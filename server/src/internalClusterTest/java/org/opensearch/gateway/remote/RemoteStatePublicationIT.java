        ensureGreen(INDEX_NAME);
import org.opensearch.common.blobstore.BlobPath;
                .updateSettings(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), isRemoteStateEnabled)
            return new InterceptingTransportService.InterceptingHandler<>(action, actualHandler);
        ensureStableCluster(5);
        ).get();
        isRemoteStateEnabled = false;
                        logger.info("intercepted action: {} count: {}", action, requestCount + 1);
        return Settings.builder()
import java.nio.charset.StandardCharsets;
        assertEquals(manifest.getRoutingTableVersion(), manifest.getRoutingTableVersion());
        assertDataNodeDownloadStats(nodesStatsResponseDataNode.getNodes().get(0));
                    persistedStateStats -> persistedStateStats.getStatsName().equals(FULL_DOWNLOAD_STATS)
    }
                );
                    Set<String> followingCMs = clusterManagers.stream()
    }
        assertEquals(manifest.getClusterUUID(), manifestAfterElection.getClusterUUID());
        int shardCount = randomIntBetween(1, 2);
            String refreshSetting = response.getState()
            .put(super.nodeSettings(nodeOrdinal))
import org.opensearch.transport.TransportRequestHandler;
    public void testPublication() throws Exception {
                RemoteClusterStateService.CLUSTER_REMOTE_STORE_STATE_PATH_PREFIX.getKey(),
                RemoteClusterStateService.RemoteClusterStateValidationMode.FAILURE
        // enable remote publication
            for (UploadedIndexMetadata md : manifest.getIndices()) {
        assertTrue(getRequestCount(PUBLISH_STATE_ACTION_NAME) > 0);
                            assertEquals(0, stats.getPublishStats().getIncompatibleClusterStateDiffReceivedCount());
                .cluster()
import java.util.HashMap;
            return fileName.split(DELIMITER)[0];
        // create cluster with multi node (3 master + 2 data)
                hasRemoteStateCharPrefix ? REMOTE_STATE_PREFIX : ""
            assertNull(remoteState.getLastAcceptedManifest());
import org.opensearch.cluster.coordination.CoordinationState;
        createIndex("index-1");
                if (FULL_DOWNLOAD_STATS.equals(statsName) || DIFF_DOWNLOAD_STATS.equals(statsName)) {
            }
            getClusterState().metadata().clusterUUID()
import static org.hamcrest.Matchers.startsWith;
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            for (PersistedStateStats persistedStateStats : persistenceStats) {
            .nodesStats(new NodesStatsRequest().addMetric(DISCOVERY.metricName()))
        );
                    });
                @Override
    private static Integer getRequestCount(String action) {
                        } else {
        ensureStableCluster(5);
import java.util.concurrent.ExecutionException;
            .cluster()
        ClusterMetadataManifest manifest = remotePersistedState.getLastAcceptedManifest();
        ensureStableCluster(5);
    public void testRemotePublicationSettingChangePersistedAfterFullRestart() throws Exception {
                                stats.getFullClusterStateReceivedCount() > 0 || stats.getCompatibleClusterStateDiffReceivedCount() > 0
                        if (activeCMRestarted) {
            .next()
}
            private final Logger logger = LogManager.getLogger(InterceptingHandler.class);
                    NodesInfoResponse nodesInfoResponse = client().admin()
        );
    }
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;
        // update settings on a random node
        Map<String, Integer> manifestFiles = getMetadataFiles(repository, RemoteClusterMetadataManifest.MANIFEST);
            .admin()
            .get();
import org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;
        }
import static org.opensearch.gateway.remote.model.RemoteTransientSettingsMetadata.TRANSIENT_SETTING_METADATA;
        prepareCluster(clusterManagerNodeCount, dataNodeCount, INDEX_NAME, replicaCount, shardCount);
