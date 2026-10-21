        when(executor.executeRowsAboveSeqNo(anyList(), eq(5L))).thenReturn(List.of(withId, withoutId));
        assertFalse(result.exists());
            .addNumRows(files.length);
        service = new DocumentLookupService(resolver, executor);
        assertTrue(e.getMessage(), e.getMessage().contains("no matching file set"));
        when(resolver.resolveMetadata(reader, "missing")).thenReturn(null);
    // ---- getDocsAboveSeqNo --------------------------------------------------
    }
    private static Map<String, Object> row(Object... kv) {
 * <p>Coverage:
 * The OpenSearch Contributors require contributions made to
    public void setUp() throws Exception {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        assertEquals(SequenceNumbers.UNASSIGNED_PRIMARY_TERM, result.primaryTerm());
    // ---- getVersionMetadata -------------------------------------------------
        DocumentLookupResult result = service.getVersionMetadata("doc1", reader, INDEX);
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
    private DocumentLookupService service;
import static org.mockito.Mockito.never;
import org.opensearch.index.seqno.SequenceNumbers;
        assertEquals(Versions.NOT_FOUND, result.version());
        when(executor.executeSingleRow(0L, fs)).thenReturn(row("_seq_no", 42L, "_primary_term", 2L, "_version", 5L));
    }
    public void testGetDocsAboveSeqNo_emptyWhenNoRows() throws Exception {
        verify(snapshot, never()).findFileSet(any(), anyLong());
 *
        assertEquals(2L, result.primaryTerm());
import static org.mockito.ArgumentMatchers.anyList;
import org.mockito.ArgumentCaptor;
        DocumentLookupResult result = service.getVersionMetadata("doc1", reader, INDEX);
        for (String f : files) {
    }
        assertEquals(good, passed.get(0));
        assertTrue(e.getMessage(), e.getMessage().contains("doc1"));
import org.opensearch.index.engine.exec.IndexReaderProvider;
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
 *
        assertTrue("user field retained: " + source, source.contains("\"name\":\"bob\""));
    public void testGetVersionMetadata_defaultsWhenFieldsMissing() throws Exception {
        assertTrue(result.exists());
        String source = result.source().utf8ToString();
        WriterFileSet empty = fileSet(2L); // no files -> excluded
        when(snapshot.getSegments()).thenReturn(List.of());
            new DocumentMetadataResolver.DocumentMetadata("doc1", 0L, 7L, 5L, DocumentMetadataResolver.UNSET, 2L)
    public void testGetById_throwsISEWhenRowNull() throws Exception {
        resolver = mock(DocumentMetadataResolver.class);
        }
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(null);
        // "_custom" is not a registered metadata field, not _primary_term, not __row_id__ -> kept in _source.
        DocumentLookupResult result = service.getById("doc1", reader, INDEX);
    public void testGetById_notFoundWhenResolverReturnsNull() throws Exception {
        assertEquals(5L, result.version());
        assertFalse("metadata field excluded: " + source, source.contains("_version"));
    }
        when(executor.formatName()).thenReturn(FORMAT);
        Map<String, Object> withId = row("_id", "d1", "_seq_no", 10L, "name", "alice");
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);
 *
        assertEquals(99L, DocumentLookupService.extractLong(Map.of("k", "abc"), "k", 99L));
        when(executor.executeSingleRow(0L, fs)).thenReturn(
    public void testGetVersionMetadata_fallsBackToRowWhenResolverReportsPartialMetadata() throws Exception {
import org.opensearch.index.get.DocumentLookupResult;
        service.getDocsAboveSeqNo(0L, reader, INDEX);
        assertFalse("metadata field excluded: " + source, source.contains("_seq_no"));
    }
        assertTrue("user fields present: " + source, source.contains("\"age\":30"));
    public void testGetVersionMetadata_notFoundWhenResolverReturnsNull() throws Exception {
        assertEquals(42L, result.seqNo());
 * {@link IndexReaderProvider.Reader}) or an abstract class ({@link CatalogSnapshot}) and are mocked.
        String source = result.source().utf8ToString();
    // ---- extractLong --------------------------------------------------------
        DocumentLookupResult result = service.getVersionMetadata("doc1", reader, INDEX);
        assertEquals(42L, result.seqNo());
        DocumentLookupResult result = service.getById("doc1", reader, INDEX);
        assertEquals(123L, DocumentLookupService.extractLong(Map.of("k", "123"), "k", 99L));
    }
import java.util.LinkedHashMap;
        assertTrue("non-metadata underscore field retained: " + source, source.contains("\"_custom\":\"keepme\""));
        assertFalse("metadata field excluded: " + source, source.contains("_seq_no"));
 * {@link Segment}/{@link WriterFileSet} are real objects constructed via their builders since they
        assertEquals("doc1", result.id());
        assertFalse(result.exists());
        when(executor.executeSingleRow(0L, fs)).thenReturn(row("_seq_no", 42L, "_primary_term", 2L, "_version", 5L, "name", "alice"));
            .directory(Path.of("/tmp/idx"))
import java.nio.file.Path;
    public void testGetDocsAboveSeqNo_buildsResultsOnlyForRowsWithId() throws Exception {
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
        assertTrue(e.getMessage(), e.getMessage().contains("doc1"));
        executor = mock(DocumentRowReader.class);
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);
import static org.mockito.ArgumentMatchers.eq;
        WriterFileSet fs = fileSet(7L, "0.parquet");
        assertFalse("__row_id__ excluded via constant: " + source, source.contains("__row_id__"));
import org.opensearch.common.lucene.uid.Versions;
        assertEquals(42L, result.seqNo());
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
 *   <li>{@code getDocsAboveSeqNo} — rows without {@code _id} skipped, empty/wrong-format file sets
    public void testExtractLong_parsesStringNumber() {
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);
    public void testExtractLong_nullReturnsFallback() {
        when(executor.executeRowsAboveSeqNo(anyList(), anyLong())).thenReturn(List.of());
/*
 *   <li>{@code getById} — not-found, success (reserved/underscore field filtering), and the two
import static org.mockito.Mockito.mock;
        assertNull(result.source());
        assertTrue(result.exists());
        assertTrue(result.exists());
        assertEquals(Versions.NOT_FOUND, result.version());
package org.opensearch.analytics.spi;
        when(snapshot.getSegments()).thenReturn(List.of(segment));
        when(executor.executeRowsAboveSeqNo(captor.capture(), eq(0L))).thenReturn(List.of());
 */
        assertFalse("metadata field excluded: " + source, source.contains("\"_id\""));
import java.util.Map;
        Segment s3 = Segment.builder(3L).addSearchableFiles("lucene", lucene).build();
        return row;
 * Unit tests for {@link DocumentLookupService}, the Core orchestrator for document lookup.
    }
    public void testExtractLong_unparseableStringReturnsFallback() {
    public void testGetById_successFiltersMetadataAndInternalColumns() throws Exception {
    }
        assertEquals(2L, result.primaryTerm());
        // user fields retained
        assertEquals(5L, result.version());
        assertTrue(result.exists());
        // metadata-mapper fields excluded via the predicate
import static org.mockito.ArgumentMatchers.any;
 * SPDX-License-Identifier: Apache-2.0
        List<DocumentLookupResult> results = service.getDocsAboveSeqNo(5L, reader, INDEX);
        assertNull(result.source());
        assertEquals(99L, DocumentLookupService.extractLong(Map.of(), "k", 99L));
        );
            .writerGeneration(generation)
}
import java.util.List;
        Map<String, Object> withoutId = row("_seq_no", 11L, "name", "bob");
        assertEquals(5L, DocumentLookupService.extractLong(Map.of("k", 5L), "k", 99L));
        // non-mapper columns excluded via the constant guards (the regression this protects against)
    }
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> service.getById("doc1", reader, INDEX));
        verify(executor).executeSingleRow(0L, fs);
    }
        assertEquals(SequenceNumbers.UNASSIGNED_SEQ_NO, result.seqNo());
 * this file be licensed under the Apache-2.0 license or a
        // row exists (found) but carries no version fields
            new DocumentMetadataResolver.DocumentMetadata("doc1", 0L, 7L, 5L, 42L, 2L)
        return b.build();
            b.addFile(f);
        when(executor.executeSingleRow(0L, fs)).thenReturn(null);
        WriterFileSet.Builder b = WriterFileSet.builder()
        WriterFileSet fs = fileSet(7L, "0.parquet");
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
    }
        for (int i = 0; i < kv.length; i += 2) {
        WriterFileSet fs = fileSet(7L, "0.parquet");
 *       excluded from the backend scan, and empty result handling.</li>
    }
        assertFalse("_primary_term excluded via constant: " + source, source.contains("_primary_term"));
    private DocumentMetadataResolver resolver;
        when(snapshot.getSegments()).thenReturn(List.of(s1, s2, s3));
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);
        assertEquals("missing", result.id());
    private static final String FORMAT = "parquet";
