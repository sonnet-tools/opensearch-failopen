        assertNotNull(fetchCtx);
        // Wait for reaper to clean up the expired context
    public void testMultipleQueriesIndependentContexts() {
        assertNotNull("Fetch phase must find the context", fetchCtx);
     * Fetch for an unknown queryId returns null (no prior query phase).
        store.freeContext("query-2", SHARD_0);
            assertEquals(0, store.activeCount());
    public void testFetchWithoutPriorQuery() {
        store.releaseContext("query-1", SHARD_0);
        Reader reader1 = gated1.get();
     * Verify reader's close callback is NOT invoked between query and fetch phases.
     */
import org.opensearch.core.index.shard.ShardId;
        assertNotNull(fetch2);
        assertTrue("Reader must be closed after freeContext", closed.get());
        store.releaseContext("query-expired", SHARD_0);
    public void testFullQueryThenFetchLifecycle() {
        assertSame(reader1, fetch1.getReader());
 * compatible open source license.
        store.createContext("query-2", SHARD_0, mockGatedReader(closed));
        assertEquals(0, store.activeCount());
        assertNotNull("Context survives query failure for potential fetch", fetchCtx);
package org.opensearch.analytics.exec;
            assertEquals(0, store.activeCount());
        // (release again so reaper can reap it)
    }
        ReaderContext ctx = store.acquireContext("nonexistent-query", SHARD_0);
 * Tests the full data-node QTF lifecycle: query phase stores reader in context,
    private ThreadPool threadPool;
        // Cleanup
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, store.activeCount());
        assertFalse("Reader must remain open while awaiting fetch", closed.get());
     */
        assertFalse("q2 reader still alive", closed2.get());
     */
        ReaderContext fetchCtx = store.acquireContext("query-expired", SHARD_0);
import org.opensearch.threadpool.ThreadPool;
    }
    public void testFetchWithExpiredContext() throws Exception {
        assertSame(reader2, fetch2.getReader());
import org.opensearch.threadpool.TestThreadPool;
        assertSame(originalReader, ctx.getReader());
        return new GatedCloseable<>(reader, () -> closedFlag.set(true));
        ReaderContextStore store = new ReaderContextStore(threadPool);
        store.createContext("query-3", SHARD_0, mockGatedReader(closed));
        store.releaseContext("query-3", SHARD_0);
    private GatedCloseable<Reader> mockGatedReader(AtomicBoolean closedFlag) {
        assertEquals(0, store.activeCount());
        ReaderContextStore store = new ReaderContextStore(threadPool);
    }
        store.createContext("q1", SHARD_0, gated1);
    }
     * Even if query "fails" (we just release without a successful result), the context remains
 * fetch phase reuses the same reader, and context is freed after fetch.
        AtomicBoolean closed = new AtomicBoolean(false);
        assertSame("Fetch must get the SAME reader instance", originalReader, fetchCtx.getReader());
    }
    public void tearDown() throws Exception {
        super.setUp();
        // Fetch arrives too late
        ReaderContextStore store = new ReaderContextStore(threadPool);
        assertFalse("Reader not yet closed", closed.get());
import org.opensearch.test.OpenSearchTestCase;
    }
        // Query phase completes, release context (reader stays alive for fetch)
        AtomicBoolean closed = new AtomicBoolean(false);
        });
        AtomicBoolean closed = new AtomicBoolean(false);
        assertEquals(2, store.activeCount());
    /**
    public void testReaderClosedAfterCompleteFetch() {
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;
            assertTrue("Reader should be closed by reaper", closed.get());
        store.releaseContext("q1", SHARD_0);
        assertNull("Unknown queryId must return null", ctx);
        fetchCtx.markDone();
        ReaderContext fetchCtx = store.acquireContext("query-1", SHARD_0);
    /**
    public void testQueryContextSurvivesQueryFailure() throws Exception {
        assertEquals(0, store.activeCount());
     * Multiple queries have independent contexts with different readers and independent lifecycles.
        ReaderContextStore store = new ReaderContextStore(threadPool, 50); // short keepAlive for reaper test
        store.createContext("q2", SHARD_0, gated2);
        AtomicBoolean closed = new AtomicBoolean(false);
    /**
        // Release both query phases
        store.freeContext("q1", SHARD_0);
        assertEquals(1, store.activeCount());
        fetch2.markDone();
     * Fetch arrives after the keep-alive expires and reaper cleans up -> acquireContext returns null.
        assertFalse("Reader must not be closed between phases", closed.get());
        assertNotNull(fetch1);
        // Fetch q2
        // Simulate query phase: acquire reader and store in context
     */
        store.createContext("query-failed", SHARD_0, mockGatedReader(closed));
