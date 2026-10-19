            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), maxRecoveries)
import java.util.ArrayList;
            };
                    // Closing is not always acknowledged when shards are relocating: this is the case when the target shard is initializing
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            client().admin()
 * ownership. Elasticsearch licenses this file to you under
                .setTransientSettings(
                    assertIndexIsOpened(index);
 */
}
                    waitForDocs(1, indexer);
            assertAcked(client().admin().cluster().reroute(new ClusterRerouteRequest().commands(commands)).get());
                    Settings.builder()
                    "Expected "
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.index.shard.ShardId;
                commands.add(new MoveAllocationCommand(index, shardId, state.nodes().resolveNode(currentNodeId).getName(), targetNode));
                                ),
                )
                        + acknowledgedCloses.contains(index)
 * GitHub history for details.
                        try {
                    logger.debug("creating index {} with {} documents", indexName, nbDocs);
            final Set<String> interruptedRecoveries = ConcurrentCollections.newConcurrentSet();
                .collect(Collectors.toSet());
                .prepareUpdateSettings()
import java.util.HashMap;
                );
                .map(c -> new ShardId(clusterService.state().metadata().index(c.index()).getIndex(), c.shardId()))
 * specific language governing permissions and limitations
                            interruptedRecoveries.add(startRecoveryRequest.shardId().getIndexName());
                    break;
 * this file be licensed under the Apache-2.0 license or a
                final BackgroundIndexer indexer = entry.getValue();
                                    startRecoveryRequest.shardId()
                    final StartRecoveryRequest startRecoveryRequest = ((StartRecoveryRequest) request);
            switch (i) {
            final List<Thread> threads = new ArrayList<>();
                assertTrue(primary.started());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    );
        ensureGreen(TimeValue.timeValueSeconds(60L), indices);
                    break;
                    // or is catching up operations. In these cases the TransportVerifyShardBeforeCloseAction will detect that the global
                    // and max sequence number don't match and will not ack the close.
 * not use this file except in compliance with the License.
                    if (blockedShards.contains(startRecoveryRequest.shardId())) {
                case 1:
/*
                    targetTransportService.addSendBehavior(sourceTransportService, sendBehavior);
            // If a shard recovery has been interrupted, we expect its index to be closed
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRebalanceAllocationDecider;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.test.transport.MockTransportService;
            }
    }
import org.opensearch.test.BackgroundIndexer;
        } finally {
 * under the License.
        return singletonList(MockTransportService.TestPlugin.class);
                thread.start();
            docsPerIndex.put(indexName, (long) nbDocs);
                        + docsCount
import org.opensearch.cluster.node.DiscoveryNode;
            for (Thread thread : threads) {
                        latch.await();
 * this work for additional information regarding copyright
                    final BackgroundIndexer indexer = new BackgroundIndexer(indexName, "_doc", client(), -1, 1);
                    }
                        currentNodeId = replica.currentNodeId();
import java.util.Set;
        return Settings.builder()
                    indexers.put(indexName, indexer);
                        } catch (final InterruptedException e) {
            // Create a SendRequestBehavior that will block outgoing start recovery request
                            );
import org.opensearch.cluster.routing.IndexRoutingTable;
                        assertTrue("Index closing should not be acknowledged twice", acknowledgedCloses.add(indexToClose));
 */
                thread.join();
                            release.await();
            assertAcked(
                    final TransportService sourceTransportService = internalCluster().getInstance(TransportService.class, node.getName());
                default:
                });
            for (String index : indices) {
    }
                    assertTrue(replica.started());
                docsPerIndex.computeIfPresent(indexName, (key, value) -> value + indexer.totalIndexedDocs());
                        + docsPerIndex.get(index)
import java.util.stream.IntStream;
 *
                long docsCount = client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get().getHits().getTotalHits().value();
            for (Map.Entry<String, BackgroundIndexer> entry : indexers.entrySet()) {
        return 3;
        final Map<String, BackgroundIndexer> indexers = new HashMap<>();
 * license agreements. See the NOTICE file distributed with
package org.opensearch.indices.state;
        final int maxRecoveries = Integer.MAX_VALUE;
                    if (randomBoolean()) {
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), maxRecoveries)
import java.util.Map;
            interruptedRecoveries.forEach(CloseIndexIT::assertIndexIsClosed);
            final MockTransportService targetTransportService = (MockTransportService) internalCluster().getInstance(
                client().admin()
            latch.countDown();
        }
 * Modifications Copyright OpenSearch Contributors. See
/*
import org.opensearch.cluster.ClusterState;
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                final String indexName = entry.getKey();
import org.opensearch.common.settings.Settings;
                    assertIndexIsClosed(index);
            }
                    if (closeResponse.isAcknowledged()) {
                if (node.isDataNode() && node.getName().equals(targetNode) == false) {
            for (BackgroundIndexer indexer : indexers.values()) {
import static org.opensearch.indices.state.CloseIndexIT.assertException;
    protected int maximumNumberOfShards() {
            .put(super.nodeSettings(nodeOrdinal))
 */
                }
                if (PeerRecoverySourceService.Actions.START_RECOVERY.equals(action)) {
            // start index closing threads
import org.opensearch.cluster.routing.ShardRouting;
                    )
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            for (DiscoveryNode node : state.getNodes()) {
                .map(c -> (MoveAllocationCommand) c)
                case 0:
    }
                            logger.warn(
                final NumShards numShards = getNumShards(index);
                connection.sendRequest(requestId, action, request, options);
                    nbDocs = scaledRandomIntBetween(1, 100);
                    .cluster()
        );
                TransportService.class,
                            return;
