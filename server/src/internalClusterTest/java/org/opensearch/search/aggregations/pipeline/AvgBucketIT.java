/*  
                client().prepareIndex("empty_bucket_idx")
                    .subAggregation(
        double aggTermsSum = 0;
                            .extendedBounds(minRandomValue, maxRandomValue)  
import org.opensearch.test.OpenSearchIntegTestCase;
            bucketSum += sum.value();  
        Histogram histo = response.getAggregations().get("histo");  
                Histogram.Bucket bucket = buckets.get(j);
    }  
            assertThat(termsBucket, notNullValue());
            double bucketSum = 0;
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
            List<? extends Bucket> buckets = histo.getBuckets();  
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
        assertThat(avgBucketValue.value(), equalTo(avgValue));
            assertThat(bucket, notNullValue());
import org.opensearch.search.aggregations.metrics.Sum;
                Histogram.Bucket bucket = buckets.get(j);  
                    .subAggregation(  
        maxRandomValue = 20;
                    )
 * specific language governing permissions and limitations
            assertThat(avgBucketValue.value(), equalTo(avgValue));
            .addAggregation(avgBucket("avg_bucket", "histo>_count"))
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            Histogram.Bucket bucket = buckets.get(i);  
        createIndex("idx_unmapped");
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            Histogram histo = termsBucket.getAggregations().get("histo");
        assertSearchResponse(response);  
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);  
                terms("terms").field("tag")  
                assertThat(bucket, notNullValue());
        assertThat(buckets.size(), equalTo(0));  
            )
            assertThat(avgBucketValue.value(), equalTo(avgHistoValue));
            assertThat(bucket, notNullValue());  
        assertSearchResponse(response);  
        }  
            assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));  
        Terms terms = response.getAggregations().get("terms");
        assertThat(terms.getName(), equalTo("terms"));
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
                count++;  
        double avgTermsValue = aggTermsCount == 0 ? Double.NaN : (aggTermsSum / aggTermsCount);
        super(staticSettings);
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;  
            new Object[] {
            assertThat(histo, notNullValue());
        InternalSimpleValue avgBucketValue = response.getAggregations().get("avg_terms_bucket");  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        assertThat(avgBucketValue.value(), equalTo(Double.NaN));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;  
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));  
                assertThat(bucket, notNullValue());
}
                    .subAggregation(avgBucket("avg_bucket", "histo>_count"))
        for (int i = 0; i < numValueBuckets; ++i) {
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.avgBucket;
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));
        assertThat(buckets.size(), equalTo(numValueBuckets));
                    assertThat(sum, notNullValue());  
            List<? extends Bucket> buckets = histo.getBuckets();
            List<? extends Bucket> buckets = histo.getBuckets();  
            assertThat(avgBucketValue, notNullValue());
            Histogram histo = termsBucket.getAggregations().get("histo");  
                count++;
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
                    Sum sum = bucket.getAggregations().get("sum");
 *
        assertSearchResponse(response);
            sum += bucket.getDocCount();
                    .order(BucketOrder.key(true))
 * Modifications Copyright OpenSearch Contributors. See
                    )  
import org.opensearch.action.index.IndexRequestBuilder;  
        assertThat(avgBucketValue.value(), equalTo(avgValue));  
            assertThat(avgBucketValue, notNullValue());
        }
            assertThat(sum, notNullValue());
            );
        for (int i = 0; i < interval; ++i) {
        assertThat(avgBucketValue, notNullValue());
    public void testNoBuckets() throws Exception {
        }  
                terms("terms").field("tag")
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        assertThat(avgBucketValue, notNullValue());
            double avgValue = count == 0 ? Double.NaN : (sum / count);
        InternalSimpleValue avgBucketValue = response.getAggregations().get("avg_bucket");
 * the Apache License, Version 2.0 (the "License"); you may
                    bucketSum += sum.value();
        for (int i = 0; i < interval; ++i) {
    public void testMetricTopLevel() throws Exception {  
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(terms, notNullValue());  
import static org.hamcrest.Matchers.greaterThan;  
    static int numValueBuckets;  
                aggHistoSum += bucket.getDocCount();
            .get();
            .addAggregation(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 */
        double bucketSum = 0;
            aggTermsCount++;
        assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));
            builders.add(
 * license agreements. See the NOTICE file distributed with
                            .interval(interval)  
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            valueCounts[bucket]++;
            .get();
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
    public static Collection<Object[]> parameters() {
                    .subAggregation(avgBucket("avg_histo_bucket", "histo>_count"))
            .addAggregation(
    }  
                terms("terms").field("tag")
 * GitHub history for details.
        assertThat(terms.getName(), equalTo("terms"));  
            .addAggregation(
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            )
import java.util.Arrays;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
import java.util.Collection;  
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);  
        int aggTermsCount = 0;  
    }  
        }  
        assertThat(avgBucketValue.value(), equalTo(avgTermsValue));  
        SearchResponse response = client().prepareSearch("idx")  
            for (int j = 0; j < numValueBuckets; ++j) {
            );  
 * The OpenSearch Contributors require contributions made to  
        Terms terms = response.getAggregations().get("terms");
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            }
                if (bucket.getDocCount() != 0) {
            .addAggregation(avgBucket("avg_terms_bucket", "terms>avg_histo_bucket"))  
    }
            count++;
            int aggHistoCount = 0;  
            }
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)  
        int count = 0;
            InternalSimpleValue avgBucketValue = termsBucket.getAggregations().get("avg_bucket");
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(terms, notNullValue());
                            .field("tag", "tag" + (i % interval))  
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);
                }  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
    static int interval;  
        }
        assertThat(avgBucketValue, notNullValue());  
            .addAggregation(
            .addAggregation(
        assertThat(buckets.size(), equalTo(interval));  
        double avgValue = count == 0 ? Double.NaN : (sum / count);
                    .subAggregation(
        assertSearchResponse(response);  
            assertThat(avgBucketValue.value(), equalTo(avgValue));
        assertThat(termsBuckets.size(), equalTo(interval));  
            assertThat(avgBucketValue.getName(), equalTo("avg_histo_bucket"));
            .get();
        assertThat(terms, notNullValue());  
            .get();  
            Terms.Bucket termsBucket = termsBuckets.get(i);  
            double bucketSum = 0;
        assertThat(histo.getName(), equalTo("histo"));
        SearchResponse response = client().prepareSearch("idx")
            double avgHistoValue = aggHistoCount == 0 ? Double.NaN : (aggHistoSum / aggHistoCount);
        int count = 0;  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            assertThat(termsBucket, notNullValue());  
    @Override
        List<? extends Bucket> buckets = histo.getBuckets();  
 * under the License.  
 *
                sum += bucket.getDocCount();
import org.opensearch.action.search.SearchResponse;
/*  
            builders.add(
            .get();
        SearchResponse response = client().prepareSearch("idx")
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);  
            InternalSimpleValue avgBucketValue = termsBucket.getAggregations().get("avg_histo_bucket");
 *  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },
            .addAggregation(  
            Histogram histo = termsBucket.getAggregations().get("histo");
    public void testDocCountAsSubAgg() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
            assertThat(avgBucketValue, notNullValue());  
                    .setSource(  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                            .interval(interval)
            Histogram histo = termsBucket.getAggregations().get("histo");  
import org.opensearch.common.settings.Settings;
                    .includeExclude(new IncludeExclude(null, "tag.*"))  
            double sum = 0;  
        assertThat(termsBuckets.size(), equalTo(interval));
                    )
            )
            assertThat(histo.getName(), equalTo("histo"));
 * compatible open source license.
            assertThat(histo.getName(), equalTo("histo"));
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
        assertThat(terms.getName(), equalTo("terms"));
    static int numDocs;
            )  
            }
        assertThat(terms, notNullValue());
                client().prepareIndex("idx")
            InternalSimpleValue avgBucketValue = termsBucket.getAggregations().get("avg_bucket");
        valueCounts = new long[numValueBuckets];
        SearchResponse response = client().prepareSearch("idx")
        InternalSimpleValue avgBucketValue = response.getAggregations().get("avg_bucket");
            }
            assertThat(histo, notNullValue());
        interval = randomIntBetween(2, 5);
                        jsonBuilder().startObject()
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        numDocs = randomIntBetween(6, 20);  
package org.opensearch.search.aggregations.pipeline;
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
            assertThat(histo, notNullValue());  
/*
                aggHistoCount++;  
                Sum sum = bucket.getAggregations().get("sum");
            )
    }
        assertThat(histo, notNullValue());
    static int maxRandomValue;
    }
            InternalSimpleValue avgBucketValue = termsBucket.getAggregations().get("avg_bucket");
            .addAggregation(avgBucket("avg_bucket", "terms>sum"))  
                terms("terms").field("tag")
                Histogram.Bucket bucket = buckets.get(j);
            double aggHistoSum = 0;
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";  
        assertThat(terms, notNullValue());  
        minRandomValue = 0;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
 * not use this file except in compliance with the License.
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        assertSearchResponse(response);
        assertThat(avgBucketValue, notNullValue());
        }
    static long[] valueCounts;
 */  
 * KIND, either express or implied.  See the License for the
            )  
@OpenSearchIntegTestCase.SuiteScopeTestCase  
        ensureSearchable();
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;  
        for (int i = 0; i < 2; i++) {  
            for (int j = 0; j < numValueBuckets; ++j) {
            int count = 0;  
        Terms terms = response.getAggregations().get("terms");
            assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));  
        assertThat(termsBuckets.size(), equalTo(interval));  
            int count = 0;
            Terms.Bucket termsBucket = termsBuckets.get(i);
            aggTermsSum += avgHistoValue;
 *    http://www.apache.org/licenses/LICENSE-2.0
            int count = 0;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.BucketOrder;  
            assertThat(histo.getName(), equalTo("histo"));  
            Terms.Bucket bucket = buckets.get(i);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                assertThat(sum, notNullValue());  
        assertThat(avgBucketValue.getName(), equalTo("avg_terms_bucket"));
 * Unless required by applicable law or agreed to in writing,
        Terms terms = response.getAggregations().get("terms");
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
        assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));  
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        assertSearchResponse(response);  
    }
            assertThat(histo.getName(), equalTo("histo"));
            assertThat(avgBucketValue, notNullValue());  
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
    public void testMetricAsSubAgg() throws Exception {
        double sum = 0;  
        SearchResponse response = client().prepareSearch("idx")  
                    .subAggregation(
    @ParametersFactory
        indexRandom(true, builders);
import org.opensearch.search.aggregations.bucket.terms.Terms;
        SearchResponse response = client().prepareSearch("idx")  
 */  
                    count++;
        InternalSimpleValue avgBucketValue = response.getAggregations().get("avg_bucket");  
                    )  
        for (int i = 0; i < numDocs; i++) {
                    )
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
                            .extendedBounds(minRandomValue, maxRandomValue)
            Terms.Bucket termsBucket = termsBuckets.get(i);
                    .subAggregation(avgBucket("avg_bucket", "histo>sum"))  
            new Object[] {  
    }
            .addAggregation(avgBucket("avg_bucket", "terms>sum"))  
        }  
 * You may obtain a copy of the License at  
            for (int j = 0; j < numValueBuckets; ++j) {  
    public void testNested() throws Exception {
    static int minRandomValue;
import java.util.ArrayList;
        for (int i = 0; i < interval; ++i) {
                Histogram.Bucket bucket = buckets.get(j);
        assertThat(terms.getName(), equalTo("terms"));
    }
            .get();
                            .endObject()
import java.util.List;
                    .order(BucketOrder.key(true))
 * Licensed to Elasticsearch under one or more contributor  
                assertThat(bucket, notNullValue());  
        assertSearchResponse(response);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        return Arrays.asList(  
            assertThat(avgBucketValue.value(), equalTo(avgValue));
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
        assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));
import static org.hamcrest.core.IsNull.notNullValue;
            count++;
                bucketSum += sum.value();  
        SearchResponse response = client().prepareSearch("idx")  
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
            new Object[] {
        );
                assertThat(bucket, notNullValue());  
 * this work for additional information regarding copyright
                terms("terms").field("tag")
        List<IndexRequestBuilder> builders = new ArrayList<>();  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }  
        assertThat(terms, notNullValue());  
                    .order(BucketOrder.key(true))  
            assertThat(termsBucket, notNullValue());  
        for (int i = 0; i < interval; ++i) {
            .get();
        assertThat(termsBuckets.size(), equalTo(interval));
    public void testDocCountTopLevel() throws Exception {
        Terms terms = response.getAggregations().get("terms");
            for (int j = 0; j < numValueBuckets; ++j) {
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
        Terms terms = response.getAggregations().get("terms");  
            Terms.Bucket termsBucket = termsBuckets.get(i);
            assertThat(histo, notNullValue());
                    .setId("" + i)  
    public AvgBucketIT(Settings staticSettings) {  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));  
            assertThat(bucket.getDocCount(), greaterThan(0L));
        for (int i = 0; i < interval; ++i) {  
                    .subAggregation(avgBucket("avg_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))
        }  
    public void setupSuiteScopeCluster() throws Exception {
            assertThat(termsBucket, notNullValue());
            Sum sum = bucket.getAggregations().get("sum");  
public class AvgBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            assertThat(avgBucketValue.getName(), equalTo("avg_bucket"));
                    .order(BucketOrder.key(true))  
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
        double avgValue = count == 0 ? Double.NaN : (bucketSum / count);  
        assertThat(terms.getName(), equalTo("terms"));
            List<? extends Bucket> buckets = histo.getBuckets();
