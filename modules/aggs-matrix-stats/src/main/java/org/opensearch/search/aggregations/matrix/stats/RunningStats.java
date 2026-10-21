            // merge counts of two sets
            }
        } catch (CloneNotSupportedException e) {
            kurtosis = new HashMap<>();
        kurtosisArr = convertFieldDoubleMap(kurtosis);
 *
 * under the License.
 * The OpenSearch Contributors require contributions made to
        double newSkew, nk;
        // Switch from the fast primitive array implementation to the slower maps implementation.
        final double nA = docCount;
    private void mergeArrays(final RunningStats other) {
        }
                this.variances.put(fieldName, other.variances.get(fieldName).doubleValue());
        );
 * Licensed to Elasticsearch under one or more contributor
        this.mergeCovarianceMaps(other, deltas);
        double d, d2, d3, d4, n2, nA2, nB2;
            if (cFieldVals.size() > 0) {
        // update total, mean, and variance
 * based on these descriptive stats. This single pass, parallel approach is based on:
    Map<String, Map<String, Double>> convertNestedDoubleArrayToMap(double[][] stats) {
    /** updates running statistics with a documents field values **/
    protected double[] meansArr;
    private void mergeMaps(final RunningStats other) {
        }
        }
        means = (Map<String, Double>) in.readGenericValue();
            nk = kurtA + kurtB + d4 * nA * nB * (nA2 - nA * nB + nB2) / (n2 * docCount);
                d = fieldValue - m1;
                this.counts.put(fieldName, other.counts.get(fieldName).longValue());
            n2 = docCount * docCount;   // num samples squared
            skewB = other.skewnessArr[i];
            && Arrays.equals(kurtosisArr, that.kurtosisArr)
            fieldSum = new HashMap<>();
            means.put(fieldName, (nA * means.get(fieldName) + nB * other.means.get(fieldName)) / (nA + nB));
        skewness = convertDoubleArrayToMap(skewnessArr);
                    cFieldVals.put(cFieldName, newVal);
    /** counts */
    RunningStats(final String[] fieldNames) {
        means = convertDoubleArrayToMap(meansArr);
            meanB = other.means.get(fieldName);
            this.usesMaps = in.readBoolean();
/*
        assert serializedMap.keySet().equals(new HashSet<>(Arrays.asList(fieldNames)));
                && Objects.equals(means, that.means)
 *
        if (this.docCount == 0) {
        final double nA = docCount;
    public boolean equals(Object o) {
    }
        fieldSum = convertDoubleArrayToMap(fieldSumArr);
            }
        Map<String, Map<String, Double>> result = new HashMap<>();
            && Arrays.equals(fieldSumArr, that.fieldSumArr)
            return (RunningStats) super.clone();
            kurtosis.put(fieldName, nk + 6D * d2 * (nA2 * varB + nB2 * varA) / n2 + 4D * d * (nA * skewB - nB * skewA) / docCount);
            this.fieldNames = in.readOptionalStringArray();
    /** per field sum of observations */
            deltas.put(fieldName, fieldValue * docCount - fieldSum.get(fieldName));
            && Arrays.deepEquals(covariancesArr, that.covariancesArr);
            counts.put(fieldName, 1 + (counts.containsKey(fieldName) ? counts.get(fieldName) : 0));
            d3 = d * d2;                // delta mean cubed
        for (int i = 0; i < fieldNames.length; i++) {
            return;
    }
            meanA = meansArr[i];
            return;
    @Override
        if (usesMaps) return;
        if (usesMaps) {
            }
import org.opensearch.OpenSearchException;
    /** skewness values (third moment) */
        double[] result = new double[fieldNames.length];
        } else {
    /** Ctor to create an instance of running statistics */
    Map<String, Long> convertLongArrayToMap(long[] stats) {
                m1 = means.get(fieldName);
 * Descriptive stats gathered per shard. Coordinating node computes final correlation and covariance stats
        countsArr = convertFieldLongMap(counts);
        // If at least one of the two RunningStats uses the maps impl, ensure both switch to it before merge
 * GitHub history for details.
                variances.put(fieldName, m2 + t1);
            variancesArr = new double[fieldNames.length];
            throw new IllegalArgumentException("Cannot merge RunningStats with different fieldNames");
            this.countsArr = other.countsArr;
        return result;
        long[] result = new long[fieldNames.length];
        return result;
            && Arrays.equals(variancesArr, that.variancesArr)
            fieldName = fieldNames[i];
                kurtosisArr[i] += t1 * dn2 * (docCount * docCount - 3D * docCount + 3D) + 6D * dn2 * m2 - 4D * dn * m3;
            Arrays.hashCode(fieldSumArr),
                this.kurtosis.put(fieldName, other.kurtosis.get(fieldName).doubleValue());
                        newVal += other.covariances.get(fieldName).get(cFieldName) + f * dR * deltas.get(cFieldName);
                && Objects.equals(covariances, that.covariances);
                dn2 = dn * dn;
            fieldName = fieldNames[i];
        try {
        double meanA, varA, skewA, kurtA, meanB, varB, skewB, kurtB;
            meanA = means.get(fieldName);
                skewnessArr[i] += (t1 * dn * (docCount - 2D) - 3D * dn * m2);
                    }
                covariances.put(fieldName, cFieldVals);
                && Objects.equals(counts, that.counts)
            // update running mean, variance, skewness, kurtosis
            throw new IllegalArgumentException("Cannot add statistics without field values.");
    long[] convertFieldLongMap(Map<String, Long> serializedMap) {
        for (int i = 0; i < fieldNames.length; i++) {
                    double intermediate = 1.0 / (docCount * (docCount - 1.0)) * deltas[i] * deltas[j];
 * Modifications Copyright OpenSearch Contributors. See
            fieldValue = fieldVals[i];
        // update total, mean, and variance
        // across fields
        if (fieldVals != null && fieldVals.length > 0) {
                // update running means
            kurtosisArr = new double[fieldNames.length];
        fieldSumArr = convertFieldDoubleMap(fieldSum);
            variances = new HashMap<>();
            nB2 = nB * nB;              // doc B num samples squared
    /** count of observations (same number of observations per field) */
            throw new IllegalArgumentException("Cannot add statistics without field names.");
        this.fieldNames = fieldNames;
            covariances = new HashMap<>();
            Arrays.hashCode(skewnessArr),
            d3 = d * d2;                // delta mean cubed
        }
        counts = (Map<String, Long>) in.readGenericValue();
            this.add(fieldNames, fieldVals);
            this.fieldSumArr = other.fieldSumArr;
        }
            result.put(fieldNames[i], stats[i]);
        if (!usesMaps) {
    public void addArrays(final double[] fieldVals) {
            // If we aren't using maps already we must convert to send. This will still be backwards compatible.
            kurtosisArr[i] = nk + 6D * d2 * (nA2 * varB + nB2 * varA) / n2 + 4D * d * (nA * skewB - nB * skewA) / docCount;
        double m2, m3; // moments
        if (fieldNames == null) throw new IllegalArgumentException("Cannot convert to array impl if fieldNames is null");
                innerMap.put(fieldNames[j], stats[i][j]);
    private void init(boolean usesMaps) {
                    this.covariances.put(fieldName, other.covariances.get(fieldName));
            }
        // deep copy of hash keys (field names)
            variances.put(fieldName, varA + varB + d2 * nA * other.docCount / docCount);
 * software distributed under the License is distributed on an
        if (fieldNames == null) {
     * Merges the descriptive statistics of a second data set (e.g., per shard)
            }
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        ++docCount;
    /** mean values (first moment) */
        mergeMaps(other);
        }
            for (int j = i + 1; j < fieldNames.length; j++) {
    }
    }
        if (!Arrays.equals(other.fieldNames, fieldNames)) {
 * ownership. Elasticsearch licenses this file to you under
            return docCount == that.docCount
            // merge means of two sets
    /** Merges two covariance matrices */
import org.opensearch.core.common.io.stream.Writeable;
import java.util.HashMap;
public class RunningStats implements Writeable, Cloneable {
            fieldSumArr[i] += fieldValue;
        double f, dR, newVal;
            nk = kurtA + kurtB + d4 * nA * nB * (nA2 - nA * nB + nB2) / (n2 * docCount);
            if (means.containsKey(fieldName)) {
                // update running means
        if (usesMaps) {
    /** variance values (second moment) */
    /** kurtosis values (fourth moment) */
    private void updateCovarianceArrays(final String[] fieldNames, final double[] deltas) {
        this.updateCovarianceMaps(fieldNames, deltas);
        for (int i = 0; i < fieldNames.length; i++) {
                dn = d / docCount;
            d = meanB - meanA;          // delta mean
        }
import java.util.HashSet;
            && Arrays.equals(countsArr, that.countsArr)
    public void add(final String[] fn, final double[] fieldVals) {
        }
            other.switchToMaps();
                        newVal += other.covariances.get(cFieldName).get(fieldName) + f * dR * deltas.get(cFieldName);
            fieldSumArr = new double[fieldNames.length];
                // update running variances
        if (docCount > 1) {
        } else if (this.docCount == 0) {
        } else if (!other.usesMaps) {
    void switchToArrays() {
            skewA = skewness.get(fieldName);
        variancesArr = convertFieldDoubleMap(variances);
        }
    }
    RunningStats(final String[] fieldNames, final double[] fieldVals) {
                    newVal = cFieldVals.get(cFieldName) + 1.0 / (docCount * (docCount - 1.0)) * dR * deltas.get(cFieldName);
                skewness.put(fieldName, 0.0);
        final double countA = docCount - other.docCount;
    double[][] convertNestedDoubleMap(Map<String, Map<String, Double>> serializedMap) {
    @Override
                means.put(fieldName, m1 + d / docCount);
                    if (other.covariances.containsKey(fieldName) && other.covariances.get(fieldName).containsKey(cFieldName)) {
                    newVal = cFieldVals.get(cFieldName);
            addArrays(fieldVals);
    }
                }
        ArrayList<String> cFieldNames = new ArrayList<>(Arrays.asList(fieldNames));
    }
    }
            // merge variances, skewness, and kurtosis of two sets
            this.covariancesArr = other.covariancesArr;
                && Objects.equals(skewness, that.skewness)
                && Objects.equals(variances, that.variances)
        if (out.getVersion().onOrAfter(ARRAY_IMPL_VERSION)) {
        if (fieldVals == null) {
        }
            nA2 = nA * nA;              // doc A num samples squared
    protected double[] fieldSumArr;
            d2 = d * d;                 // delta mean squared
                kurtosis.put(fieldName, 0.0);
    protected Map<String, Double> means;
            newSkew = skewA + skewB + d3 * nA * nB * (nA - nB) / n2;
        String fieldName;
        out.writeGenericValue(docCount);
        assert other.usesMaps && this.usesMaps;
        }
            for (String cFieldName : cFieldNames) {
import java.util.Map;
    }
                variances.put(fieldName, 0.0);
            meansArr = new double[fieldNames.length];
    protected Map<String, Map<String, Double>> covariances;
                meansArr[i] = fieldValue;
    protected Map<String, Double> variances;
            out.writeGenericValue(convertNestedDoubleArrayToMap(covariancesArr));
 * specific language governing permissions and limitations
            this.fieldNames = null;
    // or ones which have added one from an older version.
        if (usesMaps != that.usesMaps) return false;
 */
            && Arrays.equals(meansArr, that.meansArr)
    }
 *
    }
        }
            // merge totals
        if (usesMaps) {
        docCount += other.docCount;
        covariances = convertNestedDoubleArrayToMap(covariancesArr);
                m3 = skewnessArr[i];
     * running computations taken from: http://prod.sandia.gov/techlib/access-control.cgi/2008/086212.pdf
            this.variancesArr = other.variancesArr;
        }
        } else if (fieldNames.length != fieldVals.length) {
    }
        docCount += other.docCount;
            throw new OpenSearchException("Error trying to create a copy of RunningStats");
                for (int j = i + 1; j < fieldNames.length; j++) {
                } else {
    /**
            // If we are already using maps we can send them as-is.
        return Objects.hash(
    public RunningStats clone() {
        }
                // variances, skewness, kurtosis already initialized to 0
                }
                }
     * and if it's false the arrays are guaranteed to be non-null after ctor returns.
                // update running skewnesses
 * this work for additional information regarding copyright
        if (fieldNames.length != fieldVals.length) {
        counts = convertLongArrayToMap(countsArr);
                t1 = d * dn * (docCount - 1);
import java.util.Arrays;
            out.writeGenericValue(covariances);
        }
        for (int i = 0; i < fieldNames.length; i++) {
        }
 * SPDX-License-Identifier: Apache-2.0
        double newSkew, nk;
    private void updateCovarianceMaps(final String[] fieldNames, final Map<String, Double> deltas) {
 * license agreements. See the NOTICE file distributed with
            countsArr[i]++;
                means.put(fieldName, fieldValue);
            nB2 = nB * nB;              // doc B num samples squared
    /** Whether it uses the slow maps impl or not. If this is true, the Maps containing data are guaranteed to be non-null,
    protected double[] skewnessArr;
        if (usesMaps) {
    }
        Map<String, Double> result = new HashMap<>();
        skewnessArr = convertFieldDoubleMap(skewness);
                m2 = variances.get(fieldName);
            d4 = d2 * d2;               // delta mean 4th power
            skewness = new HashMap<>();
 * not use this file except in compliance with the License.
 * This should only happen in mixed clusters.
            out.writeGenericValue(convertDoubleArrayToMap(kurtosisArr));
            out.writeGenericValue(convertLongArrayToMap(countsArr));
                for (String cFieldName : cFieldVals.keySet()) {
        // merge count
    Map<String, Double> convertDoubleArrayToMap(double[] stats) {
            countsArr[i] += other.countsArr[i];
        }
    }
            // variance
        }
            final String fieldName = fs.getKey();
        return docCount == that.docCount
            out.writeGenericValue(fieldSum);
        this.updateCovarianceArrays(fieldNames, deltas);
    protected Map<String, Double> kurtosis;
            // update running mean, variance, skewness, kurtosis
    }
            final String fieldName = fs.getKey();
            // merge deltas
     */
            fieldSum.put(fieldName, fieldSum.get(fieldName) + other.fieldSum.get(fieldName));
 * http://prod.sandia.gov/techlib/access-control.cgi/2008/086212.pdf
        } else {
    private void mergeCovarianceArrays(final RunningStats other, final double[] deltas) {
        }
    }
    }
        for (Map.Entry<String, Double> fs : other.means.entrySet()) {
}
        String fieldName;
        for (int i = 0; i < fieldNames.length; ++i) {
                variancesArr[i] += t1;
        meansArr = convertFieldDoubleMap(means);
        this.usesMaps = usesMaps;
/*
    protected long[] countsArr;
            // merge variances, skewness, and kurtosis of two sets
import java.util.ArrayList;
            if (covariances.containsKey(fieldName)) {
        for (Map.Entry<String, Double> fs : other.means.entrySet()) {
 * You may obtain a copy of the License at
    public boolean usesMaps() {
import java.io.IOException;
        init(fieldNames == null);
    public int hashCode() {
                m4 = t1 * dn2 * (docCount * docCount - 3D * docCount + 3D) + 6D * dn2 * m2 - 4D * dn * m3;
        double d, dn, dn2, t1;
/*
                // update running variances
        }
            nA2 = nA * nA;              // doc A num samples squared
            out.writeGenericValue(variances);
                m2 = variancesArr[i];
            skewnessArr[i] = newSkew + 3D * d * (nA * varB - nB * varA) / docCount;
            d = meanB - meanA;          // delta mean
        ++docCount;
    protected Map<String, Long> counts;
            varA = variancesArr[i];
            skewnessArr = new double[fieldNames.length];
            counts = new HashMap<>();
                final String fieldName = fs.getKey();
                    cFieldVals.put(cFieldName, newVal);
    protected Map<String, Double> skewness;
        return result;
        double m1, m2, m3, m4;  // moments
            deltas.put(fieldName, other.fieldSum.get(fieldName) / nB - fieldSum.get(fieldName) / nA);
        return usesMaps;
            varA = variances.get(fieldName);
            // skewness
            }
                this.skewness.put(fieldName, other.skewness.get(fieldName).doubleValue());
    final String[] fieldNames;
            throw new IllegalArgumentException("Number of field values do not match number of field names.");
            result[i] = serializedMap.get(fieldNames[i]);
        return result;
            }
            switchToMaps();
            dR = deltas.get(fieldName);
            f = countA * other.docCount / this.docCount;
        if (!usesMaps && !other.usesMaps) {
            result[i] = serializedMap.get(fieldNames[i]);
                d = fieldValue - meansArr[i];
        // Always write as maps, which is how earlier versions did it. Receiving node will convert to arrays if needed.
            out.writeGenericValue(means);
        assert serializedMap.keySet().equals(new HashSet<>(Arrays.asList(fieldNames)));
                && Objects.equals(fieldSum, that.fieldSum)
            counts.put(fieldName, counts.get(fieldName) + other.counts.get(fieldName));
    }
        }
        }
 */
            }
        usesMaps = false;
        return result;
            kurtA = kurtosis.get(fieldName);
            if (docCount == 1) {
            out.writeGenericValue(counts);
        for (int i = 0; i < fieldNames.length; i++) {
 *
            out.writeGenericValue(kurtosis);
 */
    protected double[][] covariancesArr;
        for (int i = 0; i < fieldNames.length; i++) {
    public RunningStats(StreamInput in) throws IOException {
        }
    }
    @Override
    }
                dn = d / docCount;
        docCount = (Long) in.readGenericValue();
            out.writeGenericValue(convertDoubleArrayToMap(variancesArr));
            skewB = other.skewness.get(fieldName);
 * this file be licensed under the Apache-2.0 license or a
        assert !other.usesMaps && !this.usesMaps;
    }
 */
    protected Map<String, Double> fieldSum;
 * KIND, either express or implied.  See the License for the
        }
        } else {
                covariancesArr[i][j] += other.covariancesArr[i][j] + f * deltas[i] * deltas[j];
            // kurtosis
            Map<String, Double> cFieldVals = (covariances.get(fieldName) != null) ? covariances.get(fieldName) : new HashMap<>();
            return;
    public void writeTo(StreamOutput out) throws IOException {
import java.util.Objects;
    protected long docCount = 0;
            // merge counts of two sets
 * so we must revert to using maps. The same goes for any RunningStats that merges with these deserialized instances.
            } else {
            addMaps(fn, fieldVals);
        final double[] deltas = new double[fieldNames.length];
            }
        final double nB = other.docCount;
        assert serializedMap.keySet().equals(new HashSet<>(Arrays.asList(fieldNames)));
            out.writeGenericValue(convertDoubleArrayToMap(fieldSumArr));
            }
            Map<String, Double> innerMap = new HashMap<>();
                kurtosis.put(fieldName, kurtosis.get(fieldName) + m4);
        covariancesArr = convertNestedDoubleMap(covariances);
            // variance
    }
                if (cFieldVals.containsKey(cFieldName)) {
    }
            kurtA = kurtosisArr[i];
            kurtB = other.kurtosisArr[i];
            varB = other.variancesArr[i];
                if (other.covariances.containsKey(fieldName)) {
            mergeArrays(other);
    protected double[] kurtosisArr;
                Map<String, Double> cFieldVals = covariances.get(fieldName);
        final double[] deltas = new double[fieldNames.length];
            out.writeOptionalStringArray(fieldNames);
            // update running sum
            fieldValue = fieldVals[i];
            throw new IllegalArgumentException("Number of field values do not match number of field names.");
            d4 = d2 * d2;               // delta mean 4th power
            // merge means of two sets
            out.writeGenericValue(convertDoubleArrayToMap(meansArr));
        final HashMap<String, Double> deltas = new HashMap<>();
        }
 * Unless required by applicable law or agreed to in writing,
            return;
        if (o == null || getClass() != o.getClass()) return false;
    public static final Version ARRAY_IMPL_VERSION = Version.V_3_4_0;
        double fieldValue;
    }
            // update counts
            return Objects.hash(docCount, fieldSum, counts, means, variances, skewness, kurtosis, covariances);
            result.put(fieldNames[i], innerMap);
        }
            Arrays.hashCode(countsArr),
        RunningStats that = (RunningStats) o;
                m3 = skewness.get(fieldName);
