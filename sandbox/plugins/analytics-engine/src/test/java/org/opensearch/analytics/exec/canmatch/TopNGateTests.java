            }  
            worker.join();
    /** The bar only ever improves in either direction, so a verdict can't flip as more keys arrive. */
        final int perThread = 500;  
        assertFalse("29 of 30 keys → not armed", gate.isArmed());
            if (expected == null) {
        assertFalse("min 14 beats the bar", gate.canEliminate(bounds(14, 30)));
    /** Keys worse than the bar are dropped, not admitted — the bar must not degrade. */
            final int base = t * perThread;
    // ---- create() ----
        TopNGate gate = new TopNGate(3, true);  
    public void testBottomIsMonotoneAsKeysArrive() {
    public void testEliminationSetIsIndependentOfArrivalOrder() {
    private static final byte KIND = ShardSortBounds.VALUE_KIND_INT64;
                    long bottom = gate.bottom();  
    public void testPartialHeapNeverEliminates() {  
 * SPDX-License-Identifier: Apache-2.0
        final int threads = 4;
        }
    public void testDuplicateKeysConsumeCapacity() {  
    public void testAscendingUsesMinAndIsEquallyStrict() {
    }
        offerAll(gate, 100, 98, 95);
                    gate.offer(base + i);
    }  
            gate.canEliminate(new ShardSortBounds(Long.MIN_VALUE, Long.MIN_VALUE + 1, true, KIND))
    public void testConcurrentOfferAndTestKeepsHeapConsistent() throws Exception {
        TopNGate ascending = TopNGate.create(new SortSpec("size", false, 2));  
    }
     * Two shards that can never be eliminated: one with no bounds, and one reporting nulls — {@code DESC}  
            for (ShardSortBounds probe : probes) {
        TopNGate gate = new TopNGate(3, true);
        assertEquals("ASC bar is the largest of the best three", 15L, gate.bottom());  
    }  
        for (int t = 0; t < threads; t++) {  
        TopNGate gate = new TopNGate(3, true);
    }  
        for (long i = 1; i <= 40; i++) {
            TopNGate gate = new TopNGate(4, descending);
        assertFalse(gate.canEliminate(bounds(Long.MIN_VALUE, 0L)));
        assertTrue("the 30th key arms the gate", gate.isArmed());
        gate.offer(29);  
            } else {  
    public void testExtremeValuesDoNotOverflowComparisons() {
        offerAll(gate, Long.MAX_VALUE, 0L);
        long expectedBottom = (long) threads * perThread - 10;
    }
            }
        assertTrue("Case A: max 80 is strictly below the bar 95", strong.canEliminate(bounds(0, 80)));
import java.util.List;  
                assertEquals("arrival order must not change any verdict", expected, verdicts);
    // ---- concurrency ----
        for (boolean descending : new boolean[] { true, false }) {  
                    // Interleave reads to exercise the shared critical section.
        // Keys are 0..(threads*perThread - 1); the best ten are the top ten of that range.
        TopNGate gate = new TopNGate(2, true);  
        assertFalse("gate must not be armed on a partial heap", partial.isArmed());
        assertEquals("concurrent offers must not corrupt the heap", expectedBottom, gate.bottom());  
                }  
        TopNGate gate = new TopNGate(10, true);
 * compatible open source license.
        offerAll(gate, 100, 98, 95);
    public void testEliminatesOnlyWhenTheBarIsStrongEnough() {
        }
            for (long key : new long[] { 50, 90, 10, 70, 30, 100, 20, 80, 60, 40 }) {  
    }  
    public void testBottomBeforeArmedThrows() {
                gate.offer(key);
     * Response threads offer keys while dispatch threads test, so concurrent access must leave the bar
import org.opensearch.analytics.spi.ShardSortBounds;
        assertFalse(partial.canEliminate(hopeless));
        offerAll(gate, 5, 90, 40);
        assertTrue("one unit past the bar is a real loss", gate.canEliminate(bounds(0, 94)));  
    }  
            // Keys are 10..100 by tens: best four are 100/90/80/70 descending, 10/20/30/40 ascending.
            gate.offer(key);
 * the gate's failure mode is dropping rows that belonged in the answer.
    }  
    // ---- fail-open ----  
 * The OpenSearch Contributors require contributions made to  
                }
    /** The spec's limit becomes the capacity and its direction carries over. */
                for (int i = 0; i < perThread; i++) {  
    /** The comparison is strict: a shard whose max ties the bar must be kept, one unit past it is dropped. */
            "hasNulls vetoes elimination outright",  
        assertEquals("losers must not enter the heap", 95L, gate.bottom());
import org.opensearch.test.OpenSearchTestCase;
        return new ShardSortBounds(min, max, false, KIND);  
            keys.add(i * 3);
            Collections.shuffle(keys, random());
        assertFalse("max == bar must be kept", gate.canEliminate(bounds(0, 95)));
                    gate.canEliminate(bounds(0, base + i));  
/*  
        assertFalse("Case B: max 80 beats the bar 55 — the shard owns rows in the answer", weak.canEliminate(bounds(0, 80)));
    /** Arrival order is network timing, so it must not affect any verdict: same keys shuffled, same verdicts. */
    }
        for (int i = 0; i < 29; i++) {
    }
        assertFalse(
                expected = verdicts;
        offerAll(strong, 100, 98, 95);  
}
            }  
                if (gate.isArmed()) {
        for (int trial = 0; trial < 25; trial++) {
        assertFalse("min == bar must be kept", gate.canEliminate(bounds(15, 900)));  
/**
        TopNGate weak = new TopNGate(3, true);
        }
        assertTrue(gate.canEliminate(bounds(Long.MIN_VALUE, -1L)));
            List<Boolean> verdicts = new ArrayList<>(probes.size());  
    // ---- helpers ----  
        expectThrows(IllegalArgumentException.class, () -> new TopNGate(0, true));
 */  
        TopNGate gate = new TopNGate(3, true);
        offerAll(partial, 100, 98);  
    public void testBoundaryIsStrictDescending() {
 *
     */
        offerAll(gate, 100, 98, 95);
        assertTrue(gate.isArmed());
                gate.offer(key);
    public void testUnjudgeableAndNullBearingShardsAreKept() {  
        for (Thread worker : workers) {  
        offerAll(gate, 10, 12, 15);
        List<Thread> workers = new ArrayList<>(threads);
        TopNGate gate = new TopNGate(3, false);  
        assertEquals(42L, gate.bottom());
        assertTrue(gate.canEliminate(bounds(0, 89)));
            long previous = descending ? Long.MIN_VALUE : Long.MAX_VALUE;
        assertEquals(0L, gate.bottom());  
        expectThrows(IllegalStateException.class, gate::bottom);  
            assertEquals("top-5 of 3..120 by threes → bar is 108", 108L, gate.bottom());
        );
            worker.start();
            });
    }
        offerAll(gate, 1, 2, 3, -50);  
     */  
    /**  
                    assertTrue(
    }
        assertEquals(55L, weak.bottom());  
                        "bar must not regress (descending=" + descending + "): " + bottom + " after " + previous,
        gate.offer(1L);
        TopNGate partial = new TopNGate(3, true);
        assertNull(TopNGate.create(new SortSpec("@timestamp", true, TopNGate.MAX_CAPACITY + 1)));  
        List<Long> keys = new ArrayList<>();  
        List<Boolean> expected = null;  
            Thread worker = new Thread(() -> {
    /** No spec, or a limit past the cap whose heap realistic row counts can't fill: build no gate. */  
import java.util.ArrayList;
        assertEquals(90L, gate.bottom());  
 * this file be licensed under the Apache-2.0 license or a
        offerAll(weak, 100, 60, 55);
        List<ShardSortBounds> probes = List.of(bounds(0, 60), bounds(0, 90), bounds(0, 120), bounds(100, 200), bounds(0, 91));
    public void testCreateCarriesTheSpecsLimitAndDirection() {
    // ---- monotonicity ----
        assertEquals(95L, strong.bottom());
        TopNGate gate = TopNGate.create(new SortSpec("@timestamp", true, 30));  
    private static void offerAll(TopNGate gate, long... keys) {
     * exactly where a single-threaded run would.
        offerAll(gate, 42, 42, 42);
        TopNGate gate = new TopNGate(2, true);  
    /** Duplicates fill capacity like any other key — they don't collapse. */
        assertFalse("an empty heap has no bar", new TopNGate(1, true).canEliminate(hopeless));  
            assertEquals(descending ? 70L : 40L, gate.bottom());  
    }
    }
    public void testCreateRefusesUngateableShapes() {
            workers.add(worker);  
 */
        ShardSortBounds hopeless = bounds(Long.MIN_VALUE, Long.MIN_VALUE + 1);
        assertNotNull(gate);
        TopNGate strong = new TopNGate(3, true);
import java.util.Collections;
    /** ASC reads the other end of the range — min, not max — and lower wins. Strictness is the same. */
        assertNotNull(TopNGate.create(new SortSpec("@timestamp", true, TopNGate.MAX_CAPACITY)));
    public void testCapacityOneTracksTheSingleBest() {
            gate.offer(i);  
        assertNull(TopNGate.create(null));
        assertFalse("no bounds, no verdict", gate.canEliminate(null));
                    );
    private static ShardSortBounds bounds(long min, long max) {
        }
    /**
        }
public class TopNGateTests extends OpenSearchTestCase {  
        ascending.offer(20);
        assertTrue("min 20 is strictly worse than the bar 15", gate.canEliminate(bounds(20, 30)));
        ascending.offer(10);
            }
                        descending ? bottom >= previous : bottom <= previous  
            TopNGate gate = new TopNGate(5, true);  
    // ---- the bar, and who clears it ----
package org.opensearch.analytics.exec.canmatch;
     * maps to {@code NULLS FIRST}, so a null outranks every real value.
    }
            for (long key : keys) {
    /** Extremes are compared, never subtracted, so the full long range is usable. */
        }  
    public void testLosingKeysDoNotDisplaceTheTopK() {  
        assertTrue("ASC direction must survive create()", ascending.canEliminate(bounds(21, 99)));  
    }
    // ---- heap mechanics ----  
        for (long key : keys) {  
    public void testConstructorRejectsNonPositiveCapacity() {  
                verdicts.add(gate.canEliminate(probe));
    /** Until K keys exist there is no bar, so nothing can be shown to lose — however hopeless it looks. */
 * Unit coverage for {@link TopNGate}. Every case is a wrong-results guard, not a performance one —  
        TopNGate gate = new TopNGate(1, true);  
    /** The bar is the K-th best key, so the same probe is eliminable against a strong heap but not a weak one. */  
                    previous = bottom;
        expectThrows(IllegalArgumentException.class, () -> new TopNGate(-1, true));
    }  
        }  
