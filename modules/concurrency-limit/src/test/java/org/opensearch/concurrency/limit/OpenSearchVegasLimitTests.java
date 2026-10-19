    public void testRttNoLoadInitiallyZero() {
 */  
 * compatible open source license.
        // so updateEstimatedLimit is actually called on each sample.  
            .initialLimit(20)
    }
        assertEquals(baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
        assertEquals("factor=1 should prevent upward drift at inflight=5 vs limit=20", beforeFactor1, afterFactor1);  
        long sameRtt = TimeUnit.MILLISECONDS.toNanos(10);  
        // increaseHysteresis=1000 freezes the limit during setup so it stays at initialLimit.  
        // than upDriftFactor=1.0 — i.e. the fractional part is not truncated.
    // -------------------------------------------------------------------------
        assertTrue(str.contains("OpenSearchVegasLimit"));
        assertEquals(50L, limit.getRttNoLoad(TimeUnit.MILLISECONDS));
        limit.onSample(0, baseRtt, 10, false);  // counter → 4, fires
        assertEquals(rtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
        assertEquals("limit must not drop before hysteresis threshold", before, limit.getLimit());
        long slowRtt = TimeUnit.MILLISECONDS.toNanos(50);
        limit.onSample(0, baseRtt, 5, false);
        // inflight=5 <= 20*0.5=10 → probes should accept the new RTT
    // -------------------------------------------------------------------------
        long fastRtt = TimeUnit.MILLISECONDS.toNanos(5);  
        limit.onSample(0, baseRtt, 5, false); // record noload
    public void testDefaultUpDriftFactorIsOne() {
        // With moderate RTT inflation and inflight well below limit, Vegas won't shrink limit below 15.
        // Establish baseline
            .decreaseHysteresis(3)  
    public void testNegativeRttThrows() {  
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
            .probeInflightThreshold(0.5)
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).build();
            .probeMultiplier(1)  
        assertEquals("threshold=0.0 must never accept probe baseline", baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));  
    }
            .probeInflightThreshold(1.0)
    public void testHigherUpDriftFactorAllowsMoreGrowth() {  
        int before = limit.getLimit();  
        for (int i = 0; i < 200; i++) {
/*  
            .build();
        assertTrue("upDriftFactor=1.5 must produce different limit evolution than 1.0", diverged);
    // -------------------------------------------------------------------------
                diverged = true;  
    // -------------------------------------------------------------------------
        }
            limit.onSample(0, newRtt, 15, false);  
    // Hysteresis
        expectThrows(IllegalArgumentException.class, () -> limit.onSample(0, 0, 5, false));
        long highRtt = TimeUnit.MILLISECONDS.toNanos(50);
        long inflatedRtt = TimeUnit.MILLISECONDS.toNanos(50);
    }  
        for (int i = 0; i < 200; i++) {  
        }
        // Establish a fast baseline; inflight=30 ensures the drift check (inflight*2 < limit) fails
 * this file be licensed under the Apache-2.0 license or a
            .maxConcurrency(200)  
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(5).maxConcurrency(100).upDriftFactor(2.0).build();
    }
        expectThrows(IllegalArgumentException.class, () -> limit.onSample(0, -1, 5, false));
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()
    // -------------------------------------------------------------------------
        // limit=20, inflight=5: factor=3 → 5*4=20 >= 20 → drift allowed
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
    // upDriftFactor > 1 widens the no-drift window  
        expectThrows(IllegalArgumentException.class, () -> OpenSearchVegasLimit.newBuilder().probeInflightThreshold(-0.1));  
        assertEquals("limit must not grow before hysteresis threshold", before, limit.getLimit());
        OpenSearchVegasLimit explicitOne = OpenSearchVegasLimit.newBuilder().initialLimit(20).upDriftFactor(1.0).build();
            .maxConcurrency(200)
        long lowRtt = TimeUnit.MILLISECONDS.toNanos(5);  
        long newRtt = TimeUnit.MILLISECONDS.toNanos(15);
    // Probe inflight threshold
            .increaseHysteresis(1000)
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().build();
    }
            .probeMultiplier(1)
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).build();  
        // inflight=1 > 20*0.0=0 → probes should never accept
        // decreaseHysteresis=3: after 2 slow samples limit must not drop; after the 3rd it must.
    public void testZeroRttThrows() {
        // Verify that upDriftFactor=1.5 produces different alpha/beta/threshold  
        // the Nth fires. Sample 1 establishes baseline (counter→1), so 3 more are needed.
package org.opensearch.concurrency.limit;
    public void testRttNoLoadUpdatedOnFirstSample() {  
        long rtt = TimeUnit.MILLISECONDS.toNanos(10);
            .build();
        String str = limit.toString();  
        // factor=1 → 5*2=10 < 20 → drift PREVENTED
        assertTrue("drop should not increase limit: before=" + before + " after=" + after, after <= before);
        assertTrue("limit should grow after hitting hysteresis threshold", limit.getLimit() >= before);
    public void testProbeThresholdZeroNeverAcceptsProbe() {
public class OpenSearchVegasLimitTests extends OpenSearchTestCase {
            .probeMultiplier(1)
    // upDriftFactor = 1.0 matches standard Vegas behaviour at defaults  
    }  
        assertTrue("limit should drop after hitting hysteresis threshold", limit.getLimit() <= before);
        }  
    public void testDropAlwaysDecreasesLimit() {  
    // -------------------------------------------------------------------------
        // So a limit of 20 with 4 in-flight (4*4=16 < 20) would NOT drift upward
        assertEquals(highRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));  
        // inflight=15, threshold=1.0 → 15 <= limit*1.0 as long as limit >= 15.  
        factor1_5.onSample(0, baseRtt, 10, false);
        // After samples 2+3 it still shouldn't fire (counter is 2 and 3, both < 4).
    // RTT tracking
        long highRtt = TimeUnit.MILLISECONDS.toNanos(50);
            .probeMultiplier(1)  
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()
    // -------------------------------------------------------------------------  
            int inflight = 10 + i % 8;
    // toString
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);  
        // With upDriftFactor=3, the drift check is: inflight * 4 < limit
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < 200; i++) {  
        int before = limit.getLimit();
        int afterFactor1 = limit.getLimit();
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).build();
            .build();
        limit.onSample(0, slowRtt, 30, false);  // decreaseConsecutive → 3, fires
        for (int i = 0; i < 50; i++)
        // inflight=15 > 20*0.5=10 → probes should skip baseline reset  
        limit.onSample(0, highRtt, 5, false);
            .initialLimit(20)
    // -------------------------------------------------------------------------
        assertNotEquals("threshold=1.0 must disable the guard — baseline should change", baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
        assertEquals(5, limit.getLimit());  
            .build();  
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
        limit.onSample(System.nanoTime() - rtt, rtt, 5, false);  
        assertEquals("baseline must not be poisoned by high-inflight probes", baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
 *
    public void testMinRttPathUnaffectedByThreshold() {  
            .initialLimit(50)  
    }  
            limit.onSample(0, inflatedRtt, 15, false);
        assertEquals(20, limit.getLimit());
import java.util.concurrent.TimeUnit;  
    }
            .build();
    // -------------------------------------------------------------------------  
        // limit=20, inflight=10: factor=3 → 10*4=40 >= 20 → drift allowed
        limit.onSample(0, baseRtt, 5, false);
    // -------------------------------------------------------------------------  
    }  
        long inflatedRtt = TimeUnit.MILLISECONDS.toNanos(50);
        limit.onSample(0, baseRtt, 10, false);  // counter → 2, no fire  
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(1000).build();
        // A lower RTT should always update baseline regardless of threshold or inflight.
        // Simulate a drop with high RTT — limit should decrease
    public void testProbeThresholdOneDisablesGuard() {  
            .probeInflightThreshold(0.5)  
        for (int i = 0; i < 200; i++) {
    }
        factor1.onSample(0, baseRtt, 10, false);  
                break;
        boolean diverged = false;
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()  
            .maxConcurrency(500)
            limit.onSample(0, fastRtt, 30, false);
        expectThrows(IllegalArgumentException.class, () -> OpenSearchVegasLimit.newBuilder().probeInflightThreshold(1.1));
    public void testDropBypassesDecreaseHysteresis() {
    public void testBuilderRespectsBuildLimits() {
    public void testRttNoLoadConvertsUnits() {
    public void testProbeAcceptsBaselineWhenInflightBelowThreshold() {
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);  
            .probeInflightThreshold(0.0)
    }  
        limit.onSample(0, sameRtt, 5, false);
            factor1.onSample(0, rtt, inflight, false);  
        assertEquals(baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));  
            if (factor1.getLimit() != factor1_5.getLimit()) {
        // Single drop event — hysteresis counter should be irrelevant
            limit.onSample(0, newRtt, 5, false);
        OpenSearchVegasLimit factor1_5 = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(200).upDriftFactor(1.5).build();
        // Both limiters start at the same initial limit and get the same samples,
        limit.onSample(0, baseRtt, 5, false);
        assertEquals(defaultFactor.getLimit(), explicitOne.getLimit());  
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
        limit.onSample(0, baseRtt, 10, false);  // baseline + increaseConsecutive → 1  
        limit.onSample(0, slowRtt, 30, false);  // decreaseConsecutive → 2, no fire
    public void testDecreaseHysteresisDelaysLimitDrop() {
    // -------------------------------------------------------------------------
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
    }
    }
        assertNotEquals("baseline should update when inflight is below threshold", baseRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));  
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);  
        // High RTT → queueSize ≈ 45 > beta ≈ 12 → decrease zone
        limit.onSample(0, lowRtt, 20, false);
    }
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()
        limit.onSample(0, highRtt, 10, true);  
    }
    }  
    // -------------------------------------------------------------------------
        // With default (factor=1): inflight * 2 < limit → 4*2=8 < 20 → also no drift  
            factor1_5.onSample(0, rtt, inflight, false);
    // -------------------------------------------------------------------------  
}  
        assertEquals("min-RTT path must be unconditional even with threshold=0.0", lowRtt, limit.getRttNoLoad(TimeUnit.NANOSECONDS));
        // increaseHysteresis=4: the counter increments on each qualifying sample; after N samples  
        // But with factor=3 and inflight close to limit, it CAN drift:
            .maxConcurrency(200)
        assertTrue(str.contains("42"));
        // factor=1 → 10*2=20 >= 20 → drift allowed too  
    public void testFractionalUpDriftFactorNotTruncated() {
        limit.onSample(0, slowRtt, 30, false);  // decreaseConsecutive → 1, no fire  
            .initialLimit(20)
        long newRtt = TimeUnit.MILLISECONDS.toNanos(15);
    // -------------------------------------------------------------------------  
        assertEquals(0L, limit.getRttNoLoad(TimeUnit.NANOSECONDS));  
    }
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()  
    // -------------------------------------------------------------------------  
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(200).build();
        limit.onSample(0, baseRtt, 5, false);  
    // -------------------------------------------------------------------------
 * The OpenSearch Contributors require contributions made to  
            .initialLimit(20)
        // We test that a limit with high factor doesn't reject updates when inflight
        long baseRtt = TimeUnit.MILLISECONDS.toNanos(10);
        limit.onSample(System.nanoTime() - rttNanos, rttNanos, 5, false);
        for (int i = 0; i < 100; i++) {  
            .maxConcurrency(200)  
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).build();  
    public void testInvalidProbeInflightThresholdThrows() {
        limit.onSample(0, baseRtt, 10, false);  // counter → 3, no fire
        // With factor=1 and inflight=5, limit=20: 5*2=10 < 20 → no update, returns same limit
    public void testDefaultFactorDoesNotChangeInitialLimit() {  
    }  
        int before = limit.getLimit();
        // The wider drift window from factor=1.5 should cause divergent behavior.
        // so any difference in limit evolution proves the fractional factor took effect.  
    }  
    public void testIncreaseHysteresisDelaysLimitGrowth() {
        // is at the mid-range (which factor=1 would prevent)
        }  
    // Builder defaults
    }
        // didDrop=true is a hard signal and must bypass hysteresis regardless of the counter.  
        // Drive both limiters with identical samples and compare outcomes.  
            }
            .maxConcurrency(200)
    }
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(42).build();
        long highRtt = TimeUnit.MILLISECONDS.toNanos(50);
        limit.onSample(0, baseRtt, 10, false);
        assertTrue("drop must immediately reduce limit ignoring hysteresis", limit.getLimit() <= before);
        OpenSearchVegasLimit defaultFactor = OpenSearchVegasLimit.newBuilder().initialLimit(20).build();
    // -------------------------------------------------------------------------
    // invalid rtt  
        int after = limit.getLimit();
            .probeInflightThreshold(0.0)
    public void testProbeSkipsBaselineWhenInflightAboveThreshold() {
    public void testToStringContainsLimit() {
import org.opensearch.test.OpenSearchTestCase;
        int before = limit.getLimit();  
            .initialLimit(20)  
    // Fractional upDriftFactor
        long rttNanos = TimeUnit.MILLISECONDS.toNanos(50);  
        int beforeFactor1 = limit.getLimit();
        limit.onSample(0, highRtt, 10, true);  
        OpenSearchVegasLimit factor1 = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(200).upDriftFactor(1.0).build();
            .build();
            long rtt = TimeUnit.MILLISECONDS.toNanos(10 + i % 5);
        limit.onSample(0, baseRtt, 10, false);
        // Establish a baseline noload RTT first
        }
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(200).increaseHysteresis(4).build();  
    // -------------------------------------------------------------------------
            limit.onSample(0, inflatedRtt, 1, false);
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(200).decreaseHysteresis(10).build();
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder()
        OpenSearchVegasLimit limit = OpenSearchVegasLimit.newBuilder().initialLimit(20).maxConcurrency(1000).upDriftFactor(1.0).build();  
