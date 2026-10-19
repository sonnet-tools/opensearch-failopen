        internalCluster().startDataAndWarmNodes(3);
        createHotIndexAndTierToWarm(0);
        assertBusy(() -> {  
            assertEquals("replica catalog must match primary after recovery", primaryCatalog, replicaCatalog);
 */  
import org.opensearch.index.shard.IndexShard;
        IndexShard primaryShard = getIndexShard(primaryNode);  
        // After restart, verify engine type and catalog
        // Increase replica count to 1 — triggers recovery from remote store
 * SPDX-License-Identifier: Apache-2.0
     */
import org.opensearch.cluster.metadata.IndexMetadata;
 *
            Set<String> replicaCatalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(getIndexShard(replicaNode));
        internalCluster().startDataAndWarmNodes(2);  
        assertBusy(() -> {  
     * Add a replica to a warm index (0 replicas initially) — the new replica  
import org.opensearch.index.engine.exec.Indexer;
        String replicaNodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).replicaShards().get(0).currentNodeId();
        internalCluster().restartNode(primaryNode);
        // Record catalog before restart
        assertFalse("catalog must have files before restart", catalogBefore.isEmpty());
        client().admin()
        }, 60, TimeUnit.SECONDS);  
     * must recover from remote store and have the same catalog as the primary.
}  
import java.util.Set;
 * compatible open source license.
        IndexShard replicaShard = getIndexShard(replicaNode);  
package org.opensearch.composite;
import java.util.concurrent.TimeUnit;  
    /**  
    /**
        assertFalse("primary catalog must have files", primaryCatalog.isEmpty());
 * this file be licensed under the Apache-2.0 license or a
            assertEquals("catalog must be preserved after restart", catalogBefore, catalogAfter);  
        Set<String> primaryCatalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(primaryShard);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.shard.IndexShardTestCase;  
        // Replica must have same catalog as primary
    public void testPrimaryRestartRecoversFromRemoteStore() throws Exception {
        ensureGreen(INDEX_NAME);  
        // Find the new replica  
            assertTrue("recovered primary must use DataFormatAwareReadOnlyEngine", indexer instanceof DataFormatAwareReadOnlyEngine);
        // Record primary catalog
     */  
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        ensureGreen(INDEX_NAME);
            String newPrimary = primaryNodeName();
     * Restart the warm primary node — after restart, the engine must recover
            .indices()  
        String primaryNode = primaryNodeName();
        // Restart the primary node
    }
 * or when a new replica is allocated to a fresh node.
    public void testNewReplicaRecoversFromRemoteStore() throws Exception {  
public class DataFormatAwareReadonlyEngineRemoteStoreRecoveryIT extends DataFormatAwareReadonlyEngineBaseIT {  
        internalCluster().startClusterManagerOnlyNode();
            .get();  
            IndexShard recovered = getIndexShard(newPrimary);
import org.opensearch.index.engine.DataFormatAwareReadOnlyEngine;  
        String primaryNode = primaryNodeName();
        IndexShard primaryShard = getIndexShard(primaryNode);  
            .prepareUpdateSettings(INDEX_NAME)
        internalCluster().startClusterManagerOnlyNode();
 */
        // Create warm index with 0 replicas
    }
            Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(recovered);
        String replicaNode = getClusterState().nodes().get(replicaNodeId).getName();
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(primaryShard);
     * from remote store and maintain the same catalog.
 * Verifies that a warm index can recover from remote store after a node restart  
/**
        }, 60, TimeUnit.SECONDS);
/*  
        createHotIndexAndTierToWarm(0);
            Indexer indexer = IndexShardTestCase.getIndexer(recovered);  
import org.opensearch.common.settings.Settings;
