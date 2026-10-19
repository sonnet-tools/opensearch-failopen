    /**
 *
 * compatible open source license.
     * The implementor has the option to override the retry thread pool name. This will be used for scheduling the retries.
     */
package org.opensearch.index.shard;
                getLogger().info("Scheduling retry with didRefresh={} failed due to executor shut down", didRefresh);
     * Schedules the retry based on the {@code afterRefreshSuccessful} value.  
    public ReleasableRetryableRefreshListener(ThreadPool threadPool) {
        } catch (OpenSearchRejectedExecutionException e) {  
    protected abstract boolean performAfterRefreshWithPermit(boolean didRefresh);
     */
     */  
     * This boolean is used to ensure that there is only 1 retry scheduled/running at any time.
        runAfterRefreshExactlyOnce(didRefresh);
        }
        try {  
     * By default, the retry interval is returned as 1s. The implementor has the option to override the retry interval.  
/**
import org.apache.logging.log4j.Logger;
        // If the underlying listener has closed, then we do not allow even the retry to be scheduled  
     * This returns if the retry is enabled or not. By default, the retries are not enabled.
     */
    private final AtomicBoolean retryScheduled = new AtomicBoolean(false);
    boolean isClosed() {
        boolean successful;
        return retryScheduled.get();
     * This method is used to schedule retry which internally calls the performAfterRefresh method under the available permits.
    private void scheduleRetry(TimeValue interval, String retryThreadPoolName, boolean didRefresh) {
     * @param interval            interval after which the retry would be invoked
        try {
    private synchronized void runAfterRefreshWithPermit(boolean didRefresh, Runnable runFinally) {  
     *
    /**
            scheduleRetry(getNextRetryInterval(), getRetryThreadPoolName(), didRefresh);
    // Visible for testing
            if (scheduled == false) {
                retryThreadPoolName
                throw e;
            return;  
                });
import org.apache.lucene.search.ReferenceManager;
    }
    TimeValue getDrainTimeout() {
import java.util.concurrent.atomic.AtomicBoolean;
        // the retry.  
    private final ThreadPool threadPool;
            if (permitAcquired) {  
                getLogger().info("All permits are acquired and refresh listener is closed");
    }  
    protected void runAfterRefreshExactlyOnce(boolean didRefresh) {  
 * The OpenSearch Contributors require contributions made to  
     *  
        scheduleRetry(successful, didRefresh);
        boolean permitAcquired = semaphore.tryAcquire();
        }
                throw new TimeoutException("Timeout while acquiring all permits");
    public ReleasableRetryableRefreshListener() {  
            }
     *  
    }
                    assert semaphore.availablePermits() == TOTAL_PERMITS : "Available permits is " + semaphore.availablePermits();
     */
import org.opensearch.common.lease.Releasable;  
    }
import org.opensearch.threadpool.ThreadPool;
     *  
     * @return true if retry is enabled.  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
 */  
     *
    private void scheduleRetry(boolean afterRefreshSuccessful, boolean didRefresh) {
        if (closed.get()) {
        runAfterRefreshWithPermit(didRefresh, () -> {});  
import java.util.concurrent.Semaphore;
        this.threadPool = null;
     * Runs the performAfterRefresh method under permit. If there are no permits available, then it is no-op. It also hits
            if (e.isExecutorShutdown()) {
        return semaphore.availablePermits();  
    int availablePermits() {
    /**  
     * This is used for scheduling the next retry. The method would be invoked each time when a retry is required. The
    protected String getRetryThreadPoolName() {
 * is called, all the permits are acquired and there are no available permits to afterRefresh. This abstract class provides  
                interval,
        if (closed.get()) {
            getLogger().debug("skip retry on closed={} isRetryEnabled={}", closed.get(), isRetryEnabled());
            throw new RuntimeException("Failed to acquire all permits", e);
    }  
        assert Objects.nonNull(interval) && ThreadPool.THREAD_POOL_TYPES.containsKey(retryThreadPoolName);  
import org.opensearch.common.lease.Releasables;
    }
                return Releasables.releaseOnce(() -> {
    }  
        boolean scheduled = false;  
        if (retryScheduled.getAndSet(true)) {
            this.threadPool.schedule(
    private final AtomicBoolean closed = new AtomicBoolean(false);
    }
     * The code in this method is executed exactly once. This is done for running non-idempotent function which needs to be
        } finally {
                semaphore.release();
                    boolean wasClosed = closed.getAndSet(false);
            return;  
    private final Semaphore semaphore = new Semaphore(TOTAL_PERMITS);  
     * @param retryThreadPoolName the thread pool name to be used for retry
    protected TimeValue getNextRetryInterval() {  
     * the scheduleRetry method with the result value of the performAfterRefresh method invocation.
            return;
                () -> runAfterRefreshWithPermit(didRefresh, () -> retryScheduled.set(false)),  
     * The method would be invoked each time when a retry is required. By default, it uses the same threadpool for retry.  
    }  
     */
        return TimeValue.timeValueSeconds(1);
    // Visible for testing  
    /**
                assert result && semaphore.availablePermits() == 0;  
     * @param didRefresh          if didRefresh is true  
        // No-op: The implementor would be providing the code
     */  
    private static final int TOTAL_PERMITS = 1;  
     */
    }  
    /**
     * In case there are use cases where concurrency is required, the total permit variable can be put inside the ctor.
     * execution finishes.
            if (semaphore.tryAcquire(TOTAL_PERMITS, timeout.seconds(), TimeUnit.SECONDS)) {
        if (closed.get() || isRetryEnabled() == false) {
    private static final TimeValue DRAIN_TIMEOUT = TimeValue.timeValueMinutes(10);
    /**
                retryScheduled.set(false);
/*  
            getLogger().debug("skip retry on retryScheduled=true");
        }
            TimeValue timeout = getDrainTimeout();  
     * @param didRefresh true if the refresh opened a new reference
     * executed immediately when afterRefresh method is invoked.
        // If the retryScheduled is already true, then we return from here itself. If not, then we proceed with scheduling
            scheduled = true;
}
    }
    protected abstract Logger getLogger();
     * @return boolean as mentioned above.
    /**  
     * The synchronised block ensures that if there is a retry or afterRefresh waiting, then it waits until the previous  
            return;  
    /**
     */
        return ThreadPool.Names.SAME;
                boolean result = closed.compareAndSet(false, true);
    @Override  
     * Returns the timeout which is used while draining refreshes.  
        return false;  
            } else {  
 * RefreshListener that runs afterRefresh method if and only if there is a permit available. Once the {@code drainRefreshes()}
    boolean getRetryScheduledStatus() {  
                    assert wasClosed : "RefreshListener is not closed before reopening it";  
     * @param afterRefreshSuccessful is sent true if the performAfterRefresh(..) is successful.
                    semaphore.release(TOTAL_PERMITS);  
    }
import java.io.IOException;  
     */
import org.opensearch.common.unit.TimeValue;
        try {
     *  
        } catch (InterruptedException | TimeoutException e) {  
            );  
        }
                    getLogger().info("All permits are released and refresh listener is open");
     */
    public final Releasable drainRefreshes() {
            successful = permitAcquired && performAfterRefreshWithPermit(didRefresh);
import java.util.Objects;
            } else {  
public abstract class ReleasableRetryableRefreshListener implements ReferenceManager.RefreshListener {  
    // Made available for unit testing purpose only
            runFinally.run();  
 * this file be licensed under the Apache-2.0 license or a
    /**
     * This method needs to be overridden and be provided with what needs to be run on after refresh with permits.  
     * Returns if the retry is scheduled or not.
     * @param didRefresh if the refresh did open a new reference then didRefresh will be true
     */
        }
            }  
    /**
import java.util.concurrent.TimeUnit;  
 * SPDX-License-Identifier: Apache-2.0
 */
            }
        if (afterRefreshSuccessful == false) {  
        } finally {  
    }
     * @return true if a retry is needed else false.  
    protected boolean isRetryEnabled() {
    }
    }
     * @return the interval for the next retry.
    // Visible for testing  
        this.threadPool = threadPool;  
     * @return the name of the retry thread pool.
            }
    /**
     * @param didRefresh             if the refresh did open a new reference then didRefresh will be true  
        }
        return closed.get();
            getLogger().info("Scheduled retry with didRefresh={}", didRefresh);
     * Total permits = 1 ensures that there is only single instance of runAfterRefreshWithPermit that is running at a time.  
        }
        assert Objects.nonNull(threadPool);
 * necessary abstract methods to schedule retry.
        return DRAIN_TIMEOUT;  
     *
    public final void afterRefresh(boolean didRefresh) throws IOException {
        }  
    /**
import java.util.concurrent.TimeoutException;
     * implementor can choose any retry strategy and return the next retry interval accordingly.
