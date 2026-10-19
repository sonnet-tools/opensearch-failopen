            .metadata(metadata)
            .put(IndexMetadata.INDEX_REMOTE_STORE_AUTO_RESTORE_ENABLED_SETTING.getKey(), true)
        String allocId1 = randomAlphaOfLength(10);
    /**
     * delay marker set at node-left is live, the conversion is declined so a bouncing node can rejoin and reclaim  
            true,  
     * Tests that when restoring from a snapshot and we don't know the shard size yet, the shard will remain in  
            allocId2,
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
        }
        testAllocator.addData(node1, "allocId1", randomBoolean());
        );  
        );
                return shardSize;  
            allocation.routingNodes().unassigned().ignored().get(0).recoverySource().getType(),
        public TestAllocator addData(  
        RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(deciders, CLUSTER_RECOVERED, "allocId1");  
    }
        assertThat(
        assertThat(  
    public void testAutoRestoreSkipsClosedIndex() {
            allocId1,  
            equalTo(node1.getId())
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),  
            Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
            Arrays.asList(
        testAllocator.addData(node2, allocId2, false, new ReplicationCheckpoint(shardId, 20, 120, 2, Codec.getDefault().getName()));
    /**  
import org.opensearch.cluster.routing.RoutingNodes;  
        boolean node1HasPrimaryShard = randomBoolean();  
            noAllocationDeciders(),  
        // whatever routing shape a closed index takes, no shard may have been converted to a remote-store recovery
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));  
     */  
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        );
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
        assertThat(converted.recoverySource().getType(), equalTo(RecoverySource.Type.REMOTE_STORE));
     */
            yesAllocationDeciders(),
            @Override
        assertThat(allocation.routingNodes().unassigned().iterator().next().shardId(), equalTo(shardId));
            yesAllocationDeciders(),
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
            CLUSTER_RECOVERED,
    }
                primary,  
                allocationId,
import java.util.HashMap;  
        );
            randomFrom(INDEX_CREATED, CLUSTER_RECOVERED, INDEX_REOPENED)  
            allocId1,
    /**  
    }  
    }  
     * expiry, after which the conversion proceeds (the cleared-flag path is what
     * Tests that when the node returns a ShardLockObtainFailedException, it will be considered as a valid shard copy
     * force the allocation to it.
    public void testRestoreForcesAllocateIfShardAvailable() {
        testAllocator.addData(node1, null, randomBoolean());  
            .build();
            CLUSTER_RECOVERED,  
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(  
import org.opensearch.cluster.ClusterName;
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
                // the TestAllocateDecision's decision for force allocating is to THROTTLE (using
     * index-creation time.
        };  
            equalTo(RecoverySource.Type.EXISTING_STORE)  
            allocId3
    }
        final RoutingAllocation allocation = new RoutingAllocation(
import org.opensearch.cluster.routing.ShardRouting;
            .put(
import org.opensearch.index.codec.CodecService;  
                    .putInSyncAllocationIds(shardId.id(), Sets.newHashSet("in-sync-id"))
        testAllocator.addData(node3, allocId3, false, new ReplicationCheckpoint(shardId, 20, 120, 2, Codec.getDefault().getName()));
        testAllocator.addData(node1, "allocId1", randomBoolean());
        }
        String allocId3 = randomAlphaOfLength(10);  
        String allocId3 = randomAlphaOfLength(10);  
    public void testAutoRestoreConvertsNoValidShardCopyToRemoteStoreRecovery() {
        );  
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                // the allocator will see if it can force assign the primary, where the decision will be either NO or THROTTLE,
package org.opensearch.gateway;
 */  
        // The unassigned primary exactly as disassociateDeadNodes leaves it when the index carries a non-zero
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));  
import org.apache.lucene.index.CorruptIndexException;
            randomFrom(CLUSTER_RECOVERED, INDEX_REOPENED),
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
     */
        );
        assertThat(ClusterShardHealth.getInactivePrimaryHealth(converted), equalTo(org.opensearch.cluster.health.ClusterHealthStatus.RED));
     * REMOTE_STORE recovery source, and deliberately stays RED while it hydrates (a restoring primary cannot serve
            equalTo(allocId2)
    public void testOutOfSyncHighestRepCheckpointIsIgnored() {  
    }
import org.opensearch.Version;  
}
 * The OpenSearch Contributors require contributions made to  
            .build();
            yesAllocationDeciders(),
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        assertThat(allocation.routingNodes().unassigned().ignored(), empty());
            equalTo(allocId1)  
