 *
    }
        logger.info("--> relocation completed (but cluster state processing block still in place)");
        NodeEnvironment env = internalCluster().getInstance(NodeEnvironment.class, server);
            )
import org.opensearch.cluster.service.ClusterApplier.ClusterApplyListener;
        Index index = state.metadata().index("test").getIndex();
        final String nonClusterManagerNode = nodes.get(0).equals(clusterManagerNode) ? nodes.get(1) : nodes.get(0);
                .setWaitForNodes("5")
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodesToShutDown.get(1)));
        List<String> nodesToShutDown = randomSubsetOf(2, node1, node2, node3);
            .put(super.nodeSettings(nodeOrdinal))
                .prepareUpdateSettings("test")
            BlockClusterStateProcessing disruption = relocateAndBlockCompletion(logger, "test", 0, node_1, node_3);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        final Path path = shardDirectory(server, index, shard);
            )
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(true));
        Index index = resolveIndex("test");
        assertThat(Files.exists(indexDirectory(node_1, index)), equalTo(true));
        internalCluster().client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node_1, node_2)).get();
            Thread.yield();
        final String node4 = nodes.get(3);
        assertAcked(
                throw new ConnectTransportException(connection.getNode(), "DISCONNECT: simulated");
 * under the License.
        }
                )
                    receivedShardExistsRequestLatch.countDown();
        // wait for 4 active shards - we should have lost one shard
        CountDownLatch receivedShardExistsRequestLatch = new CountDownLatch(1);
    public void testShardCleanupIfShardDeletionAfterRelocationFailedAndIndexDeleted() throws Exception {
        ClusterState newState = ClusterState.builder(currentState)
        );
    private Path indexDirectory(String server, Index index) {
 * Licensed to Elasticsearch under one or more contributor
                    .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
        logger.info("--> making sure that shard is not allocated on server3");
        // node_1 will then wait for the next cluster state change before it tries a next attempt to delete the shard.
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertBusy(() -> assertTrue(internalCluster().getInstance(IndicesService.class, node4).hasIndex(index)));
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(true));
 * Unless required by applicable law or agreed to in writing,
        assertAcked(
        if (health.getStatus() != ClusterHealthStatus.RED) {
        internalCluster().setDisruptionScheme(disruption);
        logger.info("--> running cluster_health");
    }
                    .put(indexSettings())
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
            );
import org.opensearch.transport.TransportMessageListener;
            if (action.equals("internal:index/shard/exists") && shardActiveRequestSent.getCount() > 0) {
        );
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            // to prevent this we are setting the timeout here to something highish ie. the default in practice
        // TODO: we should add an easier to do this. It's too much of a song and dance..
        logClusterState();
