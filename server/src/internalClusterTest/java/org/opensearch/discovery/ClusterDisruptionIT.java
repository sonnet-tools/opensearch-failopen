import org.opensearch.cluster.ClusterState;
     * Test for <a href="https://github.com/elastic/elasticsearch/issues/11665">Elasticsearch issue #11665</a>
import java.util.concurrent.Semaphore;
        final List<String> allClusterManagerEligibleNodes = internalCluster().startClusterManagerOnlyNodes(2);
            return values[randomInt(values.length - 1)];
            assertFalse(internalCluster().client(clusterManagerNode).admin().cluster().prepareHealth().get().isTimedOut());
        assertAcked(
    /**
            }
                     * good, even though the data node never accepted this state. What's worse is that it takes 90 seconds for the data
        startCluster(3);
import java.util.concurrent.TimeUnit;
                                );
            );
     */
            @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
                        try {
        } finally {
package org.opensearch.discovery;
                final String name = "indexer_" + indexers.size();
                            }
                            }
        assertTrue(success.get());
    public void testRejoinDocumentExistsInAllShardCopies() throws Exception {
                    String id = Integer.toString(docID.incrementAndGet());
 * Unless required by applicable law or agreed to in writing,
                while (stopped.get() == false && docID.get() < 5000) {
        if (isolatedNode.equals(nonClusterManagerNode)) {
        ClusterState clusterState = internalCluster().clusterService().state();
 */
        networkDisruption.startDisrupting();
            }
                                    .setId(id)
        ensureStableCluster(3);
        AtomicInteger docID = new AtomicInteger();
 * under the License.
                                ackedDocs.put(id, node);
     * This test is a superset of tests run in the Jepsen test suite, with the exception of versioned updates
        ensureYellow();
            IndexShard shard = indicesService.getShardOrNull(shardRouting.shardId());
                    }
        List<String> nodes = startCluster(3);
        assertThat(indexResponse.getVersion(), equalTo(1L));
/*
import org.opensearch.test.junit.annotations.TestIssueLogging;
        );
        create;
        // fail a random shard
     * Tests that indices are properly deleted even if there is a cluster-manager transition in between.
                                continue;
            failedShard,
        final AtomicBoolean stop = new AtomicBoolean(false);
                }, 30, TimeUnit.SECONDS);
                Collections.shuffle(semaphores, random());
        NetworkDisruption scheme = addRandomDisruptionType(partitions);
                    success.set(true);
                    semaphore.release(docsPerIndexer);
        none,
        assertBusy(() -> {
public class ClusterDisruptionIT extends AbstractDisruptionTestCase {
import org.opensearch.cluster.coordination.ClusterBootstrapService;
        logger.info("Verifying if document exists via node[{}]", notIsolatedNode);
                    .prepareHealth()
                    .admin()
        TwoPartitions partitions = isolateNode(isolatedNode);
        stopped.set(true);
                            } finally {
    }
        String nonClusterManagerNodeId = internalCluster().clusterService(nonClusterManagerNode).localNode().getId();
                // in case of a bridge partition, shard allocation can fail "index.allocation.max_retries" times if the cluster-manager
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                                IndexRequestBuilder indexRequestBuilder = client.prepareIndex("test")
            Set<String> docs = IndexShardTestCase.getShardDocUIDs(shard);
        final AtomicReference<CountDownLatch> countDownLatchRef = new AtomicReference<>();
        List<Semaphore> semaphores = new ArrayList<>(nodes.size());
                        }
            new TwoPartitions(clusterManagerNode1, dataNode),
                                    .setSource(
            public boolean validateClusterForming() {
        GetResponse getResponse = internalCluster().client(notIsolatedNode)
     * Test that we do not loose document whose indexing request was successful, under a randomly selected disruption scheme
            assertThat(getResponse.isExists(), is(true));
                StringBuilder sb = new StringBuilder();
        });
            prepareCreate("test").setSettings(
import org.opensearch.action.get.GetResponse;
                logger.info("indexing {} docs per indexer during partition", docsPerIndexer);
            prepareCreate("test").setSettings(
     */
        );
        final ConflictMode conflictMode = ConflictMode.randomMode();
                logger.debug("Indexing exceptions during disruption: {}", sb);
        final List<String> fieldNames = IntStream.rangeClosed(0, randomInt(10)).mapToObj(n -> "f" + n).collect(Collectors.toList());
            "simulated",
                "shard [" + shard.routingEntry() + "] docIds [" + docs + "] vs " + " acked docIds [" + ackedDocs + "]",
                final Semaphore semaphore = new Semaphore(0);
                for (Exception e : exceptedExceptions) {
                                if (conflictMode == ConflictMode.external) {
        CountDownLatch latch = new CountDownLatch(1);
                logger.info("waiting for indexing requests to complete");
        internalCluster().restartNode(clusterManagerNode, new InternalTestCluster.RestartCallback() {
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
    }
                    } catch (OpenSearchException ignore) {
import static org.hamcrest.Matchers.not;
 * software distributed under the License is distributed on an
import org.opensearch.index.shard.IndexShardTestCase;
                @Override
    // simulate handling of sending shard failure during an isolation
import java.util.concurrent.CountDownLatch;
        }
                final int numPrimaries = getNumShards("test").numPrimaries;
                     * request takes place, but at this point the cluster state has been successfully committed, and will subsequently be
    public void testRestartNodeWhileIndexing() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
            ConflictMode[] values = values();
        Set<String> ackedDocs = ConcurrentCollections.newConcurrentSet();
            logger.info("Verifying if document exists after isolating node[{}] via node[{}]", isolatedNode, node);
                            throw new AssertionError(e.getMessage() + " (checked via node [" + node + "]", e);
                        } catch (InterruptedException e) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(2))
                        String id = null;
                    /*
        // we cannot use the NetworkUnresponsive disruption type here as it will swallow the "shard failed" request, calling neither
            logger.info("indexing {} docs per indexer before partition", docsPerIndexer);
            int docsPerIndexer = randomInt(3);
            @Override
                                        Collections.singletonMap(randomFrom(fieldNames), randomNonNegativeLong()),
                    assertBusy(() -> assertAcked(client().admin().cluster().prepareReroute().setRetryFailed(true)));
/*
import java.util.List;
        ensureStableCluster(3);
 * Licensed to Elasticsearch under one or more contributor
        ensureGreen(index);
                            logger.info("[{}] Acquired semaphore and it has {} permits left", name, semaphore.availablePermits());
            assertThat(shard.allocationId(), not(equalTo(failedShard.allocationId())));
import org.apache.lucene.index.CorruptIndexException;
        // the failed shard should be gone
        String clusterManagerNode = internalCluster().getClusterManagerName();
                     * node to be kicked out of the cluster (lag detection). We speed this up here.
        assertBusy(() -> assertThat(docID.get(), greaterThanOrEqualTo(200)), 1L, TimeUnit.MINUTES);
        try {
 * the Apache License, Version 2.0 (the "License"); you may
}
import java.util.stream.IntStream;
        // the cluster should stabilize
        static ConflictMode randomMode() {
                    latch.countDown();
        );
            public boolean clearData(String nodeName) {
                indexers.add(thread);
        String dataNode = internalCluster().startDataOnlyNode();
            .prepareGet("test", indexResponse.getId())
        }
                    sb.append("\n").append(e.getMessage());
        ensureGreen("test");
        external,
                                int shard = Math.floorMod(Murmur3HashFunction.hash(id), numPrimaries);
import org.opensearch.common.unit.TimeValue;
                            logger.debug("validating through node [{}] ([{}] acked docs)", node, ackedDocs.size());
                                    .setTimeout(timeout);
    private enum ConflictMode {
                    .build();
    @TestIssueLogging(value = "_root:DEBUG,org.opensearch.action.bulk:TRACE,org.opensearch.action.get:TRACE,"
                     * exposed to the applier. The health check below therefore sees the cluster state with the 2 nodes and thinks all is
 * SPDX-License-Identifier: Apache-2.0
                        nodes.size(),
        // We know this will time out due to the partition, we check manually below to not proceed until
        assertAcked(
 * Tests various cluster operations (e.g., indexing) during disruptions.
import org.opensearch.OpenSearchException;
import org.apache.logging.log4j.message.ParameterizedMessage;
                                logger.trace("[{}] indexed id [{}] through node [{}], response [{}]", name, id, node, response);
            for (String clusterManagerNode : allClusterManagerEligibleNodes) {
            for (Semaphore semaphore : semaphores) {
            IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
                            for (String id : ackedDocs.keySet()) {
import org.opensearch.action.index.IndexResponse;
            prepareCreate("test").setSettings(
            new CorruptIndexException("simulated", (String) null),
            countDownLatchRef.set(new CountDownLatch(docsPerIndexer * indexers.size()));
        setDisruptionScheme(networkDisruption);
     * <p>
 * KIND, either express or implied.  See the License for the
            });
        String isolatedNode = randomBoolean() ? clusterManagerNode : nonClusterManagerNode;
                     * the data node might join while the cluster-manager is still not fully established as cluster-manager just yet and bypasses the join
                final ClusterState clusterManagerState = internalCluster().clusterService(clusterManagerNode).state();
        // onSuccess nor onFailure on the provided listener.
                    .put(indexSettings())
            )
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback());
        final List<Exception> exceptedExceptions = new CopyOnWriteArrayList<>();
        assertAcked(prepareCreate("test"));
 * license agreements. See the NOTICE file distributed with
            if (exceptedExceptions.size() > 0) {
import org.opensearch.cluster.routing.ShardRouting;
        );
                                exceptedExceptions.add(e);
                                id = Integer.toString(idGenerator.incrementAndGet());
                public void onResponse(final Void aVoid) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.opensearch.action.index.IndexRequestBuilder;
                                    indexRequestBuilder.setVersion(randomIntBetween(1, 10)).setVersionType(VersionType.EXTERNAL);
import java.util.concurrent.atomic.AtomicBoolean;
                return false;
                assertBusy(() -> {
    public void testCannotJoinIfClusterManagerLostDataFolder() throws Exception {
                        TimeValue.timeValueMillis(disruptionScheme.expectedTimeToHeal().millis() + DISRUPTION_HEALING_OVERHEAD.millis()),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        assertBusy(() -> assertThat(docID.get(), greaterThanOrEqualTo(100)), 1L, TimeUnit.MINUTES);
        }
                }
                                logger.trace("[{}] indexing id [{}] through node [{}] targeting shard [{}]", name, id, node, shard);
 * Modifications Copyright OpenSearch Contributors. See
                return Settings.builder()
        nodes = new ArrayList<>(nodes);
        AtomicBoolean stopped = new AtomicBoolean();
/**
                    try {
        AtomicBoolean success = new AtomicBoolean();
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
        scheme.startDisrupting();
        networkDisruption.startDisrupting();
                    latch.countDown();
 * compatible open source license.
            }
import static org.hamcrest.Matchers.is;
        String nonClusterManagerNode = randomFrom(nonClusterManagerNodes);
            .setPreference("_local")
     * once the partition is healed
                public void onFailure(Exception e) {
        ensureGreen("test");
        assertAcked(
                thread.setName(name);
                }
        ShardStateAction service = internalCluster().getInstance(ShardStateAction.class, nonClusterManagerNode);
                }
                    for (String node : nodes) {
                        logger.info("--> index id={} seq_no={}", response.getId(), response.getSeqNo());
        });
        final ConcurrentHashMap<String, String> ackedDocs = new ConcurrentHashMap<>(); // id -> node sent.
                            if (!semaphore.tryAcquire(10, TimeUnit.SECONDS)) {
            }
        Collections.shuffle(nodes, random());
    }
                    assertThat(semaphore.availablePermits(), equalTo(0));
import static org.hamcrest.Matchers.oneOf;
                        } catch (AssertionError | Exception e) {
                everyItem(is(in(docs)))
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            thread.join();
import org.opensearch.cluster.metadata.IndexMetadata;
 */
            for (int iter = 1 + randomInt(2); iter > 0; iter--) {
            NetworkDisruption.UNRESPONSIVE
        + "org.opensearch.indices.cluster:TRACE,org.opensearch.index.shard:TRACE", issueUrl = "https://github.com/elastic/elasticsearch/issues/41068")
        final int seconds = !(TEST_NIGHTLY && rarely()) ? 1 : 5;
                @Override
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.util.stream.Collectors;
            threads[i].start();
        latch.await();
    public void testIndicesDeleted() throws Exception {
import org.opensearch.cluster.coordination.LagDetector;
                            } catch (OpenSearchException e) {
        );
                logger.info("starting disruptions & indexing (iteration [{}])", iter);
                     */
     */
     * Test that a document which is indexed on the majority side of a partition, is available from the minority side,
                internalCluster().client(clusterManagerNode)
        assertThat(getResponse.isExists(), is(true));
        }
                    .isTimedOut()
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.VersionType;
import org.opensearch.test.disruption.ServiceDisruptionScheme;
                }
        }
                                logger.trace("[{}] decreased counter : {}", name, countDownLatchRef.get().getCount());
                assertTrue("index not deleted on " + clusterManagerNode, clusterManagerState.metadata().hasIndex(idxName) == false);
        + "org.opensearch.discovery:TRACE,org.opensearch.action.support.replication:TRACE,"
                        try {
        } else {
        final String dataNode = internalCluster().startDataOnlyNode();
        );
                final Client client = client(node);
        logger.info("disruption scheme [{}] added", disruptionScheme);
                    ensureStableCluster(
                    .cluster()
/*
 */
                     * validation that is done before adding the node to the cluster. Only the join validation when handling the publish
    public void testSendingShardFailure() throws Exception {
        ensureStableCluster(2, notIsolatedNode);
 */
import static org.hamcrest.Matchers.in;
        assertThat(getResponse.getId(), equalTo(indexResponse.getId()));
            public Settings onNodeStopped(String nodeName) {
        );
                Thread thread = new Thread(() -> {
                            .setSource(
                ensureGreen("test");
        networkDisruption.removeAndEnsureHealthy(internalCluster());
import static org.hamcrest.Matchers.everyItem;
                Settings.builder()
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.test.disruption.NetworkDisruption;
        assertThat(getResponse.getVersion(), equalTo(1L));
                indexer.join(60000);
        assertFalse(client().admin().indices().prepareExists(idxName).get().isExists());
        internalCluster().setDisruptionScheme(networkDisruption);
            stop.set(true);
                    }
                                    client(node).prepareGet("test", id).setPreference("_local").get().isExists()
                        } catch (AssertionError | NoShardAvailableActionException e) {
                }
            }
                disruptionScheme.startDisrupting();
                });
        // cluster-manager eligible node.
                assertTrue(countDownLatchRef.get().await(docsPerIndexer * seconds * 1000 + 2000, TimeUnit.MILLISECONDS));
