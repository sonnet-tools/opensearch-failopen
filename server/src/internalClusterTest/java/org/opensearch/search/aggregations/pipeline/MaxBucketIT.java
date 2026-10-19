            assertThat(histo, notNullValue());
 * Unless required by applicable law or agreed to in writing,
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            }  
    static int interval;
                maxTermsValue = maxHistoValue;
            assertThat(bucket.getDocCount(), greaterThan(0L));
package org.opensearch.search.aggregations.pipeline;
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";
        licensePerDayBuilder.subAggregation(sumAggBuilder);
        }  
            .field("@timestamp")  
    }
        for (int i = 0; i < interval; ++i) {
        SearchResponse response = client().prepareSearch("idx")
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(terms, notNullValue());  
            )  
            double maxHistoValue = Double.NEGATIVE_INFINITY;  
        ensureSearchable();
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
    public void setupSuiteScopeCluster() throws Exception {
 * The OpenSearch Contributors require contributions made to  
        indexRandom(true, builders);  
                    .order(BucketOrder.key(true))
        SumAggregationBuilder sumAggBuilder = AggregationBuilders.sum("total_licenses").field("license.count");
                maxKeys = new ArrayList<>();
            List<String> maxKeys = new ArrayList<>();  
        List<String> maxTermsKeys = new ArrayList<>();
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;  
            assertThat(maxBucketValue.value(), equalTo(maxValue));
            .addAggregation(maxBucket("max_terms_bucket", "terms>max_histo_bucket"))  
        for (int i = 0; i < interval; ++i) {  
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(buckets.size(), equalTo(interval));  
                client().prepareIndex("idx")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        groupByLicenseAgg.subAggregation(peakPipelineAggBuilder);
                    maxKeys.add(bucket.getKeyAsString());
                Histogram.Bucket bucket = buckets.get(j);  
                assertThat(bucket, notNullValue());
        maxRandomValue = 20;  
            assertThat(bucket, notNullValue());  
        client().prepareIndex("foo_2").setSource(docBuilder).setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
                    )
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        super(staticSettings);  
                Sum sum = bucket.getAggregations().get("sum");
            assertThat(maxBucketValue.getName(), equalTo("max_bucket"));  
                            .interval(interval)
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
            }  
            .startObject("properties")
            .startObject("properties")  
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertThat(histo.getName(), equalTo("histo"));
        assertThat(terms.getName(), equalTo("terms"));
                if (bucket.getDocCount() > maxHistoValue) {
    }
                maxKeys.add(bucket.getKeyAsString());
 * specific language governing permissions and limitations
            List<String> maxKeys = new ArrayList<>();
 *
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;  
        }
        assertThat(maxBucketValue, notNullValue());
            Sum sum = bucket.getAggregations().get("sum");  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
     * the pipeline agg is run twice.  This makes invalid JSON and breaks conversion to maps.  
                    .order(BucketOrder.key(true))
                } else if (bucket.getDocCount() == maxValue) {
                if (sum.value() > maxValue) {
            .endObject()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        XContentBuilder docBuilder = jsonBuilder().startObject()
            builders.add(  
        SearchResponse response = client().prepareSearch("idx")
            List<? extends Bucket> buckets = histo.getBuckets();
        assertThat(maxBucketValue, notNullValue());  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            assertThat(histo, notNullValue());
            .get();
            assertThat(histo.getName(), equalTo("histo"));
            InternalBucketMetricValue maxBucketValue = termsBucket.getAggregations().get("max_bucket");
            "licenses_per_day>total_licenses"
        assertThat(maxBucketValue.getName(), equalTo("max_bucket"));  
            )
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },  
    }
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));  
                    maxValue = bucket.getDocCount();
        assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
                    }  
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        assertSearchResponse(response);
            assertThat(maxBucketValue.value(), equalTo(maxHistoValue));
        InternalBucketMetricValue maxBucketValue = response.getAggregations().get("max_bucket");
                    )
        assertSearchResponse(response);  
                    maxKeys.add(bucket.getKeyAsString());  
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
import org.opensearch.action.support.WriteRequest;
        SearchResponse response = client().prepareSearch("foo_*").setSize(0).addAggregation(groupByLicenseAgg).get();  
            valueCounts[bucket]++;
            new Object[] {  
            .startObject("keyword")
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))  
            assertThat(maxBucketValue.keys(), equalTo(maxHistoKeys.toArray(new String[0])));  
            .field("license.partnumber.keyword");
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
            .addAggregation(  
            "peak",
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .get();
            .addAggregation(maxBucket("max_bucket", "terms>sum"))  
                maxKeys.add(bucket.getKeyAsString());
                    .subAggregation(maxBucket("max_histo_bucket", "histo>_count"))
            assertThat(termsBucket, notNullValue());
            } else if (bucket.getDocCount() == maxValue) {
            assertThat(maxBucketValue.getName(), equalTo("max_bucket"));  
                    } else if (sum.value() == maxValue) {
                maxKeys = new ArrayList<>();
            } else if (sum.value() == maxValue) {  
            for (int j = 0; j < numValueBuckets; ++j) {
 * software distributed under the License is distributed on an
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));  
        assertSearchResponse(response);
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
    static int maxRandomValue;
