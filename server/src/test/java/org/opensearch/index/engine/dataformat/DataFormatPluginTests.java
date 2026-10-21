                Set.of(
     * Tests MergeResult with and without RowIdMapping.
            assertEquals(2, r2.totalRows);
 *   <li>The engine refreshes to produce searchable {@link Segment}s via {@link RefreshResult}</li>
        FileInfos fileInfos2 = writer2.flush(FlushInput.EMPTY);
            .existingSegments(List.of(seg))
        rm.onFilesAdded(List.of("a.parquet", "b.parquet"));
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(infos.getWriterFileSet(format).isPresent());
        assertTrue(mergeResult.rowIdMapping().isPresent());
            .build();
import org.opensearch.Version;
        d.addField(mock(MappedFieldType.class), "x");
            assertNotNull(r1);
        };
            RefreshInput.builder()
        MockDataFormat format = new MockDataFormat();
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
import java.util.List;
        }
        assertTrue(empty.existingSegments().isEmpty());
        DataFormat format2 = new DataFormat() {
        );
    /**
        WriteResult.Success success = new WriteResult.Success(1L, 1L, 42L);
        MockReaderManager rm = new MockReaderManager(format.name());
    public void testSearchHoldsSnapshotAliveWhileRefreshDeletesFiles() throws IOException {
            assertTrue(r2.fileNames.contains("data.lucene"));
        Exception ex = new IOException("disk full");
    /**
        CatalogSnapshot snapshot1 = snapshotRef1.get();
        // Search completes — releases the old snapshot ref
                        Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.STORED_FIELDS)
            new MockDataFormat(
     */
                    )
            null,
        assertEquals(1L, mapping.getNewRowId(1, 1L));
        assertFalse("Snapshot1 should still be alive while search holds ref", ((DataformatAwareCatalogSnapshot) snapshot1).isClosed());
            RefreshInput.builder().addSegment(Segment.builder(0L).addSearchableFiles(format, fs1).build()).build()
        RefreshInput input = RefreshInput.builder()
        RowIdMapping mapping = mergeResult.rowIdMapping().get();
        // 8. Delete files
        Set<FieldTypeCapabilities> fields = format.supportedFields();
        // Verify row ID mapping
    /**
     */
        assertEquals(WriteResult.Success.class, result2.getClass());
        Segment seg = new Segment(0L, Map.of());
        // Snapshot 2 works
    }
                new IndexingEngineConfig(
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        Merger merger = engine.getMerger();
        // Acquire reader directly from snapshot manager and reader manager
import org.opensearch.index.engine.exec.Segment;
        RefreshResult rr2 = indexEngine.refresh(
import org.opensearch.index.engine.dataformat.stub.MockIndexingExecutionEngine;
                )
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        assertTrue(input.deletesApplied());
            MockReader r2 = rm2.getReader(cr.get());
        MockIndexingExecutionEngine indexEngine = new MockIndexingExecutionEngine(format);
                    null,
        );
            .addSegment(Segment.builder(0L).addSearchableFiles("mock", fs1).build())
        manager.commitNewSnapshot(rr2.refreshedSegments());
                return "mock-lucene";
        RefreshResult refreshResult = engine.refresh(refreshInput);
                    null,
    /**
        assertEquals(1L, writerFileSet.get().writerGeneration());
        manager.close();
            @Override
        assertFalse(format.supportedFields().isEmpty());
        MockDocumentInput d1 = indexEngine.newDocumentInput();
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
                return null;
        DataFormat format = new MockDataFormat();
        FieldTypeCapabilities cap = fields.iterator().next();
        assertEquals(1L, success.term());
                return 50L;
import org.opensearch.index.mapper.MappedFieldType;
        // 5. Merge the two writer file sets
        MergeResult withMapping = new MergeResult(Map.of(format, fileSet), mapping);
                return new MockDataFormat("test", 1L, Set.of());
        // 7. Refresh to produce searchable segments
        WriteResult result1 = writer.addDoc(doc1);
        DataFormatPlugin plugin = MockDataFormatPlugin.of(
    }
     * File add/delete notifications propagate through reader manager.
        MockReaderManager rm2 = new MockReaderManager(format2.name());
            @Override
        DataFormatPlugin plugin = new DataFormatPlugin() {
            )
        Path dir = createTempDir();
            null,
     * Search holds snapshot alive while refresh replaces it.
    public void testGetDeleteExecutionEngineDefaultReturnsNull() {
    /**
        assertNotNull(segment.dfGroupedSearchableFiles().get(format.name()));
            public DataFormat getDataFormat() {
import org.opensearch.index.engine.exec.CommitFileManager;
     */
        w2.addDoc(d2);
        WriterFileSet fs1 = new WriterFileSet(dir.toString(), 1L, Set.of(), 10, 0L);
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
            ((DataformatAwareCatalogSnapshot) ref.get()).setLastCommitInfo("segments_1", 1L, 0L);
            List.of(),
            assertEquals(10, r2.totalRows);
        @SuppressWarnings("unchecked")
 *   <li>A {@link DataFormatPlugin} provides a {@link DataFormat} and creates an {@link IndexingExecutionEngine}</li>
        IndexingExecutionEngine<DataFormat, MockDocumentInput> engine = (IndexingExecutionEngine<DataFormat, MockDocumentInput>) plugin
