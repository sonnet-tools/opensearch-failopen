        Settings indexSettings = Settings.builder()
        assertThat(delay, equalTo(0L));
    public void testNodeLevelClusterDelayedAllocationSettingControlsNodeLeftDelay() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    .numberOfShards(randomIntBetween(1, 3))
import org.opensearch.cluster.ClusterState;
                    .build()
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.DANGLING_INDEX_IMPORTED));
            .routingTable(
    public void testFindNextDelayedAllocationUsesClusterDefault() {
            )
            .metadata(metadata)  
        clusterState = ClusterState.builder(clusterState)
        clusterState = allocation.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(false));  
     * The unassigned meta is kept when a shard goes to INITIALIZING, but cleared when it moves to STARTED.
    }
        Metadata metadata = Metadata.builder()
        assertThat(
        final Settings indexSettings = Settings.builder()  
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
    public void testFailedShard() {  
 */  
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))
        final long delta = randomBoolean() ? 0 : randomInt((int) expectMinDelaySettingsNanos - 1);  
                            UUIDs.randomBase64UUID(),  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
 * KIND, either express or implied.  See the License for the
    }
    public void testClusterRecovered() {
        ClusterState clusterState = createStartedClusterState(allocation, clusterSettings, Settings.EMPTY);  
            .metadata(metadata)
            baseTime,
        assertThat(delay, equalTo(totalDelayNanos));
        Metadata metadata = Metadata.builder()  
            UnassignedInfo.Reason.INDEX_CLOSED,
        // verify that NODE_LEAVE is the reason for meta
        );
                        )
    }  
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
        assertThat(
        clusterState = allocation.applyFailedShards(
    }
        assertThat(read.getReason(), equalTo(meta.getReason()));  
            .metadata(metadata)  
                IndexMetadata.builder("test")
     */
        // starting primaries
        final TimeValue nodeDelay = TimeValue.timeValueMillis(randomIntBetween(1, 200));  
        clusterState = ClusterState.builder(clusterState)
                            UUIDs.randomBase64UUID(),
            .put(
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;  
            .build();
        );
        }
        Metadata metadata = Metadata.builder()
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
                RoutingTable.builder()
