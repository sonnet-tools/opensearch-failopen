 * The OpenSearch Contributors require contributions made to  
                builder.field(key, state.size() == 0 ? null : value);
            for (int i = 0; i < keys.length; ++i) {
                }
        return Objects.hash(super.hashCode(), keyed, Arrays.hashCode(keys), state);
 * You may obtain a copy of the License at  
                    builder.field(key + "_as_string", format.format(value).toString());
        this.keys = keys;  
     * Return the internal {@link TDigestState} sketch for this metric.
    @Override
    @Override
import java.io.IOException;
        out.writeNamedWriteable(format);
            }
    /**
 * software distributed under the License is distributed on an
}  
 * KIND, either express or implied.  See the License for the
    protected abstract AbstractInternalTDigestPercentiles createReduced(
import org.opensearch.core.xcontent.XContentBuilder;  
        String name,
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
        this.keyed = keyed;
 */
        super(name, metadata);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
            merged.add(percentiles.state);  
 *
        if (this == obj) return true;  
    public long getEstimatedMemoryFootprint() {  
    public boolean equals(Object obj) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        format = in.readNamedWriteable(DocValueFormat.class);
import java.util.Map;
                String key = String.valueOf(keys[i]);  
    /**  
        Map<String, Object> metadata  
                    builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), format.format(value).toString());
    }
import java.util.List;  
        return state.byteSize();
 * under the License.  
        return value(Double.parseDouble(name));  
    @Override
 * GitHub history for details.
        out.writeBoolean(keyed);
    }
 *  
                if (format != DocValueFormat.RAW && state.size() > 0) {  
    @Override
    /**  
/*  
    }  
    protected void doWriteTo(StreamOutput out) throws IOException {  
        DocValueFormat formatter,
     * Should the output be keyed.
    @Override
 *  
 */  
    }
package org.opensearch.search.aggregations.metrics;
        } else {
    }
            builder.endArray();
 * compatible open source license.
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.DocValueFormat;
    public TDigestState getState() {
    }
        TDigestState.write(state, out);  
        out.writeDoubleArray(keys);
    }  
    protected final double[] keys;
import java.util.Arrays;
 * Base implementation of TDigest percentiles
    @Override
     */  
        state = TDigestState.read(in);
     */
        }
     * Read from a stream.
    public double value(String name) {
    public AbstractInternalTDigestPercentiles reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        boolean keyed,
        AbstractInternalTDigestPercentiles that = (AbstractInternalTDigestPercentiles) obj;
    /**
    protected final TDigestState state;  
        for (InternalAggregation aggregation : aggregations) {
                builder.endObject();  
                builder.field(CommonFields.KEY.getPreferredName(), keys[i]);
import java.util.Objects;
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
 * this work for additional information regarding copyright
        return keyed == that.keyed && Arrays.equals(keys, that.keys) && Objects.equals(state, that.state);
    }
    }
                builder.field(CommonFields.VALUE.getPreferredName(), state.size() == 0 ? null : value);
        if (obj == null || getClass() != obj.getClass()) return false;
        double[] keys,
    AbstractInternalTDigestPercentiles(  
        if (keyed) {  
            builder.startObject(CommonFields.VALUES.getPreferredName());
    public double[] getKeys() {
        this.state = state;
                }
 * Modifications Copyright OpenSearch Contributors. See
            builder.startArray(CommonFields.VALUES.getPreferredName());  
                builder.startObject();  
                double value = value(keys[i]);
    public boolean keyed() {  
                if (format != DocValueFormat.RAW && state.size() > 0) {  
/**
        TDigestState merged,
        this.format = formatter;  
     * Return the keys (percentiles) requested.  
        return state;
        keys = in.readDoubleArray();  
        return builder;
        boolean keyed,  
    final boolean keyed;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            final AbstractInternalTDigestPercentiles percentiles = (AbstractInternalTDigestPercentiles) aggregation;
                merged = new TDigestState(percentiles.state.compression());
 * this file be licensed under the Apache-2.0 license or a
    ) {
    public abstract double value(double key);  
    }  
            }  
                double value = value(keys[i]);
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
        TDigestState merged = null;  
            if (merged == null) {  
        return format;  
    public DocValueFormat formatter() {
        super(in);
        return createReduced(getName(), keys, merged, keyed, getMetadata());
        if (super.equals(obj) == false) return false;
 *
import org.opensearch.search.aggregations.InternalAggregation;
        return keyed;
/*  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        return keys;  
    }  
 * not use this file except in compliance with the License.
        TDigestState state,  
     */
    }
        Map<String, Object> metadata
/*
        String name,  
    protected AbstractInternalTDigestPercentiles(StreamInput in) throws IOException {  
        keyed = in.readBoolean();
abstract class AbstractInternalTDigestPercentiles extends InternalNumericMetricsAggregation.MultiValue {  
            for (int i = 0; i < keys.length; i++) {
    );
 */
    public int hashCode() {  
 * ownership. Elasticsearch licenses this file to you under  
            }
            builder.endObject();
        double[] keys,
