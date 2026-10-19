    public void testWarmReplicaReceivesReplication() throws Exception {
        // Verify catalog convergence between primary and replica
 * Verifies that warm replicas receive segment replication from the warm primary  
        // Find replica node  
import org.opensearch.index.engine.DataFormatAwareReadOnlyEngine;
        String replicaNode = getClusterState().nodes().get(replicaNodeId).getName();
    }
        assertFalse("primary catalog must have files", primaryCatalog.isEmpty());
 * compatible open source license.
        // Both primary and replica should use DataFormatAwareReadOnlyEngine
        Set<String> primaryCatalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(primaryShard);  
        internalCluster().startDataAndWarmNodes(2);
        IndexShard primaryShard = getIndexShard(primaryNode);
}  
 */
/**
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;  
        IndexShard replicaShard = getIndexShard(replicaNode);  
 * and have converged catalog snapshots.
        // 2 nodes: primary + replica  
 */  
/*  
import org.opensearch.index.shard.IndexShardTestCase;
        // Replica catalog must match primary
import org.opensearch.index.shard.IndexShard;  
        String replicaNodeId = getClusterState().routingTable().index(INDEX_NAME).shard(0).replicaShards().get(0).currentNodeId();
        Set<String> replicaCatalog = DataFormatAwareITUtils.catalogFilesExcludingSegments(replicaShard);  
        assertEquals("replica catalog must match primary", primaryCatalog, replicaCatalog);
        createHotIndexAndTierToWarm(1);  
        internalCluster().startClusterManagerOnlyNode();
 *
        Indexer primaryIndexer = IndexShardTestCase.getIndexer(primaryShard);
package org.opensearch.composite;
public class DataFormatAwareReadonlyEngineReplicationIT extends DataFormatAwareReadonlyEngineBaseIT {  
 * this file be licensed under the Apache-2.0 license or a
        String primaryNode = primaryNodeName();  
 * The OpenSearch Contributors require contributions made to  
        assertTrue("warm primary must use DataFormatAwareReadOnlyEngine", primaryIndexer instanceof DataFormatAwareReadOnlyEngine);  
import org.opensearch.index.engine.exec.Indexer;
