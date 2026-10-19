        public void setNanoTimeOverride(long nanoTime) {
        terminate(threadPool);  
import org.opensearch.Version;
        for (ShardRouting shardRouting : allShards) {
    private MockAllocationService allocationService;
            delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
        assertEquals(0, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithRemovedDelay));
            if (shardRouting.primary() == false) {
                    .numberOfReplicas(1)
            )  
                    .numberOfShards(1)
        // advance the time on the allocation service to a timestamp that happened after the delayed scheduling
        long delayUntilClusterChangeEvent = TimeValue.timeValueNanos(randomInt((int) delaySetting.nanos() - 1)).nanos();  
        ShardRouting longDelayReplica = null;
            equalTo(shortDelaySetting.nanos() - (clusterChangeEventTimestampNanos - baseTimestampNanos))
                nodeId = shardRouting.currentNodeId();  
                    )  
        assertNotNull(firstDelayedRerouteTask);
            .put(
        // we need to find the node with the replica otherwise we will not reroute  
    private static class TestDelayAllocationService extends DelayedAllocationService {
            latch1.countDown();  
        ClusterState clusterStateBeforeNodeLeft = clusterState;
        assertNotNull(delayedRerouteTask);  
        protected long currentNanoTime() {
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
                IndexMetadata.builder("test")
import org.opensearch.threadpool.ThreadPool;
        ClusterState newState = clusterState;
        }
/*  
            equalTo(delaySetting.nanos() - (clusterChangeEventTimestampNanos - baseTimestampNanos))
import static org.mockito.Mockito.any;
        assertThat(
        TimeValue delaySetting = timeValueMillis(100);
        Metadata metadata = Metadata.builder()
                                .build(),  
            .put(
        assertThat("all shards should be started", clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
        long clusterChangeEventTimestampNanos = baseTimestampNanos + delayUntilClusterChangeEvent;
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())  
                }
            assertThat(unassignedShards.get(0).unassignedInfo().isDelayed(), equalTo(false));
            .metadata(metadata)
        );
        delayedAllocationService.clusterChanged(new ClusterChangedEvent("fake node left", stateWithDelayedShard, clusterState));
        final long baseTimestampNanos = System.nanoTime();
        verify(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), eq(clusterStateUpdateTask2.get()));
            delayedAllocationService.clusterChanged(
        assertTrue(latch1.await(30, TimeUnit.SECONDS));
        assertThat(delayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));
        if (nodeAvailableForAllocation) {  
            // do not check this in the unit tests
            .build();  
        RoutingNodes.UnassignedShards.UnassignedIterator iter = stateWithDelayedShards.getRoutingNodes().unassigned().iterator();  
        localDelayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;  
import org.opensearch.common.unit.TimeValue;
            }
        verify(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), eq(clusterStateUpdateTask1.get()));  
import java.util.concurrent.atomic.AtomicReference;  
 * under the License.  
            .put(  
        // starting replicas
        assertNotNull(replicaNodeId);  
        // check that new delayed reroute task was created and registered with the proper settings
        }
            }
        CountDownLatch latch = new CountDownLatch(1);
import static org.mockito.Mockito.verify;  
     * This tests that a new delayed reroute is scheduled right after a delayed reroute was run  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(replicaNodeId)).build();  
                )
                shortDelayReplica = shardRouting;
        ShardRouting delayedShard = stateWithDelayedShard.getRoutingNodes().unassigned().iterator().next();  
}
        );
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .nodes(
        if (randomBoolean()) {
    public void testNoDelayedUnassigned() throws Exception {  
            )
        );  
 */
        // check that shard is not delayed anymore  
import java.util.List;  
        // simulate calling listener (cluster change event)
        AtomicReference<ClusterStateUpdateTask> clusterStateUpdateTask2 = new AtomicReference<>();
import org.opensearch.threadpool.TestThreadPool;
    public void createDelayedAllocationService() {  
        delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);  
        // The scheduled nextDelay assertion below is the regression check for the node-level setting path.
        delayUntilClusterChangeEvent = timeValueMillis(randomInt(50)).nanos();  
        assertNull(delayedAllocationService.delayedRerouteTask.get());  
        }  
            threadPool,
        assertThat(clusterState.getRoutingNodes().unassigned().size() > 0, equalTo(false));  
import static org.opensearch.cluster.routing.DelayedAllocationService.CLUSTER_UPDATE_TASK_SOURCE;  
 */  
            )  
        Metadata metadata = Metadata.builder()  
        CountDownLatch latch2 = new CountDownLatch(1);
            return null;  
        // make sure both replicas are marked as delayed (i.e. not reallocated)
        when(clusterService.getSettings()).thenReturn(NodeRoles.clusterManagerOnlyNode());
            .build();
