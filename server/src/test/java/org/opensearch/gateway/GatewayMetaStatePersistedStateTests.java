            Directory createDirectory(Path path) {  
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
            final long term = randomValueOtherThan(Long.MAX_VALUE, OpenSearchTestCase::randomNonNegativeLong);  
import org.apache.lucene.tests.store.MockDirectoryWrapper;
                        .build()
                    );  
        assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
 * ownership. Elasticsearch licenses this file to you under  
            randomNonNegativeLong(),  
            final IndexMetadata newIndexMetadata = createIndexMetadata(indexName, newNumberOfShards, version);
        assertTrue(remotePersistedState.getLastAcceptedManifest().isCommitted());
        try {  
        } finally {  
public class GatewayMetaStatePersistedStateTests extends OpenSearchTestCase {  
            assertThat(
        remotePersistedState.setLastAcceptedState(thirdClusterState);  
                    .build();
            );
                }
            cleanup.add(() -> {
import org.opensearch.transport.TransportService;
import org.opensearch.common.settings.Settings;
            );
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
        final TransportService transportService = mock(TransportService.class);  
                        nodeEnvironment.nodeId(),
        PersistedStateRegistry persistedStateRegistry,  
        );
                () -> 0L
            );  
            randomNonNegativeLong(),
import static org.hamcrest.Matchers.not;
                .settings(  
import org.opensearch.cluster.node.DiscoveryNode;
        final String previousClusterUUID = "prev-cluster-uuid";
            true  
                    currentTerm = newTerm;  
        assertThat(actual.version(), equalTo(expected.version()));
import org.opensearch.cluster.ClusterState;
            new RemoteClusterStateManifestInfo(manifest, "path/to/manifest")  
/*  
            );
            do {
            CoordinationMetadata persistedCoordinationMetadata = persistedClusterStateService.loadBestOnDiskState().metadata
                }  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            assertThat(
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,  
                            new RemoteIndexPathUploader(
        } catch (IOError | Exception e) {  
    }
            );  
            builder.addVotingConfigExclusion(new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10)));
            .put(stateRepoSettingsAttributeKeyPrefix + "location", "randomRepoPath")  
        ClusterState clusterState2 = createClusterState(  
            getBigArrays(),  
        ClusterState currentState,  
            final int newNumberOfShards = randomValueOtherThan(numberOfShards, () -> randomIntBetween(1, 5));
            randomNonNegativeLong(),
        final List<MockDirectoryWrapper> list = new ArrayList<>();  
                persistedStateRegistry,
                        .coordinationMetadata(createCoordinationMetadata(1L))
import static org.hamcrest.Matchers.nullValue;  
                persistedStateRegistry,
    private CoordinationState.PersistedState newGatewayPersistedState() throws IOException {  
            ).nodes(DiscoveryNodes.EMPTY_NODES).build();
    private static BigArrays getBigArrays() {
        IOUtils.close(gateway);
        } finally {
        ArgumentCaptor<ClusterState> clusterStateCaptor = ArgumentCaptor.forClass(ClusterState.class);
                        .clusterUUID(ClusterState.UNKNOWN_UUID)
        ClusterState state = createClusterState(randomNonNegativeLong(), Metadata.builder().clusterUUID(randomAlphaOfLength(10)).build());  
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenReturn(
            final RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);  
            for (int i = 0; i < randomIntBetween(1, 5); i++) {  
    }  
        } finally {
            final long term = randomNonNegativeLong();
        Mockito.when(remoteClusterStateService.getLatestClusterMetadataManifest(Mockito.any(), Mockito.any()))
            .thenReturn(new RemoteClusterStateManifestInfo(manifest, "path/to/manifest"));
import org.opensearch.repositories.RepositoriesService;
                assertEquals(currentTerm, reloadedPersistedState.getCurrentTerm());
        boolean prepareFullState
    }
            );
            remoteClusterStateService,  
import org.opensearch.cluster.service.ClusterService;
                .build();  
            });
                .put(Environment.PATH_DATA_SETTING.getKey(), path.getParent().getParent().toString())
            CoordinationMetadata expectedCoordinationMetadata = CoordinationMetadata.builder(coordinationMetadata)
            .previousClusterUUID(previousClusterUUID)
        final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(  
                Locale.getDefault(),
            final CoordinationState.PersistedState lucenePersistedState = gateway.getPersistedState();  
import static org.mockito.ArgumentMatchers.eq;  
                randomNonNegativeLong(),  
        return gateway;
    private DiscoveryNode localNode;
                .coordinationMetadata();  
    }
                                clusterSettings,  
            );
            gateway = maybeNew(gateway);  
    }
        remotePersistedState.setLastAcceptedState(clusterState3);
        }  
        );
        return ClusterState.builder(clusterName).nodes(discoveryNodes).version(version).metadata(metadata).build();
                .build();  
import java.io.IOException;
import org.opensearch.cluster.metadata.Manifest;  
            getBigArrays(),  
                Metadata.builder()
                        .version(onDiskState.lastAcceptedVersion)
        assertThat(remotePersistedState.getLastAcceptedState(), equalTo(clusterState));
                ClusterState lastAcceptedState = gateway.getLastAcceptedState();
        assertEquals(clusterTerm, remotePersistedState.getCurrentTerm());
        for (IndexMetadata indexMetadata : expected.metadata()) {
            );  
                    .coordinationMetadata(CoordinationMetadata.builder().term(randomLong()).build())
            assertThat(actual.metadata().index(indexMetadata.getIndex()), equalTo(indexMetadata));
                false
            assertThat(persistedState, instanceOf(GatewayMetaState.LucenePersistedState.class));
import static org.hamcrest.Matchers.instanceOf;
    ) throws IOException {
                persistedCoordinationMetadata.getLastCommittedConfiguration(),  
                        .build(),
        Mockito.when(remoteClusterStateService.writeIncrementalMetadata(Mockito.any(), Mockito.any(), Mockito.any()))
                    final String indexName = randomAlphaOfLength(10);  
        remotePersistedState.setLastAcceptedState(clusterState);
            gateway = maybeNew(gateway);  
            final RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
    }
                            )
            final RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
                        repositoriesServiceSupplier,
            Locale.getDefault(),
            long currentTerm = randomNonNegativeLong();  
            .thenReturn(new RemoteClusterStateManifestInfo(manifest, "path/to/manifest"));
            );
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            final RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
    private ClusterState createClusterState(long version, Metadata metadata, boolean isClusterManagerNode) {  
                buildNewFakeTransportAddress(),  
            .add(oldNode)
                                DefaultRemoteStoreSettings.INSTANCE
        }
        String stateRepoSettingsAttributeKeyPrefix = String.format(  
                remoteStoreRestoreService,
        when(metaStateService.loadFullState()).thenReturn(new Tuple<>(Manifest.empty(), ClusterState.EMPTY_STATE.metadata()));
            ClusterState.UNKNOWN_UUID
                            .settings(settings(Version.CURRENT).put(SETTING_INDEX_UUID, randomAlphaOfLength(10)))
                assertFalse(onDiskState.empty());
                state  
        try {  
            long currentTerm = state.term();
                createClusterState(  
                equalTo(GatewayMetaState.AsyncLucenePersistedState.staleStateConfiguration)
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenReturn(
import org.opensearch.cluster.coordination.CoordinationState.PersistedState;
                randomNonNegativeLong(),
            .build();  
import static org.mockito.Mockito.mock;
            long term = randomValueOtherThan(currentTerm, OpenSearchTestCase::randomNonNegativeLong);
        }  
    public void testSetCurrentTerm() throws IOException {
                randomNonNegativeLong(),  
            .build();
                Locale.getDefault(),  
    }
        startGatewayForRemoteState(
                remoteClusterStateService,  
        try {
import org.opensearch.gateway.GatewayMetaState.RemotePersistedState;  
            assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
                not(equalTo(gateway.getLastAcceptedState().getLastCommittedConfiguration()))  
            persistedStateRegistry,
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            return null;
            "node2",
        return gatewayMetaState;
        try {
            gateway.start(settings, nodeEnvironment, xContentRegistry(), persistedStateRegistry);
        assertEquals(manifest, remotePersistedState.getLastAcceptedManifest());
            assertEquals(state, persistedState.getLastAcceptedState());  
                    xContentRegistry(),
    public void testGatewayForRemoteStateForNodeReplacement() throws IOException {  
        Mockito.verify(remoteClusterStateService).writeIncrementalMetadata(clusterState2, clusterState3, manifest2);  
                randomNonNegativeLong(),  
                    final Metadata metadata = Metadata.builder()
        super.setUp();
    public void testGatewayForRemoteState() throws IOException {  
        final ClusterState state = createClusterState(
            assertThat(lucenePersistedState.getLastAcceptedState().metadata().indices().size(), equalTo(1));
            Version.V_2_13_0
        gateway.start(settings, nodeEnvironment, xContentRegistry(), persistedStateRegistry);
        };
        );
                    .clusterUUID(randomAlphaOfLength(10))
        ClusterState currentState
            startGatewayForRemoteState(
        CoordinationState.PersistedState remotePersistedState = new RemotePersistedState(remoteClusterStateService, previousClusterUUID);
        assertThat(remotePersistedState.getCurrentTerm(), equalTo(clusterTerm));  
            for (MockDirectoryWrapper wrapper : list) {
                .metadata(
                Metadata.isGlobalStateEquals(lucenePersistedState.getLastAcceptedState().metadata(), clusterState.metadata()),  
        // verify that the freshest state was rewritten to each data path
import org.opensearch.cluster.node.DiscoveryNodes;
                        .coordinationMetadata(CoordinationMetadata.builder().term(randomLong()).build())  
                new PersistedStateRegistry(),
        Mockito.verify(remoteClusterStateService, never()).writeFullMetadata(secondClusterState, previousClusterUUID);
            RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);  
        );
        assertThrows(OpenSearchException.class, () -> remotePersistedState.setLastAcceptedState(clusterState));  
import org.opensearch.gateway.remote.RemoteClusterStateService;  
                    nodeEnvironment,
                state  
                        .version(onDiskState.lastAcceptedVersion)  
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenThrow(
import org.opensearch.OpenSearchException;
import org.opensearch.env.TestEnvironment;
        );
import org.opensearch.gateway.remote.model.RemoteClusterStateManifestInfo;
                final long currentTerm = randomNonNegativeLong();
                            .build(),
            gateway.setLastAcceptedState(state);  
        }  
                        clusterService,
                remoteStoreRestoreService,
        final ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder()
        } finally {
            instanceOf(GatewayMetaState.LucenePersistedState.class)  
                    () -> 0L
            .thenReturn(new RemoteClusterStateManifestInfo(manifest2, "path/to/manifest"));  
                    .put(indexMetadata, false)
                    Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(term).build()).build()
        try {
        Settings settingWithRemoteStateEnabled = Settings.builder()
        } finally {
            .thenReturn(Optional.of(manifest));  
        ClusterService clusterService = mock(ClusterService.class);
        }
            final String indexName = randomAlphaOfLength(10);  
            randomNonNegativeLong(),
            CoordinationMetadata coordinationMetadata;  
                ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);  
                assertNotNull(reloadedPersistedState.getLastAcceptedState().metadata().index(indexName));  
        remotePersistedState.markLastAcceptedStateAsCommitted();
    public void testGatewayForRemoteStateForInitialBootstrapBlocksApplied() throws IOException {
            assertThat(
                Settings.builder()
                .build();  
    public void testRemotePersistedStateExceptionOnFullStateUpload() throws IOException {
                Collections.emptyMap(),
            randomNonNegativeLong(),  
            ClusterState state = createClusterState(  
            .codecVersion(CODEC_V1)
            assertThat(
                    new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
 * Licensed to Elasticsearch under one or more contributor  
            PersistedState remotePersistedState = persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE);  
        return IndexMetadata.builder(indexName)  
        DiscoveryNode oldNode = new DiscoveryNode(  
            remoteClusterStateService,
                );
            .opensearchVersion(Version.V_2_15_0)  
                        .clusterUUID(state.metadata().clusterUUID())
        return createClusterState(version, metadata, false);  
            randomNonNegativeLong(),
                new MetaStateService(nodeEnvironment, xContentRegistry()),  
}
        final ClusterState secondClusterState = createClusterState(  
        }).when(remoteClusterStateService).writeMetadataFailed();  
    private NodeEnvironment nodeEnvironment;
import org.opensearch.index.recovery.RemoteStoreRestoreService.RemoteRestoreResult;
/*
            final ClusterState previousState = createClusterState(
            cleanup.add(gateway);
        }  
            Settings settings = Settings.builder()
                        .clusterUUIDCommitted(true)  
 * The OpenSearch Contributors require contributions made to  
            IOUtils.close(gateway);
    public void testGatewayForRemoteStateForInitialBootstrap() throws IOException {
        remotePersistedState.setLastAcceptedState(secondClusterState);
            RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);  
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
                assertThat(gateway.getCurrentTerm(), equalTo(currentTerm));
        CoordinationState.PersistedState gateway = null;
        );
        Mockito.verify(remoteClusterStateService).writeFullMetadata(clusterState1, previousClusterUUID);
            gateway.setLastAcceptedState(
            verify(remoteStoreRestoreService).restore(any(), any(), anyBoolean(), any());
                false  
                        Collections.emptyMap(),
                remoteClusterStateServiceSupplier.get(),
        Mockito.verify(remoteClusterStateService, never()).writeFullMetadata(clusterState, previousClusterUUID);  
            String stateRepoTypeAttributeKey = String.format(  
        when(remoteClusterStateService.markLastStateAsCommitted(Mockito.any(), Mockito.any(), eq(false))).thenReturn(
import org.opensearch.common.settings.ClusterSettings;
            ClusterState state = gateway.getLastAcceptedState();  
                .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)  
                    state = createClusterState(
                wrapper.setAllowRandomFileNotFoundException(randomBoolean());
                new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        RemoteUploadStats remoteStateStats = new RemoteUploadStats();
        }
                    reloadedPersistedState.getLastAcceptedState()
                        Metadata.builder().coordinationMetadata(createCoordinationMetadata(term)).put(indexMetadata, false).build()  
                        .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())  
    @Override
 * compatible open source license.
            settingWithRemoteStateEnabled,  
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
    }
            final IndexMetadata indexMetadata = IndexMetadata.builder("test-index1")
            }
        CoordinationState.PersistedState remotePersistedState = new RemotePersistedState(remoteClusterStateService, previousClusterUUID);
                    false
                IndexMetadata.INDEX_READ_ONLY_SETTING.get(
import static org.opensearch.gateway.remote.ClusterMetadataManifest.MANIFEST_CURRENT_CODEC_VERSION;  
                Error.class,
                transportService,
            }
                ),
            Settings settings = Settings.builder()  
                assertThat(onDiskState.currentTerm, equalTo(42L));  
        remotePersistedState.setLastAcceptedState(clusterState2);
                final IndexMetadata indexMetadata = createIndexMetadata(indexName, randomIntBetween(1, 5), randomNonNegativeLong());  
            );
        final ClusterState thirdClusterState = ClusterState.builder(secondClusterState)  
                        .put(indexMetadata, false)
                                settings,
                .put(nonClusterManagerNode())
                ClusterState.EMPTY_STATE  
                RemoteRestoreResult.build("test-cluster-uuid", null, previousState)  
    public void testRemotePersistedStateNotCommitted() throws IOException {  
            false
    }  
            try {
        RemoteClusterStateService remoteClusterStateService,
 * Unless required by applicable law or agreed to in writing,
                equalTo(GatewayMetaState.AsyncLucenePersistedState.staleStateConfiguration)  
            true  
            );  
                    final IndexMetadata indexMetadata = createIndexMetadata(indexName, numberOfShards, i);  
import java.io.IOError;
            );  
            RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
                    .put(indexMetadata, false)  
        Mockito.when(remoteClusterStateService.writeIncrementalMetadata(Mockito.any(), Mockito.any(), Mockito.any()))  
            IOUtils.close(gateway);
            gateway.close();  
            persistedState.setLastAcceptedState(state);
import org.opensearch.cluster.coordination.PersistedStateRegistry;  
            .stateVersion(5L)
            gateway.setCurrentTerm(currentTerm);  
                ClusterState.EMPTY_STATE,
            IOUtils.close(gateway);  
            assertBusy(() -> assertTrue(gateway.allPendingAsyncStatesWritten()));
            writer.close();
        final ClusterState clusterState = createClusterState(  
            PersistedState remotePersistedState = persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE);
                .put(stateRepoTypeAttributeKey, FsRepository.TYPE)
            assertThat(gateway.getLastAcceptedState().coordinationMetadata().term(), equalTo(term));
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V1;
                xContentRegistry(),
            final TransportService transportService = mock(TransportService.class);  
                gatewayMetaStateSpy,
            // generate random coordinationMetadata with different lastAcceptedConfiguration and lastCommittedConfiguration  
                remoteClusterStateService,
    }  
        ClusterState clusterState = createClusterState(  
                    Metadata.builder()  
        IOUtils.close(gateway);
        final List<Closeable> cleanup = new ArrayList<>(2);
                    GatewayMetaState.AsyncLucenePersistedState.resetVotingConfiguration(state),  
        remotePersistedState.setLastAcceptedManifest(manifest);
            gateway = maybeNew(gateway);
        nodeEnvironment.close();
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder().clusterTerm(1L).stateVersion(5L).build();
import org.opensearch.common.util.MockBigArrays;
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);  
        assertThat(remotePersistedState.getLastAcceptedState().metadata().clusterUUIDCommitted(), equalTo(false));
        RemoteClusterStateService remoteClusterStateService,  
            final CoordinationState.PersistedState lucenePersistedState = gateway.getPersistedState();
        builder.lastAcceptedConfiguration(
            buildNewFakeTransportAddress(),
            GatewayMetaState.LucenePersistedState ignored = new GatewayMetaState.LucenePersistedState(  
                        clusterService,
        remotePersistedState.markLastAcceptedStateAsCommitted();
                randomNonNegativeLong(),
                .lastCommittedConfiguration(coordinationMetadata.getLastAcceptedConfiguration())
            assertThat(state.getNodes().getLocalNode(), equalTo(localNode));
            assertClusterStateEqual(state, persistedState.getLastAcceptedState());  
                        transportService.getThreadPool()  
            gateway = newGatewayForRemoteState(
    }
            try (NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings))) {
        return persistedState;
    }
import org.opensearch.index.remote.RemoteIndexPathUploader;
                            .numberOfReplicas(1)
                ClusterState.EMPTY_STATE,  
            () -> 0L  
            .thenReturn(new RemoteClusterStateManifestInfo(manifest, "path/to/manifest"));
    private CoordinationMetadata createCoordinationMetadata(long term) {
                    // bump term
            assertTrue(persistedClusterStateService.loadBestOnDiskState().metadata.clusterUUIDCommitted());  
import org.opensearch.common.util.BigArrays;  
        remotePersistedState.setLastAcceptedState(clusterState);
                wrapper.setRandomIOExceptionRateOnOpen(ioExceptionRate.get());  
        CoordinationMetadata.Builder builder = CoordinationMetadata.builder();
        Mockito.verify(remoteClusterStateService, never()).markLastStateAsCommitted(Mockito.any(), Mockito.any(), eq(false));
            verify(gatewayMetaStateSpy, times(5)).restoreClusterState(Mockito.any(), Mockito.any(), Mockito.any());
import org.opensearch.Version;
            gateway = maybeNew(gateway);
        final ClusterState thirdClusterState = ClusterState.builder(secondClusterState)  
            );  
                    Metadata.builder()
                        .put(indexMetadata, false)
 *  
        CoordinationState.PersistedState gateway = null;
    private ClusterName clusterName;  
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
import java.util.Optional;
        } finally {
                final PersistedClusterStateService newPersistedClusterStateService = new PersistedClusterStateService(  
            assertThat(
        assertEquals(clusterTerm, remotePersistedState.getCurrentTerm());  
            logger.info("initial metadata: {}", clusterState.toString());  
                .numberOfShards(5)
        } finally {  
            assertThat(lucenePersistedState.getLastAcceptedState().metadata(), equalTo(previousState.metadata()));  
    }  
            clusterService,
                    .build(),  
                assertClusterStateEqual(
            final CoordinationState.PersistedState persistedState = gateway.getPersistedState();
            assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
            final ClusterState clusterState = ClusterState.builder(
            );
                    persistedState.setLastAcceptedState(state);
                    )
    ) throws IOException {
    }
                gateway.setLastAcceptedState(state);
    public void testGatewayMetaStateRemoteStateDownloadFailure() throws IOException {
    private Settings settings;
import org.opensearch.ExceptionsHelper;  
            .committed(false)  
            );
                        settings,
                persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE),
        Mockito.verify(remoteClusterStateService, times(1)).markLastStateAsCommitted(Mockito.any(), Mockito.any(), eq(false));  
            IOUtils.close(gateway);  
        assertTrue(remotePersistedState.getLastAcceptedManifest().isCommitted());  
    public void tearDown() throws Exception {  
            }
        assertThat(persistedState, instanceOf(GatewayMetaState.LucenePersistedState.class));  
    }  
        assertNull(remotePersistedState.getLastAcceptedState());
                RemoteRestoreResult.build("test-cluster-uuid", null, ClusterState.EMPTY_STATE)  
                    persistedStateRegistry,  
            when(remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster")).thenReturn("test-cluster-uuid");
        try {  
                clusterService,
import org.opensearch.index.recovery.RemoteStoreRestoreService;  
import org.opensearch.gateway.remote.RemoteUploadStats;
        ) {
            transportService,
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build()).build(),
            );
                false
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            gateway.start(
                () -> startGatewayForRemoteState(
    public void setUp() throws Exception {
        nodeEnvironment.close();  
            IOUtils.close(gateway);
                .numberOfReplicas(1)
        }
                "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            randomNonNegativeLong(),
    public void testRemotePersistentState_FollowerNode() throws IOException {
        MockGatewayMetaState gateway = null;
import java.util.List;  
                Metadata.builder().coordinationMetadata(createCoordinationMetadata(newTerm)).put(newIndexMetadata, false).build()
                "randomRepoName"
                equalTo(GatewayMetaState.AsyncLucenePersistedState.staleStateConfiguration)  
                final MockDirectoryWrapper wrapper = newMockFSDirectory(path);
    }
 * You may obtain a copy of the License at  
import org.opensearch.env.Environment;  
            nodeEnvironment,
        String stateRepoTypeAttributeKey = String.format(
        CoordinationState.PersistedState gateway = null;
            Sets.newHashSet(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
import org.opensearch.cluster.coordination.CoordinationState;
    public void testMarkAcceptedConfigAsCommitted() throws IOException {
        doAnswer((i) -> {  
                .settings(settings(Version.CURRENT).put(SETTING_INDEX_UUID, randomAlphaOfLength(10)))
            final int iterations = randomIntBetween(1, 1000);
            }  
                ClusterState state = createClusterState(version, metadata);  
                        () -> 0L
                remoteClusterStateService,  
                .put(stateRepoSettingsAttributeKeyPrefix + "location", "randomRepoPath")
        final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
                new IllegalStateException("unable to download cluster state")
                    .coordinationMetadata(CoordinationMetadata.builder().term(randomLong()).build())
        );
import java.nio.file.Path;  
                        false  
            verify(gatewayMetaStateSpy, times(2)).restoreClusterState(Mockito.any(), Mockito.any(), Mockito.any());
            remoteStoreRestoreService  
            ).thenReturn(RemoteRestoreResult.build("test-cluster-uuid", null, ClusterState.EMPTY_STATE));  
                } else {  
        final MockGatewayMetaState gatewayMetaStateSpy;
            nodeEnvironment,
        }
                persistedClusterStateService,
            final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(  
    public void testStatePersistenceWithIOIssues() throws IOException {
 * GitHub history for details.
                new IllegalStateException("unable to download cluster state")
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
                )
            assertThat(
                persistedStateRegistry,
                final String indexName = randomAlphaOfLength(10);
                            .numberOfShards(5)  
import java.util.concurrent.TimeUnit;  
        assertFalse(remotePersistedState.getLastAcceptedState().metadata().clusterUUIDCommitted());  
 */
        ) {
import static org.mockito.ArgumentMatchers.any;
            gateway = newGatewayForRemoteState(
        if (isClusterManagerNode) {
            try (CoordinationState.PersistedState reloadedPersistedState = newGatewayPersistedState()) {  
        Mockito.verify(remoteClusterStateService).writeFullMetadata(clusterState, previousClusterUUID);  
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.verify;
                throw e;
        RemoteStoreRestoreService remoteStoreRestoreService,
        }
        if (randomBoolean()) {
            assertNotNull(ExceptionsHelper.unwrap(e, IOException.class));
                    ClusterState.builder(ClusterName.DEFAULT)  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteStoreClusterStateEnabled;
                equalTo(true)
            assertClusterStateEqual(expectedClusterState, gateway.getLastAcceptedState());  
                    Supplier<RepositoriesService> repositoriesServiceSupplier = () -> new RepositoriesService(  
            .metadata(Metadata.builder(secondClusterState.getMetadata()).clusterUUID(randomAlphaOfLength(10)).build())
            Metadata.builder()
            Sets.newHashSet(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
    }
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            () -> 0L
                    persistedState.setCurrentTerm(currentTerm);
            gateway = newGatewayPersistedState();
            gateway.setLastAcceptedState(state);
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenThrow(  
            final ClusterState newClusterState = createClusterState(  
            gateway = initializeGatewayForRemoteState(true);
/*  
                assertThat(onDiskState.currentTerm, equalTo(currentTerm));
                .put(Environment.PATH_DATA_SETTING.getKey(), path.getParent().getParent().toString())  
 * specific language governing permissions and limitations
        }
                    persistedState.setLastAcceptedState(state);
        try {  
                wrapper.setRandomIOExceptionRate(ioExceptionRate.get());  
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenReturn(  
    private MockGatewayMetaState newGatewayForRemoteState(
import static org.hamcrest.Matchers.equalTo;  
                        .build()
            );
import org.opensearch.repositories.fs.FsRepository;  
            TestThreadPool threadPool = new TestThreadPool("testMarkAcceptedConfigAsCommittedOnDataOnlyNode");
        ArgumentCaptor<String> previousClusterUUIDCaptor = ArgumentCaptor.forClass(String.class);
                getBigArrays(),  
            .put(stateRepoTypeAttributeKey, FsRepository.TYPE)
                "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
                assertClusterStateEqual(
        final long clusterTerm = randomNonNegativeLong();
            }
        long currentTerm = 42L;
import org.opensearch.common.util.MockPageCacheRecycler;
 *    http://www.apache.org/licenses/LICENSE-2.0
                gateway = maybeNew(gateway);  
                )
                    nodeEnvironment,  
                "node1",
            } while (coordinationMetadata.getLastAcceptedConfiguration().equals(coordinationMetadata.getLastCommittedConfiguration()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final ClusterState secondClusterState = createClusterState(
            CoordinationMetadata expectedCoordinationMetadata = CoordinationMetadata.builder(coordinationMetadata)
            when(remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster")).thenReturn("test-cluster-uuid");
            final RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);  
                    state,
                                threadPool,  
                        state.version() + 1,
                Metadata.builder().coordinationMetadata(coordinationMetadata).clusterUUID(randomAlphaOfLength(10)).build()
            PersistedState lucenePersistedState = persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL);
        MockGatewayMetaState gatewayMetaState = initializeGatewayForRemoteState(prepareFullState);  
            verifyNoInteractions(remoteClusterStateService);
                RemoteRestoreResult.build("test-cluster-uuid", null, clusterState)
            .clusterManagerNodeId(localNode.getId())
import java.io.Closeable;  
                .coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build())
        nodeEnvironment = newNodeEnvironment();
                    .put(  
                .clusterUUIDCommitted(true)
        final long clusterTerm = randomNonNegativeLong();
    @Override
import org.opensearch.indices.DefaultRemoteStoreSettings;  
        assertEquals(0, remotePersistedState.getCurrentTerm());
                    persistedState.setCurrentTerm(newTerm);
            .build();
            final long version = randomNonNegativeLong();
            .build();
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build()).build(),
            assertThat(  
                    persistedState.setCurrentTerm(currentTerm);
            true  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        assertNull(remotePersistedState.getLastAcceptedManifest());  
                assertClusterStateEqual(state, lastAcceptedState);  
            GatewayMetaState.LucenePersistedState persistedState = new GatewayMetaState.LucenePersistedState(  
import static org.mockito.Mockito.doAnswer;
                if (rarely()) {
            } while (coordinationMetadata.getLastAcceptedConfiguration().equals(coordinationMetadata.getLastCommittedConfiguration()));  
        return new MockGatewayMetaState(localNode, bigArrays, prepareFullState);
            remoteStoreRestoreService,
    }
            false  
            persistedState.close();
 * SPDX-License-Identifier: Apache-2.0
        assertThat(remotePersistedState.getCurrentTerm(), equalTo(0L));  
        );  
            );
            assertThat(gateway.getCurrentTerm(), equalTo(currentTerm));  
                clusterState,  
            writer.writeFullStateAndCommit(currentState.term(), currentState);  
                        randomNonNegativeLong(),
        MockGatewayMetaState gateway = null;
                                repositoriesServiceSupplier,
            verify(remoteStoreRestoreService).restore(any(ClusterState.class), any(String.class), anyBoolean(), any(String[].class));  
                .numberOfReplicas(1)  
            assertClusterStateEqual(expectedClusterState, gateway.getLastAcceptedState());
            randomRepoName  
            when(remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster")).thenReturn("test-cluster-uuid");
                null  
        final String previousClusterUUID = "prev-cluster-uuid";
    }  
    public void testRemotePersistedState() throws IOException {
            .build();
        } finally {
            try (NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings))) {
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    }  
            gateway = initializeGatewayForRemoteState(true);
        );
        try (
            assertThrows(  
            IOUtils.close(cleanup);  
import static org.mockito.Mockito.verifyNoInteractions;  
                equalTo(true)
            Metadata.builder().clusterUUID(randomAlphaOfLength(10)).build()  
            assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
        remotePersistedState.setLastAcceptedState(secondClusterState);  
        ) {
        final ClusterState clusterState = createClusterState(
        return ClusterState.builder(clusterName).nodes(nodesBuilder.build()).version(version).metadata(metadata).build();
                if (randomBoolean()) {
                )  
                    // update cluster state  
                .build();
import java.util.concurrent.atomic.AtomicReference;
                    currentTerm += 1;
                Sets.newHashSet(DiscoveryNodeRole.DATA_ROLE),
    private MockGatewayMetaState initializeGatewayForRemoteState(boolean prepareFullState) {
                    .put(IndexMetadata.SETTING_INDEX_UUID, indexName)  
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false)))
        try {
        MockGatewayMetaState gateway = null;
        );  
            metaStateService,  
        );
                remoteStoreRestoreService,
            ioExceptionRate.set(0.0d);  
            gatewayMetaState,
                    .build()
 *
            gateway = newGatewayForRemoteState(  
        MockGatewayMetaState gateway,  
                remoteStoreRestoreService,
            true
            randomNonNegativeLong(),
        CoordinationState.PersistedState gateway = null;  
                }  
        }
            assertThat(
                        Metadata.builder().clusterUUID(randomAlphaOfLength(10)).build()
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            final String indexName = randomAlphaOfLength(10);  
            for (int i = 0; i < iterations; i++) {  
            persistedState.setCurrentTerm(state.term());  
                final PersistedClusterStateService.OnDiskState onDiskState = newPersistedClusterStateService.loadBestOnDiskState();  
            }
            true
                wrapper.setRandomIOExceptionRateOnOpen(ioExceptionRate.get());
            } catch (IOError | Exception e) {
                return wrapper;  
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, randomRepoName)
        final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(  
import java.util.ArrayList;
                false
                        .put(IndexMetadata.INDEX_READ_ONLY_SETTING.getKey(), true)
import static org.mockito.Mockito.when;
        Mockito.when(remoteClusterStateService.writeFullMetadata(Mockito.any(), Mockito.any()))
        assertThat(remotePersistedState.getCurrentTerm(), equalTo(clusterTerm));  
            );  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
 * Modifications Copyright OpenSearch Contributors. See
            gatewayMetaStateSpy = Mockito.spy(gateway);
                final PersistedClusterStateService newPersistedClusterStateService = new PersistedClusterStateService(
        for (Path path : nodeEnvironment.nodeDataPaths()) {  
                    .coordinationMetadata(createCoordinationMetadata(term))  
            Version.CURRENT
                    remoteStoreRestoreService,
            assertThat(  
    public void testRemotePersistedStateFailureStats() throws IOException {  
            gateway = maybeNew(gateway);  
        builder.lastCommittedConfiguration(
            .add(localNode)
        remotePersistedState.setLastAcceptedState(thirdClusterState);  
        remotePersistedState.setLastAcceptedState(clusterState1);
                        .coordinationMetadata(expectedCoordinationMetadata)
                coordinationMetadata = createCoordinationMetadata(randomNonNegativeLong());  
            assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
            return;
        assertThat(remotePersistedState.getCurrentTerm(), equalTo(clusterTerm));  
import org.mockito.Mockito;
                if (isRemoteStoreClusterStateEnabled(settings)) {
                assertClusterStateEqual(  
            );  
            currentState  
                currentTerm,
                .build();  
            when(transportService.getThreadPool()).thenReturn(threadPool);  
        );  
            Settings settings = Settings.builder()
            : new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                .build();  
    }
            () -> 0L
            // generate random coordinationMetadata with different lastAcceptedConfiguration and lastCommittedConfiguration
            );  
    public void testSetLastAcceptedState() throws IOException {  
        CoordinationState.PersistedState remotePersistedState = new RemotePersistedState(remoteClusterStateService, previousClusterUUID);
        final long clusterTerm = randomNonNegativeLong();  
                .coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build())  
        gateway.start(
            assertBusy(() -> assertTrue(gateway.allPendingAsyncStatesWritten()));
            xContentRegistry(),
            randomNonNegativeLong(),
            randomNonNegativeLong(),
            gateway = newGatewayPersistedState();
        for (int i = 0; i < randomIntBetween(0, 5); i++) {
        final long clusterTerm = randomNonNegativeLong();
            .stateVersion(5L)  
            Settings settings = Settings.builder()
            final MockGatewayMetaState gateway = new MockGatewayMetaState(localNode, bigArrays);
            IOUtils.close(gatewayMetaStateSpy);
            for (int i = 0; i < randomIntBetween(1, 5); i++) {  
    }
            );
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(1L).build()).build(),  
            IOUtils.close(gateway);  
                        .clusterUUIDCommitted(true)  
        final AtomicReference<Double> ioExceptionRate = new AtomicReference<>(0.01d);
                gateway = maybeNew(gateway);  
            randomRepoName
        ClusterState clusterState3 = createClusterState(
            assertThat(gateway.getLastAcceptedState().metadata().index(indexName), equalTo(newIndexMetadata));
            final CoordinationState.PersistedState lucenePersistedState = gateway.getPersistedState();
        );
            assertTrue(cleanup.remove(gateway));
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false)))
        }
                )
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId());
                randomNonNegativeLong(),  
            .stateVersion(5L)
            );
        final ClusterState clusterState = createClusterState(
        try (
            assertThat(state.getVersion(), equalTo(Manifest.empty().getClusterStateVersion()));  
            verify(remoteClusterStateService).getLastKnownUUIDFromRemote(Mockito.any());  
    private MockGatewayMetaState gateway;
    public void testCurrentTermAndTermAreDifferent() throws IOException {
            assertThat(
            assertEquals(currentTerm, persistedState.getCurrentTerm());
        RemoteStoreRestoreService remoteStoreRestoreService,
                .lastCommittedConfiguration(coordinationMetadata.getLastAcceptedConfiguration())
                final PersistedClusterStateService.OnDiskState onDiskState = newPersistedClusterStateService.loadBestOnDiskState();
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(1L).build()).build()  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
            when(remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster")).thenReturn("test-cluster-uuid");
        );
                true
        super.tearDown();  
            .build();
    public void testGatewayMetaStateRemoteStateDownloadRetries() throws IOException {  
        final String previousClusterUUID = "prev-cluster-uuid";  
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build()).build(),
            PersistedState remotePersistedState = persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE);
                persistedStateRegistry,  
                }  
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()  
                equalTo(GatewayMetaState.AsyncLucenePersistedState.staleStateConfiguration)
            gateway.markLastAcceptedStateAsCommitted();
            .metadata(Metadata.builder(secondClusterState.getMetadata()).clusterUUID(randomAlphaOfLength(10)).build())
import org.opensearch.gateway.remote.ClusterMetadataManifest;
            gateway.setLastAcceptedState(newClusterState);
import org.opensearch.threadpool.ThreadPool;  
                .build();  
        MockGatewayMetaState gatewayMetaStateSpy = null;
            final IndexMetadata indexMetadata = createIndexMetadata(indexName, numberOfShards, version);
            DiscoveryNode localNode = new DiscoveryNode(
    }
            ClusterState expectedClusterState = ClusterState.builder(state)
                    randomNonNegativeLong(),  
                );
                    state,
    private BigArrays bigArrays;  
        }  
                } else {
        final String previousClusterUUID = "prev-cluster-uuid";
                .build();
                    () -> 0L
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
        try {  
    public void testStatePersistedOnLoad() throws IOException {
        MockGatewayMetaState gateway = null;
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build()).build(),
        remotePersistedState.markLastAcceptedStateAsCommitted();
                instanceOf(GatewayMetaState.LucenePersistedState.class)
                persistedStateRegistry,  
                createClusterState(
            gateway = maybeNew(gateway);
        nodeEnvironment.close();
            IOUtils.close(gateway);  
                    gatewayMetaStateSpy,  
package org.opensearch.gateway;
        assertThat(remotePersistedState.getLastAcceptedState(), equalTo(secondClusterState));
            )
            IOUtils.close(gateway);  
        assertTrue(Metadata.isGlobalStateEquals(actual.metadata(), expected.metadata()));  
                    return new RemoteClusterStateService(  
                false
                threadPool.shutdown();
import org.opensearch.common.util.io.IOUtils;  
                } else {
import org.opensearch.cluster.ClusterName;  
            .opensearchVersion(Version.CURRENT)  
                final long version = randomNonNegativeLong();
        Mockito.verify(remoteClusterStateService).writeFullMetadata(clusterStateCaptor.capture(), previousClusterUUIDCaptor.capture());  
                    final int numberOfShards = randomIntBetween(1, 5);
        assertEquals(clusterState, remotePersistedState.getLastAcceptedState());
        CoordinationState.PersistedState remotePersistedState = new RemotePersistedState(  
        }
                null,
            CoordinationMetadata coordinationMetadata;
                    getBigArrays(),
        MockGatewayMetaState gateway = null;  
        assertEquals(previousClusterUUID, previousClusterUUIDCaptor.getValue());
                .clusterUUIDCommitted(false)
        assertThat(remotePersistedState.getCurrentTerm(), equalTo(0L));
        Mockito.when(remoteClusterStateService.writeIncrementalMetadata(Mockito.any(), Mockito.any(), Mockito.any()))  
            persistedStateRegistry,
        for (Path path : nodeEnvironment.nodeDataPaths()) {
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
        assertEquals(secondClusterState, remotePersistedState.getLastAcceptedState());
        );  
            RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        return persistedState;  
            );
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build()).build(),  
            final ClusterState state = createClusterState(
                    getBigArrays(),  
            );
                        ),  
            IOUtils.close(gateway);
 *
            true
    }  
                        .metadata(onDiskState.metadata)
        );
                persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL),
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                Metadata.builder().coordinationMetadata(coordinationMetadata).clusterUUID(randomAlphaOfLength(10)).build()
            }
                lucenePersistedState.getLastAcceptedState().blocks().hasGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK),
                        List.of(
        try {
            nodeEnvironment,
                equalTo(true)
                    );
                        .clusterUUID(state.metadata().clusterUUID())
        when(transportService.getLocalNode()).thenReturn(mock(DiscoveryNode.class));
import org.opensearch.test.OpenSearchTestCase;
import static org.mockito.ArgumentMatchers.anyBoolean;
                persistedCoordinationMetadata.getLastAcceptedConfiguration(),
        Mockito.doThrow(IOException.class).when(remoteClusterStateService).writeFullMetadata(Mockito.any(), Mockito.any());
            RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
        assertEquals(clusterTerm, remotePersistedState.getCurrentTerm());
        assertEquals(1, remoteClusterStateService.getUploadStats().getFailedCount());
        CoordinationState.PersistedState gateway = null;
                .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), clusterName.value())  
                persistedCoordinationMetadata.getLastCommittedConfiguration(),  
import java.util.Collections;
                    currentTerm = currentTerm + (rarely() ? randomIntBetween(1, 5) : 0L);  
            gateway = newGatewayPersistedState();  
 */  
    }
            );
                persistedState.getLastAcceptedState().getLastAcceptedConfiguration(),
                    return null;
            persistedClusterStateService,  
            persistedCoordinationMetadata = persistedClusterStateService.loadBestOnDiskState().metadata.coordinationMetadata();  
            gateway = newGatewayForRemoteState(  
                Metadata.builder()
import org.opensearch.gateway.PersistedClusterStateService.Writer;
        }
        }
                coordinationMetadata = createCoordinationMetadata(randomNonNegativeLong());
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();  
        remotePersistedState.markLastAcceptedStateAsCommitted();
            .clusterTerm(1L)  
                    final ClusterState newState = createClusterState(  
            }
            }
            )
    }  
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
        when(clusterService.getClusterSettings()).thenReturn(
                    final IndexMetadata indexMetadata = createIndexMetadata(indexName, randomIntBetween(1, 5), randomNonNegativeLong());
        MockGatewayMetaState gateway = null;
        CoordinationState.PersistedState gateway = null;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        assertThrows(OpenSearchException.class, () -> remotePersistedState.setLastAcceptedState(clusterState));
            assertClusterStateEqual(expectedClusterState, persistedState.getLastAcceptedState());
            // generate a series of updates and check if batching works
                )
                        threadPool,  
        }
            Locale.getDefault(),
        );  
                remoteStoreRestoreService,
            true
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();  
            @Override
            final RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);  
                null,
        Mockito.verify(remoteClusterStateService).writeFullMetadata(clusterState2, previousClusterUUID);
            );
    public void testRemotePersistedStateWithDifferentNodeConfiguration() throws IOException {
                    );
        } finally {
            Collections.emptyMap(),  
import java.util.function.Supplier;
            IOUtils.close(gateway);
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);  
            remoteClusterStateService,
            );
                        .persistentSettings(Settings.builder().put(randomAlphaOfLength(10), randomAlphaOfLength(10)).build())  
            .stateVersion(5L)
            assertThat(state.getClusterName(), equalTo(clusterName));
        final long clusterTerm = randomNonNegativeLong();  
        clusterName = new ClusterName(randomAlphaOfLength(10));  
        final String previousClusterUUID = "prev-cluster-uuid";
        final String previousClusterUUID = "prev-cluster-uuid";  
