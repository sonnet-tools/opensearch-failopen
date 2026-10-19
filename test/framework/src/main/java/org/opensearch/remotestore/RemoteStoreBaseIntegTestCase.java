import org.opensearch.repositories.fs.ReloadableFsRepository;
            indexingStats.put(MAX_SEQ_NO_REFRESHED_OR_FLUSHED + "-shard-" + shardId, maxSeqNoRefreshedOrFlushed);
import org.opensearch.index.shard.IndexShard;
import org.opensearch.common.settings.Settings;
import org.opensearch.index.IndexService;
        prepareCluster(numClusterManagerNodes, numDataOnlyNodes, settings);  
/*  
        for (int i = 0; i < numberOfIterations; i++) {
            );  
    protected Settings remoteStoreIndexSettings(int numberOfReplicas) {
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();  
        } else {
                return FileVisitResult.CONTINUE;
            translogRepoPath = randomRepoPath().toAbsolutePath();  
public class RemoteStoreBaseIntegTestCase extends OpenSearchIntegTestCase {  
        long maxSeqNo = -1;  
        Settings.Builder settings = Settings.builder()  
    public RepositoryMetadata buildRepositoryMetadata(DiscoveryNode node, String name) {
import java.util.HashMap;
    }
            @Override
    }
                refresh(index);
        return defaultIndexSettings();
import org.opensearch.action.index.IndexRequest;  
    protected void setFailRate(String repoName, int value) throws ExecutionException, InterruptedException {
import java.nio.file.Files;
    private boolean metadataSupportedType = randomBoolean();
        Settings settings
import java.util.stream.Stream;
import org.opensearch.plugins.Plugin;  
            .put("location", rmd.settings().get("location"))
        return remoteStoreIndexSettings(numberOfReplicas, 1);
        IndexService indexService = indicesService.indexService(new Index(indexName, uuid));
    }
                new RestoreRemoteStoreRequest().indices(indices).restoreAllShards(restoreAllShards),
                }
            .build();
    protected void prepareCluster(int numClusterManagerNodes, int numDataOnlyNodes, Settings settings) {
            logger.info("Running with remote store fencing enabled for all indices");
    }  
    /**
            ClusterService clusterService = internalCluster().getInstance(ClusterService.class, nodeName);  
        indexingStats.put(MAX_SEQ_NO_TOTAL, maxSeqNo);
import org.junit.After;
            settings.put(remoteStoreRepoSettings());
    }
    }  
    }  
import org.opensearch.remotestore.mocks.MockFsMetadataSupportedRepositoryPlugin;
    protected static final int SHARD_COUNT = 1;
    protected void prepareCluster(
            .collect(Collectors.toMap(key -> key.replace(settingsAttributeKeyPrefix, ""), key -> node.getAttributes().get(key)));
        return indexData(numberOfIterations, invokeFlush, false, index);  
            if (emptyTranslog && i == numberOfIterations - 1) {  
 * compatible open source license.
            segmentRepoPath = randomRepoPath().toAbsolutePath();
            // Validated that all the restricted settings are entact on all the nodes.
                PlainActionFuture.newFuture()
    protected Path translogRepoPath;
    }
        int shardCount,  
    protected static final String REMOTE_ROUTING_TABLE_REPO = "remote-routing-table-repo";
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, dataNode);
import java.util.Collection;  
            }
    protected static int REPLICA_COUNT = 1;  
        return Settings.builder()  
    protected IndexResponse indexSingleDoc(String indexName, boolean forceRefresh) {
        metadataSupportedType = randomBoolean();
            .restoreRemoteStore(  
            } else {
        }
    }
        });  
            .put(remoteStoreIndexSettings(numberOfReplicas))
    protected static final String TOTAL_OPERATIONS = "total-operations";
                REPOSITORY_2_NAME,
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
    protected static boolean randomFencingMode() {  
        long maxSeqNoRefreshedOrFlushed = -1;
import org.opensearch.core.index.Index;  
    );  
        return remoteStoreFencing;  
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { repoName });  
            if (invokeFlush) {
import org.opensearch.index.mapper.MapperService;
                    setting -> assertEquals(
import java.util.Map;
            maxSeqNoRefreshedOrFlushed = maxSeqNo;  
        int replicaCount,
import org.opensearch.action.support.PlainActionFuture;  
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);  
            }
import java.nio.file.attribute.BasicFileAttributes;
    }  
     * to return {@code false}.  
        String uuid = getIndexResponse.getSettings().get(indexName).get(IndexMetadata.SETTING_INDEX_UUID);
            .keySet()
        clusterSettingsSuppliedByTest = false;  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.action.admin.indices.get.GetIndexResponse;
        return indexService.getShard(shardId);  
            refreshedOrFlushedOperations = totalOperations;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)  
            String repoType = metadataSupportedType ? MockFsMetadataSupportedRepositoryPlugin.TYPE_MD : MockFsRepositoryPlugin.TYPE;
import org.opensearch.repositories.RepositoriesService;  
            }  
                .forEach(
            createIndex(index, remoteStoreIndexSettings(replicaCount, shardCount));
        return indexingStats;
        String forced = System.getProperty("tests.remote_store.fencing");
    }
    }
    }
        Map<String, String> settingsMap = node.getAttributes()  
            }
    }  
        int numClusterManagerNodes,
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s")  
                for (BulkItemResponse singleResp : res.getItems()) {
        int shardId = 0;
import org.opensearch.indices.IndicesService;  
    protected static final String MAX_SEQ_NO_TOTAL = "max-seq-no-total";  
                REPOSITORY_NAME,
        final RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
                    .collect(Collectors.toList());  
    Settings defaultIndexSettings() {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.admin.cluster.remotestore.restore.RestoreRemoteStoreRequest;
    protected static final String REPOSITORY_3_NAME = "test-remote-store-repo-3";  
     * Randomized per test from the test seed (like {@code asyncUploadMockFsRepo} above), so CI exercises the
import org.opensearch.cluster.metadata.RepositoriesMetadata;  
    public static int getFileCount(Path path) throws IOException {
                repoType  
        return randomBoolean();
        IndexService indexService = indicesService.indexService(new Index(indexName, uuid));
        return filesExisting.get();
    protected static final String REFRESHED_OR_FLUSHED_OPERATIONS = "refreshed-or-flushed-operations";
    protected static final String REPOSITORY_2_NAME = "test-remote-store-repo-2";
import org.opensearch.action.bulk.BulkItemResponse;  
import org.opensearch.indices.replication.common.ReplicationType;
        indexingStats.put(MAX_SEQ_NO_REFRESHED_OR_FLUSHED, maxSeqNoRefreshedOrFlushed);  
    protected boolean clusterSettingsSuppliedByTest = false;
        internalCluster().startDataOnlyNodes(numDataOnlyNodes, settings);
     * existing remote store + segment replication regression surface in both modes across runs; reproduce a given  
                return Stream.concat(super.nodePlugins().stream(), Stream.of(MockFsMetadataSupportedRepositoryPlugin.class))
        if (clusterSettingsSuppliedByTest == false) {  
            indexRequestBuilder.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
import org.opensearch.cluster.service.ClusterService;  
        Map<String, String> nodeAttributes = node.getAttributes();
        Settings remoteStoreRepoSettings;  
import org.opensearch.indices.RemoteStoreSettings;
                .request();  
import org.opensearch.index.IndexModule;
     * choice with {@code -Dtests.seed}, or force one mode for a whole run with
            DiscoveryNode node = clusterService.localNode();
import org.opensearch.action.admin.indices.get.GetIndexRequest;
            .cluster()
            remoteStoreRepoSettings = remoteStoreClusterSettings(  
        long totalOperations = 0;
                        singleResp.getResponse().getSeqNo()
    protected Path segmentRepoPath;  
        Settings.Builder settings = Settings.builder();  
        for (int i = 0; i < numDocs; i++) {
    }  
                        setting.get(actualRepository.settings()),
        return Settings.builder()  
        return remoteStoreRepoSettings;
            assertAcked(client().admin().indices().prepareClose(indices));
        final BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(repositoryName);  
    private final List<String> documentKeys = List.of(  
import org.opensearch.cluster.metadata.RepositoryMetadata;
    }
        }  
    }  
import java.nio.file.SimpleFileVisitor;
        return client().bulk(bulkRequest).actionGet();  
    ) {
import java.nio.file.Path;  
        String clusterManagerName = internalCluster().getClusterManagerName();
        randomAlphaOfLength(5),
                .setId(UUIDs.randomBase64UUID())
                filesExisting.incrementAndGet();  
        prepareCluster(numClusterManagerNodes, numDataOnlyNodes, indices, replicaCount, shardCount, Settings.EMPTY);
    }
import java.util.List;
     * When {@code true}, the whole test runs with the object-store fence engaged: the dynamic cluster default
        assertRemoteStoreRepositoryOnAllNodes(REPOSITORY_NAME);
                BulkResponse res = indexBulk(index, numberOfOperations);  
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();  
                );
import org.opensearch.common.UUIDs;
        }
        return indexRequestBuilder.get();  
    protected boolean remoteStoreFencingForAllIndices() {
            .build();
        for (String index : indices.split(",")) {
        if (asyncUploadMockFsRepo) {
        String settingsAttributeKeyPrefix = String.format(Locale.getDefault(), REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX, name);
import org.opensearch.cluster.node.DiscoveryNode;
        }
    }  
        if (forceRefresh) {  
 * this file be licensed under the Apache-2.0 license or a
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
    }
            int numberOfOperations = randomIntBetween(20, 50);  
import static org.opensearch.repositories.fs.ReloadableFsRepository.REPOSITORIES_FAILRATE_SETTING;  
        return Settings.builder()
        if (!clusterSettingsSuppliedByTest && asyncUploadMockFsRepo) {  
        IndexRequestBuilder indexRequestBuilder = client().prepareIndex(indexName)  
            .filter(key -> key.startsWith(settingsAttributeKeyPrefix))  
        RepositoryMetadata rmd = res.repositories().get(0);
            remoteStoreRepoSettings = remoteStoreClusterSettings(REPOSITORY_NAME, segmentRepoPath, REPOSITORY_2_NAME, translogRepoPath);  
        RepositoriesMetadata repositories = internalCluster().getInstance(ClusterService.class, internalCluster().getNodeNames()[0])
    protected static final String MAX_SEQ_NO_REFRESHED_OR_FLUSHED = "max-seq-no-refreshed-or-flushed";
 * SPDX-License-Identifier: Apache-2.0
        }
        if (restoreAllShards) {
        randomAlphaOfLength(5),
            .metadata()
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
import java.util.concurrent.ExecutionException;
    protected IndexResponse indexSingleDoc(String indexName) {
import java.util.Locale;  
            public FileVisitResult postVisitDirectory(Path dir, IOException impossible) throws IOException {  
    protected boolean remoteStoreFencing = randomFencingMode();
        final AtomicInteger filesExisting = new AtomicInteger(0);  
                continue;
import java.util.concurrent.atomic.AtomicInteger;  
    }
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), String.valueOf(refresh))  
    protected IndexShard getIndexShard(String dataNode, String indexName) throws ExecutionException, InterruptedException {
            @Override
        clusterAdmin().prepareCleanupRepository(REPOSITORY_2_NAME).get();
            if (metadataSupportedType) {
        settings.put(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING.getKey(), true);
    }
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";
    }
        client().admin()
            .state()  
                translogRepoPath,
            .put(defaultIndexSettings())
    protected boolean asyncUploadMockFsRepo = randomBoolean();  
        }
                        String.format(Locale.ROOT, "Restricted Settings mismatch [%s]", setting.getKey()),  
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
    @Override
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;  
            final IndexRequest request = client().prepareIndex(indexName)  
                    indexingStats.put(
import org.opensearch.action.bulk.BulkRequest;
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)  
     * <p>
        }
        assertRemoteStoreRepositoryOnAllNodes(REPOSITORY_2_NAME);
        createRepository(repoName, ReloadableFsRepository.TYPE, settings);  
            RepositoryMetadata expectedRepository = buildRepositoryMetadata(node, repositoryName);
     * remote-store-backed index the test creates is fenced — with no per-test changes. This is exactly the path an
            settings.put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FENCING_ENABLED.getKey(), true);
    }
    protected void prepareCluster(int numClusterManagerNodes, int numDataOnlyNodes, String indices, int replicaCount, int shardCount) {  
    protected Settings remoteStoreIndexSettings(int numberOfReplicas, long totalFieldLimit, int refresh) {
    protected Map<String, Long> indexData(int numberOfIterations, boolean invokeFlush, boolean emptyTranslog, String index) {  
            .custom(RepositoriesMetadata.TYPE);
    protected Settings remoteStoreRepoSettings() {
        }
            ensureYellowAndNoInitializingShards(index);  
        return super.nodePlugins();
    protected Settings remoteStoreIndexSettings(int numberOfReplicas, int numberOfShards) {
        randomAlphaOfLength(5),  
        GetIndexResponse getIndexResponse = client(clusterManagerName).admin().indices().getIndex(new GetIndexRequest()).get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                repoType,  
    public Settings indexSettings() {  
                flushAndRefresh(index);  
        indexingStats.put(REFRESHED_OR_FLUSHED_OPERATIONS, refreshedOrFlushedOperations);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
            int numberOfBulk = randomIntBetween(1, 5);
        settingsMap.entrySet().forEach(entry -> settings.put(entry.getKey(), entry.getValue()));
        String type = nodeAttributes.get(String.format(Locale.getDefault(), REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT, name));  
                totalOperations += numberOfOperations;
        String indices,
        return indexService.getShard(0);
import org.opensearch.action.support.WriteRequest;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
import java.nio.file.FileVisitResult;
    public void assertRemoteStoreRepositoryOnAllNodes(String repositoryName) {
                        MAX_SEQ_NO_TOTAL + "-shard-" + singleResp.getResponse().getShardId().id(),  
            ensureGreen(index);
            .setSource(documentKeys.get(randomIntBetween(0, documentKeys.size() - 1)), randomAlphaOfLength(5));
            .put(super.indexSettings())
        Settings.Builder settings = Settings.builder().put(super.nodeSettings(nodeOrdinal));
            for (int j = 0; j < numberOfBulk; j++) {
                return FileVisitResult.CONTINUE;
        }
        return settings.build();
            } else {
        for (String nodeName : internalCluster().getNodeNames()) {
        String clusterManagerName = internalCluster().getClusterManagerName();  
        }
     * ({@code cluster.remote_store.fencing.enabled}) is put into every node's settings, and since that default is  
import java.util.stream.Collectors;
        indexingStats.put(TOTAL_OPERATIONS, totalOperations);  
        if (remoteStoreFencingForAllIndices()) {  
        }
import org.opensearch.cluster.metadata.IndexMetadata;
        randomAlphaOfLength(5),
            }  
    protected void restore(boolean restoreAllShards, String... indices) {  
import org.opensearch.action.index.IndexResponse;
            return Boolean.parseBoolean(forced);  
                    maxSeqNo = singleResp.getResponse().getSeqNo();  
    }  
            repository.getRestrictedSystemRepositorySettings()
                    );
            .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), totalFieldLimit)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
            );
                return Stream.concat(super.nodePlugins().stream(), Stream.of(MockFsRepositoryPlugin.class)).collect(Collectors.toList());
     * operator enabling the feature fleet-wide takes.  
        BulkRequest bulkRequest = new BulkRequest();
                segmentRepoPath,
        Map<String, Long> indexingStats = new HashMap<>();  
        int numDataOnlyNodes,  
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, dataNode);
        long refreshedOrFlushedOperations = 0;
            .setId(UUIDs.randomBase64UUID())
            .stream()
        if (segmentRepoPath == null || translogRepoPath == null) {
        RepositoryMetadata actualRepository = repositories.repository(repositoryName);  
import org.opensearch.index.IndexSettings;  
            .put(REPOSITORIES_FAILRATE_SETTING.getKey(), value);
                    )  
    }  
    @After
    public void teardown() {
        if (forced != null) {
        randomAlphaOfLength(5)
    protected Settings nodeSettings(int nodeOrdinal) {  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            .build();
    protected BulkResponse indexBulk(String indexName, int numDocs) {  
}  
    protected Map<String, Long> indexData(int numberOfIterations, boolean invokeFlush, String index) {
    @Override
     * baked into the final {@code index.remote_store.fencing.enabled} index setting at creation time, every
     * {@code -Dtests.remote_store.fencing=true|false}. Suites that manage fencing explicitly should override this
    protected IndexShard getIndexShardFromShardId(String dataNode, String indexName, Integer shardId) throws ExecutionException,
import org.opensearch.test.OpenSearchIntegTestCase;  
 *
package org.opensearch.remotestore;
import org.opensearch.action.index.IndexRequestBuilder;
 */  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        return indexSingleDoc(indexName, false);
     */
                .setSource(documentKeys.get(randomIntBetween(0, documentKeys.size() - 1)), randomAlphaOfLength(5))
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                .stream()  
                        setting.get(expectedRepository.settings())
            bulkRequest.add(request);
        return new RepositoryMetadata(name, type, settings.build());
            }  
import java.io.IOException;  
        }  
        remoteStoreFencing = randomFencingMode();  
        asyncUploadMockFsRepo = randomBoolean();
        internalCluster().startClusterManagerOnlyNodes(numClusterManagerNodes, settings);  
        InterruptedException {  
            // skip indexing if last iteration as we dont want to have any data in remote translog
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
