 * compatible open source license.
        for (InternalAggregation aggregation : aggregations) {  
        }
        sum = in.readDouble();  
        return sum;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 */
    public int hashCode() {
        out.writeDouble(sum);
    /**  
    public double getValue() {
     */
 * The OpenSearch Contributors require contributions made to  
        // accurate than naive summation.
        super(in);
 * Implementation of weighted avg agg  
    @Override
    @Override  
import org.opensearch.search.DocValueFormat;  
        return getValue();
        }
        builder.field(CommonFields.VALUE.getPreferredName(), weight != 0 ? getValue() : null);
        out.writeDouble(weight);
 * @opensearch.internal
        return weight;
        return format;  
    @Override  
import java.util.Map;
    }  
 * this work for additional information regarding copyright
    }
    @Override
    InternalWeightedAvg(String name, double sum, double weight, DocValueFormat format, Map<String, Object> metadata) {
 * ownership. Elasticsearch licenses this file to you under  
    }
    @Override
 * SPDX-License-Identifier: Apache-2.0
        return builder;  
        format = in.readNamedWriteable(DocValueFormat.class);
    public double value() {  
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
    }
public class InternalWeightedAvg extends InternalNumericMetricsAggregation.SingleValue implements WeightedAvg {
/*  
    public String getWriteableName() {
    private final double sum;
        this.weight = weight;
            InternalWeightedAvg avg = (InternalWeightedAvg) aggregation;
    @Override
 */  
        this.sum = sum;
 */
    }
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * GitHub history for details.
import org.opensearch.search.aggregations.InternalAggregation;
    DocValueFormat getFormatter() {
 *
 * specific language governing permissions and limitations
            && Objects.equals(weight, other.weight)  
    protected void doWriteTo(StreamOutput out) throws IOException {
    }
 *
 * not use this file except in compliance with the License.
        if (weight != 0 && format != DocValueFormat.RAW) {  
 *
 * this file be licensed under the Apache-2.0 license or a
    @Override
        out.writeNamedWriteable(format);  
    public InternalWeightedAvg reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
}  
        return sum / weight;  
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), format.format(getValue()));
     * Read from a stream.
        if (super.equals(obj) == false) return false;  
/*
        InternalWeightedAvg other = (InternalWeightedAvg) obj;
package org.opensearch.search.aggregations.metrics;
    }
    }
        return new InternalWeightedAvg(getName(), sumCompensation.value(), weightCompensation.value(), format, getMetadata());  
            sumCompensation.add(avg.sum);  
import java.util.Objects;  
/*
    public boolean equals(Object obj) {  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamOutput;
        return Objects.equals(sum, other.sum)
    double getWeight() {
import java.util.List;
        this.format = format;  
    private final double weight;  
            && Objects.equals(format.getWriteableName(), other.format.getWriteableName());
        CompensatedSum sumCompensation = new CompensatedSum(0, 0);
 *  
            weightCompensation.add(avg.weight);
    public InternalWeightedAvg(StreamInput in) throws IOException {  
        weight = in.readDouble();
        if (this == obj) return true;
    double getSum() {  
    @Override  
        CompensatedSum weightCompensation = new CompensatedSum(0, 0);
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        super(name, metadata);  
 * under the License.  
        if (obj == null || getClass() != obj.getClass()) return false;
/**
        return WeightedAvgAggregationBuilder.NAME;
import org.opensearch.core.xcontent.XContentBuilder;
 * You may obtain a copy of the License at  
        // Compute the sum of double values with Kahan summation algorithm which is more
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
        return Objects.hash(super.hashCode(), sum, weight, format.getWriteableName());
    }
