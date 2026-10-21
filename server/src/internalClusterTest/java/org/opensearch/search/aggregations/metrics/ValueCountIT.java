                .get()
                .get();
                .indices()
            .setQuery(matchAllQuery())
                .getTotal()
import java.util.Collections;
/*
    public void testOrderByEmptyAggregation() throws Exception {
                .prepareStats("cache_test_idx")
        createIndex("idx");
    @Override
        );
        SearchResponse searchResponse = client().prepareSearch("idx")
                .get()
            ValueCount count = filter.getAggregations().get("count");
            assertThat(bucket.getDocCount(), equalTo(1L));
/*
    public void testMultiValuedScript() throws Exception {
        createIndex("idx_unmapped");
 * software distributed under the License is distributed on an
        assertSearchResponse(r);
        assertThat(valueCount.getValue(), equalTo(10L));
                .getRequestCache()
            .setQuery(matchAllQuery())
        assertSearchResponse(r);
            client().admin()
                )
 */
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);
            assertThat(countAgg, notNullValue());
    }
        assertThat(buckets, notNullValue());
            assertThat(bucket, notNullValue());
            SearchResponse response = client().prepareSearch("test_value_count_agg").addAggregation(count("count").field("value")).get();
        );
     * Make sure that a request using a deterministic script or not using a script get cached.
        assertThat(valueCount, notNullValue());
    public static Collection<Object[]> parameters() {
            .get();
        indexRandom(
            )
        client().admin().indices().prepareFlush().get();
        assertThat(global, notNullValue());
            equalTo(0L)
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
                .setRequestCache(true)
        assertThat(global.getDocCount(), equalTo(10L));
 * not use this file except in compliance with the License.
            .addAggregation(count("count").field("values"))
        assertAcked(
                .prepareStats("cache_test_idx")
import org.opensearch.action.index.IndexRequestBuilder;
                .setSource(
    }
        assertThat(valueCount, notNullValue());
            .addAggregation(count("count").field("value"))
            assertThat(count.value(), equalTo(0.0));
        Terms terms = searchResponse.getAggregations().get("terms");
import org.opensearch.script.ScriptType;
 */
                .get()
        try {
import org.opensearch.test.OpenSearchIntegTestCase;
            client().admin()
        Map<String, Object> params = Collections.singletonMap("field", "value");
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
import org.opensearch.common.settings.Settings;
        r = client().prepareSearch("cache_test_idx")
import org.opensearch.plugins.Plugin;
    public void setupSuiteScopeCluster() throws Exception {
            }
                .setRequestCache(true)
        assertThat(valueCount.getName(), equalTo("count"));
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
            for (int i = 0; i < 5000; i++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertHitCount(searchResponse, 10);
            .get();
    public void testUnmapped() throws Exception {
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
        assertThat(valueCount.getName(), equalTo("count"));
            .get();
 *
            client().admin()
 * this work for additional information regarding copyright
            .get();
            )
                .setRequestCache(true)
        assertThat(global.getAggregations(), notNullValue());
                Settings.builder()
                .getMissCount(),
import java.util.Collection;
            .addAggregation(count("count").field("value"))
            .setQuery(matchAllQuery())
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
        } finally {
                builders.add(client().prepareIndex("test_value_count_agg").setSource("value", i + 1));
            .get();
            .setQuery(matchAllQuery())
                .getMissCount(),
            .addAggregation(
import java.util.Arrays;
 * ownership. Elasticsearch licenses this file to you under
        assertHitCount(searchResponse, 10);
 * Licensed to Elasticsearch under one or more contributor
 * Unless required by applicable law or agreed to in writing,
                .getRequestCache()
                .get()
        );
            .setSize(0)
        SearchResponse searchResponse = client().prepareSearch("idx")
            client().admin()
        );
        return Collections.singletonList(MetricAggScriptPlugin.class);
        SearchResponse searchResponse = client().prepareSearch("idx")
            .setQuery(matchAllQuery())
                .getRequestCache()
            client().admin()
 */
                .indices()
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.RANDOM_SCRIPT;
        for (int i = 0; i < 10; i++) {
        );
                .getRequestCache()
                .getTotal()
            client().admin()
                .indices()
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.index.query.QueryBuilders.termQuery;
    /**
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(count("foo").field("d")).get();
                .indices()
        assertThat(valueCount, notNullValue());
        assertThat((double) ((InternalAggregation) valueCount).getProperty("value"), equalTo(10d));
                .get()
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                .getHitCount(),
        assertThat(valueCount, notNullValue());
/*
            )
                .getMissCount(),
            .setQuery(matchAllQuery())
            .get();
        ValueCount valueCount = searchResponse.getAggregations().get("count");
import org.opensearch.search.aggregations.BucketOrder;
 * SPDX-License-Identifier: Apache-2.0
        createIndex("test_value_count_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());
            .addAggregation(count("count").field("value"))
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import static org.hamcrest.Matchers.equalTo;
                .setRequestCache(true)
        assertThat(valueCount, notNullValue());
            equalTo(0L)
        assertThat(buckets.size(), equalTo(10));
                .getTotal()
        assertSearchResponse(r);
                .setRequestCache(true)
        assertThat(valueCount.getValue(), equalTo(10L));
            .setSize(0)
            equalTo(2L)
            equalTo(0L)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
     */
            .setQuery(matchAllQuery())
        assertThat(valueCount, notNullValue());
            .get();
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
            .addAggregation(
            .get();
                .indices()
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
 * Modifications Copyright OpenSearch Contributors. See
    }
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)
        assertThat(
    }
            .addAggregation(
        assertThat(valueCount.getName(), equalTo("count"));
    public void testSingleValuedScriptWithParams() throws Exception {
     * Ensure requests using nondeterministic scripts do not get cached.
        }
        Map<String, Object> params = Collections.singletonMap("field", "values");
        ValueCount valueCount = searchResponse.getAggregations().get("count");
 * GitHub history for details.
            .get();
import org.opensearch.search.aggregations.bucket.filter.Filter;
    @ParametersFactory
            new Object[] {
        assertThat(valueCount.getName(), equalTo("count"));
import org.opensearch.script.Script;
    }
        assertThat(valueCount.getName(), equalTo("count"));
                    .build() }
        // Test that a request using a deterministic script gets cached
                .setId("" + i)
        );
                    .script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, VALUE_FIELD_SCRIPT, Collections.emptyMap()))
        super(staticSettings);
    public void testValueCountWithIntraSegmentPartitioning() throws Exception {
            indexBulkWithSegments(builders, 2);
            assertThat(countAgg.getValue(), equalTo(5000L));
            equalTo(1L)
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")
 * license agreements. See the NOTICE file distributed with
        ValueCount valueCount = searchResponse.getAggregations().get("count");
        assertThat(
        assertThat(
@OpenSearchIntegTestCase.SuiteScopeTestCase
        );
            )
import org.opensearch.search.aggregations.bucket.terms.Terms;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.VALUE_FIELD_SCRIPT;
                count("count").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, SUM_VALUES_FIELD_SCRIPT, Collections.emptyMap()))
    }
 * The OpenSearch Contributors require contributions made to
        SearchResponse searchResponse = client().prepareSearch("idx")
            assertThat(count, notNullValue());
        Global global = searchResponse.getAggregations().get("global");
 * specific language governing permissions and limitations
        assertThat(valueCount.getValue(), equalTo(20L));
                    jsonBuilder().startObject().field("value", i + 1).startArray("values").value(i + 2).value(i + 3).endArray().endObject()
            .addAggregation(
            .setQuery(matchAllQuery())
    @Override
                .prepareStats("cache_test_idx")
        }
