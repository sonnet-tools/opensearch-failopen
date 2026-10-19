        internalCluster().startClusterManagerOnlyNode();  
    }  
    }
    public void testDropRandomNodeDuringReplication() throws Exception {
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        final int docCount = scaledRandomIntBetween(10, 200);
        client().prepareIndex(INDEX_NAME).setId(Integer.toString(docCount)).setSource("field", "value" + docCount).execute().get();
    public Settings indexSettings() {  
 *
/*  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        refresh();
        }
 */  
import org.opensearch.indices.replication.common.ReplicationType;
        refresh();  
        // TODO: Randomly enable remote store on these tests.
        for (int i = 0; i < docCount; i++) {  
        return builder.build();  
        final int docCount = scaledRandomIntBetween(10, 200);
        internalCluster().fullRestart();
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();  
        final int docCount = scaledRandomIntBetween(10, 200);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas())
            // reset shard & replica count to random values set by OpenSearchIntegTestCase.  
        }
        internalCluster().restartRandomDataNode();
        ensureYellow(INDEX_NAME);
public class SegmentReplicationSuiteIT extends SegmentReplicationBaseIT {  
        createIndex(INDEX_NAME);
        for (int i = 0; i < docCount; i++) {  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);  
package org.opensearch.indices.replication;
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();
        final Settings.Builder builder = Settings.builder()
    }
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.common.settings.Settings;  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, minNumDataNodes = 2)
        ensureGreen(INDEX_NAME);  
    @Before
import org.opensearch.cluster.metadata.IndexMetadata;
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();  
import org.junit.Before;  
}
    public void testFullRestartDuringReplication() throws Exception {  
    @Override
        ensureGreen(INDEX_NAME);
    }  
        for (int i = 0; i < docCount; i++) {
    }
 * SPDX-License-Identifier: Apache-2.0
    public void testDeleteIndexWhileReplicating() throws Exception {
        }
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
    }  
    public void setup() {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards())
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startDataOnlyNode();  
        internalCluster().startNode();
        final int docCount = scaledRandomIntBetween(10, 200);
        verifyStoreContent();
        }
        internalCluster().startClusterManagerOnlyNodes(1);  
        refresh(INDEX_NAME);  
        for (int i = 0; i < docCount; i++) {
    public void testBasicReplication() throws Exception {  
            .put(super.indexSettings())
        client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).actionGet();  
        internalCluster().ensureAtLeastNumDataNodes(2);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        refresh(INDEX_NAME);
 * compatible open source license.
        ensureGreen(INDEX_NAME);
