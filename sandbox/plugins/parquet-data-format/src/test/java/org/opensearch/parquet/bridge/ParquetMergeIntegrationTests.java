/*
        assertEquals(9, mergedMeta.numRows());
    public void testMergeWithLiveDocsDropsDeletedRows() throws Exception {
        // Every row in every input is dead.
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(3, RustBridge.getFileMetadata(file3).numRows());
    /** A live-docs array whose length doesn't match the input file count is rejected up front. */
            IllegalArgumentException.class,
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 400, 500, 600 }, new String[] { "d", "e", "f" });
    public void testMergeWithInterleavedTimestamps() throws Exception {
        assertTrue(ex.getMessage().contains("must match"));
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2)), liveBits, mergedFile, INDEX_NAME, 0L);
        ParquetSortConfig sortConfig = new ParquetSortConfig(List.of("timestamp"), List.of(false), List.of(false), List.of(false));
        Path tempDir = createTempDir();
    }
        }
    public void testMergeSortedFiles() throws Exception {
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.BigIntVector;
        Path tempDir = createTempDir();
    }
            liveBits,
        assertEquals(3, RustBridge.getFileMetadata(file2).numRows());
            writer.flush();
import java.util.List;
import java.nio.file.Path;
    }
    public void testMergeWithMismatchedLiveDocsLengthThrows() throws Exception {
        // Interleaved ranges — merge must sort globally
            ArrowArray array = ArrowArray.allocateNew(allocator);
    private String createSortedFile(Path dir, String name, long[] timestamps, String[] messages) throws Exception {
        String mergedFile = tempDir.resolve("merged.parquet").toString();
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 200, 300 }, new String[] { "a", "b", "c" });
        RustBridge.removeSettings(INDEX_NAME);
        // 2. Create 3 sorted files with non-overlapping timestamp ranges
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 10, 20, 30 }, new String[] { "x", "y", "z" });
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        // 4. Verify merged output
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 200 }, new String[] { "b" });
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
        }
            writer.initialize(INDEX_NAME, schemaExport.getSchemaAddress(), sortConfig, 0L);
        Path tempDir = createTempDir();
        MergeFilesResult merged = RustBridge.mergeParquetFilesInRust(
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
        IllegalArgumentException ex = expectThrows(
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2)), null, mergedFile, INDEX_NAME, 0L);
        try (ArrowExport schemaExport = exportSchema()) {
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
        assertEquals("all rows dead — merged output must contain zero rows", 0, merged.metadata().numRows());
    private ArrowExport exportData(long[] timestamps, String[] messages) {
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2)), liveBits, mergedFile, INDEX_NAME, 0L);
        return new ArrowExport(null, arrowSchema);
        allocator.close();
    public void tearDown() throws Exception {
        );
        Path tempDir = createTempDir();
                msgVec.setSafe(i, messages[i].getBytes(StandardCharsets.UTF_8));
        RustBridge.removeSettings(INDEX_NAME);
        String mergedFile = tempDir.resolve("merged.parquet").toString();
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 200, 300 }, new String[] { "a", "b", "c" });
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 400, 500, 600 }, new String[] { "d", "e", "f" });
        long[][] liveBits = new long[][] { null, { 0b001L } };
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").compressionLevel(2).build();
    }
        long[][] liveBits = new long[][] { { 0L }, { 0L } };
        RustBridge.removeSettings(INDEX_NAME);
import org.apache.arrow.c.ArrowSchema;
        schema = new Schema(
        Data.exportSchema(allocator, schema, null, arrowSchema);
    private Schema schema;
        String filePath = dir.resolve(name).toString();
                new Field("message", FieldType.nullable(new ArrowType.Utf8()), null)
        RustBridge.initLogger();
import org.apache.arrow.vector.types.pojo.ArrowType;
        // The empty output is still a structurally valid parquet file: the footer must be readable.
        RustBridge.onSettingsUpdate(settings);
        String mergedFile = tempDir.resolve("merged.parquet").toString();
        RustBridge.removeSettings(INDEX_NAME);
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
    public void testMergeWithNullLiveDocsEntryKeepsFileUnfiltered() throws Exception {
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
    private static final String INDEX_NAME = "merge-test-index";
        super.setUp();
    public void testMergeWithAllRowsDeadProducesValidEmptyFile() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
            INDEX_NAME,
import java.nio.charset.StandardCharsets;
            NativeParquetWriter writer = new NativeParquetWriter(filePath);
        String mergedFile = tempDir.resolve("merged.parquet").toString();
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100 }, new String[] { "a" });
        );
        long[][] liveBits = new long[][] { { 0b101L }, { 0b010L } };
        // file1: rows 0 and 2 alive, row 1 dead. file2: only row 1 alive.
    }
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1)), null, mergedFile, INDEX_NAME, 0L);
public class ParquetMergeIntegrationTests extends OpenSearchTestCase {
            List.of(
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
        RustBridge.removeSettings(INDEX_NAME);
            }
        RustBridge.onSettingsUpdate(settings);
 *
        String mergedFile = tempDir.resolve("merged.parquet").toString();
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 400, 500, 600 }, new String[] { "d", "e", "f" });
                writer.write(dataExport.getArrayAddress(), dataExport.getSchemaAddress());
        );
        Path tempDir = createTempDir();
        // Verify individual files
