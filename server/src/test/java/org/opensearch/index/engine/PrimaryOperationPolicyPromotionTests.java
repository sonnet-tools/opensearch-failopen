            }
            assertEquals(
 * been a replica for a while never exercises the policy its engine resolved at construction. These tests
            pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);  
                );  
            );
import org.opensearch.index.mapper.SourceToParse;
            assertTrue("starting the recovered primary must activate primary mode", primary.isPrimaryMode());  
            assertUpstreamSeqNoAppliedVerbatim(primary, primaryEngine.get(), 100L);
    }
            assertSame(DefaultPrimaryOperationPolicy.INSTANCE, replica.getPrimaryOperationPolicy());
                DefaultPrimaryOperationPolicy.INSTANCE,  
        final IndexShard replica = newReplicaWithPluginPolicy(pluginPolicy);  
    }
     * directly to the shard's engine. Such an operation is only valid under the pre-assigned policy; the
                primary.getPrimaryOperationPolicy()
     */
 * The OpenSearch Contributors require contributions made to  
    private void promote(IndexShard replica) throws Exception {
    /**  
            indexOnReplicaLeavingGapAtZero(replica);
        );
 * compatible open source license.
            assertSame(
     * handoff, through {@link IndexShard#activateWithPrimaryContext}, without a primary term bump or an
import org.opensearch.index.shard.IndexShardTestUtils;
import org.opensearch.cluster.routing.ShardRoutingHelper;
            replica,
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);  
        } finally {  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
            closeShards(primary);  
            assertTrue("the target must have been handed primary mode", target.isPrimaryMode());
        expectThrows(AlreadyClosedException.class, shard::getPrimaryOperationPolicy);
        assertEquals("the upstream seq no. must be applied verbatim by the primary", upstreamSeqNo, result.getSeqNo());  
        final Engine.Index upstreamOp = new Engine.Index(
import org.opensearch.cluster.routing.ShardRouting;  
import org.opensearch.common.lease.Releasable;
                "a refresh must be able to switch back",
     * {@link IndexShard#updateShardState}. Neither a primary term bump nor an engine reset happens in
            1L,
                "a replica never refreshes, so its engine must still hold the construction-time policy",
     * policy the plugin starts resolving during that window must be the one the started primary uses.  
            p -> newShard(  
                primary.getPrimaryOperationPolicy()  
        } finally {
                    IndexShardTestUtils.getFakeDiscoNode(primary.routingEntry().currentNodeId()),  
                    super.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, listener);
    }
        final IndexShard shard = newStartedShard(true);
        final PlainActionFuture<Releasable> permit = new PlainActionFuture<>();
            }, true, true);  
    /**
            assertSame(
            assertTrue(recoverFromStore(primary));
     */
            assertEquals("the refresh must release its operation block", 0, primary.getActiveOperationsCount());
                indexDoc(source, "_doc", Integer.toString(i));  
            for (int i = 0; i < docs; i++) {
     */  
        }
    public void testPolicyAccessorOnClosedShardThrows() throws Exception {
                "store",  
     * upstream authority has not replicated to it yet.
                    config.toBuilder().primaryOperationPolicySupplier(pluginPolicy::get).build()
            return engine;
            new IndexShardRoutingTable.Builder(replicaRouting.shardId()).addShard(replicaRouting).build()  
     */
                "the gap must not be filled under a policy whose seq no. space is owned upstream",
     * engine reset. A policy the plugin starts resolving while the recovery is still running must be the
                1,  
            closeShards(replica);
            promote(replica);
    /**
            assertSame(  
                primary.getPrimaryOperationPolicy()  
    public void testPromotionUnderDefaultPolicyStillFillsGaps() throws Exception {  
     * between, and translog replay or a large restore can keep the shard recovering for a long time, so a
        final ParsedDocument doc = shard.mapperService()
     * Promotes the shard and waits for the primary term bump to complete, which is what runs the gap
    public void testPromotionPicksUpPolicyInstalledAfterEngineWasBuilt() throws Exception {
    }  
        return newStartedShard(
import org.opensearch.index.mapper.Uid;  
            .documentMapper()  
                new EngineBackedIndexerFactory(  
            "entering primary mode must install the policy the plugin resolves now",
            closeShards(replica);
    }
        final IndexShard primary = newShard(true, Settings.EMPTY, new EngineBackedIndexerFactory(config -> {
            assertSame(DefaultPrimaryOperationPolicy.INSTANCE, primary.getPrimaryOperationPolicy());  
        }
            // the plugin starts overriding the policy while the primary is still recovering; nothing rebuilds
     * A primary recovering from its store builds its engine at the start of recovery and enters primary
        permit.get().close();
        IndexShard target = null;
                replica.getOperationPrimaryTerm(),
 * SPDX-License-Identifier: Apache-2.0
    }  
                    config -> new InternalEngine(config.toBuilder().primaryOperationPolicySupplier(pluginPolicy::get).build())
     */
                    null
                "promotion must install the policy the plugin resolves now",  
            assertSame(
public class PrimaryOperationPolicyPromotionTests extends IndexShardTestCase {
                replica.getPrimaryOperationPolicy()
            target = newShard(source.routingEntry().getTargetRelocatingShard(), Settings.EMPTY, new EngineBackedIndexerFactory(config -> {  
     * plugin can tell whether the engine has picked the change up yet.  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            Engine.Operation.Origin.PRIMARY,  
                    primary.routingEntry(),
import org.opensearch.core.action.ActionListener;
    /** The unchanged case: with no plugin override the promoted primary fills its gaps as it always has. */
    }  
            pluginPolicy.set(DefaultPrimaryOperationPolicy.INSTANCE);
     * one the relocated primary uses. Segment replication is not covered here because its relocation  
import org.apache.lucene.index.Term;
                DefaultPrimaryOperationPolicy.INSTANCE,
     * Stands in for a plugin whose {@code getPrimaryOperationPolicy} answer follows an updatable index
    /**
     * The promotion path fills sequence-number gaps, so whether the gap at 0 survives promotion tells us
            doc,
            assertEquals(2L, replica.getLocalCheckpoint());
            primary
    }
 */  
import java.io.IOException;  
    public void testRelocationHandoffPicksUpPolicyInstalledAfterEngineWasBuilt() throws Exception {  
        promoteReplica(  
            closeShards(primary);
import org.opensearch.index.mapper.IdFieldMapper;  
            }));  
        return newStartedShardWithPluginPolicy(pluginPolicy, false);  
            );
            );  
            final InternalEngine engine = new InternalEngine(config.toBuilder().primaryOperationPolicySupplier(pluginPolicy::get).build());  
        try {  
     * A plugin whose policy is keyed off an updatable setting, and that has nothing else to rebuild when  
}  
            primary.refreshPrimaryOperationPolicy();  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
            final int docs = randomIntBetween(0, 10);
                new RecoveryState(
                )
            .parse(new SourceToParse(shard.shardId().getIndexName(), "upstream", new BytesArray("{}"), MediaTypeRegistry.JSON));
            // the plugin starts overriding the policy while this shard is still a replica, so nothing
import org.opensearch.index.VersionType;
import org.opensearch.indices.recovery.RecoveryTarget;  
     * that setting changes, can refresh a started primary in place rather than resetting its engine. The
                DefaultPrimaryOperationPolicy.INSTANCE,
        try {  
                false,
                p,
import java.util.Collections;
        );
     * Asserts the shard is serving primary operations under the pre-assigned policy, first directly and
        final AtomicReference<InternalEngine> primaryEngine = new AtomicReference<>();
    public void testStartedPrimaryCanBeRefreshedInPlace() throws Exception {
        } finally {  
            final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
import org.opensearch.index.shard.IndexShardTestCase;  
            upstreamSeqNo,
     * which policy the engine used. A policy installed after the engine was built must be the one that  
    private IndexShard newReplicaWithPluginPolicy(AtomicReference<PrimaryOperationPolicy> pluginPolicy) throws IOException {
    private void assertUpstreamSeqNoAppliedVerbatim(IndexShard shard, InternalEngine engine, long upstreamSeqNo) throws IOException {
            pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);  
                    );  
                )
import java.util.concurrent.atomic.AtomicReference;  
            updateMappings(target, source.indexSettings().getIndexMetadata());
     * filling this test observes.
                targetEngine.set(engine);
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),  
        }
            assertUpstreamSeqNoAppliedVerbatim(target, targetEngine.get(), docs + 100L);
                replica.getLocalCheckpoint()
            );
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            false,  
            indexOnReplicaLeavingGapAtZero(replica);
            updateRoutingEntry(primary, ShardRoutingHelper.moveToStarted(primary.routingEntry()));
     * mode only when the cluster manager marks it started, through the same-term branch of  
        try {
 * engine, and would therefore keep serving that construction-time policy as a primary.  
     */  
import org.opensearch.common.settings.Settings;  
                    // the plugin starts overriding the policy while the target is still recovering; nothing
            );  
        } finally {
            assertNotNull("the engine must be open before the policy changes", primaryEngine.get());
            primaryEngine.set(engine);
/*  
package org.opensearch.index.engine;
        final Engine.IndexResult result = engine.index(upstreamOp);
                FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
            );
            closeShards(source, target);  
 */
                @Override
        }
            recoverReplica(target, source, (shard, sourceNode) -> new RecoveryTarget(shard, sourceNode, recoveryListener, threadPool) {  
                SequenceNumbers.NO_OPS_PERFORMED,  
        }));  
 * cover the document replication promotion path, which unlike segment replication does not rebuild the
