        // Constructor is lightweight — error surfaces on initialize
            ArrowExport batch2 = exportData(new int[] { 3, 4, 5 }, new String[] { "carol", "dave", "eve" }, new long[] { 30L, 40L, 50L })
import org.apache.arrow.vector.types.pojo.Schema;
        // the previous writer un-finalized).  
        }
            writer2.initialize("test-index", export.getSchemaAddress(), ParquetSortConfig.empty(), 0L);  
            expectThrows(IOException.class, () -> writer.write(dataExport.getArrayAddress(), 0L));  
                }
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "a" }, new long[] { 1L })) {
        }
        String filePath = createTempDir().resolve("cleanup-noop.parquet").toString();  
            ArrowArray array = ArrowArray.allocateNew(allocator);
    public void testCreateWriterForSameFileReplacesStaleEntry() throws Exception {
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "alice" }, new long[] { 10L })) {
import org.apache.arrow.vector.types.pojo.ArrowType;
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "a" }, new long[] { 1L })) {  
        }  
        assertEquals(5, writer.getMetadata().numRows());
        assertTrue("Parquet file should exist after flush", Files.exists(Path.of(filePath)));
        assertFalse(writer.isInitialized());
        NativeParquetWriter writer = new NativeParquetWriter(filePath);
        ParquetFileMetadata first = writer.getMetadata();
            expectThrows(IOException.class, () -> writer.write(export.getArrayAddress(), export.getSchemaAddress()));  
        Data.exportSchema(allocator, schema, null, arrowSchema);
        }  
                    root.setRowCount(1);
        }
            writer1.write(export.getArrayAddress(), export.getSchemaAddress());
                scoreVec.setSafe(i, scores[i]);  
                new int[] { 1, 2, 3 },
    public void testWriteAfterFlushThrows() throws Exception {
        NativeParquetWriter writer2 = new NativeParquetWriter(filePath);  
        writer.flush();  
        writer.flush();  
        NativeParquetWriter writer = new NativeParquetWriter("/nonexistent/dir/file.parquet");  
    }  
        NativeParquetWriter writer2 = new NativeParquetWriter(filePath);
        }
        try (ArrowExport export = exportData(new int[] {}, new String[] {}, new long[] {})) {
            IntVector idVec = (IntVector) root.getVector("id");  
            return new ArrowExport(array, arrowSchema);
    public void testFlushWithoutWrite() throws Exception {
            writer.initialize("test-index", export.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
                // Expected — some Rust versions detect mismatch at write time
                () -> writer.initialize("test-index", export.getSchemaAddress(), ParquetSortConfig.empty(), 0L)
    }  
    public void testWriteWithNullAddresses() throws Exception {
import org.opensearch.test.OpenSearchTestCase;  
        String filePath = createTempDir().resolve("bad-schema.parquet").toString();
    @Override
        String filePath = createTempDir().resolve("duplicate.parquet").toString();
    }
        NativeParquetWriter writer = createWriter(filePath);  
    }
    public void setUp() throws Exception {  
import org.opensearch.nativebridge.spi.ArrowExport;
        }
    }
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
        }
