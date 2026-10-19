            flagsLevels = aggregationLevels.toArray(new String[0]);  
        }  
        startIndex(client, index);
        ImmutableCacheStats index2DiskExpectedStats = returnNullIfAllZero(
        int hitsOnHeapIndex2 = randomInt(itemsOnHeapIndex2AfterTest);
            client.admin()
        ImmutableCacheStats totalDiskExpectedStats = returnNullIfAllZero(
            .getTotal()
 * this file be licensed under the Apache-2.0 license or a
        // Cause some hits
            new ImmutableCacheStats(
        assertEquals(oldAPIStats.getMemorySizeInBytes(), totalStats.getSizeInBytes());  
        for (int i = 1; i < expectedEntries; i++) {  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
    }
            getTotalStats(client)
                .put(
        Map<String, Integer> values = setupCacheForAggregationTests(client);  
            Settings.builder()
            List.of("unrecognized_dimension_1", "unrecognized_dimension_2")  
        }
        );  
    /**  
        SearchResponse resp = client.prepareSearch(index)  
        expectedValues.put("itemsOnHeapIndex2AfterTest", itemsOnHeapIndex2AfterTest);
        assertEquals(totalHeapExpectedStats, heapStats);
        );
            new ImmutableCacheStats(
    }  
        // Get values broken down by indices+tiers  
        int hitsOnHeapIndex1 = randomInt(itemsOnHeapIndex1AfterTest);  
        int singleSearchSizeApproxUpperBound = 700; // We know this from other tests and manually verifying
        // Avoid forbidden API String.format()
        assertEquals(totalDiskExpectedStats, diskStats);  
        int expectedHits = randomIntBetween(itemsOnHeap, expectedEntries); // Select it so some hits come from both tiers
        internalCluster().startNodes(  
                0,
            1,  
        ImmutableCacheStatsHolder indicesOnlyStatsHolder = getNodeCacheStatsResult(  
        }
    }
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_ON_HEAP))  
        for (int i = itemsOnDiskAfterTest + itemsOnHeapIndex1AfterTest; i < itemsOnDiskAfterTest + itemsOnHeapIndex1AfterTest
        int itemsOnDiskAfterTest = 1 + randomInt(30); // The first one we search (to get the size) always goes to disk
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest("index")).get());
                values.get("itemsOnDiskIndex2AfterTest") * values.get("singleSearchSize"),  
        }
        Map<String, Integer> values = setupCacheForAggregationTests(client);
                values.get("itemsOnHeapIndex2AfterTest") + values.get("itemsOnDiskIndex2AfterTest"),
        return expectedValues;  
            new ImmutableCacheStats(  
import org.opensearch.plugins.Plugin;  
        }
            searchIndex(client, index, i);  
        assertBusy(() -> assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), getTotalStats(client)));  
        CommonStatsFlags statsFlags = new CommonStatsFlags();  
        int itemsOnDiskIndex2AfterTest = itemsOnDiskAfterTest - itemsOnDiskIndex1AfterTest;
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge(indexName).setFlush(true).get();
        );  
                values.get("hitsOnDiskIndex1") + values.get("hitsOnDiskIndex2"),
            client,
        for (int i = 0; i < expectedHits; i++) {  
    public void testStatsMatchOldApi() throws Exception {  
     */
        );  
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_DISK;
        Client client = client();
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
            flagsLevels = null;
    }
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_NAME;
        for (int i = 0; i < hitsOnDiskIndex1; i++) {
        );  
    @Override
        for (int i = itemsOnDiskAfterTest; i < itemsOnDiskAfterTest + itemsOnHeapIndex1AfterTest; i++) {  
        );
                values.get("itemsOnHeapAfterTest") * values.get("singleSearchSize"),
    }
        // get total stats  
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME)
        NodesStatsResponse nodeStatsResponse = client.admin()
        searchIndex(client, index, 0);
        return expectedStats;  
        );  
        );
        ensureSearchable(indexName);
            new ImmutableCacheStats(expectedHits, expectedMisses, 0, expectedEntries * singleSearchSize, expectedEntries),
        );  
