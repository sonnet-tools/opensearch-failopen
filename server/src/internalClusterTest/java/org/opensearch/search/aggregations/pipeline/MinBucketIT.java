        assertThat(terms.getName(), equalTo("terms"));
                if (bucket.getDocCount() != 0) {
            assertThat(bucket, notNullValue());
                } else if (bucket.getDocCount() == minHistoValue) {
        double minValue = Double.POSITIVE_INFINITY;
        indexRandom(true, builders);
                    .subAggregation(
            List<? extends Bucket> buckets = histo.getBuckets();
                terms("terms").field("tag")
 * The OpenSearch Contributors require contributions made to
        assertThat(minBucketValue, notNullValue());
        InternalBucketMetricValue minBucketValue = response.getAggregations().get("min_terms_bucket");
    }
            } else if (minHistoValue == minTermsValue) {
        }
            }
        SearchResponse response = client().prepareSearch("idx")
        for (int i = 0; i < interval; ++i) {
 */
                            .interval(interval)
            Histogram histo = termsBucket.getAggregations().get("histo");
        InternalBucketMetricValue minBucketValue = response.getAggregations().get("min_bucket");
        assertThat(minBucketValue.value(), equalTo(minTermsValue));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            assertThat(minBucketValue.keys(), equalTo(minKeys.toArray(new String[0])));
        }
import static org.hamcrest.core.IsNull.notNullValue;
 *
            Sum sum = bucket.getAggregations().get("sum");
            builders.add(
            .addAggregation(
                Histogram.Bucket bucket = buckets.get(j);
            }
import java.util.List;
            .get();
            assertThat(histo.getName(), equalTo("histo"));
            } else if (sum.value() == minValue) {
        }
        assertThat(histo, notNullValue());
package org.opensearch.search.aggregations.pipeline;
        assertThat(minBucketValue, notNullValue());
 * specific language governing permissions and limitations
        Terms terms = response.getAggregations().get("terms");
            Terms.Bucket bucket = buckets.get(i);
        double minTermsValue = Double.POSITIVE_INFINITY;
