            throw new IllegalArgumentException("field " + fieldName + " does not exist");
/*
    }
    @Override
    public double getVariance(String field) {
import org.opensearch.core.xcontent.XContentParser;
    }
    private long docCount;
                        }
        aggregation.setName(name);
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        if (counts.containsKey(field) == false) {
    @Override
            }, (p, c) -> p.mapOrdered(), new ParseField(InternalMatrixStats.Fields.CORRELATION));
                result.correlations = new LinkedHashMap<>(correls.size());
        }
            builder.endArray();
    private final Map<String, Double> means = new HashMap<>();
        static ParsedMatrixStatsResult fromXContent(XContentParser parser) throws IOException {
                result.covariances = new LinkedHashMap<>(covars.size());
                new ParseField(InternalMatrixStats.Fields.KURTOSIS)
    public long getFieldCount(String field) {
        return MatrixStatsAggregationBuilder.NAME;
        return MatrixStatsResults.getValFromUpperTriangularMatrix(covariances, fieldX, fieldY);
 * You may obtain a copy of the License at
}
    @Override
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
 * SPDX-License-Identifier: Apache-2.0
    public String getType() {
 * this file be licensed under the Apache-2.0 license or a
 * under the License.
                (result, skewness) -> result.skewness = skewness,
        PARSER.declareLong(ParsedMatrixStats::setDocCount, CommonFields.DOC_COUNT);
 * specific language governing permissions and limitations
                new ParseField(InternalMatrixStats.Fields.SKEWNESS)
                    if (covars != null) {
            return 1.0;
 * Unless required by applicable law or agreed to in writing,
            return 0;
 * not use this file except in compliance with the License.
        static {
                builder.field(InternalMatrixStats.Fields.COUNT, getFieldCount(fieldName));
        Double kurtosis;
    private static final ObjectParser<ParsedMatrixStats, Void> PARSER = new ObjectParser<>(
                builder.endObject();
    public double getCorrelation(String fieldX, String fieldY) {
        private static Double mapValueAsDouble(Object value) {
    private final Map<String, Double> skewness = new HashMap<>();
                matrixStats.correlations.put(fieldName, result.correlations);
public class ParsedMatrixStats extends ParsedAggregation implements MatrixStats {
 */
                return doubleValue;
                for (Map.Entry<String, Object> covar : covars.entrySet()) {
                matrixStats.covariances.put(fieldName, result.covariances);
/*
    }
        ParsedMatrixStats::new
                matrixStats.means.put(fieldName, result.mean);
 *
            return Double.valueOf(Objects.toString(value));
                builder.field(InternalMatrixStats.Fields.KURTOSIS, getKurtosis(fieldName));
import org.opensearch.core.xcontent.XContentBuilder;
    }
        }
    }
    @Override
    }
            ParsedMatrixStatsResult.class.getSimpleName(),
        PARSER.declareObjectArray((matrixStats, results) -> {
                }
                    builder.startObject(InternalMatrixStats.Fields.CORRELATION);
    @Override
            RESULT_PARSER.declareDouble(
        }
                final String fieldName = result.name;
        this.docCount = docCount;
    @Override
 * KIND, either express or implied.  See the License for the
    static {
    public double getMean(String field) {
        return counts.get(field);
        );
        if (fieldName == null) {
                new ParseField(InternalMatrixStats.Fields.VARIANCE)
/*
                builder.field(InternalMatrixStats.Fields.SKEWNESS, getSkewness(fieldName));
    public double getCovariance(String fieldX, String fieldY) {
            true,
        String name;
        if (fieldX.equals(fieldY)) {
                builder.field(InternalMatrixStats.Fields.VARIANCE, getVariance(fieldName));
                matrixStats.kurtosis.put(fieldName, result.kurtosis);
            return RESULT_PARSER.parse(parser, null);
            }
                (result, kurtosis) -> result.kurtosis = kurtosis,
import java.util.Map;
        return builder;
        if (values.containsKey(fieldName) == false) {
    }
                    Map<String, Double> correls = correlations.get(fieldName);
import java.util.Objects;
    }
            RESULT_PARSER.declareString((result, name) -> result.name = name, new ParseField(InternalMatrixStats.Fields.NAME));
            throw new IllegalArgumentException("field name cannot be null");
    }
        declareAggregationFields(PARSER);
            RESULT_PARSER.declareDouble(
            );
            ParsedMatrixStatsResult::new
        return docCount;
                }
                matrixStats.variances.put(fieldName, result.variance);
                    builder.endObject();
    private void setDocCount(long docCount) {
            RESULT_PARSER.declareDouble((result, mean) -> result.mean = mean, new ParseField(InternalMatrixStats.Fields.MEAN));
 *
        return checkedGet(means, field);
                {
                    builder.endObject();
        }
        Double mean;
 * Licensed to Elasticsearch under one or more contributor
            for (String fieldName : counts.keySet()) {
import org.opensearch.core.xcontent.ObjectParser;
    public double getSkewness(String field) {
    }
        return aggregation;
 * Modifications Copyright OpenSearch Contributors. See
 */
        Map<String, Double> covariances;
                (result, variance) -> result.variance = variance,
    private final Map<String, Map<String, Double>> covariances = new HashMap<>();
            builder.startArray(InternalMatrixStats.Fields.FIELDS);
            }
