            () -> mgr.tryAdmit("q1", 0, 0, "right", new byte[1])
     */
        // clearForQuery must release only the REMAINING 200 (already net of the removeBuffer above).
     */  
        mgr.setBudgets(Long.MAX_VALUE, Long.MAX_VALUE);
            threads[t].setUncaughtExceptionHandler(ueh);
        Path spillDir = createTempDir();
        assertTrue("resident must stay bounded by the budget", mgr.getTotalBytes() <= 100);  
     * BLOCKER (codex review: tombstoned-admit-budget-leak): once a query is tombstoned by
    }
        assertTrue("worker threads threw: " + failures, failures.isEmpty());
     * Codex review P1: buffers must be keyed by partitionIndex too, otherwise two partitions of the
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertEquals(2, drained.size());  
        ShuffleBufferExceededException ex = expectThrows(  
        mgr.tryAdmit("q1", 0, 0, "left", chunk(2, 40));
        Path spillDir = createTempDir();
     */
        ShuffleBufferManager.ShuffleBuffer buffer = mgr.getBuffer("q1", 0, 0);  
                Thread.currentThread().interrupt();  
     * resident chunks spill to disk. The consumer's getLeftData() returns ALL chunks in ARRIVAL order
        Path queryDir = spillDir.resolve("q1");  
        assertTrue("the bulk must be on disk", mgr.getSpilledTotalBytes() > 0);
    /**  
            assertEquals("per-query footprint must be fully reclaimed", 0L, mgr.getQueryBytes("q" + qi));  
        ShuffleBufferManager mgr = new ShuffleBufferManager();
            assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(i, 40)));
            mgr.clearForQuery("other-" + i);  
        assertEquals((byte) 1, p0.get(1)[0]);
    public void testSpillEnabledRemoveBufferDeletesSpillFile() throws Exception {  
    public void testAwaitReadyTimesOut() throws Exception {
            // succeeds once p0's drain completes and removeBuffer frees its budget). The CRITICAL
        // Terminal cleanup releases disk + budget and deletes the spill file.
        start.countDown();
    /** Distinct, recognizable chunk content so order assertions are meaningful. */  
        List<byte[]> p0 = mgr.getBuffer("q1", 0, 0).getLeftData();
     * fail the test; all threads must terminate. Generous budget so admission never rejects — we're  
    /**  
        assertNull(mgr.getBuffer("q1", 0, 0));
    public void testSpillEnabledLazyDrainStreamsInArrivalOrder() throws Exception {  
        // Stage 0 partition 1's chunk: must spill same-stage sibling (stage 0 p0), NOT stage 9.
    public void testClearForQueryIdempotentAndNoOpWhenAbsent() {  
        assertEquals("nothing spilled", 0L, mgr.getSpilledTotalBytes());
     */
                        }  
        }
     * Spill DISABLED (the default): a per-query budget breach still throws the fail-fast
     * same stage that happen to land on the same worker node would share a buffer and leak rows +
        assertTrue("sibling partition 0 must have spilled to disk", mgr.getSpilledTotalBytes() > 0);
        assertSame("non-aborted query buffers are stored normally", live, mgr.getBuffer("q2", 0, 0));
     * a late producer admit for that query would then reserve bytes that no release reclaims. The fix  
            // One terminal thread per query that clears mid-flight (the cancel/abort race).  
     * Cross-partition spill must NOT cross stage boundaries: a buffer of a DIFFERENT (possibly already-  
    }  
        assertEquals("on-disk bytes released after removeBuffer", 0L, mgr.getSpilledTotalBytes());
     * Spill enabled but the chunks fit within the per-query budget: nothing spills, the spill subdir
        // A spill file must exist under the per-query subdir before cleanup.
    /**
    public void testDiscardRacedBufferLeavesUnrelatedBuffer() {  
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 50)));
     */
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 50)));  
        // Late producer RPC racing in after the clear: accepted (don't make it retry) but NOT reserved.  
        mgr.tryAdmit("q1", 0, 0, "left", chunk(2, 50)); // forces a spill of the oldest chunk  
        // throws.  
        Path queryDir = spillDir.resolve("q1");
    public void testCompletionTriggeredEvenIfSendersFinishBeforeExpectedSet() throws Exception {  
        buffer.senderDone("right");
        assertEquals("late admit on a tombstoned query must reserve no bytes", 0L, mgr.getTotalBytes());
        ShuffleBufferManager mgr = new ShuffleBufferManager();
                byte[] c = it.next();
        }
        mgr.clearForQuery("q1");  
        assertEquals("clearForQuery must remove all 3 of q1's buffers", 3, removed);  
        mgr.setSpillConfig(true, spillDir, 1_000_000);
        }
        }
    }
        assertFalse("awaitReady must time out when right side never completes", buffer.awaitReady(100));  
        assertNotSame("partition 0 and partition 1 must not share a buffer", p0, p1);
    }
        mgr.getOrCreateBuffer("q10", 0, 0);  
        // producer RPC for the victim reserves nothing and does not repopulate the map.  
        for (int i = 0; i < 5; i++) {
     * Disk ceiling: with spill enabled but a tiny spill.max_bytes, exceeding the per-query budget
            assertTrue(p0.isDraining());
    public void testSpillEnabledCrossPartitionSpillsSibling() throws Exception {
        assertTrue("at least one .spill file must exist", countSpillFiles(queryDir) > 0);
    /**  
        mgr.setBudgets(100, 100);
        mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 50));
            mgr.clearForQuery("q" + qi);
        // the in-memory tail).  
        assertEquals("tombstoned admit must not reserve budget", 0L, mgr.getTotalBytes());
        assertNull(mgr.getBuffer("q1", 2, 1));
        assertEquals("disk accounting fully reclaimed", 0L, mgr.getSpilledTotalBytes());
        mgr.tryAdmit("q1", 1, 0, "left", new byte[20]);
        assertEquals("lazy drain must yield every chunk exactly once", n, seen);
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        ShuffleBufferManager.ShuffleBuffer buffer = mgr.getBuffer("q1", 0, 0);
    // contract (getLeftData/getRightData return the FULL chunk list in ARRIVAL order). When disabled,
    }  
        mgr.setSpillConfig(true, spillDir, 1_000_000);
            t++;  
 * compatible open source license.
        mgr.clearForQuery("q1");
     * Disk-byte accounting must not leak when a spill-file delete FAILS then the per-query dir sweep  
            assertEquals("chunk " + i + " size", 40, drained.get(i).length);  
            ShuffleBufferExceededException.class,  
    public void testTryAdmitOnTombstonedQueryReservesNoBytes() {
            assertEquals("a draining sibling must not be spilled", 0L, mgr.getSpilledTotalBytes());
     * single partition buffer may not hold enough resident bytes to cover a breach when the footprint
    /**  
        assertEquals((byte) 0, p0.get(0)[0]);
        senderThread.start();
        Path queryDir = spillDir.resolve("q1");
    }  
            while (it.hasNext()) {
        mgr.setBudgets(10_000, 1_000); // generous → no spill
        assertTrue("resident stays bounded by the per-query budget", mgr.getTotalBytes() <= 100);
     * is TTL-based tombstones (provably outlive the producer retry window). This test pins the
        assertEquals(10L, mgr.getTotalBytes());  
                    awaitQuietly(start);  
        // Stage 9's buffer kept all its bytes in memory (no spill file for it).
        mgr.setBudgets(100, 100);
        ShuffleBufferManager mgr = new ShuffleBufferManager();
                awaitQuietly(start);
     * is spread across sibling partitions of the same stage. When partition 1's first chunk arrives and  
        Path spillDir = createTempDir();  
        mgr.clearForQuery("q1");  
     * bytes released), and clearForQuery deletes the spill file (no disk leak).
        mgr.setBudgets(Long.MAX_VALUE, Long.MAX_VALUE);
import org.opensearch.analytics.spi.ShuffleBufferExceededException;
        mgr.getOrCreateBuffer("q1", 2, 0);
                        if (i % 7 == 0) {
        mgr.setSpillConfig(true, spillDir, 1_000_000);
        mgr.setBudgets(1_000, 1_000);
            th.join(30_000);
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", new byte[5]));
        mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 60));
                assertEquals("chunk " + seen + " size", 40, c.length);  
        ShuffleBufferManager.ShuffleBuffer p0 = mgr.getOrCreateBuffer("q1", 0, 0);
        // node==perQuery==100 (the production default: setBudgets(budget,budget)). Generous disk.
        mgr.setBudgets(/* node */ 10_000, /* perQuery */ 100);
        CopyOnWriteArrayList<Throwable> failures = new CopyOnWriteArrayList<>();
        mgr.clearForQuery("q1");
     * shouldn't retry a cancelled query) and leave totalBytes untouched.
        assertEquals("accounting must be untouched", before, mgr.getTotalBytes());
     */  
        Thread.UncaughtExceptionHandler ueh = (thread, ex) -> failures.add(ex);
            b[i] = (byte) marker;
            }
            });
                        // Stage doubles as partition spread; some admits race the clear below.
     * Tombstone-race spill leak (codex round-3 BLOCKER #2): when getOrCreateBuffer's computeIfAbsent  
        assertNull("buffer must be removed from the map", mgr.getBuffer("q1", 0, 0));
     */  
    }
        ShuffleBufferManager mgr = new ShuffleBufferManager();
     * replaced it), discardRacedBuffer must leave the other buffer and its accounting alone.
        ShuffleBufferManager.ShuffleBuffer buffer = new ShuffleBufferManager.ShuffleBuffer();  
        // Cancel/terminal clears q1 and tombstones it; budget fully reclaimed.  
        mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 50));
        Path spillDir = createTempDir();
     * Spill enabled: removeBuffer (the normal per-buffer drain terminal) must also delete that  
        mgr.setBudgets(1_000, 1_000);  
        ShuffleBufferManager.ShuffleBuffer a = mgr.getOrCreateBuffer("q1", 0, 0);
        mgr.setBudgets(100, 100);  
     * testing counter integrity under racing mutations, not the gates.
        mgr.getOrCreateBuffer("q1", 0, 0);
        assertEquals((byte) 2, p1.get(0)[0]);
        // Partition 0 of stage 0 fills the whole per-query budget (resident=100).
        mgr.clearForQuery("q1");
    // ---------------------------------------------------------------------------------------------
     */
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertTrue("a .spill file must exist before removeBuffer", countSpillFiles(queryDir) > 0);  
import java.util.concurrent.CountDownLatch;  
                assertEquals((byte) seen, it.next()[0]);  
     * Cross-partition spill (codex round-3 BLOCKER #1): the per-query budget is query-WIDE, but a
     * cleared, totalBytes AND every per-query footprint must be back to 0 — no leaked reservations
                seen++;  
}  
        // Stage 0 partition 0 holds 40 → query-wide resident now 100 (== budget).  
        mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 50));  
    private static long countSpillFiles(Path dir) throws Exception {  
        assertNotNull(mgr.getBuffer("q1", 0, 0));
     * (orphaned-admission, double-release, tombstoned-admit). Worker threads capture any throwable and
        // Simulate the raced discard of the existing (already-spilled) buffer — getOrCreateBuffer
        ShuffleBufferManager.ShuffleBuffer buffer = mgr.getBuffer("q1", 0, 0);
     * siblings are eligible. (codex round-3 BLOCKER #1 safety boundary.)
        assertEquals(200L, mgr.getTotalBytes());
                int stage = p;
        // Two left senders, one right sender. Mark them done from another thread, then await.  
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 50)));
        mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 50));
        buffer.setExpectedSenders(1, 1);  
    /** clearForQuery is idempotent and a no-op (0 removed) for a query with no buffers — the common
            assertTrue("no stage-9 spill file may exist", s.map(p -> p.getFileName().toString()).noneMatch(n -> n.startsWith("9-")));  
        mgr.setBudgets(1_000, 1_000);
        long before = mgr.getTotalBytes();
        Path spillDir = createTempDir();
        Path spillDir = createTempDir();
        assertEquals(100L, mgr.getTotalBytes());
        mgr.setBudgets(100, 100);  
        mgr.tryAdmit("q1", 0, 0, "left", chunk(2, 50)); // spills chunk 0 (54 <= 60 ceiling)
        mgr.setSpillConfig(true, spillDir, /* maxBytes */ 1_000_000);
    }  
        // Next chunk forces eviction of one chunk to disk → spilled total 54 (fits the 60 ceiling).
    /**  
        return b;  
        try (var it = p0.drainLeft()) {            // marks p0 draining (beginDrain under admitLock)
        mgr.removeBuffer("q1", 0, 0);
     * discard path must release the buffer's on-disk spill bytes (and delete its files) — not just drop
    public void testRemoveBufferDeletesIt() {
                t++;
        assertEquals(2, seen);  
        assertEquals("spill file deleted", 0L, countSpillFiles(queryDir));
        mgr.getOrCreateBuffer("q1", 4, 0);
    // oldest buffered chunks to disk instead of failing fast, preserving the buffer-all consumer
     * Concurrency stress for the accounting BLOCKERs: many producers admit while terminal hooks
        // When q1 finishes and releases, q2's retry now fits.  
     * Cross-partition spill must NOT evict from a sibling that has begun DRAINING (codex round-4  
 * The OpenSearch Contributors require contributions made to  
        assertEquals("nothing spilled when under budget", 0L, mgr.getSpilledTotalBytes());  
        mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 40));  
        // Tight per-query budget so almost everything spills; the lazy iterator must still reproduce  
     * Counts {@code .spill} files directly under {@code dir} (0 if the dir is absent). Filtering on
        assertEquals(1L, p1.getCurrentBytes());
                threads[t] = new Thread(() -> {
     * the map entry. A lock-free buffers.remove would leak spilledTotalBytes permanently. This drives  
        assertTrue("spill subdir must exist", Files.isDirectory(queryDir));  
            assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(i, 40)));
        assertEquals(AdmitResult.REJECT_RETRY, mgr.tryAdmit("q2", 1, 0, "left", new byte[5]));
        // Partition 1's first chunk: query-wide would be 140 > 100. Pre-fix this REJECT_RETRY'd to
        ShuffleBufferManager mgr = new ShuffleBufferManager();
                            mgr.removeBuffer(q, stage, i % 3);
        assertNotNull(buffer);
     * tryAdmit throws a NON-retryable ShuffleBufferExceededException (not REJECT_RETRY). This is the  
    public void testGetOrCreateAfterClearDoesNotRepopulate() {  
            buffer.senderDone("right");
    public void testSpillDisabledStillFailsFast() {  
     */
