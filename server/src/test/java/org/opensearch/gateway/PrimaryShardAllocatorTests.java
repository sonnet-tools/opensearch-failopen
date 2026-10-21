                routingTableBuilder.addAsRecovery(metadata.index(shardId.getIndex()));
import org.opensearch.cluster.health.ClusterStateHealth;
    public void testAutoRestoreRequiresAutoRestoreSetting() {
    /**
 *
        );
            unfenced,
        testAllocator.addData(node3, allocId3, false, new ReplicationCheckpoint(shardId, 20, 120, 2, Codec.getDefault().getName()));
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
                break;
        allocateAllUnassigned(allocation);
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
        );
        }
        String allocId1 = randomAlphaOfLength(10);
    /**
    /**
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            allocId1,
        // The unassigned primary exactly as disassociateDeadNodes leaves it when the index carries a non-zero
            IndexMetadata.State.OPEN,
            null,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(false));
 * the Apache License, Version 2.0 (the "License"); you may
        testAllocator.addData(node2, allocId2, false, new ReplicationCheckpoint(shardId, 22, 120, 2, Codec.getDefault().getName()));
     * Tests when the node returns that no data was found for it (null for allocation id),
import org.opensearch.common.settings.Settings;
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
        AllocationDeciders deciders = new AllocationDeciders(
                true,
    }
        RoutingTable routingTable = RoutingTable.builder()
            @Override
        );
        final ShardRouting parked = allocation.routingNodes().unassigned().ignored().get(0);
        assertThat(converted.recoverySource().getType(), equalTo(RecoverySource.Type.REMOTE_STORE));
import org.opensearch.env.Environment;
    }
            )
        );
    /**
            yesAllocationDeciders(),
                // the TestAllocateDecision's decision for force allocating is to THROTTLE (using
        String allocId1 = randomAlphaOfLength(10);
     * {@link #testAutoRestoreConvertsNoValidShardCopyToRemoteStoreRecovery} exercises).
import java.util.List;
        final RoutingAllocation allocation = new RoutingAllocation(
        testAllocator.addData(node2, allocId2, false, null, null);
            CLUSTER_RECOVERED,
        assertThat(
            "in-sync-id"
                    .numberOfReplicas(0)
            CLUSTER_RECOVERED,
        allocateAllUnassigned(allocation);
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
                IndexMetadata.builder(shardId.getIndexName())
                    .settings(settings(Version.CURRENT).put(extraIndexSettings))
            Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
        // check that allocation id is reused
        RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(deciders, CLUSTER_RECOVERED, "allocId1");
            withoutAutoRestore,
                getNoDeciderThatAllowsForceAllocate()
        String... activeAllocationIds
        return new TestAllocateDecision(Decision.NO) {
import org.opensearch.cluster.routing.RecoverySource;
        // the only copy the fetch finds carries an allocation id that is not in-sync: no valid copy anywhere
                System.nanoTime(),
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        final ShardRouting delayedPrimary = ShardRouting.newUnassigned(
        AllocationDeciders deciders,
            equalTo(node2.getId())
        String allocId1 = randomAlphaOfLength(10);
    /**
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        // Assert node3's allocation id should be used as it was previous primary
    /**
        allocateAllUnassigned(allocation);
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
                primary,
                0,
     * stays in the unassigned list (the shards allocator places it later in the same round), carries a fresh
        );
        assertEquals(ignored.size(), 1);
            ignored.get(0).unassignedInfo().getLastAllocationStatus(),
            CLUSTER_RECOVERED,
        return getNoDeciderWithForceAllocate(Decision.YES);
    public void testPreferReplicaWithHighestPrimaryTerm() {
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
                data = new HashMap<>();
        testAllocator.addData(node3, allocId3, true, null, null);
        return new RoutingAllocation(deciders, new RoutingNodes(state, false), state, null, null, System.nanoTime());
        assertThat(parked.recoverySource().getType(), equalTo(RecoverySource.Type.EXISTING_STORE));
                    .numberOfShards(1)
                // decider),
            public Decision canForceAllocatePrimary(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            assertThat(shard.recoverySource().getType(), equalTo(RecoverySource.Type.EXISTING_STORE));
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        String allocId3 = randomAlphaOfLength(10);
            ShardRouting shard,
        allocateAllUnassigned(allocation);
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
     * Tests that when there was a node that previously had the primary, it will be allocated to that same node again.
        RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(deciders, CLUSTER_RECOVERED, "allocId1");
        String allocId2 = randomAlphaOfLength(10);
                    .settings(settings(Version.CURRENT).put(autoRestoreEligibleSettings()))
        RoutingAllocation allocation = getRestoreRoutingAllocation(yesAllocationDeciders(), randomNonNegativeLong(), "allocId");
     */
     * index-creation time.
        allocateAllUnassigned(allocation);
     */
     * Tests that when restoring from a snapshot and we find a node with a shard copy and allocation
        testAllocator.addData(node1, allocId1, randomBoolean(), new ShardLockObtainFailedException(shardId, "test"));
            new UnassignedInfo(
            );
        ) {
            DiscoveryNode node,
     * expiry, after which the conversion proceeds (the cleared-flag path is what
            CLUSTER_RECOVERED,
 * this file be licensed under the Apache-2.0 license or a
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        );
            case INDEX_REOPENED:
        );
        );
            allocId1,
        String allocId2 = randomAlphaOfLength(10);
                assert shardRouting.primary() : "cannot force allocate a non-primary shard " + shardRouting;
                // the allocator will see if it can force assign the primary, and in this case,
     */
                break;
        // with old version, we can't know if a shard was allocated before or not
        public TestAllocator addData(DiscoveryNode node, String allocationId, boolean primary, @Nullable Exception storeException) {
                forceDecisionNo ? getNoDeciderThatDeniesForceAllocate() : getNoDeciderThatThrottlesForceAllocate()
                // so the shard will remain un-initialized
    }
            yesAllocationDeciders(),
        // delayed_timeout: NODE_LEFT with a live delay marker. (Constructed directly because ShardRouting forbids
            equalTo(node1.getId())
     */
        RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(deciders, CLUSTER_RECOVERED, "allocId1");
        String allocId3 = randomAlphaOfLength(10);
     * with its existing-store source, exactly as before this feature.
            yesAllocationDeciders(),
        public TestAllocator addData(DiscoveryNode node, String allocationId, boolean primary) {
 * ownership. Elasticsearch licenses this file to you under
                new TestAllocateDecision(randomBoolean() ? Decision.YES : Decision.NO),
            }
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        allocateAllUnassigned(allocation);
            boolean primary,
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        testAllocator.addData(node2, allocId2, false, new ReplicationCheckpoint(shardId, 20, 120, 2, Codec.getDefault().getName()));
        Settings extraIndexSettings,
        testAllocator.addData(node1, null, randomBoolean());
        );
