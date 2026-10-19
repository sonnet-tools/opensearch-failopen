            boolean pathFound = false;
        );  
            // At-least 3 new index routing files will be created as shards will transition from INIT -> UNASSIGNED -> STARTED state  
 * compatible open source license.
        ensureGreen(INDEX_NAME);  
    @Override
            .get();  
        assertTrue(areRoutingTablesSame(routingTableVersions));
            totalRoutingFiles += repository.blobStore().blobContainer(path).listBlobs().size();  
        routingTableVersions = getRoutingTableFromAllNodes();  
            .setSettings(Settings.builder().put(settingKey, settingValue))
    private void verifyUpdatesInManifestFile(
        }
        List<String> deletedIndexNames = new ArrayList<>();
        return repository;  
        for (IndexRoutingTable indexRoutingTable : indexRoutingTables) {
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);
        );
        );
            getClusterState().getClusterName().value(),
import java.nio.charset.StandardCharsets;  
        List<String> expectedIndexNames = new ArrayList<>();  
        Set<String> dataNodes = internalCluster().getDataNodeNames();
        assertEquals(3, internalCluster().clusterService().state().nodes().getDataNodes().size());
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, false);
        prepareCluster(1, 3, INDEX_NAME, 1, 5, settings);
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REMOTE_ROUTING_TABLE_REPO);
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
        assertTrue(areRoutingTablesSame(routingTables));
        // Verify routing table across all nodes is equal  
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);  
    private void deleteIndexAndVerify(RemoteManifestManager remoteManifestManager) {  
                .admin()  
        List<RoutingTable> routingTables = new ArrayList<>();  
            .build();
        // ensure restarted node joins and the cluster is stable
        ensureGreen();
            .put(super.nodeSettings(nodeOrdinal))
            assertTrue(indexRoutingFilesAfterNodeDrop > indexRoutingFiles.get());
        );
        for (IndexRoutingTable indexRoutingTable : indexRoutingTables) {
        }
                .getState()
        List<RoutingTable> routingTableVersions = getRoutingTableFromAllNodes();
    private List<RoutingTable> getRoutingTableFromAllNodes() throws ExecutionException, InterruptedException {
                .routingTable();
        ClusterUpdateSettingsResponse response = client().admin()
        if (a == b) return true;  
            // There would be >=3 files as shards will transition from UNASSIGNED -> INIT -> STARTED state
        assertEquals(isRoutingTableDiffFileExpected, manifest.getDiffManifest().getIndicesRoutingDiffPath() != null);
    }
        assertTrue(latestManifest.isPresent());
            int indexRoutingFilesAfterNodeDrop = repository.blobStore().blobContainer(indexRoutingPaths.get(0)).listBlobs().size();  
        assertEquals(routingTables.get(0).getIndicesRouting().keySet(), expectedIndicesInRoutingTable);
        ensureStableCluster(4);
            .execute()
        client().admin().indices().prepareDelete(INDEX_NAME).execute().actionGet();
            getClusterState().getMetadata().clusterUUID()
        assertTrue(response.isAcknowledged());
        // Check if all paths in manifest.getIndicesRouting() are present in indexRoutingPaths
    private static final String INDEX_NAME_1 = "test-index-1";  
            )  
import java.util.concurrent.TimeUnit;  
        );  
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_TABLE;
        assertTrue(areRoutingTablesSame(routingTableVersions));
