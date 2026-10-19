        doc3.setRowId("_row_id", 2);
package org.opensearch.index.engine.dataformat;
            RefreshInput.builder().addSegment(Segment.builder(0L).addSearchableFiles(format, fs1).build()).build()
    /**  
        MockDataFormat format = new MockDataFormat();
            .newWriterGeneration(4L)
        Path dir = createTempDir();  
import org.opensearch.Version;
        DataFormat format = new MockDataFormat();  
        assertNotNull(rm.getReader(snapshot));
        assertFalse("Snapshot1 should still be alive while search holds ref", ((DataformatAwareCatalogSnapshot) snapshot1).isClosed());  
            MockReader r2 = rm2.getReader(cr.get());
        rm.afterRefresh(true, snapshot);  
            .build();
    }
        // 4. Write a second batch with a new writer generation
            MockReader r1 = rm1.getReader(cr.get());  
        }  
            .rowIdMapping(mapping)  
            assertEquals(2L, cr2.get().getGeneration());
        assertEquals(2L, mapping.getNewRowId(0, 2L));
        assertEquals(1L, success.term());
        Writer<MockDocumentInput> writer = engine.createWriter(new WriterConfig(1L));
        // Snapshot1 still has commit ref (initial snapshot gets incRef'd by IndexFileDeleter).  
        assertTrue(rm.addedFiles.contains("a.parquet"));  
        // Verify row ID mapping  
        WriterFileSet fileSet2 = fileInfos2.getWriterFileSet(format).get();
     * Search holds snapshot alive while refresh replaces it.
        );
                return "mock-lucene";
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(1, searchReader.totalRows);
    public void testMergeResultWithAndWithoutRowIdMapping() {
        assertEquals(42L, success.seqNo());  
            .addSegment(Segment.builder(1L).addSearchableFiles("mock", fs2).build())
        // Simulate the engine's commit of the initial snapshot so commitNewSnapshot can proceed  
        // 7. Refresh to produce searchable segments  
        try (GatedCloseable<CatalogSnapshot> cr = manager.acquireSnapshot()) {
        assertNotNull(segment.dfGroupedSearchableFiles().get(format.name()));
        RefreshResult rr1 = indexEngine.refresh(
                .addSegment(Segment.builder(1L).addSearchableFiles(format, fs2).build())
        Segment seg = Segment.builder(0L).addSearchableFiles(format1, wfs1).addSearchableFiles(format2, wfs2).build();  
        assertEquals(1, rm.deletedFiles.size());  
    public void testFullDataFormatLifecycle() throws IOException {
        MergeResult mergeResult = merger.merge(mergeInput);  
import org.opensearch.index.IndexSettings;
        // 8. Delete files  
        WriteResult result2 = writer.addDoc(doc2);  
        assertEquals(2, rm.addedFiles.size());
        writer2.addDoc(doc3);  
        Path dir = createTempDir();  
        rm.afterRefresh(false, snapshot);
        assertFalse(withoutMapping.rowIdMapping().isPresent());
        Set<FieldTypeCapabilities> fields = format.supportedFields();
        MockDocumentInput d = indexEngine.newDocumentInput();  
     * afterRefresh(false) is a no-op; duplicate afterRefresh for same snapshot reuses reader.
        WriterFileSet fs2 = new WriterFileSet(dir.toString(), 2L, Set.of(), 20, 0L);
        rm.afterRefresh(true, snapshot);
            mock(CommitFileManager.class)  
        MockDocumentInput d1 = indexEngine.newDocumentInput();  
            new MockDataFormat(
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
                    new IndexSettings(IndexMetadata.builder("index").settings(settings).build(), settings),
            .addSegment(Segment.builder(0L).addSearchableFiles(format, merged).build())
            }
            assertNotNull(r1);
        // Snapshot 2 works
        assertTrue(input.deletesApplied());
                return 50L;  
        WriterFileSet fileSet1 = fileInfos.getWriterFileSet(format).get();
        d1.addField(mock(MappedFieldType.class), "Alice");
            assertEquals(10, r1.totalRows);
            assertEquals(2L, ref.get().getGeneration());
    }
        doc3.addField(mock(MappedFieldType.class), "Bob");
        manager.close();
 *   <li>Writers flush to produce {@link FileInfos} containing {@link WriterFileSet}s</li>  
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        Path dir = createTempDir();  
        assertEquals(1L, success.version());
            }
        assertNotNull(secondaryMerge.getMergedWriterFileSetForDataformat(format));
            List.of(CatalogSnapshotManager.createInitialSnapshot(1L, 1L, 0L, List.of(seg), 1L, Map.of())),  
 *   <li>The engine refreshes to produce searchable {@link Segment}s via {@link RefreshResult}</li>
        assertTrue(empty.existingSegments().isEmpty());  
            }  
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        @SuppressWarnings("unchecked")
     * Tests DataFormat equality semantics and field capabilities.  
                    null,
        assertEquals(0L, engine.getNativeBytesUsed());
            Map.of(),  
            RefreshInput.builder()  
    /**
        doc1.setRowId("__row_id__", 0);
        doc1.addField(mock(MappedFieldType.class), "Alice");
        assertNotNull(merged);
            )
        Writer<MockDocumentInput> w = indexEngine.createWriter(new WriterConfig(1L));
        assertNull(rm.getReader(snapshot));  
        assertFalse("a refresh applies no delete unless told otherwise", empty.deletesApplied());
        Writer<MockDocumentInput> w2 = indexEngine.createWriter(new WriterConfig(2L));  
     * commitNewSnapshot replaces the latest, and closing the reader releases the old snapshot.
        GatedCloseable<CatalogSnapshot> snapshotRef1 = manager.acquireSnapshot();
        assertFalse(format.supportedFields().isEmpty());  
                )
        FieldTypeCapabilities cap = fields.iterator().next();
                100L,  
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(cap.capabilities().contains(FieldTypeCapabilities.Capability.STORED_FIELDS));
 * The OpenSearch Contributors require contributions made to  
            assertNotNull(r2);  
     */
        WriteResult result1 = writer.addDoc(doc1);  
 */  
