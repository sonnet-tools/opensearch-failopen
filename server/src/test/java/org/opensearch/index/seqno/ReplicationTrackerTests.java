        assertTrue(newActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        Thread.sleep(100);
        }
        // there is a shard copy pending in sync, the global checkpoint can not advance
                break;
            } else {  
import org.apache.lucene.codecs.Codec;
        Settings settings = Settings.builder()
        addPeerRecoveryRetentionLease(tracker, newSyncingAllocationId);
        String allocationId = randomFrom(gcp.checkpoints.keySet());  
        );
    }  
            }  
        final AllocationId inSyncAllocationId = AllocationId.newInitializing();
        /*  
            indexSettings,
        Map<AllocationId, Long> initializingWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 1);
        assertTrue("the grouped listener must receive one response per tracked copy", completed.get());  
        assertAsTimePasses.accept(() -> {  
            try {  
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(1, 5);  
        final int numUpdates = randomInt(10);
                // apply cluster state update on old primary so that the states on old and new primary are comparable  
        long primaryLocalCheckpoint = activeWithCheckpoints.get(primaryId);  
        }
        final AllocationId primaryId = active.iterator().next();
    }
        assigned.putAll(initializing);
        final ReplicationTracker tracker = newTracker(primaryId, settings);  
            randomInt(2)  
        );
            onUpdate,
        assertTrue(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);
            1L,  
            tracker.updateLocalCheckpoint(initializing.getId(), nextActiveLocalCheckpoint);
        assertTrue(tracker.getSegmentReplicationStats().isEmpty());
        assertEquals(updatedGlobalCheckpoint.get(), update);  
            // cluster-manager changes its mind and cancels the allocation
        // retry start replication lag timers
        }  
    public void testMissingActiveIdsDoesNotPreventAdvanceWithRemoteTranslogEnabled() {  
        );  
        final AllocationId aId = clusterState.routingTable.primaryShard().allocationId();
            initialClusterStateVersion + 2,  
            .build();
        assertEquals(100L, globalCheckpointWithReplicaBehindPrimary(settings, true));
        final ReplicationTracker tracker = newTracker(primaryId, updatedGlobalCheckpoint::set, currentTimeMillis::get);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        );
        activeAllocationIds.remove(primaryId);
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
            }  
        assertTrue(  
        assertNotEquals(UNASSIGNED_SEQ_NO, tracker.getGlobalCheckpoint());
        final Map<AllocationId, Long> initializingToStay = randomAllocationsWithLocalCheckpoints(1, 5);
            Collections.singleton(inSyncAllocationId.getId()),
            NON_REMOTE_DISCOVERY_NODE
            assertEquals(151L, shardStat.getBytesBehindCount());
        addPeerRecoveryRetentionLease(tracker, trackingAllocationId);
import static java.util.Collections.emptySet;
        logger.info("active: {}, initializing: {}", active, initializing);
            .build();
        private FakeClusterState(long version, Set<AllocationId> inSyncIds, IndexShardRoutingTable routingTable) {  
        // it is however nice not to assume this on this level and check we do the right thing.  
        }
        final BiConsumer<RetentionLeases, ActionListener<ReplicationResponse>> onNewRetentionLease = (leases, listener) -> {};  
            .filter(a -> !removingInitializingAllocationIds.contains(a))
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO  
        assertTrue(removingActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()) == null));  
                barrier.await();  
            numberOfActiveAllocationsIds,
        tracker.updateFromClusterManager(2L, Set.of(primaryId.getId(), replicaId.getId()), relocatingRoutingTable);
        Set<AllocationId> initializing = new HashSet<>(initializingWithCheckpoints.keySet());
        assertBusy(() -> {
        // we are implicitly marking the pending in sync copy as in sync with the current global checkpoint, no advancement should occur  
        );  
        final long initialClusterStateVersion = randomNonNegativeLong();  
            try {
        final AllocationId extraId = AllocationId.newInitializing();
            logger.info("  - [{}], local checkpoint [{}], [{}]", aId, allocations.get(aId), type);
            randomNonNegativeLong(),
        assertThat(tracker.getReplicationGroup().getInSyncAllocationIds(), equalTo(ids(activeAllocationIds)));
            }
            ids(newActiveAllocationIds),
import org.opensearch.core.index.shard.ShardId;
        }
            currentTimeMillis.addAndGet(shorterThanRenewalTime);
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), randomInt((int) minLocalCheckpointAfterUpdates), false);
            activeAllocationIds.stream()
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));  
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(0, 5);
        tracker.activatePrimaryMode(activeLocalCheckpoint);
            activeAllocationIds,  
        removingActiveAllocationIds.remove(primaryId);
            oldPrimary.checkpoints.get(newPrimary.shardAllocationId).inSync,  
        final StoreFileMetadata segment_1 = new StoreFileMetadata("segment_1", 1L, "abcd", Version.LATEST);
    private long globalCheckpointWithReplicaBehindPrimary(Settings settings, boolean shardOnRemoteEnabledNode) throws InterruptedException {
 * KIND, either express or implied.  See the License for the
        randomSubsetOf(randomIntBetween(1, initializing.size() - 1), initializing.keySet()).forEach(
        assertThat(
        );
                .allMatch(  
        assertFalse(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));
        if (randomBoolean()) {
            Codec.getDefault().getName(),
        assertTrue(  
            .collect(Collectors.toSet());  
            assertEquals(2, shardStat.getCheckpointsBehindCount());  
        assertThat(
        String relocatingToNodeId = nodeIdFromAllocationId(targetAllocationId);  
                .stream()
            numberOfActiveAllocationsIds,  
        // createMissingPeerRecoveryRetentionLeases() exists to repair.  
        for (final AllocationId initializingId : initializingIds) {
            routingTable(Collections.singleton(initializing), active)
import java.util.function.Consumer;  
import java.util.HashSet;  
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4), false);
        Map<String, ReplicationTracker.CheckpointState> oldPrimaryCheckpointsCopy = new HashMap<>(oldPrimary.checkpoints);  
            activeAllocationIds.stream()
    }  
        initializingThread.join();  
            5L,
        assertBusy(() -> assertTrue(tracker.pendingInSync()));  
        }
        );  
        assertTrue(activeAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));  
            );
            assertThat(  
        tracker.updateVisibleCheckpointForShard(recoveringReplicaId.getId(), recoveryCheckpoint);
            assertEquals(2, checkpointState.checkpointTimers.size());  
                clusterState.apply(newPrimary);
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
        final ReplicationCheckpoint initialCheckpoint = new ReplicationCheckpoint(
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
            }
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
        if (randomBoolean()) {
    /**
            aId.getRelocationId(),  
            initializing.forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));  
        assertEquals(expectedIds.size(), groupStats.size());
import org.opensearch.index.remote.RemoteStoreTestsHelper;
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO  
            allocations.putAll(initializingToBeRemoved);
        }
            tracker.initiateTracking(allocationId);
        active.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));  
     * A full remote store deployment does have a remote translog, so the replica is not part of the replication group  
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);  
        final String nodeId = nodeIdFromAllocationId(allocationId);  
                .filter(ShardRouting::relocating)
        final long initialClusterStateVersion = randomNonNegativeLong();
     * update. This test fails without an additional call to {@code ReplicationTracker#updateGlobalCheckpointOnPrimary()} after
        randomSubsetOf(randomIntBetween(1, initializing.size() - 1), initializing.keySet()).forEach(
            do {  
                type = "active";  
        tracker.startReplicationLagTimers(initialCheckpoint);  
        final AllocationId primaryId = active.iterator().next();  
        });
        // now we are going to add a new allocation ID and bring it in sync which should move it to the in-sync allocation IDs  
            oldPrimary.abortRelocationHandoff();
            this.version = version;
        final AtomicBoolean complete = new AtomicBoolean();
        initializing.keySet().forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));  
        // the tracking allocation IDs should play no role in determining the global checkpoint
                    ShardRoutingState.INITIALIZING,  
         */  
        final Map<AllocationId, Integer> initializingLocalCheckpoints = newInitializingAllocationIds.stream()  
    public void testInSyncIdsAreRemovedIfNotValidatedByClusterManager() {
    public void testWaitForAllocationIdToBeInSyncCanBeInterrupted() throws BrokenBarrierException, InterruptedException {
            );  
        final AllocationId primaryId = active.iterator().next();  
        final long initialClusterStateVersion = randomIntBetween(1, Integer.MAX_VALUE);
            .build();
                .collect(Collectors.toSet())  
            0L
            }
            activeLocalCheckpoints.entrySet()
            )
            throw new AssertionError("expected the leases to be created", e);  
