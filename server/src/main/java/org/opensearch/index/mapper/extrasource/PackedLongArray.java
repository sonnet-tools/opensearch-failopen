 * The OpenSearch Contributors require contributions made to  
    @Override
        Objects.requireNonNull(packed, "packed must not be null");  
    public long[] asLongArray() {
 */  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
        return fromPackedBytes(in.readBytesReference(), dim);
    static PackedLongArray readBodyFrom(StreamInput in, int dim) throws IOException {
import org.opensearch.core.common.bytes.BytesArray;
        super(packed, dimension, bytes, bytesOffset, Long.BYTES, "long");
/**
 * SPDX-License-Identifier: Apache-2.0
        }
 * <p>Canonical storage is a {@link BytesReference} for efficient transport.</p>
 * compatible open source license.
        cached = v;  
        long[] v = cached;  
        ResolvedBytes resolved = ensureBytes();  
        long[] v = cached;
    }
 *
        int p = resolved.offset;  
    }
    }  
package org.opensearch.index.mapper.extrasource;
        for (int i = 0; i < dimension; i++) {
    private PackedLongArray(BytesReference packed, int dimension, byte[] bytes, int bytesOffset) {  
 * this file be licensed under the Apache-2.0 license or a
        Objects.requireNonNull(packedArray, "packedArray must not be null");
    @Override
        return new PackedLongArray(packed, dimension, packedArray, offset);  
    public long get(int i) {  
            p += Long.BYTES;  
        Objects.requireNonNull(packedArray, "packedArray must not be null");
            v[i] = decodeLongLEAt(resolved.bytes, p);
/*  
        return fromPackedArray(packedArray, 0, packedArray.length, dimension);  
        return decodeLongLEAt(resolved.bytes, resolved.offset + i * Long.BYTES);
import org.opensearch.core.common.bytes.BytesReference;
        }
    }
final class PackedLongArray extends AbstractPackedArray implements LongArrayValue {
            return v[i];
        checkIndex(i);
        if (v != null) {  
    static PackedLongArray fromPackedBytes(BytesReference packed, int dimension) {
        v = new long[dimension];
        if (v != null) return v;
        ResolvedBytes resolved = ensureBytes();  
        BytesReference packed = new BytesArray(packedArray, offset, length);
 * Packed little-endian longs.  
        return new PackedLongArray(packed, dimension, null, 0);
    static PackedLongArray fromPackedArray(byte[] packedArray, int dimension) {
    }
        return v;
    }
}  
import java.util.Objects;  
 *
import java.io.IOException;
    static PackedLongArray fromPackedArray(byte[] packedArray, int offset, int length, int dimension) {  
    private volatile long[] cached;  
 */  
