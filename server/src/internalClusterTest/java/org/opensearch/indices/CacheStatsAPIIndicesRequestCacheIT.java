     * Test aggregating by indices, indices+shards, shards, or no levels, and check the resulting stats  
            .get();  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.IndexSettings;
    public void testCacheStatsAPIWIthOnHeapCache() throws Exception {  
        statsFlags.includeAllCacheTypes();  
            searchIndex(client, index1Name, "");
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;  
import org.opensearch.core.xcontent.XContentBuilder;
            .cluster()
 */  
        checkCacheStatsAPIResponse(indicesStats, totalStatsKeys, expectedStats, true, true);
        expectedStats = new ImmutableCacheStats(0, 1, 0, requestSize, 1);
        startIndex(client, index1Name);
import java.util.List;
        String nodeId = nodesResponse.keySet().toArray(String[]::new)[0];
        for (int i = 0; i < expectedMisses - 1; i++) {
        startIndex(client, index);  
        int expectedHits = 2;  
        }  
        }  
        // Search for the same doc to give hits
                    Settings.builder()  
        String index2Name = "index2";
        indexRandom(true, client.prepareIndex(indexName).setSource("k", "hello"));  
        return XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), resultString, true);
    }
        return ncs.getStatsByCache(CacheType.INDICES_REQUEST_CACHE);  
        nodeStatsResponse.toXContent(builder, params);  
        Client client = client();  
        // Get the node id
            client,  
     */  
            oldApiStats.getHitCount(),
        }
        List<String> index2Shard0Dimensions = List.of("[" + index2Name + "][0]");  
     */
    private void startIndex(Client client, String indexName) throws InterruptedException {
        int numKeys = Randomness.get().nextInt(100) + 1;
    ) {
        checkCacheStatsAPIResponse(shardsStats, index1Shard0Dimensions, expectedStats, true, true);
        }  
        // Request cache should be present in the response
        // Don't check the memory size, just assert it's nonzero
        String index = "index";
    private SearchResponse searchIndex(Client client, String index, String searchSuffix) {  
        // Search once for a doc in index 2
        checkCacheStatsAPIResponse(indicesStats, index1Dimensions, expectedStats, false, true);
        NodeCacheStats ncs = nodeStatsResponse.getNodes().get(0).getNodeCacheStats();
        checkCacheStatsAPIResponse(indicesAndShardsStats, index2Dimensions, expectedStats, true, true);
    }
        startIndex(client, index);
            .prepareStats(index)
        // Don't check entries, as the old API doesn't track this
            client.admin()
        startIndex(client, index);
        SearchResponse resp = client.prepareSearch(index)
        ensureSearchable(indexName);  
        CommonStatsFlags statsFlags = new CommonStatsFlags();
        String index = "index";  
            searchIndex(client, index, String.valueOf(i));
     * Test the XContent in the response behaves correctly when we pass null levels.
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        checkCacheStatsAPIResponse(indicesAndShardsStats, index1Dimensions, expectedStats, true, true);
        ImmutableCacheStatsHolder shardsStats = getNodeCacheStatsResult(client, List.of(IndicesRequestCache.SHARD_ID_DIMENSION_NAME));
        assertNotEquals(0, originalMemorySize);
        Client client = client();  
            oldApiStats.getMemorySizeInBytes(),
                )  
            .get()
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        // Values should be at nodes.[node_id].caches.request_cache  
            .get();
        for (int i = 0; i < 2; i++) {  
 * compatible open source license.
        assertTrue(requestSize > 0);
        String[] flagsLevels;
        ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest(index);
// Use a single data node to simplify logic about cache stats across different shards.
        assertEquals(1, nodesResponse.size());  
        startIndex(client, index);
        // Aggregate by shards only
    public void testStatsMatchOldApi() throws Exception {
                .indices()
        Map<String, Object> nodesResponse = (Map<String, Object>) xContentMap.get("nodes");
    /**
        // Clear cache  
        }
        // Search for new docs  
            flagsLevels = aggregationLevels.toArray(new String[0]);
            .cluster()  
        );
        startIndex(client, index2Name);  
            .prepareNodesStats("data:true")
        Map<String, Object> xContentMap = XContentHelper.convertToMap(MediaTypeRegistry.JSON.xContent(), builder.toString(), true);
        for (int i = 0; i < numKeys / 2; i++) {
    }
    }  
        ImmutableCacheStats expected = new ImmutableCacheStats(
            flagsLevels = null;  
import org.opensearch.index.cache.request.RequestCacheStats;  
        assertEquals(6, xContentMap.size());
        ImmutableCacheStats expectedStats,
        // Get some hits as well
    /**  
        checkCacheStatsAPIResponse(statsHolder, List.of(), expectedTotal, true, true);
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;  
     * GET /_nodes/stats. They should be at nodes.[node_id].caches.request_cache.  
    private static Map<String, Object> getStatsXContent(ImmutableCacheStatsHolder statsHolder) throws IOException {  
        ImmutableCacheStats expectedStats = new ImmutableCacheStats(1, 1, 0, 0, 1);  
     * using the logic that includes the overhead memory in ICacheKey.
 *
        checkCacheStatsAPIResponse(statsHolder, List.of(), expectedTotal, false, true);
public class CacheStatsAPIIndicesRequestCacheIT extends OpenSearchIntegTestCase {
 * SPDX-License-Identifier: Apache-2.0
        // Now size and items should be 0
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .setRequestCache(true)  
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
import org.opensearch.common.unit.TimeValue;
        assertNotEquals(0, oldApiStats.getMemorySizeInBytes());
        // Since we searched twice, we expect to see 1 hit, 1 miss and 1 entry for index 1
        String resultString = builder.toString();  
     */
        ImmutableCacheStatsHolder statsHolder = getNodeCacheStatsResult(client, List.of());  
import java.util.Map;  
            .getRequestCache();  
import org.opensearch.common.cache.stats.ImmutableCacheStats;
     */  
        int expectedMisses = 7;
        index2Dimensions = List.of(index2Name, "[" + index2Name + "][0]");  
     */
    /**
    public void testCacheClear() throws Exception {  
    public void testNullLevels() throws Exception {
package org.opensearch.indices;
        for (int i = 0; i < expectedHits + 1; i++) {  
        expectedStats = new ImmutableCacheStats(1, 1, 0, requestSize, 1);  
     * Check the new stats API returns the same values as the old stats API. In particular,  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.common.Randomness;
        Client client = client();  
import org.opensearch.index.query.QueryBuilders;
        NodesStatsResponse nodeStatsResponse = client.admin()
 * The OpenSearch Contributors require contributions made to  
        // Can always get the first data node as there's only one in this test suite  
        expectedStats = new ImmutableCacheStats(0, 1, 0, requestSize, 1);
        checkCacheStatsAPIResponse(indicesStats, index2Dimensions, expectedStats, true, true);  
        String index = "index";
    }
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        String index1Name = "index1";
    }  
        boolean checkMemorySize,
        builder.endObject();
}
        expectedStats = new ImmutableCacheStats(1, 1, 0, requestSize, 1);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)  
import org.opensearch.common.settings.Settings;
        builder.startObject();
            .addMetric(NodesStatsRequest.Metric.CACHE_STATS.metricName())  
        if (aggregationLevels == null) {
        List<String> index2Dimensions = List.of(index2Name);  
import org.opensearch.common.cache.CacheType;  
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
        Map<String, Object> cachesResponse = (Map<String, Object>) ((Map<String, Object>) nodesResponse.get(nodeId)).get("caches");
        expectedTotal = new ImmutableCacheStats(expectedHits, expectedMisses, 0, 0, 0);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    public void testNodesStatsResponse() throws Exception {
import org.opensearch.action.search.SearchResponse;  
        for (int i = 0; i < numKeys; i++) {  
        // We searched once in index 2, we expect 1 miss + 1 entry
        boolean checkEntries  
        statsHolder.toXContent(builder, params);  
        assertEquals(1, nodeStatsResponse.getNodes().size());
            searchIndex(client, index, String.valueOf(i));  
                .get()
        }
        } else {
        List<String> dimensionValues,  
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        long requestSize = indicesStats.getStatsForDimensionValues(List.of(index1Name)).getSizeInBytes();  
        assertEquals(expectedStats.getEvictions(), (int) aggregatedStatsResponse.getEvictions());  
        OpenSearchAssertions.assertAllSuccessful(resp);  
        }  
    }
import org.opensearch.common.xcontent.XContentHelper;
        ImmutableCacheStats expectedTotal = new ImmutableCacheStats(expectedHits, expectedMisses, 0, 0, expectedMisses);
        assertAcked(  
                .setSettings(
            0  
     * unaffected.
        assertNotNull(cachesResponse);  
            oldApiStats.getEvictions(),
                .setMapping("k", "type=keyword")
        ImmutableCacheStatsHolder indicesStats = getNodeCacheStatsResult(client, List.of(IndicesRequestCache.INDEX_DIMENSION_NAME));
        }
            assertEquals(expectedStats.getSizeInBytes(), (int) aggregatedStatsResponse.getSizeInBytes());
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, IndicesRequestCache.SHARD_ID_DIMENSION_NAME)
    private static void checkCacheStatsAPIResponse(
            .setQuery(QueryBuilders.termQuery("k", "hello" + searchSuffix))  
/*  
    /**
        builder.endObject();
        );
        String index = "index";
     * check that the new and old APIs are both correctly estimating memory size,
        return resp;
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
        assertEquals(expectedStats.getHits(), (int) aggregatedStatsResponse.getHits());
        builder.startObject();
        Map<String, String> paramMap = new HashMap<>();
    }  
        }  
        ToXContent.Params params = new ToXContent.MapParams(paramMap);  
        XContentBuilder builder = XContentFactory.jsonBuilder();
import org.opensearch.common.xcontent.XContentFactory;  
            .indices()
        client.admin().indices().clearCache(clearIndicesCacheRequest).actionGet();
        // Null levels should result in only the total cache stats being returned -> 6 fields inside the response.
                .prepareCreate(indexName)  
        expectedStats = new ImmutableCacheStats(0, 1, 0, requestSize, 1);
        for (int i = 0; i < numKeys; i++) {
                        // Disable index refreshing to avoid cache being invalidated mid-test
        assertNotNull(aggregatedStatsResponse);  
import java.io.IOException;  
        Map<String, Object> xContentMap = getStatsXContent(getNodeCacheStatsResult(client, null));  
        searchIndex(client, index2Name, "");
            assertEquals(expectedStats.getItems(), (int) aggregatedStatsResponse.getItems());
        List<String> index1Shard0Dimensions = List.of("[" + index1Name + "][0]");
            searchIndex(client, index, String.valueOf(i));
        ImmutableCacheStatsHolder indicesAndShardsStats = getNodeCacheStatsResult(
        ToXContent.Params params = new ToXContent.MapParams(paramMap);  
    }
        Map<String, String> paramMap = new HashMap<>();
     * Only the total cache stats should be returned.
            searchIndex(client, index, String.valueOf(i));
        // First, aggregate by indices only
            .setIndices(statsFlags)
        // Get the request size for one request, so we can reuse it for next index
        Client client = client();
        statsFlags.setLevels(flagsLevels);
     * are as we expect.
            .get();
        checkCacheStatsAPIResponse(shardsStats, index2Shard0Dimensions, expectedStats, true, true);
import java.util.HashMap;
        ImmutableCacheStats aggregatedStatsResponse = statsHolder.getStatsForDimensionValues(dimensionValues);
     * Test clearing the cache using API sets memory size and number of items to 0, but leaves other stats  
        XContentBuilder builder = XContentFactory.jsonBuilder();
        RequestCacheStats oldApiStats = client.admin()  
            searchIndex(client, index, "");
        index1Dimensions = List.of(index1Name, "[" + index1Name + "][0]");
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge(indexName).setFlush(true).get();
        ImmutableCacheStatsHolder statsHolder,
        assertSearchResponse(resp);
import org.opensearch.core.xcontent.ToXContent;  
        // Search twice for the same doc in index 1
            .setRequestCache(true)
            .prepareNodesStats("data:true")
        NodesStatsResponse nodeStatsResponse = client.admin()  
import org.opensearch.common.cache.service.NodeCacheStats;
        if (checkMemorySize) {
        checkCacheStatsAPIResponse(statsHolder, List.of(), expected, true, false);  
        // Aggregate by indices and shards
        expectedStats = new ImmutableCacheStats(1, 2, 0, 2 * requestSize, 2);  
        int numKeys = Randomness.get().nextInt(100) + 1;  
        long originalMemorySize = statsHolder.getTotalSizeInBytes();  
        List<String> index1Dimensions = List.of(index1Name);
            .all() // This mimics /_nodes/stats
    }
        Client client = client();
        // The total stats for the node should be 1 hit, 2 misses, and 2 entries
        if (checkEntries) {
import org.opensearch.transport.client.Client;
        statsHolder = getNodeCacheStatsResult(client, List.of());  
    /**
        List<String> totalStatsKeys = List.of();
     * Test the cache stats responses are in the expected place in XContent when we call the overall API
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
    private static ImmutableCacheStatsHolder getNodeCacheStatsResult(Client client, List<String> aggregationLevels) throws IOException {
        assertEquals(expectedStats.getMisses(), (int) aggregatedStatsResponse.getMisses());
        assertTrue(cachesResponse.containsKey("request_cache"));
            .getTotal()
import org.opensearch.cluster.metadata.IndexMetadata;
        ImmutableCacheStatsHolder statsHolder = getNodeCacheStatsResult(client, List.of());  
            oldApiStats.getMissCount(),  