/*
        GatedCloseable<Reader> gated1 = mockGatedReader(closed1);
        GatedCloseable<Reader> gatedReader = mockGatedReader(closed);
        assertEquals(1, store.activeCount());
        AtomicBoolean closed1 = new AtomicBoolean(false);
        AtomicBoolean closed = new AtomicBoolean(false);
        ReaderContext ctx = store.createContext("query-1", SHARD_0, gatedReader);
        // Fetch completes
        ReaderContext fetchCtx = store.acquireContext("query-failed", SHARD_0);
        ReaderContext fetchCtx = store.acquireContext("query-3", SHARD_0);
        fetch1.markDone();
        fetchCtx.markDone();
     * Happy path: query phase stores reader -> fetch phase gets same reader -> free closes it.
        assertNull("Expired context must not be acquirable", fetchCtx);
 */
        // A fetch could still arrive in time
        // Simulate fetch phase: acquire the same context
        ReaderContextStore store = new ReaderContextStore(threadPool);
    public void testReaderNotClosedBetweenPhases() {
        terminate(threadPool);
        // Simulate "query failure": release the context without explicit cleanup
        assertTrue("Reader must be closed after completeFetch", closed.get());
 * this file be licensed under the Apache-2.0 license or a
        store.freeContext("query-1", SHARD_0);
        // Context still exists immediately after failure
        ReaderContextStore store = new ReaderContextStore(threadPool, 50); // 50ms keepAlive
        store.releaseContext("q2", SHARD_0);
import org.opensearch.common.concurrent.GatedCloseable;
        store.releaseContext("query-failed", SHARD_0);
    /**
import java.util.concurrent.atomic.AtomicBoolean;
        AtomicBoolean closed2 = new AtomicBoolean(false);
        });
    }
        assertTrue("q1 reader closed", closed1.get());
        assertNull("Context must be removed from store", store.getContext("query-3", SHARD_0));
        ReaderContext fetch2 = store.acquireContext("q2", SHARD_0);
     * available for potential fetch. The reaper cleans it if fetch never arrives.
        assertBusy(() -> {
        assertFalse("Reader must not be closed during fetch", closed.get());
        store.freeContext("q2", SHARD_0);
        Reader reader = mock(Reader.class);
    private static final ShardId SHARD_0 = new ShardId(new Index("idx", "uuid"), 0);
     * Verify reader's close callback IS invoked after completeFetch (freeContext).
        Reader reader2 = gated2.get();
}
    }
 *
        assertNotNull(ctx);
    @Override
    public void setUp() throws Exception {
        // If fetch never comes, reaper eventually cleans up
        assertBusy(() -> {
        // Free q1 while q2 still alive
     */
        assertNotSame("Different queries must have different readers", reader1, reader2);
        ReaderContext fetch1 = store.acquireContext("q1", SHARD_0);
 */
        Reader originalReader = gatedReader.get();
     */
 * The OpenSearch Contributors require contributions made to
        store.freeContext("query-3", SHARD_0);
        // Simulate completeFetch
        // Between phases: reader must still be alive
        fetchCtx.markDone();
    }
        // Fetch q1
/**
    }
        ReaderContextStore store = new ReaderContextStore(threadPool);
        threadPool = new TestThreadPool(getTestName());
        store.createContext("query-expired", SHARD_0, mockGatedReader(closed));
        super.tearDown();
    @Override
            assertTrue("Reaper eventually closes reader", closed.get());
        assertTrue("q2 reader closed", closed2.get());
    /**
public class QueryThenFetchDataNodeTests extends OpenSearchTestCase {
    /**
        // Query phase done
import static org.mockito.Mockito.mock;
import org.opensearch.core.index.Index;
        GatedCloseable<Reader> gated2 = mockGatedReader(closed2);
        store.releaseContext("query-2", SHARD_0);
     */
    /**
