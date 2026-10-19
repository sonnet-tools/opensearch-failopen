        }  
    // expected bucket values for random setup with gaps
        assertThat(deriv.getName(), equalTo("histo"));  
                assertThat(docCountDeriv, nullValue());  
            }
    private static int numValueBuckets;  
                assertThat(sumDeriv, nullValue());
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },  
            lastSumValue = thisSumValue;
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                builders.add(client().prepareIndex("empty_bucket_idx_rnd").setSource(newDocBuilder(i)));
        return jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, singleValueFieldValue).endObject();  
    }
        }
            }  
            if (i > 0) {
        assertThat(deriv.getName(), equalTo("histo"));
        assertAcked(prepareCreate("empty_bucket_idx_rnd").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
            SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
    @ParametersFactory  
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        for (int i = 0; i < valueCounts_empty.length; i++) {
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                    throw e;
            } else {  
            lastSumValue = thisSumValue;
        SearchResponse response = client().prepareSearch("movavg_npe")
        GapPolicy gapPolicy = randomFrom(GapPolicy.values());
            SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
            SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
        assertThat(deriv.getName(), equalTo("histo"));
            }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .subAggregation(avg("avg").field("value"))  
                }  
                assertThat(
/*  
            fail("Expected an Exception but didn't get one");
            }  
            .get();  
    }
            Stats stats = bucket.getAggregations().get("stats");
                    .extendedBounds(0L, numBuckets_empty_rnd - 1)
                }  
    }  
            .get();
            if (i == 1 || i == 3) {  
        // randomized setup for index with empty buckets
                        AggregationPath.parse("deriv.value").getPathElementsAsStringList()
            Sum sum = bucket.getAggregations().get("sum");
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx));
            .get();
    private static int numFirstDerivValueBuckets;
        }  
            long thisFirstDerivativeValue = firstDerivValueCounts[i];
            }
            new Object[] {
    /**  
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);
            .addAggregation(
        Histogram deriv = response.getAggregations().get("histo");
            )
                        .interval(interval)
            if (i == 0) {
        assertSearchResponse(response);  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
            // make approximately half of the buckets empty
                assertThat(docCount2ndDeriv.normalizedValue(), closeTo((double) (secondDerivValueCounts[i - 2]) * 2, 0.00001));
    public void testSingleValueAggDerivativeWithGaps_random() throws Exception {  
    }  
        return Arrays.asList(
        }
    public static Collection<Object[]> parameters() {
        assertThat(deriv, notNullValue());
    private static long[] valueCounts;  
        for (int i = 0; i < numValueBuckets; i++) {
        for (int i = 0; i < numValueBuckets; ++i) {
            Derivative docCount2ndDeriv = bucket.getAggregations().get("2nd_deriv");  
            XContentBuilder doc = jsonBuilder().startObject().field("tick", i).field("value", value).endObject();
import java.util.Arrays;  
        assertThat(buckets.size(), equalTo(numValueBuckets));
            )  
        SearchResponse response = client().prepareSearch("idx")
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) deriv).getProperty("_key");
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.derivative;  
            Histogram.Bucket bucket = buckets.get(i);
        refresh();
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).subAggregation(derivative("deriv", "_count"))
                    .subAggregation(derivative("2nd_deriv", "deriv"))
            if (bucket.getDocCount() == 0) {  
        }
        assertThat(deriv, notNullValue());  
    public void testSingleValueAggDerivativeWithGaps() throws Exception {
                    .subAggregation(derivative("2nd_deriv", "deriv").unit("10ms"))
                assertThat(sumDeriv, nullValue());
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
            .setQuery(matchAllQuery())
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty_rnd[i]);
                    .interval(1)  
                            )  
            .addAggregation(  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
        secondDerivValueCounts = new long[numSecondDerivValueBuckets];
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        Long lastValueCount = null;  
        assertThat(buckets.size(), equalTo(numBuckets_empty_rnd));
        List<? extends Bucket> buckets = deriv.getBuckets();
 * software distributed under the License is distributed on an
        for (int i = 0; i < 10; i++) {
                assertThat(docCountDeriv, nullValue());
                    .interval(interval)
            } else {  
    public void testUnmapped() throws Exception {
        List<Bucket> buckets = new ArrayList<>(deriv.getBuckets());
    public void testDocCountDerivativeWithGaps() throws Exception {
            } else if (!(cause instanceof IllegalArgumentException)) {
                    ),  
        interval = 5;
        indexRandom(true, builders);
        assertThat(deriv, notNullValue());
            Throwable cause = ExceptionsHelper.unwrapCause(e);
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")  
        }
            checkBucketKeyAndDocCount("InternalBucket " + i + ": ", bucket, i, valueCounts_empty[i]);
                assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty[i]));
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
        List<? extends Bucket> buckets = deriv.getBuckets();
        Object[] propertiesSumCounts = (Object[]) ((InternalAggregation) deriv).getProperty("sum.value");
 * under the License.  
            } else {
                                                         // overwritten
                    .interval(1)  
            )
            } else {  
    private static long[] secondDerivValueCounts;
     * test first and second derivative on the sing
        List<? extends Bucket> buckets = deriv.getBuckets();  
        for (int i = 0; i < numValueBuckets; ++i) {
                    .subAggregation(derivative("deriv", "_count"))  
        Long lastFirstDerivativeValueCount = null;  
import org.hamcrest.Matchers;
        firstDerivValueCounts_empty_rnd = new Double[numBuckets_empty_rnd];
        }
            }
            valueCounts_empty_rnd[i] = (long) randomIntBetween(1, 10);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
 * Modifications Copyright OpenSearch Contributors. See
                    .interval(1)
        valueCounts = new long[numValueBuckets];
            if (i == 0) {
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);  
        }  
            }  
 */  
        SearchResponse response = client().prepareSearch("idx")
 *  
                assertThat(docCountDeriv, nullValue());
public class DerivativeIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
                    .subAggregation(derivative("deriv", "_count").unit("1ms"))  
            .setQuery(matchAllQuery())
    public void testPartiallyUnmapped() throws Exception {
            }
import org.opensearch.action.search.SearchResponse;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testDocCountDerivative() {  
        List<? extends Bucket> buckets = deriv.getBuckets();
        Histogram deriv = response.getAggregations().get("histo");
                if (!(rootCause instanceof IllegalArgumentException)) {
            SimpleValue sumDeriv = bucket.getAggregations().get("deriv");  
            assertThat((long) propertiesDocCounts[i], equalTo(valueCounts[i]));
    }
            if (firstDerivValueCounts_empty[i] == null) {  
            Histogram.Bucket bucket = buckets.get(i);
        numSecondDerivValueBuckets = numFirstDerivValueBuckets - 1;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx_rnd));  
        createIndex("idx");
 * this file be licensed under the Apache-2.0 license or a
    private static Long[] valueCounts_empty_rnd;
            )  
        super(dynamicSettings);  
/*
        List<? extends Bucket> buckets = deriv.getBuckets();
            } else {
            .get();  
import static org.hamcrest.core.IsNull.nullValue;
        assertThat(deriv, notNullValue());
        firstDerivValueCounts = new long[numFirstDerivValueBuckets];
            assertThat(stats.getSum(), equalTo((double) expectedSum));
    private XContentBuilder newDocBuilder(int singleValueFieldValue) throws IOException {
                )  
        valueCounts_empty_rnd = new Long[numBuckets_empty_rnd];
    private static Double[] firstDerivValueCounts_empty;  
            Histogram.Bucket bucket = buckets.get(i);
                assertThat(docCountDeriv, nullValue());  
    private static long numDocsEmptyIdx_rnd;  
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).subAggregation(derivative("deriv", "_count"))
            Sum sum = bucket.getAggregations().get("sum");
            .addAggregation(
            Histogram.Bucket bucket = buckets.get(i);
            new Object[] {
        internalCluster().wipeIndices("movavg_npe");
    private static long[] firstDerivValueCounts;
    /**  
        }  
 * KIND, either express or implied.  See the License for the
            double thisSumValue = sum.value();
            .setQuery(matchAllQuery())  
    }
            .addAggregation(  
            if (lastFirstDerivativeValueCount != null) {  
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                assertThat(docCountDeriv, nullValue());
        Histogram deriv = response.getAggregations().get("histo");  
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.movingAvg;
                double expectedDerivative = thisSumValue - lastSumValue;
            )
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        assertThat(deriv, Matchers.notNullValue());
    public void setupSuiteScopeCluster() throws Exception {
                if (Double.isNaN(expectedDerivative)) {
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);  
            }
                    .subAggregation(derivative("deriv", "sum"))
            Histogram.Bucket bucket = buckets.get(i);
    @Override  
            .addAggregation(  
    public DerivativeIT(Settings dynamicSettings) {
import org.opensearch.index.query.QueryBuilders;  
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1).subAggregation(derivative("deriv", "_count")))
        for (int i = 0; i < valueCounts_empty_rnd.length; i++) {
    }
            Sum sum = bucket.getAggregations().get("sum");
        for (int i = 0; i < valueCounts_empty.length; i++) {
            SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
        }
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx));
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);  
        Histogram deriv = searchResponse.getAggregations().get("histo");
                firstDerivValueCounts_empty_rnd[i] = (double) valueCounts_empty_rnd[i] - valueCounts_empty_rnd[i - 1];  
 */  
        assertThat(msg + " key", ((Number) bucket.getKey()).longValue(), equalTo(expectedKey));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
    }
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);  
        assertSearchResponse(response);  
        Histogram deriv = searchResponse.getAggregations().get("histo");
