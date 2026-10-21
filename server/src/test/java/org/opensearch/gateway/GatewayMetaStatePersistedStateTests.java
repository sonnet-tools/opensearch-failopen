                wrapper.setRandomIOExceptionRateOnOpen(ioExceptionRate.get());
            ).thenReturn(RemoteRestoreResult.build("test-cluster-uuid", null, ClusterState.EMPTY_STATE));
        CoordinationState.PersistedState gateway = null;
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build()).build(),
            remoteStateStats.stateFailed();
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            final long term = randomValueOtherThan(Long.MAX_VALUE, OpenSearchTestCase::randomNonNegativeLong);
                    );
        boolean prepareFullState
                instanceOf(GatewayMetaState.RemotePersistedState.class)
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            .build();
                    );
                    .clusterUUID(randomAlphaOfLength(10))
            for (MockDirectoryWrapper wrapper : list) {
import org.opensearch.index.recovery.RemoteStoreRestoreService;
                    xContentRegistry(),
        assertThat(remotePersistedState.getCurrentTerm(), equalTo(clusterTerm));
    public void testGatewayMetaStateRemoteStateDownloadRetries() throws IOException {
                    state = createClusterState(
        );
        }
import org.opensearch.gateway.GatewayMetaState.RemotePersistedState;
import org.apache.lucene.tests.store.MockDirectoryWrapper;
                    persistedStateRegistry,
            final ClusterState clusterState = ClusterState.builder(
            long currentTerm = randomNonNegativeLong();
            Writer writer = persistedClusterStateService.createWriter();
            gateway = newGatewayPersistedState();
                not(equalTo(gateway.getLastAcceptedState().getLastCommittedConfiguration()))
            .stateVersion(5L)
    }
            IOUtils.close(gateway);
        final String previousClusterUUID = "prev-cluster-uuid";
            final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
            for (int i = 0; i < randomIntBetween(1, 5); i++) {
    public void testSetLastAcceptedState() throws IOException {
        );
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, randomRepoName)
import org.opensearch.ExceptionsHelper;
                        transportService,
                equalTo(GatewayMetaState.AsyncLucenePersistedState.staleStateConfiguration)
            long term = randomValueOtherThan(currentTerm, OpenSearchTestCase::randomNonNegativeLong);
                assertClusterStateEqual(state, lastAcceptedState);
 * Unless required by applicable law or agreed to in writing,
            assertThat(lucenePersistedState.getLastAcceptedState().metadata(), equalTo(previousState.metadata()));
                        .coordinationMetadata(CoordinationMetadata.builder().term(randomLong()).build())
            when(remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster")).thenReturn("test-cluster-uuid");
        assertEquals(secondClusterState, remotePersistedState.getLastAcceptedState());
            final CoordinationState.PersistedState lucenePersistedState = gateway.getPersistedState();
            }
import org.opensearch.common.util.BigArrays;
                assertNotNull(ExceptionsHelper.unwrap(e, IOException.class));
            persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL),
            "node1",
            null,
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false)))
                clusterState,
        super.tearDown();
            );
                    .coordinationMetadata(CoordinationMetadata.builder().term(randomLong()).build())
                            .numberOfReplicas(1)
                IndexMetadata.INDEX_READ_ONLY_SETTING.get(
            assertThat(gateway.getCurrentTerm(), equalTo(currentTerm));
                previousState.metadata().clusterUUID()
                        randomNonNegativeLong(),
                persistedCoordinationMetadata.getLastCommittedConfiguration(),
                Metadata.builder().coordinationMetadata(createCoordinationMetadata(term)).put(indexMetadata, false).build()
        when(remoteClusterStateService.markLastStateAsCommitted(Mockito.any(), Mockito.any(), eq(false))).thenReturn(
        Mockito.verify(remoteClusterStateService).writeFullMetadata(clusterStateCaptor.capture(), previousClusterUUIDCaptor.capture());
            .stateVersion(5L)
                    Supplier<RepositoriesService> repositoriesServiceSupplier = () -> new RepositoriesService(
    }
                ClusterState lastAcceptedState = gateway.getLastAcceptedState();
    public void testGatewayForRemoteStateForInitialBootstrap() throws IOException {
                    // update cluster state
                final long version = randomNonNegativeLong();
        assertThat(persistedState, instanceOf(GatewayMetaState.LucenePersistedState.class));
    }
                        Collections.emptyMap(),
                persistedStateRegistry,
            .clusterTerm(1L)
                        transportService.getThreadPool()
            );
            gateway = newGatewayPersistedState();
                persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL),
            IOUtils.close(gatewayMetaStateSpy);
            false
                        settings,
        try {
                randomNonNegativeLong(),
        assertThat(remotePersistedState.getLastAcceptedState(), equalTo(secondClusterState));
            true
                    ClusterState.EMPTY_STATE
            do {
                .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "randomRepoName")
import org.apache.lucene.store.Directory;
            verify(remoteStoreRestoreService).restore(any(ClusterState.class), any(String.class), anyBoolean(), any(String[].class));
                            )
                throw e;
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    private DiscoveryNode localNode;
                    false
            final RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;
        Mockito.when(remoteClusterStateService.getLatestClusterMetadataManifest(Mockito.any(), Mockito.any()))
                    persistedState.setCurrentTerm(currentTerm);
        for (Path path : nodeEnvironment.nodeDataPaths()) {
            persistedCoordinationMetadata = persistedClusterStateService.loadBestOnDiskState().metadata.coordinationMetadata();
        } finally {
            GatewayMetaState.LucenePersistedState ignored = new GatewayMetaState.LucenePersistedState(
        assertThat(actual.version(), equalTo(expected.version()));
        final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
            IOUtils.close(gateway);
        final String previousClusterUUID = "prev-cluster-uuid";
            gateway.close();
            when(remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster")).thenReturn("test-cluster-uuid");
        Mockito.verify(remoteClusterStateService, never()).writeFullMetadata(clusterState, previousClusterUUID);
        builder.term(term);
        assertThrows(OpenSearchException.class, () -> remotePersistedState.setLastAcceptedState(clusterState));
                    );
                        state.version() + 1,
                if (randomBoolean()) {
                assertThat(onDiskState.currentTerm, equalTo(currentTerm));
    }
            assertThat(
        String stateRepoSettingsAttributeKeyPrefix = String.format(
            );
                .build();
                        .clusterUUIDCommitted(true)
                        .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
            assertThat(lucenePersistedState.getLastAcceptedState().metadata(), equalTo(ClusterState.EMPTY_STATE.metadata()));
    }
        try {
    private IndexMetadata createIndexMetadata(String indexName, int numberOfShards, long version) {
            assertBusy(() -> assertTrue(gateway.allPendingAsyncStatesWritten()));
            final RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
        when(remoteClusterStateService.getUploadStats()).thenReturn(remoteStateStats);
            assertEquals(state, persistedState.getLastAcceptedState());
        ClusterState clusterState = createClusterState(
        Mockito.when(remoteClusterStateService.writeIncrementalMetadata(Mockito.any(), Mockito.any(), Mockito.any()))
                    Metadata.builder()
            remoteClusterStateService,
        RemoteClusterStateService remoteClusterStateService,
        localNode = new DiscoveryNode(
        when(metaStateService.loadFullState()).thenReturn(new Tuple<>(Manifest.empty(), ClusterState.EMPTY_STATE.metadata()));
                false
                        .coordinationMetadata(expectedCoordinationMetadata)
        Mockito.when(remoteClusterStateService.writeFullMetadata(Mockito.any(), Mockito.any()))
    }
        } finally {
        MockGatewayMetaState gateway = null;
            try {
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        when(clusterService.getClusterSettings()).thenReturn(
                )
    }
    public void testRemotePersistentState_FollowerNode() throws IOException {
    public void testInitialState() throws IOException {
            gateway.setLastAcceptedState(newClusterState);
                gateway = maybeNew(gateway);
        }
        gateway.start(
            assertThat(persistedState, instanceOf(GatewayMetaState.LucenePersistedState.class));
        when(transportService.getLocalNode()).thenReturn(mock(DiscoveryNode.class));
        MockGatewayMetaState gateway = null;
                } else {
        Mockito.when(remoteClusterStateService.writeFullMetadata(Mockito.any(), Mockito.any()))
        MockGatewayMetaState gateway = null;
        MockGatewayMetaState gateway = null;
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
            );
            )
                    getBigArrays(),
            ? BigArrays.NON_RECYCLING_INSTANCE
        try {
        try (
                    final long newTerm = currentTerm + 1;
                    ClusterState.builder(ClusterName.DEFAULT)
import org.opensearch.common.util.MockBigArrays;
                RemoteRestoreResult.build("test-cluster-uuid", null, clusterState)
            assertThat(currentTerm, equalTo(Manifest.empty().getCurrentTerm()));
            final ClusterState state = createClusterState(
        } finally {
                threadPool.shutdown();
    }
            clusterService,
        };
            assertNotNull(ExceptionsHelper.unwrap(e, IOException.class));
            }
        for (int i = 0; i < randomIntBetween(0, 5); i++) {
                remoteStoreRestoreService,
                .build();
                            .settings(settings(Version.CURRENT).put(SETTING_INDEX_UUID, randomAlphaOfLength(10)))
            .version(version)
            gateway = newGatewayPersistedState();
import org.opensearch.node.Node;
import static org.mockito.Mockito.never;
import org.opensearch.repositories.fs.FsRepository;
            assertThat(persistedState, instanceOf(GatewayMetaState.AsyncLucenePersistedState.class));
        if (randomBoolean()) {
    }
                }
import org.opensearch.env.TestEnvironment;
                    state,
                        .metadata(onDiskState.metadata)
            transportService,
                        .put(IndexMetadata.INDEX_READ_ONLY_SETTING.getKey(), true)
                transportService,
        }
            assertTrue(persistedClusterStateService.loadBestOnDiskState().metadata.clusterUUIDCommitted());
        );
            gateway = initializeGatewayForRemoteState(true);
        }
                assertClusterStateEqual(
            randomRepoName
            builder.addVotingConfigExclusion(new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10)));
            verify(remoteStoreRestoreService).restore(any(), any(), anyBoolean(), any());
            remoteStoreRestoreService,
        assertNull(remotePersistedState.getLastAcceptedManifest());
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
        assertThat(remotePersistedState.getCurrentTerm(), equalTo(0L));
        );
                persistedStateRegistry,
            persistedStateRegistry,
                .numberOfReplicas(1)
                    ClusterState.builder(ClusterName.DEFAULT)
                    final long version = randomNonNegativeLong();
                    final long term = Math.min(state.term() + (rarely() ? randomIntBetween(1, 5) : 0L), currentTerm);
                );
                randomNonNegativeLong(),
                false
