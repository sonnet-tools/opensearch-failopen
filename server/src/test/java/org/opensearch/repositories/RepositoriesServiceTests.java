        Metadata.Builder mdBuilder = Metadata.builder();
            ActionListener<String> listener
        public IndexMetadata getSnapshotIndexMetaData(RepositoryData repositoryData, SnapshotId snapshotId, IndexId index) {  
    private static class TestRepository implements Repository {
            }
            appender.assertAllExpectationsMatched();
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
        public RepositoryStats stats() {
        public void removeLifecycleListener(LifecycleListener listener) {
            if (metadata.cryptoMetadata() != null) {
        private final RepositoryMetadata metadata;
        ClusterState updatedClusterState = createClusterStateWithRepo(
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));  
        @Override
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.crypto.MasterKeyProvider;  
            return 0;  
            FailingOnStartTestRepository.TYPE,
        }  
    }  
        assertTrue(failure.get() instanceof RepositoryException);
        @Override  
        return state.build();
            } else {
    public void testCryptoManagersUnchangedWithSameCryptoMetadata() {
        String repoName,  
            repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepo, emptyState()));
        );
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
        @Override  
        assertThat(repositoryStatsTypeA.getRepositoryInfo().type, equalTo(MeteredRepositoryTypeB.TYPE));  
        repositoriesService.registerInternalRepository(repoName, TestRepository.TYPE);  
            long primaryTerm,
                    RepositoriesService.class.getCanonicalName(),
