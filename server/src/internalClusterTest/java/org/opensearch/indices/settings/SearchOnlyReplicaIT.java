        int numSearchReplicas = 1;
        ensureGreen(TEST_INDEX);
            .cluster()
        );
}  
    public void testSearchReplicaRoutingPreferenceWhenSearchReplicaUnassigned() {  
        // Ensure search shard is recovered
        // Stop Node which hosts the search replica
        // set preference to search replica here - we default to this when there are  
        createIndex(TEST_INDEX);  
    }
        internalCluster().startSearchOnlyNode();
    public void testUnableToAllocateSearchReplicaWontBlockRegularReplicaAllocation() {
        internalCluster().restartNode(searchNode, new InternalTestCluster.RestartCallback() {
        return getClusterState().routingTable().index(TEST_INDEX).shards().values().stream().findFirst().get();
        ensureYellow(TEST_INDEX);
        // search request can land on either writer or reader  
        indexSingleDoc(TEST_INDEX, true);
        // add another node for the search replica  
        internalCluster().startDataOnlyNode();
        // add 2 nodes for the replicas  
package org.opensearch.indices.settings;
                .put(indexSettings())
    }
        assertActiveShardCounts(numSearchReplicas, numWriterReplicas);
            .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0ms") // so that after we punt a node we can immediately try to
    /**
        createIndex(  
        createIndex(TEST_INDEX);  
        assertEquals(expectedWriteReplicaCount, indexShardRoutingTable.writerReplicas().stream().filter(ShardRouting::active).count());
            indexShardRoutingTable.replicaShards().stream().filter(ShardRouting::active).count()
    private static final String TEST_INDEX = "test_index";  
import static org.opensearch.cluster.routing.OperationRouting.STRICT_SEARCH_REPLICA_ROUTING_ENABLED;  
                .build()
            }
        assertActiveSearchShards(numSearchReplicas);
        ensureGreen(TEST_INDEX);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numWriterReplicas)
            .get();
        final String searchNode = internalCluster().startSearchOnlyNode();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.cluster.routing.Preference;
                assertActiveSearchShards(0);  
        assertThat(
        createIndex(TEST_INDEX);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numWriterReplicas)
        ensureGreen(TEST_INDEX);
    private void assertActiveSearchShards(int expectedSearchReplicaCount) {
            .prepareUpdateSettings(TEST_INDEX)
        ensureGreen(TEST_INDEX);  
        int numSearchReplicas = 1;  
        // search request will fail since it will route only to search replica but it's not available  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        // Restart Search Node  
        return Settings.builder()  
        );
            public Settings onNodeStopped(String nodeName) throws Exception {  
        );  
        int numSearchReplicas = 1;
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
        client().admin()
        // while red our search shard is still searchable
/*  
    }
        internalCluster().startSearchOnlyNode();
    }
        int numWriterReplicas = 1;
    public void testFailoverWithSearchReplica_WithWriterReplicas() throws IOException {
        client().admin()
        // add 2 nodes for the replicas
        // Set cluster.routing.search_replica.strict as false
 * The OpenSearch Contributors require contributions made to  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName));
import org.opensearch.cluster.ClusterState;
        ensureGreen(TEST_INDEX);
        createIndex(TEST_INDEX, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1).build());  
        int numWriterReplicas = 1;  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName));
        assertActiveShardCounts(numSearchReplicas, 0);
            .build();
            expectedWriteReplicaCount,  
        ensureYellow(TEST_INDEX);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        ensureGreen(TEST_INDEX);
        assertEquals(activeCount, clusterState.getRoutingNodes().shards(r -> r.active() && !r.primary()).size());  
        );
        String primaryNodeName = internalCluster().startDataOnlyNode();
        assertEquals(nodeId, indexShardRoutingTable.primaryShard().currentNodeId());  
    public void testFailoverWithSearchReplicaWhenSearchNodeRestarts() throws Exception {  
public class SearchOnlyReplicaIT extends RemoteStoreBaseIntegTestCase {
            SearchPhaseExecutionException.class,
            .setTransientSettings(Settings.builder().put(STRICT_SEARCH_REPLICA_ROUTING_ENABLED.getKey(), false))
        internalCluster().startDataOnlyNodes(3);  
        String searchNode = internalCluster().startSearchOnlyNode();
            clusterState.getRoutingNodes().shards(r -> r.active() && !r.primary() && !r.isSearchOnly()).size()
        createIndex(  
        assertEquals(
        // add another node for the search replica  
        SearchResponse response = client().prepareSearch(TEST_INDEX).setPreference(null).setQuery(QueryBuilders.matchAllQuery()).get();
        // By default cluster.routing.search_replica.strict is set as true
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        IndexShardRoutingTable indexShardRoutingTable = getIndexShardRoutingTable();
 *
            .get();  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numWriterReplicas)
                return super.onNodeStopped(nodeName);
            .get();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
                .build()  
    public void testFailoverWithSearchReplicaWhenNodeLeavesCluster() throws IOException {  
        ensureGreen(TEST_INDEX);  
import org.opensearch.action.support.WriteRequest;  
import org.opensearch.indices.replication.common.ReplicationType;  
        // Ensure search shard is recovered
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 2))  
        assertActiveSearchShards(2);
    }
            expectedWriteReplicaCount + expectedSearchReplicaCount,  
        // assert settings
    }  
        // assert routing nodes
        createIndex(
    @Override
        String nodeId = response.getHits().getAt(0).getShard().getNodeId();
        // search replicas but tests will randomize this value if unset
        // assert shards are on separate nodes & all active  
        internalCluster().startDataOnlyNode();
        assertActiveSearchShards(1);
import java.io.IOException;
        // When cluster.routing.search_replica.strict is set as false, and no assigned search replica is available;  
            Settings.builder()
            .setQuery(QueryBuilders.matchAllQuery())
        createIndex(
        nodeId = response.getHits().getAt(0).getShard().getNodeId();  
        internalCluster().startClusterManagerOnlyNode();
        assertEquals("all shards failed", throwable.getMessage());  
            TEST_INDEX,
import static org.hamcrest.core.IsEqual.equalTo;
import org.opensearch.common.settings.Settings;
    private IndexShardRoutingTable getIndexShardRoutingTable() {  
        ensureYellow(TEST_INDEX);
        );
        ensureYellowAndNoInitializingShards(TEST_INDEX);  
                .build()  
        Metadata metadata = client().admin().cluster().prepareState().get().getState().metadata();
        client().prepareIndex(TEST_INDEX).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();  
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testUnableToAllocateRegularReplicaWontBlockSearchReplicaAllocation() {  
        // Set cluster.routing.search_replica.strict as false
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)  
        ensureYellowAndNoInitializingShards(TEST_INDEX);
        SearchResponse response = client().prepareSearch(TEST_INDEX)
        internalCluster().startClusterManagerOnlyNode();
    }  
                equalTo(indexShardRoutingTable.searchOnlyReplicas().get(0).currentNodeId())  
        // Ensure search shard is unassigned  
        client().admin()  
        assertHitCount(client(searchNode).prepareSearch(TEST_INDEX).setSize(0).setPreference("_only_local").get(), 1);
        );
        internalCluster().startDataOnlyNode();
import org.opensearch.test.InternalTestCluster;
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
        assertActiveShardCounts(numSearchReplicas, numWriterReplicas);
        internalCluster().startClusterManagerOnlyNode();
        assertEquals(
                .build()
     */  
        // remove all search shards  
import org.opensearch.index.query.QueryBuilders;
        ensureGreen(TEST_INDEX);  
        );
        createIndex(TEST_INDEX, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1).build());  
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
        // stop the primary and ensure search shard is not promoted:  
        assertActiveSearchShards(numSearchReplicas);
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  
        Throwable throwable = assertThrows(
        assertActiveSearchShards(1);  
        // Add a node and ensure search shard will get assigned
    }
        assertActiveShardCounts(0, numWriterReplicas);  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numWriterReplicas)  
                .put(indexSettings())
            .indices()
        // When cluster.routing.search_replica.strict is set as true, and no assigned search replica is available,
    private final String expectedFailureMessage = "To set index.number_of_search_replicas, index.replication.type must be set to SEGMENT";
                .put(indexSettings())  
            Settings.builder()
        indexSingleDoc(TEST_INDEX, true);
        internalCluster().startClusterManagerOnlyNode();
        String nodeId = response.getHits().getAt(0).getShard().getNodeId();
    public void testSearchReplicaRoutingPreference() throws IOException {
            TEST_INDEX,
            .indices()
        createIndex(  
        internalCluster().startDataOnlyNode();
    }
        });  
        assertActiveShardCounts(expectedSearchReplicaCount, 0);  
        internalCluster().startClusterManagerOnlyNode();
        // assert search replica count
        // stop the primary and ensure search shard is not promoted:
        internalCluster().startDataOnlyNode();
            nodeId,  
        // add back a node
        ensureGreen(TEST_INDEX);
                                                                          // reallocate after node left.
        String nodeId = response.getHits().getAt(0).getShard().getNodeId();  
        assertActiveSearchShards(1);  
        ensureYellow(TEST_INDEX);
                equalTo(indexShardRoutingTable.primaryShard().currentNodeId()),
        ensureGreen(TEST_INDEX);
    public void testSearchReplicaScaling() {  
        assertActiveSearchShards(0);
        int numWriterReplicas = 0;  
        client().prepareIndex(TEST_INDEX).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        assertActiveShardCounts(numSearchReplicas, 0); // 1 repl is inactive that was promoted to primary
                                                       // removed.
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numWriterReplicas)
        internalCluster().startSearchOnlyNode();
    public void testFailoverWithSearchReplica_WithoutWriterReplicas() throws IOException {
            .prepareUpdateSettings()
            .cluster()  
        int numWriterReplicas = 1;
        indexShardRoutingTable = getIndexShardRoutingTable();
            .get();
        int numSearchReplicas = 1;
        );
        internalCluster().startClusterManagerOnlyNode();  
        assertEquals(1, numSearchReplicas);
        internalCluster().startClusterManagerOnlyNode();
        ClusterState clusterState = getClusterState();
        assertHitCount(client(searchNode).prepareSearch(TEST_INDEX).setSize(0).setPreference("_only_local").get(), 1);  
        ensureGreen(TEST_INDEX);  
        // By default cluster.routing.search_replica.strict is set as true
            @Override
            TEST_INDEX,  
        ensureYellowAndNoInitializingShards(TEST_INDEX);
        IndexShardRoutingTable indexShardRoutingTable = getIndexShardRoutingTable();  
            Settings.builder()
        internalCluster().startSearchOnlyNode();
    private void assertActiveShardCounts(int expectedSearchReplicaCount, int expectedWriteReplicaCount) {
        IndexShardRoutingTable indexShardRoutingTable = getIndexShardRoutingTable();
            .prepareUpdateSettings(TEST_INDEX)  
import org.opensearch.test.OpenSearchIntegTestCase;  
        ensureYellow(TEST_INDEX);
                .put(indexSettings())  
import org.opensearch.action.search.SearchPhaseExecutionException;
        // assert cluster state & routing table  
import org.opensearch.cluster.routing.ShardRouting;  
        assertEquals(expectedSearchReplicaCount, indexShardRoutingTable.searchOnlyReplicas().stream().filter(ShardRouting::active).count());  
                .put(indexSettings())  
            .setTransientSettings(Settings.builder().put(STRICT_SEARCH_REPLICA_ROUTING_ENABLED.getKey(), false))  
    }
        int activeCount = expectedSearchReplicaCount + expectedWriteReplicaCount;
        client().prepareIndex(TEST_INDEX).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
 * SPDX-License-Identifier: Apache-2.0
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startDataOnlyNode();  
        assertEquals(nodeId, indexShardRoutingTable.searchOnlyReplicas().get(0).currentNodeId());  
        internalCluster().startDataOnlyNode();  
            anyOf(
        internalCluster().startClusterManagerOnlyNode();
        // When cluster.routing.search_replica.strict is set as false, and assigned search replica is available;
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        int numSearchReplicas = 1;
        internalCluster().startDataOnlyNode();
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexShardRoutingTable indexShardRoutingTable = getIndexShardRoutingTable();
            () -> client().prepareSearch(TEST_INDEX).setPreference(null).setQuery(QueryBuilders.matchAllQuery()).get()  
import static org.hamcrest.Matchers.anyOf;  
        // start a node for our search replica  
    public Settings indexSettings() {
     * Helper to assert counts of active shards for each type.
        ensureYellow(TEST_INDEX);
                // Ensure search shard is unassigned
        ensureYellowAndNoInitializingShards(TEST_INDEX);
        );  
        internalCluster().startDataOnlyNode();
        // Add another search node and search replica  
import org.opensearch.action.search.SearchResponse;
        String primaryNodeName = internalCluster().startDataOnlyNode();
            TEST_INDEX,
            Settings.builder()  
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0))
            .prepareUpdateSettings()
            TEST_INDEX,
        // assert routing table
        ensureGreen(TEST_INDEX);
        client().prepareIndex(TEST_INDEX).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        // search request will succeed  
        // When cluster.routing.search_replica.strict is set as true, and assigned search replica is available;
        SearchResponse response = client().prepareSearch(TEST_INDEX).setPreference(null).setQuery(QueryBuilders.matchAllQuery()).get();
            .setPreference(Preference.SEARCH_REPLICA.type())  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            )
        assertEquals(expectedSearchReplicaCount, clusterState.getRoutingNodes().shards(r -> r.active() && r.isSearchOnly()).size());
        String searchNode = internalCluster().startSearchOnlyNode();
        internalCluster().startSearchOnlyNode();
 */  
            .get();
import org.opensearch.cluster.metadata.Metadata;  
    public void testSearchReplicaRoutingPreferenceWhenSearchReplicaAssigned() {  
        assertEquals(nodeId, indexShardRoutingTable.searchOnlyReplicas().get(0).currentNodeId());
        int numWriterReplicas = 1;  
 * this file be licensed under the Apache-2.0 license or a
        ensureRed(TEST_INDEX);  
        assertActiveSearchShards(0);
        internalCluster().startSearchOnlyNode();  
        response = client().prepareSearch(TEST_INDEX).setPreference(null).setQuery(QueryBuilders.matchAllQuery()).get();
        client().admin()  
        int numSearchReplicas = Integer.parseInt(metadata.index(TEST_INDEX).getSettings().get(SETTING_NUMBER_OF_SEARCH_REPLICAS));  
                ensureYellowAndNoInitializingShards(TEST_INDEX);
        ensureYellow(TEST_INDEX);
        internalCluster().startSearchOnlyNode();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(searchNode));
 * compatible open source license.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .build()
                .put("index.refresh_interval", "40ms") // set lower interval so replica attempts replication cycles after primary is  
        // search request will fall back to querying writers
            Settings.builder()
        internalCluster().startDataOnlyNode();
    }
