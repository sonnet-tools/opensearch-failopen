        if (fieldName == null) {
public class ParsedMatrixStats extends ParsedAggregation implements MatrixStats {
import java.util.HashMap;
                result.correlations = new LinkedHashMap<>(correls.size());
        true,  
                        for (Map.Entry<String, Double> correl : correls.entrySet()) {
        private static Double mapValueAsDouble(Object value) {
                builder.field(InternalMatrixStats.Fields.KURTOSIS, getKurtosis(fieldName));
        }
                new ParseField(InternalMatrixStats.Fields.KURTOSIS)
    public long getDocCount() {
    private final Map<String, Double> kurtosis = new HashMap<>();
    public double getCovariance(String fieldX, String fieldY) {
                builder.field(InternalMatrixStats.Fields.COUNT, getFieldCount(fieldName));
        }  
    }
    }  
 *  
                }
        if (counts.containsKey(field) == false) {
    private final Map<String, Double> means = new HashMap<>();
        private static final ObjectParser<ParsedMatrixStatsResult, Void> RESULT_PARSER = new ObjectParser<>(
        if (fieldX.equals(fieldY)) {  
            builder.endArray();
    private final Map<String, Map<String, Double>> covariances = new HashMap<>();
import org.opensearch.search.aggregations.ParsedAggregation;
 */  
        this.docCount = docCount;
    @Override
                            builder.field(covar.getKey(), covar.getValue());
    }
import org.opensearch.core.xcontent.XContentBuilder;  
 * under the License.  
        Map<String, Double> covariances;
    public double getMean(String field) {  
                matrixStats.means.put(fieldName, result.mean);
            return RESULT_PARSER.parse(parser, null);
    }
 * this file be licensed under the Apache-2.0 license or a
            RESULT_PARSER.declareDouble(
        return counts.get(field);
        ParsedMatrixStats.class.getSimpleName(),
        PARSER.declareLong(ParsedMatrixStats::setDocCount, CommonFields.DOC_COUNT);
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 *
                for (Map.Entry<String, Object> correl : correls.entrySet()) {
 * compatible open source license.
        return aggregation;
 * this work for additional information regarding copyright
        Double skewness;
    public double getCorrelation(String fieldX, String fieldY) {
        }
                    builder.endObject();  
    }
        return checkedGet(skewness, field);
                    if (covars != null) {  
                matrixStats.kurtosis.put(fieldName, result.kurtosis);
        String name;
            throw new IllegalArgumentException("field name cannot be null");
    private void setDocCount(long docCount) {  
    }
    public long getFieldCount(String field) {
        Double mean;  
        }
                }  
 * license agreements. See the NOTICE file distributed with
        declareAggregationFields(PARSER);
    @Override
            RESULT_PARSER.declareDouble(  
        }  
        return checkedGet(kurtosis, field);
                (result, variance) -> result.variance = variance,
    @Override
        if (values.containsKey(fieldName) == false) {
    private static final ObjectParser<ParsedMatrixStats, Void> PARSER = new ObjectParser<>(
                builder.startObject();
        Double kurtosis;  
                    if (correls != null) {
 * Unless required by applicable law or agreed to in writing,
            return 0;  
        aggregation.setName(name);
                matrixStats.skewness.put(fieldName, result.skewness);  
                    }
        );
                {  
                        }
            builder.startArray(InternalMatrixStats.Fields.FIELDS);  
                    builder.endObject();
    }
 * not use this file except in compliance with the License.
                return doubleValue;
        return MatrixStatsResults.getValFromUpperTriangularMatrix(covariances, fieldX, fieldY);  
    @Override
        PARSER.declareObjectArray((matrixStats, results) -> {  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    public double getVariance(String field) {
        }  
            return 1.0;  
    }  
                    result.covariances.put(covar.getKey(), mapValueAsDouble(covar.getValue()));
        return MatrixStatsResults.getValFromUpperTriangularMatrix(correlations, fieldX, fieldY);
                matrixStats.covariances.put(fieldName, result.covariances);
    );
        }, (p, c) -> ParsedMatrixStatsResult.fromXContent(p), new ParseField(InternalMatrixStats.Fields.FIELDS));
            }, (p, c) -> p.mapOrdered(), new ParseField(InternalMatrixStats.Fields.COVARIANCE));
                (result, kurtosis) -> result.kurtosis = kurtosis,
            ParsedMatrixStatsResult.class.getSimpleName(),
            );
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
            );
        Long count;
    private final Map<String, Long> counts = new LinkedHashMap<>();  
    @Override  
                }  
    @Override
                (result, skewness) -> result.skewness = skewness,  
                }
        if (counts != null && counts.isEmpty() == false) {
    }  
