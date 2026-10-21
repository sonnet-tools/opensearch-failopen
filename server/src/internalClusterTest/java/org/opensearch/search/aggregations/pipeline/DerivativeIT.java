        }
        assertThat(deriv.getBuckets().size(), equalTo(numValueBuckets));
            .addAggregation(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx));
            assertThat((double) propertiesSumCounts[i], equalTo((double) expectedSum));
                assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
 * SPDX-License-Identifier: Apache-2.0
            .addAggregation(
 * GitHub history for details.
            } else {
            Sum sum = bucket.getAggregations().get("sum");
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.derivative;
            }
        // randomized setup for index with empty buckets
        firstDerivValueCounts_empty_rnd = new Double[numBuckets_empty_rnd];
        for (int i = 0; i < valueCounts_empty.length; i++) {
import org.opensearch.search.aggregations.metrics.Stats;
    private static long numDocsEmptyIdx_rnd;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx));
 * ownership. Elasticsearch licenses this file to you under
        assertThat(buckets.size(), equalTo(valueCounts_empty.length));
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
        assertThat(buckets.size(), equalTo(valueCounts_empty.length));
            )
        createIndex("idx");
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < numFirstDerivValueBuckets; i++) {
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                        AggregationPath.parse("deriv.value").getPathElementsAsStringList()
        Histogram deriv = searchResponse.getAggregations().get("histo");
import org.opensearch.search.aggregations.InternalAggregation;
        List<? extends Bucket> buckets = deriv.getBuckets();
        assertThat(buckets.size(), equalTo(valueCounts_empty.length));
            .get();
            } else {
import org.opensearch.ExceptionsHelper;
        valueCounts_empty = new Long[] { 1L, 1L, 2L, 0L, 2L, 2L, 0L, 0L, 0L, 3L, 2L, 1L };
    private static Double[] firstDerivValueCounts_empty;
            }
                thisSumValue = gapPolicy == GapPolicy.INSERT_ZEROS ? 0 : Double.NaN;
/*
                    .interval(interval)
            } else {
        }
        Histogram deriv = searchResponse.getAggregations().get("histo");
 */
 * specific language governing permissions and limitations
        assertThat(deriv, notNullValue());
            Histogram.Bucket bucket = buckets.get(i);
        assertThat(deriv.getName(), equalTo("histo"));
                assertThat(docCountDeriv, nullValue());
            double thisSumValue = sum.value();
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
    private static int interval;
            assertThat(propertiesKeys[i], equalTo((double) i * interval));
            .setQuery(matchAllQuery())
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) deriv).getProperty("_key");
            if (i > 0) {
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                assertThat(docCountDeriv, notNullValue());
                    .subAggregation(derivative("deriv", "sum").gapPolicy(GapPolicy.INSERT_ZEROS))
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty_rnd[i]);
            assertThat((long) propertiesDocCounts[i], equalTo(valueCounts[i]));
            }
            }
                assertThat(docCountDeriv.value(), equalTo((double) firstDerivValueCounts[i - 1]));
        }
    public void testSingleValuedField_normalised() {
                numDocsEmptyIdx_rnd++;
 */
    }
        Object[] propertiesSumCounts = (Object[]) ((InternalAggregation) deriv).getProperty("stats.sum");
        Histogram deriv = searchResponse.getAggregations().get("histo");
                secondDerivValueCounts[i - 1] = diff;
                    .subAggregation(avg("avg").field("value"))
