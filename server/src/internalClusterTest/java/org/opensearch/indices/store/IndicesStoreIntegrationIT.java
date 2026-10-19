                    beginRelocationLatch.countDown();
        // disable allocation to control the situation more easily
        final String node_2 = internalCluster().startDataOnlyNode(Settings.builder().build());
/*  
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
                .setWaitForNodes("5")  
        final Path[] paths = env.availableShardPaths(new ShardId(index, shard));
            client().admin()
                .prepareUpdateSettings()
 */
        assertThat(Files.exists(indexDirectory(node_1, index)), equalTo(true));  
            .get();
            .setWaitForNoRelocatingShards(true)  
        return paths[0];
            prepareCreate("test").setSettings(
        assertAcked(  
    }
            fail("cluster didn't become red, despite of shutting 2 of 3 nodes");
        assertThat(Files.exists(shardDirectory(node_3, index, 0)), equalTo(true));
import java.util.Arrays;
        logger.debug("--> waiting for the lost shard to be recovered");  
            // wait a little so that cluster state observer is registered
        // TODO: we should add an easier to do this. It's too much of a song and dance..
        logClusterState();
                .cluster()
        );
            disruption.stopDisrupting();
        final String node3 = nodes.get(2);
        final Path[] paths = env.indexPaths(index);  
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(true));
            .prepareHealth()
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(true));
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        // delete the index. node_1 that still waits for the next cluster state update will then get the delete index next.  
            }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 *
                .cluster()
        );
 * Unless required by applicable law or agreed to in writing,
        Index index = state.metadata().index("test").getIndex();  
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
        String nodeFrom,  
    }  
        final List<String> nodes = internalCluster().startDataOnlyNodes(4);
 *  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            )
        clusterHealth = client().admin().cluster().prepareHealth().setWaitForNoRelocatingShards(true).get();
                Settings.builder()
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
import org.opensearch.transport.TransportMessageListener;
/*
        assertFalse(client().admin().cluster().prepareHealth().setWaitForActiveShards(4).get().isTimedOut());  
import org.opensearch.transport.ConnectTransportException;  
            client().admin()
        int shard,
                Settings.builder()
        TransportService transportServiceNode_2 = internalCluster().getInstance(TransportService.class, node_2);
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(false));
import org.opensearch.cluster.routing.RoutingTable;  
            // which is between 1 and 2 sec can cause each of the shard deletion requests to timeout.
    }
                    .put(indexSettings())  
        logger.debug("--> shutting down two random nodes");  
            .get();  
        assertThat(Files.exists(server2Shard), equalTo(true));
package org.opensearch.indices.store;
                .prepareUpdateSettings()  
        final String clusterManagerNode = internalCluster().getClusterManagerName();  
import org.opensearch.indices.IndicesService;  
        RoutingNode routingNode = stateResponse.getState().getRoutingNodes().node(nonClusterManagerId);
        final String node_4 = internalCluster().startNode();  
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
 * The OpenSearch Contributors require contributions made to  
        int i = 0;
            node2Shards[i] = shardRouting.shardId().id();  
            indexRoutingTableBuilder.addIndexShard(  
            public void onSuccess(String source) {
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
        assertBusy(() -> assertTrue("Expected shard to exist: " + path, Files.exists(path)));
                new IndexShardRoutingTable.Builder(new ShardId(index, j)).addShard(
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * software distributed under the License is distributed on an
                    .put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "_name", node4)  
        shardActiveRequestSent.await();
import org.opensearch.test.transport.MockTransportService;
            .prepareHealth()
 * compatible open source license.
        logger.debug("--> starting the two old nodes back");  
        assertIndexDeleted(node_1, index);
        if (randomBoolean()) { // sometimes add cluster-state delay to trigger observers in IndicesStore.ShardActiveRequestHandler
        internalCluster().client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node_1, node_2)).get();
        final String clusterManagerId = internalCluster().clusterService(clusterManagerNode).localNode().getId();  
            }
            .cluster()  
        Path server2Shard = shardDirectory(node_2, index, 0);
        client().admin()
        final String node2 = nodes.get(1);
            logClusterState();
        CountDownLatch receivedShardExistsRequestLatch = new CountDownLatch(1);
            .incrementVersion()
        assertFalse(  
import org.opensearch.cluster.ClusterState;  
        logger.info("--> making sure that shard and its replica are allocated on node_1 and node_2");  
        });
        assertShardDeleted(node_1, index, 0);
        assertShardDeleted(node_3, index, 0);
    @Override
        ensureGreen("test");  
                    .put(indexSettings())  
import org.opensearch.cluster.routing.IndexRoutingTable;  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.routing.RoutingNode;
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
    public static BlockClusterStateProcessing relocateAndBlockCompletion(
        logger.info("--> waiting for relocation to start");
            .build();  
        beginRelocationLatch.await();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)  
        logger.info("--> starting disruption");  
                .setTransientSettings(
    public IndicesStoreIntegrationIT(Settings nodeSettings) {
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(true));  
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
        logger.info("--> running cluster_health");
            )  
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
            @Override  
public class IndicesStoreIntegrationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    public void testShardsCleanup() throws Exception {  
                .prepareHealth()  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        internalCluster().startClusterManagerOnlyNode();  
        final Path path = shardDirectory(server, index, shard);  
        disruption.startDisrupting();
            public void onRequestReceived(long requestId, String action) {
        internalCluster().startNodes(node1DataPathSettings, node2DataPathSettings);
        final int[] node2Shards = new int[routingNode.numberOfOwningShards()];  
        ensureGreen();  
                .get()
        logger.info("--> starting node server3");  
                .cluster()  
        assertAcked(  
        transportService.addMessageListener(new TransportMessageListener() {  
        return paths[0];  
    }  
    private void assertShardExists(final String server, final Index index, final int shard) throws Exception {
        BlockClusterStateProcessing disruption = new BlockClusterStateProcessing(nodeTo, random());  
            .setWaitForNodes("4")  
        // allocation filtering may not have immediate effect  
    }  
        assertAcked(  
import org.opensearch.transport.TransportService;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    }
                }  
        // we will use this later on, handy to start now to make sure it has a different data folder that node 1,2 &3  
        assertBusy(() -> assertTrue(internalCluster().getInstance(IndicesService.class, node4).hasIndex(index)));  
            .setTransientSettings(
        }
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)  
import java.nio.file.Files;
                .setWaitForGreenStatus()
    /**
 * KIND, either express or implied.  See the License for the
                    TestShardRouting.newShardRouting("test", j, clusterManagerId, true, ShardRoutingState.STARTED)
            prepareCreate("test").setSettings(
        assertThat(clusterHealth.isTimedOut(), equalTo(false));  
            client().admin()
            Thread.yield();
        // wait for 4 active shards - we should have lost one shard
        logger.info("--> creating index [test] with one shard and on replica");
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node_2));  
import static org.hamcrest.Matchers.equalTo;
            .cluster()
        ClusterState newState = ClusterState.builder(currentState)  
            .setWaitForNoRelocatingShards(true)
    public static Collection<Object[]> parameters() {
                throw new ConnectTransportException(connection.getNode(), "DISCONNECT: simulated");
                .isTimedOut()
                .cluster()
import java.util.concurrent.CountDownLatch;
        assertThat(Files.exists(indexDirectory(node_1, index)), equalTo(true));  
        );
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        assertIndexDeleted(node_2, index);
            .setWaitForNodes("3")
        assertThat(Files.exists(indexDirectory(node_3, index)), equalTo(true));
            client().admin()
import org.opensearch.env.NodeEnvironment;
                    receivedShardExistsRequestLatch.countDown();
                latch.countDown();
        CountDownLatch beginRelocationLatch = new CountDownLatch(1);  
            .put(Environment.PATH_DATA_SETTING.getKey(), createTempDir())  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        // node_1 will then wait for the next cluster state change before it tries a next attempt to delete the shard.
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
                    .put(indexSettings())  
 * Modifications Copyright OpenSearch Contributors. See
                    logger.info("received: {}, relocation starts", action);
import org.opensearch.cluster.service.ClusterService;
        logger.info("--> making sure that shard is not allocated on server3");
        return Settings.builder()
        logger.info("--> making sure that shard and its replica exist on server1, server2 and server3");  
     * relocate a shard and block cluster state processing on the relocation target node to activate the shard  
            )  
        assertAcked(  
        logger.info("--> making sure that shard and its replica are allocated on node_1 and node_2");
        );
        logger.info("--> starting node server3");
        assertAcked(
        // testShardActiveElseWhere might change the state of a non-cluster-manager node  
        Index index = state.metadata().index("test").getIndex();
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
import org.opensearch.core.index.Index;
        logger.debug("--> allowing index to be assigned to node [{}]", node4);
        transportServiceNode_1.addSendBehavior(transportServiceNode_2, (connection, requestId, action, request, options) -> {  
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "all")
        for (int j = 0; j < numShards; j++) {
                .setWaitForNoRelocatingShards(true)
 * this work for additional information regarding copyright
        );
            .setWaitForNoRelocatingShards(true)
    }
        final String node4 = nodes.get(3);
        return Arrays.asList(MockTransportService.TestPlugin.class);
            )
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Settings;  
        ClusterHealthResponse clusterHealth = client().admin()
        assertThat(Files.exists(shardDirectory(node_3, index, 0)), equalTo(true));  
        assertThat(Files.exists(indexDirectory(node_2, index)), equalTo(true));
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));  
            .setWaitForNodes("2")
import java.util.Collection;
import org.apache.logging.log4j.Logger;  
        logger.info("--> making sure that shard and its replica are allocated on server1 and server3 but not on server2");
                shardActiveRequestSent.countDown();
            public void onFailure(String source, Exception e) {  
            BlockClusterStateProcessing disruption = relocateAndBlockCompletion(logger, "test", 0, node_1, node_3);  
            }  
        internalCluster().client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(index, shard, nodeFrom, nodeTo)).get();  
}
        logger.info("--> running cluster_health");
        assertThat(Files.exists(shardDirectory(node_3, index, 0)), equalTo(true));  
        final Path path = indexDirectory(server, index);
            client().admin()
    }
        NodeEnvironment env = internalCluster().getInstance(NodeEnvironment.class, server);  
        clusterHealth = client().admin()  
            .prepareHealth()
            );
        final String node_1 = internalCluster().startNode();
import java.util.List;  
        final String nonClusterManagerNode = nodes.get(0).equals(clusterManagerNode) ? nodes.get(1) : nodes.get(0);
import org.opensearch.env.Environment;
import org.opensearch.test.InternalTestCluster;  
 * ownership. Elasticsearch licenses this file to you under  
    public void testShardCleanupIfShardDeletionAfterRelocationFailedAndIndexDeleted() throws Exception {  
    protected Settings nodeSettings(int nodeOrdinal) { // simplify this and only use a single data path  
    @Override
            i++;
        );
 * specific language governing permissions and limitations
        }  
        CountDownLatch latch = new CountDownLatch(1);
        assertThat(Files.exists(indexDirectory(node_2, index)), equalTo(true));
        logger.info("--> move shard from node_1 to node_3, and wait for relocation to finish");  
import java.util.concurrent.TimeUnit;
import org.opensearch.cluster.routing.ShardRoutingState;
        assertBusy(() -> assertFalse("Expected shard to not exist: " + path, Files.exists(path)));
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "all")  
        if (health.getStatus() != ClusterHealthStatus.RED) {  
        assertThat(clusterHealth.isTimedOut(), equalTo(false));  
                    // to the other nodes that should have a copy according to cluster state.  
import java.nio.file.Path;  
        ensureGreen("test");
        receivedShardExistsRequestLatch.await();  
    protected void ensureClusterStateConsistency() throws IOException {
 * not use this file except in compliance with the License.
        }
        );  
        }
                if (action.equals(PeerRecoveryTargetService.Actions.FILES_INFO)) {  
        String nodeTo
                    // Whenever a node deletes a shard because it was relocated somewhere else, it first
        );
        return remoteStoreSettings;
            prepareCreate("test").setSettings(
        assertShardDeleted(node_1, index, 0);
 * the Apache License, Version 2.0 (the "License"); you may
        final String node_2 = internalCluster().startNode(nonClusterManagerNode());
        assertAcked(  
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)  
    ) throws InterruptedException {
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(false));  
        assertBusy(() -> assertFalse("Expected index to be deleted: " + path, Files.exists(path)));  
            .getClusterApplierService();
                logger.info("prevent shard active request from being sent");  
            .get();
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("5").get().isTimedOut());
        List<String> nodesToShutDown = randomSubsetOf(2, node1, node2, node3);
    }  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        logger.info("--> creating index [test] with one shard and on replica");  
                )  
        logger.info("--> stopping node {}", node_2);
        return disruption;
        logger.debug("--> verifying index is red");
        internalCluster().setDisruptionScheme(disruption);
        assertShardDeleted(node_2, index, 0);  
        ensureGreen("test");
        // due to rebalancing, and delete its content  
        logger.info("--> starting node node_4");
        client().admin().indices().prepareDelete("test").get();
import org.opensearch.cluster.health.ClusterHealthStatus;
    public void testIndexCleanup() throws Exception {
                .indices()
    }
        logger.info("--> creating index [test] with one shard and on replica");
    }  
                )
        assertThat(Files.exists(indexDirectory(node_2, index)), equalTo(true));
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
        internalCluster().startNode(nonDataNode());
 */  
        logger.info("--> waiting for relocation to finish");
    }
            @Override
    public void testShardActiveElsewhereDoesNotDeleteAnother() throws Exception {
        logger.info("--> done cluster_health, status {}", clusterHealth.getStatus());
        List<String> nodes = internalCluster().startNodes(2);
            .prepareUpdateSettings()  
        logger.info("--> running cluster_health");
        // so we cannot check state consistency of this cluster
                    // checks if enough other copies are started somewhere else. The node sends a ShardActiveRequest
        assertThat(Files.exists(indexDirectory(node_1, index)), equalTo(false));
            .put(super.nodeSettings(nodeOrdinal))
        } else {
        for (int shard : node2Shards) {
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(true));  
import org.opensearch.test.disruption.BlockClusterStateProcessing;
        );
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        waitNoPendingTasksOnAll();  
            assertShardExists(nonClusterManagerNode, index, shard);  
                Settings.builder()
            internalCluster().client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node_1, node_3)).get();  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodesToShutDown.get(1)));
        // we have to do this in two steps as we now do async shard fetching before assigning, so the change to the
        }
    public void testShardActiveElseWhere() throws Exception {  
        );
            prepareCreate("test").setSettings(
            .cluster()
                .setTransientSettings(
        assertThat(Files.exists(shardDirectory(node_2, index, 0)), equalTo(false));
        logger.info("--> relocation completed (but cluster state processing block still in place)");
import org.opensearch.cluster.service.ClusterApplierService;
        assertThat(Files.exists(indexDirectory(node_2, index)), equalTo(false));  
 */  
            if (action.equals("internal:index/shard/exists") && shardActiveRequestSent.getCount() > 0) {
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
    private Path shardDirectory(String server, Index index, int shard) {
        assertAcked(
     */
            // to prevent this we are setting the timeout here to something highish ie. the default in practice  
            prepareCreate("test").setSettings(
        ClusterHealthResponse clusterHealth = client().admin().cluster().prepareHealth().setWaitForNoRelocatingShards(true).get();  
 *
import org.opensearch.cluster.routing.TestShardRouting;  
        for (ShardRouting shardRouting : routingNode) {
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.cluster.routing.ShardRouting;
            .setWaitForGreenStatus()  
        logger.info("Checking if shards aren't removed");
                )  
    private Path indexDirectory(String server, Index index) {
        assertThat(Files.exists(indexDirectory(node_3, index)), equalTo(false));
        String index,
        Index index = resolveIndex("test");
        assertThat(Files.exists(shardDirectory(node_3, index, 0)), equalTo(false));  
                .cluster()
        logger.info("Node [{}] has shards: {}", nonClusterManagerNode, Arrays.toString(node2Shards));  
        assertIndexDeleted(node_1, index);  
            connection.sendRequest(requestId, action, request, options);  
    @ParametersFactory  
        waitNoPendingTasksOnAll();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodesToShutDown.get(0)));
    }
            .routingTable(RoutingTable.builder().add(indexRoutingTableBuilder).build())
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
            // by default this value is 1 sec in tests (30 sec in practice) but we adding disruption here
        Settings node1DataPathSettings = internalCluster().dataPathSettings(nodesToShutDown.get(0));
        assert paths.length == 1;
import org.opensearch.cluster.service.ClusterApplier.ClusterApplyListener;  
        });
                Settings.builder()  
        assertThat(Files.exists(server2Shard), equalTo(true));
        // it must still delete the shard, even if it cannot find it anymore in indicesservice
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertAcked(  
import java.io.IOException;
        ensureGreen("test");  
        final CountDownLatch shardActiveRequestSent = new CountDownLatch(1);
                .setTransientSettings(
        ClusterHealthResponse health = client().admin().cluster().prepareHealth().setWaitForNodes("3").get();
/*  
        clusterApplierService.onNewClusterState("test", () -> newState, new ClusterApplyListener() {
 * license agreements. See the NOTICE file distributed with
        assertThat(Files.exists(indexDirectory(node_1, index)), equalTo(true));  
                throw new AssertionError("Expected a proper response", e);
                    logger.info("received: {}, relocation done", action);
        Logger logger,  
                .prepareUpdateSettings()  
        super(nodeSettings);  
    }  
        assertShardDeleted(node_4, index, 0);
        final String node_2 = internalCluster().startNode();
                .setSettings(Settings.builder().put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "_name", "NONE"))
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().get();  
        final int numShards = scaledRandomIntBetween(2, 10);  
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
 * You may obtain a copy of the License at  
 * under the License.  
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
        // add a transport delegate that will prevent the shard active request to succeed the first time after relocation has finished.
            .cluster()
 * SPDX-License-Identifier: Apache-2.0
        ClusterHealthResponse clusterHealth = client().admin()  
        final String node1 = nodes.get(0);  
            )
    }  
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeTo);
                latch.countDown();
            .put(IndicesStore.INDICES_STORE_DELETE_SHARD_TIMEOUT.getKey(), new TimeValue(30, TimeUnit.SECONDS))
                )  
                .prepareUpdateSettings()  
        Index index = state.metadata().index("test").getIndex();
        assertAcked(  
    private void assertIndexDeleted(final String server, final Index index) throws Exception {
        String node_3 = internalCluster().startNode();  
import org.opensearch.plugins.Plugin;
        Settings node2DataPathSettings = internalCluster().dataPathSettings(nodesToShutDown.get(1));  
        // disable allocation again to control concurrency a bit and allow shard active to kick in before allocation
        latch.await();
                .setTransientSettings(
            }  
        // disable relocations when we do this, to make sure the shards are not relocated from node2
            client().admin()
        assertThat(Files.exists(shardDirectory(node_1, index, 0)), equalTo(true));
        NodeEnvironment env = internalCluster().getInstance(NodeEnvironment.class, server);
        ClusterState currentState = clusterApplierService.state();  
                .prepareUpdateSettings("test")  
            logger.info("--> stopping disruption");  
        final String nonClusterManagerId = internalCluster().clusterService(nonClusterManagerNode).localNode().getId();
    @Override
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("2").get().isTimedOut());  
            .get();
        // use a tracer on the target node to track relocation start and end
    }
        final Path path = shardDirectory(server, index, shard);
        ensureGreen("test");
        assertThat(Files.exists(indexDirectory(node_1, index)), equalTo(true));
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
            @Override
        MockTransportService transportServiceNode_1 = (MockTransportService) internalCluster().getInstance(TransportService.class, node_1);  
                } else if (action.equals(IndicesStore.ACTION_SHARD_EXISTS)) {  
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                Settings.builder()
                    .put(indexSettings())
        ClusterApplierService clusterApplierService = internalCluster().getInstance(ClusterService.class, nonClusterManagerNode)
    /* Test that shard is deleted in case ShardActiveRequest after relocation and next incoming cluster state is an index delete. */
        final String node_1 = internalCluster().startNode();
        final String node_1 = internalCluster().startNode(nonClusterManagerNode());  
import static org.opensearch.test.NodeRoles.nonDataNode;
        assertAcked(
        final Index index = stateResponse.getState().metadata().index("test").getIndex();
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        final String node_3 = internalCluster().startNode(nonClusterManagerNode());
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                ).build()  
        });
        assert paths.length == 1;
        logger.debug("--> waiting for shards to recover on [{}]", node4);
 * this file be licensed under the Apache-2.0 license or a
            )
        );
 * GitHub history for details.
        logger.info("--> move shard from {} to {}, and wait for relocation to finish", node_1, node_2);  
        assertThat(Files.exists(indexDirectory(node_2, index)), equalTo(false));
        logger.info("--> running cluster_health");
 * Licensed to Elasticsearch under one or more contributor  
    private void assertShardDeleted(final String server, final Index index, final int shard) throws Exception {  
            .build();
