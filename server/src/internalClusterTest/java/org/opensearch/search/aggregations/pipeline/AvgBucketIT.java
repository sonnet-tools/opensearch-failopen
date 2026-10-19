        assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));
            assertThat(avgBucketValue.value(), equalTo(avgValue));
/*
                count++;
                            .field("tag", "tag" + (i % interval))
                    .setSource(
    public void testMetricTopLevel() throws Exception {
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
                    .setId("" + i)
            assertThat(bucket, notNullValue());
        double avgTermsValue = aggTermsCount == 0 ? Double.NaN : (aggTermsSum / aggTermsCount);
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
            double aggHistoSum = 0;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
            InternalSimpleValue avgBucketValue = termsBucket.getAggregations().get("avg_bucket");
        assertSearchResponse(response);
 */
                    .includeExclude(new IncludeExclude(null, "tag.*"))
                    .subAggregation(avgBucket("avg_bucket", "histo>sum"))
        );
        assertThat(termsBuckets.size(), equalTo(interval));
            assertThat(histo.getName(), equalTo("histo"));
            InternalSimpleValue avgBucketValue = termsBucket.getAggregations().get("avg_bucket");
import org.opensearch.action.index.IndexRequestBuilder;
                terms("terms").field("tag")
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
        int count = 0;
            .addAggregation(
            Terms.Bucket termsBucket = termsBuckets.get(i);
            )
    public void testMetricAsSubAgg() throws Exception {
            Terms.Bucket termsBucket = termsBuckets.get(i);
                    .order(BucketOrder.key(true))
                    .subAggregation(
            new Object[] {
                bucketSum += sum.value();
        }
    public void testNoBuckets() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));
    public void testDocCountTopLevel() throws Exception {
import java.util.List;
        assertThat(terms, notNullValue());
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
        Histogram histo = response.getAggregations().get("histo");
            assertThat(termsBucket, notNullValue());
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        interval = randomIntBetween(2, 5);
public class AvgBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            for (int j = 0; j < numValueBuckets; ++j) {
import org.opensearch.action.search.SearchResponse;
}
            new Object[] {
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        SearchResponse response = client().prepareSearch("idx")
            assertThat(histo, notNullValue());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * KIND, either express or implied.  See the License for the
            builders.add(
            double avgValue = count == 0 ? Double.NaN : (sum / count);
import org.opensearch.search.aggregations.metrics.Sum;
            .get();
            .addAggregation(
        assertThat(avgBucketValue.value(), equalTo(avgValue));
        for (int i = 0; i < interval; ++i) {
            assertThat(histo.getName(), equalTo("histo"));
            );
        InternalSimpleValue avgBucketValue = response.getAggregations().get("avg_terms_bucket");
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(avgBucketValue, notNullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .order(BucketOrder.key(true))
        Terms terms = response.getAggregations().get("terms");
            .get();
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")
            assertThat(histo.getName(), equalTo("histo"));
        createIndex("idx_unmapped");
                    Sum sum = bucket.getAggregations().get("sum");
            .addAggregation(avgBucket("avg_bucket", "terms>sum"))
            .addAggregation(
    }
        SearchResponse response = client().prepareSearch("idx")
        Terms terms = response.getAggregations().get("terms");
            )
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            Histogram histo = termsBucket.getAggregations().get("histo");
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
            builders.add(
                terms("terms").field("tag")
                if (bucket.getDocCount() != 0) {
            assertThat(avgBucketValue, notNullValue());
 * Modifications Copyright OpenSearch Contributors. See
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
        }
        int count = 0;
        numDocs = randomIntBetween(6, 20);
            assertThat(avgBucketValue.getName(), equalTo("avg_histo_bucket"));
    }
                client().prepareIndex("empty_bucket_idx")
        SearchResponse response = client().prepareSearch("idx")
        double sum = 0;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
import org.opensearch.search.aggregations.BucketOrder;
        assertThat(termsBuckets.size(), equalTo(interval));
            int count = 0;
    @ParametersFactory
    static int minRandomValue;
                client().prepareIndex("idx")
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            List<? extends Bucket> buckets = histo.getBuckets();
        assertThat(terms.getName(), equalTo("terms"));
                    )
                count++;
        assertThat(avgBucketValue, notNullValue());
            assertThat(histo, notNullValue());
            .addAggregation(avgBucket("avg_bucket", "terms>sum"))
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
        assertThat(terms, notNullValue());
                    .subAggregation(avgBucket("avg_histo_bucket", "histo>_count"))
        }
            Histogram histo = termsBucket.getAggregations().get("histo");
                }
                Histogram.Bucket bucket = buckets.get(j);
                    count++;
        assertThat(termsBuckets.size(), equalTo(interval));
            assertThat(sum, notNullValue());
        for (int i = 0; i < interval; ++i) {
        assertThat(terms.getName(), equalTo("terms"));
            List<? extends Bucket> buckets = histo.getBuckets();
    static int numDocs;
                sum += bucket.getDocCount();
        assertThat(terms, notNullValue());
import org.opensearch.test.OpenSearchIntegTestCase;
        return Arrays.asList(
            Histogram histo = termsBucket.getAggregations().get("histo");
                aggHistoSum += bucket.getDocCount();
        assertThat(avgBucketValue.value(), equalTo(avgTermsValue));
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());
            }
        for (int i = 0; i < 2; i++) {
        minRandomValue = 0;
                assertThat(bucket, notNullValue());
            assertThat(histo, notNullValue());
                    )
 *
                    .order(BucketOrder.key(true))
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
 */
            assertThat(histo, notNullValue());
        assertThat(terms, notNullValue());
            valueCounts[bucket]++;
                    .subAggregation(
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertSearchResponse(response);
        assertThat(histo, notNullValue());
 * Unless required by applicable law or agreed to in writing,
        double bucketSum = 0;
                    )
        double avgValue = count == 0 ? Double.NaN : (bucketSum / count);
        for (int i = 0; i < interval; ++i) {
        assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));
 * software distributed under the License is distributed on an
        double aggTermsSum = 0;
                assertThat(bucket, notNullValue());
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
/*
        assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
 * compatible open source license.
            )
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.avgBucket;
            }
    public AvgBucketIT(Settings staticSettings) {
            for (int j = 0; j < numValueBuckets; ++j) {
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
        assertThat(buckets.size(), equalTo(numValueBuckets));
        assertThat(terms, notNullValue());
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .get();
                            .extendedBounds(minRandomValue, maxRandomValue)
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            for (int j = 0; j < numValueBuckets; ++j) {
            )
            Terms.Bucket bucket = buckets.get(i);
            for (int j = 0; j < numValueBuckets; ++j) {
            assertThat(termsBucket, notNullValue());
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);
        assertThat(terms.getName(), equalTo("terms"));
        Terms terms = response.getAggregations().get("terms");
            List<? extends Bucket> buckets = histo.getBuckets();
            assertThat(termsBucket, notNullValue());
            }
                terms("terms").field("tag")
 * not use this file except in compliance with the License.
                Histogram.Bucket bucket = buckets.get(j);
        }
                assertThat(bucket, notNullValue());
        int aggTermsCount = 0;
        for (int i = 0; i < numDocs; i++) {
    static int interval;
            int aggHistoCount = 0;
        assertSearchResponse(response);
                            .extendedBounds(minRandomValue, maxRandomValue)
 * The OpenSearch Contributors require contributions made to
                    bucketSum += sum.value();
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx")
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            .get();
            new Object[] {
            .get();
            double bucketSum = 0;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
    static int maxRandomValue;
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
    public void testDocCountAsSubAgg() throws Exception {
        assertThat(avgBucketValue.getName(), equalTo("avg_terms_bucket"));
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
import org.opensearch.search.aggregations.bucket.terms.Terms;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            assertThat(bucket.getDocCount(), greaterThan(0L));
        double avgValue = count == 0 ? Double.NaN : (sum / count);
            count++;
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
    static int numValueBuckets;
import java.util.Collection;
                Histogram.Bucket bucket = buckets.get(j);
            aggTermsCount++;
            .get();
        for (int i = 0; i < interval; ++i) {
        super(staticSettings);
        Terms terms = response.getAggregations().get("terms");
                assertThat(bucket, notNullValue());
        }
            )
            aggTermsSum += avgHistoValue;
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        assertThat(termsBuckets.size(), equalTo(interval));
        for (int i = 0; i < numValueBuckets; ++i) {
            Histogram histo = termsBucket.getAggregations().get("histo");
 *
        ensureSearchable();
    }
                    .subAggregation(avgBucket("avg_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))
        }
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        }
        assertThat(avgBucketValue, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
            assertThat(histo.getName(), equalTo("histo"));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        assertSearchResponse(response);
import static org.hamcrest.core.IsNull.notNullValue;
            .addAggregation(avgBucket("avg_terms_bucket", "terms>avg_histo_bucket"))
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
    @Override
    public void setupSuiteScopeCluster() throws Exception {
            assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));
import static org.hamcrest.Matchers.greaterThan;
            .addAggregation(
import static org.hamcrest.Matchers.equalTo;
            assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));
    static long[] valueCounts;
 * this file be licensed under the Apache-2.0 license or a
            .addAggregation(avgBucket("avg_bucket", "histo>_count"))
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
@OpenSearchIntegTestCase.SuiteScopeTestCase
            assertThat(avgBucketValue, notNullValue());
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
    public void testNested() throws Exception {
    }
    }
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
            assertThat(bucket, notNullValue());
            InternalSimpleValue avgBucketValue = termsBucket.getAggregations().get("avg_histo_bucket");
                    .subAggregation(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            Histogram.Bucket bucket = buckets.get(i);
            count++;
                            .interval(interval)
            List<? extends Bucket> buckets = histo.getBuckets();
            int count = 0;
    }
    }
            sum += bucket.getDocCount();
        assertThat(avgBucketValue, notNullValue());
            }
        InternalSimpleValue avgBucketValue = response.getAggregations().get("avg_bucket");
        for (int i = 0; i < interval; ++i) {
 * GitHub history for details.
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(avgBucketValue.value(), equalTo(avgValue));
 * You may obtain a copy of the License at
        assertSearchResponse(response);
                terms("terms").field("tag")
            .addAggregation(
 *
            bucketSum += sum.value();
    public static Collection<Object[]> parameters() {
    }
                        jsonBuilder().startObject()
            );
        List<IndexRequestBuilder> builders = new ArrayList<>();
            int count = 0;
package org.opensearch.search.aggregations.pipeline;
                    .subAggregation(
            double bucketSum = 0;
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        InternalSimpleValue avgBucketValue = response.getAggregations().get("avg_bucket");
            Sum sum = bucket.getAggregations().get("sum");
 * under the License.
        assertThat(terms.getName(), equalTo("terms"));
        indexRandom(true, builders);
                            .interval(interval)
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(terms, notNullValue());
        InternalSimpleValue avgBucketValue = response.getAggregations().get("avg_bucket");
                    .order(BucketOrder.key(true))
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        assertThat(avgBucketValue.value(), equalTo(Double.NaN));
                Sum sum = bucket.getAggregations().get("sum");
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        Terms terms = response.getAggregations().get("terms");
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        Terms terms = response.getAggregations().get("terms");
            assertThat(avgBucketValue.value(), equalTo(avgValue));
                Histogram.Bucket bucket = buckets.get(j);
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
    }
        assertThat(terms.getName(), equalTo("terms"));
 * specific language governing permissions and limitations
            Terms.Bucket termsBucket = termsBuckets.get(i);
            double sum = 0;
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
            Terms.Bucket termsBucket = termsBuckets.get(i);
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        valueCounts = new long[numValueBuckets];
            double avgHistoValue = aggHistoCount == 0 ? Double.NaN : (aggHistoSum / aggHistoCount);
            )
            assertThat(avgBucketValue.value(), equalTo(avgHistoValue));
import java.util.Arrays;
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
            assertThat(avgBucketValue, notNullValue());
            InternalSimpleValue avgBucketValue = termsBucket.getAggregations().get("avg_bucket");
                    )
        maxRandomValue = 20;
            .get();
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                    assertThat(sum, notNullValue());
        }
            assertThat(avgBucketValue.value(), equalTo(avgValue));
                aggHistoCount++;
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
            assertThat(termsBucket, notNullValue());
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
        List<? extends Bucket> buckets = histo.getBuckets();
    }
        assertThat(buckets.size(), equalTo(0));
        assertThat(buckets.size(), equalTo(interval));
        assertSearchResponse(response);
                terms("terms").field("tag")
 * ownership. Elasticsearch licenses this file to you under
                            .endObject()
 * Licensed to Elasticsearch under one or more contributor
 */
/*
            assertThat(avgBucketValue, notNullValue());
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
                assertThat(sum, notNullValue());
                    )
 * this work for additional information regarding copyright
                    .subAggregation(avgBucket("avg_bucket", "histo>_count"))
            .addAggregation(
