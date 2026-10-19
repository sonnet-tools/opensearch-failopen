            double minValue = Double.POSITIVE_INFINITY;
        List<? extends Bucket> buckets = histo.getBuckets();  
        assertThat(minBucketValue.getName(), equalTo("min_bucket"));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        InternalBucketMetricValue minBucketValue = response.getAggregations().get("min_terms_bucket");
    public void testDocCountAsSubAgg() throws Exception {
        Terms terms = response.getAggregations().get("terms");  
        Terms terms = response.getAggregations().get("terms");  
        for (int i = 0; i < interval; ++i) {
        SearchResponse response = client().prepareSearch("idx")  
                client().prepareIndex("idx")
        assertSearchResponse(response);
                    .setId("" + i)  
                Histogram.Bucket bucket = buckets.get(j);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            InternalBucketMetricValue minBucketValue = termsBucket.getAggregations().get("min_bucket");  
                    minKeys.add(bucket.getKeyAsString());
            assertThat(minBucketValue, notNullValue());
                }
 * Licensed to Elasticsearch under one or more contributor  
                if (bucket.getDocCount() != 0) {
        assertSearchResponse(response);
    public static Collection<Object[]> parameters() {
            if (sum.value() < minValue) {  
        assertThat(terms, notNullValue());
                assertThat(sum, notNullValue());
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        for (int i = 0; i < interval; ++i) {
    static int minRandomValue;
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
            .addAggregation(minBucket("min_bucket", "histo>_count"))
        assertThat(minBucketValue.getName(), equalTo("min_bucket"));
public class MinBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    public void testNoBuckets() throws Exception {
            assertThat(histo.getName(), equalTo("histo"));
        createIndex("idx_unmapped");
    }  
@OpenSearchIntegTestCase.SuiteScopeTestCase  
                    minValue = sum.value();
        assertSearchResponse(response);  
            assertThat(minBucketValue.keys(), equalTo(minKeys.toArray(new String[0])));  
            assertThat(minBucketValue.getName(), equalTo("min_bucket"));
 * specific language governing permissions and limitations
            .addAggregation(
 * GitHub history for details.
                            .extendedBounds(minRandomValue, maxRandomValue)  
            }  
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;  
        Terms terms = response.getAggregations().get("terms");
            )
import org.opensearch.common.settings.Settings;
                    Sum sum = bucket.getAggregations().get("sum");
        List<String> minKeys = new ArrayList<>();  
            double minValue = Double.POSITIVE_INFINITY;
        double minValue = Double.POSITIVE_INFINITY;
        return Arrays.asList(  
        assertThat(histo.getName(), equalTo("histo"));
                minTermsKeys.add(termsBucket.getKeyAsString());
            }
 *
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
 * ownership. Elasticsearch licenses this file to you under  
            builders.add(
            assertThat(minBucketValue, notNullValue());
        assertThat(minBucketValue.keys(), equalTo(new String[0]));  
            assertThat(bucket.getDocCount(), greaterThan(0L));  
        Terms terms = response.getAggregations().get("terms");
            Terms.Bucket termsBucket = termsBuckets.get(i);  
        assertThat(minBucketValue.value(), equalTo(minValue));  
            double minValue = Double.POSITIVE_INFINITY;  
            assertThat(minBucketValue, notNullValue());  
 * under the License.  
            Sum sum = bucket.getAggregations().get("sum");
            double minHistoValue = Double.POSITIVE_INFINITY;
                    minKeys = new ArrayList<>();
            new Object[] {  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                minKeys.add(bucket.getKeyAsString());
                    .subAggregation(minBucket("min_bucket", "histo>sum"))  
        assertThat(minBucketValue.keys(), equalTo(minTermsKeys.toArray(new String[0])));  
            .addAggregation(minBucket("min_bucket", "terms>sum"))
                }  
                    .subAggregation(
    public MinBucketIT(Settings staticSettings) {  
                    .order(BucketOrder.key(true))
        for (int i = 0; i < numDocs; i++) {
                    .includeExclude(new IncludeExclude(null, "tag.*"))  
            List<String> minKeys = new ArrayList<>();
        for (int i = 0; i < interval; ++i) {  
                if (bucket.getDocCount() < minValue) {
/*
        assertThat(terms, notNullValue());
            InternalBucketMetricValue minBucketValue = termsBucket.getAggregations().get("min_bucket");
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
        List<String> minKeys = new ArrayList<>();  
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
            assertThat(minBucketValue.keys(), equalTo(minHistoKeys.toArray(new String[0])));
            )  
            assertThat(bucket, notNullValue());
        assertThat(minBucketValue.value(), equalTo(minValue));
import static org.hamcrest.core.IsNull.notNullValue;
                terms("terms").field("tag")
            )
            } else if (sum.value() == minValue) {
        assertThat(minBucketValue.getName(), equalTo("min_bucket"));
        ensureSearchable();
            );
        for (int i = 0; i < interval; ++i) {  
            .addAggregation(  
                minTermsKeys = new ArrayList<>();
        }
        assertThat(terms.getName(), equalTo("terms"));
        Histogram histo = response.getAggregations().get("histo");  
            Histogram histo = termsBucket.getAggregations().get("histo");  
            .get();
                            .field("tag", "tag" + (i % interval))  
import org.opensearch.action.search.SearchResponse;
        assertThat(minBucketValue, notNullValue());  
            Histogram histo = termsBucket.getAggregations().get("histo");
                    .order(BucketOrder.key(true))
        double minValue = Double.POSITIVE_INFINITY;
        assertThat(minBucketValue.value(), equalTo(minTermsValue));
    public void testMetricTopLevel() throws Exception {
        assertThat(terms.getName(), equalTo("terms"));
            for (int j = 0; j < numValueBuckets; ++j) {
import java.util.List;
            .get();
        }  
        assertThat(buckets.size(), equalTo(0));  
            .get();  
        }  
        Terms terms = response.getAggregations().get("terms");  
        }
            for (int j = 0; j < numValueBuckets; ++j) {  
            assertThat(minBucketValue.value(), equalTo(minValue));  
                    )
                } else if (bucket.getDocCount() == minHistoValue) {
                    minKeys.add(bucket.getKeyAsString());  
import org.opensearch.search.aggregations.BucketOrder;  
        numDocs = randomIntBetween(6, 20);  
            assertThat(bucket, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
                Sum sum = bucket.getAggregations().get("sum");
            assertThat(histo, notNullValue());
            List<String> minKeys = new ArrayList<>();
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                minValue = bucket.getDocCount();
            .addAggregation(
            .addAggregation(minBucket("min_bucket", "terms>sum"))  
            .addAggregation(  
 * Modifications Copyright OpenSearch Contributors. See
    }
            Terms.Bucket bucket = buckets.get(i);  
                    }
                    )
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
        interval = randomIntBetween(2, 5);
        }
        SearchResponse response = client().prepareSearch("idx")  
            new Object[] {
            assertThat(minBucketValue.value(), equalTo(minHistoValue));  
        assertThat(terms, notNullValue());  
            .addAggregation(
                if (bucket.getDocCount() < minHistoValue) {  
                client().prepareIndex("empty_bucket_idx")
            builders.add(
            )
                        minKeys = new ArrayList<>();  
        }
    }  
import static org.hamcrest.Matchers.greaterThan;  
import org.opensearch.search.aggregations.metrics.Sum;
    }
 * software distributed under the License is distributed on an
            } else if (minHistoValue == minTermsValue) {  
            if (minHistoValue < minTermsValue) {
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
package org.opensearch.search.aggregations.pipeline;
                    .subAggregation(minBucket("min_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))  
        minRandomValue = 0;  
            assertThat(termsBucket, notNullValue());
                    .subAggregation(  
            Terms.Bucket termsBucket = termsBuckets.get(i);
                Histogram.Bucket bucket = buckets.get(j);
        assertSearchResponse(response);
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
            List<String> minHistoKeys = new ArrayList<>();  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchIntegTestCase;
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";  
                    .subAggregation(  
                assertThat(bucket, notNullValue());
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());  
            assertThat(histo, notNullValue());  
            assertThat(sum, notNullValue());
    }
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        assertThat(buckets.size(), equalTo(numValueBuckets));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        for (int i = 0; i < 2; i++) {  
/*  
            InternalBucketMetricValue minBucketValue = termsBucket.getAggregations().get("min_bucket");
        assertThat(termsBuckets.size(), equalTo(interval));
                    } else if (sum.value() == minValue) {
        for (int i = 0; i < interval; ++i) {
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.minBucket;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        assertThat(minBucketValue.keys(), equalTo(minKeys.toArray(new String[0])));
                    )
            assertThat(termsBucket, notNullValue());
    public void testMetricAsSubAgg() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
            Histogram histo = termsBucket.getAggregations().get("histo");
        assertThat(terms.getName(), equalTo("terms"));
            )
                if (sum.value() < minValue) {  
                } else if (sum.value() == minValue) {
        assertThat(terms.getName(), equalTo("terms"));
        double minTermsValue = Double.POSITIVE_INFINITY;
        indexRandom(true, builders);
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
                    .subAggregation(
    }
 *  
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
                }
                }  
            for (int j = 0; j < numValueBuckets; ++j) {
                    )
        assertThat(minBucketValue, notNullValue());
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
                minValue = sum.value();
                    minKeys.add(bucket.getKeyAsString());
            Terms.Bucket termsBucket = termsBuckets.get(i);
            List<? extends Bucket> buckets = histo.getBuckets();  
import org.opensearch.action.index.IndexRequestBuilder;  
        assertThat(buckets.size(), equalTo(interval));
                minTermsKeys.add(termsBucket.getKeyAsString());
    static long[] valueCounts;
                terms("terms").field("tag")  
            assertThat(termsBucket, notNullValue());
    }
                minKeys = new ArrayList<>();
                    minHistoKeys = new ArrayList<>();
            InternalBucketMetricValue minBucketValue = termsBucket.getAggregations().get("min_histo_bucket");  
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);  
                terms("terms").field("tag")
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
 * this file be licensed under the Apache-2.0 license or a
        assertSearchResponse(response);
import java.util.ArrayList;
        for (int i = 0; i < numValueBuckets; ++i) {
            );  
        assertThat(histo, notNullValue());
/*  
        valueCounts = new long[numValueBuckets];
            assertThat(minBucketValue.getName(), equalTo("min_histo_bucket"));
            assertThat(histo, notNullValue());
 *
                    .subAggregation(minBucket("min_bucket", "histo>_count"))
 */  
        Terms terms = response.getAggregations().get("terms");  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
            .addAggregation(
            assertThat(minBucketValue, notNullValue());  
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            assertThat(minBucketValue.keys(), equalTo(minKeys.toArray(new String[0])));
                    .setSource(  
    @Override
                    minKeys.add(bucket.getKeyAsString());
            List<? extends Bucket> buckets = histo.getBuckets();
            for (int j = 0; j < numValueBuckets; ++j) {  
    public void testDocCountTopLevel() throws Exception {
                    minValue = bucket.getDocCount();  
        assertThat(minBucketValue, notNullValue());  
    }
                assertThat(bucket, notNullValue());
        assertThat(termsBuckets.size(), equalTo(interval));
                minKeys = new ArrayList<>();  
        assertThat(terms, notNullValue());
    public void setupSuiteScopeCluster() throws Exception {
            )  
        super(staticSettings);
            }  
            assertThat(minBucketValue.getName(), equalTo("min_bucket"));
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
            .get();
            }
                    .subAggregation(minBucket("min_histo_bucket", "histo>_count"))
                    minHistoKeys.add(bucket.getKeyAsString());
        SearchResponse response = client().prepareSearch("idx")
            assertThat(histo.getName(), equalTo("histo"));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        InternalBucketMetricValue minBucketValue = response.getAggregations().get("min_bucket");
            List<? extends Bucket> buckets = histo.getBuckets();
        assertThat(termsBuckets.size(), equalTo(interval));
                    .order(BucketOrder.key(true))  
        assertThat(terms.getName(), equalTo("terms"));  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
    public void testNested() throws Exception {  
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
            new Object[] {
            }  
        assertThat(terms, notNullValue());
            assertThat(minBucketValue.value(), equalTo(minValue));
                            .interval(interval)
            }
                assertThat(bucket, notNullValue());
                    )  
        assertThat(termsBuckets.size(), equalTo(interval));
            .get();
                        minKeys.add(bucket.getKeyAsString());  
                Histogram.Bucket bucket = buckets.get(j);  
        );
        InternalBucketMetricValue minBucketValue = response.getAggregations().get("min_bucket");
                minTermsValue = minHistoValue;  
                        minKeys.add(bucket.getKeyAsString());
                minKeys.add(bucket.getKeyAsString());
                        jsonBuilder().startObject()
                            .endObject()
    static int numValueBuckets;  
                minKeys.add(bucket.getKeyAsString());  
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))  
                terms("terms").field("tag")
    }  
        assertThat(minBucketValue.keys(), equalTo(minKeys.toArray(new String[0])));
 * not use this file except in compliance with the License.
        SearchResponse response = client().prepareSearch("idx")
            .get();
                    minKeys = new ArrayList<>();
            if (bucket.getDocCount() < minValue) {
}
    static int maxRandomValue;
            .addAggregation(minBucket("min_terms_bucket", "terms>min_histo_bucket"))
            assertThat(histo.getName(), equalTo("histo"));
 * this work for additional information regarding copyright
            valueCounts[bucket]++;
                    minHistoValue = bucket.getDocCount();
    static int numDocs;
        maxRandomValue = 20;
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)  
            assertThat(minBucketValue.keys(), equalTo(minKeys.toArray(new String[0])));  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));  
            .get();
                Histogram.Bucket bucket = buckets.get(j);
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }  
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(terms, notNullValue());
 * You may obtain a copy of the License at  
    static int interval;  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
import java.util.Collection;  
                    if (sum.value() < minValue) {
 */  
 */
            Histogram.Bucket bucket = buckets.get(i);  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));  
        assertThat(minBucketValue.value(), equalTo(Double.POSITIVE_INFINITY));
            assertThat(histo.getName(), equalTo("histo"));  
            } else if (bucket.getDocCount() == minValue) {
                    minHistoKeys.add(bucket.getKeyAsString());  
        assertThat(minBucketValue, notNullValue());
                terms("terms").field("tag")
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
                    assertThat(sum, notNullValue());  
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            List<String> minKeys = new ArrayList<>();
            }
 * license agreements. See the NOTICE file distributed with
                assertThat(bucket, notNullValue());  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        InternalBucketMetricValue minBucketValue = response.getAggregations().get("min_bucket");  
                            .extendedBounds(minRandomValue, maxRandomValue)  
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
        assertSearchResponse(response);
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
 * The OpenSearch Contributors require contributions made to  
                } else if (bucket.getDocCount() == minValue) {  
                        minValue = sum.value();
            assertThat(minBucketValue.value(), equalTo(minValue));
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;  
            assertThat(histo, notNullValue());  
 * compatible open source license.
            Terms.Bucket termsBucket = termsBuckets.get(i);
    @ParametersFactory
        }  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        List<String> minTermsKeys = new ArrayList<>();  
                minKeys.add(bucket.getKeyAsString());  
        assertSearchResponse(response);
 * the Apache License, Version 2.0 (the "License"); you may
        }
            Histogram histo = termsBucket.getAggregations().get("histo");
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        assertThat(minBucketValue.getName(), equalTo("min_terms_bucket"));
        assertThat(terms.getName(), equalTo("terms"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(minBucketValue.getName(), equalTo("min_bucket"));
import java.util.Arrays;
            List<? extends Bucket> buckets = histo.getBuckets();
                    .order(BucketOrder.key(true))
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            assertThat(termsBucket, notNullValue());  
        SearchResponse response = client().prepareSearch("idx")  
                            .interval(interval)
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
import org.opensearch.search.aggregations.bucket.terms.Terms;
