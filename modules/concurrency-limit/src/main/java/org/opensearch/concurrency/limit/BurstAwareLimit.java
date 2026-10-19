    public BurstAwareLimit(AbstractLimit delegate, int burstCapacity, int closeThreshold, int recoveryThreshold) {
import com.netflix.concurrency.limits.limit.AbstractLimit;  
            } else {  
    public void notifyOnChange(Consumer<Integer> consumer) {
    @Override  
    private final int recoveryThreshold;  
}  
                    consecutiveBelowBase = 0;  
        delegate.notifyOnChange(newBase -> {
    private int consecutiveBelowBase = 0;  
 * It closes after {@code closeThreshold} consecutive samples where {@code inflight >= delegate.getLimit()},  
 * Any sample that breaks the streak resets the active counter.
     * Creates a new burst-aware limit wrapping the given delegate.
 *
            }
        delegate.onSample(startTime, rtt, clamped, dropped);
            updateLimit(newEffective);
    private volatile int limit;
 * compatible open source license.
     */
     * @param burstCapacity extra capacity when burst window is open
                    updateLimit(delegate.getLimit());  
import com.netflix.concurrency.limits.Limit;
        return limit;  
                    updateLimit(delegate.getLimit() + burstCapacity);
    private int consecutiveOverBase = 0;
    private final AbstractLimit delegate;  
 * this file be licensed under the Apache-2.0 license or a
    }  
 */  
                    burstOpen = false;
import java.util.List;
                consecutiveBelowBase = 0;
        int clamped = Math.min(inflight, delegate.getLimit());
     * @param closeThreshold consecutive over-base samples to close the burst window
 * The burst window starts open: effective semaphore size = {@code delegate.getLimit() + burstCapacity}.
            } else {
 * SPDX-License-Identifier: Apache-2.0
                consecutiveOverBase = 0;  
/*  
    @Override
 * Inflight is clamped to {@code delegate.getLimit()} before passing to the delegate so that
    }
        this.limit = delegate.getLimit() + burstCapacity;
    public AbstractLimit getDelegate() {  
    /**  
    private final int burstCapacity;
        return delegate;
 * and reopens after {@code recoveryThreshold} consecutive samples where {@code inflight < delegate.getLimit()}.
import java.util.function.Consumer;  
    /** Returns the wrapped delegate limit algorithm. */
/**
        });
     * @param recoveryThreshold consecutive below-base samples to reopen the burst window  
     * @param delegate the adaptive limit algorithm  
                if (++consecutiveBelowBase >= recoveryThreshold) {
    private void updateLimit(int newLimit) {  
                    consecutiveOverBase = 0;
                }
    @Override
        this.delegate = delegate;  
            if (inflight >= delegate.getLimit()) {
    private final int closeThreshold;
 * A limit wrapper that adds a fixed burst capacity above the delegate algorithm's adaptive base limit.  
package org.opensearch.concurrency.limit;
 * <p>
    private boolean burstOpen = true;
    private final List<Consumer<Integer>> listeners = new CopyOnWriteArrayList<>();  
            limit = newLimit;
            listeners.forEach(l -> l.accept(newLimit));  
                }
 */  
            }
        }  
    public int getLimit() {
            if (inflight < delegate.getLimit()) {  
        } else {
    }
    public synchronized void onSample(long startTime, long rtt, int inflight, boolean dropped) {  
     *
        this.recoveryThreshold = recoveryThreshold;  
        if (burstOpen) {
    }  
        this.closeThreshold = closeThreshold;
 * burst-range requests do not distort the algorithm's queue-size estimate.
            int newEffective = newBase + (burstOpen ? burstCapacity : 0);  
    }
 * The OpenSearch Contributors require contributions made to  
                    burstOpen = true;
                if (++consecutiveOverBase >= closeThreshold) {  
        this.burstCapacity = burstCapacity;
import java.util.concurrent.CopyOnWriteArrayList;
        if (newLimit != limit) {
 * <p>  
        }
public final class BurstAwareLimit implements Limit {
    }
        listeners.add(consumer);
