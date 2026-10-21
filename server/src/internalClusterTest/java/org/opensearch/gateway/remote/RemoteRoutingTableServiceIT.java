    }
                .get()
        return true;
/*
            getClusterState().getClusterName().value(),
        updateIndexSettings(INDEX_NAME, IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2);
        return repository.basePath()
            RoutingTable routingTable = internalCluster().client(node)
        for (ClusterMetadataManifest.UploadedIndexMetadata uploadedFilename : manifest.getIndicesRouting()) {
            int indexRoutingFilesAfterNodeDrop = repository.blobStore().blobContainer(indexRoutingPaths.get(0)).listBlobs().size();
import org.junit.Before;
    private int calculateTotalRoutingFiles(BlobStoreRepository repository) throws IOException {
import java.nio.file.Path;
        assertTrue(areRoutingTablesSame(routingTables));
            .add(
        assertEquals(3, internalCluster().clusterService().state().nodes().getDataNodes().size());
        // ensure restarted node joins and the cluster is stable
            getClusterState().getMetadata().clusterUUID()
        }
        assertBusy(() -> {
        );
        indexRoutingPaths.clear(); // Clear the list to avoid stale data
        internalCluster().restartNode(randomFrom(dataNodes));
        List<String> deletedIndexNames = new ArrayList<>();
            getClusterState().getMetadata().clusterUUID()
        ClusterMetadataManifest manifest = latestManifest.get();
            .put(REMOTE_PUBLICATION_SETTING_KEY, true)
        List<String> expectedIndexNames,
    private static final String INDEX_NAME_1 = "test-index-1";
            indexRoutingPaths.add(getIndexRoutingPath(baseMetadataPath.add(INDEX_ROUTING_TABLE), indexRoutingTable.getIndex().getUUID()));
import org.opensearch.common.settings.Settings;
            int totalRoutingFiles = calculateTotalRoutingFiles(repository);
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        assertTrue(areRoutingTablesSame(routingTables));
    @Before
    public void setup() {
        expectedIndicesInRoutingTable = Set.of(INDEX_NAME, INDEX_NAME_1);
            getClusterState().getClusterName().value(),
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
public class RemoteRoutingTableServiceIT extends RemoteStoreBaseIntegTestCase {
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
        );
            .add("cluster-state")
import java.util.concurrent.TimeUnit;
            int indexRoutingFilesAfterNodeDrop = repository.blobStore().blobContainer(indexRoutingPaths.get(0)).listBlobs().size();
        // Create new index
        List<String> expectedDeletedIndex,
        for (IndexRoutingTable indexRoutingTable : indexRoutingTables) {
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                .cluster()
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        Path segmentRepoPath = randomRepoPath();
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, false);
    }
        List<String> expectedIndexNames = new ArrayList<>();
        ensureStableCluster(4);
    }
        internalCluster().restartNode(clusterManagerName);
        return pathType.path(
        assertTrue(areRoutingTablesSame(routingTableVersions));
        List<String> expectedIndexNames = new ArrayList<>();
        for (RoutingTable routingTable : routingTables) {
        List<String> deletedIndexNames = new ArrayList<>();
        }
            int indexRoutingFilesAfterUpdate = repository.blobStore().blobContainer(indexRoutingPaths.get(0)).listBlobs().size();
            }
            REPOSITORY_2_NAME,
            getClusterState().getMetadata().clusterUUID()
        // Delete the index and assert its deletion
        }
        routingTableVersions = getRoutingTableFromAllNodes();
            for (BlobPath indexRoutingPath : indexRoutingPaths) {
    }
        assertTrue(latestManifest.isPresent());
        Path translogRepoPath = randomRepoPath();
        // Ensure node comes healthy after restart
                    .withoutPadding()
            assertTrue("Uploaded file not found in indexRoutingPaths: " + uploadedFilename.getUploadedFilename(), pathFound);
    private BlobPath getBaseMetadataPath(BlobStoreRepository repository) {
                Base64.getUrlEncoder()
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
    private static final String INDEX_NAME = "test-index";
                    .encodeToString(getClusterState().getClusterName().value().getBytes(StandardCharsets.UTF_8))
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);
        int totalRoutingFiles = 0;
        List<RoutingTable> routingTables = getRoutingTableFromAllNodes();
        latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();
            .put(
        prepareClusterAndVerifyRepository();
        Set<String> dataNodes = internalCluster().getDataNodeNames();
        createIndex(INDEX_NAME_1, remoteStoreIndexSettings(1, 5));
        );
        Path remoteRoutingTableRepoPath = randomRepoPath();
            IndexRoutingTable thisIndexRoutingTable = entry.getValue();
    }
 */
        assertRemoteStoreRepositoryOnAllNodes(REMOTE_ROUTING_TABLE_REPO);
            getClusterState().getClusterName().value(),
            boolean pathFound = false;
        deleteIndexAndVerify(remoteManifestManager);
    public void testRemoteRoutingTableWithMultipleIndex() throws Exception {
        );
            RemoteClusterStateService.class
        );
        );
        if (a.indicesRouting().size() != b.indicesRouting().size()) return false;
