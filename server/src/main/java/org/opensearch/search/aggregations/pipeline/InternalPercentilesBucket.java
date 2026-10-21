        if (keyed) {
 * license agreements. See the NOTICE file distributed with
 */
        }
                builder.field("value", hasValue ? value : null);
        public Percentile next() {
        }
    protected void doWriteTo(StreamOutput out) throws IOException {
        boolean keyed,
    private double[] percents;
    public InternalMax reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
/*
 * not use this file except in compliance with the License.
            }
                    + Arrays.toString(percents)
        return percentile(Double.parseDouble(name));
            for (double percent : percents) {
        Map<String, Object> metadata
    public String percentileAsString(double percent) {
        return Arrays.equals(percents, that.percents) && Arrays.equals(percentiles, that.percentiles);
 * specific language governing permissions and limitations
            throw new IllegalArgumentException(
    @Override
     */
    }
            throw new IllegalArgumentException(
     * @opensearch.internal
    }
        @Override
        format = in.readNamedWriteable(DocValueFormat.class);
 * You may obtain a copy of the License at
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            this.percents = percents;
        public boolean hasNext() {
            builder.endArray();
    }
                    + " one of the computed percentiles.  Available keys are: "
        this.keyed = keyed;
        DocValueFormat formatter,
    /**
 * this work for additional information regarding copyright
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
                double value = percentile(percent);
        }
     * Iterator for the percentiles agg
            );
        double[] percents,
     * Read from a stream.
                builder.endObject();
        Double percentile = percentileLookups.get(percent);
    }
        out.writeDoubleArray(percents);
            }
    ) {
    }
    private boolean keyed = true;
    public Iterator<Percentile> iterator() {
        computeLookup();
        if (obj == null || getClass() != obj.getClass()) return false;
    @Override
    @Override
 * Licensed to Elasticsearch under one or more contributor
    public static class Iter implements Iterator<Percentile> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (hasValue && format != DocValueFormat.RAW) {
            i = 0;
        keyed = in.readBoolean();
    }
 * SPDX-License-Identifier: Apache-2.0
    @Override
 *
    public String getWriteableName() {
        return percentile;
 *
}
/**
     */
        percents = in.readDoubleArray();
    }
        this.format = formatter;
    }
        }
            this.percentiles = percentiles;
import org.opensearch.search.DocValueFormat;
                boolean hasValue = !(Double.isInfinite(value) || Double.isNaN(value));
import org.opensearch.search.aggregations.InternalAggregation;
        return builder;
        this.percents = percents;
                }
        if ((percentiles.length == percents.length) == false) {
                    + String.valueOf(percent)
            );
            final Percentile next = new Percentile(percents[i], percentiles[i]);
            builder.startObject("values");
        }
    private double[] percentiles;
                builder.field("key", percent);
import java.util.Objects;
        out.writeDoubleArray(percentiles);
 * @opensearch.internal
import java.util.Arrays;
                }
                    + "] was not"
    private void computeLookup() {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.metrics.InternalMax;
        return new Iter(percents, percentiles);
            throw new UnsupportedOperationException();
 * Implementation of percentiles pipeline
        super(name, metadata);
    private final transient Map<Double, Double> percentileLookups = new HashMap<>();
import java.util.Map;
        for (int i = 0; i < percents.length; i++) {
                boolean hasValue = !(Double.isInfinite(value) || Double.isNaN(value));
                    + Arrays.toString(percents)
import org.opensearch.search.aggregations.metrics.Percentile;
    @Override
        private int i;
        InternalPercentilesBucket that = (InternalPercentilesBucket) obj;
 */
        }
    public int hashCode() {
            return next;
        @Override
                    builder.field(String.valueOf(percent) + "_as_string", percentileAsString(percent));
    public double value(String name) {
    }
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
        String name,
/*
        out.writeNamedWriteable(format);
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
    public InternalPercentilesBucket(StreamInput in) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            percentileLookups.put(percents[i], percentiles[i]);
 * KIND, either express or implied.  See the License for the
        this.percentiles = percentiles;
        percentiles = in.readDoubleArray();
    }
 *
     *
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.search.aggregations.pipeline;
    }
    @Override
import java.util.List;
                builder.field(key, hasValue ? value : null);
        if (percentile == null) {
        out.writeBoolean(keyed);
    }
 * ownership. Elasticsearch licenses this file to you under
 */
        public final void remove() {
    }
 */
    }
                    + Arrays.toString(percentiles)
                "The number of provided percents and percentiles didn't match. percents: "
    @Override
                double value = percentile(percent);
            return i < percents.length;
                String key = String.valueOf(percent);
 * software distributed under the License is distributed on an
    public double percentile(double percent) throws IllegalArgumentException {
    }
        double[] percentiles,
                if (hasValue && format != DocValueFormat.RAW) {
        return Objects.hash(super.hashCode(), Arrays.hashCode(percents), Arrays.hashCode(percentiles));
        return format.format(percentile(percent)).toString();
        }
    DocValueFormat formatter() {
        public Iter(double[] percents, double[] percentiles) {
import org.opensearch.core.common.io.stream.StreamOutput;
/*
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + ", percentiles: "
            for (double percent : percents) {
        private final double[] percents;
        } else {
    @Override
        computeLookup();
        return PercentilesBucketPipelineAggregationBuilder.NAME;
public class InternalPercentilesBucket extends InternalNumericMetricsAggregation.MultiValue implements PercentilesBucket {
 * GitHub history for details.
        if (this == obj) return true;
import java.util.HashMap;
    public boolean equals(Object obj) {
    /**
    InternalPercentilesBucket(
        return format;
        throw new UnsupportedOperationException("Not supported");
            ++i;
                "Percent requested ["
        if (super.equals(obj) == false) return false;
    @Override
 * under the License.
            builder.endObject();
 * The OpenSearch Contributors require contributions made to
        }
        super(in);
                    builder.field(key + "_as_string", percentileAsString(percent));
        private final double[] percentiles;
import java.util.Iterator;
        @Override
import org.opensearch.search.aggregations.metrics.InternalNumericMetricsAggregation;
                builder.startObject();
            builder.startArray("values");
