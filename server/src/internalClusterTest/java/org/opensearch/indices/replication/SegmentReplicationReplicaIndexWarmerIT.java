        final Map<String, Long> warmerTotalBeforeRefresh = getWarmerTotalPerShardType(INDEX_NAME);
        final String replicaNode = internalCluster().startDataOnlyNode();
            prepareCreate(INDEX_NAME).setSettings(indexSettings()).setMapping("category", "type=keyword,eager_global_ordinals=true")
                afterTotal,  
            long beforeTotal = before.get(shardType);
        final String replicaNode = internalCluster().startDataOnlyNode();  
            }
 * compatible open source license.
 * <p>Uses a keyword field with {@code eager_global_ordinals: true}  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            compareWarmerTotals(warmerTotalBeforeForceMerge, warmerTotalAfterForceMerge, true);
    @Before
 * SPDX-License-Identifier: Apache-2.0
        // Assert warmer invoked metrics from index stats API for both primary and replica shards  
        // Capture warmer stats before force merge
     * Verifies that warmer invocations continue on replica shards after a force merge on the primary,
     * followed by segment replication. This ensures warming is triggered on subsequent segment updates.  
        waitForSearchableDocs(docCount, primaryNode, replicaNode);
    private void compareWarmerTotals(Map<String, Long> before, Map<String, Long> after) {
package org.opensearch.indices.replication;
                refresh(INDEX_NAME);  
        ensureGreen(INDEX_NAME);  
     * correctly invokes the {@code IndexWarmer} chain on replica shards, which in turn loads  
import org.opensearch.test.OpenSearchIntegTestCase;
}
     * global ordinals for the keyword field with {@code eager_global_ordinals: true}.</p>
import org.junit.Before;
        IndicesStatsResponse shardStatsArray = client().admin().indices().prepareStats(indexName).clear().setWarmer(true).get();  
        assertAcked(
    }
        compareWarmerTotals(before, after, false);  
            WarmerStats warmerStats = shardStats.getStats().getWarmer();
     * <p>This test ensures that the {@code WarmerRefreshListener} in {@code NRTReplicationEngine}
    }  
    }
    private void indexTestDocuments(int docCount, int refreshAfterDocs) {
        ensureYellow(INDEX_NAME);
            long afterTotal = after.get(shardType);  
        final String primaryNode = internalCluster().startDataOnlyNode();  
public class SegmentReplicationReplicaIndexWarmerIT extends SegmentReplicationBaseIT {
     *
    public void setup() {  
     * after segment replication, by checking warmer invocation metrics from the index stats API.  
        );
        });
import org.opensearch.action.admin.indices.stats.ShardStats;
    public void testEagerGlobalOrdinalsLoadedOnReplicaAfterSegmentReplication() throws Exception {  
            }
            );
        for (int i = 0; i < docCount; i++) {  
        internalCluster().startClusterManagerOnlyNode();
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("category", "value-" + i).get();
        // Index documents in batches to create multiple segments
        }
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        ensureGreen(INDEX_NAME);
    }
        Map<String, Long> warmerTotals = new HashMap<>();
        indexTestDocuments(docCount, -1);
        client().admin().indices().prepareForceMerge(INDEX_NAME).setMaxNumSegments(1).setFlush(true).get();
        for (String shardType : before.keySet()) {
            prepareCreate(INDEX_NAME).setSettings(indexSettings()).setMapping("category", "type=keyword,eager_global_ordinals=true")  
 * index warmer gets triggered when new segments arrive on replicas via segment replication.
    }
                greaterThan(beforeTotal)
        return warmerTotals;
    private Map<String, Long> getWarmerTotalPerShardType(String indexName) {
 * this file be licensed under the Apache-2.0 license or a
            assertThat(
            Map<String, Long> warmerTotalsAfterRefresh = getWarmerTotalPerShardType(INDEX_NAME);
 */
 */  
    }  
 * The OpenSearch Contributors require contributions made to  
            final Map<String, Long> warmerTotalAfterForceMerge = getWarmerTotalPerShardType(INDEX_NAME);  
                String key = shardStats.getShardRouting().primary() ? "primary" : "replica";
        }  
 * Integration tests that verify index warming (e.g., eager global ordinals loading) works correctly
        indexTestDocuments(docCount, 3);
        warmerTotals.put("replica", 0L);  
 *
        });
        final int docCount = randomIntBetween(10, 20);  
        // Verify warmer was invoked again on replica after force merge replication
    /**
            if (warmerStats != null) {  
                continue; // Skip primary if we're only checking replica warmer totals  
import java.util.Map;
        final int docCount = randomIntBetween(10, 20);  
        assertBusy(() -> {
        warmerTotals.put("primary", 0L);
     */
            if (onReplicaOnly && shardType.equals("primary")) {
        final Map<String, Long> warmerTotalBeforeForceMerge = getWarmerTotalPerShardType(INDEX_NAME);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        refresh(INDEX_NAME);  
     * Verifies that eager global ordinals are loaded on both primary and replica shards
        assertAcked(
                "Warmer total for " + shardType + " should increase after segment replication",
        // Force merge and wait for segment replication to complete
 * on NRT replica shards during segment replication. This validates the end-to-end flow where  
import org.opensearch.index.warmer.WarmerStats;  
    public void testWarmerInvokedOnReplicaAfterForceMerge() throws Exception {
     */
        assertBusy(() -> {
 * to exercise the warming path during segment replication.</p>
    /**
        final String primaryNode = internalCluster().startDataOnlyNode();
/**
            compareWarmerTotals(warmerTotalBeforeRefresh, warmerTotalsAfterRefresh);  
import java.util.HashMap;
        waitForSearchableDocs(docCount, primaryNode, replicaNode);
import static org.hamcrest.Matchers.greaterThan;
            }  
                warmerTotals.merge(key, warmerStats.total(), Long::sum);
            if (refreshAfterDocs != -1 && i % refreshAfterDocs == 0) {
        );  
        ensureYellow(INDEX_NAME);
        for (ShardStats shardStats : shardStatsArray.getShards()) {
 *
    }  
        }
    private void compareWarmerTotals(Map<String, Long> before, Map<String, Long> after, boolean onReplicaOnly) {  
/*  
