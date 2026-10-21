            // and before acquiring the safe commit we'll be using, so we can be certain that all operations after the safe commit's
        int maxConcurrentFileChunks,
            if (logger.isTraceEnabled()) {
                createRetentionLease(startingSeqNo, ActionListener.map(sendFileStep, ignored -> SendFileResult.EMPTY));
             */
            // we have to capture the max_seen_auto_id_timestamp and the max_seq_no_of_updates to make sure that these values
            final long endingSeqNo = shard.seqNoStats().getMaxSeqNo();
                startingSeqNo,
            // conservatively copy all available operations. If we are using retention leases then "enough operations" is just the
}
                true
            );
             * all documents up to maxSeqNo in phase2.
                        logger.debug("no peer-recovery retention lease for " + request.targetAllocationId());
    ) {
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.common.SetOnce;
                throw new RecoveryEngineException(shard.shardId(), 1, "snapshot failed", e);
            retentionLock.close();
/**
            logger.debug("sendFileStep completed");
                                ThreadPool.Names.GENERIC,
            final long mappingVersionOnPrimary = shard.indexSettings().getIndexMetadata().getMappingVersion();
    }
        }, onFailure);
                resources.add(wrappedSafeSnapshot);
        finalizeStepAndCompleteFuture(startingSeqNo, sendSnapshotStep, sendFileStep, prepareEngineStep, onFailure);
                        deleteRetentionLeaseStep.onResponse(null);
            retentionLock.close();
             * This means that any document indexed into the primary after this will be replicated to this replica as well
            /*
                logger
             * add shard to replication group (shard will receive replication requests from this point on) now that engine is open.
        prepareEngineStep.whenComplete(prepareEngineTime -> {
            final GatedCloseable<CatalogSnapshot> wrappedSafeSnapshot;
                        // checkpoint backwards. We must therefore remove any existing retention lease so that we can create a
            logger.trace("performing sequence numbers based recovery. starting at [{}]", request.startingSeqNo());
 * The OpenSearch Contributors require contributions made to
                            )
                final int estimateNumOps = countNumberOfHistoryOperations(startingSeqNo);
                Long.MAX_VALUE,
            && shard.hasCompleteHistoryOperations(PEER_RECOVERY_NAME, request.startingSeqNo())
        RecoveryTargetHandler recoveryTarget,
import org.opensearch.threadpool.ThreadPool;
                sendSnapshotStep
                onSendFileStepCompleteCatalogSnapshot(sendFileStep, wrappedSafeSnapshot, releaseStore);
            && isTargetSameHistory()
        assert startingSeqNo >= 0 : "startingSeqNo must be non negative. got: " + startingSeqNo;
        final StepListener<TimeValue> prepareEngineStep = new StepListener<>();
        waitForAssignmentPropagate(retentionLeaseRef);
                        // new one later on in the recovery.
        IndexShard shard,
                // wrapped in an EngineException. Detect this and fail the shard so the
                    logger.debug("deleteRetentionLeaseStep completed");
        final StepListener<SendSnapshotResult> sendSnapshotStep = new StepListener<>();
        }
                                false
                wrappedSafeSnapshot = acquireSafeCatalogSnapshot(shard);
                shard,
                    phase1(wrappedSafeSnapshot.get(), startingSeqNo, () -> estimateNumOps, sendFileStep, false);
package org.opensearch.indices.recovery;
            } catch (final Exception e) {
import org.opensearch.common.unit.TimeValue;
            assert Transports.assertNotTransportThread(this + "[prepareTargetForTranslog]");
import org.opensearch.index.seqno.RetentionLeases;
            assert Transports.assertNotTransportThread(this + "[phase2]");
                    } catch (RetentionLeaseNotFoundException e) {
            // Try and copy enough operations to the recovering peer so that if it is promoted to primary then it has a chance of being
                deleteRetentionLeaseStep.whenComplete(ignored -> {
            // are at least as high as the corresponding values on the primary when any of these operations were executed on it.
            resources.add(phase2Snapshot);
            final Translog.Snapshot phase2Snapshot = shard.newChangesSnapshot(
            } catch (final Exception e) {
        if (isSequenceNumberBasedRecovery && retentionLeaseRef.get() != null) {
 * compatible open source license.
import org.opensearch.index.shard.IndexShard;
            try {
                phase2Snapshot,
import org.opensearch.action.support.replication.ReplicationResponse;
            }
                            request.targetNode().getId(),
    protected void innerRecoveryToTarget(ActionListener<RecoveryResponse> listener, Consumer<Exception> onFailure) throws IOException {
            try {
            // local checkpoint will be retained for the duration of this recovery.
            // For a sequence based recovery, the target can keep its local translog
                endingSeqNo,
        super(shard, recoveryTarget, threadPool, request, fileChunkSizeInBytes, maxConcurrentFileChunks, maxConcurrentOperations);
            // all the history we need is retained by the retention lock, obtained before calling shard.hasCompleteHistoryOperations()
    public LocalStorePeerRecoverySourceHandler(
        int maxConcurrentOperations
        // without having a complete history.
                || (retentionLeaseRef.get() != null && retentionLeaseRef.get().retainingSequenceNumber() <= request.startingSeqNo()));
        }, onFailure);
import org.opensearch.indices.RunUnderPrimaryPermit;
            }
                final Releasable releaseStore = acquireStore(shard.store());
            // of retention leases, but this is not guaranteed: an earlier peer recovery from a different primary might have created a
                false,
            }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
                shardId + " initiating tracking of " + request.targetAllocationId(),
             * make sure to do this before sampling the max sequence number in the next step, to ensure that we send
            }
import org.opensearch.index.seqno.RetentionLeaseNotFoundException;
                RunUnderPrimaryPermit.run(() -> {
                resources.add(releaseStore);
            // able to recover other replicas using operations-based recoveries. If we are not using retention leases then we
            if (retentionLeaseRef.get() == null) {
            final long maxSeenAutoIdTimestamp = shard.getMaxSeenAutoIdTimestamp();
                    try {
                    shard.failShard("recovery", e);
            startingSeqNo = request.startingSeqNo();
            // retention lease for some history that this primary already discarded, since we discard history when the global checkpoint
                    assert Transports.assertNotTransportThread(this + "[phase1]");
                // IndexCommit path). If the segments file is corrupt, the exception is
        } else {
    @Override
                                deleteRetentionLeaseStep,
                                logger,
        // because when doing a rolling upgrade from earlier than 7.4 we may create some leases that are initially unsatisfied. It's
                logger.trace("snapshot translog for recovery; current size is [{}]", countNumberOfHistoryOperations(startingSeqNo));
                }
        resources.add(retentionLock);
            && ((retentionLeaseRef.get() == null && shard.useRetentionLeasesInPeerRecovery() == false)
            startingSeqNo = Long.parseLong(wrappedSafeSnapshot.get().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)) + 1L;
                maxSeenAutoIdTimestamp,
 * @opensearch.internal
 */
            // advances and not when creating a new safe commit. In any case this is a best-effort thing since future recoveries can
import org.opensearch.index.seqno.RetentionLease;
                        // If the target previously had a copy of this shard then a file-based recovery might move its global
import org.opensearch.index.engine.RecoveryEngineException;
    }
 * SPDX-License-Identifier: Apache-2.0
                mappingVersionOnPrimary,
            logger.trace("performing file-based recovery followed by history replay starting at [{}]", startingSeqNo);
        ThreadPool threadPool,
                        );
                }, shardId + " removing retention lease for [" + request.targetAllocationId() + "]", shard, cancellableThreads, logger);
            logger.trace("history is retained by retention lock");
                maxSeqNoOfUpdatesOrDeletes,
                sendFileStep.onResponse(SendFileResult.EMPTY);
