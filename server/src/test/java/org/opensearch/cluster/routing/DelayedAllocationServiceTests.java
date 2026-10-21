                                .build(),
                    .numberOfReplicas(1)
        TestDelayAllocationService localDelayedAllocationService = new TestDelayAllocationService(
 *     http://www.apache.org/licenses/LICENSE-2.0
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("short_delay")).addAsNew(metadata.index("long_delay")).build())
            new ClusterChangedEvent(CLUSTER_UPDATE_TASK_SOURCE, stateWithOnlyOneDelayedShard, stateWithDelayedShards)
        // apply cluster state
     */
                    stateWithOnlyOneDelayedShard.metadata().settings()
        assertFalse(delayedRerouteTask.cancelScheduling.get());
            // update settings with shorter delay
 */
        ShardRouting delayedShard = stateWithDelayedShard.getRoutingNodes().unassigned().iterator().next();
        CountDownLatch latch = new CountDownLatch(1);
            .metadata(metadata)
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), delaySetting)
        assertFalse("no shards should be unassigned", clusterState.getRoutingNodes().unassigned().size() > 0);
        delayedAllocationService.clusterChanged(new ClusterChangedEvent("fake node left", stateWithDelayedShard, clusterState));
        clusterState = startInitializingShardsAndReroute(localAllocationService, clusterState);