import org.opensearch.cluster.metadata.IndexMetadata;
        if (input.length() >= finalLength) {
     * Test aggregating by indices
            index1HeapExpectedStats,
        for (int i = itemsOnDiskAfterTest; i < itemsOnDiskAfterTest + hitsOnHeapIndex1; i++) {
            // Cause misses
                    TimeValue.ZERO
            // pad with zeros so request 0 and request 10 have the same size ("0000" and "0010" instead of "0" and "10")  
                values.get("hitsOnHeapIndex1") + values.get("hitsOnDiskIndex1"),  
        // Check the new stats API values are as expected
        ImmutableCacheStatsHolder allLevelsStatsHolder = getNodeCacheStatsResult(
                values.get("itemsOnDiskIndex1AfterTest")
                values.get("hitsOnHeapIndex2") + values.get("hitsOnDiskIndex2"),  
        for (int i = 1; i < itemsOnDiskIndex1AfterTest; i++) { // Start at 1 as 0 has already been searched
        long singleSearchSize = getTotalStats(client).getSizeInBytes();
        internalCluster().startNodes(
                values.get("hitsOnHeapIndex1") + values.get("hitsOnHeapIndex2"),  
        assertEquals(noLevelsStatsHolder, noLevelsEquivalentStatsHolder);  
            + hitsOnHeapIndex2; i++) {  
                    "hitsOnDiskIndex2"
        // The earliest items (0 - itemsOnDiskAfterTest) are the ones which get evicted to disk
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    private String padWithZeros(int finalLength, int inputValue) {
    }
    }  
        startNodesDefaultSettings();
        return resp;
        int expectedHits = randomIntBetween(itemsOnHeap, expectedEntries); // Select it so some hits come from both tiers
        int expectedEntries = itemsOnHeap + itemsOnDisk;
        // Get some hits on all combinations of indices and tiers  
                .put(
            client,
        // Put these values into a map so tests can know what to expect in stats responses
    }  
        } else {
        assertTrue(diskCacheStat.getHits() == 0);
        );  
        ImmutableCacheStatsHolder allLevelsStatsHolder = getNodeCacheStatsResult(
            new ImmutableCacheStats(0, numberOfSegments, 0, singleSearchSize * numberOfSegments, numberOfSegments)
        return statsHolder.getStatsForDimensionValues(List.of());
    private static final String HEAP_CACHE_SIZE_STRING = "10000B";
        assertEquals(indicesOnlyStatsHolder, indicesEquivalentStatsHolder);  
    }
        for (int i = 0; i < expectedHits; i++) {
        }  
        OpenSearchAssertions.assertAllSuccessful(resp);  
            Settings.builder()
        // be the same as its max capacity  
        }
        index1OnHeapExpectedStats = returnNullIfAllZero(
                )  
            .get()  
            // heap hits for index 2
                        .build()
        startNodesDefaultSettings();
        );
                .put(defaultSettings(heap_cache_size_per_segment * numberOfSegments + "B", numberOfSegments))
        ImmutableCacheStats totalStats = getNodeCacheStatsResult(client, List.of()).getTotalStats();  
        // First search one time to calculate item size
        startNodesDefaultSettings();  
            searchIndex(client, index2Name, i);
    }
            client,  
        assertEquals(allLevelsStatsHolder, indicesAndTierEquivalentStatsHolder);
     * Check the new stats API returns the same values as the old stats API.
        );
