        assertThat(histo, notNullValue());
        assertThat(terms, notNullValue());  
            assertThat(histo, notNullValue());
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                Histogram.Bucket bucket = buckets.get(j);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        assertThat(terms.getName(), equalTo("terms"));
        for (int i = 0; i < interval; ++i) {  
import org.opensearch.search.aggregations.metrics.Sum;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.bucket.terms.Terms;
 * ownership. Elasticsearch licenses this file to you under  
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
        assertThat(sumBucketValue.getName(), equalTo("sum_terms_bucket"));
        interval = randomIntBetween(2, 5);
        assertThat(terms.getName(), equalTo("terms"));
 * the Apache License, Version 2.0 (the "License"); you may
        List<? extends Bucket> buckets = histo.getBuckets();  
    static int interval;  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
    @ParametersFactory
                    Sum sum = bucket.getAggregations().get("sum");
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
 * under the License.  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(termsBuckets.size(), equalTo(interval));
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);  
        assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));
    }  
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());  
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
 *
            )  
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
    static int minRandomValue;
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";  
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        assertSearchResponse(response);
                assertThat(sum, notNullValue());
import static org.hamcrest.core.IsNull.notNullValue;
public class SumBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        Terms terms = response.getAggregations().get("terms");
        assertSearchResponse(response);  
        assertThat(terms, notNullValue());  
                terms("terms").field("tag")  
            double aggHistoSum = 0;
            );  
                assertThat(bucket, notNullValue());
                    assertThat(sum, notNullValue());
    public static Collection<Object[]> parameters() {
            .addAggregation(
            Terms.Bucket termsBucket = termsBuckets.get(i);
            }
        assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));
            .get();
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
import static org.hamcrest.Matchers.equalTo;
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
    }  
                client().prepareIndex("empty_bucket_idx")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                Histogram.Bucket bucket = buckets.get(j);
                    )
            .get();
                    .order(BucketOrder.key(true))
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
        Terms terms = response.getAggregations().get("terms");
    static int numValueBuckets;  
        assertThat(buckets.size(), equalTo(numValueBuckets));
    }  
 */
            }
        SearchResponse response = client().prepareSearch("idx")
    }
        assertThat(sumBucketValue.value(), equalTo(sum));  
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
    public void setupSuiteScopeCluster() throws Exception {
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)  
                            .extendedBounds(minRandomValue, maxRandomValue)  
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.sumBucket;
/*
        super(staticSettings);
        for (int i = 0; i < 2; i++) {  
@OpenSearchIntegTestCase.SuiteScopeTestCase  
            .addAggregation(
        }  
                    .includeExclude(new IncludeExclude(null, "tag.*"))  
                    .setId("" + i)  
            bucketSum += sum.value();
            Histogram.Bucket bucket = buckets.get(i);
        assertThat(terms.getName(), equalTo("terms"));
        InternalSimpleValue sumBucketValue = response.getAggregations().get("sum_bucket");
            )
            InternalSimpleValue sumBucketValue = termsBucket.getAggregations().get("sum_bucket");
                sum += bucket.getDocCount();
import java.util.Collection;  
        assertThat(buckets.size(), equalTo(interval));  
                    .subAggregation(  
            aggTermsSum += aggHistoSum;  
            List<? extends Bucket> buckets = histo.getBuckets();
                            .extendedBounds(minRandomValue, maxRandomValue)
        assertThat(buckets.size(), equalTo(0));  
    public void testNested() throws Exception {
        double aggTermsSum = 0;
        SearchResponse response = client().prepareSearch("idx")  
                    bucketSum += sum.value();  
        }
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));  
            .get();
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            List<? extends Bucket> buckets = histo.getBuckets();
                terms("terms").field("tag")
import org.opensearch.action.search.SearchResponse;
        createIndex("idx_unmapped");
    static int numDocs;
            double bucketSum = 0;
        assertThat(termsBuckets.size(), equalTo(interval));  
                terms("terms").field("tag")
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));  
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.greaterThan;  
    public void testMetricAsSubAgg() throws Exception {
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
    public SumBucketIT(Settings staticSettings) {  
        for (int i = 0; i < numDocs; i++) {
            Histogram histo = termsBucket.getAggregations().get("histo");
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            assertThat(histo.getName(), equalTo("histo"));
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            InternalSimpleValue sumBucketValue = termsBucket.getAggregations().get("sum_bucket");
            for (int j = 0; j < numValueBuckets; ++j) {
 * GitHub history for details.
            Terms.Bucket bucket = buckets.get(i);
                client().prepareIndex("idx")
            assertThat(sumBucketValue, notNullValue());  
        indexRandom(true, builders);
            .addAggregation(sumBucket("sum_bucket", "terms>sum"))  
    public void testDocCountTopLevel() throws Exception {
        assertThat(terms.getName(), equalTo("terms"));  
            for (int j = 0; j < numValueBuckets; ++j) {
            }  
 *  
        assertThat(terms, notNullValue());
        assertThat(termsBuckets.size(), equalTo(interval));  
        SearchResponse response = client().prepareSearch("idx")  
            assertThat(sumBucketValue.value(), equalTo(bucketSum));
/*  
            .addAggregation(
                }
        assertThat(sumBucketValue.value(), equalTo(aggTermsSum));  
            new Object[] {
                assertThat(bucket, notNullValue());
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
        assertThat(terms, notNullValue());  
                assertThat(bucket, notNullValue());  
            for (int j = 0; j < numValueBuckets; ++j) {  
        assertThat(histo.getName(), equalTo("histo"));
 */  