@OpenSearchIntegTestCase.SuiteScopeTestCase  
                    .subAggregation(derivative("deriv", "movavg"))
            if (i == 0) {
        Long expectedSumPreviousBucket = Long.MIN_VALUE; // start value, gets  
        assertThat(buckets.size(), equalTo(numValueBuckets));
        List<IndexRequestBuilder> builders = new ArrayList<>();
                    .subAggregation(derivative("deriv", "stats.sum"))  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                }  
 * this work for additional information regarding copyright
            } else {  
        ensureSearchable();
import org.opensearch.search.aggregations.metrics.Sum;  
                assertThat(docCountDeriv.normalizedValue(), closeTo((double) (firstDerivValueCounts[i - 1]) / 5, 0.00001));
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
            if (randomBoolean()) valueCounts_empty_rnd[i] = 0L;  
        for (int i = 0; i < numValueBuckets; i++) {
    private static long numDocsEmptyIdx;
        assertThat(deriv.getName(), equalTo("histo"));  
            Histogram.Bucket bucket = buckets.get(i);  
                long sumDerivValue = expectedSum - expectedSumPreviousBucket;  
        assertThat(deriv.getName(), equalTo("histo"));
package org.opensearch.search.aggregations.pipeline;
                assertThat(docCountDeriv.value(), equalTo((double) firstDerivValueCounts[i - 1]));
            client().prepareSearch("idx")
            Histogram.Bucket bucket = buckets.get(i);  
            new Object[] {  
            }
        for (int i = 0; i < valueCounts_empty_rnd.length; i++) {
        assertThat(deriv.getName(), equalTo("histo"));  
 * The OpenSearch Contributors require contributions made to  
            Histogram.Bucket bucket = buckets.get(i);  
            SimpleValue sumDeriv = bucket.getAggregations().get("deriv");  
                throw e;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx));
        }
                builders.add(client().prepareIndex("empty_bucket_idx").setSource(newDocBuilder(i)));  
        firstDerivValueCounts_empty = new Double[] { null, 0d, 1d, -2d, 2d, 0d, -2d, 0d, 0d, 3d, -1d, -1d };
 *
            } else {
        SearchResponse response = client().prepareSearch("idx")  
                    .extendedBounds(0L, (long) numBuckets_empty_rnd - 1)
            SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
                assertThat(docCount2ndDeriv.value(), equalTo((double) secondDerivValueCounts[i - 2]));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;  
        assertThat(deriv.getBuckets().size(), equalTo(numValueBuckets));
                assertThat(sumDeriv, notNullValue());
        }  
                } else {
        }
            assertThat((double) propertiesSumCounts[i], equalTo((double) expectedSum));  
            .addAggregation(
            }
        numValueBuckets = randomIntBetween(6, 80);  
        assertThat(buckets.size(), equalTo(valueCounts_empty.length));
        }  
