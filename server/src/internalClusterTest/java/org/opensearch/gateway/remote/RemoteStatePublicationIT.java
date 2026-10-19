                    assertEquals(0, persistedStateStats.getSuccessCount());  
        }
        internalCluster().getInstances(PersistedStateRegistry.class).forEach(persistedStateRegistry -> {
                )
        assertThat(manifest.getIndicesRouting().size(), is(1));
            .put(REMOTE_PUBLICATION_SETTING_KEY, isRemotePublicationEnabled)
                    Set<String> followingCMs = clusterManagers.stream()
                    assertEquals(0, persistedStateStats.getTotalTimeInMillis());
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        prepareCluster(3, 2, Settings.EMPTY);  
            .addMetric(DISCOVERY.metricName())  
                    boolean activeCMRestarted = restartedMasters.contains(activeCM);
        logger.info("settings : {}", settings);
        assertAcked(client().admin().indices().aliases(request).actionGet());  
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            private final Logger logger = LogManager.getLogger(InterceptingHandler.class);  
        int replicaCount = 1;  
import static org.opensearch.cluster.coordination.PublicationTransportHandler.PUBLISH_REMOTE_STATE_ACTION_NAME;
            );
                }
import org.apache.logging.log4j.Logger;
                    NodesStatsResponse response = client().admin()
import java.util.function.Function;  
        ensureGreen(INDEX_NAME);
import java.nio.charset.StandardCharsets;
                        PersistedStateRegistry registry = internalCluster().getInstance(PersistedStateRegistry.class, node);  
                        || persistedStateStats.getStatsName().equals(DIFF_DOWNLOAD_STATS)  
    @Override
                    });
        internalCluster().client()
    private boolean isRemoteStateEnabled = true;
        isRemotePublicationEnabled = true;
                hasRemoteStateCharPrefix ? REMOTE_STATE_PREFIX : ""
            .admin()  
