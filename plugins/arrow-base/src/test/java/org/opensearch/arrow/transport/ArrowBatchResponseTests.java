        ((IntVector) src.getVector("a")).allocateNew();
        }
            throw new UnsupportedOperationException();
            List.of(
        verifyNoInteractions(mockOut);
        allocator = new RootAllocator();  
    public void testTransferRootMovesBuffers() {
        VectorSchemaRoot src = VectorSchemaRoot.create(schema, allocator);  
        assertEquals(2, dstVec.getValueCount());
        ((IntVector) root.getVector("val")).setValueCount(1);
        root.close();  
import static org.mockito.Mockito.verifyNoInteractions;
        dst.close();
    public void setUp() throws Exception {
        assertEquals(0, src.getRowCount());
        StreamInput notArrow = StreamInput.wrap(new byte[0]);
        }  
    }
        srcVec.setSafe(1, 99);  
            throw new UnsupportedOperationException();
        ((IntVector) root.getVector("val")).setSafe(0, 42);  
import org.opensearch.test.OpenSearchTestCase;
/*  
        public int read() {
            claimed = true;
        IntVector dstVec = (IntVector) dst.getVector("val");
        assertEquals(1, ((IntVector) dst.getVector("a")).get(0));
        assertTrue("claimOwnership must fire", in.wasClaimed());
import org.apache.arrow.vector.types.pojo.ArrowType;
        @Override
        public VectorSchemaRoot getRoot() {
 * The OpenSearch Contributors require contributions made to  
    private BufferAllocator allocator;
        }
import org.junit.After;  
        srcVec.setValueCount(2);
        src.setRowCount(1);
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);  
        ((IntVector) src.getVector("b")).setSafe(0, 2);  
        }
import static org.mockito.Mockito.mock;  
    }
        protected void ensureCanReadBytes(int length) {}
        src.close();  
        srcVec.setSafe(0, 7);  
            throw new UnsupportedOperationException();  
        FakeArrowStreamInput in = new FakeArrowStreamInput(root);
    /** Fake StreamInput that also carries an Arrow batch — the contract ArrowBatchResponse consumes. */  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("message should point at skipsDeserialization()", e.getMessage().contains("skipsDeserialization"));
        src.close();
        TestResponse(StreamInput in) throws IOException {
        }
        VectorSchemaRoot dst = VectorSchemaRoot.create(schema, allocator);
    public void tearDown() throws Exception {  
    }
            return root;
        assertEquals(2, ((IntVector) dst.getVector("b")).get(0));  
    private Schema schema;  
        srcVec.allocateNew();
import java.util.List;
        @Override
        public void readBytes(byte[] b, int offset, int len) {
        private boolean claimed = false;  
        VectorSchemaRoot src = VectorSchemaRoot.create(schema, allocator);
        // Close the source — destination owns the buffers now.
        assertEquals(0, srcVec.getValueCount());
        VectorSchemaRoot src = VectorSchemaRoot.create(multiSchema, allocator);
    @Override
    public void testWriteToFailsFast() {  
    @Override  
            )
        @Override
}
            this.root = root;  
        VectorTransfer.transferRoot(src, dst);  
        assertEquals(1, dst.getRowCount());
    public void testStreamInputConstructorRejectsNonArrowInput() {
    }  
    public void testTransferRootDestinationSurvivesSourceClose() {
import org.junit.Before;
import org.apache.arrow.memory.BufferAllocator;
 *
        VectorSchemaRoot dst = VectorSchemaRoot.create(multiSchema, allocator);
import org.apache.arrow.memory.RootAllocator;
        src.setRowCount(2);  
        }  
    }
            throw new UnsupportedOperationException();
public class ArrowBatchResponseTests extends OpenSearchTestCase {  
                new Field("a", FieldType.nullable(new ArrowType.Int(32, true)), null),
    @Before
    public void testStreamInputConstructorCapturesRootAndClaimsOwnership() throws IOException {  
        assertSame(root, response.getRoot());
        public void close() {}
        IntVector srcVec = (IntVector) src.getVector("val");  
        public byte readByte() {  
        FakeArrowStreamInput(VectorSchemaRoot root) {
        assertEquals(7, dstVec.get(0));
        Schema multiSchema = new Schema(  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> new TestResponse(notArrow));  
        StreamOutput mockOut = mock(StreamOutput.class);  
import org.apache.arrow.vector.types.pojo.Field;  
        src.close();
        dst.close();  
        boolean wasClaimed() {
        ((IntVector) src.getVector("a")).setSafe(0, 1);  
import org.apache.arrow.vector.VectorSchemaRoot;
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
        }
        ((IntVector) src.getVector("b")).setValueCount(1);
    public void testGetRootReturnsProducerRoot() {
        root.close();  
        assertEquals(2, dst.getRowCount());
        srcVec.allocateNew();
import java.io.IOException;  
        srcVec.setSafe(0, 42);
        assertEquals(2, dst.getRowCount());
        assertSame(root, response.getRoot());
        @Override
        VectorTransfer.transferRoot(src, dst);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(42, dstVec.get(0));  
        super.tearDown();
 */  
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
        @Override  
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
        assertEquals(99, dstVec.get(1));
import org.apache.arrow.vector.types.pojo.FieldType;
        VectorTransfer.transferRoot(src, dst);
        ((IntVector) src.getVector("a")).setValueCount(1);
        private final VectorSchemaRoot root;
        );
        public void claimOwnership() {  
        }
        allocator.close();
        @Override  
        @Override
        IntVector dstVec = (IntVector) dst.getVector("val");  
    }
    static class TestResponse extends ArrowBatchResponse {
        expectThrows(UnsupportedOperationException.class, () -> response.writeTo(mockOut));
import org.apache.arrow.vector.types.pojo.Schema;
        // Source should be empty after transfer  
        assertEquals(13, dstVec.get(1));  
package org.opensearch.arrow.transport;
        src.setRowCount(2);
    }
import org.apache.arrow.vector.IntVector;  
            super(root);
    static class FakeArrowStreamInput extends StreamInput implements ArrowStreamInput {
        TestResponse response = new TestResponse(in);
        TestResponse(VectorSchemaRoot root) {  
    }  
        ((IntVector) root.getVector("val")).allocateNew();
    public void testTransferRootWithMultipleVectors() {
 * compatible open source license.
        TestResponse response = new TestResponse(root);
        root.setRowCount(1);
            super(in);
        VectorSchemaRoot dst = VectorSchemaRoot.create(schema, allocator);
    }
    }  
        ((IntVector) src.getVector("b")).allocateNew();
        @Override
        public int available() {  
        root.close();
        }  
        super.setUp();
        }  
        srcVec.setValueCount(2);
            return claimed;
        dst.close();
        srcVec.setSafe(1, 13);
import org.opensearch.core.common.io.stream.StreamOutput;
                new Field("b", FieldType.nullable(new ArrowType.Int(32, true)), null)  
    @After
        TestResponse response = new TestResponse(root);
        schema = new Schema(List.of(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null)));
        IntVector srcVec = (IntVector) src.getVector("val");