import org.opensearch.Version;
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            equalTo(node3.getId())
        }
 */
        RoutingAllocation allocation = getRestoreRoutingAllocation(noAllocationDeciders(), shardSize, "allocId");
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
     * Tests that when there is a node to be allocated to, but it the decider said "no", we still
    }
        testAllocator.addData(node1, "allocId1", randomBoolean());
        String primaryAllocId = UUIDs.randomBase64UUID();
import static org.hamcrest.Matchers.equalTo;
            yesAllocationDeciders(),
        assertEquals(
        public TestAllocator addData(
    private RoutingAllocation getRestoreRoutingAllocation(AllocationDeciders allocationDeciders, Long shardSize, String... allocIds) {
                    .numberOfReplicas(0)
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        );
    }
                        primary,
     */
    public void testNoMatchingAllocationIdFound() {
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        testAllocator.addData(node1, "allocId1", randomBoolean());
            CLUSTER_RECOVERED,
                    .state(indexState)
    public void testAutoRestoreRequiresFencing() {
        assertThat(
        assertThat(
        }
        );
            .build();
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        final RoutingTable routingTable = RoutingTable.builder()
        assertThat(allocation.routingNodesChanged(), equalTo(true));
    public void testRestoreDoesNotAssignIfShardSizeNotAvailable() {
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
        boolean forceDecisionNo = randomBoolean();
            equalTo(node3.getId())
    }
            yesAllocationDeciders(),
    /**
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
        allocateAllUnassigned(allocation);
     * validator refuses that combination at creation time, but the allocator does not get to assume it), the trigger
        final Snapshot snapshot = new Snapshot("test", new SnapshotId("test", UUIDs.randomBase64UUID()));
        assertThat(allocation.routingNodesChanged(), equalTo(true));
    ) {
            autoRestoreEligibleSettings(),
     */
 * under the License.
        while (iterator.hasNext()) {
            autoRestoreEligibleSettings(),
    }
        assertThat(
 * SPDX-License-Identifier: Apache-2.0
            CLUSTER_RECOVERED,
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            equalTo(allocId2)
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
        allocateAllUnassigned(allocation);
     * Tests when the node returns data with a shard allocation id that does not match active allocation ids, it will be moved to ignore
            equalTo(allocId3)
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
import org.opensearch.snapshots.Snapshot;
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
                break;
            state,
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
            .build();
import org.opensearch.core.index.shard.ShardId;
     * Tests that when the nodes with prior copies of the given shard all return a decision of NO, but
    public void testPreferReplicaWithHighestSegmentInfoVersion() {
            yesAllocationDeciders(),
            forceDecisionNo ? AllocationStatus.DECIDERS_NO : AllocationStatus.DECIDERS_THROTTLED
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
    }
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
            allocation.routingNodes().unassigned().ignored().get(0).recoverySource().getType(),
     * The trigger honors the node-left grace window ({@code index.unassigned.node_left.delayed_timeout}): while the
            return this;
        testAllocator.addData(node2, node1HasPrimaryShard ? replicaAllocId : primaryAllocId, !node1HasPrimaryShard);
            equalTo(allocatedNode.getId())
        );
            yesAllocationDeciders(),
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            )
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
    }
        );
        );
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
            equalTo(RecoverySource.Type.EXISTING_STORE)
    /**
        testAllocator.addData(node1, "some allocId", randomBoolean());
            IndexMetadata.State.OPEN,
            equalTo(node3.getId())
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
    public void testNoAllocationFound() {
        }
        testAllocator.addData(node1, allocId1, false, new ReplicationCheckpoint(shardId, 10, 101, 1, Codec.getDefault().getName()));
    }
            "in-sync-id"
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
        allocateAllUnassigned(allocation);
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
 * compatible open source license.
    /**
    /**
        testAllocator.addData(node1, allocId1, false, new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()));
     * the unassigned list to be allocated later.
        String allocId2 = randomAlphaOfLength(10);
                    .putInSyncAllocationIds(0, Sets.newHashSet(allocIds))
            testAllocator.allocateUnassigned(iterator.next(), allocation, iterator);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        assertThat(
        return getNoDeciderWithForceAllocate(Decision.NO);
import org.junit.Before;
import org.opensearch.common.Nullable;
    }
        assertThat(
            case INDEX_CREATED:
        testAllocator.addData(node1, "stale-id", randomBoolean());
     */
            allocId2,
            yesAllocationDeciders(),
        );
        assertThat(
     */
                ReplicationCheckpoint.empty(shardId, new CodecService(null, indexSettings, null, List.of()).codec("default").getName()),
    }
        assertEquals(ignored.size(), 1);
 * You may obtain a copy of the License at
        allocateAllUnassigned(allocation);
        allocateAllUnassigned(allocation);
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
                IndexMetadata.builder(shardId.getIndexName())
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
            "allocId1"
            allocId1,
            "in-sync-id"
     * Tests when the node returns that no data was found for it, it will be moved to ignore unassigned.
     */
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
            CLUSTER_RECOVERED,
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        UnassignedInfo.Reason reason,
            Arrays.asList(
        );
