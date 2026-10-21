import org.apache.arrow.vector.types.pojo.Schema;
        StreamOutput mockOut = mock(StreamOutput.class);
        ((IntVector) src.getVector("a")).setSafe(0, 1);
        schema = new Schema(List.of(new Field("val", FieldType.nullable(new ArrowType.Int(32, true)), null)));
import org.junit.After;
 * compatible open source license.
            throw new UnsupportedOperationException();
        ((IntVector) src.getVector("b")).setSafe(0, 2);
    }
    @Override
        @Override
import static org.mockito.Mockito.mock;
        }
        srcVec.setSafe(1, 99);
}
import java.util.List;
        public int available() {
        assertEquals(7, dstVec.get(0));
        IntVector dstVec = (IntVector) dst.getVector("val");
        @Override
        dst.close();
        ((IntVector) root.getVector("val")).allocateNew();
        src.close();
        }
        allocator = new RootAllocator();
import org.junit.Before;
        srcVec.setValueCount(2);
 * The OpenSearch Contributors require contributions made to
        VectorSchemaRoot src = VectorSchemaRoot.create(schema, allocator);
        private boolean claimed = false;
    }
        }
        TestResponse(StreamInput in) throws IOException {
        srcVec.setSafe(0, 42);
        );
    public void testTransferRootDestinationSurvivesSourceClose() {
    public void testStreamInputConstructorCapturesRootAndClaimsOwnership() throws IOException {
        TestResponse response = new TestResponse(root);
        public byte readByte() {
        public VectorSchemaRoot getRoot() {
        assertEquals(42, dstVec.get(0));
        FakeArrowStreamInput(VectorSchemaRoot root) {
        ((IntVector) src.getVector("a")).allocateNew();
        VectorSchemaRoot dst = VectorSchemaRoot.create(multiSchema, allocator);
        ((IntVector) src.getVector("a")).setValueCount(1);
        public int read() {
        src.close();
        assertEquals(13, dstVec.get(1));
    @Override
    public void tearDown() throws Exception {
        dst.close();
    @Before
        assertSame(root, response.getRoot());
public class ArrowBatchResponseTests extends OpenSearchTestCase {
    }
        VectorTransfer.transferRoot(src, dst);
        // Close the source — destination owns the buffers now.
        root.close();
import org.apache.arrow.vector.types.pojo.Field;
/*
    @After
        TestResponse response = new TestResponse(root);
    }
    }
        boolean wasClaimed() {
        super.tearDown();
        VectorSchemaRoot dst = VectorSchemaRoot.create(schema, allocator);
    public void testGetRootReturnsProducerRoot() {
 *
        src.setRowCount(2);
import org.opensearch.core.common.io.stream.StreamOutput;
        srcVec.allocateNew();
        @Override
    static class TestResponse extends ArrowBatchResponse {
    public void testTransferRootMovesBuffers() {
        assertEquals(2, dstVec.getValueCount());
        srcVec.allocateNew();
        TestResponse response = new TestResponse(in);
        assertEquals(2, dst.getRowCount());
        VectorSchemaRoot src = VectorSchemaRoot.create(schema, allocator);
            throw new UnsupportedOperationException();
            List.of(
 */
    static class FakeArrowStreamInput extends StreamInput implements ArrowStreamInput {
        VectorSchemaRoot src = VectorSchemaRoot.create(multiSchema, allocator);
    }
        VectorSchemaRoot dst = VectorSchemaRoot.create(schema, allocator);
        super.setUp();
        src.setRowCount(2);
        IntVector srcVec = (IntVector) src.getVector("val");
    /** Fake StreamInput that also carries an Arrow batch — the contract ArrowBatchResponse consumes. */
        @Override
            )
    public void testWriteToFailsFast() {
        assertEquals(1, ((IntVector) dst.getVector("a")).get(0));
        VectorTransfer.transferRoot(src, dst);
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> new TestResponse(notArrow));
        TestResponse(VectorSchemaRoot root) {
        srcVec.setSafe(1, 13);
        root.close();
    public void setUp() throws Exception {
        ((IntVector) root.getVector("val")).setSafe(0, 42);
        }
        @Override
            this.root = root;
        @Override
    private Schema schema;
        }
        IntVector dstVec = (IntVector) dst.getVector("val");
            super(in);
import org.apache.arrow.memory.RootAllocator;
            throw new UnsupportedOperationException();
import org.opensearch.test.OpenSearchTestCase;
        }
            claimed = true;
        root.setRowCount(1);
import java.io.IOException;
        }
    }
import org.apache.arrow.vector.types.pojo.FieldType;
    private BufferAllocator allocator;
        IntVector srcVec = (IntVector) src.getVector("val");
        expectThrows(UnsupportedOperationException.class, () -> response.writeTo(mockOut));
        dst.close();
                new Field("a", FieldType.nullable(new ArrowType.Int(32, true)), null),
        FakeArrowStreamInput in = new FakeArrowStreamInput(root);
import org.apache.arrow.memory.BufferAllocator;
                new Field("b", FieldType.nullable(new ArrowType.Int(32, true)), null)
import static org.mockito.Mockito.verifyNoInteractions;
        ((IntVector) src.getVector("b")).allocateNew();
        public void readBytes(byte[] b, int offset, int len) {
        public void close() {}
        VectorTransfer.transferRoot(src, dst);
        }
        src.close();
 * SPDX-License-Identifier: Apache-2.0
        assertSame(root, response.getRoot());
    public void testStreamInputConstructorRejectsNonArrowInput() {
        Schema multiSchema = new Schema(
        verifyNoInteractions(mockOut);
        srcVec.setValueCount(2);
    }
        @Override
        StreamInput notArrow = StreamInput.wrap(new byte[0]);
import org.opensearch.core.common.io.stream.StreamInput;
        allocator.close();
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, src.getRowCount());
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
            throw new UnsupportedOperationException();
    public void testTransferRootWithMultipleVectors() {
import org.apache.arrow.vector.IntVector;
        // Source should be empty after transfer
        }
        protected void ensureCanReadBytes(int length) {}
package org.opensearch.arrow.transport;
        }
    }
    }
import org.apache.arrow.vector.VectorSchemaRoot;
        assertEquals(0, srcVec.getValueCount());
    }
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
        ((IntVector) root.getVector("val")).setValueCount(1);
import org.apache.arrow.vector.types.pojo.ArrowType;
        assertEquals(1, dst.getRowCount());
        @Override
        private final VectorSchemaRoot root;
        assertTrue("claimOwnership must fire", in.wasClaimed());
        assertEquals(2, dst.getRowCount());
        assertEquals(99, dstVec.get(1));
            super(root);
        assertEquals(2, ((IntVector) dst.getVector("b")).get(0));
            return claimed;
        root.close();
        src.setRowCount(1);
            return root;
        public void claimOwnership() {
        srcVec.setSafe(0, 7);
        assertTrue("message should point at skipsDeserialization()", e.getMessage().contains("skipsDeserialization"));
        ((IntVector) src.getVector("b")).setValueCount(1);