import org.opensearch.index.translog.Translog;
                startingSeqNo,
import org.opensearch.action.support.ThreadedActionListener;
 */
                cancellableThreads,
        final Closeable retentionLock = shard.acquireHistoryRetentionLock();
import org.opensearch.common.concurrent.GatedCloseable;
                if (Lucene.isCorruptionException(e)) {
 *
import org.opensearch.transport.Transports;
        // Also it's pretty cheap when soft deletes are enabled, and it'd be a disaster if we tried a sequence-number-based recovery
            final RetentionLeases retentionLeases = shard.getRetentionLeases();
                    }
        // possible there are other cases where we cannot satisfy all leases, because that's not a property we currently expect to hold.
                PEER_RECOVERY_NAME,
            // operations from the local checkpoint of the safe commit onwards, because when using soft deletes the safe commit retains
        final SetOnce<RetentionLease> retentionLeaseRef = new SetOnce<>();
        final StepListener<SendFileResult> sendFileStep = new StepListener<>();
 *
        int fileChunkSizeInBytes,
                // cluster turns RED instead of retrying recovery forever.
            // all the history we need is retained by an existing retention lease, so we do not need a separate retention lock
import org.opensearch.core.action.ActionListener;
                retentionLeases,
 * This handler is used for node-to-node peer recovery when the recovery target is a replica/ or a relocating primary
            final long maxSeqNoOfUpdatesOrDeletes = shard.getMaxSeqNoOfUpdatesOrDeletes();
                // acquireSafeCatalogSnapshot reads segments_N eagerly (unlike the old
        if (isSequenceNumberBasedRecovery) {
/*
            // always fall back to file-based ones, and only really presents a problem if this primary fails before things have settled
import java.io.IOException;
public class LocalStorePeerRecoverySourceHandler extends RecoverySourceHandler {
                        shard.removePeerRecoveryRetentionLease(
import java.io.Closeable;
                                shard.getThreadPool(),
            RunUnderPrimaryPermit.run(
            // at least as much history as anything else. The safe commit will often contain all the history retained by the current set
                            new ThreadedActionListener<>(
        final boolean isSequenceNumberBasedRecovery = request.startingSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
import java.util.function.Consumer;
        final long startingSeqNo;
        sendFileStep.whenComplete(r -> {
            } else {
            logger.trace("history is retained by {}", retentionLeaseRef.get());
 * shard with translog backed by local store.
        }
        StartRecoveryRequest request,
            prepareTargetForTranslog(countNumberOfHistoryOperations(startingSeqNo), prepareEngineStep);
            );
            logger.debug("prepareEngineStep completed");
            // down.
            );
        // NB check hasCompleteHistoryOperations when computing isSequenceNumberBasedRecovery, even if there is a retention lease,
import org.opensearch.action.StepListener;
        } else {
 * this file be licensed under the Apache-2.0 license or a
                final StepListener<ReplicationResponse> deleteRetentionLeaseStep = new StepListener<>();
                }, onFailure);
            phase2(
                throw new RecoveryEngineException(shard.shardId(), 1, "sendFileStep failed", e);
import org.opensearch.common.lucene.Lucene;
import org.opensearch.common.lease.Releasable;
                () -> shard.initiateTracking(request.targetAllocationId()),