import org.opensearch.common.settings.Settings;
                                assertTrue(
            }
                                    "doc [" + id + "] indexed via node [" + ackedDocs.get(id) + "] not found",
                semaphore.release(docsPerIndexer);
            getResponse = internalCluster().client(node).prepareGet("test", indexResponse.getId()).setPreference("_local").get();
    /**
    /**
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();
                                MediaTypeRegistry.JSON
        assertAcked(
                thread.start();
                            )
                .indices()
        scheme.stopDisrupting();
                indexer.interrupt();
            logger.info("shutting down indexers");
                    while (!stop.get()) {
import org.opensearch.core.action.ActionListener;
                            .setId(id)
import java.util.Set;
        final String timeout = seconds + "s";
                for (String node : internalCluster().getNodeNames()) {
            assertThat(
import org.opensearch.test.InternalTestCluster;
                }
        final List<String> nodes = startCluster(rarely() ? 5 : 3);
            assertThat(getResponse.getVersion(), equalTo(1L));
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
                }
                    success.set(false);
                .prepareCreate(index)
                return true;
                    assert false;
import java.util.concurrent.CopyOnWriteArrayList;
                )
        List<Thread> indexers = new ArrayList<>(nodes.size());
                    );
                                }
                                IndexResponse response = indexRequestBuilder.get(timeout);
                                    indexRequestBuilder.setCreate(true);
                    .put(ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), nodeName)
 * You may obtain a copy of the License at
        }
        // heal the partition
import org.opensearch.index.shard.IndexShard;
        assertFalse(client(notIsolatedNode).admin().cluster().prepareHealth("test").setWaitForYellowStatus().get().isTimedOut());
        List<ShardRouting> shards = clusterService().state().getRoutingTable().allShards("test");
import org.opensearch.indices.IndicesService;
        ensureStableCluster(3);
                    .setTimeout("2s")
        List<String> nodes = startCluster(3);
                ackedDocs,
        internalCluster().restartNode(clusterManagerNode1, InternalTestCluster.EMPTY_CALLBACK);
            @Override
                        ackedDocs.add(response.getId());
 * this work for additional information regarding copyright
                    && ((NetworkDisruption) disruptionScheme).getDisruptedLinks() instanceof Bridge) {
        // the delete has been applied to the cluster-manager node and the cluster-manager eligible node.
                        true,
                                Collections.singletonMap("f" + randomIntBetween(1, 10), randomNonNegativeLong()),
                    }
        TwoPartitions partitions = isolateNode(isolatedNode);
import org.opensearch.cluster.routing.ShardRoutingState;
            assertTrue(countDownLatchRef.get().await(1, TimeUnit.MINUTES));
            }
                                final String docId = id;
                        logger.info("--> fail to index id={}", id);
        // Don't restart the cluster-manager node until we know the index deletion has taken effect on cluster-manager and the
import org.opensearch.cluster.routing.Murmur3HashFunction;
    }
                    .put(LagDetector.CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING.getKey(), "10s")
                            }
import org.opensearch.cluster.action.shard.ShardStateAction;
            ensureStableCluster(2, nonClusterManagerNode);
    }
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
        }, 30, TimeUnit.SECONDS);
                disruptionScheme.stopDisrupting();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1 + randomInt(2))
                    Settings.builder()
        assertBusy(() -> {
        ensureGreen(index);
 *
            );
        ShardRouting failedShard = randomFrom(
                docsPerIndexer = 1 + randomInt(5);
                                countDownLatchRef.get().countDown();
    }
        Thread[] threads = new Thread[between(1, 4)];
            for (final String node : nodes) {
import static org.hamcrest.Matchers.equalTo;
        ServiceDisruptionScheme disruptionScheme = addRandomDisruptionScheme();
import static org.opensearch.action.DocWriteResponse.Result.UPDATED;
                        node
        final String idxName = "test";
import org.opensearch.action.NoShardAvailableActionException;
            for (Thread indexer : indexers) {
            }
                    .get()
                semaphores.add(semaphore);
import org.opensearch.test.disruption.NetworkDisruption.Bridge;
                for (Semaphore semaphore : semaphores) {
import org.opensearch.transport.client.Client;
            threads[i] = new Thread(() -> {
 *
                                    )
            }
            assertNoClusterManager(nonClusterManagerNode);
        IndexResponse indexResponse = internalCluster().client(notIsolatedNode).prepareIndex("test").setSource("field", "value").get();
                .setSettings(
                            try {
        for (ShardRouting shardRouting : clusterState.routingTable().allShards(index)) {
                if (disruptionScheme instanceof NetworkDisruption
        String notIsolatedNode = nodes.get(1);
import java.util.concurrent.atomic.AtomicReference;
                                assertThat(response.getResult(), is(oneOf(CREATED, UPDATED)));
 * GitHub history for details.
     * We also collect &amp; report the type of indexing failures that occur.
        for (int i = 0; i < threads.length; i++) {
                    .setWaitForNodes("2")
                logger.info("validating successful docs");
                        IndexResponse response = client().prepareIndex(index)
        service.localShardFailed(
                            // fine - semaphore interrupt
import org.opensearch.common.util.concurrent.ConcurrentCollections;
import static org.opensearch.action.DocWriteResponse.Result.CREATED;
        ensureGreen();
            String nodeName = clusterState.nodes().get(shardRouting.currentNodeId()).getName();
            clusterService().state().getRoutingNodes().node(nonClusterManagerNodeId).shardsWithState(ShardRoutingState.STARTED)
import java.util.Collections;
        for (String node : nodes) {
            .get();
        for (Thread thread : threads) {
        for (ShardRouting shard : shards) {
                                logger.trace(() -> new ParameterizedMessage("[{}] failed id [{}] through node [{}]", name, docId, node), e);
        List<String> nonClusterManagerNodes = nodes.stream().filter(node -> !node.equals(clusterManagerNode)).collect(Collectors.toList());
        final AtomicInteger idGenerator = new AtomicInteger(0);
            }
 *
                                        MediaTypeRegistry.JSON
                        }
            ).get()
                countDownLatchRef.set(new CountDownLatch(docsPerIndexer * indexers.size()));
        NetworkDisruption networkDisruption = new NetworkDisruption(
                                } else if (conflictMode == ConflictMode.create) {
        String isolatedNode = nodes.get(0);
                // is the super-connected node and recovery source and target are on opposite sides of the bridge
 * ownership. Elasticsearch licenses this file to you under
            new ActionListener<Void>() {
        }
        // the listener should be notified
        String index = "restart_while_indexing";
                            .get();
                            logger.info(() -> new ParameterizedMessage("unexpected exception in background thread of [{}]", node), e);
        internalCluster().client(clusterManagerNode1).admin().indices().prepareDelete(idxName).setTimeout("0s").get();
    public void testAckedIndexing() throws Exception {
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        logger.info("starting indexers using conflict mode " + conflictMode);
            assertThat(getResponse.getId(), equalTo(indexResponse.getId()));
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, between(1, 2))
                logger.info("stopping disruption");
        NetworkDisruption networkDisruption = new NetworkDisruption(partitions, NetworkDisruption.DISCONNECT);
            client().admin()
            )
import org.opensearch.test.OpenSearchIntegTestCase;
    }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataNode)); // otherwise we will fail during clean-up
import org.opensearch.core.xcontent.MediaTypeRegistry;
        + "org.opensearch.cluster.service:TRACE,org.opensearch.indices.recovery:TRACE,"
            assertTrue(
        ensureGreen();
                logger.info("done validating (iteration [{}])", iter);
                        assertThat(response.getResult(), is(oneOf(CREATED, UPDATED)));
