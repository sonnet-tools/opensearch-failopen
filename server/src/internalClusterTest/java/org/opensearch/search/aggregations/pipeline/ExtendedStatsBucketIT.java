        Terms terms = response.getAggregations().get("terms");
                Histogram.Bucket bucket = buckets.get(j);
        );
            Terms.Bucket bucket = buckets.get(i);
            min = Math.min(min, sum.value());
            Histogram histo = termsBucket.getAggregations().get("histo");
import org.opensearch.action.index.IndexRequestBuilder;
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
 * ownership. Elasticsearch licenses this file to you under
            if (!(rootCause instanceof IllegalArgumentException)) {
        Throwable cause = ExceptionsHelper.unwrapCause(ex);
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
    static int interval;
        assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
            ExtendedStatsBucket extendedStatsBucketValue = termsBucket.getAggregations().get("avg_histo_bucket");
                min = Math.min(min, sum.value());
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            .get();
        minRandomValue = 0;
            )
 * software distributed under the License is distributed on an
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
                    .subAggregation(
                if (bucket.getDocCount() != 0) {
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            assertThat(extendedStatsBucketValue.getMax(), equalTo(max));
                count++;
public class ExtendedStatsBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat(extendedStatsBucketValue.getMin(), equalTo(0.0));
                    assertThat(sum, notNullValue());
            .get();
import org.opensearch.action.search.SearchPhaseExecutionException;
 * this file be licensed under the Apache-2.0 license or a
    }
            Throwable rootCause = spee.getRootCause();
                .addAggregation(
            }
            count++;
                client().prepareIndex("idx_gappy")
            assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgHistoValue));
            new Object[] {
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
        for (int i = 0; i < numValueBuckets; ++i) {
                    count++;
            double sumOfSquares = 0;
            count++;
            int aggHistoCount = 0;
                assertThat(bucket, notNullValue());
                client().prepareIndex("idx")
            assertThat(extendedStatsBucketValue.getMax(), equalTo(max));
        assertThat(buckets.size(), equalTo(interval));
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            .get();
        assertThat(histo, notNullValue());
        double stdDev = Math.sqrt(var);
            .addAggregation(
            )
            double min = Double.POSITIVE_INFINITY;
            } else if (i == 4) {
            builders.add(
        assertThat(termsBuckets.size(), equalTo(interval));
        double avgValue = count == 0 ? Double.NaN : (sum / count);
            Sum sum = bucket.getAggregations().get("sum");
            max = Math.max(max, sum.value());
            assertThat(extendedStatsBucketValue, notNullValue());
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            for (int j = 0; j < numValueBuckets; ++j) {
            aggTermsSum += avgHistoValue;
                            .field("tag", "tag" + (i % interval))
            max = Math.max(max, bucket.getDocCount());
            double min = Double.POSITIVE_INFINITY;
            valueCounts[bucket]++;
            sumOfSquares += sum.value() * sum.value();
        double max = Double.NEGATIVE_INFINITY;
import org.opensearch.search.aggregations.BucketOrder;
            .get();
            double avgValue = count == 0 ? Double.NaN : (sum / count);
        for (int i = 0; i < interval; ++i) {
            int count = 0;
import java.util.Arrays;
            .addAggregation(extendedStatsBucket("extended_stats_bucket", "terms>sum"))
        assertThat(extendedStatsBucketValue.getAvg(), equalTo(avg));
        assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
                    .order(BucketOrder.key(true))
        assertThat(histo.getName(), equalTo("histo"));
        Histogram histo = response.getAggregations().get("histo");
            assertThat(bucket, notNullValue());
        assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
    static int numValueBuckets;
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
            assertThat(extendedStatsBucketValue, notNullValue());
        double avgTermsValue = aggTermsCount == 0 ? Double.NaN : (aggTermsSum / aggTermsCount);
        SearchResponse response = client().prepareSearch("idx")
            assertThat(bucket, notNullValue());
        }
            );
        double sumOfSquares = 0;
        assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgTermsValue));
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
            builders.add(
        assertSearchResponse(response);
import static org.hamcrest.Matchers.greaterThan;
 *
            sum += bucket.getDocCount();
            assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i == 4 ? 3 : i).endObject())
            double max = Double.NEGATIVE_INFINITY;
            .addAggregation(
        indexRandom(true, builders);
            Terms.Bucket termsBucket = termsBuckets.get(i);
            )
