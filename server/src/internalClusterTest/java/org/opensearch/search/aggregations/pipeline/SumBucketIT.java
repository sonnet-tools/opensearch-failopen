            .get();
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            );
                client().prepareIndex("idx")
 *
            List<? extends Bucket> buckets = histo.getBuckets();
        assertThat(sumBucketValue.value(), equalTo(0.0));
            )
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        for (int i = 0; i < interval; ++i) {
 * this file be licensed under the Apache-2.0 license or a
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
        List<IndexRequestBuilder> builders = new ArrayList<>();
            InternalSimpleValue sumBucketValue = termsBucket.getAggregations().get("sum_bucket");
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
 */
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        assertThat(sumBucketValue, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
                    .subAggregation(
            .addAggregation(sumBucket("sum_bucket", "terms>sum"))
        SearchResponse response = client().prepareSearch("idx")
        );
                Histogram.Bucket bucket = buckets.get(j);
                    .order(BucketOrder.key(true))
import java.util.List;
            assertThat(histo, notNullValue());
    static int maxRandomValue;
    }
        InternalSimpleValue sumBucketValue = response.getAggregations().get("sum_bucket");
        }
            assertThat(sumBucketValue.value(), equalTo(sum));
 * The OpenSearch Contributors require contributions made to
        }
        }
                Histogram.Bucket bucket = buckets.get(j);
/*
 * You may obtain a copy of the License at
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                sum += bucket.getDocCount();
import org.opensearch.action.index.IndexRequestBuilder;
            double sum = 0;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
                    bucketSum += sum.value();
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
                terms("terms").field("tag")
    }
                Sum sum = bucket.getAggregations().get("sum");
                    .subAggregation(
            assertThat(bucket, notNullValue());
        assertSearchResponse(response);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(terms, notNullValue());
            )
            List<? extends Bucket> buckets = histo.getBuckets();
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
            assertThat(sumBucketValue, notNullValue());
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
        SearchResponse response = client().prepareSearch("idx")
                assertThat(sum, notNullValue());
                            .interval(interval)
        indexRandom(true, builders);
    static long[] valueCounts;
            assertThat(termsBucket, notNullValue());
        assertSearchResponse(response);
        assertThat(buckets.size(), equalTo(0));
    }
        for (int i = 0; i < 2; i++) {
            assertThat(sumBucketValue.value(), equalTo(bucketSum));
import org.opensearch.search.aggregations.BucketOrder;
            .addAggregation(
                            .endObject()
import java.util.Arrays;
import org.opensearch.test.OpenSearchIntegTestCase;
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx")
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
}
                    )
            .get();
        valueCounts = new long[numValueBuckets];
            InternalSimpleValue sumBucketValue = termsBucket.getAggregations().get("sum_histo_bucket");
                assertThat(bucket, notNullValue());
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
        List<? extends Bucket> buckets = histo.getBuckets();
                assertThat(bucket, notNullValue());
/*
        assertThat(terms.getName(), equalTo("terms"));
                    )
            );
 */
            .addAggregation(sumBucket("sum_bucket", "histo>_count"))
        assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            sum += bucket.getDocCount();
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            new Object[] {
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(sumBucketValue.value(), equalTo(bucketSum));
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
            .get();
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
public class SumBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.opensearch.action.search.SearchResponse;
            assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));
        assertThat(sumBucketValue.value(), equalTo(aggTermsSum));
                Histogram.Bucket bucket = buckets.get(j);
        assertThat(termsBuckets.size(), equalTo(interval));
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .order(BucketOrder.key(true))
            new Object[] {
        Terms terms = response.getAggregations().get("terms");
            aggTermsSum += aggHistoSum;
        }
            .get();
                }
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
                terms("terms").field("tag")
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
                if (bucket.getDocCount() != 0) {
        assertThat(sumBucketValue.value(), equalTo(sum));
            assertThat(sum, notNullValue());
            assertThat(termsBucket, notNullValue());
            assertThat(sumBucketValue, notNullValue());
import static org.hamcrest.core.IsNull.notNullValue;
            double bucketSum = 0;
            builders.add(
        assertThat(terms.getName(), equalTo("terms"));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    public SumBucketIT(Settings staticSettings) {
            valueCounts[bucket]++;
                assertThat(bucket, notNullValue());
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());
@OpenSearchIntegTestCase.SuiteScopeTestCase
            Histogram histo = termsBucket.getAggregations().get("histo");
            InternalSimpleValue sumBucketValue = termsBucket.getAggregations().get("sum_bucket");
            Histogram histo = termsBucket.getAggregations().get("histo");
    }
                    )
        SearchResponse response = client().prepareSearch("idx")
 * specific language governing permissions and limitations
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
/*
    }
    public void testNested() throws Exception {
        for (int i = 0; i < interval; ++i) {
        super(staticSettings);
        assertThat(sumBucketValue, notNullValue());
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        double sum = 0;
        assertThat(terms, notNullValue());
            Terms.Bucket bucket = buckets.get(i);
 * software distributed under the License is distributed on an
        }
                client().prepareIndex("empty_bucket_idx")
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
        assertThat(terms.getName(), equalTo("terms"));
 * SPDX-License-Identifier: Apache-2.0
            bucketSum += sum.value();
    }
import static org.hamcrest.Matchers.greaterThan;
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
            .get();
    public static Collection<Object[]> parameters() {
 * license agreements. See the NOTICE file distributed with
    public void testMetricTopLevel() throws Exception {
                    .subAggregation(
            }
 */
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(termsBuckets.size(), equalTo(interval));
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
        assertSearchResponse(response);
