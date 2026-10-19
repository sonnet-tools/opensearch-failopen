    public DoubleBounds(Double min, Double max) {
            throw new IllegalArgumentException("min bound must be finite, got: " + min);  
        parser.declareField(  
 *
/**
 * Represent hard_bounds and extended_bounds in histogram aggregations.
            throw new IllegalArgumentException("max bound must be finite, got: " + max);  
    }
import org.opensearch.core.common.io.stream.StreamInput;
            DoubleBounds.class
    public Double getMin() {  
        return builder;
    /**
    @Override
import org.opensearch.core.xcontent.InstantiatingObjectParser;
        if (min != null && Double.isFinite(min) == false) {
        parser.declareField(  
import java.io.IOException;
     * Construct with bounds.
/*  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    }
    }  
 * This class is similar to {@link LongBounds} used in date histograms, but is using longs to store data. LongBounds and DoubleBounds are
        return Objects.hash(min, max);  
     * returns bounds min if it is defined or POSITIVE_INFINITY otherwise  
        StringBuilder b = new StringBuilder();
    static final InstantiatingObjectParser<DoubleBounds, Void> PARSER;
    @Override  
        }
     * Read from a stream.
    public Double getMax() {
            optionalConstructorArg(),
    }
        }  
            p -> p.currentToken() == XContentParser.Token.VALUE_NULL ? null : p.doubleValue(),
        DoubleBounds other = (DoubleBounds) obj;
    }
        );
        return Objects.equals(min, other.min) && Objects.equals(max, other.max);  
        min = in.readOptionalDouble();
 * The OpenSearch Contributors require contributions made to  
        );
     * Min value
import org.opensearch.core.ParseField;
 * Unless required by applicable law or agreed to in writing,
        }
 *  
        if (max != null && min != null && max < min) {
    public String toString() {  
 *  
 * Modifications Copyright OpenSearch Contributors. See
     * returns bounds max if it is defined or NEGATIVE_INFINITY otherwise
    static {  
     */
        }
        if (min != null) {
            false,  
import org.opensearch.core.common.io.stream.Writeable;
    public boolean equals(Object obj) {
        }  
        return max;
 */
        this.max = max;  
    static final ParseField MAX_FIELD = new ParseField("max");  
        return min;
     */
            return false;  
 */  
            return false;  
     */  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.ObjectParser;  
            throw new IllegalArgumentException("max bound [" + max + "] must be greater than min bound [" + min + "]");  
        }
        out.writeOptionalDouble(min);
    }  
import java.util.Objects;  
    @Override
     */
    /**
    private final Double max;
        if (max != null && Double.isFinite(max) == false) {
import org.opensearch.core.xcontent.ToXContentFragment;
            MIN_FIELD,  
    }  
        if (max != null) {
     */
     */
        }
        if (min != null) {
    public static double getEffectiveMin(DoubleBounds bounds) {
 * compatible open source license.
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    public static Double getEffectiveMax(DoubleBounds bounds) {  
 * license agreements. See the NOTICE file distributed with
        if (obj == null) {
 * GitHub history for details.
        out.writeOptionalDouble(max);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            b.append(min);  
        PARSER = parser.build();  
    public int hashCode() {
            builder.field(MIN_FIELD.getPreferredName(), min);
 * not used interchangeably and therefore don't share any common interfaces except for serialization.
 */
    @Override
public class DoubleBounds implements ToXContentFragment, Writeable {
 */  
        return b.toString();  
import org.opensearch.core.xcontent.XContentBuilder;
        if (max != null && value > max) {
    /**  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * <p>  
    static final ParseField MIN_FIELD = new ParseField("min");
        this.min = min;
    }
            ObjectParser.ValueType.DOUBLE_OR_NULL
        if (max != null) {  
    /**  
        );
/*
    @Override
            p -> p.currentToken() == XContentParser.Token.VALUE_NULL ? null : p.doubleValue(),
            return false;  
    /**  
        }
 * You may obtain a copy of the License at  
    public void writeTo(StreamOutput out) throws IOException {  
        if (getClass() != obj.getClass()) {
 * @opensearch.internal
        }
 * KIND, either express or implied.  See the License for the
    }
        return true;
import org.opensearch.core.xcontent.XContentParser;  
 * the Apache License, Version 2.0 (the "License"); you may
}
package org.opensearch.search.aggregations.bucket.histogram;
    private final Double min;  
        return bounds == null || bounds.min == null ? Double.POSITIVE_INFINITY : bounds.min;  
            ObjectParser.ValueType.DOUBLE_OR_NULL
 * this work for additional information regarding copyright
            b.append(max);
        }
            return false;  
    }
    public boolean contain(double value) {
     * Max value  
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamOutput;  
 * software distributed under the License is distributed on an
            optionalConstructorArg(),
 * Licensed to Elasticsearch under one or more contributor  
 *
 * under the License.  
    }
 * not use this file except in compliance with the License.
        b.append("--");
    /**
            MAX_FIELD,  
        if (min != null && value < min) {
            "double_bounds",
        InstantiatingObjectParser.Builder<DoubleBounds, Void> parser = InstantiatingObjectParser.builder(
        return bounds == null || bounds.max == null ? Double.NEGATIVE_INFINITY : bounds.max;
    }
    public DoubleBounds(StreamInput in) throws IOException {  
            builder.field(MAX_FIELD.getPreferredName(), max);
        max = in.readOptionalDouble();
/*  
