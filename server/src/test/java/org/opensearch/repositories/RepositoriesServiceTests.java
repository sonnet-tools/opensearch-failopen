        @Override
        return state.build();
        repositoriesService = createRepositoriesServiceAndMockCryptoClusterState(
            verified,
 * SPDX-License-Identifier: Apache-2.0
            repoName,
import java.util.function.Consumer;
        public RepositoryStats stats() {
            appender.assertAllExpectationsMatched();
        ClusterService clusterService = mock(ClusterService.class);
        expectThrows(IllegalArgumentException.class, () -> repositoriesService.registerOrUpdateRepository(request, null));
        CryptoSettings cryptoSettings = new CryptoSettings(keyProviderName);
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeB, emptyState()));
public class RepositoriesServiceTests extends OpenSearchTestCase {
        RepositoriesService repositoriesService = createRepositoriesServiceWithMockedClusterService(clusterService);
        Repository repository = new TestRepository(new RepositoryMetadata(repoName, TestRepository.TYPE, Settings.EMPTY)) {
        // No change
            RepositoryShardId shardId,
        @Override
                throw new RuntimeException("reload failed");
            @Override
            appender.assertAllExpectationsMatched();
        public void cloneShardSnapshot(
            verified,
                    RepositoriesService.class.getCanonicalName(),
            CryptoMetadata cryptoMetadata = repositoryMetadata.cryptoMetadata();
            return mock(BlobStore.class);
            clusterService,
            return 0;
        public void getRepositoryData(ActionListener<RepositoryData> listener) {
            verified,
        public void close() throws IOException {
            threadPool
                    "reloaded repository [" + ReloadableTestRepository.TYPE + "][" + repoName + "] in [*]"
    ) {
        @Override
            keyProviderName,
                )
            TestRepository.TYPE,
        private final RepositoryMetadata metadata;
            IndexCommit snapshotIndexCommit,
            Map<String, Long> indexFilesToFileLengthMap,
            return null;
    }
        public long adjustContentSizeForPartialEncryption(Object cryptoContextObj, long contentSize) {
import org.opensearch.core.index.shard.ShardId;
        state.metadata(mdBuilder);
            );
                )
    ) {
            MeteredRepositoryTypeB.TYPE,
        @Override
    }
            repositoryMetadata
            clusterService,
            String shardStateIdentifier,
            kpTypeA
        @Override
        }
        @Override
