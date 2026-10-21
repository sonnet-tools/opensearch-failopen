import java.util.Arrays;
import org.opensearch.script.ScriptType;
            assertThat(filter, notNullValue());
                .prepareStats("cache_test_idx")
        assertHitCount(searchResponse, 10);
            equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12) / 20)
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(stats("foo").field("d")).get();
        assertThat(global.getName(), equalTo("global"));
    }
/*
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        if (failures.length != expectedFailures) {
        );
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
        Terms terms = searchResponse.getAggregations().get("terms");
                stats("foo").field("d")
     * Make sure that a request using a deterministic script or not using a script get cached.
            client().admin()
        assertThat(stats, notNullValue());
        assertThat(stats.getCount(), equalTo(expectedCountValue));
import org.opensearch.search.aggregations.bucket.terms.Terms;
        assertThat(
            assertThat(bucket, notNullValue());
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        );
        assertThat(stats.getName(), equalTo("stats"));
        try {
                .getRequestCache()
        assertThat(statsFromProperty, sameInstance(stats));
                .setRequestCache(true)
            client().admin()
        assertHitCount(searchResponse, 10);
            .get();
            .get();
import static org.hamcrest.Matchers.notNullValue;
        assertThat((double) ((InternalAggregation) global).getProperty("stats.avg"), equalTo(expectedAvgValue));
    /**
                .get()
            .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat((double) ((InternalAggregation) global).getProperty("stats.min"), equalTo(expectedMinValue));
            .addAggregation(stats("stats").field("values"))
 * license agreements. See the NOTICE file distributed with
     */
        double expectedSumValue = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
            assertThat(stats.getSum(), equalTo(0.0));
import java.util.Collection;
import static org.hamcrest.Matchers.closeTo;
                .indices()
            equalTo(0L)
                .getMissCount(),
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + 1", Collections.emptyMap()))
                .getRequestCache()
        assertSearchResponse(r);
            long expectedSum = 0;
            )
 * KIND, either express or implied.  See the License for the
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        );
            client().admin()
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
                stats("foo").field("d")
        Histogram histo = searchResponse.getAggregations().get("histo");
                builders.add(client().prepareIndex("test_stats_agg").setSource("value", i + 1));
            }
        assertThat(
            .get();
            .addAggregation(histogram("histo").field("value").interval(1L).minDocCount(0).subAggregation(stats("stats").field("value")))
            assertThat(statsAgg.getAvg(), closeTo((double) expectedSum / 5000, 0.1));
import static org.hamcrest.Matchers.is;
                .prepareStats("cache_test_idx")
                .indices()
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
            )
    }
                terms("terms").field("value")
                .indices()
 * compatible open source license.
        Stats stats = searchResponse.getAggregations().get("stats");
}
import java.util.ArrayList;
            indexRandomForConcurrentSearch("test_stats_agg");
                logger.error(new ParameterizedMessage("Shard Failure: {}", failure), failure.getCause());
                .prepareStats("cache_test_idx")
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                .indices()
        assertThat(stats, notNullValue());
                .setRequestCache(true)
 * The OpenSearch Contributors require contributions made to
        assertThat(bucket, notNullValue());
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
                .getRequestCache()
        assertShardExecutionState(searchResponse, 0);
            assertThat(statsAgg.getSum(), closeTo((double) expectedSum, 0.1));
        Stats stats = global.getAggregations().get("stats");
        assertAcked(
            client().admin()
        // Test that a request using a deterministic script gets cached
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
                .getRequestCache()
        );
