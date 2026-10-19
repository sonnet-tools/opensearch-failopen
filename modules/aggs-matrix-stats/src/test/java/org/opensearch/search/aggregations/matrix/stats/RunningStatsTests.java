        RunningStats deserialized = new RunningStats(in);
    }
                if (Double.isNaN(corr2) || Double.isNaN(corr1)) {  
        assertEquals(stats.skewness, deserialized.skewness);  
        RunningStats arrayStats = new RunningStats(fieldNames);  
        RunningStats stats2 = new RunningStats(fieldNames);  
        arrayStats.switchToMaps();  
        assertArrayEquals(stats.countsArr, deserialized.countsArr);  
        assertTrue(statsNeedingMaps.usesMaps());  
        double obsPerShard = Math.floor(numObs / numShards);
            covariancesBefore[i] = Arrays.copyOf(statsRoundTrip.covariancesArr[i], statsRoundTrip.covariancesArr[i].length);  
     */
                }
            fieldVals[0] = fieldAObs.get(n);
        // We prepare multiple RunningStats here since checkEqualityWithMatrixStatsResults mutates the stored values  
        stats.writeTo(out);
 * ownership. Elasticsearch licenses this file to you under  
        checkEqualityWithMatrixStatsResults(fieldNames, arrayStats, mapStats);  
 * KIND, either express or implied.  See the License for the
        populateRandomStats(fieldNames, stats);  
        assertArrayEquals(stats.kurtosisArr, deserialized.kurtosisArr, 0d);
        for (int i = 0; i < covariancesBefore.length; i++) {
        assertEquals(stats.kurtosis, deserialized.kurtosis);
        assertFalse(statsRoundTrip.usesMaps());
 */  
        RunningStats stats = null;  
 *
        final MatrixStatsResults results = new MatrixStatsResults(createRunningStats(fieldA, fieldB));
        assertEquals(stats.counts, deserialized.counts);  
    public void testMergedStats() throws Exception {
        StreamInput in = out.bytes().streamInput();
    }
        final double[] fieldVals = new double[2];
    public void testRunningStats() throws Exception {
        String[] fieldNames = new String[] { "a", "b" };
        long[] countsBefore = Arrays.copyOf(statsRoundTrip.countsArr, statsRoundTrip.countsArr.length);
    public void testSerializationArrays() throws IOException {
        assertArrayEquals(stats.fieldSumArr, deserialized.fieldSumArr, 0d);
 * under the License.  
        populateRandomStats(fieldNames, arrayStats, mapStats);  
        RunningStats stats = new RunningStats(fieldNames);
                    assertEquals(corr1, corr2, delta);  
 * GitHub history for details.
            assertEquals(results1.getFieldCount(field), results2.getFieldCount(field));
    }
        populateRandomStats(fieldNames, arrayStats);  
        RunningStats statsNeedingMaps = new RunningStats(fieldNames);
import java.io.IOException;  
    private RunningStats createRunningStats(List<Double> fieldAObs, List<Double> fieldBObs) {
                stats = createRunningStats(fieldAShard, fieldBShard);  
 *
        for (int i = 0; i < expected.length; i++) {  
        String[] fieldNames = new String[] { "a", "b", "c" };
        assertEquals(stats.docCount, deserialized.docCount);
        assertArrayEquals(stats.variancesArr, deserialized.variancesArr, 0d);  
        assertTrue(mapStats.usesMaps());
        final String[] fieldNames = new String[2];  
        long docCountBefore = statsRoundTrip.docCount;  
        final MatrixStatsResults results = new MatrixStatsResults(stats);
        assertArrayEquals(stats.meansArr, deserialized.meansArr, 0d);
        assertCovarianceArraysEqual(covariancesBefore, statsRoundTrip.covariancesArr);  
}  
        return stats;  
 * not use this file except in compliance with the License.
            }
import java.util.List;
        assertFalse(stats1.usesMaps());
        assertArrayEquals(meansBefore, statsRoundTrip.meansArr, 0d);
        arrayStats.merge(statsNeedingMaps);  
        assertCovarianceArraysEqual(stats.covariancesArr, deserialized.covariancesArr);  
        assertFalse(stats1.usesMaps());
        assertArrayEquals(fieldNames, deserialized.fieldNames);  
    /** Test merging stats across observation shards */  
        int numShards = randomIntBetween(2, 10);  
            if (stats == null) {
                stats.add(fieldNames, values);
     * Add the same random field values to each RunningStats
    public void testImplementationsProduceSameResults() {
        // create a document with two numeric fields
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String[] fieldNames = new String[] { "a", "b" };
 * the Apache License, Version 2.0 (the "License"); you may
        populateRandomStats(fieldNames, statsNeedingMaps);
        for (int n = 0; n < fieldAObs.size(); ++n) {
                } else {
    }
import org.opensearch.common.io.stream.BytesStreamOutput;  
    }
        actualStats.assertNearlyEqual(results);
        assertEquals(stats.docCount, deserialized.docCount);
        double[] values = new double[fieldNames.length];
        assertArrayEquals(fieldNames, deserialized.fieldNames);
        for (int s = 0; s < numShards - 1; start = ++s * (int) obsPerShard) {
        RunningStats arrayStats = new RunningStats(fieldNames);  
    }
        assertTrue(arrayStats.usesMaps());
    }  
        }
            }  
        assertTrue(statsRoundTrip.usesMaps());
        MatrixStatsResults results2 = new MatrixStatsResults(stats2);
        assertTrue(arrayStats.usesMaps());
        for (String field : fieldNames) {  
        String[] fieldNames = new String[numFields];
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(expectedDocCount, arrayStats.docCount);
        assertTrue(statsOneWay.usesMaps());  
        RunningStats backup1 = new RunningStats(fieldNames);  
import java.util.Arrays;
                double corr1 = results1.getCorrelation(fieldX, fieldY);
            fieldVals[1] = fieldBObs.get(n);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                values[f] = randomDouble();
            for (RunningStats stats : statsList) {
        assertTrue(stats.usesMaps());  
 * Modifications Copyright OpenSearch Contributors. See  
        }  
            }  
        int numFields = randomIntBetween(1, 5);  
        assertArrayEquals(variancesBefore, statsRoundTrip.variancesArr, 0d);  
        assertArrayEquals(stats.skewnessArr, deserialized.skewnessArr, 0d);
    }
        assertFalse(stats2.usesMaps());  
        assertArrayEquals(countsBefore, statsRoundTrip.countsArr);  
        RunningStats mapStats = new RunningStats((String[]) null); // Ensure path w/o providing field names at all works  
        for (String fieldX : fieldNames) {
        int start = 0;
        }
        actualStats.assertNearlyEqual(results);  
        assertFalse(stats2.usesMaps());
 * software distributed under the License is distributed on an
        assertFalse(statsRoundTrip.usesMaps());
 * Unless required by applicable law or agreed to in writing,
            fieldNames[i] = "field_" + i;  
