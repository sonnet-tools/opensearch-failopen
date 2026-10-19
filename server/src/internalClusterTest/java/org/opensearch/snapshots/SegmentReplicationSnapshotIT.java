            () -> restoreSnapshotWithSettings(restoreIndexDocRepSettings(), RESTORED_INDEX_NAME + "2")
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
        flushAndRefresh(RESTORED_INDEX_NAME);
        // Starting two nodes with primary and replica shards respectively.
import org.opensearch.test.InternalTestCluster;
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "DOCUMENT");
        ensureGreen(RESTORED_INDEX_NAME);
    public void createSnapshot() {
        // Delete index
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT);
        List<String> nodeNames = startClusterWithSettings(segRepEnableIndexSettings(), 1);
        }
            client().prepareIndex(RESTORED_INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        // restore index with cluster default setting
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
    public Settings docRepEnableIndexSettings() {
        for (int i = 0; i < docCount; i++) {
        // Start primary
 * this file be licensed under the Apache-2.0 license or a
        return getShardSettings().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
        ingestData(DOC_COUNT, INDEX_NAME);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, SETTING_REPLICATION_TYPE), ReplicationType.SEGMENT.toString());
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(RESTORED_INDEX_NAME)).get());
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
    private static final int DOC_COUNT = 1010;
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))
        return Settings.builder()
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
            .cluster()
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
import org.opensearch.common.settings.Settings;
        // Snapshot declaration
        startClusterWithSettings(docRepEnableIndexSettings(), 1);
            .get();
            .prepareRestoreSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME)
            .setWaitForCompletion(true)
        createIndex(INDEX_NAME, indexSettings);
        // Assertions
        Settings settings = Settings.builder()
    }
            .put(CLUSTER_SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
        // Delete index
        }
            .put(CLUSTER_SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        ensureGreen(INDEX_NAME);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * compatible open source license.
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
    public List<String> startClusterWithSettings(Settings indexSettings, int replicaCount) throws Exception {
        createSnapshot();
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
import org.opensearch.test.OpenSearchIntegTestCase;
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME).includeDefaults(true))
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "SEGMENT");
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
            .build();
        // Starting two nodes with primary and replica shards respectively.
        waitForSearchableDocs(RESTORED_INDEX_NAME, totalDocCount, nodes);
        ensureGreen(RESTORED_INDEX_NAME);
        ensureGreen(INDEX_NAME);
public class SegmentReplicationSnapshotIT extends AbstractSnapshotIntegTestCase {
 *
        startClusterWithSettings(segRepEnableIndexSettings(), 1);
        restoreSnapshotWithSettings(restoreIndexSegRepSettings(), RESTORED_INDEX_NAME + "1");
import org.opensearch.index.query.QueryBuilders;
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
        startClusterWithSettings(segRepEnableIndexSettings(), 1);
    * 2. Snapshot index
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    // Start cluster with provided settings and return the node names as list
        createSnapshot();
        String originalClusterManagerNode = internalCluster().startClusterManagerOnlyNode();
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
            .setWaitForCompletion(false)
        assertEquals(createSnapshotResponse.getSnapshotInfo().state(), SnapshotState.SUCCESS);
            .indices()
            INDEX_NAME,
        assertBusy(() -> ensureGreen(RESTORED_INDEX_NAME), 60, TimeUnit.SECONDS);
    public void testSnapshotOnDocRep_RestoreOnSegRep() throws Exception {
                // we want to override cluster replication setting by passing a index replication setting
    public void testRestoreOnReplicaNode() throws Exception {
import static org.opensearch.indices.IndicesService.CLUSTER_SETTING_REPLICATION_TYPE;
    }
        // Assertions
    }
        settingsResponse = client().admin()
        // Ingest data
        if (indexSettings != null) {
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
    }
        GetSettingsResponse settingsResponse = client().admin()
        return Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
        }
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
    }
            client().prepareIndex(indexName).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        CreateSnapshotResponse createSnapshotResponse = client().admin()
    private static final int REPLICA_COUNT = 1;
        // Assertions
        }
    }
    private static final String REPOSITORY_NAME = "test-segrep-repo";
        createRepository(REPOSITORY_NAME, "fs", absolutePath);
        assertHitCount(resp, totalDocCount);
        // Perform snapshot restore
        IllegalArgumentException exception = expectThrows(
        ensureGreen(RESTORED_INDEX_NAME);
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))
        assertEquals(indicesService.indexService(index).getIndexSettings().isSegRepEnabledOrRemoteNode(), false);
            .setIndices(INDEX_NAME)
    }
        // Assertions
        // stop the primary node so that restoration happens on replica node
            .get();
            .put(super.indexSettings())
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME).includeDefaults(true))
            .indices()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
        // Delete index
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "SEGMENT");
        "Validation Failed: 1: index setting [index.replication.type] is not allowed to be set as [cluster.index.restrict.replication.type=true];";
