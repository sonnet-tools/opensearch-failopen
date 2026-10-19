        String index1 = "index1";
        // create second cache entry in index1
        setupIndex(client, index1);  
            // cache cleaner should NOT have cleaned from index 1
        });
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
            if (stat.getNode().isDataNode()) {
        createCacheEntry(client, index1, "hello");  
        Client client = client(node);
        }  
            Arrays.asList(requestCacheStats.getHitCount(), requestCacheStats.getMissCount(), requestCacheStats.getEvictions())
        // sleep until cache cleaner would have cleaned up the stale key from index2
        // create first cache entry in index1  
            client.admin()
        assertCacheState(client, index1, 0, 2);
            .actionGet()
        });
        assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());  
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
    }
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
    }  
    }
            // assert the memory size of index1 to only contain 1 entry added after flushAndRefresh
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;  
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();  
            Settings.builder()  
        assertCacheState(client, index2, 0, 1);  
        );  
 *
    }  
        // create first cache entry in index2
        // assert cache is empty for index2
        return client.admin()
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        assertEquals(1, getSegmentCount(client, index1));  
            .indices()
            // cache cleaner should have cleaned up the stale key from index 2
            assertEquals(1, getSegmentCount(client, index1));  
        assertCacheState(client, index1, 0, 1);
            // cache cleaner should NOT have cleaned from index 1  
        assertEquals(0, getNodeCacheStats(client).getMemorySizeInBytes());
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.10)
        refreshAndWaitForReplication();
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.90)
    }
        assertCacheState(client, index2, 0, 1);  
        String node = internalCluster().startNode(
            createCacheEntry(client, index1, "hello" + i);
        indexRandom(false, client.prepareIndex(index1).setId("1").setSource("d", "hello"));
import org.opensearch.index.MergePolicyProvider;
                )
 * ownership. Elasticsearch licenses this file to you under  
        assertCacheState(client, index, 1, 1);  
    }
        // create first cache entry in index1  
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));  
    }
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);  
        // create first cache entry in index2
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
        assertCacheState(client, index1, 0, 1);
            .size();
        // create first cache entry in index2  
        assertTrue(memorySizeForIndex1 > 0);
        forceMerge(client, index);  
        setupIndex(client, index2);
            Settings.builder().put(INDICES_CACHE_CLEANUP_INTERVAL_SETTING_KEY, TimeValue.timeValueMillis(cacheCleanIntervalInMillis))
    public void testStaleKeysRemovalWithoutExplicitThreshold() throws Exception {  
        String node = internalCluster().startNode(
        createCacheEntry(client, index2, "hello");
        createCacheEntry(client, index1, "hello");
        createCacheEntry(client, index2, "hello");
        assertTrue(finalMemorySizeForIndex1 > 0);
                )
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
 */
    }  
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
            assert (e instanceof IndexClosedException);
        assertEquals(0, getRequestCacheStats(client, index).getMemorySizeInBytes());
 * the Apache License, Version 2.0 (the "License"); you may
                    // Set interval much larger than test timeout to effectively disable it
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.QueryBuilders;  
        Client client = client(node);  
 * under the License.  
        assertCacheState(client, index1, 0, 1);
        setupIndex(client, index2);
