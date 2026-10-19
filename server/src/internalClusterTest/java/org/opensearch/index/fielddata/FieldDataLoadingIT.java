        for (int i = 0; i < numIndices; i++) {  
    private void createAndSearchIndices(int numIndices, int numFieldsPerIndex, String indexPrefix, String fieldPrefix) throws Exception {
                threads[i * numFieldsPerIndex + j] = new Thread(() -> {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        // TODO: Should be 1 entry per field per index in cache, but cannot check this directly until we add the items count stat in a
        });  
                    client().admin().indices().clearCache(clearCacheRequest).actionGet();
            threads[i] = new Thread(() -> {  
        createAndSearchIndices(numIndices, numFieldsPerIndex, indexPrefix, fieldPrefix);
        }  
                }
                    throw new RuntimeException(e);
import org.opensearch.test.OpenSearchIntegTestCase;  
        client().prepareSearch("index").setQuery(new MatchAllQueryBuilder()).addSort(fieldPrefix + "0", SortOrder.ASC).get();
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.admin.cluster.stats.ClusterStatsResponse;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                client().prepareSearch(index).setQuery(new MatchAllQueryBuilder()).addSort(fieldPrefix + j, SortOrder.ASC).get();  
                    .field("type", "text")
 *
                    .startObject("name")
    @Override  
import java.util.concurrent.Phaser;
        String fieldPrefix = "field";  
        long maxSize = maxEntries * sizePerEntry + 1;
        XContentBuilder req = jsonBuilder().startObject().startObject("properties");
 * compatible open source license.
        for (int i = 0; i < numIndices; i++) {
                });  
        Phaser phaser = new Phaser(numIndices + 1);
            for (int j = 0; j < numFieldsPerIndex; j++) {
                            .indices(indexPrefix + finalI)
        ensureGreen();  
 * Licensed to Elasticsearch under one or more contributor  
 *  
                .getIndicesStats()
 * this work for additional information regarding copyright
        int numIndices = 10;
        assertBusy(() -> {
                    countDownLatch.countDown();
        for (int j = 0; j < numFieldsPerIndex; j++) {  
        long newMaxSize = 2 * sizePerEntry + 1;
    protected Settings nodeSettings(int nodeOrdinal) {
 * You may obtain a copy of the License at  
        // Put something into the cache and clear it, waiting for stats to return to 0.  
 * license agreements. See the NOTICE file distributed with
            prepareCreate("test").setMapping(
        // Ensure cache cleared before other tests in the suite begin  
 * this file be licensed under the Apache-2.0 license or a
        }
        );  
public class FieldDataLoadingIT extends OpenSearchIntegTestCase {
                    .endObject()  
        phaser.arriveAndAwaitAdvance();
            ClusterStatsResponse clearedResponse = client().admin().cluster().prepareClusterStats().get();  
 */  
            ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().get();  
 */  
    public void testEagerGlobalOrdinalsFieldDataLoading() throws Exception {
                    }
        Thread[] threads = new Thread[numIndices];  
        assertTrue(response.getIndicesStats().getFieldData().getMemorySizeInBytes() > 0L);
        for (int j = 0; j < numFieldsPerIndex; j++) {  
        return Settings.builder()
            assertTrue(newCacheSize <= newMaxSize);
                    .field("fielddata", true)  
                        client().admin().indices().clearCache(clearCacheRequest).actionGet();  
        assertThat(response.getIndicesStats().getFieldData().getMemorySizeInBytes(), greaterThan(0L));
        }
            assertEquals(0, response.getIndicesStats().getFieldData().getMemorySizeInBytes());
        // Separate loop to ensure createIndex() handles any cache wipe from opening+closing the temporary test index
                .get()
    public void testFieldDataCacheClearConcurrentIndices() throws Exception {  
            for (int j = 0; j < numFieldsPerIndex; j++) {
/*
        int maxEntries = 10;
        client().prepareIndex(index).setId("1").setSource(source).get();  
            long newCacheSize = client().admin()
    }
    }  
        }  
                .getFieldData()  
            client().prepareSearch("index").setQuery(new MatchAllQueryBuilder()).addSort(fieldPrefix + i, SortOrder.ASC).get();
                } catch (Exception e) {  
            }
import static org.hamcrest.Matchers.greaterThan;
 * KIND, either express or implied.  See the License for the
        // Index creation temporarily opens + closes a test index using IndicesService.withTempIndexService()
 * Modifications Copyright OpenSearch Contributors. See
            });
        CountDownLatch countDownLatch = new CountDownLatch(numIndices);
/*  
        ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().get();  
        String fieldPrefix = "field";
        Thread[] threads = new Thread[numIndices * numFieldsPerIndex];
            )
            assertEquals(0, response.getIndicesStats().getFieldData().getMemorySizeInBytes());
 *    http://www.apache.org/licenses/LICENSE-2.0
        updateSettingsRequest.persistentSettings(Settings.builder().put(INDICES_FIELDDATA_CACHE_SIZE_KEY.getKey(), newMaxSize + "b"));
        // that has the same name as the real index,
 * specific language governing permissions and limitations
    // To shorten runtimes, set cluster setting INDICES_CACHE_CLEAN_INTERVAL_SETTING to a lower value.
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals(0, clearedResponse.getIndicesStats().getFieldData().getMemorySizeInBytes());
        assertAcked(prepareCreate(index).setMapping(req));
        countDownLatch.await();
    }  
        });
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        assertBusy(() -> {
 * software distributed under the License is distributed on an
        });  
        assert numFieldsPerIndex >= 1;
        // Check concurrently clearing multiple indices from the FD cache correctly removes all expected keys.
                threads[i * numFieldsPerIndex + j].start();
        phaser.arriveAndAwaitAdvance();
        updateSettingsRequest.persistentSettings(Settings.builder().put(INDICES_FIELDDATA_CACHE_SIZE_KEY.getKey(), maxSize + "b"));  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
        assertTrue(cacheSize <= maxSize && cacheSize > sizePerEntry);
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1ms")
            int finalI = i;
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        createAndSearchIndices(numIndices, 1, indexPrefix, "field");
 */
                        phaser.arriveAndAwaitAdvance();
    }  
        updateSettingsRequest = new ClusterUpdateSettingsRequest();  
        // Cache size should be 0
                countDownLatch.countDown();  
}
                        ClearIndicesCacheRequest clearCacheRequest = new ClearIndicesCacheRequest().fieldDataCache(true)  
        client().admin().indices().prepareRefresh(index).get();
                int finalJ = j;  
        int numIndices = 10;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        Phaser phaser = new Phaser(numIndices * numFieldsPerIndex + 1);  
    }  
 * under the License.  
        // Concurrently clear multiple indices+fields from FD cache
                    try {
            .put(super.nodeSettings(nodeOrdinal))  
        client().prepareIndex("test").setId("1").setSource("name", "name").get();  
            .build();
                    } catch (Exception e) {
        for (int i = 1; i < numFields; i++) {
        // future PR  
    public void testIndicesFieldDataCacheSizeSetting() throws Exception {
        Map<String, String> source = new HashMap<>();
            ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().get();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.query.MatchAllQueryBuilder;  
import static org.opensearch.indices.fielddata.cache.IndicesFieldDataCache.INDICES_FIELDDATA_CACHE_SIZE_KEY;
    }  
        client().prepareSearch(index).setQuery(new MatchAllQueryBuilder()).addSort(fieldPrefix + "0", SortOrder.ASC).get();
        long cacheSize = client().admin().cluster().prepareClusterStats().get().getIndicesStats().getFieldData().getMemorySizeInBytes();
        // Check concurrently clearing multiple indices + fields from the FD cache correctly removes all expected keys.  
        assertBusy(() -> {  
        });
        // Set the max size setting to a smaller value and assert the new size is less than that (waiting for refresh)
 * GitHub history for details.
            int finalI = i;
        ClusterStatsResponse response = client().admin().cluster().prepareClusterStats().get();
        // Add >N values to the cache and assert the size is less than the limit  
import org.opensearch.indices.IndicesService;
import org.opensearch.core.xcontent.XContentBuilder;
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
                .cluster()
                try {
        req.endObject().endObject();  
        // Put one value into the cache  
/*  
        }
            assertEquals(0, clearedResponse.getIndicesStats().getFieldData().getMemorySizeInBytes());
    private void createIndex(String index, int numFieldsPerIndex, String fieldPrefix) throws Exception {  
        ensureGreen();
        CountDownLatch countDownLatch = new CountDownLatch(numIndices * numFieldsPerIndex);
            req.startObject(fieldPrefix + j).field("type", "text").field("fielddata", true).endObject();
        int numFieldsPerIndex = 5;
package org.opensearch.index.fielddata;
        String indexPrefix = "test";  
        assertBusy(() -> {
            String index = indexPrefix + i;
import org.opensearch.common.settings.Settings;
            String index = indexPrefix + i;
import java.util.concurrent.CountDownLatch;
        assertTrue(sizePerEntry > 0);
                jsonBuilder().startObject()
                        throw new RuntimeException(e);  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;  
        for (int i = 0; i < numIndices; i++) {
 *
        // Set the max size setting so that it can fit maxEntries such entries  
            source.put(fieldPrefix + j, "value");
        // Cache size should be 0
    }
        });
        client().admin().indices().clearCache(new ClearIndicesCacheRequest().fieldDataCache(true)).actionGet();
                        .indices(indexPrefix + finalI);  
import org.opensearch.search.sort.SortOrder;
        client().admin().indices().prepareRefresh("test").get();
 * not use this file except in compliance with the License.
        }  
import java.util.Map;  
                    .field("eager_global_ordinals", true)
                    phaser.arriveAndAwaitAdvance();
        assertAcked(  
                            .fields(fieldPrefix + finalJ);
import java.util.HashMap;
                .getMemorySizeInBytes();
        for (int i = 0; i < numIndices; i++) {  
        // Concurrently clear multiple indices from FD cache
                    .startObject("properties")  
        String indexPrefix = "test";  
        client().admin().indices().clearCache(new ClearIndicesCacheRequest().fieldDataCache(true)).actionGet();
            ClusterStatsResponse clearedResponse = client().admin().cluster().prepareClusterStats().get();
            }
        // and this ensures the clear resulting from that close has completed before we go to the actual test.  
            createIndex(index, numFieldsPerIndex, fieldPrefix);
        long sizePerEntry = client().admin().cluster().prepareClusterStats().get().getIndicesStats().getFieldData().getMemorySizeInBytes();  
        countDownLatch.await();
                    .endObject()
        assertBusy(() -> {  
    public void testFieldDataCacheClearConcurrentFields() throws Exception {
                .prepareClusterStats()  
                    ClearIndicesCacheRequest clearCacheRequest = new ClearIndicesCacheRequest().fieldDataCache(true)
            // Search on each index to fill the cache  
        createIndex("index", numFields, fieldPrefix);
        int numFields = 2 * maxEntries;
                    .endObject()
            threads[i].start();
        }  
