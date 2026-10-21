            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        clusterState = allocation.reroute(clusterState, "reroute");
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
    }
            .build();
    }
            UnassignedInfo.Reason.REINITIALIZED,
            .build();
            .put(
        final Settings indexSettings = Settings.builder()
            .routingTable(RoutingTable.builder(clusterState.routingTable()).add(builder).build())
        assertThat(clusterState.getRoutingNodes().unassigned().iterator().next().unassignedInfo().isDelayed(), equalTo(false));
            .build();
            )
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        Settings clusterSettings = Settings.builder()
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getMessage(),
import org.opensearch.cluster.ClusterName;
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))
                    .numberOfReplicas(randomIntBetween(0, 3))
            .build();
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
            .build();
            .build();
}
        clusterState = ClusterState.builder(clusterState)
        );
                        metadata.index("test"),
/*
            .put(
        // starting replicas
        assertThat(UnassignedInfo.findNextDelayedAllocation(baseTime, clusterState, nodeSettings), equalTo(nodeDelay.nanos()));
            UnassignedInfo.Reason.PRIMARY_FAILED,
                    .settings(settings(Version.CURRENT))
        final long baseTime = System.nanoTime();
 * software distributed under the License is distributed on an
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }
        assertThat(
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
        assertThat(shard.state(), equalTo(ShardRoutingState.STARTED));
        }
            .put(
            null,
        // verify the reason and details
            true,
            .build();
                            Version.CURRENT,
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.INDEX_REOPENED));
        long delay = unassignedInfo.getRemainingDelay(baseTime, indexSettings, Settings.EMPTY);
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
            .build();
        );
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
import org.opensearch.cluster.ClusterState;
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.INDEX_CREATED));
        assertThat(delay, equalTo(0L));
            allocation.setNanoTimeOverride(baseTime + delta);
        // starting replicas
        Metadata metadata = Metadata.builder()
        UnassignedInfo.Reason reason = RandomPicks.randomFrom(random(), UnassignedInfo.Reason.values());
     */
            .collect(Collectors.toSet());
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(read.getUnassignedTimeInMillis(), equalTo(meta.getUnassignedTimeInMillis()));
 * license agreements. See the NOTICE file distributed with
    }
    }
        );
        );
    }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
        Metadata metadata = Metadata.builder()
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
    }
        if (delta > 0) {
            System.currentTimeMillis(),
            ? new UnassignedInfo(
            )
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import java.nio.ByteBuffer;
import static org.hamcrest.Matchers.notNullValue;
    /**
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        assertThat(read.getMessage(), equalTo(meta.getMessage()));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
 *
            .build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        AllocationService allocation = createAllocationService();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
    public void testIndexDelayedAllocationSettingOverridesClusterSettingForNodeLeftDelay() {
            clusterState = allocation.reroute(clusterState, "time moved");
            .metadata(metadata)
public class UnassignedInfoTests extends OpenSearchAllocationTestCase {
            UnassignedInfo.Reason.REPLICA_ADDED,
            .build();
import java.util.stream.Collectors;
        ShardRouting shardToFail = clusterState.getRoutingNodes().shardsWithState(STARTED).get(0);
            greaterThan(0L)
            equalTo(expectMinDelaySettingsNanos - delta)
                    .settings(settings(Version.CURRENT))
            .routingTable(RoutingTable.builder().addAsNew(metadata.index(index)).build())
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.NEW_INDEX_RESTORED));
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
            .build();
        clusterState = allocation.reroute(clusterState, "reroute");
 * this file be licensed under the Apache-2.0 license or a
            UnassignedInfo.Reason.REROUTE_CANCELLED,
            Collections.singletonList(new FailedShard(shardToFail, "test fail", null, randomBoolean()))
        ClusterState clusterState = createStartedClusterState(allocation, Settings.EMPTY, Settings.EMPTY);
        clusterState = allocation.applyFailedShards(
        Settings nodeSettings = Settings.builder()
            .routingTable(RoutingTable.builder().addAsFromCloseToOpen(metadata.index("test")).build())
import org.opensearch.repositories.IndexId;
import static org.hamcrest.Matchers.nullValue;
            .metadata(metadata)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        assertThat(shard.unassignedInfo(), notNullValue());
        delay = unassignedInfo.getRemainingDelay(baseTime + totalDelayNanos, indexSettings, Settings.EMPTY);
        assertThat(UnassignedInfo.Reason.values().length, equalTo(order.length));
        clusterState = ClusterState.builder(clusterState)
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
    }
                RoutingTable.builder()
            .build();
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
            .build();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        builder.addReplica();
            .put(
                        )
import java.util.stream.IntStream;
import static org.hamcrest.Matchers.equalTo;
            : new UnassignedInfo(reason, randomBoolean() ? randomAlphaOfLength(4) : null);
        assertThat(read.getDetails(), equalTo(meta.getDetails()));
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
                    .settings(settings(Version.CURRENT))
        }
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(index);
import org.opensearch.common.UUIDs;
    }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), clusterDelay)
            UnassignedInfo.findNextDelayedAllocation(baseTime + delta, clusterState, clusterState.metadata().settings()),
            )
        allocation.setNanoTimeOverride(baseTime);
                            new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID())),
            equalTo(UnassignedInfo.Reason.REPLICA_ADDED)
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))
            AllocationStatus readStatus = AllocationStatus.readFrom(in);
        final long baseTime = System.nanoTime();
                RoutingTable.builder()
    }
        final TimeValue clusterDelay = TimeValue.timeValueMillis(randomIntBetween(1, 200));
            .build();
        MockAllocationService allocation = createAllocationService(nodeSettings, new DelayedShardsMockGatewayAllocator());
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
            .build();
            UnassignedInfo.findNextDelayedAllocation(baseTime, clusterState, clusterState.metadata().settings()),
            ShardRoutingState.UNASSIGNED,
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))
        // remove node2 and reroute
        final TimeValue delayTest2 = TimeValue.timeValueMillis(randomIntBetween(1, 200));
                            UUIDs.randomBase64UUID(),
            UnassignedInfo.Reason.NODE_LEFT,
        Metadata metadata = Metadata.builder()
    private ClusterState createStartedClusterState(MockAllocationService allocation, Settings clusterSettings, Settings indexSettings) {
        Settings clusterSettings = Settings.builder()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .build();
/*
            UnassignedInfo.Reason.CLUSTER_RECOVERED,
        UnassignedInfo read = new UnassignedInfo(out.bytes().streamInput());
            UnassignedInfo.Reason.EXISTING_INDEX_RESTORED,
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
            .put(
            AllocationStatus.NO_ATTEMPT,
                IndexMetadata.builder("test")
        }
                        ),
        }
            0,
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
                IndexMetadata.builder("test1")
        final TimeValue nodeDelay = TimeValue.timeValueMillis(randomIntBetween(1, 200));
        }
        // verify that NODE_LEAVE is the reason for meta
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.CLUSTER_RECOVERED));
            .build();
        );
    }
                    .numberOfReplicas(1)
        // starting primaries
import org.opensearch.cluster.routing.allocation.FailedShard;
            null,
        assertThat(UnassignedInfo.getNumberOfDelayedUnassigned(clusterState), equalTo(0));
            equalTo("failed shard on node [" + shardToFail.currentNodeId() + "]: test fail")
        assertThat(clusterState.toString(), UnassignedInfo.getNumberOfDelayedUnassigned(clusterState), equalTo(2));
                    )
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .build();
            .routingTable(RoutingTable.builder().addAsFromDangling(metadata.index("test")).build())
    }
            .routingTable(
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), clusterDelay)
        // starting primaries
            )
                            Version.CURRENT,
        assertThat(
        ClusterState clusterState = createStartedClusterState(allocation, clusterSettings, Settings.EMPTY);
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
import org.opensearch.snapshots.Snapshot;
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueNanos(totalDelayNanos))
        Settings clusterSettings = Settings.builder()
    public void testNewIndexRestored() {
    public void testRemainingDelayUsesClusterDefaultWhenIndexSettingIsMissing() {
            randomBoolean(),
    public void testReplicaAdded() {
import java.util.HashSet;
                IndexMetadata.builder("test")
        clusterState = ClusterState.builder(clusterState)
            .metadata(metadata)
 * KIND, either express or implied.  See the License for the
                false,
 *
                    .numberOfShards(randomIntBetween(1, 3))
                failedNodes
    public void testIndexReopened() {
import org.opensearch.common.io.stream.BytesStreamOutput;
            .persistentSettings(clusterSettings)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            .build();
        Settings clusterSettings = Settings.builder()
    public void testNodeLeave() {
                            new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID())),
        AllocationService allocation = createAllocationService();
        MockAllocationService allocation = createAllocationService(nodeSettings, new DelayedShardsMockGatewayAllocator());
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(false));
    public void testFindNextDelayedAllocation() {
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(false));
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));
        final Settings clusterSettings = Settings.builder()
        meta.writeTo(out);
        clusterState = ClusterState.builder(clusterState)
            )
        assertThat(UnassignedInfo.getNodeLeftDelayedTimeout(indexSettings, clusterSettings), equalTo(indexDelay));
 *
                    .numberOfReplicas(randomIntBetween(0, 3))
        // fail shard
        }
                        new SnapshotRecoverySource(
    /**
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            )
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build())
            equalTo(UnassignedInfo.Reason.NODE_LEFT)
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
            .build();
            allocationStatus.writeTo(out);
import org.opensearch.core.index.Index;
            UnassignedInfo.Reason.NEW_INDEX_RESTORED,
            .put(
            Collections.emptySet()
    }
                IndexMetadata.builder("test")
            UnassignedInfo.Reason.REALLOCATED_REPLICA,
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;
        delay = unassignedInfo.getRemainingDelay(baseTime + delta1, indexSettings, Settings.EMPTY);
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
                failedAllocations,
    }
                        metadata.index("test"),
        assertThat(UnassignedInfo.getNumberOfDelayedUnassigned(clusterState), equalTo(0));
 * GitHub history for details.
            .build();
            System.currentTimeMillis(),
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
 * not use this file except in compliance with the License.
    public void testClusterStateSettingOverridesNodeLevelClusterSettingWithNoDelayForNodeLeftDelay() {
        }
        for (int i = 0; i < order.length; i++) {
            .build();
        final long baseTime = System.nanoTime();
                IndexMetadata.builder("test")
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
                    .numberOfReplicas(randomIntBetween(0, 3))
 */
        Metadata metadata = Metadata.builder()
            .build();
        final long expectMinDelaySettingsNanos = Math.min(delayTest1.nanos(), delayTest2.nanos());
    public void testFailedShard() {
        UnassignedInfo unassignedInfo = new UnassignedInfo(
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
 * Unless required by applicable law or agreed to in writing,
        AllocationService allocation = createAllocationService();
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
        assertThat(clusterState.getRoutingNodes().unassigned().iterator().next().unassignedInfo().isDelayed(), equalTo(false));
        final TimeValue clusterDelay = TimeValue.timeValueMillis(randomIntBetween(201, 400));
        );
        Settings indexSettings = Settings.builder()
        assertThat(read.getReason(), equalTo(meta.getReason()));
            1,
        final Settings clusterSettings = Settings.builder()
            greaterThan(0L)
        );
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(false));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
            )