/*
            autoRestoreEligibleSettings(),
        ShardRouting ignoredRouting = allocation.routingNodes().unassigned().ignored().get(0);
            .metadata(metadata)
        String allocId3 = randomAlphaOfLength(10);
        assertThat(converted.unassignedInfo().getNumFailedAllocations(), equalTo(0));
            allocId2
        );
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        return getNoDeciderWithForceAllocate(Decision.THROTTLE);
        assertThat(allocation.routingNodesChanged(), equalTo(true));
     * {@code AllocationService#removeDelayMarkers} on the reroute {@code DelayedAllocationService} schedules at
    /**
        AllocationDeciders deciders = new AllocationDeciders(
     * Tests that when async fetch returns that there is no data, the shard will not be allocated.
            null,
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        String allocId2 = randomAlphaOfLength(10);
        AllocationDeciders deciders = new AllocationDeciders(
        ClusterState clusterState = ClusterState.builder(new ClusterName("test-cluster")).routingTable(newRoutingTable).build();
        allocateAllUnassigned(allocation);
        assertThat(allocation.routingNodesChanged(), equalTo(true));
    public void testForceAllocatePrimary() {
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        // check that allocation id is reused
            )
     * deciders say no, we still allocate to that node.
import org.opensearch.index.IndexSettings;
            data.put(
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        }
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        UnassignedInfo.Reason reason,
        testAllocator.addData(node1, null, randomBoolean());
        assertThat(allocation.routingNodesChanged(), equalTo(true));
import org.opensearch.snapshots.SnapshotShardSizeInfo;
     * then we do not force allocate to that node but instead throttle.
        assertThat(
     * Tests that prefer allocation of replica at lower checkpoint but in sync set
     * Fixture variant taking extra index settings and an index state, for the auto-restore trigger tests. Building
        testAllocator.addData(node3, allocId3, false, new ReplicationCheckpoint(shardId, 15, 120, 2, Codec.getDefault().getName()));
            return addData(
        assertThat(
import org.opensearch.cluster.metadata.Metadata;
    class TestAllocator extends PrimaryShardAllocator {
     * The auto-restore trigger: a fenced, auto-restore-enabled remote index whose primary has no valid copy on any
            equalTo(node2.getId())
        assertThat(
     */
        String replicaAllocId = UUIDs.randomBase64UUID();
     * Tests that when restoring from a snapshot and we don't know the shard size yet, the shard will remain in
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
     */
        // check that allocation id is reused
        testAllocator.addData(node3, allocId3, false, new ReplicationCheckpoint(shardId, 15, 120, 2, Codec.getDefault().getName()));
            allocId3
            DiscoveryNode node,
     * defensive fencing guard in the allocator be exercised with combinations the validator would refuse at
 * specific language governing permissions and limitations
        );