import org.opensearch.transport.client.Client;  
        expectedValues.put("itemsOnDiskIndex1AfterTest", itemsOnDiskIndex1AfterTest);  
    private void startIndex(Client client, String indexName) throws InterruptedException {  
            )
    }
            totalStats
    private static final String index1Name = "index1";  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
    private SearchResponse searchIndex(Client client, String index, int searchSuffix) {
        assertEquals(
            index2DiskExpectedStats,
        expectedValues.put("hitsOnDiskIndex2", hitsOnDiskIndex2);
        ImmutableCacheStats onHeapCacheStat = allLevelsStatsHolder.getStatsForDimensionValues(
                values.get("itemsOnHeapAfterTest") + values.get("itemsOnDiskAfterTest") + values.get("hitsOnDiskIndex1") + values.get(
        assertEquals(  
        int expectedMisses = itemsOnHeap + itemsOnDisk;
        assertEquals(1, nodeStatsResponse.getNodes().size());  
        }
        int itemsOnDiskIndex1AfterTest = 1 + randomInt(itemsOnDiskAfterTest - 1);  
        int expectedMisses = itemsOnHeap + itemsOnDisk;
        for (ImmutableCacheStatsHolder statsHolder : List.of(allLevelsStatsHolder, indicesOnlyStatsHolder)) {
        Map<String, Integer> expectedValues = new HashMap<>();  
            return null;
        statsFlags.setLevels(flagsLevels);
import java.util.Arrays;  
    private static final String index2Name = "index2";
        statsFlags.includeAllCacheTypes();
        // This should be equivalent to "indices", "tier"
        assertTrue(diskCacheStat.getMisses() > 0);
            .cluster()
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_DISK))
        return ncs.getStatsByCache(CacheType.INDICES_REQUEST_CACHE);
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index2Name, TIER_DIMENSION_VALUE_DISK))  
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_ON_HEAP;  
import org.opensearch.index.cache.request.RequestCacheStats;  
    public void testTierLevelAggregation() throws Exception {
                .get()  
        ImmutableCacheStatsHolder indicesOnlyStatsHolder = getNodeCacheStatsResult(  
        );  
    private void startNodesDefaultSettings() {
        ImmutableCacheStatsHolder indicesAndTierEquivalentStatsHolder = getNodeCacheStatsResult(  
        internalCluster().startNodes(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            )  
        ImmutableCacheStatsHolder tiersOnlyStatsHolder = getNodeCacheStatsResult(client, List.of(TIER_DIMENSION_NAME));  
            List.of(index1Name, TIER_DIMENSION_VALUE_ON_HEAP)  
        assertEquals(  
     * Test aggregating by indices and tier  
        ImmutableCacheStatsHolder indicesEquivalentStatsHolder = getNodeCacheStatsResult(
        int heap_cache_size_per_segment = singleSearchSizeApproxUpperBound * numberOfSegments; // Worst case if all  
        }  
/*  
    private ImmutableCacheStats getTotalStats(Client client) throws IOException {  
            .addMetric(NodesStatsRequest.Metric.CACHE_STATS.metricName())
                values.get("itemsOnHeapIndex1AfterTest")
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME)
    public void testIndicesAndTierLevelAggregation() throws Exception {
        );
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME)  
        expectedValues.put("itemsOnHeapIndex1AfterTest", itemsOnHeapIndex1AfterTest);
        for (int i = 1; i < numberOfSegments; i++) {  
            searchIndex(client, index1Name, i);  
                values.get("hitsOnHeapIndex1"),  
                values.get("itemsOnDiskIndex2AfterTest") + values.get("itemsOnHeapIndex2AfterTest"),
        for (int i = itemsOnDiskAfterTest + itemsOnHeapIndex1AfterTest; i < itemsOnDiskAfterTest + itemsOnHeapAfterTest; i++) {  
                .setMapping("k", "type=keyword")
            .setIndices(statsFlags)
                    TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
        // First search one time to see how big a single value will be  
        // Now fire same queries to get some hits
        // get total stats
        );
        NodeCacheStats ncs = nodeStatsResponse.getNodes().get(0).getNodeCacheStats();
            // disk hits for index 1
            1,  
            searchIndex(client, index1Name, i);
                .setSettings(  
                    TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
import org.opensearch.test.OpenSearchIntegTestCase;
        long singleSearchSize = getTotalStats(client).getSizeInBytes();
        expectedValues.put("hitsOnHeapIndex2", hitsOnHeapIndex2);
package org.opensearch.cache.common.tier;
import org.opensearch.index.query.QueryBuilders;
        }
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)  
            )  
        }
                (values.get("itemsOnDiskIndex1AfterTest") + values.get("itemsOnHeapIndex1AfterTest")) * values.get("singleSearchSize"),  
                (values.get("itemsOnDiskIndex2AfterTest") + values.get("itemsOnHeapIndex2AfterTest")) * values.get("singleSearchSize"),  
        int itemsOnHeapAfterTest = HEAP_CACHE_SIZE / (int) singleSearchSize; // As the heap tier evicts, the items on it after the test will
        );
            searchIndex(client, index2Name, i);
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        // If the randomly chosen numbers are such that the expected stats would be 0, we actually have not interacted with the cache for
        while (sb.length() < finalLength - input.length()) {
        int itemsOnHeap = HEAP_CACHE_SIZE / (int) singleSearchSize;  
                )
                values.get("itemsOnHeapAfterTest") + values.get("itemsOnDiskAfterTest"),
        Client client = client();
import org.opensearch.index.IndexSettings;
import java.util.List;  
import org.opensearch.common.unit.TimeValue;
            client,
                    TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
        );  
        // Select numbers so we get some values on both heap and disk
        );  
    }
        );
                .build()
        allLevelsStatsHolder = getNodeCacheStatsResult(client, List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME));  
        expectedValues.put("itemsOnHeapAfterTest", itemsOnHeapAfterTest); // Can only pass 10 keys in Map.of() constructor
        );
        // Test invalid levels are ignored and permuting the order of levels in the request doesn't matter
     */
                .build()  
        );
        );  
        // segment number for queries.  
        }
            .getRequestCache();
        int hitsOnDiskIndex1 = randomInt(itemsOnDiskIndex1AfterTest);
                values.get("hitsOnDiskIndex1"),
    private static final int HEAP_CACHE_SIZE = 10_000;
        return sb.toString();  
        startNodesDefaultSettings();
    }  
        Map<String, Integer> values = setupCacheForAggregationTests(client);  
                values.get("itemsOnHeapIndex1AfterTest") + values.get("itemsOnDiskIndex1AfterTest") + values.get("hitsOnDiskIndex1"),
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        expectedValues.put("itemsOnDiskIndex2AfterTest", itemsOnDiskIndex2AfterTest);
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
    public void testInvalidLevelsAreIgnored() throws Exception {  
     * Test aggregating by tier only
                values.get("itemsOnDiskIndex1AfterTest"),
        // This should be equivalent to no levels passed in  
import java.io.IOException;
    /**
        allLevelsStatsHolder = getNodeCacheStatsResult(client, List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME));
                .put(
        ImmutableCacheStats index1ExpectedStats = returnNullIfAllZero(
                        .getKey(),  
    private ImmutableCacheStats returnNullIfAllZero(ImmutableCacheStats expectedStats) {  
        ImmutableCacheStatsHolder allLevelsStatsHolder = getNodeCacheStatsResult(  
                ),  
import java.util.HashMap;
        expectedValues.put("singleSearchSize", (int) singleSearchSize);  
import java.util.Map;
        }
        String index = "index";
        );
                values.get("itemsOnDiskIndex1AfterTest") * values.get("singleSearchSize"),
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index2Name, TIER_DIMENSION_VALUE_ON_HEAP))
                .prepareCreate(indexName)
        ImmutableCacheStats totalHeapExpectedStats = returnNullIfAllZero(
        assertEquals(
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache  
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
        // Check the new stats API values are as expected
        // Get values for tiers alone and check they add correctly across indices
        for (int i = itemsOnDiskIndex1AfterTest; i < itemsOnDiskIndex1AfterTest + hitsOnDiskIndex2; i++) {
                0,  
            // disk hits for index 2  
import org.opensearch.common.cache.CacheType;
            .setRequestCache(true)
        ImmutableCacheStats heapStats = tiersOnlyStatsHolder.getStatsForDimensionValues(List.of(TIER_DIMENSION_VALUE_ON_HEAP));  
                .put(defaultSettings(HEAP_CACHE_SIZE_STRING, getNumberOfSegments()))
        // Similarly verify items are present on disk cache now
            )
        );
        // This should be equivalent to just "indices"
        // the indices dimension  
        for (int i = itemsOnDiskIndex1AfterTest; i < itemsOnDiskIndex1AfterTest + itemsOnDiskIndex2AfterTest; i++) {
            client,
            index1DiskExpectedStats,  
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_ON_HEAP))  
            new ImmutableCacheStats(
        if (aggregationLevels == null) {  
            )
        long singleSearchSize = getTotalStats(client).getSizeInBytes();  
            searchIndex(client, index, i);
            new ImmutableCacheStats(
 *
        // this index.
 */  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
            .indices()  
    public void testStatsWithMultipleSegments() throws Exception {  
        assertEquals(oldAPIStats.getHitCount(), totalStats.getHits());  
            // Cause misses
            searchIndex(client, index1Name, i);
            searchIndex(client, index, i);
            sb.append('0');  
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))  
        for (int i = 1; i < expectedEntries; i++) {
            assertEquals(index1ExpectedStats, statsHolder.getStatsForDimensionValues(List.of(index1Name)));  
            searchIndex(client, index1Name, i);
                values.get("itemsOnDiskIndex2AfterTest"),
            )
            searchIndex(client, index1Name, i);  
                .put(  
        }
        startIndex(client, index);
        searchIndex(client, index1Name, 0);
                )
                values.get("itemsOnDiskAfterTest")
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME)
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
    /**
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME)
                values.get("itemsOnHeapIndex1AfterTest") * values.get("singleSearchSize"),  
        // keys land up in same segment, it would still be able to accommodate.
        Map<String, Integer> values = setupCacheForAggregationTests(client);
        );
        assertSearchResponse(resp);
        StringBuilder sb = new StringBuilder();
            new ImmutableCacheStats(
        assertEquals(  
            client,  
    }
        assertAcked(
                .put(
            )
        sb.append(input);
            new ImmutableCacheStats(
        assertEquals(onHeapCacheStat.getEvictions(), diskCacheStat.getItems());
                0,
import org.opensearch.common.settings.Settings;  
        );  
            .prepareStats(index)
            new ImmutableCacheStats(  
            return input;
        ImmutableCacheStats index2HeapExpectedStats = returnNullIfAllZero(  
    public void testClosingShard() throws Exception {  
        expectedValues.put("hitsOnHeapIndex1", hitsOnHeapIndex1);
        ImmutableCacheStats index1OnHeapExpectedStats = returnNullIfAllZero(
                values.get("itemsOnHeapIndex1AfterTest") + values.get("itemsOnDiskIndex1AfterTest"),
            index1OnHeapExpectedStats,
        // Now try to evict from onheap cache by adding numberOfSegments ^ 2 which will guarantee this.  
    /**  
            Settings.builder()
                )  
        );
            client,  
                values.get("itemsOnHeapIndex2AfterTest") * values.get("singleSearchSize"),
    // Duplicated from CacheStatsAPIIndicesRequestCacheIT.java, as we can't add a dependency on server.internalClusterTest  
        }
        Client client = client();  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(diskCacheStat.getEvictions() == 0);  
        int itemsOnHeapIndex2AfterTest = itemsOnHeapAfterTest - itemsOnHeapIndex1AfterTest;
        }
        RequestCacheStats oldAPIStats = client.admin()
     */  
 * SPDX-License-Identifier: Apache-2.0
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, "unrecognized_dimension")
import org.opensearch.common.cache.stats.ImmutableCacheStats;
        // get total stats  
                0,
        int numberOfSegments = randomFrom(2, 4, 8, 16, 64);
                .put(  
        // Jut verifying evictions happened as can't fetch the exact number considering we don't have a way to get
        String index = "index";  
                values.get("itemsOnDiskIndex1AfterTest") + values.get("itemsOnHeapIndex1AfterTest"),
                    new TimeValue(0, TimeUnit.SECONDS)
            searchIndex(client, index1Name, i);
            index1OnHeapExpectedStats,
            assertEquals(index2ExpectedStats, statsHolder.getStatsForDimensionValues(List.of(index2Name)));
        for (int i = 0; i < numberOfSegments; i++) {  
        ImmutableCacheStats index2ExpectedStats = returnNullIfAllZero(
        }
import static org.opensearch.indices.IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING;
        long singleSearchSize = getTotalStats(client).getSizeInBytes();  
        expectedValues.put("itemsOnDiskAfterTest", itemsOnDiskAfterTest);
                    TimeValue.ZERO
        assertTrue(diskCacheStat.getSizeInBytes() > 0);  
                    Settings.builder()
        );
        startIndex(client, index1Name);  
                    TimeValue.ZERO  
            searchIndex(client, index2Name, i);  
import org.opensearch.indices.IndicesRequestCache;
        ImmutableCacheStatsHolder allLevelsStatsHolder = getNodeCacheStatsResult(
        // We will not see it in the XContent response.
        ImmutableCacheStatsHolder statsHolder = getNodeCacheStatsResult(client, List.of());
        // Cause some hits  
        // The remaining items stay on heap
// Use a single data node to simplify accessing cache stats across different shards.
        // Now check the new stats API values for the cache as a whole match the old stats API values
        // First search one time to see how big a single value will be  
import org.opensearch.common.cache.service.NodeCacheStats;  
                )
        startIndex(client, index1Name);  
        );
                values.get("hitsOnHeapIndex2"),
            searchIndex(client, index2Name, i);
        ImmutableCacheStats index1DiskCacheExpectedStats = returnNullIfAllZero(new ImmutableCacheStats(0, numberOfSegments, 0, 0, 0));
        }
            .get();
        ImmutableCacheStats diskStats = tiersOnlyStatsHolder.getStatsForDimensionValues(List.of(TIER_DIMENSION_VALUE_DISK));
        ImmutableCacheStats index1DiskExpectedStats = returnNullIfAllZero(
        String[] flagsLevels;
                )  
    }  
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))  
                0,  
        indexRandom(true, client.prepareIndex(indexName).setSource("k", "hello"));
            .setQuery(QueryBuilders.termQuery("k", "hello" + padWithZeros(4, searchSuffix)))
        int itemsOnDisk = 1 + randomInt(30); // The first one we search (to get the size) always goes to disk
        int expectedEntries = itemsOnHeap + itemsOnDisk;
                values.get("itemsOnDiskAfterTest") * values.get("singleSearchSize"),
            client,
        assertEquals(oldAPIStats.getEvictions(), totalStats.getEvictions());
            searchIndex(client, index1Name, i);  
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME)
    }
        // statsHolder.getStatsForDimensionValues().
                        .getKey(),
            List.of(TIER_DIMENSION_NAME, "unrecognized_dimension_1", IndicesRequestCache.INDEX_DIMENSION_NAME, "unrecognized_dimension_2")
                        // Disable index refreshing to avoid cache being invalidated mid-test
        searchIndex(client, index1Name, 0);
