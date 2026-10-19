     * Stores {@code value}'s low bits into the width-specific Arrow vector. Every vector here exposes  
        if (batch == null || batch.contains(row) == false) {
        }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
                    reader.loadBatchContaining(row);
        assertIntegralColumn(ubyteFile, DecodedBatch.KIND_UBYTE, ubyteValues);
            for (int i = 0; i < values.length; i++) {
        }
                assertEquals("value at row " + row, expected(row), batch.valueAt(row));
        Schema schema = new Schema(
    /**
     * vectors reinterpret those bits without sign, which is exactly what the read path must reverse.
        DecodedBatch batch = reader.decodedBatch();
        }
        NativeParquetWriter writer = new NativeParquetWriter(file.toString());
import org.opensearch.parquet.bridge.RustBridge;  
    }  
    // u32 into a non-negative long. If the codec sign-extended it instead (the i32 path), any value
            .build();
    private static long expected(long row) {  
            reader.loadBatchContaining(0);
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
                boolean expectNull = row % nullEvery == 0;
        writeLongColumn(file, rowCount, true, nullEvery);
            }
                }
            vector.setInitialCapacity(values.length);
import org.opensearch.nativebridge.spi.ArrowExport;  
    public void tearDown() throws Exception {
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
            throw new IllegalArgumentException("unsupported integral vector " + vector.getClass().getName());  
                assertEquals("value at row " + row, values[row], batch.valueAt(row));  
        } else if (vector instanceof SmallIntVector v) {  
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
            }  
        writeIntegralColumn(ushortFile, new ArrowType.Int(16, false), ushortValues);
    public void testResidentRowIsServedWithoutMovingTheCursor() throws Exception {  
import org.opensearch.be.datafusion.DatafusionSettings;
            vector.allocateNew(rowCount);  
 * SPDX-License-Identifier: Apache-2.0
        int nullEvery = 5;  
        }  
     */
        super.setUp();  
    // above Integer.MAX_VALUE - here 3000000000 and 4294967295 - would surface as a negative long.  
 * Tokio runtime manager is a per-JVM singleton whose threads outlive any one test class.  
            return new ArrowExport(array, arrowSchema);
            v.setSafe(index, (int) value);  
            }
    private static void setIntegral(FieldVector vector, int index, long value) {
        // Deliberately never shut down - doing so kills the shared executor for the rest of the JVM.  
            vector.setValueCount(rowCount);
            List.of(new Field(COLUMN, FieldType.notNullable(new ArrowType.FloatingPoint(FloatingPointPrecision.SINGLE)), null))
import org.apache.lucene.util.NumericUtils;  
     * index settings (as two indices would open them), get different decode windows.
            assertTrue("default initial window (32) must include row 4", batch.contains(4));
                reader.loadBatchContaining(row);
    private void writeDoubleColumn(Path file, double[] values) throws Exception {  
                }  
        }
                writer.write(dataExport.getArrayAddress(), dataExport.getSchemaAddress());  
    public void testIndexScopedBatchSizeSettingsAreHonouredPerReader() throws Exception {  
            writer.initialize("test-index", schemaExport.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
            for (long row = 0; row < rowCount; row++) {
    }
import org.apache.arrow.vector.types.pojo.Schema;
        writeIntegralColumn(ubyteFile, new ArrowType.Int(8, false), ubyteValues);
        // Idempotent: the manager is a OnceLock, so another test class may already have started it.
    private void writeLongColumn(Path file, int rowCount, boolean nullable, int nullEvery) throws Exception {
import org.apache.arrow.c.Data;
        writeLongColumn(file, rowCount, false, -1);
                assertEquals("value kind", expectedKind, batch.valueKind());
                DecodedBatch batch = loadRow(reader, row);  
            assertFalse("initial window of 4 must not include row 4", batch.contains(4));  
                assertEquals("value at row " + row, values[row], NumericUtils.sortableIntToFloat((int) batch.valueAt(row)), 0.0f);
        NativeParquetWriter writer = new NativeParquetWriter(file.toString());
    public void testUnsignedIntColumnZeroExtends() throws Exception {
    }
        assertIntegralColumn(ushortFile, DecodedBatch.KIND_USHORT, ushortValues);  
            // Negatives must sort below positives in the encoded long space (range/skipper consumers).
        }
            v.setSafe(index, (int) value);
import org.apache.arrow.vector.Float8Vector;
                if (batch == null || batch.contains(row) == false) {  
    // surface as 4294967295 and Integer.MIN_VALUE as 2147483648 - this test catches that swap.
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
     */
        return row * 7 + 1;
 * this file be licensed under the Apache-2.0 license or a
            reader.loadBatchContaining(row);  
            }  
        try (ArrowExport schemaExport = exportSchema(schema)) {  
        writeFloatColumn(file, values);
    // Zero-extension coverage for KIND_UINT_BITS: an unsigned 32-bit column must widen each stored
     * reusing the same {@link NativeParquetWriter}/{@link ParquetSortConfig} path as
        long[] values = { 0L, 42L, 3000000000L, 4294967295L };
                    reader.loadBatchContaining(row);
            vector.setValueCount(values.length);
    public void testForwardJumpAndBackwardReopen() throws Exception {  
                assertEquals("resident row must not reload the batch", lastRow, batch.lastRow());
        int rowCount = 500;
                setIntegral(vector, i, values[i]);
            reader.loadBatchContaining(10);
    public void setUp() throws Exception {
                assertEquals("value at row " + row, values[row], NumericUtils.sortableLongToDouble(batch.valueAt(row)), 0.0);  
        FieldType fieldType = nullable  
            for (long row = 400; row <= 410; row++) {
            expectThrows(IndexOutOfBoundsException.class, () -> batch.isPresent(batch.lastRow() + 1));
        Data.exportSchema(allocator, schema, null, arrowSchema);
        Path file = createTempDir().resolve("doubles.parquet");
                    vector.setNull(i);  
        long[] ushortValues = { 0L, 42L, 50000L, 65535L };  
            }
            for (long row = firstRow; row <= lastRow; row++) {  
        try (ArrowExport schemaExport = exportSchema(schema)) {
                DecodedBatch current = reader.decodedBatch();
            assertEquals("value at row 10", expected(10), batch.valueAt(10));  
            vector.allocateNew(values.length);
import org.opensearch.parquet.bridge.ParquetSortConfig;
                if (current == null || current.contains(row) == false) {
        globalRuntimePtr = DataFusionRuntimeFixture.createGlobalRuntime(createTempDir("datafusion-spill"));
            FieldVector vector = root.getVector(COLUMN);
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);  
                assertTrue("row " + row + " should be present", batch.isPresent(row));  
            root.setRowCount(values.length);  
            long firstRow = reader.decodedBatch().firstRow();
        int rowCount = 500;
                assertEquals("resident row must not reload the batch", firstRow, batch.firstRow());  
    public void testShortAndByteColumnsSignExtend() throws Exception {
        writeDoubleColumn(file, values);  
        writeLongColumn(file, rowCount, false, -1);  
import org.apache.arrow.vector.IntVector;  
        writer.flush();
        Path file = createTempDir().resolve("floats.parquet");
            try (ArrowExport dataExport = new ArrowExport(array, arrowSchema)) {
import org.apache.arrow.vector.VectorSchemaRoot;  
 * End-to-end coverage for the numeric Parquet doc-values read bridge: writes a real Parquet fixture
        }
 * falling back to a private pool and cache of its own. Thread-leak detection is off because the
                }  
        } else if (vector instanceof UInt1Vector v) {  
            // The bitmap is byte-granular, so a row just past the batch can still land inside the
import org.apache.arrow.vector.BigIntVector;
    }
                assertTrue("u32 value at row " + row + " must be non-negative", loadRow(reader, row).valueAt(row) >= 0L);  
        );  
        assertNotEquals("global runtime must start before a cursor can be opened", 0L, globalRuntimePtr);  
    // the identically-signed long. If the codec zero-extended it instead (the u32 path), -1 would
            vector.allocateNew(values.length);
        }  
                DecodedBatch batch = reader.decodedBatch();  
            writer.initialize("test-index", schemaExport.getSchemaAddress(), ParquetSortConfig.empty(), 0L);  
                writer.write(dataExport.getArrayAddress(), dataExport.getSchemaAddress());
        Path file = createTempDir().resolve("ascending.parquet");  
        NativeParquetWriter writer = new NativeParquetWriter(file.toString());
            reader.loadBatchContaining(0);
    }  
            assertNull("no batch may remain resident after a failed load", reader.decodedBatch());
        } else if (vector instanceof UInt4Vector v) {
        int rowCount = 500;
            // because a successful native call frees the buffers the old batch borrowed.
        float[] values = { -100.5f, -0.5f, 0.0f, 3.25f, -2.75f, 42.0f, -3.4e38f, 3.4e38f };  
                    assertFalse("row " + row + " should be null", batch.isPresent(row));
        Path file = createTempDir().resolve("bounds.parquet");
    }
            root.setRowCount(values.length);
            for (int i = 0; i < values.length; i++) {
            batch = reader.decodedBatch();
            // The native cursor parks at lastRow + 1, so each of these would be a backward seek if
            writer.initialize("test-index", schemaExport.getSchemaAddress(), ParquetSortConfig.empty(), 0L);  
                assertEquals(DecodedBatch.KIND_FLOAT, batch.valueKind());  
    }
    public void testPresenceLookupOutsideTheBatchThrows() throws Exception {
        writeLongColumn(file, rowCount, false, -1);  
                writer.write(dataExport.getArrayAddress(), dataExport.getSchemaAddress());  
import org.apache.arrow.vector.types.FloatingPointPrecision;
 * with {@link NativeParquetWriter}, then walks it through the FFM zero-copy borrow path  
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
     * {@link #writeLongColumn}. Each supplied {@code long} is narrowed to the column's width by its
            try (ArrowExport dataExport = new ArrowExport(array, arrowSchema)) {
    }  
    // Zero-extension coverage for KIND_USHORT and KIND_UBYTE: an unsigned 16- or 8-bit column must
                    batch = reader.decodedBatch();  
                    assertEquals("value at row " + row, expected(row), batch.valueAt(row));
                }  
}  
 * (Java -> native Rust cursor -> Arrow decode -> borrowed buffers read back in Java).
import org.apache.arrow.c.ArrowArray;  
        Path byteFile = createTempDir().resolve("int8-signed.parquet");  
            }
import org.apache.arrow.c.ArrowSchema;
                DecodedBatch batch = loadRow(reader, row);
            List.of(new Field(COLUMN, FieldType.notNullable(new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE)), null))