import static org.hamcrest.Matchers.equalTo;
        clusterState = ClusterState.builder(clusterState)
        clusterState = ClusterState.builder(clusterState).nodes(nodes).build();
        AtomicReference<ClusterStateUpdateTask> clusterStateUpdateTask = new AtomicReference<>();
        DelayedAllocationService.DelayedRerouteTask delayedRerouteTask = localDelayedAllocationService.delayedRerouteTask.get();
        clusterState = startInitializingShardsAndReroute(localAllocationService, clusterState);  
        allocationService = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.ClusterChangedEvent;
        // make sure the replica is marked as delayed (i.e. not reallocated)
        // find replica of short_delay  
    public void shutdownThreadPool() throws Exception {
        delayedAllocationService.clusterChanged(new ClusterChangedEvent("fake node left", stateWithDelayedShard, clusterState));  
            .build();
        TimeValue shorterDelaySetting = timeValueMillis(100);  
        );  
        // mock ClusterService.submitStateUpdateTask() method
        allocationService.setNanoTimeOverride(baseTimestampNanos);
        verify(localClusterService).addListener(localDelayedAllocationService);  
            new ClusterChangedEvent(CLUSTER_UPDATE_TASK_SOURCE, stateWithRemovedDelay, stateWithDelayedShard)
        TestDelayAllocationService localDelayedAllocationService = new TestDelayAllocationService(
import static org.mockito.Mockito.verifyNoMoreInteractions;
        }).when(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), any(ClusterStateUpdateTask.class));
        final ClusterState stateWithDelayedShards = clusterState;
                new ClusterChangedEvent("apply shorter delay", stateWithShorterDelay, stateWithDelayedShard)
                    .remove(shortDelayReplica.currentNodeId())  
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
        }
                    .remove(longDelayReplica.currentNodeId())
        assertNotNull(secondDelayedRerouteTask);  
            }  
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), delaySetting))
        boolean nodeAvailableForAllocation = randomBoolean();
            if (shardRouting.primary() == false) {  
                    nodeIdOfBarReplica = shardRouting.currentNodeId();
            )
        clusterState = localAllocationService.disassociateDeadNodes(clusterState, true, "reroute");
        assertNull(delayedAllocationService.delayedRerouteTask.get());  
        assertEquals(baseTimestampNanos, iter.next().unassignedInfo().getUnassignedTimeInNanos());
