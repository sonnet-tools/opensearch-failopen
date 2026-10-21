        // skewness (multi-pass is more susceptible to round-off error so we need to slightly relax the tolerance)
        assertTrue(nearlyEqual(kurtosis.get(fieldAKey), stats.getKurtosis(fieldAKey), 1e-4));
    private Map<String, Double> means = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
        // compute mean
        assertTrue(nearlyEqual(covariances.get(fieldBKey).get(fieldAKey), stats.getCovariance(fieldBKey, fieldAKey), 1e-7));
/*
 * Modifications Copyright OpenSearch Contributors. See
    private Map<String, Double> variances = new HashMap<>();
    private long count;
    }
/*
        // variances
            dB = fieldB.get(n) - means.get(fieldBKey);
 * the Apache License, Version 2.0 (the "License"); you may
            meanA += fieldA.get(n);
    void assertNearlyEqual(MatrixStatsResults stats) {
    private Map<String, Double> kurtosis = new HashMap<>();
            kurtB += dB * dB * dB * dB;
        // compute covariance
        }
        assertTrue(nearlyEqual(skewness.get(fieldAKey), stats.getSkewness(fieldAKey), 1e-4));
        assertTrue(nearlyEqual(variances.get(fieldAKey), stats.getVariance(fieldAKey), 1e-7));
        covariances.put(fieldBKey, fieldBCovar);
        // set count
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(count, stats.getDocCount());
 * ownership. Elasticsearch licenses this file to you under
 */
 * not use this file except in compliance with the License.
            return true;
    private final String fieldBKey;
            kurtA += dA * dA * dA * dA;
        corr /= stdA * stdB;
            // fieldA
            return diff < (epsilon * Double.MIN_NORMAL);
            varA += dA * dA;
