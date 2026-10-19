                throw new TimeoutException("Timeout while acquiring all permits");
     * execution finishes.
    }
    /**
        }
import org.opensearch.common.lease.Releasables;
     * In case there are use cases where concurrency is required, the total permit variable can be put inside the ctor.
    /**
        }
        this.threadPool = threadPool;
    }
    }
     * @param afterRefreshSuccessful is sent true if the performAfterRefresh(..) is successful.
     * @return the name of the retry thread pool.
    }
            getLogger().info("Scheduled retry with didRefresh={}", didRefresh);
    private final AtomicBoolean closed = new AtomicBoolean(false);
 * SPDX-License-Identifier: Apache-2.0
     * This boolean is used to ensure that there is only 1 retry scheduled/running at any time.
        } finally {
     * @param didRefresh             if the refresh did open a new reference then didRefresh will be true
     * This is used for scheduling the next retry. The method would be invoked each time when a retry is required. The
    }
                    semaphore.release(TOTAL_PERMITS);
     */
     * The synchronised block ensures that if there is a retry or afterRefresh waiting, then it waits until the previous
     */
        // If the retryScheduled is already true, then we return from here itself. If not, then we proceed with scheduling
    protected abstract Logger getLogger();
        }
            }
    }
                getLogger().info("Scheduling retry with didRefresh={} failed due to executor shut down", didRefresh);
        if (closed.get()) {
            this.threadPool.schedule(
        boolean scheduled = false;
        runAfterRefreshWithPermit(didRefresh, () -> {});
    }
    @Override
 */
        }
        try {
            scheduleRetry(getNextRetryInterval(), getRetryThreadPoolName(), didRefresh);
                return Releasables.releaseOnce(() -> {
/*
     *
     * executed immediately when afterRefresh method is invoked.
        // the retry.
        if (closed.get()) {
    /**
                semaphore.release();
                });
     */
    protected boolean isRetryEnabled() {
        assert Objects.nonNull(interval) && ThreadPool.THREAD_POOL_TYPES.containsKey(retryThreadPoolName);
     */
                    boolean wasClosed = closed.getAndSet(false);
    int availablePermits() {
        } catch (InterruptedException | TimeoutException e) {
    /**
 * this file be licensed under the Apache-2.0 license or a
     * This method is used to schedule retry which internally calls the performAfterRefresh method under the available permits.
 * The OpenSearch Contributors require contributions made to
        boolean successful;
     * implementor can choose any retry strategy and return the next retry interval accordingly.
                retryThreadPoolName
     * @param interval            interval after which the retry would be invoked
     *
    protected String getRetryThreadPoolName() {
        return retryScheduled.get();
import java.io.IOException;
    }
        if (closed.get() || isRetryEnabled() == false) {
        return false;
    private static final TimeValue DRAIN_TIMEOUT = TimeValue.timeValueMinutes(10);
        return DRAIN_TIMEOUT;
            } else {
        runAfterRefreshExactlyOnce(didRefresh);
 */
 * is called, all the permits are acquired and there are no available permits to afterRefresh. This abstract class provides
     * Runs the performAfterRefresh method under permit. If there are no permits available, then it is no-op. It also hits
     * the scheduleRetry method with the result value of the performAfterRefresh method invocation.
                retryScheduled.set(false);
import java.util.Objects;
            if (permitAcquired) {
        if (retryScheduled.getAndSet(true)) {
            if (scheduled == false) {
        return TimeValue.timeValueSeconds(1);
        assert Objects.nonNull(threadPool);
    /**
     * The method would be invoked each time when a retry is required. By default, it uses the same threadpool for retry.
    /**
                getLogger().info("All permits are acquired and refresh listener is closed");
            TimeValue timeout = getDrainTimeout();
package org.opensearch.index.shard;
            );
import org.opensearch.common.lease.Releasable;
    TimeValue getDrainTimeout() {
     */
    boolean getRetryScheduledStatus() {
import java.util.concurrent.atomic.AtomicBoolean;
     */
            return;
     * The implementor has the option to override the retry thread pool name. This will be used for scheduling the retries.
import java.util.concurrent.TimeoutException;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.threadpool.ThreadPool;
     * @param retryThreadPoolName the thread pool name to be used for retry
    private final Semaphore semaphore = new Semaphore(TOTAL_PERMITS);
     *
     * @return true if retry is enabled.
            }
 * necessary abstract methods to schedule retry.
    }
    /**
    public ReleasableRetryableRefreshListener() {
                assert result && semaphore.availablePermits() == 0;
        try {
        this.threadPool = null;
     */
     * This method needs to be overridden and be provided with what needs to be run on after refresh with permits.
import org.apache.logging.log4j.Logger;
    /**
}
    protected void runAfterRefreshExactlyOnce(boolean didRefresh) {
     * By default, the retry interval is returned as 1s. The implementor has the option to override the retry interval.
     * @param didRefresh true if the refresh opened a new reference
/**
            successful = permitAcquired && performAfterRefreshWithPermit(didRefresh);
    // Visible for testing
        }
     *
    }
            return;
     * @param didRefresh if the refresh did open a new reference then didRefresh will be true
    // Made available for unit testing purpose only
     * @return boolean as mentioned above.
    public final void afterRefresh(boolean didRefresh) throws IOException {
                throw e;
            runFinally.run();
public abstract class ReleasableRetryableRefreshListener implements ReferenceManager.RefreshListener {
                interval,
    // Visible for testing
    }
    private final ThreadPool threadPool;
        } catch (OpenSearchRejectedExecutionException e) {
            if (e.isExecutorShutdown()) {
     * The code in this method is executed exactly once. This is done for running non-idempotent function which needs to be
     * This returns if the retry is enabled or not. By default, the retries are not enabled.
     * @return the interval for the next retry.
            return;
            } else {
    }
    }
import java.util.concurrent.Semaphore;
 *
        scheduleRetry(successful, didRefresh);
        return ThreadPool.Names.SAME;
    private void scheduleRetry(boolean afterRefreshSuccessful, boolean didRefresh) {
    private void scheduleRetry(TimeValue interval, String retryThreadPoolName, boolean didRefresh) {
    /**
     */
    /**
    public final Releasable drainRefreshes() {
     * Total permits = 1 ensures that there is only single instance of runAfterRefreshWithPermit that is running at a time.
            }
    private static final int TOTAL_PERMITS = 1;
     * Returns the timeout which is used while draining refreshes.
    private synchronized void runAfterRefreshWithPermit(boolean didRefresh, Runnable runFinally) {
     */
        return semaphore.availablePermits();
     *
     * Returns if the retry is scheduled or not.
        // If the underlying listener has closed, then we do not allow even the retry to be scheduled
     * Schedules the retry based on the {@code afterRefreshSuccessful} value.
        // No-op: The implementor would be providing the code
     * @param didRefresh          if didRefresh is true
    /**
    /**
    public ReleasableRetryableRefreshListener(ThreadPool threadPool) {
            }
        }
    }
 * compatible open source license.
        try {
        boolean permitAcquired = semaphore.tryAcquire();
            getLogger().debug("skip retry on closed={} isRetryEnabled={}", closed.get(), isRetryEnabled());
    private final AtomicBoolean retryScheduled = new AtomicBoolean(false);
    boolean isClosed() {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            throw new RuntimeException("Failed to acquire all permits", e);
                () -> runAfterRefreshWithPermit(didRefresh, () -> retryScheduled.set(false)),
    // Visible for testing
        if (afterRefreshSuccessful == false) {
                boolean result = closed.compareAndSet(false, true);
import java.util.concurrent.TimeUnit;
     *
            if (semaphore.tryAcquire(TOTAL_PERMITS, timeout.seconds(), TimeUnit.SECONDS)) {
        } finally {
     */
    }
            return;
    protected TimeValue getNextRetryInterval() {
                    getLogger().info("All permits are released and refresh listener is open");
            scheduled = true;
     * @return true if a retry is needed else false.
            getLogger().debug("skip retry on retryScheduled=true");
                    assert wasClosed : "RefreshListener is not closed before reopening it";
    protected abstract boolean performAfterRefreshWithPermit(boolean didRefresh);
     */
     *
 * RefreshListener that runs afterRefresh method if and only if there is a permit available. Once the {@code drainRefreshes()}
                    assert semaphore.availablePermits() == TOTAL_PERMITS : "Available permits is " + semaphore.availablePermits();
import org.apache.lucene.search.ReferenceManager;
        return closed.get();
        }
     */
        }
