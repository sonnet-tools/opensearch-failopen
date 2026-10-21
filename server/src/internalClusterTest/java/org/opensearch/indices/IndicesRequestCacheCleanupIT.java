        assertBusy(() -> {
    // calling cache clear api, when staleness threshold is lower than staleness, it should clean the stale keys from cache
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        // create second cache entry in index1
        // sleep until cache cleaner would have cleaned up the stale key from index
    }
        forceMerge(client, index2);
        createCacheEntry(client, index1, "hello");
        int cacheCleanIntervalInMillis = 100;
                )
        assertTrue(getRequestCacheStats(client, index1).getMemorySizeInBytes() > memorySizeForIndex1);
            Settings.builder()
    // when staleness threshold is higher than staleness, it should NOT clean the cache
        Client client = client(node);
    }
        String node = internalCluster().startNode(
        // create first cache entry in index1
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
    public void testCacheClearanceAfterIndexClosure() throws Exception {
        SearchResponse resp = client.prepareSearch(index).setRequestCache(true).setQuery(QueryBuilders.termQuery("k", value)).get();
        createCacheEntry(client, index2, "hello");
            assertEquals(1, getSegmentCount(client, index1));
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
            long cacheSizeBefore = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        // create second cache entry in index1
            assertEquals(1, getSegmentCount(client, index1));
            // cache cleaner should NOT have cleaned from index 1
        }
        );
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
            // cache cleaner should have cleaned up the stale key from index 2
        assertBusy(() -> {
        resp = client.prepareSearch(index).setRequestCache(true).setQuery(QueryBuilders.termQuery("k", "hello")).get();
        createCacheEntry(client, index1, "there");
        assertBusy(() -> {
        assertTrue(memorySizeForIndex1 > 0);
        // force refresh so that it creates 1 stale key
import org.opensearch.transport.client.Client;
        assertAcked(
            updateSettingsRequest.persistentSettings(
        // sleep until cache cleaner would have cleaned up the stale key from index 2
        // create first cache entry in index2
        String index2 = "index2";
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
        });
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
            assertEquals(2, getSegmentCount(client, index2));
            // assert segment counts stay the same
        assertCacheState(client, index2, 0, 1);
import org.opensearch.plugins.Plugin;
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        setupIndex(client, index);
        createCacheEntry(client, index1, "hello");
                .put(
 * under the License.
        Client client = client(node);
                .put(
            .getShards()
        // sleep until cache cleaner would have cleaned up the stale key from index2
        // assert cache is empty for index2
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
        createCacheEntry(client, index2, "hello");
                        .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
        // Should expect miss as key has changed due to change in IndexReader.CacheKey (due to refresh)
        );
        createCacheEntry(client, index1, "hello");
            // cache cleaner should have cleaned up the stale keys from index
        createCacheEntry(client, index1, "hello");
        String node = internalCluster().startNode(
        setupIndex(client, index1);
        setupIndex(client, index1);
import org.opensearch.common.settings.Settings;
        forceMerge(client, index2);
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
    }
        });
        setupIndex(client, index1);
        // create first cache entry in index2
import org.opensearch.index.MergePolicyProvider;
    // deleting the Index after caching will clean up from Indices Request Cache
        String node = internalCluster().startNode(
        // assert there are no entries in the cache for index
        assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
    public void testStaleKeysRemovalWithoutExplicitThreshold() throws Exception {
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMillis(-1))
        // sleep until cache cleaner would have cleaned up the stale key from index 2
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.33)
        assertEquals(
        assertBusy(() -> {
            .getIndices()
        flushAndRefresh(index2);
        Client client = client(node);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            }
        assertBusy(() -> {
                .put(
            assertEquals(1, getSegmentCount(client, index1));
        try {
import java.util.Arrays;
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        });
            // cache cleaner should have cleaned up the stale key from index 2
        // Index but don't refresh
            // assert the memory size of index1 to only contain 1 entry added after flushAndRefresh
    public void testInvalidStalenessThresholdUpdateThrowsException() throws Exception {
            // cache cleaner should NOT have cleaned from index 1
        // Update indices.requests.cache.cleanup.staleness_threshold to "10%"
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .segments(new IndicesSegmentsRequest(indexName))
        // Assert cache is cleared up
        // create first cache entry in index1
                .put(
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.indices;
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
 *
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        assertCacheState(client, index2, 0, 1);
import java.util.Collection;
                    Settings.builder()
        assertCacheState(client, index1, 0, 1);
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        // create first cache entry in index1
        assertCacheState(client, index1, 0, 2);
 */
    }
            assertEquals(2, getSegmentCount(client, index2));
        createCacheEntry(client, index1, "hello");
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0)
        );
        assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
            assert (e instanceof IndexNotFoundException);
        // sleep until cache cleaner would have cleaned up the stale key from index
        assertCacheState(client, index1, 0, 2);
        assertEquals(0, getRequestCacheStats(client, index1).getMemorySizeInBytes());
        // create first cache entry in index2
        try {
    }
        forceMerge(client, index2);
        Client client = client(node);
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
        );
 * software distributed under the License is distributed on an
        } catch (Exception e) {
        long memorySizeForIndex1With2Entries = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        createCacheEntry(client, index2, "hello");
                .indices()
        assertBusy(() -> {
        setupIndex(client, index2);
import org.opensearch.index.query.QueryBuilders;
        Client client = client(node);
        long memorySizeForIndex1With1Entries = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        return client.admin().indices().prepareStats(index).setRequestCache(true).get().getTotal().getRequestCache();
                )
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
        assertCacheState(client, index2, 0, 1);
        assertSearchResponse(resp);
        String index1 = "index1";
        forceMerge(client, index);
            createCacheEntry(client, index1, "hello" + i);
        });
        assertCacheState(client, index2, 0, 1);
            assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
        assertCacheState(client, index, 1, 2);
                Settings.builder().put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 10)
        int cacheCleanIntervalInMillis = 10;
                )
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
            assertCacheState(client, index1, 0, i);
        String index = "index";
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
        // create first cache entry in index2
            Settings.builder().put(INDICES_CACHE_CLEANUP_INTERVAL_SETTING_KEY, TimeValue.timeValueMillis(cacheCleanIntervalInMillis))
import org.opensearch.index.IndexNotFoundException;
        assertCacheState(client, index1, 0, 1);
        // create first cache entry in index1
import org.opensearch.index.cache.request.RequestCacheStats;
        });
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        forceMerge(client, index2);
        assertBusy(() -> {
            getRequestCacheStats(client, index);
        assertTrue(memorySizeForIndex1 > 0);
/*
        String index = "index";
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
        OpenSearchAssertions.assertAllSuccessful(resp);
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        assertTrue(memorySizeForIndex1 > 0);
            // cache cleaner should have cleaned up the stale key from index2 and hence cache should be empty
            Settings.builder()
                )
            assertEquals(0, getNodeCacheStats(client).getMemorySizeInBytes());
        assertBusy(() -> {
            assertEquals(2, getSegmentCount(client, index2));
                return stat.getIndices().getRequestCache();
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                    // Set interval much larger than test timeout to effectively disable it
            assertEquals(2, getSegmentCount(client, index2));
        ensureSearchable(index);
        // cache cleaner should NOT have cleaned from index 1
        // create first cache entry in index2
        assertBusy(() -> {
        // create second cache entry in index1
        // sleep until cache cleaner would have cleaned up the stale key from index 2
        assertBusy(() -> { assertEquals(0, getRequestCacheStats(client, index1).getMemorySizeInBytes()); });
        assertCacheState(client, index1, 0, 1);
        // create first cache entry in index
            assertEquals(1, getSegmentCount(client, index1));
        assertAcked(client.admin().indices().prepareDelete(index));
 *
        });
            // assert segment counts stay the same
        assertCacheState(client, index1, 0, 2);
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.90)
    private int getSegmentCount(Client client, String indexName) {
        setupIndex(client, index1);
        int cacheCleanIntervalInMillis = 1;
        return null;
        }
            Arrays.asList(requestCacheStats.getHitCount(), requestCacheStats.getMissCount(), requestCacheStats.getEvictions())
        // create 1 stale key
import org.opensearch.test.OpenSearchIntegTestCase;
        createCacheEntry(client, index1, "hello");
        setupIndex(client, index2);
        refreshAndWaitForReplication();
        assertTrue(memorySizeForIndex1With1Entries > 0);
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
 * this work for additional information regarding copyright
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        assertCacheState(client, index2, 0, 1);
        OpenSearchAssertions.assertAllSuccessful(forceMergeResponse);
        createCacheEntry(client, index, "hello");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        String index2 = "index2";
    // when staleness threshold is lower than staleness, it should clean the cache from all indices having stale keys
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
import org.opensearch.common.unit.TimeValue;
        createCacheEntry(client, index2, "hello");
    }
        );
            assertEquals(1, getSegmentCount(client, index2));
            .indices()
        // invalidate the cache for index2
    }
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
        assertCacheState(client, index1, 0, 2);
        Client client = client(node);
            assertEquals(2, getSegmentCount(client, index1));
        setupIndex(client, index1);
    public void testCacheWithInvalidation() throws Exception {
    // when cache cleaner interval setting is not set, cache cleaner is configured appropriately with the fall-back setting
        ClearIndicesCacheRequest clearIndicesCacheRequest = new ClearIndicesCacheRequest(index2);
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.10)
        int cacheCleanIntervalInMillis = 1;
        // create 1 stale key
        setupIndex(client, index2);
 * KIND, either express or implied.  See the License for the
        assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
        int cacheCleanIntervalInMillis = 1;
        Client client = client(node);
        assertCacheState(client, index1, 0, 2);
        );
        });
        // create first cache entry in index2
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            assertEquals(2, getSegmentCount(client, index2));
            // cache cleaner should NOT have cleaned up the stale key from index 2
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
            // assert segment counts stay the same
        // request cache stats cannot be access since Index should be closed
    private static void assertCacheState(Client client, String index, long expectedHits, long expectedMisses) {
        String index1 = "index1";
        // create 10 index1 cache entries
import org.opensearch.index.IndexSettings;
        assertSearchResponse(resp);
        forceMerge(client, index2);
            .actionGet()
        assertCacheState(client, index, 0, 1);
        );
        String index1 = "index1";
        assertBusy(() -> {
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
        setupIndex(client, index);
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        // create second cache entry in index1
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
 * compatible open source license.
            assertEquals(memorySizeForIndex1With1Entries, currentMemorySizeInBytesForIndex1);
        setupIndex(client, index1);
        // create second cache entry in index1
    // closing the Index after caching will clean up from Indices Request Cache
        // create first cache entry in index
        createCacheEntry(client, index1, "there");
 * You may obtain a copy of the License at
        SearchResponse resp = client.prepareSearch(index).setRequestCache(true).setQuery(QueryBuilders.termQuery("k", "hello")).get();
    }
        assertCacheState(client, index2, 0, 1);
            assertTrue(cacheSizeAfter > cacheSizeBefore);
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
        // create second cache entry in index1
        indexRandom(false, client.prepareIndex(index).setSource("k", "there"));
        // Should expect hit as here as refresh didn't happen
                .put(
        createCacheEntry(client, index1, "there");
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
            .get(0)
            if (stat.getNode().isDataNode()) {
        String node = internalCluster().startNode(
        assertTrue(getRequestCacheStats(client, index).getMemorySizeInBytes() > 0);
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
    public void testCacheClearAPIRemovesStaleKeysWhenStalenessThresholdIsLow() throws Exception {
        // cache cleaner should have cleaned up the stale key from index 2
        indexRandom(false, client.prepareIndex(index1).setId("1").setSource("d", "hello"));
 * Modifications Copyright OpenSearch Contributors. See
            client.admin()
 * specific language governing permissions and limitations
        setupIndex(client, index2);
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
        String index1 = "index1";
        String index2 = "index2";
            // cache cleaner should have cleaned up the stale keys from index
        });
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
            Settings.builder()
            Settings.builder()
            Settings.builder()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
        // assert there are no entries in the cache for index
                    TimeValue.timeValueDays(1)
                .put(
                )
            Arrays.asList(expectedHits, expectedMisses, 0L),
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
        RequestCacheStats requestCacheStats = getRequestCacheStats(client, index);
        assertEquals(0, getRequestCacheStats(client, index).getMemorySizeInBytes());
        // Force merge the index to ensure there can be no background merges during the subsequent searches that would invalidate the cache
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
            Settings.builder()
import static org.opensearch.indices.IndicesRequestCache.INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING;
            Settings.builder()
        );
        // create 1 stale key
        // create first cache entry in index1
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
                )
        assertCacheState(client, index1, 0, 2);
        Client client = client();
            assertEquals(1, getSegmentCount(client, index1));
        client.admin().indices().clearCache(clearIndicesCacheRequest).actionGet();
import org.opensearch.cluster.metadata.IndexMetadata;
 *
        int cacheCleanIntervalInMillis = 1;
            // cache cleaner should NOT have cleaned from index 1
        createCacheEntry(client, index2, "hello");
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.90)
            assertEquals(1, getSegmentCount(client, index1));
        setupIndex(client, index2);
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.10)
        int cacheCleanIntervalInMillis = 100;
    // when staleness threshold is lower than staleness, it should clean the stale keys from cache
        });
    private static RequestCacheStats getNodeCacheStats(Client client) {
            .getShards()[0].getSegments()
        return client.admin()
        createCacheEntry(client, index1, "hello");
        assertTrue(memorySizeForIndex1 > 0);
        // request cache stats cannot be access since Index should be deleted
        // sleep until cache cleaner would have cleaned up the stale key from index 2
        String index1 = "index1";
        String index2 = "index2";
        assertEquals(0, getRequestCacheStats(client, index).getMemorySizeInBytes());
        assertCacheState(client, index1, 0, 1);
    }
        // Explicit refresh would invalidate cache
        // create first cache entry in index1
        updateSettingsRequest.persistentSettings(Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), 0.10));
            long cacheSizeAfter = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        forceMerge(client, index);
            // cache cleaner should have cleaned up the stale key from index 2
        // assert segment counts stay the same
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
        String node = internalCluster().startNode(
            Settings.builder()
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
        assertCacheState(client, index, 0, 1);
            assertEquals(2, getSegmentCount(client, index2));
        createCacheEntry(client, index1, "hello");
        );
    public void testStaleKeysCleanupWithLowThreshold() throws Exception {
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
            assertEquals(1, getSegmentCount(client, index1));
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
    }
        });
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
    }
        assertCacheState(client, index2, 0, 1);
 * the Apache License, Version 2.0 (the "License"); you may
            // assert segment counts stay the same
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
        Client client = client(node);
        indexRandom(false, client.prepareIndex(index).setSource("k", "hello2"));
public class IndicesRequestCacheCleanupIT extends OpenSearchIntegTestCase {
}
    private void createCacheEntry(Client client, String index, String value) {
        // assert cache is empty for index1
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
        });
    // when staleness threshold is not explicitly set, cache cleaner regularly cleans up stale keys
        assertTrue(finalMemorySizeForIndex1 > 0);
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
        Client client = client(node);
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
        assertTrue(memorySizeForIndex1 > 0);
            // cache cleaner should have cleaned up the stale key from index 2
        String node = internalCluster().startNode(
    }
 * GitHub history for details.
        // sleep until cache cleaner would have cleaned up the stale key from index 2
            );
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
    public void testCacheCleanupWithDefaultSettings() throws Exception {
        String index2 = "index2";
        assertTrue(memorySizeForIndex1With2Entries > memorySizeForIndex1With1Entries);
        createCacheEntry(client, index1, "there");
            // cache cleaner should have cleaned up the stale key from index 2
                )
        setupIndex(client, index);
        });
        forceMerge(client, index2);
            // assert segment counts stay the same
            .get(indexName)
            assertEquals(finalMemorySizeForIndex1, getRequestCacheStats(client, index1).getMemorySizeInBytes());
            // cache cleaner should NOT have cleaned from index 1
    }
        setupIndex(client, index1);
        assertCacheState(client, index, 1, 1);
        // invalidate the cache for index1
        setupIndex(client, index2);
        assertSearchResponse(resp);
            // cache cleaner should have only cleaned up the stale entities for index1
        // create 1 stale key
    public void testStaleKeysCleanupWithMultipleIndices() throws Exception {
    private void forceMerge(Client client, String index) {
                .prepareCreate(index)
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        createCacheEntry(client, index, "hello");
        createCacheEntry(client, index2, "hello");
        assertEquals(1, getSegmentCount(client, index2));
        for (int i = 1; i <= 10; i++) {
        // assert there are no entries in the cache from other indices in the node
                .setSettings(
        );
        createCacheEntry(client, index1, "there");
        assertTrue(memorySizeForIndex1 > 0);
        int cacheCleanIntervalInMillis = 1;
        long finalMemorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
    @Override
        // create first cache entry in index1
                .get()
 * The OpenSearch Contributors require contributions made to
        assertThrows("Ratio should be in [0-1.0]", IllegalArgumentException.class, () -> {
        // Update indices.requests.cache.cleanup.staleness_threshold to "10%" with illegal argument
    private void setupIndex(Client client, String index) throws Exception {
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under
        assertCacheState(client, index1, 0, 2);
        );
            // assert segment counts stay the same
        }
                )
        setupIndex(client, index2);
        // delete index
        assertTrue(getNodeCacheStats(client).getMemorySizeInBytes() > 0);
        forceMerge(client, index2);
        assertCacheState(client, index2, 0, 1);
import org.opensearch.action.search.SearchResponse;
        assertSearchResponse(resp);
        resp = client.prepareSearch(index).setRequestCache(true).setQuery(QueryBuilders.termQuery("k", "hello")).get();
                )
        assertThat(resp.getHits().getTotalHits().value(), equalTo(1L));
    }
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
                .put(
        // create first cache entry in index1
        OpenSearchAssertions.assertAllSuccessful(resp);
            assert (e instanceof IndexClosedException);
            client().admin().cluster().updateSettings(updateSettingsRequest).actionGet();
import static org.hamcrest.Matchers.equalTo;
        // create 1 stale key
        String index2 = "index2";
 */
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
    }
        // sleep until cache cleaner would have cleaned up the stale key from index 2
        assertEquals(0, getNodeCacheStats(client).getMemorySizeInBytes());
        // sleep until cache cleaner would have cleaned up the stale key from index 2
        assertEquals(1, getSegmentCount(client, index));
        createCacheEntry(client, index1, "there");
    // staleness threshold dynamic updates should throw exceptions on invalid input
        String index2 = "index2";
                )
    // when staleness threshold is equal to staleness, it should clean the stale keys from cache
                .put(
            Settings.builder()
        String node = internalCluster().startNode(
        String index1 = "index1";
    }
        assertCacheState(client, index1, 0, 2);
        }
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
        // create another cache entry in index 1 same as memorySizeForIndex1With1Entries, this should not be cleaned up.
    public void testCacheCleanupAfterIndexDeletion() throws Exception {
        assertEquals(0, getNodeCacheStats(client).getMemorySizeInBytes());
    public void testCacheCleanupOnEqualStalenessAndThreshold() throws Exception {
        setupIndex(client, index2);
        // create second cache entry in index1
            long currentMemorySizeInBytesForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        indexRandom(false, client.prepareIndex(index2).setId("1").setSource("d", "hello"));
    }
    public void testCacheCleanupOnZeroStalenessThreshold() throws Exception {
        // create first cache entry in index2
        return Arrays.asList(InternalSettingsPlugin.class);
        // create first cache entry in index2
        createCacheEntry(client, index2, "hello");
        int cacheCleanIntervalInMillis = 50;
    public void testCacheCleanupSkipsWithHighStalenessThreshold() throws Exception {
        setupIndex(client, index1);
                        // Disable background segment merges invalidating the cache
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.10)
 * Licensed to Elasticsearch under one or more contributor
        assertCacheState(client, index1, 0, 1);
        createCacheEntry(client, index1, "hello");
        assertCacheState(client, index, 0, 1);
        assertTrue(getRequestCacheStats(client, index).getMemorySizeInBytes() > 0);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
        indexRandom(false, client.prepareIndex(index).setSource("k", "hello"));
        String index = "index";
                .put(
        setupIndex(client, index2);
        createCacheEntry(client, index2, "hello");
        String node = internalCluster().startNode(
        // close index
        Client client = client(node);
import static org.opensearch.indices.IndicesService.INDICES_CACHE_CLEANUP_INTERVAL_SETTING_KEY;
            // cache cleaner should NOT have cleaned up the stale key from index 2
        String index1 = "index1";
        String index1 = "index1";
    }
        createCacheEntry(client, index1, "there");
    private static RequestCacheStats getRequestCacheStats(Client client, String index) {
        setupIndex(client, index1);
            // assert segment counts stay the same
        assertBusy(() -> {
        int cacheCleanIntervalInMillis = 1;
            // cache cleaner should NOT have cleaned from index 1
        long memorySizeForIndex1 = getRequestCacheStats(client, index1).getMemorySizeInBytes();
        String index2 = "index2";
        ensureSearchable(index);
        assertCacheState(client, index2, 0, 1);
    }
        forceMerge(client, index1);
            // cache cleaner should have cleaned up the stale key from index 2
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // assert segment counts stay the same
        assertCacheState(client, index1, 0, 1);
    }
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
import org.opensearch.test.InternalSettingsPlugin;
        assertTrue(getNodeCacheStats(client).getMemorySizeInBytes() > 0);
        assertEquals(1, getSegmentCount(client, index1));
        // assert there are no entries in the cache from other indices in the node
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
        // correct we can see both values
        assertTrue(memorySizeForIndex1 > 0);
            .size();
    }
            // cache cleaner should NOT have cleaned from index 1
        String index1 = "index1";
        NodesStatsResponse stats = client.admin().cluster().prepareNodesStats().execute().actionGet();
        String index2 = "index2";
        assertCacheState(client, index1, 0, 1);
        // Check the hit count and miss count together so if they are not
        assertTrue(getRequestCacheStats(client, index2).getMemorySizeInBytes() > 0);
    public void testDynamicStalenessThresholdUpdate() throws Exception {
        );
            // cache cleaner should NOT have cleaned from index 1
        String node = internalCluster().startNode(
    // when staleness threshold is explicitly set to 0, cache cleaner regularly cleans up stale keys.
        // force refresh so that it creates 1 stale key
        assertCacheState(client, index1, 0, 1);
                .setMapping("k", "type=keyword")
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.10)
        // Hit same query again
 */
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
            assertEquals(0, getRequestCacheStats(client, index2).getMemorySizeInBytes());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    TimeValue.timeValueMillis(cacheCleanIntervalInMillis)
        assertTrue(finalMemorySizeForIndex1 > memorySizeForIndex1);
    // staleness threshold updates flows through to the cache cleaner
        // create first cache entry in index2
        Client client = client(node);
                    IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
 * license agreements. See the NOTICE file distributed with
            assertEquals(0, getNodeCacheStats(client).getMemorySizeInBytes());
        createCacheEntry(client, index1, "there");
/*
/*
            assertEquals(2, getSegmentCount(client, index2));
 * not use this file except in compliance with the License.
        assertAcked(client.admin().indices().prepareClose(index));
            getRequestCacheStats(client, index);
        String node = internalCluster().startNode(
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_STALENESS_THRESHOLD_SETTING_KEY, 0.10)
        } catch (Exception e) {
                )
        refreshAndWaitForReplication();
            Settings.builder()
        ForceMergeResponse forceMergeResponse = client.admin().indices().prepareForceMerge(index).setFlush(true).get();
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        // create second cache entry in index1
 * Unless required by applicable law or agreed to in writing,
        createCacheEntry(client, index2, "hello");
        for (NodeStats stat : stats.getNodes()) {
import org.opensearch.test.hamcrest.OpenSearchAssertions;
                        // Disable index refreshing to avoid cache being invalidated mid-test
                .put(
        String node = internalCluster().startNode(