import org.opensearch.repositories.IndexId;
        allocateAllUnassigned(allocation);
     */
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
            @Override
    }
        testAllocator.addData(node1, "allocId1", randomBoolean(), new CorruptIndexException("test", "test"));
    public void testRestoreDoesNotAssignIfNoShardAvailable() {
     * A closed index acknowledges nothing and may be mid-in-place-snapshot-restore; its lifecycle operations own the
                        storeException
        allocateAllUnassigned(allocation);
     * DECIDERS_NO means valid copies exist and allocation is blocked by policy; converting would abandon real local
                allocationId,
    public void testFoundAllocationButThrottlingDecider() {
    public void testAutoRestoreSkipsClosedIndex() {
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
     * ({@code ReplicaShardAllocator#processExistingRecoveries}) covers replicas only, since historically an
     * the unassigned list to be allocated later.
        assertThat(allocation.routingNodes().unassigned().size(), equalTo(1));
                // the allocator will see if it can force assign the primary, where the decision will be YES
    private final DiscoveryNode node1 = newNode("node1");
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
import static org.hamcrest.Matchers.empty;
        @Override
            .metadata(metadata)
    private AllocationDecider getNoDeciderWithForceAllocate(final Decision forceAllocateDecision) {
            allocation.routingNodes().unassigned().ignored().get(0).recoverySource().getType(),
        );
    public void testOutOfSyncHighestRepCheckpointIsIgnored() {
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
            RoutingAllocation allocation
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Tests that when restoring from a snapshot and we find a node with a shard copy but allocation
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
            CLUSTER_RECOVERED,
    }
    }
    }
        testAllocator.addData(node3, allocId3, false, new ReplicationCheckpoint(shardId, 20, 120, 2, Codec.getDefault().getName()));
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
     */
            randomFrom(CLUSTER_RECOVERED, INDEX_REOPENED),
    }
        allocateAllUnassigned(allocation);
            case CLUSTER_RECOVERED:
    }
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
                IndexMetadata.builder(shardId.getIndexName())
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
                // since the deciders return a NO decision for allocating a shard (due to the guaranteed NO decision from the second
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
            allocId1,
    }
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        String allocId2 = randomAlphaOfLength(10);
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
                )
     */
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        );
        assertThat(allocation.routingNodes().unassigned().ignored(), empty());
        // starts, so YELLOW would overstate availability. It converges to GREEN without operator action.
        assertThat(
            .put(IndexMetadata.INDEX_REMOTE_STORE_AUTO_RESTORE_ENABLED_SETTING.getKey(), true)
        testAllocator.addData(node1, "stale-id", randomBoolean());
            equalTo(allocId3)
                    .numberOfShards(1)
        testAllocator.addData(node2, allocId2, randomBoolean());
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        );
            System.nanoTime()
            String allocationId,
                // the allocator will see if it can force assign the primary, where the decision will be either NO or THROTTLE,
            });
            allocId2,
 * Unless required by applicable law or agreed to in writing,
    /**
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
    }
        testAllocator.addData(node1, null, false);
            equalTo(node1.getId())
            "allocId1"
        assertThat(initializingShards.size(), equalTo(1));
            ReplicationCheckpoint replicationCheckpoint,
            );
            true,
    private RoutingAllocation routingAllocationWithOnePrimaryNoReplicas(
    }
        testAllocator.addData(node1, "allocId1", randomBoolean());
        allocateAllUnassigned(allocation);
            yesAllocationDeciders(),
            CLUSTER_RECOVERED,
            )
        assertThat(ignoredRouting.unassignedInfo().getLastAllocationStatus(), equalTo(AllocationStatus.FETCHING_SHARD_DATA));
            equalTo(allocId1)
            .put(
        assertThat(
            yesAllocationDeciders(),
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        final Settings withoutAutoRestore = Settings.builder()
        // a valid in-sync copy exists; the deciders refuse to place it
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
     * live node is converted to a remote-store recovery instead of being parked at NO_VALID_SHARD_COPY. The shard
        final RoutingTable newRoutingTable = new RoutingTable.Builder().updateNodes(oldRoutingTable.version(), newRoutingNodes).build();
        final ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
     */
        testAllocator.addData(node1, "stale-id", randomBoolean());
            @Nullable Exception storeException
            equalTo(allocId2)
     * Without index.remote_store.auto_restore.enabled the trigger stays off: the shard parks at NO_VALID_SHARD_COPY
            .put(IndexMetadata.INDEX_REMOTE_STORE_AUTO_RESTORE_ENABLED_SETTING.getKey(), true)
        RoutingAllocation allocation = getRestoreRoutingAllocation(yesAllocationDeciders(), null, "allocId");
            .build();
        allocateAllUnassigned(allocation);
            allocId3
            "allocId"
        ) {
            ReplicationCheckpoint replicationCheckpoint
            return new AsyncShardFetch.FetchResult<>(data, new HashMap<>() {
    /**
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            yesAllocationDeciders(),
        testAllocator.addData(node2, allocId2, false, new ReplicationCheckpoint(shardId, 20, 120, 3, Codec.getDefault().getName()));
        String allocId1 = randomAlphaOfLength(10);
        Metadata metadata = Metadata.builder()
    private final DiscoveryNode node3 = newNode("node3");
        String allocId3 = randomAlphaOfLength(10);
    public void testRestoreForcesAllocateIfShardAvailable() {
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        );
    public void testAutoRestoreConvertsNoValidShardCopyToRemoteStoreRecovery() {
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
import org.opensearch.cluster.routing.RoutingNodes;
            )
            IndexMetadata.State.OPEN,
                new TestAllocateDecision(Decision.NO),
        assertThat(
        final ShardRouting converted = allocation.routingNodes().unassigned().iterator().next();
import org.opensearch.common.util.set.Sets;
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
     * Tests that when one node returns a ShardLockObtainFailedException and another properly loads the store, it will
                throw new IllegalArgumentException("can't do " + reason + " for you. teach me");
import org.opensearch.cluster.routing.ShardRoutingState;
                    put(shardId, Collections.<String>emptySet());
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
            .build();
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
    /**
        String allocId1 = randomAlphaOfLength(10);
            allocId1,
            default:
            }
        boolean node1HasPrimaryShard = randomBoolean();
    }
            )
     * must not fire - an unfenced trigger loses acknowledged writes (FenceAutoRestore.tla refutes it).
        );
            new RoutingNodes(state, false),
import java.util.Arrays;
     */
        );
    public void testNoProcessPrimaryNotAllocatedBefore() {
        assertThat(clusterStateHealth.getStatus().ordinal(), lessThanOrEqualTo(expectedStatus.ordinal()));
            yesAllocationDeciders(),
        allocateAllUnassigned(allocation);
                allocationId,
            randomFrom(INDEX_CREATED, CLUSTER_RECOVERED, INDEX_REOPENED)
     * force the allocation to it.
     * Tests that replica with the highest primary term version will be selected as target
        testAllocator.addData(node1, "stale-id", randomBoolean());
            Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
     * Tests that when restoring from a snapshot and we find a node with a shard copy and allocation
        AllocationDeciders deciders,
import org.opensearch.cluster.routing.RoutingNode;
            equalTo(allocId3)
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
import static org.opensearch.cluster.routing.UnassignedInfo.Reason.INDEX_CREATED;
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            yesAllocationDeciders(),
                    new IndexId(shardId.getIndexName(), UUIDs.randomBase64UUID(random()))
package org.opensearch.gateway;
                UnassignedInfo.Reason.NODE_LEFT,
        assertTrue(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).isEmpty());
    }
            randomFrom(CLUSTER_RECOVERED, INDEX_REOPENED),
    }
        );
            equalTo(allocId2)
    }
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
        assertThat(allocation.routingNodesChanged(), equalTo(true));
