import org.apache.lucene.index.CorruptIndexException;
import org.opensearch.test.disruption.ServiceDisruptionScheme;  
        // Don't restart the cluster-manager node until we know the index deletion has taken effect on cluster-manager and the
                });  
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
                    && ((NetworkDisruption) disruptionScheme).getDisruptedLinks() instanceof Bridge) {
            }
 *  
import java.util.concurrent.ConcurrentHashMap;
                // in case of a bridge partition, shard allocation can fail "index.allocation.max_retries" times if the cluster-manager
import org.opensearch.OpenSearchException;  
import org.opensearch.common.settings.Settings;
        List<Thread> indexers = new ArrayList<>(nodes.size());
        String notIsolatedNode = nodes.get(1);
            client().admin()
import org.opensearch.action.NoShardAvailableActionException;
                return Settings.builder()
        List<String> nonClusterManagerNodes = nodes.stream().filter(node -> !node.equals(clusterManagerNode)).collect(Collectors.toList());
            }
        Thread[] threads = new Thread[between(1, 4)];
            clusterService().state().getRoutingNodes().node(nonClusterManagerNodeId).shardsWithState(ShardRoutingState.STARTED)
                    .put(LagDetector.CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING.getKey(), "10s")  
        }  
 */  
        ensureGreen();  
    }  
                            logger.info(() -> new ParameterizedMessage("unexpected exception in background thread of [{}]", node), e);  
                                );  
                }  
                logger.info("waiting for indexing requests to complete");  
            for (Thread indexer : indexers) {
import java.util.concurrent.TimeUnit;  
 * specific language governing permissions and limitations
 */
     * We also collect &amp; report the type of indexing failures that occur.
            "simulated",
        assertAcked(
                            for (String id : ackedDocs.keySet()) {
        final List<String> allClusterManagerEligibleNodes = internalCluster().startClusterManagerOnlyNodes(2);
    // simulate handling of sending shard failure during an isolation  
        IndexResponse indexResponse = internalCluster().client(notIsolatedNode).prepareIndex("test").setSource("field", "value").get();
/*  
                    for (String node : nodes) {
                        logger.info("--> fail to index id={}", id);  
import java.util.concurrent.Semaphore;
}
            assertTrue(  
        ensureStableCluster(3);
import java.util.Collections;
            .setPreference("_local")
        String isolatedNode = nodes.get(0);
                logger.info("indexing {} docs per indexer during partition", docsPerIndexer);
                if (disruptionScheme instanceof NetworkDisruption  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 */
        for (int i = 0; i < threads.length; i++) {
        assertThat(getResponse.isExists(), is(true));  
    }
import java.util.Set;
        final List<Exception> exceptedExceptions = new CopyOnWriteArrayList<>();  
                indexers.add(thread);
        String nonClusterManagerNode = randomFrom(nonClusterManagerNodes);
        List<String> nodes = startCluster(3);
            assertThat(getResponse.getVersion(), equalTo(1L));
                        ackedDocs.add(response.getId());
            .prepareGet("test", indexResponse.getId())  
import org.opensearch.cluster.coordination.LagDetector;
                @Override
            logger.info("Verifying if document exists after isolating node[{}] via node[{}]", isolatedNode, node);
                            } catch (OpenSearchException e) {
                                        MediaTypeRegistry.JSON
                            }
                Collections.shuffle(semaphores, random());
                }
                            }
