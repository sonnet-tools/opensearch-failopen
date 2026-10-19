    private final IndexWarmer warmer;
                    remoteDirectory,
                    () -> new ParameterizedMessage("[{}] failed to close store on shard removal (reason: [{}])", shardId, reason),
                    store.close();
                this.indexSettings,
    final class AsyncRetentionLeaseSyncTask extends BaseAsyncTask {
            remoteStoreSettings,
        CompositeIndexSettings compositeIndexSettings,
import org.opensearch.gateway.WriteStateException;
        protected String getThreadPool() {
import org.opensearch.cluster.routing.ShardRouting;
    /**
                path = ShardPath.loadShardPath(logger, nodeEnv, shardId, this.indexSettings.customDataPath());
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        return shards.values().iterator();
    }
                        shouldWidenIndexSortType,
        this.shardLevelRefreshEnabled = shardLevelRefreshEnabled;
    private final Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier;
        void deleteShardStore(String reason, ShardLock lock, IndexSettings indexSettings) throws IOException;
            translogFactorySupplier,
                final IndexShard shard = indexService.getShardOrNull(shardId.id());
        boolean success = false;
        protected void runInternal() {
    /**
                } else if (this.indexSettings.isPluggableDataFormatEnabled() == false) {
                eventListener,
                for (final int shardId : shardIds) {
                logger.debug("{} creating using an existing path [{}]", shardId, path);
        }
    }
    }
            threadPool,
                case CLOSED:
        Function<IndexService, CheckedFunction<DirectoryReader, DirectoryReader, IOException>> wrapperFactory,
import org.opensearch.common.settings.Setting.Property;
                indexService.maybePublishReferencedSegments();
        try {
            try {
                        // ignore
            }
                case RECOVERING:
        if (closed.compareAndSet(false, true)) {
                }
    }
                threadPool,
        final SegmentReplicationCheckpointPublisher checkpointPublisher,
                        } catch (final AlreadyClosedException | IndexShardClosedException e) {
                routing,
            null,
        }
     * @opensearch.internal
                closeShard("initialization failed", shardId, indexShard, store, eventListener);
        this.client = client;
                    .buildIndexSort(
import org.opensearch.index.cache.bitset.BitsetFilterCache;
        public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
    private final SimilarityService similarityService;
        HashMap<Integer, IndexShard> newShards = new HashMap<>(shards);
        indexSettings.setDefaultMaxMergesAtOnce(newDefaultMaxMergeAtOnce);
 * @opensearch.api
                onShardClose(lock);
        IndexerFactory indexerFactory,
    private final IndexEventListener eventListener;
    public static final Setting<TimeValue> GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING = Setting.timeSetting(
        return trimTranslogTask;
     */
                bigArrays,
    private final List<SearchOperationListener> searchOperationListeners;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
import java.util.function.BiFunction;
        "index.soft_deletes.retention_lease.sync_interval",
                translogFactorySupplier,
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
                // only clear caches relating to the specified fields
    public enum IndexCreationContext {
            if (success == false) {
import org.opensearch.index.shard.IndexShardClosedException;
            super(indexService, RETENTION_LEASE_SYNC_INTERVAL_SETTING.get(indexService.getIndexSettings().getSettings()));
                        mapperService::fieldType,
            };
            scriptService,
        EngineConfigFactory engineConfigFactory,
            assert indexAnalyzers == null;
        }
                    e
     * Return the shard with the provided id, or throw an exception if it doesn't exist.
    private final Consumer<IndexShard> replicator;
            final long currentSettingsVersion = currentIndexMetadata.getSettingsVersion();
        this.translogFactorySupplier = translogFactorySupplier;
    ) {
                    fsyncTask,
            return "translog_sync";
     * Called whenever the cluster level {@code cluster.default.index.merge.scheduler.auto_throttle} changes.
    }
                );
                shardId,
    }
        }
                );
            indexFieldData.setListener(new FieldDataCacheListener(this));
 * this file be licensed under the Apache-2.0 license or a
        if (deleted.get()) { // we remove that shards content if this index has been deleted
import org.opensearch.common.util.BigArrays;
        protected String getThreadPool() {
            return ThreadPool.Names.GENERIC;
        assert Thread.holdsLock(refreshMutex);
                    eventListener.beforeIndexShardDeleted(lock.getShardId(), indexSettings.getSettings());
            } catch (IllegalStateException ex) {
        }
 * The OpenSearch Contributors require contributions made to
        IndexSettings indexSettings,
import org.opensearch.env.ShardLockObtainFailedException;
                    } finally {
                // Sample test failure: https://github.com/opensearch-project/OpenSearch/issues/13871
            }
                indexCache,
                // we parse all percolator queries as they would be parsed on shard 0
    // this setting is intentionally not registered, it is only used in tests
            return "trim_translog";
                listener.beforeIndexShardClosed(sId, indexShard, indexSettings);
                        RemoteStoreNodeAttribute.getRemoteStoreSegmentRepo(this.indexSettings.getNodeSettings()),
            );
        return indexerFactory;
                remoteStoreStatsTrackerFactory,
                seedRemote,
                    Path dataPath = shard.shardPath().getRootStatePath();
        IndexStorePlugin.DirectoryFactory directoryFactory,
        if (store != null) {
    @Deprecated(forRemoval = true)
        @Override
    private final Client client;
        }
    private void rescheduleRefreshTasks() {
    }
                mapperService,
        if (getIndexSettings().isExplicitRefresh()) {
        assert Thread.holdsLock(refreshMutex);
        }
            null
     */
        public void onRemoval(ShardId shardId, Accountable accountable) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
    }
                if (newShardLevelRefreshVal) {
                    shard.scheduledRefresh();
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig
                        path,
        BigArrays bigArrays,
            eventListener.afterIndexShardCreated(indexShard);
     * @opensearch.internal
    }
                            shard.runUnderPrimaryPermit(() -> sync.accept(shard), e -> {
                logger.debug(
                maybeRefreshEngine(true);
         */
        }
        }
            );
    }
                indexerFactory,
                // and close the shard so no operations are allowed to it
                // TODO: we should, instead, hold a "bytes reserved" of how large we anticipate this shard will be, e.g. for a shard
            this.indexFieldData = new IndexFieldDataService(
            remoteStore = indexShard.remoteStore();
        ValuesSourceRegistry valuesSourceRegistry,
import org.apache.lucene.search.Sort;
        sync(is -> is.maybeSyncGlobalCheckpoint("background"), "global checkpoint");
        if (clusterMergeSchedulerConfig != null) {
        return this.mapperService.getIndexAnalyzers();
        }
                }
import static org.opensearch.index.remote.RemoteMigrationIndexMetadataUpdater.indexHasRemoteStoreSettings;
     * Base asynchronous task
        boolean validate,
     * Context for index creation
                shardPath,
    public IndexShard getShard(int shardId) {
        }
                }
     * Return the shard with the provided id, or null if there is no such shard.
    }
import org.opensearch.common.util.io.IOUtils;
                this::getRefreshInterval,
        Property.IndexScope
                new StoreCloseListener(shardId, () -> eventListener.onStoreClosed(shardId)),
                        replicator.accept(shard);
            // if we are on a shared FS we only own the shard (i.e. we can safely delete it) if we are the primary.
                this.indexSortSupplier = () -> null;
                    );
                    IOUtils.closeWhileHandlingException(storeStrategyRegistry);