package org.opensearch.cluster.routing;
        // simulate calling listener (cluster change event)
            .metadata(metadata)
        assertThat(
            return null;  
                break;
        }
        assertThat(delayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));
            .nodes(
                    .numberOfReplicas(1)  
import org.opensearch.cluster.ClusterState;
        DelayedAllocationService.DelayedRerouteTask delayedRerouteTask = delayedAllocationService.delayedRerouteTask.get();  
        localDelayedAllocationService.clusterChanged(new ClusterChangedEvent("fake node left", stateWithDelayedShard, beforeNodeLeft));  
        private TestDelayAllocationService(ThreadPool threadPool, ClusterService clusterService, AllocationService allocationService) {
                            "foo"
        // advance the time on the allocation service to a timestamp that happened after the delayed scheduling
        assertEquals(2, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithDelayedShards));
        allocationService.setNanoTimeOverride(nanoTimeForReroute);  
        threadPool = new TestThreadPool(getTestName());
            secondDelayedRerouteTask.nextDelay.nanos(),
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);  
        // check that submitStateUpdateTask() was invoked on the cluster service mock  
        // mock ClusterService.submitStateUpdateTask() method  
                    .add(newNode("node0", singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)))
        assertNotNull(shortDelayReplica);
        assertThat(
                        settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), shortDelaySetting)  
        clusterState = localAllocationService.reroute(clusterState, "reroute");
        // apply cluster state
                    .clusterManagerNodeId("node0")  
    }
            .metadata(metadata)  
        // check that delayed reroute task was replaced by shorter reroute task
            nodes.add(newNode("node3"));  
            firstDelayedRerouteTask.nextDelay.nanos(),
        delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
        List<ShardRouting> unassignedShards = newState.getRoutingTable().shardsWithState(ShardRoutingState.UNASSIGNED);
            );
        assertNotNull(delayedRerouteTask);
        );
        // check that delayed reroute task was created and registered with the proper settings  
        // simulate calling listener (cluster change event)
                IndexMetadata.builder("short_delay")
            clusterStateUpdateTask.set((ClusterStateUpdateTask) invocationOnMock.getArguments()[1]);
        // check that shard is not delayed anymore  
        delayedAllocationService.clusterChanged(  
        // check that no new task is scheduled
        doAnswer(invocationOnMock -> {  
            .build();
        assertThat(delayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));  
        for (ShardRouting shardRouting : clusterState.getRoutingTable().allShards("short_delay")) {
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                break;  
            ClusterState stateWithShorterDelay = ClusterState.builder(stateWithDelayedShard)  
        String replicaNodeId = null;
                IndexMetadata.builder("bar")  
        );  
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        ClusterState stateWithDelayedShard = clusterState;
 * KIND, either express or implied.  See the License for the
        AtomicReference<ClusterStateUpdateTask> clusterStateUpdateTask = new AtomicReference<>();
                        .updateSettings(  
import static org.mockito.Mockito.mock;
            String nodeIdOfBarReplica = null;
                UnassignedInfo.findNextDelayedAllocation(
 *
                    clusterChangeEventTimestampNanos,
    public void testDelayedUnassignedScheduleRerouteAfterDelayedReroute() throws Exception {
                DiscoveryNodes.builder(clusterState.nodes())
        assertThat(
                    .numberOfShards(1)  
        // remove node that has replica and reroute
        assertFalse("no shards should be unassigned", clusterState.getRoutingNodes().unassigned().size() > 0);  
        clusterState = allocationService.disassociateDeadNodes(clusterState, true, "reroute");  
                .metadata(
            .build();
            equalTo(  
        assertNotEquals(shorterDelayedRerouteTask, delayedRerouteTask);
                    .numberOfReplicas(1)  
        assertNotNull(nodeId);
        clusterState = ClusterState.builder(clusterState)
        long nanoTimeForReroute = clusterChangeEventTimestampNanos + shortDelaySetting.nanos() + timeValueMillis(randomInt(50)).nanos();  
import org.opensearch.cluster.routing.allocation.AllocationService;
        clusterChangeEventTimestampNanos = nanoTimeForReroute + delayUntilClusterChangeEvent;
        assertEquals(baseTimestampNanos, iter.next().unassignedInfo().getUnassignedTimeInNanos());
                        settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), shorterDelaySetting)
        assertThat(  
 * this work for additional information regarding copyright
        assertThat(delayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));
 *
        assertNull(delayedAllocationService.delayedRerouteTask.get());
            equalTo(shorterDelaySetting.nanos() - (clusterChangeEventTimestampNanos - nodeLeftTimestampNanos))
    public void testDelayedUnassignedScheduleRerouteRescheduledOnShorterDelay() throws Exception {
            for (ShardRouting shardRouting : stateWithDelayedShard.getRoutingTable().allShards("bar")) {  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                    Metadata.builder(stateWithDelayedShard.metadata())
        // check that task is now removed  
        assertNull(delayedAllocationService.delayedRerouteTask.get());  
        @Override  
        clusterState = allocationService.reroute(clusterState, "reroute");
    }
        verify(localClusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), eq(clusterStateUpdateTask.get()));
 * software distributed under the License is distributed on an
            .build();
 * GitHub history for details.
        // starting primaries
        );  
                break;
        assertNotNull(longDelayReplica);  
        // make sure the replica is marked as delayed (i.e. not reallocated)
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), delaySetting))
 */  
        doAnswer(invocationOnMock -> {
        long clusterChangeEventTimestampNanos = baseTimestampNanos + delayUntilClusterChangeEvent;
        ClusterService localClusterService = mock(ClusterService.class);
        CountDownLatch latch = new CountDownLatch(1);
        }  
            .build();
            new ClusterChangedEvent("fake node left", stateWithDelayedShards, clusterStateBeforeNodeLeft)
import static java.util.Collections.singleton;
        // check that delayed reroute task was created and registered with the proper settings
import org.junit.Before;
            .build();  
    }
                                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), shorterDelaySetting)
    @Before
        // isDelayed alone cannot distinguish the node-level 100ms setting from the built-in 1m default.  
        Settings nodeSettings = Settings.builder()  
    private TestDelayAllocationService delayedAllocationService;  
                    .numberOfReplicas(1)
        // start primaries  
        assertEquals(nodeLeftTimestampNanos, delayedShard.unassignedInfo().getUnassignedTimeInNanos());
        delayedAllocationService.setNanoTimeOverride(nanoTimeForReroute + timeValueMillis(randomInt(200)).nanos());  
                replicaNodeId = shardRouting.currentNodeId();
        verify(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), eq(clusterStateUpdateTask.get()));
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
        // check that shard is not delayed anymore
        verifyNoMoreInteractions(clusterService);
            )
        doAnswer(invocationOnMock -> {  
        ShardRouting shortDelayReplica = null;
            }
                new ClusterChangedEvent("fake node left", stateWithShorterDelay, stateWithDelayedShard)  
     */
        assertEquals(0, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithNoDelayedShards));
            if (shardRouting.primary() == false) {
                    .settings(settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0"))
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), delaySetting)
            shorterDelayedRerouteTask.nextDelay.nanos(),  
 * You may obtain a copy of the License at  
 *  
        delayedAllocationService.clusterChanged(
        delayedAllocationService.clusterChanged(
        verifyNoMoreInteractions(clusterService);
                IndexMetadata.builder("long_delay")  
            .build();  
        }
        );
        final long baseTimestampNanos = System.nanoTime();
    }
    }  