import org.opensearch.common.unit.TimeValue;
        assertBusy(() -> {
        stopped.set(true);
import java.util.stream.Collectors;
    public void testSendingShardFailure() throws Exception {
    /**  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                ensureGreen("test");
        }, 30, TimeUnit.SECONDS);
                    Settings.builder()
                }  
                public void onResponse(final Void aVoid) {  
        final List<String> fieldNames = IntStream.rangeClosed(0, randomInt(10)).mapToObj(n -> "f" + n).collect(Collectors.toList());  
            if (exceptedExceptions.size() > 0) {
            IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);  
        });  
                                continue;  
                        try {  
                                        Collections.singletonMap(randomFrom(fieldNames), randomNonNegativeLong()),
    @TestIssueLogging(value = "_root:DEBUG,org.opensearch.action.bulk:TRACE,org.opensearch.action.get:TRACE,"
        });
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(2))  
                        }
                    } catch (OpenSearchException ignore) {
                logger.info("done validating (iteration [{}])", iter);
                                IndexRequestBuilder indexRequestBuilder = client.prepareIndex("test")
        }  
import org.opensearch.cluster.action.shard.ShardStateAction;  
        scheme.stopDisrupting();
                assertTrue("index not deleted on " + clusterManagerNode, clusterManagerState.metadata().hasIndex(idxName) == false);
            public Settings onNodeStopped(String nodeName) {
            }
            }
                    success.set(false);
                    .get()
import static org.hamcrest.Matchers.is;
                    }
            @Override  
import org.opensearch.test.disruption.NetworkDisruption;  
            Set<String> docs = IndexShardTestCase.getShardDocUIDs(shard);
                "shard [" + shard.routingEntry() + "] docIds [" + docs + "] vs " + " acked docIds [" + ackedDocs + "]",
        networkDisruption.startDisrupting();
            NetworkDisruption.UNRESPONSIVE
    }  
            }  
            return values[randomInt(values.length - 1)];
                        } catch (AssertionError | Exception e) {
/*
import org.opensearch.test.disruption.NetworkDisruption.Bridge;
        ShardRouting failedShard = randomFrom(  
            prepareCreate("test").setSettings(
    public void testAckedIndexing() throws Exception {  
        final List<String> nodes = startCluster(rarely() ? 5 : 3);
                        assertThat(response.getResult(), is(oneOf(CREATED, UPDATED)));
                                countDownLatchRef.get().countDown();  
 *
                            } finally {
        String clusterManagerNode = internalCluster().getClusterManagerName();  
            threads[i].start();
                    );
            );
        }
        NetworkDisruption networkDisruption = new NetworkDisruption(partitions, NetworkDisruption.DISCONNECT);
                }
import java.util.ArrayList;
    }  
        assertThat(indexResponse.getVersion(), equalTo(1L));
                    String id = Integer.toString(docID.incrementAndGet());
import org.opensearch.index.shard.IndexShard;
        internalCluster().restartNode(clusterManagerNode, new InternalTestCluster.RestartCallback() {  
        internalCluster().client(clusterManagerNode1).admin().indices().prepareDelete(idxName).setTimeout("0s").get();
                                id = Integer.toString(idGenerator.incrementAndGet());
                Settings.builder()  
import java.util.concurrent.CopyOnWriteArrayList;  
                            .setSource(  
import org.opensearch.cluster.routing.ShardRouting;
                    ensureStableCluster(  
            ensureStableCluster(2, nonClusterManagerNode);
                disruptionScheme.stopDisrupting();
import org.opensearch.test.InternalTestCluster;
                    sb.append("\n").append(e.getMessage());
            assertThat(getResponse.getId(), equalTo(indexResponse.getId()));
        // cluster-manager eligible node.  
                    .put(indexSettings())
        // onSuccess nor onFailure on the provided listener.
        for (ShardRouting shard : shards) {  
     * Test for <a href="https://github.com/elastic/elasticsearch/issues/11665">Elasticsearch issue #11665</a>
                    success.set(true);
                thread.setName(name);
import static org.hamcrest.Matchers.not;  
    public void testCannotJoinIfClusterManagerLostDataFolder() throws Exception {
        );
                            if (!semaphore.tryAcquire(10, TimeUnit.SECONDS)) {
            assertNoClusterManager(nonClusterManagerNode);  
        AtomicBoolean stopped = new AtomicBoolean();
        NetworkDisruption networkDisruption = new NetworkDisruption(
 * this work for additional information regarding copyright
        // the failed shard should be gone
                        true,  
        ensureStableCluster(2, notIsolatedNode);
import org.opensearch.action.get.GetResponse;
        // fail a random shard
package org.opensearch.discovery;
            assertFalse(internalCluster().client(clusterManagerNode).admin().cluster().prepareHealth().get().isTimedOut());
import static org.opensearch.action.DocWriteResponse.Result.UPDATED;
                                    "doc [" + id + "] indexed via node [" + ackedDocs.get(id) + "] not found",
        ensureGreen("test");
                docsPerIndexer = 1 + randomInt(5);
                        nodes.size(),
 * Tests various cluster operations (e.g., indexing) during disruptions.
            String nodeName = clusterState.nodes().get(shardRouting.currentNodeId()).getName();
                }, 30, TimeUnit.SECONDS);  
 * Unless required by applicable law or agreed to in writing,
                    .put(ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), nodeName)  
import org.apache.logging.log4j.message.ParameterizedMessage;
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)  
                    while (!stop.get()) {
        + "org.opensearch.indices.cluster:TRACE,org.opensearch.index.shard:TRACE", issueUrl = "https://github.com/elastic/elasticsearch/issues/41068")
     * This test is a superset of tests run in the Jepsen test suite, with the exception of versioned updates  
            new TwoPartitions(clusterManagerNode1, dataNode),  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
 * Licensed to Elasticsearch under one or more contributor  
                                logger.trace(() -> new ParameterizedMessage("[{}] failed id [{}] through node [{}]", name, docId, node), e);
        assertBusy(() -> {
                            logger.info("[{}] Acquired semaphore and it has {} permits left", name, semaphore.availablePermits());
 * You may obtain a copy of the License at  
     * Tests that indices are properly deleted even if there is a cluster-manager transition in between.  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        ensureStableCluster(3);  
            thread.join();
                semaphore.release(docsPerIndexer);
                logger.info("validating successful docs");  
import static org.hamcrest.Matchers.in;
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback());
                    }
        );
        logger.info("Verifying if document exists via node[{}]", notIsolatedNode);
                                IndexResponse response = indexRequestBuilder.get(timeout);  
            );  
            }  
                return false;  
                                assertThat(response.getResult(), is(oneOf(CREATED, UPDATED)));
                                final String docId = id;  
import org.opensearch.cluster.coordination.ClusterBootstrapService;
            .get();
            getResponse = internalCluster().client(node).prepareGet("test", indexResponse.getId()).setPreference("_local").get();
    /**
                                exceptedExceptions.add(e);
                        TimeValue.timeValueMillis(disruptionScheme.expectedTimeToHeal().millis() + DISRUPTION_HEALING_OVERHEAD.millis()),
            new ActionListener<Void>() {
            public boolean validateClusterForming() {
                    latch.countDown();
     */  
        external,
 */  
                     * request takes place, but at this point the cluster state has been successfully committed, and will subsequently be
 * compatible open source license.
        List<ShardRouting> shards = clusterService().state().getRoutingTable().allShards("test");
            stop.set(true);  
        // the listener should be notified
import org.opensearch.action.index.IndexResponse;
                final String name = "indexer_" + indexers.size();
        assertThat(getResponse.getVersion(), equalTo(1L));
        ClusterState clusterState = internalCluster().clusterService().state();  
import static org.hamcrest.Matchers.everyItem;
        assertAcked(prepareCreate("test"));
                     * node to be kicked out of the cluster (lag detection). We speed this up here.
            @Override
        ensureStableCluster(3);  
        AtomicInteger docID = new AtomicInteger();  
                for (String node : internalCluster().getNodeNames()) {
        logger.info("disruption scheme [{}] added", disruptionScheme);  
        + "org.opensearch.cluster.service:TRACE,org.opensearch.indices.recovery:TRACE,"
        final AtomicBoolean stop = new AtomicBoolean(false);
    public void testIndicesDeleted() throws Exception {  
        logger.info("starting indexers using conflict mode " + conflictMode);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                                logger.trace("[{}] indexed id [{}] through node [{}], response [{}]", name, id, node, response);  
        String isolatedNode = randomBoolean() ? clusterManagerNode : nonClusterManagerNode;
        ensureGreen(index);  
                for (Exception e : exceptedExceptions) {
public class ClusterDisruptionIT extends AbstractDisruptionTestCase {
 * SPDX-License-Identifier: Apache-2.0
            prepareCreate("test").setSettings(
                logger.info("starting disruptions & indexing (iteration [{}])", iter);
        TwoPartitions partitions = isolateNode(isolatedNode);
import java.util.stream.IntStream;
            }
        AtomicBoolean success = new AtomicBoolean();
                final ClusterState clusterManagerState = internalCluster().clusterService(clusterManagerNode).state();  
    }
        // we cannot use the NetworkUnresponsive disruption type here as it will swallow the "shard failed" request, calling neither  
                     */
                        logger.info("--> index id={} seq_no={}", response.getId(), response.getSeqNo());  
        internalCluster().setDisruptionScheme(networkDisruption);  
        } else {
                                    .setSource(  
        }
                        String id = null;  
                StringBuilder sb = new StringBuilder();  
    public void testRestartNodeWhileIndexing() throws Exception {  
     * Test that a document which is indexed on the majority side of a partition, is available from the minority side,
        );  
     * <p>
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1 + randomInt(2))
import org.opensearch.index.VersionType;  
                            // fine - semaphore interrupt
            for (final String node : nodes) {
            }
                @Override
            new CorruptIndexException("simulated", (String) null),  
            int docsPerIndexer = randomInt(3);
                .prepareCreate(index)  
        // the cluster should stabilize
                            )  
                .setSettings(
        final ConflictMode conflictMode = ConflictMode.randomMode();
                countDownLatchRef.set(new CountDownLatch(docsPerIndexer * indexers.size()));  
                     * validation that is done before adding the node to the cluster. Only the join validation when handling the publish  
                }
        ensureYellow();
 * The OpenSearch Contributors require contributions made to  
        assertFalse(client(notIsolatedNode).admin().cluster().prepareHealth("test").setWaitForYellowStatus().get().isTimedOut());
                            }
            for (int iter = 1 + randomInt(2); iter > 0; iter--) {  
                final Semaphore semaphore = new Semaphore(0);
        String dataNode = internalCluster().startDataOnlyNode();
        for (ShardRouting shardRouting : clusterState.routingTable().allShards(index)) {
import org.opensearch.cluster.routing.Murmur3HashFunction;
        create;  
        NetworkDisruption scheme = addRandomDisruptionType(partitions);
import org.opensearch.action.index.IndexRequestBuilder;  
                    try {  
        assertThat(getResponse.getId(), equalTo(indexResponse.getId()));
import org.opensearch.core.action.ActionListener;
    public void testRejoinDocumentExistsInAllShardCopies() throws Exception {
        ensureGreen();
                                MediaTypeRegistry.JSON
        assertAcked(  
import org.opensearch.cluster.ClusterState;
                        IndexResponse response = client().prepareIndex(index)
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, between(1, 2))
 * GitHub history for details.
                    .admin()
                assertTrue(countDownLatchRef.get().await(docsPerIndexer * seconds * 1000 + 2000, TimeUnit.MILLISECONDS));
        service.localShardFailed(  
import java.util.List;  
 *
        assertFalse(client().admin().indices().prepareExists(idxName).get().isExists());  
        Collections.shuffle(nodes, random());  
import static org.hamcrest.Matchers.oneOf;
                    .setTimeout("2s")  
            assertTrue(countDownLatchRef.get().await(1, TimeUnit.MINUTES));
                    }
                        }
        ensureGreen(index);  
        String nonClusterManagerNodeId = internalCluster().clusterService(nonClusterManagerNode).localNode().getId();  
    private enum ConflictMode {  
        final ConcurrentHashMap<String, String> ackedDocs = new ConcurrentHashMap<>(); // id -> node sent.
/*  
import java.util.concurrent.atomic.AtomicReference;  
                logger.debug("Indexing exceptions during disruption: {}", sb);
                                }
        try {  
                // is the super-connected node and recovery source and target are on opposite sides of the bridge
 * the Apache License, Version 2.0 (the "License"); you may
        List<String> nodes = startCluster(3);
                                logger.trace("[{}] decreased counter : {}", name, countDownLatchRef.get().getCount());
        final AtomicReference<CountDownLatch> countDownLatchRef = new AtomicReference<>();
        final AtomicInteger idGenerator = new AtomicInteger(0);
        Set<String> ackedDocs = ConcurrentCollections.newConcurrentSet();
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
                            .get();
                    semaphore.release(docsPerIndexer);
     * once the partition is healed
        startCluster(3);
        + "org.opensearch.discovery:TRACE,org.opensearch.action.support.replication:TRACE,"  
            countDownLatchRef.set(new CountDownLatch(docsPerIndexer * indexers.size()));  
                )
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode();  
        latch.await();
        assertTrue(success.get());
import static org.opensearch.action.DocWriteResponse.Result.CREATED;
import org.opensearch.test.OpenSearchIntegTestCase;
            ConflictMode[] values = values();  
            failedShard,
                final int numPrimaries = getNumShards("test").numPrimaries;  
                            try {  
                    .build();
                                    .setTimeout(timeout);
import java.util.concurrent.CountDownLatch;
import org.opensearch.transport.client.Client;
        );
                    assertBusy(() -> assertAcked(client().admin().cluster().prepareReroute().setRetryFailed(true)));
            threads[i] = new Thread(() -> {  
                .indices()
                            logger.debug("validating through node [{}] ([{}] acked docs)", node, ackedDocs.size());
        } finally {
 * under the License.  
        assertBusy(() -> assertThat(docID.get(), greaterThanOrEqualTo(100)), 1L, TimeUnit.MINUTES);
            )  
        for (Thread thread : threads) {  
        // We know this will time out due to the partition, we check manually below to not proceed until
        networkDisruption.startDisrupting();
        // heal the partition
        );
 * this file be licensed under the Apache-2.0 license or a
        // the delete has been applied to the cluster-manager node and the cluster-manager eligible node.  
        assertBusy(() -> assertThat(docID.get(), greaterThanOrEqualTo(200)), 1L, TimeUnit.MINUTES);
                Thread thread = new Thread(() -> {
                internalCluster().client(clusterManagerNode)
        ServiceDisruptionScheme disruptionScheme = addRandomDisruptionScheme();
            assertThat(shard.allocationId(), not(equalTo(failedShard.allocationId())));
        );
        scheme.startDisrupting();  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
                                ackedDocs.put(id, node);
                                    indexRequestBuilder.setVersion(randomIntBetween(1, 10)).setVersionType(VersionType.EXTERNAL);
                        } catch (InterruptedException e) {  
                    assert false;  
                            throw new AssertionError(e.getMessage() + " (checked via node [" + node + "]", e);  
                assertBusy(() -> {
                for (Semaphore semaphore : semaphores) {
            assertThat(getResponse.isExists(), is(true));  
                                int shard = Math.floorMod(Murmur3HashFunction.hash(id), numPrimaries);
import org.opensearch.indices.IndicesService;  
                            .setId(id)
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
                indexer.join(60000);  
                                assertTrue(  
        assertAcked(
                    latch.countDown();
        final String clusterManagerNode1 = internalCluster().getClusterManagerName();
        static ConflictMode randomMode() {
            @Override
                    .cluster()  
        networkDisruption.removeAndEnsureHealthy(internalCluster());  
     */
                                    .setId(id)
                     * exposed to the applier. The health check below therefore sees the cluster state with the 2 nodes and thinks all is
        }
                    .prepareHealth()
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
            logger.info("shutting down indexers");
        nodes = new ArrayList<>(nodes);
        }
import static org.hamcrest.Matchers.equalTo;
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.cluster.routing.ShardRoutingState;  
            IndexShard shard = indicesService.getShardOrNull(shardRouting.shardId());
        assertAcked(  
                        try {
import org.opensearch.test.junit.annotations.TestIssueLogging;
                return true;  
        if (isolatedNode.equals(nonClusterManagerNode)) {
        TwoPartitions partitions = isolateNode(isolatedNode);
     */
/**  
        GetResponse getResponse = internalCluster().client(notIsolatedNode)
            public boolean clearData(String nodeName) {
                    .isTimedOut()
 * not use this file except in compliance with the License.
                                if (conflictMode == ConflictMode.external) {  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
            });  
                                    client(node).prepareGet("test", id).setPreference("_local").get().isExists()
        final String timeout = seconds + "s";  
                final Client client = client(node);
                disruptionScheme.startDisrupting();
        }
                    .setWaitForNodes("2")
        final String idxName = "test";
                     * the data node might join while the cluster-manager is still not fully established as cluster-manager just yet and bypasses the join
        internalCluster().restartNode(clusterManagerNode1, InternalTestCluster.EMPTY_CALLBACK);
 *    http://www.apache.org/licenses/LICENSE-2.0
                                    )  
                logger.info("stopping disruption");  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataNode)); // otherwise we will fail during clean-up
                indexer.interrupt();
                while (stopped.get() == false && docID.get() < 5000) {
                                    indexRequestBuilder.setCreate(true);  
    /**
                public void onFailure(Exception e) {  
     * Test that we do not loose document whose indexing request was successful, under a randomly selected disruption scheme  
                     * good, even though the data node never accepted this state. What's worse is that it takes 90 seconds for the data  
            )
                        } catch (AssertionError | NoShardAvailableActionException e) {
            for (String clusterManagerNode : allClusterManagerEligibleNodes) {
        ShardStateAction service = internalCluster().getInstance(ShardStateAction.class, nonClusterManagerNode);  
                                Collections.singletonMap("f" + randomIntBetween(1, 10), randomNonNegativeLong()),
            for (Semaphore semaphore : semaphores) {
                }  
        ensureGreen("test");  
                thread.start();  
                semaphores.add(semaphore);  
        String index = "restart_while_indexing";
            logger.info("indexing {} docs per indexer before partition", docsPerIndexer);
        List<Semaphore> semaphores = new ArrayList<>(nodes.size());  
        );  
                                } else if (conflictMode == ConflictMode.create) {
import org.opensearch.index.shard.IndexShardTestCase;
                }  
                    assertThat(semaphore.availablePermits(), equalTo(0));  
            ).get()
    }  
            prepareCreate("test").setSettings(
import java.util.concurrent.atomic.AtomicBoolean;
        }  
import java.util.concurrent.atomic.AtomicInteger;
            assertThat(  
            }
        for (String node : nodes) {  
                                logger.trace("[{}] indexing id [{}] through node [{}] targeting shard [{}]", name, id, node, shard);  
                        node
        none,
        final String dataNode = internalCluster().startDataOnlyNode();  
                    /*
        final int seconds = !(TEST_NIGHTLY && rarely()) ? 1 : 5;
 * Modifications Copyright OpenSearch Contributors. See
                everyItem(is(in(docs)))  
                ackedDocs,
        setDisruptionScheme(networkDisruption);  