import org.opensearch.search.aggregations.metrics.Sum;
                assertThat(sum, notNullValue());  
        XContentHelper.convertToMap(bytes, false, MediaTypeRegistry.JSON);
        for (int i = 0; i < interval; ++i) {
        assertThat(maxBucketValue.value(), equalTo(maxValue));
    @Override  
        double maxValue = Double.NEGATIVE_INFINITY;
        List<String> maxKeys = new ArrayList<>();
                            .field("tag", "tag" + (i % interval))
                Histogram.Bucket bucket = buckets.get(j);
            } else if (maxHistoValue == maxTermsValue) {
            .get();
            List<String> maxKeys = new ArrayList<>();  
        assertThat(termsBuckets.size(), equalTo(interval));  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
        InternalBucketMetricValue maxBucketValue = response.getAggregations().get("max_bucket");
                    .subAggregation(maxBucket("max_bucket", "histo>sum"))
                    maxKeys = new ArrayList<>();  
     * <p>
        assertThat(maxBucketValue.value(), equalTo(maxValue));
    }  
        assertThat(terms, notNullValue());  
            .startObject("license")
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.maxBucket;
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
@OpenSearchIntegTestCase.SuiteScopeTestCase
            double maxValue = Double.NEGATIVE_INFINITY;
    public void testMetricAsSubAggWithInsertZeros() throws Exception {  
     * delegated reduction to the first non-unmapped agg, which would reduce and run pipeline aggs.  But then
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
            assertThat(sum, notNullValue());
        Terms terms = response.getAggregations().get("terms");
                        maxKeys = new ArrayList<>();
            )  
            )
                assertThat(bucket, notNullValue());
            .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
            Histogram histo = termsBucket.getAggregations().get("histo");  
        }
                    maxHistoValue = bucket.getDocCount();  
                    maxKeys.add(bucket.getKeyAsString());
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
        assertSearchResponse(response);  
                Histogram.Bucket bucket = buckets.get(j);  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
 * this work for additional information regarding copyright