import java.io.IOException;
            .setWaitForNodes("2")
        logger.debug("--> waiting for shards to recover on [{}]", node4);
    public void testShardsCleanup() throws Exception {
                .cluster()
        final Path path = indexDirectory(server, index);
        logger.info("--> creating index [test] with one shard and on replica");
                .cluster()
import org.opensearch.transport.ConnectTransportException;
        final CountDownLatch shardActiveRequestSent = new CountDownLatch(1);
        final Index index = stateResponse.getState().metadata().index("test").getIndex();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node_2));
        return paths[0];
        clusterApplierService.onNewClusterState("test", () -> newState, new ClusterApplyListener() {
        ensureGreen("test");
        for (ShardRouting shardRouting : routingNode) {
        assertThat(Files.exists(shardDirectory(node_3, index, 0)), equalTo(false));
        ClusterHealthResponse clusterHealth = client().admin()
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertThat(Files.exists(indexDirectory(node_2, index)), equalTo(true));
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        logger.info("Checking if shards aren't removed");
import org.opensearch.common.settings.Settings;
            .put(Environment.PATH_DATA_SETTING.getKey(), createTempDir())
 * this file be licensed under the Apache-2.0 license or a
     */
                }
                .prepareUpdateSettings()
        );
                )
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        int i = 0;
 * SPDX-License-Identifier: Apache-2.0
            logClusterState();
        if (randomBoolean()) { // sometimes add cluster-state delay to trigger observers in IndicesStore.ShardActiveRequestHandler
        logger.info("--> making sure that shard and its replica are allocated on node_1 and node_2");
                .prepareUpdateSettings()
            }
        assertThat(Files.exists(indexDirectory(node_3, index)), equalTo(false));
                latch.countDown();
                if (action.equals(PeerRecoveryTargetService.Actions.FILES_INFO)) {
        logger.debug("--> allowing index to be assigned to node [{}]", node4);
                new IndexShardRoutingTable.Builder(new ShardId(index, j)).addShard(
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
            i++;
import org.opensearch.common.unit.TimeValue;
        assertAcked(
        final String clusterManagerId = internalCluster().clusterService(clusterManagerNode).localNode().getId();
        final String node3 = nodes.get(2);
 * this work for additional information regarding copyright
            .getClusterApplierService();
/*
    /* Test that shard is deleted in case ShardActiveRequest after relocation and next incoming cluster state is an index delete. */
        super(nodeSettings);
                .cluster()
        final Path[] paths = env.availableShardPaths(new ShardId(index, shard));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // disable allocation to control the situation more easily
            .setWaitForNoRelocatingShards(true)
        );
 * You may obtain a copy of the License at
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
        final String node_3 = internalCluster().startNode(nonClusterManagerNode());
            .get();
        final String node_2 = internalCluster().startNode();
                    .put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "_name", node4)
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(false));
                .setSettings(Settings.builder().put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "_name", "NONE"))
            .get();
        logger.info("Node [{}] has shards: {}", nonClusterManagerNode, Arrays.toString(node2Shards));
        logger.info("--> starting node server3");
        assertBusy(() -> assertTrue("Expected shard to exist: " + path, Files.exists(path)));
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.index.shard.ShardId;
 * The OpenSearch Contributors require contributions made to
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("2").get().isTimedOut());
        logger.info("--> done cluster_health, status {}", clusterHealth.getStatus());
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
                .cluster()
import org.opensearch.plugins.Plugin;
        ensureGreen("test");
 * not use this file except in compliance with the License.
            client().admin()
public class IndicesStoreIntegrationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .setTransientSettings(
            public void onSuccess(String source) {
        );
        assertIndexDeleted(node_1, index);
        internalCluster().client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(index, shard, nodeFrom, nodeTo)).get();
        latch.await();
        }
        final String node_1 = internalCluster().startNode(nonClusterManagerNode());
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        }
import org.opensearch.cluster.metadata.IndexMetadata;
        String index,
            .setWaitForGreenStatus()
import org.opensearch.test.transport.MockTransportService;
    }
        Path server2Shard = shardDirectory(node_2, index, 0);
            .prepareHealth()
    protected Settings nodeSettings(int nodeOrdinal) { // simplify this and only use a single data path
                .prepareUpdateSettings()
        ensureGreen("test");
    }
import java.util.concurrent.CountDownLatch;
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
            disruption.stopDisrupting();
            }
 */
                    // checks if enough other copies are started somewhere else. The node sends a ShardActiveRequest
    }
    }
        logger.debug("--> shutting down two random nodes");
import java.nio.file.Files;
        return paths[0];
                    .put(indexSettings())
        assertAcked(
    @ParametersFactory
                Settings.builder()
        // testShardActiveElseWhere might change the state of a non-cluster-manager node
        logger.info("--> making sure that shard and its replica are allocated on node_1 and node_2");
        String node_3 = internalCluster().startNode();
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "all")
        // so we cannot check state consistency of this cluster
                .setWaitForGreenStatus()
        client().admin()
        assertThat(Files.exists(shardDirectory(node_3, index, 0)), equalTo(true));
        ClusterState currentState = clusterApplierService.state();
        final Path[] paths = env.indexPaths(index);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    @Override
        List<String> nodes = internalCluster().startNodes(2);
        );
        );
        for (int j = 0; j < numShards; j++) {
    public void testShardActiveElseWhere() throws Exception {
        });
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
    }
        assertShardDeleted(node_1, index, 0);
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeTo);
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        Logger logger,
                .prepareUpdateSettings()
        assertThat(Files.exists(server2Shard), equalTo(true));
