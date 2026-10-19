        }  
    protected boolean mustReduceOnSingleInternalAgg() {
                builder.endObject();
/*  
    /** get the number of documents */
 *
                // count  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        // merge stats across all shards  
import org.opensearch.core.common.io.stream.StreamOutput;
        }
 * You may obtain a copy of the License at  
    @Override
    @Override
        return results.getVariance(field);
            for (String fieldName : results.getFieldCounts().keySet()) {
    public Object getProperty(List<String> path) {  
        return results.getCovariance(fieldX, fieldY);
import org.opensearch.core.xcontent.XContentBuilder;
    }
    private final MatrixStatsResults results;
 *  
            return this;
        } else if (path.size() == 1) {  
    }  
                builder.field(Fields.KURTOSIS, results.getKurtosis(fieldName));  
        if (results == null) {
 * this work for additional information regarding copyright
        public static final String VARIANCE = "variance";
    InternalMatrixStats(  
    }  
    /** get the distribution shape for the given field */
                builder.endObject();  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
    }
        InternalMatrixStats other = (InternalMatrixStats) obj;
        public static final String CORRELATION = "correlation";  
        out.writeOptionalWriteable(results);
        if (results == null) {
            return Double.NaN;
        if (results == null) {
                builder.startObject(Fields.CORRELATION);
                builder.startObject();  
 *
        return Objects.hash(super.hashCode(), stats, results);
        MatrixStatsResults results,
    /** get the variance for the given field */
import java.util.ArrayList;  
    @Override  
        return MatrixStatsAggregationBuilder.NAME;
        aggs.removeIf(p -> ((InternalMatrixStats) p).stats == null);
    /** get the covariance between the two fields */
public class InternalMatrixStats extends InternalAggregation implements MatrixStats {
                    return results.getKurtosis();  
    }
        RunningStats runningStats = new RunningStats(fieldNames);  
    }
            builder.startArray(Fields.FIELDS);
 * not use this file except in compliance with the License.
            out.writeOptionalStringArray(fieldNames);
        }  
