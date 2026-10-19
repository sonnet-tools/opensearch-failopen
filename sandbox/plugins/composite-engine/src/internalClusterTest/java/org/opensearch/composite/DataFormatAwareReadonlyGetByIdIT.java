        internalCluster().startDataAndWarmNodes(2);
 * compatible open source license.
        Indexer indexer = IndexShardTestCase.getIndexer(primaryShard);
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
public class DataFormatAwareReadonlyGetByIdIT extends DataFormatAwareReadonlyEngineBaseIT {  
        assertTrue(
import org.opensearch.index.engine.exec.Indexer;
            indexer instanceof DataFormatAwareReadOnlyEngine
import org.opensearch.index.shard.IndexShardTestCase;  
 * warm, a document is still resolvable by id via the read-only row path (the warm engine has no version map).  
import org.opensearch.action.get.GetResponse;
            "warm primary must use DataFormatAwareReadOnlyEngine, got: " + indexer.getClass().getSimpleName(),  
        internalCluster().startClusterManagerOnlyNode();  
            assertEquals(cnt++, ((Number) resp.getSourceAsMap().get("field_number")).longValue());
        long cnt = 1;
 */
            assertTrue("replica get-by-id must find the replicated doc via rows", resp.isExists());
        // Confirm the warm primary really runs the read-only engine.
 * this file be licensed under the Apache-2.0 license or a
            assertNotNull(resp.getSourceAsMap().get("field_text"));
    }
            assertEquals(1L, resp.getVersion());  
 * The OpenSearch Contributors require contributions made to  
}  
/*  
            assertNotNull(resp.getSourceAsMap().get("field_keyword"));  
 */  
@AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/21803")
import java.util.List;
/**
        }
package org.opensearch.composite;
 * End-to-end get-by-id coverage for {@link DataFormatAwareReadOnlyEngine}: after an index is tiered to
    public void testGetByIdFromWarmReadOnlyEngine() throws Exception {
        );
        IndexShard primaryShard = getIndexShard(primaryNodeName());  
 * SPDX-License-Identifier: Apache-2.0
        List<String> ids = createHotIndexAndTierToWarm(0); // indexes ids 0..49 (field_text="value_<i>", field_number=<i>), flush, flip to
        for (String id : ids) {
            GetResponse resp = client().prepareGet(INDEX_NAME, id).setRealtime(false).get();  
import org.opensearch.index.engine.DataFormatAwareReadOnlyEngine;  
                                                           // warm  
import org.opensearch.index.shard.IndexShard;
 *
