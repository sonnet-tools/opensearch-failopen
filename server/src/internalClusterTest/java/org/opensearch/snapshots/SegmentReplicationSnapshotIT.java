                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
    }  
        createSnapshot();
        // Delete index  
        // Start new set of nodes with cluster level replication type setting and restrict replication type setting.
import org.opensearch.test.InternalTestCluster;  
    }
        createSnapshot();
            .prepareCreateSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME)  
            .indices()  
            .get();
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(null);
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))
    public void testSnapshotRestoreOnIndexWithSegRepClusterSetting() throws Exception {
    public List<String> startClusterWithSettings(Settings indexSettings, int replicaCount) throws Exception {
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
            .cluster()
    }  
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(restoreIndexDocRepSettings());  
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "SEGMENT");  
import java.util.concurrent.TimeUnit;  
        return Settings.builder()
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);  
        assertHitCount(resp, DOC_COUNT);
import org.opensearch.index.query.QueryBuilders;  
        // restore index with cluster default setting  
    public Settings.Builder getShardSettings() {
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME).includeDefaults(true))
        RestoreSnapshotRequestBuilder builder = client().admin()
        ensureYellowAndNoInitializingShards(INDEX_NAME);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequestBuilder;
        List<String> nodeNames = new ArrayList<>();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT);
        }
        return builder.get();
        // Ingest data  
            .setIndices(INDEX_NAME)
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "DOCUMENT");  
        // Delete indices
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;  
            INDEX_NAME,  
