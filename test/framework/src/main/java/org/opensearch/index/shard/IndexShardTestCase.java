            );  
        Settings indexSettings = Settings.builder()
        );
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
            .putMapping("{ \"properties\": {} }")  
     * @param listeners an optional set of listeners to add to the shard
                shardPath,
        } else {
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> indexReaderWrapper,
                BlobStoreRepository repo = createRepository(remotePath);
            currentClusterStateVersion.incrementAndGet(),  
            .primaryTerm(0, primaryTerm)
import org.opensearch.index.MapperTestUtils;
     *  
            shardPath,  
        Path remotePath,
        IndexMetadata metadata = IndexMetadata.builder(shardRouting.getIndexName())  
                return new InternalTranslogFactory();  
            replica.indexSettings.isRemoteTranslogStoreEnabled()  
        };
            retentionLeaseSyncer,
    ) throws IOException {  
import org.opensearch.core.common.bytes.BytesArray;
            mock(ClusterService.class),  
            .put(Settings.EMPTY)
        shard.flush(new FlushRequest(shard.shardId().getIndexName()).force(force));  
        recoverFromStore(primary);
            SimilarityService similarityService = new SimilarityService(indexSettings, null, Collections.emptyMap());  
            storeProvider,
                ? IndexShardTestUtils.getFakeRemoteEnabledDiscoveryNodes(routingTable.shards())
     * @param indexEventListener            index event listener
        IndexShard replicaShard,
                if (settings.isRemoteTranslogStoreEnabled() && shardRouting.primary()) {
import org.opensearch.index.mapper.MapperService;
     * @param latch - Latch which allows consumers of this utility to ensure segment replication completed successfully  
                    throw ExceptionsHelper.convertToRuntime(e);
        return newShard(
    }
        );
        try {
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> indexReaderWrapper,
                (repId) -> targetService.getMergedSegmentReplicationRef(repId),  
        // add node id as name to settings for proper logging  
import org.opensearch.index.engine.EngineTestCase;
            shardId,
            indexMetadata,
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000))  
            targetService = getSegmentReplicationTargetService(transportService, indicesService, clusterService, sourceFactory);
            new DummyShardLock(shardId),
        IndexShard replica,
            currentClusterStateVersion.incrementAndGet(),
import org.apache.lucene.store.Directory;
     * current node id the shard is assigned to.
        repository.updateState(clusterService.state());
    protected IndexShard newShard(final boolean primary, final Settings settings) throws IOException {  
        Consumer<IndexShard> postGetFilesRunnable  
    protected IndexShard newShard(  
        );  
    ) throws IOException {  
        @Nullable CheckedFunction<IndexSettings, Store, IOException> storeProvider,  
        boolean primary,  
            null,  
        }  
     * @param routing       the shard routing to use for the newly created shard.
     */  
import org.opensearch.index.engine.Engine;
        );  
     *
            listeners
     *
            null,
import org.opensearch.index.VersionType;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository)
            newRoutingTable,  
     * @param getTargetFunc - provides replication target from target service using replication id
        }  
     * @param settings the settings to use for this shard
            pNode = IndexShardTestUtils.getFakeRemoteEnabledNode(primary.routingEntry().currentNodeId());
        }  
     *
                SequenceNumbers.UNASSIGNED_SEQ_NO,
            directory,  
        shard.markAsRecovering("from snapshot", new RecoveryState(shardRouting, node, null));
            shardPath,
        }  
import static org.mockito.ArgumentMatchers.anyInt;  
                }  
            replica.getPendingPrimaryTerm() + 1,
 */  
     * @param globalCheckpointSyncer callback for syncing global checkpoints  
     * @param routing                shard routing to use  
     * @param indexerFactory the indexer factory for the new shard
            result = shard.applyIndexOperationOnReplica(
        final Version version = Version.CURRENT;
                        Version.CURRENT
        @Nullable IndexerFactory indexerFactory,
     * @param listeners                     an optional set of listeners to add to the shard  
            }  
        }
import org.opensearch.cluster.node.DiscoveryNodeRole;
            recoveryTarget,
