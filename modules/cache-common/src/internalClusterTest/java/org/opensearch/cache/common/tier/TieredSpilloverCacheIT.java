            if (perQuerySizeInCacheInBytes == -1) {
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));  
            }  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import java.time.ZoneId;
        assertEquals(numberOfIndexedItems * perQuerySizeInCacheInBytes, requestCacheStats.getMemorySizeInBytes());
                .put(  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        public String getName() {
        // that all items are
        final SearchResponse r1 = client.prepareSearch("index")
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
        // that all items are  
                .setRequestCache(true)
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache  
                .setSettings(  
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
    public void testWithDynamicHeapTookTimePolicy() throws Exception {  
                    new TimeValue(0, TimeUnit.MILLISECONDS)  
                .get();  
                        .getKey(),
        long perQuerySizeInCacheInBytes = -1;
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
                .setRequestCache(true)
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
        assertThat(  
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);  
                .build()  
        int onHeapCacheSizeInBytes = 2000;
            Settings.builder()
        // size to be less than or equal to onHeapCache size.  
                .indices()
            }
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        Client client = client();
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());  
                .indices()
                INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE,
                .put(
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {  
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                .put(
                        .put("index.refresh_interval", -1)  
 */  
                .setSettings(Settings.builder().put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true).build())
        assertEquals(0, requestCacheStats.getEvictions());
            Settings.builder()
import org.opensearch.action.search.SearchResponse;  
 * compatible open source license.
        assertThrows(
        Client client = client();
                    new TimeValue(0, TimeUnit.MILLISECONDS)
            // Explicit refresh should clear up cache entries  
                .get();  
        long perQuerySizeInCacheInBytes = -1;
        assertEquals(0, lastMissCountSeen - requestCacheStats.getMissCount());
        // Step 3: Decrease disk took time policy to zero so that disk cache also comes into play. Now we should be able  
        long lastKnownMissCount = requestCacheStats.getMissCount();  
        Client client = client();  
                )  
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());  
                .setRequestCache(true)
        assertEquals(numberOfIndexedItems - entriesInCache, requestCacheStats.getEvictions());
            pluginInfos.stream()
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
        }  
                .setRequestCache(true)  
        );
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        refreshAndWaitForReplication();
        // which used to not work well with the query cache because of the handles stream output  
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
                )
            ),  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            greaterThan(0L)
        // Considering disk cache won't be used due to took time policy having a high value, we expect overall cache
        requestCacheStats = getRequestCacheStats(client, "index");
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
            }
        assertEquals(numberOfIndexedItems * perQuerySizeInCacheInBytes, requestCacheStats.getMemorySizeInBytes());  
    public void testInvalidationWithIndicesRequestCache() throws Exception {
                .get();
            .get();
                .indices()  
                .get();  
        ensureSearchable("index");  
        assertAcked(
import java.util.stream.Stream;
        Client client = client();
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        assertTrue(requestCacheStats.getEvictions() > 0);
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());  
                .prepareCreate("index")
                .setMapping("k", "type=keyword")
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());  
        );
            SearchResponse resp = client.prepareSearch("index")  
        Assert.assertTrue(
    }
            assertSearchResponse(resp);
                .setRequestCache(true)
        assertEquals(0, requestCacheStats.getEvictions());
        internalCluster().startNode(
                .put(
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());  
            client.prepareIndex("index").setSource("f", "2014-03-10T00:00:00.000Z"),  
        long lastMissCountSeen = requestCacheStats.getMissCount();
        // Update disk took time policy to zero so that all entries are eligible to be cached on disk.
        // The cached is actually used
                Locale.ROOT,  
        NodesInfoResponse nodesInfoResponse = OpenSearchIntegTestCase.client().admin().cluster().nodesInfo(nodesInfoRequest).actionGet();  
        // Step 3: Turn off disk cache now. And hit same queries again. We should not see hits now as all queries
                )
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
                .prepareCreate("index")  
        // Set a high threshold for the overall cache took time policy so nothing will enter the cache.  
        }
        assertSearchResponse(r1);  
        assertEquals(entriesInCache, requestCacheStats.getHitCount());
                .put(defaultSettings(onHeapCacheSizeInBytes + "b", numberOfSegments))
        // Set a very high value for took time disk policy so that no items evicted from onHeap cache are spilled  
        // Explicit refresh would invalidate cache entries.  
        );
            client.prepareIndex("index").setSource("f", "2014-05-13T00:00:00.000Z")
