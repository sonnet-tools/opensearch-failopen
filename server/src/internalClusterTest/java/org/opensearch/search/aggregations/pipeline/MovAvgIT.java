        testValues = new HashMap<>(8);
            Histogram.Bucket actual = actualIter.next();
        assertThat(deriv, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(1L));  
        for (int i = 0; i < period; i++) {  
        }
        assertThat(histo.getName(), equalTo("histo"));
                );
                            .modelBuilder(new LinearModel.LinearModelBuilder())  
        }  
                        // HW needs at least 2 periods of data to start
                        .interval(interval)
                    )  
            vs[counter] = v + padding;  
            .addAggregation(  
        } else {
        assertThat(histo, notNullValue());
 * this file be licensed under the Apache-2.0 license or a
        assertThat(histo, notNullValue());
                    .subAggregation(metric)
 * specific language governing permissions and limitations
        if (!expectedBucketIter.hasNext()) {
        );  
                        .addRange(0, 10)
            assertThat(avgAgg.value(), equalTo(10d));
                        break;
import java.util.HashMap;  
                            movingAvg("movavg_counts", "_count").window(numBuckets)
                            .gapPolicy(gapPolicy)
                expectedValue,  
    private void setupExpected(MovAvgType type, MetricTarget target, int windowSize) {  
                            .minimize(true)  
        }  
        HOLT("holt"),
        assertThat(movAvgAgg.value(), equalTo(10d));  
        bulkBuilder.get();
        assertThat(histo, notNullValue());  
    }
