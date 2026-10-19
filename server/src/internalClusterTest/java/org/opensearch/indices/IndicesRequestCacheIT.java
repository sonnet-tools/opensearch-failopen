            .setSize(0)
        assertCacheState(client, index, 0, 0);
            .setSize(0)
        assertQueryCausesCacheState(client, index, QueryBuilders.rangeQuery(field1).gte("f").lte("g"), 0, 1, cacheSize);
            .setWaitForNoInitializingShards(true)
        Client client = client(node_1);
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        indexRandom(
            .setSize(0)
        Client client = client();
        createIndex(
            client.prepareIndex(index).setId("4").setRouting("2").setSource("s", "2016-03-22"),
            .setRequestCache(true)
        // If the request has an non-filter aggregation containing now we should not cache
        });
        assertThat(r2.getHits().getTotalHits().value(), equalTo(9L));
        forceMerge(client, index);
        assertAcked(client.admin().indices().prepareCreate("index-3").setMapping("d", "type=date").setSettings(settings).get());
            1,
                dateHistogram("histo").field("f")
        RequestCacheStats stats = getNodeCacheStats(client);
/*
            .setWaitForNoRelocatingShards(true)
    }
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-22").lte("2016-03-26"))
        // it depends on `InternalTestCluster.numDataPaths`.
        // the cache flag is explicitly set on the request
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                .setProfile(profile)
            .prepareHealth()
                .setRequestCache(true)
            client.prepareIndex(index).setId("2").setSource("d", "2014-02-01T00:00:00"),
                        // Disable index refreshing to avoid cache being invalidated mid-test
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .get();
        final SearchResponse r2 = client.prepareSearch("index-*")
        return client.admin().indices().prepareStats(index).setRequestCache(true).get().getTotal().getRequestCache();
        OpenSearchAssertions.assertAllSuccessful(r1);
import org.apache.lucene.search.Weight;
            Settings.builder().put(INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING.getKey(), maxCacheableSize)
        indexRandom(true, client.prepareIndex(index).setSource("k", "hello"));
            .get();
        );
            .setQuery(QueryBuilders.rangeQuery("created_at").gte("now-7d/d"))
        assertCacheState(client, "index-1", 0, 0);
        );
            assertCacheState(client, index, expectedHits, expectedMisses);
    private static void assertCacheState(Client client, String index, long expectedHits, long expectedMisses) {
    }
 * GitHub history for details.
        assertCacheState(client, "index-3", 0, 0);
                        .put("index.number_of_routing_shards", 5)
        assertThat(cluster().size(), equalTo(2));
    public void testCanCache() throws Exception {
        super(settings);
            Histogram h1 = r1.getAggregations().get("histo");
        // Now test all query building methods on field1 and ensure none are cacheable
import org.apache.lucene.index.Term;
                    Settings.builder()
            boolean profile = i % 2 == 0;
        );
            .setRequestCache(true)
            .get();
                    dateHistogram("histo").field("f")
        NodesStatsResponse stats = client.admin().cluster().prepareNodesStats().execute().actionGet();
        Settings settings = Settings.builder()
import org.opensearch.action.search.SearchType;
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
            assertEquals(buckets1.size(), buckets2.size());
 */
    }
        ForceMergeResponse forceMergeResponse = client.admin()
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
            client.prepareIndex(index).setId("5").setRouting("2").setSource("s", "2016-03-23"),
            client.prepareIndex(index).setId("6").setSource("d", "2014-06-01T00:00:00"),
            0,
            greaterThan(0L)
        ensureSearchable(index);
            client.prepareIndex(index).setId("1").setSource("d", "2014-01-01T00:00:00"),
        // When keyword fields have non-default values for "use_similarity" or "split_queries_on_whitespace",
 * SPDX-License-Identifier: Apache-2.0
        refreshAndWaitForReplication();
            client.prepareIndex(index).setId("5").setSource("d", "2014-05-01T00:00:00"),
