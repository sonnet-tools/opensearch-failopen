    public void stopShardRebalancing() {  
import org.opensearch.index.IndexService;
        ClusterHealthResponse actionGet = client().admin().cluster().health(request).actionGet();
        } else {  
                )
    }
                node.nodeId(),  
            translogRepoPath = randomRepoPath().toAbsolutePath();
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.action.index.IndexRequest;
        client().prepareIndex(indexName).setSource("auto", true).get();
            assertThat("timed out waiting for relocation", actionGet.isTimedOut(), equalTo(false));  
        return indexService.getShard(0);
                .isAcknowledged()
        assertTrue(
import org.opensearch.cluster.metadata.RepositoryMetadata;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;  
                .setPersistentSettings(  
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());  
        return shardCountByNodeId;
                .setId(UUIDs.randomBase64UUID())
            .put(REPOSITORIES_FAILRATE_SETTING.getKey(), value);  
                        .putNull(MIGRATION_DIRECTION_SETTING.getKey())  
            });
 * SPDX-License-Identifier: Apache-2.0
                    long currentDocCount = indexedDocs.incrementAndGet();
        for (int i = 0; i < numDocs; i++) {
                        } else {  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        }
                client().admin().cluster().preparePendingClusterTasks().get()
            return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true).build();
    public BulkResponse indexBulk(String indexName, int numDocs) {  
    }
import org.opensearch.common.unit.TimeValue;  
            logger.info("Adding docrep node");
package org.opensearch.remotemigration;
                client().admin().cluster().prepareState().get().getState(),  
        randomAlphaOfLength(5),  
    Map<String, Integer> getShardCountByNodeId() {  
                .build();
                .prepareUpdateSettings()
    }  
        );
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        ClusterHealthResponse actionGet = client().admin().cluster().health(request).actionGet();  
                .setPersistentSettings(
 *
        return ensureGreen(TimeValue.timeValueSeconds(60), indices);  
    Settings extraSettings = Settings.EMPTY;  
import org.opensearch.action.bulk.BulkRequest;
            );
            indexingThread.join();
        return client().bulk(bulkRequest).actionGet();  
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
            logger.info("Adding remote store node");
            segmentRepoPath = randomRepoPath().toAbsolutePath();
    public void initDocRepToRemoteMigration() {
    }
        );  
            return indexedDocs.get();  
        this.addRemote = addRemote;
        IndexService indexService = indicesService.indexService(new Index(indexName, uuid));
import org.opensearch.common.Priority;  
import java.util.Map;
                    }  
                        }
import org.opensearch.cluster.routing.RoutingNode;
import org.opensearch.common.settings.Settings;
        randomAlphaOfLength(5),
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
    }  
    protected IndexShard getIndexShard(String dataNode, String indexName) throws ExecutionException, InterruptedException {
import org.opensearch.action.delete.DeleteResponse;
                    Settings.builder()
import org.opensearch.indices.IndicesService;
    }  
