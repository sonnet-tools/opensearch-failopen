import org.opensearch.cluster.metadata.ComponentTemplate;
        Map<String, Long> indexStats2 = indexData(1, false, secondIndexName);
        assertThrows(IOError.class, () -> internalCluster().client());  
        assertThrows(
        // This should fail with IllegalStateException as cluster manager fails to form without any initial seed  
                // AssertionError helps us use assertBusy and retry validation if failed due to a race condition.  
                return Settings.builder()
    protected Settings nodeSettings(int nodeOrdinal) {  
            throw new RuntimeException(e);
    private static void putIndexTemplate() {  
        assertNotNull(clusterService().state().metadata().custom("component_template"));
        assertEquals(true, SETTING_READ_ONLY_SETTING.get(clusterService().state().metadata().settings()));
            RemoteClusterStateService remoteClusterStateService = internalCluster().getInstance(  
    }
            assertEquals(clusterState.version(), manifest.getStateVersion());
import org.opensearch.common.action.ActionFuture;
import java.nio.file.Path;
        validateCurrentMetadata();  
        int clusterManagerNodeCount = 3;
                IndexMetadata currentIndexMetadata = currentMetadata.index(uploadedIndexMetadata.getIndexName());
        );
        int replicaCount = 1;  
     * 4. Restart the cluster manager node with correct seeding.
                .put("index.number_of_replicas", 1)  
        assertAcked(client().admin().cluster().updateSettings(resetRequest).get());
        internalCluster().stopAllNodes();
        ensureRed(indexName);
    public void testFullClusterRestore() throws Exception {
import java.util.Collections;
    private Map<String, Long> initialTestSetup(int shardCount, int replicaCount, int dataNodeCount, int clusterManagerNodeCount) {
        assertEquals(  
                RemoteClusterStateService.class,
        assertTrue(INDEX_READ_ONLY_SETTING.get(clusterService().state().metadata().index(secondIndexName).getSettings()));  
            Settings.builder() // <1>
    private void resetCluster(int dataNodeCount, int clusterManagerNodeCount) {  
import static org.opensearch.indices.ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE;  
        resetRequest.persistentSettings(settings);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 * this file be licensed under the Apache-2.0 license or a
        int replicaCount = 1;  
                .put("compress", false)
     * 7. Metadata loaded from local disk state will be overridden with remote Metadata and no conflict should arise.
    @Before  
            Locale.ROOT,  
import org.opensearch.cluster.ClusterState;  
        assertFalse(composableIndexTemplate.indexTemplates().isEmpty());
        // start a cluster manager node with no cluster manager seeding.
        });  
            Settings.builder() // <1>
        );
    }
        assertTrue(response.get().isAcknowledged());  
                manifest = remoteClusterStateService.getLatestClusterMetadataManifest(
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;
        updatePersistentSettings(Settings.builder().put(SETTING_READ_ONLY_SETTING.getKey(), true).build());
import java.util.List;
    private void verifyRestoredRepositories(Path repoPath) {  
        int shardCount = randomIntBetween(1, 2);
        validateCurrentMetadata();  
            newClusterStateVersion
        );  
            RemoteClusterStateService.class,
        ensureGreen(INDEX_NAME);
                    new Template(Settings.EMPTY, null, Collections.emptyMap()),
            );
        // stop all nodes
        int clusterManagerNodeCount = 1;  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
            .addAlias(new Alias(INDEX_NAME))  
        updateIndexBlock(false, secondIndexName);
        );  
import org.opensearch.action.admin.indices.alias.Alias;
     * This is a special case for remote state as at this point cluster uuid in the restored state is still ClusterState.UNKNOWN_UUID as we persist it disk.
                    1L,
     * 3. Start cluster manager node without correct seeding to ensure local disk state is written with cluster uuid ClusterState.UNKNOWN_UUID but with remote restored Metadata
    public void testFullClusterRestoreGlobalMetadata() throws Exception {
        verifyRedIndicesAndTriggerRestore(indexStats2, secondIndexName, false);
import org.opensearch.action.admin.indices.datastream.DataStreamRolloverIT;  
        verifyRedIndicesAndTriggerRestore(indexStats, INDEX_NAME, false);
        assertFalse(componentTemplateMetadata.componentTemplates().isEmpty());
            newClusterStateVersion
 * SPDX-License-Identifier: Apache-2.0
            new PutComponentTemplateAction.Request(COMPONENT_TEMPLATE_NAME).componentTemplate(  
        assertTrue(componentTemplateMetadata.componentTemplates().containsKey(COMPONENT_TEMPLATE_NAME));
        // Create global metadata - Put cluster block  
    public void setup() {
        assert prevClusterStateVersion < newClusterStateVersion : String.format(
        // update coordination metadata
import org.opensearch.test.InternalTestCluster;
        assertTrue(composableTemplateResponse.get().isAcknowledged());
        resetCluster(dataNodeCount, clusterManagerNodeCount);
    @Override
            assertEquals(currentMetadata.coordinationMetadata().term(), manifest.getClusterTerm());  
        try {
        asyncUploadMockFsRepo = false;
                    Collections.emptyMap(),
 */  
        } catch (IOException e) {  
        internalCluster().startNode(Settings.builder().put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), false).build());
     */
        assert prevClusterStateVersion < newClusterStateVersion : String.format(
                Files.move(segmentRepoPath.resolve(md.getUploadedFilename()), segmentRepoPath.resolve("cluster-state/"));  
            Locale.ROOT,
        }
import org.opensearch.cluster.block.ClusterBlockException;
 *
        validateMetadata(List.of(INDEX_NAME, secondIndexName));  
                segmentRepoPath.resolve("cluster-state/")
        }
        // start data nodes to trigger index data recovery
        verifyRedIndicesAndTriggerRestore(indexStats, INDEX_NAME, false);
import org.opensearch.action.admin.indices.template.put.PutComponentTemplateAction;
            Files.move(  
        assertTrue(clusterService().state().blocks().hasGlobalBlock(CLUSTER_READ_ONLY_BLOCK));  
        validateMetadata(List.of(INDEX_NAME));
                    .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()) // disable seeding during bootstrapping  
        // repo cleanup post verification
        );
            .preparePutTemplate(TEMPLATE_NAME)
            );  
        clusterAdmin().prepareDeleteRepository("custom-repo").get();  
                    Collections.singletonList(COMPONENT_TEMPLATE_NAME),
        Map<String, Long> indexStats = initialTestSetup(shardCount, replicaCount, dataNodeCount, 1);
        verifyRedIndicesAndTriggerRestore(indexStats, INDEX_NAME, true);  
     * This test scenario covers the case where right after remote state restore and persisting it to disk via LucenePersistedState, full cluster restarts.
    }
        RepositoriesMetadata repositoriesMetadata = clusterService().state().metadata().custom(RepositoriesMetadata.TYPE);
        // Step - 1 index some data to generate files in remote directory
        long newClusterStateVersion = clusterService().state().version();
        int dataNodeCount = shardCount * (replicaCount + 1);
            .execute();
    static final String COMPOSABLE_TEMPLATE_NAME = "remote-composable-template1";
            .metadata()
            prevClusterStateVersion,