import org.opensearch.common.blobstore.BlobPath;
        // enable remote publication
            .admin()  
                });  
        ensureStableCluster(5);  
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, false).build())  
        }  
    private Map<String, Integer> getMetadataFiles(BlobStoreRepository repository, String subDirectory) throws IOException {
    }
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
            .prepareUpdateSettings()  
        isRemotePublicationEnabled = false;
                        requests.put(action, requestCount + 1);  
    public void testRemotePublicationDisabledAfterSettingChange() throws ExecutionException, InterruptedException {
                .cluster()
            Collections.addAll(this.actions, actions);
            internalCluster().restartNode(clusterManager, new InternalTestCluster.RestartCallback() {  
                synchronized (this) {  
            CoordinationState.PersistedState remoteState = persistedStateRegistry.getPersistedState(  
        DiscoveryStats dataNodeDiscoveryStats = nodeStats.getDiscoveryStats();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
                            assertNull(remoteState.getLastAcceptedState());
        Set<String> followingCMs = clusterManagers.stream().filter(node -> !Objects.equals(node, activeCM)).collect(Collectors.toSet());
        return pluginsServices.iterator()  
            .get();
        prepareCluster(3, 2, Settings.EMPTY);
        // create cluster with multi node (3 master + 2 data)
                    if (actions.contains(action)) {
            .prepareUpdateSettings()  
                            PersistedStateRegistry.PersistedStateType.REMOTE
        NodesStatsResponse nodesStatsResponse = client().admin()
import org.apache.logging.log4j.LogManager;
        followingCMs.forEach(node -> {  
        ClusterMetadataManifest manifest = remotePersistedState.getLastAcceptedManifest();
            .get();
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
            .admin()
        // coordination metadata is updated, it will be unequal  
            actions.clear();
                            ClusterState remotePersistedState = remoteState.getLastAcceptedState();
            .prepareUpdateSettings()
import java.util.Collection;
        return Settings.builder()  
            .get();
            String executor,
            @Override
            .get();
        clearInterceptedActions();
            .get().instance.getRequestCount(action);
import org.opensearch.plugins.PluginsService;  
        public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
            PublishClusterStateStats stats = nodeStats.getDiscoveryStats().getPublishStats();  
            .put(REMOTE_PUBLICATION_SETTING_KEY, isRemotePublicationEnabled)  
        assertTrue(ephemeralMetadataFiles.containsKey(DISCOVERY_NODES));  
                        .get();
            .prepareNodesStats(dataNode)
            0,
    public void testRemotePublicationDisableIfRemoteStateDisabled() {  
                assertEquals(
/*  
                RemoteClusterStateService.REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING.getKey(),
            )
        }
                .getExtendedFields()
        // assert here that NodeStats.discovery.remote_diff_download.failed_count is 0 for any/all node
        assertDataNodeDownloadStats(nodesStatsResponseDataNode.getNodes().get(0));  
            .put(  
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
        ensureStableCluster(5);
        String routingTableRepoTypeAttributeKey = String.format(
            .add(getClusterState().metadata().clusterUUID())
    public static class InterceptingTransportService implements TransportInterceptor {
            Locale.getDefault(),
                    // if masterRestarted is true Publication Setting should be false, and vice versa
                .get(1)
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);  
        RemoteClusterStateService remoteClusterStateService = internalCluster().getInstance(
                .updateSettings(
        }  
    }  
                            assertNull(remoteState.getLastAcceptedManifest());  
        // add two new nodes to the cluster, to update the voting config
        response.getNodes().forEach(nodeStats -> {
        isRemotePublicationEnabled = false;  
    private void assertDataNodeDownloadStats(NodeStats nodeStats) {  
                }
                        .cluster()  
        for (String clusterManager : clusterManagers) {
        NodesStatsResponse response = internalCluster().client()
        synchronized Integer getRequestCount(String action) {
import org.opensearch.common.settings.Settings;
            List<PersistedStateStats> persistenceStats = node.getDiscoveryStats().getClusterStateStats().getPersistenceStats();
        hasRemoteRoutingCharPrefix = randomBoolean();  
        ensureStableCluster(4);
        if (hasRemoteRoutingCharPrefix) {
            assertNull(remoteState.getLastAcceptedManifest());
        // assert cluster is stable, ensuring publication falls back to legacy transport with inconsistent settings
        for (PluginsService pluginsService : pluginsServices) {
        // enable remote publication
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 2));
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
                    .encodeToString(getClusterState().getClusterName().value().getBytes(StandardCharsets.UTF_8))
            @Override
    }
    @LockFeatureFlag(STREAM_TRANSPORT)  
import org.opensearch.cluster.coordination.PersistedStateStats;
                            assertEquals(0, stats.getPublishStats().getCompatibleClusterStateDiffReceivedCount());  
    public void testPublication() throws Exception {
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
        createIndex(INDEX_NAME + "2", remoteStoreIndexSettings(1, 2));
            CoordinationState.PersistedState remoteState = registry.getPersistedState(PersistedStateRegistry.PersistedStateType.REMOTE);
            }
                            ClusterState localState = registry.getPersistedState(PersistedStateRegistry.PersistedStateType.LOCAL)
        assertTrue(globalMetadataFiles.containsKey(TEMPLATES_METADATA));  
    }
        prepareCluster(3, 2, INDEX_NAME, 1, 2);
            }
import static org.opensearch.gateway.remote.RemoteDownloadStats.CHECKSUM_VALIDATION_FAILED_COUNT;
            .cluster()
            .addMetric(SETTINGS.metricName())
            .admin()  
import java.util.List;  
        ) {
        ensureStableCluster(5);  
            CoordinationState.PersistedState localState = persistedStateRegistry.getPersistedState(  
            routingTableRepoName  
    private boolean hasRemoteRoutingCharPrefix;
                PersistedStateRegistry.PersistedStateType.REMOTE
        assertEquals(manifest.getIndicesRouting(), manifestAfterElection.getIndicesRouting());  
        assertTrue(getRequestCount(PUBLISH_STATE_ACTION_NAME) > 0);  
                .admin()  
import org.opensearch.transport.TransportRequestHandler;  
                Base64.getUrlEncoder()
            .get();
                    NodesInfoResponse nodesInfoResponse = client().admin()
        persistedStateRegistry = internalCluster().getClusterManagerNodeInstance(PersistedStateRegistry.class);  
            for (UploadedIndexMetadata md : manifest.getIndicesRouting()) {  
                        Settings.builder().put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "10mb").build()
            .cluster()  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
                RemoteRoutingTableBlobStore.CLUSTER_REMOTE_STORE_ROUTING_TABLE_PATH_PREFIX.getKey(),
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, false).build())
        assertTrue(dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(1).getSuccessCount() > 0);  
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.DISCOVERY;
                        } else {
        plugins.add(StreamSearchIntegrationTests.MockStreamTransportPlugin.class);
        ensureStableCluster(5);
                    return Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, false).build();
            .cluster()
                        } else {  
                .clearInterceptedActions();
                PersistedStateRegistry.PersistedStateType.LOCAL
import static org.hamcrest.Matchers.startsWith;
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        }  
                    remoteState.getLastAcceptedState().getLastCommittedConfiguration()  
            requests.clear();  
    public void testRemotePublicationDownloadStats() {
import org.opensearch.action.search.StreamSearchIntegrationTests;
        assertTrue(globalMetadataFiles.containsKey(COORDINATION_METADATA));  
        internalCluster().client()
import static org.opensearch.gateway.remote.RemotePersistenceStats.FULL_DOWNLOAD_STATS;
            .add(subDirectory);
        // disable remote publication
            dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(1).getTotalTimeInMillis(),  
            .clear()  
import static org.opensearch.cluster.coordination.PublicationTransportHandler.PUBLISH_STATE_ACTION_NAME;  
import org.opensearch.gateway.GatewayMetaState;  
            String refreshSetting = response.getState()
            .admin()
                .filter(
import org.opensearch.transport.TransportChannel;  
        assertEquals(0, dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(1).getFailedCount());
        int clusterManagerNodeCount = 1;
        );
                        .cluster()  
    public void testVotingConfigAreCommitted() throws ExecutionException, InterruptedException {  
import org.opensearch.cluster.coordination.CoordinationState;  
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);  
                            assertEquals(localState.nodes(), remotePersistedState.nodes());  
        ensureStableCluster(5);
import org.junit.Before;
        assertTrue(getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME) > 0);
            .addMetric(DISCOVERY.metricName())  
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 2));  
                    });  
        assertEquals(manifest.getIndices(), manifestAfterElection.getIndices());
            .cluster()  
        internalCluster().client()  
            public final InterceptingTransportService instance = new InterceptingTransportService();
                }  
        internalCluster().rollingRestart(new InternalTestCluster.RestartCallback() {  
    }  
                RemoteClusterStateService.CLUSTER_REMOTE_STORE_STATE_PATH_PREFIX.getKey(),
    public void testRemotePublicationSettingChangePersistedAfterFullRestart() throws Exception {  
            public List<TransportInterceptor> getTransportInterceptors(
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, false).build())
import org.opensearch.transport.TransportInterceptor;
import java.util.stream.Collectors;
            .cluster()
        // get settings from each node and verify that it is updated
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.plugins.NetworkPlugin;
            Locale.getDefault(),
        isRemotePublicationEnabled = false;
            dataNodeDiscoveryStats.getClusterStateStats()
            private final TransportRequestHandler<T> handler;
        createIndex("index-3");  
                    localState.getLastAcceptedState().getLastCommittedConfiguration(),
        int dataNodeCount = shardCount * (replicaCount + 1);
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING;
                hasRemoteRoutingCharPrefix ? REMOTE_ROUTING_PREFIX : ""  
                .stream()  
                    .withoutPadding()  
                @Override
        }
                .get(CHECKSUM_VALIDATION_FAILED_COUNT)  
            .clear()
        ensureGreen(INDEX_NAME);
        ClusterMetadataManifest manifest = remoteClusterStateService.getLatestClusterMetadataManifest(  
        prepareCluster(3, 2, Settings.EMPTY);
    }
    private static void clearInterceptedActions() {  
            greaterThanOrEqualTo(0L)  
            greaterThanOrEqualTo(0L)
        assertEquals(  
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        ensureStableCluster(7);  
    }  
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;
    public void testRemotePublicationDisabledByRollingRestart() throws Exception {  
package org.opensearch.gateway.remote;
        // only disable remote state
        ).index("index-1");
            repository,
        );
 * SPDX-License-Identifier: Apache-2.0
        for (NodeStats node : nodesStatsResponse.getNodes()) {  
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);  
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
        assertEquals(manifest.getCustomMetadataMap(), manifestAfterElection.getCustomMetadataMap());
            .admin()
        Set<String> clusterManagers = internalCluster().getClusterManagerNames();
            .get();  
import java.util.Map;
    public void setup() {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        ensureGreen(INDEX_NAME);  
        );
        });
    public void testRemotePublicationSettingChangePersistedAfterRestart() throws Exception {
        IndicesAliasesRequest.AliasActions aliasAction = new IndicesAliasesRequest.AliasActions(IndicesAliasesRequest.AliasActions.Type.ADD)  
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
            .addMetric(DISCOVERY.metricName())
                this.handler = handler;
            RemoteClusterStateService.class
    public void testMasterReElectionUsesIncrementalUpload() throws IOException {
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, true).build())  
        });
                            assertEquals(localState.customs(), remotePersistedState.customs());
                            assertEquals(localState.routingTable(), remotePersistedState.routingTable());
                handler.messageReceived(request, channel, task);
            .cluster()
        asyncUploadMockFsRepo = false;
        assertTrue(ephemeralMetadataFiles.containsKey(CLUSTER_BLOCKS));
        );
        internalCluster().startClusterManagerOnlyNodes(2, Settings.EMPTY);
                .get(0)  
        }  
import java.util.HashSet;
        // disable remote publication
                        .collect(Collectors.toSet());  
        assertTrue(getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME) > 0);  
            }  
        assertTrue(getRequestCount(PUBLISH_STATE_ACTION_NAME) > 0);
                public Settings onNodeStopped(String nodeName) {
            discoveryStats.getClusterStateStats()
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);
            .nodesStats(new NodesStatsRequest().addMetric(DISCOVERY.metricName()))
                .get()  
    }
            .get();
                interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);  
        NodesStatsResponse response = client().admin()
import java.util.concurrent.ExecutionException;
        assertThat(manifest.getIndices().size(), is(1));
        assertEquals(0, dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(0).getFailedCount());  
            dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(0).getTotalTimeInMillis(),
import java.util.ArrayList;  
    }
            .admin()  
            .put(routingTableRepoTypeAttributeKey, ReloadableFsRepository.TYPE)
            logger.info(fileName);
        assertEquals(0, (int) getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME));
        ensureGreen(INDEX_NAME);  
            return requests.getOrDefault(action, 0);  
import java.util.HashMap;
        assertNotNull(dataNodeDiscoveryStats.getClusterStateStats());  
        ensureGreen(INDEX_NAME);
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            .add(
            .actionGet();
        ClusterMetadataManifest manifestAfterElection = persistedStateAfterElection.getLastAcceptedManifest();
import static org.opensearch.gateway.remote.RemotePersistenceStats.DIFF_DOWNLOAD_STATS;  
    }
                                stats.getFullClusterStateReceivedCount() > 0 || stats.getCompatibleClusterStateDiffReceivedCount() > 0
            )
    @Override
import org.opensearch.repositories.fs.ReloadableFsRepository;
import static org.opensearch.gateway.remote.model.RemoteClusterBlocks.CLUSTER_BLOCKS;
        GatewayMetaState.RemotePersistedState remotePersistedState = (GatewayMetaState.RemotePersistedState) persistedStateRegistry
        Map<String, Integer> manifestFiles = getMetadataFiles(repository, RemoteClusterMetadataManifest.MANIFEST);
                .metadata()
            .put(routingTableRepoSettingsAttributeKeyPrefix + "location", segmentRepoPath)  
        );
                        .addMetric(DISCOVERY.metricName())  
import static org.opensearch.action.admin.cluster.node.info.NodesInfoRequest.Metric.SETTINGS;  
                        );  
        }  
            RemoteClusterStateService.class,  
                            assertTrue(  
        // force elected master to step down
        public static class TestPlugin extends Plugin implements NetworkPlugin {
            InterceptingHandler(String action, TransportRequestHandler<T> handler) {
        assertThat(
        clearInterceptedActions();
        );
                    restartedMasters.add(nodeName);  
            @Override
        assertTrue(getRequestCount(PUBLISH_STATE_ACTION_NAME) > 0);
                .get(CHECKSUM_VALIDATION_FAILED_COUNT)
    public void testPublicationIndexAlias() throws Exception {
            .stream()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        BlobPath metadataPath = repository.basePath()  
 */  
    }
        IndicesAliasesRequest.AliasActions remoteIndexAction = new IndicesAliasesRequest.AliasActions(  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;  
        assertTrue(getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME) > 0);
        // if masterRestarted is true Publication Setting should be false, and vice versa  
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;  
            PersistedStateRegistry registry = internalCluster().getInstance(PersistedStateRegistry.class, node);
        // update settings on a random node  
        prepareCluster(3, 2, INDEX_NAME, 1, 1);  
            .build();
    }  
            RemoteClusterStateUtils.CLUSTER_STATE_EPHEMERAL_PATH_TOKEN
            .add(RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN)  
                .getExtendedFields()
        assertTrue(globalMetadataFiles.containsKey(TRANSIENT_SETTING_METADATA));
            .clear()  
        });
        );  
                public void doAfterNodes(int n, Client client) {
                assertThat(md.getUploadedFilename(), startsWith(REMOTE_STATE_PREFIX));
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
            .cluster()
        // create cluster with multi node with in-consistent settings  
import java.util.Collections;  
                    )
            dataNodeDiscoveryStats.getClusterStateStats()
                .getPersistenceStats()  
    }
            .index("index-2")
                        .addMetric(SETTINGS.metricName())  
        String dataNode = internalCluster().getDataNodeNames().stream().collect(Collectors.toList()).get(0);
            TransportRequestHandler<T> actualHandler  
        if (hasRemoteStateCharPrefix) {
        internalCluster().client()
        });
import java.util.Locale;
            .put(RemoteIndexMetadataManager.REMOTE_INDEX_METADATA_PATH_TYPE_SETTING.getKey(), PathType.HASHED_PREFIX.toString())
        synchronized void clearInterceptedActions() {
        internalCluster().client()  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;  
            .put(super.nodeSettings(nodeOrdinal))
        PersistedStateRegistry persistedStateRegistry = internalCluster().getClusterManagerNodeInstance(PersistedStateRegistry.class);
        assertEquals(0, (int) getRequestCount(PUBLISH_STATE_ACTION_NAME));
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, true).build())  
        prepareCluster(3, 2, Settings.EMPTY);
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
                            assertEquals(0, stats.getPublishStats().getIncompatibleClusterStateDiffReceivedCount());
        assertEquals(manifest.getTemplatesMetadata(), manifestAfterElection.getTemplatesMetadata());  
import static org.hamcrest.Matchers.is;
        assertEquals(0, (int) getRequestCount(PUBLISH_STATE_ACTION_NAME));
        for (Client client : clients()) {
            }
        );
                        .clear()
import static org.opensearch.cluster.metadata.Metadata.isGlobalStateEquals;
                        if (activeCMRestarted) {
        // disable remote publication  
    }
        ).get();  
            .getPersistedState(PersistedStateRegistry.PersistedStateType.REMOTE);  
        hasRemoteStateCharPrefix = randomBoolean();
                    followingCMs.forEach(node -> {
            }
        IndicesAliasesRequest request = new IndicesAliasesRequest(); // <1>
    private static Integer getRequestCount(String action) {
                    response.getNodes().forEach(nodeStats -> {  
        });
            )  
                    String activeCM = internalCluster().getClusterManagerName();  
    }
            public void doAfterNodes(int n, Client client) {
        assertEquals(0, (int) getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME));
 * The OpenSearch Contributors require contributions made to  
        assertEquals(manifest.getRoutingTableVersion(), manifest.getRoutingTableVersion());
    private static final String INDEX_NAME = "test-index";
        private final Map<String, Integer> requests = new HashMap<>();
}
            .get();
                .settings()  
            private final String action;
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());  
    }