import org.apache.arrow.memory.RootAllocator;
    private ArrowExport exportSchema() {  
        String filePath = createTempDir().resolve("multi-batch.parquet").toString();
                idVec.setSafe(i, ids[i]);
import org.apache.arrow.vector.VarCharVector;
        assert ids.length == names.length && names.length == scores.length;
        try (ArrowExport dataExport = exportData(new int[] { 1 }, new String[] { "a" }, new long[] { 1L })) {
            )  
    }
            );
        writer.flush();  
    private ArrowExport exportDataWithSchema(Schema customSchema, Consumer<VectorSchemaRoot> populator) {
        return writer;  
        expectThrows(Exception.class, () -> writer.initialize("test-index", 0L, ParquetSortConfig.empty(), 0L));
        // If write didn't throw, flush should detect the mismatch  
                    ((IntVector) root.getVector("other_field")).setSafe(0, 99);  
import java.nio.file.Path;
        NativeParquetWriter writer = createWriter(filePath);  
        allocator.close();  
import java.nio.charset.StandardCharsets;  
import java.io.IOException;
        writer.flush();
        ) {
import org.apache.arrow.c.ArrowArray;
    private ArrowExport exportData(int[] ids, String[] names, long[] scores) {  
        }
        // Initialize writer with a write, then flush
        NativeParquetWriter writer = createWriter(filePath);  
import org.apache.arrow.vector.IntVector;
import org.apache.arrow.vector.BigIntVector;  
            } catch (IOException e) {  
import org.apache.arrow.memory.BufferAllocator;
        try (ArrowExport export = exportSchema()) {
        assertNull(metadata);
                new long[] { 100L, 200L, 300L }  
    }  
            expectThrows(IOException.class, () -> writer.write(0L, schemaExport.getSchemaAddress()));
            ArrowExport export = exportDataWithSchema(  
        expectThrows(IOException.class, () -> writer.write(0L, 0L));  
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);  
                new Field("score", FieldType.nullable(new ArrowType.Int(64, true)), null)
        super.tearDown();
                root -> {
                writer.write(export.getArrayAddress(), export.getSchemaAddress());
        schema = new Schema(
        // First write initializes the writer with the correct schema
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "a" }, new long[] { 1L })) {  
        // cleanup() is idempotent / safe after flush already removed the entry.
        NativeParquetWriter writer = new NativeParquetWriter(filePath);
    public void testMultipleBatchesThenCloseAndFlush() throws Exception {
        String filePath = createTempDir().resolve("idempotent.parquet").toString();
            }
    @Override
            )  
import java.nio.file.Files;
        writer2.cleanup();
    private Schema schema;  
        }  
 *
                return;
                new Schema(List.of(new Field("other_field", FieldType.nullable(new ArrowType.Int(32, true)), null))),
        // A fresh writer can now initialize for the same file.
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);  
            VarCharVector nameVec = (VarCharVector) root.getVector("name");
 * compatible open source license.
    }
import org.apache.arrow.c.ArrowSchema;
    }
        NativeParquetWriter writer = createWriter(filePath);  
        assertTrue("second writer must initialize after replacing the stale entry", writer2.isInitialized());
        try (  
            root.setRowCount(ids.length);
        // Initialize writer1 by writing data
            expectThrows(
        assertEquals(3, writer.getMetadata().numRows());
import org.apache.arrow.c.Data;  
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "a" }, new long[] { 1L })) {  
        String filePath = createTempDir().resolve("mismatch.parquet").toString();
    }
            writer.write(export.getArrayAddress(), export.getSchemaAddress());
    public void testCreateWriterWithNonExistentDirectory() throws Exception {
 * The OpenSearch Contributors require contributions made to  
        // Write some data first so the writer gets initialized
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
                IOException.class,  
    }
            ArrowArray array = ArrowArray.allocateNew(allocator);
    }
        allocator = new RootAllocator();  
        // Never initialized: cleanup must be a no-op and must not throw.  
        String filePath = createTempDir().resolve("write-after-flush.parquet").toString();
        ) {
        try (ArrowExport schemaExport = exportSchema()) {  
package org.opensearch.parquet.bridge;
            )
        try (VectorSchemaRoot root = VectorSchemaRoot.create(customSchema, allocator)) {  
    public void testCleanupOnUninitializedWriterIsNoop() throws Exception {
import org.apache.arrow.vector.VectorSchemaRoot;  
        assertTrue("writer must re-initialize for the same file after cleanup", writer2.isInitialized());
            writer1.write(export.getArrayAddress(), export.getSchemaAddress());
        assertNotNull(writer.getMetadata());
        }
    public void testWriteWithSchemaMismatch() throws Exception {
        writer2.flush();
            ArrowExport export = exportData(  
        }
        }
 * SPDX-License-Identifier: Apache-2.0
        String filePath = createTempDir().resolve("close-only.parquet").toString();  
        NativeParquetWriter writer = new NativeParquetWriter(filePath);
        // cleanup() removes the native registry entry without finalizing.
        // creates a fresh writer in its place (this is what unblocks recovery after a failure left
        // Both null
import org.apache.arrow.vector.types.pojo.Field;
        String filePath = createTempDir().resolve("full.parquet").toString();
    }
        // A second writer for the same file now SUCCEEDS: create_writer removes the stale entry and
            writer.write(batch1.getArrayAddress(), batch1.getSchemaAddress());  
        try (
import java.util.function.Consumer;
        }  
        RustBridge.initLogger();
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "alice" }, new long[] { 10L })) {  
 * this file be licensed under the Apache-2.0 license or a
    public void tearDown() throws Exception {
        writer.flush();  
        String filePath = createTempDir().resolve("empty-batch.parquet").toString();
            writer.write(export.getArrayAddress(), export.getSchemaAddress());
        ) {
            List.of(
    }
        // Null schema only
            // the mismatch is detected at flush time  
        }
        ParquetFileMetadata metadata = writer.flush();
        // Second write with mismatched schema
        }
    private NativeParquetWriter createWriter(String filePath) throws Exception {
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
        }