import org.opensearch.common.settings.Settings;
    public void testMultiValuedField() throws Exception {
            .setQuery(matchAllQuery())
                .getTotal()
        assertThat(
        assertThat(stats.getCount(), equalTo(20L));
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>stats.avg", true)))
            )
        }
                .setRequestCache(true)
        long expectedCountValue = 10;
        Stats stats = searchResponse.getAggregations().get("stats");
 * You may obtain a copy of the License at
        }
        assertThat(statsFromProperty, notNullValue());
    @Override
 */
    }
                .setRequestCache(true)
        assertThat(stats, notNullValue());
        } finally {
        assertThat(stats.getMax(), equalTo(Double.NEGATIVE_INFINITY));
import static org.hamcrest.Matchers.sameInstance;
                .setRequestCache(true)
        );
    private void assertShardExecutionState(SearchResponse response, int expectedFailures) throws Exception {
                .getMissCount(),
            new Object[] {
                .prepareStats("cache_test_idx")
                .setRequestCache(true)
        return Arrays.asList(
    public void testSingleValuedField_WithFormatter() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
import static org.opensearch.index.query.QueryBuilders.termQuery;
import static org.opensearch.search.aggregations.AggregationBuilders.global;
    public void testSingleValuedField() throws Exception {
    @Override
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
        SearchResponse searchResponse = client().prepareSearch("idx")
    }
    }
        assertThat(buckets.size(), equalTo(10));
        assertThat(buckets, notNullValue());
            fail("Unexpected shard failures!");
        assertThat(stats.getCount(), equalTo(10L));
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
 *
        assertThat(histo, notNullValue());
    public void testEmptyAggregation() throws Exception {
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
            Stats statsAgg = response.getAggregations().get("stats");
        );
        assertThat(stats.getName(), equalTo("stats"));
        // Make sure we are starting with a clear cache
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
import org.opensearch.action.index.IndexRequestBuilder;
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
import org.opensearch.search.aggregations.bucket.global.Global;
            client().admin()
            .addAggregation(global("global").subAggregation(stats("stats").field("value")))
 * specific language governing permissions and limitations
 */
import java.util.List;
        assertThat((double) ((InternalAggregation) global).getProperty("stats.count"), equalTo((double) expectedCountValue));
                .getTotal()
                    .subAggregation(filter("filter", termQuery("value", 100)).subAggregation(stats("stats").field("value")))
        assertThat(stats.getCount(), equalTo(10L));
 */
            true,
                .get()
    }
        assertThat(stats, notNullValue());
        assertThat(global, notNullValue());
        assertThat(stats.getSum(), equalTo(0.0));
                .getTotal()
    }
        createIndex("test_stats_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
    }
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12));
    public void testSingleValuedFieldGetProperty() throws Exception {
        assertThat(stats.getMin(), equalTo(1.0));
                    .build() }
            .setSize(0)
        assertThat((double) ((InternalAggregation) global).getProperty("stats.max"), equalTo(expectedMaxValue));
    @Override
                .prepareStats("cache_test_idx")
        double expectedMaxValue = 10.0;
        assertThat(
        assertThat(stats.getMax(), equalTo(10.0));
            .get();
        SearchResponse searchResponse = client().prepareSearch("idx")
    }
 * not use this file except in compliance with the License.
            equalTo(0L)
            assertThat(statsAgg, notNullValue());
                .getTotal()
