    public NamedWriteableRegistry namedWriteableRegistry() {
     */
        return root;
                throw new EOFException("No more rows available in vector");
        return reader.read(this);
            throw new UnsupportedOperationException("Native Arrow responses read vectors directly from getRoot()");
            }
    // ── Byte serialization ──
                return buffer.get();
            }
            VectorTransfer.transferRoot(streamRoot, consumerRoot);
 *
    // No-op: bounds checks happen at read time in ByteSerialized, which throws
     * consumer root; {@link ArrowBatchResponse} grabs it via the receive-side constructor.
 *       the response's Java fields, so no ownership transfer is needed.</li>
        public byte[] getMetadata() {
    protected void ensureCanReadBytes(int length) {}
                throw new IOException("Empty byte array in vector at row " + (row - 1));
    }
        @Override
        Writeable.Reader<? extends C> reader = namedWriteableRegistry().getReader(categoryClass, name);
        ByteSerialized(VectorSchemaRoot root, NamedWriteableRegistry registry) {
            if (row >= vector.getValueCount()) {
        throw new UnsupportedOperationException();
        public void close() {}
        this.root = root;
    @Override
        }
                }
        return new ByteSerialized(streamRoot, registry);
         */
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
abstract class VectorStreamInput extends StreamInput {
    // EOFException when the column is exhausted.
        private boolean transferred = false;
    // ── Native Arrow ──
        @Override
    static final class NativeArrow extends VectorStreamInput implements ArrowStreamInput {
    public int read() throws IOException {
            super(root, registry);
            if (offset < 0 || len < 0 || offset + len > b.length) {
 *
    /**
        }
        }
            if (v.length == 0) {
        }
import java.nio.ByteBuffer;
 * SPDX-License-Identifier: Apache-2.0
 *
                    throw new IOException("Empty byte array in vector at row " + (row - 1));
 * <p>Two factories:
 *       consumer root before reading, so the returned {@link ArrowBatchResponse} is
        String name = readString();
    static VectorStreamInput forNativeArrow(VectorSchemaRoot streamRoot, NamedWriteableRegistry registry, byte[] metadata) {
    }
     */
}
                if (row >= vector.getValueCount()) {
                    offset += v.length;
                byte[] v = vector.get(row++);
 * The OpenSearch Contributors require contributions made to
    /**
        @Override
    @Override
    }
    public VectorSchemaRoot getRoot() {
    /** Byte-serialized input: reads bytes from the stream root's single {@code VarBinary} column. */
    @Override
        private int row = 0;
    }
        return registry;
            this.vector = (VarBinaryVector) root.getVector("0");
    }
    @Override
                throw new IllegalArgumentException("Invalid offset or length");
                if (v.length == 0) {
        }
        }
                if (v.length <= remaining) {
            throw new UnsupportedOperationException("Native Arrow responses read vectors directly from getRoot()");
            }
     * bytes written by the transport. Reads are over the stream root; FlightStream retains ownership.
        /**
        private final byte[] metadata;
                int bufferBytes = Math.min(buffer.remaining(), remaining);
        @Override
        }
import org.opensearch.core.common.io.stream.NamedWriteable;
import org.apache.arrow.vector.VarBinaryVector;
        @Override
    static VectorStreamInput forByteSerialized(VectorSchemaRoot streamRoot, NamedWriteableRegistry registry) {
            this.metadata = metadata;
        public byte readByte() {
                buffer.get(b, offset, bufferBytes);
    protected final VectorSchemaRoot root;
            throw t;
                    System.arraycopy(v, 0, b, offset, remaining);
                }
            streamRoot.getSchema(),
                remaining -= bufferBytes;
            int remaining = len;
        @Override
 *   <li>{@link #forByteSerialized} — reads bytes directly from the stream root. Used when the
        public void readBytes(byte[] b, int offset, int len) throws IOException {
                }
            }
    }
    }
        return forNativeArrow(streamRoot, registry, null);
            buffer = ByteBuffer.wrap(v);
    }
 *   <li>{@link #forNativeArrow} — zero-copy transfers the stream root's vectors into a
        }
            return buffer.get();
 * <p>Flight picks the factory based on whether the registered handler is an
        );
            return metadata;
            byte[] v = vector.get(row++);
     * outlives the next Flight batch. Released by {@link NativeArrow#close()} unless the
                }
                if (!buffer.hasRemaining()) {
                    buffer = null;
        /** Releases the consumer root unless {@link #claimOwnership()} was called. */
 * compatible open source license.
        } catch (Throwable t) {
 *       independent of the Flight stream's lifecycle.</li>
        }
            while (remaining > 0) {
                    System.arraycopy(v, 0, b, offset, v.length);
        private final VarBinaryVector vector;
     * response takes ownership via {@link NativeArrow#claimOwnership()}.
 * <ul>
            throw new IllegalStateException("Native Arrow batch has no field vectors");
            super(root, registry);
            consumerRoot.close();
        NativeArrow(VectorSchemaRoot root, NamedWriteableRegistry registry, byte[] metadata) {
            if (buffer != null && buffer.hasRemaining()) {
/**
    static VectorStreamInput forNativeArrow(VectorSchemaRoot streamRoot, NamedWriteableRegistry registry) {
        private ByteBuffer buffer = null;
 * {@code ArrowBatchResponse} can claim the batch without knowing about Flight.
            }
                    throw new EOFException("No more rows available in vector");
import org.opensearch.arrow.transport.ArrowStreamInput;
        if (streamRoot.getFieldVectors().isEmpty()) {
 *       response is not an {@link ArrowBatchResponse}: {@code handler.read()} copies bytes into
     * Transfers the stream root's vectors into a consumer root so the returned response
    @Override
 * this file be licensed under the Apache-2.0 license or a
                root.close();
                } else {
    @Override
                    remaining -= v.length;
import java.io.EOFException;
    }
import org.opensearch.arrow.transport.ArrowBatchResponseHandler;
        VectorSchemaRoot consumerRoot = VectorSchemaRoot.create(
 * </ul>
        return reader.read(this);
    protected VectorStreamInput(VectorSchemaRoot root, NamedWriteableRegistry registry) {
package org.opensearch.arrow.flight.transport;
        public void claimOwnership() {
        public void close() {
     * Returns the underlying {@link VectorSchemaRoot}. For {@link NativeArrow} this is the
    static final class ByteSerialized extends VectorStreamInput {
    /** Native Arrow input: consumer root carrying vectors transferred from the Flight stream. */
    }
 * Flight's {@link StreamInput} backed by a {@link VectorSchemaRoot}.
         * batches and closes them when the stream ends.
    public <C extends NamedWriteable> C readNamedWriteable(Class<C> categoryClass) throws IOException {
import org.opensearch.arrow.transport.VectorTransfer;
            }
import java.io.IOException;
        try {
        @Override
/*
                    buffer = ByteBuffer.wrap(v, remaining, v.length - remaining);
        throw new UnsupportedOperationException();
     */
    }
        }
 * {@link ArrowBatchResponseHandler}. Native inputs implement {@link ArrowStreamInput} so
        public byte readByte() throws IOException {
 */
    public <C extends NamedWriteable> C readNamedWriteable(Class<C> categoryClass, String name) throws IOException {
    public int available() {
            if (buffer != null && buffer.hasRemaining()) {
import org.opensearch.core.common.io.stream.StreamInput;
    /**
            streamRoot.getFieldVectors().getFirst().getAllocator()
            }
                offset += bufferBytes;
                    remaining = 0;
import org.apache.arrow.vector.VectorSchemaRoot;
    }
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.arrow.transport.ArrowBatchResponse;
         * No-op: the stream root is owned by the transport, which resets its vectors between
     * Byte-serialized path: the stream root carries a single {@code VarBinary} column of chunked
        this.registry = registry;
        return new NativeArrow(consumerRoot, registry, metadata);
 */
    protected final NamedWriteableRegistry registry;
 *
        }
        @Override
        Writeable.Reader<? extends C> reader = namedWriteableRegistry().getReader(categoryClass, name);
 * @opensearch.internal
            transferred = true;
            if (!transferred && root != null) {
        public void readBytes(byte[] b, int offset, int len) {
