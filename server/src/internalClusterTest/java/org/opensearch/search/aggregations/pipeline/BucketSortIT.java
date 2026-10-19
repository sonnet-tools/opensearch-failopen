import static org.hamcrest.Matchers.lessThanOrEqualTo;  
    public void testSortTermsOnSubAggregationPreservesOrderOnEquals() {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
                    .subAggregation(avg("avg_value_2").field(VALUE_2_FIELD))
        createIndex(INDEX, INDEX_WITH_GAPS);
 * ownership. Elasticsearch licenses this file to you under  
            .addAggregation(  
            )  
                    .interval(TimeValue.timeValueHours(1).millis())
        SearchResponse response = client().prepareSearch(INDEX_WITH_GAPS)
            .get();
                            )
        Histogram size3Histogram = response.getAggregations().get("time_buckets");  
            .setQuery(QueryBuilders.existsQuery("non-field"))
    }
        assertThat(histo.getName(), equalTo("time_buckets"));  
        List<? extends Histogram.Bucket> timeBuckets = histo.getBuckets();  
                    )
            previousKey = (String) termBucket.getKey();
    private static final String TERM_FIELD = "foo";
        assertThat(histo.getName(), equalTo("time_buckets"));
 * not use this file except in compliance with the License.
        assertThat(timeBuckets.get(2).getKey(), equalTo(2.0));
                            )
