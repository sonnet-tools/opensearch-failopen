        private int nextKey = 1;
 * <p>All callbacks now receive a {@code contextId} as their first argument.
        @Override  
    public void testUnregisteredContextIdAsserts() {  
            @Override  
import java.lang.foreign.MemorySegment;
            public void releaseProvider(int providerKey) {}
        }
        assertEquals("handle received providerKey for release", providerKey, handle.lastReleasedProviderKey);
package org.opensearch.be.datafusion.indexfilter;
            }
        }
 * Tests use {@code contextId=0} via {@link FilterTreeCallbacks#register}.
        // createCollector  
            }
            public int createProvider(int annotationId) {
        int providerKey = FilterTreeCallbacks.createProvider(CTX, 42);
            for (int i = 0; i < wordCount; i++) {  
import org.opensearch.analytics.spi.FilterDelegationHandle;
 */  
     */
        FilterTreeCallbacks.register(CTX, failingHandle, null);
        @Override
 * SPDX-License-Identifier: Apache-2.0
                return -1;
        }  
    @Override
        }  
                MemorySegment buf = arena.allocate(Long.BYTES);  
            this.lastWriterGeneration = writerGeneration;
                FilterTreeCallbacks.collectDocs(CTX, 1, 0, 64, buf, 1);
        });  
            return nextKey++;
    public void testFullRoundTrip() {
        assertEquals("handle received minDoc", 0, handle.lastMinDoc);
            return nextKey++;
            MemorySegment buf = arena.allocate(Long.BYTES);  
            int wordCount = Math.min(cannedWords.length, (int) (out.byteSize() / Long.BYTES));
        // createProvider
        public long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out) {  
}
            this.lastReleasedCollectorKey = collectorKey;
        @Override
        FilterTreeCallbacks.releaseProvider(CTX, providerKey);
 *  
    private static final class MockHandle implements FilterDelegationHandle {  
        assertTrue("providerKey >= 0", providerKey >= 0);  
        FilterTreeCallbacks.register(CTX, handle, null);
        try (Arena arena = Arena.ofConfined()) {
            }
        MockHandle handle = new MockHandle(cannedWords);
        }
 * routing to a {@link FilterDelegationHandle} without going through the full
            public long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out) {  
        long[] cannedWords = new long[] { 0x5L, 0x3L };  
    }  
     * bug signal: bindings stay alive until the last native handle is released.
        };  
        int lastAnnotationId = -1;
     * {@code assert binding != null}. With {@code -ea} on (test default), this throws
        @Override
        int lastCollectorKey = -1;  
    @Override
            this.lastReleasedProviderKey = providerKey;
import org.opensearch.test.OpenSearchTestCase;
            this.lastMaxDoc = maxDoc;
            assertEquals(-1L, FilterTreeCallbacks.collectDocs(CTX, 1, 0, 64, buf, 1));
            return wordCount;  
     * or premature-teardown bugs. Under the refcounted lifecycle this is a genuine  
        assertEquals(-1, FilterTreeCallbacks.createProvider(CTX, 1));  
/**
        public int createProvider(int annotationId) {  
    }  
            assertEquals(0x5L, buf.getAtIndex(ValueLayout.JAVA_LONG, 0));
        FilterTreeCallbacks.unregister(CTX);
    }  
 * compatible open source license.
        assertEquals("handle received collectorKey for release", collectorKey, handle.lastReleasedCollectorKey);
        // releaseCollector
 */  
            assertEquals("wordsWritten matches canned length", 2L, wordsWritten);  
            try (Arena arena = Arena.ofConfined()) {
        int lastReleasedCollectorKey = -1;
        @Override
        private final long[] cannedWords;
        assertEquals("handle received maxDoc", 128, handle.lastMaxDoc);  
        }  
            @Override
            long wordsWritten = FilterTreeCallbacks.collectDocs(CTX, collectorKey, 0, 128, buf, 2);
            this.cannedWords = cannedWords;
            @Override
    /**
            @Override
public class IndexFilterCallbackTests extends OpenSearchTestCase {
    public void tearDown() throws Exception {  
     * Lifecycle assertion: invoking an upcall on an unregistered contextId trips  
            public void close() {}
        public int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {  
                return -1;
    public void setUp() throws Exception {  
 * substrait → native pipeline.
        int lastMinDoc = -1;
        int lastMaxDoc = -1;
        }  
 * Tests the Java-side FFM callback dispatch via {@link FilterTreeCallbacks}  
            @Override
        // collectDocs
    }  
import java.lang.foreign.Arena;
        expectThrows(AssertionError.class, () -> {
        FilterDelegationHandle failingHandle = new FilterDelegationHandle() {  
    private static final long CTX = 0L;  
            public int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {
 * The OpenSearch Contributors require contributions made to  
        MockHandle(long[] cannedWords) {
            this.lastCollectorKey = collectorKey;
        public void releaseProvider(int providerKey) {  
        assertTrue("collectorKey >= 0", collectorKey >= 0);
        expectThrows(AssertionError.class, () -> FilterTreeCallbacks.releaseProvider(CTX, Integer.MAX_VALUE));
        try (Arena arena = Arena.ofConfined()) {  
        FilterTreeCallbacks.releaseCollector(CTX, collectorKey);  
        long lastWriterGeneration = -1L;  
    /** Mock handle that records arguments and returns canned bitset words. */
                return -1;  
            assertEquals(0x3L, buf.getAtIndex(ValueLayout.JAVA_LONG, 1));
        @Override
            public void releaseCollector(int collectorKey) {}
/*  
    }  
            }
        assertEquals("handle received providerKey", providerKey, handle.lastProviderKey);  
        int collectorKey = FilterTreeCallbacks.createCollector(CTX, providerKey, 2L, 0, 128);
        public void close() {}
        public void releaseCollector(int collectorKey) {
 *
        FilterTreeCallbacks.unregister(CTX);
            this.lastMinDoc = minDoc;  
        int lastProviderKey = -1;
        expectThrows(AssertionError.class, () -> FilterTreeCallbacks.releaseCollector(CTX, Integer.MAX_VALUE));
        expectThrows(AssertionError.class, () -> FilterTreeCallbacks.createCollector(CTX, 1, 0L, 0, 64));  
                out.setAtIndex(ValueLayout.JAVA_LONG, i, cannedWords[i]);
        FilterTreeCallbacks.unregister(CTX);
        assertEquals(-1, FilterTreeCallbacks.createCollector(CTX, 1, 0L, 0, 64));
    }  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("handle received annotationId", 42, handle.lastAnnotationId);
import java.lang.foreign.ValueLayout;  
            @Override
        int lastReleasedProviderKey = -1;
            this.lastAnnotationId = annotationId;
        // releaseProvider  
        assertEquals("handle received writerGeneration", 2L, handle.lastWriterGeneration);
    public void testHandleReturningNegativeOnePropagates() {
            }  
        expectThrows(AssertionError.class, () -> FilterTreeCallbacks.createProvider(CTX, 1));
            MemorySegment buf = arena.allocate(Long.BYTES * 2);
            this.lastProviderKey = providerKey;
        }  
     * AssertionError rather than silently returning -1 — surfacing missing-register
        super.tearDown();
        super.setUp();
