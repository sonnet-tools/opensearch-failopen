import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
 * SPDX-License-Identifier: Apache-2.0
        Settings.Builder settingsBuilder = Settings.builder()  
    protected static final String BASE_REMOTE_REPO = "test-rs-repo" + TEST_REMOTE_STORE_REPO_SUFFIX;  
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s");
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
        super(nodeSettings);
            var nodes = internalCluster().getDataNodeInstances(Node.class);
import org.opensearch.index.IndexModule;  
 * The OpenSearch Contributors require contributions made to  
            for (var node : nodes) {
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
    }  
import org.opensearch.index.IndexSettings;
    public RemoteSnapshotIT() {
    protected Path remoteRepoPath;
                    fileCache.clear();
    }  
 */  
import org.opensearch.cluster.metadata.RepositoryMetadata;
            .put(REPOSITORIES_FAILRATE_SETTING.getKey(), value);
    }  
import org.opensearch.node.Node;  
import org.opensearch.indices.RemoteStoreSettings;
    void indexDocuments(Client client, String indexName, int fromId, int toId) {  
            .put(super.indexSettings())
import org.opensearch.cluster.metadata.IndexMetadata;  
        super();  
        for (int i = fromId; i < toId; i++) {
            .put("location", rmd.settings().get("location"))
        }
package org.opensearch.remotestore;
        RepositoryMetadata rmd = res.repositories().get(0);
        if (WRITABLE_WARM_INDEX_SETTING.get(settings)) {
import org.opensearch.common.settings.Settings;
        return settings;
 * this file be licensed under the Apache-2.0 license or a
/*  
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)  
import java.nio.file.Path;
        Settings.Builder settings = Settings.builder()  
import org.opensearch.snapshots.AbstractSnapshotIntegTestCase;
                if (fileCache != null) {
            .put(super.nodeSettings(nodeOrdinal))
            .build();
import org.opensearch.transport.client.Client;  
                var fileCache = node.fileCache();  
public abstract class RemoteSnapshotIT extends AbstractSnapshotIntegTestCase {
 *
    @Before  
    protected Settings pinnedTimestampSettings() {
    protected Settings nodeSettings(int nodeOrdinal) {  
import org.junit.Before;
    protected void setFailRate(String repoName, int value) throws ExecutionException, InterruptedException {
        createRepository(repoName, ReloadableFsRepository.TYPE, settings);  
 * compatible open source license.
        remoteRepoPath = randomRepoPath().toAbsolutePath();
    }  
import java.util.concurrent.ExecutionException;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
        clusterAdmin().prepareCleanupRepository(BASE_REMOTE_REPO).get();
            settingsBuilder.put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)  
    }  
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { repoName });  
    @After
    }
    @Override
    protected Settings.Builder getIndexSettings(int numOfShards, int numOfReplicas) {
        Settings settings = Settings.builder()
            }
    }
            .build();
        return settingsBuilder;
        client.admin().indices().prepareFlush(indexName).get();
    protected void indexDocuments(Client client, String indexName, int numOfDocs) {
    public RemoteSnapshotIT(Settings nodeSettings) {
    }
            .put(remoteStoreClusterSettings(BASE_REMOTE_REPO, remoteRepoPath))  
            String id = Integer.toString(i);
}  
                }  
            client.prepareIndex(indexName).setId(id).setSource("text", "sometext").get();  
        return Settings.builder()
        }
            assertAcked(client().admin().indices().prepareDelete("_all").get());  
    public void setup() {
import org.junit.After;
    }
        indexDocuments(client, indexName, 0, numOfDocs);  
import static org.opensearch.repositories.fs.ReloadableFsRepository.REPOSITORIES_FAILRATE_SETTING;
    }  
    public void teardown() {  
import org.opensearch.repositories.fs.ReloadableFsRepository;
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