import org.opensearch.cluster.metadata.RepositoriesMetadata;
 *    http://www.apache.org/licenses/LICENSE-2.0
            ShardGenerations shardGenerations,
        public void removeLifecycleListener(LifecycleListener listener) {
        settings = Settings.builder();
                () -> repositoriesService.createRepository(
        assertTrue(((TestRepository) repository).isStarted);
 * Licensed to Elasticsearch under one or more contributor
        }
        String repoName = "name";
    public void testUpdateOrRegisterRejectsForSystemRepository() {
            ActionListener<String> listener
import org.opensearch.cluster.metadata.Metadata;
        ClusterState clusterStateWithRepoTypeA = state.build();
        assertThat(repositoryStatsTypeA.getRepositoryInfo().type, equalTo(MeteredRepositoryTypeB.TYPE));
            SnapshotId snapshotId,
import org.opensearch.core.action.ActionListener;
            );
        return repositoriesService;
import java.util.function.Function;
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeB, emptyState()));
        String repoName = "name";
        }
    public void testRepositoryUpdateWithDifferentCryptoMetadata() {
            keyProviderType,
 * compatible open source license.
            Version repositoryMetaVersion,
                    Level.INFO,
        @Override
        request.type(MeteredRepositoryTypeA.TYPE);
    public void testReloadRepositoryLogsTimeTakenOnFailure() throws Exception {
        public void reload(RepositoryMetadata repositoryMetadata) {
            expectThrows(
        RepositoryMetadata newRepositoryMetadata = new RepositoryMetadata(
        assertTrue(verified.get());
        expectThrows(RepositoryException.class, () -> repositoriesService.registerOrUpdateRepository(request, null));
        Repository repository = repositoriesService.repository(repoName);
        }
            return 0;
            return null;
    }
        Metadata.Builder mdBuilder = Metadata.builder();
            return 0;
        public RepositoryMetadata getMetadata() {
            return false;
        }
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
import org.opensearch.common.blobstore.BlobPath;
        }
                )
            keyProviderType,
        }
            verified.set(true);
            SnapshotId snapshotId,
    public void testUnregisterRepositoryLogsTimeTaken() throws Exception {
        repositoryRequest.type(repoType);
        // Different crypto client in new repo
            settings.build(),
        ClusterState updatedClusterState = createClusterStateWithRepo(
        Repository repository2 = repositoriesService.repository(repoName);
            return null;
            task.onFailure("delete_repository [" + repoName + "]", new RepositoryMissingException(repoName));
            AckedClusterStateUpdateTask<ClusterStateUpdateResponse> task = (AckedClusterStateUpdateTask<
                    "repository creation timing",
        public long estimateDecryptedLength(Object cryptoContext, long contentLength) {
import java.util.Map;
            keyProviderName,
        assertNotNull(repository.cryptoHandler);
        for (char c : Strings.INVALID_FILENAME_CHARS) {
                    RepositoriesService.class.getCanonicalName(),
import java.util.Collection;
            ReloadableTestRepository.TYPE,
                    "repository creation timing",
            Map<String, Object> userMetadata,
    }
        public InputStream createDecryptingStream(InputStream encryptingStream) {
import static org.hamcrest.Matchers.equalTo;
        repository = (MeteredRepositoryTypeA) repositoriesService.repository(repoName);
        public void start() {
        String keyProviderName = "kp-name";
    private static class MeteredRepositoryTypeA extends MeteredBlobStoreRepository {
        @Override
                    "delete repository [" + repoName + "] took [*]"
            SnapshotId source,
            );
    // RepositoriesService no longer participates in native store init.
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepo, emptyState()));
        }
        ) {}
        @Override
        }
        public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
        public BlobPath basePath() {
        CryptoMetadata cryptoMetadata = new CryptoMetadata(keyProviderName, keyProviderType, Settings.EMPTY);
                    new RepositoryMetadata(repoName, FailingOnStartTestRepository.TYPE, Settings.EMPTY)
                cryptoHandler = new TestCryptoProvider(
    private RepositoriesService repositoriesService;
        }
        @Override
                );
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
        MeteredRepositoryTypeA repository = (MeteredRepositoryTypeA) repositoriesService.repository("repoName");
        PutRepositoryRequest repositoryRequest = new PutRepositoryRequest(repoName);
        verified.set(false);
            SnapshotId target,
            assertThrowsOnRegister("contains" + c + "InvalidCharacters");
            Object cryptoContextObj,
import java.util.concurrent.atomic.AtomicReference;
        }
            Metadata clusterMetadata,
        final Repository repo = repositoriesService.repository("repo");
        }
            "repoName",
        cryptoSettings.settings(Settings.builder());
            long repositoryStateId,
            keyProviderName,
            return null;
        assertNotNull(repository.cryptoHandler);
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
import org.opensearch.Version;
        PutRepositoryRequest request = new PutRepositoryRequest(repoName);
        private static final RepositoryStats STATS = new RepositoryStats(Map.of("LIST", 20L));
 * under the License.
            appender.assertAllExpectationsMatched();
            public void close() {
    @Override
    }
            SnapshotId source,
        private boolean isClosed;
            IndexShardSnapshotStatus snapshotStatus,
    public void testRegisterRejectsInvalidRepositoryNames() {
                    "repository close timing",
        assertNotNull(repository.cryptoHandler);
            clusterService,
            InputStreamContainer stream,
        ) {
        repositoriesService.registerOrUpdateRepository(request, null);
        public boolean isReadOnly() {
        request.type("unknown-type");
        );
    }
        assertNotNull(repository);
        String repoType,
        ClusterState clusterStateWithRepoTypeB = createClusterStateWithRepo(repoName, MeteredRepositoryTypeB.TYPE);
            Collection<SnapshotId> snapshotIds,
        );
    private static class TestRepository implements Repository {
        ) {
                    "repository reload timing",
        private static final String TYPE = "native-aware";
        );
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", emptyState(), clusterStateWithRepoTypeA));
            );
            keyProviderName,
        assertNotNull(repository.cryptoHandler);
                    new ClusterChangedEvent("update repo", updatedClusterState, clusterStateWithRepo)
            Settings.builder().put("updated", true).build()
        }
                () -> repositoriesService.applyClusterState(
    }
        public void endVerification(String verificationToken) {
        public void verify(String verificationToken, DiscoveryNode localNode) {
        repositoriesService.registerOrUpdateRepository(request, null);
        public void stop() {
        }
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
            return null;
        ClusterState clusterStateWithRepoTypeB = createClusterStateWithKeyProvider(
            );
        @Override
    private static class FailingOnStartTestRepository extends TestRepository {
            this.kpType = kpType;
            new RepositoriesMetadata(Collections.singletonList(new RepositoryMetadata(repoName, repoType, Settings.EMPTY, cryptoMetadata)))
        assertEquals(repoName, repository.getMetadata().name());
        RepositoriesService repositoriesService = createRepositoriesServiceAndMockCryptoClusterState(
        assertSame(NativeStoreRepository.EMPTY, repo.getNativeStore());
            ActionListener<String> listener
                new MockLogAppender.SeenEventExpectation(
            Object cryptoContext,
            } else {
        ClusterState clusterStateWithRepo = createClusterStateWithRepo(repoName, TestRepository.TYPE);
        }
                cryptoHandler = null;
        String keyProviderName = "kp-name-1";
        }
import java.io.IOException;
        Settings.Builder settings = Settings.builder();
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
 * this work for additional information regarding copyright
        MeteredRepositoryTypeA repository = (MeteredRepositoryTypeA) repositoriesService.repository("repoName");
        Repository repository = repositoriesService.repository(repoName);
        String repoName = "name";
        ThreadPool threadPool = mock(ThreadPool.class);
        repositoryRequest.settings(Settings.EMPTY);
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepo, emptyState()));
import org.opensearch.cluster.metadata.RepositoryMetadata;
        @Override
import org.opensearch.common.crypto.CryptoHandler;
        public Object loadEncryptionMetadata(EncryptedHeaderContentSupplier encryptedHeaderContentSupplier) throws IOException {
        @Override
        return ClusterState.builder(new ClusterName("test")).build();
        public void snapshotRemoteStoreIndexShard(
        String repoName = "name";
            new RepositoriesMetadata(Collections.singletonList(new RepositoryMetadata(repoName, repoType, settings)))
            Settings.builder().put("updated", true).build()
            RecoveryState recoveryState,
        @Override
    public void testCloseRepositoryLogsTimeTaken() throws Exception {
            assertEquals("close failed", e.getMessage());
        assertNotNull(repository);
import static org.mockito.Mockito.when;
        assertNotNull(repository.cryptoHandler);
        ClusterState clusterStateWithRepo = createClusterStateWithRepo(repoName, ReloadableTestRepository.TYPE);
        ) {
        ) {
import org.opensearch.snapshots.SnapshotId;
            );
        @Override
            keyProviderName,
    }
        String repoName = "name";
        String repoName = "name";
        MeteredRepositoryTypeB repositoryB = (MeteredRepositoryTypeB) repositoriesService.repository("repoName");
            boundAddress -> DiscoveryNode.createLocal(Settings.EMPTY, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
        assertNotNull(repository.cryptoHandler);
        assertNotNull(repository);
            ActionListener<String> listener
                    Level.INFO,
    }
                    "delete repository timing",
    }
                    "closed repository [" + TestRepository.TYPE + "][" + repoName + "] in [*]"
            Store store,
        @Override
import org.opensearch.threadpool.ThreadPool;
 * GitHub history for details.
            long endPosOfRawContent
        repositoriesService.start();
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        String keyProviderType
            );
 * KIND, either express or implied.  See the License for the
    // -----------------------------------------------------------------------
            return true;
        repositoriesService.registerOrUpdateRepository(request, null);
        private ReloadableTestRepository(RepositoryMetadata metadata) {
        cryptoSettings.keyProviderName(keyProviderName);
                    metadata.cryptoMetadata().keyProviderType()
import static org.mockito.Mockito.doAnswer;
import org.opensearch.common.crypto.MasterKeyProvider;
            AckedClusterStateUpdateTask<ClusterStateUpdateResponse> task = (AckedClusterStateUpdateTask<
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
            repoName,
        RepositoriesService repositoriesService = createRepositoriesServiceWithMockedClusterService(clusterService);
            Function<ClusterState, ClusterState> stateTransformer,
            IndexShardSnapshotStatus snapshotStatus,
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
            return 0;
        ) {
        String keyProviderType = kpTypeA;
        super.setUp();
        AtomicReference<Exception> failure = new AtomicReference<>();
        @Override
 * not use this file except in compliance with the License.
import org.opensearch.transport.TransportService;
                    "created repository [" + TestRepository.TYPE + "][" + repoName + "] in [*]"
            String keyProviderType,
                    Level.INFO,
        public void executeConsistentStateUpdate(
    private static class MeteredRepositoryTypeB extends MeteredBlobStoreRepository {
        public InputStreamContainer createEncryptingStream(Object encryptionMetadata, InputStreamContainer streamContainer) {
            kpTypeA
        assertEquals(Settings.EMPTY, repository.getMetadata().settings());
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
        RepositoriesService repositoriesService = new RepositoriesService(
    private static class TestCryptoProvider implements CryptoHandler<Object, Object> {
        ActionListener<ClusterStateUpdateResponse> listener = ActionListener.wrap(response -> fail("expected failure"), failure::set);
        @Override
            return STATS;
        }
        public void updateState(final ClusterState state) {}
        private final Settings settings;
        }
        when(clusterService.state()).thenReturn(currentClusterState);
                    RepositoriesService.class.getCanonicalName(),
    }
    }
            assertNotNull(cryptoMetadata);
    public void testUnregisterInternalRepository() {
        String repoName = "name";
        }
import org.opensearch.cluster.metadata.IndexMetadata;
    }
            TestRepository::new,
            this.metadata = metadata;
        repositoriesService.unregisterInternalRepository(repoName);
 * this file be licensed under the Apache-2.0 license or a
        String repoName = "name";
            NoopTracer.INSTANCE
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
                new MockLogAppender.SeenEventExpectation(
                    RepositoriesService.class.getCanonicalName(),
        public void cloneRemoteStoreIndexShardSnapshot(
            IndexMetadata indexMetadata
        public RemoteStoreShardShallowCopySnapshot getRemoteStoreShallowCopyShardMetadata(
                ClusterStateUpdateResponse>) invocation.getArguments()[1];
import org.apache.logging.log4j.LogManager;
    private PutRepositoryRequest createPutRepositoryEncryptedRequest(
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
            return 0;
            return BlobPath.cleanPath();
import org.opensearch.cluster.ClusterStateUpdateTask;
            repoName,
            return new TestCryptoProvider(keyProviderName, keyProviderType);
            MeteredRepositoryTypeA.TYPE,
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        );
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));
        request.settings(Settings.EMPTY);
        assertTrue(verified.get());
            Version repositoryMetaVersion,
        @Override
                new MockLogAppender.SeenEventExpectation(
        request.cryptoSettings(cryptoSettings);
        settings = Settings.builder();
 * You may obtain a copy of the License at
            SnapshotInfo snapshotInfo,
        return createClusterStateWithRepo(repoName, repoType, Settings.EMPTY);
        verified.set(false);
            keyProviderType,
            AckedClusterStateUpdateTask<ClusterStateUpdateResponse> task = (AckedClusterStateUpdateTask<
        ) {
        }
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        doAnswer((invocation) -> {
        @Override
        private static final String TYPE = "reloadable";
import org.opensearch.cluster.node.DiscoveryNode;
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));
        private final TestCryptoProvider cryptoHandler;
        private static final String TYPE = "type-a";
            return null;
import org.opensearch.test.MockLogAppender;
        return repositoryRequest;
            listener.onResponse(null);
            return new Object();
        ClusterService clusterService = mock(ClusterService.class);
            MeteredRepositoryTypeA.TYPE,
        repositoriesService.registerInternalRepository("repo", TestRepository.TYPE);
            metadata -> new MeteredRepositoryTypeA(metadata, clusterService),
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
        }
            super(metadata, mock(NamedXContentRegistry.class), clusterService, mock(RecoverySettings.class), Map.of("bucket", "bucket-b"));
        mdBuilder.putCustom(RepositoriesMetadata.TYPE, newRepositoriesMetadata);
        expectThrows(RepositoryMissingException.class, () -> repositoriesService.repository(repoName));
            newCryptoMetadata
        public long getRemoteUploadThrottleTimeInNanos() {
            kpTypeA
    public void testRepositoriesStatsCanHaveTheSameNameAndDifferentTypeOverTime() {
        String keyProviderName,
import org.opensearch.index.snapshots.blobstore.RemoteStoreShardShallowCopySnapshot;
    }
        @Override
            Settings.EMPTY,
            Settings.EMPTY,
                    "put repository timing",
        String repoName = "name";
                )
 * The OpenSearch Contributors require contributions made to
            appender.assertAllExpectationsMatched();
            appender.addExpectation(
                    Level.INFO,
        String repoName = "name";
                new MockLogAppender.SeenEventExpectation(
        mdBuilder.putCustom(
        assertNotNull(repository.cryptoHandler);
            RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
        }
            transportService,
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
        );
import org.opensearch.common.lifecycle.Lifecycle;
        }
                new MockLogAppender.SeenEventExpectation(
            long startPosOfRawContent,
            repoName,
        }
    private RepositoriesService createRepositoriesServiceAndMockCryptoClusterState(
        Repository repository = repositoriesService.repository(repoName);
        repositoriesService = createRepositoriesServiceWithMockedClusterService(clusterService);
            Settings.EMPTY,
            repoName,
    private ClusterState emptyState() {
            return null;
        String repoName,
import org.opensearch.snapshots.SnapshotInfo;
        doAnswer((invocation) -> {
            RepositoriesMetadata repositories = clusterState.metadata().custom(RepositoriesMetadata.TYPE);
        }
    }
import org.opensearch.index.store.Store;
        @Override
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
        }
            appender.addExpectation(
    public void testCreateRepositoryLogsTimeTaken() throws Exception {
        @Override
            MasterKeyProvider keyProvider,
        }
        cryptoSettings.keyProviderType(keyProviderType);
import org.opensearch.cluster.ClusterName;
import org.opensearch.cluster.ClusterChangedEvent;
            appender.assertAllExpectationsMatched();
        ) {
import org.opensearch.cluster.service.ClusterService;
        @Override
            int streamIdx
            ShardId snapshotShardId,
    public void testCloseRepositoryLogsTimeTakenOnFailure() throws Exception {
import org.opensearch.cluster.node.DiscoveryNodes;
        repositoriesService = createRepositoriesServiceAndMockCryptoClusterState(
    }
                ClusterStateUpdateResponse>) invocation.getArguments()[1];
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
        }
        repositoriesService.registerInternalRepository(repoName, TestRepository.TYPE);
        cryptoSettings.settings(Settings.builder().put("key-1", "val-1"));
    private static abstract class TestCryptoHandler implements CryptoPlugin<Object, Object> {
        public TestCryptoProvider(String kpName, String kpType) {
        Map<String, Repository.Factory> typesRegistry = Map.of(
    private static class ReloadableTestRepository extends TestRepository {
        CryptoMetadata newCryptoMetadata = new CryptoMetadata(keyProviderName, keyProviderType, Settings.EMPTY);
        return repositoriesService;
        ClusterState clusterStateWithRepo = createClusterStateWithRepo(repoName, ReloadableTestRepository.TYPE);
        List<RepositoryStatsSnapshot> repositoriesStats = repositoriesService.repositoriesStats();
        );
        assertTrue(failure.get() instanceof RepositoryMissingException);
        @Override
        when(currentClusterState.getNodes()).thenReturn(nodes);
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;
        when(clusterService.getClusterApplierService()).thenReturn(clusterApplierService);
                    "repository close timing",
                RepositoryException.class,
        }).when(clusterService).submitStateUpdateTask(any(), any());
        repositoryRequest.cryptoSettings(cryptoSettings);
        repositoriesService.registerInternalRepository(repoName, TestRepository.TYPE);
                AssertionError.class,
            IndexId indexId,
                new MockLogAppender.SeenEventExpectation(
            listener.onResponse(null);
        NativeAwareTestRepository(RepositoryMetadata metadata) {
        ) {
        String repoName = "repoName";
            Function<RepositoryData, ClusterStateUpdateTask> createUpdateTask,
 * the Apache License, Version 2.0 (the "License"); you may
                    RepositoriesService.class.getCanonicalName(),
        );
        assertFalse(((TestRepository) repository).isClosed);
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));
        public long getLowPriorityRemoteDownloadThrottleTimeInNanos() {
        request = createPutRepositoryEncryptedRequest(repoName, MeteredRepositoryTypeA.TYPE, keyProviderName, settings, keyProviderType);
            throw new RuntimeException("start failed");
        when(clusterService.getSettings()).thenReturn(Settings.EMPTY);
                new MockLogAppender.SeenEventExpectation(
            // applyClusterState swallows the reload failure but trips an assert in tests
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));
        public long getSnapshotThrottleTimeInNanos() {
        assertTrue(verified.get());
            this.settings = settings;
        private static final String TYPE = "internal";
        ThreadPool threadPool = mock(ThreadPool.class);
    }
                    "put/update repository [" + repoName + "] took [*]"
        }
                )
            Collections.emptySet(),
        PutRepositoryRequest request = new PutRepositoryRequest(repoName);
    ) {
import org.opensearch.test.OpenSearchTestCase;
            IndexId indexId,
        }
            return null;
        ClusterState currentClusterState = mock(ClusterState.class);
            return null;
