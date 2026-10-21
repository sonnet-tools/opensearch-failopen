        schema = new Schema(fields);
            populateMetadataFields(nextDoc);
            // A dropped child would leave the data vector as an uninitialized ZeroVector.
    public void testSchemaUpdatePropagatesAcrossRotation() throws Exception {
        ManagedVSR second = manager.getActiveManagedVSR();
     * leaked by query"). Here we buffer data into the active VSR, inject an already-failed
     * Verifies that the rowId column in the active VSR is sorted, contiguous, and
            assertEquals(2, metadata.numRows());
            manager.addDocument(doc2);
            nativeAllocator.close();
            // Wait for background write to complete using assertBusy
            manager.reconcileSchema(schemaWithMultiValue("tags"));
import org.apache.arrow.vector.types.pojo.FieldType;
                .filter(f -> f.getName().equals("tags"))
    public void testAddDocumentAfterReconcileSchemaAddsVector() throws Exception {
import org.opensearch.index.engine.dataformat.DataFormat;
        active.setRowCount(2);
        Schema schemaWithRowId = new Schema(fields);
        List<Field> fields = new ArrayList<>();
        return new Schema(fields);
            ParquetDocumentInput doc1 = new ParquetDocumentInput();
        manager.reconcileSchema(new Schema(fields));
     * Reads the rowId vector directly so it doesn't depend on the native flush.
            new FixedExecutorBuilder(
            assertEquals(ParquetField.LIST_ELEMENT_NAME, tagsField.getChildren().get(0).getName());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
            KeywordFieldMapper.KeywordFieldType tags = new KeywordFieldMapper.KeywordFieldType("tags");
        fields.addAll(metadataFields());
 * SPDX-License-Identifier: Apache-2.0
            // and leaving a ListVector with no element vector to write into.
        assertEquals(3, metadata.numRows());
        }
     * A new VSRManager can be created for a file that a previous VSRManager already opened and
        List<Field> fields = new ArrayList<>();
        KeywordFieldMapper.KeywordFieldType tag3Field = new KeywordFieldMapper.KeywordFieldType("tag3");
            doc2.setRowId(DocumentInput.ROW_ID_FIELD, 1L);
        String filePath = createTempDir().resolve("rowid-monotonic.parquet").toString();
        doc.addField(valField, 42);
        List<Field> fields = new ArrayList<>();
            // This addDocument must NOT throw — verifies the fix for the
            assertNotNull(rowIdVector);
     * pendingWrite so close() takes the throwing path, and assert the pool drains to zero.
        assignTestCapabilities(valField, PARQUET_FORMAT);
import org.apache.arrow.vector.VarCharVector;
        int end = listVector.getOffsetBuffer().getInt((long) (row + 1) * 4);
            doc1.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        String filePath = createTempDir().resolve("data.parquet").toString();
    }
        assertNull(manager.getActiveManagedVSR());
        String filePath = createTempDir().resolve("multi-value.parquet").toString();
            ParquetFileMetadata metadata = manager2.flush();
        String filePath = createTempDir().resolve("rotate.parquet").toString();
        schema = new Schema(fields);
        assertNotSame(second, third);
        ManagedVSR second = manager.getActiveManagedVSR();
        List<Field> fields = new ArrayList<>(schema.getFields());
                -1,
    }
            ListVector existingListVector = (ListVector) manager.getActiveManagedVSR().getVector("tags");
            populateMetadataFields(doc);
     * awaitPendingWrite/flush, so a background-write failure skipped it and stranded the per-VSR
        ManagedVSR third = manager.getActiveManagedVSR();
        assertNotNull(metadata);
            assertTrue(f == null || f.isDone());
        fields.add(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null));
        assignTestCapabilities(valField, PARQUET_FORMAT);
            ParquetDocumentInput doc3 = new ParquetDocumentInput();
        String filePath = createTempDir().resolve("accepted-counter.parquet").toString();
        }
        fields.addAll(metadataFields());
            ListVector listVector = (ListVector) manager.getActiveManagedVSR().getVector("tags");
    }
        );
    }
        // First writer: ingesting rotates (maxRowsPerVSR=1) and initializes the native writer.
        ManagedVSR newActive = manager.getActiveManagedVSR();
    private ArrowBufferPool bufferPool;
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, null);
     * Simulates the production mapping-update path: reconcile the active VSR with the
     * successful row admit, and decremented by {@link VSRManager#rollbackTo(long)}.
import org.opensearch.parquet.ParquetBaseTests;
        assignTestCapabilities(valField, PARQUET_FORMAT);
        manager.addDocument(doc);
        try {
            manager.addDocument(doc);
                listVector.getDataVector() instanceof VarCharVector
        assertNotNull(manager.getActiveManagedVSR());
        assertEquals(1, metadata.numRows());
        String filePath = createTempDir().resolve("reconcile-children.parquet").toString();
        } finally {
        NumberFieldMapper.NumberFieldType valField = createNumberField("val", NumberFieldMapper.NumberType.INTEGER);
    public void testMaybeRotateAtThreshold() throws Exception {
        assertNotNull(metadata);
            // leaf path "tags.list.element" — keeps the declared name.
            // field and the row is null — same as absent. Documented here so the distinction
        String filePath = createTempDir().resolve("schema-rotation.parquet").toString();
     */
        populateMetadataFields(doc);
        // background writes — verifies no error when future is still running or not yet done
        List<String> values = new ArrayList<>(end - start);
    }
            // Row 0: three values including a duplicate. Row 1: field absent entirely.
        manager1.setPendingWrite(failed);
            );
        KeywordFieldMapper.KeywordFieldType tagField = new KeywordFieldMapper.KeywordFieldType("tag");
            assertEquals(1, tagsField.getChildren().size());
        populateMetadataFields(doc);
    public void testMultiValueNumericFieldIsRejected() {
import org.opensearch.common.settings.Settings;
        }
    public void testRotationAwaitsWhenFrozenSlotOccupied() throws Exception {
        updatedFields.addAll(metadataFields());
    /**
        assertEquals(101, metadata.numRows());
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
        second.setRowCount(1);
        assertTrue("pool holds buffers before close", bufferPool.getTotalAllocatedBytes() > 0);
        assertNotNull(metadata);
        }
            assertEquals(List.of("b", "a", "b"), listElements(listVector, 0));
        manager.flush();
            vec.setSafe(i, i);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
        // New active VSR should be immediately available for writes
        super.tearDown();
        NumberFieldMapper.NumberFieldType priceField = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.INTEGER);
                assertEquals("rowId at position " + i + " must equal " + i, (long) i, rowIdVector.get(i));
        for (int i = 0; i < 100; i++) {
        // addDocument needs.
    public void testReconcileSchemaReusesUnchangedListVectorWhenAddingField() throws Exception {
    }
        failed.completeExceptionally(new RuntimeException("simulated native write failure"));
        IntVector vec = (IntVector) first.getVector("val");
        // triggers background write, waits for completion, then verifies next addDocument works
            manager.addDocument(doc2); // this would've triggerer the rotation
        String filePath = createTempDir().resolve("multi-value-empty.parquet").toString();
        bufferPool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);
        }
        assignTestCapabilities(qtyField, PARQUET_FORMAT);
            doc0.addField(tags, "a");
            ParquetFileMetadata metadata = manager.flush();
    }
        expectThrows(RuntimeException.class, manager1::close);
        ParquetDocumentInput doc = new ParquetDocumentInput();
        String filePath = createTempDir().resolve("flush-await.parquet").toString();
        // Continuously add documents across many rotations without ever waiting for
    private Schema schemaWithMultiValue(String name) {
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
            manager.close();
            doc2.setRowId(DocumentInput.ROW_ID_FIELD, 1L);
    /** Returns a copy of the test schema with one extra field appended (alongside metadata fields). */
        // Close should not throw — it should await the background write gracefully
        // Both the rotated batch (100 rows) and the flushed batch (1 row) should be in the file
        active.setRowCount(1000);
        fields.add(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null));
     * production-shaped schema (val + metadata fields) so that subsequent
            ParquetDocumentInput doc1 = new ParquetDocumentInput();
            org.apache.arrow.vector.BigIntVector rowIdVector = (org.apache.arrow.vector.BigIntVector) manager.getActiveManagedVSR()
        manager.reconcileSchema(new Schema(updatedFields));
                ParquetDocumentInput doc = new ParquetDocumentInput();
            populateMetadataFields(doc3);
            vec.setSafe(i, i);
        schema = new Schema(List.of(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null)));
                .findFirst()
        VSRManager manager2 = new VSRManager(filePath, indexSettings, schema, bufferPool, 1, threadPool, 0L);
        manager.addDocument(doc);
        assertEquals(0, second.getRowCount());
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
        for (int i = 0; i < 100; i++) {
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
            .build();
            assignTestCapabilities(tags, PARQUET_FORMAT);
                .getVector(DocumentInput.ROW_ID_FIELD);
        Settings indexSettingsBuilder = Settings.builder()
        manager.flush();
            assertEquals(List.of("solo"), listElements(listVector, 2));
    }
            assertEquals(0L, manager.getAcceptedRows());
            ListVector listVector = (ListVector) manager.getActiveManagedVSR().getVector("tags");
    }
        failed.completeExceptionally(new RuntimeException("simulated native write failure"));
        ManagedVSR original = manager.getActiveManagedVSR();
