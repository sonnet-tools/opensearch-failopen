                "Updating from merge scheduler config: maxThreadCount {} -> {}, " + "maxMergeCount {} -> {}",
     * Registers a listener that fires when all active merges complete.
    public synchronized double getIORateLimitMBPerSec() {
     * ({@link #submitMergeTask}) and force merge ({@link #forceMerge}) completion paths.  
import java.util.concurrent.Semaphore;
     *   <li>On failure: {@code onMergeFailureCleanup} — releases {@code refreshLock} if still held</li>  
        // Double-check after adding — merges may have finished between the check and the add
        }  
    private volatile int maxMergeCount;  
        long totalSizeInBytes = oneMerge.getTotalSizeInBytes();  
 * Schedules and coordinates segment merge operations for a shard.
     *         {@code false} if it was already frozen
        return mergeStatsTracker.toMergeStats(mergeSchedulerConfig.isAutoThrottle() ? getIORateLimitMBPerSec() : Double.POSITIVE_INFINITY);  
    /**  
     * @param indexSettings         the index settings providing merge scheduler configuration  
        long tookMS = 0;  
    private final Logger logger;
     * <p>
        }
    private final MergeHandler mergeHandler;
        // should still be executed to drain the queue to completion.
            () -> new ParameterizedMessage(
     * @param mergeHandler          the handler that selects and executes merges
            logger.info("Merge {} completed in {}ms, result: {}", oneMerge, tookMS, mergeResult.getMergedWriterFileSet());
    /**
                newMaxMergeCount  
    private final BiConsumer<MergeResult, OneMerge> applyMergeChanges;  
        }  
        while (activeMerges.get() < maxConcurrentMerges && mergeHandler.hasPendingMerges()) {
    private boolean doAutoIOThrottle = false;  
    public MergeScheduler(  
        String state = indexSettings.getSettings().get(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name());  
                    logger.warn("Exception in onDrained listener", ex);
     */
            Collection<OneMerge> oneMerges = mergeHandler.findForceMerges(maxNumSegment);  
        }
     */  
     * <p>  
        } finally {
     * {@link #getActiveMergeCount()}.
            onDrainedListeners.clear();  
    }
     * invoked on the merge thread when the last merge finishes.
     * Executes a single merge and applies or cleans up the result.  
     * Submits a merge task to the thread pool's merge executor.
    /**
     * @param oneMerge the merge to execute
            if (isShutdown.get()) {
     * Unfreezes the merge scheduler, allowing merges to resume. Called when tiering is cancelled.  
        if (isFrozen() && activeMerges.get() == 0 && !mergeHandler.hasPendingMerges() && !onDrainedListeners.isEmpty()) {
        doAutoIOThrottle = true;
                this.maxConcurrentMerges,  
        }
     *         {@code false} if it was already unfrozen  
            return targetMBPerSec;  
    public boolean freeze() {
            for (Runnable listener : listeners) {
     * is frozen and no merges (active or pending) remain. Called from both the background merge
        activeMerges.incrementAndGet();  
     * @return {@code true} if {@link MergeHandler#hasPendingMerges()} is {@code true}  
        );
     * with a {@code compareAndSet} (or equivalent) — see {@code TransportPrepareTieringAction} for
    }  
        this.maxMergeCount = newMaxMergeCount;
    /** true if we should rate-limit writes for each merge */
            : "forceMerge must be called on FORCE_MERGE thread but was: " + Thread.currentThread().getName();
    private void runMerge(OneMerge oneMerge) throws IOException {
    public int getActiveMergeCount() {  
            List<Runnable> listeners = List.copyOf(onDrainedListeners);
            }
import java.util.concurrent.atomic.AtomicBoolean;
     * the canonical pattern.  
     * Listeners must be idempotent: under a narrow race between this method's double-check and the  
        Runnable onMergeFailureCleanup,  
            if (oneMerge == null) {
    }  
     * Idempotent via {@code compareAndSet}: {@link #triggerMerges()} runs only on a real
        // Only register new merges if not frozen. Already-pending merges  
                    logger.debug("MergeScheduler shutdown during force merge, aborting remaining merges");  
    protected double targetMBPerSec = START_MB_PER_SEC;  
        logger.info(  
     *
    private final List<Runnable> onDrainedListeners = new CopyOnWriteArrayList<>();
            throw e instanceof IOException ? (IOException) e : new IOException(e);  
     * the current {@link MergeSchedulerConfig}. No-op if the values have not changed.
     * means the queue is non-empty regardless of how many merges are currently running.
                }
     * This is the single point that owns the merge lifecycle:
     */  
                }
        this.maxConcurrentMerges = newMaxThreadCount;
     * {@link ThreadPool.Names#FORCE_MERGE} thread. Only one force merge
        return mergeHandler.hasPendingMerges();  
        return frozen.compareAndSet(false, true);
        if (!isFrozen()) {
     */
        executeMerge();
     * may execute per shard at a time — concurrent callers block until  
    }  
import org.opensearch.threadpool.ThreadPool;
     * @param shardId               the shard this scheduler is associated with
        this.threadPool = threadPool;
        }
 * compatible open source license.
     * <ol>  
     *   <li>On success: {@code applyMergeChanges} — releases {@code refreshLock}</li>
    /**
    private final ThreadPool threadPool;
import org.opensearch.index.engine.dataformat.MergeResult;
        return IndexModule.TieringState.HOT_TO_WARM.name().equals(state);
        activeMerges.decrementAndGet();  
     * Returns the current merge statistics for this scheduler.
    }  
     * @param onMergeFailureCleanup callback invoked when a merge fails and cleanup is performed
    /**
     * @param listener the callback to fire when merges are drained
        }
 * this file be licensed under the Apache-2.0 license or a
        this.applyMergeChanges = applyMergeChanges;  
     * <p>
 * concurrency via configurable merge count limits sourced from
 */  
    }
        threadPool.executor(ThreadPool.Names.MERGE).execute(() -> {
    }
import org.opensearch.core.index.shard.ShardId;  
     * @param maxNumSegment the maximum number of segments after the force merge  
    private void submitMergeTask(OneMerge oneMerge) {  
        try {
                mergeHandler.onMergeFailure(oneMerge);
                } catch (Exception ex) {
            triggerMerges();
    }
    }
            }  
            onMergeFailureCleanup.run();
            try {
     * necessary so merges do not fall behind. By default, this is disabled and writes are not
     * Multiple listeners can be registered concurrently (thread-safe via CopyOnWriteArrayList).
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);
     * @return the merge stats  
/*  
     * merge thread's snapshot-then-clear, the listener may be invoked twice. Gate any side-effects
     * Refreshes the max concurrent merge thread count and max merge count from
        isShutdown.set(true);
                }  
     * Returns the currently set per-merge IO writes rate limit, if {@link #enableAutoIOThrottle} was
     */
     */
    private final MergeStatsTracker mergeStatsTracker = new MergeStatsTracker();  
import org.opensearch.common.unit.TimeValue;
     * @param threadPool            the OpenSearch thread pool for executing merge tasks
     * underlying {@link MergeHandler} and executed up to the configured
 * <p>
        }
    private static final double START_MB_PER_SEC = 20.0;  
     * Creates a new merge scheduler.  
            MergeResult mergeResult = mergeHandler.doMerge(oneMerge);  
