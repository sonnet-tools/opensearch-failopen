    static final class SendSnapshotResult {
                long existingTotalSizeInBytes = 0;
        return request;
        return new GatedCloseable<>(wrappedSafeSnapshot.get(), () -> {
                    || (request.sourceNode().isRemoteStoreNode() && request.targetNode().isRemoteStoreNode())
            maxSeqNoOfUpdatesOrDeletes,
    RecoverySourceHandler(
        final long trimAboveSeqNo = startingSeqNo - 1;
            final TimeValue tookTime = stopWatch.totalTime();
                // Generate a "diff" of all the identical, different, and missing
                // Total size of segment files that are recovered
                    listener.onResponse(
            List<String> phase1ExistingFileNames,
     */
            shard,
    protected void onSendFileStepCompleteCatalogSnapshot(
            long maxSeqNoOfUpdatesOrDeletes,
            innerRecoveryToTarget(listener, onFailure);
        if (source.getNumDocs() != target.getNumDocs()) {
                    e = new CancellableThreads.ExecutionCancelledException("recovery was canceled reason [" + reason + "]");
                final StepListener<Void> sendFilesStep = new StepListener<>();
            if (closed.compareAndSet(false, true)) {
            long mappingVersion,
                }, listener::onFailure);
        public void close() throws IOException {
                }
                if (targetShardRouting.get() != null) {
        cancellableThreads.checkForCancel();
        cancellableThreads.checkForCancel();
            assert false : message;
                // Force round of segment replication to update its checkpoint to primary's
    protected final int shardId;
                            "recovery [phase1]: recovering [{}], exists in local store, but is different: remote [{}], local [{}]",
                    phase1ExistingFileNames,
        cancellableThreads.checkForCancel();
            final long phase1ThrottlingWaitTime = 0L; // TODO: return the actual throttle time
        resources.add(transfer);
                }, listener::onFailure);
import org.opensearch.action.support.PlainActionFuture;
        // While practically unlikely at a min pool size of 128 we could technically block the whole pool by waiting on futures
        if (shard.state() == IndexShardState.CLOSED) {
                Locale.ROOT,
                final long estimatedGlobalCheckpoint = startingSeqNo - 1;
         * Before marking the shard as in-sync we acquire an operation permit. We do this so that there is a barrier between marking a
                    logger.debug("cloneRetentionLeaseStep completed");
        recoveryTarget.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, finalizeListener);
        OperationChunkRequest(List<Translog.Operation> operations, boolean lastChunk) {
    }
import org.opensearch.common.lease.Releasable;
            snapshot,
    }
                    + source.getNumDocs()
                            Collections.emptyList(),
    }
                    + " ("
                cleanFilesStep.whenComplete(r -> {
                request.operations,
            },
     * @param maxSeenAutoIdTimestamp     the max auto_id_timestamp of append-only requests on the primary
     */
                phase1Files.addAll(diff.different);
        this.logger = Loggers.getLogger(RecoverySourceHandler.class, request.shardId(), "recover to " + request.targetNode().getName());
    boolean canSkipPhase1(Store.MetadataSnapshot source, Store.MetadataSnapshot target) {
                }
                    + ")"
        private final long maxSeenAutoIdTimestamp;
 * <p>
    }
 *
                recoveryTarget.receiveFileInfo(
import org.opensearch.index.seqno.RetentionLeaseNotFoundException;
    Waits for cluster state propagation of assignment of replica on the target node
            } catch (CorruptIndexException | IndexFormatTooOldException | IndexFormatTooNewException ex) {
                }
        ActionListener<Void> listener
                    + request.sourceNode().getName()
        this.transferHandler = new SegmentFileTransferHandler(
 * Modifications Copyright OpenSearch Contributors. See
            Collections.emptyList(),
            try {
                    translogOps.getAsInt(),
    void waitForAssignmentPropagate(SetOnce<RetentionLease> retentionLeaseRef) {
     * A send file result
            }
            cancellableThreads,
import java.util.concurrent.atomic.AtomicBoolean;
                + target.getCommitUserData()
                    assert targetShardRouting.get().initializing() : "expected recovery target to be initializing but was "
                        createRetentionLease(startingSeqNo, createRetentionLeaseStep);
    protected final ListenableFuture<RecoveryResponse> future = new ListenableFuture<>();
                    listener.onResponse(newLease);
        }
     * @param endingSeqNo                the highest sequence number that should be sent
 * not use this file except in compliance with the License.
     * shard.
            stopWatch.stop();
            final TimeValue tookTime = stopWatch.totalTime();
            stopWatch.stop();
    ) throws IOException {
 * KIND, either express or implied.  See the License for the
            this.maxSeenAutoIdTimestamp = maxSeenAutoIdTimestamp;
        final ActionListener<Void> wrappedListener = ActionListener.wrap(nullVal -> {
        sendFileStep.whenComplete(r -> {
            this.existingTotalSize = existingTotalSize;
        private int lastBatchCount = 0; // used to estimate the count of the subsequent batch.
     * point-in-time view of the translog). It then sends each translog operation to the target node so it can be replayed into the new
            this.took = took;
import java.io.Closeable;
                        "Snapshot differs from actual index - maybe index was removed metadata has "
            assert snapshot.totalOperations() == snapshot.skippedOperations() + skippedOps + totalSentOps : String.format(
                    totalSizeInBytes += md.length();
                cloneRetentionLeaseStep.whenComplete(rr -> {
                    // to the max seqno of this commit? Because (in rare corner cases) this commit might not be a safe commit here on
            }
            Collections.emptyList(),
                        + targetShardRouting;
        final String targetHistoryUUID = request.metadataSnapshot().getHistoryUUID();
public abstract class RecoverySourceHandler {
            long existingTotalSize,
            // not enough, and fall back to a file-based recovery.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    ) {
        sender.start();
                        )
    }
            logger.debug("finalizeListenerStep completed");
        this.shard = shard;
    }
            logger,
        final List<String> phase1FileNames;
                    }, listener::onFailure);
            } else {
            } finally {
     */
                for (StoreFileMetadata md : diff.identical) {
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        }, onFailure);
                sendFileResult.existingTotalSize,
import org.opensearch.action.StepListener;
                    targetLocalCheckpoint.updateAndGet(curr -> SequenceNumbers.max(curr, newCheckpoint));
        throw new DelayRecoveryException("source node does not have the shard listed in its state as allocated on the node");
    }
            throw new IndexShardClosedException(request.shardId());
            // checkpoint of the safe commit we're creating and this lease's retained seqno with the retention lock, and by cloning an
     * Perform phase1 of the recovery operations. Once this {@link CatalogSnapshot}
    }
        }
                    phase1ExistingFileSizes.add(md.length());
        cancellableThreads.checkForCancel();
        AtomicReference<ShardRouting> targetShardRouting = new AtomicReference<>();
        final Closeable releaseResources = () -> IOUtils.close(resources);
                final long existingTotalSize = existingTotalSizeInBytes;
        if (sourceSeqNos.localCheckpoint != targetSeqNos.localCheckpoint || targetSeqNos.maxSeqNo != sourceSeqNos.maxSeqNo) {
                    + "of docs differ: "
                    listener.onResponse(clonedLease);
import org.opensearch.core.common.unit.ByteSizeValue;
            stopWatch.stop();
                sendFileResult.took.millis(),
                cancellableThreads.checkForCancel();
        }
                if (beforeCancelEx != null) {
        final AtomicBoolean closed = new AtomicBoolean(false);
            assert Transports.assertNotTransportThread("[phase2]");
                // Total size of segment files that were able to be re-used
            retentionLeases,
 * the Apache License, Version 2.0 (the "License"); you may
            }
            throw new IllegalStateException(
                final Store.RecoveryDiff diff = recoverySourceMetadata.recoveryDiff(request.metadataSnapshot());
import org.opensearch.index.store.Store;
        return Releasables.releaseOnce(() -> runWithGenericThreadPool(store::decRef));
        final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = transferHandler.createTransfer(
import java.util.concurrent.CopyOnWriteArrayList;
                runWithGenericThreadPool(wrappedSafeCommit::close);
                    );
        Store.MetadataSnapshot sourceMetadata,
        IntSupplier translogOps,
        // the files after they have been renamed.
                })
        final long existingTotalSize;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    /**
        int maxConcurrentFileChunks,
                            phase1FileNames,
     */
                sendFileResult.phase1ExistingFileSizes,
    }
                    phase1ExistingFileNames.size(),
                    logger.info("Snapshot differs from actual index for file: {} meta: {}", name, recoverySourceMetadata.asMap());
            threadPool,
                }
     * An operation chunk request
                    cancellableThreads.execute(recoveryTarget::forceSegmentFileSync);