import static org.mockito.Mockito.verify;
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(
 *   <li>{@code extractLong} — Number, missing key, parsable String, and unparsable String.</li>
import org.opensearch.index.engine.exec.WriterFileSet;
 *       fallback defaults when version fields are absent.</li>
    }
    private DocumentRowReader executor;
        DocumentLookupResult result = service.getVersionMetadata("doc1", reader, INDEX);
        assertTrue(e.getMessage(), e.getMessage().contains("backend returned no row"));
        // version-only hot path: source is never reconstructed
        when(reader.catalogSnapshot()).thenReturn(snapshot);
        );
        WriterFileSet good = fileSet(1L, "0.parquet");
        when(resolver.resolveMetadata(reader, "missing")).thenReturn(null);
        verify(executor, never()).executeSingleRow(anyLong(), any());
            row("_id", "doc1", "_seq_no", 42L, "_primary_term", 2L, "_version", 5L, "__row_id__", 99L, "name", "alice", "age", 30)
 *   <li>{@code getVersionMetadata} — not-found, version-field extraction with null source, and
    public void testGetVersionMetadata_servedFromResolverWithoutReadingRow() throws Exception {
        assertEquals(42L, result.seqNo());
        );
        when(resolver.resolveMetadata(reader, "doc1")).thenReturn(metadata("doc1", 0L, 7L));
 * <p>All collaborators are interfaces ({@link DocumentMetadataResolver}, {@link DocumentRowReader},
        super.setUp();
        assertTrue(result.exists());
        assertTrue(result.documentFields().isEmpty());
    }
        assertNull(result.source());
    public void testGetVersionMetadata_extractsVersionFieldsWithNullSource() throws Exception {
    private static WriterFileSet fileSet(long generation, String... files) {
 * are final records / sealed classes.
 */
        snapshot = mock(CatalogSnapshot.class);
/**
        when(executor.executeSingleRow(0L, fs)).thenReturn(row("name", "alice"));
    }
 * </ul>
    private static final Index INDEX = new Index("idx", "uuid");
        List<WriterFileSet> passed = captor.getValue();
        assertEquals(2L, result.primaryTerm());
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> service.getById("doc1", reader, INDEX));
        reader = mock(IndexReaderProvider.Reader.class);
    // ---- helpers ------------------------------------------------------------
import static org.mockito.Mockito.when;
    }
        Map<String, Object> row = new LinkedHashMap<>();
            row.put((String) kv[i], kv[i + 1]);
        @SuppressWarnings("unchecked")
import org.opensearch.index.engine.exec.Segment;
 * <ul>
        assertEquals(1, results.size());
    public void testGetById_nonMetadataUnderscoreFieldRetained() throws Exception {
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);
        assertNull(result.source());
        assertEquals("d1", results.get(0).id());
        return new DocumentMetadataResolver.DocumentMetadata(id, rowId, generation);
        DocumentLookupResult result = service.getById("missing", reader, INDEX);
    public void testGetById_throwsISEWhenFileSetNull() throws Exception {
        when(snapshot.findFileSet(FORMAT, 7L)).thenReturn(fs);
        assertTrue(service.getDocsAboveSeqNo(5L, reader, INDEX).isEmpty());
        assertTrue(results.get(0).source().utf8ToString().contains("\"name\":\"alice\""));
        assertEquals(10L, results.get(0).seqNo());
        }
    @Override
        WriterFileSet lucene = fileSet(3L, "seg.cfs"); // different format -> excluded
        WriterFileSet fs = fileSet(7L, "0.parquet");
    public void testGetDocsAboveSeqNo_skipsEmptyAndWrongFormatFileSets() throws Exception {
public class DocumentLookupServiceTests extends OpenSearchTestCase {
        DocumentLookupResult result = service.getVersionMetadata("missing", reader, INDEX);
    private static DocumentMetadataResolver.DocumentMetadata metadata(String id, long rowId, long generation) {
        Segment s1 = Segment.builder(1L).addSearchableFiles(FORMAT, good).build();
        assertTrue("user fields present: " + source, source.contains("\"name\":\"alice\""));
    public void testExtractLong_number() {
        assertEquals(Versions.NOT_FOUND, result.version());
    }
import org.opensearch.core.index.Index;
        assertEquals(1, passed.size());
 *       Lucene/Parquet inconsistency ISE paths (missing file set, missing row).</li>
        assertEquals(7L, DocumentLookupService.extractLong(Map.of("k", 7), "k", 99L));
    private IndexReaderProvider.Reader reader;
        assertEquals(5L, result.version());
 * compatible open source license.
    private CatalogSnapshot snapshot;
    }
        when(executor.executeSingleRow(0L, fs)).thenReturn(row("_id", "doc1", "_seq_no", 1L, "_custom", "keepme", "name", "bob"));
    }
import static org.mockito.ArgumentMatchers.anyLong;
    // ---- getById ------------------------------------------------------------
        ArgumentCaptor<List<WriterFileSet>> captor = ArgumentCaptor.forClass(List.class);
import org.opensearch.test.OpenSearchTestCase;
        WriterFileSet fs = fileSet(7L, "0.parquet");
    }
        WriterFileSet fs = fileSet(7L, "0.parquet");
        Segment segment = Segment.builder(1L).addSearchableFiles(FORMAT, fileSet(1L, "0.parquet")).build();
        Segment s2 = Segment.builder(2L).addSearchableFiles(FORMAT, empty).build();
    }
