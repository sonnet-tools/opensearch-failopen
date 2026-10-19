            consumerRoot.close();  
                }
    static VectorStreamInput forNativeArrow(VectorSchemaRoot streamRoot, NamedWriteableRegistry registry, byte[] metadata) {
import org.apache.arrow.vector.VarBinaryVector;
 *
                offset += bufferBytes;  
        public void claimOwnership() {
    /** Native Arrow input: consumer root carrying vectors transferred from the Flight stream. */
            streamRoot.getFieldVectors().getFirst().getAllocator()
    }
                }
 * this file be licensed under the Apache-2.0 license or a
            if (!transferred && root != null) {
 * {@link ArrowBatchResponseHandler}. Native inputs implement {@link ArrowStreamInput} so  
    /** Byte-serialized input: reads bytes from the stream root's single {@code VarBinary} column. */
        }
import org.opensearch.core.common.io.stream.Writeable;
            return buffer.get();
                }
        }
        if (streamRoot.getFieldVectors().isEmpty()) {
            if (row >= vector.getValueCount()) {  
            VectorTransfer.transferRoot(streamRoot, consumerRoot);
    @Override  
                    System.arraycopy(v, 0, b, offset, v.length);
     */
import org.opensearch.core.common.io.stream.NamedWriteable;
        Writeable.Reader<? extends C> reader = namedWriteableRegistry().getReader(categoryClass, name);  
            int remaining = len;
        private int row = 0;
 * The OpenSearch Contributors require contributions made to  
                return buffer.get();
            if (offset < 0 || len < 0 || offset + len > b.length) {
     * Transfers the stream root's vectors into a consumer root so the returned response  
        public void readBytes(byte[] b, int offset, int len) {
            transferred = true;
    static VectorStreamInput forNativeArrow(VectorSchemaRoot streamRoot, NamedWriteableRegistry registry) {  
 * <p>Flight picks the factory based on whether the registered handler is an
        Writeable.Reader<? extends C> reader = namedWriteableRegistry().getReader(categoryClass, name);  
    }
         * No-op: the stream root is owned by the transport, which resets its vectors between
            }  
                    System.arraycopy(v, 0, b, offset, remaining);
}  
                if (row >= vector.getValueCount()) {
 *       independent of the Flight stream's lifecycle.</li>
        @Override
        this.root = root;
        @Override
    public <C extends NamedWriteable> C readNamedWriteable(Class<C> categoryClass) throws IOException {
    public int available() {  
     * Returns the underlying {@link VectorSchemaRoot}. For {@link NativeArrow} this is the
     * response takes ownership via {@link NativeArrow#claimOwnership()}.
            while (remaining > 0) {
        } catch (Throwable t) {
        @Override
    protected void ensureCanReadBytes(int length) {}
    }  
            }  
import org.opensearch.arrow.transport.ArrowStreamInput;
 *       the response's Java fields, so no ownership transfer is needed.</li>
abstract class VectorStreamInput extends StreamInput {
                int bufferBytes = Math.min(buffer.remaining(), remaining);
import org.opensearch.arrow.transport.ArrowBatchResponse;  
     */  
            if (v.length == 0) {
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
    protected final NamedWriteableRegistry registry;
    static final class NativeArrow extends VectorStreamInput implements ArrowStreamInput {
 *
        }
    // ── Native Arrow ──
    @Override
                root.close();
 *   <li>{@link #forNativeArrow} — zero-copy transfers the stream root's vectors into a  
        }
                } else {
/**
    protected final VectorSchemaRoot root;
        throw new UnsupportedOperationException();
        }  
        String name = readString();
 * </ul>  
            this.vector = (VarBinaryVector) root.getVector("0");
import org.apache.arrow.vector.VectorSchemaRoot;
 * <p>Two factories:
        @Override
            throw t;
import java.io.IOException;
                byte[] v = vector.get(row++);
                    remaining -= v.length;  
            streamRoot.getSchema(),  
        }  
        public void readBytes(byte[] b, int offset, int len) throws IOException {  
        private ByteBuffer buffer = null;  
 * Flight's {@link StreamInput} backed by a {@link VectorSchemaRoot}.
    /**  
 * SPDX-License-Identifier: Apache-2.0
        this.registry = registry;  
    // EOFException when the column is exhausted.
    @Override  
    // No-op: bounds checks happen at read time in ByteSerialized, which throws
                if (v.length == 0) {  
    protected VectorStreamInput(VectorSchemaRoot root, NamedWriteableRegistry registry) {
     */  
        /**  
 *  
    }  
            }  
                }
    public <C extends NamedWriteable> C readNamedWriteable(Class<C> categoryClass, String name) throws IOException {
    static final class ByteSerialized extends VectorStreamInput {  
    }
 *
        return forNativeArrow(streamRoot, registry, null);
                    remaining = 0;
        VectorSchemaRoot consumerRoot = VectorSchemaRoot.create(
    }
 */  
        );
        private final byte[] metadata;
            buffer = ByteBuffer.wrap(v);
        return new NativeArrow(consumerRoot, registry, metadata);  
 *       response is not an {@link ArrowBatchResponse}: {@code handler.read()} copies bytes into
        ByteSerialized(VectorSchemaRoot root, NamedWriteableRegistry registry) {
        }
                throw new IOException("Empty byte array in vector at row " + (row - 1));
    static VectorStreamInput forByteSerialized(VectorSchemaRoot streamRoot, NamedWriteableRegistry registry) {
    public VectorSchemaRoot getRoot() {
import org.opensearch.arrow.transport.VectorTransfer;  
import java.io.EOFException;  
        throw new UnsupportedOperationException();
        public byte readByte() {  
        return new ByteSerialized(streamRoot, registry);
                    buffer = ByteBuffer.wrap(v, remaining, v.length - remaining);  
import org.opensearch.core.common.io.stream.StreamInput;  
        return reader.read(this);
    // ── Byte serialization ──  
        public byte readByte() throws IOException {
        /** Releases the consumer root unless {@link #claimOwnership()} was called. */
/*  
        private final VarBinaryVector vector;
        }
        }
            throw new UnsupportedOperationException("Native Arrow responses read vectors directly from getRoot()");
            super(root, registry);  
                throw new IllegalArgumentException("Invalid offset or length");
        return root;  
 *       consumer root before reading, so the returned {@link ArrowBatchResponse} is
                buffer.get(b, offset, bufferBytes);
                    throw new IOException("Empty byte array in vector at row " + (row - 1));
        return registry;  
                if (!buffer.hasRemaining()) {
    }  
            byte[] v = vector.get(row++);  
        public void close() {  
     * consumer root; {@link ArrowBatchResponse} grabs it via the receive-side constructor.  
            if (buffer != null && buffer.hasRemaining()) {  
        public byte[] getMetadata() {  
 * {@code ArrowBatchResponse} can claim the batch without knowing about Flight.
                    buffer = null;  
 * <ul>
                remaining -= bufferBytes;
     * outlives the next Flight batch. Released by {@link NativeArrow#close()} unless the
 *   <li>{@link #forByteSerialized} — reads bytes directly from the stream root. Used when the  
 * @opensearch.internal  
    @Override
                if (v.length <= remaining) {  
            this.metadata = metadata;
            throw new IllegalStateException("Native Arrow batch has no field vectors");  
                throw new EOFException("No more rows available in vector");
        private boolean transferred = false;  
    @Override
    /**
    public int read() throws IOException {
        @Override
    /**
            return metadata;
    }
        public void close() {}
 */
        try {  
        @Override  
    public NamedWriteableRegistry namedWriteableRegistry() {
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        }
        }  
 * compatible open source license.
        NativeArrow(VectorSchemaRoot root, NamedWriteableRegistry registry, byte[] metadata) {  
            }
                    offset += v.length;
     * bytes written by the transport. Reads are over the stream root; FlightStream retains ownership.
            super(root, registry);
            }
            }  
            }
        return reader.read(this);
            if (buffer != null && buffer.hasRemaining()) {  
import java.nio.ByteBuffer;
    }
         */  
            throw new UnsupportedOperationException("Native Arrow responses read vectors directly from getRoot()");  
        @Override
     * Byte-serialized path: the stream root carries a single {@code VarBinary} column of chunked
    @Override  
         * batches and closes them when the stream ends.
package org.opensearch.arrow.flight.transport;
                    throw new EOFException("No more rows available in vector");  
    }
        @Override
    }