import org.opensearch.core.ParseField;
import org.opensearch.core.xcontent.XContentParser;
        static ParsedMatrixStatsResult fromXContent(XContentParser parser) throws IOException {  
                builder.field(InternalMatrixStats.Fields.NAME, fieldName);  
 * SPDX-License-Identifier: Apache-2.0
                            builder.field(correl.getKey(), correl.getValue());  
            RESULT_PARSER.declareObject((ParsedMatrixStatsResult result, Map<String, Object> correls) -> {  
            for (String fieldName : counts.keySet()) {
    }  
}
                    builder.startObject(InternalMatrixStats.Fields.COVARIANCE);
 * GitHub history for details.
 *
                {
import java.util.Objects;
/*  
            );  
            RESULT_PARSER.declareDouble((result, mean) -> result.mean = mean, new ParseField(InternalMatrixStats.Fields.MEAN));  
            ParsedMatrixStatsResult::new
    }  
                builder.field(InternalMatrixStats.Fields.MEAN, getMean(fieldName));
            RESULT_PARSER.declareLong((result, count) -> result.count = count, new ParseField(InternalMatrixStats.Fields.COUNT));
            }  
                for (Map.Entry<String, Object> covar : covars.entrySet()) {
                builder.endObject();
                    builder.startObject(InternalMatrixStats.Fields.CORRELATION);
            }
                        }  
                matrixStats.counts.put(fieldName, result.count);  
 */
    }
    @Override  
            RESULT_PARSER.declareString((result, name) -> result.name = name, new ParseField(InternalMatrixStats.Fields.NAME));
                matrixStats.correlations.put(fieldName, result.correlations);  
            throw new IllegalArgumentException("field " + fieldName + " does not exist");
            return checkedGet(variances, fieldX);
    private final Map<String, Double> skewness = new HashMap<>();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return checkedGet(variances, field);  
import java.util.LinkedHashMap;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
                new ParseField(InternalMatrixStats.Fields.VARIANCE)  
                    Map<String, Double> covars = covariances.get(fieldName);
            }, (p, c) -> p.mapOrdered(), new ParseField(InternalMatrixStats.Fields.CORRELATION));
            for (ParsedMatrixStatsResult result : results) {
        }
                final String fieldName = result.name;
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
    public double getSkewness(String field) {
    public static ParsedMatrixStats fromXContent(XContentParser parser, String name) throws IOException {
 */  
    public String getType() {
    static {  
                    }
 * software distributed under the License is distributed on an
    }
                result.covariances = new LinkedHashMap<>(covars.size());  
            RESULT_PARSER.declareObject((ParsedMatrixStatsResult result, Map<String, Object> covars) -> {
                        for (Map.Entry<String, Double> covar : covars.entrySet()) {
 * You may obtain a copy of the License at  
        if (fieldX.equals(fieldY)) {
    public double getKurtosis(String field) {  
/*  
import java.util.Map;
package org.opensearch.search.aggregations.matrix.stats;
        return docCount;  
    private long docCount;
            }
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
        return builder;  
                matrixStats.variances.put(fieldName, result.variance);
        Double variance;
                    result.correlations.put(correl.getKey(), mapValueAsDouble(correl.getValue()));  
        Map<String, Double> correlations;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
            return Double.valueOf(Objects.toString(value));  
        return values.get(fieldName);
import org.opensearch.core.xcontent.ObjectParser;
    static class ParsedMatrixStatsResult {
            RESULT_PARSER.declareDouble(
        static {  
        }
    }  
                builder.field(InternalMatrixStats.Fields.SKEWNESS, getSkewness(fieldName));
        return MatrixStatsAggregationBuilder.NAME;  
                new ParseField(InternalMatrixStats.Fields.SKEWNESS)
    private final Map<String, Double> variances = new HashMap<>();
    private final Map<String, Map<String, Double>> correlations = new HashMap<>();  
                builder.field(InternalMatrixStats.Fields.VARIANCE, getVariance(fieldName));  
        ParsedMatrixStats::new
        ParsedMatrixStats aggregation = PARSER.parse(parser, null);  
            if (value instanceof Double doubleValue) {  
                    Map<String, Double> correls = correlations.get(fieldName);  
    private static <T> T checkedGet(final Map<String, T> values, final String fieldName) {  
    @Override
        return checkedGet(means, field);
 * ownership. Elasticsearch licenses this file to you under  
        }
            true,  
/*
    }
