 * compatible open source license.
            VarBinaryVector vector = (VarBinaryVector) root.getVector(0);
    }
        super.tearDown();
    }
            output.writeByte((byte) 99);
            VarBinaryVector vector = (VarBinaryVector) root.getVector(0);
        assertEquals(0, allocator.getAllocatedMemory());  
            assertEquals(1, root.getRowCount());  
    }
    }
            }
    public void setUp() throws Exception {
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
        try (VectorStreamOutput output = VectorStreamOutput.forNativeArrow(root)) {
import org.apache.arrow.vector.types.pojo.Field;
        }
        vector.allocateNew();
    public void testNativeArrowCloseDoesNotCloseRoot() throws IOException {
            assertEquals(1, root.getFieldVectors().size());  
    // ── ByteSerialized tests ──  
    public void testNativeArrowFlushAndResetAreNoOps() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        allocator = new RootAllocator(Long.MAX_VALUE);  
 */  
    }
            byte[] data = new byte[5];  
        }
            assertEquals(2, root.getRowCount());  
import org.apache.arrow.vector.VarBinaryVector;
            VectorStreamOutput output = VectorStreamOutput.forNativeArrow(root);
            assertSame(root, output.getRoot());  
            assertEquals((byte) 99, value[0]);  
    }  
        } finally {
        }
            root.close();
        VectorSchemaRoot root = new VectorSchemaRoot(List.of(vector));  
        }  
        vector.setInitialCapacity(16);
    }  
            output.writeByte((byte) 7);
    @Override  