import org.opensearch.index.engine.exec.Segment;  
import static org.mockito.Mockito.mock;
    }  
     * Tests RefreshInput accumulation of writer files.
import org.opensearch.index.engine.dataformat.stub.MockCatalogSnapshot;  
        writer.close();
            readerManager.afterRefresh(true, ref.get());
            null,
            null,
        // Acquire reader directly from snapshot manager and reader manager
        // 3. Flush the writer to produce file metadata  
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
    /**
            assertTrue(r2.fileNames.contains("data.lucene"));
        assertTrue(infos.getWriterFileSet(format).isPresent());
        WriterFileSet merged = mergeResult.getMergedWriterFileSetForDataformat(format);
        // 6. Merge with an existing RowIdMapping (secondary data format merge)  
        assertEquals("mock-columnar", format.name());
            assertTrue(r1.fileNames.contains("data.parquet"));  
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {
        rm.onFilesDeleted(List.of("a.parquet"));
        RefreshResult rr2 = indexEngine.refresh(
        d2.setRowId("_row_id", 1);  
        MockReaderManager rm2 = new MockReaderManager(format2.name());
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
                return new MockDataFormat("test", 1L, Set.of());
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
            ((DataformatAwareCatalogSnapshot) ref.get()).setLastCommitInfo("segments_1", 1L, 0L);
            .build();  
            .indexingEngine(  
                    )
    public void testGetDeleteExecutionEngineDefaultReturnsNull() {
import java.nio.file.Path;
     * CompositeReader provides per-format reader access from a single catalog snapshot.  
        d.addField(mock(MappedFieldType.class), "x");
            .build();  
        rm.onFilesAdded(List.of("a.parquet", "b.parquet"));
        MockDocumentInput doc3 = engine.newDocumentInput();  
        Optional<WriterFileSet> writerFileSet = fileInfos.getWriterFileSet(format);
        assertEquals(100L, format.priority());
        assertFalse("Snapshot1 should still be alive due to commit ref", ((DataformatAwareCatalogSnapshot) snapshot1).isClosed());
        w.addDoc(d);  
        assertEquals("integer", cap.fieldType());
        // It won't be fully closed until a flush triggers the deletion policy.
        MockDocumentInput doc2 = engine.newDocumentInput();  
        Segment segment = refreshResult.refreshedSegments().get(0);  
        MockDocumentInput doc1 = engine.newDocumentInput();  
/**
        FileInfos empty = FileInfos.empty();
        // 1. Create a mock DataFormatPlugin and obtain the engine
            Map.of(),  
        assertEquals(0L, mapping.getNewRowId(0, 1L));
import org.opensearch.common.settings.Settings;
        MergeResult secondaryMerge = merger.merge(secondaryMergeInput);  
    }
     */  
