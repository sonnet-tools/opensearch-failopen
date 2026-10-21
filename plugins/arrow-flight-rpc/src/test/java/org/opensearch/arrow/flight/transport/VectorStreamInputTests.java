        VectorSchemaRoot shared = newNativeArrowRoot();
    // ArrowBatchResponse integration — verifies NativeArrow satisfies ArrowStreamInput.
            byte[] out = new byte[5];
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
        TestResponse response = new TestResponse(in);
        srcVec.setValueCount(1);
            byte[] out = new byte[4];
        vec.allocateNew();
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        shared.close();
        shared.setRowCount(1);
        VectorStreamInput.NativeArrow in = (VectorStreamInput.NativeArrow) VectorStreamInput.forNativeArrow(shared, registry);
        srcVec.setSafe(0, 42);
        VectorSchemaRoot shared = newByteSerializedRoot();
        srcVec.setValueCount(1);
            assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, out);
            // Close the stream root immediately — consumer root must survive.
            // consumer root (transferred==false).
import java.util.List;
            byte[] out = new byte[2];
            assertEquals((byte) 30, input.readByte());
        assertEquals(3, ((VarBinaryVector) shared.getVector("0")).get(0).length);
        long beforeClose;
        shared.close();
        );
    }
        shared.close();
    public void testNativeArrowRejectsByteReads() throws IOException {
        vec.allocateNew();
import org.opensearch.core.common.io.stream.StreamInput;
        // buffer (1 byte left) before pulling row 1.
            expectThrows(IOException.class, () -> input.readBytes(out, 0, 2));
    private VectorSchemaRoot newByteSerializedRoot() {
        vec.setValueCount(2);
            input.getRoot().close();
        VectorSchemaRoot shared = newNativeArrowRoot();
import org.apache.arrow.vector.VarBinaryVector;
        VectorSchemaRoot consumerRoot = input.getRoot();
            assertEquals(42, dstVec.get(0));
        vec.setValueCount(1);
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
    public void testReadBytesEofWhenRowsExhausted() throws IOException {
    private BufferAllocator allocator;
        shared.close();
        in.close();
            assertEquals(1, input.getRoot().getRowCount());
        shared.setRowCount(1);
            IllegalStateException e = expectThrows(IllegalStateException.class, () -> VectorStreamInput.forNativeArrow(shared, registry));
    public void testReadBytesSpansMultipleRowsWithLeftover() throws IOException {
    public void tearDown() throws Exception {
            assertNotSame("NativeArrow transfers into a fresh consumer root", shared, input.getRoot());
 * The OpenSearch Contributors require contributions made to
        VectorSchemaRoot shared = newByteSerializedRoot();
            expectThrows(IllegalArgumentException.class, () -> input.readBytes(target, 0, -1));
            input.readBytes(out, 0, 5);
        } finally {
    public void testForNativeArrowRejectsEmptySchema() {
            assertTrue("message should point at skipsDeserialization()", e.getMessage().contains("skipsDeserialization"));
        vec.setSafe(0, new byte[] { 1, 2, 3 });
import org.apache.arrow.vector.types.pojo.ArrowType;
import org.apache.arrow.vector.VectorSchemaRoot;
        input.close();
    }
        } finally {
        }
        shared.close();
        vec.setValueCount(1);
import org.apache.arrow.memory.RootAllocator;
        VectorSchemaRoot shared = newNativeArrowRoot();
        Schema schema = new Schema(List.of(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null)));
        }
            input.readBytes(out, 0, 3);
        shared.close();
import org.apache.arrow.vector.types.pojo.FieldType;
        }
        shared.setRowCount(1);
    @Before
            expectThrows(IllegalArgumentException.class, () -> input.readBytes(target, 3, 5));
    }
            assertEquals("source must be drained", 0, shared.getRowCount());
