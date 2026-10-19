        } else {
 * SPDX-License-Identifier: Apache-2.0
        return Type.DOUBLE_ARRAY;
    @Override  
        final boolean packedLE = in.readBoolean();  
     * Creates a {@link DoubleArrayValue} from a packed little-endian byte array.
            return PrimitiveDoubleArray.readBodyFrom(in);
        return new PrimitiveDoubleArray(values);
     * @param dimension the number of double elements
        return PackedDoubleArray.fromPackedArray(packed, dimension);
     * @param packed the packed double bytes (dimension * 8 bytes)
     * @param values the double values
    @Override
    }
     * @param packed the packed double bytes (dimension * 8 bytes)
     * byte array.  
     */
/**
    /**
    }
    default int size() {
    void writePayloadTo(StreamOutput out) throws IOException;  
    int dimension();  
            final int dim = in.readVInt();
     * @throws IllegalArgumentException if the byte length does not match {@code dimension * 8}
    }  
     * @throws IllegalArgumentException if the byte length does not match {@code dimension * 8}
    /**
 * The OpenSearch Contributors require contributions made to  
    static DoubleArrayValue fromPackedArray(byte[] packed, int dimension) {  
 * A double array value used in {@link ExtraFieldValue}.
import org.opensearch.core.common.io.stream.StreamInput;
    static DoubleArrayValue readBodyFrom(StreamInput in) throws IOException {
     */  
     * Convenience; allocates a double array for packed values.  
     */
     * @param dimension the number of double elements
        return dimension();  
     */
 * this file be licensed under the Apache-2.0 license or a
        if (packedLE) {
public non-sealed interface DoubleArrayValue extends ExtraFieldValue {  
     * Zero-copy decoding is used when the packed value is backed by a usable byte array.
 */  
     * Creates a {@link DoubleArrayValue} from packed little-endian bytes.
        }  
     * For other BytesReference implementations, decoding may lazily materialize one cached
    }
     * Packed bytes for the double vector (LE, 8 * dimension bytes).  
/*  
     *  
 * <p>Supports both primitive (decoded) and packed (little-endian) representations.</p>
    double[] asDoubleArray();
 * compatible open source license.
            return PackedDoubleArray.readBodyFrom(in, dim);  
    /** Number of double elements. */
     * @return a double-array value backed by the provided bytes  
 *  
    default void writeBodyTo(StreamOutput out) throws IOException {
     * @return a double-array value backed by the provided array  
     */
    @Override
    }
    BytesReference packedBytes();  
    /** Random access (packed reads 8 bytes at i*8; non-packed returns v[i]). */
}
package org.opensearch.index.mapper.extrasource;
    /**
    double get(int i);  
     * Creates a {@link DoubleArrayValue} from a double array.
    /**
    /** True if backed by little-endian packed bytes. */
    static DoubleArrayValue fromDoubleArray(double[] values) {
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.common.io.stream.StreamOutput;  
 */
 *
     *  
    static DoubleArrayValue fromPackedBytes(BytesReference packed, int dimension) {  
    }
        return PackedDoubleArray.fromPackedBytes(packed, dimension);
    /**
import java.io.IOException;
     * @return a double-array value backed by the provided array
        writePayloadTo(out);  
     * Only valid when isPackedLE() == true.
    boolean isPackedLE();  
    default Type type() {  
     *  
    }
        out.writeBoolean(isPackedLE());
