        });  
 */  
import org.opensearch.plugins.Plugin;  
                .put(defaultSettings(DEFAULT_CACHE_SIZE_IN_BYTES, new TimeValue(0))) // Immediately evict items after
        Client client = client();
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
                .build()
                .put(defaultSettings(DEFAULT_CACHE_SIZE_IN_BYTES, null))
/*  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)  
        List<PluginInfo> pluginInfos = nodesInfoResponse.getNodes()
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
        internalCluster().startNode(Settings.builder().put(defaultSettings(DEFAULT_CACHE_SIZE_IN_BYTES, null)).build());
                .put(
import java.util.Arrays;
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        return Arrays.asList(EhcacheCachePlugin.class);
        long perQuerySizeInCacheInBytes = -1;  
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
        assertAcked(
        final SearchRequestBuilder srb = client.prepareSearch("index")
        // stats may lag slightly; wait until cache shows non-zero memory usage
                        .get(DISK_LISTENER_MODE_SYNC_KEY)
        assertNoFailures(response);  
            client.admin()  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;  
                (Function<NodeInfo, Stream<PluginInfo>>) nodeInfo -> nodeInfo.getInfo(PluginsAndModules.class).getPluginInfos().stream()
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;  
        int numberOfIndexedItems = randomIntBetween(5, 10);
        nodesInfoRequest.addMetric(NodesInfoRequest.Metric.PLUGINS.metricName());
                .setRequestCache(true)
                    .dateHistogramInterval(DateHistogramInterval.MONTH)  
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
    public void testEvictionsFlowWithExpirationTime() throws Exception {
            SearchResponse resp = client.prepareSearch("index")
            assertSearchResponse(resp);
            .setRequestCache(true) // ensure it goes through the indices request cache
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
            );
        refreshAndWaitForReplication();
            .setSearchType(SearchType.QUERY_THEN_FETCH)  
        assertEquals(0, requestCacheStats.getEvictions());
            .flatMap(  
                )
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
    @Override
        // Validate hit and miss count.
            assertSearchResponse(resp);  
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
        // Explicit clear the cache.  
                    .minDocCount(0)
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)  
        // Now that we have access the entries, they should expire after 1ms. So lets wait and verify that cache gets
        NodesInfoResponse nodesInfoResponse = OpenSearchIntegTestCase.client().admin().cluster().nodesInfo(nodesInfoRequest).actionGet();  
                .indices()
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
                    Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))  
                .setRequestCache(true)
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);  
                .prepareCreate("index")
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());  
        internalCluster().startNode(Settings.builder().put(defaultSettings(DEFAULT_CACHE_SIZE_IN_BYTES, null)).build());  
        assertBusy(() -> {
import static org.hamcrest.Matchers.greaterThan;
                )
                    .timeZone(ZoneId.of("+01:00"))
        ensureSearchable("index");
            SearchResponse resp = client.prepareSearch("index")  
                .setRequestCache(true)
                    sizeInBytes  
            assertSearchResponse(resp);
import org.opensearch.cluster.metadata.IndexMetadata;  
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
            Settings.builder()  
                    true  
            SearchResponse resp = client.prepareSearch("index")
                    Settings.builder()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }
        // Explicit refresh would invalidate cache entries.  
        assertBusy(() -> {
                        .get(DISK_MAX_SIZE_IN_BYTES_KEY)
                )
import org.opensearch.cache.store.disk.EhcacheThreadLeakFilter;
                .prepareCreate("index")
        Client client = client();
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
                .put(defaultSettings(DEFAULT_CACHE_SIZE_IN_BYTES, null))  
            }
import static org.opensearch.indices.IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING;  
                .setSettings(
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));  
                .put(
        );  
import java.io.IOException;
    public void testInvalidationWithIndicesRequestCache() throws Exception {  
                )
                .put(
                        .get(DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY)
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);  
import org.opensearch.test.hamcrest.OpenSearchAssertions;
            )
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();
                .get();
    }
            client.admin()  
        assertAcked(
        assertEquals(0, requestCacheStats.getMemorySizeInBytes());
                .build();
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {  
import org.opensearch.index.cache.request.RequestCacheStats;  
        assertEquals(0, requestCacheStats.getEvictions());
        ensureSearchable("index");
        assertAcked(  
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
 * The OpenSearch Contributors require contributions made to  
            }  
        refreshAndWaitForReplication();
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
        );
        }
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));  
        }
            SearchResponse resp = client.prepareSearch("index")  
            pluginInfos.stream().anyMatch(pluginInfo -> pluginInfo.getName().equals("org.opensearch.cache.EhcacheCachePlugin"))
            assertSearchResponse(resp);
        );  
    }  
        }, 1, TimeUnit.SECONDS);
import java.util.UUID;
import org.opensearch.plugins.PluginInfo;
                .setSettings(
        internalCluster().startNode(
        refreshAndWaitForReplication();  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
                .setMapping("f", "type=date")
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)  
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");  
        assertSearchResponse(srb.get());
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        requestCacheStats = getRequestCacheStats(client, "index");  
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge("index").setFlush(true).get();  
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
                    Settings.builder()  
    }
import org.junit.Assert;  
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        requestCacheStats = getRequestCacheStats(client, "index");
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
                .get();
                .getTotal()
import org.opensearch.common.cache.settings.CacheSettings;
        }
                .indices()
        indexRandom(
        }  
import java.util.List;  
                    CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
                .build()  
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_STORAGE_PATH_KEY;
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();
                .setSettings(
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)  
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
            client.prepareIndex("index").setSource("f", "2014-03-10T00:00:00.000Z"),
                        .get(DISK_STORAGE_PATH_KEY)  
        ensureSearchable("index");
        );
import org.opensearch.action.search.SearchResponse;
            client.admin()
        // cleared up.
import org.opensearch.test.OpenSearchIntegTestCase;  
                .get();  
            return Settings.builder()  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
            if (perQuerySizeInCacheInBytes == -1) {  
                        .getKey(),
        );  
                )  
        // Hits and misses stats shouldn't get cleared up.
        try (NodeEnvironment env = newNodeEnvironment(Settings.EMPTY)) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .get()  
        int numberOfIndexedItems = 2;// randomIntBetween(5, 10);
        }  
            assertThat(bytes, greaterThan(0L));
                .build()
        if (expirationTime == null) {
            client.admin()
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_CACHE_EXPIRE_AFTER_ACCESS_KEY;
    private RequestCacheStats getRequestCacheStats(Client client, String indexName) {  
            indexRandom(true, client.prepareIndex("index").setSource("k" + iterator, "hello" + iterator));
                        .getKey(),
    public void testExplicitCacheClearWithIndicesRequestCache() throws Exception {
            assertTrue(getRequestCacheStats(client, "index").getMemorySizeInBytes() == 0);
            true,  
        int numberOfIndexedItems = randomIntBetween(5, 10);
        assertEquals(0, requestCacheStats.getEvictions());  
        // warm cache (run the exact same request twice)  
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());  
            Settings.builder()
import org.opensearch.cache.store.disk.EhcacheDiskCache;
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
                .prepareCreate("index")  
                )
                        .put("index.refresh_interval", -1)  
        }, 1, TimeUnit.SECONDS);
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());  
public class EhcacheDiskCacheIT extends OpenSearchIntegTestCase {  
        long perQuerySizeInCacheInBytes = -1;
    }
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)  
        ClearIndicesCacheResponse response = client.admin().indices().clearCache(request).get();
        }
        );  
            .stream()
        requestCacheStats = getRequestCacheStats(client, "index");  
                .indices()
                .get();  
import org.opensearch.common.unit.TimeValue;
        return client.admin().indices().prepareStats(indexName).setRequestCache(true).get().getTotal().getRequestCache();
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .get();
    public void testPluginsAreInstalled() {
        );  
    }
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
import org.opensearch.env.NodeEnvironment;
        Client client = client();
            SearchResponse resp = client.prepareSearch("index")
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))  
        }
                        .build()
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_LISTENER_MODE_SYNC_KEY;  
    }
                        .put("index.refresh_interval", -1)  
                    EhcacheDiskCacheSettings.getSettingListForCacheType(CacheType.INDICES_REQUEST_CACHE)
        assertEquals(0, requestCacheStats.getEvictions());  
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {  
    public void testSanityChecksWithIndicesRequestCache() throws Exception {  
        assertBusy(() -> {  
                .indices()
                .setSettings(
        assertSearchResponse(srb.get());
            if (perQuerySizeInCacheInBytes == -1) {
import org.opensearch.transport.client.Client;
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        assertEquals(numberOfIndexedItems, requestCacheStats.getHitCount());
import static org.opensearch.cache.EhcacheDiskCacheSettings.DEFAULT_CACHE_SIZE_IN_BYTES;
                .setRequestCache(true)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
        Assert.assertTrue(
    }  
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        } catch (IOException e) {  
            // All entries should get cleared up.  
            .collect(Collectors.toList());  
                .put(INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), new TimeValue(1))
 *
import java.time.ZoneId;  
                .put(
                // access  
                .setMapping("k", "type=keyword")
                        .put("index.refresh_interval", -1)
        internalCluster().startNode(  
        NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
import java.util.Collection;
        assertEquals(0, requestCacheStats.getHitCount());
            // Explicit refresh should clear up cache entries
import java.util.function.Function;  
                RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");
import static org.opensearch.cache.EhcacheDiskCacheSettings.DISK_MAX_SIZE_IN_BYTES_KEY;
        // build a cacheable search (size=0) and force request-level caching  
                .prepareStats("index")
import org.opensearch.indices.IndicesRequestCache;
            long bytes = client.admin()  
        assertEquals(numberOfIndexedItems, requestCacheStats.getMissCount());
            .addAggregation(
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
@ThreadLeakFilters(filters = { EhcacheThreadLeakFilter.class })
            if (perQuerySizeInCacheInBytes == -1) {
                )
                    EhcacheDiskCache.EhcacheDiskCacheFactory.EHCACHE_DISK_CACHE_NAME  
            // Explicit refresh should clear up cache entries  
        internalCluster().startNode(
        assertEquals(0, requestCacheStats.getHitCount());  
    }
        ensureSearchable("index");  
            client.prepareIndex("index").setSource("f", "2014-05-13T00:00:00.000Z")
                .get()
import java.util.stream.Collectors;
                .get()  
    private Settings defaultSettings(long sizeInBytes, TimeValue expirationTime) {
                    expirationTime  
import org.opensearch.common.cache.CacheType;
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        refreshAndWaitForReplication();  
                .prepareCreate("index")  
            .setSize(0)
import org.opensearch.index.query.QueryBuilders;
                .indices()
                .get()
                        .getKey(),
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;  
        );  
        }
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, "index");  
            assertSearchResponse(resp);
                .setQuery(QueryBuilders.termQuery("k" + iterator, "hello" + iterator))
        Client client = client();
                .getMemorySizeInBytes();
        }
                perQuerySizeInCacheInBytes = requestCacheStats.getMemorySizeInBytes();  
                )
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)  
import java.util.stream.Stream;
import java.util.concurrent.TimeUnit;
                )
                    Settings.builder()  
                .setRequestCache(true)  
        long perQuerySizeInCacheInBytes = -1;
import org.opensearch.action.search.SearchRequestBuilder;
                .setMapping("k", "type=keyword")  
            Settings.builder()
            throw new RuntimeException(e);
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
}  
                    env.nodePaths()[0].indicesPath.toString() + "/" + UUID.randomUUID() + "/request_cache/"
            }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        .getKey(),
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
                .setMapping("k", "type=keyword")  
import org.opensearch.action.search.SearchType;  
        assertEquals(0, requestCacheStats.getHitCount());  
import org.opensearch.common.settings.Settings;  
            expirationTime = TimeValue.MAX_VALUE;  
                .put(
 * compatible open source license.
                .get()
        assertBusy(() -> {
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheResponse;
                .setRequestCache(true)  
        assertAcked(  
        for (int iterator = 0; iterator < numberOfIndexedItems; iterator++) {
        ClearIndicesCacheRequest request = new ClearIndicesCacheRequest("index");
                .getRequestCache()  
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        }, 10, TimeUnit.MILLISECONDS);  
package org.opensearch.cache;
                dateHistogram("histo").field("f")  
        assertEquals(perQuerySizeInCacheInBytes * numberOfIndexedItems, requestCacheStats.getMemorySizeInBytes());