import org.opensearch.common.unit.TimeValue;  
        );
        assertEquals(0, requestCacheStats.getHitCount());  
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;  
            if (perQuerySizeInCacheInBytes == -1) {
import java.util.concurrent.TimeUnit;
        );  
        }, 1, TimeUnit.SECONDS);  
                .get();  
        refreshAndWaitForReplication();  
        ensureSearchable("index");
            SearchResponse resp = client.prepareSearch("index")
        // Step 4: Invalidate entries via refresh.
import org.opensearch.index.query.QueryBuilders;
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)  
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);  
        // were cached onto disk cache.  
        assertAcked(
        // We shouldn't see any new evictions now.
                )  
        ensureSearchable("index");
    }
                .get()
import static org.opensearch.indices.IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING;
        int numberOfSegments = getNumberOfSegments();
                (Function<NodeInfo, Stream<PluginInfo>>) nodeInfo -> nodeInfo.getInfo(PluginsAndModules.class).getPluginInfos().stream()
        assertBusy(() -> {
            Settings.builder()
        int numberOfIndexedItems = randomIntBetween(5, 10);  
        );
                        .put("index.refresh_interval", -1)
 * SPDX-License-Identifier: Apache-2.0
        updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));  
            client.admin()  
        // Step 2: Hit same queries again. We will see hits now.
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
import java.util.UUID;
        assertEquals(0, requestCacheStats.getEvictions());
import org.opensearch.plugins.PluginInfo;  
        for (int iterator = 0; iterator < numberOfIndexedItems * 2; iterator++) {
            SearchResponse resp = client.prepareSearch("index")  
        // Explicit clear the cache.
        int numberOfSegments = getNumberOfSegments();
            client.admin()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        lastKnownMissCount = requestCacheStats.getMissCount();
        int numberOfSegments = getNumberOfSegments();
        int onHeapCacheSizeInBytes = onHeapCacheSizePerSegmentInBytes * numberOfSegments;
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());  
        requestCacheStats = getRequestCacheStats(client, "index");
 *
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
                )
    private RequestCacheStats getRequestCacheStats(Client client, String indexName) {
        lastKnownHitCount = requestCacheStats.getHitCount();  
            assertSearchResponse(resp);
        assertAcked(  
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));  
        ensureSearchable("index");
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
    }
            Settings.builder()
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        Client client = client();
        assertBusy(() -> {  
                        .put("index.refresh_interval", -1)  
        }  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(  
            SearchResponse resp = client.prepareSearch("index")
        assertEquals(0, requestCacheStats.getHitCount());  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(  
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());  
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
        long lastKnownHitCount = requestCacheStats.getHitCount();
                .get();
                .get();
            SearchResponse resp = client.prepareSearch("index")
        ensureSearchable("index");
                    .put(defaultSettings(onHeapCacheSizeInBytes + "b", 300))
                Settings.builder()  
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());  
        // This is not a random example: serialization with time zones writes shared strings
        int numberOfIndexedItems = randomIntBetween(5, 10);
        refreshAndWaitForReplication();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            Settings.builder()  
        assertEquals(numberOfIndexedItems * 3 - entriesInCache, requestCacheStats.getMissCount());
                    Settings.builder()  
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
        assertEquals(0, requestCacheStats.getHitCount());
package org.opensearch.cache.common.tier;
        // requests.  
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                        .put("index.refresh_interval", -1)
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
import java.util.stream.Collectors;
import org.opensearch.action.search.SearchType;
        );
    public void testWithExplicitCacheClear() throws Exception {
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;  
        // Hits and misses stats shouldn't get cleared up.
import org.junit.Assert;
        NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
        // We should atleast one eviction considering disk cache isn't able to hold anything due to policy.  
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
                .indices()
            Settings.builder()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        int numberOfIndexedItems = randomIntBetween(5, 10);
            assertSearchResponse(resp);
            // All entries should get cleared up.
        Client client = client();  
                .prepareCreate("index")
                .get()
                .get()
        internalCluster().startNode(Settings.builder().put(defaultSettings(onHeapCacheSizeInBytes + "b", 1)).build());
        );
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();  
                .get();  
                .setRequestCache(true)
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
                .setSettings(
            SearchResponse resp = client.prepareSearch("index")  
                .get();
        assertTrue(requestCacheStats.getMemorySizeInBytes() <= onHeapCacheSizeInBytes);
    }  
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        assertAcked(
        Client client = client();
        }
        assertEquals(lastKnownMissCount + numberOfIndexedItems, requestCacheStats.getMissCount());  
            .stream()
        // size to be less than or equal to onHeapCache size.  
    public void testPluginsAreInstalled() {
import java.util.Map;  
                .build()  
        );
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        requestCacheStats = client.admin().indices().prepareStats("index").setRequestCache(true).get().getTotal().getRequestCache();  
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();  
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))  
        long lastEvictionSeen = requestCacheStats.getEvictions();
        }
            assertSearchResponse(resp);
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
                )
