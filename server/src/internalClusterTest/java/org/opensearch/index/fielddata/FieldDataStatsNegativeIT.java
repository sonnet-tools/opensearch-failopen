                Settings.builder()
import org.opensearch.index.query.MatchAllQueryBuilder;  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            ensureGreen(INDEX);  
/**  
            long bytes = shardStats.getStats().getFieldData().getMemorySizeInBytes();
        internalCluster().getInstance(IndicesService.class, node1).getIndicesFieldDataCache().clear();
    }
        }  
    private void populateCache() {  
        NodesStatsResponse nodesStats = client().admin().cluster().prepareNodesStats().clear().setIndices(true).get();
        final String node1 = internalCluster().startNode();
public class FieldDataStatsNegativeIT extends OpenSearchIntegTestCase {  
import org.opensearch.cluster.metadata.IndexMetadata;
        // Assert non-negative bytes at every layer.  
/*  
        // Equivalent to one cleaner tick: iterates marked stale keys and fires onRemoval
 * shardId to the current shard, decrementing a counter on bytes it never cached.
        client().admin()
            .put(IndicesService.INDICES_CACHE_CLEAN_INTERVAL_SETTING.getKey(), "1m")  
        return Settings.builder()
            .indices()  
 * The OpenSearch Contributors require contributions made to  
    protected Settings nodeSettings(int nodeOrdinal) {  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        assertThat("node stats had failures", nodesStats.failures().size(), org.hamcrest.Matchers.equalTo(0));
        IndicesStatsResponse stats = client().admin().indices().prepareStats(INDEX).clear().setFieldData(true).get();
        }
 *
 * Verifies fielddata byte counters do not go negative when a shard is relocated
            updateAllocationFilter(node1 + "," + node2);  
            assertThat("shard " + shardStats.getShardRouting().shardId() + " bytes: " + bytes, bytes, greaterThanOrEqualTo(0L));
            prepareCreate(INDEX).setSettings(
    }
    private long getFieldDataBytes() {  
 * 2. After the round-trips are complete, drive cleanup synchronously via
 *    relocation round-trips and prematurely drain stale entries.  
        assertThat("expected fielddata to be cached", getFieldDataBytes(), greaterThan(0L));
package org.opensearch.index.fielddata;
            }
        assertAcked(  
            client().admin().indices().prepareRefresh(INDEX).get();  
    @Override
            .prepareUpdateSettings(INDEX)
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    }
}
import org.opensearch.action.admin.indices.stats.ShardStats;  
 *    IndicesFieldDataCache.clear() instead of waiting on the periodic timer.
        }  
 * compatible open source license.
        // 2) Node-level stats: serialization throws on negative bytes, surfacing
            assertThat("node " + node.getNode().getName() + " bytes: " + bytes, bytes, greaterThanOrEqualTo(0L));
        }
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        // Multi-segment data: single-segment loadGlobal bypasses the cache.
            .build();
    public void testReproduceNegativeFieldDataStats() throws Exception {
import org.opensearch.indices.IndicesService;
 *    OpenSearchIntegTestCase) so the periodic cleaner cannot fire during the
import org.opensearch.common.settings.Settings;
            .get();  
import static org.hamcrest.Matchers.greaterThan;  
    }
        // for each — which is where the misrouted-decrement bug surfaces.  
        // 1) Per-shard counter (ShardFieldData.totalMetric).
        for (int batch = 0; batch < 3; batch++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * SPDX-License-Identifier: Apache-2.0
        );
        IndicesStatsResponse indicesStats = client().admin().indices().prepareStats(INDEX).clear().setFieldData(true).get();
        // 3 round-trips of shard 1. Shard 0 anchors the IndexService on node1.
            updateAllocationFilter(node1);
 * 1. Restore the production default cleanup interval (1m, vs the 1s set by
import org.opensearch.search.sort.SortOrder;
 * alive. Without the PR #21667 fix, stale CacheCleaner removals are routed by  
        populateCache();  
        for (int trip = 0; trip < 3; trip++) {
 */
            long bytes = node.getIndices().getFieldData().getMemorySizeInBytes();
    private void updateAllocationFilter(String includeNames) {
import org.opensearch.test.OpenSearchIntegTestCase;  
            .put(super.nodeSettings(nodeOrdinal))
    private static final String INDEX = "test_fd_stats";
        for (var node : nodesStats.getNodes()) {  
                client().prepareIndex(INDEX).setSource(FIELD, "b" + batch + "_d" + i).get();
        final String node2 = internalCluster().startNode();  
 *    Avoids Thread.sleep and runs deterministically.  
        // Drive cleanup synchronously instead of waiting for the periodic CacheCleaner.
        ensureStableCluster(2);
            for (int i = 0; i < 5; i++) {  
        // as a per-node failure even when one shard's counter happens to net positive.  
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", includeNames))
            populateCache();
                    .put("index.routing.allocation.include._name", node1)
    }  
        ensureGreen(INDEX);
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
        for (ShardStats shardStats : indicesStats.getShards()) {  
            ensureGreen(INDEX);
        client().prepareSearch(INDEX).setQuery(new MatchAllQueryBuilder()).addSort(FIELD, SortOrder.ASC).setSize(20).get();
        return stats.getTotal().getFieldData().getMemorySizeInBytes();
 * off and back to the same node while a sibling shard keeps the IndexService
    private static final String FIELD = "name";  
 */  
 * Two timing levers:  
            ).setMapping(FIELD, "type=text,fielddata=true")  
 *
            client().admin().indices().prepareFlush(INDEX).get();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