import org.opensearch.index.shard.IndexShard;
                        DefaultPrimaryOperationPolicy.INSTANCE,
    private IndexShard newStartedShardWithPluginPolicy(AtomicReference<PrimaryOperationPolicy> pluginPolicy, boolean primary)  
            final AtomicReference<InternalEngine> targetEngine = new AtomicReference<>();
import java.util.UUID;
        try {
            promote(replica);  
        replica.acquirePrimaryOperationPermit(permit, ThreadPool.Names.GENERIC, "");  
                    assertSame(
        assertSame(  
        assertEquals(2L, replica.seqNoStats().getMaxSeqNo());
    private void indexOnReplicaLeavingGapAtZero(IndexShard replica) throws IOException {  
                    assertNotNull("the target engine must be open before the policy changes", targetEngine.get());
    public void testStartingRecoveredPrimaryPicksUpPolicyInstalledAfterEngineWasBuilt() throws Exception {
        );  
     * then behaviorally: applies a primary-origin operation carrying an upstream-assigned sequence number  
                Settings.EMPTY,
        }
            primary.markAsRecovering(
                "a recovering primary must still hold the construction-time policy until it is started",  
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                    pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
            assertSame(  
            assertFalse("the shard must not be in primary mode until it is started", primary.isPrimaryMode());  
                UUID.randomUUID().toString(),  
import org.opensearch.action.support.PlainActionFuture;
        for (long seqNo : new long[] { 1L, 2L }) {
            System.nanoTime(),
import org.opensearch.action.index.IndexRequest;  
        assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
 *
            );
                public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {
            VersionType.EXTERNAL,
                final InternalEngine engine = new InternalEngine(
                    // rebuilds the target's engine between here and the handoff  
            // its engine between here and the shard being started  
        );
            shard.getOperationPrimaryTerm(),  
            );  
                "the shard must report the engine's snapshot, not the config's live resolution",
        final IndexShard primary = newStartedShardWithPluginPolicy(pluginPolicy, true);
import org.opensearch.indices.recovery.RecoveryState;
     * A primary relocation target builds its engine at the start of peer recovery and becomes a primary at  
        final IndexShard source = newStartedShard(true);
     * shard-level accessor must report the engine's snapshot, not the config's live resolution, so the
     * handoff rebuilds the engine via {@link IndexShard#resetToWriteableEngine()}.
    /**
            ),  
            replica.applyIndexOperationOnReplica(
 * A {@link PrimaryOperationPolicy} is only consulted for primary-origin operations, so a shard that has  
                        targetEngine.get().getPrimaryOperationPolicy()
            IndexShardTestCase.updateRoutingEntry(source, source.routingEntry().relocate(randomAlphaOfLength(10), -1));
                return engine;
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        try {
     * setting: the policy behind the reference can be changed after the engine has been built.  
import org.opensearch.index.mapper.ParsedDocument;
                }
    /** Leaves a gap at sequence number 0 by applying operations 1 and 2 only. */
        }
        assertEquals(SequenceNumbers.NO_OPS_PERFORMED, replica.getLocalCheckpoint());  
    }  
     * default policy the engine resolved when it was built rejects it, so whether it succeeds confirms
        final IndexShard replica = newReplicaWithPluginPolicy(pluginPolicy);
                        "the recovering target must still hold the construction-time policy before the handoff",  
    }
                    // the target's engine is open by now, so the switch below happens after it resolved its policy  
 * this file be licensed under the Apache-2.0 license or a
            pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
        throws IOException {
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
    /**
import org.opensearch.threadpool.ThreadPool;
     */
    }
            primary.refreshPrimaryOperationPolicy();
     * which policy the shard is actually applying.  
            Collections.singleton(replicaRouting.allocationId().getId()),
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.core.common.bytes.BytesArray;
            FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
            // rebuilds its engine
/**
                DefaultPrimaryOperationPolicy.INSTANCE,
                replica.getPrimaryOperationPolicy()
import org.apache.lucene.store.AlreadyClosedException;
        } finally {  
        final ShardRouting replicaRouting = replica.routingEntry();
                seqNo,
     * applies, otherwise this shard would record no-ops that can collide with sequence numbers the
    /**
                new SourceToParse(replica.shardId().getIndexName(), Long.toString(seqNo), new BytesArray("{}"), MediaTypeRegistry.JSON)  
            assertTrue(source.isRelocatedPrimary());
        closeShards(shard);  
            assertSame(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE, primary.getPrimaryOperationPolicy());
            shard.getPrimaryOperationPolicy()  