import org.opensearch.indices.replication.common.ReplicationType;
import java.util.concurrent.atomic.AtomicLong;
            barrier.await();
                .stream()  
            numberOfActiveAllocationsIds,
     * remote translog, so operations not yet uploaded as segments are durable only on the primary and replica disks.  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
            Map.of("segment_1", segment1, "segment_2", segment2),  
        assertThat(tracker.getReplicationGroup().getReplicationTargets().size(), equalTo(1));
     * call is added after notifying all waiters in {@link ReplicationTracker#updateLocalCheckpoint(String, long)}).
        tracker.updateFromClusterManager(initialClusterStateVersion + 1, ids(newActiveAllocationIds), routingTable);
        final AllocationId primaryId = AllocationId.newInitializing();
            assertEquals(0L, shardStat.getBytesBehindCount());  
        initializing.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));
        markAsTrackingAndInSyncQuietly(  
    private static void randomLocalCheckpointUpdate(ReplicationTracker gcp) {
import org.opensearch.cluster.routing.AllocationId;
        }
        tracker.renewPeerRecoveryRetentionLeases();
        if (millisUntilFirstRenewal != 0) {
     * Segments-only remote store: index.remote_store.enabled is set because segments are uploaded, but there is no
        // synchronize starting with the waiting thread
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    private static void randomMarkInSync(ReplicationTracker oldPrimary, ReplicationTracker newPrimary) {
                );
            Math.toIntExact(Math.min(primaryLocalCheckpoint, minimumInitailizingLocalCheckpoint) - 1)  
        );
        initializingIds.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED));  
                // no cluster state update
                clusterState.apply(newPrimary);  
            initializingLocalCheckpoints.entrySet()  
}  
            tracker.getRetentionLeases().get(advancingLeaseId).retainingSequenceNumber(),
                barrier.await();  
        final ReplicationTracker.CheckpointState checkpointState = tracker.checkpoints.get(recoveringReplicaId.getId());  
                tracker.getRetentionLeases().leases().stream().map(RetentionLease::id).collect(Collectors.toSet()),
        return newTracker(allocationId, updatedGlobalCheckpoint::set, () -> 0L, settings);
            }
        // increment checkpoints
            Codec.getDefault().getName(),
    }
            assertThat(tracker.getGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
                routingTable(initializingToStay.keySet(), primaryId)  
        );
         * Now we will add an allocation ID to each of active and initializing and ensure they propagate through. Using different lengths
        assertTrue(  
    }
    ) {
        assertThat(leaseIds, hasItem(ReplicationTracker.getPeerRecoveryRetentionLeaseId(writeReplica)));
            shardId,  
            onNewRetentionLease,  
        routingTable = routingTable(newInitializingAllocationIds, primaryId);  
                tracker.initiateTracking(newSyncingAllocationId.getId());
        final ReplicationTracker tracker = newTracker(active);
        );  
        // the primary races ahead of the replica  
        }
        try {  
            1,
        assigned.entrySet()
    private ReplicationTracker newTracker(final AllocationId allocationId) {
 * Licensed to Elasticsearch under one or more contributor  
        IndexShardRoutingTable routingTable = builder.build();  
            Codec.getDefault().getName(),
            routingTableBuilder.removeShard(replicaShard);
                .allMatch(  
        tracker.updateLocalCheckpoint(allocationId, localCheckpoint);
        final ShardId shardId = new ShardId("test", "_na_", 0);  
        final long localCheckpoint,  
                routingTable(initializingToStay.keySet(), primaryId)
            );
    private static class FakeClusterState {
     * This test checks that updateGlobalCheckpointOnReplica with remote translog does not violate any of the invariants
            1L,
        assertReplicationLagTimersStartAfterRecoveryCompletes(true);
            newInitializingAllocationIds.stream()
     * The global checkpoint must therefore still be bounded by the replica.
    }
        assertFalse(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));
                ids(activeToStay.keySet()),
 * not use this file except in compliance with the License.
        for (final AllocationId replicaId : initializingAllocationIds) {
        assertTrue(initializingIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
            primaryContext = oldPrimary.startRelocationHandoff(newPrimary.shardAllocationId);
        )
            randomNonNegativeLong(),
         * We can not assert on shared knowledge of the global checkpoint between the old primary and the new primary as the new primary
            if (randomBoolean()) {  
        );
            ShardRoutingState.STARTED,
/*  
        final long newGlobalCheckpoint = initialGlobalCheckpoint + randomLongBetween(1, 1000);
            0L,
        );  
        tracker.startReplicationLagTimers(secondCheckpoint);
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
        assigned.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), 10 + localCP));  
            initializingIds.stream()
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(1, 5);
                clusterState.apply(oldPrimary);
        tracker.activatePrimaryMode(globalCheckpoint);
            1,
        final ReplicationTracker tracker = newTracker(primaryId, settings);
            }
        tracker.activatePrimaryMode(localCheckpoint);
        final Set<AllocationId> newInitializingAllocationIds = initializingIds.stream()  
            ids(Collections.singleton(primaryId)),
        newPrimary.updateRetentionLeasesOnReplica(oldPrimary.getRetentionLeases());  
        ReplicationTracker oldPrimary = new ReplicationTracker(
        final ReplicationTracker tracker = newTracker(primaryId);
                )
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);  
        assertThat(newPrimary.routingTable, equalTo(oldPrimary.routingTable));
        }
        assertTrue(
            // Also leases are renewed before reaching half the expiry time
        }
        // first check that adding it without the cluster-manager blessing doesn't change anything.
        // simulate transferring the global checkpoint to the new primary after finalizing recovery before the handoff
        active.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
            );  
                .filter(a -> a.equals(primaryId) == false)  
        if (randomBoolean()) {
        assertEquals(expectedIds.size(), groupStats.size());
        assertThat(updatedGlobalCheckpoint.get(), equalTo(update));
            )  
        assertTrue(initializingIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        assertEquals(updatedGlobalCheckpoint.get(), updatedLocalCheckpoint);  
        final Set<AllocationId> removingActiveAllocationIds = new HashSet<>(randomSubsetOf(activeAllocationIds));  
        // increment checkpoints
        final Map<AllocationId, Long> assigned = new HashMap<>();
        assertEquals(tracker.getGlobalCheckpoint(), primaryLocalCheckpoint);  
        activeAllocationIds.add(relocatingId);
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")  
        Map<AllocationId, Long> initializingWithCheckpoints = randomAllocationsWithLocalCheckpoints(0, 5);  
        // send primary context through the wire
        timer.start();  
        }
            .filter(a -> !removingActiveAllocationIds.contains(a))  
                // ensure we do not duplicate an allocation ID
        final AllocationId initializing = AllocationId.newInitializing();  
        final String allocationId,  
            Math.max(SequenceNumbers.NO_OPS_PERFORMED, oldPrimary.getGlobalCheckpoint() + randomInt(5))  
        final Thread initializingThread = new Thread(() -> {
        final ShardId shardId = new ShardId("test", "_na_", 0);
        assertThat(newPrimary.getGlobalCheckpoint(), equalTo(oldPrimary.getGlobalCheckpoint()));  
            .build();
            routingTable(
            }
        assertTrue(replicationTargets.containsAll(initializing));  
        tracker.updateFromClusterManager(  
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);  
            oldPrimary.checkpoints.get(oldPrimary.shardAllocationId).localCheckpoint,  
        assertThat(tracker.getReplicationGroup().getReplicationTargets().size(), equalTo(1 + initializing.size()));  
            nodeIdFromAllocationId(replicaId),  
        final Thread thread = new Thread(() -> {
        assertTrue(replicationTargets.containsAll(active));
            }
                )
        final Set<AllocationId> initializingIds = activeAndInitializingAllocationIds.v2();
        } else {
            numberOfInitializingIds
     * {@link ReplicationTracker#checkpoints}. Creating the missing peer-recovery retention leases during a remote
        final Thread thread = new Thread(() -> {
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
        final ReplicationTracker tracker = newTracker(primaryId);  
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
        // now notify for the new id
        Settings settings = Settings.builder()  
        barrier.await();
            false,
            151L,
            onUpdate,
        final int activeLocalCheckpoint = randomIntBetween(0, Integer.MAX_VALUE - 1);  
            initializingToStay.keySet().forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
            ids(newActiveAllocationIds),
        final ShardRouting searchReplica = TestShardRouting.newShardRouting(
            }  
        markAsTrackingAndInSyncQuietly(  
        assertThat(allocations.size(), equalTo(active.size() + initializing.size()));  
     * grouped listener for one more response than can ever arrive, leaving the leases permanently uncreated.  
        return newTracker(allocationId, updatedGlobalCheckpoint::set, () -> 0L);
            clusterState.initializingIds(),
        markingThread.join();
            } catch (final BrokenBarrierException | InterruptedException e) {
            primaryTerm,
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);  
        final Map<String, ReplicationTracker.CheckpointState> checkpoints = tracker.checkpoints;
            + 10; // we added 10 to make sure it's advanced in the second time
        assertThat(  
        final ReplicationTracker tracker = newTracker(active);  
            0L,
        tracker.updateFromClusterManager(  
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, primaryId));
        if (randomBoolean()) {  
                tracker.markAllocationIdAsInSync(newSyncingAllocationId.getId(), localCheckpoint);
        assertThat(newPrimary.replicationGroup, equalTo(oldPrimary.replicationGroup));
                // synchronize starting with the test thread  
        final long initialClusterStateVersion = randomNonNegativeLong();
        AllocationId primaryId = activeAllocationIds.iterator().next();
         * The new in-sync allocation ID is in the in-sync set now yet the cluster-manager does not know this; the allocation ID should still be in
            .filter(e -> !e.getKey().equals(missingActiveID))  
         * Now we will add an allocation ID to each of active and initializing and ensure they propagate through. Using different lengths
    private static FakeClusterState randomUpdateClusterState(Set<String> allocationIds, FakeClusterState clusterState) {  
        Set<AllocationId> newInitializing = new HashSet<>(initializing);  
            }
                nodeIdFromAllocationId(primaryId),
        );  
            primaryTerm,
        assertThat(updatedGlobalCheckpoint.get(), equalTo(UNASSIGNED_SEQ_NO));
            final String type;  
        nonApproved.keySet()
            // Leases still don't expire
    }  
        }  
            tracker.updateLocalCheckpoint(active.getId(), nextActiveLocalCheckpoint);
        assertThat(
 * The OpenSearch Contributors require contributions made to  
                clusterState.apply(newPrimary);
            } catch (final BrokenBarrierException | InterruptedException e) {
                initialClusterStateVersion + 1,  
        final Set<AllocationId> activeIds = Set.of(primaryId, recoveringReplicaId);
        // update again
            tracker.getReplicationGroup().getInSyncAllocationIds(),
                barrier.await();  
        tracker.updateFromClusterManager(  
        final long initialClusterStateVersion = randomNonNegativeLong();
        }
            allocations.forEach((aid, ckp) -> updateLocalCheckpoint(tracker, aid.getId(), ckp + 10L));
            .build();  
        assertThat(  
        final long primaryTerm = randomNonNegativeLong();
        logger.info("--> activeAllocationIds {} Primary {}", activeAllocationIds, primaryId.getId());
        );
        // now insert an unknown active/insync id , the checkpoint shouldn't change but a refresh should be requested.
                break;
                tracker.markAllocationIdAsInSync(newSyncingAllocationId.getId(), localCheckpoint);
            } else if (initializing.contains(aId)) {  
        assertNull(tracker.checkpoints.get(extraId.getId()));
            }
        } else {  
        final int numberOfActiveAllocationsIds = randomIntBetween(2, 16);  
        assertThat(allocations.size(), equalTo(active.size() + initializing.size()));  
        } else {
        final ShardId shardId = new ShardId("test", "_na_", 0);
            routingTable(initializingAllocationIds, Collections.singleton(primaryShard.allocationId()), primaryShard)
            .build();  
        );
        assertThat(tracker.getGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
            .collect(Collectors.toSet());
                tracker.getRetentionLeases().leases().stream().mapToLong(RetentionLease::timestamp).min().getAsLong(),  
        );  
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);  
            assertThat(expectedLeaseIds, hasItem(retentionLease.id()));
        tracker.updateGlobalCheckpointOnReplica(nonUpdate, "test");  
            equalTo(ids(Sets.difference(Sets.union(activeAllocationIds, newActiveAllocationIds), removingActiveAllocationIds)))
        Settings settings = Settings.builder()
        logger.info("--> using allocations");
        tracker.updateGlobalCheckpointOnReplica(globalCheckpoint, "test");
            .getReplicationTargets()
                clusterState.apply(newPrimary);  
        final long retentionLeaseExpiryTimeMillis = tracker.indexSettings().getRetentionLeaseMillis();
    /**  
            .getReplicationTargets()  
        newInitializingAllocationIds.add(AllocationId.newInitializing());
    /**
        }  
 * under the License.  
        allocations.keySet().forEach(aId -> {
        // now we expect that the global checkpoint would advance
                clusterState.apply(oldPrimary);  
            ShardRoutingState.STARTED,  
            newPrimary.shardAllocationId,
        tracker.updateLocalCheckpoint(replicaId.getId(), localCheckpoint);  
            .collect(Collectors.toSet());
            initialLeases.add(retentionLeaseFromAllocationId.apply(primaryId));
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(2, 5);  
    }  
                .allMatch(e -> tracker.getTrackedLocalCheckpointForShard(e.getKey().getId()).getLocalCheckpoint() == e.getValue())
        assertEquals(tracker.getGlobalCheckpoint(), checkpoint);  
                break;  
        allocations.putAll(activeToStay);
        );
import org.opensearch.core.action.ActionListener;  
import java.util.stream.Stream;
            updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));  
        assertFalse(oldPrimary.relocated);
        final StoreFileMetadata segment2 = new StoreFileMetadata("segment_2", 10L, "abcd", Version.LATEST);
            allocations.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));  
    }
                .allMatch(
        );
        final int numberOfInitializingIds = randomIntBetween(2, 16);  
        // now we will remove some allocation IDs from these and ensure that they propagate through
            oldPrimary.checkpoints.get(newPrimary.shardAllocationId).inSync,  
            Map.of("segment_1", segment_1),
        });
            }
        assertTrue(replicationTargets.containsAll(initializing));
        final ReplicationTracker tracker = newTracker(active, settings);
        thread.start();
                    shardId,
        Set<AllocationId> initializing = new HashSet<>(initializingWithCheckpoints.keySet());
            globalCheckpoint,  
        }  
            nodeIdFromAllocationId(relocatingId),  
        // now notify for the new id
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);  
        final int numberOfActiveAllocationsIds = randomIntBetween(2, 2);
    ) {
     * removing the allocation ID from the pending set in {@link ReplicationTracker#markAllocationIdAsInSync(String, long)} (even if a  
        assertEquals(1 + initializingRandomSubset.size(), tracker.getReplicationGroup().getReplicationTargets().size());  
        Settings settings = Settings.builder()
            Sets.union(ids(activeAllocationIds), ids(initializingIds)),
        final ReplicationTracker tracker = newTracker(primaryId, settings);
import org.opensearch.cluster.routing.ShardRoutingState;
                clusterState.apply(oldPrimary);
            if (active.contains(aId)) {
        tracker.setLatestReplicationCheckpoint(initialCheckpoint);
        final ReplicationCheckpoint initialCheckpoint = new ReplicationCheckpoint(
        assertAsTimePasses.accept(() -> {
            try {  
            .build();
        logger.info("--> initializingIds {} Target {}", initializingIds, targetAllocationId);  
                    nodeIdFromAllocationId(relocatingReplicaId),
        );  
            oldPrimary.checkpoints.get(newPrimary.shardAllocationId).localCheckpoint,
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
            if (randomBoolean()) {  
        // first we assert that the in-sync and tracking sets are set up correctly
    }
                clusterState.apply(newPrimary);
        Settings settings = Settings.builder()
            UNASSIGNED_SEQ_NO,  
            } else if (initializing.contains(aId)) {  
    private Map<AllocationId, Long> randomAllocationsWithLocalCheckpoints(int min, int max) {
import org.opensearch.test.IndexSettingsModule;
        assertThat(tracker.getGlobalCheckpoint(), equalTo(minLocalCheckpoint));  
        assertThat(tracker.getReplicationGroup().getReplicationTargets().size(), equalTo(1));
        }
         */
        newPrimaryCheckpointsCopy.remove(oldPrimary.shardAllocationId);
            updateLocalCheckpoint(tracker, trackingAllocationId.getId(), elements.get(i));
            }
                .allMatch(e -> tracker.getTrackedLocalCheckpointForShard(e.getKey().getId()).getLocalCheckpoint() == e.getValue())  
        });  
            globalCheckpoint,  
        assertThat(updatedGlobalCheckpoint.get(), equalTo(globalCheckpoint));  
        final ReplicationCheckpoint thirdCheckpoint = new ReplicationCheckpoint(  
 */  
        );  
    }
     */
        assertFalse(tracker.pendingInSync());
        allocations.putAll(initializingWithCheckpoints);
            ids(newActiveAllocationIds),
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
import java.util.HashMap;
        final Set<String> expectedIds = ids(initializingIds);