import org.opensearch.cluster.ClusterName;
        assertEquals(secondClusterState, remotePersistedState.getLastAcceptedState());
    @Override
            remoteClusterStateService,
            .clusterManagerNodeId(localNode.getId())
            logger.info("lucene state metadata: {}", lucenePersistedState.getLastAcceptedState().toString());
    }
                    currentTerm += 1;
            gateway = maybeNew(gateway);
        } finally {
            true
            }
import static org.mockito.ArgumentMatchers.any;
                assertFalse(onDiskState.empty());
        MockGatewayMetaState gatewayMetaStateSpy = null;
import org.opensearch.common.settings.Settings;
                Metadata.isGlobalStateEquals(lucenePersistedState.getLastAcceptedState().metadata(), clusterState.metadata()),
            buildNewFakeTransportAddress(),
package org.opensearch.gateway;
            CoordinationMetadata persistedCoordinationMetadata = persistedClusterStateService.loadBestOnDiskState().metadata
            verify(remoteClusterStateService).getLastKnownUUIDFromRemote(Mockito.any()); // change this
            final IndexMetadata indexMetadata = IndexMetadata.builder("test-index1")
        final String previousClusterUUID = "prev-cluster-uuid";
        Mockito.verify(remoteClusterStateService, times(1)).markLastStateAsCommitted(Mockito.any(), Mockito.any(), eq(false));
            CoordinationMetadata coordinationMetadata;
            assertThat(state.getVersion(), equalTo(Manifest.empty().getClusterStateVersion()));
            gateway = maybeNew(gateway);
            gateway.start(settings, nodeEnvironment, xContentRegistry(), persistedStateRegistry);
            do {
                Metadata.builder().coordinationMetadata(createCoordinationMetadata(newTerm)).put(newIndexMetadata, false).build()
        }
            );
    private NodeEnvironment nodeEnvironment;
    private MockGatewayMetaState gateway;
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
        RemoteClusterStateService remoteClusterStateService,
        final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
        final long clusterTerm = randomNonNegativeLong();
        }
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            IOUtils.close(cleanup);
    public void testGatewayForRemoteStateForNodeReplacement() throws IOException {
            );
    }
                    )
            () -> 0L
 * the Apache License, Version 2.0 (the "License"); you may
                gatewayMetaStateSpy,
                remoteStoreRestoreService,
import java.util.Collections;
import java.io.IOError;
        }
            RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