public class VSRManagerTests extends ParquetBaseTests {
import org.opensearch.parquet.writer.ParquetDocumentInput;
        List<Field> fields = new ArrayList<>(schema.getFields());
    }
        {
        assertSame(original, manager.getActiveManagedVSR());
        fields.add(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null));
                "list vector must have a typed element vector, got " + listVector.getDataVector().getClass().getSimpleName(),
        super.setUp();
            manager.addDocument(doc2);
            populateMetadataFields(doc);
                rowId++;
        java.util.concurrent.CompletableFuture<Object> failed = new java.util.concurrent.CompletableFuture<>();
        List<Field> fields = new ArrayList<>(metadataFields());
            doc0.addField(tags, "b");
            assertTrue(manager.reconcileSchema(schemaWithMultiValue("tags")));
            List<Field> expandedFields = new ArrayList<>(listSchema.getFields());
import org.opensearch.parquet.fields.core.data.number.IntegerParquetField;
        int totalDocs = lowThreshold * randomIntBetween(5, 12);
        try {
        // Add data to second VSR and flush immediately — flush must await background write
        assertEquals(1, metadata.numRows());
        ManagedVSR first = manager.getActiveManagedVSR();
    }
        // Fill and rotate to trigger background write
            for (int i = 0; i < 50; i++) {
            doc1.setRowId(DocumentInput.ROW_ID_FIELD, 1);
        ParquetDocumentInput doc = new ParquetDocumentInput();
        assertFalse(manager.isSchemaMutable());
        assignTestCapabilities(priceField, PARQUET_FORMAT);
        List<Field> fields = new ArrayList<>(schema.getFields());
            doc.setRowId(DocumentInput.ROW_ID_FIELD, i);
        reconcileMetadata(manager);
        // Simulate a mapping update: the new schema introduces a tag field. reconcileSchema
            assertEquals(new ArrowType.Utf8(), tagsField.getChildren().get(0).getType());
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(indexSettingsBuilder).build();
    public void testMultiValueFieldWritesListColumn() throws Exception {
            // exceptionNow() bug on successfully completed futures
            assignTestCapabilities(valField, PARQUET_FORMAT);
    /** Minimal schema VSRManager is constructed with; addDocument tests reconcile metadata fields in via {@link #reconcileMetadata}. */
        assertEquals(50001, metadata.numRows());
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
        manager.flush();
        reconcileMetadata(manager);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
     */
    public void testAddDocument() throws Exception {
        }
    private Schema schemaWith(String name, ArrowType type) {
        String filePath = createTempDir().resolve("init.parquet").toString();
        }
        String filePath = createTempDir().resolve("double-rotate.parquet").toString();
        IntVector vec1 = (IntVector) first.getVector("val");
            doc2.addField(valField, 2);
        String filePath = createTempDir().resolve("unknown-field.parquet").toString();
            "Field [numbers] cannot be stored as multi-valued: type [IntegerParquetField] does not support list storage",
        IntVector vec2 = (IntVector) second.getVector("val");
            doc3.addField(valField, 3);
        }
            // reconcileSchema used to rebuild each Field from name + FieldType, dropping children
        String filePath = createTempDir().resolve("continuous-add.parquet").toString();
        ManagedVSR active = manager.getActiveManagedVSR();
        // Add data to second VSR
            vec.setSafe(i, i);
            manager.addDocument(doc1);
        for (int i = start; i < end; i++) {
        first.setRowCount(100);
            populateMetadataFields(doc1);
        second.setRowCount(1);
        original.setRowCount(100);
        KeywordFieldMapper.KeywordFieldType tagField = new KeywordFieldMapper.KeywordFieldType("tag");
            }
        ParquetFileMetadata metadata = manager.flush();
        // Fill second VSR — rotation returns false while frozen slot is occupied
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
        manager.reconcileSchema(schemaWith("tag", new ArrowType.Utf8()));
            // Next doc reuses rowId 1 (the slot freed by rollback).
        vec2.setSafe(0, 999);
    }
        IntVector vec1 = (IntVector) first.getVector("val");
