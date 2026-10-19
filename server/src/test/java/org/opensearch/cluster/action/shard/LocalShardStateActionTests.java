    }
        assertEquals("the other copy is untouched", shardTable(state).replicaShards().get(0), shardTable(failed).replicaShards().get(0));  
            ActionListener.wrap(r -> responded.set(true), e -> fail(e.toString())),
    }
import org.opensearch.cluster.routing.ShardRoutingState;
        assertEquals(before.inSyncAllocationIds(0), after.inSyncAllocationIds(0));
        ClusterApplierService applier = mock(ClusterApplierService.class);  
        // primary is unassigned"), and it is built from every applied state.  
    // A routing table holds a relocation as one entry: the RELOCATING source, from which the INITIALIZING target is
    private static IndexShardRoutingTable shardTable(ClusterState state) {
        ShardRouting initializing = shardTable(state).primaryShard();  
        ClusterState state = state(INDEX, true, ShardRoutingState.INITIALIZING);  
import static org.mockito.Mockito.mock;
    }  
        // so failing it as if it were one added an unassigned primary beside the relocating one.
        assertEquals(UnassignedInfo.Reason.PRIMARY_FAILED, recovering.unassignedInfo().getReason());
import org.opensearch.transport.TransportService;
        IndexShardRoutingTable shard = shardTable(failed);
        ClusterState state = state(INDEX, true, ShardRoutingState.RELOCATING);  
                2,  
            primary,
        assertSame(replaced, LocalShardStateAction.failShard(replaced, primary, "stale", null));
            .routingTable(
                false,  
        ShardRouting source = shardTable(state).primaryShard();
    }