import static org.opensearch.cluster.routing.UnassignedInfo.Reason.INDEX_REOPENED;
        testAllocator.addData(node2, allocId2, false, new ReplicationCheckpoint(shardId, 20, 120, 2, Codec.getDefault().getName()));
        );
     */
/*
        testAllocator.addData(node1, allocId1, true, new ReplicationCheckpoint(shardId, 10, 101, 1, Codec.getDefault().getName()));
     * deciders say throttle, we add it to ignored shards.
        RoutingTable oldRoutingTable = allocation.routingTable();
        List<ShardRouting> ignored = allocation.routingNodes().unassigned().ignored();
            if (data == null) {
        );
     */
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
                // the default behavior) so despite the other decider's decision to return YES for
    public void testPreferAllocatingPreviousPrimary() {
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        );
        );
     * Tests that when the nodes with prior copies of the given shard all return a decision of NO, and
import org.opensearch.cluster.routing.RoutingTable;
        final Metadata metadata = Metadata.builder()
     * shard, so the trigger must not fire.
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
    public void testFoundAllocationButNoDecider() {
            yesAllocationDeciders(),
        assertEquals(ignored.get(0).unassignedInfo().getLastAllocationStatus(), AllocationStatus.DECIDERS_THROTTLED);
        allocateAllUnassigned(allocation);
    private void assertClusterHealthStatus(RoutingAllocation allocation, ClusterHealthStatus expectedStatus) {
                    snapshot,
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
     * initializing primary WAS the only copy and there was nothing to cancel in favor of. The flag is cleared by
 * not use this file except in compliance with the License.
                    .numberOfShards(1)
    /**
    /**
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
            )
        assertThat(initializingShards.get(0).getExpectedShardSize(), equalTo(shardSize));
                )
                routingTableBuilder.addAsNew(metadata.index(shardId.getIndex()));
            }
            .put(
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
    /**
            .put(IndexMetadata.INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING.getKey(), true)
                ReplicationCheckpoint.empty(shardId, new CodecService(null, indexSettings, null, List.of()).codec("default").getName()),
                    new TransportNodesGatewayStartedShardHelper.GatewayStartedShard(
            .metadata(metadata)
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        assertTrue("the delay marker must survive the declined conversion", parked.unassignedInfo().isDelayed());
        allocateAllUnassigned(allocation);
        );
        this.testAllocator = new TestAllocator();
            CLUSTER_RECOVERED,
 * KIND, either express or implied.  See the License for the
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
     * Tests that when the node returns a ShardLockObtainFailedException, it will be considered as a valid shard copy
                    UUIDs.randomBase64UUID(),
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
        RoutingAllocation allocation = getRestoreRoutingAllocation(yesAllocationDeciders(), randomLong(), "allocId");
     */
    private final DiscoveryNode node2 = newNode("node2");
            equalTo(RecoverySource.Type.EXISTING_STORE)
import java.util.Collections;
        final long shardSize = randomNonNegativeLong();
import org.opensearch.common.UUIDs;
            public Long getShardSize(ShardRouting shardRouting) {
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
            CLUSTER_RECOVERED,
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
 */
     * Tests that when there is a node to allocate to, but it is throttling (and it is the only one),
        String allocId3 = randomAlphaOfLength(10);
                    .numberOfReplicas(0)
     */
            CLUSTER_RECOVERED,
        }
        );
            .put(IndexMetadata.INDEX_REMOTE_STORE_FENCING_ENABLED_SETTING.getKey(), true)
        String allocId3 = randomAlphaOfLength(10);
    public void testPreferReplicaWithAllNullReplicationCheckpoint() {
            String allocationId,
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            yesAllocationDeciders(),
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        }, System.nanoTime());
            assertThat(shard.recoverySource().getType(), equalTo(RecoverySource.Type.EXISTING_STORE));
            yesAllocationDeciders(),
    public void testNoAsyncFetchData() {
            .add(IndexRoutingTable.builder(shardId.getIndex()).addShard(delayedPrimary))
                return forceAllocateDecision;
        allocateAllUnassigned(allocation);
     */
    }
            .build();
            CLUSTER_RECOVERED,
    /**
    public void testFoundAllocationAndAllocating() {
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
            yesAllocationDeciders(),
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
    }
    private static Settings autoRestoreEligibleSettings() {
     * Tests that prefer allocation of older primary over replica with higher replication checkpoint
        assertThat(allocation.routingNodes().unassigned().iterator().next().shardId(), equalTo(shardId));
    /**
        testAllocator.addData(node1, "allocId1", randomBoolean(), new ShardLockObtainFailedException(shardId, "test"));
        assertThat(
    private AllocationDecider getNoDeciderThatAllowsForceAllocate() {
        );
    public void testShardLockObtainFailedExceptionPreferOtherValidCopies() {
            allocId1,
    /**
    }
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        // Assert node2's allocation id is used
        testAllocator.addData(node1, allocId1, false, null, null);
import org.opensearch.test.IndexSettingsModule;
 * this work for additional information regarding copyright
     * Tests that when restoring from a snapshot and we don't find a node with a shard copy, the shard will remain in
     */
     * Tests that replica with highest primary ter version will be selected as target
        allocateAllUnassigned(allocation);
    /**
import org.opensearch.cluster.routing.UnassignedInfo;
                routingTableBuilder.addAsFromCloseToOpen(metadata.index(shardId.getIndex()));
            boolean primary,
        RoutingNodes newRoutingNodes = allocation.routingNodes();
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
import org.opensearch.indices.replication.common.ReplicationType;
        assertThat(
     */