import org.opensearch.OpenSearchException;
        CoordinationState.PersistedState remotePersistedState = new RemotePersistedState(remoteClusterStateService, previousClusterUUID);
        RemoteStoreRestoreService remoteStoreRestoreService,
        ) {
            );
        return createClusterState(version, metadata, false);
                equalTo(true)
        Settings settingWithRemoteStateEnabled = Settings.builder()
        } finally {
        MockGatewayMetaState gateway,
    public void testGatewayForRemoteStateForNodeReboot() throws IOException {
            );
                final Metadata metadata = Metadata.builder()
                .build(),
        }
                Settings.builder()
        Mockito.verify(remoteClusterStateService, never()).writeFullMetadata(secondClusterState, previousClusterUUID);
 * not use this file except in compliance with the License.
            PersistedState remotePersistedState = persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE);
                    .put(indexMetadata, false)
                .build();
        final List<MockDirectoryWrapper> list = new ArrayList<>();
                null
        }
            gateway = maybeNew(gateway);
            for (int i = 0; i < randomIntBetween(1, 5); i++) {
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenReturn(
            final int newNumberOfShards = randomValueOtherThan(numberOfShards, () -> randomIntBetween(1, 5));
        MockGatewayMetaState gatewayMetaState = initializeGatewayForRemoteState(prepareFullState);
        }
        ClusterService clusterService = mock(ClusterService.class);
            RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
            );
                        .coordinationMetadata(createCoordinationMetadata(1L))
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
import org.opensearch.common.collect.Tuple;
import java.util.ArrayList;
                        IndexMetadata.builder("test-index1")
        }
                final long currentTerm = randomNonNegativeLong();
            final CoordinationState.PersistedState persistedState = gateway.getPersistedState();
                .build();
                .put(Environment.PATH_DATA_SETTING.getKey(), path.getParent().getParent().toString())
            final RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(1L).build()).build(),
        ) {
                .put(Environment.PATH_DATA_SETTING.getKey(), path.getParent().getParent().toString())
            Locale.getDefault(),
    }
                ClusterState.EMPTY_STATE,
            );
            .thenReturn(new RemoteClusterStateManifestInfo(manifest, "path/to/manifest"));
    }