import java.util.function.Function;
        state.metadata(mdBuilder);
        public long estimateDecryptedLength(Object cryptoContext, long contentLength) {
        }
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
            appender.assertAllExpectationsMatched();
            RecoveryState recoveryState,
            MeteredRepositoryTypeA.TYPE,
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));
        @Override
        assertNotNull(repository.cryptoHandler);  
    private static class ReloadableTestRepository extends TestRepository {
            Version repositoryMetaVersion,  
    public void testRegisterInternalRepository() {  
            SnapshotId target,  
            settings.build(),
        cryptoSettings.keyProviderName("random");
    public void testCreateRepositoryLogsTimeTaken() throws Exception {
import org.opensearch.Version;
            ActionListener<RepositoryData> listener  
        when(clusterApplierService.threadPool()).thenReturn(threadPool);
    private RepositoriesService createRepositoriesServiceAndMockCryptoClusterState(  
        repositoriesService.registerOrUpdateRepository(request, null);
            "repoName",
        assertNotNull(repository.cryptoHandler);
        }
            InputStreamContainer stream,
            listener.onResponse(null);
        }
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {  
            return null;  
        ClusterState clusterStateWithRepo = createClusterStateWithRepo(repoName, TestRepository.TYPE);
        public Object initEncryptionMetadata() {
        public boolean isSystemRepository() {
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
        public InputStreamContainer createEncryptingStreamOfPart(  
                    new RepositoryMetadata(repoName, FailingOnStartTestRepository.TYPE, Settings.EMPTY)
 * You may obtain a copy of the License at  
            ActionListener<Void> listener
            return new TestCryptoProvider(keyProviderName, keyProviderType);
        public long getSnapshotThrottleTimeInNanos() {
                new MockLogAppender.SeenEventExpectation(
                new MockLogAppender.SeenEventExpectation(
            assertEquals(keyProviderType, cryptoMetadata.keyProviderType());  
            kpTypeA
            Object cryptoContext,  
        @Override
    ) {
import org.opensearch.common.crypto.DecryptedRangedStreamProvider;
                    Level.INFO,
        expectThrows(RepositoryMissingException.class, () -> repositoriesService.repository(repoName));  
    }  
            super(metadata);
    }
            RepositoriesMetadata repositories = clusterState.metadata().custom(RepositoriesMetadata.TYPE);
            @Override  
        assertNotNull(repository);
            int streamIdx
        final String kpName;
        RepositoriesMetadata newRepositoriesMetadata = new RepositoriesMetadata(repositoryMetadataList);
            super(metadata);
        @Override  
            mock(Transport.class),
        ) {  
        public void addLifecycleListener(LifecycleListener listener) {  
        public void close() {
        @Override
        assertNotNull(repository.cryptoHandler);  
    // -----------------------------------------------------------------------  
 */
    public void testUnregisterRepositoryLogsTimeTaken() throws Exception {
import static org.mockito.Mockito.doAnswer;
            repoName,
        }
    }  
import org.opensearch.common.io.InputStreamContainer;
        );
        assertEquals(kpTypeB, repository.cryptoHandler.kpType);
    private final String kpTypeA = "kp-type-a";
        request.type(MeteredRepositoryTypeA.TYPE);
        doAnswer(invocation -> {
        assertTrue(verified.get());
            listener.onResponse(null);
        public InputStream createDecryptingStream(InputStream encryptingStream) {
            return null;
        @Override
        return repositoryRequest;  
                    metadata.cryptoMetadata().keyProviderName(),
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
            verified,  
import org.opensearch.cluster.metadata.RepositoriesMetadata;
        }
                throw new RuntimeException("reload failed");  
            repoName,
            Metadata clusterMetadata,  
        ) {}
/*  
        @Override  
        protected BlobStore createBlobStore() {
        }
        PutRepositoryRequest request = new PutRepositoryRequest("repoName");  
        String repoName = "name";
/*
                    Level.INFO,
        private boolean failOnReload;
        private static final RepositoryStats STATS = new RepositoryStats(Map.of("GET", 10L));  
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeB, emptyState()));  
        ThreadPool threadPool = mock(ThreadPool.class);
        public long getRemoteDownloadThrottleTimeInNanos() {
        }
        }
            appender.assertAllExpectationsMatched();  
        String repoName = "name";
        @Override  
    private static class MeteredRepositoryTypeB extends MeteredBlobStoreRepository {
            assertEquals(keyProviderName, cryptoMetadata.keyProviderName());
        @Override
    public void testCryptoManagerClusterStateChanges() {
        RepositoryStatsSnapshot repositoryStatsTypeA = repositoriesStats.get(0);
import org.opensearch.indices.recovery.RecoverySettings;  
            Store store,  
        );
                    "put/update repository [" + repoName + "] took [*]"
        private static final String TYPE = "internal";
            );
            Settings.EMPTY,
        String repoName = "name";  
        assertEquals(TestRepository.TYPE, repository.getMetadata().type());  
        MeteredRepositoryTypeA repository = (MeteredRepositoryTypeA) repositoriesService.repository("repoName");
                    RepositoriesService.class.getCanonicalName(),
        cryptoSettings.settings(Settings.builder());  
        public void cloneShardSnapshot(
        assertFalse(((TestRepository) repository).isClosed);
import java.io.IOException;
        doAnswer((invocation) -> {  
    public void testCloseRepositoryLogsTimeTakenOnFailure() throws Exception {  
        }
            repoName,  
                cryptoHandler = new TestCryptoProvider(
    public void testReloadRepositoryLogsTimeTakenOnFailure() throws Exception {
            "repoName",
        when(clusterService.getSettings()).thenReturn(Settings.EMPTY);
            "repoName",
        RepositoriesService repositoriesService = createRepositoriesServiceWithMockedClusterService(clusterService);
        ) {
        repositoriesService.registerInternalRepository(repoName, TestRepository.TYPE);  
            return 0;
        ) {  
        public void endVerification(String verificationToken) {
    }  
        repositoriesService.registerOrUpdateRepository(request, null);
 * SPDX-License-Identifier: Apache-2.0
        List<RepositoryMetadata> repositoryMetadata = new ArrayList<>();
            SnapshotId snapshotId,  
        final ClusterService clusterService = mock(ClusterService.class);
        assertThat(repositoriesStats.size(), equalTo(1));
            return null;  
import org.opensearch.common.settings.ClusterSettings;
        String repoName = "name";  
                    "repository reload timing",  
        assertThrowsOnRegister("contains#InvalidCharacter");
                    "reloaded repository [" + ReloadableTestRepository.TYPE + "][" + repoName + "] in [*]"  
                throw new RuntimeException("close failed");  
        private static final String TYPE = "type-a";
            return null;  
        ((ReloadableTestRepository) repositoriesService.repository(repoName)).failOnReload = true;  
            return 0;
            Version repositoryMetaVersion,
                    Level.INFO,
import java.util.Map;
        protected BlobStore createBlobStore() {  
        }
    public void testCreateRepositoryLogsTimeTakenOnFailure() throws Exception {  
        ClusterState updatedClusterState = createClusterStateWithRepo(
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
        @Override
    }
            verified.set(true);
        assertTrue(verified.get());
            repositoryMetadata
import org.opensearch.cluster.metadata.Metadata;
 * compatible open source license.
            IndexId indexId,
        @Override
    }
import java.util.concurrent.atomic.AtomicBoolean;
        public void reload(RepositoryMetadata repositoryMetadata) {
        assertEquals(repoName, repository.getMetadata().name());
            return BlobPath.cleanPath();
                    "delete repository [" + repoName + "] took [*]"  
        );  
            long startPosOfRawContent,
            assertEquals(cryptoMetadata.settings(), settings);
            Map<String, Object> userMetadata,
            ShardGenerations shardGenerations,
        String repoType,
import static org.opensearch.repositories.blobstore.BlobStoreRepository.SYSTEM_REPOSITORY_SETTING;
        );
        expectThrows(IllegalArgumentException.class, () -> repositoriesService.registerOrUpdateRepository(request, null));
        ClusterState clusterStateWithRepoTypeB = createClusterStateWithKeyProvider(  
            IndexShardSnapshotStatus snapshotStatus,  
            String keyProviderName,  
            ActionListener<String> listener
            ClusterState clusterState = task.execute(clusterStateWithRepoTypeA);  
import org.opensearch.snapshots.SnapshotId;
        expectThrows(IllegalArgumentException.class, () -> repositoriesService.registerOrUpdateRepository(request, null));
                    new ClusterChangedEvent("update repo", updatedClusterState, clusterStateWithRepo)
    public void testRegisterRejectsInvalidRepositoryNames() {  
        }  
        ClusterService clusterService,
        PutRepositoryRequest request = createPutRepositoryEncryptedRequest(
        expectThrows(RepositoryMissingException.class, () -> repositoriesService.repository(repoName));
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepo, emptyState()));  
import java.util.Collections;
        }  
        ) {
        }
        repository = (MeteredRepositoryTypeA) repositoriesService.repository(repoName);
            ShardId snapshotShardId,  
import org.opensearch.plugins.CryptoPlugin;
            repositoriesService.unregisterRepository(new DeleteRepositoryRequest(repoName), listener);  
    }
        }
            Collection<SnapshotId> snapshotIds,
        when(nodes.getMinNodeVersion()).thenReturn(Version.V_2_9_0);
        assertNotNull(repository.cryptoHandler);  
 * software distributed under the License is distributed on an
            MeteredRepositoryTypeB.TYPE,
import org.opensearch.cluster.metadata.IndexMetadata;  
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
        cryptoSettings.keyProviderType(keyProviderType);
    public void testWithSameKeyProviderNames() {
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        @Override
            SnapshotId source,
                ClusterStateUpdateResponse>) invocation.getArguments()[1];
import org.opensearch.common.crypto.CryptoHandler;  
        }).when(clusterService).submitStateUpdateTask(any(), any());
        ) {
        @Override
                    "created repository [" + TestRepository.TYPE + "][" + repoName + "] in [*]"
            clusterService,
            ReloadableTestRepository::new,
            verified,
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));
            long repositoryStateId,  
    public void setUp() throws Exception {  
    public void testCloseRepositoryLogsTimeTaken() throws Exception {  
                cryptoHandler = new TestCryptoProvider(
        @Override  
        Metadata.Builder mdBuilder = Metadata.builder();  
}
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.mock;
                new MockLogAppender.SeenEventExpectation(
        when(clusterService.state()).thenReturn(currentClusterState);
 * specific language governing permissions and limitations
        public Lifecycle.State lifecycleState() {
 * Licensed to Elasticsearch under one or more contributor  
            return mock(BlobStore.class);  
        public boolean isReadOnly() {  
            return null;
        String keyProviderType  
            new RepositoriesMetadata(Collections.singletonList(new RepositoryMetadata(repoName, repoType, Settings.EMPTY, cryptoMetadata)))
        }  
        @Override
        public TestCryptoProvider(String kpName, String kpType) {
        Repository repository2 = repositoriesService.repository(repoName);
 * license agreements. See the NOTICE file distributed with
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
        String repoName = "name";
        }
import org.opensearch.threadpool.ThreadPool;  
        }
            return null;
            String shardGeneration,  
        Settings settings,
        repositoriesService.registerOrUpdateRepository(request, null);
    // ExtensiblePlugin.loadExtensions in each repository plugin.
            verified,
        private static final String TYPE = "native-aware";
        repositoriesService.registerInternalRepository("repo", TestRepository.TYPE);
            this.kpName = kpName;
        cryptoSettings.settings(settings);  
        );
        assertNotNull(repositoryB);  
        );
        assertNotNull(repository.cryptoHandler);
        String keyProviderName = "kp-name-1";
        // No change
        repositoriesService.start();
            this.kpType = kpType;  
            }
import java.util.List;  
import org.opensearch.cluster.metadata.CryptoMetadata;
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));
import org.opensearch.common.UUIDs;  
 */  
        }
        );
            Function<RepositoryData, ClusterStateUpdateTask> createUpdateTask,
        ClusterState currentClusterState = mock(ClusterState.class);  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        public void updateState(final ClusterState state) {}
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
            repoName,
        settings = Settings.builder();  
            listener.onResponse(null);  
        public long getRemoteUploadThrottleTimeInNanos() {  
                () -> repositoriesService.applyClusterState(  
            repositoryMetadata
        }
    // RepositoriesService no longer participates in native store init.  
        @Override  
        @Override
    private ClusterState createClusterStateWithRepo(String repoName, String repoType, Settings settings) {
        @Override
        }
        }  
                    "repository creation timing",
        public TestCryptoHandler(Settings settings) {  
        private boolean isStarted;  
        );  
import org.apache.logging.log4j.LogManager;
        }
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);  
            appender.addExpectation(
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
                ClusterStateUpdateResponse>) invocation.getArguments()[1];  
        @Override
        List<RepositoryMetadata> repositoryMetadataList
        String repoName = "name";
            long endPosOfRawContent
            super(metadata, mock(NamedXContentRegistry.class), clusterService, mock(RecoverySettings.class), Map.of("bucket", "bucket-b"));
            ActionListener<RepositoryData> listener
        @Override  
            typesRegistry,  
        CryptoMetadata newCryptoMetadata = new CryptoMetadata(keyProviderName, keyProviderType, Settings.EMPTY);
        public DecryptedRangedStreamProvider createDecryptingStreamOfRange(
            repoName,  
        ThreadPool threadPool = mock(ThreadPool.class);
        public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
        assertNotNull(repository);
import org.opensearch.common.lifecycle.LifecycleListener;  
            SnapshotId snapshotId,
        }
            MeteredRepositoryTypeA.TYPE,
        private MeteredRepositoryTypeB(RepositoryMetadata metadata, ClusterService clusterService) {
                new MockLogAppender.SeenEventExpectation(
        PutRepositoryRequest request = new PutRepositoryRequest(repoName);
            new RepositoriesMetadata(Collections.singletonList(new RepositoryMetadata(repoName, repoType, settings)))
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);  
            isClosed = true;  
        ClusterState clusterStateWithRepoTypeB = createClusterStateWithRepo(repoName, MeteredRepositoryTypeB.TYPE);  
            Store store,
                    Level.INFO,  
            task.onFailure("delete_repository [" + repoName + "]", new RepositoryMissingException(repoName));
        public long getLowPriorityRemoteDownloadThrottleTimeInNanos() {
        final Repository repo = repositoriesService.repository("repo");
            Store store,
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));  
            FailingOnStartTestRepository::new,  
            repoName,  
    }
        private static final String TYPE = "failing-on-start";
        mdBuilder.putCustom(RepositoriesMetadata.TYPE, newRepositoriesMetadata);  
            String shardGeneration,
        repoName = "repoName-2";
                    "repository creation timing",
                cryptoHandler = null;  
            appender.assertAllExpectationsMatched();
            return STATS;
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));
        verified.set(false);
    }
                    "repository close timing",  
        ClusterState clusterStateWithRepo = createClusterStateWithRepo(repoName, ReloadableTestRepository.TYPE);
                    "put repository timing",
        }
            return true;  
        AtomicBoolean verified,  
        }
    @Override
        verified.set(false);  
            SnapshotInfo snapshotInfo,
        String keyProviderName = "kp-name";  
        ClusterService clusterService = mock(ClusterService.class);  
        );  
            IndexShardSnapshotStatus snapshotStatus,
            return null;