import static org.opensearch.indices.IndicesService.CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING;  
        List<String> deletedIndexNames = new ArrayList<>();
            RemoteClusterStateService.class
    private static final String INDEX_NAME = "test-index";
                    .encodeToString(getClusterState().getClusterName().value().getBytes(StandardCharsets.UTF_8))
        return totalRoutingFiles;
        if (a.version() != b.version()) return false;
        ensureStableCluster(4);  
                return false;
        // Verify indices in routing table  
    }  
        ensureGreen(INDEX_NAME);
        expectedIndicesInRoutingTable = Set.of(INDEX_NAME, INDEX_NAME_1);
        RemoteStoreEnums.PathHashAlgorithm pathHashAlgo = RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;  
        // Verify indices in routing table  
            IndexRoutingTable thatIndexRoutingTable = b.indicesRouting().get(entry.getKey());
        // ensure master is elected and the cluster is stable  
    private boolean areRoutingTablesSame(List<RoutingTable> routingTables) {
        asyncUploadMockFsRepo = false;
        String clusterManagerName = internalCluster().getClusterManagerName();
        List<String> expectedIndexNames = new ArrayList<>();
            .actionGet();  
                if (uploadedFilename.getUploadedFilename().contains(indexRoutingPath.buildAsString())) {  
import org.opensearch.gateway.remote.model.RemoteRoutingTableBlobStore;
            assertTrue(indexRoutingFilesAfterNodeDrop > indexRoutingFiles.get());
 * SPDX-License-Identifier: Apache-2.0
        int expectedIndicesRoutingFilesInManifest,
                .state(new ClusterStateRequest().local(true))
            .prepareUpdateSettings(indexName)  
            RemoteClusterStateService.class
        Path translogRepoPath = randomRepoPath();
    private void updateIndexSettings(String indexName, String settingKey, int settingValue) {  
        // Verify routing table across all nodes is equal  
                    .withoutPadding()
        }
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen(INDEX_NAME);
        routingTableVersions = getRoutingTableFromAllNodes();
            translogRepoPath,
        List<String> deletedIndexNames = new ArrayList<>();
            false
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();
        assertTrue(areRoutingTablesSame(routingTableVersions));
    }  
            REMOTE_ROUTING_TABLE_REPO,  
        internalCluster().restartNode(clusterManagerName);
import org.junit.Before;  
        List<String> deletedIndexNames = new ArrayList<>();
        assertTrue(manifest.getDiffManifest().getIndicesDeleted().contains(INDEX_NAME));
            int indexRoutingFilesAfterNodeDrop = repository.blobStore().blobContainer(indexRoutingPaths.get(0)).listBlobs().size();
import org.opensearch.common.settings.Settings;
        Set<String> expectedIndicesInRoutingTable = Set.of(INDEX_NAME);
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
    public void testRemoteRoutingTableIndexNodeRestart() throws Exception {
    }
        BlobPath baseMetadataPath = getBaseMetadataPath(repository);  
            getClusterState().getClusterName().value(),
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        return true;
        ClusterMetadataManifest manifest = latestManifest.get();  
    private BlobStoreRepository prepareClusterAndVerifyRepository() throws Exception {
        client().admin()
            if (!compareRoutingTables(firstRoutingTable, routingTable)) {  
        );
        );
        Path segmentRepoPath = randomRepoPath();
        assertRemoteStoreRepositoryOnAllNodes(REMOTE_ROUTING_TABLE_REPO);  
    public void testRemoteRoutingTableIndexLifecycle() throws Exception {
        routingTableVersions = getRoutingTableFromAllNodes();
        assertEquals(expectedIndicesRoutingFilesInManifest, manifest.getIndicesRouting().size());  
 * The OpenSearch Contributors require contributions made to  
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);  
                RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;
    }  
            int indexRoutingFilesAfterUpdate = repository.blobStore().blobContainer(indexRoutingPaths.get(0)).listBlobs().size();
import org.opensearch.test.OpenSearchIntegTestCase;
            getClusterState().getClusterName().value(),
        return true;  
        List<RoutingTable> routingTableVersions = getRoutingTableFromAllNodes();
        return Settings.builder()  
        assertTrue(areRoutingTablesSame(routingTableVersions));
                    break;
        });  
            segmentRepoPath,  
 *
            routingTables.add(routingTable);  
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();
    private BlobPath getBaseMetadataPath(BlobStoreRepository repository) {  
        // Update cluster settings
        ensureGreen(INDEX_NAME_1);
import org.opensearch.repositories.RepositoriesService;  
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
    private BlobPath getIndexRoutingPath(BlobPath indexRoutingPath, String indexUUID) {
    }
        List<RoutingTable> routingTableVersions = getRoutingTableFromAllNodes();
            )  
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
    List<BlobPath> indexRoutingPaths;
                Base64.getUrlEncoder()  
        List<RoutingTable> routingTableVersions = getRoutingTableFromAllNodes();  
            IndexRoutingTable thisIndexRoutingTable = entry.getValue();  
        assertBusy(() -> {
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;  
    }
        assertRemoteStoreRepositoryOnAllNodes(REMOTE_ROUTING_TABLE_REPO);
        indexRoutingPaths.clear(); // Clear the list to avoid stale data  
        );  
import org.opensearch.index.remote.RemoteStorePathStrategy;
            REPOSITORY_2_NAME,
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();  
            for (BlobPath indexRoutingPath : indexRoutingPaths) {
        assertTrue(areRoutingTablesSame(routingTables));
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);
            .add(getClusterState().metadata().clusterUUID());
        assertTrue(areRoutingTablesSame(routingTableVersions));
