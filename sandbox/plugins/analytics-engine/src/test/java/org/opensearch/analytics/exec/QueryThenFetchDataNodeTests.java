import org.opensearch.test.OpenSearchTestCase;
    /**
        store.releaseContext("q2", SHARD_0);  
        // Simulate fetch phase: acquire the same context
        // Simulate "query failure": release the context without explicit cleanup
        GatedCloseable<Reader> gatedReader = mockGatedReader(closed);  
        assertTrue("Reader must be closed after completeFetch", closed.get());  
     */  
        ReaderContext fetchCtx = store.acquireContext("query-3", SHARD_0);
        assertNotNull(fetchCtx);
    public void testFetchWithExpiredContext() throws Exception {
        super.setUp();
import static org.mockito.Mockito.mock;
     * Verify reader's close callback is NOT invoked between query and fetch phases.  
     */
     * available for potential fetch. The reaper cleans it if fetch never arrives.  
        fetch1.markDone();  
        assertEquals(1, store.activeCount());
        assertNotNull(ctx);  
        // Query phase done
        fetch2.markDone();
     */
        assertFalse("Reader must remain open while awaiting fetch", closed.get());
    }
        ReaderContext fetch1 = store.acquireContext("q1", SHARD_0);  
        store.createContext("q1", SHARD_0, gated1);  
    /**
        store.freeContext("query-2", SHARD_0);  
        assertEquals(0, store.activeCount());
    }  
        // Fetch q1
        // Query phase completes, release context (reader stays alive for fetch)  
import org.opensearch.core.index.shard.ShardId;  
 * fetch phase reuses the same reader, and context is freed after fetch.  
        // Context still exists immediately after failure
        // Simulate query phase: acquire reader and store in context
        assertEquals(2, store.activeCount());
        store.freeContext("query-1", SHARD_0);
        ReaderContextStore store = new ReaderContextStore(threadPool);
        });  
    }
import org.opensearch.core.index.Index;
        Reader originalReader = gatedReader.get();
    public void testReaderClosedAfterCompleteFetch() {  
        ReaderContextStore store = new ReaderContextStore(threadPool);  
        ReaderContext fetchCtx = store.acquireContext("query-1", SHARD_0);
        assertEquals(0, store.activeCount());
public class QueryThenFetchDataNodeTests extends OpenSearchTestCase {
        assertSame(reader1, fetch1.getReader());
        assertSame("Fetch must get the SAME reader instance", originalReader, fetchCtx.getReader());
        ReaderContextStore store = new ReaderContextStore(threadPool, 50); // short keepAlive for reaper test
        ReaderContext fetch2 = store.acquireContext("q2", SHARD_0);
        store.createContext("query-2", SHARD_0, mockGatedReader(closed));  
        return new GatedCloseable<>(reader, () -> closedFlag.set(true));
        fetchCtx.markDone();  
package org.opensearch.analytics.exec;
        assertNotNull("Context survives query failure for potential fetch", fetchCtx);
import org.opensearch.common.concurrent.GatedCloseable;
        store.releaseContext("query-failed", SHARD_0);  
    }  
        assertTrue("q1 reader closed", closed1.get());
            assertEquals(0, store.activeCount());
        // Cleanup
        assertFalse("Reader must not be closed between phases", closed.get());
        threadPool = new TestThreadPool(getTestName());
 * The OpenSearch Contributors require contributions made to  
        store.freeContext("q2", SHARD_0);
    }  
        ReaderContext fetchCtx = store.acquireContext("query-expired", SHARD_0);  
        AtomicBoolean closed = new AtomicBoolean(false);
    public void tearDown() throws Exception {  
    /**  
        store.releaseContext("q1", SHARD_0);
        ReaderContext ctx = store.acquireContext("nonexistent-query", SHARD_0);
    /**
        assertNotSame("Different queries must have different readers", reader1, reader2);  
    /**
        AtomicBoolean closed1 = new AtomicBoolean(false);  
        // Fetch arrives too late
 * Tests the full data-node QTF lifecycle: query phase stores reader in context,
        super.tearDown();
     * Multiple queries have independent contexts with different readers and independent lifecycles.  
        assertTrue("q2 reader closed", closed2.get());  
        // Free q1 while q2 still alive
    private ThreadPool threadPool;  
    }
        // If fetch never comes, reaper eventually cleans up
     * Even if query "fails" (we just release without a successful result), the context remains
    @Override
     * Verify reader's close callback IS invoked after completeFetch (freeContext).
import java.util.concurrent.atomic.AtomicBoolean;  
        fetchCtx.markDone();  
 */  
    public void testFetchWithoutPriorQuery() {
        assertNull("Expired context must not be acquirable", fetchCtx);
        ReaderContextStore store = new ReaderContextStore(threadPool, 50); // 50ms keepAlive  
        ReaderContextStore store = new ReaderContextStore(threadPool);
 * this file be licensed under the Apache-2.0 license or a
        // Simulate completeFetch
        GatedCloseable<Reader> gated1 = mockGatedReader(closed1);
        assertFalse("q2 reader still alive", closed2.get());  
        assertFalse("Reader must not be closed during fetch", closed.get());  
        assertBusy(() -> {  
    public void setUp() throws Exception {  
import org.opensearch.threadpool.TestThreadPool;  
        ReaderContextStore store = new ReaderContextStore(threadPool);
        assertNotNull("Fetch phase must find the context", fetchCtx);  
        // Release both query phases
 *
     * Fetch for an unknown queryId returns null (no prior query phase).
    }  
        assertEquals(1, store.activeCount());  
}  
     * Fetch arrives after the keep-alive expires and reaper cleans up -> acquireContext returns null.
     */  
        Reader reader2 = gated2.get();
    public void testQueryContextSurvivesQueryFailure() throws Exception {
     */  
        // Between phases: reader must still be alive
        assertEquals(1, store.activeCount());
        store.createContext("query-failed", SHARD_0, mockGatedReader(closed));  
            assertEquals(0, store.activeCount());  
        fetchCtx.markDone();
 */
        store.freeContext("query-3", SHARD_0);
 * compatible open source license.
        assertTrue("Reader must be closed after freeContext", closed.get());  
    private GatedCloseable<Reader> mockGatedReader(AtomicBoolean closedFlag) {
        assertSame(reader2, fetch2.getReader());  
        terminate(threadPool);
        assertNotNull(fetch2);
        store.createContext("q2", SHARD_0, gated2);
        Reader reader = mock(Reader.class);  
/**
        });
     */
        // Fetch q2  
        assertNull("Unknown queryId must return null", ctx);
        store.releaseContext("query-expired", SHARD_0);  
        // (release again so reaper can reap it)  
        ReaderContext ctx = store.createContext("query-1", SHARD_0, gatedReader);
        ReaderContextStore store = new ReaderContextStore(threadPool);
    private static final ShardId SHARD_0 = new ShardId(new Index("idx", "uuid"), 0);
    public void testFullQueryThenFetchLifecycle() {
        // Wait for reaper to clean up the expired context
/*  
        store.releaseContext("query-3", SHARD_0);
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;
            assertTrue("Reader should be closed by reaper", closed.get());
import org.opensearch.threadpool.ThreadPool;
     */
        // Fetch completes  
        store.releaseContext("query-2", SHARD_0);
    }
        AtomicBoolean closed = new AtomicBoolean(false);  
        store.createContext("query-expired", SHARD_0, mockGatedReader(closed));
        AtomicBoolean closed = new AtomicBoolean(false);
        store.releaseContext("query-1", SHARD_0);
        store.freeContext("q1", SHARD_0);
    /**
            assertTrue("Reaper eventually closes reader", closed.get());
        assertSame(originalReader, ctx.getReader());
        store.createContext("query-3", SHARD_0, mockGatedReader(closed));
        assertFalse("Reader not yet closed", closed.get());  
        AtomicBoolean closed = new AtomicBoolean(false);  
    }
        AtomicBoolean closed2 = new AtomicBoolean(false);
        assertBusy(() -> {
        // A fetch could still arrive in time  
        ReaderContext fetchCtx = store.acquireContext("query-failed", SHARD_0);
        GatedCloseable<Reader> gated2 = mockGatedReader(closed2);
        Reader reader1 = gated1.get();  
        assertNotNull(fetch1);
    public void testReaderNotClosedBetweenPhases() {
     * Happy path: query phase stores reader -> fetch phase gets same reader -> free closes it.
        assertNull("Context must be removed from store", store.getContext("query-3", SHARD_0));
        AtomicBoolean closed = new AtomicBoolean(false);
        assertEquals(0, store.activeCount());
    }
    public void testMultipleQueriesIndependentContexts() {
    @Override
    /**
 * SPDX-License-Identifier: Apache-2.0