import java.util.Set;  
            1,
            if (rarely()) {
        Set<AllocationId> newInitializing = new HashSet<>(initializing);
        );
            case 0: {
        allocations.putAll(initializingToStay);  
        assertTrue(
        }
    public void testInSyncIdsAreIgnoredIfNotValidatedByClusterManagerWithRemoteTranslogEnabled() {
        AllocationId primaryId = activeAllocationIds.iterator().next();
     */
    }
        return new FakeClusterState(
        for (SegmentReplicationShardStats shardStat : groupStats) {  
        tracker.updateFromClusterManager(
                barrier.await();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            tracker.updateFromClusterManager(
            .build();
            }
        final ReplicationCheckpoint startedCheckpoint = new ReplicationCheckpoint(
        }  
            null
                tracker.getRetentionLeases().leases().stream().map(RetentionLease::id).collect(Collectors.toSet()),  
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
            }
            0L  
            onNewRetentionLease,  
        tracker.activatePrimaryMode(localCheckpoint);  
        );
        final AllocationId inSyncAllocationId = AllocationId.newInitializing();
            0L
            Codec.getDefault().getName(),
            NO_OPS_PERFORMED,
        final long localCheckpoint
        });
        final ReplicationCheckpoint secondCheckpoint = new ReplicationCheckpoint(
            initialLeases.add(retentionLeaseFromAllocationId.apply(AllocationId.newInitializing()));
    public void testGlobalCheckpointBoundedByReplicaWithSegmentsOnlyRemoteStore() throws InterruptedException {  
    public void testEmptyShards() {
        final int initializingLocalCheckpoint = randomIntBetween(0, nextActiveLocalCheckpoint - 1);
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
            initialClusterStateVersion + 3,
        /*  
        final ShardRouting primaryShard = TestShardRouting.newShardRouting(
        activeLocalCheckpoints.forEach((a, l) -> updateLocalCheckpoint(tracker, a.getId(), l));
            assertTrue(tracker.getTrackedLocalCheckpointForShard(trackingAllocationId.getId()).inSync);
        assertThat(newPrimary.appliedClusterStateVersion, equalTo(oldPrimary.appliedClusterStateVersion));  
            if (randomBoolean()) {
    public void testPrimaryContextHandoff() throws IOException {  
        }  
        // now we will remove some allocation IDs from these and ensure that they propagate through
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        final AllocationId primaryId = randomFrom(activeAllocationIds);
        }
        assertEquals(tracker.getGlobalCheckpoint(), primaryLocalCheckpoint);
            initializingToStay.keySet().forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
            final long shorterThanRenewalTime = randomLongBetween(0L, millisUntilFirstRenewal - 1);  
    /**  
                // apply cluster state update on both copies while primary context is being transferred
                tracker.renewPeerRecoveryRetentionLeases();
                currentTimeMillis.addAndGet(randomLongBetween(0L, retentionLeaseExpiryTimeMillis * 2));
        );
        final ShardId shardId = new ShardId("test", "_na_", 0);
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        assertThat(  
                throw new IllegalStateException(aId + " not found in any map");  
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(2, 5);
        final int numberOfInitializingIds = randomIntBetween(2, 2);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
        assertThat(tracker.getGlobalCheckpoint(), equalTo(checkpoint));  
        assertReplicationLagTimersStartAfterRecoveryCompletes(false);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        final int numberOfInitializingIds
        assertTrue(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);
        final AllocationId primaryId = active.iterator().next();
        Randomness.shuffle(elements);  
            () -> 0L,
            final String type;
            if (randomBoolean()) {  
                throw new AssertionError(e);
        final LongConsumer onUpdate = updatedGlobalCheckpoint -> {};  
        if (missingActiveID.equals(primaryId) == false) {  
        );  
        final Set<AllocationId> active = Sets.union(activeToStay.keySet(), activeToBeRemoved.keySet());
        tracker.updateFromClusterManager(
    public void testUpdateAllocationIdsFromClusterManager() throws Exception {
            if (rarely()) {
        barrier.await();
        final long minLocalCheckpointAfterUpdates = allocations.entrySet()
        return allocations;  
        assertNull(tracker.checkpoints.get(extraId.getId()));  
import org.opensearch.action.support.replication.ReplicationResponse;  
    public void testGlobalCheckpointNotBoundedByReplicaWithRemoteTranslog() throws InterruptedException {  
        // noinspection OptionalGetWithoutIsPresent  
        final AllocationId primaryId = active.iterator().next();
            }
import java.util.ArrayList;
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);  
         * than we have been using above ensures that we can not collide with a previous allocation ID
                    nodeIdFromAllocationId(initializingId),  
        tracker.updateLocalCheckpoint(primaryId.getId(), updatedLocalCheckpoint);
        final ReplicationTracker tracker = newTracker(primaryId, settings, remote);
    private void updateLocalCheckpoint(final ReplicationTracker tracker, final String allocationId, final long localCheckpoint) {
                break;
            0L,  
            () -> 0L,
            assertTrue(checkpoints.get(initializingId.getId()).checkpointTimers.isEmpty());
        Map<AllocationId, Long> allocations = new HashMap<>();
            1,
    }
                k -> expectThrows(IllegalStateException.class, () -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED))  
    }
            numberOfInitializingIds
        assertEquals(1, replicationStats.size());  
        final Set<AllocationId> initializingIds = Set.of(recoveringReplicaId);
            // abort handoff, check that we can continue updates and retry handoff
            .filter(a -> !removingActiveAllocationIds.contains(a))  
        final List<AllocationId> removingInitializingAllocationIds = randomSubsetOf(initializingIds);
            gcp.updateFromClusterManager(version, ids(inSyncIds), routingTable);  
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
            0L,  
            tracker.addPeerRecoveryRetentionLease(nodeId, NO_OPS_PERFORMED, ActionListener.wrap(() -> {}));
            onNewRetentionLease,  
        expectThrows(IllegalStateException.class, () -> tracker.markAllocationIdAsInSync(randomAlphaOfLength(10), randomNonNegativeLong()));  
        tracker.markAllocationIdAsInSync(replicaId.getId(), NO_OPS_PERFORMED);
            assertEquals(3, shardStat.getCheckpointsBehindCount());
        tracker.updateGlobalCheckpointOnReplica(update, "test");
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        for (AllocationId replicaId : initializingAllocationIds) {
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
        assertTrue(newActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        tracker.updateGlobalCheckpointOnReplica(nonUpdate, "test");
        final boolean addPRRL
                relocatingToNodeId,  
            2,
            randomIntBetween(Math.toIntExact(minimumActiveLocalCheckpoint), 1024)
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));  
            lessThanOrEqualTo(testStartTimeMillis + maximumTestTimeMillis)
        final Map<AllocationId, Long> activeToBeRemoved = randomAllocationsWithLocalCheckpoints(1, 5);
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);  
        Settings settings = Settings.builder()
        tracker.updateFromClusterManager(1L, Set.of(primaryId.getId()), routingTable(initializingIds, primaryId));  
        tracker.setLatestReplicationCheckpoint(thirdCheckpoint);
        assertEquals(10L, replicaStats.getBytesBehindCount());
        markingThread.start();
        groupStats = tracker.getSegmentReplicationStats();  
    }
import org.apache.lucene.util.Version;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertThat(updatedGlobalCheckpoint.get(), equalTo(minimumActiveLocalCheckpoint));  
        final ReplicationTracker tracker = newTracker(primaryId);
            shardId,
        // now it should be incremented  
        assertFalse(oldPrimary.primaryMode);  
        assertTrue(newPrimary.primaryMode);
        assertTrue(activeAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));  
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), randomInt((int) minLocalCheckpointAfterUpdates), false);
    }  
        tracker.initiateTracking(extraId.getId());  
        allocations.forEach(a -> a.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP)));
    public void testIllegalStateExceptionIfUnknownAllocationIdWithRemoteTranslogEnabled() {
 */
        final ShardId shardId = new ShardId("test", "_na_", 0);
            assertFalse(complete.get());  
    public void testPeerRecoveryRetentionLeaseCreationAndRenewal() {
import java.util.function.Function;
        markAsTrackingAndInSyncQuietly(oldPrimary, allocationId, newLocalCheckpoint);
                newPrimary.activateWithPrimaryContext(primaryContext);
        assertThat(newPrimary.replicationGroup, equalTo(oldPrimary.replicationGroup));
            tracker.updateFromClusterManager(
    public void testSegRepTimer() throws Throwable {  
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));
        initializingIds.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED));
                ShardRoutingState.STARTED,
 *  
            newInitializingAllocationIds.stream()
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));
        if (randomBoolean()) {
            0L,  
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        assigned.putAll(initializing);  
                    "should not have removed lease for " + replicaId + " in " + retentionLeases,
        newInitializing.add(extraId);
        final List<RetentionLease> initialLeases = new ArrayList<>();  
    }  
            randomNonNegativeLong(),  
import java.io.IOException;  
        assertTrue("expired extra lease", tracker.getRetentionLeases(true).v1());
        addPeerRecoveryRetentionLease(tracker, initializing);
            routingTable(Collections.singleton(trackingAllocationId), inSyncAllocationId)
                throw new RuntimeException(e);
        Set<AllocationId> initializing = new HashSet<>(initializingWithCheckpoints.keySet());
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        if (randomBoolean()) {
        groupStats = tracker.getSegmentReplicationStats();
        final long initialClusterStateVersion = randomNonNegativeLong();
    }
        }
        }
    public void testMarkAllocationIdAsInSyncWithRemoteTranslogEnabled() throws Exception {  
        }  
        // synchronize with the waiting thread to mark that it is complete  
        final Set<AllocationId> initializingIds = activeAndInitializingAllocationIds.v2();
                barrier.await();
                shardId,
            allocations.forEach((aid, ckp) -> updateLocalCheckpoint(tracker, aid.getId(), ckp + 10L));  
            primaryNode,
            routingTable(newInitializingAllocationIds, primaryId)  
        tracker.activatePrimaryMode(globalCheckpoint);  
            tracker.renewPeerRecoveryRetentionLeases();
        // now update all knowledge of all shards
                ids(activeToStay.keySet()),  
                .stream()
        }  
            numberOfInitializingIds  
            assertEquals(3, checkpointState.checkpointTimers.size());
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .map(ShardRouting::allocationId)
                tracker.markAllocationIdAsInSync(replicaId.getId(), randomLongBetween(NO_OPS_PERFORMED, localCheckpoint - 1));
        final AllocationId replicaId = AllocationId.newInitializing();
                tracker.initiateTracking(trackingAllocationId.getId());
                    primaryRelocationTarget,
            tracker.updateVisibleCheckpointForShard(id, initialCheckpoint);
        });  
        assertThat(updatedGlobalCheckpoint.get(), equalTo(primaryLocalCheckpoint));  
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
        final ReplicationTracker tracker = new ReplicationTracker(
        final SegmentReplicationShardStats replicaStats = replicationStats.iterator().next();
            equalTo(newPrimary.checkpoints.get(newPrimary.shardAllocationId).localCheckpoint)
        barrier.await();  
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            aId.getId(),  
                // apply cluster state update on old primary while primary context is being transferred  
            tracker.shardId(),
            return Sets.union(initializingIds(), inSyncIds);
        public void apply(ReplicationTracker gcp) {
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
 * this file be licensed under the Apache-2.0 license or a
        final AllocationId primaryId = active.keySet().iterator().next();  
            ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE  
                // activate new primary
        assertTrue(oldPrimary.primaryMode);
        clusterState.apply(oldPrimary);
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(2, 5);
        tracker.initiateTracking(replicaId.getId());  
        // simulate replicas moved up to date.  
        final CyclicBarrier barrier = new CyclicBarrier(2);  
        final Map<AllocationId, Long> activeToStay = randomAllocationsWithLocalCheckpoints(1, 5);  
            aId.getRelocationId(),  
                .filter(a -> a.equals(primaryId) == false)
        Set<AllocationId> active = new HashSet<>(activeWithCheckpoints.keySet());
        return allocationIds.stream().map(AllocationId::getId).collect(Collectors.toSet());
                equalTo(expectedLeaseIds)
        tracker.updateGlobalCheckpointOnReplica(update, "test");  
            .collect(Collectors.toMap(Function.identity(), a -> randomIntBetween(1, 1024)));
        final Map<AllocationId, Long> allocations = new HashMap<>();  
        assertTrue(oldPrimary.relocated);
            oldPrimary,
        );  
 * ownership. Elasticsearch licenses this file to you under  
        if (randomBoolean()) {
    }
            routingTable(Collections.singleton(initializing), active)
        final Set<AllocationId> removingActiveAllocationIds = new HashSet<>(randomSubsetOf(activeAllocationIds));  
        updatedGlobalCheckpoint.set(UNASSIGNED_SEQ_NO);  
            shardId,
        Settings settings = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
            }  
    }
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
            activeToStay.put(primaryId, activeToBeRemoved.remove(primaryId));  
        }).collect(Collectors.toSet());
