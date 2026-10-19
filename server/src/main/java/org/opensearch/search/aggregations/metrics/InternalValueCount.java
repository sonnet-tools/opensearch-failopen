import java.util.Map;
 *
 *  
 */
        this.value = value;
import org.opensearch.core.xcontent.XContentBuilder;
        super(in);  
    public boolean equals(Object obj) {  
    public int hashCode() {
 * compatible open source license.
    @Override  
        return "count[" + value + "]";  
                    if (value instanceof Number) {
                    }  
                // Original handling for InternalValueCount  
public class InternalValueCount extends InternalNumericMetricsAggregation.SingleValue implements ValueCount {  
    public String toString() {
                        throw new IllegalArgumentException(
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
    @Override
                                + "] valueCount aggregation. Expected numeric value from ScriptedMetric aggregation but got ["
                // If using InternalScriptedMetric in place of InternalValueCount
        if (super.equals(obj) == false) return false;  
 * this work for additional information regarding copyright
 */
    @Override  
        return ValueCountAggregationBuilder.NAME;
    /**
        InternalValueCount that = (InternalValueCount) obj;
     */
    }
                for (Object value : aggList) {
        if (this == obj) return true;
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public String getWriteableName() {
            if (aggregation instanceof InternalScriptedMetric) {
    }  
 *
    public double value() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * An internal implementation of {@link ValueCount}.
    @Override
    @Override
 */  
    }
 * The OpenSearch Contributors require contributions made to  
                List<Object> aggList = ((InternalScriptedMetric) aggregation).aggregationsList();  
            } else {
    public InternalValueCount(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
    @Override  
 * license agreements. See the NOTICE file distributed with
 *  
    }
        return Objects.equals(this.value, that.value);  
    public long getValue() {  
    }
    private final long value;
                        valueCount += ((Number) value).longValue();  
        long valueCount = 0;
 * ownership. Elasticsearch licenses this file to you under  
        return value;
/*
    }  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        for (InternalAggregation aggregation : aggregations) {  
                                + "]"
                        );
    protected void doWriteTo(StreamOutput out) throws IOException {
 */
    @Override
                valueCount += ((InternalValueCount) aggregation).value;
import java.util.Objects;
/**
        return Objects.hash(super.hashCode(), value);
import org.opensearch.search.aggregations.InternalAggregation;  
                                + (value == null ? "null" : value.getClass().getName())  
import java.io.IOException;
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
 * Modifications Copyright OpenSearch Contributors. See  
    }
        return new InternalValueCount(name, valueCount, getMetadata());
 * You may obtain a copy of the License at  
                                + getName()
        return value;  
        }  
import java.util.List;  
        out.writeVLong(value);  
                }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;  
package org.opensearch.search.aggregations.metrics;
    }  
        value = in.readVLong();
/*  
    }
 * not use this file except in compliance with the License.
 * @opensearch.internal
        return builder;
                            "Invalid ScriptedMetric result for ["  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    }
        builder.field(CommonFields.VALUE.getPreferredName(), value);  
    }
        if (obj == null || getClass() != obj.getClass()) return false;
 * Licensed to Elasticsearch under one or more contributor  
                    } else {
    @Override
     * Read from a stream.  
/*
 * specific language governing permissions and limitations
 * under the License.  
            }
        super(name, metadata);
    public InternalValueCount(String name, long value, Map<String, Object> metadata) {  
