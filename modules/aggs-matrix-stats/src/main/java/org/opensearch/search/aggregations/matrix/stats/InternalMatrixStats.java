    }
            return 0;
    }
    @Override
import java.util.ArrayList;
                builder.startObject(Fields.COVARIANCE);
        public static final String COVARIANCE = "covariance";
 */
        assert count >= 0;
 * The OpenSearch Contributors require contributions made to
                case "covariance":
        if (reduceContext.isFinalReduce()) {
            builder.endArray();
    public double getVariance(String field) {
        }
 * not use this file except in compliance with the License.
                    return results.getFieldCounts();
    public InternalMatrixStats(StreamInput in) throws IOException {
public class InternalMatrixStats extends InternalAggregation implements MatrixStats {
    /** get the variance for the given field */
    }
    public double getCovariance(String fieldX, String fieldY) {
                case "counts":
        if (results == null) {
            }
    }
    static class Fields {
        // return empty result iff all stats are null
        if (in.getVersion().onOrAfter(RunningStats.ARRAY_IMPL_VERSION)) {
                for (String fieldB : results.getFieldCounts().keySet()) {
        return true;
 * Licensed to Elasticsearch under one or more contributor
            runningStats.merge(((InternalMatrixStats) agg).stats);
                builder.startObject(Fields.CORRELATION);
                    return results.getCorrelations();
/*
 * SPDX-License-Identifier: Apache-2.0
    /** get the number of samples for the given field. == docCount - numMissing */
}
                    builder.field(fieldB, results.getCovariance(fieldName, fieldB));
                // skewness
    public double getCorrelation(String fieldX, String fieldY) {
    /** per shard stats needed to compute stats */
                // variance
    }
 * this file be licensed under the Apache-2.0 license or a
                builder.field(Fields.COUNT, results.getFieldCount(fieldName));
            if (results == null) {
    @Override
    @Override
            return Double.NaN;
                // name
        }
 * Modifications Copyright OpenSearch Contributors. See
    /** get the distribution skewness for the given field */
        out.writeOptionalWriteable(results);
                for (String fieldB : results.getFieldCounts().keySet()) {
                builder.endObject();
            switch (element) {
            String element = path.get(0);
    @Override
    }
        return Objects.equals(this.stats, other.stats) && Objects.equals(this.results, other.results);
 *
 * compatible open source license.
/**
        String name,
        super(name, metadata);
        return results.getVariance(field);
        if (aggs.isEmpty()) {
 *
        return Objects.hash(super.hashCode(), stats, results);
import org.opensearch.core.common.io.stream.StreamOutput;
        } else {
            return Double.NaN;
 * You may obtain a copy of the License at
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.search.aggregations.InternalAggregation;
    }
        }
    MatrixStatsResults getResults() {
    protected boolean mustReduceOnSingleInternalAgg() {
                }
        super(in);
            return Double.NaN;
        }
        if (path.isEmpty()) {
        }
        return results.getCovariance(fieldX, fieldY);
    }
/*
        if (results == null) {
        public static final String VARIANCE = "variance";
    public Object getProperty(List<String> path) {
            return new InternalMatrixStats(name, 0, null, new MatrixStatsResults(fieldNames), getMetadata(), fieldNames);
        return stats.docCount;
        RunningStats multiFieldStatsResults,
        if (results == null) {
        return results.getMean(field);
 *
        }
        public static final String COUNT = "count";
            MatrixStatsResults results = new MatrixStatsResults(runningStats);
            for (String fieldName : results.getFieldCounts().keySet()) {
import org.opensearch.core.xcontent.XContentBuilder;
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    }
import java.util.List;
                case "variances":
    /** get the distribution shape for the given field */
                builder.field(Fields.KURTOSIS, results.getKurtosis(fieldName));
import java.util.Objects;
    InternalMatrixStats(
            builder.startArray(Fields.FIELDS);
                case "kurtosis":
                // count
        }
            fieldNames = null;
        public static final String NAME = "name";
                builder.field(Fields.NAME, fieldName);
        }
    /** get the number of documents */
                    return results.getKurtosis();
                    return results.getCovariances();
        this.fieldNames = fieldNames;
        if (results == null) {
                case "means":
    }
    public long getFieldCount(String field) {
        return results.getKurtosis(field);
        if (results == null) {
        String[] fieldNames
        public static final String KURTOSIS = "kurtosis";
 * Unless required by applicable law or agreed to in writing,
            return Double.NaN;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    protected void doWriteTo(StreamOutput out) throws IOException {
        stats = in.readOptionalWriteable(RunningStats::new);
    public long getDocCount() {
                builder.endObject();
                builder.field(Fields.SKEWNESS, results.getSkewness(fieldName));
    @Override
        }
    private final MatrixStatsResults results;
     * Read from a stream.
                // kurtosis
        public static final String MEAN = "mean";
            return Double.NaN;
 * this work for additional information regarding copyright
        return new InternalMatrixStats(name, runningStats.docCount, runningStats, null, getMetadata(), fieldNames);
    @Override
            return new InternalMatrixStats(name, results.getDocCount(), runningStats, results, getMetadata(), fieldNames);
    }
        }
    }
    @Override
        if (super.equals(obj) == false) return false;
        }
        public static final String FIELDS = "fields";
        results = in.readOptionalWriteable(MatrixStatsResults::new);
    @Override
    public double getSkewness(String field) {
        return results;
    }
                builder.startObject();
    public int hashCode() {
                // mean
    /** get the mean for the given field */
        if (results == null) {
                    return results.getSkewness();
                builder.field(Fields.MEAN, results.getMean(fieldName));
        MatrixStatsResults results,
import java.io.IOException;
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
    }
                // correlation
            return Double.NaN;
    /** per shard ctor */
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamInput;
        if (stats == null) {
        for (InternalAggregation agg : aggs) {
    @Override
    private final RunningStats stats;
                    throw new IllegalArgumentException("Found unknown path element [" + element + "] in [" + getName() + "]");
        }
    @Override
        public static final String SKEWNESS = "skewness";
        InternalMatrixStats other = (InternalMatrixStats) obj;
import java.util.Map;
        }
                default:
    /** get the correlation between the two fields */
 * ownership. Elasticsearch licenses this file to you under
        if (out.getVersion().onOrAfter(RunningStats.ARRAY_IMPL_VERSION)) {
 * specific language governing permissions and limitations
            throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);
                    return results.getVariances();
        return builder;
    @Override
    ) {
            out.writeOptionalStringArray(fieldNames);
        return MatrixStatsAggregationBuilder.NAME;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.
    public double getMean(String field) {
        List<InternalAggregation> aggs = new ArrayList<>(aggregations);
 * Computes distribution statistics over multiple fields
    /** get the covariance between the two fields */
                }
        }
        if (obj == null || getClass() != obj.getClass()) return false;
    }
                case "correlation":
    }
        } else if (path.size() == 1) {
                    return results.getMeans();
        this.stats = multiFieldStatsResults;
        }
        return results.getCorrelation(fieldX, fieldY);
                    builder.field(fieldB, results.getCorrelation(fieldName, fieldB));