import org.opensearch.common.settings.Settings;
        MockDocumentInput doc1 = engine.newDocumentInput();
            .build();
            assertTrue(r1.fileNames.contains("data.parquet"));
    }
            RefreshInput.builder().addSegment(Segment.builder(0L).addSearchableFiles(format, fs).build()).build()
        MockDataFormat format1 = new MockDataFormat();
            rm1.afterRefresh(true, ref.get());
        assertTrue(rm.deletedFiles.contains("a.parquet"));
     * Tests RefreshInput accumulation of writer files.
    public void testDataFormatCapabilities() {
            }
        engine.deleteFiles(Map.of(merged.directory(), merged.files()));
    public void testFileLifecycleNotifications() throws IOException {
        assertEquals(1, input.existingSegments().size());
        MockReaderManager readerManager = new MockReaderManager(format.name());
        DataFormat format = new MockDataFormat();
        MockIndexingExecutionEngine indexEngine = new MockIndexingExecutionEngine(format);
    public void testRefreshInput() {
    public void testWriteResult() {
                    mock(MapperService.class),
                        "integer",
    }
        MockDocumentInput d = indexEngine.newDocumentInput();
        WriteResult.Failure failure = new WriteResult.Failure(ex, -1L, -1L, -1L);
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        rm.afterRefresh(false, snapshot);
        assertEquals(0, rm.readerCount());
            MockReader r1 = rm1.getReader(cr.get());
import org.opensearch.index.engine.dataformat.stub.MockReader;
 *   <li>Writers flush to produce {@link FileInfos} containing {@link WriterFileSet}s</li>
            assertEquals(10, r1.totalRows);
        assertNotNull(secondaryMerge.getMergedWriterFileSetForDataformat(format));
        assertEquals(1, rm.readerCount());
        MergeInput mergeInput = MergeInput.builder().segments(List.of(seg1, seg2)).newWriterGeneration(3L).build();
     * Tests DataFormat equality semantics and field capabilities.
/**
        assertNotNull(rm.getReader(snapshot));
        // 2. Create a writer and write documents
            .rowIdMapping(mapping)
        MockReaderManager rm = new MockReaderManager("mock-columnar");
        assertEquals(2, input.writerFiles().size());
        // Batch 1
        assertNull(plugin.getDeleteExecutionEngine(mock(org.opensearch.index.engine.exec.commit.Committer.class)));
        Optional<WriterFileSet> writerFileSet = fileInfos.getWriterFileSet(format);
        assertEquals(1, rm.deletedFiles.size());
            @Override
        assertEquals(1, searchReader.totalRows);
 * compatible open source license.
            assertNotNull(r2);
        assertSame(first, rm.getReader(snapshot));
     * CompositeReader provides per-format reader access from a single catalog snapshot.
        snapshotRef1.close();
            .deletesApplied(true)
    }
        FileInfos infos = FileInfos.builder().putWriterFileSet(format, fileSet).build();
        assertEquals(2L, mapping.getNewRowId(0, 2L));
public class DataFormatPluginTests extends OpenSearchTestCase {
        doc2.setRowId("_row_id", 1);
import static org.mockito.Mockito.mock;
     */
        assertFalse(withoutMapping.rowIdMapping().isPresent());
        w1.close();
 *   <li>A {@link Merger} merges multiple writer file sets into a {@link MergeResult}</li>
        WriterFileSet fileSet = WriterFileSet.builder().directory(dir).writerGeneration(1L).addNumRows(5).addFile("merged.parquet").build();
            .build();
import org.opensearch.index.engine.dataformat.stub.MockCatalogSnapshot;
 */
        d2.setRowId("_row_id", 1);
            }
        WriterFileSet fileSet1 = fileInfos.getWriterFileSet(format).get();
        MockDataFormat format = new MockDataFormat();
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
    /**
     */
            List.of(CatalogSnapshotManager.createInitialSnapshot(1L, 1L, 0L, rr1.refreshedSegments(), 1L, Map.of())),
        doc3.addField(mock(MappedFieldType.class), "Bob");
    public void testCompositeReaderMultiFormat() throws IOException {
        rm.afterRefresh(true, snapshot);
        }
        assertFalse(writerFileSet.get().files().isEmpty());
        MockReaderManager rm1 = new MockReaderManager(format1.name());
        assertSame(ex, failure.cause());
        assertEquals(1, searchReader.totalRows);
                    Map.of()
        MockReader searchReader = readerManager.getReader(snapshot1);
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
        }