import org.opensearch.cluster.metadata.IndexMetadata;
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        setupIndex(client, index);
        String index1 = "index1";  
        // assert there are no entries in the cache for index
        // create first cache entry in index1
    public void testCacheCleanupAfterIndexDeletion() throws Exception {  
import org.opensearch.plugins.Plugin;
        createCacheEntry(client, index1, "there");
        forceMerge(client, index2);
            Settings.builder()  
        Client client = client(node);  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        String index1 = "index1";
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();  
    }
 * Unless required by applicable law or agreed to in writing,
    // when staleness threshold is lower than staleness, it should clean the stale keys from cache
            // cache cleaner should have cleaned up the stale key from index 2
                )
        int cacheCleanIntervalInMillis = 50;
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.10)
        assertAcked(client.admin().indices().prepareClose(index));  
        });
        String index2 = "index2";
    }
        });
            .getShards()
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        // sleep until cache cleaner would have cleaned up the stale key from index 2
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)  
import org.opensearch.index.IndexSettings;  
import org.opensearch.action.search.SearchResponse;
        assertTrue(getRequestCacheStats(client, index1).getMemorySizeInBytes() > memorySizeForIndex1);
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();  
        // Explicit refresh would invalidate cache
        resp = client.prepareSearch(index).setRequestCache(true).setQuery(QueryBuilders.termQuery("k", "hello")).get();
        assertBusy(() -> {
        assertTrue(getRequestCacheStats(client, index).getMemorySizeInBytes() > 0);
                .put(
        assertCacheState(client, index, 0, 1);
                    TimeValue.timeValueDays(1)  
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)  
        String node = internalCluster().startNode(
        });
                .put(
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());  
            updateSettingsRequest.persistentSettings(  
import org.opensearch.test.OpenSearchIntegTestCase;  
 * software distributed under the License is distributed on an
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .get(0)
 * specific language governing permissions and limitations
        assertCacheState(client, index1, 0, 2);
        String index = "index";
        } catch (Exception e) {
/*  
        Client client = client(node);
        });  
        });  
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
        assertBusy(() -> {  
        String node = internalCluster().startNode(
        ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest(index2);
    public void testStaleKeysCleanupWithMultipleIndices() throws Exception {
    private void createCacheEntry(Client client, String index, String value) {
        );  
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        );
        // create second cache entry in index1  
        // Update indices.requests.cache.cleanup.staleness_threshold to "10%"  
        String index2 = "index2";
import static org.opensearch.indices.IndicesService.INDICES_CACHE_CLEANUP_INTERVAL_SETTING_KEY;
        assertBusy(() -> {
                )
        // delete index  
            .getShards()[0].getSegments()  
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        // create first cache entry in index2  
    // deleting the Index after caching will clean up from Indices Request Cache
        // create first cache entry in index1
        assertThrows("Ratio should be in [0-1.0]", IllegalArgumentException.class, () -> {
        // create second cache entry in index1  
                )
        long memorySizeForIndex1With1Entries = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        createCacheEntry(client, index1, "hello");
            assertEquals(1, getSegmentCount(client, index1));
 *  
            // cache cleaner should have cleaned up the stale key from index 2  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
        assertBusy(() -> {
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
        // sleep until cache cleaner would have cleaned up the stale key from index 2  
 * this file be licensed under the Apache-2.0 license or a
        Client client = client(node);
        assertEquals(0, getNodeCacheStats(client).getMemorySizeInBytes());
        forceMerge(client, index2);
            Settings.builder()
        setupIndex(client, index1);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            .segments(new IndicesSegmentsRequest(indexName))  
        // sleep until cache cleaner would have cleaned up the stale key from index 2
        // sleep until cache cleaner would have cleaned up the stale key from index 2  
        );  
        setupIndex(client, index2);
        SearchResponse resp = client.prepareSearch(index).setRequestCache(true).setQuery(QueryBuilders.termQuery("k", value)).get();
            // assert segment counts stay the same  
        assertCacheState(client, index2, 0, 1);
        setupIndex(client, index);  
    public void testCacheWithInvalidation() throws Exception {  
        setupIndex(client, index1);  
            // cache cleaner should have only cleaned up the stale entities for index1
        String index = "index";
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        assertCacheState(client, index1, 0, 2);
        assertTrue(getRequestCacheStats(client, index).getMemorySizeInBytes() > 0);  
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));  
        // request cache stats cannot be access since Index should be deleted
    // when staleness threshold is lower than staleness, it should clean the cache from all indices having stale keys
        assertCacheState(client, index2, 0, 1);  
        createCacheEntry(client, index1, "there");
        assertCacheState(client, index1, 0, 2);
                .put(
    private static void assertCacheState(Client client, String index, long expectedHits, long expectedMisses) {
        assertCacheState(client, index1, 0, 2);  
            // assert segment counts stay the same
            // cache cleaner should NOT have cleaned up the stale key from index 2
        int cacheCleanIntervalInMillis = 1;  
        createCacheEntry(client, index1, "there");  
        flushAndRefresh(index2);
    public void testCacheClearanceAfterIndexClosure() throws Exception {
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
        forceMerge(client, index2);  
        assertTrue(memorySizeForIndex1With2Entries > memorySizeForIndex1With1Entries);  
                )
        String index2 = "index2";  
        assertSearchResponse(resp);
        assertCacheState(client, index1, 0, 1);  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * license agreements. See the NOTICE file distributed with
        NodesStatsResponse stats = client.admin().cluster().prepareNodesStats().execute().actionGet();
        String index2 = "index2";  
        // create first cache entry in index2
        // assert segment counts stay the same
        assertCacheState(client, index, 1, 2);
        });
    // staleness threshold updates flows through to the cache cleaner  
        String node = internalCluster().startNode(
                    Settings.builder()
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
        String index2 = "index2";  
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);  
                .put(
        assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
            Settings.builder()  
        );  
        try {
                        // Disable background segment merges invalidating the cache
        // create first cache entry in index1
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
        // create 10 index1 cache entries
        // create first cache entry in index2
        assertTrue(memorySizeForIndex1 > 0);
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
 */  
        return null;
            // cache cleaner should NOT have cleaned from index 1  
        // create first cache entry in index2
import org.opensearch.index.cache.request.RequestCacheStats;
        String index1 = "index1";  
            assertEquals(1, getSegmentCount(client, index1));  
            assertCacheState(client, index1, 0, i);
 * The OpenSearch Contributors require contributions made to  
                )  
            Settings.builder()  
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
        setupIndex(client, index1);  
        assertBusy(() -> {
            assertEquals(2, getSegmentCount(client, index1));
            assertEquals(2, getSegmentCount(client, index2));  
        setupIndex(client, index2);
    public void testCacheCleanupSkipsWithHighStalenessThreshold() throws Exception {  
        // sleep until cache cleaner would have cleaned up the stale key from index  
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
        // sleep until cache cleaner would have cleaned up the stale key from index 2
        assertBusy(() -> {  
        assertSearchResponse(resp);
            // cache cleaner should NOT have cleaned from index 1
        assertCacheState(client, index1, 0, 2);  
        Client client = client(node);  
 * compatible open source license.
    // calling cache clear api, when staleness threshold is lower than staleness, it should clean the stale keys from cache
            // cache cleaner should NOT have cleaned up the stale key from index 2
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
        ensureSearchable(index);
            // cache cleaner should have cleaned up the stale keys from index
        });
        // force refresh so that it creates 1 stale key
            client().admin().cluster().updateSettings(updateSettingsRequest).actionGet();  
        String node = internalCluster().startNode(
        String node = internalCluster().startNode(
        // create first cache entry in index2  
        createCacheEntry(client, index2, "hello");
        assertBusy(() -> { assertEquals(0, getRequestCacheStats(client, index1).getMemorySizeInBytes()); });
        String node = internalCluster().startNode(  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
        );
        setupIndex(client, index1);
        // create second cache entry in index1
        resp = client.prepareSearch(index).setRequestCache(true).setQuery(QueryBuilders.termQuery("k", "hello")).get();  
        createCacheEntry(client, index1, "there");
        assertSearchResponse(resp);  
        String index2 = "index2";
        for (int i = 1; i <= 10; i++) {
        for (NodeStats stat : stats.getNodes()) {  
 * GitHub history for details.
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
        SearchResponse resp = client.prepareSearch(index).setRequestCache(true).setQuery(QueryBuilders.termQuery("k", "hello")).get();
        // assert there are no entries in the cache for index
        createCacheEntry(client, index2, "hello");
        // create first cache entry in index  
        assertTrue(memorySizeForIndex1 > 0);
        // cache cleaner should have cleaned up the stale key from index 2
                .put(
            assertEquals(2, getSegmentCount(client, index2));
        assertTrue(memorySizeForIndex1With1Entries > 0);  
            long cacheSizeAfter = getRequestCacheStats(client, index1).getMemorySizeInBytes();  
            assertEquals(2, getSegmentCount(client, index2));  
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,  
        createCacheEntry(client, index2, "hello");
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
                .indices()  
        assertCacheState(client, index1, 0, 1);  
        Client client = client(node);  
        String index1 = "index1";
    // when staleness threshold is explicitly set to 0, cache cleaner regularly cleans up stale keys.
        forceMerge(client, index2);
        createCacheEntry(client, index2, "hello");
    }
        // sleep until cache cleaner would have cleaned up the stale key from index
        // create second cache entry in index1
        assertTrue(getNodeCacheStats(client).getMemorySizeInBytes() > 0);
import org.opensearch.common.unit.TimeValue;
    }
        String node = internalCluster().startNode(
        updateSettingsRequest.persistentSettings(Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), 0.10));
        setupIndex(client, index2);
        int cacheCleanIntervalInMillis = 100;
        setupIndex(client, index);  
        ensureSearchable(index);
        // create first cache entry in index
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        indexRandom(false, client.prepareIndex(index).setSource("k", "hello"));  
        String index2 = "index2";
package org.opensearch.indices;
        createCacheEntry(client, index1, "hello");
        assertCacheState(client, index1, 0, 1);  
        assertEquals(0, getRequestCacheStats(client, index).getMemorySizeInBytes());  
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());  
        assertThat(resp.getHits().getTotalHits().value(), equalTo(1L));
            assertEquals(1, getSegmentCount(client, index1));
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        assertTrue(memorySizeForIndex1 > 0);  
        String node = internalCluster().startNode(  
        assertCacheState(client, index2, 0, 1);
        createCacheEntry(client, index2, "hello");
        assertBusy(() -> {  
            assertEquals(2, getSegmentCount(client, index2));
    private void setupIndex(Client client, String index) throws Exception {  
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();  
            long cacheSizeBefore = getRequestCacheStats(client, index1).getMemorySizeInBytes();  
            Settings.builder()
        assertEquals(1, getSegmentCount(client, index));  
            Settings.builder()
                .get()
    // when staleness threshold is equal to staleness, it should clean the stale keys from cache
        int cacheCleanIntervalInMillis = 1;
        // request cache stats cannot be access since Index should be closed
        // invalidate the cache for index1  
        createCacheEntry(client, index1, "hello");  
            // cache cleaner should NOT have cleaned from index 1  
            // cache cleaner should have cleaned up the stale key from index 2
        assertBusy(() -> {  
 * KIND, either express or implied.  See the License for the
            }  
        try {  
        }
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,  
import org.opensearch.index.IndexNotFoundException;
/*  
            assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);  
        // Index but don't refresh
    }
                .put(
            assert (e instanceof IndexNotFoundException);  
 * Modifications Copyright OpenSearch Contributors. See
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));  
        setupIndex(client, index1);
        assertAcked(client.admin().indices().prepareDelete(index));
        forceMerge(client, index1);
        assertCacheState(client, index2, 0, 1);
    public void testCacheCleanupWithDefaultSettings() throws Exception {
        String index2 = "index2";  
        Client client = client(node);
        assertTrue(memorySizeForIndex1 > 0);
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        client.admin().indices().clearCache(clearIndicesCacheRequest).actionGet();  
    @Override
        OpenSearchAssertions.assertAllSuccessful(resp);
        createCacheEntry(client, index1, "there");
            // cache cleaner should NOT have cleaned from index 1
            getRequestCacheStats(client, index);  
import static org.hamcrest.Matchers.equalTo;
        // Check the hit count and miss count together so if they are not  
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();  
        forceMerge(client, index);  
        // assert segment counts stay the same
        assertSearchResponse(resp);
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))  
        String index2 = "index2";
            // cache cleaner should have cleaned up the stale key from index2 and hence cache should be empty  
            assertEquals(memorySizeForIndex1With1Entries, currentMemorySizeInBytesForIndex1);
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)  
        int cacheCleanIntervalInMillis = 10;  
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
                )
                        // Disable index refreshing to avoid cache being invalidated mid-test
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        );
        int cacheCleanIntervalInMillis = 1;
        String node = internalCluster().startNode(
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
            assertEquals(1, getSegmentCount(client, index2));  
        createCacheEntry(client, index1, "there");
        String index = "index";
            assertTrue(cacheSizeAfter > cacheSizeBefore);
    }
import java.util.Arrays;
    private void forceMerge(Client client, String index) {
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);  
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.90)
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();  
    }
    }  
import org.opensearch.transport.client.Client;
            assertEquals(2, getSegmentCount(client, index2));
        // force refresh so that it creates 1 stale key  
        createCacheEntry(client, index1, "hello");
 * You may obtain a copy of the License at  
        forceMerge(client, index2);
        createCacheEntry(client, index2, "hello");
    public void testCacheClearAPIRemovesStaleKeysWhenStalenessThresholdIsLow() throws Exception {
 */  
            assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
        int cacheCleanIntervalInMillis = 1;
        // sleep until cache cleaner would have cleaned up the stale key from index 2
    // when staleness threshold is higher than staleness, it should NOT clean the cache
        // create second cache entry in index1
        // Assert cache is cleared up  
        setupIndex(client, index2);  
            // assert segment counts stay the same
 * not use this file except in compliance with the License.
        assertCacheState(client, index2, 0, 1);  
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
        createCacheEntry(client, index2, "hello");
        String index1 = "index1";
        // create first cache entry in index1  
            // cache cleaner should have cleaned up the stale keys from index  
        createCacheEntry(client, index, "hello");
        setupIndex(client, index1);  
    }
        assertTrue(memorySizeForIndex1 > 0);
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
        createCacheEntry(client, index1, "there");  
        setupIndex(client, index2);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            assertEquals(2, getSegmentCount(client, index2));
            assertEquals(2, getSegmentCount(client, index2));
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,  
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
            .get(indexName)  
    public void testCacheCleanupOnEqualStalenessAndThreshold() throws Exception {
        forceMerge(client, index2);
        createCacheEntry(client, index, "hello");  
                Settings.builder().put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 10)
        // sleep until cache cleaner would have cleaned up the stale key from index 2
        // create 1 stale key
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
        Client client = client(node);
        // create second cache entry in index1
            // cache cleaner should NOT have cleaned from index 1
                )
        createCacheEntry(client, index1, "hello");
            assertEquals(0, getNodeCacheStats(client).getMemorySizeInBytes());  
        String index1 = "index1";
            assertEquals(1, getSegmentCount(client, index1));
        } catch (Exception e) {
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
        // create another cache entry in index 1 same as memorySizeForIndex1With1Entries, this should not be cleaned up.
        return client.admin().indices().prepareStats(index).setRequestCache(true).get().getTotal().getRequestCache();
        refreshAndWaitForReplication();
        );
        // create 1 stale key
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.10)
        // cache cleaner should NOT have cleaned from index 1
    // when cache cleaner interval setting is not set, cache cleaner is configured appropriately with the fall-back setting
        // create 1 stale key  
    public void testDynamicStalenessThresholdUpdate() throws Exception {
            // assert segment counts stay the same
        // Hit same query again  
        assertAcked(
            long currentMemorySizeInBytesForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();  
        assertCacheState(client, index2, 0, 1);  
        assertCacheState(client, index, 0, 1);
        int cacheCleanIntervalInMillis = 1;
        createCacheEntry(client, index1, "hello");
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
import static org.opensearch.indices.IndicesRequestCache.INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING;
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
                .put(  
        String index1 = "index1";
            assertEquals(0, getNodeCacheStats(client).getMemorySizeInBytes());
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);  
            Settings.builder()  
        indexRandom(false, client.prepareIndex(index).setSource("k", "there"));
        );  
        Client client = client(node);
        // Update indices.requests.cache.cleanup.staleness_threshold to "10%" with illegal argument  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
            // assert segment counts stay the same  
        // create first cache entry in index1
        OpenSearchAssertions.assertAllSuccessful(resp);  
        // correct we can see both values
        // close index
            // assert segment counts stay the same
            );
        // assert there are no entries in the cache from other indices in the node
    // when staleness threshold is not explicitly set, cache cleaner regularly cleans up stale keys
    // closing the Index after caching will clean up from Indices Request Cache
                        .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
        // assert cache is empty for index1  
            assertEquals(1, getSegmentCount(client, index1));
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);  
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
        // create 1 stale key
        // create first cache entry in index1
        assertTrue(getNodeCacheStats(client).getMemorySizeInBytes() > 0);  
        createCacheEntry(client, index1, "hello");
    }  
        Client client = client(node);
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
                return stat.getIndices().getRequestCache();
 * Licensed to Elasticsearch under one or more contributor  
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
    }
        createCacheEntry(client, index1, "there");
        return Arrays.asList(InternalSettingsPlugin.class);  
            assertEquals(1, getSegmentCount(client, index1));
        assertCacheState(client, index1, 0, 1);
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,  
        assertBusy(() -> {
                )
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());  
        );
        assertEquals(1, getSegmentCount(client, index2));
        assertTrue(memorySizeForIndex1 > 0);
        // Should expect hit as here as refresh didn't happen
        // create second cache entry in index1  
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge(index).setFlush(true).get();
        assertEquals(
        setupIndex(client, index2);
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.10)  
        setupIndex(client, index1);
        );
            getRequestCacheStats(client, index);
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());  
        int cacheCleanIntervalInMillis = 1;  
        Client client = client();
        // invalidate the cache for index2  
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0)
                .setMapping("k", "type=keyword")
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.10)  
public class IndicesRequestCacheCleanupIT extends OpenSearchIntegTestCase {
        assertCacheState(client, index2, 0, 1);
import org.opensearch.common.settings.Settings;  
                .put(  
        // assert there are no entries in the cache from other indices in the node  
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        assertBusy(() -> {
    public void testInvalidStalenessThresholdUpdateThrowsException() throws Exception {
    private int getSegmentCount(Client client, String indexName) {  
            Settings.builder()
import org.opensearch.test.InternalSettingsPlugin;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertEquals(0, getRequestCacheStats(client, index1).getMemorySizeInBytes());
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, index);
    public void testStaleKeysCleanupWithLowThreshold() throws Exception {  
        forceMerge(client, index2);
                .put(
    // staleness threshold dynamic updates should throw exceptions on invalid input
        // create first cache entry in index2  
                )  
        indexRandom(false, client.prepareIndex(index).setSource("k", "hello2"));
}
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
        });  
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.33)  
        assertCacheState(client, index1, 0, 2);  
        }
import java.util.Collection;
        assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());  
        }
        });
                .put(
            .getIndices()
            // assert segment counts stay the same
        setupIndex(client, index2);
        int cacheCleanIntervalInMillis = 100;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
                .prepareCreate(index)
    }  
    private static RequestCacheStats getRequestCacheStats(Client client, String index) {  
            // cache cleaner should have cleaned up the stale key from index 2
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
        long memorySizeForIndex1With2Entries = getRequestCacheStats(client, index1).getMemorySizeInBytes();
            Arrays.asList(expectedHits, expectedMisses, 0L),  
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)  
        });
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
        assertBusy(() -> {
    public void testCacheCleanupOnZeroStalenessThreshold() throws Exception {  
            Settings.builder()
 * this work for additional information regarding copyright
        String index1 = "index1";
        );
    }
        // create 1 stale key  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
    private static RequestCacheStats getNodeCacheStats(Client client) {
        assertCacheState(client, index, 0, 1);  
/*
            // cache cleaner should have cleaned up the stale key from index 2  
        setupIndex(client, index1);
                .setSettings(  
        assertCacheState(client, index1, 0, 2);
        assertCacheState(client, index1, 0, 1);
        // Should expect miss as key has changed due to change in IndexReader.CacheKey (due to refresh)  
