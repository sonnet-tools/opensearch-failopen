        VectorSchemaRoot consumerRoot = input.getRoot();
            assertEquals("consumer root survives stream root close", 42, dstVec.get(0));
            byte[] out = new byte[2];
    }  
            assertEquals((byte) 6, input.readByte());
 * The OpenSearch Contributors require contributions made to  
    public void testByteSerializedCloseIsNoOpOnSharedRoot() throws IOException {  
        registry = new NamedWriteableRegistry(Collections.emptyList());
        vec.setValueCount(1);
        VectorSchemaRoot shared = newNativeArrowRoot();  
            assertEquals((byte) 20, input.readByte());
        try (VectorStreamInput.NativeArrow input = (VectorStreamInput.NativeArrow) VectorStreamInput.forNativeArrow(shared, registry)) {  
    public void testNativeArrowRejectsByteReads() throws IOException {
            assertEquals((byte) 10, input.readByte());
        IntVector srcVec = (IntVector) shared.getVector("val");
        // Row 0: 3 bytes, row 1: 4 bytes. Read 5 bytes — spans both rows, leaves 2 in buffer
        }
    public void testReadBytesRejectsEmptyRow() throws IOException {
    }
        Schema schema = new Schema(List.of(new Field("0", FieldType.nullable(new ArrowType.Binary()), null)));  
    }
        shared.setRowCount(1);
        vec.setValueCount(1);
import org.apache.arrow.vector.VectorSchemaRoot;
        srcVec.setSafe(0, 7);  
 * compatible open source license.
        }
        shared.setRowCount(2);
    private VectorSchemaRoot newNativeArrowRoot() {
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
/*  
        VectorSchemaRoot consumerRoot = in.getRoot();  
        VectorStreamInput.NativeArrow in = (VectorStreamInput.NativeArrow) VectorStreamInput.forNativeArrow(shared, registry);
    public void testArrowBatchResponseRejectsByteSerializedInput() throws IOException {
    public void testReadBytesZeroLengthIsNoOp() throws IOException {
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        // After that, close() must leave the root alone so the response can use it.
            // Do not call input.getRoot().close() — the try-with-resources close() releases the  
        shared.close();
}
    public void testArrowBatchResponseClaimsNativeArrowInput() throws IOException {  
    }
            assertEquals((byte) 10, input.readByte());  
import org.junit.Before;  
        try (VectorStreamInput in = VectorStreamInput.forByteSerialized(shared, registry)) {  
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        // buffer (1 byte left) before pulling row 1.  
            byte[] out = new byte[4];
    public void testForNativeArrowRejectsEmptySchema() {
import org.apache.arrow.vector.types.pojo.Field;
        VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry);
        vec.setValueCount(2);  
        VectorSchemaRoot shared = newByteSerializedRoot();
        vec.allocateNew();  
        shared.close();  
        vec.setValueCount(1);
        }
        shared.close();  
        shared.close();
        shared.setRowCount(1);
        srcVec.setValueCount(1);
        response.getRoot().close();  
            IntVector dstVec = (IntVector) input.getRoot().getVector("val");
        TestResponse(StreamInput in) throws IOException {
        vec.allocateNew();
import org.apache.arrow.memory.RootAllocator;
        VectorSchemaRoot shared = newByteSerializedRoot();
        allocator = new RootAllocator();  
        shared.setRowCount(0);  
        vec.setSafe(0, new byte[] { 1, 2, 3 });
    }
            input.readBytes(new byte[4], 0, 0); // must not throw, must not advance
        vec.setSafe(0, new byte[0]);
            allocator.getAllocatedMemory() < beforeClose
            shared.close();
import org.apache.arrow.vector.types.pojo.ArrowType;  
        srcVec.allocateNew();
import java.util.List;
            assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, out);  
    public void testReadBytesEofWhenRowsExhausted() throws IOException {
            // Close the stream root immediately — consumer root must survive.  
            assertEquals(1, input.getRoot().getRowCount());
            super(root);
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
    public void testReadBytesSpansMultipleRowsWithLeftover() throws IOException {
        vec.allocateNew();
        vec.allocateNew();  
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
        vec.allocateNew();
        vec.setSafe(0, new byte[] { 1, 2 });  
        shared.close();
            "consumer root must be released when not transferred (was " + beforeClose + ", now " + allocator.getAllocatedMemory() + ")",  
        super.setUp();
        consumerRoot.close();  
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {  
import org.apache.arrow.memory.BufferAllocator;
            expectThrows(IllegalArgumentException.class, () -> input.readBytes(target, 0, -1));
        vec.setSafe(0, new byte[] { 1, 2, 3 });
 * SPDX-License-Identifier: Apache-2.0
        }  
import org.opensearch.core.common.io.stream.StreamInput;  
        }
        srcVec.setSafe(0, 42);  
    public void testByteSerializedReadsFromSharedRoot() throws IOException {
            assertSame("ByteSerialized holds the stream root — no transfer", shared, input.getRoot());  
        vec.allocateNew();  
    }
            IllegalStateException e = expectThrows(IllegalStateException.class, () -> new TestResponse(in));
        super.tearDown();
        srcVec.allocateNew();  
    @Override  
        assertTrue(
        }
            assertArrayEquals(new byte[] { 20, 30, 40 }, out);
    @Before
        shared.setRowCount(1);
        srcVec.setSafe(0, 7);
        }  
    }
 * this file be licensed under the Apache-2.0 license or a
        VectorSchemaRoot shared = newByteSerializedRoot();  
        shared.setRowCount(2);
    }
package org.opensearch.arrow.flight.transport;
import java.io.IOException;
    }
        }
    }
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        VectorSchemaRoot shared = newByteSerializedRoot();
        VectorSchemaRoot shared = newByteSerializedRoot();
            byte[] target = new byte[4];
    // ArrowBatchResponse integration — verifies NativeArrow satisfies ArrowStreamInput.  
        try (VectorStreamInput input = VectorStreamInput.forNativeArrow(shared, registry)) {  
            IllegalStateException e = expectThrows(IllegalStateException.class, () -> VectorStreamInput.forNativeArrow(shared, registry));
        TestResponse(VectorSchemaRoot root) {  
    private NamedWriteableRegistry registry;  
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
            assertTrue(input instanceof VectorStreamInput.ByteSerialized);
            input.claimOwnership();
        }  
    public void tearDown() throws Exception {  
    public void testReadBytesDrainsBufferThenAdvancesRow() throws IOException {
        // Shared root must remain fully usable — the transport owns its lifecycle.
import org.apache.arrow.vector.types.pojo.FieldType;
        shared.close();
        shared.close();
        }  
    }  
        vec.allocateNew();  
            // consumer root (transferred==false).
        }  
        assertEquals(3, ((VarBinaryVector) shared.getVector("0")).get(0).length);
        VectorSchemaRoot shared = newByteSerializedRoot();
import org.apache.arrow.vector.IntVector;  
            input.close(); // no-op after claimOwnership
    }
        // read() throws or never runs: the consumer root must be released by close(), not leaked.  
            shared.close();
    }
            assertTrue("consumer root should hold memory before close", beforeClose > 0);
        assertEquals(42, ((IntVector) response.getRoot().getVector("val")).get(0));
        } finally {  
            assertEquals(42, dstVec.get(0));  
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
 */  
    static class TestResponse extends ArrowBatchResponse {
        }  
        // claimOwnership must have fired — close() is a no-op, consumer root survives.
        allocator.close();
import org.opensearch.arrow.transport.ArrowBatchResponse;
        shared.setRowCount(1);  
            expectThrows(java.io.EOFException.class, input::readByte);
        shared.close();
        shared.close();
        VectorSchemaRoot shared = newByteSerializedRoot();
        assertEquals(1, consumerRoot.getRowCount());
    }  
        shared.close();
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        shared.setRowCount(1);  
    public void setUp() throws Exception {
    }
            expectThrows(java.io.EOFException.class, () -> input.readBytes(out, 0, 4));  
        vec.setSafe(0, new byte[0]);  
        input.close();
        }
