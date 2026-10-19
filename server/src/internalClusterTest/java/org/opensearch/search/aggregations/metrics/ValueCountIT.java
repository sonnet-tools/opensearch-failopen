 * this work for additional information regarding copyright
                .setRequestCache(true)  
        }
    public void testScriptCaching() throws Exception {
        assertThat(
            .addAggregation(count("count").field("value"))
            assertThat(bucket, notNullValue());
        assertThat(valueCount.getName(), equalTo("count"));  
/*
import java.util.List;
import org.opensearch.action.search.SearchResponse;  
        assertThat(
 * compatible open source license.
        assertSearchResponse(r);  
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(count("foo").field("d")).get();
    }
import static org.opensearch.search.aggregations.AggregationBuilders.global;
    public void testSingleValuedField() throws Exception {
            .addAggregation(global("global").subAggregation(count("count").field("value")))
import org.opensearch.search.aggregations.bucket.terms.Terms;  
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
/*  
                .getTotal()
            .setQuery(matchAllQuery())
        ValueCount valueCount = searchResponse.getAggregations().get("count");  
        client().admin().indices().prepareRefresh().get();  
 * Unless required by applicable law or agreed to in writing,
        );  
            assertThat(count, notNullValue());  
                .get()
    public void testSingleValuedFieldGetProperty() throws Exception {
                .get()
                .indices()  
            client().admin()  
        assertHitCount(searchResponse, 10);  
            .setQuery(matchAllQuery())
                .get()  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;  
import java.util.Collections;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            Filter filter = bucket.getAggregations().get("filter");
            .setQuery(matchAllQuery())
                .getRequestCache()  
                .get()
        assertThat(valueCount, notNullValue());
    public void testMultiValuedField() throws Exception {  
            )
        }  
 * ownership. Elasticsearch licenses this file to you under  
        );
                .getTotal()
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Arrays;
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                .getRequestCache()
        assertThat(global.getAggregations(), notNullValue());
    }
        assertThat(valueCount.getValue(), equalTo(10L));
        client().admin().indices().prepareFlush().get();
        // Ensure that non-scripted requests are cached as normal
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            .addAggregation(count("count").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, SUM_FIELD_PARAMS_SCRIPT, params)))
        assertThat(
    public void testMultiValuedScript() throws Exception {  
    @Override
        assertAcked(  
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
                .prepareStats("cache_test_idx")
 *  
            .get();
        assertHitCount(searchResponse, 10);
            )
import static org.opensearch.index.query.QueryBuilders.termQuery;
                .get()
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
            .get();
        assertThat(
                .getTotal()
            .get();  
import org.opensearch.common.settings.Settings;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.script.Script;  
import org.opensearch.search.aggregations.BucketOrder;
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
            )
            .addAggregation(
        ValueCount valueCount = searchResponse.getAggregations().get("count");
        );  
 * software distributed under the License is distributed on an
                .setRequestCache(true)  
                .prepareStats("cache_test_idx")  
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
        SearchResponse searchResponse = client().prepareSearch("idx")  
        assertThat(valueCount.getValue(), equalTo(10L));
    public void testMultiValuedScriptWithParams() throws Exception {
}
    @Override
    }  
        ValueCount valueCount = searchResponse.getAggregations().get("count");
                builders.add(client().prepareIndex("test_value_count_agg").setSource("value", i + 1));
 * GitHub history for details.
        assertSearchResponse(r);  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .subAggregation(filter("filter", termQuery("value", 100)).subAggregation(count("count").field("value")))  
        assertHitCount(searchResponse, 10);
            equalTo(0L)
            .setQuery(matchAllQuery())
            assertThat(filter, notNullValue());  
        SearchResponse searchResponse = client().prepareSearch("idx")  
import org.opensearch.plugins.Plugin;
 * not use this file except in compliance with the License.
            .get();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                .setRequestCache(true)
     * Make sure that a request using a deterministic script or not using a script get cached.
                .getRequestCache()  
            new Object[] {  
        assertHitCount(searchResponse, 10);
                .getMissCount(),  
    }
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
                count("count").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, SUM_VALUES_FIELD_SCRIPT, Collections.emptyMap()))
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.RANDOM_SCRIPT;
    }
import org.opensearch.search.aggregations.bucket.global.Global;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            }  
                .getTotal()
@OpenSearchIntegTestCase.SuiteScopeTestCase
            equalTo(0L)
                .indices()  
public class ValueCountIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
            equalTo(2L)
            .get();
                .getTotal()
 *
        assertThat(valueCount, notNullValue());
            .get();
            Terms.Bucket bucket = buckets.get(i);
                .getRequestCache()
        ValueCount valueCount = searchResponse.getAggregations().get("count");
                .getRequestCache()
        assertThat(valueCount.getName(), equalTo("count"));  
                count("foo").field("d").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, RANDOM_SCRIPT, Collections.emptyMap()))  
                .getRequestCache()  
        } finally {
        assertThat(valueCount.getName(), equalTo("count"));
        assertThat(
    public void testValueCountWithIntraSegmentPartitioning() throws Exception {  
                .setRequestCache(true)  
                .prepareStats("cache_test_idx")
 * SPDX-License-Identifier: Apache-2.0
        return Arrays.asList(
    public void setupSuiteScopeCluster() throws Exception {  
        assertThat(valueCount.getName(), equalTo("count"));
            .setQuery(matchAllQuery())  
        assertThat(  
            .get();
            indexRandomForConcurrentSearch("test_value_count_agg");
            client().admin()  
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));  
/*
import java.util.Collection;  
            .get();
                .prepareStats("cache_test_idx")
 */
                    .build() }
        SearchResponse searchResponse = client().prepareSearch("idx")
        try {
            equalTo(0L)
import org.opensearch.action.index.IndexRequestBuilder;
            .setQuery(matchAllQuery())  
 */  
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);  
        );  
        createIndex("idx");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ValueCount count = filter.getAggregations().get("count");
        assertThat(global.getDocCount(), equalTo(10L));  
        assertThat(valueCount.getValue(), equalTo(10L));  
        SearchResponse searchResponse = client().prepareSearch("idx")
            .setQuery(matchAllQuery())
            .addAggregation(count("count").field("values"))  
                terms("terms").field("value")
            )
            assertThat(countAgg.getValue(), equalTo(5000L));  
        assertThat(valueCount.getName(), equalTo("count"));  
            .addAggregation(
                .getHitCount(),
    public void testSingleValuedScript() throws Exception {
        // Make sure we are starting with a clear cache
        assertThat(valueCount.getValue(), equalTo(10L));  
import org.opensearch.search.aggregations.InternalAggregation;  
 * specific language governing permissions and limitations
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
                .getMissCount(),
                .getHitCount(),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
                .setRequestCache(true)
                    jsonBuilder().startObject().field("value", i + 1).startArray("values").value(i + 2).value(i + 3).endArray().endObject()
                .getTotal()
            assertThat(countAgg, notNullValue());
        indexRandom(
     * Ensure requests using nondeterministic scripts do not get cached.  
            true,  
                .prepareStats("cache_test_idx")
        assertHitCount(searchResponse, 10);
        );  
        assertThat(valueCount.getValue(), equalTo(20L));
            client().admin()
            for (int i = 0; i < 5000; i++) {
            assertThat(count.value(), equalTo(0.0));
        assertThat(valueCount.getName(), equalTo("count"));  
            .get();
        );
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
    }
                .get()
            client().admin()
                .getHitCount(),
                .setRequestCache(true)  
            ValueCount countAgg = response.getAggregations().get("count");
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.SUM_FIELD_PARAMS_SCRIPT;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            client().admin()
                )
        assertThat(valueCount.getValue(), equalTo(0L));
    }  
            .addAggregation(count("count").field("value"))  
                .setRequestCache(true)
        assertThat((ValueCount) ((InternalAggregation) global).getProperty("count"), equalTo(valueCount));
        super(staticSettings);  
                count("foo").field("d")
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)  
        assertThat(valueCount, notNullValue());
        SearchResponse r = client().prepareSearch("cache_test_idx")  
    public void testSingleValuedScriptWithParams() throws Exception {
        );
                .indices()
        ValueCount valueCount = searchResponse.getAggregations().get("count");
                .prepareStats("cache_test_idx")
            .setSize(0)  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        ValueCount valueCount = searchResponse.getAggregations().get("count");
            equalTo(0L)
        assertThat(valueCount, notNullValue());
        for (int i = 0; i < 10; i++) {  
        SearchResponse searchResponse = client().prepareSearch("idx")  
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
        assertThat((double) ((InternalAggregation) global).getProperty("count.value"), equalTo(10d));  
                .prepareStats("cache_test_idx")
        ValueCount valueCount = searchResponse.getAggregations().get("count");  
    }
        assertHitCount(searchResponse, 10);
        assertThat(valueCount, notNullValue());
        assertHitCount(searchResponse, 10);
        assertThat(valueCount.getName(), equalTo("count"));  
        SearchResponse searchResponse = client().prepareSearch("idx")
 * under the License.  
        Map<String, Object> params = Collections.singletonMap("field", "value");
