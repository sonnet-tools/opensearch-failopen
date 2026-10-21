                .setId(UUIDs.randomBase64UUID())
 * The OpenSearch Contributors require contributions made to
            internalCluster().client()
            .waitForEvents(Priority.LANGUID);
                )
    }
import org.opensearch.repositories.fs.ReloadableFsRepository;
            this.indexName = indexName;
import org.opensearch.cluster.health.ClusterHealthStatus;
            client().admin()
import org.opensearch.common.settings.Settings;
        private Thread getIndexingThread() {
            .waitForNoRelocatingShards(true)
        private AtomicBoolean finished = new AtomicBoolean();
                .prepareUpdateSettings()
        }
                        .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
    }
                clusterState.getRoutingNodes().node(node.nodeId()).numberOfOwningShards()
            client().admin()
        assertEquals(DocWriteResponse.Result.CREATED, indexResponse.getResult());
    }
                        }
        public long getIndexedDocs() {
import java.util.List;
        AsyncIndexingService(String indexName) {
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
 * compatible open source license.
    public ClusterHealthStatus waitForRelocation() {
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
        setAddRemote(false);
                .prepareUpdateSettings()
        }
                        .putNull(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey())
                .put(extraSettings)
                            logger.info("Completed ingestion of {} docs. Flushing now", currentDocCount);
import org.opensearch.action.index.IndexResponse;
    public BulkResponse indexBulk(String indexName, int numDocs) {
    public void stopShardRebalancing() {
            });
    private void indexSingleDoc(String indexName) {
        randomAlphaOfLength(5)
            assertThat("timed out waiting for relocation", actionGet.isTimedOut(), equalTo(false));
    }
                .setPersistentSettings(
        if (actionGet.isTimedOut()) {
        return actionGet.getStatus();
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
                .admin()
            return Settings.builder()
    }
                client().admin().cluster().preparePendingClusterTasks().get()
                .prepareUpdateSettings()
            indexingThread.start();
            .waitForNoRelocatingShards(true)
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        }
import org.opensearch.action.admin.indices.get.GetIndexRequest;
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, dataNode);
        for (int i = 0; i < numDocs; i++) {
        client().prepareIndex(indexName).setSource("auto", true).get();
        randomAlphaOfLength(5),
        );
        } else {
    }
        );
        return indexService.getShard(0);
                    Settings.builder()
import org.opensearch.cluster.metadata.RepositoryMetadata;
            internalCluster().client()
        );
import java.util.Map;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void changeReplicaCountAndEnsureGreen(int replicaCount, String indexName) {
            .timeout(TimeValue.timeValueSeconds(60))
        }
import java.util.concurrent.ExecutionException;
        return shardCountByNodeId;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import org.opensearch.cluster.routing.RoutingNode;
