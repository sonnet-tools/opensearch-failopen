     * Checks if we have datapoints more than or equal to the window size
 */
     * Creates a new instance of MovingAverage with a new window size based on WindowDuration.  
public abstract class AbstractAverageUsageTracker extends AbstractLifecycleComponent {
        }
    protected final TimeValue pollingInterval;  
    @Override
    protected void doStop() {
     * cycles that fit in the window duration; a window shorter than the polling interval floors that ratio to zero.  
/**
            scheduledFuture.cancel();
    }
     * We clamp to a minimum of one observation rather than letting {@link MovingAverage} reject a zero size, because
     * This runs as a settings-update consumer at apply time. The moving-average window size is the number of polling
        long pollingNanos = pollingInterval.nanos();
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
        scheduledFuture = threadPool.scheduleWithFixedDelay(() -> {
import org.opensearch.common.unit.TimeValue;
        return pollingInterval;
     * Returns the moving average of the datapoints
import org.opensearch.threadpool.ThreadPool;
     */  
    public AbstractAverageUsageTracker(ThreadPool threadPool, TimeValue pollingInterval, TimeValue windowDuration) {  
     * throwing here would fail while cluster state is applied and could destabilize the cluster-manager. The window and
        this.pollingInterval = pollingInterval;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
    protected void doStart() {  
    protected final ThreadPool threadPool;
        }, pollingInterval, ThreadPool.Names.GENERIC);
        LOGGER.debug("updated window size: {}", windowSize);  
        observations.get().record(usage);
    public abstract long getUsage();
    }
/*  
     * <p>
 *
     */
import org.opensearch.common.util.MovingAverage;
        return observations.get().getCount();
    }  
    }  
    public TimeValue getPollingInterval() {
    private static final Logger LOGGER = LogManager.getLogger(AbstractAverageUsageTracker.class);  
        return observations.get().isReady();
        this.threadPool = threadPool;
 * The OpenSearch Contributors require contributions made to  
        int windowSize = pollingNanos <= 0 ? 1 : Math.max(1, (int) (windowDuration.nanos() / pollingNanos));
import org.apache.logging.log4j.LogManager;
        if (scheduledFuture != null) {  
     * polling interval are node-local ({@code polling_interval} is {@code NodeScope}-only), so the relationship cannot  
        return observations.get().getAverage();
    private TimeValue windowDuration;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.atomic.AtomicReference;  
    protected void doClose() {}  
        this.windowDuration = windowDuration;
    protected volatile Scheduler.Cancellable scheduledFuture;
 * compatible open source license.
    }
 */  
            recordUsage(usage);  
        // window. polling_interval is NodeScope-only and permits 0ms, so this is only reachable at node construction.  
    }
        return windowDuration;  
    }
    }  
package org.opensearch.node.resource.tracker;
        // Guard against a zero (or non-positive) polling interval before dividing; fall back to a single-observation
import org.opensearch.threadpool.Scheduler;  
        observations.set(new MovingAverage(windowSize));
    public TimeValue getWindowDuration() {
    public double getAverage() {  
    private final AtomicReference<MovingAverage> observations = new AtomicReference<>();
}
    public void setWindowSize(TimeValue windowDuration) {  
            long usage = getUsage();
    }  
 * Base class for sliding window resource usage trackers  
     * be validated up front by a settings {@code Validator}.
 * this file be licensed under the Apache-2.0 license or a
    public void recordUsage(long usage) {
    public boolean isReady() {
     */
    /**
    public long getWindowSize() {  
    /**  
    @Override
        this.windowDuration = windowDuration;  
    @Override
        this.setWindowSize(windowDuration);
