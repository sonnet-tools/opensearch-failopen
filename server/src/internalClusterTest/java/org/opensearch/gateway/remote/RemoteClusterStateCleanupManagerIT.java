        int clusterManagerNodeCount = 1;
        List<String> last10Initial = initialManifests.subList(0, 10);
        });
        RemoteClusterStateCleanupManager cleanupManager = internalCluster().getClusterManagerNodeInstance(
        assertTrue(initialManifests.size() >= 50);
            "As cleanup batch size is exhausted, we should not update last successful cleanup attempt version",
        assertBusy(() -> { assertFalse(cleanupManager.isDeleteStaleMetadataRunning().get()); });
        assertBusy(() -> assertEquals(100, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval().getMillis()));
    public void testRemoteCleanupDeleteStale() throws Exception {
        verifyIndexRoutingFilesDeletion(routingTableRepository, indexRoutingPath, nodesStatsResponse);
        Path translogRepoPath = randomRepoPath();
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        RemoteClusterStateCleanupManager remoteClusterStateCleanupManager = internalCluster().getClusterManagerNodeInstance(
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .blobContainer(manifestContainerPath)
            .add(getClusterState().metadata().clusterUUID());
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), "-1"))
            currentManifests.size()
            .put(REMOTE_PUBLICATION_SETTING_KEY, true);
            // we can't guarantee that we have same number of manifest as Retained manifest in our repo as there can be other queued task
        int shardCount = randomIntBetween(1, 2);
        BlobPath manifestContainerPath = getBaseMetadataPath(repository).add("manifest");
                Map<String, AtomicLong> extendedFields = persistedStateStats.getExtendedFields();
            logger.info("number of current manifest file: {}", manifestFiles);
        );
            RemoteClusterStateCleanupManager.class
            // other than replica count change which can upload new manifest files, that's why we check that number of manifests is between
        settingsBuilder.put(
    private final RemoteStoreEnums.PathType pathType = RemoteStoreEnums.PathType.HASHED_PREFIX;
                manifestFiles >= RETAINED_MANIFESTS && manifestFiles < RETAINED_MANIFESTS + 2 * SKIP_CLEANUP_STATE_CHANGES
            }
            .prepareUpdateSettings()
            "lastCleanupAttemptStateVersion should be updated after successful cleanup",
import org.opensearch.repositories.RepositoriesService;
        // to repository, if manifest files are less than that it means clean up has run
        assertEquals(shardCount * (replicaCount + 1), getNumShards(INDEX_NAME).totalNumShards);
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING;
        int dataNodeCount = shardCount * (replicaCount + 1);
import org.opensearch.discovery.DiscoveryStats;
        List<String> currentManifests = repository.blobStore()
import java.nio.file.Path;
        ClusterUpdateSettingsResponse response = client().admin()
        int dataNodeCount = shardCount * (replicaCount + 1);
            RemoteStorePathStrategy.PathInput.builder().basePath(baseMetadataPath.add(INDEX_ROUTING_TABLE)).indexUUID(indexUUID).build(),
        assertNotNull(discoveryStats.getClusterStateStats());
import static org.opensearch.gateway.remote.RemoteUploadStats.REMOTE_UPLOAD;
        for (PersistedStateStats persistedStateStats : discoveryStats.getClusterStateStats().getPersistenceStats()) {
import java.util.ArrayList;
        int replicaCount = 1;
        for (int i = n; i > 0; i--) {
            .listBlobsByPrefix("manifest")
import java.util.concurrent.atomic.AtomicLong;
                REMOTE_ROUTING_TABLE_REPO,
        // attempt only 1 batch to validate we stop after specified attempts
            assertTrue(
        assertTrue(response.isAcknowledged());
import org.opensearch.gateway.remote.model.RemoteRoutingTableBlobStore;
    }
        assertTrue(response.isAcknowledged());
    public void testRemoteCleanupDeleteStaleIndexRoutingFiles() throws Exception {
            .listBlobsByPrefix("manifest")
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);
        assertTrue(response.isAcknowledged());
            .add("cluster-state")
            .stream()
            .sorted()
        // trigger deletion
            cleanupManager.getLastCleanupAttemptStateVersion()
                .cluster()
        assertEquals(
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), "100ms"))
import java.util.concurrent.TimeUnit;
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING;
                REPOSITORY_2_NAME,
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), -1)
    @Before
            .keySet()
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_TABLE;
        // disable auto cleanup as the test will trigger the deletion manually
        updateClusterStateNTimes(50);
        });
        // wait for completion
    }
    public void setup() {
    }
            .stream()
            )
            .cluster()
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;
        int replicaCount = 1;
    private void performBatchedDeletionsGivenBatchSize(int batchSize) throws Exception {
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING.getKey(), maxBatchesToDelete)
        // Verify index routing files delete stats
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);
        int newReplicaCount = randomIntBetween(0, 3);
                Settings.builder()
            .cluster()
        ensureGreen(INDEX_NAME);
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), -1))
    private void updateClusterStateNTimes(int n) {
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
import org.opensearch.index.remote.RemoteStoreEnums;
            .sorted()
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
    @Override
            .add(getClusterState().metadata().clusterUUID());
        );
            .listBlobsByPrefix("manifest")
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);
        int clusterManagerNodeCount = 1;
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
        }
        int replicaCount = 1;
