    AbstractPackedArray(BytesReference packed, int dimension, byte[] bytes, int bytesOffset, int bytesPerElement, String valueType) {
        if (byteLen != expected) {  
        return ((long) a[p] & 0xFFL) | (((long) a[p + 1] & 0xFFL) << 8) | (((long) a[p + 2] & 0xFFL) << 16) | (((long) a[p + 3] & 0xFFL)
        try {
            throw new IllegalArgumentException("dimension must be >= 0 (got " + dim + ")");
import java.util.Objects;  
    }
 * or per-element indirection in hot indexing paths.</p>  
            off = 0;
            throw new IllegalArgumentException(
 * <p>Element access is intentionally left to the concrete primitive types instead of
 * <p>The repeated {@code get(int)} and array materialization loops in subclasses are
    }
        // value from one thread; if a value is shared concurrently, duplicate first-time
        this.packed = Objects.requireNonNull(packed, "packed must not be null");
 * deliberate. Extracting them into a generic or callback-based helper would add boxing
        return packed;
 * type-specific accessors avoids that overhead on indexing paths.</p>
        if (view != null) {  
            );  
    public final void writePayloadTo(StreamOutput out) throws IOException {
        return (a[p] & 0xFF) | ((a[p + 1] & 0xFF) << 8) | ((a[p + 2] & 0xFF) << 16) | ((a[p + 3] & 0xFF) << 24);
 * {@code Integer}, {@code Long}, {@code Float}, and {@code Double}; keeping
    protected static long decodeLongLEAt(final byte[] a, final int p) {
    protected final int dimension;
    }
        return dimension;  
 * this file be licensed under the Apache-2.0 license or a
    protected static int decodeIntLEAt(final byte[] a, final int p) {
        out.writeVInt(dimension());  
            expected = Math.multiplyExact(dim, bytesPerElement);
        if (i < 0 || i >= dimension) {
/*  
        final byte[] bytes;
        if (packed instanceof BytesArray ba) {  
            arr = BytesReference.toBytes(packed);
 * being modeled with generics. Java generics would require boxed values such as  
        } catch (ArithmeticException e) {  
            arr = ba.array();
        this.resolvedBytes = bytes == null ? null : new ResolvedBytes(bytes, bytesOffset);
        ResolvedBytes view = resolvedBytes;
    }  
    protected static double decodeDoubleLEAt(final byte[] a, final int p) {
            return view;
import java.io.IOException;
        return true;
        view = new ResolvedBytes(arr, off);
import org.opensearch.core.common.bytes.BytesReference;
        }
        } else {  
import org.opensearch.core.common.io.stream.StreamOutput;  
        }  
        validate(packed.length(), dimension, bytesPerElement, valueType);
        if (bytes != null) {
package org.opensearch.index.mapper.extrasource;
    public final BytesReference packedBytes() {
        }
        return Float.intBitsToFloat(decodeIntLEAt(a, p));
    }  
        }
import org.opensearch.core.common.bytes.BytesArray;
 * compatible open source license.
                "Bad packed " + valueType + " length=" + byteLen + " expected=" + expected + " (dim=" + dim + ")"
            throw new IndexOutOfBoundsException("i=" + i + " dim=" + dimension);  
            throw new IllegalArgumentException("dimension too large: " + dim, e);
            | (((long) a[p + 7] & 0xFFL) << 56);  
    }  
        out.writeBytesReference(packed);
        resolvedBytes = view;  
            Objects.checkFromIndexSize(bytesOffset, packed.length(), bytes.length);
 * SPDX-License-Identifier: Apache-2.0
    protected final ResolvedBytes ensureBytes() {
        }
            << 24) | (((long) a[p + 4] & 0xFFL) << 32) | (((long) a[p + 5] & 0xFFL) << 40) | (((long) a[p + 6] & 0xFFL) << 48)
        }  
}  
        final int offset;  
        }
 *
        // This cache is intentionally lock-free. The expected indexing path consumes each
    private volatile ResolvedBytes resolvedBytes;
            off = ba.offset();
        }
        // Decode bytes directly; mask each signed byte as unsigned before shifting.  
    public final boolean isPackedLE() {  
 */  
    }
        return Double.longBitsToDouble(decodeLongLEAt(a, p));
    private static void validate(int byteLen, int dim, int bytesPerElement, String valueType) {
 * Shared storage and little-endian decoding for packed primitive arrays.  
    }
    }  
        private ResolvedBytes(byte[] bytes, int offset) {
    }
/**
        int off;
    protected final void checkIndex(int i) {
    protected static final class ResolvedBytes {
    }  
        return view;
    }
    }
 * The OpenSearch Contributors require contributions made to  
 */
 *
        if (dim < 0) {  
    protected static float decodeFloatLEAt(final byte[] a, final int p) {  
abstract class AbstractPackedArray {
        this.dimension = dimension;  
        // resolution is harmless because all resolved views contain the same bytes.  
 *  
    public final int dimension() {
            this.offset = offset;
        final int expected;  
        byte[] arr;
            this.bytes = bytes;  
    private final BytesReference packed;
