    }
        ImmutableCacheStats index2ExpectedStats = returnNullIfAllZero(
import java.util.Collection;
        int hitsOnDiskIndex1 = randomInt(itemsOnDiskIndex1AfterTest);
        );
        StringBuilder sb = new StringBuilder();
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        ImmutableCacheStatsHolder noLevelsEquivalentStatsHolder = getNodeCacheStatsResult(
        startIndex(client, index);
        ImmutableCacheStats diskCacheStat = allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_DISK));
        // Check the new stats API values are as expected
        return expectedValues;
        return expectedStats;
        ImmutableCacheStats onHeapCacheStat = allLevelsStatsHolder.getStatsForDimensionValues(
import org.opensearch.common.cache.CacheType;
        startIndex(client, index1Name);
}
        // This should be equivalent to just "indices"
        int hitsOnHeapIndex1 = randomInt(itemsOnHeapIndex1AfterTest);
                    "hitsOnDiskIndex2"
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .get()
        searchIndex(client, index1Name, 0);
                values.get("itemsOnDiskAfterTest") * values.get("singleSearchSize"),
            searchIndex(client, index2Name, i);
            .get();
        }
        int itemsOnHeapIndex2AfterTest = itemsOnHeapAfterTest - itemsOnHeapIndex1AfterTest;
            Settings.builder()
        // get total stats
import org.opensearch.common.unit.TimeValue;
    }
    public void testClosingShard() throws Exception {
        expectedValues.put("itemsOnHeapAfterTest", itemsOnHeapAfterTest); // Can only pass 10 keys in Map.of() constructor
    /**
 */
 * The OpenSearch Contributors require contributions made to
        statsFlags.includeAllCacheTypes();
        String input = String.valueOf(inputValue);
        );
        int expectedHits = randomIntBetween(itemsOnHeap, expectedEntries); // Select it so some hits come from both tiers
                )
        ImmutableCacheStatsHolder allLevelsStatsHolder = getNodeCacheStatsResult(
        startNodesDefaultSettings();
            .cluster()
        ImmutableCacheStatsHolder allLevelsStatsHolder = getNodeCacheStatsResult(
            .setRequestCache(true)
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_DISK))
        Map<String, Integer> values = setupCacheForAggregationTests(client);
            .indices()
        }
        );
    @Override
        assertEquals(totalHeapExpectedStats, heapStats);
            .setIndices(statsFlags)
        // Avoid forbidden API String.format()
        // Put some values on heap and disk for each index
    private void startNodesDefaultSettings() {
                values.get("itemsOnDiskIndex2AfterTest") + values.get("itemsOnHeapIndex2AfterTest"),
import java.util.List;
        // The first one we search (to get the size) always goes to disk
            searchIndex(client, index, i);
        int itemsOnDisk = 1 + randomInt(30); // The first one we search (to get the size) always goes to disk
        // Now try to hit queries same as number of segments. All these should be able to reside inside onHeap cache.
            + hitsOnHeapIndex2; i++) {
                    Settings.builder()
            Settings.builder()
                values.get("itemsOnDiskIndex1AfterTest") + values.get("itemsOnHeapIndex1AfterTest")
        expectedValues.put("hitsOnDiskIndex1", hitsOnDiskIndex1);
        }
        );
        );
        while (sb.length() < finalLength - input.length()) {
        int numberOfSegments = randomFrom(2, 4, 8, 16, 64);
            searchIndex(client, index1Name, i);
        // The remaining items stay on heap
        startNodesDefaultSettings();
            return input;
    }
    private static final String index2Name = "index2";
                values.get("hitsOnDiskIndex2"),
    }
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_DISK))
        );
    }
                values.get("itemsOnHeapIndex2AfterTest") + values.get("itemsOnDiskIndex2AfterTest") + values.get("hitsOnDiskIndex2"),
                values.get("hitsOnHeapIndex1") + values.get("hitsOnDiskIndex1"),
        }
        Map<String, Integer> values = setupCacheForAggregationTests(client);
            1,
        for (ImmutableCacheStatsHolder statsHolder : List.of(allLevelsStatsHolder, indicesOnlyStatsHolder)) {
        int itemsOnHeapAfterTest = HEAP_CACHE_SIZE / (int) singleSearchSize; // As the heap tier evicts, the items on it after the test will
        int expectedMisses = itemsOnHeap + itemsOnDisk;
            new ImmutableCacheStats(numberOfSegments, numberOfSegments, 0, singleSearchSize * numberOfSegments, numberOfSegments)
            client,
                    TimeValue.ZERO
        }
                values.get("hitsOnHeapIndex1"),
        // statsHolder.getStatsForDimensionValues().