import org.apache.lucene.index.IndexCommit;
package org.opensearch.repositories;
import org.opensearch.indices.recovery.RecoveryState;
            keyProviderName,
        }
        String keyProviderName,
            String shardGeneration,
            expectThrows(
        String keyProviderName = "kp-name";
                ClusterStateUpdateResponse>) invocation.getArguments()[1];
            long commitGeneration,
import org.apache.logging.log4j.Level;
        List<RepositoryMetadata> repositoryMetadataList
            String shardGeneration,
                cryptoHandler = null;
            return mock(BlobStore.class);
        @Override
        }
        public void addLifecycleListener(LifecycleListener listener) {
        }
        MeteredRepositoryTypeA repository = (MeteredRepositoryTypeA) repositoriesService.repository("repoName");
        public void restoreShard(
        @Override
        @Override
        }
                throw new RuntimeException("close failed");
            Store store,
            super(metadata);
                new MockLogAppender.SeenEventExpectation(
        public void snapshotShard(
        verified.set(false);
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
            repositoriesService.applyClusterState(new ClusterChangedEvent("update repo", updatedClusterState, clusterStateWithRepo));
        assertNotNull(repositoryB);
        );
        }
        }
            IndexId indexId,
            ActionListener<RepositoryData> listener
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));
            verified,
        public IndexMetadata getSnapshotIndexMetaData(RepositoryData repositoryData, SnapshotId snapshotId, IndexId index) {
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
        AtomicBoolean verified,
                )
    private final String kpTypeA = "kp-type-a";
            settings.build(),
                    metadata.cryptoMetadata().keyProviderName(),
            String source,
    }
            settings.build(),