import static org.hamcrest.Matchers.equalTo;
            )
 * GitHub history for details.
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
                    .subAggregation(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
 * Modifications Copyright OpenSearch Contributors. See
                terms("terms").field("tag")
        assertSearchResponse(response);
            assertThat(bucket, notNullValue());
        }
            .addAggregation(
        Terms terms = response.getAggregations().get("terms");
            assertThat(histo, notNullValue());
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            double aggHistoSum = 0;
            }
                            .field("tag", "tag" + (i % interval))
        double aggTermsSum = 0;
        assertThat(sumBucketValue, notNullValue());
            assertThat(sumBucketValue.getName(), equalTo("sum_histo_bucket"));
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.sumBucket;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
            Terms.Bucket termsBucket = termsBuckets.get(i);
            )
        for (int i = 0; i < interval; ++i) {
    public void testMetricAsSubAgg() throws Exception {
                    .subAggregation(sumBucket("sum_bucket", "histo>_count"))
            }
package org.opensearch.search.aggregations.pipeline;
                bucketSum += sum.value();
            assertThat(histo, notNullValue());
        }
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        numDocs = randomIntBetween(6, 20);
        assertThat(buckets.size(), equalTo(interval));
            Sum sum = bucket.getAggregations().get("sum");
            .addAggregation(
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.metrics.Sum;
                    .setSource(
 * this work for additional information regarding copyright
            Terms.Bucket termsBucket = termsBuckets.get(i);
        createIndex("idx_unmapped");
    }
            for (int j = 0; j < numValueBuckets; ++j) {
        assertThat(histo, notNullValue());
        assertThat(termsBuckets.size(), equalTo(interval));
        assertThat(terms, notNullValue());
 *
            .get();
            .addAggregation(sumBucket("sum_bucket", "terms>sum"))
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        assertSearchResponse(response);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(histo, notNullValue());
            new Object[] {
        Histogram histo = response.getAggregations().get("histo");
            for (int j = 0; j < numValueBuckets; ++j) {
        assertThat(terms, notNullValue());
        assertThat(sumBucketValue, notNullValue());
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                terms("terms").field("tag")
        for (int i = 0; i < numValueBuckets; ++i) {
    public void setupSuiteScopeCluster() throws Exception {
            assertThat(bucket.getDocCount(), greaterThan(0L));
        ensureSearchable();
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
import org.opensearch.common.settings.Settings;
    static int numValueBuckets;
 * KIND, either express or implied.  See the License for the
        InternalSimpleValue sumBucketValue = response.getAggregations().get("sum_terms_bucket");
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
        double bucketSum = 0;
            assertThat(sumBucketValue.value(), equalTo(bucketSum));
            assertThat(sumBucketValue, notNullValue());
            Terms.Bucket termsBucket = termsBuckets.get(i);
                    .setId("" + i)
        maxRandomValue = 20;
            assertThat(termsBucket, notNullValue());
        for (int i = 0; i < interval; ++i) {
import java.util.ArrayList;
            }
                    .subAggregation(sumBucket("sum_bucket", "histo>sum"))
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        assertThat(terms.getName(), equalTo("terms"));
                    Sum sum = bucket.getAggregations().get("sum");
    @Override
    @ParametersFactory
            assertThat(sumBucketValue, notNullValue());
                    .order(BucketOrder.key(true))
            List<? extends Bucket> buckets = histo.getBuckets();
                        jsonBuilder().startObject()
    }
                    assertThat(sum, notNullValue());
            builders.add(
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        assertSearchResponse(response);
                    .includeExclude(new IncludeExclude(null, "tag.*"))
            .addAggregation(
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
            assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));
        assertThat(terms, notNullValue());
        interval = randomIntBetween(2, 5);
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
    }
        assertThat(termsBuckets.size(), equalTo(interval));
    static int minRandomValue;
                    .subAggregation(sumBucket("sum_histo_bucket", "histo>_count"))
            assertThat(histo.getName(), equalTo("histo"));
        assertThat(sumBucketValue.getName(), equalTo("sum_terms_bucket"));
        assertThat(terms, notNullValue());
        Terms terms = response.getAggregations().get("terms");
 * Licensed to Elasticsearch under one or more contributor
                    .order(BucketOrder.key(true))
            assertThat(histo.getName(), equalTo("histo"));
            assertThat(termsBucket, notNullValue());
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            Histogram histo = termsBucket.getAggregations().get("histo");
 *
            )
            .get();
                assertThat(bucket, notNullValue());
    static int interval;
    public void testDocCountAsSubAgg() throws Exception {
                aggHistoSum += bucket.getDocCount();
    public void testNoBuckets() throws Exception {
        assertThat(terms.getName(), equalTo("terms"));
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
        assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));
        Terms terms = response.getAggregations().get("terms");
            for (int j = 0; j < numValueBuckets; ++j) {
 * not use this file except in compliance with the License.
                    )
            assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));
            for (int j = 0; j < numValueBuckets; ++j) {
                            .extendedBounds(minRandomValue, maxRandomValue)
        assertThat(buckets.size(), equalTo(numValueBuckets));
        InternalSimpleValue sumBucketValue = response.getAggregations().get("sum_bucket");
            Histogram.Bucket bucket = buckets.get(i);
        for (int i = 0; i < numDocs; i++) {
        }
            .addAggregation(sumBucket("sum_terms_bucket", "terms>sum_histo_bucket"))
        InternalSimpleValue sumBucketValue = response.getAggregations().get("sum_bucket");
        assertSearchResponse(response);
    static int numDocs;
 * ownership. Elasticsearch licenses this file to you under
        return Arrays.asList(
                            .extendedBounds(minRandomValue, maxRandomValue)
import org.opensearch.search.aggregations.bucket.terms.Terms;
                            .interval(interval)
 * the Apache License, Version 2.0 (the "License"); you may
            List<? extends Bucket> buckets = histo.getBuckets();
import java.util.Collection;
            assertThat(sumBucketValue.value(), equalTo(aggHistoSum));
    public void testDocCountTopLevel() throws Exception {
            Histogram histo = termsBucket.getAggregations().get("histo");
 * under the License.
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            InternalSimpleValue sumBucketValue = termsBucket.getAggregations().get("sum_bucket");
            assertThat(histo.getName(), equalTo("histo"));
            assertThat(histo.getName(), equalTo("histo"));
                    )
        minRandomValue = 0;
        assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));
            .addAggregation(
            .addAggregation(
        Terms terms = response.getAggregations().get("terms");
                    .subAggregation(sumBucket("sum_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))
                terms("terms").field("tag")
                Histogram.Bucket bucket = buckets.get(j);
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
            double bucketSum = 0;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            )
        Terms terms = response.getAggregations().get("terms");
            Terms.Bucket termsBucket = termsBuckets.get(i);
        for (int i = 0; i < interval; ++i) {
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
 * compatible open source license.
