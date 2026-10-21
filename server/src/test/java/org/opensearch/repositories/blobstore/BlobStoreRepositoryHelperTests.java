import org.opensearch.index.IndexService;
    }
import java.util.List;
import org.opensearch.index.IndexModule;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
            client.prepareIndex(indexName).setId(id).setSource("text", "sometext").get();
        createRepository(client, repoName, repoSettings);
import org.opensearch.indices.RemoteStoreSettings;
import org.opensearch.common.blobstore.BlobPath;
            .cluster()
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repoName, REPO_TYPE, settingsBuilder);
    protected void indexDocuments(Client client, String indexName) {
import org.opensearch.transport.client.Client;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
        return snapshotInfo;
 */
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .put("index.refresh_interval", "300s")
        }
 * The OpenSearch Contributors require contributions made to
        ) {
import static org.hamcrest.Matchers.equalTo;
    protected Settings getRemoteStoreBackedIndexSettings() {
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);
import org.opensearch.cluster.service.ClusterService;
    protected void createRepository(Client client, String repoName, Settings repoSettings) {
        );
                }
            RecoverySettings recoverySettings
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
            remoteStorerepository.basePath(),
        final IndexService indexService = indicesService.indexService(resolveIndex(indexName));
 * compatible open source license.
            .setIndices(indices.toArray(Strings.EMPTY_ARRAY))
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
/*
                        // eliminate thread name check as we access blobStore on test/main threads
        @Override
 * this file be licensed under the Apache-2.0 license or a
        return Arrays.asList(FsLikeRepoPlugin.class);
public class BlobStoreRepositoryHelperTests extends OpenSearchSingleNodeTestCase {
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
import org.opensearch.plugins.RepositoryPlugin;
import org.opensearch.repositories.Repository;
        final CreateSnapshotResponse response = client().admin()
            remoteStoreIndex,
import org.opensearch.indices.IndicesService;
        public Map<String, Repository.Factory> getRepositories(
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));
    }
    protected Collection<Class<? extends Plugin>> getPlugins() {
import org.opensearch.core.xcontent.NamedXContentRegistry;
        SnapshotInfo snapshotInfo = response.getSnapshotInfo();
import org.opensearch.index.IndexSettings;
        }
        BlobPath shardLevelBlobPath = getShardLevelBlobPath(
        BlobContainer blobContainer = remoteStorerepository.blobStore().blobContainer(shardLevelBlobPath);
            client(),
            ClusterService clusterService,
    protected void updateRepository(Client client, String repoName, Settings repoSettings) {
    // the reason for this plug-in is to drop any assertSnapshotOrGenericThread as mostly all access in this test goes from test threads
import org.opensearch.indices.replication.common.ReplicationType;
import org.opensearch.plugins.Plugin;
import org.opensearch.repositories.fs.FsRepository;
                REPO_TYPE,
        final BlobStoreRepository remoteStorerepository = (BlobStoreRepository) repositoriesService.repository(remoteStoreRepository);
            .setWaitForCompletion(true)
import org.opensearch.core.common.Strings;
        }
import org.opensearch.repositories.RepositoriesService;
        int numDocs = randomIntBetween(10, 20);
            .put(node().settings())
            .prepareCreateSnapshot(repositoryName, snapshot)
        return indexService.getIndexSettings();
            return Collections.singletonMap(
import org.opensearch.snapshots.SnapshotInfo;
        logger.info("--> creating snapshot [{}] of {} in [{}]", snapshot, indices, repositoryName);
import org.opensearch.common.settings.Settings;
    protected String[] getLockFilesInRemoteStore(String remoteStoreIndex, String remoteStoreRepository) throws IOException {
import org.opensearch.index.store.RemoteBufferedOutputDirectory;
 *
                    }
            "0",
    }
    protected IndexSettings getIndexSettings(String indexName) {
            NamedXContentRegistry namedXContentRegistry,
            LOCK_FILES,
        return Settings.builder()
                    protected void assertSnapshotOrGenericThread() {
                .toArray(String[]::new);
import org.opensearch.snapshots.SnapshotState;
    protected SnapshotInfo createSnapshot(String repositoryName, String snapshot, List<String> indices) {
        Settings.Builder settings = Settings.builder()
        assertThat(snapshotInfo.failedShards(), equalTo(0));
            segmentsPathFixedPrefix
                (metadata) -> new FsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings) {
        ClusterService clusterService = getInstanceFromNode(ClusterService.class);
    }
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.LOCK_FILES;
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()));
    }
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
    public static class FsLikeRepoPlugin extends Plugin implements RepositoryPlugin {
            .build();
        Settings.Builder settingsBuilder = Settings.builder().put(repoSettings);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
}
    }
    static final String REPO_TYPE = "fsLike";
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.indices.recovery.RecoverySettings;
            String id = Integer.toString(i);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
package org.opensearch.repositories.blobstore;
import static org.hamcrest.Matchers.greaterThan;
import java.util.Collections;
            .get();
            );
    }
import org.opensearch.env.Environment;
    protected void createRepository(Client client, String repoName) {
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
    }
                    @Override
                .filter(lock -> lock.endsWith(".lock") || lock.endsWith(".v2_lock"))
            Environment env,
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;
            return Arrays.stream(lockDirectory.listAll())
import org.opensearch.common.blobstore.BlobContainer;
    }
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(clusterService.getSettings());
            SEGMENTS,
        try (RemoteBufferedOutputDirectory lockDirectory = new RemoteBufferedOutputDirectory(blobContainer)) {
import java.util.Map;
import java.util.Collection;
import org.opensearch.cluster.metadata.IndexMetadata;
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repoName, REPO_TYPE, settings);
    }