import org.opensearch.analytics.exec.shuffle.ShuffleBufferManager.AdmitResult;
        byte[] b = new byte[size];
        assertEquals(0L, mgr.getTotalBytes());  
            () -> mgr.tryAdmit("q1", 0, 0, "left", chunk(3, 50)) // would spill a 2nd chunk → 108 > 60
        assertEquals(100L, mgr.getTotalBytes());  
        ShuffleBufferManager mgr = new ShuffleBufferManager();
    public void testSpillByteAccountingFullyReclaimedOnClear() throws Exception {  
    private static void awaitQuietly(CountDownLatch latch) {
    /**  
        assertEquals(1, mgr.clearForQuery("q1"));  
        assertNull(mgr.getBuffer("q1", 7, 3));  
     * clearForQuery must remove EVERY buffer for the query (all stages + partitions on this node) so
        assertEquals("on-disk spill bytes must be released (no leak)", 0L, mgr.getSpilledTotalBytes());  
            // p0's in-flight drain still yields BOTH of its chunks intact, in order.  
        mgr.tryAdmit("victim", 0, 0, "left", new byte[100]);  
        mgr.getOrCreateBuffer("q1", 2, 0);
        Thread[] threads = new Thread[queries * (producersPerQuery + 1)];
                    }
        assertEquals(100L, mgr.getTotalBytes());
        assertEquals("no buffers → 0 removed", 0, mgr.clearForQuery("nonexistent"));
     * leak the node budget permanently. tryAdmit must drop the payload (still ACCEPTED — the producer
        Path spillDir = createTempDir();
     * 0, never undercount (which would silently shrink the effective budget for later queries).
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q2", 0, 0, "left", new byte[1_000]));  
    public void testLazyDrainNonSpilledSide() throws Exception {  
        ShuffleBufferManager mgr = new ShuffleBufferManager();  
    public void testCrossPartitionSpillSkipsDrainingSibling() throws Exception {  
     * intact. This is the cross-query leak fix — without it buffers live for the JVM's lifetime.  
            String q = "q" + qi;
     * BLOCKER (codex review round 2: tombstoned-admit-budget-leak via tombstone eviction). With the
        assertEquals(11L, ex.observedBytes());  
        p1.addData("left", new byte[] { 99 });
        // Mark left done but leave right pending — short timeout must return false.
        ShuffleBufferManager.ShuffleBuffer buffer = new ShuffleBufferManager.ShuffleBuffer();
        ShuffleBufferManager mgr = new ShuffleBufferManager(); // defaults to Long.MAX_VALUE budgets
        assertEquals("node budget fully reclaimed", 0L, mgr.getTotalBytes());
        }
            ShuffleBufferExceededException.class,
        assertFalse("no spill dir created when disabled", Files.exists(spillDir.resolve("q1")));
                startGate.await(5, TimeUnit.SECONDS);
     */
        assertTrue("precondition: something spilled", mgr.getSpilledTotalBytes() > 0);
    }
        // Per-query budget 100 bytes; node budget generous so only the per-query gate triggers spill.  
        // Resident on-heap must be bounded by the per-query budget — never the full 200 bytes.
        assertEquals("rejected chunk must not be reserved", 10L, mgr.getTotalBytes());
        ShuffleBufferManager mgr = new ShuffleBufferManager();
    /**
            // now p0 is skipped. With node==perQuery and p0 holding the whole budget, nothing is
            } catch (InterruptedException e) {
    /**
import java.util.concurrent.CopyOnWriteArrayList;
    /**
        try (var it = buffer.drainLeft()) {  
                mgr.clearForQuery(q);  
public class ShuffleBufferManagerTests extends OpenSearchTestCase {  
     * queries finish), NOT a throw.
        // The victim's tombstone must STILL be live (TTL is 120s; this loop is sub-second), so a late
    }  
     * stays cleared and the late write lands on a collectible object. Without the tombstone this  
        ShuffleBufferManager.ShuffleBuffer p0 = mgr.getBuffer("q1", 0, 0);  
    /**
     * recreated buffer would leak (no consumer to drain/remove it).
        mgr.setBudgets(/* node */ 10, /* perQuery */ 10);
     * the {@code .spill} suffix is deliberate: the test framework's {@code ExtrasFS} mockfile injects
    }
     * directory configured, setSpillConfig(false, ...) keeps spill off. No spill file is created.
        assertNull("the throwaway must NOT be stored in the map", mgr.getBuffer("q1", 2, 0));
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 40)));
        ShuffleBufferExceededException ex = expectThrows(  
     * removeBuffer / clearForQuery concurrently. After all activity quiesces and every query is  
        mgr.clearForQuery("q1");
     * Hard per-query ceiling: when a SINGLE query's footprint would exceed the per-query budget,
     * Discard must be conditional: if the map entry for the key is NOT our buffer (a racing producer  
    }
    // Disk-spill (analytics.mpp.shuffle.spill.*) — when enabled, a per-query budget breach spills the  
     * Lazy drain on a NON-spilled side returns the plain in-memory chunks (fast path) and its
    /**  
        // re-checks after set, so the buffer must transition ready.
        mgr.setBudgets(10_000, 100);  
        int seen = 0;
        CountDownLatch start = new CountDownLatch(1);  
        assertNull(mgr.getBuffer("q1", 4, 0));  
        assertEquals(120L, ex.observedBytes());
        mgr.removeBuffer("q1", 1, 0); // frees 20
     */
        ShuffleBufferManager.ShuffleBuffer live = mgr.getOrCreateBuffer("q2", 0, 0);  
        mgr.removeBuffer("q1", 0, 0); // frees 30  
 * this file be licensed under the Apache-2.0 license or a
        int t = 0;  
     * the discard helper directly (the live branch only fires in a narrow concurrent window).
     * random {@code extraN} files/dirs into directories to catch code that assumes empty dirs, so a  
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 9, 0, "left", chunk(7, 60)));
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        for (int i = 0; i < 10_000; i++) {
            }
        assertEquals(0L, mgr.getTotalBytes());  
    }  
        for (int i = 0; i < 5; i++) {
        assertEquals("rejected chunk not reserved", 60L, mgr.getTotalBytes());  
        // Both partitions still drain their full chunk set in arrival order.
        // exhaustion (p1 had nothing of its own to spill); now the manager spills sibling p0.
            assertFalse("worker thread did not terminate within 30s", th.isAlive());
    }
        for (Thread th : threads) {  
        assertEquals("no .spill file may survive the terminal", 0L, countSpillFiles(queryDir));  
        mgr.setSpillConfig(false, spillDir, 1_000_000); // disabled
        mgr.setBudgets(/* node */ 100, /* perQuery */ 10);  
        for (int i = 0; i < n; i++) {  
                assertEquals((byte) (seen + 1), it.next()[0]);
            try {  
                seen++;
        int n = 50; // 50 chunks × 40 bytes = 2000 bytes; budget 100 → ~48 chunks on disk
        ShuffleBufferManager mgr = new ShuffleBufferManager();  
    }  
        assertSame("same key must return same buffer", a, b);  
            buffer.senderDone("left");  
        ShuffleBufferManager.ShuffleBuffer spilled = mgr.getBuffer("q1", 0, 0);
    }  
        assertTrue("expected some spill", spilledBefore > 0);
        assertNull("and must not repopulate the buffer map", mgr.getBuffer("victim", 0, 0));
     * full arrival sequence is reproduced AND the on-heap resident set stayed bounded throughout.
        assertEquals("disk accounting fully reclaimed", 0L, mgr.getSpilledTotalBytes());
        mgr.tryAdmit("q1", 0, 0, "left", chunk(2, 40));
 * SPDX-License-Identifier: Apache-2.0
                return;
     * Soft node-contention: when the NODE total would exceed the node budget but the query still  
        assertTrue("some bytes must have spilled to disk", mgr.getSpilledTotalBytes() > 0);  
        // Fill the budget: 100 bytes resident (chunks 0,1 of 50 each). Under budget so far.  
        mgr.clearForQuery("q1");
        // Terminal cleanup (as the coordinator does on failure) closes + deletes the open spill file.
            int seen = 0;
            while (it.hasNext()) {
import java.util.concurrent.TimeUnit;
        assertNull("tombstoned admit must not repopulate the map", mgr.getBuffer("q1", 0, 0));  
        }
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", new byte[10_000]));  
        // Late producer RPC for the cancelled query:
     * invariant directly: a tombstone is LIVE right after clearForQuery, and an admit while tombstoned
     */  
        // node budget 10, per-query budget 10 (each query may use the whole node if alone).  
                threads[t].setUncaughtExceptionHandler(ueh);  
        assertEquals("and reserve nothing against the per-query footprint", 0L, mgr.getQueryBytes("victim"));  
        mgr.tryAdmit("q1", 1, 0, "left", new byte[200]);
     * resulting isolation.
        mgr.setSpillConfig(true, spillDir, /* maxBytes */ 60);
     * bare "directory is empty" check would spuriously fail. We assert on OUR files only.
            }
     * partition 0 already holds the whole budget, the manager must spill partition 0 (a SAME-stage
 */  
     */
        // the full arrival order without ever holding all chunks resident.
            th.start();  
        assertTrue("awaitReady must complete after all senders signal done", buffer.awaitReady(5_000));  
        }  
    /**
        p0.addData("left", new byte[] { 10, 20 });
     * exceed the per-query budget (so most are on disk), drains via the lazy iterator, and asserts the  
        try {
        mgr.tryAdmit("q1", 0, 0, "left", new byte[100]);
    /** Prefix matching must not be fooled by a query id that is a PREFIX of another (q1 vs q10):
    /**
    public void testGetOrCreateReturnsStableBuffer() {
     *  the key separator ':' makes "q1:" not a prefix of "q10:". */
        mgr.discardRacedBuffer("q1", "q1:0:0", spilled);  
        ShuffleBufferManager.ShuffleBuffer b = mgr.getOrCreateBuffer("q1", 0, 0);
        assertEquals("no leaked reservations after all queries cleared", 0L, mgr.getTotalBytes());
        int producersPerQuery = 6;
        mgr.clearForQuery("q1");
        assertEquals("no .spill file may survive the terminal", 0L, countSpillFiles(spillDir.resolve("q1")));
        mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 50));
     * the on-heap payload becomes collectible at query end, while leaving OTHER queries' buffers
        int seen = 0;
        // Feed data into each partition and confirm isolation — p0 sees only its own bytes.  
        mgr.getOrCreateBuffer("q1", 0, 0);  
    }
        Path spillDir = createTempDir();
        // clearForQuery must delete the spill file(s) AND the per-query subdir (no disk leak), and  
        // Disk ceiling of 60 bytes. Each spilled 50-byte chunk costs 54 bytes on disk (50 payload + a  
     * BLOCKER #1): a drain may have already snapshotted the sibling's in-memory tail / opened its
     * is never created, and getLeftData returns the plain in-memory list (the fast no-spill path).
    public void testConcurrentAdmitClearKeepsCountersConsistent() throws Exception {  
        int queries = 8;  
import org.opensearch.test.OpenSearchTestCase;  
        // Edge case: senders may signal done before setExpectedSenders is called. The implementation
            () -> mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 60)) // 120 > 100, fail fast
     * throwaway that no removeBuffer/clearForQuery will ever release, so reserving bytes for it would  
        mgr.setSpillConfig(true, spillDir, 1_000_000);
        ShuffleBufferManager mgr = new ShuffleBufferManager();
    public void testClearForQueryPrefixIsExactPerQueryId() {  
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        // Feed five 40-byte chunks (200 bytes total) into the left side of one partition. The budget
        mgr.clearForQuery("q1");  
            threads[t] = new Thread(() -> {
        // Fill + overflow partition 0 so it spills to disk.  
     * drain so both branches are covered.
    public void testTryAdmitRejectsRetryableOnNodeContention() {
        mgr.setSpillConfig(true, spillDir, 1_000_000);
                assertEquals("chunk " + seen + " must be in arrival order", (byte) seen, c[0]);
    /**  
        assertTrue("a spill file must exist before discard", countSpillFiles(queryDir) > 0);
     * returns a PRE-EXISTING buffer that already SPILLED, and the query is then found tombstoned, the
        assertEquals("null queryId → 0 removed, no NPE", 0, mgr.clearForQuery(null));  
package org.opensearch.analytics.exec.shuffle;
        // The only spill file(s) must belong to stage 0 (key prefix "0-"), never stage 9 ("9-").
        // Stage 9 partition 0 holds 60 bytes resident (a different stage — must be left untouched).
        Thread senderThread = new Thread(() -> {
     * After clearForQuery (cancel/abort), a late producer RPC racing in via getOrCreateBuffer must
     * whole shuffle on-heap until OOM.
        }
     * must NOT re-materialize the whole partition into a List. This test feeds many chunks that far
        // The consumer drains the FULL set of 5 chunks in ARRIVAL order (spilled chunks first, then
    public void testDifferentPartitionsSameStageHaveDistinctBuffers() {  
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "right", new byte[10_000]));
        startGate.countDown();
                seen++;
        // A different (live) query is unaffected by q1's tombstone.
     * LAZY drain (the property that makes spill actually remove the heap ceiling): {@code drainLeft()}  
 *
        mgr.removeBuffer("q1", 0, 0); // drains + releases the 100-byte buffer  
    }
     * forces a spill that breaches the disk ceiling → terminal ShuffleBufferExceededException (the
    public void testNoBudgetAlwaysAccepts() {
    // behavior is byte-identical to the pre-spill fail-fast path (the tests above stay green).  
            Thread.currentThread().interrupt();
    }
        assertEquals(50L, mgr.getTotalBytes());
        ShuffleBufferManager mgr = new ShuffleBufferManager();
    public void testTryAdmitThrowsWhenQueryExceedsPerQueryBudget() {
        mgr.removeBuffer("q1", 7, 3);
        );  
        long spilledBefore = mgr.getSpilledTotalBytes();
     * clearForQuery, a late producer RPC must NOT reserve budget. The buffer it gets is an unstored
            }  
/*  
        // Final terminal sweep for every query (the real coordinator broadcasts this on every
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", new byte[5]));
        buffer.senderDone("left");
        assertEquals(20L, mgr.getTotalBytes());
        assertEquals("disk-ceiling exception names the spill.max_bytes limit", 60L, ex.limitBytes());
        assertEquals("rejected chunk not reserved", 6L, mgr.getTotalBytes());
        );  
     */
        assertNull(mgr.getBuffer("q1", 0, 0));  
        assertNull(mgr.getBuffer("q1", 2, 0));
     * NOT repopulate the map — it gets an unstored throwaway buffer instead, so the cleared query
        mgr.setBudgets(10_000, 100);  
    /** removeBuffer releases that buffer's reserved bytes back to the node + per-query budgets. */
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        }  
        List<byte[]> drained = buffer.getLeftData();  
        for (int i = 0; i < size; i++) {  
    }
    }
     * streams a spilled partition's chunks back ONE AT A TIME from disk, then the in-memory tail — it
     * {@code isLast} markers across partitions. This test pins the correct key shape and the  
    }
     * then begins draining; partition 1's incoming chunk must NOT spill partition 0 (it stays  
        }
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        mgr.getOrCreateBuffer("q1", 2, 1);  
        assertTrue(buffer.awaitReady(1_000));
        ShuffleBufferManager.ShuffleBuffer stranger = new ShuffleBufferManager.ShuffleBuffer();
                    for (int i = 0; i < 50; i++) {
            // invariant is that p0 was NOT spilled and its in-flight drain stays intact.
            return 0L;
        // The remainder lives on disk.
        ShuffleBufferManager mgr = new ShuffleBufferManager();  
        assertEquals(20_000L, mgr.getTotalBytes());
            while (it.hasNext()) {
    }
        assertEquals(100L, ex.limitBytes());
    }
        }
        buffer.senderDone("left");
        senderThread.join(1_000);
        assertTrue(Files.isDirectory(queryDir));  
    /**  
     *  non-shuffle / already-cleaned case, plus the cancellation backstop firing after normal cleanup. */
        buffer.setExpectedSenders(1, 1);  
    }
     * ShuffleBufferExceededException — byte-identical to the pre-spill behavior. Even with a spill  
    }  
        try (var s = Files.list(dir)) {
        }
    public void testRemoveBufferThenClearForQueryDoesNotDoubleRelease() {  
    public void testSpillEnabledExceedsBudgetNoThrowAndDrainsInArrivalOrder() throws Exception {  
        mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 50));
    /**  
        ShuffleBufferManager.ShuffleBuffer late = mgr.getOrCreateBuffer("q1", 2, 0);
    }
        );
            assertEquals(AdmitResult.REJECT_RETRY, mgr.tryAdmit("q1", 0, 1, "left", chunk(2, 40)));  
    }
    public void testSpillEnabledCrossPartitionDoesNotSpillOtherStage() throws Exception {
        mgr.getOrCreateBuffer("q1", 0, 0);
        assertEquals(10L, ex.limitBytes());
     * fits its per-query share, tryAdmit returns REJECT_RETRY (retryable — room frees when other
        assertNotNull("the real buffer must remain", mgr.getBuffer("q1", 0, 0));
            mgr.tryAdmit("q1", 7, 3, "right", chunk(i, 40));  
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("victim", 0, 0, "left", new byte[100]));
        mgr.setBudgets(10_000, 1_000);
     */  
        mgr.setSpillConfig(true, spillDir, /* maxBytes */ 1_000_000);  
        assertEquals(0L, mgr.getTotalBytes());
        // Drain via the LAZY iterator — pull one chunk at a time, asserting arrival order. We never  
        ShuffleBufferManager.ShuffleBuffer p1 = mgr.getOrCreateBuffer("q1", 0, 1);  
        assertEquals("other-stage buffer must stay fully resident", 60L, mgr.getBuffer("q1", 9, 0).getCurrentBytes());
        // Simulate heavy churn: clear far more than the old FIFO cap would have retained.
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q2", 1, 0, "left", new byte[5]));  
            // Partition 1's chunk arrives while p0 is draining. Pre-fix this would spill sibling p0;
        assertEquals("no .spill file may survive the terminal", 0L, countSpillFiles(spillDir.resolve("q1")));  
    /**
            for (int p = 0; p < producersPerQuery; p++) {  
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", new byte[100]));
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 1, "left", chunk(1, 40)));
        ShuffleBufferExceededException ex = expectThrows(
        assertEquals("no double-release: budget must return to exactly 0", 0L, mgr.getTotalBytes());
        assertTrue("per-query resident bounded too", mgr.getQueryBytes("q1") <= 100);
        mgr.setBudgets(/* node */ 1_000_000, /* perQuery */ 100);
        }  
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        // Next chunk pushes q1's own footprint to 11 > perQuery=10 → hard, non-retryable throw.
        // Partition 0 fills the whole budget, then a consumer begins draining it.  
        buffer.setExpectedSenders(2, 1);
        // 4-byte frame header), so the first spill (54 <= 60) fits and the second (108 > 60) breaches.
    }
            ShuffleBufferExceededException.class,
        assertNotNull("getOrCreate must still return a usable (throwaway) buffer, never null", late);  
    /**  
     * {@code close()} is a harmless no-op — exercises the {@code spill == null} branch of the lazy  
        ShuffleBufferManager.ShuffleBuffer c = mgr.getOrCreateBuffer("q1", 1, 0);
     * q17-OOM fix — a query that can't fit even on an idle node fails fast instead of buffering its
     */
                        mgr.tryAdmit(q, stage, i % 3, (i % 2 == 0) ? "left" : "right", new byte[16]);  
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        mgr.clearForQuery("q1");
        Path spillDir = createTempDir();
            latch.await(10, TimeUnit.SECONDS);  
        assertEquals("all 5 chunks must be drained (spilled + tail)", 5, drained.size());
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertNotSame("different stageId must yield a different buffer", a, c);  
    }
     * buffer's spill file and release its on-disk bytes — not just clearForQuery.
        assertEquals(0L, mgr.getTotalBytes());
        assertEquals(1, mgr.clearForQuery("q1"));  
        List<byte[]> p1 = mgr.getBuffer("q1", 0, 1).getLeftData();  
        // q1: two stages, multiple partitions (a cascade puts >1 worker stage on a node).
        // q2 still fits its own 10-byte share, but node total 6+5=11 > 10 → retryable reject.  
     * spill file, so spilling it would drop/duplicate rows or NPE. Here partition 0 fills the budget
        mgr.setSpillConfig(true, spillDir, 1_000_000);
        for (int qi = 0; qi < queries; qi++) {
        try (var s = Files.list(queryDir)) {
        assertEquals(80L, mgr.getTotalBytes());
    public void testTombstoneSurvivesManyOtherClearsAndBlocksReservation() {  
        assertEquals("nothing spilled when disabled", 0L, mgr.getSpilledTotalBytes());
        for (Thread th : threads) {
        }
        for (int qi = 0; qi < queries; qi++) {
     */
    // ---------------------------------------------------------------------------------------------
            buffer.senderDone("left");
     * BLOCKER (codex review: shuffle-budget-double-release): removeBuffer (per-buffer, on normal
    private static byte[] chunk(int marker, int size) {
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 50)));
    /**
        assertEquals("disk accounting fully reclaimed after clear", 0L, mgr.getSpilledTotalBytes());
        // q2: a different query whose buffers must survive q1's cleanup.
     */
    public void testAwaitReadyCompletesWhenBothSidesDone() throws Exception {  
        }  
     * charged). The orphan-release path itself is exercised by deleteQuerySpillDir on every clear.
        assertEquals("partition 1 keeps its chunk", 1, p1.size());
        ShuffleBufferManager mgr = new ShuffleBufferManager();
     * reserves NO bytes — independent of how many OTHER queries are cleared in between (the case that  
    public void testSpillEnabledDiskCeilingThrows() throws Exception {
    /**
     * Drain one buffer via removeBuffer, then clearForQuery the rest — totalBytes must land at exactly  
import java.nio.file.Path;  
        ShuffleBufferManager mgr = new ShuffleBufferManager();  
                });
     */  
        mgr.tryAdmit("q1", 0, 0, "left", new byte[30]);  
     * normal terminal, spilledTotalBytes returns to 0 and the orphan map is empty (no path left  
     * disk-ceiling variant), NOT a silent run. limitBytes() reflects the disk ceiling.  
        assertEquals(100L, mgr.getTotalBytes());
        mgr.clearForQuery("victim");
        } catch (InterruptedException e) {
    }
        assertEquals(2L, p0.getCurrentBytes());  
     * drain) and clearForQuery (whole-query, on terminal) must compose without double-subtracting.
        Path queryDir = spillDir.resolve("q1");
        // A throwaway buffer that was never the map entry for q1:0:0.  
     */
        assertEquals(100L, mgr.getTotalBytes());
            }
        if (!Files.isDirectory(dir)) {
        mgr.tryAdmit("q1", 0, 0, "left", new byte[100]);  
        assertEquals(300L, mgr.getTotalBytes());
        // release all budget + disk accounting.
        // calls this after its post-insert tombstone re-check fires.
        CountDownLatch startGate = new CountDownLatch(1);
        assertEquals("removeBuffer must delete the buffer's .spill file", 0L, countSpillFiles(queryDir));
        assertTrue(mgr.getSpilledTotalBytes() > 0);
        mgr.discardRacedBuffer("q1", "q1:0:0", stranger);
     * sibling) to admit partition 1 — NOT fail-fast or REJECT_RETRY. Both partitions stay drainable.
        assertNotNull("q10 must be untouched by clearForQuery(q1)", mgr.getBuffer("q10", 0, 0));  
        int removed = mgr.clearForQuery("q1");
        // is 100 bytes, so the oldest chunks spill to keep resident bounded, and NONE of these admits
     */
        try (var it = buffer.drainLeft()) {  
        assertFalse("no spill subdir created when nothing spills", Files.exists(spillDir.resolve("q1")));
        assertEquals("partition 0 keeps both chunks (spilled + tail)", 2, p0.size());  
        assertTrue("resident bytes must be bounded by the budget, was " + mgr.getTotalBytes(), mgr.getTotalBytes() <= 100);  
     * Spill enabled: feeding chunks that exceed the per-query budget does NOT throw — the oldest
     * later removes the file (codex round-4 SHOULD-FIX #2). We can't easily force a delete IOException
        mgr.setBudgets(100, 100);
     */
        assertEquals("cross-partition spill must admit, not reject", AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 1, "left", chunk(2, 40)));  
        });  
    /** Budget disabled (Long.MAX_VALUE) → tryAdmit always accepts, never throws/rejects. */  
     * in a unit test, so this asserts the happy-path invariant the orphan tracker preserves: after a
        assertNotNull("a different query's buffer must NOT be cleared", mgr.getBuffer("q2", 2, 0));
            assertEquals("draining sibling delivers all its chunks despite the concurrent admit", 2, seen);  
    }  
        }
        Path spillDir = createTempDir();
        assertEquals("resident bytes released too", 0L, mgr.getTotalBytes());
    public void testDiscardRacedBufferReleasesSpillBytes() throws Exception {  
        // terminal); after it, all reservations — node total AND per-query — must be released.  
        assertEquals("node budget released after removeBuffer", 0L, mgr.getTotalBytes());  
     * draining) stage is never spilled to make room for an incoming chunk. Only same-(query,stage)
        mgr.setSpillConfig(true, spillDir, /* maxBytes */ 10_000_000);  
        assertEquals("only q1's buffer, not q10's", 1, mgr.clearForQuery("q1"));
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        ShuffleBufferManager.ShuffleBuffer buffer = new ShuffleBufferManager.ShuffleBuffer();
     */
        assertEquals("disk accounting fully reclaimed", 0L, mgr.getSpilledTotalBytes());
            assertEquals("chunk " + i + " must be in arrival order (marker " + i + ")", (byte) i, drained.get(i)[0]);
     * (spilled-then-tail), currentBytes/totalBytes reflect ONLY the in-memory-resident bytes (spilled  
        assertNotNull(buffer);
     * resident + fully drainable), even though that means partition 1's admit runs over budget.
     * used to evict the tombstone). We clear many other queries to simulate the eviction pressure.
     * prior COUNT-based FIFO cap, a still-in-window tombstone could be evicted by N other clears, and
        Path spillDir = createTempDir();
