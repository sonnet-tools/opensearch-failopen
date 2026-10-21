            primaryEngine.set(engine);
        } finally {
    }
            upstreamSeqNo,
            assertUpstreamSeqNoAppliedVerbatim(primary, primaryEngine.get(), 100L);
                indexDoc(source, "_doc", Integer.toString(i));
            assertSame(
        assertEquals(2L, replica.seqNoStats().getMaxSeqNo());
            assertTrue("starting the recovered primary must activate primary mode", primary.isPrimaryMode());
                "promotion must install the policy the plugin resolves now",
    /**
                seqNo,
            final InternalEngine engine = new InternalEngine(config.toBuilder().primaryOperationPolicySupplier(pluginPolicy::get).build());
            // rebuilds its engine
            System.nanoTime(),
    private void promote(IndexShard replica) throws Exception {
                replica.getLocalCheckpoint()
     * which policy the shard is actually applying.
            final int docs = randomIntBetween(0, 10);
            }, true, true);
        assertEquals("the upstream seq no. must be applied verbatim by the primary", upstreamSeqNo, result.getSeqNo());
                    // rebuilds the target's engine between here and the handoff
            indexOnReplicaLeavingGapAtZero(replica);
     * handoff, through {@link IndexShard#activateWithPrimaryContext}, without a primary term bump or an
    public void testPromotionUnderDefaultPolicyStillFillsGaps() throws Exception {
    }
            assertEquals(
        }
            new Term(IdFieldMapper.NAME, Uid.encodeId(doc.id())),
            new IndexShardRoutingTable.Builder(replicaRouting.shardId()).addShard(replicaRouting).build()
import org.opensearch.common.lease.Releasable;
        } finally {
    /** The unchanged case: with no plugin override the promoted primary fills its gaps as it always has. */
import org.opensearch.action.index.IndexRequest;
            assertEquals(2L, replica.getLocalCheckpoint());
import org.opensearch.index.mapper.Uid;
 * cover the document replication promotion path, which unlike segment replication does not rebuild the
                    // the target's engine is open by now, so the switch below happens after it resolved its policy
        );
     * Asserts the shard is serving primary operations under the pre-assigned policy, first directly and
 */
        assertEquals(SequenceNumbers.NO_OPS_PERFORMED, replica.getLocalCheckpoint());
import org.apache.lucene.index.Term;
import java.util.UUID;
 * been a replica for a while never exercises the policy its engine resolved at construction. These tests
                1,
            assertSame(
        replica.acquirePrimaryOperationPermit(permit, ThreadPool.Names.GENERIC, "");
import java.io.IOException;
        final ParsedDocument doc = shard.mapperService()
    /** Leaves a gap at sequence number 0 by applying operations 1 and 2 only. */
                    IndexShardTestUtils.getFakeDiscoNode(primary.routingEntry().currentNodeId()),
                    // the plugin starts overriding the policy while the target is still recovering; nothing
            replica,
                primary.getPrimaryOperationPolicy()
        );
    public void testPolicyAccessorOnClosedShardThrows() throws Exception {
            }));
            );
    private IndexShard newStartedShardWithPluginPolicy(AtomicReference<PrimaryOperationPolicy> pluginPolicy, boolean primary)
                DefaultPrimaryOperationPolicy.INSTANCE,
                SequenceNumbers.NO_OPS_PERFORMED,
        }
            p -> newShard(
                }
            IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        promoteReplica(
    }
import org.opensearch.core.common.bytes.BytesArray;
                public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {
        assertSame(
        );
 * compatible open source license.
            VersionType.EXTERNAL,
                    null
        closeShards(shard);
        return newStartedShardWithPluginPolicy(pluginPolicy, false);
     */
public class PrimaryOperationPolicyPromotionTests extends IndexShardTestCase {
                "a refresh must be able to switch back",
        IndexShard target = null;
                FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
        }
            );
        for (long seqNo : new long[] { 1L, 2L }) {
                "a replica never refreshes, so its engine must still hold the construction-time policy",
}
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
        try {
    }
        final PlainActionFuture<Releasable> permit = new PlainActionFuture<>();
     */
                DefaultPrimaryOperationPolicy.INSTANCE,
                new RecoveryState(
            false,
                new SourceToParse(replica.shardId().getIndexName(), Long.toString(seqNo), new BytesArray("{}"), MediaTypeRegistry.JSON)
    }
 */
import org.apache.lucene.store.AlreadyClosedException;
        try {
    /**
     * applies, otherwise this shard would record no-ops that can collide with sequence numbers the
            "entering primary mode must install the policy the plugin resolves now",
            closeShards(primary);
            replica.applyIndexOperationOnReplica(
        } finally {
                @Override
    /**
                    pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
    public void testRelocationHandoffPicksUpPolicyInstalledAfterEngineWasBuilt() throws Exception {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertTrue("the target must have been handed primary mode", target.isPrimaryMode());
     * A primary recovering from its store builds its engine at the start of recovery and enters primary
     */
                )
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
     */
    public void testStartedPrimaryCanBeRefreshedInPlace() throws Exception {
            );
