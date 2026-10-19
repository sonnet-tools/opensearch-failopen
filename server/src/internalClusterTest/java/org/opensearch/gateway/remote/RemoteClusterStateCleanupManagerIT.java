import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.SKIP_CLEANUP_STATE_CHANGES;
        Path segmentRepoPath = randomRepoPath();  
        assertEquals(
        // trigger deletion
                .cluster()
            // Retained manifests and Retained manifests + 2 * Skip cleanup state changes (each cluster state update uploads 2 manifests)
            "Cleanup should have stopped after specified batch limit",  
            .listBlobsByPrefix("manifest")
        verifyIndexRoutingFilesDeletion(routingTableRepository, indexRoutingPath, nodesStatsResponse);
    }  
        );
            // There would be >=3 files as shards will transition from UNASSIGNED -> INIT -> STARTED state
            .cluster()
        assertEquals(-1, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval().getMillis());
        int replicaCount = 1;  
    }
import org.opensearch.test.OpenSearchIntegTestCase;  
        ClusterUpdateSettingsResponse response = client().admin()  
        )  
        assertTrue(response.isAcknowledged());  
    public void testRemoteCleanupWithBatchSizeAs20() throws Exception {  
                false  
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
        // now disable
        assertNotEquals(
            .add("cluster-state")
        BlobPath baseMetadataPath = repository.basePath()
        }  
        assertBusy(() -> { assertEquals(1, routingTableRepository.blobStore().blobContainer(indexRoutingPath).listBlobs().size()); });
package org.opensearch.gateway.remote;
        RemoteClusterStateCleanupManager cleanupManager = internalCluster().getClusterManagerNodeInstance(
        BlobStoreRepository routingTableRepository,
        client().admin()  
            .stream()  
        String clusterManagerNode = internalCluster().getClusterManagerName();
            .cluster()
        response = client().admin()
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;  
            assertTrue(response.isAcknowledged());
        ensureGreen(INDEX_NAME);
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), "1m"))  
import org.junit.Before;
            initialCleanupAttemptVersion,  
        assertBusy(() -> {  
                Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
            currentManifests.size()
        ClusterUpdateSettingsResponse response = client().admin()
            int manifestFiles = repository.blobStore().blobContainer(manifestContainerPath).listBlobsByPrefix("manifest").size();
    }
            .get();
            .get();
import java.util.concurrent.TimeUnit;
                .prepareUpdateSettings()
        int clusterManagerNodeCount = 1;
 * The OpenSearch Contributors require contributions made to  
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);  
        ClusterUpdateSettingsResponse response = client().admin()  
        List<String> currentManifests = repository.blobStore()
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);  
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
        assertTrue(response.isAcknowledged());
            .listBlobsByPrefix("manifest")
    public void setup() {
        RemoteClusterStateCleanupManager cleanupManager = internalCluster().getClusterManagerNodeInstance(
import java.util.Map;
        asyncUploadMockFsRepo = false;
        assertTrue(response.isAcknowledged());
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                REMOTE_ROUTING_TABLE_REPO,
        assertBusy(() -> { assertFalse(cleanupManager.isDeleteStaleMetadataRunning().get()); });  
            )  
import org.opensearch.gateway.remote.model.RemoteRoutingTableBlobStore;  
        // attempt only 1 batch to validate we stop after specified attempts
        });  
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), -1))
        // trigger deletion  
                manifestFiles >= RETAINED_MANIFESTS && manifestFiles < RETAINED_MANIFESTS + 2 * SKIP_CLEANUP_STATE_CHANGES
        // ensure cleanup is completed and successful
        assertEquals(
    @Override
    }  
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);  
            .prepareUpdateSettings()
        // set cleanup interval to 100 ms to make the test faster  
        int shardCount = randomIntBetween(1, 2);  
        assertBusy(() -> {  
    private BlobPath getBaseMetadataPath(BlobStoreRepository repository) {  
        // update cluster state 21 times to ensure that clean up has run after this will upload 42 manifest files
import org.opensearch.discovery.DiscoveryStats;
            .stream()
import java.util.stream.Collectors;  
        // disable auto cleanup as the test will trigger the deletion manually
        // set cleanup interval to 100 ms to make the test faster
import java.util.Base64;  
            .get();
        BlobPath manifestContainerPath = baseMetadataPath.add("manifest");  
            if (Objects.equals(persistedStateStats.getStatsName(), REMOTE_UPLOAD)) {
            .blobContainer(manifestContainerPath)
        List<String> initialManifests = repository.blobStore()
    }
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
            cleanupManager.getLastCleanupAttemptStateVersion()
        settingsBuilder.put(
            logger.info("number of current manifest file: {}", manifestFiles);
        int maxBatchesToDelete = 1;  
    }
        NodesStatsResponse nodesStatsResponse = client().admin()
        for (int i = n; i > 0; i--) {
            // other than replica count change which can upload new manifest files, that's why we check that number of manifests is between
        assertEquals(1, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval().getMinutes());
        assertTrue(initialManifests.size() >= 50);
        int replicaCount = 1;
            .setPersistentSettings(
    ) throws Exception {
            }
        // ensure we update the last successful cleanup attempt version once we update  
            .prepareUpdateSettings()  
        // disable auto cleanup as the test will trigger the deletion manually  
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);  
            .blobContainer(manifestContainerPath)  
            .prepareUpdateSettings()  
    private final RemoteStoreEnums.PathType pathType = RemoteStoreEnums.PathType.HASHED_PREFIX;
                long cleanupAttemptFailedCount = extendedFields.get(RemoteUploadStats.INDEX_ROUTING_FILES_CLEANUP_ATTEMPT_FAILED_COUNT)
/*  
        Path translogRepoPath = randomRepoPath();
            .add(
        BlobPath indexRoutingPath,
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount, settings);
        int clusterManagerNodeCount = 1;
            .prepareUpdateSettings()
            .cluster()
        performBatchedDeletionsGivenBatchSize(50);
            .prepareUpdateSettings()  
    }  
                .get();
        int dataNodeCount = shardCount * (replicaCount + 1);  
    }
                Base64.getUrlEncoder()  
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), -1)
        int clusterManagerNodeCount = 1;  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
            .keySet()
    private void performBatchedDeletionsGivenBatchSize(int batchSize) throws Exception {  
        // wait for completion  
        List<String> last10Initial = initialManifests.subList(0, 10);  
        int dataNodeCount = shardCount * (replicaCount + 1);
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT;
import org.opensearch.cluster.coordination.PersistedStateStats;
            .prepareUpdateSettings()  
            .sorted()
            .cluster()
        cleanupManager.cleanUpStaleFiles();  
    }
public class RemoteClusterStateCleanupManagerIT extends RemoteStoreBaseIntegTestCase {
            .cluster()  
 *
            .blobContainer(manifestContainerPath)
        assertTrue(response.isAcknowledged());
        int newReplicaCount = randomIntBetween(0, 3);
        return repository.basePath()
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true).build();
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        // now set Clean up interval to 1 min
            )
            .setPersistentSettings(  
        RemoteClusterStateCleanupManager remoteClusterStateCleanupManager = internalCluster().getClusterManagerNodeInstance(
            .sorted()
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), batchSizePerDeletion)
        int dataNodeCount = shardCount * (replicaCount + 1);  
                    .withoutPadding()
        assertEquals(shardCount * (replicaCount + 1), getNumShards(INDEX_NAME).totalNumShards);
            .add("cluster-state")
                    .encodeToString(getClusterState().getClusterName().value().getBytes(StandardCharsets.UTF_8))
        // To ensure we complete the cleanup entirely
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
import org.opensearch.repositories.RepositoriesService;
 * compatible open source license.
        assertEquals(CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval());
        assertEquals(
    public void testRemoteCleanupWithBatchSizeAs50() throws Exception {
}
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);
    @Before  
    }
        updateClusterStateNTimes(RETAINED_MANIFESTS + SKIP_CLEANUP_STATE_CHANGES + 1);  
    public void testRemoteCleanupTaskUpdated() {
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
        // to repository, if manifest files are less than that it means clean up has run
            .get();
            RemoteClusterStateCleanupManager.class
    private static final String INDEX_NAME = "test-index";  
        return pathType.path(  
 */  
        // to repository, if manifest files are less than that it means clean up has run
            last10Initial,
            RemoteClusterStateCleanupManager.class
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;  
        RemoteClusterStateCleanupManager remoteClusterStateCleanupManager = internalCluster().getClusterManagerNodeInstance(  
            "Last 10 manifest files should remain the same after cleanup",  
            .sorted()  
        );
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), batchSize)
            ClusterUpdateSettingsResponse response = client().admin()  
import java.util.concurrent.atomic.AtomicLong;
        assertTrue(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isScheduled());
            .listBlobsByPrefix("manifest")  
                assertTrue(extendedFields.containsKey(RemoteUploadStats.INDEX_ROUTING_FILES_CLEANUP_ATTEMPT_FAILED_COUNT));
        int replicaCount = 1;
            .get();  
        settingsBuilder.put(  
        );  
        }  
                .setPersistentSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), i, TimeUnit.SECONDS))  
        RemoteClusterStateCleanupManager remoteClusterStateCleanupManager = internalCluster().getClusterManagerNodeInstance(
import java.util.Objects;  
        BlobStoreRepository routingTableRepository = (BlobStoreRepository) repositoriesService.repository(REMOTE_ROUTING_TABLE_REPO);  
        );  
        Settings.Builder settingsBuilder = Settings.builder();  
        );  
            .cluster()
        BlobPath baseMetadataPath = getBaseMetadataPath(repository);
            .collect(Collectors.toList());
    }  
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
            expectedListAfterDeletionAttempt.size(),
    public void testCleanupStopsAtMaxBatchesLimit() throws Exception {  
        );  
            .put(REMOTE_PUBLICATION_SETTING_KEY, true);
            RemoteStorePathStrategy.PathInput.builder().basePath(baseMetadataPath.add(INDEX_ROUTING_TABLE)).indexUUID(indexUUID).build(),
        List<String> expectedListAfterDeletionAttempt = initialManifests.subList(0, initialManifests.size() - expectedManifestsToBeDeleted);
        List<String> initialManifests = repository.blobStore()  
        int clusterManagerNodeCount = 1;
            RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64
            .add(
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_TABLE;
            .prepareUpdateSettings()
        BlobPath manifestContainerPath = getBaseMetadataPath(repository).add("manifest");
        int shardCount = randomIntBetween(1, 2);
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
        int batchSizePerDeletion = 30;
        updateClusterStateNTimes(RETAINED_MANIFESTS + SKIP_CLEANUP_STATE_CHANGES + 1);  
        int dataNodeCount = shardCount * (replicaCount + 1);
            .cluster()
    private void updateClusterStateNTimes(int n) {  
        // Verify index routing files delete stats
    private Map<String, Long> initialTestSetup(int shardCount, int replicaCount, int dataNodeCount, int clusterManagerNodeCount) {
            )  
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING.getKey(), maxBatchesToDelete)
        List<String> currentManifests = repository.blobStore()  
            assertTrue(routingTableRepository.blobStore().blobContainer(indexRoutingPath).listBlobs().size() >= 3);
        int clusterManagerNodeCount = 1;  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
                assertEquals(0, cleanupAttemptFailedCount);
        int replicaCount = 1;
            .keySet()  
        for (PersistedStateStats persistedStateStats : discoveryStats.getClusterStateStats().getPersistenceStats()) {
        performBatchedDeletionsGivenBatchSize(100);  
            .add(getClusterState().metadata().clusterUUID());
import org.opensearch.common.blobstore.BlobPath;  
                    .get();  
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount, settingsBuilder.build());
import org.opensearch.cluster.routing.IndexRoutingTable;
        ensureGreen(INDEX_NAME);
            )
        List<String> last10Initial = initialManifests.subList(0, RETAINED_MANIFESTS);  
        assertEquals("Last 10 manifest files should remain the same after cleanup", last10Initial, currentManifests);
        int expectedManifestsToBeDeleted = (batchSizePerDeletion - RETAINED_MANIFESTS) * maxBatchesToDelete;
        client().admin()
            .keySet()
            .collect(Collectors.toList());  
            .get();
        );
        Path remoteRoutingTableRepoPath = randomRepoPath();
        // disable the clean up to avoid race condition during shutdown  
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING;  
        assertTrue(response.isAcknowledged());  
            // we can't guarantee that we have same number of manifest as Retained manifest in our repo as there can be other queued task  
    private void verifyIndexRoutingFilesDeletion(  
            initialCleanupAttemptVersion
            .add(getClusterState().metadata().clusterUUID());
        int dataNodeCount = shardCount * (replicaCount + 1);
            );  
            RemoteRoutingTableBlobStore.REMOTE_ROUTING_TABLE_PATH_TYPE_SETTING.getKey(),
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);  
        assertTrue(response.isAcknowledged());
        NodesStatsResponse nodesStatsResponse  
        response = client().admin()
                Base64.getUrlEncoder()  
    public void testRemoteCleanupDeleteStale() throws Exception {
        );  
            currentManifests.subList(0, RETAINED_MANIFESTS)
            .keySet()  
            .get();  
        assertFalse(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isScheduled());  
    }
        long initialCleanupAttemptVersion = cleanupManager.getLastCleanupAttemptStateVersion();
            .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())
                segmentRepoPath,
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;  
                    .withoutPadding()
    private BlobPath getIndexRoutingPath(BlobPath baseMetadataPath, String indexUUID) {
                REPOSITORY_NAME,  
        // disable the clean up to avoid race condition during shutdown  
                    .encodeToString(getClusterState().getClusterName().value().getBytes(StandardCharsets.UTF_8))
            .prepareUpdateSettings()
    protected Settings nodeSettings(int nodeOrdinal) {  
        // update cluster state 21 times to ensure that clean up has run after this will upload 42 manifest files
        int shardCount = randomIntBetween(1, 2);  
        int replicaCount = 1;
    public void testRemoteCleanupDeleteStaleIndexRoutingFiles() throws Exception {
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING;  
import org.opensearch.index.remote.RemoteStoreEnums;
        BlobPath manifestContainerPath = getBaseMetadataPath(repository).add("manifest");  
import org.opensearch.index.remote.RemoteStorePathStrategy;
        int shardCount = randomIntBetween(1, 2);
        List<IndexRoutingTable> indexRoutingTables = new ArrayList<>(getClusterState().routingTable().indicesRouting().values());
            "As cleanup batch size is exhausted, we should not update last successful cleanup attempt version",  
            RemoteClusterStateCleanupManager.class
        );  
        DiscoveryStats discoveryStats = nodesStatsResponse.getNodes().get(0).getDiscoveryStats();
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, REMOTE_ROUTING_TABLE_REPO)
            "lastCleanupAttemptStateVersion should be updated after successful cleanup",
        int maxBatchesToAttempt = 20;  
            RemoteStoreEnums.PathType.HASHED_PREFIX.toString()
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), "-1"))
import java.nio.charset.StandardCharsets;  
                remoteRoutingTableRepoPath,
        updateClusterStateNTimes(50);
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
        assertNotNull(discoveryStats.getClusterStateStats());  
            RemoteClusterStateCleanupManager.class  
        return indexStats;  
        // wait for completion
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING;
        );
            .stream()
 * SPDX-License-Identifier: Apache-2.0
            .toList();  
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), -1)  
        updateClusterStateNTimes(50);  
            .listBlobsByPrefix("manifest")
                REPOSITORY_2_NAME,
        assertBusy(() -> assertEquals(100, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval().getMillis()));
        clusterSettingsSuppliedByTest = true;
