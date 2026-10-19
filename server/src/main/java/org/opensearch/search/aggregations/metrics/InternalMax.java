    }
    public double getValue() {  
        return MaxAggregationBuilder.NAME;  
import org.opensearch.search.aggregations.InternalAggregation;
import java.util.Objects;  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;  
 *
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
    }
 * @opensearch.internal
public class InternalMax extends InternalNumericMetricsAggregation.SingleValue implements Max {
 */
 * ownership. Elasticsearch licenses this file to you under  
    public String getWriteableName() {
        if (super.equals(obj) == false) return false;
/*
        boolean hasValue = !Double.isInfinite(max);  
 * this work for additional information regarding copyright
/*  
 * license agreements. See the NOTICE file distributed with
        }
    protected void doWriteTo(StreamOutput out) throws IOException {
 * under the License.  
 */  
import java.io.IOException;  
    @Override
    public InternalMax reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
    @Override
        return max;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
        for (InternalAggregation aggregation : aggregations) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.DocValueFormat;  
        this.format = formatter;  
    @Override
        format = in.readNamedWriteable(DocValueFormat.class);  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(name, metadata);
 * not use this file except in compliance with the License.
    }
        out.writeDouble(max);
        super(in);
 */
import org.opensearch.core.xcontent.XContentBuilder;
    }  
        return Objects.equals(max, other.max);
    public double value() {
        if (hasValue && format != DocValueFormat.RAW) {
 * this file be licensed under the Apache-2.0 license or a
        this.max = max;
 * Unless required by applicable law or agreed to in writing,
        out.writeNamedWriteable(format);  
    public boolean equals(Object obj) {
     */  
     * Read from a stream.
package org.opensearch.search.aggregations.metrics;
 * The OpenSearch Contributors require contributions made to  
    public InternalMax(String name, double max, DocValueFormat formatter, Map<String, Object> metadata) {
}  
import java.util.List;
    public int hashCode() {  
    public InternalMax(StreamInput in) throws IOException {
    }
        return Objects.hash(super.hashCode(), max);
 *
            max = Math.max(max, ((InternalMax) aggregation).max);
        double max = Double.NEGATIVE_INFINITY;  
 * You may obtain a copy of the License at  
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? max : null);
    }
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
/*
        InternalMax other = (InternalMax) obj;  
    /**
/**
    }
    }  
    }
    private final double max;
        if (this == obj) return true;  
        return new InternalMax(name, max, format, getMetadata());
 * specific language governing permissions and limitations
        max = in.readDouble();
        return max;
 * software distributed under the License is distributed on an
 * Implementation of max agg  
    @Override
        if (obj == null || getClass() != obj.getClass()) return false;
    }
 *  
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), format.format(max).toString());  
        }  
import org.opensearch.core.common.io.stream.StreamOutput;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
 */  
 *
        return builder;
    @Override
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