import org.opensearch.repositories.IndexId;
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");  
        );  
        long delay = unassignedInfo.getRemainingDelay(baseTime, indexSettings, Settings.EMPTY);  
            .metadata(metadata)
                AllocationStatus.NO_ATTEMPT,  
        Metadata metadata = Metadata.builder()  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
    public void testFindNextDelayedAllocationUsesNodeLevelClusterDefault() {
package org.opensearch.cluster.routing;
    public void testRemainingDelayCalculation() throws Exception {
            UnassignedInfo.Reason.REROUTE_CANCELLED,
                    .settings(settings(Version.CURRENT))
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
            .metadata(metadata)
            )
 * The OpenSearch Contributors require contributions made to  
                    .numberOfReplicas(1)
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        delay = unassignedInfo.getRemainingDelay(baseTime + totalDelayNanos, indexSettings, Settings.EMPTY);
     * Verifies that delayed allocation calculation are correct.
        ClusterState clusterState = createStartedClusterState(allocation, clusterSettings, Settings.EMPTY);
        delay = unassignedInfo.getRemainingDelay(baseTime + totalDelayNanos + randomIntBetween(1, 20), indexSettings, Settings.EMPTY);
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
    }
        assertThat(  
        clusterState = ClusterState.builder(clusterState)  
        builder.addReplica();  
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), delayTest2))
            )  
        int failedAllocations = randomIntBetween(1, 100);
     */  
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getUnassignedTimeInMillis(),
            0,
        final TimeValue indexDelay = TimeValue.timeValueMillis(randomIntBetween(1, 200));
            AllocationStatus.NO_ATTEMPT,  
            .build();
    public void testClusterStateSettingOverridesNodeLevelClusterSettingForNodeLeftDelay() {
        assertThat(clusterState.getRoutingNodes().unassigned().iterator().next().unassignedInfo().isDelayed(), equalTo(false));  
            .routingTable(RoutingTable.builder().addAsFromCloseToOpen(metadata.index("test")).build())
                IndexMetadata.builder("test")
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))  
    }
            UnassignedInfo.Reason.INDEX_REOPENED,  
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
        }
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .persistentSettings(clusterSettings)  
/*  
            AllocationStatus.NO_ATTEMPT,
            )
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .build();
            equalTo(UnassignedInfo.Reason.REPLICA_ADDED)
            )
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            .put(
            .put(
import java.io.IOException;  
    }
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        final long expectMinDelaySettingsNanos = Math.min(delayTest1.nanos(), delayTest2.nanos());  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // starting primaries
    }
            .build();  
        Metadata metadata = Metadata.builder()
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo(), notNullValue());  
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getDetails(),
        clusterState = allocation.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                    .numberOfReplicas(randomIntBetween(0, 3))
                    .numberOfShards(randomIntBetween(1, 3))
            .build();
        final TimeValue clusterDelay = TimeValue.timeValueMillis(randomIntBetween(1, 200));  
        // remove node2 and reroute
                            Version.CURRENT,  
            .build();  
                    .numberOfReplicas(1)
        Settings clusterSettings = Settings.builder()  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))  
            Collections.emptySet()
        clusterState = allocation.reroute(clusterState, "reroute");
            .metadata(metadata)
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        assertThat(  
            null,
    }  
        }  
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getReason(),
    public void testFindNextDelayedAllocation() {
            Collections.emptySet()  
                System.currentTimeMillis(),
        ShardRouting shard = TestShardRouting.newShardRouting(
                failedAllocations,
        assertThat(  
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))
            .build();
        );
        clusterState = ClusterState.builder(clusterState)  
    public void testReasonOrdinalOrder() {
        // starting primaries
            equalTo(UnassignedInfo.Reason.ALLOCATION_FAILED)  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            ShardRoutingState.UNASSIGNED,
 *
        );
        assertThat(UnassignedInfo.getNodeLeftDelayedTimeout(Settings.EMPTY, clusterSettings), equalTo(clusterDelay));
     * Tests that during reroute when a node is detected as leaving the cluster, the right unassigned meta is set
            .build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                    .addAsNewRestore(  
        Settings clusterSettings = Settings.builder()  
            equalTo("failed shard on node [" + shardToFail.currentNodeId() + "]: test fail")
        allocation.setNanoTimeOverride(baseTime);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                            new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID())),
        assertThat(shard.state(), equalTo(ShardRoutingState.STARTED));  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
                    .settings(settings(Version.CURRENT))  
            .build();
            baseTime,  
import static org.hamcrest.Matchers.equalTo;
            allocation.setNanoTimeOverride(baseTime + delta);  
            .build();
            .build();
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                    .numberOfReplicas(randomIntBetween(0, 3))
                    .numberOfShards(randomIntBetween(1, 3))
            .build();
        );  
            System.currentTimeMillis(),
                            new IndexId("test", UUIDs.randomBase64UUID(random()))  
        clusterState = ClusterState.builder(clusterState)
                        metadata.index("test"),
 * Licensed to Elasticsearch under one or more contributor  
                randomBoolean() ? randomAlphaOfLength(4) : null,  
        assertThat(UnassignedInfo.Reason.values().length, equalTo(order.length));  
        final Settings clusterSettings = Settings.builder()
            .routingTable(
        clusterState = allocation.reroute(clusterState, "reroute");
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
/*
    private ClusterState createStartedClusterState(MockAllocationService allocation, Settings clusterSettings, Settings indexSettings) {
        ShardRouting shardToFail = clusterState.getRoutingNodes().shardsWithState(STARTED).get(0);
        assertThat(UnassignedInfo.getNumberOfDelayedUnassigned(clusterState), equalTo(0));  
        final long baseTime = System.nanoTime();
        Metadata metadata = Metadata.builder()
        assertThat(clusterState.toString(), UnassignedInfo.getNumberOfDelayedUnassigned(clusterState), equalTo(2));
    }  
            .build();  
 * specific language governing permissions and limitations
            0,
        Settings nodeSettings = Settings.builder()  
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
                    .numberOfShards(1)  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import java.nio.ByteBuffer;
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));
            assertThat(order[i].ordinal(), equalTo(i));
        shard = shard.initialize("test_node", null, -1);
        for (int i = 0; i < order.length; i++) {  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        );
import org.opensearch.common.UUIDs;
        );  
        assertThat(UnassignedInfo.getNumberOfDelayedUnassigned(clusterState), equalTo(0));  
        UnassignedInfo unassignedInfo = new UnassignedInfo(  
            UnassignedInfo.Reason.FORCED_EMPTY_PRIMARY,
        // remove node2 and reroute  
        delay = unassignedInfo.getRemainingDelay(baseTime + delta1, indexSettings, Settings.EMPTY);  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        final Settings indexSettings = Settings.builder()  
import java.util.stream.Collectors;
        Settings nodeSettings = Settings.builder()
            )  
import org.opensearch.cluster.metadata.Metadata;
            clusterState = allocation.reroute(clusterState, "time moved");
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueNanos(totalDelayNanos))
            .build();  
        AllocationService allocation = createAllocationService();
            )
import org.opensearch.common.settings.Settings;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
    }
        // verify the reason and details  
        clusterState = allocation.reroute(clusterState, "reroute");  
import static org.hamcrest.Matchers.nullValue;
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
 * license agreements. See the NOTICE file distributed with
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getMessage(),  
 * software distributed under the License is distributed on an
            AllocationStatus readStatus = AllocationStatus.readFrom(in);
        Settings nodeSettings = Settings.builder()
        final long baseTime = System.nanoTime();
        allocation.setNanoTimeOverride(baseTime);
        MockAllocationService allocation = createAllocationService(nodeSettings, new DelayedShardsMockGatewayAllocator());
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo(), notNullValue());
                    .settings(settings(Version.CURRENT))
            .build();  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .build();
        UnassignedInfo meta = reason == UnassignedInfo.Reason.ALLOCATION_FAILED  
        Metadata metadata = Metadata.builder()  
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
                        new HashSet<>()
        final TimeValue clusterDelay = TimeValue.timeValueMillis(randomIntBetween(1, 200));  
        assertThat(read.getMessage(), equalTo(meta.getMessage()));
        AllocationService allocation = createAllocationService();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                System.nanoTime(),  
            "test",
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();  
        final Settings nodeSettings = Settings.builder()
    public void testNumberOfDelayedUnassigned() throws Exception {
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
     */  
        final Index index = metadata.index("test").getIndex();
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import org.opensearch.common.unit.TimeValue;
    public void testClusterDelayedAllocationSettingControlsNodeLeftDelay() {
            greaterThan(0L)  
                        metadata.index("test"),
            .build();
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.INDEX_CREATED));
import org.opensearch.cluster.routing.allocation.FailedShard;
            .routingTable(RoutingTable.builder().addAsNew(metadata.index(index)).build())
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
    /**
        final Settings clusterSettings = Settings.builder()
        Metadata metadata = Metadata.builder()
            Collections.singletonList(new FailedShard(shardToFail, "test fail", null, randomBoolean()))
            "test",  
            equalTo(expectMinDelaySettingsNanos - delta)  
        Metadata metadata = Metadata.builder()  
            equalTo(clusterDelay.nanos())  
        UnassignedInfo read = new UnassignedInfo(out.bytes().streamInput());
import org.opensearch.core.index.Index;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();  
    }
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), nodeDelay)
        final Settings clusterSettings = Settings.builder()  
import java.util.HashSet;  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
                    .build()
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), clusterDelay)
        }  
        final long baseTime = System.nanoTime();
        assertThat(shard.unassignedInfo(), notNullValue());
            UnassignedInfo.Reason.INDEX_CREATED,
            .metadata(metadata)  
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(false));
            .put(  
            .build();  
        // starting replicas  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
    public void testIndexDelayedAllocationSettingOverridesClusterSettingForNodeLeftDelay() {  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        clusterState = allocation.reroute(clusterState, "reroute");  
    public void testDanglingIndexImported() {  
            .build();
            .build();
            .build();
        UnassignedInfo.Reason reason = RandomPicks.randomFrom(random(), UnassignedInfo.Reason.values());
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), delayTest1))
                    .numberOfReplicas(randomIntBetween(0, 3))  
            )  
            .build();
        for (IndexShardRoutingTable indexShardRoutingTable : clusterState.routingTable().index(index)) {  
            .routingTable(RoutingTable.builder().addAsFromDangling(metadata.index("test")).build())
                    .numberOfShards(1)  
 * Unless required by applicable law or agreed to in writing,
    }
                    .numberOfReplicas(randomIntBetween(0, 3))
            .build();  
 *  
    public void testIndexDelayedAllocationSettingOverridesClusterDefault() {  
                        ),
        clusterState = ClusterState.builder(clusterState)
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getReason(),  
            null,  
        Metadata metadata = Metadata.builder()  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            UnassignedInfo.Reason.CLUSTER_RECOVERED,
        assertThat(read.getNumFailedAllocations(), equalTo(meta.getNumFailedAllocations()));
        AllocationService allocation = createAllocationService();
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))  
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));
        assertThat(
            builder.addIndexShard(indexShardRoutingTable);
            .build();
 * ownership. Elasticsearch licenses this file to you under  
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
    }
        assertThat(shard.unassignedInfo(), notNullValue());
        allocation.setNanoTimeOverride(baseTime);  
            true,
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build())  
    public void testNewIndexRestored() {
        MockAllocationService allocation = createAllocationService(nodeSettings, new DelayedShardsMockGatewayAllocator());
            "test",
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.CLUSTER_RECOVERED));
        }  
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), indexDelay)
            UnassignedInfo.findNextDelayedAllocation(baseTime + delta, clusterState, clusterState.metadata().settings()),
}
            .build();
                    .numberOfShards(randomIntBetween(1, 3))
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getReason(),
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
            UnassignedInfo.Reason.CHILD_SHARD_CREATED, };
    public void testReplicaAdded() {  
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
public class UnassignedInfoTests extends OpenSearchAllocationTestCase {  
        clusterState = allocation.reroute(clusterState, "reroute");
        );
            .routingTable(RoutingTable.builder().addAsRecovery(metadata.index("test")).build())
            .put(
    public void testAllocationStatusSerialization() throws IOException {  
        ClusterState clusterState = createStartedClusterState(allocation, clusterSettings, Settings.EMPTY);  
import org.opensearch.cluster.ClusterName;
            allocationStatus.writeTo(out);  
 */  
        final long baseTime = System.nanoTime();  
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(false));
        assertThat(clusterState.getRoutingNodes().unassigned().iterator().next().unassignedInfo().isDelayed(), equalTo(false));
            .persistentSettings(clusterSettings)  
        MockAllocationService allocation = createAllocationService(nodeSettings, new DelayedShardsMockGatewayAllocator());  
            UnassignedInfo.Reason.NODE_LEFT,
            .build();  
            null,
                    .settings(settings(Version.CURRENT))  
            .build();
        Metadata metadata = Metadata.builder()
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(index);
        meta.writeTo(out);
 * not use this file except in compliance with the License.
        final TimeValue clusterDelay = TimeValue.timeValueMillis(randomIntBetween(201, 400));
 * Modifications Copyright OpenSearch Contributors. See
        ClusterState clusterState = createStartedClusterState(allocation, clusterSettings, indexSettings);
