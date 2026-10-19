 * under the License.  
    }
        // marshall correlation
            results.kurtosis.put(fieldName, (double) results.docCount * results.kurtosis.get(fieldName) / (var * var));  
 * Descriptive stats gathered per shard. Coordinating node computes final pearson product coefficient  
            final double var = results.variances.get(fieldName);
        }  
        for (String fieldName : results.means.keySet()) {
    }
        return getMapHelper(results, results.kurtosis, results.kurtosisArr);
                // fieldY exists as a col key to fieldX
    /** return the skewness for the requested field */
            } else {
        checkField(field, skewness);
                    cor = Double.NaN;  
    @Override  
    }
            results.skewness.put(fieldName, Math.sqrt(results.docCount) * results.skewness.get(fieldName) / Math.pow(var, 1.5D));
        if (results.usesMaps()) {
import org.opensearch.OpenSearchException;  
    public Double getCorrelation(String fieldX, String fieldY) {
 * based on these descriptive stats
    /** return the field counts - not public, used for getProperty() */
        if (o == null || getClass() != o.getClass()) return false;  
        Map<String, Double> skewness = getSkewness();  
            checkField(fieldX, variances);
            // update variances
 * specific language governing permissions and limitations
    /** return the kurtosis */
    }
    private Map<String, Double> getMapHelper(RunningStats results, Map<String, Double> map, double[] array) {
        return kurtosis.get(field);
        if (fieldX.equals(fieldY)) {
            // fieldX did not exist as a row key, it must be a col key  
            return 0;
import java.io.IOException;
class MatrixStatsResults implements Writeable {  
    @Override
    }
            if (map.get(fieldX).containsKey(fieldY)) {
    /** return the correlation coefficient between two fields */
    /** object holding results - computes results in place */
/*  
        return getMapHelper(results, results.skewness, results.skewnessArr);
        }  
    @SuppressWarnings("unchecked")
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
    protected Map<String, Map<String, Double>> getCovariances() {  
                    cor = covRow.get(colName) / corDen;  
    protected Map<String, Long> getFieldCounts() {  
        if (this == o) return true;
                covRow.put(colName, covRow.get(colName) / nM1);
        }  
    public double getCovariance(String fieldX, String fieldY) {
    }  
            throw new OpenSearchException("Error trying to create multifield_stats results from stream input", e);
    /** pearson product correlation coefficients */  
                // update covariance
        return results.docCount;
        try {
        this.results = stats.clone();
        this.compute();
                final String colName = col.getKey();  
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object o) {
    }
        return variances.get(field);
        return Collections.unmodifiableMap(results.covariances);
            }
    /** Base ctor */  
        return getValFromUpperTriangularMatrix(correlation, fieldX, fieldY);  
 *
        return skewness.get(field);
    protected MatrixStatsResults(StreamInput in) {  
    }
    /** Marshalls MatrixStatsResults */  
            // update skewness  
        Map<String, Double> kurtosis = getKurtosis();  
            final String rowName = row.getKey();
        return means.get(field);
                // update correlation  
 */
    protected final Map<String, Map<String, Double>> correlation;
 * not use this file except in compliance with the License.
        checkField(field, variances);
                if (results.variances.get(rowName) == 0d || results.variances.get(colName) == 0d) {
        return Collections.unmodifiableMap(correlation);
            // update kurtosis
    private void compute() {
    public int hashCode() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /** Computes final covariance, variance, and correlation */  
        MatrixStatsResults that = (MatrixStatsResults) o;
    }
        return getValFromUpperTriangularMatrix(getCovariances(), fieldX, fieldY);
        }
                return map.get(fieldY).get(fieldX);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.correlation = new HashMap<>();  
import java.util.HashMap;
        } else if (map.containsKey(fieldX)) {
        // marshall results  
        }  
import java.util.Map;
        if (!results.usesMaps()) {
        results.writeTo(out);
    /** return the means - not public, used for getProperty() */
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Objects;  
    }  
                } else {
        if (results.usesMaps()) {
    protected Map<String, Double> getKurtosis() {  
        }
            // fieldX exists as a row key  
    }
        Map<String, Double> variances = getVariances();  
                // if there is no variance in the data then correlation is NaN
 *  
            return Collections.unmodifiableMap(results.counts);
    }  
 */
    protected final RunningStats results;
    }  
    public void writeTo(StreamOutput out) throws IOException {
        throw new IllegalArgumentException("Coefficient not computed between fields: " + fieldX + " and " + fieldY);  
    }  
    }
