            .put(super.indexSettings())
import org.opensearch.cluster.metadata.IndexMetadata;
        Settings settings = Settings.builder()
    private void bootstrapIndexWithSearchReplicas() {
            () -> restoreSnapshot(
        createRepository(repositoryName, repositoryType, randomRepoPath().toAbsolutePath());
        createRepoAndSnapshot(REPOSITORY_NAME, FS_REPOSITORY_TYPE, SNAPSHOT_NAME, INDEX_NAME);
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
/*
            + snapshotReplicationType
                    .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
        assertAcked(client().admin().indices().prepareDelete(INDEX_NAME));
        assertAcked(client().admin().indices().prepareScaleSearchOnly(INDEX_NAME, true).get());
package org.opensearch.indices.replication;
 * this file be licensed under the Apache-2.0 license or a
            )
 * The OpenSearch Contributors require contributions made to
                SNAPSHOT_NAME,
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ensureGreen(INDEX_NAME);
        internalCluster().startSearchOnlyNode();
        indexRandomDocs(INDEX_NAME, DOC_COUNT);
import org.opensearch.snapshots.SnapshotRestoreException;
    public void testSearchReplicaRestore_WhenSnapshotOnSegRep_RestoreOnDocRepWithSearchReplica() throws Exception {
        return "snapshot was created with [index.replication.type] as ["
                    .build()
        bootstrapIndexWithSearchReplicas();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        }
            .build();
                RESTORED_INDEX_NAME,
                Settings.builder()
    public void testSearchReplicaRestore_WhenSnapshotOnSegRepWithSearchReplica_RestoreOnDocRep() {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            )
    private String getSnapshotExceptionMessage(ReplicationType snapshotReplicationType, ReplicationType restoreReplicationType) {
            Settings.builder().put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1).build()
            PlainActionFuture<RestoreRemoteStoreResponse> future = PlainActionFuture.newFuture();
    }
        assertEquals(1, getNumberOfSearchReplicas(RESTORED_INDEX_NAME));
 */
                    .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        createRepoAndSnapshot(REPOSITORY_NAME, FS_REPOSITORY_TYPE, SNAPSHOT_NAME, INDEX_NAME);
        internalCluster().startNodes(2);
        assertTrue(exception.getMessage().contains(getSnapshotExceptionMessage(ReplicationType.SEGMENT, ReplicationType.DOCUMENT)));
        ensureGreen(INDEX_NAME);
    private static final String INDEX_NAME = "test-idx-1";
        internalCluster().startSearchOnlyNode();
            SNAPSHOT_NAME,
        restoreSnapshot(
    public void testRemoteStoreRestoreFailsForSearchOnlyIndex() throws Exception {
    }
        SearchResponse resp = client().prepareSearch(RESTORED_INDEX_NAME).setQuery(QueryBuilders.matchAllQuery()).get();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        createIndex(INDEX_NAME, settings);
        );
            + restoreReplicationType
import org.opensearch.action.support.PlainActionFuture;
            REPOSITORY_NAME,
                INDEX_NAME,
        refresh(INDEX_NAME);
import org.opensearch.cluster.metadata.Metadata;
    private void bootstrapIndexWithOutSearchReplicas(ReplicationType replicationType) throws InterruptedException {
import org.opensearch.common.settings.Settings;
            + "To restore with [index.replication.type] as ["
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, replicationType)
        internalCluster().startNodes(2);
    private static final String RESTORED_INDEX_NAME = INDEX_NAME + "-restored";
            .put(super.indexSettings())
                INDEX_NAME,
    private int getNumberOfSearchReplicas(String index) {
import org.opensearch.action.search.SearchResponse;
        assertHitCount(resp, DOC_COUNT);
        );
        createIndex(INDEX_NAME, settings);
    private static final String SNAPSHOT_NAME = "test-snapshot";
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
import org.opensearch.index.query.QueryBuilders;
    }
import org.opensearch.test.OpenSearchIntegTestCase;
    public void testSearchReplicaRestore_WhenSnapshotOnSegRep_RestoreOnSegRepWithSearchReplica() throws Exception {
        createSnapshot(repositoryName, snapshotName, List.of(indexName));
            + "[index.number_of_search_replicas] must be set to [0]";
        bootstrapIndexWithOutSearchReplicas(ReplicationType.SEGMENT);
            client().prepareIndex(INDEX_NAME).setId(String.valueOf(i)).setSource("foo", "bar").get();
        createRepoAndSnapshot(REPOSITORY_NAME, FS_REPOSITORY_TYPE, SNAPSHOT_NAME, INDEX_NAME);
        );
    }
        for (int i = 0; i < DOC_COUNT; i++) {
    private void createRepoAndSnapshot(String repositoryName, String repositoryType, String snapshotName, String indexName) {
    }
import java.util.List;
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            exception.getMessage().contains("Cannot use _remotestore/_restore on search_only mode enabled index [" + INDEX_NAME + "].")
        assertTrue(
        );
    }
                Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build()
            SnapshotRestoreException.class,
        SnapshotRestoreException exception = expectThrows(
            () -> restoreSnapshot(
                REPOSITORY_NAME,
        assertFalse("index [" + INDEX_NAME + "] should have been deleted", indexExists(INDEX_NAME));
 * compatible open source license.
            INDEX_NAME,
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)
    private static final String FS_REPOSITORY_TYPE = "fs";
                REPOSITORY_NAME,
            future.actionGet();
        ensureYellowAndNoInitializingShards(RESTORED_INDEX_NAME);
        bootstrapIndexWithOutSearchReplicas(ReplicationType.SEGMENT);
        return Integer.valueOf(metadata.index(index).getSettings().get(SETTING_NUMBER_OF_SEARCH_REPLICAS));
        flushAndRefresh(INDEX_NAME);
}
            + "], "
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreResponse;
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 0)
                SNAPSHOT_NAME,
        SnapshotRestoreException exception = expectThrows(
        bootstrapIndexWithSearchReplicas();
 *
            SnapshotRestoreException.class,
    }
        });
    }
            client().admin().cluster().restoreRemoteStore(new RestoreRemoteStoreRequest().indices(INDEX_NAME), future);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.indices.replication.common.ReplicationType;
                RESTORED_INDEX_NAME,
            + "]. "
        Metadata metadata = client().admin().cluster().prepareState().get().getState().metadata();
public class SearchReplicaRestoreIT extends RemoteSnapshotIT {
            RESTORED_INDEX_NAME,
        assertEquals("true", settingsResponse.getSetting(INDEX_NAME, IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey()));
        Settings settings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .build();
    private static final String REPOSITORY_NAME = "test-repo";
        assertTrue(exception.getMessage().contains(getSnapshotExceptionMessage(ReplicationType.SEGMENT, ReplicationType.DOCUMENT)));
 * SPDX-License-Identifier: Apache-2.0
        ensureGreen(RESTORED_INDEX_NAME);
        GetSettingsResponse settingsResponse = client().admin().indices().prepareGetSettings(INDEX_NAME).get();
import org.opensearch.remotestore.RemoteSnapshotIT;
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
    private static final int DOC_COUNT = 10;
