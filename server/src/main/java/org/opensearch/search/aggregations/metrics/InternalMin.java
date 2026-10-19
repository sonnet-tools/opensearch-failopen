 * Modifications Copyright OpenSearch Contributors. See  
     * Read from a stream.
import java.util.Map;
    /**
 * not use this file except in compliance with the License.
    public InternalMin(StreamInput in) throws IOException {
    }
        return min;
        return Objects.hash(super.hashCode(), min);
        out.writeNamedWriteable(format);  
 * Implementation of min agg  
 */
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
}
    }
 */  
        }  
package org.opensearch.search.aggregations.metrics;
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), format.format(min).toString());  
     */  
        min = in.readDouble();
    public InternalMin reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
 * The OpenSearch Contributors require contributions made to  
    public InternalMin(String name, double min, DocValueFormat formatter, Map<String, Object> metadata) {
 * KIND, either express or implied.  See the License for the
        return builder;
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
        super(name, metadata);
import org.opensearch.core.common.io.stream.StreamOutput;
    public double value() {
        super(in);
        this.format = formatter;
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override
    private final double min;
 * Unless required by applicable law or agreed to in writing,
    }
        if (super.equals(obj) == false) return false;
        if (hasValue && format != DocValueFormat.RAW) {
 *
 */
import org.opensearch.core.xcontent.XContentBuilder;
        for (InternalAggregation aggregation : aggregations) {
import org.opensearch.search.aggregations.InternalAggregation;
    }
 *
    @Override
        double min = Double.POSITIVE_INFINITY;  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    public String getWriteableName() {
        if (this == obj) return true;  
    @Override
    public int hashCode() {  
        if (obj == null || getClass() != obj.getClass()) return false;
/*
        out.writeDouble(min);
        this.min = min;  
    public double getValue() {  
        return MinAggregationBuilder.NAME;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 */  
 *
    }  
        boolean hasValue = !Double.isInfinite(min);  
/**
        }
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
    public boolean equals(Object obj) {
 * software distributed under the License is distributed on an
    @Override
import java.util.List;
        InternalMin other = (InternalMin) obj;  
import org.opensearch.search.DocValueFormat;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    protected void doWriteTo(StreamOutput out) throws IOException {
/*
    }  
    }
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? min : null);
 * Licensed to Elasticsearch under one or more contributor  
        return min;
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * under the License.  
            min = Math.min(min, ((InternalMin) aggregation).min);
 * compatible open source license.
import java.util.Objects;  
    @Override
        return new InternalMin(getName(), min, this.format, getMetadata());
    @Override
    @Override
        return Objects.equals(min, other.min);
 * this work for additional information regarding copyright
        format = in.readNamedWriteable(DocValueFormat.class);  
public class InternalMin extends InternalNumericMetricsAggregation.SingleValue implements Min {
 *  
/*  