import java.nio.file.Files;
            // spillable, so the admit is REJECT_RETRY (the safe fallback — the producer retries and  
        mgr.setBudgets(10_000, 100);
        ShuffleBufferManager mgr = new ShuffleBufferManager();  
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        // build a full List from it, mirroring the consumer's chunk-at-a-time pump.
        assertEquals("second clear is a no-op", 0, mgr.clearForQuery("q1"));
    /**
    public void testClearForQueryRemovesAllQueryBuffersOnly() {
import java.util.List;
    }
            return s.filter(p -> p.getFileName().toString().endsWith(".spill")).count();
    public void testRemoveBufferReleasesBytes() {  
        for (int i = 0; i < 5; i++) {
        // Budget fully reclaimed → a fresh query can now use the whole node.
        List<byte[]> drained = mgr.getBuffer("q1", 0, 0).getLeftData();
        mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 40));  
        mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 40)); // the LIVE buffer at q1:0:0  
        mgr.setBudgets(100, 100);  
        mgr.getOrCreateBuffer("q2", 2, 0);  
    /**
    }
        assertNotNull(spilled);  
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", new byte[6]));
        mgr.tryAdmit("q1", 0, 0, "left", chunk(2, 50)); // spills
        }  
    public void testSpillEnabledNoSpillWhenUnderBudget() {