import org.opensearch.indices.mapper.MapperRegistry;
                    );
    }
     * @param maxForceMergeMBPerSec the updated cluster max force merge MB per second rate.
                setInterval(newInterval);
        Function<IndexService, CheckedFunction<DirectoryReader, DirectoryReader, IOException>> wrapperFactory,
                        true,
        @Override
        IndicesFieldDataCache indicesFieldDataCache,
    /**
        }
            }
    }
    public ScriptService getScriptService() {
    static final class AsyncTranslogFSync extends BaseAsyncTask {
        if (count == 0) {
        RemoteStoreSettings remoteStoreSettings,
        this.allowExpensiveQueries = allowExpensiveQueries;
        ShardId shardId,
                    remoteDirectory = ((RemoteSegmentStoreDirectoryFactory) remoteDirectoryFactory).newDirectory(
        boolean keywordIndexOrDocValuesEnabled
                    // do nothing
    }
    }
        final ShardRouting routing,
    private final IndexStorePlugin.DirectoryFactory remoteDirectoryFactory;
            eventListener.indexShardStateChanged(indexShard, null, indexShard.state(), "shard created");
     */
        }
     * Creates DataFormatAwareStoreDirectory using the factory if available, otherwise fallback to Store's internal creation.
    /**
import org.opensearch.index.engine.EngineConfigFactory;
        String clusterAlias,
        final Settings indexSettings = this.indexSettings.getSettings();
            validate,
        return xContentRegistry;
            directoryFactory,
    final class AsyncReplicationTask extends BaseAsyncTask {
            try {
                }
                this.indexSortSupplier = () -> indexSettings.getIndexSortConfig()
                if (indexShard != null) {
            if (indexSettings.getIndexSortConfig().hasIndexSort()) {
        if (closed.get()) {
    /**
            clusterDefaultRefreshIntervalSupplier,
import org.opensearch.index.query.SearchIndexNameMatcher;
        AsyncTrimTranslogTask(IndexService indexService) {
            if (path == null) {
                this.indexSettings,
    @Override
        assert Objects.nonNull(refreshTask);
        }
            if (shardLevelRefreshEnabled == false) {
    }
    }
        }
        Store remoteStore = null;
                    shard.fieldData().onRemoval(shardId, fieldName, wasEvicted, sizeInBytes);
            eventListener.onStoreCreated(shardId);
        metadataListeners.add(listener);
        BooleanSupplier allowExpensiveQueries,
                }
                refreshMutex,
                                if (e instanceof AlreadyClosedException == false
     * @return the refresh interval.
            remoteStoreStatsTrackerFactory,
                        this.indexSettings,
            try {
    private void stopShardLevelRefreshTasks() {
    public IndexMetadata getMetadata() {
        @Override
                        nodeCacheService
    // this setting is intentionally not registered, it is only used in tests
        }
            // TODO : Need to remove this check after support for hot indices is added in Composite Directory
            protected void doRun() throws Exception {
    private final RecoverySettings recoverySettings;
            return -1L;
    @PublicApi(since = "1.0.0")
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
    public IndexAnalyzers getIndexAnalyzers() {
        final IndexShard indexShard;
                indicesFieldDataCache,
     */
