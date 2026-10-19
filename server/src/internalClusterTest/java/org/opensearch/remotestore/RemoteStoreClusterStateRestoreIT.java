        putIndexTemplate();
            client().admin()
        // Step - 3 validate cluster state restored
        int shardCount = randomIntBetween(1, 2);
                .get()
        client().execute(AddVotingConfigExclusionsAction.INSTANCE, new AddVotingConfigExclusionsRequest(EXCLUDED_NODES));
            }
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
import java.util.Objects;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                getClusterState().metadata().clusterUUID()
        assertTrue(clusterUpdateSettingsResponse.get().isAcknowledged());
        assertTrue(SYSTEM_REPOSITORY_SETTING.get(repositoriesMetadata.repository(REPOSITORY_NAME).settings()));
        Map<String, Long> indexStats = initialTestSetup(shardCount, replicaCount, dataNodeCount, 1);
            throw new RuntimeException(e);
            .metadata()
        try {
        return path;
            .setPatterns(Arrays.stream(INDEX_NAMES_WILDCARD.split(",")).collect(Collectors.toList()))
            .execute();
    }
            Locale.ROOT,
        assertThrows(
        // Step - 2 Replace all nodes in the cluster with new nodes. This ensures new cluster state doesn't have previous index metadata
import org.opensearch.test.InternalTestCluster;
                internalCluster().getClusterManagerName()
        int dataNodeCount = shardCount * (replicaCount + 1);
        assertAcked(
        ActionFuture<AcknowledgedResponse> composableTemplateResponse = client().execute(
    public void testFullClusterRestoreGlobalMetadata() throws Exception {
        verifyRestoredData(indexStats, indexName, indexMoreDocs);
                    .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(), nodeName)  // Seed with correct Cluster Manager node
        resetCluster(dataNodeCount, clusterManagerNodeCount);
        String newClusterUUID = clusterService().state().metadata().clusterUUID();
        verifyRedIndicesAndTriggerRestore(indexStats, INDEX_NAME, true);
        // Create global metadata - persistent settings
    public void testDataStreamPostRemoteStateRestore() throws Exception {
                .build(),
                )
    private void resetCluster(int dataNodeCount, int clusterManagerNodeCount) {
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(composableIndexTemplate.indexTemplates().containsKey(COMPOSABLE_TEMPLATE_NAME));
        assert prevClusterStateVersion < newClusterStateVersion : String.format(
    }
import org.opensearch.cluster.metadata.Metadata;
        String newClusterUUID = clusterService().state().metadata().clusterUUID();
        request.settings(
        assert prevClusterStateVersion < newClusterStateVersion : String.format(
        long newClusterStateVersion = clusterService().state().version();
        int shardCount = randomIntBetween(1, 2);
    private void verifyRestoredIndexTemplate() {
 * SPDX-License-Identifier: Apache-2.0
            PutComponentTemplateAction.INSTANCE,
        // validate new cluster state formed
        // Remote the cluster read only block to ensure proper cleanup
        resetCluster(dataNodeCount, clusterManagerNodeCount);
            "ClusterState version is not restored. previousClusterVersion: [%s] is greater than current [%s]",
                    null
        assertFalse(clusterService().state().metadata().templates().isEmpty());
        createRepository("custom-repo", "fs", Settings.builder().put("location", path).put("compress", false));
    @Override
        internalCluster().fullRestart(new InternalTestCluster.RestartCallback() {
            "ClusterState version is not restored. previousClusterVersion: [%s] is greater than current [%s]",
    private static void updateIndexBlock(boolean value, String secondIndexName) throws InterruptedException, ExecutionException {
        resetCluster(dataNodeCount, clusterManagerNodeCount);
            @Override
        assert !Objects.equals(newClusterUUID, prevClusterUUID) : "cluster restart not successful. cluster uuid is same";
        resetRequest.persistentSettings(settings);
import static org.opensearch.cluster.metadata.Metadata.CLUSTER_READ_ONLY_BLOCK;
 * compatible open source license.
            internalCluster().getClusterManagerName()
        validateCurrentMetadata();
        }
        String newClusterUUID = clusterService().state().metadata().clusterUUID();
        // Step - 1 index some data to generate files in remote directory
 */
        // Remove the block to ensure proper cleanup
        for (String indexName : indexNames) {
        int clusterManagerNodeCount = 1;
     * This is a special case for remote state as at this point cluster uuid in the restored state is still ClusterState.UNKNOWN_UUID as we persist it disk.
        ActionFuture<AcknowledgedResponse> response = client().admin()
    private static void putIndexTemplate() {
                throw new AssertionError("Error while validating latest cluster metadata", e);
                manifest = remoteClusterStateService.getLatestClusterMetadataManifest(
        );
                IndexMetadata currentIndexMetadata = currentMetadata.index(uploadedIndexMetadata.getIndexName());
        internalCluster().startDataOnlyNodes(dataNodeCount);
            "ClusterState version is not restored. previousClusterVersion: [%s] is greater than current [%s]",
import org.opensearch.common.action.ActionFuture;
        ComposableIndexTemplateMetadata composableIndexTemplate = clusterService().state().metadata().custom("index_template");
    public void testRemoteStateFullRestart() throws Exception {
    }
            throw new RuntimeException(e);
        assert Objects.equals(newClusterUUID, prevClusterUUID) : "Full restart not successful. cluster uuid has changed";
        int replicaCount = 1;
        // Create global metadata - index template
        verifyRestoredIndexTemplate();
        Settings settings = repositoriesMetadata.repository("custom-repo").settings();
        assert Objects.equals(newClusterUUID, ClusterState.UNKNOWN_UUID)
        int replicaCount = 1;
    }
import org.opensearch.test.OpenSearchIntegTestCase;
    }
        PutIndexTemplateRequest request = new PutIndexTemplateRequest("my-template"); // <1>
import java.nio.file.Path;
        clusterService().state()
        int dataNodeCount = shardCount * (replicaCount + 1);
import java.util.stream.Collectors;
            RemoteClusterStateService.class,
import org.opensearch.cluster.metadata.RepositoriesMetadata;
        verifyRedIndicesAndTriggerRestore(indexStats2, secondIndexName, false);
        assertTrue(componentTemplateMetadata.componentTemplates().containsKey(COMPONENT_TEMPLATE_NAME));
}
                .put("index.number_of_shards", 3)
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
import org.opensearch.action.admin.indices.template.put.PutIndexTemplateRequest;
        // Step - 2 Replace all nodes in the cluster with new nodes. This ensures new cluster state doesn't have previous index metadata
     * 2. Replace all nodes to remove all local disk state
     * 6. The cluster manager will try to restore from remote again.
            }
     * 3. Start cluster manager node without correct seeding to ensure local disk state is written with cluster uuid ClusterState.UNKNOWN_UUID but with remote restored Metadata
        }
        assertFalse(composableIndexTemplate.indexTemplates().isEmpty());
import java.util.Map;
        PathType pathType = BlobStoreRepository.SHARD_PATH_TYPE.get(settings);
        verifyRestoredRepositories(repoPath);
            Locale.ROOT,
        String newClusterUUID = clusterService().state().metadata().clusterUUID();
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();
    static final String COMPONENT_TEMPLATE_NAME = "remote-component-template1";
        updatePersistentSettings(Settings.builder().put(SETTING_CLUSTER_MAX_SHARDS_PER_NODE.getKey(), 34).build());
            .preparePutTemplate(TEMPLATE_NAME)
                    encodeString(clusterService().state().getClusterName().value()) + "/cluster-state/" + prevClusterUUID + "/manifest"
            newClusterStateVersion
        assertTrue(clusterService().state().blocks().hasGlobalBlock(CLUSTER_READ_ONLY_BLOCK));
        assertEquals(clusterService().state().metadata().indices().size(), indexNames.size());
        long prevClusterStateVersion = clusterService().state().version();
            new PutComposableIndexTemplateAction.Request(COMPOSABLE_TEMPLATE_NAME).indexTemplate(
        // Create global metadata - Put cluster block
import org.opensearch.common.settings.Setting;
    }
            assertTrue(clusterService().state().metadata().hasIndex(indexName));
        );
            assertEquals(currentMetadata.coordinationMetadata().term(), manifest.getClusterTerm());
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.encodeString;
     * 8. Add data nodes to recover index data
        ensureRed(indexName);
        ActionFuture<AcknowledgedResponse> componentTemplateResponse = client().execute(
import java.util.Arrays;
            assertEquals(clusterState.version(), manifest.getStateVersion());
        // Step - 3 validate cluster state restored
            .cluster()
        updateIndexBlock(false, secondIndexName);
    private Map<String, Long> initialTestSetup(int shardCount, int replicaCount, int dataNodeCount, int clusterManagerNodeCount) {
        internalCluster().stopAllNodes();
        );
import org.junit.Before;
                clusterManagerNodeCount,
        asyncUploadMockFsRepo = false;
        int replicaCount = 1;
        throws Exception {
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
        validateMetadata(List.of(INDEX_NAME));
    }
        int clusterManagerNodeCount = 1;
    private void addClusterLevelReadOnlyBlock() throws InterruptedException, ExecutionException {
        createIndex(secondIndexName, remoteStoreIndexSettings(replicaCount, shardCount + 1));
                RemoteClusterStateService.class,
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsRequest;
        // This should fail with IllegalStateException as cluster manager fails to form without any initial seed
        int dataNodeCount = shardCount * (replicaCount + 1);
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
        // Step - 1.1 Add some cluster state elements
            () -> internalCluster().startClusterManagerOnlyNodes(
        long prevClusterStateVersion = clusterService().state().version();
            newClusterStateVersion
    }
        long newClusterStateVersion = clusterService().state().version();
        assertEquals(
     * 7. Metadata loaded from local disk state will be overridden with remote Metadata and no conflict should arise.
        });
        assertFalse(clusterService().state().metadata().settings().isEmpty());
            try {
        String secondIndexName = INDEX_NAME + "-2";
                new ComponentTemplate(new Template(Settings.EMPTY, null, Collections.emptyMap()), 1L, Collections.emptyMap())
        }.testDataStreamRollover();
        // Step - 1 index some data to generate files in remote directory
        ensureGreen(secondIndexName);
    public void testFullClusterRestoreManifestFilePointsToInvalidIndexMetadataPathThrowsException() throws Exception {
        } catch (IOException e) {
            .indices()
import org.opensearch.action.admin.indices.template.put.PutComponentTemplateAction;
            );
        ensureGreen(INDEX_NAME);
        // Step - 3 validate cluster state restored
        assertEquals(3, repositoriesMetadata.repositories().size()); // includes remote store repo as well
                // AssertionError helps us use assertBusy and retry validation if failed due to a race condition.
        internalCluster().stopAllNodes();
    static final Setting<String> MOCK_SETTING = Setting.simpleString("mock-setting");
     *
     */
        internalCluster().startNode(Settings.builder().put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), false).build());
        // repo cleanup post verification
            internalCluster().stopAllNodes();
                )
    }
import java.io.IOError;
     * This test scenario covers the case where right after remote state restore and persisting it to disk via LucenePersistedState, full cluster restarts.
    }
    }
        assertTrue(client().admin().indices().putTemplate(request).actionGet().isAcknowledged());
        internalCluster().startDataOnlyNodes(dataNodeCount);
        int shardCount = randomIntBetween(1, 2);
            Settings.builder() // <1>
        assertTrue(componentTemplateResponse.get().isAcknowledged());
                return Settings.builder()
                Files.move(segmentRepoPath.resolve(md.getUploadedFilename()), segmentRepoPath.resolve("cluster-state/"));
        // Step - 3 Delete index metadata file in remote
            prevClusterStateVersion,
        RemoteClusterStateService remoteClusterStateService = internalCluster().getInstance(
                assertEquals(currentIndexMetadata.getIndex().getUUID(), uploadedIndexMetadata.getIndexUUID());
        // restart cluster manager with correct seed
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();
        // Test is complete
        int shardCount = randomIntBetween(1, 2);
import java.util.concurrent.ExecutionException;
        Map<String, Long> indexStats = initialTestSetup(shardCount, replicaCount, dataNodeCount, 1);
        // stop all nodes
                    new UpdateSettingsRequest(Settings.builder().put(INDEX_READ_ONLY_SETTING.getKey(), value).build(), secondIndexName)
        assert prevClusterStateVersion < newClusterStateVersion : String.format(
        // start a cluster manager node with no cluster manager seeding.
        Map<String, IndexTemplateMetadata> indexTemplateMetadataMap = clusterService().state().metadata().templates();
        updatePersistentSettings(Settings.builder().put(SETTING_READ_ONLY_SETTING.getKey(), true).build());
            IllegalStateException.class,
            protected boolean triggerRemoteStateRestore() {
import org.opensearch.cluster.metadata.IndexMetadata;
     * After restart the local disk state will be read but should be again overridden with remote state.
        clusterAdmin().prepareDeleteRepository("custom-repo").get();
        restore(false, indexName);
        assert prevClusterStateVersion < newClusterStateVersion : String.format(
    private Path registerCustomRepository() {
        assert !Objects.equals(newClusterUUID, prevClusterUUID) : "cluster restart not successful. cluster uuid is same";
        );
        internalCluster().fullRestart();
            );
        int dataNodeCount = shardCount * (replicaCount + 1);
                .updateSettings(
package org.opensearch.remotestore;
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
    }
        String clusterName = clusterService().state().getClusterName().value();
            .setPersistentSettings(Settings.builder().put(SETTING_READ_ONLY_SETTING.getKey(), false).build())
        long newClusterStateVersion = clusterService().state().version();
        // validate global metadata restored
        int dataNodeCount = shardCount * (replicaCount + 1);
        ClusterUpdateSettingsRequest resetRequest = new ClusterUpdateSettingsRequest();
                .put(BlobStoreRepository.SHARD_PATH_TYPE.getKey(), pathType)
                    1L,
        );
        Path repoPath = registerCustomRepository();
        // Step - 2 Replace all nodes in the cluster with new nodes. This ensures new cluster state doesn't have previous index metadata
     * 1. Form a cluster and index few docs
        String newClusterUUID = clusterService().state().metadata().clusterUUID();
import java.util.Collections;
                .put("index.number_of_replicas", 1)
        int dataNodeCount = shardCount * (replicaCount + 1);
        Map<String, Long> indexStats = initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
            } catch (IllegalStateException e) {
            settings
        );
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();
                ).get();
        );
        assertEquals("fs", repositoriesMetadata.repository("custom-repo").type());
        assert !Objects.equals(newClusterUUID, prevClusterUUID) : "cluster restart not successful. cluster uuid is same";
            .execute();
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();
        return indexStats;
 *
        validateMetadata(List.of(INDEX_NAME));
            ClusterState clusterState = getClusterState();
            newClusterStateVersion
     * 5. After restart the cluster manager picks up the local disk state with has same Metadata as remote but cluster uuid is still ClusterState.UNKNOWN_UUID
            assertEquals(currentMetadata.clusterUUIDCommitted(), manifest.isClusterUUIDCommitted());
                segmentRepoPath.resolve("cluster-state/")
        assertEquals(1, indexTemplateMetadataMap.size());
            for (UploadedIndexMetadata md : manifest.getIndices()) {
        int clusterManagerNodeCount = 3;
    private void updatePersistentSettings(Settings settings) throws ExecutionException, InterruptedException {
        internalCluster().stopAllNodes();
    /**
                    getClusterState().metadata().clusterUUID()
    }
        assert !Objects.equals(newClusterUUID, ClusterState.UNKNOWN_UUID) : "cluster restart not successful. cluster uuid is still unknown";
            )
        // Delete index metadata file in remote
            Locale.ROOT,
import java.util.Locale;
import org.opensearch.cluster.metadata.ComponentTemplate;
import org.opensearch.cluster.metadata.Template;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_SETTING;
        Map<String, Long> indexStats = initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
            indexTemplateMetadataMap.get("my-template").settings()
                    .build()
        assertEquals(true, SETTING_READ_ONLY_SETTING.get(clusterService().state().metadata().settings()));
            Files.move(
        newClusterUUID = clusterService().state().metadata().clusterUUID();
        ActionFuture<ClusterUpdateSettingsResponse> clusterUpdateSettingsResponse = client().admin()
        int clusterManagerNodeCount = 1;
        long prevClusterStateVersion = clusterService().state().version();
    static final String COMPOSABLE_TEMPLATE_NAME = "remote-composable-template1";
            .addAlias(new Alias(INDEX_NAME))
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            .prepareUpdateSettings()
            }
            : "Disabling Cluster manager seeding failed. cluster uuid is not unknown";
    static final String[] EXCLUDED_NODES = { "ex-1", "ex-2" };
            .getVotingConfigExclusions()
    }
                .put("index.number_of_replicas", 1)
                return true;
    static final String TEMPLATE_NAME = "remote-store-test-template";
                    Arrays.stream(INDEX_NAMES_WILDCARD.split(",")).collect(Collectors.toList()),
                Settings.builder()
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true).build();
        int shardCount = randomIntBetween(1, 2);
    protected Settings nodeSettings(int nodeOrdinal) {
        // verify cluster manager not elected
        );
        Map<String, Long> indexStats = initialTestSetup(shardCount, replicaCount, dataNodeCount, 1);
        assertAcked(client().admin().cluster().updateSettings(resetRequest).get());
            )
        assert !Objects.equals(newClusterUUID, prevClusterUUID) : "cluster restart not successful. cluster uuid is same";
import org.opensearch.cluster.metadata.ComposableIndexTemplateMetadata;
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();
        assertTrue(INDEX_READ_ONLY_SETTING.get(clusterService().state().metadata().index(secondIndexName).getSettings()));
        verifyRedIndicesAndTriggerRestore(indexStats, INDEX_NAME, true);
        // update coordination metadata
        String prevClusterUUID = clusterService().state().metadata().clusterUUID();
            ).get();
            }
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
import org.opensearch.common.settings.Settings;
import org.opensearch.gateway.remote.RemoteClusterStateService;
    public void testFullClusterRestoreDoesntFailWithConflictingLocalState() throws Exception {
        request.patterns(Arrays.asList("pattern-1", "log-*")); // <2>
            PutComposableIndexTemplateAction.INSTANCE,
            Locale.ROOT,
        RepositoriesMetadata repositoriesMetadata = clusterService().state().metadata().custom(RepositoriesMetadata.TYPE);
        internalCluster().startClusterManagerOnlyNodes(clusterManagerNodeCount);
        );
                    Collections.singletonList(COMPONENT_TEMPLATE_NAME),
            .coordinationMetadata()
        // Step - 1 index some data to generate files in remote directory
        assertEquals((shardCount + 1) * (replicaCount + 1), getNumShards(secondIndexName).totalNumShards);
        assertTrue(clusterService().state().blocks().hasGlobalBlock(CLUSTER_READ_ONLY_BLOCK));
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;
        int clusterManagerNodeCount = 1;
        updateIndexBlock(true, secondIndexName);
import java.nio.file.Files;
import org.opensearch.cluster.metadata.ComponentTemplateMetadata;
            Settings.builder() // <1>
        int replicaCount = 1;
        } catch (IOException e) {
            "ClusterState version is not restored. previousClusterVersion: [%s] is greater than current [%s]",
        int clusterManagerNodeCount = 1;
        verifyRedIndicesAndTriggerRestore(indexStats, INDEX_NAME, false);
        long newClusterStateVersion = clusterService().state().version();
/*
        assertThrows(ClusterBlockException.class, () -> indexSingleDoc(secondIndexName));
    private void verifyRestoredRepositories(Path repoPath) {
        // Starting a node without remote state to ensure test cleanup
    public void testFullClusterRestore() throws Exception {
            newClusterStateVersion
            .stream()
            prevClusterStateVersion,
        new DataStreamRolloverIT() {
    }
            "ClusterState version is not restored. previousClusterVersion: [%s] is greater than current [%s]",
        verifyRedIndicesAndTriggerRestore(indexStats, INDEX_NAME, false);
            ClusterMetadataManifest manifest;
        initialTestSetup(shardCount, replicaCount, dataNodeCount, clusterManagerNodeCount);
    }
        assertTrue(SYSTEM_REPOSITORY_SETTING.get(repositoriesMetadata.repository(REPOSITORY_2_NAME).settings()));
import org.opensearch.action.admin.indices.alias.Alias;
        assertFalse(componentTemplateMetadata.componentTemplates().isEmpty());
        assertEquals(
        assert prevClusterStateVersion < newClusterStateVersion : String.format(
        );
                    new Template(Settings.EMPTY, null, Collections.emptyMap()),
                segmentRepoPath.resolve(
                .indices()
        assertEquals(shardCount * (replicaCount + 1), getNumShards(INDEX_NAME).totalNumShards);
        Map<String, Long> indexStats = indexData(1, false, INDEX_NAME);
            for (UploadedIndexMetadata uploadedIndexMetadata : manifest.getIndices()) {
            prevClusterStateVersion,
        long prevClusterStateVersion = clusterService().state().version();
                    .putList(INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()) // disable seeding during bootstrapping
    }
            new PutComponentTemplateAction.Request(COMPONENT_TEMPLATE_NAME).componentTemplate(
        Path path = randomRepoPath();
            prevClusterStateVersion,
        assertTrue(composableTemplateResponse.get().isAcknowledged());
        // Create global metadata - register a custom repo
        assertNotNull(clusterService().state().metadata().custom("index_template"));
                .put("location", repoPath)
    protected void verifyRedIndicesAndTriggerRestore(Map<String, Long> indexStats, String indexName, boolean indexMoreDocs)
import java.io.IOException;
import org.opensearch.action.admin.cluster.configuration.AddVotingConfigExclusionsAction;
                    getClusterState().getClusterName().value(),
    @Before
import java.util.List;
        }
        );
        verifyRedIndicesAndTriggerRestore(indexStats, INDEX_NAME, true);
        int replicaCount = 1;
            RemoteClusterStateService remoteClusterStateService = internalCluster().getInstance(
 * The OpenSearch Contributors require contributions made to
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
        assertTrue(response.get().isAcknowledged());
        // index some data to generate files in remote directory
        assertThrows(IOError.class, () -> internalCluster().client());
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
            )
            Settings.builder()
public class RemoteStoreClusterStateRestoreIT extends BaseRemoteStoreRestoreIT {
    }
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
            assertEquals(clusterState.stateUUID(), manifest.getStateUUID());
    public void testFullClusterRestoreMultipleIndices() throws Exception {
            Locale.ROOT,
        assertEquals(Integer.valueOf(34), SETTING_CLUSTER_MAX_SHARDS_PER_NODE.get(clusterService().state().metadata().settings()));
    public void setup() {
                new ComposableIndexTemplate(
import static org.opensearch.indices.ShardLimitValidator.SETTING_CLUSTER_MAX_SHARDS_PER_NODE;
import org.opensearch.action.admin.indices.datastream.DataStreamRolloverIT;
                ),
            public Settings onNodeStopped(String nodeName) {
            Metadata currentMetadata = clusterState.metadata();
                    1L,
     * 9. Verify Metadata and index data is restored.
                getClusterState().getClusterName().value(),
        // Step - 2 Replace all nodes in the cluster with new nodes. This ensures new cluster state doesn't have previous index metadata
                .put("compress", false)
        assertTrue(clusterService().state().metadata().templates().containsKey(TEMPLATE_NAME));
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        // Test is complete
            prevClusterStateVersion,
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        addClusterLevelReadOnlyBlock();
            assertEquals(currentMetadata.indices().size(), manifest.getIndices().size());
            }
        assertEquals(Arrays.asList("pattern-1", "log-*"), indexTemplateMetadataMap.get("my-template").patterns());
            ClusterMetadataManifest manifest = remoteClusterStateService.getLatestClusterMetadataManifest(
                .put("index.number_of_shards", 3)
import static org.opensearch.cluster.metadata.Metadata.SETTING_READ_ONLY_SETTING;
        // Step - 1 index some data to generate files in remote directory
    private void validateMetadata(List<String> indexNames) {
        });
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
    }
        );
        try {
     * 4. Restart the cluster manager node with correct seeding.
        ComponentTemplateMetadata componentTemplateMetadata = clusterService().state().metadata().custom("component_template");
import org.opensearch.cluster.block.ClusterBlockException;
        assertBusy(() -> {
import org.opensearch.gateway.remote.ClusterMetadataManifest;
        long prevClusterStateVersion = clusterService().state().version();
        ensureGreen(INDEX_NAME);
        int shardCount = randomIntBetween(1, 2);
        // Add a custom metadata as component index template
        validateMetadata(List.of(INDEX_NAME, secondIndexName));
        int replicaCount = 1;
                    Collections.emptyMap(),
            .forEach(config -> assertTrue(Arrays.stream(EXCLUDED_NODES).anyMatch(node -> node.equals(config.getNodeId()))));
        long newClusterStateVersion = clusterService().state().version();
        );
    private void validateCurrentMetadata() throws Exception {
                    .build();
        assertFalse(clusterService().state().blocks().hasGlobalBlock(CLUSTER_READ_ONLY_BLOCK));
                .build(),
        Map<String, Long> indexStats2 = indexData(1, false, secondIndexName);
        assertFalse(clusterService().state().metadata().settings().getAsBoolean(SETTING_READ_ONLY_SETTING.getKey(), true));
            newClusterStateVersion
        validateCurrentMetadata();
        assertNotNull(clusterService().state().metadata().custom("component_template"));
        // start data nodes to trigger index data recovery
        updatePersistentSettings(Settings.builder().put(SETTING_READ_ONLY_SETTING.getKey(), false).build());