import org.apache.arrow.vector.IntVector;
import org.junit.Before;
    }
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        vec.setSafe(0, new byte[] { 1, 2, 3 });
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        }
            assertEquals("consumer root survives stream root close", 42, dstVec.get(0));
        try {
        // readByte advances row 0 into the internal buffer; readBytes must then drain the
        VectorSchemaRoot shared = VectorSchemaRoot.create(emptySchema, allocator);
        // Shared root must remain fully usable — the transport owns its lifecycle.
        try (VectorStreamInput.NativeArrow input = (VectorStreamInput.NativeArrow) VectorStreamInput.forNativeArrow(shared, registry)) {
        VectorSchemaRoot shared = newByteSerializedRoot();
    public void testByteSerializedReadsBytesFromSharedVector() throws IOException {
            allocator.getAllocatedMemory() < beforeClose
            "consumer root must be released when not transferred (was " + beforeClose + ", now " + allocator.getAllocatedMemory() + ")",
    public void testReadByteEofWhenRowsExhausted() throws IOException {
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
 * this file be licensed under the Apache-2.0 license or a
    }
        shared.close();
            assertEquals((byte) 10, input.readByte());
        vec.allocateNew();
 * SPDX-License-Identifier: Apache-2.0
            expectThrows(java.io.EOFException.class, input::readByte);
    public void testByteSerializedReadsFromSharedRoot() throws IOException {
            shared.close();
        shared.setRowCount(0);
    }
import java.io.IOException;
        }
        VectorSchemaRoot shared = newByteSerializedRoot();
        VectorSchemaRoot shared = newByteSerializedRoot();
        allocator = new RootAllocator();
        vec.allocateNew();
        vec.allocateNew();
            expectThrows(UnsupportedOperationException.class, input::readByte);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        super.tearDown();
        vec.setSafe(0, new byte[0]);
    public void setUp() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
        shared.setRowCount(1);
        srcVec.allocateNew();
        try {
        }
        IntVector vec = (IntVector) shared.getVector("val");
            assertEquals((byte) 7, input.readByte());
        }
        vec.setSafe(0, 42);
        vec.setSafe(1, new byte[] { 30, 40 });
        try (VectorStreamInput in = VectorStreamInput.forByteSerialized(shared, registry)) {
import org.opensearch.arrow.transport.ArrowBatchResponse;
    }
        assertSame(consumerRoot, response.getRoot());
    }
import org.apache.arrow.vector.types.pojo.Schema;
        }
        }
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        VectorSchemaRoot shared = newNativeArrowRoot();
            assertTrue("consumer root should hold memory before close", beforeClose > 0);
        }
        ((VarBinaryVector) shared.getVector("0")).allocateNew();
        IntVector srcVec = (IntVector) shared.getVector("val");
        vec.setValueCount(2);
            shared.close();
        srcVec.setSafe(0, 7);
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
        srcVec.allocateNew();
        input.claimOwnership();
        // read() throws or never runs: the consumer root must be released by close(), not leaked.
    @Override
    }
        VectorSchemaRoot shared = newByteSerializedRoot();
    }
            byte[] out = new byte[3];
    public void testNativeArrowCloseReleasesRootIfNotTransferred() throws IOException {
    public void testReadBytesZeroLengthIsNoOp() throws IOException {
    }
        vec.allocateNew();
 * compatible open source license.
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
        }
            assertTrue(input instanceof VectorStreamInput.ByteSerialized);
    }
    public void testByteSerializedCloseIsNoOpOnSharedRoot() throws IOException {
        shared.close();
        shared.close();
            assertEquals((byte) 20, input.readByte());
        shared.close();
    }
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
    public void testReadByteRejectsEmptyRow() throws IOException {
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
        assertEquals(1, consumerRoot.getRowCount());
        }
        allocator.close();