import org.opensearch.common.unit.TimeValue;
            fsyncTask.updateIfNeeded();
    }
        /*
        IndexAnalyzers indexAnalyzers,
import org.opensearch.index.cache.query.QueryCache;
            try {
            }
                    throw new IllegalStateException(
    ) {
        for (IndexShard shard : this.shards.values()) {
                    + "] "
        String clusterAlias,
                checksumStrategies,
                // TODO: Remove this once remote to docrep migration is supported
import static java.util.Collections.unmodifiableMap;
import org.opensearch.index.engine.EngineFactory;
                        threadPool
import org.opensearch.cluster.node.DiscoveryNode;
            throw new IllegalStateException(shardId + " already exists");
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier,
    private final IndexStorePlugin.CompositeDirectoryFactory compositeDirectoryFactory;
    private volatile boolean shardLevelRefreshEnabled;
                        ? getAvgShardSizeInBytes()
            logger.warn(() -> new ParameterizedMessage("failed to write dangling indices state for index {}", index()), e);
        @Override
    List<IndexingOperationListener> getIndexOperationListeners() { // pkg private for testing
                    ShardPath.deleteLeftoverShardDirectory(logger, nodeEnv, lock, this.indexSettings);
                return true;
                    startShardLevelRefreshTasks();
    public String indexUUID() {
import org.opensearch.common.Nullable;
        void addPendingDelete(ShardId shardId, IndexSettings indexSettings);
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
        final RepositoriesService repositoriesService,
        protected void runInternal() {
     *
    /**
            } finally {
                discoveryNodes,
    }
    }
                // When an instance of Store is created, a shardlock is created which is released on closing the instance of store.
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
        }
                    remoteStoreLock,
                            }, ThreadPool.Names.SAME, source + " sync");
        this.indexingOperationListeners = Collections.unmodifiableList(indexingOperationListeners);
        } catch (ShardLockObtainFailedException e) {
            );
                try {
    }
import java.util.Objects;
    private final IndexerFactory indexerFactory;
     */
            throw new IOException("failed to obtain in-memory shard lock", e);
                retentionLeaseSyncer,
                similarityService,
                // Disallow shards with remote store based settings to be created on non-remote store enabled nodes
        int count = 0;
                directoryFactory,
            this.bitsetFilterCache = new BitsetFilterCache(indexSettings, indicesBitsetFilterCache, new BitsetCacheListener(this));
        @Override
                } catch (IOException ex) {
            && indexCreationContext == IndexCreationContext.CREATE_INDEX); // metadata verification needs a mapper service
        DiscoveryNodes discoveryNodes,
        @Override
    public synchronized void close(final String reason, boolean delete) throws IOException {
            boolean seedRemote = false;
            this.indexFieldData = null;
                        nodeCacheService != null ? nodeCacheService.fileCache() : null,
            null,
    public synchronized IndexShard createShard(
    public Supplier<Sort> getIndexSortSupplier() {
     * Passing a {@code null} {@link IndexSearcher} will return a valid context, however it won't be able to make
    abstract static class BaseAsyncTask extends AbstractAsyncTask {
    }
        RemoteStoreSettings remoteStoreSettings,
                for (String field : fields) {
                    trimTranslogTask,
        }
        return false == (indexSettings.getIndexMetadata().getState() == IndexMetadata.State.CLOSE
        this.replicator = replicator;
                        this.indexSettings.getRemoteStoreSegmentPathPrefix(),
            rescheduleIfNecessary();
        final Settings indexSettings = this.getIndexSettings().getSettings();
                .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
                        try {
                    indexFieldData.clearField(field);
                indexFieldData.clear();
                    if (curCount == null) {
    }
    private volatile AsyncReplicationTask asyncReplicationTask;
                    } catch (Exception e) {
        if (mapperService == null) {
import java.util.function.Function;
        public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
    private TimeValue getRefreshInterval() {
        final RetentionLeaseSyncer retentionLeaseSyncer,
        final Consumer<ShardId> globalCheckpointSyncer,
        ShardLock lock = null;
        return mapperService.updateMapping(currentIndexMetadata, newIndexMetadata);
        BaseAsyncTask(final IndexService indexService, final TimeValue interval, Supplier<Boolean> fixedIntervalSchedulingEnabled) {
        ValuesSourceRegistry valuesSourceRegistry,
                circuitBreakerService,
        METADATA_VERIFICATION
    // NOTE: O(numShards) cost, but numShards should be smallish?
     */
import org.opensearch.index.seqno.RetentionLeaseSyncer;
        ScriptService scriptService,
                // Currently, we create 2 instances of store for remote store backed indices: store and remoteStore.
                Map<DataFormat, StoreStrategy> storeStrategies = dataFormatRegistry.getStoreStrategies(this.indexSettings);
            valuesSourceRegistry,
 * GitHub history for details.
        return indexCache;
    /**
                    path,
    // Visible for test
import java.util.concurrent.atomic.AtomicBoolean;
        MapperRegistry mapperRegistry,
                    + newSettingsVersion
        long sum = 0;
            super(indexService, indexService.getRefreshInterval(), fixedRefreshIntervalSchedulingEnabled);
        this.expressionResolver = expressionResolver;
        MergedSegmentWarmerFactory mergedSegmentWarmerFactory,
        }
        }
                }
                switch (shard.state()) {
                } else {
    }
                    e
     * Creates a new QueryShardContext.
                if (indexHasRemoteStoreSettings(indexSettings)) {
        IndexShard indexShard = null;
                        shardId,
        IndexStorePlugin.StoreFactory storeFactory,
                if (shard.isPrimaryMode() && shard.routingEntry().active()) {
      For a remote snapshot index, the cache path is used to initialize the shards.
        }
        protected void runInternal() {
    private final Function<ShardId, ReplicationStats> segmentReplicationStatsProvider;
                    dataPathToShardCount.put(dataPath, curCount + 1);
            fsyncTask = new AsyncTranslogFSync(this);
        IndexStorePlugin.StoreFactory storeFactory,
import org.opensearch.index.analysis.IndexAnalyzers;
        protected boolean shouldRun() {
            fixedRefreshIntervalSchedulingEnabled,
                    indexFieldData.clearField(field);
            keywordIndexOrDocValuesEnabled
        final ShardId shardId = routing.shardId();
        BooleanSupplier idFieldDataEnabled,
        }
    public boolean clearCaches(boolean queryCache, boolean fieldDataCache, String... fields) {
     * <p>
        public String toString() {
                if (shard != null) {
                    @Override
import org.opensearch.common.util.FeatureFlags;
        CircuitBreakerService circuitBreakerService,
                remoteStore,
        @Override
                    } catch (IndexShardClosedException | AlreadyClosedException ex) {
    AsyncTrimTranslogTask getTrimTranslogTask() { // for tests
package org.opensearch.index;
        return this.eventListener;
    public synchronized void writeDanglingIndicesInfo() {
            this.indexService = indexService;
     * Creates a new QueryShardContext.
                // Warm + format-aware: create StoreStrategyRegistry here so we can
    private final BooleanSupplier allowExpensiveQueries;
                // keeping this defensive check in place
 * ownership. Elasticsearch licenses this file to you under
    private volatile AsyncRefreshTask refreshTask;
        }
                // The sort order is validated right after the merge of the mapping later in the process.
    private final List<IndexingOperationListener> indexingOperationListeners;
        throw new UnsupportedOperationException("Engine Factory doesn't exist for current index.");
                    try {
        protected final IndexService indexService;
        IndexAnalyzers indexAnalyzers,
    }
                    throw e;
        }
        return recoveryStateFactory.newRecoveryState(shardRouting, targetNode, sourceNode);
        ShardStoreDeleter shardStoreDeleter,
                            // the shard was closed concurrently, continue
                    fsyncTask.close();
            count++;
                        logger.info("DocRep shard {} is migrating to remote", shardId);
        try {
                // allocation level,
        }
        @Nullable DiscoveryNode sourceNode,
                    try {
            this.globalCheckpointTask = new AsyncGlobalCheckpointTask(this);
    }
            return indexService.closed.get() == false
    /**
        this.asyncPublishReferencedSegmentsTask = new AsyncPublishReferencedSegmentsTask(this);
            logger.debug("creating shard_id {}", shardId);
                } catch (IOException e) {
                    }
        for (IndexShard shard : this.shards.values()) {
    }
import org.opensearch.index.shard.ShardPath;
    public IndexCache cache() {
        AsyncTranslogFSync(IndexService indexService) {
            expressionResolver
        } finally {
import org.opensearch.core.xcontent.NamedXContentRegistry;
            client,
                        shard.trimTranslog();
        return indexSettings.getIndexMetadata();
        QueryCache queryCache,
                try {
                        startIndexLevelRefreshTask();
                if (lock != null) {
        synchronized (refreshMutex) {
import org.opensearch.index.shard.SearchOperationListener;
                    + "]";
            clearedAtLeastOne = true;
            throw new IllegalStateException("Can't create shard " + routing.shardId() + ", closed");
            } else {
                    eventListener.afterIndexShardDeleted(lock.getShardId(), indexSettings.getSettings());
            final Engine.Warmer engineWarmer = (reader) -> {
    }
        }
     * @opensearch.api
                Map<Path, Integer> dataPathToShardCount = new HashMap<>();
    /**
    private final RemoteStoreSettings remoteStoreSettings;
                        storeStrategyRegistry,
            return NativeStoreRepository.EMPTY;
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig,
        return null;
/*
                if (shard != null) {
import org.opensearch.index.similarity.SimilarityService;
    private final NodeCacheService nodeCacheService;
        this.recoverySettings = recoverySettings;
import org.opensearch.gateway.MetadataStateFormat;
    public ThreadPool getThreadPool() {
            return "global_checkpoint_sync";
    private void onShardClose(ShardLock lock) {
                this.indexSettings.isSegRepEnabledOrRemoteNode() ? checkpointPublisher : null,
                        : routing.getExpectedShardSize(),
                shardStoreDeleter.addPendingDelete(lock.getShardId(), indexSettings);
            indexService.maybeTrimTranslog();
                    );
import org.opensearch.index.fielddata.IndexFieldDataService;
    private void startIndexLevelRefreshTask() {
        }
     * <p>
    private final IndexStorePlugin.DirectoryFactory directoryFactory;
        }
            if (currentSettingsVersion == newSettingsVersion) {
            checkpointPublisher,
    public void onDefaultMaxMergeOrThreadCountUpdate(int maxThreadCount, int maxMergeCount) {
import org.opensearch.common.annotation.InternalApi;
        }
     */
            indexService.maybeFSyncTranslogs();
                indexFieldData,
            }
        public String toString() {
    /**
        boolean shardLevelRefreshEnabled,
            if (fields.length == 0) {
        } finally {
                    if (sourceNode == null || sourceNode.isRemoteSegmentStoreNode() == false) {
        }
    private final IndexFieldDataService indexFieldData;
 */
            routing,
import org.opensearch.repositories.NativeStoreRepository;
            indexService.maybeRefreshEngine(false);
            } catch (Exception e) {
                assert updateIndexSettings;
import org.opensearch.index.shard.IndexShard;
            clusterService,
        }
            return "publish_primary_referenced_segments";
                startIndexLevelRefreshTask();
                StoreStrategyRegistry storeStrategyRegistry = null;
     *
        for (IndexShard indexShard : this) {
        @Override
        @Override
        final IndexService indexService;
    }
    private final ClusterService clusterService;
                try {
                boolean shouldWidenIndexSortType = this.indexSettings.shouldWidenIndexSortType();
                    case STARTED:
    }
        this.indexerFactory = Objects.requireNonNull(indexerFactory);
        for (IndexShard shard : this.shards.values()) {
 * KIND, either express or implied.  See the License for the
        for (final IndexShard shard : this.shards.values()) {
    public TimeValue getRefreshTaskInterval() {
/*
            }
        ShardPath path;
            }
            sourceNode,
                        }
        shards = unmodifiableMap(newShards);
            null
        @Override
    @InternalApi
                threadPool,
                segmentReplicationStatsProvider,
            }
        BigArrays bigArrays,
                        shardId,
     */
    }
            mapperService(),
    }
                        // Do nothing for shard lock on remote store
      Fetches the shard path based on the index type -
                // As part of https://github.com/opensearch-project/OpenSearch/issues/13075, we want to move away from keeping 2
    }
    private final BitsetFilterCache bitsetFilterCache;
                fsyncTask = null;
    ) throws IOException {
        this.similarityService = similarityService;
    private final MapperService mapperService;
        return indexShard;
import org.opensearch.common.CheckedFunction;
        new TimeValue(0, TimeUnit.MILLISECONDS),
        return shardLevelRefreshEnabled;
            );
        threadPool.executor(ThreadPool.Names.REFRESH).execute(new AbstractRunnable() {
        }
    private final ScriptService scriptService;
    private class StoreCloseListener implements Store.OnClose {
    }
                // ToDo: remove the isPluggableDataFromatEnabled check once MergedSegment replication flow is integrated for DataFormatAware
     */
     * The {@link BigArrays} to use for this index.
        LongSupplier nowInMillis,
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
            indexCreationContext,
        }
        this.namedWriteableRegistry = namedWriteableRegistry;
            throw new ShardNotFoundException(new ShardId(index(), shardId));
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
                    nodeEnv,
                assert updateIndexSettings == false;
        return fsyncTask;
 * this work for additional information regarding copyright
        if (indexerFactory instanceof EngineBackedIndexerFactory) {
    }
            );
                        (RemoteSegmentStoreDirectory) remoteDirectory,
        Supplier<Integer> clusterDefaultMaxMergeAtOnce,
        protected boolean mustReschedule() {
                        (RemoteSegmentStoreDirectory) remoteDirectory,
                && indexService.indexSettings.getIndexMetadata().getState() == IndexMetadata.State.OPEN;
                } catch (IndexShardClosedException | AlreadyClosedException ex) {
        for (IndexShard shard : this.shards.values()) {
        AsyncRetentionLeaseSyncTask(final IndexService indexService) {
            );
        return clearedAtLeastOne;
            return (indexSettings.isSegRepLocalEnabled() || indexSettings.isRemoteStoreEnabled())
 * The main OpenSearch index service
                    shardId,
                    try {
}
                    indexCache,
            null,
    /**
        public void onCache(ShardId shardId, Accountable accountable) {
                circuitBreakerService,
        // kick off async ops for the first shard in this index
     */
        closeShard(reason, sId, indexShard, indexShard.store(), indexShard.getIndexEventListener());
                // call this before we close the store, so we can release resources for it
                        if (routing.primary() == false) {
                    continue;
                    // Will be enabled in case of formatAware indices.
                for (String field : fields) {
    }
import org.opensearch.core.Assertions;
        }
        }
        this.readerWrapper = wrapperFactory.apply(this);
                indexSettings,
        this.directoryFactory = directoryFactory;
    private void startShardLevelRefreshTasks() {
        }
    private final ShardStoreDeleter shardStoreDeleter;
                () -> globalCheckpointSyncer.accept(shardId),
import static java.util.Collections.emptyMap;
import org.opensearch.repositories.RepositoriesService;
        }
    // method is synchronized so that IndexService can't be closed while we're deleting dangling indices information
            allowExpensiveQueries,
            if (shouldRun()) {
    private final BigArrays bigArrays;
        if (dataFormatAwareStoreDirectoryFactory != null) {
                case CREATED:
                    case CREATED:
        }
                    }
    }
                            throw new IllegalStateException("Can't migrate a remote shard to replica before primary " + routing.shardId());
 * specific language governing permissions and limitations
    /**
    public void onRefreshIntervalChange() {
    private void updateReplicationTask() {
                // Only the primary shard publish referenced segments.
                    + currentSettingsVersion
            }
    private final IndexNameExpressionResolver expressionResolver;
                                }
         * keep it synced.
        @Override
    private final DataFormatRegistry dataFormatRegistry;
            return ThreadPool.Names.REFRESH;
        logger.debug("No DataFormatAwareStoreDirectoryFactory available, Store will handle internal creation for: {}", shardPath);
        }
        @Override
            if (this.indexSettings.isPluggableDataFormatEnabled() && dataFormatRegistry != null) {
    private void maybeTrimTranslog() {
        refreshInterval = getRefreshInterval();
            if (shardId != null) {
import org.opensearch.core.index.shard.ShardId;
                                    && e instanceof ShardNotInPrimaryModeException == false) {
            deleted.compareAndSet(false, delete);
            sum += indexShard.store().stats(0L).sizeInBytes();
                directoryFactory
    }
    }
                    () -> new ParameterizedMessage("[{}] failed to delete shard content - scheduled a retry", lock.getShardId().id()),
        return shards.containsKey(shardId);
                        nativeStore,
        return asyncReplicationTask;
        this.compositeDirectoryFactory = compositeDirectoryFactory;
                    stopShardLevelRefreshTasks();
        indexSettings.setDefaultAutoThrottleEnabled(enabled);
        if (needsMapperService(indexSettings, indexCreationContext)) {
        IndexSettings indexSettings,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        } else {
        return compositeIndexSettings;
/**
                        startShardLevelRefreshTasks();
        if (indexSettings.getTranslogDurability() == Translog.Durability.REQUEST) {
        MergedSegmentPublisher mergedSegmentPublisher,
    }
            }
            return;
import org.opensearch.plugins.NativeStoreHandle;
import org.opensearch.index.store.FormatChecksumStrategy;
    ) throws IOException {
            }
                        removeShard(shardId, reason);
import org.opensearch.index.query.QueryShardContext;
        return mapperService;
        RecoverySettings recoverySettings,
     */
        }
        this.indexSettings = indexSettings;
            super(indexService.logger, indexService.threadPool, interval, true, fixedIntervalSchedulingEnabled);
        this.scriptService = scriptService;
        StoreCloseListener(ShardId shardId, Closeable... toClose) {
      For a local index, a local shard path is loaded or a new path is calculated.
            return "refresh";
        ClusterService clusterService,
        int shardId,
            s -> {},
    }
            super(indexService, GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.get(indexService.getIndexSettings().getSettings()));
        }
    private volatile AsyncPublishReferencedSegmentsTask asyncPublishReferencedSegmentsTask;
        IndexNameExpressionResolver expressionResolver,
    private final AtomicBoolean deleted = new AtomicBoolean(false);
import org.opensearch.index.store.Store;
        if (updateIndexSettings) {
        assert Thread.holdsLock(refreshMutex);
                    }
                readerWrapper,
            indexerFactory,
        if (getRefreshInterval().millis() > 0 || force) {
    @PublicApi(since = "1.0.0")
        assert Thread.holdsLock(refreshMutex);
        indexShard = newShards.remove(shardId);
        IndexSearcher searcher,
    /*
        }
        BooleanSupplier idFieldDataEnabled,
        @Override
    public SimilarityService similarityService() {
                final IndexShard shard = getShardOrNull(shardId.id());
                clusterMergeSchedulerConfig.getClusterMaxMergeCount()
     * Background task that syncs the global checkpoint to replicas.
import org.opensearch.script.ScriptService;
        IndexEventListener eventListener,
            }
    // Visible for testing
                        storeStrategies,
    ) throws IOException {
    private ShardPath getShardPath(ShardRouting routing, ShardId shardId, ShardLock lock) throws IOException {
            // index.global_checkpoint_sync_interval is not a real setting, it is only registered in tests
    }
            repositoriesService,
                    remoteStore.close();
    final class AsyncRefreshTask extends BaseAsyncTask {
        FieldDataCacheListener(IndexService indexService) {
import org.opensearch.indices.recovery.RecoveryState;
            recoveryStateFactory,
     * {@link IndexReader}-specific optimizations, such as rewriting containing range queries.
        ThreadPool threadPool,
                    refreshTask,
import java.io.Closeable;
            logger.debug("Using DataFormatAwareStoreDirectoryFactory to create directory for shard path: {}", shardPath);
            return ThreadPool.Names.GENERIC;
            final long newSettingsVersion = newIndexMetadata.getSettingsVersion();
import org.opensearch.index.mapper.MapperService;
        // The refresh task is expected to be non-null at this point.
    private final NamedWriteableRegistry namedWriteableRegistry;
                        final boolean flushEngine = deleted.get() == false && closed.get();
    private final AsyncTrimTranslogTask trimTranslogTask;
    private final AtomicBoolean closed = new AtomicBoolean(false);
            }
        }
import org.opensearch.common.annotation.PublicApi;
        IndexCreationContext indexCreationContext,
            asyncReplicationTask.close();
                dataFormatRegistry
        }
    }
import org.opensearch.index.shard.IndexingOperationListener;
        final ShardId sId = new ShardId(index(), shardId);
        synchronized (refreshMutex) {
                try {
     * Called when the cluster level settings: {@code cluster.default.index.merge.scheduler.max_merge_count} OR
        @Override
        this.dataFormatAwareStoreDirectoryFactory = dataFormatAwareStoreDirectoryFactory;
        this.engineConfigFactory = Objects.requireNonNull(engineConfigFactory);
    AsyncPublishReferencedSegmentsTask getPublishReferencedSegmentsTask() {
                    default:
    private void stopIndexLevelRefreshTask() {
        @Override
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
            IndexMetadata.FORMAT.writeAndCleanup(getMetadata(), nodeEnv.indexPaths(index()));
            indexCache.bitsetFilterCache(),
        private final Closeable[] toClose;
        }
                assert lock.getShardId().equals(shardId) : "shard id mismatch, expected: " + shardId + " but got: " + lock.getShardId();
                    long ramBytesUsed = accountable != null ? accountable.ramBytesUsed() : 0L;
                if (shard != null) {
        }
                indexAnalyzers,
    private final Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled;
            }
        protected String getThreadPool() {
            return ThreadPool.Names.FLUSH;
    private void maybeSyncSegments(boolean force) {
     * Gets the refresh interval seen by the index service. Index setting overrides takes the highest precedence.
                    shardId,
            path = ShardPath.loadFileCachePath(nodeEnv, shardId);
                }
            this.indexCache = null;
    @Override
    private NativeStoreRepository resolveNativeStore(RepositoriesService repositoriesService) {
                        continue;
import org.opensearch.indices.ClusterMergeSchedulerConfig;
 */
                try {
            clusterAlias,
                && this.indexSettings.isWarmIndex()
            namedWriteableRegistry,
                final IndexShard shard = indexService.getShardOrNull(shardId.id());
        }
            recoverySettings,
    }
        SimilarityService similarityService,
        final SearchIndexNameMatcher indexNameMatcher = new SearchIndexNameMatcher(
                }
     * Called whenever the cluster level {@code cluster.default.index.max_merge_at_once} changes.
    private final class FieldDataCacheListener implements IndexFieldDataCache.Listener {
        try {
        if (shards.containsKey(shardId) == false) {
            success = true;
import java.util.function.Supplier;
        }
    @Override
    }
        final Consumer<ShardId> globalCheckpointSyncer,
                }
                }
        boolean shardLevelRefreshEnabled,
        public String toString() {
    }
                .getSettings()
    private final CompositeIndexSettings compositeIndexSettings;
            return "retention_lease_sync";
                indexSortSupplier,
        this.remoteDirectoryFactory = remoteDirectoryFactory;
        } finally {
    ) {
import org.opensearch.index.cache.IndexCache;
                    );
