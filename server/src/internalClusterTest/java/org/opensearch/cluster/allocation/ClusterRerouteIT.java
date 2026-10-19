            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),  
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
        logger.info("--> explicitly allocate shard 1, actually allocating, no dry run");
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        final String indexName = "test_index";
            assertThat(response.getExplanations().getYesDecisionMessages().get(0), containsString(nodeName1));
 * KIND, either express or implied.  See the License for the
            .actionGet();
                .cluster()
        internalCluster().startNode(commonSettings);
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
            .cluster()  
import static org.hamcrest.Matchers.containsString;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        if (randomBoolean()) {
            .setWaitForActiveShards(ActiveShardCount.NONE)
            .put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name())  
        logger.info("--> stopping node1");
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 2)
            .add(new MoveAllocationCommand("test", 0, node_1, node_2))  
            );  
        assertThat(
        assertThat(cluster().size(), equalTo(1));
 *
import org.apache.logging.log4j.Logger;  
            .setWaitForActiveShards(ActiveShardCount.NONE)
        final String nodeName2 = internalCluster().startNode(settings);
            .build();
            .cluster()  
                    "no completed message logged on dry run",
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),  
                    .prepareReroute()  
            .setWaitForEvents(Priority.LANGUID)  
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));  
                assertAcked(client().admin().indices().prepareClose(indexName));
                    .setWaitForNoRelocatingShards(true)  
                .setExplain(true) // so we get a NO decision back rather than an exception  
            state.getRoutingNodes().node(state.nodes().resolveNode(node_2).getId()).iterator().next().state(),
 * software distributed under the License is distributed on an
                    .cluster()
                Settings.builder()
        Settings commonSettings = Settings.builder()
import java.util.List;  
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), 1)
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
            .actionGet()
        assertThat(((MoveAllocationCommand) explanation.command()).fromNode(), equalTo(cmd.fromNode()));
        for (int i = 0; i < 25; i++) {
        healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("2").execute().actionGet();
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;  
        for (String blockSetting : Arrays.asList(  
        logger.info("--> starting a node");
                new MockLogAppender.UnseenEventExpectation(  
        client().admin()
        );
        client().admin()
        internalCluster().closeNonSharedNodes(false); // don't wipe data directories the index needs to be there!  
        }  
        );
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
    }  
        }
        ensureGreen(TimeValue.timeValueMinutes(1));
        assertThat(healthResponse.isTimedOut(), equalTo(false));  
                ClusterHealthResponse healthResponse = client().admin()