import java.util.Optional;  
        }  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        assertNotNull(internalCluster().clusterService().state().nodes().getClusterManagerNode());
        // Delete the index and assert its deletion
        Optional<ClusterMetadataManifest> latestManifest,
        String[] allNodes = internalCluster().getNodeNames();
        assertEquals(expectedDeletedIndex, manifest.getDiffManifest().getIndicesDeleted());
        }
        if (routingTables == null || routingTables.isEmpty()) {  
        // Verify index is marked deleted in manifest
        );
        int totalRoutingFiles = 0;
                RemoteRoutingTableBlobStore.REMOTE_ROUTING_TABLE_PATH_TYPE_SETTING.getKey(),
        ClusterMetadataManifest manifest = latestManifest.get();
        List<String> expectedDeletedIndex,
            getClusterState().getMetadata().clusterUUID()  
            .indices()
        indexRoutingPaths = new ArrayList<>();  
        for (ClusterMetadataManifest.UploadedIndexMetadata uploadedFilename : manifest.getIndicesRouting()) {  
            getClusterState().getClusterName().value(),  
        List<String> expectedIndexNames = new ArrayList<>();
    ) {
            .prepareUpdateSettings()
        );  
        // Create new index  
        assertBusy(() -> {
    protected Settings nodeSettings(int nodeOrdinal) {
                logger.info("Responses are not the same: {} {}", firstRoutingTable, routingTable);
                return false;  
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
            getClusterState().getMetadata().clusterUUID()  
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
        boolean isRoutingTableDiffFileExpected  
        clusterSettingsSuppliedByTest = true;  
import java.util.Base64;  
        updateIndexSettings(INDEX_NAME, IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2);
        assertTrue(areRoutingTablesSame(routingTableVersions));
    }
            .setPersistentSettings(Settings.builder().put(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.getKey(), 0, TimeUnit.SECONDS))
            }
    public void testRemoteRoutingTableIndexMasterRestart() throws Exception {  
        // Update index settings
    }
    public void testRemoteRoutingTableEmptyRoutingTableDiff() throws Exception {
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
            .add(
import org.opensearch.common.blobstore.BlobPath;  
            .cluster()  
        for (String node : allNodes) {
        // Ensure node comes healthy after restart  
            RoutingTable routingTable = internalCluster().client(node)
            RemoteClusterStateService.class  
    }
        );  
import org.opensearch.cluster.metadata.IndexMetadata;  
        for (BlobPath path : indexRoutingPaths) {
        assertTrue(latestManifest.isPresent());  
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        assertEquals(routingTables.get(0).getIndicesRouting().keySet(), expectedIndicesInRoutingTable);
        List<String> expectedIndexNames = new ArrayList<>();  
        }
                    pathFound = true;
        // Ensure node comes healthy after restart
        for (Map.Entry<String, IndexRoutingTable> entry : a.indicesRouting().entrySet()) {
    private void updateIndexRoutingPaths(BlobStoreRepository repository) {
                .get()  
            getClusterState().getClusterName().value(),  
                }  
        latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        List<String> expectedIndexNames = new ArrayList<>();  
                RemoteClusterStateService.REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING.getKey(),
        return pathType.path(
package org.opensearch.gateway.remote;
        latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        List<IndexRoutingTable> indexRoutingTables = new ArrayList<>(getClusterState().routingTable().indicesRouting().values());
        BlobStoreRepository repository = prepareClusterAndVerifyRepository();
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
            getClusterState().getMetadata().clusterUUID()
        Path remoteRoutingTableRepoPath = randomRepoPath();  
            assertTrue(indexRoutingFilesAfterUpdate >= indexRoutingFiles.get() + 3);
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
import java.util.Set;
            .put(  
        assertTrue(areRoutingTablesSame(routingTableVersions));
        });
    }
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(  
        Settings settings = buildRemoteStoreNodeAttributes(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            remoteRoutingTableRepoPath,
        internalCluster().restartNode(randomFrom(dataNodes));  
        return routingTables;
    public void testRemoteRoutingTableWithMultipleIndex() throws Exception {
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 2, deletedIndexNames, true);
            }  
        );  
        prepareClusterAndVerifyRepository();
import java.util.List;
import java.util.Map;
            RemoteClusterStateService.class  
    private boolean compareRoutingTables(RoutingTable a, RoutingTable b) {
        ensureGreen();  
    AtomicInteger indexRoutingFiles = new AtomicInteger();
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(  
            assertTrue(indexRoutingFiles.get() >= 3);  
    }
    private final RemoteStoreEnums.PathType pathType = RemoteStoreEnums.PathType.HASHED_PREFIX;  
            indexRoutingPaths.add(getIndexRoutingPath(baseMetadataPath.add(INDEX_ROUTING_TABLE), indexRoutingTable.getIndex().getUUID()));
        List<String> deletedIndexNames = new ArrayList<>();
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        verifyUpdatesInManifestFile(latestManifest, expectedIndexNames, 1, deletedIndexNames, true);
        assertFalse(client().admin().indices().prepareExists(INDEX_NAME).get().isExists());
            RemoteStorePathStrategy.PathInput.builder().basePath(indexRoutingPath).indexUUID(indexUUID).build(),
    @Before
        );
import java.io.IOException;
        List<IndexRoutingTable> indexRoutingTables = new ArrayList<>(getClusterState().routingTable().indicesRouting().values());
            )  
        Optional<ClusterMetadataManifest> latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(
        );
        }  
        List<String> expectedIndexNames,  
        latestManifest = remoteManifestManager.getLatestClusterMetadataManifest(  
    public void setup() {  
            getClusterState().getMetadata().clusterUUID()
        BlobPath baseMetadataPath = getBaseMetadataPath(repository);
import java.util.concurrent.atomic.AtomicInteger;
public class RemoteRoutingTableServiceIT extends RemoteStoreBaseIntegTestCase {
        RemoteClusterStateService remoteClusterStateService = internalCluster().getClusterManagerNodeInstance(
    private int calculateTotalRoutingFiles(BlobStoreRepository repository) throws IOException {  
            getClusterState().getClusterName().value(),  
        });
    }  
}  
            getClusterState().getMetadata().clusterUUID()
            pathHashAlgo  
            getClusterState().getClusterName().value(),  
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, REMOTE_ROUTING_TABLE_REPO)
            getClusterState().getClusterName().value(),
        assertRemoteStoreRepositoryOnAllNodes(REMOTE_ROUTING_TABLE_REPO);
    }
            assertTrue("Uploaded file not found in indexRoutingPaths: " + uploadedFilename.getUploadedFilename(), pathFound);
            return false;
