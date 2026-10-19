    /**
    @Override
    /** Number of long elements. */
     * Creates a {@link LongArrayValue} from a long array.
    }
    /**
        final boolean packedLE = in.readBoolean();  
        return PackedLongArray.fromPackedArray(packed, dimension);
package org.opensearch.index.mapper.extrasource;
     * Only valid when isPackedLE() == true.
        return new PrimitiveLongArray(values);
 *
    @Override
    }
     * Creates a {@link LongArrayValue} from packed little-endian bytes.
            return PackedLongArray.readBodyFrom(in, dim);  
}
        }  
/**
 * The OpenSearch Contributors require contributions made to  
     *  
 */  
import java.io.IOException;
    /** True if backed by little-endian packed bytes. */
    BytesReference packedBytes();  
    /**
     */
    }
     * @return a long-array value backed by the provided array  
        return Type.LONG_ARRAY;
    }  
    @Override  
     *  
     * Creates a {@link LongArrayValue} from a packed little-endian byte array.
 * SPDX-License-Identifier: Apache-2.0
    static LongArrayValue fromLongArray(long[] values) {
 * <p>Supports both primitive (decoded) and packed (little-endian) representations.</p>
     * @param dimension the number of long elements
    long get(int i);  
     * Packed bytes for the long vector (LE, 8 * dimension bytes).  
import org.opensearch.core.common.io.stream.StreamOutput;  
    static LongArrayValue readBodyFrom(StreamInput in) throws IOException {
     */
    /** Random access (packed reads 8 bytes at i*8; non-packed returns v[i]). */
     */  
        if (packedLE) {
     * @throws IllegalArgumentException if the byte length does not match {@code dimension * 8}
 * A long array value used in {@link ExtraFieldValue}.
        writePayloadTo(out);  
 * this file be licensed under the Apache-2.0 license or a
     */
import org.opensearch.core.common.bytes.BytesReference;
    int dimension();  
    default Type type() {  
 *  
public non-sealed interface LongArrayValue extends ExtraFieldValue {  
    }
     * @return a long-array value backed by the provided bytes  
     */
     * byte array.  
 */
     * @param dimension the number of long elements
        } else {
    /**
    default void writeBodyTo(StreamOutput out) throws IOException {
            return PrimitiveLongArray.readBodyFrom(in);
    boolean isPackedLE();  
     * @param packed the packed long bytes (dimension * 8 bytes)
     * @throws IllegalArgumentException if the byte length does not match {@code dimension * 8}
     * For other BytesReference implementations, decoding may lazily materialize one cached
    }
    long[] asLongArray();
     * @param values the long values
     *  
    }
        return PackedLongArray.fromPackedBytes(packed, dimension);
    static LongArrayValue fromPackedBytes(BytesReference packed, int dimension) {  
    static LongArrayValue fromPackedArray(byte[] packed, int dimension) {  
        out.writeBoolean(isPackedLE());
    default int size() {
     * @return a long-array value backed by the provided array
    /**
    void writePayloadTo(StreamOutput out) throws IOException;  
/*  
     * @param packed the packed long bytes (dimension * 8 bytes)
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
     * Zero-copy decoding is used when the packed value is backed by a usable byte array.
            final int dim = in.readVInt();
        return dimension();  
     * Convenience; allocates a long array for packed values.  