import org.opensearch.threadpool.FixedExecutorBuilder;
        IntVector vec2 = (IntVector) second.getVector("val");
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
        doc.addField(tag2Field, "b");
            assertNotNull(listVector);
        updatedFields.add(new Field("tag1", FieldType.nullable(new ArrowType.Utf8()), null));
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
    public void testFlushAwaitsBackgroundWrite() throws Exception {
            Future<?> f = manager1.getPendingWrite();
        fields.add(new KeywordParquetField().toArrowField(name, true));
                manager.addDocument(doc);
    @Override
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
            doc2.addField(tagField, "b");
        String filePath = createTempDir().resolve("add-doc.parquet").toString();
        vec2.setSafe(0, 42);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
    }
        assertNotNull(second);
        RuntimeException thrown = expectThrows(RuntimeException.class, manager::close);
        assertNotNull(metadata);
        terminate(threadPool);
    }
    }
    public void testCloseAwaitsBackgroundWrite() throws Exception {
            assertBusy(() -> {
            // list vector's child to "$data$" internally, but the schema — which is what
        try {
        }
            manager.addDocument(doc);
            assertSame(existingListVector, manager.getActiveManagedVSR().getVector("tags"));
            doc3.setRowId(DocumentInput.ROW_ID_FIELD, 2L);
import org.opensearch.parquet.bridge.RustBridge;
        ParquetFileMetadata metadata = manager.flush();
    public void testRotationWritesHappenOnBackgroundThread() throws Exception {
                settings,
    }
            manager.addDocument(doc1);
        );
            doc1.addField(valField, 2);
            manager.close();
        }
    }
    }