import org.opensearch.remotestore.RemoteStoreBaseIntegTestCase;
                        if (activeCMRestarted) {
            pluginsService.filterPlugins(InterceptingTransportService.TestPlugin.class).stream().findFirst().get().instance
        // assert here that NodeStats.discovery.remote_diff_download.failed_count is 0 for any/all node
                    }
    }
            .admin()
        ensureStableCluster(5);
        // if masterRestarted is true Publication Setting should be false, and vice versa
        });
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            .filterPlugins(InterceptingTransportService.TestPlugin.class)
            .put(
            dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(0).getTotalTimeInMillis(),
                this.action = action;
    @Override
            boolean forceExecution,
            .cluster()
            .prepareNodesInfo(activeCM)
        synchronized Integer getRequestCount(String action) {
import java.util.Collection;
import org.opensearch.discovery.DiscoveryStats;
        internalCluster().client()
        assertEquals(manifest.getCustomMetadataMap(), manifestAfterElection.getCustomMetadataMap());
            requests.clear();
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
            .prepareUpdateSettings()
                .get(0)
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 2));
            .cluster()
        ensureStableCluster(5);
            .clear()
        String routingTableRepoName = "remote-routing-repo";
                RemoteRoutingTableBlobStore.CLUSTER_REMOTE_STORE_ROUTING_TABLE_PATH_PREFIX.getKey(),
                .clearInterceptedActions();
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, routingTableRepoName)
                .getExtendedFields()
        for (PluginsService pluginsService : pluginsServices) {
        assertEquals(manifest.getIndicesRouting(), manifestAfterElection.getIndicesRouting());
                .actionGet()
                    .encodeToString(getClusterState().getClusterName().value().getBytes(StandardCharsets.UTF_8))
    public void testRemotePublicationDownloadStats() {
import org.opensearch.plugins.NetworkPlugin;
            if (remoteState != null) {
                .get(1)
        assertEquals(0, (int) getRequestCount(PUBLISH_STATE_ACTION_NAME));
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
        isRemotePublicationEnabled = false;
    private void assertDataNodeDownloadStats(NodeStats nodeStats) {
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
            }
            String action,
 *
        internalCluster().stopCurrentClusterManagerNode();
            .cluster()
        assertTrue(getRequestCount(PUBLISH_STATE_ACTION_NAME) > 0);
    }
        ) {
            .get();
        NodesStatsResponse response = client().admin()
    public void testRemotePublicationDisableIfRemoteStateDisabled() {
        clearInterceptedActions();
                    assertEquals(0, persistedStateStats.getTotalTimeInMillis());
        assertNotEquals(manifest.getCoordinationMetadata(), manifestAfterElection.getCoordinationMetadata());
        assertFalse(remoteClusterStateService.isRemotePublicationEnabled());
            return requests.getOrDefault(action, 0);
 * SPDX-License-Identifier: Apache-2.0
        // disable remote publication
        internalCluster().client()
        ensureGreen(INDEX_NAME);
            .put(
        Settings settings = clusterService().getSettings();
import org.opensearch.cluster.coordination.PersistedStateRegistry;
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
                    remoteState.getLastAcceptedState().getLastCommittedConfiguration()
            .put(
            .prepareNodesStats(followingCMs.toArray(new String[0]))
        String dataNode = internalCluster().getDataNodeNames().stream().collect(Collectors.toList()).get(0);
        createIndex(INDEX_NAME + "2", remoteStoreIndexSettings(1, 2));
    public static class InterceptingTransportService implements TransportInterceptor {
        ClusterMetadataManifest manifestAfterElection = persistedStateAfterElection.getLastAcceptedManifest();
import static org.opensearch.common.util.FeatureFlags.STREAM_TRANSPORT;
            .findFirst()
import org.opensearch.action.search.StreamSearchIntegrationTests;
            actions.clear();
            .prepareUpdateSettings()
        public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
        prepareCluster(3, 2, Settings.EMPTY);
        assertEquals(0, dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(1).getFailedCount());
                )
            PersistedStateRegistry.PersistedStateType.REMOTE
            .get();
                                .getLastAcceptedState();
                        .clear()
        if (hasRemoteStateCharPrefix) {
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
            @Override
        asyncUploadMockFsRepo = false;
                .interceptTransportActions(actions);
        ensureGreen(INDEX_NAME);
        }
        private final Set<String> actions = new HashSet<>();
            public final InterceptingTransportService instance = new InterceptingTransportService();
        for (PluginsService pluginsService : pluginsServices) {
        GatewayMetaState.RemotePersistedState remotePersistedState = (GatewayMetaState.RemotePersistedState) persistedStateRegistry
                PersistedStateRegistry.PersistedStateType.REMOTE
            .put(RemoteIndexMetadataManager.REMOTE_INDEX_METADATA_PATH_TYPE_SETTING.getKey(), PathType.HASHED_PREFIX.toString())
                            assertEquals(localState.customs(), remotePersistedState.customs());
    public void testRemotePublicationDisabledAfterSettingChange() throws ExecutionException, InterruptedException {
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
                RemoteIndexMetadataManager.REMOTE_INDEX_METADATA_PATH_HASH_ALGO_SETTING.getKey(),
                    followingCMs.forEach(node -> {
                            assertEquals(0, stats.getPublishStats().getCompatibleClusterStateDiffReceivedCount());
            internalCluster().restartNode(clusterManager, new InternalTestCluster.RestartCallback() {
            }
            )
        ensureStableCluster(5);
import org.opensearch.cluster.coordination.PersistedStateStats;
            0,
                        requests.put(action, requestCount + 1);
    public void testMasterReElectionUsesIncrementalUpload() throws IOException {
    protected Settings nodeSettings(int nodeOrdinal) {
        persistedStateRegistry = internalCluster().getClusterManagerNodeInstance(PersistedStateRegistry.class);
import org.opensearch.common.util.concurrent.ThreadContext;
                )
            .cluster()
            .prepareNodesStats(dataNode)
        // add two new nodes to the cluster, to update the voting config
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
import static org.hamcrest.Matchers.is;
    }
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, false).build())
                .get()
                PersistedStateRegistry.PersistedStateType.LOCAL
            .get();
import static org.opensearch.gateway.remote.model.RemoteCustomMetadata.CUSTOM_METADATA;
        }
    @LockFeatureFlag(STREAM_TRANSPORT)
    private boolean isRemotePublicationEnabled = true;
        @Override
            );
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
            assertNotNull(discoveryStats.getClusterStateStats());
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
        request.addAliasAction(aliasAction);
        RemoteClusterStateService remoteClusterStateService = internalCluster().getCurrentClusterManagerNodeInstance(
            .alias("index-1");
        ensureStableCluster(5);
 * compatible open source license.
            dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(1).getTotalTimeInMillis(),
                        .cluster()
        return plugins;
        ensureGreen(INDEX_NAME);
                ThreadContext threadContext
    }
                    localState.getLastAcceptedState().getLastCommittedConfiguration(),
            .addMetric(DISCOVERY.metricName())
        clearInterceptedActions();
                            assertEquals(localState.routingTable(), remotePersistedState.routingTable());
        }
            .admin()
            .clear()
        );
            .stream()
        return repository.blobStore().blobContainer(metadataPath).listBlobs().keySet().stream().map(fileName -> {
        assertThat(
            dataNodeDiscoveryStats.getClusterStateStats()
        }
        plugins.add(StreamSearchIntegrationTests.MockStreamTransportPlugin.class);
    @Before
            )
                        .cluster()
        NodesStatsResponse response = internalCluster().client()
        );
            .addMetric(DISCOVERY.metricName())
        prepareCluster(3, 2, INDEX_NAME, 1, 2);
        synchronized void clearInterceptedActions() {
            .build();
    private static void clearInterceptedActions() {
    private static void interceptTransportActions(String... actions) {
            IndicesAliasesRequest.AliasActions.Type.REMOVE_INDEX
        clearInterceptedActions();
 * The OpenSearch Contributors require contributions made to
            .put(routingTableRepoSettingsAttributeKeyPrefix + "location", segmentRepoPath)
                        .get();
        // enable remote publication
                            );
            @Override
        prepareCluster(3, 2, Settings.EMPTY);
            .put(REMOTE_PUBLICATION_SETTING_KEY, isRemotePublicationEnabled)
        ClusterMetadataManifest manifest = remoteClusterStateService.getLatestClusterMetadataManifest(
    public void testPublicationIndexAlias() throws Exception {
        internalCluster().fullRestart();
    @Override
        assertTrue(globalMetadataFiles.containsKey(SETTING_METADATA));
        ensureGreen(INDEX_NAME);
            TransportRequestHandler<T> actualHandler
            Locale.getDefault(),
import java.util.HashSet;
                        .prepareNodesInfo(activeCM)
                @Override
            .cluster()
                .metadata()
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        Set<String> clusterManagers = internalCluster().getClusterManagerNames();
                    // if masterRestarted is true Publication Setting should be false, and vice versa
        isRemotePublicationEnabled = true;
                        Settings.builder().put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "10mb").build()
                    assertTrue(REMOTE_PUBLICATION_SETTING.get(nodesInfoResponse.getNodes().get(0).getSettings()) != activeCMRestarted);
import static org.opensearch.cluster.metadata.Metadata.isGlobalStateEquals;
import org.opensearch.transport.TransportChannel;
    }
        for (String clusterManager : clusterManagers) {
import static org.opensearch.cluster.coordination.PublicationTransportHandler.PUBLISH_REMOTE_STATE_ACTION_NAME;
        }
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, true).build())
        }
    private Map<String, Integer> getMetadataFiles(BlobStoreRepository repository, String subDirectory) throws IOException {
        // create cluster with multi node with in-consistent settings
            .clear()
        });
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                assertEquals(5, remoteState.getLastAcceptedState().getLastCommittedConfiguration().getNodeIds().size());
                            assertEquals(0, stats.getPublishStats().getFullClusterStateReceivedCount());
        );
            dataNodeDiscoveryStats.getClusterStateStats()
        prepareCluster(3, 2, Settings.EMPTY);
                }
        internalCluster().client()
        // get settings from each node and verify that it is updated
            .prepareUpdateSettings()
            RemoteClusterStateUtils.CLUSTER_STATE_EPHEMERAL_PATH_TOKEN
            .addMetric(SETTINGS.metricName())
