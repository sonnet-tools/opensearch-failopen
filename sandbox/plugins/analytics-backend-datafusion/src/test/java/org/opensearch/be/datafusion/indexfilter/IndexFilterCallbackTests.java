            MemorySegment buf = arena.allocate(Long.BYTES);
            }
        FilterDelegationHandle failingHandle = new FilterDelegationHandle() {
            MemorySegment buf = arena.allocate(Long.BYTES * 2);
            return nextKey++;
        @Override
            assertEquals(-1L, FilterTreeCallbacks.collectDocs(CTX, 1, 0, 64, buf, 1));
        expectThrows(AssertionError.class, () -> FilterTreeCallbacks.releaseProvider(CTX, Integer.MAX_VALUE));
            try (Arena arena = Arena.ofConfined()) {
        // releaseCollector
    }
    }
import org.opensearch.test.OpenSearchTestCase;
            return wordCount;
/*
        assertEquals(-1, FilterTreeCallbacks.createCollector(CTX, 1, 0L, 0, 64));
            public void releaseProvider(int providerKey) {}
        assertTrue("providerKey >= 0", providerKey >= 0);
        assertEquals("handle received maxDoc", 128, handle.lastMaxDoc);
    @Override
    public void testFullRoundTrip() {
        // collectDocs
import org.opensearch.analytics.spi.FilterDelegationHandle;
                return -1;
        expectThrows(AssertionError.class, () -> FilterTreeCallbacks.createProvider(CTX, 1));
            long wordsWritten = FilterTreeCallbacks.collectDocs(CTX, collectorKey, 0, 128, buf, 2);
        MockHandle handle = new MockHandle(cannedWords);
        @Override
            this.lastReleasedCollectorKey = collectorKey;
                out.setAtIndex(ValueLayout.JAVA_LONG, i, cannedWords[i]);
        int providerKey = FilterTreeCallbacks.createProvider(CTX, 42);
            this.lastReleasedProviderKey = providerKey;
 *
        int lastReleasedCollectorKey = -1;
 *
            @Override
        try (Arena arena = Arena.ofConfined()) {
        }
            @Override
            int wordCount = Math.min(cannedWords.length, (int) (out.byteSize() / Long.BYTES));
        }
 * this file be licensed under the Apache-2.0 license or a
    /** Mock handle that records arguments and returns canned bitset words. */
        public void close() {}
                MemorySegment buf = arena.allocate(Long.BYTES);
        }
        int lastCollectorKey = -1;
        long lastWriterGeneration = -1L;
        @Override
    public void testHandleReturningNegativeOnePropagates() {
        public int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {
            this.lastMaxDoc = maxDoc;
    }
    }
        private final long[] cannedWords;
            }
        int lastMaxDoc = -1;
     * or premature-teardown bugs. Under the refcounted lifecycle this is a genuine
        int lastProviderKey = -1;
        });
        // createProvider
        MockHandle(long[] cannedWords) {
 */
        public void releaseCollector(int collectorKey) {
        FilterTreeCallbacks.unregister(CTX);
            @Override
 * compatible open source license.
        public int createProvider(int annotationId) {
            this.lastMinDoc = minDoc;
        FilterTreeCallbacks.unregister(CTX);
            assertEquals(0x3L, buf.getAtIndex(ValueLayout.JAVA_LONG, 1));
        @Override
            for (int i = 0; i < wordCount; i++) {
        FilterTreeCallbacks.register(CTX, failingHandle, null);
        @Override
                FilterTreeCallbacks.collectDocs(CTX, 1, 0, 64, buf, 1);
        expectThrows(AssertionError.class, () -> FilterTreeCallbacks.createCollector(CTX, 1, 0L, 0, 64));
            assertEquals(0x5L, buf.getAtIndex(ValueLayout.JAVA_LONG, 0));
            }
            this.lastCollectorKey = collectorKey;
import java.lang.foreign.MemorySegment;
        int lastReleasedProviderKey = -1;
            @Override
                return -1;
import java.lang.foreign.ValueLayout;
     * {@code assert binding != null}. With {@code -ea} on (test default), this throws
    private static final class MockHandle implements FilterDelegationHandle {
    @Override
        assertEquals("handle received annotationId", 42, handle.lastAnnotationId);
        };
            this.lastAnnotationId = annotationId;
        @Override
                return -1;
     * Lifecycle assertion: invoking an upcall on an unregistered contextId trips
        int lastAnnotationId = -1;
            public void releaseCollector(int collectorKey) {}
        public long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out) {
    }
        int collectorKey = FilterTreeCallbacks.createCollector(CTX, providerKey, 2L, 0, 128);
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(AssertionError.class, () -> FilterTreeCallbacks.releaseCollector(CTX, Integer.MAX_VALUE));
            this.lastWriterGeneration = writerGeneration;
        // createCollector
    }
            this.cannedWords = cannedWords;
        }
        assertEquals("handle received providerKey for release", providerKey, handle.lastReleasedProviderKey);
        FilterTreeCallbacks.register(CTX, handle, null);
            public int createProvider(int annotationId) {
package org.opensearch.be.datafusion.indexfilter;
        FilterTreeCallbacks.releaseProvider(CTX, providerKey);
        assertEquals("handle received writerGeneration", 2L, handle.lastWriterGeneration);
        }
        assertTrue("collectorKey >= 0", collectorKey >= 0);
        // releaseProvider
        assertEquals("handle received minDoc", 0, handle.lastMinDoc);
        assertEquals(-1, FilterTreeCallbacks.createProvider(CTX, 1));
        assertEquals("handle received providerKey", providerKey, handle.lastProviderKey);
        FilterTreeCallbacks.unregister(CTX);
        }
            this.lastProviderKey = providerKey;
            }
            public long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out) {
import java.lang.foreign.Arena;
 */
        expectThrows(AssertionError.class, () -> {
    public void testUnregisteredContextIdAsserts() {
}
     * AssertionError rather than silently returning -1 — surfacing missing-register
            }
        }
        int lastMinDoc = -1;
    public void setUp() throws Exception {
        super.tearDown();
    /**
        try (Arena arena = Arena.ofConfined()) {
            @Override
 * Tests the Java-side FFM callback dispatch via {@link FilterTreeCallbacks}
        super.setUp();
 * The OpenSearch Contributors require contributions made to
        FilterTreeCallbacks.releaseCollector(CTX, collectorKey);
 * substrait → native pipeline.
 * <p>All callbacks now receive a {@code contextId} as their first argument.
    public void tearDown() throws Exception {
            return nextKey++;
        long[] cannedWords = new long[] { 0x5L, 0x3L };
     * bug signal: bindings stay alive until the last native handle is released.
            public int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {
            @Override
            public void close() {}
 * routing to a {@link FilterDelegationHandle} without going through the full
/**
        private int nextKey = 1;
 * Tests use {@code contextId=0} via {@link FilterTreeCallbacks#register}.
        assertEquals("handle received collectorKey for release", collectorKey, handle.lastReleasedCollectorKey);
     */
        public void releaseProvider(int providerKey) {
            assertEquals("wordsWritten matches canned length", 2L, wordsWritten);
public class IndexFilterCallbackTests extends OpenSearchTestCase {
    private static final long CTX = 0L;
        }
