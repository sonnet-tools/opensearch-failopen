        assertSearchResponse(response);
 * Licensed to Elasticsearch under one or more contributor
    }
        // Since all max values are equal, we expect the order of keyBucketSort to have been preserved
        assertThat(histo.getName(), equalTo("time_buckets"));
    }
        assertSearchResponse(response);
 * GitHub history for details.
    }
 * license agreements. See the NOTICE file distributed with
            assertThat(previousKey, lessThanOrEqualTo((String) termBucket.getKey()));
            .setSource("time", "type=date", "foo", "type=keyword", "value_1", "type=float", "value_2", "type=float")
        assertThat(histo, notNullValue());
        assertThat(terms, notNullValue());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .interval(TimeValue.timeValueHours(1).millis())
 * KIND, either express or implied.  See the License for the
            .addAggregation(
 * ownership. Elasticsearch licenses this file to you under
        jsonBuilder.startObject();
            assertThat(previousKey, lessThanOrEqualTo((String) termBucket.getKey()));
import java.util.ArrayList;
            new Object[] {
        jsonBuilder.endObject();
            assertThat(previousKey, lessThanOrEqualTo((ZonedDateTime) timeBucket.getKey()));
 *
        assertSearchResponse(response);
                                new FieldSortBuilder("avg_value_1").order(SortOrder.ASC)
        assertThat(terms, notNullValue());
        Terms terms = response.getAggregations().get("foos");
        for (int i = 0; i < size3From2TimeBuckets.size(); ++i) {
                .addAggregation(terms("foos").field(TERM_FIELD).subAggregation(bucketSort("bucketSort", Collections.emptyList())))
        builders.add(client().prepareIndex(INDEX_WITH_GAPS).setSource(newDocBuilder(3, "foo", 3.0, 42.0)));
                    .interval(1)
        assertThat(e.getMessage(), containsString("No aggregation found for path [invalid]"));
                        ).size(2)
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
    }
import java.time.ZonedDateTime;
        // These become our baseline
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(timeBuckets.size(), equalTo(3));
                    terms("foos").field(TERM_FIELD).subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("invalid"))))
            containsString("[bucketSort] is configured to perform nothing." + " Please set either of [sort, size, from] to use bucket_sort")
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch(INDEX)
        assertThat(histo, notNullValue());
    }
    private static final String VALUE_1_FIELD = "value_1";
        assertEquals(3, termsBuckets.size());
            ActionRequestValidationException.class,
        Histogram histo = response.getAggregations().get("time_buckets");
                            "bucketSort",
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
 */
        assertThat(histo.getName(), equalTo("time_buckets"));
        SearchResponse response = client().prepareSearch(INDEX)
        assertThat(histo, notNullValue());
                        bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("avg_value").order(SortOrder.DESC))).size(2).from(3)
