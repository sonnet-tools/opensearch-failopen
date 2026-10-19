        Set<String> finalCatalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);
     * The catalog file set on the replica should match the primary's.
            for (int d = 0; d < docsPerBatch; d++) {
        IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
    public void testOldParquetGenerationCleanupOnReplica() throws Exception {  
import org.opensearch.common.unit.TimeValue;
            .put(dfaIndexSettings(0))  
            // Index new docs before each restart
        internalCluster().startClusterManagerOnlyNode();
     *
                primaryCatalogFiles,
        String replicaNode = replicaNodeNames().get(0);
        }
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(1)).get();  
            ClusterHealthStatus.GREEN,
        // segments. The safe commit must reference >= TieredMergePolicy.DEFAULT_SEGMENTS_PER_TIER  
        ensureGreen(INDEX_NAME);
                replicaCatalogFiles  
    public void testMultipleConsecutiveReplicaRestarts() throws Exception {
            .setWaitForGreenStatus()
        // Wait for replication to converge  
}  
     * leaving the shard unable to start.  
        // Flush so segments are persisted in a real Lucene commit (segments_<N>).
        internalCluster().startDataOnlyNodes(2);  
        // Restart the data node holding the primary — forces engine teardown and reinit
            Set<String> replicaCatalogFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(replica);
        // 15 batches × 5 docs with explicit refresh between → ~13 distinct Lucene segments,
            assertCatalogSnapshotsConverged(INDEX_NAME);  
     * with new documents indexed between each restart. Validates catalog grows
        ensureGreen(INDEX_NAME);
    public void testEngineReinitDoesNotFailWithIndexSortMismatch() throws Exception {
     * <p>Without the fix, {@code discoverAndTrimUnsafeCommits} opens a temp {@code IndexWriter}  
    /**
 */  
            .setTimeout(TimeValue.timeValueSeconds(60))  
        assertBusy(() -> {  
            // Verify catalog convergence before restart  
        // Replica should have the same catalog files (not accumulated old generations)
    /**
            assertEquals(  
        // the default ensureGreen window.
        internalCluster().restartNode(primaryNode);
        Set<String> primaryCatalogFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);
     * Reproduces the indexSort mismatch fired when {@code LuceneCommitter.discoverAndTrimUnsafeCommits}  
                "Replica should have same catalog files as primary (no stale generations)",
     * subsequent (sorted) {@code MergeIndexWriter} cannot open at that polluted commit and
     * runs at engine reinit with many Lucene segments at the safe-commit point.
        String primaryNode = primaryNodeName();
 * and old parquet generation cleanup during replication.
        // Final verification: catalog is non-empty and consistent  
        internalCluster().startDataOnlyNodes(2);
import org.opensearch.index.shard.IndexShard;
        // through LuceneCommitter.<init> → SafeBootstrapCommitter ctor →
     */
        // Bound the wait so a buggy build fails fast rather than silently retrying for  
            .prepareHealth(INDEX_NAME)
            assertCatalogSnapshotsConverged(INDEX_NAME);
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
 *
import java.util.List;
     *
        }, 60, TimeUnit.SECONDS);
     * with default {@code TieredMergePolicy} and no {@code setIndexSort}. If the safe commit
     * Tests that a replica recovers correctly through 3 consecutive node restarts  
    }  
            String replicaNode = replicaNodeNames().get(0);
        ensureGreen(INDEX_NAME);
        // discoverAndTrimUnsafeCommits, which is where the bug fires.  
            String replicaNode = replicaNodeNames().get(0);  
    }
            IndexShard recoveredReplica = getIndexShard(newReplicaNode, INDEX_NAME);
            .getStatus();
     * <p>The fix pins {@code NoMergePolicy.INSTANCE} on that temp writer.
import java.util.Set;
            .cluster()  
import org.opensearch.cluster.metadata.IndexMetadata;
                client().prepareIndex(INDEX_NAME).setSource("name", "b" + b + "_d" + d, "value", b * 100 + d).get();
 * compatible open source license.
     * has {@code >= ~10} segments, the temp writer fires a merge during its open/close cycle
     * throws {@code IllegalArgumentException: cannot change previous indexSort=null ...},
     * (new generations) and convergence holds after each recovery cycle.
        // Perform multiple flush cycles to create multiple parquet generations  
import java.util.concurrent.TimeUnit;  
            Set<String> recoveredFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(recoveredReplica);  
            internalCluster().restartNode(replicaNode);
        }
 * The OpenSearch Contributors require contributions made to  
        int numBatches = 15;
        assertEquals(  
        int docsPerBatch = 5;
 * SPDX-License-Identifier: Apache-2.0
                + INDEX_NAME
                + "] must reach GREEN after engine reinit; the indexSort bug in "  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(1)).get();
            indexDocs(10);
            IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);
        // Lucene-secondary index with merges suppressed so refreshes accumulate as separate
            status  
        // commit and the shard fails to start, so the cluster never reaches GREEN.
 */
            .put("index.merge.policy.segments_per_tier", 100)
        for (int restart = 0; restart < 3; restart++) {
            .put("index.composite.merge_on_refresh_max_size", "0")  
    /**
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
     * Tests that after multiple flush cycles, old parquet generation files are cleaned up
        }, 60, TimeUnit.SECONDS);
        // well above the TieredMergePolicy default segments_per_tier threshold.  
     * on replicas during replication, leaving only the current generation's files.  
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
            .get()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Restart replica and verify cleanup persists after recovery
        // Get the primary's current catalog files — this is the "truth"  
            );
            // Restart the replica node  
        ClusterHealthStatus status = client().admin()
            ensureGreen(INDEX_NAME);  
            "Index ["
import org.opensearch.cluster.health.ClusterHealthStatus;
        ensureGreen(INDEX_NAME);  
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).get();
        // (~10) Lucene segments to trigger the buggy temp-writer merge during engine reinit.
            String newReplicaNode = replicaNodeNames().get(0);
                + "discoverAndTrimUnsafeCommits prevents this when the safe commit has many segments.",
        assertBusy(() -> {
        assertCatalogSnapshotsConverged(INDEX_NAME);
        internalCluster().startDataOnlyNodes(2);  
     */  
            client().admin().indices().prepareFlush(INDEX_NAME).get();  
        internalCluster().startClusterManagerOnlyNode();
            client().admin().indices().prepareFlush(INDEX_NAME).get();
            .put("index.merge.policy.floor_segment", "1gb")  
 * Integration tests for DFA replica resilience: multiple consecutive replica restarts  
        for (int gen = 0; gen < 4; gen++) {
     */  
            assertEquals("Recovered replica should have same catalog files as primary", primaryCatalogFiles, recoveredFiles);
     * that produces a segment with {@code source=merge} and {@code indexSort=null}. The  
        );
            .put("index.merge.policy.max_merge_at_once", 2)
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
 * this file be licensed under the Apache-2.0 license or a
            // Verify catalog convergence after restart
/**
        internalCluster().restartNode(replicaNode);  
        IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
            .build();
        Settings indexSettings = Settings.builder()
public class DataFormatAwareReplicaResilienceIT extends DataFormatAwareReplicationBaseIT {  
        internalCluster().startClusterManagerOnlyNode();
        // Without the fix, the new MergeIndexWriter cannot open at the (now polluted)
    }
        for (int b = 0; b < numBatches; b++) {  
import org.opensearch.common.settings.Settings;  
        assertFalse("catalog must have files after 3 restart cycles", finalCatalog.isEmpty());  
            }  
        }
package org.opensearch.composite;
            indexDocs(randomIntBetween(10, 20));  
/*  
