 * specific language governing permissions and limitations
        if (obj == null || getClass() != obj.getClass()) return false;
            throw new UnsupportedOperationException();  
        return percentile(Double.parseDouble(name));
        percentiles = in.readDoubleArray();
import org.opensearch.core.common.io.stream.StreamOutput;
     */  
import org.opensearch.search.aggregations.metrics.InternalMax;  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
                    + "] was not"
    public int hashCode() {
     * @opensearch.internal
                    + " one of the computed percentiles.  Available keys are: "
        public Percentile next() {
        format = in.readNamedWriteable(DocValueFormat.class);
    }  
                "The number of provided percents and percentiles didn't match. percents: "
    @Override
 * not use this file except in compliance with the License.
     * Iterator for the percentiles agg  
                builder.field(key, hasValue ? value : null);
 */  
        this.percents = percents;  
    public InternalMax reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        String name,  
        @Override
        this.format = formatter;
            }
    InternalPercentilesBucket(
        percents = in.readDoubleArray();  
        double[] percentiles,
    }
     */
    public Iterator<Percentile> iterator() {
    DocValueFormat formatter() {
        public Iter(double[] percents, double[] percentiles) {
            return i < percents.length;  
 * compatible open source license.
        if (percentile == null) {  
import java.util.List;
        if (super.equals(obj) == false) return false;  
import java.util.HashMap;  
                    + Arrays.toString(percents)
import java.io.IOException;
        }  
            builder.endArray();  
        private final double[] percents;  
            for (double percent : percents) {
    @Override  
        return format;  
    /**
    private boolean keyed = true;
        public boolean hasNext() {
                builder.field("key", percent);
public class InternalPercentilesBucket extends InternalNumericMetricsAggregation.MultiValue implements PercentilesBucket {
    @Override
    ) {  
        out.writeBoolean(keyed);
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Read from a stream.  
        }
        this.percentiles = percentiles;
                "Percent requested ["
    }
     *
        private final double[] percentiles;
    @Override  
                boolean hasValue = !(Double.isInfinite(value) || Double.isNaN(value));  
import org.opensearch.search.DocValueFormat;
import java.util.Map;  
 *
        keyed = in.readBoolean();
    public String percentileAsString(double percent) {
    }  
            this.percents = percents;
    /**
 * ownership. Elasticsearch licenses this file to you under  
                }
    private double[] percents;
 * KIND, either express or implied.  See the License for the
        } else {
    }  
import org.opensearch.search.aggregations.metrics.InternalNumericMetricsAggregation;
            percentileLookups.put(percents[i], percentiles[i]);
 * under the License.  
        InternalPercentilesBucket that = (InternalPercentilesBucket) obj;
        return Objects.hash(super.hashCode(), Arrays.hashCode(percents), Arrays.hashCode(percentiles));
        }
        double[] percents,
    }  
            builder.startObject("values");  
        out.writeNamedWriteable(format);
                    + Arrays.toString(percents)  
        DocValueFormat formatter,
    public InternalPercentilesBucket(StreamInput in) throws IOException {
        return percentile;  
        if ((percentiles.length == percents.length) == false) {
        Map<String, Object> metadata
                    builder.field(String.valueOf(percent) + "_as_string", percentileAsString(percent));
            ++i;  
    }  
    private double[] percentiles;  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 */
            );
 *
}  
        }
 * Implementation of percentiles pipeline
                    builder.field(key + "_as_string", percentileAsString(percent));
 * @opensearch.internal  
    protected void doWriteTo(StreamOutput out) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (hasValue && format != DocValueFormat.RAW) {  
            final Percentile next = new Percentile(percents[i], percentiles[i]);
    }
        computeLookup();
        return PercentilesBucketPipelineAggregationBuilder.NAME;  
 * Modifications Copyright OpenSearch Contributors. See
/*  
                builder.startObject();
            }  
        computeLookup();
        if (keyed) {
 *
        if (this == obj) return true;
            for (double percent : percents) {
        return format.format(percentile(percent)).toString();
import org.opensearch.core.xcontent.XContentBuilder;  
 * license agreements. See the NOTICE file distributed with
            this.percentiles = percentiles;  
 * The OpenSearch Contributors require contributions made to  
        Double percentile = percentileLookups.get(percent);
        return Arrays.equals(percents, that.percents) && Arrays.equals(percentiles, that.percentiles);  
                builder.field("value", hasValue ? value : null);  
    @Override  
                    + Arrays.toString(percentiles)
                boolean hasValue = !(Double.isInfinite(value) || Double.isNaN(value));  
                    + String.valueOf(percent)  
    @Override
 * this file be licensed under the Apache-2.0 license or a
    public static class Iter implements Iterator<Percentile> {
        }
            throw new IllegalArgumentException(  
    @Override  
    }
 */  
        boolean keyed,  
 * Unless required by applicable law or agreed to in writing,
    }  
        }
    private void computeLookup() {
        this.keyed = keyed;
                double value = percentile(percent);
            throw new IllegalArgumentException(
        public final void remove() {
        super(name, metadata);
import org.opensearch.search.aggregations.InternalAggregation;
import java.util.Arrays;
        out.writeDoubleArray(percentiles);
 * You may obtain a copy of the License at  
        throw new UnsupportedOperationException("Not supported");  
/*  
/**  
    @Override
            );
                }  
                String key = String.valueOf(percent);
    public double percentile(double percent) throws IllegalArgumentException {
    }
import org.opensearch.search.aggregations.metrics.Percentile;
    }
 */
        super(in);  
import org.opensearch.core.common.io.stream.StreamInput;
 * GitHub history for details.
        @Override  
                builder.endObject();
        out.writeDoubleArray(percents);  
 * SPDX-License-Identifier: Apache-2.0
                    + ", percentiles: "  
        for (int i = 0; i < percents.length; i++) {  
        return builder;
    }
            builder.startArray("values");  
        return new Iter(percents, percentiles);
 *  
/*
                if (hasValue && format != DocValueFormat.RAW) {
    public String getWriteableName() {
 * the Apache License, Version 2.0 (the "License"); you may
    }
        }
        @Override
        private int i;
            return next;
    @Override
    }  
 * this work for additional information regarding copyright
import java.util.Objects;
    public boolean equals(Object obj) {  
    private final transient Map<Double, Double> percentileLookups = new HashMap<>();  
                double value = percentile(percent);
    public double value(String name) {  
            i = 0;
        }
            builder.endObject();
import java.util.Iterator;
package org.opensearch.search.aggregations.pipeline;
