            // field and the row is null — same as absent. Documented here so the distinction  
        int rowId = 0;  
        IntVector vec = (IntVector) first.getVector("val");
        super.tearDown();
        KeywordFieldMapper.KeywordFieldType tag1Field = new KeywordFieldMapper.KeywordFieldType("tag1");  
import org.opensearch.parquet.engine.ParquetDataFormat;
            doc2.setRowId(DocumentInput.ROW_ID_FIELD, 2);
        bufferPool.close();
    }
        assertTrue("pool holds buffers before close", bufferPool.getTotalAllocatedBytes() > 0);
            manager.addDocument(doc3);
            ParquetDocumentInput doc = new ParquetDocumentInput();
        first.setRowCount(100);  
            }  
        String filePath = createTempDir().resolve("reconcile-list-idempotent.parquet").toString();
        updatedFields.addAll(metadataFields());
            assertEquals(1L, manager.getAcceptedRows());
                settings,
        NumberFieldMapper.NumberFieldType valField = createNumberField("val", NumberFieldMapper.NumberType.INTEGER);
        ParquetFileMetadata metadata = manager.flush();
        manager.setPendingWrite(failed);
        String filePath = createTempDir().resolve("data.parquet").toString();
        manager.flush();  
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
        IntVector vec2 = (IntVector) second.getVector("val");
        assignTestCapabilities(valField, PARQUET_FORMAT);
        }
        int start = listVector.getOffsetBuffer().getInt((long) row * 4);
        assertNotNull(metadata);
                ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME,  
            manager.close();  
        ManagedVSR first = manager.getActiveManagedVSR();  
        String filePath = createTempDir().resolve("rotate-flush.parquet").toString();
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);  
                assertTrue("Background write should complete", f == null || f.isDone());
            assertEquals(List.of("solo"), listElements(listVector, 2));  
        String filePath = createTempDir().resolve("reconcile-children.parquet").toString();
                .orElseThrow();  
        active.setRowCount(1000);  
            // exportSchema hands to the native writer, and therefore what determines the Parquet
        ManagedVSR active = manager.getActiveManagedVSR();
        second.setRowCount(1);  
                manager.addDocument(doc);
    private static final DataFormat PARQUET_FORMAT = new ParquetDataFormat();
        // condition (Background VSR write failed) that used to skip vsrPool.close().
        assertEquals(0, second.getRowCount());
        }
        fields.add(new Field("price", FieldType.nullable(new ArrowType.Int(32, true)), null));  
        // Wait for background write to complete, then rotation should succeed
            doc.setRowId(DocumentInput.ROW_ID_FIELD, i);
        fields.add(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null));  
        updatedFields.add(new Field("tag1", FieldType.nullable(new ArrowType.Utf8()), null));  
            ParquetFileMetadata metadata = manager.flush();
            populateMetadataFields(doc);  
            manager.close();  
        original.setRowCount(50000);  
        assertEquals(totalDocs, metadata.numRows());  
        ingest(manager1);  
            ParquetDocumentInput doc0 = new ParquetDocumentInput();
            nativeAllocator = null;
            }  
        // Simulate a mapping update: the new schema introduces a tag field. reconcileSchema
import org.opensearch.parquet.ParquetDataFormatPlugin;
            assertEquals(2L, manager.getAcceptedRows());
        manager.maybeRotateActiveVSR();
            manager.addDocument(doc1);  
        // Fill and rotate to trigger background write  
        manager.addDocument(doc);  
        manager.close();
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
        assertEquals(1, metadata.numRows());
        // addDocument needs.  
        VarCharVector data = (VarCharVector) listVector.getDataVector();  
        assertEquals(  
        ManagedVSR second = manager.getActiveManagedVSR();
            for (int i = 0; i < 50; i++) {
        // Add all docs in a tight loop — no waiting between rotations  
        assertNotNull(manager.getActiveManagedVSR());
        assignTestCapabilities(qtyField, PARQUET_FORMAT);
            assertEquals(new ArrowType.Utf8(), tagsField.getChildren().get(0).getType());
        RuntimeException thrown = expectThrows(RuntimeException.class, manager::close);  
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, lowThreshold, threadPool, 0L);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
        }
        manager.addDocument(doc);
        ManagedVSR second = manager.getActiveManagedVSR();
        // Continuously add documents across many rotations without ever waiting for
