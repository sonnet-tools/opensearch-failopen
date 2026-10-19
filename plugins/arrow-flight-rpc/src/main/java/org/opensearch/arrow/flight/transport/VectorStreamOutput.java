        }
     * Creates a byte-serialization output.
     * Creates a native Arrow output. The root is already populated.  
        }
        public void writeBytes(byte[] b, int offset, int length) {}
        public void writeBytes(byte[] b, int offset, int length) {  
                vector.setSafe(row++, tempBuffer, 0, tempBufferPos);
    // ── Byte serialization ──
                vector.allocateNew();
 * @opensearch.internal  
            }
        return new ByteSerialized(allocator, existingRoot);
    }  
                vector = (VarBinaryVector) existingRoot.getVector(0);
    }  
    /** Creates a VectorStreamOutput. */
        }  
    static VectorStreamOutput forNativeArrow(VectorSchemaRoot root) {
                Field field = new Field("0", new FieldType(true, new ArrowType.Binary(), null, null), null);
        private int row = 0;
        }  
 * SPDX-License-Identifier: Apache-2.0
 *       {@code writeTo()} writes bytes into a VarBinary vector.</li>
     */  
        public void writeByte(byte b) {}
import java.util.List;
        public void flush() {}
abstract class VectorStreamOutput extends StreamOutput {
}
        private final VarBinaryVector vector;  
        public void close() {}
        @Override
 *       The root is already populated; writes are no-ops.</li>  
                root = new VectorSchemaRoot(List.of(vector));
 * <p>The framework selects the right factory based on whether the response  
        @Override
        private VectorSchemaRoot root;
    static final class NativeArrow extends VectorStreamOutput {
        private final byte[] tempBuffer = new byte[8192];
package org.opensearch.arrow.flight.transport;
 *
                tempBufferPos = 0;  
        @Override
/**
            if (b.length < (offset + length)) {
            root.setRowCount(row);  
            if (root == null) {  
        @Override
        public void close() throws IOException {
            return root;
        @Override
    // ── Native Arrow ──
            if (tempBufferPos >= tempBuffer.length) flushTempBuffer();
    protected VectorStreamOutput() {}
 * is an {@link ArrowBatchResponse}.
import org.apache.arrow.vector.VectorSchemaRoot;  
            vector.clear();
            if (length == 0) return;
                vector.setInitialCapacity(16);  
            row = 0;  
        }  
        public void reset() {
     */
import org.apache.arrow.vector.VarBinaryVector;
        return new NativeArrow(root);  
    /**  
 *  
        @Override
    public abstract VectorSchemaRoot getRoot();  
            }
 *
/*  
        NativeArrow(VectorSchemaRoot root) {
            row = 0;  
        }
                this.root = existingRoot;
        @Override
 * <p>Two factory methods create the appropriate instance:
        public VectorSchemaRoot getRoot() {  
 *   <li>{@link #forNativeArrow(VectorSchemaRoot)} — native Arrow.
    /**
        @Override
        }  
    }
        private final VectorSchemaRoot root;
                throw new IllegalArgumentException("Illegal offset " + offset + "/length " + length + " for byte[] of length " + b.length);  
            this.root = root;
import org.apache.arrow.vector.types.pojo.FieldType;  
                vector = (VarBinaryVector) field.createVector(allocator);
            if (existingRoot != null) {  
            flushTempBuffer();
            }
        public void flush() {}
 * compatible open source license.
 *   <li>{@link #create(BufferAllocator, VectorSchemaRoot)} — byte serialization.  
        public void reset() {}
import org.opensearch.arrow.transport.ArrowBatchResponse;
        @Override
    /**
        public VectorSchemaRoot getRoot() {  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        ByteSerialized(BufferAllocator allocator, VectorSchemaRoot existingRoot) {
        }
            vector.setValueCount(row);
            tempBuffer[tempBufferPos++] = b;
            if (tempBufferPos > 0) flushTempBuffer();
import org.apache.arrow.vector.types.pojo.ArrowType;
            tempBufferPos = 0;
            return root;
            }
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        @Override
 *
            vector.close();
     */
    }  
        private void flushTempBuffer() {  
 * this file be licensed under the Apache-2.0 license or a
            } else {  
 * A {@link StreamOutput} that produces a {@link VectorSchemaRoot} for the Flight transport.
 */  
 */
 * </ul>
 * <ul>
        @Override
import org.apache.arrow.vector.types.pojo.Field;
            if (tempBufferPos > 0) {
        @Override
     * Returns the {@link VectorSchemaRoot} to send over Flight.
    static final class ByteSerialized extends VectorStreamOutput {
            vector.setSafe(row++, b, offset, length);  
import org.apache.arrow.memory.BufferAllocator;
    static VectorStreamOutput create(BufferAllocator allocator, VectorSchemaRoot existingRoot) {
        private int tempBufferPos = 0;  
        public void writeByte(byte b) {  