import java.io.IOError;
        // Remove the block to ensure proper cleanup
        assert prevClusterStateVersion < newClusterStateVersion : String.format(  
            )
            : "Disabling Cluster manager seeding failed. cluster uuid is not unknown";
            public Settings onNodeStopped(String nodeName) {
        int dataNodeCount = shardCount * (replicaCount + 1);
        );
                segmentRepoPath.resolve(
        assert !Objects.equals(newClusterUUID, prevClusterUUID) : "cluster restart not successful. cluster uuid is same";
        assertEquals((shardCount + 1) * (replicaCount + 1), getNumShards(secondIndexName).totalNumShards);  
        assertTrue(client().admin().indices().putTemplate(request).actionGet().isAcknowledged());  
            assertEquals(clusterState.stateUUID(), manifest.getStateUUID());
        Map<String, Long> indexStats = initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
                assertEquals(currentIndexMetadata.getIndex().getUUID(), uploadedIndexMetadata.getIndexUUID());  
    }  
        long prevClusterStateVersion = clusterService().state().version();
        assertFalse(clusterService().state().metadata().templates().isEmpty());
        // Step - 2 Replace all nodes in the cluster with new nodes. This ensures new cluster state doesn't have previous index metadata  
                )
                .put(BlobStoreRepository.SHARD_PATH_TYPE.getKey(), pathType)  
        ComposableIndexTemplateMetadata composableIndexTemplate = clusterService().state().metadata().custom("index_template");
                .updateSettings(
        // Create global metadata - register a custom repo  
            .cluster()
        int replicaCount = 1;
     * After restart the local disk state will be read but should be again overridden with remote state.  
        long prevClusterStateVersion = clusterService().state().version();  
        long prevClusterStateVersion = clusterService().state().version();  
import org.opensearch.gateway.remote.ClusterMetadataManifest;
        return indexStats;  
import org.opensearch.cluster.metadata.Metadata;
        // Step - 3 validate cluster state restored  
        verifyRestoredIndexTemplate();  
        // Step - 2 Replace all nodes in the cluster with new nodes. This ensures new cluster state doesn't have previous index metadata
        // validate global metadata restored
        );
        verifyRestoredData(indexStats, indexName, indexMoreDocs);
        createRepository("custom-repo", "fs", Settings.builder().put("location", path).put("compress", false));
        PutIndexTemplateRequest request = new PutIndexTemplateRequest("my-template"); // <1>
        assertTrue(composableIndexTemplate.indexTemplates().containsKey(COMPOSABLE_TEMPLATE_NAME));  
    }  
        verifyRedIndicesAndTriggerRestore(indexStats, INDEX_NAME, true);  
                    Arrays.stream(INDEX_NAMES_WILDCARD.split(",")).collect(Collectors.toList()),  
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true).build();
                .build(),
        assert !Objects.equals(newClusterUUID, prevClusterUUID) : "cluster restart not successful. cluster uuid is same";
        internalCluster().stopAllNodes();  
        assertTrue(SYSTEM_REPOSITORY_SETTING.get(repositoriesMetadata.repository(REPOSITORY_NAME).settings()));  
    private void validateMetadata(List<String> indexNames) {
            prevClusterStateVersion,
    protected void verifyRedIndicesAndTriggerRestore(Map<String, Long> indexStats, String indexName, boolean indexMoreDocs)  
    }
