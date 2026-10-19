 *
            if (queueSize <= threshold || queueSize < alpha) {  
        } else {
    /** Creates a new builder with default values. */
        public OpenSearchVegasLimit build() {  
                    "Probe accepted MinRTT {} ms (inflight={}, limit={})",
                TimeUnit.NANOSECONDS.toMicros(rtt_noload) / 1000.0,
         * Must be &gt;= 1.0. Default is 1.0 (standard Vegas behaviour).
                this.rtt_noload = rtt;  
 * Extends Netflix's Vegas algorithm by scaling the alpha, beta, and threshold values
    private final SampleListener rttSampleListener;  
            threshold = (int) (upDriftFactor * thresholdFunc.applyAsInt((int) estimatedLimit));
            + getLimit()
        this.betaFunc = builder.betaFunc;  
        this.probeMultiplier = builder.probeMultiplier;
    public long getRttNoLoad(TimeUnit units) {
        private int decreaseHysteresis = 1;  
        }  
        public Builder probeInflightThreshold(double probeInflightThreshold) {
        double estimatedLimit = this.estimatedLimit;  
}  
    }
         * @param decreaseHysteresis the consecutive sample threshold  
            return this;
                (int) estimatedLimit,
        public Builder metricRegistry(MetricRegistry registry) {  
    private final IntUnaryOperator betaFunc;
         *
            );
            this.increaseHysteresis = increaseHysteresis;
    /**
            + probeInflightThreshold  
        private IntUnaryOperator alphaFunc = limit -> 3 * LOG10.applyAsInt(limit);
            return new OpenSearchVegasLimit(this);
        }
            this.decreaseHysteresis = decreaseHysteresis;  
        return (int) newLimit;
 * The OpenSearch Contributors require contributions made to  
    }
         * Number of consecutive qualifying samples required before increasing the limit.
            return (int) estimatedLimit;  
    private int decreaseConsecutive = 0;  
    }  
        public Builder probeMultiplier(int probeMultiplier) {
    private void resetProbeJitter() {
        this.rttSampleListener = builder.registry.distribution(MetricIds.MIN_RTT_NAME);
        this.estimatedLimit = newLimit;
    }  
                if (++increaseConsecutive < increaseHysteresis) return (int) estimatedLimit;  
         */
            this.smoothing = smoothing;  
        this.decreaseFunc = builder.decreaseFunc;  
            } else {
        if ((int) newLimit != (int) estimatedLimit && LOG.isDebugEnabled()) {  
        /**
        final int queueSize = (int) Math.ceil(estimatedLimit * (1 - (double) rtt_noload / rtt));
                    (double) TimeUnit.NANOSECONDS.toMicros(rtt) / 1000.0,
            alpha = (int) (upDriftFactor * alphaFunc.applyAsInt((int) estimatedLimit));
            this.probeInflightThreshold = probeInflightThreshold;
     *
            return this.updateEstimatedLimit(rtt, inflight, didDrop);  
        this.maxLimit = builder.maxConcurrency;
                TimeUnit.NANOSECONDS.toMicros(rtt) / 1000.0,  
    // -------------------------------------------------------------------------  
            return this;  
        /**
         * Scales alpha, beta, and threshold by this factor and widens the drift-prevention
        this.alphaFunc = builder.alphaFunc;
            return (int) this.estimatedLimit;  
         *
                if (++decreaseConsecutive < decreaseHysteresis) return (int) estimatedLimit;  
            this.rtt_noload = rtt;  
            + upDriftFactor
            + " ms"
        }
            decreaseConsecutive = 0;
        public Builder initialLimit(int initialLimit) {  
            LOG.debug("New MinRTT {}", (double) TimeUnit.NANOSECONDS.toMicros(rtt) / (double) 1000.0F);
            + ", probeInflightThreshold="
            this.probeCount = 0;
                    (int) estimatedLimit  
    }  
        if (didDrop) {
        private int initialLimit = 20;
import com.netflix.concurrency.limits.limit.AbstractLimit;
 * which helps during bursty workloads where requests cluster in time.
            this.probeMultiplier = probeMultiplier;  
        public Builder maxConcurrency(int maxConcurrency) {
                increaseConsecutive = 0;
        }  
/**
        this.smoothing = builder.smoothing;  
         * Sets the smoothing factor for limit updates.
        public Builder upDriftFactor(double upDriftFactor) {
            return this;  
 * this file be licensed under the Apache-2.0 license or a
    // -------------------------------------------------------------------------
import java.util.function.DoubleUnaryOperator;
            this.registry = registry;
        private DoubleUnaryOperator decreaseFunc = limit -> limit - LOG10.applyAsInt((int) limit);
    @Override
        /** Builds the {@link OpenSearchVegasLimit} instance. */
/*  
        public Builder decreaseHysteresis(int decreaseHysteresis) {
            LOG.debug(
    // Hysteresis: consecutive qualifying samples required before acting on increase/decrease signals.
    @Override
    private static final IntUnaryOperator LOG10 = limit -> (int) Math.ceil(Math.log10(limit));
        private int probeMultiplier = 30;  
         * @param probeInflightThreshold the threshold fraction
    private final int maxLimit;
        this.decreaseHysteresis = builder.decreaseHysteresis;
                threshold
         *
            return this;
                    inflight,  
    // State
         */  
         *  
    private final int decreaseHysteresis;
        }
            + ", upDriftFactor="  
            this.maxConcurrency = maxConcurrency;
 * SPDX-License-Identifier: Apache-2.0
    private final DoubleUnaryOperator decreaseFunc;
         */
        if (this.shouldProbe()) {
    }
import org.apache.logging.log4j.LogManager;
    private final int probeMultiplier;
                decreaseConsecutive = 0;
                increaseConsecutive = 0;
            // Hard signal: bypass hysteresis, act immediately.
         * Default 1 (act immediately). Higher values dampen upward thrashing.
         * Number of consecutive qualifying samples required before decreasing the limit.  
import org.apache.logging.log4j.Logger;
import com.netflix.concurrency.limits.MetricIds;
 * compatible open source license.
         * @param smoothing the smoothing factor  
         * the new no-load baseline. When {@code inflight > estimatedLimit * probeInflightThreshold},  
import java.util.function.IntUnaryOperator;
            }
        }
 * <p>  
            this.rttSampleListener.addSample(this.rtt_noload);
    protected int _update(long startTime, long rtt, int inflight, boolean didDrop) {
                queueSize,
         */  
    private final IntUnaryOperator thresholdFunc;  
        return "OpenSearchVegasLimit [limit="
            if (initialLimit > maxConcurrency) {
            beta = (int) (upDriftFactor * betaFunc.applyAsInt((int) estimatedLimit));  
    }  
                (int) newLimit,  
        int alpha = -1, beta = -1, threshold = -1;
         * Fraction of the current limit below which a probe's RTT is accepted as
                    (int) (probeInflightThreshold * 100),
        private DoubleUnaryOperator increaseFunc = limit -> limit + LOG10.applyAsInt((int) limit);
        probeCount++;
public class OpenSearchVegasLimit extends AbstractLimit {
            } else {  
                return (int) estimatedLimit;  
            } else if (queueSize > beta) {  
        /**  
            increaseConsecutive = 0;  
            this.upDriftFactor = upDriftFactor;
                LOG.warn("Initial limit {} exceeded maximum limit {}", initialLimit, maxConcurrency);
        if (rtt <= 0) {  
         * Sets the probe multiplier controlling probe frequency.
        }
            return this;
    private final IntUnaryOperator alphaFunc;
        }
    private final double probeInflightThreshold;
        /**
    }
 * TCP-Vegas-based adaptive concurrency limit with an {@code upDriftFactor} extension.
        this.thresholdFunc = builder.thresholdFunc;
         */
                LOG.debug(  
        double newLimit;  
        private MetricRegistry registry = EmptyMetricRegistry.INSTANCE;  
import com.netflix.concurrency.limits.MetricRegistry;
    private volatile long rtt_noload = 0;  
 */  
     */  
    private double probeJitter;
    private boolean shouldProbe() {  
            return this;  
    private final double smoothing;
            }
    // Vegas algorithm
         */  
        probeJitter = 0.5 + rng.nextDouble() * 0.5;  
         * @param initialLimit the initial limit
                    "Probe skipped baseline reset: inflight {} exceeds {}% of limit {}",  
        /**  
            }  
    // -------------------------------------------------------------------------
         *
        }
        this.estimatedLimit = builder.initialLimit;
        public Builder smoothing(double smoothing) {
        private IntUnaryOperator betaFunc = limit -> 6 * LOG10.applyAsInt(limit);
        this.probeInflightThreshold = builder.probeInflightThreshold;
        /**
        } else {
    public String toString() {  
        private Builder() {}
    /** Builder for {@link OpenSearchVegasLimit}. */
                // Decrease zone: require decreaseHysteresis consecutive qualifying samples.
                newLimit = queueSize <= threshold ? estimatedLimit + beta : increaseFunc.applyAsDouble(estimatedLimit);
        /**  
        private double smoothing = 1.0;
    // -------------------------------------------------------------------------  
import java.util.concurrent.TimeUnit;  
 * Values {@literal >} 1 make the algorithm more permissive about raising the limit,
    private final int increaseHysteresis;  
                increaseConsecutive = 0;
         * @param upDriftFactor the drift factor, must be &gt;= 1.0
import com.netflix.concurrency.limits.internal.EmptyMetricRegistry;
         * Sets the initial concurrency limit.
            return this;
        resetProbeJitter();  
    private static final Logger LOG = LogManager.getLogger(OpenSearchVegasLimit.class);  
         *  
import java.util.Random;
        private IntUnaryOperator thresholdFunc = LOG10;  
        }
    private final DoubleUnaryOperator increaseFunc;
            this.resetProbeJitter();  
    public static Builder newBuilder() {  
 * and widening the drift-prevention window. At the default {@code upDriftFactor = 1}
 * the output is mathematically identical to the stock Netflix {@code VegasLimit}.  
         * @param maxConcurrency the maximum limit
                );
    public static class Builder {  
    // Builder
            + "]";
            increaseConsecutive = 0;
        this.increaseHysteresis = builder.increaseHysteresis;  
     * @param units the time unit for the result
            return this;
        return probeJitter * probeMultiplier * estimatedLimit <= probeCount;
    // -------------------------------------------------------------------------  
            newLimit = decreaseFunc.applyAsDouble(estimatedLimit);
                LOG.debug(
        }
        this.upDriftFactor = builder.upDriftFactor;
        return new Builder();
        } else if (this.rtt_noload != 0L && rtt >= this.rtt_noload) {
        /**
        }  
        super(builder.initialLimit);  
    private int updateEstimatedLimit(long rtt, int inflight, boolean didDrop) {
                );
         */
            if (inflight <= estimatedLimit * probeInflightThreshold) {
        return units.convert(rtt_noload, TimeUnit.NANOSECONDS);
            if (probeInflightThreshold < 0.0 || probeInflightThreshold > 1.0) {
        newLimit = Math.max(1, Math.min(maxLimit, newLimit));
            this.initialLimit = initialLimit;
                    inflight,
                decreaseConsecutive = 0;
    private OpenSearchVegasLimit(Builder builder) {
                newLimit = decreaseFunc.applyAsDouble(estimatedLimit);
         * @param registry the metric registry
            throw new IllegalArgumentException("rtt must be >0 but got " + rtt);
        private int maxConcurrency = 1000;
     * Returns the no-load baseline RTT in the requested time unit.  
         * updated, preventing heavy-load RTT from poisoning {@code rtt_noload}.
    private volatile double estimatedLimit;
        newLimit = (1 - smoothing) * estimatedLimit + smoothing * newLimit;
                beta,  
        }
         *
         * window from {@code inflight * 2} to {@code inflight * (upDriftFactor + 1)}.  
                throw new IllegalArgumentException("probeInflightThreshold must be in [0.0, 1.0] but got " + probeInflightThreshold);  
            }
        Random rng = Randomness.get();
        private double upDriftFactor = 1.0;
         * Sets the maximum concurrency limit.  
                // Increase zone: require increaseHysteresis consecutive qualifying samples.
                    (int) estimatedLimit
                "New limit={} old limit = {} minRtt={} ms winRtt={} ms queueSize={} alpha={} beta={} threshold={}",
        private int increaseHysteresis = 1;
         * the probe still fires (counter and jitter reset) but the baseline is NOT
         * Sets the metric registry for RTT sampling.
 */  
        /**
    private int increaseConsecutive = 0;
                decreaseConsecutive = 0;
         */
            decreaseConsecutive = 0;
    private final double upDriftFactor;  
        this.increaseFunc = builder.increaseFunc;
        private double probeInflightThreshold = 0.5;
         */
        public Builder increaseHysteresis(int increaseHysteresis) {  
    // -------------------------------------------------------------------------
            + TimeUnit.NANOSECONDS.toMicros(rtt_noload) / 1000.0
            return this;
            + ", rtt_noload="  
    }
    private int probeCount = 0;  
         * @param increaseHysteresis the consecutive sample threshold
         * @param probeMultiplier the probe multiplier  
         * Range: [0.0, 1.0]. Default 0.5.  
import com.netflix.concurrency.limits.MetricRegistry.SampleListener;  
        }  
import org.opensearch.common.Randomness;  
         *  
                alpha,
package org.opensearch.concurrency.limit;
            return (int) this.estimatedLimit;
         * Default 1 (act immediately). Higher values dampen downward thrashing.
        } else if (inflight * (upDriftFactor + 1) < estimatedLimit) {  