/*
        // apply cluster state
        assertNotNull(delayedRerouteTask);
                .nodes(DiscoveryNodes.builder(stateWithDelayedShard.nodes()).remove(nodeIdOfBarReplica))
            .build();
            return null;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(baseTimestampNanos, delayedShard.unassignedInfo().getUnassignedTimeInNanos());
            .build();
        final long nodeLeftTimestampNanos = System.nanoTime();
    }
                nodeId = shardRouting.currentNodeId();
import org.opensearch.cluster.service.ClusterService;
            delayedRerouteTask.nextDelay.nanos(),
                    .numberOfShards(1)
                    )
import static org.mockito.Mockito.verifyNoMoreInteractions;
            .put(
        // starting primaries
        assertNotNull(firstDelayedRerouteTask);
                    stateWithDelayedShards,
        clusterState = startInitializingShardsAndReroute(localAllocationService, clusterState);
            clusterStateUpdateTask2.set((ClusterStateUpdateTask) invocationOnMock.getArguments()[1]);
        clusterState = ClusterState.builder(clusterState)
        assertTrue(latch.await(30, TimeUnit.SECONDS));
            .build();
    private ClusterService clusterService;
                .build();
            .build();
        delayedAllocationService.clusterChanged(
                    .clusterManagerNodeId("node0")
            firstDelayedRerouteTask.nextDelay.nanos(),
        delayedAllocationService.setNanoTimeOverride(nanoTimeForReroute + timeValueMillis(randomInt(50)).nanos());
                IndexMetadata.builder("test")
        // starting replicas
                    .remove(longDelayReplica.currentNodeId())
        // check that delayed reroute task was created and registered with the proper settings
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
                    .numberOfReplicas(1)
import static org.mockito.Mockito.any;
        }
            return nanoTimeOverride == -1L ? super.currentNanoTime() : nanoTimeOverride;
        assertTrue(latch.await(30, TimeUnit.SECONDS));
                    .settings(
            .build();
            this.nanoTimeOverride = nanoTime;
            delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
        assertNull(delayedAllocationService.delayedRerouteTask.get());
        doAnswer(invocationOnMock -> {
        delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
        delayUntilClusterChangeEvent = timeValueMillis(randomInt(50)).nanos();
        clusterState = localAllocationService.reroute(clusterState, "reroute");
                    )
                    .localNodeId("node1")
        ClusterState beforeNodeLeft = clusterState;
        TimeValue delaySetting = timeValueSeconds(30);
        // make sure the replica is marked as delayed (i.e. not reallocated)
 * under the License.
            )
        String nodeIdOfFooReplica = null;
            .build();
        // check that submitStateUpdateTask() was invoked on the cluster service mock
            assertThat(unassignedShards.size(), equalTo(1));
            latch.countDown();
            localClusterService,
        assertEquals(0, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithRemovedDelay));
        assertNotNull(secondDelayedRerouteTask);
        assertEquals(1, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithOnlyOneDelayedShard));
        assertNotNull(shortDelayReplica);
            )
        clusterState = allocationService.disassociateDeadNodes(clusterState, true, "reroute");
        ClusterService localClusterService = mock(ClusterService.class);
        // make sure both replicas are marked as delayed (i.e. not reallocated)
        verify(localClusterService).getSettings();
        // check that shard is not delayed anymore
            delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
        long delayUntilClusterChangeEvent = TimeValue.timeValueNanos(randomInt((int) shorterDelaySetting.nanos() - 1)).nanos();
        assertThat(
            delayedRerouteTask.nextDelay.nanos(),
    }
    private MockAllocationService allocationService;
        assertThat(firstDelayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));
        delayedAllocationService = new TestDelayAllocationService(threadPool, clusterService, allocationService);
            .build();
            .put(
 * this work for additional information regarding copyright
            .build();
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
        assertThat("all shards should be started", clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaNodeId)).build();
        verify(localClusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), eq(clusterStateUpdateTask.get()));
            // node leaves with replica shard of index bar that has shorter delay
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), delaySetting))
        Metadata metadata = Metadata.builder()
        AtomicReference<ClusterStateUpdateTask> clusterStateUpdateTask2 = new AtomicReference<>();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        Metadata metadata = Metadata.builder()
            assertNotNull(nodeIdOfBarReplica);
        delayedAllocationService.clusterChanged(
    }
            }
            equalTo(delaySetting.nanos() - (clusterChangeEventTimestampNanos - nodeLeftTimestampNanos))
        // start primaries
    }
        assertTrue(latch2.await(30, TimeUnit.SECONDS));
            )
            .build();
import org.opensearch.cluster.ClusterState;
            .build();
        clusterState = localAllocationService.disassociateDeadNodes(clusterState, true, "reroute");
            .nodes(
        );
                    .numberOfShards(1)
 *
        delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
        } else {
        ClusterState newState = clusterState;
        // remove node of shortDelayReplica and node of longDelayReplica and reroute
            ClusterState stateWithShorterDelay = ClusterState.builder(stateWithDelayedShard)
            )
        if (randomBoolean()) {
public class DelayedAllocationServiceTests extends OpenSearchAllocationTestCase {
        );
        private TestDelayAllocationService(ThreadPool threadPool, ClusterService clusterService, AllocationService allocationService) {
        localDelayedAllocationService.clusterChanged(new ClusterChangedEvent("fake node left", stateWithDelayedShard, beforeNodeLeft));
        ClusterState stateWithDelayedShard = clusterState;
        long clusterChangeEventTimestampNanos = baseTimestampNanos + delayUntilClusterChangeEvent;
            super(threadPool, clusterService, allocationService);
    }
            latch1.countDown();
        }
                .build();
        CountDownLatch latch1 = new CountDownLatch(1);
import org.opensearch.threadpool.TestThreadPool;
        }
    private TestDelayAllocationService delayedAllocationService;
        String nodeId = null;
        ClusterState stateWithOnlyOneDelayedShard = clusterStateUpdateTask1.get().execute(stateWithDelayedShards);
                break;
                    .numberOfReplicas(1)
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .put(
        }).when(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), any(ClusterStateUpdateTask.class));
        assertNull(delayedAllocationService.delayedRerouteTask.get());
        // check that submitStateUpdateTask() was invoked on the cluster service mock
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        assertTrue(latch1.await(30, TimeUnit.SECONDS));
        assertThat(
        );
 * Licensed to Elasticsearch under one or more contributor
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
        // check that new delayed reroute task was created and registered with the proper settings
/*
        assertNotNull(delayedRerouteTask);
        clusterState = allocationService.disassociateDeadNodes(clusterState, true, "reroute");
            new ClusterChangedEvent(CLUSTER_UPDATE_TASK_SOURCE, stateWithRemovedDelay, stateWithDelayedShard)
        // starting replicas
import static org.hamcrest.Matchers.equalTo;
            )
        // find replica of short_delay
        for (ShardRouting shardRouting : clusterState.getRoutingTable().allShards("long_delay")) {
        List<ShardRouting> unassignedShards = newState.getRoutingTable().shardsWithState(ShardRoutingState.UNASSIGNED);
            delayedRerouteTask.nextDelay.nanos(),
        nanoTimeForReroute = clusterChangeEventTimestampNanos + longDelaySetting.nanos() + timeValueMillis(randomInt(50)).nanos();
        verifyNoMoreInteractions(clusterService);
import java.util.concurrent.atomic.AtomicReference;
            if (shardRouting.primary() == false) {
                nodeIdOfFooReplica = shardRouting.currentNodeId();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            }
        clusterService = mock(ClusterService.class);
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0"))
    @Before
        localAllocationService.setNanoTimeOverride(baseTimestampNanos);
 */
        long delayUntilClusterChangeEvent = TimeValue.timeValueNanos(randomInt((int) shortDelaySetting.nanos() - 1)).nanos();
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        DelayedAllocationService.DelayedRerouteTask delayedRerouteTask = localDelayedAllocationService.delayedRerouteTask.get();
        );
        );
        // The scheduled nextDelay assertion below is the regression check for the node-level setting path.