import java.util.concurrent.atomic.AtomicBoolean;
            repositoryMetadata
        repoName = "repoName-3";
        public Lifecycle.State lifecycleState() {
        }
        mdBuilder.putCustom(
            Version repositoryMetaVersion,
/*
            if (metadata.cryptoMetadata() != null) {
                    metadata.cryptoMetadata().keyProviderName(),
    // ExtensiblePlugin.loadExtensions in each repository plugin.
 * Modifications Copyright OpenSearch Contributors. See
        @Override
import org.opensearch.common.settings.ClusterSettings;
        private static final String TYPE = "failing-on-start";
    }
        request = createPutRepositoryEncryptedRequest(repoName, MeteredRepositoryTypeA.TYPE, keyProviderName, settings, keyProviderType);
    private final String kpTypeB = "kp-type-b";
        }
    }
        assertNotNull(repository);
import org.opensearch.common.crypto.DecryptedRangedStreamProvider;
        assertThat(repositoryStatsTypeA.getRepositoryStats(), equalTo(MeteredRepositoryTypeB.STATS));
            }
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepo, emptyState()));
        @Override
        keyProviderType = kpTypeA;
            repositoryMetadata
        String keyProviderName = "kp-name";
import org.opensearch.cluster.ClusterState;
            repositoriesService.registerOrUpdateRepository(request, listener);
                    metadata.cryptoMetadata().keyProviderType()
 * ownership. Elasticsearch licenses this file to you under
            String shardStateIdentifier,
        public boolean isReloadableSettings(RepositoryMetadata newRepositoryMetadata) {
            long repositoryStateId,
            Priority repositoryUpdatePriority,
            isClosed = true;
            appender.addExpectation(
                    RepositoriesService.class.getCanonicalName(),
            );
        return state.build();
    }
            return STATS;
        final TransportService transportService = new TransportService(
            clusterService,
        keyProviderType = kpTypeB;
        PutRepositoryRequest request = createPutRepositoryEncryptedRequest(
            IndexCommit snapshotIndexCommit,
        repositoriesService.registerInternalRepository(repoName, TestRepository.TYPE);
                )
        );
            repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepo, emptyState()));
            keyProviderName,
        expectThrows(RepositoryException.class, () -> repositoriesService.registerOrUpdateRepository(request, null));
            typesRegistry,
        public DecryptedRangedStreamProvider createDecryptingStreamOfRange(
                    "created repository [" + FailingOnStartTestRepository.TYPE + "][" + repoName + "] in [*]"
        private static final RepositoryStats STATS = new RepositoryStats(Map.of("GET", 10L));
import org.opensearch.common.UUIDs;
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
        public SnapshotInfo getSnapshotInfo(SnapshotId snapshotId) {
import org.opensearch.cluster.metadata.CryptoMetadata;
    public void testGetNativeStoreDefaultIsEmpty() {
        RepositoriesMetadata newRepositoriesMetadata = new RepositoriesMetadata(repositoryMetadataList);
 *
        public long getRestoreThrottleTimeInNanos() {
        }
        public long estimateEncryptedLengthOfEntireContent(Object cryptoContextObj, long contentLength) {
import static org.mockito.ArgumentMatchers.any;
        doAnswer(invocation -> {
        @Override
            repositoriesService.unregisterRepository(new DeleteRepositoryRequest(repoName), listener);
        ((ReloadableTestRepository) repositoriesService.repository(repoName)).failOnReload = true;
            appender.addExpectation(
        private boolean failOnReload;
        public boolean isSystemRepository() {
            return BlobPath.cleanPath();
        RepositoriesService repositoriesService = createRepositoriesServiceWithMockedClusterService(clusterService);
        repositoriesService = createRepositoriesServiceAndMockCryptoClusterState(
        ClusterState clusterStateWithRepo = createClusterStateWithRepo(repoName, TestRepository.TYPE);
            MeteredRepositoryTypeB.TYPE,
}
        }
import org.opensearch.common.crypto.EncryptedHeaderContentSupplier;
        expectThrows(IllegalArgumentException.class, () -> repositoriesService.registerOrUpdateRepository(request, null));
import org.opensearch.cluster.service.ClusterApplierService;
        AtomicBoolean verified = new AtomicBoolean();
        CryptoSettings cryptoSettings = new CryptoSettings(keyProviderName);
        // Same crypto client in new repo
        }
    private RepositoriesService createRepositoriesServiceWithMockedClusterService(ClusterService clusterService) {
        }
            FailingOnStartTestRepository.TYPE,
        private FailingOnStartTestRepository(RepositoryMetadata metadata) {
        }
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
        @Override
            FailingOnStartTestRepository::new,
        String repoType,
            String keyProviderName,
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(0));
        @Override
        }
            this.kpName = kpName;
            return 0;
        protected BlobStore createBlobStore() {
    public void testWithSameKeyProviderNames() {
        }
        Settings.Builder settings,
        private static final String TYPE = "type-b";
        @Override
 */
            MeteredRepositoryTypeA.TYPE,
        );
            );
    }
        }
        @Override
            }
            settings.build(),
        repository = (MeteredRepositoryTypeA) repositoriesService.repository(repoName);
            repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));
        }
