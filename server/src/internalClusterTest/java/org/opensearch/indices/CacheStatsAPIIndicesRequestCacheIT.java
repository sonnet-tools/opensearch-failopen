        Map<String, Object> cachesResponse = (Map<String, Object>) ((Map<String, Object>) nodesResponse.get(nodeId)).get("caches");
        ImmutableCacheStats expectedStats,
            assertEquals(expectedStats.getItems(), (int) aggregatedStatsResponse.getItems());
import org.opensearch.common.xcontent.XContentFactory;
            0
        boolean checkMemorySize,
        return resp;
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        statsFlags.setLevels(flagsLevels);
        startIndex(client, index);
        Client client = client();
            client,
        }
        long originalMemorySize = statsHolder.getTotalSizeInBytes();
        String index = "index";
            assertEquals(expectedStats.getSizeInBytes(), (int) aggregatedStatsResponse.getSizeInBytes());
        // Get the request size for one request, so we can reuse it for next index
        assertNotNull(cachesResponse);
        for (int i = 0; i < numKeys / 2; i++) {
            .getRequestCache();
        );
        // Search once for a doc in index 2
        // The total stats for the node should be 1 hit, 2 misses, and 2 entries
    private static Map<String, Object> getStatsXContent(ImmutableCacheStatsHolder statsHolder) throws IOException {
 */
            searchIndex(client, index1Name, "");
                    Settings.builder()
        OpenSearchAssertions.assertAllSuccessful(resp);
            .get();
        ImmutableCacheStatsHolder shardsStats = getNodeCacheStatsResult(client, List.of(IndicesRequestCache.SHARD_ID_DIMENSION_NAME));
                .setMapping("k", "type=keyword")
        int numKeys = Randomness.get().nextInt(100) + 1;
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
        // Can always get the first data node as there's only one in this test suite
import org.opensearch.common.cache.CacheType;
        ImmutableCacheStatsHolder statsHolder = getNodeCacheStatsResult(client, List.of());
    }
import java.io.IOException;
        ImmutableCacheStatsHolder statsHolder = getNodeCacheStatsResult(client, List.of());
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        expectedStats = new ImmutableCacheStats(0, 1, 0, requestSize, 1);
    }
            oldApiStats.getHitCount(),