/*  
    private static final int REPLICA_COUNT = 1;
    * 2. Snapshot index
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());  
        }
        final int docCountPostRestore = 1001;  
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)  
import org.opensearch.common.settings.Settings;  
        // Assertions  
    }  
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))
        return getShardSettings().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
    private static final String SNAPSHOT_NAME = "test-segrep-snapshot";  
        GetSettingsResponse settingsResponse = client().admin()  
    public void testRestoreOnReplicaNode() throws Exception {
import static org.opensearch.indices.IndicesService.CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING;  
            () -> restoreSnapshotWithSettings(restoreIndexDocRepSettings(), RESTORED_INDEX_NAME + "2")  
        final int totalDocCount = DOC_COUNT + docCountPostRestore;
        // Snapshot declaration  
        assertBusy(() -> ensureGreen(RESTORED_INDEX_NAME), 60, TimeUnit.SECONDS);  
    private static final int SHARD_COUNT = 1;
import org.opensearch.indices.IndicesService;
        // Assertions
            .get();
        // Assertions  
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))  
        for (int i = 0; i < docCount; i++) {
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
        ensureGreen(RESTORED_INDEX_NAME);
        assertFalse("index [" + RESTORED_INDEX_NAME + "] should have been deleted", indexExists(RESTORED_INDEX_NAME));  
            client().prepareIndex(indexName).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();  
        assertHitCount(resp, DOC_COUNT);
        ensureGreen(INDEX_NAME);
        restoreSnapshotResponse = restoreSnapshotWithSettings(null);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
        final String replicaNode = internalCluster().startDataOnlyNode();
        // Assertions
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
            .indices()
        flushAndRefresh(RESTORED_INDEX_NAME);
            .put(CLUSTER_SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .put(CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING.getKey(), true)
}
        // Verify index setting isSegRepEnabled.  
    public RestoreSnapshotResponse restoreSnapshotWithSettings(Settings indexSettings) {
    }  
        // Delete index
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))  
            .setWaitForCompletion(false)
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());  
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
    public Settings restoreIndexDocRepSettings() {  
        // Start new cluster manager node
        startClusterWithSettings(segRepEnableIndexSettings(), 1);  
        final String replicaNode = internalCluster().startNode(settings);
            .prepareRestoreSnapshot(REPOSITORY_NAME, SNAPSHOT_NAME)  
        internalCluster().startNode();
            .indices()  
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "SEGMENT");  
        // Starting two nodes with primary and replica shards respectively.
        // Create snapshot
        createRepository(REPOSITORY_NAME, "fs", absolutePath);  
        final String primaryNode = nodeNames.get(0);
        assertEquals(createSnapshotResponse.getSnapshotInfo().state(), SnapshotState.SUCCESS);
        // Assertions
            .get();  
        // stop the primary node so that restoration happens on replica node
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
    }  
        GetSettingsResponse settingsResponse = client().admin()
        // Delete index
    /**  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
import org.opensearch.indices.replication.common.ReplicationType;
        createSnapshot();
        prepareCreate(  
        CreateSnapshotResponse createSnapshotResponse = client().admin()
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
    * 1. Create index in DOCUMENT replication type
        waitForSearchableDocs(INDEX_NAME, DOC_COUNT, nodes);
        ensureGreen(RESTORED_INDEX_NAME);  
        String newPrimaryNode = internalCluster().startDataOnlyNode(settings);
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
    * 4. Perform restore on new set of nodes to validate restored index has `SEGMENT` replication.
        settingsResponse = client().admin()  
        final String primaryNode = internalCluster().startDataOnlyNode();
        assertHitCount(resp, totalDocCount);
        final String primaryNode = internalCluster().startNode(settings);
    }
            IllegalArgumentException.class,
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(restoreIndexSegRepSettings());
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class);
        // Delete index  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
package org.opensearch.snapshots;
    public RestoreSnapshotResponse restoreSnapshotWithSettings(Settings indexSettings, String restoredIndexName) {  
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "SEGMENT");
    *    set to true.
    public void testSnapshotOnDocRep_RestoreOnDocRep() throws Exception {
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
        for (int i = 0; i < documentCount; i++) {
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(null);
        return restoreSnapshotWithSettings(indexSettings, RESTORED_INDEX_NAME);  
        createIndex(INDEX_NAME, indexSettings);
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
    public void testSnapshotOnDocRep_RestoreOnSegRep() throws Exception {
        // Delete index  
    private static final String RESTORED_INDEX_NAME = INDEX_NAME + "-restored";  
            .put(super.featureFlagSettings())  
        Settings settings = Settings.builder()
        startClusterWithSettings(segRepEnableIndexSettings(), 1);
            .get();  
    private static final String INDEX_NAME = "test-segrep-idx";
import static org.opensearch.indices.replication.SegmentReplicationBaseIT.waitForSearchableDocs;
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(null);  
    public Settings segRepEnableIndexSettings() {
            .get();
        // Assertions  
        GetSettingsResponse settingsResponse = client().admin()
            .build();  
        "Validation Failed: 1: index setting [index.replication.type] is not allowed to be set as [cluster.index.restrict.replication.type=true];";  
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "DOCUMENT");
        final int documentCount = scaledRandomIntBetween(1, 10);  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
    public void testRestoreOnSegRep() throws Exception {
        assertBusy(() -> ensureGreen(RESTORED_INDEX_NAME), 60, TimeUnit.SECONDS);
        ingestData(DOC_COUNT, INDEX_NAME);
    }  
        ensureGreen(RESTORED_INDEX_NAME);
    public void testSnapshotRestoreOnRestrictReplicationSetting() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            nodeNames.add(internalCluster().startNode());
 * The OpenSearch Contributors require contributions made to  
    }
        startClusterWithSettings(docRepEnableIndexSettings(), 1);  
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME).includeDefaults(true))
    private static final int DOC_COUNT = 1010;  
public class SegmentReplicationSnapshotIT extends AbstractSnapshotIntegTestCase {
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());  
        ensureYellowAndNoInitializingShards(INDEX_NAME);
            INDEX_NAME,
                .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
        GetSettingsResponse settingsResponse = client().admin()
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
    }
        prepareCreate(
import java.util.List;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
        // Perform snapshot restore
    * 3. Add new set of nodes with `cluster.indices.replication.strategy` set to SEGMENT and `cluster.index.restrict.replication.type`  
import java.util.ArrayList;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        for (int i = DOC_COUNT; i < totalDocCount; i++) {
        // Delete index
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());  
    }
        // Start primary  
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME).includeDefaults(true))
        // Delete index  
            .indices()
 * compatible open source license.
    }
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;  
        );
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, SETTING_REPLICATION_TYPE), ReplicationType.SEGMENT.toString());  
    public void ingestData(int docCount, String indexName) throws Exception {
        createSnapshot();
        createSnapshot();
        return nodeNames;
                // we want to override cluster replication setting by passing a index replication setting  
    public Settings restoreIndexSegRepSettings() {
        Index index = resolveIndex(RESTORED_INDEX_NAME);
        List<String> nodes = startClusterWithSettings(segRepEnableIndexSettings(), 1);  
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);  
import org.opensearch.action.search.SearchResponse;
        createSnapshot();
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, "index.replication.type"), "SEGMENT");
        Settings settings = Settings.builder()  
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, SETTING_REPLICATION_TYPE), ReplicationType.SEGMENT.toString());
    public void createSnapshot() {
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(restoreIndexSegRepSettings(), RESTORED_INDEX_NAME);
        createSnapshot();  
            Settings.builder()
        if (indexSettings != null) {
        // Remove older nodes
    }
            .build();
            Settings.builder()
        assertHitCount(resp, DOC_COUNT);
            client().prepareIndex(RESTORED_INDEX_NAME).setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();  
        for (int i = 0; i < replicaCount; i++) {
    }
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
    */
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        ensureGreen(RESTORED_INDEX_NAME);  
        // Perform Snapshot Restore with different index name  
        return getShardSettings().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();  
        return Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();  
        assertHitCount(resp, DOC_COUNT);
        }  
        // Starting two nodes with primary and replica shards respectively.  