import org.opensearch.cluster.metadata.RepositoryMetadata;  
        RepositoryMetadata newRepositoryMetadata = new RepositoryMetadata(
        }  
    }
        ActionListener<ClusterStateUpdateResponse> listener = ActionListener.wrap(response -> fail("expected failure"), failure::set);
                    "created repository [" + FailingOnStartTestRepository.TYPE + "][" + repoName + "] in [*]"
        Repository repository = repositoriesService.repository(repoName);
                    Level.INFO,  
            assertThrowsOnRegister("contains" + c + "InvalidCharacters");
            repositoriesService.registerOrUpdateRepository(request, listener);
        // Same crypto client in new repo
    }
import org.opensearch.cluster.AckedClusterStateUpdateTask;
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
        @Override
        assertNotNull(repository.cryptoHandler);
        public CryptoHandler<Object, Object> getOrCreateCryptoHandler(
        assertEquals(Settings.EMPTY, repository.getMetadata().settings());
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {  
        PutRepositoryRequest repositoryRequest = new PutRepositoryRequest(repoName);  
        public void executeConsistentStateUpdate(
            settings.build(),  
            this.metadata = metadata;
        AtomicReference<Exception> failure = new AtomicReference<>();  
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));  
                cryptoHandler = null;
        String repoType,
            );
        final ClusterApplierService clusterApplierService = mock(ClusterApplierService.class);  
                )
        repositoryRequest.cryptoSettings(cryptoSettings);
        cryptoSettings.keyProviderName(keyProviderName);
        assertNotNull(repository.cryptoHandler);  
            transportService,
        final TransportService transportService = new TransportService(
        assertTrue(verified.get());
            IndexMetadata indexMetadata  
        @Override  
            repositoryMetadataList.add(newRepositoryMetadata);  
        ClusterService clusterService = mock(ClusterService.class);
                )
        when(clusterService.getClusterApplierService()).thenReturn(clusterApplierService);
                () -> repositoriesService.createRepository(
        assertNotNull(repository);  
            keyProviderName,
        public BlobPath basePath() {  
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);  
import org.opensearch.index.mapper.MapperService;
            clusterService,
        ) {  
            Runnable onClose
            IndexCommit snapshotIndexCommit,
            Object cryptoContextObj,
            return false;
                super.close();
        }
        public RemoteStoreShardShallowCopySnapshot getRemoteStoreShallowCopyShardMetadata(
                    Level.INFO,
 * not use this file except in compliance with the License.
        return state.build();
import org.opensearch.cluster.node.DiscoveryNode;
        @Override  
        @Override
        repository = (MeteredRepositoryTypeA) repositoriesService.repository(repoName);
        repositoriesService.registerOrUpdateRepository(request, null);  
        Settings.Builder settings,  
            Function<ClusterState, ClusterState> stateTransformer,  
        mdBuilder.putCustom(
import org.apache.lucene.index.IndexCommit;  
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
        }
        assertTrue(((TestRepository) repository).isClosed);
            );
        }
        public String startVerification() {  
        public void stop() {  
            ReloadableTestRepository.TYPE,  
        @Override  
            clusterService,
        }  
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
        state.metadata(mdBuilder);  
        public void close() throws IOException {
            appender.addExpectation(
                    RepositoriesService.class.getCanonicalName(),  
            metadata -> new MeteredRepositoryTypeA(metadata, clusterService),
            );  
        String repoName = "name";
        AtomicBoolean verified = new AtomicBoolean();
        Settings.Builder settings = Settings.builder();
        ClusterState clusterStateWithRepo = createClusterStateWithRepo(repoName, TestRepository.TYPE);  
        public boolean isReloadableSettings(RepositoryMetadata newRepositoryMetadata) {
        }
            boundAddress -> DiscoveryNode.createLocal(Settings.EMPTY, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
        @Override  
            RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,  
                    "closed repository [" + TestRepository.TYPE + "][" + repoName + "] in [*]"
        public long getRestoreThrottleTimeInNanos() {
    private PutRepositoryRequest createPutRepositoryEncryptedRequest(
        assertSame(repository, repository2);  
    private static abstract class TestCryptoHandler implements CryptoPlugin<Object, Object> {  
        }
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", emptyState(), clusterStateWithRepoTypeA));  
    }  
        repositoriesService = createRepositoriesServiceAndMockCryptoClusterState(
            keyProviderName,
        Repository repository = repositoriesService.repository(repoName);
                );
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepo, emptyState()));  
    private ClusterState createClusterStateWithRepo(String repoName, String repoType) {
            appender.addExpectation(  
import org.opensearch.core.common.Strings;
        assertNotNull(repository);
            Settings.EMPTY,  
import org.opensearch.common.blobstore.BlobPath;
                new MockLogAppender.SeenEventExpectation(  
            kpTypeA
            MasterKeyProvider keyProvider,
        @Override
    // Native store tests — native store wiring is now handled by
            return 0;
import org.opensearch.index.snapshots.blobstore.RemoteStoreShardShallowCopySnapshot;  
            ReloadableTestRepository.TYPE,  
        String repoName,
            kpTypeA
        private static final String TYPE = "reloadable";  
        }
            MapperService mapperService,  
        }  
        @Override
            return 0;  
import java.util.ArrayList;  
        }
            expectThrows(
        @Override  
        repositoriesService.registerOrUpdateRepository(request, null);
                    metadata.cryptoMetadata().keyProviderName(),  
        settings = Settings.builder();
        repositoriesService = createRepositoriesServiceAndMockCryptoClusterState(  
    }
            long commitGeneration,
            keyProviderType,
    public void testUpdateOrRegisterRejectsForSystemRepository() {
        @Override
        }  
        private static final String TYPE = "type-b";  
            keyProviderName,
        MeteredRepositoryTypeA repository = (MeteredRepositoryTypeA) repositoriesService.repository("repoName");  
    }
        assertNotNull(repository.cryptoHandler);  
    }  
        public void deleteSnapshots(
    }
    private static class FailingOnStartTestRepository extends TestRepository {
        String repoName = "name";
        @Override  
            expectThrows(
import java.io.InputStream;
            );
            appender.assertAllExpectationsMatched();
        private boolean isClosed;
                    metadata.cryptoMetadata().keyProviderType()
        @Override
                )
            SnapshotInfo snapshotInfo,
            typesRegistry,
    }
        CryptoSettings cryptoSettings = new CryptoSettings(keyProviderName);  