public class DelayedAllocationServiceTests extends OpenSearchAllocationTestCase {
                if (shardRouting.primary() == false) {
        ClusterState stateWithRemovedDelay = clusterStateUpdateTask.get().execute(stateWithDelayedShard);
            localClusterService,  
        );
        clusterState = ClusterState.builder(clusterState)  
 * compatible open source license.
        // check that delayed reroute task was created and registered with the proper settings
            if (shardRouting.primary() == false) {  
        DelayedAllocationService.DelayedRerouteTask shorterDelayedRerouteTask = delayedAllocationService.delayedRerouteTask.get();
        assertNull(delayedAllocationService.delayedRerouteTask.get());
            .build();
                    .add(newNode("node4"))
                    .settings(
            .put(
                    .settings(
        long delayUntilClusterChangeEvent = TimeValue.timeValueNanos(randomInt((int) delaySetting.nanos() - 1)).nanos();  
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test")).build())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .numberOfReplicas(1)
        delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
        assertFalse(delayedRerouteTask.cancelScheduling.get());
    }
import org.opensearch.cluster.metadata.Metadata;
            .build();  
        protected void assertClusterOrClusterManagerStateThread() {
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        // apply cluster state
 * The OpenSearch Contributors require contributions made to  
        );
        // check that no further cluster state update was submitted  
        // remove node2 and reroute
        localAllocationService.setNanoTimeOverride(baseTimestampNanos);  
        TimeValue longDelaySetting = TimeValue.timeValueSeconds(1);
                    stateWithDelayedShards.metadata().settings()
            return null;  
                    clusterChangeEventTimestampNanos,
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("short_delay")).addAsNew(metadata.index("long_delay")).build())
        delayedAllocationService.clusterChanged(new ClusterChangedEvent("test", newState, prevState));
import org.opensearch.test.NodeRoles;  
        assertNotNull(delayedRerouteTask);
        assertEquals(1, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithDelayedShard));
                    .numberOfShards(1)
    /**
        Metadata metadata = Metadata.builder()
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).localNodeId("node1").clusterManagerNodeId("node1"))  
                    .numberOfShards(1)
        MockAllocationService localAllocationService = createAllocationService(nodeSettings, new DelayedShardsMockGatewayAllocator());
        long clusterChangeEventTimestampNanos = nodeLeftTimestampNanos + delayUntilClusterChangeEvent;
        assertNull(delayedAllocationService.delayedRerouteTask.get());
        clusterState = allocationService.reroute(clusterState, "reroute");
            )
import static org.mockito.Mockito.eq;
            return null;
import org.opensearch.cluster.node.DiscoveryNodes;
 *     http://www.apache.org/licenses/LICENSE-2.0
        long delayUntilClusterChangeEvent = TimeValue.timeValueNanos(randomInt((int) shorterDelaySetting.nanos() - 1)).nanos();
        assertEquals(1, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithDelayedShard));
                IndexMetadata.builder("test")  
                        settings(Version.CURRENT).put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), longDelaySetting)
            ClusterState stateWithShorterDelay = allocationService.disassociateDeadNodes(clusterState, true, "fake node left");  
        for (ShardRouting shardRouting : clusterState.getRoutingTable().allShards("foo")) {
        }).when(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), any(ClusterStateUpdateTask.class));
        delayedAllocationService = new TestDelayAllocationService(threadPool, clusterService, allocationService);
        assertFalse(firstDelayedRerouteTask.cancelScheduling.get());
 * Licensed to Elasticsearch under one or more contributor  
        // starting primaries
                longDelayReplica = shardRouting;
        allocationService.setNanoTimeOverride(nanoTimeForReroute);  
        verify(localClusterService).getSettings();
        @Override  
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        TimeValue delaySetting = timeValueSeconds(30);
        assertTrue(latch.await(30, TimeUnit.SECONDS));
        assertThat(  
                    .add(newNode("node2"))
                    .add(newNode("node2"))
                nodeIdOfFooReplica = shardRouting.currentNodeId();
            )
    }  
                DiscoveryNodes.builder()
        );
 * license agreements. See the NOTICE file distributed with
        // start replicas
                .build();
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);  
            firstDelayedRerouteTask.nextDelay.nanos(),  
                    .add(newNode("node1"))  
        clusterState = allocationService.disassociateDeadNodes(clusterState, true, "reroute");
                DiscoveryNodes.builder()  
        assertFalse(delayedRerouteTask.cancelScheduling.get());  
            delayedRerouteTask.nextDelay.nanos(),  
        DelayedAllocationService.DelayedRerouteTask secondDelayedRerouteTask = delayedAllocationService.delayedRerouteTask.get();
        assertTrue(latch2.await(30, TimeUnit.SECONDS));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(nodeId)).build();
        assertThat(secondDelayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);  
                    .numberOfReplicas(1)  
        nanoTimeForReroute = clusterChangeEventTimestampNanos + longDelaySetting.nanos() + timeValueMillis(randomInt(50)).nanos();
 * Unless required by applicable law or agreed to in writing,
        clusterState = allocationService.disassociateDeadNodes(clusterState, true, "fake node left");
            .build();
        delayedAllocationService.setNanoTimeOverride(nanoTimeForReroute + timeValueMillis(randomInt(50)).nanos());  
            if (shardRouting.primary() == false) {
                break;  
                    .add(newNode("node3"))
        assertThat(
        private volatile long nanoTimeOverride = -1L;  
        when(localClusterService.getSettings()).thenReturn(nodeSettings);  
        final long nodeLeftTimestampNanos = System.nanoTime();
            new ClusterChangedEvent(CLUSTER_UPDATE_TASK_SOURCE, stateWithNoDelayedShards, stateWithOnlyOneDelayedShard)
                .nodes(DiscoveryNodes.builder(stateWithDelayedShard.nodes()).remove(nodeIdOfBarReplica))
            new ClusterChangedEvent(CLUSTER_UPDATE_TASK_SOURCE, stateWithOnlyOneDelayedShard, stateWithDelayedShards)
        assertFalse(secondDelayedRerouteTask.cancelScheduling.get());
                    stateWithOnlyOneDelayedShard.metadata().settings()  
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
        verifyNoMoreInteractions(clusterService);
        assertNull(delayedAllocationService.delayedRerouteTask.get());
        String nodeIdOfFooReplica = null;
            delayedRerouteTask.nextDelay.nanos(),
        assertThat(firstDelayedRerouteTask.baseTimestampNanos, equalTo(clusterChangeEventTimestampNanos));  
        doAnswer(invocationOnMock -> {  
        );  
        }
                    .add(newNode("node4"))  
            secondDelayedRerouteTask.nextDelay.nanos(),
        String nodeId = null;
                    )
        TimeValue shortDelaySetting = timeValueMillis(100);  
            .put(NodeRoles.clusterManagerOnlyNode())
                    .settings(
            equalTo(delaySetting.nanos() - (clusterChangeEventTimestampNanos - baseTimestampNanos))  
    public void testDelayedUnassignedScheduleReroute() throws Exception {  
        assertNotNull(shorterDelayedRerouteTask);  
            );
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(baseTimestampNanos, delayedShard.unassignedInfo().getUnassignedTimeInNanos());
        assertEquals(1, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithDelayedShard));
        assertFalse("no shards should be unassigned", clusterState.getRoutingNodes().unassigned().size() > 0);  
            clusterState = ClusterState.builder(stateWithDelayedShard)  
        }
            // remove node that has replica and reroute
    public void testDelayedUnassignedScheduleRerouteUsesNodeLevelClusterDefault() throws Exception {
        clusterState = ClusterState.builder(clusterState)
                .build();
        clusterState = ClusterState.builder(clusterState)  
        ClusterState beforeNodeLeft = clusterState;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).localNodeId("node1").clusterManagerNodeId("node1"))
            assertNotNull(nodeIdOfBarReplica);  
            equalTo(delaySetting.nanos() - (clusterChangeEventTimestampNanos - nodeLeftTimestampNanos))
            delayedRerouteTask.nextDelay.nanos(),
            latch2.countDown();
        }).when(clusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), any(ClusterStateUpdateTask.class));
        Metadata metadata = Metadata.builder()
            .metadata(metadata)
        // allocate shards
                IndexMetadata.builder("foo")  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).localNodeId("node1").clusterManagerNodeId("node1"))  
        // starting replicas
        ClusterState stateWithOnlyOneDelayedShard = clusterStateUpdateTask1.get().execute(stateWithDelayedShards);  
import static org.mockito.Mockito.doAnswer;  
        if (nodeAvailableForAllocation) {
        // mock ClusterService.submitStateUpdateTask() method again  
        for (ShardRouting shardRouting : clusterState.getRoutingTable().allShards("test")) {  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
        // check that submitStateUpdateTask() was invoked on the cluster service mock
import static org.mockito.Mockito.when;
                )  
        } else {
    @After
        DelayedAllocationService.DelayedRerouteTask firstDelayedRerouteTask = delayedAllocationService.delayedRerouteTask.get();  
            // update settings with shorter delay
            clusterStateUpdateTask1.set((ClusterStateUpdateTask) invocationOnMock.getArguments()[1]);
            latch.countDown();
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            .build();  
    }
        ClusterState stateWithNoDelayedShards = clusterStateUpdateTask2.get().execute(stateWithOnlyOneDelayedShard);
                    )  
        clusterState = allocationService.reroute(clusterState, "reroute");
import org.opensearch.common.settings.Settings;
                    .numberOfShards(1)
        ClusterState stateWithDelayedShard = clusterState;  
/*  
            .put(  
        }  
            )
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("foo")).addAsNew(metadata.index("bar")).build())
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes()).remove("node2");  
        allocationService.setNanoTimeOverride(nanoTimeForReroute);
    private ClusterService clusterService;
            assertThat(unassignedShards.size(), equalTo(0));
        assertFalse(delayedRerouteTask.cancelScheduling.get());
            clusterStateUpdateTask2.set((ClusterStateUpdateTask) invocationOnMock.getArguments()[1]);
        // check that no new task is scheduled
            .nodes(
            clusterStateUpdateTask.set((ClusterStateUpdateTask) invocationOnMock.getArguments()[1]);
        long nanoTimeForReroute = clusterChangeEventTimestampNanos + delaySetting.nanos() + timeValueMillis(randomInt(200)).nanos();
        }
        CountDownLatch latch1 = new CountDownLatch(1);
            // node leaves with replica shard of index bar that has shorter delay
        // starting primaries
        ClusterState stateWithDelayedShard = clusterState;  
            localAllocationService
        AtomicReference<ClusterStateUpdateTask> clusterStateUpdateTask1 = new AtomicReference<>();  
            .build();
 * the Apache License, Version 2.0 (the "License"); you may
        assertNull(delayedAllocationService.delayedRerouteTask.get());  
import org.opensearch.cluster.ClusterName;  
            .build();
import org.opensearch.cluster.service.ClusterService;  
            return nanoTimeOverride == -1L ? super.currentNanoTime() : nanoTimeOverride;
        assertNotNull(nodeIdOfFooReplica);
            delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);
            super(threadPool, clusterService, allocationService);  
        long delayUntilClusterChangeEvent = TimeValue.timeValueNanos(randomInt((int) shortDelaySetting.nanos() - 1)).nanos();
            )  
        verify(clusterService).getSettings();
        TimeValue delaySetting = timeValueMillis(100);
        );
            equalTo(
        final List<ShardRouting> allShards = clusterState.getRoutingTable().allShards("test");
        assertNull(delayedAllocationService.delayedRerouteTask.get());  
            .put(
        assertTrue(delayedRerouteTask.cancelScheduling.get()); // existing task was cancelled
        }
            equalTo(longDelaySetting.nanos() - (clusterChangeEventTimestampNanos - baseTimestampNanos))  
        clusterState = allocationService.reroute(clusterState, "reroute");
        // check that submitStateUpdateTask() was invoked on the cluster service mock  
                            Settings.builder()
        allocationService.setNanoTimeOverride(baseTimestampNanos);  
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);  
        // apply cluster state
        assertThat(
import org.junit.After;  
        assertTrue(latch.await(30, TimeUnit.SECONDS));
                    .numberOfShards(1)
            )
import org.opensearch.cluster.ClusterStateUpdateTask;
        // find replica of long_delay
        // remove node that has replica and reroute  
            .build();  
        DelayedAllocationService.DelayedRerouteTask delayedRerouteTask = delayedAllocationService.delayedRerouteTask.get();
                )
        // check that task is now removed
                    break;  
        verify(clusterService).addListener(delayedAllocationService);  
            this.nanoTimeOverride = nanoTime;  
        clusterService = mock(ClusterService.class);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        // advance the time on the allocation service to a timestamp that happened after the delayed scheduling
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
    private ThreadPool threadPool;  
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(nodeIdOfFooReplica))  
            assertThat(unassignedShards.size(), equalTo(1));  
        }).when(localClusterService).submitStateUpdateTask(eq(CLUSTER_UPDATE_TASK_SOURCE), any(ClusterStateUpdateTask.class));
            delayedAllocationService.clusterChanged(  
                    stateWithOnlyOneDelayedShard,
                break;
        allocationService.setNanoTimeOverride(nodeLeftTimestampNanos);  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            }  
                    .localNodeId("node1")
                    .add(newNode("node3"))  
import java.util.concurrent.CountDownLatch;
                        )
            }
        // check that task is now removed
                UnassignedInfo.findNextDelayedAllocation(  
        clusterState = allocationService.disassociateDeadNodes(clusterState, true, "reroute");  
        delayedAllocationService.setNanoTimeOverride(clusterChangeEventTimestampNanos);  
                    .add(newNode("node1"))
        clusterState = startInitializingShardsAndReroute(localAllocationService, clusterState);
        assertEquals(1, UnassignedInfo.getNumberOfDelayedUnassigned(stateWithOnlyOneDelayedShard));
        // starting replicas
        // check that no further cluster state update was submitted  
 * not use this file except in compliance with the License.
                    stateWithDelayedShards,  
        } else {  
                    .localNodeId("node0")
        for (ShardRouting shardRouting : clusterState.getRoutingTable().allShards("long_delay")) {  
        ShardRouting delayedShard = stateWithDelayedShard.getRoutingNodes().unassigned().iterator().next();  
        // remove node of shortDelayReplica and node of longDelayReplica and reroute
import java.util.concurrent.TimeUnit;
            .metadata(metadata)  
/*
        assertFalse(shorterDelayedRerouteTask.cancelScheduling.get());  
            )  
            latch.countDown();
        ClusterState prevState = clusterState;
        final long baseTimestampNanos = System.nanoTime();
        Metadata metadata = Metadata.builder()
        long clusterChangeEventTimestampNanos = baseTimestampNanos + delayUntilClusterChangeEvent;
        clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
        delayedAllocationService.clusterChanged(
                    .clusterManagerNodeId("node1")