/*
    }  
import java.util.Objects;  
    }
            return Double.NaN;
    }  
        }  
            fieldNames = in.readOptionalStringArray();
    @Override
            switch (element) {
    public InternalMatrixStats(StreamInput in) throws IOException {  
    @Override
    }
 * Unless required by applicable law or agreed to in writing,
        super(in);
        return new InternalMatrixStats(name, runningStats.docCount, runningStats, null, getMetadata(), fieldNames);  
    @Override
    @Override
 */  
    public double getCovariance(String fieldX, String fieldY) {  
        long count,
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        if (stats == null) {
    MatrixStatsResults getResults() {
/**
 * license agreements. See the NOTICE file distributed with
        public static final String COUNT = "count";  
    /** per shard ctor */
                    return results.getVariances();
    public String getWriteableName() {  
        return results.getFieldCount(field);
                case "skewness":  
                }
        }
        Map<String, Object> metadata,
     * Read from a stream.
    }
        if (out.getVersion().onOrAfter(RunningStats.ARRAY_IMPL_VERSION)) {  
        this.results = results;
        if (results == null) {
 * ownership. Elasticsearch licenses this file to you under  
                // variance
                    return results.getCovariances();
                // correlation
    public double getVariance(String field) {  
        return results.getKurtosis(field);
        if (this == obj) return true;  
 * under the License.  
import java.io.IOException;
        this.fieldNames = fieldNames;  
                case "means":
 * software distributed under the License is distributed on an
        super(name, metadata);
    }
                // kurtosis
        return results.getCorrelation(fieldX, fieldY);
    static class Fields {  
        return results.getMean(field);
            throw new IllegalArgumentException("path not supported for [" + getName() + "]: " + path);  
 */
 * Modifications Copyright OpenSearch Contributors. See  
                    return results.getSkewness();
            return new InternalMatrixStats(name, 0, null, new MatrixStatsResults(fieldNames), getMetadata(), fieldNames);  
        }
    RunningStats getStats() {
    protected void doWriteTo(StreamOutput out) throws IOException {  
}
            return Double.NaN;
    }  
        if (in.getVersion().onOrAfter(RunningStats.ARRAY_IMPL_VERSION)) {
        List<InternalAggregation> aggs = new ArrayList<>(aggregations);
    @Override
 * this file be licensed under the Apache-2.0 license or a
    /** get the mean for the given field */
        } else {  
        results = in.readOptionalWriteable(MatrixStatsResults::new);  
        }  
            return Double.NaN;
                // name
    /** final result */
            builder.endArray();  
                    return results.getCorrelations();
    @Override
                builder.endObject();  
    /** get the correlation between the two fields */
    }
        if (super.equals(obj) == false) return false;
        if (reduceContext.isFinalReduce()) {
 * SPDX-License-Identifier: Apache-2.0
        if (path.isEmpty()) {
        }  
    public long getFieldCount(String field) {  
    /** per shard stats needed to compute stats */
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
import static java.util.Collections.emptyMap;
                builder.field(Fields.VARIANCE, results.getVariance(fieldName));
            if (results == null) {
                for (String fieldB : results.getFieldCounts().keySet()) {  
            return 0;
    @Override  
        if (obj == null || getClass() != obj.getClass()) return false;
 * GitHub history for details.
                builder.field(Fields.SKEWNESS, results.getSkewness(fieldName));
            }
        if (results == null) {
 * The OpenSearch Contributors require contributions made to  
                for (String fieldB : results.getFieldCounts().keySet()) {  
                    throw new IllegalArgumentException("Found unknown path element [" + element + "] in [" + getName() + "]");  
    public double getKurtosis(String field) {  
        String[] fieldNames  
    private final String[] fieldNames;  
        }  
        stats = in.readOptionalWriteable(RunningStats::new);
import org.opensearch.core.common.io.stream.StreamInput;  
                builder.field(Fields.COUNT, results.getFieldCount(fieldName));
    }
import java.util.Map;
        out.writeOptionalWriteable(stats);
        }  
    public boolean equals(Object obj) {
                case "kurtosis":
        if (aggs.isEmpty()) {
        }  
                builder.startObject(Fields.COVARIANCE);
    @Override
        RunningStats multiFieldStatsResults,  
            String element = path.get(0);
 * Licensed to Elasticsearch under one or more contributor  
    public double getMean(String field) {  
    }
        assert count >= 0;  
    public int hashCode() {  
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
    }
    ) {
        }
                case "covariance":
/*
    public double getCorrelation(String fieldX, String fieldY) {  
        }  
                builder.field(Fields.MEAN, results.getMean(fieldName));  
        }
                }
        if (results == null) {
        public static final String FIELDS = "fields";
        this.stats = multiFieldStatsResults;
        if (results != null && results.getFieldCounts().keySet().isEmpty() == false) {  
        return results.getSkewness(field);
                // skewness  
        }
                    builder.field(fieldB, results.getCovariance(fieldName, fieldB));
        public static final String KURTOSIS = "kurtosis";
            MatrixStatsResults results = new MatrixStatsResults(runningStats);  
        public static final String NAME = "name";
        return builder;
    @Override
    }
        return stats;
        return stats.docCount;
package org.opensearch.search.aggregations.matrix.stats;
 * specific language governing permissions and limitations
    public double getSkewness(String field) {  
            return 0;
 */  
            return new InternalMatrixStats(name, results.getDocCount(), runningStats, results, getMetadata(), fieldNames);
        String name,
        if (results == null) {
                    return results.getMeans();  
    /** get the number of samples for the given field. == docCount - numMissing */
                    builder.field(fieldB, results.getCorrelation(fieldName, fieldB));
    @Override
                case "correlation":  
    /** get the distribution skewness for the given field */
    private final RunningStats stats;  
 * compatible open source license.
            }
 * KIND, either express or implied.  See the License for the
    @Override
            return Double.NaN;
        return Objects.equals(this.stats, other.stats) && Objects.equals(this.results, other.results);
            runningStats.merge(((InternalMatrixStats) agg).stats);
    @Override
    }  
 */
            return Double.NaN;
        public static final String COVARIANCE = "covariance";
        return results;  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
     */
    @Override
    public long getDocCount() {  
                return emptyMap();  
                case "variances":
        public static final String MEAN = "mean";
import org.opensearch.search.aggregations.InternalAggregation;  
    }
    /**  
        public static final String SKEWNESS = "skewness";  
        for (InternalAggregation agg : aggs) {
                // covariance
            fieldNames = null;
                default:
                    return results.getFieldCounts();
 * Computes distribution statistics over multiple fields
        // return empty result iff all stats are null
        return true;
                case "counts":  
                builder.field(Fields.NAME, fieldName);
    }
                // mean
