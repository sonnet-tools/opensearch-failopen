            default:
                    )
                        .subAggregation(
                        }
                .get();
                    .subAggregation(
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
                    histogram("histo").field(INTERVAL_FIELD)
                        .addRange(0, 10)
                    .interval(interval)
            for (int i = 0; i < period; i++) {
            assertThat(derivMovAvg, notNullValue());
            assertEquals(
        assertThat(histo.getName(), equalTo("histo"));
        COUNT("count"),
                b = beta * (s - last_s) + (1 - beta) * last_b;
        last_s = s;
        // Predictions
        LINEAR("linear"),
        public String toString() {
    static double gamma;
        assertThat(histo.getName(), equalTo("histo"));
        double last;
    public void testCheckIfNonTunableCanBeMinimized() {
            fail("MovingAvg should not accept non-histogram as parent");
     */
                                    .seasonalityType(seasonalityType)
                            .minimize(false)
        }
    public static Collection<Object[]> parameters() {
            assertThat(derivMovAvg.value(), equalTo(0d));
                    .subAggregation(randomMetric("the_metric", VALUE_FIELD))
                metricValue = target.equals(MetricTarget.VALUE)
    static List<PipelineAggregationHelperTests.MockBucket> mockHisto;
        assertSearchResponse(response);
                histogram("histo").field(INTERVAL_FIELD)
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
        while (actualIter.hasNext()) {
            .get();
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
            )
                values.add(null);
                            .modelBuilder(new HoltLinearModel.HoltLinearModelBuilder().alpha(alpha).beta(beta))
        }
                        .subAggregation(
            assertBucketContents(actual, expectedCount, expectedValue);
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
            .addAggregation(
        gapPolicy = randomBoolean() ? BucketHelpers.GapPolicy.SKIP : BucketHelpers.GapPolicy.INSERT_ZEROS;
        }
        }
                                    .gamma(gamma)
                                    .gapPolicy(gapPolicy)
                            .minimize(true)
                                .gapPolicy(gapPolicy)
            .get();
        List<Double> expectedCounts = testValues.get(MovAvgType.HOLT_WINTERS.name() + "_" + MetricTarget.COUNT.name());
    }
        alpha = randomDouble();
     *
    }
        EWMA("ewma"),
        assertThat(derivMovAvg, nullValue());
                            movingAvg("movavg_counts", "the_metric").window(windowSize)
                        movingAvg("movavg_counts", "_count").window(windowSize)
        Histogram histo = response.getAggregations().get("histo");
    public void testBadParent() {
                        .subAggregation(randomMetric("the_metric", VALUE_FIELD))
        mockHisto = PipelineAggregationHelperTests.generateHistogram(interval, numBuckets, randomDouble(), randomDouble());
        List<Double> expectedCounts = testValues.get(MovAvgType.HOLT_WINTERS.name() + "_" + MetricTarget.COUNT.name());
            assertThat(movAvgAgg, notNullValue());
            )
        return avg;
        List<? extends Bucket> buckets = histo.getBuckets();
                )
                    .subAggregation(max("max2").field(VALUE_FIELD2))
                .endObject()
            assertThat(
 * specific language governing permissions and limitations
            double metricValue;
                            .gapPolicy(gapPolicy)
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
            } else {
            // All Good
            if (expectedCount == null) {
        double s = 0;
     * @param target    The document field "target", e.g. _count or a field value
                        values.add(linear(window));
                    histogram("histo").field(INTERVAL_FIELD)
        List<Double> expectedCounts = testValues.get(MovAvgType.HOLT.name() + "_" + MetricTarget.COUNT.name());
                    .subAggregation(
                        break;
                client().prepareIndex("neg_idx")
                    case LINEAR:
        } catch (IllegalArgumentException e) {
                            .gapPolicy(gapPolicy)
                        .extendedBounds(0L, interval * (numBuckets - 1))
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
                    .subAggregation(
        } else {
 * compatible open source license.
            client().prepareSearch("idx")
                    histogram("histo").field(INTERVAL_FIELD)
        }
        // This is a gap bucket
                                .minimize(true)
                        movingAvg("avg_movavg", "avg").window(windowSize)
        SearchResponse response = client().prepareSearch("idx")
                    .subAggregation(
import java.util.List;
        derivMovAvg = bucket.getAggregations().get("deriv_movavg");
                histogram("histo").field(INTERVAL_FIELD)
                )
                        )
                    .subAggregation(avg("avg").field(VALUE_FIELD))
                    histogram("histo").field(INTERVAL_FIELD)
 * license agreements. See the NOTICE file distributed with
                    case HOLT:
                                .modelBuilder(new SimpleModel.SimpleModelBuilder())
            XContentFactory.jsonBuilder()
                    metricValue = PipelineAggregationHelperTests.calculateMetric(docValues, metric);
public class MovAvgIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                                        .beta(beta)
                                new HoltWintersModel.HoltWintersModelBuilder().alpha(alpha)
            } else {
                            .gapPolicy(gapPolicy)
                        movingAvg("movavg_counts", "_count").window(windowSize)
        // Second bucket
                    .interval(interval)
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
    }
            assertThat(bucket.getKey(), equalTo((double) i));
            movAvg += value;
            counter += 1;
            Double expectedCount = expectedCountsIter.next();
import org.opensearch.action.index.IndexRequestBuilder;
        seasonalityType = randomBoolean() ? HoltWintersModel.SeasonalityType.ADDITIVE : HoltWintersModel.SeasonalityType.MULTIPLICATIVE;
                        movingAvg("deriv_movavg", "deriv").window(windowSize)
        assertThat(current, nullValue());
            assertThat(movAvgAgg.value(), equalTo(10d));
        for (int i = -10; i < 10; i++) {
    public void testSimpleSingleValuedField() {
        } catch (ActionRequestValidationException e) {
            name = s;
        List<Double> expectedCounts = testValues.get(MovAvgType.EWMA.name() + "_" + MetricTarget.COUNT.name());
            vs[counter] = v + padding;
        assertThat(histo, notNullValue());
        assertThat(histo, notNullValue());
        }
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(24));
            assertBucketContents(actual, expectedCount, expectedValue);
        assertThat(histo.getName(), equalTo("histo"));
     * test simple moving average on single value field
    private double ewma(Collection<Double> window) {
        assertSearchResponse(response);
                            .gapPolicy(gapPolicy)
        } catch (ActionRequestValidationException exception) {
            assertThat(bucket.getKey(), equalTo((double) i));
 *
        BulkRequestBuilder bulkBuilder = client().prepareBulk().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
                    .interval(interval)
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
        if (expectedValue == null) {
        }
        int numPredictions = randomIntBetween(1, 10);
            assertBucketContents(actual, expectedCount, expectedValue);
            );
                            .gapPolicy(BucketHelpers.GapPolicy.SKIP)
        Iterator<Double> expectedValueIter = expectedValues.iterator();
        createIndex("predict_non_empty");
    /**
    static int numBuckets;
import org.opensearch.transport.client.Client;
                                    .gamma(gamma)
            Avg avgAgg = bucket.getAggregations().get("avg");
                        values.add(holt(window));
            assertThat(e.getMessage(), is("[window] must be a positive integer: [movavg_counts]"));
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
        SearchResponse response = client().prepareSearch("idx")
        assertThat(bucket, notNullValue());
            default:
                        } else {
        // TODO perhaps pad out seasonal to a power of 2 and use a mask instead of modulo?
                    .subAggregation(avg("avg").field(VALUE_FIELD))
                                .gapPolicy(gapPolicy)
 * KIND, either express or implied.  See the License for the
        try {
                )
        double b = 0;
                        .subAggregation(randomMetric("the_metric", VALUE_FIELD))
            assertThat(movAvgAgg.value(), equalTo(10d));
                                .modelBuilder(new SimpleModel.SimpleModelBuilder())
                            .predict(12)
        assertThat(derivMovAvg, Matchers.nullValue());                 // still null because of movavg delay
                    )
            assertThat(e.getMessage(), is("[window] must be a positive integer: [movavg_counts]"));
        gamma = randomDouble();
                histogram("histo").field(INTERVAL_FIELD)
 * Licensed to Elasticsearch under one or more contributor
            .get();
            totalWeight += current;
                                    .period(period)
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
                        .interval(interval)
        return s + (0 * b);
            .get();
            new HoltWintersModel.HoltWintersModelBuilder() };
            }
                            .gapPolicy(gapPolicy)
                    .extendedBounds(0L, interval * (numBuckets - 1))
        Histogram histo = response.getAggregations().get("histo");
        metric = randomMetric("the_metric", VALUE_FIELD);
                            movingAvg("movavg_counts", "_count").window(10)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            Bucket bucket = buckets.get(i);
        assertThat(histo.getName(), equalTo("histo"));
            new Object[] {
                    .subAggregation(
                                    .minimize(true)
        Histogram histo = response.getAggregations().get("histo");
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            movAvgAgg = bucket.getAggregations().get("avg_movavg");
        for (double value : window) {
                        .subAggregation(randomMetric("the_metric", VALUE_FIELD))
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                    )
                expectedCount,
        } catch (IllegalArgumentException exception) {
                        break;
                .addAggregation(
                    .subAggregation(
            Double expectedCount = expectedCountsIter.next();
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
    }
    private void setupExpected(MovAvgType type, MetricTarget target, int windowSize) {
                    .subAggregation(
        assertThat(histo.getName(), equalTo("histo"));
                            movingAvg("movavg_counts", "_count").window(numBuckets)
            if (seasonalityType.equals(HoltWintersModel.SeasonalityType.MULTIPLICATIVE)) {
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
        switch (rand) {
        } else {
        windowSize = randomIntBetween(period * 2, 10);  // start must be 2*period to play nice with HW
            return name;
                                    new HoltWintersModel.HoltWintersModelBuilder().alpha(alpha)
                            .gapPolicy(gapPolicy)
                    histogram("histo").field(INTERVAL_FIELD)
            }
                            .modelBuilder(
                        )
     */
                        movingAvg("movavg_counts", "_count").window(windowSize)
    private void assertValidIterators(Iterator expectedBucketIter, Iterator expectedCountsIter, Iterator expectedValuesIter) {
            } else {
                        movingAvg("movavg_counts", "the_metric").window(windowSize)
        }
            bulkBuilder.add(
            );
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
                    .subAggregation(
        try {
                return new SimpleModel.SimpleModelBuilder();
                                    .seasonalityType(seasonalityType)
    enum MetricTarget {
                histogram("histo").field(INTERVAL_FIELD)
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
     * the default settings.  Which means our mock histo will match the generated result (which it won't
        }
            avg += value * current;
            assertThat(avgAgg, notNullValue());
        if (Double.compare(s, 0.0) == 0 || Double.compare(s, -0.0) == 0) {
                s = alpha * (vs[i] / seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
        Histogram histo = response.getAggregations().get("histo");
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
                            .gapPolicy(gapPolicy)
        );
    private static final String VALUE_FIELD = "v_value";
            b += (vs[i + period] - vs[i]) / period;
            }
                        if (window.size() >= period * 2) {
     * @param type      The moving average model to use
        SearchResponse response = client().prepareSearch("predict_non_empty")
        assertThat(deriv, nullValue());
                            .subAggregation(
    static int windowSize;
        }
                                    .modelBuilder(builder)
 */
    public void testZeroPrediction() {
    }
            )
                        )
                        .extendedBounds(0L, interval * (numBuckets - 1))
                }
            .get();
    }
import static org.hamcrest.core.IsNull.notNullValue;
            assertThat(bucket.getKey(), equalTo(i - 10d));
                            .minimize(false)
                    .interval(1)
            Arrays.fill(seasonal, 0.0);
                return new HoltLinearModel.HoltLinearModelBuilder().alpha(alpha + padding).beta(beta + padding);
                            )
        long current = 1;
        List<Double> expectedCounts = testValues.get(MovAvgType.SIMPLE.name() + "_" + MetricTarget.COUNT.name());
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
        SearchResponse response = client().prepareSearch("neg_idx")
            )
                                new HoltWintersModel.HoltWintersModelBuilder().alpha(alpha)
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
            deriv = bucket.getAggregations().get("deriv");
            } else {
        }
                        )
     * @param window Window of values to compute movavg for
                    .subAggregation(
            new HoltLinearModel.HoltLinearModelBuilder(),
            Histogram.Bucket actual = actualIter.next();
        @Override
    static int period;
            );
        assertThat(bucket, notNullValue());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        prepareCreate("idx").setMapping(
        } else if (Double.isNaN(expectedValue)) {
                            movingAvg("movavg_counts", "the_metric").window(windowSize)
                            .gapPolicy(gapPolicy)
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
        assertThat(avgAgg, notNullValue());
                            .modelBuilder(new HoltLinearModel.HoltLinearModelBuilder().alpha(alpha).beta(beta))
        for (MovAvgType type : MovAvgType.values()) {
        }
        List<? extends Bucket> buckets = histo.getBuckets();
                                .gapPolicy(gapPolicy)
                    .subAggregation(
    public void testLinearSingleValuedField() {
                    .addAggregation(
                )
            fail("`expectedBucketIter` iterator ended before `actual` iterator, size mismatch");
                countMovAvg.value(),
     */
            assertThat(avgAgg, nullValue());
import java.util.ArrayList;
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
     * @param window Window of values to compute movavg for
        assertSearchResponse(response);
                                .modelBuilder(new SimpleModel.SimpleModelBuilder())
            Double expectedValue = expectedValueIter.next();
                first = false;
        avgAgg = bucket.getAggregations().get("avg");
                                        .gamma(gamma)
                .get();
        int rand = randomIntBetween(0, 3);
import org.opensearch.common.settings.Settings;
                    .subAggregation(
                    .extendedBounds(0L, interval * (numBuckets - 1))
                "[value] movavg should be NaN, but is [" + valuesMovAvg.value() + "] instead",
            assertThat(bucket.getDocCount(), equalTo(1L));
                    )
     * Holt-Linear (Double exponential) moving avg
            current += 1;
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
        return avg / totalWeight;
        SearchResponse response = client().prepareSearch("idx")
                    .interval(1)
        if (!expectedValuesIter.hasNext()) {
        List<Double> expectedValues = testValues.get(MovAvgType.HOLT_WINTERS.name() + "_" + MetricTarget.VALUE.name());
            Double expectedCount = expectedCountsIter.next();
        indexRandom(true, builders);
/*
 * Unless required by applicable law or agreed to in writing,
                            movingAvg("movavg_counts", "_count").window(-10)
    private static final String INTERVAL_FIELD = "l_value";
    }
    }
            () -> client.prepareSearch("idx")
     * Only some models can be minimized, should throw exception for: simple, linear
        movAvg /= window.size();
        HOLT_BIG_MINIMIZE("holt");
            } else {
        // Calculate first seasonal
                        break;
        assertThat(current, nullValue());
        SimpleValue derivMovAvg = bucket.getAggregations().get("deriv_movavg");
    /**
                    .subAggregation(
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
                b = value - last;
            assertThat("[value] movavg is not null", valuesMovAvg, Matchers.nullValue());
            s += vs[i];
    public void testNegativeWindow() {
        List<? extends Bucket> buckets = histo.getBuckets();
import org.opensearch.search.aggregations.metrics.Avg;
        int idx = window.size() - period + (0 % period);
    }
                    )
    /**
     * Holt winters (triple exponential) moving avg
        // Trend value
import org.opensearch.action.bulk.BulkRequestBuilder;
        MovAvgModelBuilder[] builders = new MovAvgModelBuilder[] {
            assertThat(avgAgg.value(), equalTo(10d));
        }
                    .subAggregation(metric)
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(histo.getName(), equalTo("histo"));
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
            Histogram.Bucket actual = actualIter.next();
    static BucketHelpers.GapPolicy gapPolicy;
            assertThat(bucket.getDocCount(), equalTo(0L));
                        values.add(simple(window));
            );
        } else if (Double.isNaN(expectedCount)) {
        }
        List<? extends Bucket> buckets = histo.getBuckets();
        }
        Derivative deriv = bucket.getAggregations().get("deriv");
    }
        SearchResponse response = client().prepareSearch("idx")
                histogram("histo").field(INTERVAL_FIELD)
                0.1 * Math.abs(countMovAvg.value())
    public void testNoBucketsInHistogramWithPredict() {
        // The minimizer is stochastic, so just make sure all the values coming back aren't null
            assertThat("[_count] movavg is null", countMovAvg, notNullValue());
        SimpleValue movAvgAgg = bucket.getAggregations().get("avg_movavg");
                    .extendedBounds(0L, interval * (numBuckets - 1))
                            movingAvg("movavg_values", "the_metric").window(10)
                    .interval(1)
                }
    public void testPredictNegativeKeysAtStart() {
                    metricValue = 0.0;
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
        double avg = 0;
            b = beta * (s - last_s) + (1 - beta) * last_b;
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
        List<Double> expectedValues = testValues.get(MovAvgType.SIMPLE.name() + "_" + MetricTarget.VALUE.name());
        double b = 0;
import static org.hamcrest.Matchers.is;
        assertThat(movAvgAgg, nullValue());
        }
        testValues = new HashMap<>(8);
        assertSearchResponse(response);
            last = value;
        bulkBuilder.get();
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
    }
            assertThat(movAvgAgg, notNullValue());
}
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
        Avg avgAgg = bucket.getAggregations().get("avg");
                        break;
     */
    }
        private final String name;
            .addAggregation(
        double last_b = 0;
                        .subAggregation(randomMetric("the_metric", VALUE_FIELD))
                            .gapPolicy(gapPolicy)
                    .interval(interval)
        assertThat(histo.getName(), equalTo("histo"));
        double[] vs = new double[window.size()];
                        movingAvg("movavg_values", "the_metric").window(windowSize)
            Double expectedCount = expectedCountsIter.next();
            derivMovAvg = bucket.getAggregations().get("deriv_movavg");
            movAvgAgg = bucket.getAggregations().get("avg_movavg");
        }
                            values.add(null);
            last_s = s;
                            .gapPolicy(gapPolicy)
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
                        .extendedBounds(0L, interval * (numBuckets - 1))
            avgAgg = bucket.getAggregations().get("avg");
        List<Double> expectedValues = testValues.get(MovAvgType.EWMA.name() + "_" + MetricTarget.VALUE.name());
 *
import static org.hamcrest.Matchers.equalTo;
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
        while (actualIter.hasNext()) {
        indexRandomForConcurrentSearch("predict_non_empty");
        double movAvg = 0;
    }
 */
        double padding = seasonalityType.equals(HoltWintersModel.SeasonalityType.MULTIPLICATIVE) ? 0.0000000001 : 0;
                assertThat(countMovAvg, notNullValue());
        assertSearchResponse(response);
    public void testTwoMovAvgsWithPredictions() {
                s = alpha * (vs[i] - seasonal[i - period]) + (1.0d - alpha) * (last_s + last_b);
            assertThat(bucket, notNullValue());
            }
                        movingAvg("movavg_values", "the_metric").window(numBuckets)
            assertBucketContents(actual, expectedCount, expectedValue);
                // Note that we don't compare against the mock values, since those are assuming
        SimpleValue countMovAvg = actual.getAggregations().get("movavg_counts");
        }
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
                    )
            case 2:
        } catch (ActionRequestValidationException e) {
        for (double v : window) {
        // Smoothed value
            .get();
                                )
                }
    public void testNegativePrediction() {
        List<? extends Bucket> buckets = histo.getBuckets();
                        values.add(ewma(window));
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
        for (int i = 1; i < 20; i++) {
                            .predict(numPredictions)
    static double beta;
        ensureSearchable();
        assertThat(bucket.getDocCount(), equalTo(1L));
        }
            } else {
            fail("`expectedValuesIter` iterator ended before `actual` iterator, size mismatch");
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.movingAvg;
        VALUE("value"),
        assertThat(buckets.size(), equalTo(0));
import static org.hamcrest.core.IsNull.nullValue;
                    .setSource(jsonBuilder().startObject().field(INTERVAL_FIELD, i).field(VALUE_FIELD, 10).endObject())
    }