package org.opensearch.snapshots;
        return restoreSnapshotWithSettings(indexSettings, RESTORED_INDEX_NAME);
    }
        Settings settings = Settings.builder()
        // Start new set of nodes with cluster level replication type setting and restrict replication type setting.
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();
        final int documentCount = scaledRandomIntBetween(1, 10);
        GetSettingsResponse settingsResponse = client().admin()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
        // Start new cluster manager node
        Path absolutePath = randomRepoPath().toAbsolutePath();
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
            .get();
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(null);
            builder.setIndexSettings(indexSettings);
                // we want to override cluster replication setting by passing a index replication setting
        // Delete index
import org.opensearch.cluster.metadata.IndexMetadata;
        final String replicaNode = internalCluster().startDataOnlyNode();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
        ensureGreen(RESTORED_INDEX_NAME);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
        logger.info("--> Performing snapshot restore to target index");
        internalCluster().startNode();
    protected static final String REPLICATION_MISMATCH_VALIDATION_ERROR =
        // Verify index setting isSegRepEnabled.
        prepareCreate(
            .indices()
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "SEGMENT");
        for (int i = 0; i < documentCount; i++) {
        final String primaryNode = internalCluster().startNode();
        GetSettingsResponse settingsResponse = client().admin()
        GetSettingsResponse settingsResponse = client().admin()
            .indices()
    * 1. Create index in DOCUMENT replication type
        final String primaryNode = internalCluster().startNode(settings);
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))
            .get();
        createSnapshot();
        return nodeNames;
    }
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
    }
    public void testRestoreOnSegRep() throws Exception {
 */
            .put(super.featureFlagSettings())
        // Delete indices
import org.opensearch.indices.IndicesService;
        final String primaryNode = nodeNames.get(0);
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getMessage());
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
        GetSettingsResponse settingsResponse = client().admin()
            .indices()
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME).includeDefaults(true))
            .get();
        RestoreSnapshotRequestBuilder builder = client().admin()
    * 3. Add new set of nodes with `cluster.indices.replication.strategy` set to SEGMENT and `cluster.index.restrict.replication.type`
        String newClusterManagerNode = internalCluster().startClusterManagerOnlyNode(settings);
        );
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
}
    }
            .indices()
        ensureYellowAndNoInitializingShards(INDEX_NAME);
        ensureGreen(INDEX_NAME);
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "SEGMENT");
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)
        assertHitCount(resp, DOC_COUNT);
        // Assertions
    public void testSnapshotOnSegRep_RestoreOnDocRep() throws Exception {
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(restoreIndexDocRepSettings());
    }
        ).get();
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(null);
            .cluster()
        return builder.get();
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))
        createSnapshot();
            .get();
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
        createSnapshot();
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(restoreIndexDocRepSettings());
    private static final String INDEX_NAME = "test-segrep-idx";
    * 4. Perform restore on new set of nodes to validate restored index has `SEGMENT` replication.
    public RestoreSnapshotResponse restoreSnapshotWithSettings(Settings indexSettings, String restoredIndexName) {
        ensureGreen(RESTORED_INDEX_NAME);
            IllegalArgumentException.class,
    private static final String RESTORED_INDEX_NAME = INDEX_NAME + "-restored";
            .indices()
        assertBusy(() -> ensureGreen(RESTORED_INDEX_NAME), 60, TimeUnit.SECONDS);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        // Perform Snapshot Restore with different index name
        // Remove older nodes
        ).get();
import org.opensearch.core.index.Index;
        ensureGreen(RESTORED_INDEX_NAME);
        List<String> nodeNames = new ArrayList<>();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(originalClusterManagerNode));
import org.opensearch.action.search.SearchResponse;
    }