/*
        assertThat(timeBuckets.get(0).getKey(), equalTo(3.0));
        SearchResponse response = client().prepareSearch(INDEX)
        Exception e = expectThrows(
            ActionRequestValidationException.class,
    }
            jsonBuilder.field(VALUE_1_FIELD, value1);
        for (Terms.Bucket termBucket : termsBuckets) {
    }
                            )
        assertThat(histo, notNullValue());
    public void testEmptyBuckets() {
        Histogram size3From2Histogram = response.getAggregations().get("time_buckets");
                for (int i = 0; i < termCount; ++i) {
                terms("foos").field(TERM_FIELD).subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("_key"))))
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(size3TimeBuckets.get(i).getKey(), equalTo(timeBuckets.get(i).getKey()));
import org.opensearch.action.index.IndexRequestBuilder;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                terms("foos").field(TERM_FIELD)
import org.opensearch.action.ActionRequestValidationException;
                assertThat(previousAvgValue, greaterThanOrEqualTo(avg.getValue()));
            previousKey = (String) termBucket.getKey();
            assertThat(previousAvgValue, greaterThanOrEqualTo(avg.getValue()));
    }
                    .subAggregation(bucketSort("bucketSort", Collections.emptyList()).size(3))
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
                    .subAggregation(avg("avg_value_2").field(VALUE_2_FIELD))
        Histogram histo = response.getAggregations().get("time_buckets");
        double previousAvgValue = ((Avg) termsBuckets.get(0).getAggregations().get("avg_value")).getValue();
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            for (String term : terms) {
    public void testSortHistogram_GivenGapsAndGapPolicyIsSkip() {
    }
                    .subAggregation(avg("avg_value_1").field(VALUE_1_FIELD))
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        return Arrays.asList(
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
            assertThat(size3From2TimeBuckets.get(i).getKey(), equalTo(timeBuckets.get(i + 2).getKey()));
                    .interval(TimeValue.timeValueHours(1).millis())
    public BucketSortIT(Settings staticSettings) {
        assertSearchResponse(response);
        Histogram histo = response.getAggregations().get("time_buckets");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
    public void testSortDateHistogramDescending() {
        Terms terms = response.getAggregations().get("foos");
        assertThat(histo.getName(), equalTo("time_buckets"));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
            .setSize(0)
 * specific language governing permissions and limitations
        String previousKey = (String) termsBuckets.get(0).getKey();
        }
import java.util.Arrays;
                                new FieldSortBuilder("avg_value_1").order(SortOrder.DESC),
            assertThat(previousCount, lessThanOrEqualTo(termBucket.getDocCount()));
                histogram("time_buckets").field(TIME_FIELD)
        SearchResponse response = client().prepareSearch(INDEX_WITH_GAPS)
                    .subAggregation(bucketSort("bucketSort", Collections.emptyList()).size(3).from(2))
                            "bucketSort",
import org.opensearch.index.query.QueryBuilders;
            .addAggregation(
        assertThat(timeBuckets.get(2).getKey(), equalTo(2.0));
        builders.add(client().prepareIndex(INDEX_WITH_GAPS).setSource(newDocBuilder(1, "foo", 1.0, 42.0)));
        Terms terms = response.getAggregations().get("foos");
            .addAggregation(dateHistogram("time_buckets").field(TIME_FIELD).interval(TimeValue.timeValueHours(1).millis()))
            )
        List<IndexRequestBuilder> builders = new ArrayList<>();
    public void testEmptyBucketSort() {
            .get();
    }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        Histogram histo = response.getAggregations().get("time_buckets");
            )
            if (previousCount == termBucket.getDocCount()) {
    public void testSortTermsOnKeyWithSize() {
            .setSize(0)
                    )
            )
        );
        }
import java.util.List;
 *
import org.opensearch.search.sort.FieldSortBuilder;
            time += TimeValue.timeValueHours(1).millis();
 * this file be licensed under the Apache-2.0 license or a
                        bucketSort(
import org.opensearch.search.sort.SortOrder;
        List<? extends Histogram.Bucket> timeBuckets = histo.getBuckets();
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
 * Unless required by applicable law or agreed to in writing,
        assertSearchResponse(response);
                histogram("time_buckets").field(TIME_FIELD)
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
    }
        for (Histogram.Bucket timeBucket : timeBuckets) {
                    .interval(1)
                terms("foos").field(TERM_FIELD)
        }
        List<? extends Histogram.Bucket> descendingTimeBuckets = histo.getBuckets();
            .get();
 * The OpenSearch Contributors require contributions made to
        long previousCount = termsBuckets.get(0).getDocCount();
            .setSize(0)
        assertThat(timeBuckets.size(), equalTo(3));
            previousCount = termBucket.getDocCount();
        assertThat(timeBuckets.size(), equalTo(2));
        }
                    )
        response = client().prepareSearch(INDEX)
    public void testSortTermsOnSubAggregationPreservesOrderOnEquals() {
            .setSize(0)
/*
                    .subAggregation(bucketSort("keyBucketSort", Arrays.asList(new FieldSortBuilder("_key"))))
 */
        List<? extends Histogram.Bucket> size3TimeBuckets = size3Histogram.getBuckets();
        Histogram histo = response.getAggregations().get("time_buckets");
        int numTerms = 10;
        List<? extends Histogram.Bucket> ascendingTimeBuckets = histo.getBuckets();
        }
            )
    }
        builders.add(client().prepareIndex(INDEX_WITH_GAPS).setSource(newDocBuilder(2, "foo", null, 42.0)));
        createIndex(INDEX, INDEX_WITH_GAPS);
        assertSearchResponse(response);
        assertThat(timeBuckets.get(2).getKey(), equalTo(2.0));
        // Finally, let's test using size + from
        assertThat(histogram, notNullValue());
            previousAvgValue = avg.getValue();
            Avg avg = termBucket.getAggregations().get("avg_value");
                terms("foos").field(TERM_FIELD)
            .addAggregation(
                                new FieldSortBuilder("avg_value_2").order(SortOrder.DESC),
            jsonBuilder.field(VALUE_2_FIELD, value2);
        jsonBuilder.field(TIME_FIELD, timeMillis);
        for (Terms.Bucket termBucket : termsBuckets) {
        SearchResponse response = client().prepareSearch(INDEX_WITH_GAPS)
        assertSearchResponse(response);
            assertThat(previousKey, lessThanOrEqualTo((String) termBucket.getKey()));
            )
        int bucketCount = ascendingTimeBuckets.size();
        assertThat(timeBuckets.get(1).getKey(), equalTo(1.0));
import org.opensearch.action.search.SearchResponse;
            .addAggregation(
 * You may obtain a copy of the License at
public class BucketSortIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        Exception e = expectThrows(
        if (value1 != null) {
        for (int i = 0; i < numTerms; ++i) {
            .get();
                    .subAggregation(
        assertSearchResponse(response);
        assertSearchResponse(response);
            .addAggregation(
                            Arrays.asList(
        assertThat(terms, notNullValue());
                            Arrays.asList(
        );
            .get();
            .setSize(0)
        Terms terms = response.getAggregations().get("foos");
 * software distributed under the License is distributed on an
        client().admin()
        assertThat(terms, notNullValue());
        for (Terms.Bucket termBucket : termsBuckets) {
            previousKey = (String) termBucket.getKey();
        SearchResponse response = client().prepareSearch(INDEX)
        for (Terms.Bucket termBucket : termsBuckets) {
        List<? extends Histogram.Bucket> timeBuckets = histo.getBuckets();
                    .subAggregation(
        assertThat(timeBuckets.get(0).getKey(), equalTo(1.0));
import java.util.Collection;
            .indices()
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
                    .subAggregation(bucketSort("maxBucketSort", Arrays.asList(new FieldSortBuilder("max"))))
                            BucketHelpers.GapPolicy.SKIP
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
                    )
}
        assertThat(timeBuckets.get(1).getKey(), equalTo(1.0));
        ensureSearchable();
                histogram("time_buckets").field(TIME_FIELD)
        assertThat(terms, notNullValue());
    public void testSortHistogram_GivenGapsAndGapPolicyIsSkipAndPrimarySortHasGaps() {
            new Object[] {
                        bucketSort(
            new Object[] {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
        assertThat(timeBuckets.get(1).getKey(), equalTo(1.0));
            .addAggregation(dateHistogram("time_buckets").field(TIME_FIELD).interval(TimeValue.timeValueHours(1).millis()))
        histo = response.getAggregations().get("time_buckets");
    }
        jsonBuilder.field(TERM_FIELD, fooValue);
        while (time < now) {
    }
        }
                }
        assertThat(histo.getName(), equalTo("time_buckets"));
                        )
            .get();
    public void testSortTermsOnKey() {
            .setSize(0)
    public void testSortTermsOnCountWithSecondarySort() {
            previousAvgValue = avg.getValue();
        assertThat(timeBuckets.get(0).getKey(), equalTo(3.0));
    public static Collection<Object[]> parameters() {
            Avg avg = termBucket.getAggregations().get("avg_value");
                    .subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("avg_value").order(SortOrder.DESC))))
    public void testSortHistogram_GivenGapsAndGapPolicyIsSkipAndSecondarySortHasGaps() {
        assertSearchResponse(response);
            .get();
        }
        String previousKey = (String) termsBuckets.get(0).getKey();
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                    )
        assertSearchResponse(response);
        Histogram histo = response.getAggregations().get("time_buckets");
    public void testSortTermsOnSubAggregation() {
            .get();
            )
                        bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("avg_value").order(SortOrder.DESC))).gapPolicy(
import static org.hamcrest.Matchers.containsString;
        List<? extends Terms.Bucket> size2From3TermsBuckets = size2From3Terms.getBuckets();
 * under the License.
            assertThat(avg, notNullValue());
            .setQuery(QueryBuilders.existsQuery("non-field"))
                        bucketSort(
        assertThat(timeBuckets.get(0).getKey(), equalTo(3.0));
    private XContentBuilder newDocBuilder(long timeMillis, String fooValue, Double value1) throws IOException {
        for (int i = 0; i < size2From3TermsBuckets.size(); ++i) {
        Histogram histogram = response.getAggregations().get("time_buckets");
                    .subAggregation(
            )
        assertThat(
            .get();
    }
            )
                dateHistogram("time_buckets").field(TIME_FIELD)
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.bucketSort;
 */
import org.opensearch.common.unit.TimeValue;
                    .subAggregation(
            () -> client().prepareSearch(INDEX)
    @Override
        }
        for (Terms.Bucket termBucket : termsBuckets) {
        return jsonBuilder;
                            BucketHelpers.GapPolicy.INSERT_ZEROS
                    .subAggregation(
            )
        assertThat(histo, notNullValue());
            .addAggregation(
        SearchResponse response = client().prepareSearch(INDEX_WITH_GAPS)
            .get();
 * compatible open source license.
                    .subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("_key"))).size(3))
        assertThat(histo.getName(), equalTo("time_buckets"));
        }
                            Arrays.asList(
        assertThat(timeBuckets.get(0).getKey(), equalTo(3.0));
            .addAggregation(
 *
                histogram("time_buckets").field(TIME_FIELD)
            .addAggregation(
            .setSize(0)
        }
            assertThat(ascendingTimeBuckets.get(i).getKey(), equalTo(descendingTimeBuckets.get(bucketCount - i - 1).getKey()));
        if (value2 != null) {
        );
            )
        response = client().prepareSearch(INDEX)
            previousKey = (ZonedDateTime) timeBucket.getKey();
                            )
import org.opensearch.search.aggregations.bucket.terms.Terms;
            )
                    )
            .get();
                            "bucketSort",
        assertThat(size3From2Histogram, notNullValue());
        SearchResponse response = client().prepareSearch(INDEX)
            terms.add(randomAlphaOfLengthBetween(3, 8));
                        ).gapPolicy(BucketHelpers.GapPolicy.SKIP)
    private static final String TIME_FIELD = "time";
        SearchResponse response = client().prepareSearch(INDEX)
                    builders.add(
        assertThat(histo.getName(), equalTo("time_buckets"));
import org.opensearch.search.aggregations.metrics.Avg;
        }
            .get();
        assertThat(timeBuckets.size(), equalTo(3));
            .addAggregation(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
package org.opensearch.search.aggregations.pipeline;
    private static final String INDEX_WITH_GAPS = "bucket-sort-it-data-index-with-gaps";
        assertThat(timeBuckets.get(1).getKey(), equalTo(3.0));
        super(staticSettings);
                                new FieldSortBuilder("_count").order(SortOrder.ASC),
            .setSize(0)
                        client().prepareIndex(INDEX).setSource(newDocBuilder(time, term, randomIntBetween(1, 10) * randomDouble()))
        assertThat(histo, notNullValue());
                        )
        }
 * this work for additional information regarding copyright
            () -> client().prepareSearch(INDEX)
    private static final String TERM_FIELD = "foo";
                    .subAggregation(avg("avg_value_2").field(VALUE_2_FIELD))
        assertSearchResponse(response);
        assertSearchResponse(response);
                        bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("avg_value").order(SortOrder.DESC))).gapPolicy(
        long now = System.currentTimeMillis();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            .get();
import org.opensearch.common.settings.Settings;
    }
                    .subAggregation(max("max").field("missingValue").missing(1))
import static org.hamcrest.Matchers.is;
                histogram("time_buckets").field(TIME_FIELD)
            .get();
import org.opensearch.test.OpenSearchIntegTestCase;
    private XContentBuilder newDocBuilder(long timeMillis, String fooValue, Double value1, Double value2) throws IOException {
                .get()
            .setSize(0)
                    .interval(1)
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @ParametersFactory
    private static final String VALUE_2_FIELD = "value_2";
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
    public void setupSuiteScopeCluster() throws Exception {
        XContentBuilder jsonBuilder = jsonBuilder();
            e.getMessage(),
                terms("foos").field(TERM_FIELD).subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("_key"))))
                )
        Histogram size3Histogram = response.getAggregations().get("time_buckets");
            )
        assertThat(histo, notNullValue());
                    .subAggregation(avg("avg_value_1").field(VALUE_1_FIELD))
    public void testSortHistogram_GivenGapsAndGapPolicyIsInsertZeros() {
        for (int i = 0; i < bucketCount; ++i) {
import static org.hamcrest.Matchers.notNullValue;
                            )
        }
            )
                    .interval(TimeValue.timeValueHours(1).millis())
        ZonedDateTime previousKey = (ZonedDateTime) timeBuckets.get(0).getKey();
                                new FieldSortBuilder("avg_value").order(SortOrder.DESC)
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
                        bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("avg_value").order(SortOrder.DESC))).gapPolicy(
    private static final String INDEX = "bucket-sort-it-data-index";
            .get();
                    .subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("_key").order(SortOrder.DESC))))
            .get();
            )
            .addAggregation(
import java.io.IOException;
            assertThat(avg, notNullValue());
        for (int i = 0; i < size3TimeBuckets.size(); ++i) {
        assertThat(timeBuckets.get(2).getKey(), equalTo(2.0));
        }
                dateHistogram("time_buckets").field(TIME_FIELD)
                                new FieldSortBuilder("avg_value_2").order(SortOrder.DESC)
    }
