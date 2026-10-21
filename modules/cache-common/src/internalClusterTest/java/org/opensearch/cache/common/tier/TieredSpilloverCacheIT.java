                .get();
            SearchResponse resp = client.prepareSearch("index")
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
            String.format(
                )
        long lastKnownHitCount = requestCacheStats.getHitCount();
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
                .build()
/*
                .setMapping("k", "type=keyword")
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
            Settings.builder()
        long perQuerySizeInCacheInBytes = -1;
                .get();
        );
        refreshAndWaitForReplication();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
                .prepareCreate("index")
                .prepareCreate("index")
                .get();
import java.util.List;
            Settings.builder()
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        // Step 2: Again hit same set of queries as above, we still won't see any hits as items keeps getting evicted.
        );
            assertSearchResponse(resp);
                .put(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
            Settings.builder()
import org.opensearch.common.settings.Settings;
            .setSize(0)
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
            Settings.builder()
        int numberOfSegments = getNumberOfSegments();
                .get();
                    new TimeValue(100, TimeUnit.SECONDS)
        assertEquals(numberOfIndexedItems * 3 - entriesInCache, requestCacheStats.getMissCount());
import org.opensearch.action.search.SearchResponse;
            SearchResponse resp = client.prepareSearch("index")
        long entriesInCache = requestCacheStats.getMemorySizeInBytes() / perQuerySizeInCacheInBytes;
                        .put("index.refresh_interval", -1)
                .get();
        long perQuerySizeInCacheInBytes = -1;
            }
            Settings.builder()
        }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
    public void testPluginsAreInstalled() {
                .setRequestCache(true)
    }
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
                .get()
                .setMapping("k", "type=keyword")
                        .getKey(),
                .build()
            }
                .build()
            assertSearchResponse(resp);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
        long perQuerySizeInCacheInBytes = -1;
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
    }
                .setSettings(
        ClearIndicesCacheRequest request = new ClearIndicesCacheRequest("index");
    }
                    Settings.builder()
        // Step 3: Turn off disk cache now. And hit same queries again. We should not see hits now as all queries
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                .put(
            return Map.of(MockDiskCache.MockDiskCacheFactory.NAME, new MockDiskCache.MockDiskCacheFactory(0, 10000, false, 1));
        ensureSearchable("index");
    public static class MockDiskCachePlugin extends Plugin implements CachePlugin {
        assertEquals(lastHitCountSeen + numberOfIndexedItems, requestCacheStats.getHitCount());
                .prepareCreate("index")
            if (perQuerySizeInCacheInBytes == -1) {
                .setSettings(
                .build()
                        .getKey(),
        // segment, atleast one of the segment will have 2 entries and we will see evictions.
            assertSearchResponse(resp);
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
        internalCluster().startNodes(3, Settings.builder().put(defaultSettings("1%", numberOfSegments)).build());
    }
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
        );
        updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
            assertSearchResponse(resp);
        }
            }
 * SPDX-License-Identifier: Apache-2.0
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // to disk. And then hit requests so that few items are cached into cache.
        }
            client.admin()
                        .put("index.refresh_interval", -1)
                        .put("index.refresh_interval", -1)
        internalCluster().startNode(Settings.builder().put(defaultSettings("1%", getNumberOfSegments())).build());
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
        int onHeapCacheSizePerSegmentInBytes = 800; // Per cache entry below is around ~700 bytes, so keeping this
        // Considering disk cache won't be used due to took time policy having a high value, we expect overall cache
        // All should be misses in the first attempt
            greaterThan(0L)
                    new TimeValue(0, TimeUnit.MILLISECONDS)
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
            client.admin()
            if (perQuerySizeInCacheInBytes == -1) {
                .setRequestCache(true)
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        int numberOfIndexedItems = randomIntBetween(5, 10);
        ensureSearchable("index");
                .build()
        int numberOfSegments = getNumberOfSegments();
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        }
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        int onHeapCacheSizeInBytes = randomIntBetween(numberOfSegments + 1, numberOfSegments * 2); // Keep it low so
        // Update disk took time policy to zero so that all entries are eligible to be cached on disk.
                    new TimeValue(0, TimeUnit.MILLISECONDS)
 */
                .get();
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        refreshAndWaitForReplication();
            if (perQuerySizeInCacheInBytes == -1) {
            Settings.builder()
        return client.admin().indices().prepareStats(indexName).setRequestCache(true).get().getTotal().getRequestCache();
                Locale.ROOT,
        assertTrue(requestCacheStats.getMemorySizeInBytes() <= onHeapCacheSizeInBytes);
        Client client = client();
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
        requestCacheStats = client.admin().indices().prepareStats("index").setRequestCache(true).get().getTotal().getRequestCache();
                .setSettings(
        Assert.assertTrue(
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
import java.util.Locale;
        // Decrease disk took time policy to zero so that disk cache also comes into play. Now we should be able
        assertEquals(0, requestCacheStats.getEvictions());
 *
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
            client.admin().indices().prepareStats("index").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
        // to cache all entries.
        // were cached onto disk cache.
            IllegalArgumentException.class,
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
        assertTrue(requestCacheStats.getMemorySizeInBytes() <= onHeapCacheSizeInBytes);
                .put(TieredSpilloverCacheSettings.DISK_CACHE_ENABLED_SETTING_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), false)
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
        assertEquals(0, requestCacheStats.getHitCount());
                        .put("index.refresh_interval", -1)
            .get();
        ensureSearchable("index");
        assertSearchResponse(r1);
        int numberOfIndexedItems = randomIntBetween(5, 10);
        assertEquals(0, requestCacheStats.getHitCount());
        // All entries should get cached.
    }
            )
                .setRequestCache(true)
        assertBusy(() -> {
        internalCluster().startNode(Settings.builder().put(defaultSettings(onHeapCacheSizeInBytes + "b", 1)).build());
        }
        // This is not a random example: serialization with time zones writes shared strings
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.function.Function;
        assertTrue(requestCacheStats.getMemorySizeInBytes() <= onHeapCacheSizeInBytes);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .build()
}
    public void testWithDynamicHeapTookTimePolicy() throws Exception {
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
            client.admin()
            assertSearchResponse(resp);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        int numberOfSegments = getNumberOfSegments();
import org.opensearch.common.cache.CacheType;
        assertEquals(lastEvictionSeen, requestCacheStats.getEvictions());
        // Set a high threshold for the overall cache took time policy so nothing will enter the cache.
        }
        assertEquals(numberOfIndexedItems * 2 - entriesInCache, requestCacheStats.getEvictions());
        int numberOfIndexedItems = numberOfSegments + 1; // Best case if all keys are distributed among different
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());
                .put(
        // No more evictions seen when compared with last step.
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
        assertEquals(0, requestCacheStats.getHitCount());
        assertEquals(numberOfIndexedItems * perQuerySizeInCacheInBytes, requestCacheStats.getMemorySizeInBytes());
            client.prepareIndex("index").setSource("f", "2014-03-10T00:00:00.000Z"),
        // The cached is actually used
                .indices()
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
        }, 1, TimeUnit.SECONDS);
        }, 1, TimeUnit.SECONDS);
        assertEquals(0, requestCacheStats.getHitCount());
        }, 1, TimeUnit.SECONDS);
        int numberOfIndexedItems = randomIntBetween(6, 10);
        int numberOfSegments = getNumberOfSegments();
                .anyMatch(pluginInfo -> pluginInfo.getName().equals("org.opensearch.cache.common.tier.TieredSpilloverCachePlugin"))
        assertEquals(0, requestCacheStats.getHitCount());
        // We shouldn't see any new evictions now.
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
                .get();
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
                .put(defaultSettings(onHeapCacheSizeInBytes + "b", numberOfSegments))
        updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
