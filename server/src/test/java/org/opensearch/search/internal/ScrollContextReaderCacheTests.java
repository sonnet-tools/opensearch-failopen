                    scrollContext.getCachedSequentialReader(segmentKeys[i])
 * The OpenSearch Contributors require contributions made to  
        assertSame(reader1, scrollContext.getCachedSequentialReader(segmentKey1));
    public void testCachePutAndGet() throws IOException {
        scrollContext.close();
        ScrollContext scrollContext = new ScrollContext();  
        doThrow(new IOException("test exception")).when(reader1).close();  
import static org.mockito.Mockito.mock;
                    readers[i],  
        Object segmentKey1 = new Object();
/**
        scrollContext.close();
        Object segmentKey2 = new Object();
            assertNull(scrollContext.getCachedSequentialReader(segmentKeys[i]));
        Object[] segmentKeys = new Object[numSegments];
        assertNull(scrollContext.getCachedSequentialReader(segmentKey2));
        }  
import org.opensearch.test.OpenSearchTestCase;
    public void testCloseWithEmptyCache() {
import org.apache.lucene.codecs.StoredFieldsReader;
        StoredFieldsReader reader2 = mock(StoredFieldsReader.class);
                    "Batch " + batch + ", segment " + i + " should hit cache",
        scrollContext.cacheSequentialReader(segmentKey2, reader2);
import static org.mockito.Mockito.doThrow;  
        // Verify both readers were closed
        }
        scrollContext.cacheSequentialReader(segmentKey2, reader2);
        StoredFieldsReader reader2 = mock(StoredFieldsReader.class);
            }  
        // Should not throw when closing with no cached readers  
 * SPDX-License-Identifier: Apache-2.0
        // Make reader1 throw on close
        // After close, cache should be cleared
    }  
    public void testMultipleSegmentsCached() throws IOException {
 * Unit tests for {@link ScrollContext}'s StoredFieldsReader caching functionality.  
                );
        scrollContext.close();
    }
        scrollContext.cacheSequentialReader(segmentKey1, reader1);  
import static org.mockito.Mockito.times;
/*  
        assertNull(scrollContext.getCachedSequentialReader(segmentKey1));  
        }  
        // Initially no cached readers
public class ScrollContextReaderCacheTests extends OpenSearchTestCase {  
            verify(readers[i], times(1)).close();
        assertNull(scrollContext.getCachedSequentialReader(new Object()));
 * of stored field blocks.
            segmentKeys[i] = new Object();
        // Should not throw, should continue closing other readers  
 * compatible open source license.
        scrollContext.cacheSequentialReader(segmentKey1, reader1);
    }
    }
        Object segmentKey1 = new Object();
        StoredFieldsReader reader1 = mock(StoredFieldsReader.class);  
        verify(reader2, times(1)).close();
        assertNull(scrollContext.getCachedSequentialReader(segmentKey1));  
package org.opensearch.search.internal;
        verify(reader2, times(1)).close();
 *
import java.io.IOException;
            scrollContext.cacheSequentialReader(segmentKeys[i], readers[i]);
        verify(reader1, times(1)).close();  
                assertSame(
        scrollContext.close();
 */  
        assertSame(reader2, scrollContext.getCachedSequentialReader(segmentKey2));  
        assertSame(reader1, scrollContext.getCachedSequentialReader(segmentKey1));
        for (int batch = 2; batch <= 5; batch++) {
        // Verify all readers were closed  
            for (int i = 0; i < numSegments; i++) {  
        // Simulate multiple scroll batches - all should hit cache
    public void testCloseHandlesReaderException() throws IOException {
        assertNull(scrollContext.getCachedSequentialReader(segmentKey2));
 * The cache stores merge instances of StoredFieldsReader per segment to optimize
        verify(reader1, times(1)).close();  
        // Cache reader for segment 1
        ScrollContext scrollContext = new ScrollContext();  
        assertNull(scrollContext.getCachedSequentialReader(segmentKey2));
            readers[i] = mock(StoredFieldsReader.class);  
        // Cache reader for segment 2  
        for (int i = 0; i < numSegments; i++) {
        ScrollContext scrollContext = new ScrollContext();
        Object segmentKey2 = new Object();
 *
        // Cache readers for all segments (simulates first batch per segment)  
        StoredFieldsReader[] readers = new StoredFieldsReader[numSegments];
        StoredFieldsReader reader1 = mock(StoredFieldsReader.class);  
 * sequential document access during scroll queries by avoiding repeated decompression  
}
        int numSegments = randomIntBetween(3, 10);  
import static org.mockito.Mockito.verify;  
        ScrollContext scrollContext = new ScrollContext();
        for (int i = 0; i < numSegments; i++) {
 * this file be licensed under the Apache-2.0 license or a
        // Both readers should have been attempted to close
 */