/**
        return Objects.hash(results, correlation);
        this.correlation = new HashMap<>();  
            results.covariances.put(rowName, covRow);
}  
    }
        }  
        results = new RunningStats(fieldNames);
        return Collections.unmodifiableMap(results.convertDoubleArrayToMap(array));
        if (map.containsKey(field) == false) {
        if (counts.containsKey(field) == false) {
    private void checkField(String field, Map<String, ?> map) {  
 * this file be licensed under the Apache-2.0 license or a
 */
    public double getMean(String field) {
                    final double corDen = Math.sqrt(results.variances.get(rowName)) * Math.sqrt(results.variances.get(colName));
        return Collections.unmodifiableMap(results.convertLongArrayToMap(results.countsArr));
    }
    /** return the covariances as a map - not public, used for getProperty() */
    MatrixStatsResults(String[] fieldNames) {
    public final long getDocCount() {
            correlation = (Map<String, Map<String, Double>>) in.readGenericValue();  
/*
        }
    /** return the value for two fields in an upper triangular matrix, regardless of row col location. */  
    /** return the variance for the requested field */
        return getMapHelper(results, results.variances, results.variancesArr);
                return map.get(fieldX).get(fieldY);  
    /** return the field count for the requested field */
        Map<String, Double> variances = getVariances();  
import org.opensearch.core.common.io.stream.StreamOutput;
            for (Map.Entry<String, Double> col : covRow.entrySet()) {
            throw new IllegalArgumentException("neither field " + fieldX + " nor " + fieldY + " exist");
        checkField(field, kurtosis);
        return Objects.equals(results, that.results) && Objects.equals(correlation, that.correlation);
    /** return the correlations as a map - not public, used for getProperty() */
                corRow.put(colName, cor);
    }
        for (Map.Entry<String, Map<String, Double>> row : results.covariances.entrySet()) {
    }
            final Map<String, Double> covRow = row.getValue();  
        if (field == null) {
        // compute final skewness and kurtosis  
        }
 * GitHub history for details.
        if (map.containsKey(fieldX) == false && map.containsKey(fieldY) == false) {  
    protected Map<String, Double> getSkewness() {  
            correlation.put(rowName, corRow);
                }
        Map<String, Long> counts = getFieldCounts();  
            return map.get(fieldY).get(fieldX);
    /** return the skewness - not public, used for getProperty() */
    /** return the mean for the requested field */
import org.opensearch.core.common.io.stream.StreamInput;
    /** creates and computes result from provided stats */  
        } catch (IOException e) {
            final Map<String, Double> corRow = new HashMap<>();
    /** creates a results object from the given stream */
            return variances.get(fieldX);  
package org.opensearch.search.aggregations.matrix.stats;
    MatrixStatsResults(RunningStats stats) {
    protected Map<String, Map<String, Double>> getCorrelations() {  
        return counts.get(field);
            throw new IllegalArgumentException("field " + field + " does not exist");
        // compute final covariances and correlation
 *
 * compatible open source license.
    public double getVariance(String field) {
 */  
 * this work for additional information regarding copyright
        checkField(field, means);
        if (fieldX.equals(fieldY)) {  
 * ownership. Elasticsearch licenses this file to you under  
            }  
    }  
    /** return document count */  
 * You may obtain a copy of the License at  
    /** return the variances - not public, used for getProperty() */
            results = new RunningStats(in);
    public double getKurtosis(String field) {
        // for the co-value to exist, one of the two (or both) fields has to be a row key
        double cor;  
    /** return the covariance between two fields */
        }  
    }
    protected Map<String, Double> getVariances() {  
 * Unless required by applicable law or agreed to in writing,
            results.switchToMaps();  
import org.opensearch.core.common.io.stream.Writeable;  
    }
        Map<String, Double> means = getMeans();  
                // otherwise fieldX is the col key to fieldY
        } else if (map.containsKey(fieldY)) {
    public long getFieldCount(String field) {
 * SPDX-License-Identifier: Apache-2.0
        final double nM1 = results.docCount - 1D;
 * software distributed under the License is distributed on an
        return getMapHelper(results, results.means, results.meansArr);
    }  
        }
    }
            throw new IllegalArgumentException("field name cannot be null");
        out.writeGenericValue(correlation);  
    protected Map<String, Double> getMeans() {  
            return Collections.unmodifiableMap(map);  
 * Modifications Copyright OpenSearch Contributors. See  
    /** return the kurtosis for the requested field */
    @Override
            results.variances.put(fieldName, results.variances.get(fieldName) / nM1);
/*
import java.util.Collections;  
    }  
        }  
    public double getSkewness(String field) {
    static <M extends Map<String, Double>> double getValFromUpperTriangularMatrix(Map<String, M> map, String fieldX, String fieldY) {
            return 1.0;
 * license agreements. See the NOTICE file distributed with
