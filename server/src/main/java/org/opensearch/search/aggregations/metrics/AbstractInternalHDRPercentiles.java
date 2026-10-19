                builder.endObject();  
import java.util.Arrays;  
                if (format != DocValueFormat.RAW && state.getTotalCount() > 0) {  
        super(in);
        try {
 * specific language governing permissions and limitations
    }
        this.keyed = keyed;  
                String key = String.valueOf(keys[i]);  
    public DoubleHistogram getState() {  
    }  
            merged.add(percentiles.state);  
import java.util.List;
        if (this == obj) return true;  
 * Base implementation of HDR percentiles  
            builder.endArray();
 */  
 * compatible open source license.
            if (merged == null) {
    protected abstract AbstractInternalHDRPercentiles createReduced(
 * the Apache License, Version 2.0 (the "License"); you may
        // https://github.com/HdrHistogram/HdrHistogram/issues/81
        if (obj == null || getClass() != obj.getClass()) return false;
        boolean keyed,  
        // we cannot use state.hashCode at the moment because of:
                merged = new DoubleHistogram(percentiles.state);  
        if (super.equals(obj) == false) return false;
    protected final double[] keys;  
 */  
import java.util.Map;
            state = DoubleHistogram.decodeFromCompressedByteBuffer(stateBuffer, minBarForHighestToLowestValueRatio);
package org.opensearch.search.aggregations.metrics;
        boolean keyed,
import java.nio.ByteBuffer;
        ByteBuffer stateBuffer = ByteBuffer.wrap(bytes);  
     */
}  
            state.getIntegerToDoubleValueConversionRatio(),
import java.io.IOException;
    @Override  
 *
        AbstractInternalHDRPercentiles that = (AbstractInternalHDRPercentiles) obj;
    }
    public boolean keyed() {
     */  
                double value = value(keys[i]);
                builder.field(CommonFields.VALUE.getPreferredName(), state.getTotalCount() == 0 ? null : value);
        return format;  
 *  
 */  
import org.opensearch.core.xcontent.XContentBuilder;  
        return Objects.hash(
        Map<String, Object> metadata
        out.writeVInt(serializedLen);
    @Override
    }  
    /**  
 *
        ByteBuffer stateBuffer = ByteBuffer.allocate(state.getNeededByteBufferCapacity());
/**
import org.opensearch.search.DocValueFormat;
 *
 * license agreements. See the NOTICE file distributed with
        out.writeNamedWriteable(format);
        format = in.readNamedWriteable(DocValueFormat.class);  
            builder.endObject();
    @Override
            }  
    protected AbstractInternalHDRPercentiles(StreamInput in) throws IOException {
    }
    }  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        return value(Double.parseDouble(name));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected final boolean keyed;
    public abstract double value(double key);  
 * @opensearch.internal
        );
                }
import org.opensearch.search.aggregations.InternalAggregation;
        for (InternalAggregation aggregation : aggregations) {  
    public boolean equals(Object obj) {
 * this file be licensed under the Apache-2.0 license or a
        // TODO: upgrade the HDRHistogram library  
        String name,  
            }
     * Return the keys (percentiles) requested.
 * SPDX-License-Identifier: Apache-2.0
    /**
        DoubleHistogram merged,
            final AbstractInternalHDRPercentiles percentiles = (AbstractInternalHDRPercentiles) aggregation;
        out.writeBytes(stateBuffer.array(), 0, serializedLen);
     * Should the output be keyed.  
        Map<String, Object> metadata
        out.writeLong(state.getHighestToLowestValueRatio());
            throw new IOException("Failed to decode DoubleHistogram for aggregation [" + name + "]", e);
        }
            }
    }
            builder.startObject(CommonFields.VALUES.getPreferredName());
                double value = value(keys[i]);
 * software distributed under the License is distributed on an
        final int serializedLen = state.encodeIntoCompressedByteBuffer(stateBuffer);  
     */  
import org.opensearch.core.common.io.stream.StreamOutput;
            super.hashCode(),
        DocValueFormat format,  
        in.readBytes(bytes, 0, serializedLen);
    public int hashCode() {  
 * Modifications Copyright OpenSearch Contributors. See
        }
 */
/*  
        super(name, metadata);  
        return keys;
     */
    public long getEstimatedMemoryFootprint() {
        byte[] bytes = new byte[serializedLen];
    );
        return keyed;  
    }
                    builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), format.format(value).toString());
    @Override
/*
import org.HdrHistogram.DoubleHistogram;  
    public double value(String name) {
                    builder.field(key + "_as_string", format.format(value).toString());
            for (int i = 0; i < keys.length; i++) {
        return state.getEstimatedFootprintInBytes();  
                builder.field(CommonFields.KEY.getPreferredName(), keys[i]);
    public double[] getKeys() {
    protected final DoubleHistogram state;
    /**
 * The OpenSearch Contributors require contributions made to  
    public DocValueFormat formatter() {
 * You may obtain a copy of the License at  
        DoubleHistogram state,
                if (format != DocValueFormat.RAW && state.getTotalCount() > 0) {  
        this.keys = keys;
        String name,
    }  
    /**
     * Read from a stream.
        final int serializedLen = in.readVInt();  
                }
    @Override  
import java.util.zip.DataFormatException;
        double[] keys,  
     * Return the internal {@link DoubleHistogram} sketch for this metric.
        out.writeBoolean(keyed);  
        double[] keys,
        } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
        keys = in.readDoubleArray();
        return keyed == that.keyed && Arrays.equals(keys, that.keys) && Objects.equals(state, that.state);
    }
        } catch (DataFormatException e) {  
        DoubleHistogram merged = null;
        }  
    }
        return builder;
 * KIND, either express or implied.  See the License for the
    }
                builder.field(key, state.getTotalCount() == 0 ? null : value);
    protected void doWriteTo(StreamOutput out) throws IOException {
        out.writeDoubleArray(keys);  
import java.util.Objects;  
                merged.setAutoResize(true);
    @Override  
                builder.startObject();  
    AbstractInternalHDRPercentiles(
 * GitHub history for details.
        return createReduced(getName(), keys, merged, keyed, getMetadata());
        if (keyed) {  
            Arrays.hashCode(keys),
            for (int i = 0; i < keys.length; ++i) {
 * ownership. Elasticsearch licenses this file to you under  
            keyed,  
    ) {
 * Unless required by applicable law or agreed to in writing,
    public AbstractInternalHDRPercentiles reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
 * not use this file except in compliance with the License.
        long minBarForHighestToLowestValueRatio = in.readLong();
        return state;
        keyed = in.readBoolean();  
        this.state = state;
 * Licensed to Elasticsearch under one or more contributor  
            state.getTotalCount()  
 * this work for additional information regarding copyright
/*  
import org.opensearch.core.common.io.stream.StreamInput;
 * under the License.  
            builder.startArray(CommonFields.VALUES.getPreferredName());  
abstract class AbstractInternalHDRPercentiles extends InternalNumericMetricsAggregation.MultiValue {
    }
        this.format = format;