import java.util.Objects;
        int maxBatchesToAttempt = 20;
            )
        DiscoveryStats discoveryStats = nodesStatsResponse.getNodes().get(0).getDiscoveryStats();
    public void testRemoteCleanupTaskUpdated() {
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount, settings);
        List<IndexRoutingTable> indexRoutingTables = new ArrayList<>(getClusterState().routingTable().indicesRouting().values());
            cleanupManager.getLastCleanupAttemptStateVersion(),
            .get();
        String clusterManagerNode = internalCluster().getClusterManagerName();
    public void testRemoteCleanupWithBatchSizeAs20() throws Exception {
        int shardCount = randomIntBetween(1, 2);
                translogRepoPath,
        int shardCount = randomIntBetween(1, 2);
    }
        int expectedManifestsToBeDeleted = (batchSizePerDeletion - RETAINED_MANIFESTS) * maxBatchesToDelete;
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.RETAINED_MANIFESTS;
        int clusterManagerNodeCount = 1;
        // set cleanup interval to 100 ms to make the test faster
                assertTrue(extendedFields.containsKey(RemoteUploadStats.INDEX_ROUTING_FILES_CLEANUP_ATTEMPT_FAILED_COUNT));
            .prepareUpdateSettings()
        RemoteClusterStateCleanupManager cleanupManager = internalCluster().getClusterManagerNodeInstance(
import java.nio.charset.StandardCharsets;
            .stream()
            .sorted()
        assertBusy(() -> { assertFalse(cleanupManager.isDeleteStaleMetadataRunning().get()); });
            .prepareUpdateSettings()
    }
        // disable auto cleanup as the test will trigger the deletion manually
}
            .blobContainer(manifestContainerPath)
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true).build();
            .get();
                Base64.getUrlEncoder()
        assertTrue(response.isAcknowledged());
        assertEquals(1, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval().getMinutes());
        assertEquals(
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), "100ms"))
            .add("cluster-state")
        // disable the clean up to avoid race condition during shutdown
 * this file be licensed under the Apache-2.0 license or a
            ClusterUpdateSettingsResponse response = client().admin()
        BlobStoreRepository routingTableRepository = (BlobStoreRepository) repositoriesService.repository(REMOTE_ROUTING_TABLE_REPO);
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, REMOTE_ROUTING_TABLE_REPO)
        updateClusterStateNTimes(RETAINED_MANIFESTS + SKIP_CLEANUP_STATE_CHANGES + 1);
package org.opensearch.gateway.remote;
            .prepareUpdateSettings()
        client().admin()
            "Last 10 manifest files should remain the same after cleanup",
            .cluster()
 * SPDX-License-Identifier: Apache-2.0
    private static final String INDEX_NAME = "test-index";
        // update cluster state 21 times to ensure that clean up has run after this will upload 42 manifest files
                .prepareUpdateSettings()
            .get();
        }
        );
            initialCleanupAttemptVersion,
        );