import org.opensearch.test.disruption.BlockClusterStateProcessing;
        RoutingNode routingNode = stateResponse.getState().getRoutingNodes().node(nonClusterManagerId);
            client().admin()
            )
            logger.info("--> stopping disruption");
        assertIndexDeleted(node_1, index);
        Index index = state.metadata().index("test").getIndex();
            .incrementVersion()
        assertFalse(client().admin().cluster().prepareHealth().setWaitForActiveShards(4).get().isTimedOut());
            client().admin()
            assertShardExists(nonClusterManagerNode, index, shard);
            public void onFailure(String source, Exception e) {
import org.opensearch.indices.IndicesService;
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().get();
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
                .prepareHealth()
    private Path shardDirectory(String server, Index index, int shard) {
import org.opensearch.cluster.service.ClusterApplierService;
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(true));
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        return remoteStoreSettings;
     * relocate a shard and block cluster state processing on the relocation target node to activate the shard
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "all")
        internalCluster().startNodes(node1DataPathSettings, node2DataPathSettings);
            .prepareHealth()
        assertAcked(
        final String node_4 = internalCluster().startNode();
        logger.info("--> creating index [test] with one shard and on replica");
    }
        assertAcked(
 *
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("5").get().isTimedOut());
        // delete the index. node_1 that still waits for the next cluster state update will then get the delete index next.
        Settings node2DataPathSettings = internalCluster().dataPathSettings(nodesToShutDown.get(1));
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
        // disable allocation again to control concurrency a bit and allow shard active to kick in before allocation
    }
            .cluster()
            fail("cluster didn't become red, despite of shutting 2 of 3 nodes");
import org.opensearch.cluster.service.ClusterService;
            indexRoutingTableBuilder.addIndexShard(
                .setWaitForNoRelocatingShards(true)
            .setWaitForNodes("3")
            // by default this value is 1 sec in tests (30 sec in practice) but we adding disruption here
    }
 *
import org.opensearch.cluster.routing.IndexRoutingTable;
            prepareCreate("test").setSettings(
        ensureGreen("test");
        return Arrays.asList(MockTransportService.TestPlugin.class);
        // disable relocations when we do this, to make sure the shards are not relocated from node2
            .setWaitForNoRelocatingShards(true)
        assertAcked(
        assertThat(Files.exists(indexDirectory(node_1, index)), equalTo(false));
        return Settings.builder()
            public void onRequestReceived(long requestId, String action) {
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
        CountDownLatch beginRelocationLatch = new CountDownLatch(1);
        );
                    .put(indexSettings())
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        internalCluster().startNode(nonDataNode());
import java.util.Collection;
        // due to rebalancing, and delete its content
            .cluster()
 * GitHub history for details.
                    logger.info("received: {}, relocation done", action);
import org.opensearch.cluster.health.ClusterHealthStatus;
        final String node_2 = internalCluster().startDataOnlyNode(Settings.builder().build());
        assertThat(Files.exists(indexDirectory(node_1, index)), equalTo(true));
            @Override
        logger.info("--> move shard from {} to {}, and wait for relocation to finish", node_1, node_2);
        );
        logger.info("--> waiting for relocation to start");
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
            )
                    .put(indexSettings())
                    // Whenever a node deletes a shard because it was relocated somewhere else, it first
            prepareCreate("test").setSettings(
        final Path path = shardDirectory(server, index, shard);
                throw new AssertionError("Expected a proper response", e);
        assertAcked(
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        final int numShards = scaledRandomIntBetween(2, 10);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                )
        NodeEnvironment env = internalCluster().getInstance(NodeEnvironment.class, server);
        });
                .indices()
        assertThat(Files.exists(indexDirectory(node_1, index)), equalTo(true));
        transportServiceNode_1.addSendBehavior(transportServiceNode_2, (connection, requestId, action, request, options) -> {
import org.opensearch.env.Environment;
        logger.info("--> making sure that shard and its replica exist on server1, server2 and server3");
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        assertShardDeleted(node_1, index, 0);
            .get();
        assert paths.length == 1;
        assert paths.length == 1;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
import org.opensearch.cluster.routing.RoutingNode;
        assertIndexDeleted(node_2, index);
        logger.info("--> running cluster_health");
            .cluster()
        assertAcked(
        // allocation filtering may not have immediate effect
    }
        assertThat(Files.exists(indexDirectory(node_2, index)), equalTo(true));
    }
    protected void ensureClusterStateConsistency() throws IOException {
import org.opensearch.transport.TransportService;
    }
            .put(IndicesStore.INDICES_STORE_DELETE_SHARD_TIMEOUT.getKey(), new TimeValue(30, TimeUnit.SECONDS))
            client().admin()
        int shard,
            )
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(false));
                    logger.info("received: {}, relocation starts", action);
        clusterHealth = client().admin().cluster().prepareHealth().setWaitForNoRelocatingShards(true).get();
        });
