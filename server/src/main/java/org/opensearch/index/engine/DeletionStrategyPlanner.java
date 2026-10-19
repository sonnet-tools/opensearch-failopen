        final DeletionStrategy plan;  
                    plan = DeletionStrategy.processButSkipEngine(false, delete.version());  
        IndexSettings indexSettings,
import java.util.function.BiFunction;  
                );
                delete.id(),
            // or due to concurrent indexing & recovery. For the former it is important to skip lucene as the operation in
    private final Supplier<Boolean> incrementVersionLookup;
                    currentVersion,
    @Override  
                    // we don't need to index it again as stale op as it would create multiple documents for same seq no
                delete.getIfSeqNo(),
 * compatible open source license.
 * @opensearch.internal  
                final Exception reserveError = tryAcquireInFlightDocs.apply(delete, 1);
        return plan;
    private final ShardId shardId;
        }
 * execution of delete operations on both primary and replica shards.
 * The OpenSearch Contributors require contributions made to  
    @Override  
                    shardId,
import org.opensearch.common.CheckedBiFunction;
        } else {
        Predicate<Engine.Operation> hasBeenProcessedBefore,  
 *
        BiFunction<Engine.Operation, Integer, Exception> tryAcquireInFlightDocs,  
            boolean segRepEnabled = indexSettings.isSegRepEnabledOrRemoteNode();
                    delete.id(),  
        if (delete.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO && currentlyDeleted) {
        final VersionValue versionValue = docVersionSupplier.apply(delete, delete.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO);
        this.hasBeenProcessedBefore = hasBeenProcessedBefore;
                    plan = DeletionStrategy.failAsTooManyDocs(reserveError);  
                    final long versionOfDeletion = delete.versionType().updateVersion(currentVersion, delete.version());
                }
        CheckedBiFunction<Engine.Operation, Boolean, VersionValue, IOException> docVersionSupplier,
                shardId,  
                plan = DeletionStrategy.skipDueToVersionConflict(e, currentVersion, currentlyDeleted);  
import org.opensearch.index.IndexSettings;
            } else {  
        if (versionValue == null) {
}
        }
            plan = DeletionStrategy.skipDueToVersionConflict(e, currentVersion, true);
    private final Predicate<Engine.Operation> hasBeenProcessedBefore;  
    private final CheckedFunction<Engine.Operation, OpVsEngineDocStatus, IOException> opVsEngineDocStatusFunction;
                    versionValue.term
        return plan;  
        if (hasBeenProcessedBefore.test(delete)) {
/*  
    public DeletionStrategy planOperationAsPrimary(Engine.Delete delete) throws IOException {
            currentVersion = Versions.NOT_FOUND;  
import java.io.IOException;
                final VersionConflictEngineException e = new VersionConflictEngineException(
 */
                    plan = DeletionStrategy.processAsStaleOp(delete.version());
    private final CheckedBiFunction<Engine.Operation, Boolean, VersionValue, IOException> docVersionSupplier;
        this.indexSettings = indexSettings;  
 * this file be licensed under the Apache-2.0 license or a
        } else {
                    // For segrep based indices, we can't completely rely on localCheckpointTracker  
        this.shardId = shardId;
        CheckedFunction<Engine.Operation, OpVsEngineDocStatus, IOException> opVsEngineDocStatusFunction,
        assert delete.origin() == Engine.Operation.Origin.PRIMARY : "planing as primary but got " + delete.origin();
            } else {
            currentVersion = versionValue.version;  
                    shardId,  
            final OpVsEngineDocStatus opVsLucene = opVsEngineDocStatusFunction.apply(delete);  
import java.util.function.Supplier;
 * Plans execution strategies for deletion operations.
import org.opensearch.common.CheckedFunction;
public class DeletionStrategyPlanner implements OperationStrategyPlanner<Engine.Delete, DeletionStrategy> {
import org.opensearch.index.seqno.SequenceNumbers;  
 * SPDX-License-Identifier: Apache-2.0
    private final IndexSettings indexSettings;
                    delete,
                );
        this.tryAcquireInFlightDocs = tryAcquireInFlightDocs;
            }
                plan = DeletionStrategy.processNormally(opVsLucene == OpVsEngineDocStatus.DOC_NOT_FOUND, delete.version(), 0);
            // part of the lucene commit (either from a peer recovery or a local translog)
            );  
        final DeletionStrategy plan;  
                }  
        // resolve operation from external to internal  
            // See testRecoveryWithOutOfOrderDelete for an example of peer recovery
            // question may have been deleted in an out of order op that is not replayed.  
            if (opVsLucene == OpVsEngineDocStatus.OP_STALE_OR_EQUAL) {
            // See testRecoverFromStoreWithOutOfOrderDelete for an example of local recovery
        this.incrementVersionLookup = incrementVersionLookup;  
    private final BiFunction<Engine.Operation, Integer, Exception> tryAcquireInFlightDocs;  
                plan = DeletionStrategy.skipDueToVersionConflict(e, currentVersion, currentlyDeleted);
        final long currentVersion;  
import org.opensearch.common.lucene.uid.Versions;  
    }  
            // this can happen during recovery where older operations are sent from the translog that are already  
            plan = DeletionStrategy.processButSkipEngine(false, delete.version());  
            currentlyDeleted = true;
            currentlyDeleted = versionValue.isDelete();
            final VersionConflictEngineException e = new VersionConflictEngineException(
    public DeletionStrategyPlanner(  
                    currentlyDeleted  
                SequenceNumbers.UNASSIGNED_SEQ_NO,
        ShardId shardId,
            } else if (delete.versionType().isVersionConflictForWrites(currentVersion, delete.version(), currentlyDeleted)) {
                SequenceNumbers.UNASSIGNED_PRIMARY_TERM
                if (segRepEnabled) {
    }
import java.util.function.Predicate;
    }
            && (versionValue.seqNo != delete.getIfSeqNo() || versionValue.term != delete.getIfPrimaryTerm())) {  
/**
                final VersionConflictEngineException e = new VersionConflictEngineException(
                    delete.getIfPrimaryTerm(),
        assert incrementVersionLookup.get();
 *
                } else {
        this.opVsEngineDocStatusFunction = opVsEngineDocStatusFunction;  
 * The planner produces {@link DeletionStrategy} instances that guide the engine's  
                    versionValue.seqNo,  
                    // as the preserved checkpoint may not have all the operations present in lucene
        } else if (delete.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
                    delete.getIfSeqNo(),
                delete.getIfPrimaryTerm(),  
    ) {
        assert assertNonPrimaryOrigin(delete);
        final boolean currentlyDeleted;
                    plan = DeletionStrategy.processNormally(currentlyDeleted, versionOfDeletion, 1);  
                } else {
            }  
        this.docVersionSupplier = docVersionSupplier;
import org.opensearch.core.index.shard.ShardId;
    public DeletionStrategy planOperationAsNonPrimary(Engine.Delete delete) throws IOException {
                if (reserveError != null) {
        Supplier<Boolean> incrementVersionLookup
package org.opensearch.index.engine;
 */  
            // the operation seq# was processed thus this operation was already put into lucene
