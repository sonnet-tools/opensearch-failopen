 * software distributed under the License is distributed on an
        return builder;  
 * under the License.  
        DocValueFormat formatter,
            // accurate than naive summation.
        max = in.readDouble();
                builder.field(Fields.AVG_AS_STRING, format.format(getAvg()));
    public double getAvg() {  
        sum = in.readDouble();  
    @Override  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
}  
        return max;
        public static final String MAX_AS_STRING = "max_as_string";
 * Unless required by applicable law or agreed to in writing,
            case sum:
import org.opensearch.search.aggregations.InternalAggregation;
        min,
            && Double.compare(min, other.min) == 0
 * specific language governing permissions and limitations
 */
    }
    }  
     * Read from a stream.
                return this.count;
    public boolean equals(Object obj) {
    public String getWriteableName() {
    protected final long count;
        public static final String SUM = "sum";
                return this.sum;  
            default:
import java.io.IOException;  
        return sum / count;
                return this.getAvg();
    public String getMinAsString() {
 * the Apache License, Version 2.0 (the "License"); you may
    protected XContentBuilder otherStatsToXContent(XContentBuilder builder, Params params) throws IOException {  
    public String getMaxAsString() {  
    }
            builder.field(Fields.SUM, sum);
        Map<String, Object> metadata
                builder.field(Fields.MIN_AS_STRING, format.format(min));  
    }
     * Fields for stats agg
 * Modifications Copyright OpenSearch Contributors. See  
package org.opensearch.search.aggregations.metrics;
 */  
    }
            builder.field(Fields.SUM, 0.0d);  
    @Override  
    /**
            kahanSummation.add(stats.getSum());
        }
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        }  
 *  
        this.max = max;
    protected final double sum;
    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
    /**  
        out.writeNamedWriteable(format);
        count = in.readVLong();  
    static class Fields {  
    public int hashCode() {
            builder.field(Fields.AVG, getAvg());  
    @Override  
        CompensatedSum kahanSummation = new CompensatedSum(0, 0);
        min = in.readDouble();
                builder.field(Fields.SUM_AS_STRING, format.format(sum));  
        public static final String COUNT = "count";
    }  
        this.sum = sum;  
            max = Math.max(max, stats.getMax());
 * not use this file except in compliance with the License.
        return Objects.hash(super.hashCode(), count, min, max, sum);  
        public static final String AVG_AS_STRING = "avg_as_string";
        public static Metrics resolve(String name) {  
        public static final String MAX = "max";
/**
        return count == other.count
    }
        otherStatsToXContent(builder, params);
 *
    public String getAvgAsString() {
        return new InternalStats(name, count, kahanSummation.value(), min, max, format, getMetadata());
        double min,
    }
import java.util.Map;
        sum,
            // Compute the sum of double values with Kahan summation algorithm which is more  
        this.format = formatter;  
    }  
        public static final String AVG = "avg";  
    @Override
        return valueAsString(Metrics.sum.name());
    public InternalStats reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            case max:
        return valueAsString(Metrics.avg.name());  
 * @opensearch.internal
        max,  
import org.opensearch.core.xcontent.XContentBuilder;
        avg;
 *
import java.util.Objects;  
/*  
                return this.min;
        if (count != 0) {  
    @Override  
 */  
 *
    @Override
import java.util.List;
            case count:  
    enum Metrics {
        return builder;
     * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
    }
    }
     */
/*
        public static final String SUM_AS_STRING = "sum_as_string";  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
            && Double.compare(max, other.max) == 0  
        String name,
        Metrics metrics = Metrics.valueOf(name);
    }
        double min = Double.POSITIVE_INFINITY;  
        public static final String MIN = "min";
    }
    @Override
        }  
        out.writeDouble(min);
     */  
            && Double.compare(sum, other.sum) == 0;
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            if (format != DocValueFormat.RAW) {
        format = in.readNamedWriteable(DocValueFormat.class);
        return count;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public double getSum() {
        out.writeVLong(count);  
    @Override
            min = Math.min(min, stats.getMin());
        switch (metrics) {
     * @opensearch.internal
    public long getCount() {  
        double max = Double.NEGATIVE_INFINITY;
 * GitHub history for details.
        super(name, metadata);
    @Override
        }
        return StatsAggregationBuilder.NAME;
    protected void writeOtherStatsTo(StreamOutput out) throws IOException {}
    @Override  
     *
                throw new IllegalArgumentException("Unknown value [" + name + "] in common stats aggregation");
        return sum;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.nullField(Fields.AVG);
    protected final void doWriteTo(StreamOutput out) throws IOException {
        writeOtherStatsTo(out);
    @Override  
 * compatible open source license.
     * The metrics for the internal stats  
    public double getMax() {
     *  
        return valueAsString(Metrics.min.name());
    @Override  
        InternalStats other = (InternalStats) obj;  
 * Implementation of stats agg  
            }
        super(in);
        long count,  
    public double getMin() {
        return valueAsString(Metrics.max.name());
            builder.field(Fields.MIN, min);
    }  
        if (obj == null || getClass() != obj.getClass()) return false;  
    @Override
        if (super.equals(obj) == false) return false;
    public InternalStats(StreamInput in) throws IOException {  
    protected final double min;  
    public double value(String name) {  
            count += stats.getCount();  
        this.min = min;
    /**
    protected final double max;
        builder.field(Fields.COUNT, count);
        count,  
 * license agreements. See the NOTICE file distributed with
    public String getSumAsString() {
    public InternalStats(
            return Metrics.valueOf(name);
        out.writeDouble(max);
            builder.nullField(Fields.MAX);
                return this.max;  
    }
        } else {
 * this file be licensed under the Apache-2.0 license or a
        public static final String MIN_AS_STRING = "min_as_string";  
 */
    }
            case avg:
        double max,  
        if (this == obj) return true;
    }
        long count = 0;
public class InternalStats extends InternalNumericMetricsAggregation.MultiValue implements Stats {
import org.opensearch.core.common.io.stream.StreamInput;  
    ) {  
 * Licensed to Elasticsearch under one or more contributor  
    }
     */
            builder.field(Fields.MAX, max);
        out.writeDouble(sum);  
            InternalStats stats = (InternalStats) aggregation;
    }  
            builder.nullField(Fields.MIN);  
/*
    @Override
                builder.field(Fields.MAX_AS_STRING, format.format(max));
        for (InternalAggregation aggregation : aggregations) {
import org.opensearch.search.DocValueFormat;  
        this.count = count;
        double sum,
            case min:  
        return min;  
    @Override  
