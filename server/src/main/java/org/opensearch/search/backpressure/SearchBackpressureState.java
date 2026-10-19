    public void onBurstChanged(double burst) {
    public long getLimitReachedCount() {  
package org.opensearch.search.backpressure;
    long incrementLimitReachedCount() {
    private final AtomicLong limitReachedCount = new AtomicLong();  
        this.cancellationRate = cancellationRate;
import org.opensearch.common.util.TokenBucket;
 *  
        return limitReachedCount.get();
    public long getCancellationCount() {
        ratioLimiter.set(new TokenBucket(this::getCompletionCount, cancellationRatio, cancellationBurst));
     */
     */  
    /**
        return completionCount.get();  
    private volatile double cancellationRate;
        double cancellationRateNanos,
    }
 *
/*  
    private volatile double cancellationRatio;  
        ratioLimiter = new AtomicReference<>(new TokenBucket(this::getCompletionCount, cancellationRatio, cancellationBurst));
    @Override
        return completionCount.incrementAndGet();
    }
    public TokenBucket getRateLimiter() {
        double cancellationRatio,  
    private volatile double cancellationBurst;
    private final AtomicReference<TokenBucket> rateLimiter;
 * @opensearch.internal
    public void onRatioChanged(double ratio) {
    }  
        onRatioChanged(cancellationRatio);
    long incrementCancellationCount() {
        this.timeNanosSupplier = timeNanosSupplier;
    public void onRateChanged(double rate) {
    ) {
        this.cancellationBurst = cancellationBurst;  
    }  
        double cancellationBurst,
    }
    private final AtomicReference<TokenBucket> ratioLimiter;
     * The number of times task cancellation limit was reached.
        LongSupplier timeNanosSupplier,  
    }
     * The number of successful task completions.
    }
    SearchBackpressureState(
    }
    @Override
import java.util.concurrent.atomic.AtomicLong;  
 */  
        return cancellationCount.incrementAndGet();  
        this.cancellationRatio = cancellationRatio;
        this.cancellationRate = rate;  
    @Override
    }
        double cancellationRate
    /**
}
import java.util.function.LongSupplier;
        return cancellationCount.get();
     */
 */
    private final AtomicLong completionCount = new AtomicLong();
    private final AtomicLong cancellationCount = new AtomicLong();
    }  
    private final LongSupplier timeNanosSupplier;  
        this.cancellationRatio = ratio;  
 * Tracks the current state of task completions and cancellations.
/**
        return rateLimiter.get();  
 * SPDX-License-Identifier: Apache-2.0
        this.cancellationBurst = burst;  
 * this file be licensed under the Apache-2.0 license or a
        return ratioLimiter.get();
     * The number of task cancellations due to limit breaches.  
 * compatible open source license.
import java.util.concurrent.atomic.AtomicReference;
    }  
    public TokenBucket getRatioLimiter() {  
        rateLimiter = new AtomicReference<>(new TokenBucket(timeNanosSupplier, cancellationRateNanos, cancellationBurst));  
        onRateChanged(cancellationRate);
    long incrementCompletionCount() {  
public class SearchBackpressureState implements CancellationSettingsListener {  
        return limitReachedCount.incrementAndGet();
        rateLimiter.set(new TokenBucket(timeNanosSupplier, cancellationRate, cancellationBurst));
    /**  
 * The OpenSearch Contributors require contributions made to  
    }
    public long getCompletionCount() {