import org.apache.arrow.vector.VarCharVector;
        reconcileMetadata(manager);
        String filePath = createTempDir().resolve("multi-value-empty.parquet").toString();
    /**
        fields.add(new Field("qty", FieldType.nullable(new ArrowType.Int(32, true)), null));
            // Wait for background write to complete using assertBusy
        manager.flush();
        // Inject an already-failed background write so close()'s awaitPendingWrite throws — the exact  
        vec2.setSafe(0, 42);
    public void setUp() throws Exception {
    }  
        List<Field> fields = new ArrayList<>(schema.getFields());  
        String filePath = createTempDir().resolve("bg-write-success.parquet").toString();  
        reconcileMetadata(manager);
        fields.add(new KeywordParquetField().toArrowField(name, true));  
                "list vector must have a typed element vector, got " + listVector.getDataVector().getClass().getSimpleName(),
        ParquetDocumentInput doc = new ParquetDocumentInput();
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
        String filePath = createTempDir().resolve("add-doc.parquet").toString();
            ListVector listVector = (ListVector) manager.getActiveManagedVSR().getVector("tags");
            // Assert on the VSR *schema* rather than the vector's own field: Arrow Java renames a
     * release the VSR pool. The pre-fix close() called {@code vsrPool.close()} only after
    public void tearDown() throws Exception {  
        vec2.setSafe(0, 999);
            doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
            assertBusy(() -> {  
    public void testAddDocumentAfterReconcileSchemaAddsVector() throws Exception {
        );
        doc.addField(qtyField, 5);  
import org.opensearch.Version;
        List<Field> updatedFields = new ArrayList<>(schema.getFields());
        }
            .build();
 */  
        ParquetDocumentInput doc = new ParquetDocumentInput();
            for (int i = 0; i < lowThreshold; i++) {
        return values;
    private void reconcileMetadata(VSRManager manager) {
    public void testFlushWithNoDataReturnsMetadata() throws Exception {
import org.apache.arrow.vector.types.pojo.Schema;
        }
        doc.addField(priceField, 10);
    }
        // Use a very low rotation threshold to trigger background writes frequently  
        assignTestCapabilities(tagField, PARQUET_FORMAT);
    private void ingest(VSRManager manager) throws Exception {  
    }
            "Field [numbers] cannot be stored as multi-valued: type [IntegerParquetField] does not support list storage",
        for (int i = 0; i < 2; i++) {
    public void testIsSchemaMutableBeforeAndAfterFlush() throws Exception {
        NumberFieldMapper.NumberFieldType qtyField = new NumberFieldMapper.NumberFieldType("qty", NumberFieldMapper.NumberType.INTEGER);
    public void testReconcileSchemaAddsMultipleVectorsAtOnce() throws Exception {
            // A dropped child would leave the data vector as an uninitialized ZeroVector.
        }
        ManagedVSR first = manager.getActiveManagedVSR();
        assertEquals(101, metadata.numRows());
import org.opensearch.parquet.ParquetBaseTests;  
            doc2.addField(valField, 3);
    }
        }
        first.setRowCount(100);
        java.util.concurrent.CompletableFuture<Object> failed = new java.util.concurrent.CompletableFuture<>();  
    /** Returns a copy of the test schema with one extra field appended (alongside metadata fields). */
import org.opensearch.parquet.fields.core.data.text.KeywordParquetField;
    }
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.mapper.KeywordFieldMapper;
        schema = new Schema(fields);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
        assignTestCapabilities(tag3Field, PARQUET_FORMAT);  
        // Second writer for the same file, same schema, same data: must initialize and flush cleanly.
            NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
            assertNotNull(rowIdVector);
        ParquetFileMetadata metadata = manager.flush();  
        assertNotNull(metadata);
        assertEquals(VSRState.ACTIVE, second.getState());  
import org.opensearch.cluster.metadata.IndexMetadata;
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 1L);  
        ParquetDocumentInput doc = new ParquetDocumentInput();  
            assignTestCapabilities(valField, PARQUET_FORMAT);  