/*  
            assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));
            builders.add(
    public void testDocCountAsSubAgg() throws Exception {  
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
                    .subAggregation(
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
        for (int i = 0; i < numValueBuckets; ++i) {
import java.util.List;
            assertThat(sumBucketValue, notNullValue());
 * SPDX-License-Identifier: Apache-2.0
            assertThat(sumBucketValue, notNullValue());
 * You may obtain a copy of the License at  
                    .order(BucketOrder.key(true))  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
 *
            .addAggregation(sumBucket("sum_bucket", "histo>_count"))
                    .subAggregation(sumBucket("sum_bucket", "histo>sum"))  
        assertThat(termsBuckets.size(), equalTo(interval));
            Terms.Bucket termsBucket = termsBuckets.get(i);
 * KIND, either express or implied.  See the License for the
            new Object[] {  
    public void testNoBuckets() throws Exception {
                    )  
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
            Histogram histo = termsBucket.getAggregations().get("histo");  
            Terms.Bucket termsBucket = termsBuckets.get(i);  
 * this work for additional information regarding copyright
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }  
            List<? extends Bucket> buckets = histo.getBuckets();  
 */  
            .get();
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
import org.opensearch.test.OpenSearchIntegTestCase;
            InternalSimpleValue sumBucketValue = termsBucket.getAggregations().get("sum_histo_bucket");
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
            .addAggregation(  
                            .interval(interval)  
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            for (int j = 0; j < numValueBuckets; ++j) {
                    .subAggregation(
        maxRandomValue = 20;
 * not use this file except in compliance with the License.
            assertThat(bucket.getDocCount(), greaterThan(0L));
                Histogram.Bucket bucket = buckets.get(j);  
        assertThat(sumBucketValue, notNullValue());
                assertThat(bucket, notNullValue());
            assertThat(bucket, notNullValue());
            )
                terms("terms").field("tag")
            Sum sum = bucket.getAggregations().get("sum");
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));  
import org.opensearch.action.index.IndexRequestBuilder;  
            assertThat(sum, notNullValue());  
            assertThat(sumBucketValue.getName(), equalTo("sum_histo_bucket"));  
        assertThat(sumBucketValue.value(), equalTo(0.0));
        assertThat(terms.getName(), equalTo("terms"));
        assertSearchResponse(response);
 * this file be licensed under the Apache-2.0 license or a
            .addAggregation(sumBucket("sum_terms_bucket", "terms>sum_histo_bucket"))  
        Histogram histo = response.getAggregations().get("histo");  
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;  
            .get();  
        }
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
            )
        InternalSimpleValue sumBucketValue = response.getAggregations().get("sum_terms_bucket");  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    public void testMetricTopLevel() throws Exception {  
        minRandomValue = 0;  
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
                if (bucket.getDocCount() != 0) {  
            assertThat(termsBucket, notNullValue());
            assertThat(sumBucketValue.value(), equalTo(bucketSum));
                Sum sum = bucket.getAggregations().get("sum");
            Terms.Bucket termsBucket = termsBuckets.get(i);
        double bucketSum = 0;
            assertThat(termsBucket, notNullValue());  
        }  
package org.opensearch.search.aggregations.pipeline;
        assertSearchResponse(response);
        assertThat(sumBucketValue.value(), equalTo(bucketSum));
        assertThat(sumBucketValue, notNullValue());
        assertSearchResponse(response);  
            Histogram histo = termsBucket.getAggregations().get("histo");
            assertThat(histo, notNullValue());  
        for (int i = 0; i < interval; ++i) {
    }  
 * software distributed under the License is distributed on an
            .get();
import org.opensearch.search.aggregations.BucketOrder;  
        assertThat(sumBucketValue, notNullValue());  
            )
    static int maxRandomValue;
        for (int i = 0; i < interval; ++i) {  
        valueCounts = new long[numValueBuckets];
    }
                            .field("tag", "tag" + (i % interval))  
        assertThat(sumBucketValue, notNullValue());
    @Override
            .addAggregation(sumBucket("sum_bucket", "terms>sum"))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        InternalSimpleValue sumBucketValue = response.getAggregations().get("sum_bucket");
        }
        InternalSimpleValue sumBucketValue = response.getAggregations().get("sum_bucket");  
                    .order(BucketOrder.key(true))
                Histogram.Bucket bucket = buckets.get(j);  
        for (int i = 0; i < interval; ++i) {  
        Terms terms = response.getAggregations().get("terms");  
            .addAggregation(
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;  
        List<IndexRequestBuilder> builders = new ArrayList<>();  
            }
        }
    static long[] valueCounts;