/*
            appender.addExpectation(
        final String kpName;
    }
 * Unless required by applicable law or agreed to in writing,
            return metadata;
                    "reloaded repository [" + ReloadableTestRepository.TYPE + "][" + repoName + "] in [*]"
            repositoryMetadata
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));
        ClusterState clusterStateWithRepoTypeA = createClusterStateWithKeyProvider(
        when(nodes.getMinNodeVersion()).thenReturn(Version.V_2_9_0);
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
        }
                cryptoHandler = new TestCryptoProvider(
            typesRegistry,
            assertEquals(keyProviderType, cryptoMetadata.keyProviderType());
            assertEquals(cryptoMetadata.settings(), settings);
import org.opensearch.common.lifecycle.LifecycleListener;
        cryptoSettings.settings(settings);
            isStarted = true;
        settings = Settings.builder();
            MapperService mapperService,
    }
            kpTypeA
            repoName,
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
        public InputStreamContainer createEncryptingStreamOfPart(
import org.opensearch.cluster.AckedClusterStateUpdateTask;
        }
        List<RepositoryMetadata> repositoryMetadata = new ArrayList<>();
        ClusterState clusterStateWithRepoTypeA = createClusterStateWithRepo(repoName, MeteredRepositoryTypeA.TYPE);
                    RepositoriesService.class.getCanonicalName(),
        public void close() {
        AtomicReference<Exception> failure = new AtomicReference<>();
        expectThrows(RepositoryMissingException.class, () -> repositoriesService.repository(repoName));
        assertNotNull(repository.cryptoHandler);
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
    }
            if (metadata.cryptoMetadata() != null) {
        assertFalse(((TestRepository) repository).isClosed);
            null,
        keyProviderType = kpTypeA;
            return 0;
            Store store,
                    Level.INFO,
import java.util.Collections;
            Metadata clusterMetadata,
        assertThrowsOnRegister("contains#InvalidCharacter");
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            Runnable onClose
        @Override
            appender.assertAllExpectationsMatched();
            RepositoriesMetadata.TYPE,
        );
        @Override
            } else {
            MeteredRepositoryTypeA.TYPE,
            RepositoryMetadata repositoryMetadata = repositories.repositories().get(repositoryMetadataList.size() - 1);
        if (!repositoryMetadataList.contains(newRepositoryMetadata)) {
            SnapshotInfo snapshotInfo,
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
import static org.mockito.Mockito.mock;
        ) {
        }
            Consumer<Exception> onFailure
        }
        String keyProviderName,
        ) {
        assertFalse(((TestRepository) repository).isClosed);
        public TestCryptoHandler(Settings settings) {
            appender.assertAllExpectationsMatched();
        @Override
        );
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));
        MeteredRepositoryTypeA repository = (MeteredRepositoryTypeA) repositoriesService.repository(repoName);
            long startTime,
    }
            appender.assertAllExpectationsMatched();
    public void testCreateRepositoryLogsTimeTakenOnFailure() throws Exception {
            return null;
            MeteredRepositoryTypeA.TYPE,
        repositoriesService.registerInternalRepository(repoName, TestRepository.TYPE);
                );
        @Override
            return null;
            return null;
        public BlobPath basePath() {
        ClusterState clusterStateWithRepoTypeA = createClusterStateWithKeyProvider(
import org.opensearch.common.io.InputStreamContainer;
            }
        repositoriesService.registerOrUpdateRepository(request, null);
        public CryptoHandler<Object, Object> getOrCreateCryptoHandler(
        ClusterService clusterService = mock(ClusterService.class);
            mock(Transport.class),
        public void deleteSnapshots(
                    RepositoriesService.class.getCanonicalName(),
import org.opensearch.indices.recovery.RecoverySettings;
        public void start() {
            SnapshotId target,
        public Object initEncryptionMetadata() {
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
            ActionListener<Void> listener
            RepositoriesMetadata.TYPE,
        assertNotNull(repository.cryptoHandler);
        @Override
        );
    public void setUp() throws Exception {
    }
            "repoName",
    }
import org.opensearch.index.mapper.MapperService;
        @Override
        final String kpType;
        public String startVerification() {
        Settings settings,
        @Override
    }
        }
/*
            ActionListener<RepositoryData> listener
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));
            repositoryMetadataList.add(newRepositoryMetadata);
    // Native store tests — native store wiring is now handled by
        }
            assertEquals(keyProviderName, cryptoMetadata.keyProviderName());
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
        String keyProviderType,
 * software distributed under the License is distributed on an
            listener.onResponse(null);
        private final TestCryptoProvider cryptoHandler;
import java.util.List;
 */
        @Override
 *
        request = createPutRepositoryEncryptedRequest(repoName, MeteredRepositoryTypeA.TYPE, keyProviderName, settings, keyProviderType);
 * license agreements. See the NOTICE file distributed with
        ) {
            "repoName",
        }
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));
        ClusterService clusterService,
        expectThrows(RepositoryMissingException.class, () -> repositoriesService.repository(repoName));
        public long getRemoteDownloadThrottleTimeInNanos() {
        repository = (MeteredRepositoryTypeA) repositoriesService.repository("repoName");
            keyProviderName,
            MeteredRepositoryTypeA.TYPE,
            RepositoryShardId shardId,
            long primaryTerm,
        ActionListener<ClusterStateUpdateResponse> listener = ActionListener.wrap(response -> fail("expected failure"), failure::set);
    }
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));
        verified.set(false);
        expectThrows(RepositoryMissingException.class, () -> repositoriesService.repository(repoName));
        }
        }
            settings,
        );
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
        String repoName,
        cryptoSettings.keyProviderType(kpTypeA);
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
    // -----------------------------------------------------------------------
        }
        @Override
        Metadata.Builder mdBuilder = Metadata.builder();
