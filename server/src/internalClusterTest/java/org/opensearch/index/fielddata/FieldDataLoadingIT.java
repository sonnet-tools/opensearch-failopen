            createIndex(index, numFieldsPerIndex, fieldPrefix);
        createAndSearchIndices(numIndices, numFieldsPerIndex, indexPrefix, fieldPrefix);
                client().prepareSearch(index).setQuery(new MatchAllQueryBuilder()).addSort(fieldPrefix + j, SortOrder.ASC).get();
                .getMemorySizeInBytes();
        ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().get();
        Map<String, String> source = new HashMap<>();
    }
                    ClearIndicesCacheRequest clearCacheRequest = new ClearIndicesCacheRequest().fieldDataCache(true)
                    client().admin().indices().clearCache(clearCacheRequest).actionGet();
        // Add >N values to the cache and assert the size is less than the limit
            prepareCreate("test").setMapping(
    public void testFieldDataCacheClearConcurrentFields() throws Exception {
        createAndSearchIndices(numIndices, 1, indexPrefix, "field");
import static org.hamcrest.Matchers.greaterThan;
            String index = indexPrefix + i;
            long newCacheSize = client().admin()
                    .startObject("name")
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1ms")
    }
        assertBusy(() -> {
        assertTrue(sizePerEntry > 0);
        // Concurrently clear multiple indices+fields from FD cache
    private void createAndSearchIndices(int numIndices, int numFieldsPerIndex, String indexPrefix, String fieldPrefix) throws Exception {
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
        assert numFieldsPerIndex >= 1;
            ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().get();
 * under the License.
    }
        for (int i = 0; i < numIndices; i++) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.sort.SortOrder;
 * license agreements. See the NOTICE file distributed with
    }
                    countDownLatch.countDown();
        assertTrue(response.getIndicesStats().getFieldData().getMemorySizeInBytes() > 0L);
 * Licensed to Elasticsearch under one or more contributor
 *
                    .field("fielddata", true)
import java.util.HashMap;
        assertBusy(() -> {
 * this work for additional information regarding copyright
                jsonBuilder().startObject()
        client().prepareSearch("index").setQuery(new MatchAllQueryBuilder()).addSort(fieldPrefix + "0", SortOrder.ASC).get();
        // future PR
        }
                    .endObject()
        Thread[] threads = new Thread[numIndices * numFieldsPerIndex];
 * Modifications Copyright OpenSearch Contributors. See
        long sizePerEntry = client().admin().cluster().prepareClusterStats().get().getIndicesStats().getFieldData().getMemorySizeInBytes();
        });
        String indexPrefix = "test";
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * specific language governing permissions and limitations
                .getIndicesStats()
        client().admin().indices().prepareRefresh("test").get();
        assertAcked(
 */
}
    private void createIndex(String index, int numFieldsPerIndex, String fieldPrefix) throws Exception {
        int numIndices = 10;
        ensureGreen();
                .cluster()
 */
        String fieldPrefix = "field";
            .put(super.nodeSettings(nodeOrdinal))
        countDownLatch.await();
        for (int i = 0; i < numIndices; i++) {
        return Settings.builder()
            assertEquals(0, response.getIndicesStats().getFieldData().getMemorySizeInBytes());
 * the Apache License, Version 2.0 (the "License"); you may
            });
        assertBusy(() -> {
import org.opensearch.common.settings.Settings;
import static org.opensearch.indices.fielddata.cache.IndicesFieldDataCache.INDICES_FIELDDATA_CACHE_SIZE_KEY;
        client().prepareIndex("test").setId("1").setSource("name", "name").get();
        });
            ClusterStatsResponse clearedResponse = client().admin().cluster().prepareClusterStats().get();
                int finalJ = j;
    @Override
        Phaser phaser = new Phaser(numIndices + 1);
        client().prepareIndex(index).setId("1").setSource(source).get();
        assertAcked(prepareCreate(index).setMapping(req));
                        throw new RuntimeException(e);
            req.startObject(fieldPrefix + j).field("type", "text").field("fielddata", true).endObject();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            client().prepareSearch("index").setQuery(new MatchAllQueryBuilder()).addSort(fieldPrefix + i, SortOrder.ASC).get();
 * this file be licensed under the Apache-2.0 license or a
                    try {
        CountDownLatch countDownLatch = new CountDownLatch(numIndices);
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        // Put something into the cache and clear it, waiting for stats to return to 0.
                .getFieldData()
        for (int i = 0; i < numIndices; i++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .field("eager_global_ordinals", true)
 */
        int numFieldsPerIndex = 5;
                        client().admin().indices().clearCache(clearCacheRequest).actionGet();
        for (int i = 0; i < numIndices; i++) {
                } catch (Exception e) {
                .prepareClusterStats()
            assertTrue(newCacheSize <= newMaxSize);
                        ClearIndicesCacheRequest clearCacheRequest = new ClearIndicesCacheRequest().fieldDataCache(true)
        ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().get();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
    }
            .build();
        int maxEntries = 10;
        for (int i = 1; i < numFields; i++) {
                    .endObject()
        // Set the max size setting so that it can fit maxEntries such entries
            assertEquals(0, clearedResponse.getIndicesStats().getFieldData().getMemorySizeInBytes());
        Thread[] threads = new Thread[numIndices];
    public void testIndicesFieldDataCacheSizeSetting() throws Exception {
    // To shorten runtimes, set cluster setting INDICES_CACHE_CLEAN_INTERVAL_SETTING to a lower value.
        assertThat(response.getIndicesStats().getFieldData().getMemorySizeInBytes(), greaterThan(0L));
            assertEquals(0, response.getIndicesStats().getFieldData().getMemorySizeInBytes());
        int numIndices = 10;
            for (int j = 0; j < numFieldsPerIndex; j++) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        }
            }
                    phaser.arriveAndAwaitAdvance();
 *
 * compatible open source license.
        String indexPrefix = "test";
        }
            source.put(fieldPrefix + j, "value");
        // Put one value into the cache
        // Check concurrently clearing multiple indices + fields from the FD cache correctly removes all expected keys.
        // Set the max size setting to a smaller value and assert the new size is less than that (waiting for refresh)
package org.opensearch.index.fielddata;
                threads[i * numFieldsPerIndex + j] = new Thread(() -> {
        // Cache size should be 0
 * not use this file except in compliance with the License.
        }
            ClusterStatsResponse clearedResponse = client().admin().cluster().prepareClusterStats().get();
        updateSettingsRequest.persistentSettings(Settings.builder().put(INDICES_FIELDDATA_CACHE_SIZE_KEY.getKey(), maxSize + "b"));
        long newMaxSize = 2 * sizePerEntry + 1;
        countDownLatch.await();
                }
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        long maxSize = maxEntries * sizePerEntry + 1;
 *
                    .field("type", "text")
        client().prepareSearch(index).setQuery(new MatchAllQueryBuilder()).addSort(fieldPrefix + "0", SortOrder.ASC).get();
        Phaser phaser = new Phaser(numIndices * numFieldsPerIndex + 1);
            threads[i].start();
/*
        String fieldPrefix = "field";
            int finalI = i;
        // Index creation temporarily opens + closes a test index using IndicesService.withTempIndexService()
import org.opensearch.test.OpenSearchIntegTestCase;
 * The OpenSearch Contributors require contributions made to
    public void testFieldDataCacheClearConcurrentIndices() throws Exception {
        // Separate loop to ensure createIndex() handles any cache wipe from opening+closing the temporary test index
    }
                        .indices(indexPrefix + finalI);
        client().admin().indices().clearCache(new ClearIndicesCacheRequest().fieldDataCache(true)).actionGet();
                .get()
                            .fields(fieldPrefix + finalJ);
            assertEquals(0, clearedResponse.getIndicesStats().getFieldData().getMemorySizeInBytes());
        phaser.arriveAndAwaitAdvance();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                });
        int numFields = 2 * maxEntries;
/*
import org.opensearch.index.query.MatchAllQueryBuilder;
        long cacheSize = client().admin().cluster().prepareClusterStats().get().getIndicesStats().getFieldData().getMemorySizeInBytes();
/*
        CountDownLatch countDownLatch = new CountDownLatch(numIndices * numFieldsPerIndex);
                    throw new RuntimeException(e);
                try {
        client().admin().indices().clearCache(new ClearIndicesCacheRequest().fieldDataCache(true)).actionGet();
                threads[i * numFieldsPerIndex + j].start();
        });
        assertTrue(cacheSize <= maxSize && cacheSize > sizePerEntry);
        req.endObject().endObject();
        ensureGreen();
                countDownLatch.countDown();
                            .indices(indexPrefix + finalI)
                        phaser.arriveAndAwaitAdvance();
public class FieldDataLoadingIT extends OpenSearchIntegTestCase {
        updateSettingsRequest.persistentSettings(Settings.builder().put(INDICES_FIELDDATA_CACHE_SIZE_KEY.getKey(), newMaxSize + "b"));
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    protected Settings nodeSettings(int nodeOrdinal) {
 * SPDX-License-Identifier: Apache-2.0
                    }
        // Cache size should be 0
        // TODO: Should be 1 entry per field per index in cache, but cannot check this directly until we add the items count stat in a
                    } catch (Exception e) {
    public void testEagerGlobalOrdinalsFieldDataLoading() throws Exception {
                    .startObject("properties")
        createIndex("index", numFields, fieldPrefix);
 * You may obtain a copy of the License at
 * software distributed under the License is distributed on an
        XContentBuilder req = jsonBuilder().startObject().startObject("properties");
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
        client().admin().indices().prepareRefresh(index).get();
        assertBusy(() -> {
        // Concurrently clear multiple indices from FD cache
        assertBusy(() -> {
            String index = indexPrefix + i;
 * KIND, either express or implied.  See the License for the
        // Ensure cache cleared before other tests in the suite begin
    }
        }
            }
        }
        // Check concurrently clearing multiple indices from the FD cache correctly removes all expected keys.
        });
import org.opensearch.indices.IndicesService;
            threads[i] = new Thread(() -> {
            int finalI = i;
import org.opensearch.core.xcontent.XContentBuilder;
            for (int j = 0; j < numFieldsPerIndex; j++) {
        for (int j = 0; j < numFieldsPerIndex; j++) {
        updateSettingsRequest = new ClusterUpdateSettingsRequest();
        });
 * ownership. Elasticsearch licenses this file to you under
            )
        for (int j = 0; j < numFieldsPerIndex; j++) {
        // that has the same name as the real index,
 * GitHub history for details.
import java.util.concurrent.Phaser;
import java.util.concurrent.CountDownLatch;
        );
        phaser.arriveAndAwaitAdvance();
            ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().get();
                    .endObject()
            // Search on each index to fill the cache
        // and this ensures the clear resulting from that close has completed before we go to the actual test.
import java.util.Map;