import org.opensearch.action.admin.cluster.repositories.delete.DeleteRepositoryRequest;  
        );  
            // applyClusterState swallows the reload failure but trips an assert in tests  
            );
        }  
import org.apache.logging.log4j.Level;
            SnapshotId snapshotId,
    }  
        repository = (MeteredRepositoryTypeA) repositoriesService.repository(repoName);
        }  
            kpTypeA
    public void testGetNativeStoreDefaultIsEmpty() {  
        private TestRepository(RepositoryMetadata metadata) {
        }  
        Repository repository = repositoriesService.repository(repoName);  
        if (!repositoryMetadataList.contains(newRepositoryMetadata)) {
            keyProviderType,
            RepositoryMetadata repositoryMetadata = repositories.repositories().get(repositoryMetadataList.size() - 1);
            metadata -> new MeteredRepositoryTypeB(metadata, clusterService)
            RepositoriesMetadata.TYPE,  
            RepositoriesMetadata.TYPE,  
        assertSame(NativeStoreRepository.EMPTY, repo.getNativeStore());  
            return metadata;
            return 0;  
    public void testRepositoriesStatsCanHaveTheSameNameAndDifferentTypeOverTime() {  
import java.util.concurrent.atomic.AtomicReference;  
        String keyProviderName,
        }
        @Override
import java.util.Collection;
        assertThat(repositoryStatsTypeA.getRepositoryStats(), equalTo(MeteredRepositoryTypeB.STATS));
                    Level.INFO,
                );
        repositoryRequest.settings(Settings.EMPTY);
            return new Object();
        keyProviderType = kpTypeA;  
            super(metadata, mock(NamedXContentRegistry.class), clusterService, mock(RecoverySettings.class), Map.of("bucket", "bucket-a"));
    }
                new MockLogAppender.SeenEventExpectation(  
    }  
        private FailingOnStartTestRepository(RepositoryMetadata metadata) {  
            newCryptoMetadata  
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(0));
import static org.mockito.ArgumentMatchers.any;  
            );
            NoopTracer.INSTANCE