import static org.junit.Assert.assertTrue;
import java.util.Map;
        // correlation
 * this work for additional information regarding copyright
        skewness.put(fieldBKey, skewB / ((count - 1) * variances.get(fieldBKey) * stdB));
        assertEquals(count, stats.getFieldCount(fieldAKey));
        fieldBCovar.put(fieldAKey, cVar);
        final HashMap<String, Double> fieldBCorr = new HashMap<>();
 * license agreements. See the NOTICE file distributed with
        // variances
            skewA += dA * dA * dA;
        covariances.put(fieldAKey, fieldACovar);
        for (int n = 0; n < count; ++n) {
        // covariances
        if (a == b) { // shortcut, handles infinities
 * The OpenSearch Contributors require contributions made to
        skewness.put(fieldAKey, skewA / ((count - 1) * variances.get(fieldAKey) * stdA));
        correlations.put(fieldAKey, fieldACorr);
        assertTrue(nearlyEqual(correlations.get(fieldAKey).get(fieldBKey), stats.getCorrelation(fieldAKey, fieldBKey), 1e-7));
            cVar += dA * dB;
        assertEquals(count, stats.getFieldCount(fieldBKey));
        fieldACorr.put(fieldAKey, 1d);
 * Unless required by applicable law or agreed to in writing,
        variances.put(fieldBKey, varB / (count - 1));
            // a or b is zero or both are extremely close to it
 * You may obtain a copy of the License at
        assertEquals(count, stats.getDocCount());
        final double absA = Math.abs(a);
        kurtosis.put(fieldAKey, kurtA / ((count - 1) * variances.get(fieldAKey) * variances.get(fieldAKey)));
        double corr = covariances.get(fieldAKey).get(fieldBKey);
        final double stdB = Math.sqrt(variances.get(fieldBKey));
 * compatible open source license.
        assertTrue(nearlyEqual(correlations.get(fieldBKey).get(fieldAKey), stats.getCorrelation(fieldBKey, fieldAKey), 1e-7));
 *
        fieldACovar.put(fieldAKey, 1d);
        // correlation
 *
        means.put(fieldAKey, meanA / count);
        double varB = 0d;
/*
        fieldACovar.put(fieldBKey, cVar);
    private final String fieldAKey;
        // kurtosis (multi-pass is more susceptible to round-off error so we need to slightly relax the tolerance)
        double skewB = 0d;
        // skewness (multi-pass is more susceptible to round-off error so we need to slightly relax the tolerance)
        final HashMap<String, Double> fieldBCovar = new HashMap<>(2);
    void assertNearlyEqual(InternalMatrixStats stats) {
        fieldACorr.put(fieldBKey, corr);
        for (int n = 0; n < count; ++n) {
    }
class MultiPassStats {
        } else { // use relative error
    private Map<String, HashMap<String, Double>> covariances = new HashMap<>();
        cVar /= count - 1;
        fieldBCorr.put(fieldBKey, 1d);
    private Map<String, Double> skewness = new HashMap<>();
        assertTrue(nearlyEqual(means.get(fieldAKey), stats.getMean(fieldAKey), 1e-7));
        double dA;
        count = fieldA.size();
        final double absB = Math.abs(b);
        this.fieldAKey = fieldAName;
        assertTrue(nearlyEqual(means.get(fieldBKey), stats.getMean(fieldBKey), 1e-7));
 * SPDX-License-Identifier: Apache-2.0
        // means
        assertTrue(nearlyEqual(variances.get(fieldAKey), stats.getVariance(fieldAKey), 1e-7));
        final HashMap<String, Double> fieldACorr = new HashMap<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        this.fieldBKey = fieldBName;
    void computeStats(final List<Double> fieldA, final List<Double> fieldB) {
import static org.junit.Assert.assertEquals;
 */
        assertEquals(count, stats.getFieldCount(fieldAKey));
        } else if (a == 0 || b == 0 || diff < Double.MIN_NORMAL) {
package org.opensearch.search.aggregations.matrix.stats;
 *
        double kurtA = 0d;
            varB += dB * dB;
        // compute correlation
import java.util.List;
            skewB += dB * dB * dB;
        assertTrue(nearlyEqual(means.get(fieldBKey), stats.getMean(fieldBKey), 1e-7));
        correlations.put(fieldBKey, fieldBCorr);
        fieldBCovar.put(fieldBKey, 1d);
        fieldBCorr.put(fieldAKey, corr);
        assertTrue(nearlyEqual(covariances.get(fieldBKey).get(fieldAKey), stats.getCovariance(fieldBKey, fieldAKey), 1e-7));
        double meanA = 0d;
    MultiPassStats(String fieldAName, String fieldBName) {
        assertTrue(nearlyEqual(skewness.get(fieldBKey), stats.getSkewness(fieldBKey), 1e-4));
 * software distributed under the License is distributed on an
        final double diff = Math.abs(a - b);
    private Map<String, HashMap<String, Double>> correlations = new HashMap<>();
            // relative error is less meaningful here
        assertTrue(nearlyEqual(skewness.get(fieldAKey), stats.getSkewness(fieldAKey), 1e-4));
        means.put(fieldBKey, meanB / count);
 */
        assertTrue(nearlyEqual(kurtosis.get(fieldAKey), stats.getKurtosis(fieldAKey), 1e-4));
            return diff / Math.min((absA + absB), Double.MAX_VALUE) < epsilon;
        double varA = 0d;
    private static boolean nearlyEqual(double a, double b, double epsilon) {
    }
        kurtosis.put(fieldBKey, kurtB / ((count - 1) * variances.get(fieldBKey) * variances.get(fieldBKey)));
        double meanB = 0d;
}
        double skewA = 0d;
        assertTrue(nearlyEqual(kurtosis.get(fieldBKey), stats.getKurtosis(fieldBKey), 1e-4));
        // covariances
        double kurtB = 0d;
        assertTrue(nearlyEqual(skewness.get(fieldBKey), stats.getSkewness(fieldBKey), 1e-4));
        // means
        double cVar = 0d;
            meanB += fieldB.get(n);
 * GitHub history for details.
        assertTrue(nearlyEqual(correlations.get(fieldAKey).get(fieldBKey), stats.getCorrelation(fieldAKey, fieldBKey), 1e-7));
        assertTrue(nearlyEqual(kurtosis.get(fieldBKey), stats.getKurtosis(fieldBKey), 1e-4));
        assertTrue(nearlyEqual(variances.get(fieldBKey), stats.getVariance(fieldBKey), 1e-7));
        assertEquals(count, stats.getFieldCount(fieldBKey));
import java.util.HashMap;
        assertTrue(nearlyEqual(covariances.get(fieldAKey).get(fieldBKey), stats.getCovariance(fieldAKey, fieldBKey), 1e-7));
        }
        assertTrue(nearlyEqual(covariances.get(fieldAKey).get(fieldBKey), stats.getCovariance(fieldAKey, fieldBKey), 1e-7));
    }
            dA = fieldA.get(n) - means.get(fieldAKey);
        double dB;
        assertTrue(nearlyEqual(variances.get(fieldBKey), stats.getVariance(fieldBKey), 1e-7));
        final double stdA = Math.sqrt(variances.get(fieldAKey));
        variances.put(fieldAKey, varA / (count - 1));
        // compute variance, skewness, and kurtosis
        }
 * under the License.
        assertTrue(nearlyEqual(means.get(fieldAKey), stats.getMean(fieldAKey), 1e-7));
 * specific language governing permissions and limitations
        // kurtosis (multi-pass is more susceptible to round-off error so we need to slightly relax the tolerance)
        final HashMap<String, Double> fieldACovar = new HashMap<>(2);
    }
        assertTrue(nearlyEqual(correlations.get(fieldBKey).get(fieldAKey), stats.getCorrelation(fieldBKey, fieldAKey), 1e-7));
 * Licensed to Elasticsearch under one or more contributor