import org.opensearch.common.Priority;
            this.refreshFrequency = refreshFrequency;
    protected void setFailRate(String repoName, int value) throws ExecutionException, InterruptedException {
    Map<String, Integer> getShardCountByNodeId() {
                .get()
    boolean addRemote = false;
        }
        if (actionGet.isTimedOut()) {
        return client().bulk(bulkRequest).actionGet();
    @Before
            return indexedDocs.get();
        this.addRemote = addRemote;
import org.opensearch.common.unit.TimeValue;
        final Map<String, Integer> shardCountByNodeId = new HashMap<>();
    public void completeDocRepToRemoteMigration() {
        ClusterHealthRequest request = Requests.clusterHealthRequest()
            );
import org.opensearch.core.index.Index;
import org.opensearch.cluster.metadata.IndexMetadata;
/*
import org.opensearch.index.shard.IndexShard;
        randomAlphaOfLength(5),
        }
            translogRepoPath = randomRepoPath().toAbsolutePath();
        if (segmentRepoPath == null || translogRepoPath == null) {
        super.setUp();
            .put(REPOSITORIES_FAILRATE_SETTING.getKey(), value);
        }
                "waitForRelocation timed out, cluster state:\n{}\n{}",
                .request();
        ClusterHealthRequest request = Requests.clusterHealthRequest()
        createRepository(repoName, ReloadableFsRepository.TYPE, settings);
                }
            logger.info("Adding docrep node");
import static org.opensearch.repositories.fs.ReloadableFsRepository.REPOSITORIES_FAILRATE_SETTING;
        }
    }
 *
import org.opensearch.common.UUIDs;
                .indices()
        assertAcked(
}
import org.opensearch.action.DocWriteResponse;
            indexingThread.join();
            shardCountByNodeId.put(node.nodeId(), clusterState.getRoutingNodes().node(node.nodeId()).numberOfOwningShards());
            logger.info(
    public class AsyncIndexingService {
        ensureGreen(indexName);
                    indexSingleDoc(indexName);
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
                .admin()
import java.util.HashMap;
            .put("location", rmd.settings().get("location"))
    public void setAddRemote(boolean addRemote) {
            finished.set(true);
            logger.info(
                            client().admin().indices().prepareRefresh(indexName).get();
            segmentRepoPath = randomRepoPath().toAbsolutePath();
        RepositoryMetadata rmd = res.repositories().get(0);
import org.opensearch.action.index.IndexRequest;
        private AtomicLong indexedDocs = new AtomicLong(0);
        String clusterManagerName = internalCluster().getClusterManagerName();
                "waitForRelocation timed out, cluster state:\n{}\n{}",
                .setPersistentSettings(Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none").build())
    protected Path translogRepoPath;
                .get()
                .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
import org.opensearch.indices.IndicesService;
        randomAlphaOfLength(5),
                .prepareUpdateSettings(indexName)
        for (final RoutingNode node : clusterState.getRoutingNodes()) {
                .cluster()
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
        ClusterHealthResponse actionGet = client().admin().cluster().health(request).actionGet();
        BulkRequest bulkRequest = new BulkRequest();
    protected static final String REPOSITORY_2_NAME = "test-remote-store-repo-2";
        private int refreshFrequency = 3;
    }
        }
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.exclude._" + attr, value))
                .setPersistentSettings(
        assertAcked(
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
    }
                .isAcknowledged()
        randomAlphaOfLength(5),
                .isAcknowledged()
        }
    public void excludeNodeSet(String attr, String value) {
    );
                    long currentDocCount = indexedDocs.incrementAndGet();
                client().admin().cluster().prepareState().get().getState(),
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";
                        .putNull(MIGRATION_DIRECTION_SETTING.getKey())
            return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true).build();
                .put(remoteStoreClusterSettings(REPOSITORY_NAME, segmentRepoPath, REPOSITORY_2_NAME, translogRepoPath))
        IndexResponse indexResponse = client().prepareIndex(indexName).setId("id").setSource("field", "value").get();
    Settings extraSettings = Settings.EMPTY;
            final IndexRequest request = client().prepareIndex(indexName)
                        } else {
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            .waitForEvents(Priority.LANGUID);
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
package org.opensearch.remotemigration;
    private final List<String> documentKeys = List.of(
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
    protected Path segmentRepoPath;
        Settings.Builder settings = Settings.builder()
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
    protected Settings nodeSettings(int nodeOrdinal) {
                        .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
    }
public class MigrationBaseTestCase extends OpenSearchIntegTestCase {
                .cluster()
        assertTrue(
    }
    }
        DeleteResponse deleteResponse = client().prepareDelete(indexName, "id").get();
        public void startIndexing() {
    public void setUp() throws Exception {
        }
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
                            client().admin().indices().prepareFlush(indexName).get();
    }
                .cluster()
                .get()
import org.opensearch.transport.client.Requests;
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { repoName });
                        if (rarely()) {
    protected static final String ROUTING_TABLE_REPO_NAME = "remote-routing-repo";
        assertTrue(
            indexingThread = getIndexingThread();
    protected IndexShard getIndexShard(String dataNode, String indexName) throws ExecutionException, InterruptedException {
import org.opensearch.index.IndexService;
            );
            internalCluster().client()
        );
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
                .get()
                )
                .build();
    public void initDocRepToRemoteMigration() {
    public ClusterHealthStatus ensureGreen(String... indices) {
            logger.info("Adding remote store node");
                .admin()
        private String indexName;
            logger.info(
        return actionGet.getStatus();
        );
                client().admin().cluster().prepareState().get().getState(),
import java.util.concurrent.atomic.AtomicLong;
                .prepareUpdateSettings()
                .setSource(documentKeys.get(randomIntBetween(0, documentKeys.size() - 1)), randomAlphaOfLength(5))
                client().admin().cluster().preparePendingClusterTasks().get()
import java.util.concurrent.atomic.AtomicBoolean;
                node.nodeId(),
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchIntegTestCase;
        if (addRemote) {
        assertAcked(
        ClusterHealthResponse actionGet = client().admin().cluster().health(request).actionGet();
import org.opensearch.action.delete.DeleteResponse;
        return ensureGreen(TimeValue.timeValueSeconds(60), indices);
    }
                "----> node {} has {} shards",
    }
import java.nio.file.Path;
                    Settings.builder()
 */
 * SPDX-License-Identifier: Apache-2.0
            );
    public ClusterHealthStatus waitForRelocation(TimeValue t) {
import org.opensearch.action.bulk.BulkResponse;
        public void setRefreshFrequency(int refreshFrequency) {
                    }
    }
                .cluster()
        }
    }
        public void stopIndexing() throws InterruptedException {
            return new Thread(() -> {
                    if (currentDocCount > 0 && currentDocCount % refreshFrequency == 0) {
import org.opensearch.cluster.ClusterState;
            .timeout(t)
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, replicaCount))
import org.opensearch.action.bulk.BulkRequest;
                while (finished.get() == false) {
            assertThat("timed out waiting for relocation", actionGet.isTimedOut(), equalTo(false));
import static org.hamcrest.Matchers.equalTo;
        private Thread indexingThread;
import org.junit.Before;
                .put(super.nodeSettings(nodeOrdinal))
        IndexService indexService = indicesService.indexService(new Index(indexName, uuid));
            bulkRequest.add(request);
