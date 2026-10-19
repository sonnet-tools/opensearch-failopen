import static org.mockito.Mockito.when;
        assertEquals(5L, result.version());
        assertEquals(Versions.NOT_FOUND, result.version());
        );  
 * {@link IndexReaderProvider.Reader}) or an abstract class ({@link CatalogSnapshot}) and are mocked.
        WriterFileSet empty = fileSet(2L); // no files -> excluded
    private static DocumentMetadataResolver.DocumentMetadata metadata(String id, long rowId, long generation) {  
}  
    }
import static org.mockito.ArgumentMatchers.eq;
        when(snapshot.getSegments()).thenReturn(List.of(s1, s2, s3));
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);  
 * The OpenSearch Contributors require contributions made to  
 *  
        Segment segment = Segment.builder(1L).addSearchableFiles(FORMAT, fileSet(1L, "0.parquet")).build();  
        assertEquals("d1", results.get(0).id());
        ArgumentCaptor<List<WriterFileSet>> captor = ArgumentCaptor.forClass(List.class);
    public void testGetDocsAboveSeqNo_buildsResultsOnlyForRowsWithId() throws Exception {
 *
            new DocumentMetadataResolver.DocumentMetadata("doc1", 0L, 7L, 5L, DocumentMetadataResolver.UNSET, 2L)
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);
        assertNull(result.source());
    }
    }
        assertTrue(e.getMessage(), e.getMessage().contains("backend returned no row"));
        Map<String, Object> row = new LinkedHashMap<>();
    public void testExtractLong_nullReturnsFallback() {
        when(executor.executeSingleRow(0L, fs)).thenReturn(row("_id", "doc1", "_seq_no", 1L, "_custom", "keepme", "name", "bob"));
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(
    }
        assertTrue(result.documentFields().isEmpty());
/**
        super.setUp();
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);
        assertEquals(2L, result.primaryTerm());
        assertTrue(result.exists());
        assertEquals(Versions.NOT_FOUND, result.version());
        assertEquals(123L, DocumentLookupService.extractLong(Map.of("k", "123"), "k", 99L));  
    public void testGetVersionMetadata_fallsBackToRowWhenResolverReportsPartialMetadata() throws Exception {  
    }
            row.put((String) kv[i], kv[i + 1]);
import static org.mockito.Mockito.verify;
        assertFalse(result.exists());  
            b.addFile(f);
        return new DocumentMetadataResolver.DocumentMetadata(id, rowId, generation);
    }
        assertNull(result.source());  
 *       Lucene/Parquet inconsistency ISE paths (missing file set, missing row).</li>  
        assertEquals(SequenceNumbers.UNASSIGNED_SEQ_NO, result.seqNo());  
        DocumentLookupResult result = service.getById("doc1", reader, INDEX);  
        service = new DocumentLookupService(resolver, executor);
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
 *   <li>{@code getById} — not-found, success (reserved/underscore field filtering), and the two
import org.opensearch.core.index.Index;
        resolver = mock(DocumentMetadataResolver.class);
        DocumentLookupResult result = service.getVersionMetadata("doc1", reader, INDEX);  
        when(executor.executeSingleRow(0L, fs)).thenReturn(row("name", "alice"));  
    public void testExtractLong_parsesStringNumber() {
    }  
        assertEquals(2L, result.primaryTerm());  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        Segment s2 = Segment.builder(2L).addSearchableFiles(FORMAT, empty).build();
    // ---- getVersionMetadata -------------------------------------------------
        snapshot = mock(CatalogSnapshot.class);
        for (int i = 0; i < kv.length; i += 2) {  
 * are final records / sealed classes.
 *   <li>{@code getDocsAboveSeqNo} — rows without {@code _id} skipped, empty/wrong-format file sets  
        String source = result.source().utf8ToString();  
        // version-only hot path: source is never reconstructed
        WriterFileSet fs = fileSet(7L, "0.parquet");  
    private static final Index INDEX = new Index("idx", "uuid");  
        assertEquals(1, results.size());  
    private DocumentRowReader executor;  
import java.util.List;
public class DocumentLookupServiceTests extends OpenSearchTestCase {
import java.util.LinkedHashMap;
        when(resolver.resolveMetadata(reader, "missing")).thenReturn(null);  
        assertEquals(99L, DocumentLookupService.extractLong(Map.of("k", "abc"), "k", 99L));
        DocumentLookupResult result = service.getVersionMetadata("doc1", reader, INDEX);
        assertFalse("_primary_term excluded via constant: " + source, source.contains("_primary_term"));
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
import static org.mockito.ArgumentMatchers.anyLong;  
    private DocumentMetadataResolver resolver;
        verify(snapshot, never()).findFileSet(any(), anyLong());  
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(null);
        assertEquals(42L, result.seqNo());  
import org.opensearch.index.engine.exec.IndexReaderProvider;
 */
    }
        when(executor.executeSingleRow(0L, fs)).thenReturn(row("_seq_no", 42L, "_primary_term", 2L, "_version", 5L, "name", "alice"));  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> service.getById("doc1", reader, INDEX));  
        Map<String, Object> withoutId = row("_seq_no", 11L, "name", "bob");
    public void testGetById_notFoundWhenResolverReturnsNull() throws Exception {
    }
        assertEquals(5L, result.version());  
 *       fallback defaults when version fields are absent.</li>
        WriterFileSet fs = fileSet(7L, "0.parquet");
        assertEquals(1, passed.size());
        WriterFileSet lucene = fileSet(3L, "seg.cfs"); // different format -> excluded  
