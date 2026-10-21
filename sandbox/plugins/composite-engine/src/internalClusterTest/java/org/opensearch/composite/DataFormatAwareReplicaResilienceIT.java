            assertCatalogSnapshotsConverged(INDEX_NAME);
            .put(dfaIndexSettings(0))
 * SPDX-License-Identifier: Apache-2.0
    }
 * compatible open source license.
 */
     */
    public void testEngineReinitDoesNotFailWithIndexSortMismatch() throws Exception {
        assertBusy(() -> {
        internalCluster().startClusterManagerOnlyNode();
    }
     * that produces a segment with {@code source=merge} and {@code indexSort=null}. The
     * <p>Without the fix, {@code discoverAndTrimUnsafeCommits} opens a temp {@code IndexWriter}
        IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
            );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Without the fix, the new MergeIndexWriter cannot open at the (now polluted)
    public void testOldParquetGenerationCleanupOnReplica() throws Exception {
     * (new generations) and convergence holds after each recovery cycle.
            String newReplicaNode = replicaNodeNames().get(0);
        for (int gen = 0; gen < 4; gen++) {
                primaryCatalogFiles,
        // Restart replica and verify cleanup persists after recovery
     * throws {@code IllegalArgumentException: cannot change previous indexSort=null ...},
            String replicaNode = replicaNodeNames().get(0);
     * runs at engine reinit with many Lucene segments at the safe-commit point.
     * Tests that after multiple flush cycles, old parquet generation files are cleaned up
            status
            client().admin().indices().prepareFlush(INDEX_NAME).get();
        internalCluster().restartNode(primaryNode);
            assertEquals("Recovered replica should have same catalog files as primary", primaryCatalogFiles, recoveredFiles);
        for (int restart = 0; restart < 3; restart++) {
        // Bound the wait so a buggy build fails fast rather than silently retrying for
        // Wait for replication to converge
        }, 60, TimeUnit.SECONDS);
            IndexShard replica = getIndexShard(replicaNode, INDEX_NAME);
import org.opensearch.common.unit.TimeValue;
    public void testMultipleConsecutiveReplicaRestarts() throws Exception {
        internalCluster().startDataOnlyNodes(2);
        ClusterHealthStatus status = client().admin()
     */
            .putList("index.composite.secondary_data_formats", List.of("lucene"))
                + INDEX_NAME
        // commit and the shard fails to start, so the cluster never reaches GREEN.
                + "] must reach GREEN after engine reinit; the indexSort bug in "
     * on replicas during replication, leaving only the current generation's files.
            // Verify catalog convergence after restart
            .build();
            .setTimeout(TimeValue.timeValueSeconds(60))
            .put("index.merge.policy.floor_segment", "1gb")
     * subsequent (sorted) {@code MergeIndexWriter} cannot open at that polluted commit and
        internalCluster().startDataOnlyNodes(2);
            ClusterHealthStatus.GREEN,
    }
package org.opensearch.composite;
import org.opensearch.index.shard.IndexShard;
            .get()
            for (int d = 0; d < docsPerBatch; d++) {
     * with default {@code TieredMergePolicy} and no {@code setIndexSort}. If the safe commit
     * <p>The fix pins {@code NoMergePolicy.INSTANCE} on that temp writer.
        // (~10) Lucene segments to trigger the buggy temp-writer merge during engine reinit.
        internalCluster().restartNode(replicaNode);
            client().admin().indices().prepareFlush(INDEX_NAME).get();
        ensureGreen(INDEX_NAME);
        // Lucene-secondary index with merges suppressed so refreshes accumulate as separate
/**
                "Replica should have same catalog files as primary (no stale generations)",
        internalCluster().startClusterManagerOnlyNode();
        IndexShard primary = getIndexShard(primaryNodeName(), INDEX_NAME);
            // Index new docs before each restart
import org.opensearch.cluster.metadata.IndexMetadata;
        // discoverAndTrimUnsafeCommits, which is where the bug fires.
            // Verify catalog convergence before restart
        }, 60, TimeUnit.SECONDS);
            internalCluster().restartNode(replicaNode);
        ensureGreen(INDEX_NAME);
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(indexSettings).get();
        assertBusy(() -> {
        // segments. The safe commit must reference >= TieredMergePolicy.DEFAULT_SEGMENTS_PER_TIER
                replicaCatalogFiles
     * The catalog file set on the replica should match the primary's.
        // Final verification: catalog is non-empty and consistent
            Set<String> replicaCatalogFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(replica);
        internalCluster().startClusterManagerOnlyNode();
            .setWaitForGreenStatus()
    /**
            // Restart the replica node
        // well above the TieredMergePolicy default segments_per_tier threshold.
        assertCatalogSnapshotsConverged(INDEX_NAME);
}
     * has {@code >= ~10} segments, the temp writer fires a merge during its open/close cycle
    /**
        }
                client().prepareIndex(INDEX_NAME).setSource("name", "b" + b + "_d" + d, "value", b * 100 + d).get();
     *
     * leaving the shard unable to start.
        // 15 batches × 5 docs with explicit refresh between → ~13 distinct Lucene segments,
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(1)).get();
        // the default ensureGreen window.
            ensureGreen(INDEX_NAME);
            String replicaNode = replicaNodeNames().get(0);
        // Get the primary's current catalog files — this is the "truth"
public class DataFormatAwareReplicaResilienceIT extends DataFormatAwareReplicationBaseIT {
     *
                + "discoverAndTrimUnsafeCommits prevents this when the safe commit has many segments.",
 * The OpenSearch Contributors require contributions made to
        assertEquals(
     * Reproduces the indexSort mismatch fired when {@code LuceneCommitter.discoverAndTrimUnsafeCommits}
import org.opensearch.common.settings.Settings;
            }
 * this file be licensed under the Apache-2.0 license or a
     */
        Set<String> primaryCatalogFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);
            .put("index.merge.policy.segments_per_tier", 100)
            .prepareHealth(INDEX_NAME)
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(dfaIndexSettings(1)).get();
     * with new documents indexed between each restart. Validates catalog grows
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).setWaitIfOngoing(true).get();
        ensureGreen(INDEX_NAME);
            indexDocs(randomIntBetween(10, 20));
 * Integration tests for DFA replica resilience: multiple consecutive replica restarts
            assertEquals(
        DataFormatAwareITUtils.assertCatalogMatchesLocalAndRemote(primary);
        // Restart the data node holding the primary — forces engine teardown and reinit
            .cluster()
            Set<String> recoveredFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(recoveredReplica);
 * and old parquet generation cleanup during replication.
        int numBatches = 15;
        int docsPerBatch = 5;
        );
        String primaryNode = primaryNodeName();
    /**
        // Perform multiple flush cycles to create multiple parquet generations
        internalCluster().startDataOnlyNodes(2);
            .getStatus();
        // through LuceneCommitter.<init> → SafeBootstrapCommitter ctor →
        for (int b = 0; b < numBatches; b++) {
            indexDocs(10);
            assertCatalogSnapshotsConverged(INDEX_NAME);
import org.opensearch.cluster.health.ClusterHealthStatus;
            .put("index.merge.policy.max_merge_at_once", 2)
/*
            client().admin().indices().prepareRefresh(INDEX_NAME).get();
import java.util.Set;
        String replicaNode = replicaNodeNames().get(0);
 */
            "Index ["
        // Flush so segments are persisted in a real Lucene commit (segments_<N>).
        ensureGreen(INDEX_NAME);
     * Tests that a replica recovers correctly through 3 consecutive node restarts
        Settings indexSettings = Settings.builder()
            .put("index.composite.merge_on_refresh_max_size", "0")
            IndexShard recoveredReplica = getIndexShard(newReplicaNode, INDEX_NAME);
        }
import java.util.concurrent.TimeUnit;
import java.util.List;
        // Replica should have the same catalog files (not accumulated old generations)
        assertFalse("catalog must have files after 3 restart cycles", finalCatalog.isEmpty());
        Set<String> finalCatalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(primary);
        }
 *