import java.nio.charset.StandardCharsets;
    }  
        assignTestCapabilities(valField, PARQUET_FORMAT);  
            ParquetDocumentInput doc = new ParquetDocumentInput();
                assertEquals("rowId at position " + i + " must equal " + i, (long) i, rowIdVector.get(i));  
        assignTestCapabilities(valField, PARQUET_FORMAT);  
        assertEquals(1, metadata.numRows());
            populateMetadataFields(doc2);
    public void testRotationAwaitsWhenFrozenSlotOccupied() throws Exception {  
            NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);  
            doc2.addField(tagField, "b");
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);
        fields.addAll(metadataFields());
            assertEquals(1, manager.flush().numRows());
        indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);  
            populateMetadataFields(doc1);  
            manager.addDocument(doc2); // this would've triggerer the rotation  
        // Fill first VSR to trigger rotation (async write submitted)
    /** Reads back the elements of one row of a list vector. */
            nativeAllocator.close();
        try {  
        assertNotNull(metadata);  
    public void testCloseReleasesPoolWhenBackgroundWriteFailed() throws Exception {
            populateMetadataFields(doc3);
            doc3.setRowId(DocumentInput.ROW_ID_FIELD, 1L);  
        Settings indexSettingsBuilder = Settings.builder()  
            assignTestCapabilities(tags, PARQUET_FORMAT);
    }
     * Simulates the production mapping-update path: reconcile the active VSR with the
            rowId++;  
        String filePath = createTempDir().resolve("unknown-field.parquet").toString();
        String filePath = createTempDir().resolve("multi-unknown.parquet").toString();
        String filePath = createTempDir().resolve("norotate.parquet").toString();
    public void testMultiValueNumericFieldIsRejected() {
        ManagedVSR active = manager.getActiveManagedVSR();
        String filePath = createTempDir().resolve("double-rotate.parquet").toString();
        populateMetadataFields(doc);  
                .getSchema()
        // Schema must declare __row_id__ for VSRManager to populate the column.  
    public void testAddDocumentAfterSuccessfulBackgroundWriteDoesNotThrow() throws Exception {
        KeywordFieldMapper.KeywordFieldType tag2Field = new KeywordFieldMapper.KeywordFieldType("tag2");
import java.util.concurrent.Future;
        String filePath = createTempDir().resolve("distinct.parquet").toString();
            manager.close();
            assertNotNull(metadata);  
        IntVector vec = (IntVector) first.getVector("val");
        assertTrue(manager.isSchemaMutable());
    private ArrowNativeAllocator nativeAllocator;  
        second.setRowCount(1);  
            // This addDocument must NOT throw — verifies the fix for the
        assertNotNull(metadata);  
            vec.setSafe(i, i);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 1, threadPool, 1L);
        }
        String filePath = createTempDir().resolve("schema-rotation.parquet").toString();
        String filePath = createTempDir().resolve("schema-mutable.parquet").toString();  
        Settings settings = Settings.builder().put("node.name", "vsrmanager-test").build();
     * Verifies that the rowId column in the active VSR is sorted, contiguous, and  
                populateMetadataFields(doc);
     */
        expectThrows(RuntimeException.class, manager1::close);  
        KeywordFieldMapper.KeywordFieldType tag3Field = new KeywordFieldMapper.KeywordFieldType("tag3");
    /**  
            doc0.addField(valField, 1);
            nextDoc.setRowId(DocumentInput.ROW_ID_FIELD, rowId);
    }
        populateMetadataFields(doc);
    public void testConstructionInitializesActiveVSR() throws Exception {
        manager.flush();
 * compatible open source license.
import org.opensearch.parquet.bridge.RustBridge;  
            populateMetadataFields(doc0);  
    public void testCloseAwaitsBackgroundWrite() throws Exception {
            // and leaving a ListVector with no element vector to write into.
     * closed, ingest the same data, and flush successfully.
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 1L);  
        // With lazy native writer init, flush returns null when no data was written
     */
            manager.addDocument(doc2);
            KeywordFieldMapper.KeywordFieldType tags = new KeywordFieldMapper.KeywordFieldType("tags");  
    }
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        String filePath = createTempDir().resolve("multi-value.parquet").toString();
                "thread_pool." + ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        return new Schema(fields);
        List<Field> fields = new ArrayList<>(schema.getFields());
    @Override
            doc.setRowId(DocumentInput.ROW_ID_FIELD, i);
 *
        } finally {
        manager.addDocument(doc);  
        doc.setRowId("__row_id__", 0);  
    @Override
        IntVector vec1 = (IntVector) first.getVector("val");  
        } finally {  
            // Row 0: three values including a duplicate. Row 1: field absent entirely.  
        // adds the missing vector to the active VSR before addDocument runs.  
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);  
        {  
            ParquetDocumentInput doc2 = new ParquetDocumentInput();
        // Single reconcileSchema call adds three vectors plus the metadata fields the next
            assignTestCapabilities(valField, PARQUET_FORMAT);
        assertEquals(1, manager.getActiveManagedVSR().getRowCount());  
            Field tagsField = manager.getActiveManagedVSR()  
        int lowThreshold = randomIntBetween(2, 4);  
        NumberFieldMapper.NumberFieldType valField = createNumberField("val", NumberFieldMapper.NumberType.INTEGER);
        assignTestCapabilities(tag1Field, PARQUET_FORMAT);
    }
        ManagedVSR second = manager.getActiveManagedVSR();
            assertEquals(ParquetField.LIST_ELEMENT_NAME, tagsField.getChildren().get(0).getName());  
        ParquetFileMetadata metadata = manager.flush();
