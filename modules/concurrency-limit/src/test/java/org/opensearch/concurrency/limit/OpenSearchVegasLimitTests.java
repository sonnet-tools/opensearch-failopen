        limit.onSample(0, lowRtt, 20, false);
        assertNotEquals("threshold=1.0 must disable the guard — baseline should change", baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
    public void testMinRttPathUnaffectedByThreshold() {
            .probeMultiplier(1)
        boolean diverged = false;
        assertTrue("limit should grow after hitting hysteresis threshold", limit.getLimit() >= before);
        }
package org.opensearch.concurrency.limit;
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
    }
    }
        assertEquals(defaultFactor.getLimit(), explicitOne.getLimit());
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(200).decreaseHysteresis(10).build();
        assertEquals(5, limit.getLimit());
        assertEquals(highRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
        limit.onSample(0, highRtt, 5, false);
        // factor=1 → 5*2=10 < 20 → drift PREVENTED
        limit.onSample(0, slowRtt, 30, false);  // decreaseConsecutive → 2, no fire
    // -------------------------------------------------------------------------
            .maxConcurrency(200)
        factor1_5.onSample(0, baseRtt, 10, false);
            .initialLimit(20)
        limit.onSample(0, baseRtt, 5, false);
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0L, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
        limit.onSample(0, baseRtt, 10, false);
        // Verify that upDriftFactor=1.5 produces different alpha/beta/threshold
        int afterFactor1 = limit.getLimit();
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(1000).upDriftFactor(1.0).build();
        assertEquals("min-RTT path must be unconditional even with threshold=0.0", lowRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
        limit.onSample(0, baseRtt, 10, false);
            .probeMultiplier(1)
        limit.onSample(0, baseRtt, 5, false); // record noload
        int before = limit.getLimit();
        limit.onSample(System.nanoTime() - rttNanos, rttNanos, 5, false);
        limit.onSample(0, baseRtt, 5, false);
        expectThrows(IllegalArgumentException.class, () -> limit.onSample(0, -1, 5, false));
        for (int i = 0; i < 200; i++) {
        // inflight=15 > 20*0.5=10 → probes should skip baseline reset
        assertEquals(20, limit.getLimit());
    // -------------------------------------------------------------------------
    }
        limit.onSample(0, baseRtt, 10, false);  // counter → 2, no fire
    }
        }
        long rttNanos = TimeUnit.MILLISECONDS.toNanos(50);
    // -------------------------------------------------------------------------
    // Hysteresis
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()
            int inflight = 10 + i % 8;
            .maxConcurrency(500)
    public void testProbeAcceptsBaselineWhenInflightBelowThreshold() {
    public void testDropAlwaysDecreasesLimit() {
        // We test that a limit with high factor doesn't reject updates when inflight
        for (int i = 0; i < 100; i++) {
    }
    // -------------------------------------------------------------------------
        limit.onSample(0, sameRtt, 5, false);
    public void testInvalidProbeInflightThresholdThrows() {
    }
        int before = limit.getLimit();
        long slowRtt = TimeUnit.MILLISECONDS.toNanos(50);
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
    }
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()
        // factor=1 → 10*2=20 >= 20 → drift allowed too
    }
    // -------------------------------------------------------------------------
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).build();
    // upDriftFactor = 1.0 matches standard Vegas behaviour at defaults
    // Fractional upDriftFactor
    // -------------------------------------------------------------------------
        int after = limit.getLimit();
        }
        // Single drop event — hysteresis counter should be irrelevant
    public void testHigherUpDriftFactorAllowsMoreGrowth() {
        for (int i = 0; i < 50; i++)
        String str = limit.toString();
        // limit=20, inflight=10: factor=3 → 10*4=40 >= 20 → drift allowed
            .build();
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
    // upDriftFactor > 1 widens the no-drift window
            .initialLimit(20)
            .build();
    }
        limit.onSample(0, highRtt, 10, true);
        // so any difference in limit evolution proves the fractional factor took effect.
    // -------------------------------------------------------------------------
    }
    // -------------------------------------------------------------------------
        // Drive both limiters with identical samples and compare outcomes.
        // increaseHysteresis=4: the counter increments on each qualifying sample; after N samples
    }
        limit.onSample(0, slowRtt, 30, false);  // decreaseConsecutive → 1, no fire
        factor1.onSample(0, baseRtt, 10, false);
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(5).maxConcurrency(100).upDriftFactor(2.0).build();
        long sameRtt = TimeUnit.MILLISECONDS.toNanos(10);
    }
            limit.onSample(0, newRtt, 15, false);
            .maxConcurrency(200)
        expectThrows(IllegalArgumentException.class, () -> limit.onSample(0, 0, 5, false));
        assertEquals(rtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(200).increaseHysteresis(4).build();
    // -------------------------------------------------------------------------
        // decreaseHysteresis=3: after 2 slow samples limit must not drop; after the 3rd it must.
    public void testRttNoLoadUpdatedOnFirstSample() {
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).build();
    // -------------------------------------------------------------------------
/*
    }
            .initialLimit(50)
        for (int i = 0; i < 200; i++) {
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).build();
        // Establish a fast baseline; inflight=30 ensures the drift check (inflight*2 < limit) fails
            .build();
        assertTrue(str.contains("OpenSearchVegasLimit"));
        assertEquals("limit must not drop before hysteresis threshold", before, limit.getLimit());
            limit.onSample(0, newRtt, 5, false);
    }
    }
    }
        long lowRtt = TimeUnit.MILLISECONDS.toNanos(5);
        // With moderate RTT inflation and inflight well below limit, Vegas won't shrink limit below 15.
        // After samples 2+3 it still shouldn't fire (counter is 2 and 3, both < 4).
        long highRtt = TimeUnit.MILLISECONDS.toNanos(50);
            .build();
        }
        // Both limiters start at the same initial limit and get the same samples,
    public void testNegativeRttThrows() {
    // RTT tracking
    // -------------------------------------------------------------------------
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("limit must not grow before hysteresis threshold", before, limit.getLimit());
        long newRtt = TimeUnit.MILLISECONDS.toNanos(15);
            .increaseHysteresis(1000)
        // With default (factor=1): inflight * 2 < limit → 4*2=8 < 20 → also no drift
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(42).build();
            .maxConcurrency(200)
            .probeInflightThreshold(0.0)
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()
        // So a limit of 20 with 4 in-flight (4*4=16 < 20) would NOT drift upward
            .build();
        assertTrue("drop must immediately reduce limit ignoring hysteresis", limit.getLimit() <= before);
        // Simulate a drop with high RTT — limit should decrease
    }
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(200).build();
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
        limit.onSample(0, highRtt, 10, true);
        assertTrue("upDriftFactor=1.5 must produce different limit evolution than 1.0", diverged);
    // -------------------------------------------------------------------------
        assertEquals("factor=1 should prevent upward drift at inflight=5 vs limit=20", beforeFactor1, afterFactor1);
            .initialLimit(20)
    public void testDefaultFactorDoesNotChangeInitialLimit() {
    // Builder defaults
        OpenSearchVegasLimit factor1_5 = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(200).upDriftFactor(1.5).build();
        // Establish a baseline noload RTT first
        expectThrows(IllegalArgumentException.class, () -> OpenSearchVegasLimit.newBuilder().probeInflightThreshold(-0.1));
    }
        limit.onSample(0, baseRtt, 10, false);  // baseline + increaseConsecutive → 1
            .probeMultiplier(1)
        // Establish baseline
 *
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()
    public void testDropBypassesDecreaseHysteresis() {
    // Probe inflight threshold
        for (int i = 0; i < 200; i++) {
        long inflatedRtt = TimeUnit.MILLISECONDS.toNanos(50);
        // High RTT → queueSize ≈ 45 > beta ≈ 12 → decrease zone
            factor1_5.onSample(0, rtt, inflight, false);
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(1000).build();
    // -------------------------------------------------------------------------
                diverged = true;
    // -------------------------------------------------------------------------
    // invalid rtt
        int beforeFactor1 = limit.getLimit();
import java.util.concurrent.TimeUnit;
            .initialLimit(20)
        long rtt = TimeUnit.MILLISECONDS.toNanos(10);
            .probeInflightThreshold(0.5)
        // inflight=15, threshold=1.0 → 15 <= limit*1.0 as long as limit >= 15.
            limit.onSample(0, inflatedRtt, 15, false);
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
        int before = limit.getLimit();
        // With factor=1 and inflight=5, limit=20: 5*2=10 < 20 → no update, returns same limit
    public void testProbeThresholdOneDisablesGuard() {
            .probeInflightThreshold(0.0)
        assertTrue("limit should drop after hitting hysteresis threshold", limit.getLimit() <= before);
            .decreaseHysteresis(3)
        limit.onSample(0, baseRtt, 5, false);
    // -------------------------------------------------------------------------
            if (factor1.getLimit() != factor1_5.getLimit()) {
            .initialLimit(20)
    public void testProbeSkipsBaselineWhenInflightAboveThreshold() {
            .maxConcurrency(200)
        }
    // -------------------------------------------------------------------------
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).build();
            .maxConcurrency(200)
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().build();
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        long highRtt = TimeUnit.MILLISECONDS.toNanos(50);
        // limit=20, inflight=5: factor=3 → 5*4=20 >= 20 → drift allowed
        // so updateEstimatedLimit is actually called on each sample.
    public void testDecreaseHysteresisDelaysLimitDrop() {
    // toString
    // -------------------------------------------------------------------------
        expectThrows(IllegalArgumentException.class, () -> OpenSearchVegasLimit.newBuilder().probeInflightThreshold(1.1));
        // inflight=5 <= 20*0.5=10 → probes should accept the new RTT
    public void testRttNoLoadConvertsUnits() {
        limit.onSample(0, baseRtt, 10, false);  // counter → 3, no fire
            long rtt = TimeUnit.MILLISECONDS.toNanos(10 + i % 5);
public class OpenSearchVegasLimitTests extends OpenSearchTestCase {
            limit.onSample(0, fastRtt, 30, false);
        long inflatedRtt = TimeUnit.MILLISECONDS.toNanos(50);
        for (int i = 0; i < 200; i++) {
    }
        limit.onSample(0, baseRtt, 5, false);
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()
        // With upDriftFactor=3, the drift check is: inflight * 4 < limit
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
        // increaseHysteresis=1000 freezes the limit during setup so it stays at initialLimit.
        long newRtt = TimeUnit.MILLISECONDS.toNanos(15);
        // The wider drift window from factor=1.5 should cause divergent behavior.
 * The OpenSearch Contributors require contributions made to
    public void testIncreaseHysteresisDelaysLimitGrowth() {
        assertEquals(baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
    }
    public void testToStringContainsLimit() {
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()
            .probeMultiplier(1)
    }
}
        assertEquals(baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
    public void testRttNoLoadInitiallyZero() {
        limit.onSample(System.nanoTime() - rtt, rtt, 5, false);
            limit.onSample(0, inflatedRtt, 1, false);
        // didDrop=true is a hard signal and must bypass hysteresis regardless of the counter.
        // the Nth fires. Sample 1 establishes baseline (counter→1), so 3 more are needed.
        OpenSearchVegasLimit defaultFactor = OpenSearchVegasLimit.newBuilder().initialLimit(20).build();
        // A lower RTT should always update baseline regardless of threshold or inflight.
            .probeInflightThreshold(0.5)
        long fastRtt = TimeUnit.MILLISECONDS.toNanos(5);
                break;
            }
        limit.onSample(0, baseRtt, 10, false);  // counter → 4, fires
    public void testDefaultUpDriftFactorIsOne() {
        assertEquals("baseline must not be poisoned by high-inflight probes", baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
        // inflight=1 > 20*0.0=0 → probes should never accept
        assertTrue("drop should not increase limit: before=" + before + " after=" + after, after <= before);
    public void testFractionalUpDriftFactorNotTruncated() {
        assertEquals("threshold=0.0 must never accept probe baseline", baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
    public void testProbeThresholdZeroNeverAcceptsProbe() {
        limit.onSample(0, slowRtt, 30, false);  // decreaseConsecutive → 3, fires
        OpenSearchVegasLimit factor1 = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(200).upDriftFactor(1.0).build();
        assertNotEquals("baseline should update when inflight is below threshold", baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
        assertEquals(50L, limit.getRttNoLoad(TimeUnit.MILLISECONDS));
    public void testBuilderRespectsBuildLimits() {
        // than upDriftFactor=1.0 — i.e. the fractional part is not truncated.
        OpenSearchVegasLimit explicitOne = OpenSearchVegasLimit.newBuilder().initialLimit(20).upDriftFactor(1.0).build();
            .probeInflightThreshold(1.0)
        // is at the mid-range (which factor=1 would prevent)
            .build();
        // But with factor=3 and inflight close to limit, it CAN drift:
    public void testZeroRttThrows() {
        int before = limit.getLimit();
        long highRtt = TimeUnit.MILLISECONDS.toNanos(50);
        assertTrue(str.contains("42"));
            factor1.onSample(0, rtt, inflight, false);
    // -------------------------------------------------------------------------
 */
