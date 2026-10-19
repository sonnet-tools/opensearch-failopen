 * this file be licensed under the Apache-2.0 license or a
            "promoted replica must use DataFormatAwareReadOnlyEngine, got: " + newIndexer.getClass().getSimpleName(),  
        Indexer newIndexer = IndexShardTestCase.getIndexer(newPrimaryShard);
        // Verify new primary uses DataFormatAwareReadOnlyEngine  
}
 */  
 * SPDX-License-Identifier: Apache-2.0
        internalCluster().startDataAndWarmNodes(3);  
        String newPrimary = primaryNodeName();
import org.opensearch.index.shard.IndexShardTestCase;
public class DataFormatAwareReadonlyEngineReplicaPromotionIT extends DataFormatAwareReadonlyEngineBaseIT {
        IndexShard primaryShard = getIndexShard(warmPrimary);
        createHotIndexAndTierToWarm(1);
            .add(new org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand(INDEX_NAME, 0, warmPrimary, true))
import org.opensearch.index.shard.IndexShard;  
        // 3 nodes: primary + replica + spare for re-allocation after promotion
        assertTrue("primary term must advance", newPrimaryShard.getOperationPrimaryTerm() >= 2);
        // Record state before promotion  
            .actionGet();  
 * Verifies that when the warm primary is cancelled (via reroute), the replica  
        client().admin()
            .cluster()
        // Cancel primary allocation → triggers promotion  
        Set<String> catalogAfter = DataFormatAwareITUtils.catalogFilesExcludingSegments(newPrimaryShard);
    }
        internalCluster().startClusterManagerOnlyNode();
 * is promoted to primary and continues using DataFormatAwareReadOnlyEngine
        IndexShard newPrimaryShard = getIndexShard(newPrimary);  
/**
 * with the same catalog files.
import java.util.Set;  
            .execute()
    public void testReplicaPromotedAfterPrimaryCancelled() throws Exception {  
 *
            newIndexer instanceof DataFormatAwareReadOnlyEngine
 * compatible open source license.
import org.opensearch.index.engine.exec.Indexer;
        );
        // Verify catalog preserved
        assertEquals("catalog must be preserved across promotion", catalogBefore, catalogAfter);  
            .prepareReroute()  
        assertTrue(
/*  
        ensureGreen(INDEX_NAME);
        assertFalse("catalog must have files", catalogBefore.isEmpty());
        Set<String> catalogBefore = DataFormatAwareITUtils.catalogFilesExcludingSegments(primaryShard);  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.engine.DataFormatAwareReadOnlyEngine;
        String warmPrimary = primaryNodeName();
        // Verify primary term advanced
package org.opensearch.composite;
 */  
