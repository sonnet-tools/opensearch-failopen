        // compute mean
class MultiPassStats {
    private static boolean nearlyEqual(double a, double b, double epsilon) {
        assertTrue(nearlyEqual(variances.get(fieldBKey), stats.getVariance(fieldBKey), 1e-7));
        // variances
            return true;
 * The OpenSearch Contributors require contributions made to  
        // means
        // covariances
        assertTrue(nearlyEqual(skewness.get(fieldAKey), stats.getSkewness(fieldAKey), 1e-4));  
 * ownership. Elasticsearch licenses this file to you under  
        }  
}
            skewA += dA * dA * dA;
        assertTrue(nearlyEqual(variances.get(fieldAKey), stats.getVariance(fieldAKey), 1e-7));  
import static org.junit.Assert.assertEquals;
        assertTrue(nearlyEqual(covariances.get(fieldBKey).get(fieldAKey), stats.getCovariance(fieldBKey, fieldAKey), 1e-7));
        double varA = 0d;
        skewness.put(fieldBKey, skewB / ((count - 1) * variances.get(fieldBKey) * stdB));  
/*
        assertTrue(nearlyEqual(covariances.get(fieldAKey).get(fieldBKey), stats.getCovariance(fieldAKey, fieldBKey), 1e-7));  
        double cVar = 0d;
        fieldACorr.put(fieldAKey, 1d);
    }
        assertTrue(nearlyEqual(correlations.get(fieldAKey).get(fieldBKey), stats.getCorrelation(fieldAKey, fieldBKey), 1e-7));  
            // relative error is less meaningful here
    private Map<String, Double> kurtosis = new HashMap<>();
    private Map<String, HashMap<String, Double>> covariances = new HashMap<>();
        double meanA = 0d;
        means.put(fieldBKey, meanB / count);
        final HashMap<String, Double> fieldBCovar = new HashMap<>(2);
 * this work for additional information regarding copyright
        double corr = covariances.get(fieldAKey).get(fieldBKey);  
        assertTrue(nearlyEqual(variances.get(fieldAKey), stats.getVariance(fieldAKey), 1e-7));  
        this.fieldBKey = fieldBName;
        assertTrue(nearlyEqual(kurtosis.get(fieldBKey), stats.getKurtosis(fieldBKey), 1e-4));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
    void assertNearlyEqual(InternalMatrixStats stats) {
        assertTrue(nearlyEqual(covariances.get(fieldAKey).get(fieldBKey), stats.getCovariance(fieldAKey, fieldBKey), 1e-7));  
            return diff / Math.min((absA + absB), Double.MAX_VALUE) < epsilon;
        assertTrue(nearlyEqual(skewness.get(fieldAKey), stats.getSkewness(fieldAKey), 1e-4));  
 * Licensed to Elasticsearch under one or more contributor  
        assertTrue(nearlyEqual(means.get(fieldAKey), stats.getMean(fieldAKey), 1e-7));  
 *
        // skewness (multi-pass is more susceptible to round-off error so we need to slightly relax the tolerance)
        final double absA = Math.abs(a);
        fieldBCorr.put(fieldBKey, 1d);  
        double kurtB = 0d;
        fieldACovar.put(fieldBKey, cVar);
        double dB;  
        final HashMap<String, Double> fieldBCorr = new HashMap<>();
        assertTrue(nearlyEqual(kurtosis.get(fieldAKey), stats.getKurtosis(fieldAKey), 1e-4));  
        assertTrue(nearlyEqual(variances.get(fieldBKey), stats.getVariance(fieldBKey), 1e-7));
    private Map<String, Double> variances = new HashMap<>();
        final HashMap<String, Double> fieldACovar = new HashMap<>(2);
        // compute correlation  
    private long count;  
        double kurtA = 0d;  
        fieldACovar.put(fieldAKey, 1d);  
        means.put(fieldAKey, meanA / count);
        final double stdB = Math.sqrt(variances.get(fieldBKey));
 * license agreements. See the NOTICE file distributed with
        assertTrue(nearlyEqual(kurtosis.get(fieldBKey), stats.getKurtosis(fieldBKey), 1e-4));
        } else { // use relative error  
        assertTrue(nearlyEqual(means.get(fieldBKey), stats.getMean(fieldBKey), 1e-7));
        corr /= stdA * stdB;
        double meanB = 0d;
        assertTrue(nearlyEqual(correlations.get(fieldAKey).get(fieldBKey), stats.getCorrelation(fieldAKey, fieldBKey), 1e-7));  
 */  
        fieldACorr.put(fieldBKey, corr);
        this.fieldAKey = fieldAName;  
        double skewA = 0d;
        } else if (a == 0 || b == 0 || diff < Double.MIN_NORMAL) {
            dB = fieldB.get(n) - means.get(fieldBKey);
 * You may obtain a copy of the License at  
            varB += dB * dB;
        assertEquals(count, stats.getFieldCount(fieldAKey));  
        // means
        assertTrue(nearlyEqual(skewness.get(fieldBKey), stats.getSkewness(fieldBKey), 1e-4));
    private Map<String, Double> means = new HashMap<>();
            // a or b is zero or both are extremely close to it  
        double skewB = 0d;
 * not use this file except in compliance with the License.
    }
        // covariances
        assertEquals(count, stats.getDocCount());