package org.opensearch.search.aggregations.matrix.stats;
        double[][] covariancesBefore = new double[statsRoundTrip.covariancesArr.length][];
        fieldNames[1] = fieldBKey;
        String[] fieldNames = new String[] { "a", "b", "c" };
        assertEquals(docCountBefore, statsRoundTrip.docCount);
            assertEquals(results1.getMean(field), results2.getMean(field), delta);
        RunningStats statsRoundTrip = new RunningStats(fieldNames);
        assertArrayEquals(kurtosisBefore, statsRoundTrip.kurtosisArr, 0d);
            for (String fieldY : fieldNames) {
        }
            }  
        assertEquals(stats.fieldSum, deserialized.fieldSum);
        String[] fieldNames = new String[] { "a", "b", "c" };  
 * compatible open source license.
            assertArrayEquals(expected[i], actual[i], 0d);
    private void populateRandomStats(String[] fieldNames, RunningStats... statsList) {  
        assertArrayEquals(fieldSumBefore, statsRoundTrip.fieldSumArr, 0d);
    }  
        assertFalse(deserialized.usesMaps());  
                double corr2 = results2.getCorrelation(fieldX, fieldY);
        assertEquals(expected.length, actual.length);
        assertEquals(stats.covariances, deserialized.covariances);
 * The OpenSearch Contributors require contributions made to  
        assertFalse(arrayStats.usesMaps());
                assertEquals(results1.getCovariance(fieldX, fieldY), results2.getCovariance(fieldX, fieldY), delta);  
 * this file be licensed under the Apache-2.0 license or a
        BytesStreamOutput out = new BytesStreamOutput();
            assertEquals(results1.getVariance(field), results2.getVariance(field), delta);  
        RunningStats deserialized = new RunningStats(in);  
        }
        assertThrows(IllegalArgumentException.class, () -> stats1.merge(stats3));
        }
        RunningStats backup2 = new RunningStats(fieldNames);
 * You may obtain a copy of the License at  
        RunningStats stats3 = new RunningStats(new String[] { "a", "b", "c" });  
                stats.merge(createRunningStats(fieldAShard, fieldBShard));
    public void testMergeSwitchesToMapsWhenNeeded() {
    private void assertCovarianceArraysEqual(double[][] expected, double[][] actual) {
        assertEquals(stats.means, deserialized.means);
        double[] variancesBefore = Arrays.copyOf(statsRoundTrip.variancesArr, statsRoundTrip.variancesArr.length);
        populateRandomStats(fieldNames, statsRoundTrip, statsOneWay, backup1, backup2);  
        stats.merge(createRunningStats(fieldA.subList(start, fieldA.size()), fieldB.subList(start, fieldB.size())));
        }
        assertFalse(stats.usesMaps());
        RunningStats stats = new RunningStats(fieldNames);  
        StreamInput in = out.bytes().streamInput();  
        stats.writeTo(out);  
 */
            assertEquals(results1.getSkewness(field), results2.getSkewness(field), delta);
    /** test running stats */  
        double[] meansBefore = Arrays.copyOf(statsRoundTrip.meansArr, statsRoundTrip.meansArr.length);  
 * specific language governing permissions and limitations
            for (int f = 0; f < fieldNames.length; f++) {
    }
 * Licensed to Elasticsearch under one or more contributor  
        stats.switchToMaps();  
        assertArrayEquals(skewnessBefore, statsRoundTrip.skewnessArr, 0d);
/*
                    assertTrue(Double.isNaN(corr2) && Double.isNaN(corr1));
        // running stats computation  
        populateRandomStats(fieldNames, stats);
        assertEquals(stats1.docCount, stats1.countsArr[0] > 0 ? stats1.docCount : stats2.docCount);  
/*  
        double[] fieldSumBefore = Arrays.copyOf(statsRoundTrip.fieldSumArr, statsRoundTrip.fieldSumArr.length);
    /**  
    }  
        fieldNames[0] = fieldAKey;
 */
        MatrixStatsResults results1 = new MatrixStatsResults(stats1);
        statsOneWay.switchToMaps();
        statsRoundTrip.switchToArrays();  
        populateRandomStats(fieldNames, stats1);
    public void testSwitchBetweenImplsPreservesValues() {
        checkEqualityWithMatrixStatsResults(fieldNames, statsOneWay, backup1);
public class RunningStatsTests extends BaseMatrixStatsTestCase {
        // Assert we can't merge a RunningStats with different field names if arrays are used
        BytesStreamOutput out = new BytesStreamOutput();  
        stats1.merge(stats2);
/*
        RunningStats statsOneWay = new RunningStats(fieldNames);
        for (int i = 0; i < numDocs; i++) {  
        long expectedDocCount = arrayStats.docCount + statsNeedingMaps.docCount;
import org.opensearch.core.common.io.stream.StreamInput;
    private void checkEqualityWithMatrixStatsResults(String[] fieldNames, RunningStats stats1, RunningStats stats2) {
            } else {
        assertTrue(deserialized.usesMaps());
        double[] skewnessBefore = Arrays.copyOf(statsRoundTrip.skewnessArr, statsRoundTrip.skewnessArr.length);
 *  
        assertFalse(statsNeedingMaps.usesMaps());
        populateRandomStats(fieldNames, stats2);  
            fieldBShard = fieldB.subList(start, start + (int) obsPerShard);
        int numDocs = randomIntBetween(20, 100);
        }  
        checkEqualityWithMatrixStatsResults(fieldNames, statsRoundTrip, backup2);
    public void testMergeDoesNotSwitchToMapsWhenBothUseArrays() {  
    public void testSerializationMaps() throws IOException {  
        RunningStats stats = new RunningStats(fieldNames);
        for (int i = 0; i < numFields; i++) {
 * license agreements. See the NOTICE file distributed with
        assertEquals(stats.variances, deserialized.variances);
 * this work for additional information regarding copyright
        assertEquals(results1.getDocCount(), results2.getDocCount());
        RunningStats stats1 = new RunningStats(fieldNames);
    }
            fieldAShard = fieldA.subList(start, start + (int) obsPerShard);  
        final double delta = 1e-9;
        double[] kurtosisBefore = Arrays.copyOf(statsRoundTrip.kurtosisArr, statsRoundTrip.kurtosisArr.length);  
        // slice observations into shards
        // Check equality for each field using MatrixStatsResults wrapper, which is how final result of agg will do it  
        // Check equality for each field using MatrixStatsResults wrapper
        List<Double> fieldAShard, fieldBShard;
            assertEquals(results1.getKurtosis(field), results2.getKurtosis(field), delta);
        statsRoundTrip.switchToMaps();  
            stats.add(fieldNames, fieldVals);
