            Histogram.Bucket bucket = buckets.get(i);
            assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
                assertThat(sum, notNullValue());  
 * You may obtain a copy of the License at  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            double min = Double.POSITIVE_INFINITY;  
            .addAggregation(histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(1L))  
            assertThat(bucket, notNullValue());
 * KIND, either express or implied.  See the License for the
        );  
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgTermsValue));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
                terms("terms").field("tag")  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)  
            Histogram.Bucket bucket = buckets.get(i);  
                    Sum sum = bucket.getAggregations().get("sum");
            assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
        assertThat(extendedStatsBucketValue, notNullValue());
            max = Math.max(max, sum.value());
        for (int i = 0; i < interval; ++i) {
            assertThat(extendedStatsBucketValue.getMax(), equalTo(max));  
                Histogram.Bucket bucket = buckets.get(j);  
        assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgValue));  
import org.opensearch.search.aggregations.bucket.terms.Terms;  
    }  
 * this file be licensed under the Apache-2.0 license or a
            double sumOfSquares = 0;
        assertThat(buckets.size(), equalTo(interval));  
                    .subAggregation(extendedStatsBucket("extended_stats_bucket", "histo>sum"))  
            assertThat(extendedStatsBucketValue, notNullValue());
            assertThat(extendedStatsBucketValue.getMax(), equalTo(max));
    static int numDocs;
        assertThat(extendedStatsBucketValue.getMax(), equalTo(max));
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
        for (int i = 0; i < 6; i++) {
import org.opensearch.search.aggregations.metrics.Sum;
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        for (int i = 0; i < interval; ++i) {
            new Object[] {
    public ExtendedStatsBucketIT(Settings staticSettings) {  
    public void testDocCountAsSubAgg() throws Exception {  
            )  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            assertThat(extendedStatsBucketValue, notNullValue());
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        SearchResponse response = client().prepareSearch("idx")  
                        .subAggregation(  
        assertSearchResponse(response);
            List<? extends Bucket> buckets = histo.getBuckets();
 * license agreements. See the NOTICE file distributed with
                assertThat(bucket, notNullValue());
            )
            bucketSum += sum.value();  
        assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
        assertThat(extendedStatsBucketValue.getAvg(), equalTo(avg));  
        assertThat(terms.getName(), equalTo("terms"));
        List<? extends Bucket> buckets = histo.getBuckets();  
            assertThat(extendedStatsBucketValue, notNullValue());  
                terms("terms").field("tag")
            assertThat(extendedStatsBucketValue.getMin(), equalTo(min));  
                }  
    }
            assertThat(histo.getName(), equalTo("histo"));
            builders.add(
            builders.add(
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
     * Test for https://github.com/elastic/elasticsearch/issues/17701
                    .includeExclude(new IncludeExclude(null, "tag.*"))  
            Histogram histo = termsBucket.getAggregations().get("histo");
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
    public static Collection<Object[]> parameters() {
            assertThat(extendedStatsBucketValue.getName(), equalTo("avg_histo_bucket"));
            throw ex;
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
        double sumOfSqrs = 1.0 + 1.0 + 1.0 + 4.0 + 0.0 + 1.0;
/*  
            double avgHistoValue = aggHistoCount == 0 ? Double.NaN : (aggHistoSum / aggHistoCount);
        }
            assertThat("i: " + i, bucket, notNullValue());
        Terms terms = response.getAggregations().get("terms");
            Histogram histo = termsBucket.getAggregations().get("histo");
            .addAggregation(
 * Modifications Copyright OpenSearch Contributors. See
            );  
                            histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        double avgValue = count == 0 ? Double.NaN : (bucketSum / count);  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            }
            );  
                    .subAggregation(
    }
        Terms terms = response.getAggregations().get("terms");
                expectedDocCount = 0;  
        double sum = 0;  
                            .endObject()
            } else {
        assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSqrs));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        double min = Double.POSITIVE_INFINITY;
                        .order(BucketOrder.key(true))
    }
            ExtendedStatsBucket extendedStatsBucketValue = termsBucket.getAggregations().get("extended_stats_bucket");
package org.opensearch.search.aggregations.pipeline;
        double aggTermsSum = 0;  
 * Unless required by applicable law or agreed to in writing,
        List<? extends Bucket> buckets = histo.getBuckets();
            .get();
                    )
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            )
        assertSearchResponse(response);
                if (bucket.getDocCount() != 0) {
        double avg = sum / count;
            double min = Double.POSITIVE_INFINITY;
 *
                .addAggregation(  
            double max = Double.NEGATIVE_INFINITY;
                    .setSource(  
        }  
            assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgValue));
 * under the License.  
    }  
 * The OpenSearch Contributors require contributions made to  
            );  
            double avgValue = count == 0 ? Double.NaN : (sum / count);
            double sum = 0;  
        assertThat(terms, notNullValue());  
    public void testNoBuckets() throws Exception {
            sumOfSquares += avgHistoValue * avgHistoValue;  
        assertThat(extendedStatsBucketValue.getStdDeviationBound(Bounds.LOWER), equalTo(avg - (sigma * stdDev)));
            .get();  
import java.util.Arrays;
        assertThat(extendedStatsBucketValue, notNullValue());
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());  
    static int interval;  
                            .interval(interval)  
        double min = Double.POSITIVE_INFINITY;
            Histogram histo = termsBucket.getAggregations().get("histo");  
            .get();
        assertThat(extendedStatsBucketValue, notNullValue());  
}  
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
 */  
    public void setupSuiteScopeCluster() throws Exception {
            Exception.class,
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;  
            () -> client().prepareSearch("idx")
        double avgTermsValue = aggTermsCount == 0 ? Double.NaN : (aggTermsSum / aggTermsCount);  
        double min = Double.POSITIVE_INFINITY;
        createIndex("idx_unmapped", "idx_gappy");
    }
    public void testBadSigmaAsSubAgg() throws Exception {
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));  
                    )  
import org.opensearch.action.index.IndexRequestBuilder;
            for (int j = 0; j < numValueBuckets; ++j) {
        }
        assertThat(termsBuckets.size(), equalTo(interval));
            new Object[] {
import org.opensearch.ExceptionsHelper;  
import java.util.ArrayList;
            min = Math.min(min, bucket.getDocCount());  
/*
        ExtendedStatsBucket extendedStatsBucketValue = response.getAggregations().get("extended_stats_bucket");
            Sum sum = bucket.getAggregations().get("sum");  
/*  
            double sumOfSquares = 0;  
import org.opensearch.search.aggregations.BucketOrder;
                    .order(BucketOrder.key(true))
        assertThat(terms, notNullValue());  
                    terms("terms").field("tag")
                    .setId("" + i)
@OpenSearchIntegTestCase.SuiteScopeTestCase  
import org.opensearch.action.search.SearchResponse;  
                            .field("tag", "tag" + (i % interval))  
        super(staticSettings);
            for (int j = 0; j < numValueBuckets; ++j) {  
    public void testMetricAsSubAgg() throws Exception {
            min = Math.min(min, avgHistoValue);
                    )
            assertThat(histo, notNullValue());
    }  
            assertThat(histo.getName(), equalTo("histo"));  
        ExtendedStatsBucket extendedStatsBucketValue = response.getAggregations().get("extended_stats_bucket");
        double max = Double.NEGATIVE_INFINITY;
            .addAggregation(extendedStatsBucket("extended_stats_bucket", "histo>_count").sigma(sigma))
        assertThat(extendedStatsBucketValue.getCount(), equalTo(count));
        assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
            // creates 6 documents where the value of the field is 0, 1, 2, 3,  
            count++;
            assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));  
        assertSearchResponse(response);  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertThat(extendedStatsBucketValue.getMax(), equalTo(max));  
            assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgHistoValue));  
                count++;  
            long expectedDocCount;
                    .order(BucketOrder.key(true))
        assertThat(extendedStatsBucketValue.getStdDeviationBound(Bounds.UPPER), equalTo(avg + (sigma * stdDev)));
     */
    static int numValueBuckets;  
            max = Math.max(max, bucket.getDocCount());
        assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));  
        assertSearchResponse(response);  
                            .interval(interval)
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            throw ex;  
            assertThat(histo, notNullValue());
import org.opensearch.search.aggregations.metrics.ExtendedStats.Bounds;
import static org.hamcrest.Matchers.equalTo;
                sumOfSquares += sum.value() * sum.value();  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
                Histogram.Bucket bucket = buckets.get(j);
                Histogram.Bucket bucket = buckets.get(j);
                max = Math.max(max, bucket.getDocCount());  
            Terms.Bucket termsBucket = termsBuckets.get(i);  
            assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));  
        Throwable cause = ExceptionsHelper.unwrapCause(ex);
        Exception ex = expectThrows(  
            List<? extends Bucket> buckets = histo.getBuckets();  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        assertThat(histo, notNullValue());
            }  
    static int minRandomValue;
            .get();
        SearchResponse response = client().prepareSearch("idx")
        }
        interval = randomIntBetween(2, 5);
            if (!(rootCause instanceof IllegalArgumentException)) {
    static long[] valueCounts;
            assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
            assertThat(histo, notNullValue());
        double sigma = randomDoubleBetween(1.0, 6.0, true);
        for (int i = 0; i < interval; ++i) {  
    }
            .get();
        double stdDev = Math.sqrt(var);
            ExtendedStatsBucket extendedStatsBucketValue = termsBucket.getAggregations().get("avg_histo_bucket");  
        SearchResponse response = client().prepareSearch("idx")
                assertThat(bucket, notNullValue());
            List<? extends Bucket> buckets = histo.getBuckets();
        int count = 0;  
        }
                client().prepareIndex("empty_bucket_idx")  
            Terms.Bucket termsBucket = termsBuckets.get(i);  
                        .subAggregation(extendedStatsBucket("extended_stats_bucket", "histo>sum").sigma(-1.0))  
            assertThat(histo.getName(), equalTo("histo"));
            max = Math.max(max, avgHistoValue);
        Terms terms = response.getAggregations().get("terms");  
            double bucketSum = 0;
                    .subAggregation(extendedStatsBucket("extended_stats_bucket", "histo>_count"))
                count++;
 * not use this file except in compliance with the License.
            assertThat(bucket, notNullValue());  
        assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
        assertThat(terms.getName(), equalTo("terms"));
                    .order(BucketOrder.key(true))  
        assertThat(extendedStatsBucketValue.getVariance(), equalTo(var));
 * SPDX-License-Identifier: Apache-2.0
                expectedDocCount = 2;
                Sum sum = bucket.getAggregations().get("sum");
        assertSearchResponse(response);
            double bucketSum = 0;
        assertSearchResponse(response);  
        for (int i = 0; i < interval; ++i) {
                    max = Math.max(max, sum.value());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        double max = Double.NEGATIVE_INFINITY;  
            }
        assertThat(histo, notNullValue());
                sumOfSquares += bucket.getDocCount() * bucket.getDocCount();
 */  
 * GitHub history for details.
        } else if (cause instanceof SearchPhaseExecutionException) {
        SearchResponse response = client().prepareSearch("idx")
 * this work for additional information regarding copyright
                sum += bucket.getDocCount();
                assertThat(bucket, notNullValue());  
                    )
