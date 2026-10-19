    }
import org.opensearch.test.OpenSearchTestCase;
        when(snapshot.findFileSet("parquet", 1L)).thenReturn(pset);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        assertEquals(5L, result.seqNo());
    }  
}
        super.setUp();
    public void testExtractLong_string() throws Exception {  
        when(resolver.resolveMetadata(any(), eq("doc1"))).thenReturn(null);
        when(executor.formatName()).thenReturn("parquet");
public class GetServiceTests extends OpenSearchTestCase {  
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
import static org.mockito.ArgumentMatchers.any;
        when(resolver.resolveMetadata(any(), eq("doc1"))).thenReturn(metadata);  
    }
        DocumentMetadataResolver resolver = mock(DocumentMetadataResolver.class);
    public void testGetById_docFound_returnsFromParquet() throws IOException {
        expectThrows(IOException.class, () -> service.getById("doc1", mockReader, INDEX));  
    }  
        DocumentMetadata metadata = new DocumentMetadata("doc1", 0L, 1L);
        assertEquals(-1L, invokeExtractLong(Map.of("k", "abc"), "k", -1L));  
        expectThrows(IllegalStateException.class, () -> service.getById("doc1", mockReader, INDEX));  
    private static final Index INDEX = new Index("idx", "uuid");
import static org.mockito.Mockito.mock;  
    }
    public void testGetById_nullResolver_returnsNotFound() throws IOException {  
        when(resolver.resolveMetadata(any(), eq("doc1"))).thenReturn(metadata);  
    public void testGetById_fileSetNull_throwsISE() throws IOException {  
        IndexReaderProvider.Reader mockReader = mock(IndexReaderProvider.Reader.class);
        expectThrows(IllegalStateException.class, () -> service.getById("doc1", mockReader, INDEX));  
    public void testGetById_executorReturnsNull_throwsISE() throws IOException {  
 * compatible open source license.
        when(snapshot.findFileSet("parquet", 1L)).thenReturn(pset);  
 * The OpenSearch Contributors require contributions made to  
    }
        DocumentMetadataResolver resolver = mock(DocumentMetadataResolver.class);
    private DocumentRowReader mockExecutor;
import static org.mockito.ArgumentMatchers.eq;
/*  
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
        when(resolver.resolveMetadata(any(), eq("doc1"))).thenReturn(metadata);
    public void testExtractLong_number() throws Exception {  
import org.opensearch.index.engine.exec.IndexReaderProvider;  
    }
        assertEquals("doc1", result.id());
        when(executor.formatName()).thenReturn("parquet");
        DocumentLookupResult result = service.getById("doc1", mockReader, INDEX);
    public void testExtractLong_invalidString_returnsFallback() throws Exception {
        DocumentMetadata metadata = new DocumentMetadata("doc1", 0L, 1L);
        DocumentRowReader executor = mock(DocumentRowReader.class);
import org.opensearch.analytics.spi.DocumentRowReader;
        mockExecutor = mock(DocumentRowReader.class);  
        IndexReaderProvider.Reader mockReader = mock(IndexReaderProvider.Reader.class);  
        when(snapshot.findFileSet("parquet", 1L)).thenReturn(null);
        );
        DocumentLookupService service = new GetService(mockExecutor).documentLookupService(resolver);
        assertEquals("doc1", result.id());
import org.opensearch.analytics.spi.DocumentLookupService;
        when(mockReader.catalogSnapshot()).thenReturn(snapshot);
        IndexReaderProvider.Reader mockReader = mock(IndexReaderProvider.Reader.class);
        DocumentLookupService service = new GetService(mockExecutor).documentLookupService(resolver);
 */  
    }
        DocumentMetadataResolver resolver = mock(DocumentMetadataResolver.class);  
        DocumentLookupService service = new GetService(mockExecutor).documentLookupService(resolver);
    }
import java.util.Map;
import org.opensearch.core.index.Index;  
    }
        WriterFileSet pset = new WriterFileSet("/dir", 1L, Set.of("f.parquet"), 1L, 100L);
    public void testExtractLong_missing_returnsFallback() throws Exception {
        when(resolver.resolveMetadata(any(), eq("doc1"))).thenThrow(new IOException("reader closed"));
        assertTrue("doc should be found", result.exists());  
 *
import org.opensearch.index.engine.exec.DocumentMetadataResolver.DocumentMetadata;
        DocumentMetadataResolver resolver = mock(DocumentMetadataResolver.class);
        assertNull(DocumentMetadataResolver.NOOP.resolveMetadata(mock(IndexReaderProvider.Reader.class), "any"));
        DocumentLookupService service = new GetService(executor).documentLookupService(resolver);
        DocumentMetadata metadata = new DocumentMetadata("doc1", 0L, 1L);
        assertFalse(result.exists());
    public void testGetById_resolverThrows_propagates() throws IOException {  
        return DocumentLookupService.extractLong(row, key, fallback);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(99L, invokeExtractLong(Map.of("k", "99"), "k", -1L));
package org.opensearch.be.datafusion;
        assertEquals(42L, invokeExtractLong(Map.of("k", 42L), "k", -1L));
        when(executor.executeSingleRow(0L, pset)).thenReturn(
        when(mockExecutor.formatName()).thenReturn("parquet");  
    public void testNoopResolver_returnsNull() throws IOException {  
        DocumentRowReader executor = mock(DocumentRowReader.class);
import org.opensearch.index.get.DocumentLookupResult;  
        DocumentLookupResult result = service.getById("doc1", mockReader, INDEX);  
    public void setUp() throws Exception {
        when(mockReader.catalogSnapshot()).thenReturn(snapshot);
    }  
    }
        when(executor.executeSingleRow(0L, pset)).thenReturn(null);  
            Map.of("_id", "doc1", "_seq_no", 5L, "_primary_term", 1L, "_version", 2L, "field1", "value1")  
        WriterFileSet pset = new WriterFileSet("/dir", 1L, Set.of("f.parquet"), 1L, 100L);  
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);
        assertEquals(-1L, invokeExtractLong(Map.of(), "k", -1L));
import static org.mockito.Mockito.when;
        IndexReaderProvider.Reader mockReader = mock(IndexReaderProvider.Reader.class);
import org.opensearch.index.engine.exec.WriterFileSet;
import java.util.Set;
        assertEquals(2L, result.version());  
        DocumentMetadataResolver resolver = mock(DocumentMetadataResolver.class);
        IndexReaderProvider.Reader mockReader = mock(IndexReaderProvider.Reader.class);
        assertEquals(42L, invokeExtractLong(Map.of("k", 42), "k", -1L));
import java.io.IOException;  
        assertEquals(42L, invokeExtractLong(Map.of("k", 42.9), "k", -1L));  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
    private static long invokeExtractLong(Map<String, Object> row, String key, long fallback) {
        when(mockReader.catalogSnapshot()).thenReturn(snapshot);  
        DocumentLookupService service = new GetService(executor).documentLookupService(resolver);  
        CatalogSnapshot snapshot = mock(CatalogSnapshot.class);  