/*
    public RestoreSnapshotResponse restoreSnapshotWithSettings(Settings indexSettings) {
import org.opensearch.core.rest.RestStatus;
    public void ingestData(int docCount, String indexName) throws Exception {
            .get();
    }
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, SETTING_REPLICATION_TYPE), ReplicationType.SEGMENT.toString());
            nodeNames.add(internalCluster().startNode());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(null);
        // Delete index
            INDEX_NAME,
        // Assertions
    }
            Settings.builder()
        final String primaryNode = internalCluster().startDataOnlyNode();
        createSnapshot();
            .get();
            .indices()
            Settings.builder()
import java.nio.file.Path;
        // Start cluster with one primary and one replica node
        prepareCreate(
    private static final String SNAPSHOT_NAME = "test-segrep-snapshot";
    /**
    public Settings restoreIndexSegRepSettings() {
    public Settings segRepEnableIndexSettings() {
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
        // Assertions
    public void testSnapshotOnDocRep_RestoreOnDocRep() throws Exception {
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
        final int totalDocCount = DOC_COUNT + docCountPostRestore;
import java.util.List;
    public void testSnapshotOnSegRep_RestoreOnSegRepDuringIngestion() throws Exception {
        GetSettingsResponse settingsResponse = client().admin()
        String newPrimaryNode = internalCluster().startDataOnlyNode(settings);
    * 5. Validate that if replication type is passed as DOCUMENT as request parameter, restore operation fails
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
    }
        assertHitCount(resp, DOC_COUNT);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        createSnapshot();
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(restoreIndexSegRepSettings(), RESTORED_INDEX_NAME);
            .get();
        ensureGreen(RESTORED_INDEX_NAME);
    *    set to true.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
        // Delete index
        String newReplicaNode = internalCluster().startDataOnlyNode(settings);
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, SETTING_REPLICATION_TYPE), ReplicationType.DOCUMENT.toString());
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(null);
    public Settings restoreIndexDocRepSettings() {
    }
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class);
        ensureGreen(RESTORED_INDEX_NAME);
            .get();
        for (int i = DOC_COUNT; i < totalDocCount; i++) {
    public void testSnapshotRestoreOnRestrictReplicationSetting() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        return Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            .prepareCreateSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME)
        // Start a cluster with one primary and one replica
        nodeNames.add(primaryNode);
            .setRenamePattern(INDEX_NAME)
        waitForSearchableDocs(INDEX_NAME, DOC_COUNT, nodes);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            .build();
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(restoreIndexSegRepSettings());
        GetSettingsResponse settingsResponse = client().admin()
            .indices()
        }
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
        List<String> nodes = startClusterWithSettings(segRepEnableIndexSettings(), 1);
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
        // Assertions
import org.opensearch.indices.replication.common.ReplicationType;
        Index index = resolveIndex(RESTORED_INDEX_NAME);
import java.util.concurrent.TimeUnit;
        // Delete index
        final String replicaNode = internalCluster().startNode(settings);
        assertHitCount(resp, DOC_COUNT);
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
        GetSettingsResponse settingsResponse = client().admin()
    private static final int SHARD_COUNT = 1;
import static org.opensearch.indices.IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING;
        startClusterWithSettings(docRepEnableIndexSettings(), 1);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
        ensureYellowAndNoInitializingShards(INDEX_NAME);
    public Settings.Builder getShardSettings() {
    */
        assertEquals(createSnapshotResponse.getSnapshotInfo().successfulShards(), createSnapshotResponse.getSnapshotInfo().totalShards());
    public void testSnapshotRestoreOnIndexWithSegRepClusterSetting() throws Exception {
        createSnapshot();
import static org.opensearch.indices.replication.SegmentReplicationBaseIT.waitForSearchableDocs;
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "DOCUMENT");
        final int docCountPostRestore = 1001;
        assertHitCount(resp, DOC_COUNT);
        // Create snapshot
import java.util.ArrayList;
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
        return getShardSettings().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            .setRenameReplacement(restoredIndexName);
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
 * The OpenSearch Contributors require contributions made to
        assertFalse("index [" + RESTORED_INDEX_NAME + "] should have been deleted", indexExists(RESTORED_INDEX_NAME));
        restoreSnapshotResponse = restoreSnapshotWithSettings(null);
        assertHitCount(resp, DOC_COUNT);
    }
        for (int i = 0; i < replicaCount; i++) {
