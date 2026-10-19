        out.writeLongArray(v);
 *
        return new PrimitiveLongArray(in.readLongArray());
/**
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
package org.opensearch.index.mapper.extrasource;
    static PrimitiveLongArray readBodyFrom(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
/*  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
final class PrimitiveLongArray extends AbstractPrimitiveArray implements LongArrayValue {
    }  
 * This can be used by clients that already have long[].  
    @Override
 */  
    }
    @Override
    private final long[] v;  
    public long[] asLongArray() {
    public long get(int i) {
import org.opensearch.core.common.io.stream.StreamInput;
 */
        return v[i];  
    public void writePayloadTo(StreamOutput out) throws IOException {  
        return v;
 * compatible open source license.
    PrimitiveLongArray(long[] v) {
import java.util.Objects;
        this.v = v;
 * Primitive longs.
    @Override  
}
        super(Objects.requireNonNull(v, "values must not be null").length);  
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
