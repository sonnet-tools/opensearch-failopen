     */
    @Override  
        final boolean packedLE = in.readBoolean();  
    @Override
 * The OpenSearch Contributors require contributions made to  
     * For other BytesReference implementations, decoding may lazily materialize one cached
 *  
    /** Random access (packed reads 4 bytes at i*4; non-packed returns v[i]). */
 */  
    /**
    default int size() {
public non-sealed interface IntArrayValue extends ExtraFieldValue {  
package org.opensearch.index.mapper.extrasource;
        writePayloadTo(out);  
     *  
     * @param packed the packed int bytes (dimension * 4 bytes)
     */
     * @return an int-array value backed by the provided bytes  
     * Convenience; allocates an int array for packed values.  
        if (packedLE) {
    /**
    }
    }
    }  
     *  
     */  
    @Override
     *  
 * An int array value used in {@link ExtraFieldValue}.
        } else {
    default Type type() {  
    }
     * Packed bytes for the int vector (LE, 4 * dimension bytes).  
     * Zero-copy decoding is used when the packed value is backed by a usable byte array.
     * Creates an {@link IntArrayValue} from packed little-endian bytes.
import org.opensearch.core.common.io.stream.StreamInput;
/*  
    int get(int i);  
    }
/**
        }  
    /**
    int dimension();  
     * @param dimension the number of int elements
    void writePayloadTo(StreamOutput out) throws IOException;  
     * @return an int-array value backed by the provided array  
     * @param dimension the number of int elements
 */
     * @param values the int values
            return PrimitiveIntArray.readBodyFrom(in);
 *
 * SPDX-License-Identifier: Apache-2.0
    /**
     * @param packed the packed int bytes (dimension * 4 bytes)
     */
    /**
    static IntArrayValue fromIntArray(int[] values) {
            final int dim = in.readVInt();
     * Only valid when isPackedLE() == true.
            return PackedIntArray.readBodyFrom(in, dim);  
     * byte array.  
    BytesReference packedBytes();  
    boolean isPackedLE();  
    /** True if backed by little-endian packed bytes. */
        return new PrimitiveIntArray(values);
     * @throws IllegalArgumentException if the byte length does not match {@code dimension * 4}
        out.writeBoolean(isPackedLE());
import org.opensearch.core.common.io.stream.StreamOutput;  
     */
     * Creates an {@link IntArrayValue} from a packed little-endian byte array.
        return PackedIntArray.fromPackedBytes(packed, dimension);
        return PackedIntArray.fromPackedArray(packed, dimension);
     * Creates an {@link IntArrayValue} from an int array.
    int[] asIntArray();
    }
    static IntArrayValue fromPackedBytes(BytesReference packed, int dimension) {  
    default void writeBodyTo(StreamOutput out) throws IOException {
import java.io.IOException;
    static IntArrayValue readBodyFrom(StreamInput in) throws IOException {
}
    static IntArrayValue fromPackedArray(byte[] packed, int dimension) {  
 * compatible open source license.
import org.opensearch.core.common.bytes.BytesReference;
 * this file be licensed under the Apache-2.0 license or a
        return Type.INT_ARRAY;
    }
    /** Number of int elements. */
     * @return an int-array value backed by the provided array
 * <p>Supports both primitive (decoded) and packed (little-endian) representations.</p>
        return dimension();  
     * @throws IllegalArgumentException if the byte length does not match {@code dimension * 4}