import org.opensearch.action.search.SearchPhaseExecutionException;
        for (int i = 0; i < valueCounts_empty.length; i++) {
                histogram("histo").field("tick")
    public void testSingleValueAggDerivative() throws Exception {
            double thisSumValue = sum.value();  
            .setQuery(matchAllQuery())  
            if (lastValueCount != null) {  
            }
        assertSearchResponse(response);
            .get();
                        )
                    .minDocCount(0)
import static org.hamcrest.Matchers.closeTo;
                firstDerivValueCounts[i - 1] = diff;
                    assertThat(sumDeriv.value(), equalTo(expectedDerivative));  
        Histogram deriv = response.getAggregations().get("histo");
        assertThat(buckets.size(), equalTo(valueCounts_empty.length));
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
        assertThat(deriv.getName(), equalTo("histo"));
            } else if (cause instanceof SearchPhaseExecutionException) {
        final long expectedKey,
                numDocsEmptyIdx++;
}
            SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")  
            lastValueCount = thisValue;
import static org.hamcrest.Matchers.equalTo;
        double lastSumValue = Double.NaN;
            .addAggregation(  
    }
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx_rnd")
                    assertThat(sumDeriv.value(), equalTo(expectedDerivative));  
            Integer value = i;
            .get();  
                assertThat(docCount2ndDeriv, nullValue());
            SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
    }  
                    ),
        assertSearchResponse(response);
            }  
        Histogram deriv = searchResponse.getAggregations().get("histo");
            } else {
    public void testDocCountDerivativeWithGaps_insertZeros() throws Exception {
        // setup for index with empty buckets
            SimpleValue sumDeriv = bucket.getAggregations().get("deriv");  
                value = null;
        assertThat(deriv, Matchers.notNullValue());
        for (int i = 0; i < numBuckets_empty_rnd; i++) {  
        firstDerivValueCounts_empty_rnd[0] = null;  
                long diff = thisValue - lastValueCount;
 * Unless required by applicable law or agreed to in writing,
                                                         // overwritten  
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty_rnd[i]);  
        valueCounts_empty = new Long[] { 1L, 1L, 2L, 0L, 2L, 2L, 0L, 0L, 0L, 3L, 2L, 1L };  
                assertThat(docCount2ndDeriv.value(), closeTo((secondDerivValueCounts[i - 2]), 0.00001));  
 * the Apache License, Version 2.0 (the "License"); you may
        final long expectedDocCount
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        assertSearchResponse(response);
        assertThat(deriv, Matchers.notNullValue());
            expectedSumPreviousBucket = expectedSum;
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
            .get();  
            }
    public void testAvgMovavgDerivNPE() throws Exception {
     */
        Object[] propertiesSumCounts = (Object[]) ((InternalAggregation) deriv).getProperty("stats.sum");  
                                sum("sum").field(SINGLE_VALUED_FIELD_NAME)
                    .subAggregation(derivative("deriv", "sum").gapPolicy(GapPolicy.INSERT_ZEROS))
                    .subAggregation(derivative("deriv", "sum"))  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
 *
            } else {
import org.opensearch.common.settings.Settings;
            if (firstDerivValueCounts_empty[i] == null) {
        List<? extends Bucket> buckets = deriv.getBuckets();  
                } else {
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
        }
import org.opensearch.action.index.IndexRequestBuilder;
                        .subAggregation(  
        }
                double expectedDerivative = thisSumValue - lastSumValue;
        double lastSumValue = Double.NaN;  
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";  
        final String msg,
                        .subAggregation(derivative("deriv", "filters>get>sum"))
        numBuckets_empty_rnd = randomIntBetween(20, 100);  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
                assertThat(docCountDeriv, notNullValue());  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx_rnd));
                    assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
            )
                assertThat(sumDeriv, nullValue());  
