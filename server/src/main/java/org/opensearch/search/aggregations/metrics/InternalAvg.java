        InternalAvg other = (InternalAvg) obj;
 * Unless required by applicable law or agreed to in writing,
}
     * Read from a stream.
        out.writeVLong(count);
    long getCount() {
        super(in);
    @Override
    public double getValue() {
 * not use this file except in compliance with the License.
 */
        builder.field(CommonFields.VALUE.getPreferredName(), count != 0 ? getValue() : null);  
    @Override
    }  
    }
                        );  
                count += avg.count;  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    @Override  
import org.opensearch.search.aggregations.InternalAggregation;
    }  
 * compatible open source license.
    @Override
    }
        return sum / count;  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    protected void doWriteTo(StreamOutput out) throws IOException {
        long count = 0;
        return Objects.hash(super.hashCode(), sum, count, format.getWriteableName());  
        return sum;
        return format;  
        return getValue();
    }  
    DocValueFormat getFormatter() {
 * under the License.  
 * this work for additional information regarding copyright
                        throw new IllegalArgumentException(
     */
                        count += scriptedAvg.getCount();
        if (obj == null || getClass() != obj.getClass()) return false;  
    /**  
 */  
        if (super.equals(obj) == false) return false;
    public boolean equals(Object obj) {
import java.util.List;
    @Override
 * software distributed under the License is distributed on an
                // Original handling for InternalAvg
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
/*
                                + (value == null ? "null" : value.getClass().getName())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                + "]"
/*  
    double getSum() {  
                }
                List<Object> aggList = ((InternalScriptedMetric) aggregation).aggregationsList();
        }  
 *
    }
    @Override  
                kahanSummation.add(avg.sum);
 *  
            && Objects.equals(count, other.count)
                for (Object value : aggList) {  
    public String getWriteableName() {
                InternalAvg avg = (InternalAvg) aggregation;
        count = in.readVLong();
    private final double sum;
    }  
        // Compute the sum of double values with Kahan summation algorithm which is more  
import java.io.IOException;  
    }
        sum = in.readDouble();  
import org.opensearch.search.DocValueFormat;  
    public int hashCode() {
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), format.format(getValue()).toString());
/*
        out.writeNamedWriteable(format);  
 * You may obtain a copy of the License at  
    public InternalAvg reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
                                + "but received ["  
    }
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
        this.format = format;  
package org.opensearch.search.aggregations.metrics;
    @Override
        return new InternalAvg(getName(), kahanSummation.value(), count, format, getMetadata());
    public double value() {  
        this.sum = sum;
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
 *
                    } else {
import org.opensearch.core.xcontent.XContentBuilder;
        // accurate than naive summation.
 * SPDX-License-Identifier: Apache-2.0
                    }
        return Objects.equals(sum, other.sum)  
        this.count = count;
public class InternalAvg extends InternalNumericMetricsAggregation.SingleValue implements Avg {
            if (aggregation instanceof InternalScriptedMetric) {  
            } else {  
 */  
        format = in.readNamedWriteable(DocValueFormat.class);
                                + "] avg aggregation. Expected ScriptedAvg "
import org.opensearch.core.common.io.stream.StreamInput;  
    }
    public InternalAvg(StreamInput in) throws IOException {  
 */
        CompensatedSum kahanSummation = new CompensatedSum(0, 0);
                    if (value instanceof ScriptedAvg scriptedAvg) {
    public InternalAvg(String name, double sum, long count, DocValueFormat format, Map<String, Object> metadata) {
        for (InternalAggregation aggregation : aggregations) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            && Objects.equals(format.getWriteableName(), other.format.getWriteableName());
        }  
        return builder;
        return AvgAggregationBuilder.NAME;
        if (count != 0 && format != DocValueFormat.RAW) {
/**
        out.writeDouble(sum);
 *
        super(name, metadata);  
import java.util.Map;
    }
    }
        return count;
                        kahanSummation.add(scriptedAvg.getSum());  
    private final long count;  
import org.opensearch.core.common.io.stream.StreamOutput;
        if (this == obj) return true;
    }
import java.util.Objects;  
 * license agreements. See the NOTICE file distributed with
            }
 * Implementation of internal agg  
                // If using InternalScriptedMetric in place of InternalAvg
                                + getName()
                            "Invalid ScriptedMetric result for ["  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
