 * KIND, either express or implied.  See the License for the
    }
        // marshall results
    /** return the correlation coefficient between two fields */
    /** Base ctor */
    public final long getDocCount() {
        if (this == o) return true;
        return Collections.unmodifiableMap(correlation);
 * You may obtain a copy of the License at
    protected final Map<String, Map<String, Double>> correlation;
        if (!results.usesMaps()) {
    /** return the field count for the requested field */
        return getMapHelper(results, results.means, results.meansArr);
            return Collections.unmodifiableMap(map);
        return counts.get(field);
    /** return the skewness - not public, used for getProperty() */
    public boolean equals(Object o) {
    }
            for (Map.Entry<String, Double> col : covRow.entrySet()) {
        final double nM1 = results.docCount - 1D;
                // update correlation
            } else {
    }
            if (map.get(fieldX).containsKey(fieldY)) {
        } else if (map.containsKey(fieldY)) {
        return Collections.unmodifiableMap(results.convertDoubleArrayToMap(array));
        }
    public Double getCorrelation(String fieldX, String fieldY) {
    /** return the field counts - not public, used for getProperty() */
    protected Map<String, Long> getFieldCounts() {
import java.util.Collections;
import java.util.HashMap;
            throw new IllegalArgumentException("field " + field + " does not exist");
        return means.get(field);
    /** object holding results - computes results in place */
                covRow.put(colName, covRow.get(colName) / nM1);
        if (fieldX.equals(fieldY)) {
    }
    }
        return Objects.equals(results, that.results) && Objects.equals(correlation, that.correlation);
 * Modifications Copyright OpenSearch Contributors. See
            correlation.put(rowName, corRow);
    public double getVariance(String field) {
    }
            final double var = results.variances.get(fieldName);
    }
    protected Map<String, Double> getKurtosis() {
    static <M extends Map<String, Double>> double getValFromUpperTriangularMatrix(Map<String, M> map, String fieldX, String fieldY) {
            return map.get(fieldY).get(fieldX);
    /** return the means - not public, used for getProperty() */
    }
 * Licensed to Elasticsearch under one or more contributor
            final String rowName = row.getKey();
    }
        checkField(field, kurtosis);
            final Map<String, Double> covRow = row.getValue();
    MatrixStatsResults(String[] fieldNames) {
        return getMapHelper(results, results.variances, results.variancesArr);
 */
        Map<String, Double> variances = getVariances();
        if (map.containsKey(fieldX) == false && map.containsKey(fieldY) == false) {
                    cor = covRow.get(colName) / corDen;
    }
            // update skewness
        results = new RunningStats(fieldNames);
    protected MatrixStatsResults(StreamInput in) {
    /** return document count */
                }
    /** Marshalls MatrixStatsResults */
    /** return the kurtosis for the requested field */
    }
        this.results = stats.clone();
            final Map<String, Double> corRow = new HashMap<>();
    /** pearson product correlation coefficients */
 *
 * this file be licensed under the Apache-2.0 license or a
    }
            correlation = (Map<String, Map<String, Double>>) in.readGenericValue();
    private void checkField(String field, Map<String, ?> map) {
        }
    private void compute() {
 * the Apache License, Version 2.0 (the "License"); you may
    }
        // marshall correlation
        if (fieldX.equals(fieldY)) {
    /** return the skewness for the requested field */
/*
        Map<String, Double> kurtosis = getKurtosis();
        checkField(field, means);
        }
                corRow.put(colName, cor);
        return variances.get(field);
                final String colName = col.getKey();
            results.covariances.put(rowName, covRow);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            results.switchToMaps();
                if (results.variances.get(rowName) == 0d || results.variances.get(colName) == 0d) {
        }
    /** creates and computes result from provided stats */
                    final double corDen = Math.sqrt(results.variances.get(rowName)) * Math.sqrt(results.variances.get(colName));
        }
    @Override
 * The OpenSearch Contributors require contributions made to
    /** Computes final covariance, variance, and correlation */
import org.opensearch.core.common.io.stream.Writeable;
/*
 * compatible open source license.
    }
        results.writeTo(out);
            return variances.get(fieldX);
                return map.get(fieldY).get(fieldX);
    }
    protected final RunningStats results;
 *    http://www.apache.org/licenses/LICENSE-2.0
                return map.get(fieldX).get(fieldY);
        return getValFromUpperTriangularMatrix(getCovariances(), fieldX, fieldY);
 * software distributed under the License is distributed on an
        return Collections.unmodifiableMap(results.covariances);
            throw new IllegalArgumentException("neither field " + fieldX + " nor " + fieldY + " exist");
    public double getMean(String field) {
}
        }
    @Override
    @Override
    /** return the correlations as a map - not public, used for getProperty() */
            // update variances
                // update covariance
        double cor;
        checkField(field, skewness);
            results.skewness.put(fieldName, Math.sqrt(results.docCount) * results.skewness.get(fieldName) / Math.pow(var, 1.5D));
    }
        if (o == null || getClass() != o.getClass()) return false;
    private Map<String, Double> getMapHelper(RunningStats results, Map<String, Double> map, double[] array) {
                // otherwise fieldX is the col key to fieldY
 *
        return getMapHelper(results, results.skewness, results.skewnessArr);
    public int hashCode() {
            checkField(fieldX, variances);
        return skewness.get(field);
            return Collections.unmodifiableMap(results.counts);
 * license agreements. See the NOTICE file distributed with
        this.compute();
    public long getFieldCount(String field) {
 */
    /** return the mean for the requested field */
        for (String fieldName : results.means.keySet()) {
            // fieldX did not exist as a row key, it must be a col key
    public double getKurtosis(String field) {
    protected Map<String, Double> getSkewness() {
    }
    /** creates a results object from the given stream */
            }
            results.kurtosis.put(fieldName, (double) results.docCount * results.kurtosis.get(fieldName) / (var * var));
        }
    /** return the value for two fields in an upper triangular matrix, regardless of row col location. */
        throw new IllegalArgumentException("Coefficient not computed between fields: " + fieldX + " and " + fieldY);
 */
 * Unless required by applicable law or agreed to in writing,
        if (results.usesMaps()) {
        // for the co-value to exist, one of the two (or both) fields has to be a row key
import java.io.IOException;
        // compute final covariances and correlation
        checkField(field, variances);
                // if there is no variance in the data then correlation is NaN
        // compute final skewness and kurtosis
        for (Map.Entry<String, Map<String, Double>> row : results.covariances.entrySet()) {
 * GitHub history for details.
    }
        return Collections.unmodifiableMap(results.convertLongArrayToMap(results.countsArr));
package org.opensearch.search.aggregations.matrix.stats;
        this.correlation = new HashMap<>();
import org.opensearch.core.common.io.stream.StreamOutput;
    }
import java.util.Map;
    /** return the kurtosis */
import org.opensearch.OpenSearchException;
                    cor = Double.NaN;
        }
            // fieldX exists as a row key
 *
        return Objects.hash(results, correlation);
    MatrixStatsResults(RunningStats stats) {
 * Descriptive stats gathered per shard. Coordinating node computes final pearson product coefficient
 */
            return 0;
    protected Map<String, Double> getMeans() {
    /** return the variance for the requested field */
        } catch (IOException e) {
                } else {
    @SuppressWarnings("unchecked")
    protected Map<String, Map<String, Double>> getCorrelations() {
 * SPDX-License-Identifier: Apache-2.0
    }
        if (map.containsKey(field) == false) {
        }
/*
        } else if (map.containsKey(fieldX)) {
        }
        return results.docCount;
            throw new OpenSearchException("Error trying to create multifield_stats results from stream input", e);
    protected Map<String, Double> getVariances() {
 * this work for additional information regarding copyright
            // update kurtosis
            }
            results = new RunningStats(in);
 * not use this file except in compliance with the License.
    /** return the covariance between two fields */
        if (results.usesMaps()) {
        }
    public double getCovariance(String fieldX, String fieldY) {
        return getValFromUpperTriangularMatrix(correlation, fieldX, fieldY);
        if (counts.containsKey(field) == false) {
    protected Map<String, Map<String, Double>> getCovariances() {
class MatrixStatsResults implements Writeable {
        Map<String, Double> skewness = getSkewness();
            throw new IllegalArgumentException("field name cannot be null");
    public double getSkewness(String field) {
import org.opensearch.core.common.io.stream.StreamInput;
        this.correlation = new HashMap<>();
    }
    }
                // fieldY exists as a col key to fieldX
        try {
 * based on these descriptive stats
    public void writeTo(StreamOutput out) throws IOException {
    }
    }
        Map<String, Double> variances = getVariances();
/**
    /** return the variances - not public, used for getProperty() */
            results.variances.put(fieldName, results.variances.get(fieldName) / nM1);
 * specific language governing permissions and limitations
import java.util.Objects;
        if (field == null) {
        out.writeGenericValue(correlation);
    /** return the covariances as a map - not public, used for getProperty() */
        MatrixStatsResults that = (MatrixStatsResults) o;
        Map<String, Long> counts = getFieldCounts();
 * under the License.
        return getMapHelper(results, results.kurtosis, results.kurtosisArr);
        return kurtosis.get(field);
            return 1.0;
    }
 * ownership. Elasticsearch licenses this file to you under
        Map<String, Double> means = getMeans();