import org.opensearch.tasks.Task;
        assertTrue(globalMetadataFiles.containsKey(SETTING_METADATA));
        ensureGreen(INDEX_NAME);
            return fileName.split(DELIMITER)[0];
                }  
                    persistedStateStats -> persistedStateStats.getStatsName().equals(FULL_DOWNLOAD_STATS)
            .get();
        String routingTableRepoSettingsAttributeKeyPrefix = String.format(  
        assertThat(
            for (UploadedIndexMetadata md : manifest.getIndices()) {  
    protected Settings nodeSettings(int nodeOrdinal) {
        // assert cluster state stats for data node
            }
                            assertTrue(isGlobalStateEquals(localState.metadata(), remotePersistedState.metadata()));
        plugins.add(InterceptingTransportService.TestPlugin.class);
                .interceptTransportActions(actions);  
                );
        assertEquals(manifest.getSettingsMetadata(), manifestAfterElection.getSettingsMetadata());
            .filterPlugins(InterceptingTransportService.TestPlugin.class)
        }
                    assertEquals(0, persistedStateStats.getFailedCount());
        NodesStatsResponse nodesStatsResponseDataNode = client().admin()  
        assertTrue(globalMetadataFiles.keySet().stream().anyMatch(key -> key.startsWith(CUSTOM_METADATA)));
                    new ClusterUpdateSettingsRequest().persistentSettings(  
        private class InterceptingHandler<T extends TransportRequest> implements TransportRequestHandler<T> {  
                            );
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;  
        ensureStableCluster(5);
import org.opensearch.common.util.concurrent.ThreadContext;  
            .cluster()
        assertEquals(manifest.getClusterUUID(), manifestAfterElection.getClusterUUID());  
        createIndex("index-2");
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), isRemoteStateEnabled)
                .getPersistenceStats()
        request.addAliasAction(remoteIndexAction);  
        );
                ThreadContext threadContext
            internalCluster().getClusterManagerName()
                assertThat(md.getUploadedFilename(), startsWith(REMOTE_ROUTING_PREFIX));
                .actionGet()
        prepareCluster(3, 2, INDEX_NAME, 1, 2);  
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
        response.getNodes().forEach(nodeStats -> {  
        assertTrue(dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(0).getSuccessCount() > 0);
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
import org.opensearch.discovery.DiscoveryStats;
import org.opensearch.plugins.Plugin;
            .prepareUpdateSettings()
        assertAcked(
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, true).build())
    }  
            routingTableRepoName
                        if (activeCMRestarted) {
                if (FULL_DOWNLOAD_STATS.equals(statsName) || DIFF_DOWNLOAD_STATS.equals(statsName)) {
public class RemoteStatePublicationIT extends RemoteStoreBaseIntegTestCase {
        }
                        }  
        RemoteClusterStateService remoteClusterStateService = internalCluster().getCurrentClusterManagerNodeInstance(  
        );
            .prepareUpdateSettings()
        assertTrue(manifestFiles.containsKey(RemoteClusterMetadataManifest.MANIFEST));  
            for (PersistedStateStats persistedStateStats : persistenceStats) {
        Set<String> restartedMasters = new HashSet<>();  
import org.opensearch.gateway.remote.model.RemoteClusterMetadataManifest;
        assertTrue(getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME) > 0);
                        .filter(node -> !Objects.equals(node, activeCM))
                        .prepareNodesStats(followingCMs.toArray(new String[0]))
        ensureGreen(INDEX_NAME);
        Map<String, Integer> ephemeralMetadataFiles = getMetadataFiles(  
            }
            )
        assertEquals(0, (int) getRequestCount(PUBLISH_STATE_ACTION_NAME));  
        ensureGreen(INDEX_NAME + "2");
        // all other attributes are not uploaded again and will be pointing to same files in manifest after new master is elected
        // enable remote publication
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);  
                        .prepareNodesInfo(activeCM)
        prepareCluster(3, 2, INDEX_NAME, 1, 2);
                    assertTrue(REMOTE_PUBLICATION_SETTING.get(nodesInfoResponse.getNodes().get(0).getSettings()) != activeCMRestarted);  
            boolean forceExecution,
            .put(
import org.opensearch.test.InternalTestCluster;  
        ensureStableCluster(5);  
        }).collect(Collectors.toMap(Function.identity(), key -> 1, Integer::sum));  
        request.addAliasAction(aliasAction);
                    }
                .get(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey());
        assertFalse(remoteClusterStateService.isRemotePublicationEnabled());
                        .clear()