import java.util.List;
            RemoteClusterStateCleanupManager.class  
            .cluster()  
            .get();
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), "-1"))
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), "100ms"))  
        ClusterUpdateSettingsResponse response = client().admin()
        });
            assertTrue(  
    }  
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING;
        BlobPath indexRoutingPath = getIndexRoutingPath(baseMetadataPath, indexRoutingTables.get(0).getIndex().getUUID());
                "Current number of manifest files: " + manifestFiles,
    private void initialTestSetup(int shardCount, int replicaCount, int dataNodeCount, int clusterManagerNodeCount, Settings settings) {  
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.RETAINED_MANIFESTS;  
    }
                Settings.builder()
    public void testRemoteCleanupWithBatchSizeAs100() throws Exception {
            buildRemoteStoreNodeAttributes(
        int shardCount = randomIntBetween(1, 2);
            .prepareNodesStats(clusterManagerNode)
    }
        assertBusy(() -> { assertFalse(cleanupManager.isDeleteStaleMetadataRunning().get()); });
import org.opensearch.common.settings.Settings;
import java.nio.file.Path;
            .get();  
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING.getKey(), maxBatchesToAttempt)  
            .sorted()
            .stream()
                translogRepoPath,  
            .toList();
import static org.opensearch.gateway.remote.RemoteUploadStats.REMOTE_UPLOAD;
        assertBusy(() -> assertEquals(100, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval().getMillis()));
        );
                Map<String, AtomicLong> extendedFields = persistedStateStats.getExtendedFields();  
            )  
        cleanupManager.cleanUpStaleFiles();
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), "100ms"))
            cleanupManager.getLastCleanupAttemptStateVersion(),
        performBatchedDeletionsGivenBatchSize(20);
            .blobContainer(manifestContainerPath)
        long initialCleanupAttemptVersion = cleanupManager.getLastCleanupAttemptStateVersion();  
            .cluster()
