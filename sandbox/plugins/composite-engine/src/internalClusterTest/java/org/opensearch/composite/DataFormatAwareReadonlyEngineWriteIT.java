            "warm primary must use DataFormatAwareReadOnlyEngine, got: " + indexer.getClass().getSimpleName(),
/*  
package org.opensearch.composite;
        }
}  
        // Verify catalog has files  
 * compatible open source license.
        createHotIndexAndTierToWarm(0);  
            assertTrue("expected rejection, got: " + e.getMessage(), e.getMessage().contains("does not support"));  
 * this file be licensed under the Apache-2.0 license or a
            client().prepareIndex(INDEX_NAME).setSource("field_text", "fail").get();  
        // Refresh is no-op (should not throw)  
        org.opensearch.cluster.node.DiscoveryNode dn = getClusterState().nodes().resolveNode(primaryNode);  
        String primaryNode = primaryNodeName();  
 * and that flush/refresh are no-ops.
        IndexShard primaryShard = getIndexShard(primaryNode);
import org.opensearch.cluster.node.DiscoveryNodeRole;
 * Verifies that the warm read-only engine rejects all write operations
        internalCluster().startDataAndWarmNodes(2);
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            indexer instanceof DataFormatAwareReadOnlyEngine
 */  
        try {
    public void testWarmEngineFlipAndWriteRejection() throws Exception {  
        );  
import org.opensearch.index.engine.exec.Indexer;  
        Indexer indexer = IndexShardTestCase.getIndexer(primaryShard);
 *
        Set<String> catalogFiles = DataFormatAwareITUtils.catalogFilesExcludingSegments(primaryShard);
        } catch (Exception e) {
 */  
public class DataFormatAwareReadonlyEngineWriteIT extends DataFormatAwareReadonlyEngineBaseIT {
import org.opensearch.index.engine.DataFormatAwareReadOnlyEngine;
import org.opensearch.index.shard.IndexShardTestCase;
 * The OpenSearch Contributors require contributions made to  
        // Index must be rejected
        client().admin().indices().prepareFlush(INDEX_NAME).setForce(true).get();
        // Verify on warm-eligible node
        internalCluster().startClusterManagerOnlyNode();
        assertTrue(  
        assertFalse("catalog must have files after tiering", catalogFiles.isEmpty());
            fail("index should be rejected");
import org.opensearch.index.shard.IndexShard;
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
        // Flush is no-op (should not throw)  
/**  
        // Verify engine type
    }
        assertTrue("primary must be on warm node", dn.getRoles().contains(DiscoveryNodeRole.WARM_ROLE));