import org.opensearch.env.ShardLockObtainFailedException;
                return shardSize;
     * {@link AllocationDecider#canForceAllocatePrimary(ShardRouting, RoutingNode, RoutingAllocation)}
        allocateAllUnassigned(allocation);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        allocateAllUnassigned(allocation);
            allocation.routingNodes().unassigned().ignored().get(0).recoverySource().getType(),
            .addAsRestore(
                null,
        );
            .put(
            equalTo("allocId1")
    public void testPreferAllocatingPreviousPrimaryWithLowerRepCheckpoint() {
        );
            equalTo("allocId1")
            allocId3
                    )
        private Map<DiscoveryNode, TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> data;
     */
    }
     */
        }
    public void testAutoRestoreWaitsOutNodeLeftDelay() {
        assertTrue(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).isEmpty());
    public void testDontForceAllocateOnThrottleDecision() {
    }
    /**
     * select the second node as target
            equalTo(node2.getId())
            .build();
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        testAllocator.addData(node2, allocId2, false);
            RecoverySource.ExistingStoreRecoverySource.INSTANCE,
        DiscoveryNode allocatedNode = node1HasPrimaryShard ? node1 : node2;
            yesAllocationDeciders(),
        assertThat(allocation.routingNodesChanged(), equalTo(false));
 * license agreements. See the NOTICE file distributed with
        testAllocator.addData(node1, "some allocId", randomBoolean());
    }
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
    public void testAutoRestoreSkipsDecidersNo() {
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
     * returns a YES decision for at least one of those NO nodes, then we force allocate to one of them
            );
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
    private RoutingAllocation routingAllocationWithOnePrimaryNoReplicas(
            noAllocationDeciders(),
            IndexMetadata.State.CLOSE,
        assertThat(ClusterShardHealth.getInactivePrimaryHealth(converted), equalTo(org.opensearch.cluster.health.ClusterHealthStatus.RED));
        }
        testAllocator.addData(node3, allocId3, false, new ReplicationCheckpoint(shardId, 40, 120, 2, Codec.getDefault().getName()));
        public TestAllocator clear() {
            allocId3
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
                    .putInSyncAllocationIds(shardId.id(), Sets.newHashSet("in-sync-id"))
            new AllocationDeciders(Arrays.asList(getNoDeciderThatDeniesForceAllocate())),
        IndexMetadata.State indexState,
                System.currentTimeMillis(),
        );
        );
        ) {
import static org.opensearch.cluster.routing.UnassignedInfo.Reason.CLUSTER_RECOVERED;
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
        final Settings unfenced = Settings.builder()
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
    }
    }
        allocateAllUnassigned(allocation);
                node,
    /**
        );
     */
     * queries), converging to GREEN without operator action - the improvement is convergence, not the color.
        testAllocator.addData(node1, node1HasPrimaryShard ? primaryAllocId : replicaAllocId, node1HasPrimaryShard);
        allocateAllUnassigned(allocation);
            return addData(node, allocationId, primary, replicationCheckpoint, null);
     * returns a NO or THROTTLE decision for a node, then we do not force allocate to that node.
        );
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
     */
     * REMOTE_STORE recovery source, and deliberately stays RED while it hydrates (a restoring primary cannot serve
            "allocId1"
import org.opensearch.cluster.health.ClusterHealthStatus;
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
        );