import static org.mockito.Mockito.never;  
 * this file be licensed under the Apache-2.0 license or a
        assertFalse("metadata field excluded: " + source, source.contains("_version"));
        assertFalse(result.exists());
        when(snapshot.getSegments()).thenReturn(List.of(segment));
        when(reader.catalogSnapshot()).thenReturn(snapshot);  
        reader = mock(IndexReaderProvider.Reader.class);
        for (String f : files) {  
        assertFalse("metadata field excluded: " + source, source.contains("_seq_no"));  
            .addNumRows(files.length);
 * {@link Segment}/{@link WriterFileSet} are real objects constructed via their builders since they  
    // ---- getDocsAboveSeqNo --------------------------------------------------  
        when(executor.executeRowsAboveSeqNo(captor.capture(), eq(0L))).thenReturn(List.of());
    }
 * </ul>  
import static org.mockito.Mockito.mock;
    }
 * Unit tests for {@link DocumentLookupService}, the Core orchestrator for document lookup.
        WriterFileSet fs = fileSet(7L, "0.parquet");
import java.util.Map;  
    public void testGetById_throwsISEWhenFileSetNull() throws Exception {  
        List<DocumentLookupResult> results = service.getDocsAboveSeqNo(5L, reader, INDEX);
        assertTrue(e.getMessage(), e.getMessage().contains("no matching file set"));
 * <p>All collaborators are interfaces ({@link DocumentMetadataResolver}, {@link DocumentRowReader},
 *   <li>{@code getVersionMetadata} — not-found, version-field extraction with null source, and
    }
    public void testGetById_successFiltersMetadataAndInternalColumns() throws Exception {
    }
        when(executor.executeSingleRow(0L, fs)).thenReturn(row("_seq_no", 42L, "_primary_term", 2L, "_version", 5L));  
import java.nio.file.Path;  
import org.opensearch.index.seqno.SequenceNumbers;  
        // user fields retained  
        assertTrue("non-metadata underscore field retained: " + source, source.contains("\"_custom\":\"keepme\""));
        DocumentLookupResult result = service.getById("doc1", reader, INDEX);
        WriterFileSet good = fileSet(1L, "0.parquet");
        assertTrue("user fields present: " + source, source.contains("\"name\":\"alice\""));
    private CatalogSnapshot snapshot;
        WriterFileSet fs = fileSet(7L, "0.parquet");
    private static final String FORMAT = "parquet";
package org.opensearch.analytics.spi;
        WriterFileSet fs = fileSet(7L, "0.parquet");  
        DocumentLookupResult result = service.getVersionMetadata("doc1", reader, INDEX);
import org.opensearch.common.lucene.uid.Versions;
        assertTrue(result.exists());
    // ---- extractLong --------------------------------------------------------  
            .directory(Path.of("/tmp/idx"))  
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(
        assertTrue(service.getDocsAboveSeqNo(5L, reader, INDEX).isEmpty());  
    @Override
        assertEquals(42L, result.seqNo());
    public void testGetById_throwsISEWhenRowNull() throws Exception {  
    public void setUp() throws Exception {  
        assertTrue("user fields present: " + source, source.contains("\"age\":30"));
    }  
        }
    }  
        when(snapshot.getSegments()).thenReturn(List.of());  
import static org.mockito.ArgumentMatchers.anyList;
        service.getDocsAboveSeqNo(0L, reader, INDEX);
import org.opensearch.index.engine.exec.Segment;
    private static Map<String, Object> row(Object... kv) {
    // ---- helpers ------------------------------------------------------------
        when(executor.executeSingleRow(0L, fs)).thenReturn(null);
        assertEquals("missing", result.id());
        List<WriterFileSet> passed = captor.getValue();  
/*  
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
    }
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));  
        assertEquals(SequenceNumbers.UNASSIGNED_PRIMARY_TERM, result.primaryTerm());
 */  
        assertTrue(result.exists());
        @SuppressWarnings("unchecked")  
    public void testGetVersionMetadata_extractsVersionFieldsWithNullSource() throws Exception {
        // "_custom" is not a registered metadata field, not _primary_term, not __row_id__ -> kept in _source.
        assertEquals(10L, results.get(0).seqNo());
        verify(executor, never()).executeSingleRow(anyLong(), any());
        assertTrue("user field retained: " + source, source.contains("\"name\":\"bob\""));
import org.opensearch.index.engine.exec.DocumentMetadataResolver;  
        assertEquals(7L, DocumentLookupService.extractLong(Map.of("k", 7), "k", 99L));
 * compatible open source license.
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);  
        when(executor.executeSingleRow(0L, fs)).thenReturn(
        when(executor.executeRowsAboveSeqNo(anyList(), anyLong())).thenReturn(List.of());
    // ---- getById ------------------------------------------------------------  
import org.mockito.ArgumentCaptor;
    }
        assertTrue(e.getMessage(), e.getMessage().contains("doc1"));  
        assertFalse("__row_id__ excluded via constant: " + source, source.contains("__row_id__"));  
        assertEquals(42L, result.seqNo());
        );
        // row exists (found) but carries no version fields
 *   <li>{@code extractLong} — Number, missing key, parsable String, and unparsable String.</li>
        DocumentLookupResult result = service.getVersionMetadata("doc1", reader, INDEX);
    public void testGetVersionMetadata_servedFromResolverWithoutReadingRow() throws Exception {
    }
        DocumentLookupResult result = service.getVersionMetadata("missing", reader, INDEX);
    public void testExtractLong_number() {
import org.opensearch.index.get.DocumentLookupResult;
        assertTrue(result.exists());
        assertFalse("metadata field excluded: " + source, source.contains("_seq_no"));
 *
        return b.build();  
            .writerGeneration(generation)
    }  
        Map<String, Object> withId = row("_id", "d1", "_seq_no", 10L, "name", "alice");  
        assertEquals(42L, result.seqNo());
    }  
        // non-mapper columns excluded via the constant guards (the regression this protects against)
 * SPDX-License-Identifier: Apache-2.0
        DocumentLookupResult result = service.getById("missing", reader, INDEX);
        executor = mock(DocumentRowReader.class);  
        // metadata-mapper fields excluded via the predicate  
 * <ul>
        assertEquals("doc1", result.id());  
        return row;  
        Segment s3 = Segment.builder(3L).addSearchableFiles("lucene", lucene).build();  
 * <p>Coverage:  
        verify(executor).executeSingleRow(0L, fs);  