import org.opensearch.index.engine.DocIdSeqNoAndSource;  
import org.opensearch.action.index.IndexRequest;
    public static boolean recoverFromStore(IndexShard newShard) {  
            retentionLeaseSyncer,
            final SegmentReplicationTargetService targetService = prepareForReplication(primaryShard, replica);  
            routingEntry,  
     *
                mergedSegmentPublisher,  
import org.opensearch.common.CheckedFunction;
            null,  
        recoverySettings.setChunkSize(new ByteSizeValue(fileChunkSizeInBytes));
     *
            throw e;
        final ShardId shardId = routing.shardId();
    /**
                    target.writeFileChunk(md, pos, new BytesArray(buffer), pos + length == md.length(), 0, mock(ActionListener.class));
    protected void assertDocs(IndexShard shard, String... ids) throws IOException {  
            listeners
                    );
                .shardGenerations()
 * Licensed to Elasticsearch under one or more contributor  
        return Settings.EMPTY;
     * Creates a new empty shard with the specified settings and engine factory and starts it.
    }  
            clusterService.close();
            replica.routingEntry().moveToStarted(),  
        Runnable globalCheckpointSyncer,
    }
     *                             which are desired right after files are copied. e.g. To work with temp files
    private void writeFileChunks(AbstractSegmentReplicationTarget target, IndexShard primary, StoreFileMetadata[] files)
        final boolean markAsRecovering,
     */
        failOnShardFailures();
        IndexShard target,
     * @param primary indicates whether to a primary shard (ready to recover from an empty store) or a replica
        ClusterService clusterService
    protected ThreadPool threadPool;
            }
     *
        final DiscoveryNode rNode;
                Version.CURRENT,
            startReplicaAfterRecovery(replica, primary, inSyncIds, routingTable);
        boolean startReplica,
        ClusterService clusterService,
            ),
            );
    public static final IndexEventListener EMPTY_EVENT_LISTENER = new IndexEventListener() {  
        return new SegmentReplicationTargetService.SegmentReplicationListener() {
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))  
 * under the License.  
        indexShard.acquirePrimaryOperationPermit(fut, ThreadPool.Names.WRITE, "");
            when(sourceFactory.get(any())).thenReturn(replicationSource);  
     * @param primary indicates whether to a primary shard (ready to recover from an empty store) or a replica (ready to recover from  
    ) throws IOException {  
        if (replica.isRemoteTranslogEnabled()) {
                translogFactorySupplier,
            ActionListener<List<BlobMetadata>> listener = invocation.getArgument(3);
        );  
    public final void recoverUnstartedReplica(
import org.apache.lucene.store.IOContext;
        RetentionLeaseSyncer retentionLeaseSyncer,
            null,
        Settings nodeSettings = Settings.builder().put("node.name", routing.currentNodeId()).build();
                    shard.shardId,
            xContentRegistry(),
        boolean primary,  
            sourceFactory = mock(SegmentReplicationSourceFactory.class);
            primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE
    protected IndexShard newShard(
            try (IndexInput in = primary.store().directory().openInput(md.name(), IOContext.READONCE)) {
                    primaryShard.updateVisibleCheckpointForShard(  
import org.opensearch.indices.replication.GetSegmentFilesResponse;  
    }  
import org.opensearch.common.blobstore.BlobStore;
                int pos = 0;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        assertEquals(shard.snapshotStoreMetadata().size(), lastSnapshotStatus.getTotalFileCount());
    protected IndexShard newStartedShard() throws IOException {  
        String nodeId,
        MergedSegmentPublisher mergedSegmentPublisher,  
                Versions.MATCH_ANY,
        Function<Long, ReplicationCollection.ReplicationRef<MergedSegmentReplicationTarget>> getMergedSegmentTargetFunc,
            ShardRoutingState.INITIALIZING,
            routing,
import org.opensearch.ExceptionsHelper;
        InterruptedException {
    public static Indexer getIndexer(IndexShard indexShard) {
    ) {
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
            indexMetadata,  
/*  
            indexMetadata,  
import org.opensearch.snapshots.Snapshot;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.index.engine.InternalEngineFactory;  
            recoverySettings,
import org.opensearch.indices.replication.common.ReplicationFailedException;
    protected BlobContainer getBlobContainer(Path f) throws IOException {  
import org.opensearch.cluster.routing.TestShardRouting;  
     *  
        );  
                Collections.emptyMap(),
     * @param primary indicates whether to a primary shard (ready to recover from an empty store) or a replica
     *
            startingSeqNo  
                remoteStoreStatsTrackerFactory.afterIndexShardCreated(indexShard);
            ) {  
/*
                recoverySettings,
    }  
    protected RepositoriesService createRepositoriesService() {
            indexSettings,
                false,
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(  
     * Note: this method keeps the shard in {@link IndexShardState#POST_RECOVERY} and doesn't start it.  
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();  
        @Nullable EngineConfigFactory engineConfigFactory,  
     * creates a new empty shard and starts it.
     * Segment Replication specific test method - Replicate merged segments to a list of replicas from a given primary.  
        }).when(blobContainer)
            indexId
import java.util.ArrayList;
     */
    protected Releasable acquirePrimaryOperationPermitBlockingly(IndexShard indexShard) throws ExecutionException, InterruptedException {
    }
import org.opensearch.cluster.metadata.RepositoryMetadata;  
        Path path,
                long replicationId,
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;
        final boolean markAsStarted,
        final Settings settings,  
            );
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        return newStartedShard(primary, Settings.EMPTY, new EngineBackedIndexerFactory(new InternalEngineFactory()));  
    }
            .addShard(routingEntry)  
    /**
                        primaryShard.getLatestReplicationCheckpoint()
    }
import org.opensearch.indices.recovery.AsyncRecoveryTarget;
    protected IndexShard newShard(
        }
    protected Store createStore(ShardId shardId, IndexSettings indexSettings, Directory directory, ShardPath shardPath) throws IOException {
                    IndexFileNames.parseSegmentName(replicationCheckpoint.getMetadataMap().keySet().stream().toList().getFirst())
            null,
            indexerFactory,
    protected IndexShard reinitShard(IndexShard current, ShardRouting routing, IndexingOperationListener... listeners) throws IOException {  
                    replicationCheckpoint.getShardId(),
    private SegmentReplicationTargetService getSegmentReplicationTargetService(
            indexReaderWrapper,  
                postGetFilesRunnable.accept(indexShard);
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
     * @param routing       shard routing to use
        final Store store = storeProvider.apply(indexSettings);
                try {  
        );
            repositoryMetadata,
            closeShards(primary);
        } else {  
    /**  
    protected Engine.IndexResult indexDoc(IndexShard shard, String id, String source, MediaType mediaType, String routing)
        assertThat(inSyncIds, contains(replica.routingEntry().allocationId().getId()));
     * @return Return SegmentReplicationSource  
            repository.snapshotShard(
        }
            newRoutingTable,
        MergedSegmentPublisher mergedSegmentPublisher,
                );
        } catch (Exception e) {  
            UUIDs.randomBase64UUID(),
import org.opensearch.index.store.Store;
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
            replica.getPendingPrimaryTerm(),
import org.opensearch.indices.recovery.RecoverySourceHandlerFactory;  
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;  
     *
import org.opensearch.indices.replication.SegmentReplicationTargetService;  
    /**
        return reinitShard(current, routing, null, listeners);
            ShardRoutingState.INITIALIZING,
            );
                clusterSettings  
    protected void updateMappings(IndexShard shard, IndexMetadata indexMetadata) {
    protected void closeShards(IndexShard... shards) throws IOException {
            success = true;  
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.indices.replication.MergedSegmentReplicationTarget;
 * license agreements. See the NOTICE file distributed with
     *
        }
                    listener.onResponse(
            .updateIndexMetadata(
    protected void assertDocCount(IndexShard shard, int docDount) throws IOException {
     * can call this method to ignore those failures
     *                      another shard)
     */
        primary.updateShardState(  
     * promotes a replica to primary, incrementing it's term and starting it if needed
            final BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier = (settings, shardRouting) -> {
     * @param indexMetadata the index metadata to use for the newly created shard
     */  
        SourceToParse sourceToParse = new SourceToParse(shard.shardId().getIndexName(), id, new BytesArray(source), mediaType, routing);
            remoteStoreLockManager,
     * @param shardFunction shard factory function
            public void getMergedSegmentFiles(
        return newShard(shardRouting, Settings.EMPTY, new EngineBackedIndexerFactory(new InternalEngineFactory()), listeners);
        return newShard(
import org.opensearch.index.engine.NRTReplicationEngineFactory;  
    /**  
        Runnable globalCheckpointSyncer,
                        buildNewFakeTransportAddress(),
    protected Store createRemoteStore(Path path, ShardRouting shardRouting, IndexMetadata metadata, ShardPath shardPath)  
import java.util.Collections;
        try {  
    }
        return newShard(primary, checkpointPublisher, settings);
        Path path,
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
     * Creates a new initializing shard. The shard will have its own unique data path.  
                BiConsumer<String, Long> fileProgressTracker,  
            );  
            listeners
                    replicationCheckpoint.getLength(),
    }  
     * @param routing                shard routing to use  
    }
    /**
            engineConfigFactory,  
                        new RemoteTranslogTransferTracker(shardRouting.shardId(), 20),
                breakerService,
    public void tearDown() throws Exception {
    protected IndexShard newShard(boolean primary, SegmentReplicationCheckpointPublisher checkpointPublisher, Settings settings)  
                        .build()  
     * @param indexMetadata                 indexMetadata for the shard, including any mapping
        for (IndexShard replica : replicaShards) {
     * @param primary controls whether the shard will be a primary or a replica.  
        IndexingOperationListener... listeners
                (repId) -> targetService.get(repId),
import org.opensearch.common.lucene.uid.Versions;
        primary.markAsRecovering(  
     * @param indicesService {@link IndicesService} - The indices service to be used on target  
    }
                .build()  
                shard.mapperService(),
        IndexShard shard = shardFunction.apply(primary);  
import org.opensearch.common.concurrent.GatedCloseable;
        } else {  
        if (markAsStarted) {  
                        settings.getRemoteStoreTranslogRepository(),  
        return newShard(routing, indexMetadata, indexReaderWrapper, indexerFactory, () -> {}, RetentionLeaseSyncer.EMPTY, null, listeners);  
    /**
            };
     * Creates a new empty shard and starts it. The shard will randomly be a replica or a primary.
        final Set<String> inSyncIds = Collections.singleton(primary.routingEntry().allocationId().getId());  
                        replicaShard.routingEntry().allocationId().getId(),
    /**
            current,
 * ownership. Elasticsearch licenses this file to you under  
            .build();
        );
        return result;
        IndexerFactory indexerFactory,  
            }  
                VersionType.INTERNAL,  
    public SegmentReplicationSource getSegmentReplicationSource(
     * @param targetSupplier         supplies an instance of {@link RecoveryTarget}
            shardRouting,
     * @param shardPath                     path to use for shard data  
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;  
            shard.sync(); // advance local checkpoint  
        IndicesService indicesService,  
                "dummy-node",  
        Runnable globalCheckpointSyncer,
                indexReaderWrapper,
        ShardRouting routing,
        final BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier,
    /**
        updateRoutingEntry(primary, ShardRoutingHelper.moveToStarted(primary.routingEntry()));
import org.opensearch.index.similarity.SimilarityService;
import org.opensearch.repositories.Repository;
            node.getId(),
     * Hook for tests on the blob store that backs a remote-store shard's segment and translog repository. The default
import static org.hamcrest.Matchers.contains;
        EngineConfigFactory engineConfigFactory,  
            );  
        return newStartedShard(p -> newShard(p, settings, indexerFactory), primary);
        final long startingSeqNo = indexShard.recoverLocallyAndFetchStartSeqNo(!remoteTranslogEnabled);
        // Get primary metadata to verify with replica's, used to ensure replica catches up
        IndexMetadata indexMetadata,
        for (IndexShard shard : shards) {
    ) {
                    replicationCheckpoint.getMetadataMap(),  
            request,
                } else if (remotePath == null) {  
        final RecoverySourceHandler recovery = RecoverySourceHandlerFactory.create(
            routing,  
            RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory = null;  
            new HashMap<>()
     * @param settings      the settings to use for this shard
        countDownLatch.await(30, TimeUnit.SECONDS);  
            globalCheckpointSyncer,  
    private SegmentReplicationTargetService prepareForReplication(  
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000))  
                sourceToParse,
        );  
        IndexShard indexShard = recoveryTarget.indexShard();
            IOUtils.close(() -> shard.close("test", false, false), shard.store());
        IndexMetadata indexMetadata,
                    );  
        recoverReplica(replica, primary, targetSupplier, markAsRecovering, markAsStarted, (a) -> null);
            listeners
                } catch (IOException e) {
            .build();
        );
        @Override
        final IndexShard replica,  
        IndexingOperationListener... listeners
                    listener.onFailure(e);  
     * @param storeProvider                 an optional custom store provider to use. If null a default file based store will be created
            Function<ShardId, ReplicationStats> mockReplicationStatsProvider = mock(Function.class);  
            @Override
        // To simulate that the node is remote backed  
        }
            ShardRoutingState.INITIALIZING,
    protected IndexShard reinitShard(IndexShard current, Path remotePath, IndexingOperationListener... listeners) throws IOException {
import java.util.function.BiConsumer;
     */
            new EngineConfigFactory(new IndexSettings(indexMetadata, indexMetadata.getSettings())),
        IndexMetadata indexMetadata,
     * Helper method to access (package-protected) engine from tests.
            randomAlphaOfLength(5),  
    }  
                shardRouting.primary() ? RecoverySource.ExistingStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE
            result = shard.applyIndexOperationOnPrimary(
        @Nullable Path remotePath,  
            storeProvider = is -> createStore(is, shardPath);
        );  
import java.util.stream.Collectors;
        return new RemoteSegmentStoreDirectory(
 * this work for additional information regarding copyright
    /**  
            inSyncIds,  
            .listBlobsByPrefixInSortedOrder(  
        indexer.ensureOpen();
            recoverySettings  
import org.opensearch.indices.recovery.RecoveryState;
     * creates a new initializing shard. The shard will be put in its proper path under the  
                snapshotStatus,  
                .build();
        assertEquals("Replication should complete successfully", 0, countDownLatch.getCount());
     * Takes an existing shard, closes it and starts a new initialing shard at the same location
                mockReplicationStatsProvider,
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(
                .addShard(replica.routingEntry())
        IndexMetadata indexMetadata,
                    byte[] buffer = new byte[length];
        primary.updateShardState(
 * the Apache License, Version 2.0 (the "License"); you may
        Settings indexSettings = Settings.builder()
            @Override
        }
    }
        ShardRouting initializingReplicaRouting = replica.routingEntry();  
                .add(  
        Map<String, StoreFileMetadata> primaryMetadata,
     * @param indexMetadata          indexMetadata for the shard, including any mapping
        final Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction
        return newShard(
    }  
import org.opensearch.indices.replication.common.ReplicationState;
import org.apache.lucene.index.IndexCommit;
    }  
     * @return Returns SegmentReplicationTargetService.SegmentReplicationListener  
                        .putMapping(result.getRequiredMappingUpdate().toString())
            shard.updateLocalCheckpointForShard(shard.routingEntry().allocationId().getId(), shard.getLocalCheckpoint());
        return newShard(shardRouting, Settings.EMPTY, listeners);  
    }
     * get_files calls.
        RemoteStoreLockManager remoteStoreLockManager = new RemoteStoreMetadataLockManager(
            threadPool,
        final IndexShardSnapshotStatus snapshotStatus = IndexShardSnapshotStatus.newInitializing(  
    }  
        final IndexingOperationListener... listeners
                while (pos < md.length()) {  
                postGetFilesRunnable.accept(indexShard);
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
        final BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier,  
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;  
import org.opensearch.core.action.ActionListener;
        RetentionLeaseSyncer retentionLeaseSyncer,  
     * @param shardPath                     path to use for shard data
        SegmentReplicationTargetService targetService;
        );  
        final NodeEnvironment.NodePath nodePath = new NodeEnvironment.NodePath(createTempDir());
            inSyncIds,  
                        shardRouting.currentNodeId(),
        if (storeProvider == null) {
        if (shard.routingEntry().primary()) {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            mock(TransportService.class),
                } finally {  
package org.opensearch.index.shard;
        // Apply state once to initialize repo properly like RepositoriesService would
            ? new IndexShardRoutingTable.Builder(routingTable).removeShard(primary.routingEntry()).addShard(replica.routingEntry()).build()
    }
import org.opensearch.common.util.io.IOUtils;  
            final SegmentInfos primarySegmentInfos = segmentInfosSnapshot.get();
            .build();
            DefaultRecoverySettings.INSTANCE,
        }  
            return null;
            final Engine.Warmer warmer = createTestWarmer(indexSettings);
     * creates a new initializing shard. The shard will be put in its proper path under the
        ShardPath shardPath = new ShardPath(false, nodePath.resolve(shardId), nodePath.resolve(shardId), shardId);  
            }
    ) {
            new ShardId("index", "_na_", 0),
    }  
import org.opensearch.index.store.RemoteDirectory;
import static org.mockito.Mockito.doAnswer;
        try {
            if (result.getResultType() == Engine.Result.Type.MAPPING_UPDATE_REQUIRED) {  
                .put(Environment.PATH_HOME_SETTING.getKey(), home.toAbsolutePath())
    protected long primaryTerm;
    ) throws IOException {  
            primary.isRemoteTranslogEnabled()  
        return prepareForReplication(
     * @param primaryShard Primary IndexShard - source of segment replication
     * @return Returns SegmentReplicationTargetService.SegmentReplicationListener
    protected IndexShard newShard(ShardRouting shardRouting, final IndexingOperationListener... listeners) throws IOException {
        Set<String> inSyncIds = shardRouting.active() ? Collections.singleton(shardRouting.allocationId().getId()) : Collections.emptySet();
     * @param mergedSegmentPublisher merged segment publisher  
        IndexShard target,
            (indexShard) -> {}
     * by default, tests will fail if any shard created by this class fails. Tests that cause failures by design  
        newShard.recoverFromStore(future);
            primary,  
                Settings.EMPTY,
    }
     * @param storeProvider                 an optional custom store provider to use. If null a default file based store will be created
            result = shard.applyDeleteOperationOnPrimary(  
     * @param routing                       shard routing to use
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
     * current node id the shard is assigned to.
        final BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier,
        ShardRouting routing,  
                }
    /**  
            recoveryTarget.markAsDone();
                any(String.class),
     * been configured to return the given primaryShard's current segments. In order to do so, it mimics the replication
            when(indicesService.getShardOrNull(any())).thenReturn(target);
            .putMapping("{ \"properties\": {} }");  
        );
        clusterService.addStateApplier(event -> repository.updateState(event.state()));  
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> indexReaderWrapper,  
            listener.onResponse(new ArrayList<>());  
    protected void recoverReplica(
            .primaryTerm(0, primaryTerm)
                        RemoteStoreUtils.isServerSideEncryptionEnabledIndex(settings.getIndexMetadata())  
        Indexer indexer = getIndexer(shard);  
            shardId,
                }
        // Latch to block test execution until replica catches up
        return new TestThreadPool(getClass().getName(), threadPoolSettings());  
        final CountDownLatch countDownLatch = new CountDownLatch(replicaShards.size());  
    protected IndexShard newStartedShard(final boolean primary, final Settings settings, final IndexerFactory indexerFactory)
    public Function<List<IndexShard>, List<SegmentReplicationTarget>> getReplicationFunc(final IndexShard target) {
        return indexShard;  
    };
                try (final GatedCloseable<SegmentInfos> snapshot = replicaShard.getSegmentInfosSnapshot()) {
            path,  
     * @param shardId the shard id to use  
                    shard,  
    /**
    }  
        ShardId shardId = shardRouting.shardId();  
            newRoutingTable,
import java.util.function.BiFunction;
        return indexDoc(shard, type, id, "{}");
    }
        return reinitShard(
                    EngineTestCase.assertAtMostOneLuceneDocumentPerSequenceNumber(indexSettings, reader);  
                    logger.error("Unexpected error computing CopyState", e);
    }  
        when(repositoriesService.repository(any(String.class))).thenReturn(repository);
            replica.routingEntry().currentNodeId(),
import org.opensearch.common.lease.Releasable;
        @Nullable IndexerFactory indexerFactory,
            CircuitBreakerService breakerService = new HierarchyCircuitBreakerService(  
                    return new RemoteBlobStoreInternalTranslogFactory(  
import static org.mockito.Mockito.when;  
    protected final List<SegmentReplicationTarget> replicateSegments(IndexShard primaryShard, List<IndexShard> replicaShards)
        IndexMetadata indexMetadata,
            : null;  
     * @param primaryShard {@link IndexShard} - The primary shard to replicate from.
            : RecoverySource.PeerRecoverySource.INSTANCE;  
        DiscoveryNodes discoveryNodes = IndexShardTestUtils.getFakeDiscoveryNodes(routing);
    protected final void replicateMergedSegments(IndexShard primaryShard, List<IndexShard> replicaShards) throws IOException,  
                shard.getOperationPrimaryTerm(),
        );  
            dataDirectory,
     * creates a new initializing shard. The shard will be put in its proper path under the
import org.opensearch.common.blobstore.BlobMetadata;  
     * target is to assert things in the various stages of recovery.
        return indexDoc(shard, id, source, MediaTypeRegistry.JSON, null);
    protected void failOnShardFailures() {
        TransportService transportService,
            : randomIntBetween(1, 10 * 1024 * 1024);
            ? engineBackedIndexer.getEngine()
    ) {
        return newShard(
        ShardId shardId,
        return newShard(shardRouting, settings, indexerFactory);
import org.opensearch.cluster.node.DiscoveryNodes;  
import org.opensearch.indices.recovery.DefaultRecoverySettings;  
        CountDownLatch latch  
    }
            shardId,
    }  
            public void onReplicationDone(SegmentReplicationState state) {
        when(repository.blobStore()).thenReturn(blobStore);
import org.opensearch.index.store.StoreFileMetadata;
            EMPTY_EVENT_LISTENER,  
        ShardPath remoteShardPath = new ShardPath(false, remoteNodePath.resolve(shardId), remoteNodePath.resolve(shardId), shardId);
    public static void assertConsistentHistoryBetweenTranslogAndLucene(IndexShard shard) throws IOException {  
        shard.updateShardState(
        failOnShardFailures.set(true);  
                    final Map<String, StoreFileMetadata> replicaMetadata = replicaShard.store().getSegmentMetadataMap(replicaInfos);
                () -> null,
            new FsDirectoryFactory()
        IndexShardRoutingTable routingTable
                .put("node.name", routing.currentNodeId())  
import org.opensearch.indices.recovery.RecoveryTarget;
        );
                EngineTestCase.assertAtMostOneLuceneDocumentPerSequenceNumber(engine);
        final IndexShard replica,
                IndexMetadata.builder(indexMetadata).putMapping(new MappingMetadata(shard.mapperService().documentMapper())).build()
import org.apache.lucene.index.SegmentInfos;  
        if (replica.routingEntry().isRelocationTarget() == false) {  
import org.opensearch.indices.replication.common.CopyState;  
            );
                )  
     * @param routing                       shard routing to use
    }  
import org.opensearch.repositories.fs.FsRepository;  
            @Override  
     * @param clusterService {@link ClusterService} - The cluster service to be used on target
                    final ReplicationCollection.ReplicationRef<MergedSegmentReplicationTarget> replicationRef = getMergedSegmentTargetFunc
                ReplicationCheckpoint checkpoint,  
                    )
            // This is needed for force segment sync call. Remote store uses a different recovery mechanism
        final RecoverySource recoverySource = primary
import org.opensearch.common.settings.Settings;
    }
            replica,  
            final Engine engine = shard.getIndexerOrNull() instanceof EngineBackedIndexer engineBackedIndexer
            protected BlobStore createBlobStore() throws Exception {
        inSyncIdsWithReplica.add(replica.routingEntry().allocationId().getId());
    }
        final FsRepository repository = new FsRepository(
                ? engineBackedIndexer.getEngine()
    private BlobStoreRepository createRepository(Path path) {  
                List<StoreFileMetadata> filesToFetch,
import org.opensearch.cluster.metadata.IndexMetadata;
            Settings.builder()  
        Map<String, StoreFileMetadata> primaryMetadata;
     * @param current The current shard to reinit
            globalCheckpointSyncer,  
        );
            primary,
                : IndexShardTestUtils.getFakeDiscoveryNodes(routingTable.shards())  
        ShardPath shardPath,
    }
                logger.error("Unexpected replication failure in test", e);
     * creates a new initializing shard. The shard will have its own unique data path.
        BlobPath blobPath = new BlobPath();
    }
            }  
            current,
                xContentRegistry(),  
    /** recovers a replica from the given primary **/
        return newShard(shardId, primary, nodeId, indexMetadata, readerWrapper, () -> {});
            }
import java.util.concurrent.TimeUnit;
            indexReaderWrapper,  
            primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE
            Store.OnClose.EMPTY,
     * @param primaryShard - {@link IndexShard} The current primary shard.  
import org.opensearch.index.remote.RemoteStoreUtils;
                }  
     */
        Engine.IndexResult result;
                }  
        return result;
            remotePath,
    }
     * Get listener on started merged segment replication event which verifies replica shard store with primary's after completion
                .put("node.attr.remote_store.translog.repository", "seg_repo")
            ) {
import org.opensearch.common.blobstore.fs.FsBlobStore;
            tearDownThreadPool();  
            public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
     * Creates a new initializing shard. The shard will have its own unique data path.
        if (failOnShardFailures.get()) {
    ) throws IOException {
            primary.routingEntry(),
                when(mockRepoSvc.repository(any())).thenAnswer(invocationOnMock -> repo);
    public static ReplicationTracker getReplicationTracker(IndexShard indexShard) {  
    /**  
        if (engine != null) {
    protected void promoteReplica(IndexShard replica, Set<String> inSyncIds, IndexShardRoutingTable routingTable) throws IOException {  
     */
 * Modifications Copyright OpenSearch Contributors. See  
    /** Recover a shard from a snapshot using a given repository **/  
                remoteStore = null;
        throws IOException {
                long replicationId,  
    }
        return newStartedShard(randomBoolean(), settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));  
        final ShardRouting shardRouting,
            result = shard.applyDeleteOperationOnReplica(seqNo, shard.getOperationPrimaryTerm(), 0L, id, null);
        ShardRouting shardRouting = TestShardRouting.newShardRouting(  
                    remotePath = createTempDir();
     */
            new AsyncRecoveryTarget(recoveryTarget, threadPool.generic(), primary, replica, replicatePrimaryFunction),
    }
    }
    }  
                closeShard(shard, true);  
        };
     * @param globalCheckpointSyncer callback for syncing global checkpoints  
            path,
import org.opensearch.action.support.replication.TransportReplicationAction;  
        return EngineTestCase.getDocIds(((EngineBackedIndexer) shard.getIndexer()).getEngine(), true);
                    "Mappings are not available on the replica yet, triggered update: " + result.getRequiredMappingUpdate()  
     */
        @Nullable IndexerFactory indexerFactory,
     * @param listeners new listerns to use for the newly created shard
import java.io.IOException;  
    }  
     * @param indexReaderWrapper            an optional wrapper to be used during search
import org.opensearch.repositories.blobstore.OpenSearchBlobStoreRepositoryIntegTestCase;
            current.shardPath(),
import java.util.concurrent.atomic.AtomicBoolean;
            final SegmentReplicationTargetService targetService = prepareForReplication(primaryShard, replica);
        );
import static org.hamcrest.Matchers.equalTo;  
            ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * @param primaryMetadata - primary shard metadata before start of segment replication
            @Override
        // Latch to block test execution until replica catches up  
    protected void recoverReplica(
        );  
    /**
                    int length = between(1, Math.toIntExact(md.length() - pos));
            shard.advanceMaxSeqNoOfUpdatesOrDeletes(seqNo); // manually replicate max_seq_no_of_updates  
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                    latch.countDown();
     * current node id the shard is assigned to.
import org.opensearch.cluster.routing.RecoverySource;
                    new DiscoveryNode(
        return ids;
        final PlainActionFuture<String> future = PlainActionFuture.newFuture();
        return indexShard.getIndexer();
    }
     *
     * This test will use a real {@link SegmentReplicationTarget} for each replica with a mock {@link SegmentReplicationSource} that
import org.apache.lucene.store.IndexInput;  
                    assertTrue(recoveryDiff.different.isEmpty());
                throw new RuntimeException(e);
        return newStartedShard(randomBoolean());
        }
     * @param shardRouting  the {@link ShardRouting} to use for this shard
        }  
                BigArrays.NON_RECYCLING_INSTANCE,
     */
                    assertTrue(recoveryDiff.missing.isEmpty());  
        );
     */
                .put(Environment.PATH_REPO_SETTING.getKey(), path.toAbsolutePath())
            clusterService
                } catch (IOException e) {
            }  
        try (GatedCloseable<IndexCommit> wrappedIndexCommit = shard.acquireLastIndexCommit(true)) {
            primary,  
            }
    public static Translog getTranslog(IndexShard shard) {
     * @param markAsRecovering       set to {@code false} if the replica is marked as recovering
        return fut.get();
     * creates a new initializing shard. The shard will be put in its proper path under the  
import org.opensearch.index.translog.InternalTranslogManager;  
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
    /**
        Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction  
            randomAlphaOfLength(10),
        if (primaryShard.indexSettings.isRemoteStoreEnabled() || primaryShard.indexSettings.isAssignedOnRemoteNode()) {
            : "only InternalEngines or NRTReplicationEngines have translogs, got: " + engine.getClass();  
    }  
        } finally {
            ShardRoutingHelper.initWithSameId(  
                wrappedIndexCommit.get(),
import org.opensearch.indices.IndicesService;  
            indexReaderWrapper,
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
        ShardRouting routing,  
    }
     * @param checkpointPublisher               Segment Replication Checkpoint Publisher to publish checkpoint
     * Snapshot a shard using a given repository.
            clusterService,
     */
     */  
                Collections.emptyList(),
import java.util.Arrays;  
    ) {
    @Override
            try {  
                remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, indexSettings.getSettings());  
     * @param listeners              an optional set of listeners to add to the shard
    ) throws IOException {  
     */
            (is, listener) -> listener.onResponse(
        );
        throws IOException, InterruptedException {
                    listener.onFailure(e);  
                    remotePath = PathUtils.get(remoteStoreRepository.replace("__test", ""));
        return newShard(primary, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
     * @param primaryMetadata - primary shard metadata before start of segment replication
                        DefaultRemoteStoreSettings.INSTANCE,
        return shardGen;
            shard.advanceMaxSeqNoOfUpdatesOrDeletes(seqNo); // manually replicate max_seq_no_of_updates
    }  
    protected IndexShard newShard(boolean primary, SegmentReplicationCheckpointPublisher checkpointPublisher) throws IOException {
        final Set<String> inSyncIds,  
     * been configured to return the given primaryShard's current segments.  
        if (shard.routingEntry().primary()) {
import org.opensearch.cluster.routing.ShardRoutingHelper;
    /**
    }
     *                             which are desired right after files are copied. e.g. To work with temp files  
     * @param settings      the settings to use for this shard  
    }
            readerWrapper,
    protected BlobStore wrapRemoteStoreBlobStore(BlobStore blobStore) {
/*
            retentionLeaseSyncer,
                any(ActionListener.class)
import org.opensearch.index.engine.InternalEngine;
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
            engineConfigFactory,
        }
                        DiscoveryNodeRole.BUILT_IN_ROLES,  
        ShardId shardId,
            return;
            recoveryEmptyReplica(shard, true);
        final Index index = shard.shardId().getIndex();
                    throw ExceptionsHelper.convertToRuntime(e);  
            newRoutingTable.addShard(replica.routingEntry());
import org.opensearch.indices.recovery.RecoverySettings;
                null // TODO  
            } else {  
            null,
            throw new AssertionError(e);  
                snapshot.getSnapshotId(),
                replica,  
            new RecoveryState(primary.routingEntry(), IndexShardTestUtils.getFakeDiscoNode(primary.routingEntry().currentNodeId()), null)
        @Nullable CheckedFunction<IndexSettings, Store, IOException> storeProvider,  
        return target.indexSettings().isSegRepEnabledOrRemoteNode() ? (shardList) -> {
    /**
    }
            shardGen = future.actionGet();  
        repository.restoreShard(shard.store(), snapshot.getSnapshotId(), indexId, shard.shardId(), shard.recoveryState(), future);  
                    replicationCheckpoint.getPrimaryTerm(),
     * @param shardId the shard id to use  
                );
        }
public abstract class IndexShardTestCase extends OpenSearchTestCase {
            current.getRetentionLeaseSyncer(),
            shardId,
     * @param replicaShard - target of segment replication
     * @param path                   remote path
        List<SegmentReplicationTarget> ids = new ArrayList<>();
                    writeFileChunks(replicationRef.get(), primaryShard, filesToFetch.toArray(new StoreFileMetadata[] {}));
 * specific language governing permissions and limitations
                indexSettings.getSettings(),
     * creates a new initializing shard.  
     */
import org.opensearch.repositories.IndexId;  
import org.opensearch.index.translog.TranslogManager;
                nodeSettings,
     */
import org.opensearch.indices.replication.common.ReplicationListener;  
                        new CheckpointInfoResponse(copyState.getCheckpoint(), copyState.getMetadataMap(), copyState.getInfosBytes())
     * @param getMergedSegmentTargetFunc - provides merged segment replication target from target service using replication id  
            final SegmentReplicationSource replicationSource = getSegmentReplicationSource(  
        final IndexShardRoutingTable routingTable = newRoutingTable.build();
    }
    ) throws IOException {
            newRoutingTable,
        return createStore(shardId, new IndexSettings(metadata, nodeSettings), remoteSegmentStoreDirectory, shardPath);
        final boolean markAsStarted
    }  
    /**
        TranslogManager translogManager = indexer.translogManager();
     *  
        };
            replicatePrimaryFunction
 * containing utilities for shard creation and recoveries. See {{@link #newShard(boolean)}} and
        PlainActionFuture<Releasable> fut = new PlainActionFuture<>();  
            @Override
     */
     * Get listener on started segment replication event which verifies replica shard store with primary's after completion
import java.util.concurrent.CountDownLatch;
                VersionType.INTERNAL,
    }
        super.setUp();
                .build();
import org.opensearch.core.xcontent.MediaType;
        RemoteDirectory metadataDirectory = newRemoteDirectory(remoteShardPath.resolveIndex().resolve("metadata"));  
        } else {
            ShardRoutingState.STARTED,
                new Object(),
                ActionListener<GetSegmentFilesResponse> listener
 * Unless required by applicable law or agreed to in writing,
                replica,
                    Set<String> replicaFiles = Arrays.stream(replicaShard.store().directory().listAll()).collect(Collectors.toSet());  
    }  
     * @param primary                the recovery source shard  
    protected Engine.IndexResult indexDoc(IndexShard shard, String type, String id, String source) throws IOException {
            if (assertConsistencyBetweenTranslogAndLucene) {
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));  
import org.opensearch.indices.replication.SegmentReplicationTarget;
            );