import org.apache.arrow.vector.IntVector;
import org.opensearch.threadpool.FixedExecutorBuilder;
            manager.addDocument(doc0);  
        schema = new Schema(fields);
            doc.addField(valField, i);
        String filePath = createTempDir().resolve("bgwrite-fail.parquet").toString();  
        int lowThreshold = randomIntBetween(2, 5);
        // Both the rotated batch (100 rows) and the flushed batch (1 row) should be in the file
            populateMetadataFields(doc);  
            populateMetadataFields(nextDoc);
            // between [] and absent is a deliberate, tested choice rather than an accident.
     * (awaitPendingWrite throws {@code IOException("Background VSR write failed...")}), it must still
        ManagedVSR first = manager.getActiveManagedVSR();
        VSRManager manager = new VSRManager(filePath, indexSettings, schemaWithRowId, bufferPool, 50000, threadPool, 0L);
    }
    }  
        assignTestCapabilities(tagField, PARQUET_FORMAT);
            ParquetDocumentInput doc1 = new ParquetDocumentInput();
        assertNotNull(metadata);  
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(indexSettingsBuilder).build();
            doc0.addField(tags, "b");
            IllegalArgumentException.class,  
        schema = new Schema(List.of(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null)));
    public void testMultiValueFieldWritesEmptyListDistinctFromAbsent() throws Exception {  
        List<String> values = new ArrayList<>(end - start);
    }  
                ParquetDocumentInput doc = new ParquetDocumentInput();
        doc.addField(valField, 42);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        try {  
        assertEquals(50001, metadata.numRows());  
        RustBridge.initLogger();
            ParquetFileMetadata metadata = manager2.flush();  
        ParquetFileMetadata metadata = manager.flush();
import org.apache.arrow.vector.complex.ListVector;  
        }
    }  
        java.util.concurrent.CompletableFuture<Object> failed = new java.util.concurrent.CompletableFuture<>();
            expandedFields.add(new Field("new_field", FieldType.nullable(new ArrowType.Utf8()), null));
        });
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
            for (int i = 0; i < 50; i++) {
        List<Field> fields = new ArrayList<>();
        {  
        for (int i = start; i < end; i++) {
        assignTestCapabilities(valField, PARQUET_FORMAT);  
            manager.reconcileSchema(schemaWithMultiValue("tags"));
        IntVector vec = (IntVector) first.getVector("val");
    /** Reconciles the metadata fields and ingests two documents via {@link VSRManager#addDocument}. */
    public void testMultiValueFieldWritesListColumn() throws Exception {
            manager.addDocument(nextDoc);
        // Close via the failing background-write path so flush() is skipped and cleanup() runs in the finally.
                populateMetadataFields(doc);  
        reconcileMetadata(manager);
        }
            assertEquals(3, metadata.numRows());
import org.apache.arrow.vector.types.pojo.Field;
        manager.flush();
            assertTrue(  
        for (int cycle = 0; cycle < cycles; cycle++) {
        } finally {
            assertTrue(f == null || f.isDone());  
    /**
            manager.addDocument(doc);  
     * starts at 0 — the per-flush invariant that protects cross-format correlation.
            assertTrue(manager.reconcileSchema(new Schema(expandedFields)));  
        assertNotNull(metadata);
        // Fill second VSR — rotation returns false while frozen slot is occupied
        vec.setSafe(0, 10);  
    public void testMaybeRotateAtThreshold() throws Exception {
     * Reads the rowId vector directly so it doesn't depend on the native flush.
            doc0.addField(tags, "a");
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        assertNotNull(metadata);  
        vec2.setSafe(0, 99);
        assertEquals(1, manager.getActiveManagedVSR().getRowCount());
    }
        } finally {  
        IntVector vec2 = (IntVector) second.getVector("val");  
        String filePath = createTempDir().resolve("empty.parquet").toString();
import java.util.List;  
            assertEquals(1L, manager.getAcceptedRows());
        for (int i = 0; i < 100; i++) {
     * production-shaped schema (val + metadata fields) so that subsequent
        );
        List<Field> fields = new ArrayList<>();
        fields.add(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null));
        for (int i = 0; i < 100; i++) {  
            assertEquals(2L, manager.getAcceptedRows());
    }  
                ParquetDocumentInput doc = new ParquetDocumentInput();  
            tags.setMultiValued(true);
        // Add data to second VSR
            settings,  
        ManagedVSR second = manager.getActiveManagedVSR();  
        manager.close();
        // First writer: ingesting rotates (maxRowsPerVSR=1) and initializes the native writer.
        fields.addAll(metadataFields());
            assertTrue("absent field must read back as a null list", listVector.isNull(1));
        fields.addAll(metadataFields());  
        vec.setSafe(1, 20);
        nativeAllocator.getOrCreatePool(NativeAllocatorPoolConfig.POOL_INGEST, 0L, Long.MAX_VALUE, null);  
        assertEquals(3, metadata.numRows());
            assertEquals(ArrowType.List.INSTANCE, tagsField.getType());
package org.opensearch.parquet.vsr;
        );
     * successful row admit, and decremented by {@link VSRManager#rollbackTo(long)}.  
        fields.addAll(metadataFields());
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);  
        ParquetFileMetadata metadata = manager.flush();
        // Reconcile once before any docs — the tag vector must persist across the VSR  
        assertEquals(VSRState.ACTIVE, manager.getActiveManagedVSR().getState());
import org.opensearch.index.engine.dataformat.DocumentInput;  
        // Run multiple rotation cycles — each cycle fills the VSR to threshold,  
        Schema schemaWithRowId = new Schema(fields);
        ManagedVSR first = manager.getActiveManagedVSR();
        VSRManager manager1 = new VSRManager(filePath, indexSettings, schema, bufferPool, 1, threadPool, 0L);
        doc.addField(tag2Field, "b");
        // flush handles freeze + close internally  
     */
        assertEquals(VSRState.ACTIVE, newActive.getState());
            assertTrue(manager.reconcileSchema(schemaWithMultiValue("tags")));
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);  
        manager.addDocument(doc);  
    private Schema schemaWithMultiValue(String name) {  
                1,
     */  
            manager.addDocument(doc);  
            assertTrue(listVector.isNull(0));  
        ParquetDocumentInput doc = new ParquetDocumentInput();  
        second.setRowCount(1);
        manager.reconcileSchema(schemaWith("tag", new ArrowType.Utf8()));
        fields.add(new Field(name, FieldType.nullable(type), null));
        fields.addAll(metadataFields());
        }
    public void testAddDocument() throws Exception {
            doc1.setRowId(DocumentInput.ROW_ID_FIELD, 0L);  
        original.setRowCount(100);
            manager.addDocument(doc2);  
            doc1.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
        threadPool = new ThreadPool(
        // New active VSR should be immediately available for writes  
        updatedFields.add(new Field("tag3", FieldType.nullable(new ArrowType.Utf8()), null));
            ParquetDocumentInput doc2 = new ParquetDocumentInput();  
            doc2.addField(tags, "solo");  
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
            "close still surfaces the background-write failure",
 * this file be licensed under the Apache-2.0 license or a
        } finally {  
                doc.setRowId(DocumentInput.ROW_ID_FIELD, rowId);  
            // Row 2: a single value. Covers the three cardinalities in one file.
        manager.flush();
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);  
        assertNotSame(first, second);
        }
            () -> new IntegerParquetField().toArrowField("numbers", true)
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 1L);
        manager.flush();
        }
                .getVector(DocumentInput.ROW_ID_FIELD);  
        ParquetFileMetadata metadata = manager.flush();
        schema = new Schema(fields);
        }
        for (int i = 0; i < 100; i++) {  
        Schema updatedSchema = schemaWith("tag", new ArrowType.Utf8());
            assertTrue(manager.reconcileSchema(listSchema));  
            assertNotNull(manager.getActiveManagedVSR().getVector("new_field"));
            manager.reconcileSchema(schemaWithMultiValue("tags"));
            assertNotNull(metadata);
    }
    }  
        ParquetFileMetadata metadata = manager.flush();
        bufferPool = new ArrowBufferPool(Settings.EMPTY, nativeAllocator);
        assertEquals(2, metadata.numRows());  
        manager.flush();  
            vec.setSafe(i, i);
        // Can write to second VSR while background write may still be in progress  
        VSRManager manager2 = new VSRManager(filePath, indexSettings, schema, bufferPool, 1, threadPool, 0L);  
    }  
        fields.add(new Field(DocumentInput.ROW_ID_FIELD, FieldType.nullable(new ArrowType.Int(64, true)), null));  
    }  
        populateMetadataFields(doc);  
        int end = listVector.getOffsetBuffer().getInt((long) (row + 1) * 4);
        nativeAllocator = new ArrowNativeAllocator();
        doc.addField(valField, 42);
        List<Field> fields = new ArrayList<>();  
        ParquetDocumentInput doc = new ParquetDocumentInput();
            ParquetDocumentInput doc2 = new ParquetDocumentInput();
                .findFirst()
        String filePath = createTempDir().resolve("bg-thread.parquet").toString();  
            doc2.addField(valField, 2);
        doc.addField(tag3Field, "c");
 * SPDX-License-Identifier: Apache-2.0
