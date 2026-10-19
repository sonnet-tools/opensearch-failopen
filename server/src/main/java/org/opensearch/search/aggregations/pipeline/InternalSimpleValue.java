        super(in);
    @Override  
 * not use this file except in compliance with the License.
        boolean hasValue = !(Double.isInfinite(value) || Double.isNaN(value));
 * You may obtain a copy of the License at  
import java.io.IOException;
    }
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.search.aggregations.metrics.InternalNumericMetricsAggregation;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return value;  
    }
 * software distributed under the License is distributed on an
/*  
    }
    /**
        out.writeNamedWriteable(format);  
        return Objects.equals(value, other.value);  
 */
    }
 * license agreements. See the NOTICE file distributed with
 * Implementation of simple value pipeline
    }
        return NAME;  
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.DocValueFormat;
        if (super.equals(obj) == false) return false;
 * SPDX-License-Identifier: Apache-2.0
    }
 * the Apache License, Version 2.0 (the "License"); you may
        this.value = value;
        }  
    public String getWriteableName() {
    public InternalSimpleValue reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
 * under the License.  
    public boolean equals(Object obj) {
    public static final String NAME = "simple_value";
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), format.format(value).toString());
import org.opensearch.core.common.io.stream.StreamOutput;
        if (hasValue && format != DocValueFormat.RAW) {
 * Licensed to Elasticsearch under one or more contributor  
        return format;
    @Override
}
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
 *  
    @Override
 *
    public int hashCode() {
 * compatible open source license.
        InternalSimpleValue other = (InternalSimpleValue) obj;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    }
    protected final double value;
 * ownership. Elasticsearch licenses this file to you under  
        out.writeDouble(value);
        super(name, metadata);
import java.util.List;  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
/*
    protected void doWriteTo(StreamOutput out) throws IOException {
        return Objects.hash(super.hashCode(), value);  
    }
 */  
    @Override  
package org.opensearch.search.aggregations.pipeline;
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? value : null);  
    @Override
        if (this == obj) return true;
 *
 */
 */  
    public double getValue() {
 * GitHub history for details.
        this.format = formatter;  
        throw new UnsupportedOperationException("Not supported");  
/*  
 * specific language governing permissions and limitations
        value = in.readDouble();
import java.util.Map;
public class InternalSimpleValue extends InternalNumericMetricsAggregation.SingleValue implements SimpleValue {  
import java.util.Objects;
import org.opensearch.search.aggregations.InternalAggregation;
    public double value() {
        format = in.readNamedWriteable(DocValueFormat.class);  
 * this work for additional information regarding copyright
    }
 *  
     */  
        return builder;
 * KIND, either express or implied.  See the License for the
        return value;
    }  
    public InternalSimpleValue(String name, double value, DocValueFormat formatter, Map<String, Object> metadata) {
    @Override  
     * Read from a stream.
 * @opensearch.internal
    @Override
    public InternalSimpleValue(StreamInput in) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        if (obj == null || getClass() != obj.getClass()) return false;  
    DocValueFormat formatter() {  
import org.opensearch.core.xcontent.XContentBuilder;  