import org.opensearch.cluster.routing.ShardRouting;
                    beginRelocationLatch.countDown();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
/*
        logger.info("--> starting disruption");
import java.util.concurrent.TimeUnit;
    }
        ClusterHealthResponse clusterHealth = client().admin().cluster().prepareHealth().setWaitForNoRelocatingShards(true).get();
        assertShardDeleted(node_3, index, 0);
        waitNoPendingTasksOnAll();
            .prepareHealth()
                .setTransientSettings(
        ensureGreen("test");
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
import java.util.Arrays;
            // which is between 1 and 2 sec can cause each of the shard deletion requests to timeout.
    ) throws InterruptedException {
            )
 * Modifications Copyright OpenSearch Contributors. See
 */
        final String node_1 = internalCluster().startNode();
        for (int shard : node2Shards) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    @Override
            node2Shards[i] = shardRouting.shardId().id();
            }
            .routingTable(RoutingTable.builder().add(indexRoutingTableBuilder).build())
                Settings.builder()
import org.opensearch.cluster.routing.TestShardRouting;
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(false));
    private void assertShardExists(final String server, final Index index, final int shard) throws Exception {
        logger.info("--> running cluster_health");
        beginRelocationLatch.await();
                ).build()
        logger.info("--> making sure that shard and its replica are allocated on server1 and server3 but not on server2");
        client().admin().indices().prepareDelete("test").get();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        disruption.startDisrupting();
                Settings.builder()
    @Override
import org.opensearch.cluster.ClusterState;
        logger.info("--> starting node node_4");
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodesToShutDown.get(0)));
        assertThat(Files.exists(indexDirectory(node_2, index)), equalTo(true));
        logger.info("--> creating index [test] with one shard and on replica");
        logger.info("--> stopping node {}", node_2);
        // we will use this later on, handy to start now to make sure it has a different data folder that node 1,2 &3
import org.apache.logging.log4j.Logger;
        logger.info("--> move shard from node_1 to node_3, and wait for relocation to finish");
        logger.info("--> waiting for relocation to finish");
            .setWaitForNodes("4")
        final String nonClusterManagerId = internalCluster().clusterService(nonClusterManagerNode).localNode().getId();
        assertBusy(() -> assertFalse("Expected index to be deleted: " + path, Files.exists(path)));
        assertShardDeleted(node_4, index, 0);
        logger.debug("--> waiting for the lost shard to be recovered");
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
                .cluster()
        }
        logger.debug("--> verifying index is red");
                .setTransientSettings(
        ClusterApplierService clusterApplierService = internalCluster().getInstance(ClusterService.class, nonClusterManagerNode)
        final String clusterManagerNode = internalCluster().getClusterManagerName();
 */
import java.nio.file.Path;
                Settings.builder()
        logger.info("--> running cluster_health");
        receivedShardExistsRequestLatch.await();
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        Settings node1DataPathSettings = internalCluster().dataPathSettings(nodesToShutDown.get(0));
        assertThat(Files.exists(server2Shard), equalTo(true));
        shardActiveRequestSent.await();
        final String node_2 = internalCluster().startNode(nonClusterManagerNode());
        assertBusy(() -> assertFalse("Expected shard to not exist: " + path, Files.exists(path)));
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
    private void assertShardDeleted(final String server, final Index index, final int shard) throws Exception {
                shardActiveRequestSent.countDown();
        String nodeFrom,
            .prepareUpdateSettings()
        assertThat(Files.exists(shardDirectory(node_3, index, 0)), equalTo(true));
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
        );
            connection.sendRequest(requestId, action, request, options);
        String nodeTo
                )
            // wait a little so that cluster state observer is registered
