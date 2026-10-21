    /** removeBuffer releases that buffer's reserved bytes back to the node + per-query budgets. */
        int t = 0;
        assertEquals("lazy drain must yield every chunk exactly once", n, seen);
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        }
    public void testSpillEnabledRemoveBufferDeletesSpillFile() throws Exception {
        Path spillDir = createTempDir();
        assertTrue("a .spill file must exist before removeBuffer", countSpillFiles(queryDir) > 0);
        }
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        Path spillDir = createTempDir();
     * Disk-byte accounting must not leak when a spill-file delete FAILS then the per-query dir sweep
        assertTrue(buffer.awaitReady(1_000));
     * used to evict the tombstone). We clear many other queries to simulate the eviction pressure.
        mgr.setBudgets(Long.MAX_VALUE, Long.MAX_VALUE);
        mgr.setBudgets(10_000, 100);
    }
    }
        }
     * then begins draining; partition 1's incoming chunk must NOT spill partition 0 (it stays
     * a late producer admit for that query would then reserve bytes that no release reclaims. The fix
        assertTrue("worker threads threw: " + failures, failures.isEmpty());
        mgr.tryAdmit("q1", 0, 0, "left", chunk(2, 50)); // forces a spill of the oldest chunk
        try (var s = Files.list(queryDir)) {
    public void testTryAdmitRejectsRetryableOnNodeContention() {
        ShuffleBufferManager.ShuffleBuffer buffer = new ShuffleBufferManager.ShuffleBuffer();
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        buffer.setExpectedSenders(1, 1);
            b[i] = (byte) marker;
        mgr.setBudgets(/* node */ 10, /* perQuery */ 10);
    /** clearForQuery is idempotent and a no-op (0 removed) for a query with no buffers — the common
     * Disk ceiling: with spill enabled but a tiny spill.max_bytes, exceeding the per-query budget
     */
    }
        // Edge case: senders may signal done before setExpectedSenders is called. The implementation
        mgr.clearForQuery("q1");
     * must NOT re-materialize the whole partition into a List. This test feeds many chunks that far
     */
        assertEquals("no .spill file may survive the terminal", 0L, countSpillFiles(queryDir));
        ShuffleBufferManager mgr = new ShuffleBufferManager();
    /**
        for (int i = 0; i < n; i++) {
     * buffer's spill file and release its on-disk bytes — not just clearForQuery.
     * BLOCKER (codex review: tombstoned-admit-budget-leak): once a query is tombstoned by
        assertEquals("rejected chunk must not be reserved", 10L, mgr.getTotalBytes());
     * bytes released), and clearForQuery deletes the spill file (no disk leak).
        ShuffleBufferManager mgr = new ShuffleBufferManager();
     * shouldn't retry a cancelled query) and leave totalBytes untouched.
            }
     * queries finish), NOT a throw.
            assertTrue("no stage-9 spill file may exist", s.map(p -> p.getFileName().toString()).noneMatch(n -> n.startsWith("9-")));
        mgr.removeBuffer("q1", 7, 3);
        // Mark left done but leave right pending — short timeout must return false.
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 50)));
    public void testDiscardRacedBufferLeavesUnrelatedBuffer() {
    // ---------------------------------------------------------------------------------------------
        ShuffleBufferExceededException ex = expectThrows(
        // clearForQuery must delete the spill file(s) AND the per-query subdir (no disk leak), and
        // The victim's tombstone must STILL be live (TTL is 120s; this loop is sub-second), so a late
     * clearForQuery must remove EVERY buffer for the query (all stages + partitions on this node) so
        Thread senderThread = new Thread(() -> {
        assertEquals("disk accounting fully reclaimed", 0L, mgr.getSpilledTotalBytes());
        } catch (InterruptedException e) {
        mgr.clearForQuery("q1");
            threads[t] = new Thread(() -> {
        assertEquals("node budget released after removeBuffer", 0L, mgr.getTotalBytes());
        assertEquals("no leaked reservations after all queries cleared", 0L, mgr.getTotalBytes());
        assertEquals("no .spill file may survive the terminal", 0L, countSpillFiles(spillDir.resolve("q1")));
     */
        assertEquals("and reserve nothing against the per-query footprint", 0L, mgr.getQueryBytes("victim"));
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertEquals("disk accounting fully reclaimed after clear", 0L, mgr.getSpilledTotalBytes());
    public void testCompletionTriggeredEvenIfSendersFinishBeforeExpectedSet() throws Exception {
            while (it.hasNext()) {
     * Counts {@code .spill} files directly under {@code dir} (0 if the dir is absent). Filtering on
    /**
            // invariant is that p0 was NOT spilled and its in-flight drain stays intact.
    public void testTryAdmitThrowsWhenQueryExceedsPerQueryBudget() {
        // the full arrival order without ever holding all chunks resident.
                awaitQuietly(start);
        assertNull("and must not repopulate the buffer map", mgr.getBuffer("victim", 0, 0));
        for (int i = 0; i < 10_000; i++) {
        ShuffleBufferManager.ShuffleBuffer b = mgr.getOrCreateBuffer("q1", 0, 0);
        // Disk ceiling of 60 bytes. Each spilled 50-byte chunk costs 54 bytes on disk (50 payload + a
    }
     * throwaway that no removeBuffer/clearForQuery will ever release, so reserving bytes for it would
     * is spread across sibling partitions of the same stage. When partition 1's first chunk arrives and
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertEquals("disk accounting fully reclaimed", 0L, mgr.getSpilledTotalBytes());
    }
            th.join(30_000);
        Path queryDir = spillDir.resolve("q1");
        ShuffleBufferManager.ShuffleBuffer c = mgr.getOrCreateBuffer("q1", 1, 0);
        assertNull("the throwaway must NOT be stored in the map", mgr.getBuffer("q1", 2, 0));
            assertEquals("draining sibling delivers all its chunks despite the concurrent admit", 2, seen);
        mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 50));
        assertNotSame("different stageId must yield a different buffer", a, c);
import org.opensearch.analytics.exec.shuffle.ShuffleBufferManager.AdmitResult;
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertTrue("resident bytes must be bounded by the budget, was " + mgr.getTotalBytes(), mgr.getTotalBytes() <= 100);
        mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 50));
        assertEquals(50L, mgr.getTotalBytes());
        mgr.removeBuffer("q1", 0, 0);
        mgr.setBudgets(10_000, 1_000); // generous → no spill
        assertEquals(0L, mgr.getTotalBytes());
        Path spillDir = createTempDir();
     */
            while (it.hasNext()) {
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertEquals("late admit on a tombstoned query must reserve no bytes", 0L, mgr.getTotalBytes());
            t++;
        Path spillDir = createTempDir();
        // Budget fully reclaimed → a fresh query can now use the whole node.
            }
        Path spillDir = createTempDir();
        assertEquals(100L, mgr.getTotalBytes());
        }
            }
     * drain) and clearForQuery (whole-query, on terminal) must compose without double-subtracting.
    /**
    public void testNoBudgetAlwaysAccepts() {
        Path spillDir = createTempDir();
        // node==perQuery==100 (the production default: setBudgets(budget,budget)). Generous disk.
    public void testTryAdmitOnTombstonedQueryReservesNoBytes() {
    }
                    awaitQuietly(start);
import java.util.concurrent.CopyOnWriteArrayList;
    }
            // One terminal thread per query that clears mid-flight (the cancel/abort race).
        assertTrue("resident must stay bounded by the budget", mgr.getTotalBytes() <= 100);
        assertNotSame("partition 0 and partition 1 must not share a buffer", p0, p1);
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", new byte[10_000]));
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("victim", 0, 0, "left", new byte[100]));
        assertEquals((byte) 2, p1.get(0)[0]);
        assertEquals(120L, ex.observedBytes());
        assertTrue("resident stays bounded by the per-query budget", mgr.getTotalBytes() <= 100);
     * is TTL-based tombstones (provably outlive the producer retry window). This test pins the
        if (!Files.isDirectory(dir)) {
 *
        assertNull("tombstoned admit must not repopulate the map", mgr.getBuffer("q1", 0, 0));
        int seen = 0;
                    for (int i = 0; i < 50; i++) {
                threads[t] = new Thread(() -> {
        // Stage 9 partition 0 holds 60 bytes resident (a different stage — must be left untouched).
                t++;
        assertEquals("removeBuffer must delete the buffer's .spill file", 0L, countSpillFiles(queryDir));
    }
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q2", 1, 0, "left", new byte[5]));
        assertEquals(20_000L, mgr.getTotalBytes());
     * clearForQuery, a late producer RPC must NOT reserve budget. The buffer it gets is an unstored
    public void testLazyDrainNonSpilledSide() throws Exception {
        mgr.setBudgets(10_000, 100);
        assertEquals(1, mgr.clearForQuery("q1"));
        assertEquals(10L, ex.limitBytes());
        try (var it = p0.drainLeft()) {            // marks p0 draining (beginDrain under admitLock)
        assertTrue("awaitReady must complete after all senders signal done", buffer.awaitReady(5_000));
            } catch (InterruptedException e) {
        }
        // calls this after its post-insert tombstone re-check fires.
            // p0's in-flight drain still yields BOTH of its chunks intact, in order.
        ShuffleBufferManager.ShuffleBuffer p1 = mgr.getOrCreateBuffer("q1", 0, 1);
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "right", new byte[10_000]));
        try (var it = buffer.drainLeft()) {
    }
            while (it.hasNext()) {
     */
        assertEquals("rejected chunk not reserved", 60L, mgr.getTotalBytes());
     */
    }
        assertEquals(0L, mgr.getTotalBytes());
        // q1: two stages, multiple partitions (a cascade puts >1 worker stage on a node).
    private static long countSpillFiles(Path dir) throws Exception {
        assertEquals(80L, mgr.getTotalBytes());
import java.util.List;
    /**
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        int seen = 0;
        mgr.getOrCreateBuffer("q1", 4, 0);
        mgr.setSpillConfig(true, spillDir, /* maxBytes */ 1_000_000);
        mgr.clearForQuery("q1");
        ShuffleBufferManager.ShuffleBuffer p0 = mgr.getBuffer("q1", 0, 0);
    }
    }
        assertEquals(1, mgr.clearForQuery("q1"));
        mgr.getOrCreateBuffer("q1", 2, 0);
        assertEquals("rejected chunk not reserved", 6L, mgr.getTotalBytes());
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 1, "left", chunk(1, 40)));
        mgr.tryAdmit("q1", 0, 0, "left", new byte[100]);
        p0.addData("left", new byte[] { 10, 20 });
        mgr.clearForQuery("q1");
        // Partition 1's first chunk: query-wide would be 140 > 100. Pre-fix this REJECT_RETRY'd to
        ShuffleBufferExceededException ex = expectThrows(
            });
        assertEquals(100L, mgr.getTotalBytes());
        mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 40));
                        if (i % 7 == 0) {
            th.start();
        mgr.clearForQuery("q1");
        mgr.getOrCreateBuffer("q1", 0, 0);
        assertNotNull("a different query's buffer must NOT be cleared", mgr.getBuffer("q2", 2, 0));
            assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(i, 40)));
        mgr.tryAdmit("q1", 0, 0, "left", chunk(2, 40));
        assertEquals(1L, p1.getCurrentBytes());
        }
            return 0L;
        ShuffleBufferManager.ShuffleBuffer spilled = mgr.getBuffer("q1", 0, 0);
        assertEquals(300L, mgr.getTotalBytes());
            buffer.senderDone("left");
    }
        mgr.removeBuffer("q1", 0, 0); // frees 30
     */
            buffer.senderDone("left");
    }
        assertEquals(10L, mgr.getTotalBytes());
        // A different (live) query is unaffected by q1's tombstone.
     * Discard must be conditional: if the map entry for the key is NOT our buffer (a racing producer
        assertEquals("second clear is a no-op", 0, mgr.clearForQuery("q1"));
        }
        assertNotNull(buffer);
        // exhaustion (p1 had nothing of its own to spill); now the manager spills sibling p0.
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 50)));
    public void testTombstoneSurvivesManyOtherClearsAndBlocksReservation() {
     *  the key separator ':' makes "q1:" not a prefix of "q10:". */
        assertSame("same key must return same buffer", a, b);
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        Path spillDir = createTempDir();
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertNotNull(buffer);
            buffer.senderDone("right");
        mgr.setSpillConfig(true, spillDir, 1_000_000);
     * single partition buffer may not hold enough resident bytes to cover a breach when the footprint
        mgr.setBudgets(/* node */ 10_000, /* perQuery */ 100);
        // Stage 0 partition 0 holds 40 → query-wide resident now 100 (== budget).
import java.nio.file.Files;
        Path spillDir = createTempDir();
                assertEquals("chunk " + seen + " size", 40, c.length);
     * Hard per-query ceiling: when a SINGLE query's footprint would exceed the per-query budget,
        // Terminal cleanup (as the coordinator does on failure) closes + deletes the open spill file.
 * compatible open source license.
        Path spillDir = createTempDir();
        // Per-query budget 100 bytes; node budget generous so only the per-query gate triggers spill.
            () -> mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 60)) // 120 > 100, fail fast
        ShuffleBufferManager.ShuffleBuffer buffer = mgr.getBuffer("q1", 0, 0);
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q2", 0, 0, "left", new byte[1_000]));
    }
     * the on-heap payload becomes collectible at query end, while leaving OTHER queries' buffers
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        // Cancel/terminal clears q1 and tombstones it; budget fully reclaimed.
     * intact. This is the cross-query leak fix — without it buffers live for the JVM's lifetime.
        mgr.getOrCreateBuffer("q1", 0, 0);
        assertNotNull(spilled);
    /**
        assertEquals(100L, mgr.getTotalBytes());
        p1.addData("left", new byte[] { 99 });
    public void testSpillEnabledExceedsBudgetNoThrowAndDrainsInArrivalOrder() throws Exception {
     * returns a PRE-EXISTING buffer that already SPILLED, and the query is then found tombstoned, the
import java.util.concurrent.CountDownLatch;
    public void testClearForQueryRemovesAllQueryBuffersOnly() {
    }
     */
        assertTrue("some bytes must have spilled to disk", mgr.getSpilledTotalBytes() > 0);
        assertTrue("spill subdir must exist", Files.isDirectory(queryDir));
        buffer.senderDone("left");
        // Tight per-query budget so almost everything spills; the lazy iterator must still reproduce
        mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 50));
    }
                threads[t].setUncaughtExceptionHandler(ueh);
                startGate.await(5, TimeUnit.SECONDS);
                        // Stage doubles as partition spread; some admits race the clear below.
        long before = mgr.getTotalBytes();
     * tryAdmit throws a NON-retryable ShuffleBufferExceededException (not REJECT_RETRY). This is the
    }
     * Cross-partition spill must NOT evict from a sibling that has begun DRAINING (codex round-4
    public void testRemoveBufferDeletesIt() {
                int stage = p;
            // Partition 1's chunk arrives while p0 is draining. Pre-fix this would spill sibling p0;
    public void testDifferentPartitionsSameStageHaveDistinctBuffers() {
            for (int p = 0; p < producersPerQuery; p++) {
        byte[] b = new byte[size];
        buffer.senderDone("right");
        assertNotNull(mgr.getBuffer("q1", 0, 0));
     * same stage that happen to land on the same worker node would share a buffer and leak rows +
        assertEquals(2, seen);
     * LAZY drain (the property that makes spill actually remove the heap ceiling): {@code drainLeft()}
     */
        assertTrue("the bulk must be on disk", mgr.getSpilledTotalBytes() > 0);
            assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(i, 40)));
    public void testSpillEnabledCrossPartitionSpillsSibling() throws Exception {
        // The consumer drains the FULL set of 5 chunks in ARRIVAL order (spilled chunks first, then
    public void testRemoveBufferThenClearForQueryDoesNotDoubleRelease() {
    public void testAwaitReadyTimesOut() throws Exception {
        ShuffleBufferManager.ShuffleBuffer a = mgr.getOrCreateBuffer("q1", 0, 0);
                Thread.currentThread().interrupt();
     * (orphaned-admission, double-release, tombstoned-admit). Worker threads capture any throwable and
        assertFalse("awaitReady must time out when right side never completes", buffer.awaitReady(100));
        assertNotNull("q10 must be untouched by clearForQuery(q1)", mgr.getBuffer("q10", 0, 0));
        mgr.removeBuffer("q1", 0, 0); // drains + releases the 100-byte buffer
        // Resident on-heap must be bounded by the per-query budget — never the full 200 bytes.
        mgr.tryAdmit("victim", 0, 0, "left", new byte[100]);
        Path queryDir = spillDir.resolve("q1");
     */
        assertEquals("clearForQuery must remove all 3 of q1's buffers", 3, removed);
    /** Distinct, recognizable chunk content so order assertions are meaningful. */
        mgr.tryAdmit("q1", 0, 0, "left", new byte[30]);
        assertTrue("per-query resident bounded too", mgr.getQueryBytes("q1") <= 100);
            }
     *  non-shuffle / already-cleaned case, plus the cancellation backstop firing after normal cleanup. */
        // the in-memory tail).
        assertEquals("tombstoned admit must not reserve budget", 0L, mgr.getTotalBytes());
     * recreated buffer would leak (no consumer to drain/remove it).
        mgr.setSpillConfig(false, spillDir, 1_000_000); // disabled
    private static void awaitQuietly(CountDownLatch latch) {
        assertNull(mgr.getBuffer("q1", 0, 0));
        Path queryDir = spillDir.resolve("q1");
        // producer RPC for the victim reserves nothing and does not repopulate the map.
        assertFalse("no spill subdir created when nothing spills", Files.exists(spillDir.resolve("q1")));
        ShuffleBufferManager mgr = new ShuffleBufferManager();
     */
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertNull(mgr.getBuffer("q1", 2, 0));
        ShuffleBufferManager.ShuffleBuffer stranger = new ShuffleBufferManager.ShuffleBuffer();
            // spillable, so the admit is REJECT_RETRY (the safe fallback — the producer retries and
        // 4-byte frame header), so the first spill (54 <= 60) fits and the second (108 > 60) breaches.
     * Tombstone-race spill leak (codex round-3 BLOCKER #2): when getOrCreateBuffer's computeIfAbsent
        for (int qi = 0; qi < queries; qi++) {
    }
        ShuffleBufferManager.ShuffleBuffer p0 = mgr.getOrCreateBuffer("q1", 0, 0);
            }
        }
        mgr.setSpillConfig(true, spillDir, 1_000_000);
        mgr.setBudgets(1_000, 1_000);
     */
     * Spill DISABLED (the default): a per-query budget breach still throws the fail-fast
     */
            ShuffleBufferExceededException.class,
        return b;
        ShuffleBufferManager mgr = new ShuffleBufferManager();
    private static byte[] chunk(int marker, int size) {
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        Thread.UncaughtExceptionHandler ueh = (thread, ex) -> failures.add(ex);
     */
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        mgr.removeBuffer("q1", 1, 0); // frees 20
/*
            () -> mgr.tryAdmit("q1", 0, 0, "left", chunk(3, 50)) // would spill a 2nd chunk → 108 > 60
        mgr.setBudgets(Long.MAX_VALUE, Long.MAX_VALUE);
        // build a full List from it, mirroring the consumer's chunk-at-a-time pump.
     * resident chunks spill to disk. The consumer's getLeftData() returns ALL chunks in ARRIVAL order
        // re-checks after set, so the buffer must transition ready.
    /**
    }
    }
    }
 * The OpenSearch Contributors require contributions made to
    // ---------------------------------------------------------------------------------------------
    }
        }
            return s.filter(p -> p.getFileName().toString().endsWith(".spill")).count();
            assertEquals(AdmitResult.REJECT_RETRY, mgr.tryAdmit("q1", 0, 1, "left", chunk(2, 40)));
        assertEquals(2L, p0.getCurrentBytes());
        mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 50));
        }
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        assertEquals("no .spill file may survive the terminal", 0L, countSpillFiles(spillDir.resolve("q1")));
    }
        mgr.setSpillConfig(true, spillDir, 1_000_000);
     * siblings are eligible. (codex round-3 BLOCKER #1 safety boundary.)
        int producersPerQuery = 6;
    public void testAwaitReadyCompletesWhenBothSidesDone() throws Exception {
        Path spillDir = createTempDir();
        for (Thread th : threads) {
        mgr.setSpillConfig(true, spillDir, 1_000_000);
        // The remainder lives on disk.
            mgr.clearForQuery("q" + qi);
        assertEquals(AdmitResult.REJECT_RETRY, mgr.tryAdmit("q2", 1, 0, "left", new byte[5]));
        // Feed data into each partition and confirm isolation — p0 sees only its own bytes.
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 50)));
        mgr.tryAdmit("q1", 0, 0, "left", chunk(2, 50)); // spills
     * invariant directly: a tombstone is LIVE right after clearForQuery, and an admit while tombstoned
    public void testSpillEnabledCrossPartitionDoesNotSpillOtherStage() throws Exception {
        });
        mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 60));
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", new byte[100]));
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 0; i < 5; i++) {
     * After clearForQuery (cancel/abort), a late producer RPC racing in via getOrCreateBuffer must
        CountDownLatch startGate = new CountDownLatch(1);
        assertSame("non-aborted query buffers are stored normally", live, mgr.getBuffer("q2", 0, 0));
        mgr.setBudgets(10_000, 1_000);
        // q2 still fits its own 10-byte share, but node total 6+5=11 > 10 → retryable reject.
        mgr.getOrCreateBuffer("q1", 2, 0);
        assertTrue(Files.isDirectory(queryDir));
    /** Prefix matching must not be fooled by a query id that is a PREFIX of another (q1 vs q10):
        );
     * the discard helper directly (the live branch only fires in a narrow concurrent window).
        List<byte[]> p1 = mgr.getBuffer("q1", 0, 1).getLeftData();
     * normal terminal, spilledTotalBytes returns to 0 and the orphan map is empty (no path left
     */
    public void testSpillByteAccountingFullyReclaimedOnClear() throws Exception {
                seen++;
        mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 50));
     * full arrival sequence is reproduced AND the on-heap resident set stayed bounded throughout.
        }
        assertEquals("nothing spilled when under budget", 0L, mgr.getSpilledTotalBytes());
                byte[] c = it.next();
        assertEquals(200L, mgr.getTotalBytes());
                mgr.clearForQuery(q);
        }
    /**
        senderThread.start();
        assertEquals(2, drained.size());
     * fail the test; all threads must terminate. Generous budget so admission never rejects — we're
        mgr.setSpillConfig(true, spillDir, /* maxBytes */ 60);
        assertEquals("node budget fully reclaimed", 0L, mgr.getTotalBytes());
        // Simulate heavy churn: clear far more than the old FIFO cap would have retained.
        for (int i = 0; i < size; i++) {
        mgr.tryAdmit("q1", 0, 0, "left", new byte[100]);
     */
        mgr.getOrCreateBuffer("q2", 2, 0);
                assertEquals((byte) seen, it.next()[0]);
    /**
        mgr.tryAdmit("q1", 1, 0, "left", new byte[20]);
        buffer.setExpectedSenders(1, 1);
                            mgr.removeBuffer(q, stage, i % 3);
        // Next chunk pushes q1's own footprint to 11 > perQuery=10 → hard, non-retryable throw.
        assertEquals(11L, ex.observedBytes());
        mgr.getOrCreateBuffer("q1", 0, 0);
            assertEquals("per-query footprint must be fully reclaimed", 0L, mgr.getQueryBytes("q" + qi));
        ShuffleBufferManager.ShuffleBuffer buffer = new ShuffleBufferManager.ShuffleBuffer();
        List<byte[]> drained = buffer.getLeftData();
     * discard path must release the buffer's on-disk spill bytes (and delete its files) — not just drop
    public void testSpillEnabledNoSpillWhenUnderBudget() {
        for (int i = 0; i < 5; i++) {
        assertTrue(mgr.getSpilledTotalBytes() > 0);
            try {
    /**
     * the map entry. A lock-free buffers.remove would leak spilledTotalBytes permanently. This drives
                        }
                        mgr.tryAdmit(q, stage, i % 3, (i % 2 == 0) ? "left" : "right", new byte[16]);
        // Terminal cleanup releases disk + budget and deletes the spill file.
    // oldest buffered chunks to disk instead of failing fast, preserving the buffer-all consumer
        Path queryDir = spillDir.resolve("q1");
            () -> mgr.tryAdmit("q1", 0, 0, "right", new byte[1])
        mgr.setBudgets(100, 100);
        mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 50));
        mgr.tryAdmit("q1", 0, 0, "left", chunk(2, 40));
        mgr.setSpillConfig(true, spillDir, 1_000_000);
        assertEquals(0L, mgr.getTotalBytes());
        senderThread.join(1_000);
        assertEquals("on-disk bytes released after removeBuffer", 0L, mgr.getSpilledTotalBytes());
        assertEquals(100L, mgr.getTotalBytes());
        assertNotNull("the real buffer must remain", mgr.getBuffer("q1", 0, 0));
        ShuffleBufferManager mgr = new ShuffleBufferManager();
     * later removes the file (codex round-4 SHOULD-FIX #2). We can't easily force a delete IOException
            assertEquals("a draining sibling must not be spilled", 0L, mgr.getSpilledTotalBytes());
        buffer.setExpectedSenders(2, 1);
        startGate.countDown();
        mgr.clearForQuery("q1");
    // behavior is byte-identical to the pre-spill fail-fast path (the tests above stay green).
        for (Thread th : threads) {
        CountDownLatch start = new CountDownLatch(1);
        mgr.setBudgets(100, 100);
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        // Next chunk forces eviction of one chunk to disk → spilled total 54 (fits the 60 ceiling).
            Thread.currentThread().interrupt();
 */
        );
        assertEquals("null queryId → 0 removed, no NPE", 0, mgr.clearForQuery(null));
        ShuffleBufferManager.ShuffleBuffer buffer = new ShuffleBufferManager.ShuffleBuffer();
package org.opensearch.analytics.exec.shuffle;
     * the {@code .spill} suffix is deliberate: the test framework's {@code ExtrasFS} mockfile injects
        assertEquals(20L, mgr.getTotalBytes());
            ShuffleBufferExceededException.class,
}
     * 0, never undercount (which would silently shrink the effective budget for later queries).
        ShuffleBufferManager mgr = new ShuffleBufferManager();
    }
        buffer.senderDone("left");
            latch.await(10, TimeUnit.SECONDS);
        assertEquals("nothing spilled", 0L, mgr.getSpilledTotalBytes());
                return;
     * removeBuffer / clearForQuery concurrently. After all activity quiesces and every query is
     * testing counter integrity under racing mutations, not the gates.
    /**
     * ShuffleBufferExceededException — byte-identical to the pre-spill behavior. Even with a spill
        assertEquals("nothing spilled when disabled", 0L, mgr.getSpilledTotalBytes());
        // Fill the budget: 100 bytes resident (chunks 0,1 of 50 each). Under budget so far.
        assertEquals((byte) 0, p0.get(0)[0]);
    public void testClearForQueryIdempotentAndNoOpWhenAbsent() {
        mgr.setSpillConfig(true, spillDir, 1_000_000);
    /**
        ShuffleBufferManager mgr = new ShuffleBufferManager();
    /**
        assertEquals("resident bytes released too", 0L, mgr.getTotalBytes());
     * whole shuffle on-heap until OOM.
            // succeeds once p0's drain completes and removeBuffer frees its budget). The CRITICAL
import java.nio.file.Path;
        mgr.setBudgets(/* node */ 1_000_000, /* perQuery */ 100);
    /**
        assertFalse("no spill dir created when disabled", Files.exists(spillDir.resolve("q1")));
        List<byte[]> p0 = mgr.getBuffer("q1", 0, 0).getLeftData();
     * Spill enabled: feeding chunks that exceed the per-query budget does NOT throw — the oldest
        // Two left senders, one right sender. Mark them done from another thread, then await.
        mgr.discardRacedBuffer("q1", "q1:0:0", spilled);
    public void testCrossPartitionSpillSkipsDrainingSibling() throws Exception {
        // Stage 0 partition 1's chunk: must spill same-stage sibling (stage 0 p0), NOT stage 9.
    /**
        assertNull(mgr.getBuffer("q1", 2, 1));
        }
        // Simulate the raced discard of the existing (already-spilled) buffer — getOrCreateBuffer
     * resident + fully drainable), even though that means partition 1's admit runs over budget.
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 9, 0, "left", chunk(7, 60)));
     */
     * disk-ceiling variant), NOT a silent run. limitBytes() reflects the disk ceiling.
 * SPDX-License-Identifier: Apache-2.0
     * drain so both branches are covered.
        int n = 50; // 50 chunks × 40 bytes = 2000 bytes; budget 100 → ~48 chunks on disk
            assertEquals("chunk " + i + " must be in arrival order (marker " + i + ")", (byte) i, drained.get(i)[0]);
     * BLOCKER (codex review: shuffle-budget-double-release): removeBuffer (per-buffer, on normal
     * BLOCKER (codex review round 2: tombstoned-admit-budget-leak via tombstone eviction). With the
     * fits its per-query share, tryAdmit returns REJECT_RETRY (retryable — room frees when other
    /**
        // When q1 finishes and releases, q2's retry now fits.
        mgr.clearForQuery("q1");
     * charged). The orphan-release path itself is exercised by deleteQuerySpillDir on every clear.
        try (var it = buffer.drainLeft()) {
        // is 100 bytes, so the oldest chunks spill to keep resident bounded, and NONE of these admits
     * Soft node-contention: when the NODE total would exceed the node budget but the query still
        mgr.setBudgets(1_000, 1_000);
        // Fill + overflow partition 0 so it spills to disk.
        mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 40));
        // Final terminal sweep for every query (the real coordinator broadcasts this on every
        assertEquals("other-stage buffer must stay fully resident", 60L, mgr.getBuffer("q1", 9, 0).getCurrentBytes());
     * random {@code extraN} files/dirs into directories to catch code that assumes empty dirs, so a
    }
     * draining) stage is never spilled to make room for an incoming chunk. Only same-(query,stage)
     * streams a spilled partition's chunks back ONE AT A TIME from disk, then the in-memory tail — it
            assertFalse("worker thread did not terminate within 30s", th.isAlive());
     * cleared, totalBytes AND every per-query footprint must be back to 0 — no leaked reservations
        assertEquals("all 5 chunks must be drained (spilled + tail)", 5, drained.size());
    /**
     * {@code close()} is a harmless no-op — exercises the {@code spill == null} branch of the lazy
        assertEquals(100L, mgr.getTotalBytes());
    /**
        ShuffleBufferManager.ShuffleBuffer buffer = mgr.getBuffer("q1", 0, 0);
        assertTrue("precondition: something spilled", mgr.getSpilledTotalBytes() > 0);
     * partition 0 already holds the whole budget, the manager must spill partition 0 (a SAME-stage
        List<byte[]> drained = mgr.getBuffer("q1", 0, 0).getLeftData();
     * bare "directory is empty" check would spuriously fail. We assert on OUR files only.
        mgr.setBudgets(100, 100);
        assertEquals("no buffers → 0 removed", 0, mgr.clearForQuery("nonexistent"));
        // Partition 0 fills the whole budget, then a consumer begins draining it.
        for (int i = 0; i < 5; i++) {
     * directory configured, setSpillConfig(false, ...) keeps spill off. No spill file is created.
     */
    // Disk-spill (analytics.mpp.shuffle.spill.*) — when enabled, a per-query budget breach spills the
        mgr.clearForQuery("q1");
        mgr.setBudgets(1_000, 1_000);
        mgr.setSpillConfig(true, spillDir, /* maxBytes */ 10_000_000);
        assertEquals("disk accounting fully reclaimed", 0L, mgr.getSpilledTotalBytes());
    public void testSpillDisabledStillFailsFast() {
    }
        assertTrue("a spill file must exist before discard", countSpillFiles(queryDir) > 0);
            mgr.clearForQuery("other-" + i);
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", new byte[5]));
        assertEquals(0L, mgr.getTotalBytes());
     * {@code isLast} markers across partitions. This test pins the correct key shape and the
                });
        assertTrue("expected some spill", spilledBefore > 0);
        int removed = mgr.clearForQuery("q1");
        int queries = 8;
    /**
        ShuffleBufferManager mgr = new ShuffleBufferManager(); // defaults to Long.MAX_VALUE budgets
        long spilledBefore = mgr.getSpilledTotalBytes();
     * sibling) to admit partition 1 — NOT fail-fast or REJECT_RETRY. Both partitions stay drainable.
        Thread[] threads = new Thread[queries * (producersPerQuery + 1)];
     * (spilled-then-tail), currentBytes/totalBytes reflect ONLY the in-memory-resident bytes (spilled
     * Cross-partition spill must NOT cross stage boundaries: a buffer of a DIFFERENT (possibly already-
        mgr.tryAdmit("q1", 0, 0, "left", chunk(2, 50)); // spills chunk 0 (54 <= 60 ceiling)
        mgr.clearForQuery("q1");
    /** Budget disabled (Long.MAX_VALUE) → tryAdmit always accepts, never throws/rejects. */
        // q2: a different query whose buffers must survive q1's cleanup.
    /**
     */
        assertEquals("partition 1 keeps its chunk", 1, p1.size());
        );
        mgr.clearForQuery("q1");
        assertEquals("disk-ceiling exception names the spill.max_bytes limit", 60L, ex.limitBytes());
    /**
        }
     * Codex review P1: buffers must be keyed by partitionIndex too, otherwise two partitions of the
                assertEquals("chunk " + seen + " must be in arrival order", (byte) seen, c[0]);
     * forces a spill that breaches the disk ceiling → terminal ShuffleBufferExceededException (the
    public void testRemoveBufferReleasesBytes() {
     * Spill enabled but the chunks fit within the per-query budget: nothing spills, the spill subdir
     */
     * is never created, and getLeftData returns the plain in-memory list (the fast no-spill path).
        mgr.setBudgets(/* node */ 100, /* perQuery */ 10);
        assertEquals((byte) 1, p0.get(1)[0]);
    }
     * stays cleared and the late write lands on a collectible object. Without the tombstone this
            threads[t].setUncaughtExceptionHandler(ueh);
    public void testGetOrCreateAfterClearDoesNotRepopulate() {
     * q17-OOM fix — a query that can't fit even on an idle node fails fast instead of buffering its
        for (int qi = 0; qi < queries; qi++) {
    /**
        assertEquals("spill file deleted", 0L, countSpillFiles(queryDir));
     */
        assertEquals(100L, ex.limitBytes());
        mgr.tryAdmit("q1", 1, 0, "left", new byte[200]);
     * prior COUNT-based FIFO cap, a still-in-window tombstone could be evicted by N other clears, and
        }
    }
        mgr.setBudgets(100, 100);
     * exceed the per-query budget (so most are on disk), drains via the lazy iterator, and asserts the
        assertNull(mgr.getBuffer("q1", 7, 3));
    // contract (getLeftData/getRightData return the FULL chunk list in ARRIVAL order). When disabled,
     * NOT repopulate the map — it gets an unstored throwaway buffer instead, so the cleared query
        ShuffleBufferExceededException ex = expectThrows(
        ShuffleBufferManager.ShuffleBuffer live = mgr.getOrCreateBuffer("q2", 0, 0);
     * BLOCKER #1): a drain may have already snapshotted the sibling's in-memory tail / opened its
            assertEquals("chunk " + i + " size", 40, drained.get(i).length);
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", new byte[6]));
    /**
        CopyOnWriteArrayList<Throwable> failures = new CopyOnWriteArrayList<>();
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 40)));
    public void testSpillEnabledLazyDrainStreamsInArrivalOrder() throws Exception {
    public void testConcurrentAdmitClearKeepsCountersConsistent() throws Exception {
        start.countDown();
        // Feed five 40-byte chunks (200 bytes total) into the left side of one partition. The budget
        assertNotNull("getOrCreate must still return a usable (throwaway) buffer, never null", late);
        }
        assertEquals("accounting must be untouched", before, mgr.getTotalBytes());
                seen++;
                seen++;
public class ShuffleBufferManagerTests extends OpenSearchTestCase {
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", new byte[5]));
        // clearForQuery must release only the REMAINING 200 (already net of the removeBuffer above).
        mgr.getOrCreateBuffer("q10", 0, 0);
        assertNull("buffer must be removed from the map", mgr.getBuffer("q1", 0, 0));
            assertTrue(p0.isDraining());
import java.util.concurrent.TimeUnit;
        ShuffleBufferManager.ShuffleBuffer buffer = mgr.getBuffer("q1", 0, 0);
        // A spill file must exist under the per-query subdir before cleanup.
        assertNull(mgr.getBuffer("q1", 4, 0));
        mgr.discardRacedBuffer("q1", "q1:0:0", stranger);
     * Spill enabled: removeBuffer (the normal per-buffer drain terminal) must also delete that
     * Concurrency stress for the accounting BLOCKERs: many producers admit while terminal hooks
        // Stage 9's buffer kept all its bytes in memory (no spill file for it).
        assertEquals("only q1's buffer, not q10's", 1, mgr.clearForQuery("q1"));
    public void testGetOrCreateReturnsStableBuffer() {
                    }
     * Drain one buffer via removeBuffer, then clearForQuery the rest — totalBytes must land at exactly
            // now p0 is skipped. With node==perQuery and p0 holding the whole budget, nothing is
        mgr.setBudgets(100, 100);
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        mgr.getOrCreateBuffer("q1", 2, 1);
    public void testDiscardRacedBufferReleasesSpillBytes() throws Exception {
        ShuffleBufferManager mgr = new ShuffleBufferManager();
        mgr.setBudgets(100, 100);
        try (var s = Files.list(dir)) {
     */
            ShuffleBufferExceededException.class,
        // terminal); after it, all reservations — node total AND per-query — must be released.
            mgr.tryAdmit("q1", 7, 3, "right", chunk(i, 40));
    }
        assertEquals("on-disk spill bytes must be released (no leak)", 0L, mgr.getSpilledTotalBytes());
        // release all budget + disk accounting.
     * reserves NO bytes — independent of how many OTHER queries are cleared in between (the case that
        mgr.clearForQuery("victim");
    public void testSpillEnabledDiskCeilingThrows() throws Exception {
        // throws.
        assertNull(mgr.getBuffer("q1", 0, 0));
        assertEquals("cross-partition spill must admit, not reject", AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 1, "left", chunk(2, 40)));
     * spill file, so spilling it would drop/duplicate rows or NPE. Here partition 0 fills the budget
     * Cross-partition spill (codex round-3 BLOCKER #1): the per-query budget is query-WIDE, but a
        assertTrue("sibling partition 0 must have spilled to disk", mgr.getSpilledTotalBytes() > 0);
        // Late producer RPC for the cancelled query:
     * Lazy drain on a NON-spilled side returns the plain in-memory chunks (fast path) and its
        assertEquals("partition 0 keeps both chunks (spilled + tail)", 2, p0.size());
        // Both partitions still drain their full chunk set in arrival order.
            String q = "q" + qi;
        // node budget 10, per-query budget 10 (each query may use the whole node if alone).
     * replaced it), discardRacedBuffer must leave the other buffer and its accounting alone.
        ShuffleBufferManager.ShuffleBuffer late = mgr.getOrCreateBuffer("q1", 2, 0);
        // Late producer RPC racing in after the clear: accepted (don't make it retry) but NOT reserved.
        }
        // A throwaway buffer that was never the map entry for q1:0:0.
        mgr.tryAdmit("q1", 0, 0, "left", chunk(0, 40)); // the LIVE buffer at q1:0:0
        // Drain via the LAZY iterator — pull one chunk at a time, asserting arrival order. We never
     * leak the node budget permanently. tryAdmit must drop the payload (still ACCEPTED — the producer
        mgr.setSpillConfig(true, spillDir, /* maxBytes */ 1_000_000);
        // Partition 0 of stage 0 fills the whole per-query budget (resident=100).
        mgr.setBudgets(10_000, 100);
    /**
    }
     * in a unit test, so this asserts the happy-path invariant the orphan tracker preserves: after a
import org.opensearch.analytics.spi.ShuffleBufferExceededException;
    public void testClearForQueryPrefixIsExactPerQueryId() {
        try {
    }
    }
        assertEquals("no double-release: budget must return to exactly 0", 0L, mgr.getTotalBytes());
        assertEquals(AdmitResult.ACCEPTED, mgr.tryAdmit("q1", 0, 0, "left", chunk(1, 50)));
        assertTrue("at least one .spill file must exist", countSpillFiles(queryDir) > 0);
        Path spillDir = createTempDir();
        // The only spill file(s) must belong to stage 0 (key prefix "0-"), never stage 9 ("9-").
                assertEquals((byte) (seen + 1), it.next()[0]);
     */
     * resulting isolation.
            int seen = 0;