import java.io.IOException;
        }).collect(Collectors.toMap(Function.identity(), key -> 1, Integer::sum));
                    if (actions.contains(action)) {
            logger.info(fileName);
import static org.opensearch.cluster.coordination.PublicationTransportHandler.PUBLISH_STATE_ACTION_NAME;
        );
                        CoordinationState.PersistedState remoteState = registry.getPersistedState(
            private final TransportRequestHandler<T> handler;
import org.opensearch.repositories.fs.ReloadableFsRepository;
        RemoteClusterStateService remoteClusterStateService = internalCluster().getInstance(
        prepareCluster(3, 2, INDEX_NAME, 1, 2);
        ensureStableCluster(5);
        });
        internalCluster().getInstances(PersistedStateRegistry.class).forEach(persistedStateRegistry -> {
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
                            ClusterState localState = registry.getPersistedState(PersistedStateRegistry.PersistedStateType.LOCAL)
                assertThat(md.getUploadedFilename(), startsWith(REMOTE_ROUTING_PREFIX));
            .admin()
                }
        assertEquals(
        CoordinationState.PersistedState persistedStateAfterElection = persistedStateRegistry.getPersistedState(
import java.util.Set;
        IndicesAliasesRequest.AliasActions aliasAction = new IndicesAliasesRequest.AliasActions(IndicesAliasesRequest.AliasActions.Type.ADD)
                        .filter(node -> !Objects.equals(node, activeCM))
                        }
        assertEquals(
            routingTableRepoName
            .cluster()
        isRemoteStateEnabled = true;
            ) {
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            .get();
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, true).build())
import static org.opensearch.action.admin.cluster.node.info.NodesInfoRequest.Metric.SETTINGS;
            CoordinationState.PersistedState remoteState = registry.getPersistedState(PersistedStateRegistry.PersistedStateType.REMOTE);
            greaterThanOrEqualTo(0L)
                NamedWriteableRegistry namedWriteableRegistry,
        ensureGreen(INDEX_NAME + "2");
                RemoteClusterStateService.REMOTE_CLUSTER_STATE_CHECKSUM_VALIDATION_MODE_SETTING.getKey(),
            .index("index-2")
        prepareCluster(3, 2, INDEX_NAME, 1, 2);
                            PersistedStateRegistry.PersistedStateType.REMOTE
                            assertNull(remoteState.getLastAcceptedState());
        int replicaCount = 1;
                });
        response.getNodes().forEach(nodeStats -> {
                        .clear()
        ensureGreen(INDEX_NAME);
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
            );
            .get();
import org.apache.logging.log4j.Logger;
                public void doAfterNodes(int n, Client client) {
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, false).build())
            internalCluster().client()
                    response.getNodes().forEach(nodeStats -> {
        ensureGreen(INDEX_NAME + "2");
            internalCluster().getClusterManagerName()
        assertFalse(REMOTE_PUBLICATION_SETTING.get(nodesInfoResponse.getNodes().get(0).getSettings()));
        assertAcked(
        NodesStatsResponse nodesStatsResponse = client().admin()
        clearInterceptedActions();
        }
            }
        assertEquals(0, (int) getRequestCount(PUBLISH_STATE_ACTION_NAME));
        assertTrue(getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME) > 0);
        Set<String> followingCMs = clusterManagers.stream().filter(node -> !Objects.equals(node, activeCM)).collect(Collectors.toSet());
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
            CoordinationState.PersistedState localState = persistedStateRegistry.getPersistedState(
                    .withoutPadding()
        PersistedStateRegistry persistedStateRegistry = internalCluster().getClusterManagerNodeInstance(PersistedStateRegistry.class);
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
                    )
        assertEquals(0, (int) getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME));