import java.io.IOException;  
    }
     * effect; redundant calls are no-ops.
            decrementAndFireDrainListeners();  
     * Runs synchronously on the calling thread, which must be a
 * {@link MergeSchedulerConfig}. Merge tasks are submitted to the OpenSearch
            return;  
     * rate-limited.
     * @return {@code true} if this call transitioned the scheduler from frozen to unfrozen,
import org.opensearch.index.merge.MergeStats;
            return;
    }
        ThreadPool threadPool  
     * submitting each merge as a task to the thread pool.
    }  
     * Turn on dynamic IO throttling, to adaptively rate limit writes bytes/sec to the minimal rate  
     * Freezes the merge scheduler: blocks new merges (in-flight and already-pending merges still drain
     * Drains the pending-merge queue up to {@link #maxConcurrentMerges},
     * concurrency limits.
        long timeNS = System.nanoTime();
            }
    /**  
     */
 * SPDX-License-Identifier: Apache-2.0
                    logger.debug("MergeScheduler is shutdown, skipping merge");
    /**
                logger.debug("MergeScheduler is shutdown, skipping force merge");  
     * or because the index tiering state indicates preparation/migration is in progress.  
    private final Runnable onMergeFailureCleanup;
     * <p>  
     * frozen-to-unfrozen transition, so a redundant unfreeze does not kick off a spurious merge cycle.  
     * <p>  
        int newMaxMergeCount = mergeSchedulerConfig.getMaxMergeCount();  
                // A completed merge may free up capacity for new merges, so check again.
     * Forces a merge down to at most {@code maxNumSegment} segments.  
    public synchronized void enableAutoIOThrottle() {
            try {  
     * called, else {@code Double.POSITIVE_INFINITY}.
        assert Thread.currentThread().getName().contains(ThreadPool.Names.FORCE_MERGE)  
     */
    private final AtomicInteger activeMerges = new AtomicInteger(0);  
            mergeHandler.onMergeFailure(oneMerge);
            )
            mergeStatsTracker.afterMerge(tookMS, totalNumDocs, totalSizeInBytes);
     * to completion). Used during tiering preparation to ensure no catalog mutations from merges.
     * Returns whether there are any merges queued but not yet started.