import org.opensearch.cluster.metadata.Metadata;
    public void testReasonOrdinalOrder() {
            .build();
    }
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(delay, equalTo(totalDelayNanos - delta1));
        Settings nodeSettings = Settings.builder()
import java.util.Set;
            .build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
        Metadata metadata = Metadata.builder()
        Metadata metadata = Metadata.builder()
        final long baseTime = System.nanoTime();
        final long baseTime = System.nanoTime();
        clusterState = allocation.reroute(clusterState, "reroute");
            UnassignedInfo.Reason.NODE_LEFT,
                    .numberOfShards(randomIntBetween(1, 3))
            UnassignedInfo.Reason.INDEX_CLOSED,
                            UUIDs.randomBase64UUID(),
            .build();
                    .numberOfShards(randomIntBetween(1, 3))
/*
    }
    }
 */
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
            .build();
            .build();
        // remove node2 and reroute
            .build();
    public void testStateTransitionMetaHandling() {
 * Licensed to Elasticsearch under one or more contributor
            .build();
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.DANGLING_INDEX_IMPORTED));
            .build();
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))
                    .numberOfShards(1)
            .build();
        allocation.setNanoTimeOverride(baseTime);
        final long totalDelayNanos = TimeValue.timeValueMillis(10).nanos();
        clusterState = allocation.reroute(clusterState, "reroute");
            )
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))
import static org.hamcrest.Matchers.greaterThan;
    public void testClusterRecovered() {
 * under the License.
        Metadata metadata = Metadata.builder()
            .build();
            .metadata(metadata)
            .build();
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().unassigned().iterator().next().unassignedInfo().isDelayed(), equalTo(false));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(false));
    public void testIndexDelayedAllocationSettingOverridesClusterDefault() {
        UnassignedInfo meta = reason == UnassignedInfo.Reason.ALLOCATION_FAILED
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(true));
        clusterState = allocation.reroute(clusterState, "reroute");
        ShardRouting shard = TestShardRouting.newShardRouting(
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo(), notNullValue());
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(100))
import org.opensearch.common.settings.Settings;
                    .addAsRestore(
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
            .put(
        delay = unassignedInfo.getRemainingDelay(baseTime + totalDelayNanos + randomIntBetween(1, 20), indexSettings, Settings.EMPTY);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        shard = shard.initialize("test_node", null, -1);
                    .numberOfShards(randomIntBetween(1, 3))
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            .build();
                reason,
                        new SnapshotRecoverySource(
            UnassignedInfo.Reason.INDEX_REOPENED,
        assertThat(shard.unassignedInfo(), nullValue());
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .metadata(metadata)
        clusterState = ClusterState.builder(clusterState)
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), delayTest1))
        // starting primaries
     * The unassigned meta is kept when a shard goes to INITIALIZING, but cleared when it moves to STARTED.
            baseTime,
                    .numberOfReplicas(randomIntBetween(0, 3))
        final TimeValue clusterDelay = TimeValue.timeValueMillis(randomIntBetween(1, 200));
        clusterState = ClusterState.builder(clusterState)
            UnassignedInfo.Reason.INDEX_CREATED,
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build())
 * this work for additional information regarding copyright
        );
            AllocationStatus.NO_ATTEMPT,