import java.util.Locale;
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
            gateway.markLastAcceptedStateAsCommitted();
            .metadata(Metadata.builder(clusterState.getMetadata()).clusterUUID(randomAlphaOfLength(10)).clusterUUIDCommitted(false).build())  
    }  
            xContentRegistry(),
                assertNotNull(ExceptionsHelper.unwrap(e, IOException.class));  
        RemotePersistedState remotePersistedState = new RemotePersistedState(remoteClusterStateService, previousClusterUUID);  
                    .persistentSettings(Settings.builder().put(randomAlphaOfLength(10), randomAlphaOfLength(10)).build())
 * license agreements. See the NOTICE file distributed with
        settings = Settings.builder().put(ClusterName.CLUSTER_NAME_SETTING.getKey(), clusterName.value()).build();
    }
        Mockito.doThrow(IOException.class).when(remoteClusterStateService).writeFullMetadata(Mockito.any(), Mockito.any());
            .clusterTerm(1L)
                previousState.metadata().clusterUUID()
            assertThat(persistedState, instanceOf(GatewayMetaState.AsyncLucenePersistedState.class));  
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            gateway = newGatewayPersistedState();
            "node1",  
            }
        );
        PersistedStateRegistry persistedStateRegistry,
            final long newTerm = randomLongBetween(term + 1, Long.MAX_VALUE);  
            ClusterState state = createClusterState(
    }
                        Collections.emptyMap(),
        }  
