            return v[i];
    @Override
        int p = resolved.offset;  
import org.opensearch.core.common.io.stream.StreamInput;  
        }
        ResolvedBytes resolved = ensureBytes();  
/**
    static PackedIntArray fromPackedArray(byte[] packedArray, int offset, int length, int dimension) {  
 * <p>Canonical storage is a {@link BytesReference} for efficient transport.</p>
 * compatible open source license.
    }
 * The OpenSearch Contributors require contributions made to  
        return new PackedIntArray(packed, dimension, packedArray, offset);  
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Objects;  
        return v;
    }
        Objects.requireNonNull(packedArray, "packedArray must not be null");
        return new PackedIntArray(packed, dimension, null, 0);
        int[] v = cached;
 *
    static PackedIntArray fromPackedArray(byte[] packedArray, int dimension) {
import org.opensearch.core.common.bytes.BytesArray;
        v = new int[dimension];
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
    static PackedIntArray readBodyFrom(StreamInput in, int dim) throws IOException {
        return fromPackedArray(packedArray, 0, packedArray.length, dimension);  
        checkIndex(i);
package org.opensearch.index.mapper.extrasource;
        cached = v;  
/*  
    static PackedIntArray fromPackedBytes(BytesReference packed, int dimension) {
 * Packed little-endian ints.  
        return decodeIntLEAt(resolved.bytes, resolved.offset + i * Integer.BYTES);
        int[] v = cached;  
        if (v != null) return v;
        ResolvedBytes resolved = ensureBytes();  
        Objects.requireNonNull(packedArray, "packedArray must not be null");
    }
 * this file be licensed under the Apache-2.0 license or a
        return fromPackedBytes(in.readBytesReference(), dim);
    }
final class PackedIntArray extends AbstractPackedArray implements IntArrayValue {
    }
        BytesReference packed = new BytesArray(packedArray, offset, length);
 */  
import java.io.IOException;
    }  
    private volatile int[] cached;  
    private PackedIntArray(BytesReference packed, int dimension, byte[] bytes, int bytesOffset) {  
    public int[] asIntArray() {
        }
    }
        if (v != null) {  
            p += Integer.BYTES;  
}  
        for (int i = 0; i < dimension; i++) {
        super(packed, dimension, bytes, bytesOffset, Integer.BYTES, "int");
    public int get(int i) {  
            v[i] = decodeIntLEAt(resolved.bytes, p);
        Objects.requireNonNull(packed, "packed must not be null");  
    @Override