import static org.hamcrest.Matchers.greaterThan;
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);  
        refreshAndWaitForReplication();  
        assertEquals(0, requestCacheStats.getHitCount());
        int numberOfSegments = getNumberOfSegments();
                .setQuery(QueryBuilders.termQuery(UUID.randomUUID().toString(), UUID.randomUUID().toString()))
        }  
        long perQuerySizeInCacheInBytes = -1;
            client.admin()  
        refreshAndWaitForReplication();  
        internalCluster().startNode(Settings.builder().put(defaultSettings(onHeapCacheSizeInBytes + "b", numberOfSegments)).build());
        }
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        internalCluster().startNode(
            Settings.builder()  
import org.opensearch.test.OpenSearchIntegTestCase;
                )  
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))  
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
import java.util.Collection;  
import org.opensearch.index.cache.request.RequestCacheStats;
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
        // cached onto disk.  
        requestCacheStats = client.admin().indices().prepareStats("index").setRequestCache(true).get().getTotal().getRequestCache();
                )  
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                .put(
        assertEquals(numberOfIndexedItems * perQuerySizeInCacheInBytes, requestCacheStats.getMemorySizeInBytes()); //
        // Still shows disk cache entries as explicit clear or invalidation is required to clean up disk cache.
                        .put("index.refresh_interval", -1)
            if (perQuerySizeInCacheInBytes == -1) {
        int onHeapCacheSizeInBytes = 2000;  
            }
                    new TimeValue(100, TimeUnit.SECONDS)
                .indices()
        }  
        public MockDiskCachePlugin() {}
                .setSettings(
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        @Override
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        }
        assertEquals(numberOfIndexedItems * perQuerySizeInCacheInBytes, requestCacheStats.getMemorySizeInBytes());
            return Map.of(MockDiskCache.MockDiskCacheFactory.NAME, new MockDiskCache.MockDiskCacheFactory(0, 10000, false, 1));  
        int onHeapCacheSizePerSegmentInBytes = 800; // Per cache entry below is around ~700 bytes, so keeping this
            )
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
        // Update disk took time policy to zero so that all entries are eligible to be cached on disk.
            )
    @Override  
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testSanityChecksWithIndicesRequestCache() throws InterruptedException {
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
                .get();  
                    TieredSpilloverCacheSettings.TOOK_TIME_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(),
        assertEquals(0, requestCacheStats.getEvictions());
import java.util.Arrays;
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)  
    }  
                .build()  
            SearchResponse resp = client.prepareSearch("index")  
                .setMapping("k", "type=keyword")  
 * this file be licensed under the Apache-2.0 license or a
        assertAcked(
        nodesInfoRequest.addMetric(NodesInfoRequest.Metric.PLUGINS.metricName());
            .addAggregation(
import java.util.Locale;
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
                .setMapping("k", "type=keyword")
                .setSettings(
                .get();  
                .setRequestCache(true)
                .setRequestCache(true)
        long perQuerySizeInCacheInBytes = -1;
        // to disk. And then hit requests so that few items are cached into cache.
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
        );
        int numberOfIndexedItems = randomIntBetween(6, 10);
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {  
        assertBusy(() -> {
            // Explicit refresh should clear up cache entries  
        assertEquals(0, requestCacheStats.getEvictions() - lastEvictionSeen);  
            client.admin()
            assertSearchResponse(resp);
/*  
                .build()
        int onHeapCacheSizeInBytes = randomIntBetween(numberOfSegments + 1, numberOfSegments * 2); // Keep it low so
 * The OpenSearch Contributors require contributions made to  
        // to disk. And then hit requests so that few items are cached into cache.
                .setRequestCache(true)
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
                .get()
                )
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        }
                        .getKey(),
        assertEquals(0, requestCacheStats.getEvictions());
        assertTrue(requestCacheStats.getMemorySizeInBytes() <= onHeapCacheSizeInBytes);
        }
        ClearIndicesCacheResponse response = client.admin().indices().clearCache(request).get();  
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
import org.opensearch.common.settings.Settings;
        }  
            if (perQuerySizeInCacheInBytes == -1) {
        }
        long lastHitCountSeen = requestCacheStats.getHitCount();  
                .build()
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
                )
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            assertSearchResponse(resp);
        // to cache all entries.
                        .getKey(),  
            .collect(Collectors.toList());  
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
                .put(TieredSpilloverCacheSettings.DISK_CACHE_ENABLED_SETTING_MAP.get(CacheType.INDICES_REQUEST_CACHE).getKey(), false)  
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);  
                .get()
            SearchResponse resp = client.prepareSearch("index")
        }
        ensureSearchable("index");
                .setRequestCache(true)
        int numberOfSegments = getNumberOfSegments();
            true,
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)  
        requestCacheStats = getRequestCacheStats(client, "index");  
                .anyMatch(pluginInfo -> pluginInfo.getName().equals("org.opensearch.cache.common.tier.TieredSpilloverCachePlugin"))  
        assertEquals(0, requestCacheStats.getEvictions() - lastEvictionSeen);
        // Step 4: Again hit the same requests, we should get hits for all entries.  
        }
                    new TimeValue(0, TimeUnit.MILLISECONDS)
    public void testWithDynamicDiskTookTimePolicy() throws Exception {
        // Hit count should be equal to number of cache entries present in previous step.  
            assertSearchResponse(resp);  
            SearchResponse resp = client.prepareSearch("index")  
        internalCluster().startNode(Settings.builder().put(defaultSettings(onHeapCacheSizeInBytes + "b", 1)).build());  
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        assertEquals(numberOfIndexedItems * 2 - entriesInCache, requestCacheStats.getEvictions());
                .build()  
        );
        // cached onto disk.
            SearchResponse resp = client.prepareSearch("index")
        internalCluster().startNodes(3, Settings.builder().put(defaultSettings("1%", numberOfSegments)).build());  
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
            assertSearchResponse(resp);
        long perQuerySizeInCacheInBytes = -1;
                .build()  
                .prepareCreate("index")
        assertEquals(lastEvictionSeen, requestCacheStats.getEvictions());  
            SearchResponse resp = client.prepareSearch("index")  
        // just a bit higher so that each segment can atleast hold 1 entry.  
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)  
        refreshAndWaitForReplication();  
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(  
    }
        assertEquals(numberOfIndexedItems * 2, requestCacheStats.getMissCount());
            client.admin()
                    .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
        // Explicit refresh would invalidate cache entries.  
            assertSearchResponse(resp);
                    new TimeValue(0, TimeUnit.MILLISECONDS)
    }
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        );  
        }, 1, TimeUnit.SECONDS);
                        .getKey(),  
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
        long lastEvictionSeen = requestCacheStats.getEvictions();  
            assertSearchResponse(resp);
        assertEquals(0, requestCacheStats.getHitCount());  
                .setMapping("k", "type=keyword")
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
        );
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
            }
        // No more evictions seen when compared with last step.
                .build()
        updateSettingsRequest = new ClusterUpdateSettingsRequest().transientSettings(
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {  
            Settings.builder()  
                .prepareCreate("index")
    }  
        // All entries should get cached.
            assertSearchResponse(resp);
                .get();
        assertEquals(0, requestCacheStats.getHitCount());  
        // Step 2: Again hit same set of queries as above, we still won't see any hits as items keeps getting evicted.
public class TieredSpilloverCacheIT extends TieredSpilloverCacheBaseIT {
            Settings.builder()
        assertAcked(  
        return Arrays.asList(TieredSpilloverCachePlugin.class, MockDiskCachePlugin.class);
        ClearIndicesCacheRequest request = new ClearIndicesCacheRequest("index");
        // Update disk took time policy to zero so that all entries are eligible to be cached on disk.
        int onHeapCacheSizeInBytes = 2000;  
        }  
                        .getKey(),
                    Settings.builder()
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
        List<PluginInfo> pluginInfos = nodesInfoResponse.getNodes()
import org.opensearch.common.cache.ICache;
            () -> internalCluster().startNode(
import org.opensearch.transport.client.Client;
                .build()
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");  
        ensureSearchable("index");
                    new TimeValue(100, TimeUnit.SECONDS)
        assertEquals(0, lastKnownHitCount - requestCacheStats.getHitCount());
        requestCacheStats = getRequestCacheStats(client, "index");
    public void testWithInvalidSegmentNumberSetting() throws Exception {
                .put(
            if (perQuerySizeInCacheInBytes == -1) {  
        long perQuerySizeInCacheInBytes = -1;
        // Decrease disk took time policy to zero so that disk cache also comes into play. Now we should be able
    }
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)  
                .indices()  
        internalCluster().startNode(Settings.builder().put(defaultSettings("1%", getNumberOfSegments())).build());  
        );
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
        }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .build()
        int onHeapCacheSizeInBytes = randomIntBetween(numberOfSegments + 1, numberOfSegments * 2); // Keep it low so
                    new TimeValue(0, TimeUnit.MILLISECONDS)
        );
import static org.opensearch.common.cache.settings.CacheSettings.INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE;
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
        );
        }  
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());  
                .setMapping("f", "type=date")  
import org.opensearch.common.cache.CacheType;  
                .put(
                .setSettings(  
        // No more evictions seen when compared with last step.
            IllegalArgumentException.class,
        indexRandom(
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
    }
                .get();  
        refreshAndWaitForReplication();
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
        assertTrue(requestCacheStats.getMemorySizeInBytes() <= onHeapCacheSizeInBytes);  
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
            String.format(
            .setSize(0)  
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)
            )
        );  
    public void testWithDynamicDiskCacheSetting() throws Exception {  
import org.opensearch.plugins.Plugin;
        int onHeapCacheSizeInBytes = 2000;
            SearchResponse resp = client.prepareSearch("index")  
                .setRequestCache(true)
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
                )
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();  
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));  
            SearchResponse resp = client.prepareSearch("index")  
import org.opensearch.plugins.CachePlugin;
                .indices()
        // Step 1: Hit some queries. We will see misses and queries will be cached(onto disk cache) for subsequent
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
}
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));  
        // Considering disk cache won't be used due to took time policy having a high value, we expect overall cache
import org.opensearch.indices.IndicesRequestCache;  
                    Settings.builder()
                        .getKey(),
        assertEquals(0, requestCacheStats.getEvictions());
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
            .flatMap(  
                    TieredSpilloverCacheSettings.TOOK_TIME_DISK_TIER_POLICY_CONCRETE_SETTINGS_MAP.get(CacheType.INDICES_REQUEST_CACHE)  
        // Step 1 : Set a very high value for disk took time policy so that no items evicted from onHeap cache are spilled
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
        assertAcked(
                .get()  
    public static class MockDiskCachePlugin extends Plugin implements CachePlugin {  
        requestCacheStats = getRequestCacheStats(client, "index");
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
            return "mock_disk_plugin";
            Settings.builder()
        // All should be misses in the first attempt  
                .put(  
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
                .prepareCreate("index")  
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());
                    Settings.builder()  
        }  
        // segment, atleast one of the segment will have 2 entries and we will see evictions.
        refreshAndWaitForReplication();  
        assertEquals(numberOfIndexedItems * perQuerySizeInCacheInBytes, requestCacheStats.getMemorySizeInBytes());
                )  
        requestCacheStats = getRequestCacheStats(client, "index");  
        }  
        // to cache all entries.  
        }, 1, TimeUnit.SECONDS);
                dateHistogram("histo").field("f").timeZone(ZoneId.of("+01:00")).minDocCount(0).calendarInterval(DateHistogramInterval.MONTH)  
        assertEquals(lastHitCountSeen + numberOfIndexedItems, requestCacheStats.getHitCount());
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))  
        int numberOfSegments = getNumberOfSegments();  
        // see #9500
                .setMapping("k", "type=keyword")  
                .put(defaultSettings(onHeapCacheSizeInBytes + "b", numberOfSegments))  
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
                .build()
        );
        );
        int numberOfIndexedItems = randomIntBetween(6, 10);
        assertEquals(0, lastKnownMissCount - requestCacheStats.getMissCount());
import org.opensearch.cluster.metadata.IndexMetadata;
        @Override  
        assertAcked(internalCluster().client().admin().cluster().updateSettings(updateSettingsRequest).get());
import java.util.function.Function;  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                        .put("index.refresh_interval", -1)
        // All entries should get cached.  
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
            Settings.builder()
        assertEquals(0, requestCacheStats.getMemorySizeInBytes());
        );  
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
        );  
                .setRequestCache(true)
        assertNoFailures(response);
                TieredSpilloverCache.TieredSpilloverCacheFactory.TIERED_SPILLOVER_CACHE_NAME
        // We still won't get any hits as items keep getting evicted in LRU fashion due to limited cache size.
                .put(defaultSettings(onHeapCacheSizeInBytes + "b", numberOfSegments))
        public Map<String, ICache.Factory> getCacheFactoryMap() {
        long entriesInCache = requestCacheStats.getMemorySizeInBytes() / perQuerySizeInCacheInBytes;
                .build()
                        .getKey(),  
    public void testWithDynamicDiskTookTimePolicyWithMultiSegments() throws Exception {  
                    Settings.builder()
                .get()  
                    .build()  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
                .prepareCreate("index")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                )
    }
            assertSearchResponse(resp);
                .setRequestCache(true)  
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
                )  
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
                    new TimeValue(100, TimeUnit.SECONDS)
            client.admin().indices().prepareStats("index").setRequestCache(true).get().getTotal().getRequestCache().getMemorySizeInBytes(),
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();  
        assertEquals(0, lastKnownHitCount - requestCacheStats.getHitCount()); // No new hits being seen.
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
                    Settings.builder()
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
import java.util.List;
                .setSettings(
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);  
            assertSearchResponse(resp);
            client.admin()
            Settings.builder()  
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
        int numberOfIndexedItems = numberOfSegments + 1; // Best case if all keys are distributed among different  
                .setMapping("k", "type=keyword")
        requestCacheStats = getRequestCacheStats(client, "index");  
        return client.admin().indices().prepareStats(indexName).setRequestCache(true).get().getTotal().getRequestCache();  
        internalCluster().startNode(
        );  
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
            client.admin()  
    }  
        }
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