import org.opensearch.indices.cluster.IndicesClusterStateService;
        refreshTask = new AsyncRefreshTask(this);
                    } catch (Exception e) {
import org.opensearch.cluster.node.DiscoveryNodes;
                }
            return ((EngineBackedIndexerFactory) indexerFactory).getEngineFactory();
            for (IndexShard shard : this.shards.values()) {
import org.apache.lucene.search.IndexSearcher;
     * 1. {@code cluster.default.index.refresh_interval} cluster setting changes. The change would only happen for
                        // only flush if we are closed (closed index or shutdown) and if we are not deleted
            }
                // The following method provides ShardLock that is not maintained by NodeEnvironment.
            Store remoteStore = null;
                    IOUtils.close(toClose);
        }
        final DiscoveryNode targetNode,
                } catch (IndexShardClosedException | AlreadyClosedException ex) {
        return newQueryShardContext(shardId, searcher, nowInMillis, clusterAlias, validate, false);
    public MapperService mapperService() {
     * Shard Store Deleter Interface
import java.io.IOException;
        final ShardRouting routing,
        List<IndexingOperationListener> indexingOperationListeners,
        indexSettings.setDefaultMaxThreadAndMergeCount(maxThreadCount, maxMergeCount);
                } else {
            lock = nodeEnv.shardLock(shardId, "starting shard", TimeUnit.SECONDS.toMillis(5));
                idFieldDataEnabled,
        metadataListeners.forEach(c -> c.accept(newIndexMetadata));
            return indexService.closed.get() == false;
        }
        @Override
        private final ShardId shardId;
            }
            circuitBreakerService,
                    );
    public boolean updateMapping(final IndexMetadata currentIndexMetadata, final IndexMetadata newIndexMetadata) throws IOException {
    }
        DiscoveryNodes discoveryNodes,
        final RetentionLeaseSyncer retentionLeaseSyncer,
                    protected void closeInternal() {
     */
            } catch (IOException e) {
                path = ShardPath.selectNewPathForShard(
            Map<DataFormat, NativeStoreHandle> dataformatAwareStoreHandles = Map.of();
    boolean isShardLevelRefreshEnabled() {
    final IndexStorePlugin.DirectoryFactory getDirectoryFactory() {
     */
                    throw ex;
                    routing.getExpectedShardSize() == ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE
                if (shard != null) {
        RecoverySettings recoverySettings,
            return;
            }
import org.opensearch.index.engine.Engine;
 *
                    directory = createDataFormatAwareStoreDirectory(shardId, path, checksumStrategies);
            if (shard.routingEntry().active() && shard.routingEntry().primary()) {
            null,
     * @opensearch.internal
            expressionResolver,
                        path,
        public String toString() {
            } else {
        if (getIndexSettings().getPublishReferencedSegmentsInterval().equals(asyncPublishReferencedSegmentsTask.getInterval())) {
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
        if (fieldDataCache) {
            similarityService,
        }
    }
        BooleanSupplier allowExpensiveQueries,
            return indexShard;
            indexAnalyzers,
                checksumStrategies = dataFormatRegistry.createChecksumStrategies(this.indexSettings);
    public static final Setting<TimeValue> RETENTION_LEASE_SYNC_INTERVAL_SETTING = Setting.timeSetting(
        }
                        checksumStrategies,
        if (closed.get()) {
            null,
                        () -> new ParameterizedMessage("[{}] failed to notify shard about setting change", shard.shardId().id()),
            if (newInterval.equals(getInterval()) == false) {
        boolean validate
    /**
        // visible for tests
            targetNode,
                logger.warn("{} failed to load shard path, trying to remove leftover", shardId);
    private volatile AsyncGlobalCheckpointTask globalCheckpointTask;
 * software distributed under the License is distributed on an
    }
            }
        int shardId,
 *    http://www.apache.org/licenses/LICENSE-2.0
                && recoverySettings.isMergedSegmentReplicationWarmerEnabled()
        // once we change the refresh interval we schedule yet another refresh
     * Passing a {@code null} {@link IndexSearcher} will return a valid context, however it won't be able to make
            }
            null,
     * @param repositoriesService the repositories service, may be {@code null}
                    shard.fieldData().onCache(shardId, fieldName, ramUsage);
        this.eventListener = eventListener;
        return indexingOperationListeners;
    public NamedXContentRegistry xContentRegistry() {
                    shard.onSettingsChanged();
            retentionLeaseSyncer,
    private final Object refreshMutex = new Object();
        return indexSortSupplier;
        @Override
            this.warmer = null;
            idFieldDataEnabled,
            similarityService(),
    @Override
                } catch (Exception e) {
                // This creates an issue when we are deleting the index as it results in closing both store and remoteStore.
            indexCache.query().clear("api");
        ClusterService clusterService,
    }
        boolean clearedAtLeastOne = false;
                        nodeCacheService != null ? nodeCacheService.fileCache() : null,
            } catch (IOException ex) {
    final class AsyncPublishReferencedSegmentsTask extends BaseAsyncTask {
                for (IndexShard shard : this) {
            try {
 *
        Store store = null;
        protected void runInternal() {
    final class AsyncGlobalCheckpointTask extends BaseAsyncTask {
                        indexShard.close(reason, flushEngine, deleted.get());
            if (targetNode.isRemoteSegmentStoreNode()) {
                    remoteDirectory = remoteDirectoryFactory.newDirectory(this.indexSettings, path);
 * not use this file except in compliance with the License.
                    if (shard.routingEntry().isSearchOnly() && shard.routingEntry().active()) {
        MapperRegistry mapperRegistry,
        return shards.size();
        new TimeValue(30, TimeUnit.SECONDS),
    } // pkg private for testing
                mergedSegmentWarmerFactory,
                        this.indexSettings.getUUID(),
        try {
    /**
                lock,
                    logger.warn("failed to sync translog", e);
            searchOperationListeners,
        }
                if (store != null) {
import org.opensearch.index.engine.dataformat.StoreStrategy;
                // Even though we have `RemoteStoreMigrationAllocationDecider` in place to prevent something like this from happening at the
        }
    public synchronized void deleteDanglingIndicesInfo() {
                try {
    }
        Client client,
import org.opensearch.index.engine.exec.IndexerFactory;
                    case CLOSED:
                    dataformatAwareStoreHandles = storeStrategyRegistry.getFormatStoreHandles();
            } else {
            for (IndexShard shard : this.shards.values()) {
            allowExpensiveQueries,
            valuesSourceRegistry,
                && this.indexSettings.isPluggableDataFormatEnabled()
            (shardId) -> ReplicationStats.empty(),
                listener.afterIndexShardClosed(sId, indexShard, indexSettings);
import java.util.Set;
            clusterService,
        if (refreshInterval.equals(getRefreshInterval())) {
    public CompositeIndexSettings getCompositeIndexSettings() {
                // store instances.
        }
            engineConfigFactory,
        IndexShard indexShard = getShardOrNull(shardId);
                    stopIndexLevelRefreshTask();
                    try {
    final class AsyncTrimTranslogTask extends BaseAsyncTask {
        } else if (fsyncTask == null) {
            // don't re-schedule if the IndexService instance is closed or if the index is closed
        Property.Dynamic,
                if (remoteStore != null && indexShard.isPrimaryMode() && deleted.get()) {
                    // fine - continue;
    public void onDefaultAutoThrottleEnabledUpdate(boolean enabled) {
        final IndexService indexService;
    private void closeShard(String reason, ShardId sId, IndexShard indexShard, Store store, IndexEventListener listener) {
import org.opensearch.index.shard.IndexEventListener;
            this.shardId = shardId;
        }
        final boolean updateIndexSettings = indexSettings.updateIndexMetadata(newIndexMetadata);
        if (repoName == null || repositoriesService == null) {
            return ThreadPool.Names.GENERIC;
    static boolean needsMapperService(IndexSettings indexSettings, IndexCreationContext indexCreationContext) {
        }
        @Override
    }
            this.indexCache = new IndexCache(indexSettings, queryCache, bitsetFilterCache);
                    }
     */
                () -> newQueryShardContext(0, null, System::currentTimeMillis, null),
    private final ThreadPool threadPool;
        logger.debug("[{}] closing... (reason: [{}])", shardId, reason);
                case STARTED:
                // indices.
                if (this.indexSettings.isRemoteStoreEnabled()) {
        return refreshMutex;
     */
     */
    public BigArrays getBigArrays() {
                }
    }
                default:
                }
        protected boolean shouldRun() {
            return repositoriesService.repository(repoName).getNativeStore();
                IndexShard shard = getShardOrNull(shardId.getId());
                final IndexShard shard = indexService.getShardOrNull(shardId.id());
            } else if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_SETTING) &&
                IOUtils.close(
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
            this.retentionLeaseSyncTask = new AsyncRetentionLeaseSyncTask(this);
    }
        this.asyncReplicationTask = new AsyncReplicationTask(this);
    private final Supplier<Sort> indexSortSupplier;
    );
                );
            }
                } catch (AlreadyClosedException ex) {
        this.dataFormatRegistry = dataFormatRegistry;
        if (!indexSettings.getIndexMetadata().useIngestionSource()) {
            return indexSettings.isSegRepEnabledOrRemoteNode() && super.mustReschedule();
                    logger.trace("[{}] store not initialized prior to closing shard, nothing to close", shardId);
        refreshTask.close();
    }
        this.refreshInterval = getRefreshInterval();
                    throw new IllegalStateException("unknown state: " + shard.state());
                indexSettings,
            this.indexSortSupplier = () -> null;
                };
        if (getRefreshInterval().millis() > 0 || force) {
        }
        CircuitBreakerService circuitBreakerService,
                indexCache.clear("api");
        IndexStorePlugin.RecoveryStateFactory recoveryStateFactory,
        }
        super(indexSettings);
    private void maybeSyncGlobalCheckpoints() {
 * Modifications Copyright OpenSearch Contributors. See
                    + "to be less than new settings version ["
                } catch (Exception e) {
                shardLevelRefreshEnabled,
                    mapperService,
 */
                } else {
        });
        List<IndexingOperationListener> indexingOperationListeners,
                xContentRegistry,
     * This method centralizes the directory creation logic and enables plugin-based format discovery.
    }
        SimilarityService similarityService,
        if (indexShard == null) {
     * The {@link ThreadPool} to use for this index.
        if (clearedAtLeastOne == false) {
    }
            discoveryNodes,
    public int numberOfShards() {
                directory,
                    path = ShardPath.loadShardPath(logger, nodeEnv, shardId, this.indexSettings.customDataPath());
        // that are waiting for a refresh.
        private BitsetCacheListener(IndexService indexService) {
                assert currentSettingsVersion < newSettingsVersion : "expected current settings version ["
    /**
     *
        public void accept(ShardLock lock) {
     * @return a live native store or {@link NativeStoreRepository#EMPTY}
                fixedRefreshIntervalSchedulingEnabled,
import org.opensearch.index.store.remote.filecache.NodeCacheService;
            this.toClose = toClose;
            }
 *
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
        ShardPath shardPath,
    public synchronized IndexShard createShard(
            }
    }
    }
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
            clusterAlias,
                        directoryFactory,
    }
        @Override
            indexingOperationListeners,
                mapperRegistry,
        protected String getThreadPool() {
        protected void runInternal() {
                    directory = directoryFactory.newDirectory(this.indexSettings, path);
     * Called whenever the cluster level {@code cluster.merge.scheduler.max_force_merge_mb_per_sec} changes.
        }
        }
            }
                    long ramBytesUsed = accountable != null ? accountable.ramBytesUsed() : 0L;
    }
                // As there can be only one shardlock acquired for a given shard, the lock is shared between store and remoteStore.
            ShardPath path = getShardPath(routing, shardId, lock);
    private void updateFsyncTaskIfNecessary() {
            Directory directory = null;
            this.mapperService = new MapperService(
                    case POST_RECOVERY:
            indexSettings.getMergeSchedulerConfig().setMaxForceMergeMBPerSec(maxForceMergeMBPerSec);
            store.beforeClose();
            remoteDirectoryFactory,
        this.circuitBreakerService = circuitBreakerService;
        IndexEventListener eventListener,
        ShardStoreDeleter shardStoreDeleter,
        IndexStorePlugin.RecoveryStateFactory recoveryStateFactory,
                searchOperationListeners,
     * Resolves the native object store for the index's remote store repository.
                if (fsyncTask != null) {
                final Set<Integer> shardIds = shardIds();
    }
        ReferencedSegmentsPublisher referencedSegmentsPublisher
        IndexStorePlugin.CompositeDirectoryFactory compositeDirectoryFactory,
    public IndexService(
     *
                    );
        }
            bigArrays,
            indexSettings,
                                    && e instanceof IndexShardClosedException == false
        @Nullable DiscoveryNode sourceNode,
            store = storeFactory.newStore(
    }
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
        this.storeFactory = storeFactory;
                } finally {
import java.util.Collections;
            if (shardId != null) {
            public boolean isForceExecution() {
    }
                    if (shard.isSyncNeeded()) {
        final int shardId = sId.id();
            shard.stopRefreshTask();
 * the Apache License, Version 2.0 (the "License"); you may
        IndexCreationContext indexCreationContext,
     */
        ScriptService scriptService,
        }
            }
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
    private volatile Map<Integer, IndexShard> shards = emptyMap();
    }
        return similarityService;
        protected boolean mustReschedule() {
                        path,
            indexSettings,
                threadPool
        this.trimTranslogTask = new AsyncTrimTranslogTask(this);
import org.apache.logging.log4j.message.ParameterizedMessage;
    // don't convert to Setting<> and register... we only set this in tests and register via a plugin
     */
import org.apache.lucene.util.Accountable;
                );
                indicesBitsetFilterCache != null ? indicesBitsetFilterCache.createListener(threadPool) : null
     */
        return shards.keySet();
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
            clusterMergeSchedulerConfig,
        return directoryFactory;
            asyncReplicationTask = new AsyncReplicationTask(this);
        }
        synchronized (refreshMutex) {
import org.opensearch.storage.directory.StoreStrategyRegistry;
                    shard.publishReferencedSegments();
            shards = newMapBuilder(shards).put(shardId.id(), indexShard).immutableMap();
        Consumer<IndexShard> replicator,
                }
    public QueryShardContext newQueryShardContext(int shardId, IndexSearcher searcher, LongSupplier nowInMillis, String clusterAlias) {
            try {
                indexService,
import org.opensearch.index.translog.Translog;
                && indexSettings.isPluggableDataFormatEnabled() == false;
        return shards.get(shardId);
            indexShard = new IndexShard(
            MetadataStateFormat.deleteMetaState(nodeEnv.indexPaths(index()));
        @Override
     *
        try {
                    case RECOVERING:
        @Override
        this.fixedRefreshIntervalSchedulingEnabled = fixedRefreshIntervalSchedulingEnabled;
            return indexSettings.isSegRepEnabledOrRemoteNode() && super.mustReschedule();
            switch (shard.state()) {
    private final String INDEX_TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING = "index.translog.retention.check_interval";
            if (shardLevelRefreshEnabled) {
        @Override
import org.opensearch.cluster.service.ClusterService;
                if (shard != null) {
            globalCheckpointSyncer,
    private static final class BitsetCacheListener implements BitsetFilterCache.Listener {
            }
import org.opensearch.indices.recovery.RecoverySettings;
    private final IndexStorePlugin.StoreFactory storeFactory;
        protected boolean mustReschedule() {
            this.warmer = new IndexWarmer(
                    // fine - continue;
        public String toString() {
                                    logger.warn(new ParameterizedMessage("{} failed to execute {} sync", shard.shardId(), source), e);
            if (shardId != null) {
    private volatile TimeValue refreshInterval;
            }
        return refreshTask;
    public void onClusterLevelForceMergeMBPerSecUpdate(double maxForceMergeMBPerSec) {
                indexService.getIndexSettings()
    private void syncRetentionLeases() {
 */
        }
/*
        }
                    directoryFactory
     * This method is called when the refresh level is changed from index level to shard level or vice versa.
        @Override
import java.util.concurrent.CopyOnWriteArrayList;
        // to ensure we are in a clean and predictable state.
    private final IndexSettings indexSettings;
        IndexStorePlugin.DirectoryFactory directoryFactory,
                        threadPool
        @Override
        }
            if (shardId != null) {
import org.opensearch.indices.RemoteStoreSettings;
    // visible for tests
                    ex.addSuppressed(inner);
    public IndexService(
                logger.warn(
                // The refresh mode has changed from index level to shard level and vice versa
            shard.startRefreshTask();
    /**
                        curCount = 0;
            super(indexService, indexService.getIndexSettings().getPublishReferencedSegmentsInterval());
    private void maybePublishReferencedSegments() {
            nodeEnv,
                        logger.warn("failed to close shard", e);
     * <p>
                );
            }
            queryCache,
    AsyncRefreshTask getRefreshTask() { // for tests
        return bigArrays;
        // initialize this last -- otherwise if the wrapper requires any other member to be non-null we fail with an NPE
        }
            } else {
        this.threadPool = threadPool;
                }
            shardLevelRefreshEnabled,
            clusterDefaultMaxMergeAtOnce,
            store.setDataformatAwareStoreHandles(dataformatAwareStoreHandles);
        return newQueryShardContext(shardId, searcher, nowInMillis, clusterAlias, false);
    public Object getRefreshMutex() {
import java.util.HashMap;
        Objects.requireNonNull(retentionLeaseSyncer);
            xContentRegistry,
        BaseAsyncTask(final IndexService indexService, final TimeValue interval) {
                boolean prevShardLevelRefreshVal = this.shardLevelRefreshEnabled;
                this.indexSettings.isWarmIndex()) {
                        stopShardLevelRefreshTasks();
                    indexFieldData,
        this.recoveryStateFactory = recoveryStateFactory;
    private void updatePublishReferencedSegmentsTask() {
import org.opensearch.env.NodeEnvironment;
        refreshTask = null;
    List<SearchOperationListener> getSearchOperationListener() { // pkg private for testing
        protected void runInternal() {
    public boolean hasShard(int shardId) {
                    this.indexSettings,
        protected boolean mustReschedule() {
    private volatile AsyncTranslogFSync fsyncTask;
    @Override
        Property.Dynamic,
        Property.IndexScope
                }
        } catch (RepositoryMissingException e) {
                    logger.warn(
            indexService.maybeSyncGlobalCheckpoints();
        // docs to become visible immediately. This also flushes all pending indexing / search requests
                try {
    private void maybeFSyncTranslogs() {
     * The {@link ScriptService} to use for this index.
import org.opensearch.common.settings.Setting;
                        "[{" + routing.shardId() + "}] Cannot initialize shards with remote store index settings on non-remote store nodes"
        }
        protected void runInternal() {
    private volatile AsyncRetentionLeaseSyncTask retentionLeaseSyncTask;
                indexFieldData.clear();
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
     */
import java.util.function.BooleanSupplier;
        protected String getThreadPool() {
                        continue;
        if (indexShard != null) {
    public final IndexerFactory getIndexerFactory() {
        if (shards.containsKey(shardId.id())) {
import java.util.Map;
                }
            }
            index().getName(),
    // visible for tests
                    } finally {
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
        String repoName = this.indexSettings.getRemoteStoreRepository();
                store,
        } finally {
                logger.warn("forced refresh failed after interval change", e);
 * You may obtain a copy of the License at
            assert indexAnalyzers != null;
        @Override
            super(indexService, indexService.getIndexSettings().getTranslogSyncInterval());
                    }
            this.indexService = indexService;
            return dataFormatAwareStoreDirectoryFactory.newDataFormatAwareStoreDirectory(
            for (final IndexShard shard : this.shards.values()) {
                }
            }
                logger.debug("shard level refresh is disabled for index [{}]", indexSettings.getIndex().getName());
     * {@link IndexReader}-specific optimizations, such as rewriting containing range queries.
                        seedRemote = true;
import java.util.Iterator;
            asyncPublishReferencedSegmentsTask = new AsyncPublishReferencedSegmentsTask(this);
                    shard.shardBitsetFilterCache().onRemoval(ramBytesUsed);
     */
    private final CopyOnWriteArrayList<Consumer<IndexMetadata>> metadataListeners = new CopyOnWriteArrayList<>();
                    directory = compositeDirectoryFactory.newDirectory(
        List<SearchOperationListener> searchOperationListeners,
public class IndexService extends AbstractIndexComponent implements IndicesClusterStateService.AllocatedIndex<IndexShard> {
        rescheduleRefreshTasks();
        }
            if (this.shardLevelRefreshEnabled != newShardLevelRefreshVal) {
                clusterMergeSchedulerConfig.getClusterMaxThreadCount(),
                    }
import org.opensearch.index.fielddata.IndexFieldDataCache;
        NamedXContentRegistry xContentRegistry,
    public interface ShardStoreDeleter {
                    warmer.warm(reader, shard, IndexService.this.indexSettings);
            }
        QueryCache queryCache,
        }
        final DiscoveryNode targetNode,
        CREATE_INDEX,
    }
                }
@PublicApi(since = "1.0.0")
        this(
     * @opensearch.internal
    }
    /**
        "index.global_checkpoint_sync.interval",
    final CheckedFunction<DirectoryReader, DirectoryReader, IOException> getReaderWrapper() {
            } else {
        }
    }
    }
            shardStoreDeleter,
            indexSettings.setDefaultAutoThrottleEnabled(clusterMergeSchedulerConfig.getClusterMergeAutoThrottleEnabled());
import java.util.List;
                }
            indicesFieldDataCache,
                nodeEnv.nodeId(),
        if (closed.get()) {
     * Called whenever the refresh interval changes. This can happen in 2 cases -
        ThreadPool threadPool,
            @Override
        return threadPool;
            } finally {
        AsyncGlobalCheckpointTask(final IndexService indexService) {
import org.opensearch.index.remote.RemoteStoreUtils;
        this.segmentReplicationStatsProvider = segmentReplicationStatsProvider;
 * Licensed to Elasticsearch under one or more contributor
                    retentionLeaseSyncTask
import java.util.function.Consumer;
        Client client,
    public final EngineFactory getEngineFactory() {
        this.nodeEnv = nodeEnv;
    @Nullable
        final RepositoriesService repositoriesService,
        );
    /**
                // extract native store handles for the Store before passing to the factory.
        this.clusterDefaultRefreshIntervalSupplier = clusterDefaultRefreshIntervalSupplier;
        this.compositeIndexSettings = compositeIndexSettings;
            if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_SETTING)
        EngineConfigFactory engineConfigFactory,
    public void onRefreshLevelChange(boolean newShardLevelRefreshVal) {
        }
        }
import org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory;
        protected String getThreadPool() {
                // The replicas cleans up the redundant pending merge segments according to the primary shard request.
                logger.warn(() -> new ParameterizedMessage("failed to publish primary referenced segments"), ex);
                path,
        MergedSegmentWarmerFactory mergedSegmentWarmerFactory
        try {
                    IOUtils.closeWhileHandlingException(lock);
        }
            logger.warn("Native store not available for repository [{}]", repoName);
        NamedWriteableRegistry namedWriteableRegistry,
                        this.indexSettings.getRemoteStorePathStrategy(),
        } else {
     * Creates a new QueryShardContext.
        return searchOperationListeners;
    public Iterator<IndexShard> iterator() {
                try {
        );
            clearedAtLeastOne = true;
     * or the repository is missing.
    /**
    /**
import java.nio.file.Path;
        indexSettings.setDefaultMaxMergesAtOnce(clusterDefaultMaxMergeAtOnceSupplier.get());
                } catch (Exception inner) {
    // method is synchronized so that IndexService can't be closed while we're writing out dangling indices information
    /**
                } finally {
        assert Objects.isNull(refreshTask);
            for (IndexShard shard : this.shards.values()) {
            storeFactory,
        return indexSettings.getUUID();
        }
        this.xContentRegistry = xContentRegistry;
    // Visible for testing
        this.shardStoreDeleter = shardStoreDeleter;
                }
        return clusterDefaultRefreshIntervalSupplier.get();
                    startIndexLevelRefreshTask();
            scriptService,
    public QueryShardContext newQueryShardContext(
                remoteStore = new Store(
            return getIndexSettings().getRefreshInterval();
        }
            if (fields.length == 0) {
        }
                this.indexSettings.isSegRepEnabledOrRemoteNode() ? mergedSegmentPublisher : null,
            nowInMillis,
            }
            } finally {
     *
            @Override
                    shard.shardBitsetFilterCache().onCached(ramBytesUsed);
     * Cache listener for bitsets
     */
            }
                    logger.debug("failed to close resource", ex);
                case POST_RECOVERY:
                        this.indexSettings,
        if (indexSettings.getTranslogDurability() == Translog.Durability.ASYNC) {
    private final EngineConfigFactory engineConfigFactory;
    /**
        @Override
     */
        return readerWrapper;
            try {
    private final CircuitBreakerService circuitBreakerService;
                        continue;
    private long getAvgShardSizeInBytes() throws IOException {
            return NativeStoreRepository.EMPTY;
                    bitsetFilterCache,
            return;
                }
        return new QueryShardContext(
                    dataPathToShardCount
    private final NamedXContentRegistry xContentRegistry;
    }
    private final NodeEnvironment nodeEnv;
                    directory = dataFormatAwareStoreDirectoryFactory.newDataFormatAwareStoreDirectory(
                try {
        sync(IndexShard::syncRetentionLeases, "retention lease");
                } finally {
                try {
    }
            return false == indexSettings.getIndexMetadata()
import org.opensearch.env.ShardLock;
    }
                        assert false : "shard " + shard.shardId() + " is in post-recovery but marked as active";
        return scriptService;
                        directoryFactory,
import org.opensearch.repositories.RepositoryMissingException;
                    shardStoreDeleter.deleteShardStore("delete index", lock, indexSettings);
            asyncPublishReferencedSegmentsTask.close();
                    Store.OnClose.EMPTY,
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
    }
    /**
            bigArrays,
                    }
    public QueryShardContext newQueryShardContext(
     * Passing a {@code null} {@link IndexSearcher} will return a valid context, however it won't be able to make
                    }
            indexService.syncRetentionLeases();
            this.mapperService = null;
                shardId,
    private final IndexCache indexCache;
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
    }
        return path;
            } else {
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
            return ThreadPool.Names.GENERIC;
                checksumStrategies
        LongSupplier nowInMillis,
        NodeEnvironment nodeEnv,
            return "replication";
    }
import org.apache.lucene.store.Directory;
        new TimeValue(0, TimeUnit.MILLISECONDS),
                }
                    storeStrategyRegistry = StoreStrategyRegistry.open(
            xContentRegistry,
     */
        );
                remoteStoreSettings,
                } else {
         * be able to serialize the execution via the cluster state in the future. for now we just
     */
        if (!MergeSchedulerConfig.MAX_FORCE_MERGE_MB_PER_SEC_SETTING.exists(indexSettings.getSettings())) {
    }
            super(indexService, indexService.getRefreshInterval());
                // that's being relocated/replicated we know how large it will become once it's done copying:
     * FSyncs the translog for all shards of this index in a defined interval.
    }
            Map<String, FormatChecksumStrategy> checksumStrategies = Collections.emptyMap();
        } else {
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
            this.bitsetFilterCache = null;
            indexSettings.setDefaultMaxThreadAndMergeCount(
            return;
            return false;
        this.bigArrays = bigArrays;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        } catch (WriteStateException e) {
            }
        this.nodeCacheService = nodeCacheService;
            this.indexService = indexService;
        }
                scriptService,
import org.opensearch.common.util.concurrent.AbstractRunnable;
                && this.dataFormatAwareStoreDirectoryFactory != null) {
    public synchronized void updateMetadata(final IndexMetadata currentIndexMetadata, final IndexMetadata newIndexMetadata) {
        protected String getThreadPool() {
        DataFormatAwareStoreDirectoryFactory dataFormatAwareStoreDirectoryFactory,
        NodeEnvironment nodeEnv,
        }
                }
     * The change is only applied if the index doesn't have its own explicit force merge MB per sec setting.
import static org.opensearch.common.collect.MapBuilder.newMapBuilder;
    @InternalApi
            public void onFailure(Exception e) {
            });
                NativeStoreRepository nativeStore = resolveNativeStore(repositoriesService);
import org.opensearch.threadpool.ThreadPool;
            return sum / count;
            shardId,
 * compatible open source license.
                indexSettings,
        NodeCacheService nodeCacheService
import org.opensearch.index.translog.TranslogFactory;
import org.opensearch.index.engine.dataformat.DataFormat;
    }
        @Override
                this.indexSettings.isSegRepEnabledOrRemoteNode() ? referencedSegmentsPublisher : null,
        return indexSettings;
    public IndexSettings getIndexSettings() {
    public Set<Integer> shardIds() {
                }
                engineConfigFactory,
                    );
            return ThreadPool.Names.MANAGEMENT;
     * {@code cluster.default.index.merge.scheduler.max_thread_count} change.
    AsyncTranslogFSync getFsyncTask() { // for tests
import org.opensearch.transport.client.Client;
        IndexSearcher searcher,
    /**
                return shard == null ? IndicesFieldDataCache.Key.NO_SHARD_IDENTITY : System.identityHashCode(shard);
                similarityService,
     *
    private final CheckedFunction<DirectoryReader, DirectoryReader, IOException> readerWrapper;
    } // pkg private for testing
        );
                // we delay the actual creation of the sort order for this index because the mapping has not been merged yet.
        DataFormatRegistry dataFormatRegistry,
            );
                mapperService,
                ShardLock remoteStoreLock = new ShardLock(shardId) {
        NamedWriteableRegistry namedWriteableRegistry,
import java.util.function.LongSupplier;
    private final BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier;
        // The refresh task is expected to be null at this point.
            wrapperFactory,
    public void onDefaultMaxMergeAtOnceChanged(int newDefaultMaxMergeAtOnce) {
        this.remoteStoreSettings = remoteStoreSettings;
     * @opensearch.api
                }
    }
            final TimeValue newInterval = indexService.getIndexSettings().getTranslogSyncInterval();
        public String toString() {
            super(
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
        }
        IndexerFactory indexerFactory,
            this(indexService, interval, () -> Boolean.FALSE);
    public void addMetadataListener(Consumer<IndexMetadata> listener) {
        this.clusterService = clusterService;
                path,
    public IndexEventListener getIndexEventListener() {
    private final DataFormatAwareStoreDirectoryFactory dataFormatAwareStoreDirectoryFactory;
            Directory remoteDirectory = null;
        }
import org.opensearch.plugins.IndexStorePlugin;
        final SegmentReplicationCheckpointPublisher checkpointPublisher,
import org.opensearch.index.shard.ShardNotFoundException;
    AsyncReplicationTask getReplicationTask() {
    private DataFormatAwareStoreDirectory createDataFormatAwareStoreDirectory(
    }
                }
                        // fine - continue;
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
                recoverySettings,
import org.apache.lucene.index.IndexReader;
                        }
                }
        updateFsyncTaskIfNecessary();
        this.searchOperationListeners = Collections.unmodifiableList(searchOperationListeners);
import org.apache.lucene.index.DirectoryReader;
        AsyncRefreshTask(IndexService indexService) {
                logger.debug("{} creating using a new path [{}]", shardId, path);
    }
                indexService.maybeSyncSegments(false);
            eventListener,
            } finally {
                dataFormatRegistry
    }
            @Override
    @Override
         * TODO: we execute this in parallel but it's a synced method. Yet, we might
import org.opensearch.common.settings.Settings;
            indexNameMatcher,
            }
                }
                    this.indexSettings,
 * license agreements. See the NOTICE file distributed with
     */
                    continue;
        }
    );
                engineWarmer,
    public RecoveryState createRecoveryState(ShardRouting shardRouting, DiscoveryNode targetNode, DiscoveryNode sourceNode) {
                    }
                    globalCheckpointTask,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        if (this.indexSettings.isRemoteSnapshot()) {
    }
     * 2. {@code index.refresh_interval} index setting changes.
import org.apache.lucene.store.AlreadyClosedException;
    ) {
            onRefreshIntervalChange();
     * {@link IndexReader}-specific optimizations, such as rewriting containing range queries.
        this.valuesSourceRegistry = valuesSourceRegistry;
        }
    }
import org.opensearch.indices.IndicesBitsetFilterCache;
        AsyncPublishReferencedSegmentsTask(IndexService indexService) {
                        e
            updateFsyncTaskIfNecessary();
    }
                    .getSettings()
    }
        return refreshTask.getInterval();
            if (shouldRun()) {
            updateReplicationTask();
     * Clears the caches for the given shard id if the shard is still allocated on this node
        }
    private void sync(final Consumer<IndexShard> sync, final String source) {
        return createShard(
        IndicesFieldDataCache indicesFieldDataCache,
 *
                this.shardLevelRefreshEnabled = newShardLevelRefreshVal;
        Map<String, FormatChecksumStrategy> checksumStrategies
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.compositeindex.CompositeIndexSettings;
            mergedSegmentWarmerFactory,
        } else {
        void updateIfNeeded() {
        if (queryCache) {
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
            logger.warn(() -> new ParameterizedMessage("failed to delete dangling indices state for index {}", index()), e);
        }
        // disable these checks for ingestion source engine
                // this logic is tricky, we want to close the engine so we rollback the changes done to it
            namedWriteableRegistry,
            return;
            updatePublishReferencedSegmentsTask();
            } else {
            indexFieldData.setShardIdentityResolver(shardId -> {
        } catch (IOException e) {
    /**
                indexingOperationListeners,
                        shard.sync();
        NamedXContentRegistry xContentRegistry,
            mapperRegistry,
        IndexNameExpressionResolver expressionResolver,
        }
        @Override
        }
    private final ValuesSourceRegistry valuesSourceRegistry;
        }
            }
                }
        if (Assertions.ENABLED && currentIndexMetadata != null) {
        }
        try {
                final IndexShard shard = indexService.getShardOrNull(shardId.id());
                        logger.debug(() -> new ParameterizedMessage("[{}] failed to close index shard", shardId), e);
        AsyncReplicationTask(IndexService indexService) {
    public synchronized void removeShard(int shardId, String reason) {
            eventListener.beforeIndexShardCreated(shardId, indexSettings);
     *
                    Integer curCount = dataPathToShardCount.get(dataPath);
    }
        public String toString() {
 * under the License.
        }
        new TimeValue(30, TimeUnit.SECONDS),
        @Override
                        RemoteStoreUtils.isServerSideEncryptionEnabledIndex(this.indexSettings.getIndexMetadata())
    private final IndexStorePlugin.RecoveryStateFactory recoveryStateFactory;
                        (fieldType, searchLookup) -> indexFieldData.getForField(fieldType, indexFieldData.index().getName(), searchLookup)
            indexFieldData::getForField,
            try {
        // visible for tests
            client,
    }
                logger.info("refresh tasks rescheduled oldVal={} newVal={}", prevShardLevelRefreshVal, newShardLevelRefreshVal);
                        stopIndexLevelRefreshTask();
                // Count up how many shards are currently on each data path:
        // it doesn't matter if we move from or to <code>-1</code> in both cases we want
        }
    public IndexShard getShardOrNull(int shardId) {
        IndicesBitsetFilterCache indicesBitsetFilterCache,
     * Publish primary shard referenced segments in a defined interval.
     * indexes relying on cluster default.
                clusterService.getClusterApplierService(),
        logger.debug("[{}] closed (reason: [{}])", shardId, reason);
                        remoteDirectory,
            searcher,
        }
                    try {
     * Returns {@link NativeStoreRepository#EMPTY} when no repository is configured
import java.util.concurrent.TimeUnit;
        @Override
                    }
        List<SearchOperationListener> searchOperationListeners,
    private void maybeRefreshEngine(boolean force) {
                    .getAsTime(INDEX_TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING, TimeValue.timeValueMinutes(10))
            );
 * Unless required by applicable law or agreed to in writing,
                        throw new IllegalStateException("unknown state [" + shard.state() + "]");
import org.opensearch.index.shard.ShardNotInPrimaryModeException;
        return asyncPublishReferencedSegmentsTask;