import org.opensearch.common.settings.Settings;
import org.opensearch.test.OpenSearchIntegTestCase;
        BlobPath baseMetadataPath = getBaseMetadataPath(repository);
        // wait for completion
    public void testRemoteCleanupWithBatchSizeAs50() throws Exception {
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount, settingsBuilder.build());
    }
            .get();
            .keySet()
        assertBusy(() -> {
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
            assertTrue(response.isAcknowledged());
        performBatchedDeletionsGivenBatchSize(20);
        int clusterManagerNodeCount = 1;
        assertTrue(response.isAcknowledged());
        List<String> expectedListAfterDeletionAttempt = initialManifests.subList(0, initialManifests.size() - expectedManifestsToBeDeleted);
            .cluster()
import org.opensearch.index.remote.RemoteStorePathStrategy;
        List<String> last10Initial = initialManifests.subList(0, RETAINED_MANIFESTS);
                .get();
            .get();
        cleanupManager.cleanUpStaleFiles();
        BlobStoreRepository routingTableRepository,
import org.opensearch.cluster.routing.IndexRoutingTable;
    private BlobPath getIndexRoutingPath(BlobPath baseMetadataPath, String indexUUID) {
                    .encodeToString(getClusterState().getClusterName().value().getBytes(StandardCharsets.UTF_8))
        response = client().admin()
        long initialCleanupAttemptVersion = cleanupManager.getLastCleanupAttemptStateVersion();
        ClusterUpdateSettingsResponse response = client().admin()
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        RemoteClusterStateCleanupManager remoteClusterStateCleanupManager = internalCluster().getClusterManagerNodeInstance(
        assertBusy(() -> assertEquals(100, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval().getMillis()));
import java.util.List;
        );
            .toList();
        response = client().admin()
    private void initialTestSetup(int shardCount, int replicaCount, int dataNodeCount, int clusterManagerNodeCount, Settings settings) {
    public void testRemoteCleanupWithBatchSizeAs100() throws Exception {
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), "1m"))
        int dataNodeCount = shardCount * (replicaCount + 1);
        assertEquals(CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval());
        NodesStatsResponse nodesStatsResponse = client().admin()
        int dataNodeCount = shardCount * (replicaCount + 1);
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.SKIP_CLEANUP_STATE_CHANGES;
            .keySet()
            .cluster()
            RemoteClusterStateCleanupManager.class
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING.getKey(), maxBatchesToAttempt)
        // to repository, if manifest files are less than that it means clean up has run
                REPOSITORY_NAME,
        // disable the clean up to avoid race condition during shutdown
        clusterSettingsSuppliedByTest = true;
        );
        List<String> currentManifests = repository.blobStore()
            assertTrue(routingTableRepository.blobStore().blobContainer(indexRoutingPath).listBlobs().size() >= 3);
                    .get();
        int maxBatchesToDelete = 1;
                "Current number of manifest files: " + manifestFiles,
        Settings.Builder settingsBuilder = Settings.builder();
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
import java.util.Base64;
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
/*
    }
                long cleanupAttemptFailedCount = extendedFields.get(RemoteUploadStats.INDEX_ROUTING_FILES_CLEANUP_ATTEMPT_FAILED_COUNT)
        assertEquals("Last 10 manifest files should remain the same after cleanup", last10Initial, currentManifests);
    private BlobPath getBaseMetadataPath(BlobStoreRepository repository) {
                    .encodeToString(getClusterState().getClusterName().value().getBytes(StandardCharsets.UTF_8))
        List<String> initialManifests = repository.blobStore()
        int dataNodeCount = shardCount * (replicaCount + 1);
                remoteRoutingTableRepoPath,
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT;
        Path segmentRepoPath = randomRepoPath();
    public void testCleanupStopsAtMaxBatchesLimit() throws Exception {
        // now set Clean up interval to 1 min
import org.opensearch.common.blobstore.BlobPath;
        assertFalse(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isScheduled());
        )
        Path remoteRoutingTableRepoPath = randomRepoPath();
            // There would be >=3 files as shards will transition from UNASSIGNED -> INIT -> STARTED state
 * compatible open source license.
        int shardCount = randomIntBetween(1, 2);
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), batchSize)
        BlobPath indexRoutingPath = getIndexRoutingPath(baseMetadataPath, indexRoutingTables.get(0).getIndex().getUUID());
                .setPersistentSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), i, TimeUnit.SECONDS))
            expectedListAfterDeletionAttempt.size(),
            RemoteRoutingTableBlobStore.REMOTE_ROUTING_TABLE_PATH_TYPE_SETTING.getKey(),
            if (Objects.equals(persistedStateStats.getStatsName(), REMOTE_UPLOAD)) {
        assertTrue(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isScheduled());
            .add(
    }
 *
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);
import java.util.Map;
            )
            .setPersistentSettings(Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), "-1"))
            );
 * The OpenSearch Contributors require contributions made to
    }
            .add(
            .get();
        BlobPath indexRoutingPath,
        // now disable
            RemoteClusterStateCleanupManager.class
        long initialCleanupAttemptVersion = cleanupManager.getLastCleanupAttemptStateVersion();
            RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64
            .prepareUpdateSettings()
        int replicaCount = 1;
            .get();
        BlobPath baseMetadataPath = repository.basePath()
            RemoteClusterStateCleanupManager.class
                assertEquals(0, cleanupAttemptFailedCount);
        int shardCount = randomIntBetween(1, 2);
            // Retained manifests and Retained manifests + 2 * Skip cleanup state changes (each cluster state update uploads 2 manifests)
            .setPersistentSettings(
            .cluster()
        int batchSizePerDeletion = 30;
        // update cluster state 21 times to ensure that clean up has run after this will upload 42 manifest files
 */
        performBatchedDeletionsGivenBatchSize(50);
        assertEquals(
            .cluster()
    private Map<String, Long> initialTestSetup(int shardCount, int replicaCount, int dataNodeCount, int clusterManagerNodeCount) {
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING.getKey(), -1)
        // ensure we update the last successful cleanup attempt version once we update
        // trigger deletion
        ensureGreen(INDEX_NAME);
                Base64.getUrlEncoder()
            .blobContainer(manifestContainerPath)
        settingsBuilder.put(
                segmentRepoPath,
        assertBusy(() -> {
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
        );
        updateClusterStateNTimes(50);
                false
        );
            .listBlobsByPrefix("manifest")
        );
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);
        ClusterUpdateSettingsResponse response = client().admin()
        );
            .prepareUpdateSettings()
            .prepareNodesStats(clusterManagerNode)
            buildRemoteStoreNodeAttributes(
import java.util.stream.Collectors;
            RemoteStoreEnums.PathType.HASHED_PREFIX.toString()
            .keySet()
        ClusterUpdateSettingsResponse response = client().admin()
            )
        cleanupManager.cleanUpStaleFiles();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            currentManifests.subList(0, RETAINED_MANIFESTS)
            )
        updateClusterStateNTimes(RETAINED_MANIFESTS + SKIP_CLEANUP_STATE_CHANGES + 1);
            .cluster()
            .toList();
            .collect(Collectors.toList());
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING;
        BlobPath manifestContainerPath = getBaseMetadataPath(repository).add("manifest");
        // To ensure we complete the cleanup entirely
        // ensure cleanup is completed and successful
    }
        assertNotEquals(
        // set cleanup interval to 100 ms to make the test faster
        return repository.basePath()
            .addMetric(NodesStatsRequest.Metric.DISCOVERY.metricName())
                    .withoutPadding()
    }
    }
            .get();
        assertBusy(() -> { assertEquals(1, routingTableRepository.blobStore().blobContainer(indexRoutingPath).listBlobs().size()); });
                Settings.builder()
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
            last10Initial,
        );
            .collect(Collectors.toList());
            .sorted()
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
    private void verifyIndexRoutingFilesDeletion(
            .get();
            .blobContainer(manifestContainerPath)
            .setPersistentSettings(
            .prepareUpdateSettings()
        return indexStats;
            .cluster()
        assertTrue(response.isAcknowledged());
        BlobPath manifestContainerPath = baseMetadataPath.add("manifest");
            "Cleanup should have stopped after specified batch limit",
    }
    }
import org.junit.Before;
        assertEquals(-1, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval().getMillis());
        return pathType.path(
            .stream()
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING;
            .prepareUpdateSettings()
        int clusterManagerNodeCount = 1;
        asyncUploadMockFsRepo = false;
public class RemoteClusterStateCleanupManagerIT extends RemoteStoreBaseIntegTestCase {
            int manifestFiles = repository.blobStore().blobContainer(manifestContainerPath).listBlobsByPrefix("manifest").size();
import org.opensearch.cluster.coordination.PersistedStateStats;
        client().admin()
            initialCleanupAttemptVersion
        performBatchedDeletionsGivenBatchSize(100);
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
                    .withoutPadding()
    ) throws Exception {
        RemoteClusterStateCleanupManager remoteClusterStateCleanupManager = internalCluster().getClusterManagerNodeInstance(
        List<String> initialManifests = repository.blobStore()
        int replicaCount = 1;
        NodesStatsResponse nodesStatsResponse
    }
                    .put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), batchSizePerDeletion)
            RemoteClusterStateCleanupManager.class
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
    protected Settings nodeSettings(int nodeOrdinal) {
    }
