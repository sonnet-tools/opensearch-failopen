        assertSame(created.getReader(), acquired.getReader());
        assertNotNull(ctx.getReader());
        ReaderContextStore store = new ReaderContextStore(threadPool, 50); // 50ms keepAlive
        ReaderContextStore store = new ReaderContextStore(threadPool);
        ReaderContext acquired = store.acquireContext("q1", SHARD_0);
        assertTrue(closed1.get());
public class ReaderContextStoreTests extends OpenSearchTestCase {
        assertNull("Should not find after free", store.getContext("q1", SHARD_0));
    @Override
     * the refcount returns to the base ref, so the reaper closes it once keepAlive elapses.
    public void tearDown() throws Exception {
    }
        ReaderContext created = store.createContext("q1", SHARD_0, mockGatedReader(closed));
        store.createContext("q1", SHARD_0, mockGatedReader(closed1));
    }
    }
        assertEquals(2, store.activeCount());
        ctx.markDone();
 * compatible open source license.
        // Fetch done: free
        ReaderContextStore store = new ReaderContextStore(threadPool);
        threadPool = new TestThreadPool(getTestName());
        assertEquals(0, store.activeCount());
        Thread.sleep(50);
        assertBusy(() -> {
     * before closing the reader, even with a tiny keepAlive.
        assertEquals(0, store.activeCount());
        assertNotNull(store.acquireContext("q1", SHARD_0));          // fetch acquires
        // Fetch fails: release this acquire, then free the base ref (mirrors drainFetchByRowIds error paths).
        store.releaseAndFree("q1", SHARD_0);
        assertTrue("Reader should be closed after releaseAndFree", closed.get());
        });
    }
        store.releaseContext("q1", SHARD_0);
     * the reader immediately rather than leaking it to the reaper.
    private GatedCloseable<Reader> mockGatedReader(AtomicBoolean closedFlag) {
        store.createContext("q1", SHARD_0, mockGatedReader(closed)); // query phase
        // Fetch finishes: now reapable.
    public void testQueryThenFetchLifecycle() {
import org.opensearch.threadpool.ThreadPool;
     * Freeing a context while a phase is still using it must not close the reader immediately;
 *
    public void setUp() throws Exception {
        assertNotNull(fetchCtx);
        assertFalse("Reader must stay open while fetch still in-use", closed.get());
        // Query in use; fetch acquires while query is still in use.
        return new GatedCloseable<>(reader, () -> closedFlag.set(true));
        // Wait for expiry + reaper cycle
    private static final ShardId SHARD_0 = new ShardId(new Index("idx", "uuid"), 0);
            assertEquals(0, store.activeCount());
    }
            assertTrue("Reader closed once both phases released", closed.get());
        assertFalse("Reader stays open between phases", closed.get());
     * Query and fetch hold the context at the same time; the reaper must wait for both to finish
        assertEquals(1, store.activeCount());
        AtomicBoolean closed = new AtomicBoolean(false);
    public void testFreeContextRemovesFromStore() {
 */
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
        // createContext leaves the context in-use (refcount = base + this phase). releaseAndFree
        // Query finishes, fetch still running: reader must stay open past keepAlive.
    }
        store.createContext("q2", SHARD_1, mockGatedReader(closed2));
import org.opensearch.core.index.shard.ShardId;
    private ThreadPool threadPool;
    public void testFreeContextClosesReader() {
        assertTrue("Reader closed after fetch", closed.get());
        assertNotNull("Fetch must acquire while query still in-use", store.acquireContext("q1", SHARD_0));
import java.util.concurrent.atomic.AtomicBoolean;
        assertFalse("Reader must stay open while a phase is still using the context", closed.get());
    /**
import org.opensearch.core.index.Index;
        store.releaseContext("q1", SHARD_0);
 * SPDX-License-Identifier: Apache-2.0
        // Query phase started (createContext marks in-use), then failed -> release without fetch.
        assertEquals(0, store.activeCount());
        assertTrue(closed2.get());
        assertNotNull(store.acquireContext("q1", SHARD_0));
        assertSame(ctx.getReader(), fetched.getReader());
        AtomicBoolean closed = new AtomicBoolean(false);
    }
import static org.mockito.Mockito.mock;
            assertTrue("Reader should be closed by reaper", closed.get());
        ReaderContext fetchCtx = store.acquireContext("q1", SHARD_0);
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
        // Query done
        store.releaseContext("q1", SHARD_0);
        assertTrue("Reader should be closed after freeContext", closed.get());
            assertEquals(0, store.activeCount());
    }
        store.releaseContext("q2", SHARD_1);
    @Override
        ReaderContextStore store = new ReaderContextStore(threadPool);
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
 * this file be licensed under the Apache-2.0 license or a
        store.releaseContext("q1", SHARD_0);
        assertTrue("Reader must be closed immediately on fetch-phase failure", closed.get());
        ReaderContextStore store = new ReaderContextStore(threadPool);
        store.freeContext("q1", SHARD_0);
        assertEquals(1, store.activeCount());
        AtomicBoolean closed1 = new AtomicBoolean(false);
        ReaderContext ctx = store.getContext("q1", SHARD_0);
        super.setUp();
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
        // Release from query phase
}
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;
        store.releaseContext("q1", SHARD_0);
        assertEquals(0, store.activeCount());
     */
    public void testReaperCleansExpiredContexts() throws Exception {
        store.releaseContext("q1", SHARD_0);
        store.releaseContext("q1", SHARD_0);
    public void testMultipleContexts() {
        AtomicBoolean closed = new AtomicBoolean(false);
     */
import org.opensearch.common.concurrent.GatedCloseable;
        AtomicBoolean closed = new AtomicBoolean(false);
     */
        store.freeContext("q1", SHARD_0);
        store.freeContext("q2", SHARD_1);
    /**
    public void testReaperClosesContextAfterQueryPhaseFailure() throws Exception {
    }
        store.freeContext("q1", SHARD_0);
     * the close is deferred until that phase finishes.
        AtomicBoolean closed = new AtomicBoolean(false);
        assertNotNull("Should acquire even while query phase still in-use", acquired);
    public void testFreeContextDefersCloseUntilLastPhaseDone() {
        ReaderContext ctx = store.createContext("q1", SHARD_0, mockGatedReader(closed));
 * The OpenSearch Contributors require contributions made to
        assertNotNull("Should acquire for fetch", fetched);
    }
    public void testCreateAndAcquireContext() {
        store.releaseContext("q1", SHARD_0);
            assertTrue("Reaper must close the reader after a query-phase failure", closed.get());
        AtomicBoolean closed = new AtomicBoolean(false);
     */
        ReaderContext fetched = store.acquireContext("q1", SHARD_0);
        ReaderContextStore store = new ReaderContextStore(threadPool);
        assertEquals(1, store.activeCount());
        ReaderContextStore store = new ReaderContextStore(threadPool);
        // Still in-use (not released)
    }
        // Fetch phase: acquire + use
        AtomicBoolean closed = new AtomicBoolean(false);
        AtomicBoolean closed = new AtomicBoolean(false);
        assertFalse(closed2.get());
            assertEquals(0, store.activeCount());
        store.freeContext("q1", SHARD_0);
        store.releaseContext("q1", SHARD_0);
        AtomicBoolean closed = new AtomicBoolean(false);
package org.opensearch.analytics.exec;
    }
    public void testFetchPhaseFailureFreesReaderImmediately() {
        store.freeContext("q1", SHARD_0);
        AtomicBoolean closed2 = new AtomicBoolean(false);
    public void testAcquireNonExistentReturnsNull() {
        store.freeContext("q1", SHARD_0);
/*
        assertNull(store.acquireContext("no-such-query", SHARD_0));
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
import org.opensearch.threadpool.TestThreadPool;
        ReaderContextStore store = new ReaderContextStore(threadPool);
        assertSame(ctx.getReader(), fetchCtx.getReader());
    }
        ReaderContextStore store = new ReaderContextStore(threadPool, 1); // 1ms keepAlive
        super.tearDown();
    /**
        terminate(threadPool);
        });
        // Query phase: create + use
    public void testReaperWaitsForOverlappingQueryAndFetch() throws Exception {
        store.releaseContext("q1", SHARD_0);
        AtomicBoolean closed = new AtomicBoolean(false);
    }
        // Acquire for fetch phase
        assertEquals(1, store.activeCount());
        ReaderContextStore store = new ReaderContextStore(threadPool);
        Reader reader = mock(Reader.class);
        assertTrue("Reader closed once the last phase finishes", closed.get());
        ReaderContext ctx = store.createContext("q1", SHARD_0, gated);
        AtomicBoolean closed = new AtomicBoolean(false);
        ReaderContextStore store = new ReaderContextStore(threadPool);
        store.releaseContext("q1", SHARD_0);
        assertEquals("Context removed from store on free", 0, store.activeCount());
        // must drop both refs and close the reader in one call.
        assertNotNull(ctx);
        // Already in use by the query phase; the fetch phase must still be able to acquire it.
    }
        fetchCtx.markDone();
        store.freeContext("q1", SHARD_0);
     * A fetch-phase failure that releases both the fetch and the base reference (eager free) closes
        GatedCloseable<Reader> gated = mockGatedReader(closed);
        ReaderContextStore store = new ReaderContextStore(threadPool, 1); // 1ms keepAlive
    }
        AtomicBoolean closed = new AtomicBoolean(false);
        store.releaseContext("q1", SHARD_0);
        store.releaseContext("q1", SHARD_0);                         // query done
     * A query-phase failure releases the query's use-reference but leaves the context registered;
        assertNotNull(ctx);
        // Cleanup
    public void testReleaseAndFreeClosesReaderInUse() {
    }
        });
        assertBusy(() -> {
        assertFalse("Reaper should not close in-use context", closed.get());
import org.opensearch.test.OpenSearchTestCase;
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
    private static final ShardId SHARD_1 = new ShardId(new Index("idx", "uuid"), 1);
        ReaderContextStore store = new ReaderContextStore(threadPool);
        Thread.sleep(50);
    public void testReaperDoesNotCleanInUseContext() throws Exception {
    /**
        ReaderContextStore store = new ReaderContextStore(threadPool, 50); // 50ms keepAlive
        assertBusy(() -> {
    public void testAcquireWhileInUseSucceeds() {