import org.opensearch.search.aggregations.bucket.global.Global;
        assertThat(valueCount.getValue(), equalTo(10L));
 * KIND, either express or implied.  See the License for the
        assertHitCount(searchResponse, 10);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(terms, notNullValue());
 *
        assertThat(valueCount.getValue(), equalTo(10L));
        );
                .setRequestCache(true)
        }
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
            indexRandomForConcurrentSearch("test_value_count_agg");
import java.util.List;
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.METRIC_SCRIPT_ENGINE;
            client().prepareIndex("idx")
        client().admin().indices().prepareRefresh().get();
                count("foo").field("d").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, RANDOM_SCRIPT, Collections.emptyMap()))
        internalCluster().wipeIndices("cache_test_idx");
        ValueCount valueCount = global.getAggregations().get("count");
                .getRequestCache()
        assertThat(valueCount.getValue(), equalTo(0L));
        ValueCount valueCount = searchResponse.getAggregations().get("count");
            .addAggregation(count("count").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, SUM_FIELD_PARAMS_SCRIPT, params)))
public class ValueCountIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .addAggregation(
            internalCluster().wipeIndices("test_value_count_agg");
        assertThat(valueCount.getValue(), equalTo(20L));
import static org.opensearch.search.aggregations.AggregationBuilders.count;
            .setQuery(matchAllQuery())
 *
        SearchResponse searchResponse = client().prepareSearch("idx")
}
        assertThat(
        ValueCount valueCount = searchResponse.getAggregations().get("count");
        assertThat(valueCount.getName(), equalTo("count"));
    }
        assertThat(valueCount.getName(), equalTo("count"));
                .prepareStats("cache_test_idx")
 * You may obtain a copy of the License at
        SearchResponse searchResponse = client().prepareSearch("idx")
        ValueCount valueCount = searchResponse.getAggregations().get("count");
    }
        );
        assertThat(valueCount.getName(), equalTo("count"));
        assertThat((double) ((InternalAggregation) global).getProperty("count.value"), equalTo(10d));
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
import org.opensearch.search.aggregations.InternalAggregation;
                .setRequestCache(true)
            .addAggregation(global("global").subAggregation(count("count").field("value")))
            .get();
            .get();
                .getMissCount(),
            assertThat(filter, notNullValue());
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>count", true)))
        assertHitCount(searchResponse, 10);
                .get()
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                count("foo").field("d")
                .get()
                .getTotal()
            assertThat(filter.getDocCount(), equalTo(0L));
                .prepareStats("cache_test_idx")
        // Test that a request using a nondeterministic script does not get cached
                .indices()
            client().admin()
            Filter filter = bucket.getAggregations().get("filter");
        ValueCount valueCount = searchResponse.getAggregations().get("count");