import org.opensearch.env.NodeEnvironment;
                latch.countDown();
 * compatible open source license.
                .get()
            .build();
        logger.debug("--> starting the two old nodes back");
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(true));
    public IndicesStoreIntegrationIT(Settings nodeSettings) {
        final String node1 = nodes.get(0);
    /**
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.routing.RoutingTable;
            .setWaitForNoRelocatingShards(true)
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
    public void testShardActiveElsewhereDoesNotDeleteAnother() throws Exception {
            prepareCreate("test").setSettings(
        final String node_1 = internalCluster().startNode();
                Settings.builder()
        assertThat(Files.exists(shardDirectory(node_3, index, 0)), equalTo(true));
}
        assertThat(Files.exists(indexDirectory(node_3, index)), equalTo(true));
package org.opensearch.indices.store;
                .isTimedOut()
        Index index = state.metadata().index("test").getIndex();
            prepareCreate("test").setSettings(
import static org.opensearch.test.NodeRoles.nonDataNode;
            prepareCreate("test").setSettings(
 * specific language governing permissions and limitations
            }
            .get();
            client().admin()
        BlockClusterStateProcessing disruption = new BlockClusterStateProcessing(nodeTo, random());
            .build();
                } else if (action.equals(IndicesStore.ACTION_SHARD_EXISTS)) {
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        }
        final List<String> nodes = internalCluster().startDataOnlyNodes(4);
    public void testIndexCleanup() throws Exception {
            client().admin()
        assertThat(Files.exists(indexDirectory(node_1, index)), equalTo(true));
        transportService.addMessageListener(new TransportMessageListener() {
    public static BlockClusterStateProcessing relocateAndBlockCompletion(
            @Override
        // add a transport delegate that will prevent the shard active request to succeed the first time after relocation has finished.
 *    http://www.apache.org/licenses/LICENSE-2.0
                logger.info("prevent shard active request from being sent");
                .setTransientSettings(
        // it must still delete the shard, even if it cannot find it anymore in indicesservice
        clusterHealth = client().admin()
    public static Collection<Object[]> parameters() {
 * software distributed under the License is distributed on an
        // we have to do this in two steps as we now do async shard fetching before assigning, so the change to the
        logger.info("--> starting node server3");
        assertFalse(
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.test.InternalTestCluster;
        waitNoPendingTasksOnAll();
        final String node2 = nodes.get(1);
/*
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        assertThat(Files.exists(indexDirectory(node_2, index)), equalTo(false));
import org.opensearch.core.index.Index;
            .cluster()
        );
        internalCluster().startClusterManagerOnlyNode();
        return disruption;
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
 * the Apache License, Version 2.0 (the "License"); you may
        MockTransportService transportServiceNode_1 = (MockTransportService) internalCluster().getInstance(TransportService.class, node_1);
        ensureGreen();
                    // to the other nodes that should have a copy according to cluster state.
        ClusterHealthResponse clusterHealth = client().admin()
        // use a tracer on the target node to track relocation start and end
                    TestShardRouting.newShardRouting("test", j, clusterManagerId, true, ShardRoutingState.STARTED)
    }
                .setTransientSettings(
            internalCluster().client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node_1, node_3)).get();
 * ownership. Elasticsearch licenses this file to you under
            @Override
    private void assertIndexDeleted(final String server, final Index index) throws Exception {
        assertAcked(
        } else {
        TransportService transportServiceNode_2 = internalCluster().getInstance(TransportService.class, node_2);
        assertThat(Files.exists(indexDirectory(node_2, index)), equalTo(false));
        final int[] node2Shards = new int[routingNode.numberOfOwningShards()];
import org.opensearch.cluster.routing.ShardRoutingState;
 * KIND, either express or implied.  See the License for the
        CountDownLatch latch = new CountDownLatch(1);
        assertShardDeleted(node_2, index, 0);
