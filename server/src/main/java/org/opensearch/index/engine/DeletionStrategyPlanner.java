                    // we don't need to index it again as stale op as it would create multiple documents for same seq no
        return plan;
        this.hasBeenProcessedBefore = hasBeenProcessedBefore;
            currentlyDeleted = versionValue.isDelete();
}
        final DeletionStrategy plan;
            // this can happen during recovery where older operations are sent from the translog that are already
    private final Supplier<Boolean> incrementVersionLookup;
                delete.getIfPrimaryTerm(),
    }
        }
        } else {
 */
            plan = DeletionStrategy.skipDueToVersionConflict(e, currentVersion, true);
        if (hasBeenProcessedBefore.test(delete)) {
            // See testRecoveryWithOutOfOrderDelete for an example of peer recovery
                    versionValue.term
            // question may have been deleted in an out of order op that is not replayed.
        ShardId shardId,
                    delete.getIfSeqNo(),
                    // as the preserved checkpoint may not have all the operations present in lucene
 * execution of delete operations on both primary and replica shards.
        } else if (delete.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
import java.util.function.Predicate;
        this.indexSettings = indexSettings;
        assert assertNonPrimaryOrigin(delete);
                SequenceNumbers.UNASSIGNED_SEQ_NO,
            final VersionConflictEngineException e = new VersionConflictEngineException(
                    delete.id(),
        Supplier<Boolean> incrementVersionLookup
            plan = DeletionStrategy.processButSkipEngine(false, delete.version());
        Predicate<Engine.Operation> hasBeenProcessedBefore,
        final DeletionStrategy plan;
import java.util.function.Supplier;
                    final long versionOfDeletion = delete.versionType().updateVersion(currentVersion, delete.version());
    public DeletionStrategy planOperationAsPrimary(Engine.Delete delete) throws IOException {
                    // For segrep based indices, we can't completely rely on localCheckpointTracker
            } else {
                    delete,
            } else {
    private final CheckedBiFunction<Engine.Operation, Boolean, VersionValue, IOException> docVersionSupplier;
                shardId,
        if (versionValue == null) {
 * compatible open source license.
        IndexSettings indexSettings,
                );
        if (delete.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO && currentlyDeleted) {
            currentlyDeleted = true;
            currentVersion = versionValue.version;
import org.opensearch.index.IndexSettings;
        BiFunction<Engine.Operation, Integer, Exception> tryAcquireInFlightDocs,
                } else {
/*
            boolean segRepEnabled = indexSettings.isSegRepEnabledOrRemoteNode();
                if (segRepEnabled) {
        // resolve operation from external to internal
        final VersionValue versionValue = docVersionSupplier.apply(delete, delete.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO);
        this.shardId = shardId;
                    currentlyDeleted
        final long currentVersion;
            // See testRecoverFromStoreWithOutOfOrderDelete for an example of local recovery
import java.io.IOException;
        this.docVersionSupplier = docVersionSupplier;
        return plan;
                    plan = DeletionStrategy.processNormally(currentlyDeleted, versionOfDeletion, 1);
 */
 * @opensearch.internal
import org.opensearch.index.seqno.SequenceNumbers;
    }
                final VersionConflictEngineException e = new VersionConflictEngineException(
 * The planner produces {@link DeletionStrategy} instances that guide the engine's
                plan = DeletionStrategy.processNormally(opVsLucene == OpVsEngineDocStatus.DOC_NOT_FOUND, delete.version(), 0);
            // part of the lucene commit (either from a peer recovery or a local translog)
            // the operation seq# was processed thus this operation was already put into lucene
import org.opensearch.common.CheckedFunction;
            } else if (delete.versionType().isVersionConflictForWrites(currentVersion, delete.version(), currentlyDeleted)) {
                    plan = DeletionStrategy.processButSkipEngine(false, delete.version());
    @Override
                );
 * The OpenSearch Contributors require contributions made to
                SequenceNumbers.UNASSIGNED_PRIMARY_TERM
            if (opVsLucene == OpVsEngineDocStatus.OP_STALE_OR_EQUAL) {
 * SPDX-License-Identifier: Apache-2.0
 *
            currentVersion = Versions.NOT_FOUND;
                delete.id(),
public class DeletionStrategyPlanner implements OperationStrategyPlanner<Engine.Delete, DeletionStrategy> {
                }
                final VersionConflictEngineException e = new VersionConflictEngineException(
    private final CheckedFunction<Engine.Operation, OpVsEngineDocStatus, IOException> opVsEngineDocStatusFunction;
        this.opVsEngineDocStatusFunction = opVsEngineDocStatusFunction;
                    plan = DeletionStrategy.processAsStaleOp(delete.version());
    private final ShardId shardId;
                if (reserveError != null) {
                    shardId,
 * this file be licensed under the Apache-2.0 license or a
                delete.getIfSeqNo(),
                final Exception reserveError = tryAcquireInFlightDocs.apply(delete, 1);
    public DeletionStrategyPlanner(
        assert delete.origin() == Engine.Operation.Origin.PRIMARY : "planing as primary but got " + delete.origin();
            }
        CheckedBiFunction<Engine.Operation, Boolean, VersionValue, IOException> docVersionSupplier,
    private final Predicate<Engine.Operation> hasBeenProcessedBefore;
 *
                    plan = DeletionStrategy.failAsTooManyDocs(reserveError);
/**
        final boolean currentlyDeleted;
        this.tryAcquireInFlightDocs = tryAcquireInFlightDocs;
import org.opensearch.common.CheckedBiFunction;
    private final BiFunction<Engine.Operation, Integer, Exception> tryAcquireInFlightDocs;
                    delete.getIfPrimaryTerm(),
                    currentVersion,
    private final IndexSettings indexSettings;
        }
        CheckedFunction<Engine.Operation, OpVsEngineDocStatus, IOException> opVsEngineDocStatusFunction,
                    versionValue.seqNo,
            }
    public DeletionStrategy planOperationAsNonPrimary(Engine.Delete delete) throws IOException {
    ) {
import org.opensearch.common.lucene.uid.Versions;
        } else {
                }
                    shardId,
 * Plans execution strategies for deletion operations.
                plan = DeletionStrategy.skipDueToVersionConflict(e, currentVersion, currentlyDeleted);
        this.incrementVersionLookup = incrementVersionLookup;
import org.opensearch.core.index.shard.ShardId;
package org.opensearch.index.engine;
                } else {
import java.util.function.BiFunction;
            );
    @Override
                plan = DeletionStrategy.skipDueToVersionConflict(e, currentVersion, currentlyDeleted);
    }
            && (versionValue.seqNo != delete.getIfSeqNo() || versionValue.term != delete.getIfPrimaryTerm())) {
            final OpVsEngineDocStatus opVsLucene = opVsEngineDocStatusFunction.apply(delete);
            // or due to concurrent indexing & recovery. For the former it is important to skip lucene as the operation in
        assert incrementVersionLookup.get();