import org.opensearch.cluster.metadata.IndexMetadata;
            : new UnassignedInfo(reason, randomBoolean() ? randomAlphaOfLength(4) : null);  
                            new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID())),
        );
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
            equalTo("failed shard on node [" + shardToFail.currentNodeId() + "]: test fail")
                    )  
                reason,
                    .numberOfShards(randomIntBetween(1, 3))
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(true));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }
 * You may obtain a copy of the License at  
            .metadata(metadata)
            .build();  
 * this work for additional information regarding copyright
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .build();  
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.NEW_INDEX_RESTORED));
                IndexMetadata.builder("test")
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        // starting replicas
    }  
    public void testNodeLeave() {
        for (AllocationStatus allocationStatus : AllocationStatus.values()) {
    }
    public void testClusterStateSettingOverridesNodeLevelClusterSettingWithNoDelayForNodeLeftDelay() {
     * Verifies that when a shard fails, reason is properly set and details are preserved.
        // fail shard  
        long delta1 = randomIntBetween(1, (int) (totalDelayNanos - 1));
                RoutingTable.builder()  
            .build();
        assertThat(
        );
        return startInitializingShardsAndReroute(allocation, clusterState);  
    /**  
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
        clusterState = ClusterState.builder(clusterState)
        final long totalDelayNanos = TimeValue.timeValueMillis(10).nanos();
            clusterState,  
                    .numberOfReplicas(randomIntBetween(0, 3))  
    /**  
            .metadata(metadata)
            .build();  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
 *
        // starting primaries  
            .build();
        ClusterState clusterState = createStartedClusterState(allocation, Settings.EMPTY, Settings.EMPTY);
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");  
            .build();  
            UnassignedInfo.Reason.NODE_LEFT,
                IndexMetadata.builder("test")
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(read.getUnassignedTimeInMillis(), equalTo(meta.getUnassignedTimeInMillis()));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        assertThat(read.getFailedNodeIds(), equalTo(meta.getFailedNodeIds()));
        }
            UnassignedInfo.Reason.REPLICA_ADDED,
            UnassignedInfo.Reason.EXISTING_INDEX_RESTORED,  
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))  
    public void testExistingIndexRestored() {  
    /**
                failedNodes
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;
            UnassignedInfo.Reason.DANGLING_INDEX_IMPORTED,
    public void testIndexCreated() {
import java.util.stream.IntStream;  
            randomBoolean(),
        // starting replicas  
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {  
    }
        assertThat(delay, equalTo(totalDelayNanos - delta1));
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo(), notNullValue());
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        UnassignedInfo.Reason[] order = new UnassignedInfo.Reason[] {  
            .build();
import java.util.Collections;
            .build();
    }
        assertThat(UnassignedInfo.getNodeLeftDelayedTimeout(indexSettings, clusterSettings), equalTo(indexDelay));
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(false));
        clusterState = allocation.reroute(clusterState, "reroute");
        final TimeValue delayTest2 = TimeValue.timeValueMillis(randomIntBetween(1, 200));
            BytesStreamOutput out = new BytesStreamOutput();
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getUnassignedTimeInMillis(),
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build())  
        UnassignedInfo unassignedInfo = new UnassignedInfo(
                    .numberOfReplicas(randomIntBetween(0, 3))
        // make sure both replicas are marked as delayed (i.e. not reallocated)
        final TimeValue delayTest1 = TimeValue.timeValueMillis(randomIntBetween(1, 200));
            .build();
    public void testRemainingDelayUsesClusterDefaultWhenIndexSettingIsMissing() {
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
import org.opensearch.snapshots.Snapshot;  
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
            .build();
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");  
            UnassignedInfo.Reason.NODE_LEFT,  
        );
        }
 * compatible open source license.
        assertThat(
        assertThat(unassignedInfo.getRemainingDelay(baseTime, Settings.EMPTY, clusterSettings), equalTo(clusterDelay.nanos()));  
        assertThat(shard.state(), equalTo(ShardRoutingState.INITIALIZING));  
            .build();
                            Version.CURRENT,
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        }
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        // starting primaries
            .put(
    public void testStateTransitionMetaHandling() {  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                IndexMetadata.builder("test")  
            assertThat(readStatus, equalTo(allocationStatus));  
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))
        assertThat(
        shard = shard.moveToStarted();
    }  
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), clusterDelay)
        // remove node2 and reroute  
        );  
        assertThat(UnassignedInfo.findNextDelayedAllocation(baseTime, clusterState, nodeSettings), equalTo(nodeDelay.nanos()));  
        }
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");  
            .build();
    }
        Settings clusterSettings = Settings.builder()
 * under the License.  
        assertThat(read.getDetails(), equalTo(meta.getDetails()));  
    public void testIndexReopened() {
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();  
            .build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }  
            ByteBufferStreamInput in = new ByteBufferStreamInput(ByteBuffer.wrap(out.bytes().toBytesRef().bytes));
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
import static org.hamcrest.Matchers.greaterThan;
            true,  
            .metadata(metadata)  
        assertThat(shard.unassignedInfo(), nullValue());
            .build();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))
/*  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
    public void testSerialization() throws Exception {  
            null,
            .metadata(metadata)
                IndexMetadata.builder("test")  
        Settings clusterSettings = Settings.builder()
        Metadata metadata = Metadata.builder()
                IndexMetadata.builder("test2")
            UnassignedInfo.Reason.REINITIALIZED,
 */
            greaterThan(0L)
            ? new UnassignedInfo(
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
                        new SnapshotRecoverySource(
            .build();  
            .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().unassigned().iterator().next().unassignedInfo().isDelayed(), equalTo(true));
        assertThat(clusterState.getRoutingNodes().unassigned().iterator().next().unassignedInfo().isDelayed(), equalTo(true));
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT).put(indexSettings)).numberOfShards(1).numberOfReplicas(1))
        assertThat(clusterState.getRoutingNodes().unassigned().iterator().next().unassignedInfo().isDelayed(), equalTo(false));  
                false,
 * this file be licensed under the Apache-2.0 license or a
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
    }  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        // starting replicas  
            System.currentTimeMillis(),  
            )  
        out.close();  
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), clusterDelay)
            .mapToObj(n -> "failed-node-" + n)
    }
            .collect(Collectors.toSet());
                    )  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
            .put(  
    }