import org.opensearch.indices.recovery.RecoverySettings;
                .get(CHECKSUM_VALIDATION_FAILED_COUNT)
                    NodesStatsResponse response = client().admin()
        String routingTableRepoSettingsAttributeKeyPrefix = String.format(
        assertThat(manifest.getIndices().size(), is(1));
        assertTrue(getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME) > 0);
    }
                .admin()
        assertThat(
            )
            routingTableRepoName
            )
        assertEquals(0, (int) getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME));
import java.util.function.Function;
                        }
                            assertTrue(isGlobalStateEquals(localState.metadata(), remotePersistedState.metadata()));
            .cluster()
                .get()
        assertTrue(globalMetadataFiles.keySet().stream().anyMatch(key -> key.startsWith(CUSTOM_METADATA)));
        assertEquals(0, (int) getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME));
            }
        createIndex("index-3");
    private boolean hasRemoteStateCharPrefix;
        ensureGreen(INDEX_NAME);
            }
import org.opensearch.transport.TransportRequest;
                            PublishClusterStateStats stats = nodeStats.getDiscoveryStats().getPublishStats();
                .settings()
            .admin()
                .getPersistenceStats()
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 2));
    private static final String INDEX_NAME = "test-index";
        assertTrue(getRequestCount(PUBLISH_STATE_ACTION_NAME) > 0);
            .admin()
                        );
        internalCluster().client()
        assertEquals(0, dataNodeDiscoveryStats.getClusterStateStats().getUpdateSuccess());
        ensureStableCluster(5);
            pluginsService.filterPlugins(InterceptingTransportService.TestPlugin.class).stream().findFirst().get().instance
            Locale.getDefault(),
                    assertEquals(0, persistedStateStats.getFailedCount());
    public void testRemotePublicationSettingChangePersistedAfterRestart() throws Exception {
    }