import org.hamcrest.Matchers;
                // Note that we don't compare against the mock values, since those are assuming
                histogram("histo").field(INTERVAL_FIELD)
            Double expectedCount = expectedCountsIter.next();
        expectThrows(
 * ownership. Elasticsearch licenses this file to you under
     *
    static Map<String, ArrayList<Double>> testValues;
                    values.add(null);
                histogram("histo").field(INTERVAL_FIELD)
                .addAggregation(
                    .extendedBounds(0L, interval * (numBuckets - 1))
            Double expectedValue = expectedValuesIter.next();
 */
                } else if (gapPolicy.equals(BucketHelpers.GapPolicy.INSERT_ZEROS)) {
     */
                assertThat(movAvgAgg.value(), equalTo(10d));
            return s + (1 * b) + seasonal[idx];
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
            new EwmaModel.EWMAModelBuilder(),
                            .minimize(true)
                builders.add(
                s = alpha * value + (1.0d - alpha) * (last_s + last_b);
            assertThat(bucket, notNullValue());
            SimpleValue movAvgAgg = bucket.getAggregations().get("movavg_values");
                )
                            movingAvg("movavg_counts", "the_metric").window(windowSize)
                    .get();
        }
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
    private double linear(Collection<Double> window) {
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
        }
        for (int i = 12; i < 24; i++) {
        HOLT("holt"),
        assertThat(histo, notNullValue());
            assertThat(movAvgAgg, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
                        )
        List<Double> expectedCounts = testValues.get(MovAvgType.LINEAR.name() + "_" + MetricTarget.COUNT.name());
 * this file be licensed under the Apache-2.0 license or a
                countMovAvg.value(),
                histogram("histo").field(INTERVAL_FIELD)
                        movingAvg("movavg_values", "the_metric").window(windowSize)
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
                        .extendedBounds(0L, interval * (numBuckets - 1))
                            .interval(interval)
        assertSearchResponse(response);
            .addAggregation(
                return new EwmaModel.EWMAModelBuilder().alpha(alpha + padding);
                    // otherwise insert a zero instead of the true value
        try {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
        while (actualIter.hasNext()) {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
            window.offer(metricValue);
import org.opensearch.action.search.SearchResponse;
            assertThat(avgAgg, notNullValue());
    /**
        List<Double> expectedCounts = testValues.get(MovAvgType.HOLT_BIG_MINIMIZE.name() + "_" + MetricTarget.COUNT.name());
        }
            Double expectedCount = expectedCountsIter.next();
            }
                return min(name).field(field);
            .get();
    }
        }
    public void setupSuiteScopeCluster() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
                assertThat(valuesMovAvg, nullValue());
        for (int i = 20; i < 25; i++) {
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
    }
                        movingAvg("movavg_counts", "_count").window(windowSize)
        for (int i = 1; i < 20; i++) {
            // All good
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.derivative;
                    case SIMPLE:
        assertThat(bucket.getKey(), equalTo(1d));
                                        .seasonalityType(seasonalityType)
                    .setSource(jsonBuilder().startObject().field(INTERVAL_FIELD, i).field(VALUE_FIELD2, 10).endObject())
        ).execute().get();
     *
 * this work for additional information regarding copyright
    }
            bulkBuilder.add(
                // a non-minimized set of coefficients. Just check for not-nullness
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
import static org.opensearch.search.aggregations.AggregationBuilders.min;
    }
    }
            Double expectedValue = expectedValuesIter.next();
        }
            .get();
                        .subAggregation(
        List<Double> expectedValues = testValues.get(MovAvgType.HOLT_WINTERS.name() + "_" + MetricTarget.VALUE.name());
            if (mockBucket.count == 0 && target.equals(MetricTarget.VALUE)) {
                    .subAggregation(metric)
    private MovAvgModelBuilder randomModelBuilder() {
                seasonal[i] = gamma * (vs[i] - (last_s - last_b)) + (1 - gamma) * seasonal[i - period];
                    .subAggregation(
        try {
                    case EWMA:
        assertThat(bucket.getDocCount(), equalTo(1L));
                client().prepareSearch("idx")
                .addAggregation(
                .startObject("properties")
                            .gapPolicy(gapPolicy)
                    histogram("histo").field(INTERVAL_FIELD)
                        .interval(interval)
            bucket = buckets.get(i);
            }
    }
        deriv = bucket.getAggregations().get("deriv");
            if (counter == 0) {
        assertSearchResponse(response);
                            .modelBuilder(new HoltWintersModel.HoltWintersModelBuilder().period(period).seasonalityType(seasonalityType))
        }
        SearchResponse response = client().prepareSearch("idx")
            last_b = b;
            name = s;
                        movingAvg("movavg_counts", "_count").window(numBuckets)
        if (seasonalityType.equals(HoltWintersModel.SeasonalityType.MULTIPLICATIVE)) {
        Histogram histo = response.getAggregations().get("histo");
                                .modelBuilder(randomModelBuilder())
                    .setSource(jsonBuilder().startObject().field(INTERVAL_FIELD, i).field(VALUE_FIELD, 10).endObject())
                assertThat(valuesMovAvg, notNullValue());
        SimpleValue valuesMovAvg = actual.getAggregations().get("movavg_values");
        for (int i = 10; i < 20; i++) {
                    .extendedBounds(0L, interval * (numBuckets - 1))
    }
    }
                // a non-minimized set of coefficients. Just check for not-nullness
            fail("MovingAvg should not accept a prediction size that is zero");
    }
                                .modelBuilder(
        for (PipelineAggregationHelperTests.MockBucket mockBucket : mockHisto) {
                            .modelBuilder(new HoltLinearModel.HoltLinearModelBuilder().alpha(alpha).beta(beta))
                        .subAggregation(
        SearchResponse response = client().prepareSearch("idx")
            assertThat(bucket.getKey(), equalTo(i - 10d));
 * You may obtain a copy of the License at
                    .subAggregation(
        List<Double> expectedValues = testValues.get(MovAvgType.HOLT.name() + "_" + MetricTarget.VALUE.name());
        return Arrays.asList(
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
 * not use this file except in compliance with the License.
        List<? extends Bucket> buckets = histo.getBuckets();
        s /= period;
        }
import org.opensearch.test.OpenSearchIntegTestCase;
                .get();
            fail("Linear Model cannot be minimized, but an exception was not thrown");
            )
            .addAggregation(
                        movingAvg("movavg_values", "the_metric").window(windowSize)
     * Computed values are stored in the testValues map.
                // movavg should be null too
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
                    .interval(interval)
        assertThat(bucket.getKey(), equalTo(0d));
        SearchResponse response = client().prepareSearch("double_predict")
            // All good
            assertThat(avgAgg.value(), equalTo(10d));
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
        super(staticSettings);
            case 0:
            }
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        double avg = 0;
            new Object[] {
     */
                    .interval(interval)
        assertThat(histo, notNullValue());
                .addAggregation(
                            .modelBuilder(new EwmaModel.EWMAModelBuilder().alpha(alpha))
     * <p>
                )
        assertThat(histo, notNullValue());
        assertThat(deriv, notNullValue());
    public void testMinimizeNotEnoughData() {
    }
                } else {
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertSearchResponse(response);
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
            .addAggregation(
                "[_count] movavg should be NaN, but is [" + countMovAvg.value() + "] instead",
                .addAggregation(
/*
            builders.add(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .subAggregation(max("max").field(VALUE_FIELD))
        assertThat(histo, notNullValue());
        }
                        jsonBuilder().startObject().field(INTERVAL_FIELD, i).field(VALUE_FIELD, 10).field(VALUE_FIELD2, 10).endObject()
                            .modelBuilder(new LinearModel.LinearModelBuilder())
        movAvgAgg = bucket.getAggregations().get("avg_movavg");
            assertThat(bucket, notNullValue());
            assertThat(bucket, notNullValue());
            assertThat(
            Double expectedValue = expectedValuesIter.next();
import org.opensearch.common.xcontent.XContentFactory;
        }
                switch (type) {
    private MovAvgModelBuilder randomModelBuilder(double padding) {
            try {
import java.util.Arrays;
            if (seasonalityType.equals(HoltWintersModel.SeasonalityType.MULTIPLICATIVE)) {
                    )
            if (expectedValue == null) {
        assertThat(histo, notNullValue());
    public void testPredictWithNonEmptyBuckets() throws Exception {
                    .subAggregation(
            .get();
                        .subAggregation(
    @Override
        SearchResponse response = client().prepareSearch("idx")
            assertThat(bucket.getKey(), equalTo((double) i));
            client().prepareSearch("idx")
                                .gapPolicy(gapPolicy)
        testValues.put(type.name() + "_" + target.name(), values);
    public void testSizeZeroWindow() {
            derivMovAvg = bucket.getAggregations().get("deriv_movavg");
            // Extra so there is a bucket that only has second field
                        )
                client().prepareIndex("predict_non_empty")
        assertThat(avgAgg.value(), equalTo(10d));
            assertThat(derivMovAvg.value(), equalTo(0d));
        }
        List<? extends Bucket> buckets = histo.getBuckets();
            client().prepareSearch("idx")
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
                expectedValue,
                        )
                    .interval(interval)
    public void testHoltWintersNotEnoughData() {
        Histogram histo = response.getAggregations().get("histo");
        for (MovAvgModelBuilder builder : builders) {
                return avg(name).field(field);
                            movingAvg("movavg_counts", "_count").window(numBuckets)
        for (PipelineAggregationHelperTests.MockBucket mockBucket : mockHisto) {
                        movingAvg("movavg_counts", "the_metric").window(windowSize)
        List<Double> expectedValues = testValues.get(MovAvgType.HOLT_BIG_MINIMIZE.name() + "_" + MetricTarget.VALUE.name());
                                .gapPolicy(gapPolicy)
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
            case 3:
            .get();
            case 2:
        METRIC("metric");
                        histogram("histo").field(INTERVAL_FIELD)
                                .predict(-10)
                if (type.equals(MovAvgType.HOLT_BIG_MINIMIZE)) {
            Bucket bucket = buckets.get(i);
        assertThat(histo.getName(), equalTo("histo"));
                        .extendedBounds(0L, interval * (numBuckets - 1))
                            .minimize(true)
            }
                return new SimpleModel.SimpleModelBuilder();
            assertThat(deriv, notNullValue());
     */
                        .extendedBounds(0L, interval * (numBuckets - 1))
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
            Histogram.Bucket actual = actualIter.next();
                                        .seasonalityType(seasonalityType)
     * These models are all minimizable, so they should not throw exceptions
                    .subAggregation(
                        )
                            .modelBuilder(new HoltWintersModel.HoltWintersModelBuilder().period(period).seasonalityType(seasonalityType))
            assertThat("[_count] movavg is not null", countMovAvg, nullValue());
        }
        Histogram histo = response.getAggregations().get("histo");
    }
        }
        double last_b = 0;
        switch (rand) {
                assertThat(movAvgAgg, notNullValue());
    private double holt(Collection<Double> window) {
        if (!expectedCountsIter.hasNext()) {
                            .predict(12)
            .addAggregation(
 * GitHub history for details.
                    .subAggregation(
        Histogram histo = response.getAggregations().get("histo");
                .addAggregation(
                        .interval(interval)
    /**
            assertThat(movAvgAgg, notNullValue());
        EvictingQueue<Double> window = new EvictingQueue<>(windowSize);
    }
        @Override
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
        for (int i = 0; i < 12; i++) {
            last_s = s;
import java.util.Iterator;
                                .gapPolicy(gapPolicy)
    }
            .addAggregation(
                "[value] movavg does not match expected [" + valuesMovAvg.value() + " vs " + expectedValue + "]",
            SimpleValue movAvgAgg = bucket.getAggregations().get("movavg_values");
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
        }
        createIndex("idx_unmapped");
     * If the minimizer is turned on, but there isn't enough data to minimize with, it will simply use
        Histogram histo = response.getAggregations().get("histo");
        while (actualIter.hasNext()) {
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
    }
        for (double value : window) {
            }
                    )
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
                        .extendedBounds(0L, interval * (numBuckets - 1))
            SimpleValue countMovAvg = actual.getAggregations().get("movavg_counts");
        assertThat(movAvgAgg, notNullValue());
                            .predict(5)
    enum MovAvgType {
            // All Good
        period = randomIntBetween(1, 5);
        assertThat(movAvgAgg.value(), equalTo(10d));
        for (double value : window) {
     * Exponentially weighted (EWMA, Single exponential) moving avg
                    histogram("histo").field(INTERVAL_FIELD)
                            .gapPolicy(gapPolicy)
                // If this isn't a gap, or is a _count, just insert the value
        while (actualIter.hasNext()) {
            fail("MovingAvg should not accept a window that is negative");
            Double expectedValue = expectedValuesIter.next();
        int counter = 0;
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
                                movingAvg("movavg_counts", "_count").window(numBuckets)
                                        .gamma(gamma)
 *
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(25));
        MetricTarget(String s) {
                // this bucket wasn't supposed to have a value (empty, skipped, etc), so
        // Calculate the slopes between first and second season for each period
                    .setSource(
        internalCluster().wipeIndices("predict_non_empty");
                        movingAvg("movavg_values", "the_metric").window(windowSize)
    private double holtWinters(Collection<Double> window) {
        List<Double> expectedValues = testValues.get(MovAvgType.LINEAR.name() + "_" + MetricTarget.VALUE.name());
                "[_count] movavg does not match expected [" + countMovAvg.value() + " vs " + expectedCount + "]",
import org.opensearch.action.support.WriteRequest;
    }
    static int interval;
        } else {
        SimpleValue current = buckets.get(0).getAggregations().get("movavg_values");
        } catch (IllegalArgumentException e) {
                histogram("histo").field("test")
        // randomized testing too tricky. Should probably add dedicated, randomized tests just for HoltWinters,
        Histogram histo = response.getAggregations().get("histo");
     * @param window Window of values to compute movavg for
            } else {
            Avg avgAgg = bucket.getAggregations().get("avg");
                .addAggregation(
                valuesMovAvg.value(),
        while (actualIter.hasNext()) {
import static org.opensearch.search.aggregations.AggregationBuilders.max;
                        values.add(holt(window));
                                .gapPolicy(gapPolicy)
        while (actualIter.hasNext()) {
    public void testNoBucketsInHistogram() {
                        .subAggregation(
        // Initial level value is average of first season
                                    .beta(beta)
            )
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
     * if the minimizer is actually working, since the coefficients will be different and thus generate different
                    )
                s = value;
        }
                    )
            assertThat(deriv, nullValue());
    static double alpha;
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
            return (s + (1 * b)) * seasonal[idx];
        }
                        break;
            Double expectedValue = expectedValuesIter.next();
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
            new Object[] {
                            )
        int counter = 0;
    public void testCheckIfTunableCanBeMinimized() {
        assertSearchResponse(response);
                    .subAggregation(
            Double expectedValue = expectedValuesIter.next();
                    case HOLT_BIG_MINIMIZE:
        // Seasonal value
            counter += 1;
import java.util.Map;
                    )
 * software distributed under the License is distributed on an
                    .extendedBounds(0L, interval * (numBuckets - 1))
            .addAggregation(
 * The OpenSearch Contributors require contributions made to
        double s = 0;
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        } catch (IllegalArgumentException exception) {
                                        .period(interval * 10)
        for (int i = 0; i < period; i++) {
        List<? extends Bucket> buckets = histo.getBuckets();
            client().prepareSearch("idx")
                            .modelBuilder(
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
            Bucket bucket = buckets.get(i);
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
                                    .beta(beta)
            )
                        .subAggregation(metric)
        assertSearchResponse(response);
            .addAggregation(
                client().prepareIndex("predict_non_empty")
            if (first) {
                .get();
        }
    /**
                            .gapPolicy(gapPolicy)
        List<? extends Bucket> buckets = histo.getBuckets();
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
                    .subAggregation(metric)
                valuesMovAvg.value(),
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
                } else {
                    setupExpected(type, target, numBuckets);
        SIMPLE("simple"),
        assertSearchResponse(response);
                                .modelBuilder(
        bucket = buckets.get(1);
/*
            assertThat("[value] movavg is null", valuesMovAvg, notNullValue());
    static ValuesSourceAggregationBuilder<? extends ValuesSourceAggregationBuilder<?>> metric;
                avg = (value * alpha) + (avg * (1 - alpha));
                    )
            );
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
            // Gaps only apply to metric values, not doc _counts
        for (double value : window) {
     * We can simulate this by setting the window size == size of histo
        }
                    )
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(20));
            for (double value : mockBucket.docValues) {
                    .subAggregation(randomMetric("the_metric", VALUE_FIELD))
            case 1:
                    )
        } else {
                            values.add(holtWinters(window));
     * Linearly weighted moving avg
    public void testHoltWintersValuedField() {
            }
                            movingAvg("movavg_counts", "the_metric").window(0)
            if (i < 15) {
            }
            if (window.size() > 0) {
            )
        long totalWeight = 1;
                                .minimize(true)
            .get();
                        .interval(interval)
            assertThat(bucket, notNullValue());
     */
                            .gapPolicy(gapPolicy)
            assertThat(deriv.value(), equalTo(0d));
    /**
        try {
        Histogram histo = response.getAggregations().get("histo");
                        .subAggregation(metric)
    }
                                .modelBuilder(randomModelBuilder())
                        .subAggregation(metric)
    }
            assertThat(movAvgAgg.value(), equalTo(10d));
        boolean first = true;
            } else {
        List<? extends Bucket> buckets = histo.getBuckets();
            Histogram.Bucket actual = actualIter.next();
                                .modelBuilder(new SimpleModel.SimpleModelBuilder())
                            .extendedBounds(0L, interval * (numBuckets - 1))
            )
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
                equalTo(Double.NaN)
                        .setSource(jsonBuilder().startObject().field(INTERVAL_FIELD, mockBucket.key).field(VALUE_FIELD, value).endObject())
                    ? PipelineAggregationHelperTests.calculateMetric(docValues, metric)
        SimpleValue current = buckets.get(0).getAggregations().get("movavg_values");
            Histogram.Bucket actual = actualIter.next();
                            .minimize(true)
                .addAggregation(
            assertBucketContents(actual, expectedCount, expectedValue);
        double[] seasonal = new double[window.size()];
    /**
        assertThat(avgAgg.value(), equalTo(10d));
        }
        MovAvgType(String s) {
                                .gapPolicy(gapPolicy)
                    )
            client().prepareSearch("idx")
    /**
        ensureSearchable();
        assertThat(histo, notNullValue());
            .get();
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
                        .subAggregation(
    }
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
import java.util.Collection;
                        .interval(interval)
            deriv = bucket.getAggregations().get("deriv");
            .addAggregation(
        // HoltWinters is excluded from random generation, because it's "cold start" behavior makes
                .startObject()
import org.opensearch.action.search.SearchPhaseExecutionException;
        }
                    .subAggregation(metric)
            fail("MovingAvg should not accept a prediction size that is negative");
                seasonal[i] = gamma * (vs[i] / (last_s + last_b)) + (1 - gamma) * seasonal[i - period];
                equalTo(Double.NaN)
                    .subAggregation(metric)
                        movingAvg("movavg_counts", "_count").window(windowSize)
        int rand = randomIntBetween(0, 3);
                    )
        public String toString() {
                .endObject()
                        .subAggregation(randomMetric("the_metric", VALUE_FIELD))
                    )
            );
                                    new HoltWintersModel.HoltWintersModelBuilder().alpha(alpha)
                .get();
            return name;
                // movavg should be null too
    public void testHoltWintersMinimization() {
        interval = 5;
                    .subAggregation(derivative("deriv", "avg").gapPolicy(gapPolicy))
        assertThat(histo, notNullValue());
        Histogram histo = response.getAggregations().get("histo");
            case 3:
                        .subAggregation(
            client().prepareSearch("idx")
                avg = value;
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
                .get();
    }
        beta = randomDouble();
    private ValuesSourceAggregationBuilder<? extends ValuesSourceAggregationBuilder<?>> randomMetric(String name, String field) {
                        movingAvg("movavg_values", "the_metric").window(windowSize)
                return max(name).field(field);
            assertThat(avgAgg, nullValue());
                    )
                seasonal[i] = vs[i] / s;
        }
                .get()
                            .subAggregation(metric)
                    .extendedBounds(0L, interval * (numBuckets - 1))
 * under the License.
        ArrayList<Double> values = new ArrayList<>(numBuckets);
     * data)
        Bucket bucket = buckets.get(0);
        }
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = period; i < vs.length; i++) {
     */
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
            );
import static org.opensearch.search.aggregations.AggregationBuilders.range;
                            .gapPolicy(gapPolicy)
        HOLT_WINTERS("holt_winters"),
            Double expectedCount = expectedCountsIter.next();
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
                );
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
        try {
import org.opensearch.common.collect.EvictingQueue;
@OpenSearchIntegTestCase.SuiteScopeTestCase
                    case HOLT_WINTERS:
     * Simple, unweighted moving average
            case 0:
                        movingAvg("movavg_values", "the_metric").window(windowSize)
        assertThat(histo.getName(), equalTo("histo"));
        return movAvg;
        List<? extends Bucket> buckets = histo.getBuckets();
    public void testEwmaSingleValuedField() {
            IllegalArgumentException.class,
                // If there was a gap in doc counts and we are ignoring, just skip this bucket
 *    http://www.apache.org/licenses/LICENSE-2.0
        double last_s = 0;
        );
                            .gapPolicy(gapPolicy)
                                    .period(period)
                    setupExpected(type, target, windowSize);
            double[] docValues = mockBucket.docValues;
     * @param window Window of values to compute movavg for
                                        .period(interval * 10)
 * SPDX-License-Identifier: Apache-2.0
            SimpleValue valuesMovAvg = actual.getAggregations().get("movavg_values");
                    .subAggregation(
    }
    /**
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .interval(interval)
                histogram("histo").field(INTERVAL_FIELD)
        for (int i = 0; i < 10; i++) {
package org.opensearch.search.aggregations.pipeline;
import org.opensearch.action.ActionRequestValidationException;
        }
                            .modelBuilder(new EwmaModel.EWMAModelBuilder().alpha(alpha))
        }
        List<? extends Bucket> buckets = histo.getBuckets();
            }
                            )
                    range("histo").field(INTERVAL_FIELD)
        assertThat(histo, notNullValue());
        assertThat(histo, notNullValue());
        Client client = client();
                    .interval(interval)
            builders.add(
                        .interval(interval)
     *
            assertEquals(
        SearchResponse response = client().prepareSearch("idx")
                            .gapPolicy(gapPolicy)
        assertThat(histo.getName(), equalTo("histo"));
        }
            fail("MovingAvg should not accept a window that is zero");
    public void testHoltSingleValuedField() {
    private static final String VALUE_FIELD2 = "v_value2";
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
                                        .beta(beta)
        double last_s = 0;
            bucket = buckets.get(i);
                                .predict(0)
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
                .field("type", "double")
        }
                histogram("histo").field("test")
    }
                        break;
                        movingAvg("movavg_values", "max").window(windowSize)
            assertThat(bucket.getDocCount(), equalTo(1L));
        return randomModelBuilder(0);
                    )
                .startObject(VALUE_FIELD)
                0.1 * Math.abs(valuesMovAvg.value())
                assertThat(countMovAvg, nullValue());
                                .modelBuilder(new LinearModel.LinearModelBuilder())
    private void assertBucketContents(Histogram.Bucket actual, Double expectedCount, Double expectedValue) {
            }
                return new LinearModel.LinearModelBuilder();
            } else {
            assertThat(movAvgAgg.value(), equalTo(10d));
                            .predict(5)
        // which can compensate for the idiosyncrasies
            );
            fail("`expectedCountsIter` iterator ended before `actual` iterator, size mismatch");
            Histogram.Bucket actual = actualIter.next();
        if (!expectedBucketIter.hasNext()) {
    }
        // This is a gap bucket
            // all good
    private double simple(Collection<Double> window) {
            assertBucketContents(actual, expectedCount, expectedValue);
                    : mockBucket.count;
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
                        .interval(interval)
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
            client().prepareSearch("idx")
        assertThat(buckets.size(), equalTo(0));
            last_b = b;
                )
import java.util.HashMap;
            for (MetricTarget target : MetricTarget.values()) {
                if (gapPolicy.equals(BucketHelpers.GapPolicy.SKIP)) {
                    continue;
                    )
        assertThat(histo.getName(), equalTo("histo"));
        for (int i = 2; i < 12; i++) {
                client().prepareIndex("double_predict")
                histogram("histo").field(INTERVAL_FIELD)
                                .gapPolicy(gapPolicy)
                    .subAggregation(metric)
                        movingAvg("movavg_counts", "_count").window(windowSize)
        assertThat(avgAgg, notNullValue());
                fail("Model [" + builder.toString() + "] can be minimized, but an exception was thrown");
    public MovAvgIT(Settings staticSettings) {
                assertThat(movAvgAgg, nullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                                )
        private final String name;
        // Trend value
            assertThat(derivMovAvg, notNullValue());
                    .subAggregation(
            .addAggregation(
                            .modelBuilder(new SimpleModel.SimpleModelBuilder())
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
    static HoltWintersModel.SeasonalityType seasonalityType;
            )
     */
                        movingAvg("movavg_values", "avg").window(windowSize)
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
        assertThat(histo, notNullValue());
        assertSearchResponse(response);
        numBuckets = randomIntBetween(6, 80);
                    )
                        )
            SimpleValue movAvgAgg = bucket.getAggregations().get("movavg_values");
        b /= period;
                            .gapPolicy(gapPolicy)
            )
        }
            .addAggregation(
                // this bucket wasn't supposed to have a value (empty, skipped, etc), so
            assertThat(bucket.getDocCount(), equalTo(0L));
                .get();
        try {
                        .subAggregation(
            avgAgg = bucket.getAggregations().get("avg");
        }
                    )
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
                            .modelBuilder(new HoltLinearModel.HoltLinearModelBuilder().alpha(alpha).beta(beta))
                .endObject()
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
            fail("Simple Model cannot be minimized, but an exception was not thrown");
            Histogram.Bucket actual = actualIter.next();
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
                            .gapPolicy(gapPolicy)
                            .modelBuilder(new LinearModel.LinearModelBuilder())
                )
     * Calculates the moving averages for a specific (model, target) tuple based on the previously generated mock histogram.
            )
     * @param window Window of values to compute movavg for
                return avg(name).field(field);
                    .subAggregation(metric)
            assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(deriv.value(), equalTo(0d));
                    client().prepareIndex("idx")
            } catch (SearchPhaseExecutionException e) {
        if (expectedCount == null) {
    @ParametersFactory
                        // HW needs at least 2 periods of data to start