import org.opensearch.core.common.Strings;
        repository = (MeteredRepositoryTypeA) repositoriesService.repository(repoName);
        }
        repositoriesService.registerOrUpdateRepository(request, null);
            ReloadableTestRepository.TYPE,
            SnapshotId snapshotId,
        @Override
        Metadata.Builder mdBuilder = Metadata.builder();
import org.opensearch.repositories.blobstore.MeteredBlobStoreRepository;
import java.util.ArrayList;
        state.metadata(mdBuilder);
            super(metadata);
        assertTrue(verified.get());
            appender.addExpectation(
            task.execute(clusterStateWithRepoTypeA);
    }
        }
            repositoriesService.applyClusterState(new ClusterChangedEvent("removed repo", emptyState(), clusterStateWithRepo));
    private ClusterState createClusterStateWithRepo(String repoName, String repoType) {
                )
            ShardId snapshotShardId
        @Override
            return 0;
            "repoName",
            );
            ActionListener<String> listener,
        request.settings(Settings.builder().put(SYSTEM_REPOSITORY_SETTING.getKey(), true).build());
        state.metadata(mdBuilder);
        @Override
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
        protected BlobStore createBlobStore() {
                    Level.INFO,
        expectThrows(IllegalArgumentException.class, () -> repositoriesService.registerOrUpdateRepository(request, null));
        String repoName,
    private ClusterState createClusterStateWithRepo(String repoName, String repoType, Settings settings) {
        String repoName = "name";
 */
            ShardGenerations shardGenerations,
            ReloadableTestRepository.TYPE,
    }
            int totalStreams,
            ActionListener<RepositoryData> listener
        @Override
        assertThat(repositoriesStats.size(), equalTo(1));
        }
    }
        ClusterState clusterStateWithRepoTypeA = createClusterStateWithKeyProvider(
        @Override
            listener.onResponse(null);
            return null;
        );