import org.opensearch.index.engine.dataformat.stub.MockReaderManager;
        assertEquals(42L, success.seqNo());
                )
            }
        WriterFileSet wfs1 = WriterFileSet.builder().directory(dir).writerGeneration(1L).addFile("data.parquet").addNumRows(10).build();
        assertEquals("integer", cap.fieldType());
        WriterFileSet fs2 = w2.flush(FlushInput.EMPTY).getWriterFileSet(format).get();
     */
    }
        Segment segment = refreshResult.refreshedSegments().get(0);
                    new IndexSettings(IndexMetadata.builder("index").settings(settings).build(), settings),
    /**
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        MergeInput secondaryMergeInput = MergeInput.builder()
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        );
        assertEquals(2, writerFileSet.get().numRows());
            readerManager.afterRefresh(true, ref.get());
        assertFalse("Snapshot1 should still be alive due to commit ref", ((DataformatAwareCatalogSnapshot) snapshot1).isClosed());
            .newWriterGeneration(4L)
        assertEquals(0L, mapping.getNewRowId(0, 1L));
            mock(CommitFileManager.class)
        w.close();
 *
        assertNull(rm.getReader(snapshot));
        // Simulate the engine's commit of the initial snapshot so commitNewSnapshot can proceed
        // Snapshot1 still has commit ref (initial snapshot gets incRef'd by IndexFileDeleter).
        assertFalse(refreshResult.refreshedSegments().isEmpty());
import org.opensearch.cluster.metadata.IndexMetadata;
        Path dir = createTempDir();
        assertEquals(format, engine.getDataFormat());
        FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
        MockDocumentInput doc2 = engine.newDocumentInput();
        writer2.addDoc(doc3);
        w1.addDoc(d1);
        try (GatedCloseable<CatalogSnapshot> cr = manager.acquireSnapshot()) {
     * afterRefresh(false) is a no-op; duplicate afterRefresh for same snapshot reuses reader.
            files -> Map.of(),
            files -> Map.of(),
     * End-to-end test: plugin → engine → write docs → flush → merge → refresh.
                return Set.of();
import org.opensearch.common.concurrent.GatedCloseable;
        Segment seg1 = Segment.builder(fileSet1.writerGeneration()).addSearchableFiles(format, fileSet1).build();
    public void testRefreshEdgeCases() throws IOException {
    /**
    /**
        RefreshResult rr = indexEngine.refresh(
            assertNotSame(snapshot1, ref.get());
        d2.addField(mock(MappedFieldType.class), "Bob");
                .build()
        DataFormat format = plugin.getDataFormat();
        assertTrue(withMapping.rowIdMapping().isPresent());
 * <ol>
import static org.opensearch.index.engine.dataformat.stub.MockDataFormat.DEFAULT_MOCK_FORMAT_NAME;
            }
            List.of(CatalogSnapshotManager.createInitialSnapshot(1L, 1L, 0L, List.of(seg), 1L, Map.of())),
    }
import java.nio.file.Path;
        }
     * Tests WriteResult record fields.
        MockReader first = rm.getReader(snapshot);
        }
 *   <li>The engine creates {@link Writer} instances to write documents via {@link DocumentInput}</li>
    /**
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
            public String name() {
            assertEquals(2L, ref.get().getGeneration());
            .build();
        writer.close();
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;
import java.util.Optional;
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
import java.util.Set;
                    null,
/*
    }
 * The OpenSearch Contributors require contributions made to
        MockCatalogSnapshot snapshot = new MockCatalogSnapshot(1L, rr.refreshedSegments(), format);
import java.util.Map;
                .addSegment(Segment.builder(1L).addSearchableFiles(format, fs2).build())
        WriterFileSet merged = mergeResult.getMergedWriterFileSetForDataformat(format);
        MockDocumentInput doc3 = engine.newDocumentInput();
        w.addDoc(d);
                100L,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(WriteResult.Success.class, result1.getClass());
        WriterFileSet fs1 = w1.flush(FlushInput.EMPTY).getWriterFileSet(format).get();
    }
        MergeResult secondaryMerge = merger.merge(secondaryMergeInput);
        assertEquals(3L, merged.writerGeneration());
import org.opensearch.index.IndexSettings;
        MergeResult mergeResult = merger.merge(mergeInput);
            rm2.afterRefresh(true, ref.get());
        assertFalse("a refresh applies no delete unless told otherwise", empty.deletesApplied());
        // It won't be fully closed until a flush triggers the deletion policy.
import java.io.IOException;
        );
        // New refresh arrives — commit replaces snapshot
        // 3. Flush the writer to produce file metadata
        doc2.addField(mock(MappedFieldType.class), 30);
    public void testMergeResultWithAndWithoutRowIdMapping() {
        WriteResult result2 = writer.addDoc(doc2);
        assertEquals(1, rm.readerCount());
        WriterFileSet fs2 = new WriterFileSet(dir.toString(), 2L, Set.of(), 20, 0L);
        assertEquals(10, infos.getWriterFileSet(format).get().numRows());
            );
        // Snapshot1 still alive — search reader still works because the ref is held
        assertEquals(1L, snapshot1.getGeneration());
        MockDocumentInput d2 = indexEngine.newDocumentInput();
        Writer<MockDocumentInput> w1 = indexEngine.createWriter(new WriterConfig(1L));
        assertNotNull(merged);
            .indexingEngine(
            List.of(),
        assertEquals(2, rm.addedFiles.size());
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        d1.addField(mock(MappedFieldType.class), "Alice");
    public void testFullDataFormatLifecycle() throws IOException {
        RefreshInput empty = RefreshInput.builder().build();
            @Override
     */
        assertEquals(1L, success.version());
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        DataFormat format = new MockDataFormat();
            public Set<FieldTypeCapabilities> supportedFields() {
            mock(CommitFileManager.class)
        WriterFileSet fileSet = WriterFileSet.builder().directory(dir).writerGeneration(1L).addFile("data.parquet").addNumRows(10).build();
        doc1.addField(mock(MappedFieldType.class), "Alice");
        WriterFileSet fs = w.flush(FlushInput.EMPTY).getWriterFileSet(format).get();
        assertTrue(cap.capabilities().contains(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE));
        d.setRowId("_row_id", 0);
    public void testFileInfosBuilder() {
    }
        // 1. Create a mock DataFormatPlugin and obtain the engine
            MockReader r2 = readerManager.getReader(cr2.get());
        try (GatedCloseable<CatalogSnapshot> cr2 = manager.acquireSnapshot()) {
        assertTrue(empty.writerFilesMap().isEmpty());
        RefreshResult rr1 = indexEngine.refresh(
        Segment seg2 = Segment.builder(fileSet2.writerGeneration()).addSearchableFiles(format, fileSet2).build();
                DEFAULT_MOCK_FORMAT_NAME,
            @Override
            public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {
            .addSegment(Segment.builder(1L).addSearchableFiles("mock", fs2).build())
        // New acquireSnapshot returns snapshot2, not snapshot1
        Writer<MockDocumentInput> w2 = indexEngine.createWriter(new WriterConfig(2L));
        assertEquals(1, fields.size());
        WriterFileSet fileSet2 = fileInfos2.getWriterFileSet(format).get();
        }
        writer2.close();
        RowIdMapping mapping = new PackedRowIdMapping(new long[] { 0 }, false);
        Writer<MockDocumentInput> writer = engine.createWriter(new WriterConfig(1L));
                    new FieldTypeCapabilities(
     * Tests FileInfos builder and empty factory.
            .segments(List.of(seg1, seg2))
        rm.afterRefresh(true, snapshot);
        // 4. Write a second batch with a new writer generation
        assertTrue(rm.addedFiles.contains("a.parquet"));
        manager.close();
            .addSegment(Segment.builder(0L).addSearchableFiles(format, merged).build())
        w2.close();
            assertEquals(2L, cr2.get().getGeneration());
            readerManager.afterRefresh(true, ref.get());
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertTrue(cap.capabilities().contains(FieldTypeCapabilities.Capability.STORED_FIELDS));
        );
        doc3.setRowId("_row_id", 2);
        assertEquals(fileSet, withoutMapping.getMergedWriterFileSetForDataformat(format));
    }
     */
        WriterFileSet wfs2 = WriterFileSet.builder().directory(dir).writerGeneration(1L).addFile("data.lucene").addNumRows(10).build();
        assertEquals(0L, engine.getNativeBytesUsed());
        d1.setRowId("_row_id", 0);
import org.opensearch.index.mapper.MapperService;
 * Tests demonstrating the data format plugin API lifecycle:
        Segment seg = Segment.builder(0L).addSearchableFiles(format1, wfs1).addSearchableFiles(format2, wfs2).build();
        assertTrue(empty.writerFiles().isEmpty());
        doc1.setRowId("__row_id__", 0);
        // 6. Merge with an existing RowIdMapping (secondary data format merge)
     * CatalogSnapshotManager handles ref counting: acquireReader increments,
        };
 * </ol>
        Settings settings = Settings.builder()
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
        Writer<MockDocumentInput> w = indexEngine.createWriter(new WriterConfig(1L));
        rm.onFilesDeleted(List.of("a.parquet"));
            Map.of(),
        assertTrue(writerFileSet.isPresent());
        );
}
        }
import org.opensearch.index.engine.exec.WriterFileSet;
            }
            Map.of(),
     * commitNewSnapshot replaces the latest, and closing the reader releases the old snapshot.
        MergeResult withoutMapping = new MergeResult(Map.of(format, fileSet));
        GatedCloseable<CatalogSnapshot> snapshotRef1 = manager.acquireSnapshot();
 * this file be licensed under the Apache-2.0 license or a
        RefreshInput refreshInput = RefreshInput.builder()
        FileInfos empty = FileInfos.empty();
        assertEquals(100L, format.priority());
            public long priority() {
        Writer<MockDocumentInput> writer2 = engine.createWriter(new WriterConfig(2L));
package org.opensearch.index.engine.dataformat;
        Path dir = createTempDir();
        Path dir = createTempDir();
 */
     */
        assertEquals("mock-columnar", format.name());
     */
                .addSegment(Segment.builder(0L).addSearchableFiles(format, fs1).build())