public class ReplicationTrackerTests extends ReplicationTrackerTestCase {  
        final String advancingLeaseId = retentionLeaseFromAllocationId.apply(advancingAllocationId).id();
            assertTrue(tracker.checkpoints.get(initializingId.getId()).checkpointTimers.isEmpty());
        );
        final AllocationId primaryId = AllocationId.newInitializing();  
    public void testCreateMissingPeerRecoveryRetentionLeasesSkipsSearchReplicas() throws InterruptedException {
        final ReplicationTracker tracker = newTracker(active);
            oldPrimary.checkpoints.get(newPrimary.shardAllocationId).localCheckpoint,
        assertThat(tracker.getGlobalCheckpoint(), not(equalTo(UNASSIGNED_SEQ_NO)));  
            "lease was renewed because the shard advanced its global checkpoint",  
            2,  
        assertThat(newPrimary.routingTable, equalTo(oldPrimary.routingTable));
            initialClusterStateVersion + 2,  
        if (tracker.getRetentionLeases().contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(nodeId)) == false) {
            .orElse(UNASSIGNED_SEQ_NO);
            initialClusterStateVersion + 1,
            tracker.updateFromClusterManager(
        IndexShardRoutingTable.Builder routingTableBuilder = new IndexShardRoutingTable.Builder(routingTable);
        );
            if (rarely()) {
        assigned.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
            }
            }
        assertTrue(tracker.checkpoints.get(recoveringReplicaId.getId()).checkpointTimers.isEmpty());  
    }  
                final String leaseId = retentionLeaseFromAllocationId.apply(replicaId).id();  
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();  
            0L,
        ReplicationTracker oldPrimary = new ReplicationTracker(
        Set<SegmentReplicationShardStats> groupStats = tracker.getSegmentReplicationStats();
        expectThrows(IllegalStateException.class, () -> tracker.markAllocationIdAsInSync(randomAlphaOfLength(10), randomNonNegativeLong()));
        final AllocationId replicaId = initializing.iterator().next();
        final AllocationId initializing = AllocationId.newInitializing();  
    }
        final IndexShardRoutingTable routingTable;
                throw new IllegalStateException(aId + " not found in any map");  
        assertEquals(updatedGlobalCheckpoint.get(), UNASSIGNED_SEQ_NO);  
            .collect(Collectors.toMap(Function.identity(), a -> randomIntBetween(1, 1024)));
            .stream()
        final int numberOfActiveAllocationsIds = randomIntBetween(2, 16);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")  
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE - 1);
        for (int i = 0; i < elements.size(); i++) {
        ReplicationTracker.PrimaryContext primaryContext = oldPrimary.startRelocationHandoff(newPrimary.shardAllocationId);  
        });
            0L  
    }
        oldPrimary.completeRelocationHandoff();
        allocations.putAll(initializingToStay);  
        final AllocationId primaryId = activeAllocationIds.iterator().next();  
            onUpdate,
            }
        expectThrows(IllegalStateException.class, () -> tracker.initiateTracking(randomAlphaOfLength(10)));  
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);
        );  
            case 2: {
        final long localCheckpoint = randomLongBetween(0, Long.MAX_VALUE - 1);
    }
        primaryContext.writeTo(output);
        tracker.startReplicationLagTimers(thirdCheckpoint);  
        assertEquals(updatedGlobalCheckpoint.get(), primaryLocalCheckpoint);  
         * global checkpoint state after the primary context was transferred.
                throw new RuntimeException(e);
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        /*
        assertTrue(newInitializingAllocationIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        assertTrue(removingActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()) == null));  
    public void testMissingActiveIdsPreventAdvance() {
import org.opensearch.common.io.stream.BytesStreamOutput;  
        final Function<AllocationId, RetentionLease> retentionLeaseFromAllocationId = allocationId -> new RetentionLease(
        initializingIds.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED));
        barrier.await();  
                tracker.initiateTracking(trackingAllocationId.getId());
                complete.set(true);
        Thread.sleep(100);
        tracker.startReplicationLagTimers(recoveryCheckpoint);
            tracker.shardId(),
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
    public void testWaitForAllocationIdToBeInSync() throws Exception {  
                clusterState.apply(oldPrimary);  
        List<Map<AllocationId, Long>> allocations = Arrays.asList(active, initializing, nonApproved);  
        tracker.updateLocalCheckpoint(replicaId.getId(), 50L);
        IndexShardRoutingTable routingTable = routingTable(initializingIds, primaryId);
            tracker.shardId(),
            2,  
        final Map<AllocationId, Integer> activeLocalCheckpoints = newActiveAllocationIds.stream()  
        newInitializing.add(extraId);
        tracker.updateFromClusterManager(
                clusterState.routingTable.primaryShard()
            // ... and any extra peer recovery retention leases are expired immediately since the shard is fully active  
        tracker.startReplicationLagTimers(initialCheckpoint);  
        IndexShardRoutingTable routingTable = routingTable(initializingIds, primaryId);
        Set<AllocationId> active = new HashSet<>(activeWithCheckpoints.keySet());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    public void testMarkAllocationIdAsInSync() throws Exception {
    /**
        assertTrue(
            // abort handoff, check that we can continue updates and retry handoff
            .mapToObj(i -> AllocationId.newInitializing())
            allocations.putAll(activeToBeRemoved);
    }
                    return newAllocationId;
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        final int numberOfActiveAllocationsIds = randomIntBetween(2, 16);
        for (AllocationId initializingId : initializingIds) {
                throw new RuntimeException(e);
                .allMatch(e -> tracker.getTrackedLocalCheckpointForShard(e.getKey().getId()).getLocalCheckpoint() == e.getValue())
            onUpdate,
        final AllocationId recoveringReplicaId = AllocationId.newInitializing();  
        );
                // synchronize with the test thread checking if we are interrupted
        final int numberOfInitializingIds = randomIntBetween(0, 8);
                Collections.singleton(inSyncAllocationId.getId()),
                throw new RuntimeException(e);  
        updatedGlobalCheckpoint.set(UNASSIGNED_SEQ_NO);  
            numberOfActiveAllocationsIds,  
        );  
        Map<String, ReplicationTracker.CheckpointState> newPrimaryCheckpointsCopy = new HashMap<>(newPrimary.checkpoints);  
            while (currentTimeMillis.get() < startTime + retentionLeaseExpiryTimeMillis * 2) {  
            Sets.difference(ids(activeAllocationIds), Set.of(primaryId.getId()))  
        );  
        // Recovering replicas and unavailable allocation IDs do not receive replication lag timers.
        Settings settings = Settings.builder()  
        }
                initialClusterStateVersion + 2,  
        primaryContext.writeTo(output);
        assertThat(tracker.getGlobalCheckpoint(), equalTo((long) nextActiveLocalCheckpoint));  
        );  
        assertThat(tracker.getReplicationGroup().getReplicationTargets().size(), equalTo(1 + initializing.size()));  
    public void testSegmentReplicationLagTimersStartAfterRecoveryCompletes() {  
                newPrimary.activateWithPrimaryContext(primaryContext);
        // note: allocations can never be empty in practice as we always have at least one primary shard active/in sync
        Settings settings = Settings.builder()
        final int numUpdates = randomInt(10);
        }
        Map<AllocationId, Long> activeWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 1);
        // first we assert that the in-sync and tracking sets are set up correctly
        );
                    null,
            }
            updatedGlobalCheckpoint::set,
            try {
            oldPrimary.checkpoints.get(oldPrimary.shardAllocationId).inSync,
        assertFalse(oldPrimary.primaryMode);  
        }
            final RetentionLeases retentionLeases = tracker.getRetentionLeases();
        newPrimaryCheckpointsCopy.remove(newPrimary.shardAllocationId);
 * You may obtain a copy of the License at  
                routingTable(initializingToStay.keySet(), primaryId)
        // now notify for the new id
        Settings settings = Settings.builder()
        ReplicationTracker newPrimary = new ReplicationTracker(
    public void testPrimaryContextHandoffWithRemoteTranslogEnabled() throws IOException {
            builder.addShard(  
            .stream()
        final Set<SegmentReplicationShardStats> replicationStats = tracker.getSegmentReplicationStats();
        nonApproved.keySet()
        assertTrue(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);
        final Consumer<Runnable> assertAsTimePasses = assertion -> {
        activeLocalCheckpoints.forEach((a, l) -> updateLocalCheckpoint(tracker, a.getId(), l));
        } else {
            Math.max(SequenceNumbers.NO_OPS_PERFORMED, oldPrimary.getGlobalCheckpoint() + randomInt(5))  
        tracker.updateLocalCheckpoint(primaryId.getId(), updatedLocalCheckpoint);
            .build();  
        final CyclicBarrier barrier = new CyclicBarrier(2);  
        assertFalse(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")  
            1,
    public void testMissingInSyncIdsDoesNotPreventAdvanceWithRemoteTranslogEnabled() {
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(0, 5);  
                addPeerRecoveryRetentionLease(tracker, allocationId);
        final AllocationId newSyncingAllocationId = AllocationId.newInitializing();
            .forEach(e -> updateLocalCheckpoint(tracker, e.getKey().getId(), e.getValue()));
        );
        final ReplicationTracker tracker = newTracker(inSyncAllocationId);  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        );  
            logger.info("  - [{}], local checkpoint [{}], [{}]", aId, allocations.get(aId), type);
        assertFalse(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));  
            ShardRoutingState.RELOCATING,  
        updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));
        assertThat(tracker.getReplicationGroup().getInSyncAllocationIds(), equalTo(ids(activeAllocationIds)));
        final AllocationId newSyncingAllocationId = AllocationId.newInitializing();
    public void testInSyncIdsAreRemovedIfNotValidatedByClusterManagerWithRemoteTranslogEnabled() {
        tracker.updateFromClusterManager(initialClusterStateVersion + 1, ids(newActiveAllocationIds), routingTable);
 *
        final String allocationId = randomFrom(oldPrimary.checkpoints.keySet());  
        expectThrows(IllegalStateException.class, () -> tracker.initiateTracking(extraId.getId()));  
        assertBusy(() -> {
        assertThat(updatedGlobalCheckpoint.get(), equalTo(UNASSIGNED_SEQ_NO));
        final Set<AllocationId> existingAllocationIds,
        final long minLocalCheckpointAfterUpdates = allocations.values().stream().min(Long::compareTo).orElse(UNASSIGNED_SEQ_NO);
import org.opensearch.common.settings.Settings;
            assertThat(
 * this work for additional information regarding copyright
            if (rarely()) {
    }
                    nodeIdFromAllocationId(AllocationId.newInitializing(relocatingReplicaId.getRelocationId())),  
        final AllocationId extraId = AllocationId.newInitializing();
            3,
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();  
            assertThat(updatedGlobalCheckpoint.get(), equalTo(UNASSIGNED_SEQ_NO));
        assertFalse(oldPrimary.relocated);
    public void testInSyncIdsAreIgnoredIfNotValidatedByClusterManager() {
        builder.addShard(
                // no cluster state update
        tracker.updateVisibleCheckpointForShard("randomAllocationID", initialCheckpoint);  
        if (randomBoolean()) {
        }  
        StreamInput streamInput = output.bytes().streamInput();
        thread.start();  
            equalTo(newPrimary.checkpoints.get(newPrimary.shardAllocationId).inSync)
                break;
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
                .filter(a -> a.equals(primaryId) == false)
        clusterState.apply(oldPrimary);
            updateLocalCheckpoint(tracker, trackingAllocationId.getId(), randomIntBetween(globalCheckpoint, 64));
        tracker.startReplicationLagTimers(startedCheckpoint);
        expectThrows(IllegalStateException.class, () -> tracker.initiateTracking(extraId.getId()));
            randomNonNegativeLong(),
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                // synchronize starting with the test thread
                clusterState = randomUpdateClusterState(allocationIds, clusterState);  
            assertThat("renewal is a no-op after a short time", tracker.getRetentionLeases().version(), equalTo(initialVersion));  
            routingTable(Collections.singleton(trackingAllocationId), inSyncAllocationId)  
        tracker.markAllocationIdAsInSync(replicaId.getId(), randomLongBetween(NO_OPS_PERFORMED, localCheckpoint - 1));  
            .leases()
        });  
        for (int i = randomIntBetween(0, 5); i > 0; i--) {  
        final Set<AllocationId> initializingIdsToAdd = randomAllocationIdsExcludingExistingIds(
            try {
        tracker.setLatestReplicationCheckpoint(recoveryCheckpoint);  
            Collections.singleton(active.getId()),
            routingTable(Collections.singleton(initializing), active)
        final Map<AllocationId, Long> assigned = new HashMap<>();  
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));
        IndexShardRoutingTable routingTable = routingTable(initializingIds, primaryId);  
        final CyclicBarrier barrier = new CyclicBarrier(2);
        tracker.markAllocationIdAsInSync(replicaId.getId(), updatedLocalCheckpoint);  
        final long updatedLocalCheckpoint = randomLongBetween(1 + localCheckpoint, Long.MAX_VALUE);
        });
            numberOfInitializingIds
                barrier.await();
                newPrimary.activateWithPrimaryContext(primaryContext);
    public void testSegmentReplicationCheckpointTrackingInvalidAllocationIDs() {
            .stream()
            TestShardRouting.newShardRouting(shardId, nodeIdFromAllocationId(primaryId), null, true, ShardRoutingState.STARTED, primaryId)  
        assertTrue(  
        final Map<AllocationId, Long> activeToBeRemoved = randomAllocationsWithLocalCheckpoints(1, 5);
        addPeerRecoveryRetentionLease(tracker, extraId);
            tracker.getReplicationGroup().getInSyncAllocationIds(),
            } else {
                initialLeases.add(retentionLeaseFromAllocationId.apply(replicaId));  
                throw new RuntimeException(e);
        markAsTrackingAndInSyncQuietly(tracker, recoveringReplicaId.getId(), NO_OPS_PERFORMED);
        assertNull(tracker.checkpoints.get(extraId.getId()));
            .collect(Collectors.toSet());
        final Map<String, ReplicationTracker.CheckpointState> checkpoints = tracker.checkpoints;  
        IndexShardRoutingTable routingTable = routingTable(initializingAllocationIds, primaryId);
            0L
            Collections.singleton(inSyncAllocationId.getId()),  
        barrier.await();  
        initializingLocalCheckpoints.forEach((a, l) -> updateLocalCheckpoint(tracker, a.getId(), l));
                tracker.initiateTracking(newSyncingAllocationId.getId());
        final AllocationId relocatingReplicaId = AllocationId.newRelocation(replicaId);  
        assertTrue(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);
        assertThat(tracker.getGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));  
                newPrimary.activateWithPrimaryContext(primaryContext);
        assertThat(tracker.getGlobalCheckpoint(), not(equalTo(UNASSIGNED_SEQ_NO)));
        assertTrue(oldPrimary.relocated);
        assertThat("immediate renewal is a no-op", tracker.getRetentionLeases().version(), equalTo(initialVersion));
            Codec.getDefault().getName(),
     */
            ShardRoutingState.STARTED,
         */
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);
        final BiConsumer<RetentionLeases, ActionListener<ReplicationResponse>> onNewRetentionLease = (leases, listener) -> {};  
        assigned.putAll(active);
            indexSettings,
        // now update all knowledge of all shards
        }
         */
        );  
        final Set<String> leaseIds = tracker.getRetentionLeases().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());  
        );
        final Set<AllocationId> inSyncIds;  
    private static void markAsTrackingAndInSyncQuietly(  
    }
                tracker.markAllocationIdAsInSync(initializing.getId(), initializingLocalCheckpoint - 1);  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        final int numberOfActiveAllocationsIds = randomIntBetween(1, 8);  
    }
        final int localCheckpoint = randomIntBetween(1, 32);
        // A remote-enabled primary with a docrep write replica still left in the group, which is the situation
        final long initialClusterStateVersion = randomNonNegativeLong();  
        tracker.updateFromClusterManager(  
            newActiveAllocationIds.stream()  
        tracker.renewPeerRecoveryRetentionLeases();  
    }
 * Modifications Copyright OpenSearch Contributors. See
        );
        );
            .min()
        // we can however assert that shared knowledge of the local checkpoint and in-sync status is equal
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), randomInt((int) minLocalCheckpointAfterUpdates));
        );
    private static Tuple<Set<AllocationId>, Set<AllocationId>> randomActiveAndInitializingAllocationIds(
        final AllocationId primaryId = active.iterator().next();
        // synchronize starting with the waiting thread
        assertThat(
     * allocation ID to the in-sync set and removing it from pending, the local checkpoint update that freed the thread waiting for the
            2,  
        allocations.keySet().forEach(aId -> {  
                    shardId,
                randomMarkInSync(oldPrimary, newPrimary);
            Math.toIntExact(Math.min(minimumActiveLocalCheckpoint, minimumInitailizingLocalCheckpoint) - 1)  
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
            TestShardRouting.newShardRouting(  
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
        );
        updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));
        );
        ReplicationTracker.PrimaryContext primaryContext = oldPrimary.startRelocationHandoff(newPrimary.shardAllocationId);  
        Map<AllocationId, Long> allocations = new HashMap<>();
            // normal path, shard catches up  
        tracker.updateLocalCheckpoint(  
            equalTo(newPrimary.checkpoints.get(oldPrimary.shardAllocationId).inSync)  
        // now remove shards  
            return routingTable.getAllInitializingShards().stream().map(ShardRouting::allocationId).collect(Collectors.toSet());
        if (randomBoolean()) {  
        final long maximumTestTimeMillis = 13 * retentionLeaseExpiryTimeMillis;
        AllocationId targetAllocationId = initializingIds.iterator().next();
    public void testRaceUpdatingGlobalCheckpoint() throws InterruptedException, BrokenBarrierException {  
        });  
            routingTable(newInitializingAllocationIds, primaryId)  
        final long initialClusterStateVersion = randomNonNegativeLong();  
                Sets.difference(Sets.union(initializingIdsExceptRelocationTargets, initializingIdsToAdd), initializingIdsToRemove),  
        tracker.startReplicationLagTimers(checkpoint);
        return tracker.getGlobalCheckpoint();
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")  
        );
            .collect(Collectors.toMap(Function.identity(), a -> randomIntBetween(1, 1024)));
        oldPrimaryCheckpointsCopy.remove(oldPrimary.shardAllocationId);
    }
        );
        assertTrue(
            tracker.shardId(),  
        tracker.setLatestReplicationCheckpoint(secondCheckpoint);  
    public void testSegmentReplicationCheckpointTracking() {  
        Settings settings = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
                randomMarkInSync(oldPrimary, newPrimary);
            );  
        Settings settings = Settings.builder()
            assertNull(tracker.getTrackedLocalCheckpointForShard(trackingAllocationId.getId()));  
        }
        Settings settings = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));
        /*
            1,  
            if (randomBoolean()) {
/*
        updatedGlobalCheckpoint.set(UNASSIGNED_SEQ_NO);
        assertEquals(tracker.getReplicationGroup().getReplicationTargets().size(), active.size() + initializing.size());
        // first check that adding it without the cluster-manager blessing doesn't change anything.  
            case 1: {  
        final Set<AllocationId> newActiveAllocationIds = activeAllocationIds.stream()
        );
        );
            aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED)
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(  
 * Unless required by applicable law or agreed to in writing,
        if (activeToBeRemoved.containsKey(primaryId)) {
        assertTrue(groupStats.isEmpty());  
        activeAllocationIds.addAll(initializingAllocationIds);
        ReplicationTracker newPrimary = new ReplicationTracker(
            if (randomBoolean()) {  
     * and the global checkpoint advances with the primary alone.
                .allMatch(
     * ID to the in-sync set and remove it from the pending set before the local checkpoint updating thread executed the global checkpoint
        switch (randomInt(3)) {
        Map<String, ReplicationTracker.CheckpointState> newPrimaryCheckpointsCopy = new HashMap<>(newPrimary.checkpoints);  
        thread.join();  
    }
         *
        expectThrows(IllegalStateException.class, () -> tracker.initiateTracking(randomAlphaOfLength(10)));
        newPrimary.updateRetentionLeasesOnReplica(oldPrimary.getRetentionLeases());  
        );
        final Set<String> expectedLeaseIds = Stream.concat(Stream.of(primaryId), initializingAllocationIds.stream())  
            equalTo(newGlobalCheckpoint + 1)
                clusterState.apply(oldPrimary);  
        assertThat(
        // now we are going to add a new allocation ID and bring it in sync which should move it to the in-sync allocation IDs  
                randomLocalCheckpointUpdate(oldPrimary);
    public void testIllegalStateExceptionIfUnknownAllocationId() {
            ids(newActiveAllocationIds),
        assigned.putAll(active);
            replicaId
import java.util.Collection;  
        }
import java.util.concurrent.atomic.AtomicBoolean;  
        barrier.await();
        if (randomBoolean()) {
            currentTimeMillis.get(),
            tracker.shardId(),  
        newInitializingAllocationIds.add(newSyncingAllocationId);
            tracker.getRetentionLeases().leases().stream().allMatch(l -> l.timestamp() == currentTimeMillis.get())
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            "primary's retention lease should exist",  
                throw new RuntimeException(e);
        final Set<AllocationId> initializing = Sets.union(initializingToStay.keySet(), initializingToBeRemoved.keySet());
        final long minimumInitailizingLocalCheckpoint = (long) initializingLocalCheckpoints.values().stream().min(Integer::compareTo).get();
        final Set<AllocationId> active = Sets.union(activeToStay.keySet(), activeToBeRemoved.keySet());
        );
                break;  
    public void testGlobalCheckpointUpdate() {  
            .mapToLong(RetentionLease::timestamp)
        final long newLocalCheckpoint = Math.max(NO_OPS_PERFORMED, oldPrimary.getGlobalCheckpoint() + randomInt(5));
            case 0: {
        final long initialClusterStateVersion = randomNonNegativeLong();  
        for (final RetentionLease retentionLease : tracker.getRetentionLeases().leases()) {  
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(1, 5);
/*  
                randomMarkInSync(oldPrimary, newPrimary);
            equalTo(expectedLeaseIds)
    public void testMissingInSyncIdsPreventAdvance() {
        final AtomicBoolean completed = new AtomicBoolean();
    }
import java.util.stream.Collectors;  
            }
        public Set<AllocationId> initializingIds() {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                break;
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")  
import static org.hamcrest.Matchers.not;
        final IndexShardRoutingTable routingTable = new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
        assertAsTimePasses.accept(() -> {
            final long startTime = currentTimeMillis.get();
    ) {
    }
            51L,
        return allocationIds.stream().filter(aId -> !excludeIds.contains(aId.getId())).collect(Collectors.toSet());
            updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));  
                )
import org.opensearch.cluster.routing.ShardRouting;
        final CyclicBarrier barrier = new CyclicBarrier(4);
        );  
                // synchronize with the test thread checking if we are no longer waiting
        long primaryLocalCheckpoint = active.get(primaryId);
        active.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));  
        final Set<AllocationId> newActiveAllocationIds = activeAllocationIds.stream()
        });  
            initializingIds.stream()
        gcp.updateLocalCheckpoint(allocationId, Math.max(SequenceNumbers.NO_OPS_PERFORMED, currentLocalCheckpoint + randomInt(5)));
            true,
         * than we have been using above ensures that we can not collide with a previous allocation ID
        final long localCheckpoint = randomIntBetween(
        newInitializingAllocationIds.add(AllocationId.newInitializing());
        currentTimeMillis.set(testStartTimeMillis);  
        final AllocationId relocatingId = AllocationId.newRelocation(primaryId);  
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, primaryId));
            routingTable(newInitializingAllocationIds, primaryId)
            ids(newActiveAllocationIds),
            throw new RuntimeException(e);
                }
            .collect(Collectors.toSet());
        Settings settings = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();  
    private static FakeClusterState initialState() {
            ReplicationTracker.getPeerRecoveryRetentionLeaseId(nodeIdFromAllocationId(allocationId)),  
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();  
            globalCheckpoint,  
        assertThat(updatedGlobalCheckpoint.get(), equalTo(UNASSIGNED_SEQ_NO));
        final Map<AllocationId, Integer> initializingLocalCheckpoints = newInitializingAllocationIds.stream()  
        final long initialGlobalCheckpoint = Math.max(  
        Settings settings = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
        thread.join();
                assertTrue(
            }
        assertEquals(relocatingReplicaId.getId(), replicationStats.iterator().next().getAllocationId());  
 * SPDX-License-Identifier: Apache-2.0
import java.util.stream.IntStream;
        final Set<AllocationId> initializingIds = randomAllocationIdsExcludingExistingIds(activeAllocationIds, numberOfInitializingIds);  
        final CyclicBarrier barrier = new CyclicBarrier(2);  
        assertTrue(newInitializingAllocationIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));  
            "search-node",  
            numberOfInitializingIds
        final AllocationId active = AllocationId.newInitializing();
        final ReplicationTracker tracker = newTracker(active, settings);  
        final Set<AllocationId> initializingIds = activeAndInitializingAllocationIds.v2();  
        final Set<AllocationId> initializingIds = activeAndInitializingAllocationIds.v2();
            assertEquals(0, shardStat.getCheckpointsBehindCount());
            equalTo(newPrimary.checkpoints.get(newPrimary.shardAllocationId).inSync)
                clusterState.apply(oldPrimary);
            shardId,
        addPeerRecoveryRetentionLease(tracker, newSyncingAllocationId);
        newPrimaryCheckpointsCopy.remove(newPrimary.shardAllocationId);
    }
        final ReplicationTracker tracker = newTracker(primaryId);
        final long initialClusterStateVersion = randomNonNegativeLong();
        tracker.updateFromClusterManager(initialClusterStateVersion + 1, ids(active), routingTable(newInitializing, primaryId));
        // send primary context through the wire
            shardId,
            }
            clusterState.routingTable.activeShards()
    }  
            initialClusterStateVersion,
            tracker.shardId(),  
            Map.of("segment_1", segment1),  
            .stream()  
        clusterState.apply(newPrimary);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);  
        logger.info("--> using allocations");
        assertTrue(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Collections.shuffle(allocations, random());
        final AllocationId active = AllocationId.newInitializing();
        tracker.markAllocationIdAsInSync(replicaId.getId(), updatedLocalCheckpoint);
                initialClusterStateVersion + 1,
        initializingThread.start();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                tracker.markAllocationIdAsInSync(trackingAllocationId.getId(), localCheckpoint);
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
                assertion.run();
         *
     * translog stored locally.
            .collect(Collectors.toSet());
        final long localCheckpoint = randomLongBetween(0, Long.MAX_VALUE - 1);  
        assertThat(
     * Search replicas appear in the routing table but are never tracked by the primary, so they have no entry in  
        assertEquals(Set.of(checkpoint), tracker.checkpoints.get(relocatingReplicaId.getId()).checkpointTimers.keySet());  
                randomLocalCheckpointUpdate(oldPrimary);
    private static void addPeerRecoveryRetentionLease(final ReplicationTracker tracker, final AllocationId allocationId) {
        final AllocationId replicaId = AllocationId.newInitializing();
        } else {  
        Set<AllocationId> newInitializing = new HashSet<>(initializing);
        Map<AllocationId, Long> allocations = new HashMap<>(activeWithCheckpoints);  
                TestShardRouting.newShardRouting(
            case 2: {
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            nodeId -> primaryNode.equals(nodeId)
        thread.start();  
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
        final long millisUntilFirstRenewal = tracker.getRetentionLeases()
        allocations.putAll(initializingWithCheckpoints);
        assertTrue(
        final ReplicationTracker tracker = newTracker(primaryId);  
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(1, 5);
                barrier.await();  
            0L,
                clusterState = randomUpdateClusterState(allocationIds, clusterState);  
                type = "init";
        final ReplicationTracker tracker,
        // Unknown allocation ID will be ignored.
            numberOfInitializingIds
            assertFalse(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));
                clusterState.apply(oldPrimary);
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, primaryId));
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
            final ReplicationTracker.CheckpointState checkpointState = checkpoints.get(id);  
        );  
            }
                primaryId  
        });  
        final ReplicationTracker tracker = newTracker(AllocationId.newInitializing());  
            true,  
        oldPrimary.completeRelocationHandoff();
            1,
    public void testSegmentReplicationLagTimersTrackRelocatingReplicaSource() {
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            REMOTE_DISCOVERY_NODE
        long primaryLocalCheckpoint = active.get(primaryId);
            equalTo(newPrimary.checkpoints.get(oldPrimary.shardAllocationId).localCheckpoint)
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, primaryId));
        AllocationId primaryId = active.keySet().iterator().next();
        final AllocationId primaryId = active.keySet().iterator().next();
            equalTo(newPrimary.checkpoints.get(oldPrimary.shardAllocationId).localCheckpoint)
            .collect(Collectors.toSet());
        assertFalse(tracker.indexSettings().isRemoteTranslogStoreEnabled());
        tracker.updateFromClusterManager(  
        final ReplicationTracker tracker = newTracker(primaryId);
        initializing.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
        Map<AllocationId, Long> initializingWithCheckpoints = randomAllocationsWithLocalCheckpoints(0, 5);  
        );  
                // activate new primary  
        oldPrimary.updateGlobalCheckpointForShard(newPrimary.shardAllocationId, oldPrimary.getGlobalCheckpoint());
            equalTo(ids(Sets.difference(Sets.union(activeAllocationIds, newActiveAllocationIds), removingActiveAllocationIds)))
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            );  
    ) {
                )  
            assertTrue(shardStat.getCurrentReplicationLagMillis() >= shardStat.getCurrentReplicationTimeMillis());  
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            activeToStay.put(primaryId, activeToBeRemoved.remove(primaryId));  
                .filter(a -> a.equals(primaryId) == false)  
            ids(newActiveAllocationIds),
            this.routingTable = routingTable;  
                // apply cluster state update on new primary so that the states on old and new primary are comparable
        );  
        final AtomicBoolean interrupted = new AtomicBoolean();  
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);  
        addPeerRecoveryRetentionLease(tracker, AllocationId.newInitializing(allocationId));
        final long initialClusterStateVersion = randomNonNegativeLong();
            );  
        Map<AllocationId, Long> activeWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 5);  
        Map<AllocationId, Long> activeWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 5);  
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;  
            Codec.getDefault().getName(),
            exclude(clusterState.allIds(), allocationIds),
 * specific language governing permissions and limitations
        return newTracker(allocationId, updatedGlobalCheckpoint::set, () -> 0L, settings, remote);  
            shardId,
        allocations.forEach(a -> a.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP)));
        final Set<AllocationId> initializingAllocationIds = activeAndInitializingAllocationIds.v2();
                // apply cluster state update on new primary while primary context is being transferred
                Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build()  
        final String primaryNode = nodeIdFromAllocationId(primaryId);  
            primaryId.getId(),  
        allocations.keySet().forEach(aId -> {
            nodeIdFromAllocationId(AllocationId.newInitializing(relocatingId.getRelocationId())),
        assertTrue(removingInitializingAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()) == null));
            tracker.shardId(),
        assertThat(tracker.getGlobalCheckpoint(), greaterThan(minLocalCheckpoint));
    }
        if (randomBoolean()) {
    }  
        });
        BytesStreamOutput output = new BytesStreamOutput();  
        );
import java.util.Map;
        final long minLocalCheckpoint = allocations.values().stream().min(Long::compare).orElse(UNASSIGNED_SEQ_NO);
            assertFalse(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);  
                newPrimary.activateWithPrimaryContext(primaryContext);
        for (AllocationId initializingId : initializingIds) {
        } catch (final InterruptedException e) {  
        Set<AllocationId> initializing = new HashSet<>(initializingWithCheckpoints.keySet());
         */
            () -> 0L,
        final long localCheckpoint = randomIntBetween(
        final StoreFileMetadata segment = new StoreFileMetadata("segment_1", 5L, "abcd", Version.LATEST);
        }  
     */  
                TestShardRouting.newShardRouting(  
        );
            relocatingId
        routingTable = routingTable(newInitializingAllocationIds, primaryId);  
        // using a different length than we have been using above ensures that we can not collide with a previous allocation ID  
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        assertThat(  
            1,
        );
            numberOfActiveAllocationsIds,  
        expectThrows(IllegalStateException.class, () -> tracker.initiateTracking(extraId.getId()));
        tracker.updateRetentionLeasesOnReplica(new RetentionLeases(randomNonNegativeLong(), randomNonNegativeLong(), initialLeases));  
        tracker.updateLocalCheckpoint(newSyncingAllocationId.getId(), randomIntBetween(Math.toIntExact(primaryLocalCheckpoint), 1024));  
        assertFalse(tracker.pendingInSync.contains(trackingAllocationId.getId()));
    public void testRemoteStoreReplicationLagTimersStartAfterRecoveryCompletes() {
        tracker.updateFromClusterManager(
import java.util.Collections;
        oldPrimary.updateGlobalCheckpointForShard(newPrimary.shardAllocationId, oldPrimary.getGlobalCheckpoint());
        final long nonUpdate = randomLongBetween(NO_OPS_PERFORMED, globalCheckpoint);  
            .forEach(e -> updateLocalCheckpoint(tracker, e.getKey().getId(), e.getValue()));  
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
        newPrimaryCheckpointsCopy.remove(oldPrimary.shardAllocationId);
            assertTrue(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);  
                barrier.await();
        );
            if (randomBoolean()) {  
            .stream()
            oldPrimary.abortRelocationHandoff();
        tracker.updateFromClusterManager(1L, Set.of(primaryId.getId()), routingTable(Set.of(replicaId), primaryId));
            case 1: {  
        final long globalCheckpoint = UNASSIGNED_SEQ_NO;
                .filter(a -> a.equals(primaryId) == false)
        final Set<SegmentReplicationShardStats> replicationStats = tracker.getSegmentReplicationStats();
            equalTo(newPrimary.checkpoints.get(oldPrimary.shardAllocationId).inSync)  
                .map(s -> s.allocationId().getRelocationId())
        final StoreFileMetadata segment_2 = new StoreFileMetadata("segment_2", 50L, "abcd", Version.LATEST);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        Map<AllocationId, Long> activeWithCheckpoints = randomAllocationsWithLocalCheckpoints(2, 5);
        AllocationId primaryId = active.keySet().iterator().next();
            allocations.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
        });
        final StoreFileMetadata segment1 = new StoreFileMetadata("segment_1", 5L, "abcd", Version.LATEST);
        );
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(2, 5);
            case 3: {  
            numberOfInitializingIds
        oldPrimaryCheckpointsCopy.remove(newPrimary.shardAllocationId);
            .map(Map.Entry::getValue)  
        // update again
                final AllocationId newAllocationId = AllocationId.newInitializing();
        final int globalCheckpoint = randomIntBetween(localCheckpoint + 1, 64);
        final Thread thread = new Thread(() -> {
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
        markAsTrackingAndInSyncQuietly(tracker, allocationId, localCheckpoint, true);  
import java.util.List;
            assertThat(
            .addShard(
            if (active.contains(aId)) {
            if (randomBoolean()) {  
            Collections.emptyMap(),
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
    public void testSegmentReplicationCheckpointForRelocatingPrimary() {
            0,
        tracker.renewPeerRecoveryRetentionLeases();
        assertEquals(50L, globalCheckpointWithReplicaBehindPrimary(settings, false));
        }
            .getAsLong() + peerRecoveryRetentionLeaseRenewalTimeMillis - currentTimeMillis.get();  
            routingTable(Collections.singleton(replicaId), primaryId)  
            clusterState.version + randomIntBetween(1, 5),  
        assertEquals(updatedGlobalCheckpoint.get(), 10 + primaryLocalCheckpoint);
            assertEquals(updatedGlobalCheckpoint.get(), primaryLocalCheckpoint);  
        tracker.updateGlobalCheckpointOnReplica(globalCheckpoint, "test");
        final ShardRouting primaryShard = TestShardRouting.newShardRouting(
                clusterStateVersion + 1,  
        final long minLocalCheckpointAfterUpdates = allocations.values().stream().min(Long::compareTo).orElse(UNASSIGNED_SEQ_NO);  
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);  
                // activate new primary
    }
        final Map<AllocationId, Long> initializingToStay = randomAllocationsWithLocalCheckpoints(1, 5);
        final Set<AllocationId> remainingInSyncIds = Sets.difference(clusterState.inSyncIds, inSyncIdsToRemove);
            .build();
        assertEquals(updatedGlobalCheckpoint.get(), updatedLocalCheckpoint);
        initializing.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED, false));
            newPrimary.shardAllocationId,
        } else {  
        final AllocationId primaryId = active.iterator().next();  
        assertNull("precondition: the search replica is not tracked", tracker.checkpoints.get(searchReplica.allocationId().getId()));
        tracker.initiateTracking(replicaId.getId());
        } else {  
        timer.stop();
                clusterState.apply(newPrimary);
        assertEquals(Set.of(startedCheckpoint), checkpointState.checkpointTimers.keySet());
import org.opensearch.index.SegmentReplicationShardStats;
            shardId,
import java.util.concurrent.CyclicBarrier;
        final long checkpoint = Stream.concat(activeToStay.values().stream(), initializingToStay.values().stream()).min(Long::compare).get()  
        for (String id : expectedIds) {
    }
        Settings settings = Settings.builder()
            }
                randomMarkInSync(oldPrimary, newPrimary);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
            } catch (final BrokenBarrierException | InterruptedException e) {
        AllocationId primaryId = active.keySet().iterator().next();  
        List<Map<AllocationId, Long>> allocations = Arrays.asList(active, initializing, nonApproved);  
            boolean primaryRelocationTarget = initializingId.equals(targetAllocationId);
        thread.start();
            }
            primaryId
            0L  
    }
        tracker.initiateTracking(replicaId.getId());  
        assertTrue("Total time since timer was created should be greater than 200", timer.totalElapsedTime() >= 200);
            } catch (final BrokenBarrierException | InterruptedException e) {  
                barrier.await();
            routingTable(newInitializingAllocationIds, primaryId)
    }  
            );
        final ReplicationTracker tracker = newTracker(primaryId, settings, shardOnRemoteEnabledNode);  
        oldPrimary.activatePrimaryMode(randomIntBetween(Math.toIntExact(NO_OPS_PERFORMED), 10));
            } catch (final BrokenBarrierException | InterruptedException e) {
        // A started search replica. It is assigned, but the cluster manager keeps it out of the in-sync set.  
            try {  
         * the in-sync set even if we receive a cluster state update that does not reflect this.  
        final IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);  
        if (randomBoolean()) {
        if (randomBoolean()) {
            null,
        final Map<AllocationId, Long> allocations = new HashMap<>();  
    public void testUpdateAllocationIdsFromClusterManagerWithRemoteTranslogEnabled() throws Exception {  
                    initialLeases.stream().noneMatch(l -> l.id().equals(leaseId)) || retentionLeases.contains(leaseId)  
                )
            Map.of("segment_1", segment_1),
                type = "init";
        Set<AllocationId> replicationTargets = tracker.getReplicationGroup()
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));
        assertTrue(newInitializingAllocationIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
     * @throws InterruptedException   if the main test thread was interrupted while waiting  
            markAsTrackingAndInSyncQuietly(tracker, replicaId.getId(), NO_OPS_PERFORMED);
        final CyclicBarrier barrier = new CyclicBarrier(2);  
                .stream()
            assertEquals(0, checkpointState.checkpointTimers.size());
                )
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);  
            () -> 0L,
        Map<AllocationId, Long> activeWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 1);  
        tracker.updateFromClusterManager(initialClusterStateVersion + 1, ids(active), routingTable(newInitializing, primaryId));  
        logger.info("--> using allocations");
        );
        assertEquals(  
     * store migration must skip them; including them would dereference a null checkpoint and would also size the
        final long primaryTerm = randomNonNegativeLong();
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, active, primaryId));  
            tracker.updateVisibleCheckpointForShard(id, thirdCheckpoint);
        assertTrue(tracker.hasAllPeerRecoveryRetentionLeases());
        updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));  
                // activate new primary  
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);  
        assertEquals(updatedGlobalCheckpoint.get(), primaryLocalCheckpoint);
            Map.of("segment_1", segment),  
        assertThat(newPrimaryCheckpointsCopy, equalTo(oldPrimaryCheckpointsCopy));  
        tracker.updateFromClusterManager(initialClusterStateVersion + randomLongBetween(1, 10), ids(activeAllocationIds), routingTable);
            assertEquals(150L, shardStat.getBytesBehindCount());
        final ReplicationCheckpoint recoveryCheckpoint = new ReplicationCheckpoint(
            primaryTerm,
                clusterState.apply(newPrimary);  
        markAsTrackingAndInSyncQuietly(tracker, replicaId.getId(), NO_OPS_PERFORMED);
        assertTrue(groupStats.isEmpty());  
        thread.join();
        initializing.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED));
            // cluster state update after primary context handoff  
            true,  
        assertTrue(newActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
            .addShard(writeReplica)  
                routingTable(emptySet(), inSyncAllocationId)
import org.opensearch.common.collect.Tuple;
        );
        if (randomBoolean()) {  
        if (missingActiveID.equals(primaryId) == false) {
                type = "init";
        for (String id : expectedIds) {
        });  
        assertThat("renewal happens after a sufficiently long time", tracker.getRetentionLeases().version(), greaterThan(initialVersion));
            tracker.addPeerRecoveryRetentionLease(randomAlphaOfLength(10), randomNonNegativeLong(), ActionListener.wrap(() -> {}));
            }
            tracker.markAllocationIdAsInSync(allocationId, localCheckpoint);
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, active, primaryId));
                clusterState.apply(oldPrimary);  
        tracker.markAllocationIdAsInSync(replicaId.getId(), 10L);
                clusterState.apply(newPrimary);
    private AtomicLong updatedGlobalCheckpoint = new AtomicLong(UNASSIGNED_SEQ_NO);  
        );  
        allocations.putAll(activeWithCheckpoints);
            // do another handoff
            routingTable(Collections.emptySet(), startedAllocationIds, primaryId)
        };  
        if (activeToBeRemoved.containsKey(primaryId)) {
            ? primaryId
                if (!existingAllocationIds.contains(newAllocationId)) {  
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        );
                clusterState.apply(oldPrimary);  
    public void testUpdateGlobalCheckpointOnReplicaWithRemoteTranslogEnabled() {
        Set<AllocationId> initializing = new HashSet<>(initializingWithCheckpoints.keySet());  
            initializingLocalCheckpoints.entrySet()  
        /*
import org.opensearch.indices.replication.common.SegmentReplicationLagTimer;  
            0L
        final Map<AllocationId, Long> nonApproved = randomAllocationsWithLocalCheckpoints(1, 5);
            .filter(a -> !removingInitializingAllocationIds.contains(a))
        assertThat(tracker.getGlobalCheckpoint(), equalTo(minimumActiveLocalCheckpoint));
        assertTrue("Total elapsed time should be greater than time since timer start", timer.totalElapsedTime() - timer.time() >= 100);
        thread.interrupt();
            try {
        final ReplicationTracker tracker,
            Map.of("segment_1", segment_1, "segment_2", segment_2, "segment_3", segment_3),
                .allMatch(  
            shardId,
        final AllocationId extraId = AllocationId.newInitializing();  
        // simulate transferring the global checkpoint to the new primary after finalizing recovery before the handoff
        assertThat(updatedGlobalCheckpoint.get(), equalTo(updatedLocalCheckpoint));
        barrier.await();
                true,
    private ReplicationTracker newTracker(final AllocationId allocationId, Settings settings, boolean remote) {
        }
                // apply cluster state update on both copies while primary context is being transferred
            indexSettings,
            if (randomBoolean()) {
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
        final long version;
        final AllocationId replicaId = AllocationId.newInitializing();
        // the tracking allocation IDs should play no role in determining the global checkpoint
    }
            .collect(Collectors.toSet());
        assertEquals(tracker.getReplicationGroup().getRoutingTable(), routingTable);
            );
                tracker.initiateTracking(initializing.getId());
        final Set<AllocationId> initializingIdsToRemove = new HashSet<>(
        newInitializing.add(extraId);  
 * software distributed under the License is distributed on an
        final long initialVersion = tracker.getRetentionLeases().version();
            exclude(randomSubsetOf(randomInt(clusterState.inSyncIds.size()), clusterState.inSyncIds), allocationIds)  
         * the in-sync set even if we receive a cluster state update that does not reflect this.  
        final AllocationId active = AllocationId.newInitializing();
            tracker.shardId(),  
        );
        tracker.updateFromClusterManager(2L, ids(activeIds), routingTable(Collections.emptySet(), activeIds, primaryId));
        AllocationId primaryId = activeAllocationIds.iterator().next();
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        }
        assertTrue(  
        for (int i = 0; i < numUpdates; i++) {  
        final int numberOfInitializingIds = randomIntBetween(2, 16);
                clusterState.apply(oldPrimary);
        final long checkpoint = activeToStay.get(primaryId) + 10;
        final AllocationId active = AllocationId.newInitializing();
        assertTrue(
         */  
     *
    private ReplicationTracker newTracker(final AllocationId allocationId, Settings settings) {  
        for (int i = 0; i < numUpdates; i++) {  
            logger.info("  - [{}], local checkpoint [{}], [{}]", aId, allocations.get(aId), type);  
        tracker.updateFromClusterManager(
    }  
            } catch (final BrokenBarrierException | InterruptedException e) {
        Set<AllocationId> active = new HashSet<>(activeWithCheckpoints.keySet());
        final int numberOfActiveAllocationsIds = randomIntBetween(1, 8);  
        tracker.setLatestReplicationCheckpoint(startedCheckpoint);  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                clusterState.apply(newPrimary);  
        assertTrue(removingInitializingAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()) == null));
        assertThat(newPrimaryCheckpointsCopy, equalTo(oldPrimaryCheckpointsCopy));  
        }));
        /*
            initialClusterStateVersion + 4,
        final AtomicLong currentTimeMillis = new AtomicLong(0L);
    }
import java.util.concurrent.BrokenBarrierException;
        initializing.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));  
        for (int i = randomIntBetween(min, max); i > 0; i--) {  
            initialClusterStateVersion + 3,
        final long updatedLocalCheckpoint = randomLongBetween(1 + localCheckpoint, Long.MAX_VALUE);
        Collections.shuffle(allocations, random());
        oldPrimaryCheckpointsCopy.remove(newPrimary.shardAllocationId);
        tracker.renewPeerRecoveryRetentionLeases();
        assertTrue(activeAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));  
    }
        );
            allocations.forEach((aid, ckp) -> updateLocalCheckpoint(tracker, aid.getId(), ckp + 10L));
        });
                Collections.singleton(clusterState.routingTable.primaryShard().allocationId()),
     */  
        final int numberOfInitializingIds = randomIntBetween(0, 8);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")  