import java.util.List;  
            jsonBuilder.field(VALUE_1_FIELD, value1);  
        Histogram histo = response.getAggregations().get("time_buckets");
 * this work for additional information regarding copyright
                    .subAggregation(
                terms("foos").field(TERM_FIELD)  
        }
                    .subAggregation(avg("avg_value_1").field(VALUE_1_FIELD))  
    public BucketSortIT(Settings staticSettings) {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;  
        assertSearchResponse(response);
            for (String term : terms) {
        assertThat(timeBuckets.get(2).getKey(), equalTo(2.0));
                        bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("avg_value").order(SortOrder.DESC))).gapPolicy(  
            .addAggregation(
        assertSearchResponse(response);
                terms("foos").field(TERM_FIELD)
        SearchResponse response = client().prepareSearch(INDEX_WITH_GAPS)  
/*
            .setSize(0)
        }
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.bucketSort;  
        assertSearchResponse(response);
        // Since all max values are equal, we expect the order of keyBucketSort to have been preserved  
    }
                    .subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("_key").order(SortOrder.DESC))))
    public void testEmptyBucketSort() {  
                    .subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("_key"))).size(3))  
            assertThat(size3TimeBuckets.get(i).getKey(), equalTo(timeBuckets.get(i).getKey()));
        Terms terms = response.getAggregations().get("foos");
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                        bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("avg_value").order(SortOrder.DESC))).gapPolicy(
        assertSearchResponse(response);
            )
import org.opensearch.common.settings.Settings;  
public class BucketSortIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                int termCount = randomIntBetween(3, 6);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        for (int i = 0; i < bucketCount; ++i) {
                        client().prepareIndex(INDEX).setSource(newDocBuilder(time, term, randomIntBetween(1, 10) * randomDouble()))
            .get();
        }
        }
        assertThat(timeBuckets.get(1).getKey(), equalTo(3.0));
            .addAggregation(  
        List<? extends Terms.Bucket> size2From3TermsBuckets = size2From3Terms.getBuckets();
        assertThat(size2From3Terms, notNullValue());  
        for (int i = 0; i < numTerms; ++i) {
            .get();
        assertThat(e.getMessage(), containsString("No aggregation found for path [invalid]"));  
            .setSize(0)
            new Object[] {
        assertThat(timeBuckets.get(0).getKey(), equalTo(1.0));  
        );  
            new Object[] {  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    public void setupSuiteScopeCluster() throws Exception {
    @ParametersFactory  
        response = client().prepareSearch(INDEX)
            jsonBuilder.field(VALUE_2_FIELD, value2);  
        assertThat(histo, notNullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<? extends Histogram.Bucket> ascendingTimeBuckets = histo.getBuckets();
    private static final String TIME_FIELD = "time";  
        response = client().prepareSearch(INDEX)
        assertSearchResponse(response);
        Histogram histo = response.getAggregations().get("time_buckets");  
            e.getMessage(),
                    );  
        assertThat(histogram, notNullValue());  
    public void testSortDateHistogramDescending() {  
        XContentBuilder jsonBuilder = jsonBuilder();
            }
            .get();  
        List<? extends Histogram.Bucket> timeBuckets = histo.getBuckets();
                                new FieldSortBuilder("avg_value_2").order(SortOrder.DESC),  
                dateHistogram("time_buckets").field(TIME_FIELD)  
        assertThat(timeBuckets.get(2).getKey(), equalTo(2.0));
        List<IndexRequestBuilder> builders = new ArrayList<>();
        List<? extends Histogram.Bucket> timeBuckets = histo.getBuckets();
            assertThat(previousKey, lessThanOrEqualTo((String) termBucket.getKey()));  
            .setSize(0)
        Terms terms = response.getAggregations().get("foos");
        Histogram histo = response.getAggregations().get("time_buckets");  
                                new FieldSortBuilder("_count").order(SortOrder.ASC),  
                        ).gapPolicy(BucketHelpers.GapPolicy.SKIP)  
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
/*  
        if (value2 != null) {
                    )
                .addAggregation(terms("foos").field(TERM_FIELD).subAggregation(bucketSort("bucketSort", Collections.emptyList())))
                        bucketSort(
        jsonBuilder.endObject();
        assertThat(terms, notNullValue());
    private XContentBuilder newDocBuilder(long timeMillis, String fooValue, Double value1) throws IOException {
    }
        assertThat(histo, notNullValue());
                histogram("time_buckets").field(TIME_FIELD)  
        }
        for (Terms.Bucket termBucket : termsBuckets) {  
 * compatible open source license.
        assertThat(terms, notNullValue());
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },  
                            Arrays.asList(
            previousKey = (ZonedDateTime) timeBucket.getKey();  
        Histogram histogram = response.getAggregations().get("time_buckets");
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;  
                assertThat(previousAvgValue, greaterThanOrEqualTo(avg.getValue()));
                terms("foos").field(TERM_FIELD)
        assertThat(timeBuckets.size(), equalTo(2));
    }  
    }  
        List<String> terms = new ArrayList<>(numTerms);
                                new FieldSortBuilder("avg_value_2").order(SortOrder.DESC)  
                                new FieldSortBuilder("avg_value").order(SortOrder.DESC)
            assertThat(ascendingTimeBuckets.get(i).getKey(), equalTo(descendingTimeBuckets.get(bucketCount - i - 1).getKey()));  
                        )
        jsonBuilder.startObject();
                    .interval(1)
        builders.add(client().prepareIndex(INDEX_WITH_GAPS).setSource(newDocBuilder(1, "foo", 1.0, 42.0)));  
        List<? extends Histogram.Bucket> timeBuckets = histogram.getBuckets();
                            "bucketSort",  
import org.opensearch.action.ActionRequestValidationException;  
            .indices()
            .addAggregation(dateHistogram("time_buckets").field(TIME_FIELD).interval(TimeValue.timeValueHours(1).millis()))  
        }
                                new FieldSortBuilder("avg_value_1").order(SortOrder.ASC)
        long now = System.currentTimeMillis();  
            }  
        SearchResponse response = client().prepareSearch(INDEX)  
            ActionRequestValidationException.class,
        return Arrays.asList(
                    .interval(1)  
        SearchResponse response = client().prepareSearch(INDEX_WITH_GAPS)  
        String previousKey = (String) termsBuckets.get(0).getKey();  
        assertSearchResponse(response);  
    }
import org.opensearch.action.search.SearchResponse;
        assertSearchResponse(response);
            .get();
        assertThat(histo.getName(), equalTo("time_buckets"));  
                dateHistogram("time_buckets").field(TIME_FIELD)
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        }
        Histogram histo = response.getAggregations().get("time_buckets");  
        for (Terms.Bucket termBucket : termsBuckets) {
            )
            .setSize(0)  
import java.util.Collection;
                    .interval(1)  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
                    .subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("avg_value").order(SortOrder.DESC))))
                    .subAggregation(bucketSort("bucketSort", Collections.emptyList()).size(3))  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
 */  
        assertThat(terms, notNullValue());  
    }
    public void testSortHistogram_GivenGapsAndGapPolicyIsSkipAndSecondarySortHasGaps() {
                    .subAggregation(
        int numTerms = 10;  
        assertSearchResponse(response);
            )
                        )
                terms("foos").field(TERM_FIELD).subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("_key"))))  
            .get();  
            )
        return jsonBuilder;  
            .get();
    public void testSortHistogram_GivenGapsAndGapPolicyIsSkipAndSizeIsLessThanAvailableBuckets() {
            Avg avg = termBucket.getAggregations().get("avg_value");
        SearchResponse response = client().prepareSearch(INDEX)  
                        bucketSort(  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
import org.opensearch.core.xcontent.XContentBuilder;
        jsonBuilder.field(TERM_FIELD, fooValue);
                            BucketHelpers.GapPolicy.SKIP  
            () -> client().prepareSearch(INDEX)  
        assertThat(timeBuckets.get(1).getKey(), equalTo(1.0));  
                            )
                    .subAggregation(
        assertThat(histo, notNullValue());
        assertThat(
            .setSize(0)
        for (Terms.Bucket termBucket : termsBuckets) {  
            assertThat(previousKey, lessThanOrEqualTo((String) termBucket.getKey()));  
        double previousAvgValue = ((Avg) termsBuckets.get(0).getAggregations().get("avg_value")).getValue();
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
                        )  
        return newDocBuilder(timeMillis, fooValue, value1, null);  
            )
 * Licensed to Elasticsearch under one or more contributor  
        assertSearchResponse(response);
    public void testEmptyBuckets() {
            )
        SearchResponse response = client().prepareSearch(INDEX)
                        ).size(2)
            .addAggregation(  
        assertSearchResponse(response);  
        assertThat(termsBuckets.isEmpty(), is(true));  
        SearchResponse response = client().prepareSearch(INDEX_WITH_GAPS)
import org.opensearch.search.sort.SortOrder;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
    }
            previousAvgValue = avg.getValue();
    private XContentBuilder newDocBuilder(long timeMillis, String fooValue, Double value1, Double value2) throws IOException {  
                            "bucketSort",
            .addAggregation(
                    )  
            new Object[] {
                histogram("time_buckets").field(TIME_FIELD)
        assertThat(timeBuckets.get(0).getKey(), equalTo(3.0));
        assertThat(histo.getName(), equalTo("time_buckets"));  
        assertThat(timeBuckets.size(), equalTo(3));
        assertSearchResponse(response);
            .addAggregation(
 * under the License.  
        SearchResponse response = client().prepareSearch(INDEX_WITH_GAPS)
    public void testInvalidPath() {  
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
            .get();  
        SearchResponse response = client().prepareSearch(INDEX)
            .setSize(0)
        assertThat(timeBuckets.get(0).getKey(), equalTo(3.0));
            .preparePutMapping(INDEX)
            .addAggregation(
        );
            .addAggregation(dateHistogram("time_buckets").field(TIME_FIELD).interval(TimeValue.timeValueHours(1).millis()))
    private static final String INDEX = "bucket-sort-it-data-index";  
        assertThat(size3Histogram, notNullValue());
package org.opensearch.search.aggregations.pipeline;
        assertEquals(3, termsBuckets.size());  
            .setSize(0)  
        Terms terms = response.getAggregations().get("foos");
 */
            )
 * software distributed under the License is distributed on an
                            Arrays.asList(
 * this file be licensed under the Apache-2.0 license or a
    public void testSortHistogram_GivenGapsAndGapPolicyIsSkip() {
        if (value1 != null) {
        client().admin()  
        // Finally, let's test using size + from
            assertThat(size3From2TimeBuckets.get(i).getKey(), equalTo(timeBuckets.get(i + 2).getKey()));
import org.opensearch.search.sort.FieldSortBuilder;
            assertThat(previousAvgValue, greaterThanOrEqualTo(avg.getValue()));  
 * GitHub history for details.
        assertSearchResponse(response);
    }
        assertSearchResponse(response);
            .get();
        histo = response.getAggregations().get("time_buckets");
    private static final String INDEX_WITH_GAPS = "bucket-sort-it-data-index-with-gaps";
                        ).gapPolicy(BucketHelpers.GapPolicy.SKIP)
    }  
            .get();
            .addAggregation(
        for (Terms.Bucket termBucket : termsBuckets) {
                    .subAggregation(
            .get();
    public void testNeitherSortsNorSizeSpecifiedAndFromIsDefault_ShouldThrowValidation() {  
            .get();
            previousAvgValue = avg.getValue();
            previousKey = (String) termBucket.getKey();
        assertThat(ascendingTimeBuckets.size(), equalTo(descendingTimeBuckets.size()));  
        );  
        List<? extends Histogram.Bucket> descendingTimeBuckets = histo.getBuckets();
 * Unless required by applicable law or agreed to in writing,
import java.util.Arrays;  
        // These become our baseline
            .addAggregation(
        assertThat(timeBuckets.get(1).getKey(), equalTo(1.0));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import java.io.IOException;  
 * You may obtain a copy of the License at  
                dateHistogram("time_buckets").field(TIME_FIELD)
                        bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("avg_value").order(SortOrder.DESC))).size(2).from(3)
        Terms terms = response.getAggregations().get("foos");  
        assertThat(terms, notNullValue());  
        assertThat(size3From2Histogram, notNullValue());  
import static org.hamcrest.Matchers.is;
    public void testSortTermsOnKeyWithSize() {
        assertThat(timeBuckets.get(0).getKey(), equalTo(3.0));
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
}  
import java.util.Collections;
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
            .get();
        List<? extends Histogram.Bucket> timeBuckets = histo.getBuckets();  
 * specific language governing permissions and limitations
    }  
                                new FieldSortBuilder("avg_value_1").order(SortOrder.DESC),
                            Arrays.asList(
 * the Apache License, Version 2.0 (the "License"); you may
    public void testSortHistogram_GivenGapsAndGapPolicyIsSkipAndPrimarySortHasGaps() {  
            assertThat(size2From3TermsBuckets.get(i).getKey(), equalTo(termsBuckets.get(i + 3).getKey()));  
            )
        assertThat(terms, notNullValue());
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
 * SPDX-License-Identifier: Apache-2.0
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
    public void testSortTermsOnCountWithSecondarySort() {
                histogram("time_buckets").field(TIME_FIELD)
        );
        jsonBuilder.field(TIME_FIELD, timeMillis);  
import java.time.ZonedDateTime;
import org.opensearch.index.query.QueryBuilders;  
                    .interval(1)
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
                        bucketSort(  
        response = client().prepareSearch(INDEX)  
        Exception e = expectThrows(
        assertThat(timeBuckets.get(0).getKey(), equalTo(3.0));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    )  
            Avg avg = termBucket.getAggregations().get("avg_value");
                .get()
        }  
        Histogram histo = response.getAggregations().get("time_buckets");
        Histogram histo = response.getAggregations().get("time_buckets");
        }
            .get();
            previousCount = termBucket.getDocCount();
        while (time < now) {  
            )  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;  
            time += TimeValue.timeValueHours(1).millis();  
        response = client().prepareSearch(INDEX)  
                terms("foos").field(TERM_FIELD).subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("_key"))))  
            assertThat(previousKey, lessThanOrEqualTo((ZonedDateTime) timeBucket.getKey()));
        assertSearchResponse(response);  
                        bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("avg_value").order(SortOrder.DESC))).gapPolicy(  
            () -> client().prepareSearch(INDEX)  
                    .interval(TimeValue.timeValueHours(1).millis())  
            .get();  
        assertThat(timeBuckets.size(), equalTo(3));
    }
            )
            assertThat(previousCount, lessThanOrEqualTo(termBucket.getDocCount()));  
        SearchResponse response = client().prepareSearch(INDEX)  