public class DerivativeIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
                            filters("filters", QueryBuilders.termQuery("tag", "foo")).subAggregation(
            expectedSumPreviousBucket = expectedSum;
        assertThat(deriv.getName(), equalTo("histo"));
        return Arrays.asList(
import org.hamcrest.Matchers;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
                    .interval(1)
    /**
                assertThat(sumDeriv, nullValue());
        GapPolicy gapPolicy = randomFrom(GapPolicy.values());
    public void testSingleValueAggDerivativeWithGaps_random() throws Exception {
            valueCounts[i] = randomIntBetween(1, 20);
            }
        for (int i = 0; i < numValueBuckets; ++i) {
        assertSearchResponse(response);
        }
        numValueBuckets = randomIntBetween(6, 80);
            assertThat(propertiesKeys[i], equalTo((double) i * interval));
            lastSumValue = thisSumValue;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx_rnd));
    private static int numFirstDerivValueBuckets;
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        for (int i = 0; i < numValueBuckets; i++) {
                    .subAggregation(derivative("deriv", "movavg"))
                    .interval(1)
        // setup for index with empty buckets
        Long lastFirstDerivativeValueCount = null;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
        assertSearchResponse(response);
        assertSearchResponse(response);
            new Object[] {
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            )
            assertThat((double) propertiesSumCounts[i], equalTo((double) expectedSum));
 * this work for additional information regarding copyright
     * test first and second derivative on the sing
            Histogram.Bucket bucket = buckets.get(i);
        assertThat(deriv, Matchers.notNullValue());
            assertThat((long) propertiesDocCounts[i], equalTo(valueCounts[i]));
        Histogram deriv = searchResponse.getAggregations().get("histo");
            }
    public void testDocCountDerivative() {
    private static long[] secondDerivValueCounts;
            if (bucket.getDocCount() == 0) {
    }
            Histogram.Bucket bucket = buckets.get(i);
                    .subAggregation(derivative("deriv", "sum").gapPolicy(gapPolicy))
                if (!(rootCause instanceof IllegalArgumentException)) {
        }
        }
 *
                        .subAggregation(
            .get();
                value = null;
    }
                    ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
                    .subAggregation(derivative("deriv", "stats.sum"))
            SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
                    equalTo((double) sumDerivValue)
                    throw e;
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).subAggregation(derivative("deriv", "_count"))
                assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty[i]));
        assertThat(deriv, notNullValue());
        );
                        "histo",
        indexRandom(true, builders);
        for (int i = 0; i < numValueBuckets; ++i) {
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            if (i > 0) {
        }
        assertThat(deriv.getName(), equalTo("histo"));
            }
        SearchResponse response = client().prepareSearch("movavg_npe")
    public void testDocCountDerivativeWithGaps_insertZeros() throws Exception {
            Histogram.Bucket bucket = buckets.get(i);
                    .interval(1)
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                    .subAggregation(derivative("deriv", "_count").unit("1ms"))
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
    }
            }
                assertThat(docCount2ndDeriv.normalizedValue(), closeTo((double) (secondDerivValueCounts[i - 2]) * 2, 0.00001));
        Long lastValueCount = null;
            .get();
            .get();
                long sumDerivValue = expectedSum - expectedSumPreviousBucket;
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty_rnd[i]);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    ) {
            // make approximately half of the buckets empty
            } else if (!(cause instanceof IllegalArgumentException)) {
        valueCounts = new long[numValueBuckets];
                )
        assertThat(buckets.size(), equalTo(numBuckets_empty_rnd));
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1).subAggregation(derivative("deriv", "_count")))
 * not use this file except in compliance with the License.
            new Object[] {
                assertThat(docCountDeriv, nullValue());
}
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.movingAvg;
        assertSearchResponse(response);
                assertThat(docCount2ndDeriv, nullValue());
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
            if (i == 0) {
                firstDerivValueCounts[i - 1] = diff;
        List<? extends Bucket> buckets = deriv.getBuckets();
        assertThat(buckets.size(), equalTo(valueCounts_empty.length));
        firstDerivValueCounts = new long[numFirstDerivValueBuckets];
            long expectedSum = valueCounts[i] * (i * interval);
            lastFirstDerivativeValueCount = thisFirstDerivativeValue;
            .addAggregation(
        Object[] propertiesKeys = (Object[]) ((InternalAggregation) deriv).getProperty("_key");
    }
                assertThat(docCountDeriv, notNullValue());
            Sum sum = bucket.getAggregations().get("sum");
            }
        Long expectedSumPreviousBucket = Long.MIN_VALUE; // start value, gets
            Stats stats = bucket.getAggregations().get("stats");
        assertThat(deriv.getBuckets().size(), equalTo(0));
                assertThat(docCount2ndDeriv.value(), equalTo((double) secondDerivValueCounts[i - 2]));
                assertThat(sumDeriv, nullValue());
            assertThat(sum, notNullValue());
                firstDerivValueCounts_empty_rnd[i] = (double) valueCounts_empty_rnd[i] - valueCounts_empty_rnd[i - 1];
    private static long[] valueCounts;
            Histogram.Bucket bucket = buckets.get(i);
                    .subAggregation(derivative("deriv", "_count").gapPolicy(GapPolicy.INSERT_ZEROS))
            if (i > 1) {
        final long expectedKey,
            XContentBuilder doc = jsonBuilder().startObject().field("tick", i).field("value", value).endObject();
import org.opensearch.test.OpenSearchIntegTestCase;
        for (int i = 0; i < valueCounts_empty_rnd.length; i++) {
    public void testDocCountDerivativeWithGaps_random() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
    }
                    .subAggregation(derivative("2nd_deriv", "deriv").unit("10ms"))
                assertThat(docCountDeriv, notNullValue());
            }
            .setQuery(matchAllQuery())
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        }
        assertThat(deriv.getBuckets().size(), equalTo(numValueBuckets));
            .setQuery(matchAllQuery())
            if (bucket.getDocCount() == 0) {
    }
        assertThat(buckets.size(), equalTo(numValueBuckets));
                long diff = thisValue - lastValueCount;
            .addAggregation(
            }
    // expected bucket values for random setup with gaps
    public void testSingleValueAggDerivative_invalidPath() throws Exception {
                    equalTo((double) sumDerivValue)
        Histogram deriv = searchResponse.getAggregations().get("histo");
        for (int i = 0; i < numValueBuckets; ++i) {
 * software distributed under the License is distributed on an
        assertThat(deriv.getName(), equalTo("histo"));
 * Unless required by applicable law or agreed to in writing,
    private static int numSecondDerivValueBuckets;
 */
import java.util.Collection;
            }
            .get();
                    .subAggregation(derivative("deriv", "sum"))
            Histogram.Bucket bucket = buckets.get(i);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        }
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx_rnd")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            double thisSumValue = sum.value();
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);
            if (firstDerivValueCounts_empty_rnd[i] == null) {
                assertThat(docCountDeriv.value(), closeTo((firstDerivValueCounts[i - 1]), 0.00001));
            }
    }
            assertThat(sum.getValue(), equalTo((double) expectedSum));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
     * test first and second derivative on the sing
    private static long numDocsEmptyIdx;
                builders.add(client().prepareIndex("empty_bucket_idx_rnd").setSource(newDocBuilder(i)));
     */
            )
            } else {
            .setQuery(matchAllQuery())
            expectedSumPreviousBucket = expectedSum;
                    .subAggregation(derivative("deriv", "_count").gapPolicy(randomFrom(GapPolicy.values())))
 * compatible open source license.
    private static Double[] firstDerivValueCounts_empty_rnd;
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                assertThat(
                .addAggregation(
            Histogram.Bucket bucket = buckets.get(i);
import static org.hamcrest.Matchers.closeTo;
     */
        Long expectedSumPreviousBucket = Long.MIN_VALUE; // start value, gets
import org.opensearch.action.search.SearchPhaseExecutionException;
        for (int i = 0; i < numValueBuckets; i++) {
            if (i == 1 || i == 3) {
                    .minDocCount(0)
                    .interval(interval)
    public void testSingleValueAggDerivativeWithGaps() throws Exception {
            } else {
            client().prepareSearch("idx")
        assertThat(msg + " docCount", bucket.getDocCount(), equalTo(expectedDocCount));
 * Licensed to Elasticsearch under one or more contributor
        firstDerivValueCounts_empty = new Double[] { null, 0d, 1d, -2d, 2d, 0d, -2d, 0d, 0d, 3d, -1d, -1d };
        List<? extends Bucket> buckets = deriv.getBuckets();
            if (lastFirstDerivativeValueCount != null) {
        Histogram deriv = response.getAggregations().get("histo");
            .get();
                    .interval(interval)
                histogram("histo").field("tick")
/*
                assertThat(sumDeriv, nullValue());
                    .subAggregation(derivative("2nd_deriv", "deriv"))
                throw e;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                thisSumValue = 0;
            }
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
    @Override
        assertThat(deriv, Matchers.notNullValue());
            if (i > 0) {
            )
    public void testAvgMovavgDerivNPE() throws Exception {
        assertSearchResponse(response);
            )
                long diff = thisFirstDerivativeValue - lastFirstDerivativeValueCount;
            )
import java.util.Arrays;
    }
            SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
        for (int i = 0; i < valueCounts_empty_rnd.length; i++) {
                                                         // overwritten
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.search.aggregations.support.AggregationPath;
            long expectedSum = valueCounts[i] * (i * interval);
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
            SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
                numDocsEmptyIdx++;
        internalCluster().wipeIndices("movavg_npe");
            )
            SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
        assertThat(deriv, Matchers.notNullValue());
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx_rnd));
            Sum sum = bucket.getAggregations().get("sum");
        valueCounts_empty_rnd = new Long[numBuckets_empty_rnd];
            Throwable cause = ExceptionsHelper.unwrapCause(e);
 * KIND, either express or implied.  See the License for the
            if (i > 1) {
        final Histogram.Bucket bucket,
    private XContentBuilder newDocBuilder(int singleValueFieldValue) throws IOException {
            Integer value = i;
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
                assertThat(docCount2ndDeriv, notNullValue());
            SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
                assertThat(docCountDeriv.value(), equalTo((double) firstDerivValueCounts[i - 1]));
            }
        assertThat(deriv, Matchers.notNullValue());
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);
        } catch (Exception e) {
        indexRandomForConcurrentSearch("movavg_npe");
            }
        assertAcked(prepareCreate("empty_bucket_idx_rnd").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
    public void setupSuiteScopeCluster() throws Exception {
        Histogram deriv = response.getAggregations().get("histo");
            if (firstDerivValueCounts_empty[i] == null) {
        interval = 5;
                assertThat(docCountDeriv.normalizedValue(), closeTo((double) (firstDerivValueCounts[i - 1]) / 5, 0.00001));
                assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty[i]));
                throw e;
            lastSumValue = thisSumValue;
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx_rnd")
            if (lastValueCount != null) {
 * The OpenSearch Contributors require contributions made to
                        )
 *
        List<? extends Bucket> buckets = deriv.getBuckets();
                );
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
    public DerivativeIT(Settings dynamicSettings) {
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            .get();
import static org.hamcrest.core.IsNull.nullValue;
import org.opensearch.index.query.QueryBuilders;
            SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
            if (cause == null) {
    public void testDocCountDerivativeWithGaps() throws Exception {
        assertThat(msg, bucket, notNullValue());
    public static Collection<Object[]> parameters() {
        assertThat(deriv.getName(), equalTo("histo"));
    }
                    ),
                assertThat(sumDeriv, notNullValue());
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        assertThat(deriv, notNullValue());
                builders.add(client().prepareIndex("idx").setSource(newDocBuilder(i * interval)));
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        for (int i = 0; i < valueCounts_empty.length; i++) {
        SearchResponse response = client().prepareSearch("idx")
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.metrics.Sum;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx));
        double lastSumValue = Double.NaN;
        List<? extends Bucket> buckets = deriv.getBuckets();
    }
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
            if (i == 0) {
            .addAggregation(
            double thisSumValue = sum.value();
            .addAggregation(
                    assertThat(sumDeriv.value(), equalTo(expectedDerivative));
            for (int docs = 0; docs < valueCounts_empty[i]; docs++) {
            } else {
        Histogram deriv = response.getAggregations().get("histo");
    }
        assertThat(msg + " key", ((Number) bucket.getKey()).longValue(), equalTo(expectedKey));
            SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
            Histogram.Bucket bucket = buckets.get(i);
        SearchResponse response = client().prepareSearch("idx_unmapped")
        refresh();
            valueCounts_empty_rnd[i] = (long) randomIntBetween(1, 10);
        assertThat(deriv.getName(), equalTo("histo"));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
    private static int numValueBuckets;
    private static Long[] valueCounts_empty_rnd;
            SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .subAggregation(derivative("deriv", "filters>get>sum"))
                assertThat(sumDeriv.value(), equalTo((double) sumDerivValue));
        Object[] propertiesSumCounts = (Object[]) ((InternalAggregation) deriv).getProperty("sum.value");
                    .subAggregation(movingAvg("movavg", "avg").modelBuilder(new SimpleModel.SimpleModelBuilder()).window(3))
                double expectedDerivative = thisSumValue - lastSumValue;
                    assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
            }
            Histogram.Bucket bucket = buckets.get(i);
                assertThat(docCountDeriv, nullValue());
    public void testSingleValueAggDerivative() throws Exception {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocsEmptyIdx));
    public void testMultiValueAggDerivative() throws Exception {
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
            .get();
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                double expectedDerivative = thisSumValue - lastSumValue;
                assertThat(sumDeriv, nullValue());
            )
        }
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            } else {
        List<Bucket> buckets = new ArrayList<>(deriv.getBuckets());
@OpenSearchIntegTestCase.SuiteScopeTestCase
                Throwable rootCause = spee.getRootCause();
                    .interval(interval)
        List<Bucket> buckets = new ArrayList<>(deriv.getBuckets());
            for (int docs = 0; docs < valueCounts[i]; docs++) {
                    .subAggregation(derivative("deriv", "sum"))
 *
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i, valueCounts_empty[i]);
    private static long[] firstDerivValueCounts;
            }
                assertThat(docCount2ndDeriv, notNullValue());
        assertSearchResponse(response);
    }
    public void testPartiallyUnmapped() throws Exception {
                if (Double.isNaN(expectedDerivative)) {
import java.util.ArrayList;
        Histogram deriv = searchResponse.getAggregations().get("histo");
        }
                );
            new Object[] {
                assertThat(
        createIndex("idx_unmapped");
        assertThat(buckets.size(), equalTo(numBuckets_empty_rnd));
            lastSumValue = thisSumValue;
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) deriv).getProperty("_count");
            }
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
                assertThat(sumDeriv, notNullValue());
        assertThat(buckets.size(), equalTo(numValueBuckets));
        List<? extends Bucket> buckets = deriv.getBuckets();
                }
            if (bucket.getDocCount() == 0) {
                assertThat(docCountDeriv, nullValue());
            for (int docs = 0; docs < valueCounts_empty_rnd[i]; docs++) {
            long thisValue = valueCounts[i];
                    .subAggregation(derivative("deriv", "_count"))
import static org.opensearch.search.aggregations.AggregationBuilders.filters;
    }
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
            }
            Sum sum = bucket.getAggregations().get("sum");
        }
                    .interval(1)
                assertThat(docCount2ndDeriv, nullValue());
        for (int i = 0; i < numValueBuckets; ++i) {
        return jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, singleValueFieldValue).endObject();
            Histogram.Bucket bucket = buckets.get(i);
        final long expectedDocCount
                }
import org.opensearch.common.settings.Settings;
                } else {
            .addAggregation(
        for (int i = 0; i < numValueBuckets; i++) {
                assertThat(docCountDeriv.value(), equalTo(firstDerivValueCounts_empty_rnd[i]));
                    assertThat(sumDeriv.value(), closeTo(expectedDerivative, 0.00001));
        List<? extends Bucket> buckets = deriv.getBuckets();
        numBuckets_empty_rnd = randomIntBetween(20, 100);
            checkBucketKeyAndDocCount("InternalBucket " + i, bucket, i * interval, valueCounts[i]);
    /**
            Derivative docCount2ndDeriv = bucket.getAggregations().get("2nd_deriv");
import org.opensearch.action.index.IndexRequestBuilder;
        }
    }
        assertThat(deriv.getName(), equalTo("histo"));
            }
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).subAggregation(derivative("deriv", "_count"))
            }
            if (i > 0) {
                }
            .addAggregation(
        try {
        secondDerivValueCounts = new long[numSecondDerivValueBuckets];
            .addAggregation(
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
            } else {
            )
            )
                    ),
                SearchPhaseExecutionException spee = (SearchPhaseExecutionException) e;
                assertThat(docCountDeriv, nullValue());
        for (int i = 0; i < 10; i++) {
        assertThat(deriv, Matchers.notNullValue());
            )
                        AggregationPath.parse("deriv.value").getPathElementsAsStringList()
            SimpleValue docCountDeriv = bucket.getAggregations().get("deriv");
            .get();
                    .interval(1)
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        createIndex("movavg_npe");
                long sumDerivValue = expectedSum - expectedSumPreviousBucket;
            if (i == 0) {
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
import java.io.IOException;
        SearchResponse response = client().prepareSearch("idx")
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                    .interval(1)
        }
            .addAggregation(
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        List<? extends Bucket> buckets = deriv.getBuckets();
            Histogram.Bucket bucket = buckets.get(i);
            if (i > 0) {
            assertThat(stats, notNullValue());
                    .subAggregation(stats("stats").field(SINGLE_VALUED_FIELD_NAME))
                double expectedDerivative = thisSumValue - lastSumValue;
        List<? extends Bucket> buckets = deriv.getBuckets();
        assertThat(deriv, notNullValue());
                    ((InternalMultiBucketAggregation.InternalBucket) bucket).getProperty(
            } else {
            }
    private static Long[] valueCounts_empty;
    }
        numSecondDerivValueBuckets = numFirstDerivValueBuckets - 1;
                        .interval(interval)
        double lastSumValue = Double.NaN;
        SearchResponse response = client().prepareSearch("idx")
            } else {
            if (randomBoolean()) valueCounts_empty_rnd[i] = 0L;
            SimpleValue docCount2ndDeriv = bucket.getAggregations().get("2nd_deriv");
    @ParametersFactory
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
            } else {
                    .extendedBounds(0L, (long) numBuckets_empty_rnd - 1)
        Object[] propertiesDocCounts = (Object[]) ((InternalAggregation) deriv).getProperty("_count");
    public void testUnmapped() throws Exception {
        assertThat(deriv.getName(), equalTo("histo"));
            if (i > 0) {
 * You may obtain a copy of the License at
        }
import java.util.List;
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
            if (firstDerivValueCounts_empty[i] == null) {
            } else if (cause instanceof SearchPhaseExecutionException) {
        numFirstDerivValueBuckets = numValueBuckets - 1;
import static org.hamcrest.Matchers.equalTo;
    }
        assertThat(deriv.getBuckets().size(), equalTo(numValueBuckets));
                builders.add(client().prepareIndex("empty_bucket_idx").setSource(newDocBuilder(i)));
            long thisFirstDerivativeValue = firstDerivValueCounts[i];
                if (Double.isNaN(expectedDerivative)) {
        assertThat(deriv.getName(), equalTo("histo"));
            .addAggregation(
                assertThat(docCountDeriv, nullValue());
 * under the License.
import static org.hamcrest.core.IsNull.notNullValue;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
                                sum("sum").field(SINGLE_VALUED_FIELD_NAME)
            .setQuery(matchAllQuery())
            .get();
                assertThat(sumDeriv.value(), equalTo((double) sumDerivValue));
            } else {
        }
        double lastSumValue = Double.NaN;
            }
            .get();
import org.opensearch.action.search.SearchResponse;
                .get();
            checkBucketKeyAndDocCount("InternalBucket " + i + ": ", bucket, i, valueCounts_empty[i]);
/*
            } else {
            assertThat(stats.getSum(), equalTo((double) expectedSum));
        assertSearchResponse(response);
    }
        for (int i = 0; i < numValueBuckets; ++i) {
        for (int i = 0; i < valueCounts_empty.length; i++) {
        }
                assertThat(docCount2ndDeriv.value(), closeTo((secondDerivValueCounts[i - 2]), 0.00001));
                                                         // overwritten
package org.opensearch.search.aggregations.pipeline;
        super(dynamicSettings);
                thisSumValue = Double.NaN;
    public void testSingleValueAggDerivativeWithGaps_insertZeros() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
                assertThat(sumDeriv, nullValue());
        firstDerivValueCounts_empty_rnd[0] = null;
        for (int i = 0; i < numBuckets_empty_rnd; i++) {
            .setQuery(matchAllQuery())
            .addAggregation(
    private void checkBucketKeyAndDocCount(
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
                        "histo",
        assertThat(deriv.getName(), equalTo("histo"));
            lastValueCount = thisValue;
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        }
import org.opensearch.core.xcontent.XContentBuilder;
                } else {
        assertThat(deriv, notNullValue());
        Histogram deriv = response.getAggregations().get("histo");
                    assertThat(sumDeriv.value(), equalTo(expectedDerivative));
        Histogram deriv = response.getAggregations().get("histo");
                            )
            SimpleValue sumDeriv = bucket.getAggregations().get("deriv");
            )
            fail("Expected an Exception but didn't get one");
        assertThat(deriv, Matchers.notNullValue());
        }
        assertThat(deriv, notNullValue());
            .get();
            .get();
            Derivative docCountDeriv = bucket.getAggregations().get("deriv");
        List<IndexRequestBuilder> builders = new ArrayList<>();
        Histogram deriv = response.getAggregations().get("histo");
        ensureSearchable();
        final String msg,
        for (int i = 0; i < valueCounts_empty.length; i++) {
        for (int i = 0; i < valueCounts_empty.length; i++) {
        assertThat(deriv.getName(), equalTo("histo"));
    private static int numBuckets_empty_rnd;
                    .extendedBounds(0L, numBuckets_empty_rnd - 1)
        assertThat(deriv.getName(), equalTo("histo"));
 * the Apache License, Version 2.0 (the "License"); you may
            client().prepareIndex("movavg_npe").setSource(doc).get();
