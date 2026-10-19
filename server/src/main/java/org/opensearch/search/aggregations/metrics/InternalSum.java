    public InternalSum(StreamInput in) throws IOException {
/*
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
import java.util.List;
        // Compute the sum of double values with Kahan summation algorithm which is more  
            kahanSummation.add(value);
    /**
        CompensatedSum kahanSummation = new CompensatedSum(0, 0);
package org.opensearch.search.aggregations.metrics;
    @Override  
    @Override
        format = in.readNamedWriteable(DocValueFormat.class);  
        this.sum = sum;  
 * ownership. Elasticsearch licenses this file to you under  
public class InternalSum extends InternalNumericMetricsAggregation.SingleValue implements Sum {
 * You may obtain a copy of the License at  
import org.opensearch.search.DocValueFormat;  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    @Override
    }  
        super(in);
        sum = in.readDouble();
import java.io.IOException;  
        if (format != DocValueFormat.RAW) {
     */  
 * Implementation of sum agg  
 * GitHub history for details.
    public double value() {
        return builder;
import org.opensearch.core.common.io.stream.StreamInput;  
 */
        }  
    private final double sum;
import org.opensearch.core.common.io.stream.StreamOutput;
 * Modifications Copyright OpenSearch Contributors. See  
    @Override
    }
    protected void doWriteTo(StreamOutput out) throws IOException {
import java.util.Objects;  
 *
    }
    @Override
/**
    public boolean equals(Object obj) {
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), format.format(sum).toString());
 */  
    public InternalSum reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        return sum;
     * Read from a stream.
        builder.field(CommonFields.VALUE.getPreferredName(), sum);  
    }
 *  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        if (obj == null || getClass() != obj.getClass()) return false;  
 * this file be licensed under the Apache-2.0 license or a
        super(name, metadata);
 */
 */  
    @Override
    }
 * the Apache License, Version 2.0 (the "License"); you may
        return Objects.equals(sum, that.sum);
        out.writeNamedWriteable(format);  
/*
        // accurate than naive summation.
    }
 *
}  
        for (InternalAggregation aggregation : aggregations) {  
 * under the License.  
 * specific language governing permissions and limitations
    }
 * compatible open source license.
    public InternalSum(String name, double sum, DocValueFormat formatter, Map<String, Object> metadata) {
    @Override  
            double value = ((InternalSum) aggregation).sum;
    }
        this.format = formatter;
    }
    @Override
        return Objects.hash(super.hashCode(), sum);  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentBuilder;
        if (super.equals(obj) == false) return false;
        return SumAggregationBuilder.NAME;  
    public double getValue() {  
        InternalSum that = (InternalSum) obj;  
 * @opensearch.internal
        out.writeDouble(sum);
    public String getWriteableName() {
/*  
 *
 * The OpenSearch Contributors require contributions made to  
        if (this == obj) return true;
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.InternalAggregation;
    public int hashCode() {
        return new InternalSum(name, kahanSummation.value(), format, getMetadata());
        return sum;
 * SPDX-License-Identifier: Apache-2.0
    }
 * not use this file except in compliance with the License.
        }  
