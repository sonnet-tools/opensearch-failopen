        } else {
import com.netflix.concurrency.limits.internal.EmptyMetricRegistry;
            this.registry = registry;
public class OpenSearchVegasLimit extends AbstractLimit {
            this.maxConcurrency = maxConcurrency;
 * <p>
                increaseConsecutive = 0;
        this.probeInflightThreshold = builder.probeInflightThreshold;
    public static Builder newBuilder() {
                    "Probe accepted MinRTT {} ms (inflight={}, limit={})",
        }
    // -------------------------------------------------------------------------
    private final IntUnaryOperator alphaFunc;
        /**
            return this;
            }
            newLimit = decreaseFunc.applyAsDouble(estimatedLimit);
        public Builder decreaseHysteresis(int decreaseHysteresis) {
            increaseConsecutive = 0;
            this.resetProbeJitter();
            this.rttSampleListener.addSample(this.rtt_noload);
            return this;
        private int increaseHysteresis = 1;
            this.probeMultiplier = probeMultiplier;
         */
         *
    // Vegas algorithm
         */
        }
 * Values {@literal >} 1 make the algorithm more permissive about raising the limit,
 * compatible open source license.
        this.smoothing = builder.smoothing;
                );
        this.rttSampleListener = builder.registry.distribution(MetricIds.MIN_RTT_NAME);
    private int updateEstimatedLimit(long rtt, int inflight, boolean didDrop) {
    private static final IntUnaryOperator LOG10 = limit -> (int) Math.ceil(Math.log10(limit));
                TimeUnit.NANOSECONDS.toMicros(rtt_noload) / 1000.0,
         * Fraction of the current limit below which a probe's RTT is accepted as
            if (queueSize <= threshold || queueSize < alpha) {
        public Builder probeInflightThreshold(double probeInflightThreshold) {
            LOG.debug(
    /** Builder for {@link OpenSearchVegasLimit}. */
            return this;
        return (int) newLimit;
        }
            decreaseConsecutive = 0;
                LOG.warn("Initial limit {} exceeded maximum limit {}", initialLimit, maxConcurrency);
            alpha = (int) (upDriftFactor * alphaFunc.applyAsInt((int) estimatedLimit));
         * Default 1 (act immediately). Higher values dampen upward thrashing.
                newLimit = decreaseFunc.applyAsDouble(estimatedLimit);
 *
        Random rng = Randomness.get();
         *
                (int) estimatedLimit,
         */
    private final int increaseHysteresis;
    private int increaseConsecutive = 0;
 */
            if (inflight <= estimatedLimit * probeInflightThreshold) {
         * @param probeInflightThreshold the threshold fraction
         * Sets the metric registry for RTT sampling.
        public Builder increaseHysteresis(int increaseHysteresis) {
            );
        /**
        public Builder upDriftFactor(double upDriftFactor) {
                    "Probe skipped baseline reset: inflight {} exceeds {}% of limit {}",
        private Builder() {}
            // Hard signal: bypass hysteresis, act immediately.
        private int decreaseHysteresis = 1;
import org.apache.logging.log4j.Logger;
    }
    public long getRttNoLoad(TimeUnit units) {
import java.util.function.IntUnaryOperator;
         *
                LOG.debug(
    private volatile double estimatedLimit;
            + TimeUnit.NANOSECONDS.toMicros(rtt_noload) / 1000.0
                this.rtt_noload = rtt;
         */
import org.opensearch.common.Randomness;
import java.util.concurrent.TimeUnit;
         * @param initialLimit the initial limit
            + upDriftFactor
            + ", probeInflightThreshold="
         */
     */
         * @param probeMultiplier the probe multiplier
         * Scales alpha, beta, and threshold by this factor and widens the drift-prevention
            + " ms"
                increaseConsecutive = 0;
    private final double upDriftFactor;
         */
        private IntUnaryOperator alphaFunc = limit -> 3 * LOG10.applyAsInt(limit);
                threshold
 * which helps during bursty workloads where requests cluster in time.
            decreaseConsecutive = 0;
import com.netflix.concurrency.limits.MetricRegistry;
 * TCP-Vegas-based adaptive concurrency limit with an {@code upDriftFactor} extension.
            }
            return (int) this.estimatedLimit;
                throw new IllegalArgumentException("probeInflightThreshold must be in [0.0, 1.0] but got " + probeInflightThreshold);
            + getLimit()
 * SPDX-License-Identifier: Apache-2.0
        }
                return (int) estimatedLimit;
    private static final Logger LOG = LogManager.getLogger(OpenSearchVegasLimit.class);
    private final double smoothing;
         * the probe still fires (counter and jitter reset) but the baseline is NOT
                "New limit={} old limit = {} minRtt={} ms winRtt={} ms queueSize={} alpha={} beta={} threshold={}",
                decreaseConsecutive = 0;
        }
    // -------------------------------------------------------------------------
import com.netflix.concurrency.limits.MetricRegistry.SampleListener;
         * Sets the maximum concurrency limit.
        }
        this.increaseHysteresis = builder.increaseHysteresis;
