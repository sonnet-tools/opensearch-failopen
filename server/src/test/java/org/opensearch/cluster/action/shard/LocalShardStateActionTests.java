        ShardRouting unassigned = shardTable(failed).primaryShard();
        // so failing it as if it were one added an unassigned primary beside the relocating one.
    public void testOnlyTheRoutingTableChanges() {
        // As RoutingNodes#failShard does: the target is a replica recovering like any other, and has no need of the source.
        ClusterState started = started(state, initializing, state.metadata().index(INDEX).primaryTerm(0));
            ActionListener.wrap(r -> responded.set(true), e -> fail(e.toString())),
        IndexMetadata after = failed.metadata().index(INDEX);
        ClusterState withoutIndex = ClusterState.builder(state).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
        ClusterState twice = started(once, initializing, state.metadata().index(INDEX).primaryTerm(0));
        action.localShardFailed(primary, "engine failure", null, ActionListener.wrap(r -> fail("must not succeed"), failure::set), state);
import static org.mockito.Mockito.doAnswer;
        assertNotNull("the listener must be told the failure was not applied", failure.get());
        assertEquals(RecoverySource.Type.EXISTING_STORE, unassigned.recoverySource().getType());
    }
        assertEquals(source.relocatingNodeId(), replica.currentNodeId());