package org.opensearch.arrow.flight.transport;
            assertSame(root, output.getRoot());
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {  
            assertSame(root, output.getRoot());
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> output.writeBytes(data, 3, 5));
        try (VectorStreamOutput output = VectorStreamOutput.forNativeArrow(root)) {  
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);  
    public void testResetClearsState() throws IOException {
import java.io.IOException;  
import org.apache.arrow.vector.types.pojo.ArrowType;
    public void testWriteBytesFlushesPendingTempBuffer() throws IOException {
    public void testWriteBytesWithInvalidOffsetThrows() throws IOException {
            output.writeByte((byte) 42);
            output.writeBytes(new byte[5], 0, 0);
/*  
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
            // Root should still be the same and accessible  
            root.close();  
        output.close();
        VectorSchemaRoot existingRoot = new VectorSchemaRoot(List.of(vector));
        allocator.close();  
    }
    }
            assertTrue(e.getMessage().contains("Illegal offset"));
        }
    public void testWriteByteTriggersFlushTempBuffer() throws IOException {
            output.writeByte((byte) 1);
            assertEquals(1, root.getRowCount());
            output.writeByte((byte) 42);
            byte[] data = new byte[5];
        } finally {
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {  
            assertEquals((byte) 1, row0[0]);
            assertEquals(1, vector.get(1).length);
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> output.writeBytes(data, 0, 10));
        }
    @Override  
    }
        }
import org.opensearch.test.OpenSearchTestCase;
            assertEquals(3, row1.length);  
        }  
                output.writeByte((byte) (i & 0xFF));  
    }  
        } finally {
            output.reset();
        VectorSchemaRoot root = new VectorSchemaRoot(List.of(vector));
}
        }
    }
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
            assertEquals(0, root.getRowCount());
            // Root should still be usable after NativeArrow.close()
            assertTrue(e.getMessage().contains("Illegal offset"));  
            assertNotNull(root.getSchema());
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
        vector.allocateNew();  
            assertEquals(8192, vector.get(0).length);  
            // Write some bytes via writeByte to fill tempBuffer partially
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {
            assertEquals(1, root.getRowCount());
        vector.allocateNew();  
    public void testNativeArrowWriteByteIsNoOp() throws IOException {
            assertEquals((byte) 2, row0[1]);  
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);  
    }  
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);  
            for (int i = 0; i < 8193; i++) {
import java.util.List;
import org.apache.arrow.vector.types.pojo.FieldType;  
        }
            root.close();  
        }
 *
            output.close();  
            // Row 1: direct writeBytes data
            VectorSchemaRoot root = output.getRoot();
            // Now writeBytes should flush the pending temp buffer first
            byte[] data = new byte[] { 3, 4, 5 };
        } finally {
            output.writeByte((byte) 1);  
            VectorSchemaRoot root1 = output.getRoot();
            root.close();
    }
    public void testWriteBytesWithInvalidLengthThrows() throws IOException {
        }
            VectorSchemaRoot root = output.getRoot();
            output.writeBytes(data, 0, 3);  
            assertNotNull(root);  
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);
        VectorSchemaRoot root = new VectorSchemaRoot(List.of(vector));
 * this file be licensed under the Apache-2.0 license or a
        }
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
            assertEquals((byte) 7, value[0]);
        try {
        try (VectorStreamOutput output = VectorStreamOutput.forNativeArrow(root)) {
            output.flush();
        vector.allocateNew();
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {  
    public void testByteSerializedConstructorWithExistingRoot() throws IOException {
        }  
            // Write exactly 8192 bytes to fill the temp buffer, then one more to trigger flush
            // Vector should remain unchanged  
            byte[] row1 = vector.get(1);
            byte[] value = ((VarBinaryVector) root.getVector(0)).get(0);
            assertEquals(0, vector.getValueCount());
            assertEquals(2, root.getRowCount());
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);  
            // After reset, writing and getting root should start fresh  
        output.writeByte((byte) 1);  
        vector.allocateNew();
import org.apache.arrow.vector.VectorSchemaRoot;  
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {  
        Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
            output.writeByte((byte) 2);
        VectorStreamOutput output = VectorStreamOutput.create(allocator, null);
        VectorSchemaRoot root = new VectorSchemaRoot(List.of(vector));
            byte[] value = ((VarBinaryVector) root.getVector(0)).get(0);
            assertSame(root1, root2);  
        } finally {
            byte[] row0 = vector.get(0);  
            output.reset();
            // First 8192 bytes flushed as one row, remaining 1 byte flushed as second row  
            assertEquals(0, vector.getValueCount());  
            VectorSchemaRoot root = output.getRoot();  
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, existingRoot)) {  
        try (VectorStreamOutput output = VectorStreamOutput.forNativeArrow(root)) {
    public void testNativeArrowGetRootReturnsSameRoot() throws IOException {
        super.setUp();
            output.writeByte((byte) 1);
 * The OpenSearch Contributors require contributions made to  
    }
    public void testCloseReleasesVector() throws IOException {
            VectorSchemaRoot root2 = output.getRoot();
            VectorSchemaRoot root = output.getRoot();
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);
import org.apache.arrow.memory.RootAllocator;
            assertEquals(2, row0.length);
        try (VectorStreamOutput output = VectorStreamOutput.create(allocator, null)) {  
    public void testByteSerializedConstructorWithoutExistingRoot() throws IOException {
            assertEquals(1, value.length);
        VectorSchemaRoot root = new VectorSchemaRoot(List.of(vector));
    private RootAllocator allocator;
    public void tearDown() throws Exception {
            output.writeBytes(new byte[] { 1, 2, 3 }, 0, 3);
    public void testWriteBytesWithZeroLengthIsNoOp() throws IOException {  
    }
        // After close, allocator should have no outstanding allocations
            output.writeBytes(new byte[] { 2, 3 }, 0, 2);
            // Row 0: flushed temp buffer (2 bytes from writeByte)
            assertEquals((byte) 3, row1[0]);
            assertSame(existingRoot, root);  
            assertEquals(1, value.length);  
    }  
        vector.allocateNew();
    public void testNativeArrowWriteBytesIsNoOp() throws IOException {
            VectorSchemaRoot root = output.getRoot();
    public void testGetRootCreatesRootOnFirstCallReusesOnSecond() throws IOException {
    // ── NativeArrow tests ──  
        VarBinaryVector vector = (VarBinaryVector) field.createVector(allocator);  
            assertNotNull(root1);
public class VectorStreamOutputTests extends OpenSearchTestCase {  
            root.close();  
            output.writeByte((byte) 2);  
            VectorSchemaRoot root = output.getRoot();