import org.opensearch.transport.Transport;
            repositoryMetadata
            Settings.builder().put("updated", true).build()
            repositoriesService.applyClusterState(new ClusterChangedEvent("removed repo", emptyState(), clusterStateWithRepo));
        );  
            String source,  
            return null;  
import org.opensearch.index.store.Store;
 */  
        public RepositoryMetadata getMetadata() {  
        }
        doAnswer((invocation) -> {
        NativeAwareTestRepository(RepositoryMetadata metadata) {  
        return repositoriesService;  
            task.execute(clusterStateWithRepoTypeA);
        String repoName = "repoName";
            appender.addExpectation(
import org.opensearch.core.index.shard.ShardId;
        ClusterState clusterStateWithRepoTypeA = createClusterStateWithKeyProvider(
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
        }
            }
        }
            );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        settings = Settings.builder();
            keyProviderName,  
        public void verify(String verificationToken, DiscoveryNode localNode) {
            this.settings = settings;
        @Override
        repositoriesService = createRepositoriesServiceWithMockedClusterService(clusterService);  
import org.opensearch.transport.TransportService;
        repositoriesService.registerInternalRepository(repoName, TestRepository.TYPE);
                )
        public void restoreShard(
            Settings.builder().put("updated", true).build()
        Repository repository = new TestRepository(new RepositoryMetadata(repoName, TestRepository.TYPE, Settings.EMPTY)) {
        @Override
        }
    }
        public void getRepositoryData(ActionListener<RepositoryData> listener) {
            SnapshotId source,  
        }
        request.cryptoSettings(cryptoSettings);  
            );
            ShardId snapshotShardId
        ) {
            String keyProviderType,
 *  
        @Override  
            Function<ClusterState, ClusterState> stateTransformer,
            return null;
            SnapshotId snapshotId,
            return mock(BlobStore.class);
        }  
        private ReloadableTestRepository(RepositoryMetadata metadata) {  
import org.opensearch.common.settings.Settings;
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {  
                    "reloaded repository [" + ReloadableTestRepository.TYPE + "][" + repoName + "] in [*]"  
        CryptoSettings cryptoSettings = new CryptoSettings(keyProviderName);  
import org.opensearch.cluster.ClusterChangedEvent;  
        assertNotNull(repository.cryptoHandler);  
        }
            keyProviderName,
                    RepositoriesService.class.getCanonicalName(),
package org.opensearch.repositories;
            "repoName",
import org.opensearch.indices.recovery.RecoveryState;
        expectThrows(IllegalArgumentException.class, () -> repositoriesService.registerOrUpdateRepository(request, null));
        @Override
            CryptoMetadata cryptoMetadata = repositoryMetadata.cryptoMetadata();  
        assertFalse(((TestRepository) repository).isClosed);
        ClusterService clusterService = mock(ClusterService.class);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {
            ShardGenerations shardGenerations,
        public void finalizeSnapshot(  
            threadPool,
        private final TestCryptoProvider cryptoHandler;
        }
        @Override
        public void snapshotRemoteStoreIndexShard(  
        request = createPutRepositoryEncryptedRequest(repoName, MeteredRepositoryTypeA.TYPE, keyProviderName, settings, keyProviderType);
            long startTime,  
    }  
import static org.mockito.Mockito.when;  
        }
import java.util.function.Consumer;
            keyProviderName,
        }).when(clusterService).submitStateUpdateTask(any(), any());  
