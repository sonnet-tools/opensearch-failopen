        assertEquals(1, stats.getMissCount());
        final SearchResponse r1 = client.prepareSearch(index)  
            .setQuery(QueryBuilders.rangeQuery("d").gte("now-7d/d").lte("now"))
            .put("index.number_of_routing_shards", 2)
        assertCacheState(client, index, 0, 0);  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
            0,
            .setSize(0)
        assertCacheState(client, "index-2", 0, 1);  
    private void forceMerge(Client client, String index) {  
    public void testDeleteAndCreateSameIndexShardOnSameNode() throws Exception {
            index,
            client.prepareIndex(index).setId("5").setSource("d", "2014-05-01T00:00:00"),  
    }
        forceMerge(client, index);  
import java.time.ZoneOffset;
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        // The cache should be empty as the timed-out query was invalidated
                    dateHistogram("histo").field("f")
        final Path[] paths = env.availableShardPaths(new ShardId(index, shard));  
        assertThat(r1.getHits().getTotalHits().value(), equalTo(8L));
        assertCacheState(client, "index-1", 0, 0);  
                .setSettings(settings)
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
                } else {
        assertCacheState(client, index, 0, 1);  
        assertThat(
        OpenSearchAssertions.assertAllSuccessful(r6);  
        indexRandom(  
            client.admin()
            client.admin()  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        Client client = client();  
        ensureSearchable(index);  
        assertCacheState(client, index, 3, 7);
        String node_2 = internalCluster().startDataOnlyNode(Settings.builder().build());
            client,
            .setQuery(QueryBuilders.rangeQuery("created_at").gte("now-7d/d"))  
import org.apache.lucene.index.Term;  
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-19").lte("2016-03-25"))
        Client client = client();  
            assertCacheState(client, index, expectedHits, expectedMisses);
        assertQueryCausesCacheState(client, index, QueryBuilders.termsQuery(field1, "foo", "foo2"), 0, 1, cacheSize);
        assertAcked(  
        String field2 = "field2";
        ensureSearchable(index);  
            .cluster()
                .get()
        assertThat(r2.getHits().getTotalHits().value(), equalTo(8L));
        ensureSearchable(index);
                        return result;
        final SearchResponse r1 = client.prepareSearch(index)
        Client client = client();
import org.opensearch.cluster.metadata.IndexMetadata;
 * specific language governing permissions and limitations
        forceMerge(client, index);
            client.prepareIndex("index-1").setId("2").setSource("d", formatter.format(now.minusDays(1))),  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            if (profile == false) {
}  
        return client.admin().indices().prepareStats(index).setRequestCache(true).get().getTotal().getRequestCache();  
        // Because the query will INTERSECT with the 3rd index it will not be
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
            client.prepareIndex(index).setId("8").setSource("d", "2014-08-01T00:00:00"),  
            client.prepareIndex(index).setId("9").setSource("d", "2014-09-01T00:00:00")
        NodesStatsResponse stats = client.admin().cluster().prepareNodesStats().execute().actionGet();
        assertThat(r1.getHits().getTotalHits().value(), equalTo(7L));
        assertAcked(
        return paths;  
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-20").lte("2016-03-26"))
                )
        assertThat(r3.getHits().getTotalHits().value(), equalTo(8L));
            assertSearchResponse(resp);
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        );
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
                        } catch (InterruptedException ignored) {}  
        assertSearchResponse(r1);
        ensureSearchable(index);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .build();
                    Settings.builder()
                .setMapping("created_at", "type=date")
                    }
 * software distributed under the License is distributed on an
        assertSearchResponse(resp);  
        assertThat(r1.getHits().getTotalHits().value(), equalTo(8L));
        internalCluster().client().admin().cluster().prepareReroute().add(cmd).get();  
                .get()
            .setSize(0)
        ClusterHealthResponse clusterHealth = client().admin()  
        OpenSearchAssertions.assertAllSuccessful(r2);  
        // rewritten and will still contain `now` so won't be recorded as a
            .setRequestCache(true)  
            .get();
        final SearchResponse r1 = client.prepareSearch("index-*")
        final SearchResponse r3 = client.prepareSearch(index)
            .get();
public class IndicesRequestCacheIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            cacheSize
            Settings.builder().put(INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING.getKey(), maxCacheableSize)
            client.prepareIndex(index).setId("6").setSource("s", "2016-03-24"),
        String index = "index";
            client.prepareIndex("index-3").setId("7").setSource("d", formatter.format(now.minusDays(6))),
        // If size > 0 we should no cache by default  
            .setSize(0)
        client.prepareIndex(index).setId("1").setRouting("1").setSource("created_at", DateTimeFormatter.ISO_LOCAL_DATE.format(now)).get();
        logger.info("Moving the shard: {} again from node:{} to node:{}", indexName + "#0", node_2, node_1);
        testKeywordFieldParameterCacheabilityCase("use_similarity");
            client.prepareIndex(index).setId("1").setSource("s", "2016-03-19"),
        assertTrue(stats.getMemorySizeInBytes() == 0);  
                        try {
            .get();
                .indices()
        OpenSearchAssertions.assertAllSuccessful(r1);
        assertQueryCausesCacheState(  
            .setRequestCache(true)
            client.prepareIndex(index).setId("3").setSource("s", "2016-03-21"),
        );
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        String index = "index";  
        Client client = client(node_1);  
        );
            .addAggregation(filter("foo", QueryBuilders.rangeQuery("s").from("2016-01-01").to("now")))
        String index = "index";
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
            .addAggregation(new GlobalAggregationBuilder("global"))
    public void testQueryRewriteDatesWithNow() throws Exception {
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                    .minDocCount(0)  
import org.opensearch.cluster.ClusterState;
        OpenSearchAssertions.assertAllSuccessful(r5);
        indexRandom(  
        assertQueryCausesCacheState(client, index, QueryBuilders.fuzzyQuery(field1, "foe"), 0, 1, cacheSize);
                        .put(SETTING_NUMBER_OF_SHARDS, 1)
    }  
    }
        );
                .get()