import static org.hamcrest.Matchers.equalTo;
            )
                    );
                    .interval(1)
        List<? extends Histogram.Bucket> timeBuckets = histogram.getBuckets();
        assertThat(terms, notNullValue());
                    )
                terms("foos").field(TERM_FIELD)
        List<? extends Histogram.Bucket> timeBuckets = histo.getBuckets();
 * SPDX-License-Identifier: Apache-2.0
        assertThat(timeBuckets.size(), equalTo(2));
            }
                        )
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
@OpenSearchIntegTestCase.SuiteScopeTestCase
            }
        assertSearchResponse(response);
        List<? extends Histogram.Bucket> timeBuckets = histo.getBuckets();
        SearchResponse response = client().prepareSearch(INDEX)
                terms("foos").field(TERM_FIELD)
        double previousAvgValue = ((Avg) termsBuckets.get(0).getAggregations().get("avg_value")).getValue();
import static org.opensearch.search.aggregations.AggregationBuilders.max;
    public void testSortHistogram_GivenGapsAndGapPolicyIsSkipAndSizeIsLessThanAvailableBuckets() {
        Terms terms = response.getAggregations().get("foos");
                dateHistogram("time_buckets").field(TIME_FIELD)
        response = client().prepareSearch(INDEX)
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
                    .interval(1)
    }
