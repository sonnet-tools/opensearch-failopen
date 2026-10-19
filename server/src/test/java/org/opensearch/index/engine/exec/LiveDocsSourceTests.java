        @Override
    public void testResolverPassesThroughTheCountsFromTheLivenessHoldingFormat() throws IOException {
        resolver.apply(mock(CatalogSnapshot.class));
    /** A reader manager for a format that appends rows and never hides any. */
        assertTrue(resolver.apply(mock(CatalogSnapshot.class)).isEmpty());
}
        assertTrue("this test relies on assertions being enabled", LiveDocsSourceTests.class.desiredAssertionStatus());  
    }  
/*  
 * SPDX-License-Identifier: Apache-2.0
        public Map<Long, DocCounts> docCountsByGeneration(CatalogSnapshot catalogSnapshot) {
            List.of(new PlainReaderManager(), new PlainReaderManager())
 */  
        public void onFilesDeleted(Collection<String> files) {}
    public void testResolverReportsNothingForAnEmptyShard() throws IOException {
        public void onDeleted(CatalogSnapshot catalogSnapshot) {}
        public void beforeRefresh() {}
        );
        }
import java.util.Map;
        @Override  
        assertTrue(error.getMessage(), error.getMessage().contains("at most one data format"));  
    public void testResolverRejectsMoreThanOneLivenessHoldingFormat() {
public class LiveDocsSourceTests extends OpenSearchTestCase {  
    private static class PlainReaderManager implements EngineReaderManager<Object> {  
        }
        @Override  
        assertEquals(2, counts.size());  
        public Object getReader(CatalogSnapshot catalogSnapshot) {
        private final Map<Long, DocCounts> counts;  
        CheckedFunction<CatalogSnapshot, Map<Long, DocCounts>, IOException> resolver = LiveDocsSource.docCountsResolver(  
 * The OpenSearch Contributors require contributions made to  
            calls++;  
    }  
        LiveDocsReaderManager(Map<Long, DocCounts> counts) {  
        LiveDocsReaderManager liveDocs = new LiveDocsReaderManager(Map.of(1L, new DocCounts(4, 6), 2L, new DocCounts(3, 0)));
        assertEquals(new DocCounts(3, 0), counts.get(2L));
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(resolver.apply(mock(CatalogSnapshot.class)).isEmpty());
        LiveDocsReaderManager liveDocs = new LiveDocsReaderManager(Map.of(1L, new DocCounts(2, 0)));  
        CheckedFunction<CatalogSnapshot, Map<Long, DocCounts>, IOException> resolver = LiveDocsSource.docCountsResolver(List.of());
        AssertionError error = expectThrows(
import java.util.Collection;  
        );  
    public void testResolverReportsNothingWhenNoFormatHoldsLiveness() throws IOException {
        @Override  
    }
    }  
import static org.mockito.Mockito.mock;
import org.opensearch.test.OpenSearchTestCase;  
package org.opensearch.index.engine.exec;
 * compatible open source license.
            return new Object();  
        @Override  
        public void afterRefresh(boolean didRefresh, CatalogSnapshot catalogSnapshot) {}
    /** A reader manager for the format that holds the liveness information. */
        }
    public void testResolverIsAskedOncePerSnapshotNotOncePerManager() throws IOException {
            AssertionError.class,  
        CheckedFunction<CatalogSnapshot, Map<Long, DocCounts>, IOException> resolver = LiveDocsSource.docCountsResolver(
import java.util.List;
        @Override
            return counts;
        assertEquals(new DocCounts(4, 6), counts.get(1L));
 *
            List.of(new PlainReaderManager(), liveDocs, new PlainReaderManager())
            List.of(new PlainReaderManager(), liveDocs)
        assertEquals(2, liveDocs.calls);
/**  
 * Tests for {@link LiveDocsSource#docCountsResolver}.
import org.opensearch.common.CheckedFunction;
    }
        @Override  
        public void onFilesAdded(Collection<String> files) {}
        @Override  
        );
        private int calls;
        Map<Long, DocCounts> counts = resolver.apply(mock(CatalogSnapshot.class));
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    }
        public void close() {}
    private static class LiveDocsReaderManager extends PlainReaderManager implements LiveDocsSource {
        );
            () -> LiveDocsSource.docCountsResolver(List.of(new LiveDocsReaderManager(Map.of()), new LiveDocsReaderManager(Map.of())))
        CheckedFunction<CatalogSnapshot, Map<Long, DocCounts>, IOException> resolver = LiveDocsSource.docCountsResolver(  
import java.io.IOException;
            this.counts = counts;
 */
    }
        resolver.apply(mock(CatalogSnapshot.class));  