package org.opensearch.search.aggregations.pipeline;
        assertThat(terms.getName(), equalTo("terms"));
                terms("terms").field("tag")
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        for (int i = 0; i < 2; i++) {
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void testDocCountTopLevel() throws Exception {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                bucketSum += sum.value();
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
            double sumOfSquares = 0;
                max = Math.max(max, sum.value());
        }
        return Arrays.asList(
        SearchResponse response = client().prepareSearch("idx")
            double max = Double.NEGATIVE_INFINITY;
        Terms terms = response.getAggregations().get("terms");
                    .subAggregation(extendedStatsBucket("avg_histo_bucket", "histo>_count"))
        if (cause == null) {
            for (int j = 0; j < numValueBuckets; ++j) {
                            .interval(interval)
    public void testNested() throws Exception {
            }
    public ExtendedStatsBucketIT(Settings staticSettings) {
                Histogram.Bucket bucket = buckets.get(j);
        assertThat(extendedStatsBucketValue, notNullValue());
                throw ex;
import java.util.List;
                    )
            Histogram histo = termsBucket.getAggregations().get("histo");
                        .subAggregation(
import java.util.ArrayList;
                    .setId("" + i)
        double min = Double.POSITIVE_INFINITY;
        assertThat(extendedStatsBucketValue.getVariance(), equalTo(var));
            assertThat(histo.getName(), equalTo("histo"));
            new Object[] {
                            .extendedBounds(minRandomValue, maxRandomValue)
        assertThat(terms, notNullValue());
        maxRandomValue = 20;
        for (int i = 0; i < interval; ++i) {
        valueCounts = new long[numValueBuckets];
        assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgValue));
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());
        assertSearchResponse(response);
        }
        assertThat(extendedStatsBucketValue.getCount(), equalTo(count));
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
@OpenSearchIntegTestCase.SuiteScopeTestCase
        } else if (cause instanceof SearchPhaseExecutionException) {
        List<? extends Bucket> buckets = histo.getBuckets();
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        assertThat(extendedStatsBucketValue.getStdDeviation(), equalTo(stdDev));
            for (int j = 0; j < numValueBuckets; ++j) {
 * compatible open source license.
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            Terms.Bucket termsBucket = termsBuckets.get(i);
        assertThat(buckets.size(), equalTo(0));
            assertThat(histo.getName(), equalTo("histo"));
            assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
                    .setId("" + i)
        assertThat(extendedStatsBucketValue.getAvg(), equalTo(Double.NaN));
                        jsonBuilder().startObject()
        ExtendedStatsBucket extendedStatsBucketValue = response.getAggregations().get("avg_terms_bucket");
        Terms terms = response.getAggregations().get("terms");
        assertThat(extendedStatsBucketValue, notNullValue());
        double aggTermsSum = 0;
        assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgValue));
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
                            .endObject()
import org.opensearch.ExceptionsHelper;
                    .subAggregation(
        assertSearchResponse(response);
    }
        assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
                terms("terms").field("tag")
        Exception ex = expectThrows(
            .get();
                assertThat(bucket, notNullValue());
                    )
/*
        }
            assertThat(termsBucket, notNullValue());
            for (int j = 0; j < numValueBuckets; ++j) {
        assertThat(terms, notNullValue());
        double max = Double.NEGATIVE_INFINITY;
            SearchPhaseExecutionException spee = (SearchPhaseExecutionException) ex;
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
        double avg = sum / count;
        double sumOfSquares = 0;
            } else {
        double sumOfSqrs = 1.0 + 1.0 + 1.0 + 4.0 + 0.0 + 1.0;
 * this work for additional information regarding copyright
                assertThat(sum, notNullValue());
            bucketSum += sum.value();
                assertThat(bucket, notNullValue());
            )
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
            Terms.Bucket termsBucket = termsBuckets.get(i);
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx_gappy")
            new Object[] {
 * Licensed to Elasticsearch under one or more contributor
        assertThat(histo, notNullValue());
        assertThat(extendedStatsBucketValue.getSum(), equalTo(sum));
            assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgValue));
        assertThat(termsBuckets.size(), equalTo(interval));
            int count = 0;
            .get();
            Histogram histo = termsBucket.getAggregations().get("histo");
        double avgValue = count == 0 ? Double.NaN : (bucketSum / count);
                                .extendedBounds(minRandomValue, maxRandomValue)
        for (int i = 0; i < interval; ++i) {
            ExtendedStatsBucket extendedStatsBucketValue = termsBucket.getAggregations().get("extended_stats_bucket");
                min = Math.min(min, bucket.getDocCount());
                max = Math.max(max, bucket.getDocCount());
 * Unless required by applicable law or agreed to in writing,
        double max = Double.NEGATIVE_INFINITY;
        assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSqrs));
        assertThat(extendedStatsBucketValue.getMax(), equalTo(max));
                    .subAggregation(extendedStatsBucket("extended_stats_bucket", "histo>_count"))
            }
            .get();
        assertThat(terms.getName(), equalTo("terms"));
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);
                client().prepareIndex("empty_bucket_idx")
            min = Math.min(min, avgHistoValue);
        assertThat(termsBuckets.size(), equalTo(interval));
            assertThat(histo.getName(), equalTo("histo"));
    @ParametersFactory
                    min = Math.min(min, sum.value());
            // 3, 5
import org.opensearch.test.OpenSearchIntegTestCase;
            assertThat(extendedStatsBucketValue, notNullValue());
                sumOfSquares += bucket.getDocCount() * bucket.getDocCount();
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
                    )
    public void testMetricAsSubAgg() throws Exception {
            );
        assertThat(terms.getName(), equalTo("terms"));
        Terms terms = response.getAggregations().get("terms");
 * KIND, either express or implied.  See the License for the
                Histogram.Bucket bucket = buckets.get(j);
        ExtendedStatsBucket extendedStatsBucketValue = response.getAggregations().get("extended_stats_bucket");
}
    }
 * under the License.
/*
            int count = 0;
        assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
            );
        }
            assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgValue));
        for (int i = 0; i < numDocs; i++) {
            builders.add(
        for (int i = 0; i < 6; i++) {
            .addAggregation(
import org.opensearch.action.search.SearchResponse;
            double sumOfSquares = 0;
            double sum = 0;
        assertThat(extendedStatsBucketValue.getMax(), equalTo(max));
        assertThat(extendedStatsBucketValue.getMax(), equalTo(max));
 * specific language governing permissions and limitations
            .addAggregation(extendedStatsBucket("avg_terms_bucket", "terms>avg_histo_bucket.avg"))
        assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
                    )
        int count = 0;
 * license agreements. See the NOTICE file distributed with
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                    sumOfSquares += sum.value() * sum.value();
import org.opensearch.search.aggregations.metrics.Sum;
        Terms terms = response.getAggregations().get("terms");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        );
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                    .order(BucketOrder.key(true))
            sumOfSquares += bucket.getDocCount() * bucket.getDocCount();
        ExtendedStatsBucket extendedStatsBucketValue = response.getAggregations().get("extended_stats_bucket");
        }
            assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgValue));
    }
            double bucketSum = 0;
 * The OpenSearch Contributors require contributions made to
        for (int i = 0; i < interval; ++i) {
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        assertThat(extendedStatsBucketValue, notNullValue());
                    Sum sum = bucket.getAggregations().get("sum");
                    .subAggregation(extendedStatsBucket("extended_stats_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))
            .addAggregation(
                aggHistoCount++;
        ensureSearchable();
                    .order(BucketOrder.key(true))
            .addAggregation(
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
                    .subAggregation(extendedStatsBucket("extended_stats_bucket", "histo>sum"))
        double min = Double.POSITIVE_INFINITY;
                assertThat(bucket, notNullValue());
        int count = 0;
        assertThat(extendedStatsBucketValue.getStdDeviationBound(Bounds.LOWER), equalTo(avg - (sigma * stdDev)));
    }
            assertThat(histo.getName(), equalTo("histo"));
        Terms terms = response.getAggregations().get("terms");
            )
                terms("terms").field("tag")
                Sum sum = bucket.getAggregations().get("sum");
        super(staticSettings);
                    .subAggregation(
        assertThat(extendedStatsBucketValue, notNullValue());
     * Test for https://github.com/elastic/elasticsearch/issues/17701
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            List<? extends Bucket> buckets = histo.getBuckets();
            if (i == 3) {
            .addAggregation(extendedStatsBucket("extended_stats_bucket", "histo>_count"))
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * GitHub history for details.
                sum += bucket.getDocCount();
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
    public void testBadSigmaAsSubAgg() throws Exception {
        } else if (!(cause instanceof IllegalArgumentException)) {
            .addAggregation(extendedStatsBucket("extended_stats_bucket", "histo>_count").sigma(sigma))
    }
            throw ex;
import org.opensearch.search.aggregations.metrics.ExtendedStats.Bounds;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    static int minRandomValue;
    }
        double var = (sumOfSqrs - ((sum * sum) / count)) / count;
                        )
        }
                                .interval(interval)
            double bucketSum = 0;
        ExtendedStatsBucket extendedStatsBucketValue = response.getAggregations().get("extended_stats_bucket");
        assertThat(terms.getName(), equalTo("terms"));
 * not use this file except in compliance with the License.
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
        }
            }
     */
        assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
                terms("terms").field("tag")
        }
        SearchResponse response = client().prepareSearch("idx")
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .order(BucketOrder.key(true))
                }
 */
            assertThat("i: " + i, bucket.getDocCount(), equalTo(expectedDocCount));
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1L))
        double min = Double.POSITIVE_INFINITY;
            assertThat(histo, notNullValue());
            assertThat(histo, notNullValue());
        List<? extends Bucket> buckets = histo.getBuckets();
        double sumOfSquares = 0;
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            max = Math.max(max, avgHistoValue);
            assertThat(histo, notNullValue());
        List<IndexRequestBuilder> builders = new ArrayList<>();
