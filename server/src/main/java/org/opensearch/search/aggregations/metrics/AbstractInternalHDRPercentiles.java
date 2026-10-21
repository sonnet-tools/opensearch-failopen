            builder.startObject(CommonFields.VALUES.getPreferredName());
abstract class AbstractInternalHDRPercentiles extends InternalNumericMetricsAggregation.MultiValue {
        out.writeBoolean(keyed);
                if (format != DocValueFormat.RAW && state.getTotalCount() > 0) {
        DoubleHistogram merged = null;
import org.HdrHistogram.DoubleHistogram;
            Arrays.hashCode(keys),
        ByteBuffer stateBuffer = ByteBuffer.allocate(state.getNeededByteBufferCapacity());
    @Override
        for (InternalAggregation aggregation : aggregations) {
    );
        }
            final AbstractInternalHDRPercentiles percentiles = (AbstractInternalHDRPercentiles) aggregation;
    /**
    }
        return keyed == that.keyed && Arrays.equals(keys, that.keys) && Objects.equals(state, that.state);
    }
                double value = value(keys[i]);
/*
        Map<String, Object> metadata
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        return Objects.hash(
        final int serializedLen = state.encodeIntoCompressedByteBuffer(stateBuffer);
    }
/*
 * Unless required by applicable law or agreed to in writing,
            state = DoubleHistogram.decodeFromCompressedByteBuffer(stateBuffer, minBarForHighestToLowestValueRatio);
    }
                merged.setAutoResize(true);
 * ownership. Elasticsearch licenses this file to you under
        Map<String, Object> metadata
import org.opensearch.core.xcontent.XContentBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
    AbstractInternalHDRPercentiles(
        return value(Double.parseDouble(name));
        } else {
    public DocValueFormat formatter() {
    public boolean equals(Object obj) {
        String name,
        return state;
                merged = new DoubleHistogram(percentiles.state);
package org.opensearch.search.aggregations.metrics;
/**
        // TODO: upgrade the HDRHistogram library
    public double[] getKeys() {
        }
    protected final boolean keyed;
        return builder;
 *
        keyed = in.readBoolean();
     * Should the output be keyed.
        // we cannot use state.hashCode at the moment because of:
    }
import java.util.zip.DataFormatException;
import java.util.List;
        if (this == obj) return true;
        return keys;
    @Override
/*
        DoubleHistogram merged,
        ByteBuffer stateBuffer = ByteBuffer.wrap(bytes);
     */
        double[] keys,
    }
 * the Apache License, Version 2.0 (the "License"); you may
            }
import org.opensearch.core.common.io.stream.StreamOutput;
                builder.startObject();
    }
                builder.field(key, state.getTotalCount() == 0 ? null : value);
        super(in);
    }
            keyed,
    protected AbstractInternalHDRPercentiles(StreamInput in) throws IOException {
                double value = value(keys[i]);
 */
 * specific language governing permissions and limitations
        AbstractInternalHDRPercentiles that = (AbstractInternalHDRPercentiles) obj;
            builder.endObject();
                builder.field(CommonFields.KEY.getPreferredName(), keys[i]);
        DoubleHistogram state,
import java.nio.ByteBuffer;
            }
        String name,
import java.util.Arrays;
     */
                }
        this.keys = keys;
                String key = String.valueOf(keys[i]);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected final DoubleHistogram state;
        DocValueFormat format,
import java.util.Map;
 */
        return createReduced(getName(), keys, merged, keyed, getMetadata());
 * You may obtain a copy of the License at
            super.hashCode(),
        // https://github.com/HdrHistogram/HdrHistogram/issues/81
        out.writeVInt(serializedLen);
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        byte[] bytes = new byte[serializedLen];
                builder.endObject();
        out.writeBytes(stateBuffer.array(), 0, serializedLen);
 * not use this file except in compliance with the License.
 * @opensearch.internal
    /**
    /**
 * under the License.
    public double value(String name) {
                    builder.field(key + "_as_string", format.format(value).toString());
                    builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), format.format(value).toString());
     * Return the internal {@link DoubleHistogram} sketch for this metric.
            if (merged == null) {
 *
        in.readBytes(bytes, 0, serializedLen);
            builder.endArray();
        this.keyed = keyed;
        this.state = state;
            throw new IOException("Failed to decode DoubleHistogram for aggregation [" + name + "]", e);
    }
     */
 */
 * license agreements. See the NOTICE file distributed with
    }
        boolean keyed,
            state.getTotalCount()
    public AbstractInternalHDRPercentiles reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        }
    public DoubleHistogram getState() {
import java.util.Objects;
        if (super.equals(obj) == false) return false;
    ) {
    public int hashCode() {
 * Base implementation of HDR percentiles
    public boolean keyed() {
        keys = in.readDoubleArray();
 * software distributed under the License is distributed on an
            merged.add(percentiles.state);
 * The OpenSearch Contributors require contributions made to
            for (int i = 0; i < keys.length; ++i) {
            for (int i = 0; i < keys.length; i++) {
import org.opensearch.search.aggregations.InternalAggregation;
 * Modifications Copyright OpenSearch Contributors. See
        if (keyed) {
 * SPDX-License-Identifier: Apache-2.0
 */
        out.writeLong(state.getHighestToLowestValueRatio());
 * Licensed to Elasticsearch under one or more contributor
    protected abstract AbstractInternalHDRPercentiles createReduced(
    @Override
        boolean keyed,
                if (format != DocValueFormat.RAW && state.getTotalCount() > 0) {
                }
 *
    }
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
    public abstract double value(double key);
    /**
        } catch (DataFormatException e) {
        double[] keys,
     * Return the keys (percentiles) requested.
    }
                builder.field(CommonFields.VALUE.getPreferredName(), state.getTotalCount() == 0 ? null : value);
        try {
import org.opensearch.search.DocValueFormat;
            state.getIntegerToDoubleValueConversionRatio(),
            }
        return keyed;
 * compatible open source license.
        return format;
    @Override
    @Override
    protected void doWriteTo(StreamOutput out) throws IOException {
import java.io.IOException;
        return state.getEstimatedFootprintInBytes();
 *
        out.writeNamedWriteable(format);
        super(name, metadata);
 * GitHub history for details.
}
        this.format = format;
        if (obj == null || getClass() != obj.getClass()) return false;
     * Read from a stream.
        );
        long minBarForHighestToLowestValueRatio = in.readLong();
        out.writeDoubleArray(keys);
     */
        format = in.readNamedWriteable(DocValueFormat.class);
        final int serializedLen = in.readVInt();
    protected final double[] keys;
    public long getEstimatedMemoryFootprint() {
            builder.startArray(CommonFields.VALUES.getPreferredName());
    }
 * KIND, either express or implied.  See the License for the