import java.util.Collection;
        assertEquals(
                values.get("itemsOnDiskIndex2AfterTest")
            new ImmutableCacheStats(numberOfSegments, numberOfSegments, 0, singleSearchSize * numberOfSegments, numberOfSegments)
        // First search one time to see how big a single value will be
        String input = String.valueOf(inputValue);  
        Client client = client();
                values.get("itemsOnDiskAfterTest"),
 * compatible open source license.
            1,
        Client client = client();  
                .put(defaultSettings(HEAP_CACHE_SIZE_STRING, 1))  
        // Can always get the first data node as there's only one in this test suite
        // The first one we search (to get the size) always goes to disk
        // Get values for indices alone, assert these match for statsHolders that have additional dimensions vs. a statsHolder that only has
            // heap hits for index 1
        return Arrays.asList(TieredSpilloverCachePlugin.class, TieredSpilloverCacheIT.MockDiskCachePlugin.class);
            client,
        expectedValues.put("hitsOnDiskIndex1", hitsOnDiskIndex1);  
        int itemsOnHeap = HEAP_CACHE_SIZE / (int) singleSearchSize;
                .indices()  
        assertTrue(onHeapCacheStat.getEvictions() > 0);
        }  
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
        // In this case, we expect the stats holder to have no stats for this node, and therefore we should get null from  
        assertEquals(
                values.get("itemsOnDiskIndex1AfterTest") + values.get("itemsOnHeapIndex1AfterTest")
}
                        .getKey(),  