import org.opensearch.action.search.SearchResponse;
                .prepareStats("cache_test_idx")
    public void testSingleValuedField() throws Exception {
    }
                .setRequestCache(true)
        assertThat(valueCount.getName(), equalTo("count"));
                .getRequestCache()
        assertHitCount(searchResponse, 10);
                .prepareStats("cache_test_idx")
 * under the License.
import static org.hamcrest.Matchers.notNullValue;
    }
        assertThat(
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
package org.opensearch.search.aggregations.metrics;
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
        assertThat(
                .getHitCount(),
    }
 * compatible open source license.
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(valueCount, notNullValue());
                .getRequestCache()
                .getTotal()
import static org.opensearch.search.aggregations.AggregationBuilders.global;
                .getHitCount(),
            ValueCount countAgg = response.getAggregations().get("count");
        assertThat(valueCount, notNullValue());
    }
    }
        SearchResponse searchResponse = client().prepareSearch("idx")
            equalTo(0L)
    public void testSingleValuedFieldGetProperty() throws Exception {
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
    public void testSingleValuedScript() throws Exception {
                .get()
            client().admin()
                terms("terms").field("value")
                .getTotal()
                .indices()
    }
        ensureSearchable();
    public void testMultiValuedScriptWithParams() throws Exception {
import java.util.ArrayList;
                .get()
            )
                count("count").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, VALUE_FIELD_SCRIPT, Collections.emptyMap()))
    public void testScriptCaching() throws Exception {
        assertThat(
            true,
            Terms.Bucket bucket = buckets.get(i);
        assertHitCount(searchResponse, 10);
            .setQuery(matchAllQuery())
                .getRequestCache()
    public ValueCountIT(Settings staticSettings) {
        assertThat((ValueCount) ((InternalAggregation) global).getProperty("count"), equalTo(valueCount));
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.SUM_VALUES_FIELD_SCRIPT;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        );
        // Ensure that non-scripted requests are cached as normal
import java.util.Map;
        ValueCount valueCount = searchResponse.getAggregations().get("count");
                .prepareStats("cache_test_idx")
        SearchResponse r = client().prepareSearch("cache_test_idx")
 *    http://www.apache.org/licenses/LICENSE-2.0
        // Make sure we are starting with a clear cache
        assertHitCount(searchResponse, 10);
        return Arrays.asList(
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.SUM_FIELD_PARAMS_SCRIPT;
        assertHitCount(searchResponse, 10);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")
        );
        assertThat(valueCount.getValue(), equalTo(20L));
                    .subAggregation(filter("filter", termQuery("value", 100)).subAggregation(count("count").field("value")))
    }
            equalTo(0L)
        assertThat(valueCount.getValue(), equalTo(10L));
        assertHitCount(searchResponse, 10);
            .get();
        SearchResponse searchResponse = client().prepareSearch("idx")
                .getTotal()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
                .indices()
                .getHitCount(),
            .addAggregation(count("count").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, SUM_FIELD_PARAMS_SCRIPT, params)))
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        assertThat(valueCount, notNullValue());
            equalTo(0L)
    public void testMultiValuedField() throws Exception {
        assertThat(
                .getTotal()
        assertThat(global.getName(), equalTo("global"));
        for (int i = 0; i < 10; i++) {