import org.opensearch.repositories.RepositoriesService;
                    new ClusterUpdateSettingsRequest().persistentSettings(
        String routingTableRepoTypeAttributeKey = String.format(
        }
import java.util.ArrayList;
        assertTrue(dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(1).getSuccessCount() > 0);
public class RemoteStatePublicationIT extends RemoteStoreBaseIntegTestCase {
import org.opensearch.test.InternalTestCluster;
            CoordinationState.PersistedState remoteState = persistedStateRegistry.getPersistedState(
                        .addMetric(SETTINGS.metricName())
            .cluster()
import org.opensearch.cluster.coordination.PublishClusterStateStats;
                        .addMetric(DISCOVERY.metricName())
        ensureGreen(INDEX_NAME);
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
                .getExtendedFields()
        });
        assertTrue(getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME) > 0);
        request.addAliasAction(remoteIndexAction);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 2));
        internalCluster().rollingRestart(new InternalTestCluster.RestartCallback() {
            .prepareNodesStats(internalCluster().getNodeNames())
            @Override
            .add(
        logger.info("settings : {}", settings);
                    boolean activeCMRestarted = restartedMasters.contains(activeCM);
        int clusterManagerNodeCount = 1;
                    assertEquals(0, persistedStateStats.getFailedCount());
        assertThat(manifest.getIndicesRouting().size(), is(1));
                synchronized (this) {
                    // after master is flipped to restarted master, publication should happen on Transport
import org.junit.Before;
        });
        // assert cluster state stats for data node
import org.opensearch.gateway.remote.model.RemoteClusterMetadataManifest;
        prepareCluster(3, 2, Settings.EMPTY);
        prepareCluster(3, 2, INDEX_NAME, 1, 2);
import org.opensearch.common.settings.Settings;
                        } else {
import org.opensearch.tasks.Task;
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, true).build())
        IndicesAliasesRequest.AliasActions remoteIndexAction = new IndicesAliasesRequest.AliasActions(
        RepositoriesService repositoriesService = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class);
        hasRemoteStateCharPrefix = randomBoolean();
            List<PersistedStateStats> persistenceStats = node.getDiscoveryStats().getClusterStateStats().getPersistenceStats();
        assertTrue(globalMetadataFiles.containsKey(COORDINATION_METADATA));
            public void doAfterNodes(int n, Client client) {
                .getPersistenceStats()
import org.opensearch.plugins.Plugin;
            String executor,
        );
            // ensure none of the nodes received remote publication
            .setPersistentSettings(Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, false).build())
        assertEquals(manifest.getTemplatesMetadata(), manifestAfterElection.getTemplatesMetadata());
                            assertEquals(localState.nodes(), remotePersistedState.nodes());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
            .actionGet();
