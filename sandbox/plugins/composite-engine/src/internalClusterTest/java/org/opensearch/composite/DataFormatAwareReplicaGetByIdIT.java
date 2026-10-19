/**  
            assertNotNull(resp.getSourceAsMap().get("field_text"));  
        int maxDocs = randomIntBetween(1, 20);  
 * The OpenSearch Contributors require contributions made to  
public class DataFormatAwareReplicaGetByIdIT extends DataFormatAwareReplicationBaseIT {
 * compatible open source license.
        // Ensure the replica's catalog has converged with the primary (segments replicated).
import java.util.List;
import java.util.Collections;  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
 * this file be licensed under the Apache-2.0 license or a
        Collections.shuffle(ids, random());
            assertEquals(1L, resp.getVersion());
 */
            assertTrue("replica get-by-id must find the replicated doc via rows", resp.isExists());
            // Route the GET to the replica copy so DataFormatAwareNRTReplicationEngine#getById serves it.
 * engine has no live version map) once segment replication has propagated it.  
        createDfaIndex(1); // 1 replica, 2 data nodes (from base)
            GetResponse resp = client().prepareGet(INDEX_NAME, id).setPreference("_only_nodes:" + replicaNode).setRealtime(false).get();  
 * End-to-end get-by-id coverage for {@link org.opensearch.index.engine.DataFormatAwareNRTReplicationEngine}:
        String replicaNode = replicaNodeNames().get(0);
}
        // data files beyond segments_N, which an empty index never produces (randomInt(20) can be 0).
 *
 * a doc indexed on the primary is resolvable by id from a replica shard via the row path (the replica
            assertNotNull(resp.getSourceAsMap().get("field_keyword"));
 */  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
package org.opensearch.composite;
 * SPDX-License-Identifier: Apache-2.0
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
import org.opensearch.action.get.GetResponse;  
/*  
        }
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
        List<String> ids = indexDocs(maxDocs);     // ids 1..20, RefreshPolicy.NONE
        // At least one doc: assertCatalogSnapshotsConverged asserts the lucene index/ has segment
        assertCatalogSnapshotsConverged(INDEX_NAME);
        for (String id : ids) {
    }  
import org.opensearch.test.OpenSearchIntegTestCase;
    public void testGetByIdFromReplica() throws Exception {  