import org.opensearch.index.cache.request.RequestCacheStats;
        long perQuerySizeInCacheInBytes = -1;
            }
                )
                .setRequestCache(true)
                .get()
        List<PluginInfo> pluginInfos = nodesInfoResponse.getNodes()
        );
        // Hit count should be equal to number of cache entries present in previous step.
        ensureSearchable("index");
import java.util.Arrays;
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
        assertEquals(0, requestCacheStats.getEvictions() - lastEvictionSeen);
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
        // to cache all entries.
                .setRequestCache(true)
import java.util.stream.Collectors;
        assertEquals(0, lastKnownHitCount - requestCacheStats.getHitCount()); // No new hits being seen.
                )
        // Explicit clear the cache.
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .get()
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
            client.admin()
        updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
                    new TimeValue(0, TimeUnit.MILLISECONDS)
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
                .get();
        assertAcked(
        long perQuerySizeInCacheInBytes = -1;
        );
        );
                .build()
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                .get();
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
                dateHistogram("histo").field("f").timeZone(ZoneId.of("+01:00")).minDocCount(0).calendarInterval(DateHistogramInterval.MONTH)
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
            assertSearchResponse(resp);
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
                INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE,
            assertSearchResponse(resp);
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
        assertNoFailures(response);
                .indices()
        long lastEvictionSeen = requestCacheStats.getEvictions();
            Settings.builder()
        assertEquals(0, requestCacheStats.getEvictions());
            () -> internalCluster().startNode(
    public void testWithDynamicDiskTookTimePolicyWithMultiSegments() throws Exception {
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
            // Explicit refresh should clear up cache entries
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
        // We should atleast one eviction considering disk cache isn't able to hold anything due to policy.
        requestCacheStats = getRequestCacheStats(client, "index");
                    Settings.builder()
        assertEquals(0, requestCacheStats.getEvictions());
        assertAcked(
        }
        assertEquals(numberOfIndexedItems * perQuerySizeInCacheInBytes, requestCacheStats.getMemorySizeInBytes());
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
            client.admin()
            Settings.builder()
            true,
                )
                    Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
        requestCacheStats = getRequestCacheStats(client, "index");
        requestCacheStats = getRequestCacheStats(client, "index");
        // Still shows disk cache entries as explicit clear or invalidation is required to clean up disk cache.
        );
                .setRequestCache(true)
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        internalCluster().startNode(Settings.builder().put(defaultSettings(onHeapCacheSizeInBytes + "b", 1)).build());
            Settings.builder()
        assertBusy(() -> {
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
package org.opensearch.cache.common.tier;
                )
                        .put("index.refresh_interval", -1)
                .indices()
                        .getKey(),
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        int onHeapCacheSizeInBytes = onHeapCacheSizePerSegmentInBytes * numberOfSegments;
        internalCluster().startNode(
        public String getName() {
            client.admin()
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
        );
                (Function<NodeInfo, Stream<PluginInfo>>) nodeInfo -> nodeInfo.getInfo(PluginsAndModules.class).getPluginInfos().stream()
 * compatible open source license.
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        // Hits and misses stats shouldn't get cleared up.
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
            client.admin()
        indexRandom(
            .flatMap(
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
            assertSearchResponse(resp);
                .get()
        assertEquals(0, requestCacheStats.getEvictions() - lastEvictionSeen);
        assertAcked(
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
                )
        assertEquals(numberOfIndexedItems * perQuerySizeInCacheInBytes, requestCacheStats.getMemorySizeInBytes());
        refreshAndWaitForReplication();
        }
        lastKnownHitCount = requestCacheStats.getHitCount();
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        // see #9500
            Settings.builder()
        requestCacheStats = client.admin().indices().prepareStats("index").setRequestCache(true).get().getTotal().getRequestCache();
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
                    Settings.builder()
        }
                    new TimeValue(0, TimeUnit.MILLISECONDS)
        );
        internalCluster().startNode(Settings.builder().put(defaultSettings(onHeapCacheSizeInBytes + "b", numberOfSegments)).build());
            assertSearchResponse(resp);
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        requestCacheStats = getRequestCacheStats(client, "index");
        lastKnownMissCount = requestCacheStats.getMissCount();
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        assertEquals(lastKnownMissCount + numberOfIndexedItems, requestCacheStats.getMissCount());
        assertAcked(
                )
            if (perQuerySizeInCacheInBytes == -1) {
                )
                )
                )
        );
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
        public Map<String, ICache.Factory> getCacheFactoryMap() {
            SearchResponse resp = client.prepareSearch("index")
                .build()
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
        // cached onto disk.
        assertEquals(numberOfIndexedItems * perQuerySizeInCacheInBytes, requestCacheStats.getMemorySizeInBytes()); //
        // requests.
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                .setQuery(QueryBuilders.termQuery(UUID.randomUUID().toString(), UUID.randomUUID().toString()))
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
import org.opensearch.action.search.SearchType;
        // Explicit refresh would invalidate cache entries.
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
        refreshAndWaitForReplication();
                )
        assertBusy(() -> {
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import static org.opensearch.common.cache.settings.CacheSettings.INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE;
        // Step 1 : Set a very high value for disk took time policy so that no items evicted from onHeap cache are spilled
        internalCluster().startNode(
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        // Step 1: Hit some queries. We will see misses and queries will be cached(onto disk cache) for subsequent
                Settings.builder()
        nodesInfoRequest.addMetric(NodesInfoRequest.Metric.PLUGINS.metricName());
        }
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
            return "mock_disk_plugin";
        NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
        int onHeapCacheSizeInBytes = randomIntBetween(numberOfSegments + 1, numberOfSegments * 2); // Keep it low so
        refreshAndWaitForReplication();
        // No more evictions seen when compared with last step.
        long lastEvictionSeen = requestCacheStats.getEvictions();
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
        assertEquals(numberOfIndexedItems - entriesInCache, requestCacheStats.getEvictions());
        assertAcked(
            SearchResponse resp = client.prepareSearch("index")
    public void testWithExplicitCacheClear() throws Exception {
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
        // size to be less than or equal to onHeapCache size.
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
        ClearIndicesCacheResponse response = client.admin().indices().clearCache(request).get();
                .setRequestCache(true)
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        // Step 3: Decrease disk took time policy to zero so that disk cache also comes into play. Now we should be able
        return Arrays.asList(TieredSpilloverCachePlugin.class, MockDiskCachePlugin.class);
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
                    Settings.builder()
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Client client = client();
        // Step 2: Hit same queries again. We will see hits now.
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        @Override
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
    public void testInvalidationWithIndicesRequestCache() throws Exception {
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
            SearchResponse resp = client.prepareSearch("index")
            assertSearchResponse(resp);
            .collect(Collectors.toList());
            Settings.builder()
                .put(defaultSettings(onHeapCacheSizeInBytes + "b", numberOfSegments))
import java.util.Collection;
            ),
        );
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
    }
                .setSettings(
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                .put(
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        // Explicit refresh would invalidate cache entries.
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
                )
            client.prepareIndex("index").setSource("f", "2014-05-13T00:00:00.000Z")
        }
        int onHeapCacheSizeInBytes = 2000;
        }
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testWithDynamicDiskTookTimePolicy() throws Exception {
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
            SearchResponse resp = client.prepareSearch("index")
    }
import static org.opensearch.indices.IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING;
                .setMapping("k", "type=keyword")
        // Set a very high value for took time disk policy so that no items evicted from onHeap cache are spilled
        // that all items are
                .setRequestCache(true)
        assertEquals(0, requestCacheStats.getMemorySizeInBytes());
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
            SearchResponse resp = client.prepareSearch("index")
        }
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        assertEquals(0, requestCacheStats.getEvictions());
                .setMapping("f", "type=date")
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
        // size to be less than or equal to onHeapCache size.
        for (int iterator = 0; iterator < numberOfIndexedItems * 2; iterator++) {
    }
    public void testWithDynamicDiskCacheSetting() throws Exception {
        refreshAndWaitForReplication();
                .put(
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals(numberOfIndexedItems * perQuerySizeInCacheInBytes, requestCacheStats.getMemorySizeInBytes());
import java.util.concurrent.TimeUnit;
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        // cached onto disk.
                .build()
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
                .setRequestCache(true)
                .indices()
import org.junit.Assert;
        Client client = client();
        }
        refreshAndWaitForReplication();
        // Considering disk cache won't be used due to took time policy having a high value, we expect overall cache
        ensureSearchable("index");
                .build()
        assertEquals(numberOfIndexedItems * 2, requestCacheStats.getMissCount());
            }
        int onHeapCacheSizeInBytes = 2000;
                .prepareCreate("index")
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .indices()
        // Update disk took time policy to zero so that all entries are eligible to be cached on disk.
        );
                    new TimeValue(100, TimeUnit.SECONDS)
        );
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
        );
                .setMapping("k", "type=keyword")
        assertEquals(0, lastKnownHitCount - requestCacheStats.getHitCount());
        // Update disk took time policy to zero so that all entries are eligible to be cached on disk.
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                )
        int numberOfSegments = getNumberOfSegments();
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
                        .getKey(),
            SearchResponse resp = client.prepareSearch("index")
            )
                .get();
            SearchResponse resp = client.prepareSearch("index")
        // Step 4: Invalidate entries via refresh.
            pluginInfos.stream()
        );
                        .put("index.refresh_interval", -1)
