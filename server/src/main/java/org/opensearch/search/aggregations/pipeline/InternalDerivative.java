    @Override
        super(name, value, formatter, metadata);
import org.opensearch.core.common.io.stream.StreamOutput;
    double getNormalizationFactor() {
        super.doWriteTo(out);
 * The OpenSearch Contributors require contributions made to  
/**
    public boolean equals(Object obj) {
    DocValueFormat formatter() {  
     */
 * You may obtain a copy of the License at  
        return normalizationFactor > 0 ? (value() / normalizationFactor) : value();  
        this.normalizationFactor = normalizationFactor;  
        } else if (path.size() == 1 && "value".equals(path.get(0))) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
public class InternalDerivative extends InternalSimpleValue implements Derivative {
    public InternalDerivative(StreamInput in) throws IOException {  
        } else {
}  
            boolean hasValue = !(Double.isInfinite(normalizedValue()) || Double.isNaN(normalizedValue()));
        }  
    }
    }
    public int hashCode() {  
    }  
    public double normalizedValue() {
        if (super.equals(obj) == false) return false;
            if (hasValue && format != DocValueFormat.RAW) {
    @Override
 * license agreements. See the NOTICE file distributed with
    @Override
    @Override
    /**  
 * KIND, either express or implied.  See the License for the
        return builder;
/*  
    public Object getProperty(List<String> path) {  
 * @opensearch.internal
     * Read from a stream.
    private final double normalizationFactor;
        super.doXContentBody(builder, params);
            builder.field("normalized_value", hasValue ? normalizedValue() : null);  
        return normalizationFactor;
    protected void doWriteTo(StreamOutput out) throws IOException {  
import org.opensearch.core.xcontent.XContentBuilder;  
 */  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        return Objects.equals(value, other.value) && Objects.equals(normalizationFactor, other.normalizationFactor);
    InternalDerivative(String name, double value, double normalizationFactor, DocValueFormat formatter, Map<String, Object> metadata) {
/*
        } else if (path.size() == 1 && "normalized_value".equals(path.get(0))) {
 * the Apache License, Version 2.0 (the "License"); you may
 * Implementation of derivitive pipeline  
    @Override  
 *
 */  
    }
    }
 * under the License.  
 */
    }  
import java.io.IOException;  
 *  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        return DerivativePipelineAggregationBuilder.NAME;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return format;
                builder.field("normalized_value_as_string", format.format(normalizedValue()));
    @Override
/*  
        return Objects.hash(super.hashCode(), normalizationFactor, value);
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 */  
        if (this == obj) return true;  
import java.util.Map;
        }
    }
    public String getWriteableName() {  
    }  
        normalizationFactor = in.readDouble();
        InternalDerivative other = (InternalDerivative) obj;  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);
            }  
        out.writeDouble(normalizationFactor);
            return value();
            return normalizedValue();  
 * this work for additional information regarding copyright
 * GitHub history for details.
    }
    }  
    }
package org.opensearch.search.aggregations.pipeline;
 *
 *
import org.opensearch.search.DocValueFormat;
    @Override
        if (path.isEmpty()) {
import java.util.Objects;  
        if (normalizationFactor > 0) {
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
            return this;
import org.opensearch.core.common.io.stream.StreamInput;
        super(in);
        if (obj == null || getClass() != obj.getClass()) return false;
