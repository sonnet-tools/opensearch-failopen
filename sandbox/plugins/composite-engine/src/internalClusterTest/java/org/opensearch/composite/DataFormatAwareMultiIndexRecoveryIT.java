        assertCatalogSnapshotsConverged(INDEX_NAME);  
package org.opensearch.composite;
                throw new AssertionError("shard not yet available after node restart; will retry", e);
        // Create 3 indices — use INDEX_NAME as one so base class helpers work
    /**
    public void testEmptyIndexRecovery() throws Exception {
            30,  
        ensureGreen(INDEX_NAME, index2, index3);  
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(primaryNodeName(), INDEX_NAME));
        // Verify catalog convergence for the base index (no cross-contamination)
            .putList("index.composite.secondary_data_formats", List.of("lucene"))  
            client().prepareIndex(indexName).setSource("field_text", randomAlphaOfLength(10), "field_number", (long) i).get();  
            } catch (Exception e) {  
 */  
import org.opensearch.test.InternalTestCluster;  
    }
        client().admin().indices().prepareFlush(INDEX_NAME, index2, index3).get();  
import org.opensearch.action.support.PlainActionFuture;
            assertNotEquals("Index must not be RED during recovery", ClusterHealthStatus.RED, status);
        String index2 = "dfa-multi-idx-2";  
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.cluster.metadata.IndexMetadata;
        assertBusy(() -> {
        ensureGreen(TimeValue.timeValueSeconds(90), INDEX_NAME, index2, index3);
        ensureGreen(INDEX_NAME);  
    }
    public void testMultiIndexConcurrentRecovery() throws Exception {  
        // Capture catalog state before restart
        String nodeToRestart = replicaNodeNames().isEmpty() ? primaryNodeName() : replicaNodeNames().get(0);
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen(INDEX_NAME);
            }
        // Flush the empty index to ensure remote store state is published
        internalCluster().restartNode(nodeToRestart);
            Set<String> catalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);  
            .put("index.composite.primary_data_format", "parquet")
            final IndexShard primary;  
            ClusterHealthStatus status = client().admin().cluster().prepareHealth(INDEX_NAME).get().getStatus();  
        Settings multiShardSettings = Settings.builder()  
import org.opensearch.common.unit.TimeValue;  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        client().admin().indices().prepareFlush(INDEX_NAME).get();
     */  
        client().admin().indices().prepareCreate(index3).setSettings(dfaIndexSettings(1)).get();
 * The OpenSearch Contributors require contributions made to  
        }, 60, TimeUnit.SECONDS);  
     * Tests that a DFA index with multiple shards (2) and a replica never enters RED state
    private void indexDocsToIndex(String indexName, int count) {
     */  
        client().admin().indices().prepareCreate(index2).setSettings(dfaIndexSettings(1)).get();
        client().admin().indices().prepareFlush(INDEX_NAME).get();  
            () -> assertEquals(ClusterHealthStatus.RED, client().admin().cluster().prepareHealth(INDEX_NAME).get().getStatus()),
        // Catalog should have files now  
                primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        String dataNode1 = internalCluster().startDataOnlyNode();
 * Integration tests for DFA recovery with multiple indices, empty indices, and multi-shard configurations.
 */
        internalCluster().startDataOnlyNode();  
     * Tests that a DFA index with zero documents recovers correctly from remote store.
 * this file be licensed under the Apache-2.0 license or a
        internalCluster().startClusterManagerOnlyNode();
     */
            .build();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataNode));  
        indexDocsToIndex(index3, randomIntBetween(10, 30));
        ensureGreen(INDEX_NAME);  
            assertFalse("catalog must have files after indexing on recovered empty index", catalog.isEmpty());
        // Should never be RED — at worst YELLOW while replicas recover
import org.opensearch.index.shard.IndexShard;
        indexDocs(randomIntBetween(20, 40));  
import org.opensearch.indices.replication.common.ReplicationType;
        indexDocs(randomIntBetween(10, 30));
        assertBusy(
        String index3 = "dfa-multi-idx-3";
        assertCatalogSnapshotsConverged(INDEX_NAME);  
import org.opensearch.common.settings.Settings;
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
        // Verify the index can accept writes after recovery
        internalCluster().startDataOnlyNode();
            .put(remoteStoreIndexSettings(1, 2))
import java.util.Set;  
    }
            .put("index.pluggable.dataformat.enabled", true)  
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
/*  
        // Stop data node, start new one, restore from remote store
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);  
        client().admin().indices().prepareClose(INDEX_NAME).get();
        );
            assertTrue("catalog after recovery must contain all pre-recovery files", catalogAfter.containsAll(catalogBefore));
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
import java.util.concurrent.TimeUnit;
        }, 60, TimeUnit.SECONDS);
    }
        // Flush to ensure any new generation files are uploaded to remote store
            try {
        client().admin().indices().prepareFlush(INDEX_NAME).get();
    public void testMultiShardRecoveryNoRedState() throws Exception {
        for (int i = 0; i < count; i++) {
 * compatible open source license.
 *
        indexDocsToIndex(index2, randomIntBetween(10, 30));  
import java.util.List;
public class DataFormatAwareMultiIndexRecoveryIT extends DataFormatAwareReplicationBaseIT {  
/**  
        assertBusy(() -> {
import org.opensearch.cluster.health.ClusterHealthStatus;  
        internalCluster().restartNode(dataNode1);
        ensureGreen(INDEX_NAME);
     * CatalogSnapshot should be valid and the index must accept writes after recovery.
        // Restart one data node — some shards will need to recover  
        assertBusy(() -> {
     * during recovery — transitions cleanly without getting stuck.
            .put("index.pluggable.dataformat", "composite")
     * Tests recovery of multiple DFA indices simultaneously after a data node restart.  
        // Full convergence check (primary == replica catalogs + local/remote consistency)
        client().admin().indices().prepareFlush(INDEX_NAME, index2, index3).get();
        String dataNode2 = internalCluster().startDataOnlyNode();  
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());
}  
    /**  
        }
        indexDocs(randomIntBetween(10, 20));  
        client().admin()  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(multiShardSettings).get();  
            assertFalse("catalog must have files after multi-index recovery", catalogAfter.isEmpty());
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(1)).get();  
        }, 60, TimeUnit.SECONDS);  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
     * Validates no cross-contamination of CatalogSnapshot between indices.
    /**  
            TimeUnit.SECONDS
        internalCluster().startDataOnlyNode();
        String dataNode = internalCluster().startDataOnlyNode();  
        // Restart one data node — forces recovery of all shards on that node  
            .cluster()