import org.opensearch.indices.replication.common.ReplicationType;
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
import org.opensearch.common.Nullable;
            .addAsRestore(  
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        public TestAllocator addData(DiscoveryNode node, String allocationId, boolean primary) {  
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(  
        assertThat(allocation.routingNodesChanged(), equalTo(true));
                new SnapshotRecoverySource(
        testAllocator.addData(node1, allocId1, false, new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()));
                    .state(indexState)  
        );  
    /**
    /**  
        String allocId2 = randomAlphaOfLength(10);
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        testAllocator.addData(node2, node1HasPrimaryShard ? replicaAllocId : primaryAllocId, !node1HasPrimaryShard);
                // the allocator will see if it can force assign the primary, and in this case,
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
            CLUSTER_RECOVERED,  
                // so the shard will remain un-initialized
    }
        ShardRouting ignoredRouting = allocation.routingNodes().unassigned().ignored().get(0);  
import java.util.List;
                        allocationId,  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
     * Tests that when there is a node to allocate to, but it is throttling (and it is the only one),
 * under the License.  
            autoRestoreEligibleSettings(),
import org.opensearch.cluster.routing.IndexRoutingTable;
                IndexMetadata.builder(shardId.getIndexName())
     */
                        storeException  
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),  
        assertThat(
            .build();
    /**  
        RoutingTable routingTable = RoutingTable.builder()
                    put(shardId, Collections.<String>emptySet());
            .build();
    public void testNoProcessPrimaryNotAllocatedBefore() {
     */  
     */  
        String allocId3 = randomAlphaOfLength(10);  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
     * its local copy. Prevention is the primary's only protection today - the rejoin cancellation machinery
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
                    .putInSyncAllocationIds(shardId.id(), Sets.newHashSet(activeAllocationIds))  
        );
 * not use this file except in compliance with the License.
        public TestAllocator addData(  
     * Tests that null ReplicationCheckpoint are ignored
            boolean primary,  
        // Assert node3's allocation id should be used as it was previous primary
        assertThat(initializingShards.size(), equalTo(1));
    private RoutingAllocation routingAllocationWithOnePrimaryNoReplicas(
                new TestAllocateDecision(Decision.THROTTLE),
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(  
            "allocId"  
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        );  
     * Tests that when the nodes with prior copies of the given shard all return a decision of NO, but  
     */  
                    .numberOfShards(1)
            IndexMetadata.State.OPEN,  
 * You may obtain a copy of the License at  
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
            }
                    UUIDs.randomBase64UUID(),  
        assertEquals(ignored.size(), 1);
            }
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),  
            equalTo(allocId3)  
    }
    /**
        allocateAllUnassigned(allocation);  
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        String allocId1 = randomAlphaOfLength(10);
            "in-sync-id"
     * data over a transient decider, so the trigger must not fire.
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
     * A closed index acknowledges nothing and may be mid-in-place-snapshot-restore; its lifecycle operations own the
    private AllocationDecider getNoDeciderWithForceAllocate(final Decision forceAllocateDecision) {
                    Version.CURRENT,
            equalTo(allocatedNode.getId())
        final ShardRouting parked = allocation.routingNodes().unassigned().ignored().get(0);  
                break;
        }
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))  
            yesAllocationDeciders(),
    }
        testAllocator.addData(node3, allocId3, false, new ReplicationCheckpoint(shardId, 20, 120, 2, Codec.getDefault().getName()));
            assertThat(shard.recoverySource().getType(), equalTo(RecoverySource.Type.EXISTING_STORE));
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));  
            autoRestoreEligibleSettings(),
            .build();
        assertTrue(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).isEmpty());
        // starts, so YELLOW would overstate availability. It converges to GREEN without operator action.
            allocId2,
    public void testPreferAllocatingPreviousPrimaryWithLowerRepCheckpoint() {
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));  
        testAllocator.addData(node1, "some allocId", randomBoolean());
        assertThat(
            yesAllocationDeciders(),
                )
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
        allocateAllUnassigned(allocation);
    }  
        assertThat(
        allocateAllUnassigned(allocation);
            .metadata(metadata)  
                // since both deciders here return a NO decision for allocating a shard,  
            allocId1,
        final Settings withoutAutoRestore = Settings.builder()
                System.nanoTime(),
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
        assertThat(allocation.routingNodes().unassigned().size(), equalTo(1));
    public void testShardLockObtainFailedException() {
     */  
        testAllocator.addData(node3, allocId3, false, new ReplicationCheckpoint(shardId, 40, 120, 2, Codec.getDefault().getName()));
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
        }
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),  
    /**  
     * it will be moved to ignore unassigned.  
     * {@link IndexMetadata} directly bypasses registered setting validators, which is deliberate: it lets the  
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(deciders, CLUSTER_RECOVERED, "allocId1");
            CLUSTER_RECOVERED,  
        public TestAllocator clear() {
        final ShardRouting converted = allocation.routingNodes().unassigned().iterator().next();  
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));  
    /**
        assertThat(
     */
                    .numberOfReplicas(0)  
    }  
        testAllocator.addData(node1, allocId1, false, null, null);
        assertThat(
            if (data == null) {
        assertThat(initializingShards.get(0).getExpectedShardSize(), equalTo(shardSize));
    public void testRestoreDoesNotAssignIfNoShardAvailable() {
        List<ShardRouting> ignored = allocation.routingNodes().unassigned().ignored();
            equalTo("allocId1")
    }
            equalTo(allocId3)
            CLUSTER_RECOVERED,
        );
    private static Settings autoRestoreEligibleSettings() {  
     * the unassigned list to be allocated later.
        assertThat(
import org.apache.lucene.codecs.Codec;
                data = new HashMap<>();
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
                assert shardRouting.primary() : "cannot force allocate a non-primary shard " + shardRouting;  
    public void testRestoreThrottle() {
    public void testPreferAllocatingPreviousPrimary() {  
            "allocId1"
            "allocId1"
    }  
        testAllocator.addData(node2, allocId2, randomBoolean());
import static org.opensearch.cluster.routing.UnassignedInfo.Reason.INDEX_REOPENED;  
        ClusterStateHealth clusterStateHealth = new ClusterStateHealth(clusterState);
        assertThat(ignoredRouting.unassignedInfo().getLastAllocationStatus(), equalTo(AllocationStatus.FETCHING_SHARD_DATA));
     * Tests that when restoring from a snapshot and we find a node with a shard copy but allocation
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),  
import org.opensearch.snapshots.Snapshot;
     * Without index.remote_store.auto_restore.enabled the trigger stays off: the shard parks at NO_VALID_SHARD_COPY  
 * ownership. Elasticsearch licenses this file to you under  
                )
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
            equalTo(allocId2)
            CLUSTER_RECOVERED,
/*  
     * Tests that when one node returns a ShardLockObtainFailedException and another properly loads the store, it will  
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
        // check that allocation id is reused
        allocateAllUnassigned(allocation);
        allocateAllUnassigned(allocation);
                primary,  
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
    /**
/*
            case CLUSTER_RECOVERED:  
        final Settings unfenced = Settings.builder()
        assertThat(  
import java.util.Map;
            equalTo(allocId2)
        );
            allocId2
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        assertThat(parked.recoverySource().getType(), equalTo(RecoverySource.Type.EXISTING_STORE));
            data = null;
        assertThat(
            equalTo(node2.getId())
     * the unassigned list to be allocated later.
                    .numberOfReplicas(0)
     * Tests that when restoring from a snapshot and we find a node with a shard copy and allocation
        while (iterator.hasNext()) {
        assertThat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            equalTo(RecoverySource.Type.EXISTING_STORE)  
        testAllocator.addData(node1, "stale-id", randomBoolean());
import org.opensearch.env.ShardLockObtainFailedException;
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        switch (reason) {
            allocId2,
        String allocId2 = randomAlphaOfLength(10);
     * Tests that when the nodes with prior copies of the given shard all return a decision of NO, and  
        allocateAllUnassigned(allocation);  
            )
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
    ) {
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
        allocateAllUnassigned(allocation);
        assertThat(
        final ShardRouting delayedPrimary = ShardRouting.newUnassigned(
        String... activeAllocationIds  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.routing.RecoverySource;  
    }
        );
            Arrays.asList(
        allocateAllUnassigned(allocation);
                    snapshot,
        allocateAllUnassigned(allocation);  
                node,
import org.opensearch.core.index.shard.ShardId;
            )  
            allocation.routingNodes().unassigned().ignored().get(0).recoverySource().getType(),
     * Tests when the node returns that no data was found for it (null for allocation id),
        );  
            forceDecisionNo ? AllocationStatus.DECIDERS_NO : AllocationStatus.DECIDERS_THROTTLED
        testAllocator.addData(node3, allocId3, false, new ReplicationCheckpoint(shardId, 15, 120, 2, Codec.getDefault().getName()));  
            return addData(  
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        }, System.nanoTime());
            IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", nodeSettings);
        String... activeAllocationIds
    }
        AllocationDeciders deciders,  
            .put(IndexMetadata.INDEX_REMOTE_STORE_AUTO_RESTORE_ENABLED_SETTING.getKey(), true)
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        RoutingNodes newRoutingNodes = allocation.routingNodes();
    /**
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
                    .numberOfShards(1)
        final List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);  
                    .state(IndexMetadata.State.OPEN)
        RoutingAllocation allocation = getRestoreRoutingAllocation(yesAllocationDeciders(), randomNonNegativeLong(), "allocId");
     * {@code AllocationService#removeDelayMarkers} on the reroute {@code DelayedAllocationService} schedules at
            throttleAllocationDeciders(),  
        testAllocator.addData(node1, "stale-id", randomBoolean());
    private TestAllocator testAllocator;
            Arrays.asList(
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
    }
            "allocId"
     */  
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
        assertThat(converted.unassignedInfo().getNumFailedAllocations(), equalTo(0));
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        );
        private Map<DiscoveryNode, TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> data;
        testAllocator.addData(node3, allocId3, true, null, null);
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)  
                true,  
        String allocId3 = randomAlphaOfLength(10);  
            .put(
     */
            CLUSTER_RECOVERED,
        // check that allocation id is reused  
        RoutingAllocation allocation = getRestoreRoutingAllocation(yesAllocationDeciders(), randomLong(), "allocId");  
        );
                node,
            null,
            )
    private final DiscoveryNode node2 = newNode("node2");  
        String allocId1 = randomAlphaOfLength(10);
    private final DiscoveryNode node1 = newNode("node1");
            .add(IndexRoutingTable.builder(shardId.getIndex()).addShard(delayedPrimary))  
        assertThat(allocation.routingNodesChanged(), equalTo(true));
                allocationId,
                    .settings(settings(Version.CURRENT).put(autoRestoreEligibleSettings()))  
        final RoutingTable newRoutingTable = new RoutingTable.Builder().updateNodes(oldRoutingTable.version(), newRoutingNodes).build();
    }
        );
                null,
     */
 * software distributed under the License is distributed on an
    }
            equalTo(node3.getId())
        allocateAllUnassigned(allocation);  
        allocateAllUnassigned(allocation);
        testAllocator.addData(node1, "allocId1", randomBoolean());  
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
     * Tests that when async fetch returns that there is no data, the shard will not be allocated.
        assertThat(allocation.routingNodes().unassigned().size(), equalTo(1));
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
    private final ShardId shardId = new ShardId("test", "_na_", 0);
     * validator refuses that combination at creation time, but the allocator does not get to assume it), the trigger  
        String allocId1 = randomAlphaOfLength(10);
        return getNoDeciderWithForceAllocate(Decision.YES);  
        final long shardSize = randomNonNegativeLong();  
                        primary,
                // since we have a NO decision for allocating a shard (because the second decider returns a NO decision),  
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
            CLUSTER_RECOVERED,
     * The trigger honors the node-left grace window ({@code index.unassigned.node_left.delayed_timeout}): while the
            return this;
    public void testFoundAllocationAndAllocating() {  
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        );  
            CLUSTER_RECOVERED,  
        );  
        assertThat(
            "in-sync-id"
    private AllocationDecider getNoDeciderThatDeniesForceAllocate() {
 * Modifications Copyright OpenSearch Contributors. See
            CLUSTER_RECOVERED,  
        );  
        );
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
     * {@link #testAutoRestoreConvertsNoValidShardCopyToRemoteStoreRecovery} exercises).  
import org.opensearch.index.IndexSettings;
        );
            CLUSTER_RECOVERED,
            autoRestoreEligibleSettings(),
     */
     * stays in the unassigned list (the shards allocator places it later in the same round), carries a fresh  
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
        return getNoDeciderWithForceAllocate(Decision.THROTTLE);
            equalTo(RecoverySource.Type.EXISTING_STORE)
        for (ShardRouting shard : allocation.routingNodes().unassigned().ignored()) {  
import static org.opensearch.cluster.routing.UnassignedInfo.Reason.INDEX_CREATED;
                forceDecisionNo ? getNoDeciderThatDeniesForceAllocate() : getNoDeciderThatThrottlesForceAllocate()
        allocateAllUnassigned(allocation);
            allocId2,
        assertThat(clusterStateHealth.getStatus().ordinal(), lessThanOrEqualTo(expectedStatus.ordinal()));
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        ) {  
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
     * ({@code ReplicaShardAllocator#processExistingRecoveries}) covers replicas only, since historically an
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
        String allocId1 = randomAlphaOfLength(10);
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        protected AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> fetchData(
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        allocateAllUnassigned(allocation);
            primaryAllocId,  
        testAllocator.addData(node1, "id1", randomBoolean());
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),  
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));  
        );
        // Assert node2's allocation id is used
     * initializing primary WAS the only copy and there was nothing to cancel in favor of. The flag is cleared by  
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(false));  
import org.opensearch.cluster.routing.UnassignedInfo;
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
        Metadata metadata = Metadata.builder()  
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
     * Fixture variant taking extra index settings and an index state, for the auto-restore trigger tests. Building
                    .numberOfReplicas(0)
            new RoutingNodes(state, false),  
    /**
     * The defensive fencing guard: even if index metadata carries auto_restore=true without fencing (the setting
    /**  
            CLUSTER_RECOVERED,
    }
        assertTrue(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).isEmpty());  
import org.opensearch.common.util.set.Sets;
        final Snapshot snapshot = new Snapshot("test", new SnapshotId("test", UUIDs.randomBase64UUID()));
            .put(  
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
            equalTo(node2.getId())
            DiscoveryNode node,
    private RoutingAllocation getRestoreRoutingAllocation(AllocationDeciders allocationDeciders, Long shardSize, String... allocIds) {
            state,
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
    private void allocateAllUnassigned(final RoutingAllocation allocation) {  
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        );
     * Tests that replica with highest primary ter version will be selected as target
        testAllocator.addData(node2, allocId2, false);  
        );
        assertThat(  
    }
                {
        assertEquals(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), 1);
            allocId3  
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
        }
            IndexMetadata.State.OPEN,
    public void testPreferReplicaWithHighestSegmentInfoVersion() {  
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
    /**
     * Tests that when the nodes with prior copies of the given shard return a THROTTLE decision,
            @Override
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
            .build();
        testAllocator.addData(node1, "allocId1", randomBoolean());  
        testAllocator.addData(node1, "stale-id", randomBoolean());  
                node,
            equalTo(node3.getId())
            .routingTable(routingTable)
     * defensive fencing guard in the allocator be exercised with combinations the validator would refuse at
        allocateAllUnassigned(allocation);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        // with old version, we can't know if a shard was allocated before or not  
        // Health deliberately stays RED while the restore hydrates: the primary cannot serve queries until it  
    /**
            yesAllocationDeciders(),
        testAllocator.addData(node1, allocId1, false, new ReplicationCheckpoint(shardId, 10, 101, 1, Codec.getDefault().getName()));
            allocId1,
public class PrimaryShardAllocatorTests extends OpenSearchAllocationTestCase {
    private AllocationDecider getNoDeciderThatThrottlesForceAllocate() {  
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
            allocId2,
        assertEquals(ignored.get(0).unassignedInfo().getLastAllocationStatus(), AllocationStatus.DECIDERS_THROTTLED);
        String allocId2 = randomAlphaOfLength(10);
            );  
     */
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
            equalTo(node1.getId())
        allocateAllUnassigned(allocation);
        allocateAllUnassigned(allocation);
     * Tests that when restoring from a snapshot and we find a node with a shard copy and allocation
