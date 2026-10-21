            );
            DefaultRecoverySettings.INSTANCE,
import org.apache.lucene.store.IndexInput;
            public void onReplicationDone(SegmentReplicationState state) {
        }
            primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE
    /**
 * A base class for unit tests that need to create and shutdown {@link IndexShard} instances easily,
        );
                any(String.class),
     * returns the store unchanged; a test overrides it to interpose, for instance to hold a download until released.
import org.opensearch.core.index.Index;
import org.opensearch.action.support.PlainActionFuture;
    protected void updateMappings(IndexShard shard, IndexMetadata indexMetadata) {
            ShardRoutingState.STARTED,
    }
import org.opensearch.index.ReplicationStats;
import org.opensearch.index.store.lockmanager.RemoteStoreMetadataLockManager;
    }
                "index"
                .addShard(replica.routingEntry())
    };
        Map<String, StoreFileMetadata> primaryMetadata;
        IndexShard replicaShard,
            );
        );
        final boolean markAsStarted
                }
        );
        for (StoreFileMetadata md : files) {
    /**
        shard.updateShardState(
                    latch.countDown();
        return createStore(shardId, new IndexSettings(metadata, nodeSettings), remoteSegmentStoreDirectory, shardPath);
        }
        IndexingOperationListener... listeners
            ? engineBackedIndexer.getEngine()
    };
            );
            shardRouting,
    }
import org.opensearch.indices.replication.SegmentReplicationTargetService;
    public static Set<String> getShardDocUIDs(final IndexShard shard) throws IOException {
        ShardRouting routing,
        return newShard(shardRouting, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()), listeners);
        IndexEventListener indexEventListener,
        return shard;
            storeProvider = is -> createStore(is, shardPath);
        );
    }
    protected IndexShard newShard(
        return new TestThreadPool(getClass().getName(), threadPoolSettings());
     * @param indexMetadata          indexMetadata for the shard, including any mapping
        return indexDoc(shard, type, id, "{}");
import static org.mockito.ArgumentMatchers.anyInt;
        } else {
import org.apache.lucene.store.IOContext;
        TransportService transportService,
                false,
        throws IOException {
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
            recoverySource
    public static Indexer getIndexer(IndexShard indexShard) {
    public static final IndexEventListener EMPTY_EVENT_LISTENER = new IndexEventListener() {
        );
     *
     * current node id the shard is assigned to.
import java.util.Set;
        );
        inSyncIdsWithReplica.add(replica.routingEntry().allocationId().getId());
            .listBlobsByPrefixInSortedOrder(
        assert engine instanceof InternalEngine || engine instanceof NRTReplicationEngine
    protected IndexShard newStartedShard(Settings settings) throws IOException {
    }
import org.opensearch.index.engine.EngineBackedIndexer;
import static org.mockito.Mockito.mock;
            throw new AssertionError(failure.reason, failure.cause);
            current.indexerFactory,
import org.apache.lucene.index.IndexFileNames;
                );
            final SegmentInfos primarySegmentInfos = segmentInfosSnapshot.get();
     */
            ) {
     * @return Returns SegmentReplicationTargetService
import org.opensearch.indices.replication.MergedSegmentReplicationTarget;
                EngineTestCase.assertAtMostOneLuceneDocumentPerSequenceNumber(engine);
import org.opensearch.index.MapperTestUtils;
                when(mockRepoSvc.repository(any())).thenAnswer(invocationOnMock -> repo);
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
                    final ReplicationCollection.ReplicationRef<SegmentReplicationTarget> replicationRef = getTargetFunc.apply(replicationId)
    protected IndexShard reinitShard(IndexShard current, Path remotePath, IndexingOperationListener... listeners) throws IOException {
            // This is fine since we are not testing the node stats now
        }
            @Override
    }
    protected void failOnShardFailures() {
import org.opensearch.test.OpenSearchTestCase;
        replica.updateShardState(
        Path remotePath,
                }
            mock(TransportService.class),
            recovery.recoverToTarget(future);
            throw e;
     * @param indexEventListener            index event listener
                nodeSettings,
                        replicaShard.routingEntry().allocationId().getId(),
        return newShard(routing, indexMetadata, indexReaderWrapper, indexerFactory, () -> {}, RetentionLeaseSyncer.EMPTY, null, listeners);
        SegmentReplicationSourceFactory sourceFactory = null;
                    EngineTestCase.assertAtMostOneLuceneDocumentPerSequenceNumber(indexSettings, reader);
            .put(settings)
                sourceToParse,
import org.opensearch.indices.replication.common.ReplicationCollection;
import java.util.function.BiFunction;
    protected Engine.DeleteResult deleteDoc(IndexShard shard, String id) throws IOException {
    /** recovers a replica from the given primary **/
        boolean remoteTranslogEnabled = recoveryTarget.state().getPrimary() == false && indexShard.isRemoteTranslogEnabled();
            replica.routingEntry().moveToStarted(),
    /** recovers a replica from the given primary **/
        );
                if (remoteStoreRepository != null && remoteStoreRepository.endsWith("__test")) {
        replica.updateShardState(
        Set<String> inSyncIds,
     *
        threadPool = setUpThreadPool();
    /**
    }
            ShardRoutingState.INITIALIZING,
            @Override
            @Override
                translogFactorySupplier,
    protected void recoverShardFromSnapshot(final IndexShard shard, final Snapshot snapshot, final Repository repository) {
                        shardRouting.currentNodeId(),
        assertThat(inSyncIds, contains(replica.routingEntry().allocationId().getId()));
        IndexShard primary,
        @Override
        boolean primary,
            }
                return replicateSegments(primary, shardList.subList(1, shardList.size()));
        } catch (Exception e) {
    protected void recoverReplica(
     * @param settings      the settings to use for this shard
     * can call this method to ignore those failures
            new EngineConfigFactory(new IndexSettings(metadata, metadata.getSettings())),
        }).when(blobContainer)
    protected void closeShards(IndexShard... shards) throws IOException {
import org.opensearch.common.concurrent.GatedCloseable;
     */
            routing,
                shardRouting,
            }
 * {@link #newStartedShard()} for a good starting points
            if (result.getResultType() == Engine.Result.Type.MAPPING_UPDATE_REQUIRED) {
     * Creates a new empty shard and starts it
                id,
                long replicationId,
     * promotes a replica to primary, incrementing it's term and starting it if needed
        TransportService transportService,
            shardId,
        }
     * @param listeners                     an optional set of listeners to add to the shard
        IndexMetadata indexMetadata,
                shardPath,
            } catch (IOException | InterruptedException e) {
                IOUtils.close(store);
            startReplica,
    protected void closeShards(Iterable<IndexShard> shards) throws IOException {
        IndicesService indicesService,
import org.opensearch.index.translog.Translog;
        Indexer indexer = indexShard.getIndexer();
            sourceFactory = mock(SegmentReplicationSourceFactory.class);
    }
        shard.markAsRecovering("from snapshot", new RecoveryState(shardRouting, node, null));
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
    }
 * specific language governing permissions and limitations
                indexSettings::getRefreshInterval,
     *                             which are desired right after files are copied. e.g. To work with temp files
     *
        Map<String, StoreFileMetadata> primaryMetadata,
     * @param primaryMetadata - primary shard metadata before start of segment replication
import org.opensearch.index.cache.IndexCache;
import org.opensearch.indices.replication.common.CopyState;
     */
        IndexShard primary,
                Collections.emptyMap(),
     * @param primaryShard - source of segment replication
        return reinitShard(
                discoveryNodes,
import org.opensearch.index.engine.exec.Indexer;
                indexerFactory,
        String nodeId,
            .build();
     * target is to assert things in the various stages of recovery.
     * @param primary                the recovery source shard
        Settings indexSettings = Settings.builder()
     * @param storeProvider                 an optional custom store provider to use. If null a default file based store will be created
            primary.getPendingPrimaryTerm(),
    /**
        final IndexShard indexShard;
    }
            Store.OnClose.EMPTY,
                        primaryShard.getLatestReplicationCheckpoint()
        }
        final IndexShard primary,
            discoveryNodes = DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeRemoteEnabledNode(routing.currentNodeId())).build();
        }
        IndexShard replicaShard,
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
            routing,
            current,
import org.opensearch.action.admin.indices.flush.FlushRequest;
                    assertEquals(recoveryDiff.identical.size(), primaryMetadata.size());
        };
        newShard.recoverFromStore(future);
    }
            inSyncIdsWithReplica,
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
            shardId,
        final ShardRouting routingEntry = newShardRouting(
    protected IndexShard newShard(ShardRouting shardRouting, final Settings settings, final IndexingOperationListener... listeners)
        ClusterService clusterService,
                }
            primary,
                () -> null,
            primary.indexSettings.isRemoteTranslogStoreEnabled()
import org.opensearch.indices.recovery.RecoveryResponse;
                if (settings.isRemoteTranslogStoreEnabled() && shardRouting.primary()) {
    }
                checkpointPublisher,
     *
        return targetService;
import java.util.HashSet;
                : IndexShardTestUtils.getFakeDiscoveryNodes(routingTable.getShards())
        try (GatedCloseable<IndexCommit> wrappedIndexCommit = shard.acquireLastIndexCommit(true)) {
            shardId,
    protected IndexShard newShard(boolean primary, SegmentReplicationCheckpointPublisher checkpointPublisher) throws IOException {
    protected long primaryTerm;
import org.opensearch.cluster.metadata.IndexMetadata;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            indexReaderWrapper,
            null,
import org.opensearch.index.store.RemoteDirectory;
            success = true;
     * @param indexMetadata                 indexMetadata for the shard, including any mapping
/*
        assertThat(shardDocUIDs, contains(ids));
     * @param primary indicates whether to a primary shard (ready to recover from an empty store) or a replica
        } else {
    protected void allowShardFailures() {
            RepositoriesService mockRepoSvc = mock(RepositoriesService.class);
                // remote path via setting a repository . This is a hack used for shards are created using reset .
import org.opensearch.cluster.node.DiscoveryNodes;
                    Set<String> replicaFiles = Arrays.stream(replicaShard.store().directory().listAll()).collect(Collectors.toSet());
            targetService = getSegmentReplicationTargetService(transportService, indicesService, clusterService, sourceFactory);
    /**
import org.opensearch.index.cache.query.DisabledQueryCache;
    protected IndexShard newShard(ShardId shardId, boolean primary, IndexingOperationListener... listeners) throws IOException {
    protected static AtomicLong currentClusterStateVersion = new AtomicLong();
     *                  (ready to recover from another shard)
    }
                    replicationCheckpoint.getShardId(),
        NodeEnvironment.NodePath remoteNodePath = new NodeEnvironment.NodePath(path);
        ReplicationCheckpoint replicationCheckpoint = primaryShard.getLatestReplicationCheckpoint();
            OpenSearchBlobStoreRepositoryIntegTestCase.getRepositoryData(repository)
        Runnable globalCheckpointSyncer
            new HashMap<>()
    }
    protected IndexShard newStartedShard(final boolean primary, Settings settings) throws IOException {
import org.opensearch.common.util.BigArrays;
     *                another shard)
     * current node id the shard is assigned to.
 */
import org.opensearch.env.Environment;
        return indexDoc(shard, id, source, MediaTypeRegistry.JSON, null);
            indexId
                Versions.MATCH_ANY,
     * @param shardRouting  the {@link ShardRouting} to use for this shard
            result = shard.applyIndexOperationOnReplica(
    /**
        PlainActionFuture<Releasable> fut = new PlainActionFuture<>();
                indexSettings,
        IndexingOperationListener... listeners
     * Segment Replication specific test method - Creates a {@link SegmentReplicationTargetService} to perform replications that has
        );
            .settings(indexSettings)
     * @param postGetFilesRunnable - Consumer which is executed after file copy operation. This can be used to stub operations
            .primaryTerm(0, primaryTerm)
 *
        clusterService = createClusterService(threadPool);
                recoverySettings,
            }
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
import org.opensearch.indices.replication.common.ReplicationState;
    protected void flushShard(IndexShard shard, boolean force) {
    public static ReplicationTracker getReplicationTracker(IndexShard indexShard) {
        final DiscoveryNode rNode;
     * @param shardPath                     path to use for shard data
                .getShardGen(indexId, shard.shardId().getId())
            new AsyncRecoveryTarget(recoveryTarget, threadPool.generic(), primary, replica, replicatePrimaryFunction),
            indexReaderWrapper,
    }
     * @param latch - Latch which allows consumers of this utility to ensure segment replication completed successfully
     */
    protected ThreadPool threadPool;
            }
        return newShard(
        ShardPath shardPath = new ShardPath(false, nodePath.resolve(shardId), nodePath.resolve(shardId), shardId);
        );
            indexShard = new IndexShard(
     * @param checkpointPublisher           segment Replication Checkpoint Publisher to publish checkpoint
        RemoteDirectory metadataDirectory = newRemoteDirectory(remoteShardPath.resolveIndex().resolve("metadata"));
    }
    }
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
     * by default, tests will fail if any shard created by this class fails. Tests that cause failures by design
        throws IOException, InterruptedException {
            routingEntry,
     */
import org.opensearch.transport.TransportService;
        } finally {
        shard.flush(new FlushRequest(shard.shardId().getIndexName()).force(force));
     */
                .put("node.name", routing.currentNodeId())
        final Set<String> inSyncIds,
        ClusterService clusterService,
import org.opensearch.repositories.fs.FsRepository;
        final PlainActionFuture<String> future = PlainActionFuture.newFuture();
        IndexingOperationListener... listeners
     */
                } finally {
            replicatePrimaryFunction
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.apache.lucene.index.IndexCommit;
                remoteStoreStatsTrackerFactory,
            null,
    /**
     */
        Engine.IndexResult result;
    }
     * writes all segments directly to the target.
    protected ThreadPool setUpThreadPool() {
        throws IOException {
    protected IndexShard reinitShard(IndexShard current, ShardRouting routing, IndexingOperationListener... listeners) throws IOException {
    }
 * GitHub history for details.
        List<SegmentReplicationTarget> ids = new ArrayList<>();
                int pos = 0;
    }
    }
    private void writeFileChunks(AbstractSegmentReplicationTarget target, IndexShard primary, StoreFileMetadata[] files)
            replica.markAsRecovering("remote", new RecoveryState(replica.routingEntry(), pNode, rNode));
                null
        } : (a) -> null;
        final Index index = shard.shardId().getIndex();
            listeners
    /**
    }
    private Environment createEnvironment(Path path) {
    protected IndexShard newShard(ShardRouting shardRouting, final IndexingOperationListener... listeners) throws IOException {
                ? IndexShardTestUtils.getFakeRemoteEnabledDiscoveryNodes(routingTable.getShards())
import java.util.Collections;
            indexMetadata,
        if (markAsStarted) {
        RetentionLeaseSyncer retentionLeaseSyncer,
        Path remotePath,
import org.opensearch.common.util.io.IOUtils;
     * @param recoverySettings              recovery settings
                return wrapRemoteStoreBlobStore(super.createBlobStore());
        }
            shardRouting,
     */
     * @param indexerFactory the indexer factory to use for this shard
     * been configured to return the given primaryShard's current segments. In order to do so, it mimics the replication
            shard.advanceMaxSeqNoOfUpdatesOrDeletes(seqNo); // manually replicate max_seq_no_of_updates
    public SegmentReplicationSource getSegmentReplicationSource(
import org.opensearch.indices.replication.SegmentReplicationTarget;
                ActionListener<GetSegmentFilesResponse> listener
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
        final IndexShardSnapshotStatus.Copy lastSnapshotStatus = snapshotStatus.asCopy();
                } catch (Exception e) {
                    replicationCheckpoint.getMetadataMap(),
            }
    /**
        final IndexShard replica,
        return reinitShard(
            MergedSegmentPublisher.EMPTY,
import org.opensearch.index.engine.exec.IndexerFactory;
     * creates a new initializing shard. The shard will be put in its proper path under the
    }
     *                      another shard)
import org.opensearch.action.index.IndexRequest;
        String nodeId,
        failOnShardFailures();
        }
    }
import static org.hamcrest.Matchers.contains;
        try {
        final ShardId shardId = new ShardId("index", "_na_", 0);
        Settings settings = Settings.builder().put("location", path).build();
            ShardRoutingHelper.initWithSameId(
            shardPath,
        } finally {
                postGetFilesRunnable.accept(indexShard);
import org.opensearch.index.engine.NRTReplicationEngine;
                .put(Environment.PATH_HOME_SETTING.getKey(), home.toAbsolutePath())
                }
                remoteStoreStatsTrackerFactory.afterIndexShardCreated(indexShard);
        repository.updateState(clusterService.state());
     *
            path,
            );
        shard.indexSettings()
import org.opensearch.index.mapper.SourceToParse;
                long replicationId,
                result = shard.applyIndexOperationOnPrimary(
                null,
     * @param listeners              an optional set of listeners to add to the shard
    public static Engine.Warmer createTestWarmer(IndexSettings indexSettings) {
                snapshot.getSnapshotId(),
                Assert.fail("test replication should not fail: " + e);
        return internalTranslogManager.getTranslog();
                mergedSegmentPublisher,
            engineConfigFactory,
                    byte[] buffer = new byte[length];
        if (replica.routingEntry().isRelocationTarget() == false) {
            @Override
    public static boolean recoverFromStore(IndexShard newShard) {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
     * source (to avoid transport calls) and simply copies over the segment files from primary store to replica's as part of
            createEnvironment(path),
                logger.error("Unexpected replication failure in test", e);
        return repositoriesService;
     * Takes an existing shard, closes it and starts a new initialing shard at the same location
    }
    /**
        ShardId shardId,
            ) {
 */
            targetService.startMergedSegmentReplication(
        when(repository.blobStore()).thenReturn(blobStore);
     *
                clusterSettings
    }
                Collections.emptyList(),
     * @param indexReaderWrapper            an optional wrapper to be used during search
        } finally {
        return new TestReplicationSource() {
        final ShardId shardId = shard.shardId();
            current.getGlobalCheckpointSyncer(),
            .put(settings)
        final boolean markAsRecovering,
        // Apply state once to initialize repo properly like RepositoriesService would
        IndexMetadata indexMetadata,
     */
                .shardGenerations()
import org.opensearch.snapshots.Snapshot;
    }
    protected ClusterService clusterService;
        IndexerFactory indexerFactory,
                Arrays.asList(listeners),
import org.apache.lucene.index.DirectoryReader;
    /** Recover a shard from a snapshot using a given repository **/
            public void getSegmentFiles(
     */
     * @param current The current shard to reinit
    ) throws IOException {
        try {
            // This is needed for force segment sync call. Remote store uses a different recovery mechanism
        final IndexShardRoutingTable routingTable,
            .build();
        return new RemoteDirectory(getBlobContainer(f));
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(
     * Hook for tests on the blob store that backs a remote-store shard's segment and translog repository. The default
        throws IOException {
                postGetFilesRunnable
import java.util.function.Function;
        FsBlobStore fsBlobStore = new FsBlobStore(1024, f, false);
     * @param primaryShard {@link IndexShard} - The target replica shard in segment replication.
import org.opensearch.index.replication.TestReplicationSource;
    /**
import org.opensearch.cluster.routing.TestShardRouting;
 * The OpenSearch Contributors require contributions made to
     * current node id the shard is assigned to.
            shard.sync(); // advance local checkpoint
 */
        return newShard(shardId, primary, nodeId, indexMetadata, readerWrapper, () -> {});
     * @param replicaShards - Replicas that will be updated.
                getMergedSegmentTargetListener(primaryShard, replica, primaryMetadata, countDownLatch)
            final long seqNo = shard.seqNoStats().getMaxSeqNo() + 1;
     * @param primaryShard {@link IndexShard} - The primary shard to replicate from.
                    final SegmentInfos replicaInfos = snapshot.get();
        final String shardGen;
        return newStartedShard(randomBoolean());
                assert shardList.size() >= 2;
import org.opensearch.indices.recovery.RecoveryTarget;
        }
                    throw new AssertionError(e);
        CountDownLatch latch
                threadPool,
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
                    0,
    protected String snapshotShard(final IndexShard shard, final Snapshot snapshot, final Repository repository) throws IOException {
    protected IndexShard newShard(
            listeners
                indexEventListener,
            inSyncIdsWithReplica,
        Runnable globalCheckpointSyncer,
     * @param remotePath                    remote path
            newRoutingTable.addShard(replica.routingEntry());
                VersionType.INTERNAL,
        final IndexingOperationListener... listeners
     * Segment Replication specific test method - Creates a {@link SegmentReplicationTargetService} to perform replications that has
            }
    }
        if (indexer instanceof EngineBackedIndexer engineBackedIndexer) {
        // Get primary metadata to verify with replica's, used to ensure replica catches up
            primaryMetadata = primaryShard.store().getSegmentMetadataMap(primarySegmentInfos);
            recoveryEmptyReplica(shard, true);
import org.opensearch.common.blobstore.BlobPath;
import org.apache.lucene.store.Directory;
        throws IOException {
    public SegmentReplicationTargetService.SegmentReplicationListener getTargetListener(
                store,
    public static Engine getEngine(IndexShard indexShard) {
    protected Engine.IndexResult indexDoc(IndexShard shard, String id, String source, MediaType mediaType, String routing)
        } else {
        final CountDownLatch countDownLatch = new CountDownLatch(replicaShards.size());
    }
import java.util.stream.Collectors;
            closeShards(primary);
import org.opensearch.index.translog.InternalTranslogFactory;
     * Get listener on started segment replication event which verifies replica shard store with primary's after completion
    }
        SegmentReplicationCheckpointPublisher checkpointPublisher,
            null,
    /**
            if (shard != null) {
        final IndexShard primary,
import org.opensearch.indices.recovery.RecoverySourceHandler;
        MergedSegmentPublisher mergedSegmentPublisher,
            final long seqNo = shard.seqNoStats().getMaxSeqNo() + 1;
import java.io.IOException;
     * Note: this method keeps the shard in {@link IndexShardState#POST_RECOVERY} and doesn't start it.
            }
        ShardPath shardPath = new ShardPath(false, nodePath.resolve(shardId), nodePath.resolve(shardId), shardId);
            // This isn't a warmer but sometimes verify the content in the reader
import org.opensearch.core.common.unit.ByteSizeValue;
        Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction
            }
            result = shard.applyDeleteOperationOnPrimary(
        return newShard(primary, Settings.EMPTY);
    public static List<DocIdSeqNoAndSource> getDocIdAndSeqNos(final IndexShard shard) throws IOException {
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
                );
    protected void closeShard(IndexShard shard, boolean assertConsistencyBetweenTranslogAndLucene) throws IOException {
     * @param indexEventListener            index event listener
     */
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            remotePath,
                indexId,
            xContentRegistry(),
     * @param primaryShard - source of segment replication
        BlobContainer blobContainer = Mockito.mock(BlobContainer.class);
        return null;
        try {
                retentionLeaseSyncer,
                        threadPool,
            current.indexSettings.getIndexMetadata(),
import org.opensearch.indices.recovery.RecoverySettings;
            indexSettings,
            final Engine engine = shard.getIndexerOrNull() instanceof EngineBackedIndexer engineBackedIndexer
            }
                try (
    protected IndexShard newShard(
     * @param listeners                     an optional set of listeners to add to the shard
                final IndexShard primary = shardList.get(0);
                }
        Consumer<IndexShard> postGetFilesRunnable
                )
     * @param shardId the shard id to use
            newRoutingTable,
 * KIND, either express or implied.  See the License for the
            replica.getPendingPrimaryTerm(),
        if (storeProvider == null) {
            primaryMetadata = primaryShard.store().getSegmentMetadataMap(primarySegmentInfos);
    }
        if (replica.isRemoteTranslogEnabled()) {
     * @param replicaShards - Replicas that will be updated.
     */
                }
    /**
        assertThat(shardDocUIDs, hasSize(ids.length));
            retentionLeaseSyncer,
        IndexShardRoutingTable.Builder newRoutingTable = new IndexShardRoutingTable.Builder(replica.shardId());
import org.opensearch.repositories.IndexId;
            };
 *     http://www.apache.org/licenses/LICENSE-2.0
            null,
        ClusterService clusterService
        );
     */
     * Returns null if the indexer is not engine-backed (e.g., DataFormatAwareEngine).
     * Creates a new empty shard and starts it.
        IndexerFactory indexerFactory,
import org.opensearch.indices.replication.SegmentReplicationSource;
        Settings nodeSettings = Settings.builder().put("node.name", shardRouting.currentNodeId()).build();
                .build()
            indexMetadata,
        Consumer<IndexShard> postGetFilesRunnable
        return future.actionGet();
                Collections.emptyList(),
            RecoverySettings recoverySettings = new RecoverySettings(
        DiscoveryNodes discoveryNodes = IndexShardTestUtils.getFakeDiscoveryNodes(routing);
    @Override
                false
    protected BlobStore wrapRemoteStoreBlobStore(BlobStore blobStore) {
            final BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier = (settings, shardRouting) -> {
    protected Releasable acquirePrimaryOperationPermitBlockingly(IndexShard indexShard) throws ExecutionException, InterruptedException {
     * @param primaryShard Primary IndexShard - source of segment replication
            EMPTY_EVENT_LISTENER,
     * @param replica                the recovery target shard
    protected Store createStore(ShardId shardId, IndexSettings indexSettings, Directory directory, ShardPath shardPath) throws IOException {
     * Recovers a replica from the give primary, allow the user to supply a custom recovery target. A typical usage of a custom recovery
     * @param target {@link IndexShard} - The source primary shard in segment replication.
    /**
    }
                } else if (remotePath == null) {
    ) {
            MergedSegmentPublisher.EMPTY,
    }
import org.opensearch.core.action.ActionListener;
        };
        Runnable globalCheckpointSyncer,
        );
     *
     */
     * @param markAsRecovering       set to {@code false} if the replica is marked as recovering
                indexCache,
     */
                UUID.randomUUID().toString(),
        return newShard(shardRouting, Settings.EMPTY, new EngineBackedIndexerFactory(new InternalEngineFactory()), listeners);
            listeners
     */
    ) throws IOException {
/*
            startingSeqNo
            readerWrapper,
        }
        );
     * Utility method which creates a segment replication source, which copies files from primary shard to target shard
            pNode = IndexShardTestUtils.getFakeRemoteEnabledNode(primary.routingEntry().currentNodeId());
     * @param indicesService {@link IndicesService} - The indices service to be used on target
                primaryShard.getLatestReplicationCheckpoint(),
            sourceFactory = new SegmentReplicationSourceFactory(transportService, recoverySettings, clusterService);
import org.opensearch.cluster.routing.RecoverySource;
     * @param primary controls whether the shard will be a primary or a replica.
            shard.advanceMaxSeqNoOfUpdatesOrDeletes(seqNo); // manually replicate max_seq_no_of_updates
        closeShards(current);
     *
            new RecoveryState(primary.routingEntry(), IndexShardTestUtils.getFakeDiscoNode(primary.routingEntry().currentNodeId()), null)
            SegmentReplicationCheckpointPublisher.EMPTY,
            newRoutingTable,
                seqNo,
        final IndexShard replica,
                        .putMapping(result.getRequiredMappingUpdate().toString())
     */
                SequenceNumbers.UNASSIGNED_SEQ_NO,
import org.opensearch.common.UUIDs;
            currentClusterStateVersion.get(),
    private SegmentReplicationTargetService getSegmentReplicationTargetService(
                0,
                future,
     *
import org.opensearch.common.blobstore.fs.FsBlobStore;
                ? IndexShardTestUtils.getFakeRemoteEnabledDiscoveryNodes(routingTable.shards())
                .add(
            replica.getPendingPrimaryTerm() + 1,
            replica,
import static org.mockito.Mockito.doAnswer;
        recoverReplica(replica, primary, startReplica, getReplicationFunc(replica));
    /**
                (repId) -> targetService.get(repId),
        throws IOException {
            }
            routing,
            }
                }
     * @param storeProvider                 an optional custom store provider to use. If null a default file based store will be created
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000))
/*
        shard.mapperService().merge(indexMetadata, MapperService.MergeReason.MAPPING_UPDATE);
     * creates a new initializing shard. The shard will have its own unique data path.
                    shard,
    public Function<List<IndexShard>, List<SegmentReplicationTarget>> getReplicationFunc(final IndexShard target) {
            indexerFactory,
            repository.snapshotShard(
            primary.routingEntry(),
        IndexShard target,
import static org.hamcrest.Matchers.hasSize;
            primary,
        Settings indexSettings = Settings.builder()
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
        return new SegmentReplicationTargetService(
     * Segment Replication specific test method - Replicate merged segments to a list of replicas from a given primary.
            path,
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    }
            primaryShard,
            .build();
            DiscoveryNodes.builder()
                () -> Boolean.FALSE,
            null,
                    replicationCheckpoint.getLength(),
        return new SegmentReplicationTargetService.SegmentReplicationListener() {
    /**
            retentionLeaseSyncer,
        if (engine != null) {
import org.opensearch.core.common.bytes.BytesArray;
                BiConsumer<String, Long> fileProgressTracker,
    ) {
        };
        for (IndexShard replica : replicaShards) {
            );
            recoverySource
        IndexShardRoutingTable routingTable
                "dummy-node",
     * @param shardPath                     path to use for shard data
        IndexMetadata indexMetadata,
import java.util.UUID;
            ? new IndexShardRoutingTable.Builder(routingTable).removeShard(primary.routingEntry()).addShard(replica.routingEntry()).build()
            if (randomBoolean()) {
            ShardRoutingState.INITIALIZING,
                        .apply(replicationId)
            DefaultRecoverySettings.INSTANCE,
     * @param clusterService {@link ClusterService} - The cluster service to be used on target
     * @param indexReaderWrapper            an optional wrapper to be used during search
    protected BlobContainer getBlobContainer(Path f) throws IOException {
import org.opensearch.indices.recovery.AsyncRecoveryTarget;
                ReplicationCheckpoint checkpoint,
            randomAlphaOfLength(10),
                new MergedSegmentCheckpoint(
            .settings(indexSettings)
            primary.getPendingPrimaryTerm(),
        boolean success = false;
            currentClusterStateVersion.incrementAndGet(),
    /**
            }
import org.opensearch.test.DummyShardLock;
        final IndexShardRoutingTable newRoutingTable = new IndexShardRoutingTable.Builder(routingTable).removeShard(replica.routingEntry())
     * creates a new initializing shard. The shard will be put in its proper path under the
import org.opensearch.indices.recovery.DefaultRecoverySettings;
    protected void recoverReplica(
        @Nullable CheckedFunction<IndexSettings, Store, IOException> storeProvider,
import org.opensearch.repositories.Repository;
                : IndexShardTestUtils.getFakeDiscoveryNodes(routingTable.shards())
            newRoutingTable,
     * @param checkpointPublisher               Segment Replication Checkpoint Publisher to publish checkpoint
     * @param shardId   the shard id to use
import org.opensearch.repositories.blobstore.OpenSearchBlobStoreRepositoryIntegTestCase;
            PlainActionFuture<RecoveryResponse> future = new PlainActionFuture<>();
                .build()
            target,
    protected IndexShard reinitShard(IndexShard current, ShardRouting routing, Path remotePath, IndexingOperationListener... listeners)
import org.opensearch.indices.replication.SegmentReplicationState;
     * @return {@link List} List of target components orchestrating replication.
            indexMetadata,
     * @param routing                       shard routing to use
            .putMapping("{ \"properties\": {} }")
            );
        );
                BigArrays.NON_RECYCLING_INSTANCE,
    protected IndexShard newStartedShard(final boolean primary, final Settings settings, final IndexerFactory indexerFactory)
        countDownLatch.await(30, TimeUnit.SECONDS);
import org.junit.Assert;
        );
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import org.opensearch.cluster.service.ClusterService;
        return getDocIdAndSeqNos(shard).stream().map(DocIdSeqNoAndSource::getId).collect(Collectors.toSet());
            shard.getPendingPrimaryTerm(),
     * been configured to return the given primaryShard's current segments.
    protected void assertDocCount(IndexShard shard, int docDount) throws IOException {
        @Nullable CheckedFunction<IndexSettings, Store, IOException> storeProvider,
        }
 *
    }
    protected IndexShard newShard(
            listeners
    /**
            try (IndexInput in = primary.store().directory().openInput(md.name(), IOContext.READONCE)) {
    }
                    IndexFileNames.parseSegmentName(replicationCheckpoint.getMetadataMap().keySet().stream().toList().getFirst())
            final SegmentReplicationTarget target = targetService.startReplication(
                    SequenceNumbers.UNASSIGNED_SEQ_NO,
            storeProvider,
 * software distributed under the License is distributed on an
        IndexShard target,
        final IndexId indexId = new IndexId(index.getName(), index.getUUID());
                return new InternalTranslogFactory();
import java.util.concurrent.atomic.AtomicBoolean;
     *
     * @return new shard generation
        }
     */
        return TestEnvironment.newEnvironment(
        );
                0
     */
    }
            replica.routingEntry().shardId(),
        final NodeEnvironment.NodePath nodePath = new NodeEnvironment.NodePath(createTempDir());
    }
import org.opensearch.index.engine.InternalEngine;
    protected IndexShard newShard(
            @Override
     * creates a new initializing shard. The shard will be put in its proper path under the
        assertEquals("Replication should complete successfully", 0, countDownLatch.getCount());
        final long startingSeqNo = indexShard.recoverLocallyAndFetchStartSeqNo(!remoteTranslogEnabled);
            new EngineConfigFactory(new IndexSettings(indexMetadata, indexMetadata.getSettings())),
    ) throws IOException {
            new DummyShardLock(shardId),
        final BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier,
    /**
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
    protected IndexShard newShard(final boolean primary, final Settings settings) throws IOException {
                ReferencedSegmentsPublisher.EMPTY,
    ) throws IOException {
import java.nio.file.Path;
            public void getMergedSegmentFiles(
            EMPTY_EVENT_LISTENER,
    private RemoteDirectory newRemoteDirectory(Path f) throws IOException {
    }
        RecoverySettings recoverySettings,
     * @param latch - Latch which allows consumers of this utility to ensure segment replication completed successfully
        return shardGen;
        Runnable globalCheckpointSyncer,
     * creates a new initializing shard. The shard will be put in its proper path under the
        final boolean markAsRecovering,
            .updateIndexMetadata(
    private SegmentReplicationTargetService prepareForReplication(
     * @param transportService {@link TransportService} - Transport service to be used on target
            shardPath,
import org.opensearch.env.NodeEnvironment;
            threadPool,
    protected IndexShard newShard(
        return fut.get();
        // Latch to block test execution until replica catches up
            MergedSegmentPublisher.EMPTY
            result = shard.applyDeleteOperationOnReplica(seqNo, shard.getOperationPrimaryTerm(), 0L, id, null);
            final SegmentReplicationTargetService targetService = prepareForReplication(primaryShard, replica);
import org.opensearch.indices.replication.GetSegmentFilesResponse;
        }
            ),
            recoverySettings
    }
            }
                anyInt(),
    ) {
                postGetFilesRunnable.accept(indexShard);
        assert shardRouting.initializing() : shardRouting;
            remotePath,
        };
     * writes all segments directly to the target.
            primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE
     *
            when(mockReplicationStatsProvider.apply(any())).thenReturn(new ReplicationStats(800, 800, 500));
                IndexShard indexShard,
        assertEquals(IndexShardSnapshotStatus.Stage.DONE, lastSnapshotStatus.getStage());
        repository.restoreShard(shard.store(), snapshot.getSnapshotId(), indexId, shard.shardId(), shard.recoveryState(), future);
        future.actionGet();
import org.opensearch.index.VersionType;
        return newShard(
    /**
            dataDirectory,
import org.opensearch.common.io.PathUtils;
    }
     * Creates a new empty shard and starts it.
     * @param mergedSegmentPublisher merged segment publisher
        if (primary.isRemoteTranslogEnabled()) {
        return new Store(
            new ShardId("index", "_na_", 0),
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), between(0, 1000))
            indexerFactory,
    /**
                mockReplicationStatsProvider,
import org.opensearch.common.blobstore.BlobMetadata;
        return new SegmentReplicationTargetService.SegmentReplicationListener() {
            remoteStoreLockManager,
     * @param primary       indicates whether to a primary shard (ready to recover from an empty store) or a replica (ready to recover from
        IndexShardRoutingTable newRoutingTable = initializingReplicaRouting.isRelocationTarget()
            Function<ShardId, ReplicationStats> mockReplicationStatsProvider = mock(Function.class);
                    writeFileChunks(replicationRef.get(), primaryShard, filesToFetch.toArray(new StoreFileMetadata[] {}));
        recoverySettings.setChunkSize(new ByteSizeValue(fileChunkSizeInBytes));
            );
        recoverReplica(
        BlobPath blobPath = new BlobPath();
    ) throws IOException {
            .putMapping("{ \"properties\": {} }");
        final DiscoveryNode node = IndexShardTestUtils.getFakeDiscoNode(shard.routingEntry().currentNodeId());
                        new RemoteTranslogTransferTracker(shardRouting.shardId(), 20),
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
    protected void recoverShardFromStore(IndexShard primary) throws IOException {
import java.util.function.Consumer;
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        final ShardRouting shardRouting = current.routingEntry();
            rNode = IndexShardTestUtils.getFakeRemoteEnabledNode(replica.routingEntry().currentNodeId());
            @Override
    ) {
        // update both primary and replica shard state
        // To simulate that the node is remote backed
            (is, listener) -> listener.onResponse(
    }
            recoveryTarget.fail(new RecoveryFailedException(request, e), false);
                        DefaultRemoteStoreSettings.INSTANCE,
 * under the License.
            globalCheckpointSyncer,
    private RecoveryTarget recoveryTarget;
                        new CheckpointInfoResponse(copyState.getCheckpoint(), copyState.getMetadataMap(), copyState.getInfosBytes())
        Settings nodeSettings = Settings.builder().put("node.name", routing.currentNodeId()).build();
    }
 * the Apache License, Version 2.0 (the "License"); you may
            current.getRetentionLeaseSyncer(),
     *
                try {
        final CountDownLatch countDownLatch = new CountDownLatch(replicaShards.size());
    /**
    protected IndexShard newStartedShard() throws IOException {
        final Engine.DeleteResult result;
    }
import org.apache.lucene.index.SegmentInfos;
        final RecoverySource recoverySource = primary
     * @param shardId the shard id to use
        Runnable globalCheckpointSyncer,
        } else {
     * @param primary indicates whether to a primary shard (ready to recover from an empty store) or a replica (ready to recover from
        IndexingOperationListener... listeners
                DefaultRemoteStoreSettings.INSTANCE,
    }
    ) throws IOException {
import org.opensearch.index.engine.NRTReplicationEngineFactory;
        IndexShard primaryShard,
        recoverFromStore(primary);
        final Set<String> shardDocUIDs = getShardDocUIDs(shard);
                primaryShard,
            null,
                Collections.emptyMap(),
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()),
        assertEquals(shard.snapshotStoreMetadata().size(), lastSnapshotStatus.getTotalFileCount());
        @Override
            globalCheckpointSyncer,
        IndexingOperationListener... listeners
    }
     * @param routing       shard routing to use
     * Creates a new empty shard with the specified settings and engine factory and starts it.
        recoverUnstartedReplica(replica, primary, targetSupplier, markAsRecovering, inSyncIds, routingTable, replicatePrimaryFunction);
                } finally {
        } else {
        assertThat(getShardDocUIDs(shard), hasSize(docDount));
    ) throws IOException {
     *                (ready to recover from another shard)
 */
            }
     * get_files calls.
     */
            primary,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     * @param getTargetFunc - provides replication target from target service using replication id
        public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
import org.opensearch.indices.replication.AbstractSegmentReplicationTarget;
     * @param primary indicates whether to a primary shard (ready to recover from an empty store) or a replica
                        Version.CURRENT
import java.util.concurrent.ExecutionException;
                try {
                    assertTrue(replicaFiles.containsAll(primaryMetadata.keySet()));
                Settings.EMPTY,
            node.getId(),
                new PrimaryReplicaSyncer.ResyncTask(1, "type", "action", "desc", null, Collections.emptyMap())
            protected void assertSnapshotOrGenericThread() {
    ) throws IOException {
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
                remoteStore = createRemoteStore(remotePath, routing, indexMetadata, shardPath);
            EMPTY_EVENT_LISTENER,
     * @param indexReaderWrapper     an optional wrapper to be used during search
            ) {
                0,
                null,
            new EngineBackedIndexerFactory(new InternalEngineFactory()),
     * @param primary controls whether the shard will be a primary or a replica.
            @Override
                throw new TransportReplicationAction.RetryOnReplicaException(
import org.opensearch.index.store.RemoteBufferedOutputDirectory;
        RetentionLeaseSyncer retentionLeaseSyncer,
    }
 * not use this file except in compliance with the License.
        final Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction
                    );
                routing,
        return target.indexSettings().isSegRepEnabledOrRemoteNode() ? (shardList) -> {
            null,
        InterruptedException {
        Function<Long, ReplicationCollection.ReplicationRef<MergedSegmentReplicationTarget>> getMergedSegmentTargetFunc,
                    sourceToParse,
            threadPool,
                    replicationCheckpoint.getCodec(),
                VersionType.INTERNAL,
                remoteStore,
     * @param indexerFactory the indexer factory to use for this shard
            new RemoteBufferedOutputDirectory(getBlobContainer(remoteShardPath.resolveIndex().resolve("lock_files")))
            indexEventListener,
        when(repository.basePath()).thenReturn(new BlobPath());
        );
        IndexShard primaryShard,
        return newShard(shardRouting, settings, indexerFactory);
    }
    protected IndexShard newShard(boolean primary) throws IOException {
            IndexShardTestUtils.getFakeDiscoveryNodes(routingEntry)
import java.util.HashMap;
     * @param listeners     an optional set of listeners to add to the shard
                    assertTrue(recoveryDiff.different.isEmpty());
     * @param listeners              an optional set of listeners to add to the shard
            remotePath,
            indexMetadata,
        IndexMetadata indexMetadata,
                throw new RuntimeException(e);
        IndexMetadata indexMetadata,
    }
        RemoteDirectory dataDirectory = newRemoteDirectory(remoteShardPath.resolveIndex().resolve("data"));
                } catch (IOException e) {
            listeners
     */
     * supplied node id.
                wrappedIndexCommit.get(),
    }
import org.opensearch.index.IndexSettings;
import org.opensearch.cluster.metadata.MappingMetadata;
                : IndexShardTestUtils.getFakeDiscoveryNodes(routingTable.shards())
        return newShard(
        return prepareForReplication(primaryShard, target, transportService, indicesService, clusterService, (indexShard) -> {});
        );
        IndexMetadata indexMetadata,
import org.opensearch.core.indices.breaker.CircuitBreakerService;
     */
     * @param getMergedSegmentTargetFunc - provides merged segment replication target from target service using replication id
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> indexReaderWrapper,
     *                (ready to recover from another shard)
            RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory = null;
            recoverySettings,
    }
    protected final void replicateMergedSegments(IndexShard primaryShard, List<IndexShard> replicaShards) throws IOException,
        return EngineTestCase.getDocIds(((EngineBackedIndexer) shard.getIndexer()).getEngine(), true);
            "store",
        for (IndexShard shard : shards) {
        Engine engine = getEngine(shard);
            current.engineConfigFactory,
        try (final GatedCloseable<SegmentInfos> segmentInfosSnapshot = primaryShard.getSegmentInfosSnapshot()) {
        assertNull(lastSnapshotStatus.getFailure());
            snapshot,
     * Segment Replication specific test method - Replicate segments to a list of replicas from a given primary.
            remotePath,
        final Settings settings,
                    // necessary to obtain the entire file list through listAll().
        } else {
            startReplicaAfterRecovery(replica, primary, inSyncIds, routingTable);
        return reinitShard(current, routing, null, listeners);
        final PlainActionFuture<Void> future = PlainActionFuture.newFuture();
     * @param primary indicates whether to a primary shard (ready to recover from an empty store) or a replica (ready to recover from
        IndexShard primaryShard,
        final boolean markAsRecovering,
import java.util.concurrent.atomic.AtomicLong;
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;
                sourceToParse
            indexerFactory,
            if (assertConsistencyBetweenTranslogAndLucene) {
     * Creates a new empty shard and starts it. The shard will randomly be a replica or a primary.
                    shard.shardId,
    protected IndexShard newStartedShard(CheckedFunction<Boolean, IndexShard, IOException> shardFunction, boolean primary)
    }
            ids.add(target);
        repository.start();
        }
                    final Map<String, StoreFileMetadata> replicaMetadata = replicaShard.store().getSegmentMetadataMap(replicaInfos);
     */
        return newShard(primary, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
    protected final List<SegmentReplicationTarget> replicateSegments(IndexShard primaryShard, List<IndexShard> replicaShards)
    /**
            ShardRoutingState.INITIALIZING,
     * @param listeners new listerns to use for the newly created shard
                .build();
                updateMappings(
            if (indexSettings.isRemoteStoreEnabled() || indexSettings.isAssignedOnRemoteNode()) {
        ShardRouting initializingReplicaRouting = replica.routingEntry();
        Map<String, StoreFileMetadata> primaryMetadata,
     * @param listeners an optional set of listeners to add to the shard
        final RecoveryTarget recoveryTarget = targetSupplier.apply(replica, pNode);
     * @param routing                shard routing to use
    protected IndexShard newShard(
            UUIDs.randomBase64UUID(),
     * creates a new initializing shard. The shard will be put in its proper path under the
            );
            );
            shardPath,
                    remotePath = createTempDir();
    }
    protected void recoverReplica(
            sourceFactory,
    /**
    protected Engine.IndexResult indexDoc(IndexShard shard, String type, String id) throws IOException {
        IndexShard replica,
        return indexShard.getReplicationTracker();
        assertEquals("Replication merged segment should complete successfully", 0, countDownLatch.getCount());
    }
            : null;
import org.opensearch.core.xcontent.MediaType;
     *                             which are desired right after files are copied. e.g. To work with temp files
                ActionListener<CheckpointInfoResponse> listener
import org.opensearch.indices.recovery.RecoverySourceHandlerFactory;
     * @param primaryShard - {@link IndexShard} The current primary shard.
                logger.error("Unexpected replication failure in test", e);
        );
    protected IndexShard newShard(boolean primary, SegmentReplicationCheckpointPublisher checkpointPublisher, Settings settings)
                    false
        closeShards(Arrays.asList(shards));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     * current node id the shard is assigned to.
                ) {
        IndexShard primary = null;
        if (primary) {
        indexShard.acquirePrimaryOperationPermit(fut, ThreadPool.Names.WRITE, "");
     * @param settings the settings to use for this shard
            recoverReplica(replica, primary, startReplica);
    protected Engine.IndexResult indexDoc(IndexShard shard, String type, String id, String source) throws IOException {
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
                IndexMetadata.builder(indexMetadata).putMapping(new MappingMetadata(shard.mapperService().documentMapper())).build()
        IndicesService indicesService,
    }
    ) throws IOException {
     * @return Return SegmentReplicationSource
     * <p>
        }
    }
        doAnswer(invocation -> {
import org.opensearch.common.settings.Settings;
    }
                        .build()
    }
     */
     */
            mock(IndicesService.class),
     *
 * compatible open source license.
        return Settings.EMPTY;
        IndexShard shard = shardFunction.apply(primary);
            indexMetadata,
    }
            primary,
     * Creates a new initializing shard. The shard will have its own unique data path.
            primary,
    }
     * @param globalCheckpointSyncer        callback for syncing global checkpoints
            final SegmentInfos primarySegmentInfos = segmentInfosSnapshot.get();
        RecoverySettings recoverySettings = new RecoverySettings(
            );
            .build();
                .build();
import org.opensearch.index.engine.Engine;
                Version.CURRENT,
public abstract class IndexShardTestCase extends OpenSearchTestCase {
                clusterService.getClusterApplierService(),
    protected IndexShard newShard(boolean primary, Settings settings, IndexerFactory indexerFactory) throws IOException {
        newRoutingTable.addShard(primary.routingEntry());
            replica.indexSettings.isRemoteTranslogStoreEnabled()
        }
     * @param target {@link IndexShard} - The target replica shard.
        );
        ShardPath remoteShardPath = new ShardPath(false, remoteNodePath.resolve(shardId), remoteNodePath.resolve(shardId), shardId);
        );
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
    /**
            if (engine != null) {
     * Takes an existing shard, closes it and starts a new initialing shard at the same location
            settings,
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> indexReaderWrapper,
            MapperService mapperService = MapperTestUtils.newMapperService(
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        return newStartedShard(primary, settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
        Set<String> inSyncIdsWithReplica = new HashSet<>(inSyncIds);
     */
     * @param shardFunction shard factory function
        if (primaryShard.indexSettings.isRemoteStoreEnabled() || primaryShard.indexSettings.isAssignedOnRemoteNode()) {
    public static void updateRoutingEntry(IndexShard shard, ShardRouting shardRouting) throws IOException {
                try (
        Path home = createTempDir();
            super.tearDown();
        primaryTerm = randomIntBetween(1, 100); // use random but fixed term for creating shards
     *
            null,
        final ShardId shardId = routing.shardId();
                replica,
 * Licensed to Elasticsearch under one or more contributor
            SimilarityService similarityService = new SimilarityService(indexSettings, null, Collections.emptyMap());
        Set<String> inSyncIds = shardRouting.active() ? Collections.singleton(shardRouting.allocationId().getId()) : Collections.emptySet();
import org.opensearch.common.lucene.uid.Versions;
    /**
        return indexShard.getIndexer();
    /**
        return reader -> {
     */
     * @param primary       controls whether the shard will be a primary or a replica.
        }
            mapperService.merge(indexMetadata, MapperService.MergeReason.MAPPING_RECOVERY);
    }
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.index.translog.TranslogManager;
import org.opensearch.indices.recovery.RecoveryFailedException;
    protected IndexShard reinitShard(
            result = shard.applyIndexOperationOnPrimary(
        assert translogManager instanceof InternalTranslogManager : "only InternalTranslogManager have translogs, got: "
        for (IndexShard replica : replicaShards) {
        boolean primary,
                }
import org.opensearch.index.seqno.RetentionLeaseSyncer;
            currentClusterStateVersion.incrementAndGet(),
        @Nullable IndexerFactory indexerFactory,
        }
            ActionListener<List<BlobMetadata>> listener = invocation.getArgument(3);
            ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // Latch to block test execution until replica catches up
            indexReaderWrapper,
import org.opensearch.index.seqno.SequenceNumbers;
     * @param globalCheckpointSyncer        callback for syncing global checkpoints
import org.opensearch.indices.IndicesService;
                similarityService,
                    throw ExceptionsHelper.convertToRuntime(e);
     * current node id the shard is assigned to.
            metadataDirectory,
    protected void recoverReplica(IndexShard replica, IndexShard primary, boolean startReplica) throws IOException {
        final IndexSettings indexSettings = new IndexSettings(indexMetadata, nodeSettings);
     *
        if (shard.routingEntry().primary()) {
import org.opensearch.index.store.StoreFileMetadata;
     * @return Returns SegmentReplicationTargetService.SegmentReplicationListener
import org.opensearch.index.similarity.SimilarityService;
            }
        final BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier,
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> indexReaderWrapper,
        }
                ) {
            assertEquals(replica.state(), IndexShardState.RECOVERING);
        return ids;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.ShardRouting;
    /**
import org.opensearch.threadpool.ThreadPool;
            true,
        return prepareForReplication(
        );
 * containing utilities for shard creation and recoveries. See {{@link #newShard(boolean)}} and
            @Override
            null,
    }
    }
            shardRouting,
            .primaryTerm(0, primaryTerm)
import org.opensearch.repositories.RepositoriesService;
        boolean startReplica,
    public final SegmentReplicationTargetService prepareForReplication(
import org.opensearch.indices.replication.common.ReplicationType;
                } catch (IOException e) {
            shardPath,
    }
     */
            tearDownThreadPool();
            .addShard(routingEntry)
    public Settings threadPoolSettings() {
            indexShard.addShardFailureCallback(DEFAULT_SHARD_FAILURE_HANDLER);
            null
import java.util.List;
            engineConfigFactory,
                    target.writeFileChunk(md, pos, new BytesArray(buffer), pos + length == md.length(), 0, mock(ActionListener.class));
                        Collections.emptyMap(),
        final ClusterService clusterService = BlobStoreTestUtil.mockClusterService(repositoryMetadata);
     * creates a new initializing shard. The shard will be put in its proper path under the
     * @param postGetFilesRunnable - Consumer which is executed after file copy operation. This can be used to stub operations
     * @param indexMetadata          indexMetadata for the shard, including any mapping
import org.opensearch.cluster.routing.ShardRoutingHelper;
        public void onDone(ReplicationState state) {
            : new IndexShardRoutingTable.Builder(routingTable).removeShard(initializingReplicaRouting)
            primary.routingEntry(),
                globalCheckpointSyncer,
        return newStartedShard(randomBoolean(), settings, new EngineBackedIndexerFactory(new InternalEngineFactory()));
                createTempDir(),
package org.opensearch.index.shard;
import org.opensearch.common.blobstore.BlobContainer;
            @Override
            nodeSettings = Settings.builder()
        ShardPath shardPath,
                // eliminate thread name check as we create repo manually
        SegmentReplicationTargetService targetService;
                remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, indexSettings.getSettings());
        Function<Long, ReplicationCollection.ReplicationRef<SegmentReplicationTarget>> getTargetFunc,
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            indicesService,
            true,
        );
    public void tearDown() throws Exception {
                while (pos < md.length()) {
        ShardRouting routing,
import org.opensearch.common.settings.ClusterSettings;
                SequenceNumbers.UNASSIGNED_SEQ_NO,
        IndexMetadata.Builder metadata = IndexMetadata.builder(shardRouting.getIndexName())
                        RemoteStoreUtils.isServerSideEncryptionEnabledIndex(settings.getIndexMetadata())
        if (failOnShardFailures.get()) {
 * Modifications Copyright OpenSearch Contributors. See
                engineConfigFactory,
     * @param routing                shard routing to use
     *
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> readerWrapper,
        final IndexerFactory indexerFactory,
import org.opensearch.common.lease.Releasable;
                ActionListener<GetSegmentFilesResponse> listener
            IOUtils.close(() -> shard.close("test", false, false), shard.store());
            RetentionLeaseSyncer.EMPTY,
    /**
        if (shard.state() != IndexShardState.POST_RECOVERY && shard.state() != IndexShardState.STARTED) {
            final SegmentReplicationTargetService targetService = prepareForReplication(primaryShard, replica);
            randomAlphaOfLength(5),
                false,
        IndexShard primaryShard,
            }
    /**
                        DiscoveryNodeRole.BUILT_IN_ROLES,
            nodeId,
            new FsDirectoryFactory()
import org.opensearch.Version;
        SourceToParse sourceToParse = new SourceToParse(shard.shardId().getIndexName(), id, new BytesArray(source), mediaType, routing);
     * Creates a new initializing shard. The shard will have its own unique data path.
        final StartRecoveryRequest request = PeerRecoveryTargetService.getStartRecoveryRequest(
    protected IndexShard newStartedShard(final boolean primary) throws IOException {
            indexerFactory,
            shard.sync(); // advance local checkpoint
                        buildNewFakeTransportAddress(),
            : randomIntBetween(1, 10 * 1024 * 1024);
            ? RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING.getDefault(Settings.EMPTY).getBytes()
        IndexEventListener indexEventListener,
            replica.routingEntry().allocationId()
     * Get listener on started merged segment replication event which verifies replica shard store with primary's after completion
        );
            replica.routingEntry().currentNodeId(),
            current,
                try (final GatedCloseable<SegmentInfos> snapshot = replicaShard.getSegmentInfosSnapshot()) {
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
            return;
     */
     * @param routing                       shard routing to use
    }
                replica,
        IndexShardRoutingTable newRoutingTable = new IndexShardRoutingTable.Builder(shardRouting.shardId()).addShard(shardRouting).build();
        @Nullable IndexerFactory indexerFactory,
    protected void recoveryEmptyReplica(IndexShard replica, boolean startReplica) throws IOException {
        RecoverySettings recoverySettings,
        try (final GatedCloseable<SegmentInfos> segmentInfosSnapshot = primaryShard.getSegmentInfosSnapshot()) {
            recoverShardFromStore(shard);
                ReplicationCheckpoint checkpoint,
    protected void tearDownThreadPool() {
     *
            final Engine.Warmer warmer = createTestWarmer(indexSettings);
        Map<String, StoreFileMetadata> primaryMetadata;
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        final DiscoveryNode pNode;
            inSyncIds,
                    replicationCheckpoint.getPrimaryTerm(),
    }
     *
    }
     * @return Returns SegmentReplicationTargetService
        } finally {
            logger,
            : "only InternalEngines or NRTReplicationEngines have translogs, got: " + engine.getClass();
        }
 * ownership. Elasticsearch licenses this file to you under
    /**
import org.opensearch.cluster.node.DiscoveryNodeRole;
     * @param globalCheckpointSyncer callback for syncing global checkpoints
            randomAlphaOfLength(10),
        return newShard(
            targetService = getSegmentReplicationTargetService(transportService, indicesService, clusterService, sourceFactory);
            shardId,
            .put("indices.recovery.max_concurrent_file_chunks", Integer.toString(between(1, 4)))
        BlobStore blobStore = Mockito.mock(BlobStore.class);
        return repository;
        );
import org.opensearch.common.blobstore.BlobStore;
                shard.getOperationPrimaryTerm(),
    }
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = createRemoteSegmentStoreDirectory(shardId, path);
            directory,
import org.opensearch.common.CheckedFunction;
    }
        final RecoverySource.SnapshotRecoverySource recoverySource = new RecoverySource.SnapshotRecoverySource(
            final SegmentReplicationSource replicationSource = getSegmentReplicationSource(
     * supplied node id.
     * @param recoverySettings       recovery settings
    @Override
     * @param listeners     an optional set of listeners to add to the shard
            Settings.builder()
    }
            public void getCheckpointMetadata(
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    }
            Store remoteStore;
import org.opensearch.indices.replication.common.ReplicationFailedException;
                        settings.getRemoteStoreTranslogRepository(),
        recoverReplica(replica, primary, targetSupplier, markAsRecovering, markAsStarted, (a) -> null);
     * @param routing       the shard routing to use for the newly created shard.
            shardId,
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata(randomAlphaOfLength(10), FsRepository.TYPE, settings);
        IndexShard indexShard = recoveryTarget.indexShard();
        IndexMetadata indexMetadata,
import org.opensearch.cluster.metadata.RepositoryMetadata;
     *
            if (success == false) {
            public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
            DefaultRecoverySettings.INSTANCE,
                    pos += length;
        final Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction
import org.opensearch.index.engine.InternalEngineFactory;
    protected IndexShard newShard(
            transportService,
    ) throws IOException {
        if (markAsRecovering) {
                mapperService,
     *                another shard)
import org.opensearch.common.Nullable;
            primary ? RecoverySource.EmptyStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE
                .put(Environment.PATH_REPO_SETTING.getKey(), path.toAbsolutePath())
        final IndexShardSnapshotStatus snapshotStatus = IndexShardSnapshotStatus.newInitializing(
        RepositoriesService repositoriesService = Mockito.mock(RepositoriesService.class);
                any(ActionListener.class)
                    IndexMetadata.builder(shard.indexSettings().getIndexMetadata())
     * @param settings the settings to use for this shard
        clusterService.addStateApplier(event -> repository.updateState(event.state()));
        indexer.ensureOpen();
import org.opensearch.index.translog.InternalTranslogManager;
            newRoutingTable,
                    Versions.MATCH_ANY,
import org.opensearch.index.engine.EngineTestCase;
    }
                Versions.MATCH_ANY,
    }
import org.opensearch.index.remote.RemoteStoreUtils;
        final ShardRouting shardRouting,
            shardGen = future.actionGet();
        RetentionLeaseSyncer retentionLeaseSyncer,
        IndicesService indicesService,
import org.opensearch.index.translog.RemoteBlobStoreInternalTranslogFactory;
            SegmentReplicationCheckpointPublisher.EMPTY,
    public static void assertConsistentHistoryBetweenTranslogAndLucene(IndexShard shard) throws IOException {
        final NodeEnvironment.NodePath nodePath = new NodeEnvironment.NodePath(createTempDir());
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> readerWrapper
            null,
        RetentionLeaseSyncer retentionLeaseSyncer,
            retentionLeaseSyncer,
        IndexShard replica,
    ) throws IOException {
        flushShard(shard, false);
                false,
import org.opensearch.env.TestEnvironment;
    private BlobStoreRepository createRepository(Path path) {
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(
            try {
        IndexMetadata indexMetadata,
import org.opensearch.index.mapper.MapperService;
    }
import org.opensearch.ExceptionsHelper;
        CountDownLatch latch
            rNode,
     * @param targetSupplier         supplies an instance of {@link RecoveryTarget}
     * @param indexMetadata indexMetadata for the shard, including any mapping
                // since we can't get remote path from IndexShard directly, we are using repository to store it .
                Assert.fail("test replication should not fail: " + e);
            protected BlobStore createBlobStore() throws Exception {
import org.opensearch.index.engine.DocIdSeqNoAndSource;
     * Creates a new initializing shard. The shard will have its own unique data path.
        EngineConfigFactory engineConfigFactory,
            (indexShard) -> {}
     * @param indexerFactory the indexer factory for the new shard
        return new RemoteSegmentStoreDirectory(
    protected void flushShard(IndexShard shard) {
    public final void recoverUnstartedReplica(
                    );
 * SPDX-License-Identifier: Apache-2.0
            request,
     * creates a new empty shard and starts it.
                closeShard(shard, true);
     * @param indexReaderWrapper     an optional wrapper to be used during search
    protected void startReplicaAfterRecovery(
     * @param settings      the settings to use for this shard
    protected IndexShard reinitShard(IndexShard current, IndexingOperationListener... listeners) throws IOException {
    private static final Consumer<IndexShard.ShardFailure> DEFAULT_SHARD_FAILURE_HANDLER = failure -> {
     * @param primaryMetadata - primary shard metadata before start of segment replication
                } catch (IOException e) {
                snapshotStatus,
        }
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> indexReaderWrapper,
    ) {
import org.opensearch.indices.replication.common.ReplicationListener;
import java.util.Map;
     *
    /**
        try {
            }
        TransportService transportService,
            clusterService,
    }
     */
    protected static final ReplicationListener recoveryListener = new ReplicationListener() {
            return null;
     * @param primary   indicates whether to a primary shard (ready to recover from an empty store) or a replica
    }
    protected Store createStore(IndexSettings indexSettings, ShardPath shardPath) throws IOException {
                    // After the pre-copy merged segment is completed, the merged segment is not yet visible in the replica shard, so it is
        ShardId shardId,
                ? engineBackedIndexer.getEngine()
import static org.mockito.Mockito.when;
/**
    protected Store createRemoteStore(Path path, ShardRouting shardRouting, IndexMetadata metadata, ShardPath shardPath)
                    latch.countDown();
     * Creates a new initializing shard. The shard will have its own unique data path.
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
                    assertTrue(recoveryDiff.missing.isEmpty());
                    IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
    /**
    };
import org.mockito.Mockito;
     * @param replicaShard - target of segment replication
                    listener.onFailure(e);
        );
        }
    }
            );
     * @param primary controls whether the shard will be a primary or a replica.
        primary.updateShardState(
            metadata,
        return createStore(shardPath.getShardId(), indexSettings, newFSDirectory(shardPath.resolveIndex()), shardPath);
            .build();
                    primaryShard.updateVisibleCheckpointForShard(
        return newShard(shardRouting, Settings.EMPTY, listeners);
        failOnShardFailures.set(true);
            listener.onResponse(new ArrayList<>());
                remoteStore = null;
            return engineBackedIndexer.getEngine();
        final FsRepository repository = new FsRepository(
            + engine.getClass();
        MergedSegmentPublisher mergedSegmentPublisher,
            assertThat(shard.getMaxSeqNoOfUpdatesOrDeletes(), equalTo(shard.seqNoStats().getMaxSeqNo()));
import org.opensearch.indices.recovery.StartRecoveryRequest;
        );
        TranslogManager translogManager = indexer.translogManager();
        final Store store = storeProvider.apply(indexSettings);
        return newShard(
        final Version version = Version.CURRENT;
            shard.updateLocalCheckpointForShard(shard.routingEntry().allocationId().getId(), shard.getLocalCheckpoint());
        }
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;
                    in.readBytes(buffer, 0, length);
        final BiFunction<IndexShard, DiscoveryNode, RecoveryTarget> targetSupplier,
import org.opensearch.index.store.FsDirectoryFactory;
import static org.mockito.ArgumentMatchers.any;
        }
                } catch (Exception e) {
import org.opensearch.common.blobstore.fs.FsBlobContainer;
        return newShard(primary, checkpointPublisher, settings);
            primary.isRemoteTranslogEnabled()
     * @param globalCheckpointSyncer callback for syncing global checkpoints
        IndexShard primaryShard,
                BiConsumer<String, Long> fileProgressTracker,
        );
        InternalTranslogManager internalTranslogManager = (InternalTranslogManager) translogManager;
     * creates a new initializing shard.
    public final SegmentReplicationTargetService prepareForReplication(IndexShard primaryShard, IndexShard target) {
            checkpointPublisher,
                    new DiscoveryNode(
            routingTable,
    ) throws IOException {
     */
    }
            globalCheckpointSyncer,
        } else {
            repositoryMetadata,
                    VersionType.INTERNAL,
                (repId) -> targetService.getMergedSegmentReplicationRef(repId),
                    final ReplicationCollection.ReplicationRef<MergedSegmentReplicationTarget> replicationRef = getMergedSegmentTargetFunc
                    int length = between(1, Math.toIntExact(md.length() - pos));
            globalCheckpointSyncer,
            () -> {},
import org.opensearch.index.store.Store;
                ReplicationCheckpoint checkpoint,
        ShardRouting routing,
     * @param indexerFactory the indexer factory to use for this shard
            }
    ) throws IOException {
            true,
        // Get primary metadata to verify with replica's, used to ensure replica catches up
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                        shardRouting.currentNodeId(),
                shard.store(),
        primary.updateShardState(
                String remoteStoreRepository = indexSettings.getRemoteStoreRepository();
                shardRouting.primary() ? RecoverySource.ExistingStoreRecoverySource.INSTANCE : RecoverySource.PeerRecoverySource.INSTANCE
            routing,
        );
                ? IndexShardTestUtils.getFakeRemoteEnabledDiscoveryNodes(routingTable.shards())
            clusterService.close();
            ? RecoverySource.EmptyStoreRecoverySource.INSTANCE
import org.opensearch.index.engine.EngineConfigFactory;
                getTargetListener(primaryShard, replica, primaryMetadata, countDownLatch)
    private static final AtomicBoolean failOnShardFailures = new AtomicBoolean(true);
        countDownLatch.await(30, TimeUnit.SECONDS);
    }
                listener.onResponse(new GetSegmentFilesResponse(filesToFetch));
            IndexCache indexCache = new IndexCache(indexSettings, new DisabledQueryCache(indexSettings), null);
    public static Translog getTranslog(IndexShard shard) {
        RemoteStoreLockManager remoteStoreLockManager = new RemoteStoreMetadataLockManager(
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
    protected void promoteReplica(IndexShard replica, Set<String> inSyncIds, IndexShardRoutingTable routingTable) throws IOException {
                xContentRegistry(),
import org.opensearch.core.index.shard.ShardId;
                );
        );
                indexReaderWrapper,
        updateRoutingEntry(primary, ShardRoutingHelper.moveToStarted(primary.routingEntry()));
                List<StoreFileMetadata> filesToFetch,
            pNode = IndexShardTestUtils.getFakeDiscoNode(primary.routingEntry().currentNodeId());
            when(sourceFactory.get(any())).thenReturn(replicationSource);
            );
    }
        @Nullable EngineConfigFactory engineConfigFactory,
     * @param settings      the settings to use for this shard
            if (remoteStoreStatsTrackerFactory != null) {
        ShardRouting routing,
        try {
        };
                new Object(),
        @Nullable Path remotePath,
        return reinitShard(current, (Path) null, listeners);
 *
    }
                new MergedSegmentWarmerFactory(null, new RecoverySettings(nodeSettings, clusterSettings), clusterService),
            shardId,
                    listener.onResponse(
            shard.sync(); // advance local checkpoint
            public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
    ) throws IOException {
    }
        return result;
                }
import org.opensearch.indices.replication.CheckpointInfoResponse;
            future.actionGet();
    }
        ShardPath shardPath,
            ),
        return newShard(
        throws IOException {
            when(indicesService.getShardOrNull(any())).thenReturn(target);
     * This test will use a real {@link SegmentReplicationTarget} for each replica with a mock {@link SegmentReplicationSource} that
import static org.hamcrest.Matchers.equalTo;
            if (result.getResultType() == Engine.Result.Type.MAPPING_UPDATE_REQUIRED) {
                    Assert.fail("Failed to compute copyState");
     * This test will use a real {@link SegmentReplicationTarget} for each replica with a mock {@link SegmentReplicationSource} that
import org.opensearch.index.seqno.ReplicationTracker;
                try (final CopyState copyState = new CopyState(primaryShard)) {
     * creates a new initializing shard. The shard will be put in its proper path under the
            } else {
        IndexingOperationListener... listeners
            mergedSegmentPublisher,
            listeners
        if (indexMetadata.getSettings().get(IndexMetadata.SETTING_REMOTE_STORE_ENABLED) == "true") {
            RetentionLeaseSyncer.EMPTY,
import java.util.ArrayList;
                } catch (IOException e) {
     * @param replicaShard - target of segment replication
                any(BlobContainer.BlobNameSortOrder.class),
     * @param mergedSegmentPublisher        merged segment publisher
                indexSettings.getSettings(),
            }
import org.opensearch.action.support.replication.TransportReplicationAction;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                .put("node.attr.remote_store.translog.repository", "seg_repo")
     * @param primaryShard - {@link IndexShard} The current primary shard.
            );
        failOnShardFailures.set(false);
            throw new AssertionError(e);
        final IndexId indexId = new IndexId(shardId.getIndex().getName(), shardId.getIndex().getUUID());
        Path path,
        ShardId shardId = shardRouting.shardId();
        return new FsBlobContainer(fsBlobStore, blobPath, f);
        when(repositoriesService.repository(any(String.class))).thenReturn(repository);
            null,
    }
    protected RepositoriesService createRepositoriesService() {
                        () -> mockRepoSvc,
            EngineTestCase.assertConsistentHistoryBetweenTranslogAndLuceneIndex(engine);
        if (shard.routingEntry().primary()) {
        final IndexShardRoutingTable routingTable = newRoutingTable.build();
    }
                warmer,
}
        @Nullable IndexerFactory indexerFactory,
        final IndexShard replica,
                    replicationCheckpoint.getSegmentInfosVersion(),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public SegmentReplicationTargetService.SegmentReplicationListener getMergedSegmentTargetListener(
        return newStartedShard(primary, Settings.EMPTY, new EngineBackedIndexerFactory(new InternalEngineFactory()));
            current.shardPath(),
     * @param listeners new listerns to use for the newly created shard
        }
            ShardRoutingState.INITIALIZING,
                List<StoreFileMetadata> filesToFetch,
    /**
                ),
            (r, sourceNode) -> new RecoveryTarget(r, sourceNode, recoveryListener, threadPool),
        }
        return blobStore;
                null // TODO
 * Unless required by applicable law or agreed to in writing,
        primary.markAsRecovering(
        @Nullable EngineConfigFactory engineConfigFactory,
     * Helper method to access (package-protected) engine from tests.
import java.util.concurrent.TimeUnit;
        BlobStoreRepository repository = Mockito.mock(BlobStoreRepository.class);
        );
        final boolean markAsStarted,
     * @param listeners     new listerns to use for the newly created shard
    }
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
            .put(Settings.EMPTY)
     * Snapshot a shard using a given repository.
        return indexShard;
            }
        }
    public void setUp() throws Exception {
     * @param path                   remote path
            primary = newStartedShard(true, replica.indexSettings.getSettings());
import org.opensearch.indices.DefaultRemoteStoreSettings;
        @Nullable IndexerFactory indexerFactory,
        replica.prepareForIndexRecovery();
            recoveryTarget,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.threadpool.TestThreadPool;
                    )
        return newStartedShard(p -> newShard(p, settings, indexerFactory), primary);
    }
     * @param indexMetadata                 indexMetadata for the shard, including any mapping
        final Settings settings = Settings.builder()
     * @return Returns SegmentReplicationTargetService.SegmentReplicationListener
                IndexShard indexShard,
 * license agreements. See the NOTICE file distributed with
        }
        ShardRouting routing,
        IndexShard current,
        SegmentReplicationSourceFactory sourceFactory
        final Engine engine = shard.getIndexerOrNull() instanceof EngineBackedIndexer engineBackedIndexer
                    final Store.RecoveryDiff recoveryDiff = Store.segmentReplicationDiff(primaryMetadata, replicaMetadata);
        IndexMetadata metadata = IndexMetadata.builder(shardRouting.getIndexName())
        Indexer indexer = getIndexer(shard);
            : RecoverySource.PeerRecoverySource.INSTANCE;
                breakerService,
                long replicationId,
                    "Mappings are not available on the replica yet, triggered update: " + result.getRequiredMappingUpdate()
            version,
            routing,
                : null;
            mock(ClusterService.class),
 * this work for additional information regarding copyright
    protected void assertDocs(IndexShard shard, String... ids) throws IOException {
            inSyncIds,
import java.util.Arrays;
        final IndexShard primary,
import java.util.function.BiConsumer;
            currentClusterStateVersion.incrementAndGet(),
            currentClusterStateVersion.incrementAndGet(),
        ShardRouting routing,
    protected RemoteSegmentStoreDirectory createRemoteSegmentStoreDirectory(ShardId shardId, Path path) throws IOException {
        );
                BlobStoreRepository repo = createRepository(remotePath);
    ) {
            ShardRoutingState.INITIALIZING,
        @Nullable CheckedFunction<DirectoryReader, DirectoryReader, IOException> indexReaderWrapper,
            .put("indices.recovery.max_concurrent_operations", Integer.toString(between(1, 4)))
        }
        // add node id as name to settings for proper logging
            clusterService
        return result;
import org.opensearch.indices.recovery.RecoveryState;
    }
        ) {
                    remotePath = PathUtils.get(remoteStoreRepository.replace("__test", ""));
                    writeFileChunks(replicationRef.get(), primaryShard, filesToFetch.toArray(new StoreFileMetadata[] {}));
            shard.updateLocalCheckpointForShard(shard.routingEntry().allocationId().getId(), shard.getLocalCheckpoint());
        final RecoverySourceHandler recovery = RecoverySourceHandlerFactory.create(
import org.opensearch.cluster.node.DiscoveryNode;
                    return new RemoteBlobStoreInternalTranslogFactory(
        super.setUp();
import java.util.concurrent.CountDownLatch;
        throws IOException {
     * Takes an existing shard, closes it and starts a new initialing shard at the same location
        );
            inSyncIds,
            recoveryTarget.markAsDone();
        final Set<String> inSyncIds = Collections.singleton(primary.routingEntry().allocationId().getId());
            public void onReplicationDone(SegmentReplicationState state) {
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
                    );
            rNode = IndexShardTestUtils.getFakeDiscoNode(replica.routingEntry().currentNodeId());
import org.opensearch.index.translog.TranslogFactory;
            CircuitBreakerService breakerService = new HierarchyCircuitBreakerService(
import org.opensearch.core.xcontent.MediaTypeRegistry;
     * @param indexMetadata the index metadata to use for the newly created shard
     */
        throws IOException {
                    listener.onFailure(e);
                    logger.error("Unexpected error computing CopyState", e);
        return newShard(shardRouting, metadata.build(), null, indexerFactory, () -> {}, RetentionLeaseSyncer.EMPTY, null, listeners);
    }
 * You may obtain a copy of the License at
     * @param remotePath Remote path to recover from if remote storage is used
            primary,
    /**
            shard.sync(); // advance local checkpoint
        final ShardRouting shardRouting = TestShardRouting.newShardRouting(
                    throw ExceptionsHelper.convertToRuntime(e);
                shard.mapperService(),
        Path path,
     * @param routing   the shard routing to use for the newly created shard.
     */
        long fileChunkSizeInBytes = randomBoolean()
     */
