        // After close, allocator should have no outstanding allocations
    }
            assertSame(root1, root2);
        assertEquals(0, allocator.getAllocatedMemory());
            output.reset();
    }
        }
            assertEquals(2, root.getRowCount());
        }
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
            assertSame(root, output.getRoot());
    }
            // Row 0: flushed temp buffer (2 bytes from writeByte)
            for (int i = 0; i < 8193; i++) {
            output.writeByte((byte) 2);
        }
            output.writeByte((byte) 42);
            output.writeBytes(new byte[] { 2, 3 }, 0, 2);
        try (VectorStreamOutput output = VectorStreamOutput.forNativeArrow(root)) {
        try (VectorStreamOutput output = VectorStreamOutput.forNativeArrow(root)) {
import org.apache.arrow.vector.VarBinaryVector;
        output.close();
            assertEquals(2, root.getRowCount());
        } finally {
    public void testNativeArrowGetRootReturnsSameRoot() throws IOException {
            VectorSchemaRoot root = output.getRoot();
import org.apache.arrow.vector.types.pojo.Field;
    public void testGetRootCreatesRootOnFirstCallReusesOnSecond() throws IOException {
    public void setUp() throws Exception {
        output.writeByte((byte) 1);
            byte[] data = new byte[] { 3, 4, 5 };
    // ── NativeArrow tests ──
            byte[] data = new byte[5];
    }
            VectorSchemaRoot root = output.getRoot();
            assertEquals((byte) 1, row0[0]);
        allocator = new RootAllocator(Long.MAX_VALUE);
        VectorSchemaRoot root = new VectorSchemaRoot(List.of(vector));
 * this file be licensed under the Apache-2.0 license or a
            VectorSchemaRoot root = output.getRoot();
public class VectorStreamOutputTests extends OpenSearchTestCase {
        }
/*
            root.close();
            output.flush();
            VectorSchemaRoot root1 = output.getRoot();
            assertEquals((byte) 7, value[0]);
        vector.allocateNew();
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);
        vector.allocateNew();
    public void testWriteBytesWithInvalidLengthThrows() throws IOException {
            output.writeByte((byte) 1);
    // ── ByteSerialized tests ──
 * SPDX-License-Identifier: Apache-2.0
            VectorSchemaRoot root = output.getRoot();
            // Write exactly 8192 bytes to fill the temp buffer, then one more to trigger flush
            root.close();
            // Write some bytes via writeByte to fill tempBuffer partially
            assertEquals(1, vector.get(1).length);
            output.writeByte((byte) 2);
            // Vector should remain unchanged
            assertSame(existingRoot, root);
            // Root should still be usable after NativeArrow.close()
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, existingRoot)) {
            byte[] row1 = vector.get(1);
    public void testByteSerializedConstructorWithoutExistingRoot() throws IOException {
            output.writeBytes(new byte[] { 1, 2, 3 }, 0, 3);
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
            byte[] value = ((VarBinaryVector) root.getVector(0)).get(0);
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
    public void testResetClearsState() throws IOException {
import org.apache.arrow.vector.types.pojo.FieldType;
import java.io.IOException;
    public void tearDown() throws Exception {
    }
            output.writeByte((byte) 1);
            // First 8192 bytes flushed as one row, remaining 1 byte flushed as second row
            assertNotNull(root);
    }
    }
            assertEquals(0, vector.getValueCount());
            byte[] data = new byte[5];
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
            assertTrue(e.getMessage().contains("Illegal offset"));
        super.tearDown();
            output.reset();
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
        } finally {
            assertSame(root, output.getRoot());
    public void testWriteBytesWithInvalidOffsetThrows() throws IOException {
    }
 */
            assertNotNull(root.getSchema());
            assertEquals((byte) 99, value[0]);
    private RootAllocator allocator;
            VectorSchemaRoot root = output.getRoot();
            VectorStreamOutput output = VectorStreamOutput.forNativeArrow(root);
            root.close();
    }
        } finally {
        vector.setInitialCapacity(16);
        } finally {
        try (VectorStreamOutput output = VectorStreamOutput.forNativeArrow(root)) {
package org.opensearch.arrow.flight.transport;
    }
        }
            assertEquals((byte) 2, row0[1]);
            }
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
        vector.allocateNew();
 * compatible open source license.
            assertEquals(1, root.getFieldVectors().size());
        vector.allocateNew();
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> output.writeBytes(data, 3, 5));
        VectorSchemaRoot root = new VectorSchemaRoot(List.of(vector));
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);
            assertTrue(e.getMessage().contains("Illegal offset"));
            root.close();
