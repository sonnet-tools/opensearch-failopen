            throw e;
        LongSupplier globalCheckpointSupplier,
        if (fence != null) {
        );
    private final Supplier<LocalCheckpointTracker> localCheckpointTrackerSupplier;
            }
    public long getLastSyncedGlobalCheckpoint() {
                tracker.markSeqNoAsPersisted(seqNo);
            translog.trimUnreferencedReaders();
     * @see Translog#trimOperations(long, long)
        translogEventListener.onAfterTranslogSync();
    }
            return false;
    /*
    }
    }
        translogEventListener.onAfterTranslogRecovery();
    public Translog.Snapshot newChangesSnapshot(long fromSeqNo, long toSeqNo, boolean requiredFullRange) throws IOException {
        return fence == null || fence.revertFenceOwnership();
        try (ReleasableLock ignored = readLock.acquire()) {
    @Override
     * @throws IOException throws an IO exception
        if (localCheckpoint < recoverUpToSeqNo) {
                translog.currentFileGeneration()
        LongSupplier primaryTermSupplier,
            engineLifeCycleAware.ensureOpen();
    private final Translog translog;
            throw new TranslogException(shardId, "failed to trim unreferenced translog translog", e);
        // This is the minimum seqNo that is referred in translog and considered for calculating translog size
         * When the local checkpoint equals to max_seqno, and translog-gen of the last commit equals to translog-gen of
    public void rollTranslogGeneration() throws TranslogException, IOException {
            translog.trimOperations(belowTerm, aboveSeqNo);
        /*
        TranslogDeletionPolicy translogDeletionPolicy,
    @Override
    @Override
        return translog.isOpen() == false ? translog.getTragicException() : null;
import org.opensearch.common.logging.Loggers;
     */