import org.opensearch.index.remote.RemoteStoreEnums;
    @Override
            getClusterState().getMetadata().clusterUUID()
        );
            .actionGet();
    private boolean compareRoutingTables(RoutingTable a, RoutingTable b) {
        RoutingTable firstRoutingTable = routingTables.get(0);
        }
    private BlobPath getIndexRoutingPath(BlobPath indexRoutingPath, String indexUUID) {
    }
        String[] allNodes = internalCluster().getNodeNames();
        );
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
            pathHashAlgo
                .routingTable();
        assertEquals(routingTables.get(0).getIndicesRouting().keySet(), expectedIndicesInRoutingTable);
            REPOSITORY_NAME,
        assertBusy(() -> {
        BlobPath baseMetadataPath = getBaseMetadataPath(repository);
                    pathFound = true;
            getClusterState().getMetadata().clusterUUID()
    private void updateIndexSettings(String indexName, String settingKey, int settingValue) {
        return repository;
            return false;
                return false;
import java.util.Map;
            }
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
        ensureGreen(INDEX_NAME);
        client().admin()
        List<RoutingTable> routingTableVersions = getRoutingTableFromAllNodes();
        List<String> expectedIndexNames = new ArrayList<>();
        ensureStableCluster(4);
        List<String> deletedIndexNames = new ArrayList<>();
        latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        assertTrue(areRoutingTablesSame(routingTableVersions));
        });
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.cluster.metadata.IndexMetadata;
        client().admin().indices().prepareDelete(INDEX_NAME).execute().actionGet();
    }
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);
        );
            getClusterState().getMetadata().clusterUUID()
            .prepareUpdateSettings()
        List<RoutingTable> routingTableVersions = getRoutingTableFromAllNodes();
    }
            getClusterState().getMetadata().clusterUUID()
import org.opensearch.repositories.RepositoriesService;
 * compatible open source license.
