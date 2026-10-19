        prepareCreate("old_index").setMapping(
        assertThat(sum.getName(), equalTo("sum"));  
        } finally {  
import org.opensearch.search.aggregations.bucket.filter.Filter;
            .setQuery(matchAllQuery())  
        Sum sum = searchResponse.getAggregations().get("sum");
    }
        assertThat(sum, IsNull.notNullValue());
            long expectedSum = 0;  
        assertThat(sum.getValue(), equalTo(expectedSumValue));
            }
        return Arrays.asList(
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        }
    }  
        builders.add(client().prepareIndex("new_index").setSource("transit_mode", "train", "route_length_miles", 100.2));
        );
 * specific language governing permissions and limitations
import org.opensearch.script.ScriptType;
import java.util.List;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
            )
    public void testSingleValuedFieldGetProperty() throws Exception {  
        assertThat(bucket.getKey(), equalTo("train"));
        assertThat(buckets.size(), equalTo(2));  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(sum.getValue(), equalTo((double) 2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12));  
    public void testSingleValuedFieldWithFormatter() throws Exception {
        assertThat(sum, notNullValue());
            equalTo(0L)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                .prepareStats("cache_test_idx")  
            assertThat(sum, notNullValue());
                Settings.builder()
        Histogram histo = searchResponse.getAggregations().get("histo");
     * Make sure that a request using a deterministic script or not using a script get cached.
    public void testSumWithIntraSegmentPartitioning() throws Exception {  
                .setRequestCache(true)
                .prepareStats("cache_test_idx")
    @Override
        SearchResponse response = client().prepareSearch("old_index", "new_index")  
            equalTo(1L)  
    @ParametersFactory  
        SearchResponse r = client().prepareSearch("cache_test_idx")  
        assertThat(bucket, notNullValue());  
                .get()
 *  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
        builders.add(client().prepareIndex("old_index").setSource("transit_mode", "train", "distance", 42.0));  
        sum = bucket.getAggregations().get("sum");
            "type=keyword",  
                .get()  
        assertHitCount(searchResponse, 10);
        assertSearchResponse(r);
    public void testUnmapped() throws Exception {}  
        builders.add(client().prepareIndex("old_index").setSource("transit_mode", "bus", "distance", 50.5));
        );
                .getTotal()
        assertAcked(  
        assertThat(bucket, notNullValue());
        );
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
                .getMissCount(),  
        bucket = buckets.get(1);
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
    public void testFieldAliasInSubAggregation() {  
        try {
        // Test that a request using a nondeterministic script does not get cached
        assertThat(terms.getName(), equalTo("terms"));  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
import org.hamcrest.core.IsNull;
        assertThat(  
                .prepareStats("cache_test_idx")
 * this file be licensed under the Apache-2.0 license or a
        assertThat(sum.getValue(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
        assertThat(  
        assertThat((double) ((InternalAggregation) sum).getProperty("value"), equalTo(expectedSumValue));
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
                .prepareStats("cache_test_idx")
                .getHitCount(),
            .setQuery(matchAllQuery())
            .setQuery(matchAllQuery())  
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
    @Override
        assertThat(sum.getValue(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
            .get();
                .indices()
            equalTo(0L)
        r = client().prepareSearch("cache_test_idx")
 * software distributed under the License is distributed on an
    }
    }
public class SumIT extends AbstractNumericTestCase {  
        assertThat(
        assertThat(sum.getName(), equalTo("sum"));  
                .setRequestCache(true)
        double expectedSumValue = (double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
        assertHitCount(searchResponse, 10);
                .getRequestCache()  
                .getRequestCache()  
/*  
                .getTotal()
                .get()
            )
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
                .indices()  
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.METRIC_SCRIPT_ENGINE;
                .get()  
            Terms.Bucket bucket = buckets.get(i);
                .getTotal()  
 */
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)  
            .get();
        assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(histo, notNullValue());  
        Sum sum = searchResponse.getAggregations().get("sum");
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
        indexRandom(true, builders);
                .indices()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
                .getTotal()  
        assertThat(sum, notNullValue());
 * this work for additional information regarding copyright
                .setRequestCache(true)
                .indices()  
        );
            Sum sum = filter.getAggregations().get("sum");  
                builders.add(client().prepareIndex("test_sum_agg").setSource("value", i + 1));
        Sum sum = bucket.getAggregations().get("sum");
    }  
            client().admin()  
        assertSearchResponse(r);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            assertThat(sumAgg, notNullValue());
            .addAggregation(sum("sum").field("route_length_miles"))
                .get()  
        assertSearchResponse(response);
        // one, and a concrete field in the other.  
            indexRandomForConcurrentSearch("test_sum_agg");
            .setSize(0)
        assertThat(  
        return Collections.singleton(MetricAggScriptPlugin.class);
        SearchResponse searchResponse = client().prepareSearch("idx")
            client().admin()
import org.opensearch.action.search.SearchResponse;  
import java.util.Collection;  
            .setQuery(matchAllQuery())  
        assertThat(sum.getValue(), equalTo(192.7));  
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
    public void testEmptyAggregation() throws Exception {  
        ensureSearchable();
                .getHitCount(),  
                .getMissCount(),
        );  
            .addAggregation(histogram("histo").field("value").interval(1L).minDocCount(0).subAggregation(sum("sum").field("value")))
            .get();
                .getRequestCache()
            .get();  
                .getHitCount(),  
        assertThat(buckets.size(), equalTo(10));
    @Override
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.VALUE_SCRIPT;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
 * not use this file except in compliance with the License.
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
        assertThat(sum.getName(), equalTo("sum"));  
    @Override
    }  
                .setRequestCache(true)  
        Global global = searchResponse.getAggregations().get("global");  
        Sum sum = response.getAggregations().get("sum");  
        assertThat(bucket.getDocCount(), equalTo(1L));
                .getTotal()
        indexRandom(
import static org.hamcrest.Matchers.closeTo;
                .prepareStats("cache_test_idx")
            client().admin()
                .indices()
        Sum sum = searchResponse.getAggregations().get("sum");  
            equalTo(0L)  
                sum("foo").field("d").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, VALUE_SCRIPT, Collections.emptyMap()))
            equalTo(2L)  
            assertThat(filter, notNullValue());
        createIndex("test_sum_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());
        assertThat(sum, notNullValue());
        assertThat(bucket.getKey(), equalTo("bus"));
            .addAggregation(terms("terms").field("transit_mode").subAggregation(sum("sum").field("route_length_miles")))
        );
    public void setupSuiteScopeCluster() throws Exception {
                .get()
        assertThat(global.getName(), equalTo("global"));
        Terms terms = response.getAggregations().get("terms");
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
import org.opensearch.search.aggregations.bucket.global.Global;
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
            "route_length_miles",  
import org.opensearch.script.Script;  
import static org.hamcrest.Matchers.notNullValue;
    public void testSingleValuedField() throws Exception {  
                .getRequestCache()
import java.util.Collections;
            new Object[] {  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
import org.opensearch.search.aggregations.InternalAggregation;  
            )  
import org.opensearch.plugins.Plugin;
            for (int i = 0; i < 5000; i++) {
                .getRequestCache()
                .setRequestCache(true)
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(sum("foo").field("d")).get();
            Sum sumAgg = response.getAggregations().get("sum");  
            .setQuery(matchAllQuery())  
/*
import org.opensearch.common.settings.Settings;
            "distance",
                .getTotal()
        assertHitCount(searchResponse, 10);  
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat((double) ((InternalAggregation) global).getProperty("sum.value"), equalTo(expectedSumValue));
            .setQuery(matchAllQuery())
        assertThat(sum.getValue(), equalTo(142.2));  
            .addAggregation(
import java.util.ArrayList;
    public void testOrderByEmptyAggregation() throws Exception {
        prepareCreate("new_index").setMapping("transit_mode", "type=keyword", "route_length_miles", "type=double").get();  
        Sum sum = bucket.getAggregations().get("sum");
        assertThat(
        Terms terms = searchResponse.getAggregations().get("terms");
            indexBulkWithSegments(builders, 2);  
    @Override
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
                .getMissCount(),
    }
import static org.opensearch.search.aggregations.AggregationBuilders.filter;  
        assertThat(sum, notNullValue());  
        assertThat(sum, notNullValue());
                .getMissCount(),
        );  
            client().admin()
        assertThat(
import org.opensearch.search.aggregations.BucketOrder;
        assertSearchResponse(r);  
            .addAggregation(sum("sum").format("0000.0").field("value"))
    public void testScriptCaching() throws Exception {
        assertThat(buckets, notNullValue());
import static org.opensearch.index.query.QueryBuilders.termQuery;
import org.opensearch.search.aggregations.bucket.terms.Terms;
        );
    public static Collection<Object[]> parameters() {
import java.util.Arrays;
                    .build() }
    @Override
        super.setupSuiteScopeCluster();  
        assertThat(global.getDocCount(), equalTo(10L));  
    public SumIT(Settings staticSettings) {
        SearchResponse searchResponse = client().prepareSearch("idx")
            "type=alias,path=distance"
 */  
 * GitHub history for details.
 *
            .get();  
 *
    }  
import static org.hamcrest.Matchers.equalTo;  
            equalTo(0L)
                .indices()  
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>sum", true)))  
            .get();  
            internalCluster().wipeIndices("test_sum_agg");
                    .subAggregation(filter("filter", termQuery("value", 100)).subAggregation(sum("sum").field("value")))
            assertThat(bucket.getDocCount(), equalTo(1L));
            client().admin()
                .indices()
        assertThat(sum.getName(), equalTo("sum"));
                .getRequestCache()
            .get();
    }
        for (int i = 0; i < 10; i++) {
            equalTo(0L)
            "type=double",
                .get()  
        List<IndexRequestBuilder> builders = new ArrayList<>();
 */
            .addAggregation(sum("sum").field("value"))  
        Sum sum = global.getAggregations().get("sum");
        assertThat(global.getAggregations(), notNullValue());
                .getTotal()  
    }
            .get();
            .addAggregation(sum("sum").field("values"))
            "transit_mode",
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
        assertThat(sum.getName(), equalTo("sum"));
        assertThat(global, notNullValue());
                .prepareStats("cache_test_idx")  
    /** This test has been moved to {@link SumAggregatorTests#testUnmapped()} */
            client().admin()
                .getRequestCache()
            assertThat(bucket, notNullValue());  
        assertThat(bucket, notNullValue());  
        assertThat(terms, notNullValue());
                expectedSum += (i + 1);  
        SearchResponse searchResponse = client().prepareSearch("idx")
    }
        assertThat(terms, notNullValue());
        internalCluster().wipeIndices("cache_test_idx");
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.RANDOM_SCRIPT;  
                terms("terms").field("value")
    }  
    public void testMultiValuedField() throws Exception {  
import org.opensearch.action.index.IndexRequestBuilder;
        );
        assertThat(sum, notNullValue());
        SearchResponse searchResponse = client().prepareSearch("idx")  
        // Ensure that non-scripted requests are cached as normal  
        ).get();
        assertThat(sum.getName(), equalTo("sum"));
            .addAggregation(global("global").subAggregation(sum("sum").field("value")))
    /**
 * The OpenSearch Contributors require contributions made to  
                .prepareStats("cache_test_idx")
        assertThat(
                .setRequestCache(true)  
        assertThat((Sum) ((InternalAggregation) global).getProperty("sum"), equalTo(sum));  
        Histogram.Bucket bucket = histo.getBuckets().get(1);
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        // Test that a request using a deterministic script gets cached
    }  
            .get();
                .prepareStats("cache_test_idx")  
                .getTotal()
            client().admin()
 * You may obtain a copy of the License at  
        Terms.Bucket bucket = buckets.get(0);
                .getRequestCache()
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
            client().admin()  
                .get()
 * compatible open source license.
        assertThat(sum.getValueAsString(), equalTo("0055.0"));
     * Ensure requests using nondeterministic scripts do not get cached.  
        assertSearchResponse(response);
        // Create two indices and add the field 'route_length_miles' as an alias in
            assertThat(sum.value(), equalTo(0.0));
 * KIND, either express or implied.  See the License for the
    @Override  
        assertHitCount(searchResponse, 10);
package org.opensearch.search.aggregations.metrics;
 * Modifications Copyright OpenSearch Contributors. See  
        }
 * Unless required by applicable law or agreed to in writing,
        assertThat(
     */
    }  
        assertThat(sum.getValue(), equalTo(50.5));  
        // Make sure we are starting with a clear cache
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
            assertThat(sumAgg.getValue(), closeTo((double) expectedSum, 0.1));
            .get();
                sum("foo").field("d").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, RANDOM_SCRIPT, Collections.emptyMap()))  
    public void testFieldAlias() {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            true,  
            .addAggregation(
        assertHitCount(searchResponse, 10);
            assertThat(filter.getDocCount(), equalTo(0L));
            .addAggregation(
        SearchResponse response = client().prepareSearch("old_index", "new_index")
                .setRequestCache(true)
            SearchResponse response = client().prepareSearch("test_sum_agg").addAggregation(sum("sum").field("value")).get();
        super(staticSettings);  
}
 * under the License.  
            .setSize(0)  
                .getHitCount(),
                .get()
            Filter filter = bucket.getAggregations().get("filter");  
        );
/*
                .setRequestCache(true)
        assertThat(sum.getValue(), equalTo(0.0));
 * the Apache License, Version 2.0 (the "License"); you may
                .indices()
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);
            equalTo(0L)
        assertThat(sum, notNullValue());
        );  
