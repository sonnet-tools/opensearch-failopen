        int aggTermsCount = 0;
        StatsBucket statsBucketValue = response.getAggregations().get("avg_terms_bucket");  
            }  
                            .extendedBounds(minRandomValue, maxRandomValue)
    public void testMetricAsSubAggWithInsertZeros() throws Exception {
            Terms.Bucket termsBucket = termsBuckets.get(i);
        assertThat(statsBucketValue.getMax(), equalTo(max));
            assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));  
        super(staticSettings);  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
        double min = Double.POSITIVE_INFINITY;  
        assertThat(buckets.size(), equalTo(0));
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.index.IndexRequestBuilder;  
        double avgValue = count == 0 ? Double.NaN : (sum / count);
    public void setupSuiteScopeCluster() throws Exception {
            for (int j = 0; j < numValueBuckets; ++j) {
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            .addAggregation(statsBucket("avg_terms_bucket", "terms>avg_histo_bucket.avg"))
            Histogram histo = termsBucket.getAggregations().get("histo");
    }  
            );
            assertThat(statsBucketValue.getAvg(), equalTo(avgValue));
        return Arrays.asList(
 * not use this file except in compliance with the License.
            )
        assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));
        double min = Double.POSITIVE_INFINITY;
            assertThat(statsBucketValue, notNullValue());  
        SearchResponse response = client().prepareSearch("idx")
        assertThat(terms.getName(), equalTo("terms"));  
            assertThat(termsBucket, notNullValue());
        int count = 0;  
import java.util.Arrays;
        indexRandom(true, builders);  
            List<? extends Bucket> buckets = histo.getBuckets();
            assertThat(statsBucketValue, notNullValue());
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        );  
            assertThat(histo, notNullValue());
        double aggTermsSum = 0;
        assertThat(statsBucketValue.getAvg(), equalTo(avgValue));  
                assertThat(bucket, notNullValue());
                    .order(BucketOrder.key(true))
    public void testMetricAsSubAgg() throws Exception {  
                            .endObject()  
    }
import org.opensearch.search.aggregations.BucketOrder;  
        SearchResponse response = client().prepareSearch("idx")  
            Terms.Bucket termsBucket = termsBuckets.get(i);
                bucketSum += sum.value();
        assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));  
        assertThat(statsBucketValue, notNullValue());
        assertSearchResponse(response);
        double avgTermsValue = aggTermsCount == 0 ? Double.NaN : (aggTermsSum / aggTermsCount);
            double aggHistoSum = 0;  
            double bucketSum = 0;  