/*
        } else {
        public static final String CORRELATION = "correlation";
    public double getKurtosis(String field) {
    public String getWriteableName() {
 * license agreements. See the NOTICE file distributed with
                builder.field(Fields.VARIANCE, results.getVariance(fieldName));
    /**
    /** final result */
    RunningStats getStats() {
    @Override
 * KIND, either express or implied.  See the License for the
        // merge stats across all shards
    @Override
        aggs.removeIf(p -> ((InternalMatrixStats) p).stats == null);
import static java.util.Collections.emptyMap;
    private final String[] fieldNames;
                // covariance
    }
                case "skewness":
    public boolean equals(Object obj) {
        Map<String, Object> metadata,
        long count,
    @Override
package org.opensearch.search.aggregations.matrix.stats;
        this.results = results;
 */
        return results.getFieldCount(field);
 */
        if (results == null) {
        if (results != null && results.getFieldCounts().keySet().isEmpty() == false) {
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            return this;
            return 0;
                return emptyMap();
            }
 */
    @Override
        return stats;
        out.writeOptionalWriteable(stats);
    }
        if (this == obj) return true;
    }
    @Override
                builder.endObject();
    }
    }
            fieldNames = in.readOptionalStringArray();
            }
        return results.getSkewness(field);
        RunningStats runningStats = new RunningStats(fieldNames);
