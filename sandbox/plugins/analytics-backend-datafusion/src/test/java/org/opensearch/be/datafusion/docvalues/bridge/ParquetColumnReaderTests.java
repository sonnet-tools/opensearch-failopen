                assertTrue("row " + row + " should be present", batch.isPresent(row));
                assertEquals("resident row must not reload the batch", lastRow, batch.lastRow());
 */
    public void testFailedLoadDoesNotRetainTheStaleBatch() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
                writer.write(dataExport.getArrayAddress(), dataExport.getSchemaAddress());
        try (ArrowExport schemaExport = exportSchema(schema)) {
        }
                }
import org.apache.lucene.util.NumericUtils;
import org.apache.arrow.vector.UInt4Vector;
import org.opensearch.common.settings.Settings;
import java.nio.file.Path;
        NativeParquetWriter writer = new NativeParquetWriter(file.toString());
        writer.flush();
     * reusing the same {@link NativeParquetWriter}/{@link ParquetSortConfig} path as
        long[] ushortValues = { 0L, 42L, 50000L, 65535L };
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
    }
        }
        int nullEvery = 5;
    public void testAscendingWalkReloadsBatches() throws Exception {
            }
        writeIntegralColumn(ushortFile, new ArrowType.Int(16, false), ushortValues);
                assertEquals("value at row " + row, values[row], batch.valueAt(row));
                } else {
            long lastRow = reader.decodedBatch().lastRow();
import org.apache.arrow.c.ArrowArray;
        }
                boolean expectNull = row % nullEvery == 0;
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
    }
        double[] values = { -100.5, -0.5, 0.0, 3.25, -2.75, 42.0, -1.0e300, 1.0e300 };
        }
        Path file = createTempDir().resolve("bounds.parquet");
        }
                    batch = reader.decodedBatch();
        writeLongColumn(file, rowCount, false, -1);
                DecodedBatch current = reader.decodedBatch();
                DecodedBatch batch = reader.decodedBatch();
    // each stored value into the identically-signed long. A zero-extension bug would turn -1 into
            expectThrows(IOException.class, () -> reader.loadBatchContaining(rowCount));
        writeIntegralColumn(byteFile, new ArrowType.Int(8, true), byteValues);
        try (ArrowExport dataExport = exportData(schema, rowCount, nullEvery)) {
import org.opensearch.parquet.bridge.ParquetSortConfig;
    @Override
                DecodedBatch batch = reader.decodedBatch();
        } else if (vector instanceof UInt4Vector v) {
            .put(DatafusionSettings.DOCVALUES_MAX_BATCH_SIZE.getKey(), 8)
                    assertFalse("row " + row + " should be null", batch.isPresent(row));
 * The OpenSearch Contributors require contributions made to
                assertEquals("value at row " + row, expected(row), batch.valueAt(row));
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
    private static DecodedBatch loadRow(ParquetColumnReader reader, long row) throws java.io.IOException {
    // widen each stored value into a non-negative long. A sign-extension bug would turn 50000 into
        // Deliberately never shut down - doing so kills the shared executor for the rest of the JVM.
     */
        if (globalRuntimePtr != 0L) {
     * the value is *honoured* per reader: two readers over the same file, opened with different
        return new ArrowExport(null, arrowSchema);
import org.apache.arrow.vector.SmallIntVector;
        }
import org.apache.arrow.vector.UInt2Vector;
            assertFalse("initial window of 4 must not include row 4", batch.contains(4));
        writeLongColumn(file, rowCount, false, -1);
                if (batch == null || batch.contains(row) == false) {
            writer.initialize("test-index", schemaExport.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
        // load — the two readers diverge purely on the Settings they were opened with.
            assertTrue(batch.contains(3));
                if (expectNull) {
    public void setUp() throws Exception {
            for (int row = 0; row < values.length; row++) {
                assertEquals("resident row must not reload the batch", firstRow, batch.firstRow());
                    batch = reader.decodedBatch();
                }
            allocator.close();
     * {@link #writeLongColumn}. Each supplied {@code long} is narrowed to the column's width by its
        int rowCount = 500;
            assertEquals("value at row 10", expected(10), batch.valueAt(10));
    private void assertIntegralColumn(Path file, int expectedKind, long[] values) throws Exception {
        Data.exportSchema(allocator, schema, null, arrowSchema);
    }
                } else {
    private static long expected(long row) {
        }
    private long globalRuntimePtr;
 * compatible open source license.
        Path file = createTempDir().resolve("stale.parquet");
        writeDoubleColumn(file, values);
        } else if (vector instanceof UInt2Vector v) {
    }
        long[] values = { -1L, Integer.MIN_VALUE, -987654L, 0L, 42L, Integer.MAX_VALUE };
import org.apache.arrow.vector.Float4Vector;
        allocator = new RootAllocator();
        float[] values = { -100.5f, -0.5f, 0.0f, 3.25f, -2.75f, 42.0f, -3.4e38f, 3.4e38f };
        // Idempotent: the manager is a OnceLock, so another test class may already have started it.
    }
                }
     * index settings (as two indices would open them), get different decode windows.
            vector.allocateNew(values.length);
            DecodedBatch batch = reader.decodedBatch();
import org.opensearch.parquet.bridge.NativeParquetWriter;
                    reader.loadBatchContaining(row);
                DecodedBatch batch = loadRow(reader, row);
        }
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
        NativeParquetWriter writer = new NativeParquetWriter(file.toString());
     */
            }
                    reader.loadBatchContaining(row);
            assertNotNull("a batch should be resident after a successful load", reader.decodedBatch());
            try (ArrowExport dataExport = new ArrowExport(array, arrowSchema)) {
 * falling back to a private pool and cache of its own. Thread-leak detection is off because the
        }
            expectThrows(IndexOutOfBoundsException.class, () -> batch.isPresent(batch.firstRow() - 1));
        try (ArrowExport schemaExport = exportSchema(schema)) {
    }
            DecodedBatch batch = reader.decodedBatch();
                    assertEquals("value at row " + row, expected(row), batch.valueAt(row));
        Path file = createTempDir().resolve("ascending.parquet");
        }
            List.of(new Field(COLUMN, FieldType.notNullable(new ArrowType.FloatingPoint(FloatingPointPrecision.SINGLE)), null))
        assertIntegralColumn(shortFile, DecodedBatch.KIND_SHORT, shortValues);
        Path file = createTempDir().resolve("resident.parquet");
        int rowCount = 500;
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
            DecodedBatch batch = reader.decodedBatch();
        }
                assertTrue("row " + row + " should be in the batch", batch.contains(row));
            for (int i = 0; i < values.length; i++) {
        Path ubyteFile = createTempDir().resolve("uint8.parquet");
            DecodedBatch batch = loadRow(reader, 0);
            assertTrue(batch.contains(0));
            }
            }
        }
                writer.write(dataExport.getArrayAddress(), dataExport.getSchemaAddress());
            for (int i = 0; i < values.length; i++) {
            root.setRowCount(rowCount);
            }
    private void writeIntegralColumn(Path file, ArrowType.Int arrowType, long[] values) throws Exception {
import org.apache.arrow.vector.types.pojo.Schema;
    public void testNegativeFloatsUseSignExtendedSortableEncoding() throws Exception {
    }
            BigIntVector vector = (BigIntVector) root.getVector(COLUMN);
        Path file = createTempDir().resolve("scoped.parquet");
        writeIntegralColumn(ubyteFile, new ArrowType.Int(8, false), ubyteValues);
    /** Reads every row back and asserts both the mapped value kind and the exact widened long. */
            vector.setValueCount(rowCount);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            writer.write(dataExport.getArrayAddress(), dataExport.getSchemaAddress());
                assertTrue("u32 value at row " + row + " must be non-negative", loadRow(reader, row).valueAt(row) >= 0L);
        DecodedBatch batch = reader.decodedBatch();
            reader.loadBatchContaining(0);
        writeLongColumn(file, rowCount, false, -1);
            // A load past the end fails. The batch it would have replaced must not stay reachable,
            ? FieldType.nullable(new ArrowType.Int(64, true))
                assertEquals(DecodedBatch.KIND_DOUBLE, batch.valueKind());
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
 * <p>Opening a cursor needs the DataFusion runtime manager and the global file-metadata cache the
            reader.loadBatchContaining(400);
            reader.loadBatchContaining(64);
            for (long row = 400; row <= 410; row++) {
        }
            try (ArrowExport dataExport = new ArrowExport(array, arrowSchema)) {
            : FieldType.notNullable(new ArrowType.Int(64, true));
        Schema schema = new Schema(
            }
        writeLongColumn(file, rowCount, false, -1);
            DecodedBatch batch = loadRow(reader, 0);
    public void testUnsignedIntColumnZeroExtends() throws Exception {
            assertTrue("row 10 should be present", batch.isPresent(10));
            // The bitmap is byte-granular, so a row just past the batch can still land inside the
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        try (ArrowExport schemaExport = exportSchema(schema)) {
    }
    public void tearDown() throws Exception {
        assertIntegralColumn(file, DecodedBatch.KIND_INT, values);
        }
                vector.setSafe(i, values[i]);
    // 65535 (short) / 255 (byte) and the MIN_VALUEs into their positive u16/u8 counterparts.
    public void testForwardJumpAndBackwardReopen() throws Exception {
            }
    // -15536 (u16) and 200 into -56 (u8) once the top bit is set.
import org.apache.arrow.vector.VectorSchemaRoot;
    }
    public void testPresenceLookupOutsideTheBatchThrows() throws Exception {
                    reader.loadBatchContaining(row);
            writer.initialize("test-index", schemaExport.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
            v.setSafe(index, (int) value);
    // the identically-signed long. If the codec zero-extended it instead (the u32 path), -1 would
 * End-to-end coverage for the numeric Parquet doc-values read bridge: writes a real Parquet fixture
                assertEquals("value kind", expectedKind, batch.valueKind());
                DecodedBatch batch = reader.decodedBatch();
    public void testShortAndByteColumnsSignExtend() throws Exception {
    private void writeFloatColumn(Path file, float[] values) throws Exception {
            DecodedBatch batch = reader.decodedBatch();
            for (int row = 0; row < values.length; row++) {
    }
            for (long row = 0; row < rowCount; row++) {
            vector.setInitialCapacity(values.length);
        writeLongColumn(file, rowCount, true, nullEvery);
    }
            batch = reader.decodedBatch();
        int rowCount = 500;
import org.apache.arrow.memory.RootAllocator;
        assertNotEquals("global runtime must start before a cursor can be opened", 0L, globalRuntimePtr);
        int rowCount = 500;
                    assertTrue("row " + row + " should be present", batch.isPresent(row));
        writeFloatColumn(file, values);
    public void testNegativeDoublesUseSortableEncoding() throws Exception {
import org.apache.arrow.vector.types.FloatingPointPrecision;
     */
/*
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
    // surface as 4294967295 and Integer.MIN_VALUE as 2147483648 - this test catches that swap.
        }
            for (long row = firstRow; row <= lastRow; row++) {
        // The same file under default settings (initial 32): row 4 IS resident after the first
        } else if (vector instanceof UInt1Vector v) {
 */
        writer.flush();
        Path ushortFile = createTempDir().resolve("uint16.parquet");
            // Negatives must sort below positives in the encoded long space (range/skipper consumers).
            for (long row = 0; row < rowCount; row++) {
}
        RustBridge.initLogger();
import org.opensearch.be.datafusion.DatafusionSettings;
    }
                    reader.loadBatchContaining(row);
            ArrowSchema arrowSchema = ArrowSchema.allocateNew(allocator);
        }
 * SPDX-License-Identifier: Apache-2.0
        super.tearDown();
        }
        }
import org.apache.arrow.vector.FieldVector;
            vector.allocateNew(rowCount);
            assertTrue("row 10 should be in the batch after backward reopen", batch.contains(10));
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator)) {
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        assertIntegralColumn(byteFile, DecodedBatch.KIND_BYTE, byteValues);
                    batch = reader.decodedBatch();
import java.util.List;
                // valueAt returns the sortable long; sortableLongToDouble must recover the original value.
            long firstRow = reader.decodedBatch().firstRow();
        Schema schema = new Schema(List.of(new Field(COLUMN, FieldType.notNullable(arrowType), null)));
        Schema schema = new Schema(
            v.setSafe(index, (int) value);
        writeIntegralColumn(file, new ArrowType.Int(32, false), values);
            for (int i = 0; i < values.length; i++) {
     * Stores {@code value}'s low bits into the width-specific Arrow vector. Every vector here exposes
            vector.setValueCount(values.length);
                assertEquals(DecodedBatch.KIND_FLOAT, batch.valueKind());
        writeIntegralColumn(file, new ArrowType.Int(32, true), values);
        } else if (vector instanceof SmallIntVector v) {
                assertEquals("value at row " + row, values[row], NumericUtils.sortableIntToFloat((int) batch.valueAt(row)), 0.0f);
import org.apache.arrow.vector.types.pojo.ArrowType;
     * vectors reinterpret those bits without sign, which is exactly what the read path must reverse.
                    current = reader.decodedBatch();
        if (allocator != null) {
            expectThrows(IndexOutOfBoundsException.class, () -> batch.isPresent(batch.lastRow() + 1));
                assertTrue("row " + row + " should be present after forward jump", batch.isPresent(row));
     * {@code setSafe(int, int)}, so the {@code (int)} cast carries the raw bit pattern - the unsigned
                if (nullEvery > 0 && i % nullEvery == 0) {
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
import org.apache.arrow.vector.types.pojo.FieldType;
                assertEquals("value at row " + row, values[row], NumericUtils.sortableLongToDouble(batch.valueAt(row)), 0.0);
            root.setRowCount(values.length);
        if (batch == null || batch.contains(row) == false) {
import org.apache.arrow.vector.BigIntVector;
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        long[] shortValues = { -1L, Short.MIN_VALUE, -1234L, 0L, 42L, Short.MAX_VALUE };
            }
            for (long row = 0; row < rowCount; row++) {
        Schema schema = new Schema(List.of(new Field(COLUMN, fieldType, null)));
        }
                if (batch.contains(row) == false) {
        }
            for (int row = 0; row < values.length; row++) {
                    vector.setSafe(i, expected(i));
            }
import java.io.IOException;
    }
    // Sign-extension coverage for KIND_SHORT and KIND_BYTE: a signed 16- or 8-bit column must widen
            }
    @Override
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
            vector.allocateNew(values.length);
        return batch;
import org.apache.arrow.vector.IntVector;
        if (vector instanceof IntVector v) {
        } else {
            }
    private ArrowExport exportSchema(Schema schema) {
        );
     * maximum via the same {@code long[]}), matching how the reader widens the stored bits back.
        writeLongColumn(file, rowCount, true, 5);
    // Zero-extension coverage for KIND_UINT_BITS: an unsigned 32-bit column must widen each stored
            // mapped bytes. It must be rejected rather than answered from a neighbouring bit.
    }
                if (current == null || current.contains(row) == false) {
            reader.loadBatchContaining(100);
            }
import org.apache.arrow.memory.BufferAllocator;
        writer.flush();
        assertIntegralColumn(ubyteFile, DecodedBatch.KIND_UBYTE, ubyteValues);
 * (Java -> native Rust cursor -> Arrow decode -> borrowed buffers read back in Java).
        );
            vector.allocateNew();
            .build();
            writer.initialize("test-index", schemaExport.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
            DataFusionRuntimeFixture.closeGlobalRuntime(globalRuntimePtr);
    private void writeLongColumn(Path file, int rowCount, boolean nullable, int nullEvery) throws Exception {
        }
                    vector.setNull(i);
        Path file = createTempDir().resolve("floats.parquet");
            v.setSafe(index, (int) value);
            // Dense walk: the adaptive window may grow, but never past max_batch_size = 8.
    }
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        }
    // Sign-extension coverage for KIND_INT: a signed 32-bit column must widen each stored int into
        Path file = createTempDir().resolve("uint32.parquet");
                if (batch == null || batch.contains(row) == false) {
            assertTrue("negative float must sort below positive (sign-extended)", batch.valueAt(0) < batch.valueAt(5));
                assertEquals("value at row " + row, expected(row), batch.valueAt(row));
        writeLongColumn(file, rowCount, false, -1);
        assertIntegralColumn(ushortFile, DecodedBatch.KIND_USHORT, ushortValues);
            root.setRowCount(values.length);
        }
    }
            Float8Vector vector = (Float8Vector) root.getVector(COLUMN);
     * Registering a setting as {@code IndexScope} only makes it *settable* per index; this proves
            vector.setValueCount(values.length);
                assertTrue("row " + row + " should be present", batch.isPresent(row));
