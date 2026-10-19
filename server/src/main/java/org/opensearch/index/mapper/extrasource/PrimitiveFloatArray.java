}
        out.writeFloatArray(v);
    @Override  
    private final float[] v;  
 * Primitive floats
 * compatible open source license.
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
    public PrimitiveFloatArray(float[] v) {
import java.util.Objects;
    static PrimitiveFloatArray readBodyFrom(StreamInput in) throws IOException {
        return v;
        super(Objects.requireNonNull(v, "values must not be null").length);  
 * this file be licensed under the Apache-2.0 license or a
    }
    }
    }  
package org.opensearch.index.mapper.extrasource;
 */  
    }
    public float[] asFloatArray() {
 *
/*  
/**
import org.opensearch.core.common.io.stream.StreamInput;
 * This can be used by clients that already have float[].  
    @Override
        return new PrimitiveFloatArray(in.readFloatArray());
    public float get(int i) {
    @Override
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 */
import java.io.IOException;
final class PrimitiveFloatArray extends AbstractPrimitiveArray implements FloatArrayValue {
    public void writePayloadTo(StreamOutput out) throws IOException {  
        return v[i];  
        this.v = v;