import java.util.Arrays;
        assertCacheState(client, index, 1, 2);
        indexRandom(
    public void testQueryRewriteMissingValues() throws Exception {
    }
            if (stat.getNode().isDataNode()) {
        assertCacheState(client, index, 0, 0);
                QueryBuilders.boolQuery().should(QueryBuilders.termQuery(field1, "foo")).should(QueryBuilders.termQuery(field1, "foo2"))
            .setSize(0)
                    Settings.builder()
import static org.opensearch.search.aggregations.AggregationBuilders.dateRange;
        String index = "index";
        final SearchResponse r1 = client.prepareSearch(index)
        logger.info("Disabling allocation");
        assertAcked(client.admin().indices().prepareCreate("index-2").setMapping("d", "type=date").setSettings(settings).get());
import static org.opensearch.indices.IndicesRequestCache.INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING;
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
            .get();
        String index = "index";
                )
            client.prepareIndex(index).setId("9").setSource("s", "2016-03-27")
import org.opensearch.common.unit.TimeValue;
                .indices()
    }
            .setSize(0)
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
            Settings.builder()
            client.admin()
        assertEquals(expectedMemory, stats.getMemorySizeInBytes());
        OpenSearchAssertions.assertAllSuccessful(r1);
        assertAcked(client.admin().indices().prepareCreate("index-1").setMapping("d", "type=date").setSettings(settings).get());
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
        for (NodeStats stat : stats.getNodes()) {
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            .setSize(0)
        assertAcked(
                        try {
            client.prepareIndex(index).setId("2").setSource("s", "2016-03-20"),
                            Thread.sleep(500);
            .get();
            .addAggregation(new GlobalAggregationBuilder("global"))
            }
        assertThat(
            .setQuery(QueryBuilders.rangeQuery("d").gte("now-7d/d").lte("now"))
            .get();
        Client client = client();
            .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
            assertFalse(Arrays.stream(shardDirectory(node_1, index, 0)).anyMatch(Files::exists));
/*
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
        );
        assertCacheState(client, index, 0, 0);
        assertTrue(cacheSize > 0);
import org.opensearch.test.hamcrest.OpenSearchAssertions;
            final List<? extends Bucket> buckets2 = h2.getBuckets();
        assertTrue(stats.getMemorySizeInBytes() == 0);
        Client client = client();
        assertCacheState(client, index, 0, 6);
                    .timeZone(ZoneId.of("+01:00"))
        assertThat(r1.getHits().getTotalHits().value(), equalTo(9L));
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
        internalCluster().client().admin().cluster().prepareReroute().add(cmd).get();
        // The cache should be empty as the timed-out query was invalidated
        assertTrue(stats.getMemorySizeInBytes() == 0);
                .indices()
                .prepareCreate(index)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
                .get();
        OpenSearchAssertions.assertAllSuccessful(r7);
            .get();
        return paths;
            .addAggregation(
 * Unless required by applicable law or agreed to in writing,
            client.prepareIndex(index).setId("7").setSource("d", "2014-07-01T00:00:00"),
            client.prepareIndex(index).setId("8").setRouting("3").setSource("s", "2016-03-26"),
            .get();
            .setSize(0)
                return stat.getIndices().getRequestCache();
        int expectedHits = 0;
            .addAggregation(new GlobalAggregationBuilder("global"))
        // If the request has a filter aggregation containing now we should cache since it gets rewritten
        assertCacheState(client, index, 0, 5);
            .get();
            client.admin().indices().prepareStats(index).setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
        forceMerge(client, index);
                    Settings.builder()
            .setRequestCache(true)
    public void testQueryRewriteDatesWithNow() throws Exception {
        forceMerge(client, index);
        SearchResponse resp = client.prepareSearch(index).setRequestCache(true).setQuery(builder).get();
            .setWaitForNoInitializingShards(true)
        assertAcked(
        assertCacheState(client, index, 0, 0);
        final SearchResponse r8 = client.prepareSearch(index)
            .get();
                .setSettings(
        );
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        assertEquals(0, requestCacheStats.getMemorySizeInBytes());
        assertThat(r2.getHits().getTotalHits().value(), equalTo(8L));
                .get()
 * under the License.
        assertCacheState(client, index, 0, 0);
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        String field1 = "field1";
            Settings.builder().put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY, TimeValue.timeValueMillis(50))
                .build()
        for (int i = 0; i < 10; ++i) {
    }
                .indices()
        assertAcked(
        return null;
        assertSearchResponse(resp);
            client.admin()
 * not use this file except in compliance with the License.
            .addAggregation(dateRange("foo").field("s").addRange("2016-01-01", "now"))
        });
import org.apache.lucene.search.IndexSearcher;
            client.prepareIndex(index).setId("3").setRouting("1").setSource("s", "2016-03-21"),
                .setMapping("s", "type=date")
        // Update max cacheable size for request cache from default value of 0
        String node = internalCluster().startNode(
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
        Settings settings = Settings.builder()
    private void testKeywordFieldParameterCacheabilityCase(String paramName) throws Exception {
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        String field2 = "field2";
            0,
            client.prepareIndex(index).setId("5").setSource("s", "2016-03-23"),
                        // Disable index refreshing to avoid cache being invalidated mid-test
        int maxCacheableSize = 5;
        Client client,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            client.admin()
        assertThat(r1.getHits().getTotalHits().value(), equalTo(7L));
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(newSettings).execute().actionGet();
        final SearchResponse r6 = client.prepareSearch(index)
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
            client.prepareIndex(index).setId("1").setRouting("1").setSource("s", "2016-03-19"),
                .setSettings(
        stats = getNodeCacheStats(client(node_1));
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
        final SearchResponse r2 = client.prepareSearch(index)
        final SearchResponse r3 = client.prepareSearch(index)
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
 */
        OpenSearchAssertions.assertAllSuccessful(r1);
            client.prepareIndex("index-2").setId("5").setSource("d", formatter.format(now.minusDays(4))),
            client.prepareIndex("index-1").setId("1").setSource("d", formatter.format(now)),
        );
        final SearchResponse r2 = client.prepareSearch(index)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
                .indices()
        ensureSearchable(index);
            assertThat(resp.getHits().getTotalHits().value(), equalTo(1L));
                .prepareCreate(index)
        String node_2 = internalCluster().startDataOnlyNode(Settings.builder().build());
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        assertCacheState(client, index, 0, 0);
 * You may obtain a copy of the License at
        logger.info("Writing few docs and searching those which will cache items in RequestCache");
        DateFormatter formatter = DateFormatter.forPattern("strict_date_optional_time");
        );
        assertCacheState(client, index, 0, 1);
                .prepareCreate(index)
            .prepareForceMerge("index-1", "index-2", "index-3")
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
                assertEquals(b1.getKey(), b2.getKey());
import org.apache.lucene.search.ScoreMode;
import java.io.IOException;
                .indices()
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge(index).setFlush(true).get();
            .get();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
            .setSize(0)
 *
                    @SuppressForbidden(reason = "Waiting 10x the timeout")
        assertThat(r3.getHits().getTotalHits().value(), equalTo(9L));
            true,
        assertCacheState(client, index, 0, 0);
            .get();
        Client client = client();
import org.opensearch.core.index.shard.ShardId;
            client.prepareIndex("index-3").setId("7").setSource("d", formatter.format(now.minusDays(6))),
        OpenSearchAssertions.assertAllSuccessful(r3);
        long expectedMisses,
        String index = "index";
        assertCacheState(client, index, 2, 1);
                    .minDocCount(0)
            assertSearchResponse(r2);
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
                .setMapping("s", "type=date")
        updateSettingsRequest.persistentSettings(
import org.opensearch.index.IndexSettings;
                    Settings.builder()
        assertCacheState(client, "index-1", 0, 0);
            cacheSize
        // and also shouldn't add any extra entries to the cache
        };
            client.prepareIndex(index).setId("9").setSource("d", "2014-09-01T00:00:00")
        );
