                            .endObject()
 */
                    .subAggregation(
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            .dateHistogramInterval(DateHistogramInterval.DAY);
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.maxBucket;
        DateHistogramAggregationBuilder licensePerDayBuilder = AggregationBuilders.dateHistogram("licenses_per_day")
            .field("type", "long")
        SearchResponse response = client().prepareSearch("idx")
                assertThat(sum, notNullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .startObject("keyword")
        InternalBucketMetricValue maxBucketValue = response.getAggregations().get("max_bucket");
    public void testFieldIsntWrittenOutTwice() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
@OpenSearchIntegTestCase.SuiteScopeTestCase
                    .order(BucketOrder.key(true))
 * The OpenSearch Contributors require contributions made to
        Histogram histo = response.getAggregations().get("histo");
    static int numDocs;
                } else if (bucket.getDocCount() == maxHistoValue) {
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            .endObject()
            }
            .addAggregation(
            assertThat(termsBucket, notNullValue());
            assertThat(maxBucketValue.value(), equalTo(maxHistoValue));
        assertThat(terms, notNullValue());
            Histogram histo = termsBucket.getAggregations().get("histo");
            for (int j = 0; j < numValueBuckets; ++j) {
                    .subAggregation(maxBucket("max_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))
            builders.add(
            .addAggregation(
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        );
                    )
            Terms.Bucket termsBucket = termsBuckets.get(i);
            )
        minRandomValue = 0;
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            InternalBucketMetricValue maxBucketValue = termsBucket.getAggregations().get("max_bucket");
                if (sum.value() > maxValue) {
        return Arrays.asList(
            new Object[] {
            .endObject()
            Terms.Bucket bucket = buckets.get(i);
        for (int i = 0; i < interval; ++i) {
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
            .addAggregation(
        List<? extends Bucket> buckets = histo.getBuckets();
                    maxKeys.add(bucket.getKeyAsString());
    public void testMetricAsSubAggOfSingleBucketAgg() throws Exception {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        XContentBuilder docBuilder = jsonBuilder().startObject()
        assertThat(maxBucketValue.keys(), equalTo(new String[0]));
        assertSearchResponse(response);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.index.IndexRequestBuilder;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
        assertThat(terms, notNullValue());
 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            Terms.Bucket termsBucket = termsBuckets.get(i);
        assertThat(maxBucketValue, notNullValue());
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
    /**
            assertThat(maxBucketValue, notNullValue());
        Filter filter = response.getAggregations().get("filter");
            }
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));
            Sum sum = bucket.getAggregations().get("sum");
        indexRandom(true, builders);
        assertThat(terms.getName(), equalTo("terms"));
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
package org.opensearch.search.aggregations.pipeline;
            assertThat(maxBucketValue.value(), equalTo(maxValue));
                maxValue = sum.value();
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        for (int i = 0; i < numDocs; i++) {
                        .interval(interval)
        assertSearchResponse(response);
                    )
            .get();
            );
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            assertThat(histo, notNullValue());
        assertSearchResponse(response);
                    .order(BucketOrder.key(true))
                assertThat(bucket, notNullValue());
            new Object[] {
                    maxKeys = new ArrayList<>();
            .field("type", "date")
        Histogram histo = filter.getAggregations().get("histo");
                        .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            }
        Terms terms = response.getAggregations().get("terms");
        assertThat(maxBucketValue.keys(), equalTo(maxTermsKeys.toArray(new String[0])));
        SumAggregationBuilder sumAggBuilder = AggregationBuilders.sum("total_licenses").field("license.count");
        assertThat(maxBucketValue.value(), equalTo(maxTermsValue));
        assertThat(maxBucketValue.value(), equalTo(maxValue));
            .get();
            .addAggregation(
    static long[] valueCounts;
                        maxValue = sum.value();
            Histogram histo = termsBucket.getAggregations().get("histo");
        for (int j = 0; j < numValueBuckets; ++j) {
import org.opensearch.search.aggregations.AggregationBuilders;
        assertThat(maxBucketValue, notNullValue());
                    maxValue = sum.value();
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(termsBucket, notNullValue());
                    if (sum.value() > maxValue) {
import org.opensearch.core.common.bytes.BytesReference;
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
 * this file be licensed under the Apache-2.0 license or a
        assertThat(buckets.size(), equalTo(0));
                    Sum sum = bucket.getAggregations().get("sum");
            .get();
        assertSearchResponse(response);
        assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
            .get();
            .startObject("license")
        assertThat(buckets.size(), equalTo(numValueBuckets));
        InternalBucketMetricValue maxBucketValue = filter.getAggregations().get("max_bucket");
            .get();
        valueCounts = new long[numValueBuckets];
                maxKeys.add(bucket.getKeyAsString());
            assertThat(bucket, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
                            .extendedBounds(minRandomValue, maxRandomValue)
            double maxHistoValue = Double.NEGATIVE_INFINITY;
            assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));
                }
            double maxValue = Double.NEGATIVE_INFINITY;
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
    }
        double maxTermsValue = Double.NEGATIVE_INFINITY;
                client().prepareIndex("idx")
            );
            }
                } else if (sum.value() == maxValue) {
            .field("ignore_above", 256)
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        super(staticSettings);
            .field("license.partnumber.keyword");
                    .subAggregation(
                    maxKeys.add(bucket.getKeyAsString());
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            assertThat(termsBucket, notNullValue());
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
        SearchResponse response = client().prepareSearch("idx")
            assertThat(histo.getName(), equalTo("histo"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        maxRandomValue = 20;
                maxKeys = new ArrayList<>();
    public void testDocCountTopLevel() throws Exception {
        assertThat(filter, notNullValue());
 * SPDX-License-Identifier: Apache-2.0
        assertThat(maxBucketValue.value(), equalTo(Double.NEGATIVE_INFINITY));
        groupByLicenseAgg.subAggregation(peakPipelineAggBuilder);
        createIndex("idx_unmapped");
            .field("type", "text")
        for (int i = 0; i < interval; ++i) {
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
 * this work for additional information regarding copyright
/*
        assertThat(histo.getName(), equalTo("histo"));
        BytesReference bytes = org.opensearch.core.xcontent.XContentHelper.toXContent(response, MediaTypeRegistry.JSON, false);
 *    http://www.apache.org/licenses/LICENSE-2.0
            .startObject("properties")
            .endObject()
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            for (int j = 0; j < numValueBuckets; ++j) {
        assertThat(filter.getName(), equalTo("filter"));
    }
                client().prepareIndex("empty_bucket_idx")
    public void testMetricTopLevel() throws Exception {
 * compatible open source license.
        for (int i = 0; i < interval; ++i) {
        SearchResponse response = client().prepareSearch("idx")
            assertThat(histo, notNullValue());
    }
import org.opensearch.action.support.WriteRequest;
        SearchResponse response = client().prepareSearch("idx")
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            "licenses_per_day>total_licenses"
            .startObject("license")
            .startObject("count")
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
                ).subAggregation(maxBucket("max_bucket", "histo>sum"))
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
            )
                terms("terms").field("tag")
                assertThat(sum, notNullValue());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertSearchResponse(response);
            } else if (bucket.getDocCount() == maxValue) {
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
                        maxKeys.add(bucket.getKeyAsString());
            .endObject();
import org.opensearch.search.aggregations.BucketOrder;
            .get();
        SearchResponse response = client().prepareSearch("idx")
                    .order(BucketOrder.key(true))
import org.opensearch.common.settings.Settings;
        assertThat(terms.getName(), equalTo("terms"));
 * ownership. Elasticsearch licenses this file to you under
            .endObject()
    public void testNested() throws Exception {
            .endObject()
            assertThat(histo.getName(), equalTo("histo"));
                    .subAggregation(maxBucket("max_bucket", "histo>sum"))
    static int maxRandomValue;
            Histogram.Bucket bucket = buckets.get(i);
            } else if (sum.value() == maxValue) {
 * the Apache License, Version 2.0 (the "License"); you may
 */
            List<? extends Bucket> buckets = histo.getBuckets();
                        .extendedBounds(minRandomValue, maxRandomValue)
            double maxValue = Double.NEGATIVE_INFINITY;
    @Override
            assertThat(histo.getName(), equalTo("histo"));
            .addAggregation(maxBucket("max_terms_bucket", "terms>max_histo_bucket"))
            assertThat(maxBucketValue.keys(), equalTo(maxHistoKeys.toArray(new String[0])));
            new Object[] {
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
        List<IndexRequestBuilder> builders = new ArrayList<>();
                Sum sum = bucket.getAggregations().get("sum");
            .startObject("partnumber")
        assertThat(termsBuckets.size(), equalTo(interval));
        assertThat(histo, notNullValue());
        assertThat(terms, notNullValue());
        assertThat(terms.getName(), equalTo("terms"));
            assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
                terms("terms").field("tag")
                    } else if (sum.value() == maxValue) {
            Terms.Bucket termsBucket = termsBuckets.get(i);
            .endObject()
        SearchResponse response = client().prepareSearch("idx")
            assertThat(bucket.getDocCount(), greaterThan(0L));
                Histogram.Bucket bucket = buckets.get(j);
            assertThat(histo, notNullValue());
                        jsonBuilder().startObject()
public class MaxBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                        maxKeys.add(bucket.getKeyAsString());
        assertThat(maxBucketValue, notNullValue());
                            .extendedBounds(minRandomValue, maxRandomValue)
     * Applies to any pipeline agg, not just max.
    public void testDocCountAsSubAgg() throws Exception {
            }
            assertThat(histo.getName(), equalTo("histo"));
import static org.hamcrest.core.IsNull.notNullValue;
            assertThat(maxBucketValue.getName(), equalTo("max_histo_bucket"));
            assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
                Histogram.Bucket bucket = buckets.get(j);
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                    assertThat(sum, notNullValue());
        // you need to add an additional index with no fields in order to trigger this (or potentially a shard)
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
/*
            if (bucket.getDocCount() != 0) {
            List<String> maxKeys = new ArrayList<>();
            List<? extends Bucket> buckets = histo.getBuckets();
import java.util.List;
                terms("terms").field("tag")
 * not use this file except in compliance with the License.
import java.util.ArrayList;
            .field("type", "keyword")
import static org.hamcrest.Matchers.equalTo;
 *
        }
            .get();
            Terms.Bucket termsBucket = termsBuckets.get(i);
                    maxKeys.add(bucket.getKeyAsString());
        List<String> maxKeys = new ArrayList<>();
}
                maxKeys = new ArrayList<>();
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            .field("partnumber", "foobar")
            )
    }
            assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
            .addAggregation(maxBucket("max_bucket", "terms>sum"))
            Histogram histo = termsBucket.getAggregations().get("histo");
     */
                Sum sum = bucket.getAggregations().get("sum");
import java.util.Arrays;
            InternalBucketMetricValue maxBucketValue = termsBucket.getAggregations().get("max_bucket");
            builders.add(
        InternalBucketMetricValue maxBucketValue = response.getAggregations().get("max_terms_bucket");
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        for (int i = 0; i < numValueBuckets; ++i) {
     * <p>
        Terms terms = response.getAggregations().get("terms");
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
 *
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
        assertThat(terms.getName(), equalTo("terms"));
            if (maxHistoValue > maxTermsValue) {
        }
        List<String> maxTermsKeys = new ArrayList<>();
        assertThat(terms.getName(), equalTo("terms"));
 *
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            List<String> maxKeys = new ArrayList<>();
            .startObject("@timestamp")
                    )
                assertThat(bucket, notNullValue());
                }
                } else if (sum.value() == maxValue) {
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
                    .subAggregation(
     * execution returns to the UnmappedTerms and _it_ runs pipelines as well, doubling up on the values.
        for (int i = 0; i < interval; ++i) {
                    .subAggregation(maxBucket("max_bucket", "histo>_count"))
        List<? extends Bucket> buckets = histo.getBuckets();
        internalCluster().wipeIndices("foo_*");
import java.util.Collection;
                    maxKeys.add(bucket.getKeyAsString());
            )
                assertThat(bucket, notNullValue());
        assertThat(terms, notNullValue());
/*
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
import org.opensearch.search.aggregations.PipelineAggregatorBuilders;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            }
                    .includeExclude(new IncludeExclude(null, "tag.*"))
            assertThat(maxBucketValue, notNullValue());
            assertThat(bucket, notNullValue());
            assertThat(maxBucketValue.value(), equalTo(maxValue));
        );
            .startObject("fields")
                    maxHistoKeys.add(bucket.getKeyAsString());
                maxTermsKeys.add(termsBucket.getKeyAsString());
import static org.opensearch.index.query.QueryBuilders.termQuery;
                } else if (bucket.getDocCount() == maxValue) {
                if (bucket.getDocCount() > maxHistoValue) {
    public void testMetricAsSubAgg() throws Exception {
            List<? extends Bucket> buckets = histo.getBuckets();
                    maxValue = sum.value();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        client().admin().indices().prepareRefresh();
            assertThat(termsBucket, notNullValue());
import org.opensearch.test.OpenSearchIntegTestCase;
 * software distributed under the License is distributed on an
        }
        assertThat(histo, notNullValue());
import org.opensearch.action.search.SearchResponse;
        assertThat(maxBucketValue, notNullValue());
 * GitHub history for details.
 * under the License.
                    maxKeys.add(bucket.getKeyAsString());
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
    static int minRandomValue;
                    maxKeys = new ArrayList<>();
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
            assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));
        assertThat(histo.getName(), equalTo("histo"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
            InternalBucketMetricValue maxBucketValue = termsBucket.getAggregations().get("max_bucket");
    public static Collection<Object[]> parameters() {
import static org.hamcrest.Matchers.greaterThan;
            assertThat(histo, notNullValue());
            .field("@timestamp", "2018-07-08T08:07:00.599Z")
                maxKeys.add(bucket.getKeyAsString());
                maxKeys.add(bucket.getKeyAsString());
                    maxValue = bucket.getDocCount();
 */
            )
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
                    maxKeys = new ArrayList<>();
                    .setSource(
                maxTermsValue = maxHistoValue;
                    )
        assertThat(terms.getName(), equalTo("terms"));
        SearchResponse response = client().prepareSearch("foo_*").setSize(0).addAggregation(groupByLicenseAgg).get();
            assertThat(maxBucketValue, notNullValue());
import org.opensearch.search.aggregations.bucket.filter.Filter;
     * <p>
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
 * specific language governing permissions and limitations
                maxKeys.add(bucket.getKeyAsString());
            "peak",
            Histogram histo = termsBucket.getAggregations().get("histo");
            if (bucket.getDocCount() > maxValue) {
            valueCounts[bucket]++;
        double maxValue = Double.NEGATIVE_INFINITY;
                assertThat(bucket, notNullValue());
        assertThat(termsBuckets.size(), equalTo(interval));
        List<String> maxKeys = new ArrayList<>();
        assertSearchResponse(response);
    }
        assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
            .addAggregation(
                if (bucket.getDocCount() != 0) {
        numDocs = randomIntBetween(6, 20);
        Terms terms = response.getAggregations().get("terms");
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
        }
     * the pipeline agg is run twice.  This makes invalid JSON and breaks conversion to maps.
            assertThat(maxBucketValue.value(), equalTo(maxValue));
        double maxValue = Double.NEGATIVE_INFINITY;
    }
            if (sum.value() > maxValue) {
        }
                    .subAggregation(
        assertThat(maxBucketValue.getName(), equalTo("max_terms_bucket"));
    public void testNoBuckets() throws Exception {
            double maxValue = Double.NEGATIVE_INFINITY;
            )
                Histogram.Bucket bucket = buckets.get(j);
                maxValue = bucket.getDocCount();
                }
import org.opensearch.common.xcontent.XContentHelper;
            .field("@timestamp")
        Terms terms = response.getAggregations().get("terms");
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        assertThat(maxBucketValue, notNullValue());
    public MaxBucketIT(Settings staticSettings) {
        }
        XContentHelper.convertToMap(bytes, false, MediaTypeRegistry.JSON);
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());
        }
        for (int i = 0; i < 2; i++) {
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
        ensureSearchable();
            List<? extends Bucket> buckets = histo.getBuckets();
        client().prepareIndex("foo_2").setSource(docBuilder).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
     * delegated reduction to the first non-unmapped agg, which would reduce and run pipeline aggs.  But then
        groupByLicenseAgg.subAggregation(licensePerDayBuilder);
                terms("terms").field("tag")
            assertThat(sum, notNullValue());
        }
        assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));
        }
        assertThat(terms, notNullValue());
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
                    }
            .endObject()
            }
            } else if (maxHistoValue == maxTermsValue) {
            )
        for (int i = 0; i < interval; ++i) {
import org.opensearch.search.aggregations.bucket.terms.Terms;
                            .interval(interval)
                    .subAggregation(maxBucket("max_histo_bucket", "histo>_count"))
        assertThat(termsBuckets.size(), equalTo(interval));
     * The bug was caused by an UnmappedTerms being the chosen as the first reduction target.  UnmappedTerms
        interval = randomIntBetween(2, 5);
            for (int j = 0; j < numValueBuckets; ++j) {
        assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
        XContentBuilder builder = jsonBuilder().startObject()
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
                filter("filter", termQuery("tag", "tag0")).subAggregation(
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
            Histogram.Bucket bucket = buckets.get(j);
                    maxHistoValue = bucket.getDocCount();
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
        Terms terms = response.getAggregations().get("terms");
            .addAggregation(
        InternalBucketMetricValue maxBucketValue = response.getAggregations().get("max_bucket");
        assertSearchResponse(response);
        licensePerDayBuilder.subAggregation(sumAggBuilder);
        assertThat(termsBuckets.size(), equalTo(interval));
 * You may obtain a copy of the License at
    static int numValueBuckets;
                    maxHistoKeys.add(bucket.getKeyAsString());
                Histogram.Bucket bucket = buckets.get(j);
        assertThat(buckets.size(), equalTo(interval));
    }
        assertThat(maxBucketValue.value(), equalTo(maxValue));
    }
            List<String> maxKeys = new ArrayList<>();
                maxTermsKeys = new ArrayList<>();
                }
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        TermsAggregationBuilder groupByLicenseAgg = AggregationBuilders.terms("group_by_license_partnumber")
    }
     * https://github.com/elastic/elasticsearch/issues/33514
        Terms terms = response.getAggregations().get("terms");
        assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));
        InternalBucketMetricValue maxBucketValue = response.getAggregations().get("max_bucket");
                    maxHistoKeys = new ArrayList<>();
            .endObject()
            .endObject();
        List<String> maxKeys = new ArrayList<>();
            assertThat(bucket, notNullValue());
            .startObject("properties")
            for (int j = 0; j < numValueBuckets; ++j) {
                    maxKeys.add(bucket.getKeyAsString());
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        double maxValue = Double.NEGATIVE_INFINITY;
                            .field("tag", "tag" + (i % interval))
    public void setupSuiteScopeCluster() throws Exception {
    @ParametersFactory
            InternalBucketMetricValue maxBucketValue = termsBucket.getAggregations().get("max_histo_bucket");
                if (bucket.getDocCount() > maxValue) {
 * KIND, either express or implied.  See the License for the
                    .order(BucketOrder.key(true))
                    .setId("" + i)
            .addAggregation(maxBucket("max_bucket", "terms>sum"))
        assertSearchResponse(response);
        assertThat(terms, notNullValue());
        assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
import org.opensearch.search.aggregations.metrics.Sum;
            .field("count", 2)
     * This bug manifests as the max_bucket agg ("peak") being added to the response twice, because
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                    )
            .endObject()
    }
        createIndex("foo_1");
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
 * Unless required by applicable law or agreed to in writing,
    }
        assertThat(maxBucketValue.value(), equalTo(maxValue));
                            .interval(interval)
            }
                        maxKeys = new ArrayList<>();
    static int interval;
                if (sum.value() > maxValue) {
            .addAggregation(
        MaxBucketPipelineAggregationBuilder peakPipelineAggBuilder = PipelineAggregatorBuilders.maxBucket(
        assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));
            .get();
        assertAcked(client().admin().indices().prepareCreate("foo_2").setMapping(builder).get());
                }
                terms("terms").field("tag")
                maxTermsKeys.add(termsBucket.getKeyAsString());
            assertThat(maxBucketValue, notNullValue());
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            .addAggregation(maxBucket("max_bucket", "histo>_count"))
            List<String> maxHistoKeys = new ArrayList<>();
        // so that there is an UnmappedTerms in the list to reduce.
