            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), new ByteSizeValue(16, ByteSizeUnit.GB).toString())
/**
    /** Hot DFA index settings (not warm) — used for initial index creation. */  
 *
        String primaryNode = primaryNodeName();  
    protected Settings featureFlagSettings() {  
import org.opensearch.index.engine.exec.Indexer;
        return super.dfaIndexSettings(replicaCount);
            "primary after warm flip must use DataFormatAwareReadOnlyEngine, got: " + indexer.getClass().getSimpleName(),
 * the warm tier. The read-only engine is the flip target when a shard is  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 * <p>Flow: create hot DFA index → index docs → close → mark warm → reopen → verify engine.  
            .build();
        // Verify basic engine properties  
    @Override
import org.opensearch.test.OpenSearchIntegTestCase;
        IndexShard primaryShard = getIndexShard(primaryNode, INDEX_NAME);
 *
        client().admin()  
        // Add file cache (required for warm directory stack) on top of the base remote store settings
    protected boolean addMockIndexStorePlugin() {
    }
import org.opensearch.common.util.FeatureFlags;
            .indices()
        ensureGreen(INDEX_NAME);  
    }
 * Integration tests for the read-only engine on indices that transition to
import org.opensearch.index.engine.DataFormatAwareReadOnlyEngine;  
    public void testReadOnlyEngineAfterWarmFlip() throws Exception {  
        // The primary should now be using DataFormatAwareReadOnlyEngine
        internalCluster().startDataAndWarmNodes(2);
        // Close → mark warm → reopen
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(hotDfaIndexSettings(0)).get();
import org.opensearch.core.common.unit.ByteSizeValue;
        return Settings.builder().put(super.featureFlagSettings()).put(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG, true).build();
        return Settings.builder()
     * the primary uses DataFormatAwareReadOnlyEngine.
import org.opensearch.index.shard.IndexShardTestCase;  
        client().admin().indices().prepareOpen(INDEX_NAME).get();
package org.opensearch.composite;
            indexer instanceof DataFormatAwareReadOnlyEngine  
 * compatible open source license.
    @Override
 */  
 */
        ensureGreen(INDEX_NAME);  
import org.opensearch.common.settings.Settings;
public class DataFormatAwareWarmEngineIT extends DataFormatAwareReplicationBaseIT {  
     * Verifies that after marking a DFA index as warm (close → update → reopen),  
        // Create as hot DFA index, index docs, flush
            .put(super.nodeSettings(nodeOrdinal))  
import org.opensearch.node.Node;
import org.opensearch.index.IndexModule;
        internalCluster().startClusterManagerOnlyNode();
            .get();
            .prepareUpdateSettings(INDEX_NAME)
    }  
        return false;  
    private Settings hotDfaIndexSettings(int replicaCount) {
import org.opensearch.index.shard.IndexShard;
 * this file be licensed under the Apache-2.0 license or a
        Indexer indexer = IndexShardTestCase.getIndexer(primaryShard);
     */
        client().admin().indices().prepareClose(INDEX_NAME).get();
    protected Settings nodeSettings(int nodeOrdinal) {  
 * SPDX-License-Identifier: Apache-2.0
    }  
        assertTrue(
        assertFalse("read-only primary must not identify as replica", indexer.isReplicaIndexer());
            .setSettings(Settings.builder().put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true))  
    /**
import org.opensearch.core.common.unit.ByteSizeUnit;  
/*  
        );
        indexDocs(10);
 * reopened after being marked with {@code isWarmIndex()}.
        assertNotNull("primary shard must have an indexer", indexer);  
}
    @Override
        client().admin().indices().prepareFlush(INDEX_NAME).get();
 * The OpenSearch Contributors require contributions made to  
    }  
        indexer.ensureOpen();