import java.io.IOException;  
    /**
        MergeResult withMapping = new MergeResult(Map.of(format, fileSet), mapping);
        // New acquireSnapshot returns snapshot2, not snapshot1  
        assertFalse(refreshResult.refreshedSegments().isEmpty());
        DataFormat format = new MockDataFormat();
            .deletesApplied(true)  
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        assertTrue(withMapping.rowIdMapping().isPresent());  
        Merger merger = engine.getMerger();
public class DataFormatPluginTests extends OpenSearchTestCase {
        assertEquals(format, engine.getDataFormat());
    public void testSearchHoldsSnapshotAliveWhileRefreshDeletesFiles() throws IOException {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        assertEquals(1, fields.size());
        assertEquals(3L, merged.writerGeneration());  
        Writer<MockDocumentInput> writer2 = engine.createWriter(new WriterConfig(2L));
        writer2.close();
import org.opensearch.index.engine.dataformat.stub.MockReaderManager;  
        MockReaderManager readerManager = new MockReaderManager(format.name());
        d2.addField(mock(MappedFieldType.class), "Bob");
import org.opensearch.common.concurrent.GatedCloseable;  
        }
                    new FieldTypeCapabilities(
    }  
 * <ol>  
 */
import org.opensearch.index.engine.exec.WriterFileSet;
 * compatible open source license.
                .addSegment(Segment.builder(0L).addSearchableFiles(format, fs1).build())
        Writer<MockDocumentInput> w1 = indexEngine.createWriter(new WriterConfig(1L));
        assertEquals(0, rm.readerCount());
        WriterFileSet fileSet = WriterFileSet.builder().directory(dir).writerGeneration(1L).addFile("data.parquet").addNumRows(10).build();
 *
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
            @Override  
     */  
        assertFalse(writerFileSet.get().files().isEmpty());
        );
 * </ol>  
        assertEquals(1, searchReader.totalRows);
import java.util.Map;  
        };
/*  
            files -> Map.of(),
import org.opensearch.index.engine.dataformat.stub.MockReader;
     */
        };  
        MockIndexingExecutionEngine indexEngine = new MockIndexingExecutionEngine(format);
                    mock(MapperService.class),  
        FileInfos infos = FileInfos.builder().putWriterFileSet(format, fileSet).build();  
    }
        }
            public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig settings) {  
    public void testRefreshInput() {  
    }  
        FileInfos fileInfos = writer.flush(FlushInput.EMPTY);
        assertEquals(1L, snapshot1.getGeneration());  
    /**
        // New refresh arrives — commit replaces snapshot
        assertSame(ex, failure.cause());
        );
        DataFormatPlugin plugin = new DataFormatPlugin() {
            List.of(CatalogSnapshotManager.createInitialSnapshot(1L, 1L, 0L, rr1.refreshedSegments(), 1L, Map.of())),  
            .addSegment(Segment.builder(0L).addSearchableFiles("mock", fs1).build())  
        assertEquals(1, input.existingSegments().size());  
        }  
        );  
    public void testCompositeReaderMultiFormat() throws IOException {
    }  
        w2.close();  
    /**
     */
        RowIdMapping mapping = mergeResult.rowIdMapping().get();
        assertTrue(empty.writerFiles().isEmpty());
        MockReaderManager rm = new MockReaderManager("mock-columnar");
                return Set.of();
     * End-to-end test: plugin → engine → write docs → flush → merge → refresh.
        assertSame(first, rm.getReader(snapshot));  
        manager.close();
            MockReader r2 = readerManager.getReader(cr2.get());  
            .existingSegments(List.of(seg))
     * File add/delete notifications propagate through reader manager.
        Exception ex = new IOException("disk full");
        );
            files -> Map.of(),
    }
        RefreshResult rr = indexEngine.refresh(
                    Map.of()
            );  
        assertEquals(1L, writerFileSet.get().writerGeneration());  
        WriterFileSet wfs2 = WriterFileSet.builder().directory(dir).writerGeneration(1L).addFile("data.lucene").addNumRows(10).build();
        assertEquals(1L, mapping.getNewRowId(1, 1L));  
            rm1.afterRefresh(true, ref.get());
        w1.close();
            assertNotSame(snapshot1, ref.get());  
            readerManager.afterRefresh(true, ref.get());
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
        MockReaderManager rm1 = new MockReaderManager(format1.name());  
     * Tests FileInfos builder and empty factory.
        manager.commitNewSnapshot(rr2.refreshedSegments());
        WriteResult.Success success = new WriteResult.Success(1L, 1L, 42L);  
                new IndexingEngineConfig(
     */  
        );  
        engine.deleteFiles(Map.of(merged.directory(), merged.files()));
                DEFAULT_MOCK_FORMAT_NAME,