@ExperimentalApi
    }  
     * @param applyMergeChanges     callback to apply merge results (e.g., update the catalog)  
 * This scheduler delegates merge selection to a {@link MergeHandler} and controls  
        int newMaxThreadCount = mergeSchedulerConfig.getMaxThreadCount();
            return;
    public boolean unfreeze() {
            tookMS = TimeValue.nsecToMSec((System.nanoTime() - timeNS));  
    private volatile int maxConcurrentMerges;
     * Returns the number of currently active (in-flight) merge tasks.
        if (newMaxThreadCount == this.maxConcurrentMerges && newMaxMergeCount == this.maxMergeCount) {
        this.onMergeFailureCleanup = onMergeFailureCleanup;
            }
    private final Semaphore forceMergeLock = new Semaphore(1);
    /**  
    /**  
            applyMergeChanges.accept(mergeResult, oneMerge);
        long totalNumDocs = oneMerge.getTotalNumDocs();
    /**
     * Idempotent via {@code compareAndSet} — only the first call that actually flips the state takes
        return activeMerges.get();
        }
        ShardId shardId,
            listener.run();  
     * Shuts down this merge scheduler, preventing new merges from being submitted.
                    return;  
import java.util.List;
     * Reports pending state orthogonally from active state: a {@code true} result here
import org.opensearch.common.logging.Loggers;
     */  
     */
     */
     *  
        this.mergeSchedulerConfig = indexSettings.getMergeSchedulerConfig();
            } catch (Exception e) {  
    /**
                if (isShutdown.get()) {
     * Decrements the active merge count and fires all registered drain listeners if the scheduler
            }  
 * {@link ThreadPool} using the {@link ThreadPool.Names#FORCE_MERGE} executor.  
    public synchronized void refreshConfig() {
 * @opensearch.experimental
     * @return the active merge count
    public void shutdown() {  
    /**
            mergeHandler.findAndRegisterMerges();  
    /**  
                decrementAndFireDrainListeners();
            for (OneMerge oneMerge : oneMerges) {
     */
    /** Current IO writes throttle rate */
import org.opensearch.common.annotation.ExperimentalApi;  
                onMergeFailureCleanup.run();
import java.util.concurrent.CopyOnWriteArrayList;  
 *
                // uncaught exception on the merge thread pool.
            logger.error(new ParameterizedMessage("Merge failed for: {}", oneMerge), e);  
     */
     *
    private final IndexSettings indexSettings;
        refreshConfig();  
 * The OpenSearch Contributors require contributions made to  
                executeMerge();  
                runMerge(oneMerge);  
    ) {
     */  
        try {
                    break;
    public void triggerMerges() {
                submitMergeTask(oneMerge);
        } catch (Exception e) {
import java.util.function.BiConsumer;
    /**
    /**  
    public MergeStats stats() {
    }
     *  
        }
    private final MergeSchedulerConfig mergeSchedulerConfig;
     */
public class MergeScheduler {
            mergeStatsTracker.beforeMerge(totalNumDocs, totalSizeInBytes);
package org.opensearch.index.engine.dataformat.merge;
     * Callers that want a "any work outstanding" signal should combine this with  
     */  
        if (frozen.get()) {  
    /** Initial value for IO write rate limit when doAutoIOThrottle is true */
            } catch (Exception e) {  
     * If already drained (no active merges and no pending), fires the listener immediately  
     */  
                return;
     * </ol>
        return false;
        if (activeMerges.get() == 0 && !mergeHandler.hasPendingMerges()) {
        onDrainedListeners.add(listener);  
        this.indexSettings = indexSettings;
     *
     * <p>
    private void executeMerge() {
    /**
/**  
    }
                if (isShutdown.get()) {
            } finally {  
            return true;
        }
        if (isShutdown.get()) {
            OneMerge oneMerge = mergeHandler.getNextMerge();  
import org.opensearch.index.MergeSchedulerConfig;  
                listener.run();
                try {
                runMerge(oneMerge);
    /**
                    listener.run();  
     */  
            }
    }
        this.mergeHandler = mergeHandler;
        }  
    private final AtomicBoolean frozen = new AtomicBoolean(false);  
     * Triggers pending merge operations. Merges are selected by the  
        });
     *  
                return;
        if (doAutoIOThrottle) {
    public boolean hasPendingMerges() {
     * release guarantee is maintained in exactly one code path.  
        targetMBPerSec = START_MB_PER_SEC;  
     *   <li>{@code doMerge} — may acquire {@code refreshLock} via the pre-merge-commit hook</li>
}
        activeMerges.incrementAndGet();
        return Double.POSITIVE_INFINITY;  
     * inline. Otherwise, adds the listener to the list — all registered listeners will be
    public void onDrained(Runnable listener) {
                newMaxThreadCount,
import org.apache.logging.log4j.Logger;
        logger = Loggers.getLogger(getClass(), shardId);  
     * By funnelling both background and force merges through this method, the lock
     * Returns true if the merge scheduler is frozen — either explicitly via {@link #freeze()}
            }
import org.opensearch.index.IndexSettings;
 */  
     *
        BiConsumer<MergeResult, OneMerge> applyMergeChanges,
    }
import java.util.concurrent.atomic.AtomicInteger;  
     * the ongoing force merge completes.
        if (frozen.compareAndSet(true, false)) {  
     * @return {@code true} if this call transitioned the scheduler from unfrozen to frozen,
                this.maxMergeCount,
            forceMergeLock.release();
        IndexSettings indexSettings,
    /**  
        if (activeMerges.get() == 0 && !mergeHandler.hasPendingMerges()) {
    public void forceMerge(int maxNumSegment) throws IOException {
    public boolean isFrozen() {
            if (onDrainedListeners.remove(listener)) {  
        } finally {
import java.util.Collection;
    private void decrementAndFireDrainListeners() {
                // runMerge already invoked onMergeFailureCleanup; swallow to prevent
            mergeHandler.onMergeFinished(oneMerge, isFrozen());
        forceMergeLock.acquireUninterruptibly();
import org.opensearch.index.IndexModule;
import org.opensearch.index.merge.MergeStatsTracker;  
        MergeHandler mergeHandler,
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
            logger.warn("MergeScheduler is shutdown, ignoring merge trigger");  
     *
 *
     *
            return true;
