        for (int i = 0; i < docCount; i++) {  
    public void testStopPrimary_RestoreOnNewNode() throws Exception {
        assertDocCounts(10, searchNode);  
        assertDownloadStats(searchNode, false);  
import org.junit.After;
        assertDocCounts(10, searchNode);  
        }  
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();  
        assertDownloadStats(searchNode, true);  
        // stop the primary
import org.opensearch.indices.recovery.RecoveryState;
            .indices()  
        // Verify the number of primary shards
    }
        assertDocCounts(docCount, searchNode);  
        flush(INDEX_NAME);  
 * compatible open source license.
    }
    protected Path absolutePath;
    }
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    private static void assertDownloadStats(String replica, boolean expectBytesDownloaded) throws InterruptedException, ExecutionException {
    protected Settings nodeSettings(int nodeOrdinal) {
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1))
        final int docCount = 10;
                assertEquals("All SR should be of expected recovery type", recoveryType, recoveryState.getRecoverySource().getType());
        ensureGreen(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startClusterManagerOnlyNode();
        }
    }
        refresh(INDEX_NAME);
                .build()
        ensureGreen(INDEX_NAME);
        final String searchNode = internalCluster().startSearchOnlyNode();
            assertEquals(0, nodeStats.getIndices().getSegments().getRemoteSegmentStats().getDownloadBytesStarted());  
        waitForSearchableDocs(10, primary, searchNode);
            .prepareUpdateSettings(INDEX_NAME)  
        }
 * this file be licensed under the Apache-2.0 license or a
        final String primary = internalCluster().startDataOnlyNode();  
        ensureGreen(INDEX_NAME);
import org.opensearch.common.settings.Settings;
        }
        internalCluster().startClusterManagerOnlyNode();
    @After  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        );  
