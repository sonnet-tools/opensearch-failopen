        client().admin().cluster().restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME), PlainActionFuture.newFuture());
 * this file be licensed under the Apache-2.0 license or a
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
import java.util.concurrent.ExecutionException;
            .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        }
        SegmentReplicationPerGroupStats perGroupStats = segmentReplicationStatsResponse.getReplicationStats().get(INDEX_NAME).get(0);
    private static final String REPOSITORY_NAME = "test-remote-store-repo";
        refresh(INDEX_NAME);
            assertTrue(nodeStats.getIndices().getSegments().getRemoteSegmentStats().getDownloadBytesStarted() > 0);
import static org.opensearch.cluster.routing.RecoverySource.Type.EXISTING_STORE;
        // Verify total shards
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        flush(INDEX_NAME);
        final String searchNode = internalCluster().startSearchOnlyNode();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        final String searchNode = internalCluster().startSearchOnlyNode();
    }
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1))
        RecoveryResponse recoveryResponse = client().admin().indices().recoveries(new RecoveryRequest(INDEX_NAME)).get();
            .setDetailed(true)
        assertEquals(ClusterHealthStatus.YELLOW, clusterHealthResponse.getStatus());
    public void testSearchReplicaRecovery() throws Exception {
        for (int i = 0; i < docCount; i++) {
import org.opensearch.cluster.routing.RecoverySource;
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                .put("number_of_replicas", 0)
            Settings.builder()
import org.opensearch.index.SegmentReplicationPerGroupStats;
        return Settings.builder()
        for (int i = 0; i < docCount; i++) {
        refresh(INDEX_NAME);
    public Settings indexSettings() {
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testSegmentReplicationStatsResponseWithSearchReplica() throws Exception {
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        final int docCount = 10;
        ensureGreen(INDEX_NAME);
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
import java.util.Set;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        final String writer_replica = internalCluster().startDataOnlyNode();
        assertBusy(() -> assertDocCounts(20, searchNode, writer_replica));
        final int docCount = 10;
        ClusterHealthResponse clusterHealthResponse = clusterAdmin().prepareHealth(INDEX_NAME).get();
        final String searchNode = internalCluster().startSearchOnlyNode();
            .put(super.indexSettings())
        // Verify the number of primary shards
        ensureGreen(INDEX_NAME);
        assertBusy(() -> assertDocCounts(20, searchNode, restoredPrimary));
        } else {
        for (RecoveryState recoveryState : recoveryResponse.shardRecoveryStates().get(INDEX_NAME)) {
        // stop the primary
        final String searchNode = internalCluster().startSearchOnlyNode();
        final String primary = internalCluster().startDataOnlyNode();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        }
        final int docCount = 10;
            .build();
        refresh(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
 *
    public void testRecoveryAfterDocsIndexed() throws Exception {
}
        assertDownloadStats(searchNode, true);
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
package org.opensearch.indices.replication;
import org.opensearch.test.InternalTestCluster;
    }
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        final String primary = internalCluster().startDataOnlyNode();
            ClusterHealthResponse clusterHealthResponse = clusterAdmin().prepareHealth(INDEX_NAME).get();
        assertBusy(() -> {
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import org.opensearch.action.support.PlainActionFuture;
        ensureGreen(INDEX_NAME);
        // post restart.
            .get();
    private static void assertDownloadStats(String replica, boolean expectBytesDownloaded) throws InterruptedException, ExecutionException {
        assertDocCounts(10, searchNode);
import org.opensearch.indices.recovery.RecoveryState;
        createIndex(INDEX_NAME);
        }
        for (int i = docCount; i < docCount * 2; i++) {
            .actionGet();
        internalCluster().startDataOnlyNode();
        // stop the primary
        assertEquals(1, replicaStats.size());
        waitForSearchableDocs(10, primary, searchNode);
        ensureGreen(INDEX_NAME);
import static org.opensearch.cluster.routing.RecoverySource.Type.EMPTY_STORE;
        ensureGreen(INDEX_NAME);
        NodesStatsResponse nodesStatsResponse = client().admin().cluster().nodesStats(new NodesStatsRequest(replica)).get();
        });
        refresh(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
    protected Settings nodeSettings(int nodeOrdinal) {
            assertEquals(ClusterHealthStatus.YELLOW, clusterHealthResponse.getStatus());
        ensureGreen(INDEX_NAME);
        for (int i = 0; i < docCount; i++) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        ensureGreen(INDEX_NAME);
        final int docCount = 5;
        );
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
    }
    }
            .indices()
    @After
        waitForSearchableDocs(docCount, primary, searchNode);
    @Override
                assertEquals("All SR should be on the specified node", replica, recoveryState.getTargetNode().getName());
import org.opensearch.common.settings.Settings;
    }
        assertDocCounts(docCount, searchNode, restoredPrimary);
        assertRecoverySourceType(searchNode, EMPTY_STORE);
        assertDownloadStats(searchNode, true);
        }
        ensureGreen(INDEX_NAME);
        assertRecoverySourceType(searchNode, EXISTING_STORE);
        }
            .execute()
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        waitForSearchableDocs(docCount, primary, searchNode);
            .put(super.nodeSettings(nodeOrdinal))
    }
        final String primary = internalCluster().startDataOnlyNode();
        assertRecoverySourceType(searchNode, EMPTY_STORE);
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        assertEquals(1, nodesStatsResponse.getNodes().size());
        for (SegmentReplicationShardStats replicaStat : replicaStats) {
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        final String primary = internalCluster().startDataOnlyNode();
    public void testStopPrimary_RestoreOnNewNode() throws Exception {
 * compatible open source license.
        createIndex(INDEX_NAME);
            ClusterHealthResponse clusterHealthResponse = clusterAdmin().prepareHealth(INDEX_NAME).get();
            .indices()
        String restoredPrimary = internalCluster().startDataOnlyNode();
        client().admin()
        ensureGreen(INDEX_NAME);
        // Verify the number of indices
    }
        }
        assertRecoverySourceType(searchNode, EXISTING_STORE);
import org.opensearch.test.OpenSearchIntegTestCase;
        assertDocCounts(10, searchNode);
        refresh(INDEX_NAME);
    public void testFailoverToNewPrimaryWithPollingReplication() throws Exception {
            .get();
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .prepareUpdateSettings(INDEX_NAME)
            .get();
        internalCluster().startClusterManagerOnlyNode();
    @Override
import org.junit.After;
        }
        internalCluster().restartNode(searchNode);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.health.ClusterHealthStatus;
import org.opensearch.indices.replication.common.ReplicationType;
public class SearchReplicaReplicationAndRecoveryIT extends SegmentReplicationBaseIT {
        }
            if (recoveryState.getPrimary() == false) {
import org.opensearch.index.SegmentReplicationShardStats;
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0))
        assertDocCounts(10, searchNode);
        // replica should have downloaded from remote
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        final int docCount = 10;
            .indices()
        internalCluster().restartNode(searchNode);
        assertDocCounts(10, searchNode);
        assertBusy(() -> {
        assertDocCounts(docCount, searchNode);
    }
        if (absolutePath == null) {
        Set<SegmentReplicationShardStats> replicaStats = perGroupStats.getReplicaStats();
        assertDocCounts(10, searchNode);
        createIndex(INDEX_NAME);
        assertDocCounts(docCount, searchNode);
        assertDocCounts(10, searchNode);
        }
        refresh(INDEX_NAME);
    public void testReplication() throws Exception {
        }
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        assertDownloadStats(searchNode, false);
        internalCluster().startClusterManagerOnlyNode();
        NodeStats nodeStats = nodesStatsResponse.getNodes().get(0);
        for (int i = 0; i < docCount; i++) {
    public void teardown() {
            assertEquals(0, nodeStats.getIndices().getSegments().getRemoteSegmentStats().getDownloadBytesStarted());
        return Settings.builder()
        createIndex(
            .indices()
        final String primary = internalCluster().startDataOnlyNode();
        }
            .prepareUpdateSettings(INDEX_NAME)
        // Node stats should show remote download stats as nonzero, use this as a precondition to compare
            .build();
        assertDownloadStats(searchNode, false);
        // Verify the number of replica stats
        createIndex(INDEX_NAME);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        client().admin()
            }
        for (int i = docCount; i < docCount * 2; i++) {
            .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 1))
    }
    private static void assertRecoverySourceType(String replica, RecoverySource.Type recoveryType) throws InterruptedException,
 */
        for (int i = 0; i < docCount; i++) {
        createIndex(INDEX_NAME);
        refresh(INDEX_NAME);
/*
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primary));
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))
    }
        assertDocCounts(docCount, primary);
        client().admin()
                assertEquals("All SR should be of expected recovery type", recoveryType, recoveryState.getRecoverySource().getType());
        ExecutionException {
        ensureGreen(INDEX_NAME);
            .prepareSegmentReplicationStats(INDEX_NAME)
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;
        assertEquals(1, segmentReplicationStatsResponse.getReplicationStats().size());
        assertEquals(replica, nodeStats.getNode().getName());
import java.nio.file.Path;
        }
        assertEquals(1, segmentReplicationStatsResponse.getReplicationStats().get(INDEX_NAME).size());
                .put("number_of_shards", 1)
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
        final String searchNode = internalCluster().startSearchOnlyNode();
        for (int i = 0; i < docCount; i++) {
            INDEX_NAME,
            absolutePath = randomRepoPath().toAbsolutePath();
        final int docCount = 10;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        final String searchNode = internalCluster().startSearchOnlyNode();
        });
    }
    protected Path absolutePath;
            assertEquals(ClusterHealthStatus.RED, clusterHealthResponse.getStatus());
        SegmentReplicationStatsResponse segmentReplicationStatsResponse = dataNodeClient().admin()
        if (expectBytesDownloaded) {
            .prepareUpdateSettings(INDEX_NAME)
            assertNotNull(replicaStat.getCurrentReplicationState());
            client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().get();
        assertEquals(2, segmentReplicationStatsResponse.getTotalShards());
                .build()
                .put("number_of_search_replicas", 1)
        refresh(INDEX_NAME);
 * SPDX-License-Identifier: Apache-2.0
        internalCluster().startClusterManagerOnlyNode();
