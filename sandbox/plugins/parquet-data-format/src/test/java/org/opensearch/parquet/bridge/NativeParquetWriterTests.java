            ArrowArray array = ArrowArray.allocateNew(allocator);
        NativeParquetWriter writer = createWriter(filePath);
 */
                scoreVec.setSafe(i, scores[i]);
        try (
        try (ArrowExport export = exportSchema()) {
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
    public void testFlushIsIdempotent() throws Exception {
    public void testCreateWriterWithNonExistentDirectory() throws Exception {
    }
        writer2.cleanup();
        // cleanup() removes the native registry entry without finalizing.
        NativeParquetWriter writer = new NativeParquetWriter(filePath);
                }
        writer.flush();
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
                () -> writer.initialize("test-index", export.getSchemaAddress(), ParquetSortConfig.empty(), 0L)
        String filePath = createTempDir().resolve("full.parquet").toString();
import java.nio.charset.StandardCharsets;
        try (ArrowExport export = exportSchema()) {
        String filePath = createTempDir().resolve("cleanup-noop.parquet").toString();
        assertNull(metadata);
import java.util.function.Consumer;
        }
 * SPDX-License-Identifier: Apache-2.0
        RustBridge.initLogger();
import java.io.IOException;
        NativeParquetWriter writer = new NativeParquetWriter(filePath);
        NativeParquetWriter writer = new NativeParquetWriter(filePath);
        assertNotNull(writer.getMetadata());
        try (
        assertFalse(writer.isInitialized());
            return new ArrowExport(array, arrowSchema);
            for (int i = 0; i < ids.length; i++) {
        }
        writer.flush();
        return writer;
        try (
        try (ArrowExport export = exportData(new int[] {}, new String[] {}, new long[] {})) {
        // the previous writer un-finalized).
        NativeParquetWriter writer2 = new NativeParquetWriter(filePath);
        return new ArrowExport(null, arrowSchema);
        NativeParquetWriter writer = createWriter(filePath);
        // Never initialized: cleanup must be a no-op and must not throw.
        // Constructor is lightweight — error surfaces on initialize
import org.opensearch.test.OpenSearchTestCase;
                    ((IntVector) root.getVector("other_field")).setSafe(0, 99);
                new int[] { 1, 2, 3 },
        NativeParquetWriter writer = createWriter(filePath);
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
        Data.exportSchema(allocator, schema, null, arrowSchema);
        NativeParquetWriter writer1 = createWriter(filePath);
            expectThrows(
                // Expected — some Rust versions detect mismatch at write time
    }
        NativeParquetWriter writer = createWriter(filePath);
        // Initialize writer1 by writing data
        super.setUp();
    public void testWriteEmptyBatch() throws Exception {
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
        );
        writer.flush();
        expectThrows(IOException.class, () -> writer.write(0L, 0L));
    }
        super.tearDown();
        NativeParquetWriter writer1 = createWriter(filePath);
        // Second write with mismatched schema
            VarCharVector nameVec = (VarCharVector) root.getVector("name");
        }
        assertTrue("Parquet file should exist after flush", Files.exists(Path.of(filePath)));
        }
            try {
            );
    @Override
    }
        try (ArrowExport export = exportSchema()) {
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "alice" }, new long[] { 10L })) {
        // Initialize writer with a write, then flush
import org.apache.arrow.vector.types.pojo.Field;
            BigIntVector scoreVec = (BigIntVector) root.getVector("score");
            writer.initialize("test-index", export.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
        writer.flush();
            return new ArrowExport(array, arrowSchema);
}
            writer.write(export.getArrayAddress(), export.getSchemaAddress());
        expectThrows(IOException.class, writer::flush);
        String filePath = createTempDir().resolve("null-addr.parquet").toString();
    public void testCleanupWriterAllowsReinitializeForSameFile() throws Exception {
    }
 * The OpenSearch Contributors require contributions made to
        String filePath = createTempDir().resolve("empty-batch.parquet").toString();
        // A fresh writer can now initialize for the same file.
        allocator = new RootAllocator();
        String filePath = createTempDir().resolve("close-only.parquet").toString();
        assertFalse(writer.isInitialized());
            expectThrows(IOException.class, () -> writer.write(export.getArrayAddress(), export.getSchemaAddress()));
        String filePath = createTempDir().resolve("multi-batch.parquet").toString();
            ArrowExport export = exportData(
        writer.flush();
    private ArrowExport exportDataWithSchema(Schema customSchema, Consumer<VectorSchemaRoot> populator) {
            )
                idVec.setSafe(i, ids[i]);
                new Field("score", FieldType.nullable(new ArrowType.Int(64, true)), null)
    }
import org.apache.arrow.vector.types.pojo.FieldType;
                IOException.class,
        assert ids.length == names.length && names.length == scores.length;
        }
        writer.cleanup();
    }
        try (VectorSchemaRoot root = VectorSchemaRoot.create(customSchema, allocator)) {
        // First write initializes the writer with the correct schema
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
        // If write didn't throw, flush should detect the mismatch
            writer2.initialize("test-index", export.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
                new Schema(List.of(new Field("other_field", FieldType.nullable(new ArrowType.Int(32, true)), null))),
    }
import org.apache.arrow.vector.IntVector;
    public void testWriteWithNullAddresses() throws Exception {
                root -> {
    public void testFullLifecycle() throws Exception {
import org.apache.arrow.vector.types.pojo.ArrowType;
                new Field("id", FieldType.nullable(new ArrowType.Int(32, true)), null),
 * this file be licensed under the Apache-2.0 license or a
/*
                new long[] { 100L, 200L, 300L }
    private Schema schema;
            }
            ArrowExport batch2 = exportData(new int[] { 3, 4, 5 }, new String[] { "carol", "dave", "eve" }, new long[] { 30L, 40L, 50L })
            writer.write(export.getArrayAddress(), export.getSchemaAddress());
            // the mismatch is detected at flush time
    public void testFlushWithoutWrite() throws Exception {
import org.apache.arrow.vector.VectorSchemaRoot;
                new String[] { "alice", "bob", "carol" },
package org.opensearch.parquet.bridge;
        assertNotNull(writer.getMetadata());
    public void testWriteWithSchemaMismatch() throws Exception {
        try (ArrowExport schemaExport = exportSchema()) {
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "alice" }, new long[] { 10L })) {
import org.apache.arrow.c.Data;
        }
            writer1.write(export.getArrayAddress(), export.getSchemaAddress());
        String filePath = createTempDir().resolve("cleanup.parquet").toString();
        // cleanup() is idempotent / safe after flush already removed the entry.
            List.of(
import org.apache.arrow.vector.types.pojo.Schema;
        // A second writer for the same file now SUCCEEDS: create_writer removes the stale entry and
    public void testCreateWriterForSameFileReplacesStaleEntry() throws Exception {
            // Rust side may or may not throw on schema mismatch during write;
    public void testCreateWriterWithInvalidSchemaAddress() throws Exception {
        ParquetFileMetadata metadata = writer.flush();
        try (ArrowExport dataExport = exportData(new int[] { 1 }, new String[] { "a" }, new long[] { 1L })) {
        NativeParquetWriter writer = new NativeParquetWriter("/nonexistent/dir/file.parquet");
            expectThrows(IOException.class, () -> writer.write(0L, schemaExport.getSchemaAddress()));
        allocator.close();
        }
        }
        writer2.flush();
    }
                return;
        writer2.flush();
import java.util.List;
    }
 * compatible open source license.
        schema = new Schema(
        expectThrows(Exception.class, () -> writer.initialize("test-index", 0L, ParquetSortConfig.empty(), 0L));
        assertTrue("second writer must initialize after replacing the stale entry", writer2.isInitialized());
import org.opensearch.nativebridge.spi.ArrowExport;
        }
        ) {
                nameVec.setSafe(i, names[i].getBytes(StandardCharsets.UTF_8));
            root.setRowCount(ids.length);
    public void testWriteAfterFlushThrows() throws Exception {
            ArrowExport export = exportDataWithSchema(
        NativeParquetWriter writer2 = new NativeParquetWriter(filePath);
import org.apache.arrow.c.ArrowSchema;
        String filePath = createTempDir().resolve("duplicate.parquet").toString();
        ParquetFileMetadata first = writer.getMetadata();
import org.apache.arrow.c.ArrowArray;
        }
            writer.write(export.getArrayAddress(), export.getSchemaAddress());
        }
        assertEquals(3, writer.getMetadata().numRows());
        ) {
import org.apache.arrow.vector.BigIntVector;
    }
        writer.flush();
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "a" }, new long[] { 1L })) {
            expectThrows(IOException.class, () -> writer.write(dataExport.getArrayAddress(), 0L));
    }
import org.apache.arrow.vector.VarCharVector;
        NativeParquetWriter writer = createWriter(filePath);
            writer.write(export.getArrayAddress(), export.getSchemaAddress());
    public void setUp() throws Exception {
        try (ArrowExport export = exportSchema()) {
            )
    public void testMultipleBatchesThenCloseAndFlush() throws Exception {
        NativeParquetWriter writer = new NativeParquetWriter(filePath);
        assertEquals(5, writer.getMetadata().numRows());
    }
            writer.write(export.getArrayAddress(), export.getSchemaAddress());
        assertTrue("writer must re-initialize for the same file after cleanup", writer2.isInitialized());
        // Both null
        }
        String filePath = createTempDir().resolve("idempotent.parquet").toString();
            ArrowArray array = ArrowArray.allocateNew(allocator);
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "a" }, new long[] { 1L })) {
        }
        }
            )
            } catch (IOException e) {
            writer.write(batch1.getArrayAddress(), batch1.getSchemaAddress());
    }
    }
    public void tearDown() throws Exception {
    }
 *
        }
            writer2.initialize("test-index", export.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
            IntVector idVec = (IntVector) root.getVector("id");
            populator.accept(root);
        // Write some data first so the writer gets initialized
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "a" }, new long[] { 1L })) {
import java.nio.file.Path;
        try (ArrowExport export = exportData(new int[] { 1 }, new String[] { "a" }, new long[] { 1L })) {
    }
        // Writer was never initialized, so flush returns null
        ) {
import java.nio.file.Files;
        // Null array only
    }
        }
import org.apache.arrow.memory.BufferAllocator;
            writer.write(batch2.getArrayAddress(), batch2.getSchemaAddress());
        // creates a fresh writer in its place (this is what unblocks recovery after a failure left
    private BufferAllocator allocator;
    private NativeParquetWriter createWriter(String filePath) throws Exception {
    @Override
    private ArrowExport exportData(int[] ids, String[] names, long[] scores) {
        String filePath = createTempDir().resolve("mismatch.parquet").toString();
        try (ArrowExport batch1 = exportData(new int[] { 1, 2 }, new String[] { "alice", "bob" }, new long[] { 10L, 20L })) {
                writer.write(export.getArrayAddress(), export.getSchemaAddress());
        }
        assertTrue("Parquet file should exist after flush", Files.exists(Path.of(filePath)));
        String filePath = createTempDir().resolve("write-after-flush.parquet").toString();
        assertSame(first, writer.getMetadata());
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
                new Field("name", FieldType.nullable(new ArrowType.Utf8()), null),
    }
        NativeParquetWriter writer = createWriter(filePath);
        // Null schema only
            writer1.write(export.getArrayAddress(), export.getSchemaAddress());
        }
        String filePath = createTempDir().resolve("bad-schema.parquet").toString();
        }
            }
                    root.setRowCount(1);
        NativeParquetWriter writer = createWriter(filePath);
        writer1.cleanup();
public class NativeParquetWriterTests extends OpenSearchTestCase {
    public void testCleanupOnUninitializedWriterIsNoop() throws Exception {
    private ArrowExport exportSchema() {
import org.apache.arrow.memory.RootAllocator;
