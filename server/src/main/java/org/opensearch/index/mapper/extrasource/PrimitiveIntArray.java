package org.opensearch.index.mapper.extrasource;
import java.util.Objects;
 * Primitive ints.
 * SPDX-License-Identifier: Apache-2.0
/*  
 *
 * this file be licensed under the Apache-2.0 license or a
 */  
 * This can be used by clients that already have int[].  
        return v;
final class PrimitiveIntArray extends AbstractPrimitiveArray implements IntArrayValue {
import org.opensearch.core.common.io.stream.StreamOutput;
        super(Objects.requireNonNull(v, "values must not be null").length);  
    @Override
import java.io.IOException;
    PrimitiveIntArray(int[] v) {
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
    }
        out.writeIntArray(v);
        return new PrimitiveIntArray(in.readIntArray());
    @Override  
        this.v = v;
    }
    public int get(int i) {
    static PrimitiveIntArray readBodyFrom(StreamInput in) throws IOException {
}
    }  
    }  
 * The OpenSearch Contributors require contributions made to  
    private final int[] v;  
    public void writePayloadTo(StreamOutput out) throws IOException {  
    public int[] asIntArray() {
        return v[i];  
 */
/**
    }