import org.opensearch.cluster.node.DiscoveryNodes;
            .metadata(metadata)
        int failedAllocations = randomIntBetween(1, 100);
                    .settings(settings(Version.CURRENT))
        // starting replicas
        Metadata metadata = Metadata.builder()
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getReason(),
        clusterState = allocation.reroute(clusterState, "reroute");
import java.util.Collections;
        // make sure both replicas are marked as delayed (i.e. not reallocated)
        // starting primaries
                    .numberOfReplicas(randomIntBetween(0, 3))
        assertThat(unassignedInfo.getRemainingDelay(baseTime, Settings.EMPTY, clusterSettings), equalTo(clusterDelay.nanos()));
        Set<String> failedNodes = IntStream.range(0, between(0, failedAllocations))
        );
            "test",
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        assertThat(delay, equalTo(totalDelayNanos));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), nodeDelay)
 * compatible open source license.
        MockAllocationService allocation = createAllocationService(nodeSettings, new DelayedShardsMockGatewayAllocator());
            null,
 * The OpenSearch Contributors require contributions made to
        }
            UnassignedInfo.Reason.FORCED_EMPTY_PRIMARY,
                    .numberOfReplicas(1)
            .build();
        Metadata metadata = Metadata.builder()
        out.close();
                System.nanoTime(),
            0,
        assertThat(read.getNumFailedAllocations(), equalTo(meta.getNumFailedAllocations()));
 * You may obtain a copy of the License at
            .build();
    }
            "test",
        return startInitializingShardsAndReroute(allocation, clusterState);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT).put(indexSettings)).numberOfShards(1).numberOfReplicas(1))
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
    public void testExistingIndexRestored() {
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
            .build();
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
            .metadata(metadata)
                    .numberOfShards(randomIntBetween(1, 3))
        final Settings clusterSettings = Settings.builder()
                    .settings(settings(Version.CURRENT))
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
            .metadata(metadata)
import org.opensearch.cluster.routing.allocation.AllocationService;
    }
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    public void testNumberOfDelayedUnassigned() throws Exception {
            UnassignedInfo.Reason.CHILD_SHARD_CREATED, };
                    .addAsNewRestore(
        clusterState = ClusterState.builder(clusterState)
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            UnassignedInfo.Reason.NODE_LEFT,
        assertThat(UnassignedInfo.getNodeLeftDelayedTimeout(Settings.EMPTY, clusterSettings), equalTo(clusterDelay));
            .metadata(metadata)
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), indexDelay)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo(), notNullValue());
                System.currentTimeMillis(),
        UnassignedInfo unassignedInfo = new UnassignedInfo(
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .metadata(metadata)
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
                null,
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getUnassignedTimeInMillis(),
        for (IndexShardRoutingTable indexShardRoutingTable : clusterState.routingTable().index(index)) {
     * Verifies that delayed allocation calculation are correct.
        Metadata metadata = Metadata.builder()
            ByteBufferStreamInput in = new ByteBufferStreamInput(ByteBuffer.wrap(out.bytes().toBytesRef().bytes));
    }
            )
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), clusterDelay)
            .build();
                    .settings(settings(Version.CURRENT))
    }
            .metadata(metadata)
                            new IndexId("test", UUIDs.randomBase64UUID(random()))
            .mapToObj(n -> "failed-node-" + n)
 * specific language governing permissions and limitations
    public void testSerialization() throws Exception {
            Collections.emptySet()
            .routingTable(
                            new IndexId("test", UUIDs.randomBase64UUID(random()))
                    .build()
                IndexMetadata.builder("test2")
                    .numberOfReplicas(randomIntBetween(0, 3))
        );
        assertThat(
        final Index index = metadata.index("test").getIndex();
     */
        // starting replicas
import org.opensearch.common.unit.TimeValue;
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                    .build()
        );
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(true));
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
        assertThat(
            .build();
    }
    }
            .metadata(metadata)
    public void testFindNextDelayedAllocationUsesNodeLevelClusterDefault() {
        final Settings nodeSettings = Settings.builder()
        Metadata metadata = Metadata.builder()
        );
                IndexMetadata.builder("test")
        for (AllocationStatus allocationStatus : AllocationStatus.values()) {
package org.opensearch.cluster.routing;
            UnassignedInfo.Reason.ALLOCATION_FAILED,
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
     * Tests that during reroute when a node is detected as leaving the cluster, the right unassigned meta is set
            assertThat(shard.unassignedInfo().getReason(), equalTo(UnassignedInfo.Reason.EXISTING_INDEX_RESTORED));
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        assertThat(
        clusterState = ClusterState.builder(clusterState)
    }
 * SPDX-License-Identifier: Apache-2.0
            .persistentSettings(clusterSettings)
    public void testClusterStateSettingOverridesNodeLevelClusterSettingForNodeLeftDelay() {
import java.io.IOException;
     */
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(
        final long delta = randomBoolean() ? 0 : randomInt((int) expectMinDelaySettingsNanos - 1);
        clusterState = allocation.reroute(clusterState, "reroute");
    }
        Metadata metadata = Metadata.builder()
                randomBoolean() ? randomAlphaOfLength(4) : null,
            .build();
            )
        shard = shard.moveToStarted();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                IndexMetadata.builder("test")
    public void testIndexCreated() {
        clusterState = allocation.reroute(clusterState, "reroute");
        ClusterState clusterState = createStartedClusterState(allocation, clusterSettings, indexSettings);
                    .numberOfShards(randomIntBetween(1, 3))
            .build();
            .metadata(metadata)
            BytesStreamOutput out = new BytesStreamOutput();
            equalTo("failed shard on node [" + shardToFail.currentNodeId() + "]: test fail")
                        new HashSet<>()
 * ownership. Elasticsearch licenses this file to you under
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        assertThat(shard.state(), equalTo(ShardRoutingState.INITIALIZING));
     * Verifies that when a shard fails, reason is properly set and details are preserved.
            equalTo(clusterDelay.nanos())
        assertThat(delay, equalTo(0L));
        assertThat(
    public void testDanglingIndexImported() {
            .build();
            .build();
        allocation.setNanoTimeOverride(baseTime);
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))
        BytesStreamOutput out = new BytesStreamOutput();
            builder.addIndexShard(indexShardRoutingTable);
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
import org.opensearch.snapshots.SnapshotId;
        final TimeValue delayTest1 = TimeValue.timeValueMillis(randomIntBetween(1, 200));
            .build();
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
                AllocationStatus.NO_ATTEMPT,
        Metadata metadata = Metadata.builder()
        long delta1 = randomIntBetween(1, (int) (totalDelayNanos - 1));
            .build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }
        assertThat(shard.unassignedInfo(), notNullValue());
            .build();
import org.opensearch.Version;
                    .numberOfShards(1)
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getDetails(),
        final TimeValue indexDelay = TimeValue.timeValueMillis(randomIntBetween(1, 200));
        final Settings indexSettings = Settings.builder()
        assertThat(read.getFailedNodeIds(), equalTo(meta.getFailedNodeIds()));
        assertThat(
        assertThat(clusterState.getRoutingNodes().unassigned().iterator().next().unassignedInfo().isDelayed(), equalTo(true));
            .build();
    public void testNodeLevelClusterDelayedAllocationSettingControlsNodeLeftDelay() {
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().unassigned().iterator().next().unassignedInfo().isDelayed(), equalTo(true));
            )
            "test",
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getReason(),
            .put(
        for (ShardRouting shard : clusterState.getRoutingNodes().shardsWithState(UNASSIGNED)) {
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
        Metadata metadata = Metadata.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo(), notNullValue());
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
        assertThat(
                    )
        }
            UnassignedInfo.Reason.MANUAL_ALLOCATION,
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            baseTime,
        // starting primaries
            .build();
    public void testRemainingDelayCalculation() throws Exception {
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
            .routingTable(RoutingTable.builder().addAsRecovery(metadata.index("test")).build())
    /**
        Settings nodeSettings = Settings.builder()
    public void testFindNextDelayedAllocationUsesClusterDefault() {
            assertThat(readStatus, equalTo(allocationStatus));
    /**
    public void testClusterDelayedAllocationSettingControlsNodeLeftDelay() {
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(1));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
            true,
            UnassignedInfo.Reason.DANGLING_INDEX_IMPORTED,
        }
        ClusterState clusterState = createStartedClusterState(allocation, clusterSettings, Settings.EMPTY);
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), delayTest2))
    public void testAllocationStatusSerialization() throws IOException {
        // remove node2 and reroute
        ClusterState clusterState = createStartedClusterState(allocation, clusterSettings, Settings.EMPTY);
            assertThat(order[i].ordinal(), equalTo(i));
            null,
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getReason(),
            clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).get(0).unassignedInfo().getUnassignedTimeInMillis(),
        UnassignedInfo.Reason[] order = new UnassignedInfo.Reason[] {
            equalTo(UnassignedInfo.Reason.ALLOCATION_FAILED)
     */
            clusterState,
 */
