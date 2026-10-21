                }
                decrementAndFireDrainListeners();
                    listener.run();
            triggerMerges();
    }
     * to completion). Used during tiering preparation to ensure no catalog mutations from merges.
            onMergeFailureCleanup.run();
        doAutoIOThrottle = true;
            try {
    }
            for (OneMerge oneMerge : oneMerges) {
import java.util.Collection;
public class MergeScheduler {
     * @return {@code true} if {@link MergeHandler#hasPendingMerges()} is {@code true}
    public boolean hasPendingMerges() {
                submitMergeTask(oneMerge);
        logger = Loggers.getLogger(getClass(), shardId);
            forceMergeLock.release();
    public boolean unfreeze() {
     * invoked on the merge thread when the last merge finishes.
     * Triggers pending merge operations. Merges are selected by the
    }
                }
        long totalNumDocs = oneMerge.getTotalNumDocs();
        return activeMerges.get();
     * @param maxNumSegment the maximum number of segments after the force merge
                return;
        if (frozen.get()) {
/*
                if (isShutdown.get()) {
import org.opensearch.index.IndexSettings;
     */
     *
    /**
        this.threadPool = threadPool;
        if (isFrozen() && activeMerges.get() == 0 && !mergeHandler.hasPendingMerges() && !onDrainedListeners.isEmpty()) {
    }
        forceMergeLock.acquireUninterruptibly();
    public MergeScheduler(
                    logger.debug("MergeScheduler is shutdown, skipping merge");
            } finally {
    /** Current IO writes throttle rate */
@ExperimentalApi
    }
            mergeHandler.findAndRegisterMerges();
     */
    private static final double START_MB_PER_SEC = 20.0;
     * the canonical pattern.
    public int getActiveMergeCount() {
    public boolean isFrozen() {
            if (isShutdown.get()) {
     * Refreshes the max concurrent merge thread count and max merge count from
     * This is the single point that owns the merge lifecycle:
     * <p>
                mergeHandler.onMergeFailure(oneMerge);
     * @return the active merge count
        if (frozen.compareAndSet(true, false)) {
        });
            decrementAndFireDrainListeners();
 * {@link MergeSchedulerConfig}. Merge tasks are submitted to the OpenSearch
 * concurrency via configurable merge count limits sourced from
     * Multiple listeners can be registered concurrently (thread-safe via CopyOnWriteArrayList).
        } finally {
    private final Semaphore forceMergeLock = new Semaphore(1);
    /**
     * Forces a merge down to at most {@code maxNumSegment} segments.
    }
     * <p>
            applyMergeChanges.accept(mergeResult, oneMerge);
import java.util.List;
    private final Logger logger;
    /**
     *
    }
     * Listeners must be idempotent: under a narrow race between this method's double-check and the
            )
        if (isShutdown.get()) {
        isShutdown.set(true);
                if (isShutdown.get()) {
                } catch (Exception ex) {
     * Reports pending state orthogonally from active state: a {@code true} result here
            }
                this.maxMergeCount,
        activeMerges.incrementAndGet();
    /**
        }
                runMerge(oneMerge);
        int newMaxMergeCount = mergeSchedulerConfig.getMaxMergeCount();
     * merge thread's snapshot-then-clear, the listener may be invoked twice. Gate any side-effects
                // runMerge already invoked onMergeFailureCleanup; swallow to prevent
        targetMBPerSec = START_MB_PER_SEC;
 *
import java.util.concurrent.CopyOnWriteArrayList;
import org.opensearch.threadpool.ThreadPool;
    }
                }
    /**
    /** Initial value for IO write rate limit when doAutoIOThrottle is true */
    public MergeStats stats() {
     * Returns the currently set per-merge IO writes rate limit, if {@link #enableAutoIOThrottle} was
    }
     *   <li>On success: {@code applyMergeChanges} — releases {@code refreshLock}</li>
    }
 */
        logger.info(
     *
     * Freezes the merge scheduler: blocks new merges (in-flight and already-pending merges still drain
import org.opensearch.index.merge.MergeStatsTracker;
        MergeHandler mergeHandler,
        while (activeMerges.get() < maxConcurrentMerges && mergeHandler.hasPendingMerges()) {
     * @param onMergeFailureCleanup callback invoked when a merge fails and cleanup is performed
     * rate-limited.
    /**
     */
                onMergeFailureCleanup.run();
            logger.warn("MergeScheduler is shutdown, ignoring merge trigger");
    }
        ThreadPool threadPool
 * this file be licensed under the Apache-2.0 license or a
     * Runs synchronously on the calling thread, which must be a
     * frozen-to-unfrozen transition, so a redundant unfreeze does not kick off a spurious merge cycle.
            Collection<OneMerge> oneMerges = mergeHandler.findForceMerges(maxNumSegment);
     * {@link #getActiveMergeCount()}.
    private volatile int maxConcurrentMerges;
        }
        activeMerges.incrementAndGet();
            if (oneMerge == null) {
 *
        executeMerge();
 * Schedules and coordinates segment merge operations for a shard.
    private final Runnable onMergeFailureCleanup;
    /**
    private final BiConsumer<MergeResult, OneMerge> applyMergeChanges;
    /**
            }
                    logger.warn("Exception in onDrained listener", ex);
                return;
        long totalSizeInBytes = oneMerge.getTotalSizeInBytes();
     * <p>
    private final MergeHandler mergeHandler;
    public void shutdown() {
     * Returns the number of currently active (in-flight) merge tasks.
        if (activeMerges.get() == 0 && !mergeHandler.hasPendingMerges()) {
}
            : "forceMerge must be called on FORCE_MERGE thread but was: " + Thread.currentThread().getName();
        // should still be executed to drain the queue to completion.
    /**
            listener.run();
     * or because the index tiering state indicates preparation/migration is in progress.
     * @param shardId               the shard this scheduler is associated with
     */
        long tookMS = 0;
    }
     * is frozen and no merges (active or pending) remain. Called from both the background merge
 */
                // uncaught exception on the merge thread pool.
            }
     * release guarantee is maintained in exactly one code path.
        if (newMaxThreadCount == this.maxConcurrentMerges && newMaxMergeCount == this.maxMergeCount) {
                executeMerge();
     *   <li>{@code doMerge} — may acquire {@code refreshLock} via the pre-merge-commit hook</li>
    ) {
    private void submitMergeTask(OneMerge oneMerge) {
            return;
     * Returns the current merge statistics for this scheduler.
                logger.debug("MergeScheduler is shutdown, skipping force merge");
        }
        if (!isFrozen()) {
            return;
import org.opensearch.common.unit.TimeValue;
     *         {@code false} if it was already unfrozen
import org.opensearch.index.engine.dataformat.MergeResult;
    private final MergeStatsTracker mergeStatsTracker = new MergeStatsTracker();
        refreshConfig();
     */
                "Updating from merge scheduler config: maxThreadCount {} -> {}, " + "maxMergeCount {} -> {}",
    }
/**
import org.opensearch.common.logging.Loggers;
            return true;
            logger.error(new ParameterizedMessage("Merge failed for: {}", oneMerge), e);
     * @param threadPool            the OpenSearch thread pool for executing merge tasks
     * By funnelling both background and force merges through this method, the lock
            }
import org.opensearch.common.annotation.ExperimentalApi;
     *
            return;
    private final IndexSettings indexSettings;
            } catch (Exception e) {
     *         {@code false} if it was already frozen
        } finally {
     */
     * </ol>
        ShardId shardId,
                listener.run();
    protected double targetMBPerSec = START_MB_PER_SEC;
            mergeStatsTracker.afterMerge(tookMS, totalNumDocs, totalSizeInBytes);
     * Drains the pending-merge queue up to {@link #maxConcurrentMerges},
        int newMaxThreadCount = mergeSchedulerConfig.getMaxThreadCount();
                    logger.debug("MergeScheduler shutdown during force merge, aborting remaining merges");
     * the ongoing force merge completes.
    public void onDrained(Runnable listener) {
     * called, else {@code Double.POSITIVE_INFINITY}.
 * compatible open source license.
        threadPool.executor(ThreadPool.Names.MERGE).execute(() -> {
        long timeNS = System.nanoTime();
    /**
     * inline. Otherwise, adds the listener to the list — all registered listeners will be
        this.mergeSchedulerConfig = indexSettings.getMergeSchedulerConfig();
        return mergeHandler.hasPendingMerges();
            try {
     * If already drained (no active merges and no pending), fires the listener immediately
        );
    private volatile int maxMergeCount;
     * concurrency limits.
        BiConsumer<MergeResult, OneMerge> applyMergeChanges,
        assert Thread.currentThread().getName().contains(ThreadPool.Names.FORCE_MERGE)
     */
import java.util.concurrent.atomic.AtomicInteger;
        this.applyMergeChanges = applyMergeChanges;
        return false;
     * @param applyMergeChanges     callback to apply merge results (e.g., update the catalog)
package org.opensearch.index.engine.dataformat.merge;
        Runnable onMergeFailureCleanup,
    public synchronized void refreshConfig() {
     * Returns whether there are any merges queued but not yet started.
import java.util.function.BiConsumer;
        activeMerges.decrementAndGet();
     * @param listener the callback to fire when merges are drained
     * the current {@link MergeSchedulerConfig}. No-op if the values have not changed.
 * @opensearch.experimental
     * @return {@code true} if this call transitioned the scheduler from unfrozen to frozen,
import org.opensearch.index.merge.MergeStats;
     */
            } catch (Exception e) {
        String state = indexSettings.getSettings().get(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name());
     *   <li>On failure: {@code onMergeFailureCleanup} — releases {@code refreshLock} if still held</li>
                    break;
import java.util.concurrent.atomic.AtomicBoolean;
     */
     * ({@link #submitMergeTask}) and force merge ({@link #forceMerge}) completion paths.
        return mergeStatsTracker.toMergeStats(mergeSchedulerConfig.isAutoThrottle() ? getIORateLimitMBPerSec() : Double.POSITIVE_INFINITY);
        try {
     * Callers that want a "any work outstanding" signal should combine this with
    private boolean doAutoIOThrottle = false;
     * with a {@code compareAndSet} (or equivalent) — see {@code TransportPrepareTieringAction} for
     * @param oneMerge the merge to execute
import org.apache.logging.log4j.Logger;
import org.opensearch.index.IndexModule;
 * This scheduler delegates merge selection to a {@link MergeHandler} and controls
     *
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);
     *
    public synchronized void enableAutoIOThrottle() {
        this.mergeHandler = mergeHandler;
import java.util.concurrent.Semaphore;
     * {@link ThreadPool.Names#FORCE_MERGE} thread. Only one force merge
     * Turn on dynamic IO throttling, to adaptively rate limit writes bytes/sec to the minimal rate
    /**
     */
        this.maxConcurrentMerges = newMaxThreadCount;
        try {
        IndexSettings indexSettings,
    private final ThreadPool threadPool;
        return frozen.compareAndSet(false, true);
     * may execute per shard at a time — concurrent callers block until
                runMerge(oneMerge);
     */
        }
        this.onMergeFailureCleanup = onMergeFailureCleanup;
        }
     * @return {@code true} if this call transitioned the scheduler from frozen to unfrozen,
            throw e instanceof IOException ? (IOException) e : new IOException(e);
            }
            List<Runnable> listeners = List.copyOf(onDrainedListeners);
     * Executes a single merge and applies or cleans up the result.
            () -> new ParameterizedMessage(
     *
                newMaxThreadCount,
 * <p>
     */
    public synchronized double getIORateLimitMBPerSec() {
    }
        }
    private void decrementAndFireDrainListeners() {
        }
        onDrainedListeners.add(listener);
     * means the queue is non-empty regardless of how many merges are currently running.
    /**
                    return;
        // Only register new merges if not frozen. Already-pending merges
import org.opensearch.core.index.shard.ShardId;
            if (onDrainedListeners.remove(listener)) {
     * @param mergeHandler          the handler that selects and executes merges
        }
        this.maxMergeCount = newMaxMergeCount;
    }
     * Shuts down this merge scheduler, preventing new merges from being submitted.
            return true;
     */
            MergeResult mergeResult = mergeHandler.doMerge(oneMerge);
     * @return the merge stats
     * Decrements the active merge count and fires all registered drain listeners if the scheduler
import java.io.IOException;
     * Submits a merge task to the thread pool's merge executor.
     */
        }
            }
        }
            return targetMBPerSec;
    /**
 * SPDX-License-Identifier: Apache-2.0
     */
     * <p>
     * <ol>
                // A completed merge may free up capacity for new merges, so check again.
import org.opensearch.index.MergeSchedulerConfig;
    /**
        }
     * underlying {@link MergeHandler} and executed up to the configured
     * Idempotent via {@code compareAndSet} — only the first call that actually flips the state takes
    }
     */
     * necessary so merges do not fall behind. By default, this is disabled and writes are not
     *
    private final List<Runnable> onDrainedListeners = new CopyOnWriteArrayList<>();
    /**
                this.maxConcurrentMerges,
    private final MergeSchedulerConfig mergeSchedulerConfig;
            onDrainedListeners.clear();
     */
    private final AtomicBoolean frozen = new AtomicBoolean(false);
            for (Runnable listener : listeners) {
     * effect; redundant calls are no-ops.
    public boolean freeze() {
 * {@link ThreadPool} using the {@link ThreadPool.Names#FORCE_MERGE} executor.
     *
        return IndexModule.TieringState.HOT_TO_WARM.name().equals(state);
     * Unfreezes the merge scheduler, allowing merges to resume. Called when tiering is cancelled.
            tookMS = TimeValue.nsecToMSec((System.nanoTime() - timeNS));
     */
import org.apache.logging.log4j.message.ParameterizedMessage;
            OneMerge oneMerge = mergeHandler.getNextMerge();
    private final AtomicInteger activeMerges = new AtomicInteger(0);
        return Double.POSITIVE_INFINITY;
     * Idempotent via {@code compareAndSet}: {@link #triggerMerges()} runs only on a real
     * Returns true if the merge scheduler is frozen — either explicitly via {@link #freeze()}
     * submitting each merge as a task to the thread pool.
    /**
            }
            mergeStatsTracker.beforeMerge(totalNumDocs, totalSizeInBytes);
                newMaxMergeCount
     * Creates a new merge scheduler.
                try {
            mergeHandler.onMergeFinished(oneMerge, isFrozen());
    /**
    public void forceMerge(int maxNumSegment) throws IOException {
    private void runMerge(OneMerge oneMerge) throws IOException {
     * @param indexSettings         the index settings providing merge scheduler configuration
     * <p>
    }
        }
     * Registers a listener that fires when all active merges complete.
            logger.info("Merge {} completed in {}ms, result: {}", oneMerge, tookMS, mergeResult.getMergedWriterFileSet());
    private void executeMerge() {
        } catch (Exception e) {
        // Double-check after adding — merges may have finished between the check and the add
    /**
            mergeHandler.onMergeFailure(oneMerge);
    /** true if we should rate-limit writes for each merge */
    public void triggerMerges() {
 * The OpenSearch Contributors require contributions made to
        if (doAutoIOThrottle) {
    }
        this.indexSettings = indexSettings;
        if (activeMerges.get() == 0 && !mergeHandler.hasPendingMerges()) {
     * <p>