import static org.mockito.Mockito.times;
                    final long version = randomNonNegativeLong();
import org.opensearch.common.util.set.Sets;
 */  
                .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "randomRepoName")  
        MockGatewayMetaState gateway = null;  
                .put(Node.NODE_NAME_SETTING.getKey(), "test")
    private ClusterState createClusterStateWithNodes(long version, Metadata metadata) {
                    lucenePersistedState.getLastAcceptedState().metadata().index("test-index1").getSettings()  
        Mockito.verify(remoteClusterStateService, times(1)).writeFullMetadata(secondClusterState, previousClusterUUID);  
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
                .build(),  
        );  
import org.opensearch.cluster.coordination.CoordinationMetadata;
                gateway.getLastAcceptedState().getLastAcceptedConfiguration(),
                    state = createClusterState(version, metadata);
            gateway = new MockGatewayMetaState(localNode, bigArrays, remoteClusterStateService, remoteStoreRestoreService);  
            final int numberOfShards = randomIntBetween(1, 5);
        Mockito.when(remoteClusterStateService.writeFullMetadata(Mockito.any(), Mockito.any()))
            ClusterService clusterService = mock(ClusterService.class);
                .build();
    }  
            );
        } finally {  
            );
                42L,
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenReturn(
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            assertBusy(() -> assertTrue(gateway.allPendingAsyncStatesWritten()));
        assertThat(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE), nullValue());
            .put(settings)  
                settings,  
            .build();
            logger.info("lucene state metadata: {}", lucenePersistedState.getLastAcceptedState().toString());
                .numberOfShards(5)
        localNode = new DiscoveryNode(
            final RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
    }
        assertThat(remotePersistedState.getLastAcceptedState().metadata().clusterUUIDCommitted(), equalTo(true));
                persistedClusterStateService,
            return newGatewayPersistedState();  
            verify(remoteClusterStateService).getLastKnownUUIDFromRemote(clusterName.value()); // change this
        );
                    Metadata.builder()  
            .build();
                persistedCoordinationMetadata.getLastAcceptedConfiguration(),
            null,
            );