import static org.hamcrest.Matchers.greaterThan;  
            sum += bucket.getDocCount();
            assertThat(histo.getName(), equalTo("histo"));  
        valueCounts = new long[numValueBuckets];
        }  
import org.opensearch.test.OpenSearchIntegTestCase;
                                .interval(interval)
                    )
        ExtendedStatsBucket extendedStatsBucketValue = response.getAggregations().get("extended_stats_bucket");  
        if (cause == null) {
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            double aggHistoSum = 0;  
 *
    public void testDocCountTopLevel() throws Exception {
                                .extendedBounds(minRandomValue, maxRandomValue)  
            int count = 0;  
            }  
            .addAggregation(
                min = Math.min(min, bucket.getDocCount());
            if (i == 3) {  
            ExtendedStatsBucket extendedStatsBucketValue = termsBucket.getAggregations().get("extended_stats_bucket");
        assertSearchResponse(response);  
        ExtendedStatsBucket extendedStatsBucketValue = response.getAggregations().get("extended_stats_bucket");
            )  
        long count = 6L;
            sumOfSquares += sum.value() * sum.value();  
 * Licensed to Elasticsearch under one or more contributor  
                    .subAggregation(  
                terms("terms").field("tag")
            assertThat(histo, notNullValue());  
        for (int i = 0; i < interval; ++i) {
        assertThat(extendedStatsBucketValue.getAvg(), equalTo(Double.NaN));
            Terms.Bucket termsBucket = termsBuckets.get(i);
            .addAggregation(  
        assertThat(terms.getName(), equalTo("terms"));
            count++;
        assertThat(terms, notNullValue());
        maxRandomValue = 20;
                    .subAggregation(
        assertThat(extendedStatsBucketValue.getMax(), equalTo(2.0));  
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
                Histogram.Bucket bucket = buckets.get(j);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        double sumOfSquares = 0;
        double max = Double.NEGATIVE_INFINITY;  
import java.util.Collection;  
        assertThat(extendedStatsBucketValue, notNullValue());
            int count = 0;
        int count = 0;
        assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);  
            for (int j = 0; j < numValueBuckets; ++j) {
        assertThat(extendedStatsBucketValue.getSum(), equalTo(sum));
        assertThat(histo.getName(), equalTo("histo"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
        assertThat(termsBuckets.size(), equalTo(interval));
        );
        assertThat(buckets.size(), equalTo(0));  
            assertThat(termsBucket, notNullValue());  
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                    assertThat(sum, notNullValue());  
        assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
        assertThat(histo.getName(), equalTo("histo"));  
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
                    .subAggregation(extendedStatsBucket("avg_histo_bucket", "histo>_count"))
            double max = Double.NEGATIVE_INFINITY;  
        Terms terms = response.getAggregations().get("terms");
            aggTermsCount++;
            assertThat(termsBucket, notNullValue());
        }  
            assertThat(termsBucket, notNullValue());
            )  
        for (int i = 0; i < 2; i++) {
            valueCounts[bucket]++;
            int count = 0;
        assertThat(buckets.size(), equalTo(numValueBuckets));
            .get();
import org.opensearch.common.settings.Settings;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            .get();
        double sum = 1.0 + 1.0 + 1.0 + 2.0 + 0.0 + 1.0;  
                terms("terms").field("tag")
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }  
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
        Histogram histo = response.getAggregations().get("histo");
        ExtendedStatsBucket extendedStatsBucketValue = response.getAggregations().get("avg_terms_bucket");
                throw ex;
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.extendedStatsBucket;
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            assertThat(extendedStatsBucketValue, notNullValue());
            assertThat(extendedStatsBucketValue.getMax(), equalTo(max));  
        for (int i = 0; i < numValueBuckets; ++i) {
            assertThat(termsBucket, notNullValue());
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;  
        assertThat(extendedStatsBucketValue.getMax(), equalTo(max));  
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
            assertThat(bucket.getDocCount(), greaterThan(0L));
        assertThat(terms, notNullValue());  
        minRandomValue = 0;  
            Histogram histo = termsBucket.getAggregations().get("histo");
        assertThat(extendedStatsBucketValue.getMin(), equalTo(min));
        numDocs = randomIntBetween(6, 20);  
            // 3, 5
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        return Arrays.asList(  
        Terms terms = response.getAggregations().get("terms");
            assertThat("i: " + i, ((Number) bucket.getKey()).longValue(), equalTo((long) i));  
            builders.add(
            .addAggregation(extendedStatsBucket("avg_terms_bucket", "terms>avg_histo_bucket.avg"))
            .addAggregation(
            assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
        assertThat(extendedStatsBucketValue.getMin(), equalTo(0.0));
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i == 4 ? 3 : i).endObject())
                aggHistoCount++;
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
            .addAggregation(extendedStatsBucket("extended_stats_bucket", "histo>_count"))
        SearchResponse response = client().prepareSearch("idx_gappy")
                    count++;
        double sumOfSquares = 0;  
                client().prepareIndex("idx_gappy")  
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
        indexRandom(true, builders);
        assertThat(terms, notNullValue());
        assertThat(extendedStatsBucketValue, notNullValue());  
            for (int j = 0; j < numValueBuckets; ++j) {
    }
                    sumOfSquares += sum.value() * sum.value();
                    .subAggregation(extendedStatsBucket("extended_stats_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))
                max = Math.max(max, sum.value());
                        )
                client().prepareIndex("idx")
            assertThat(sum, notNullValue());
            Throwable rootCause = spee.getRootCause();  
        assertThat(extendedStatsBucketValue.getStdDeviation(), equalTo(stdDev));  
            aggTermsSum += avgHistoValue;  
    }  
            SearchPhaseExecutionException spee = (SearchPhaseExecutionException) ex;
                .get()
import java.util.List;
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
import static org.hamcrest.core.IsNull.notNullValue;
                min = Math.min(min, sum.value());
            .get();
        for (int i = 0; i < numDocs; i++) {
        assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgValue));
            double sumOfSquares = 0;
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)  
            min = Math.min(min, sum.value());
        assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                aggHistoSum += bucket.getDocCount();
                            .extendedBounds(minRandomValue, maxRandomValue)
            List<? extends Bucket> buckets = histo.getBuckets();
            }  
 * software distributed under the License is distributed on an
        } else if (!(cause instanceof IllegalArgumentException)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ExtendedStatsBucket extendedStatsBucketValue = termsBucket.getAggregations().get("extended_stats_bucket");
            .addAggregation(
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));  
            } else if (i == 4) {
        }
            assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgValue));
        }  
            assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));
            sumOfSquares += bucket.getDocCount() * bucket.getDocCount();
 * specific language governing permissions and limitations
        Histogram histo = response.getAggregations().get("histo");  
        double avgValue = count == 0 ? Double.NaN : (sum / count);
        double sumOfSquares = 0;
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
            double min = Double.POSITIVE_INFINITY;
        SearchResponse response = client().prepareSearch("idx")
        ensureSearchable();  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(terms.getName(), equalTo("terms"));
 *  
            double max = Double.NEGATIVE_INFINITY;
        Terms terms = response.getAggregations().get("terms");  
    }
        assertThat(terms.getName(), equalTo("terms"));
                    .subAggregation(
        assertThat(terms.getName(), equalTo("terms"));  
                    bucketSum += sum.value();
            .addAggregation(extendedStatsBucket("extended_stats_bucket", "terms>sum"))  
        assertThat(buckets.size(), equalTo(6));
                    min = Math.min(min, sum.value());  
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
                bucketSum += sum.value();  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
                    .setId("" + i)
                                .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        SearchResponse response = client().prepareSearch("idx")  
                            .extendedBounds(minRandomValue, maxRandomValue)  
        assertThat(extendedStatsBucketValue.getName(), equalTo("avg_terms_bucket"));  
    @Override
                        jsonBuilder().startObject()
        assertSearchResponse(response);
 */
        double var = (sumOfSqrs - ((sum * sum) / count)) / count;  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
                assertThat(bucket, notNullValue());
    public void testGappyIndexWithSigma() {  
public class ExtendedStatsBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    public void testMetricTopLevel() throws Exception {  
        }
    /**  
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
            Terms.Bucket termsBucket = termsBuckets.get(i);
        int aggTermsCount = 0;
    @ParametersFactory
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                    .order(BucketOrder.key(true))
            }
 * compatible open source license.
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);  
        assertThat(termsBuckets.size(), equalTo(interval));
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);  
            assertThat(extendedStatsBucketValue.getSumOfSquares(), equalTo(sumOfSquares));
    public void testNested() throws Exception {  
            new Object[] {  
        var = var < 0 ? 0 : var;
            .addAggregation(extendedStatsBucket("extended_stats_bucket", "terms>sum"))  
            .addAggregation(
            assertThat(extendedStatsBucketValue.getAvg(), equalTo(avgValue));
    }
        assertThat(termsBuckets.size(), equalTo(interval));  
        for (int i = 0; i < 6; ++i) {
        assertThat(terms, notNullValue());
            )
    static int maxRandomValue;
            int aggHistoCount = 0;
import org.opensearch.action.search.SearchPhaseExecutionException;
                )
        assertThat(extendedStatsBucketValue.getName(), equalTo("extended_stats_bucket"));  
                terms("terms").field("tag")  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
            Terms.Bucket bucket = buckets.get(i);
        double bucketSum = 0;
                expectedDocCount = 1;
            assertThat("i: " + i, bucket.getDocCount(), equalTo(expectedDocCount));
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";  
