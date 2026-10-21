                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
        // Add a node and ensure search shard will get assigned
        // add 2 nodes for the replicas
        internalCluster().startDataOnlyNode();
        );
import org.opensearch.test.OpenSearchIntegTestCase;
        int numWriterReplicas = 1;
    private void assertActiveShardCounts(int expectedSearchReplicaCount, int expectedWriteReplicaCount) {
                .build()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numWriterReplicas)
package org.opensearch.indices.settings;
        int numWriterReplicas = 1;
        int numSearchReplicas = 1;
        int numSearchReplicas = 1;
            () -> client().prepareSearch(TEST_INDEX).setPreference(null).setQuery(QueryBuilders.matchAllQuery()).get()
    public void testFailoverWithSearchReplica_WithWriterReplicas() throws IOException {
        IndexShardRoutingTable indexShardRoutingTable = getIndexShardRoutingTable();
            .get();
        // add 2 nodes for the replicas
import org.opensearch.cluster.routing.Preference;
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                .put(indexSettings())
                .build()
    public Settings indexSettings() {
        String searchNode = internalCluster().startSearchOnlyNode();
        assertHitCount(client(searchNode).prepareSearch(TEST_INDEX).setSize(0).setPreference("_only_local").get(), 1);
import org.opensearch.test.InternalTestCluster;
        int numSearchReplicas = 1;
import org.opensearch.cluster.ClusterState;
        assertEquals(nodeId, indexShardRoutingTable.searchOnlyReplicas().get(0).currentNodeId());
    }
        String nodeId = response.getHits().getAt(0).getShard().getNodeId();
        // Set cluster.routing.search_replica.strict as false
import org.opensearch.cluster.routing.ShardRouting;
        );
            clusterState.getRoutingNodes().shards(r -> r.active() && !r.primary() && !r.isSearchOnly()).size()
    public void testFailoverWithSearchReplicaWhenNodeLeavesCluster() throws IOException {
        internalCluster().startDataOnlyNode();
        assertEquals(expectedSearchReplicaCount, indexShardRoutingTable.searchOnlyReplicas().stream().filter(ShardRouting::active).count());
import static org.opensearch.cluster.routing.OperationRouting.STRICT_SEARCH_REPLICA_ROUTING_ENABLED;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numWriterReplicas)
import static org.hamcrest.core.IsEqual.equalTo;
        internalCluster().startDataOnlyNode();
        int numSearchReplicas = 1;
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                ensureYellowAndNoInitializingShards(TEST_INDEX);
            indexShardRoutingTable.replicaShards().stream().filter(ShardRouting::active).count()
    }
    }
        assertActiveSearchShards(numSearchReplicas);
        response = client().prepareSearch(TEST_INDEX).setPreference(null).setQuery(QueryBuilders.matchAllQuery()).get();
        String nodeId = response.getHits().getAt(0).getShard().getNodeId();
        ensureYellow(TEST_INDEX);
    private IndexShardRoutingTable getIndexShardRoutingTable() {
        internalCluster().startClusterManagerOnlyNode();
        int activeCount = expectedSearchReplicaCount + expectedWriteReplicaCount;
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
        internalCluster().startSearchOnlyNode();
                assertActiveSearchShards(0);
        internalCluster().startSearchOnlyNode();
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
        ensureYellow(TEST_INDEX);
        // add another node for the search replica
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numWriterReplicas)
        assertActiveShardCounts(numSearchReplicas, 0);
        client().prepareIndex(TEST_INDEX).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        Throwable throwable = assertThrows(
                .put(indexSettings())
        createIndex(
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName));
        Metadata metadata = client().admin().cluster().prepareState().get().getState().metadata();
        // Set cluster.routing.search_replica.strict as false
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
    }
        ensureGreen(TEST_INDEX);
        // stop the primary and ensure search shard is not promoted:
        // Ensure search shard is recovered
    public void testUnableToAllocateRegularReplicaWontBlockSearchReplicaAllocation() {
import org.opensearch.cluster.metadata.Metadata;
     * Helper to assert counts of active shards for each type.
        );
            @Override
        internalCluster().startClusterManagerOnlyNode();
        createIndex(
        createIndex(
        indexShardRoutingTable = getIndexShardRoutingTable();
import org.opensearch.cluster.metadata.IndexMetadata;
        );
        ensureGreen(TEST_INDEX);
        internalCluster().startClusterManagerOnlyNode();
        // remove all search shards
        assertActiveSearchShards(0);
        internalCluster().startDataOnlyNode();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                return super.onNodeStopped(nodeName);
        // add back a node
        // while red our search shard is still searchable
                                                                          // reallocate after node left.
import org.opensearch.common.settings.Settings;
        ensureYellow(TEST_INDEX);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testFailoverWithSearchReplicaWhenSearchNodeRestarts() throws Exception {
        // Ensure search shard is unassigned
        String primaryNodeName = internalCluster().startDataOnlyNode();
            expectedWriteReplicaCount,
        SearchResponse response = client().prepareSearch(TEST_INDEX).setPreference(null).setQuery(QueryBuilders.matchAllQuery()).get();
        assertActiveSearchShards(1);
    }
            TEST_INDEX,
        assertEquals(nodeId, indexShardRoutingTable.primaryShard().currentNodeId());
            .get();
        // Stop Node which hosts the search replica
        ensureGreen(TEST_INDEX);
        assertEquals("all shards failed", throwable.getMessage());
        assertActiveSearchShards(1);
            .cluster()
            .setPreference(Preference.SEARCH_REPLICA.type())
import static org.hamcrest.Matchers.anyOf;
    @Override
        ensureGreen(TEST_INDEX);
            Settings.builder()
        nodeId = response.getHits().getAt(0).getShard().getNodeId();
import org.opensearch.action.search.SearchResponse;
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            TEST_INDEX,
        assertActiveSearchShards(1);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(searchNode));
 *
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        ensureYellowAndNoInitializingShards(TEST_INDEX);
        client().prepareIndex(TEST_INDEX).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        assertEquals(1, numSearchReplicas);
        // search replicas but tests will randomize this value if unset
    public void testFailoverWithSearchReplica_WithoutWriterReplicas() throws IOException {
            .prepareUpdateSettings(TEST_INDEX)
    /**
        assertEquals(nodeId, indexShardRoutingTable.searchOnlyReplicas().get(0).currentNodeId());
        internalCluster().restartNode(searchNode, new InternalTestCluster.RestartCallback() {
            Settings.builder()
        assertEquals(activeCount, clusterState.getRoutingNodes().shards(r -> r.active() && !r.primary()).size());
        String nodeId = response.getHits().getAt(0).getShard().getNodeId();
        assertEquals(
        // assert settings
            .indices()
 * The OpenSearch Contributors require contributions made to
        IndexShardRoutingTable indexShardRoutingTable = getIndexShardRoutingTable();
        IndexShardRoutingTable indexShardRoutingTable = getIndexShardRoutingTable();
        ensureGreen(TEST_INDEX);
    public void testSearchReplicaRoutingPreference() throws IOException {
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
        // assert shards are on separate nodes & all active
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 2))
            TEST_INDEX,
            public Settings onNodeStopped(String nodeName) throws Exception {
            .cluster()
        ensureGreen(TEST_INDEX);
        internalCluster().startSearchOnlyNode();
        // When cluster.routing.search_replica.strict is set as false, and assigned search replica is available;
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
            .indices()
        ensureYellowAndNoInitializingShards(TEST_INDEX);
            expectedWriteReplicaCount + expectedSearchReplicaCount,
        // search request can land on either writer or reader
        internalCluster().startClusterManagerOnlyNode();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numWriterReplicas)
        // search request will fall back to querying writers
                equalTo(indexShardRoutingTable.searchOnlyReplicas().get(0).currentNodeId())
        createIndex(TEST_INDEX, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1).build());
                equalTo(indexShardRoutingTable.primaryShard().currentNodeId()),
        ClusterState clusterState = getClusterState();
            .setTransientSettings(Settings.builder().put(STRICT_SEARCH_REPLICA_ROUTING_ENABLED.getKey(), false))
        // add another node for the search replica
        assertHitCount(client(searchNode).prepareSearch(TEST_INDEX).setSize(0).setPreference("_only_local").get(), 1);
            TEST_INDEX,
        assertActiveSearchShards(2);
        assertActiveShardCounts(expectedSearchReplicaCount, 0);
        // By default cluster.routing.search_replica.strict is set as true
        internalCluster().startDataOnlyNodes(3);
            .prepareUpdateSettings()
        internalCluster().startDataOnlyNode();
        internalCluster().startDataOnlyNode();
    private void assertActiveSearchShards(int expectedSearchReplicaCount) {
        ensureYellowAndNoInitializingShards(TEST_INDEX);
        assertEquals(expectedSearchReplicaCount, clusterState.getRoutingNodes().shards(r -> r.active() && r.isSearchOnly()).size());
        ensureGreen(TEST_INDEX);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName));
            .build();
        int numSearchReplicas = 1;
        SearchResponse response = client().prepareSearch(TEST_INDEX).setPreference(null).setQuery(QueryBuilders.matchAllQuery()).get();
/*
    }
        assertEquals(expectedWriteReplicaCount, indexShardRoutingTable.writerReplicas().stream().filter(ShardRouting::active).count());
        SearchResponse response = client().prepareSearch(TEST_INDEX)
        String searchNode = internalCluster().startSearchOnlyNode();
        createIndex(TEST_INDEX);
    }
    }
        ensureGreen(TEST_INDEX);
        client().admin()
        ensureGreen(TEST_INDEX);
        });
        int numSearchReplicas = Integer.parseInt(metadata.index(TEST_INDEX).getSettings().get(SETTING_NUMBER_OF_SEARCH_REPLICAS));
        // assert routing nodes
        // assert routing table
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numWriterReplicas)
        ensureYellowAndNoInitializingShards(TEST_INDEX);
        assertActiveSearchShards(0);
    }
        );
    public void testSearchReplicaRoutingPreferenceWhenSearchReplicaUnassigned() {
        internalCluster().startClusterManagerOnlyNode();
        );
        // When cluster.routing.search_replica.strict is set as true, and assigned search replica is available;
                .build()
        createIndex(
            TEST_INDEX,
        // By default cluster.routing.search_replica.strict is set as true
        ensureGreen(TEST_INDEX);
        internalCluster().startDataOnlyNode();
            }
}
        // start a node for our search replica
            .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0ms") // so that after we punt a node we can immediately try to
        internalCluster().startSearchOnlyNode();
            .prepareUpdateSettings(TEST_INDEX)
            .get();
        createIndex(
    public void testSearchReplicaRoutingPreferenceWhenSearchReplicaAssigned() {
            )
                // Ensure search shard is unassigned
        // When cluster.routing.search_replica.strict is set as true, and no assigned search replica is available,
        // Ensure search shard is recovered
        indexSingleDoc(TEST_INDEX, true);
        // Add another search node and search replica
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numSearchReplicas)
                                                       // removed.
 * SPDX-License-Identifier: Apache-2.0
        // stop the primary and ensure search shard is not promoted:
        // assert cluster state & routing table
        assertActiveShardCounts(numSearchReplicas, 0); // 1 repl is inactive that was promoted to primary
            .setTransientSettings(Settings.builder().put(STRICT_SEARCH_REPLICA_ROUTING_ENABLED.getKey(), false))
        // set preference to search replica here - we default to this when there are
        );
        // search request will succeed
        ensureYellow(TEST_INDEX);
            Settings.builder()
                .put(indexSettings())
        ensureGreen(TEST_INDEX);
        client().prepareIndex(TEST_INDEX).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        ensureYellow(TEST_INDEX);
                .put("index.refresh_interval", "40ms") // set lower interval so replica attempts replication cycles after primary is
        indexSingleDoc(TEST_INDEX, true);
        int numWriterReplicas = 1;
            .prepareUpdateSettings()
        createIndex(TEST_INDEX, Settings.builder().put(indexSettings()).put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1).build());
        assertActiveShardCounts(numSearchReplicas, numWriterReplicas);
    }
        internalCluster().startClusterManagerOnlyNode();
        // Restart Search Node
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        internalCluster().startSearchOnlyNode();
        IndexShardRoutingTable indexShardRoutingTable = getIndexShardRoutingTable();
        client().prepareIndex(TEST_INDEX).setId("1").setSource("foo", "bar").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE).get();
        internalCluster().startDataOnlyNode();
        assertActiveSearchShards(numSearchReplicas);
    }
        assertActiveShardCounts(0, numWriterReplicas);
        createIndex(TEST_INDEX);
    private static final String TEST_INDEX = "test_index";
        int numWriterReplicas = 1;
        internalCluster().startDataOnlyNode();
        return Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            SearchPhaseExecutionException.class,
        );
    }
     */
        int numWriterReplicas = 0;
        final String searchNode = internalCluster().startSearchOnlyNode();
        // When cluster.routing.search_replica.strict is set as false, and no assigned search replica is available;
import org.opensearch.index.query.QueryBuilders;
                .build()
import org.opensearch.indices.replication.common.ReplicationType;
import java.io.IOException;
                .put(indexSettings())
 */
                .build()
import org.opensearch.action.search.SearchPhaseExecutionException;
    private final String expectedFailureMessage = "To set index.number_of_search_replicas, index.replication.type must be set to SEGMENT";
        internalCluster().startClusterManagerOnlyNode();
        ensureYellow(TEST_INDEX);
    }
            .setQuery(QueryBuilders.matchAllQuery())
        ensureYellow(TEST_INDEX);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
        // search request will fail since it will route only to search replica but it's not available
        client().admin()
    }
            nodeId,
        internalCluster().startDataOnlyNode();
        ensureGreen(TEST_INDEX);
                .put(indexSettings())
        internalCluster().startSearchOnlyNode();
            .get();
        // assert search replica count
    public void testSearchReplicaScaling() {
            Settings.builder()
            anyOf(
        assertActiveShardCounts(numSearchReplicas, numWriterReplicas);
            .get();
        internalCluster().startClusterManagerOnlyNode();
        );
 * compatible open source license.
        internalCluster().startClusterManagerOnlyNode();
        client().admin()
 * this file be licensed under the Apache-2.0 license or a
            Settings.builder()
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0))
        internalCluster().startSearchOnlyNode();
        return getClusterState().routingTable().index(TEST_INDEX).shards().values().stream().findFirst().get();
        ensureRed(TEST_INDEX);
        assertThat(
import org.opensearch.action.support.WriteRequest;
public class SearchOnlyReplicaIT extends RemoteStoreBaseIntegTestCase {
        createIndex(TEST_INDEX);
        String primaryNodeName = internalCluster().startDataOnlyNode();
        client().admin()
    public void testUnableToAllocateSearchReplicaWontBlockRegularReplicaAllocation() {
        assertEquals(