import static org.hamcrest.Matchers.hasSize;
        threadPool = setUpThreadPool();
    protected Engine.DeleteResult deleteDoc(IndexShard shard, String id) throws IOException {  
    }
     *  
            if (indexSettings.isRemoteStoreEnabled() || indexSettings.isAssignedOnRemoteNode()) {  
        when(repository.basePath()).thenReturn(new BlobPath());
            assertEquals(replica.state(), IndexShardState.RECOVERING);
            nodeSettings = Settings.builder()
        IndexShardRoutingTable.Builder newRoutingTable = new IndexShardRoutingTable.Builder(replica.shardId());
            primary.getPendingPrimaryTerm(),
        return prepareForReplication(primaryShard, target, transportService, indicesService, clusterService, (indexShard) -> {});  
        IndexShard primaryShard,  
import org.opensearch.common.settings.ClusterSettings;  
            final long seqNo = shard.seqNoStats().getMaxSeqNo() + 1;  
                IOUtils.close(store);  
                false,  
        ReplicationCheckpoint replicationCheckpoint = primaryShard.getLatestReplicationCheckpoint();
                }
    ) {
        final IndexShardRoutingTable routingTable,
            rNode = IndexShardTestUtils.getFakeDiscoNode(replica.routingEntry().currentNodeId());
            .settings(indexSettings)
                new PrimaryReplicaSyncer.ResyncTask(1, "type", "action", "desc", null, Collections.emptyMap())  
import org.opensearch.common.io.PathUtils;  
import org.opensearch.common.UUIDs;
            current.indexerFactory,
            RetentionLeaseSyncer.EMPTY,
    protected IndexShard newStartedShard(final boolean primary, Settings settings) throws IOException {  
    };
            final long seqNo = shard.seqNoStats().getMaxSeqNo() + 1;
            rNode,
import org.opensearch.repositories.RepositoriesService;
    }  