// Use a single data node to simplify logic about cache stats across different shards.
        List<String> totalStatsKeys = List.of();
        }
    public void testNullLevels() throws Exception {
        List<String> index2Dimensions = List.of(index2Name);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
            .setQuery(QueryBuilders.termQuery("k", "hello" + searchSuffix))
        for (int i = 0; i < expectedHits + 1; i++) {
        ImmutableCacheStats expectedTotal = new ImmutableCacheStats(expectedHits, expectedMisses, 0, 0, expectedMisses);
        statsHolder = getNodeCacheStatsResult(client, List.of());
     * are as we expect.
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
     * unaffected.
    private static void checkCacheStatsAPIResponse(
        assertEquals(1, nodeStatsResponse.getNodes().size());
        assertNotNull(aggregatedStatsResponse);
        // Search for the same doc to give hits
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
            searchIndex(client, index, String.valueOf(i));
import org.opensearch.transport.client.Client;
        }
    /**
    private static ImmutableCacheStatsHolder getNodeCacheStatsResult(Client client, List<String> aggregationLevels) throws IOException {
        checkCacheStatsAPIResponse(statsHolder, List.of(), expectedTotal, false, true);
        RequestCacheStats oldApiStats = client.admin()
            .getTotal()
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
                .prepareCreate(indexName)
        String index1Name = "index1";
        assertEquals(expectedStats.getMisses(), (int) aggregatedStatsResponse.getMisses());
        );
import org.opensearch.cluster.metadata.IndexMetadata;
        Map<String, String> paramMap = new HashMap<>();
        String index2Name = "index2";
        assertEquals(6, xContentMap.size());
     */
        for (int i = 0; i < numKeys; i++) {
     * check that the new and old APIs are both correctly estimating memory size,
        if (checkEntries) {
        if (aggregationLevels == null) {
                .get()
import org.opensearch.test.OpenSearchIntegTestCase;
        ImmutableCacheStatsHolder indicesStats = getNodeCacheStatsResult(client, List.of(IndicesRequestCache.INDEX_DIMENSION_NAME));
    }
        NodesStatsResponse nodeStatsResponse = client.admin()
            .get();
        assertTrue(requestSize > 0);
            searchIndex(client, index, String.valueOf(i));
        String[] flagsLevels;
            flagsLevels = aggregationLevels.toArray(new String[0]);
    private void startIndex(Client client, String indexName) throws InterruptedException {
        assertSearchResponse(resp);
        int expectedMisses = 7;
        searchIndex(client, index2Name, "");
                )
        // Aggregate by indices and shards
        ImmutableCacheStats aggregatedStatsResponse = statsHolder.getStatsForDimensionValues(dimensionValues);
            searchIndex(client, index, "");
     */
            .cluster()
        ImmutableCacheStatsHolder indicesAndShardsStats = getNodeCacheStatsResult(
    private SearchResponse searchIndex(Client client, String index, String searchSuffix) {
            .prepareNodesStats("data:true")
        statsHolder.toXContent(builder, params);
import org.opensearch.index.cache.request.RequestCacheStats;
import org.opensearch.index.query.QueryBuilders;
        List<String> index1Dimensions = List.of(index1Name);
}
 * compatible open source license.
        ImmutableCacheStats expectedStats = new ImmutableCacheStats(1, 1, 0, 0, 1);
        builder.endObject();
        // Request cache should be present in the response
        checkCacheStatsAPIResponse(statsHolder, List.of(), expected, true, false);
        return ncs.getStatsByCache(CacheType.INDICES_REQUEST_CACHE);
 * The OpenSearch Contributors require contributions made to
        // Don't check the memory size, just assert it's nonzero
        assertNotEquals(0, oldApiStats.getMemorySizeInBytes());
import org.opensearch.test.hamcrest.OpenSearchAssertions;
import org.opensearch.action.search.SearchResponse;
     * using the logic that includes the overhead memory in ICacheKey.
        for (int i = 0; i < 2; i++) {
        ToXContent.Params params = new ToXContent.MapParams(paramMap);
        XContentBuilder builder = XContentFactory.jsonBuilder();
        // Values should be at nodes.[node_id].caches.request_cache
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
        startIndex(client, index1Name);
            .indices()
    public void testNodesStatsResponse() throws Exception {
            .prepareStats(index)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import java.util.HashMap;
        checkCacheStatsAPIResponse(shardsStats, index2Shard0Dimensions, expectedStats, true, true);
            .setRequestCache(true)
        ImmutableCacheStatsHolder statsHolder,
     */
        ToXContent.Params params = new ToXContent.MapParams(paramMap);
import org.opensearch.common.Randomness;
        // Don't check entries, as the old API doesn't track this
            .get();
        startIndex(client, index);
        checkCacheStatsAPIResponse(indicesAndShardsStats, index1Dimensions, expectedStats, true, true);
        SearchResponse resp = client.prepareSearch(index)
import java.util.List;
            .get()
        NodeCacheStats ncs = nodeStatsResponse.getNodes().get(0).getNodeCacheStats();
        NodesStatsResponse nodeStatsResponse = client.admin()
        );
            .addMetric(NodesStatsRequest.Metric.CACHE_STATS.metricName())
        Client client = client();
        Client client = client();
        int expectedHits = 2;
        Client client = client();
            searchIndex(client, index, String.valueOf(i));
        for (int i = 0; i < numKeys; i++) {
    }
        startIndex(client, index);
    /**
import java.util.Map;
            .prepareNodesStats("data:true")
        assertEquals(expectedStats.getHits(), (int) aggregatedStatsResponse.getHits());
        int numKeys = Randomness.get().nextInt(100) + 1;
        builder.endObject();
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge(indexName).setFlush(true).get();
        // We searched once in index 2, we expect 1 miss + 1 entry
        startIndex(client, index2Name);
        boolean checkEntries
        builder.startObject();
        Map<String, Object> xContentMap = getStatsXContent(getNodeCacheStatsResult(client, null));
        List<String> index2Shard0Dimensions = List.of("[" + index2Name + "][0]");
package org.opensearch.indices;
        assertAcked(
        assertEquals(1, nodesResponse.size());
import org.opensearch.common.xcontent.XContentHelper;
     */
    public void testCacheStatsAPIWIthOnHeapCache() throws Exception {
        long requestSize = indicesStats.getStatsForDimensionValues(List.of(index1Name)).getSizeInBytes();
        // First, aggregate by indices only
        checkCacheStatsAPIResponse(indicesStats, index2Dimensions, expectedStats, true, true);
        return XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), resultString, true);
        expectedStats = new ImmutableCacheStats(1, 1, 0, requestSize, 1);
import org.opensearch.index.IndexSettings;
        checkCacheStatsAPIResponse(statsHolder, List.of(), expectedTotal, true, true);
        Client client = client();
                .indices()
            .all() // This mimics /_nodes/stats
        CommonStatsFlags statsFlags = new CommonStatsFlags();
import org.opensearch.core.xcontent.XContentBuilder;
    }
    /**
            .setRequestCache(true)
        indexRandom(true, client.prepareIndex(indexName).setSource("k", "hello"));
        List<String> index1Shard0Dimensions = List.of("[" + index1Name + "][0]");
import org.opensearch.common.unit.TimeValue;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            client.admin()
import org.opensearch.core.xcontent.MediaTypeRegistry;
        startIndex(client, index);
        }
    }
    }
import org.opensearch.common.cache.stats.ImmutableCacheStats;
            oldApiStats.getMissCount(),
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
     * Test clearing the cache using API sets memory size and number of items to 0, but leaves other stats
    public void testCacheClear() throws Exception {
    }
        // Now size and items should be 0
            oldApiStats.getEvictions(),
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, IndicesRequestCache.SHARD_ID_DIMENSION_NAME)
        }
        ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest(index);
        // Aggregate by shards only
        index2Dimensions = List.of(index2Name, "[" + index2Name + "][0]");
        XContentBuilder builder = XContentFactory.jsonBuilder();
     * Test the cache stats responses are in the expected place in XContent when we call the overall API
    }
        assertTrue(cachesResponse.containsKey("request_cache"));
    ) {
            searchIndex(client, index, String.valueOf(i));
     * Only the total cache stats should be returned.
        Map<String, Object> xContentMap = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), builder.toString(), true);
        nodeStatsResponse.toXContent(builder, params);
public class CacheStatsAPIIndicesRequestCacheIT extends OpenSearchIntegTestCase {
        ImmutableCacheStats expected = new ImmutableCacheStats(
 * this file be licensed under the Apache-2.0 license or a
        String resultString = builder.toString();
        // Search twice for the same doc in index 1
        }
     * Test the XContent in the response behaves correctly when we pass null levels.
import org.opensearch.core.xcontent.ToXContent;
     */
        if (checkMemorySize) {
        checkCacheStatsAPIResponse(indicesAndShardsStats, index2Dimensions, expectedStats, true, true);
import org.opensearch.common.settings.Settings;
        expectedStats = new ImmutableCacheStats(0, 1, 0, requestSize, 1);
        expectedTotal = new ImmutableCacheStats(expectedHits, expectedMisses, 0, 0, 0);
        // Null levels should result in only the total cache stats being returned -> 6 fields inside the response.
        String index = "index";
        }
        assertEquals(expectedStats.getEvictions(), (int) aggregatedStatsResponse.getEvictions());
        index1Dimensions = List.of(index1Name, "[" + index1Name + "][0]");
            oldApiStats.getMemorySizeInBytes(),
    /**
        String nodeId = nodesResponse.keySet().toArray(String[]::new)[0];
        Map<String, String> paramMap = new HashMap<>();
    public void testStatsMatchOldApi() throws Exception {
            flagsLevels = null;
        statsFlags.includeAllCacheTypes();
        List<String> dimensionValues,
        expectedStats = new ImmutableCacheStats(1, 1, 0, requestSize, 1);
    /**
        }
     * Test aggregating by indices, indices+shards, shards, or no levels, and check the resulting stats
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        String index = "index";
        }
        ensureSearchable(indexName);
        // Search for new docs
        // Clear cache
import org.opensearch.common.cache.service.NodeCacheStats;
        expectedStats = new ImmutableCacheStats(1, 2, 0, 2 * requestSize, 2);
            .cluster()
        builder.startObject();
        checkCacheStatsAPIResponse(shardsStats, index1Shard0Dimensions, expectedStats, true, true);
        expectedStats = new ImmutableCacheStats(0, 1, 0, requestSize, 1);
        String index = "index";
        } else {
     * GET /_nodes/stats. They should be at nodes.[node_id].caches.request_cache.
            .setIndices(statsFlags)
        checkCacheStatsAPIResponse(indicesStats, index1Dimensions, expectedStats, false, true);
        // Get some hits as well
                        // Disable index refreshing to avoid cache being invalidated mid-test
        checkCacheStatsAPIResponse(indicesStats, totalStatsKeys, expectedStats, true, true);
        // Get the node id
        assertNotEquals(0, originalMemorySize);
/*
        client.admin().indices().clearCache(clearIndicesCacheRequest).actionGet();
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> nodesResponse = (Map<String, Object>) xContentMap.get("nodes");
        for (int i = 0; i < expectedMisses - 1; i++) {
        // Since we searched twice, we expect to see 1 hit, 1 miss and 1 entry for index 1
 *
     * Check the new stats API returns the same values as the old stats API. In particular,
                .setSettings(