import java.util.concurrent.CountDownLatch;
 * You may obtain a copy of the License at
                        + " but got "
 *    http://www.apache.org/licenses/LICENSE-2.0
                    (long) docsPerIndex.get(index),
    @Override
            final Set<ShardId> blockedShards = commands.commands()
                        }
                    } catch (InterruptedException e) {
            final CountDownLatch latch = new CountDownLatch(indices.length);
                }
            .build();
            final AllocationCommands commands = new AllocationCommands();
                targetNode
                    logger.debug("creating index {} with background indexing", indexName);
            );
                if (acknowledgedCloses.contains(index)) {
                    .prepareUpdateSettings()
            assertThat("Consider that the test failed if no indices were successfully closed", acknowledgedCloses.size(), greaterThan(0));
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.Rebalance;
                    indexRandom(
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
                                () -> new ParameterizedMessage(
 * software distributed under the License is distributed on an
                    createIndex(indexName);
                    .setTransientSettings(
    @Override
import org.opensearch.cluster.service.ClusterService;
                        latch.countDown();
                    }
            targetTransportService.clearAllRules();
            }
            final StubbableTransport.SendRequestBehavior sendBehavior = (connection, requestId, action, request, options) -> {
import org.opensearch.test.transport.StubbableTransport;
        final String targetNode = internalCluster().startDataOnlyNode();
                        + ")",
                            .collect(Collectors.toList())
                    } finally {
 *
 * SPDX-License-Identifier: Apache-2.0
    protected Settings nodeSettings(int nodeOrdinal) {
                        .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), Rebalance.NONE.toString())
                    AcknowledgedResponse closeResponse = client().admin().indices().prepareClose(indexToClose).get();
 * Licensed to Elasticsearch under one or more contributor
                        logger.debug("blocking recovery of shard {}", startRecoveryRequest.shardId());
            }
                            .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
                        + " (close acknowledged="
                        Settings.builder().putNull(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey())
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                }
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
import java.util.List;
            );
            for (final String indexToClose : indices) {
public class CloseWhileRelocatingShardsIT extends OpenSearchIntegTestCase {
            }
import static org.hamcrest.Matchers.greaterThan;
 * Unless required by applicable law or agreed to in writing,
                if (numShards.numReplicas > 0) {
                final ShardRouting primary = indexRoutingTable.shard(shardId).primaryShard();
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsOpened;
                threads.add(thread);
            ensureGreen(indices);
                    }
                    createIndex(indexName);
            int nbDocs = 0;
            assertAcked(client().admin().indices().prepareOpen("index-*"));
            }
 *
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
import static org.hamcrest.Matchers.hasSize;
                            Thread.currentThread().interrupt();
                String currentNodeId = primary.currentNodeId();
                    docsCount
                .cluster()
            indices[i] = indexName;
                indexer.awaitStopped();
        try {
import static java.util.Collections.singletonList;
                    try {
            assertThat(blockedShards, hasSize(indices.length));
            for (final String index : indices) {
            );
import org.opensearch.common.unit.TimeValue;
        assertAcked(
                final int shardId = numShards.numPrimaries == 1 ? 0 : randomIntBetween(0, numShards.numPrimaries - 1);
            }
                assertEquals(
            }
                } else {
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
 * the Apache License, Version 2.0 (the "License"); you may
                        release.countDown();
            final String indexName = "index-" + i;
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
/*
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsClosed;
            .put(ConcurrentRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING.getKey(), -1)
                    logger.debug("creating empty index {}", indexName);
                        randomBoolean(),
                .stream()
            final Set<String> acknowledgedCloses = ConcurrentCollections.newConcurrentSet();
    }
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
                        + index
                final IndexRoutingTable indexRoutingTable = state.routingTable().index(index);
                indexer.stop();
        final String[] indices = new String[randomIntBetween(3, 5)];
        final Map<String, Long> docsPerIndex = new HashMap<>();
            // stop indexers first without waiting for stop to not redundantly index on some while waiting for another one to stop
            // relocate one shard for every index to be closed
            final ClusterService clusterService = internalCluster().getInstance(
 * compatible open source license.
                        throw new AssertionError(e);
                                    "exception when releasing recovery of shard {}",
                                e
    public void testCloseWhileRelocatingShards() throws Exception {
                internalCluster().getClusterManagerName()
        ensureClusterSizeConsistency(); // wait for the cluster-manager to finish processing join.
import org.opensearch.plugins.Plugin;
                            logger.debug("releasing recovery of shard {}", startRecoveryRequest.shardId());
                    indexer.setFailureAssertion(t -> assertException(t, indexName));
        for (int i = 0; i < indices.length; i++) {
                final Thread thread = new Thread(() -> {
import java.util.stream.Collectors;
            final CountDownLatch release = new CountDownLatch(indices.length);
                    final ShardRouting replica = indexRoutingTable.shard(shardId).replicaShards().iterator().next();
                    }
import org.opensearch.indices.recovery.PeerRecoverySourceService;
                        + " docs in index "
                }
                ClusterService.class,
            for (String index : acknowledgedCloses) {
import java.util.Collection;
            // Build the list of shards for which recoveries will be blocked
    @Override
            }
import org.opensearch.indices.recovery.StartRecoveryRequest;
                        IntStream.range(0, nbDocs)
import org.opensearch.transport.TransportService;
            final ClusterState state = clusterService.state();