import org.opensearch.common.settings.Settings;
            client,
            searchIndex(client, index1Name, i);
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
                .build()
        );
        ImmutableCacheStatsHolder allLevelsStatsHolder = getNodeCacheStatsResult(
import org.opensearch.action.search.SearchResponse;
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME)
        int itemsOnHeap = HEAP_CACHE_SIZE / (int) singleSearchSize;
        expectedValues.put("hitsOnHeapIndex2", hitsOnHeapIndex2);
        }
            new ImmutableCacheStats(
        for (int i = 0; i < expectedHits; i++) {
                values.get("itemsOnHeapAfterTest") + values.get("itemsOnDiskAfterTest") + values.get("hitsOnDiskIndex1") + values.get(
        for (int i = itemsOnDiskAfterTest; i < itemsOnDiskAfterTest + hitsOnHeapIndex1; i++) {
                values.get("itemsOnHeapAfterTest")
    }
    }
import java.util.Map;
        for (int i = 1; i < numberOfSegments; i++) {
 *
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME)
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        // First search one time to see how big a single value will be
     */
import org.opensearch.plugins.Plugin;
        ImmutableCacheStatsHolder allLevelsStatsHolder = getNodeCacheStatsResult(
    }
import org.opensearch.common.cache.service.NodeCacheStats;
// Use a single data node to simplify accessing cache stats across different shards.
            new ImmutableCacheStats(
        int itemsOnDiskIndex1AfterTest = 1 + randomInt(itemsOnDiskAfterTest - 1);
            // heap hits for index 1
    }
            assertEquals(index2ExpectedStats, statsHolder.getStatsForDimensionValues(List.of(index2Name)));
        long singleSearchSize = getTotalStats(client).getSizeInBytes();
        );
        // Check the new stats API values are as expected
        assertEquals(
                values.get("itemsOnDiskIndex1AfterTest") * values.get("singleSearchSize"),
        for (int i = itemsOnDiskAfterTest; i < itemsOnDiskAfterTest + itemsOnHeapIndex1AfterTest; i++) {
                        .getKey(),
        startNodesDefaultSettings();
                .put(
        }
        Client client = client();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        );
    public void testStatsWithMultipleSegments() throws Exception {
 * compatible open source license.
            new ImmutableCacheStats(expectedHits, expectedMisses, 0, expectedEntries * singleSearchSize, expectedEntries),
        Client client = client();
        // this index.
                    TimeValue.ZERO
        int itemsOnHeapIndex1AfterTest = randomInt(itemsOnHeapAfterTest);
        assertEquals(noLevelsStatsHolder, noLevelsEquivalentStatsHolder);
            searchIndex(client, index2Name, i);
            )
                    new TimeValue(0, TimeUnit.SECONDS)
        internalCluster().startNodes(
        );
                0,
            new ImmutableCacheStats(
        searchIndex(client, index, 0);
        );
        String index = "index";
            .getTotal()
                .setMapping("k", "type=keyword")
        // Get some hits on all combinations of indices and tiers
    }
            totalStats
                .build()
                        .getKey(),
            client,
            flagsLevels = aggregationLevels.toArray(new String[0]);
        Map<String, Integer> values = setupCacheForAggregationTests(client);
        for (int i = itemsOnDiskAfterTest + itemsOnHeapIndex1AfterTest; i < itemsOnDiskAfterTest + itemsOnHeapAfterTest; i++) {
                        // Disable index refreshing to avoid cache being invalidated mid-test
        return resp;
        );
        assertEquals(oldAPIStats.getMissCount(), totalStats.getMisses());
        );