import org.opensearch.index.mapper.KeywordFieldMapper;
        manager.maybeRotateActiveVSR();
        } finally {
        fields.addAll(metadataFields());
            assertEquals(3, metadata.numRows());
        second.setRowCount(1);
        // Use a very low rotation threshold to trigger background writes frequently
            manager.addDocument(doc);
        try {
        ManagedVSR original = manager.getActiveManagedVSR();
        manager.maybeRotateActiveVSR();
import org.opensearch.threadpool.ThreadPool;
        } finally {
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
                .getFields()
    }
        IllegalArgumentException error = expectThrows(
        assertTrue(
    /**
        Schema updatedSchema = schemaWith("tag", new ArrowType.Utf8());
        }
/*
        assertEquals(VSRState.ACTIVE, second.getState());
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        manager.reconcileSchema(updatedSchema);
        IntVector vec2 = (IntVector) second.getVector("val");
    private static List<String> listElements(ListVector listVector, int row) {
            manager.addDocument(doc0);
        manager.flush();
        ManagedVSR first = manager.getActiveManagedVSR();
            ParquetDocumentInput doc = new ParquetDocumentInput();
            assertTrue(manager.reconcileSchema(new Schema(expandedFields)));
            populateMetadataFields(doc3);
import org.opensearch.index.mapper.NumberFieldMapper;
    public void testFlushWithNoDataReturnsMetadata() throws Exception {
    public void testReconcileSchemaPreservesListChildren() throws Exception {
    /**
 * compatible open source license.
            nextDoc.addField(valField, rowId);
            assertEquals(1, manager.flush().numRows());
        for (int i = 0; i < 50000; i++) {
        try {
        assignTestCapabilities(tag1Field, PARQUET_FORMAT);
                .orElseThrow();
        // Fill and rotate to trigger background write
        // Fill first VSR to trigger rotation
            populateMetadataFields(doc0);
            ParquetDocumentInput doc2 = new ParquetDocumentInput();
        // With lazy native writer init, flush returns null when no data was written
        // condition (Background VSR write failed) that used to skip vsrPool.close().
            assertEquals(2L, manager.getAcceptedRows());
        schema = new Schema(fields);
import java.util.List;
            assertEquals(1L, manager.getAcceptedRows());
            ParquetDocumentInput doc2 = new ParquetDocumentInput();
                .getSchema()
            ParquetDocumentInput doc2 = new ParquetDocumentInput();
            ParquetDocumentInput doc = new ParquetDocumentInput();
        original.setRowCount(50000);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            // between [] and absent is a deliberate, tested choice rather than an accident.
        IntVector vec = (IntVector) active.getVector("val");
import org.opensearch.parquet.engine.ParquetDataFormat;
        updatedFields.add(new Field("tag2", FieldType.nullable(new ArrowType.Utf8()), null));
        assignTestCapabilities(valField, PARQUET_FORMAT);
        // Fill first VSR to trigger rotation (async write submitted)
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
            doc0.setRowId(DocumentInput.ROW_ID_FIELD, 0);
        assertTrue(manager.isSchemaMutable());
            expandedFields.add(new Field("new_field", FieldType.nullable(new ArrowType.Utf8()), null));
        KeywordFieldMapper.KeywordFieldType tag2Field = new KeywordFieldMapper.KeywordFieldType("tag2");
            for (int i = 0; i < lowThreshold; i++) {
            }
            populateMetadataFields(doc1);
        KeywordFieldMapper.KeywordFieldType tag1Field = new KeywordFieldMapper.KeywordFieldType("tag1");
            manager.addDocument(doc3); // this would've triggerer the rotation
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
            vec1.setSafe(i, i);
            populateMetadataFields(doc1);
import org.opensearch.parquet.fields.core.data.text.KeywordParquetField;
                ParquetDocumentInput doc = new ParquetDocumentInput();
        }
    public void testAllowsDistinctFieldsInSingleDocument() throws Exception {
        // Can write to second VSR while background write may still be in progress
        String filePath = createTempDir().resolve("close-await.parquet").toString();
        for (int i = 0; i < 100; i++) {
            Schema listSchema = schemaWithMultiValue("tags");
        String filePath = createTempDir().resolve("multi-unknown.parquet").toString();
        manager.maybeRotateActiveVSR();
    public void testConstructionInitializesActiveVSR() throws Exception {
     * (awaitPendingWrite throws {@code IOException("Background VSR write failed...")}), it must still
            ParquetDocumentInput doc = new ParquetDocumentInput();
        }
        vec2.setSafe(0, 99);
        fields.addAll(metadataFields());
            doc.addField(valField, i);
        // Schema must declare __row_id__ for VSRManager to populate the column.
        String filePath = createTempDir().resolve("schema-mutable.parquet").toString();
        fields.add(new Field("qty", FieldType.nullable(new ArrowType.Int(32, true)), null));
    /** Test schema plus metadata fields plus a keyword field declared multi-valued. */
    /** Reads back the elements of one row of a list vector. */
    private Schema schema;
        // Inject an already-failed background write so close()'s awaitPendingWrite throws — the exact
        String filePath = createTempDir().resolve("bg-thread.parquet").toString();
        });
    /**
        ParquetDocumentInput doc = new ParquetDocumentInput();
     * {@code addDocument} calls find every vector they need.
    public void testAcceptedRowsCounterTracksAdmitsAndRollbacks() throws Exception {
            "close still surfaces the background-write failure",
        assertEquals("VSR pool must be released even when the background write failed", 0, bufferPool.getTotalAllocatedBytes());
        manager.addDocument(doc);
        );
    public void tearDown() throws Exception {
        try {
        bufferPool.close();
package org.opensearch.parquet.vsr;
        // rotation triggered by maxRowsPerVSR=1.
        int cycles = randomIntBetween(3, 8);
            )
        threadPool = new ThreadPool(
            }
                ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME,
        manager.flush();
            ParquetDocumentInput doc3 = new ParquetDocumentInput();
        manager.flush();
            populateMetadataFields(doc2);
                Future<?> f = manager.getPendingWrite();
        VarCharVector data = (VarCharVector) listVector.getDataVector();
        fields.addAll(metadataFields());
    }
        String filePath = createTempDir().resolve("bgwrite-fail.parquet").toString();
        VSRManager manager1 = new VSRManager(filePath, indexSettings, schema, bufferPool, 1, threadPool, 0L);
    }
        populateMetadataFields(doc);
    }
        // Flush at the end — must succeed regardless of pending write state
            assertEquals(2L, manager.getAcceptedRows());
        assignTestCapabilities(tag2Field, PARQUET_FORMAT);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, lowThreshold, threadPool, 0L);
        updatedFields.add(new Field("tag3", FieldType.nullable(new ArrowType.Utf8()), null));
import org.opensearch.cluster.metadata.IndexMetadata;
            assertTrue(
            tags.setMultiValued(true);
            for (int i = 0; i < 50; i++) {
            vec1.setSafe(i, i);
                assertTrue("Background write should complete", f == null || f.isDone());
        // Fill and rotate
        assertEquals(totalDocs, metadata.numRows());
        ParquetFileMetadata metadata = manager.flush();
        String filePath = createTempDir().resolve("bg-write-success.parquet").toString();
        String filePath = createTempDir().resolve("reconcile-list-idempotent.parquet").toString();
        // Second writer for the same file, same schema, same data: must initialize and flush cleanly.
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 1L);
                doc.setRowId(DocumentInput.ROW_ID_FIELD, rowId);
    }
import java.util.ArrayList;
        ParquetFileMetadata metadata = manager.flush();
    public void setUp() throws Exception {
        first.setRowCount(50000);
        manager.close();
     * Regression for the ingest-pool leak: when {@code close()} fails to drain a background write
            Field tagsField = manager.getActiveManagedVSR()
        first.setRowCount(100);
        try {
            doc0.addField(tags, "b");
        ParquetFileMetadata metadata = manager.flush();
        nativeAllocator = new ArrowNativeAllocator();
        assertNull(metadata);
            values.add(new String(data.get(i), StandardCharsets.UTF_8));
        manager.addDocument(doc);
        populateMetadataFields(doc);
            () -> new IntegerParquetField().toArrowField("numbers", true)
    public void testMaybeRotateNoOpBelowThreshold() throws Exception {
        fields.addAll(metadataFields());
            populateMetadataFields(doc2);
    }
        if (nativeAllocator != null) {
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
     * Verifies that {@link VSRManager#getAcceptedRows} is incremented only after a
     * closed, ingest the same data, and flush successfully.
        ManagedVSR first = manager.getActiveManagedVSR();
        doc.addField(qtyField, 5);
                doc.setRowId(DocumentInput.ROW_ID_FIELD, (long) i);
        ManagedVSR second = manager.getActiveManagedVSR();
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
    public void testReinitializeForSameFileAfterClose() throws Exception {
            settings,
        assignTestCapabilities(valField, PARQUET_FORMAT);
            // Mapping update introduces a keyword field declared multi-valued, so it arrives as a
            doc.addField(valField, i);
        assertNotNull(metadata);
        doc.setRowId("__row_id__", 0);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 1L);
    }
        for (int i = 0; i < 2; i++) {
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, lowThreshold, threadPool, 0L);
    @Override
            doc1.addField(valField, 1);
                manager.addDocument(doc);
        assertNotSame(first, second);
            rowId++;
    }
}
            NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        ParquetFileMetadata metadata = manager.flush();
            doc2.setRowId(DocumentInput.ROW_ID_FIELD, 2);
            IllegalArgumentException.class,
     */
    public void testRowIdColumnIsSortedAndContiguous() throws Exception {
            nextDoc.setRowId(DocumentInput.ROW_ID_FIELD, rowId);
        doc.addField(valField, 42);
        Thread.sleep(500);
        String filePath = createTempDir().resolve("empty.parquet").toString();
    }
            NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        manager.flush();
        vec.setSafe(1, 20);
        Settings settings = Settings.builder().put("node.name", "vsrmanager-test").build();
            doc1.addField(tagField, "a");
        }
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 1, threadPool, 1L);
            assertNotNull(metadata);
    }
        fields.add(new Field(name, FieldType.nullable(type), null));
        second.setRowCount(100);
        assertEquals(1, manager.getActiveManagedVSR().getRowCount());
    public void testAddDocumentAfterSuccessfulBackgroundWriteDoesNotThrow() throws Exception {
        }
        manager.maybeRotateActiveVSR();
    private void reconcileMetadata(VSRManager manager) {
        vec.setSafe(0, 10);
        {
            });
        } finally {
        // Close via the failing background-write path so flush() is skipped and cleanup() runs in the finally.
        assertEquals(VSRState.ACTIVE, newActive.getState());
    }
            thrown.getMessage() != null && thrown.getMessage().contains("Failed to close VSRManager")
        List<Field> updatedFields = new ArrayList<>(schema.getFields());
        assignTestCapabilities(valField, PARQUET_FORMAT);
        }
            manager.rollbackTo(1L);
        doc.addField(priceField, 10);
