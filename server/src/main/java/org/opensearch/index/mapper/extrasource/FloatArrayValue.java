     * @return a float-array value backed by the provided bytes  
import java.io.IOException;
    /**
     * @throws IllegalArgumentException if the byte length does not match {@code dimension * 4}
     * Creates a {@link FloatArrayValue} from packed little-endian bytes.
     * For other BytesReference implementations, decoding may lazily materialize one cached
     * @throws IllegalArgumentException if the byte length does not match {@code dimension * 4}
     */  
    /**
/*  
     */
    /**
     * @param values the float values
     * @return a float-array value backed by the provided array  
        if (packedLE) {
    /** Number of float elements. */
        final boolean packedLE = in.readBoolean();  
     * Packed bytes for the float vector (LE, 4 * dimension bytes).  
    static FloatArrayValue readBodyFrom(StreamInput in) throws IOException {
     * Convenience; allocates a float array for packed values.  
    }
}
    void writePayloadTo(StreamOutput out) throws IOException;  
package org.opensearch.index.mapper.extrasource;
    }
    static FloatArrayValue fromFloatArray(float[] values) {
    /**
            return PrimitiveFloatArray.readBodyFrom(in);
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.common.io.stream.StreamInput;
    static FloatArrayValue fromPackedBytes(BytesReference packed, int dimension) {  
    /** Random access (packed reads 4 bytes at i*4; non-packed returns v[i]). */
     * Zero-copy decoding is used when the packed value is backed by a usable byte array.
     *  
        out.writeBoolean(isPackedLE());
     * @param packed the packed float bytes (dimension * 4 bytes)
            return PackedFloatArray.readBodyFrom(in, dim);  
 * <p>Supports both primitive (decoded) and packed (little-endian) representations.</p>
    }
            final int dim = in.readVInt();
    }
 * compatible open source license.
    boolean isPackedLE();  
     * Creates a {@link FloatArrayValue} from a packed little-endian byte array.
 */  
        return PackedFloatArray.fromPackedArray(packed, dimension);
        }  
import org.opensearch.core.common.io.stream.StreamOutput;  
     * @param dimension the number of float elements
    static FloatArrayValue fromPackedArray(byte[] packed, int dimension) {  
        writePayloadTo(out);  
     * Only valid when isPackedLE() == true.
 * this file be licensed under the Apache-2.0 license or a
 *
        } else {
     * @param dimension the number of float elements
    int dimension();  
     * Creates a {@link FloatArrayValue} from a float array.
 */
     *  
    }
    }  
/**
        return new PrimitiveFloatArray(values);
        return Type.FLOAT_ARRAY;
    @Override
    @Override  
public non-sealed interface FloatArrayValue extends ExtraFieldValue {  
     */
    default int size() {
 * The OpenSearch Contributors require contributions made to  
    /**
 * SPDX-License-Identifier: Apache-2.0
     */
        return PackedFloatArray.fromPackedBytes(packed, dimension);
     * @return a float-array value backed by the provided array
     * @param packed the packed float bytes (dimension * 4 bytes)
    /** True if backed by little-endian packed bytes. */
    @Override
    default Type type() {  
     */
 * A float array value used in {@link ExtraFieldValue}.
 *  
    }
     * byte array.  
    float get(int i);  
    default void writeBodyTo(StreamOutput out) throws IOException {
    BytesReference packedBytes();  
        return dimension();  
     *  
    float[] asFloatArray();
