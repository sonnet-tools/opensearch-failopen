                .setRequestCache(true)
        assertThat(stats, notNullValue());  
                .get()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                .setRequestCache(true)
            assertThat(statsAgg.getSum(), closeTo((double) expectedSum, 0.1));
                .setRequestCache(true)
        Terms terms = searchResponse.getAggregations().get("terms");
        for (int i = 0; i < 10; i++) {
        assertThat(
            assertThat(statsAgg.getMin(), closeTo(1.0, 0.1));
        assertSearchResponse(r);
 * software distributed under the License is distributed on an
        assertThat(stats.getAvgAsString(), equalTo("0005.5"));  
    }  
        assertThat(buckets, notNullValue());
        );
            .get();  
            .addAggregation(  
        assertThat(global, notNullValue());
        assertThat((double) ((InternalAggregation) global).getProperty("stats.sum"), equalTo(expectedSumValue));
        assertThat(stats.getMax(), equalTo(10.0));  
                .getRequestCache()
                .getRequestCache()
        assertThat(stats.getCount(), equalTo(10L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);  
        r = client().prepareSearch("cache_test_idx")
import java.util.List;
    }
    @Override
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
                .get()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
            new Object[] {  
        try {
        assertShardExecutionState(searchResponse, 0);  
            .setQuery(matchAllQuery())
import static org.hamcrest.Matchers.equalTo;
    public static Collection<Object[]> parameters() {
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertThat(stats.getMax(), equalTo(Double.NEGATIVE_INFINITY));
    }  
     * Ensure requests using nondeterministic scripts do not get cached.
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
        assertThat(stats.getAvg(), equalTo(expectedAvgValue));  
        Stats stats = searchResponse.getAggregations().get("stats");  
        assertHitCount(searchResponse, 10);
                .getTotal()
                .setRequestCache(true)
        assertHitCount(searchResponse, 10);
            equalTo(0L)  
        Stats stats = bucket.getAggregations().get("stats");
        assertThat(statsFromProperty, notNullValue());  
        );
                    .build() }
import org.opensearch.common.settings.Settings;  
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(global.getAggregations(), notNullValue());
                .getMissCount(),
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
            assertThat(stats.getCount(), equalTo(0L));
            assertThat(filter.getDocCount(), equalTo(0L));  
        assertThat(  
            assertThat(statsAgg.getAvg(), closeTo((double) expectedSum / 5000, 0.1));
        assertShardExecutionState(searchResponse, 0);
                .prepareStats("cache_test_idx")  
import java.util.ArrayList;  
            .setSize(0)
        assertThat(stats.getMaxAsString(), equalTo("0010.0"));
        SearchResponse searchResponse = client().prepareSearch("idx")  
    @Override
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 *  
        double expectedAvgValue = (double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10;
                .getHitCount(),  
                .setRequestCache(true)
        assertHitCount(searchResponse, 10);  
            assertThat(stats.getMax(), equalTo(Double.NEGATIVE_INFINITY));
    }  
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
        assertThat(  
                .setRequestCache(true)
        assertThat(bucket, notNullValue());
                .getRequestCache()
                stats("foo").field("d")
    private void assertShardExecutionState(SearchResponse response, int expectedFailures) throws Exception {  
            assertThat(bucket, notNullValue());
            .get();  
        ShardSearchFailure[] failures = response.getShardFailures();
        // Make sure we are starting with a clear cache  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
                .indices()
        assertAcked(
        assertThat(
import org.opensearch.search.aggregations.bucket.filter.Filter;
        assertThat(stats.getName(), equalTo("stats"));
    public void testScriptCaching() throws Exception {  
        assertThat(stats, notNullValue());
import org.opensearch.search.aggregations.InternalAggregation;  
        assertThat(stats.getMax(), equalTo(expectedMaxValue));  
    }  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + 1", Collections.emptyMap()))
            indexRandomForConcurrentSearch("test_stats_agg");  
                stats("foo").field("d")
            )  
        assertThat(
            assertThat(statsAgg.getMax(), closeTo(5000.0, 0.1));  
    @Override
                .getTotal()  
            stats.getAvg(),
    public void testOrderByEmptyAggregation() throws Exception {
        assertThat(stats.getName(), equalTo("stats"));  
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>stats.avg", true)))
                .indices()
public class StatsIT extends AbstractNumericTestCase {
        assertThat(stats.getName(), equalTo("stats"));
            .setQuery(matchAllQuery())
                .getMissCount(),
            equalTo(0L)
        assertThat(stats, notNullValue());
    }
                .setRequestCache(true)
            .setQuery(matchAllQuery())
        );
            )  
 * Licensed to Elasticsearch under one or more contributor  
        // Test that a request using a deterministic script gets cached  
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
            client().admin()
            client().admin()
        );
        assertThat(
                terms("terms").field("value")  
                .getRequestCache()
                    .subAggregation(filter("filter", termQuery("value", 100)).subAggregation(stats("stats").field("value")))
/*
        assertThat(stats.getSum(), equalTo(0.0));
            equalTo(0L)  
import org.opensearch.search.aggregations.bucket.global.Global;
    public StatsIT(Settings staticSettings) {
            client().admin()
            .get();
        Stats stats = searchResponse.getAggregations().get("stats");
 */
                .get()  
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
                .setRequestCache(true)
            assertThat(statsAgg.getCount(), equalTo(5000L));
                .getRequestCache()
    }
    public void testSingleValuedField_WithFormatter() throws Exception {
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;  
    public void testStatsWithIntraSegmentPartitioning() throws Exception {
 */  
                .indices()  
                .prepareStats("cache_test_idx")
 * The OpenSearch Contributors require contributions made to  
        );
            equalTo(0L)
 * You may obtain a copy of the License at  
        assertThat(  
                expectedSum += (i + 1);
            client().admin()
            fail("Unexpected shard failures!");  
            .get();
            assertThat(stats.getSum(), equalTo(0.0));  
        Stats stats = searchResponse.getAggregations().get("stats");
                .get()  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
                .prepareStats("cache_test_idx")
        indexRandom(  
            .get();
    }
        // Ensure that non-scripted requests are cached as normal  
        assertShardExecutionState(searchResponse, 0);
                .indices()  
        assertThat(stats.getName(), equalTo("stats"));
            equalTo(0L)
import java.util.Collection;
                .getMissCount(),
        assertThat(stats.getMax(), equalTo(12.0));
        }  
        createIndex("test_stats_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());  
 * ownership. Elasticsearch licenses this file to you under  
            client().admin()
            .addAggregation(stats("stats").field("values"))
 * not use this file except in compliance with the License.
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
    @Override
                .get()
    public void testSingleValuedField() throws Exception {  
                .get()
                .get()
import org.opensearch.script.ScriptType;  
 * specific language governing permissions and limitations
                .prepareStats("cache_test_idx")  
            indexBulkWithSegments(builders, 2);
                .prepareStats("cache_test_idx")
        assertThat(stats.getCount(), equalTo(0L));
                .indices()  
    /**
 * license agreements. See the NOTICE file distributed with
        assertThat("Not all shards are initialized", response.getSuccessfulShards(), equalTo(response.getTotalShards()));
        );
            assertThat(bucket.getDocCount(), equalTo(1L));  
                .getRequestCache()
                Settings.builder()
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)  
import static org.hamcrest.Matchers.is;  
            .addAggregation(  
import static org.opensearch.search.aggregations.AggregationBuilders.global;  
            .addAggregation(global("global").subAggregation(stats("stats").field("value")))
    @ParametersFactory  
        if (failures.length != expectedFailures) {
import org.apache.logging.log4j.message.ParameterizedMessage;
                .getTotal()
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
            client().admin()
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
        assertThat(stats, notNullValue());
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(buckets.size(), equalTo(10));  
                .getRequestCache()
import org.opensearch.action.search.ShardSearchFailure;
        );
        assertSearchResponse(r);
     * Make sure that a request using a deterministic script or not using a script get cached.  
package org.opensearch.search.aggregations.metrics;
        assertThat(stats.getMin(), equalTo(1.0));
    public void testMultiValuedField() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .addAggregation(
}
import org.opensearch.search.aggregations.bucket.histogram.Histogram;  
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
            equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12) / 20)
            .setQuery(matchAllQuery())
            .setQuery(matchAllQuery())
import static org.hamcrest.Matchers.notNullValue;
 * GitHub history for details.
            true,
            Stats stats = filter.getAggregations().get("stats");
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", Collections.emptyMap()))
        SearchResponse searchResponse = client().prepareSearch("idx")  
                .getHitCount(),  
import java.util.Arrays;
    public void testEmptyAggregation() throws Exception {
        assertThat((double) ((InternalAggregation) global).getProperty("stats.max"), equalTo(expectedMaxValue));
            assertThat(stats.getAvg(), equalTo(Double.NaN));
        long expectedCountValue = 10;
            for (int i = 0; i < 5000; i++) {
        SearchResponse searchResponse = client().prepareSearch("idx")  
            }
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(stats("foo").field("d")).get();
            internalCluster().wipeIndices("test_stats_agg");
        assertThat(stats.getMin(), equalTo(2.0));
 * this work for additional information regarding copyright
                .get()
     */
        assertThat(stats.getName(), equalTo("stats"));  
            assertThat(statsAgg, notNullValue());  
                .prepareStats("cache_test_idx")  
        Global global = searchResponse.getAggregations().get("global");
                .getHitCount(),  
            .addAggregation(stats("stats").field("value"))  
        assertThat(stats.getMinAsString(), equalTo("0001.0"));
import org.opensearch.search.aggregations.BucketOrder;
        assertThat(stats.getCount(), equalTo(20L));
            .setSize(0)
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
        assertThat(stats.getMax(), equalTo(10.0));  
                .indices()
            }
        assertThat(stats.getCount(), equalTo(expectedCountValue));  
import org.opensearch.plugins.Plugin;
        Stats statsFromProperty = (Stats) ((InternalAggregation) global).getProperty("stats");
import org.opensearch.action.index.IndexRequestBuilder;  
 *
                .indices()  
            equalTo(1L)  
import static org.hamcrest.Matchers.sameInstance;
            client().admin()
        assertThat(global.getDocCount(), equalTo(10L));
                .get()  
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)  
            equalTo(2L)  
                .getTotal()
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(  
        assertThat(stats.getCount(), equalTo(10L));
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12));  
        assertThat(statsFromProperty, sameInstance(stats));
                .getMissCount(),
        );
import static org.hamcrest.Matchers.closeTo;
        }
 * KIND, either express or implied.  See the License for the
        Histogram histo = searchResponse.getAggregations().get("histo");
        assertThat((double) ((InternalAggregation) global).getProperty("stats.min"), equalTo(expectedMinValue));
 * Unless required by applicable law or agreed to in writing,
                .prepareStats("cache_test_idx")
import org.opensearch.search.aggregations.bucket.terms.Terms;
    public void testSingleValuedFieldGetProperty() throws Exception {
            assertThat(filter, notNullValue());
import org.opensearch.action.search.SearchResponse;
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
    }  
        internalCluster().wipeIndices("cache_test_idx");
            assertThat(stats, notNullValue());
        SearchResponse r = client().prepareSearch("cache_test_idx")
    }
                .getTotal()  
            SearchResponse response = client().prepareSearch("test_stats_agg").addAggregation(stats("stats").field("value")).get();
        assertThat(  
        double expectedMaxValue = 10.0;
            long expectedSum = 0;
        return Arrays.asList(
        );
 * SPDX-License-Identifier: Apache-2.0
        );
        double expectedMinValue = 1.0;
        );
                .prepareStats("cache_test_idx")  
        assertThat(Double.isNaN(stats.getAvg()), is(true));
        }
                .getHitCount(),  
        assertThat((double) ((InternalAggregation) global).getProperty("stats.count"), equalTo((double) expectedCountValue));
            assertThat(stats.getMin(), equalTo(Double.POSITIVE_INFINITY));  
            client().admin()
                .getTotal()  
    @Override
        return Collections.singleton(AggregationTestScriptsPlugin.class);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        Histogram.Bucket bucket = histo.getBuckets().get(1);
 * under the License.  
            .addAggregation(stats("stats").format("0000.0").field("value"))  
                .getTotal()  
 */
    }  
                .indices()
            Terms.Bucket bucket = buckets.get(i);  