import org.opensearch.test.MockLogAppender;
            AllocationCommand yesDecisionAllocation = new AllocateEmptyPrimaryAllocationCommand(indexName, 0, nodeName1, true);
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),
/*  
                    Level.INFO,  
        internalCluster().startNode(commonSettings);
                    .add(new MoveAllocationCommand("test-blocks", 1, nodesIds.get(toggle % 2), nodesIds.get(++toggle % 2)))
        final Settings settings = Settings.builder()
}
            if (randomBoolean()) {  
        logger.info("--> get the state, verify shard 1 primary allocated");
        assertThat(cluster().size(), equalTo(1));
        assertThat(
            .add(new AllocateEmptyPrimaryAllocationCommand("test", 0, node_1, true))  
                        .prepareReroute()  
            .prepareReroute()
        logger.info("--> explicitly allocate shard 1, *under dry_run*");
        internalCluster().startNode(commonSettings);
            .cluster()  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        final String node_1 = nodesIds.get(0);
 * specific language governing permissions and limitations
            .getState();
            .execute()
        logger.info("--> create an index with 1 shard");
            .cluster()  
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
            equalTo(ShardRoutingState.STARTED)
        );  
            .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE.name())  
            try {
            assertAcked(client().admin().indices().prepareClose("test"));  
        client().admin()  
                    .prepareHealth()  
        );  
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("2").execute().actionGet();
        assertThat(explanation.command().name(), equalTo(cmd.name()));
    public void testClusterRerouteWithBlocks() {
            .actionGet()
import java.util.Arrays;
            );  
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;
public class ClusterRerouteIT extends OpenSearchIntegTestCase {
                    .cluster()
        } finally {  
            .actionGet();  
import static org.hamcrest.Matchers.hasSize;  
        logger.info("--> check that the shard is allocated");  
            assertThat(dryRunResponse.getExplanations().getYesDecisionMessages(), hasSize(1));
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();
            // during a dry run, messages exist but are not logged or exposed  
            );
            .execute()
            .setIndices("test")
        );
            setClusterReadOnly(true);
package org.opensearch.cluster.allocation;
        }  
        RoutingExplanations e = resp.getExplanations();
        assertThat(  
/*  
            .actionGet();  
        if (closed) {  
 * this work for additional information regarding copyright
import org.apache.logging.log4j.LogManager;
        state = client().admin()  
        final Index index = resolveIndex("test");
            .setExplain(randomBoolean())
        Settings commonSettings = Settings.builder()
                    client().admin()
        state = client().admin()
            )
            .cluster()  
                    .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), randomIntBetween(250, 1000) + "ms")  
            } finally {
            .build();  
        assertThat(healthResponse.isTimedOut(), equalTo(false));
                .add(noDecisionAllocation)
            .setWaitForEvents(Priority.LANGUID)
        state = client().admin()
            .actionGet();
import org.opensearch.cluster.routing.ShardRouting;
        Settings commonSettings = Settings.builder()  
        logger.info("--> starting 2 nodes");
 * license agreements. See the NOTICE file distributed with
        logger.info("--> retrieve the node where the shard is allocated");
        state = client().admin()
        }  
 */  
                disableIndexBlock("test-blocks", blockSetting);
        assertThat(healthResponse.isTimedOut(), equalTo(false));  
        assertThat(explanation.decisions().type(), equalTo(Decision.Type.YES));  
 * ownership. Elasticsearch licenses this file to you under  
    }
        healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("2").execute().actionGet();
        state = client().admin().cluster().prepareState().execute().actionGet().getState();  
    }  
        logger.info("--> starting nodes back, will not allocate the shard since it has no data, but the index will be there");  
            SETTING_READ_ONLY_ALLOW_DELETE
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
            .setExplain(randomBoolean())
        logger.info("--> explicitly allocate primary");
        );
            .getState();  
                    TransportClusterRerouteAction.class.getName(),
            equalTo(ShardRoutingState.STARTED)  
            .setExplain(randomBoolean())
                    .setWaitForYellowStatus()
            allocateMockLog.addExpectation(
            .indices()  
                .prepareReroute()
    public void testRerouteWithCommands_enableAllocationSettings() throws Exception {
        if (closed == false) {
                .prepareReroute()
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(), 1)  
            .prepareHealth()  
                    "allocated an empty primary*"
                )
        // In some case, the shards will be rebalanced back and forth, it seems like a very low probability bug.
        ensureGreen(TimeValue.timeValueMinutes(2), false);  
            .prepareCreate(indexName)
            client().admin().indices().prepareClose("test").get();
        // This might run slowly on older hardware
                        .add(new MoveAllocationCommand("test-blocks", 0, nodesIds.get(toggle % 2), nodesIds.get(++toggle % 2)))
        assertThat(healthResponse.isTimedOut(), equalTo(false));  
                new MockLogAppender.SeenEventExpectation(  
    }
            .add(new AllocateEmptyPrimaryAllocationCommand("test", 0, node_1, true))  
        final String node_2 = nodesIds.get(1);
            .getState();  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        );  
                )
    public void testRerouteWithAllocateLocalGateway_enableAllocationSettings() throws Exception {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;  
            .prepareReroute()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;  
        );
            equalTo(ShardRoutingState.INITIALIZING)
        try {
        assertThat(healthResponse.isTimedOut(), equalTo(false));  
import org.opensearch.cluster.routing.allocation.RoutingExplanations;  
        }
        Settings newSettings = Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name()).build();
            .getState();  
        RerouteExplanation explanation = e.explanations().get(0);
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING;
        String node_1 = internalCluster().startNode(commonSettings);
        );
            createIndex(
import org.opensearch.core.index.shard.ShardId;
            .setWaitForYellowStatus()  
            .prepareCreate("test")
        logger.info("--> get the state, verify shard 1 primary moved from node1 to node2");
            .put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name())
 * the Apache License, Version 2.0 (the "License"); you may
            .setExplain(randomBoolean())  
        try (MockLogAppender allocateMockLog = MockLogAppender.createForLoggers(actionLogger)) {
        DiscoveryNode node = state.nodes().resolveNode(shard.currentNodeId());
                    .setIndices("test-blocks")
            equalTo(ShardRoutingState.INITIALIZING)
                    "message for first allocate empty primary",
            equalTo(ShardRoutingState.INITIALIZING)  
            allocateMockLog.addExpectation(
        final String nodeName1 = internalCluster().startNode(settings);  
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("1").execute().actionGet();
        assertThat(
        String node_1 = internalCluster().startNode(commonSettings);
        assertThat(((MoveAllocationCommand) explanation.command()).shardId(), equalTo(cmd.shardId()));  
import org.opensearch.action.support.WriteRequest.RefreshPolicy;  
            .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
            .build();  
            .setDryRun(true)
        logger.info("--> get the state, verify shard 1 primary allocated");
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
        Settings commonSettings = Settings.builder().build();
import org.opensearch.action.support.ActiveShardCount;
        assertThat(  
            .prepareReroute()
 *
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("1").execute().actionGet();
        assertThat(
import org.opensearch.cluster.metadata.IndexMetadata;  
 * The OpenSearch Contributors require contributions made to  
            client().admin().cluster().prepareHealth().setIndices("test").setWaitForNodes("2").execute().actionGet().getStatus(),
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
        logger.info("--> get the state, verify shard 1 primary allocated");
        assertThat(cluster().size(), equalTo(2));  
            .setSettings(  
            .indices()  
            .actionGet();
            SETTING_READ_ONLY,  
import org.opensearch.common.unit.TimeValue;
            equalTo(ShardRoutingState.INITIALIZING)
        logger.info("--> deleting the shard data [{}] ", Arrays.toString(shardLocation));
            );
            .prepareHealth()
        );
                assertAcked(  
                enableIndexBlock("test-blocks", blockSetting);
import org.opensearch.cluster.routing.UnassignedInfo;
import org.opensearch.test.InternalTestCluster;
        assertThat(cluster().size(), equalTo(2));
        rerouteWithAllocateLocalGateway(commonSettings);  
                )
        logger.info("--> explicitly allocate shard 1, actually allocating, no dry run");
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
                    "no message for second allocate empty primary",  
        logger.info("--> create an index with 1 shard, 1 replica, nothing should allocate");
            assertThat(response.getExplanations().getYesDecisionMessages().get(0), containsString("allocated an empty primary"));
        // wait a bit for the cluster to realize that the shard is not there...  
        logger.info("--> starting 4 nodes");  
import org.opensearch.common.Priority;
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));  
        }
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(2));  
                    .execute()
                    Level.INFO,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.cluster.health.ClusterHealthStatus;
            .execute()
            .prepareReroute()
        // TODO can we get around this? the cluster is RED, so what do we wait for?
            .execute()
 * Unless required by applicable law or agreed to in writing,
            .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
        List<String> nodesIds = internalCluster().startNodes(2, commonSettings);  
 * Modifications Copyright OpenSearch Contributors. See
            }  
                .actionGet();
                    TransportClusterRerouteAction.class.getName(),
 *  
 * You may obtain a copy of the License at  
    private void rerouteWithAllocateLocalGateway(Settings commonSettings) throws Exception {  
        final boolean closed = randomBoolean();
        assertThat(
            .actionGet()
 */  
        // Rerouting shards is not blocked
            ClusterRerouteResponse dryRunResponse = client().admin()  
        state = client().admin().cluster().prepareState().execute().actionGet().getState();  
            dryRunMockLog.addExpectation(
        try (MockLogAppender dryRunMockLog = MockLogAppender.createForLoggers(actionLogger)) {
        logger.info("--> create an index with 1 shard, 1 replica, nothing should allocate");
    }
            .cluster()
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(2));
    public void testRerouteExplain() {
            );
                new MockLogAppender.UnseenEventExpectation(
            .add(new AllocateEmptyPrimaryAllocationCommand("test", 0, node_1, true))  
        ClusterHealthResponse healthResponse = client().admin()
 * compatible open source license.
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),  
import org.opensearch.cluster.ClusterState;
            .cluster()
 */
import org.opensearch.action.admin.cluster.reroute.TransportClusterRerouteAction;
            .indices()
        assertThat(((MoveAllocationCommand) explanation.command()).toNode(), equalTo(cmd.toNode()));
                .execute()  
            .actionGet()
            SETTING_BLOCKS_WRITE,
        }
import org.opensearch.common.util.io.IOUtils;
        logger.info("--> closing all nodes");  
            .setIndices("test")
        if (randomBoolean()) {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node_1));
            "test-blocks",
            ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
            client().prepareIndex("test").setId("1").setSource("field", "value").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            equalTo(ShardRoutingState.RELOCATING)