import java.io.IOException;
        Long count;
            RESULT_PARSER.declareLong((result, count) -> result.count = count, new ParseField(InternalMatrixStats.Fields.COUNT));
    public static ParsedMatrixStats fromXContent(XContentParser parser, String name) throws IOException {
            );
    );
            RESULT_PARSER.declareDouble(
 * software distributed under the License is distributed on an
                    }
            RESULT_PARSER.declareObject((ParsedMatrixStatsResult result, Map<String, Object> correls) -> {
            RESULT_PARSER.declareObject((ParsedMatrixStatsResult result, Map<String, Object> covars) -> {
    }
        return checkedGet(kurtosis, field);
import java.util.HashMap;
    @Override
    private final Map<String, Long> counts = new LinkedHashMap<>();
 */
                    }
                        }
    static class ParsedMatrixStatsResult {
        }, (p, c) -> ParsedMatrixStatsResult.fromXContent(p), new ParseField(InternalMatrixStats.Fields.FIELDS));
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                matrixStats.skewness.put(fieldName, result.skewness);
import org.opensearch.core.ParseField;
                builder.field(InternalMatrixStats.Fields.NAME, fieldName);
 *
                    result.covariances.put(covar.getKey(), mapValueAsDouble(covar.getValue()));
    }
        return MatrixStatsResults.getValFromUpperTriangularMatrix(correlations, fieldX, fieldY);
    }
        }
        return checkedGet(skewness, field);
    @Override
 * compatible open source license.
        if (fieldX.equals(fieldY)) {
import org.opensearch.search.aggregations.ParsedAggregation;
        Double variance;
                }
    private final Map<String, Double> variances = new HashMap<>();
            );
        ParsedMatrixStats.class.getSimpleName(),
        private static final ObjectParser<ParsedMatrixStatsResult, Void> RESULT_PARSER = new ObjectParser<>(
        return checkedGet(variances, field);
import java.util.LinkedHashMap;
        }
                    builder.startObject(InternalMatrixStats.Fields.COVARIANCE);
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    Map<String, Double> covars = covariances.get(fieldName);
    private final Map<String, Double> kurtosis = new HashMap<>();
        return values.get(fieldName);
        ParsedMatrixStats aggregation = PARSER.parse(parser, null);
 * ownership. Elasticsearch licenses this file to you under
            return checkedGet(variances, fieldX);
                for (Map.Entry<String, Object> correl : correls.entrySet()) {
                        for (Map.Entry<String, Double> correl : correls.entrySet()) {
                    if (correls != null) {
                builder.startObject();
 * GitHub history for details.
    public long getDocCount() {
 * license agreements. See the NOTICE file distributed with
    }
                }
            }, (p, c) -> p.mapOrdered(), new ParseField(InternalMatrixStats.Fields.COVARIANCE));
                            builder.field(covar.getKey(), covar.getValue());
        }
                    result.correlations.put(correl.getKey(), mapValueAsDouble(correl.getValue()));
    @Override
package org.opensearch.search.aggregations.matrix.stats;
        true,
            if (value instanceof Double doubleValue) {
    }
    private static <T> T checkedGet(final Map<String, T> values, final String fieldName) {
            for (ParsedMatrixStatsResult result : results) {
                            builder.field(correl.getKey(), correl.getValue());
        if (counts != null && counts.isEmpty() == false) {
 * the Apache License, Version 2.0 (the "License"); you may
                {
        Map<String, Double> correlations;
    public double getKurtosis(String field) {
        Double skewness;
 * this work for additional information regarding copyright
                builder.field(InternalMatrixStats.Fields.MEAN, getMean(fieldName));
    private final Map<String, Map<String, Double>> correlations = new HashMap<>();
 * The OpenSearch Contributors require contributions made to
                        for (Map.Entry<String, Double> covar : covars.entrySet()) {
    @Override
                matrixStats.counts.put(fieldName, result.count);