import java.util.Optional;
            );
    private CoordinationMetadata createCoordinationMetadata(long term) {
                nodeEnvironment,
        final String previousClusterUUID = "prev-cluster-uuid";
            when(remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster")).thenReturn("test-cluster-uuid");
                assertEquals(currentTerm, reloadedPersistedState.getCurrentTerm());
        remotePersistedState.setLastAcceptedManifest(manifest);
        }
        assertNull(remotePersistedState.getLastAcceptedState());
    }
        );
                        .persistentSettings(Settings.builder().put(randomAlphaOfLength(10), randomAlphaOfLength(10)).build())
        assertFalse(remotePersistedState.getLastAcceptedState().metadata().clusterUUIDCommitted());
            .build();
    public void tearDown() throws Exception {
                } else {
        remotePersistedState.markLastAcceptedStateAsCommitted();
                        .put(indexMetadata, false)
import static org.mockito.Mockito.when;
            final ClusterState newClusterState = createClusterState(
        CoordinationState.PersistedState gateway = null;
    }
 * GitHub history for details.
        ClusterState state = createClusterState(randomNonNegativeLong(), Metadata.builder().clusterUUID(randomAlphaOfLength(10)).build());
                Metadata.builder()
                        Collections.emptyMap(),
                        .clusterUUID(ClusterState.UNKNOWN_UUID)
        for (Path path : nodeEnvironment.nodeDataPaths()) {
    @Override
            final String indexName = randomAlphaOfLength(10);
        } finally {
    public void testRemotePersistedState() throws IOException {
    public void testStatePersistenceWithIOIssues() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
                    .build();
                            .numberOfShards(5)
                assertNotNull(reloadedPersistedState.getLastAcceptedState().metadata().index(indexName));
        );
            randomNonNegativeLong(),
            final String indexName = randomAlphaOfLength(10);
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
                    persistedState.setCurrentTerm(newTerm);
        RemotePersistedState remotePersistedState = new RemotePersistedState(remoteClusterStateService, previousClusterUUID);
            remoteStoreRestoreService
                gateway = maybeNew(gateway);
                Collections.emptyMap(),
                )
            );
    }
        }
        Mockito.verify(remoteClusterStateService).writeFullMetadata(clusterState2, previousClusterUUID);
            gateway.markLastAcceptedStateAsCommitted();
            // generate random coordinationMetadata with different lastAcceptedConfiguration and lastCommittedConfiguration
                    .coordinationMetadata(createCoordinationMetadata(term))
            for (int i = 0; i < iterations; i++) {
            randomNonNegativeLong(),
    public void testGatewayForRemoteState() throws IOException {
                }
                list.add(wrapper);
        RemoteStoreRestoreService remoteStoreRestoreService,
            String stateRepoSettingsAttributeKeyPrefix = String.format(
                    return new RemoteClusterStateService(
        );
            );
            long currentTerm = state.term();
            assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testCurrentTermAndTermAreDifferent() throws IOException {
                RemoteRestoreResult.build("test-cluster-uuid", null, ClusterState.EMPTY_STATE)
        assertThat(remotePersistedState.getCurrentTerm(), equalTo(0L));
            when(remoteClusterStateService.getLastKnownUUIDFromRemote(clusterName.value())).thenReturn(
            .metadata(Metadata.builder(secondClusterState.getMetadata()).clusterUUID(randomAlphaOfLength(10)).build())
                "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            final int iterations = randomIntBetween(1, 1000);
            gateway.setLastAcceptedState(state);
                if (randomBoolean()) {
    public void testRemotePersistedStateExceptionOnFullStateUpload() throws IOException {
        startGatewayForRemoteState(
            );
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    getBigArrays(),
        );
                        .build()
            IOUtils.close(gateway);
                Sets.newHashSet(DiscoveryNodeRole.DATA_ROLE),
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder().clusterTerm(1L).stateVersion(5L).build();
            Metadata.builder().clusterUUID(randomAlphaOfLength(10)).build()
                        .build(),
                new MetaStateService(nodeEnvironment, xContentRegistry()),
            Collections.emptyMap(),
                remoteClusterStateService,
            } while (coordinationMetadata.getLastAcceptedConfiguration().equals(coordinationMetadata.getLastCommittedConfiguration()));
                assertClusterStateEqual(
            startGatewayForRemoteState(
        Mockito.verify(remoteClusterStateService).writeIncrementalMetadata(clusterState2, clusterState3, manifest2);
                persistedStateRegistry,
            Supplier<RemoteClusterStateService> remoteClusterStateServiceSupplier = () -> {
        assertThat(remotePersistedState.getCurrentTerm(), equalTo(clusterTerm));
            );
        Mockito.verify(remoteClusterStateService, never()).markLastStateAsCommitted(Mockito.any(), Mockito.any(), eq(false));
                randomNonNegativeLong(),
            assertThat(
        nodeEnvironment.close();
            final CoordinationState.PersistedState lucenePersistedState = gateway.getPersistedState();
            );
                createClusterState(
        final ClusterState clusterState = createClusterState(
import static org.mockito.ArgumentMatchers.anyBoolean;
            nodeEnvironment,
        assertEquals(clusterTerm, remotePersistedState.getCurrentTerm());
        } catch (IOError | Exception e) {
        clusterName = new ClusterName(randomAlphaOfLength(10));
    }
import java.nio.file.Path;
 *
            }
                    return null;
            }
            randomNonNegativeLong(),
        CoordinationState.PersistedState remotePersistedState = new RemotePersistedState(
        assertThat(
            : new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            IOUtils.close(gateway);
    }
            assertThat(
        final ClusterState thirdClusterState = ClusterState.builder(secondClusterState)
import org.opensearch.cluster.node.DiscoveryNodes;
                persistedCoordinationMetadata.getLastAcceptedConfiguration(),
            ClusterState state = gateway.getLastAcceptedState();
                new IllegalStateException("unable to download cluster state")
                    Metadata.builder()
        try {
        }
            );
    }
                }
        // verify that the freshest state was rewritten to each data path
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false)))
                                threadPool,
        final long clusterTerm = randomNonNegativeLong();
            try (CoordinationState.PersistedState reloadedPersistedState = newGatewayPersistedState()) {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.isRemoteStoreClusterStateEnabled;
                .put(nonClusterManagerNode())
                "node1",
            remoteClusterStateService,
            assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
            assertTrue(Metadata.isGlobalStateEquals(state.metadata(), Metadata.EMPTY_METADATA));
        );
    ) throws IOException {
                equalTo(GatewayMetaState.AsyncLucenePersistedState.staleStateConfiguration)
                .settings(
            .put(stateRepoTypeAttributeKey, FsRepository.TYPE)
            final IndexMetadata newIndexMetadata = createIndexMetadata(indexName, newNumberOfShards, version);
    public void testGatewayMetaStateRemoteStateDownloadFailure() throws IOException {
                        .metadata(onDiskState.metadata)
            assertThat(actual.metadata().index(indexMetadata.getIndex()), equalTo(indexMetadata));
            verifyNoInteractions(remoteStoreRestoreService);
    private CoordinationState.PersistedState maybeNew(CoordinationState.PersistedState persistedState) throws IOException {
        if (isClusterManagerNode) {
                    persistedState.setLastAcceptedState(state);
            assertClusterStateEqual(state, persistedState.getLastAcceptedState());
import org.opensearch.common.util.io.IOUtils;
                return wrapper;
                        .clusterUUID(state.metadata().clusterUUID())
                );
public class GatewayMetaStatePersistedStateTests extends OpenSearchTestCase {
                "randomRepoName"
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
                wrapper.setAllowRandomFileNotFoundException(randomBoolean());
            .previousClusterUUID(previousClusterUUID)
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
    public void testSetCurrentTerm() throws IOException {
                ClusterState state = createClusterState(version, metadata);
                randomNonNegativeLong(),
        final long clusterTerm = randomNonNegativeLong();
            assertBusy(() -> assertTrue(gateway.allPendingAsyncStatesWritten()));
        final ClusterState clusterState = createClusterState(
                        .clusterUUID(state.metadata().clusterUUID())
        super.setUp();
            assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
        remotePersistedState.setLastAcceptedState(clusterState2);
                42L,
                .numberOfReplicas(1)
            Settings settings = Settings.builder()
                .metadata(
                    randomNonNegativeLong(),
            persistedState.markLastAcceptedStateAsCommitted();
                            new RemoteIndexPathUploader(
                    randomNonNegativeLong(),
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenReturn(
        } finally {
                final PersistedClusterStateService.OnDiskState onDiskState = newPersistedClusterStateService.loadBestOnDiskState();
            );
        RemoteUploadStats remoteStateStats = new RemoteUploadStats();
                    state = newState;
                    Metadata.builder()
        clusterState = ClusterState.builder(clusterState)
            gateway = new MockGatewayMetaState(localNode, bigArrays, remoteClusterStateService, remoteStoreRestoreService);
 * Licensed to Elasticsearch under one or more contributor
                final String indexName = randomAlphaOfLength(10);
                ClusterState.EMPTY_STATE,
            .build();
    private MockGatewayMetaState initializeGatewayForRemoteState(boolean prepareFullState) {
                persistedStateRegistry,
            cleanup.add(() -> {
                getBigArrays(),
            .build();
                .put(stateRepoTypeAttributeKey, FsRepository.TYPE)
            final int numberOfShards = randomIntBetween(1, 5);
            randomNonNegativeLong(),
                "randomRepoName"
        );
import org.opensearch.common.settings.ClusterSettings;
            Version.CURRENT
            )
            persistedStateRegistry,
                        clusterService,
                            .build(),
                );
import org.opensearch.common.util.set.Sets;
        }
            );
            final long term = randomNonNegativeLong();
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
            gateway = maybeNew(gateway);
                    .clusterUUID(randomAlphaOfLength(10))
            gateway = newGatewayForRemoteState(
        );
import org.opensearch.transport.TransportService;
            Version.V_2_13_0
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(
                .numberOfShards(5)
            .add(oldNode)
            gateway.start(
    }
                null,
                        nodeEnvironment.nodeId(),
            getBigArrays(),
                    .build(),
        builder.lastAcceptedConfiguration(
        CoordinationState.PersistedState remotePersistedState = new RemotePersistedState(remoteClusterStateService, previousClusterUUID);
                .clusterUUIDCommitted(false)
        } finally {
            ClusterState expectedClusterState = ClusterState.builder(state)
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        assertFalse(remotePersistedState.getLastAcceptedManifest().isCommitted());
            gateway = maybeNew(gateway);
            .put(settings)
                new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        );
            currentState
                true
        assertThat(remotePersistedState.getLastAcceptedState().metadata().clusterUUIDCommitted(), equalTo(false));
            final RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
import static org.mockito.Mockito.times;
                settings,
            final ClusterState previousState = createClusterState(
import org.opensearch.gateway.remote.RemoteClusterStateService;
            null,
            final RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
 *
        // open LucenePersistedState to make sure that cluster state is written out to each data path
        try {
            CoordinationMetadata expectedCoordinationMetadata = CoordinationMetadata.builder(coordinationMetadata)
    }
            @Override
        final ClusterState secondClusterState = createClusterState(
        assertThat(remotePersistedState.getLastAcceptedState().metadata().clusterUUIDCommitted(), equalTo(true));
    public void testRemotePersistedStateWithDifferentNodeConfiguration() throws IOException {
            xContentRegistry(),
    }
            .build();
        IOUtils.close(gateway);
                currentTerm,
                wrapper.setRandomIOExceptionRateOnOpen(ioExceptionRate.get());
                                clusterSettings,
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
        final AtomicReference<Double> ioExceptionRate = new AtomicReference<>(0.01d);
        nodeEnvironment.close();
    }
import org.opensearch.cluster.metadata.Metadata;
            IOUtils.close(gateway);
    private ClusterState createClusterState(long version, Metadata metadata) {
        assertEquals(manifest, remotePersistedState.getLastAcceptedManifest());
                        () -> 0L,
            nodeEnvironment,
        }
        } finally {
            randomNonNegativeLong(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return IndexMetadata.builder(indexName)
                Error.class,
        Mockito.doThrow(IOException.class).when(remoteClusterStateService).writeFullMetadata(Mockito.any(), Mockito.any());
            );
        String stateRepoTypeAttributeKey = String.format(
        assertThat(remotePersistedState.getCurrentTerm(), equalTo(clusterTerm));
        );
        Mockito.verify(remoteClusterStateService, times(1)).writeFullMetadata(secondClusterState, previousClusterUUID);
import static org.mockito.Mockito.verifyNoInteractions;
                    .build(),
                state
        );
                not(equalTo(persistedState.getLastAcceptedState().getLastCommittedConfiguration()))
                        List.of(
            .codecVersion(MANIFEST_CURRENT_CODEC_VERSION)
                                settings,
            assertTrue(cleanup.remove(gateway));
                    reloadedPersistedState.getLastAcceptedState()
 * license agreements. See the NOTICE file distributed with
            );
            assertThat(lucenePersistedState.getLastAcceptedState().metadata().indices().get("test-index1"), equalTo(indexMetadata));
            assertEquals(currentTerm, persistedState.getCurrentTerm());
    public void testDataOnlyNodePersistence() throws Exception {
            .thenReturn(new RemoteClusterStateManifestInfo(manifest, "path/to/manifest"));
            .add(localNode)
            verifyNoInteractions(remoteStoreRestoreService);
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            );
        MockGatewayMetaState gateway = null;
                remoteClusterStateService,
            verifyNoInteractions(remoteClusterStateService);
            return newGatewayPersistedState();
import org.opensearch.common.util.MockPageCacheRecycler;
            )
    }
                ClusterState.EMPTY_STATE,
                persistedClusterStateService,
            Sets.newHashSet(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        ArgumentCaptor<String> previousClusterUUIDCaptor = ArgumentCaptor.forClass(String.class);
                equalTo(true)
        remotePersistedState.markLastAcceptedStateAsCommitted();
            IOUtils.close(gateway);
        try {
                createClusterState(
        Mockito.when(remoteClusterStateService.writeFullMetadata(Mockito.any(), Mockito.any()))
            gateway = newGatewayForRemoteState(
                lucenePersistedState.getLastAcceptedState().blocks().hasGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK),
            assertThat(
            true
            // generate random coordinationMetadata with different lastAcceptedConfiguration and lastCommittedConfiguration
                () -> startGatewayForRemoteState(
        } finally {
        CoordinationState.PersistedState remotePersistedState = new RemotePersistedState(remoteClusterStateService, previousClusterUUID);
import org.opensearch.cluster.metadata.Manifest;
            final CoordinationState.PersistedState lucenePersistedState = gateway.getPersistedState();
                state
            when(remoteClusterStateService.getLastKnownUUIDFromRemote(clusterName.value())).thenReturn("test-cluster-uuid");
                    state = createClusterState(version, metadata);
import org.opensearch.cluster.node.DiscoveryNode;
        assertThrows(OpenSearchException.class, () -> remotePersistedState.setLastAcceptedState(clusterState));
                    remoteClusterStateService,
            final IndexMetadata indexMetadata = IndexMetadata.builder("test-index1")
                .coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build())
            CoordinationMetadata coordinationMetadata;
            instanceOf(GatewayMetaState.LucenePersistedState.class)
            .opensearchVersion(Version.V_2_15_0)
            randomNonNegativeLong(),
        try (
import org.opensearch.gateway.remote.ClusterMetadataManifest;
import java.util.Locale;
            assertThat(lucenePersistedState.getLastAcceptedState().metadata().indices().size(), equalTo(1));
            true
            TestThreadPool threadPool = new TestThreadPool("testMarkAcceptedConfigAsCommittedOnDataOnlyNode");
                final PersistedClusterStateService newPersistedClusterStateService = new PersistedClusterStateService(
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
                Version.CURRENT
                assertClusterStateEqual(
        return builder.build();
import org.mockito.Mockito;
import java.util.List;
        IOUtils.close(gateway);
                    Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(term).build()).build()
            metaStateService,
        final long clusterTerm = randomNonNegativeLong();
 * software distributed under the License is distributed on an
import java.util.function.Supplier;
 * specific language governing permissions and limitations
import org.opensearch.Version;
    public void setUp() throws Exception {
                .build();
            gateway = newGatewayPersistedState();
        final MockGatewayMetaState gatewayMetaStateSpy;
                    nodeEnvironment,
                assertFalse(onDiskState.empty());
                Metadata.builder().coordinationMetadata(coordinationMetadata).clusterUUID(randomAlphaOfLength(10)).build()
import org.opensearch.cluster.coordination.CoordinationState;
        for (IndexMetadata indexMetadata : expected.metadata()) {
            });
            gateway = newGatewayForRemoteState(
        remotePersistedState.setLastAcceptedState(clusterState);
            Sets.newHashSet(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                gateway.setCurrentTerm(currentTerm);
                ),
            return;
                instanceOf(GatewayMetaState.LucenePersistedState.class)
            PersistedState remotePersistedState = persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE);
                                DefaultRemoteStoreSettings.INSTANCE
        remotePersistedState.setLastAcceptedState(secondClusterState);
            long currentTerm = gateway.getCurrentTerm();
                .lastCommittedConfiguration(coordinationMetadata.getLastAcceptedConfiguration())
                remoteStoreRestoreService,
    private CoordinationState.PersistedState newGatewayPersistedState() throws IOException {
                coordinationMetadata = createCoordinationMetadata(randomNonNegativeLong());
        try {
        CoordinationState.PersistedState gateway = null;
                persistedClusterStateService,
        CoordinationState.PersistedState gateway = null;
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
                    () -> 0L
import org.opensearch.threadpool.ThreadPool;
            Metadata.builder()
            .clusterTerm(1L)
        );
                        clusterService,
            Settings settings = Settings.builder()
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V1;
            randomNonNegativeLong(),
            gatewayMetaStateSpy = Mockito.spy(gateway);
                    gatewayMetaStateSpy,
        remotePersistedState.setLastAcceptedState(clusterState3);
        gateway.start(settings, nodeEnvironment, xContentRegistry(), persistedStateRegistry);
            try (NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings))) {
            when(remoteClusterStateService.getLastKnownUUIDFromRemote(clusterName.value())).thenReturn(ClusterState.UNKNOWN_UUID);
        }
        return usually()
                persistedCoordinationMetadata.getLastCommittedConfiguration(),
        assertTrue(remotePersistedState.getLastAcceptedState().metadata().clusterUUIDCommitted());
                    nodeEnvironment,
                        .version(onDiskState.lastAcceptedVersion)
        return ClusterState.builder(clusterName).nodes(nodesBuilder.build()).version(version).metadata(metadata).build();
        return new MockGatewayMetaState(localNode, bigArrays, prepareFullState);
import org.opensearch.index.recovery.RemoteStoreRestoreService.RemoteRestoreResult;
                randomNonNegativeLong(),
import static org.hamcrest.Matchers.not;
            final RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
    }
            gatewayMetaStateSpy = Mockito.spy(gateway);
        final MetaStateService metaStateService = mock(MetaStateService.class);
            .thenReturn(new RemoteClusterStateManifestInfo(manifest, "path/to/manifest"));
                ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
import org.opensearch.gateway.PersistedClusterStateService.Writer;
import org.opensearch.cluster.coordination.CoordinationMetadata;
            Directory createDirectory(Path path) {
                        Metadata.builder().coordinationMetadata(createCoordinationMetadata(term)).put(indexMetadata, false).build()
import java.io.IOException;
        CoordinationState.PersistedState remotePersistedState = new RemotePersistedState(remoteClusterStateService, previousClusterUUID);
            assertThat(
            assertClusterStateEqual(expectedClusterState, gateway.getLastAcceptedState());
                    xContentRegistry(),
            new RemoteClusterStateManifestInfo(manifest, "path/to/manifest")
                        .build()
                        Metadata.builder().clusterUUID(randomAlphaOfLength(10)).build()
                new PersistedStateRegistry(),
            }
                        false
import org.mockito.ArgumentCaptor;
                Metadata.builder().coordinationMetadata(coordinationMetadata).clusterUUID(randomAlphaOfLength(10)).build()
        );
        Mockito.doThrow(IOException.class).when(remoteClusterStateService).writeFullMetadata(Mockito.any(), Mockito.any());
                persistedClusterStateService,
import static org.hamcrest.Matchers.equalTo;
            xContentRegistry(),
            CoordinationMetadata expectedCoordinationMetadata = CoordinationMetadata.builder(coordinationMetadata)
    private void assertClusterStateEqual(ClusterState expected, ClusterState actual) {
        }
            assertEquals(currentTerm, persistedState.getCurrentTerm());
                    remoteStoreRestoreService,
        CoordinationState.PersistedState gateway = null;
                    .build()
                final IndexMetadata indexMetadata = createIndexMetadata(indexName, randomIntBetween(1, 5), randomNonNegativeLong());
                assertThat(onDiskState.currentTerm, equalTo(42L));
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
                equalTo(GatewayMetaState.AsyncLucenePersistedState.staleStateConfiguration)
            verify(remoteClusterStateService).getLastKnownUUIDFromRemote(clusterName.value()); // change this
            writer.writeFullStateAndCommit(currentState.term(), currentState);
            getBigArrays(),
        );
import static org.hamcrest.Matchers.nullValue;
        builder.lastCommittedConfiguration(
    private MockGatewayMetaState startGatewayForRemoteState(
                        .build()
        MockGatewayMetaState gateway = null;
        settings = Settings.builder().put(ClusterName.CLUSTER_NAME_SETTING.getKey(), clusterName.value()).build();
            true
                .build(),
    private ClusterState createClusterStateWithNodes(long version, Metadata metadata) {
            writer.close();
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build()).build(),
            assertBusy(() -> assertTrue(gateway.allPendingAsyncStatesWritten()));
                new IllegalStateException("unable to download cluster state")
import java.util.concurrent.TimeUnit;
                        ),
import static org.opensearch.gateway.remote.ClusterMetadataManifest.MANIFEST_CURRENT_CODEC_VERSION;
            );
            Collections.emptyMap(),
import static org.mockito.Mockito.doAnswer;
            when(clusterService.getClusterSettings()).thenReturn(new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
            GatewayMetaState.LucenePersistedState persistedState = new GatewayMetaState.LucenePersistedState(
            .put(stateRepoSettingsAttributeKeyPrefix + "location", "randomRepoPath")
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build()).build(),
                    new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenReturn(
    private BigArrays bigArrays;
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build()).build(),
                false
        }
        );
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
    }
            assertThat(gateway.getLastAcceptedState().metadata().index(indexName), equalTo(newIndexMetadata));
            );
        assertEquals(clusterTerm, remotePersistedState.getCurrentTerm());
            }
        assertThat(remotePersistedState.getLastAcceptedState(), equalTo(secondClusterState));
                .put(stateRepoSettingsAttributeKeyPrefix + "location", "randomRepoPath")
                null,
                    () -> 0L
import org.opensearch.indices.DefaultRemoteStoreSettings;
            DiscoveryNode localNode = new DiscoveryNode(
                false
            );
    }
            if (ioExceptionRate.get() == 0.0d) {
            final MockGatewayMetaState gateway = new MockGatewayMetaState(localNode, bigArrays);
                .numberOfShards(5)
        CoordinationMetadata.Builder builder = CoordinationMetadata.builder();
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            final long version = randomNonNegativeLong();
            assertThat(
            .thenReturn(new RemoteClusterStateManifestInfo(manifest, "path/to/manifest"));
import org.opensearch.gateway.remote.RemoteUploadStats;
                false
        try {
        remotePersistedState.markLastAcceptedStateAsCommitted();
            assertThat(gateway.getLastAcceptedState().coordinationMetadata().term(), equalTo(term));
            assertThat(
                        settings,
            PersistedState lucenePersistedState = persistedStateRegistry.getPersistedState(PersistedStateType.LOCAL);
        Mockito.when(remoteClusterStateService.writeIncrementalMetadata(Mockito.any(), Mockito.any(), Mockito.any()))
            assertThrows(
import static org.mockito.Mockito.verify;
        doAnswer((i) -> {
        } finally {
    ) throws IOException {
            verify(gatewayMetaStateSpy, times(2)).restoreClusterState(Mockito.any(), Mockito.any(), Mockito.any());
                .put(Node.NODE_NAME_SETTING.getKey(), "test")
            randomNonNegativeLong(),
import org.opensearch.cluster.node.DiscoveryNodeRole;
        );
            final IndexMetadata indexMetadata = createIndexMetadata(indexName, numberOfShards, version);
            randomRepoName
            gateway.setCurrentTerm(currentTerm);
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenThrow(
        return ClusterState.builder(clusterName).nodes(discoveryNodes).version(version).metadata(metadata).build();
    }
        assertEquals(1, remoteClusterStateService.getUploadStats().getFailedCount());
        assertTrue(Metadata.isGlobalStateEquals(actual.metadata(), expected.metadata()));
                .build();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
            IOUtils.close(gateway);
            final TransportService transportService = mock(TransportService.class);
            );
            try (NodeEnvironment nodeEnvironment = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings))) {
            );
                persistedState.getLastAcceptedState().getLastAcceptedConfiguration(),
import org.opensearch.cluster.service.ClusterService;
                )
            true
                )
        }
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            IOUtils.close(gateway);
    private ClusterName clusterName;
            .stateVersion(5L)
            }
import org.opensearch.test.OpenSearchTestCase;
        nodeEnvironment = newNodeEnvironment();
        final List<Closeable> cleanup = new ArrayList<>(2);
        return gateway;
                final MockDirectoryWrapper wrapper = newMockFSDirectory(path);
            RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
                "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
                persistedStateRegistry,
import static org.mockito.ArgumentMatchers.eq;
                    .put(
import java.util.concurrent.atomic.AtomicReference;
            .opensearchVersion(Version.CURRENT)
        remotePersistedState.setLastAcceptedState(clusterState);
            Locale.getDefault(),
import org.opensearch.env.Environment;
                        writableRegistry(),
                )
                RemoteRestoreResult.build("test-cluster-uuid", null, ClusterState.EMPTY_STATE)
                    currentTerm = newTerm;
        } finally {
    public void testRemotePersistedStateNotCommitted() throws IOException {
                .build();
        );
            );
            final long newTerm = randomLongBetween(term + 1, Long.MAX_VALUE);
    private ClusterState createClusterState(long version, Metadata metadata, boolean isClusterManagerNode) {
                xContentRegistry(),
            ioExceptionRate.set(0.0d);
            .build();
    }
                } else {
 * SPDX-License-Identifier: Apache-2.0
        nodeEnvironment.close();
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build()).build(),
 * KIND, either express or implied.  See the License for the
        try {
                    .coordinationMetadata(CoordinationMetadata.builder().term(randomLong()).build())
 * this file be licensed under the Apache-2.0 license or a
                wrapper.setRandomIOExceptionRate(ioExceptionRate.get());
            persistedState.setLastAcceptedState(state);
            RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
        final long clusterTerm = randomNonNegativeLong();
        );
            .build();
import static org.mockito.Mockito.mock;
        long currentTerm = 42L;
            }
                equalTo(GatewayMetaState.AsyncLucenePersistedState.staleStateConfiguration)
        ) {
        PersistedStateRegistry persistedStateRegistry,
    }
                remoteClusterStateService,
            gateway.setLastAcceptedState(state);
        return gatewayMetaState;
            logger.info("initial metadata: {}", clusterState.toString());
            ClusterService clusterService = mock(ClusterService.class);
        } finally {
                                repositoriesServiceSupplier,
    public void testStatePersistedOnLoad() throws IOException {
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
                final PersistedClusterStateService newPersistedClusterStateService = new PersistedClusterStateService(
import java.io.Closeable;
            for (int i = 0; i < randomIntBetween(1, 5); i++) {
            IOUtils.close(gateway);
        final ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
        );
                        .version(onDiskState.lastAcceptedVersion)
        try {
        if (!ClusterState.EMPTY_STATE.equals(currentState)) {
            .clusterTerm(1L)
        );
            .settings(
                final PersistedClusterStateService.OnDiskState onDiskState = newPersistedClusterStateService.loadBestOnDiskState();
import org.opensearch.repositories.RepositoriesService;
            } catch (IOError | Exception e) {
 * compatible open source license.
            final CoordinationState.PersistedState persistedState = gateway.getPersistedState();
            randomNonNegativeLong(),
            .codecVersion(CODEC_V1)
                Locale.getDefault(),
        try {
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            Metadata.builder()
import org.opensearch.threadpool.TestThreadPool;
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(1L).build()).build(),
import static org.hamcrest.Matchers.instanceOf;
    }
                equalTo(true)
            ClusterState.UNKNOWN_UUID
        }
        ClusterState currentState
            assertThat(
    }
            .stateVersion(5L)
        assertEquals(clusterState, remotePersistedState.getLastAcceptedState());
            assertThat(
                    final Metadata metadata = Metadata.builder()
                .metadata(
 * The OpenSearch Contributors require contributions made to
        try {
        assertEquals(0, remotePersistedState.getCurrentTerm());
        CoordinationState.PersistedState gateway = null;
import org.opensearch.index.remote.RemoteIndexPathUploader;
            verify(remoteClusterStateService).getLastKnownUUIDFromRemote(Mockito.any());
                .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), clusterName.value())
                        .clusterUUIDCommitted(true)
        assertTrue(remotePersistedState.getLastAcceptedManifest().isCommitted());
            }
                    .put(IndexMetadata.SETTING_INDEX_UUID, indexName)
        final ClusterState state = createClusterState(
            .metadata(Metadata.builder(secondClusterState.getMetadata()).clusterUUID(randomAlphaOfLength(10)).build())
        try {
            .committed(false)
            xContentRegistry(),
                .clusterUUIDCommitted(true)
        }).when(remoteClusterStateService).writeMetadataFailed();
            );
                        .build()
            .build();
/*
            gatewayMetaState,
            }
            settingWithRemoteStateEnabled,
            cleanup.add(gateway);
        final RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
        ClusterState currentState,
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            } while (coordinationMetadata.getLastAcceptedConfiguration().equals(coordinationMetadata.getLastCommittedConfiguration()));
            IOUtils.close(gateway);
                randomNonNegativeLong(),
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenThrow(
        );
                );
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
        ClusterState clusterState2 = createClusterState(
                    final IndexMetadata indexMetadata = createIndexMetadata(indexName, randomIntBetween(1, 5), randomNonNegativeLong());
            ClusterState state = createClusterState(
        remotePersistedState.markLastAcceptedStateAsCommitted();
                .coordinationMetadata();
                remoteStoreRestoreService,
        final String previousClusterUUID = "prev-cluster-uuid";
        ArgumentCaptor<ClusterState> clusterStateCaptor = ArgumentCaptor.forClass(ClusterState.class);
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId());
        final String previousClusterUUID = "prev-cluster-uuid";
        PersistedStateRegistry persistedStateRegistry,
            PersistedState remotePersistedState = persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE);
 *
            .thenReturn(new RemoteClusterStateManifestInfo(manifest2, "path/to/manifest"));
        remotePersistedState.setLastAcceptedState(clusterState1);
            assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
        remotePersistedState.setLastAcceptedState(clusterState);
                .lastCommittedConfiguration(coordinationMetadata.getLastAcceptedConfiguration())
    private Settings settings;
            () -> 0L
                    persistedState.setLastAcceptedState(newState);
        return persistedState;
            };
            PersistedState remotePersistedState = persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE);
    public void testMarkAcceptedConfigAsCommitted() throws IOException {
            getBigArrays(),
            IOUtils.close(gateway);
                () -> 0L
                )
        gateway = new MockGatewayMetaState(localNode, bigArrays);
            false
 * this work for additional information regarding copyright
                Locale.getDefault(),
        final TransportService transportService = mock(TransportService.class);
    private static BigArrays getBigArrays() {
                if (isRemoteStoreClusterStateEnabled(settings)) {
        ClusterState clusterState1 = createClusterStateWithNodes(
        remotePersistedState.setLastAcceptedState(secondClusterState);
            ClusterState expectedClusterState = ClusterState.builder(state)
            gateway = initializeGatewayForRemoteState(true);
            );
                } else {
            RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        try {
            .localNodeId(localNode.getId())
            );
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
            verify(gatewayMetaStateSpy, times(5)).restoreClusterState(Mockito.any(), Mockito.any(), Mockito.any());
            .metadata(Metadata.builder(clusterState.getMetadata()).clusterUUID(randomAlphaOfLength(10)).clusterUUIDCommitted(false).build())
    public void testRemotePersistedStateFailureStats() throws IOException {
}
            String stateRepoTypeAttributeKey = String.format(
            RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
            );
                gateway.setLastAcceptedState(state);
            Settings settings = Settings.builder()
                persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE),
                coordinationMetadata = createCoordinationMetadata(randomNonNegativeLong());
            assertThat(
            );
        assertEquals(previousClusterUUID, previousClusterUUIDCaptor.getValue());
        );
            );
                    final ClusterState newState = createClusterState(
                    ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    persistedState.setLastAcceptedState(state);
                    lucenePersistedState.getLastAcceptedState().metadata().index("test-index1").getSettings()
                .build();
            Settings settings = Settings.builder()
import org.opensearch.gateway.remote.model.RemoteClusterStateManifestInfo;
                if (rarely()) {
        assertThat(remotePersistedState.getLastAcceptedState(), equalTo(clusterState));
            nodeEnvironment,
    public void testGatewayForRemoteStateForInitialBootstrapBlocksApplied() throws IOException {
        return persistedState;
        }
import org.opensearch.cluster.coordination.CoordinationState.PersistedState;
                remoteStoreRestoreService,
        final ClusterState secondClusterState = createClusterState(
            gateway = maybeNew(gateway);
            ).nodes(DiscoveryNodes.EMPTY_NODES).build();
                    state,
        assertEquals(0, remoteClusterStateService.getUploadStats().getSuccessCount());
            .build();
                .settings(settings(Version.CURRENT).put(SETTING_INDEX_UUID, randomAlphaOfLength(10)))
            final RemoteStoreRestoreService remoteStoreRestoreService = mock(RemoteStoreRestoreService.class);
            () -> 0L
        final ClusterState clusterState = createClusterState(
        assertThat(persistedStateRegistry.getPersistedState(PersistedStateType.REMOTE), nullValue());
            .clusterTerm(1L)
            assertThat(state.getClusterName(), equalTo(clusterName));
            assertThat(state.getNodes().getLocalNode(), equalTo(localNode));
                remoteClusterStateService,
            // generate a series of updates and check if batching works
        final CoordinationState.PersistedState persistedState = gateway.getPersistedState();
                .coordinationMetadata(CoordinationMetadata.builder().term(clusterTerm).build())
        }
 * You may obtain a copy of the License at
        MockGatewayMetaState gateway = null;
        // verify that the freshest state was rewritten to each data path
        remotePersistedState.setLastAcceptedState(thirdClusterState);
                );
        Mockito.when(remoteClusterStateService.writeFullMetadata(Mockito.any(), Mockito.any()))
            true
                    GatewayMetaState.AsyncLucenePersistedState.resetVotingConfiguration(state),
                    new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            final RemoteClusterStateService remoteClusterStateService = mock(RemoteClusterStateService.class);
        String randomRepoName = "randomRepoName";
        assertThat(remotePersistedState.getLastAcceptedState(), nullValue());
                    currentTerm = currentTerm + (rarely() ? randomIntBetween(1, 5) : 0L);
import org.opensearch.env.NodeEnvironment;
                persistedCoordinationMetadata.getLastAcceptedConfiguration(),
        assertTrue(remotePersistedState.getLastAcceptedManifest().isCommitted());
                    settings(Version.CURRENT).put(SETTING_INDEX_UUID, randomAlphaOfLength(10))
                        .build();
    }
            assertClusterStateEqual(expectedClusterState, persistedState.getLastAcceptedState());
                clusterService,
            ClusterState state = createClusterState(
            persistedClusterStateService,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
    private MockGatewayMetaState newGatewayForRemoteState(
            .thenReturn(new RemoteClusterStateManifestInfo(manifest2, "path/to/manifest3"));
            randomNonNegativeLong(),
        Mockito.verify(remoteClusterStateService).writeFullMetadata(clusterState1, previousClusterUUID);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
        Mockito.verify(remoteClusterStateService).writeFullMetadata(clusterState, previousClusterUUID);
    }
                .build();
                ClusterState.EMPTY_STATE
                }
            Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(1L).build()).build()
                    persistedState.setCurrentTerm(currentTerm);
        final ClusterState thirdClusterState = ClusterState.builder(secondClusterState)
                    final String indexName = randomAlphaOfLength(10);
 */
                        .coordinationMetadata(expectedCoordinationMetadata)
                .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        DiscoveryNode oldNode = new DiscoveryNode(
                RemoteRestoreResult.build("test-cluster-uuid", null, previousState)
            gateway.setLastAcceptedState(
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
/*
                    final int numberOfShards = randomIntBetween(1, 5);
        assertEquals(clusterTerm, remotePersistedState.getCurrentTerm());
            assertClusterStateEqual(expectedClusterState, gateway.getLastAcceptedState());
        remotePersistedState.setLastAcceptedState(thirdClusterState);
                Metadata.builder()
                    // bump term
            persistedState.close();
            gateway = newGatewayForRemoteState(
 */
            .thenReturn(Optional.of(manifest));
                gateway.getLastAcceptedState().getLastAcceptedConfiguration(),
        final ClusterState clusterState = createClusterState(
                    .persistentSettings(Settings.builder().put(randomAlphaOfLength(10), randomAlphaOfLength(10)).build())
/*
    public void testSetLastAcceptedStateTermChanged() throws IOException {
                remoteClusterStateService,
                assertThat(gateway.getCurrentTerm(), equalTo(currentTerm));
        final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
                .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
            "node2",
            gateway.markLastAcceptedStateAsCommitted();
                        .put(indexMetadata, false)
            return null;
    }
                        repositoriesServiceSupplier,
 */
    }
            gateway = newGatewayPersistedState();
            when(remoteClusterStateService.getLastKnownUUIDFromRemote("test-cluster")).thenReturn("test-cluster-uuid");
                buildNewFakeTransportAddress(),
        Mockito.when(remoteClusterStateService.writeIncrementalMetadata(Mockito.any(), Mockito.any(), Mockito.any()))
                    );
            );
import org.opensearch.cluster.ClusterState;
                    .put(indexMetadata, false)
                remoteClusterStateServiceSupplier.get(),
            randomNonNegativeLong(),
                .build();
            IOUtils.close(gateway);
                wrapper.setRandomIOExceptionRate(ioExceptionRate.get());
            .build();
                        () -> 0L
            buildNewFakeTransportAddress(),
                        threadPool,
            gateway = newGatewayPersistedState();
            final ClusterState clusterState = createClusterState(
            when(remoteStoreRestoreService.restore(any(), any(), anyBoolean(), any())).thenReturn(
            .thenReturn(new RemoteClusterStateManifestInfo(manifest, "path/to/manifest2"));
        ClusterState clusterState3 = createClusterState(
import org.opensearch.cluster.coordination.PersistedStateRegistry;
        final PersistedClusterStateService persistedClusterStateService = new PersistedClusterStateService(
            when(transportService.getThreadPool()).thenReturn(threadPool);
 * under the License.
            persistedState.setCurrentTerm(state.term());
            nodesBuilder.clusterManagerNodeId(localNode.getId());
        } finally {
                    final IndexMetadata indexMetadata = createIndexMetadata(indexName, numberOfShards, i);
        final ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder()