/*
        SearchResponse response = client().prepareSearch("neg_idx")
        assertThat(bucket, notNullValue());
                    .subAggregation(
            Double expectedCount = expectedCountsIter.next();  
            assertThat(bucket, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
    private static final String INTERVAL_FIELD = "l_value";
        for (int i = 20; i < 25; i++) {
 * compatible open source license.
import org.opensearch.common.settings.Settings;
            .get();  
    static double gamma;
                        .interval(interval)
            assertThat(bucket, notNullValue());
     */
                        )
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
        MovAvgType(String s) {
        prepareCreate("idx").setMapping(
                    .subAggregation(metric)
                                    .period(period)
            } else {
                        .subAggregation(
            );  
                    .interval(interval)
            fail("MovingAvg should not accept a window that is zero");  
    }
            fail("MovingAvg should not accept a prediction size that is negative");
            SimpleValue valuesMovAvg = actual.getAggregations().get("movavg_values");
            assertThat("[value] movavg is not null", valuesMovAvg, Matchers.nullValue());  
        while (actualIter.hasNext()) {  
     * Computed values are stored in the testValues map.
            assertBucketContents(actual, expectedCount, expectedValue);  
    }
                            movingAvg("movavg_counts", "the_metric").window(0)  
    }
        }  
                            .predict(12)
            )  
            s += vs[i];
            Double expectedCount = expectedCountsIter.next();  
                    histogram("histo").field(INTERVAL_FIELD)
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .subAggregation(
import org.opensearch.action.bulk.BulkRequestBuilder;
            assertThat(
    private double holtWinters(Collection<Double> window) {
        }  
            movAvgAgg = bucket.getAggregations().get("avg_movavg");
                        break;
        assertSearchResponse(response);
                    )
                equalTo(Double.NaN)
        assertSearchResponse(response);
            default:
        List<? extends Bucket> buckets = histo.getBuckets();
            assertThat(bucket.getKey(), equalTo(i - 10d));
            double metricValue;
        List<Double> expectedValues = testValues.get(MovAvgType.HOLT.name() + "_" + MetricTarget.VALUE.name());  
        }  
        ArrayList<Double> values = new ArrayList<>(numBuckets);
            for (int i = 0; i < period; i++) {  
                            .modelBuilder(new HoltLinearModel.HoltLinearModelBuilder().alpha(alpha).beta(beta))  
            client().prepareSearch("idx")
                    .interval(1)  
            window.offer(metricValue);
                    .extendedBounds(0L, interval * (numBuckets - 1))  
                    histogram("histo").field(INTERVAL_FIELD)
                    .subAggregation(randomMetric("the_metric", VALUE_FIELD))  
                return avg(name).field(field);
     */
                        values.add(holt(window));
                        movingAvg("movavg_counts", "_count").window(windowSize)  
        private final String name;
                            .predict(5)  
            // All Good
        List<Double> expectedCounts = testValues.get(MovAvgType.LINEAR.name() + "_" + MetricTarget.COUNT.name());
        numBuckets = randomIntBetween(6, 80);
        } catch (IllegalArgumentException e) {
                        movingAvg("movavg_values", "max").window(windowSize)
            assertThat(movAvgAgg.value(), equalTo(10d));
                    .subAggregation(
            .addAggregation(
                    .extendedBounds(0L, interval * (numBuckets - 1))  
        long current = 1;  
                        }  
                .get();
        for (int i = 0; i < 10; i++) {  
        derivMovAvg = bucket.getAggregations().get("deriv_movavg");
        }  
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
                    .extendedBounds(0L, interval * (numBuckets - 1))  
            if (mockBucket.count == 0 && target.equals(MetricTarget.VALUE)) {  
                                        .period(interval * 10)  
        } else if (Double.isNaN(expectedValue)) {
 * Modifications Copyright OpenSearch Contributors. See
                                .gapPolicy(gapPolicy)
        assertThat(histo.getName(), equalTo("histo"));  
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {  
     * Exponentially weighted (EWMA, Single exponential) moving avg
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
    }
                        } else {
            .addAggregation(  
            .get();  
            assertBucketContents(actual, expectedCount, expectedValue);
                b = value - last;
                        .extendedBounds(0L, interval * (numBuckets - 1))  
        }
import org.opensearch.action.index.IndexRequestBuilder;
        List<? extends Bucket> buckets = histo.getBuckets();
                "[_count] movavg should be NaN, but is [" + countMovAvg.value() + "] instead",
        last_s = s;  
     * If the minimizer is turned on, but there isn't enough data to minimize with, it will simply use  
    }
    }  
                    .interval(interval)
            assertThat(bucket.getDocCount(), equalTo(1L));
 * Licensed to Elasticsearch under one or more contributor  
        }  
            case 1:
            }
            counter += 1;
                            .modelBuilder(new EwmaModel.EWMAModelBuilder().alpha(alpha))  
    }  
            Double expectedCount = expectedCountsIter.next();  
        EWMA("ewma"),
            last = value;
    }
        assertThat(movAvgAgg, notNullValue());
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
                    range("histo").field(INTERVAL_FIELD)
            )
        }
        int idx = window.size() - period + (0 % period);  
                .startObject()
        // Trend value
            assertThat(movAvgAgg.value(), equalTo(10d));
                            .gapPolicy(gapPolicy)
                                .gapPolicy(gapPolicy)
            } else {
    public void testHoltSingleValuedField() {
            case 2:  
            assertThat(movAvgAgg, notNullValue());
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
            );
        } catch (IllegalArgumentException e) {
            Histogram.Bucket actual = actualIter.next();
                    )
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
            assertThat(movAvgAgg.value(), equalTo(10d));  
                    .extendedBounds(0L, interval * (numBuckets - 1))  
                    .setSource(jsonBuilder().startObject().field(INTERVAL_FIELD, i).field(VALUE_FIELD, 10).endObject())
                            .modelBuilder(new LinearModel.LinearModelBuilder())
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
                .addAggregation(  
                                new HoltWintersModel.HoltWintersModelBuilder().alpha(alpha)
            case 3:
     * Holt-Linear (Double exponential) moving avg
            .get();
                                    .period(period)
        for (MovAvgModelBuilder builder : builders) {  
            )  
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();  
                    .subAggregation(avg("avg").field(VALUE_FIELD))
                            .predict(12)
        List<? extends Bucket> buckets = histo.getBuckets();
            counter += 1;
            .addAggregation(  
                        .subAggregation(randomMetric("the_metric", VALUE_FIELD))
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
                    .setSource(jsonBuilder().startObject().field(INTERVAL_FIELD, i).field(VALUE_FIELD2, 10).endObject())  
    public void testNegativeWindow() {  
 * GitHub history for details.
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));  
        LINEAR("linear"),  
                histogram("histo").field(INTERVAL_FIELD)
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
                    : mockBucket.count;
                            movingAvg("movavg_counts", "_count").window(numBuckets)  
                return min(name).field(field);
                assertThat(movAvgAgg, nullValue());  
    /**
    }  
            client().prepareSearch("idx")
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.movingAvg;
        assertThat(histo, notNullValue());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                "[value] movavg should be NaN, but is [" + valuesMovAvg.value() + "] instead",  
        }
    public MovAvgIT(Settings staticSettings) {
                    .subAggregation(max("max2").field(VALUE_FIELD2))
                            .gapPolicy(BucketHelpers.GapPolicy.SKIP)  
                valuesMovAvg.value(),
        // Calculate first seasonal
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
            // All good
            assertThat("[value] movavg is null", valuesMovAvg, notNullValue());
                return new EwmaModel.EWMAModelBuilder().alpha(alpha + padding);
    static int period;
        List<Double> expectedValues = testValues.get(MovAvgType.EWMA.name() + "_" + MetricTarget.VALUE.name());  
        @Override  
    private double linear(Collection<Double> window) {  
        SimpleValue current = buckets.get(0).getAggregations().get("movavg_values");
        if (!expectedValuesIter.hasNext()) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * under the License.  
        for (int i = 2; i < 12; i++) {
                    .subAggregation(
    }
            Double expectedValue = expectedValuesIter.next();
            assertThat(bucket.getDocCount(), equalTo(0L));  
        assertSearchResponse(response);  
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
        double avg = 0;
                    .subAggregation(  
                        .subAggregation(randomMetric("the_metric", VALUE_FIELD))
                    )  
                        .extendedBounds(0L, interval * (numBuckets - 1))
                    .subAggregation(metric)
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();  
     */
        double b = 0;
                            .minimize(true)
     * test simple moving average on single value field
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
        Bucket bucket = buckets.get(0);
import org.opensearch.action.ActionRequestValidationException;  
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
                    .interval(interval)
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
            Double expectedValue = expectedValuesIter.next();  
                return new LinearModel.LinearModelBuilder();
     * the default settings.  Which means our mock histo will match the generated result (which it won't
                0.1 * Math.abs(countMovAvg.value())
        for (PipelineAggregationHelperTests.MockBucket mockBucket : mockHisto) {
    enum MetricTarget {  
    /**
                .addAggregation(  
                    )
        try {
                // a non-minimized set of coefficients. Just check for not-nullness
                            values.add(null);
                            )
            .addAggregation(  
                        movingAvg("deriv_movavg", "deriv").window(windowSize)
                0.1 * Math.abs(valuesMovAvg.value())
            SimpleValue movAvgAgg = bucket.getAggregations().get("movavg_values");  
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
        assertThat(histo.getName(), equalTo("histo"));
     */  
        assertThat(histo, notNullValue());
                seasonal[i] = gamma * (vs[i] - (last_s - last_b)) + (1 - gamma) * seasonal[i - period];
    @Override  
        }
        List<? extends Bucket> buckets = histo.getBuckets();
                                movingAvg("movavg_counts", "_count").window(numBuckets)  
                        .interval(interval)
                        .subAggregation(
            bulkBuilder.add(
     * @param window Window of values to compute movavg for
        for (int i = 0; i < 12; i++) {  
        } else {
        Histogram histo = response.getAggregations().get("histo");
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
        for (int i = 1; i < 20; i++) {
        for (double value : window) {  
                )  
        }
        expectThrows(
                        .extendedBounds(0L, interval * (numBuckets - 1))
            assertThat("[_count] movavg is null", countMovAvg, notNullValue());  
                                        .period(interval * 10)
            avg += value * current;  
        Histogram histo = response.getAggregations().get("histo");
            new Object[] {
        for (MovAvgType type : MovAvgType.values()) {  
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));  
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
                                .predict(-10)  
                client().prepareSearch("idx")
     * @param window Window of values to compute movavg for
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.search.SearchPhaseExecutionException;  
 * KIND, either express or implied.  See the License for the
                // this bucket wasn't supposed to have a value (empty, skipped, etc), so
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));  
            Bucket bucket = buckets.get(i);  
        seasonalityType = randomBoolean() ? HoltWintersModel.SeasonalityType.ADDITIVE : HoltWintersModel.SeasonalityType.MULTIPLICATIVE;
                                    .beta(beta)  
                    .subAggregation(
                    .subAggregation(
     */
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
    }
                            .gapPolicy(gapPolicy)
        assertThat(deriv, nullValue());  
import org.opensearch.action.support.WriteRequest;
            () -> client.prepareSearch("idx")  
            fail("Simple Model cannot be minimized, but an exception was not thrown");
                histogram("histo").field(INTERVAL_FIELD)
                        movingAvg("movavg_counts", "_count").window(windowSize)  
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
            Avg avgAgg = bucket.getAggregations().get("avg");  
                            movingAvg("movavg_counts", "the_metric").window(windowSize)
                    .subAggregation(avg("avg").field(VALUE_FIELD))
                            .gapPolicy(gapPolicy)
            if (seasonalityType.equals(HoltWintersModel.SeasonalityType.MULTIPLICATIVE)) {
            assertThat(  
            assertThat(deriv, notNullValue());
            }  
        List<Double> expectedCounts = testValues.get(MovAvgType.HOLT_WINTERS.name() + "_" + MetricTarget.COUNT.name());  
            assertThat(bucket.getDocCount(), equalTo(0L));  
                                .modelBuilder(
        return avg / totalWeight;
        return avg;  
        }  
                                .modelBuilder(new LinearModel.LinearModelBuilder())  
            assertThat(bucket.getDocCount(), equalTo(1L));  
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(25));
            if (counter == 0) {
        bucket = buckets.get(1);  
            );
    public static Collection<Object[]> parameters() {
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
                    metricValue = PipelineAggregationHelperTests.calculateMetric(docValues, metric);  
                            .gapPolicy(gapPolicy)  
                    .subAggregation(randomMetric("the_metric", VALUE_FIELD))  
                            )
        List<Double> expectedValues = testValues.get(MovAvgType.LINEAR.name() + "_" + MetricTarget.VALUE.name());  
                    .setSource(  
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())  
                    )
                .get();  
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();  
    }  
            current += 1;
        Client client = client();  
        while (actualIter.hasNext()) {
            assertThat(movAvgAgg, notNullValue());
    }
        assertThat(histo.getName(), equalTo("histo"));
            last_b = b;  
                            .minimize(false)  
                )
                    )
        if (expectedValue == null) {
            } else {
            Histogram.Bucket actual = actualIter.next();
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
        }
import java.util.ArrayList;  
        COUNT("count"),
    }
        }
                    metricValue = 0.0;
            .addAggregation(  
        // TODO perhaps pad out seasonal to a power of 2 and use a mask instead of modulo?
    private void assertValidIterators(Iterator expectedBucketIter, Iterator expectedCountsIter, Iterator expectedValuesIter) {  
        Iterator<Double> expectedValueIter = expectedValues.iterator();  
                                        .beta(beta)
        assertThat(derivMovAvg, Matchers.nullValue());                 // still null because of movavg delay  
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
import org.hamcrest.Matchers;
                assertThat(countMovAvg, notNullValue());  
                )
    }
                        if (window.size() >= period * 2) {
                )
        } catch (ActionRequestValidationException e) {
                                .modelBuilder(randomModelBuilder())
    public void testZeroPrediction() {
    }
 * software distributed under the License is distributed on an
 *
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
            new HoltLinearModel.HoltLinearModelBuilder(),  
                                    new HoltWintersModel.HoltWintersModelBuilder().alpha(alpha)
        }
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(deriv.value(), equalTo(0d));
        try {  
                    case HOLT_BIG_MINIMIZE:  
                    histogram("histo").field(INTERVAL_FIELD)
            IllegalArgumentException.class,
                    histogram("histo").field(INTERVAL_FIELD)
                    case EWMA:  
                        movingAvg("movavg_counts", "_count").window(windowSize)  
                            .modelBuilder(new HoltLinearModel.HoltLinearModelBuilder().alpha(alpha).beta(beta))
    public void testTwoMovAvgsWithPredictions() {
        SearchResponse response = client().prepareSearch("idx")
        // randomized testing too tricky. Should probably add dedicated, randomized tests just for HoltWinters,
            assertEquals(  
        switch (rand) {  
        List<Double> expectedValues = testValues.get(MovAvgType.HOLT_BIG_MINIMIZE.name() + "_" + MetricTarget.VALUE.name());
        for (int i = 10; i < 20; i++) {
        }
 * SPDX-License-Identifier: Apache-2.0
                    .subAggregation(max("max").field(VALUE_FIELD))
        SimpleValue valuesMovAvg = actual.getAggregations().get("movavg_values");
 * this work for additional information regarding copyright
                    .setSource(jsonBuilder().startObject().field(INTERVAL_FIELD, i).field(VALUE_FIELD, 10).endObject())  
        assertThat(histo, notNullValue());
                    setupExpected(type, target, numBuckets);  
    }
        SearchResponse response = client().prepareSearch("idx")
        List<Double> expectedCounts = testValues.get(MovAvgType.HOLT_WINTERS.name() + "_" + MetricTarget.COUNT.name());
        Histogram histo = response.getAggregations().get("histo");
        assertThat(bucket.getKey(), equalTo(1d));
     *  
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
            } else {
                        movingAvg("movavg_counts", "the_metric").window(windowSize)
                    .extendedBounds(0L, interval * (numBuckets - 1))  
        try {
                    ? PipelineAggregationHelperTests.calculateMetric(docValues, metric)  
        while (actualIter.hasNext()) {  
                }  
                        .subAggregation(  
            assertThat(movAvgAgg, notNullValue());
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
                .field("type", "double")
                            .modelBuilder(new HoltWintersModel.HoltWintersModelBuilder().period(period).seasonalityType(seasonalityType))  
        Histogram histo = response.getAggregations().get("histo");
                        break;
            assertThat(e.getMessage(), is("[window] must be a positive integer: [movavg_counts]"));
        period = randomIntBetween(1, 5);
import java.util.Arrays;
                    .addAggregation(  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;  
     * Simple, unweighted moving average  
        ensureSearchable();
    }
    /**  
                            .gapPolicy(gapPolicy)
            .addAggregation(  
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));  
                            .gapPolicy(gapPolicy)
        double padding = seasonalityType.equals(HoltWintersModel.SeasonalityType.MULTIPLICATIVE) ? 0.0000000001 : 0;
        List<IndexRequestBuilder> builders = new ArrayList<>();
        double last;
        if (!expectedCountsIter.hasNext()) {
                    .get();  
    public void testNegativePrediction() {  
    public void testPredictNegativeKeysAtStart() {  
                return new SimpleModel.SimpleModelBuilder();
            } else {  
                .get();
    }
     * if the minimizer is actually working, since the coefficients will be different and thus generate different
        SearchResponse response = client().prepareSearch("idx")
            )  
            .get();
    static List<PipelineAggregationHelperTests.MockBucket> mockHisto;  
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
                            .minimize(true)
    static HoltWintersModel.SeasonalityType seasonalityType;  
                            .subAggregation(
                            .gapPolicy(gapPolicy)
                fail("Model [" + builder.toString() + "] can be minimized, but an exception was thrown");
 * The OpenSearch Contributors require contributions made to  
        }
                assertThat(valuesMovAvg, notNullValue());
 * You may obtain a copy of the License at  
    /**
            .get();
            .addAggregation(  
            SimpleValue countMovAvg = actual.getAggregations().get("movavg_counts");
            assertThat(avgAgg, nullValue());
    public void testHoltWintersNotEnoughData() {
            );  
        }
        double last_s = 0;
                b = beta * (s - last_s) + (1 - beta) * last_b;
                        .subAggregation(
        // HoltWinters is excluded from random generation, because it's "cold start" behavior makes
        }  
import static org.opensearch.search.aggregations.AggregationBuilders.range;
        }  
            )
            assertThat(deriv.value(), equalTo(0d));
        double[] seasonal = new double[window.size()];
 */  
        }
                        .extendedBounds(0L, interval * (numBuckets - 1))  
                    .subAggregation(
                        .subAggregation(metric)
                        movingAvg("movavg_values", "the_metric").window(numBuckets)  
                .addAggregation(  
        for (PipelineAggregationHelperTests.MockBucket mockBucket : mockHisto) {
            bulkBuilder.add(
        assertSearchResponse(response);  
                        movingAvg("movavg_values", "the_metric").window(windowSize)
                        values.add(simple(window));
    private double holt(Collection<Double> window) {
                        .subAggregation(
            name = s;
            derivMovAvg = bucket.getAggregations().get("deriv_movavg");
                            movingAvg("movavg_counts", "the_metric").window(windowSize)  
                    .subAggregation(  
            }
                            .modelBuilder(new HoltLinearModel.HoltLinearModelBuilder().alpha(alpha).beta(beta))
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();  
                                        .seasonalityType(seasonalityType)  
                            .interval(interval)
                )
            )  
                            .predict(numPredictions)
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));  
        Histogram histo = response.getAggregations().get("histo");
        } catch (ActionRequestValidationException exception) {
                .get()
import org.opensearch.common.collect.EvictingQueue;  
            try {
    static double beta;  
     * @param window Window of values to compute movavg for
        }
            )  
import java.util.Map;  
    static double alpha;
                        )
            assertThat(avgAgg, notNullValue());
                                .gapPolicy(gapPolicy)
        }  
    private static final String VALUE_FIELD = "v_value";
            assertThat("[_count] movavg is not null", countMovAvg, nullValue());
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();  
                assertThat(countMovAvg, nullValue());
        }
     * These models are all minimizable, so they should not throw exceptions
                    )
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();  
        while (actualIter.hasNext()) {
            }
            .addAggregation(  
        }  
        while (actualIter.hasNext()) {
        internalCluster().wipeIndices("predict_non_empty");  
 *
 */  
                        )  
        }  
        }  
            case 3:
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
import org.opensearch.transport.client.Client;  
                            .gapPolicy(gapPolicy)
