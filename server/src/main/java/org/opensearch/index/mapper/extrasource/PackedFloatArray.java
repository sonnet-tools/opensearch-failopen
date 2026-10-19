        }  
 *
 *   <li>If created from an array (or a {@link BytesArray}), keep an array-backed view (no copy).</li>  
            p += Float.BYTES;
        for (int i = 0; i < dimension; i++) {  
    public float[] asFloatArray() {
        float[] v = cached;
        Objects.requireNonNull(packed, "packed must not be null");
            return v[i];  
 *
    }
        Objects.requireNonNull(packedArray, "packedArray must not be null");  
    public static PackedFloatArray fromPackedArray(byte[] packedArray, int dimension) {  
        return fromPackedBytes(in.readBytesReference(), dim);
 *
    }
        ResolvedBytes resolved = ensureBytes();
    }  
    public static PackedFloatArray fromPackedBytes(BytesReference packed, int dimension) {
    @Override  
        checkIndex(i);  
package org.opensearch.index.mapper.extrasource;
 * <p>Canonical storage is a {@link BytesReference} for efficient transport.</p>
import org.opensearch.core.common.bytes.BytesReference;
    private PackedFloatArray(BytesReference packed, int dimension, byte[] bytes, int bytesOffset) {
        BytesReference packed = new BytesArray(packedArray, offset, length);
/*  
        }
 *   <li>Otherwise, on first access that requires decoding, materialize a compact {@code byte[]} via
        return decodeFloatLEAt(resolved.bytes, resolved.offset + i * Float.BYTES);  
 * SPDX-License-Identifier: Apache-2.0
        return new PackedFloatArray(packed, dimension, null, 0);  
import java.util.Objects;  
 */
import org.opensearch.core.common.io.stream.StreamInput;  
        float[] v = cached;
 * <p>The materialization is cached for subsequent reads; under concurrent access multiple threads may
 *  
    }  
        return new PackedFloatArray(packed, dimension, packedArray, offset);
        cached = v;
        int p = resolved.offset;
        super(packed, dimension, bytes, bytesOffset, Float.BYTES, "float");  
}
    public static PackedFloatArray fromPackedArray(byte[] packedArray, int offset, int length, int dimension) {
        v = new float[dimension];
final class PackedFloatArray extends AbstractPackedArray implements FloatArrayValue {  
 *       {@code BytesReference.toBytes(...)}. This may copy for composite/paged implementations.</li>
    }
import org.opensearch.core.common.bytes.BytesArray;
    }
    @Override
    public float get(int i) {
    private volatile float[] cached;
 * this file be licensed under the Apache-2.0 license or a
 * <p>Decoding strategy:</p>
        return v;  
        return fromPackedArray(packedArray, 0, packedArray.length, dimension);
 * Packed little-endian floats.  
 * <ul>
 * The OpenSearch Contributors require contributions made to  
            v[i] = decodeFloatLEAt(resolved.bytes, p);
 * compatible open source license.
/**
        if (v != null) return v;  
import java.io.IOException;
        if (v != null) {
    }
 * transiently materialize/allocate more than once, but results are equivalent.</p>  
 */  
    static PackedFloatArray readBodyFrom(StreamInput in, int dim) throws IOException {  
        Objects.requireNonNull(packedArray, "packedArray must not be null");
        ResolvedBytes resolved = ensureBytes();
 * </ul>  
