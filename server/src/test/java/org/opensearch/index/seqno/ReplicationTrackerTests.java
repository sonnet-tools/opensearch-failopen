        final IndexShardRoutingTable routingTable = new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
    }
            primaryTerm,
        final ReplicationTracker tracker,
            equalTo(ids(Sets.difference(Sets.union(activeAllocationIds, newActiveAllocationIds), removingActiveAllocationIds)))
import java.util.function.LongConsumer;
    public void testMarkAllocationIdAsInSyncWithRemoteTranslogEnabled() throws Exception {
        // first we assert that the in-sync and tracking sets are set up correctly
            null
        assertTrue(interrupted.get());
        return IntStream.range(0, numberOfAllocationIds).mapToObj(i -> {
         * global checkpoint state after the primary context was transferred.
            0L
import java.util.Set;
        ReplicationTracker oldPrimary = new ReplicationTracker(
        // synchronize starting with the waiting thread
        assertTrue(newInitializingAllocationIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        }
            replicaId
            .addShard(
            throw new RuntimeException(e);
        final long millisUntilFirstRenewal = tracker.getRetentionLeases()
        tracker.updateFromClusterManager(1L, Set.of(primaryId.getId()), routingTable(initializingIds, primaryId));
            () -> 0L,
    private Map<AllocationId, Long> randomAllocationsWithLocalCheckpoints(int min, int max) {
            TestShardRouting.newShardRouting(shardId, nodeIdFromAllocationId(primaryId), null, true, ShardRoutingState.STARTED, primaryId)
            "primary's retention lease should exist",
            this.inSyncIds = Collections.unmodifiableSet(inSyncIds);
        });
        });
        final long globalCheckpoint = UNASSIGNED_SEQ_NO;
        assertThat(tracker.getReplicationGroup().getReplicationTargets().size(), equalTo(1 + initializing.size()));
        if (randomBoolean()) {
        if (randomBoolean()) {
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(1, 5);
                .filter(a -> a.equals(primaryId) == false)
        Settings settings = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            );
     * translog stored locally.
        assertTrue("the grouped listener must receive one response per tracked copy", completed.get());
    }
        final Map<AllocationId, Long> initializingToBeRemoved = randomAllocationsWithLocalCheckpoints(1, 5);
            assertFalse(complete.get());
                )
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, active, primaryId));
        Settings settings = Settings.builder()
                newPrimary.activateWithPrimaryContext(primaryContext);
        };
        gcp.updateLocalCheckpoint(allocationId, Math.max(SequenceNumbers.NO_OPS_PERFORMED, currentLocalCheckpoint + randomInt(5)));
import static org.hamcrest.Matchers.greaterThan;
        assertAsTimePasses.accept(() -> {
        }
            if (addPRRL) {
                randomLocalCheckpointUpdate(oldPrimary);
                    initialLeases.stream().noneMatch(l -> l.id().equals(leaseId)) || retentionLeases.contains(leaseId)
            0L,
        final Thread thread = new Thread(() -> {
    }
    }
        final long localCheckpoint
            } else if (initializing.contains(aId)) {
    public void testSegmentReplicationLagTimersStartAfterRecoveryCompletes() {
        });
            assertEquals(2, shardStat.getCheckpointsBehindCount());
    }
        final int numberOfInitializingIds = randomIntBetween(2, 16);
        }
        assertTrue("Total time since timer started should be greater than 100", timer.time() >= 100);
        // Recovering replicas and unavailable allocation IDs do not receive replication lag timers.
                    shardId,
        logger.info("--> using allocations");
        // synchronize starting with the waiting thread
            if (randomBoolean()) {
            Map.of("segment_1", segment1),
        newInitializingAllocationIds.add(AllocationId.newInitializing());
            tracker.shardId(),
                type = "active";
        );
            oldPrimary.checkpoints.get(newPrimary.shardAllocationId).inSync,
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        allocations.keySet().forEach(aId -> {
                addPeerRecoveryRetentionLease(tracker, allocationId);
        // now we are going to add a new allocation ID and bring it in sync which should move it to the in-sync allocation IDs
    public void testSegmentReplicationLagTimersTrackRelocatingReplicaSource() {
        assertAsTimePasses.accept(() -> {
        tracker.startReplicationLagTimers(thirdCheckpoint);
 * compatible open source license.
        assertThat(updatedGlobalCheckpoint.get(), equalTo(UNASSIGNED_SEQ_NO));
        Settings settings = Settings.builder()
        oldPrimary.updateGlobalCheckpointForShard(newPrimary.shardAllocationId, oldPrimary.getGlobalCheckpoint());
        final Set<SegmentReplicationShardStats> replicationStats = tracker.getSegmentReplicationStats();
            numberOfActiveAllocationsIds,
            Math.max(SequenceNumbers.NO_OPS_PERFORMED, oldPrimary.getGlobalCheckpoint() + randomInt(5))
        return newTracker(allocationId, updatedGlobalCheckpoint::set, () -> 0L, settings);
            initialClusterStateVersion + 1,
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(1, 5);
        final AllocationId replicaId = AllocationId.newInitializing();
        assertTrue(newInitializingAllocationIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        tracker.updateRetentionLeasesOnReplica(new RetentionLeases(randomNonNegativeLong(), randomNonNegativeLong(), initialLeases));
     * removing the allocation ID from the pending set in {@link ReplicationTracker#markAllocationIdAsInSync(String, long)} (even if a
            .getAsLong() + peerRecoveryRetentionLeaseRenewalTimeMillis - currentTimeMillis.get();
    /**
            randomNonNegativeLong(),
            true,
        assertEquals(1, replicaStats.getCheckpointsBehindCount());
                break;
        assertEquals(tracker.getGlobalCheckpoint(), primaryLocalCheckpoint);
        newPrimary.updateRetentionLeasesOnReplica(oldPrimary.getRetentionLeases());
        assertEquals(updatedGlobalCheckpoint.get(), 10 + primaryLocalCheckpoint);
        );
                tracker.renewPeerRecoveryRetentionLeases();
            tracker.getReplicationGroup().getInSyncAllocationIds(),
            currentTimeMillis.addAndGet(shorterThanRenewalTime);
            numberOfInitializingIds
            ShardRoutingState.STARTED,
        assertTrue(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);
            }
        tracker.startReplicationLagTimers(secondCheckpoint);
                initialLeases.add(retentionLeaseFromAllocationId.apply(replicaId));
        final SegmentReplicationShardStats replicaStats = replicationStats.iterator().next();
import org.opensearch.cluster.routing.ShardRouting;
            aId.getRelocationId(),
        }
        assertFalse(tracker.pendingInSync.contains(trackingAllocationId.getId()));
            tracker.shardId(),
            5L,
        final int numUpdates = randomInt(10);
        clusterState.apply(oldPrimary);
        // we can however assert that shared knowledge of the local checkpoint and in-sync status is equal
    }
        final String nodeId = nodeIdFromAllocationId(allocationId);
         */
        final AtomicBoolean interrupted = new AtomicBoolean();
        tracker.activatePrimaryMode(globalCheckpoint);
        final int numberOfAllocationIds
            assertEquals(3, checkpointState.checkpointTimers.size());
        assertTrue(replicationTargets.containsAll(active));
        assertThat(tracker.getGlobalCheckpoint(), equalTo(primaryLocalCheckpoint));
        allocations.putAll(activeToStay);
            shardId,
                // apply cluster state update on new primary so that the states on old and new primary are comparable
        assertThat(newPrimaryCheckpointsCopy, equalTo(oldPrimaryCheckpointsCopy));
        Set<AllocationId> active = new HashSet<>(activeWithCheckpoints.keySet());
        final Set<AllocationId> remainingInSyncIds = Sets.difference(clusterState.inSyncIds, inSyncIdsToRemove);
            aId.getId(),
        oldPrimaryCheckpointsCopy.remove(oldPrimary.shardAllocationId);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
            .collect(Collectors.toMap(Function.identity(), a -> randomIntBetween(1, 1024)));
        oldPrimaryCheckpointsCopy.remove(newPrimary.shardAllocationId);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
            initialLeases.add(retentionLeaseFromAllocationId.apply(primaryId));
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(2, 5);
         *
     */
    private long globalCheckpointWithReplicaBehindPrimary(Settings settings, boolean shardOnRemoteEnabledNode) throws InterruptedException {
            }
    public void testWaitForAllocationIdToBeInSync() throws Exception {
        if (randomBoolean()) {
        addPeerRecoveryRetentionLease(tracker, initializing);
    private ReplicationTracker newTracker(final AllocationId allocationId, Settings settings) {
import org.opensearch.core.common.io.stream.StreamInput;
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
            initializingLocalCheckpoints.entrySet()
            }
        assertThat(newPrimaryCheckpointsCopy, equalTo(oldPrimaryCheckpointsCopy));
        thread.start();
            barrier.await();
        }
        final IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
        return Tuple.tuple(activeAllocationIds, initializingIds);
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));
        assertNull(tracker.checkpoints.get(extraId.getId()));
        }
        newInitializingAllocationIds.add(newSyncingAllocationId);
                newPrimary.activateWithPrimaryContext(primaryContext);
                clusterState.apply(newPrimary);
                initialClusterStateVersion + 1,
                tracker.markAllocationIdAsInSync(newSyncingAllocationId.getId(), localCheckpoint);
            newInitializingAllocationIds.stream()
            // Leases for assigned replicas do not expire
        final Set<AllocationId> removingActiveAllocationIds = new HashSet<>(randomSubsetOf(activeAllocationIds));
        final int numberOfActiveAllocationsIds = randomIntBetween(2, 2);
            indexSettings,
            if (randomBoolean()) {
            1,
                throw new RuntimeException(e);
        // the tracking allocation IDs should play no role in determining the global checkpoint
            if (randomBoolean()) {
    }
            newSyncingAllocationId.getId(),
        initializingLocalCheckpoints.forEach((a, l) -> updateLocalCheckpoint(tracker, a.getId(), l));
        Set<AllocationId> initializing = new HashSet<>(initializingWithCheckpoints.keySet());
}
import static org.hamcrest.Matchers.not;
        addPeerRecoveryRetentionLease(tracker, trackingAllocationId);
            }
        assigned.putAll(initializing);
            if (active.contains(aId)) {
            UNASSIGNED_SEQ_NO,
                clusterState.apply(newPrimary);
            assertNull(tracker.getTrackedLocalCheckpointForShard(trackingAllocationId.getId()));
            .orElse(UNASSIGNED_SEQ_NO);
        tracker.startReplicationLagTimers(startedCheckpoint);
        final AllocationId newSyncingAllocationId = AllocationId.newInitializing();
                throw new RuntimeException(e);
            true,
            allocations.putAll(initializingToBeRemoved);
                break;
            Map.of("segment_1", segment_1, "segment_2", segment_2),
            .leases()
    }
        final Map<AllocationId, Integer> activeLocalCheckpoints = newActiveAllocationIds.stream()
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));
                ShardRoutingState.STARTED,
            primaryTerm,
        assigned.putAll(active);
    public void testInSyncIdsAreRemovedIfNotValidatedByClusterManager() {
        final ReplicationCheckpoint startedCheckpoint = new ReplicationCheckpoint(
                .allMatch(
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
            null,
        );
                primaryId
        tracker.updateVisibleCheckpointForShard("randomAllocationID", initialCheckpoint);
        final Map<AllocationId, Long> initializingToStay = randomAllocationsWithLocalCheckpoints(1, 5);
        final AllocationId extraId = AllocationId.newInitializing();
            }
        assertTrue(
            } catch (BrokenBarrierException | InterruptedException e) {
            } while (true);
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);
        final ReplicationCheckpoint initialCheckpoint = new ReplicationCheckpoint(
         * the in-sync set even if we receive a cluster state update that does not reflect this.
import org.opensearch.core.action.ActionListener;
        final AllocationId active = AllocationId.newInitializing();
         */
        final long minimumInitailizingLocalCheckpoint = (long) initializingLocalCheckpoints.values().stream().min(Integer::compareTo).get();
        return new FakeClusterState(
        final Map<AllocationId, Long> activeToBeRemoved = randomAllocationsWithLocalCheckpoints(1, 5);
                tracker.markAllocationIdAsInSync(newSyncingAllocationId.getId(), localCheckpoint);
            oldPrimary.abortRelocationHandoff();
            do {
                throw new RuntimeException(e);
        final AllocationId primaryId = AllocationId.newInitializing();
        );
    private void updateLocalCheckpoint(final ReplicationTracker tracker, final String allocationId, final long localCheckpoint) {
            assertEquals(0, checkpointState.checkpointTimers.size());
        barrier.await();
        long primaryLocalCheckpoint = active.get(primaryId);
            .build();
            }
        assigned.putAll(initializing);
            initializingToStay.keySet().forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
            );
        assertThat(updatedGlobalCheckpoint.get(), not(equalTo(UNASSIGNED_SEQ_NO)));
        IndexShardRoutingTable routingTable = routingTable(initializingAllocationIds, primaryId);
        // createMissingPeerRecoveryRetentionLeases() exists to repair.
import static java.util.Collections.emptySet;
public class ReplicationTrackerTests extends ReplicationTrackerTestCase {
        final AllocationId replicaId = AllocationId.newInitializing();
        final Map<AllocationId, Long> assigned = new HashMap<>();
        ReplicationTracker newPrimary = new ReplicationTracker(
        logger.info("--> activeAllocationIds {} Primary {}", activeAllocationIds, primaryId.getId());
        }
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(2, 5);
        assigned.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
            if (randomBoolean()) {
        final ReplicationCheckpoint secondCheckpoint = new ReplicationCheckpoint(
         * Now we will add an allocation ID to each of active and initializing and ensure they propagate through. Using different lengths
        final CyclicBarrier barrier = new CyclicBarrier(2);
        assertTrue(
        final ReplicationCheckpoint recoveryCheckpoint = new ReplicationCheckpoint(
            equalTo(newPrimary.checkpoints.get(newPrimary.shardAllocationId).inSync)
        assertThat(newPrimary.getGlobalCheckpoint(), equalTo(oldPrimary.getGlobalCheckpoint()));
            ids(newActiveAllocationIds),
                .stream()
                .filter(a -> a.equals(primaryId) == false)
            2,
        }
        assertThat(tracker.getGlobalCheckpoint(), not(equalTo(UNASSIGNED_SEQ_NO)));
        newInitializing.add(extraId);
            .build();
    }
    }
            // cluster state update after primary context handoff
        final long localCheckpoint = randomLongBetween(0, Long.MAX_VALUE - 1);
        /*
        tracker.activatePrimaryMode(10L);
                randomMarkInSync(oldPrimary, newPrimary);
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4), false);
            ),
            .map(ShardRouting::allocationId)
        );
                barrier.await();
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
import org.opensearch.action.support.replication.ReplicationResponse;
        assertThat(tracker.getReplicationGroup().getInSyncAllocationIds(), equalTo(ids(activeAllocationIds)));
        final Set<AllocationId> existingAllocationIds,
        final StoreFileMetadata segment_1 = new StoreFileMetadata("segment_1", 5L, "abcd", Version.LATEST);
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
     */
 */
        );
                true,
            () -> 0L,
     * @throws InterruptedException   if the main test thread was interrupted while waiting
            "All active & initializing ids are now marked in-sync",
                .filter(a -> a.equals(primaryId) == false)
        public void apply(ReplicationTracker gcp) {
        assertThat(newPrimary.replicationGroup, equalTo(oldPrimary.replicationGroup));
            try {
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);
    private static FakeClusterState randomUpdateClusterState(Set<String> allocationIds, FakeClusterState clusterState) {
        allocations.putAll(initializingWithCheckpoints);
        final Map<AllocationId, Long> initializingToBeRemoved = randomAllocationsWithLocalCheckpoints(1, 5);
        );
        thread.start();
            case 2: {
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        assertTrue(initializingIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
            numberOfInitializingIds
        );
        assertThat(
        assertTrue(newInitializingAllocationIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        Settings settings = Settings.builder()
        ReplicationTracker.PrimaryContext primaryContext = oldPrimary.startRelocationHandoff(newPrimary.shardAllocationId);
        Settings settings = Settings.builder()
        }
        // the primary races ahead of the replica
            assertFalse(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);
        final long globalCheckpoint = UNASSIGNED_SEQ_NO;
        assertEquals(1, replicationStats.size());
            routingTable(newInitializingAllocationIds, primaryId)
            initialClusterStateVersion + 3,
        final long nonUpdate = randomLongBetween(NO_OPS_PERFORMED, globalCheckpoint);
                // apply cluster state update on both copies while primary context is being transferred
        activeAllocationIds.add(relocatingId);
        final AllocationId primaryId = active.keySet().iterator().next();
            primaryTerm,
        Set<AllocationId> initializing = new HashSet<>(initializingWithCheckpoints.keySet());
            0L
         * than we have been using above ensures that we can not collide with a previous allocation ID
package org.opensearch.index.seqno;
        final Thread thread = new Thread(() -> {
            // normal path, shard catches up
        initializing.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
        } else {
        );
        initializingThread.join();
            NO_OPS_PERFORMED,
            Sets.union(ids(activeAllocationIds), ids(initializingIds)),
        final long minLocalCheckpointAfterUpdates = allocations.values().stream().min(Long::compareTo).orElse(UNASSIGNED_SEQ_NO);
            assertEquals(150L, shardStat.getBytesBehindCount());
            .stream()
        newInitializing.add(extraId);
        });
import org.opensearch.common.settings.Settings;
            final long shorterThanRenewalTime = randomLongBetween(0L, millisUntilFirstRenewal - 1);
            "test ran for too long, potentially leading to overflow",
            activeToStay.put(primaryId, activeToBeRemoved.remove(primaryId));
        assertTrue(newPrimary.primaryMode);
        final AllocationId primaryId = activeAllocationIds.iterator().next();
                // synchronize with the test thread checking if we are interrupted
        );
        final ReplicationTracker tracker,
        tracker.updateFromClusterManager(2L, Set.of(primaryId.getId(), replicaId.getId()), relocatingRoutingTable);
            .collect(Collectors.toMap(Function.identity(), a -> randomIntBetween(1, 1024)));
    private static FakeClusterState initialState() {
        updatedGlobalCheckpoint.set(UNASSIGNED_SEQ_NO);
        updatedGlobalCheckpoint.set(UNASSIGNED_SEQ_NO);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        routingTable = routingTable(newInitializingAllocationIds, primaryId);
        } else {
            } catch (final BrokenBarrierException | InterruptedException e) {
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
                type = "init";
        updatedGlobalCheckpoint.set(UNASSIGNED_SEQ_NO);
            .filter(e -> !e.getKey().equals(missingActiveID))
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
            // cluster state update after primary context handoff
        Randomness.shuffle(elements);
            barrier.await();
    private static void randomLocalCheckpointUpdate(ReplicationTracker gcp) {
            ShardRoutingState.RELOCATING,
        tracker.updateFromClusterManager(initialClusterStateVersion + 1, ids(active), routingTable(newInitializing, primaryId));
                clusterState.apply(oldPrimary);
    public void testUpdateAllocationIdsFromClusterManagerWithRemoteTranslogEnabled() throws Exception {
        assertThat(updatedGlobalCheckpoint.get(), equalTo(globalCheckpoint));
        newPrimaryCheckpointsCopy.remove(oldPrimary.shardAllocationId);
         * We can not assert on shared knowledge of the global checkpoint between the old primary and the new primary as the new primary
            initialClusterStateVersion + 3,
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
        Map<AllocationId, Long> allocations = new HashMap<>();
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            tracker.updateFromClusterManager(
        tracker.updateLocalCheckpoint(primaryId.getId(), updatedLocalCheckpoint);
        assertNull("precondition: the search replica is not tracked", tracker.checkpoints.get(searchReplica.allocationId().getId()));
                // apply cluster state update on old primary while primary context is being transferred
            case 0: {
        final Set<AllocationId> newInitializingAllocationIds = initializingIds.stream()
        final AtomicBoolean complete = new AtomicBoolean();
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);
        Set<AllocationId> active = new HashSet<>(activeWithCheckpoints.keySet());
        });
                clusterState.apply(oldPrimary);
        final long checkpoint = Stream.concat(activeToStay.values().stream(), initializingToStay.values().stream()).min(Long::compare).get()
        oldPrimary.updateGlobalCheckpointForShard(newPrimary.shardAllocationId, oldPrimary.getGlobalCheckpoint());
        tracker.updateLocalCheckpoint(allocationId, localCheckpoint);
    }
     */
        final int activeLocalCheckpoint = randomIntBetween(0, Integer.MAX_VALUE - 1);
    private ReplicationTracker newTracker(final AllocationId allocationId, Settings settings, boolean remote) {
        initializing.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED, false));
            REMOTE_DISCOVERY_NODE
            assertEquals(0L, shardStat.getBytesBehindCount());
        SegmentReplicationLagTimer timer = new SegmentReplicationLagTimer();
        assertThat(tracker.getReplicationGroup().getInSyncAllocationIds(), equalTo(ids(activeAllocationIds)));
            shardId,
            equalTo(newPrimary.checkpoints.get(oldPrimary.shardAllocationId).inSync)
                throw new RuntimeException(e);
    private static class FakeClusterState {
    }
                clusterState.apply(newPrimary);
    public void testIllegalStateExceptionIfUnknownAllocationId() {
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            boolean primaryRelocationTarget = initializingId.equals(targetAllocationId);
import java.util.Map;
        );
    }
            .build();
        final long initialClusterStateVersion = randomIntBetween(1, Integer.MAX_VALUE);
        final LongConsumer onUpdate = updatedGlobalCheckpoint -> {};
        tracker.updateLocalCheckpoint(replicaId.getId(), localCheckpoint);
                greaterThanOrEqualTo(currentTimeMillis.get() - peerRecoveryRetentionLeaseRenewalTimeMillis)
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        Settings settings = Settings.builder()
    }
        assertEquals(10L, replicaStats.getBytesBehindCount());
import java.util.HashSet;
        ReplicationTracker.PrimaryContext primaryContext = oldPrimary.startRelocationHandoff(newPrimary.shardAllocationId);
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(2, 5);
        final ReplicationTracker tracker = newTracker(active);
        AllocationId primaryId = activeAllocationIds.iterator().next();
        assertThat(updatedGlobalCheckpoint.get(), equalTo(NO_OPS_PERFORMED));
        final long localCheckpoint = randomLongBetween(0, Long.MAX_VALUE - 1);
        assertTrue(oldPrimary.relocated);
        assertThat(updatedGlobalCheckpoint.get(), equalTo(UNASSIGNED_SEQ_NO));
        });
        }
            oldPrimary.abortRelocationHandoff();
            ids(Collections.singleton(primaryId)),
        final long update = randomLongBetween(globalCheckpoint, Long.MAX_VALUE);
        Set<AllocationId> initializing = new HashSet<>(initializingWithCheckpoints.keySet());
            NON_REMOTE_DISCOVERY_NODE
