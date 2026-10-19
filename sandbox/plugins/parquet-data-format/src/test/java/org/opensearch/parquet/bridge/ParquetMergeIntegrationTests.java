        long[][] liveBits = new long[][] { { 0b101L }, { 0b010L } };
            INDEX_NAME,
public class ParquetMergeIntegrationTests extends OpenSearchTestCase {
    /** An all-ones bitmap behaves exactly like passing no live-docs at all. */
        // 5. Cleanup
// The Tokio IO runtime worker thread (used by the Rust merge k-way merge sort) is a process-lifetime
import org.apache.arrow.c.ArrowArray;  
    public void testMergeWithLiveDocsDropsDeletedRows() throws Exception {
    @Override
        Path tempDir = createTempDir();
            List.of(Path.of(file1), Path.of(file2)),
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 200, 300 }, new String[] { "a", "b", "c" });
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 200, 300 }, new String[] { "a", "b", "c" });
     */  
        String mergedFile = tempDir.resolve("merged.parquet").toString();
import org.apache.arrow.vector.VarCharVector;  
        assertEquals(3, RustBridge.getFileMetadata(file1).numRows());  
        allocator = new RootAllocator();
    }
        RustBridge.onSettingsUpdate(settings);
        // 2. Create 3 sorted files with non-overlapping timestamp ranges  
import org.apache.arrow.vector.types.pojo.Field;  
    }  
            BigIntVector tsVec = (BigIntVector) root.getVector("timestamp");
        Path tempDir = createTempDir();
        assertEquals(3, RustBridge.getFileMetadata(mergedFile).numRows());
    /**  
                tsVec.setSafe(i, timestamps[i]);
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 300, 500 }, new String[] { "a", "c", "e" });  
        RustBridge.removeSettings(INDEX_NAME);
        RustBridge.onSettingsUpdate(settings);  
    }  
            List.of(
 * compatible open source license.
        RustBridge.removeSettings(INDEX_NAME);  
    /** A merge where every input row is dead produces a valid, readable, zero-row output file. */
        super.tearDown();
                new Field("timestamp", FieldType.nullable(new ArrowType.Int(64, true)), null),
            liveBits,
import org.apache.arrow.vector.types.pojo.FieldType;
        Path tempDir = createTempDir();
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 400, 500, 600 }, new String[] { "d", "e", "f" });  
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2)), liveBits, mergedFile, INDEX_NAME, 0L);
        );  
        Path tempDir = createTempDir();
        IllegalArgumentException ex = expectThrows(  
        String mergedFile = tempDir.resolve("merged.parquet").toString();
        Path tempDir = createTempDir();  
        }
        assertEquals("3 unfiltered rows + 1 surviving row", 4, RustBridge.getFileMetadata(mergedFile).numRows());
                writer.write(dataExport.getArrayAddress(), dataExport.getSchemaAddress());
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 200, 400, 600 }, new String[] { "b", "d", "f" });
            return new ArrowExport(array, arrowSchema);
}
 * this file be licensed under the Apache-2.0 license or a
            writer.flush();
import org.apache.arrow.vector.types.pojo.Schema;
        long[][] liveBits = new long[][] { null, { 0b001L } };  
        long[][] liveBits = new long[][] { { 0b111L }, { 0b111L } };
        Path tempDir = createTempDir();
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1)), null, mergedFile, INDEX_NAME, 0L);  
import org.apache.arrow.vector.types.pojo.ArrowType;
            writer.initialize(INDEX_NAME, schemaExport.getSchemaAddress(), sortConfig, 0L);
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100 }, new String[] { "a" });  
        RustBridge.onSettingsUpdate(settings);
    public void testMergeWithMismatchedLiveDocsLengthThrows() throws Exception {
    /** A null bitset entry disables filtering for that file only. */
    public void testMergeWithInterleavedTimestamps() throws Exception {
            for (int i = 0; i < timestamps.length; i++) {
    @Override
            () -> RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2)), liveBits, mergedFile, INDEX_NAME, 0L)
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2)), liveBits, mergedFile, INDEX_NAME, 0L);  
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 200, 300 }, new String[] { "a", "b", "c" });  
// singleton that persists after tests complete. It polls for new async IO tasks between merges.
        // file1: rows 0 and 2 alive, row 1 dead. file2: only row 1 alive.  
        // The empty output is still a structurally valid parquet file: the footer must be readable.  
        RustBridge.onSettingsUpdate(settings);  
        RustBridge.onSettingsUpdate(settings);
        assertEquals("all rows dead — merged output must contain zero rows", 0, merged.metadata().numRows());
        RustBridge.onSettingsUpdate(settings);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
    }
            VarCharVector msgVec = (VarCharVector) root.getVector("message");  
    }
            mergedFile,  
        long[][] liveBits = new long[][] { { 0b1L } }; // 1 entry for 2 files  
        // 4. Verify merged output  
        assertEquals("2 rows from file1 + 1 row from file2 must survive", 3, RustBridge.getFileMetadata(mergedFile).numRows());  
        // 3. Merge
        String mergedFile = tempDir.resolve("merged.parquet").toString();  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(6, RustBridge.getFileMetadata(mergedFile).numRows());
import org.apache.arrow.c.ArrowSchema;
    }  
        RustBridge.onSettingsUpdate(settings);