import org.opensearch.common.settings.Settings;
        Path ushortFile = createTempDir().resolve("uint16.parquet");
        }
                assertTrue("row " + row + " should be in the batch", batch.contains(row));
    }
            assertTrue("row 10 should be present", batch.isPresent(10));
        writer.flush();  
            v.setSafe(index, (int) value);  
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);  
    public void testIntColumnSignExtendsNegatives() throws Exception {  
                if (nullEvery > 0 && i % nullEvery == 0) {
        RustBridge.initLogger();
                    reader.loadBatchContaining(row);  
    }
            reader.loadBatchContaining(64);
        } else if (vector instanceof TinyIntVector v) {
import java.nio.file.Path;
/*  
import java.io.IOException;  
                assertEquals("value at row " + row, expected(row), batch.valueAt(row));
                assertTrue("row " + row + " should be present after forward jump", batch.isPresent(row));
        writeLongColumn(file, rowCount, true, 5);
import org.apache.arrow.vector.UInt2Vector;
        writeLongColumn(file, rowCount, false, -1);
    private void writeFloatColumn(Path file, float[] values) throws Exception {  
        int rowCount = 500;
    /** Reads every row back and asserts both the mapped value kind and the exact widened long. */
    }
import org.apache.arrow.vector.UInt4Vector;
                }
                } else {
            ArrowArray array = ArrowArray.allocateNew(allocator);
        long[] byteValues = { -1L, Byte.MIN_VALUE, -50L, 0L, 42L, Byte.MAX_VALUE };
        writeIntegralColumn(shortFile, new ArrowType.Int(16, true), shortValues);
            // mapped bytes. It must be rejected rather than answered from a neighbouring bit.  
import org.opensearch.test.OpenSearchTestCase;
            Float4Vector vector = (Float4Vector) root.getVector(COLUMN);  
                // valueAt returns the sortable long; sortableLongToDouble must recover the original value.
     * Registering a setting as {@code IndexScope} only makes it *settable* per index; this proves
            reader.loadBatchContaining(0);
    /**
            for (int i = 0; i < rowCount; i++) {
                if (batch.contains(row) == false) {  
            DataFusionRuntimeFixture.closeGlobalRuntime(globalRuntimePtr);
     * maximum via the same {@code long[]}), matching how the reader widens the stored bits back.
import org.apache.arrow.vector.types.pojo.Field;  
        }
        DataFusionRuntimeFixture.initRuntimeManager(2);
    private ArrowExport exportData(Schema schema, int rowCount, int nullEvery) {  
                if (expectNull) {  
     * low bits (so callers can express both signed negatives and unsigned values above the signed  
        }
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {  
        Path file = createTempDir().resolve("resident.parquet");
 * The OpenSearch Contributors require contributions made to  
        }
            // Dense walk: the adaptive window may grow, but never past max_batch_size = 8.
        }
        }
    }  
    private void assertIntegralColumn(Path file, int expectedKind, long[] values) throws Exception {  
    private long globalRuntimePtr;
            for (int row = 0; row < values.length; row++) {
            vector.setValueCount(values.length);
            root.setRowCount(values.length);  
 */  
            }
                DecodedBatch batch = reader.decodedBatch();
        return new ArrowExport(null, arrowSchema);  
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
    // -15536 (u16) and 200 into -56 (u8) once the top bit is set.
                assertEquals("value at row " + row, expected(row), batch.valueAt(row));
        writer.flush();  
        int rowCount = 500;
        writer.flush();  
            DecodedBatch batch = loadRow(reader, 0);
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {  
        }
        writeIntegralColumn(byteFile, new ArrowType.Int(8, true), byteValues);
        Path shortFile = createTempDir().resolve("int16-signed.parquet");
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
     */  
        Schema schema = new Schema(
        allocator = new RootAllocator();
        long[] shortValues = { -1L, Short.MIN_VALUE, -1234L, 0L, 42L, Short.MAX_VALUE };  
    public void testNullPresenceBitmap() throws Exception {
    }
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
        }  
        double[] values = { -100.5, -0.5, 0.0, 3.25, -2.75, 42.0, -1.0e300, 1.0e300 };
                }
                assertTrue("row " + row + " should be in the batch", current.contains(row));  
                DecodedBatch batch = loadRow(reader, row);  
            reader.loadBatchContaining(100);  
    public void testNegativeFloatsUseSignExtendedSortableEncoding() throws Exception {
            expectThrows(IndexOutOfBoundsException.class, () -> batch.isPresent(batch.firstRow() - 1));
        Schema schema = new Schema(List.of(new Field(COLUMN, FieldType.notNullable(arrowType), null)));
            assertTrue("negative float must sort below positive (sign-extended)", batch.valueAt(0) < batch.valueAt(5));
     * Writes a single non-nullable integer column of the caller-chosen Arrow width and signedness,  
            DecodedBatch batch = loadRow(reader, 0);  
            }  
        }
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
            for (long row = 0; row < rowCount; row++) {
            ArrowArray array = ArrowArray.allocateNew(allocator);
        }  
        }  
            }
        NativeParquetWriter writer = new NativeParquetWriter(file.toString());
            ArrowArray array = ArrowArray.allocateNew(allocator);
        assertIntegralColumn(byteFile, DecodedBatch.KIND_BYTE, byteValues);
                DecodedBatch batch = reader.decodedBatch();
        Path file = createTempDir().resolve("nullable.parquet");
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        return batch;  
            DecodedBatch batch = reader.decodedBatch();  
        Path file = createTempDir().resolve("int32-signed.parquet");
            }
                    current = reader.decodedBatch();
 *
        } else {
    }  
        }
        super.tearDown();  
                assertTrue("row " + row + " should be present", batch.isPresent(row));