import org.opensearch.cluster.ClusterState;
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
        assertThat(allocation.routingNodes().unassigned().size(), equalTo(1));
import org.opensearch.cluster.ClusterName;
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        );
import org.opensearch.index.codec.CodecService;
        // Health deliberately stays RED while the restore hydrates: the primary cannot serve queries until it
        assertThat(
        String allocId2 = randomAlphaOfLength(10);
            IndexMetadata.State.OPEN,
     * Tests that when there is a node to allocate the shard to, it will be allocated to it.
    private AllocationDecider getNoDeciderThatThrottlesForceAllocate() {
        allocateAllUnassigned(allocation);
        List<ShardRouting> ignored = allocation.routingNodes().unassigned().ignored();
     * Tests that when the nodes with prior copies of the given shard return a THROTTLE decision,
                {
                    .settings(settings(Version.CURRENT))
                "node_left [node1]",
                // since both deciders here return a NO decision for allocating a shard,
            "allocId"
                storeException
        );
        testAllocator.addData(node1, "in-sync-id", randomBoolean());
        testAllocator.addData(node1, allocId1, false, new ReplicationCheckpoint(shardId, 10, 101, 1, Codec.getDefault().getName()));
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
                Collections.emptySet()
    private AllocationDecider getNoDeciderThatDeniesForceAllocate() {
 * The OpenSearch Contributors require contributions made to
        allocateAllUnassigned(allocation);
        RoutingAllocation allocation = getRestoreRoutingAllocation(throttleAllocationDeciders(), randomLong(), "allocId");
        testAllocator.addData(node1, allocId1, false, new ReplicationCheckpoint(shardId, 20, 101, 1, Codec.getDefault().getName()));
     * Tests that null ReplicationCheckpoint are ignored
        assertThat(
                        replicationCheckpoint,
        assertEquals(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), 1);
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
            .build();
                    node,
        allocation = routingAllocationWithOnePrimaryNoReplicas(
    private void allocateAllUnassigned(final RoutingAllocation allocation) {
                metadata.index(shardId.getIndex()),
            .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
 * Modifications Copyright OpenSearch Contributors. See
            .build();
    }
            primaryAllocId,
            CLUSTER_RECOVERED,
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        assertThat(
            .routingTable(routingTable)
    ) {
        testAllocator.addData(node1, "allocId1", randomBoolean());
        assertThat(
import org.opensearch.cluster.node.DiscoveryNodes;
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
     * {@link IndexMetadata} directly bypasses registered setting validators, which is deliberate: it lets the
        public TestAllocator addData(
            yesAllocationDeciders(),
            IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", nodeSettings);
import org.opensearch.snapshots.SnapshotId;
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(false));
            return this;
            equalTo(node1.getId())
     * {@link AllocationDecider#canForceAllocatePrimary(ShardRouting, RoutingNode, RoutingAllocation)}
            .build();
    public void testRestoreThrottle() {
public class PrimaryShardAllocatorTests extends OpenSearchAllocationTestCase {
        allocateAllUnassigned(allocation);
        );
     * it will be moved to ignore unassigned until it can be allocated to.
     * deciders say yes, we allocate to that node.
        String... activeAllocationIds
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
 * GitHub history for details.
            allocId2,
            shardId,
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
        assertTrue(allocation.routingNodes().unassigned().ignored().isEmpty());
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
     */
        testAllocator.addData(node1, "some allocId", randomBoolean());
     */
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
        for (ShardRouting shard : allocation.routingNodes().unassigned().ignored()) {
        assertThat(
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
    }
import org.opensearch.cluster.metadata.IndexMetadata;
    private final ShardId shardId = new ShardId("test", "_na_", 0);
        );
            CLUSTER_RECOVERED,
            CLUSTER_RECOVERED,
        );
    /**
            "in-sync-id"
                // force allocating the shard, we still THROTTLE due to the decision from TestAllocateDecision
        // Assert node3's allocation id is used
                primary,
     * The defensive fencing guard: even if index metadata carries auto_restore=true without fencing (the setting
            .build();
            allocId2,
            IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", nodeSettings);
        );
                node,
import org.opensearch.cluster.routing.allocation.decider.Decision;
            equalTo(node1.getId())
        );
                    .putInSyncAllocationIds(shardId.id(), Sets.newHashSet(activeAllocationIds))
                new TransportNodesListGatewayStartedShards.NodeGatewayStartedShards(
            allocId3
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.health.ClusterShardHealth;
        assertThat(
    }
        assertThat(allocation.routingNodesChanged(), equalTo(true));
    /**
    /**
                null
                    .state(IndexMetadata.State.OPEN)
        // Assert node1's allocation id is used with highest replication checkpoint
     * Tests that replica with highest segment info version will be selected as target on equal primary terms
        final RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(
    public void testRestore() {
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
            equalTo(RecoverySource.Type.EXISTING_STORE)
            .routingTable(routingTable)
    }
        testAllocator.addData(node1, "allocId1", randomBoolean());
    public void testDontAllocateOnNoOrThrottleForceAllocationDecision() {
            throttleAllocationDeciders(),
        return Settings.builder()
        allocateAllUnassigned(allocation);
        );
            .routingTable(routingTableBuilder.build())
        assertEquals(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(), node1.getId());
            data = null;
    }
        protected AsyncShardFetch.FetchResult<TransportNodesListGatewayStartedShards.NodeGatewayStartedShards> fetchData(
     * it will be moved to ignore unassigned.
        }
        switch (reason) {
    /**
            )
 *
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        testAllocator.addData(node1, "stale-id", randomBoolean());
    public void buildTestAllocator() {
            Arrays.asList(
                getNoDeciderThatAllowsForceAllocate()
        return routingAllocationWithOnePrimaryNoReplicas(deciders, reason, Settings.EMPTY, IndexMetadata.State.OPEN, activeAllocationIds);
        }
        final RoutingAllocation allocation;
    public void testStoreException() {
                    Version.CURRENT,
     * unassigned.
                node,
    }
            "allocId1"
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
 * software distributed under the License is distributed on an
        RoutingAllocation allocation = routingAllocationWithOnePrimaryNoReplicas(yesAllocationDeciders(), CLUSTER_RECOVERED, "id2");
     * data over a transient decider, so the trigger must not fire.
     * delay marker set at node-left is live, the conversion is declined so a bouncing node can rejoin and reclaim
                        allocationId,
        testAllocator.addData(node1, "allocId1", randomBoolean());
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
    public void testShardLockObtainFailedException() {
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
            return addData(
    }
    /**
import org.apache.lucene.codecs.Codec;
    }
 */
     */
    private TestAllocator testAllocator;
        for (ShardRouting shard : allocation.routingNodes().unassigned()) {
            "in-sync-id"
                new TestAllocateDecision(Decision.THROTTLE),
        testAllocator.addData(node1, "id1", randomBoolean());
            Arrays.asList(
        );
            CLUSTER_RECOVERED,
     */
        // the non-delayed -> delayed transition via updateUnassigned.)
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        String allocId1 = randomAlphaOfLength(10);
        assertThat(allocation.routingNodes().unassigned().size(), equalTo(1));
            .build();
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
    }
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
    /**
        allocateAllUnassigned(allocation);
 * Licensed to Elasticsearch under one or more contributor
            "allocId1"
            allocId3
        final List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
            CLUSTER_RECOVERED,
 *
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
        String allocId1 = randomAlphaOfLength(10);
/*
            allocId2,
    public void testPreferReplicaWithNullReplicationCheckpoint() {
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).allocationId().getId(),
import java.util.HashMap;
        return new RoutingAllocation(allocationDeciders, new RoutingNodes(state, false), state, null, new SnapshotShardSizeInfo(Map.of()) {
        assertThat(
        Metadata metadata = Metadata.builder()
        // Assert node2's allocation id is used
        assertClusterHealthStatus(allocation, ClusterHealthStatus.YELLOW);
                // since we have a NO decision for allocating a shard (because the second decider returns a NO decision),
        };
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
import org.opensearch.cluster.node.DiscoveryNode;
    }
            replicaAllocId
    @Before
        );
            allocId1,
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
     * its local copy. Prevention is the primary's only protection today - the rejoin cancellation machinery
                new SnapshotRecoverySource(
        assertThat(allocation.routingNodes().unassigned().ignored().isEmpty(), equalTo(true));
}
        );
        assertThat(
        // Assert node3's allocation id should be used as it has highest replication checkpoint
import org.apache.lucene.index.CorruptIndexException;
        String allocId2 = randomAlphaOfLength(10);
    /**
        ClusterStateHealth clusterStateHealth = new ClusterStateHealth(clusterState);
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
import java.util.Map;
                }
import org.opensearch.cluster.routing.IndexRoutingTable;
        // whatever routing shape a closed index takes, no shard may have been converted to a remote-store recovery