import org.opensearch.index.query.TermQueryBuilder;
        assertEquals(expectedMisses, stats.getMissCount());
        OpenSearchAssertions.assertAllSuccessful(r2);
        assertThat(r8.getHits().getTotalHits().value(), equalTo(5L));
        assertThat(healthResponse.isTimedOut(), equalTo(false));
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-19").lte("2016-03-28"))
        indexRandom(true, client.prepareIndex(index).setSource(field1, "foo2", field2, "foo2"));
        testKeywordFieldParameterCacheabilityCase("use_similarity");
            client.prepareIndex(index).setSource("f", "2014-03-10T00:00:00.000Z"),
            true,
            .setWaitForNoRelocatingShards(true)
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        final SearchResponse r4 = client.prepareSearch(index)
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        assertEquals(
        assertQueryCausesCacheState(client, index, QueryBuilders.prefixQuery(field1, "fo"), 0, 1, cacheSize);
            client.prepareIndex(index).setId("7").setRouting("3").setSource("s", "2016-03-25"),
                .indices()
        NodeEnvironment env = internalCluster().getInstance(NodeEnvironment.class, server);
            Histogram h2 = r2.getAggregations().get("histo");
            .cluster()
            SearchResponse resp = client.prepareSearch(index)
        assertCacheState(client, index, 0, 0);
            .setSize(0)
    }
        long expectedHits,
        PutMappingRequest mappingRequest = new PutMappingRequest().indices(index).source(field1, "type=keyword," + paramName + "=true");
        forceMerge(client, index);
        Client client = client();
        int expectedMisses = 0;
            .addAggregation(new GlobalAggregationBuilder("global"))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING;
            final List<? extends Bucket> buckets1 = h1.getBuckets();
            @Override
        // no extra misses and no extra values in cache
        assertBusy(() -> {
        OpenSearchAssertions.assertAllSuccessful(r2);
            client.admin()
            client.prepareIndex(index).setId("8").setSource("s", "2016-03-26"),
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        logger.info("Creating an index: {} with 2 shards", indexName);
        final Path[] paths = env.availableShardPaths(new ShardId(index, shard));
        Settings newSettings = Settings.builder()
                )
                .prepareCreate(index)
            QueryBuilders.boolQuery().should(QueryBuilders.termQuery(field1, "foo")).should(QueryBuilders.termQuery(field1, "foo2")),
        // rewritten and will still contain `now` so won't be recorded as a
    @ParametersFactory
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertBusy(() -> {
            .setSize(0)
        assertCacheState(client, "index-3", 0, 0);
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setSettings(
        String index = "index";
        assertCacheState(client, index, 0, 0);
        final SearchResponse r3 = client.prepareSearch("index-*")
            client.admin()
        }
            client.admin()
            .get();
                )
                )
        );
        internalCluster().client().admin().cluster().prepareReroute().add(cmd).get();
        );
        assertThat(r5.getHits().getTotalHits().value(), equalTo(7L));
            .setQuery(QueryBuilders.rangeQuery("d").gte("2013-01-01T00:00:00").lte("now"))
        ensureGreen(indexName);
    // One of the primary purposes of the query cache is to cache aggs results
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        OpenSearchAssertions.assertAllSuccessful(r1);
import java.nio.file.Files;
            .put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), EnableAllocationDecider.Allocation.NONE.name())
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                )
    private void forceMerge(Client client, String index) {
            client.prepareIndex(index).setId("7").setSource("other", "value"),
        assertEquals(expectedHits, stats.getHitCount());
import org.opensearch.transport.client.Client;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        assertThat(r3.getHits().getTotalHits().value(), equalTo(8L));
    }
                    @Override
        assertCacheState(client, "index-1", 2, 1);
        forceMerge(client, index);
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        );
                        // Disable index refreshing to avoid cache being invalidated mid-test
                .get()
            // to ensure that query is executed even if it rewrites to match_no_docs
 * software distributed under the License is distributed on an
    ) {
import org.opensearch.index.query.QueryShardContext;
        assertQueryCausesCacheState(client, index, QueryBuilders.wildcardQuery(field1, "f*"), 0, 1, cacheSize);
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-21").lte("2016-03-27"))
            true,
        final SearchResponse r2 = client.prepareSearch(index)
            .get();
            client.prepareIndex("index-1").setId("2").setSource("d", formatter.format(now.minusDays(1))),
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-20").lte("2016-03-26"))
        assertCacheState(client, "index-3", 0, 0);
    public void testKeywordFieldUseSimilarityCacheability() throws Exception {
            .setSize(0)
            .get();
        indexRandom(
                .setSearchType(SearchType.QUERY_THEN_FETCH)
    public void testTimedOutQuery() throws Exception {
                .setMapping("f", "type=date")
        final SearchResponse r2 = client.prepareSearch(index)
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        ensureSearchable(index);
            .get();
        assertAcked(
        assertThat(r3.getHits().getTotalHits().value(), equalTo(7L));
        forceMerge(client, index);
            .addAggregation(new GlobalAggregationBuilder("global"))
            client.prepareIndex(index).setId("6").setSource("s", "2016-03-24"),
                .get()
            .build();
            client.prepareIndex(index).setId("3").setSource("s", "2016-03-21"),
        assertThat(r1.getHits().getTotalHits().value(), equalTo(1L));
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
        forceMerge(client, index);
        assertQueryCausesCacheState(
                final Bucket b1 = buckets1.get(j);
            assertEquals(1, Arrays.stream(shardDirectory(node_2, index, 0)).filter(Files::exists).count());
            .prepareHealth()
import org.opensearch.cluster.metadata.IndexMetadata;
            .build();
            cacheSize
        }
        QueryBuilder builder,
        ensureSearchable(index);
import org.apache.lucene.search.TermQuery;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                        // sometimes throw an exception on timeout, rather than timing out gracefully.
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
    }
import org.opensearch.index.query.QueryBuilder;
            true,
        OpenSearchAssertions.assertAllSuccessful(r1);
                        .minDocCount(0)
        OpenSearchAssertions.assertAllSuccessful(r3);
import java.util.concurrent.TimeUnit;
        OpenSearchAssertions.assertAllSuccessful(r2);
                        .timeZone(ZoneId.of("+01:00"))
    private static RequestCacheStats getRequestCacheStats(Client client, String index) {
            .setSize(0)
        );
 * license agreements. See the NOTICE file distributed with
        assertCacheState(client, index, 0, 0);
import org.apache.lucene.search.Query;
            .get();
        indexRandom(true, client.prepareIndex(indexName).setSource("k", "hello"));
            client.prepareIndex(index).setId("1").setRouting("1").setSource("s", "2016-03-19"),
        ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest(indexName);
        assertSearchResponse(resp);
            client.prepareIndex(index).setId("7").setRouting("3").setSource("s", "2016-03-25"),
        client.admin().indices().clearCache(clearIndicesCacheRequest).actionGet();
package org.opensearch.indices;
 * The OpenSearch Contributors require contributions made to
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        String index,
        assertQueryCausesCacheState(
        assertAcked(
        String index = "index";
                .setMapping("created_at", "type=date")
        final SearchResponse r7 = client.prepareSearch(index)
        final SearchResponse r1 = client.prepareSearch(index)
            .setSearchType(SearchType.QUERY_THEN_FETCH)
 * Licensed to Elasticsearch under one or more contributor
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-19").lte("2016-03-25"))
            client.prepareIndex(index).setId("2").setRouting("1").setSource("s", "2016-03-20"),
                    Settings.builder()
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-19").lte("2016-03-28"))
                    Settings.builder()
public class IndicesRequestCacheIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            client.admin()
        );
import org.opensearch.common.time.DateFormatter;
            .get();
                    expectedMisses++;
            .setFlush(true)
            .setQuery(QueryBuilders.rangeQuery("d").gte("now-7d/d").lte("now"))
import org.opensearch.common.SuppressForbidden;
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        assertCacheState(client, index, 1, 1);
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            .setQuery(QueryBuilders.rangeQuery("d").gte("now-7d/d").lte("now"))
import java.nio.file.Path;
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
            }
        String index = "index";
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        ensureSearchable("index-1", "index-2", "index-3");
        );
        assertQueryCausesCacheState(client, index, QueryBuilders.fuzzyQuery(field1, "foe"), 0, 1, cacheSize);
        logger.info("Moving the shard: {} again from node:{} to node:{}", indexName + "#0", node_2, node_1);
            .cluster()
    }
            .setSize(0)
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertCacheState(client, index, 6, 9);
            client.prepareIndex(index).setId("8").setSource("d", "2014-08-01T00:00:00"),
        final SearchResponse r1 = client.prepareSearch(index)
            .setSize(0)
        assertCacheState(client, index, 0, 1);
        assertCacheState(client, index, 0, 0);
        String indexName = "test";
        assertCacheState(client, "index-1", 0, 1);
                        // Disable index refreshing to avoid cache being invalidated mid-test
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        assertCacheState(client, "index-3", 0, 0);
                } else {
        assertCacheState(client, "index-2", 2, 1);
        long expectedMemory
            .setSize(1)
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            .setQuery(timeoutQueryBuilder)
            .get();
            .setSize(0)
        forceMerge(client, indexName);
            client.prepareIndex("index-1").setId("3").setSource("d", formatter.format(now.minusDays(2))),
            .setTimeout(new TimeValue(5, TimeUnit.MILLISECONDS))
            .addAggregation(new GlobalAggregationBuilder("global"))
import java.time.ZoneOffset;
                .setSettings(
            .get();
        Client client = client();
    protected boolean useRandomReplicationStrategy() {
            client,
        assertThat(r3.getHits().getTotalHits().value(), equalTo(7L));
        ensureSearchable(index);
                        // Disable index refreshing to avoid cache being invalidated mid-test
            index,
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-20").lte("2016-03-26"))
            if (profile == false) {
        assertThat(r1.getHits().getTotalHits().value(), equalTo(8L));
        OpenSearchAssertions.assertAllSuccessful(r2);
        assertThat(r1.getHits().getTotalHits().value(), equalTo(1L));
            }
        final SearchResponse r3 = client.prepareSearch(index)
            .setRequestCache(true)
                        Weight result = super.createWeight(searcher, scoreMode, boost);
        assertThat(r3.getHits().getTotalHits().value(), equalTo(8L));
        clusterHealth = client().admin()
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-20").lte("2016-03-26"))
        r1 = client.prepareSearch("last_week").setSearchType(SearchType.QUERY_THEN_FETCH).setSize(0).get();
            .setSize(maxCacheableSize)
            .put("index.number_of_routing_shards", 2)
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
        );
            assertEquals(1, Arrays.stream(shardDirectory(node_1, index, 0)).filter(Files::exists).count());
        OpenSearchAssertions.assertAllSuccessful(r5);
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        // Check the hit count and miss count together so if they are not
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        OpenSearchAssertions.assertAllSuccessful(r3);
        OpenSearchAssertions.assertAllSuccessful(r2);
            OpenSearchAssertions.assertAllSuccessful(resp);
            .get();
                    Settings.builder()
            .get();
        OpenSearchAssertions.assertAllSuccessful(r3);
            .setSearchType(SearchType.QUERY_THEN_FETCH)
    private static RequestCacheStats getNodeCacheStats(Client client) {
        MoveAllocationCommand cmd = new MoveAllocationCommand(indexName, 0, node_1, node_2);
 * specific language governing permissions and limitations
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        final SearchResponse r1 = client.prepareSearch(index)
        // Sizes > the cluster setting value should not be cached
import org.opensearch.action.admin.indices.alias.Alias;
            .setQuery(QueryBuilders.rangeQuery("created_at").gte("now-7d/d"))
                .setMapping("k", "type=keyword")
                        // Create the weight before sleeping. Otherwise, TermStates.build() (in the call to super.createWeight()) will
        OpenSearchAssertions.assertAllSuccessful(r1);
            Arrays.asList(expectedHits, expectedMisses, 0L),
            client.prepareIndex(index).setSource("f", "2014-05-13T00:00:00.000Z")
 * ownership. Elasticsearch licenses this file to you under
                .indices()
        RequestCacheStats stats = getNodeCacheStats(client);
                .setMapping("d", "type=date")
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
        logger.info("Starting a second node");
        cmd = new MoveAllocationCommand(indexName, 0, node_2, node_1);
            .build();
        assertCacheState(client, index, 2, 2);
            .setRequestCache(true)
            QueryBuilders.boolQuery().should(QueryBuilders.termQuery(field1, "foo")).should(QueryBuilders.termQuery(field2, "foo2")),
            client.prepareIndex("index-3").setId("9").setSource("d", formatter.format(now.minusDays(8)))
        assertThat(r1.getHits().getTotalHits().value(), equalTo(8L));
import java.util.Collection;
 * this work for additional information regarding copyright
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
                        .dateHistogramInterval(DateHistogramInterval.MONTH)
                .prepareCreate(index)
        OpenSearchAssertions.assertAllSuccessful(r1);
        assertCacheState(client, index, 0, 0);
        for (int i = 0; i < 5; i++) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        ensureSearchable(indexName);
        ClusterHealthResponse clusterHealth = client().admin()
            true,
        SearchResponse resp = client.prepareSearch(indexName).setRequestCache(true).setQuery(QueryBuilders.termQuery("k", "hello")).get();
            for (int j = 0; j < buckets1.size(); ++j) {
            .get();
        r1 = client.prepareSearch(index)
        assertAcked(
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        OpenSearchAssertions.assertAllSuccessful(r4);
    }
 * the Apache License, Version 2.0 (the "License"); you may
        long cacheSize = stats.getMemorySizeInBytes();
        assertSearchResponse(r1);
            client.prepareIndex(index).setId("6").setRouting("2").setSource("s", "2016-03-24"),
        // A timed out query should be cached and then invalidated
        ensureSearchable("index-1", "index-2", "index-3");
import org.opensearch.index.cache.request.RequestCacheStats;
            client.prepareIndex("index-2").setId("4").setSource("d", formatter.format(now.minusDays(3))),
 * Modifications Copyright OpenSearch Contributors. See
    }
            .setSize(0)
import org.opensearch.cluster.ClusterState;
    }
        indexRandom(true, client.prepareIndex(index).setSource(field1, "foo", field2, "foo"));
        assertThat(r2.getHits().getTotalHits().value(), equalTo(7L));
        assertCacheState(client, "index-3", 0, 0);
        Client client = client();
        // This query should be cached
    }
        Client client = client();
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
            client.prepareIndex(index).setId("5").setRouting("2").setSource("s", "2016-03-23"),
                .get()
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        final Index index = state.metadata().index(indexName).getIndex();
                        } catch (InterruptedException ignored) {}
            client,
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
    public void testProfileDisableCache() throws Exception {
        indexRandom(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.time.ZonedDateTime;
            )
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/14288")
    }
        assertThat(r7.getHits().getTotalHits().value(), equalTo(5L));
            .get();
    }
        assertThat(cluster().size(), equalTo(1));
                .setMapping(field1, "type=keyword," + paramName + "=false", field2, "type=keyword," + paramName + "=true")
                .get()
                }
        assertCacheState(client, "index-1", 1, 1);
        client.admin().indices().putMapping(mappingRequest).actionGet();
 *
        assertCacheState(client, index, 0, 0);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            protected Query doToQuery(QueryShardContext context) {
        final SearchResponse r1 = client.prepareSearch("index-*")
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setSize(0)
        SearchResponse resp = client.prepareSearch(index)
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("1").execute().actionGet();
    public static Collection<Object[]> parameters() {
            assertFalse(Arrays.stream(shardDirectory(node_2, index, 0)).anyMatch(Files::exists));
        // If size > 1 and cache flag is set on the request we should cache
        QueryBuilder timeoutQueryBuilder = new TermQueryBuilder("k", "hello") {
import org.opensearch.index.query.QueryBuilders;
                assertEquals(b1.getDocCount(), b2.getDocCount());
        refreshAndWaitForReplication();
 */
            client.prepareIndex(index).setId("9").setRouting("3").setSource("s", "2016-03-27")
                return new TermQuery(new Term("k", "hello")) {
    }
                )
        ClusterState state = client().admin().cluster().prepareState().get().getState();
            .setSize(maxCacheableSize + 1)
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
        assertQueryCausesCacheState(client, index, QueryBuilders.regexpQuery(field1, "f*o"), 0, 1, cacheSize);
        // the available paths of the shard may be bigger than the 1,
        RequestCacheStats stats = getNodeCacheStats(client);
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
import org.opensearch.core.index.Index;
        assertThat(r1.getHits().getTotalHits().value(), equalTo(1L));
        assertCacheState(client, "index-2", 0, 1);
        ensureSearchable(index);
            client.prepareIndex(index).setId("8").setRouting("3").setSource("s", "2016-03-26"),
            client.prepareIndex(index).setId("3").setRouting("1").setSource("s", "2016-03-21"),
        // Because the query will INTERSECT with the 3rd index it will not be
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-20").lte("2016-03-26"))
            .get();
        stats = getNodeCacheStats(client(node_2));
    }
        );
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 * KIND, either express or implied.  See the License for the
        assertEquals(1, stats.getMissCount());
        forceMerge(client, index);
                        // Disable index refreshing to avoid cache being invalidated mid-test
                .prepareCreate(index)
            .setQuery(QueryBuilders.rangeQuery("d").gte("2013-01-01T00:00:00").lte("now"))
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                .setSettings(
        // This is not a random example: serialization with time zones writes shared strings
            .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        Settings settings = Settings.builder()
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("k", "hello"))
            .setSize(1)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
                .setSettings(
            .addAggregation(filter("foo", QueryBuilders.rangeQuery("s").from("2016-01-01").to("now")))
        assertCacheState(client, index, 2, 1);
    }
        // correct we can see both values
        indexRandom(true, client.prepareIndex(index).setSource("k", "hello"));