/*
                queueSize,
        this.maxLimit = builder.maxConcurrency;
                if (++increaseConsecutive < increaseHysteresis) return (int) estimatedLimit;
    // State
        /**
         * the new no-load baseline. When {@code inflight > estimatedLimit * probeInflightThreshold},
            this.probeInflightThreshold = probeInflightThreshold;
    // -------------------------------------------------------------------------
    /** Creates a new builder with default values. */
        public Builder initialLimit(int initialLimit) {
    // -------------------------------------------------------------------------
                    inflight,
    protected int _update(long startTime, long rtt, int inflight, boolean didDrop) {
            this.smoothing = smoothing;
    private final int decreaseHysteresis;
                LOG.debug(
    private final IntUnaryOperator betaFunc;
         */
    // -------------------------------------------------------------------------
        public Builder smoothing(double smoothing) {
    private final int maxLimit;
        double estimatedLimit = this.estimatedLimit;
        private int maxConcurrency = 1000;
            return this;
/**
        this.decreaseHysteresis = builder.decreaseHysteresis;
        this.thresholdFunc = builder.thresholdFunc;
        private int initialLimit = 20;
    private volatile long rtt_noload = 0;
    }
        } else if (inflight * (upDriftFactor + 1) < estimatedLimit) {
        if (this.shouldProbe()) {
    private int probeCount = 0;
        /**
                (int) newLimit,
        private MetricRegistry registry = EmptyMetricRegistry.INSTANCE;
            throw new IllegalArgumentException("rtt must be >0 but got " + rtt);
package org.opensearch.concurrency.limit;
import java.util.Random;
         * @param maxConcurrency the maximum limit
         * @param upDriftFactor the drift factor, must be &gt;= 1.0
            if (initialLimit > maxConcurrency) {
 * The OpenSearch Contributors require contributions made to
         *
            this.increaseHysteresis = increaseHysteresis;
            + ", upDriftFactor="
            return this;
        }
        public Builder metricRegistry(MetricRegistry registry) {
        probeJitter = 0.5 + rng.nextDouble() * 0.5;
    private double probeJitter;
            return new OpenSearchVegasLimit(this);
        return new Builder();
        int alpha = -1, beta = -1, threshold = -1;
            + ", rtt_noload="
                // Increase zone: require increaseHysteresis consecutive qualifying samples.
                decreaseConsecutive = 0;
            return (int) this.estimatedLimit;
            this.rtt_noload = rtt;
    private final SampleListener rttSampleListener;
        private double probeInflightThreshold = 0.5;
import com.netflix.concurrency.limits.limit.AbstractLimit;
            }
            LOG.debug("New MinRTT {}", (double) TimeUnit.NANOSECONDS.toMicros(rtt) / (double) 1000.0F);
        }
         * Range: [0.0, 1.0]. Default 0.5.
     * Returns the no-load baseline RTT in the requested time unit.
    private void resetProbeJitter() {
                decreaseConsecutive = 0;
        private DoubleUnaryOperator increaseFunc = limit -> limit + LOG10.applyAsInt((int) limit);
            return this;
            return this;
    @Override
        /** Builds the {@link OpenSearchVegasLimit} instance. */
        }
        probeCount++;
 * this file be licensed under the Apache-2.0 license or a
        double newLimit;
            return this;
                    inflight,
         * Default 1 (act immediately). Higher values dampen downward thrashing.
            threshold = (int) (upDriftFactor * thresholdFunc.applyAsInt((int) estimatedLimit));
    private final int probeMultiplier;
    private boolean shouldProbe() {
            return this.updateEstimatedLimit(rtt, inflight, didDrop);
         * @param decreaseHysteresis the consecutive sample threshold
                );
                // Decrease zone: require decreaseHysteresis consecutive qualifying samples.
        this.alphaFunc = builder.alphaFunc;
    private final DoubleUnaryOperator decreaseFunc;
        }
        this.estimatedLimit = newLimit;
    }
                beta,
            this.upDriftFactor = upDriftFactor;
            return this;
        return probeJitter * probeMultiplier * estimatedLimit <= probeCount;
        } else {
        }
         */
        /**
    @Override
import com.netflix.concurrency.limits.MetricIds;
}
        public OpenSearchVegasLimit build() {
        this.increaseFunc = builder.increaseFunc;
         * window from {@code inflight * 2} to {@code inflight * (upDriftFactor + 1)}.
            this.decreaseHysteresis = decreaseHysteresis;
 */
    }
     *
