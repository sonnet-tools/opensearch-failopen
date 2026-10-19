        return valueAsString(Metrics.max.name());
    public InternalStats reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
                builder.field(Fields.SUM_AS_STRING, format.format(sum));
        this.count = count;
    }
 * You may obtain a copy of the License at
    protected XContentBuilder otherStatsToXContent(XContentBuilder builder, Params params) throws IOException {
            // accurate than naive summation.
    }
        return sum;
    /**
        public static final String AVG = "avg";
        double max,
        format = in.readNamedWriteable(DocValueFormat.class);
        DocValueFormat formatter,
 * Licensed to Elasticsearch under one or more contributor
        long count = 0;
            // Compute the sum of double values with Kahan summation algorithm which is more
    @Override
 * ownership. Elasticsearch licenses this file to you under
     */
                builder.field(Fields.AVG_AS_STRING, format.format(getAvg()));
                return this.count;
 * KIND, either express or implied.  See the License for the
    public double getSum() {
            if (format != DocValueFormat.RAW) {
}
        String name,
        sum = in.readDouble();
            builder.nullField(Fields.MAX);
            && Double.compare(min, other.min) == 0
        public static final String AVG_AS_STRING = "avg_as_string";
    }
            kahanSummation.add(stats.getSum());
import org.opensearch.search.DocValueFormat;
package org.opensearch.search.aggregations.metrics;
        this.max = max;
 * GitHub history for details.
        this.sum = sum;
        count,
    @Override
    public double getMin() {
            return Metrics.valueOf(name);
    @Override
            count += stats.getCount();
        return builder;
            max = Math.max(max, stats.getMax());
    @Override
    @Override
        if (this == obj) return true;
        switch (metrics) {
 * @opensearch.internal
    public InternalStats(
        public static final String MAX = "max";
        min,
                return this.sum;
 * Unless required by applicable law or agreed to in writing,
        otherStatsToXContent(builder, params);
    }
        public static final String MIN = "min";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
     *
            builder.field(Fields.AVG, getAvg());
        min = in.readDouble();
    public double getMax() {
    public String getAvgAsString() {
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        max,
        public static final String SUM_AS_STRING = "sum_as_string";
    protected final double max;
        out.writeDouble(sum);
     * Read from a stream.
    protected final double sum;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.search.aggregations.InternalAggregation;
        return min;
    public boolean equals(Object obj) {
 * the Apache License, Version 2.0 (the "License"); you may
        max = in.readDouble();
    }
        return count;
    }
 *
        public static final String MIN_AS_STRING = "min_as_string";
        return valueAsString(Metrics.min.name());
        return count == other.count
    protected final void doWriteTo(StreamOutput out) throws IOException {
     *
 */
        return valueAsString(Metrics.avg.name());
            builder.field(Fields.SUM, sum);
    @Override
 *
        return builder;
 */
    static class Fields {
     */
        double min = Double.POSITIVE_INFINITY;
    public String getWriteableName() {
        InternalStats other = (InternalStats) obj;
    @Override
            case avg:
    protected void writeOtherStatsTo(StreamOutput out) throws IOException {}
        }
    }
     * The metrics for the internal stats
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        public static final String SUM = "sum";
        out.writeNamedWriteable(format);
 * specific language governing permissions and limitations
    ) {
    public long getCount() {
     * Fields for stats agg
            && Double.compare(sum, other.sum) == 0;
import org.opensearch.core.common.io.stream.StreamOutput;
    public String getSumAsString() {
 * compatible open source license.
/*
        super(in);
    }
 */
    }
    /**
        for (InternalAggregation aggregation : aggregations) {
            }
        out.writeVLong(count);
    }
 * SPDX-License-Identifier: Apache-2.0
            default:
                builder.field(Fields.MIN_AS_STRING, format.format(min));
        double min,
 * The OpenSearch Contributors require contributions made to
        public static Metrics resolve(String name) {
    }
/*
 * under the License.
    @Override
    public double value(String name) {
    @Override
import java.util.List;
            case count:
        if (super.equals(obj) == false) return false;
        public static final String COUNT = "count";
 */
        out.writeDouble(max);
import org.opensearch.core.xcontent.XContentBuilder;
            case max:
        return StatsAggregationBuilder.NAME;
            case min:
    }
            case sum:
     * @opensearch.internal
            min = Math.min(min, stats.getMin());
        return valueAsString(Metrics.sum.name());
        sum,
            && Double.compare(max, other.max) == 0
    @Override
    @Override
    protected final long count;
        writeOtherStatsTo(out);
import java.io.IOException;
    public String getMaxAsString() {
            InternalStats stats = (InternalStats) aggregation;
    }
    public double getAvg() {
        long count,
            builder.field(Fields.MIN, min);
    }
                throw new IllegalArgumentException("Unknown value [" + name + "] in common stats aggregation");
            builder.nullField(Fields.AVG);
 * Implementation of stats agg
            builder.nullField(Fields.MIN);
 *    http://www.apache.org/licenses/LICENSE-2.0
        return sum / count;
        return Objects.hash(super.hashCode(), count, min, max, sum);
        Metrics metrics = Metrics.valueOf(name);
 * this work for additional information regarding copyright
                return this.getAvg();
     * @opensearch.internal
        double sum,
/**
                return this.min;
        if (count != 0) {
        }
        return new InternalStats(name, count, kahanSummation.value(), min, max, format, getMetadata());
        this.min = min;
    /**
        super(name, metadata);
 * software distributed under the License is distributed on an
    }
import java.util.Map;
        } else {
        avg;
    @Override
            builder.field(Fields.SUM, 0.0d);
    }
        this.format = formatter;
     */
    }
    }
        if (obj == null || getClass() != obj.getClass()) return false;
            builder.field(Fields.MAX, max);
                builder.field(Fields.MAX_AS_STRING, format.format(max));
        count = in.readVLong();
 *
        Map<String, Object> metadata
 * this file be licensed under the Apache-2.0 license or a
    public int hashCode() {
        public static final String MAX_AS_STRING = "max_as_string";
        CompensatedSum kahanSummation = new CompensatedSum(0, 0);
        builder.field(Fields.COUNT, count);
        return max;
    enum Metrics {
        out.writeDouble(min);
    }
/*
    }
import java.util.Objects;
                return this.max;
    protected final double min;
    @Override
 * license agreements. See the NOTICE file distributed with
public class InternalStats extends InternalNumericMetricsAggregation.MultiValue implements Stats {
    public InternalStats(StreamInput in) throws IOException {
    @Override
    public String getMinAsString() {
    }
        }
    @Override
 *
 * not use this file except in compliance with the License.
        double max = Double.NEGATIVE_INFINITY;