import java.util.ArrayList;
        List<? extends Histogram.Bucket> size3From2TimeBuckets = size3From2Histogram.getBuckets();
                    .subAggregation(avg("avg_value_2").field(VALUE_2_FIELD))  
            )  
    }
        // Now let's test using size  
        ZonedDateTime previousKey = (ZonedDateTime) timeBuckets.get(0).getKey();  
        assertThat(timeBuckets.get(1).getKey(), equalTo(1.0));  
    }
                .get()
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
    public void testSortTermsOnKey() {
        }
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))  
                .addAggregation(
                    .subAggregation(avg("avg_value_1").field(VALUE_1_FIELD))
                            BucketHelpers.GapPolicy.SKIP
            .get();
            assertThat(avg, notNullValue());
import org.opensearch.action.index.IndexRequestBuilder;
import org.opensearch.search.aggregations.bucket.terms.Terms;
    }
        for (Histogram.Bucket timeBucket : timeBuckets) {
        assertThat(histo.getName(), equalTo("time_buckets"));
            .addAggregation(
        SearchResponse response = client().prepareSearch(INDEX)
        for (Terms.Bucket termBucket : termsBuckets) {
                    .subAggregation(
 * license agreements. See the NOTICE file distributed with
        }
        indexRandom(true, builders);
        SearchResponse response = client().prepareSearch(INDEX)
    }
import static org.opensearch.search.aggregations.AggregationBuilders.max;
 *  
                for (int i = 0; i < termCount; ++i) {  
 */  
                    terms("foos").field(TERM_FIELD).subAggregation(bucketSort("bucketSort", Arrays.asList(new FieldSortBuilder("invalid"))))
            .addAggregation(  
                    .interval(1)
        builders.add(client().prepareIndex(INDEX_WITH_GAPS).setSource(newDocBuilder(3, "foo", 3.0, 42.0)));
        assertSearchResponse(response);  
            if (previousCount == termBucket.getDocCount()) {
            .get();
        double previousAvgValue = ((Avg) termsBuckets.get(0).getAggregations().get("avg_value")).getValue();
            .get();
        SearchResponse response = client().prepareSearch(INDEX)
        assertThat(timeBuckets.size(), equalTo(3));
                terms("foos").field(TERM_FIELD)
                    builders.add(
        assertThat(histo, notNullValue());
        ensureSearchable();
        String previousKey = (String) termsBuckets.get(0).getKey();
            .setSource("time", "type=date", "foo", "type=keyword", "value_1", "type=float", "value_2", "type=float")  
        assertThat(histo, notNullValue());  
        long time = now - TimeValue.timeValueHours(24).millis();
    }
                histogram("time_buckets").field(TIME_FIELD)
        for (int i = 0; i < size3From2TimeBuckets.size(); ++i) {  
        List<? extends Histogram.Bucket> timeBuckets = histo.getBuckets();  
        }
        assertThat(histo, notNullValue());
            )  
            terms.add(randomAlphaOfLengthBetween(3, 8));  
            .setSize(0)
import org.opensearch.common.unit.TimeValue;
        for (int i = 0; i < size3TimeBuckets.size(); ++i) {
        }  
 * KIND, either express or implied.  See the License for the
            previousKey = (String) termBucket.getKey();  
                    .subAggregation(avg("avg_value").field(VALUE_1_FIELD))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
    public void testSortTermsOnSubAggregation() {
    private static final String VALUE_1_FIELD = "value_1";
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;  
        Exception e = expectThrows(
                    .subAggregation(bucketSort("keyBucketSort", Arrays.asList(new FieldSortBuilder("_key"))))  
    public static Collection<Object[]> parameters() {
        builders.add(client().prepareIndex(INDEX_WITH_GAPS).setSource(newDocBuilder(2, "foo", null, 42.0)));
 * Modifications Copyright OpenSearch Contributors. See
    private static final String VALUE_2_FIELD = "value_2";  
        String previousKey = (String) termsBuckets.get(0).getKey();
    }  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
                    .interval(TimeValue.timeValueHours(1).millis())
        Terms terms = response.getAggregations().get("foos");  
            assertThat(previousKey, lessThanOrEqualTo((String) termBucket.getKey()));
                    )
        assertThat(histo.getName(), equalTo("time_buckets"));
        assertSearchResponse(response);  
            ActionRequestValidationException.class,
 *
                    .subAggregation(bucketSort("maxBucketSort", Arrays.asList(new FieldSortBuilder("max"))))
            .setSize(0)  
                    )
import static org.hamcrest.Matchers.notNullValue;
 * The OpenSearch Contributors require contributions made to  
        super(staticSettings);  
        int bucketCount = ascendingTimeBuckets.size();
        Terms terms = response.getAggregations().get("foos");  
 *
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertThat(terms, notNullValue());
    }  
    }
                            BucketHelpers.GapPolicy.INSERT_ZEROS
        assertThat(timeBuckets.get(1).getKey(), equalTo(1.0));  
                            "bucketSort",
            assertThat(avg, notNullValue());
        assertSearchResponse(response);  
            )
                }