import java.util.concurrent.atomic.AtomicBoolean;  
        }  
        private Thread getIndexingThread() {  
import org.opensearch.action.admin.indices.get.GetIndexRequest;  
                .cluster()  
    public ClusterHealthStatus ensureGreen(String... indices) {
            );  
                .admin()
import org.opensearch.index.shard.IndexShard;  
                .prepareUpdateSettings()  
    boolean addRemote = false;
                "----> node {} has {} shards",
import java.util.HashMap;
            internalCluster().client()  
                        .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
    protected static final String ROUTING_TABLE_REPO_NAME = "remote-routing-repo";
        }
            internalCluster().client()
                .put(extraSettings)
        assertTrue(
            logger.info(
        ClusterHealthRequest request = Requests.clusterHealthRequest()
        randomAlphaOfLength(5)
        return actionGet.getStatus();
                .prepareUpdateSettings()  
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.test.OpenSearchIntegTestCase;  
                .request();  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
                clusterState.getRoutingNodes().node(node.nodeId()).numberOfOwningShards()
        ClusterHealthRequest request = Requests.clusterHealthRequest()
            .timeout(t)  
                        if (rarely()) {  
            client().admin()
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, replicaCount))
    public void changeReplicaCountAndEnsureGreen(int replicaCount, String indexName) {
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);  
    private final List<String> documentKeys = List.of(
                "waitForRelocation timed out, cluster state:\n{}\n{}",  
                .get()
import org.junit.Before;
        randomAlphaOfLength(5),  
            logger.info(
        private AtomicLong indexedDocs = new AtomicLong(0);  
            finished.set(true);
    }  
        );
            final IndexRequest request = client().prepareIndex(indexName)  
        assertAcked(
            assertThat("timed out waiting for relocation", actionGet.isTimedOut(), equalTo(false));
import org.opensearch.repositories.fs.ReloadableFsRepository;
                while (finished.get() == false) {
                client().admin().cluster().prepareState().get().getState(),
public class MigrationBaseTestCase extends OpenSearchIntegTestCase {  
        private AtomicBoolean finished = new AtomicBoolean();
            indexingThread = getIndexingThread();
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
        for (final RoutingNode node : clusterState.getRoutingNodes()) {  
            .waitForNoRelocatingShards(true)
    }
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
import org.opensearch.core.index.Index;
import org.opensearch.cluster.health.ClusterHealthStatus;
        }  
        AsyncIndexingService(String indexName) {  
        Settings.Builder settings = Settings.builder()
            client().admin()
        }
 * compatible open source license.
        if (actionGet.isTimedOut()) {  
            .timeout(TimeValue.timeValueSeconds(60))
            this.indexName = indexName;
        randomAlphaOfLength(5),
            shardCountByNodeId.put(node.nodeId(), clusterState.getRoutingNodes().node(node.nodeId()).numberOfOwningShards());  
    }
            bulkRequest.add(request);
import org.opensearch.cluster.ClusterState;
        BulkRequest bulkRequest = new BulkRequest();
            return Settings.builder()  
        createRepository(repoName, ReloadableFsRepository.TYPE, settings);
            .waitForEvents(Priority.LANGUID);
                .put(super.nodeSettings(nodeOrdinal))
                .get()  
            );
        public void stopIndexing() throws InterruptedException {  
    @Before
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
import java.util.concurrent.ExecutionException;
            internalCluster().client()  
import java.util.List;  
                .get()  
    public void setAddRemote(boolean addRemote) {
    public void excludeNodeSet(String attr, String value) {
    }  
                .indices()
                client().admin().cluster().preparePendingClusterTasks().get()
            .put("location", rmd.settings().get("location"))
                            logger.info("Completed ingestion of {} docs. Flushing now", currentDocCount);
        RepositoryMetadata rmd = res.repositories().get(0);  
        public long getIndexedDocs() {
import org.opensearch.transport.client.Requests;
    }
                .get()
                .cluster()
        private String indexName;
                .cluster()
        ensureGreen(indexName);  
        }  
        setAddRemote(false);
    }
                .prepareUpdateSettings(indexName)  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
import org.opensearch.action.bulk.BulkResponse;  
}  
        }  
    }
        assertAcked(
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        }
            .waitForEvents(Priority.LANGUID);
            this.refreshFrequency = refreshFrequency;  
            return new Thread(() -> {
        }
        return actionGet.getStatus();  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, dataNode);
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { repoName });
        );
                .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
    }
        public void startIndexing() {
import java.nio.file.Path;
                            client().admin().indices().prepareFlush(indexName).get();
        }
            logger.info(
import static org.opensearch.repositories.fs.ReloadableFsRepository.REPOSITORIES_FAILRATE_SETTING;
 * this file be licensed under the Apache-2.0 license or a
        }
        private int refreshFrequency = 3;
    public class AsyncIndexingService {
    private void indexSingleDoc(String indexName) {
        );
                    if (currentDocCount > 0 && currentDocCount % refreshFrequency == 0) {
        super.setUp();
import org.opensearch.action.DocWriteResponse;
                        .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")  
                }
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";
                "waitForRelocation timed out, cluster state:\n{}\n{}",
            .waitForNoRelocatingShards(true)  
                .setSource(documentKeys.get(randomIntBetween(0, documentKeys.size() - 1)), randomAlphaOfLength(5))
                .admin()  
                .prepareUpdateSettings()
        if (addRemote) {
    public void completeDocRepToRemoteMigration() {  
    }
    protected Path translogRepoPath;
import java.util.concurrent.atomic.AtomicLong;
        DeleteResponse deleteResponse = client().prepareDelete(indexName, "id").get();
        public void setRefreshFrequency(int refreshFrequency) {
                .admin()
                )
    public ClusterHealthStatus waitForRelocation() {
import org.opensearch.common.UUIDs;
    protected void setFailRate(String repoName, int value) throws ExecutionException, InterruptedException {  
        private Thread indexingThread;
                    Settings.builder()
                .cluster()
/*  
        assertAcked(  
        String clusterManagerName = internalCluster().getClusterManagerName();  
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.exclude._" + attr, value))
        if (segmentRepoPath == null || translogRepoPath == null) {  
                    indexSingleDoc(indexName);  
        final Map<String, Integer> shardCountByNodeId = new HashMap<>();
                            client().admin().indices().prepareRefresh(indexName).get();
                .isAcknowledged()  
    );
    protected static final String REPOSITORY_2_NAME = "test-remote-store-repo-2";
        if (actionGet.isTimedOut()) {
    }  
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
                        .putNull(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey())
import org.opensearch.action.index.IndexResponse;  
    }
        IndexResponse indexResponse = client().prepareIndex(indexName).setId("id").setSource("field", "value").get();  
                .setPersistentSettings(Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none").build())
        }
            indexingThread.start();  
 */  
    protected Path segmentRepoPath;  
                .put(remoteStoreClusterSettings(REPOSITORY_NAME, segmentRepoPath, REPOSITORY_2_NAME, translogRepoPath))  
    public ClusterHealthStatus waitForRelocation(TimeValue t) {  
    public void setUp() throws Exception {  