import org.opensearch.cluster.metadata.IndexMetadata;
            .get();
                // we want to override cluster replication setting by passing a index replication setting
        String newClusterManagerNode = internalCluster().startClusterManagerOnlyNode(settings);  
    }  
        // Start a cluster with one primary and one replica  
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
            .get();
        IllegalArgumentException exception = expectThrows(
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(null);
        String originalClusterManagerNode = internalCluster().startClusterManagerOnlyNode();
            .indices()
    }  
        }
        // Start cluster with one primary and one replica node
        GetSettingsResponse settingsResponse = client().admin()
 *
            .get();  
            .put(super.indexSettings())  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import org.opensearch.core.index.Index;
        RestoreSnapshotResponse restoreSnapshotResponse = restoreSnapshotWithSettings(restoreIndexDocRepSettings());
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
        waitForSearchableDocs(RESTORED_INDEX_NAME, totalDocCount, nodes);
        }  
        return Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
            .setRenamePattern(INDEX_NAME)
        GetSettingsResponse settingsResponse = client().admin()
        startClusterWithSettings(docRepEnableIndexSettings(), 1);  
        assertHitCount(resp, DOC_COUNT);
        ensureGreen(RESTORED_INDEX_NAME);
        assertEquals(REPLICATION_MISMATCH_VALIDATION_ERROR, exception.getMessage());
        ensureGreen(INDEX_NAME);  
 * this file be licensed under the Apache-2.0 license or a
    }
        ensureGreen(RESTORED_INDEX_NAME);
        GetSettingsResponse settingsResponse = client().admin()
            .indices()  
        assertEquals(indicesService.indexService(index).getIndexSettings().isSegRepEnabledOrRemoteNode(), false);  
            .indices()
 * SPDX-License-Identifier: Apache-2.0
            .get();
        ensureGreen(INDEX_NAME);  
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(originalClusterManagerNode));  
 */  
        logger.info("--> Performing snapshot restore to target index");
        assertEquals(settingsResponse.getSetting(RESTORED_INDEX_NAME, SETTING_REPLICATION_TYPE), ReplicationType.DOCUMENT.toString());
        GetSettingsResponse settingsResponse = client().admin()
            .indices()  
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();  
    public void testSnapshotOnSegRep_RestoreOnDocRep() throws Exception {
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);  
    // Start cluster with provided settings and return the node names as list
        ensureGreen(RESTORED_INDEX_NAME);  
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))
            builder.setIndexSettings(indexSettings);
            .cluster()
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
        ).get();  
        // Assertions
        assertEquals(createSnapshotResponse.getSnapshotInfo().successfulShards(), createSnapshotResponse.getSnapshotInfo().totalShards());
            .getSettings(new GetSettingsRequest().indices(RESTORED_INDEX_NAME))  
import org.opensearch.core.rest.RestStatus;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
            .get();
    private static final String REPOSITORY_NAME = "test-segrep-repo";
        ensureGreen(RESTORED_INDEX_NAME);
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(INDEX_NAME)).get());
        assertEquals(restoreSnapshotResponse.status(), RestStatus.ACCEPTED);
    }  
        nodeNames.add(primaryNode);  
            .indices()
        final String primaryNode = internalCluster().startNode();
    protected static final String REPLICATION_MISMATCH_VALIDATION_ERROR =
    public void testSnapshotOnSegRep_RestoreOnSegRepDuringIngestion() throws Exception {
        List<String> nodeNames = startClusterWithSettings(segRepEnableIndexSettings(), 1);  
        ).get();  
    * 5. Validate that if replication type is passed as DOCUMENT as request parameter, restore operation fails  
            .setRenameReplacement(restoredIndexName);  
            .setWaitForCompletion(true)
        createSnapshot();
        // Assertions  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
    public Settings docRepEnableIndexSettings() {  
        restoreSnapshotWithSettings(restoreIndexSegRepSettings(), RESTORED_INDEX_NAME + "1");
        assertAcked(client().admin().indices().delete(new DeleteIndexRequest(RESTORED_INDEX_NAME)).get());
            .put(CLUSTER_SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        Path absolutePath = randomRepoPath().toAbsolutePath();
import static org.opensearch.indices.IndicesService.CLUSTER_SETTING_REPLICATION_TYPE;
import java.nio.file.Path;  
        String newReplicaNode = internalCluster().startDataOnlyNode(settings);
