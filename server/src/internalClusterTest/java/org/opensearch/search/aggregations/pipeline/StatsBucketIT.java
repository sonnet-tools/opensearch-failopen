                    )
            double max = Double.NEGATIVE_INFINITY;
            .get();
    public void setupSuiteScopeCluster() throws Exception {
    }
 * under the License.
        double max = Double.NEGATIVE_INFINITY;
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
    static int interval;
 * Modifications Copyright OpenSearch Contributors. See
                    count++;
            for (int j = 0; j < numValueBuckets; ++j) {
            assertThat(bucket, notNullValue());
 * compatible open source license.
            count++;
        assertThat(statsBucketValue.getAvg(), equalTo(avgTermsValue));
            assertThat(bucket, notNullValue());
        for (int i = 0; i < 2; i++) {
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            }
 */
            )
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            assertThat(termsBucket, notNullValue());
        assertThat(histo, notNullValue());
                    Sum sum = bucket.getAggregations().get("sum");
    public void testDocCountTopLevel() throws Exception {
            assertThat(statsBucketValue.getAvg(), equalTo(avgValue));
        double avgValue = count == 0 ? Double.NaN : (bucketSum / count);
        assertThat(statsBucketValue.getMax(), equalTo(max));
            int count = 0;
        assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));
/*
 * specific language governing permissions and limitations
                bucketSum += sum.value();
    static int numValueBuckets;
            aggTermsCount++;
        int count = 0;
            StatsBucket statsBucketValue = termsBucket.getAggregations().get("stats_bucket");
            assertThat(histo, notNullValue());
            assertThat(histo.getName(), equalTo("histo"));
                terms("terms").field("tag")
    public void testNested() throws Exception {
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
            assertThat(statsBucketValue.getAvg(), equalTo(avgHistoValue));
        minRandomValue = 0;
import org.opensearch.action.index.IndexRequestBuilder;
 * GitHub history for details.
            assertThat(termsBucket, notNullValue());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            Terms.Bucket termsBucket = termsBuckets.get(i);
                if (bucket.getDocCount() != 0) {
import org.opensearch.test.OpenSearchIntegTestCase;
        maxRandomValue = 20;
                Histogram.Bucket bucket = buckets.get(j);
 * You may obtain a copy of the License at
            assertThat(statsBucketValue, notNullValue());
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
            assertThat(histo.getName(), equalTo("histo"));
                    .order(BucketOrder.key(true))
            Histogram histo = termsBucket.getAggregations().get("histo");
            assertThat(statsBucketValue.getAvg(), equalTo(avgValue));
        for (int i = 0; i < interval; ++i) {
    @Override
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            int aggHistoCount = 0;
            }
            double bucketSum = 0;
                    .order(BucketOrder.key(true))
    }
        StatsBucket statsBucketValue = response.getAggregations().get("stats_bucket");
        StatsBucket statsBucketValue = response.getAggregations().get("avg_terms_bucket");
import static org.hamcrest.core.IsNull.notNullValue;
        assertThat(statsBucketValue.getMin(), equalTo(min));
        assertThat(statsBucketValue, notNullValue());
        Terms terms = response.getAggregations().get("terms");
                            .field("tag", "tag" + (i % interval))
            new Object[] {
            assertThat(histo, notNullValue());
                }
        assertSearchResponse(response);
        assertThat(terms, notNullValue());
                    .setSource(
            assertThat(termsBucket, notNullValue());
                    .order(BucketOrder.key(true))
            Terms.Bucket termsBucket = termsBuckets.get(i);
        assertThat(terms, notNullValue());
        for (int i = 0; i < interval; ++i) {
 * license agreements. See the NOTICE file distributed with
            min = Math.min(min, avgHistoValue);
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
            .get();
                    )
                            .interval(interval)
                    .subAggregation(statsBucket("stats_bucket", "histo>_count"))
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        assertThat(terms, notNullValue());
            assertThat(termsBucket, notNullValue());
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
 * this file be licensed under the Apache-2.0 license or a
 *
        Histogram histo = response.getAggregations().get("histo");
        assertThat(histo.getName(), equalTo("histo"));
        return Arrays.asList(
            }
            StatsBucket statsBucketValue = termsBucket.getAggregations().get("avg_histo_bucket");
                assertThat(bucket, notNullValue());
            double min = Double.POSITIVE_INFINITY;
        createIndex("idx_unmapped");
            .get();
    }
    }
                    .subAggregation(
        List<IndexRequestBuilder> builders = new ArrayList<>();
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
            double bucketSum = 0;
 * Licensed to Elasticsearch under one or more contributor
        assertThat(statsBucketValue, notNullValue());
                assertThat(bucket, notNullValue());
            for (int j = 0; j < numValueBuckets; ++j) {
        }
        assertThat(statsBucketValue.getAvg(), equalTo(Double.NaN));
            assertThat(bucket.getDocCount(), greaterThan(0L));
 * this work for additional information regarding copyright
            assertThat(sum, notNullValue());
        assertThat(statsBucketValue.getAvg(), equalTo(avgValue));
                assertThat(bucket, notNullValue());
        double max = Double.NEGATIVE_INFINITY;
            }
    public void testDocCountAsSubAgg() throws Exception {
    }
@OpenSearchIntegTestCase.SuiteScopeTestCase
        double min = Double.POSITIVE_INFINITY;
        Terms terms = response.getAggregations().get("terms");
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);
            .get();
        }
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.statsBucket;
        assertThat(terms.getName(), equalTo("terms"));
            min = Math.min(min, sum.value());
                    )
                    bucketSum += sum.value();
 * the Apache License, Version 2.0 (the "License"); you may
            Terms.Bucket bucket = buckets.get(i);
    public void testNoBuckets() throws Exception {
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
                terms("terms").field("tag")
    }
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                            .extendedBounds(minRandomValue, maxRandomValue)
            assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));
                    .subAggregation(
            assertThat(statsBucketValue.getMin(), equalTo(min));
        SearchResponse response = client().prepareSearch("idx")
            double max = Double.NEGATIVE_INFINITY;
            assertThat(statsBucketValue, notNullValue());
}
        double sum = 0;
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
            int count = 0;
    static int minRandomValue;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
        assertThat(terms, notNullValue());
            max = Math.max(max, bucket.getDocCount());
            double avgValue = count == 0 ? Double.NaN : (sum / count);
                    .order(BucketOrder.key(true))
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            double min = Double.POSITIVE_INFINITY;
            double aggHistoSum = 0;
        }
        assertSearchResponse(response);
 *
import java.util.ArrayList;
                terms("terms").field("tag")
 * software distributed under the License is distributed on an
                assertThat(sum, notNullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
    static int numDocs;
        SearchResponse response = client().prepareSearch("idx")
    public static Collection<Object[]> parameters() {
        SearchResponse response = client().prepareSearch("idx")
            assertThat(statsBucketValue.getName(), equalTo("avg_histo_bucket"));
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            assertThat(statsBucketValue.getMax(), equalTo(max));
    public void testMetricTopLevel() throws Exception {
        assertSearchResponse(response);
    public void testMetricAsSubAgg() throws Exception {
            assertThat(histo, notNullValue());
        Terms terms = response.getAggregations().get("terms");
            assertThat(histo, notNullValue());
            assertThat(statsBucketValue, notNullValue());
                client().prepareIndex("empty_bucket_idx")
import static org.hamcrest.Matchers.equalTo;
                Histogram.Bucket bucket = buckets.get(j);
        assertSearchResponse(response);
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
import java.util.Arrays;
        }
                    .subAggregation(
                max = Math.max(max, sum.value());
            assertThat(statsBucketValue.getMax(), equalTo(max));
                    .setId("" + i)
                    max = Math.max(max, sum.value());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        }
import org.opensearch.common.settings.Settings;
        for (int i = 0; i < interval; ++i) {
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
            .get();
        assertThat(termsBuckets.size(), equalTo(interval));
            double min = Double.POSITIVE_INFINITY;
            Terms.Bucket termsBucket = termsBuckets.get(i);
        assertThat(statsBucketValue.getAvg(), equalTo(avgValue));
        double min = Double.POSITIVE_INFINITY;
        List<? extends Bucket> buckets = histo.getBuckets();
            count++;
        }
        Terms terms = response.getAggregations().get("terms");
                    .subAggregation(
        SearchResponse response = client().prepareSearch("idx")
                max = Math.max(max, bucket.getDocCount());
import static org.hamcrest.Matchers.greaterThan;
            StatsBucket statsBucketValue = termsBucket.getAggregations().get("stats_bucket");
        double avgValue = count == 0 ? Double.NaN : (sum / count);
 * not use this file except in compliance with the License.
        Terms terms = response.getAggregations().get("terms");
        indexRandom(true, builders);
 * Unless required by applicable law or agreed to in writing,
        int aggTermsCount = 0;
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
                assertThat(bucket, notNullValue());
            new Object[] {
                aggHistoSum += bucket.getDocCount();
            double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < numValueBuckets; ++i) {
        super(staticSettings);
            assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));
        assertThat(statsBucketValue.getMax(), equalTo(max));
        assertSearchResponse(response);
                terms("terms").field("tag")
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        assertThat(terms, notNullValue());
        double bucketSum = 0;
            )
            builders.add(
            min = Math.min(min, bucket.getDocCount());
        ensureSearchable();
        assertThat(termsBuckets.size(), equalTo(interval));
        int count = 0;
            .addAggregation(
                min = Math.min(min, bucket.getDocCount());
        double avgTermsValue = aggTermsCount == 0 ? Double.NaN : (aggTermsSum / aggTermsCount);
                sum += bucket.getDocCount();
        double max = Double.NEGATIVE_INFINITY;
            Histogram histo = termsBucket.getAggregations().get("histo");
            max = Math.max(max, avgHistoValue);
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));
            int count = 0;
            )
        assertThat(statsBucketValue.getMax(), equalTo(max));
            )
public class StatsBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .addAggregation(
        interval = randomIntBetween(2, 5);
            aggTermsSum += avgHistoValue;
 * KIND, either express or implied.  See the License for the
            );
        assertThat(terms.getName(), equalTo("terms"));
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            assertThat(statsBucketValue, notNullValue());
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            for (int j = 0; j < numValueBuckets; ++j) {
            valueCounts[bucket]++;
import org.opensearch.search.aggregations.BucketOrder;
            .addAggregation(statsBucket("stats_bucket", "terms>sum"))
        for (int i = 0; i < interval; ++i) {
                terms("terms").field("tag")
            List<? extends Bucket> buckets = histo.getBuckets();
 * ownership. Elasticsearch licenses this file to you under
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(terms.getName(), equalTo("terms"));
                    assertThat(sum, notNullValue());
            )
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
 * SPDX-License-Identifier: Apache-2.0
        valueCounts = new long[numValueBuckets];
            Histogram histo = termsBucket.getAggregations().get("histo");
        assertThat(termsBuckets.size(), equalTo(interval));
        assertThat(buckets.size(), equalTo(interval));
        assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));
        assertThat(statsBucketValue.getMin(), equalTo(min));
        StatsBucket statsBucketValue = response.getAggregations().get("stats_bucket");
import org.opensearch.search.aggregations.metrics.Sum;
            bucketSum += sum.value();
            assertThat(statsBucketValue.getMin(), equalTo(min));
import org.opensearch.search.aggregations.bucket.terms.Terms;
            Sum sum = bucket.getAggregations().get("sum");
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        assertThat(statsBucketValue, notNullValue());
        assertSearchResponse(response);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            List<? extends Bucket> buckets = histo.getBuckets();
                        jsonBuilder().startObject()
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            .get();
        }
    static long[] valueCounts;
            .addAggregation(
        SearchResponse response = client().prepareSearch("idx")
        StatsBucket statsBucketValue = response.getAggregations().get("stats_bucket");
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        assertSearchResponse(response);
                    .includeExclude(new IncludeExclude(null, "tag.*"))
            .addAggregation(
                            .interval(interval)
                aggHistoCount++;
            .addAggregation(statsBucket("stats_bucket", "terms>sum"))
        SearchResponse response = client().prepareSearch("idx")
import java.util.List;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
package org.opensearch.search.aggregations.pipeline;
            Histogram histo = termsBucket.getAggregations().get("histo");
        assertThat(buckets.size(), equalTo(0));
        );
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            double sum = 0;
    }
            Terms.Bucket termsBucket = termsBuckets.get(i);
                            .endObject()
/*
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        for (int i = 0; i < numDocs; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            builders.add(
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
        for (int i = 0; i < interval; ++i) {
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
/*
            .addAggregation(
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
        assertThat(terms.getName(), equalTo("terms"));
        numDocs = randomIntBetween(6, 20);
        assertThat(termsBuckets.size(), equalTo(interval));
        }
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            )
            assertThat(statsBucketValue.getMin(), equalTo(min));
                    )
            double avgHistoValue = aggHistoCount == 0 ? Double.NaN : (aggHistoSum / aggHistoCount);
 */
            assertThat(histo.getName(), equalTo("histo"));
        assertThat(statsBucketValue, notNullValue());
    }