import org.apache.arrow.vector.VarBinaryVector;
        VectorSchemaRoot shared = newByteSerializedRoot();  
            input.readBytes(out, 0, 3);  
        } finally {
import org.apache.arrow.vector.types.pojo.Schema;  
        vec.setSafe(1, new byte[] { 4, 5, 6, 7 });
        vec.setValueCount(2);  
        VectorSchemaRoot shared = newByteSerializedRoot();  
        shared.setRowCount(1);  
        VectorStreamInput.NativeArrow input = (VectorStreamInput.NativeArrow) VectorStreamInput.forNativeArrow(shared, registry);
    public void testNativeArrowCloseIsNoOpAfterMarkTransferred() throws IOException {  
        vec.setSafe(0, 42);
            expectThrows(IllegalArgumentException.class, () -> input.readBytes(target, 3, 5));
        VectorSchemaRoot shared = newByteSerializedRoot();
import java.util.Collections;  
        vec.setValueCount(1);  
    @After
        input.close();  
        shared.setRowCount(1);  
    public void testNativeArrowCloseReleasesRootIfNotTransferred() throws IOException {
            assertTrue(e.getMessage().contains("no field vectors"));  
            assertTrue("message should point at skipsDeserialization()", e.getMessage().contains("skipsDeserialization"));
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {  
        }
        Schema emptySchema = new Schema(List.<Field>of());
public class VectorStreamInputTests extends OpenSearchTestCase {  
    public void testReadByteRejectsEmptyRow() throws IOException {
            expectThrows(IllegalArgumentException.class, () -> input.readBytes(target, -1, 2));  
        assertEquals(7, ((IntVector) consumerRoot.getVector("val")).get(0));
        }  
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
        vec.setSafe(1, new byte[] { 30, 40 });
        vec.setSafe(0, new byte[] { 10, 20, 30 });
        vec.setSafe(0, new byte[] { 10, 20 });
    public void testReadByteEofWhenRowsExhausted() throws IOException {  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        input.claimOwnership();  
            input.readBytes(out, 0, 5);
            expectThrows(UnsupportedOperationException.class, input::readByte);
        shared.close();
        try {
        VectorSchemaRoot shared = newByteSerializedRoot();  
        VectorSchemaRoot shared = newNativeArrowRoot();
        VectorStreamInput.NativeArrow input = (VectorStreamInput.NativeArrow) VectorStreamInput.forNativeArrow(shared, registry);
            // Simulate ArrowBatchResponse taking ownership, then close the consumer root on the response side.
            assertEquals((byte) 30, input.readByte());
    public void testReadBytesInvalidOffsetThrows() throws IOException {
    }  
import org.opensearch.test.OpenSearchTestCase;
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");  
            expectThrows(UnsupportedOperationException.class, () -> input.readBytes(new byte[1], 0, 1));
        shared.close();  
        ((VarBinaryVector) shared.getVector("0")).allocateNew();
        try {
    }  
        // for a follow-up readByte.  
            shared.close();
        shared.close();
        // ArrowBatchResponse(StreamInput) calls claimOwnership to take ownership.
            beforeClose = allocator.getAllocatedMemory();
        }  
            // Remaining buffered bytes from row 1 feed readByte.
        vec.setValueCount(1);
            byte[] out = new byte[3];
        VectorSchemaRoot shared = newNativeArrowRoot();  
        VectorSchemaRoot shared = newByteSerializedRoot();  
        try (VectorStreamInput input = VectorStreamInput.forByteSerialized(shared, registry)) {
            expectThrows(IOException.class, input::readByte);  
import org.junit.After;
        );
        IntVector vec = (IntVector) shared.getVector("val");
    }
            super(in);
        assertEquals(1, shared.getRowCount());  
        vec.allocateNew();  
        // readByte advances row 0 into the internal buffer; readBytes must then drain the
            byte[] out = new byte[5];
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
            assertNotSame("NativeArrow transfers into a fresh consumer root", shared, input.getRoot());  
        IntVector srcVec = (IntVector) shared.getVector("val");
            assertEquals((byte) 7, input.readByte());  
        } finally {  
        return VectorSchemaRoot.create(schema, allocator);  
    }  
        shared.setRowCount(1);
    }
        in.close();  
    @Override
        // After try-with-resources: close() ran, transferred==false, root should be released.
        TestResponse response = new TestResponse(in);
    }  
        srcVec.setValueCount(1);
        return VectorSchemaRoot.create(schema, allocator);
        srcVec.setValueCount(1);
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
        VectorSchemaRoot shared = VectorSchemaRoot.create(emptySchema, allocator);  
 *
        IntVector srcVec = (IntVector) shared.getVector("val");
    private BufferAllocator allocator;
    }  
        long beforeClose;
        shared.close();
        vec.setValueCount(1);
    }
        VectorSchemaRoot shared = newNativeArrowRoot();
        assertSame(consumerRoot, response.getRoot());  
        Schema schema = new Schema(List.of(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null)));
        srcVec.allocateNew();
    private VectorSchemaRoot newByteSerializedRoot() {
        shared.setRowCount(1);
    public void testByteSerializedReadsBytesFromSharedVector() throws IOException {  
        }
    public void testNativeArrowTransfersIntoOwnedRoot() throws IOException {
            expectThrows(IOException.class, () -> input.readBytes(out, 0, 2));  
        // Consumer root must remain usable — ArrowBatchResponse owns it after handoff.  
            input.getRoot().close();
        VectorSchemaRoot shared = newNativeArrowRoot();
            assertEquals("source must be drained", 0, shared.getRowCount());
        shared.close();
        VarBinaryVector vec = (VarBinaryVector) shared.getVector("0");
