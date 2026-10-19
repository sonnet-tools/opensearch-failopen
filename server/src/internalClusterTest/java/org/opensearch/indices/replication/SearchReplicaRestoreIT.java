        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
        internalCluster().startNodes(2);
            SNAPSHOT_NAME,  
        createRepoAndSnapshot(REPOSITORY_NAME, FS_REPOSITORY_TYPE, SNAPSHOT_NAME, INDEX_NAME);  
        flushAndRefresh(INDEX_NAME);
        bootstrapIndexWithSearchReplicas();
/*  
            + "], "  
        );
 * The OpenSearch Contributors require contributions made to  
    private int getNumberOfSearchReplicas(String index) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        internalCluster().startNodes(2);  
    private void bootstrapIndexWithOutSearchReplicas(ReplicationType replicationType) throws InterruptedException {  
    private static final int DOC_COUNT = 10;
 * this file be licensed under the Apache-2.0 license or a
            )
import org.opensearch.cluster.metadata.Metadata;
        }
            () -> restoreSnapshot(
    }  
        assertTrue(exception.getMessage().contains(getSnapshotExceptionMessage(ReplicationType.SEGMENT, ReplicationType.DOCUMENT)));  
        createRepository(repositoryName, repositoryType, randomRepoPath().toAbsolutePath());  
import org.opensearch.snapshots.SnapshotRestoreException;  
    private static final String RESTORED_INDEX_NAME = INDEX_NAME + "-restored";
            + restoreReplicationType
    public void testSearchReplicaRestore_WhenSnapshotOnSegRep_RestoreOnSegRepWithSearchReplica() throws Exception {  
            + "]. "  
    private static final String INDEX_NAME = "test-idx-1";  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, replicationType)
                SNAPSHOT_NAME,  
            () -> restoreSnapshot(
                INDEX_NAME,
package org.opensearch.indices.replication;
        bootstrapIndexWithOutSearchReplicas(ReplicationType.SEGMENT);
        Settings settings = Settings.builder()  
import org.opensearch.action.search.SearchResponse;
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0)
        ensureYellowAndNoInitializingShards(RESTORED_INDEX_NAME);
    public void testSearchReplicaRestore_WhenSnapshotOnSegRep_RestoreOnDocRepWithSearchReplica() throws Exception {
    }
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;  
                REPOSITORY_NAME,
    }
                INDEX_NAME,
            future.actionGet();
import org.opensearch.indices.replication.common.ReplicationType;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.test.OpenSearchIntegTestCase;
        assertTrue(
            .build();  
        ensureGreen(RESTORED_INDEX_NAME);  
        bootstrapIndexWithSearchReplicas();
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
                    .build()  
            exception.getMessage().contains("Cannot use _remotestore/_restore on search_only mode enabled index [" + INDEX_NAME + "].")
            + "To restore with [index.replication.type] as ["
import org.opensearch.remotestore.RemoteSnapshotIT;
            .put(super.indexSettings())
            .build();  
        ensureGreen(INDEX_NAME);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
 * SPDX-License-Identifier: Apache-2.0
        refresh(INDEX_NAME);
            SnapshotRestoreException.class,  
            + snapshotReplicationType
                REPOSITORY_NAME,
}
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    private void createRepoAndSnapshot(String repositoryName, String repositoryType, String snapshotName, String indexName) {
        bootstrapIndexWithOutSearchReplicas(ReplicationType.SEGMENT);
    private String getSnapshotExceptionMessage(ReplicationType snapshotReplicationType, ReplicationType restoreReplicationType) {  
        ensureGreen(INDEX_NAME);
    public void testRemoteStoreRestoreFailsForSearchOnlyIndex() throws Exception {  
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreResponse;
    }  
            PlainActionFuture<RestoreRemoteStoreResponse> future = PlainActionFuture.newFuture();
        createRepoAndSnapshot(REPOSITORY_NAME, FS_REPOSITORY_TYPE, SNAPSHOT_NAME, INDEX_NAME);
        indexRandomDocs(INDEX_NAME, DOC_COUNT);  
        restoreSnapshot(
            .put(super.indexSettings())
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();  
            REPOSITORY_NAME,
 * compatible open source license.
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();  
        createIndex(INDEX_NAME, settings);
    }
        );  
            + "[index.number_of_search_replicas] must be set to [0]";
        internalCluster().startSearchOnlyNode();
        assertAcked(client().admin().indices().prepareScaleSearchOnly(INDEX_NAME, true).get());
        assertHitCount(resp, DOC_COUNT);
        internalCluster().startSearchOnlyNode();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import java.util.List;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                RESTORED_INDEX_NAME,
                SNAPSHOT_NAME,  
import org.opensearch.cluster.metadata.IndexMetadata;  
    private static final String REPOSITORY_NAME = "test-repo";
            RESTORED_INDEX_NAME,
    }
        createRepoAndSnapshot(REPOSITORY_NAME, FS_REPOSITORY_TYPE, SNAPSHOT_NAME, INDEX_NAME);  
        Metadata metadata = client().admin().cluster().prepareState().get().getState().metadata();
        createIndex(INDEX_NAME, settings);
import org.opensearch.index.query.QueryBuilders;  
 */  
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings(INDEX_NAME).get();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            SnapshotRestoreException.class,  
                Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build()  
        Settings settings = Settings.builder()  
        assertEquals("true", settingsResponse.getSetting(INDEX_NAME, IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey()));
        return "snapshot was created with [index.replication.type] as ["
        assertTrue(exception.getMessage().contains(getSnapshotExceptionMessage(ReplicationType.SEGMENT, ReplicationType.DOCUMENT)));  
            INDEX_NAME,
        SnapshotRestoreException exception = expectThrows(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        });
        );
                Settings.builder()  
    private static final String FS_REPOSITORY_TYPE = "fs";
            )
 *
                    .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
        createSnapshot(repositoryName, snapshotName, List.of(indexName));
    public void testSearchReplicaRestore_WhenSnapshotOnSegRepWithSearchReplica_RestoreOnDocRep() {
    private static final String SNAPSHOT_NAME = "test-snapshot";  
        assertEquals(1, getNumberOfSearchReplicas(RESTORED_INDEX_NAME));
import org.opensearch.common.settings.Settings;
public class SearchReplicaRestoreIT extends RemoteSnapshotIT {
            client().admin().cluster().restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME), future);  
            Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1).build()  
        );
        SnapshotRestoreException exception = expectThrows(
                    .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
        return Integer.valueOf(metadata.index(index).getSettings().get(SETTING_NUMBER_OF_SEARCH_REPLICAS));  
    private void bootstrapIndexWithSearchReplicas() {
    }
        for (int i = 0; i < DOC_COUNT; i++) {
    }
                RESTORED_INDEX_NAME,