import org.opensearch.indices.recovery.RecoverySettings;  
            IndicesAliasesRequest.AliasActions.Type.REMOVE_INDEX
            .cluster()
        ensureStableCluster(5);
        isRemoteStateEnabled = false;
        String activeCM = internalCluster().getClusterManagerName();  
                        .get();
            internalCluster().client()
            }
        @Override
            });  
                String statsName = persistedStateStats.getStatsName();  
        assertEquals(0, dataNodeDiscoveryStats.getClusterStateStats().getUpdateSuccess());
        );  
                assertEquals(5, remoteState.getLastAcceptedState().getLastCommittedConfiguration().getNodeIds().size());
            assertTrue(stats.getFullClusterStateReceivedCount() > 0 || stats.getCompatibleClusterStateDiffReceivedCount() > 0);
        ensureStableCluster(5);
                            PublishClusterStateStats stats = nodeStats.getDiscoveryStats().getPublishStats();
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        CoordinationState.PersistedState persistedStateAfterElection = persistedStateRegistry.getPersistedState(
            .get();
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
            );
                .get()
            ClusterStateResponse response = client.admin().cluster().prepareState().clear().setMetadata(true).get();  
        String routingTableRepoName = "remote-routing-repo";  
            if (remoteState != null) {  
import org.opensearch.cluster.ClusterState;
            getClusterState().getClusterName().value(),
                this.action = action;  
            pluginsService.filterPlugins(InterceptingTransportService.TestPlugin.class).stream().findFirst().get().instance  
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
            .findFirst()
        ensureGreen(INDEX_NAME);  
        ensureGreen(INDEX_NAME);  
        isRemoteStateEnabled = true;  
            .cluster()
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
        internalCluster().stopCurrentClusterManagerNode();  
            .put(
        ensureStableCluster(5);
        Settings settings = clusterService().getSettings();  
import static org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA;
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
                                .getLastAcceptedState();  
        internalCluster().fullRestart();
        assertFalse(REMOTE_PUBLICATION_SETTING.get(nodesInfoResponse.getNodes().get(0).getSettings()));
            .prepareUpdateSettings()
import org.opensearch.transport.client.Client;
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, routingTableRepoName)
                RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE  
        }
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;
import java.util.Objects;  
            .prepareNodesInfo(activeCM)
            getClusterState().metadata().clusterUUID()
 * compatible open source license.
        return plugins;  
            pluginsService.filterPlugins(InterceptingTransportService.TestPlugin.class).stream().findFirst().get().instance
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
                .getPersistenceStats()
        createIndex("index-1");
                @Override
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 2));
            .prepareNodesStats(followingCMs.toArray(new String[0]))
            return new InterceptingTransportService.InterceptingHandler<>(action, actualHandler);
    }
        int shardCount = randomIntBetween(1, 2);
        NodesInfoResponse nodesInfoResponse = client().admin()  
    }
        clearInterceptedActions();  
        synchronized void interceptTransportActions(String... actions) {  
                            DiscoveryStats stats = nodeStats.getDiscoveryStats();
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.DISCOVERY_NODES;  
            String action,  
        }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                        CoordinationState.PersistedState remoteState = registry.getPersistedState(
        ensureGreen(INDEX_NAME + "2");
            0,  
            )  
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
                        logger.info("intercepted action: {} count: {}", action, requestCount + 1);
                            assertEquals(0, stats.getPublishStats().getFullClusterStateReceivedCount());
                NamedWriteableRegistry namedWriteableRegistry,  
                return Collections.singletonList(instance);  
