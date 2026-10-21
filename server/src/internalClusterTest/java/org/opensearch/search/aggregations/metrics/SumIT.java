            Filter filter = bucket.getAggregations().get("filter");
                .indices()
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
        assertSearchResponse(r);
}
        SearchResponse searchResponse = client().prepareSearch("idx")
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            )
     */
                .prepareStats("cache_test_idx")
        assertThat(terms.getName(), equalTo("terms"));
        assertSearchResponse(r);
        assertThat(global.getDocCount(), equalTo(10L));
                .getTotal()
 *
        assertThat(bucket, notNullValue());
            client().admin()
            assertThat(filter.getDocCount(), equalTo(0L));
        assertThat(sum, notNullValue());
        assertThat(bucket.getDocCount(), equalTo(2L));
    }
        );
                .getTotal()
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);
        Sum sum = bucket.getAggregations().get("sum");
        );
                    .subAggregation(filter("filter", termQuery("value", 100)).subAggregation(sum("sum").field("value")))
            client().admin()
 * software distributed under the License is distributed on an
    public void testUnmapped() throws Exception {}
            .get();
                expectedSum += (i + 1);
import org.opensearch.search.aggregations.bucket.filter.Filter;
                .indices()
 * not use this file except in compliance with the License.
    public void testFieldAlias() {
    @Override
            assertThat(sumAgg.getValue(), closeTo((double) expectedSum, 0.1));
        builders.add(client().prepareIndex("old_index").setSource("transit_mode", "bus", "distance", 50.5));
    @Override
            .get();
            new Object[] {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .getTotal()
                .indices()
        assertThat(bucket, notNullValue());
        Histogram histo = searchResponse.getAggregations().get("histo");
package org.opensearch.search.aggregations.metrics;
 * Unless required by applicable law or agreed to in writing,
            "type=keyword",
 * compatible open source license.
                .get()
    /**
import org.hamcrest.core.IsNull;
    }
        super(staticSettings);
        // Ensure that non-scripted requests are cached as normal
    }
        assertThat(global.getName(), equalTo("global"));
    public SumIT(Settings staticSettings) {
            .setQuery(matchAllQuery())
                .getHitCount(),
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat(sum, notNullValue());
        assertHitCount(searchResponse, 10);
            "transit_mode",
            true,
                .setRequestCache(true)
                .get()
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(sum("foo").field("d")).get();
        indexRandom(
        Sum sum = bucket.getAggregations().get("sum");
            Sum sum = filter.getAggregations().get("sum");
            .get();
    public static Collection<Object[]> parameters() {
import static org.opensearch.search.aggregations.AggregationBuilders.global;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertThat(sum.getValueAsString(), equalTo("0055.0"));
import java.util.Collection;
 * this work for additional information regarding copyright
                .prepareStats("cache_test_idx")
                .setRequestCache(true)
            equalTo(0L)
        assertThat(buckets.size(), equalTo(2));
            .setQuery(matchAllQuery())
        SearchResponse r = client().prepareSearch("cache_test_idx")
        assertThat(sum, IsNull.notNullValue());
            )
                .setRequestCache(true)
                .getMissCount(),
                .setRequestCache(true)
            .setQuery(matchAllQuery())
        assertThat(
            .addAggregation(sum("sum").format("0000.0").field("value"))
            .get();
                .indices()
        assertThat(sum.getName(), equalTo("sum"));
        assertHitCount(searchResponse, 10);
            Terms.Bucket bucket = buckets.get(i);
        Sum sum = searchResponse.getAggregations().get("sum");
import static org.hamcrest.Matchers.closeTo;
    }
        r = client().prepareSearch("cache_test_idx")
                builders.add(client().prepareIndex("test_sum_agg").setSource("value", i + 1));
        // one, and a concrete field in the other.
        assertThat(sum.getValue(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
import org.opensearch.common.settings.Settings;
import static org.opensearch.index.query.QueryBuilders.termQuery;
        );
/*
        assertThat((double) ((InternalAggregation) sum).getProperty("value"), equalTo(expectedSumValue));
                .get()
        assertThat(sum.getName(), equalTo("sum"));
 * You may obtain a copy of the License at
        assertThat(
        }
                terms("terms").field("value")
            .addAggregation(
    }
                .getRequestCache()
        assertThat(terms, notNullValue());
        Histogram.Bucket bucket = histo.getBuckets().get(1);
            long expectedSum = 0;
        assertThat(sum.getValue(), equalTo(0.0));
                .getRequestCache()
        assertThat(global, notNullValue());
        assertThat(
            client().admin()
        assertThat(sum, notNullValue());
        sum = bucket.getAggregations().get("sum");
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    public void testSumWithIntraSegmentPartitioning() throws Exception {
        Terms terms = searchResponse.getAggregations().get("terms");
        assertAcked(
                .getMissCount(),
        Sum sum = searchResponse.getAggregations().get("sum");
            "route_length_miles",
        assertThat(sum.getName(), equalTo("sum"));
            assertThat(bucket.getDocCount(), equalTo(1L));
                Settings.builder()
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(sumAgg, notNullValue());
                .get()
    }
        assertThat(bucket, notNullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
        Sum sum = response.getAggregations().get("sum");
            .addAggregation(sum("sum").field("values"))
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        Global global = searchResponse.getAggregations().get("global");
        assertHitCount(searchResponse, 10);
 */
    @Override
            equalTo(1L)
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
                    .build() }
        SearchResponse response = client().prepareSearch("old_index", "new_index")
    }
        assertThat(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .get();
        assertHitCount(searchResponse, 10);
        builders.add(client().prepareIndex("old_index").setSource("transit_mode", "train", "distance", 42.0));
        assertThat(sum.getValue(), equalTo((double) 2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12));
                sum("foo").field("d").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, RANDOM_SCRIPT, Collections.emptyMap()))
        assertThat(bucket.getKey(), equalTo("train"));
 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
            assertThat(filter, notNullValue());
            equalTo(0L)
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.METRIC_SCRIPT_ENGINE;
        assertThat(sum.getValue(), equalTo(192.7));