import java.util.ArrayList;
            assertThat(termsBucket, notNullValue());  
        createIndex("foo_1");
        SearchResponse response = client().prepareSearch("idx")
            }
                    maxHistoKeys.add(bucket.getKeyAsString());
                    )
        assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));
                        maxValue = sum.value();
            );
    }
                    .subAggregation(
        for (int j = 0; j < numValueBuckets; ++j) {  
/*  
    public MaxBucketIT(Settings staticSettings) {
                            .extendedBounds(minRandomValue, maxRandomValue)
        for (int i = 0; i < interval; ++i) {
            .endObject()
        assertThat(histo, notNullValue());  
        assertThat(maxBucketValue, notNullValue());
    public void testNoBuckets() throws Exception {
        Histogram histo = response.getAggregations().get("histo");
                maxTermsKeys.add(termsBucket.getKeyAsString());
                    assertThat(sum, notNullValue());
        valueCounts = new long[numValueBuckets];  
            );
            assertThat(maxBucketValue, notNullValue());  
     * <p>
            .endObject()  
import java.util.Arrays;
            new Object[] {
    static int numValueBuckets;
            if (maxHistoValue > maxTermsValue) {
}
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            .endObject()
            Histogram.Bucket bucket = buckets.get(j);
                        jsonBuilder().startObject()  
                        maxKeys.add(bucket.getKeyAsString());
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
        interval = randomIntBetween(2, 5);  
 * compatible open source license.
            if (bucket.getDocCount() != 0) {
            )
        assertThat(maxBucketValue.value(), equalTo(Double.NEGATIVE_INFINITY));
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);  
        }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;  
     * The bug was caused by an UnmappedTerms being the chosen as the first reduction target.  UnmappedTerms
        assertThat(maxBucketValue.keys(), equalTo(maxTermsKeys.toArray(new String[0])));
import org.opensearch.test.OpenSearchIntegTestCase;
            assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
            assertThat(bucket, notNullValue());
            InternalBucketMetricValue maxBucketValue = termsBucket.getAggregations().get("max_bucket");
 * not use this file except in compliance with the License.
                        .extendedBounds(minRandomValue, maxRandomValue)  
        }
 *
        assertThat(termsBuckets.size(), equalTo(interval));  
            .addAggregation(  
        assertThat(terms, notNullValue());
            Histogram histo = termsBucket.getAggregations().get("histo");
        for (int i = 0; i < 2; i++) {
        double maxValue = Double.NEGATIVE_INFINITY;  
        assertThat(terms, notNullValue());  
 */  
        assertThat(histo, notNullValue());  
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                    Sum sum = bucket.getAggregations().get("sum");
        assertThat(termsBuckets.size(), equalTo(interval));  
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Histogram histo = filter.getAggregations().get("histo");
            .addAggregation(
            .get();
            List<? extends Bucket> buckets = histo.getBuckets();
 * ownership. Elasticsearch licenses this file to you under  
            .addAggregation(
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        assertThat(termsBuckets.size(), equalTo(interval));
        List<IndexRequestBuilder> builders = new ArrayList<>();
    public void testDocCountAsSubAgg() throws Exception {
        return Arrays.asList(
import static org.opensearch.search.aggregations.AggregationBuilders.filter;  
        );  
 */  
        assertThat(maxBucketValue, notNullValue());
        assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
                }
                    maxKeys.add(bucket.getKeyAsString());
        InternalBucketMetricValue maxBucketValue = response.getAggregations().get("max_terms_bucket");
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.common.xcontent.XContentHelper;
            builders.add(  
 * Licensed to Elasticsearch under one or more contributor  
                            .interval(interval)
import org.opensearch.search.aggregations.AggregationBuilders;
            .get();
        }  
                ).subAggregation(maxBucket("max_bucket", "histo>sum"))
            .startObject("partnumber")
public class MaxBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                terms("terms").field("tag")  
import static org.hamcrest.core.IsNull.notNullValue;  
                filter("filter", termQuery("tag", "tag0")).subAggregation(  
            InternalBucketMetricValue maxBucketValue = termsBucket.getAggregations().get("max_histo_bucket");
            .field("partnumber", "foobar")  
    }
        assertThat(terms.getName(), equalTo("terms"));  
        Terms terms = response.getAggregations().get("terms");
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(terms, notNullValue());  
            assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));
        }
    }  
     * execution returns to the UnmappedTerms and _it_ runs pipelines as well, doubling up on the values.  
        client().admin().indices().prepareRefresh();
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())  
            .field("type", "long")
    public void testFieldIsntWrittenOutTwice() throws Exception {
        assertThat(maxBucketValue.getName(), equalTo("max_terms_bucket"));  
                if (bucket.getDocCount() > maxValue) {
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));  
 * You may obtain a copy of the License at  
        assertSearchResponse(response);  
                    .subAggregation(maxBucket("max_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))
                    .subAggregation(  
            assertThat(termsBucket, notNullValue());
            .startObject("@timestamp")
import org.opensearch.common.settings.Settings;  
                maxKeys.add(bucket.getKeyAsString());  
                    .setSource(
        numDocs = randomIntBetween(6, 20);
        assertThat(filter, notNullValue());  
        BytesReference bytes = org.opensearch.core.xcontent.XContentHelper.toXContent(response, MediaTypeRegistry.JSON, false);
            .startObject("count")
     * https://github.com/elastic/elasticsearch/issues/33514  
    }
        assertThat(maxBucketValue, notNullValue());  
    }
        InternalBucketMetricValue maxBucketValue = filter.getAggregations().get("max_bucket");
        assertThat(maxBucketValue.keys(), equalTo(new String[0]));
    @ParametersFactory  
            for (int j = 0; j < numValueBuckets; ++j) {  
                maxTermsKeys = new ArrayList<>();  
import org.opensearch.search.aggregations.PipelineAggregatorBuilders;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                    histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))  
     * Applies to any pipeline agg, not just max.
    public void testMetricAsSubAgg() throws Exception {  
        SearchResponse response = client().prepareSearch("idx")  
            Terms.Bucket termsBucket = termsBuckets.get(i);
            .addAggregation(  
            assertThat(termsBucket, notNullValue());
            for (int j = 0; j < numValueBuckets; ++j) {
        Terms terms = response.getAggregations().get("terms");
            assertThat(maxBucketValue, notNullValue());
                }
            new Object[] {
            .addAggregation(
                }
            }  
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
            List<String> maxHistoKeys = new ArrayList<>();
            .endObject();
        assertThat(maxBucketValue.value(), equalTo(maxTermsValue));
        assertSearchResponse(response);  
            .field("count", 2)
            .addAggregation(maxBucket("max_bucket", "histo>_count"))  
        assertThat(terms.getName(), equalTo("terms"));
            .endObject()  
            .field("type", "date")  
        Filter filter = response.getAggregations().get("filter");
            .endObject()
            assertThat(bucket, notNullValue());  
        assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));  
        }  
                } else if (sum.value() == maxValue) {  
            assertThat(histo.getName(), equalTo("histo"));
                    )
        assertThat(terms, notNullValue());
            assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));  
        minRandomValue = 0;
        assertThat(maxBucketValue.value(), equalTo(maxValue));  