import org.opensearch.cluster.node.DiscoveryNodes;  
                    .settings(settings(Version.CURRENT))  
            .metadata(metadata)  
                    .numberOfShards(randomIntBetween(1, 3))
import org.opensearch.snapshots.SnapshotId;
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {  
        final long baseTime = System.nanoTime();
                    .addAsRestore(
            UnassignedInfo.Reason.REALLOCATED_REPLICA,  
                IndexMetadata.builder("test1")
            UnassignedInfo.findNextDelayedAllocation(baseTime, clusterState, clusterState.metadata().settings()),
            .build();  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 * GitHub history for details.
import org.opensearch.cluster.routing.allocation.AllocationService;  
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));  
        }
        assertThat(delay, equalTo(0L));  
    }
            .routingTable(RoutingTable.builder(clusterState.routingTable()).add(builder).build())
     */
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
            UnassignedInfo.Reason.MANUAL_ALLOCATION,  
        Metadata metadata = Metadata.builder()  
            UnassignedInfo.Reason.NEW_INDEX_RESTORED,
                null,
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
            .build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(
import org.opensearch.Version;  
            .build();
import org.opensearch.common.io.stream.BytesStreamOutput;  
            .build();  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
 * the Apache License, Version 2.0 (the "License"); you may
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
            .build();
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            UnassignedInfo.Reason.PRIMARY_FAILED,
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))  
                        new SnapshotRecoverySource(  
            )
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.INDEX_REOPENED));
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.EXISTING_INDEX_RESTORED));
            .build();
            UnassignedInfo.Reason.ALLOCATION_FAILED,
            .build();
            1,  
            .build();  
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(true));
            )
                    .settings(settings(Version.CURRENT))  
                            new IndexId("test", UUIDs.randomBase64UUID(random()))
        Set<String> failedNodes = IntStream.range(0, between(0, failedAllocations))  
import static org.hamcrest.Matchers.notNullValue;  
            .metadata(metadata)  
        if (delta > 0) {
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));  
            equalTo(UnassignedInfo.Reason.NODE_LEFT)