import org.opensearch.cluster.routing.ShardRoutingState;  
    private RoutingAllocation routingAllocationWithOnePrimaryNoReplicas(
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
    }  
        allocateAllUnassigned(allocation);
        AllocationDeciders deciders = new AllocationDeciders(
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
                break;
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
            equalTo(node3.getId())
            IndexMetadata.State.OPEN,
 *  
        String primaryAllocId = UUIDs.randomBase64UUID();
            RoutingAllocation allocation
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
            }  
    /**  
            null,  
            replicaAllocId
            shardId,
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(  
    /**
        allocateAllUnassigned(allocation);
            unfenced,  
        AllocationDeciders deciders = new AllocationDeciders(
import static org.hamcrest.Matchers.empty;
            @Nullable Exception storeException
                IndexMetadata.builder(shardId.getIndexName())
            return addData(  
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
        allocateAllUnassigned(allocation);
        // Assert node3's allocation id should be used as it has highest replication checkpoint
 */  
        testAllocator.addData(node1, "some allocId", randomBoolean());
            .put(IndexMetadata.INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING.getKey(), true)
     * Tests that when there is a node to be allocated to, but it the decider said "no", we still
                0,  
                getNoDeciderThatAllowsForceAllocate()  
    private final DiscoveryNode node3 = newNode("node3");
        assertThat(  
        );
        allocateAllUnassigned(allocation);
     */  
        testAllocator.addData(node1, null, randomBoolean());
     * Tests when the node returns data with a shard allocation id that does not match active allocation ids, it will be moved to ignore
                new TestAllocateDecision(randomBoolean() ? Decision.YES : Decision.NO),
            .routingTable(routingTableBuilder.build())
        testAllocator.addData(node1, "allocId1", randomBoolean());