import java.util.Set;
 *
        clearInterceptedActions();  
    }
                PathHashAlgorithm.FNV_1A_COMPOSITE_1.toString()
            .cluster()  
                    assertEquals(0, persistedStateStats.getFailedCount());
        assertEquals(
        ensureStableCluster(5);
import org.opensearch.cluster.coordination.PublishClusterStateStats;  
        // create cluster with multi node (3 master + 2 data)
        assertNotEquals(manifest.getCoordinationMetadata(), manifestAfterElection.getCoordinationMetadata());
            ) {
                RemoteIndexMetadataManager.REMOTE_INDEX_METADATA_PATH_HASH_ALGO_SETTING.getKey(),
            assertEquals("10mb", refreshSetting);
        private final Set<String> actions = new HashSet<>();
import org.opensearch.cluster.coordination.PersistedStateRegistry;
        return repository.blobStore().blobContainer(metadataPath).listBlobs().keySet().stream().map(fileName -> {  
                )  
    private static final String REMOTE_STATE_PREFIX = "!";
            .alias("index-1");
        prepareCluster(3, 2, INDEX_NAME, 1, 2);
import org.opensearch.transport.TransportRequest;
    @Before  
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
                    // after master is flipped to restarted master, publication should happen on Transport
        internalCluster().client()
            .put(  
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;  
                        }
                .forEach(persistedStateStats -> {
            PersistedStateRegistry.PersistedStateType.REMOTE
        createIndex(INDEX_NAME + "2", remoteStoreIndexSettings(1, 2));  
        assertEquals(0, (int) getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME));
import java.io.IOException;
                        Integer requestCount = requests.getOrDefault(action, 0);
    private boolean hasRemoteStateCharPrefix;  
        prepareCluster(3, 2, INDEX_NAME, 1, 2);  
            .prepareNodesStats(internalCluster().getNodeNames())
import java.util.Base64;
            .next()
            // ensure none of the nodes received remote publication  
    private static final String REMOTE_ROUTING_PREFIX = "_";  
            public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertEquals(0, (int) getRequestCount(PUBLISH_STATE_ACTION_NAME));  
 * this file be licensed under the Apache-2.0 license or a
        }
import org.opensearch.gateway.remote.model.RemoteRoutingTableBlobStore;  
            DiscoveryStats discoveryStats = nodeStats.getDiscoveryStats();
            assertNotNull(discoveryStats.getClusterStateStats());
        Map<String, Integer> globalMetadataFiles = getMetadataFiles(repository, RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN);
    private static void interceptTransportActions(String... actions) {
    public void testRemotePublicationEnabledAfterSettingChange() {
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        for (PluginsService pluginsService : pluginsServices) {
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 2));
    private boolean isRemotePublicationEnabled = true;
            assertNull(remoteState.getLastAcceptedState());  
