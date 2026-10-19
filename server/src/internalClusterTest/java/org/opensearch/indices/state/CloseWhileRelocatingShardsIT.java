        }
            );  
 *  
        try {
                    try {  
        final Map<String, BackgroundIndexer> indexers = new HashMap<>();  
            }
                .stream()  
 * Licensed to Elasticsearch under one or more contributor  
            }  
            // relocate one shard for every index to be closed
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
                    } finally {
import static org.hamcrest.Matchers.hasSize;
import org.opensearch.core.index.shard.ShardId;
    }  
                .cluster()
 * license agreements. See the NOTICE file distributed with
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), maxRecoveries)
                    break;
                if (PeerRecoverySourceService.Actions.START_RECOVERY.equals(action)) {
                    if (randomBoolean()) {  
            for (String index : acknowledgedCloses) {
import org.opensearch.indices.recovery.PeerRecoverySourceService;  
import org.opensearch.cluster.routing.ShardRouting;  
            final ClusterService clusterService = internalCluster().getInstance(
            final Set<ShardId> blockedShards = commands.commands()
            indices[i] = indexName;
import org.opensearch.cluster.service.ClusterService;
                case 1:
        ensureGreen(TimeValue.timeValueSeconds(60L), indices);
            for (String index : indices) {
 * The OpenSearch Contributors require contributions made to  
            final CountDownLatch latch = new CountDownLatch(indices.length);
                    (long) docsPerIndex.get(index),
        final String targetNode = internalCluster().startDataOnlyNode();
                    nbDocs = scaledRandomIntBetween(1, 100);
                        currentNodeId = replica.currentNodeId();
                connection.sendRequest(requestId, action, request, options);  
                    );
    @Override  
                            interruptedRecoveries.add(startRecoveryRequest.shardId().getIndexName());  
/*
 * Modifications Copyright OpenSearch Contributors. See  
    public void testCloseWhileRelocatingShards() throws Exception {  
                    if (blockedShards.contains(startRecoveryRequest.shardId())) {
 * GitHub history for details.
 *
            client().admin()
                    "Expected "
    protected Settings nodeSettings(int nodeOrdinal) {  
            // stop indexers first without waiting for stop to not redundantly index on some while waiting for another one to stop  
        final int maxRecoveries = Integer.MAX_VALUE;
import org.opensearch.indices.recovery.StartRecoveryRequest;
 * SPDX-License-Identifier: Apache-2.0
            // If a shard recovery has been interrupted, we expect its index to be closed  
            // start index closing threads
                assertEquals(  
                if (node.isDataNode() && node.getName().equals(targetNode) == false) {  
            }
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsOpened;
                    indexRandom(
                docsPerIndex.computeIfPresent(indexName, (key, value) -> value + indexer.totalIndexedDocs());
                ClusterService.class,  
import org.opensearch.cluster.routing.allocation.decider.ConcurrentRebalanceAllocationDecider;  
            for (Map.Entry<String, BackgroundIndexer> entry : indexers.entrySet()) {
                final int shardId = numShards.numPrimaries == 1 ? 0 : randomIntBetween(0, numShards.numPrimaries - 1);
            .build();
            latch.countDown();
            final ClusterState state = clusterService.state();  
                    // Closing is not always acknowledged when shards are relocating: this is the case when the target shard is initializing
 */  
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
                    assertTrue(replica.started());
import org.apache.logging.log4j.message.ParameterizedMessage;  
                );  
                        + " but got "
import static org.opensearch.indices.state.CloseIndexIT.assertException;
            assertAcked(client().admin().cluster().reroute(new ClusterRerouteRequest().commands(commands)).get());  
import org.opensearch.transport.TransportService;
            final AllocationCommands commands = new AllocationCommands();
                    indexer.setFailureAssertion(t -> assertException(t, indexName));
import java.util.List;  
                final NumShards numShards = getNumShards(index);
            switch (i) {
                final IndexRoutingTable indexRoutingTable = state.routingTable().index(index);  
import org.opensearch.test.transport.MockTransportService;
                thread.join();  
                final Thread thread = new Thread(() -> {
                    assertIndexIsClosed(index);
                client().admin()
                default:  
                        + docsPerIndex.get(index)
                String currentNodeId = primary.currentNodeId();
                    createIndex(indexName);
import org.opensearch.common.settings.Settings;
                    waitForDocs(1, indexer);
                        } catch (final InterruptedException e) {
import static org.hamcrest.Matchers.greaterThan;  
            }
                        IntStream.range(0, nbDocs)
                    }
                        + " (close acknowledged="
 *
            );
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.Rebalance;
                assertTrue(primary.started());  
        } finally {
            final MockTransportService targetTransportService = (MockTransportService) internalCluster().getInstance(  
        final Map<String, Long> docsPerIndex = new HashMap<>();
                        + " docs in index "  
            // Create a SendRequestBehavior that will block outgoing start recovery request  
                .setTransientSettings(
                            .collect(Collectors.toList())  
                    // and max sequence number don't match and will not ack the close.  
                }
                            .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
            }
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsClosed;  
import org.opensearch.cluster.ClusterState;  
            final StubbableTransport.SendRequestBehavior sendBehavior = (connection, requestId, action, request, options) -> {
 */
        return Settings.builder()
            for (BackgroundIndexer indexer : indexers.values()) {
 */
                final String indexName = entry.getKey();
                indexer.awaitStopped();  
import static java.util.Collections.singletonList;
    }  
                        + ")",  
                        try {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        return 3;  
import org.opensearch.test.BackgroundIndexer;  
                        latch.countDown();  
            targetTransportService.clearAllRules();
            }
            for (final String indexToClose : indices) {
                            );
                targetNode
 * Unless required by applicable law or agreed to in writing,
                    .cluster()
import org.opensearch.common.unit.TimeValue;  
    @Override
            interruptedRecoveries.forEach(CloseIndexIT::assertIndexIsClosed);
 * not use this file except in compliance with the License.
                                    startRecoveryRequest.shardId()
                            logger.warn(
}
                    // or is catching up operations. In these cases the TransportVerifyShardBeforeCloseAction will detect that the global
                    targetTransportService.addSendBehavior(sourceTransportService, sendBehavior);
            assertThat(blockedShards, hasSize(indices.length));
            int nbDocs = 0;
 * KIND, either express or implied.  See the License for the
                    final BackgroundIndexer indexer = new BackgroundIndexer(indexName, "_doc", client(), -1, 1);
                }
            final Set<String> acknowledgedCloses = ConcurrentCollections.newConcurrentSet();  
                                    "exception when releasing recovery of shard {}",
import java.util.concurrent.CountDownLatch;  
                if (acknowledgedCloses.contains(index)) {  
            ensureGreen(indices);
import java.util.stream.Collectors;
                            Thread.currentThread().interrupt();
                    docsCount
                TransportService.class,
                        logger.debug("blocking recovery of shard {}", startRecoveryRequest.shardId());
                    } catch (InterruptedException e) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        ensureClusterSizeConsistency(); // wait for the cluster-manager to finish processing join.
import java.util.ArrayList;  
                                () -> new ParameterizedMessage(  
 * this file be licensed under the Apache-2.0 license or a
                )
 * this work for additional information regarding copyright
                    assertIndexIsOpened(index);  
                    indexers.put(indexName, indexer);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }
                    logger.debug("creating index {} with background indexing", indexName);
import java.util.HashMap;
                        release.countDown();
            final String indexName = "index-" + i;  
            for (Thread thread : threads) {
import java.util.Set;
            .put(super.nodeSettings(nodeOrdinal))  
                    final ShardRouting replica = indexRoutingTable.shard(shardId).replicaShards().iterator().next();
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
import java.util.Collection;
                .map(c -> new ShardId(clusterService.state().metadata().index(c.index()).getIndex(), c.shardId()))
                    createIndex(indexName);
/*  
            };
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                        + acknowledgedCloses.contains(index)
                .prepareUpdateSettings()  
                            release.await();
                    .prepareUpdateSettings()  
public class CloseWhileRelocatingShardsIT extends OpenSearchIntegTestCase {
                threads.add(thread);  
import org.opensearch.test.transport.StubbableTransport;  
            }  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * You may obtain a copy of the License at  
        );
                        + docsCount  
                        randomBoolean(),  
                    Settings.builder()
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                        Settings.builder().putNull(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey())
            assertThat("Consider that the test failed if no indices were successfully closed", acknowledgedCloses.size(), greaterThan(0));  
                            return;
    }
                    final StartRecoveryRequest startRecoveryRequest = ((StartRecoveryRequest) request);  
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)  
            assertAcked(client().admin().indices().prepareOpen("index-*"));
                }  
    }
                .map(c -> (MoveAllocationCommand) c)
 * under the License.  
                internalCluster().getClusterManagerName()
            }  
                if (numShards.numReplicas > 0) {  
                        }  
import java.util.Map;
                        latch.await();
import org.opensearch.plugins.Plugin;
                    }  
                thread.start();
                    logger.debug("creating empty index {}", indexName);
                indexer.stop();
    protected int maximumNumberOfShards() {
            docsPerIndex.put(indexName, (long) nbDocs);
                final ShardRouting primary = indexRoutingTable.shard(shardId).primaryShard();
                                ),  
                });
 * software distributed under the License is distributed on an
        return singletonList(MockTransportService.TestPlugin.class);
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), maxRecoveries)
    @Override
                    }
                        .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), Rebalance.NONE.toString())  
package org.opensearch.indices.state;
                    final TransportService sourceTransportService = internalCluster().getInstance(TransportService.class, node.getName());
 * compatible open source license.
                .collect(Collectors.toSet());  
                } else {
                    break;  
            }
                long docsCount = client().prepareSearch(index).setSize(0).setTrackTotalHits(true).get().getHits().getTotalHits().value();
                            logger.debug("releasing recovery of shard {}", startRecoveryRequest.shardId());  
            assertAcked(  
import org.opensearch.cluster.routing.IndexRoutingTable;
                        throw new AssertionError(e);  
                        + index
                    )  
 * the Apache License, Version 2.0 (the "License"); you may
                }  
            final CountDownLatch release = new CountDownLatch(indices.length);
            final Set<String> interruptedRecoveries = ConcurrentCollections.newConcurrentSet();
            for (DiscoveryNode node : state.getNodes()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    logger.debug("creating index {} with {} documents", indexName, nbDocs);  
                    if (closeResponse.isAcknowledged()) {
/*
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                commands.add(new MoveAllocationCommand(index, shardId, state.nodes().resolveNode(currentNodeId).getName(), targetNode));
                                e
            .put(ConcurrentRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING.getKey(), -1)  
 * ownership. Elasticsearch licenses this file to you under  
                final BackgroundIndexer indexer = entry.getValue();
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.test.OpenSearchIntegTestCase;
                        assertTrue("Index closing should not be acknowledged twice", acknowledgedCloses.add(indexToClose));  
            final List<Thread> threads = new ArrayList<>();  
                case 0:  
        for (int i = 0; i < indices.length; i++) {
            for (final String index : indices) {  
        assertAcked(  
            // Build the list of shards for which recoveries will be blocked
            );
                    AcknowledgedResponse closeResponse = client().admin().indices().prepareClose(indexToClose).get();
        final String[] indices = new String[randomIntBetween(3, 5)];
import java.util.stream.IntStream;
        }  
                    .setTransientSettings(