import org.opensearch.common.xcontent.XContentFactory;
    }
                        )
            assertThat(bucket.getKey(), equalTo(i - 10d));
                            .modelBuilder(new EwmaModel.EWMAModelBuilder().alpha(alpha))
                    case LINEAR:  
        }
        } else if (Double.isNaN(expectedCount)) {
    private MovAvgModelBuilder randomModelBuilder() {  
                            .gapPolicy(gapPolicy)
    }
            }
        public String toString() {
            client().prepareSearch("idx")
        SimpleValue derivMovAvg = bucket.getAggregations().get("deriv_movavg");
        List<? extends Bucket> buckets = histo.getBuckets();  
            new Object[] {
            Histogram.Bucket actual = actualIter.next();
        }  
            )  
                        .subAggregation(metric)  
                        .subAggregation(  
                seasonal[i] = vs[i] / s;
 * license agreements. See the NOTICE file distributed with
        HOLT_WINTERS("holt_winters"),  
        double s = 0;  
public class MovAvgIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                                .modelBuilder(new SimpleModel.SimpleModelBuilder())
                    )
                    .subAggregation(
        assertSearchResponse(response);  
                                    .seasonalityType(seasonalityType)  
        return randomModelBuilder(0);
 * not use this file except in compliance with the License.
            if (i < 15) {
            SimpleValue movAvgAgg = bucket.getAggregations().get("movavg_values");  
                histogram("histo").field(INTERVAL_FIELD)
                        movingAvg("movavg_counts", "the_metric").window(windowSize)
     * Linearly weighted moving avg
        int rand = randomIntBetween(0, 3);
        private final String name;  
    public void testCheckIfNonTunableCanBeMinimized() {  
            Double expectedValue = expectedValuesIter.next();
                            movingAvg("movavg_values", "the_metric").window(10)  
    public void testMinimizeNotEnoughData() {
        assertThat(histo, notNullValue());  
                    )  
                                .minimize(true)
     */  
     * <p>
            .get();
                    )
                        .subAggregation(randomMetric("the_metric", VALUE_FIELD))
    static BucketHelpers.GapPolicy gapPolicy;
            assertThat(bucket.getKey(), equalTo((double) i));
                    .subAggregation(derivative("deriv", "avg").gapPolicy(gapPolicy))
import java.util.List;
    public void testCheckIfTunableCanBeMinimized() {  
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
        }  
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                .endObject()
import static org.hamcrest.Matchers.equalTo;  
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())  
                    )
        for (double value : window) {  
            bucket = buckets.get(i);  
                seasonal[i] = gamma * (vs[i] / (last_s + last_b)) + (1 - gamma) * seasonal[i - period];  
                    .interval(interval)
                assertThat(movAvgAgg.value(), equalTo(10d));
            new EwmaModel.EWMAModelBuilder(),
                    )  
        VALUE("value"),
                // If there was a gap in doc counts and we are ignoring, just skip this bucket
            new Object[] {  
            assertThat(bucket.getDocCount(), equalTo(1L));  
     */  
        }
        SIMPLE("simple"),
 *  
                histogram("histo").field(INTERVAL_FIELD)  
            Histogram.Bucket actual = actualIter.next();  
        assertThat(bucket.getKey(), equalTo(0d));
                valuesMovAvg.value(),
                    case HOLT_WINTERS:  
                            .gapPolicy(gapPolicy)  
                                .gapPolicy(gapPolicy)
            assertThat(bucket.getKey(), equalTo((double) i));
            b = beta * (s - last_s) + (1 - beta) * last_b;  
    }
                avg = (value * alpha) + (avg * (1 - alpha));  
            last_b = b;  
                    .subAggregation(
        }
            } else {
            assertThat(movAvgAgg, notNullValue());  
                            .extendedBounds(0L, interval * (numBuckets - 1))  
                client().prepareIndex("predict_non_empty")
    private MovAvgModelBuilder randomModelBuilder(double padding) {
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));  
        List<Double> expectedValues = testValues.get(MovAvgType.SIMPLE.name() + "_" + MetricTarget.VALUE.name());  
        }  
                s = value;  
            }  
            .get();
        // Seasonal value
                    continue;
    static int numBuckets;  
                }
    public void testHoltWintersMinimization() {  
        assertSearchResponse(response);
                        values.add(linear(window));
        List<? extends Bucket> buckets = histo.getBuckets();
        assertThat(histo.getName(), equalTo("histo"));  
            }  
        }
        assertThat(histo.getName(), equalTo("histo"));
    }
        List<Double> expectedValues = testValues.get(MovAvgType.HOLT_WINTERS.name() + "_" + MetricTarget.VALUE.name());
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
 */
            .get();
        return s + (0 * b);  
            )
        // The minimizer is stochastic, so just make sure all the values coming back aren't null
        interval = 5;  
                return avg(name).field(field);  
                .addAggregation(
        List<Double> expectedValues = testValues.get(MovAvgType.HOLT_WINTERS.name() + "_" + MetricTarget.VALUE.name());
        List<Double> expectedCounts = testValues.get(MovAvgType.SIMPLE.name() + "_" + MetricTarget.COUNT.name());
        SearchResponse response = client().prepareSearch("double_predict")
                histogram("histo").field(INTERVAL_FIELD)
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
                    )
                                .minimize(true)  
            )  
                            .modelBuilder(new HoltLinearModel.HoltLinearModelBuilder().alpha(alpha).beta(beta))
                        .interval(interval)
        for (int i = 12; i < 24; i++) {
                // movavg should be null too  
                        .subAggregation(randomMetric("the_metric", VALUE_FIELD))  
                    )
    }
                                .modelBuilder(
                            .gapPolicy(gapPolicy)
        try {
    public void testLinearSingleValuedField() {
            assertThat(deriv, nullValue());  
                                .gapPolicy(gapPolicy)
            Arrays.fill(seasonal, 0.0);
                    .subAggregation(metric)
        Histogram histo = response.getAggregations().get("histo");
                    .interval(1)  
                    histogram("histo").field(INTERVAL_FIELD)
                            .gapPolicy(gapPolicy)
            fail("`expectedBucketIter` iterator ended before `actual` iterator, size mismatch");
            return (s + (1 * b)) * seasonal[idx];
            } else {
                // this bucket wasn't supposed to have a value (empty, skipped, etc), so
    public void testNoBucketsInHistogramWithPredict() {  
    public void testHoltWintersValuedField() {
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));  
        assertSearchResponse(response);  
                    )
                    .subAggregation(
        Histogram histo = response.getAggregations().get("histo");
                        break;
                        movingAvg("avg_movavg", "avg").window(windowSize)
        List<? extends Bucket> buckets = histo.getBuckets();
        assertThat(bucket, notNullValue());  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
            .get();
        return Arrays.asList(
                                        .beta(beta)  
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));  
                    .extendedBounds(0L, interval * (numBuckets - 1))
    /**  
                                .gapPolicy(gapPolicy)  
                    .interval(interval)
                        .subAggregation(
        Derivative deriv = bucket.getAggregations().get("deriv");
    private double simple(Collection<Double> window) {
        assertThat(histo.getName(), equalTo("histo"));
                                .gapPolicy(gapPolicy)  
    public void testSizeZeroWindow() {  
                        .setSource(jsonBuilder().startObject().field(INTERVAL_FIELD, mockBucket.key).field(VALUE_FIELD, value).endObject())  
package org.opensearch.search.aggregations.pipeline;
                    case SIMPLE:  
        int counter = 0;  
     */  
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
        mockHisto = PipelineAggregationHelperTests.generateHistogram(interval, numBuckets, randomDouble(), randomDouble());
    }
        avgAgg = bucket.getAggregations().get("avg");
                    .subAggregation(  
        }  
                                .gapPolicy(gapPolicy)
                    .interval(interval)
    private double ewma(Collection<Double> window) {  
                        movingAvg("movavg_values", "the_metric").window(windowSize)  
        }  
                histogram("histo").field(INTERVAL_FIELD)
        SearchResponse response = client().prepareSearch("idx")
    }
                        )  
                countMovAvg.value(),
                    .subAggregation(metric)
            );  
     * We can simulate this by setting the window size == size of histo
        double[] vs = new double[window.size()];
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();  
        List<? extends Bucket> buckets = histo.getBuckets();
        SearchResponse response = client().prepareSearch("idx")
        double b = 0;  
                                )
    static int windowSize;
                .get();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            SimpleValue movAvgAgg = bucket.getAggregations().get("movavg_values");
            for (MetricTarget target : MetricTarget.values()) {
            case 0:
            Bucket bucket = buckets.get(i);
/*  
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
            return name;
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
                avg = value;  
                                new HoltWintersModel.HoltWintersModelBuilder().alpha(alpha)
import static org.hamcrest.core.IsNull.notNullValue;
                    .interval(interval)
    }
     */
        assertSearchResponse(response);
        MetricTarget(String s) {
        assertThat(histo, notNullValue());  
    /**
        Avg avgAgg = bucket.getAggregations().get("avg");
import static org.opensearch.search.aggregations.AggregationBuilders.min;
        SimpleValue movAvgAgg = bucket.getAggregations().get("avg_movavg");
                            .gapPolicy(gapPolicy)
                // movavg should be null too
            .get();
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
        }
                    values.add(null);  
            for (double value : mockBucket.docValues) {  
    public void testPredictWithNonEmptyBuckets() throws Exception {
                        )
            } else {
                    setupExpected(type, target, windowSize);
        // Second bucket
            bucket = buckets.get(i);  
                    .subAggregation(
    }
                s = alpha * (vs[i] - seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);  
        }
                s = alpha * (vs[i] / seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
            assertThat(avgAgg, nullValue());  
        windowSize = randomIntBetween(period * 2, 10);  // start must be 2*period to play nice with HW  
                .addAggregation(
        testValues.put(type.name() + "_" + target.name(), values);
                "[value] movavg does not match expected [" + valuesMovAvg.value() + " vs " + expectedValue + "]",
                            movingAvg("movavg_counts", "_count").window(-10)  
                    case HOLT:  
        indexRandomForConcurrentSearch("predict_non_empty");  
            assertThat(derivMovAvg.value(), equalTo(0d));
        assertThat(histo, notNullValue());  
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
        assertThat(histo.getName(), equalTo("histo"));
        for (double v : window) {
                                        .seasonalityType(seasonalityType)
        assertThat(avgAgg.value(), equalTo(10d));
                    client().prepareIndex("idx")
import java.util.Collection;
                            )
                                .modelBuilder(new SimpleModel.SimpleModelBuilder())
import java.util.Iterator;
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(20));  
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
            name = s;  
            fail("`expectedValuesIter` iterator ended before `actual` iterator, size mismatch");
        int numPredictions = randomIntBetween(1, 10);
@OpenSearchIntegTestCase.SuiteScopeTestCase
        int rand = randomIntBetween(0, 3);
        for (double value : window) {
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
            avgAgg = bucket.getAggregations().get("avg");
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
                // a non-minimized set of coefficients. Just check for not-nullness
                s = alpha * value + (1.0d - alpha) * (last_s + last_b);  
        } catch (ActionRequestValidationException e) {
 * Unless required by applicable law or agreed to in writing,
        assertThat(histo, notNullValue());
                        )
        ).execute().get();
                .get();
        } else {
                    .interval(1)  
            }
        double last_b = 0;
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));  
                                    .modelBuilder(builder)
                } else {
                )
        SearchResponse response = client().prepareSearch("idx")
                    .interval(interval)
    /**  
                    .extendedBounds(0L, interval * (numBuckets - 1))  
        gamma = randomDouble();  
                .get();
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
        double movAvg = 0;
                        histogram("histo").field(INTERVAL_FIELD)
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();  
        assertSearchResponse(response);  
                assertThat(movAvgAgg, notNullValue());  
     */  
/*  
import org.opensearch.test.OpenSearchIntegTestCase;
        return movAvg;
                )
        boolean first = true;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;  
                metricValue = target.equals(MetricTarget.VALUE)
            assertThat(movAvgAgg.value(), equalTo(10d));
            Double expectedCount = expectedCountsIter.next();
        int counter = 0;  
            return name;
        List<Double> expectedCounts = testValues.get(MovAvgType.HOLT.name() + "_" + MetricTarget.COUNT.name());
            // All Good
            if (seasonalityType.equals(HoltWintersModel.SeasonalityType.MULTIPLICATIVE)) {  
    private ValuesSourceAggregationBuilder<? extends ValuesSourceAggregationBuilder<?>> randomMetric(String name, String field) {  
        assertThat(buckets.size(), equalTo(0));  
     * @param type      The moving average model to use  
            client().prepareSearch("idx")
        // which can compensate for the idiosyncrasies  
import static org.hamcrest.Matchers.is;
                                    .gamma(gamma)
                return new HoltLinearModel.HoltLinearModelBuilder().alpha(alpha + padding).beta(beta + padding);  
            last_s = s;
    /**  
                                    .gamma(gamma)
        gapPolicy = randomBoolean() ? BucketHelpers.GapPolicy.SKIP : BucketHelpers.GapPolicy.INSERT_ZEROS;  
            Double expectedCount = expectedCountsIter.next();
            .get();
        Histogram histo = response.getAggregations().get("histo");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    )  
                            .subAggregation(metric)
                        jsonBuilder().startObject().field(INTERVAL_FIELD, i).field(VALUE_FIELD, 10).field(VALUE_FIELD2, 10).endObject()
                                    .beta(beta)  
        List<? extends Bucket> buckets = histo.getBuckets();
        // Predictions
                            .minimize(false)  
        try {
            } catch (SearchPhaseExecutionException e) {
        SimpleValue countMovAvg = actual.getAggregations().get("movavg_counts");
     * Only some models can be minimized, should throw exception for: simple, linear
        assertSearchResponse(response);  
        }  
        createIndex("idx_unmapped");  
            Double expectedCount = expectedCountsIter.next();  
import org.opensearch.search.aggregations.metrics.Avg;
        assertThat(histo.getName(), equalTo("histo"));
        if (expectedCount == null) {  
            fail("MovingAvg should not accept non-histogram as parent");
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
                        .extendedBounds(0L, interval * (numBuckets - 1))  
        assertThat(avgAgg, notNullValue());  
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
                .endObject()  
    private static final String VALUE_FIELD2 = "v_value2";  
        }
    private void assertBucketContents(Histogram.Bucket actual, Double expectedCount, Double expectedValue) {  
            }
            totalWeight += current;
            fail("MovingAvg should not accept a window that is negative");  
                        .subAggregation(randomMetric("the_metric", VALUE_FIELD))
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));  
                client().prepareIndex("predict_non_empty")
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },  
            )
                        .interval(interval)  
            assertThat(derivMovAvg, notNullValue());  
            case 0:
                expectedCount,
        SearchResponse response = client().prepareSearch("predict_non_empty")
                if (gapPolicy.equals(BucketHelpers.GapPolicy.SKIP)) {
    static Map<String, ArrayList<Double>> testValues;
        SearchResponse response = client().prepareSearch("idx")
        b /= period;
 *    http://www.apache.org/licenses/LICENSE-2.0
                        values.add(holt(window));
        Histogram histo = response.getAggregations().get("histo");  
            .addAggregation(
    static ValuesSourceAggregationBuilder<? extends ValuesSourceAggregationBuilder<?>> metric;
                } else if (gapPolicy.equals(BucketHelpers.GapPolicy.INSERT_ZEROS)) {
                histogram("histo").field(INTERVAL_FIELD)
        Histogram histo = response.getAggregations().get("histo");  
            if (expectedValue == null) {  
            if (first) {
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(movAvgAgg, nullValue());  
        }
            );
        // Calculate the slopes between first and second season for each period
        List<Double> expectedCounts = testValues.get(MovAvgType.EWMA.name() + "_" + MetricTarget.COUNT.name());
                    )
                    .subAggregation(
                            .modelBuilder(
}  
        List<? extends Bucket> buckets = histo.getBuckets();  
                .startObject("properties")
                equalTo(Double.NaN)  
                        break;
                // If this isn't a gap, or is a _count, just insert the value
        assertThat(histo, notNullValue());  
                histogram("histo").field(INTERVAL_FIELD)
    }
            // all good
            assertEquals(
                .endObject()
                        )  
    public void testBadParent() {  
                }  
                                .predict(0)
                countMovAvg.value(),  
    public void testEwmaSingleValuedField() {
     *
        s /= period;
                                .gapPolicy(gapPolicy)
        MovAvgModelBuilder[] builders = new MovAvgModelBuilder[] {
            default:
        assertThat(avgAgg.value(), equalTo(10d));  
                    .subAggregation(
            fail("MovingAvg should not accept a prediction size that is zero");
        assertSearchResponse(response);  
                client().prepareIndex("double_predict")
                            .gapPolicy(gapPolicy)
            } else {
                            .gapPolicy(gapPolicy)
        assertThat(histo, notNullValue());  
            }
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
        super(staticSettings);  
                    )
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
                        movingAvg("movavg_counts", "_count").window(windowSize)
    @ParametersFactory  
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
        long totalWeight = 1;
        if (seasonalityType.equals(HoltWintersModel.SeasonalityType.MULTIPLICATIVE)) {  
                        .subAggregation(
            assertBucketContents(actual, expectedCount, expectedValue);
            if (expectedCount == null) {
        switch (rand) {
            );  
        while (actualIter.hasNext()) {  
            client().prepareSearch("idx")  
            }  
        Histogram histo = response.getAggregations().get("histo");
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
            .addAggregation(
        ensureSearchable();  
            assertThat(avgAgg.value(), equalTo(10d));
        } else {
                            .modelBuilder(
                    )  
    /**
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
        double last_s = 0;  
            Bucket bucket = buckets.get(i);  
        double last_b = 0;
            derivMovAvg = bucket.getAggregations().get("deriv_movavg");  
import static org.hamcrest.core.IsNull.nullValue;  
                .startObject(VALUE_FIELD)  
                                        .gamma(gamma)
                switch (type) {
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
                    .subAggregation(
        BulkRequestBuilder bulkBuilder = client().prepareBulk().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            }
            b += (vs[i + period] - vs[i]) / period;
        }  
    enum MovAvgType {
            new HoltWintersModel.HoltWintersModelBuilder() };
                .addAggregation(  
            Double expectedValue = expectedValuesIter.next();  
import static org.opensearch.search.aggregations.AggregationBuilders.max;  
            assertThat(bucket.getKey(), equalTo((double) i));
                        .extendedBounds(0L, interval * (numBuckets - 1))  
        assertThat(histo.getName(), equalTo("histo"));  
                histogram("histo").field(INTERVAL_FIELD)
     * Calculates the moving averages for a specific (model, target) tuple based on the previously generated mock histogram.  
            assertBucketContents(actual, expectedCount, expectedValue);  
        assertThat(buckets.size(), equalTo(0));
            Avg avgAgg = bucket.getAggregations().get("avg");
     * data)  
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
    }  
                return max(name).field(field);
    }
                        movingAvg("movavg_values", "the_metric").window(windowSize)
                    .subAggregation(
            movAvgAgg = bucket.getAggregations().get("avg_movavg");
            )
                        .subAggregation(
            builders.add(  
            assertBucketContents(actual, expectedCount, expectedValue);  
            assertThat(bucket, notNullValue());
        assertSearchResponse(response);
     * Holt winters (triple exponential) moving avg
        METRIC("metric");  
        List<Double> expectedCounts = testValues.get(MovAvgType.HOLT_BIG_MINIMIZE.name() + "_" + MetricTarget.COUNT.name());
        for (double value : window) {
                                    .gapPolicy(gapPolicy)
                                .modelBuilder(new SimpleModel.SimpleModelBuilder())  
                        movingAvg("movavg_values", "the_metric").window(windowSize)
            Histogram.Bucket actual = actualIter.next();  
        try {
                    .subAggregation(metric)
                        movingAvg("movavg_counts", "_count").window(windowSize)  
            client().prepareSearch("idx")
            Histogram.Bucket actual = actualIter.next();
                                        .gamma(gamma)
        double s = 0;
    }
            assertThat(bucket, notNullValue());
                            values.add(holtWinters(window));  
        }  
        for (int i = period; i < vs.length; i++) {
                        )  
        }  
        Histogram histo = response.getAggregations().get("histo");
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(24));  
            fail("Linear Model cannot be minimized, but an exception was not thrown");  
        metric = randomMetric("the_metric", VALUE_FIELD);
                .addAggregation(  
                first = false;
    }
                            movingAvg("movavg_counts", "_count").window(10)
                    // otherwise insert a zero instead of the true value  
        } catch (IllegalArgumentException exception) {
                    histogram("histo").field(INTERVAL_FIELD)  
            // Gaps only apply to metric values, not doc _counts
            XContentFactory.jsonBuilder()  
    }
        // Trend value  
        double avg = 0;
        // Initial level value is average of first season
                values.add(null);
                    .subAggregation(
        assertThat(current, nullValue());  
            assertThat(avgAgg, notNullValue());  
                    .subAggregation(
        // This is a gap bucket
        // Smoothed value
            .get();  
                .get();  
        }
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.derivative;  
                            .gapPolicy(gapPolicy)
            assertThat(e.getMessage(), is("[window] must be a positive integer: [movavg_counts]"));
        try {
            double[] docValues = mockBucket.docValues;  
        List<? extends Bucket> buckets = histo.getBuckets();
            Double expectedCount = expectedCountsIter.next();
                return new SimpleModel.SimpleModelBuilder();  
            movAvg += value;
                    .subAggregation(metric)  
                histogram("histo").field(INTERVAL_FIELD)
            Double expectedValue = expectedValueIter.next();
        );  
            builders.add(
        HOLT_BIG_MINIMIZE("holt");
                if (type.equals(MovAvgType.HOLT_BIG_MINIMIZE)) {
                        break;
        beta = randomDouble();
    static int interval;
     *
                        movingAvg("movavg_values", "the_metric").window(windowSize)
    public void testSimpleSingleValuedField() {
            // All good  
                "[_count] movavg does not match expected [" + countMovAvg.value() + " vs " + expectedCount + "]",
            fail("`expectedCountsIter` iterator ended before `actual` iterator, size mismatch");
            Double expectedValue = expectedValuesIter.next();
                            .minimize(true)  
                                )
            // Extra so there is a bucket that only has second field  
        for (int i = -10; i < 10; i++) {
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
                client().prepareIndex("neg_idx")
                    histogram("histo").field(INTERVAL_FIELD)
                        .extendedBounds(0L, interval * (numBuckets - 1))
        createIndex("predict_non_empty");  
                                .modelBuilder(new SimpleModel.SimpleModelBuilder())
        @Override
        indexRandom(true, builders);
                        .subAggregation(metric)
                    )  
            case 2:  
        while (actualIter.hasNext()) {
                // Note that we don't compare against the mock values, since those are assuming
        public String toString() {  
            deriv = bucket.getAggregations().get("deriv");
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(derivMovAvg, nullValue());  
                        .interval(interval)
                } else {
            assertThat(derivMovAvg, notNullValue());
            Double expectedValue = expectedValuesIter.next();
            if (window.size() > 0) {
        assertThat(avgAgg, notNullValue());
            assertThat(bucket, notNullValue());  
        assertThat(current, nullValue());
            assertThat(derivMovAvg.value(), equalTo(0d));
                            .modelBuilder(new HoltWintersModel.HoltWintersModelBuilder().period(period).seasonalityType(seasonalityType))  
                                    new HoltWintersModel.HoltWintersModelBuilder().alpha(alpha)  
     * @param window Window of values to compute movavg for
        movAvg /= window.size();  
                        .interval(interval)  
                            .gapPolicy(gapPolicy)
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
            avgAgg = bucket.getAggregations().get("avg");
                        movingAvg("movavg_values", "avg").window(windowSize)  
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
        deriv = bucket.getAggregations().get("deriv");  
                            .predict(5)
                            movingAvg("movavg_counts", "the_metric").window(windowSize)
        for (int i = 1; i < 20; i++) {
                assertThat(valuesMovAvg, nullValue());  
                            .gapPolicy(gapPolicy)
     * @param window Window of values to compute movavg for
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
            last_s = s;
     * @param target    The document field "target", e.g. _count or a field value
            );
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
                .addAggregation(
        } catch (IllegalArgumentException exception) {  
            deriv = bucket.getAggregations().get("deriv");  
        SearchResponse response = client().prepareSearch("idx")
                        movingAvg("movavg_counts", "_count").window(numBuckets)  
                        movingAvg("movavg_counts", "_count").window(windowSize)  
        // This is a gap bucket  
            assertBucketContents(actual, expectedCount, expectedValue);  
                        values.add(ewma(window));
                // Note that we don't compare against the mock values, since those are assuming  
     *  
                                .modelBuilder(randomModelBuilder())
                )  
                histogram("histo").field("test")
                    .interval(interval)
        movAvgAgg = bucket.getAggregations().get("avg_movavg");
    public void setupSuiteScopeCluster() throws Exception {
    public void testNoBucketsInHistogram() {  
            client().prepareSearch("idx")
                                    .seasonalityType(seasonalityType)  
            return s + (1 * b) + seasonal[idx];  
        SimpleValue current = buckets.get(0).getAggregations().get("movavg_values");
        List<? extends Bucket> buckets = histo.getBuckets();
    /**
        assertThat(bucket.getDocCount(), equalTo(1L));
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())  
                builders.add(
                        movingAvg("movavg_values", "the_metric").window(windowSize)
                histogram("histo").field("test")
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
                                    .minimize(true)  
    }
                    )
        alpha = randomDouble();
            }