import static org.mockito.Mockito.eq;
                            Settings.builder()
        // apply cluster state
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                IndexMetadata.builder("short_delay")
        assertThat(
        assertThat(delayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));
        when(clusterService.getSettings()).thenReturn(NodeRoles.clusterManagerOnlyNode());
        // starting primaries
        // advance the time on the allocation service to a timestamp that happened after the delayed scheduling
        // simulate calling listener (cluster change event)
                    .settings(
                    .numberOfReplicas(1)
    public void createDelayedAllocationService() {
            firstDelayedRerouteTask.nextDelay.nanos(),
        assertThat(delayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));
        // find replica of long_delay
        // check that delayed reroute task was created and registered with the proper settings
        clusterState = allocationService.reroute(clusterState, "reroute");
        doAnswer(invocationOnMock -> {
                    .remove(shortDelayReplica.currentNodeId())
                    clusterChangeEventTimestampNanos,
        long clusterChangeEventTimestampNanos = baseTimestampNanos + delayUntilClusterChangeEvent;
        // check that task is now removed
        // starting primaries
        AtomicReference<ClusterStateUpdateTask> clusterStateUpdateTask1 = new AtomicReference<>();
        for (ShardRouting shardRouting : clusterState.getRoutingTable().allShards("foo")) {
        // check that submitStateUpdateTask() was invoked on the cluster service mock
        long clusterChangeEventTimestampNanos = nodeLeftTimestampNanos + delayUntilClusterChangeEvent;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).localNodeId("node1").clusterManagerNodeId("node1"))
        doAnswer(invocationOnMock -> {
        );
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
            .build();
                        settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), shorterDelaySetting)
        assertNull(delayedAllocationService.delayedRerouteTask.get());
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            equalTo(
            .metadata(metadata)
        long clusterChangeEventTimestampNanos = baseTimestampNanos + delayUntilClusterChangeEvent;
            )
            nodes.add(newNode("node3"));
        // allocate shards
 * SPDX-License-Identifier: Apache-2.0
        allocationService.setNanoTimeOverride(baseTimestampNanos);
        // advance the time on the allocation service to a timestamp that happened after the delayed scheduling
        assertEquals(nodeLeftTimestampNanos, delayedShard.unassignedInfo().getUnassignedTimeInNanos());
        // check that task is now removed
        if (nodeAvailableForAllocation) {
     * This tests that a new delayed reroute is scheduled right after a delayed reroute was run
        TimeValue longDelaySetting = TimeValue.timeValueSeconds(1);
            secondDelayedRerouteTask.nextDelay.nanos(),
        // check that task is now removed
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
                    .numberOfShards(1)
 */
import org.opensearch.cluster.ClusterChangedEvent;
            clusterStateUpdateTask.set((ClusterStateUpdateTask) invocationOnMock.getArguments()[1]);
            }
                    .numberOfShards(1)
        assertNull(delayedAllocationService.delayedRerouteTask.get());
                        settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), shortDelaySetting)
        assertEquals(1, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithDelayedShard));
        AtomicReference<ClusterStateUpdateTask> clusterStateUpdateTask = new AtomicReference<>();
        clusterState = allocationService.reroute(clusterState, "reroute");
        verify(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), eq(clusterStateUpdateTask.get()));
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        clusterState = ClusterState.builder(clusterState)
        allocationService = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
                    )
 * The OpenSearch Contributors require contributions made to
        );
        when(localClusterService.getSettings()).thenReturn(nodeSettings);
                    .numberOfShards(1)
                    .add(newNode("node2"))
 * KIND, either express or implied.  See the License for the
        assertNull(delayedAllocationService.delayedRerouteTask.get());
        // check that delayed reroute task was created and registered with the proper settings
    public void testDelayedUnassignedScheduleRerouteRescheduledOnShorterDelay() throws Exception {
                DiscoveryNodes.builder(clusterState.nodes())
            );
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
        clusterState = allocationService.disassociateDeadNodes(clusterState, true, "fake node left");
        TimeValue shortDelaySetting = timeValueMillis(100);
    }
        assertEquals(0, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithNoDelayedShards));
        delayedAllocationService.clusterChanged(
                        )
            assertThat(unassignedShards.get(0).unassignedInfo().isDelayed(), equalTo(false));
        public void setNanoTimeOverride(long nanoTime) {
                UnassignedInfo.findNextDelayedAllocation(
        for (ShardRouting shardRouting : allShards) {
            for (ShardRouting shardRouting : stateWithDelayedShard.getRoutingTable().allShards("bar")) {
        // remove node2 and reroute
                DiscoveryNodes.builder()
            clusterStateUpdateTask.set((ClusterStateUpdateTask) invocationOnMock.getArguments()[1]);
        assertFalse(delayedRerouteTask.cancelScheduling.get());
        assertThat(
        }
                    .localNodeId("node0")
        CountDownLatch latch2 = new CountDownLatch(1);
        verify(clusterService).getSettings();
        DelayedAllocationService.DelayedRerouteTask delayedRerouteTask = delayedAllocationService.delayedRerouteTask.get();
        assertNotNull(longDelayReplica);
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).localNodeId("node1").clusterManagerNodeId("node1"))
 *
        );
    public void testNoDelayedUnassigned() throws Exception {
import static org.opensearch.cluster.routing.DelayedAllocationService.CLUSTER_UPDATE_TASK_SOURCE;
        );
                IndexMetadata.builder("test")
        assertThat(
                        settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), longDelaySetting)
                IndexMetadata.builder("long_delay")
            if (shardRouting.primary() == false) {
            ClusterState stateWithShorterDelay = allocationService.disassociateDeadNodes(clusterState, true, "fake node left");
        for (ShardRouting shardRouting : clusterState.getRoutingTable().allShards("short_delay")) {
        );
        }
        // we need to find the node with the replica otherwise we will not reroute
        assertFalse(shorterDelayedRerouteTask.cancelScheduling.get());
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
            }
 * compatible open source license.
        final long baseTimestampNanos = System.nanoTime();
                    stateWithOnlyOneDelayedShard,
        ClusterState prevState = clusterState;
        assertNull(delayedAllocationService.delayedRerouteTask.get());
        // starting replicas
        }).when(localClusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), any(ClusterStateUpdateTask.class));