import org.opensearch.index.SegmentReplicationPerGroupStats;
        ensureGreen(INDEX_NAME);
        }
 * The OpenSearch Contributors require contributions made to  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .indices()  
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        assertRecoverySourceType(searchNode, EXISTING_STORE);
        assertBusy(() -> assertDocCounts(20, searchNode, restoredPrimary));  
        final String primary = internalCluster().startDataOnlyNode();  
    }  
        final int docCount = 10;  
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
/*  
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))
        refresh(INDEX_NAME);
        // Verify the number of replica stats  
        assertDocCounts(docCount, primary);
    }
            .put(super.nodeSettings(nodeOrdinal))
            .get();
        }
        RecoveryResponse recoveryResponse = client().admin().indices().recoveries(new RecoveryRequest(INDEX_NAME)).get();
        createIndex(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        for (int i = docCount; i < docCount * 2; i++) {
        refresh(INDEX_NAME);
    public void teardown() {
        final String searchNode = internalCluster().startSearchOnlyNode();
            .build();
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().nodesStats(new NodesStatsRequest(replica)).get();
        client().admin().cluster().restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME), PlainActionFuture.newFuture());
        ensureGreen(INDEX_NAME);  
        assertRecoverySourceType(searchNode, EXISTING_STORE);
        waitForSearchableDocs(docCount, primary, searchNode);  
        // post restart.
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            ClusterHealthResponse clusterHealthResponse = clusterAdmin().prepareHealth(INDEX_NAME).get();
        assertDownloadStats(searchNode, false);
        assertDocCounts(10, searchNode);
        assertEquals(1, segmentReplicationStatsResponse.getReplicationStats().get(INDEX_NAME).size());
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;  
        for (int i = 0; i < docCount; i++) {
import org.opensearch.index.SegmentReplicationShardStats;  
import org.opensearch.cluster.routing.RecoverySource;  
        });
        ensureGreen(INDEX_NAME);
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
            if (recoveryState.getPrimary() == false) {  
 *
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();  
        final String searchNode = internalCluster().startSearchOnlyNode();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        return Settings.builder()
import org.opensearch.cluster.health.ClusterHealthStatus;
        internalCluster().startClusterManagerOnlyNode();
        assertBusy(() -> assertDocCounts(20, searchNode, writer_replica));  
        ExecutionException {  
            assertTrue(nodeStats.getIndices().getSegments().getRemoteSegmentStats().getDownloadBytesStarted() > 0);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
        // Node stats should show remote download stats as nonzero, use this as a precondition to compare  
        SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
            ClusterHealthResponse clusterHealthResponse = clusterAdmin().prepareHealth(INDEX_NAME).get();  
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();  
    }
    }
        assertBusy(() -> {
        client().admin()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));  
        assertEquals(1, replicaStats.size());
        });  
        assertDocCounts(10, searchNode);
            .get();
            .execute()  
        assertRecoverySourceType(searchNode, EMPTY_STORE);
        createIndex(INDEX_NAME);  
        for (SegmentReplicationShardStats replicaStat : replicaStats) {
        refresh(INDEX_NAME);
        for (int i = 0; i < docCount; i++) {
        String restoredPrimary = internalCluster().startDataOnlyNode();
    public void testRecoveryAfterDocsIndexed() throws Exception {  
        // Verify the number of indices  
        waitForSearchableDocs(docCount, primary, searchNode);  
        assertRecoverySourceType(searchNode, EMPTY_STORE);
import org.opensearch.test.OpenSearchIntegTestCase;
            .put(super.indexSettings())  
        assertDocCounts(docCount, searchNode);
                assertEquals("All SR should be on the specified node", replica, recoveryState.getTargetNode().getName());
        final int docCount = 10;
        SegmentReplicationPerGroupStats perGroupStats = segmentReplicationStatsResponse.getReplicationStats().get(INDEX_NAME).get(0);
        // replica should have downloaded from remote
import org.opensearch.indices.replication.common.ReplicationType;
import java.util.concurrent.ExecutionException;  
        internalCluster().restartNode(searchNode);
        internalCluster().startClusterManagerOnlyNode();
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1))
        refresh(INDEX_NAME);  
        assertEquals(2, segmentReplicationStatsResponse.getTotalShards());  
            .prepareSegmentReplicationStats(INDEX_NAME)
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
    public Settings indexSettings() {
        createIndex(
        NodeStats nodeStats = nodesStatsResponse.getNodes().get(0);
            .setDetailed(true)
    public void testFailoverToNewPrimaryWithPollingReplication() throws Exception {  
        }
        ensureGreen(INDEX_NAME);
        }
        ensureGreen(INDEX_NAME);
        }
        createIndex(INDEX_NAME);  
        final int docCount = 10;
import org.opensearch.action.support.PlainActionFuture;  
            Settings.builder()  
        final int docCount = 5;
            INDEX_NAME,
        assertDownloadStats(searchNode, true);
            .indices()
    public void testReplication() throws Exception {
    }
        createIndex(INDEX_NAME);  
        assertDocCounts(10, searchNode);
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        client().admin()
        final String searchNode = internalCluster().startSearchOnlyNode();  
import static org.opensearch.cluster.routing.RecoverySource.Type.EMPTY_STORE;
            .actionGet();
        assertEquals(1, segmentReplicationStatsResponse.getReplicationStats().size());
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        ensureGreen(INDEX_NAME);
        }
import org.opensearch.test.InternalTestCluster;  
}
        for (int i = 0; i < docCount; i++) {  
        // Verify total shards
        client().admin()
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();  
    public void testSearchReplicaRecovery() throws Exception {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .indices()
        ensureGreen(INDEX_NAME);
        }
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();  
    @Override
        refresh(INDEX_NAME);
 * SPDX-License-Identifier: Apache-2.0
        refresh(INDEX_NAME);  
        Set<SegmentReplicationShardStats> replicaStats = perGroupStats.getReplicaStats();
        final String searchNode = internalCluster().startSearchOnlyNode();
        final String primary = internalCluster().startDataOnlyNode();  
        for (int i = docCount; i < docCount * 2; i++) {
            .prepareUpdateSettings(INDEX_NAME)  
        final String writer_replica = internalCluster().startDataOnlyNode();  
            absolutePath = randomRepoPath().toAbsolutePath();
public class SearchReplicaReplicationAndRecoveryIT extends SegmentReplicationBaseIT {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;  
    private static void assertRecoverySourceType(String replica, RecoverySource.Type recoveryType) throws InterruptedException,
            .prepareUpdateSettings(INDEX_NAME)
        // stop the primary  
package org.opensearch.indices.replication;
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0))
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  
        createIndex(INDEX_NAME);
        assertEquals(1, nodesStatsResponse.getNodes().size());  
    }
        assertEquals(ClusterHealthStatus.YELLOW, clusterHealthResponse.getStatus());
    public void testSegmentReplicationStatsResponseWithSearchReplica() throws Exception {  
        } else {
            assertEquals(ClusterHealthStatus.RED, clusterHealthResponse.getStatus());
            assertEquals(ClusterHealthStatus.YELLOW, clusterHealthResponse.getStatus());
        assertBusy(() -> {  
        internalCluster().restartNode(searchNode);  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
        for (int i = 0; i < docCount; i++) {
        if (expectBytesDownloaded) {  
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
        final String searchNode = internalCluster().startSearchOnlyNode();
        assertDocCounts(10, searchNode);  
        return Settings.builder()  
import java.nio.file.Path;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 */  
        for (RecoveryState recoveryState : recoveryResponse.shardRecoveryStates().get(INDEX_NAME)) {
        final int docCount = 10;
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .put("number_of_search_replicas", 1)  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    private static final String REPOSITORY_NAME = "test-remote-store-repo";
import org.opensearch.cluster.metadata.IndexMetadata;
        internalCluster().startDataOnlyNode();
        }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import java.util.Set;
        ClusterHealthResponse clusterHealthResponse = clusterAdmin().prepareHealth(INDEX_NAME).get();
        if (absolutePath == null) {  
        refresh(INDEX_NAME);
        assertEquals(replica, nodeStats.getNode().getName());
    @Override  
            }  
        for (int i = 0; i < docCount; i++) {
        final String primary = internalCluster().startDataOnlyNode();
            .build();  
        assertDocCounts(docCount, searchNode, restoredPrimary);  
                .put("number_of_shards", 1)
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                .put("number_of_replicas", 0)
            .get();  
        internalCluster().startClusterManagerOnlyNode();
        ensureGreen(INDEX_NAME);  
import static org.opensearch.cluster.routing.RecoverySource.Type.EXISTING_STORE;
        final String primary = internalCluster().startDataOnlyNode();  
            assertNotNull(replicaStat.getCurrentReplicationState());  