import java.util.Collections;
        testAllocator.addData(node1, allocId1, false, new ReplicationCheckpoint(shardId, 10, 101, 1, Codec.getDefault().getName()));
        boolean forceDecisionNo = randomBoolean();  
            CLUSTER_RECOVERED,
     * deciders say no, we still allocate to that node.  
        );
            randomFrom(CLUSTER_RECOVERED, INDEX_REOPENED),  
     */
            .build();  
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        );
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
    }  
                return forceAllocateDecision;
            .build();  
                    node,
        List<ShardRouting> ignored = allocation.routingNodes().unassigned().ignored();  
            public Long getShardSize(ShardRouting shardRouting) {
        IndexMetadata.State indexState,
        }
                // the default behavior) so despite the other decider's decision to return YES for  
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
    public void testShardLockObtainFailedExceptionPreferOtherValidCopies() {  
import static org.opensearch.cluster.routing.UnassignedInfo.Reason.CLUSTER_RECOVERED;
        // a valid in-sync copy exists; the deciders refuse to place it
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        );  
 * Licensed to Elasticsearch under one or more contributor  
        @Override
        String allocId3 = randomAlphaOfLength(10);
 * SPDX-License-Identifier: Apache-2.0
    public void testForceAllocatePrimary() {
     */
            yesAllocationDeciders(),  
        allocateAllUnassigned(allocation);  
            );  
        testAllocator.addData(node2, allocId2, false, new ReplicationCheckpoint(shardId, 20, 120, 2, Codec.getDefault().getName()));
        final Metadata metadata = Metadata.builder()  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));  
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
        return getNoDeciderWithForceAllocate(Decision.NO);
        // Assert node1's allocation id is used with highest replication checkpoint  
     */
                UnassignedInfo.Reason.NODE_LEFT,  
            IndexMetadata.State.OPEN,
        assertThat(
            yesAllocationDeciders(),
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),  
            CLUSTER_RECOVERED,
     */
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(false));
                    new TransportNodesGatewayStartedShardHelper.GatewayStartedShard(
 * compatible open source license.
            public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        String allocId1 = randomAlphaOfLength(10);
    public void testFoundAllocationButThrottlingDecider() {
        String allocId2 = randomAlphaOfLength(10);
    public void testDontAllocateOnNoOrThrottleForceAllocationDecision() {
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
    }
                ReplicationCheckpoint.empty(shardId, new CodecService(null, indexSettings, null, List.of()).codec("default").getName()),
        AllocationDeciders deciders,
    }  
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
            boolean primary,  
        ) {
import org.opensearch.test.IndexSettingsModule;
    /**  
    public void testRestore() {
        );
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
        RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(yesAllocationDeciders(), CLUSTER_RECOVERED, "id2");  
     */  
        assertThat(allocation.routingNodes().unassigned().size(), equalTo(1));
        // Assert node2's allocation id is used
        return new RoutingAllocation(deciders, new RoutingNodes(state, false), state, null, null, System.nanoTime());
        Metadata metadata = Metadata.builder()
            return this;  
                break;
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
import org.opensearch.cluster.routing.allocation.decider.Decision;  
        testAllocator.addData(node2, allocId2, false, null, null);  
        return new RoutingAllocation(allocationDeciders, new RoutingNodes(state, false), state, null, new SnapshotShardSizeInfo(Map.of()) {  
    public void testPreferReplicaWithHighestPrimaryTerm() {  
        return new TestAllocateDecision(Decision.NO) {  
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
            equalTo("allocId1")  
     * The auto-restore trigger: a fenced, auto-restore-enabled remote index whose primary has no valid copy on any
     */
import org.opensearch.cluster.health.ClusterHealthStatus;
    /**  
        );  
            CLUSTER_RECOVERED,
        allocateAllUnassigned(allocation);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        String allocId3 = randomAlphaOfLength(10);  
        assertEquals(  
    public void testAutoRestoreSkipsDecidersNo() {  
            allocation.routingNodes().unassigned().ignored().get(0).recoverySource().getType(),
        AllocationDeciders deciders = new AllocationDeciders(  
        // delayed_timeout: NODE_LEFT with a live delay marker. (Constructed directly because ShardRouting forbids
            equalTo(node2.getId())
        );
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        assertThat(  
import org.opensearch.snapshots.SnapshotId;
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        testAllocator.addData(node3, allocId3, false, new ReplicationCheckpoint(shardId, 15, 120, 2, Codec.getDefault().getName()));  
     * deciders say throttle, we add it to ignored shards.
    public void testPreferReplicaWithNullReplicationCheckpoint() {  
        String allocId2 = randomAlphaOfLength(10);
            });
     * {@link AllocationDecider#canForceAllocatePrimary(ShardRouting, RoutingNode, RoutingAllocation)}
    public void testFoundAllocationButNoDecider() {
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
     * Tests that replica with the highest primary term version will be selected as target
import org.opensearch.repositories.IndexId;  
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));  
    public void buildTestAllocator() {
     * deciders say yes, we allocate to that node.  
                ReplicationCheckpoint.empty(shardId, new CodecService(null, indexSettings, null, List.of()).codec("default").getName()),
     * Tests that when there was a node that previously had the primary, it will be allocated to that same node again.
            .build();
            allocId1,
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));  
        );
            .routingTable(routingTable)  
        final ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
     */
import org.opensearch.cluster.routing.RoutingNode;
                // force allocating the shard, we still THROTTLE due to the decision from TestAllocateDecision
        allocateAllUnassigned(allocation);
        // Assert node3's allocation id is used  
        allocateAllUnassigned(allocation);
            ShardRouting shard,  
import org.junit.Before;
            yesAllocationDeciders(),  
    }
            )
        testAllocator.addData(node1, "allocId1", randomBoolean(), new CorruptIndexException("test", "test"));
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
import org.opensearch.cluster.health.ClusterShardHealth;
import org.opensearch.cluster.node.DiscoveryNodes;
                routingTableBuilder.addAsNew(metadata.index(shardId.getIndex()));
        Settings extraIndexSettings,
     */  
        );  
        );  
            yesAllocationDeciders(),
 * license agreements. See the NOTICE file distributed with
            "allocId1"
            String allocationId,
     * queries), converging to GREEN without operator action - the improvement is convergence, not the color.
    /**
        );
    }
     * returns a NO or THROTTLE decision for a node, then we do not force allocate to that node.
        allocateAllUnassigned(allocation);
            case INDEX_REOPENED:  
import static org.hamcrest.Matchers.equalTo;
            allocId3  
        );
                routingTableBuilder.addAsRecovery(metadata.index(shardId.getIndex()));
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        );
                "node_left [node1]",
import java.util.Arrays;
     * returns a YES decision for at least one of those NO nodes, then we force allocate to one of them
import org.opensearch.cluster.health.ClusterStateHealth;  
            Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
     * Tests that prefer allocation of replica at lower checkpoint but in sync set
        }
            yesAllocationDeciders(),
        testAllocator.addData(node1, "in-sync-id", randomBoolean());  
import org.opensearch.common.UUIDs;
            .build();  
    }
                    .numberOfShards(1)
     * {@link AllocationDecider#canForceAllocatePrimary(ShardRouting, RoutingNode, RoutingAllocation)}
            yesAllocationDeciders(),  
            new AllocationDeciders(Arrays.asList(getNoDeciderThatDeniesForceAllocate())),
        RoutingTable oldRoutingTable = allocation.routingTable();  
        assertThat(
    public void testNoAllocationFound() {
     * Tests that when there is a node to allocate the shard to, it will be allocated to it.
            IndexMetadata.State.CLOSE,  
    }
    /**
                    .settings(settings(Version.CURRENT).put(extraIndexSettings))
        // the only copy the fetch finds carries an allocation id that is not in-sync: no valid copy anywhere  
    }  
     * Tests that prefer allocation of older primary over replica with higher replication checkpoint  
        );  
        final RoutingAllocation allocation;
    }
                System.currentTimeMillis(),
     */
     * it will be moved to ignore unassigned until it can be allocated to.
    /**
 * this work for additional information regarding copyright
        RoutingAllocation allocation = getRestoreRoutingAllocation(throttleAllocationDeciders(), randomLong(), "allocId");
        testAllocator.addData(node1, allocId1, randomBoolean(), new ShardLockObtainFailedException(shardId, "test"));  
        testAllocator.addData(node2, allocId2, false, new ReplicationCheckpoint(shardId, 22, 120, 2, Codec.getDefault().getName()));  
        assertThat(
        // check that allocation id is reused
import org.opensearch.cluster.routing.RoutingTable;
            )
                        replicationCheckpoint,
        RoutingAllocation allocation = getRestoreRoutingAllocation(yesAllocationDeciders(), null, "allocId");
            return new AsyncShardFetch.FetchResult<>(data, new HashMap<>() {  
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
        allocateAllUnassigned(allocation);
            yesAllocationDeciders(),
     * then we do not force allocate to that node but instead throttle.  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test-cluster")).routingTable(newRoutingTable).build();  
            case INDEX_CREATED:  
        String allocId2 = randomAlphaOfLength(10);
        String allocId2 = randomAlphaOfLength(10);
        );  
        RoutingAllocation allocation = getRestoreRoutingAllocation(noAllocationDeciders(), shardSize, "allocId");
                    .settings(settings(Version.CURRENT))  
                routingTableBuilder.addAsFromCloseToOpen(metadata.index(shardId.getIndex()));
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
    public void testNoAsyncFetchData() {  
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
            );  
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
            "in-sync-id"  
        assertThat(  
        allocateAllUnassigned(allocation);
     */
     * with its existing-store source, exactly as before this feature.
                // the allocator will see if it can force assign the primary, where the decision will be YES
                IndexMetadata.builder(shardId.getIndexName())
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
    class TestAllocator extends PrimaryShardAllocator {  
        testAllocator.addData(node1, allocId1, true, new ReplicationCheckpoint(shardId, 10, 101, 1, Codec.getDefault().getName()));
    public void testAutoRestoreRequiresFencing() {  
                null
            yesAllocationDeciders(),
                }  
        testAllocator.addData(node1, null, false);
                metadata.index(shardId.getIndex()),
 */
     * select the second node as target
    /**  
            yesAllocationDeciders(),
                // decider),  
/*  
        ) {
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(  
                throw new IllegalArgumentException("can't do " + reason + " for you. teach me");
    /**  
            IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", nodeSettings);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.metadata.Metadata;
            allocId1,  
        allocateAllUnassigned(allocation);
    ) {  
            testAllocator.allocateUnassigned(iterator.next(), allocation, iterator);  
        return Settings.builder()
    public void testPreferReplicaWithAllNullReplicationCheckpoint() {  
        // the non-delayed -> delayed transition via updateUnassigned.)  
import org.opensearch.common.settings.Settings;  
            yesAllocationDeciders(),
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(  
    public void testAutoRestoreWaitsOutNodeLeftDelay() {
        assertThat(allocation.routingNodesChanged(), equalTo(true));
                    )
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
            ReplicationCheckpoint replicationCheckpoint
        );
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
                new TransportNodesListGatewayStartedShards.NodeGatewayStartedShards(  
            CLUSTER_RECOVERED,
            "in-sync-id"
        assertThat(
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),  
            "in-sync-id"
     */
     */
            return addData(node, allocationId, primary, replicationCheckpoint, null);  
 * the Apache License, Version 2.0 (the "License"); you may
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
        for (ShardRouting shard : allocation.routingNodes().unassigned()) {  
    }
            ReplicationCheckpoint replicationCheckpoint,
            )
            equalTo(allocId3)
            yesAllocationDeciders(),
    }  
        UnassignedInfo.Reason reason,  
            allocId3  
            )
        testAllocator.addData(node1, allocId1, false, new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()));
        allocateAllUnassigned(allocation);
            "allocId1"  
        testAllocator.addData(node1, "allocId1", randomBoolean(), new ShardLockObtainFailedException(shardId, "test"));
            allocId3  
        assertThat(allocation.routingNodesChanged(), equalTo(false));  
            yesAllocationDeciders(),
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),  
 * GitHub history for details.
    }  
    public void testAutoRestoreRequiresAutoRestoreSetting() {  
import org.opensearch.env.Environment;  
            withoutAutoRestore,  
    private void assertClusterHealthStatus(RoutingAllocation allocation, ClusterHealthStatus expectedStatus) {
        return routingAllocationWithOnePrimaryNoReplicas(deciders, reason, Settings.EMPTY, IndexMetadata.State.OPEN, activeAllocationIds);
     * unassigned.  
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        String replicaAllocId = UUIDs.randomBase64UUID();
        testAllocator.addData(node1, "some allocId", randomBoolean());  
 * specific language governing permissions and limitations
        }
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
    /**
     */
    }
                Collections.emptySet()
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
    }
        testAllocator.addData(node1, "stale-id", randomBoolean());
    public void testStoreException() {
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
            .metadata(metadata)
     * DECIDERS_NO means valid copies exist and allocation is blocked by policy; converting would abandon real local  
    public void testDontForceAllocateOnThrottleDecision() {
        assertThat(  
    public void testNoMatchingAllocationIdFound() {
        RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(  
            allocId1,
        );
            RecoverySource.ExistingStoreRecoverySource.INSTANCE,
     * must not fire - an unfenced trigger loses acknowledged writes (FenceAutoRestore.tla refutes it).
import org.opensearch.cluster.ClusterState;
        );
    /**  
            allocId3
                storeException
     * Tests that replica with highest segment info version will be selected as target on equal primary terms
                    new IndexId(shardId.getIndexName(), UUIDs.randomBase64UUID(random()))  
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),  
            default:  
            ignored.get(0).unassignedInfo().getLastAllocationStatus(),
    @Before
        }
            equalTo(node1.getId())
        );
 *
        }
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        String allocId1 = randomAlphaOfLength(10);  
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);  
        testAllocator.addData(node1, "stale-id", randomBoolean());  
     * Tests that when restoring from a snapshot and we don't find a node with a shard copy, the shard will remain in
        UnassignedInfo.Reason reason,
    /**
        assertTrue(allocation.routingNodes().unassigned().ignored().isEmpty());  
    /**  
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
            CLUSTER_RECOVERED,  
                getNoDeciderThatAllowsForceAllocate()  
            yesAllocationDeciders(),
    public void testRestoreDoesNotAssignIfShardSizeNotAvailable() {  
            System.nanoTime()
        final RoutingTable routingTable = RoutingTable.builder()
                    .putInSyncAllocationIds(0, Sets.newHashSet(allocIds))  
        DiscoveryNode allocatedNode = node1HasPrimaryShard ? node1 : node2;
     * shard, so the trigger must not fire.
    /**  
import org.opensearch.cluster.node.DiscoveryNode;  
        allocateAllUnassigned(allocation);
    }
    private AllocationDecider getNoDeciderThatAllowsForceAllocate() {
     * Tests when the node returns that no data was found for it, it will be moved to ignore unassigned.  
        testAllocator.addData(node2, allocId2, false, new ReplicationCheckpoint(shardId, 20, 120, 3, Codec.getDefault().getName()));  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)  
        testAllocator.addData(node1, node1HasPrimaryShard ? primaryAllocId : replicaAllocId, node1HasPrimaryShard);
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
                // since the deciders return a NO decision for allocating a shard (due to the guaranteed NO decision from the second
     */  
        RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(deciders, CLUSTER_RECOVERED, "allocId1");  
        allocation = routingAllocationWithOnePrimaryNoReplicas(
        );
            DiscoveryNode node,
     * live node is converted to a remote-store recovery instead of being parked at NO_VALID_SHARD_COPY. The shard
            "allocId1"
            assertThat(shard.recoverySource().getType(), equalTo(RecoverySource.Type.EXISTING_STORE));
                new TestAllocateDecision(Decision.NO),  
 * KIND, either express or implied.  See the License for the
 *
        assertThat(allocation.routingNodesChanged(), equalTo(true));
     */
        public TestAllocator addData(DiscoveryNode node, String allocationId, boolean primary, @Nullable Exception storeException) {  
    }
        assertEquals(ignored.size(), 1);
        );  
        );  
            .put(IndexMetadata.INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING.getKey(), true)
        this.testAllocator = new TestAllocator();  
    }
        allocateAllUnassigned(allocation);  
            equalTo(node1.getId())
    /**
        assertTrue("the delay marker must survive the declined conversion", parked.unassignedInfo().isDelayed());
    }  
            .build();  
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
        );  
        );
import org.opensearch.snapshots.SnapshotShardSizeInfo;  
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
    /**
 * this file be licensed under the Apache-2.0 license or a
            String allocationId,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
    }  
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
            new UnassignedInfo(
    }
            CLUSTER_RECOVERED,  
        assertEquals(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), node1.getId());
            )
    }  
            data.put(
        );
     */
        testAllocator.addData(node1, "allocId1", randomBoolean());
        );
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));  
        assertThat(  