import java.util.concurrent.atomic.AtomicBoolean;
        tracker.renewPeerRecoveryRetentionLeases();
            );
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), randomInt((int) minLocalCheckpointAfterUpdates), false);
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
        );
        assertTrue(
        }));
        Set<AllocationId> active = new HashSet<>(activeWithCheckpoints.keySet());
import java.util.HashMap;
        long primaryLocalCheckpoint = active.get(primaryId);
                clusterState.apply(newPrimary);
        assertThat(tracker.getReplicationGroup().getInSyncAllocationIds(), equalTo(ids(activeAllocationIds)));
        initializingRandomSubset.forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
        routingTable = routingTable(newInitializingAllocationIds, primaryId);
     */
        final long minLocalCheckpoint = allocations.values().stream().min(Long::compare).orElse(UNASSIGNED_SEQ_NO);
    ) {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
            for (final AllocationId replicaId : initializingAllocationIds) {
        );
        // simulate transferring the global checkpoint to the new primary after finalizing recovery before the handoff
    }
        assertEquals(Set.of(startedCheckpoint), checkpointState.checkpointTimers.keySet());
        // increment checkpoints
        Map<String, ReplicationTracker.CheckpointState> newPrimaryCheckpointsCopy = new HashMap<>(newPrimary.checkpoints);
     * update. This test fails without an additional call to {@code ReplicationTracker#updateGlobalCheckpointOnPrimary()} after
        // the tracking allocation IDs should play no role in determining the global checkpoint
        tracker.updateFromClusterManager(initialClusterStateVersion + 1, ids(newActiveAllocationIds), routingTable);
            } catch (final BrokenBarrierException | InterruptedException e) {
    public void testInSyncIdsAreIgnoredIfNotValidatedByClusterManager() {
        addPeerRecoveryRetentionLease(tracker, trackingAllocationId);
    }
            oldPrimary,
            );
    }
                    nodeIdFromAllocationId(relocatingReplicaId),
            // abort handoff, check that we can continue updates and retry handoff
            ids(newActiveAllocationIds),
        Settings settings = Settings.builder()
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        final long minimumActiveLocalCheckpoint = (long) activeLocalCheckpoints.values().stream().min(Integer::compareTo).get();
        assertThat(
            aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED)