import java.util.function.DoubleUnaryOperator;
    }
        /**
            this.initialLimit = initialLimit;
        this.upDriftFactor = builder.upDriftFactor;
import org.apache.logging.log4j.LogManager;
        if ((int) newLimit != (int) estimatedLimit && LOG.isDebugEnabled()) {
    public static class Builder {
         * Sets the smoothing factor for limit updates.
        newLimit = (1 - smoothing) * estimatedLimit + smoothing * newLimit;
        private IntUnaryOperator thresholdFunc = LOG10;
        /**
                    (int) (probeInflightThreshold * 100),
            + "]";
        this.probeMultiplier = builder.probeMultiplier;
    private final double probeInflightThreshold;
        } else if (this.rtt_noload != 0L && rtt >= this.rtt_noload) {
         * @param increaseHysteresis the consecutive sample threshold
         * updated, preventing heavy-load RTT from poisoning {@code rtt_noload}.
        private DoubleUnaryOperator decreaseFunc = limit -> limit - LOG10.applyAsInt((int) limit);
    // Builder
         *
            return (int) estimatedLimit;
 * Extends Netflix's Vegas algorithm by scaling the alpha, beta, and threshold values
        this.estimatedLimit = builder.initialLimit;
        this.decreaseFunc = builder.decreaseFunc;
                    (double) TimeUnit.NANOSECONDS.toMicros(rtt) / 1000.0,
     * @param units the time unit for the result
        super(builder.initialLimit);
        public Builder maxConcurrency(int maxConcurrency) {
        /**
            } else if (queueSize > beta) {
            increaseConsecutive = 0;
        private double upDriftFactor = 1.0;
         * Number of consecutive qualifying samples required before decreasing the limit.
 * the output is mathematically identical to the stock Netflix {@code VegasLimit}.
        this.betaFunc = builder.betaFunc;
    }
         * Number of consecutive qualifying samples required before increasing the limit.
            beta = (int) (upDriftFactor * betaFunc.applyAsInt((int) estimatedLimit));
        }
        return "OpenSearchVegasLimit [limit="
            } else {
            }
    /**
                alpha,
                if (++decreaseConsecutive < decreaseHysteresis) return (int) estimatedLimit;
        resetProbeJitter();
        private int probeMultiplier = 30;
        }
            if (probeInflightThreshold < 0.0 || probeInflightThreshold > 1.0) {
         * @param registry the metric registry
        private IntUnaryOperator betaFunc = limit -> 6 * LOG10.applyAsInt(limit);
    }
    // -------------------------------------------------------------------------
         *
        if (rtt <= 0) {
        public Builder probeMultiplier(int probeMultiplier) {
         * @param smoothing the smoothing factor
                increaseConsecutive = 0;
            } else {
    private OpenSearchVegasLimit(Builder builder) {
        /**
         *
    private final DoubleUnaryOperator increaseFunc;
        }
    // Hysteresis: consecutive qualifying samples required before acting on increase/decrease signals.
            + probeInflightThreshold
    }
         * Sets the probe multiplier controlling probe frequency.
    private final IntUnaryOperator thresholdFunc;
         */
    public String toString() {
        private double smoothing = 1.0;
        if (didDrop) {
         * Sets the initial concurrency limit.
                    (int) estimatedLimit
                TimeUnit.NANOSECONDS.toMicros(rtt) / 1000.0,
    }
    private int decreaseConsecutive = 0;
        newLimit = Math.max(1, Math.min(maxLimit, newLimit));
        return units.convert(rtt_noload, TimeUnit.NANOSECONDS);
                newLimit = queueSize <= threshold ? estimatedLimit + beta : increaseFunc.applyAsDouble(estimatedLimit);
         *
 * and widening the drift-prevention window. At the default {@code upDriftFactor = 1}
        final int queueSize = (int) Math.ceil(estimatedLimit * (1 - (double) rtt_noload / rtt));
            this.probeCount = 0;
                    (int) estimatedLimit
         * Must be &gt;= 1.0. Default is 1.0 (standard Vegas behaviour).