import java.util.Optional;
            indexRoutingPaths.add(getIndexRoutingPath(baseMetadataPath.add(INDEX_ROUTING_TABLE), indexRoutingTable.getIndex().getUUID()));
    }
        assertTrue(areRoutingTablesSame(routingTableVersions));
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
        if (b == null || a.getClass() != b.getClass()) return false;
        List<String> expectedIndexNames = new ArrayList<>();
        assertRemoteStoreRepositoryOnAllNodes(REMOTE_ROUTING_TABLE_REPO);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        // Verify routing table across all nodes is equal
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
        }
                return false;
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
            RemoteClusterStateService.class
    public void testRemoteRoutingTableIndexMasterRestart() throws Exception {
        Set<String> expectedIndicesInRoutingTable = Set.of(INDEX_NAME);
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
        // Ensure node comes healthy after restart
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_TABLE;
            RemoteStorePathStrategy.PathInput.builder().basePath(indexRoutingPath).indexUUID(indexUUID).build(),
        ensureGreen(INDEX_NAME);
        latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
            REMOTE_ROUTING_TABLE_REPO,
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING;
        assertBusy(() -> {
        for (String node : allNodes) {
        );
import java.util.concurrent.ExecutionException;
    }
            .prepareUpdateSettings(indexName)
        ensureGreen(INDEX_NAME);
    private BlobStoreRepository prepareClusterAndVerifyRepository() throws Exception {
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;
        asyncUploadMockFsRepo = false;
            .put(
            RemoteClusterStateService.class
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 2, deletedIndexNames, true);
        routingTables = getRoutingTableFromAllNodes();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
 * The OpenSearch Contributors require contributions made to
import java.util.Set;
                logger.info("Responses are not the same: {} {}", firstRoutingTable, routingTable);
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
        List<String> expectedIndexNames = new ArrayList<>();
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();
    }
        assertRemoteStoreRepositoryOnAllNodes(REMOTE_ROUTING_TABLE_REPO);
            totalRoutingFiles += repository.blobStore().blobContainer(path).listBlobs().size();
            routingTables.add(routingTable);
        for (IndexRoutingTable indexRoutingTable : indexRoutingTables) {
        // Verify routing table across all nodes is equal
        });
        List<String> deletedIndexNames = new ArrayList<>();
 *
import java.nio.charset.StandardCharsets;
    private boolean areRoutingTablesSame(List<RoutingTable> routingTables) {
        if (routingTables == null || routingTables.isEmpty()) {
        assertTrue(areRoutingTablesSame(routingTableVersions));
                RemoteStoreEnums.PathType.HASHED_PREFIX.toString()
    List<BlobPath> indexRoutingPaths;
        );
        // Verify indices in routing table
import org.opensearch.common.blobstore.BlobPath;
            getClusterState().getClusterName().value(),
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
            getClusterState().getMetadata().clusterUUID()
        ensureGreen();
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
import org.opensearch.gateway.remote.model.RemoteRoutingTableBlobStore;
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
    }
        // Verify indices in routing table
import java.util.concurrent.atomic.AtomicInteger;
        assertTrue(manifest.getIndicesRouting().isEmpty());
        );
import org.opensearch.test.OpenSearchIntegTestCase;
                if (uploadedFilename.getUploadedFilename().contains(indexRoutingPath.buildAsString())) {
        BlobPath baseMetadataPath = getBaseMetadataPath(repository);
    private void updateIndexRoutingPaths(BlobStoreRepository repository) {
                    break;
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, REMOTE_ROUTING_TABLE_REPO)
        String clusterManagerName = internalCluster().getClusterManagerName();
        List<RoutingTable> routingTableVersions = getRoutingTableFromAllNodes();
package org.opensearch.gateway.remote;
        routingTableVersions = getRoutingTableFromAllNodes();
                }
                .getState()
    private final RemoteStoreEnums.PathType pathType = RemoteStoreEnums.PathType.HASHED_PREFIX;
            .cluster()
            indexRoutingFiles.set(totalRoutingFiles);
