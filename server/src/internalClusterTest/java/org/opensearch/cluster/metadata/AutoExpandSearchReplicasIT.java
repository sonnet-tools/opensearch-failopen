 * The OpenSearch Contributors require contributions made to  
        internalCluster().startSearchOnlyNode();
import org.opensearch.common.unit.TimeValue;  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(searchNode));  
 */  
 * this file be licensed under the Apache-2.0 license or a
        // Enable auto expand for search replica
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
        internalCluster().startSearchOnlyNode();
 *
            .get();
        // Add 1 more search nodes  
import org.opensearch.indices.replication.common.ReplicationType;
    }  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        // Add 1 more search nodes  
            indexName,
        );  
        createIndex(  
package org.opensearch.cluster.metadata;
        // Stop a node which hosts search replica
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        assertBusy(() -> assertEquals(1, getNumShards(indexName).numSearchReplicas));  
import org.opensearch.cluster.routing.UnassignedInfo;
public class AutoExpandSearchReplicasIT extends RemoteStoreBaseIntegTestCase {  
 * SPDX-License-Identifier: Apache-2.0
            .prepareUpdateSettings(indexName)
import org.opensearch.common.settings.Settings;
/*  
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        ensureGreen();
        internalCluster().startDataOnlyNode();
                .build()
import org.opensearch.test.InternalTestCluster;  
 * compatible open source license.
    public void testAutoExpandSearchReplica() throws Exception {
        String indexName = "test";  
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        assertBusy(() -> assertEquals(2, getNumShards(indexName).numSearchReplicas));  
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMillis(0))
        internalCluster().startDataOnlyNode();
        client().admin()  
        String searchNode = internalCluster().startSearchOnlyNode();  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
}
        assertBusy(() -> assertEquals(1, getNumShards(indexName).numSearchReplicas));
        assertBusy(() -> assertEquals(2, getNumShards(indexName).numSearchReplicas));
        // Create index with 1 primary, 1 replica and 1 search replica shards
import org.opensearch.test.OpenSearchIntegTestCase;
            .setSettings(Settings.builder().put("index.auto_expand_search_replicas", "0-all"))  
        internalCluster().startClusterManagerOnlyNode();
        // Create a cluster with 2 data nodes and 1 search node  
            .indices()
            Settings.builder()