/*
import static org.hamcrest.Matchers.equalTo;
        SearchResponse response = client().prepareSearch("idx")
        assertThat(histo.getName(), equalTo("histo"));
                    maxValue = sum.value();  
        SearchResponse response = client().prepareSearch("idx")
 * this file be licensed under the Apache-2.0 license or a
        assertThat(maxBucketValue.getName(), equalTo("max_bucket"));
                client().prepareIndex("empty_bucket_idx")
        createIndex("idx_unmapped");  
    public void testDocCountTopLevel() throws Exception {
            assertThat(histo.getName(), equalTo("histo"));  
            assertThat(histo, notNullValue());
 */
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
import static org.hamcrest.Matchers.greaterThan;
                    )  
            List<? extends Bucket> buckets = histo.getBuckets();
            Terms.Bucket bucket = buckets.get(i);
                terms("terms").field("tag")
        assertSearchResponse(response);  
        SearchResponse response = client().prepareSearch("idx")
            .endObject()  
        TermsAggregationBuilder groupByLicenseAgg = AggregationBuilders.terms("group_by_license_partnumber")
    static int minRandomValue;  
import org.opensearch.action.index.IndexRequestBuilder;  
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
        List<? extends Bucket> buckets = histo.getBuckets();
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        assertThat(filter.getName(), equalTo("filter"));
            List<? extends Bucket> buckets = histo.getBuckets();  
            assertThat(maxBucketValue.value(), equalTo(maxValue));
                            .extendedBounds(minRandomValue, maxRandomValue)
 *  
    static int numDocs;
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        assertAcked(client().admin().indices().prepareCreate("foo_2").setMapping(builder).get());
        }  
    }
import org.opensearch.core.common.bytes.BytesReference;
            Terms.Bucket termsBucket = termsBuckets.get(i);  
            Terms.Bucket termsBucket = termsBuckets.get(i);  