/*  
import org.opensearch.search.aggregations.metrics.Avg;  
    @Override  
            .addAggregation(
        Terms size2From3Terms = response.getAggregations().get("foos");
        Histogram size3From2Histogram = response.getAggregations().get("time_buckets");
            .addAggregation(
        assertThat(histo, notNullValue());
                    .subAggregation(bucketSort("bucketSort", Collections.emptyList()).size(3).from(2))
            .setSize(0)
            containsString("[bucketSort] is configured to perform nothing." + " Please set either of [sort, size, from] to use bucket_sort")  
        List<? extends Histogram.Bucket> size3TimeBuckets = size3Histogram.getBuckets();
                    )  
            .addAggregation(
    public void testSortHistogram_GivenGapsAndGapPolicyIsInsertZeros() {
                terms("foos").field(TERM_FIELD)  
            .addAggregation(
        assertThat(timeBuckets.size(), equalTo(2));  
                    .subAggregation(
                    .subAggregation(max("max").field("missingValue").missing(1))
        long previousCount = termsBuckets.get(0).getDocCount();
@OpenSearchIntegTestCase.SuiteScopeTestCase  
        }
                )  
            )  
        assertThat(histo.getName(), equalTo("time_buckets"));
        for (int i = 0; i < size2From3TermsBuckets.size(); ++i) {
                histogram("time_buckets").field(TIME_FIELD)
                    .subAggregation(  