import org.opensearch.test.OpenSearchTestCase;
            row("_id", "doc1", "_seq_no", 42L, "_primary_term", 2L, "_version", 5L, "__row_id__", 99L, "name", "alice", "age", 30)  
            new DocumentMetadataResolver.DocumentMetadata("doc1", 0L, 7L, 5L, 42L, 2L)  
        assertEquals(5L, DocumentLookupService.extractLong(Map.of("k", 5L), "k", 99L));  
        WriterFileSet.Builder b = WriterFileSet.builder()
        assertNull(result.source());  
        assertTrue(results.get(0).source().utf8ToString().contains("\"name\":\"alice\""));  
        assertTrue(e.getMessage(), e.getMessage().contains("doc1"));
        }
    public void testGetById_nonMetadataUnderscoreFieldRetained() throws Exception {  
        assertEquals(99L, DocumentLookupService.extractLong(Map.of(), "k", 99L));
        assertEquals(5L, result.version());
    public void testGetVersionMetadata_notFoundWhenResolverReturnsNull() throws Exception {
import org.opensearch.index.engine.exec.WriterFileSet;  
        assertEquals(good, passed.get(0));
        );
        when(executor.executeRowsAboveSeqNo(anyList(), eq(5L))).thenReturn(List.of(withId, withoutId));
        Segment s1 = Segment.builder(1L).addSearchableFiles(FORMAT, good).build();
        when(resolver.resolveMetadata(reader, "missing")).thenReturn(null);
        assertEquals(2L, result.primaryTerm());
    private DocumentLookupService service;  
    public void testGetDocsAboveSeqNo_skipsEmptyAndWrongFormatFileSets() throws Exception {  
    public void testGetDocsAboveSeqNo_emptyWhenNoRows() throws Exception {
        assertEquals(Versions.NOT_FOUND, result.version());  
        assertFalse("metadata field excluded: " + source, source.contains("\"_id\""));  
        when(executor.formatName()).thenReturn(FORMAT);
 *       excluded from the backend scan, and empty result handling.</li>
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
    public void testGetVersionMetadata_defaultsWhenFieldsMissing() throws Exception {
    private static WriterFileSet fileSet(long generation, String... files) {
    }
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> service.getById("doc1", reader, INDEX));
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);
        assertTrue(result.exists());
    private IndexReaderProvider.Reader reader;
    public void testExtractLong_unparseableStringReturnsFallback() {  
        WriterFileSet fs = fileSet(7L, "0.parquet");
        String source = result.source().utf8ToString();
        assertNull(result.source());
import static org.mockito.ArgumentMatchers.any;