import org.opensearch.common.util.concurrent.FutureUtils;
            sourceMetadata,
        final List<Long> phase1ExistingFileSizes;
import org.opensearch.common.logging.Loggers;
                }
 */
import org.opensearch.action.ActionRunnable;
                        : () -> {};
 * operations across the wire once the segments have been copied.
        }
     */
                    phase1FileNames,
            logger
                createRetentionLease(startingSeqNo, createRetentionLeaseStep);
                    } else {
                retentionLeases,
                        );
        );
            } else {
            Collections.emptyList(),
            + request.targetNode()
                sendFileResult.phase1FileNames,
    }
        this.shardId = this.request.shardId().id();
        final long targetLocalCheckpoint;
        }
            cancellableThreads,
        recoveryTarget.prepareForTranslogOperations(totalTranslogOps, wrappedListener);
        while (backoffDelayIterator.hasNext()) {
            final List<Translog.Operation> ops = lastBatchCount > 0 ? new ArrayList<>(lastBatchCount) : new ArrayList<>();
                 */
                final List<Long> phase1ExistingFileSizes = new ArrayList<>();
                if (shard.indexSettings().isSegRepEnabledOrRemoteNode()) {
                    sendFilesStep.whenComplete(r -> {
            shardId + " marking " + request.targetAllocationId() + " as in sync",
                cancellableThreads,
                    throw new IndexShardClosedException(request.shardId());
         */
                        logger.trace(
            this.maxSeqNoOfUpdatesOrDeletes = maxSeqNoOfUpdatesOrDeletes;
                    final TimeValue took = stopWatch.totalTime();
     * <p>
            logger.trace("cloning primary's retention lease");
                ArrayUtil.timSort(mds, Comparator.comparingLong(StoreFileMetadata::length)); // check small files first
        @Override
            finalizeRecovery(r.targetLocalCheckpoint, trimAboveSeqNo, finalizeStep);
    private final RecoveryTargetHandler recoveryTarget;
    }
    // Request containing source and target node information
                maxSeenAutoIdTimestamp,
                StoreFileMetadata[] mds = StreamSupport.stream(sourceMetadata.spliterator(), false).toArray(StoreFileMetadata[]::new);
        return new GatedCloseable<>(wrappedSafeCommit.get(), () -> {
            List<Long> phase1FileSizes,
                if (batchSizeInBytes >= chunkSizeInBytes) {
        final Translog.Snapshot snapshot,
                // check if this request is past bytes threshold, and if so, send it off
    private final int chunkSizeInBytes;
        store.incRef();
                IOUtils.close(resources);
        StepListener<TimeValue> prepareEngineStep,
            try {
                    );
            recoveryTarget,
import java.util.concurrent.atomic.AtomicReference;
    }
                    sendFiles(store, phase1Files.toArray(new StoreFileMetadata[0]), translogOps, sendFilesStep);
            0L,
                    + request.shardId()
            maxConcurrentFileChunks
                ops.add(operation);
                    listener.onResponse(
import org.opensearch.index.seqno.SequenceNumbers;
                    e = new IndexShardClosedException(shard.shardId(), "shard is closed and recovery was canceled reason [" + reason + "]");
        );
        final PlainActionFuture<Void> future = new PlainActionFuture<>();
import org.opensearch.indices.RunUnderPrimaryPermit;
            IOUtils.close(wrappedSafeSnapshot, releaseStore);
            long batchSizeInBytes = 0L;
                }
import org.opensearch.common.util.CancellableThreads;
    void phase1(
        private final AtomicInteger skippedOps = new AtomicInteger();
                }
 *
                createRetentionLeaseStep.whenComplete(retentionLease -> {
    }
            recoveryTarget.indexTranslogOperations(
 * specific language governing permissions and limitations
        }, e -> {
                sendSnapshotResult.tookTime.millis()
                sendSnapshotResult.sentOperations,
                    new ByteSizeValue(totalSizeInBytes),
                        logger.trace("recovery [phase1]: recovering [{}], does not exist in remote", md.name());
            logger.info("finalizing recovery took [{}]", stopWatch.totalTime());
        recoveryTarget.cleanFiles(
     */
                            took
            StopWatch stopWatch = new StopWatch().start();
     */
        Store store,
 * while the {@link RateLimiter} passed via {@link RecoverySettings} is shared across recoveries
            + ", sourceNode="
        return true;
            );
                // this acquires all IndexShard operation permits and will thus delay new recoveries until it is done
        final GatedCloseable<CatalogSnapshot> wrappedSafeSnapshot = shard.acquireSafeCatalogSnapshot();
import org.opensearch.index.seqno.RetentionLeases;
    }
        this.request = request;
import org.apache.lucene.index.IndexFormatTooNewException;
            cancellableThreads.setOnCancel((reason, beforeCancelEx) -> {
            while ((operation = snapshot.next()) != null) {
    public String toString() {
        StepListener<SendSnapshotResult> sendSnapshotStep,
                        request.targetNode()
                            md.name(),
                    phase1FileSizes,
        GatedCloseable<CatalogSnapshot> wrappedSafeSnapshot,
            List<String> phase1FileNames,
                            phase1FileSizes,
    /*
     * @opensearch.internal
            } catch (final IOException ex) {
                 * if the recovery process fails after disabling primary mode on the source shard, both relocation source and
                cancellableThreads.execute(
            }
        // Once the files have been renamed, any other files that are not
 * originating from this nodes to throttle the number bytes send during file transfer. The transaction log
     * Increases the store reference and returns a {@link Releasable} that will decrease the store reference using the generic thread pool.
            + "shardId="
        final StopWatch stopWatch = new StopWatch().start();
 * this work for additional information regarding copyright
                logger.trace("cloned primary's retention lease as [{}]", clonedLease);
     * checksum can be reused.
import org.opensearch.transport.Transports;
import java.util.Iterator;
                    // Establishes new empty translog on the replica with global checkpoint set to lastKnownGlobalCheckpoint. We want
        } catch (Exception e) {
                        );
    }
        final AtomicBoolean closed = new AtomicBoolean(false);
        long globalCheckpoint,
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.index.translog.Translog;
                            totalSize,
     * performs the recovery from the local engine to the target
        StartRecoveryRequest request,
import org.opensearch.common.concurrent.GatedCloseable;
    /**
import org.apache.lucene.index.CorruptIndexException;
                        logger.debug("sendFilesStep completed");
                    logger.debug("sendFileInfoStep completed");
import org.apache.lucene.util.ArrayUtil;
                skippedOps,
 * under the License.
     * Cancels the recovery and interrupts all eligible threads.
            logger.trace("recovery [phase2]: took [{}]", tookTime);
    }
            );
                List<StoreFileMetadata> phase1Files = new ArrayList<>(diff.different.size() + diff.missing.size());
     * has been acquired no commit operations (files being fsync'd) are effectively
        RunUnderPrimaryPermit.run(
                final Runnable forceSegRepRunnable = shard.indexSettings().isSegRepEnabledOrRemoteNode()
                // TODO: make relocated async
        }, onFailure);
import java.io.IOException;
                final StepListener<ReplicationResponse> cloneRetentionLeaseStep = new StepListener<>();
    /**
            // (approximately) because we do not guarantee to be able to satisfy every lease on every peer.
                shardId + " updating " + request.targetAllocationId() + "'s global checkpoint",
 * Unless required by applicable law or agreed to in writing,
            long startingSeqNo,
            + '}';
                if (shard.state() == IndexShardState.CLOSED) {
        final TimeValue tookTime;
                final StepListener<RetentionLease> createRetentionLeaseStep = new StepListener<>();
        }, e -> listener.onFailure(new RecoveryEngineException(shard.shardId(), 1, "prepare target for translog failed", e)));
                }, listener::onFailure);
            logger.debug("sendFileStep completed");
                final StepListener<Void> sendFileInfoStep = new StepListener<>();
    protected boolean isTargetSameHistory() {
 * RecoverySourceHandler handles the three phases of shard recovery, which is
            }
        @Override
            Translog.Snapshot snapshot,
                final List<Long> phase1FileSizes = new ArrayList<>();
            // the recovery now fails before copying enough history over then a subsequent attempt will find this lease, determine it is
        future.addListener(listener, OpenSearchExecutors.newDirectExecutorService());
            if (closed.compareAndSet(false, true)) {
        transfer.start();
import org.opensearch.index.store.StoreFileMetadata;
                logger.trace(
                    + "("
            ActionListener<Void> listener
            final SendSnapshotResult sendSnapshotResult = sendSnapshotStep.result();
                    new ThreadedActionListener<>(logger, shard.getThreadPool(), ThreadPool.Names.GENERIC, addRetentionLeaseStep, false)
 * everything relating to copying the segment files as well as sending translog
            });
    void phase2(
    protected final StartRecoveryRequest request;
        try {
            return;
                sentOps.incrementAndGet();
                            md.name(),
import org.opensearch.common.SetOnce;
        @Override
                }
     * Handles cleanup after the file-sending step completes (success or failure): closes the
                            Collections.emptyList(),
    @Deprecated
                        logger.debug("sendFilesStep completed");
                batchSizeInBytes += operation.estimateSize();
    /**
        }
        final long mappingVersion,
        private final RetentionLeases retentionLeases;
        StepListener<SendFileResult> sendFileStep,
    protected Releasable acquireStore(Store store) {
        Consumer<Exception> onFailure
                    sendFileInfoStep
     *
                totalSentOps
import java.util.function.IntSupplier;
                        name
    public void cancel(String reason) {
                prepareEngineStep.result().millis(),
            );
            this.operations = operations;
        final long maxSeqNoOfUpdatesOrDeletes,
                final IndexShardRoutingTable routingTable = shard.getReplicationGroup().getRoutingTable();
     * @param startingSeqNo the starting sequence number to count; included
        ) {
                logger
            }
        final Store store = shard.store();
        final long totalSize;
                }, listener::onFailure);
        long startingSeqNo,
            this.phase1ExistingFileNames = phase1ExistingFileNames;
     */
        addListener(listener);
                    skippedOps.incrementAndGet();
                recoverySourceMetadata = store.getMetadata(snapshot);
                IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
        this.threadPool = threadPool;
        OperationBatchSender(
            request.targetNode(),
        FutureUtils.get(future);
            try {
                            md.checksum(),
                    phase1FileNames.size(),
    }
            this.endingSeqNo = endingSeqNo;
        });
            cancellableThreads.checkForCancel();
     * <p>
        );
                    if (request.metadataSnapshot().asMap().containsKey(md.name())) {
    }
        this.maxConcurrentOperations = maxConcurrentOperations;
     * {@link CatalogSnapshot}. Callers must close the returned handle to release refs.
                    l.onResponse(null);
    /**
        final long endingSeqNo,
                IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
                            + recoverySourceMetadata.asMap().size()
                // but we must still create a retention lease
     * recovery paths.
                addRetentionLeaseStep.whenComplete(rr -> {
    void prepareTargetForTranslog(int totalTranslogOps, ActionListener<TimeValue> listener) {
            this.lastChunk = lastChunk;
     * @param snapshot                   a snapshot of the translog
    /**
                }
        private final AtomicInteger sentOps = new AtomicInteger();
                    phase1ExistingFileSizes,
                    + request.targetNode().getName()
        finalizeStep.whenComplete(r -> {
 * You may obtain a copy of the License at
            final Consumer<Exception> onFailure = e -> {
        protected synchronized OperationChunkRequest nextChunkRequest(Translog.Snapshot snapshot) throws IOException {
                + "seq_no stats are mismatched: ["
                logger.trace("skipping [phase1] since source and target have identical sync id [{}]", recoverySourceMetadata.getSyncId());
                snapshot.skippedOperations(),
    protected final Logger logger;
        // if the target is on an old version, it won't be able to handle out-of-order file chunks.
                    }, listener::onFailure);
 * license agreements. See the NOTICE file distributed with
            this.phase1FileNames = phase1FileNames;
            if (request.isPrimaryRelocation()) {
    private final SegmentFileTransferHandler transferHandler;
            final int totalSentOps = sender.sentOps.get();
import org.opensearch.index.shard.IndexShardClosedException;
                long totalSizeInBytes = 0;
     * with the file systems due to interrupt (see {@link org.apache.lucene.store.NIOFSDirectory} javadocs for more detail).
                snapshot.totalOperations(),
        }
        // Send a request preparing the new shard's translog to receive operations. This ensures the shard engine is started and disables
                );
 * ownership. Elasticsearch licenses this file to you under
            );
        assert targetHistoryUUID != null : "incoming target history missing";
                    logger.debug("addRetentionLeaseStep completed");
import org.opensearch.action.support.replication.ReplicationResponse;
            0L,
import java.util.List;
            // We need to synchronized Snapshot#next() because it's called by different threads through sendBatch.
 *    http://www.apache.org/licenses/LICENSE-2.0
                final StepListener<RetentionLease> createRetentionLeaseStep = new StepListener<>();
import java.util.function.Consumer;
                sendFileInfoStep.whenComplete(r -> {
            this.sentOperations = sentOperations;
            listener.onResponse(tookTime);
import org.apache.lucene.index.IndexCommit;
     * allowed on this index until all recovery phases are done.
                // When doing peer recovery of remote store enabled replica, retention leases are not required.
     * @param startingSeqNo              the sequence number to start recovery from, or {@link SequenceNumbers#UNASSIGNED_SEQ_NO} if all
                final RetentionLease newLease = shard.addPeerRecoveryRetentionLease(
                            0L,
            this.snapshot = snapshot;
        logger.trace("finalizing recovery");
                        "delaying recovery of {} as it is not listed as assigned to target node {}",
        assert threadPool.generic().isShutdown() == false;
         * shard as in-sync and relocating a shard. If we acquire the permit then no relocation handoff can complete before we are done
import java.util.Collections;
                    );
        final List<String> phase1ExistingFileNames;
            logger.debug("sendSnapshotStep completed");
                    new ThreadedActionListener<>(logger, shard.getThreadPool(), ThreadPool.Names.GENERIC, cloneRetentionLeaseStep, false)
     *
    }
        if (source.getSyncId() == null || source.getSyncId().equals(target.getSyncId()) == false) {
                shard,
     * Phase two uses a snapshot of the current translog *without* acquiring the write lock (however, the translog snapshot is
                            existingTotalSize,
import org.opensearch.cluster.routing.ShardRouting;
import java.util.stream.StreamSupport;
    }
    }
                phase1Files.addAll(diff.missing);
import org.opensearch.common.util.io.IOUtils;
                // segment files on the target node, using the existing files on
 */
        StepListener<SendFileResult> sendFileStep,
        // related to this recovery (out of date segments, for example)
 * this file be licensed under the Apache-2.0 license or a
        //
            Collections.emptyList(),
 * phase bypasses the rate limiter entirely.
            };
            TimeValue took
import java.util.ArrayList;
        final StepListener<Void> finalizeStep = new StepListener<>();
                final List<String> phase1ExistingFileNames = new ArrayList<>();
            RunUnderPrimaryPermit.run(
    ) {
        }
                    logger.trace("recovery [phase1]: took [{}]", took);
     *
        StopWatch stopWatch = new StopWatch().start();
                            0L,
        );
            // existing lease we (approximately) know that all our peers are also retaining history as requested by the cloned lease. If
                + " with sync id but "
        }
        });
/*
                phase1ThrottlingWaitTime,
                    phase1FileSizes.add(md.length());
                        )
     * @opensearch.internal
        @Override
            files,
            store,
                ActionListener.delegateFailure(listener, (l, newCheckpoint) -> {
                    // the primary, and in these cases the max seqno would be too high to be valid as a global checkpoint.
            listener.onResponse(null);
                logger.trace("performing relocation hand-off");
                } else {
            TimeValue.ZERO
                final long seqNo = operation.seqNo();
            List<Long> phase1ExistingFileSizes,
 * software distributed under the License is distributed on an
            final Store.MetadataSnapshot recoverySourceMetadata;
    }
                if (shard.state() == IndexShardState.CLOSED) { // check if the shard got closed on us
        final long startingSeqNo,
                            "recovery [phase1]: not recovering [{}], exist in local store and has checksum [{}]," + " size [{}]",
                maxSeqNoOfUpdatesOrDeletes,
                // the source node
                    e.addSuppressed(beforeCancelEx);
    /**
    // Shard that is going to be recovered (the "source")
                    phase1ExistingFileNames.add(md.name());
         * marking the shard as in-sync. If the relocation handoff holds all the permits then after the handoff completes and we acquire
            final String message = "try to recover "
                        logger.trace(
                logger.trace("created retention lease with estimated checkpoint of [{}]", estimatedGlobalCheckpoint);
                    + target.getNumDocs()
    protected final CancellableThreads cancellableThreads = new CancellableThreads();
    /**
        }
    private void runWithGenericThreadPool(CheckedRunnable<Exception> task) {
import org.opensearch.index.shard.IndexShardState;
                }, listener::onFailure);
                createRetentionLeaseStep.whenComplete(retentionLease -> {
            this.startingSeqNo = startingSeqNo;
    private void cleanFiles(
        RunUnderPrimaryPermit.run(() -> {
        // Send the CLEAN_FILES request, which takes all of the files that
            //
    protected int countNumberOfHistoryOperations(long startingSeqNo) throws IOException {
package org.opensearch.indices.recovery;
                sendFileResult.phase1FileSizes,
            );
        final GatedCloseable<IndexCommit> wrappedSafeCommit = shard.acquireSafeIndexCommit();
                + "] vs ["
                    throw new CorruptIndexException(
                        shard.getRetentionLeases().get(ReplicationTracker.getPeerRecoveryRetentionLeaseId(targetShardRouting.get()))
        }
    /**
            } catch (RetentionLeaseNotFoundException e) {
        final List<Translog.Operation> operations;
    /**
                if (seqNo < startingSeqNo || seqNo > endingSeqNo) {
                    }
            }
        }, listener::onFailure);
import java.util.Comparator;
                    phase1FileNames.add(md.name());
                /*
            throw new IndexShardClosedException(request.shardId());
        threadPool.generic().execute(ActionRunnable.run(future, task));
                "try to recover "
        IntSupplier translogOps,
            this.totalSize = totalSize;
        // TODO: We shouldn't use the generic thread pool here as we already execute this from the generic pool.
                final long totalSize = totalSizeInBytes;
    protected final IndexShard shard;
                    final TimeValue took = stopWatch.totalTime();
import org.opensearch.index.seqno.RetentionLease;
import org.opensearch.core.action.ActionListener;
 * The OpenSearch Contributors require contributions made to
    /**
        // are deleted
    protected GatedCloseable<IndexCommit> acquireSafeCommit(IndexShard shard) {
                sendFileResult.phase1ExistingFileNames,
        private final AtomicLong targetLocalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                IOUtils.close(wrappedSafeSnapshot, releaseStore);
        static final SendFileResult EMPTY = new SendFileResult(
            throw new RecoveryEngineException(shard.shardId(), 2, "failed to send/replay operations", e);
            long endingSeqNo,
     * A result for a send snapshot
        boolean skipCreateRetentionLeaseStep
        int maxConcurrentOperations
     * Perform phase two of the recovery process.
            this.phase1ExistingFileSizes = phase1ExistingFileSizes;
        // Recovery target can trim all operations >= startingSeqNo as we have sent all these operations in the phase 2
import org.opensearch.common.unit.TimeValue;
        this.chunkSizeInBytes = fileChunkSizeInBytes;
/**
        long startingSeqNo,
            startingSeqNo,
            this.retentionLeases = retentionLeases;
import org.apache.logging.log4j.Logger;
        // garbage collection (not the JVM's GC!) of tombstone deletes.
                + request.shardId()
        final boolean lastChunk;
            return new OperationChunkRequest(ops, operation == null);
        // below and thus make it impossible for the store release to execute which in turn would block the futures forever
    ) {
        final ActionListener<SendSnapshotResult> listener
                cancellableThreads,
                sendFileResult.totalSize,
    static final class SendFileResult {
                    totalSizeInBytes += md.length();
    void finalizeRecovery(long targetLocalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) throws IOException {
            if (targetShardRouting.get() != null) {
    void sendFiles(Store store, StoreFileMetadata[] files, IntSupplier translogOps, ActionListener<Void> listener) {
    }
 * @opensearch.internal
        sendSnapshotStep.whenComplete(r -> {
    /**
        SequenceNumbers.CommitInfo targetSeqNos = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(target.getCommitUserData().entrySet());
        RecoveryTargetHandler recoveryTarget,
                transferHandler.handleErrorOnSendFiles(store, e, mds);
        final int sentOperations;
            if (canSkipPhase1(recoverySourceMetadata, request.metadataSnapshot()) == false) {
        StopWatch stopWatch = new StopWatch().start();
import org.apache.lucene.store.RateLimiter;
     */
    protected final List<Closeable> resources = new CopyOnWriteArrayList<>();
        Iterator<TimeValue> backoffDelayIterator = EXPONENTIAL_BACKOFF_POLICY.iterator();
    public void addListener(ActionListener<RecoveryResponse> listener) {
    protected void finalizeStepAndCompleteFuture(
import org.opensearch.index.seqno.ReplicationTracker;
                if (md == null) {
    private final int maxConcurrentOperations;
    protected GatedCloseable<CatalogSnapshot> acquireSafeCatalogSnapshot(IndexShard shard) {
     * Phase1 examines the segment files on the target node and copies over the
            final SendFileResult sendFileResult = sendFileStep.result();
        ActionListener<SendFileResult> listener,
            RetentionLeases retentionLeases,
        }
                            Collections.emptyList(),
    }
                    new ByteSizeValue(existingTotalSizeInBytes)
     * Same thread-pool-close semantics as {@link #acquireSafeCommit(IndexShard)}, but returns a
    }
        );
        }, shardId + " establishing retention lease for [" + request.targetAllocationId() + "]", shard, cancellableThreads, logger);
                final StoreFileMetadata md = recoverySourceMetadata.get(name);
                    "recovery [phase1]: recovering_files [{}] with total_size [{}], reusing_files [{}] with total_size [{}]",
                throw e;
        BackoffPolicy EXPONENTIAL_BACKOFF_POLICY = BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(1000), 5);
        private final long maxSeqNoOfUpdatesOrDeletes;
     * Releasing a safe commit can access some commit files. It's better not to use {@link CancellableThreads} to interact
import org.opensearch.action.support.ThreadedActionListener;
                return;
                    );