import java.util.List;
                .get(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey());
    }
            0,
    }
            assertEquals("10mb", refreshSetting);
        internalCluster().client()
        // assert cluster is stable, ensuring publication falls back to legacy transport with inconsistent settings
            public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {
import static org.opensearch.gateway.remote.RemotePersistenceStats.DIFF_DOWNLOAD_STATS;
        ensureStableCluster(4);
                }
    }
            .cluster()
                    restartedMasters.add(nodeName);
        );
        // enable remote publication
    }
    }
    private boolean hasRemoteRoutingCharPrefix;
    }
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
                }
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
    }
        }
                    return Settings.builder().put(REMOTE_PUBLICATION_SETTING_KEY, false).build();
/*
    private static final String REMOTE_ROUTING_PREFIX = "_";
        int dataNodeCount = shardCount * (replicaCount + 1);
    public void setup() {
                .filter(
            PersistedStateRegistry registry = internalCluster().getInstance(PersistedStateRegistry.class, node);
                hasRemoteRoutingCharPrefix ? REMOTE_ROUTING_PREFIX : ""
            InterceptingHandler(String action, TransportRequestHandler<T> handler) {
        // disable remote publication
        internalCluster().client()
        ensureStableCluster(5);
        for (Client client : clients()) {
import org.opensearch.transport.client.Client;
            .get().instance.getRequestCount(action);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
import org.opensearch.gateway.remote.model.RemoteRoutingTableBlobStore;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
package org.opensearch.gateway.remote;
        assertTrue(ephemeralMetadataFiles.containsKey(CLUSTER_BLOCKS));
import org.opensearch.gateway.GatewayMetaState;
import java.util.Locale;
        ).index("index-1");
                handler.messageReceived(request, channel, task);
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
            getClusterState().getClusterName().value(),
                        .prepareNodesStats(followingCMs.toArray(new String[0]))
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
        DiscoveryStats dataNodeDiscoveryStats = nodeStats.getDiscoveryStats();
    private boolean isRemoteStateEnabled = true;
import org.opensearch.transport.TransportInterceptor;
        assertEquals(manifest.getIndices(), manifestAfterElection.getIndices());
                String statsName = persistedStateStats.getStatsName();
            discoveryStats.getClusterStateStats()
        assertTrue(globalMetadataFiles.containsKey(TEMPLATES_METADATA));
        BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository(REPOSITORY_NAME);
        );
                    });
    }
        assertNotNull(dataNodeDiscoveryStats.getClusterStateStats());
                        Integer requestCount = requests.getOrDefault(action, 0);
 */
                .getPersistenceStats()
        // only disable remote state
                .stream()
        private class InterceptingHandler<T extends TransportRequest> implements TransportRequestHandler<T> {
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            }
        isRemotePublicationEnabled = false;
            greaterThanOrEqualTo(0L)
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
    }
        ensureStableCluster(7);
            .get();
