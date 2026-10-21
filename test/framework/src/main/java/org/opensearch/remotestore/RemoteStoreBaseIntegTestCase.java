                flushAndRefresh(index);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .filter(key -> key.startsWith(settingsAttributeKeyPrefix))
            public FileVisitResult postVisitDirectory(Path dir, IOException impossible) throws IOException {
    }
        randomAlphaOfLength(5),
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
import org.opensearch.action.bulk.BulkRequest;
    protected static int REPLICA_COUNT = 1;
        int replicaCount,
            if (invokeFlush) {
import org.opensearch.action.support.WriteRequest;
                return Stream.concat(super.nodePlugins().stream(), Stream.of(MockFsRepositoryPlugin.class)).collect(Collectors.toList());
                );
        indexingStats.put(MAX_SEQ_NO_TOTAL, maxSeqNo);
    protected boolean asyncUploadMockFsRepo = randomBoolean();
            settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED.getKey(), true);
import org.opensearch.plugins.Plugin;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
    private boolean metadataSupportedType = randomBoolean();
                return FileVisitResult.CONTINUE;
     * baked into the final {@code index.remote_store.fencing.enabled} index setting at creation time, every
        return Settings.builder()
    protected void setFailRate(String repoName, int value) throws ExecutionException, InterruptedException {
 * this file be licensed under the Apache-2.0 license or a
        randomAlphaOfLength(5)
        prepareCluster(numClusterManagerNodes, numDataOnlyNodes, settings);
            .setSource(documentKeys.get(randomIntBetween(0, documentKeys.size() - 1)), randomAlphaOfLength(5));
import org.opensearch.index.IndexService;
        if (clusterSettingsSuppliedByTest == false) {
        return indexingStats;
import java.util.Collection;
        final RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
 */
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";
        indexingStats.put(MAX_SEQ_NO_REFRESHED_OR_FLUSHED, maxSeqNoRefreshedOrFlushed);
                return Stream.concat(super.nodePlugins().stream(), Stream.of(MockFsMetadataSupportedRepositoryPlugin.class))
        for (int i = 0; i < numberOfIterations; i++) {
                }
    public RepositoryMetadata buildRepositoryMetadata(DiscoveryNode node, String name) {
            .build();
        }
 * compatible open source license.
    }
        String clusterManagerName = internalCluster().getClusterManagerName();
import java.nio.file.Files;
        prepareCluster(numClusterManagerNodes, numDataOnlyNodes, indices, replicaCount, shardCount, Settings.EMPTY);
                    maxSeqNo = singleResp.getResponse().getSeqNo();
        settings.put(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING.getKey(), true);
        for (String nodeName : internalCluster().getNodeNames()) {
import org.junit.After;
    public void teardown() {
        if (forced != null) {
                .forEach(
    }
                translogRepoPath,
        }
            .metadata()
    protected Path translogRepoPath;
    protected static final String REPOSITORY_3_NAME = "test-remote-store-repo-3";
public class RemoteStoreBaseIntegTestCase extends OpenSearchIntegTestCase {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
    }
            translogRepoPath = randomRepoPath().toAbsolutePath();
        for (int i = 0; i < numDocs; i++) {
            if (emptyTranslog && i == numberOfIterations - 1) {
        clusterSettingsSuppliedByTest = false;
                continue;
                for (BulkItemResponse singleResp : res.getItems()) {
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
            segmentRepoPath = randomRepoPath().toAbsolutePath();
        long maxSeqNoRefreshedOrFlushed = -1;
        IndexService indexService = indicesService.indexService(new Index(indexName, uuid));
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
            indexingStats.put(MAX_SEQ_NO_REFRESHED_OR_FLUSHED + "-shard-" + shardId, maxSeqNoRefreshedOrFlushed);
                totalOperations += numberOfOperations;
                .setId(UUIDs.randomBase64UUID())
    }
        return remoteStoreRepoSettings;
                .stream()
        return super.nodePlugins();
        createRepository(repoName, ReloadableFsRepository.TYPE, settings);
            .state()
                repoType,
        client().admin()
            .put(super.indexSettings())
        randomAlphaOfLength(5),
        if (restoreAllShards) {
        assertRemoteStoreRepositoryOnAllNodes(REPOSITORY_NAME);
            RepositoryMetadata expectedRepository = buildRepositoryMetadata(node, repositoryName);
     * When {@code true}, the whole test runs with the object-store fence engaged: the dynamic cluster default
import java.util.stream.Collectors;
import org.opensearch.action.bulk.BulkResponse;
    @Override
    protected Settings nodeSettings(int nodeOrdinal) {
        RepositoryMetadata actualRepository = repositories.repository(repositoryName);
        randomAlphaOfLength(5),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
import org.opensearch.common.settings.Settings;
     * to return {@code false}.
            }
            createIndex(index, remoteStoreIndexSettings(replicaCount, shardCount));
            ClusterService clusterService = internalCluster().getInstance(ClusterService.class, nodeName);
    ) {
import org.opensearch.index.shard.IndexShard;
        randomAlphaOfLength(5),
    }
        return indexService.getShard(shardId);
    protected IndexShard getIndexShard(String dataNode, String indexName) throws ExecutionException, InterruptedException {
            return Boolean.parseBoolean(forced);
    }
import java.nio.file.attribute.BasicFileAttributes;
        return new RepositoryMetadata(name, type, settings.build());
                filesExisting.incrementAndGet();
    public void assertRemoteStoreRepositoryOnAllNodes(String repositoryName) {
    }
    protected IndexShard getIndexShardFromShardId(String dataNode, String indexName, Integer shardId) throws ExecutionException,
    }
    protected void prepareCluster(int numClusterManagerNodes, int numDataOnlyNodes, Settings settings) {
    protected static final String MAX_SEQ_NO_TOTAL = "max-seq-no-total";
package org.opensearch.remotestore;
 *
import org.opensearch.action.admin.indices.get.GetIndexRequest;
        int shardCount,
        asyncUploadMockFsRepo = randomBoolean();
        for (String index : indices.split(",")) {
        if (asyncUploadMockFsRepo) {
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { repoName });
            settings.put(remoteStoreRepoSettings());
                        singleResp.getResponse().getSeqNo()
 * SPDX-License-Identifier: Apache-2.0
        if (remoteStoreFencingForAllIndices()) {
import java.util.concurrent.ExecutionException;
        if (segmentRepoPath == null || translogRepoPath == null) {
            }
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
                new RestoreRemoteStoreRequest().indices(indices).restoreAllShards(restoreAllShards),
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, dataNode);
import org.opensearch.index.IndexModule;
                    );
                repoType
        RepositoriesMetadata repositories = internalCluster().getInstance(ClusterService.class, internalCluster().getNodeNames()[0])
        return Settings.builder()
            int numberOfOperations = randomIntBetween(20, 50);
    }
        }
        return indexRequestBuilder.get();
        IndexService indexService = indicesService.indexService(new Index(indexName, uuid));
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
        });
    protected static final String REPOSITORY_2_NAME = "test-remote-store-repo-2";
import java.util.concurrent.atomic.AtomicInteger;
    protected Map<String, Long> indexData(int numberOfIterations, boolean invokeFlush, String index) {
import org.opensearch.index.mapper.MapperService;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
import java.nio.file.SimpleFileVisitor;
                refresh(index);
    }
    protected Settings remoteStoreIndexSettings(int numberOfReplicas, long totalFieldLimit, int refresh) {
        if (!clusterSettingsSuppliedByTest && asyncUploadMockFsRepo) {
     * remote-store-backed index the test creates is fenced — with no per-test changes. This is exactly the path an
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
import org.opensearch.cluster.node.DiscoveryNode;
    protected static final String REMOTE_ROUTING_TABLE_REPO = "remote-routing-table-repo";
    @After
        return randomBoolean();
            .custom(RepositoriesMetadata.TYPE);
        return indexSingleDoc(indexName, false);
    protected void prepareCluster(int numClusterManagerNodes, int numDataOnlyNodes, String indices, int replicaCount, int shardCount) {
        RepositoryMetadata rmd = res.repositories().get(0);
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
    }
        long totalOperations = 0;
    }
        Settings.Builder settings = Settings.builder().put(super.nodeSettings(nodeOrdinal));
import org.opensearch.action.index.IndexResponse;
    }
import org.opensearch.cluster.service.ClusterService;
            indexRequestBuilder.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        Settings settings
    }
            refreshedOrFlushedOperations = totalOperations;
            .stream()
    protected Map<String, Long> indexData(int numberOfIterations, boolean invokeFlush, boolean emptyTranslog, String index) {
                REPOSITORY_2_NAME,
     * choice with {@code -Dtests.seed}, or force one mode for a whole run with
        internalCluster().startDataOnlyNodes(numDataOnlyNodes, settings);
    protected IndexResponse indexSingleDoc(String indexName) {
        BulkRequest bulkRequest = new BulkRequest();
            .put(defaultIndexSettings())
        return settings.build();
    protected boolean clusterSettingsSuppliedByTest = false;
            }
     * operator enabling the feature fleet-wide takes.
        }
        if (forceRefresh) {
import org.opensearch.action.index.IndexRequest;
                segmentRepoPath,
    protected void prepareCluster(
import org.opensearch.cluster.metadata.RepositoriesMetadata;
        }
                        MAX_SEQ_NO_TOTAL + "-shard-" + singleResp.getResponse().getShardId().id(),
    protected boolean remoteStoreFencing = randomFencingMode();
    }
        Map<String, Long> indexingStats = new HashMap<>();