import org.apache.arrow.c.Data;
 */  
     * Creates a sorted Parquet file via the full Rust writer pipeline:
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 400, 500, 600 }, new String[] { "d", "e", "f" });
        );  
    }
        schema = new Schema(  
        allocator.close();
        long[][] liveBits = new long[][] { { 0L }, { 0L } };  
        // Interleaved ranges — merge must sort globally
        RustBridge.removeSettings(INDEX_NAME);
        assertEquals(9, mergedMeta.numRows());
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();  
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
    /** A live-docs array whose length doesn't match the input file count is rejected up front. */  
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 10, 20, 30 }, new String[] { "x", "y", "z" });
    public void testMergeWithAllRowsDeadProducesValidEmptyFile() throws Exception {  
import org.apache.arrow.memory.BufferAllocator;  
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);  
import java.util.List;
    }  
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
    /** Rows flagged dead in the live-docs bitset are dropped from the merged output. */  
import org.apache.arrow.vector.VectorSchemaRoot;
        );
            try (ArrowExport dataExport = exportData(timestamps, messages)) {  
        RustBridge.removeSettings(INDEX_NAME);
import org.opensearch.nativebridge.spi.ArrowExport;  
 *
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2)), liveBits, mergedFile, INDEX_NAME, 0L);
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
        ParquetFileMetadata mergedMeta = RustBridge.getFileMetadata(mergedFile);
        RustBridge.removeSettings(INDEX_NAME);
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();  
            }
    // ========== Live-docs delete filtering ==========
        ParquetSortConfig sortConfig = new ParquetSortConfig(List.of("timestamp"), List.of(false), List.of(false), List.of(false));  
import java.nio.file.Path;
        return filePath;  
/*  
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
    private static final String INDEX_NAME = "merge-test-index";  
        assertEquals(3, RustBridge.getFileMetadata(file2).numRows());
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
    public void tearDown() throws Exception {  
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 400, 500, 600 }, new String[] { "d", "e", "f" });
    private Schema schema;
        String file3 = createSortedFile(tempDir, "f3.parquet", new long[] { 700, 800, 900 }, new String[] { "g", "h", "i" });  
import org.apache.arrow.memory.RootAllocator;
        assertEquals(0, RustBridge.getFileMetadata(mergedFile).numRows());
        // Verify individual files
        // 1. Push settings  
    private String createSortedFile(Path dir, String name, long[] timestamps, String[] messages) throws Exception {
        assertEquals(6, RustBridge.getFileMetadata(mergedFile).numRows());  
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2)), null, mergedFile, INDEX_NAME, 0L);
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 400, 500, 600 }, new String[] { "d", "e", "f" });  
        String mergedFile = tempDir.resolve("merged.parquet").toString();  
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").build();
        assertEquals(3, RustBridge.getFileMetadata(file3).numRows());
    }
        return new ArrowExport(null, arrowSchema);  
    }  
            ArrowArray array = ArrowArray.allocateNew(allocator);
            root.setRowCount(timestamps.length);
import org.apache.arrow.vector.BigIntVector;
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 200 }, new String[] { "b" });
        RustBridge.removeSettings(INDEX_NAME);
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 200, 300 }, new String[] { "a", "b", "c" });
            0L
        Path tempDir = createTempDir();
    private ArrowExport exportSchema() {  
            )
                new Field("message", FieldType.nullable(new ArrowType.Utf8()), null)  
        String mergedFile = tempDir.resolve("merged.parquet").toString();
import java.nio.charset.StandardCharsets;  
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)  
package org.opensearch.parquet.bridge;
    public void setUp() throws Exception {
        RustBridge.initLogger();
    public void testMergeSingleFile() throws Exception {  
        }
        String filePath = dir.resolve(name).toString();
        String mergedFile = tempDir.resolve("merged.parquet").toString();
    }
    private ArrowExport exportData(long[] timestamps, String[] messages) {  
        // file1 unfiltered (null entry); file2 keeps only row 0.
    }  
        RustBridge.mergeParquetFilesInRust(List.of(Path.of(file1), Path.of(file2), Path.of(file3)), null, mergedFile, INDEX_NAME, 0L);
                msgVec.setSafe(i, messages[i].getBytes(StandardCharsets.UTF_8));  
            IllegalArgumentException.class,
        String mergedFile = tempDir.resolve("merged.parquet").toString();  
        try (ArrowExport schemaExport = exportSchema()) {
     * createWriter (with sort config) → write → finalizeWriter.
        String file2 = createSortedFile(tempDir, "f2.parquet", new long[] { 400, 500, 600 }, new String[] { "d", "e", "f" });
    public void testMergeWithNullLiveDocsEntryKeepsFileUnfiltered() throws Exception {  
    public void testMergeSortedFiles() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
        Data.exportSchema(allocator, schema, null, arrowSchema);
        RustBridge.removeSettings(INDEX_NAME);  
        Path tempDir = createTempDir();  
        NativeSettings settings = NativeSettings.builder().indexName(INDEX_NAME).compressionType("LZ4_RAW").compressionLevel(2).build();
        String file1 = createSortedFile(tempDir, "f1.parquet", new long[] { 100, 200, 300 }, new String[] { "a", "b", "c" });
        MergeFilesResult merged = RustBridge.mergeParquetFilesInRust(  
        RustBridge.onSettingsUpdate(settings);
            NativeParquetWriter writer = new NativeParquetWriter(filePath);  
        assertTrue(ex.getMessage().contains("must match"));
            }
        super.setUp();  
        RustBridge.removeSettings(INDEX_NAME);  
    public void testMergeWithAllAliveBitmapKeepsEveryRow() throws Exception {
    }
        // Every row in every input is dead.
    private BufferAllocator allocator;
 * The OpenSearch Contributors require contributions made to  
        String mergedFile = tempDir.resolve("merged.parquet").toString();