package org.opensearch.search.aggregations.metrics;
     */
            equalTo(0L)
        for (int i = 0; i < 10; i++) {  
            .get();  
        r = client().prepareSearch("cache_test_idx")
        // Test that a request using a deterministic script gets cached
            )
            .addAggregation(  
        assertHitCount(searchResponse, 10);
            internalCluster().wipeIndices("test_value_count_agg");
        ValueCount valueCount = global.getAggregations().get("count");
            equalTo(0L)  
        Map<String, Object> params = Collections.singletonMap("field", "values");
 * license agreements. See the NOTICE file distributed with
    }
    }
        assertThat(global.getName(), equalTo("global"));
        assertThat((double) ((InternalAggregation) valueCount).getProperty("value"), equalTo(10d));
    }
            .get();  
            .addAggregation(  
    }  
            .setQuery(matchAllQuery())
            SearchResponse response = client().prepareSearch("test_value_count_agg").addAggregation(count("count").field("value")).get();  
        assertThat(valueCount.getName(), equalTo("count"));
        assertThat(valueCount, notNullValue());
        ValueCount valueCount = searchResponse.getAggregations().get("count");
        assertThat(valueCount, notNullValue());  
    /**
            .addAggregation(count("count").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, SUM_FIELD_PARAMS_SCRIPT, params)))
        assertThat(valueCount, notNullValue());  
                .getTotal()
                .indices()
            client().admin()
    public void testUnmapped() throws Exception {  
            .addAggregation(
        );
            .setQuery(matchAllQuery())
import java.util.Map;  
                .getMissCount(),  
import static org.opensearch.search.aggregations.AggregationBuilders.filter;  
        SearchResponse searchResponse = client().prepareSearch("idx")
        createIndex("test_value_count_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());
    public ValueCountIT(Settings staticSettings) {
                .get()  
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.METRIC_SCRIPT_ENGINE;  
                .getMissCount(),  
                    .script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, VALUE_FIELD_SCRIPT, Collections.emptyMap()))  
import org.opensearch.script.ScriptType;
 * The OpenSearch Contributors require contributions made to  
    public void testOrderByEmptyAggregation() throws Exception {  
                count("count").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, VALUE_FIELD_SCRIPT, Collections.emptyMap()))  
        // Test that a request using a nondeterministic script does not get cached
        }  
                Settings.builder()
                .getTotal()  
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")
        assertThat(buckets.size(), equalTo(10));
            equalTo(1L)
 * Modifications Copyright OpenSearch Contributors. See  
            client().admin()  
import static org.hamcrest.Matchers.notNullValue;  
        ensureSearchable();
        assertThat(
                .indices()
        Terms terms = searchResponse.getAggregations().get("terms");  
                .get()  
            client().prepareIndex("idx")
                .indices()
        createIndex("idx_unmapped");
                .setId("" + i)
            indexBulkWithSegments(builders, 2);
        assertThat(valueCount.getValue(), equalTo(20L));
import org.opensearch.search.aggregations.bucket.filter.Filter;
        assertSearchResponse(r);  
        assertThat(valueCount, notNullValue());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                .indices()  
        assertHitCount(searchResponse, 10);
            client().admin()  
        assertThat(valueCount.getValue(), equalTo(20L));
    public static Collection<Object[]> parameters() {
            assertThat(filter.getDocCount(), equalTo(0L));
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.SUM_VALUES_FIELD_SCRIPT;  
        internalCluster().wipeIndices("cache_test_idx");  
        return Collections.singletonList(MetricAggScriptPlugin.class);  
        assertThat(valueCount.getValue(), equalTo(10L));
    }
            .setSize(0)
                .getHitCount(),
 */
        assertThat(valueCount.getName(), equalTo("count"));
                .prepareStats("cache_test_idx")
import java.util.ArrayList;
            .get();  
        assertThat(buckets, notNullValue());  
        );  
        SearchResponse searchResponse = client().prepareSearch("idx")  
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
 * You may obtain a copy of the License at  
                .get();  
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")
        assertThat(terms, notNullValue());
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
import org.opensearch.test.OpenSearchIntegTestCase;
        );
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(
        assertThat(global, notNullValue());
                .setSource(  
                .getRequestCache()
        );
                .indices()
import static org.opensearch.search.aggregations.AggregationBuilders.count;
            .addAggregation(count("count").field("value"))
                .setRequestCache(true)
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
    }
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.equalTo;
    }
    }
            assertThat(bucket.getDocCount(), equalTo(1L));
    @ParametersFactory  
            .setQuery(matchAllQuery())
                .getRequestCache()  
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.VALUE_FIELD_SCRIPT;
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>count", true)))
        Global global = searchResponse.getAggregations().get("global");  
                .get()  
