    public void testInvalidLagSize() {
 * You may obtain a copy of the License at
        }
            Double lagValue;
import java.util.ArrayList;
     */
                )
        MetricTarget(String s) {
        }
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
/*
        for (MetricTarget target : MetricTarget.values()) {
            .get();
            fail("`expectedValuesIter` iterator ended before `actual` iterator, size mismatch");
    }
 * KIND, either express or implied.  See the License for the
                lagValue = Double.NaN;
        return Arrays.asList(
    private static final String VALUE_FIELD = "v_value";
            if (counter <= lag) {
            // Normalize null's to NaN
import static org.opensearch.search.aggregations.AggregationBuilders.max;
import static org.hamcrest.core.IsNull.notNullValue;
        }
            );
    static int interval;
            case 2:
            Histogram.Bucket actual = actualIter.next();
    static Map<String, ArrayList<Double>> testValues;
                } else {
                        .subAggregation(metric)
    private ValuesSourceAggregationBuilder<? extends ValuesSourceAggregationBuilder<?>> randomMetric(String name, String field) {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        while (actualIter.hasNext()) {
        EvictingQueue<Double> lagWindow = new EvictingQueue<>(lag);
 *
                    // otherwise insert a zero instead of the true value
            );
        int rand = randomIntBetween(0, 3);
 * ownership. Elasticsearch licenses this file to you under
            }
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));
                    metricValue = 0.0;
     * @param target    The document field "target", e.g. _count or a field value
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
    }
import static org.hamcrest.Matchers.closeTo;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        }
        @Override
        }
    public SerialDiffIT(Settings staticSettings) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        // This is a gap bucket
    static ValuesSourceAggregationBuilder<? extends ValuesSourceAggregationBuilder<?>> metric;
        SimpleValue countDiff = actual.getAggregations().get("diff_counts");
        }
 * specific language governing permissions and limitations
        testValues.put(target.toString(), values);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                values.add(diff);
                    metricValue = null;
        ArrayList<Double> values = new ArrayList<>(numBuckets);
        ensureSearchable();
            assertThat("[value] diff is null", valuesDiff, notNullValue());
                        .subAggregation(diff("diff_counts", "_count").lag(-1).gapPolicy(gapPolicy))
                    client().prepareIndex("idx")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            }
                    histogram("histo").field(INTERVAL_FIELD)
    @ParametersFactory
        gapPolicy = randomBoolean() ? BucketHelpers.GapPolicy.SKIP : BucketHelpers.GapPolicy.INSERT_ZEROS;
    /**
            setupExpected(target);
            assertThat(
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
                .get();
            Double metricValue;
        indexRandom(true, builders);
            } else {
                closeTo(expectedCount, 0.1)
import static org.hamcrest.core.IsNull.nullValue;
        }
import static org.hamcrest.Matchers.is;
            if (!Double.isNaN(metricValue) && !Double.isNaN(lagValue)) {
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();
 * Unless required by applicable law or agreed to in writing,
        if (expectedCount == null) {
 * compatible open source license.
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
        List<Double> expectedCounts = testValues.get(MetricTarget.COUNT.toString());
import static org.opensearch.search.aggregations.AggregationBuilders.min;
    static List<PipelineAggregationHelperTests.MockBucket> mockHisto;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
            assertThat(
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
    }
            client().prepareSearch("idx")
        assertThat(histo.getName(), equalTo("histo"));
            case 3:
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
    }
 * SPDX-License-Identifier: Apache-2.0
    }
 * Modifications Copyright OpenSearch Contributors. See
    private void setupExpected(MetricTarget target) {
        );
                        .interval(interval)
                    .subAggregation(metric)
 * license agreements. See the NOTICE file distributed with
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
            fail("`expectedBucketIter` iterator ended before `actual` iterator, size mismatch");
                histogram("histo").field(INTERVAL_FIELD)
                builders.add(
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));
        lag = randomIntBetween(1, numBuckets / 2);
    enum MetricTarget {
            return name;
    public static Collection<Object[]> parameters() {
        int counter = 0;
        COUNT("count");
        assertThat(histo, notNullValue());
        super(staticSettings);
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.diff;
 * software distributed under the License is distributed on an
    private void assertValidIterators(Iterator expectedBucketIter, Iterator expectedCountsIter, Iterator expectedValuesIter) {
        for (PipelineAggregationHelperTests.MockBucket mockBucket : mockHisto) {
        }
                metricValue = target.equals(MetricTarget.VALUE)
                );
            }
import static org.hamcrest.Matchers.equalTo;
 * GitHub history for details.
        }
import java.util.List;
 * this work for additional information regarding copyright
            // Still under the initial lag period, add nothing and move on
        if (!expectedCountsIter.hasNext()) {
    static int numBuckets;
 * under the License.
 *
                        .extendedBounds(0L, (long) (interval * (numBuckets - 1)))
            assertThat("[_count] diff is null", countDiff, notNullValue());
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
/*
                lagValue = lagWindow.peek();  // Peek here, because we rely on add'ing to always move the window
        } else {
 */
 * The OpenSearch Contributors require contributions made to
        Histogram histo = response.getAggregations().get("histo");
            // Gaps only apply to metric values, not doc _counts
            // Both have values, calculate diff and replace the "empty" bucket
        List<? extends Bucket> buckets = histo.getBuckets();
        createIndex("idx");
                if (gapPolicy.equals(BucketHelpers.GapPolicy.SKIP)) {
    public void testBasicDiff() {
            }
        for (PipelineAggregationHelperTests.MockBucket mockBucket : mockHisto) {
                "[value] diff does not match expected [" + valuesDiff.value() + " vs " + expectedValue + "]",
public class SerialDiffIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        private final String name;
import java.util.Collection;
                    : mockBucket.count;
            double[] docValues = mockBucket.docValues;
        }
    }
