            Histogram.Bucket actual = actualIter.next();
            new Object[] {
            // Gaps only apply to metric values, not doc _counts
                return min(name).field(field);  
            assertThat(e.getMessage(), is("[lag] must be a positive integer: [diff_counts]"));
    @ParametersFactory
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                )
        List<Double> expectedValues = testValues.get(MetricTarget.VALUE.toString());  
                double diff = metricValue - lagValue;
 */
                return avg(name).field(field);
            assertValidIterators(expectedBucketIter, expectedCountsIter, expectedValuesIter);
    public static Collection<Object[]> parameters() {
    }
 *
    private void assertValidIterators(Iterator expectedBucketIter, Iterator expectedCountsIter, Iterator expectedValuesIter) {
import org.opensearch.common.collect.EvictingQueue;
    static int lag;
        // This is a gap bucket
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    .subAggregation(diff("diff_counts", "_count").lag(lag).gapPolicy(gapPolicy))
        Iterator<Double> expectedCountsIter = expectedCounts.iterator();
            case 0:
            } else {  
            new Object[] {  
                    .subAggregation(diff("diff_values", "the_metric").lag(lag).gapPolicy(gapPolicy))
            .get();
        COUNT("count");
     * @param target    The document field "target", e.g. _count or a field value  
                    .interval(interval)
            if (mockBucket.count == 0 && target.equals(MetricTarget.VALUE)) {  
                        .extendedBounds(0L, (long) (interval * (numBuckets - 1)))
        }
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
            Double expectedCount = expectedCountsIter.next();  
 * specific language governing permissions and limitations
            assertThat("[value] diff is not null", valuesDiff, Matchers.nullValue());  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        assertThat("Size of buckets array is not correct.", buckets.size(), equalTo(mockHisto.size()));  
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.diff;
            }
        SimpleValue valuesDiff = actual.getAggregations().get("diff_values");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
        }
            assertThat("doc counts do not match", actual.getDocCount(), equalTo((long) expected.count));
    }  
            new Object[] {
            )  
import static org.hamcrest.Matchers.equalTo;
            assertThat("[_count] diff is null", countDiff, notNullValue());
            } else {
 * Modifications Copyright OpenSearch Contributors. See
                lagValue = lagWindow.peek();  // Peek here, because we rely on add'ing to always move the window
        switch (rand) {
    public SerialDiffIT(Settings staticSettings) {  
     */
    /**
        }
            if (counter <= lag) {
                        .subAggregation(diff("diff_counts", "_count").lag(-1).gapPolicy(gapPolicy))  
        );
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }  
            );
                return avg(name).field(field);  
            if (!Double.isNaN(metricValue) && !Double.isNaN(lagValue)) {
    @Override
                    metricValue = null;  
            Double metricValue;
                    .extendedBounds(0L, (long) (interval * (numBuckets - 1)))
    static int numBuckets;  
            default:
        }
                closeTo(expectedCount, 0.1)
        ArrayList<Double> values = new ArrayList<>(numBuckets);  
import static org.opensearch.search.aggregations.AggregationBuilders.max;
 * The OpenSearch Contributors require contributions made to  
            PipelineAggregationHelperTests.MockBucket expected = expectedBucketIter.next();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
                } else {
        testValues = new HashMap<>(8);
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
    enum MetricTarget {
                    client().prepareIndex("idx")
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        @Override  
        }  
        testValues.put(target.toString(), values);  
import org.opensearch.action.search.SearchResponse;
        VALUE("value"),  
                );  
        SearchResponse response = client().prepareSearch("idx")
                    : mockBucket.count;  
        indexRandom(true, builders);
        private final String name;  
            case 3:  
        // This is a gap bucket  
                lagValue = Double.NaN;
                metricValue = target.equals(MetricTarget.VALUE)
        for (PipelineAggregationHelperTests.MockBucket mockBucket : mockHisto) {
            case 2:
        if (!expectedCountsIter.hasNext()) {
        public String toString() {
        MetricTarget(String s) {
    private void assertBucketContents(Histogram.Bucket actual, Double expectedCount, Double expectedValue) {
            }  
            fail("`expectedValuesIter` iterator ended before `actual` iterator, size mismatch");  
import static org.hamcrest.Matchers.is;
            counter += 1;  
        }
        gapPolicy = randomBoolean() ? BucketHelpers.GapPolicy.SKIP : BucketHelpers.GapPolicy.INSERT_ZEROS;  
            assertThat("[_count] diff is not null", countDiff, nullValue());
        if (!expectedBucketIter.hasNext()) {
    }  
                "[value] diff does not match expected [" + valuesDiff.value() + " vs " + expectedValue + "]",
        lag = randomIntBetween(1, numBuckets / 2);
import static org.hamcrest.core.IsNull.nullValue;
    }
                } else if (gapPolicy.equals(BucketHelpers.GapPolicy.INSERT_ZEROS)) {
        if (expectedCount == null) {
    static Map<String, ArrayList<Double>> testValues;  
            if (metricValue == null) {
        Histogram histo = response.getAggregations().get("histo");
            } else {
/*
                    // otherwise insert a zero instead of the true value
 * license agreements. See the NOTICE file distributed with
            name = s;  
        interval = 5;
import java.util.Arrays;  
    public void testInvalidLagSize() {
    }
        assertSearchResponse(response);  
import org.opensearch.action.index.IndexRequestBuilder;  
public class SerialDiffIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        if (expectedValue == null) {
            return name;
                return max(name).field(field);
                .get();
            }
        Iterator<Double> expectedValuesIter = expectedValues.iterator();
import java.util.List;
        return Arrays.asList(  
        EvictingQueue<Double> lagWindow = new EvictingQueue<>(lag);
                        .subAggregation(metric)
                "[_count] diff does not match expected [" + countDiff.value() + " vs " + expectedCount + "]",  
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
            // Still under the initial lag period, add nothing and move on
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<Double> expectedCounts = testValues.get(MetricTarget.COUNT.toString());
        for (PipelineAggregationHelperTests.MockBucket mockBucket : mockHisto) {
        }
/*  
        }
                        .setSource(jsonBuilder().startObject().field(INTERVAL_FIELD, mockBucket.key).field(VALUE_FIELD, value).endObject())
        SimpleValue countDiff = actual.getAggregations().get("diff_counts");  
        ensureSearchable();
 * KIND, either express or implied.  See the License for the
            lagWindow.add(metricValue);
    private void setupExpected(MetricTarget target) {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;  
            assertBucketContents(actual, expectedCount, expectedValue);  
            assertThat("[value] diff is null", valuesDiff, notNullValue());
            }
        }
 */  
                        .interval(interval)  
import org.opensearch.common.settings.Settings;  
        metric = randomMetric("the_metric", VALUE_FIELD);
 * this work for additional information regarding copyright
        }
    }
 * You may obtain a copy of the License at  
import static org.hamcrest.core.IsNull.notNullValue;  
            Double lagValue;  
                metricValue = Double.NaN;  
            double[] docValues = mockBucket.docValues;  
            fail("`expectedCountsIter` iterator ended before `actual` iterator, size mismatch");  
        }
