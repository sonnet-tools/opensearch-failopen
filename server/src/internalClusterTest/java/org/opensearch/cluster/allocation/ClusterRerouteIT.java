            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        assertThat(((MoveAllocationCommand) explanation.command()).toNode(), equalTo(cmd.toNode()));
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(2));
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
            .add(new AllocateEmptyPrimaryAllocationCommand("test", 0, node_1, true))
        logger.info("--> create an index with 1 shard, 1 replica, nothing should allocate");
                .add(yesDecisionAllocation)
        logger.info("--> get the state, verify shard 1 primary allocated");
            assertThat(response.getExplanations().getYesDecisionMessages().get(0), containsString("allocated an empty primary"));
        }
            .execute()
            .prepareCreate("test")
import java.nio.file.Path;
            ClusterRerouteResponse dryRunResponse = client().admin()
                .setExplain(randomBoolean())
import org.opensearch.cluster.ClusterState;
 * You may obtain a copy of the License at
            .setWaitForActiveShards(ActiveShardCount.NONE)
                    .setWaitForYellowStatus()
        assertThat(e.explanations().size(), equalTo(1));
                .prepareReroute()
import static org.hamcrest.Matchers.containsString;
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
        rerouteWithCommands(commonSettings);
        }
import java.util.List;
            createIndex(
                new MockLogAppender.UnseenEventExpectation(
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            allocateMockLog.assertAllExpectationsMatched();
            .setWaitForEvents(Priority.LANGUID)
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        assertThat(healthResponse.isTimedOut(), equalTo(false));
            );
                assertThat(healthResponse.isTimedOut(), equalTo(false));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
            .setSettings(Settings.builder().put("index.number_of_shards", 1))
        logger.info("--> stopping node1");
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
            assertThat(clusterState.getRoutingNodes().node(nodeId).iterator().next().state(), equalTo(ShardRoutingState.STARTED));
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
            )
        node_1 = internalCluster().startNode(commonSettings);
            AllocationCommand yesDecisionAllocation = new AllocateEmptyPrimaryAllocationCommand(indexName, 0, nodeName1, true);
        Settings commonSettings = Settings.builder()
        ensureGreen(TimeValue.timeValueMinutes(2), false);
                    "allocated an empty primary*" + nodeName1 + "*"
            }
 * Modifications Copyright OpenSearch Contributors. See
    }
        }
        Settings commonSettings = Settings.builder()
        try (MockLogAppender allocateMockLog = MockLogAppender.createForLoggers(actionLogger)) {
            .cluster()
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("4").execute().actionGet();
            } finally {
        assertThat(explanation.decisions().type(), equalTo(Decision.Type.YES));
/*
        Logger actionLogger = LogManager.getLogger(TransportClusterRerouteAction.class);
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        rerouteWithAllocateLocalGateway(commonSettings);
            .add(new AllocateEmptyPrimaryAllocationCommand("test", 0, node_1, true))
            .build();
        healthResponse = client().admin()
public class ClusterRerouteIT extends OpenSearchIntegTestCase {
            .indices()
                new MockLogAppender.SeenEventExpectation(
                .cluster()
            .execute()
        logger.info("--> explicitly allocate shard 1, actually allocating, no dry run");
    public void testClusterRerouteWithBlocks() {
            .setSettings(Settings.builder().put("index.number_of_shards", 1))
}
            .actionGet()
        );
            dryRunMockLog.assertAllExpectationsMatched();
        Settings commonSettings = Settings.builder()
        }
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
                ClusterHealthResponse healthResponse = client().admin()
            equalTo(ShardRoutingState.INITIALIZING)
        if (randomBoolean()) {
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            .setWaitForEvents(Priority.LANGUID)
    public void testRerouteWithCommands_enableAllocationSettings() throws Exception {
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
            equalTo(ShardRoutingState.INITIALIZING)
            .setIndices("test")
                )
    public void testDelayWithALargeAmountOfShards() throws Exception {
        logger.info("--> get the state, verify nothing changed because of the dry run");
import static org.hamcrest.Matchers.equalTo;
            SETTING_BLOCKS_METADATA,
                );
            ClusterState clusterState = client().admin().cluster().prepareState().execute().actionGet().getState();
            .execute()
                    Level.INFO,
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
            .execute()
import org.opensearch.cluster.routing.UnassignedInfo;
            equalTo(ShardRoutingState.STARTED)
 */
        internalCluster().startNode(commonSettings);
            .execute()
            .actionGet()
        client().admin()
        createIndex(
    public void testMessageLogging() throws Exception {
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        createIndex(
        internalCluster().closeNonSharedNodes(false); // don't wipe data directories the index needs to be there!
            SETTING_BLOCKS_READ,
            .cluster()
        rerouteWithAllocateLocalGateway(commonSettings);
        List<ShardRouting> shards = state.routingTable().allShards("test-blocks");
    private final Logger logger = LogManager.getLogger(ClusterRerouteIT.class);
        assertThat(
 * Licensed to Elasticsearch under one or more contributor
        );
                    "allocated an empty primary*" + nodeName2 + "*"
        logger.info("--> check that the index has 1 shard");
        } finally {
        assertThat(cluster().size(), equalTo(1));
        if (randomBoolean()) {
                Settings.builder()
package org.opensearch.cluster.allocation;
            .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
        assertThat(shard.assignedToNode(), equalTo(true));
            .setWaitForYellowStatus()
            .setWaitForEvents(Priority.LANGUID)
            .prepareHealth()
                .actionGet();
import org.opensearch.test.MockLogAppender;
        )) {
                )
import java.util.Arrays;
        final String node_2 = nodesIds.get(1);
                    .execute()
import org.apache.logging.log4j.Logger;
                assertAcked(client().admin().indices().prepareClose(indexName));
import org.apache.lucene.tests.util.LuceneTestCase;
            SETTING_BLOCKS_WRITE,
    }
import org.opensearch.test.OpenSearchIntegTestCase;
            .prepareReroute()
            .prepareReroute()
import org.opensearch.cluster.routing.ShardRoutingState;
        IOUtils.rm(shardLocation);
                    .add(new MoveAllocationCommand("test-blocks", 1, nodesIds.get(toggle % 2), nodesIds.get(++toggle % 2)))
        logger.info("--> explicitly allocate shard 1, *under dry_run*");
import org.opensearch.test.InternalTestCluster;
import org.opensearch.core.util.FileSystemUtils;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
            .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name())
import org.opensearch.common.unit.TimeValue;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(
                        .cluster()
            .getState();
        // toggle is used to mve the shard from one node to another
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
            );
            .build();
            .put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name())
            .actionGet()
        if (closed == false) {
            .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
            .cluster()
        assertThat(
        try {
    public void testRerouteWithCommands_disableAllocationSettings() throws Exception {
            .indices()
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        final String nodeName2 = internalCluster().startNode(settings);
        }
            AllocationCommand dryRunAllocation = new AllocateEmptyPrimaryAllocationCommand(indexName, 0, nodeName1, true);
        assertThat(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
import org.opensearch.common.settings.Settings;
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),
            .put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name())
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
/*
            .execute()
/*
            .add(new MoveAllocationCommand("test", 0, node_1, node_2))
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),
            if (randomBoolean()) {
        logger.info("--> get the state, verify shard 1 primary allocated");
                enableIndexBlock("test-blocks", blockSetting);
                .add(noDecisionAllocation)
                    .build()
        RoutingExplanations e = resp.getExplanations();
        logger.info("--> starting a second node");
            assertThat(response.getExplanations().getYesDecisionMessages(), hasSize(1));
            .actionGet();
import org.opensearch.core.index.Index;
 * KIND, either express or implied.  See the License for the
import org.apache.logging.log4j.LogManager;
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        }
                )
        assertThat(cluster().size(), equalTo(1));
            allocateMockLog.addExpectation(
                    client().admin()
 */
        logger.info("--> create an index with 1 shard, 1 replica, nothing should allocate");
                .setExplain(true) // so we get a NO decision back rather than an exception
import org.opensearch.common.util.io.IOUtils;
        }
                    "no completed message logged on dry run",
        );
    }
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
        assertThat(
        healthResponse = client().admin()
            equalTo(ShardRoutingState.RELOCATING)
                .setDryRun(true)
        final String node_1 = nodesIds.get(0);
        logger.info("--> create an index with 1 shard");
        state = client().admin()
        });
            .build();
        final Index index = resolveIndex("test");
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),
        internalCluster().startNode(commonSettings);
                    Level.INFO,
            "test-blocks",
        state = client().admin()
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("1").execute().actionGet();
        logger.info("--> explicitly allocate shard 1, actually allocating, no dry run");
            .execute()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(node_1));
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;
        DiscoveryNode node = state.nodes().resolveNode(shard.currentNodeId());
        Settings commonSettings = Settings.builder().build();
        String node_1 = internalCluster().startNode(commonSettings);
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
 * Unless required by applicable law or agreed to in writing,
        final boolean closed = randomBoolean();
            .build();
        assertThat(cluster().size(), equalTo(2));
        assertThat(FileSystemUtils.exists(shardLocation), equalTo(true)); // verify again after cluster was shut down
        logger.info("--> try to move the shard from node1 to node2");
 * GitHub history for details.
        logger.info("--> retrieve the node where the shard is allocated");
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),
            .setWaitForNoRelocatingShards(true)
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(2));
        logger.info("--> starting nodes back, will not allocate the shard since it has no data, but the index will be there");
            .setSettings(
        assertThat(FileSystemUtils.exists(shardLocation), equalTo(true)); // make sure the data is there!
            .add(new AllocateEmptyPrimaryAllocationCommand("test", 0, node_1, true))
            .actionGet();
        );
            dryRunMockLog.addExpectation(
import org.opensearch.action.support.ActiveShardCount;
        assertThat(explanation.command().name(), equalTo(cmd.name()));
                    .setIndices("test-blocks")
            .execute()
import org.opensearch.cluster.health.ClusterHealthStatus;
            .cluster()
            .execute()
        RerouteExplanation explanation = e.explanations().get(0);
        logger.info("--> create an index with 1 shard and 0 replicas");
            .actionGet()
            .setExplain(randomBoolean())
            SETTING_READ_ONLY,
                .prepareReroute()
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
            .setWaitForYellowStatus()
    public void testRerouteWithAllocateLocalGateway_disableAllocationSettings() throws Exception {
            );
        ClusterState state = client().admin().cluster().prepareState().execute().actionGet().getState();
        assertThat(cluster().size(), equalTo(2));
            .build();
        assertThat(
            .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE.name())
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        logger.info("--> explicitly allocate primary");
            client().prepareIndex("test").setId("1").setSource("field", "value").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        );
        logger.info("--> check that the shard is allocated");
            .add(new AllocateEmptyPrimaryAllocationCommand("test", 0, node_1, true))
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
            .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
                    .actionGet();
        assertBusy(() -> {
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        logger.info("--> create indices");
        List<String> nodesIds = internalCluster().startNodes(2, commonSettings);
        logger.info("--> move shard 1 primary from node1 to node2");
 * this file be licensed under the Apache-2.0 license or a
        String node_1 = internalCluster().startNode(commonSettings);
            try {
            .setIndices("test")
        List<String> nodesIds = internalCluster().startNodes(2);
            final String indexName = "test" + i;
        logger.info("--> get the state, verify shard 1 primary allocated");
import org.opensearch.cluster.routing.ShardRouting;
            .getState();
        assertThat(((MoveAllocationCommand) explanation.command()).shardId(), equalTo(cmd.shardId()));
        // Rerouting shards is blocked when the cluster is read only
        // This might run slowly on older hardware
            setClusterReadOnly(false);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
        Path[] shardLocation = internalCluster().getInstance(NodeEnvironment.class, node_1).availableShardPaths(new ShardId(index, 0));
        assertThat(cluster().size(), equalTo(2));
        final String indexName = "test_index";
            .prepareCreate(indexName)
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("1").execute().actionGet();
        if (randomBoolean()) {
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),
        state = client().admin()
 *
        );
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        logger.info("--> closing all nodes");
            String nodeId = clusterState.nodes().resolveNode(nodeToCheck).getId();
        for (String blockSetting : Arrays.asList(
                        .add(new MoveAllocationCommand("test-blocks", 0, nodesIds.get(toggle % 2), nodesIds.get(++toggle % 2)))
                assertAcked(
// testDelayWithALargeAmountOfShards does a lot of cluster state updates, and WindowsFS slows it down too much (#52000)
            .setWaitForActiveShards(ActiveShardCount.NONE)
                indexName,
@LuceneTestCase.SuppressFileSystems(value = "WindowsFS")
        ClusterHealthResponse healthResponse = client().admin()
            assertThat(response.getExplanations().getYesDecisionMessages().get(0), containsString(nodeName1));
        assertThat(
        internalCluster().startNode(commonSettings);
                    TransportClusterRerouteAction.class.getName(),
                        .prepareReroute()
    }
import org.opensearch.core.index.shard.ShardId;
            .prepareReroute()
            .actionGet();
            .setIndices("test")
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), 1)
        rerouteWithCommands(commonSettings);
        logger.info("--> get the state, verify shard 1 primary moved from node1 to node2");
            assertThat(dryRunResponse.getExplanations().getYesDecisionMessages(), hasSize(1));
        );
        final String nodeName1 = internalCluster().startNode(settings);
        state = client().admin()
            .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
            "test",
        try (MockLogAppender dryRunMockLog = MockLogAppender.createForLoggers(actionLogger)) {
        final Settings settings = Settings.builder()
            .execute()
            equalTo(ShardRoutingState.INITIALIZING)
 * software distributed under the License is distributed on an
        }
                .cluster()
        logger.info("--> starting 2 nodes");
        // TODO can we get around this? the cluster is RED, so what do we wait for?
            allocateMockLog.addExpectation(
            .actionGet();
                    TransportClusterRerouteAction.class.getName(),
            .actionGet();
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),
            .execute()
import static org.hamcrest.Matchers.hasSize;
        assertThat(((MoveAllocationCommand) explanation.command()).fromNode(), equalTo(cmd.fromNode()));
                .execute()
            .prepareHealth()
            .cluster()
            .prepareHealth()
                    TransportClusterRerouteAction.class.getName(),
                disableIndexBlock("test-blocks", blockSetting);
            // during a dry run, messages exist but are not logged or exposed
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
            .prepareReroute()
                .execute()
 * this work for additional information regarding copyright
import org.opensearch.cluster.routing.allocation.decider.Decision;
                    .cluster()
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(), 1)
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
            .build();
            .setExplain(randomBoolean())
        // In some case, the shards will be rebalanced back and forth, it seems like a very low probability bug.
        );
    }
            .setExplain(randomBoolean())
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
                    Level.INFO,
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
                .actionGet();
 */
            setClusterReadOnly(true);
        );
        assertThat(healthResponse.isTimedOut(), equalTo(false));
            .setDryRun(true)
            assertThat(dryRunResponse.getExplanations().getYesDecisionMessages().get(0), containsString("allocated an empty primary"));
 *
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("2").execute().actionGet();
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
                Settings.builder()
                new MockLogAppender.UnseenEventExpectation(
                .add(dryRunAllocation)
            .setWaitForYellowStatus()
        healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("2").execute().actionGet();
 * the Apache License, Version 2.0 (the "License"); you may
            assertAcked(client().admin().indices().prepareClose("test-blocks"));
            state.getRoutingNodes().node(state.nodes().resolveNode(node_2).getId()).iterator().next().state(),
        client().admin().cluster().prepareReroute().get();
            equalTo(ShardRoutingState.STARTED)
    }
        // Rerouting shards is not blocked
            ClusterRerouteResponse response = client().admin()
        internalCluster().startNode(commonSettings);
            .indices()
        assertThat(shards, hasSize(1));
                    "message for first allocate empty primary",
 * specific language governing permissions and limitations
        client().admin()
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 2)
            }
        state = client().admin()
        logger.info("--> starting 4 nodes");
            );
                    "allocated an empty primary*"
        assertThat(cluster().size(), equalTo(4));
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        }
            .setWaitForActiveShards(ActiveShardCount.NONE)
            .actionGet();
                    "no message for second allocate empty primary",
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
            equalTo(ShardRoutingState.INITIALIZING)
 * The OpenSearch Contributors require contributions made to
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
            client().admin().indices().prepareClose("test").get();
            .prepareCreate("test")
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(2));
            SETTING_READ_ONLY_ALLOW_DELETE
        Settings newSettings = Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name()).build();
            .prepareReroute()
                client().admin()
            .cluster()
                    .prepareHealth()
    }
        ShardRouting shard = shards.get(0);
            );
        String node_2 = internalCluster().startNode(commonSettings);
            .getState();
        final String nodeToCheck = node_1;
        assertThat(
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.Allocation;
        logger.info("--> starting a node");
import org.opensearch.cluster.routing.allocation.RoutingExplanations;
    }
                    .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), randomIntBetween(250, 1000) + "ms")
        if (closed) {
        ClusterRerouteResponse resp = client().admin().cluster().prepareReroute().add(cmd).setExplain(true).execute().actionGet();
            .getState();
        assertThat(
                    .cluster()
 * ownership. Elasticsearch licenses this file to you under
            .cluster()
        assertThat(state.getRoutingNodes().unassigned().size(), equalTo(1));
import org.opensearch.action.admin.cluster.reroute.TransportClusterRerouteAction;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
 * compatible open source license.
        int toggle = nodesIds.indexOf(node.getName());
import org.opensearch.cluster.node.DiscoveryNode;
import org.apache.logging.log4j.Level;
            equalTo(ShardRoutingState.STARTED)
        MoveAllocationCommand cmd = new MoveAllocationCommand("test", 0, node_1, node_2);
        Settings commonSettings = Settings.builder()
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
import org.opensearch.cluster.metadata.IndexMetadata;
        healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("2").execute().actionGet();
            client().admin().cluster().prepareHealth().setIndices("test").setWaitForNodes("2").execute().actionGet().getStatus(),
    public void testRerouteWithAllocateLocalGateway_enableAllocationSettings() throws Exception {
    public void testRerouteExplain() {
 * not use this file except in compliance with the License.
        }
        Settings commonSettings = Settings.builder()
        logger.info("--> deleting the shard data [{}] ", Arrays.toString(shardLocation));
 * license agreements. See the NOTICE file distributed with
        ensureGreen("test");
            state.getRoutingNodes().node(state.nodes().resolveNode(node_1).getId()).iterator().next().state(),
            assertBlocked(
            equalTo(ShardRoutingState.INITIALIZING)
import org.opensearch.common.Priority;
            state.getRoutingNodes().node(state.nodes().resolveNode(node_2).getId()).iterator().next().state(),
    }
            .setExplain(randomBoolean())
            .cluster()
        client().admin()
        assertThat(
                    .prepareReroute()
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertThat(healthResponse.isTimedOut(), equalTo(false));
            .actionGet()
        );
        ensureGreen("test-blocks");
 * under the License.
 *
import org.opensearch.env.NodeEnvironment;
            client().admin().indices().prepareClose("test").get();
            .setExplain(randomBoolean())
        ensureGreen(TimeValue.timeValueMinutes(1));
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(newSettings).execute().actionGet();
            .getState();
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING;
                    .setWaitForNoRelocatingShards(true)
        String node_1 = internalCluster().startNode(commonSettings);
    private void rerouteWithCommands(Settings commonSettings) throws Exception {
        );
            equalTo(ClusterHealthStatus.RED)
            assertAcked(client().admin().indices().prepareClose("test"));
        for (int i = 0; i < 25; i++) {
        // wait a bit for the cluster to realize that the shard is not there...
    private void rerouteWithAllocateLocalGateway(Settings commonSettings) throws Exception {
        logger.info("--> disable allocation");
            AllocationCommand noDecisionAllocation = new AllocateEmptyPrimaryAllocationCommand("noexist", 1, nodeName2, true);
        assertNotNull(node);
        internalCluster().startNode(commonSettings);
