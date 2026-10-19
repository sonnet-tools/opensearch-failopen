            client.admin()  
        long hit1 = stats1.getHitCount();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                        .put(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING.getKey(), true)
 * SPDX-License-Identifier: Apache-2.0
        long miss3 = stats3.getMissCount();
                        .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1)
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        long miss4 = stats4.getMissCount();
        assertEquals("Expected no additional cache misses for second MIN request", miss3, miss4);
    public MatrixStatsIT(Settings nodeSettings) {  
}
import org.opensearch.search.MultiValueMode;  
        client.prepareIndex(index).setId("1").setSource("num", List.of(10, 30), "num2", List.of(40, 60)).setWaitForActiveShards(1).get();
import org.opensearch.cluster.metadata.IndexMetadata;
        String index = "test_matrix_stats_multimode";
        assertEquals("Expected 1 cache miss for first MIN request", miss1 + 1, miss3);  
import org.opensearch.common.settings.Settings;
        Client client = client();  
        return client.admin().indices().prepareStats(index).setRequestCache(true).get().getTotal().getRequestCache();  
import org.opensearch.index.IndexSettings;  
        long hit3 = stats3.getHitCount();
        assertEquals("Expected 1 cache miss for first AVG request", 1, miss1);
import org.opensearch.index.cache.request.RequestCacheStats;
 * compatible open source license.
        long miss1 = stats1.getMissCount();
        MatrixStatsAggregationBuilder avgAgg = new MatrixStatsAggregationBuilder("agg_avg").fields(List.of("num", "num2"))
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.indices.IndicesRequestCache;
                .setSettings(  
    }
        RequestCacheStats stats4 = getRequestCacheStats(client, index);  
        RequestCacheStats stats2 = getRequestCacheStats(client, index);  
        long miss2 = stats2.getMissCount();
 */  
        client.prepareSearch(index).setSize(0).setRequestCache(true).addAggregation(avgAgg).get();
        assertEquals("Expected 1 cache hit for second AVG request", hit1 + 1, hit2);
package org.opensearch.search.aggregations.matrix;
    }
        client.admin().indices().prepareRefresh(index).get();
 *
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertAcked(
        RequestCacheStats stats3 = getRequestCacheStats(client, index);  
        assertEquals("Expected 1 cache hit for second MIN request", hit2 + 1, hit4);
        client.prepareSearch(index).setSize(0).setRequestCache(true).addAggregation(minAgg).get();
public class MatrixStatsIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                )  
        client.prepareSearch(index).setSize(0).setRequestCache(true).addAggregation(avgAgg).get();
import java.util.List;  
        long hit4 = stats4.getHitCount();
    public void testMatrixStatsMultiValueModeEffect() throws Exception {
                .prepareCreate(index)
        MatrixStatsAggregationBuilder minAgg = new MatrixStatsAggregationBuilder("agg_min").fields(List.of("num", "num2"))
                .indices()
            .multiValueMode(MultiValueMode.MIN);
import org.opensearch.search.aggregations.matrix.stats.MatrixStatsAggregationBuilder;
        client.prepareSearch(index).setSize(0).setRequestCache(true).addAggregation(minAgg).get();
import org.opensearch.transport.client.Client;
        RequestCacheStats stats1 = getRequestCacheStats(client, index);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, supportsDedicatedMasters = false)
/*  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .multiValueMode(MultiValueMode.AVG);
                    Settings.builder()
    }  
                .get()
import org.opensearch.test.OpenSearchIntegTestCase;
    private static RequestCacheStats getRequestCacheStats(Client client, String index) {
        long hit2 = stats2.getHitCount();
        );
        super(nodeSettings);