import java.util.HashMap;  
import java.util.Map;
    private final String fieldBKey;
        double varB = 0d;  
        final double stdA = Math.sqrt(variances.get(fieldAKey));
        // skewness (multi-pass is more susceptible to round-off error so we need to slightly relax the tolerance)
            // fieldA  
        assertTrue(nearlyEqual(kurtosis.get(fieldAKey), stats.getKurtosis(fieldAKey), 1e-4));  
        kurtosis.put(fieldBKey, kurtB / ((count - 1) * variances.get(fieldBKey) * variances.get(fieldBKey)));
        }  
        final double diff = Math.abs(a - b);
            return diff < (epsilon * Double.MIN_NORMAL);
        variances.put(fieldBKey, varB / (count - 1));  
            kurtA += dA * dA * dA * dA;  
package org.opensearch.search.aggregations.matrix.stats;
        assertEquals(count, stats.getFieldCount(fieldAKey));  
        fieldBCovar.put(fieldBKey, 1d);  
        // kurtosis (multi-pass is more susceptible to round-off error so we need to slightly relax the tolerance)
/*
        correlations.put(fieldAKey, fieldACorr);  
        // set count
        fieldBCorr.put(fieldAKey, corr);
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(nearlyEqual(skewness.get(fieldBKey), stats.getSkewness(fieldBKey), 1e-4));
    void computeStats(final List<Double> fieldA, final List<Double> fieldB) {
        covariances.put(fieldBKey, fieldBCovar);
    }
import static org.junit.Assert.assertTrue;
            meanB += fieldB.get(n);
        // correlation
        // variances
        }
        final double absB = Math.abs(b);  
        fieldBCovar.put(fieldAKey, cVar);
 * Modifications Copyright OpenSearch Contributors. See  
        // kurtosis (multi-pass is more susceptible to round-off error so we need to slightly relax the tolerance)
/*  
import java.util.List;
        assertTrue(nearlyEqual(correlations.get(fieldBKey).get(fieldAKey), stats.getCorrelation(fieldBKey, fieldAKey), 1e-7));
        // compute variance, skewness, and kurtosis
 * specific language governing permissions and limitations
 *  
 * GitHub history for details.
        correlations.put(fieldBKey, fieldBCorr);
 * KIND, either express or implied.  See the License for the
        for (int n = 0; n < count; ++n) {
        assertTrue(nearlyEqual(correlations.get(fieldBKey).get(fieldAKey), stats.getCorrelation(fieldBKey, fieldAKey), 1e-7));
        variances.put(fieldAKey, varA / (count - 1));
        // compute covariance
    private Map<String, Double> skewness = new HashMap<>();  
    private final String fieldAKey;  
        final HashMap<String, Double> fieldACorr = new HashMap<>();
 */
 *
        for (int n = 0; n < count; ++n) {
 * compatible open source license.
        assertEquals(count, stats.getDocCount());
    void assertNearlyEqual(MatrixStatsResults stats) {
        covariances.put(fieldAKey, fieldACovar);  
            skewB += dB * dB * dB;  
        if (a == b) { // shortcut, handles infinities  
 * this file be licensed under the Apache-2.0 license or a
    private Map<String, HashMap<String, Double>> correlations = new HashMap<>();  
        assertTrue(nearlyEqual(means.get(fieldBKey), stats.getMean(fieldBKey), 1e-7));
        assertTrue(nearlyEqual(covariances.get(fieldBKey).get(fieldAKey), stats.getCovariance(fieldBKey, fieldAKey), 1e-7));
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // correlation
        kurtosis.put(fieldAKey, kurtA / ((count - 1) * variances.get(fieldAKey) * variances.get(fieldAKey)));
            kurtB += dB * dB * dB * dB;
    MultiPassStats(String fieldAName, String fieldBName) {
            dA = fieldA.get(n) - means.get(fieldAKey);  
        skewness.put(fieldAKey, skewA / ((count - 1) * variances.get(fieldAKey) * stdA));
        assertEquals(count, stats.getFieldCount(fieldBKey));
            cVar += dA * dB;
 */
        double dA;
 * SPDX-License-Identifier: Apache-2.0
            varA += dA * dA;
        count = fieldA.size();  
        assertTrue(nearlyEqual(means.get(fieldAKey), stats.getMean(fieldAKey), 1e-7));  
            meanA += fieldA.get(n);
        cVar /= count - 1;
 * Unless required by applicable law or agreed to in writing,
    }
        assertEquals(count, stats.getFieldCount(fieldBKey));
 * software distributed under the License is distributed on an