import java.util.Collection;
        allocations.putAll(activeWithCheckpoints);
        switch (randomInt(3)) {
                }
        final AllocationId replicaId = initializing.iterator().next();
            numberOfActiveAllocationsIds,
        Map<AllocationId, Long> initializingWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 1);
    public void testGlobalCheckpointBoundedByReplicaWithoutClusterStateRepo() throws InterruptedException {
        final int numberOfInitializingIds = randomIntBetween(2, 2);
        );
        );
            equalTo(newPrimary.checkpoints.get(oldPrimary.shardAllocationId).localCheckpoint)
            Collections.singleton(active.getId()),
        assigned.putAll(active);
            routingTable(newInitializingAllocationIds, primaryId)
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
        assertEquals(tracker.getReplicationGroup().getReplicationTargets().size(), active.size() + initializing.size());
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        final Set<AllocationId> initializingIds = Set.of(recoveringReplicaId);
        final int numberOfActiveAllocationsIds = randomIntBetween(1, 8);
            numberOfInitializingIds
     * grouped listener for one more response than can ever arrive, leaving the leases permanently uncreated.
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            0L,
        logger.info("--> using allocations");
        } catch (final InterruptedException e) {
        );
        Map<AllocationId, Long> initializingWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 1);
                tracker.initiateTracking(trackingAllocationId.getId());
        initializing.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED));
        final long primaryTerm = randomNonNegativeLong();
        assertFalse(tracker.pendingInSync());
        for (int i = 0; i < elements.size(); i++) {
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
                break;
     */
        List<AllocationId> initializingRandomSubset = randomSubsetOf(initializing.keySet());
        /*
        final Set<String> expectedIds = ids(initializingIds);
            equalTo(newPrimary.checkpoints.get(newPrimary.shardAllocationId).localCheckpoint)
        Thread.sleep(100);
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        // send primary context through the wire
    /**
        }
            tracker.shardId(),
        if (randomBoolean()) {
        final AllocationId newSyncingAllocationId = AllocationId.newInitializing();
        assertThat(tracker.getGlobalCheckpoint(), equalTo(minLocalCheckpoint));
            globalCheckpoint,
        return newTracker(allocationId, updatedGlobalCheckpoint::set, () -> 0L, settings, remote);
        // A remote-enabled primary with a docrep write replica still left in the group, which is the situation
        });
        });
            }
        assertTrue("Total elapsed time should be greater than time since timer start", timer.totalElapsedTime() - timer.time() >= 100);
            }
        assertNull(tracker.checkpoints.get(extraId.getId()));
    private AtomicLong updatedGlobalCheckpoint = new AtomicLong(UNASSIGNED_SEQ_NO);
            .build();
        return newTracker(allocationId, updatedGlobalCheckpoint::set, () -> 0L);
            final String type;
                routingTable(initializingToStay.keySet(), primaryId)
        );
    public void testSegmentReplicationCheckpointTrackingInvalidAllocationIDs() {
        }
                clusterStateVersion + 1,
            }
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        final int nextActiveLocalCheckpoint = randomIntBetween(activeLocalCheckpoint + 1, Integer.MAX_VALUE);
            updateLocalCheckpoint(tracker, trackingAllocationId.getId(), elements.get(i));
            initialClusterStateVersion + 4,
                throw new IllegalStateException(aId + " not found in any map");
        assertTrue(
                randomLocalCheckpointUpdate(oldPrimary);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertThat(updatedGlobalCheckpoint.get(), equalTo(minimumActiveLocalCheckpoint));
        );
        if (activeToBeRemoved.containsKey(primaryId)) {
            logger.info("  - [{}], local checkpoint [{}], [{}]", aId, allocations.get(aId), type);
            if (active.contains(aId)) {
        }
        // now we will remove some allocation IDs from these and ensure that they propagate through
            5L,
import java.util.Arrays;
            onNewRetentionLease,
        final StoreFileMetadata segment_1 = new StoreFileMetadata("segment_1", 1L, "abcd", Version.LATEST);
        tracker.updateFromClusterManager(
        allocations.putAll(initializingWithCheckpoints);
            onNewRetentionLease,
            } else {
            assertBusy(() -> assertTrue(tracker.pendingInSync.contains(trackingAllocationId.getId())));
        );
        assertThat(tracker.getReplicationGroup().getReplicationTargets().size(), equalTo(1 + initializing.size()));
    }
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
 * not use this file except in compliance with the License.
        }
            }
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(
            true,
        );
import org.opensearch.test.IndexSettingsModule;
        // update again
                initialClusterStateVersion + 2,
        });
 * license agreements. See the NOTICE file distributed with
        tracker.updateGlobalCheckpointOnReplica(update, "test");
            allocations.putAll(initializingToBeRemoved);
    }
        long primaryLocalCheckpoint = activeWithCheckpoints.get(primaryId);
        assertThat(allocations.size(), equalTo(active.size() + initializing.size()));
        final Set<AllocationId> initializingAllocationIds = activeAndInitializingAllocationIds.v2();
        );
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.routing.ShardRoutingState;
        }).collect(Collectors.toSet());
            oldPrimary.checkpoints.get(newPrimary.shardAllocationId).localCheckpoint,
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            equalTo(newPrimary.checkpoints.get(newPrimary.shardAllocationId).localCheckpoint)
            nodeIdFromAllocationId(AllocationId.newInitializing(relocatingId.getRelocationId())),
                )
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
            oldPrimary.checkpoints.get(newPrimary.shardAllocationId).inSync,
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4), false);
        assertEquals(1 + initializingRandomSubset.size(), tracker.getReplicationGroup().getReplicationTargets().size());
            return routingTable.getAllInitializingShards().stream().map(ShardRouting::allocationId).collect(Collectors.toSet());
        markAsTrackingAndInSyncQuietly(
                Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build()
        final ReplicationTracker tracker = newTracker(active);
    private static void markAsTrackingAndInSyncQuietly(
            try {
        currentTimeMillis.set(testStartTimeMillis);
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));
        }
                    ShardRoutingState.RELOCATING,
            );
            REMOTE_DISCOVERY_NODE
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        final long initialClusterStateVersion = randomNonNegativeLong();
        final long peerRecoveryRetentionLeaseRenewalTimeMillis = retentionLeaseExpiryTimeMillis / 2;
        // it is however nice not to assume this on this level and check we do the right thing.
        tracker.initiateTracking(replicaId.getId());
        final boolean addPRRL
        /*
            assertEquals(0, shardStat.getCheckpointsBehindCount());
            primaryContext = oldPrimary.startRelocationHandoff(newPrimary.shardAllocationId);
            initialClusterStateVersion + 4,
        return tracker.getGlobalCheckpoint();
                type = "init";
            }
            }
        final ShardId shardId = new ShardId("test", "_na_", 0);
        thread.start();
import java.util.function.BiConsumer;
     * @throws BrokenBarrierException if the barrier was broken while the main test thread was waiting
            assertTrue(tracker.checkpoints.get(initializingId.getId()).checkpointTimers.isEmpty());
        assertEquals(
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
        newInitializing.add(extraId);
        final Set<AllocationId> activeAllocationIds = IntStream.range(0, numberOfActiveAllocationsIds)
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", settings);
        // send primary context through the wire
        assertFalse(tracker.indexSettings().isRemoteTranslogStoreEnabled());
        IndexShardRoutingTable routingTable = routingTable(initializingIds, primaryId);
            )
            Collections.singleton(inSyncAllocationId.getId()),
import org.opensearch.index.SegmentReplicationShardStats;
    }
        // first check that adding it without the cluster-manager blessing doesn't change anything.
        AllocationId targetAllocationId = initializingIds.iterator().next();
        if (randomBoolean()) {
            final ReplicationTracker.CheckpointState checkpointState = checkpoints.get(id);
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
        for (int i = 0; i < numUpdates; i++) {
            Math.toIntExact(Math.min(primaryLocalCheckpoint, minimumInitailizingLocalCheckpoint) - 1)
        Settings settings = Settings.builder()
            tracker.shardId(),
        // now insert an unknown active/insync id , the checkpoint shouldn't change but a refresh should be requested.
                clusterState.apply(newPrimary);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
            3,
        Set<String> allocationIds = new HashSet<>(Arrays.asList(oldPrimary.shardAllocationId, newPrimary.shardAllocationId));
        assertTrue(
        tracker.createMissingPeerRecoveryRetentionLeases(ActionListener.wrap(ignored -> completed.set(true), e -> {
        final Thread activeThread = new Thread(() -> {
            Codec.getDefault().getName(),
        assertThat(leaseIds, not(hasItem(ReplicationTracker.getPeerRecoveryRetentionLeaseId(searchReplica))));
    public void testPrimaryContextHandoff() throws IOException {
        final AllocationId primaryId = AllocationId.newInitializing();
import org.opensearch.indices.replication.common.SegmentReplicationLagTimer;
                tracker.getRetentionLeases(true);
import java.util.Collections;
    }
            assertEquals(2, checkpointState.checkpointTimers.size());
            currentTimeMillis.get(),
            currentTimeMillis.addAndGet(millisUntilFirstRenewal - shorterThanRenewalTime);
        initializing.keySet().forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
                .filter(a -> a.equals(primaryId) == false)
        );
                    initializingId
        Map<AllocationId, Long> activeWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 1);
        assertEquals(updatedGlobalCheckpoint.get(), updatedLocalCheckpoint);
        );
        final long initialClusterStateVersion = randomNonNegativeLong();
        if (randomBoolean()) {
                    ShardRoutingState.INITIALIZING,
                clusterState.apply(newPrimary);
import java.util.List;
        );
            .addShard(searchReplica)
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
                // synchronize with the test thread checking if we are no longer waiting
        tracker.renewPeerRecoveryRetentionLeases();
                tracker.markAllocationIdAsInSync(trackingAllocationId.getId(), localCheckpoint);
            ReplicationTracker.getPeerRecoveryRetentionLeaseId(nodeIdFromAllocationId(allocationId)),
        final ShardId shardId = new ShardId("test", "_na_", 0);
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
            oldPrimary.checkpoints.get(oldPrimary.shardAllocationId).inSync,
        thread.join();
            () -> 0L,
            }
        final AtomicBoolean completed = new AtomicBoolean();
        final AllocationId relocatingId = AllocationId.newRelocation(primaryId);
        // Leases that don't correspond to assigned replicas, however, are expired by this time.
        Set<SegmentReplicationShardStats> groupStats = tracker.getSegmentReplicationStats();
                clusterState.apply(oldPrimary);
        tracker.updateFromClusterManager(1L, ids(Sets.newHashSet(primaryId, replicaId)), routingTable);
        final Set<AllocationId> inSyncIdsToRemove = new HashSet<>(
        final AllocationId primaryId = AllocationId.newInitializing();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));
        assertTrue(
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        final long nonUpdate = randomLongBetween(NO_OPS_PERFORMED, globalCheckpoint);
                // apply cluster state update on old primary so that the states on old and new primary are comparable
                interrupted.set(true);
            routingTable(initializingAllocationIds, Collections.singleton(primaryShard.allocationId()), primaryShard)
        assertThat(tracker.getGlobalCheckpoint(), equalTo((long) nextActiveLocalCheckpoint));
                equalTo(expectedLeaseIds)
        assertThat(tracker.getGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
import org.opensearch.common.io.stream.BytesStreamOutput;
            .stream()
        if (randomBoolean()) {
            try {
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
                // synchronize starting with the test thread
            while (currentTimeMillis.get() < startTime + retentionLeaseExpiryTimeMillis * 2) {
            .collect(Collectors.toMap(Function.identity(), a -> randomIntBetween(1, 1024)));
        newInitializingAllocationIds.add(AllocationId.newInitializing());
            .build();
            allocations.forEach((aid, ckp) -> updateLocalCheckpoint(tracker, aid.getId(), ckp + 10L));
            updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));
        }
            0L,
        final long checkpoint = activeToStay.get(primaryId) + 10;
            assertEquals(2, checkpointState.checkpointTimers.size());
        final long newLocalCheckpoint = Math.max(NO_OPS_PERFORMED, oldPrimary.getGlobalCheckpoint() + randomInt(5));
        initializingLocalCheckpoints.forEach((a, l) -> updateLocalCheckpoint(tracker, a.getId(), l));
        primaryContext = new ReplicationTracker.PrimaryContext(streamInput);
        Map<AllocationId, Long> activeWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 5);
        final AllocationId missingActiveID = randomFrom(active.keySet());
            2,
        final Map<AllocationId, Long> assigned = new HashMap<>();
                    nodeIdFromAllocationId(AllocationId.newInitializing(relocatingReplicaId.getRelocationId())),
        tracker.initiateTracking(extraId.getId());
        final ShardId shardId = new ShardId("test", "_na_", 0);
            try {
                randomMarkInSync(oldPrimary, newPrimary);
     * A full remote store deployment does have a remote translog, so the replica is not part of the replication group
            .forEach(e -> updateLocalCheckpoint(tracker, e.getKey().getId(), e.getValue()));
        expectThrows(IllegalStateException.class, () -> tracker.markAllocationIdAsInSync(randomAlphaOfLength(10), randomNonNegativeLong()));
    }
        addPeerRecoveryRetentionLease(tracker, extraId);
            .stream()
        assertThat(
            numberOfActiveAllocationsIds,
        List<Map<AllocationId, Long>> allocations = Arrays.asList(active, initializing, nonApproved);
        initializingIds.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED));
                throw new IllegalStateException(aId + " not found in any map");
import static org.hamcrest.Matchers.equalTo;
        initializing.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
            tracker.markAllocationIdAsInSync(allocationId, localCheckpoint);
        barrier.await();
            .build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
        if (randomBoolean()) {
        // we can however assert that shared knowledge of the local checkpoint and in-sync status is equal
            primaryNode,
        assertEquals(
                .filter(ShardRouting::relocating)
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
            tracker.renewPeerRecoveryRetentionLeases();
        Map<AllocationId, Long> allocations = new HashMap<>(activeWithCheckpoints);
        oldPrimary.activatePrimaryMode(randomIntBetween(Math.toIntExact(NO_OPS_PERFORMED), 10));
     * Segments-only remote store: index.remote_store.enabled is set because segments are uploaded, but there is no
            shardId,
        final Set<AllocationId> initializingIds = activeAndInitializingAllocationIds.v2();
    }
        }
    ) {
        assertTrue(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);
        final long initialGlobalCheckpoint = Math.max(
        final AllocationId extraId = AllocationId.newInitializing();
                )
 * SPDX-License-Identifier: Apache-2.0
        final Set<AllocationId> initializingIds = activeAndInitializingAllocationIds.v2();
        allocations.putAll(activeToStay);
     * If we do not update the global checkpoint in {@link ReplicationTracker#markAllocationIdAsInSync(String, long)} after adding the
            tracker.updateVisibleCheckpointForShard(id, thirdCheckpoint);
        Map<String, ReplicationTracker.CheckpointState> newPrimaryCheckpointsCopy = new HashMap<>(newPrimary.checkpoints);
        assertEquals(relocatingReplicaId.getId(), replicationStats.iterator().next().getAllocationId());
import static org.hamcrest.Matchers.hasItem;
        assertFalse(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));
            routingTable(Collections.singleton(replicaId), primaryId)
        tracker.updateFromClusterManager(
            try {
            assertTrue(checkpoints.get(initializingId.getId()).checkpointTimers.isEmpty());
            tracker.updateVisibleCheckpointForShard(id, initialCheckpoint);
            case 2: {
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
        final int numberOfInitializingIds = randomIntBetween(0, 8);
    public void testRemoteStoreReplicationLagTimersStartAfterRecoveryCompletes() {
 *
        assertThat(leaseIds, hasItem(ReplicationTracker.getPeerRecoveryRetentionLeaseId(writeReplica)));
        }
        /*
            clusterStateVersion,
        }
                throw new IllegalStateException(aId + " not found in any map");
            allocations.put(AllocationId.newInitializing(), (long) randomInt(1000));
            assertTrue(complete.get());
            if (rarely()) {
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            equalTo(newPrimary.checkpoints.get(newPrimary.shardAllocationId).inSync)
            routingTable(Collections.singleton(initializing), active)
        final Map<AllocationId, Integer> activeLocalCheckpoints = newActiveAllocationIds.stream()
        if (activeToBeRemoved.containsKey(primaryId)) {
        final ShardRouting writeReplica = TestShardRouting.newShardRouting(
        initializing.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));
        assertThat(tracker.getGlobalCheckpoint(), not(equalTo(UNASSIGNED_SEQ_NO)));
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
        final long localCheckpoint = randomIntBetween(
        );
        routingTable = routingTableBuilder.build();
            .getReplicationTargets()
        final Set<AllocationId> active = Sets.union(activeToStay.keySet(), activeToBeRemoved.keySet());
        final AllocationId active = AllocationId.newInitializing();
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
     * and the global checkpoint advances with the primary alone.
        final IndexShardRoutingTable routingTable;
        thread.start();
            () -> 0L,
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
        oldPrimary.completeRelocationHandoff();
    private static void randomMarkInSync(ReplicationTracker oldPrimary, ReplicationTracker newPrimary) {
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
        final Set<SegmentReplicationShardStats> replicationStats = tracker.getSegmentReplicationStats();
                    shardId,
        markAsTrackingAndInSyncQuietly(oldPrimary, allocationId, newLocalCheckpoint);
            }
            oldPrimary,
                // ensure we do not duplicate an allocation ID
            initialClusterStateVersion + 2,
        // there is a shard copy pending in sync, the global checkpoint can not advance
        active.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));
        assertThat(tracker.getReplicationGroup().getReplicationTargets().size(), equalTo(1));
            equalTo(newPrimary.checkpoints.get(oldPrimary.shardAllocationId).localCheckpoint)
            0L
        assertFalse(oldPrimary.primaryMode);
                .stream()
                break;
            logger.info("  - [{}], local checkpoint [{}], [{}]", aId, allocations.get(aId), type);
    private static Set<AllocationId> exclude(Collection<AllocationId> allocationIds, Set<String> excludeIds) {
            routingTable(Collections.singleton(initializing), active)
        final List<AllocationId> removingInitializingAllocationIds = randomSubsetOf(initializingIds);
                TestShardRouting.newShardRouting(
            updateLocalCheckpoint(tracker, trackingAllocationId.getId(), randomIntBetween(globalCheckpoint, 64));
            );
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
    }
            .build();
        Settings settings = Settings.builder()
        tracker.updateGlobalCheckpointOnReplica(nonUpdate, "test");
        final Thread thread = new Thread(() -> {
        final Map<AllocationId, Long> nonApproved = randomAllocationsWithLocalCheckpoints(1, 5);
            }
        final long initialVersion = tracker.getRetentionLeases().version();
            } else if (initializing.contains(aId)) {
                complete.set(true);
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        );
            .stream()
        tracker.updateFromClusterManager(initialClusterStateVersion + 1, ids(newActiveAllocationIds), routingTable);
    /**
        assertTrue(replicationTargets.containsAll(initializing));
            .build();
/*
            shardId,
                tracker.initiateTracking(newSyncingAllocationId.getId());
        }
    public void testUpdateGlobalCheckpointOnReplicaWithRemoteTranslogEnabled() {
        }
        Set<SegmentReplicationShardStats> groupStats = tracker.getSegmentReplicationStats();
        final Set<AllocationId> active = Sets.union(activeToStay.keySet(), activeToBeRemoved.keySet());
        );
            }
        final List<Integer> elements = IntStream.rangeClosed(0, globalCheckpoint - 1).boxed().collect(Collectors.toList());
            .map(ShardRouting::allocationId)
        barrier.await();
            ShardRoutingState.STARTED,
        newPrimary.updateRetentionLeasesOnReplica(oldPrimary.getRetentionLeases());
        final long maximumTestTimeMillis = 13 * retentionLeaseExpiryTimeMillis;
import java.util.function.Consumer;
            // cluster-manager changes its mind and cancels the allocation
         * will update its global checkpoint state without the old primary learning of it, and the old primary could have updated its
        final ShardRouting searchReplica = TestShardRouting.newShardRouting(
        // simulate replicas moved up to date.
                .allMatch(
        final int numUpdates = randomInt(10);
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);
            Collections.singleton(active.getId()),
        tracker.updateFromClusterManager(
        final int numberOfActiveAllocationsIds = randomIntBetween(2, 16);
        final ReplicationTracker tracker = newTracker(primaryId);
        final AllocationId primaryId = active.iterator().next();
            .addShard(writeReplica)
            numberOfActiveAllocationsIds,
        final ReplicationTracker.CheckpointState checkpointState = tracker.checkpoints.get(recoveringReplicaId.getId());
            try {
        });
        oldPrimary.completeRelocationHandoff();
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
            assertEquals(3, shardStat.getCheckpointsBehindCount());
    public void testGlobalCheckpointUpdate() {
        assertTrue(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);
 */
            shardId,
        assertThat("renewal happens after a sufficiently long time", tracker.getRetentionLeases().version(), greaterThan(initialVersion));
        assertFalse(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));
            onNewRetentionLease,
    private void assertReplicationLagTimersStartAfterRecoveryCompletes(boolean remote) {
    public void testUpdateFromClusterManagerWithRemoteTranslogEnabled() {
        // now remove shards
        final AllocationId initializing = AllocationId.newInitializing();
        Settings settings = Settings.builder()
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
         */
        Settings settings = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
        // now notify for the new id
        assertEquals(50L, globalCheckpointWithReplicaBehindPrimary(settings, false));
            assertThat("renewal is a no-op after a short time", tracker.getRetentionLeases().version(), equalTo(initialVersion));
            );
        assertThat(
 *
        for (int i = 0; i < numUpdates; i++) {
        final long initialClusterStateVersion = randomNonNegativeLong();
            updatedGlobalCheckpoint::set,
                    return newAllocationId;
    /**
import java.util.ArrayList;
        final ReplicationTracker tracker = newTracker(inSyncAllocationId);
            } catch (final BrokenBarrierException | InterruptedException e) {
        tracker.startReplicationLagTimers(checkpoint);
        );
        assertThat(newPrimary.appliedClusterStateVersion, equalTo(oldPrimary.appliedClusterStateVersion));
     * The global checkpoint must therefore still be bounded by the replica.
            0L
        }
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
    }
        assertTrue("expired extra lease", tracker.getRetentionLeases(true).v1());
        tracker.updateLocalCheckpoint(newSyncingAllocationId.getId(), randomIntBetween(Math.toIntExact(primaryLocalCheckpoint), 1024));
     * checkpoint cannot advance past it.
        final int numberOfActiveAllocationsIds = randomIntBetween(2, 16);
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
        assertEquals(tracker.getGlobalCheckpoint(), primaryLocalCheckpoint);
                .allMatch(
            .build();
            Codec.getDefault().getName(),
        Set<AllocationId> newInitializing = new HashSet<>(initializing);
         * Now we will add an allocation ID to each of active and initializing and ensure they propagate through. Using different lengths
                true,
        ReplicationTracker oldPrimary = new ReplicationTracker(
        final AtomicLong currentTimeMillis = new AtomicLong(0L);
            initializing.forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
        assertTrue(oldPrimary.relocated);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
        assertEquals(tracker.getReplicationGroup().getRoutingTable(), routingTable);
        assertEquals(tracker.getGlobalCheckpoint(), 10 + primaryLocalCheckpoint);
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE - 1);
        tracker.updateGlobalCheckpointOnReplica(nonUpdate, "test");
        final ReplicationTracker tracker = newTracker(primaryId, settings);
                type = "init";
        if (randomBoolean()) {
        markAsTrackingAndInSyncQuietly(tracker, allocationId, localCheckpoint, true);
        assertEquals(tracker.getGlobalCheckpoint(), primaryLocalCheckpoint);
    }
            onUpdate,
                equalTo(expectedLeaseIds)
        markingThread.start();
                currentTimeMillis.addAndGet(randomLongBetween(0L, retentionLeaseExpiryTimeMillis * 2));
                throw new RuntimeException(e);
                clusterState.apply(oldPrimary);
        final String allocationId = randomFrom(oldPrimary.checkpoints.keySet());
        }
        assertTrue(groupStats.isEmpty());
        initializingIds.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED));
            assertThat(
        );
            }
            Codec.getDefault().getName(),
                break;
        final String advancingLeaseId = retentionLeaseFromAllocationId.apply(advancingAllocationId).id();
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        clusterState.apply(newPrimary);
        }
        final long updatedLocalCheckpoint = randomLongBetween(1 + localCheckpoint, Long.MAX_VALUE);
        assertEquals(expectedIds.size(), groupStats.size());
        for (AllocationId replicaId : initializingAllocationIds) {
            allocations.forEach((aid, ckp) -> updateLocalCheckpoint(tracker, aid.getId(), ckp + 10L));
        );
            randomInt(2)
                newPrimary.activateWithPrimaryContext(primaryContext);
        assigned.entrySet()
    }
        final long initialClusterStateVersion = randomNonNegativeLong();
        }
import org.opensearch.cluster.routing.TestShardRouting;
        );
            1,
        );
        // now update all knowledge of all shards
                nodeIdFromAllocationId(primaryId),
                // activate new primary
        );
        final CyclicBarrier barrier = new CyclicBarrier(2);
                barrier.await();
                clusterState.apply(oldPrimary);
        final Set<AllocationId> initializing = Sets.union(initializingToStay.keySet(), initializingToBeRemoved.keySet());
        assertTrue(
 * The OpenSearch Contributors require contributions made to
        assertEquals(50L, globalCheckpointWithReplicaBehindPrimary(settings, false));
        assertThat(
        Settings settings = Settings.builder()
                k -> expectThrows(IllegalStateException.class, () -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED))
    public void testMissingInSyncIdsPreventAdvance() {
        final Set<AllocationId> initializingIdsExceptRelocationTargets = exclude(
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertThat(
        assertTrue("Total time since timer was created should be greater than 200", timer.totalElapsedTime() >= 200);
            numberOfInitializingIds
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
                clusterState.apply(oldPrimary);
        groupStats = tracker.getSegmentReplicationStats();
        Map<String, ReplicationTracker.CheckpointState> oldPrimaryCheckpointsCopy = new HashMap<>(oldPrimary.checkpoints);
        final ShardId shardId = new ShardId("test", "_na_", 0);
        final AllocationId aId = clusterState.routingTable.primaryShard().allocationId();
        tracker.markAllocationIdAsInSync(replicaId.getId(), randomLongBetween(NO_OPS_PERFORMED, localCheckpoint - 1));
import org.opensearch.index.IndexSettings;
        assertEquals(Set.of(checkpoint), tracker.checkpoints.get(relocatingReplicaId.getId()).checkpointTimers.keySet());
/*
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(1, 5);
        }
            tracker.getRetentionLeases().leases().stream().map(RetentionLease::id).collect(Collectors.toSet()),
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
        final AllocationId active = AllocationId.newInitializing();
        // simulate transferring the global checkpoint to the new primary after finalizing recovery before the handoff
        final AllocationId active = AllocationId.newInitializing();
        assertFalse(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));
            Map.of("segment_1", segment),
                newPrimary.activateWithPrimaryContext(primaryContext);
        timer.start();
        tracker.activatePrimaryMode(activeLocalCheckpoint);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        );
        allocations.putAll(initializingToStay);
 * this work for additional information regarding copyright
        addPeerRecoveryRetentionLease(tracker, newSyncingAllocationId);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
        assertTrue(removingInitializingAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()) == null));
            .collect(Collectors.toSet());
        final AllocationId extraId = AllocationId.newInitializing();
            1,
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        assertEquals(updatedGlobalCheckpoint.get(), updatedLocalCheckpoint);
        tracker.updateFromClusterManager(
     * ID to the in-sync set and remove it from the pending set before the local checkpoint updating thread executed the global checkpoint
        tracker.renewPeerRecoveryRetentionLeases();
        final long initialClusterStateVersion = randomNonNegativeLong();
            }
        assertNotEquals(UNASSIGNED_SEQ_NO, tracker.getGlobalCheckpoint());
        });
            .build();
            onUpdate,
        final Map<String, ReplicationTracker.CheckpointState> checkpoints = tracker.checkpoints;
        assertThrows(AssertionError.class, () -> tracker.updateVisibleCheckpointForShard(tracker.shardAllocationId, initialCheckpoint));
                barrier.await();
            .mapToObj(i -> AllocationId.newInitializing())
        final CyclicBarrier barrier = new CyclicBarrier(2);
        final int numberOfInitializingIds = randomIntBetween(0, 8);
                // apply cluster state update on old primary so that the states on old and new primary are comparable
        );
        for (ShardRouting replicaShard : routingTable.replicaShards()) {
        // now insert an unknown active/insync id , the checkpoint shouldn't change but a refresh should be requested.
        final AllocationId primaryId = active.iterator().next();
        final long clusterStateVersion = randomNonNegativeLong();
        Set<AllocationId> newInitializing = new HashSet<>(initializing);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
    public void testUpdateGlobalCheckpointOnReplica() {
            2,
            exclude(clusterState.allIds(), allocationIds),
        );
    }
        barrier.await();
            .collect(Collectors.toSet());
        assertTrue(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);
    public void testInSyncIdsAreIgnoredIfNotValidatedByClusterManagerWithRemoteTranslogEnabled() {
        final long initialClusterStateVersion = randomNonNegativeLong();
                barrier.await();
        AllocationId primaryId = activeAllocationIds.iterator().next();
                Collections.singleton(inSyncAllocationId.getId()),
        assertThat(
            updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));
                TestShardRouting.newShardRouting(
        final int numberOfActiveAllocationsIds,
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
        );
    /**
            allocations.forEach((aid, ckp) -> updateLocalCheckpoint(tracker, aid.getId(), ckp + 10L));
    ) {
            assertTrue(shardStat.getCurrentReplicationLagMillis() >= shardStat.getCurrentReplicationTimeMillis());
        groupStats = tracker.getSegmentReplicationStats();
        logger.info("active: {}, initializing: {}", active, initializing);
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
        );
     * remote translog, so operations not yet uploaded as segments are durable only on the primary and replica disks.
                barrier.await();
        assertEquals(updatedGlobalCheckpoint.get(), updatedLocalCheckpoint);
        tracker.setLatestReplicationCheckpoint(thirdCheckpoint);
        for (final AllocationId replicaId : initializingAllocationIds) {
            "Active ids are in-sync but still unavailable",
    public void testUpdateAllocationIdsFromClusterManager() throws Exception {
        final long updatedLocalCheckpoint = randomLongBetween(1 + localCheckpoint, Long.MAX_VALUE);
        tracker.updateLocalCheckpoint(replicaId.getId(), localCheckpoint);
            builder.addShard(
        for (int i = randomIntBetween(min, max); i > 0; i--) {
        // now we will remove some allocation IDs from these and ensure that they propagate through
        final ShardId shardId = new ShardId("test", "_na_", 0);
                initialClusterStateVersion + 1,
        Set<AllocationId> initializing = new HashSet<>(initializingWithCheckpoints.keySet());
            assertTrue(tracker.getTrackedLocalCheckpointForShard(trackingAllocationId.getId()).inSync);
        final long primaryTerm = randomNonNegativeLong();
            randomIntBetween(Math.toIntExact(minimumActiveLocalCheckpoint), 1024)
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
                    primaryRelocationTarget,
                assertion.run();
            false,
        long primaryLocalCheckpoint = activeWithCheckpoints.get(primaryId);
        final AllocationId recoveringReplicaId = AllocationId.newInitializing();
            final ReplicationTracker.CheckpointState checkpointState = checkpoints.get(id);
                k -> expectThrows(IllegalStateException.class, () -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED))
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            () -> 0L,
            1,
            routingTable(Collections.singleton(trackingAllocationId), inSyncAllocationId)
        );
     *
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
    }
        Set<AllocationId> newInitializing = new HashSet<>(initializing);
        BytesStreamOutput output = new BytesStreamOutput();
            oldPrimary.checkpoints.get(oldPrimary.shardAllocationId).localCheckpoint,
            shardId,
        final Map<AllocationId, Long> allocations = new HashMap<>();
        oldPrimaryCheckpointsCopy.remove(oldPrimary.shardAllocationId);
        initializingThread.start();
                clusterState.apply(oldPrimary);
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
        final Set<AllocationId> initializingIds = activeAndInitializingAllocationIds.v2();
                // apply cluster state update on new primary while primary context is being transferred
        final long initialClusterStateVersion = randomIntBetween(0, Integer.MAX_VALUE - 1);
                )
        tracker.initiateTracking(replicaId.getId());
        final int localCheckpoint = randomIntBetween(1, 32);
        assertTrue(newInitializingAllocationIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        final AllocationId primaryId = AllocationId.newInitializing();
            null,
        BytesStreamOutput output = new BytesStreamOutput();
            .collect(Collectors.toSet());
        randomSubsetOf(initializing.keySet()).forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
            1,
            if (randomBoolean()) {
            .map(allocationId -> retentionLeaseFromAllocationId.apply(allocationId).id())
        final ReplicationTracker tracker = newTracker(primaryId, settings);
        Settings settings = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
        }
        IndexShardRoutingTable routingTable = routingTable(initializingIds, primaryId);
        });
        final ReplicationTracker tracker = newTracker(primaryId, settings);
        }
        assertThat(updatedGlobalCheckpoint.get(), equalTo(update));
        final Set<String> leaseIds = tracker.getRetentionLeases().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());
        final String allocationId,
        Set<AllocationId> active = new HashSet<>(activeWithCheckpoints.keySet());
        assertThat(
import java.util.stream.Stream;
        // now notify for the new id
        final AllocationId trackingAllocationId = AllocationId.newInitializing();
     * local checkpoint to advance could miss updating the global checkpoint in a race if the waiting thread did not add the allocation
            routingTableBuilder.removeShard(replicaShard);
        assertThat(tracker.getGlobalCheckpoint(), greaterThan(minLocalCheckpoint));
        // retry start replication lag timers
            assertThat(tracker.getGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
            Sets.union(ids(activeAllocationIds), ids(initializingIds)),
            .min(Long::compareTo)
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
    private static void addPeerRecoveryRetentionLease(final ReplicationTracker tracker, final AllocationId allocationId) {
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            0L
            1,
            .filter(a -> !removingInitializingAllocationIds.contains(a))
            0L,
                tracker.getRetentionLeases() + " renewed before too long",
            routingTable(newInitializingAllocationIds, primaryId)
                )
        Map<AllocationId, Long> activeWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 5);
                clusterState.apply(newPrimary);
        tracker.updateFromClusterManager(
        }
    public void testSegRepTimer() throws Throwable {
        assertFalse(oldPrimary.primaryMode);
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));
                clusterState.routingTable.primaryShard()
        tracker.updateGlobalCheckpointOnReplica(globalCheckpoint, "test");
        if (randomBoolean()) {
        } else {
            indexSettings,
            clusterState.initializingIds(),
        IndexShardRoutingTable routingTable = routingTable(initializingIds, primaryId);
                .filter(a -> a.equals(primaryId) == false)
        newPrimary.updateRetentionLeasesOnReplica(oldPrimary.getRetentionLeases());
        removingActiveAllocationIds.remove(primaryId);
        final ReplicationTracker tracker = newTracker(primaryId);
    public void testSegmentReplicationCheckpointTracking() {
        assertTrue(
        Set<AllocationId> replicationTargets = tracker.getReplicationGroup()
        final long primaryLocalCheckpoint = activeLocalCheckpoints.get(primaryId);
    /**
        timer.stop();
        final long version;
        assertThat(tracker.getGlobalCheckpoint(), equalTo(checkpoint));
            ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
            }
                // activate new primary
        // now notify for the new id
        assertBusy(() -> assertTrue(tracker.pendingInSync()));
            );
        final Set<AllocationId> activeIds = Set.of(primaryId, recoveringReplicaId);
            tracker.shardId(),
            shardId,
            }
        assertThat(tracker.getGlobalCheckpoint(), equalTo(minimumActiveLocalCheckpoint));
        builder.addShard(
            newActiveAllocationIds.stream()
                relocatingToNodeId,
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            allocations.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
        activeAllocationIds.addAll(initializingAllocationIds);
    }
            allocations.forEach((aid, ckp) -> updateLocalCheckpoint(tracker, aid.getId(), ckp + 10L));
        );
        assertTrue(groupStats.isEmpty());
            .min()
        Settings settings = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            exclude(randomSubsetOf(randomInt(clusterState.inSyncIds.size()), clusterState.inSyncIds), allocationIds)
        assertThat(tracker.getGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
        final AllocationId primaryId = active.iterator().next();
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(0, 5);
        final long minimumInitailizingLocalCheckpoint = (long) initializingLocalCheckpoints.values().stream().min(Integer::compareTo).get();
                shardId,
                // apply cluster state update on both copies while primary context is being transferred
                Collections.singleton(clusterState.routingTable.primaryShard().allocationId()),
        assertTrue(
            .build();
            if (randomBoolean()) {
        final Set<String> expectedLeaseIds = Stream.concat(Stream.of(primaryId), initializingAllocationIds.stream())
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, primaryId));
            updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));
 * Modifications Copyright OpenSearch Contributors. See
        Map<AllocationId, Long> initializingWithCheckpoints = randomAllocationsWithLocalCheckpoints(0, 5);
        });
                .stream()
        assertEquals(updatedGlobalCheckpoint.get(), update);
        final Set<AllocationId> initializingAllocationIds = activeAndInitializingAllocationIds.v2();
        }
            .build();
                barrier.await();
        String allocationId = randomFrom(gcp.checkpoints.keySet());
        final int initializingLocalCheckpoint = randomIntBetween(0, nextActiveLocalCheckpoint - 1);
        assertThat(
            activeToStay.put(primaryId, activeToBeRemoved.remove(primaryId));
        final Set<AllocationId> initializing = Sets.union(initializingToStay.keySet(), initializingToBeRemoved.keySet());
        final AllocationId primaryId = randomFrom(activeAllocationIds);
        primaryContext = new ReplicationTracker.PrimaryContext(streamInput);
            newActiveAllocationIds.stream()
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(2, 5);
        );
import org.opensearch.common.util.set.Sets;
        assertThat(tracker.getRetentionLeases().get(advancingLeaseId).retainingSequenceNumber(), equalTo(initialGlobalCheckpoint + 1));
    }
        initializing.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));
            "lease was renewed because the shard advanced its global checkpoint",
                throw new RuntimeException(e);
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), randomInt((int) minLocalCheckpointAfterUpdates));
        tracker.markAllocationIdAsInSync(replicaId.getId(), 10L);
            tracker.shardId(),
        final ReplicationCheckpoint initialCheckpoint = new ReplicationCheckpoint(
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
        removingActiveAllocationIds.remove(primaryId);
            primaryTerm,
        barrier.await();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            case 1: {
            .filter(a -> !removingActiveAllocationIds.contains(a))
        final long initialClusterStateVersion = randomNonNegativeLong();
            );
                .allMatch(
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));
        final ReplicationTracker tracker = newTracker(primaryId, settings);
        private FakeClusterState(long version, Set<AllocationId> inSyncIds, IndexShardRoutingTable routingTable) {
        addPeerRecoveryRetentionLease(tracker, AllocationId.newInitializing(allocationId));
        // now remove shards
        assertThat(newPrimary.routingTable, equalTo(oldPrimary.routingTable));
        tracker.updateFromClusterManager(
            }
        // A started search replica. It is assigned, but the cluster manager keeps it out of the in-sync set.
                if (!existingAllocationIds.contains(newAllocationId)) {
        FakeClusterState clusterState = initialState();
        }
         * global checkpoint state after the primary context was transferred.
        } else {
        }
            0L
                ids(activeToStay.keySet()),
        AllocationId primaryId = active.keySet().iterator().next();
        expectThrows(IllegalStateException.class, () -> tracker.initiateTracking(randomAlphaOfLength(10)));
                .allMatch(
        thread.join();
        final Map<AllocationId, Long> activeToStay = randomAllocationsWithLocalCheckpoints(1, 5);
        expectThrows(IllegalStateException.class, () -> tracker.initiateTracking(extraId.getId()));
    /**
        final StoreFileMetadata segment_2 = new StoreFileMetadata("segment_2", 50L, "abcd", Version.LATEST);
import java.io.IOException;
    }
                .allMatch(
    }
                clusterState.apply(newPrimary);
            randomNonNegativeLong(),
            Collections.emptyMap(),
            ids(newActiveAllocationIds),
            }
                // no cluster state update
        }
        assertEquals(updatedGlobalCheckpoint.get(), globalCheckpoint);
    }
        assertTrue(activeAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
                randomMarkInSync(oldPrimary, newPrimary);
            } catch (final BrokenBarrierException | InterruptedException e) {
        );
            numberOfActiveAllocationsIds,
        expectThrows(IllegalStateException.class, () -> tracker.initiateTracking(randomAlphaOfLength(10)));
    public void testGlobalCheckpointUpdateWithRemoteTranslogEnabled() {
        tracker.markAllocationIdAsInSync(replicaId.getId(), NO_OPS_PERFORMED);
        );
            try {
        addPeerRecoveryRetentionLease(oldPrimary, newPrimary.shardAllocationId);
import java.util.concurrent.BrokenBarrierException;
            "all leases were renewed",
        tracker.updateFromClusterManager(
            shardId,
            .forEach(
        final List<AllocationId> removingInitializingAllocationIds = randomSubsetOf(initializingIds);
        Map<AllocationId, Long> allocations = new HashMap<>(activeWithCheckpoints);
        final AllocationId primaryId = active.iterator().next();
        assertEquals(tracker.getReplicationGroup().getReplicationTargets().size(), active.size());
            tracker.updateFromClusterManager(
            Math.max(SequenceNumbers.NO_OPS_PERFORMED, oldPrimary.getGlobalCheckpoint() + randomInt(5))
            logger.info("  - [{}], local checkpoint [{}], [{}]", aId, allocations.get(aId), type);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        }
        final CyclicBarrier barrier = new CyclicBarrier(2);
            1,
                clusterState.apply(newPrimary);
        activeThread.start();
        assertThat(newPrimary.getGlobalCheckpoint(), equalTo(oldPrimary.getGlobalCheckpoint()));
                final String leaseId = retentionLeaseFromAllocationId.apply(replicaId).id();
        updatedGlobalCheckpoint.set(UNASSIGNED_SEQ_NO);
        final long minLocalCheckpointAfterUpdates = allocations.values().stream().min(Long::compareTo).orElse(UNASSIGNED_SEQ_NO);
        Set<AllocationId> replicationTargets = tracker.getReplicationGroup()
        assertEquals(tracker.getGlobalCheckpoint(), primaryLocalCheckpoint);
        assertThat(newPrimary.routingTable, equalTo(oldPrimary.routingTable));
            if (randomBoolean()) {
    }
            .filter(a -> !removingActiveAllocationIds.contains(a))
        final Set<AllocationId> initializingIds = activeAndInitializingAllocationIds.v2();
            )
    }
        FakeClusterState clusterState = initialState();
         */
        activeLocalCheckpoints.forEach((a, l) -> updateLocalCheckpoint(tracker, a.getId(), l));
import org.opensearch.cluster.routing.AllocationId;
        newPrimaryCheckpointsCopy.remove(newPrimary.shardAllocationId);
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
            primaryId.getId(),
        assertTrue(newActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
            aId.getRelocationId(),
        );
            tracker.shardId(),
        clusterState.apply(newPrimary);
            relocatingId
        } else {
        tracker.startReplicationLagTimers(initialCheckpoint);
        assertTrue(activeAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
                )
            assertFalse(tracker.getTrackedLocalCheckpointForShard(trackingAllocationId.getId()).inSync);
        final ReplicationTracker tracker = newTracker(primaryId, updatedGlobalCheckpoint::set, currentTimeMillis::get);
            initializing.forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
        assertTrue(activeAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        if (tracker.getRetentionLeases().contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(nodeId)) == false) {
            .collect(Collectors.toMap(Function.identity(), a -> randomIntBetween(1, 1024)));
        final Map<AllocationId, Long> activeToBeRemoved = randomAllocationsWithLocalCheckpoints(1, 5);
import java.util.concurrent.CyclicBarrier;
    }
        StreamInput streamInput = output.bytes().streamInput();
        logger.info("--> initializingIds {} Target {}", initializingIds, targetAllocationId);
            tracker.updateFromClusterManager(
        final Map<AllocationId, Long> initializingToStay = randomAllocationsWithLocalCheckpoints(1, 5);
        final long testStartTimeMillis = randomLongBetween(0L, Long.MAX_VALUE - maximumTestTimeMillis);
         * will update its global checkpoint state without the old primary learning of it, and the old primary could have updated its
        final int numberOfActiveAllocationsIds = randomIntBetween(1, 8);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        final long minLocalCheckpointAfterUpdates = allocations.entrySet()
     * Search replicas appear in the routing table but are never tracked by the primary, so they have no entry in
            newPrimary.shardAllocationId,
        final Set<AllocationId> initializingIdsToRemove = new HashSet<>(
        tracker.updateFromClusterManager(
            }
            routingTableBuilder.addShard(replicaShard.moveToStarted());
        final ReplicationTracker tracker = newTracker(inSyncAllocationId);
            null,
            tracker.getReplicationGroup().getInSyncAllocationIds()
                type = "active";
        IndexShardRoutingTable routingTable = builder.build();
            } else {
            assertThat(
        Set<AllocationId> initializing = new HashSet<>(initializingWithCheckpoints.keySet());
            } else if (initializing.contains(aId)) {
            oldPrimary.checkpoints.get(newPrimary.shardAllocationId).localCheckpoint,
        final int globalCheckpoint = randomIntBetween(localCheckpoint + 1, 64);
        Map<String, ReplicationTracker.CheckpointState> oldPrimaryCheckpointsCopy = new HashMap<>(oldPrimary.checkpoints);
    public void testPrimaryContextHandoffWithRemoteTranslogEnabled() throws IOException {
                // apply cluster state update on old primary while primary context is being transferred
        tracker.updateFromClusterManager(initialClusterStateVersion + 1, ids(active), routingTable(newInitializing, primaryId));
    private static void addPeerRecoveryRetentionLease(final ReplicationTracker tracker, final String allocationId) {
            if (active.contains(aId)) {
        );
        initializingIds.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED));
            case 3: {
        tracker.startReplicationLagTimers(recoveryCheckpoint);
            numberOfInitializingIds
        tracker.setLatestReplicationCheckpoint(secondCheckpoint);
        );
         * The new in-sync allocation ID is in the in-sync set now yet the cluster-manager does not know this; the allocation ID should still be in
        if (randomBoolean()) {
        assertEquals(expectedIds.size(), groupStats.size());
            1L,
import java.util.stream.Collectors;
            indexSettings,
            .forEach(e -> updateLocalCheckpoint(tracker, e.getKey().getId(), e.getValue()));
            throw new AssertionError("expected the leases to be created", e);
                .collect(Collectors.toSet())
        final int numberOfInitializingIds = randomIntBetween(2, 16);
            this.routingTable = routingTable;
            // do another handoff
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        );
        tracker.startReplicationLagTimers(initialCheckpoint);
        assertThat(
        final CyclicBarrier barrier = new CyclicBarrier(4);
            case 1: {
            )
            // Leases still don't expire
        );
        final long initialClusterStateVersion = randomNonNegativeLong();
        /*
        final long localCheckpoint = randomIntBetween(
        if (randomBoolean()) {
        markAsTrackingAndInSyncQuietly(tracker, replicaId.getId(), NO_OPS_PERFORMED);
        final Set<AllocationId> newActiveAllocationIds = activeAllocationIds.stream()
        markingThread.join();
        nonApproved.keySet()
        newInitializingAllocationIds.add(newSyncingAllocationId);
            tracker.getReplicationGroup().getUnavailableInSyncShards(),
        newPrimaryCheckpointsCopy.remove(newPrimary.shardAllocationId);
        } else {
            15L,
            NON_REMOTE_DISCOVERY_NODE
    public void testGlobalCheckpointNotBoundedByReplicaWithRemoteTranslog() throws InterruptedException {
            aId.getId(),
        assertTrue(replicationTargets.containsAll(initializing));
/*
            Collections.singleton(inSyncAllocationId.getId()),
        final AllocationId inSyncAllocationId = AllocationId.newInitializing();
            oldPrimary.checkpoints.get(oldPrimary.shardAllocationId).localCheckpoint,
        Set<AllocationId> active = new HashSet<>(activeWithCheckpoints.keySet());
            );
        assertThat(tracker.getGlobalCheckpoint(), not(equalTo(UNASSIGNED_SEQ_NO)));
        return allocationIds.stream().filter(aId -> !excludeIds.contains(aId.getId())).collect(Collectors.toSet());
        });
            final long startTime = currentTimeMillis.get();
        return new FakeClusterState(
            assertTrue(tracker.getTrackedLocalCheckpointForShard(newSyncingAllocationId.getId()).inSync);
                clusterState.apply(newPrimary);
        );
        activeAllocationIds.remove(primaryId);
            151L,
        assertTrue(activeAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
            if (randomBoolean()) {
    public void testRaceUpdatingGlobalCheckpoint() throws InterruptedException, BrokenBarrierException {
        );
        final AllocationId active = AllocationId.newInitializing();
        final ReplicationTracker tracker = newTracker(primaryId, settings, shardOnRemoteEnabledNode);
        final long localCheckpoint,
        public Set<AllocationId> allIds() {
                ids(activeToStay.keySet()),
    }
                newPrimary.activateWithPrimaryContext(primaryContext);
                .allMatch(
                // synchronize starting with the test thread
        );
        assertThat(newPrimary.appliedClusterStateVersion, equalTo(oldPrimary.appliedClusterStateVersion));
     * allocation ID to the in-sync set and removing it from pending, the local checkpoint update that freed the thread waiting for the
        final ReplicationTracker tracker = newTracker(primaryId, settings, remote);
    }
            if (rarely()) {
    }
        allocations.keySet().forEach(aId -> {
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            exclude(randomSubsetOf(randomInt(clusterState.initializingIds().size()), clusterState.initializingIds()), allocationIds)
     */
        }
        final Set<AllocationId> initializingIdsToAdd = randomAllocationIdsExcludingExistingIds(
        );
        final ReplicationCheckpoint thirdCheckpoint = new ReplicationCheckpoint(
        activeThread.join();
        assertBusy(() -> {
                barrier.await();
        initializing.keySet().forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
            .filter(a -> !removingInitializingAllocationIds.contains(a))
                .filter(a -> a.equals(primaryId) == false)
            primaryId
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
            tracker.updateLocalCheckpoint(active.getId(), nextActiveLocalCheckpoint);
            randomNonNegativeLong(),
    private static Set<String> ids(Set<AllocationId> allocationIds) {
         * We can not assert on shared knowledge of the global checkpoint between the old primary and the new primary as the new primary
        });
        );
                break;
            allocations.putAll(activeToBeRemoved);
            // Leases still don't expire
            initialLeases.add(retentionLeaseFromAllocationId.apply(AllocationId.newInitializing()));
        Set<String> allocationIds = new HashSet<>(Arrays.asList(oldPrimary.shardAllocationId, newPrimary.shardAllocationId));
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(updatedGlobalCheckpoint.get(), UNASSIGNED_SEQ_NO);
                .allMatch(e -> tracker.getTrackedLocalCheckpointForShard(e.getKey().getId()).getLocalCheckpoint() == e.getValue())
        Settings settings = Settings.builder().put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
    public void testMarkAllocationIdAsInSync() throws Exception {
            } else {
        assertEquals(updatedGlobalCheckpoint.get(), primaryLocalCheckpoint);
        final ReplicationTracker tracker = newTracker(primaryId);
            0L,
            // do another handoff
            onUpdate,
            onNewRetentionLease,
        assertTrue(
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(1, 5);
        logger.info("active: {}, initializing: {}", active, initializing);
 * Unless required by applicable law or agreed to in writing,
                .stream()
        final StoreFileMetadata segment_3 = new StoreFileMetadata("segment_3", 100L, "abcd", Version.LATEST);
        assertNull(tracker.checkpoints.get(extraId.getId()));
        for (String id : expectedIds) {
            false,
            nodeIdFromAllocationId(replicaId),
        final ReplicationTracker tracker = newTracker(active, settings);
        assertThat(allocations.size(), equalTo(active.size() + initializing.size()));
            tracker.updateFromClusterManager(
        tracker.activatePrimaryMode(localCheckpoint);
            ? primaryId
        IndexShardRoutingTable.Builder routingTableBuilder = new IndexShardRoutingTable.Builder(routingTable);
                clusterState.apply(oldPrimary);
                newPrimary.activateWithPrimaryContext(primaryContext);
                .allMatch(
        );
 * ownership. Elasticsearch licenses this file to you under
        final ReplicationTracker tracker = newTracker(primaryId);
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
            Codec.getDefault().getName(),
            clusterState.version + randomIntBetween(1, 5),
            gcp.updateFromClusterManager(version, ids(inSyncIds), routingTable);
            numberOfInitializingIds
        );
            this.version = version;
        // update again
            routingTable(newInitializingAllocationIds, primaryId)
        String relocatingToNodeId = nodeIdFromAllocationId(targetAllocationId);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        );
            assertTrue(complete.get());
        // now it should be incremented
        for (int i = randomIntBetween(0, 5); i > 0; i--) {
        // first we assert that the in-sync and tracking sets are set up correctly
        final ReplicationTracker tracker = newTracker(primaryId);
                break;
    public void testGlobalCheckpointBoundedByReplicaWithSegmentsOnlyRemoteStore() throws InterruptedException {
        tracker.updateFromClusterManager(
        expectThrows(IllegalStateException.class, () -> tracker.initiateTracking(extraId.getId()));
        );
            51L,
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
import org.opensearch.common.collect.Tuple;
        final long newGlobalCheckpoint = initialGlobalCheckpoint + randomLongBetween(1, 1000);
        assertThat(
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
            remainingInSyncIds.isEmpty() ? clusterState.inSyncIds : remainingInSyncIds,
            + 10; // we added 10 to make sure it's advanced in the second time
import java.util.stream.IntStream;
            ids(newActiveAllocationIds),
        assertThat(tracker.getGlobalCheckpoint(), equalTo(NO_OPS_PERFORMED));
            routingTable(newInitializingAllocationIds, primaryId)
        markAsTrackingAndInSyncQuietly(
        } else {
            1,
        assertTrue(tracker.hasAllPeerRecoveryRetentionLeases());
            }
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
            Sets.difference(ids(activeAllocationIds), Set.of(primaryId.getId()))
        tracker.markAllocationIdAsInSync(replicaId.getId(), updatedLocalCheckpoint);
                )
        final AllocationId advancingAllocationId = initializingAllocationIds.isEmpty() || rarely()
    }
        final Set<AllocationId> newInitializingAllocationIds = initializingIds.stream()
        assigned.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), 10 + localCP));
            .collect(Collectors.toSet());
            .collect(Collectors.toSet());
            if (randomBoolean()) {
            newPrimary.shardAllocationId,
        tracker.updateLocalCheckpoint(replicaId.getId(), 50L);
        final ReplicationTracker tracker = newTracker(active);
            try {
        expectThrows(IllegalStateException.class, () -> tracker.markAllocationIdAsInSync(randomAlphaOfLength(10), randomNonNegativeLong()));
        assertThat(
    }
        final ReplicationCheckpoint initialCheckpoint = new ReplicationCheckpoint(
            if (randomBoolean()) {
            tracker.getRetentionLeases().get(advancingLeaseId).retainingSequenceNumber(),
        if (missingActiveID.equals(primaryId) == false) {
import org.apache.lucene.codecs.Codec;
            2,
            }
        tracker.initiateTracking(replicaId.getId());
                type = "active";
            globalCheckpoint,
            0L
        logger.info("--> using allocations");
        );
        Map<AllocationId, Long> activeWithCheckpoints = randomAllocationsWithLocalCheckpoints(1, 1);
                final AllocationId newAllocationId = AllocationId.newInitializing();
    public void testEmptyShards() {
        final List<RetentionLease> initialLeases = new ArrayList<>();
            routingTable(Collections.singleton(trackingAllocationId), inSyncAllocationId)
        allocations.forEach(a -> a.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP)));
                Sets.difference(Sets.union(initializingIdsExceptRelocationTargets, initializingIdsToAdd), initializingIdsToRemove),
            } catch (final BrokenBarrierException | InterruptedException e) {
        assertThat(tracker.getReplicationGroup().getInSyncAllocationIds(), equalTo(ids(activeAllocationIds)));
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
        final int numberOfInitializingIds = randomIntBetween(2, 16);
        );
        final LongConsumer onUpdate = updatedGlobalCheckpoint -> {};
        }
        tracker.updateVisibleCheckpointForShard(recoveringReplicaId.getId(), recoveryCheckpoint);
 * the Apache License, Version 2.0 (the "License"); you may
                    null,
        allocations.putAll(initializingWithCheckpoints);
        switch (randomInt(3)) {
                barrier.await();
        tracker.startReplicationLagTimers(initialCheckpoint);
        assertTrue(removingInitializingAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()) == null));
                    relocatingReplicaId
        if (randomBoolean()) {
    public void testIllegalStateExceptionIfUnknownAllocationIdWithRemoteTranslogEnabled() {
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
        final Thread initializingThread = new Thread(() -> {
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
        AllocationId primaryId = activeAllocationIds.iterator().next();
        assertReplicationLagTimersStartAfterRecoveryCompletes(false);
        )
            (leases, listener) -> listener.onResponse(new ReplicationResponse()),
            2,
                tracker.markAllocationIdAsInSync(replicaId.getId(), randomLongBetween(NO_OPS_PERFORMED, localCheckpoint - 1));
        final Set<AllocationId> newActiveAllocationIds = activeAllocationIds.stream()
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        final ShardRouting primaryShard = TestShardRouting.newShardRouting(
            currentTimeMillis.get(),
        tracker.setLatestReplicationCheckpoint(recoveryCheckpoint);
        AllocationId primaryId = active.keySet().iterator().next();
            0L,
        tracker.updateFromClusterManager(
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .collect(Collectors.toSet());
        // now we are going to add a new allocation ID and bring it in sync which should move it to the in-sync allocation IDs
                clusterState.apply(newPrimary);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            "search-node",
        allocations.keySet().forEach(aId -> {
        final Map<AllocationId, Integer> initializingLocalCheckpoints = newInitializingAllocationIds.stream()
        final ReplicationTracker tracker = newTracker(primaryId);
        if (randomBoolean()) {
import org.opensearch.common.Randomness;
        }
        tracker.renewPeerRecoveryRetentionLeases();
            0,
            tracker.initiateTracking(allocationId);
    private static void markAsTrackingAndInSyncQuietly(
        oldPrimary.activatePrimaryMode(randomIntBetween(Math.toIntExact(NO_OPS_PERFORMED), 10));
        );
                throw new RuntimeException(e);
            }
    public void testMissingActiveIdsPreventAdvance() {
                barrier.await();
        assertThat(updatedGlobalCheckpoint.get(), not(equalTo(UNASSIGNED_SEQ_NO)));
        /*
         */
        assertThat(tracker.getGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
        assertThat(newPrimary.replicationGroup, equalTo(oldPrimary.replicationGroup));
        final StoreFileMetadata segment = new StoreFileMetadata("segment_1", 5L, "abcd", Version.LATEST);
            final String type;
        final Map<AllocationId, Long> activeToStay = randomAllocationsWithLocalCheckpoints(1, 5);
        primaryContext.writeTo(output);
        assertTrue(activeAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        );
                // no cluster state update
        assertThat("immediate renewal is a no-op", tracker.getRetentionLeases().version(), equalTo(initialVersion));
        updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));
                clusterState.apply(oldPrimary);
            final String type;
            assertThat(updatedGlobalCheckpoint.get(), equalTo(UNASSIGNED_SEQ_NO));
    }
        final ReplicationTracker tracker = newTracker(primaryId, settings);
        assertThat(updatedGlobalCheckpoint.get(), equalTo(UNASSIGNED_SEQ_NO));
            1,
        assertEquals(updatedGlobalCheckpoint.get(), primaryLocalCheckpoint);
                clusterState.apply(oldPrimary);
                tracker.initiateTracking(trackingAllocationId.getId());
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);
        tracker.markAllocationIdAsInSync(replicaId.getId(), updatedLocalCheckpoint);
        tracker.updateFromClusterManager(
        assertTrue(newActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        tracker.setLatestReplicationCheckpoint(initialCheckpoint);
        final AllocationId initializing = AllocationId.newInitializing();
            .build();
            assertEquals(updatedGlobalCheckpoint.get(), primaryLocalCheckpoint);
            oldPrimary.checkpoints.get(oldPrimary.shardAllocationId).inSync,
        final Thread thread = new Thread(() -> {
    private ReplicationTracker newTracker(final AllocationId allocationId) {
     */
    ) {
            // ... and any extra peer recovery retention leases are expired immediately since the shard is fully active
        final Map<AllocationId, Long> nonApproved = randomAllocationsWithLocalCheckpoints(1, 5);
            activeAllocationIds,
        for (final AllocationId initializingId : initializingIds) {
        assertThat(updatedGlobalCheckpoint.get(), equalTo(updatedLocalCheckpoint));
    }
        active.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));
            ids(newActiveAllocationIds),
            } catch (final BrokenBarrierException | InterruptedException e) {
            }
        assertThat(allocations.size(), equalTo(active.size() + initializing.size()));
        assertBusy(() -> {
        if (millisUntilFirstRenewal != 0) {
        final int numberOfActiveAllocationsIds = randomIntBetween(2, 16);
        final long update = randomLongBetween(globalCheckpoint, Long.MAX_VALUE);
        // first check that adding it without the cluster-manager blessing doesn't change anything.
        assertTrue(newActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
                    a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).getLocalCheckpoint() == SequenceNumbers.UNASSIGNED_SEQ_NO
            assertThat(
                barrier.await();
        AllocationId primaryId = activeAllocationIds.iterator().next();
            numberOfActiveAllocationsIds,
        for (final RetentionLease retentionLease : tracker.getRetentionLeases().leases()) {
 * You may obtain a copy of the License at
        );
            equalTo(ids(Sets.difference(Sets.union(activeAllocationIds, newActiveAllocationIds), removingActiveAllocationIds)))
        final AllocationId initializing = AllocationId.newInitializing();
            globalCheckpoint,
            assertEquals(tracker.getGlobalCheckpoint(), primaryLocalCheckpoint);
        }
            }
    public void testWaitForAllocationIdToBeInSyncCanBeInterrupted() throws BrokenBarrierException, InterruptedException {
        if (randomBoolean()) {
        activeLocalCheckpoints.forEach((a, l) -> updateLocalCheckpoint(tracker, a.getId(), l));
    private static Tuple<Set<AllocationId>, Set<AllocationId>> randomActiveAndInitializingAllocationIds(
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(0, 5);
            equalTo(expectedLeaseIds)
            RemoteStoreTestsHelper.createIndexSettings(
        );
        assertTrue(tracker.getSegmentReplicationStats().isEmpty());
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
        final long initialClusterStateVersion = randomNonNegativeLong();
        tracker.updateLocalCheckpoint(
        final int numberOfInitializingIds = randomIntBetween(2, 16);
        final long initialClusterStateVersion = randomNonNegativeLong();
        // noinspection OptionalGetWithoutIsPresent
            lessThanOrEqualTo(testStartTimeMillis + maximumTestTimeMillis)
            newInitializingAllocationIds.stream()
    }
        );
        final AllocationId trackingAllocationId = AllocationId.newInitializing();
        );
                .map(s -> s.allocationId().getRelocationId())
        barrier.await();
                randomLocalCheckpointUpdate(oldPrimary);
                tracker.getRetentionLeases().leases().stream().mapToLong(RetentionLease::timestamp).min().getAsLong(),
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertThat(updatedGlobalCheckpoint.get(), equalTo(primaryLocalCheckpoint));
            .collect(Collectors.toSet());
            case 3: {
                tracker.markAllocationIdAsInSync(trackingAllocationId.getId(), localCheckpoint);
 * software distributed under the License is distributed on an
        // now insert an unknown active/insync id , the checkpoint shouldn't change but a refresh should be requested.
        Settings settings = Settings.builder()
        initializing.forEach(aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED, false));
        final Tuple<Set<AllocationId>, Set<AllocationId>> activeAndInitializingAllocationIds = randomActiveAndInitializingAllocationIds(
                // apply cluster state update on new primary while primary context is being transferred
            tracker.getRetentionLeases().leases().stream().allMatch(l -> l.timestamp() == currentTimeMillis.get())
            }
        assertTrue(newPrimary.primaryMode);
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
                )
        addPeerRecoveryRetentionLease(tracker, replicaId);
            .stream()
            1,
        assertTrue(removingActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()) == null));
        assertTrue(oldPrimary.primaryMode);
            activeLocalCheckpoints.entrySet()
        final ShardRouting primaryShard = TestShardRouting.newShardRouting(
        tracker.updateFromClusterManager(
        primaryContext.writeTo(output);
        }
        assertEquals(recoveringReplicaId.getId(), replicaStats.getAllocationId());
                assertTrue(
        );
                barrier.await();
        final Thread markingThread = new Thread(() -> {
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(activeAllocationIds), routingTable);
        final Set<AllocationId> startedAllocationIds = Sets.union(initializingIds, Set.of(primaryId));
            }
         *
            Map.of("segment_1", segment1, "segment_2", segment2),
        Map<AllocationId, Long> allocations = new HashMap<>();
        IndexShardRoutingTable routingTable = routingTable(initializingIds, primaryId);
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));
            nodeIdFromAllocationId(relocatingId),
        Set<SegmentReplicationShardStats> groupStats = tracker.getSegmentReplicationStats();
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
            try {
            : randomFrom(initializingAllocationIds);
        );
        );
        final ReplicationTracker tracker = newTracker(active, settings);
            Map.of("segment_1", segment_1),
        thread.join();
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
                ids(activeToStay.keySet()),
        final Map<String, ReplicationTracker.CheckpointState> checkpoints = tracker.checkpoints;
                clusterState.apply(oldPrimary);
                tracker.initiateTracking(newSyncingAllocationId.getId());
        final BiConsumer<RetentionLeases, ActionListener<ReplicationResponse>> onNewRetentionLease = (leases, listener) -> {};
        oldPrimaryCheckpointsCopy.remove(newPrimary.shardAllocationId);
            initialClusterStateVersion + 2,
            routingTable(Collections.singleton(initializing), active)
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
        try {
        List<Map<AllocationId, Long>> allocations = Arrays.asList(active, initializing, nonApproved);
            shardId,
            numberOfInitializingIds
        assigned.entrySet()
    public void testPeerRecoveryRetentionLeaseCreationAndRenewal() {
            tracker.addPeerRecoveryRetentionLease(randomAlphaOfLength(10), randomNonNegativeLong(), ActionListener.wrap(() -> {}));
        assertFalse(oldPrimary.relocated);
            equalTo(newGlobalCheckpoint + 1)
        // note: allocations can never be empty in practice as we always have at least one primary shard active/in sync
                // apply cluster state update on new primary so that the states on old and new primary are comparable
        allocations.keySet().forEach(aId -> updateLocalCheckpoint(tracker, aId.getId(), allocations.get(aId)));
                )
        barrier.await();
            assertThat(expectedLeaseIds, hasItem(retentionLease.id()));
            0L,
            initializingIds.stream()
            .map(Map.Entry::getValue)
        public Set<AllocationId> initializingIds() {
            numberOfActiveAllocationsIds,
                break;
            if (rarely()) {
        tracker.updateFromClusterManager(initialClusterStateVersion + randomLongBetween(1, 10), ids(activeAllocationIds), routingTable);
            ids(newActiveAllocationIds),
        assertTrue(removingActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()) == null));
            Codec.getDefault().getName(),
                throw new AssertionError(e);
        tracker.updateFromClusterManager(
        final long initialClusterStateVersion = randomNonNegativeLong();
                newPrimary.activateWithPrimaryContext(primaryContext);
            tracker.getRetentionLeases().contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(routingTable.primaryShard()))
    public void testCreateMissingPeerRecoveryRetentionLeasesSkipsSearchReplicas() throws InterruptedException {
                .allMatch(e -> tracker.getTrackedLocalCheckpointForShard(e.getKey().getId()).getLocalCheckpoint() == e.getValue())
import org.opensearch.index.remote.RemoteStoreTestsHelper;
            tracker.addPeerRecoveryRetentionLease(nodeId, NO_OPS_PERFORMED, ActionListener.wrap(() -> {}));
        );
        final int globalCheckpoint = randomIntBetween(localCheckpoint + 1, 64);
        assertTrue(
        final ReplicationTracker tracker = newTracker(primaryId);
            activeAllocationIds.stream()
        final Set<AllocationId> initializingIds = randomAllocationIdsExcludingExistingIds(activeAllocationIds, numberOfInitializingIds);
            }
        }
        newPrimaryCheckpointsCopy.remove(oldPrimary.shardAllocationId);
        final Map<AllocationId, Long> active = randomAllocationsWithLocalCheckpoints(1, 5);
        // synchronize with the waiting thread to mark that it is complete
            Codec.getDefault().getName(),
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            // noinspection OptionalGetWithoutIsPresent
     * This test checks that the global checkpoint update mechanism is honored and relies only on the shards that have
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        AllocationId primaryId = activeAllocationIds.iterator().next();
    public void testSegmentReplicationCheckpointForRelocatingPrimary() {
            .build();
        }
import org.opensearch.core.index.shard.ShardId;
                tracker.getRetentionLeases().leases().stream().map(RetentionLease::id).collect(Collectors.toSet()),
            tracker.getTrackedLocalCheckpointForShard(advancingAllocationId.getId()).globalCheckpoint
        // we are implicitly marking the pending in sync copy as in sync with the current global checkpoint, no advancement should occur
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            tracker.updateFromClusterManager(
            initializingLocalCheckpoints.entrySet()
                routingTable(initializingToStay.keySet(), primaryId)
        }
        final Map<AllocationId, Long> initializing = randomAllocationsWithLocalCheckpoints(1, 5);
                );
            routingTable(
                clusterState.apply(newPrimary);
            Codec.getDefault().getName(),
        nonApproved.keySet()
        );
            }
        }
        randomSubsetOf(randomIntBetween(1, initializing.size() - 1), initializing.keySet()).forEach(
            tracker.shardId(),
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        final ShardId shardId = new ShardId("test", "_na_", 0);
        assertThat(updatedGlobalCheckpoint.get(), equalTo(tracker.getGlobalCheckpoint()));
        final long initialClusterStateVersion = randomNonNegativeLong();
            }
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, active, primaryId));
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
            }
        final int numberOfInitializingIds
        final Set<AllocationId> inSyncIds;
    public void testMissingActiveIdsDoesNotPreventAdvanceWithRemoteTranslogEnabled() {
        tracker.setLatestReplicationCheckpoint(initialCheckpoint);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
                .allMatch(e -> tracker.getTrackedLocalCheckpointForShard(e.getKey().getId()).getLocalCheckpoint() == e.getValue())
            ShardRoutingState.STARTED,
            Math.toIntExact(Math.min(minimumActiveLocalCheckpoint, minimumInitailizingLocalCheckpoint) - 1)
        final AllocationId aId = clusterState.routingTable.primaryShard().allocationId();
         * The new in-sync allocation ID is in the in-sync set now yet the cluster-manager does not know this; the allocation ID should still be in
        final Map<AllocationId, Long> allocations = new HashMap<>();
            routingTable(newInitializingAllocationIds, primaryId)
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
 *     http://www.apache.org/licenses/LICENSE-2.0
        final long retentionLeaseExpiryTimeMillis = tracker.indexSettings().getRetentionLeaseMillis();
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        tracker.updateFromClusterManager(2L, ids(activeIds), routingTable(Collections.emptySet(), activeIds, primaryId));
        } else {
            if (randomBoolean()) {
        active.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
        final Map<AllocationId, Integer> initializingLocalCheckpoints = newInitializingAllocationIds.stream()
            // abort handoff, check that we can continue updates and retry handoff
     * call is added after notifying all waiters in {@link ReplicationTracker#updateLocalCheckpoint(String, long)}).
            0L
        return allocations;
                routingTable(emptySet(), inSyncAllocationId)
            try {
        tracker.updateLocalCheckpoint(primaryId.getId(), 100L);
         * than we have been using above ensures that we can not collide with a previous allocation ID
        // increment checkpoints
                    false,
 *
            activeAllocationIds.stream()
            markAsTrackingAndInSyncQuietly(tracker, replicaId.getId(), NO_OPS_PERFORMED);
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        final CyclicBarrier barrier = new CyclicBarrier(2);
                initialClusterStateVersion + 2,
        AllocationId primaryId = active.keySet().iterator().next();
        final StoreFileMetadata segment1 = new StoreFileMetadata("segment_1", 5L, "abcd", Version.LATEST);
        if (randomBoolean()) {
     * This test checks that updateGlobalCheckpointOnReplica with remote translog does not violate any of the invariants
            TestShardRouting.newShardRouting(
         * the in-sync set even if we receive a cluster state update that does not reflect this.
        );
        thread.interrupt();
     * store migration must skip them; including them would dereference a null checkpoint and would also size the
     * Plain segment replication with a local translog. The replica is part of the replication group, so the global
        Settings settings = Settings.builder()
        // first check that adding it without the cluster-manager blessing doesn't change anything.
        assertEquals(100L, globalCheckpointWithReplicaBehindPrimary(settings, true));
    }
                .allMatch(e -> tracker.getTrackedLocalCheckpointForShard(e.getKey().getId()).getLocalCheckpoint() == e.getValue())
import org.opensearch.indices.replication.common.ReplicationType;
        tracker.initiateTracking(extraId.getId());
        final AllocationId primaryId = active.iterator().next();
        );
        tracker.updateLocalCheckpoint(primaryId.getId(), updatedLocalCheckpoint);
        assertTrue(tracker.checkpoints.get(recoveringReplicaId.getId()).checkpointTimers.isEmpty());
            return Sets.union(initializingIds(), inSyncIds);
                tracker.markAllocationIdAsInSync(initializing.getId(), initializingLocalCheckpoint - 1);
        assertTrue(
        final String allocationId,
        tracker.updateFromClusterManager(initialClusterStateVersion + 1, ids(active), routingTable(newInitializing, primaryId));
        // now we expect that the global checkpoint would advance
        // Unknown allocation ID will be ignored.
        Map<AllocationId, Long> activeWithCheckpoints = randomAllocationsWithLocalCheckpoints(2, 5);
        active.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.index.store.StoreFileMetadata;
            } catch (final InterruptedException e) {
 * GitHub history for details.
        long currentLocalCheckpoint = gcp.checkpoints.get(allocationId).getLocalCheckpoint();
        for (SegmentReplicationShardStats shardStat : groupStats) {
                    nodeIdFromAllocationId(initializingId),
        );
        tracker.updateGlobalCheckpointOnReplica(globalCheckpoint, "test");
    }
        tracker.setLatestReplicationCheckpoint(initialCheckpoint);
        assertTrue(
            clusterState.routingTable.activeShards()
        assertEquals(tracker.getGlobalCheckpoint(), checkpoint);
        Map<AllocationId, Long> initializingWithCheckpoints = randomAllocationsWithLocalCheckpoints(0, 5);
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        final int numberOfActiveAllocationsIds = randomIntBetween(2, 16);
        final int localCheckpoint = randomIntBetween(1, 32);
        final AllocationId primaryId = active.iterator().next();
        final AllocationId inSyncAllocationId = AllocationId.newInitializing();
                ids(activeToStay.keySet()),
        }
            5L,
        randomSubsetOf(randomIntBetween(1, initializing.size() - 1), initializing.keySet()).forEach(
                clusterState = randomUpdateClusterState(allocationIds, clusterState);
            nodeId -> primaryNode.equals(nodeId)
        );
            if (rarely()) {
        AllocationId primaryId = active.keySet().iterator().next();
    }
            assertEquals(151L, shardStat.getBytesBehindCount());
                routingTable(initializingToStay.keySet(), primaryId)
        tracker.updateGlobalCheckpointOnReplica(update, "test");
        final Set<AllocationId> activeAllocationIds = activeAndInitializingAllocationIds.v1();
            initializingToStay.keySet().forEach(k -> markAsTrackingAndInSyncQuietly(tracker, k.getId(), NO_OPS_PERFORMED));
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        tracker.activatePrimaryMode(localCheckpoint);
        }
        tracker.initiateTracking(replicaId.getId());
        allocations.forEach(a -> a.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP)));
            0L,
        final BiConsumer<RetentionLeases, ActionListener<ReplicationResponse>> onNewRetentionLease = (leases, listener) -> {};
        final AllocationId relocatingReplicaId = AllocationId.newRelocation(replicaId);
        );
 * under the License.
        final StoreFileMetadata segment2 = new StoreFileMetadata("segment_2", 10L, "abcd", Version.LATEST);
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE - 1);
            .build();
         */
            .filter(e -> !e.getKey().equals(missingActiveID))
            } catch (final BrokenBarrierException | InterruptedException e) {
        });
        // now update all knowledge of all shards
        assertEquals(expectedIds.size(), groupStats.size());
            .mapToLong(RetentionLease::timestamp)
            .stream()
        );
            activeLocalCheckpoints.entrySet()
    }
            equalTo(newPrimary.checkpoints.get(oldPrimary.shardAllocationId).inSync)
        );
            initialClusterStateVersion,
        tracker.updateFromClusterManager(1L, Set.of(primaryId.getId()), routingTable(Set.of(replicaId), primaryId));
        final IndexShardRoutingTable relocatingRoutingTable = new IndexShardRoutingTable.Builder(shardId).addShard(
    }
            indexSettings,
                tracker.getRetentionLeases().leases().stream().map(RetentionLease::id).collect(Collectors.toSet()),
        final ReplicationTracker tracker = newTracker(AllocationId.newInitializing());
        assertTrue(initializingIds.stream().noneMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
        Settings settings = Settings.builder()
                routingTable(initializingToStay.keySet(), primaryId)
                clusterState.apply(oldPrimary);
                )
        return allocationIds.stream().map(AllocationId::getId).collect(Collectors.toSet());
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            case 0: {
        tracker.startReplicationLagTimers(initialCheckpoint);
    }
        expectThrows(IllegalStateException.class, () -> tracker.initiateTracking(extraId.getId()));
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, primaryId));
            markAsTrackingAndInSyncQuietly(tracker, extraId.getId(), randomInt((int) minLocalCheckpointAfterUpdates), false);
        addPeerRecoveryRetentionLease(tracker, newSyncingAllocationId);
        barrier.await();
            }
        barrier.await();
            } catch (final BrokenBarrierException | InterruptedException e) {
        tracker.initiateTracking(extraId.getId());
        // using a different length than we have been using above ensures that we can not collide with a previous allocation ID
            Collections.singleton(active.getId()),
        );
        allocations.putAll(initializingToStay);
        }
 */
                tracker.initiateTracking(initializing.getId());
        final AllocationId replicaId = AllocationId.newInitializing();
        assertTrue(newActiveAllocationIds.stream().allMatch(a -> tracker.getTrackedLocalCheckpointForShard(a.getId()).inSync));
     * {@link ReplicationTracker#checkpoints}. Creating the missing peer-recovery retention leases during a remote
        thread.start();
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, primaryId));
            initializingIds.stream()
        final String primaryNode = nodeIdFromAllocationId(primaryId);
        final ReplicationTracker tracker = new ReplicationTracker(
        final AllocationId primaryId = active.keySet().iterator().next();
                // activate new primary
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, primaryId));
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
        );
        StreamInput streamInput = output.bytes().streamInput();
        assertAsTimePasses.accept(() -> {
        final Consumer<Runnable> assertAsTimePasses = assertion -> {
        assertThat(tracker.getGlobalCheckpoint(), equalTo(UNASSIGNED_SEQ_NO));
        if (missingActiveID.equals(primaryId) == false) {
            );
        final Thread thread = new Thread(() -> {
        assertFalse(oldPrimary.relocated);
        markAsTrackingAndInSyncQuietly(tracker, recoveringReplicaId.getId(), NO_OPS_PERFORMED);
        Map<AllocationId, Long> initializingWithCheckpoints = randomAllocationsWithLocalCheckpoints(0, 5);
    public void testMissingInSyncIdsDoesNotPreventAdvanceWithRemoteTranslogEnabled() {
        for (AllocationId initializingId : initializingIds) {
import org.apache.lucene.util.Version;
            tracker.getReplicationGroup().getInSyncAllocationIds(),
        active.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
            routingTable(Collections.emptySet(), startedAllocationIds, primaryId)
        clusterState.apply(oldPrimary);
                randomLocalCheckpointUpdate(oldPrimary);
        tracker.activatePrimaryMode(globalCheckpoint);
        for (AllocationId initializingId : initializingIds) {
        Collections.shuffle(allocations, random());
        final AllocationId primaryId = active.iterator().next();
        assertFalse(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));
        final Set<AllocationId> initializingIds = activeAndInitializingAllocationIds.v2();
        assertThat(tracker.getReplicationGroup().getRoutingTable(), equalTo(routingTable));
            tracker.updateLocalCheckpoint(initializing.getId(), nextActiveLocalCheckpoint);
        assertReplicationLagTimersStartAfterRecoveryCompletes(true);
            }
            assertFalse(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));
        );
        assertTrue(
            1L,
        final ReplicationTracker tracker = newTracker(primaryId, settings, true);
        for (String id : expectedIds) {
            allocations.forEach((aid, localCP) -> updateLocalCheckpoint(tracker, aid.getId(), localCP));
 * this file be licensed under the Apache-2.0 license or a
            0L,
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
        tracker.updateFromClusterManager(randomNonNegativeLong(), ids(active.keySet()), routingTable(initializing.keySet(), primaryId));
        Thread.sleep(100);
    }
 * KIND, either express or implied.  See the License for the
    }
                .stream()
    }
                barrier.await();
            1L,
            assertTrue(tracker.pendingInSync.contains(newSyncingAllocationId.getId()));
    }
        assertEquals(1, replicationStats.size());
            globalCheckpoint,
                // activate new primary
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, "true")
        ReplicationTracker newPrimary = new ReplicationTracker(
                throw new RuntimeException(e);
            allocations.putAll(activeToBeRemoved);
            }
        barrier.await();
        final Set<AllocationId> removingActiveAllocationIds = new HashSet<>(randomSubsetOf(activeAllocationIds));
 * specific language governing permissions and limitations
        tracker.setLatestReplicationCheckpoint(checkpoint);
            onUpdate,
            randomNonNegativeLong(),
            .getReplicationTargets()
        Collections.shuffle(allocations, random());
            // Also leases are renewed before reaching half the expiry time
        if (randomBoolean()) {
            }
        );
        );
            Map.of("segment_1", segment_1, "segment_2", segment_2, "segment_3", segment_3),
                    "should not have removed lease for " + replicaId + " in " + retentionLeases,
        initializing.forEach(aId -> allocations.put(aId, allocations.get(aId) + 1 + randomInt(4)));
        tracker.setLatestReplicationCheckpoint(startedCheckpoint);
            .forEach(
        final Function<AllocationId, RetentionLease> retentionLeaseFromAllocationId = allocationId -> new RetentionLease(
    }
        assertTrue(oldPrimary.primaryMode);
            // synchronize with the waiting thread to mark that it is complete
    }