// singleton that persists after tests complete. It polls for new async IO tasks between merges.
    }
        return filePath;
            BigIntVector tsVec = (BigIntVector) root.getVector("timestamp");
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 200, 400, 600 }, new String[] { "b", "d", "f" });
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
        assertEquals(3, RustBridge.getFileMetadata(file1).numRows());
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
    public void testMergeSingleFile() throws Exception {
        Path tempDir = createTempDir();
 */
    }
// The Tokio IO runtime worker thread (used by the Rust merge k-way merge sort) is a process-lifetime
            VarCharVector msgVec = (VarCharVector) root.getVector("message");
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.types.pojo.Field;
        RustBridge.onSettingsUpdate(settings);
import org.apache.arrow.c.ArrowArray;
     * createWriter (with sort config) → write → finalizeWriter.
            mergedFile,
        // file1 unfiltered (null entry); file2 keeps only row 0.
import org.opensearch.nativebridge.spi.ArrowExport;
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 200, 300 }, new String[] { "a", "b", "c" });
        assertEquals(0, RustBridge.getFileMetadata(mergedFile).numRows());
        RustBridge.onSettingsUpdate(settings);
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 400, 500, 600 }, new String[] { "d", "e", "f" });
        String mergedFile = tempDir.resolve("merged.parquet").toString();
            0L
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
 * this file be licensed under the Apache-2.0 license or a
    /** A merge where every input row is dead produces a valid, readable, zero-row output file. */
     */
        assertEquals(3, RustBridge.getFileMetadata(mergedFile).numRows());
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 200, 300 }, new String[] { "a", "b", "c" });
            List.of(Path.of(file1), Path.of(file2)),
import org.apache.arrow.vector.types.pojo.FieldType;
        RustBridge.removeSettings(INDEX_NAME);
        // 3. Merge
        String mergedFile = tempDir.resolve("merged.parquet").toString();
            return new ArrowExport(array, arrowSchema);
        long[][] liveBits = new long[][] { { 0b1L } }; // 1 entry for 2 files
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2), Path.of(file3)), null, mergedFile, INDEX_NAME, 0L);
            root.setRowCount(timestamps.length);
        RustBridge.onSettingsUpdate(settings);
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 400, 500, 600 }, new String[] { "d", "e", "f" });
    }
        // 5. Cleanup
    @Override
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 300, 500 }, new String[] { "a", "c", "e" });
        ParquetFileMetadata mergedMeta = RustBridge.getFileMetadata(mergedFile);
        assertEquals("3 unfiltered rows + 1 surviving row", 4, RustBridge.getFileMetadata(mergedFile).numRows());
}
    }
    private ArrowExport exportSchema() {
    }
            }
            for (int i = 0; i < timestamps.length; i++) {
            )
        String mergedFile = tempDir.resolve("merged.parquet").toString();
        assertEquals(6, RustBridge.getFileMetadata(mergedFile).numRows());
        String file3 = createSortedFile(tempDir, "f3.parquet", new long[] { 700, 800, 900 }, new String[] { "g", "h", "i" });
        RustBridge.onSettingsUpdate(settings);
        RustBridge.removeSettings(INDEX_NAME);
        RustBridge.onSettingsUpdate(settings);
    public void testMergeWithAllAliveBitmapKeepsEveryRow() throws Exception {
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2)), liveBits, mergedFile, INDEX_NAME, 0L);
                new Field("timestamp", FieldType.nullable(new ArrowType.Int(64, true)), null),
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 200, 300 }, new String[] { "a", "b", "c" });
    /** Rows flagged dead in the live-docs bitset are dropped from the merged output. */
 * compatible open source license.
    /** A null bitset entry disables filtering for that file only. */
import org.apache.arrow.vector.types.pojo.Schema;
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
        RustBridge.onSettingsUpdate(settings);
        long[][] liveBits = new long[][] { { 0b111L }, { 0b111L } };
import org.apache.arrow.vector.VectorSchemaRoot;
package org.opensearch.parquet.bridge;
    }
    // ========== Live-docs delete filtering ==========
import org.apache.arrow.memory.RootAllocator;
        // 1. Push settings
        Path tempDir = createTempDir();
                tsVec.setSafe(i, timestamps[i]);
            try (ArrowExport dataExport = exportData(timestamps, messages)) {
    public void setUp() throws Exception {
     * Creates a sorted Parquet file via the full Rust writer pipeline:
 * The OpenSearch Contributors require contributions made to
    }
    /**
        allocator = new RootAllocator();
            () -> RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2)), liveBits, mergedFile, INDEX_NAME, 0L)
        assertEquals("2 rows from file1 + 1 row from file2 must survive", 3, RustBridge.getFileMetadata(mergedFile).numRows());
    @Override
        RustBridge.removeSettings(INDEX_NAME);
    /** An all-ones bitmap behaves exactly like passing no live-docs at all. */
    }
import org.apache.arrow.c.Data;
        assertEquals(6, RustBridge.getFileMetadata(mergedFile).numRows());
        Path tempDir = createTempDir();
        super.tearDown();
    private BufferAllocator allocator;