public class TieredSpilloverCacheIT extends TieredSpilloverCacheBaseIT {
                .get()
        refreshAndWaitForReplication();
    @Override
            Settings.builder()
        assertThrows(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
                .get()
                .setRequestCache(true)
                .put(
            assertSearchResponse(resp);
            assertSearchResponse(resp);
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
        NodesInfoResponse nodesInfoResponse = OpenSearchIntegTestCase.client().admin().cluster().nodesInfo(nodesInfoRequest).actionGet();
                .indices()
        int onHeapCacheSizeInBytes = 2000;
        }
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
import org.opensearch.test.hamcrest.OpenSearchAssertions;
                .build()
        @Override
            .setSearchType(SearchType.QUERY_THEN_FETCH)
import org.opensearch.indices.IndicesRequestCache;
        // All entries should get cached.
        assertEquals(0, requestCacheStats.getEvictions());
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
        );
        requestCacheStats = getRequestCacheStats(client, "index");
import org.opensearch.common.unit.TimeValue;
        }
                )
        assertEquals(0, requestCacheStats.getEvictions());
        }
        internalCluster().startNode(
            .addAggregation(
        );
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
import java.util.UUID;
                    .build()
        assertThat(
                .setRequestCache(true)
import org.opensearch.plugins.PluginInfo;
        int numberOfSegments = getNumberOfSegments();
                .put(
import org.opensearch.common.cache.ICache;
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
                    Settings.builder()
                .get();
        long lastKnownMissCount = requestCacheStats.getMissCount();
            if (perQuerySizeInCacheInBytes == -1) {
                .indices()
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());
        // that all items are
        // to disk. And then hit requests so that few items are cached into cache.
        assertEquals(entriesInCache, requestCacheStats.getHitCount());
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
        ensureSearchable("index");
                        .getKey(),
            // Explicit refresh should clear up cache entries
        requestCacheStats = getRequestCacheStats(client, "index");
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
            SearchResponse resp = client.prepareSearch("index")
        assertEquals(0, lastMissCountSeen - requestCacheStats.getMissCount());
    }
        int numberOfIndexedItems = randomIntBetween(6, 10);
import static org.hamcrest.Matchers.greaterThan;
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
import java.util.Map;
        long perQuerySizeInCacheInBytes = -1;
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            SearchResponse resp = client.prepareSearch("index")
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
                .setSettings(Settings.builder().put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true).build())
                .put(defaultSettings(onHeapCacheSizeInBytes + "b", numberOfSegments))
        Client client = client();
        int numberOfIndexedItems = randomIntBetween(5, 10);
    }
        Client client = client();
                .setRequestCache(true)
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
    }
        long lastHitCountSeen = requestCacheStats.getHitCount();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .get();
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        int onHeapCacheSizeInBytes = 2000;
                    new TimeValue(100, TimeUnit.SECONDS)
        }
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
        );
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
        assertEquals(0, requestCacheStats.getHitCount());