import org.mockito.ArgumentCaptor;
            };
                    xContentRegistry(),
        // verify that the freshest state was rewritten to each data path
        remotePersistedState.setLastAcceptedState(clusterState);  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;
            do {
                    final long term = Math.min(state.term() + (rarely() ? randomIntBetween(1, 5) : 0L), currentTerm);
    private CoordinationState.PersistedState maybeNew(CoordinationState.PersistedState persistedState) throws IOException {  
            .settings(
                        .metadata(onDiskState.metadata)
            long currentTerm = gateway.getCurrentTerm();  
                    .build(),
                Metadata.builder().coordinationMetadata(createCoordinationMetadata(term)).put(indexMetadata, false).build()
                    ClusterState.EMPTY_STATE
        } finally {
                        .build()
            persistedState.markLastAcceptedStateAsCommitted();
            persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL),
        gateway = new MockGatewayMetaState(localNode, bigArrays);
            .thenReturn(new RemoteClusterStateManifestInfo(manifest2, "path/to/manifest3"));
            assertThat(lucenePersistedState.getLastAcceptedState().metadata(), equalTo(ClusterState.EMPTY_STATE.metadata()));  
            IOUtils.close(gateway);  
        }
            randomNonNegativeLong(),
            final ClusterState clusterState = createClusterState(
                list.add(wrapper);
            assertThat(lucenePersistedState.getLastAcceptedState().metadata().indices().get("test-index1"), equalTo(indexMetadata));
    }
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
                );
                "randomRepoName"  
                remoteClusterStateService,  
                RemoteRestoreResult.build("test-cluster-uuid", null, ClusterState.EMPTY_STATE)
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;  
            final CoordinationState.PersistedState persistedState = gateway.getPersistedState();
        return builder.build();
            remoteStateStats.stateFailed();
                        transportService,  
                    state = newState;
        );  
    }  
            when(remoteClusterStateService.getLastKnownUUIDFromRemote(clusterName.value())).thenReturn(ClusterState.UNKNOWN_UUID);
        Mockito.when(remoteClusterStateService.writeFullMetadata(Mockito.any(), Mockito.any()))  
        Mockito.when(remoteClusterStateService.writeFullMetadata(Mockito.any(), Mockito.any()))
                )  
                if (randomBoolean()) {
                assertFalse(onDiskState.empty());
            );  
            )
            .clusterTerm(1L)  
            null,
        );
            when(remoteClusterStateService.getLastKnownUUIDFromRemote(clusterName.value())).thenReturn("test-cluster-uuid");  
                wrapper.setRandomIOExceptionRate(ioExceptionRate.get());