import org.opensearch.cluster.ClusterState;
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.DISCOVERY;
            .add(subDirectory);
        hasRemoteRoutingCharPrefix = randomBoolean();
                        .collect(Collectors.toSet());
        NodesStatsResponse nodesStatsResponseDataNode = client().admin()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ensureGreen(INDEX_NAME);
            .get();
            }
        if (hasRemoteRoutingCharPrefix) {
            ClusterStateResponse response = client.admin().cluster().prepareState().clear().setMetadata(true).get();
        assertEquals(0, (int) getRequestCount(PUBLISH_STATE_ACTION_NAME));
                this.handler = handler;
            .add(RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN)
        assertTrue(ephemeralMetadataFiles.containsKey(DISCOVERY_NODES));
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
import static org.opensearch.gateway.remote.model.RemoteClusterBlocks.CLUSTER_BLOCKS;
    }
        IndicesAliasesRequest request = new IndicesAliasesRequest(); // <1>
        ensureGreen(INDEX_NAME);
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING;
        isRemotePublicationEnabled = false;
        Iterable<PluginsService> pluginsServices = internalCluster().getInstances(PluginsService.class);
        createIndex("index-2");
        Map<String, Integer> ephemeralMetadataFiles = getMetadataFiles(
            .prepareUpdateSettings()
            .cluster()
        }
                    assertEquals(0, persistedStateStats.getSuccessCount());
                return Collections.singletonList(instance);
        assertTrue(getRequestCount(PUBLISH_REMOTE_STATE_ACTION_NAME) > 0);
        NodesInfoResponse nodesInfoResponse = client().admin()
        assertEquals(0, dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(0).getFailedCount());