import org.opensearch.cluster.service.ClusterService;
            return null;
            long repositoryStateId,  
            settings.build(),  
            IndexId indexId,  
public class RepositoriesServiceTests extends OpenSearchTestCase {
            ActionListener<String> listener,
    public void testRepositoryUpdateWithDifferentCryptoMetadata() {
            String shardStateIdentifier,
        private final TestCryptoProvider cryptoHandler;
        }  
        String keyProviderName,
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryRequest;
                    "repository close timing",
        assertTrue(verified.get());
        PutRepositoryRequest request = new PutRepositoryRequest(repoName);
import org.opensearch.cluster.ClusterStateUpdateTask;  
        ) {
        ClusterState clusterStateWithRepo = createClusterStateWithRepo(repoName, ReloadableTestRepository.TYPE);
 * Unless required by applicable law or agreed to in writing,
        );
            keyProviderName,
            public void close() {
        MeteredRepositoryTypeA repository = (MeteredRepositoryTypeA) repositoriesService.repository("repoName");
        String keyProviderType
        public void cloneRemoteStoreIndexShardSnapshot(
    private static class TestCryptoProvider implements CryptoHandler<Object, Object> {  
        }
    private RepositoriesService createRepositoriesServiceWithMockedClusterService(ClusterService clusterService) {  
        repositoriesService.unregisterInternalRepository(repoName);
        @Override
            return null;
        assertThrowsOnRegister("");
            repositoryMetadata
        RepositoriesService repositoriesService = createRepositoriesServiceWithMockedClusterService(clusterService);
            AckedClusterStateUpdateTask<ClusterStateUpdateResponse> task = (AckedClusterStateUpdateTask<
            appender.addExpectation(  
    private static class MeteredRepositoryTypeA extends MeteredBlobStoreRepository {
            if (failOnReload) {
        RepositoriesService repositoriesService = new RepositoriesService(
            SnapshotId target,
            MeteredRepositoryTypeA.TYPE,  
            keyProviderType,
        expectThrows(RepositoryMissingException.class, () -> repositoriesService.repository(repoName));
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));  
        @Override
        Map<String, Repository.Factory> typesRegistry = Map.of(  
        verified.set(false);  
        public void snapshotShard(
import org.opensearch.common.crypto.EncryptedHeaderContentSupplier;
    }  
    }  
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
            return false;  
        public long estimateEncryptedLengthOfEntireContent(Object cryptoContextObj, long contentLength) {
        }  
        Metadata.Builder mdBuilder = Metadata.builder();  
 * GitHub history for details.
        PutRepositoryRequest request = new PutRepositoryRequest(repoName);
            Map<String, Long> indexFilesToFileLengthMap,
        expectThrows(RepositoryMissingException.class, () -> repositoriesService.repository(repoName));
    }
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepo, emptyState()));
        public RepositoryStats stats() {
        ) {
                )  
        public Metadata getSnapshotGlobalMetadata(SnapshotId snapshotId) {
            TestRepository::new,
        }
            isStarted = true;
        cryptoSettings.settings(Settings.builder().put("key-1", "val-1"));
            String shardStateIdentifier,
        ) {  
            ReloadableTestRepository.TYPE,  
        keyProviderType = kpTypeB;  
                )
        );
    }
        }
        request.settings(Settings.EMPTY);
            appender.addExpectation(
            repositoriesService.applyClusterState(new ClusterChangedEvent("update repo", updatedClusterState, clusterStateWithRepo));  
        }).when(clusterService).submitStateUpdateTask(any(), any());
            int totalStreams,  
        String keyProviderType = kpTypeA;  
                AssertionError.class,
    public void testReloadRepositoryLogsTimeTaken() throws Exception {  
        }
                    "delete repository timing",  
        @Override
 * Modifications Copyright OpenSearch Contributors. See
            IndexId indexId,
            RepositoryShardId shardId,
        assertEquals(kpTypeA, repository.cryptoHandler.kpType);
            Version repositoryMetaVersion,