import org.opensearch.common.collect.Tuple;  
    public void testGatewayForRemoteStateForNodeReboot() throws IOException {  
        } finally {
        assertThat(remotePersistedState.getLastAcceptedState(), equalTo(secondClusterState));
            assertThat(
            assertEquals(currentTerm, persistedState.getCurrentTerm());
                    new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
    private MockGatewayMetaState startGatewayForRemoteState(
            .thenReturn(new RemoteClusterStateManifestInfo(manifest, "path/to/manifest"));
                } else {  
        } finally {
        CoordinationState.PersistedState remotePersistedState = new RemotePersistedState(remoteClusterStateService, previousClusterUUID);  
            final RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
            xContentRegistry(),  
        return usually()  
        final ClusterState clusterState = createClusterState(
import org.opensearch.threadpool.TestThreadPool;
 * KIND, either express or implied.  See the License for the
                        IndexMetadata.builder("test-index1")
 * software distributed under the License is distributed on an
            );  
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(1L).build()).build(),
            .thenReturn(new RemoteClusterStateManifestInfo(manifest, "path/to/manifest2"));  
                persistedClusterStateService,  
            .version(version)  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
                nodeEnvironment,
        try {
 * the Apache License, Version 2.0 (the "License"); you may
                    settings(Version.CURRENT).put(SETTING_INDEX_UUID, randomAlphaOfLength(10))
        String randomRepoName = "randomRepoName";  
        assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
            Supplier<RemoteClusterStateService> remoteClusterStateServiceSupplier = () -> {
            .localNodeId(localNode.getId())  
        assertThat(
            ? BigArrays.NON_RECYCLING_INSTANCE
import org.opensearch.cluster.metadata.Metadata;
    public void testSetLastAcceptedStateTermChanged() throws IOException {
            );  
    }
            );
    public void testInitialState() throws IOException {
import org.opensearch.env.NodeEnvironment;
            gateway = newGatewayPersistedState();
                remoteClusterStateService,
            when(clusterService.getClusterSettings()).thenReturn(new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
    public void testDataOnlyNodePersistence() throws Exception {  
import org.opensearch.cluster.node.DiscoveryNodeRole;  
                .build(),
                    persistedState.setLastAcceptedState(newState);
            Writer writer = persistedClusterStateService.createWriter();
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()  
            verifyNoInteractions(remoteStoreRestoreService);
        try {
        } finally {
                gateway.setCurrentTerm(currentTerm);
        // open LucenePersistedState to make sure that cluster state is written out to each data path
                .metadata(
                        () -> 0L,
            .clusterTerm(1L)
                        settings,  
                        .coordinationMetadata(expectedCoordinationMetadata)
        assertEquals(secondClusterState, remotePersistedState.getLastAcceptedState());  
            if (ioExceptionRate.get() == 0.0d) {
import static org.mockito.Mockito.never;  
import org.apache.lucene.store.Directory;
            Metadata.builder()  
            .build();
            nodesBuilder.clusterManagerNodeId(localNode.getId());  
                );  
                        .build()  
            final IndexMetadata indexMetadata = IndexMetadata.builder("test-index1")  
            for (int i = 0; i < randomIntBetween(1, 5); i++) {  
            }
                        .build();  
                );  
            ClusterState expectedClusterState = ClusterState.builder(state)
import org.opensearch.node.Node;
 * not use this file except in compliance with the License.
                final Metadata metadata = Metadata.builder()
                    ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    );  
        assertFalse(remotePersistedState.getLastAcceptedManifest().isCommitted());
                    final long newTerm = currentTerm + 1;
 * this work for additional information regarding copyright
                    .clusterUUID(randomAlphaOfLength(10))
    private ClusterState createClusterState(long version, Metadata metadata) {
        );
            IOUtils.close(gateway);  
        );
        final CoordinationState.PersistedState persistedState = gateway.getPersistedState();
                    remoteClusterStateService,
                        writableRegistry(),
        }
    }
            verifyNoInteractions(remoteStoreRestoreService);  
            assertTrue(Metadata.isGlobalStateEquals(state.metadata(), Metadata.EMPTY_METADATA));
            Collections.emptyMap(),
            String stateRepoSettingsAttributeKeyPrefix = String.format(
        try {  
        assertTrue(remotePersistedState.getLastAcceptedState().metadata().clusterUUIDCommitted());
    private IndexMetadata createIndexMetadata(String indexName, int numberOfShards, long version) {
    private void assertClusterStateEqual(ClusterState expected, ClusterState actual) {
                    randomNonNegativeLong(),
        final MetaStateService metaStateService = mock(MetaStateService.class);  
 * under the License.  
        }  
            when(remoteClusterStateService.getLastKnownUUIDFromRemote(clusterName.value())).thenReturn(  
        when(remoteClusterStateService.getUploadStats()).thenReturn(remoteStateStats);
                ClusterState.EMPTY_STATE,
                    ClusterState.builder(ClusterName.DEFAULT)
        clusterState = ClusterState.builder(clusterState)
            PersistedState remotePersistedState = persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE);
        builder.term(term);  
            RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);  
        if (!ClusterState.EMPTY_STATE.equals(currentState)) {
            gatewayMetaStateSpy = Mockito.spy(gateway);  
        ClusterState clusterState1 = createClusterStateWithNodes(
    }  
        }
        assertEquals(0, remoteClusterStateService.getUploadStats().getSuccessCount());  
                instanceOf(GatewayMetaState.RemotePersistedState.class)  
        try {  
            buildNewFakeTransportAddress(),
            gateway = newGatewayPersistedState();
                .build();  
            getBigArrays(),
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        );  
                not(equalTo(persistedState.getLastAcceptedState().getLastCommittedConfiguration()))  
            assertThat(currentTerm, equalTo(Manifest.empty().getCurrentTerm()));
            .build();
                Version.CURRENT  
import org.opensearch.cluster.metadata.IndexMetadata;
            verify(remoteClusterStateService).getLastKnownUUIDFromRemote(Mockito.any()); // change this  