/*
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(nodeId)).build();
            )
        delayedAllocationService.clusterChanged(new ClusterChangedEvent("fake node left", stateWithDelayedShard, clusterState));
        assertNull(delayedAllocationService.delayedRerouteTask.get());
        assertFalse(firstDelayedRerouteTask.cancelScheduling.get());
            )
        // start replicas
        }
        DelayedAllocationService.DelayedRerouteTask secondDelayedRerouteTask = delayedAllocationService.delayedRerouteTask.get();
        assertNotNull(nodeIdOfFooReplica);
        assertEquals(baseTimestampNanos, iter.next().unassignedInfo().getUnassignedTimeInNanos());
        allocationService.setNanoTimeOverride(nanoTimeForReroute);
 * not use this file except in compliance with the License.
        assertThat(delayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));
import static org.mockito.Mockito.mock;
        Settings nodeSettings = Settings.builder()
        // remove node that has replica and reroute
            )
        }
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), delaySetting))
import org.opensearch.threadpool.ThreadPool;
package org.opensearch.cluster.routing;
            .put(
 *
                )
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.ClusterName;
        delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
        allocationService.setNanoTimeOverride(nanoTimeForReroute);
 * Modifications Copyright OpenSearch Contributors. See
        @Override
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(nodeIdOfFooReplica))
                longDelayReplica = shardRouting;
        DelayedAllocationService.DelayedRerouteTask firstDelayedRerouteTask = delayedAllocationService.delayedRerouteTask.get();
        final ClusterState stateWithDelayedShards = clusterState;
            if (shardRouting.primary() == false) {
            if (shardRouting.primary() == false) {
        AtomicReference<ClusterStateUpdateTask> clusterStateUpdateTask = new AtomicReference<>();
            localAllocationService
                break;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).localNodeId("node1").clusterManagerNodeId("node1"))
                .metadata(
    public void testDelayedUnassignedScheduleReroute() throws Exception {
        allocationService.setNanoTimeOverride(baseTimestampNanos);
        allocationService.setNanoTimeOverride(nodeLeftTimestampNanos);
        // simulate calling listener (cluster change event)
            return null;
        }).when(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), any(ClusterStateUpdateTask.class));
                        .updateSettings(
        // make sure the replica is marked as delayed (i.e. not reallocated)
                    .clusterManagerNodeId("node1")
        // check that no further cluster state update was submitted
            // do not check this in the unit tests
                    nodeIdOfBarReplica = shardRouting.currentNodeId();
        DelayedAllocationService.DelayedRerouteTask delayedRerouteTask = delayedAllocationService.delayedRerouteTask.get();
        }
    /**
        assertThat(delayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));
        if (nodeAvailableForAllocation) {
            equalTo(shorterDelaySetting.nanos() - (clusterChangeEventTimestampNanos - nodeLeftTimestampNanos))
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
                    .numberOfShards(1)
        );
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes()).remove("node2");
            .build();
        }
        // isDelayed alone cannot distinguish the node-level 100ms setting from the built-in 1m default.
        allocationService.setNanoTimeOverride(nanoTimeForReroute);
            .put(
        Metadata metadata = Metadata.builder()
        assertEquals(baseTimestampNanos, iter.next().unassignedInfo().getUnassignedTimeInNanos());
            String nodeIdOfBarReplica = null;
        delayedAllocationService.clusterChanged(
        assertEquals(1, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithDelayedShard));
        ClusterState stateWithDelayedShard = clusterState;
    }
        TimeValue delaySetting = timeValueMillis(100);
        } else {
                }
        TimeValue delaySetting = timeValueMillis(100);
            )
        assertNotNull(delayedRerouteTask);
            )
        // check that no new task is scheduled
            }
        ClusterState stateWithNoDelayedShards = clusterStateUpdateTask2.get().execute(stateWithOnlyOneDelayedShard);
            .build();
            }
                    .add(newNode("node0", singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)))
            .nodes(
        ShardRouting delayedShard = stateWithDelayedShard.getRoutingNodes().unassigned().iterator().next();
                new ClusterChangedEvent("fake node left", stateWithShorterDelay, stateWithDelayedShard)
import org.opensearch.cluster.node.DiscoveryNodes;
        assertNotNull(replicaNodeId);
        final long baseTimestampNanos = System.nanoTime();
                )
        RoutingNodes.UnassignedShards.UnassignedIterator iter = stateWithDelayedShards.getRoutingNodes().unassigned().iterator();
        delayedAllocationService.setNanoTimeOverride(nanoTimeForReroute + timeValueMillis(randomInt(200)).nanos());
            secondDelayedRerouteTask.nextDelay.nanos(),
            .put(NodeRoles.clusterManagerOnlyNode())
                break;
 * GitHub history for details.
        @Override
        clusterState = allocationService.reroute(clusterState, "reroute");
    public void testDelayedUnassignedScheduleRerouteAfterDelayedReroute() throws Exception {
                replicaNodeId = shardRouting.currentNodeId();
        for (ShardRouting shardRouting : clusterState.getRoutingTable().allShards("test")) {
        clusterState = ClusterState.builder(clusterState)
        // check that no further cluster state update was submitted
        assertNull(delayedAllocationService.delayedRerouteTask.get());
            .nodes(
import org.opensearch.Version;
                DiscoveryNodes.builder()
            delayedAllocationService.clusterChanged(
                    .numberOfReplicas(1)
import java.util.concurrent.CountDownLatch;
            if (shardRouting.primary() == false) {
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(false));
        assertFalse(delayedRerouteTask.cancelScheduling.get());
        clusterState = ClusterState.builder(clusterState).nodes(nodes).build();
        verifyNoMoreInteractions(clusterService);
        assertEquals(1, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithDelayedShard));
import org.opensearch.cluster.metadata.Metadata;
        Metadata metadata = Metadata.builder()
            return null;
        assertFalse("no shards should be unassigned", clusterState.getRoutingNodes().unassigned().size() > 0);
        long nanoTimeForReroute = clusterChangeEventTimestampNanos + shortDelaySetting.nanos() + timeValueMillis(randomInt(50)).nanos();
        assertNotNull(shorterDelayedRerouteTask);
        // remove node that has replica and reroute
        terminate(threadPool);
                            "foo"
 * software distributed under the License is distributed on an
        DelayedAllocationService.DelayedRerouteTask shorterDelayedRerouteTask = delayedAllocationService.delayedRerouteTask.get();
            // remove node that has replica and reroute
        // advance the time on the allocation service to a timestamp that happened after the delayed scheduling
            clusterState = ClusterState.builder(stateWithDelayedShard)
 * the Apache License, Version 2.0 (the "License"); you may
        String replicaNodeId = null;
        assertTrue(delayedRerouteTask.cancelScheduling.get()); // existing task was cancelled
        clusterChangeEventTimestampNanos = nanoTimeForReroute + delayUntilClusterChangeEvent;
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("foo")).addAsNew(metadata.index("bar")).build())
                    .add(newNode("node1"))
    public void testDelayedUnassignedScheduleRerouteUsesNodeLevelClusterDefault() throws Exception {
                    .add(newNode("node2"))
            .metadata(metadata)
import java.util.concurrent.TimeUnit;
            .put(
        ShardRouting longDelayReplica = null;
import java.util.List;
        // check that shard is not delayed anymore
        assertEquals(2, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithDelayedShards));
import org.opensearch.cluster.node.DiscoveryNodeRole;
        protected void assertClusterOrClusterManagerStateThread() {
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            shorterDelayedRerouteTask.nextDelay.nanos(),
        MockAllocationService localAllocationService = createAllocationService(nodeSettings, new DelayedShardsMockGatewayAllocator());
import static org.mockito.Mockito.doAnswer;
            equalTo(delaySetting.nanos() - (clusterChangeEventTimestampNanos - baseTimestampNanos))
                    .add(newNode("node1"))
 * Unless required by applicable law or agreed to in writing,
        assertThat(secondDelayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));
 * ownership. Elasticsearch licenses this file to you under
        assertNotEquals(shorterDelayedRerouteTask, delayedRerouteTask);
 * You may obtain a copy of the License at
                shortDelayReplica = shardRouting;
        assertThat(
        long delayUntilClusterChangeEvent = TimeValue.timeValueNanos(randomInt((int) delaySetting.nanos() - 1)).nanos();
                    stateWithDelayedShards.metadata().settings()
        boolean nodeAvailableForAllocation = randomBoolean();
            .build();
            equalTo(shortDelaySetting.nanos() - (clusterChangeEventTimestampNanos - baseTimestampNanos))
        }
import org.opensearch.common.settings.Settings;
            delayedAllocationService.clusterChanged(
        assertNotNull(nodeId);
        assertThat(
            threadPool,
                    break;
            assertThat(unassignedShards.size(), equalTo(0));
            .build();
        // check that delayed reroute task was replaced by shorter reroute task
        clusterState = ClusterState.builder(clusterState)
        private volatile long nanoTimeOverride = -1L;
            equalTo(longDelaySetting.nanos() - (clusterChangeEventTimestampNanos - baseTimestampNanos))
        ClusterState stateWithDelayedShard = clusterState;
            latch2.countDown();
import static java.util.Collections.singleton;
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
        // mock ClusterService.submitStateUpdateTask() method again
        ClusterState stateWithRemovedDelay = clusterStateUpdateTask.get().execute(stateWithDelayedShard);
                                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), shorterDelaySetting)
        localDelayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
 * this file be licensed under the Apache-2.0 license or a
        clusterState = allocationService.reroute(clusterState, "reroute");
            .build();
import static org.mockito.Mockito.when;
        verifyNoMoreInteractions(clusterService);
}
        ShardRouting shortDelayReplica = null;
        assertFalse(secondDelayedRerouteTask.cancelScheduling.get());
        threadPool = new TestThreadPool(getTestName());
            .metadata(metadata)
            new ClusterChangedEvent(CLUSTER_UPDATE_TASK_SOURCE, stateWithNoDelayedShards, stateWithOnlyOneDelayedShard)
        // check that no new task is scheduled
                IndexMetadata.builder("bar")
                if (shardRouting.primary() == false) {
                    .numberOfReplicas(1)
        long delayUntilClusterChangeEvent = TimeValue.timeValueNanos(randomInt((int) delaySetting.nanos() - 1)).nanos();
                new ClusterChangedEvent("apply shorter delay", stateWithShorterDelay, stateWithDelayedShard)
        long nanoTimeForReroute = clusterChangeEventTimestampNanos + delaySetting.nanos() + timeValueMillis(randomInt(200)).nanos();
            new ClusterChangedEvent("fake node left", stateWithDelayedShards, clusterStateBeforeNodeLeft)
    private ThreadPool threadPool;
            equalTo(
        protected long currentNanoTime() {
            return null;
                UnassignedInfo.findNextDelayedAllocation(
        TimeValue shorterDelaySetting = timeValueMillis(100);
        clusterState = ClusterState.builder(clusterState)
        verify(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), eq(clusterStateUpdateTask2.get()));
        assertNull(delayedAllocationService.delayedRerouteTask.get());
        );
 * specific language governing permissions and limitations
            .metadata(metadata)
import org.opensearch.cluster.ClusterStateUpdateTask;
    public void shutdownThreadPool() throws Exception {
        );
        delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
 * license agreements. See the NOTICE file distributed with
        // check that shard is not delayed anymore
            equalTo(delaySetting.nanos() - (clusterChangeEventTimestampNanos - baseTimestampNanos))
                    .add(newNode("node3"))
import org.opensearch.cluster.routing.allocation.AllocationService;
        verify(localClusterService).addListener(localDelayedAllocationService);
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        CountDownLatch latch = new CountDownLatch(1);
                IndexMetadata.builder("foo")
        final long baseTimestampNanos = System.nanoTime();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // mock ClusterService.submitStateUpdateTask() method
import org.junit.After;
                    .add(newNode("node4"))
                    .add(newNode("node4"))
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
import static org.mockito.Mockito.verify;
import org.junit.Before;
        }).when(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), any(ClusterStateUpdateTask.class));
                )
        ClusterState clusterStateBeforeNodeLeft = clusterState;
        }
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
        // mock ClusterService.submitStateUpdateTask() method
        assertThat(
        clusterState = allocationService.disassociateDeadNodes(clusterState, true, "reroute");
        verify(clusterService).addListener(delayedAllocationService);
    private static class TestDelayAllocationService extends DelayedAllocationService {
        delayedAllocationService.clusterChanged(new ClusterChangedEvent("test", newState, prevState));
                    Metadata.builder(stateWithDelayedShard.metadata())
                    .add(newNode("node3"))
        // simulate calling listener (cluster change event)
            latch.countDown();
        final List<ShardRouting> allShards = clusterState.getRoutingTable().allShards("test");
        doAnswer(invocationOnMock -> {
        verify(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), eq(clusterStateUpdateTask1.get()));
    @After
                break;
            clusterStateUpdateTask1.set((ClusterStateUpdateTask) invocationOnMock.getArguments()[1]);
import org.opensearch.test.NodeRoles;
                break;
                    clusterChangeEventTimestampNanos,
                    .settings(
            );