import org.opensearch.index.engine.dataformat.DocumentInput;
        NumberFieldMapper.NumberFieldType valField = createNumberField("val", NumberFieldMapper.NumberType.INTEGER);
        reconcileMetadata(manager);
        doc.addField(tag1Field, "a");
        String filePath = createTempDir().resolve("norotate.parquet").toString();
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
 */
        } finally {
            doc3.addField(tagField, "c");
    /**
        manager.maybeRotateActiveVSR();
     * starts at 0 — the per-flush invariant that protects cross-format correlation.
        fields.addAll(metadataFields());
            doc3.setRowId(DocumentInput.ROW_ID_FIELD, 1L);
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        }
                populateMetadataFields(doc);
            // An explicit "tags": [] parses to zero addField calls, so the writer never sees the
            ingest(manager2);
        }
        schema = new Schema(fields);
            doc2.addField(valField, 3);
    }
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
        manager.maybeRotateActiveVSR();
import org.apache.arrow.vector.types.pojo.ArrowType;
        assignTestCapabilities(tag3Field, PARQUET_FORMAT);
        manager.addDocument(doc);
        doc.addField(tagField, "hello");
    }
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 1L);
            // Assert on the VSR *schema* rather than the vector's own field: Arrow Java renames a
        assertNotNull(metadata);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        IntVector vec2 = (IntVector) second.getVector("val");
        } finally {
            doc2.addField(tags, "solo");
import org.apache.arrow.vector.types.pojo.Field;
     */
        fields.add(new Field(DocumentInput.ROW_ID_FIELD, FieldType.nullable(new ArrowType.Int(64, true)), null));
            // exportSchema hands to the native writer, and therefore what determines the Parquet
            vec.setSafe(i, i);
     * release the VSR pool. The pre-fix close() called {@code vsrPool.close()} only after
            doc.addField(valField, 1);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(2, metadata.numRows());
        doc.addField(valField, 1);
    private void ingest(VSRManager manager) throws Exception {
        doc.addField(tag3Field, "c");
            ListVector listVector = (ListVector) manager.getActiveManagedVSR().getVector("tags");
    public void testMultiValueFieldWritesEmptyListDistinctFromAbsent() throws Exception {
        int lowThreshold = randomIntBetween(2, 5);
            doc0.addField(valField, 1);
                .stream()
        String filePath = createTempDir().resolve("recovery-reinit.parquet").toString();
        for (int i = 0; i < totalDocs; i++) {
        int lowThreshold = randomIntBetween(2, 4);
        assertEquals(1, metadata.numRows());
            assertTrue(listVector.isNull(0));
        return new Schema(fields);
        ingest(manager1);
            doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
        // adds the missing vector to the active VSR before addDocument runs.
        ParquetFileMetadata metadata = manager.flush();
            ParquetDocumentInput nextDoc = new ParquetDocumentInput();
import org.opensearch.parquet.bridge.ParquetFileMetadata;
        ManagedVSR first = manager.getActiveManagedVSR();
        assertEquals(
        assertEquals(1, manager.getActiveManagedVSR().getRowCount());
            manager.addDocument(nextDoc);
            // LIST<Utf8> rather than a flat Utf8 column.
        java.util.concurrent.CompletableFuture<Object> failed = new java.util.concurrent.CompletableFuture<>();
        ParquetDocumentInput doc = new ParquetDocumentInput();
        IntVector vec = (IntVector) active.getVector("val");
        IntVector vec = (IntVector) first.getVector("val");
    public void testIsSchemaMutableBeforeAndAfterFlush() throws Exception {
        for (int i = 0; i < 100; i++) {
import org.opensearch.parquet.ParquetDataFormatPlugin;
            ParquetDocumentInput doc0 = new ParquetDocumentInput();
     */
            doc1.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        assertEquals(101, metadata.numRows());
            assertNotNull(manager.getActiveManagedVSR().getVector("new_field"));
        VSRManager manager = new VSRManager(filePath, indexSettings, schemaWithRowId, bufferPool, 50000, threadPool, 0L);
            assertEquals(1L, manager.getAcceptedRows());
    private ThreadPool threadPool;
        );
        for (int cycle = 0; cycle < cycles; cycle++) {
        indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        int start = listVector.getOffsetBuffer().getInt((long) row * 4);
        assignTestCapabilities(tagField, PARQUET_FORMAT);
        manager.maybeRotateActiveVSR();
    }
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
        // Materialize buffers on the active VSR's child allocator so the pool holds bytes.
        }
        String filePath = createTempDir().resolve("distinct.parquet").toString();
        doc.addField(valField, 1);
    public void testFlushWithData() throws Exception {
            manager.close();
            manager.addDocument(doc3);
    private ArrowNativeAllocator nativeAllocator;
import org.opensearch.Version;
            assertTrue(manager.reconcileSchema(listSchema));
import java.util.concurrent.Future;
            manager2.close();
        assertNotSame(original, newActive);
    /** Reconciles the metadata fields and ingests two documents via {@link VSRManager#addDocument}. */
import org.apache.arrow.vector.types.pojo.Schema;
                doc.addField(valField, rowId);
        populateMetadataFields(doc);
        fields.add(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null));
            vec2.setSafe(i, i + 100);
        }
                "thread_pool." + ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME
        for (int i = 0; i < 1000; i++) {
        for (int i = 0; i < 100; i++) {
    public void testReconcileSchemaAddsMultipleVectorsAtOnce() throws Exception {
        ParquetFileMetadata metadata = manager.flush();
    private static final DataFormat PARQUET_FORMAT = new ParquetDataFormat();
        first.setRowCount(100);
            manager.close();
        // Run multiple rotation cycles — each cycle fills the VSR to threshold,
import org.opensearch.parquet.fields.ParquetField;
            assertEquals(ArrowType.List.INSTANCE, tagsField.getType());
        assertBusy(() -> {
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
        ParquetFileMetadata metadata = manager.flush();
        manager.close();
import org.opensearch.index.IndexSettings;
            // Row 2: a single value. Covers the three cardinalities in one file.
        IntVector vec = (IntVector) first.getVector("val");
    public void testContinuousAddDocumentAcrossMultipleRotationsWithoutWaiting() throws Exception {
        // Add all docs in a tight loop — no waiting between rotations
            nativeAllocator = null;
            populateMetadataFields(doc);
        ManagedVSR first = manager.getActiveManagedVSR();
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
        {
        RustBridge.initLogger();
        int rowId = 0;
        NumberFieldMapper.NumberFieldType qtyField = new NumberFieldMapper.NumberFieldType("qty", NumberFieldMapper.NumberType.INTEGER);
        assertEquals(VSRState.ACTIVE, manager.getActiveManagedVSR().getState());
import org.opensearch.parquet.memory.ArrowBufferPool;
    }
            doc.setRowId(DocumentInput.ROW_ID_FIELD, i);
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        ManagedVSR active = manager.getActiveManagedVSR();
            assertNotNull(metadata);
        String filePath = createTempDir().resolve("rotate-flush.parquet").toString();
        List<Field> fields = new ArrayList<>();
        assignTestCapabilities(tagField, PARQUET_FORMAT);
        // flush handles freeze + close internally
        // Single reconcileSchema call adds three vectors plus the metadata fields the next
    private IndexSettings indexSettings;
        assertNotNull(metadata);
 *
            assignTestCapabilities(valField, PARQUET_FORMAT);
        ParquetDocumentInput doc = new ParquetDocumentInput();
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
            error.getMessage()
            manager.close();
    }
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        first.setRowCount(100);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
            ParquetDocumentInput doc1 = new ParquetDocumentInput();
 * The OpenSearch Contributors require contributions made to
            assertTrue("absent field must read back as a null list", listVector.isNull(1));
import java.nio.charset.StandardCharsets;
import org.apache.arrow.vector.IntVector;
        ManagedVSR second = manager.getActiveManagedVSR();
        // Wait for background write to complete, then rotation should succeed
        } finally {
        manager.setPendingWrite(failed);
            manager.close();
        // Reconcile once before any docs — the tag vector must persist across the VSR
    public void testCloseReleasesPoolWhenBackgroundWriteFailed() throws Exception {
    public void testFlushAfterRotation() throws Exception {
                1,
        manager.maybeRotateActiveVSR();
        assertEquals(VSRState.ACTIVE, third.getState());
            manager.reconcileSchema(schemaWithMultiValue("tags"));
        ParquetFileMetadata metadata = manager.flush();
                populateMetadataFields(doc);
        return values;
            manager.addDocument(doc1);
import org.apache.arrow.vector.complex.ListVector;
        }
        fields.add(new Field("price", FieldType.nullable(new ArrowType.Int(32, true)), null));
        assertNotNull(metadata);
            populateMetadataFields(doc2);
     * child allocators' off-heap buffers on the ingest pool for the node's lifetime ("Memory was