import org.opensearch.common.settings.Settings;
 * engine, and would therefore keep serving that construction-time policy as a primary.
        );
    }
            assertSame(
    /**
     * mode only when the cluster manager marks it started, through the same-term branch of
            IndexShardTestCase.updateRoutingEntry(source, source.routingEntry().relocate(randomAlphaOfLength(10), -1));
        try {
     * upstream authority has not replicated to it yet.
        final IndexShard replica = newReplicaWithPluginPolicy(pluginPolicy);
            primary
     * one the relocated primary uses. Segment replication is not covered here because its relocation
            updateRoutingEntry(primary, ShardRoutingHelper.moveToStarted(primary.routingEntry()));
            primary.markAsRecovering(
            1L,
import java.util.Collections;
                )
     * directly to the shard's engine. Such an operation is only valid under the pre-assigned policy; the
import org.opensearch.index.VersionType;
package org.opensearch.index.engine;
    }
                        "the recovering target must still hold the construction-time policy before the handoff",
            updateMappings(target, source.indexSettings().getIndexMetadata());
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
     * handoff rebuilds the engine via {@link IndexShard#resetToWriteableEngine()}.
            final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
            assertSame(DefaultPrimaryOperationPolicy.INSTANCE, primary.getPrimaryOperationPolicy());
            // the plugin starts overriding the policy while this shard is still a replica, so nothing
            closeShards(source, target);
            return engine;
            assertSame(
        final IndexShard replica = newReplicaWithPluginPolicy(pluginPolicy);
        try {
     * setting: the policy behind the reference can be changed after the engine has been built.
     * default policy the engine resolved when it was built rejects it, so whether it succeeds confirms
import org.opensearch.cluster.routing.ShardRouting;
                "store",
                false,
import org.opensearch.index.seqno.SequenceNumbers;
                    config.toBuilder().primaryOperationPolicySupplier(pluginPolicy::get).build()
                );
    public void testStartingRecoveredPrimaryPicksUpPolicyInstalledAfterEngineWasBuilt() throws Exception {
            closeShards(primary);
    }
     * plugin can tell whether the engine has picked the change up yet.
            shard.getOperationPrimaryTerm(),
     * which policy the engine used. A policy installed after the engine was built must be the one that
            promote(replica);
            assertTrue(recoverFromStore(primary));
                return engine;
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM
        throws IOException {
import org.opensearch.cluster.routing.ShardRoutingHelper;
        final IndexShard primary = newStartedShardWithPluginPolicy(pluginPolicy, true);
/**
    /**
                    config -> new InternalEngine(config.toBuilder().primaryOperationPolicySupplier(pluginPolicy::get).build())
                        DefaultPrimaryOperationPolicy.INSTANCE,
            promote(replica);
                    super.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, listener);
import org.opensearch.index.shard.IndexShardTestUtils;
            primary.refreshPrimaryOperationPolicy();
     */
import org.opensearch.index.mapper.IdFieldMapper;
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
        expectThrows(AlreadyClosedException.class, shard::getPrimaryOperationPolicy);
import org.opensearch.action.support.PlainActionFuture;
            primary.refreshPrimaryOperationPolicy();
            .parse(new SourceToParse(shard.shardId().getIndexName(), "upstream", new BytesArray("{}"), MediaTypeRegistry.JSON));
            assertTrue(source.isRelocatedPrimary());
     * A primary relocation target builds its engine at the start of peer recovery and becomes a primary at
            recoverReplica(target, source, (shard, sourceNode) -> new RecoveryTarget(shard, sourceNode, recoveryListener, threadPool) {
                targetEngine.set(engine);
     * then behaviorally: applies a primary-origin operation carrying an upstream-assigned sequence number
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                new EngineBackedIndexerFactory(
     * {@link IndexShard#updateShardState}. Neither a primary term bump nor an engine reset happens in
                replica.getOperationPrimaryTerm(),
            assertNotNull("the engine must be open before the policy changes", primaryEngine.get());
            ),
    public void testPromotionPicksUpPolicyInstalledAfterEngineWasBuilt() throws Exception {
import org.opensearch.indices.recovery.RecoveryTarget;
import org.opensearch.index.shard.IndexShard;
                primary.getPrimaryOperationPolicy()
        final AtomicReference<InternalEngine> primaryEngine = new AtomicReference<>();
                "the shard must report the engine's snapshot, not the config's live resolution",
            );
            // its engine between here and the shard being started
                DefaultPrimaryOperationPolicy.INSTANCE,
     */
        }
            assertEquals("the refresh must release its operation block", 0, primary.getActiveOperationsCount());
     * policy the plugin starts resolving during that window must be the one the started primary uses.
        } finally {
            }
                    assertSame(
                        targetEngine.get().getPrimaryOperationPolicy()
            // the plugin starts overriding the policy while the primary is still recovering; nothing rebuilds
import org.opensearch.indices.recovery.RecoveryState;
import org.opensearch.threadpool.ThreadPool;
            pluginPolicy.set(DefaultPrimaryOperationPolicy.INSTANCE);
import org.opensearch.index.mapper.ParsedDocument;
     * Promotes the shard and waits for the primary term bump to complete, which is what runs the gap
    /**
import org.opensearch.core.action.ActionListener;
     * A plugin whose policy is keyed off an updatable setting, and that has nothing else to rebuild when
import org.opensearch.index.shard.IndexShardTestCase;
    /**
                    primary.routingEntry(),
                UUID.randomUUID().toString(),
            doc,
            assertFalse("the shard must not be in primary mode until it is started", primary.isPrimaryMode());
                    assertNotNull("the target engine must be open before the policy changes", targetEngine.get());
     * between, and translog replay or a large restore can keep the shard recovering for a long time, so a
 *
    private void indexOnReplicaLeavingGapAtZero(IndexShard replica) throws IOException {
            );
        final IndexShard shard = newStartedShard(true);
    }
            .documentMapper()
            FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE,
        final IndexShard primary = newShard(true, Settings.EMPTY, new EngineBackedIndexerFactory(config -> {
     * engine reset. A policy the plugin starts resolving while the recovery is still running must be the
                "the gap must not be filled under a policy whose seq no. space is owned upstream",
    private IndexShard newReplicaWithPluginPolicy(AtomicReference<PrimaryOperationPolicy> pluginPolicy) throws IOException {
            Engine.Operation.Origin.PRIMARY,
            );
     * shard-level accessor must report the engine's snapshot, not the config's live resolution, so the
     * Stands in for a plugin whose {@code getPrimaryOperationPolicy} answer follows an updatable index
                replica.getPrimaryOperationPolicy()
            assertSame(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE, primary.getPrimaryOperationPolicy());
            indexOnReplicaLeavingGapAtZero(replica);
                primary.getPrimaryOperationPolicy()
            target = newShard(source.routingEntry().getTargetRelocatingShard(), Settings.EMPTY, new EngineBackedIndexerFactory(config -> {
            pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
    }
        }
import java.util.concurrent.atomic.AtomicReference;
 * The OpenSearch Contributors require contributions made to
                p,
            closeShards(replica);
        return newStartedShard(
                "a recovering primary must still hold the construction-time policy until it is started",
        assertEquals(Engine.Result.Type.SUCCESS, result.getResultType());
            shard.getPrimaryOperationPolicy()
            assertSame(DefaultPrimaryOperationPolicy.INSTANCE, replica.getPrimaryOperationPolicy());
        final IndexShard source = newStartedShard(true);
     * The promotion path fills sequence-number gaps, so whether the gap at 0 survives promotion tells us
        final ShardRouting replicaRouting = replica.routingEntry();
/*
        final AtomicReference<PrimaryOperationPolicy> pluginPolicy = new AtomicReference<>(DefaultPrimaryOperationPolicy.INSTANCE);
            closeShards(replica);
            Collections.singleton(replicaRouting.allocationId().getId()),
    private void assertUpstreamSeqNoAppliedVerbatim(IndexShard shard, InternalEngine engine, long upstreamSeqNo) throws IOException {
     * filling this test observes.
 * this file be licensed under the Apache-2.0 license or a
        }));
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        final Engine.Index upstreamOp = new Engine.Index(
                replica.getPrimaryOperationPolicy()
     */
                Settings.EMPTY,
            );
 * SPDX-License-Identifier: Apache-2.0
                    );
    }
            pluginPolicy.set(FakePreAssignedSeqNoPrimaryOperationPolicy.INSTANCE);
        } finally {
            for (int i = 0; i < docs; i++) {
import org.opensearch.index.mapper.SourceToParse;
            assertSame(
            assertUpstreamSeqNoAppliedVerbatim(target, targetEngine.get(), docs + 100L);
 * A {@link PrimaryOperationPolicy} is only consulted for primary-origin operations, so a shard that has
        }
                final InternalEngine engine = new InternalEngine(
            );
        permit.get().close();
            final AtomicReference<InternalEngine> targetEngine = new AtomicReference<>();
     * that setting changes, can refresh a started primary in place rather than resetting its engine. The
                DefaultPrimaryOperationPolicy.INSTANCE,
        try {
        final Engine.IndexResult result = engine.index(upstreamOp);
