        ReaderContext created = store.createContext("q1", SHARD_0, mockGatedReader(closed));  
        ReaderContextStore store = new ReaderContextStore(threadPool, 1); // 1ms keepAlive
    }  
        store.releaseContext("q1", SHARD_0);  
import org.opensearch.core.index.shard.ShardId;  
        // Acquire for fetch phase
        // Cleanup
        GatedCloseable<Reader> gated = mockGatedReader(closed);
/*  
        store.releaseContext("q1", SHARD_0);
     */  
    public void testFreeContextDefersCloseUntilLastPhaseDone() {
        terminate(threadPool);
        assertSame(created.getReader(), acquired.getReader());
        store.freeContext("q1", SHARD_0);  
        // Release from query phase
     */
 * The OpenSearch Contributors require contributions made to  
    private static final ShardId SHARD_1 = new ShardId(new Index("idx", "uuid"), 1);
        assertEquals(0, store.activeCount());  
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
        // Fetch fails: release this acquire, then free the base ref (mirrors drainFetchByRowIds error paths).
        ReaderContextStore store = new ReaderContextStore(threadPool);  
        assertTrue("Reader closed once the last phase finishes", closed.get());
        assertNotNull(fetchCtx);
    public void testQueryThenFetchLifecycle() {
     * Query and fetch hold the context at the same time; the reaper must wait for both to finish
        store.releaseContext("q1", SHARD_0);  
        assertSame(ctx.getReader(), fetchCtx.getReader());  
}
        assertNotNull(ctx);
        store.freeContext("q1", SHARD_0);
    public void testCreateAndAcquireContext() {
        store.releaseContext("q1", SHARD_0);  
    }
    }  
        assertEquals(1, store.activeCount());
    }  
        ctx.markDone();
        assertEquals(1, store.activeCount());  
        assertBusy(() -> {  
            assertEquals(0, store.activeCount());
     */
    }  
        AtomicBoolean closed = new AtomicBoolean(false);
     * the close is deferred until that phase finishes.
    public void testReaperClosesContextAfterQueryPhaseFailure() throws Exception {  
    public void testAcquireWhileInUseSucceeds() {
     * A query-phase failure releases the query's use-reference but leaves the context registered;  
        store.releaseContext("q2", SHARD_1);
        ReaderContextStore store = new ReaderContextStore(threadPool, 50); // 50ms keepAlive
 */  
        assertFalse("Reader stays open between phases", closed.get());
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
        AtomicBoolean closed = new AtomicBoolean(false);
        ReaderContextStore store = new ReaderContextStore(threadPool);  
        assertTrue("Reader should be closed after freeContext", closed.get());  
        // Fetch done: free
        assertBusy(() -> {  
            assertTrue("Reader closed once both phases released", closed.get());
        store.freeContext("q1", SHARD_0);
        assertTrue("Reader should be closed after releaseAndFree", closed.get());
        assertTrue(closed2.get());
        store.releaseContext("q1", SHARD_0);
        ReaderContext fetchCtx = store.acquireContext("q1", SHARD_0);
        store.releaseContext("q1", SHARD_0);                         // query done
    }  
import org.opensearch.core.index.Index;
package org.opensearch.analytics.exec;
        store.createContext("q2", SHARD_1, mockGatedReader(closed2));
    public void testReaperDoesNotCleanInUseContext() throws Exception {  
        store.releaseContext("q1", SHARD_0);
    public void testReleaseAndFreeClosesReaderInUse() {
        AtomicBoolean closed = new AtomicBoolean(false);
        store.freeContext("q1", SHARD_0);
        threadPool = new TestThreadPool(getTestName());
        ReaderContextStore store = new ReaderContextStore(threadPool);  
    }
    }
        // createContext leaves the context in-use (refcount = base + this phase). releaseAndFree
        store.releaseContext("q1", SHARD_0);  
        ReaderContextStore store = new ReaderContextStore(threadPool);
        assertNotNull("Should acquire even while query phase still in-use", acquired);  
        });  
     */
import java.util.concurrent.atomic.AtomicBoolean;  
        assertFalse("Reader must stay open while a phase is still using the context", closed.get());
            assertTrue("Reader should be closed by reaper", closed.get());
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;
        assertEquals(2, store.activeCount());
        assertNotNull("Should acquire for fetch", fetched);
        // Query finishes, fetch still running: reader must stay open past keepAlive.
        ReaderContext ctx = store.createContext("q1", SHARD_0, gated);  
        ReaderContextStore store = new ReaderContextStore(threadPool, 1); // 1ms keepAlive
        AtomicBoolean closed = new AtomicBoolean(false);  
        assertSame(ctx.getReader(), fetched.getReader());
        });
 *
    /**
        Reader reader = mock(Reader.class);  
    }
        assertNotNull("Fetch must acquire while query still in-use", store.acquireContext("q1", SHARD_0));
        assertTrue("Reader closed after fetch", closed.get());
 * this file be licensed under the Apache-2.0 license or a
        super.tearDown();
    @Override
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
        assertTrue("Reader must be closed immediately on fetch-phase failure", closed.get());  
     * the reader immediately rather than leaking it to the reaper.
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
        store.releaseContext("q1", SHARD_0);
    }
        // Query phase started (createContext marks in-use), then failed -> release without fetch.
        store.releaseAndFree("q1", SHARD_0);
        ReaderContextStore store = new ReaderContextStore(threadPool, 50); // 50ms keepAlive  
        AtomicBoolean closed = new AtomicBoolean(false);
        // Query in use; fetch acquires while query is still in use.  
    public void testFreeContextRemovesFromStore() {
        assertEquals(1, store.activeCount());  
            assertTrue("Reaper must close the reader after a query-phase failure", closed.get());  
        Thread.sleep(50);  
        assertEquals(1, store.activeCount());  
        fetchCtx.markDone();  
        return new GatedCloseable<>(reader, () -> closedFlag.set(true));
        assertBusy(() -> {
        assertFalse("Reaper should not close in-use context", closed.get());
        // Fetch finishes: now reapable.
        ReaderContext ctx = store.createContext("q1", SHARD_0, mockGatedReader(closed));
    }  
        store.freeContext("q1", SHARD_0);
        AtomicBoolean closed = new AtomicBoolean(false);
        store.releaseContext("q1", SHARD_0);
    }
import org.opensearch.threadpool.TestThreadPool;  
public class ReaderContextStoreTests extends OpenSearchTestCase {
        assertTrue(closed1.get());
    }  
        AtomicBoolean closed = new AtomicBoolean(false);
        store.releaseContext("q1", SHARD_0);  
        store.releaseContext("q1", SHARD_0);  
        Thread.sleep(50);
    }
        assertFalse("Reader must stay open while fetch still in-use", closed.get());
        assertEquals("Context removed from store on free", 0, store.activeCount());
     * Freeing a context while a phase is still using it must not close the reader immediately;
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
        ReaderContextStore store = new ReaderContextStore(threadPool);
        ReaderContextStore store = new ReaderContextStore(threadPool);  
    /**  
        store.createContext("q1", SHARD_0, mockGatedReader(closed));  
            assertEquals(0, store.activeCount());
 * SPDX-License-Identifier: Apache-2.0
        AtomicBoolean closed = new AtomicBoolean(false);  
        ReaderContextStore store = new ReaderContextStore(threadPool);
    @Override
        store.createContext("q1", SHARD_0, mockGatedReader(closed1));  
 * compatible open source license.
        // must drop both refs and close the reader in one call.  
        store.freeContext("q2", SHARD_1);
        AtomicBoolean closed = new AtomicBoolean(false);
        store.createContext("q1", SHARD_0, mockGatedReader(closed)); // query phase
        // Query done
        // Already in use by the query phase; the fetch phase must still be able to acquire it.
    private static final ShardId SHARD_0 = new ShardId(new Index("idx", "uuid"), 0);  
        // Still in-use (not released)
            assertEquals(0, store.activeCount());
        assertEquals(0, store.activeCount());
        AtomicBoolean closed = new AtomicBoolean(false);
        // Wait for expiry + reaper cycle
        assertNull(store.acquireContext("no-such-query", SHARD_0));
        AtomicBoolean closed = new AtomicBoolean(false);  
     * before closing the reader, even with a tiny keepAlive.  
        ReaderContext acquired = store.acquireContext("q1", SHARD_0);
        store.releaseContext("q1", SHARD_0);  
    }
        ReaderContextStore store = new ReaderContextStore(threadPool);  
import static org.mockito.Mockito.mock;
    public void testReaperCleansExpiredContexts() throws Exception {
        AtomicBoolean closed2 = new AtomicBoolean(false);  
     * the refcount returns to the base ref, so the reaper closes it once keepAlive elapses.
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(closed2.get());
        assertNotNull(store.acquireContext("q1", SHARD_0));  
    }  
        ReaderContextStore store = new ReaderContextStore(threadPool);  
        AtomicBoolean closed = new AtomicBoolean(false);
        store.freeContext("q1", SHARD_0);
        store.createContext("q1", SHARD_0, mockGatedReader(closed));  
        ReaderContextStore store = new ReaderContextStore(threadPool);
        assertNull("Should not find after free", store.getContext("q1", SHARD_0));
        assertEquals(0, store.activeCount());
        store.freeContext("q1", SHARD_0);
        AtomicBoolean closed1 = new AtomicBoolean(false);
    private GatedCloseable<Reader> mockGatedReader(AtomicBoolean closedFlag) {
    public void setUp() throws Exception {  
        // Fetch phase: acquire + use  
        // Query phase: create + use
    public void testFetchPhaseFailureFreesReaderImmediately() {  
    public void testMultipleContexts() {
        assertNotNull(store.acquireContext("q1", SHARD_0));          // fetch acquires  
        super.setUp();
    public void testAcquireNonExistentReturnsNull() {
        assertNotNull(ctx.getReader());  
    /**
        });  
        assertEquals(0, store.activeCount());
    public void testReaperWaitsForOverlappingQueryAndFetch() throws Exception {
    public void testFreeContextClosesReader() {
        ReaderContext ctx = store.getContext("q1", SHARD_0);
        ReaderContext fetched = store.acquireContext("q1", SHARD_0);  
     * A fetch-phase failure that releases both the fetch and the base reference (eager free) closes  
import org.opensearch.common.concurrent.GatedCloseable;
        store.createContext("q1", SHARD_0, mockGatedReader(closed));
    /**
        assertNotNull(ctx);
    private ThreadPool threadPool;  
    }
import org.opensearch.threadpool.ThreadPool;
    public void tearDown() throws Exception {  
