 * this file be licensed under the Apache-2.0 license or a
                    @Override
import org.opensearch.common.blobstore.BlobPath;
import org.opensearch.plugins.RepositoryPlugin;
import org.opensearch.repositories.RepositoriesService;
        return indexService.getIndexSettings();
package org.opensearch.repositories.blobstore;
            return Arrays.stream(lockDirectory.listAll())  
            LOCK_FILES,
    }
        assertThat(snapshotInfo.failedShards(), equalTo(0));
    protected IndexSettings getIndexSettings(String indexName) {
        createRepository(client, repoName, repoSettings);
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.SEGMENTS;  
        return Arrays.asList(FsLikeRepoPlugin.class);
            .put("index.refresh_interval", "300s")
        Settings.Builder settings = Settings.builder()
        public Map<String, Repository.Factory> getRepositories(
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
import static org.hamcrest.Matchers.is;
import org.opensearch.test.OpenSearchIntegTestCase;
        ClusterService clusterService = getInstanceFromNode(ClusterService.class);
import org.opensearch.indices.replication.common.ReplicationType;
import static org.hamcrest.Matchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
                (metadata) -> new FsRepository(metadata, env, namedXContentRegistry, clusterService, recoverySettings) {  
                        // eliminate thread name check as we access blobStore on test/main threads  
    public static class FsLikeRepoPlugin extends Plugin implements RepositoryPlugin {
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
import org.opensearch.indices.RemoteStoreSettings;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")  
import java.util.Collections;
        String segmentsPathFixedPrefix = RemoteStoreSettings.CLUSTER_REMOTE_STORE_SEGMENTS_PATH_PREFIX.get(clusterService.getSettings());  
            String id = Integer.toString(i);
    }  
import java.util.Collection;
        for (int i = 0; i < numDocs; i++) {
        final CreateSnapshotResponse response = client().admin()
import org.opensearch.env.Environment;  
import java.io.IOException;
        );  
import org.opensearch.core.common.Strings;
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;
            .cluster()
                REPO_TYPE,
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
                    protected void assertSnapshotOrGenericThread() {
            );  
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.LOCK_FILES;
        ) {  
    }
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        BlobPath shardLevelBlobPath = getShardLevelBlobPath(
    }
        Settings.Builder settingsBuilder = Settings.builder().put(repoSettings);  
                    }
        logger.info("--> creating snapshot [{}] of {} in [{}]", snapshot, indices, repositoryName);
import org.opensearch.index.IndexService;
import org.opensearch.common.settings.Settings;  
            .get();  
                }
            .put("location", OpenSearchIntegTestCase.randomRepoPath(node().settings()));
import static org.hamcrest.Matchers.greaterThan;  
    protected Settings getRemoteStoreBackedIndexSettings() {
import java.util.Arrays;  
        }  
            .put(node().settings())  
            .setWaitForCompletion(true)
    }
    static final String REPO_TYPE = "fsLike";
            .build();
        }
        final RepositoriesService repositoriesService = getInstanceFromNode(RepositoriesService.class);  
            remoteStorerepository.basePath(),
import org.opensearch.indices.recovery.RecoverySettings;
        final IndexService indexService = indicesService.indexService(resolveIndex(indexName));  
import org.opensearch.plugins.Plugin;  
            SEGMENTS,  
import org.opensearch.snapshots.SnapshotInfo;
import org.opensearch.core.xcontent.NamedXContentRegistry;
            return Collections.singletonMap(
 *
    // the reason for this plug-in is to drop any assertSnapshotOrGenericThread as mostly all access in this test goes from test threads  
    protected void createRepository(Client client, String repoName, Settings repoSettings) {
    }
import org.opensearch.snapshots.SnapshotState;  
    }  
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.FS.getSettingsKey())
import org.opensearch.indices.IndicesService;
 * compatible open source license.
    }  
        BlobContainer blobContainer = remoteStorerepository.blobStore().blobContainer(shardLevelBlobPath);
import org.opensearch.index.IndexSettings;  
import org.opensearch.repositories.Repository;  
    protected Collection<Class<? extends Plugin>> getPlugins() {
                .toArray(String[]::new);
        return snapshotInfo;
        assertThat(snapshotInfo.successfulShards(), greaterThan(0));  
            Environment env,
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
            ClusterService clusterService,
        SnapshotInfo snapshotInfo = response.getSnapshotInfo();
            RecoverySettings recoverySettings
        }
    protected void createRepository(Client client, String repoName) {
            client.prepareIndex(indexName).setId(id).setSource("text", "sometext").get();  
            .setIndices(indices.toArray(Strings.EMPTY_ARRAY))
        try (RemoteBufferedOutputDirectory lockDirectory = new RemoteBufferedOutputDirectory(blobContainer)) {
    protected String[] getLockFilesInRemoteStore(String remoteStoreIndex, String remoteStoreRepository) throws IOException {
            NamedXContentRegistry namedXContentRegistry,  
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        return Settings.builder()  
import org.opensearch.cluster.metadata.IndexMetadata;
                .filter(lock -> lock.endsWith(".lock") || lock.endsWith(".v2_lock"))
            "0",
import org.opensearch.index.store.RemoteBufferedOutputDirectory;
    protected SnapshotInfo createSnapshot(String repositoryName, String snapshot, List<String> indices) {
        final BlobStoreRepository remoteStorerepository = (BlobStoreRepository) repositoriesService.repository(remoteStoreRepository);
            remoteStoreIndex,  
            segmentsPathFixedPrefix
import org.opensearch.cluster.service.ClusterService;  
    }  
            client(),
        @Override  
public class BlobStoreRepositoryHelperTests extends OpenSearchSingleNodeTestCase {  
import org.opensearch.repositories.fs.FsRepository;
 */  
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repoName, REPO_TYPE, settingsBuilder);
import java.util.List;  
        OpenSearchIntegTestCase.putRepository(client.admin().cluster(), repoName, REPO_TYPE, settings);
import org.opensearch.common.blobstore.BlobContainer;
/*  
            .prepareCreateSnapshot(repositoryName, snapshot)  
import org.opensearch.index.IndexModule;
        int numDocs = randomIntBetween(10, 20);  
}
    protected void indexDocuments(Client client, String indexName) {
    protected void updateRepository(Client client, String repoName, Settings repoSettings) {
import org.opensearch.transport.client.Client;  
