        return new PackedDoubleArray(packed, dimension, packedArray, offset);  
    public double get(int i) {  
    }
 * The OpenSearch Contributors require contributions made to  
    }
        BytesReference packed = new BytesArray(packedArray, offset, length);
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Objects;  
        return fromPackedBytes(in.readBytesReference(), dim);
    @Override
        double[] v = cached;  
    public double[] asDoubleArray() {
    }
    }
        Objects.requireNonNull(packedArray, "packedArray must not be null");
 *
            p += Double.BYTES;  
        if (v != null) {  
import java.io.IOException;
        if (v != null) return v;
 */  
package org.opensearch.index.mapper.extrasource;
        return decodeDoubleLEAt(resolved.bytes, resolved.offset + i * Double.BYTES);
/*  
    static PackedDoubleArray readBodyFrom(StreamInput in, int dim) throws IOException {
        checkIndex(i);
    }  
    static PackedDoubleArray fromPackedBytes(BytesReference packed, int dimension) {
        ResolvedBytes resolved = ensureBytes();  
        int p = resolved.offset;  
            return v[i];
}  
    }
 * <p>Canonical storage is a {@link BytesReference} for efficient transport.</p>
        Objects.requireNonNull(packedArray, "packedArray must not be null");
        }
    @Override
            v[i] = decodeDoubleLEAt(resolved.bytes, p);
import org.opensearch.core.common.bytes.BytesArray;
        double[] v = cached;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */  
        Objects.requireNonNull(packed, "packed must not be null");  
import org.opensearch.core.common.io.stream.StreamInput;  
        super(packed, dimension, bytes, bytesOffset, Double.BYTES, "double");
        return new PackedDoubleArray(packed, dimension, null, 0);
        for (int i = 0; i < dimension; i++) {
        }
 * Packed little-endian doubles.  
        return fromPackedArray(packedArray, 0, packedArray.length, dimension);  
    static PackedDoubleArray fromPackedArray(byte[] packedArray, int offset, int length, int dimension) {  
        return v;
        ResolvedBytes resolved = ensureBytes();  
 *
    private PackedDoubleArray(BytesReference packed, int dimension, byte[] bytes, int bytesOffset) {  
        cached = v;  
    }
 * SPDX-License-Identifier: Apache-2.0
/**
final class PackedDoubleArray extends AbstractPackedArray implements DoubleArrayValue {
        v = new double[dimension];
    private volatile double[] cached;  
    static PackedDoubleArray fromPackedArray(byte[] packedArray, int dimension) {