import org.apache.arrow.vector.types.pojo.ArrowType;
        ManagedVSR original = manager.getActiveManagedVSR();
        fields.addAll(metadataFields());
     * child allocators' off-heap buffers on the ingest pool for the node's lifetime ("Memory was
import org.apache.arrow.vector.types.pojo.FieldType;  
        for (int i = 0; i < 1000; i++) {  
        try {
     */  
        try {
        assertNotSame(original, newActive);
            );  
/*  
    /** Minimal schema VSRManager is constructed with; addDocument tests reconcile metadata fields in via {@link #reconcileMetadata}. */
        ManagedVSR newActive = manager.getActiveManagedVSR();  
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
            assertEquals(2, metadata.numRows());
        // Add data to second VSR and flush immediately — flush must await background write
        ParquetFileMetadata metadata = manager.flush();
    private ArrowBufferPool bufferPool;
    /** Test schema plus metadata fields plus a keyword field declared multi-valued. */
            vec2.setSafe(i, i + 100);
        // Fill and rotate  
            ParquetDocumentInput doc1 = new ParquetDocumentInput();
        for (int i = 0; i < 50000; i++) {
        IntVector vec1 = (IntVector) first.getVector("val");  
    public void testContinuousAddDocumentAcrossMultipleRotationsWithoutWaiting() throws Exception {  
     * Verifies that {@link VSRManager#getAcceptedRows} is incremented only after a
            populateMetadataFields(doc2);
        manager.maybeRotateActiveVSR();  
        doc.addField(tagField, "hello");  
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
        ParquetFileMetadata metadata = manager.flush();  
    private static List<String> listElements(ListVector listVector, int row) {  
    private Schema schema;  
                Future<?> f = manager.getPendingWrite();
        assertNull(metadata);  
    }  
        assertNull(manager.getActiveManagedVSR());
            doc3.addField(valField, 3);
            List<Field> expandedFields = new ArrayList<>(listSchema.getFields());  
                .getFields()
     * {@code addDocument} calls find every vector they need.  
            ListVector existingListVector = (ListVector) manager.getActiveManagedVSR().getVector("tags");
            thrown.getMessage() != null && thrown.getMessage().contains("Failed to close VSRManager")  
    }
        // Fill first VSR to trigger rotation
            assertNotNull(listVector);
            populateMetadataFields(doc3);
        return new Schema(fields);  
        String filePath = createTempDir().resolve("rotate.parquet").toString();
            values.add(new String(data.get(i), StandardCharsets.UTF_8));  
        ManagedVSR third = manager.getActiveManagedVSR();  
        KeywordFieldMapper.KeywordFieldType tagField = new KeywordFieldMapper.KeywordFieldType("tag");
            Future<?> f = manager1.getPendingWrite();
    private ThreadPool threadPool;
import org.opensearch.parquet.fields.core.data.number.IntegerParquetField;  
            manager.addDocument(doc3); // this would've triggerer the rotation  
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);  
        assertSame(original, manager.getActiveManagedVSR());
            ParquetDocumentInput doc = new ParquetDocumentInput();
            org.apache.arrow.vector.BigIntVector rowIdVector = (org.apache.arrow.vector.BigIntVector) manager.getActiveManagedVSR()
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);  
        IntVector vec = (IntVector) active.getVector("val");
        populateMetadataFields(doc);
            nextDoc.addField(valField, rowId);  
        }
        second.setRowCount(100);  
        if (nativeAllocator != null) {  
        populateMetadataFields(doc);  
                manager.addDocument(doc);
    public void testAllowsDistinctFieldsInSingleDocument() throws Exception {  
    private IndexSettings indexSettings;
        String filePath = createTempDir().resolve("rowid-monotonic.parquet").toString();
     * Regression for the ingest-pool leak: when {@code close()} fails to drain a background write  
                .stream()  
            populateMetadataFields(doc);  
                rowId++;
        List<Field> fields = new ArrayList<>(metadataFields());
public class VSRManagerTests extends ParquetBaseTests {  
                .filter(f -> f.getName().equals("tags"))
        IllegalArgumentException error = expectThrows(
        assertEquals(1, metadata.numRows());
    public void testRowIdColumnIsSortedAndContiguous() throws Exception {
        manager.reconcileSchema(new Schema(updatedFields));  
    }
    }
     * pendingWrite so close() takes the throwing path, and assert the pool drains to zero.  
        }  
            assertSame(existingListVector, manager.getActiveManagedVSR().getVector("tags"));
        );  
            // LIST<Utf8> rather than a flat Utf8 column.  
        assertEquals(101, metadata.numRows());
        fields.add(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null));
    /**  
            manager2.close();
            doc0.setRowId(DocumentInput.ROW_ID_FIELD, 0);
            manager.rollbackTo(1L);  
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0L);
            // exceptionNow() bug on successfully completed futures  
        doc.addField(valField, 1);
        }
            assertEquals(1, tagsField.getChildren().size());
            vec1.setSafe(i, i);
        } finally {
        assignTestCapabilities(tag2Field, PARQUET_FORMAT);
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
        for (int i = 0; i < totalDocs; i++) {
            new FixedExecutorBuilder(
    }
            ListVector listVector = (ListVector) manager.getActiveManagedVSR().getVector("tags");  
        terminate(threadPool);
            Schema listSchema = schemaWithMultiValue("tags");
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);
            manager.close();  
        ManagedVSR original = manager.getActiveManagedVSR();
            manager.close();
        updatedFields.add(new Field("tag2", FieldType.nullable(new ArrowType.Utf8()), null));
            vec.setSafe(i, i);
    }
            doc.addField(valField, i);
    public void testSchemaUpdatePropagatesAcrossRotation() throws Exception {  
        NumberFieldMapper.NumberFieldType valField = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
            manager.addDocument(doc1);  
            // leaf path "tags.list.element" — keeps the declared name.
        NumberFieldMapper.NumberFieldType priceField = new NumberFieldMapper.NumberFieldType("price", NumberFieldMapper.NumberType.INTEGER);
        fields.add(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null));
        assertTrue(
            doc2.setRowId(DocumentInput.ROW_ID_FIELD, 1L);  
        // Fill and rotate to trigger background write
import org.opensearch.parquet.bridge.ParquetFileMetadata;
        assignTestCapabilities(valField, PARQUET_FORMAT);  
import org.opensearch.parquet.fields.ParquetField;
        IntVector vec = (IntVector) active.getVector("val");
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        // triggers background write, waits for completion, then verifies next addDocument works
    }
        failed.completeExceptionally(new RuntimeException("simulated native write failure"));  
            assertEquals(List.of("b", "a", "b"), listElements(listVector, 0));
        int cycles = randomIntBetween(3, 8);
import org.opensearch.arrow.allocator.ArrowNativeAllocator;  
            populateMetadataFields(doc1);
        active.setRowCount(2);
     * leaked by query"). Here we buffer data into the active VSR, inject an already-failed
        assertBusy(() -> {
import org.opensearch.index.engine.dataformat.DataFormat;
            populateMetadataFields(doc2);  
import org.opensearch.index.mapper.NumberFieldMapper;
        // Materialize buffers on the active VSR's child allocator so the pool holds bytes.  
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 100, threadPool, 0L);  
        manager.maybeRotateActiveVSR();  
        assignTestCapabilities(valField, PARQUET_FORMAT);
        assertEquals(VSRState.ACTIVE, third.getState());
        List<Field> fields = new ArrayList<>(schema.getFields());  
            doc1.setRowId(DocumentInput.ROW_ID_FIELD, 1);
        {  
        manager.maybeRotateActiveVSR();
            manager.addDocument(doc1);  
                listVector.getDataVector() instanceof VarCharVector
            )
import org.opensearch.common.settings.Settings;  
        Thread.sleep(500);  
                -1,
        IntVector vec2 = (IntVector) second.getVector("val");
    }
            ParquetDocumentInput nextDoc = new ParquetDocumentInput();
import java.util.ArrayList;
            ParquetDocumentInput doc3 = new ParquetDocumentInput();
        }
    }
            // Mapping update introduces a keyword field declared multi-valued, so it arrives as a
        assertNotNull(metadata);
    public void testRotationWritesHappenOnBackgroundThread() throws Exception {
        schema = new Schema(fields);  
    public void testAcceptedRowsCounterTracksAdmitsAndRollbacks() throws Exception {
        // Flush at the end — must succeed regardless of pending write state  
            vec1.setSafe(i, i);
        assertNotNull(second);
    public void testReinitializeForSameFileAfterClose() throws Exception {
            ListVector listVector = (ListVector) manager.getActiveManagedVSR().getVector("tags");  
                doc.setRowId(DocumentInput.ROW_ID_FIELD, (long) i);
        assertFalse(manager.isSchemaMutable());  
        manager.maybeRotateActiveVSR();
            // reconcileSchema used to rebuild each Field from name + FieldType, dropping children
        }
            doc0.addField(tags, "b");  
        try {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            doc.addField(valField, 1);
            error.getMessage()
        ManagedVSR first = manager.getActiveManagedVSR();
        // background writes — verifies no error when future is still running or not yet done
            manager.close();  
        doc.addField(tag1Field, "a");  
        manager.addDocument(doc);
            // An explicit "tags": [] parses to zero addField calls, so the writer never sees the
        } finally {
        String filePath = createTempDir().resolve("flush-await.parquet").toString();
            });  
            doc3.setRowId(DocumentInput.ROW_ID_FIELD, 2L);  
            doc2.setRowId(DocumentInput.ROW_ID_FIELD, 1L);
    public void testFlushAfterRotation() throws Exception {  
        }  
        assertEquals("VSR pool must be released even when the background write failed", 0, bufferPool.getTotalAllocatedBytes());  
        try {  
     * awaitPendingWrite/flush, so a background-write failure skipped it and stranded the per-VSR  
        try {
            ParquetDocumentInput doc1 = new ParquetDocumentInput();  
        first.setRowCount(50000);
            vec.setSafe(i, i);  
        IntVector vec2 = (IntVector) second.getVector("val");
        manager.reconcileSchema(new Schema(fields));
    public void testReconcileSchemaPreservesListChildren() throws Exception {
        // Close should not throw — it should await the background write gracefully  
            doc1.addField(valField, 2);
            // list vector's child to "$data$" internally, but the schema — which is what  
}
                doc.addField(valField, rowId);
        manager.maybeRotateActiveVSR();
        String filePath = createTempDir().resolve("continuous-add.parquet").toString();
        String filePath = createTempDir().resolve("recovery-reinit.parquet").toString();
            doc1.addField(valField, 1);
    }
        assertNotSame(second, third);
        first.setRowCount(100);  
            ingest(manager2);
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
    }
        doc.addField(valField, 1);
        manager.maybeRotateActiveVSR();
            doc3.addField(tagField, "c");
 * The OpenSearch Contributors require contributions made to  
        assignTestCapabilities(priceField, PARQUET_FORMAT);  
        for (int i = 0; i < 100; i++) {  
        KeywordFieldMapper.KeywordFieldType tagField = new KeywordFieldMapper.KeywordFieldType("tag");
            doc1.addField(tagField, "a");
     * A new VSRManager can be created for a file that a previous VSRManager already opened and
        // rotation triggered by maxRowsPerVSR=1.
    public void testFlushAwaitsBackgroundWrite() throws Exception {
import org.opensearch.parquet.memory.ArrowBufferPool;
    private Schema schemaWith(String name, ArrowType type) {
        }
        for (int i = 0; i < 100; i++) {
            populateMetadataFields(doc1);
            }
    public void testMaybeRotateNoOpBelowThreshold() throws Exception {
        String filePath = createTempDir().resolve("accepted-counter.parquet").toString();  
        int totalDocs = lowThreshold * randomIntBetween(5, 12);
    public void testFlushWithData() throws Exception {  
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
        fields.addAll(metadataFields());
            manager.addDocument(doc);  
import org.opensearch.parquet.writer.ParquetDocumentInput;  
        manager1.setPendingWrite(failed);
    }  
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, 50000, threadPool, 0L);  
        }  
        List<Field> fields = new ArrayList<>();
        String filePath = createTempDir().resolve("init.parquet").toString();
    public void testReconcileSchemaReusesUnchangedListVectorWhenAddingField() throws Exception {
    /**
        super.setUp();  
        doc.setRowId(DocumentInput.ROW_ID_FIELD, 0);
        manager.maybeRotateActiveVSR();
            assertEquals(0L, manager.getAcceptedRows());
        String filePath = createTempDir().resolve("close-await.parquet").toString();  
        manager.reconcileSchema(updatedSchema);
        failed.completeExceptionally(new RuntimeException("simulated native write failure"));
    }
        ParquetFileMetadata metadata = manager.flush();
        first.setRowCount(100);
            // Next doc reuses rowId 1 (the slot freed by rollback).  
            ParquetDocumentInput doc3 = new ParquetDocumentInput();
import org.opensearch.index.IndexSettings;
        VSRManager manager = new VSRManager(filePath, indexSettings, schema, bufferPool, lowThreshold, threadPool, 0L);
