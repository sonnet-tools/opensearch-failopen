            );
        assert startingSeqNo >= 0 : "startingSeqNo must be non negative. got: " + startingSeqNo;
            prepareTargetForTranslog(countNumberOfHistoryOperations(startingSeqNo), prepareEngineStep);
 * shard with translog backed by local store.
                        shard.removePeerRecoveryRetentionLease(
                // acquireSafeCatalogSnapshot reads segments_N eagerly (unlike the old  
import org.opensearch.index.shard.IndexShard;
 *
        super(shard, recoveryTarget, threadPool, request, fileChunkSizeInBytes, maxConcurrentFileChunks, maxConcurrentOperations);
        sendFileStep.whenComplete(r -> {  
import org.opensearch.index.translog.Translog;
        int maxConcurrentOperations
            // all the history we need is retained by the retention lock, obtained before calling shard.hasCompleteHistoryOperations()  
                // cluster turns RED instead of retrying recovery forever.  
        }, onFailure);
    ) {  
            final long maxSeenAutoIdTimestamp = shard.getMaxSeenAutoIdTimestamp();
import org.opensearch.transport.Transports;
import org.opensearch.index.engine.RecoveryEngineException;
            final long maxSeqNoOfUpdatesOrDeletes = shard.getMaxSeqNoOfUpdatesOrDeletes();
                final Releasable releaseStore = acquireStore(shard.store());
            // retention lease for some history that this primary already discarded, since we discard history when the global checkpoint
                        // If the target previously had a copy of this shard then a file-based recovery might move its global
        prepareEngineStep.whenComplete(prepareEngineTime -> {
import org.opensearch.core.action.ActionListener;  
        }, onFailure);
                final StepListener<ReplicationResponse> deleteRetentionLeaseStep = new StepListener<>();
                PEER_RECOVERY_NAME,
            final long endingSeqNo = shard.seqNoStats().getMaxSeqNo();  
        final long startingSeqNo;
            && isTargetSameHistory()  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        final StepListener<SendFileResult> sendFileStep = new StepListener<>();  
            RunUnderPrimaryPermit.run(
        }
                if (Lucene.isCorruptionException(e)) {
            // of retention leases, but this is not guaranteed: an earlier peer recovery from a different primary might have created a  
        IndexShard shard,
                onSendFileStepCompleteCatalogSnapshot(sendFileStep, wrappedSafeSnapshot, releaseStore);  
                endingSeqNo,
            logger.debug("sendFileStep completed");
                        // checkpoint backwards. We must therefore remove any existing retention lease so that we can create a  
                            new ThreadedActionListener<>(
 * SPDX-License-Identifier: Apache-2.0
    @Override
                                deleteRetentionLeaseStep,
                    shard.failShard("recovery", e);
            } catch (final Exception e) {
                startingSeqNo,  
                            )
            // always fall back to file-based ones, and only really presents a problem if this primary fails before things have settled  
                    logger.debug("deleteRetentionLeaseStep completed");
        RecoveryTargetHandler recoveryTarget,  
import org.opensearch.common.lease.Releasable;  
/*  
            logger.debug("prepareEngineStep completed");
import org.opensearch.index.seqno.RetentionLease;  
    public LocalStorePeerRecoverySourceHandler(
        final StepListener<SendSnapshotResult> sendSnapshotStep = new StepListener<>();
        int maxConcurrentFileChunks,
        } else {  
        final boolean isSequenceNumberBasedRecovery = request.startingSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
        ThreadPool threadPool,
        final Closeable retentionLock = shard.acquireHistoryRetentionLock();
 */
                    assert Transports.assertNotTransportThread(this + "[phase1]");
                true  
            // and before acquiring the safe commit we'll be using, so we can be certain that all operations after the safe commit's
}
                }  
                        logger.debug("no peer-recovery retention lease for " + request.targetAllocationId());
            // all the history we need is retained by an existing retention lease, so we do not need a separate retention lock
        finalizeStepAndCompleteFuture(startingSeqNo, sendSnapshotStep, sendFileStep, prepareEngineStep, onFailure);
            resources.add(phase2Snapshot);
                deleteRetentionLeaseStep.whenComplete(ignored -> {  
             * make sure to do this before sampling the max sequence number in the next step, to ensure that we send
            && ((retentionLeaseRef.get() == null && shard.useRetentionLeasesInPeerRecovery() == false)
/**
        // because when doing a rolling upgrade from earlier than 7.4 we may create some leases that are initially unsatisfied. It's
            }
        }  
 */  
                phase2Snapshot,
            final RetentionLeases retentionLeases = shard.getRetentionLeases();  
             * This means that any document indexed into the primary after this will be replicated to this replica as well  
import org.opensearch.common.concurrent.GatedCloseable;
            final long mappingVersionOnPrimary = shard.indexSettings().getIndexMetadata().getMappingVersion();
                resources.add(releaseStore);
                createRetentionLease(startingSeqNo, ActionListener.map(sendFileStep, ignored -> SendFileResult.EMPTY));
                shardId + " initiating tracking of " + request.targetAllocationId(),  
        // Also it's pretty cheap when soft deletes are enabled, and it'd be a disaster if we tried a sequence-number-based recovery
            assert Transports.assertNotTransportThread(this + "[prepareTargetForTranslog]");
        resources.add(retentionLock);  
                mappingVersionOnPrimary,  
            logger.trace("history is retained by retention lock");  
 * @opensearch.internal  
        waitForAssignmentPropagate(retentionLeaseRef);
            } else {  
            } catch (final Exception e) {  
                // IndexCommit path). If the segments file is corrupt, the exception is
                logger.trace("snapshot translog for recovery; current size is [{}]", countNumberOfHistoryOperations(startingSeqNo));
            retentionLock.close();  
                RunUnderPrimaryPermit.run(() -> {  
                sendSnapshotStep
        // possible there are other cases where we cannot satisfy all leases, because that's not a property we currently expect to hold.  
        int fileChunkSizeInBytes,  
            // conservatively copy all available operations. If we are using retention leases then "enough operations" is just the  
import org.opensearch.index.seqno.SequenceNumbers;  
            && shard.hasCompleteHistoryOperations(PEER_RECOVERY_NAME, request.startingSeqNo())
            startingSeqNo = request.startingSeqNo();  
        } else {
            // advances and not when creating a new safe commit. In any case this is a best-effort thing since future recoveries can
                false,
                () -> shard.initiateTracking(request.targetAllocationId()),
            final GatedCloseable<CatalogSnapshot> wrappedSafeSnapshot;
                }, shardId + " removing retention lease for [" + request.targetAllocationId() + "]", shard, cancellableThreads, logger);
            /*
            try {
            phase2(
            // we have to capture the max_seen_auto_id_timestamp and the max_seq_no_of_updates to make sure that these values
import java.io.IOException;
                startingSeqNo,  
                logger  
            // Try and copy enough operations to the recovering peer so that if it is promoted to primary then it has a chance of being
import org.opensearch.action.support.ThreadedActionListener;
        if (isSequenceNumberBasedRecovery) {
                // wrapped in an EngineException. Detect this and fail the shard so the
            );
import java.util.function.Consumer;  
                maxSeenAutoIdTimestamp,  
                cancellableThreads,
import org.opensearch.threadpool.ThreadPool;
            // down.
            logger.trace("performing file-based recovery followed by history replay starting at [{}]", startingSeqNo);  
                                ThreadPool.Names.GENERIC,
                }, onFailure);
             * all documents up to maxSeqNo in phase2.
import org.opensearch.indices.RunUnderPrimaryPermit;  
    }
            // able to recover other replicas using operations-based recoveries. If we are not using retention leases then we
        if (isSequenceNumberBasedRecovery && retentionLeaseRef.get() != null) {
            );
import org.opensearch.index.seqno.RetentionLeases;
        // without having a complete history.
    }  
            startingSeqNo = Long.parseLong(wrappedSafeSnapshot.get().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)) + 1L;
                    phase1(wrappedSafeSnapshot.get(), startingSeqNo, () -> estimateNumOps, sendFileStep, false);  
                resources.add(wrappedSafeSnapshot);
 * compatible open source license.
            logger.trace("history is retained by {}", retentionLeaseRef.get());
        final SetOnce<RetentionLease> retentionLeaseRef = new SetOnce<>();  
 * This handler is used for node-to-node peer recovery when the recovery target is a replica/ or a relocating primary  
import org.opensearch.common.lucene.Lucene;
            // at least as much history as anything else. The safe commit will often contain all the history retained by the current set
                                shard.getThreadPool(),  
            }  
            if (logger.isTraceEnabled()) {
                    try {
            // are at least as high as the corresponding values on the primary when any of these operations were executed on it.  
 *
            }
        // NB check hasCompleteHistoryOperations when computing isSequenceNumberBasedRecovery, even if there is a retention lease,
            final Translog.Snapshot phase2Snapshot = shard.newChangesSnapshot(
                            request.targetNode().getId(),  
                    }  
             */  
                                logger,
                        deleteRetentionLeaseStep.onResponse(null);
import java.io.Closeable;
import org.opensearch.action.StepListener;
                                false  
                maxSeqNoOfUpdatesOrDeletes,
        StartRecoveryRequest request,
                        );
            logger.trace("performing sequence numbers based recovery. starting at [{}]", request.startingSeqNo());
                wrappedSafeSnapshot = acquireSafeCatalogSnapshot(shard);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.SetOnce;
import org.opensearch.index.seqno.RetentionLeaseNotFoundException;
                throw new RecoveryEngineException(shard.shardId(), 1, "sendFileStep failed", e);
            // local checkpoint will be retained for the duration of this recovery.
import org.opensearch.common.unit.TimeValue;
                final int estimateNumOps = countNumberOfHistoryOperations(startingSeqNo);  
                || (retentionLeaseRef.get() != null && retentionLeaseRef.get().retainingSequenceNumber() <= request.startingSeqNo()));  
package org.opensearch.indices.recovery;
                sendFileStep.onResponse(SendFileResult.EMPTY);
            if (retentionLeaseRef.get() == null) {
            }
                    } catch (RetentionLeaseNotFoundException e) {  
            // For a sequence based recovery, the target can keep its local translog  
             * add shard to replication group (shard will receive replication requests from this point on) now that engine is open.
                Long.MAX_VALUE,
    protected void innerRecoveryToTarget(ActionListener<RecoveryResponse> listener, Consumer<Exception> onFailure) throws IOException {
                throw new RecoveryEngineException(shard.shardId(), 1, "snapshot failed", e);
            // operations from the local checkpoint of the safe commit onwards, because when using soft deletes the safe commit retains
import org.opensearch.action.support.replication.ReplicationResponse;  
            retentionLock.close();  
 * The OpenSearch Contributors require contributions made to  
                retentionLeases,
public class LocalStorePeerRecoverySourceHandler extends RecoverySourceHandler {
                        // new one later on in the recovery.
                shard,
            assert Transports.assertNotTransportThread(this + "[phase2]");  
            try {
        final StepListener<TimeValue> prepareEngineStep = new StepListener<>();