public class StatsIT extends AbstractNumericTestCase {
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(
            for (int i = 0; i < 5000; i++) {
        assertThat(stats.getMaxAsString(), equalTo("0010.0"));
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", Collections.emptyMap()))
        indexRandom(
import org.opensearch.search.aggregations.bucket.filter.Filter;
        for (int i = 0; i < 10; i++) {
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
import org.opensearch.plugins.Plugin;
        assertThat(stats.getMax(), equalTo(expectedMaxValue));
            assertThat(stats.getMin(), equalTo(Double.POSITIVE_INFINITY));
            .addAggregation(
            Stats stats = filter.getAggregations().get("stats");
            .addAggregation(stats("stats").field("value"))
            Terms.Bucket bucket = buckets.get(i);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        SearchResponse r = client().prepareSearch("cache_test_idx")
            equalTo(1L)
                .getRequestCache()
                .getTotal()
            .setQuery(matchAllQuery())
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
                .get()
import org.opensearch.action.search.SearchResponse;
            equalTo(0L)
        ShardSearchFailure[] failures = response.getShardFailures();
            for (ShardSearchFailure failure : failures) {
            assertThat(statsAgg.getMin(), closeTo(1.0, 0.1));
            .setQuery(matchAllQuery())
                .prepareStats("cache_test_idx")
                .getHitCount(),
                .getTotal()
            internalCluster().wipeIndices("test_stats_agg");
                .indices()
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
                .getMissCount(),
                .getHitCount(),
        SearchResponse searchResponse = client().prepareSearch("idx")
                .getRequestCache()
        assertThat(stats.getMax(), equalTo(10.0));
                .get()
                .indices()
        assertHitCount(searchResponse, 10);
        assertThat(stats.getSum(), equalTo(expectedSumValue));
import org.opensearch.search.aggregations.BucketOrder;
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
            .setQuery(matchAllQuery())
        Histogram.Bucket bucket = histo.getBuckets().get(1);
import org.apache.logging.log4j.message.ParameterizedMessage;
        assertThat("Not all shards are initialized", response.getSuccessfulShards(), equalTo(response.getTotalShards()));
        assertThat(stats.getMin(), equalTo(2.0));
        assertThat(stats.getCount(), equalTo(0L));
    }
        assertSearchResponse(r);
        assertThat(Double.isNaN(stats.getAvg()), is(true));
                .get()
            .addAggregation(
        assertSearchResponse(r);
import org.opensearch.action.search.ShardSearchFailure;
            assertThat(stats.getAvg(), equalTo(Double.NaN));
        assertThat(stats.getMin(), equalTo(expectedMinValue));
        }
import org.opensearch.script.Script;
                Settings.builder()
            equalTo(2L)
                .prepareStats("cache_test_idx")
        // Test that a request using a nondeterministic script does not get cached
            assertThat(stats, notNullValue());
        assertHitCount(searchResponse, 10);
                .getRequestCache()
 * under the License.
                .get()
        // Ensure that non-scripted requests are cached as normal
        Global global = searchResponse.getAggregations().get("global");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .setQuery(matchAllQuery())
        assertThat(stats.getMin(), equalTo(Double.POSITIVE_INFINITY));
        );
    @Override
            }
    @Override
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);
        internalCluster().wipeIndices("cache_test_idx");
            .get();
                .getTotal()
        assertThat(
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            client().admin()
                .get()
        assertShardExecutionState(searchResponse, 0);
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
            assertThat(stats.getMax(), equalTo(Double.NEGATIVE_INFINITY));
        assertThat(stats.getMin(), equalTo(1.0));
                .setRequestCache(true)
        assertThat(stats.getMax(), equalTo(12.0));
    @ParametersFactory
        );
            .setQuery(matchAllQuery())
        r = client().prepareSearch("cache_test_idx")
                .getRequestCache()
     * Ensure requests using nondeterministic scripts do not get cached.
    public void testStatsWithIntraSegmentPartitioning() throws Exception {
            .setSize(0)
 * software distributed under the License is distributed on an
        );
            stats.getAvg(),
    public StatsIT(Settings staticSettings) {
package org.opensearch.search.aggregations.metrics;
        assertThat((double) ((InternalAggregation) global).getProperty("stats.sum"), equalTo(expectedSumValue));
        assertThat(stats.getName(), equalTo("stats"));
        assertThat(
        );
            .addAggregation(
                .get()
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
        assertHitCount(searchResponse, 10);
            assertThat(bucket.getDocCount(), equalTo(1L));
    public void testOrderByEmptyAggregation() throws Exception {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
            equalTo(0L)
            assertThat(stats.getCount(), equalTo(0L));
import static org.hamcrest.Matchers.equalTo;
        super(staticSettings);
        return Collections.singleton(AggregationTestScriptsPlugin.class);
 * Modifications Copyright OpenSearch Contributors. See
        );
 * ownership. Elasticsearch licenses this file to you under
    public static Collection<Object[]> parameters() {
 * this work for additional information regarding copyright
            equalTo(0L)
        );
        assertThat(
                .getTotal()
                .indices()
        double expectedAvgValue = (double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10;
        assertThat(stats.getName(), equalTo("stats"));
            SearchResponse response = client().prepareSearch("test_stats_agg").addAggregation(stats("stats").field("value")).get();
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
        assertThat(stats.getName(), equalTo("stats"));
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(stats.getMinAsString(), equalTo("0001.0"));
            Filter filter = bucket.getAggregations().get("filter");
            client().admin()
        assertThat(
                .getHitCount(),
                .setRequestCache(true)
            .addAggregation(stats("stats").format("0000.0").field("value"))
 * Licensed to Elasticsearch under one or more contributor
        assertThat(stats.getAvg(), equalTo(expectedAvgValue));
            assertThat(statsAgg.getMax(), closeTo(5000.0, 0.1));
                .getHitCount(),
            .get();
        assertThat(global.getDocCount(), equalTo(10L));
import org.opensearch.search.aggregations.InternalAggregation;
        Stats statsFromProperty = (Stats) ((InternalAggregation) global).getProperty("stats");
    @Override
        assertThat(stats.getSumAsString(), equalTo("0055.0"));
        assertThat(stats, notNullValue());
            equalTo(0L)
            client().admin()
        double expectedMinValue = 1.0;
/*
        Stats stats = searchResponse.getAggregations().get("stats");
    public void testScriptCaching() throws Exception {
    }
        SearchResponse searchResponse = client().prepareSearch("idx")
                .indices()
            assertThat(filter.getDocCount(), equalTo(0L));
        Stats stats = bucket.getAggregations().get("stats");
            indexBulkWithSegments(builders, 2);
            .get();
        assertShardExecutionState(searchResponse, 0);
        assertThat(global.getAggregations(), notNullValue());
        assertThat(stats.getAvgAsString(), equalTo("0005.5"));
                .get()
 * GitHub history for details.
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertThat(terms, notNullValue());
 *
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
                expectedSum += (i + 1);
                .getMissCount(),
            assertThat(statsAgg.getCount(), equalTo(5000L));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                .prepareStats("cache_test_idx")
    }
