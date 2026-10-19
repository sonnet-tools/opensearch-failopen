import org.opensearch.common.settings.Settings;
                .indices()
        );
            client.admin()
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
        );
                .setRequestCache(true)
        refreshAndWaitForReplication();
                .put(defaultSettings(DEFAULT_CACHE_SIZE_IN_BYTES, null))
                .get();
        // build a cacheable search (size=0) and force request-level caching
import org.opensearch.index.cache.request.RequestCacheStats;
    }
            // All entries should get cleared up.
        assertBusy(() -> {
@ThreadLeakFilters(filters = { EhcacheThreadLeakFilter.class })
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
        int numberOfIndexedItems = randomIntBetween(5, 10);
            assertSearchResponse(resp);
        if (expirationTime == null) {
        ensureSearchable("index");
    }
                .put(
                .setMapping("k", "type=keyword")
                .indices()
                .prepareCreate("index")
                        .put("index.refresh_interval", -1)
        assertBusy(() -> {
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(0, requestCacheStats.getHitCount());
                .build()
                    env.nodePaths()[0].indicesPath.toString() + "/" + UUID.randomUUID() + "/request_cache/"
                .get()
                .put(
    @Override
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        // cleared up.
                        .build()
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        ensureSearchable("index");
        internalCluster().startNode(Settings.builder().put(defaultSettings(DEFAULT_CACHE_SIZE_IN_BYTES, null)).build());
        );
        ClearIndicesCacheRequest request = new ClearIndicesCacheRequest("index");
/*
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        }
            if (perQuerySizeInCacheInBytes == -1) {
import org.opensearch.action.search.SearchType;
        assertAcked(
import java.time.ZoneId;
                .put(defaultSettings(DEFAULT_CACHE_SIZE_IN_BYTES, null))
        // stats may lag slightly; wait until cache shows non-zero memory usage
            // Explicit refresh should clear up cache entries
                .indices()
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
                .getRequestCache()
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
import org.opensearch.plugins.PluginInfo;
        );
        }
                .put(
            Settings.builder()
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
import java.util.UUID;
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Explicit refresh would invalidate cache entries.
import org.opensearch.common.cache.settings.CacheSettings;
        internalCluster().startNode(
 * SPDX-License-Identifier: Apache-2.0
    public void testExplicitCacheClearWithIndicesRequestCache() throws Exception {
                .get();
            .collect(Collectors.toList());
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
            // Explicit refresh should clear up cache entries
                .setRequestCache(true)
            throw new RuntimeException(e);
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
            pluginInfos.stream().anyMatch(pluginInfo -> pluginInfo.getName().equals("org.opensearch.cache.EhcacheCachePlugin"))
            client.admin()
                    EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME
        int numberOfIndexedItems = 2;// randomIntBetween(5, 10);
        return client.admin().indices().prepareStats(indexName).setRequestCache(true).get().getTotal().getRequestCache();
                )
import org.opensearch.plugins.Plugin;
                        .get(DISK_STORAGE_PATH_KEY)
                .setSettings(
            SearchResponse resp = client.prepareSearch("index")
    }
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
                )
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
                        .getKey(),
            )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                .prepareCreate("index")
                .indices()
            SearchResponse resp = client.prepareSearch("index")
}
import org.opensearch.index.query.QueryBuilders;
        assertAcked(
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
import org.junit.Assert;
                    Settings.builder()
            Settings.builder()
        internalCluster().startNode(
        }, 10, TimeUnit.MILLISECONDS);
        nodesInfoRequest.addMetric(NodesInfoRequest.Metric.PLUGINS.metricName());
                .put(
        assertEquals(0, requestCacheStats.getHitCount());
        refreshAndWaitForReplication();
                // access
                .setMapping("k", "type=keyword")
        requestCacheStats = getRequestCacheStats(client, "index");
import org.opensearch.env.NodeEnvironment;
        assertNoFailures(response);
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
                .setMapping("f", "type=date")
        assertEquals(0, requestCacheStats.getEvictions());
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                .prepareCreate("index")
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    Settings.builder()
import static org.opensearch.cache.EhcacheDiskCacheSettings.DEFAULT_CACHE_SIZE_IN_BYTES;
        assertSearchResponse(srb.get());
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
                .setRequestCache(true)
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        try (NodeEnvironment env = newNodeEnvironment(Settings.EMPTY)) {
            .setSize(0)
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
import org.opensearch.cache.store.disk.EhcacheDiskCache;
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());
                .indices()
                .build();
        assertAcked(
            if (perQuerySizeInCacheInBytes == -1) {
import java.util.List;
        long perQuerySizeInCacheInBytes = -1;
            .flatMap(
        assertEquals(0, requestCacheStats.getEvictions());
        final SearchRequestBuilder srb = client.prepareSearch("index")
public class EhcacheDiskCacheIT extends OpenSearchIntegTestCase {
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_STORAGE_PATH_KEY;
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
import org.opensearch.transport.client.Client;
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
 *
    private RequestCacheStats getRequestCacheStats(Client client, String indexName) {
                .get()
        requestCacheStats = getRequestCacheStats(client, "index");
                    expirationTime
import static org.opensearch.indices.IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING;
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
        Assert.assertTrue(
        );
            client.prepareIndex("index").setSource("f", "2014-05-13T00:00:00.000Z")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .getMemorySizeInBytes();
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        int numberOfIndexedItems = randomIntBetween(5, 10);
    public void testEvictionsFlowWithExpirationTime() throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .get();
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
import org.opensearch.action.search.SearchRequestBuilder;
            SearchResponse resp = client.prepareSearch("index")
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
        assertEquals(0, requestCacheStats.getHitCount());
                .get();
        }
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
        List<PluginInfo> pluginInfos = nodesInfoResponse.getNodes()
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
            client.admin()
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
                .setSettings(
            SearchResponse resp = client.prepareSearch("index")
        refreshAndWaitForReplication();
        }
        internalCluster().startNode(
import org.opensearch.cluster.metadata.IndexMetadata;
            }
                .setRequestCache(true)
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        ensureSearchable("index");
                    Settings.builder()
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        assertAcked(
            );
            if (perQuerySizeInCacheInBytes == -1) {
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
                    true
    }
                    Settings.builder()
        // warm cache (run the exact same request twice)
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
    public void testInvalidationWithIndicesRequestCache() throws Exception {
            return Settings.builder()
import java.util.Arrays;
        assertBusy(() -> {
        long perQuerySizeInCacheInBytes = -1;
    }
                    .dateHistogramInterval(DateHistogramInterval.MONTH)
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
                        .put("index.refresh_interval", -1)
import org.opensearch.test.OpenSearchIntegTestCase;
        ensureSearchable("index");
            .setRequestCache(true) // ensure it goes through the indices request cache
    public void testSanityChecksWithIndicesRequestCache() throws Exception {
        }, 1, TimeUnit.SECONDS);
import java.util.concurrent.TimeUnit;
        long perQuerySizeInCacheInBytes = -1;
        internalCluster().startNode(Settings.builder().put(defaultSettings(DEFAULT_CACHE_SIZE_IN_BYTES, null)).build());
        );
                    CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        // Explicit clear the cache.
        assertEquals(0, requestCacheStats.getEvictions());
                .build()
import org.opensearch.cache.store.disk.EhcacheThreadLeakFilter;
                )
                        .getKey(),
            assertSearchResponse(resp);
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
                        .get(DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY)
import java.io.IOException;
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        });
                        .getKey(),
                    .timeZone(ZoneId.of("+01:00"))
                )
import java.util.stream.Collectors;
        indexRandom(
        requestCacheStats = getRequestCacheStats(client, "index");
        // Validate hit and miss count.
                    .minDocCount(0)
                dateHistogram("histo").field("f")
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY;
                        .getKey(),
                .prepareStats("index")
            assertSearchResponse(resp);
            SearchResponse resp = client.prepareSearch("index")
import org.opensearch.common.unit.TimeValue;
        }, 1, TimeUnit.SECONDS);
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
    public void testPluginsAreInstalled() {
            expirationTime = TimeValue.MAX_VALUE;
    }
        assertBusy(() -> {
        }
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_MAX_SIZE_IN_BYTES_KEY;
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
                .get()
            Settings.builder()
            .stream()
        }
 * this file be licensed under the Apache-2.0 license or a
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
                .setRequestCache(true)
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
                .setSettings(
                .prepareCreate("index")
        Client client = client();
    }
        NodesInfoResponse nodesInfoResponse = OpenSearchIntegTestCase.client().admin().cluster().nodesInfo(nodesInfoRequest).actionGet();
                (Function<NodeInfo, Stream<PluginInfo>>) nodeInfo -> nodeInfo.getInfo(PluginsAndModules.class).getPluginInfos().stream()
            assertThat(bytes, greaterThan(0L));
        } catch (IOException e) {
        return Arrays.asList(EhcacheCachePlugin.class);
            client.admin()
            }
                .setSettings(
            long bytes = client.admin()
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
                .put(
        ClearIndicesCacheResponse response = client.admin().indices().clearCache(request).get();
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
            assertSearchResponse(resp);
                .get()
        Client client = client();
                .get();
        Client client = client();
            }
            .setSearchType(SearchType.QUERY_THEN_FETCH)
        NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
import org.opensearch.common.cache.CacheType;
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_LISTENER_MODE_SYNC_KEY;
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
        // Now that we have access the entries, they should expire after 1ms. So lets wait and verify that cache gets
import org.opensearch.test.hamcrest.OpenSearchAssertions;
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
    }
        // Hits and misses stats shouldn't get cleared up.
        }
                .get()
                .setRequestCache(true)
        assertEquals(0, requestCacheStats.getEvictions());
                )
        }
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
                        .get(DISK_LISTENER_MODE_SYNC_KEY)
                )
 * The OpenSearch Contributors require contributions made to
        );
        );
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
        Client client = client();
        refreshAndWaitForReplication();
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
            client.prepareIndex("index").setSource("f", "2014-03-10T00:00:00.000Z"),
                        .get(DISK_MAX_SIZE_IN_BYTES_KEY)
import java.util.function.Function;
        }
                .getTotal()
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
                )
        assertSearchResponse(srb.get());
import org.opensearch.action.search.SearchResponse;
                        .put("index.refresh_interval", -1)
import java.util.Collection;
        }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import static org.hamcrest.Matchers.greaterThan;
                )
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
            assertSearchResponse(resp);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
package org.opensearch.cache;
        assertEquals(0, requestCacheStats.getMemorySizeInBytes());
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
import java.util.stream.Stream;
import org.opensearch.indices.IndicesRequestCache;
            .addAggregation(
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
 * compatible open source license.
                .setMapping("k", "type=keyword")
                )
                .build()
                    sizeInBytes
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
 */
                .put(defaultSettings(DEFAULT_CACHE_SIZE_IN_BYTES, new TimeValue(0))) // Immediately evict items after
        );
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            true,
    private Settings defaultSettings(long sizeInBytes, TimeValue expirationTime) {