import java.util.ArrayList;
    }
            .setSettings(Settings.builder().put(settingKey, settingValue))
            getClusterState().getClusterName().value(),
        Optional<ClusterMetadataManifest> latestManifest,
            remoteRoutingTableRepoPath,
                .state(new ClusterStateRequest().local(true))
        });
        for (BlobPath path : indexRoutingPaths) {
        // Verify index is marked deleted in manifest
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();
    private void verifyUpdatesInManifestFile(
        routingTableVersions = getRoutingTableFromAllNodes();
import org.opensearch.cluster.routing.RoutingTable;
        List<IndexRoutingTable> indexRoutingTables = new ArrayList<>(getClusterState().routingTable().indicesRouting().values());
        );
        );
    ) {
    }
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();
            if (!compareRoutingTables(firstRoutingTable, routingTable)) {
        return routingTables;
        Settings settings = buildRemoteStoreNodeAttributes(
            IndexRoutingTable thatIndexRoutingTable = b.indicesRouting().get(entry.getKey());
        ensureGreen(INDEX_NAME);
        boolean isRoutingTableDiffFileExpected
            getClusterState().getClusterName().value(),
            translogRepoPath,
 * SPDX-License-Identifier: Apache-2.0
                RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE
        indexRoutingPaths = new ArrayList<>();
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
            .setPersistentSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), 0, TimeUnit.SECONDS))
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REMOTE_ROUTING_TABLE_REPO);
    public void testRemoteRoutingTableEmptyRoutingTableDiff() throws Exception {
        if (a.version() != b.version()) return false;
            segmentRepoPath,
            getClusterState().getClusterName().value(),
        updateIndexRoutingPaths(repository);
        assertFalse(client().admin().indices().prepareExists(INDEX_NAME).get().isExists());
            assertTrue(indexRoutingFilesAfterNodeDrop > indexRoutingFiles.get());
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        // Check if all paths in manifest.getIndicesRouting() are present in indexRoutingPaths
        List<String> deletedIndexNames = new ArrayList<>();
import java.util.List;
            .indices()
            getClusterState().getMetadata().clusterUUID()
        }
}
        RemoteStoreEnums.PathHashAlgorithm pathHashAlgo = RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;
        List<IndexRoutingTable> indexRoutingTables = new ArrayList<>(getClusterState().routingTable().indicesRouting().values());
            .execute()
                .admin()
 * this file be licensed under the Apache-2.0 license or a
        );
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        prepareCluster(1, 3, INDEX_NAME, 1, 5, settings);
            assertTrue(indexRoutingFilesAfterNodeDrop > indexRoutingFiles.get());
        assertEquals(routingTables.get(0).getIndicesRouting().keySet(), expectedIndicesInRoutingTable);
        assertEquals(isRoutingTableDiffFileExpected, manifest.getDiffManifest().getIndicesRoutingDiffPath() != null);
    }
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        assertEquals(expectedIndicesRoutingFilesInManifest, manifest.getIndicesRouting().size());
            .add(getClusterState().metadata().clusterUUID());
        ensureGreen(INDEX_NAME_1);
        for (Map.Entry<String, IndexRoutingTable> entry : a.indicesRouting().entrySet()) {
            }
                RemoteRoutingTableBlobStore.REMOTE_ROUTING_TABLE_PATH_TYPE_SETTING.getKey(),
            // There would be >=3 files as shards will transition from UNASSIGNED -> INIT -> STARTED state
            )
            .get();
            .build();
            RemoteClusterStateService.class
        return totalRoutingFiles;
        assertEquals(expectedDeletedIndex, manifest.getDiffManifest().getIndicesDeleted());
        ClusterMetadataManifest manifest = latestManifest.get();
        assertTrue(areRoutingTablesSame(routingTableVersions));
        }
import java.util.Base64;
        );
        assertTrue(response.isAcknowledged());
            assertTrue(indexRoutingFilesAfterUpdate >= indexRoutingFiles.get() + 3);
        ensureGreen();
    }
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
            false
            )
            RemoteClusterStateService.class
import org.opensearch.cluster.routing.IndexRoutingTable;
        assertTrue(manifest.getDiffManifest().getIndicesDeleted().contains(INDEX_NAME));
            if (!thatIndexRoutingTable.equals(thatIndexRoutingTable)) {
            assertTrue(indexRoutingFiles.get() >= 3);
    public void testRemoteRoutingTableIndexLifecycle() throws Exception {
        List<RoutingTable> routingTableVersions = getRoutingTableFromAllNodes();
        int expectedIndicesRoutingFilesInManifest,
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);
        clusterSettingsSuppliedByTest = true;
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);
            // At-least 3 new index routing files will be created as shards will transition from INIT -> UNASSIGNED -> STARTED state
    private void deleteIndexAndVerify(RemoteManifestManager remoteManifestManager) {
            getClusterState().getClusterName().value(),
    }
        assertTrue(areRoutingTablesSame(routingTableVersions));
        // Update index settings
        // Update cluster settings
    AtomicInteger indexRoutingFiles = new AtomicInteger();
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
        assertBusy(() -> {
import org.opensearch.index.remote.RemoteStorePathStrategy;
import java.io.IOException;
        assertTrue(areRoutingTablesSame(routingTableVersions));
        }
        return true;
            )
    public void testRemoteRoutingTableIndexNodeRestart() throws Exception {
        if (a == b) return true;
        assertNotNull(internalCluster().clusterService().state().nodes().getClusterManagerNode());
        });
    }
        ClusterUpdateSettingsResponse response = client().admin()
            getClusterState().getClusterName().value(),
        assertTrue(latestManifest.isPresent());
        List<RoutingTable> routingTables = new ArrayList<>();
        return Settings.builder()
        // ensure master is elected and the cluster is stable
                RemoteClusterStateService.REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING.getKey(),
    private List<RoutingTable> getRoutingTableFromAllNodes() throws ExecutionException, InterruptedException {