import java.util.List;  
    public void testFullLifecycle() throws Exception {
        writer.cleanup();
            try {
            writer.write(export.getArrayAddress(), export.getSchemaAddress());  
            writer.write(export.getArrayAddress(), export.getSchemaAddress());  
            writer2.initialize("test-index", export.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
                new Field("name", FieldType.nullable(new ArrowType.Utf8()), null),
        // Writer was never initialized, so flush returns null  
        NativeParquetWriter writer1 = createWriter(filePath);  
        NativeParquetWriter writer = createWriter(filePath);  
        try (ArrowExport export = exportSchema()) {  
 */  
        writer1.cleanup();  
        NativeParquetWriter writer1 = createWriter(filePath);  
public class NativeParquetWriterTests extends OpenSearchTestCase {  
        assertSame(first, writer.getMetadata());
}
            for (int i = 0; i < ids.length; i++) {  
    }
        assertNotNull(writer.getMetadata());
        // Null array only
            BigIntVector scoreVec = (BigIntVector) root.getVector("score");
        writer2.flush();  
            writer.write(batch2.getArrayAddress(), batch2.getSchemaAddress());  
import org.apache.arrow.vector.types.pojo.FieldType;  
        try (ArrowExport export = exportSchema()) {
    public void testWriteEmptyBatch() throws Exception {
        expectThrows(IOException.class, writer::flush);
        try (ArrowExport export = exportSchema()) {
    }
        NativeParquetWriter writer = createWriter(filePath);  
    public void testCleanupWriterAllowsReinitializeForSameFile() throws Exception {
        try (ArrowExport batch1 = exportData(new int[] { 1, 2 }, new String[] { "alice", "bob" }, new long[] { 10L, 20L })) {
            populator.accept(root);
        );
    public void testCreateWriterWithInvalidSchemaAddress() throws Exception {  
            writer.write(export.getArrayAddress(), export.getSchemaAddress());
    }
                new Field("id", FieldType.nullable(new ArrowType.Int(32, true)), null),  
            }  
        writer.flush();  
        }
        NativeParquetWriter writer = createWriter(filePath);  
/*  
        super.setUp();
                nameVec.setSafe(i, names[i].getBytes(StandardCharsets.UTF_8));
        }
        try (
                new String[] { "alice", "bob", "carol" },
            return new ArrowExport(array, arrowSchema);
    public void testFlushIsIdempotent() throws Exception {
    }
            // Rust side may or may not throw on schema mismatch during write;
        assertFalse(writer.isInitialized());  
        return new ArrowExport(null, arrowSchema);  
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
    private BufferAllocator allocator;
    }
        NativeParquetWriter writer = new NativeParquetWriter(filePath);
        String filePath = createTempDir().resolve("cleanup.parquet").toString();
        String filePath = createTempDir().resolve("null-addr.parquet").toString();
        assertTrue("Parquet file should exist after flush", Files.exists(Path.of(filePath)));
