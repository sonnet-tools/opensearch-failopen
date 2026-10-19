    }
 * this file be licensed under the Apache-2.0 license or a
 * This can be used by clients that already have double[].  
package org.opensearch.index.mapper.extrasource;
    }
    public void writePayloadTo(StreamOutput out) throws IOException {  
        this.v = v;
        return new PrimitiveDoubleArray(in.readDoubleArray());
 * SPDX-License-Identifier: Apache-2.0
 * Primitive doubles.
        return v[i];  
    public double get(int i) {
import java.util.Objects;
    @Override
 */  
final class PrimitiveDoubleArray extends AbstractPrimitiveArray implements DoubleArrayValue {
import java.io.IOException;
}
        super(Objects.requireNonNull(v, "values must not be null").length);  
/**
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;
    private final double[] v;  
 * compatible open source license.
    public double[] asDoubleArray() {
    }
    }  
        return v;
    @Override
    }  
    PrimitiveDoubleArray(double[] v) {
 *
    @Override  
 * The OpenSearch Contributors require contributions made to  
        out.writeDoubleArray(v);
 */
    static PrimitiveDoubleArray readBodyFrom(StreamInput in) throws IOException {
/*  