import org.opensearch.index.IndexSettings;  
            Sets.union(ids(activeAllocationIds), ids(initializingIds)),  
        barrier.await();
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
        initializing.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED, false));  
    public void testUpdateGlobalCheckpointOnReplica() {
        assertEquals(1, replicaStats.getCheckpointsBehindCount());  
            );
    /**
        Map<AllocationId, Long> initializingWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 1);
        switch (randomInt(3)) {
    public void testGlobalCheckpointBoundedByReplicaWithoutClusterStateRepo() throws InterruptedException {
        );
    }
            }  
        final AllocationId primaryId = AllocationId.newInitializing();
            1,  
        final long update = randomLongBetween(globalCheckpoint, Long.MAX_VALUE);
        final Map<AllocationId, Integer> activeLocalCheckpoints = newActiveAllocationIds.stream()  
                    ShardRoutingState.RELOCATING,
        addPeerRecoveryRetentionLease(tracker, trackingAllocationId);  
        tracker.startReplicationLagTimers(initialCheckpoint);
        active.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));  
     * local checkpoint to advance could miss updating the global checkpoint in a race if the waiting thread did not add the allocation  
        final int numberOfAllocationIds  
        final long clusterStateVersion = randomNonNegativeLong();
        assertEquals(recoveringReplicaId.getId(), replicaStats.getAllocationId());
            NON_REMOTE_DISCOVERY_NODE
        );  
            allocations.forEach((aid, ckp) -> updateLocalCheckpoint(tracker, aid.getId(), ckp + 10L));
         * global checkpoint state after the primary context was transferred.
        if (randomBoolean()) {  
                clusterState.apply(newPrimary);
        final IndexShardRoutingTable relocatingRoutingTable = new IndexShardRoutingTable.Builder(shardId).addShard(
            } catch (final BrokenBarrierException | InterruptedException e) {  
        final int nextActiveLocalCheckpoint = randomIntBetween(activeLocalCheckpoint + 1, Integer.MAX_VALUE);  
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
    private void assertReplicationLagTimersStartAfterRecoveryCompletes(boolean remote) {  
        final int globalCheckpoint = randomIntBetween(localCheckpoint + 1, 64);
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));  
        assertTrue(newPrimary.primaryMode);
        final Map<AllocationId, Long> initializingToBeRemoved = randomAllocationsWithLocalCheckpoints(1, 5);  
                greaterThanOrEqualTo(currentTimeMillis.get() - peerRecoveryRetentionLeaseRenewalTimeMillis)
         * We can not assert on shared knowledge of the global checkpoint between the old primary and the new primary as the new primary
            allocations.put(AllocationId.newInitializing(), (long) randomInt(1000));
            primaryContext = oldPrimary.startRelocationHandoff(newPrimary.shardAllocationId);
        final AllocationId missingActiveID = randomFrom(active.keySet());
            initializing.forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
            REMOTE_DISCOVERY_NODE
            // Leases still don't expire
            .forEach(
        assertThat(leaseIds, not(hasItem(ReplicationTracker.getPeerRecoveryRetentionLeaseId(searchReplica))));  
                // apply cluster state update on new primary while primary context is being transferred
            (leases, listener) -> listener.onResponse(new ReplicationResponse()),  
        FakeClusterState clusterState = initialState();
        assertThat(
        final Set<AllocationId> initializingIdsExceptRelocationTargets = exclude(  
        final long nonUpdate = randomLongBetween(NO_OPS_PERFORMED, globalCheckpoint);
        final Set<AllocationId> initializing = Sets.union(initializingToStay.keySet(), initializingToBeRemoved.keySet());
        assertEquals(expectedIds.size(), groupStats.size());  
        activeThread.start();  
        assertTrue(
            .build();
        assigned.entrySet()  
        // now remove shards
        long currentLocalCheckpoint = gcp.checkpoints.get(allocationId).getLocalCheckpoint();
            clusterStateVersion,
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(1, 5);  
    }  
            tracker.updateFromClusterManager(
            Codec.getDefault().getName(),  
                clusterState.apply(oldPrimary);
                .allMatch(  
        final long update = randomLongBetween(globalCheckpoint, Long.MAX_VALUE);
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
                equalTo(expectedLeaseIds)
        final Set<AllocationId> newInitializingAllocationIds = initializingIds.stream()  
            if (active.contains(aId)) {
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
            } catch (final BrokenBarrierException | InterruptedException e) {
        primaryContext = new ReplicationTracker.PrimaryContext(streamInput);  
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);  
            .build();
        newInitializingAllocationIds.add(newSyncingAllocationId);
            }  
                )
        assertEquals(  
            try {  
        Settings settings = Settings.builder()  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
     * Plain segment replication with a local translog. The replica is part of the replication group, so the global
        final Thread activeThread = new Thread(() -> {
        Settings settings = Settings.builder()
            try {
import java.util.Arrays;
            0L
            remainingInSyncIds.isEmpty() ? clusterState.inSyncIds : remainingInSyncIds,
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(
        if (randomBoolean()) {
        assertThat(newPrimary.appliedClusterStateVersion, equalTo(oldPrimary.appliedClusterStateVersion));  
        );
        final ShardId shardId = new ShardId("test", "_na_", 0);
            .forEach(
            0,
        updatedGlobalCheckpoint.set(UNASSIGNED_SEQ_NO);
    }
        for (SegmentReplicationShardStats shardStat : groupStats) {
        IndexShardRoutingTable routingTable = routingTable(initializingIds, primaryId);
        assertThat(updatedGlobalCheckpoint.get(), not(equalTo(UNASSIGNED_SEQ_NO)));
        allocations.putAll(activeToStay);
            assertTrue(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));
            oldPrimary.checkpoints.get(oldPrimary.shardAllocationId).inSync,
        );
            .stream()  
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
        assertEquals(50L, globalCheckpointWithReplicaBehindPrimary(settings, false));
        addPeerRecoveryRetentionLease(oldPrimary, newPrimary.shardAllocationId);
        AllocationId primaryId = activeAllocationIds.iterator().next();  
            .min(Long::compareTo)
        tracker.updateLocalCheckpoint(replicaId.getId(), localCheckpoint);
        );  
        for (SegmentReplicationShardStats shardStat : groupStats) {
        initializingLocalCheckpoints.forEach((a, l) -> updateLocalCheckpoint(tracker, a.getId(), l));
            .map(ShardRouting::allocationId)
                interrupted.set(true);
            false,
                true,
    }
            "All active & initializing ids are now marked in-sync",
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));  
            tracker.getReplicationGroup().getUnavailableInSyncShards(),
     * checkpoint cannot advance past it.  
                barrier.await();  
                initialClusterStateVersion + 2,
        tracker.startReplicationLagTimers(initialCheckpoint);  
            }
        assertThat(tracker.getRetentionLeases().get(advancingLeaseId).retainingSequenceNumber(), equalTo(initialGlobalCheckpoint + 1));
        return IntStream.range(0, numberOfAllocationIds).mapToObj(i -> {
        active.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        Set<String> allocationIds = new HashSet<>(Arrays.asList(oldPrimary.shardAllocationId, newPrimary.shardAllocationId));
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        FakeClusterState clusterState = initialState();
        assertThat(allocations.size(), equalTo(active.size() + initializing.size()));
            null,
        final StoreFileMetadata segment_1 = new StoreFileMetadata("segment_1", 5L, "abcd", Version.LATEST);  
    public void testUpdateFromClusterManagerWithRemoteTranslogEnabled() {
    }
        addPeerRecoveryRetentionLease(oldPrimary, newPrimary.shardAllocationId);
    }
        initializing.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));  
    private static void markAsTrackingAndInSyncQuietly(
        final Thread markingThread = new Thread(() -> {
        final Thread thread = new Thread(() -> {
        final Set<AllocationId> initializingIds = activeAndInitializingAllocationIds.v2();
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4), false);  
        initializing.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));
        Map<AllocationId, Long> initializingWithCheckpoints = randomAllocationsWithLocalCheckpoints(0, 5);
     */
            assertEquals(2, checkpointState.checkpointTimers.size());  
            5L,
        assertThat(updatedGlobalCheckpoint.get(), equalTo(NO_OPS_PERFORMED));
            indexSettings,
        Map<String, ReplicationTracker.CheckpointState> oldPrimaryCheckpointsCopy = new HashMap<>(oldPrimary.checkpoints);  
        final Map<AllocationId, Long> nonApproved = randomAllocationsWithLocalCheckpoints(1, 5);
        assertThat(updatedGlobalCheckpoint.get(), equalTo(tracker.getGlobalCheckpoint()));  
        final ReplicationTracker tracker = newTracker(primaryId, settings);
            }
        final StoreFileMetadata segment_3 = new StoreFileMetadata("segment_3", 100L, "abcd", Version.LATEST);  
            )
        final int numberOfInitializingIds = randomIntBetween(2, 16);
        // now insert an unknown active/insync id , the checkpoint shouldn't change but a refresh should be requested.
        tracker.initiateTracking(extraId.getId());
        Set<AllocationId> active = new HashSet<>(activeWithCheckpoints.keySet());
            numberOfActiveAllocationsIds,
            tracker.getRetentionLeases().contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(routingTable.primaryShard()))
            }
            } catch (BrokenBarrierException | InterruptedException e) {  
            assertTrue(complete.get());
            activeLocalCheckpoints.entrySet()
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")  
        tracker.updateFromClusterManager(
     * @throws BrokenBarrierException if the barrier was broken while the main test thread was waiting
        }  
            }  
            assertTrue(complete.get());
            if (addPRRL) {
        barrier.await();
        initializing.keySet().forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));  
            allocations.putAll(initializingToBeRemoved);
        tracker.updateFromClusterManager(  
            // Leases for assigned replicas do not expire  
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
            case 3: {  
            final String type;  
package org.opensearch.index.seqno;
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
        );
            15L,
        final long globalCheckpoint = UNASSIGNED_SEQ_NO;
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);  
import static org.hamcrest.Matchers.hasItem;
                throw new RuntimeException(e);
     */
            // noinspection OptionalGetWithoutIsPresent  
            2,
        );
            globalCheckpoint,  
                .filter(a -> a.equals(primaryId) == false)
        assertEquals(tracker.getReplicationGroup().getReplicationTargets().size(), active.size());
                )
        Set<SegmentReplicationShardStats> groupStats = tracker.getSegmentReplicationStats();
            } while (true);  
        final List<Integer> elements = IntStream.rangeClosed(0, globalCheckpoint - 1).boxed().collect(Collectors.toList());
                ids(activeToStay.keySet()),
            currentTimeMillis.addAndGet(millisUntilFirstRenewal - shorterThanRenewalTime);
                    false,
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));  
        assertThat(tracker.getGlobalCheckpoint(), not(equalTo(UNASSIGNED_SEQ_NO)));  
        final long peerRecoveryRetentionLeaseRenewalTimeMillis = retentionLeaseExpiryTimeMillis / 2;
        final AllocationId trackingAllocationId = AllocationId.newInitializing();
            Codec.getDefault().getName(),
        assertEquals(updatedGlobalCheckpoint.get(), globalCheckpoint);
                break;
        assertTrue(oldPrimary.primaryMode);
        }
        assertTrue(interrupted.get());  
        tracker.setLatestReplicationCheckpoint(initialCheckpoint);
            newSyncingAllocationId.getId(),
            } catch (final InterruptedException e) {  
        final int numberOfActiveAllocationsIds = randomIntBetween(2, 16);
            if (randomBoolean()) {  
        );  
                barrier.await();
        assertEquals(1, replicationStats.size());
        }
            "Active ids are in-sync but still unavailable",
        final int numberOfActiveAllocationsIds,  
            // synchronize with the waiting thread to mark that it is complete
        assertEquals(tracker.getGlobalCheckpoint(), primaryLocalCheckpoint);
        assertThat(
        tracker.updateFromClusterManager(1L, ids(Sets.newHashSet(primaryId, replicaId)), routingTable);
            tracker.getReplicationGroup().getInSyncAllocationIds()  
        });
        );  
         * will update its global checkpoint state without the old primary learning of it, and the old primary could have updated its  
        final long minimumInitailizingLocalCheckpoint = (long) initializingLocalCheckpoints.values().stream().min(Integer::compareTo).get();
        }  