/*
                    .subAggregation(
            assertThat(bucket.getDocCount(), greaterThan(0L));
        assertThat(minBucketValue.keys(), equalTo(minTermsKeys.toArray(new String[0])));
import static org.hamcrest.Matchers.greaterThan;
        assertThat(buckets.size(), equalTo(0));
    }
                }
 * under the License.
                assertThat(bucket, notNullValue());
 */
                    .subAggregation(minBucket("min_bucket", "histo>sum"))
                    )
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
                assertThat(sum, notNullValue());
    static long[] valueCounts;
            valueCounts[bucket]++;
                minKeys.add(bucket.getKeyAsString());
            double minValue = Double.POSITIVE_INFINITY;
            }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                minKeys.add(bucket.getKeyAsString());
    }
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            );
 * Modifications Copyright OpenSearch Contributors. See
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        assertThat(terms.getName(), equalTo("terms"));
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
            for (int j = 0; j < numValueBuckets; ++j) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            Terms.Bucket termsBucket = termsBuckets.get(i);
        valueCounts = new long[numValueBuckets];
            assertThat(minBucketValue, notNullValue());
            assertThat(histo, notNullValue());
            assertThat(minBucketValue.getName(), equalTo("min_bucket"));
            new Object[] {
        assertThat(terms, notNullValue());
                terms("terms").field("tag")
            .addAggregation(
        assertThat(terms.getName(), equalTo("terms"));
            assertThat(histo.getName(), equalTo("histo"));
                    )
                minValue = bucket.getDocCount();
                            .extendedBounds(minRandomValue, maxRandomValue)
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            for (int j = 0; j < numValueBuckets; ++j) {
                    .order(BucketOrder.key(true))
            List<String> minKeys = new ArrayList<>();
    public void testDocCountTopLevel() throws Exception {
        assertThat(terms, notNullValue());
import static org.hamcrest.Matchers.equalTo;
            .addAggregation(minBucket("min_terms_bucket", "terms>min_histo_bucket"))
            );
                terms("terms").field("tag")
                        jsonBuilder().startObject()
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
                assertThat(bucket, notNullValue());
    public MinBucketIT(Settings staticSettings) {
        assertSearchResponse(response);
            InternalBucketMetricValue minBucketValue = termsBucket.getAggregations().get("min_bucket");
            .get();
                        minValue = sum.value();
                    minKeys.add(bucket.getKeyAsString());
        interval = randomIntBetween(2, 5);
                } else if (bucket.getDocCount() == minValue) {
                }
                    if (sum.value() < minValue) {
                minTermsKeys.add(termsBucket.getKeyAsString());
            assertThat(minBucketValue.value(), equalTo(minValue));
                    minKeys = new ArrayList<>();
            }
            assertThat(minBucketValue.value(), equalTo(minValue));
            }
            assertThat(minBucketValue, notNullValue());
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            )
 * Licensed to Elasticsearch under one or more contributor
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                    .order(BucketOrder.key(true))
                if (bucket.getDocCount() < minValue) {
                    minHistoKeys.add(bucket.getKeyAsString());
    }
            List<String> minKeys = new ArrayList<>();
            List<? extends Bucket> buckets = histo.getBuckets();
        assertThat(minBucketValue.getName(), equalTo("min_bucket"));
                    .subAggregation(
            assertThat(minBucketValue.keys(), equalTo(minKeys.toArray(new String[0])));
        for (int i = 0; i < interval; ++i) {
                    minValue = sum.value();
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        assertThat(terms, notNullValue());
        assertThat(minBucketValue.getName(), equalTo("min_terms_bucket"));
                minKeys.add(bucket.getKeyAsString());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                assertThat(bucket, notNullValue());
        assertSearchResponse(response);
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
            assertThat(termsBucket, notNullValue());
                        minKeys.add(bucket.getKeyAsString());
                    minValue = bucket.getDocCount();
import org.opensearch.test.OpenSearchIntegTestCase;
            assertThat(histo.getName(), equalTo("histo"));
        assertThat(minBucketValue.getName(), equalTo("min_bucket"));
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                assertThat(bucket, notNullValue());
            Histogram histo = termsBucket.getAggregations().get("histo");
                minKeys = new ArrayList<>();
            InternalBucketMetricValue minBucketValue = termsBucket.getAggregations().get("min_bucket");
                minTermsValue = minHistoValue;
            if (bucket.getDocCount() < minValue) {
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
 * SPDX-License-Identifier: Apache-2.0
        return Arrays.asList(
            assertThat(minBucketValue, notNullValue());
            new Object[] {
            assertThat(minBucketValue.keys(), equalTo(minKeys.toArray(new String[0])));
            List<String> minHistoKeys = new ArrayList<>();
            assertThat(histo.getName(), equalTo("histo"));
        maxRandomValue = 20;
    public void testMetricAsSubAgg() throws Exception {
            .addAggregation(
            )
            Terms.Bucket termsBucket = termsBuckets.get(i);
        assertThat(minBucketValue.value(), equalTo(minValue));
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());
                    minHistoKeys = new ArrayList<>();
        for (int i = 0; i < interval; ++i) {
        assertThat(termsBuckets.size(), equalTo(interval));
 * this work for additional information regarding copyright
            InternalBucketMetricValue minBucketValue = termsBucket.getAggregations().get("min_histo_bucket");
        assertThat(minBucketValue.keys(), equalTo(minKeys.toArray(new String[0])));
        SearchResponse response = client().prepareSearch("idx")
                    .subAggregation(minBucket("min_histo_bucket", "histo>_count"))
                    minHistoKeys.add(bucket.getKeyAsString());
            assertThat(sum, notNullValue());
        Terms terms = response.getAggregations().get("terms");
                    .includeExclude(new IncludeExclude(null, "tag.*"))
        assertSearchResponse(response);
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        List<String> minKeys = new ArrayList<>();
        assertThat(minBucketValue.keys(), equalTo(minKeys.toArray(new String[0])));
            List<? extends Bucket> buckets = histo.getBuckets();
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        assertThat(minBucketValue.value(), equalTo(minValue));
            Terms.Bucket termsBucket = termsBuckets.get(i);
                        minKeys = new ArrayList<>();
            Histogram histo = termsBucket.getAggregations().get("histo");
@OpenSearchIntegTestCase.SuiteScopeTestCase
        for (int i = 0; i < 2; i++) {
        InternalBucketMetricValue minBucketValue = response.getAggregations().get("min_bucket");
        for (int i = 0; i < interval; ++i) {
        assertThat(terms.getName(), equalTo("terms"));
            .get();
                minKeys.add(bucket.getKeyAsString());
/*
                minTermsKeys.add(termsBucket.getKeyAsString());
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            Histogram.Bucket bucket = buckets.get(i);
                    minKeys.add(bucket.getKeyAsString());
            .get();
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
        super(staticSettings);
            .addAggregation(
        );
 * Unless required by applicable law or agreed to in writing,
/*
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
            .get();
        assertThat(minBucketValue.keys(), equalTo(new String[0]));
        assertThat(termsBuckets.size(), equalTo(interval));
            Histogram histo = termsBucket.getAggregations().get("histo");
    static int minRandomValue;
 * ownership. Elasticsearch licenses this file to you under
import java.util.Arrays;
    }
        Terms terms = response.getAggregations().get("terms");
        assertThat(terms.getName(), equalTo("terms"));
            for (int j = 0; j < numValueBuckets; ++j) {
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
public class MinBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            )
                            .field("tag", "tag" + (i % interval))
        List<String> minKeys = new ArrayList<>();
        assertThat(terms, notNullValue());
 * not use this file except in compliance with the License.
    static int numDocs;
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                if (bucket.getDocCount() < minHistoValue) {
        minRandomValue = 0;
            assertThat(histo, notNullValue());
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        assertSearchResponse(response);
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                minKeys = new ArrayList<>();
        Terms terms = response.getAggregations().get("terms");
import java.util.ArrayList;
                    minKeys.add(bucket.getKeyAsString());
        assertThat(termsBuckets.size(), equalTo(interval));
        assertThat(minBucketValue, notNullValue());
        for (int i = 0; i < interval; ++i) {
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                terms("terms").field("tag")
import org.opensearch.action.index.IndexRequestBuilder;
            .addAggregation(minBucket("min_bucket", "histo>_count"))
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            assertThat(minBucketValue.getName(), equalTo("min_bucket"));
            } else if (bucket.getDocCount() == minValue) {
    public void testMetricTopLevel() throws Exception {
    static int numValueBuckets;
import org.opensearch.search.aggregations.bucket.terms.Terms;
import org.opensearch.search.aggregations.BucketOrder;
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
        assertThat(terms, notNullValue());
    }
    public void testDocCountAsSubAgg() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
                Histogram.Bucket bucket = buckets.get(j);
    }
        SearchResponse response = client().prepareSearch("idx")
        }
                minValue = sum.value();
        numDocs = randomIntBetween(6, 20);
                        minKeys.add(bucket.getKeyAsString());
                    assertThat(sum, notNullValue());
    static int maxRandomValue;
                Histogram.Bucket bucket = buckets.get(j);
                terms("terms").field("tag")
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        assertThat(buckets.size(), equalTo(numValueBuckets));
    }
        }
            }
            assertThat(termsBucket, notNullValue());
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
        for (int i = 0; i < numValueBuckets; ++i) {
            List<String> minKeys = new ArrayList<>();
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        ensureSearchable();
                            .endObject()
            )
                }
        List<String> minTermsKeys = new ArrayList<>();
            new Object[] {
        assertThat(minBucketValue.getName(), equalTo("min_bucket"));
                    minKeys = new ArrayList<>();
    public void testNoBuckets() throws Exception {
            InternalBucketMetricValue minBucketValue = termsBucket.getAggregations().get("min_bucket");
                    )
            double minHistoValue = Double.POSITIVE_INFINITY;
    }
            assertThat(minBucketValue, notNullValue());
    }
                if (sum.value() < minValue) {
        Terms terms = response.getAggregations().get("terms");
        assertSearchResponse(response);
        Terms terms = response.getAggregations().get("terms");
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        List<IndexRequestBuilder> builders = new ArrayList<>();
 */
                client().prepareIndex("empty_bucket_idx")
    public void testNested() throws Exception {
 * compatible open source license.
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
                    .setSource(
            builders.add(
        List<? extends Bucket> buckets = histo.getBuckets();
            assertThat(histo, notNullValue());
                    } else if (sum.value() == minValue) {
            Terms.Bucket termsBucket = termsBuckets.get(i);
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
        SearchResponse response = client().prepareSearch("idx")
        }
            double minValue = Double.POSITIVE_INFINITY;
import java.util.Collection;
                    .subAggregation(
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                    minKeys.add(bucket.getKeyAsString());
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
    @ParametersFactory
import org.opensearch.action.search.SearchResponse;
            .get();
            assertThat(minBucketValue.value(), equalTo(minValue));
            .addAggregation(minBucket("min_bucket", "terms>sum"))
 *
            .addAggregation(minBucket("min_bucket", "terms>sum"))
            assertThat(minBucketValue.getName(), equalTo("min_histo_bucket"));
                minTermsKeys = new ArrayList<>();
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        createIndex("idx_unmapped");
            )
                            .extendedBounds(minRandomValue, maxRandomValue)
        assertThat(termsBuckets.size(), equalTo(interval));
            assertThat(bucket, notNullValue());
        assertThat(minBucketValue.value(), equalTo(Double.POSITIVE_INFINITY));
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
                } else if (sum.value() == minValue) {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertThat(histo.getName(), equalTo("histo"));
            assertThat(minBucketValue.keys(), equalTo(minHistoKeys.toArray(new String[0])));
    public void setupSuiteScopeCluster() throws Exception {
        assertThat(minBucketValue, notNullValue());
            List<? extends Bucket> buckets = histo.getBuckets();
                    .subAggregation(minBucket("min_bucket", "histo>_count"))
        }
                Histogram.Bucket bucket = buckets.get(j);
        assertThat(terms, notNullValue());
                    Sum sum = bucket.getAggregations().get("sum");
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
            }
        }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    )
            double minValue = Double.POSITIVE_INFINITY;
                Sum sum = bucket.getAggregations().get("sum");
            .addAggregation(
            if (sum.value() < minValue) {
            .addAggregation(
        assertThat(buckets.size(), equalTo(interval));
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
            assertThat(minBucketValue.value(), equalTo(minHistoValue));
 *
                }
                client().prepareIndex("idx")
        for (int i = 0; i < numDocs; i++) {
        assertSearchResponse(response);
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
            assertThat(histo, notNullValue());
        assertSearchResponse(response);
import org.opensearch.search.aggregations.metrics.Sum;
            if (minHistoValue < minTermsValue) {
}
            assertThat(minBucketValue.getName(), equalTo("min_bucket"));
            assertThat(termsBucket, notNullValue());
                    .order(BucketOrder.key(true))
                    minHistoValue = bucket.getDocCount();
                    .setId("" + i)
 *    http://www.apache.org/licenses/LICENSE-2.0
        double minValue = Double.POSITIVE_INFINITY;
                    .subAggregation(minBucket("min_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))
        InternalBucketMetricValue minBucketValue = response.getAggregations().get("min_bucket");
            for (int j = 0; j < numValueBuckets; ++j) {
    static int interval;
                    }
    public static Collection<Object[]> parameters() {
                            .interval(interval)
 * GitHub history for details.
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.minBucket;
 * You may obtain a copy of the License at
            .get();
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
        assertThat(terms.getName(), equalTo("terms"));
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
import org.opensearch.common.settings.Settings;
            assertThat(termsBucket, notNullValue());
 * software distributed under the License is distributed on an
        Histogram histo = response.getAggregations().get("histo");
                    .order(BucketOrder.key(true))
            )
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
                    )
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