public class TieredSpilloverCacheStatsIT extends TieredSpilloverCacheBaseIT {
                values.get("hitsOnDiskIndex2"),  
        searchIndex(client, index, 0);
        );
        int hitsOnDiskIndex2 = randomInt(itemsOnDiskIndex2AfterTest);  
                values.get("itemsOnHeapIndex2AfterTest") + values.get("itemsOnDiskIndex2AfterTest") + values.get("hitsOnDiskIndex2"),  
            new ImmutableCacheStats(expectedHits, expectedMisses, 0, expectedEntries * singleSearchSize, expectedEntries),  
        if (expectedStats.equals(new ImmutableCacheStats(0, 0, 0, 0, 0))) {  
        ImmutableCacheStatsHolder noLevelsStatsHolder = getNodeCacheStatsResult(client, List.of());
            .get();  
                    TimeValue.ZERO
                values.get("itemsOnHeapAfterTest")  
            .prepareNodesStats("data:true")  
            index2HeapExpectedStats,
import org.opensearch.test.hamcrest.OpenSearchAssertions;
            )
        ImmutableCacheStats index1HeapExpectedStats = returnNullIfAllZero(
        startIndex(client, index2Name);
                .build()
            .setRequestCache(true)
        ImmutableCacheStats diskCacheStat = allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_DISK));
            searchIndex(client, index, i);  
                values.get("itemsOnHeapIndex2AfterTest")  
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_DISK))
        // Select numbers so we get some values on both heap and disk
        for (int i = numberOfSegments; i < numberOfSegments + numberOfSegments * numberOfSegments; i++) {
                    new TimeValue(0, TimeUnit.SECONDS)
        assertEquals(oldAPIStats.getMissCount(), totalStats.getMisses());
        Client client = client();
        assertEquals(
        assertEquals(
        // Closing the index should close the shard
                )
        Client client = client();
        // Closing the shard should totally remove the stats associated with that shard.
        ImmutableCacheStatsHolder noLevelsEquivalentStatsHolder = getNodeCacheStatsResult(
        );
    private static ImmutableCacheStatsHolder getNodeCacheStatsResult(Client client, List<String> aggregationLevels) throws IOException {
        );
    public void testIndicesLevelAggregation() throws Exception {  
        // get total stats
import java.util.concurrent.TimeUnit;
            index1DiskCacheExpectedStats,
        int itemsOnHeapIndex1AfterTest = randomInt(itemsOnHeapAfterTest);
        // Now try to hit queries same as number of segments. All these should be able to reside inside onHeap cache.
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.action.search.SearchResponse;  
     */
        // Put some values on heap and disk for each index  
        int itemsOnDisk = 1 + randomInt(30); // The first one we search (to get the size) always goes to disk  
                values.get("itemsOnDiskIndex2AfterTest") + values.get("itemsOnHeapIndex2AfterTest")
        startNodesDefaultSettings();
        );  
        }
    private Map<String, Integer> setupCacheForAggregationTests(Client client) throws Exception {
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_ON_HEAP))  