import org.opensearch.common.StopWatch;
                    // the commit we just copied to be a safe commit on the replica, so why not set the global checkpoint on the replica
                shardId + " validating recovery target [" + request.targetAllocationId() + "] registered ",
                // it's possible that the primary has no retention lease yet if we are doing a rolling upgrade from a version before
        }
                    );
                            Collections.emptyList(),
        public boolean lastChunk() {
        }
            }
        final StepListener<Void> finalizeListener = new StepListener<>();
        Releasable releaseStore
            );
        private final long endingSeqNo;
    public static final String PEER_RECOVERY_NAME = "peer-recovery";
                    request.targetNode().getId(),
            final RecoveryResponse response = new RecoveryResponse(
                () -> shard.updateGlobalCheckpointForShard(request.targetAllocationId(), globalCheckpoint),
        private final long startingSeqNo;
        );
import org.opensearch.index.engine.RecoveryEngineException;
import java.util.concurrent.atomic.AtomicInteger;
                 * target are failed (see {@link IndexShard#updateRoutingEntry}).
        SendFileResult(
        final OperationBatchSender sender = new OperationBatchSender(
 */
                if (targetShardRouting.get() == null) {
                            phase1ExistingFileNames,
 * SPDX-License-Identifier: Apache-2.0
    ) {
        final long globalCheckpoint = shard.getLastKnownGlobalCheckpoint(); // this global checkpoint is persisted in finalizeRecovery
                            md.length()
            // Clone the peer recovery retention lease belonging to the source shard. We are retaining history between the local
                );
                mappingVersion,
import org.opensearch.threadpool.ThreadPool;
import java.util.Locale;
            endingSeqNo,
                        : retentionLease + " vs " + lastKnownGlobalCheckpoint;
import org.opensearch.index.shard.IndexShard;
     * This method acquires a safe commit and wraps it to make sure that it will be released using the generic thread pool.
            throw new IllegalStateException(message);
                // 7.4, and in that case we just create a lease using the local checkpoint of the safe commit which we're using for
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                    final long lastKnownGlobalCheckpoint = shard.getLastKnownGlobalCheckpoint();
                final RetentionLease clonedLease = shard.cloneLocalPeerRecoveryRetentionLease(
                    if (logger.isTraceEnabled()) {
                            phase1ExistingFileSizes,
                    logger.debug("cleanFilesStep completed");
            this.phase1FileSizes = phase1FileSizes;
            () -> shard.markAllocationIdAsInSync(request.targetAllocationId(), targetLocalCheckpoint),
 * GitHub history for details.
        final List<Long> phase1FileSizes;
     *
     */
                    cleanFiles(store, recoverySourceMetadata, translogOps, lastKnownGlobalCheckpoint, cleanFilesStep);
                    assert retentionLease == null || retentionLease.retainingSequenceNumber() - 1 <= lastKnownGlobalCheckpoint
        }
                    Thread.sleep(backoffDelayIterator.next().millis());
    }
                }
                    request.targetNode().getId(),
        final long maxSeenAutoIdTimestamp,
                future.onResponse(response);
    void createRetentionLease(final long startingSeqNo, ActionListener<RetentionLease> listener) {
        cancellableThreads.cancel(reason);
            logger.debug("finalizeStep completed");
                final List<String> phase1FileNames = new ArrayList<>();
        ThreadPool threadPool,
import org.opensearch.common.CheckedRunnable;
            cancellableThreads.checkForCancel();
                        request.shardId(),
        });
     * @param listener                   a listener which will be notified with the local checkpoint on the target.
        cancellableThreads.checkForCancel();
                "expected total [%d], overridden [%d], skipped [%d], total sent [%d]",
            Translog.Operation operation;
            }
        try {
            shard,
                );
                            md
                }
                    break;
        sendListener.whenComplete(ignored -> {
            + request.sourceNode()
                    () -> shard.relocated(request.targetAllocationId(), recoveryTarget::handoffPrimaryContext, forceSegRepRunnable)
                            request.metadataSnapshot().asMap().get(md.name()),
        // names to the actual file names. It also writes checksums for
        } catch (Exception e) {
            final long skippedOps = sender.skippedOps.get();
        final RetentionLeases retentionLeases,
        CatalogSnapshot snapshot,
            + ", targetNode="
}
            translogOps.getAsInt(),
                + source.getCommitUserData()
                        new SendFileResult(
                // recovery as a conservative estimate for the global checkpoint.
            IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
                        new SendFileResult(
                    retentionLeaseRef.set(
     * We must never release the store using an interruptible thread as we can risk invalidating the node lock.
                    continue;
    public void recoverToTarget(ActionListener<RecoveryResponse> listener) {
                } else {
        }
        return shard.countNumberOfHistoryOperations(PEER_RECOVERY_NAME, startingSeqNo, Long.MAX_VALUE);
        // were transferred and renames them from their temporary file
        private final Translog.Snapshot snapshot;
        throws IOException;
                            took
        int fileChunkSizeInBytes,
            ActionListener.delegateResponse(listener, (l, e) -> ActionListener.completeWith(l, () -> {
        private final long mappingVersion;
    private final ThreadPool threadPool;
     * Counts the number of history operations from the starting sequence number
            return lastChunk;
                    logger.trace("recovery [phase1]: took [{}]", took);
            throw new RecoverFilesRecoveryException(request.shardId(), 0, new ByteSizeValue(0L), e);
                logger
            for (String name : snapshot.getFiles(true)) {
        SendSnapshotResult(final long targetLocalCheckpoint, final int sentOperations, final TimeValue tookTime) {
        }, listener::onFailure);
         * the permit then the state of the shard will be relocated and this recovery will fail.
import java.util.concurrent.atomic.AtomicLong;
                }
                    existingTotalSizeInBytes += md.length();
    }
                }, listener::onFailure);
            long totalSize,
                if (skipCreateRetentionLeaseStep) {
     * @return number of history operations
        if (shard.state() == IndexShardState.CLOSED) {
        }
                shard,
     * @opensearch.internal
                        createRetentionLeaseStep.onResponse(null);
                throw e;
        if (targetShardRouting.get() != null) {
     * segments that are missing. Only segments that have the same size and
                    estimatedGlobalCheckpoint,
            }
     */
 */
        }
        recoveryTarget.cancel();
                            + " files",
        final TimeValue took;
                + "]";
    public StartRecoveryRequest getRequest() {
                        ? recoveryTarget::forceSegmentFileSync
import org.opensearch.action.bulk.BackoffPolicy;
                targetShardRouting.set(routingTable.getByAllocationId(request.targetAllocationId()));
     */
            logger.trace("recovery [phase1]: remote engine start took [{}]", tookTime);
        protected void handleError(Translog.Snapshot snapshot, Exception e) {
                assert shard.indexSettings().isSoftDeleteEnabled() == false;
            long maxSeenAutoIdTimestamp,
        return "ShardRecoveryHandler{"
import org.opensearch.common.util.concurrent.ListenableFuture;
     *                                   ops should be sent
                throw ex;
            final long targetLocalCheckpoint = sender.targetLocalCheckpoint.get();
     * @param maxSeqNoOfUpdatesOrDeletes the max seq_no of updates or deletes on the primary after these operations were executed on it.
        ) {
                final StepListener<Void> cleanFilesStep = new StepListener<>();
            listener.onResponse(new SendSnapshotResult(targetLocalCheckpoint, totalSentOps, tookTime));
        SequenceNumbers.CommitInfo sourceSeqNos = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(source.getCommitUserData().entrySet());
 * compatible open source license.
 *
                    logger.info(
    private class OperationBatchSender extends MultiChunkTransfer<Translog.Snapshot, OperationChunkRequest> {
            sendListener
                assert Transports.assertNotTransportThread(this + "[onFailure]");
        return targetHistoryUUID.equals(shard.getHistoryUUID());
        logger.trace("recovery [phase2]: sending transaction log operations (from [" + startingSeqNo + "] to [" + endingSeqNo + "]");
            this.tookTime = tookTime;
            // Even though those calls are not concurrent, Snapshot#next() uses non-synchronized state and is not multi-thread-compatible.
                logger.warn("releasing snapshot caused exception", ex);
            this.mappingVersion = mappingVersion;
    ) {
     *
 *
                runWithGenericThreadPool(wrappedSafeSnapshot::close);
                );
                final StepListener<ReplicationResponse> addRetentionLeaseStep = new StepListener<>();
            listener
            globalCheckpoint,
            try {
            }
            fileChunkSizeInBytes,
            + request.shardId()
     */
                snapshot.totalOperations(),
            return false;
            RunUnderPrimaryPermit.run(() -> {
        finalizeListener.whenComplete(r -> {
 * file and translog transfer. This handler is completely isolated from other recoveries
    private static class OperationChunkRequest implements MultiChunkTransfer.ChunkRequest {
                    + " from primary shard with sync id but number "
        @Override
        final StepListener<Void> sendListener = new StepListener<>();
        IndexShard shard,
            snapshot.close();
            this.targetLocalCheckpoint = targetLocalCheckpoint;
        /*
                shard.failShard("recovery", ex);
    protected abstract void innerRecoveryToTarget(ActionListener<RecoveryResponse> listener, Consumer<Exception> onFailure)
        logger.trace("recovery [phase1]: prepare remote engine for translog");
/*
            super(logger, threadPool.getThreadContext(), listener, maxConcurrentOperations, Collections.singletonList(snapshot));
                    sendFilesStep.whenComplete(r -> {
                final RuntimeException e;
import org.opensearch.common.lease.Releasables;
        this.recoveryTarget = recoveryTarget;
     * safe snapshot handle and releases the store reference. Used by both local and remote
                for (StoreFileMetadata md : phase1Files) {
            mappingVersion,
import org.apache.lucene.index.IndexFormatTooOldException;
import org.opensearch.indices.replication.SegmentFileTransferHandler;
                    + ", primary) vs "
/*
            lastBatchCount = ops.size();
 * Note: There is always one source handler per recovery that handles all the
            translogOps,
                );
        protected void executeChunkRequest(OperationChunkRequest request, ActionListener<Void> listener) {
                    }
    @Override
            maxSeenAutoIdTimestamp,
            }))