import org.opensearch.cluster.metadata.RepositoriesMetadata;  
            PutComposableIndexTemplateAction.INSTANCE,  
            "ClusterState version is not restored. previousClusterVersion: [%s] is greater than current [%s]",
        String newClusterUUID = clusterService().state().metadata().clusterUUID();
    }
        // verify cluster manager not elected
        );
        PathType pathType = BlobStoreRepository.SHARD_PATH_TYPE.get(settings);
    }  
    }  
    }
            .execute();
        internalCluster().stopAllNodes();  
            .coordinationMetadata()  
        );  
        newClusterUUID = clusterService().state().metadata().clusterUUID();  
        addClusterLevelReadOnlyBlock();
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        long newClusterStateVersion = clusterService().state().version();
            assertEquals(currentMetadata.indices().size(), manifest.getIndices().size());
        Path path = randomRepoPath();
        // Step - 1.1 Add some cluster state elements
    }
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);  
                    getClusterState().metadata().clusterUUID()  
            .prepareUpdateSettings()  
        assertTrue(SYSTEM_REPOSITORY_SETTING.get(repositoriesMetadata.repository(REPOSITORY_2_NAME).settings()));
        String secondIndexName = INDEX_NAME + "-2";  
                    .build()
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();
        int replicaCount = 1;  
            }
            .getVotingConfigExclusions()
        int clusterManagerNodeCount = 1;
        // Step - 2 Replace all nodes in the cluster with new nodes. This ensures new cluster state doesn't have previous index metadata  
            } catch (IllegalStateException e) {
            throw new RuntimeException(e);
            ClusterMetadataManifest manifest = remoteClusterStateService.getLatestClusterMetadataManifest(
     * 5. After restart the cluster manager picks up the local disk state with has same Metadata as remote but cluster uuid is still ClusterState.UNKNOWN_UUID  
        // Test is complete
        request.settings(
        assertTrue(clusterService().state().metadata().templates().containsKey(TEMPLATE_NAME));
                internalCluster().getClusterManagerName()
        // Step - 3 Delete index metadata file in remote
        resetCluster(dataNodeCount, clusterManagerNodeCount);
            internalCluster().getClusterManagerName()
    private void verifyRestoredIndexTemplate() {
        Map<String, Long> indexStats = initialTestSetup(shardCount, replicaCount, dataNodeCount, 1);
        }
        assertAcked(
            }
import org.opensearch.cluster.metadata.ComponentTemplateMetadata;  
        assertEquals(
        // Remote the cluster read only block to ensure proper cleanup
                    new UpdateSettingsRequest(Settings.builder().put(INDEX_READ_ONLY_SETTING.getKey(), value).build(), secondIndexName)
                    null  
                ).get();
            .stream()
        putIndexTemplate();
import static org.opensearch.cluster.metadata.Metadata.SETTING_READ_ONLY_SETTING;  
            assertEquals(currentMetadata.clusterUUIDCommitted(), manifest.isClusterUUIDCommitted());  
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
            newClusterStateVersion  
                    .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), nodeName)  // Seed with correct Cluster Manager node  
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();  
                .put("index.number_of_shards", 3)  
                    getClusterState().getClusterName().value(),
        ensureGreen(INDEX_NAME);
        } catch (IOException e) {  
import java.nio.file.Files;
        assertFalse(clusterService().state().metadata().settings().getAsBoolean(SETTING_READ_ONLY_SETTING.getKey(), true));
        for (String indexName : indexNames) {  
    public void testFullClusterRestoreManifestFilePointsToInvalidIndexMetadataPathThrowsException() throws Exception {
        // Step - 1 index some data to generate files in remote directory  
        new DataStreamRolloverIT() {  
                .get()
     *
        int shardCount = randomIntBetween(1, 2);
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
        assert prevClusterStateVersion < newClusterStateVersion : String.format(
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
                .put("index.number_of_shards", 3)
    public void testRemoteStateFullRestart() throws Exception {
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();
    private Path registerCustomRepository() {  
        // Starting a node without remote state to ensure test cleanup  
        throws Exception {
        assertEquals(Integer.valueOf(34), SETTING_CLUSTER_MAX_SHARDS_PER_NODE.get(clusterService().state().metadata().settings()));
        int shardCount = randomIntBetween(1, 2);
     * 8. Add data nodes to recover index data  
     * 2. Replace all nodes to remove all local disk state  
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
        long prevClusterStateVersion = clusterService().state().version();
        verifyRedIndicesAndTriggerRestore(indexStats, INDEX_NAME, true);
        Settings settings = repositoriesMetadata.repository("custom-repo").settings();  
        assertFalse(clusterService().state().metadata().settings().isEmpty());  
                new ComposableIndexTemplate(
        Path repoPath = registerCustomRepository();
        String newClusterUUID = clusterService().state().metadata().clusterUUID();
        long newClusterStateVersion = clusterService().state().version();
        int clusterManagerNodeCount = 1;
        verifyRestoredRepositories(repoPath);
        assertEquals(clusterService().state().metadata().indices().size(), indexNames.size());
        int clusterManagerNodeCount = 1;
        assertEquals(shardCount * (replicaCount + 1), getNumShards(INDEX_NAME).totalNumShards);
    }
            )
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;  
        assertNotNull(clusterService().state().metadata().custom("index_template"));  
                .indices()  
        try {
        internalCluster().startDataOnlyNodes(dataNodeCount);  
    }  
        // Test is complete
            IllegalStateException.class,
        int dataNodeCount = shardCount * (replicaCount + 1);
        // Delete index metadata file in remote
        assertTrue(clusterUpdateSettingsResponse.get().isAcknowledged());  
        ActionFuture<AcknowledgedResponse> composableTemplateResponse = client().execute(
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;  
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();
    static final String TEMPLATE_NAME = "remote-store-test-template";  
    /**  
            PutComponentTemplateAction.INSTANCE,
        internalCluster().startClusterManagerOnlyNodes(clusterManagerNodeCount);
        // validate new cluster state formed
                clusterManagerNodeCount,
        return path;  
            "ClusterState version is not restored. previousClusterVersion: [%s] is greater than current [%s]",
            Metadata currentMetadata = clusterState.metadata();
    }
    }
    }
        String newClusterUUID = clusterService().state().metadata().clusterUUID();  
        Map<String, Long> indexStats = initialTestSetup(shardCount, replicaCount, dataNodeCount, 1);
        ActionFuture<AcknowledgedResponse> response = client().admin()  
        );  
        ComponentTemplateMetadata componentTemplateMetadata = clusterService().state().metadata().custom("component_template");  
        createIndex(secondIndexName, remoteStoreIndexSettings(replicaCount, shardCount + 1));
        String newClusterUUID = clusterService().state().metadata().clusterUUID();  
        ActionFuture<AcknowledgedResponse> componentTemplateResponse = client().execute(
                getClusterState().getClusterName().value(),
    public void testDataStreamPostRemoteStateRestore() throws Exception {
 * The OpenSearch Contributors require contributions made to  
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();
import java.util.Locale;  
        assertThrows(ClusterBlockException.class, () -> indexSingleDoc(secondIndexName));
            prevClusterStateVersion,  
            client().admin()
            .setPersistentSettings(Settings.builder().put(SETTING_READ_ONLY_SETTING.getKey(), false).build())
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
        updateIndexBlock(true, secondIndexName);
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);  
        );  
            Locale.ROOT,
            @Override  
        ensureGreen(secondIndexName);
    }  
        validateMetadata(List.of(INDEX_NAME));
            prevClusterStateVersion,  
import java.util.Map;
        updatePersistentSettings(Settings.builder().put(SETTING_READ_ONLY_SETTING.getKey(), false).build());
        assert Objects.equals(newClusterUUID, ClusterState.UNKNOWN_UUID)
                    encodeString(clusterService().state().getClusterName().value()) + "/cluster-state/" + prevClusterUUID + "/manifest"
            internalCluster().stopAllNodes();
            ).get();
    }
        );  
                new ComponentTemplate(new Template(Settings.EMPTY, null, Collections.emptyMap()), 1L, Collections.emptyMap())
        assertTrue(componentTemplateResponse.get().isAcknowledged());
        );
            for (UploadedIndexMetadata md : manifest.getIndices()) {
            Locale.ROOT,  
        resetCluster(dataNodeCount, clusterManagerNodeCount);
        int replicaCount = 1;
import org.junit.Before;  
        assert prevClusterStateVersion < newClusterStateVersion : String.format(  
            .forEach(config -> assertTrue(Arrays.stream(EXCLUDED_NODES).anyMatch(node -> node.equals(config.getNodeId()))));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
/*  
        int dataNodeCount = shardCount * (replicaCount + 1);  
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;  
        Map<String, Long> indexStats = initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
import org.opensearch.common.settings.Settings;
            .indices()
            }
            Settings.builder()  
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
package org.opensearch.remotestore;
        // Step - 1 index some data to generate files in remote directory
        });
        int shardCount = randomIntBetween(1, 2);
import java.util.Objects;
            newClusterStateVersion  
import org.opensearch.cluster.metadata.Template;
            new PutComposableIndexTemplateAction.Request(COMPOSABLE_TEMPLATE_NAME).indexTemplate(
    public void testFullClusterRestoreDoesntFailWithConflictingLocalState() throws Exception {  
                )  
        // Step - 1 index some data to generate files in remote directory
        int clusterManagerNodeCount = 1;
        // index some data to generate files in remote directory  
        assertEquals(1, indexTemplateMetadataMap.size());
        // Create global metadata - index template  
        internalCluster().fullRestart();  
        long prevClusterStateVersion = clusterService().state().version();
                .put("location", repoPath)
        assertEquals(3, repositoriesMetadata.repositories().size()); // includes remote store repo as well
     * 1. Form a cluster and index few docs
        assertEquals("fs", repositoriesMetadata.repository("custom-repo").type());
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
        // Step - 3 validate cluster state restored
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.encodeString;
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
            "ClusterState version is not restored. previousClusterVersion: [%s] is greater than current [%s]",
        // Step - 2 Replace all nodes in the cluster with new nodes. This ensures new cluster state doesn't have previous index metadata
            indexTemplateMetadataMap.get("my-template").settings()
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            )
import java.io.IOException;  
        int shardCount = randomIntBetween(1, 2);  
            newClusterStateVersion  
                ),  
                .build(),
            protected boolean triggerRemoteStateRestore() {
        ClusterUpdateSettingsRequest resetRequest = new ClusterUpdateSettingsRequest();  
        restore(false, indexName);  
        // Create global metadata - persistent settings  
                getClusterState().metadata().clusterUUID()  
        assert Objects.equals(newClusterUUID, prevClusterUUID) : "Full restart not successful. cluster uuid has changed";  
            () -> internalCluster().startClusterManagerOnlyNodes(  
        clusterService().state()
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
    }  
        String newClusterUUID = clusterService().state().metadata().clusterUUID();  
        int dataNodeCount = shardCount * (replicaCount + 1);
        // restart cluster manager with correct seed
public class RemoteStoreClusterStateRestoreIT extends BaseRemoteStoreRestoreIT {
 * compatible open source license.
     * 6. The cluster manager will try to restore from remote again.
        long newClusterStateVersion = clusterService().state().version();
        ActionFuture<ClusterUpdateSettingsResponse> clusterUpdateSettingsResponse = client().admin()
import org.opensearch.common.settings.Setting;  
            }  
import org.opensearch.gateway.remote.RemoteClusterStateService;
            }
        // Add a custom metadata as component index template  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_SETTING;
import java.util.stream.Collectors;
    private void validateCurrentMetadata() throws Exception {
            Locale.ROOT,  
    static final String[] EXCLUDED_NODES = { "ex-1", "ex-2" };
        Map<String, IndexTemplateMetadata> indexTemplateMetadataMap = clusterService().state().metadata().templates();  
            settings
        }.testDataStreamRollover();
    private static void updateIndexBlock(boolean value, String secondIndexName) throws InterruptedException, ExecutionException {  
            try {  
                throw new AssertionError("Error while validating latest cluster metadata", e);
        assert !Objects.equals(newClusterUUID, prevClusterUUID) : "cluster restart not successful. cluster uuid is same";
        assertFalse(clusterService().state().blocks().hasGlobalBlock(CLUSTER_READ_ONLY_BLOCK));  
}
                .put("index.number_of_replicas", 1)
import org.opensearch.test.OpenSearchIntegTestCase;
        long newClusterStateVersion = clusterService().state().version();
        updatePersistentSettings(Settings.builder().put(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), 34).build());
    static final Setting<String> MOCK_SETTING = Setting.simpleString("mock-setting");  
                    .build();
        client().execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(EXCLUDED_NODES));
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();  
        assertBusy(() -> {
            "ClusterState version is not restored. previousClusterVersion: [%s] is greater than current [%s]",
        String clusterName = clusterService().state().getClusterName().value();  
import java.util.concurrent.ExecutionException;  
import java.util.Arrays;  
            .setPatterns(Arrays.stream(INDEX_NAMES_WILDCARD.split(",")).collect(Collectors.toList()))
     * 9. Verify Metadata and index data is restored.
        assert !Objects.equals(newClusterUUID, prevClusterUUID) : "cluster restart not successful. cluster uuid is same";
        assert !Objects.equals(newClusterUUID, ClusterState.UNKNOWN_UUID) : "cluster restart not successful. cluster uuid is still unknown";
import org.opensearch.cluster.metadata.ComposableIndexTemplateMetadata;
                return true;
        int dataNodeCount = shardCount * (replicaCount + 1);  
    }
        // Step - 3 validate cluster state restored  
        int shardCount = randomIntBetween(1, 2);
        request.patterns(Arrays.asList("pattern-1", "log-*")); // <2>
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {
import org.opensearch.cluster.metadata.IndexMetadata;  
            ClusterMetadataManifest manifest;
    }
                Settings.builder()
    static final String COMPONENT_TEMPLATE_NAME = "remote-component-template1";
        assertTrue(clusterService().state().blocks().hasGlobalBlock(CLUSTER_READ_ONLY_BLOCK));
            prevClusterStateVersion,
                    1L,  
    private void updatePersistentSettings(Settings settings) throws ExecutionException, InterruptedException {
            ClusterState clusterState = getClusterState();  
import static org.opensearch.cluster.metadata.Metadata.CLUSTER_READ_ONLY_BLOCK;
    private void addClusterLevelReadOnlyBlock() throws InterruptedException, ExecutionException {  
            assertTrue(clusterService().state().metadata().hasIndex(indexName));
            for (UploadedIndexMetadata uploadedIndexMetadata : manifest.getIndices()) {
        internalCluster().startDataOnlyNodes(dataNodeCount);
        RemoteClusterStateService remoteClusterStateService = internalCluster().getInstance(  
        int replicaCount = 1;
    public void testFullClusterRestoreMultipleIndices() throws Exception {  
        assertEquals(Arrays.asList("pattern-1", "log-*"), indexTemplateMetadataMap.get("my-template").patterns());
            "ClusterState version is not restored. previousClusterVersion: [%s] is greater than current [%s]",