/*  
            .addShard(replacement)
        // RoutingNodes refuses a copy that is peer recovering from an unassigned primary ("shard is peer recovering but
        ShardRouting source = shardTable(state).primaryShard();
            } else {
        // Primary terms and in-sync allocation ids belong to whatever builds the local cluster state.
        ClusterState state = state(INDEX, true, ShardRoutingState.INITIALIZING);
        assertEquals(source.relocatingNodeId(), shard.primaryShard().currentNodeId());
}
        // fails and its failure is applied first. Removing by equality removed nothing and added a started copy beside the  
        return applied.get();
        assertTrue(shardTable(started).primaryShard().initializing());
    }
        ClusterState started = started(state, target, state.metadata().index(INDEX).primaryTerm(0));
    public void testTheCopyIsFoundByAllocationIdNotByEquality() {
        assertTrue("back where it was, and started: " + replica, replica.started());
        assertEquals(RecoverySource.Type.EXISTING_STORE, unassigned.recoverySource().getType());  
        return ClusterState.builder(state)  
import org.opensearch.core.action.ActionListener;
        assertSame(withoutIndex, LocalShardStateAction.failShard(withoutIndex, primary, "deleted", null));
            "engine failure",  
    public void testAnInitializingCopyIsStarted() {  
        ShardRouting replica = shardTable(failed).replicaShards().get(0);
    public void testLocalShardFailedAppliesTheFailureAndCompletesTheListener() {  
            new UnassignedInfo(
        assertTrue(source.relocating());  
        assertEquals(shardTable(failed), shardTable(started));
                UnassignedInfo.Reason.ALLOCATION_FAILED,  
        assertEquals("the started replica is untouched, and still a replica", replica, shardTable(failed).replicaShards().get(0));
        assertEquals("nothing is left unassigned: " + shard, 1, shard.size());
    private static LocalShardStateAction action(ClusterState state, AtomicReference<ClusterState> applied, Exception applyFailure) {
        );  
            .build();
        assertEquals("applier closed", failure.get().getMessage());
        assertNull(unassigned.currentNodeId());
        IndexShardRoutingTable shard = shardTable(failed);
        ShardRouting replica = shardTable(failed).replicaShards().get(0);
        ClusterState failed = LocalShardStateAction.failShard(state, source, "engine failure", null);
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED);
        // are for whatever builds the local cluster state to decide, not for this action to infer.  
import static org.mockito.Mockito.when;  
import static org.mockito.Mockito.doAnswer;
            )  
        ClusterState failed = LocalShardStateAction.failShard(started, initializing, "failed", null);  
import java.util.concurrent.atomic.AtomicReference;
        assertTrue(shard.primaryShard().started());
        assertEquals(shard.toString(), 1, shard.size());  
            Function<ClusterState, ClusterState> update = invocation.getArgument(1);  
        state = withCopy(state, replica, failedBefore);
        ShardRouting recovering = shard.replicaShards().stream().filter(copy -> copy.started() == false).findFirst().orElseThrow();  
        ShardRouting primary = shardTable(state).primaryShard();  
import org.opensearch.common.settings.Settings;
        assertEquals("the listener must be completed", Boolean.TRUE, responded.get());
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.RELOCATING);
    }
                org.opensearch.cluster.metadata.Metadata.builder(state.metadata())  
        // the source. Removing the target by equality removed nothing and left the relocation in place beside it.  
        ClusterState state = state(INDEX, true, ShardRoutingState.INITIALIZING);
        ClusterState failed = LocalShardStateAction.failShard(state, target, "recovery failed", null);
        ClusterState failed = LocalShardStateAction.failShard(state, shardTable(state).primaryShard(), "engine failure", null);
    // ---------------------------------------------------------------- shardStarted
    public void testAFailureForAnIndexNoLongerInTheStateChangesNothing() {
        AtomicReference<ClusterState> applied = new AtomicReference<>();  
 * SPDX-License-Identifier: Apache-2.0
        ShardRouting target = shardTable(state).getByAllocationId(source.allocationId().getRelocationId());
        ClusterState state = state(INDEX, true, ShardRoutingState.INITIALIZING);
    public void testLocalShardFailedPassesOnAFailureToApply() {
        return state.routingTable().index(INDEX).shard(0);
        assertEquals(before.primaryTerm(0), after.primaryTerm(0));  
import org.opensearch.cluster.service.ClusterService;
        ShardRouting replica = shardTable(state).replicaShards().get(0);  
        assertEquals(shard.toString(), 1, shard.size());
import org.opensearch.cluster.service.ClusterApplierService;
        assertEquals(relocating.currentNodeId(), replica.currentNodeId());  
        assertNotEquals(primary.allocationId().getId(), shardTable(replaced).primaryShard().allocationId().getId());  
    public void testAFailedRelocationTargetCancelsTheRelocation() {
        failed.getRoutingNodes();  
    }
        assertTrue(replica.toString(), replica.initializing());
        ClusterState state = state(INDEX, true, ShardRoutingState.RELOCATING);
            }
        ShardRouting initializing = shardTable(state).primaryShard();
    }
                applied.set(update.apply(state));
        ClusterState failed = LocalShardStateAction.failShard(state, shardTable(state).primaryShard(), "engine failure", null);
        ClusterState started = started(promoted, initializing, term);
        ClusterState failed = LocalShardStateAction.failShard(state, shardTable(state).primaryShard(), "engine failure", null);
                    .add(org.opensearch.cluster.routing.IndexRoutingTable.builder(shard.shardId().getIndex()).addIndexShard(shard))  
import org.opensearch.cluster.metadata.IndexMetadata;
            .build();  
        ShardRouting source = shardTable(state).primaryShard();  
        ShardRouting source = shardTable(state).replicaShards().get(0);
        ShardRouting initializing = shardTable(state).primaryShard();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import static org.mockito.ArgumentMatchers.any;
        ClusterState failed = LocalShardStateAction.failShard(state, failedBefore, "recovery failed", null);
    public void testAStartedMessageForACopyAlreadyStartedChangesNothing() {
        ShardRouting failedBefore = replica.moveToUnassigned(
        assertEquals(3, info.getNumFailedAllocations());
        ClusterState promoted = ClusterState.builder(state)
import org.opensearch.cluster.service.ClusterApplier;  
        assertTrue(target.isRelocationTarget());
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        }).when(applier).updateClusterState(anyString(), any(), any());  
        return new LocalShardStateAction(clusterService, mock(TransportService.class), null, null, null);
        ClusterState twice = started(once, initializing, state.metadata().index(INDEX).primaryTerm(0));
                "earlier",
    }
        ShardRouting initializing = shardTable(state).primaryShard();
            @SuppressWarnings("unchecked")
        ShardRouting successor = primary.moveToUnassigned(new UnassignedInfo(UnassignedInfo.Reason.ALLOCATION_FAILED, "earlier"))  
        ClusterState started = withCopy(state, initializing, initializing.moveToStarted());
    private static ClusterState withCopy(ClusterState state, ShardRouting existing, ShardRouting replacement) {
        ShardRouting primary = shardTable(state).primaryShard();
import java.util.function.Function;
        assertTrue(shard.primaryShard().started());  
    private static final String INDEX = "test-index";
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED);
 * this file be licensed under the Apache-2.0 license or a
        ClusterState failed = LocalShardStateAction.failShard(state, initializing, "engine failure", null);
 */  
            )
        ClusterState once = started(state, initializing, state.metadata().index(INDEX).primaryTerm(0));
        assertEquals("no target left recovering from it", 0, shard.getAllInitializingShards().size());
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(shardTable(once), shardTable(twice));  
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
    private static ClusterState started(ClusterState state, ShardRouting shard, long primaryTerm) {  
        assertTrue(recovering.unassigned());
    }
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
public class LocalShardStateActionTests extends OpenSearchTestCase {
    public void testAStartedMessageFromAnEarlierPrimaryTermChangesNothing() {  
        when(clusterService.getClusterSettings()).thenReturn(
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED);
        AtomicReference<ClusterState> applied = new AtomicReference<>();
    }  
        when(clusterService.getSettings()).thenReturn(Settings.EMPTY);  
        // The order IndicesClusterStateService can produce: recovery done and the started message queued, then the shard
            if (applyFailure != null) {
        assertEquals("boom", info.getFailure().getMessage());
import org.opensearch.cluster.routing.UnassignedInfo;
                    .put(IndexMetadata.builder(state.metadata().index(INDEX)).primaryTerm(0, term + 1))
        LocalShardStateAction action = action(state, new AtomicReference<>(), new IllegalStateException("applier closed"));
        // Where this departs from RoutingNodes#failShard on purpose. Promotion comes with a new primary term, and both
        ClusterState failed = LocalShardStateAction.failShard(state, primary, "engine failure", null);
        when(clusterService.getClusterApplierService()).thenReturn(applier);
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED);  
        ShardRouting primary = shardTable(state).primaryShard();
        failed.getRoutingNodes();  
        );
        // The target is what the target node's IndicesClusterStateService sees and fails. It is not an entry in the table,  
        assertEquals(initializing.allocationId().getId(), shardTable(started).primaryShard().allocationId().getId());
    }  
        IndexShardRoutingTable shard = new IndexShardRoutingTable.Builder(shardTable(state)).removeShard(existing)  
        ClusterState state = state(INDEX, true, ShardRoutingState.RELOCATING);
    /** Through the public API, so that these tests describe what the action does rather than how. */
        ClusterState started = started(state, initializing, state.metadata().index(INDEX).primaryTerm(0));