import org.opensearch.index.remote.RemoteStoreEnums;  
import java.util.ArrayList;
        }  
        deleteIndexAndVerify(remoteManifestManager);
            .put(REMOTE_PUBLICATION_SETTING_KEY, true)
import org.opensearch.cluster.routing.IndexRoutingTable;
            indexRoutingFiles.set(totalRoutingFiles);
    }
            .add("cluster-state")
            REPOSITORY_NAME,
        assertBusy(() -> {  
            if (!thatIndexRoutingTable.equals(thatIndexRoutingTable)) {
        List<RoutingTable> routingTables = getRoutingTableFromAllNodes();
        );
            .put(  
 */  
        for (RoutingTable routingTable : routingTables) {
            getClusterState().getMetadata().clusterUUID()
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
        ensureGreen(INDEX_NAME);
        RoutingTable firstRoutingTable = routingTables.get(0);
/*  
            getClusterState().getMetadata().clusterUUID()
        createIndex(INDEX_NAME_1, remoteStoreIndexSettings(1, 5));
import org.opensearch.cluster.routing.RoutingTable;
            RemoteClusterStateService.class
        if (a.indicesRouting().size() != b.indicesRouting().size()) return false;  
        assertTrue(manifest.getIndicesRouting().isEmpty());  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
                RemoteStoreEnums.PathType.HASHED_PREFIX.toString()
import java.util.concurrent.ExecutionException;
import java.nio.file.Path;
            int totalRoutingFiles = calculateTotalRoutingFiles(repository);  
        if (b == null || a.getClass() != b.getClass()) return false;
                .cluster()
        return repository.basePath()
            indexRoutingPaths.add(getIndexRoutingPath(baseMetadataPath.add(INDEX_ROUTING_TABLE), indexRoutingTable.getIndex().getUUID()));
        RemoteManifestManager remoteManifestManager = remoteClusterStateService.getRemoteManifestManager();
        );  
            getClusterState().getMetadata().clusterUUID()
            }
        routingTables = getRoutingTableFromAllNodes();
    }  
        assertBusy(() -> {
            getClusterState().getClusterName().value(),
        updateIndexRoutingPaths(repository);  
        });
    }
    }  