import org.opensearch.plugins.Plugin;
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
                .prepareCreate("index")
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
            )
        final SearchResponse r1 = client.prepareSearch("index")
                .setSettings(
 * The OpenSearch Contributors require contributions made to
                        .getKey(),
        // just a bit higher so that each segment can atleast hold 1 entry.
        Client client = client();
        );
        Client client = client();
        }
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
        assertTrue(requestCacheStats.getEvictions() > 0);
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
            // All entries should get cleared up.
    public void testSanityChecksWithIndicesRequestCache() throws InterruptedException {
        ensureSearchable("index");
                .build()
import org.opensearch.transport.client.Client;
        );
                .setMapping("k", "type=keyword")
                .put(
                .get()
            .stream()
        public MockDiskCachePlugin() {}
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
    private RequestCacheStats getRequestCacheStats(Client client, String indexName) {
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
    }
        // Step 4: Again hit the same requests, we should get hits for all entries.
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
        requestCacheStats = getRequestCacheStats(client, "index");
            SearchResponse resp = client.prepareSearch("index")
                        .getKey(),
import org.opensearch.plugins.CachePlugin;
                    new TimeValue(0, TimeUnit.MILLISECONDS)
            assertSearchResponse(resp);
import java.util.stream.Stream;
                .setSettings(
        assertEquals(0, lastKnownMissCount - requestCacheStats.getMissCount());
        );
        }
        assertAcked(
        assertAcked(
        );
        // We still won't get any hits as items keep getting evicted in LRU fashion due to limited cache size.
                    .put(defaultSettings(onHeapCacheSizeInBytes + "b", 300))
                .setMapping("k", "type=keyword")
        }
                .setRequestCache(true)
                .prepareCreate("index")
        // which used to not work well with the query cache because of the handles stream output
    public void testWithInvalidSegmentNumberSetting() throws Exception {
        );
import org.opensearch.index.query.QueryBuilders;
import java.time.ZoneId;
        long lastMissCountSeen = requestCacheStats.getMissCount();
            SearchResponse resp = client.prepareSearch("index")
                .get();
                    TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
                .prepareCreate("index")