import org.opensearch.search.aggregations.BucketOrder;  
                    .subAggregation(maxBucket("max_bucket", "histo>_count"))  
 * license agreements. See the NOTICE file distributed with
        Terms terms = response.getAggregations().get("terms");
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
                    .order(BucketOrder.key(true))
                maxValue = bucket.getDocCount();
                    .subAggregation(
        List<? extends Bucket> buckets = histo.getBuckets();
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            assertThat(maxBucketValue.keys(), equalTo(maxKeys.toArray(new String[0])));
        assertThat(terms.getName(), equalTo("terms"));
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
            .startObject("license")
        groupByLicenseAgg.subAggregation(licensePerDayBuilder);  
    public static Collection<Object[]> parameters() {
        for (int i = 0; i < interval; ++i) {
                maxKeys.add(bucket.getKeyAsString());
                    maxHistoKeys.add(bucket.getKeyAsString());
                terms("terms").field("tag")
import java.util.List;
                assertThat(sum, notNullValue());
        Terms terms = response.getAggregations().get("terms");  
                terms("terms").field("tag")
                    .subAggregation(
        Terms terms = response.getAggregations().get("terms");
                maxValue = sum.value();  
                    maxKeys.add(bucket.getKeyAsString());
            double maxValue = Double.NEGATIVE_INFINITY;
            }
            assertThat(maxBucketValue.getName(), equalTo("max_histo_bucket"));
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());
            }
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
    static long[] valueCounts;  
                assertThat(bucket, notNullValue());
        double maxValue = Double.NEGATIVE_INFINITY;  
                Histogram.Bucket bucket = buckets.get(j);
                        .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            .get();  
                Sum sum = bucket.getAggregations().get("sum");  
            if (bucket.getDocCount() > maxValue) {  
 * under the License.  
        List<String> maxKeys = new ArrayList<>();
                        .interval(interval)
        InternalBucketMetricValue maxBucketValue = response.getAggregations().get("max_bucket");  
        assertSearchResponse(response);  
            Histogram.Bucket bucket = buckets.get(i);
            assertThat(histo, notNullValue());  
/*  
        assertThat(terms.getName(), equalTo("terms"));
            .endObject()
                    maxKeys.add(bucket.getKeyAsString());  
        assertThat(buckets.size(), equalTo(0));
            .field("type", "keyword")
            }
            assertThat(maxBucketValue, notNullValue());  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
                    maxValue = sum.value();
        // you need to add an additional index with no fields in order to trigger this (or potentially a shard)
        double maxTermsValue = Double.NEGATIVE_INFINITY;  
            .get();
        internalCluster().wipeIndices("foo_*");  
                        maxKeys.add(bucket.getKeyAsString());  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;
            double maxValue = Double.NEGATIVE_INFINITY;
        );  
            .field("type", "text")
                    .includeExclude(new IncludeExclude(null, "tag.*"))
            .endObject();
        assertThat(buckets.size(), equalTo(numValueBuckets));  
                if (bucket.getDocCount() != 0) {  
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .setId("" + i)
            Histogram histo = termsBucket.getAggregations().get("histo");
        XContentBuilder builder = jsonBuilder().startObject()  
     * This bug manifests as the max_bucket agg ("peak") being added to the response twice, because
            assertThat(maxBucketValue, notNullValue());
            assertThat(histo.getName(), equalTo("histo"));  
                if (sum.value() > maxValue) {
    }
                }
                assertThat(bucket, notNullValue());  
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
            for (int j = 0; j < numValueBuckets; ++j) {
            .dateHistogramInterval(DateHistogramInterval.DAY);
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
                    maxKeys = new ArrayList<>();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .startObject("fields")  
                } else if (bucket.getDocCount() == maxHistoValue) {  
                            .endObject()  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                } else if (sum.value() == maxValue) {
                    if (sum.value() > maxValue) {  
                terms("terms").field("tag")  
        for (int i = 0; i < numValueBuckets; ++i) {
import org.opensearch.action.search.SearchResponse;
 * KIND, either express or implied.  See the License for the
                    maxKeys = new ArrayList<>();  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))  
        MaxBucketPipelineAggregationBuilder peakPipelineAggBuilder = PipelineAggregatorBuilders.maxBucket(  
    }
            .addAggregation(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        for (int i = 0; i < numDocs; i++) {
            assertThat(maxBucketValue.value(), equalTo(maxValue));
                maxTermsKeys.add(termsBucket.getKeyAsString());  
                    .order(BucketOrder.key(true))  
            )  
            .field("@timestamp", "2018-07-08T08:07:00.599Z")  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;  
    public void testMetricAsSubAggOfSingleBucketAgg() throws Exception {  
            Terms.Bucket termsBucket = termsBuckets.get(i);
    public void testMetricTopLevel() throws Exception {  
            Histogram histo = termsBucket.getAggregations().get("histo");
            }
        List<String> maxKeys = new ArrayList<>();
            InternalBucketMetricValue maxBucketValue = termsBucket.getAggregations().get("max_bucket");
        // so that there is an UnmappedTerms in the list to reduce.  
 * GitHub history for details.
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
        DateHistogramAggregationBuilder licensePerDayBuilder = AggregationBuilders.dateHistogram("licenses_per_day")
    /**
import org.opensearch.search.aggregations.bucket.filter.Filter;
            if (sum.value() > maxValue) {
            .field("ignore_above", 256)  
            )
            .addAggregation(maxBucket("max_bucket", "terms>sum"))
            .get();
    public void testNested() throws Exception {
     */  
                    maxHistoKeys = new ArrayList<>();