import org.opensearch.test.OpenSearchIntegTestCase;
                if (gapPolicy.equals(BucketHelpers.GapPolicy.SKIP)) {
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        }
import static org.opensearch.search.aggregations.AggregationBuilders.avg;  
                // If this isn't a gap, or is a _count, just insert the value  
        assertThat(histo, notNullValue());  
    }
            Double expectedValue = expectedValuesIter.next();
                    .subAggregation(metric)  
                builders.add(  
import java.util.HashMap;
import java.util.Iterator;  
        List<? extends Bucket> buckets = histo.getBuckets();
        try {
        int rand = randomIntBetween(0, 3);
                valuesDiff.value(),
                }  
                closeTo(expectedValue, 0.1)  
            );  
            assertThat("keys do not match", ((Number) actual.getKey()).longValue(), equalTo(expected.key));  
import org.hamcrest.Matchers;  
import java.util.Collection;
        numBuckets = randomIntBetween(10, 80);  
            assertThat(
 * SPDX-License-Identifier: Apache-2.0
                    histogram("histo").field(INTERVAL_FIELD)
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    public void setupSuiteScopeCluster() throws Exception {  
                .addAggregation(
}
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        for (MetricTarget target : MetricTarget.values()) {  
                    metricValue = PipelineAggregationHelperTests.calculateMetric(docValues, metric);
        if (!expectedValuesIter.hasNext()) {
                values.add(null);   // The tests need null, even though the agg doesn't
import static org.hamcrest.Matchers.closeTo;  
        createIndex("idx_unmapped");
        }
 * compatible open source license.
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
import java.util.ArrayList;
            }
    }
                values.add(diff);  
            client().prepareSearch("idx")  
    private static final String INTERVAL_FIELD = "l_value";
 *  
            fail("`expectedBucketIter` iterator ended before `actual` iterator, size mismatch");  
    static BucketHelpers.GapPolicy gapPolicy;
 * under the License.  
    private ValuesSourceAggregationBuilder<? extends ValuesSourceAggregationBuilder<?>> randomMetric(String name, String field) {
/*  
        } else {  
 * software distributed under the License is distributed on an
            // Both have values, calculate diff and replace the "empty" bucket  
                countDiff.value(),
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(  
@OpenSearchIntegTestCase.SuiteScopeTestCase  
import static org.opensearch.search.aggregations.AggregationBuilders.min;  
        mockHisto = PipelineAggregationHelperTests.generateHistogram(interval, numBuckets, randomDouble(), randomDouble());
package org.opensearch.search.aggregations.pipeline;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
    public void testBasicDiff() {  
        super(staticSettings);
        Iterator<? extends Histogram.Bucket> actualIter = buckets.iterator();
                // If there was a gap in doc counts and we are ignoring, just skip this bucket
    static List<PipelineAggregationHelperTests.MockBucket> mockHisto;
        Iterator<PipelineAggregationHelperTests.MockBucket> expectedBucketIter = mockHisto.iterator();  
            setupExpected(target);
        int counter = 0;  
            .addAggregation(
        createIndex("idx");
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        } else {
            for (double value : mockBucket.docValues) {
    static ValuesSourceAggregationBuilder<? extends ValuesSourceAggregationBuilder<?>> metric;  
        } catch (IllegalArgumentException e) {  
                    ? PipelineAggregationHelperTests.calculateMetric(docValues, metric)
                histogram("histo").field(INTERVAL_FIELD)  
    static int interval;
    }
                    metricValue = 0.0;  
    }  
 * not use this file except in compliance with the License.
 */  
        assertThat(histo.getName(), equalTo("histo"));
        while (actualIter.hasNext()) {
            // Normalize null's to NaN
    private static final String VALUE_FIELD = "v_value";  
 *