import java.io.IOException;
        ImmutableCacheStatsHolder indicesEquivalentStatsHolder = getNodeCacheStatsResult(
        // the indices dimension
        for (int i = numberOfSegments; i < numberOfSegments + numberOfSegments * numberOfSegments; i++) {
            sb.append('0');
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_ON_HEAP))
        return Arrays.asList(TieredSpilloverCachePlugin.class, TieredSpilloverCacheIT.MockDiskCachePlugin.class);
        );
                )
        // be the same as its max capacity
        assertEquals(
        ImmutableCacheStats index1DiskExpectedStats = returnNullIfAllZero(
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_ON_HEAP))
        allLevelsStatsHolder = getNodeCacheStatsResult(client, List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME));
        } else {
                values.get("itemsOnHeapAfterTest") * values.get("singleSearchSize"),
        );
    private static final int HEAP_CACHE_SIZE = 10_000;
        // Closing the index should close the shard
        );
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        NodeCacheStats ncs = nodeStatsResponse.getNodes().get(0).getNodeCacheStats();
 * this file be licensed under the Apache-2.0 license or a
                values.get("itemsOnHeapIndex1AfterTest")
                values.get("itemsOnHeapIndex2AfterTest")
        // get total stats
        }
                (values.get("itemsOnDiskIndex2AfterTest") + values.get("itemsOnHeapIndex2AfterTest")) * values.get("singleSearchSize"),
            1,
                values.get("itemsOnHeapAfterTest") + values.get("itemsOnDiskAfterTest"),
            searchIndex(client, index, i);
        ImmutableCacheStatsHolder tiersOnlyStatsHolder = getNodeCacheStatsResult(client, List.of(TIER_DIMENSION_NAME));
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest("index")).get());
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, "unrecognized_dimension")
            // disk hits for index 1
                values.get("hitsOnHeapIndex1") + values.get("hitsOnHeapIndex2"),
            .prepareStats(index)
        int hitsOnDiskIndex2 = randomInt(itemsOnDiskIndex2AfterTest);
        // This should be equivalent to "indices", "tier"
                values.get("hitsOnDiskIndex1") + values.get("hitsOnDiskIndex2"),
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge(indexName).setFlush(true).get();
        assertTrue(diskCacheStat.getHits() == 0);
        // If the randomly chosen numbers are such that the expected stats would be 0, we actually have not interacted with the cache for
        );
        ImmutableCacheStats totalStats = getNodeCacheStatsResult(client, List.of()).getTotalStats();
        OpenSearchAssertions.assertAllSuccessful(resp);
     */
    public void testIndicesAndTierLevelAggregation() throws Exception {
        allLevelsStatsHolder = getNodeCacheStatsResult(client, List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME));
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
        SearchResponse resp = client.prepareSearch(index)
        // keys land up in same segment, it would still be able to accommodate.