import org.apache.lucene.search.IndexSearcher;
        logger.info("Disabling allocation");  
        logger.info("Creating an index: {} with 2 shards", indexName);
            .addAggregation(new GlobalAggregationBuilder("global"))
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-20").lte("2016-03-26"))  
                .addAlias(new Alias("last_week").filter(QueryBuilders.rangeQuery("created_at").gte("now-7d/d")))  
        );
            // Disable index refreshing to avoid cache being invalidated mid-test
        assertThat(r8.getHits().getTotalHits().value(), equalTo(5L));
 *  
        assertCacheState(client, index, 0, 0);  
import org.opensearch.action.search.SearchType;  
package org.opensearch.indices;
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        for (int i = 0; i < 5; i++) {  
        String node = internalCluster().startNode(
        assertCacheState(client, index, 0, 6);  
        final SearchResponse r4 = client.prepareSearch(index)
        String node_1 = internalCluster().startNode(Settings.builder().build());
                dateHistogram("histo").field("f")
    }
import java.util.concurrent.TimeUnit;
            .setSize(0)  
import java.time.ZonedDateTime;
        logger.info("Moving the shard:{} from node:{} to node:{}", indexName + "#0", node_1, node_2);  
            .get();
import java.time.ZoneId;  
                    Settings.builder()  
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))  
        assertThat(cluster().size(), equalTo(2));
        assertCacheState(client, index, 0, 4);
        forceMerge(client, index);
    public void testQueryRewriteMissingValues() throws Exception {  
                assertEquals(b1.getDocCount(), b2.getDocCount());  
        OpenSearchAssertions.assertAllSuccessful(r1);  
 * license agreements. See the NOTICE file distributed with
                        .put("index.number_of_routing_shards", 5)
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-20").lte("2016-03-26"))
        assertAcked(  
            Histogram h2 = r2.getAggregations().get("histo");
        forceMerge(client, index);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        QueryBuilder builder,  
                        // Disable index refreshing to avoid cache being invalidated mid-test
        Settings settings = Settings.builder()
            .get();
    }  
            final SearchResponse r2 = client.prepareSearch(index)
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))  
            )
            for (int j = 0; j < buckets1.size(); ++j) {
            true,
        indexRandom(true, client.prepareIndex(indexName).setSource("k", "hello"));  
        final SearchResponse r2 = client.prepareSearch(index)
    private Path[] shardDirectory(String server, Index index, int shard) {
            .get();  
    public static Collection<Object[]> parameters() {
 * not use this file except in compliance with the License.
                .setRequestCache(true)  
        ensureSearchable(index);  
        final SearchResponse r8 = client.prepareSearch(index)
        assertQueryCausesCacheState(
import org.opensearch.index.IndexSettings;  
        assertAcked(client.admin().indices().prepareCreate("index-3").setMapping("d", "type=date").setSettings(settings).get());  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
            client.prepareIndex(index).setId("6").setRouting("2").setSource("s", "2016-03-24"),
            .addAggregation(new GlobalAggregationBuilder("global"))
        assertCacheState(client, index, 6, 9);  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        Settings newSettings = Settings.builder()
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
        clusterHealth = client().admin()
                .setSettings(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .get();
    // One of the primary purposes of the query cache is to cache aggs results
    public void testKeywordFieldSplitWhitespaceCacheability() throws Exception {
        assertCacheState(client, index, 0, 0);
            1,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
    }  
                .setSettings(
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        OpenSearchAssertions.assertAllSuccessful(r1);
        assertEquals(expectedMemory, stats.getMemorySizeInBytes());
    private void testKeywordFieldParameterCacheabilityCase(String paramName) throws Exception {
                    expectedHits++;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        .minDocCount(0)
        );
            .setSize(0)
                )  
            .setSize(maxCacheableSize)  
            .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        indexRandom(true, client.prepareIndex(index).setSource(field1, "foo2", field2, "foo2"));
        QueryBuilder timeoutQueryBuilder = new TermQueryBuilder("k", "hello") {  
        assertCacheState(client, index, 0, 1);
        assertCacheState(client, "index-1", 0, 1);
        final SearchResponse r1 = client.prepareSearch(index)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                .prepareCreate(index)
        // Sizes > the cluster setting value should not be cached
            .get();  
            client.admin()
            .setSize(1)
        String index = "index";
            client.prepareIndex(index).setId("5").setRouting("2").setSource("s", "2016-03-23"),  
        assertAcked(client.admin().indices().prepareCreate("index-1").setMapping("d", "type=date").setSettings(settings).get());
        final SearchResponse r2 = client.prepareSearch(index)
        final SearchResponse r1 = client.prepareSearch(index)
        assertAcked(  
            .build();  
                    @Override
        super(settings);
            client.prepareIndex(index).setSource("f", "2014-05-13T00:00:00.000Z")  
        assertQueryCausesCacheState(client, index, QueryBuilders.rangeQuery(field1).gte("f").lte("g"), 0, 1, cacheSize);
import java.time.format.DateTimeFormatter;  
        Settings settings = Settings.builder()  
                .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
        // no extra misses and no extra values in cache
            }
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
                        .timeZone(ZoneId.of("+01:00"))  
        // correct we can see both values  
        );
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        return null;
            .setQuery(QueryBuilders.rangeQuery("d").gte("2013-01-01T00:00:00").lte("now"))
                        // Disable index refreshing to avoid cache being invalidated mid-test
                    @SuppressForbidden(reason = "Waiting 10x the timeout")
        // Now test all query building methods on field1 and ensure none are cacheable  
            .get();  
                if (i == 1) {
                .indices()
                .indices()
            .get();
import java.util.Arrays;
            true,
    @ParametersFactory
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(newSettings).execute().actionGet();
 * Modifications Copyright OpenSearch Contributors. See
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge(index).setFlush(true).get();
            .setSize(maxCacheableSize + 1)
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache  
import java.nio.file.Files;
            .get();  
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache  
        DateFormatter formatter = DateFormatter.forPattern("strict_date_optional_time");
        assertEquals(expectedMisses, stats.getMissCount());  
import org.opensearch.common.settings.Settings;  
        // Sizes <= the cluster setting value should be cached  
        OpenSearchAssertions.assertAllSuccessful(r1);
        forceMerge(client, index);
        client.admin().indices().clearCache(clearIndicesCacheRequest).actionGet();
            client.prepareIndex("index-1").setId("3").setSource("d", formatter.format(now.minusDays(2))),
            .setQuery(QueryBuilders.rangeQuery("d").gte("now-7d/d").lte("now"))
        SearchResponse resp = client.prepareSearch(index)
                .setMapping("s", "type=date")
import org.opensearch.common.SuppressForbidden;
        final SearchResponse r2 = client.prepareSearch(index)  
            cacheSize  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        final SearchResponse r3 = client.prepareSearch(index)
            client.admin()
        OpenSearchAssertions.assertAllSuccessful(r1);
        assertCacheState(client, index, 0, 6);
            .setQuery(timeoutQueryBuilder)  
            client.prepareIndex(index).setId("7").setRouting("3").setSource("s", "2016-03-25"),
            client.prepareIndex(index).setId("2").setRouting("1").setSource("s", "2016-03-20"),  
            0,  
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-20").lte("2016-03-26"))  
        OpenSearchAssertions.assertAllSuccessful(r3);
        stats = getNodeCacheStats(client(node_1));  
        for (NodeStats stat : stats.getNodes()) {
        String indexName = "test";
            assertEquals(1, Arrays.stream(shardDirectory(node_2, index, 0)).filter(Files::exists).count());
 */  
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))  
        // This query should be cached  
            Arrays.asList(expectedHits, expectedMisses, 0L),
        );  
 * the Apache License, Version 2.0 (the "License"); you may
        assertCacheState(client, index, 0, 0);  
        // Show this behavior works for a nested query where the termQuery built by KeywordFieldMapper is not the outermost query
            // to ensure that query is executed even if it rewrites to match_no_docs
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache  
        OpenSearchAssertions.assertAllSuccessful(r3);
            .get();
/*  
                .prepareCreate(index)  
        );  
import static org.opensearch.indices.IndicesRequestCache.INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING;  
        // If search type is DFS_QUERY_THEN_FETCH we should not cache
        assertThat(r5.getHits().getTotalHits().value(), equalTo(7L));
    }
        assertThat(r3.getHits().getTotalHits().value(), equalTo(7L));
            .setSize(0)
        assertSearchResponse(resp);  
            client.prepareIndex(index).setId("7").setSource("d", "2014-07-01T00:00:00"),
                        Weight result = super.createWeight(searcher, scoreMode, boost);  
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
            boolean profile = i % 2 == 0;
        assertCacheState(client, "index-3", 0, 0);
        assertThat(r1.getHits().getTotalHits().value(), equalTo(7L));  
                .prepareCreate(index)
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
    }
        // the available paths of the shard may be bigger than the 1,
        assertThat(r1.getHits().getTotalHits().value(), equalTo(1L));
        assertCacheState(client, index, 2, 1);
            .setSize(0)
    public IndicesRequestCacheIT(Settings settings) {  
            .get();  
        final SearchResponse r7 = client.prepareSearch(index)
        String field1 = "field1";
        // it depends on `InternalTestCluster.numDataPaths`.
import org.opensearch.common.unit.TimeValue;
                .setMapping("s", "type=date")  
        assertCacheState(client, index, 0, 0);
        }  
        forceMerge(client, indexName);
            }
        assertCacheState(client, index, 0, 2);
            client.prepareIndex(index).setId("3").setRouting("1").setSource("s", "2016-03-21"),
    }
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
    public void testProfileDisableCache() throws Exception {
            client.prepareIndex(index).setId("1").setSource("d", "2014-01-01T00:00:00"),
        OpenSearchAssertions.assertAllSuccessful(r1);  
                .indices()
import org.opensearch.index.query.QueryBuilders;  
        r1 = client.prepareSearch("last_week").setSearchType(SearchType.QUERY_THEN_FETCH).setSize(0).get();  
            client.prepareIndex("index-1").setId("1").setSource("d", formatter.format(now)),
        String index = "index";
        client.admin().indices().putMapping(mappingRequest).actionGet();
        forceMerge(client, index);
        assertCacheState(client, index, 0, 0);
        // The same query but involving field2 at all should not be cacheable even if setRequestCache is true:  
 *    http://www.apache.org/licenses/LICENSE-2.0
        indexRandom(  
        healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("2").execute().actionGet();  
        SearchResponse resp = client.prepareSearch(index).setRequestCache(true).setQuery(builder).get();
            final List<? extends Bucket> buckets2 = h2.getBuckets();  
        );  
 *
                    .timeZone(ZoneId.of("+01:00"))
        }
        // cache miss or cache hit since queries containing now can't be cached  
            .get();
        assertCacheState(client, "index-3", 0, 0);
            .build();  
            .get();  
            .get();  
            client.prepareIndex(index).setSource("f", "2014-03-10T00:00:00.000Z"),
    }  
        int maxCacheableSize = 5;  
import org.apache.lucene.search.Query;
            assertSearchResponse(r2);
        );  
            client.prepareIndex(index).setId("4").setSource("s", "2016-03-22"),
        assertThat(r1.getHits().getTotalHits().value(), equalTo(1L));  
                .setProfile(profile)
            client.prepareIndex(index).setId("3").setRouting("1").setSource("s", "2016-03-21"),
            client.prepareIndex("index-2").setId("4").setSource("d", formatter.format(now.minusDays(3))),
        SearchResponse resp = client.prepareSearch(index)
        long expectedHits,
        final SearchResponse r2 = client.prepareSearch("index-*")  
        assertCacheState(client, "index-1", 2, 1);  
 * under the License.  
    public void testCanCache() throws Exception {
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
        assertThat(r2.getHits().getTotalHits().value(), equalTo(8L));  
            .setWaitForNoRelocatingShards(true)
            .get();
        ensureSearchable(index);  
        assertCacheState(client, index, 0, 0);
                .get()
        );
            .get();
    }
            client.prepareIndex(index).setId("8").setRouting("3").setSource("s", "2016-03-26"),  
        // Now change the parameter value to true for field1, and check the same query again does NOT come from the cache (hits == 0)
            client.prepareIndex(index).setId("7").setRouting("3").setSource("s", "2016-03-25"),  
        OpenSearchAssertions.assertAllSuccessful(r3);
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;  
        assertCacheState(client, index, 0, 0);
                    Settings.builder()
        assertCacheState(client, index, 2, 2);
                        // Disable index refreshing to avoid cache being invalidated mid-test
    private static void assertCacheState(Client client, String index, long expectedHits, long expectedMisses) {  
    }
        );
                        // sometimes throw an exception on timeout, rather than timing out gracefully.
            .setSearchType(SearchType.QUERY_THEN_FETCH)
                        // Create the weight before sleeping. Otherwise, TermStates.build() (in the call to super.createWeight()) will
        assertCacheState(client, "index-1", 1, 1);
        // When keyword fields have non-default values for "use_similarity" or "split_queries_on_whitespace",  
        assertCacheState(client, index, 1, 1);
            Histogram h1 = r1.getAggregations().get("histo");  
            QueryBuilders.boolQuery().should(QueryBuilders.termQuery(field1, "foo")).should(QueryBuilders.termQuery(field1, "foo2")),  
        assertThat(r1.getHits().getTotalHits().value(), equalTo(9L));
        assertThat(healthResponse.isTimedOut(), equalTo(false));  
 * SPDX-License-Identifier: Apache-2.0
        OpenSearchAssertions.assertAllSuccessful(r3);
            Settings.builder().put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY, TimeValue.timeValueMillis(50))  
            .setRequestCache(true)  
import org.opensearch.index.query.QueryBuilder;
        });
        );
            Settings.builder()
            .setRequestCache(true)  
    public void testCacheAggs() throws Exception {  
        indexRandom(true, client.prepareIndex(indexName).setSource("y", "hello again"));
                .setMapping(field1, "type=keyword," + paramName + "=false", field2, "type=keyword," + paramName + "=true")
            QueryBuilders.boolQuery().should(QueryBuilders.termQuery(field1, "foo")).should(QueryBuilders.termQuery(field2, "foo2")),
    }  
            true,
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
import static org.opensearch.search.aggregations.AggregationBuilders.dateRange;  
                        // Disable index refreshing to avoid cache being invalidated mid-test
 * ownership. Elasticsearch licenses this file to you under  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            client.prepareIndex(index).setId("5").setSource("s", "2016-03-23"),  
            client.prepareIndex(index).setId("2").setSource("d", "2014-02-01T00:00:00"),  
        assertCacheState(client, index, 1, 1);  
            client.prepareIndex(index).setId("2").setRouting("1").setSource("s", "2016-03-20"),
 */  
        Settings settings = Settings.builder()
            .setSearchType(SearchType.QUERY_THEN_FETCH)
import org.opensearch.common.time.DateFormatter;
        assertTrue(resp.isTimedOut());  
        assertCacheState(client, index, 1, 1);  
        RequestCacheStats stats = getNodeCacheStats(client);  
                .get()
        final SearchResponse r6 = client.prepareSearch(index)  
            // to ensure that query is executed even if it rewrites to match_no_docs  
        indexRandom(true, client.prepareIndex(index).setSource("k", "hello"));
            client.admin()  
        OpenSearchAssertions.assertAllSuccessful(r8);
import static org.hamcrest.Matchers.equalTo;
import java.util.Collection;
            if (stat.getNode().isDataNode()) {  
 * GitHub history for details.
        assertCacheState(client, "index-3", 0, 0);
        assertQueryCausesCacheState(client, index, QueryBuilders.wildcardQuery(field1, "f*"), 0, 1, cacheSize);  
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
    @Override  
                assertEquals(b1.getKey(), b2.getKey());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-19").lte("2016-03-28"))
            .setWaitForNoRelocatingShards(true)  
        );
 * compatible open source license.
            .addAggregation(  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
        );  
            .setSize(0)
        ensureSearchable("index-1", "index-2", "index-3");
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        ForceMergeResponse forceMergeResponse = client.admin()  
            .put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), EnableAllocationDecider.Allocation.NONE.name())
                };  
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest(indexName);  
                .setSettings(
            .get();
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
            .setSize(0)
/*  
                .prepareCreate(index)  
        indexRandom(true, client.prepareIndex(index).setSource("k", "hello"));
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);  
        assertQueryCausesCacheState(client, index, QueryBuilders.prefixQuery(field1, "fo"), 0, 1, cacheSize);
        assertThat(r2.getHits().getTotalHits().value(), equalTo(9L));
        assertThat(r3.getHits().getTotalHits().value(), equalTo(7L));
        assertThat(r1.getHits().getTotalHits().value(), equalTo(1L));  
        assertCacheState(client, "index-2", 2, 1);
                    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                        .dateHistogramInterval(DateHistogramInterval.MONTH)
        OpenSearchAssertions.assertAllSuccessful(r4);  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // which used to not work well with the query cache because of the handles stream output
                return new TermQuery(new Term("k", "hello")) {  
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-20").lte("2016-03-26"))
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        Client client = client();
        final SearchResponse r3 = client.prepareSearch(index)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .get()  
            client.prepareIndex(index).setId("8").setRouting("3").setSource("s", "2016-03-26"),
        indexRandom(  
        return Arrays.asList(  
    public void testQueryRewrite() throws Exception {
            index,
        // If search type is DFS_QUERY_THEN_FETCH we should not cache even if
 * KIND, either express or implied.  See the License for the
        assertAcked(
            protected Query doToQuery(QueryShardContext context) {
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-21").lte("2016-03-27"))
        return true;
        assertEquals(expectedHits, stats.getHitCount());
            .get();
        createIndex(
        forceMerge(client, index);
            .setSize(0)  
import org.apache.lucene.search.TermQuery;
        r1 = client.prepareSearch("last_week").setSearchType(SearchType.QUERY_THEN_FETCH).setSize(0).get();
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)  
            assertFalse(Arrays.stream(shardDirectory(node_2, index, 0)).anyMatch(Files::exists));
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-19").lte("2016-03-28"))
        assertAcked(  
        OpenSearchAssertions.assertAllSuccessful(r2);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            client.prepareIndex(index).setId("9").setRouting("3").setSource("s", "2016-03-27")
            .get();
            .setQuery(QueryBuilders.rangeQuery("created_at").gte("now-7d/d"))  
        // queries on those fields shouldn't be cacheable. Default value is false for both parameters.
                    Settings.builder()  
        final SearchResponse r5 = client.prepareSearch(index)  
        logger.info("Writing few docs and searching those which will cache items in RequestCache");
            .setSize(0)
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
        final Index index = state.metadata().index(indexName).getIndex();  
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
        String index = "index";
        assertThat(cluster().size(), equalTo(1));
            .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
import org.apache.lucene.search.ScoreMode;  
            .prepareHealth()  
        assertThat(r7.getHits().getTotalHits().value(), equalTo(5L));
            client.prepareIndex(index).setId("6").setSource("d", "2014-06-01T00:00:00"),
        indexRandom(  
        int expectedHits = 0;
 * Unless required by applicable law or agreed to in writing,
            .build();
        OpenSearchAssertions.assertAllSuccessful(r7);  
        SearchResponse r1 = client.prepareSearch(index)  
        resp = client.prepareSearch(indexName).setRequestCache(true).setQuery(QueryBuilders.termQuery("y", "hello")).get();
        // If size > 1 and cache flag is set on the request we should cache
        OpenSearchAssertions.assertAllSuccessful(r2);
        RequestCacheStats stats = getNodeCacheStats(client);
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)  
import org.opensearch.transport.client.Client;
    }
import static org.hamcrest.Matchers.greaterThan;
 * You may obtain a copy of the License at  
        assertAcked(client.admin().indices().prepareCreate("index-2").setMapping("d", "type=date").setSettings(settings).get());
            .setSearchType(SearchType.QUERY_THEN_FETCH)
            Arrays.asList(requestCacheStats.getHitCount(), requestCacheStats.getMissCount(), requestCacheStats.getEvictions())  
        );
    private static RequestCacheStats getNodeCacheStats(Client client) {  
            .setRequestCache(true)
        Client client = client();
            .get();  
                .build()  
                // Disable index refreshing to avoid cache being invalidated mid-test
        assertCacheState(client, "index-3", 0, 0);  
            client.admin().indices().prepareStats(index).setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
            }
                .setMapping("d", "type=date")
                .get();
        // see #9500
        MoveAllocationCommand cmd = new MoveAllocationCommand(indexName, 0, node_1, node_2);
        OpenSearchAssertions.assertAllSuccessful(r1);  
            }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge(index).setFlush(true).get();
        assertEquals(0, requestCacheStats.getMemorySizeInBytes());  
        assertQueryCausesCacheState(client, index, QueryBuilders.regexpQuery(field1, "f*o"), 0, 1, cacheSize);  
        String index = "index";
import org.opensearch.test.OpenSearchIntegTestCase;
        );
    }  
            .addAggregation(dateRange("foo").field("s").addRange("2016-01-01", "now"))
        assertThat(r3.getHits().getTotalHits().value(), equalTo(8L));
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache  
            indexName,  
import java.util.List;  
        assertCacheState(client, index, 2, 1);  
                .get()
        // Update max cacheable size for request cache from default value of 0
                .addAggregation(
        ensureSearchable(index);  
        Client client = client();
                .prepareCreate(index)  
        final SearchResponse r1 = client.prepareSearch(index)
    }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        forceMerge(client, index);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        assertThat(r2.getHits().getTotalHits().value(), equalTo(7L));
    public void testCacheWithFilteredAlias() throws InterruptedException {  
        cmd = new MoveAllocationCommand(indexName, 0, node_2, node_1);
        logger.info("Starting a node in the cluster");
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
        final SearchResponse r2 = client.prepareSearch(index)
        testKeywordFieldParameterCacheabilityCase("split_queries_on_whitespace");
        String index,
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
            client.prepareIndex(index).setId("2").setSource("s", "2016-03-20"),  
        final SearchResponse r3 = client.prepareSearch(index)
            true,
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
                .prepareCreate(index)
        assertThat(clusterHealth.isTimedOut(), equalTo(false));  
 * this work for additional information regarding copyright
            .setTimeout(new TimeValue(5, TimeUnit.MILLISECONDS))
                .setSearchType(SearchType.QUERY_THEN_FETCH)  
            client.admin()
    }
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
            .setSize(0)
        assertCacheState(client, index, 0, 0);
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING;
 * Licensed to Elasticsearch under one or more contributor  
    }
        RequestCacheStats stats = getNodeCacheStats(client);
            .setWaitForNoInitializingShards(true)
            .setSize(1)  
        assertAcked(
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)  
        assertCacheState(client, "index-1", 0, 0);
    public void testQueryRewriteDates() throws Exception {  
        assertAcked(  
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-21").lte("2016-03-27"))
import org.opensearch.core.index.Index;  
        assertCacheState(client, index, 0, 0);  
            .get();  
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-19").lte("2016-03-25"))
            assertEquals(1, Arrays.stream(shardDirectory(node_1, index, 0)).filter(Files::exists).count());
                .indices()
            .setSize(0)
import org.apache.lucene.search.Weight;
            .setQuery(QueryBuilders.rangeQuery("d").gte("2013-01-01T00:00:00").lte("now"))
        assertCacheState(client, "index-2", 1, 1);
            .prepareHealth()
        Client client = client();  
        assertBusy(() -> {
    }
        assertEquals(
            client.prepareIndex(index).setId("1").setRouting("1").setSource("s", "2016-03-19"),  
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
        Client client = client(node);
        indexRandomForConcurrentSearch(index);
        // If the request has a filter aggregation containing now we should cache since it gets rewritten
        assertThat(r2.getHits().getTotalHits().value(), equalTo(7L));
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)  
        OpenSearchAssertions.assertAllSuccessful(r1);  
        // This is not a random example: serialization with time zones writes shared strings  
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
                .setSettings(
                .setMapping("f", "type=date")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            client.prepareIndex(index).setId("4").setSource("d", "2014-04-01T00:00:00"),
        PutMappingRequest mappingRequest = new PutMappingRequest().indices(index).source(field1, "type=keyword," + paramName + "=true");
        ClusterState state = client().admin().cluster().prepareState().get().getState();
 * The OpenSearch Contributors require contributions made to  
            .setSize(0)
        assertCacheState(client, "index-3", 0, 0);  
            client.prepareIndex(index).setId("3").setSource("d", "2014-03-01T00:00:00"),
            .setQuery(
            .addAggregation(new GlobalAggregationBuilder("global"))
    }
        ensureSearchable("index-1", "index-2", "index-3");  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;  
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
            client.prepareIndex("index-3").setId("8").setSource("d", formatter.format(now.minusDays(7))),  
        OpenSearchAssertions.assertAllSuccessful(r2);
            .setSize(0)
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            client.prepareIndex("index-2").setId("6").setSource("d", formatter.format(now.minusDays(5))),
                )  
        logger.info("Clearing the cache for index:{}. And verify the request stats doesn't go negative", indexName);
                .prepareCreate(index)  
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
            .setSearchType(SearchType.QUERY_THEN_FETCH)
    private static RequestCacheStats getRequestCacheStats(Client client, String index) {
            .get();  
        };
            .setSize(0)  
            client.prepareIndex(index).setId("4").setRouting("2").setSource("s", "2016-03-22"),  
        long expectedMisses,
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        );
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import org.opensearch.index.query.TermQueryBuilder;
        long cacheSize = stats.getMemorySizeInBytes();  
                )  
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-19").lte("2016-03-28"))
            client.prepareIndex("index-2").setId("5").setSource("d", formatter.format(now.minusDays(4))),  
                .setMapping("k", "type=keyword")  
            .addAggregation(new GlobalAggregationBuilder("global"))  
            @Override
            .setQuery(QueryBuilders.rangeQuery("d").gte("2013-01-01T00:00:00").lte("now"))
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        indexRandom(
        final SearchResponse r3 = client.prepareSearch("index-*")
                final Bucket b1 = buckets1.get(j);  
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
                .indices()
        ensureSearchable(index);
        Client client = client();
                .prepareCreate(index)  
        assertThat(r6.getHits().getTotalHits().value(), equalTo(7L));
        internalCluster().client().admin().cluster().prepareReroute().add(cmd).get();
            client.prepareIndex(index).setId("5").setRouting("2").setSource("s", "2016-03-23"),
import org.opensearch.index.cache.request.RequestCacheStats;
            client.admin()
            true,
                        // Disable index refreshing to avoid cache being invalidated mid-test  
            client.prepareIndex(index).setId("6").setRouting("2").setSource("s", "2016-03-24"),
        int expectedMisses = 0;
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
                .indices()  
            .setSize(0)  
            .get();
        assertBusy(() -> {  
            .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)  
            client.prepareIndex(index).setId("8").setSource("s", "2016-03-26"),  
            .setSize(0)
            .setWaitForNoInitializingShards(true)
        String index = "index";
            assertThat(resp.getHits().getTotalHits().value(), equalTo(1L));  
            assertFalse(Arrays.stream(shardDirectory(node_1, index, 0)).anyMatch(Files::exists));  
        assertAcked(client.admin().indices().prepareCreate(index).setMapping("s", "type=date").setSettings(settings).get());  
                        // Disable index refreshing to avoid cache being invalidated mid-test
                return stat.getIndices().getRequestCache();
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
        assertCacheState(client, "index-2", 0, 0);
        );
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, index);
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-22").lte("2016-03-26"))
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;  
 */
        refreshAndWaitForReplication();
            final List<? extends Bucket> buckets1 = h1.getBuckets();
                )  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                .setQuery(QueryBuilders.termQuery("k", "hello"))
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
                )
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, index);
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/14288")  
        OpenSearchAssertions.assertAllSuccessful(r2);
            SearchResponse resp = client.prepareSearch(index)
        updateSettingsRequest.persistentSettings(
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        assertCacheState(client, index, 0, 1);
            .cluster()
        );
            .setQuery(QueryBuilders.rangeQuery("d").gte("now-7d/d").lte("now"))  
 *
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
    public void testKeywordFieldUseSimilarityCacheability() throws Exception {  
        assertThat(r4.getHits().getTotalHits().value(), equalTo(7L));
        assertCacheState(client, index, 0, 0);
            assertEquals(buckets1.size(), buckets2.size());
                .setMapping("k", "type=keyword")
        OpenSearchAssertions.assertAllSuccessful(r1);
        refreshAndWaitForReplication();  
                .setSettings(  
        SearchResponse resp = client.prepareSearch(indexName).setRequestCache(true).setQuery(QueryBuilders.termQuery("k", "hello")).get();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
            .indices()
            OpenSearchAssertions.assertAllSuccessful(resp);
import org.opensearch.action.admin.indices.alias.Alias;
            .get();  
                )  
 * this file be licensed under the Apache-2.0 license or a
                .setSettings(
        assertCacheState(client, index, 1, 2);  
        r1 = client.prepareSearch(index)  
        stats = getNodeCacheStats(client(node_2));
        // A timed out query should be cached and then invalidated
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .setFlush(true)  
        // the cache flag is explicitly set on the request  
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
            client.admin()
                    Settings.builder()
        assertCacheState(client, index, 0, 0);
        assertTrue(cacheSize > 0);
                        // Disable index refreshing to avoid cache being invalidated mid-test
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
    }
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        assertCacheState(client, "index-2", 0, 0);
            .setSize(0)  
import org.opensearch.core.index.shard.ShardId;
        // and also shouldn't add any extra entries to the cache  
                .get()
            .prepareForceMerge("index-1", "index-2", "index-3")
                .setSize(0)
                    expectedMisses++;  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        String index = "index";  
            .setRequestCache(true)
    protected boolean useRandomReplicationStrategy() {
                    Settings.builder()  
                .setSettings(
        assertThat(healthResponse.isTimedOut(), equalTo(false));
    }
    private void assertQueryCausesCacheState(  
import org.opensearch.index.query.QueryShardContext;
        // The cached is actually used  
                QueryBuilders.boolQuery().should(QueryBuilders.termQuery(field1, "foo")).should(QueryBuilders.termQuery(field1, "foo2"))
    public void testTimedOutQuery() throws Exception {  
        long expectedMemory  
        // If the request has an non-filter aggregation containing now we should not cache
        }  
        assertTrue(stats.getMemorySizeInBytes() > 0);
/*
        Client client = client();
            .get();
    ) {
        Client client,
        assertTrue(stats.getMemorySizeInBytes() == 0);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
        for (int i = 0; i < 10; ++i) {  
        // Check the hit count and miss count together so if they are not
                }  
                            Thread.sleep(500);
            client.prepareIndex(index).setId("4").setRouting("2").setSource("s", "2016-03-22"),
        ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth().setWaitForNodes("1").execute().actionGet();
        assertCacheState(client, index, 0, 0);  
            .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        );
            .addAggregation(new GlobalAggregationBuilder("global"))  
            client.prepareIndex(index).setId("7").setSource("other", "value"),
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            .setQuery(QueryBuilders.rangeQuery("s").gte("2016-03-22").lte("2016-03-26"))
        OpenSearchAssertions.assertAllSuccessful(r3);
        assertThat(r1.getHits().getTotalHits().value(), equalTo(1L));
            client.prepareIndex(index).setId("9").setRouting("3").setSource("s", "2016-03-27")
        refreshAndWaitForReplication();  
                )  
        logger.info("Starting a second node");  
        assertCacheState(client, index, 0, 5);
import org.opensearch.env.NodeEnvironment;
            client.prepareIndex(index).setId("1").setRouting("1").setSource("s", "2016-03-19"),
            client.prepareIndex(index).setId("9").setSource("s", "2016-03-27")
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        indexRandom(true, client.prepareIndex(index).setSource(field1, "foo", field2, "foo"));
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache  
            client,  
            client.prepareIndex("index-3").setId("9").setSource("d", formatter.format(now.minusDays(8)))
        assertThat(r3.getHits().getTotalHits().value(), equalTo(9L));  
        });  
import org.opensearch.action.search.SearchResponse;
                final Bucket b2 = buckets2.get(j);
        assertSearchResponse(resp);
        ensureGreen(indexName);  
                .get();  
            1,
import java.nio.file.Path;
                .indices()
            .get();  
import java.io.IOException;  
        NodeEnvironment env = internalCluster().getInstance(NodeEnvironment.class, server);
            true,
        ensureSearchable(indexName);
            greaterThan(0L)  
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
            )  
                    Settings.builder()  