import java.util.ArrayList;
    }
            sum += bucket.getDocCount();  
        assertThat(terms.getName(), equalTo("terms"));
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        }  
            double bucketSum = 0;
        return Arrays.asList(  
                        jsonBuilder().startObject()
        assertThat(terms, notNullValue());  
            assertThat(sumBucketValue, notNullValue());
                    .subAggregation(sumBucket("sum_bucket", "histo>_count"))
import java.util.Arrays;
            assertThat(termsBucket, notNullValue());
            assertThat(bucket, notNullValue());  
    }
                    .subAggregation(
            builders.add(
                    )
        Terms terms = response.getAggregations().get("terms");
        SearchResponse response = client().prepareSearch("idx")  
            InternalSimpleValue sumBucketValue = termsBucket.getAggregations().get("sum_bucket");
        for (int i = 0; i < interval; ++i) {
            Histogram histo = termsBucket.getAggregations().get("histo");
                    .setSource(  
        assertThat(terms, notNullValue());
            assertThat(termsBucket, notNullValue());
        Terms terms = response.getAggregations().get("terms");
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
}
            assertThat(histo.getName(), equalTo("histo"));
        );
        numDocs = randomIntBetween(6, 20);  
import org.opensearch.common.settings.Settings;
                    .subAggregation(sumBucket("sum_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));  
            .get();
        assertSearchResponse(response);  
                    .subAggregation(sumBucket("sum_histo_bucket", "histo>_count"))
            assertThat(sumBucketValue.value(), equalTo(sum));
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
        }
 * The OpenSearch Contributors require contributions made to  
    }
        Terms terms = response.getAggregations().get("terms");
                aggHistoSum += bucket.getDocCount();
            assertThat(histo.getName(), equalTo("histo"));  
            assertThat(histo, notNullValue());
            assertThat(histo.getName(), equalTo("histo"));
            )  
                terms("terms").field("tag")
                    )  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        SearchResponse response = client().prepareSearch("idx")  
                    .order(BucketOrder.key(true))  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            assertThat(sumBucketValue.getName(), equalTo("sum_bucket"));  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
    }
                    )
            assertThat(sumBucketValue.value(), equalTo(aggHistoSum));
        assertSearchResponse(response);  
                            .endObject()
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
                            .interval(interval)
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            );
            assertThat(histo, notNullValue());  
            double sum = 0;  
            List<? extends Bucket> buckets = histo.getBuckets();
            new Object[] {
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            valueCounts[bucket]++;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        ensureSearchable();
        double sum = 0;  
                bucketSum += sum.value();