import org.opensearch.index.engine.exec.IndexerFactory;  
import org.opensearch.threadpool.TestThreadPool;
            );
    }
     * writes all segments directly to the target.
            current.engineConfigFactory,
        flushShard(shard, false);
        }
    public final SegmentReplicationTargetService prepareForReplication(
     *  
     */
        final IndexShard primary,
                indexSettings,
            @Override
        IndexMetadata.Builder metadata = IndexMetadata.builder(shardRouting.getIndexName())  
        return newShard(shardRouting, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()), listeners);
        throws IOException {
                Assert.fail("test replication should not fail: " + e);  
 * SPDX-License-Identifier: Apache-2.0
            inSyncIds,
        } else {
                null,
        } finally {
        BlobStoreRepository repository = Mockito.mock(BlobStoreRepository.class);  
    ) throws IOException {  
            currentClusterStateVersion.incrementAndGet(),
                if (remoteStoreRepository != null && remoteStoreRepository.endsWith("__test")) {
import org.opensearch.cluster.metadata.MappingMetadata;
            remotePath,
 * {@link #newStartedShard()} for a good starting points
        // update both primary and replica shard state
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
    private static final Consumer<IndexShard.ShardFailure> DEFAULT_SHARD_FAILURE_HANDLER = failure -> {
     */
import java.nio.file.Path;
            shardRouting,  
            future.actionGet();
        return shard;
    }
     * @param listeners              an optional set of listeners to add to the shard
     * Creates a new initializing shard. The shard will have its own unique data path.  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.indices.recovery.RecoveryResponse;  
import org.opensearch.threadpool.ThreadPool;
        return newShard(
        boolean remoteTranslogEnabled = recoveryTarget.state().getPrimary() == false && indexShard.isRemoteTranslogEnabled();  
                indexEventListener,
     * Creates a new empty shard and starts it.
            if (randomBoolean()) {
 * GitHub history for details.
        assert shardRouting.initializing() : shardRouting;
        final boolean markAsRecovering,  
                IndexShard indexShard,  
        IndexingOperationListener... listeners
        ) {
            SegmentReplicationCheckpointPublisher.EMPTY,  
        return newStartedShard(primary, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
                ReplicationCheckpoint checkpoint,  
            // This is fine since we are not testing the node stats now
                    assertEquals(recoveryDiff.identical.size(), primaryMetadata.size());
 */
    protected IndexShard newShard(  
    /**
    }
        assertThat(getShardDocUIDs(shard), hasSize(docDount));  
    }
    }
            RepositoriesService mockRepoSvc = mock(RepositoriesService.class);
            primary.routingEntry(),  
                        Collections.emptyMap(),
            routing,
                        shardRouting.currentNodeId(),  
        try {
     * creates a new initializing shard. The shard will be put in its proper path under the  
            sourceFactory,  
                ) {  
                shardRouting,
     * @param globalCheckpointSyncer        callback for syncing global checkpoints
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        if (indexMetadata.getSettings().get(IndexMetadata.SETTING_REMOTE_STORE_ENABLED) == "true") {
        Settings nodeSettings = Settings.builder().put("node.name", shardRouting.currentNodeId()).build();
            recoveryTarget.fail(new RecoveryFailedException(request, e), false);
            shard.sync(); // advance local checkpoint
        Function<Long, ReplicationCollection.ReplicationRef<SegmentReplicationTarget>> getTargetFunc,
 * KIND, either express or implied.  See the License for the
    protected void recoverReplica(IndexShard replica, IndexShard primary, boolean startReplica) throws IOException {  
 * A base class for unit tests that need to create and shutdown {@link IndexShard} instances easily,  
        Runnable globalCheckpointSyncer
    protected void recoverShardFromStore(IndexShard primary) throws IOException {
import org.opensearch.action.admin.indices.flush.FlushRequest;  
    protected IndexShard newShard(ShardRouting shardRouting, final Settings settings, final IndexingOperationListener... listeners)  
        ShardPath shardPath = new ShardPath(false, nodePath.resolve(shardId), nodePath.resolve(shardId), shardId);
                Versions.MATCH_ANY,
            }
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
     * returns the store unchanged; a test overrides it to interpose, for instance to hold a download until released.  
            recoverShardFromStore(shard);
            indexShard = new IndexShard(
    ) throws IOException {
import org.mockito.Mockito;
    protected void flushShard(IndexShard shard) {
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
            listeners
            );
     * @return Returns SegmentReplicationTargetService
                    writeFileChunks(replicationRef.get(), primaryShard, filesToFetch.toArray(new StoreFileMetadata[] {}));
     * @param replicaShards - Replicas that will be updated.
                ? IndexShardTestUtils.getFakeRemoteEnabledDiscoveryNodes(routingTable.getShards())
    protected IndexShard reinitShard(IndexShard current, IndexingOperationListener... listeners) throws IOException {  
            indexEventListener,
            shardId,  
    ) throws IOException {
            settings,
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
import org.junit.Assert;
    protected void recoverShardFromSnapshot(final IndexShard shard, final Snapshot snapshot, final Repository repository) {
            );
        Indexer indexer = indexShard.getIndexer();  
        return repository;
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
        future.actionGet();
     * @param remotePath                    remote path
                store,  
    protected void closeShard(IndexShard shard, boolean assertConsistencyBetweenTranslogAndLucene) throws IOException {
        final Set<String> shardDocUIDs = getShardDocUIDs(shard);
            throw new AssertionError(failure.reason, failure.cause);  
     * Segment Replication specific test method - Creates a {@link SegmentReplicationTargetService} to perform replications that has
            DefaultRecoverySettings.INSTANCE,
 */  
        );  
     * source (to avoid transport calls) and simply copies over the segment files from primary store to replica's as part of  
import org.opensearch.index.translog.InternalTranslogFactory;
            replica.routingEntry().shardId(),  
import org.opensearch.index.translog.RemoteBlobStoreInternalTranslogFactory;
    }
            metadata,
            shardPath,  
import org.opensearch.index.replication.TestReplicationSource;  
                try {
        shard.indexSettings()  
        return TestEnvironment.newEnvironment(
import org.opensearch.core.index.shard.ShardId;
import java.util.concurrent.atomic.AtomicLong;  
        final String shardGen;  
import java.util.UUID;
    }  
            final SegmentReplicationTarget target = targetService.startReplication(
     * This test will use a real {@link SegmentReplicationTarget} for each replica with a mock {@link SegmentReplicationSource} that
        IndexShardRoutingTable newRoutingTable = initializingReplicaRouting.isRelocationTarget()
import org.opensearch.indices.recovery.RecoveryFailedException;
        if (indexer instanceof EngineBackedIndexer engineBackedIndexer) {
        } finally {
                mapperService,  
                new MergedSegmentWarmerFactory(null, new RecoverySettings(nodeSettings, clusterSettings), clusterService),  
     * @param settings      the settings to use for this shard  
     * creates a new initializing shard. The shard will be put in its proper path under the
import org.opensearch.index.seqno.ReplicationTracker;
            IndexShardTestUtils.getFakeDiscoveryNodes(routingEntry)
    protected String snapshotShard(final IndexShard shard, final Snapshot snapshot, final Repository repository) throws IOException {  
                        threadPool,
            ids.add(target);
        );  
        IndexShard primary,
import org.opensearch.env.TestEnvironment;
    protected IndexShard newShard(ShardId shardId, boolean primary, IndexingOperationListener... listeners) throws IOException {  
                    IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                );
            ? RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING.getDefault(Settings.EMPTY).getBytes()  
            (r, sourceNode) -> new RecoveryTarget(r, sourceNode, recoveryListener, threadPool),
            new RemoteBufferedOutputDirectory(getBlobContainer(remoteShardPath.resolveIndex().resolve("lock_files")))
            public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {  
        @Nullable IndexerFactory indexerFactory,
     */
        assert translogManager instanceof InternalTranslogManager : "only InternalTranslogManager have translogs, got: "  
        primaryTerm = randomIntBetween(1, 100); // use random but fixed term for creating shards  
    /**  
        final RecoverySource.SnapshotRecoverySource recoverySource = new RecoverySource.SnapshotRecoverySource(  
    protected IndexShard newShard(
                remoteStoreStatsTrackerFactory,
import java.util.function.Consumer;  
import static org.mockito.Mockito.mock;
     *
     * @param target {@link IndexShard} - The target replica shard.  
                Assert.fail("test replication should not fail: " + e);
        closeShards(current);
    }  
        return newShard(primary, Settings.EMPTY);  
            );
        throws IOException {  
        final IndexId indexId = new IndexId(shardId.getIndex().getName(), shardId.getIndex().getUUID());
    }  
        RecoverySettings recoverySettings,
                any(BlobContainer.BlobNameSortOrder.class),  
            primaryMetadata = primaryShard.store().getSegmentMetadataMap(primarySegmentInfos);  
    }
     * @param routing   the shard routing to use for the newly created shard.  
    protected IndexShard newStartedShard(Settings settings) throws IOException {
            indexerFactory,
     * creates a new initializing shard. The shard will be put in its proper path under the
            null,  
    }
import java.util.HashSet;  
                globalCheckpointSyncer,
                SequenceNumbers.UNASSIGNED_SEQ_NO,
        return createStore(shardPath.getShardId(), indexSettings, newFSDirectory(shardPath.resolveIndex()), shardPath);
    }
    }
            shardId,
                    Assert.fail("Failed to compute copyState");  
    }
        final DiscoveryNode node = IndexShardTestUtils.getFakeDiscoNode(shard.routingEntry().currentNodeId());
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> indexReaderWrapper,
            .put("indices.recovery.max_concurrent_operations", Integer.toString(between(1, 4)))
                threadPool,  
            primary,
                try (  
import org.opensearch.index.IndexSettings;  
     * @param primary controls whether the shard will be a primary or a replica.  
            nodeId,
        clusterService = createClusterService(threadPool);
            null,
            primary,
 * You may obtain a copy of the License at  
        } : (a) -> null;
/**
     * @param indexEventListener            index event listener
        final IndexShardSnapshotStatus.Copy lastSnapshotStatus = snapshotStatus.asCopy();  
    private RecoveryTarget recoveryTarget;
            randomAlphaOfLength(10),  
        Path remotePath,
            indexMetadata,
        }  
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;  
            ? RecoverySource.EmptyStoreRecoverySource.INSTANCE
     * @param replicaShards - Replicas that will be updated.
                : IndexShardTestUtils.getFakeDiscoveryNodes(routingTable.getShards())
                }
    }  
            createEnvironment(path),  
    protected IndexShard newStartedShard(CheckedFunction<Boolean, IndexShard, IOException> shardFunction, boolean primary)
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> indexReaderWrapper,  
            .put("indices.recovery.max_concurrent_file_chunks", Integer.toString(between(1, 4)))  
    /**
                UUID.randomUUID().toString(),  
                result = shard.applyIndexOperationOnPrimary(
 *
                Collections.emptyList(),  
import org.opensearch.core.index.Index;
        };
            routing,
     * Creates a new initializing shard. The shard will have its own unique data path.
            primary = newStartedShard(true, replica.indexSettings.getSettings());
    protected void flushShard(IndexShard shard, boolean force) {
        return reinitShard(  
            MergedSegmentPublisher.EMPTY,
        public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
                    final ReplicationCollection.ReplicationRef<SegmentReplicationTarget> replicationRef = getTargetFunc.apply(replicationId)
            inSyncIdsWithReplica,
        IndexEventListener indexEventListener,  
import org.opensearch.common.blobstore.BlobPath;
        IndexingOperationListener... listeners
                anyInt(),
            if (success == false) {
            mock(IndicesService.class),
        Runnable globalCheckpointSyncer,
        if (markAsRecovering) {
            inSyncIdsWithReplica,
                logger.error("Unexpected replication failure in test", e);
            ShardRoutingState.INITIALIZING,
}
        IndexerFactory indexerFactory,
     * @param indexMetadata          indexMetadata for the shard, including any mapping
        return blobStore;  
 *
        BlobStore blobStore = Mockito.mock(BlobStore.class);
        );
import org.opensearch.common.Nullable;  
            : new IndexShardRoutingTable.Builder(routingTable).removeShard(initializingReplicaRouting)  
            currentClusterStateVersion.get(),  
        repository.start();  
            .put(settings)
                ReplicationCheckpoint checkpoint,
    /**
        recoverReplica(
    /**  
        ShardRouting routing,  
     * @param primary       indicates whether to a primary shard (ready to recover from an empty store) or a replica (ready to recover from
                getTargetListener(primaryShard, replica, primaryMetadata, countDownLatch)
        ShardPath shardPath,
                future,  
import org.opensearch.env.NodeEnvironment;
     * Utility method which creates a segment replication source, which copies files from primary shard to target shard  
     */
        final ShardId shardId = new ShardId("index", "_na_", 0);
        Set<String> inSyncIdsWithReplica = new HashSet<>(inSyncIds);  
     * Segment Replication specific test method - Creates a {@link SegmentReplicationTargetService} to perform replications that has
        IndexShard primaryShard,  
    }  
        }
        RetentionLeaseSyncer retentionLeaseSyncer,  
            globalCheckpointSyncer,  
 */
            primaryShard,
     */
                ) {  
     * @param transportService {@link TransportService} - Transport service to be used on target
        );  
            primary,  
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
 * not use this file except in compliance with the License.
                createTempDir(),
            recoverySource  
    protected Engine.IndexResult indexDoc(IndexShard shard, String type, String id) throws IOException {  
        recoverReplica(replica, primary, startReplica, getReplicationFunc(replica));
        SegmentReplicationSourceFactory sourceFactory = null;  
                checkpointPublisher,  
     */  
            shardRouting,
    };
     */  
        try (final GatedCloseable<SegmentInfos> segmentInfosSnapshot = primaryShard.getSegmentInfosSnapshot()) {  
            DiscoveryNodes.builder()
    /**
                routing,  
    protected IndexShard newShard(
        final ClusterService clusterService = BlobStoreTestUtil.mockClusterService(repositoryMetadata);  
        IndexMetadata indexMetadata,
                engineConfigFactory,  
    protected IndexShard newShard(
     * @param recoverySettings       recovery settings
    }  
                    final Store.RecoveryDiff recoveryDiff = Store.segmentReplicationDiff(primaryMetadata, replicaMetadata);
            @Override  
            shard.getPendingPrimaryTerm(),  
        RecoverySettings recoverySettings,
                    // necessary to obtain the entire file list through listAll().
                    IndexMetadata.builder(shard.indexSettings().getIndexMetadata())
                long replicationId,
        long fileChunkSizeInBytes = randomBoolean()
                .build()
            }
        }  
    /**  
            startReplica,
            ) {
     * @param target {@link IndexShard} - The source primary shard in segment replication.
            EMPTY_EVENT_LISTENER,  
                .getShardGen(indexId, shard.shardId().getId())  
     * @param primaryShard - {@link IndexShard} The current primary shard.  
                // since we can't get remote path from IndexShard directly, we are using repository to store it .  
            }
        try (final GatedCloseable<SegmentInfos> segmentInfosSnapshot = primaryShard.getSegmentInfosSnapshot()) {
import java.util.function.Function;
            PlainActionFuture<RecoveryResponse> future = new PlainActionFuture<>();
     *  
                    final SegmentInfos replicaInfos = snapshot.get();  
                remoteStore = createRemoteStore(remotePath, routing, indexMetadata, shardPath);
                } finally {
import org.opensearch.index.store.FsDirectoryFactory;  
        final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
                0  
     * @param remotePath Remote path to recover from if remote storage is used
                false,
            listeners
            Store remoteStore;
                throw new TransportReplicationAction.RetryOnReplicaException(
import org.opensearch.indices.replication.SegmentReplicationState;
        CountDownLatch latch
        IndexShard primary,
import org.opensearch.cluster.routing.ShardRouting;  
                }
import org.opensearch.common.blobstore.fs.FsBlobContainer;  
            ),  
import org.opensearch.index.engine.exec.Indexer;
     * @param listeners     new listerns to use for the newly created shard  
                DefaultRemoteStoreSettings.INSTANCE,
        }  
        Set<String> inSyncIds,  
import java.util.concurrent.ExecutionException;  
        InternalTranslogManager internalTranslogManager = (InternalTranslogManager) translogManager;
                    VersionType.INTERNAL,
        } else {
import org.opensearch.index.seqno.RetentionLeaseSyncer;
                IndexShard indexShard,
     * @param indexerFactory the indexer factory to use for this shard  
            current.getGlobalCheckpointSyncer(),
     */  
        IndexShard primaryShard,
                return replicateSegments(primary, shardList.subList(1, shardList.size()));  
        }  
        final IndexShard primary,
    }  
     *
 * The OpenSearch Contributors require contributions made to  
                shard.store(),  
                Collections.emptyMap(),
     */
        );  
     * @param postGetFilesRunnable - Consumer which is executed after file copy operation. This can be used to stub operations
            remotePath,
        if (shard.state() != IndexShardState.POST_RECOVERY && shard.state() != IndexShardState.STARTED) {
            logger,  
    public static void updateRoutingEntry(IndexShard shard, ShardRouting shardRouting) throws IOException {
        shard.mapperService().merge(indexMetadata, MapperService.MergeReason.MAPPING_UPDATE);
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        assertEquals(IndexShardSnapshotStatus.Stage.DONE, lastSnapshotStatus.getStage());
        replica.updateShardState(
     * @param primaryShard - source of segment replication
     * @param indexMetadata indexMetadata for the shard, including any mapping
                    in.readBytes(buffer, 0, length);  
    }
import org.opensearch.core.common.unit.ByteSizeValue;  
            SegmentReplicationCheckpointPublisher.EMPTY,  
                        () -> mockRepoSvc,
     */
            }
        return reinitShard(current, (Path) null, listeners);
        assertNull(lastSnapshotStatus.getFailure());  
        final IndexShardRoutingTable newRoutingTable = new IndexShardRoutingTable.Builder(routingTable).removeShard(replica.routingEntry())
                    false  
        return targetService;
        }
        failOnShardFailures.set(false);
     * @param recoverySettings              recovery settings  
import org.opensearch.Version;
            shard.updateLocalCheckpointForShard(shard.routingEntry().allocationId().getId(), shard.getLocalCheckpoint());  
     * @param indexerFactory the indexer factory to use for this shard
        Engine engine = getEngine(shard);
        throws IOException {
import org.opensearch.index.engine.NRTReplicationEngine;
        RecoverySettings recoverySettings = new RecoverySettings(  
                remoteStore,
        Path home = createTempDir();
                indexId,  
                }
        final ShardRouting shardRouting = current.routingEntry();  
        );  
    /**  
    }
        TransportService transportService,  
                ActionListener<GetSegmentFilesResponse> listener
                    pos += length;
            currentClusterStateVersion.incrementAndGet(),
        final NodeEnvironment.NodePath nodePath = new NodeEnvironment.NodePath(createTempDir());
                try (final CopyState copyState = new CopyState(primaryShard)) {  
     *                another shard)  
            targetService.startMergedSegmentReplication(
import org.opensearch.common.blobstore.BlobContainer;
    }
    }
        return new SegmentReplicationTargetService.SegmentReplicationListener() {  
    }
    protected void startReplicaAfterRecovery(  
        return new RemoteDirectory(getBlobContainer(f));  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        if (primary) {
import org.opensearch.env.Environment;  
     * @param listeners                     an optional set of listeners to add to the shard  
     * @param indexReaderWrapper            an optional wrapper to be used during search  
            ShardRoutingState.INITIALIZING,
import org.opensearch.indices.recovery.RecoverySourceHandler;
        String nodeId,
        IndexShardRoutingTable newRoutingTable = new IndexShardRoutingTable.Builder(shardRouting.shardId()).addShard(shardRouting).build();  
                seqNo,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
    public static Engine getEngine(IndexShard indexShard) {
        for (StoreFileMetadata md : files) {  
            when(mockReplicationStatsProvider.apply(any())).thenReturn(new ReplicationStats(800, 800, 500));
        } else {
    protected void tearDownThreadPool() {
        final Engine.DeleteResult result;
            replica.routingEntry().allocationId()
    /**
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);  
                    // After the pre-copy merged segment is completed, the merged segment is not yet visible in the replica shard, so it is
        try {  
    /**  
            version,  
        return new TestReplicationSource() {
        ShardRouting routing,  
            mapperService.merge(indexMetadata, MapperService.MergeReason.MAPPING_RECOVERY);
            public void onReplicationDone(SegmentReplicationState state) {
                0,  
        newRoutingTable.addShard(primary.routingEntry());
        IndexShard replicaShard,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    ) throws IOException {
     *                another shard)
     * @param primary       controls whether the shard will be a primary or a replica.
                    replicationCheckpoint.getCodec(),
            }
                    SequenceNumbers.UNASSIGNED_SEQ_NO,  
        final IndexShard primary,  
import java.util.Set;  
        } finally {
            }
                // eliminate thread name check as we create repo manually
    public Settings threadPoolSettings() {  
            .build();
        IndexMetadata indexMetadata,
                try (
import org.opensearch.index.translog.Translog;
    protected ThreadPool setUpThreadPool() {
        RemoteDirectory dataDirectory = newRemoteDirectory(remoteShardPath.resolveIndex().resolve("data"));
                } catch (Exception e) {
    }
    /**
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()),
 * compatible open source license.
        IndicesService indicesService,
            super.tearDown();  
     */
    }
    protected ClusterService clusterService;  
     * @param globalCheckpointSyncer        callback for syncing global checkpoints  
            if (shard != null) {
            () -> {},
     * Returns null if the indexer is not engine-backed (e.g., DataFormatAwareEngine).  
            pNode = IndexShardTestUtils.getFakeDiscoNode(primary.routingEntry().currentNodeId());  
        assertThat(shardDocUIDs, hasSize(ids.length));  
                ReferencedSegmentsPublisher.EMPTY,
    ) throws IOException {  
            .put(settings)
            .settings(indexSettings)
     * @param mergedSegmentPublisher        merged segment publisher
        final RecoveryTarget recoveryTarget = targetSupplier.apply(replica, pNode);
                        .apply(replicationId)
    protected IndexShard newShard(
            threadPool,  
            snapshot,
            }
    /**
        }  
            }
        IndexShard current,
        IndexMetadata indexMetadata,
        IndexingOperationListener... listeners
        Settings settings = Settings.builder().put("location", path).build();
import static org.mockito.ArgumentMatchers.any;
    public static Set<String> getShardDocUIDs(final IndexShard shard) throws IOException {  
     * supplied node id.
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));  
            recovery.recoverToTarget(future);  
    }
            return engineBackedIndexer.getEngine();
        assertThat(shardDocUIDs, contains(ids));
        final Engine engine = shard.getIndexerOrNull() instanceof EngineBackedIndexer engineBackedIndexer
                retentionLeaseSyncer,  
            MergedSegmentPublisher.EMPTY,  
        return new FsBlobContainer(fsBlobStore, blobPath, f);  
        return newShard(
     * @return {@link List} List of target components orchestrating replication.
import org.opensearch.index.store.lockmanager.RemoteStoreMetadataLockManager;
     * @param indexReaderWrapper     an optional wrapper to be used during search
     *  
     * @param shardId   the shard id to use
    protected IndexShard newStartedShard(final boolean primary) throws IOException {
            rNode = IndexShardTestUtils.getFakeRemoteEnabledNode(replica.routingEntry().currentNodeId());  
import org.opensearch.indices.replication.common.ReplicationType;
                similarityService,
    }
        final IndexShard indexShard;  
            sourceFactory = new SegmentReplicationSourceFactory(transportService, recoverySettings, clusterService);
        NodeEnvironment.NodePath remoteNodePath = new NodeEnvironment.NodePath(path);  
        RetentionLeaseSyncer retentionLeaseSyncer,
        return getDocIdAndSeqNos(shard).stream().map(DocIdSeqNoAndSource::getId).collect(Collectors.toSet());
     * @param primaryShard - source of segment replication  
        if (primary.isRemoteTranslogEnabled()) {  
        }  
        return reader -> {
            RecoverySettings recoverySettings = new RecoverySettings(  
 *  
            + engine.getClass();
        throws IOException {
        assert engine instanceof InternalEngine || engine instanceof NRTReplicationEngine
            null,  
            routingTable,
    public SegmentReplicationTargetService.SegmentReplicationListener getMergedSegmentTargetListener(  
        replica.prepareForIndexRecovery();  
            target,  
            indexMetadata,
            shard.sync(); // advance local checkpoint
            if (result.getResultType() == Engine.Result.Type.MAPPING_UPDATE_REQUIRED) {
    private RemoteDirectory newRemoteDirectory(Path f) throws IOException {
            "store",
import org.opensearch.cluster.routing.ShardRoutingState;
            protected void assertSnapshotOrGenericThread() {  
            checkpointPublisher,
            @Override  
            public void getSegmentFiles(
            discoveryNodes = DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeRemoteEnabledNode(routing.currentNodeId())).build();  
    /**
        public void onDone(ReplicationState state) {  
    protected void closeShards(Iterable<IndexShard> shards) throws IOException {  
     * Takes an existing shard, closes it and starts a new initialing shard at the same location  
     * Recovers a replica from the give primary, allow the user to supply a custom recovery target. A typical usage of a custom recovery  
            transportService,
            indexShard.addShardFailureCallback(DEFAULT_SHARD_FAILURE_HANDLER);
     * @param listeners new listerns to use for the newly created shard  
        }
     * @param primary   indicates whether to a primary shard (ready to recover from an empty store) or a replica
     * @param indexerFactory the indexer factory to use for this shard
                } catch (Exception e) {
        boolean success = false;
                indexerFactory,
     * @param primary indicates whether to a primary shard (ready to recover from an empty store) or a replica (ready to recover from
     * Segment Replication specific test method - Replicate segments to a list of replicas from a given primary.  
        throws IOException {
            public void getCheckpointMetadata(
     * @param replicaShard - target of segment replication  
        IndexShard primary = null;  
        SegmentReplicationSourceFactory sourceFactory  
        );  
    /**  
            if (remoteStoreStatsTrackerFactory != null) {  
            MergedSegmentPublisher.EMPTY
            shard.sync(); // advance local checkpoint
        final DiscoveryNode pNode;
                id,
            recoverySource
        IndicesService indicesService,
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        };
     * @param postGetFilesRunnable - Consumer which is executed after file copy operation. This can be used to stub operations
                () -> Boolean.FALSE,
    /** recovers a replica from the given primary **/
import org.opensearch.cluster.service.ClusterService;
     * @param primaryShard {@link IndexShard} - The target replica shard in segment replication.  
 * this file be licensed under the Apache-2.0 license or a
    }
    }
     * writes all segments directly to the target.
        IndexShard primaryShard,
     * @param listeners     an optional set of listeners to add to the shard  
                Arrays.asList(listeners),
     * @param indexReaderWrapper     an optional wrapper to be used during search
     * @param replica                the recovery target shard
    public static List<DocIdSeqNoAndSource> getDocIdAndSeqNos(final IndexShard shard) throws IOException {
    /**
        final IndexId indexId = new IndexId(index.getName(), index.getUUID());
    }  
     *                (ready to recover from another shard)
                ),
                ? IndexShardTestUtils.getFakeRemoteEnabledDiscoveryNodes(routingTable.shards())
        final Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.indices.replication.CheckpointInfoResponse;
        );
        throws IOException {  
     *                  (ready to recover from another shard)  
    }  
import org.apache.lucene.index.DirectoryReader;  
            current.indexSettings.getIndexMetadata(),  
                List<StoreFileMetadata> filesToFetch,
        FsBlobStore fsBlobStore = new FsBlobStore(1024, f, false);
            indexerFactory,
    }  
import org.opensearch.action.support.PlainActionFuture;
            );  
    @Override  
        final boolean markAsRecovering,
    protected void allowShardFailures() {
                warmer,
    /**
        return new Store(  
     * @param listeners     an optional set of listeners to add to the shard
        @Override
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
import org.opensearch.indices.replication.SegmentReplicationSource;
    public static Engine.Warmer createTestWarmer(IndexSettings indexSettings) {
            targetService = getSegmentReplicationTargetService(transportService, indicesService, clusterService, sourceFactory);
            .build();
                final IndexShard primary = shardList.get(0);
                null
import org.opensearch.indices.replication.common.ReplicationCollection;
            IndexCache indexCache = new IndexCache(indexSettings, new DisabledQueryCache(indexSettings), null);
        );
     * Takes an existing shard, closes it and starts a new initialing shard at the same location
    private static final AtomicBoolean failOnShardFailures = new AtomicBoolean(true);  
        return indexShard.getReplicationTracker();
     * @return new shard generation
    }
import org.opensearch.index.mapper.SourceToParse;
    protected IndexShard newShard(boolean primary, Settings settings, IndexerFactory indexerFactory) throws IOException {  
                } catch (IOException e) {
     * current node id the shard is assigned to.
            remotePath,  
                "index"  
        recoverUnstartedReplica(replica, primary, targetSupplier, markAsRecovering, inSyncIds, routingTable, replicatePrimaryFunction);
        IndexingOperationListener... listeners
import org.opensearch.index.store.RemoteBufferedOutputDirectory;
                    sourceToParse,
                } catch (IOException e) {
        throws IOException {
        @Nullable EngineConfigFactory engineConfigFactory,  
     * current node id the shard is assigned to.  
import org.opensearch.index.seqno.SequenceNumbers;  
                postGetFilesRunnable
                : IndexShardTestUtils.getFakeDiscoveryNodes(routingTable.shards())
        assertEquals("Replication merged segment should complete successfully", 0, countDownLatch.getCount());
        final CountDownLatch countDownLatch = new CountDownLatch(replicaShards.size());
            } catch (IOException | InterruptedException e) {
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> readerWrapper  
import org.opensearch.indices.DefaultRemoteStoreSettings;
     */
    }
                    );  
    public SegmentReplicationTargetService.SegmentReplicationListener getTargetListener(
     *
                String remoteStoreRepository = indexSettings.getRemoteStoreRepository();
            routing,
        Consumer<IndexShard> postGetFilesRunnable  
        SegmentReplicationCheckpointPublisher checkpointPublisher,
import org.opensearch.index.translog.TranslogFactory;  
        ClusterService clusterService,
    protected IndexShard reinitShard(
                new MergedSegmentCheckpoint(  
        closeShards(Arrays.asList(shards));
            assertThat(shard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(shard.seqNoStats().getMaxSeqNo()));  
            EngineTestCase.assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
        IndexEventListener indexEventListener,  
        return null;
            true,  
            @Override  
            mergedSegmentPublisher,  
        Map<String, StoreFileMetadata> primaryMetadata,  
    public void setUp() throws Exception {  
    protected IndexShard reinitShard(IndexShard current, ShardRouting routing, Path remotePath, IndexingOperationListener... listeners)
import org.opensearch.test.DummyShardLock;
                : null;  
        }
            EMPTY_EVENT_LISTENER,
        replica.updateShardState(
            true,  
            indicesService,
            }
                    replicationCheckpoint.getSegmentInfosVersion(),  
        return new SegmentReplicationTargetService(
        final StartRecoveryRequest request = PeerRecoveryTargetService.getStartRecoveryRequest(
    }
     */
                indexSettings::getRefreshInterval,  
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> readerWrapper,  
        IndexShard primaryShard,  
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = createRemoteSegmentStoreDirectory(shardId, path);
import org.opensearch.test.OpenSearchTestCase;  
                getMergedSegmentTargetListener(primaryShard, replica, primaryMetadata, countDownLatch)  
            primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE  
            primary.indexSettings.isRemoteTranslogStoreEnabled()
import org.apache.lucene.index.IndexFileNames;
     * @param indexMetadata                 indexMetadata for the shard, including any mapping  
        );
                false
            indexerFactory,
        }
        final ShardId shardId = shard.shardId();  
import org.opensearch.index.cache.IndexCache;
     * @param settings the settings to use for this shard  
            null,
            metadataDirectory,  
    protected Store createStore(IndexSettings indexSettings, ShardPath shardPath) throws IOException {
    public final SegmentReplicationTargetService prepareForReplication(IndexShard primaryShard, IndexShard target) {  
    protected static AtomicLong currentClusterStateVersion = new AtomicLong();
                    assertTrue(replicaFiles.containsAll(primaryMetadata.keySet()));
        countDownLatch.await(30, TimeUnit.SECONDS);  
                // remote path via setting a repository . This is a hack used for shards are created using reset .
                    latch.countDown();
        return future.actionGet();  
     */  
        Map<String, StoreFileMetadata> primaryMetadata;  
        }  
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(  
    }
                    0,
     * Creates a new empty shard and starts it.
    protected RemoteSegmentStoreDirectory createRemoteSegmentStoreDirectory(ShardId shardId, Path path) throws IOException {
     */
        ShardRouting routing,
    }
    protected static final ReplicationListener recoveryListener = new ReplicationListener() {
                BiConsumer<String, Long> fileProgressTracker,
        }
                    Versions.MATCH_ANY,  
                indexCache,
        for (IndexShard replica : replicaShards) {  
import org.opensearch.index.cache.query.DisabledQueryCache;
                0,  
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
    private Environment createEnvironment(Path path) {  
                ActionListener<CheckpointInfoResponse> listener
 * software distributed under the License is distributed on an
            null,
        final Settings settings = Settings.builder()
            }  
                return wrapRemoteStoreBlobStore(super.createBlobStore());  
            // This isn't a warmer but sometimes verify the content in the reader  
                sourceToParse  
        return newShard(shardRouting, metadata.build(), null, indexerFactory, () -> {}, RetentionLeaseSyncer.EMPTY, null, listeners);
            null
import java.util.HashMap;
    }  
            DefaultRecoverySettings.INSTANCE,
    ) throws IOException {  
            recoverReplica(replica, primary, startReplica);  
import org.opensearch.index.engine.EngineConfigFactory;  
import org.opensearch.indices.replication.AbstractSegmentReplicationTarget;
                null,  
        return repositoriesService;  
            primaryMetadata = primaryShard.store().getSegmentMetadataMap(primarySegmentInfos);
    protected void recoveryEmptyReplica(IndexShard replica, boolean startReplica) throws IOException {
        RepositoriesService repositoriesService = Mockito.mock(RepositoriesService.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            globalCheckpointSyncer,  
            primary.getPendingPrimaryTerm(),
            final SegmentInfos primarySegmentInfos = segmentInfosSnapshot.get();
        final ShardRouting routingEntry = newShardRouting(
     * @param primary controls whether the shard will be a primary or a replica.
     */  
    protected IndexShard newShard(boolean primary) throws IOException {
import org.opensearch.common.util.BigArrays;
    }
import org.opensearch.transport.TransportService;  
        TransportService transportService,  
     * supplied node id.
        final IndexerFactory indexerFactory,
        );
import org.opensearch.indices.recovery.StartRecoveryRequest;  
    ) throws IOException {
            RetentionLeaseSyncer.EMPTY,
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata(randomAlphaOfLength(10), FsRepository.TYPE, settings);
     * @param latch - Latch which allows consumers of this utility to ensure segment replication completed successfully
        // Get primary metadata to verify with replica's, used to ensure replica catches up
     * @return Returns SegmentReplicationTargetService
                primaryShard.getLatestReplicationCheckpoint(),
                discoveryNodes,
                updateMappings(
                primaryShard,
                assert shardList.size() >= 2;
    /**
    protected void recoverReplica(  
            }
     */
import org.opensearch.index.ReplicationStats;
        final IndexShard replica,
     *                (ready to recover from another shard)
import java.util.List;
import org.opensearch.index.engine.EngineBackedIndexer;
            true,  
            MapperService mapperService = MapperTestUtils.newMapperService(
            if (engine != null) {
                    throw new AssertionError(e);
            }
     * @param checkpointPublisher           segment Replication Checkpoint Publisher to publish checkpoint
        );  
            new EngineConfigFactory(new IndexSettings(metadata, metadata.getSettings())),  
                clusterService.getClusterApplierService(),
     * <p>
        IndexShard replica,  
        doAnswer(invocation -> {
     * Creates a new empty shard and starts it
        return internalTranslogManager.getTranslog();  
        final IndexSettings indexSettings = new IndexSettings(indexMetadata, nodeSettings);
            shardPath,  
            replica.markAsRecovering("remote", new RecoveryState(replica.routingEntry(), pNode, rNode));
        BlobContainer blobContainer = Mockito.mock(BlobContainer.class);  