import java.util.Arrays;
import java.util.HashMap;
        index1OnHeapExpectedStats = returnNullIfAllZero(
        // get total stats
/*
    private static final String index1Name = "index1";
        // Test invalid levels are ignored and permuting the order of levels in the request doesn't matter
                values.get("itemsOnHeapIndex1AfterTest") + values.get("itemsOnDiskIndex1AfterTest") + values.get("hitsOnDiskIndex1"),
            client,
    /**
            index1DiskCacheExpectedStats,
    private SearchResponse searchIndex(Client client, String index, int searchSuffix) {
        for (int i = 0; i < hitsOnDiskIndex1; i++) {
        assertEquals(totalDiskExpectedStats, diskStats);
                )
        ImmutableCacheStats index1HeapExpectedStats = returnNullIfAllZero(
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME)
        // Now check the new stats API values for the cache as a whole match the old stats API values
        assertEquals(
                    TimeValue.ZERO
            index1OnHeapExpectedStats,
            List.of(TIER_DIMENSION_NAME, "unrecognized_dimension_1", IndicesRequestCache.INDEX_DIMENSION_NAME, "unrecognized_dimension_2")
        }
        int hitsOnHeapIndex2 = randomInt(itemsOnHeapIndex2AfterTest);
                values.get("itemsOnDiskIndex2AfterTest"),
        assertEquals(1, nodeStatsResponse.getNodes().size());
                0,
        RequestCacheStats oldAPIStats = client.admin()
        expectedValues.put("itemsOnDiskAfterTest", itemsOnDiskAfterTest);
        ImmutableCacheStats totalHeapExpectedStats = returnNullIfAllZero(
     */
        ImmutableCacheStats diskStats = tiersOnlyStatsHolder.getStatsForDimensionValues(List.of(TIER_DIMENSION_VALUE_DISK));
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index2Name, TIER_DIMENSION_VALUE_ON_HEAP))
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        // Select numbers so we get some values on both heap and disk
        // Jut verifying evictions happened as can't fetch the exact number considering we don't have a way to get
     * Test aggregating by tier only
            searchIndex(client, index1Name, i);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private ImmutableCacheStats returnNullIfAllZero(ImmutableCacheStats expectedStats) {
                .put(defaultSettings(HEAP_CACHE_SIZE_STRING, 1))
        );
        expectedValues.put("itemsOnHeapIndex1AfterTest", itemsOnHeapIndex1AfterTest);
        // Select numbers so we get some values on both heap and disk
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
    /**
            // disk hits for index 2
        }
                values.get("itemsOnDiskIndex2AfterTest") + values.get("itemsOnHeapIndex2AfterTest")
import org.opensearch.index.query.QueryBuilders;
        int expectedMisses = itemsOnHeap + itemsOnDisk;
            List.of(index1Name, TIER_DIMENSION_VALUE_ON_HEAP)
        // In this case, we expect the stats holder to have no stats for this node, and therefore we should get null from
                .setSettings(
                .indices()
                )
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME)
    }
        // Closing the shard should totally remove the stats associated with that shard.
                .put(defaultSettings(HEAP_CACHE_SIZE_STRING, getNumberOfSegments()))
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_NAME;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    private String padWithZeros(int finalLength, int inputValue) {
            // Cause misses
            new ImmutableCacheStats(
        return statsHolder.getStatsForDimensionValues(List.of());
        assertTrue(diskCacheStat.getEvictions() == 0);
        sb.append(input);
    private static final String HEAP_CACHE_SIZE_STRING = "10000B";
    // Duplicated from CacheStatsAPIIndicesRequestCacheIT.java, as we can't add a dependency on server.internalClusterTest
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    public void testStatsMatchOldApi() throws Exception {
            searchIndex(client, index1Name, i);
            // pad with zeros so request 0 and request 10 have the same size ("0000" and "0010" instead of "0" and "10")
            index1OnHeapExpectedStats,
        }
    private static ImmutableCacheStatsHolder getNodeCacheStatsResult(Client client, List<String> aggregationLevels) throws IOException {
        if (aggregationLevels == null) {
                .put(
        expectedValues.put("hitsOnHeapIndex1", hitsOnHeapIndex1);
        );
                .put(defaultSettings(heap_cache_size_per_segment * numberOfSegments + "B", numberOfSegments))
            .getRequestCache();
    private void startIndex(Client client, String indexName) throws InterruptedException {
        }
        expectedValues.put("itemsOnDiskIndex1AfterTest", itemsOnDiskIndex1AfterTest);
        searchIndex(client, index1Name, 0);
        searchIndex(client, index, 0);
        assertTrue(diskCacheStat.getSizeInBytes() > 0);
        // Cause some hits
                .prepareCreate(indexName)
            new ImmutableCacheStats(expectedHits, expectedMisses, 0, expectedEntries * singleSearchSize, expectedEntries),
        for (int i = itemsOnDiskAfterTest + itemsOnHeapIndex1AfterTest; i < itemsOnDiskAfterTest + itemsOnHeapIndex1AfterTest
        int itemsOnHeap = HEAP_CACHE_SIZE / (int) singleSearchSize;
        );
            index2HeapExpectedStats,
     * Test aggregating by indices and tier
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            .get()
        }
        int itemsOnDisk = 1 + randomInt(30); // The first one we search (to get the size) always goes to disk
            client,
            1,
                values.get("itemsOnDiskIndex1AfterTest"),
        // Put these values into a map so tests can know what to expect in stats responses
import org.opensearch.cluster.metadata.IndexMetadata;
        for (int i = 1; i < expectedEntries; i++) {
        expectedValues.put("itemsOnDiskIndex2AfterTest", itemsOnDiskIndex2AfterTest);
            return null;
        long singleSearchSize = getTotalStats(client).getSizeInBytes();
        // Can always get the first data node as there's only one in this test suite
    }
                        .getKey(),
            index1DiskExpectedStats,
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME)
            // heap hits for index 2
        ImmutableCacheStats index2DiskExpectedStats = returnNullIfAllZero(
                values.get("itemsOnDiskIndex2AfterTest") * values.get("singleSearchSize"),
                values.get("itemsOnHeapIndex2AfterTest") * values.get("singleSearchSize"),
        // Get values for indices alone, assert these match for statsHolders that have additional dimensions vs. a statsHolder that only has
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
    }
        // Similarly verify items are present on disk cache now
            index2DiskExpectedStats,
                .put(
        );
            .setQuery(QueryBuilders.termQuery("k", "hello" + padWithZeros(4, searchSuffix)))
        );
    public void testIndicesLevelAggregation() throws Exception {
        ImmutableCacheStats heapStats = tiersOnlyStatsHolder.getStatsForDimensionValues(List.of(TIER_DIMENSION_VALUE_ON_HEAP));
            new ImmutableCacheStats(
        // We will not see it in the XContent response.
package org.opensearch.cache.common.tier;
    private ImmutableCacheStats getTotalStats(Client client) throws IOException {
    /**
        startNodesDefaultSettings();
            client,
        // This should be equivalent to no levels passed in
            Settings.builder()
                values.get("itemsOnHeapIndex1AfterTest") * values.get("singleSearchSize"),
        // First search one time to see how big a single value will be
        if (expectedStats.equals(new ImmutableCacheStats(0, 0, 0, 0, 0))) {
        );
    }
        // Get values broken down by indices+tiers
            flagsLevels = null;
                .put(
    private Map<String, Integer> setupCacheForAggregationTests(Client client) throws Exception {
            .addMetric(NodesStatsRequest.Metric.CACHE_STATS.metricName())
        assertEquals(
        assertEquals(indicesOnlyStatsHolder, indicesEquivalentStatsHolder);
                .put(
        ImmutableCacheStatsHolder indicesAndTierEquivalentStatsHolder = getNodeCacheStatsResult(
                values.get("itemsOnDiskIndex1AfterTest")
            )
        int itemsOnDiskIndex2AfterTest = itemsOnDiskAfterTest - itemsOnDiskIndex1AfterTest;
                values.get("itemsOnDiskIndex1AfterTest") + values.get("itemsOnHeapIndex1AfterTest"),
        internalCluster().startNodes(
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_ON_HEAP;
        int singleSearchSizeApproxUpperBound = 700; // We know this from other tests and manually verifying
            new ImmutableCacheStats(
        ImmutableCacheStatsHolder indicesOnlyStatsHolder = getNodeCacheStatsResult(
                0,
import java.util.concurrent.TimeUnit;
        Map<String, Integer> values = setupCacheForAggregationTests(client);
            new ImmutableCacheStats(
                    TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        );
        // get total stats
        );
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index1Name, TIER_DIMENSION_VALUE_ON_HEAP))
        int expectedEntries = itemsOnHeap + itemsOnDisk;
        startNodesDefaultSettings();
        assertEquals(oldAPIStats.getEvictions(), totalStats.getEvictions());
        int expectedHits = randomIntBetween(itemsOnHeap, expectedEntries); // Select it so some hits come from both tiers
import org.opensearch.indices.IndicesRequestCache;
        Map<String, Integer> expectedValues = new HashMap<>();
        assertEquals(oldAPIStats.getMemorySizeInBytes(), totalStats.getSizeInBytes());
        return ncs.getStatsByCache(CacheType.INDICES_REQUEST_CACHE);
            client,
        );
            getTotalStats(client)
            searchIndex(client, index1Name, i);
import org.opensearch.index.IndexSettings;
                0,
        Client client = client();
                .build()
        ImmutableCacheStats index1ExpectedStats = returnNullIfAllZero(
import org.opensearch.transport.client.Client;
        assertEquals(allLevelsStatsHolder, indicesAndTierEquivalentStatsHolder);
            )
        Client client = client();
        }
            )
        for (int i = 1; i < expectedEntries; i++) {
        expectedValues.put("itemsOnHeapIndex2AfterTest", itemsOnHeapIndex2AfterTest);
        CommonStatsFlags statsFlags = new CommonStatsFlags();
                values.get("itemsOnDiskAfterTest"),
        statsFlags.setLevels(flagsLevels);
            )
        assertAcked(
    public void testTierLevelAggregation() throws Exception {
            List.of(IndicesRequestCache.INDEX_DIMENSION_NAME, TIER_DIMENSION_NAME)
        );
                )
        ImmutableCacheStats totalDiskExpectedStats = returnNullIfAllZero(
        int expectedEntries = itemsOnHeap + itemsOnDisk;
            client,
            new ImmutableCacheStats(0, numberOfSegments, 0, singleSearchSize * numberOfSegments, numberOfSegments)
        for (int i = itemsOnDiskIndex1AfterTest; i < itemsOnDiskIndex1AfterTest + hitsOnDiskIndex2; i++) {
        );
        assertTrue(onHeapCacheStat.getEvictions() > 0);
    }
        String index = "index";
        ImmutableCacheStatsHolder indicesOnlyStatsHolder = getNodeCacheStatsResult(
        );
        // Now try to evict from onheap cache by adding numberOfSegments ^ 2 which will guarantee this.
        Client client = client();
        ImmutableCacheStatsHolder statsHolder = getNodeCacheStatsResult(client, List.of());
        }
            searchIndex(client, index1Name, i);
                values.get("hitsOnHeapIndex2"),
                .put(
                values.get("hitsOnHeapIndex2") + values.get("hitsOnDiskIndex2"),
                    TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
            searchIndex(client, index1Name, i);
                (values.get("itemsOnDiskIndex1AfterTest") + values.get("itemsOnHeapIndex1AfterTest")) * values.get("singleSearchSize"),
        );
        // Get values for tiers alone and check they add correctly across indices
                values.get("itemsOnDiskAfterTest")
                values.get("hitsOnDiskIndex1"),
        }
        for (int i = 0; i < expectedHits; i++) {
        // Cause some hits
            .setRequestCache(true)
public class TieredSpilloverCacheStatsIT extends TieredSpilloverCacheBaseIT {
                values.get("itemsOnDiskIndex2AfterTest")
        // First search one time to see how big a single value will be
        assertEquals(
            searchIndex(client, index2Name, i);
        assertBusy(() -> assertEquals(new ImmutableCacheStats(0, 0, 0, 0, 0), getTotalStats(client)));
                    new TimeValue(0, TimeUnit.SECONDS)
                0,
        // First search one time to calculate item size
        ensureSearchable(indexName);
import static org.opensearch.cache.common.tier.TieredSpilloverCacheStatsHolder.TIER_DIMENSION_VALUE_DISK;
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
            searchIndex(client, index, i);
import org.opensearch.test.OpenSearchIntegTestCase;
        int itemsOnDiskAfterTest = 1 + randomInt(30); // The first one we search (to get the size) always goes to disk
                    TimeValue.ZERO
 * SPDX-License-Identifier: Apache-2.0
            allLevelsStatsHolder.getStatsForDimensionValues(List.of(index2Name, TIER_DIMENSION_VALUE_DISK))
        startIndex(client, index2Name);
        ImmutableCacheStats index2HeapExpectedStats = returnNullIfAllZero(
        if (input.length() >= finalLength) {
        for (int i = 0; i < numberOfSegments; i++) {
import org.opensearch.common.cache.stats.ImmutableCacheStats;
            .prepareNodesStats("data:true")
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
            new ImmutableCacheStats(
            index1HeapExpectedStats,
        assertSearchResponse(resp);
        }
import static org.opensearch.indices.IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING;
    public void testInvalidLevelsAreIgnored() throws Exception {
        );
        }
        // The earliest items (0 - itemsOnDiskAfterTest) are the ones which get evicted to disk
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
        String[] flagsLevels;
        Client client = client();
            searchIndex(client, index2Name, i);
     * Test aggregating by indices
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        assertEquals(onHeapCacheStat.getEvictions(), diskCacheStat.getItems());
                    TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
        assertEquals(
        expectedValues.put("singleSearchSize", (int) singleSearchSize);
        ImmutableCacheStats index1OnHeapExpectedStats = returnNullIfAllZero(
        startIndex(client, index1Name);
        long singleSearchSize = getTotalStats(client).getSizeInBytes();
                )
        }
            assertEquals(index1ExpectedStats, statsHolder.getStatsForDimensionValues(List.of(index1Name)));
        }
        return sb.toString();
                ),
        // segment number for queries.
        expectedValues.put("hitsOnDiskIndex2", hitsOnDiskIndex2);
        for (int i = 1; i < itemsOnDiskIndex1AfterTest; i++) { // Start at 1 as 0 has already been searched
            // Cause misses
     * Check the new stats API returns the same values as the old stats API.
            )
        ImmutableCacheStatsHolder noLevelsStatsHolder = getNodeCacheStatsResult(client, List.of());
        startIndex(client, index);
        assertEquals(oldAPIStats.getHitCount(), totalStats.getHits());
        indexRandom(true, client.prepareIndex(indexName).setSource("k", "hello"));
     */
            )
            .get();
        for (int i = itemsOnDiskIndex1AfterTest; i < itemsOnDiskIndex1AfterTest + itemsOnDiskIndex2AfterTest; i++) {
        assertEquals(
                values.get("itemsOnHeapIndex1AfterTest") + values.get("itemsOnDiskIndex1AfterTest"),
        long singleSearchSize = getTotalStats(client).getSizeInBytes();
        NodesStatsResponse nodeStatsResponse = client.admin()
        internalCluster().startNodes(
                        .build()
            client.admin()
        assertEquals(
        assertTrue(diskCacheStat.getMisses() > 0);
        ImmutableCacheStats index1DiskCacheExpectedStats = returnNullIfAllZero(new ImmutableCacheStats(0, numberOfSegments, 0, 0, 0));
                )
        int heap_cache_size_per_segment = singleSearchSizeApproxUpperBound * numberOfSegments; // Worst case if all
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
        assertEquals(
import org.opensearch.index.cache.request.RequestCacheStats;
        Client client = client();
            List.of("unrecognized_dimension_1", "unrecognized_dimension_2")
            )
        );
            client,
        // Now fire same queries to get some hits
                values.get("itemsOnHeapIndex2AfterTest") + values.get("itemsOnDiskIndex2AfterTest"),
        );
            searchIndex(client, index, i);
    }
