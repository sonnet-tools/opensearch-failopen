}
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.action.index.IndexResponse;
        ensureGreen(INDEX_NAME);
 * Companion to {@link DataFormatAwareUpdateIT}.  
        ensureYellowAndNoInitializingShards(INDEX_NAME);  
        // Disable the final append-only setting at index creation to allow updates.
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("new_text", resp.getSourceAsMap().get("field_text"));
            .get();
        assertEquals(DocWriteResponse.Result.UPDATED, updated.getResult());
 */  
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
import org.opensearch.cluster.metadata.IndexMetadata;  
public class DataFormatAwareReplicaUpdateIT extends DataFormatAwareReplicationBaseIT {
        assertEquals(1L, created.getVersion());
 * SPDX-License-Identifier: Apache-2.0
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
            .setId("k1")
            .setSource("field_text", "new_text", "field_keyword", "new_kw", "field_number", 2L)  
/*  
        IndexResponse updated = client().prepareIndex(INDEX_NAME)
            .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)  
            .setId("k1")
            .put(dfaIndexSettings(1)) // 1 replica, segment replication, composite parquet+lucene
    public void testUpdatedDocVisibleOnReplica() throws Exception {  
            .get();  
/**
package org.opensearch.composite;
    }
        GetResponse resp = client().prepareGet(INDEX_NAME, "k1").setPreference("_only_nodes:" + replicaNode).setRealtime(false).get();
 * The OpenSearch Contributors require contributions made to  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            .build();
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).get();
        IndexResponse created = client().prepareIndex(INDEX_NAME)  
        internalCluster().startDataOnlyNodes(2);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        Settings settings = Settings.builder()
        assertEquals(DocWriteResponse.Result.CREATED, created.getResult());
        assertTrue("replica must resolve the updated doc via rows", resp.isExists());  
        assertCatalogSnapshotsConverged(INDEX_NAME);
import org.opensearch.common.settings.Settings;
        assertEquals(2L, resp.getVersion());  
        String replicaNode = replicaNodeNames().get(0);
 * compatible open source license.
        // Verify the replica resolves the updated row.  
        assertEquals(2L, updated.getVersion());  
        assertEquals("new_kw", resp.getSourceAsMap().get("field_keyword"));
 *
            .setSource("field_text", "old_text", "field_keyword", "old_kw", "field_number", 1L)
import org.opensearch.action.get.GetResponse;
import org.opensearch.action.DocWriteResponse;  
 * Verifies that primary-side updates become visible on replicas through segment replication.
 */
        internalCluster().startClusterManagerOnlyNode();
        // Refresh, then wait for segment replication to carry the updated segments to the replica.