import org.opensearch.transport.Transport;
        String repoName = "name";
        );
import org.opensearch.common.blobstore.BlobStore;
        @Override
        private MeteredRepositoryTypeB(RepositoryMetadata metadata, ClusterService clusterService) {
            ReloadableTestRepository::new,
            appender.addExpectation(
            super(metadata);
            Version repositoryMetaVersion,
        public void finalizeSnapshot(
    }
        String keyProviderType
    private void assertThrowsOnRegister(String repoName) {
            keyProviderType,
    public void testRegisterWillNotUpdateIfInternalRepositoryWithNameExists() {
            IndexId indexId,
            long repositoryStateId,
import org.opensearch.common.settings.Settings;
            return false;
        }
                    Level.INFO,
                    "repository reload timing",
        RepositoryStatsSnapshot repositoryStatsTypeA = repositoriesStats.get(0);
    }
            keyProviderType
        assertThrowsOnRegister("");
                    "closed repository [" + TestRepository.TYPE + "][" + repoName + "] in [*]"
    public void testRegisterRepositoryLogsTimeTakenOnFailure() throws Exception {
        public RepositoryStats stats() {
    public void testRegisterInternalRepository() {
        }
            SnapshotId snapshotId,
        cryptoSettings.keyProviderName("random");
            return null;
        }
        assertEquals(kpTypeB, repository.cryptoHandler.kpType);
                super.close();
        cryptoSettings.keyProviderName(keyProviderName);
    public void testCryptoManagerClusterStateChanges() {
            if (failOnReload) {
        }
 *
 * specific language governing permissions and limitations
            metadata -> new MeteredRepositoryTypeB(metadata, clusterService)
        }).when(clusterService).submitStateUpdateTask(any(), any());
                )
            return null;
            threadPool,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        repoName = "repoName-2";
        ClusterState updatedClusterState = createClusterStateWithRepo(
        assertEquals(TestRepository.TYPE, repository.getMetadata().type());
        private boolean isStarted;
        @Override
            super(metadata, mock(NamedXContentRegistry.class), clusterService, mock(RecoverySettings.class), Map.of("bucket", "bucket-a"));
        }
import org.opensearch.action.admin.cluster.crypto.CryptoSettings;
            clusterService,
        PutRepositoryRequest request = new PutRepositoryRequest(repoName);
import org.opensearch.plugins.CryptoPlugin;
        assertTrue(failure.get() instanceof RepositoryException);
        private MeteredRepositoryTypeA(RepositoryMetadata metadata, ClusterService clusterService) {
            ClusterState clusterState = task.execute(clusterStateWithRepoTypeA);
        }
        String repoName = "name";
            Function<ClusterState, ClusterState> stateTransformer,
            RuntimeException e = expectThrows(RuntimeException.class, () -> repositoriesService.closeRepository(repository));
        PutRepositoryRequest request = new PutRepositoryRequest("repoName");
        final ClusterService clusterService = mock(ClusterService.class);
    private static class NativeAwareTestRepository extends TestRepository {
        assertTrue(((TestRepository) repository).isClosed);
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);
        expectThrows(RepositoryMissingException.class, () -> repositoriesService.repository(repoName));
        @Override
import java.io.InputStream;
        private TestRepository(RepositoryMetadata metadata) {
            repoName,
        };
    private ClusterState createClusterStateWithKeyProvider(
                )
import org.opensearch.common.Priority;
        }
        assertSame(repository, repository2);
        }
                    Level.INFO,
            keyProviderName,
            appender.addExpectation(
            repoName,
        }).when(clusterService).submitStateUpdateTask(any(), any());
            }
        ) {
        );
        public Metadata getSnapshotGlobalMetadata(SnapshotId snapshotId) {
        public void finalizeSnapshot(
    public void testCryptoManagersUnchangedWithSameCryptoMetadata() {
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
    public void testReloadRepositoryLogsTimeTaken() throws Exception {
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