package org.opensearch.search.aggregations.matrix.stats;
            Arrays.hashCode(kurtosisArr),
    public void addMaps(final String[] fieldNames, final double[] fieldVals) {
        double dR, newVal;
        covariances = (Map<String, Map<String, Double>>) in.readGenericValue();
            Arrays.hashCode(meansArr),
                    cFieldVals.put(cFieldName, 0.0);
            meanB = other.meansArr[i];
    private void mergeCovarianceMaps(final RunningStats other, final Map<String, Double> deltas) {
import org.opensearch.core.common.io.stream.StreamInput;
        for (int i = 0; i < fieldNames.length; ++i) {
    public void merge(final RunningStats other) {
            // merge deltas
        }
            }
            // merge covariances of two sets
    }
        double meanA, varA, skewA, kurtA, meanB, varB, skewB, kurtB;
            // update running sum
    void switchToMaps() {
            assert fieldNames != null;
            varB = other.variances.get(fieldName);
        for (int i = 0; i < fieldNames.length; ++i) {
            dR = deltas.get(fieldName);
    protected double[] variancesArr;
        final double nB = other.docCount;
            for (Map.Entry<String, Double> fs : other.means.entrySet()) {
        if (usesMaps) {
            this.skewnessArr = other.skewnessArr;
            skewA = skewnessArr[i];
            if (!usesMaps) {
                meansArr[i] += dn;
        for (int i = 0; i < fieldNames.length; i++) {
        }
            // update running deltas
            deltas[i] = fieldValue * docCount - fieldSumArr[i];
            init(fieldNames == null);
                    } else {
        if (in.getVersion().onOrAfter(ARRAY_IMPL_VERSION)) {
        kurtosis = convertDoubleArrayToMap(kurtosisArr);
            skewness.put(fieldName, newSkew + 3D * d * (nA * varB - nB * varA) / docCount);
        kurtosis = (Map<String, Double>) in.readGenericValue();
        double fieldValue;
    @Override
            covariancesArr = new double[fieldNames.length][fieldNames.length];
    /** covariance values */
                    covariancesArr[i][j] += intermediate;
     **/
        variances = convertDoubleArrayToMap(variancesArr);
                switchToArrays();
        double d, dn, dn2, t1;
            out.writeGenericValue(convertDoubleArrayToMap(skewnessArr));
 * However, when deserializing RunningStats from previous versions, we don't have the sorted list of field names,
            Arrays.hashCode(variancesArr),
     * <p>
        final HashMap<String, Double> deltas = new HashMap<>();
            } else {
    /** Update covariance matrix */
 * <p>
        if (other == null) {
            fieldSum.put(fieldName, fieldValue + (fieldSum.containsKey(fieldName) ? fieldSum.get(fieldName) : 0));
            for (int j = i + 1; j < fieldNames.length; j++) {
        variances = (Map<String, Double>) in.readGenericValue();
            // merge covariances
        this.mergeCovarianceArrays(other, deltas);
        fieldSum = (Map<String, Double>) in.readGenericValue();
            this.usesMaps = true;
            this.kurtosisArr = other.kurtosisArr;
        double f = ((double) (docCount - other.docCount)) * other.docCount / this.docCount; // , dR, newVal;
 *    http://www.apache.org/licenses/LICENSE-2.0
                dn2 = dn * dn;
        // Switch from the slower maps implementation to the fast primitive array implementation.
        Map<String, Long> result = new HashMap<>();
            countsArr = new long[fieldNames.length];
            fieldSumArr[i] += other.fieldSumArr[i];
            n2 = docCount * docCount;   // num samples squared
            && Arrays.equals(skewnessArr, that.skewnessArr)
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < fieldNames.length; i++) {
        } else {
        this.fieldNames = fieldNames;
            out.writeBoolean(usesMaps);
import org.opensearch.Version;
            cFieldNames.remove(fieldName);
        if (this == o) return true;
        // across fields
            means = new HashMap<>();
                covariances.put(fieldName, cFieldVals);
        double[][] result = new double[fieldNames.length][fieldNames.length];
    // Old map-based values
        // merge count
                }
        }
 * Map-based implementation is left here for backwards compatibility purposes. It's much faster to use
            out.writeGenericValue(skewness);
    // Array-based values. These may be null for RunningStats from older versions
        }
        return result;
            newSkew = skewA + skewB + d3 * nA * nB * (nA - nB) / n2;
            // skeewness
    private boolean usesMaps = false;
            for (int j = i + 1; j < fieldNames.length; j++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            docCount,
                t1 = d * dn * (docCount - 1);
                skewness.put(fieldName, m3 + (t1 * dn * (docCount - 2D) - 3D * dn * m2));
                this.docCount = other.docCount;
        }
                this.means.put(fieldName, fs.getValue().doubleValue());
/**
            meansArr[i] = (nA * meansArr[i] + nB * other.meansArr[i]) / (nA + nB);
            for (int i = 0; i < fieldNames.length; ++i) {
            // merge totals
            Arrays.deepHashCode(covariancesArr)
 * primitive arrays, as the keys of the map are constant (they're just the fields of the aggregation).
        usesMaps = true;
            // update running deltas
        skewness = (Map<String, Double>) in.readGenericValue();
            result.put(fieldNames[i], stats[i]);
    }
                this.fieldSum.put(fieldName, other.fieldSum.get(fieldName).doubleValue());
            // kurtosis
            this.meansArr = other.meansArr;
            deltas[i] = other.fieldSumArr[i] / nB - fieldSumArr[i] / nA;
            d2 = d * d;                 // delta mean squared
            // update running covariances
            kurtB = other.kurtosis.get(fieldName);
    @SuppressWarnings("unchecked")
                result[i][j] = serializedMap.get(fieldNames[i]).get(fieldNames[j]);
            variancesArr[i] = varA + varB + d2 * nA * other.docCount / docCount;
            this.docCount = other.docCount;
    double[] convertFieldDoubleMap(Map<String, Double> serializedMap) {
        double d, d2, d3, d4, n2, nA2, nB2;
            // update counts
 * compatible open source license.
                && Objects.equals(kurtosis, that.kurtosis)