import java.util.Collection;  
            for (int j = 0; j < numValueBuckets; ++j) {
            for (int j = 0; j < numValueBuckets; ++j) {
        assertThat(statsBucketValue, notNullValue());
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));  
        assertThat(statsBucketValue.getMin(), equalTo(min));
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_AUTO;  
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_ALL;
            assertThat(bucket, notNullValue());
    }
            assertThat(bucket, notNullValue());
            double min = Double.POSITIVE_INFINITY;
                max = Math.max(max, bucket.getDocCount());
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))
        }
        assertThat(buckets.size(), equalTo(interval));
                    .subAggregation(  
            new Object[] {
            assertThat(histo, notNullValue());
            Sum sum = bucket.getAggregations().get("sum");
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();  
                aggHistoCount++;
 */  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)
            assertThat((String) bucket.getKey(), equalTo("tag" + (i % interval)));
            aggTermsSum += avgHistoValue;  
    public void testDocCountTopLevel() throws Exception {
            int count = 0;
    public void testNoBuckets() throws Exception {
            StatsBucket statsBucketValue = termsBucket.getAggregations().get("stats_bucket");
                    .order(BucketOrder.key(true))
            assertThat(histo, notNullValue());
            for (int j = 0; j < numValueBuckets; ++j) {  
    public void testMetricTopLevel() throws Exception {
            List<? extends Bucket> buckets = histo.getBuckets();  
        assertThat(terms, notNullValue());
public class StatsBucketIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
            .addAggregation(terms("terms").field("tag").subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME)))
            assertThat(termsBucket, notNullValue());
    }
            .addAggregation(
                    min = Math.min(min, sum.value());
                client().prepareIndex("empty_bucket_idx")
            double min = Double.POSITIVE_INFINITY;  
        assertThat(terms, notNullValue());
    public static Collection<Object[]> parameters() {
        minRandomValue = 0;
                min = Math.min(min, bucket.getDocCount());  
            new Object[] {
            assertThat(statsBucketValue.getName(), equalTo("avg_histo_bucket"));
        numDocs = randomIntBetween(6, 20);
/*
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        Terms terms = response.getAggregations().get("terms");
import org.opensearch.action.search.SearchResponse;
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            StatsBucket statsBucketValue = termsBucket.getAggregations().get("stats_bucket");
                        jsonBuilder().startObject()  
    static int numDocs;
    }
                    )  
        Terms terms = response.getAggregations().get("terms");
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
/*  
            assertThat(histo.getName(), equalTo("histo"));
            sum += bucket.getDocCount();  
            int count = 0;  
                    count++;
 * Modifications Copyright OpenSearch Contributors. See
                assertThat(bucket, notNullValue());
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));  
}
        SearchResponse response = client().prepareSearch("idx")
        assertThat(statsBucketValue.getMin(), equalTo(min));
            assertThat(statsBucketValue, notNullValue());
        assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));  
                terms("terms").field("tag")
        assertThat(statsBucketValue.getMin(), equalTo(min));
        assertThat(termsBuckets.size(), equalTo(interval));
            builders.add(  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
            aggTermsCount++;
            min = Math.min(min, bucket.getDocCount());
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
        }
            double min = Double.POSITIVE_INFINITY;
        double bucketSum = 0;
        }
 * You may obtain a copy of the License at  
        StatsBucket statsBucketValue = response.getAggregations().get("stats_bucket");
                            .extendedBounds(minRandomValue, maxRandomValue)  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                    max = Math.max(max, sum.value());
            .get();  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
            double avgHistoValue = aggHistoCount == 0 ? Double.NaN : (aggHistoSum / aggHistoCount);
        StatsBucket statsBucketValue = response.getAggregations().get("stats_bucket");  
        assertSearchResponse(response);
    }
import static org.opensearch.search.aggregations.PipelineAggregatorBuilders.statsBucket;
            assertThat(statsBucketValue.getMax(), equalTo(max));  
import java.util.ArrayList;
            min = Math.min(min, sum.value());
        StatsBucket statsBucketValue = response.getAggregations().get("stats_bucket");
            int aggHistoCount = 0;
        for (int i = 0; i < 2; i++) {
import java.util.List;
        assertThat(terms, notNullValue());
            assertThat(statsBucketValue.getMin(), equalTo(min));  
            assertThat(statsBucketValue.getAvg(), equalTo(avgValue));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        SearchResponse response = client().prepareSearch("idx")  
            assertThat(statsBucketValue.getAvg(), equalTo(avgValue));
            .get();  
    static int minRandomValue;  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
 * this file be licensed under the Apache-2.0 license or a
                Histogram.Bucket bucket = buckets.get(j);  
        for (int i = 0; i < interval; ++i) {
            .addAggregation(
                terms("terms").field("tag")
        assertThat(terms.getName(), equalTo("terms"));
        List<? extends Bucket> buckets = histo.getBuckets();
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;  
            Histogram histo = termsBucket.getAggregations().get("histo");
            .addAggregation(statsBucket("stats_bucket", "terms>sum"))
            StatsBucket statsBucketValue = termsBucket.getAggregations().get("avg_histo_bucket");  
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("tag", "type=keyword").get());
        Terms terms = response.getAggregations().get("terms");
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
        assertThat(statsBucketValue.getAvg(), equalTo(avgValue));
            builders.add(  
        assertSearchResponse(response);  
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);  
            double avgValue = count == 0 ? Double.NaN : (sum / count);
                Sum sum = bucket.getAggregations().get("sum");  
        for (int i = 0; i < interval; ++i) {  
        Terms terms = response.getAggregations().get("terms");
                            .interval(interval)
    public void testNested() throws Exception {
        createIndex("idx_unmapped");  
 *
import org.opensearch.test.OpenSearchIntegTestCase;
            max = Math.max(max, bucket.getDocCount());
            count++;
        }  
                    Sum sum = bucket.getAggregations().get("sum");  
                    .subAggregation(statsBucket("stats_bucket", "histo>sum"))
        }
            )  
            .addAggregation(  
            valueCounts[bucket]++;
                    .setSource(
                            .field("tag", "tag" + (i % interval))
 * the Apache License, Version 2.0 (the "License"); you may
            min = Math.min(min, avgHistoValue);
import org.opensearch.common.settings.Settings;
                    .subAggregation(
        SearchResponse response = client().prepareSearch("idx")
                client().prepareIndex("idx")
        assertSearchResponse(response);  
            )
        assertThat(statsBucketValue.getMax(), equalTo(max));
            assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));  
        SearchResponse response = client().prepareSearch("idx")
            }
            assertThat(statsBucketValue.getMax(), equalTo(max));
            final int bucket = (fieldValue / interval); // + (fieldValue < 0 ? -1 : 0) - (minRandomValue / interval - 1);  
            .addAggregation(statsBucket("stats_bucket", "histo>_count"))  
 *    http://www.apache.org/licenses/LICENSE-2.0
                            .interval(interval)
        maxRandomValue = 20;  
 * GitHub history for details.
    static int maxRandomValue;
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())  
        }
                    .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))  
            int count = 0;
            .get();
            assertThat(histo.getName(), equalTo("histo"));  
 * Unless required by applicable law or agreed to in writing,
            )
                assertThat(bucket, notNullValue());  
                assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) j * interval));
                    )
                terms("terms").field("tag")
            Terms.Bucket termsBucket = termsBuckets.get(i);  
        assertThat(statsBucketValue, notNullValue());
                    .order(BucketOrder.key(true))  
        Terms terms = response.getAggregations().get("terms");
    static int interval;
            Histogram.Bucket bucket = buckets.get(i);
 * under the License.  
                Histogram.Bucket bucket = buckets.get(j);  
                sum += bucket.getDocCount();
 * license agreements. See the NOTICE file distributed with
        assertThat(termsBuckets.size(), equalTo(interval));
    public StatsBucketIT(Settings staticSettings) {
            assertThat(histo, notNullValue());  
            count++;  
                assertThat(bucket, notNullValue());
    }  
            assertThat(statsBucketValue.getName(), equalTo("stats_bucket"));
            Terms.Bucket bucket = buckets.get(i);  
                count++;
                if (bucket.getDocCount() != 0) {
        for (int i = 0; i < interval; ++i) {
    static long[] valueCounts;  
            assertThat(histo.getName(), equalTo("histo"));
            bucketSum += sum.value();
        int count = 0;
            assertThat(statsBucketValue.getMax(), equalTo(max));  
        SearchResponse response = client().prepareSearch("idx")
    }
    @Override  
        assertSearchResponse(response);
import static org.hamcrest.Matchers.greaterThan;  
            Histogram histo = termsBucket.getAggregations().get("histo");
        numValueBuckets = ((maxRandomValue - minRandomValue) / interval) + 1;
                terms("terms").field("tag")
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
                            .subAggregation(sum("sum").field(SINGLE_VALUED_FIELD_NAME))  
            assertThat(sum, notNullValue());
            )
                max = Math.max(max, sum.value());  
 *  
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        for (int i = 0; i < numValueBuckets; ++i) {  
            assertThat(bucket.getDocCount(), equalTo(valueCounts[i]));
import static org.hamcrest.core.IsNull.notNullValue;
            double max = Double.NEGATIVE_INFINITY;
                aggHistoSum += bucket.getDocCount();
                Histogram.Bucket bucket = buckets.get(j);
            Terms.Bucket termsBucket = termsBuckets.get(i);  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_MODE_NONE;
        assertThat(terms.getName(), equalTo("terms"));  
        assertSearchResponse(response);
            Histogram histo = termsBucket.getAggregations().get("histo");  
        }
            .get();  
        double avgValue = count == 0 ? Double.NaN : (bucketSum / count);  
 * KIND, either express or implied.  See the License for the
            assertThat(termsBucket, notNullValue());  
        assertThat(terms, notNullValue());  
        assertThat(terms, notNullValue());
            double avgValue = count == 0 ? Double.NaN : (bucketSum / count);  
                    .subAggregation(  
            double bucketSum = 0;
    @ParametersFactory  
            assertThat(statsBucketValue, notNullValue());
        double sum = 0;
    static int numValueBuckets;
 */  
        Histogram histo = response.getAggregations().get("histo");
            double max = Double.NEGATIVE_INFINITY;
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
            }
        assertThat(termsBuckets.size(), equalTo(interval));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE;
        Terms terms = response.getAggregations().get("terms");  
                    .subAggregation(statsBucket("avg_histo_bucket", "histo>_count"))  
                    )
            .addAggregation(  
                count++;  
        assertThat(terms.getName(), equalTo("terms"));  
import org.opensearch.search.aggregations.bucket.terms.Terms;
        interval = randomIntBetween(2, 5);  
        assertThat(histo.getName(), equalTo("histo"));
                    )
                histogram("histo").field(SINGLE_VALUED_FIELD_NAME).interval(interval).extendedBounds(minRandomValue, maxRandomValue)
            assertThat(statsBucketValue.getMin(), equalTo(min));
import org.opensearch.search.aggregations.metrics.Sum;
            .get();  
            .addAggregation(statsBucket("stats_bucket", "terms>sum"))
/*  
 * SPDX-License-Identifier: Apache-2.0
                    assertThat(sum, notNullValue());
package org.opensearch.search.aggregations.pipeline;
        assertThat(statsBucketValue.getName(), equalTo("avg_terms_bucket"));
    }
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_NONE).build() }
                }  
            List<? extends Bucket> buckets = histo.getBuckets();
 */
                            .field(SINGLE_VALUED_FIELD_NAME, fieldValue)
                    .includeExclude(new IncludeExclude(null, "tag.*"))
        for (int i = 0; i < interval; ++i) {
        double max = Double.NEGATIVE_INFINITY;
        assertAcked(prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer"));
                    .subAggregation(statsBucket("stats_bucket", "histo>_count"))
        assertThat(statsBucketValue.getAvg(), equalTo(avgTermsValue));  
        assertThat(terms.getName(), equalTo("terms"));
            }
        assertSearchResponse(response);
            assertThat(termsBucket, notNullValue());
 * compatible open source license.
            assertThat(histo.getName(), equalTo("histo"));  
        assertThat(terms, notNullValue());
                    .subAggregation(statsBucket("stats_bucket", "histo>sum").gapPolicy(GapPolicy.INSERT_ZEROS))  
        ensureSearchable();
                    .setId("" + i)
        assertThat(terms.getName(), equalTo("terms"));  
        }  
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_ALL).build() },
    public void testDocCountAsSubAgg() throws Exception {
@OpenSearchIntegTestCase.SuiteScopeTestCase  
                    .order(BucketOrder.key(true))
        double max = Double.NEGATIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
                min = Math.min(min, sum.value());
                terms("terms").field("tag")  
        assertThat(histo, notNullValue());  
                    .subAggregation(
            StatsBucket statsBucketValue = termsBucket.getAggregations().get("stats_bucket");
            max = Math.max(max, sum.value());  
    }  
        assertThat(termsBuckets.size(), equalTo(interval));  
        assertThat(buckets.size(), equalTo(numValueBuckets));  
            assertThat(statsBucketValue.getMin(), equalTo(min));
                    bucketSum += sum.value();  
            double sum = 0;
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        List<? extends Terms.Bucket> termsBuckets = terms.getBuckets();
            new Object[] {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.equalTo;
            max = Math.max(max, avgHistoValue);
            )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            double max = Double.NEGATIVE_INFINITY;  
                    )
                Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_MODE.getKey(), CONCURRENT_SEGMENT_SEARCH_MODE_AUTO).build() },  
        assertThat(statsBucketValue.getAvg(), equalTo(Double.NaN));
        for (int i = 0; i < numDocs; i++) {
            .addAggregation(  
    private static final String SINGLE_VALUED_FIELD_NAME = "l_value";  
                assertThat(sum, notNullValue());
 *
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            assertThat((String) termsBucket.getKey(), equalTo("tag" + (i % interval)));
            .addAggregation(  
            .get();
            .get();
            int fieldValue = randomIntBetween(minRandomValue, maxRandomValue);
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(statsBucketValue.getMax(), equalTo(max));  
                        histogram("histo").field(SINGLE_VALUED_FIELD_NAME)  
        assertThat(statsBucketValue, notNullValue());
 * this work for additional information regarding copyright
        List<IndexRequestBuilder> builders = new ArrayList<>();
            assertThat(bucket.getDocCount(), greaterThan(0L));  
        double min = Double.POSITIVE_INFINITY;  
            List<? extends Bucket> buckets = histo.getBuckets();
            );
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        valueCounts = new long[numValueBuckets];  
                Histogram.Bucket bucket = buckets.get(j);
            assertThat(((Number) bucket.getKey()).longValue(), equalTo((long) i * interval));  
        for (int i = 0; i < interval; ++i) {
            assertThat(statsBucketValue.getAvg(), equalTo(avgHistoValue));  
