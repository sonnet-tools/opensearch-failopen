        mergeMaps(other);  
    public void writeTo(StreamOutput out) throws IOException {  
        // merge count  
            newSkew = skewA + skewB + d3 * nA * nB * (nA - nB) / n2;
        // If at least one of the two RunningStats uses the maps impl, ensure both switch to it before merge  
            throw new IllegalArgumentException("Cannot add statistics without field names.");
            for (int i = 0; i < fieldNames.length; ++i) {  
            // update counts  
        final double nA = docCount;
            meanA = means.get(fieldName);  
            variancesArr[i] = varA + varB + d2 * nA * other.docCount / docCount;  
            // merge covariances  
        // merge count
                this.fieldSum.put(fieldName, other.fieldSum.get(fieldName).doubleValue());
        this.mergeCovarianceMaps(other, deltas);  
                for (String cFieldName : cFieldVals.keySet()) {  
            // update running mean, variance, skewness, kurtosis
            Map<String, Double> cFieldVals = (covariances.get(fieldName) != null) ? covariances.get(fieldName) : new HashMap<>();
        double f, dR, newVal;  
                    } else {
                for (int j = i + 1; j < fieldNames.length; j++) {
    protected double[] meansArr;
    }
            } else {
    /** skewness values (third moment) */  
        double fieldValue;
        final HashMap<String, Double> deltas = new HashMap<>();
        for (int i = 0; i < fieldNames.length; i++) {
 * software distributed under the License is distributed on an
            Arrays.hashCode(kurtosisArr),
                variances.put(fieldName, 0.0);
        }
        skewness = convertDoubleArrayToMap(skewnessArr);  
            // update running deltas
    }  
            this.meansArr = other.meansArr;  
                // update running means  
            for (int j = i + 1; j < fieldNames.length; j++) {  
        double d, dn, dn2, t1;
        }
                // update running variances
    void switchToArrays() {
    // or ones which have added one from an older version.
            // If we aren't using maps already we must convert to send. This will still be backwards compatible.
            kurtA = kurtosis.get(fieldName);  
        }
 *
/*
                } else {
                this.counts.put(fieldName, other.counts.get(fieldName).longValue());  
            meansArr = new double[fieldNames.length];
                innerMap.put(fieldNames[j], stats[i][j]);
        final double[] deltas = new double[fieldNames.length];  
        }
        // Switch from the fast primitive array implementation to the slower maps implementation.
            kurtosis.put(fieldName, nk + 6D * d2 * (nA2 * varB + nB2 * varA) / n2 + 4D * d * (nA * skewB - nB * skewA) / docCount);  
                d = fieldValue - m1;
                this.docCount = other.docCount;
        );
    /** Whether it uses the slow maps impl or not. If this is true, the Maps containing data are guaranteed to be non-null,  
    }  
        double d, dn, dn2, t1;  
            out.writeGenericValue(convertNestedDoubleArrayToMap(covariancesArr));
            final String fieldName = fs.getKey();
    protected double[] skewnessArr;  
    /** per field sum of observations */
            out.writeGenericValue(convertDoubleArrayToMap(kurtosisArr));
        // Always write as maps, which is how earlier versions did it. Receiving node will convert to arrays if needed.
            return;
            // update running sum
                if (other.covariances.containsKey(fieldName)) {
            fieldValue = fieldVals[i];
            d3 = d * d2;                // delta mean cubed  
                m1 = means.get(fieldName);
                kurtosisArr[i] += t1 * dn2 * (docCount * docCount - 3D * docCount + 3D) + 6D * dn2 * m2 - 4D * dn * m3;  
                // update running means  
            final String fieldName = fs.getKey();
    public void add(final String[] fn, final double[] fieldVals) {  
        covariances = (Map<String, Map<String, Double>>) in.readGenericValue();  
                && Objects.equals(counts, that.counts)  
     * and if it's false the arrays are guaranteed to be non-null after ctor returns.
            out.writeGenericValue(convertDoubleArrayToMap(meansArr));
        if (fieldNames == null) throw new IllegalArgumentException("Cannot convert to array impl if fieldNames is null");  
            out.writeGenericValue(means);
 * SPDX-License-Identifier: Apache-2.0
    }  
 * specific language governing permissions and limitations
import java.util.ArrayList;
            fieldSumArr[i] += fieldValue;  
            }
        skewnessArr = convertFieldDoubleMap(skewness);
 * based on these descriptive stats. This single pass, parallel approach is based on:
 * Licensed to Elasticsearch under one or more contributor  
            Arrays.hashCode(variancesArr),  
            result[i] = serializedMap.get(fieldNames[i]);  
        this.usesMaps = usesMaps;  
                means.put(fieldName, m1 + d / docCount);  
    // Old map-based values  
            result.put(fieldNames[i], stats[i]);
            result.put(fieldNames[i], innerMap);  
        }  
    private void mergeMaps(final RunningStats other) {  
            return (RunningStats) super.clone();
 */
    protected double[][] covariancesArr;
        return result;
        variances = convertDoubleArrayToMap(variancesArr);
            // merge means of two sets  
        double newSkew, nk;  
        final double nA = docCount;  
                m4 = t1 * dn2 * (docCount * docCount - 3D * docCount + 3D) + 6D * dn2 * m2 - 4D * dn * m3;  
            this.add(fieldNames, fieldVals);
            // merge totals  
    public void merge(final RunningStats other) {
        if (fieldVals != null && fieldVals.length > 0) {
    }  
            this.fieldNames = in.readOptionalStringArray();
                    cFieldVals.put(cFieldName, newVal);  
        if (usesMaps) {
 * Descriptive stats gathered per shard. Coordinating node computes final correlation and covariance stats  
        if (!Arrays.equals(other.fieldNames, fieldNames)) {  
            newSkew = skewA + skewB + d3 * nA * nB * (nA - nB) / n2;
            && Arrays.equals(countsArr, that.countsArr)  
            countsArr[i] += other.countsArr[i];
        }  
        means = convertDoubleArrayToMap(meansArr);
import org.opensearch.core.common.io.stream.Writeable;
                    covariancesArr[i][j] += intermediate;  
    protected long docCount = 0;
        }
            assert fieldNames != null;
                // update running skewnesses
        usesMaps = false;
import java.util.HashSet;
     * Merges the descriptive statistics of a second data set (e.g., per shard)  
        for (Map.Entry<String, Double> fs : other.means.entrySet()) {
            fieldSum.put(fieldName, fieldSum.get(fieldName) + other.fieldSum.get(fieldName));
    protected Map<String, Long> counts;
        fieldSum = (Map<String, Double>) in.readGenericValue();  
import java.util.Arrays;
            // update running covariances  
            }
            means = new HashMap<>();
                    this.covariances.put(fieldName, other.covariances.get(fieldName));  
    protected Map<String, Double> skewness;
    protected long[] countsArr;  
        double meanA, varA, skewA, kurtA, meanB, varB, skewB, kurtB;  
    protected Map<String, Double> means;  
    Map<String, Long> convertLongArrayToMap(long[] stats) {  
            fieldSum = new HashMap<>();  
    RunningStats(final String[] fieldNames, final double[] fieldVals) {  
            throw new IllegalArgumentException("Cannot merge RunningStats with different fieldNames");
            // merge counts of two sets  
                t1 = d * dn * (docCount - 1);  
            counts.put(fieldName, counts.get(fieldName) + other.counts.get(fieldName));
        if (docCount > 1) {
        return Objects.hash(
 * Map-based implementation is left here for backwards compatibility purposes. It's much faster to use
                kurtosis.put(fieldName, 0.0);  
     */
            means.put(fieldName, (nA * means.get(fieldName) + nB * other.means.get(fieldName)) / (nA + nB));
        if (!usesMaps) {
            covariances = new HashMap<>();
    /** variance values (second moment) */
                    newVal = cFieldVals.get(cFieldName);
        fieldSum = convertDoubleArrayToMap(fieldSumArr);
        for (Map.Entry<String, Double> fs : other.means.entrySet()) {
            result[i] = serializedMap.get(fieldNames[i]);  
            d2 = d * d;                 // delta mean squared
            return docCount == that.docCount
            if (means.containsKey(fieldName)) {
            out.writeGenericValue(fieldSum);
        }
            }
 * the Apache License, Version 2.0 (the "License"); you may
            nk = kurtA + kurtB + d4 * nA * nB * (nA2 - nA * nB + nB2) / (n2 * docCount);
    /** mean values (first moment) */
            nB2 = nB * nB;              // doc B num samples squared
            variances.put(fieldName, varA + varB + d2 * nA * other.docCount / docCount);  
            Map<String, Double> innerMap = new HashMap<>();
            skewness.put(fieldName, newSkew + 3D * d * (nA * varB - nB * varA) / docCount);  
            fieldSumArr[i] += other.fieldSumArr[i];
                if (cFieldVals.containsKey(cFieldName)) {
    private void mergeArrays(final RunningStats other) {  
        double newSkew, nk;
            skewnessArr[i] = newSkew + 3D * d * (nA * varB - nB * varA) / docCount;  
 * so we must revert to using maps. The same goes for any RunningStats that merges with these deserialized instances.
            throw new IllegalArgumentException("Number of field values do not match number of field names.");
            nA2 = nA * nA;              // doc A num samples squared  
            if (covariances.containsKey(fieldName)) {
            docCount,
        this.updateCovarianceMaps(fieldNames, deltas);
        Map<String, Long> result = new HashMap<>();
                final String fieldName = fs.getKey();
        docCount += other.docCount;
            for (String cFieldName : cFieldNames) {  
            out.writeGenericValue(convertDoubleArrayToMap(fieldSumArr));
        return docCount == that.docCount
    /** count of observations (same number of observations per field) */  
        countsArr = convertFieldLongMap(counts);
            variancesArr = new double[fieldNames.length];
                // update running variances
    RunningStats(final String[] fieldNames) {
            // merge means of two sets  
    }
            varA = variances.get(fieldName);
    Map<String, Double> convertDoubleArrayToMap(double[] stats) {
        }  
 * Unless required by applicable law or agreed to in writing,
            counts = new HashMap<>();
        for (int i = 0; i < fieldNames.length; ++i) {
            skewB = other.skewnessArr[i];  
            fieldSum.put(fieldName, fieldValue + (fieldSum.containsKey(fieldName) ? fieldSum.get(fieldName) : 0));  
            // merge covariances of two sets  
            nA2 = nA * nA;              // doc A num samples squared  
        means = (Map<String, Double>) in.readGenericValue();
    /** counts */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            switchToMaps();
            f = countA * other.docCount / this.docCount;
                covariances.put(fieldName, cFieldVals);  
        if (usesMaps) return;
        out.writeGenericValue(docCount);
        for (int i = 0; i < fieldNames.length; i++) {
            out.writeGenericValue(convertLongArrayToMap(countsArr));  
    public RunningStats(StreamInput in) throws IOException {
        final double[] deltas = new double[fieldNames.length];  
 */
                && Objects.equals(variances, that.variances)
    private void updateCovarianceMaps(final String[] fieldNames, final Map<String, Double> deltas) {
        }
        double[] result = new double[fieldNames.length];
/**
import org.opensearch.OpenSearchException;  
            } else {
    public int hashCode() {  
        double m1, m2, m3, m4;  // moments
        for (int i = 0; i < fieldNames.length; i++) {
    protected double[] fieldSumArr;
        }
 */
                        newVal += other.covariances.get(fieldName).get(cFieldName) + f * dR * deltas.get(cFieldName);  
            }
                t1 = d * dn * (docCount - 1);  
            for (int j = i + 1; j < fieldNames.length; j++) {  
    }
        String fieldName;  
     * <p>
    private void mergeCovarianceArrays(final RunningStats other, final double[] deltas) {  
        this.fieldNames = fieldNames;
    public void addArrays(final double[] fieldVals) {
    }  
        for (int i = 0; i < fieldNames.length; ++i) {  
            meansArr[i] = (nA * meansArr[i] + nB * other.meansArr[i]) / (nA + nB);
        }  
        docCount = (Long) in.readGenericValue();
 *
            // kurtosis
            addArrays(fieldVals);
    }
            init(fieldNames == null);  
    protected Map<String, Double> variances;
            skewA = skewness.get(fieldName);
    protected double[] variancesArr;
            deltas.put(fieldName, other.fieldSum.get(fieldName) / nB - fieldSum.get(fieldName) / nA);
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        if (fieldNames.length != fieldVals.length) {  
            }
        try {
    }  
            throw new IllegalArgumentException("Cannot add statistics without field values.");
            }  
                    }  
import org.opensearch.core.common.io.stream.StreamOutput;  
            this.kurtosisArr = other.kurtosisArr;
        this.mergeCovarianceArrays(other, deltas);  
                dn = d / docCount;
        }
            kurtosis = new HashMap<>();  
        }
            this.usesMaps = in.readBoolean();  
        if (other == null) {
                }
 * You may obtain a copy of the License at  
                dn2 = dn * dn;
    }  
            // merge variances, skewness, and kurtosis of two sets  
        // Switch from the slower maps implementation to the fast primitive array implementation.
        if (fieldNames == null) {
import java.util.HashMap;  
            Arrays.hashCode(meansArr),
            kurtA = kurtosisArr[i];  
    public boolean equals(Object o) {
        double[][] result = new double[fieldNames.length][fieldNames.length];
    }  
            dR = deltas.get(fieldName);
            // kurtosis
        } else if (fieldNames.length != fieldVals.length) {  
/*  
        }
        final double countA = docCount - other.docCount;
            nB2 = nB * nB;              // doc B num samples squared
            throw new OpenSearchException("Error trying to create a copy of RunningStats");
        }
            meanA = meansArr[i];  
        skewness = (Map<String, Double>) in.readGenericValue();
        if (usesMaps) {  
            fieldSumArr = new double[fieldNames.length];  
    public RunningStats clone() {  
        } else if (!other.usesMaps) {  
    }  
    protected double[] kurtosisArr;
     * running computations taken from: http://prod.sandia.gov/techlib/access-control.cgi/2008/086212.pdf
            varB = other.variances.get(fieldName);
        final double nB = other.docCount;
    }
            skewA = skewnessArr[i];
            countsArr[i]++;
            dR = deltas.get(fieldName);
            kurtosisArr = new double[fieldNames.length];  
        variancesArr = convertFieldDoubleMap(variances);  
        }
        if (o == null || getClass() != o.getClass()) return false;  
        if (this == o) return true;
            this.docCount = other.docCount;
            return;
    }
            // update counts  
            Arrays.hashCode(fieldSumArr),  
                this.means.put(fieldName, fs.getValue().doubleValue());
    /** updates running statistics with a documents field values **/
            out.writeGenericValue(counts);  
        }  
            varB = other.variancesArr[i];
                }
 * KIND, either express or implied.  See the License for the
            this.usesMaps = true;  
 *  
            nk = kurtA + kurtB + d4 * nA * nB * (nA2 - nA * nB + nB2) / (n2 * docCount);
    Map<String, Map<String, Double>> convertNestedDoubleArrayToMap(double[][] stats) {
 * This should only happen in mixed clusters.  
 * compatible open source license.
            covariancesArr = new double[fieldNames.length][fieldNames.length];
    /** Update covariance matrix */  
        for (int i = 0; i < fieldNames.length; i++) {
        RunningStats that = (RunningStats) o;
 *
        ++docCount;
        assert !other.usesMaps && !this.usesMaps;
    /** covariance values */
            }
        }
        assert serializedMap.keySet().equals(new HashSet<>(Arrays.asList(fieldNames)));  
import java.util.Map;
    public static final Version ARRAY_IMPL_VERSION = Version.V_3_4_0;
        this.updateCovarianceArrays(fieldNames, deltas);  
    // Array-based values. These may be null for RunningStats from older versions  
        }  
            variances = new HashMap<>();
            out.writeGenericValue(convertDoubleArrayToMap(variancesArr));
            fieldName = fieldNames[i];
                m2 = variancesArr[i];
                && Objects.equals(skewness, that.skewness)  
        for (int i = 0; i < fieldNames.length; i++) {
            n2 = docCount * docCount;   // num samples squared
                m3 = skewness.get(fieldName);  
    /**
                skewness.put(fieldName, m3 + (t1 * dn * (docCount - 2D) - 3D * dn * m2));
    /** kurtosis values (fourth moment) */
        kurtosis = convertDoubleArrayToMap(kurtosisArr);
            Arrays.hashCode(skewnessArr),
            if (cFieldVals.size() > 0) {
            // update running deltas
            && Arrays.deepEquals(covariancesArr, that.covariancesArr);
            // skewness
    }
 * http://prod.sandia.gov/techlib/access-control.cgi/2008/086212.pdf  
            }
        } catch (CloneNotSupportedException e) {  
    protected Map<String, Double> fieldSum;
            && Arrays.equals(kurtosisArr, that.kurtosisArr)
 * Modifications Copyright OpenSearch Contributors. See  
 * <p>
                result[i][j] = serializedMap.get(fieldNames[i]).get(fieldNames[j]);
 *    http://www.apache.org/licenses/LICENSE-2.0
        // across fields
        } else {  
                dn = d / docCount;
import java.util.Objects;  
        } else if (this.docCount == 0) {
        assert other.usesMaps && this.usesMaps;
public class RunningStats implements Writeable, Cloneable {
        for (int i = 0; i < fieldNames.length; i++) {  
            // merge deltas  
            kurtB = other.kurtosisArr[i];
import java.io.IOException;  
        }
                m2 = variances.get(fieldName);
            // update running mean, variance, skewness, kurtosis
        return result;
        if (this.docCount == 0) {
                this.skewness.put(fieldName, other.skewness.get(fieldName).doubleValue());  
        }
            // merge deltas  
            this.countsArr = other.countsArr;
        final double nB = other.docCount;
        } else {
            meanB = other.means.get(fieldName);
        double meanA, varA, skewA, kurtA, meanB, varB, skewB, kurtB;
        if (out.getVersion().onOrAfter(ARRAY_IMPL_VERSION)) {
            && Arrays.equals(meansArr, that.meansArr)
    }
            varA = variancesArr[i];
                covariancesArr[i][j] += other.covariancesArr[i][j] + f * deltas[i] * deltas[j];
            }  
}  
                && Objects.equals(means, that.means)
        docCount += other.docCount;  
            // merge totals  
        ArrayList<String> cFieldNames = new ArrayList<>(Arrays.asList(fieldNames));  
            // update running sum
            // If we are already using maps we can send them as-is.
package org.opensearch.search.aggregations.matrix.stats;
        return result;
    private boolean usesMaps = false;  
        Map<String, Map<String, Double>> result = new HashMap<>();  
    }  
                skewnessArr[i] += (t1 * dn * (docCount - 2D) - 3D * dn * m2);
            deltas[i] = other.fieldSumArr[i] / nB - fieldSumArr[i] / nA;
                this.kurtosis.put(fieldName, other.kurtosis.get(fieldName).doubleValue());
        // deep copy of hash keys (field names)
    protected Map<String, Double> kurtosis;  
    }
            this.skewnessArr = other.skewnessArr;
        long[] result = new long[fieldNames.length];
            return;
        double dR, newVal;
            meanB = other.meansArr[i];
 * However, when deserializing RunningStats from previous versions, we don't have the sorted list of field names,
 * this file be licensed under the Apache-2.0 license or a
        // across fields  
            countsArr = new long[fieldNames.length];
            out.writeGenericValue(covariances);
 * this work for additional information regarding copyright
        }  
                meansArr[i] = fieldValue;  
                this.variances.put(fieldName, other.variances.get(fieldName).doubleValue());
 * ownership. Elasticsearch licenses this file to you under  
            && Arrays.equals(variancesArr, that.variancesArr)
            out.writeGenericValue(skewness);  
    }
                skewness.put(fieldName, 0.0);
            Arrays.hashCode(countsArr),
     **/  
            out.writeGenericValue(convertDoubleArrayToMap(skewnessArr));  
                meansArr[i] += dn;  
                && Objects.equals(covariances, that.covariances);
        }  
            // variance
        kurtosis = (Map<String, Double>) in.readGenericValue();
        if (!usesMaps && !other.usesMaps) {
                // variances, skewness, kurtosis already initialized to 0
        meansArr = convertFieldDoubleMap(means);  
            // variance
        return result;
        } else {  
                variancesArr[i] += t1;
            out.writeBoolean(usesMaps);  
            throw new IllegalArgumentException("Number of field values do not match number of field names.");
        variances = (Map<String, Double>) in.readGenericValue();  
        }
    }  
    private void mergeCovarianceMaps(final RunningStats other, final Map<String, Double> deltas) {
        double m2, m3; // moments
            Arrays.deepHashCode(covariancesArr)  
            deltas.put(fieldName, fieldValue * docCount - fieldSum.get(fieldName));
    public void addMaps(final String[] fieldNames, final double[] fieldVals) {  
        }
            if (!usesMaps) {
            d3 = d * d2;                // delta mean cubed  
        assert serializedMap.keySet().equals(new HashSet<>(Arrays.asList(fieldNames)));  
        }
        if (usesMaps != that.usesMaps) return false;
                    if (other.covariances.containsKey(fieldName) && other.covariances.get(fieldName).containsKey(cFieldName)) {
        return result;
        for (int i = 0; i < fieldNames.length; i++) {
            this.covariancesArr = other.covariancesArr;  
            fieldValue = fieldVals[i];
        String fieldName;
            }
        ++docCount;
            d = meanB - meanA;          // delta mean
            d2 = d * d;                 // delta mean squared
        counts = convertLongArrayToMap(countsArr);  
                    cFieldVals.put(cFieldName, 0.0);
        fieldSumArr = convertFieldDoubleMap(fieldSum);
        // update total, mean, and variance
        for (int i = 0; i < fieldNames.length; i++) {
    /** Ctor to create an instance of running statistics */
/*
        kurtosisArr = convertFieldDoubleMap(kurtosis);
            fieldName = fieldNames[i];  
                        newVal += other.covariances.get(cFieldName).get(fieldName) + f * dR * deltas.get(cFieldName);
                Map<String, Double> cFieldVals = covariances.get(fieldName);
            result.put(fieldNames[i], stats[i]);  
                variances.put(fieldName, m2 + t1);
            && Arrays.equals(skewnessArr, that.skewnessArr)  
                d = fieldValue - meansArr[i];
    }
        }
        assert serializedMap.keySet().equals(new HashSet<>(Arrays.asList(fieldNames)));  
            // merge counts of two sets  
        if (usesMaps) {
        double d, d2, d3, d4, n2, nA2, nB2;
    final String[] fieldNames;
    @SuppressWarnings("unchecked")  
            // skeewness
 * under the License.  
            other.switchToMaps();
import org.opensearch.core.common.io.stream.StreamInput;
            return;  
        double f = ((double) (docCount - other.docCount)) * other.docCount / this.docCount; // , dR, newVal;
        init(fieldNames == null);  
            if (docCount == 1) {
    @Override  
        }
 * primitive arrays, as the keys of the map are constant (they're just the fields of the aggregation).  
                }  
            d4 = d2 * d2;               // delta mean 4th power
        for (int i = 0; i < fieldNames.length; ++i) {
        if (fieldVals == null) {
    protected Map<String, Map<String, Double>> covariances;
            d4 = d2 * d2;               // delta mean 4th power
        }  
        usesMaps = true;
    @Override
                    newVal = cFieldVals.get(cFieldName) + 1.0 / (docCount * (docCount - 1.0)) * dR * deltas.get(cFieldName);
        counts = (Map<String, Long>) in.readGenericValue();
    private void init(boolean usesMaps) {
    private void updateCovarianceArrays(final String[] fieldNames, final double[] deltas) {
            mergeArrays(other);  
    double[][] convertNestedDoubleMap(Map<String, Map<String, Double>> serializedMap) {
    @Override
 * license agreements. See the NOTICE file distributed with
        }
            skewB = other.skewness.get(fieldName);  
                kurtosis.put(fieldName, kurtosis.get(fieldName) + m4);
 * GitHub history for details.
            kurtosisArr[i] = nk + 6D * d2 * (nA2 * varB + nB2 * varA) / n2 + 4D * d * (nA * skewB - nB * skewA) / docCount;  
            this.variancesArr = other.variancesArr;  
    public boolean usesMaps() {
        Map<String, Double> result = new HashMap<>();
            counts.put(fieldName, 1 + (counts.containsKey(fieldName) ? counts.get(fieldName) : 0));
            for (Map.Entry<String, Double> fs : other.means.entrySet()) {  
        double fieldValue;  
                switchToArrays();  
        } else {  
            n2 = docCount * docCount;   // num samples squared
    long[] convertFieldLongMap(Map<String, Long> serializedMap) {
                    double intermediate = 1.0 / (docCount * (docCount - 1.0)) * deltas[i] * deltas[j];
        double d, d2, d3, d4, n2, nA2, nB2;
        return result;  
            return Objects.hash(docCount, fieldSum, counts, means, variances, skewness, kurtosis, covariances);
                    cFieldVals.put(cFieldName, newVal);
    double[] convertFieldDoubleMap(Map<String, Double> serializedMap) {
            for (int j = i + 1; j < fieldNames.length; j++) {
            this.fieldNames = null;
            skewness = new HashMap<>();
                means.put(fieldName, fieldValue);  
            addMaps(fn, fieldVals);
            cFieldNames.remove(fieldName);
        this.fieldNames = fieldNames;
                && Objects.equals(fieldSum, that.fieldSum)
            deltas[i] = fieldValue * docCount - fieldSumArr[i];
    }
            // merge variances, skewness, and kurtosis of two sets  
        covariances = convertNestedDoubleArrayToMap(covariancesArr);  
    }
    void switchToMaps() {  
            skewnessArr = new double[fieldNames.length];
                && Objects.equals(kurtosis, that.kurtosis)
        if (in.getVersion().onOrAfter(ARRAY_IMPL_VERSION)) {
                m3 = skewnessArr[i];  
    @Override
            this.fieldSumArr = other.fieldSumArr;
            && Arrays.equals(fieldSumArr, that.fieldSumArr)
    }
        covariancesArr = convertNestedDoubleMap(covariances);
                covariances.put(fieldName, cFieldVals);  
    }  
            out.writeGenericValue(kurtosis);
        final HashMap<String, Double> deltas = new HashMap<>();
                dn2 = dn * dn;
        if (usesMaps) {  
import org.opensearch.Version;
            kurtB = other.kurtosis.get(fieldName);
            out.writeOptionalStringArray(fieldNames);
                }
            d = meanB - meanA;          // delta mean
    }  
            }
        // update total, mean, and variance
        if (usesMaps) {
        return usesMaps;  
            out.writeGenericValue(variances);
 */  
    /** Merges two covariance matrices */  
