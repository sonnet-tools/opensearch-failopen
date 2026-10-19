    }
import java.util.List;
     * maps to {@code NULLS FIRST}, so a null outranks every real value.
            assertEquals(descending ? 70L : 40L, gate.bottom());
        final int perThread = 500;
            TopNGate gate = new TopNGate(4, descending);
        assertFalse("min == bar must be kept", gate.canEliminate(bounds(15, 900)));
    public void testCreateCarriesTheSpecsLimitAndDirection() {
        TopNGate gate = TopNGate.create(new SortSpec("@timestamp", true, 30));
            worker.start();
    public void testCapacityOneTracksTheSingleBest() {
            worker.join();
            for (long key : keys) {
    public void testExtremeValuesDoNotOverflowComparisons() {
        assertEquals(90L, gate.bottom());
                    );
                    gate.offer(base + i);
import org.opensearch.test.OpenSearchTestCase;
     */
    public void testCreateRefusesUngateableShapes() {
            }
        offerAll(weak, 100, 60, 55);
        assertFalse("gate must not be armed on a partial heap", partial.isArmed());
        List<Long> keys = new ArrayList<>();
    }
    // ---- create() ----
        assertFalse("29 of 30 keys → not armed", gate.isArmed());
    /** Extremes are compared, never subtracted, so the full long range is usable. */
 */
    }
            Collections.shuffle(keys, random());
 *
    }
    }
        assertTrue(gate.canEliminate(bounds(Long.MIN_VALUE, -1L)));
    }
import org.opensearch.analytics.spi.ShardSortBounds;
        offerAll(strong, 100, 98, 95);
        expectThrows(IllegalArgumentException.class, () -> new TopNGate(-1, true));
        TopNGate gate = new TopNGate(3, true);
    }
        ascending.offer(10);
            gate.canEliminate(new ShardSortBounds(Long.MIN_VALUE, Long.MIN_VALUE + 1, true, KIND))
                assertEquals("arrival order must not change any verdict", expected, verdicts);
import java.util.Collections;
        assertNull(TopNGate.create(new SortSpec("@timestamp", true, TopNGate.MAX_CAPACITY + 1)));
    /** No spec, or a limit past the cap whose heap realistic row counts can't fill: build no gate. */
            }
            } else {
        TopNGate gate = new TopNGate(3, true);
        for (Thread worker : workers) {
    /** Keys worse than the bar are dropped, not admitted — the bar must not degrade. */
    // ---- monotonicity ----
    public void testUnjudgeableAndNullBearingShardsAreKept() {
        for (int t = 0; t < threads; t++) {
    public void testConstructorRejectsNonPositiveCapacity() {
    public void testEliminationSetIsIndependentOfArrivalOrder() {
    // ---- concurrency ----
        }
    /**
        offerAll(gate, 10, 12, 15);
                if (gate.isArmed()) {
    public void testConcurrentOfferAndTestKeepsHeapConsistent() throws Exception {
        List<ShardSortBounds> probes = List.of(bounds(0, 60), bounds(0, 90), bounds(0, 120), bounds(100, 200), bounds(0, 91));
    // ---- fail-open ----
        TopNGate ascending = TopNGate.create(new SortSpec("size", false, 2));
        assertTrue("the 30th key arms the gate", gate.isArmed());
                        "bar must not regress (descending=" + descending + "): " + bottom + " after " + previous,
    }
 * SPDX-License-Identifier: Apache-2.0
            gate.offer(key);
        TopNGate gate = new TopNGate(2, true);
                for (int i = 0; i < perThread; i++) {
        TopNGate weak = new TopNGate(3, true);
        }
    /**
        expectThrows(IllegalStateException.class, gate::bottom);
            for (long key : new long[] { 50, 90, 10, 70, 30, 100, 20, 80, 60, 40 }) {
        assertEquals(42L, gate.bottom());
            "hasNulls vetoes elimination outright",
        TopNGate gate = new TopNGate(3, false);
            }
/*
    public void testEliminatesOnlyWhenTheBarIsStrongEnough() {
    /** The comparison is strict: a shard whose max ties the bar must be kept, one unit past it is dropped. */
        List<Boolean> expected = null;
    }
        assertTrue("min 20 is strictly worse than the bar 15", gate.canEliminate(bounds(20, 30)));
        assertNull(TopNGate.create(null));
        assertEquals("ASC bar is the largest of the best three", 15L, gate.bottom());
        gate.offer(1L);
        assertFalse("min 14 beats the bar", gate.canEliminate(bounds(14, 30)));
        final int threads = 4;
        for (long key : keys) {
 * this file be licensed under the Apache-2.0 license or a
                    long bottom = gate.bottom();
        assertFalse(gate.canEliminate(bounds(Long.MIN_VALUE, 0L)));
        offerAll(gate, Long.MAX_VALUE, 0L);
        offerAll(gate, 100, 98, 95);
        offerAll(gate, 1, 2, 3, -50);
 * the gate's failure mode is dropping rows that belonged in the answer.
        assertTrue("Case A: max 80 is strictly below the bar 95", strong.canEliminate(bounds(0, 80)));
        assertEquals(95L, strong.bottom());
            }
        assertEquals("concurrent offers must not corrupt the heap", expectedBottom, gate.bottom());
     */
        return new ShardSortBounds(min, max, false, KIND);
                    gate.canEliminate(bounds(0, base + i));
 */
                    assertTrue(
        TopNGate gate = new TopNGate(10, true);
    // ---- the bar, and who clears it ----
 * The OpenSearch Contributors require contributions made to
            long previous = descending ? Long.MIN_VALUE : Long.MAX_VALUE;
                gate.offer(key);
            assertEquals("top-5 of 3..120 by threes → bar is 108", 108L, gate.bottom());
    }
     * exactly where a single-threaded run would.
        offerAll(gate, 5, 90, 40);
        }
        }
    // ---- helpers ----
        assertFalse("max == bar must be kept", gate.canEliminate(bounds(0, 95)));
        }
    }
                    previous = bottom;
    public void testBottomBeforeArmedThrows() {
}
            // Keys are 10..100 by tens: best four are 100/90/80/70 descending, 10/20/30/40 ascending.
                        descending ? bottom >= previous : bottom <= previous
        TopNGate strong = new TopNGate(3, true);
        TopNGate gate = new TopNGate(3, true);
 * compatible open source license.
    /** The bar only ever improves in either direction, so a verdict can't flip as more keys arrive. */
        assertTrue("ASC direction must survive create()", ascending.canEliminate(bounds(21, 99)));
        offerAll(gate, 100, 98, 95);
    /** The bar is the K-th best key, so the same probe is eliminable against a strong heap but not a weak one. */
            keys.add(i * 3);
    public void testBoundaryIsStrictDescending() {
public class TopNGateTests extends OpenSearchTestCase {
        TopNGate gate = new TopNGate(3, true);
            if (expected == null) {
        for (int i = 0; i < 29; i++) {
    // ---- heap mechanics ----
    }
    }
    public void testPartialHeapNeverEliminates() {
        long expectedBottom = (long) threads * perThread - 10;
        TopNGate gate = new TopNGate(1, true);
        assertNotNull(gate);
            gate.offer(i);
        assertEquals("losers must not enter the heap", 95L, gate.bottom());
            TopNGate gate = new TopNGate(5, true);
                gate.offer(key);
        );
        ShardSortBounds hopeless = bounds(Long.MIN_VALUE, Long.MIN_VALUE + 1);
                }
                verdicts.add(gate.canEliminate(probe));
        }
        assertTrue(gate.isArmed());
        assertNotNull(TopNGate.create(new SortSpec("@timestamp", true, TopNGate.MAX_CAPACITY)));
        assertFalse("Case B: max 80 beats the bar 55 — the shard owns rows in the answer", weak.canEliminate(bounds(0, 80)));
    /** ASC reads the other end of the range — min, not max — and lower wins. Strictness is the same. */
    }
            });
        offerAll(gate, 100, 98, 95);
 * Unit coverage for {@link TopNGate}. Every case is a wrong-results guard, not a performance one —