import org.opensearch.common.blobstore.BlobStore;
import org.opensearch.cluster.ClusterState;
                ClusterStateUpdateResponse>) invocation.getArguments()[1];
        assertTrue(((TestRepository) repository).isStarted);
        String keyProviderName = "kp-name";
        mdBuilder.putCustom(
        RepositoriesService repositoriesService = createRepositoriesServiceAndMockCryptoClusterState(
        }  
import org.opensearch.cluster.ClusterName;
        String repoName = "name";  
            IndexId indexId,
            ActionListener<RepositoryData> listener
    private ClusterState emptyState() {  
        assertTrue(failure.get() instanceof RepositoryMissingException);  
        List<RepositoryStatsSnapshot> repositoriesStats = repositoriesService.repositoriesStats();  
            keyProviderType,
                )
import org.opensearch.cluster.node.DiscoveryNodes;
        @Override
        );  
    private ClusterState createClusterStateWithKeyProvider(
    }
        repositoriesService.registerInternalRepository(repoName, TestRepository.TYPE);  
        @Override  
        repositoriesService = createRepositoriesServiceAndMockCryptoClusterState(
        request.type("unknown-type");
        );
            repoName,  
        @Override
            Collections.emptySet(),  
            MeteredRepositoryTypeB.TYPE,  
