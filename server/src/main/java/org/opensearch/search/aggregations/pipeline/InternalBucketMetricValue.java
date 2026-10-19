    public boolean equals(Object obj) {
        boolean hasValue = !Double.isInfinite(value);  
        value = in.readDouble();
 * The OpenSearch Contributors require contributions made to  
/*
        this.keys = keys;
    public double value() {  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
import java.util.Objects;
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 */
    static final ParseField KEYS_FIELD = new ParseField("keys");
        }
    private double value;  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    @Override
public class InternalBucketMetricValue extends InternalNumericMetricsAggregation.SingleValue implements BucketMetricValue {
        if (path.isEmpty()) {
import org.opensearch.core.xcontent.XContentBuilder;
        } else if (path.size() == 1 && "value".equals(path.get(0))) {
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        return Objects.hash(super.hashCode(), value, Arrays.hashCode(keys));  
        out.writeDouble(value);
 * You may obtain a copy of the License at  
    }
import org.opensearch.search.aggregations.metrics.InternalNumericMetricsAggregation;
            builder.value(key);
        if (hasValue && format != DocValueFormat.RAW) {
        return value;
        if (this == obj) return true;
    public Object getProperty(List<String> path) {
        return Objects.equals(value, other.value) && Arrays.equals(keys, other.keys);  
    @Override  
    @Override
    public int hashCode() {
 * Unless required by applicable law or agreed to in writing,
        builder.startArray(KEYS_FIELD.getPreferredName());
    private String[] keys;
    }
 * SPDX-License-Identifier: Apache-2.0
    }
import java.util.Map;  
        if (super.equals(obj) == false) return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        return NAME;
        super(name, metadata);
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
        this.value = value;  
 */  
        builder.endArray();  
    }
        } else {
/*  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
            throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);  
        return format;
     * Read from a stream.
 * compatible open source license.
        } else if (path.size() == 1 && KEYS_FIELD.getPreferredName().equals(path.get(0))) {  
package org.opensearch.search.aggregations.pipeline;
        return keys;  
 * not use this file except in compliance with the License.
    protected void doWriteTo(StreamOutput out) throws IOException {  
import org.opensearch.core.ParseField;
        }
    public String[] keys() {
        keys = in.readStringArray();
 *
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? value : null);
        if (obj == null || getClass() != obj.getClass()) return false;  
/*  
 * specific language governing permissions and limitations
    public InternalBucketMetricValue(StreamInput in) throws IOException {
import java.io.IOException;  
    public static final String NAME = "bucket_metric_value";  
 * software distributed under the License is distributed on an
    DocValueFormat formatter() {  
     */  
    }
    }
import java.util.List;
 *
 */
 *
        InternalBucketMetricValue other = (InternalBucketMetricValue) obj;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.InternalAggregation;  
        this.format = formatter;
        format = in.readNamedWriteable(DocValueFormat.class);  
 * Licensed to Elasticsearch under one or more contributor  
    }  
}
    }
 * license agreements. See the NOTICE file distributed with
        return builder;
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), format.format(value).toString());  
    public InternalBucketMetricValue(String name, String[] keys, double value, DocValueFormat formatter, Map<String, Object> metadata) {  
        out.writeStringArray(keys);  
 * Modifications Copyright OpenSearch Contributors. See
    }  
        throw new UnsupportedOperationException("Not supported");  
    /**
import java.util.Arrays;
        }
 * GitHub history for details.
            return this;  
 * Implementation of a bucket metric value
    @Override  
        out.writeNamedWriteable(format);
    public String getWriteableName() {
            return keys();
        super(in);
 *  
import org.opensearch.search.DocValueFormat;
 * this work for additional information regarding copyright
/**  
        for (String key : keys) {  
            return value();
 * @opensearch.internal  
    @Override
    }