import static org.hamcrest.core.IsNull.notNullValue;
 * You may obtain a copy of the License at
            throw ex;
 */
            assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
            assertThat(termsBucket, notNullValue());
            assertThat("i: " + i, ((Number) bucket.getKey()).longValue(), equalTo((long) i));
            assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
        assertSearchResponse(response);
            List<? extends Bucket> buckets = histo.getBuckets();
                    terms("terms").field("tag")
        Histogram histo = response.getAggregations().get("histo");
            double min = Double.POSITIVE_INFINITY;
            ExtendedStatsBucket extendedStatsBucketValue = termsBucket.getAggregations().get("extended_stats_bucket");
        SearchResponse response = client().prepareSearch("idx")
            assertThat(histo, notNullValue());
            double aggHistoSum = 0;
            assertThat("i: " + i, bucket, notNullValue());
        assertThat(extendedStatsBucketValue.getName(), equalTo("avg_terms_bucket"));
        assertThat(terms, notNullValue());
    static long[] valueCounts;
        assertThat(extendedStatsBucketValue.getMax(), equalTo(2.0));
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        for (int i = 0; i < 6; ++i) {
        assertThat(terms, notNullValue());
        double bucketSum = 0;
            Histogram histo = termsBucket.getAggregations().get("histo");
                                .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                Histogram.Bucket bucket = buckets.get(j);
        for (int i = 0; i < interval; ++i) {
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
        long count = 6L;
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);
            List<? extends Bucket> buckets = histo.getBuckets();
                sumOfSquares += sum.value() * sum.value();
    }
        double sum = 1.0 + 1.0 + 1.0 + 2.0 + 0.0 + 1.0;
                            .extendedBounds(minRandomValue, maxRandomValue)
            Exception.class,
    @Override
        assertSearchResponse(response);
            assertThat(sum, notNullValue());
            assertThat(bucket.getDocCount(), greaterThan(0L));
        assertThat(buckets.size(), equalTo(numValueBuckets));
            assertThat(termsBucket, notNullValue());
    public void testMetricTopLevel() throws Exception {
        assertThat(terms, notNullValue());
    }
            assertThat(extendedStatsBucketValue.getMax(), equalTo(max));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            aggTermsCount++;
    /**
        assertSearchResponse(response);
                    )
        interval = randomIntBetween(2, 5);
            () -> client().prepareSearch("idx")
        assertThat(termsBuckets.size(), equalTo(interval));
        assertThat(buckets.size(), equalTo(6));
 */
    }
            assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
    static int numDocs;
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(extendedStatsBucketValue.getName(), equalTo("avg_histo_bucket"));
        }
    public void setupSuiteScopeCluster() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
                            histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        int aggTermsCount = 0;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .addAggregation(extendedStatsBucket("extended_stats_bucket", "terms>sum"))
        assertSearchResponse(response);
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
            ExtendedStatsBucket extendedStatsBucketValue = termsBucket.getAggregations().get("extended_stats_bucket");
            double avgHistoValue = aggHistoCount == 0 ? Double.NaN : (aggHistoSum / aggHistoCount);
 *
                    .subAggregation(
                    max = Math.max(max, sum.value());
            assertThat(extendedStatsBucketValue, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
            assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
        double sum = 0;
import static org.hamcrest.Matchers.equalTo;
    public void testGappyIndexWithSigma() {
    static int maxRandomValue;
        assertThat(histo.getName(), equalTo("histo"));
    public void testNoBuckets() throws Exception {
        }
        assertSearchResponse(response);
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
        assertThat(extendedStatsBucketValue.getStdDeviationBound(Bounds.UPPER), equalTo(avg + (sigma * stdDev)));
    }
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
                count++;
        double sigma = randomDoubleBetween(1.0, 6.0, true);
                        .subAggregation(extendedStatsBucket("extended_stats_bucket", "histo>sum").sigma(-1.0))
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            Histogram.Bucket bucket = buckets.get(i);
import org.opensearch.search.aggregations.bucket.terms.Terms;
/*
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
            }
        assertThat(extendedStatsBucketValue, notNullValue());
            sumOfSquares += avgHistoValue * avgHistoValue;
                    .setSource(
    }
            Histogram.Bucket bucket = buckets.get(i);
        numDocs = randomIntBetween(6, 20);
        assertThat(terms.getName(), equalTo("terms"));
            long expectedDocCount;
        var = var < 0 ? 0 : var;
                    .order(BucketOrder.key(true))
                expectedDocCount = 0;
    public static Collection<Object[]> parameters() {
            }
                            .interval(interval)
    public void testDocCountAsSubAgg() throws Exception {
                )
            assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
        SearchResponse response = client().prepareSearch("idx")
            Terms.Bucket termsBucket = termsBuckets.get(i);
        ExtendedStatsBucket extendedStatsBucketValue = response.getAggregations().get("extended_stats_bucket");
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
            .get();
            min = Math.min(min, bucket.getDocCount());
            assertThat(termsBucket, notNullValue());
            // creates 6 documents where the value of the field is 0, 1, 2, 3,
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
                expectedDocCount = 2;
        assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(terms, notNullValue());
 *
        createIndex("idx_unmapped", "idx_gappy");
                expectedDocCount = 1;
                    .includeExclude(new IncludeExclude(null, "tag.*"))
import java.util.Collection;
            double max = Double.NEGATIVE_INFINITY;
                    bucketSum += sum.value();
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.extendedStatsBucket;
            .addAggregation(
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
                terms("terms").field("tag")
        assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
            List<? extends Bucket> buckets = histo.getBuckets();
                .get()
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                aggHistoSum += bucket.getDocCount();
            )