import org.apache.logging.log4j.Level;
        rerouteWithCommands(commonSettings);
            setClusterReadOnly(false);
        IOUtils.rm(shardLocation);
    private void rerouteWithCommands(Settings commonSettings) throws Exception {
                .execute()  
                    .actionGet();
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
            .add(new AllocateEmptyPrimaryAllocationCommand("test", 0, node_1, true))
        );  
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)  
    }
        createIndex(  
            .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name())
        healthResponse = client().admin()
                );
            AllocationCommand dryRunAllocation = new AllocateEmptyPrimaryAllocationCommand(indexName, 0, nodeName1, true);
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        assertThat(
            .setWaitForActiveShards(ActiveShardCount.NONE)  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
import org.apache.lucene.tests.util.LuceneTestCase;
        ClusterRerouteResponse resp = client().admin().cluster().prepareReroute().add(cmd).setExplain(true).execute().actionGet();
        if (randomBoolean()) {
        assertThat(healthResponse.isTimedOut(), equalTo(false));  
                .setDryRun(true)
            ClusterRerouteResponse response = client().admin()  
 * under the License.  
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),  
            .setWaitForEvents(Priority.LANGUID)
            .setSettings(Settings.builder().put("index.number_of_shards", 1))  
            .execute()
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        assertThat(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
            equalTo(ShardRoutingState.STARTED)
            .prepareHealth()  
        final String nodeToCheck = node_1;
            .prepareReroute()
 * GitHub history for details.
                .cluster()
        List<ShardRouting> shards = state.routingTable().allShards("test-blocks");  
/*
            .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
        ensureGreen("test");
        Path[] shardLocation = internalCluster().getInstance(NodeEnvironment.class, node_1).availableShardPaths(new ShardId(index, 0));
            state.getRoutingNodes().node(state.nodes().resolveNode(node_2).getId()).iterator().next().state(),
@LuceneTestCase.SuppressFileSystems(value = "WindowsFS")  
        assertThat(
                    TransportClusterRerouteAction.class.getName(),
    }  
            .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")  
            .execute()
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),  
        Settings commonSettings = Settings.builder()
            assertThat(clusterState.getRoutingNodes().node(nodeId).iterator().next().state(), equalTo(ShardRoutingState.STARTED));  
        assertThat(FileSystemUtils.exists(shardLocation), equalTo(true)); // verify again after cluster was shut down  
    }
        }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
                    "allocated an empty primary*" + nodeName1 + "*"
        ensureGreen("test-blocks");
            assertBlocked(  
            .execute()
            .setWaitForYellowStatus()
        // toggle is used to mve the shard from one node to another
            }
            SETTING_BLOCKS_METADATA,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String node_2 = internalCluster().startNode(commonSettings);  
        logger.info("--> try to move the shard from node1 to node2");
        node_1 = internalCluster().startNode(commonSettings);
        ShardRouting shard = shards.get(0);
        Settings commonSettings = Settings.builder()
import org.opensearch.cluster.routing.ShardRoutingState;  
                indexName,
import org.opensearch.common.settings.Settings;  
        }
    private final Logger logger = LogManager.getLogger(ClusterRerouteIT.class);  
        internalCluster().startNode(commonSettings);  
            AllocationCommand noDecisionAllocation = new AllocateEmptyPrimaryAllocationCommand("noexist", 1, nodeName2, true);
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        logger.info("--> move shard 1 primary from node1 to node2");
            assertThat(response.getExplanations().getYesDecisionMessages(), hasSize(1));  
                .add(yesDecisionAllocation)
            .setWaitForNoRelocatingShards(true)
            final String indexName = "test" + i;  
import org.opensearch.env.NodeEnvironment;  
            equalTo(ShardRoutingState.INITIALIZING)
            .execute()  
    public void testRerouteWithCommands_disableAllocationSettings() throws Exception {
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
        healthResponse = client().admin()
        logger.info("--> check that the index has 1 shard");
        createIndex(  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;  
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),  
        List<String> nodesIds = internalCluster().startNodes(2);  
            .setIndices("test")
            client().admin().indices().prepareClose("test").get();
        assertThat(shards, hasSize(1));
            .getState();  
        int toggle = nodesIds.indexOf(node.getName());  
            .execute()  
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
// testDelayWithALargeAmountOfShards does a lot of cluster state updates, and WindowsFS slows it down too much (#52000)
                .actionGet();
        logger.info("--> starting a second node");
        assertThat(cluster().size(), equalTo(4));  
            .setWaitForYellowStatus()  
                        .cluster()
        assertThat(healthResponse.isTimedOut(), equalTo(false));
            .setSettings(Settings.builder().put("index.number_of_shards", 1))
 * not use this file except in compliance with the License.
    public void testDelayWithALargeAmountOfShards() throws Exception {
import org.opensearch.cluster.routing.allocation.decider.Decision;
            .actionGet()
        assertThat(shard.assignedToNode(), equalTo(true));
                .add(dryRunAllocation)
            assertThat(dryRunResponse.getExplanations().getYesDecisionMessages().get(0), containsString("allocated an empty primary"));
        logger.info("--> disable allocation");
                    "allocated an empty primary*" + nodeName2 + "*"  
    }
            String nodeId = clusterState.nodes().resolveNode(nodeToCheck).getId();
        assertBusy(() -> {  
        logger.info("--> get the state, verify nothing changed because of the dry run");  
                .setExplain(randomBoolean())  
            .build();
 * Licensed to Elasticsearch under one or more contributor  
            assertAcked(client().admin().indices().prepareClose("test-blocks"));  
    }
        }
        rerouteWithAllocateLocalGateway(commonSettings);
        assertThat(cluster().size(), equalTo(2));
            SETTING_BLOCKS_READ,
            .setExplain(randomBoolean())
        assertThat(e.explanations().size(), equalTo(1));  
        MoveAllocationCommand cmd = new MoveAllocationCommand("test", 0, node_1, node_2);  
        assertThat(FileSystemUtils.exists(shardLocation), equalTo(true)); // make sure the data is there!
            .build();
 * this file be licensed under the Apache-2.0 license or a
            .build();
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(2));
            allocateMockLog.assertAllExpectationsMatched();
            .actionGet();
        logger.info("--> create an index with 1 shard and 0 replicas");
        // Rerouting shards is blocked when the cluster is read only  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import org.opensearch.core.index.Index;  
                assertThat(healthResponse.isTimedOut(), equalTo(false));  
import org.opensearch.cluster.node.DiscoveryNode;
        internalCluster().startNode(commonSettings);  
        state = client().admin()
        client().admin().cluster().prepareReroute().get();
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(newSettings).execute().actionGet();  
            dryRunMockLog.assertAllExpectationsMatched();
        assertThat(healthResponse.isTimedOut(), equalTo(false));  
import org.opensearch.core.util.FileSystemUtils;
            "test",
                    .build()
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.Allocation;  
            equalTo(ClusterHealthStatus.RED)
        String node_1 = internalCluster().startNode(commonSettings);
        assertNotNull(node);  
        Logger actionLogger = LogManager.getLogger(TransportClusterRerouteAction.class);
        )) {  
import org.opensearch.test.OpenSearchIntegTestCase;  
                Settings.builder()  
            .cluster()
            .prepareCreate("test")
    public void testRerouteWithAllocateLocalGateway_disableAllocationSettings() throws Exception {
    public void testMessageLogging() throws Exception {  
                client().admin()
        });
            .execute()
import java.nio.file.Path;
        logger.info("--> create indices");
            .execute()
        rerouteWithCommands(commonSettings);
                    Level.INFO,  