import org.apache.arrow.c.Data;
            vector.setValueCount(values.length);
                DecodedBatch batch = reader.decodedBatch();
    }
import org.apache.arrow.vector.types.pojo.Field;
        int rowCount = 500;
            ArrowArray array = ArrowArray.allocateNew(allocator);
        long[] values = { 0L, 42L, 3000000000L, 4294967295L };
import org.apache.arrow.vector.TinyIntVector;
        long[] ubyteValues = { 0L, 42L, 200L, 255L };
            reader.loadBatchContaining(0);
        assertIntegralColumn(file, DecodedBatch.KIND_UINT_BITS, values);
            root.setRowCount(values.length);
        writer.flush();
        Path file = createTempDir().resolve("nullable.parquet");
                DecodedBatch batch = loadRow(reader, row);
                assertTrue("row " + row + " should be in the batch", current.contains(row));
 *
        writeIntegralColumn(shortFile, new ArrowType.Int(16, true), shortValues);
                reader.loadBatchContaining(row);
    }
    /**
        return row * 7 + 1;
    public void testNullPresenceBitmap() throws Exception {
            assertNull("no batch may remain resident after a failed load", reader.decodedBatch());
import org.apache.arrow.vector.Float8Vector;
            }
    }
    public void testIntColumnSignExtendsNegatives() throws Exception {
        } else if (vector instanceof TinyIntVector v) {
            for (int i = 0; i < rowCount; i++) {
    private static final String COLUMN = "value";
            try (ArrowExport dataExport = new ArrowExport(array, arrowSchema)) {
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
import org.opensearch.nativebridge.spi.ArrowExport;
            reader.loadBatchContaining(0);
import org.apache.arrow.c.ArrowSchema;
            v.setSafe(index, (int) value);
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        super.setUp();
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
    public void testResidentRowIsServedWithoutMovingTheCursor() throws Exception {
            Data.exportVectorSchemaRoot(allocator, root, null, array, arrowSchema);
                }
            throw new IllegalArgumentException("unsupported integral vector " + vector.getClass().getName());
        globalRuntimePtr = DataFusionRuntimeFixture.createGlobalRuntime(createTempDir("datafusion-spill"));
            writer.initialize("test-index", schemaExport.getSchemaAddress(), ParquetSortConfig.empty(), 0L);
 *
                }
    private BufferAllocator allocator;
        Settings small = Settings.builder()
    // u32 into a non-negative long. If the codec sign-extended it instead (the i32 path), any value
            ArrowArray array = ArrowArray.allocateNew(allocator);
    }
        Path file = createTempDir().resolve("jump.parquet");
            }
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
            }
                DecodedBatch batch = loadRow(reader, row);
    private ArrowExport exportData(Schema schema, int rowCount, int nullEvery) {
                setIntegral(vector, i, values[i]);
            // The native cursor parks at lastRow + 1, so each of these would be a backward seek if
 * with {@link NativeParquetWriter}, then walks it through the FFM zero-copy borrow path
    public void testIndexScopedBatchSizeSettingsAreHonouredPerReader() throws Exception {
                }
            }
    }
/**
 * analytics-backend-datafusion plugin owns, so each test starts a runtime rather than the reader
        }
        Path byteFile = createTempDir().resolve("int8-signed.parquet");
            v.setSafe(index, (int) value);
            FieldVector vector = root.getVector(COLUMN);
 * Tokio runtime manager is a per-JVM singleton whose threads outlive any one test class.
            return new ArrowExport(array, arrowSchema);
            // Sign-extended, so a negative float's long compares below a positive float's long.
import org.opensearch.parquet.bridge.RustBridge;
     * low bits (so callers can express both signed negatives and unsigned values above the signed
    /**
    /**
            ArrowArray array = ArrowArray.allocateNew(allocator);
        Path shortFile = createTempDir().resolve("int16-signed.parquet");
            .put(DatafusionSettings.DOCVALUES_INITIAL_BATCH_SIZE.getKey(), 4)
            v.setSafe(index, (int) value);
        try (ArrowExport schemaExport = exportSchema(schema)) {
    private void writeDoubleColumn(Path file, double[] values) throws Exception {
        NativeParquetWriter writer = new NativeParquetWriter(file.toString());
    // above Integer.MAX_VALUE - here 3000000000 and 4294967295 - would surface as a negative long.
            for (int row = 0; row < values.length; row++) {
            reader.loadBatchContaining(10);
            reader.loadBatchContaining(row);
            assertTrue("negative double must sort below positive", batch.valueAt(0) < batch.valueAt(5));
    public void testUnsignedShortAndByteZeroExtend() throws Exception {
        Path file = createTempDir().resolve("int32-signed.parquet");
                assertEquals(DecodedBatch.KIND_LONG, batch.valueKind());
            List.of(new Field(COLUMN, FieldType.notNullable(new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE)), null))
import org.opensearch.test.OpenSearchTestCase;
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        int rowCount = 500;
                assertEquals("value at row " + row, expected(row), batch.valueAt(row));
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN)) {
        Path file = createTempDir().resolve("doubles.parquet");
                writer.write(dataExport.getArrayAddress(), dataExport.getSchemaAddress());
            ArrowArray array = ArrowArray.allocateNew(allocator);
                assertFalse("window must stay capped at max_batch_size=8 rows", current.contains(row + 8));
            Float4Vector vector = (Float4Vector) root.getVector(COLUMN);
        DataFusionRuntimeFixture.initRuntimeManager(2);
            assertTrue("default initial window (32) must include row 4", batch.contains(4));
        }
    }
public class ParquetColumnReaderTests extends OpenSearchTestCase {
            // because a successful native call frees the buffers the old batch borrowed.
        FieldType fieldType = nullable
        long[] byteValues = { -1L, Byte.MIN_VALUE, -50L, 0L, 42L, Byte.MAX_VALUE };
import org.apache.arrow.vector.UInt1Vector;
    }
     * Writes a single non-nullable integer column of the caller-chosen Arrow width and signedness,
    }
        // Explicitly guard the sign: zero-extension must never produce a negative long.
            // it reached the native side.
        try (ParquetColumnReader reader = ParquetColumnReader.open(file, COLUMN, small)) {
        NativeParquetWriter writer = new NativeParquetWriter(file.toString());
        int rowCount = 500;
package org.opensearch.be.datafusion.docvalues.bridge;
    private static void setIntegral(FieldVector vector, int index, long value) {
    // Zero-extension coverage for KIND_USHORT and KIND_UBYTE: an unsigned 16- or 8-bit column must
    }
                vector.setSafe(i, values[i]);