import org.opensearch.plugins.PluginsService;
        Map<String, Integer> globalMetadataFiles = getMetadataFiles(repository, RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN);
    public void testRemotePublicationEnabledAfterSettingChange() {
            for (UploadedIndexMetadata md : manifest.getIndicesRouting()) {
            PublishClusterStateStats stats = nodeStats.getDiscoveryStats().getPublishStats();
import java.util.Collections;
                        .get();
            RemoteClusterStateService.class
                .forEach(persistedStateStats -> {
        public static class TestPlugin extends Plugin implements NetworkPlugin {
        Set<String> restartedMasters = new HashSet<>();
        }
            private final String action;
                    String activeCM = internalCluster().getClusterManagerName();
            .put(routingTableRepoTypeAttributeKey, ReloadableFsRepository.TYPE)
            Collections.addAll(this.actions, actions);
            .put(
            DiscoveryStats discoveryStats = nodeStats.getDiscoveryStats();
            .admin()
        assertAcked(client().admin().indices().aliases(request).actionGet());
    public void testVotingConfigAreCommitted() throws ExecutionException, InterruptedException {
import java.util.stream.Collectors;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        followingCMs.forEach(node -> {
        return pluginsServices.iterator()
        response.getNodes().forEach(nodeStats -> {
            assertTrue(stats.getFullClusterStateReceivedCount() > 0 || stats.getCompatibleClusterStateDiffReceivedCount() > 0);
        );
            public List<TransportInterceptor> getTransportInterceptors(
            .add(getClusterState().metadata().clusterUUID())
            .prepareUpdateSettings()
                public Settings onNodeStopped(String nodeName) {
        // create cluster with multi node (3 master + 2 data)
    private static final String REMOTE_STATE_PREFIX = "!";
        String activeCM = internalCluster().getClusterManagerName();
        synchronized void interceptTransportActions(String... actions) {
        // force elected master to step down
                            assertNull(remoteState.getLastAcceptedManifest());
                            DiscoveryStats stats = nodeStats.getDiscoveryStats();
        BlobPath metadataPath = repository.basePath()
            .get();
                            ClusterState remotePersistedState = remoteState.getLastAcceptedState();
                assertThat(md.getUploadedFilename(), startsWith(REMOTE_STATE_PREFIX));
                        PersistedStateRegistry registry = internalCluster().getInstance(PersistedStateRegistry.class, node);
            repository,
        ensureGreen(INDEX_NAME);
        }
        assertEquals(manifest.getSettingsMetadata(), manifestAfterElection.getSettingsMetadata());
        plugins.add(InterceptingTransportService.TestPlugin.class);
                        || persistedStateStats.getStatsName().equals(DIFF_DOWNLOAD_STATS)
        assertTrue(dataNodeDiscoveryStats.getClusterStateStats().getPersistenceStats().get(0).getSuccessCount() > 0);
            .put(REMOTE_PUBLICATION_SETTING_KEY, isRemotePublicationEnabled)
import java.util.Map;
                assertEquals(
import java.util.Base64;
        prepareCluster(3, 2, INDEX_NAME, 1, 2);
        createIndex(INDEX_NAME, remoteStoreIndexSettings(1, 2));
        // disable remote publication
        private final Map<String, Integer> requests = new HashMap<>();
        for (NodeStats node : nodesStatsResponse.getNodes()) {
            assertNull(remoteState.getLastAcceptedState());
        assertTrue(manifestFiles.containsKey(RemoteClusterMetadataManifest.MANIFEST));
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.gateway.remote.RemoteClusterStateAttributesManager.DISCOVERY_NODES;
            .addMetric(DISCOVERY.metricName())
        interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
                interceptTransportActions(PUBLISH_REMOTE_STATE_ACTION_NAME, PUBLISH_STATE_ACTION_NAME);
        createIndex(INDEX_NAME + "2", remoteStoreIndexSettings(1, 2));
        internalCluster().startClusterManagerOnlyNodes(2, Settings.EMPTY);
        // all other attributes are not uploaded again and will be pointing to same files in manifest after new master is elected
        prepareCluster(3, 2, INDEX_NAME, 1, 1);
                            assertTrue(
                PathHashAlgorithm.FNV_1A_COMPOSITE_1.toString()
import static org.opensearch.gateway.remote.RemoteDownloadStats.CHECKSUM_VALIDATION_FAILED_COUNT;
        assertEquals(0, (int) getRequestCount(PUBLISH_STATE_ACTION_NAME));
            RemoteClusterStateService.class,
        ensureStableCluster(5);
            )
import static org.opensearch.gateway.remote.RemotePersistenceStats.FULL_DOWNLOAD_STATS;
            .prepareUpdateSettings()
            .getPersistedState(PersistedStateRegistry.PersistedStateType.REMOTE);
                Base64.getUrlEncoder()
            });
    public void testRemotePublicationDisabledByRollingRestart() throws Exception {
        // coordination metadata is updated, it will be unequal
        );
                .get(CHECKSUM_VALIDATION_FAILED_COUNT)
        assertTrue(globalMetadataFiles.containsKey(TRANSIENT_SETTING_METADATA));
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            .get();