import org.opensearch.core.xcontent.XContentBuilder;
            .addAggregation(
                .addAggregation(
        // Now let's test using size
    public void testInvalidPath() {
    public void testNeitherSortsNorSizeSpecifiedAndFromIsDefault_ShouldThrowValidation() {
        assertThat(histo.getName(), equalTo("time_buckets"));
        return newDocBuilder(timeMillis, fooValue, value1, null);
                int termCount = randomIntBetween(3, 6);
            .get();
        SearchResponse response = client().prepareSearch(INDEX)
        indexRandom(true, builders);
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
        assertThat(ascendingTimeBuckets.size(), equalTo(descendingTimeBuckets.size()));
            previousKey = (String) termBucket.getKey();
                .get()
                    .subAggregation(
        SearchResponse response = client().prepareSearch(INDEX_WITH_GAPS)
            .addAggregation(
            .get();
        List<String> terms = new ArrayList<>(numTerms);
        response = client().prepareSearch(INDEX)
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        long time = now - TimeValue.timeValueHours(24).millis();
/*
        Terms terms = response.getAggregations().get("foos");
                            BucketHelpers.GapPolicy.SKIP
            .addAggregation(
                    )
                        ).gapPolicy(BucketHelpers.GapPolicy.SKIP)
        assertThat(size3Histogram, notNullValue());
                    .subAggregation(
        assertThat(size2From3Terms, notNullValue());
    }
        assertThat(timeBuckets.get(1).getKey(), equalTo(1.0));
import java.util.Collections;
        assertThat(termsBuckets.isEmpty(), is(true));
 * not use this file except in compliance with the License.
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
    }
        assertSearchResponse(response);
            .setSize(0)
        String previousKey = (String) termsBuckets.get(0).getKey();
            .get();
        List<? extends Histogram.Bucket> timeBuckets = histo.getBuckets();
        Terms size2From3Terms = response.getAggregations().get("foos");
            .addAggregation(
        SearchResponse response = client().prepareSearch(INDEX_WITH_GAPS)
            .preparePutMapping(INDEX)
            .addAggregation(
        );
        List<? extends Histogram.Bucket> size3From2TimeBuckets = size3From2Histogram.getBuckets();
        assertSearchResponse(response);
            assertThat(size2From3TermsBuckets.get(i).getKey(), equalTo(termsBuckets.get(i + 3).getKey()));