import org.opensearch.action.search.SearchResponse;
    public void setupSuiteScopeCluster() throws Exception {
import org.opensearch.script.ScriptType;
        indexRandom(true, builders);
        assertSearchResponse(response);
            .get();
            .get();
            .setQuery(matchAllQuery())
import java.util.Collections;
                .setRequestCache(true)
 *
        assertThat(bucket.getDocCount(), equalTo(1L));
                .getTotal()
        );
        prepareCreate("new_index").setMapping("transit_mode", "type=keyword", "route_length_miles", "type=double").get();
            assertThat(bucket, notNullValue());
            equalTo(2L)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            client().admin()
/*
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.VALUE_SCRIPT;
     * Ensure requests using nondeterministic scripts do not get cached.
        prepareCreate("old_index").setMapping(
    @ParametersFactory
        assertSearchResponse(response);
            client().admin()
    }
        SearchResponse searchResponse = client().prepareSearch("idx")
 *
            .addAggregation(histogram("histo").field("value").interval(1L).minDocCount(0).subAggregation(sum("sum").field("value")))
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
            .setSize(0)
                .indices()
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(
import org.opensearch.script.Script;
        );
        assertSearchResponse(r);
        );
        assertThat(sum.getValue(), equalTo(142.2));
            .addAggregation(terms("terms").field("transit_mode").subAggregation(sum("sum").field("route_length_miles")))
            equalTo(0L)
import java.util.Arrays;
            client().admin()
                .setRequestCache(true)
import org.opensearch.search.aggregations.bucket.terms.Terms;
                .getRequestCache()
            }
    public void testSingleValuedFieldWithFormatter() throws Exception {
        } finally {
            .setSize(0)
        // Make sure we are starting with a clear cache
            .addAggregation(sum("sum").field("value"))
                .getRequestCache()
            client().admin()
        assertThat(sum.getValue(), equalTo(50.5));
                .getHitCount(),
        );
import org.opensearch.search.aggregations.bucket.global.Global;
                .get()
import java.util.List;
            .addAggregation(global("global").subAggregation(sum("sum").field("value")))
            internalCluster().wipeIndices("test_sum_agg");
        createIndex("test_sum_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());
        internalCluster().wipeIndices("cache_test_idx");
            indexRandomForConcurrentSearch("test_sum_agg");
                .setRequestCache(true)
            assertThat(sum, notNullValue());
                .prepareStats("cache_test_idx")
                .getMissCount(),
            indexBulkWithSegments(builders, 2);
        assertThat(sum.getName(), equalTo("sum"));
            "distance",
    }
                .indices()
    public void testSingleValuedField() throws Exception {
import org.opensearch.search.aggregations.InternalAggregation;
        assertThat(sum.getName(), equalTo("sum"));
    }
    @Override
            for (int i = 0; i < 5000; i++) {
        assertThat((double) ((InternalAggregation) global).getProperty("sum.value"), equalTo(expectedSumValue));
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
/*
        assertThat(
public class SumIT extends AbstractNumericTestCase {
 * SPDX-License-Identifier: Apache-2.0
        assertThat(sum, notNullValue());
                .getHitCount(),
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
        );
                .getMissCount(),
        assertThat(
        }
 * specific language governing permissions and limitations
                .indices()
        // Test that a request using a nondeterministic script does not get cached
            )
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
import org.opensearch.plugins.Plugin;
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
                .get()
        );
        );
                .get()
            .setQuery(matchAllQuery())
        assertThat(sum, notNullValue());
            "type=alias,path=distance"
        Terms.Bucket bucket = buckets.get(0);
        double expectedSumValue = (double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
    public void testScriptCaching() throws Exception {
            .addAggregation(sum("sum").field("route_length_miles"))
 */
        try {
    }
        assertThat(global.getAggregations(), notNullValue());
        assertThat(sum, notNullValue());
            equalTo(0L)
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
import static org.hamcrest.Matchers.notNullValue;
        assertThat(
import org.opensearch.search.aggregations.BucketOrder;
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            .get();
        );
            .setQuery(matchAllQuery())
 * GitHub history for details.
 * under the License.
                .getTotal()
                .prepareStats("cache_test_idx")
        // Test that a request using a deterministic script gets cached
    public void testFieldAliasInSubAggregation() {
        assertThat(sum, notNullValue());
        SearchResponse response = client().prepareSearch("old_index", "new_index")
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
                .getTotal()
        ).get();
                .getTotal()
        assertThat(terms, notNullValue());
    public void testSingleValuedFieldGetProperty() throws Exception {
                .get()
import static org.opensearch.search.aggregations.metrics.MetricAggScriptPlugin.RANDOM_SCRIPT;
        super.setupSuiteScopeCluster();
    /** This test has been moved to {@link SumAggregatorTests#testUnmapped()} */
        assertThat(sum.getValue(), equalTo(expectedSumValue));
        Sum sum = global.getAggregations().get("sum");
            SearchResponse response = client().prepareSearch("test_sum_agg").addAggregation(sum("sum").field("value")).get();
            assertThat(sum.value(), equalTo(0.0));
                .getRequestCache()
                .setRequestCache(true)
                .prepareStats("cache_test_idx")
            .get();
    @Override
            client().admin()
    @Override
            equalTo(0L)
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import java.util.ArrayList;
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
 * The OpenSearch Contributors require contributions made to
            "type=double",
        for (int i = 0; i < 10; i++) {
        bucket = buckets.get(1);
 * KIND, either express or implied.  See the License for the
                .getHitCount(),
import org.opensearch.action.index.IndexRequestBuilder;
    public void testOrderByEmptyAggregation() throws Exception {
                .getRequestCache()
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(buckets.size(), equalTo(10));
        SearchResponse searchResponse = client().prepareSearch("idx")
     * Make sure that a request using a deterministic script or not using a script get cached.
        return Arrays.asList(
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
 * Modifications Copyright OpenSearch Contributors. See
 */
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
                .getTotal()
    }
        builders.add(client().prepareIndex("new_index").setSource("transit_mode", "train", "route_length_miles", 100.2));
        assertThat(buckets, notNullValue());
                .getRequestCache()
        return Collections.singleton(MetricAggScriptPlugin.class);
        assertHitCount(searchResponse, 10);
        ensureSearchable();
                .getRequestCache()
        List<IndexRequestBuilder> builders = new ArrayList<>();
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)
    }
    public void testMultiValuedField() throws Exception {
                .prepareStats("cache_test_idx")
        assertThat(histo, notNullValue());
                .indices()
            .addAggregation(
                .get()
    @Override
        assertThat(bucket.getKey(), equalTo("bus"));
    }
        SearchResponse searchResponse = client().prepareSearch("idx")
 * this file be licensed under the Apache-2.0 license or a
        assertThat((Sum) ((InternalAggregation) global).getProperty("sum"), equalTo(sum));
    public void testEmptyAggregation() throws Exception {
                .prepareStats("cache_test_idx")
        Terms terms = response.getAggregations().get("terms");
            Sum sumAgg = response.getAggregations().get("sum");
                sum("foo").field("d").script(new Script(ScriptType.INLINE, METRIC_SCRIPT_ENGINE, VALUE_SCRIPT, Collections.emptyMap()))
            .addAggregation(
        // Create two indices and add the field 'route_length_miles' as an alias in
            .get();
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>sum", true)))
        Sum sum = searchResponse.getAggregations().get("sum");
            equalTo(0L)
        assertThat(sum.getName(), equalTo("sum"));
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
                .prepareStats("cache_test_idx")
    @Override
        assertThat(sum.getValue(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under
import static org.hamcrest.Matchers.equalTo;