/**
                }
        assertTrue(gate.canEliminate(bounds(0, 89)));
        assertFalse(partial.canEliminate(hopeless));
        for (long i = 1; i <= 40; i++) {
import java.util.ArrayList;
        List<Thread> workers = new ArrayList<>(threads);
        // Keys are 0..(threads*perThread - 1); the best ten are the top ten of that range.
     * Response threads offer keys while dispatch threads test, so concurrent access must leave the bar
        offerAll(partial, 100, 98);
    /** Until K keys exist there is no bar, so nothing can be shown to lose — however hopeless it looks. */
            for (ShardSortBounds probe : probes) {
                    // Interleave reads to exercise the shared critical section.
     * Two shards that can never be eliminated: one with no bounds, and one reporting nulls — {@code DESC}
    public void testLosingKeysDoNotDisplaceTheTopK() {
        TopNGate gate = new TopNGate(2, true);
            workers.add(worker);
        assertEquals(55L, weak.bottom());
    public void testBottomIsMonotoneAsKeysArrive() {
    private static ShardSortBounds bounds(long min, long max) {
package org.opensearch.analytics.exec.canmatch;
        ascending.offer(20);
        TopNGate partial = new TopNGate(3, true);
            final int base = t * perThread;
    public void testAscendingUsesMinAndIsEquallyStrict() {
    private static void offerAll(TopNGate gate, long... keys) {
        assertFalse(
        gate.offer(29);
        assertFalse("no bounds, no verdict", gate.canEliminate(null));
        offerAll(gate, 42, 42, 42);
        }
    }
            Thread worker = new Thread(() -> {
    private static final byte KIND = ShardSortBounds.VALUE_KIND_INT64;
        assertTrue("one unit past the bar is a real loss", gate.canEliminate(bounds(0, 94)));
                expected = verdicts;
        for (int trial = 0; trial < 25; trial++) {
    }
            List<Boolean> verdicts = new ArrayList<>(probes.size());
    /** Duplicates fill capacity like any other key — they don't collapse. */
    }
    /** Arrival order is network timing, so it must not affect any verdict: same keys shuffled, same verdicts. */
    }
        assertEquals(0L, gate.bottom());
    public void testDuplicateKeysConsumeCapacity() {
        assertFalse("an empty heap has no bar", new TopNGate(1, true).canEliminate(hopeless));
        for (boolean descending : new boolean[] { true, false }) {
    /** The spec's limit becomes the capacity and its direction carries over. */
        expectThrows(IllegalArgumentException.class, () -> new TopNGate(0, true));