import java.time.ZoneId;
            client.prepareIndex(index).setId("4").setSource("s", "2016-03-22"),
import java.time.format.DateTimeFormatter;
        // If search type is DFS_QUERY_THEN_FETCH we should not cache even if
    public void testCacheWithFilteredAlias() throws InterruptedException {
                )
        assertThat(r2.getHits().getTotalHits().value(), equalTo(8L));
            )
                .indices()
        String index = "index";
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            true,
        assertQueryCausesCacheState(client, index, QueryBuilders.termsQuery(field1, "foo", "foo2"), 0, 1, cacheSize);
 * this file be licensed under the Apache-2.0 license or a
                .addAlias(new Alias("last_week").filter(QueryBuilders.rangeQuery("created_at").gte("now-7d/d")))
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.action.search.SearchResponse;
        ensureSearchable(index);
            client.prepareIndex("index-2").setId("6").setSource("d", formatter.format(now.minusDays(5))),
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        r1 = client.prepareSearch("last_week").setSearchType(SearchType.QUERY_THEN_FETCH).setSize(0).get();
import org.opensearch.env.NodeEnvironment;
        );
            client.prepareIndex(index).setId("4").setSource("d", "2014-04-01T00:00:00"),
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-20").lte("2016-03-26"))
    public void testDeleteAndCreateSameIndexShardOnSameNode() throws Exception {
        assertCacheState(client, index, 0, 1);
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        assertCacheState(client, "index-2", 1, 1);
    }
        String index = "index";
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-22").lte("2016-03-26"))
        String index = "index";
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        client.prepareIndex(index).setId("1").setRouting("1").setSource("created_at", DateTimeFormatter.ISO_LOCAL_DATE.format(now)).get();
        assertThat(r4.getHits().getTotalHits().value(), equalTo(7L));
                final Bucket b2 = buckets2.get(j);
    private void assertQueryCausesCacheState(
            .setSize(0)
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // see #9500
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        assertCacheState(client, "index-2", 0, 0);
        String node_1 = internalCluster().startNode(Settings.builder().build());
        assertThat(r1.getHits().getTotalHits().value(), equalTo(7L));
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("2").execute().actionGet();
        assertTrue(stats.getMemorySizeInBytes() > 0);
        refreshAndWaitForReplication();
            client.prepareIndex(index).setId("4").setRouting("2").setSource("s", "2016-03-22"),
                .setSettings(
            client.admin()
        // Sizes <= the cluster setting value should be cached
        SearchResponse resp = client.prepareSearch(index)
    public void testQueryRewriteDates() throws Exception {
import static org.hamcrest.Matchers.greaterThan;
        assertAcked(
                .get()
            client.prepareIndex(index).setId("6").setRouting("2").setSource("s", "2016-03-24"),
                .setMapping("k", "type=keyword")
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        indexRandom(true, client.prepareIndex(indexName).setSource("y", "hello again"));
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            // to ensure that query is executed even if it rewrites to match_no_docs
                if (i == 1) {
            .get();
        // cache miss or cache hit since queries containing now can't be cached
    public void testCacheAggs() throws Exception {
            .addAggregation(new GlobalAggregationBuilder("global"))
 * compatible open source license.
            client.prepareIndex("index-3").setId("8").setSource("d", formatter.format(now.minusDays(7))),
            .setSize(0)
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
        );
        assertCacheState(client, index, 0, 2);
                };
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
        Client client = client();
        indexRandom(
        logger.info("Moving the shard:{} from node:{} to node:{}", indexName + "#0", node_1, node_2);
                .addAggregation(
        assertAcked(
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, index);
            client.prepareIndex(index).setId("1").setSource("s", "2016-03-19"),
                .get()
            Arrays.asList(requestCacheStats.getHitCount(), requestCacheStats.getMissCount(), requestCacheStats.getEvictions())
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-19").lte("2016-03-28"))
        // Show this behavior works for a nested query where the termQuery built by KeywordFieldMapper is not the outermost query
            .setQuery(QueryBuilders.rangeQuery("d").gte("2013-01-01T00:00:00").lte("now"))
        );
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    }
            client.prepareIndex(index).setId("9").setRouting("3").setSource("s", "2016-03-27")
                // Disable index refreshing to avoid cache being invalidated mid-test
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, index);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        assertCacheState(client, "index-2", 0, 0);
                .setSettings(settings)
        OpenSearchAssertions.assertAllSuccessful(r3);
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
        assertCacheState(client, index, 0, 4);
    }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        return result;
        OpenSearchAssertions.assertAllSuccessful(r8);
        // If size > 0 we should no cache by default
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        assertCacheState(client, index, 1, 1);
        assertCacheState(client, index, 1, 1);
                .prepareCreate(index)
        indexRandomForConcurrentSearch(index);
                    expectedHits++;
        testKeywordFieldParameterCacheabilityCase("split_queries_on_whitespace");
            indexName,
                .prepareCreate(index)
            .setRequestCache(true)
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
            .indices()
        resp = client.prepareSearch(indexName).setRequestCache(true).setQuery(QueryBuilders.termQuery("y", "hello")).get();
    public void testKeywordFieldSplitWhitespaceCacheability() throws Exception {
        assertThat(r2.getHits().getTotalHits().value(), equalTo(7L));
        );
        assertThat(r6.getHits().getTotalHits().value(), equalTo(7L));
            }
        );
        }
        // The same query but involving field2 at all should not be cacheable even if setRequestCache is true:
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            // Disable index refreshing to avoid cache being invalidated mid-test
        return true;
        Client client = client(node);
                .get();
                .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
        // If search type is DFS_QUERY_THEN_FETCH we should not cache
        final SearchResponse r3 = client.prepareSearch(index)
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge(index).setFlush(true).get();
        assertTrue(resp.isTimedOut());
        indexRandom(
        logger.info("Clearing the cache for index:{}. And verify the request stats doesn't go negative", indexName);
import static org.hamcrest.Matchers.equalTo;
            index,
        assertThat(r1.getHits().getTotalHits().value(), equalTo(1L));
        assertAcked(client.admin().indices().prepareCreate(index).setMapping("s", "type=date").setSettings(settings).get());
            .setQuery(
        assertSearchResponse(resp);
            .get();
            .setSize(0)
            .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
            final SearchResponse r2 = client.prepareSearch(index)
        final SearchResponse r3 = client.prepareSearch(index)
        ensureSearchable(index);
                .get()
import org.opensearch.common.settings.Settings;
        assertCacheState(client, index, 0, 6);
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-19").lte("2016-03-25"))
        // The cached is actually used
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
            client.prepareIndex(index).setId("3").setSource("d", "2014-03-01T00:00:00"),
        SearchResponse r1 = client.prepareSearch(index)
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        OpenSearchAssertions.assertAllSuccessful(r1);
            .setSearchType(SearchType.QUERY_THEN_FETCH)
import java.util.List;
}
        logger.info("Starting a node in the cluster");
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        final SearchResponse r1 = client.prepareSearch(index)
                        .put(SETTING_NUMBER_OF_SHARDS, 1)
            assertSearchResponse(resp);
    public void testQueryRewrite() throws Exception {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                        // Disable index refreshing to avoid cache being invalidated mid-test
    public IndicesRequestCacheIT(Settings settings) {
    @Override
 *
        // queries on those fields shouldn't be cacheable. Default value is false for both parameters.
                )
        assertCacheState(client, index, 3, 7);
/*
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-21").lte("2016-03-27"))
        // which used to not work well with the query cache because of the handles stream output
        OpenSearchAssertions.assertAllSuccessful(r1);
    private Path[] shardDirectory(String server, Index index, int shard) {
            .get();
            1,
            .build();
        return Arrays.asList(
            client.prepareIndex(index).setId("2").setRouting("1").setSource("s", "2016-03-20"),
        // Now change the parameter value to true for field1, and check the same query again does NOT come from the cache (hits == 0)
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
        final SearchResponse r5 = client.prepareSearch(index)
        OpenSearchAssertions.assertAllSuccessful(r6);
            .setSearchType(SearchType.QUERY_THEN_FETCH)