/*  
            equalTo(0L)
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;  
        assertThat((double) ((InternalAggregation) global).getProperty("stats.avg"), equalTo(expectedAvgValue));
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")  
        assertHitCount(searchResponse, 10);  
        assertThat(stats.getSum(), equalTo(expectedSumValue));  
                .getTotal()
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
        } finally {  
        );  
        assertThat(stats.getMin(), equalTo(1.0));
            .get();
/*
        assertThat(stats.getMin(), equalTo(Double.POSITIVE_INFINITY));  
    @Override
 *
        assertThat(global.getName(), equalTo("global"));  
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(global.getAggregations().asMap().size(), equalTo(1));  
        assertThat(stats.getMin(), equalTo(expectedMinValue));  
            .get();
        // Test that a request using a nondeterministic script does not get cached  
            for (ShardSearchFailure failure : failures) {  
        double expectedSumValue = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
                builders.add(client().prepareIndex("test_stats_agg").setSource("value", i + 1));  
            )  
        assertHitCount(searchResponse, 10);
 * compatible open source license.
        assertThat(histo, notNullValue());  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.script.Script;
            .addAggregation(histogram("histo").field("value").interval(1L).minDocCount(0).subAggregation(stats("stats").field("value")))
            Filter filter = bucket.getAggregations().get("filter");
        assertSearchResponse(r);
            .setQuery(matchAllQuery())
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
        Stats stats = global.getAggregations().get("stats");
                logger.error(new ParameterizedMessage("Shard Failure: {}", failure), failure.getCause());
        assertThat(stats, notNullValue());  
            Stats statsAgg = response.getAggregations().get("stats");
        super(staticSettings);  
                .getRequestCache()
            .get();  
        assertThat(stats.getSumAsString(), equalTo("0055.0"));  
        assertThat(terms, notNullValue());  