import org.opensearch.cluster.service.ClusterApplierService;  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            keyProviderName,
        @Override  
        request.settings(Settings.builder().put(SYSTEM_REPOSITORY_SETTING.getKey(), true).build());
            listener.onResponse(null);  
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
            return null;
            ActionListener<String> listener
        public BlobPath basePath() {
            long repositoryStateId,
 * under the License.  
                    "repository reload timing",  
    public void testRegisterWillNotUpdateIfInternalRepositoryWithNameExists() {  
        String keyProviderName,  
        verified.set(false);  
    private static class NativeAwareTestRepository extends TestRepository {  
            return null;
        public long adjustContentSizeForPartialEncryption(Object cryptoContextObj, long contentSize) {  
            return 0;
            return BlobPath.cleanPath();
        }  
        when(currentClusterState.getNodes()).thenReturn(nodes);
        cryptoSettings.keyProviderType(kpTypeA);
            threadPool
        // Different crypto client in new repo
        public InputStreamContainer createEncryptingStream(Object encryptionMetadata, InputStreamContainer streamContainer) {
        ) {  
    public void testUnregisterInternalRepository() {
        expectThrows(RepositoryException.class, () -> repositoriesService.registerOrUpdateRepository(request, null));  
        ClusterState clusterStateWithRepoTypeA = createClusterStateWithRepo(repoName, MeteredRepositoryTypeA.TYPE);
            settings.build(),  
        String repoName = "name";  
        request = createPutRepositoryEncryptedRequest(repoName, MeteredRepositoryTypeA.TYPE, keyProviderName, settings, keyProviderType);
        String keyProviderType,
        CryptoMetadata cryptoMetadata = new CryptoMetadata(keyProviderName, keyProviderType, Settings.EMPTY);
        String repoName = "name";
        ClusterState.Builder state = ClusterState.builder(new ClusterName("test"));
        public Object loadEncryptionMetadata(EncryptedHeaderContentSupplier encryptedHeaderContentSupplier) throws IOException {  
                new MockLogAppender.SeenEventExpectation(
        }
                )  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
    public void testRegisterRepositoryLogsTimeTakenOnFailure() throws Exception {
        repoName = "repoName-3";
            MeteredRepositoryTypeA.TYPE,
        for (char c : Strings.INVALID_FILENAME_CHARS) {  
            appender.addExpectation(
        @Override  
            IndexCommit snapshotIndexCommit,  
    }  
            null,
        }
        assertThat(repositoriesService.repositoriesStats().size(), equalTo(1));
            } else {  
        public void finalizeSnapshot(
    private void assertThrowsOnRegister(String repoName) {
        }
            Metadata clusterMetadata,
 * The OpenSearch Contributors require contributions made to  
            repoName,  
            assertEquals("close failed", e.getMessage());
            return null;
            verified,
                    RepositoriesService.class.getCanonicalName(),
        }
            keyProviderName,  
        AtomicReference<Exception> failure = new AtomicReference<>();
                    RepositoriesService.class.getCanonicalName(),  
    // -----------------------------------------------------------------------
        String repoName = "name";
import org.opensearch.test.OpenSearchTestCase;
            appender.assertAllExpectationsMatched();
            appender.addExpectation(
            clusterService,
            return STATS;  
        @Override  
            settings,  
        public SnapshotInfo getSnapshotInfo(SnapshotId snapshotId) {
        ClusterState clusterStateWithRepoTypeA = createClusterStateWithKeyProvider(
        @Override
            RepositoryShardId shardId,
    ) {
            assertNotNull(cryptoMetadata);
        repository = (MeteredRepositoryTypeA) repositoriesService.repository("repoName");
        MeteredRepositoryTypeA repository = (MeteredRepositoryTypeA) repositoriesService.repository(repoName);
        RepositoriesService repositoriesService = createRepositoriesServiceWithMockedClusterService(clusterService);
            repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));  
        private static final RepositoryStats STATS = new RepositoryStats(Map.of("LIST", 20L));
        keyProviderType = kpTypeA;
        String keyProviderName = "kp-name";  
            Version repositoryMetaVersion,  
            clusterService,
import org.opensearch.repositories.blobstore.MeteredBlobStoreRepository;  
        @Override
                )
 *
        ClusterState clusterStateWithRepoTypeA = createClusterStateWithKeyProvider(
 * this work for additional information regarding copyright
            AckedClusterStateUpdateTask<ClusterStateUpdateResponse> task = (AckedClusterStateUpdateTask<  
            RuntimeException e = expectThrows(RuntimeException.class, () -> repositoriesService.closeRepository(repository));  
        return repositoriesService;
        final String kpType;
        ) {  
        }  
    }
            keyProviderType
    private final String kpTypeB = "kp-type-b";  
                    "closed repository [" + TestRepository.TYPE + "][" + repoName + "] in [*]"  
                    metadata.cryptoMetadata().keyProviderType()  
import org.opensearch.common.lifecycle.Lifecycle;
    }
                    RepositoriesService.class.getCanonicalName(),
import static org.hamcrest.Matchers.equalTo;
    }
        String repoName,  
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
import org.opensearch.snapshots.SnapshotInfo;
            TestRepository.TYPE,
    private RepositoriesService repositoriesService;
            AckedClusterStateUpdateTask<ClusterStateUpdateResponse> task = (AckedClusterStateUpdateTask<
            super(metadata);
            MeteredRepositoryTypeA.TYPE,  
                    RepositoriesService.class.getCanonicalName(),
        expectThrows(RepositoryException.class, () -> repositoriesService.registerOrUpdateRepository(request, null));  
        }  
            MeteredRepositoryTypeA.TYPE,  
        assertFalse(((TestRepository) repository).isClosed);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(RepositoriesService.class))) {  
        private final Settings settings;
        );  
    }  
        super.setUp();
        state.metadata(mdBuilder);  
            return 0;  
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));
            Priority repositoryUpdatePriority,
            Settings.EMPTY,  
        };
        ClusterState clusterStateWithRepoTypeA = state.build();
import org.opensearch.action.admin.cluster.crypto.CryptoSettings;
        private MeteredRepositoryTypeA(RepositoryMetadata metadata, ClusterService clusterService) {  
import org.opensearch.test.MockLogAppender;
            );  
        cryptoSettings.keyProviderName(keyProviderName);
        }  
        @Override
        public void start() {
            if (metadata.cryptoMetadata() != null) {  
                new MockLogAppender.SeenEventExpectation(
        return ClusterState.builder(new ClusterName("test")).build();
            Consumer<Exception> onFailure
        }
        request = createPutRepositoryEncryptedRequest(repoName, MeteredRepositoryTypeA.TYPE, keyProviderName, settings, keyProviderType);
                )  
import org.opensearch.common.Priority;
            throw new RuntimeException("start failed");  
        MeteredRepositoryTypeB repositoryB = (MeteredRepositoryTypeB) repositoriesService.repository("repoName");
            appender.assertAllExpectationsMatched();
import org.opensearch.core.action.ActionListener;  
        ActionListener<ClusterStateUpdateResponse> listener = ActionListener.wrap(response -> fail("expected failure"), failure::set);
        String repoName = "name";  
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeA, emptyState()));  
/*  
                RepositoryException.class,  
        public void start() {
 *
            }
    }
        repositoryRequest.type(repoType);
        }
        repositoriesService.applyClusterState(new ClusterChangedEvent("new repo", clusterStateWithRepoTypeB, emptyState()));
            return null;
    }  
        return createClusterStateWithRepo(repoName, repoType, Settings.EMPTY);
        }
            appender.assertAllExpectationsMatched();
        expectThrows(RepositoryMissingException.class, () -> repositoriesService.repository(repoName));
                    Level.INFO,
        }