import org.apache.arrow.memory.BufferAllocator;  
        Path file = createTempDir().resolve("jump.parquet");
     * the value is *honoured* per reader: two readers over the same file, opened with different  
        Schema schema = new Schema(List.of(new Field(COLUMN, fieldType, null)));  
            }  
    // widen each stored value into a non-negative long. A sign-extension bug would turn 50000 into  
        if (allocator != null) {  
    }
    // 65535 (short) / 255 (byte) and the MIN_VALUEs into their positive u16/u8 counterparts.
                    vector.setSafe(i, expected(i));
            reader.loadBatchContaining(400);  
            writer.write(dataExport.getArrayAddress(), dataExport.getSchemaAddress());
        }
    }
            }
            vector.allocateNew();  
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);  
            try (ArrowExport dataExport = new ArrowExport(array, arrowSchema)) {
    public void testNegativeDoublesUseSortableEncoding() throws Exception {  
        writeIntegralColumn(file, new ArrowType.Int(32, true), values);  
        );  
    // each stored value into the identically-signed long. A zero-extension bug would turn -1 into  
        }
                    batch = reader.decodedBatch();
import org.apache.arrow.memory.RootAllocator;
            BigIntVector vector = (BigIntVector) root.getVector(COLUMN);
    // Sign-extension coverage for KIND_SHORT and KIND_BYTE: a signed 16- or 8-bit column must widen
    /**
            ArrowArray array = ArrowArray.allocateNew(allocator);
 *
        Path file = createTempDir().resolve("uint32.parquet");  
        if (globalRuntimePtr != 0L) {  
            ? FieldType.nullable(new ArrowType.Int(64, true))
                vector.setSafe(i, values[i]);  
import org.apache.arrow.vector.SmallIntVector;
        }
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
public class ParquetColumnReaderTests extends OpenSearchTestCase {  
        assertIntegralColumn(shortFile, DecodedBatch.KIND_SHORT, shortValues);  
                assertFalse("window must stay capped at max_batch_size=8 rows", current.contains(row + 8));
import java.util.List;
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
    // Sign-extension coverage for KIND_INT: a signed 32-bit column must widen each stored int into  
import org.apache.arrow.vector.UInt1Vector;  
/**
        assertIntegralColumn(file, DecodedBatch.KIND_INT, values);
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        long[] values = { -1L, Integer.MIN_VALUE, -987654L, 0L, 42L, Integer.MAX_VALUE };
        long[] ubyteValues = { 0L, 42L, 200L, 255L };
        int rowCount = 500;  
    private void writeIntegralColumn(Path file, ArrowType.Int arrowType, long[] values) throws Exception {  
            DecodedBatch batch = reader.decodedBatch();  
    }
        int rowCount = 500;
        // Explicitly guard the sign: zero-extension must never produce a negative long.  
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);  
                    batch = reader.decodedBatch();
    }  
            .put(DatafusionSettings.DOCVALUES_MAX_BATCH_SIZE.getKey(), 8)
    }
            expectThrows(IOException.class, () -> reader.loadBatchContaining(rowCount));  
            DecodedBatch batch = reader.decodedBatch();  
            vector.setValueCount(values.length);
        if (vector instanceof IntVector v) {
    @Override
        }
            allocator.close();
            Float8Vector vector = (Float8Vector) root.getVector(COLUMN);  
    }  
            .put(DatafusionSettings.DOCVALUES_INITIAL_BATCH_SIZE.getKey(), 4)  
            assertTrue(batch.contains(3));
        assertIntegralColumn(file, DecodedBatch.KIND_UINT_BITS, values);
import org.apache.arrow.vector.TinyIntVector;
        }
            root.setRowCount(rowCount);  
            }
            v.setSafe(index, (int) value);
            for (int i = 0; i < values.length; i++) {
            for (int row = 0; row < values.length; row++) {
                assertEquals(DecodedBatch.KIND_LONG, batch.valueKind());
        } else if (vector instanceof UInt2Vector v) {
    private static final String COLUMN = "value";
            for (long row = 0; row < rowCount; row++) {  
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
            for (int row = 0; row < values.length; row++) {
    }
            // Sign-extended, so a negative float's long compares below a positive float's long.  
    private ArrowExport exportSchema(Schema schema) {  
 * compatible open source license.
package org.opensearch.be.datafusion.docvalues.bridge;
    }
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {  
    @Override
            // A load past the end fails. The batch it would have replaced must not stay reachable,
            }
        try (ArrowExport dataExport = exportData(schema, rowCount, nullEvery)) {  
            assertNotNull("a batch should be resident after a successful load", reader.decodedBatch());
import org.opensearch.parquet.bridge.NativeParquetWriter;
            }  
    private static DecodedBatch loadRow(ParquetColumnReader reader, long row) throws java.io.IOException {  
 * analytics-backend-datafusion plugin owns, so each test starts a runtime rather than the reader
        Path file = createTempDir().resolve("scoped.parquet");
            for (int row = 0; row < values.length; row++) {
                assertEquals(DecodedBatch.KIND_DOUBLE, batch.valueKind());
        writeLongColumn(file, rowCount, false, -1);  
                vector.setSafe(i, values[i]);  
        try (ArrowExport schemaExport = exportSchema(schema)) {  
        writeIntegralColumn(file, new ArrowType.Int(32, false), values);
            : FieldType.notNullable(new ArrowType.Int(64, true));
    public void testAscendingWalkReloadsBatches() throws Exception {
            v.setSafe(index, (int) value);
            // it reached the native side.
import org.apache.arrow.vector.types.pojo.FieldType;
        // load — the two readers diverge purely on the Settings they were opened with.  
     * {@code setSafe(int, int)}, so the {@code (int)} cast carries the raw bit pattern - the unsigned
            assertTrue("row 10 should be in the batch after backward reopen", batch.contains(10));
                    assertTrue("row " + row + " should be present", batch.isPresent(row));  
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
        try (ArrowExport schemaExport = exportSchema(schema)) {
import org.apache.arrow.vector.FieldVector;  
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
                    reader.loadBatchContaining(row);
            v.setSafe(index, (int) value);
            writer.initialize("test-index", schemaExport.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
    public void testFailedLoadDoesNotRetainTheStaleBatch() throws Exception {
            assertTrue(batch.contains(0));
 */
                if (batch == null || batch.contains(row) == false) {
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN, small)) {
        Path ubyteFile = createTempDir().resolve("uint8.parquet");  
    }
                } else {
            assertTrue("negative double must sort below positive", batch.valueAt(0) < batch.valueAt(5));
    }  
            }
    }
    public void testUnsignedShortAndByteZeroExtend() throws Exception {
                DecodedBatch batch = reader.decodedBatch();
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {  
            long lastRow = reader.decodedBatch().lastRow();
import org.apache.arrow.vector.Float4Vector;
        Settings small = Settings.builder()
        Path file = createTempDir().resolve("stale.parquet");  
            DecodedBatch batch = reader.decodedBatch();  
    private BufferAllocator allocator;
        // The same file under default settings (initial 32): row 4 IS resident after the first
import org.apache.arrow.vector.types.pojo.ArrowType;
 * <p>Opening a cursor needs the DataFusion runtime manager and the global file-metadata cache the  
