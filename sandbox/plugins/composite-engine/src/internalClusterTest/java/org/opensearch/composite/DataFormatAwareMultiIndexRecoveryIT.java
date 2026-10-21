            assertTrue("catalog after recovery must contain all pre-recovery files", catalogAfter.containsAll(catalogBefore));
        client().admin().indices().prepareFlush(INDEX_NAME, index2, index3).get();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataNode));
            assertFalse("catalog must have files after indexing on recovered empty index", catalog.isEmpty());
 * this file be licensed under the Apache-2.0 license or a
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(1)).get();
        ensureGreen(INDEX_NAME);
    private void indexDocsToIndex(String indexName, int count) {
import org.opensearch.common.settings.Settings;
import org.opensearch.common.unit.TimeValue;
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(primaryNodeName(), INDEX_NAME));
     * Validates no cross-contamination of CatalogSnapshot between indices.
        }, 60, TimeUnit.SECONDS);
    }
            assertFalse("catalog must have files after multi-index recovery", catalogAfter.isEmpty());
import java.util.Set;
        assertCatalogSnapshotsConverged(INDEX_NAME);
/**
            .restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME).restoreAllShards(true), PlainActionFuture.newFuture());
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);
            try {
    }
     * Tests recovery of multiple DFA indices simultaneously after a data node restart.
            30,
     * Tests that a DFA index with multiple shards (2) and a replica never enters RED state
import java.util.List;
    public void testMultiIndexConcurrentRecovery() throws Exception {
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        client().admin().indices().prepareClose(INDEX_NAME).get();
        assertBusy(() -> {
            assertNotEquals("Index must not be RED during recovery", ClusterHealthStatus.RED, status);
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().restartNode(nodeToRestart);
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(multiShardSettings).get();
     */
        indexDocsToIndex(index2, randomIntBetween(10, 30));
     * Tests that a DFA index with zero documents recovers correctly from remote store.
            final IndexShard primary;
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME, index2, index3);
        internalCluster().startDataOnlyNode();
            ClusterHealthStatus status = client().admin().cluster().prepareHealth(INDEX_NAME).get().getStatus();
        internalCluster().startClusterManagerOnlyNode();
    }
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
        for (int i = 0; i < count; i++) {
            .cluster()
        ensureGreen(TimeValue.timeValueSeconds(90), INDEX_NAME, index2, index3);
        // Capture catalog state before restart
            DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
        internalCluster().startDataOnlyNode();
 */
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(0)).get();
        internalCluster().startDataOnlyNode();
        indexDocs(randomIntBetween(10, 20));
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        // Flush to ensure any new generation files are uploaded to remote store
        String dataNode1 = internalCluster().startDataOnlyNode();
import org.opensearch.indices.replication.common.ReplicationType;
        // Restart one data node — some shards will need to recover
        client().admin().indices().prepareCreate(index2).setSettings(dfaIndexSettings(1)).get();
    public void testEmptyIndexRecovery() throws Exception {
            .put("index.pluggable.dataformat", "composite")
     */
        internalCluster().startClusterManagerOnlyNode();
 * The OpenSearch Contributors require contributions made to
        // Verify catalog convergence for the base index (no cross-contamination)
        assertBusy(
        // Stop data node, start new one, restore from remote store
public class DataFormatAwareMultiIndexRecoveryIT extends DataFormatAwareReplicationBaseIT {
            IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
        client().admin().indices().prepareFlush(INDEX_NAME, index2, index3).get();
    /**
        // Restart one data node — forces recovery of all shards on that node
        assertCatalogSnapshotsConverged(INDEX_NAME);
        // Create 3 indices — use INDEX_NAME as one so base class helpers work
        indexDocs(randomIntBetween(10, 30));
            .build();
            TimeUnit.SECONDS
     * during recovery — transitions cleanly without getting stuck.
        client().admin()
    /**
        String dataNode2 = internalCluster().startDataOnlyNode();
package org.opensearch.composite;
        // Flush the empty index to ensure remote store state is published
 *
        ensureGreen(INDEX_NAME);
            .put("index.composite.primary_data_format", "parquet")
import org.opensearch.action.support.PlainActionFuture;
}
        internalCluster().restartNode(dataNode1);
 */
        client().admin().indices().prepareFlush(INDEX_NAME).get();
            Set<String> catalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);
        }
import org.opensearch.cluster.health.ClusterHealthStatus;
        Settings multiShardSettings = Settings.builder()
        ensureGreen(INDEX_NAME);
                throw new AssertionError("shard not yet available after node restart; will retry", e);
 * SPDX-License-Identifier: Apache-2.0
/*
            () -> assertEquals(ClusterHealthStatus.RED, client().admin().cluster().prepareHealth(INDEX_NAME).get().getStatus()),
            .put(remoteStoreIndexSettings(1, 2))
        indexDocsToIndex(index3, randomIntBetween(10, 30));
        client().admin().indices().prepareFlush(INDEX_NAME).get();
        );
        assertBusy(() -> {
        assertBusy(() -> {
        String nodeToRestart = replicaNodeNames().isEmpty() ? primaryNodeName() : replicaNodeNames().get(0);
        }, 60, TimeUnit.SECONDS);
        // Verify the index can accept writes after recovery
import org.opensearch.test.InternalTestCluster;
     */
import java.util.concurrent.TimeUnit;
                primary = getIndexShard(primaryNodeName(), INDEX_NAME);
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
        String dataNode = internalCluster().startDataOnlyNode();
        // Should never be RED — at worst YELLOW while replicas recover
     * CatalogSnapshot should be valid and the index must accept writes after recovery.
        client().admin().indices().prepareCreate(index3).setSettings(dfaIndexSettings(1)).get();
            .put("index.pluggable.dataformat.enabled", true)
        String index2 = "dfa-multi-idx-2";
        }, 60, TimeUnit.SECONDS);
    public void testMultiShardRecoveryNoRedState() throws Exception {
        String index3 = "dfa-multi-idx-3";
        // Full convergence check (primary == replica catalogs + local/remote consistency)
import org.opensearch.cluster.metadata.IndexMetadata;
    }
            }
 * compatible open source license.
import org.opensearch.index.shard.IndexShard;
        indexDocs(randomIntBetween(20, 40));
            client().prepareIndex(indexName).setSource("field_text", randomAlphaOfLength(10), "field_number", (long) i).get();
        // Catalog should have files now
    /**
            } catch (Exception e) {
 * Integration tests for DFA recovery with multiple indices, empty indices, and multi-shard configurations.