import org.opensearch.index.engine.LifecycleAware;
        return translog.newSnapshot(fromSeqNo, toSeqNo, requiredFullRange);
    }
        logger.trace(
        } catch (TranslogUploadFailedException e) {
            }
    /**
        translog.setMinSeqNoToKeep(seqNo);
            persistedSequenceNumberConsumer,
     * @param operation operation to add to translog
        String translogUUID,
        return translog.getDeletionPolicy();
    }
/*
        translogEventListener.onBeginTranslogRecovery();
     * @return the uuid of the translog
            opsRecovered = 0;
     *
        }
    public void setMinSeqNoToKeep(long seqNo) {
    /**
    /**
     * for each answer, rather than by defaults on the shared Translog base. IndexShard additionally gates these on the
        final int opsRecovered;
        this.translog = translog;
    /**
        }
     * Syncs the translog and invokes the listener
                e.addSuppressed(inner);
    public void trimUnreferencedTranslogFiles() throws TranslogException {
            translogEventListener.onFailure("translog trimming unreferenced translog failed", e);
        return translog.getTranslogUUID();
            throw e;
         */
    }
     * @return the location in the translog
    @Override
        translog.trimUnreferencedReaders();
        }
        ReleasableLock readLock,
    /**
            translogEventListener.onFailure("translog roll generation failed", e);
    /**
 * compatible open source license.
     * Returns the last location that the translog of this engine has written into.
            translogUUID,
    /**
        pendingTranslogRecovery.set(false); // we are good - now we can commit
     * @return the total number of operations recovered
        /*
                    translogEventListener.onFailure("failed to recover from translog", e);
import org.opensearch.index.seqno.LocalCheckpointTracker;
    private final TranslogEventListener translogEventListener;
     * @throws IOException throws an IO exception
     * Trims translog for terms below <code>belowTerm</code> and seq# above <code>aboveSeqNo</code>
     * @return the translog operation
        return getTranslog(true).syncNeeded();
     * Ensures that the flushes can succeed if there are no pending translog recovery
    @Override
    private final Logger logger;
     * @return the tragic exception
    public TranslogDeletionPolicy getDeletionPolicy() {
 * SPDX-License-Identifier: Apache-2.0
     */
    }
        LongConsumer persistedSequenceNumberConsumer,
        TranslogConfig translogConfig,
     */
        return translogFactory.newTranslog(
    /**
    }
         * commit points to the later generation the last commit's(eg. gen-of-last-commit < gen-of-new-commit)[1].
     * on every call. Safe to hold because {@link #translog} is assigned once.
        } catch (Exception e) {
     * @throws IOException the exception on sync failure
    /**
     * Retrieves the translog unique identifier
        this.engineLifeCycleAware = engineLifeCycleAware;
        final long minReferencedTranslogGeneration = translog.getMinGenerationForSeqNo(minTranslogRefSeqNo).translogFileGeneration;
     */
         * happens when the generation-threshold is close to or above the flush-threshold; otherwise we have rolled
import org.opensearch.common.util.concurrent.ReleasableLock;
    /**
        return fence != null && fence.isRemoteStoreFenceSuperseded();
     * Fence operations, delegated when this translog has a fence. The absent case is answered here, beside the reason
        TranslogOperationHelper translogOperationHelper
    }
import org.opensearch.core.index.shard.ShardId;
    }
        TranslogEventListener translogEventListener,
        return translog.drainSync();
        translog.onDelete();
    /**
     */
        }
                try {
        LongSupplier globalCheckpointSupplier,
     * Checks if the underlying storage sync is required.
        assert pendingTranslogRecovery.get() == false : "translog recovery can't be pending before we set it";
        // engine otherwise we might loose documents if the flush succeeds
    public boolean shouldPeriodicallyFlush(long localCheckpointOfLastCommit, long flushThreshold) {
     */
    public Translog.TranslogGeneration getTranslogGeneration() {
     * @return if the translog should be flushed
        }
    @Override
        Translog translog = openTranslog(translogConfig, primaryTermSupplier, translogDeletionPolicy, globalCheckpointSupplier, seqNo -> {
     */
        }
import java.util.function.BooleanSupplier;
    }
            translog.trimUnreferencedReaders();
     * @return last synced global checkpoint
        } catch (AlreadyClosedException e) {
    }
                    pendingTranslogRecovery.set(true); // just play safe and never allow commits on this see #ensureCanFlush
import org.opensearch.common.util.io.IOUtils;
            try (Translog.Snapshot snapshot = getTranslog(true).newSnapshot(processedCheckpoint + 1, Long.MAX_VALUE)) {
    public void ensureCanFlush() {
     */
            } catch (Exception inner) {
        // flush if we recovered something or if we have references to older translogs
    private final AtomicBoolean pendingTranslogRecovery = new AtomicBoolean(false);
            startedPrimarySupplier,
    @Override
import java.util.function.Supplier;
 */
    @Override
     *  @param translogRecoveryRunner the translog recovery runner
        }
        }
        throws IOException {
    }
        return synced;
        try (ReleasableLock ignored = readLock.acquire()) {
            translogOperationHelper
        TranslogOperationHelper translogOperationHelper
        pendingTranslogRecovery.set(true);
     */
            )
                opsRecovered = translogRecoveryRunner.run(snapshot);
        assert translog.getGeneration() != null;
    @Override
    public Closeable acquireHistoryRetentionLock() {
     */
    }
    @Override
    }
    private final LifecycleAware engineLifeCycleAware;
     * @return {@code true} if the current generation should be rolled to a new generation
        return opsRecovered;
     * @return TranslogDeletionPolicy
            throw e;
 * the {@link org.opensearch.index.engine.InternalEngine}
    /**
            throw new TranslogException(shardId, "failed to trim translog operations", e);
            throw new IllegalStateException(shardId.toString() + " flushes are disabled - pending translog recovery");
        TranslogDeletionPolicy translogDeletionPolicy,
    @Override
     * Retrieves last synced global checkpoint
    }
        if (translog.sizeInBytesByMinGen(minReferencedTranslogGeneration) < flushThreshold) {
    public Translog.Operation readOperation(Translog.Location location) throws IOException {
        long minTranslogRefSeqNo = translog.getMinUnreferencedSeqNoInSegments(localCheckpointOfLastCommit + 1);
        return translog.readOperation(location);
            || localCheckpointTrackerSupplier.get().getProcessedCheckpoint() == localCheckpointTrackerSupplier.get().getMaxSeqNo();
import java.util.function.LongConsumer;
            // Do not trigger the translogEventListener as it fails the Engine while this is only an issue with remote upload
     *
        int opsRecovered = 0;
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
     * @param recoverUpToSeqNo       the upper bound, inclusive, of sequence number to be recovered
    // visible for testing
        // If we are in this stage we have to prevent flushes from this
import org.apache.lucene.store.AlreadyClosedException;
     * This method replays translog to restore the Lucene index which might be reverted previously.
        translog.sync();
            engineLifeCycleAware.ensureOpen();
    }
        return translog.add(operations);
    }
            }
            final LocalCheckpointTracker tracker = localCheckpointTrackerSupplier.get();
    private final ReleasableLock readLock;
            } catch (Exception inner) {
     */
    @Override
            }
    public void skipTranslogRecovery() {
        // and the translog recovery fails when we "commit" the translog on flush.
/**
        return translog.acquireRetentionLock();
        return getTranslog(true).shouldRollGeneration();
     * @param location location of translog
         * This can trigger flush depending upon translog's implementation
            translogEventListener.onFailure("translog operations trimming failed", e);
        }
        } catch (AlreadyClosedException e) {
        return translog.getLastSyncedGlobalCheckpoint();
            if (tracker != null) {
            assert tracker != null || getTranslog(true).isOpen() == false;
        final boolean synced = translog.ensureSynced(locations);
    private Translog getTranslog(boolean ensureOpen) {
         * This method is to maintain translog only, thus IndexWriter#hasUncommittedChanges condition is not considered.
            }
    }
    public long getMaxSeqNo() {
    public boolean revertFenceOwnership() throws IOException {
                } catch (Exception inner) {
        Supplier<LocalCheckpointTracker> localCheckpointTrackerSupplier,
    /**
        LifecycleAware engineLifeCycleAware,
        assert pendingTranslogRecovery.get() : "translogRecovery is not pending but should be";
    public void onDelete() {
        }
            try {
    @Override
     * This ensures that all acknowledged writes are restored correctly when this engine is promoted.
            translogConfig,
     */
            translogEventListener.onAfterTranslogSync();
    public boolean isTranslogSyncNeeded() {
     */
    public int recoverFromTranslog(TranslogRecoveryRunner translogRecoveryRunner, long localCheckpoint, long recoverUpToSeqNo)
     * @return max seq no
 * The OpenSearch Contributors require contributions made to
            try {
    }
        // With no fence there is no ownership to lose, so an aborted handoff leaves this copy free to resume.
    @Override
    public Exception getTragicExceptionIfClosed() {
        TranslogConfig translogConfig,
import java.util.concurrent.atomic.AtomicBoolean;
                    e.addSuppressed(inner);
        ShardId shardId,
            translog.rollGeneration();
    public void transferFenceOwnership(String targetAllocationId) throws IOException {
        // note: if opsRecovered == 0 and we have older translogs it means they are corrupted or 0 length.
    public void close() throws IOException {
        try (ReleasableLock ignored = readLock.acquire()) {
     * Rolls the translog generation and cleans unneeded.
                throw e;
    }
         * We flush to reduce the size of uncommitted translog but strictly speaking the uncommitted size won't always be
    }
import java.io.IOException;
    /**
            return true;
import java.util.function.LongSupplier;
            try {
    @Override
     * Retrieves the translog deletion policy
            }
        this.localCheckpointTrackerSupplier = localCheckpointTrackerSupplier;
        return translog;
         * periodically flush condition if this condition is disabled after a flush. The condition will change if the new
     */
    public String getTranslogUUID() {
     * Retrieves the max seq no
     *
    @Override
    /**
    /**
     * This operation will close the engine if the recovery fails.
        String translogUUID,
    }
     * @param localCheckpointOfLastCommit local checkpoint reference of last commit to translog
        } catch (Exception e) {
            } catch (Exception e) {
        }
    /**
         * threshold and the flush-threshold is guaranteed to be higher than an empty translog by the setting validation.
            if (pendingTranslogRecovery.get() == false) {
import org.apache.logging.log4j.Logger;
                opsRecovered,
            try {
        return getTranslog(true).getLastWriteLocation();
         *
import org.opensearch.index.translog.listener.TranslogEventListener;
            engineLifeCycleAware.ensureOpen();
    @Override
        this.fence = translog instanceof RemoteStoreFenceOwnership fenceAware ? fenceAware : null;
            globalCheckpointSupplier,
        } else {
        final long translogGenerationOfNewCommit = translog.getMinGenerationForSeqNo(
    public void trimUnreferencedReaders() throws IOException {
    }
         */
    public void trimOperationsFromTranslog(long belowTerm, long aboveSeqNo) throws TranslogException {
        }, translogUUID, translogFactory, startedPrimarySupplier, translogOperationHelper);
    @Override
        // don't allow commits until we are done with recovering
 * @opensearch.internal
     * Do not replay translog operations, but make the engine be ready.
    /**
                translogEventListener.onFailure("translog roll generation failed", e);
    }
    }
        // No fence means nothing can have superseded us; matches the fail-open choice documented on the caller.
            fence.transferFenceOwnership(targetAllocationId);
 */
        try (ReleasableLock ignored = readLock.acquire()) {
        return translog;
            throw e;
            engineLifeCycleAware.ensureOpen();
        if (ensureOpen) {
            throw new TranslogException(shardId, "failed to roll translog", e);
         * generations as the generation-threshold was reached, then the first condition (eg. [1]) is already satisfied.
        assert pendingTranslogRecovery.get() : "translogRecovery is not pending but should be";
    }
     */
                throw new TranslogException(shardId, "failed to recover from translog", e);
        if (pendingTranslogRecovery.get()) {
            primaryTermSupplier,
                translogEventListener.onFailure("translog operations trimming failed", e);
     * @param flushThreshold threshold to flush to translog
         * the new commit, we know that the last generation must contain operations because its size is above the flush
                e.addSuppressed(inner);
 * The {@link TranslogManager} implementation capable of orchestrating all read/write {@link Translog} operations for
     */
     * checks and removes translog files that no longer need to be retained. See
     */
            translogDeletionPolicy,
    }
     * Tests whether or not the translog generation should be rolled to a new generation.
    @Override
    public boolean isRemoteStoreFenceSuperseded() throws IOException {
        this.translogEventListener = translogEventListener;
            () -> new ParameterizedMessage(
 * this file be licensed under the Apache-2.0 license or a
    public Translog.Location add(Translog.Operation operation) throws IOException {
    public boolean shouldRollTranslogGeneration() {
     * This test is based on the size of the current generation compared to the configured generation threshold size.
    /**
     * Performs recovery from the transaction log up to {@code recoverUpToSeqNo} (inclusive).
    public InternalTranslogManager(
    /**
        );
    @Override
    @Override
    protected Translog openTranslog(
    public Translog.Location getTranslogLastWriteLocation() {
            }
                return translogRecoveryRunner.run(snapshot);
        TranslogFactory translogFactory,
    }
                opsRecovered = recoverFromTranslogInternal(translogRecoveryRunner, localCheckpoint, recoverUpToSeqNo);
     */
public class InternalTranslogManager implements TranslogManager, RemoteStoreFenceOwnership {
        TranslogFactory translogFactory,
         *
        try (ReleasableLock ignored = readLock.acquire()) {
    public Translog.Location[] add(java.util.List<Translog.Operation> operations) throws IOException {
    @Override
 *
            try (Translog.Snapshot snapshot = translog.newSnapshot(localCheckpoint + 1, recoverUpToSeqNo)) {
    private final RemoteStoreFenceOwnership fence;
    }
        } catch (AlreadyClosedException e) {
import java.util.stream.Stream;
        return translog.add(operation);
     * Reads operations from the translog
        // translog recovery happens after the engine is fully constructed.
        LongSupplier primaryTermSupplier,
     */
import org.opensearch.index.translog.transfer.TranslogUploadFailedException;
    }
     */
        IOUtils.closeWhileHandlingException(translog);
     */
         * This guarantees that the new commit will point to the newly rolled generation. In fact, this scenario only
        pendingTranslogRecovery.set(false); // we are good - now we can commit
    }
                throw new IllegalStateException("Engine has already been recovered");
        return translog.getMaxSeqNo();
        return translog.getGeneration();
    public Releasable drainSync() {
    // TODO refactor tests to remove public access to translog
    public int restoreLocalHistoryFromTranslog(long processedCheckpoint, TranslogRecoveryRunner translogRecoveryRunner) throws IOException {
     * Retrieves the underlying translog tragic exception
        } catch (Exception e) {
        BooleanSupplier startedPrimarySupplier,
        return getTranslog(true).stats();
     * index setting, so a fencing-enabled shard never relies on the fallbacks below.
    public void syncTranslog() throws IOException {
     * Adds an operation to the translog
        return minReferencedTranslogGeneration < translogGenerationOfNewCommit
            } catch (Exception inner) {
        if (synced) {
     */
     * Ensures that all locations in the given stream have been written to the underlying storage.
package org.opensearch.index.translog;
}
            this.engineLifeCycleAware.ensureOpen();
    public Translog getTranslog() {
                e.addSuppressed(inner);
     * @return the number of translog operations have been recovered
import java.io.Closeable;
        this.readLock = readLock;
        BooleanSupplier startedPrimarySupplier,
     * required generation
 *
                }
    }
    }
        if (translog.shouldFlush()) {
    public boolean ensureTranslogSynced(Stream<Translog.Location> locations) throws IOException {
     * The translog's fence, or {@code null} when it has none. A fence is an object-store construct, so only a
    }
    @Override
    private final ShardId shardId;
    }
    @Override
    @Override
     * {@link org.opensearch.index.translog.TranslogDeletionPolicy} for details
    public TranslogStats getTranslogStats() {
        this.logger = Loggers.getLogger(getClass(), shardId);
    ) throws IOException {
    ) throws IOException {
        ).translogFileGeneration;
import org.opensearch.common.lease.Releasable;
                translogEventListener.onFailure("translog trimming unreferenced translog failed", e);
        this.shardId = shardId;
    }
    @Override
    /**
    /**
            }
            engineLifeCycleAware.ensureOpen();
            } catch (Exception e) {
     * remote-backed translog has one; narrowing once here keeps that out of {@link Translog} without repeating the test
                "flushing post recovery from translog: ops recovered [{}], current translog generation [{}]",
        }
    private int recoverFromTranslogInternal(TranslogRecoveryRunner translogRecoveryRunner, long localCheckpoint, long recoverUpToSeqNo) {
         * below the flush-threshold after a flush. To avoid getting into an endless loop of flushing, we only enable the
        return opsRecovered;
            localCheckpointTrackerSupplier.get().getProcessedCheckpoint() + 1
     */
     * Trims unreferenced translog generations by asking {@link TranslogDeletionPolicy} for the minimum