package org.opensearch.arrow.flight.transport;
        srcVec.setSafe(0, 7);
    public void testReadBytesRejectsEmptyRow() throws IOException {
            expectThrows(java.io.EOFException.class, () -> input.readBytes(out, 0, 4));
    public void testArrowBatchResponseRejectsByteSerializedInput() throws IOException {
        TestResponse(VectorSchemaRoot root) {
        super.setUp();
    public void testArrowBatchResponseClaimsNativeArrowInput() throws IOException {
        }
            expectThrows(IllegalArgumentException.class, () -> input.readBytes(target, -1, 2));
        VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry);
        shared.close();
        srcVec.allocateNew();
        vec.setSafe(0, new byte[] { 10, 20, 30 });
            super(root);
            // Remaining buffered bytes from row 1 feed readByte.
        vec.setSafe(0, new byte[0]);
        shared.close();
    public void testReadBytesInvalidOffsetThrows() throws IOException {
    }
 *
    }
        VectorSchemaRoot consumerRoot = in.getRoot();
    }
            input.claimOwnership();
    }
        return VectorSchemaRoot.create(schema, allocator);
        // After try-with-resources: close() ran, transferred==false, root should be released.
        assertEquals(42, ((IntVector) response.getRoot().getVector("val")).get(0));
        IntVector srcVec = (IntVector) shared.getVector("val");
        }
        try (VectorStreamInput input = VectorStreamInput.forNativeArrow(shared, registry)) {
import org.junit.After;
            assertTrue(e.getMessage().contains("no field vectors"));
        TestResponse(StreamInput in) throws IOException {
        shared.setRowCount(1);
/*
        srcVec.setValueCount(1);
public class VectorStreamInputTests extends OpenSearchTestCase {
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
        VectorStreamInput.NativeArrow input = (VectorStreamInput.NativeArrow) VectorStreamInput.forNativeArrow(shared, registry);
        VectorSchemaRoot shared = newByteSerializedRoot();
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        } finally {
            assertSame("ByteSerialized holds the stream root — no transfer", shared, input.getRoot());
            assertEquals((byte) 10, input.readByte());
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        IntVector srcVec = (IntVector) shared.getVector("val");
            shared.close();
            // Simulate ArrowBatchResponse taking ownership, then close the consumer root on the response side.
            IllegalStateException e = expectThrows(IllegalStateException.class, () -> new TestResponse(in));
        VectorStreamInput.NativeArrow input = (VectorStreamInput.NativeArrow) VectorStreamInput.forNativeArrow(shared, registry);
            input.close(); // no-op after claimOwnership
        vec.setSafe(1, new byte[] { 4, 5, 6, 7 });
        // claimOwnership must have fired — close() is a no-op, consumer root survives.
        vec.setValueCount(1);
        // Consumer root must remain usable — ArrowBatchResponse owns it after handoff.
        VectorSchemaRoot shared = newByteSerializedRoot();
    }
    }
        assertEquals(1, shared.getRowCount());
            expectThrows(IOException.class, input::readByte);
    }
    public void testReadBytesDrainsBufferThenAdvancesRow() throws IOException {
        shared.close();
            expectThrows(UnsupportedOperationException.class, () -> input.readBytes(new byte[1], 0, 1));
        // After that, close() must leave the root alone so the response can use it.
        vec.setValueCount(1);
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
    static class TestResponse extends ArrowBatchResponse {
            super(in);
        VectorSchemaRoot shared = newByteSerializedRoot();
        VectorSchemaRoot shared = newByteSerializedRoot();
        assertTrue(
    }
    private VectorSchemaRoot newNativeArrowRoot() {
 */
        vec.setSafe(0, new byte[] { 1, 2 });
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
        }
        consumerRoot.close();
    public void testNativeArrowCloseIsNoOpAfterMarkTransferred() throws IOException {
        response.getRoot().close();
        return VectorSchemaRoot.create(schema, allocator);
            assertEquals((byte) 6, input.readByte());
        vec.setValueCount(1);
    @Override
            assertArrayEquals(new byte[] { 20, 30, 40 }, out);
    }
import org.apache.arrow.vector.types.pojo.Field;
        shared.setRowCount(1);
        // Row 0: 3 bytes, row 1: 4 bytes. Read 5 bytes — spans both rows, leaves 2 in buffer
            byte[] target = new byte[4];
        // ArrowBatchResponse(StreamInput) calls claimOwnership to take ownership.
        }
        VectorSchemaRoot shared = newNativeArrowRoot();
import java.util.Collections;
        Schema emptySchema = new Schema(List.<Field>of());
    private NamedWriteableRegistry registry;
        VectorSchemaRoot shared = newByteSerializedRoot();
            input.readBytes(new byte[4], 0, 0); // must not throw, must not advance
        shared.setRowCount(1);
        shared.setRowCount(2);
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        input.close();
            // Do not call input.getRoot().close() — the try-with-resources close() releases the
        // for a follow-up readByte.
        VectorSchemaRoot shared = newByteSerializedRoot();
        shared.setRowCount(1);
        vec.setValueCount(1);
    public void testNativeArrowTransfersIntoOwnedRoot() throws IOException {
        shared.setRowCount(2);
    @After
            IntVector dstVec = (IntVector) input.getRoot().getVector("val");
        shared.close();
        registry = new NamedWriteableRegistry(Collections.emptyList());
        Schema schema = new Schema(List.of(new Field("0", FieldType.nullable(new ArrowType.Binary()), null)));
}
        assertEquals(7, ((IntVector) consumerRoot.getVector("val")).get(0));
        shared.close();
            beforeClose = allocator.getAllocatedMemory();
        vec.setSafe(0, new byte[] { 10, 20 });
        vec.allocateNew();
        }
import org.apache.arrow.memory.BufferAllocator;
    }
        shared.setRowCount(1);
        vec.allocateNew();