import java.util.Set;  
        assertEquals(source.allocationId().getId(), shard.primaryShard().allocationId().getId());
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.RELOCATING);
        ClusterState state = state(INDEX, true, ShardRoutingState.INITIALIZING);
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        action.localShardFailed(primary, "engine failure", null, ActionListener.wrap(r -> fail("must not succeed"), failure::set), state);
        ShardRouting unassigned = shardTable(failed).primaryShard();  
    }  
    public void testAFailureForAnAllocationNoLongerInTheStateChangesNothing() {
    public void testAFailedPrimaryCancelsAReplicaRelocationRecoveringFromIt() {  
        assertNotNull("the listener must be told the failure was not applied", failure.get());
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
import org.opensearch.cluster.routing.RoutingTable;
                RoutingTable.builder(state.routingTable())
        assertTrue(unassigned.unassigned());
                System.currentTimeMillis(),
        assertNull("no longer a relocation target", replica.relocatingNodeId());  
        ClusterService clusterService = mock(ClusterService.class);
                listener.onSuccess(invocation.getArgument(0));  
    // So either end can be the copy that failed, and only the source is there to change.  
            .metadata(
    public void testAStartedRelocationTargetReplacesItsSource() {
    public void testAFailedPrimaryFailsTheReplicasRecoveringFromIt() {
        ClusterState failed = LocalShardStateAction.failShard(state, source, "engine failure", null);  
        ShardRouting initializing = shardTable(state).primaryShard();  
                    .build()
        // The copy failed while initializing, and the state has since marked it started. Removing by equality with the  
                System.nanoTime(),
            )
        AtomicReference<Boolean> responded = new AtomicReference<>();
    public void testOnlyTheRoutingTableChanges() {  
        assertTrue("a started replica is not recovering from it", shard.replicaShards().contains(started));  
        assertEquals(target.allocationId().getId(), shard.primaryShard().allocationId().getId());  
        assertNull(shard.primaryShard().relocatingNodeId());
        assertEquals(source.currentNodeId(), shard.primaryShard().currentNodeId());  
        LocalShardStateAction action = action(state, applied, null);
        ShardRouting started = shardTable(state).replicaShards().stream().filter(ShardRouting::started).findFirst().orElseThrow();
    }  
        ClusterState failed = LocalShardStateAction.failShard(state, primary, "engine failure", new RuntimeException("boom"));
        assertEquals(UnassignedInfo.Reason.ALLOCATION_FAILED, info.getReason());
    // derived (IndexShardRoutingTable lists the target among its assigned shards, and getByAllocationId finds it).
        action(state, applied, null).shardStarted(shard, primaryTerm, "test", ActionListener.wrap(r -> {}, e -> fail(e.toString())), state);
    public void testAStartedMessageForACopyThatFailedSinceChangesNothing() {
import org.opensearch.cluster.ClusterState;
                Set.of("some-other-node")
 *
    }
        assertEquals(Set.of("some-other-node", replica.currentNodeId()), info.getFailedNodeIds());
            return null;
        assertNotNull("an update must be submitted", applied.get());  
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
    }
        IndexShardRoutingTable shard = shardTable(started);
            state  
                null,
        // routing that failed would remove nothing, and leave the copy stuck.
        ClusterState withoutIndex = ClusterState.builder(state).routingTable(RoutingTable.EMPTY_ROUTING_TABLE).build();
        // As RoutingNodes#failShard does: the target is a replica recovering like any other, and has no need of the source.  
                listener.onFailure(invocation.getArgument(0), applyFailure);  
        assertTrue(shardTable(applied.get()).primaryShard().unassigned());
        assertEquals(source.relocatingNodeId(), replica.currentNodeId());
    public void testAFailedStartedPrimaryBecomesUnassigned() {  
    }  
        assertNotNull("a failure must be applied to the local cluster state", applied.get());  
        IndexShardRoutingTable shard = shardTable(failed);  
 * compatible open source license.
    public void testAFailedPrimaryPromotesNothing() {
        assertEquals(source.getTargetRelocatingShard().allocationId().getId(), replica.allocationId().getId());
        assertTrue(shard.primaryShard().unassigned());
        doAnswer(invocation -> {
        action.localShardFailed(
        assertTrue(shardTable(failed).primaryShard().unassigned());
        assertTrue(info.getMessage(), info.getMessage().contains("engine failure"));
    }
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
            .initialize(primary.currentNodeId(), null, -1);
    public void testAFailedRelocatingReplicaLeavesItsTargetRecoveringFromThePrimary() {
        assertEquals(relocating.allocationId().getId(), replica.allocationId().getId());
        UnassignedInfo info = unassigned.unassignedInfo();
    }
        ShardRouting primary = shardTable(state).primaryShard();
        ).initialize(replica.currentNodeId(), null, -1);
    }  
import org.opensearch.common.settings.ClusterSettings;  
        IndexMetadata before = state.metadata().index(INDEX);
        ClusterState state = state(INDEX, true, ShardRoutingState.STARTED);  
    public void testAFailedRelocatingPrimaryIsUnassignedAndTheRelocationWithIt() {
        assertTrue(shardTable(started).primaryShard().started());  
        ShardRouting relocating = shardTable(state).replicaShards().get(0);
        assertTrue(shard.primaryShard().unassigned());
    }  
        ShardRouting primary = shardTable(state).primaryShard();
        ShardRouting primary = shardTable(state).primaryShard();
import org.opensearch.cluster.routing.RecoverySource;
import static org.mockito.ArgumentMatchers.anyString;  
        ClusterState replaced = withCopy(state, primary, successor);
import org.opensearch.cluster.routing.ShardRouting;  
        // The target is derived from the relocating source rather than an entry of its own, so starting it means replacing
        IndexMetadata after = failed.metadata().index(INDEX);
            .build();  
        assertEquals(1, info.getNumFailedAllocations());  
 * The OpenSearch Contributors require contributions made to  
        ShardRouting replica = shardTable(state).replicaShards().get(0);
            null,
        ClusterState started = started(failed, initializing, failed.metadata().index(INDEX).primaryTerm(0));  
package org.opensearch.cluster.action.shard;
        assertTrue(shardTable(failed).primaryShard().unassigned());  
        UnassignedInfo info = shardTable(failed).replicaShards().get(0).unassignedInfo();  
        ShardRouting target = shardTable(state).getByAllocationId(source.allocationId().getRelocationId());  
        AtomicReference<Exception> failure = new AtomicReference<>();  
    public void testAnInitializingCopyThatFailedBeforeCountsItsEarlierFailures() {
    }  
        // unassigned one.
        long term = state.metadata().index(INDEX).primaryTerm(0);  
            ClusterApplier.ClusterApplyListener listener = invocation.getArgument(2);
    }  
        // Stale: the copy that failed has been replaced, and its successor must not be failed in its place.  
