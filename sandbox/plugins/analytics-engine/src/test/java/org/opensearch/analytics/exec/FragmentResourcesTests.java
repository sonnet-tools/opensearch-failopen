        AtomicBoolean closed = new AtomicBoolean(false);
        super.tearDown();
 *
        return new GatedCloseable<>(reader, () -> closedFlag.set(true));
    }  
            // expected  
        AtomicBoolean closed = new AtomicBoolean(false);  
        assertTrue("Reader must be closed after a non-QTF query error", closed.get());  
}  
        assertEquals("Context must remain in the store", 1, store.activeCount());
 * Verifies how {@link FragmentResources#close()} disposes of the reader context depending on
    public void testRequestsRowIdsDetectsQtfVsNormal() {
        terminate(threadPool);
    }  
        super.setUp();
import org.opensearch.analytics.spi.ShardScanInstructionNode;
        Reader reader = mock(Reader.class);  
 * The OpenSearch Contributors require contributions made to  
    }  
        new FragmentResources(store, ctx, null, null, null, false).close();  
    @Override
        ReaderContext ctx = store.createContext("q1", SHARD_0, mockGatedReader(closed));
        assertFalse(  
        ReaderContext ctx = store.createContext("q1", SHARD_0, mockGatedReader(closed));
        ReaderContextStore store = new ReaderContextStore(threadPool);  
import java.util.concurrent.atomic.AtomicBoolean;  
        new FragmentResources(store, ctx, null, null, null, false).close(); // requiresTopDocs=false  
    }
import org.opensearch.threadpool.ThreadPool;  
    public void tearDown() throws Exception {  
    private GatedCloseable<Reader> mockGatedReader(AtomicBoolean closedFlag) {
    }
import org.opensearch.core.index.Index;
public class FragmentResourcesTests extends OpenSearchTestCase {
    public void testRequiresTopDocsKeepsReaderForFetch() throws Exception {  
        AtomicBoolean closed = new AtomicBoolean(false);
    public void setUp() throws Exception {  
 */  
        // Fetch reuses then frees it (terminal phase, requiresTopDocs=false).
        } catch (RuntimeException expected) {
        // Non-QTF query (requiresTopDocs=false) whose stream throws while draining: try-with-resources
    }
    }
import org.opensearch.threadpool.TestThreadPool;
package org.opensearch.analytics.exec;
        assertEquals(0, store.activeCount());
            AnalyticsSearchService.requestsRowIds(List.of(new ShardScanInstructionNode(false)))
        assertNotNull(store.acquireContext("q1", SHARD_0));
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;  
import org.opensearch.test.OpenSearchTestCase;
        ReaderContext ctx = store.createContext("q1", SHARD_0, mockGatedReader(closed));  
        // still runs close(), which must free the reader rather than leak it to the reaper.
        }
 * this file be licensed under the Apache-2.0 license or a
/**
        );  
    private ThreadPool threadPool;  
/*  
import org.opensearch.core.index.shard.ShardId;
 * whether the reader is single-session (freed eagerly) or multi-session (kept for the fetch).  
    @Override
        threadPool = new TestThreadPool(getTestName());
import org.opensearch.common.concurrent.GatedCloseable;  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Reader with no following fetch must be closed on close()", closed.get());
    public void testNoFetchClosesReaderEagerly() throws Exception {
        assertFalse("Reader must stay open for the following fetch phase", closed.get());
        assertTrue("Reader closed once the terminal fetch frees it", closed.get());
            throw new RuntimeException("simulated query-phase failure");
        ReaderContextStore store = new ReaderContextStore(threadPool);
 * compatible open source license.
        assertEquals("Context must be removed from the store", 0, store.activeCount());
            "Normal scan does not request row ids",
        assertTrue("QTF scan requests row ids", AnalyticsSearchService.requestsRowIds(List.of(new ShardScanInstructionNode(true))));
        assertFalse("No scan node means no row ids", AnalyticsSearchService.requestsRowIds(List.<InstructionNode>of()));
    private static final ShardId SHARD_0 = new ShardId(new Index("idx", "uuid"), 0);
import java.util.List;
        assertEquals("Context must be removed from the store", 0, store.activeCount());  
    public void testNonQtfQueryErrorClosesReader() throws Exception {
 */
        new FragmentResources(store, ctx, null, null, null, true).close(); // requiresTopDocs=true
import static org.mockito.Mockito.mock;
        ReaderContextStore store = new ReaderContextStore(threadPool);
        try (FragmentResources resources = new FragmentResources(store, ctx, null, null, null, false)) {  
import org.opensearch.analytics.spi.InstructionNode;