import org.opensearch.core.xcontent.XContentBuilder;
            }
                builders.add(client().prepareIndex("idx").setSource(newDocBuilder(i * interval)));
 * not use this file except in compliance with the License.
        for (int i = 0; i < numValueBuckets; ++i) {
 * SPDX-License-Identifier: Apache-2.0
    }
            }
            if (i > 0) {  
            double thisSumValue = sum.value();
    }
            .addAggregation(
        }  
            .setQuery(matchAllQuery())
    ) {  
        Histogram deriv = searchResponse.getAggregations().get("histo");  
        assertThat(deriv.getName(), equalTo("histo"));  
                assertThat(docCountDeriv, nullValue());  
            assertThat(sum.getValue(), equalTo((double) expectedSum));
        indexRandomForConcurrentSearch("movavg_npe");  
        assertThat(buckets.size(), equalTo(valueCounts_empty.length));
            long expectedSum = valueCounts[i] * (i * interval);  
        assertThat(msg + " docCount", bucket.getDocCount(), equalTo(expectedDocCount));  
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) deriv).getProperty("_key");  
                assertThat(sumDeriv, nullValue());  
 * compatible open source license.
                long sumDerivValue = expectedSum - expectedSumPreviousBucket;
 */
    }  
    public void testSingleValueAggDerivative_invalidPath() throws Exception {  
                        "histo",  
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        Histogram deriv = searchResponse.getAggregations().get("histo");  
                    .interval(1)
                    ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(  
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) deriv).getProperty("_count");
 * license agreements. See the NOTICE file distributed with
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx));  
                secondDerivValueCounts[i - 1] = diff;
            if (bucket.getDocCount() == 0) {  
                assertThat(docCountDeriv.value(), equalTo((double) firstDerivValueCounts[i - 1]));
                thisSumValue = 0;
            .get();
        assertThat(deriv.getName(), equalTo("histo"));
        assertThat(deriv, Matchers.notNullValue());  
                assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty[i]));  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(deriv.getName(), equalTo("histo"));  
                            filters("filters", QueryBuilders.termQuery("tag", "foo")).subAggregation(
        double lastSumValue = Double.NaN;  
                assertThat(docCount2ndDeriv, notNullValue());
                throw e;  
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
    private static int numBuckets_empty_rnd;  
            } else {
    private static Double[] firstDerivValueCounts_empty_rnd;
            assertThat((long) propertiesDocCounts[i], equalTo(valueCounts[i]));
            } else {
import static org.hamcrest.core.IsNull.notNullValue;  
        assertThat(deriv, notNullValue());
        assertSearchResponse(response);
                        AggregationPath.parse("deriv.value").getPathElementsAsStringList()
            }  
            Derivative docCountDeriv = bucket.getAggregations().get("deriv");
                assertThat(sumDeriv.value(), equalTo((double) sumDerivValue));
            long expectedSum = valueCounts[i] * (i * interval);
            if (i > 0) {
                    .interval(interval)
            .addAggregation(
 * You may obtain a copy of the License at  
                assertThat(sumDeriv, nullValue());
            )  
        Histogram deriv = response.getAggregations().get("histo");
        try {
                    .interval(interval)  
            Histogram.Bucket bucket = buckets.get(i);
    }
        assertThat(buckets.size(), equalTo(numBuckets_empty_rnd));  
                numDocsEmptyIdx_rnd++;  
import org.opensearch.search.aggregations.InternalAggregation;
            .addAggregation(
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
        assertThat(deriv.getBuckets().size(), equalTo(0));
import org.opensearch.search.aggregations.metrics.Stats;
            assertThat(propertiesKeys[i], equalTo((double) i * interval));
                    .subAggregation(derivative("deriv", "_count").gapPolicy(randomFrom(GapPolicy.values())))
            Histogram.Bucket bucket = buckets.get(i);  
                    equalTo((double) sumDerivValue)  
        for (int i = 0; i < numValueBuckets; ++i) {
            }
                    assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
        );  
            SimpleValue docCount2ndDeriv = bucket.getAggregations().get("2nd_deriv");
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;  
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;  
                long diff = thisFirstDerivativeValue - lastFirstDerivativeValueCount;
            )
            } else {  
        for (int i = 0; i < valueCounts_empty.length; i++) {
        for (int i = 0; i < valueCounts_empty.length; i++) {
     */
        assertThat(deriv, Matchers.notNullValue());
        Long expectedSumPreviousBucket = Long.MIN_VALUE; // start value, gets
            )
            valueCounts[i] = randomIntBetween(1, 20);
            )
            assertThat(sum, notNullValue());
            Histogram.Bucket bucket = buckets.get(i);
                        "histo",
            assertThat((double) propertiesSumCounts[i], equalTo((double) expectedSum));
                    .interval(1)
                assertThat(sumDeriv.value(), equalTo((double) sumDerivValue));  
            .get();
                    .interval(1)
            if (i > 0) {
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) deriv).getProperty("_count");
            if (cause == null) {
            }
        }  
        for (int i = 0; i < numValueBuckets; ++i) {
import static org.opensearch.search.aggregations.AggregationBuilders.filters;
                    .subAggregation(derivative("deriv", "sum").gapPolicy(gapPolicy))  
            for (int docs = 0; docs < valueCounts_empty_rnd[i]; docs++) {
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
        assertThat(buckets.size(), equalTo(valueCounts_empty.length));  
import java.util.List;
            }
            if (i > 1) {  
    private void checkBucketKeyAndDocCount(
    public void testMultiValueAggDerivative() throws Exception {  
            )  
            .get();  
                );
        assertThat(deriv.getName(), equalTo("histo"));  
        List<? extends Bucket> buckets = deriv.getBuckets();
                assertThat(docCount2ndDeriv, nullValue());  
 * ownership. Elasticsearch licenses this file to you under  
    }
            lastFirstDerivativeValueCount = thisFirstDerivativeValue;
            Sum sum = bucket.getAggregations().get("sum");
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);  
                .get();
            .setQuery(matchAllQuery())
        assertThat(deriv.getBuckets().size(), equalTo(numValueBuckets));  
            .get();  
            .get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            )
            .get();
        List<? extends Bucket> buckets = deriv.getBuckets();
            for (int docs = 0; docs < valueCounts[i]; docs++) {  
                assertThat(docCountDeriv, notNullValue());  
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
        assertThat(msg, bucket, notNullValue());
            if (bucket.getDocCount() == 0) {
            long thisValue = valueCounts[i];
            expectedSumPreviousBucket = expectedSum;  
                assertThat(docCountDeriv.value(), closeTo((firstDerivValueCounts[i - 1]), 0.00001));
                thisSumValue = Double.NaN;
                Throwable rootCause = spee.getRootCause();  
        numFirstDerivValueBuckets = numValueBuckets - 1;
        for (int i = 0; i < numValueBuckets; i++) {  
                    ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
        for (int i = 0; i < numFirstDerivValueBuckets; i++) {
            if (firstDerivValueCounts_empty_rnd[i] == null) {  
    public void testSingleValueAggDerivativeWithGaps_insertZeros() throws Exception {  
        List<Bucket> buckets = new ArrayList<>(deriv.getBuckets());
        assertThat(deriv, notNullValue());
import org.opensearch.search.aggregations.support.AggregationPath;
            .addAggregation(
        SearchResponse response = client().prepareSearch("idx")
                    equalTo((double) sumDerivValue)
            } else {
            assertThat(stats, notNullValue());  
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
                double expectedDerivative = thisSumValue - lastSumValue;
            }
        createIndex("movavg_npe");
import java.util.Collection;
                    .subAggregation(movingAvg("movavg", "avg").modelBuilder(new SimpleModel.SimpleModelBuilder()).window(3))
    public void testSingleValuedField_normalised() {  
                    .subAggregation(derivative("deriv", "_count").gapPolicy(GapPolicy.INSERT_ZEROS))
            client().prepareIndex("movavg_npe").setSource(doc).get();
            }
            for (int docs = 0; docs < valueCounts_empty[i]; docs++) {
 * specific language governing permissions and limitations
            .addAggregation(  
import java.util.ArrayList;
import org.opensearch.test.OpenSearchIntegTestCase;  
                SearchPhaseExecutionException spee = (SearchPhaseExecutionException) e;
                    .interval(interval)
                assertThat(sumDeriv, notNullValue());
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx_rnd")
    private static int interval;
        assertSearchResponse(response);
                assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty_rnd[i]));  
            if (i > 0) {
        createIndex("idx_unmapped");  
        assertThat(deriv.getName(), equalTo("histo"));
        Histogram deriv = response.getAggregations().get("histo");
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")  
import org.opensearch.ExceptionsHelper;  
 * GitHub history for details.
        final Histogram.Bucket bucket,  
                thisSumValue = gapPolicy == GapPolicy.INSERT_ZEROS ? 0 : Double.NaN;
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                );
            }
import java.io.IOException;
    }
            }
                if (Double.isNaN(expectedDerivative)) {
                assertThat(docCount2ndDeriv, notNullValue());
        Histogram deriv = searchResponse.getAggregations().get("histo");
        SearchResponse response = client().prepareSearch("idx_unmapped")
                assertThat(
    public void testDocCountDerivativeWithGaps_random() throws Exception {
    private static Long[] valueCounts_empty;
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));  
    private static int numSecondDerivValueBuckets;
        List<? extends Bucket> buckets = deriv.getBuckets();
                assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));  
        } catch (Exception e) {  
                .addAggregation(  
/*  
        assertThat(deriv.getBuckets().size(), equalTo(numValueBuckets));
     * test first and second derivative on the sing
            if (i > 0) {
    }  
        assertThat(deriv, Matchers.notNullValue());  
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                assertThat(docCountDeriv, notNullValue());  
            if (i > 1) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(propertiesKeys[i], equalTo((double) i * interval));  
            lastSumValue = thisSumValue;
        }