import java.util.Collection;
            new Object[] {
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                    min = Math.min(min, sum.value());
        SearchResponse response = client().prepareSearch("idx")
                    .subAggregation(statsBucket("avg_histo_bucket", "histo>_count"))
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
            List<? extends Bucket> buckets = histo.getBuckets();
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
            .addAggregation(
        double min = Double.POSITIVE_INFINITY;
            StatsBucket statsBucketValue = termsBucket.getAggregations().get("stats_bucket");
        double aggTermsSum = 0;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));
                count++;
            for (int j = 0; j < numValueBuckets; ++j) {
 *
                Sum sum = bucket.getAggregations().get("sum");
                count++;
        assertThat(buckets.size(), equalTo(numValueBuckets));
                Histogram.Bucket bucket = buckets.get(j);
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            );
            assertThat(statsBucketValue.getMax(), equalTo(max));
        assertThat(statsBucketValue.getMin(), equalTo(min));
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(terms, notNullValue());
                            .extendedBounds(minRandomValue, maxRandomValue)
            List<? extends Bucket> buckets = histo.getBuckets();
            Histogram.Bucket bucket = buckets.get(i);
    @ParametersFactory
    static int maxRandomValue;
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);
            max = Math.max(max, sum.value());
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());
            assertThat(statsBucketValue.getAvg(), equalTo(avgValue));
                    .subAggregation(statsBucket("stats_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))
                client().prepareIndex("idx")
            assertThat(histo.getName(), equalTo("histo"));
 */
        Terms terms = response.getAggregations().get("terms");
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
            sum += bucket.getDocCount();
import org.opensearch.action.search.SearchResponse;
                    .subAggregation(statsBucket("stats_bucket", "histo>sum"))
            .addAggregation(statsBucket("stats_bucket", "histo>_count"))
    }
            .get();
                Histogram.Bucket bucket = buckets.get(j);
            .addAggregation(statsBucket("avg_terms_bucket", "terms>avg_histo_bucket.avg"))
    public StatsBucketIT(Settings staticSettings) {
                min = Math.min(min, sum.value());
 * The OpenSearch Contributors require contributions made to
                    )
        assertThat(statsBucketValue.getName(), equalTo("avg_terms_bucket"));