import org.opensearch.cluster.routing.TestShardRouting;  
        final Set<AllocationId> initializingAllocationIds = activeAndInitializingAllocationIds.v2();
        assertEquals(tracker.getGlobalCheckpoint(), primaryLocalCheckpoint);
                )
            .collect(Collectors.toMap(Function.identity(), a -> randomIntBetween(1, 1024)));
            onNewRetentionLease,  
            1L,  
            RemoteStoreTestsHelper.createIndexSettings(
        tracker.initiateTracking(replicaId.getId());
            // do another handoff
            0L,
        final ReplicationTracker tracker = newTracker(inSyncAllocationId);
            if (randomBoolean()) {  
        tracker.initiateTracking(extraId.getId());
            }  
import java.util.function.BiConsumer;
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(  
        AllocationId primaryId = active.keySet().iterator().next();  
    /**
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
        final String allocationId,
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(  
        routingTable = routingTableBuilder.build();
        assertTrue(newActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
            assertEquals(tracker.getGlobalCheckpoint(), primaryLocalCheckpoint);
        // Leases that don't correspond to assigned replicas, however, are expired by this time.
import org.opensearch.cluster.metadata.IndexMetadata;
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(1, 5);  
            randomNonNegativeLong(),  
import static org.hamcrest.Matchers.greaterThan;  
            routingTable(newInitializingAllocationIds, primaryId)  
        final ReplicationTracker tracker = newTracker(primaryId, settings);
        long primaryLocalCheckpoint = activeWithCheckpoints.get(primaryId);
        return new FakeClusterState(
        final Set<AllocationId> activeAllocationIds = IntStream.range(0, numberOfActiveAllocationsIds)  
            oldPrimary,
    private static Set<AllocationId> exclude(Collection<AllocationId> allocationIds, Set<String> excludeIds) {
        final int localCheckpoint = randomIntBetween(1, 32);  
                ids(activeToStay.keySet()),
            Collections.singleton(active.getId()),
                )  
        }  
            final ReplicationTracker.CheckpointState checkpointState = checkpoints.get(id);
        assertTrue(activeAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        final long initialClusterStateVersion = randomNonNegativeLong();
            } else {
                newPrimary.activateWithPrimaryContext(primaryContext);  
        // using a different length than we have been using above ensures that we can not collide with a previous allocation ID  
                newPrimary.activateWithPrimaryContext(primaryContext);  
        for (ShardRouting replicaShard : routingTable.replicaShards()) {  
        }
         * will update its global checkpoint state without the old primary learning of it, and the old primary could have updated its  
        final Map<AllocationId, Long> activeToStay = randomAllocationsWithLocalCheckpoints(1, 5);  
        oldPrimary.activatePrimaryMode(randomIntBetween(Math.toIntExact(NO_OPS_PERFORMED), 10));
        final AllocationId initializing = AllocationId.newInitializing();  
    private static Set<AllocationId> randomAllocationIdsExcludingExistingIds(
        return Tuple.tuple(activeAllocationIds, initializingIds);
            1,
            try {
                .allMatch(
        // first check that adding it without the cluster-manager blessing doesn't change anything.
            ),
        tracker.setLatestReplicationCheckpoint(initialCheckpoint);
        Map<AllocationId, Long> allocations = new HashMap<>(activeWithCheckpoints);
            routingTableBuilder.addShard(replicaShard.moveToStarted());
        assertTrue("Total time since timer started should be greater than 100", timer.time() >= 100);  
        final long minimumActiveLocalCheckpoint = (long) activeLocalCheckpoints.values().stream().min(Integer::compareTo).get();
     * This test checks that the global checkpoint update mechanism is honored and relies only on the shards that have
            tracker.getRetentionLeases().leases().stream().map(RetentionLease::id).collect(Collectors.toSet()),  
        final long testStartTimeMillis = randomLongBetween(0L, Long.MAX_VALUE - maximumTestTimeMillis);
        // we can however assert that shared knowledge of the local checkpoint and in-sync status is equal
        final AllocationId active = AllocationId.newInitializing();
            );
            currentTimeMillis.get(),
        );
        oldPrimaryCheckpointsCopy.remove(oldPrimary.shardAllocationId);
        primaryContext = new ReplicationTracker.PrimaryContext(streamInput);  
    }
                tracker.getRetentionLeases() + " renewed before too long",
        assertThat(updatedGlobalCheckpoint.get(), not(equalTo(UNASSIGNED_SEQ_NO)));
        }  
        final long initialClusterStateVersion = randomNonNegativeLong();
        assertThat(tracker.getGlobalCheckpoint(), equalTo(primaryLocalCheckpoint));
        Set<AllocationId> replicationTargets = tracker.getReplicationGroup()
            Map.of("segment_1", segment_1, "segment_2", segment_2),  
            .build();
        }  
 * compatible open source license.
            // cluster state update after primary context handoff  
        tracker.updateFromClusterManager(
        final AllocationId replicaId = initializing.iterator().next();
                k -> expectThrows(IllegalStateException.class, () -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED))  
         * The new in-sync allocation ID is in the in-sync set now yet the cluster-manager does not know this; the allocation ID should still be in
        clusterState.apply(newPrimary);
        );
        );  
        );  
            aId.getId(),  
        tracker.updateGlobalCheckpointForShard(advancingAllocationId.getId(), newGlobalCheckpoint);  
        StreamInput streamInput = output.bytes().streamInput();
        thread.start();  
                .stream()
                barrier.await();  
            routingTable(newInitializingAllocationIds, primaryId)  
                // apply cluster state update on old primary while primary context is being transferred  
                type = "active";
            tracker.getTrackedLocalCheckpointForShard(advancingAllocationId.getId()).globalCheckpoint
import static org.hamcrest.Matchers.equalTo;
            primaryTerm,
        assertThat(tracker.getGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
import java.util.function.LongConsumer;
        randomSubsetOf(initializing.keySet()).forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
            .filter(e -> !e.getKey().equals(missingActiveID))
            "test ran for too long, potentially leading to overflow",  
        final ReplicationTracker tracker = newTracker(primaryId);
        List<AllocationId> initializingRandomSubset = randomSubsetOf(initializing.keySet());  
import org.opensearch.common.Randomness;
            () -> 0L,
        );
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);  
            equalTo(newPrimary.checkpoints.get(newPrimary.shardAllocationId).localCheckpoint)
            }
    }
        // increment checkpoints
            this.inSyncIds = Collections.unmodifiableSet(inSyncIds);
    }
        );  
                clusterState.apply(oldPrimary);  
        tracker.updateFromClusterManager(initialClusterStateVersion + 1, ids(active), routingTable(newInitializing, primaryId));
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")  
            initialClusterStateVersion + 4,
            assertFalse(tracker.getTrackedLocalCheckpointForShard(trackingAllocationId.getId()).inSync);
                randomLocalCheckpointUpdate(oldPrimary);
                randomLocalCheckpointUpdate(oldPrimary);
            barrier.await();  
        }  
    }
            aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED)
            oldPrimary.checkpoints.get(oldPrimary.shardAllocationId).localCheckpoint,  
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE - 1);  
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
        tracker.activatePrimaryMode(10L);
        final Set<AllocationId> inSyncIdsToRemove = new HashSet<>(
    private static Set<String> ids(Set<AllocationId> allocationIds) {  
        initializingRandomSubset.forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        assertEquals(tracker.getGlobalCheckpoint(), 10 + primaryLocalCheckpoint);
        final LongConsumer onUpdate = updatedGlobalCheckpoint -> {};  
        final AllocationId trackingAllocationId = AllocationId.newInitializing();  
import org.opensearch.common.util.set.Sets;
        SegmentReplicationLagTimer timer = new SegmentReplicationLagTimer();
 *     http://www.apache.org/licenses/LICENSE-2.0
        // now insert an unknown active/insync id , the checkpoint shouldn't change but a refresh should be requested.  
                throw new RuntimeException(e);
                barrier.await();  
        final Thread thread = new Thread(() -> {
            numberOfActiveAllocationsIds,
                .allMatch(
            "all leases were renewed",
        newPrimary.updateRetentionLeasesOnReplica(oldPrimary.getRetentionLeases());  
        );  
        assertThat(tracker.getReplicationGroup().getInSyncAllocationIds(), equalTo(ids(activeAllocationIds)));
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
            .map(allocationId -> retentionLeaseFromAllocationId.apply(allocationId).id())
                    initializingId
        );  
        final int numberOfInitializingIds = randomIntBetween(2, 16);
    }  
        final AllocationId advancingAllocationId = initializingAllocationIds.isEmpty() || rarely()
            assertBusy(() -> assertTrue(tracker.pendingInSync.contains(trackingAllocationId.getId())));
        barrier.await();
        );
import org.opensearch.core.common.io.stream.StreamInput;
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        assertThrows(AssertionError.class, () -> tracker.updateVisibleCheckpointForShard(tracker.shardAllocationId, initialCheckpoint));
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        assertTrue(
    }
        assertThat(tracker.getGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
            }  
            5L,  
        tracker.updateLocalCheckpoint(primaryId.getId(), 100L);
            .build();  
    public void testGlobalCheckpointUpdateWithRemoteTranslogEnabled() {
                clusterState.apply(newPrimary);
        final ReplicationCheckpoint initialCheckpoint = new ReplicationCheckpoint(
                    relocatingReplicaId  
        assertThat(leaseIds, hasItem(ReplicationTracker.getPeerRecoveryRetentionLeaseId(primaryShard)));
        final AllocationId primaryId = AllocationId.newInitializing();  
    private static void addPeerRecoveryRetentionLease(final ReplicationTracker tracker, final String allocationId) {  
        removingActiveAllocationIds.remove(primaryId);
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();  
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
        assertTrue(activeAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));  
        allocations.putAll(initializingWithCheckpoints);  
        assertEquals(updatedGlobalCheckpoint.get(), updatedLocalCheckpoint);
            newActiveAllocationIds.stream()  
 * GitHub history for details.
        addPeerRecoveryRetentionLease(tracker, replicaId);
        AllocationId primaryId = activeAllocationIds.iterator().next();  
            : randomFrom(initializingAllocationIds);  
        activeThread.join();
        } else {
                type = "active";
        }  
 *
 * the Apache License, Version 2.0 (the "License"); you may
            exclude(randomSubsetOf(randomInt(clusterState.initializingIds().size()), clusterState.initializingIds()), allocationIds)  
                .allMatch(e -> tracker.getTrackedLocalCheckpointForShard(e.getKey().getId()).getLocalCheckpoint() == e.getValue())  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        BytesStreamOutput output = new BytesStreamOutput();  
        public Set<AllocationId> allIds() {  
                newPrimary.activateWithPrimaryContext(primaryContext);
        assertThat(newPrimary.getGlobalCheckpoint(), equalTo(oldPrimary.getGlobalCheckpoint()));  
        }
            for (final AllocationId replicaId : initializingAllocationIds) {
        assertThat(tracker.getGlobalCheckpoint(), equalTo(NO_OPS_PERFORMED));
            .addShard(searchReplica)
 * license agreements. See the NOTICE file distributed with
            } else if (initializing.contains(aId)) {
        Set<SegmentReplicationShardStats> groupStats = tracker.getSegmentReplicationStats();
        final long initialClusterStateVersion = randomIntBetween(0, Integer.MAX_VALUE - 1);
        Set<AllocationId> active = new HashSet<>(activeWithCheckpoints.keySet());  
        assertThat(
        final Set<AllocationId> startedAllocationIds = Sets.union(initializingIds, Set.of(primaryId));  
        final long primaryLocalCheckpoint = activeLocalCheckpoints.get(primaryId);
        final Map<AllocationId, Long> initializingToBeRemoved = randomAllocationsWithLocalCheckpoints(1, 5);  
        tracker.createMissingPeerRecoveryRetentionLeases(ActionListener.wrap(ignored -> completed.set(true), e -> {
import org.opensearch.index.store.StoreFileMetadata;  
        if (randomBoolean()) {  
            Collections.singleton(active.getId()),  
        final AllocationId aId = clusterState.routingTable.primaryShard().allocationId();
            null,
        final List<AllocationId> removingInitializingAllocationIds = randomSubsetOf(initializingIds);
                routingTable(initializingToStay.keySet(), primaryId)
            tracker.updateFromClusterManager(  
                clusterState.apply(newPrimary);
            }
                // apply cluster state update on new primary so that the states on old and new primary are comparable
        assertTrue(newInitializingAllocationIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));  
                tracker.markAllocationIdAsInSync(trackingAllocationId.getId(), localCheckpoint);  
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
            0L,
        );  
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, primaryId));
        tracker.setLatestReplicationCheckpoint(checkpoint);  
            shardId,
                tracker.getRetentionLeases(true);  
            .build();
        final ShardRouting writeReplica = TestShardRouting.newShardRouting(
                // apply cluster state update on old primary so that the states on old and new primary are comparable  
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
 */  
        logger.info("active: {}, initializing: {}", active, initializing);
     * If we do not update the global checkpoint in {@link ReplicationTracker#markAllocationIdAsInSync(String, long)} after adding the
                throw new IllegalStateException(aId + " not found in any map");
        final AllocationId missingActiveID = randomFrom(active.keySet());  
        Set<String> allocationIds = new HashSet<>(Arrays.asList(oldPrimary.shardAllocationId, newPrimary.shardAllocationId));
            allocations.putAll(activeToBeRemoved);
        assertThat(tracker.getReplicationGroup().getInSyncAllocationIds(), equalTo(ids(activeAllocationIds)));