import org.opensearch.cluster.service.ClusterApplier;
    public void testAFailureForAnIndexNoLongerInTheStateChangesNothing() {
    /** Through the public API, so that these tests describe what the action does rather than how. */
        ClusterState promoted = ClusterState.builder(state)
        when(clusterService.getClusterSettings()).thenReturn(
 * SPDX-License-Identifier: Apache-2.0
                listener.onFailure(invocation.getArgument(0), applyFailure);
        assertEquals(before.inSyncAllocationIds(0), after.inSyncAllocationIds(0));
                    .put(IndexMetadata.builder(state.metadata().index(INDEX)).primaryTerm(0, term + 1))
        assertTrue(shard.primaryShard().unassigned());
            .routingTable(
    }
        assertEquals(UnassignedInfo.Reason.ALLOCATION_FAILED, info.getReason());
        LocalShardStateAction action = action(state, applied, null);
        assertEquals("no target left recovering from it", 0, shard.getAllInitializingShards().size());
    public void testAnInitializingCopyIsStarted() {
 * compatible open source license.
        failed.getRoutingNodes();
        assertEquals(relocating.currentNodeId(), replica.currentNodeId());
    public void testAnInitializingCopyThatFailedBeforeCountsItsEarlierFailures() {
    private static IndexShardRoutingTable shardTable(ClusterState state) {
        assertTrue(shard.primaryShard().started());
        ).initialize(replica.currentNodeId(), null, -1);
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED);
        return ClusterState.builder(state)
    public void testLocalShardFailedAppliesTheFailureAndCompletesTheListener() {
    private static ClusterState withCopy(ClusterState state, ShardRouting existing, ShardRouting replacement) {
            .build();
        ShardRouting primary = shardTable(state).primaryShard();
        ClusterState failed = LocalShardStateAction.failShard(state, primary, "engine failure", new RuntimeException("boom"));
        ShardRouting replica = shardTable(failed).replicaShards().get(0);
        assertTrue("a started replica is not recovering from it", shard.replicaShards().contains(started));
        when(clusterService.getClusterApplierService()).thenReturn(applier);
        ShardRouting source = shardTable(state).primaryShard();
        // The order IndicesClusterStateService can produce: recovery done and the started message queued, then the shard
        assertNull(unassigned.currentNodeId());
    }
import static org.mockito.ArgumentMatchers.any;
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
        // Stale: the copy that failed has been replaced, and its successor must not be failed in its place.
import org.opensearch.cluster.routing.ShardRoutingState;
            ClusterApplier.ClusterApplyListener listener = invocation.getArgument(2);
    public void testAFailedPrimaryPromotesNothing() {
        IndexShardRoutingTable shard = new IndexShardRoutingTable.Builder(shardTable(state)).removeShard(existing)
public class LocalShardStateActionTests extends OpenSearchTestCase {
    }
        ClusterState state = state(INDEX, true, ShardRoutingState.INITIALIZING);
        assertTrue(target.isRelocationTarget());
            @SuppressWarnings("unchecked")
        ShardRouting initializing = shardTable(state).primaryShard();
        IndexShardRoutingTable shard = shardTable(failed);
        ClusterState once = started(state, initializing, state.metadata().index(INDEX).primaryTerm(0));
import org.opensearch.core.action.ActionListener;
    public void testLocalShardFailedPassesOnAFailureToApply() {
    }
        assertEquals(shardTable(failed), shardTable(started));
        ShardRouting recovering = shard.replicaShards().stream().filter(copy -> copy.started() == false).findFirst().orElseThrow();
        ClusterState started = withCopy(state, initializing, initializing.moveToStarted());
        ShardRouting initializing = shardTable(state).primaryShard();
            return null;
import org.opensearch.cluster.routing.RecoverySource;
import static org.mockito.ArgumentMatchers.anyString;
    public void testAFailedRelocatingReplicaLeavesItsTargetRecoveringFromThePrimary() {
        ClusterState failed = LocalShardStateAction.failShard(state, source, "engine failure", null);
        assertEquals(UnassignedInfo.Reason.PRIMARY_FAILED, recovering.unassignedInfo().getReason());
        return state.routingTable().index(INDEX).shard(0);
        ShardRouting primary = shardTable(state).primaryShard();
        assertEquals(Set.of("some-other-node", replica.currentNodeId()), info.getFailedNodeIds());
        // The target is what the target node's IndicesClusterStateService sees and fails. It is not an entry in the table,
        assertTrue(shard.primaryShard().unassigned());
                applied.set(update.apply(state));
        ShardRouting initializing = shardTable(state).primaryShard();
        // RoutingNodes refuses a copy that is peer recovering from an unassigned primary ("shard is peer recovering but
            state
        ShardRouting replica = shardTable(state).replicaShards().get(0);
        assertEquals("nothing is left unassigned: " + shard, 1, shard.size());
import static org.mockito.Mockito.when;
/*
    }
        // fails and its failure is applied first. Removing by equality removed nothing and added a started copy beside the
        ShardRouting target = shardTable(state).getByAllocationId(source.allocationId().getRelocationId());
        // unassigned one.
                System.currentTimeMillis(),
        assertNotNull("a failure must be applied to the local cluster state", applied.get());
import org.opensearch.common.settings.Settings;
        ClusterState failed = LocalShardStateAction.failShard(state, initializing, "engine failure", null);
        // Primary terms and in-sync allocation ids belong to whatever builds the local cluster state.
        assertEquals(source.allocationId().getId(), shard.primaryShard().allocationId().getId());
        AtomicReference<ClusterState> applied = new AtomicReference<>();
    public void testTheCopyIsFoundByAllocationIdNotByEquality() {
    public void testAStartedRelocationTargetReplacesItsSource() {
        ShardRouting relocating = shardTable(state).replicaShards().get(0);
                UnassignedInfo.Reason.ALLOCATION_FAILED,
        ClusterState started = started(failed, initializing, failed.metadata().index(INDEX).primaryTerm(0));
package org.opensearch.cluster.action.shard;
        ShardRouting primary = shardTable(state).primaryShard();
import org.opensearch.common.settings.ClusterSettings;
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.RELOCATING);
        AtomicReference<ClusterState> applied = new AtomicReference<>();
                listener.onSuccess(invocation.getArgument(0));
            }
        UnassignedInfo info = unassigned.unassignedInfo();
    public void testAFailedPrimaryFailsTheReplicasRecoveringFromIt() {
            .addShard(replacement)
        ClusterState state = state(INDEX, true, ShardRoutingState.RELOCATING);
            new UnassignedInfo(
            .initialize(primary.currentNodeId(), null, -1);
        ClusterState failed = LocalShardStateAction.failShard(started, initializing, "failed", null);
        ShardRouting successor = primary.moveToUnassigned(new UnassignedInfo(UnassignedInfo.Reason.ALLOCATION_FAILED, "earlier"))
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
                "earlier",
        IndexMetadata before = state.metadata().index(INDEX);
        ShardRouting replica = shardTable(failed).replicaShards().get(0);
        failed.getRoutingNodes();
        assertEquals(1, info.getNumFailedAllocations());
        // are for whatever builds the local cluster state to decide, not for this action to infer.
        UnassignedInfo info = shardTable(failed).replicaShards().get(0).unassignedInfo();
    // A routing table holds a relocation as one entry: the RELOCATING source, from which the INITIALIZING target is
            .metadata(
        assertEquals(shard.toString(), 1, shard.size());
        ShardRouting primary = shardTable(state).primaryShard();
        // The copy failed while initializing, and the state has since marked it started. Removing by equality with the
    }
        ClusterState state = state(INDEX, true, ShardRoutingState.RELOCATING);
import java.util.function.Function;
import org.opensearch.cluster.service.ClusterApplierService;
    private static ClusterState started(ClusterState state, ShardRouting shard, long primaryTerm) {
        ShardRouting initializing = shardTable(state).primaryShard();
    }
 *
            } else {
        assertEquals("the started replica is untouched, and still a replica", replica, shardTable(failed).replicaShards().get(0));
        ClusterState started = started(promoted, initializing, term);
        assertNotEquals(primary.allocationId().getId(), shardTable(replaced).primaryShard().allocationId().getId());
        assertTrue(unassigned.unassigned());
        assertTrue(shardTable(failed).primaryShard().unassigned());
            "engine failure",
        assertTrue("back where it was, and started: " + replica, replica.started());
import static org.mockito.Mockito.mock;
        return new LocalShardStateAction(clusterService, mock(TransportService.class), null, null, null);
        LocalShardStateAction action = action(state, new AtomicReference<>(), new IllegalStateException("applier closed"));
        ClusterState failed = LocalShardStateAction.failShard(state, target, "recovery failed", null);
        ShardRouting initializing = shardTable(state).primaryShard();
            .build();
    }
                Set.of("some-other-node")
    public void testAFailedPrimaryCancelsAReplicaRelocationRecoveringFromIt() {
        assertNull(shard.primaryShard().relocatingNodeId());
        IndexShardRoutingTable shard = shardTable(failed);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        ClusterState failed = LocalShardStateAction.failShard(state, failedBefore, "recovery failed", null);
    }
    public void testAFailureForAnAllocationNoLongerInTheStateChangesNothing() {
        // The target is derived from the relocating source rather than an entry of its own, so starting it means replacing
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED);
        );
        assertEquals(source.relocatingNodeId(), shard.primaryShard().currentNodeId());
        assertSame(replaced, LocalShardStateAction.failShard(replaced, primary, "stale", null));
    private static final String INDEX = "test-index";
    }
    }
        action(state, applied, null).shardStarted(shard, primaryTerm, "test", ActionListener.wrap(r -> {}, e -> fail(e.toString())), state);
            Function<ClusterState, ClusterState> update = invocation.getArgument(1);
        assertEquals(before.primaryTerm(0), after.primaryTerm(0));
            )
        ShardRouting replica = shardTable(state).replicaShards().get(0);
}
 */
        ClusterState state = state(INDEX, true, ShardRoutingState.INITIALIZING);
        AtomicReference<Exception> failure = new AtomicReference<>();
        ClusterApplierService applier = mock(ClusterApplierService.class);
        assertNull("no longer a relocation target", replica.relocatingNodeId());
        action.localShardFailed(
        ClusterState failed = LocalShardStateAction.failShard(state, shardTable(state).primaryShard(), "engine failure", null);
    }
        ClusterState state = state(INDEX, true, ShardRoutingState.INITIALIZING);
        assertNotNull("an update must be submitted", applied.get());
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        return applied.get();
            .build();
        assertEquals("the other copy is untouched", shardTable(state).replicaShards().get(0), shardTable(failed).replicaShards().get(0));
import org.opensearch.cluster.service.ClusterService;
    }
import org.opensearch.transport.TransportService;
        assertTrue(shardTable(started).primaryShard().started());
        assertSame(withoutIndex, LocalShardStateAction.failShard(withoutIndex, primary, "deleted", null));
        ClusterState failed = LocalShardStateAction.failShard(state, shardTable(state).primaryShard(), "engine failure", null);
        assertTrue(shardTable(applied.get()).primaryShard().unassigned());
            primary,
        assertEquals(shard.toString(), 1, shard.size());
        state = withCopy(state, replica, failedBefore);
                null,
    }
    public void testAStartedMessageForACopyThatFailedSinceChangesNothing() {
    // ---------------------------------------------------------------- shardStarted
        // routing that failed would remove nothing, and leave the copy stuck.
    }
        assertTrue(shard.primaryShard().started());
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED);
        assertTrue(shardTable(failed).primaryShard().unassigned());
                RoutingTable.builder(state.routingTable())
        assertTrue(shardTable(started).primaryShard().initializing());
    }
        ClusterState state = state(INDEX, true, ShardRoutingState.RELOCATING);
        when(clusterService.getSettings()).thenReturn(Settings.EMPTY);
        assertTrue(replica.toString(), replica.initializing());
        ShardRouting primary = shardTable(state).primaryShard();
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
        ShardRouting failedBefore = replica.moveToUnassigned(
        assertEquals(relocating.allocationId().getId(), replica.allocationId().getId());
                false,
        ShardRouting target = shardTable(state).getByAllocationId(source.allocationId().getRelocationId());
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        assertEquals(source.currentNodeId(), shard.primaryShard().currentNodeId());
    // derived (IndexShardRoutingTable lists the target among its assigned shards, and getByAllocationId finds it).
        ShardRouting started = shardTable(state).replicaShards().stream().filter(ShardRouting::started).findFirst().orElseThrow();
    // So either end can be the copy that failed, and only the source is there to change.
        ShardRouting primary = shardTable(state).primaryShard();
import java.util.concurrent.atomic.AtomicReference;
import org.opensearch.cluster.routing.RoutingTable;
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED);
                System.nanoTime(),
import org.opensearch.cluster.routing.UnassignedInfo;
import org.opensearch.cluster.routing.ShardRouting;
    public void testAFailedStartedPrimaryBecomesUnassigned() {
        AtomicReference<Boolean> responded = new AtomicReference<>();
        assertEquals(3, info.getNumFailedAllocations());
                org.opensearch.cluster.metadata.Metadata.builder(state.metadata())
        long term = state.metadata().index(INDEX).primaryTerm(0);
import java.util.Set;
        assertTrue(info.getMessage(), info.getMessage().contains("engine failure"));
        // the source. Removing the target by equality removed nothing and left the relocation in place beside it.
            )
        assertEquals("boom", info.getFailure().getMessage());
        ShardRouting source = shardTable(state).primaryShard();
    }
        );
                2,
    public void testAStartedMessageFromAnEarlierPrimaryTermChangesNothing() {
        // Where this departs from RoutingNodes#failShard on purpose. Promotion comes with a new primary term, and both
        doAnswer(invocation -> {
            if (applyFailure != null) {
    private static LocalShardStateAction action(ClusterState state, AtomicReference<ClusterState> applied, Exception applyFailure) {
import org.opensearch.test.OpenSearchTestCase;
        ClusterState failed = LocalShardStateAction.failShard(state, shardTable(state).primaryShard(), "engine failure", null);
    }
        ClusterState state = state(INDEX, true, ShardRoutingState.INITIALIZING);
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
    }
        assertEquals("the listener must be completed", Boolean.TRUE, responded.get());
        ShardRouting source = shardTable(state).replicaShards().get(0);
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED);
            null,
        ClusterState state = state(INDEX, true, ShardRoutingState.INITIALIZING);
 * this file be licensed under the Apache-2.0 license or a
        }).when(applier).updateClusterState(anyString(), any(), any());
        ClusterState replaced = withCopy(state, primary, successor);
        assertEquals(source.getTargetRelocatingShard().allocationId().getId(), replica.allocationId().getId());
    }
        ShardRouting source = shardTable(state).primaryShard();
            )
    }
        ClusterState failed = LocalShardStateAction.failShard(state, primary, "engine failure", null);
    public void testAFailedRelocatingPrimaryIsUnassignedAndTheRelocationWithIt() {
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        ClusterService clusterService = mock(ClusterService.class);
        assertEquals(target.allocationId().getId(), shard.primaryShard().allocationId().getId());
        assertTrue(source.relocating());
import org.opensearch.cluster.ClusterState;
        ClusterState started = started(state, target, state.metadata().index(INDEX).primaryTerm(0));
import org.opensearch.cluster.metadata.IndexMetadata;
                    .add(org.opensearch.cluster.routing.IndexRoutingTable.builder(shard.shardId().getIndex()).addIndexShard(shard))
    }
                    .build()
        assertEquals(shardTable(once), shardTable(twice));
    public void testAFailedRelocationTargetCancelsTheRelocation() {
    public void testAStartedMessageForACopyAlreadyStartedChangesNothing() {
        assertEquals("applier closed", failure.get().getMessage());
        IndexShardRoutingTable shard = shardTable(failed);
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.RELOCATING);
        assertEquals(initializing.allocationId().getId(), shardTable(started).primaryShard().allocationId().getId());
        ClusterState failed = LocalShardStateAction.failShard(state, source, "engine failure", null);
        assertTrue(recovering.unassigned());
 * The OpenSearch Contributors require contributions made to
        // primary is unassigned"), and it is built from every applied state.
        IndexShardRoutingTable shard = shardTable(started);