import org.opensearch.test.OpenSearchTestCase;
            byte[] value = ((VarBinaryVector) root.getVector(0)).get(0);
        }
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
        try {
        VectorSchemaRoot root = new VectorSchemaRoot(List.of(vector));
        }
            assertEquals(1, root.getRowCount());
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);
            assertEquals(1, root.getRowCount());
    }
            assertEquals(2, row0.length);
    }
            output.writeByte((byte) 42);
        }
            assertEquals(3, row1.length);
        }
        }
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
        } finally {
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
            assertNotNull(root1);
        }
        }
        super.setUp();
            // Row 1: direct writeBytes data
import org.apache.arrow.memory.RootAllocator;
        VectorSchemaRoot root = new VectorSchemaRoot(List.of(vector));
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
            output.writeBytes(new byte[5], 0, 0);
            // Root should still be the same and accessible
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> output.writeBytes(data, 0, 10));
            output.writeByte((byte) 7);
            VectorSchemaRoot root = output.getRoot();
    }
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
 * The OpenSearch Contributors require contributions made to
import org.apache.arrow.vector.types.pojo.ArrowType;
 *
            assertEquals(0, vector.getValueCount());
    public void testWriteByteTriggersFlushTempBuffer() throws IOException {
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);
    public void testByteSerializedConstructorWithExistingRoot() throws IOException {
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);
        vector.allocateNew();
            VarBinaryVector vector = (VarBinaryVector) root.getVector(0);
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);
    @Override
        }
            output.writeByte((byte) 99);
    }
        allocator.close();
        VectorStreamOutput output = VectorStreamOutput.create(allocator, null);
import java.util.List;
                output.writeByte((byte) (i & 0xFF));
import org.apache.arrow.vector.VectorSchemaRoot;
            output.writeBytes(data, 0, 3);
            assertEquals(8192, vector.get(0).length);
            output.writeByte((byte) 1);
            VarBinaryVector vector = (VarBinaryVector) root.getVector(0);
    public void testWriteBytesFlushesPendingTempBuffer() throws IOException {
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
            assertEquals(1, root.getRowCount());
            // After reset, writing and getting root should start fresh
    @Override
        VectorSchemaRoot root = new VectorSchemaRoot(List.of(vector));
            root.close();
            assertEquals(0, root.getRowCount());
    public void testNativeArrowWriteBytesIsNoOp() throws IOException {
        VectorSchemaRoot existingRoot = new VectorSchemaRoot(List.of(vector));
            // Now writeBytes should flush the pending temp buffer first
            assertEquals(1, value.length);
    }
            output.close();
            byte[] row0 = vector.get(0);
        try (VectorStreamOutput output = VectorStreamOutput.forNativeArrow(root)) {
    public void testNativeArrowWriteByteIsNoOp() throws IOException {
        }
            VectorSchemaRoot root2 = output.getRoot();
            assertSame(root, output.getRoot());
    }
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
            assertEquals(1, value.length);
    public void testNativeArrowFlushAndResetAreNoOps() throws IOException {
    }
}
        vector.allocateNew();
    public void testNativeArrowCloseDoesNotCloseRoot() throws IOException {
    public void testCloseReleasesVector() throws IOException {
            assertEquals((byte) 3, row1[0]);
    public void testWriteBytesWithZeroLengthIsNoOp() throws IOException {