import java.util.function.Function;
        final AllocationId replicaId = initializing.iterator().next();
            Codec.getDefault().getName(),
        for (SegmentReplicationShardStats shardStat : groupStats) {
            0,
        tracker.updateGlobalCheckpointForShard(advancingAllocationId.getId(), newGlobalCheckpoint);
        assertThat(leaseIds, hasItem(ReplicationTracker.getPeerRecoveryRetentionLeaseId(primaryShard)));
            Map.of("segment_1", segment_1),
            final RetentionLeases retentionLeases = tracker.getRetentionLeases();
            primaryContext = oldPrimary.startRelocationHandoff(newPrimary.shardAllocationId);
        assertThat(tracker.getReplicationGroup().getReplicationTargets().size(), equalTo(1));
        assertThat(
    private static Set<AllocationId> randomAllocationIdsExcludingExistingIds(
                randomMarkInSync(oldPrimary, newPrimary);
            .collect(Collectors.toSet());
        for (SegmentReplicationShardStats shardStat : groupStats) {
        final AllocationId missingActiveID = randomFrom(active.keySet());
    public void testInSyncIdsAreRemovedIfNotValidatedByClusterManagerWithRemoteTranslogEnabled() {
            randomNonNegativeLong(),
            }
                barrier.await();
        }
            aId -> markAsTrackingAndInSyncQuietly(tracker, aId.getId(), NO_OPS_PERFORMED)
        tracker.updateFromClusterManager(initialClusterStateVersion, ids(active), routingTable(initializing, primaryId));
        // increment checkpoints
        addPeerRecoveryRetentionLease(oldPrimary, newPrimary.shardAllocationId);
                newPrimary.activateWithPrimaryContext(primaryContext);
        updateLocalCheckpoint(tracker, extraId.getId(), minLocalCheckpointAfterUpdates + 1 + randomInt(4));
import java.util.concurrent.atomic.AtomicLong;
        // using a different length than we have been using above ensures that we can not collide with a previous allocation ID