import org.opensearch.action.bulk.BulkItemResponse;
        long refreshedOrFlushedOperations = 0;
                        setting.get(actualRepository.settings()),
        Map<String, String> nodeAttributes = node.getAttributes();
            int numberOfBulk = randomIntBetween(1, 5);
            // Validated that all the restricted settings are entact on all the nodes.
            repository.getRestrictedSystemRepositorySettings()
            if (metadataSupportedType) {
        metadataSupportedType = randomBoolean();
            .put(REPOSITORIES_FAILRATE_SETTING.getKey(), value);
        int shardId = 0;
        return Settings.builder()
            // skip indexing if last iteration as we dont want to have any data in remote translog
            ensureYellowAndNoInitializingShards(index);
        }
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.indices.IndicesService;
    }
                    setting -> assertEquals(
        }
                    indexingStats.put(
        return remoteStoreFencing;
            } else {
     * <p>
        InterruptedException {
    Settings defaultIndexSettings() {
import java.util.List;
    }
import java.nio.file.FileVisitResult;
            String repoType = metadataSupportedType ? MockFsMetadataSupportedRepositoryPlugin.TYPE_MD : MockFsRepositoryPlugin.TYPE;
                    .collect(Collectors.toList());
        return defaultIndexSettings();
    protected BulkResponse indexBulk(String indexName, int numDocs) {
            }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.common.UUIDs;
        Settings.Builder settings = Settings.builder()
        clusterAdmin().prepareCleanupRepository(REPOSITORY_2_NAME).get();
     * {@code -Dtests.remote_store.fencing=true|false}. Suites that manage fencing explicitly should override this
        String clusterManagerName = internalCluster().getClusterManagerName();
    /**
    }
import org.opensearch.index.IndexSettings;
            .restoreRemoteStore(
                REPOSITORY_NAME,
    public Settings indexSettings() {
            .put(remoteStoreIndexSettings(numberOfReplicas))
        long maxSeqNo = -1;
        }
            bulkRequest.add(request);
        int numClusterManagerNodes,
        return client().bulk(bulkRequest).actionGet();
            .keySet()
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, dataNode);
import org.opensearch.action.index.IndexRequestBuilder;
     * Randomized per test from the test seed (like {@code asyncUploadMockFsRepo} above), so CI exercises the
                .setSource(documentKeys.get(randomIntBetween(0, documentKeys.size() - 1)), randomAlphaOfLength(5))
import org.opensearch.indices.replication.common.ReplicationType;
import java.util.Locale;
            logger.info("Running with remote store fencing enabled for all indices");
import org.opensearch.action.admin.indices.get.GetIndexResponse;
                        setting.get(expectedRepository.settings())
                BulkResponse res = indexBulk(index, numberOfOperations);
        return indexData(numberOfIterations, invokeFlush, false, index);
            .collect(Collectors.toMap(key -> key.replace(settingsAttributeKeyPrefix, ""), key -> node.getAttributes().get(key)));
                        String.format(Locale.ROOT, "Restricted Settings mismatch [%s]", setting.getKey()),
    protected static final int SHARD_COUNT = 1;
            for (int j = 0; j < numberOfBulk; j++) {
        final AtomicInteger filesExisting = new AtomicInteger(0);
    protected Path segmentRepoPath;
/*
    private final List<String> documentKeys = List.of(
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexRequestBuilder indexRequestBuilder = client().prepareIndex(indexName)
                    )
                .request();
            remoteStoreRepoSettings = remoteStoreClusterSettings(
            .setId(UUIDs.randomBase64UUID())
            DiscoveryNode node = clusterService.localNode();
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
        }
            remoteStoreRepoSettings = remoteStoreClusterSettings(REPOSITORY_NAME, segmentRepoPath, REPOSITORY_2_NAME, translogRepoPath);
    protected Settings remoteStoreIndexSettings(int numberOfReplicas, int numberOfShards) {
        String indices,
import static org.opensearch.repositories.fs.ReloadableFsRepository.REPOSITORIES_FAILRATE_SETTING;
import org.opensearch.test.OpenSearchIntegTestCase;
            .build();
            maxSeqNoRefreshedOrFlushed = maxSeqNo;
import org.opensearch.indices.RemoteStoreSettings;
            .build();
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(repositoryName);
    }
            final IndexRequest request = client().prepareIndex(indexName)
            .put("location", rmd.settings().get("location"))
            );
        }
        int numDataOnlyNodes,
    public static int getFileCount(Path path) throws IOException {
    protected Settings remoteStoreRepoSettings() {
        }
                PlainActionFuture.newFuture()
        remoteStoreFencing = randomFencingMode();
    protected static boolean randomFencingMode() {
    }
}
    protected static final String REFRESHED_OR_FLUSHED_OPERATIONS = "refreshed-or-flushed-operations";
    protected Settings remoteStoreIndexSettings(int numberOfReplicas) {
    protected void restore(boolean restoreAllShards, String... indices) {
import java.util.HashMap;
import java.util.stream.Stream;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.index.Index;
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), String.valueOf(refresh))
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            );
        internalCluster().startClusterManagerOnlyNodes(numClusterManagerNodes, settings);
            ensureGreen(index);
            .cluster()
            @Override
    );
        settingsMap.entrySet().forEach(entry -> settings.put(entry.getKey(), entry.getValue()));
import java.nio.file.Path;
        indexingStats.put(TOTAL_OPERATIONS, totalOperations);
            @Override
import java.util.Map;
        Map<String, String> settingsMap = node.getAttributes()
        String type = nodeAttributes.get(String.format(Locale.getDefault(), REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, name));
import java.io.IOException;
        return indexService.getShard(0);
            }
    }
                return FileVisitResult.CONTINUE;
    protected static final String MAX_SEQ_NO_REFRESHED_OR_FLUSHED = "max-seq-no-refreshed-or-flushed";
import org.opensearch.action.support.PlainActionFuture;
     * existing remote store + segment replication regression surface in both modes across runs; reproduce a given
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
import org.opensearch.repositories.fs.ReloadableFsRepository;
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
    protected static final String TOTAL_OPERATIONS = "total-operations";
        indexingStats.put(REFRESHED_OR_FLUSHED_OPERATIONS, refreshedOrFlushedOperations);
    }
        assertRemoteStoreRepositoryOnAllNodes(REPOSITORY_2_NAME);
            } else {
    }
        }
        Settings.Builder settings = Settings.builder();
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
    protected boolean remoteStoreFencingForAllIndices() {
            }
import org.opensearch.remotestore.mocks.MockFsMetadataSupportedRepositoryPlugin;
        return filesExisting.get();
     */
     * ({@code cluster.remote_store.fencing.enabled}) is put into every node's settings, and since that default is
import org.opensearch.repositories.blobstore.BlobStoreRepository;
    }
        } else {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        String settingsAttributeKeyPrefix = String.format(Locale.getDefault(), REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, name);
            assertAcked(client().admin().indices().prepareClose(indices));
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s")
import org.opensearch.cluster.metadata.RepositoryMetadata;
        String forced = System.getProperty("tests.remote_store.fencing");
            .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), totalFieldLimit)
    }
        Settings remoteStoreRepoSettings;
        return remoteStoreIndexSettings(numberOfReplicas, 1);
    protected IndexResponse indexSingleDoc(String indexName, boolean forceRefresh) {
    @Override
