    }
    // Request containing source and target node information
     * point-in-time view of the translog). It then sends each translog operation to the target node so it can be replayed into the new
 * <p>
                    request.targetNode().getId(),
                cloneRetentionLeaseStep.whenComplete(rr -> {
     * safe snapshot handle and releases the store reference. Used by both local and remote  
        // Send a request preparing the new shard's translog to receive operations. This ensures the shard engine is started and disables  
                    break;
                    phase1ExistingFileNames.size(),
         * Before marking the shard as in-sync we acquire an operation permit. We do this so that there is a barrier between marking a
            assert false : message;
                        : () -> {};  
        cancellableThreads.checkForCancel();  
                    phase1FileNames.add(md.name());
        long startingSeqNo,  
                    l.onResponse(null);
    @Override  
                final StoreFileMetadata md = recoverySourceMetadata.get(name);
                recoveryTarget.receiveFileInfo(
        IndexShard shard,
            stopWatch.stop();
        this.maxConcurrentOperations = maxConcurrentOperations;
                maxSeqNoOfUpdatesOrDeletes,  
        AtomicReference<ShardRouting> targetShardRouting = new AtomicReference<>();
                            md  
        RunUnderPrimaryPermit.run(
                    continue;
     *
 */  
    protected GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot(IndexShard shard) {
        }
                snapshot.totalOperations(),
                sendSnapshotResult.sentOperations,
    }
 * SPDX-License-Identifier: Apache-2.0
        final StopWatch stopWatch = new StopWatch().start();  
        // the files after they have been renamed.
        // TODO: We shouldn't use the generic thread pool here as we already execute this from the generic pool.  
import java.util.concurrent.atomic.AtomicLong;  
            );  
                    e = new CancellableThreads.ExecutionCancelledException("recovery was canceled reason [" + reason + "]");  
import org.opensearch.threadpool.ThreadPool;
            TimeValue.ZERO  
                // Generate a "diff" of all the identical, different, and missing  
            + request.sourceNode()  
            } catch (RetentionLeaseNotFoundException e) {  
            final List<Translog.Operation> ops = lastBatchCount > 0 ? new ArrayList<>(lastBatchCount) : new ArrayList<>();
     * We must never release the store using an interruptible thread as we can risk invalidating the node lock.
import org.apache.lucene.util.ArrayUtil;
                sendFileResult.phase1FileSizes,  
                shardId + " updating " + request.targetAllocationId() + "'s global checkpoint",
            maxConcurrentFileChunks
 * You may obtain a copy of the License at  
                            phase1FileNames,
import org.opensearch.common.util.CancellableThreads;  
 *
        @Override
                    translogOps.getAsInt(),  
                shard.failShard("recovery", ex);
import org.opensearch.indices.replication.SegmentFileTransferHandler;  
                cancellableThreads.execute(
    public void recoverToTarget(ActionListener<RecoveryResponse> listener) {  
     */
                // it's possible that the primary has no retention lease yet if we are doing a rolling upgrade from a version before
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Collections.emptyList(),
                    phase1ExistingFileSizes.add(md.length());  
                    // Establishes new empty translog on the replica with global checkpoint set to lastKnownGlobalCheckpoint. We want
        StopWatch stopWatch = new StopWatch().start();
 * originating from this nodes to throttle the number bytes send during file transfer. The transaction log
     */  
        final ActionListener<SendSnapshotResult> listener  
         */  
 * phase bypasses the rate limiter entirely.  
                ActionListener.delegateFailure(listener, (l, newCheckpoint) -> {  
                logger.trace("performing relocation hand-off");
            maxSeenAutoIdTimestamp,  
    static final class SendSnapshotResult {
                prepareEngineStep.result().millis(),
            cancellableThreads.checkForCancel();  
                if (skipCreateRetentionLeaseStep) {
            throw new IndexShardClosedException(request.shardId());
import java.util.function.Consumer;
        sendListener.whenComplete(ignored -> {  
        recoveryTarget.prepareForTranslogOperations(totalTranslogOps, wrappedListener);
            final Consumer<Exception> onFailure = e -> {
import org.opensearch.common.StopWatch;  
     * @param startingSeqNo the starting sequence number to count; included
    }
     */
import org.opensearch.index.shard.IndexShardClosedException;  
            translogOps.getAsInt(),
                IOUtils.close(wrappedSafeSnapshot, releaseStore);
        StepListener<SendFileResult> sendFileStep,
                            "recovery [phase1]: recovering [{}], exists in local store, but is different: remote [{}], local [{}]",  
            StopWatch stopWatch = new StopWatch().start();
        this.shard = shard;  
                if (shard.state() == IndexShardState.CLOSED) {
            logger.debug("finalizeListenerStep completed");
        final long maxSeenAutoIdTimestamp,
            ActionListener.delegateResponse(listener, (l, e) -> ActionListener.completeWith(l, () -> {
        ActionListener<Void> listener
        final String targetHistoryUUID = request.metadataSnapshot().getHistoryUUID();  
                final RetentionLease clonedLease = shard.cloneLocalPeerRecoveryRetentionLease(  
                    // the primary, and in these cases the max seqno would be too high to be valid as a global checkpoint.
            try {
     *  
            );
        future.addListener(listener, OpenSearchExecutors.newDirectExecutorService());  
            this.maxSeenAutoIdTimestamp = maxSeenAutoIdTimestamp;
                createRetentionLeaseStep.whenComplete(retentionLease -> {
import org.opensearch.indices.RunUnderPrimaryPermit;
    @Deprecated
            RunUnderPrimaryPermit.run(() -> {
            );
                // segment files on the target node, using the existing files on
        throws IOException;
                }  
            this.lastChunk = lastChunk;
        Store store,
        final GatedCloseable<IndexCommit> wrappedSafeCommit = shard.acquireSafeIndexCommit();
                if (seqNo < startingSeqNo || seqNo > endingSeqNo) {  
            logger.debug("sendSnapshotStep completed");
            throw new IllegalStateException(
        this.recoveryTarget = recoveryTarget;  
            logger.trace("cloning primary's retention lease");  
            this.sentOperations = sentOperations;
    RecoverySourceHandler(
            this.maxSeqNoOfUpdatesOrDeletes = maxSeqNoOfUpdatesOrDeletes;
 */  
                runWithGenericThreadPool(wrappedSafeSnapshot::close);
 * the Apache License, Version 2.0 (the "License"); you may
                sendSnapshotResult.tookTime.millis()  
            listener.onResponse(null);
                })  
                    + " ("
                final long seqNo = operation.seqNo();
            long batchSizeInBytes = 0L;
                skippedOps,  
import org.opensearch.core.action.ActionListener;
import org.opensearch.index.store.Store;
        final List<Long> phase1FileSizes;
                            md.name(),
     * performs the recovery from the local engine to the target
            this.phase1FileNames = phase1FileNames;
import java.util.stream.StreamSupport;
                sendFileInfoStep.whenComplete(r -> {
        }
            }  
                    skippedOps.incrementAndGet();
    }
         * marking the shard as in-sync. If the relocation handoff holds all the permits then after the handoff completes and we acquire
        final StepListener<Void> finalizeStep = new StepListener<>();  
                // 7.4, and in that case we just create a lease using the local checkpoint of the safe commit which we're using for
 * GitHub history for details.
                /*
                            + " files",
     * Counts the number of history operations from the starting sequence number  
     * Same thread-pool-close semantics as {@link #acquireSafeCommit(IndexShard)}, but returns a
            stopWatch.stop();
        recoveryTarget.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, finalizeListener);
                totalSentOps
        );
                            Collections.emptyList(),  
                ArrayUtil.timSort(mds, Comparator.comparingLong(StoreFileMetadata::length)); // check small files first
            List<Long> phase1ExistingFileSizes,
                // this acquires all IndexShard operation permits and will thus delay new recoveries until it is done  
            final Store.MetadataSnapshot recoverySourceMetadata;  
        ActionListener<SendFileResult> listener,
                shard,
import java.util.Iterator;  
        this.request = request;
                return;
        }, shardId + " establishing retention lease for [" + request.targetAllocationId() + "]", shard, cancellableThreads, logger);  
                    request.targetNode().getId(),
import org.opensearch.action.bulk.BackoffPolicy;
        sender.start();
        }
        }
                        new SendFileResult(
                batchSizeInBytes += operation.estimateSize();
                    + " from primary shard with sync id but number "
                            phase1ExistingFileNames,
    }
                }, listener::onFailure);
        final StepListener<Void> sendListener = new StepListener<>();
                }
            recoveryTarget,
import org.opensearch.common.unit.TimeValue;
    void finalizeRecovery(long targetLocalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) throws IOException {  
     */  
            this.tookTime = tookTime;  
                 * if the recovery process fails after disabling primary mode on the source shard, both relocation source and
    /**
     * @opensearch.internal
                    logger.debug("cleanFilesStep completed");  
                    cancellableThreads.execute(recoveryTarget::forceSegmentFileSync);
 *
            startingSeqNo,  
        final long endingSeqNo,  
        RecoveryTargetHandler recoveryTarget,  
    }
    /**  
            Translog.Operation operation;  
            final long phase1ThrottlingWaitTime = 0L; // TODO: return the actual throttle time
 * @opensearch.internal
                    phase1FileNames.size(),  
import java.util.Collections;
                logger.trace("created retention lease with estimated checkpoint of [{}]", estimatedGlobalCheckpoint);
        return request;
     * @return number of history operations  
    private final SegmentFileTransferHandler transferHandler;
                final List<String> phase1FileNames = new ArrayList<>();
        final int sentOperations;  
                    logger.debug("addRetentionLeaseStep completed");
                final Store.RecoveryDiff diff = recoverySourceMetadata.recoveryDiff(request.metadataSnapshot());  
                + "seq_no stats are mismatched: ["
                phase1ThrottlingWaitTime,  
        long globalCheckpoint,
        }, e -> {
            // not enough, and fall back to a file-based recovery.  
    }  
                    + request.shardId()
        }  
                    totalSizeInBytes += md.length();
            long existingTotalSize,
 * KIND, either express or implied.  See the License for the
    }
            maxSeqNoOfUpdatesOrDeletes,
            long endingSeqNo,
                cancellableThreads.checkForCancel();  
                            0L,
                final long totalSize = totalSizeInBytes;  
            final long targetLocalCheckpoint = sender.targetLocalCheckpoint.get();  
                logger.warn("releasing snapshot caused exception", ex);  
            this.took = took;
 */
                    + request.sourceNode().getName()  
                + "]";  
        }
        private int lastBatchCount = 0; // used to estimate the count of the subsequent batch.  
        //
                    phase1ExistingFileNames,
    /**
                    + "("  
            }  
            final int totalSentOps = sender.sentOps.get();
        if (sourceSeqNos.localCheckpoint != targetSeqNos.localCheckpoint || targetSeqNos.maxSeqNo != sourceSeqNos.maxSeqNo) {
            throw new RecoverFilesRecoveryException(request.shardId(), 0, new ByteSizeValue(0L), e);  
    }
    public static final String PEER_RECOVERY_NAME = "peer-recovery";
                // TODO: make relocated async
            }  
    protected Releasable acquireStore(Store store) {
                            totalSize,
            return;  
     * A send file result
        }, onFailure);  
                final Runnable forceSegRepRunnable = shard.indexSettings().isSegRepEnabledOrRemoteNode()  
                // the source node
        /*
                }
            }
            lastBatchCount = ops.size();
                            took
import java.util.concurrent.CopyOnWriteArrayList;  
    boolean canSkipPhase1(Store.MetadataSnapshot source, Store.MetadataSnapshot target) {  
            stopWatch.stop();  
        Consumer<Exception> onFailure
import org.opensearch.action.support.replication.ReplicationResponse;
            snapshot,
                transferHandler.handleErrorOnSendFiles(store, e, mds);
    }
    }  
                    + ")"
 * file and translog transfer. This handler is completely isolated from other recoveries  
            logger,  
        recoveryTarget.cancel();  
                } else {
                }, listener::onFailure);
        );
import org.opensearch.index.seqno.RetentionLeaseNotFoundException;
                );  
                request.operations,  
        int fileChunkSizeInBytes,  
            mappingVersion,  
            final SendFileResult sendFileResult = sendFileStep.result();  
    void waitForAssignmentPropagate(SetOnce<RetentionLease> retentionLeaseRef) {  
            // Even though those calls are not concurrent, Snapshot#next() uses non-synchronized state and is not multi-thread-compatible.
        final OperationBatchSender sender = new OperationBatchSender(
            logger.trace("recovery [phase1]: remote engine start took [{}]", tookTime);  
                        );
                logger
                            phase1FileSizes,  
        if (shard.state() == IndexShardState.CLOSED) {
                }, listener::onFailure);
                    // the commit we just copied to be a safe commit on the replica, so why not set the global checkpoint on the replica  
     */  
                IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
                if (beforeCancelEx != null) {
    protected final IndexShard shard;
            snapshot.close();
        }  
            };
    /**
 * ownership. Elasticsearch licenses this file to you under  
        return shard.countNumberOfHistoryOperations(PEER_RECOVERY_NAME, startingSeqNo, Long.MAX_VALUE);  
            cancellableThreads.checkForCancel();
    /**  
 * Licensed to Elasticsearch under one or more contributor  
                if (shard.state() == IndexShardState.CLOSED) { // check if the shard got closed on us  
                Locale.ROOT,
    protected int countNumberOfHistoryOperations(long startingSeqNo) throws IOException {
import java.util.Comparator;
                // check if this request is past bytes threshold, and if so, send it off
    }
            ActionListener<Void> listener
    ) {
            if (targetShardRouting.get() != null) {
     * allowed on this index until all recovery phases are done.
                if (shard.indexSettings().isSegRepEnabledOrRemoteNode()) {
                        request.shardId(),
            sourceMetadata,
            logger  
    }
     * Phase two uses a snapshot of the current translog *without* acquiring the write lock (however, the translog snapshot is
                throw e;  
                + " with sync id but "
 * Note: There is always one source handler per recovery that handles all the
            try {  
     */  
     * @opensearch.internal
            this.phase1FileSizes = phase1FileSizes;  
            } else {
        StepListener<SendSnapshotResult> sendSnapshotStep,
            this.existingTotalSize = existingTotalSize;
    protected final CancellableThreads cancellableThreads = new CancellableThreads();
            );
        throw new DelayRecoveryException("source node does not have the shard listed in its state as allocated on the node");
                addRetentionLeaseStep.whenComplete(rr -> {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.engine.RecoveryEngineException;
import org.opensearch.common.util.concurrent.FutureUtils;
     */
                            Collections.emptyList(),
                // recovery as a conservative estimate for the global checkpoint.  
                    logger.info(  
            + ", targetNode="
            return new OperationChunkRequest(ops, operation == null);
        this.chunkSizeInBytes = fileChunkSizeInBytes;
                    logger.debug("cloneRetentionLeaseStep completed");  
                    + "of docs differ: "  
            }  
        final long trimAboveSeqNo = startingSeqNo - 1;
                        createRetentionLease(startingSeqNo, createRetentionLeaseStep);  
            + ", sourceNode="
        }
                            "recovery [phase1]: not recovering [{}], exist in local store and has checksum [{}]," + " size [{}]",
        store.incRef();
                    listener.onResponse(  
                    );
                }, listener::onFailure);  
                createRetentionLease(startingSeqNo, createRetentionLeaseStep);
                final List<String> phase1ExistingFileNames = new ArrayList<>();
                final StepListener<ReplicationResponse> cloneRetentionLeaseStep = new StepListener<>();
 * software distributed under the License is distributed on an
import java.util.Locale;
     * @param maxSeenAutoIdTimestamp     the max auto_id_timestamp of append-only requests on the primary  
            this.totalSize = totalSize;
        }  
        public void close() throws IOException {
import org.apache.lucene.index.IndexFormatTooNewException;
                shard,
            innerRecoveryToTarget(listener, onFailure);  
                final List<Long> phase1ExistingFileSizes = new ArrayList<>();
        // are deleted
                    phase1ExistingFileNames.add(md.name());
            final RecoveryResponse response = new RecoveryResponse(
        try {
                }
import org.apache.logging.log4j.Logger;
            this.endingSeqNo = endingSeqNo;
    Waits for cluster state propagation of assignment of replica on the target node
                        )  
        boolean skipCreateRetentionLeaseStep  
            IOUtils.close(wrappedSafeSnapshot, releaseStore);
            0L,
     * @param listener                   a listener which will be notified with the local checkpoint on the target.
                StoreFileMetadata[] mds = StreamSupport.stream(sourceMetadata.spliterator(), false).toArray(StoreFileMetadata[]::new);  
     * Handles cleanup after the file-sending step completes (success or failure): closes the
        RunUnderPrimaryPermit.run(() -> {
        private final AtomicInteger skippedOps = new AtomicInteger();
            // We need to synchronized Snapshot#next() because it's called by different threads through sendBatch.  
    }
     */
    /**
                final long estimatedGlobalCheckpoint = startingSeqNo - 1;  
        static final SendFileResult EMPTY = new SendFileResult(
        final long totalSize;  
    }  
                if (targetShardRouting.get() != null) {
                    retentionLeaseRef.set(
    }
                // When doing peer recovery of remote store enabled replica, retention leases are not required.  
        final TimeValue took;  
    /**
        return true;
        ThreadPool threadPool,
                () -> shard.updateGlobalCheckpointForShard(request.targetAllocationId(), globalCheckpoint),  
import org.opensearch.common.concurrent.GatedCloseable;
     * <p>
                        "Snapshot differs from actual index - maybe index was removed metadata has "  
            TimeValue took  
        sendFileStep.whenComplete(r -> {
    public void cancel(String reason) {
            retentionLeases,
                    // to the max seqno of this commit? Because (in rare corner cases) this commit might not be a safe commit here on
    void prepareTargetForTranslog(int totalTranslogOps, ActionListener<TimeValue> listener) {
        logger.trace("recovery [phase2]: sending transaction log operations (from [" + startingSeqNo + "] to [" + endingSeqNo + "]");
        });
     * Perform phase two of the recovery process.
        ) {
     * @param maxSeqNoOfUpdatesOrDeletes the max seq_no of updates or deletes on the primary after these operations were executed on it.
import org.opensearch.index.seqno.ReplicationTracker;  
            RunUnderPrimaryPermit.run(
                sendFileResult.took.millis(),
        }
            if (closed.compareAndSet(false, true)) {
                future.onResponse(response);  
import org.opensearch.common.util.io.IOUtils;
            try {
        logger.trace("recovery [phase1]: prepare remote engine for translog");
        GatedCloseable<CatalogSnapshot> wrappedSafeSnapshot,
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        if (targetShardRouting.get() != null) {
                    if (request.metadataSnapshot().asMap().containsKey(md.name())) {
            () -> shard.markAllocationIdAsInSync(request.targetAllocationId(), targetLocalCheckpoint),
    ) {  
                        new SendFileResult(
        final Closeable releaseResources = () -> IOUtils.close(resources);
        });
                + target.getCommitUserData()
import java.util.ArrayList;  
                + "] vs ["
    ) {
        final long maxSeqNoOfUpdatesOrDeletes,  
                sendFileResult.phase1ExistingFileSizes,
                    new ByteSizeValue(existingTotalSizeInBytes)  
        );
                    sendFilesStep.whenComplete(r -> {
 *  
        OperationChunkRequest(List<Translog.Operation> operations, boolean lastChunk) {
                    sendFileInfoStep
package org.opensearch.indices.recovery;
 * Unless required by applicable law or agreed to in writing,
            this.startingSeqNo = startingSeqNo;
        return "ShardRecoveryHandler{"
            }  
                final RuntimeException e;
                assert Transports.assertNotTransportThread(this + "[onFailure]");  
            assert snapshot.totalOperations() == snapshot.skippedOperations() + skippedOps + totalSentOps : String.format(
                        )  
            shard,
            });
                    new ByteSizeValue(totalSizeInBytes),
     * <p>  
        @Override  
            // existing lease we (approximately) know that all our peers are also retaining history as requested by the cloned lease. If
        );
     * has been acquired no commit operations (files being fsync'd) are effectively  
    private static class OperationChunkRequest implements MultiChunkTransfer.ChunkRequest {
                    estimatedGlobalCheckpoint,  
                            md.length()
     * Increases the store reference and returns a {@link Releasable} that will decrease the store reference using the generic thread pool.
     */
     * @param snapshot                   a snapshot of the translog
        protected synchronized OperationChunkRequest nextChunkRequest(Translog.Snapshot snapshot) throws IOException {
                    assert targetShardRouting.get().initializing() : "expected recovery target to be initializing but was "
        // Once the files have been renamed, any other files that are not  
                retentionLeases,
        }, listener::onFailure);
            endingSeqNo,
            files,
                IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
        @Override
                shardId + " validating recovery target [" + request.targetAllocationId() + "] registered ",
        final ActionListener<Void> wrappedListener = ActionListener.wrap(nullVal -> {  
                maxSeenAutoIdTimestamp,
                for (StoreFileMetadata md : diff.identical) {
        finalizeListener.whenComplete(r -> {  
                throw e;  
import org.opensearch.action.support.PlainActionFuture;
                            + recoverySourceMetadata.asMap().size()
            logger.debug("sendFileStep completed");  
                        logger.debug("sendFilesStep completed");  
     * An operation chunk request  
import org.opensearch.common.CheckedRunnable;
            globalCheckpoint,  
        if (source.getNumDocs() != target.getNumDocs()) {
                IOUtils.close(resources);
        final Store store = shard.store();  
                            request.metadataSnapshot().asMap().get(md.name()),
            recoveryTarget.indexTranslogOperations(
        final RetentionLeases retentionLeases,
    }
            shardId + " marking " + request.targetAllocationId() + " as in sync",  
 * not use this file except in compliance with the License.
     *
    protected final StartRecoveryRequest request;
     *
        cancellableThreads.checkForCancel();
                    sendFiles(store, phase1Files.toArray(new StoreFileMetadata[0]), translogOps, sendFilesStep);  
    private void cleanFiles(  
                cancellableThreads,  
            throw new IndexShardClosedException(request.shardId());  
        IntSupplier translogOps,
        protected void handleError(Translog.Snapshot snapshot, Exception e) {
            }
            if (request.isPrimaryRelocation()) {
                    }  
    }  
            // (approximately) because we do not guarantee to be able to satisfy every lease on every peer.
                    listener.onResponse(  
                    throw new IndexShardClosedException(request.shardId());  
            listener  
    /**
     * Phase1 examines the segment files on the target node and copies over the  
                        logger.debug("sendFilesStep completed");
        private final AtomicInteger sentOps = new AtomicInteger();
import java.util.concurrent.atomic.AtomicReference;
            + request.shardId()
                            md.name(),
import org.opensearch.index.store.StoreFileMetadata;  
                long existingTotalSizeInBytes = 0;
        @Override
    }
        SequenceNumbers.CommitInfo sourceSeqNos = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(source.getCommitUserData().entrySet());
        finalizeStep.whenComplete(r -> {
                for (StoreFileMetadata md : phase1Files) {  
            } else {  
    protected final int shardId;  
        final StepListener<Void> finalizeListener = new StepListener<>();  
import org.opensearch.common.SetOnce;
 * everything relating to copying the segment files as well as sending translog
 * operations across the wire once the segments have been copied.  
            final TimeValue tookTime = stopWatch.totalTime();
            listener.onResponse(new SendSnapshotResult(targetLocalCheckpoint, totalSentOps, tookTime));  
        assert targetHistoryUUID != null : "incoming target history missing";
                sendFileResult.existingTotalSize,
    void phase2(
        threadPool.generic().execute(ActionRunnable.run(future, task));  
    protected abstract void innerRecoveryToTarget(ActionListener<RecoveryResponse> listener, Consumer<Exception> onFailure)  
import org.apache.lucene.index.IndexFormatTooOldException;
            List<String> phase1FileNames,  
            long maxSeqNoOfUpdatesOrDeletes,
                phase1Files.addAll(diff.different);
    ) {
            this.phase1ExistingFileSizes = phase1ExistingFileSizes;  
    /**  
                + request.shardId()  
                            took
                    listener.onResponse(clonedLease);
            );
                sendFileResult.phase1ExistingFileNames,
/*  
                }  
import org.opensearch.common.logging.Loggers;
        final List<Long> phase1ExistingFileSizes;  
                    targetLocalCheckpoint.updateAndGet(curr -> SequenceNumbers.max(curr, newCheckpoint));
    protected final List<Closeable> resources = new CopyOnWriteArrayList<>();
            );
        final GatedCloseable<CatalogSnapshot> wrappedSafeSnapshot = shard.acquireSafeCatalogSnapshot();  
                "try to recover "  
     * {@link CatalogSnapshot}. Callers must close the returned handle to release refs.  
import org.opensearch.index.shard.IndexShardState;
        final List<String> phase1ExistingFileNames;
import org.apache.lucene.store.RateLimiter;  
        StopWatch stopWatch = new StopWatch().start();
                    throw new CorruptIndexException(
                        logger.trace(
            final SendSnapshotResult sendSnapshotResult = sendSnapshotStep.result();
import org.apache.lucene.index.CorruptIndexException;
                final IndexShardRoutingTable routingTable = shard.getReplicationGroup().getRoutingTable();  
            long totalSize,
 * this file be licensed under the Apache-2.0 license or a
        Store.MetadataSnapshot sourceMetadata,
    void createRetentionLease(final long startingSeqNo, ActionListener<RetentionLease> listener) {  
                final StepListener<Void> sendFilesStep = new StepListener<>();  
                    () -> shard.relocated(request.targetAllocationId(), recoveryTarget::handoffPrimaryContext, forceSegRepRunnable)
                createRetentionLeaseStep.whenComplete(retentionLease -> {  
                    + request.targetNode().getName()
        private final long startingSeqNo;
        // related to this recovery (out of date segments, for example)
        final TimeValue tookTime;
    protected final ListenableFuture<RecoveryResponse> future = new ListenableFuture<>();  
     * @param endingSeqNo                the highest sequence number that should be sent
            Collections.emptyList(),
        while (backoffDelayIterator.hasNext()) {
import org.opensearch.common.util.concurrent.ListenableFuture;
        private final RetentionLeases retentionLeases;
        public boolean lastChunk() {
                    totalSizeInBytes += md.length();
                runWithGenericThreadPool(wrappedSafeCommit::close);
     * segments that are missing. Only segments that have the same size and
        resources.add(transfer);
        final long startingSeqNo,
            + '}';  
        final AtomicBoolean closed = new AtomicBoolean(false);
                final StepListener<ReplicationResponse> addRetentionLeaseStep = new StepListener<>();
                    }, listener::onFailure);
    ) throws IOException {
        transfer.start();  
                    );
            this.operations = operations;  
        assert threadPool.generic().isShutdown() == false;
import org.opensearch.common.lease.Releasables;  
        final Translog.Snapshot snapshot,
        }
     * @opensearch.internal
        final AtomicBoolean closed = new AtomicBoolean(false);
                );
    void phase1(
     * shard.  
                // but we must still create a retention lease  
    private final int maxConcurrentOperations;
            fileChunkSizeInBytes,  
     */
import org.apache.lucene.index.IndexCommit;  
        // names to the actual file names. It also writes checksums for  
                            Collections.emptyList(),
                    new ThreadedActionListener<>(logger, shard.getThreadPool(), ThreadPool.Names.GENERIC, cloneRetentionLeaseStep, false)
        SequenceNumbers.CommitInfo targetSeqNos = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(target.getCommitUserData().entrySet());  
        this.transferHandler = new SegmentFileTransferHandler(
        }  
    // Shard that is going to be recovered (the "source")
                // Total size of segment files that are recovered
        private final AtomicLong targetLocalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
                } else {  
     * Perform phase1 of the recovery operations. Once this {@link CatalogSnapshot}
import org.opensearch.index.seqno.RetentionLease;
                final StepListener<RetentionLease> createRetentionLeaseStep = new StepListener<>();
    }
        private final long maxSeenAutoIdTimestamp;
        if (source.getSyncId() == null || source.getSyncId().equals(target.getSyncId()) == false) {
        return Releasables.releaseOnce(() -> runWithGenericThreadPool(store::decRef));  
    protected GatedCloseable<IndexCommit> acquireSafeCommit(IndexShard shard) {  
                            0L,
 * RecoverySourceHandler handles the three phases of shard recovery, which is
                if (targetShardRouting.get() == null) {
     *
     *                                   ops should be sent  
                    + target.getNumDocs()
/*
                }
                    logger.trace("recovery [phase1]: took [{}]", took);
                assert shard.indexSettings().isSoftDeleteEnabled() == false;
            0L,
        StepListener<TimeValue> prepareEngineStep,  
 *
            store,  
            this.mappingVersion = mappingVersion;
    }
        cancellableThreads.cancel(reason);
import java.util.List;
            + request.targetNode()
        final long mappingVersion,
    static final class SendFileResult {  
                phase1Files.addAll(diff.missing);
            if (closed.compareAndSet(false, true)) {  
                    e = new IndexShardClosedException(shard.shardId(), "shard is closed and recovery was canceled reason [" + reason + "]");
 * under the License.  
                final StepListener<RetentionLease> createRetentionLeaseStep = new StepListener<>();
                            Collections.emptyList(),  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        final List<String> phase1FileNames;
                final long existingTotalSize = existingTotalSizeInBytes;
                    phase1FileSizes.add(md.length());  
    /**
        SendFileResult(
        }  
     */  
            super(logger, threadPool.getThreadContext(), listener, maxConcurrentOperations, Collections.singletonList(snapshot));  
            // Clone the peer recovery retention lease belonging to the source shard. We are retaining history between the local
                        request.targetNode()  
                    logger.trace("recovery [phase1]: took [{}]", took);
/*  
            RetentionLeases retentionLeases,
            List<String> phase1ExistingFileNames,  
            if (canSkipPhase1(recoverySourceMetadata, request.metadataSnapshot()) == false) {
        FutureUtils.get(future);
import java.util.function.IntSupplier;  
        addListener(listener);
            }))
            this.phase1ExistingFileNames = phase1ExistingFileNames;
                }  
                snapshot.totalOperations(),
                sendFileResult.phase1FileNames,
                            md.checksum(),  
 *    http://www.apache.org/licenses/LICENSE-2.0
                        name  
                            existingTotalSize,
        }, listener::onFailure);
        // below and thus make it impossible for the store release to execute which in turn would block the futures forever
        this.shardId = this.request.shardId().id();
            long startingSeqNo,  
                // Force round of segment replication to update its checkpoint to primary's  
        try {  
                    + source.getNumDocs()
                    );
 * The OpenSearch Contributors require contributions made to  
     * A result for a send snapshot  
            logger.debug("finalizeStep completed");  
        recoveryTarget.cleanFiles(
        ) {
    /*  
                    logger.debug("sendFileInfoStep completed");
                cancellableThreads,  
            Translog.Snapshot snapshot,
            },  
    public StartRecoveryRequest getRequest() {
import java.util.concurrent.atomic.AtomicBoolean;
    protected void finalizeStepAndCompleteFuture(
 * specific language governing permissions and limitations
            }  
        private final long endingSeqNo;  
import org.opensearch.index.shard.IndexShard;
        final long existingTotalSize;
        );
                final StepListener<Void> sendFileInfoStep = new StepListener<>();
     */  
                long totalSizeInBytes = 0;
                        + targetShardRouting;  
 * license agreements. See the NOTICE file distributed with
                    phase1FileSizes,  
            threadPool,
        cancellableThreads.checkForCancel();
                );
    }
     * checksum can be reused.
                    );
     * This method acquires a safe commit and wraps it to make sure that it will be released using the generic thread pool.  
                mappingVersion,
                    final TimeValue took = stopWatch.totalTime();
                final List<Long> phase1FileSizes = new ArrayList<>();  
            this.snapshot = snapshot;  
                }
                    final long lastKnownGlobalCheckpoint = shard.getLastKnownGlobalCheckpoint();
                    sendFilesStep.whenComplete(r -> {
        }
}
        IntSupplier translogOps,  
                    }, listener::onFailure);
        return new GatedCloseable<>(wrappedSafeCommit.get(), () -> {  
import org.opensearch.index.seqno.RetentionLeases;  
            throw new RecoveryEngineException(shard.shardId(), 2, "failed to send/replay operations", e);  
                "expected total [%d], overridden [%d], skipped [%d], total sent [%d]",  
                }, listener::onFailure);
            cancellableThreads.setOnCancel((reason, beforeCancelEx) -> {
                    + ", primary) vs "
    }
                final RetentionLease newLease = shard.addPeerRecoveryRetentionLease(
        }
        );
                            phase1ExistingFileSizes,  
                    } else {
                    logger.info("Snapshot differs from actual index for file: {} meta: {}", name, recoverySourceMetadata.asMap());
import org.opensearch.index.seqno.SequenceNumbers;
     */
import org.opensearch.index.translog.Translog;
         * shard as in-sync and relocating a shard. If we acquire the permit then no relocation handoff can complete before we are done  
            cancellableThreads,
        cancellableThreads.checkForCancel();
            final TimeValue tookTime = stopWatch.totalTime();
import java.util.concurrent.atomic.AtomicInteger;
                    "recovery [phase1]: recovering_files [{}] with total_size [{}], reusing_files [{}] with total_size [{}]",
import org.opensearch.action.StepListener;  
            Collections.emptyList(),  
import org.opensearch.core.common.unit.ByteSizeValue;  
    private final RecoveryTargetHandler recoveryTarget;
        StepListener<SendFileResult> sendFileStep,
        final boolean lastChunk;  
        });  
            } catch (CorruptIndexException | IndexFormatTooOldException | IndexFormatTooNewException ex) {  
                recoverySourceMetadata = store.getMetadata(snapshot);
    private final ThreadPool threadPool;  
    private final int chunkSizeInBytes;  
        final long globalCheckpoint = shard.getLastKnownGlobalCheckpoint(); // this global checkpoint is persisted in finalizeRecovery
                        );
            assert Transports.assertNotTransportThread("[phase2]");
        Iterator<TimeValue> backoffDelayIterator = EXPONENTIAL_BACKOFF_POLICY.iterator();  
        int maxConcurrentFileChunks,
                );
            }
        // Send the CLEAN_FILES request, which takes all of the files that
        if (shard.state() == IndexShardState.CLOSED) {
            throw new IllegalStateException(message);
                        logger.trace("recovery [phase1]: recovering [{}], does not exist in remote", md.name());  
                logger.trace(
import org.opensearch.cluster.routing.ShardRouting;  
                        logger.trace(  
            return false;
                 */
        final PlainActionFuture<Void> future = new PlainActionFuture<>();
        } catch (Exception e) {
            }
        }  
    }  
            for (String name : snapshot.getFiles(true)) {
                    assert retentionLease == null || retentionLease.retainingSequenceNumber() - 1 <= lastKnownGlobalCheckpoint  
            logger.trace("recovery [phase2]: took [{}]", tookTime);
                    listener.onResponse(newLease);
        // While practically unlikely at a min pool size of 128 we could technically block the whole pool by waiting on futures
        private final long maxSeqNoOfUpdatesOrDeletes;  
import org.opensearch.action.ActionRunnable;
     * recovery paths.
import org.opensearch.common.lease.Releasable;
                if (batchSizeInBytes >= chunkSizeInBytes) {  
            IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
    private void runWithGenericThreadPool(CheckedRunnable<Exception> task) {  
            while ((operation = snapshot.next()) != null) {
                    new ThreadedActionListener<>(logger, shard.getThreadPool(), ThreadPool.Names.GENERIC, addRetentionLeaseStep, false)
                    phase1ExistingFileSizes,
                    final TimeValue took = stopWatch.totalTime();
     * @param startingSeqNo              the sequence number to start recovery from, or {@link SequenceNumbers#UNASSIGNED_SEQ_NO} if all
        // Recovery target can trim all operations >= startingSeqNo as we have sent all these operations in the phase 2
    void sendFiles(Store store, StoreFileMetadata[] files, IntSupplier translogOps, ActionListener<Void> listener) {
 */  
        int maxConcurrentOperations
            try {
            shard,  
    protected void onSendFileStepCompleteCatalogSnapshot(  
                List<StoreFileMetadata> phase1Files = new ArrayList<>(diff.different.size() + diff.missing.size());  
        // were transferred and renames them from their temporary file
        this.logger = Loggers.getLogger(RecoverySourceHandler.class, request.shardId(), "recover to " + request.targetNode().getName());
     * with the file systems due to interrupt (see {@link org.apache.lucene.store.NIOFSDirectory} javadocs for more detail).
                + source.getCommitUserData()  
            listener.onResponse(tookTime);
    /**
        // if the target is on an old version, it won't be able to handle out-of-order file chunks.  
                final StepListener<Void> cleanFilesStep = new StepListener<>();
                        "delaying recovery of {} as it is not listed as assigned to target node {}",
                ops.add(operation);
                    cleanFiles(store, recoverySourceMetadata, translogOps, lastKnownGlobalCheckpoint, cleanFilesStep);  
            this.retentionLeases = retentionLeases;  
            cancellableThreads,
        protected void executeChunkRequest(OperationChunkRequest request, ActionListener<Void> listener) {  
        BackoffPolicy EXPONENTIAL_BACKOFF_POLICY = BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(1000), 5);
        logger.trace("finalizing recovery");  
                    existingTotalSizeInBytes += md.length();
    protected final Logger logger;  
            sendListener
                    );  
            List<Long> phase1FileSizes,
        OperationBatchSender(
            this.targetLocalCheckpoint = targetLocalCheckpoint;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
        }, e -> listener.onFailure(new RecoveryEngineException(shard.shardId(), 1, "prepare target for translog failed", e)));
        @Override
            Collections.emptyList(),  
            return lastChunk;  
                logger.trace("skipping [phase1] since source and target have identical sync id [{}]", recoverySourceMetadata.getSyncId());
            }
                 * target are failed (see {@link IndexShard#updateRoutingEntry}).  
    }
            finalizeRecovery(r.targetLocalCheckpoint, trimAboveSeqNo, finalizeStep);
            + "shardId="  
                        shard.getRetentionLeases().get(ReplicationTracker.getPeerRecoveryRetentionLeaseId(targetShardRouting.get()))
                    }
                    Thread.sleep(backoffDelayIterator.next().millis());
        Releasable releaseStore  
                }
            logger.info("finalizing recovery took [{}]", stopWatch.totalTime());  
                }, listener::onFailure);
        } catch (Exception e) {
                }
                    e.addSuppressed(beforeCancelEx);  
            // checkpoint of the safe commit we're creating and this lease's retained seqno with the retention lock, and by cloning an  
        }, onFailure);
            final long skippedOps = sender.skippedOps.get();
                }
        CatalogSnapshot snapshot,
        this.threadPool = threadPool;
/**  
 * while the {@link RateLimiter} passed via {@link RecoverySettings} is shared across recoveries
            } catch (final IOException ex) {
import org.opensearch.transport.Transports;
            final String message = "try to recover "
    protected boolean isTargetSameHistory() {
     * Cancels the recovery and interrupts all eligible threads.
                    || (request.sourceNode().isRemoteStoreNode() && request.targetNode().isRemoteStoreNode())
import org.opensearch.action.support.ThreadedActionListener;  
 * compatible open source license.
                }
                logger.trace("cloned primary's retention lease as [{}]", clonedLease);
        return targetHistoryUUID.equals(shard.getHistoryUUID());
        cancellableThreads.checkForCancel();  
            //
                        ? recoveryTarget::forceSegmentFileSync
        private final long mappingVersion;
        sendSnapshotStep.whenComplete(r -> {  
    /**
                cleanFilesStep.whenComplete(r -> {
            long maxSeenAutoIdTimestamp,  
 * this work for additional information regarding copyright
        }
        SendSnapshotResult(final long targetLocalCheckpoint, final int sentOperations, final TimeValue tookTime) {  
                snapshot.skippedOperations(),
    ) {  
     * Releasing a safe commit can access some commit files. It's better not to use {@link CancellableThreads} to interact
import java.io.Closeable;
         * the permit then the state of the shard will be relocated and this recovery will fail.
            long mappingVersion,  
                sentOps.incrementAndGet();  
                logger
            translogOps,
        final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = transferHandler.createTransfer(
        StartRecoveryRequest request,
public abstract class RecoverySourceHandler {
        long startingSeqNo,  
    }  
        return new GatedCloseable<>(wrappedSafeSnapshot.get(), () -> {
                throw ex;
    }  
        final long targetLocalCheckpoint;
                sendFileResult.totalSize,  
                    phase1FileNames,
                    if (logger.isTraceEnabled()) {
            } finally {
    public String toString() {
    private class OperationBatchSender extends MultiChunkTransfer<Translog.Snapshot, OperationChunkRequest> {
                // Total size of segment files that were able to be re-used  
        // garbage collection (not the JVM's GC!) of tombstone deletes.
            // the recovery now fails before copying enough history over then a subsequent attempt will find this lease, determine it is
        final List<Translog.Operation> operations;
                targetShardRouting.set(routingTable.getByAllocationId(request.targetAllocationId()));
                        createRetentionLeaseStep.onResponse(null);
        private final Translog.Snapshot snapshot;
                        : retentionLease + " vs " + lastKnownGlobalCheckpoint;
    public void addListener(ActionListener<RecoveryResponse> listener) {
        }  
                if (md == null) {  
import java.io.IOException;
                );  
            request.targetNode(),