/*
            Double expectedValue = expectedValuesIter.next();
                return avg(name).field(field);
        assertSearchResponse(response);
        if (!expectedBucketIter.hasNext()) {
                return min(name).field(field);
                closeTo(expectedValue, 0.1)
    }
            assertBucketContents(actual, expectedCount, expectedValue);
 *
}
        if (!expectedValuesIter.hasNext()) {
            default:
import java.util.Iterator;
    static BucketHelpers.GapPolicy gapPolicy;
        try {
 * Licensed to Elasticsearch under one or more contributor
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
    static int lag;
import org.opensearch.common.collect.EvictingQueue;
            new Object[] {
            case 0:
                .addAggregation(
            if (metricValue == null) {
 * the Apache License, Version 2.0 (the "License"); you may
                "[_count] diff does not match expected [" + countDiff.value() + " vs " + expectedCount + "]",
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                countDiff.value(),
                    .extendedBounds(0L, (long) (interval * (numBuckets - 1)))
                    .interval(interval)
                } else if (gapPolicy.equals(BucketHelpers.GapPolicy.INSERT_ZEROS)) {
                return max(name).field(field);
                return avg(name).field(field);
                    ? PipelineAggregationHelperTests.calculateMetric(docValues, metric)
                    .subAggregation(diff("diff_values", "the_metric").lag(lag).gapPolicy(gapPolicy))
 * not use this file except in compliance with the License.
                values.add(null);   // The tests need null, even though the agg doesn't
import java.util.HashMap;
    private static final String INTERVAL_FIELD = "l_value";
            name = s;
        public String toString() {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            new Object[] {
            .addAggregation(
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        // This is a gap bucket
            fail("`expectedCountsIter` iterator ended before `actual` iterator, size mismatch");
@OpenSearchIntegTestCase.SuiteScopeTestCase
            if (mockBucket.count == 0 && target.equals(MetricTarget.VALUE)) {
            assertThat("[_count] diff is not null", countDiff, nullValue());
import org.hamcrest.Matchers;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            lagWindow.add(metricValue);
            counter += 1;
 * this file be licensed under the Apache-2.0 license or a
        numBuckets = randomIntBetween(10, 80);
    public void setupSuiteScopeCluster() throws Exception {
        } else {
        SearchResponse response = client().prepareSearch("idx")
    private void assertBucketContents(Histogram.Bucket actual, Double expectedCount, Double expectedValue) {
 */
    }
 */
            assertThat(e.getMessage(), is("[lag] must be a positive integer: [diff_counts]"));
    @Override
                // If this isn't a gap, or is a _count, just insert the value
        }
            } else {
                        .setSource(jsonBuilder().startObject().field(INTERVAL_FIELD, mockBucket.key).field(VALUE_FIELD, value).endObject())
        }
        mockHisto = PipelineAggregationHelperTests.generateHistogram(interval, numBuckets, randomDouble(), randomDouble());
        if (expectedValue == null) {
            for (double value : mockBucket.docValues) {
        testValues = new HashMap<>(8);
            }
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.action.search.SearchResponse;
        metric = randomMetric("the_metric", VALUE_FIELD);
    }
        SimpleValue valuesDiff = actual.getAggregations().get("diff_values");
        List<Double> expectedValues = testValues.get(MetricTarget.VALUE.toString());
                double diff = metricValue - lagValue;
            assertThat("[value] diff is not null", valuesDiff, Matchers.nullValue());
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
            Double expectedCount = expectedCountsIter.next();
                metricValue = Double.NaN;
import org.opensearch.action.index.IndexRequestBuilder;
import org.opensearch.common.settings.Settings;
        }
        switch (rand) {
import java.util.Map;
        } catch (IllegalArgumentException e) {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
package org.opensearch.search.aggregations.pipeline;
            )
    }
                    metricValue = PipelineAggregationHelperTests.calculateMetric(docValues, metric);
        VALUE("value"),
                valuesDiff.value(),
            } else {
            new Object[] {
                }
        createIndex("idx_unmapped");
        List<IndexRequestBuilder> builders = new ArrayList<>();
                // If there was a gap in doc counts and we are ignoring, just skip this bucket
        interval = 5;
                    .subAggregation(diff("diff_counts", "_count").lag(lag).gapPolicy(gapPolicy))
import java.util.Arrays;