import java.util.Set;
 *   <li>The engine creates {@link Writer} instances to write documents via {@link DocumentInput}</li>
        MergeResult withoutMapping = new MergeResult(Map.of(format, fileSet));  
        assertEquals(1, rm.readerCount());
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;  
        WriterFileSet fileSet = WriterFileSet.builder().directory(dir).writerGeneration(1L).addNumRows(5).addFile("merged.parquet").build();
            @Override
        MockDataFormat format = new MockDataFormat();
 * Tests demonstrating the data format plugin API lifecycle:
        MergeInput secondaryMergeInput = MergeInput.builder()
                        Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.STORED_FIELDS)
        doc2.setRowId("_row_id", 1);
        MergeInput mergeInput = MergeInput.builder().segments(List.of(seg1, seg2)).newWriterGeneration(3L).build();
        assertEquals(1, rm.readerCount());
        MockReaderManager rm = new MockReaderManager(format.name());  
        assertTrue(cap.capabilities().contains(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE));  
            public String name() {  
                    null,
                )  
        WriterFileSet fs1 = w1.flush(FlushInput.EMPTY).getWriterFileSet(format).get();
            List.of(),
        WriterFileSet fs1 = new WriterFileSet(dir.toString(), 1L, Set.of(), 10, 0L);
        MockDocumentInput d2 = indexEngine.newDocumentInput();
        // 5. Merge the two writer file sets
        // Search completes — releases the old snapshot ref  
 * SPDX-License-Identifier: Apache-2.0
        d.setRowId("_row_id", 0);
            }
        WriterFileSet wfs1 = WriterFileSet.builder().directory(dir).writerGeneration(1L).addFile("data.parquet").addNumRows(10).build();
    public void testWriteResult() {
        // Batch 1
            public long priority() {
            assertEquals(2, r2.totalRows);
        Path dir = createTempDir();  
        MockReader first = rm.getReader(snapshot);
     * Tests MergeResult with and without RowIdMapping.
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
        CatalogSnapshot snapshot1 = snapshotRef1.get();  
            List.of(),
        MockCatalogSnapshot snapshot = new MockCatalogSnapshot(1L, rr.refreshedSegments(), format);
        try (GatedCloseable<CatalogSnapshot> cr2 = manager.acquireSnapshot()) {
        assertTrue(writerFileSet.isPresent());  
    /**
     */  
        CatalogSnapshotManager manager = new CatalogSnapshotManager(
                Set.of(
            public Set<FieldTypeCapabilities> supportedFields() {
        WriteResult.Failure failure = new WriteResult.Failure(ex, -1L, -1L, -1L);  
    /**
        w.close();
            @Override
            mock(CommitFileManager.class)  
        MockDataFormat format1 = new MockDataFormat();  
 *   <li>A {@link Merger} merges multiple writer file sets into a {@link MergeResult}</li>
import static org.opensearch.index.engine.dataformat.stub.MockDataFormat.DEFAULT_MOCK_FORMAT_NAME;
        IndexingExecutionEngine<DataFormat, MockDocumentInput> engine = (IndexingExecutionEngine<DataFormat, MockDocumentInput>) plugin
}
        d1.setRowId("_row_id", 0);
        assertEquals(2, writerFileSet.get().numRows());
            @Override
            rm2.afterRefresh(true, ref.get());
 * this file be licensed under the Apache-2.0 license or a
        assertNull(plugin.getDeleteExecutionEngine(mock(org.opensearch.index.engine.exec.commit.Committer.class)));
        MockIndexingExecutionEngine indexEngine = new MockIndexingExecutionEngine(format);  
        WriterFileSet fs = w.flush(FlushInput.EMPTY).getWriterFileSet(format).get();
     */
            .segments(List.of(seg1, seg2))
import org.opensearch.index.engine.dataformat.stub.MockIndexingExecutionEngine;
    }
 *   <li>A {@link DataFormatPlugin} provides a {@link DataFormat} and creates an {@link IndexingExecutionEngine}</li>
        RefreshResult refreshResult = engine.refresh(refreshInput);
import org.opensearch.index.engine.dataformat.stub.MockDocumentInput;  
        DataFormat format2 = new DataFormat() {
        assertEquals(2, input.writerFiles().size());
     * CatalogSnapshotManager handles ref counting: acquireReader increments,  
        doc2.addField(mock(MappedFieldType.class), 30);
        RefreshInput refreshInput = RefreshInput.builder()
        }  
                        "integer",  
        }  
        WriterFileSet fs2 = w2.flush(FlushInput.EMPTY).getWriterFileSet(format).get();
    /**
import org.opensearch.index.mapper.MappedFieldType;
    /**
            public DataFormat getDataFormat() {
                .build()  
        Settings settings = Settings.builder()
        try (GatedCloseable<CatalogSnapshot> ref = manager.acquireSnapshot()) {  
        Segment seg = new Segment(0L, Map.of());  
    public void testFileInfosBuilder() {
        DataFormatPlugin plugin = MockDataFormatPlugin.of(  
import java.util.List;
        assertEquals(WriteResult.Success.class, result1.getClass());
        assertTrue(mergeResult.rowIdMapping().isPresent());
        Segment seg1 = Segment.builder(fileSet1.writerGeneration()).addSearchableFiles(format, fileSet1).build();  
    public void testRefreshEdgeCases() throws IOException {
        // 2. Create a writer and write documents  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testFileLifecycleNotifications() throws IOException {
        DataFormat format = plugin.getDataFormat();  
import org.opensearch.index.mapper.MapperService;  
     * Tests WriteResult record fields.  
        snapshotRef1.close();
     */  
        RefreshInput input = RefreshInput.builder()
        FileInfos fileInfos2 = writer2.flush(FlushInput.EMPTY);
        DataFormat format = new MockDataFormat();
            RefreshInput.builder().addSegment(Segment.builder(0L).addSearchableFiles(format, fs).build()).build()
            CatalogSnapshotDeletionPolicy.KEEP_LATEST_ONLY,
        // Snapshot1 still alive — search reader still works because the ref is held
        }
        assertEquals(fileSet, withoutMapping.getMergedWriterFileSetForDataformat(format));
        w1.addDoc(d1);  
import java.util.Optional;
            .build();
        assertEquals(WriteResult.Success.class, result2.getClass());
        assertEquals(10, infos.getWriterFileSet(format).get().numRows());
        assertTrue(rm.deletedFiles.contains("a.parquet"));
        RowIdMapping mapping = new PackedRowIdMapping(new long[] { 0 }, false);
                return null;
            assertEquals(10, r2.totalRows);
        RefreshInput empty = RefreshInput.builder().build();
    public void testDataFormatCapabilities() {
            @Override  
        w2.addDoc(d2);
        MockReader searchReader = readerManager.getReader(snapshot1);
    }
import org.opensearch.index.engine.exec.CommitFileManager;
        Segment seg2 = Segment.builder(fileSet2.writerGeneration()).addSearchableFiles(format, fileSet2).build();
     */
        assertTrue(empty.writerFilesMap().isEmpty());
                    null,  
            }  
