        synchronized (refreshMutex) {  
            indexSettings,
    private final List<SearchOperationListener> searchOperationListeners;
            Store remoteStore = null;
        if (dataFormatAwareStoreDirectoryFactory != null) {
        logger.debug("No DataFormatAwareStoreDirectoryFactory available, Store will handle internal creation for: {}", shardPath);  
            indexFieldData::getForField,
                }
     * Context for index creation
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (shouldRun()) {
    final class AsyncTrimTranslogTask extends BaseAsyncTask {
        this.indexingOperationListeners = Collections.unmodifiableList(indexingOperationListeners);
    }
        }
import org.opensearch.index.shard.ShardPath;
        this.clusterService = clusterService;  
        this.translogFactorySupplier = translogFactorySupplier;
        this.bigArrays = bigArrays;  
                        this.indexSettings.getRemoteStorePathStrategy(),
            }
                    case CREATED:  
            }  
        return similarityService;  
     * Called whenever the cluster level {@code cluster.merge.scheduler.max_force_merge_mb_per_sec} changes.  
import org.opensearch.index.query.QueryShardContext;
                    path,  
    ) {
                            throw new IllegalStateException("Can't migrate a remote shard to replica before primary " + routing.shardId());
            client,  
                clusterService.getClusterApplierService(),  
            }
                remoteStoreStatsTrackerFactory,  
        return indexSettings.getIndexMetadata();
            return;
    }  
    /**
                        threadPool
    private final NamedXContentRegistry xContentRegistry;  
        this.refreshInterval = getRefreshInterval();  
        SimilarityService similarityService,  
import java.io.Closeable;
        }  
                fsyncTask = null;
    }  
     */  
        }
     *
    }
    }  
                        continue;  
            }  
    private void maybePublishReferencedSegments() {  
                case CREATED:
        return null;
        DiscoveryNodes discoveryNodes,
        NodeEnvironment nodeEnv,
        if (deleted.get()) { // we remove that shards content if this index has been deleted
        } else if (fsyncTask == null) {
                    // fine - continue;  
    private ShardPath getShardPath(ShardRouting routing, ShardId shardId, ShardLock lock) throws IOException {
            return indexSettings.isSegRepEnabledOrRemoteNode() && super.mustReschedule();
            searchOperationListeners,
import org.opensearch.index.store.remote.filecache.NodeCacheService;  
            throw new IllegalStateException(shardId + " already exists");  
                // allocation level,  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        }
        sync(IndexShard::syncRetentionLeases, "retention lease");
    }
                indexFieldData,  
        boolean keywordIndexOrDocValuesEnabled  
        IndexerFactory indexerFactory,  
            return ((EngineBackedIndexerFactory) indexerFactory).getEngineFactory();  
    private final NamedWriteableRegistry namedWriteableRegistry;
        }
                } catch (AlreadyClosedException ex) {
            indexNameMatcher,
                dataFormatRegistry
        this.similarityService = similarityService;
        }  
        this.dataFormatAwareStoreDirectoryFactory = dataFormatAwareStoreDirectoryFactory;  
                );  
    @PublicApi(since = "1.0.0")
                    () -> new ParameterizedMessage("[{}] failed to delete shard content - scheduled a retry", lock.getShardId().id()),
    public synchronized void deleteDanglingIndicesInfo() {  
                }
            super(indexService, indexService.getRefreshInterval());  
            protected void doRun() throws Exception {
     * The {@link BigArrays} to use for this index.
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
                checksumStrategies,  
    }  
        Property.IndexScope
     */  
    public IndexService(
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
            checkpointPublisher,
        this.threadPool = threadPool;
            indexShard = new IndexShard(  
    } // pkg private for testing
                };
                    remoteDirectory = remoteDirectoryFactory.newDirectory(this.indexSettings, path);  
import java.util.Collections;
                    continue;
            }  
                && this.dataFormatAwareStoreDirectoryFactory != null) {
                logger.info("refresh tasks rescheduled oldVal={} newVal={}", prevShardLevelRefreshVal, newShardLevelRefreshVal);
            final long currentSettingsVersion = currentIndexMetadata.getSettingsVersion();
                // ToDo: remove the isPluggableDataFromatEnabled check once MergedSegment replication flow is integrated for DataFormatAware
        }
                    globalCheckpointTask,
    private final class FieldDataCacheListener implements IndexFieldDataCache.Listener {  
                    bitsetFilterCache,  
                remoteStoreSettings,  
                        seedRemote = true;
                        () -> new ParameterizedMessage("[{}] failed to notify shard about setting change", shard.shardId().id()),
        IndexerFactory indexerFactory,  
                // we delay the actual creation of the sort order for this index because the mapping has not been merged yet.
        }
        return refreshTask.getInterval();
        long sum = 0;
            this.bitsetFilterCache = null;  
                    logger.trace("[{}] store not initialized prior to closing shard, nothing to close", shardId);  
            }  
    private volatile Map<Integer, IndexShard> shards = emptyMap();  
        @Override
            if (fields.length == 0) {  
        boolean success = false;  
    private volatile AsyncPublishReferencedSegmentsTask asyncPublishReferencedSegmentsTask;  
import java.util.function.Function;  
        }
        MergedSegmentWarmerFactory mergedSegmentWarmerFactory
                indicesFieldDataCache,
    private final DataFormatAwareStoreDirectoryFactory dataFormatAwareStoreDirectoryFactory;  
                        shouldWidenIndexSortType,  
import org.opensearch.cluster.metadata.IndexMetadata;  
        indexShard = newShards.remove(shardId);
    // Visible for test  
import org.opensearch.plugins.NativeStoreHandle;
                        storeStrategies,  
                        // fine - continue;
                );
    private final Consumer<IndexShard> replicator;
    private volatile AsyncRefreshTask refreshTask;
                StoreStrategyRegistry storeStrategyRegistry = null;  
    final class AsyncReplicationTask extends BaseAsyncTask {  
            }
        protected void runInternal() {
        try {
        }  
            shard.stopRefreshTask();
        final Settings indexSettings = this.indexSettings.getSettings();
                            // the shard was closed concurrently, continue
    /**
                return true;
 * KIND, either express or implied.  See the License for the
                    shardStoreDeleter.deleteShardStore("delete index", lock, indexSettings);
                    shard.fieldData().onCache(shardId, fieldName, ramUsage);  
import org.apache.lucene.index.IndexReader;  
        IndexStorePlugin.RecoveryStateFactory recoveryStateFactory,
                ShardLock remoteStoreLock = new ShardLock(shardId) {  
        }
            eventListener.afterIndexShardCreated(indexShard);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.cache.IndexCache;  
        }
            scriptService,
        if (shards.containsKey(shardId) == false) {  
                indexSettings,
        final RetentionLeaseSyncer retentionLeaseSyncer,
                onShardClose(lock);
        logger.debug("[{}] closing... (reason: [{}])", shardId, reason);  
        updateFsyncTaskIfNecessary();
                    );  
    }  
     * Creates DataFormatAwareStoreDirectory using the factory if available, otherwise fallback to Store's internal creation.
            public boolean isForceExecution() {  
                        final boolean flushEngine = deleted.get() == false && closed.get();  
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
                // The following method provides ShardLock that is not maintained by NodeEnvironment.  
        }
                    directoryFactory
    public IndexAnalyzers getIndexAnalyzers() {
                        removeShard(shardId, reason);
     */  
            retentionLeaseSyncer,
        BooleanSupplier allowExpensiveQueries,
        protected String getThreadPool() {
                startIndexLevelRefreshTask();  
     * Resolves the native object store for the index's remote store repository.
        @Override
    private final Client client;
    private final IndexStorePlugin.DirectoryFactory remoteDirectoryFactory;
        // The refresh task is expected to be null at this point.
        /*
    }
import org.opensearch.index.engine.EngineFactory;  
import org.opensearch.cluster.routing.ShardRouting;
        return shards.values().iterator();  
            shards = newMapBuilder(shards).put(shardId.id(), indexShard).immutableMap();
    }  
            indexerFactory,
                    case CLOSED:
        LongSupplier nowInMillis,  
                similarityService,  
import org.opensearch.common.annotation.InternalApi;
        if (needsMapperService(indexSettings, indexCreationContext)) {  
                } finally {
            return repositoriesService.repository(repoName).getNativeStore();  
        Map<String, FormatChecksumStrategy> checksumStrategies
                this.indexSettings.isSegRepEnabledOrRemoteNode() ? referencedSegmentsPublisher : null,
                    throw e;  
 */
         */  
                }
    );
import org.apache.logging.log4j.message.ParameterizedMessage;
            store.beforeClose();
            );
            }  
    public void onDefaultMaxMergeOrThreadCountUpdate(int maxThreadCount, int maxMergeCount) {  
                boolean prevShardLevelRefreshVal = this.shardLevelRefreshEnabled;
     * @opensearch.internal
    AsyncPublishReferencedSegmentsTask getPublishReferencedSegmentsTask() {
                if (shard != null) {  
     * Clears the caches for the given shard id if the shard is still allocated on this node
            threadPool,  
            }
                } finally {
            fsyncTask.updateIfNeeded();
        this.indexerFactory = Objects.requireNonNull(indexerFactory);  
    private void updateFsyncTaskIfNecessary() {
            asyncReplicationTask = new AsyncReplicationTask(this);
    private void maybeTrimTranslog() {
        public String toString() {
                }
        if (repoName == null || repositoriesService == null) {
                    trimTranslogTask,  
        "index.global_checkpoint_sync.interval",  
        return new QueryShardContext(
        // The refresh task is expected to be non-null at this point.  
        return false == (indexSettings.getIndexMetadata().getState() == IndexMetadata.State.CLOSE
     * @param repositoriesService the repositories service, may be {@code null}  
            targetNode,
     */
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        for (final IndexShard shard : this.shards.values()) {
    }
        ShardStoreDeleter shardStoreDeleter,
 */  
     * Return the shard with the provided id, or throw an exception if it doesn't exist.
                // extract native store handles for the Store before passing to the factory.  
            remoteStoreSettings,  
                    }
        Supplier<Integer> clusterDefaultMaxMergeAtOnce,  
public class IndexService extends AbstractIndexComponent implements IndicesClusterStateService.AllocatedIndex<IndexShard> {  
                similarityService,
     *
            return "retention_lease_sync";  
            logger.debug("creating shard_id {}", shardId);
    private void stopIndexLevelRefreshTask() {
            return indexSettings.isSegRepEnabledOrRemoteNode() && super.mustReschedule();
                        e
                    long ramBytesUsed = accountable != null ? accountable.ramBytesUsed() : 0L;  
         * keep it synced.
        @Override
            if (this.shardLevelRefreshEnabled != newShardLevelRefreshVal) {  
        public String toString() {
                recoverySettings,
    private final Object refreshMutex = new Object();  
        CircuitBreakerService circuitBreakerService,
    }
                indexCache.clear("api");
                    store.close();
                    // Will be enabled in case of formatAware indices.
        indexSettings.setDefaultMaxMergesAtOnce(clusterDefaultMaxMergeAtOnceSupplier.get());  
        throw new UnsupportedOperationException("Engine Factory doesn't exist for current index.");
            xContentRegistry,
                    IOUtils.closeWhileHandlingException(storeStrategyRegistry);
                if (shard.isPrimaryMode() && shard.routingEntry().active()) {
    public CompositeIndexSettings getCompositeIndexSettings() {
    private void updatePublishReferencedSegmentsTask() {
            this.indexSortSupplier = () -> null;
        }
    }  
import org.opensearch.indices.IndicesBitsetFilterCache;
    public boolean updateMapping(final IndexMetadata currentIndexMetadata, final IndexMetadata newIndexMetadata) throws IOException {
                for (IndexShard shard : this) {  
                        indexShard.close(reason, flushEngine, deleted.get());
    public SimilarityService similarityService() {
                    case POST_RECOVERY:  
            remoteStore = indexShard.remoteStore();
            storeFactory,
        if (indexSettings.getTranslogDurability() == Translog.Durability.ASYNC) {
                && indexSettings.isPluggableDataFormatEnabled() == false;
    final class AsyncPublishReferencedSegmentsTask extends BaseAsyncTask {
import org.opensearch.common.util.io.IOUtils;  
        @Override
        MapperRegistry mapperRegistry,
        ShardId shardId,  
                        RemoteStoreNodeAttribute.getRemoteStoreSegmentRepo(this.indexSettings.getNodeSettings()),
            );
                        stopShardLevelRefreshTasks();
import org.opensearch.index.shard.IndexShard;
        }
            indexService.syncRetentionLeases();
        this.eventListener = eventListener;
        }
        try {  
import org.opensearch.index.fielddata.IndexFieldDataService;
            }
    // method is synchronized so that IndexService can't be closed while we're deleting dangling indices information
                for (final int shardId : shardIds) {  
    private final IndexNameExpressionResolver expressionResolver;  
        }
                    } catch (Exception e) {  
        protected String getThreadPool() {  
        }
    }
        return shards.keySet();
    private final ScriptService scriptService;
    }
            circuitBreakerService,
@PublicApi(since = "1.0.0")
            indexService.maybeSyncGlobalCheckpoints();
            return false;
                    try {
                        "[{" + routing.shardId() + "}] Cannot initialize shards with remote store index settings on non-remote store nodes"
                this.indexSettings,  
import org.opensearch.index.store.Store;
                        // only flush if we are closed (closed index or shutdown) and if we are not deleted
                // Warm + format-aware: create StoreStrategyRegistry here so we can
        this.segmentReplicationStatsProvider = segmentReplicationStatsProvider;
            this.indexFieldData = new IndexFieldDataService(
            remoteDirectoryFactory,
                    }
    private final CheckedFunction<DirectoryReader, DirectoryReader, IOException> readerWrapper;  
 * compatible open source license.
    /*
            if (fields.length == 0) {  
    }  
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;  
                        shardId,
            namedWriteableRegistry,  
     * <p>
        AsyncRetentionLeaseSyncTask(final IndexService indexService) {
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
                && this.indexSettings.isWarmIndex()
        }
                }  
                        continue;
    ) {
            );
import org.opensearch.core.Assertions;
        }  
    private void rescheduleRefreshTasks() {
        return shardLevelRefreshEnabled;
                                    && e instanceof ShardNotInPrimaryModeException == false) {
     * @return the refresh interval.
                    e
                } else {
                    @Override
        this.compositeIndexSettings = compositeIndexSettings;
        IndicesFieldDataCache indicesFieldDataCache,  
        // docs to become visible immediately. This also flushes all pending indexing / search requests
                    try {
     * {@link IndexReader}-specific optimizations, such as rewriting containing range queries.
        @Override  
    }
        return shards.get(shardId);
    }
                indexAnalyzers,
        this.remoteStoreSettings = remoteStoreSettings;
    }  
    }
        }
                    remoteStore.close();
            logger.warn(() -> new ParameterizedMessage("failed to write dangling indices state for index {}", index()), e);
    }  
     *  
        List<SearchOperationListener> searchOperationListeners,  
        boolean validate  
                if (indexShard != null) {  
        IndexSearcher searcher,  
            return "publish_primary_referenced_segments";  
                    dataPathToShardCount.put(dataPath, curCount + 1);  
    }
                            shard.runUnderPrimaryPermit(() -> sync.accept(shard), e -> {
        if (refreshInterval.equals(getRefreshInterval())) {  
import org.opensearch.index.remote.RemoteStoreUtils;
                        (fieldType, searchLookup) -> indexFieldData.getForField(fieldType, indexFieldData.index().getName(), searchLookup)
        if (shards.containsKey(shardId.id())) {
                }
        void updateIfNeeded() {
        ValuesSourceRegistry valuesSourceRegistry,  
    private void startIndexLevelRefreshTask() {
            path = ShardPath.loadFileCachePath(nodeEnv, shardId);
    private final IndexCache indexCache;
                assert updateIndexSettings;  
        }
                try {
        IndexCreationContext indexCreationContext,  
                default:
            shardLevelRefreshEnabled,
import org.opensearch.plugins.IndexStorePlugin;  
    public String indexUUID() {
import org.opensearch.gateway.WriteStateException;
        }
        }  
import org.opensearch.threadpool.ThreadPool;
    }
    private static final class BitsetCacheListener implements BitsetFilterCache.Listener {  
        indexSettings.setDefaultAutoThrottleEnabled(enabled);
                    remoteDirectory = ((RemoteSegmentStoreDirectoryFactory) remoteDirectoryFactory).newDirectory(
        }
                path = ShardPath.selectNewPathForShard(
            if (shouldRun()) {  
                    Path dataPath = shard.shardPath().getRootStatePath();
    }  
    }  
import org.opensearch.index.shard.ShardNotFoundException;
                    dataPathToShardCount  
            similarityService,
    /**
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,  
                    eventListener.afterIndexShardDeleted(lock.getShardId(), indexSettings.getSettings());
    }
    public synchronized void close(final String reason, boolean delete) throws IOException {
import java.util.HashMap;  
                }
     * Returns {@link NativeStoreRepository#EMPTY} when no repository is configured  
    private final CompositeIndexSettings compositeIndexSettings;  
            MetadataStateFormat.deleteMetaState(nodeEnv.indexPaths(index()));
import java.io.IOException;  
 * under the License.  
        refreshTask.close();
        return scriptService;
            @Override  
        }  
        NamedXContentRegistry xContentRegistry,
        AsyncGlobalCheckpointTask(final IndexService indexService) {  
     */  
     * <p>
            });
                }
     */
    public IndexEventListener getIndexEventListener() {  
            // TODO : Need to remove this check after support for hot indices is added in Composite Directory  
            assert indexAnalyzers == null;
            eventListener.onStoreCreated(shardId);
            index().getName(),  
     * Creates a new QueryShardContext.  
            clusterAlias,
        }
    }  
    } // pkg private for testing
        return mapperService.updateMapping(currentIndexMetadata, newIndexMetadata);  
                // that's being relocated/replicated we know how large it will become once it's done copying:  
            mapperRegistry,
        this.xContentRegistry = xContentRegistry;  
        Objects.requireNonNull(retentionLeaseSyncer);
        final RepositoriesService repositoriesService,
     * Base asynchronous task
    private void maybeSyncSegments(boolean force) {  
import org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory;
import org.opensearch.common.util.concurrent.AbstractRunnable;
        for (IndexShard indexShard : this) {
        DiscoveryNodes discoveryNodes,
     * Passing a {@code null} {@link IndexSearcher} will return a valid context, however it won't be able to make
    public IndexCache cache() {
            similarityService(),  
                    throw new IllegalStateException("unknown state: " + shard.state());  
                        directoryFactory,
        ScriptService scriptService,
    private final EngineConfigFactory engineConfigFactory;
import java.util.List;
                        this.indexSettings,  
    }
                    if (shard.isSyncNeeded()) {
    /**
 * GitHub history for details.
    }
        if (mapperService == null) {  
                } else {
     * @opensearch.internal
            this.globalCheckpointTask = new AsyncGlobalCheckpointTask(this);
    private final ThreadPool threadPool;  
        }
            if (path == null) {
     */  
        }
    private final RemoteStoreSettings remoteStoreSettings;
        }
            null
            final TimeValue newInterval = indexService.getIndexSettings().getTranslogSyncInterval();
        indexSettings.setDefaultMaxMergesAtOnce(newDefaultMaxMergeAtOnce);
    public NamedXContentRegistry xContentRegistry() {
    @Override
        }  
                    shardId,
    }
            indexFieldData.setListener(new FieldDataCacheListener(this));
        public void onCache(ShardId shardId, String fieldName, Accountable ramUsage) {
        if (!indexSettings.getIndexMetadata().useIngestionSource()) {
import org.opensearch.index.compositeindex.CompositeIndexSettings;  
                        shard.trimTranslog();  
                discoveryNodes,
        public String toString() {
                }  
 */  
                        shardId,
            );  
                nodeEnv.nodeId(),
     * Called whenever the cluster level {@code cluster.default.index.merge.scheduler.auto_throttle} changes.
            indexCache.query().clear("api");
            if (shard.routingEntry().active() && shard.routingEntry().primary()) {  
     * or the repository is missing.
        @Override
        QueryCache queryCache,
                indexFieldData.clear();
    public MapperService mapperService() {  
    }  
     */  
            Map<DataFormat, NativeStoreHandle> dataformatAwareStoreHandles = Map.of();  
            @Override
        try {
     * <p>  
    }  
            valuesSourceRegistry,
     */
     * Shard Store Deleter Interface
            } else {
        List<IndexingOperationListener> indexingOperationListeners,
            if (indexSettings.getIndexSortConfig().hasIndexSort()) {  
import org.opensearch.common.unit.TimeValue;
            super(indexService.logger, indexService.threadPool, interval, true, fixedIntervalSchedulingEnabled);  
    private final IndexStorePlugin.StoreFactory storeFactory;  
            for (final IndexShard shard : this.shards.values()) {
                    routing.getExpectedShardSize() == ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE  
    }
        }  
            s -> {},
                try {  
import org.apache.lucene.util.Accountable;
        @Override
                try {
        this.recoveryStateFactory = recoveryStateFactory;
                // The refresh mode has changed from index level to shard level and vice versa  
        String clusterAlias,
            repositoriesService,
            } else {  
        this.expressionResolver = expressionResolver;
            }
        @Override
        protected String getThreadPool() {  
                indicesBitsetFilterCache != null ? indicesBitsetFilterCache.createListener(threadPool) : null
        if (count == 0) {
        } else {
                final IndexShard shard = indexService.getShardOrNull(shardId.id());
            throw new IOException("failed to obtain in-memory shard lock", e);  
                final IndexShard shard = indexService.getShardOrNull(shardId.id());  
        return path;
            updateFsyncTaskIfNecessary();
        String repoName = this.indexSettings.getRemoteStoreRepository();
 * Unless required by applicable law or agreed to in writing,
            );  
            this.indexCache = new IndexCache(indexSettings, queryCache, bitsetFilterCache);  
    private volatile AsyncTranslogFSync fsyncTask;
                } catch (IOException e) {
        this.storeFactory = storeFactory;  
        ValuesSourceRegistry valuesSourceRegistry,
     */
                    shard.shardBitsetFilterCache().onRemoval(ramBytesUsed);  
        this.directoryFactory = directoryFactory;
     * 1. {@code cluster.default.index.refresh_interval} cluster setting changes. The change would only happen for
    final IndexStorePlugin.DirectoryFactory getDirectoryFactory() {  
                new StoreCloseListener(shardId, () -> eventListener.onStoreClosed(shardId)),  
        }  
            return;
    private final NodeEnvironment nodeEnv;
            shard.startRefreshTask();  
        // to ensure we are in a clean and predictable state.
    final class AsyncRetentionLeaseSyncTask extends BaseAsyncTask {  
                () -> globalCheckpointSyncer.accept(shardId),  
                }  
    /**
            nodeEnv,  
        Store store = null;
                }
                    IOUtils.close(toClose);
 * software distributed under the License is distributed on an
            final long newSettingsVersion = newIndexMetadata.getSettingsVersion();
                store,
        ScriptService scriptService,
        new TimeValue(30, TimeUnit.SECONDS),
         * be able to serialize the execution via the cluster state in the future. for now we just
import static java.util.Collections.unmodifiableMap;
        }
        }  
        }
        if (getIndexSettings().getPublishReferencedSegmentsInterval().equals(asyncPublishReferencedSegmentsTask.getInterval())) {  
            mapperService(),
        @Override
    private void syncRetentionLeases() {  
    AsyncReplicationTask getReplicationTask() {  
            bigArrays,
            indexService.maybeRefreshEngine(false);
import org.opensearch.gateway.MetadataStateFormat;  
                this.indexSettings,
            asyncReplicationTask.close();
        @Override  
    private void updateReplicationTask() {  
            indexService.maybeFSyncTranslogs();
    private final Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier;
        IndexStorePlugin.RecoveryStateFactory recoveryStateFactory,
                } catch (Exception e) {
        }  
        this.recoverySettings = recoverySettings;  
        this.shardStoreDeleter = shardStoreDeleter;
            idFieldDataEnabled,
 * not use this file except in compliance with the License.
      Fetches the shard path based on the index type -  
                    logger.warn(  
         * TODO: we execute this in parallel but it's a synced method. Yet, we might  
        if (store != null) {  
import org.opensearch.indices.recovery.RecoverySettings;  
     */
        if (indexerFactory instanceof EngineBackedIndexerFactory) {
            } finally {
        }  
    boolean isShardLevelRefreshEnabled() {
            onRefreshIntervalChange();  
    }  
            if (shardId != null) {  
        }  
        @Override  
    private final AtomicBoolean deleted = new AtomicBoolean(false);
            client,
        return newQueryShardContext(shardId, searcher, nowInMillis, clusterAlias, false);  
import org.opensearch.cluster.service.ClusterService;
     */
    // NOTE: O(numShards) cost, but numShards should be smallish?  
        if (queryCache) {  
import org.opensearch.cluster.node.DiscoveryNodes;  
        QueryCache queryCache,
     * Passing a {@code null} {@link IndexSearcher} will return a valid context, however it won't be able to make
        int count = 0;  
        }
        @Override  
        );
                    );  
        } else {
            return sum / count;
    private final DataFormatRegistry dataFormatRegistry;
            this.bitsetFilterCache = new BitsetFilterCache(indexSettings, indicesBitsetFilterCache, new BitsetCacheListener(this));  
                    nodeEnv,  
        }  
import org.opensearch.env.NodeEnvironment;  
            super(indexService, GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.get(indexService.getIndexSettings().getSettings()));
    @Deprecated(forRemoval = true)  
    public void onRefreshIntervalChange() {
                indexService,  
        Consumer<IndexShard> replicator,  
import java.util.Iterator;
    public static final Setting<TimeValue> GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING = Setting.timeSetting(
        // kick off async ops for the first shard in this index
     * Gets the refresh interval seen by the index service. Index setting overrides takes the highest precedence.  
                    startShardLevelRefreshTasks();
        } finally {
                indexService.getIndexSettings()
        if (indexShard == null) {  
        try {
            if (newInterval.equals(getInterval()) == false) {  
    public Set<Integer> shardIds() {  
            this.indexService = indexService;
        BooleanSupplier allowExpensiveQueries,
    public synchronized void writeDanglingIndicesInfo() {  
        final Consumer<ShardId> globalCheckpointSyncer,  
        }
     * The change is only applied if the index doesn't have its own explicit force merge MB per sec setting.
        Client client,
 *
        private final ShardId shardId;
    }
            store = storeFactory.newStore(
    private volatile AsyncGlobalCheckpointTask globalCheckpointTask;  
    @Override  
        this.trimTranslogTask = new AsyncTrimTranslogTask(this);
        }
                translogFactorySupplier,  
        BigArrays bigArrays,  
            super(indexService, RETENTION_LEASE_SYNC_INTERVAL_SETTING.get(indexService.getIndexSettings().getSettings()));  
                    shard.scheduledRefresh();  
                    retentionLeaseSyncTask
                threadPool
                IOUtils.close(
            searcher,
                    }  
            }  
                path,
    public QueryShardContext newQueryShardContext(  
                    long ramBytesUsed = accountable != null ? accountable.ramBytesUsed() : 0L;
                } catch (IndexShardClosedException | AlreadyClosedException ex) {
import org.opensearch.script.ScriptService;
        IndicesBitsetFilterCache indicesBitsetFilterCache,
        AsyncReplicationTask(IndexService indexService) {
    /**
    }
    private final IndexerFactory indexerFactory;  
    }
            shardId,  
    }
 * this file be licensed under the Apache-2.0 license or a
                logger.warn(
    public void onRefreshLevelChange(boolean newShardLevelRefreshVal) {
                        try {
        @Override
    // visible for tests
            clusterDefaultMaxMergeAtOnce,
import org.opensearch.repositories.RepositoryMissingException;
import org.opensearch.common.util.BigArrays;
                switch (shard.state()) {
                NativeStoreRepository nativeStore = resolveNativeStore(repositoriesService);
            throw new ShardNotFoundException(new ShardId(index(), shardId));
                }
        IndexShard indexShard = null;
                        startShardLevelRefreshTasks();  
        if (this.indexSettings.isRemoteSnapshot()) {  
    @Nullable
 * license agreements. See the NOTICE file distributed with
        }
import org.apache.lucene.store.AlreadyClosedException;  
            wrapperFactory,
            return indexService.closed.get() == false;  
                    try {  
            logger.warn(() -> new ParameterizedMessage("failed to delete dangling indices state for index {}", index()), e);
     */  
                boolean shouldWidenIndexSortType = this.indexSettings.shouldWidenIndexSortType();  
    }
import org.apache.lucene.search.IndexSearcher;
     */
/**  
        protected boolean shouldRun() {  
        }  
    }
        return indexSettings.getUUID();  
                    Integer curCount = dataPathToShardCount.get(dataPath);
    private final List<IndexingOperationListener> indexingOperationListeners;
        ShardLock lock = null;  
    }
                }
                    );
        // it doesn't matter if we move from or to <code>-1</code> in both cases we want  
            this.indexService = indexService;
                    fsyncTask.close();
            clusterMergeSchedulerConfig,
                mapperService,
                remoteStore,
            return getIndexSettings().getRefreshInterval();
        protected boolean shouldRun() {
import java.util.function.Consumer;
    }
        final boolean updateIndexSettings = indexSettings.updateIndexMetadata(newIndexMetadata);
    List<SearchOperationListener> getSearchOperationListener() { // pkg private for testing  
        // visible for tests
                for (String field : fields) {  
                        RemoteStoreUtils.isServerSideEncryptionEnabledIndex(this.indexSettings.getIndexMetadata())
                indexService.maybeSyncSegments(false);  
        RemoteStoreSettings remoteStoreSettings,
                lock,
        protected boolean mustReschedule() {
                }  
        });  
    /**  
    public ScriptService getScriptService() {
                remoteStore = new Store(  
                case CLOSED:
import java.nio.file.Path;
                }  
    public TimeValue getRefreshTaskInterval() {
    }
        }
    }
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.index.mapper.MapperService;  
                fixedRefreshIntervalSchedulingEnabled,  
                listener.beforeIndexShardClosed(sId, indexShard, indexSettings);
        }
        final SegmentReplicationCheckpointPublisher checkpointPublisher,
            }
     */
        } finally {
import org.opensearch.index.store.FormatChecksumStrategy;
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
    }  
        Function<IndexService, CheckedFunction<DirectoryReader, DirectoryReader, IOException>> wrapperFactory,
        BigArrays bigArrays,  
        @Override
                    shard.publishReferencedSegments();  
            return false == indexSettings.getIndexMetadata()  
        IndexStorePlugin.DirectoryFactory directoryFactory,  
            }
    // method is synchronized so that IndexService can't be closed while we're writing out dangling indices information
        threadPool.executor(ThreadPool.Names.REFRESH).execute(new AbstractRunnable() {  
            return ThreadPool.Names.GENERIC;  
                IndexShard shard = getShardOrNull(shardId.getId());
                try {
        Client client,
            }
        final SegmentReplicationCheckpointPublisher checkpointPublisher,  
    private DataFormatAwareStoreDirectory createDataFormatAwareStoreDirectory(
                final IndexShard shard = indexService.getShardOrNull(shardId.id());
            try {
        void addPendingDelete(ShardId shardId, IndexSettings indexSettings);  
    private void sync(final Consumer<IndexShard> sync, final String source) {
            };  
                // this logic is tricky, we want to close the engine so we rollback the changes done to it
        }  
    private final IndexEventListener eventListener;
                () -> newQueryShardContext(0, null, System::currentTimeMillis, null),  
            }  
                this.indexSettings.isSegRepEnabledOrRemoteNode() ? checkpointPublisher : null,
            shardStoreDeleter,  
        MergedSegmentWarmerFactory mergedSegmentWarmerFactory,  
            expressionResolver,
        }
            valuesSourceRegistry,
                        assert false : "shard " + shard.shardId() + " is in post-recovery but marked as active";
        // that are waiting for a refresh.
                    );  
        super(indexSettings);
    final class AsyncRefreshTask extends BaseAsyncTask {
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig,  
        MapperRegistry mapperRegistry,  
                    }
                        mapperService::fieldType,
     * @opensearch.internal
    public BigArrays getBigArrays() {  
        final ShardRouting routing,  
                && indexService.indexSettings.getIndexMetadata().getState() == IndexMetadata.State.OPEN;  
                    }
                }
    private void startShardLevelRefreshTasks() {  
                            }, ThreadPool.Names.SAME, source + " sync");
        protected boolean mustReschedule() {  
        }
                }
        ClusterService clusterService,  
        }
    /**
        }
                }
        ThreadPool threadPool,
            }
                } finally {  
        IndexEventListener eventListener,
import org.opensearch.index.translog.TranslogFactory;
            indexFieldData.setShardIdentityResolver(shardId -> {
            } catch (Exception e) {
    }
    }
            // don't re-schedule if the IndexService instance is closed or if the index is closed
    public void onDefaultMaxMergeAtOnceChanged(int newDefaultMaxMergeAtOnce) {
        }  
                retentionLeaseSyncer,
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig
        return indexingOperationListeners;  
        for (IndexShard shard : this.shards.values()) {  
import org.opensearch.index.engine.Engine;
        }  
    }
    public boolean hasShard(int shardId) {  
import static org.opensearch.common.collect.MapBuilder.newMapBuilder;  
        @Override
                } catch (Exception inner) {
                        }
    private final BitsetFilterCache bitsetFilterCache;
        protected void runInternal() {  
     * Called whenever the refresh interval changes. This can happen in 2 cases -  
            return (indexSettings.isSegRepLocalEnabled() || indexSettings.isRemoteStoreEnabled())
                indexCache,  
        synchronized (refreshMutex) {
                    stopShardLevelRefreshTasks();  
            indexSettings.getMergeSchedulerConfig().setMaxForceMergeMBPerSec(maxForceMergeMBPerSec);
                    if (sourceNode == null || sourceNode.isRemoteSegmentStoreNode() == false) {
    private final IndexStorePlugin.CompositeDirectoryFactory compositeDirectoryFactory;
        IndexStorePlugin.DirectoryFactory directoryFactory,  
    AsyncTranslogFSync getFsyncTask() { // for tests
                        } catch (final AlreadyClosedException | IndexShardClosedException e) {  
                indexingOperationListeners,
        }
                }  
     * indexes relying on cluster default.
        this.replicator = replicator;
                    } catch (IndexShardClosedException | AlreadyClosedException ex) {
        @Override
        @Override
        final DiscoveryNode targetNode,
import java.util.Objects;
            return;
    }  
            try {  
                try {
            return "replication";
            asyncPublishReferencedSegmentsTask = new AsyncPublishReferencedSegmentsTask(this);  
        rescheduleRefreshTasks();
        return refreshMutex;
            fsyncTask = new AsyncTranslogFSync(this);
                    startIndexLevelRefreshTask();
        if (closed.get()) {
        final ShardRouting routing,
import java.util.Map;  
                circuitBreakerService,
                logger.warn(() -> new ParameterizedMessage("failed to publish primary referenced segments"), ex);  
            this.warmer = null;
        final ShardId shardId = routing.shardId();
    }
                return shard == null ? IndicesFieldDataCache.Key.NO_SHARD_IDENTITY : System.identityHashCode(shard);
        } finally {  
                    }  
                }  
        }  
        try {  
                    throw new IllegalStateException(
import org.apache.lucene.search.Sort;
        refreshTask = null;  
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,  
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
     * {@code cluster.default.index.merge.scheduler.max_thread_count} change.
                case POST_RECOVERY:  
        refreshInterval = getRefreshInterval();  
        AsyncPublishReferencedSegmentsTask(IndexService indexService) {  
    @InternalApi  
    public synchronized IndexShard createShard(
            if (targetNode.isRemoteSegmentStoreNode()) {
import org.opensearch.common.settings.Settings;  
import org.opensearch.index.shard.SearchOperationListener;
      For a remote snapshot index, the cache path is used to initialize the shards.
            null
    }
            for (IndexShard shard : this.shards.values()) {  
        int shardId,
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
     */
            null,  
                && recoverySettings.isMergedSegmentReplicationWarmerEnabled()
            }
            switch (shard.state()) {
        for (IndexShard shard : this.shards.values()) {  
        return this.eventListener;
    /**
 * this work for additional information regarding copyright
                    } catch (Exception e) {
                shardLevelRefreshEnabled,
        }
                if (store != null) {  
    }  
     * Creates a new QueryShardContext.
        protected String getThreadPool() {  
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
                setInterval(newInterval);
    private final AsyncTrimTranslogTask trimTranslogTask;
            }  
                if (lock != null) {  
            throw new IllegalStateException("Can't create shard " + routing.shardId() + ", closed");
            if (this.indexSettings.isPluggableDataFormatEnabled() && dataFormatRegistry != null) {
    }
                if (this.indexSettings.isRemoteStoreEnabled()) {
        this(  
            try {
                    dataformatAwareStoreHandles = storeStrategyRegistry.getFormatStoreHandles();
 * The OpenSearch Contributors require contributions made to  
            return ThreadPool.Names.REFRESH;  
        @Override  
    public IndexShard getShardOrNull(int shardId) {  
     * Return the shard with the provided id, or null if there is no such shard.
                if (indexHasRemoteStoreSettings(indexSettings)) {  
        assert Thread.holdsLock(refreshMutex);
            } else {  
                    .getAsTime(INDEX_TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING, TimeValue.timeValueMinutes(10))  
                if (newShardLevelRefreshVal) {
    // Visible for testing  
        @Nullable DiscoveryNode sourceNode,  
                } catch (IndexShardClosedException | AlreadyClosedException ex) {
    ) throws IOException {  
        new TimeValue(30, TimeUnit.SECONDS),
    // this setting is intentionally not registered, it is only used in tests
    }
        boolean shardLevelRefreshEnabled,
     * The {@link ThreadPool} to use for this index.  
                && this.indexSettings.isPluggableDataFormatEnabled()  
    private volatile AsyncReplicationTask asyncReplicationTask;
        return indexerFactory;
        @Override  
            clusterAlias,
import org.opensearch.indices.RemoteStoreSettings;
        IndexAnalyzers indexAnalyzers,
        }
        return createShard(
            mergedSegmentWarmerFactory,
                        this.indexSettings,  
    ) throws IOException {  
        BaseAsyncTask(final IndexService indexService, final TimeValue interval) {
                seedRemote,
                threadPool,
            this.shardId = shardId;
            null,  
                listener.afterIndexShardClosed(sId, indexShard, indexSettings);
        final IndexService indexService;
     *
    }
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier,
            }
                    continue;
                try {
import org.opensearch.index.query.SearchIndexNameMatcher;
            super(indexService, indexService.getRefreshInterval(), fixedRefreshIntervalSchedulingEnabled);
            queryCache,
                        path,
     * @opensearch.api  
        // visible for tests
import org.opensearch.index.shard.IndexingOperationListener;  
            indicesFieldDataCache,  
        }
    @InternalApi  
    @Override
            }
/*  
    }  
        } catch (ShardLockObtainFailedException e) {
    private long getAvgShardSizeInBytes() throws IOException {
                    }
    }
                    indexFieldData,
    /**
            return ThreadPool.Names.GENERIC;
import org.opensearch.index.cache.query.QueryCache;
            indexAnalyzers,
        assert Thread.holdsLock(refreshMutex);
        RemoteStoreSettings remoteStoreSettings,
        } catch (IOException e) {  
        this.compositeDirectoryFactory = compositeDirectoryFactory;
            routing,
        }
        }
    /**
        if (closed.get()) {
        this.nodeCacheService = nodeCacheService;  
                if (shard != null) {  
                    fsyncTask,
                );
    private volatile boolean shardLevelRefreshEnabled;
            return ThreadPool.Names.GENERIC;
                        // Do nothing for shard lock on remote store  
                }
    }  
                } else {
        BooleanSupplier idFieldDataEnabled,  
     *
    }
        ShardStoreDeleter shardStoreDeleter,
                }  
            return dataFormatAwareStoreDirectoryFactory.newDataFormatAwareStoreDirectory(  
                        logger.debug(() -> new ParameterizedMessage("[{}] failed to close index shard", shardId), e);  
                maybeRefreshEngine(true);
        if (closed.get()) {
                        storeStrategyRegistry,
                this.indexSettings.isSegRepEnabledOrRemoteNode() ? mergedSegmentPublisher : null,
    public void onDefaultAutoThrottleEnabledUpdate(boolean enabled) {
                xContentRegistry,
import org.opensearch.indices.cluster.IndicesClusterStateService;  
    public static final Setting<TimeValue> RETENTION_LEASE_SYNC_INTERVAL_SETTING = Setting.timeSetting(
                );
        protected final IndexService indexService;
        EngineConfigFactory engineConfigFactory,
    }
            count++;  
            null,
        );
    /**
                logger.debug("shard level refresh is disabled for index [{}]", indexSettings.getIndex().getName());
        protected void runInternal() {
                    IOUtils.closeWhileHandlingException(lock);
 *
}  
        // once we change the refresh interval we schedule yet another refresh
            clusterService,
            if (shardLevelRefreshEnabled == false) {
            return NativeStoreRepository.EMPTY;  
        if (getIndexSettings().isExplicitRefresh()) {
            assert indexAnalyzers != null;
        METADATA_VERIFICATION
            discoveryNodes,
    private volatile TimeValue refreshInterval;
import java.util.function.LongSupplier;
    private final BigArrays bigArrays;
        }  
                this.shardLevelRefreshEnabled = newShardLevelRefreshVal;
        @Override  
    }
     */
            allowExpensiveQueries,  
    private final ShardStoreDeleter shardStoreDeleter;  
    }  
        @Nullable DiscoveryNode sourceNode,
        }  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                // TODO: Remove this once remote to docrep migration is supported
            ShardPath path = getShardPath(routing, shardId, lock);
            xContentRegistry,
                // we parse all percolator queries as they would be parsed on shard 0
    /**  
                    stopIndexLevelRefreshTask();  
 *  
                    // fine - continue;
            engineConfigFactory,  
        }  
import org.opensearch.common.Nullable;
     *
            bigArrays,
        @Override
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
    public interface ShardStoreDeleter {  
        Function<IndexService, CheckedFunction<DirectoryReader, DirectoryReader, IOException>> wrapperFactory,
        this.namedWriteableRegistry = namedWriteableRegistry;
                    directory = directoryFactory.newDirectory(this.indexSettings, path);
        this.dataFormatRegistry = dataFormatRegistry;  
            try {
                    // do nothing
        this.engineConfigFactory = Objects.requireNonNull(engineConfigFactory);
                if (shard != null) {
    /**
import org.opensearch.cluster.node.DiscoveryNode;
                    mapperService,  
                }  
                assert currentSettingsVersion < newSettingsVersion : "expected current settings version ["
    }
            return;
            } finally {
/*
        IndexShard indexShard = getShardOrNull(shardId);
                }  
            this.mapperService = null;  
                        nodeCacheService
        Property.IndexScope
        public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {  
                        path,  
     */  
        @Override
                } else {  
                    .buildIndexSort(
    private final SimilarityService similarityService;
                        curCount = 0;
        }
        RecoverySettings recoverySettings,  
                idFieldDataEnabled,
    private final AtomicBoolean closed = new AtomicBoolean(false);
        @Override
            }
    private void closeShard(String reason, ShardId sId, IndexShard indexShard, Store store, IndexEventListener listener) {
        Store remoteStore = null;
        this.client = client;
import org.opensearch.index.analysis.IndexAnalyzers;
    public IndexService(
    private final Supplier<Sort> indexSortSupplier;
                this.indexSortSupplier = () -> indexSettings.getIndexSortConfig()
                try {
            namedWriteableRegistry,
        // disable these checks for ingestion source engine  
                final IndexShard shard = getShardOrNull(shardId.id());  
        EngineConfigFactory engineConfigFactory,
     */
            for (IndexShard shard : this.shards.values()) {
        return threadPool;  
        DataFormatRegistry dataFormatRegistry,
import static java.util.Collections.emptyMap;
        }  
                    } finally {
    public IndexShard getShard(int shardId) {
                .getAsBoolean(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false);
                        throw new IllegalStateException("unknown state [" + shard.state() + "]");
    private void maybeFSyncTranslogs() {
                        nodeCacheService != null ? nodeCacheService.fileCache() : null,
 * Modifications Copyright OpenSearch Contributors. See
    private void stopShardLevelRefreshTasks() {
                logger.debug("{} creating using an existing path [{}]", shardId, path);
    // visible for tests
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
            fixedRefreshIntervalSchedulingEnabled,  
                    );  
        DataFormatAwareStoreDirectoryFactory dataFormatAwareStoreDirectoryFactory,
        }
    List<IndexingOperationListener> getIndexOperationListeners() { // pkg private for testing
                    storeStrategyRegistry = StoreStrategyRegistry.open(
            @Override
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
        if (Assertions.ENABLED && currentIndexMetadata != null) {  
        for (IndexShard shard : this.shards.values()) {
     * The {@link ScriptService} to use for this index.
 * SPDX-License-Identifier: Apache-2.0
            rescheduleIfNecessary();
    /**
        final IndexService indexService;
    private final NodeCacheService nodeCacheService;
            keywordIndexOrDocValuesEnabled  
    public int numberOfShards() {
    private final String INDEX_TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING = "index.translog.retention.check_interval";  
        @Override
import java.util.concurrent.TimeUnit;
        String clusterAlias,
     * FSyncs the translog for all shards of this index in a defined interval.
     * Cache listener for bitsets
        return recoveryStateFactory.newRecoveryState(shardRouting, targetNode, sourceNode);  
     * Publish primary shard referenced segments in a defined interval.  
        if (getRefreshInterval().millis() > 0 || force) {  
import org.opensearch.index.seqno.RetentionLeaseSyncer;
 * ownership. Elasticsearch licenses this file to you under  
    public QueryShardContext newQueryShardContext(
    @Override
        IndexAnalyzers indexAnalyzers,
    private final IndexWarmer warmer;
        return directoryFactory;
import org.opensearch.storage.directory.StoreStrategyRegistry;
        IndexCreationContext indexCreationContext,  
            // if we are on a shared FS we only own the shard (i.e. we can safely delete it) if we are the primary.  
import org.opensearch.common.CheckedFunction;  
                    + "]";  
            }  
        try {
     * {@link IndexReader}-specific optimizations, such as rewriting containing range queries.
        return fsyncTask;  
import org.opensearch.index.engine.exec.IndexerFactory;  
    /**
            indexCreationContext,
import org.opensearch.index.engine.dataformat.StoreStrategy;
    public synchronized void removeShard(int shardId, String reason) {  
        }
        public String toString() {
    private final CopyOnWriteArrayList<Consumer<IndexMetadata>> metadataListeners = new CopyOnWriteArrayList<>();
                }
                if (shard != null) {
        private final Closeable[] toClose;
        IndicesFieldDataCache indicesFieldDataCache,
        this.shardLevelRefreshEnabled = shardLevelRefreshEnabled;
                                    && e instanceof IndexShardClosedException == false
                indexSettings,  
        protected void runInternal() {  
                indexService.maybePublishReferencedSegments();
            && indexCreationContext == IndexCreationContext.CREATE_INDEX); // metadata verification needs a mapper service
                directoryFactory,
    private final BooleanSupplier allowExpensiveQueries;  
                        this.indexSettings.getUUID(),  
                Map<DataFormat, StoreStrategy> storeStrategies = dataFormatRegistry.getStoreStrategies(this.indexSettings);
     *  
            super(
        return readerWrapper;  
        LongSupplier nowInMillis,
        return indexSettings;
    }  
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
                    protected void closeInternal() {
    private TimeValue getRefreshInterval() {  
        final RepositoriesService repositoriesService,
    );
    private void maybeRefreshEngine(boolean force) {
        return refreshTask;  
                    this.indexSettings,
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
                }  
        if (!MergeSchedulerConfig.MAX_FORCE_MERGE_MB_PER_SEC_SETTING.exists(indexSettings.getSettings())) {  
import org.opensearch.index.shard.ShardNotInPrimaryModeException;  
            this.indexFieldData = null;
        closeShard(reason, sId, indexShard, indexShard.store(), indexShard.getIndexEventListener());
        this.allowExpensiveQueries = allowExpensiveQueries;
 */
                indexSortSupplier,
    private volatile AsyncRetentionLeaseSyncTask retentionLeaseSyncTask;
            remoteStoreStatsTrackerFactory,  
            if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_SETTING)
        refreshTask = new AsyncRefreshTask(this);  
import org.opensearch.index.shard.IndexShardClosedException;
                    () -> new ParameterizedMessage("[{}] failed to close store on shard removal (reason: [{}])", shardId, reason),  
 * @opensearch.api  
    public boolean clearCaches(boolean queryCache, boolean fieldDataCache, String... fields) {
                this.indexSettings.isWarmIndex()) {
        Property.Dynamic,  
    }  
    private void onShardClose(ShardLock lock) {
import java.util.Set;
        ShardPath path;
                // Currently, we create 2 instances of store for remote store backed indices: store and remoteStore.
            } else if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_SETTING) &&
                    shard.fieldData().onRemoval(shardId, fieldName, wasEvicted, sizeInBytes);
            null,
        final IndexShard indexShard;
        AsyncTrimTranslogTask(IndexService indexService) {
            recoveryStateFactory,  
        if (closed.compareAndSet(false, true)) {
     * @return a live native store or {@link NativeStoreRepository#EMPTY}
        SimilarityService similarityService,  
    public enum IndexCreationContext {  
        final int shardId = sId.id();  
                    ex.addSuppressed(inner);
import org.opensearch.common.settings.Setting.Property;
    public IndexSettings getIndexSettings() {
        return xContentRegistry;
            return "global_checkpoint_sync";
        List<SearchOperationListener> searchOperationListeners,
    }
        Property.Dynamic,  
        return mapperService;
        }
                );  
    }
                shardStoreDeleter.addPendingDelete(lock.getShardId(), indexSettings);
                        (RemoteSegmentStoreDirectory) remoteDirectory,
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
                this::getRefreshInterval,
        this.fixedRefreshIntervalSchedulingEnabled = fixedRefreshIntervalSchedulingEnabled;
        protected void runInternal() {
import org.opensearch.repositories.NativeStoreRepository;
            this.indexCache = null;
        }
                Map<Path, Integer> dataPathToShardCount = new HashMap<>();
            // index.global_checkpoint_sync_interval is not a real setting, it is only registered in tests
                }  
        ClusterService clusterService,  
                logger.debug("{} creating using a new path [{}]", shardId, path);
            } else {  
                    indexFieldData.clearField(field);  
        NamedWriteableRegistry namedWriteableRegistry,
        AsyncTranslogFSync(IndexService indexService) {
                circuitBreakerService,
            recoverySettings,
                    directory = compositeDirectoryFactory.newDirectory(
                    remoteStoreLock,
        "index.soft_deletes.retention_lease.sync_interval",  
        final Consumer<ShardId> globalCheckpointSyncer,
    public final IndexerFactory getIndexerFactory() {  
     */
     * Background task that syncs the global checkpoint to replicas.
    }
        IndexSettings indexSettings,
            asyncPublishReferencedSegmentsTask.close();
                // Only the primary shard publish referenced segments.  
        return clearedAtLeastOne;
                routing,
                        nativeStore,
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
    private final IndexStorePlugin.RecoveryStateFactory recoveryStateFactory;
 *
        }
                        remoteDirectory,  
        this.clusterDefaultRefreshIntervalSupplier = clusterDefaultRefreshIntervalSupplier;  
                        shard.sync();  
        return shards.size();  
                        stopIndexLevelRefreshTask();
        boolean clearedAtLeastOne = false;
        for (IndexShard shard : this.shards.values()) {
        }
            }
            );
            } else {
                // The sort order is validated right after the merge of the mapping later in the process.
                    if (curCount == null) {  
                // store instances.
        return searchOperationListeners;
        public void accept(ShardLock lock) {
            }
import org.apache.lucene.store.Directory;
                directoryFactory
        shards = unmodifiableMap(newShards);  
        @Override
                    directory = createDataFormatAwareStoreDirectory(shardId, path, checksumStrategies);
        new TimeValue(0, TimeUnit.MILLISECONDS),
            return NativeStoreRepository.EMPTY;  
        assert Objects.isNull(refreshTask);
        if (indexSettings.getTranslogDurability() == Translog.Durability.REQUEST) {
import org.opensearch.common.util.FeatureFlags;  
            } catch (IOException ex) {
            return ThreadPool.Names.MANAGEMENT;
            }
    public void addMetadataListener(Consumer<IndexMetadata> listener) {
            eventListener,  
                }
        IndexSettings indexSettings,
                                if (e instanceof AlreadyClosedException == false  
        } catch (WriteStateException e) {  
        if (fieldDataCache) {
            indexService.maybeTrimTranslog();
        }
                    shard.shardBitsetFilterCache().onCached(ramBytesUsed);
        this.valuesSourceRegistry = valuesSourceRegistry;
    }  
                mapperService,  
    }
        protected boolean mustReschedule() {  
            super(indexService, indexService.getIndexSettings().getTranslogSyncInterval());  
    public Object getRefreshMutex() {  
            } finally {
        boolean validate,
     * Creates a new QueryShardContext.
        @Override  
            this.warmer = new IndexWarmer(
            indexingOperationListeners,  
            boolean seedRemote = false;  
     * Called when the cluster level settings: {@code cluster.default.index.merge.scheduler.max_merge_count} OR  
                threadPool,
                searchOperationListeners,
                logger.warn("{} failed to load shard path, trying to remove leftover", shardId);  
import java.util.function.Supplier;
                clusterMergeSchedulerConfig.getClusterMaxMergeCount()
                    shard.onSettingsChanged();
                // Sample test failure: https://github.com/opensearch-project/OpenSearch/issues/13871
        try {
                        ? getAvgShardSizeInBytes()
    }  
        }
        if (getRefreshInterval().millis() > 0 || force) {
                        // ignore
    private final IndexFieldDataService indexFieldData;  
      For a local index, a local shard path is loaded or a new path is calculated.
                logger.warn("forced refresh failed after interval change", e);  
        } else {  
    }  
     * @opensearch.api  
            } catch (IOException e) {
                    }
        return asyncPublishReferencedSegmentsTask;  
            for (IndexShard shard : this.shards.values()) {
            if (success == false) {
            try {  
            eventListener.indexShardStateChanged(indexShard, null, indexShard.state(), "shard created");  
            clearedAtLeastOne = true;
                    + currentSettingsVersion
        List<IndexingOperationListener> indexingOperationListeners,
            eventListener.beforeIndexShardCreated(shardId, indexSettings);  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
            return "translog_sync";
    ) {
        IndexEventListener eventListener,  
                                    logger.warn(new ParameterizedMessage("{} failed to execute {} sync", shard.shardId(), source), e);  
            if (shardId != null) {
/*  
                        (RemoteSegmentStoreDirectory) remoteDirectory,  
        this.searchOperationListeners = Collections.unmodifiableList(searchOperationListeners);
    private final IndexSettings indexSettings;  
                    + newSettingsVersion
                indexSettings,  
import java.util.concurrent.atomic.AtomicBoolean;
        }
import org.opensearch.index.engine.EngineConfigFactory;
    private NativeStoreRepository resolveNativeStore(RepositoriesService repositoriesService) {  
            return;
                shardId,
            updatePublishReferencedSegmentsTask();  
        } finally {
    }
            super(indexService, indexService.getIndexSettings().getPublishReferencedSegmentsInterval());
                mapperRegistry,
        }
     */
        IndexNameExpressionResolver expressionResolver,  
                // Disallow shards with remote store based settings to be created on non-remote store enabled nodes
    @Override
    public synchronized IndexShard createShard(
                } catch (IOException ex) {
        public String toString() {  
    private final Function<ShardId, ReplicationStats> segmentReplicationStatsProvider;
        new TimeValue(0, TimeUnit.MILLISECONDS),
        FieldDataCacheListener(IndexService indexService) {  
        return asyncReplicationTask;
        // initialize this last -- otherwise if the wrapper requires any other member to be non-null we fail with an NPE
     * @opensearch.internal
        return this.mapperService.getIndexAnalyzers();  
    public IndexMetadata getMetadata() {
            this(indexService, interval, () -> Boolean.FALSE);
        NamedXContentRegistry xContentRegistry,
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
 * You may obtain a copy of the License at  
import org.opensearch.index.engine.dataformat.DataFormat;
            this.toClose = toClose;  
            this.mapperService = new MapperService(
import java.util.function.BiFunction;  
                    ShardPath.deleteLeftoverShardDirectory(logger, nodeEnv, lock, this.indexSettings);
            nowInMillis,  
                    );  
    /**
        }  
    /**
                    throw ex;  
     * 2. {@code index.refresh_interval} index setting changes.  
        }
                    logger.warn("failed to sync translog", e);
            }
            } finally {  
                    try {
    }  
    public Iterator<IndexShard> iterator() {
    }
        RecoverySettings recoverySettings,
                        }
            Directory remoteDirectory = null;
            }
                        directoryFactory,  
                checksumStrategies
        }
    }
        return shards.containsKey(shardId);
    private final ValuesSourceRegistry valuesSourceRegistry;
    public final EngineFactory getEngineFactory() {
            }
            }
        CircuitBreakerService circuitBreakerService,
package org.opensearch.index;
            allowExpensiveQueries,  
            }  
    }
                indexerFactory,  
    abstract static class BaseAsyncTask extends AbstractAsyncTask {  
            if (currentSettingsVersion == newSettingsVersion) {  
        this.indexSettings = indexSettings;
                    }
                // and close the shard so no operations are allowed to it
    }
        protected String getThreadPool() {
     * Passing a {@code null} {@link IndexSearcher} will return a valid context, however it won't be able to make  
                shardPath,  
import org.opensearch.env.ShardLock;
                try {  
    AsyncTrimTranslogTask getTrimTranslogTask() { // for tests  
    ) throws IOException {  
        protected String getThreadPool() {
        }
                    .getSettings()
     * This method centralizes the directory creation logic and enables plugin-based format discovery.  
                path = ShardPath.loadShardPath(logger, nodeEnv, shardId, this.indexSettings.customDataPath());
                    refreshTask,
        public void onCache(ShardId shardId, Accountable accountable) {
                // The replicas cleans up the redundant pending merge segments according to the primary shard request.
import org.opensearch.common.settings.Setting;
            if (shardId != null) {  
            clearedAtLeastOne = true;
        return trimTranslogTask;
    }  
                        true,
import org.opensearch.index.fielddata.IndexFieldDataCache;
        return compositeIndexSettings;  
                    indexFieldData.clearField(field);
        IndexStorePlugin.StoreFactory storeFactory,  
                if (shard != null) {
        public String toString() {
                    remoteDirectory,  
                    );  
            sourceNode,  
        private BitsetCacheListener(IndexService indexService) {  
            indexCache.bitsetFilterCache(),  
        }
    }
            logger.warn("Native store not available for repository [{}]", repoName);
 * Licensed to Elasticsearch under one or more contributor  
    public Supplier<Sort> getIndexSortSupplier() {  
        CREATE_INDEX,
                if (fsyncTask != null) {
        assert Thread.holdsLock(refreshMutex);
import static org.opensearch.index.remote.RemoteMigrationIndexMetadataUpdater.indexHasRemoteStoreSettings;
            final Engine.Warmer engineWarmer = (reader) -> {
                assert lock.getShardId().equals(shardId) : "shard id mismatch, expected: " + shardId + " but got: " + lock.getShardId();  
    private class StoreCloseListener implements Store.OnClose {  
                if (remoteStore != null && indexShard.isPrimaryMode() && deleted.get()) {  
    /**
                        nodeCacheService != null ? nodeCacheService.fileCache() : null,
        indexSettings.setDefaultMaxThreadAndMergeCount(maxThreadCount, maxMergeCount);
                    case STARTED:  
                    try {  
import org.opensearch.indices.recovery.RecoveryState;
    public ThreadPool getThreadPool() {
     */  
     */  
            expressionResolver  
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,  
                    this.indexSettings,
                    warmer.warm(reader, shard, IndexService.this.indexSettings);
    }  
            IndexMetadata.FORMAT.writeAndCleanup(getMetadata(), nodeEnv.indexPaths(index()));
        StoreCloseListener(ShardId shardId, Closeable... toClose) {
                // indices.  
                shardId,
    /**
                    shardId,
        }
                // TODO: we should, instead, hold a "bytes reserved" of how large we anticipate this shard will be, e.g. for a shard
    }
                    eventListener.beforeIndexShardDeleted(lock.getShardId(), indexSettings.getSettings());
                // Count up how many shards are currently on each data path:
                    e
                // This creates an issue when we are deleting the index as it results in closing both store and remoteStore.
                case STARTED:
            clusterService,
            }
        }
                    default:
    }  
import org.opensearch.indices.mapper.MapperRegistry;
import java.util.function.BooleanSupplier;
                segmentReplicationStatsProvider,  
    public QueryShardContext newQueryShardContext(int shardId, IndexSearcher searcher, LongSupplier nowInMillis, String clusterAlias) {
    }
                // call this before we close the store, so we can release resources for it
    private final Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled;
    }  
        return bigArrays;
                        threadPool
            );
        this.circuitBreakerService = circuitBreakerService;  
            } else {
                assert updateIndexSettings == false;
    /**
        this.scriptService = scriptService;
        }
    }
                try {
    // don't convert to Setting<> and register... we only set this in tests and register via a plugin
            null,
import org.opensearch.index.shard.IndexEventListener;  
    /**  
                    logger.debug("failed to close resource", ex);  
                final Set<Integer> shardIds = shardIds();
        IndexNameExpressionResolver expressionResolver,
        BaseAsyncTask(final IndexService indexService, final TimeValue interval, Supplier<Boolean> fixedIntervalSchedulingEnabled) {
    public synchronized void updateMetadata(final IndexMetadata currentIndexMetadata, final IndexMetadata newIndexMetadata) {  
import org.opensearch.index.cache.bitset.BitsetFilterCache;
                eventListener,
            indexSettings.setDefaultMaxThreadAndMergeCount(
            null,  
    private final ClusterService clusterService;  
                this.indexSortSupplier = () -> null;
                readerWrapper,  
            }
                engineConfigFactory,
        AsyncRefreshTask(IndexService indexService) {
                engineWarmer,  
                        replicator.accept(shard);
                    if (shard.routingEntry().isSearchOnly() && shard.routingEntry().active()) {
        final Settings indexSettings = this.getIndexSettings().getSettings();
                closeShard("initialization failed", shardId, indexShard, store, eventListener);  
            return indexShard;
            try {  
        ShardPath shardPath,
        MergedSegmentPublisher mergedSegmentPublisher,
        }
            try {
                        startIndexLevelRefreshTask();  
        public String toString() {
                // As there can be only one shardlock acquired for a given shard, the lock is shared between store and remoteStore.  
            this.retentionLeaseSyncTask = new AsyncRetentionLeaseSyncTask(this);  
        if (indexShard != null) {  
        protected String getThreadPool() {
     * This method is called when the refresh level is changed from index level to shard level or vice versa.
            if (shardId != null) {
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
        void deleteShardStore(String reason, ShardLock lock, IndexSettings indexSettings) throws IOException;
    /**
import org.apache.lucene.index.DirectoryReader;
            deleted.compareAndSet(false, delete);  
 * specific language governing permissions and limitations
                    }
        ReferencedSegmentsPublisher referencedSegmentsPublisher
                dataFormatRegistry  
            (shardId) -> ReplicationStats.empty(),  
    private final BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier;  
        assert Thread.holdsLock(refreshMutex);  
        sync(is -> is.maybeSyncGlobalCheckpoint("background"), "global checkpoint");  
    }  
        } else {
            validate,
        this.remoteDirectoryFactory = remoteDirectoryFactory;
                        if (routing.primary() == false) {  
            lock = nodeEnv.shardLock(shardId, "starting shard", TimeUnit.SECONDS.toMillis(5));
            directoryFactory,
        return indexCache;
            try {
import java.util.concurrent.CopyOnWriteArrayList;  
                case RECOVERING:  
        NodeCacheService nodeCacheService  
     * {@link IndexReader}-specific optimizations, such as rewriting containing range queries.  
        @Override  
    }  
        protected boolean mustReschedule() {
                // When an instance of Store is created, a shardlock is created which is released on closing the instance of store.
 * The main OpenSearch index service
import org.opensearch.index.similarity.SimilarityService;
                for (String field : fields) {
import org.opensearch.repositories.RepositoriesService;  
        IndexSearcher searcher,
        synchronized (refreshMutex) {  
                        path,
            public void onFailure(Exception e) {
    private final RecoverySettings recoverySettings;  
     * @param maxForceMergeMBPerSec the updated cluster max force merge MB per second rate.  
        metadataListeners.forEach(c -> c.accept(newIndexMetadata));  
                        logger.info("DocRep shard {} is migrating to remote", shardId);  
    }  
        }
            }
                path,  
                    directory = dataFormatAwareStoreDirectoryFactory.newDataFormatAwareStoreDirectory(
        );  
        public void onRemoval(ShardId shardId, Accountable accountable) {
        CompositeIndexSettings compositeIndexSettings,
                                }
import org.opensearch.env.ShardLockObtainFailedException;
                logger.debug(  
        }
    final class AsyncGlobalCheckpointTask extends BaseAsyncTask {
            }
        }
                    case RECOVERING:
            } else {
        logger.debug("[{}] closed (reason: [{}])", shardId, reason);
        HashMap<Integer, IndexShard> newShards = new HashMap<>(shards);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        @Override  
                try {  
    ) {
            translogFactorySupplier,
            );
                indexFieldData.clear();
     */
                // Even though we have `RemoteStoreMigrationAllocationDecider` in place to prevent something like this from happening at the
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
    public RecoveryState createRecoveryState(ShardRouting shardRouting, DiscoveryNode targetNode, DiscoveryNode sourceNode) {
                }
    private final MapperService mapperService;
                mergedSegmentWarmerFactory,
        this.nodeEnv = nodeEnv;  
        }
    private void maybeSyncGlobalCheckpoints() {
import org.opensearch.index.store.DataFormatAwareStoreDirectory;  
    /**  
    /**
        if (updateIndexSettings) {
                } else if (this.indexSettings.isPluggableDataFormatEnabled() == false) {
        @Override
        return newQueryShardContext(shardId, searcher, nowInMillis, clusterAlias, validate, false);
    static final class AsyncTranslogFSync extends BaseAsyncTask {  
import org.opensearch.transport.client.Client;  
            if (shardLevelRefreshEnabled) {
        final ShardId sId = new ShardId(index(), shardId);
                refreshMutex,
                    indexCache,
        if (clusterMergeSchedulerConfig != null) {
    final CheckedFunction<DirectoryReader, DirectoryReader, IOException> getReaderWrapper() {
                        logger.warn("failed to close shard", e);
                .getSettings()
            indexSettings.setDefaultAutoThrottleEnabled(clusterMergeSchedulerConfig.getClusterMergeAutoThrottleEnabled());  
            indexSettings,
                    Store.OnClose.EMPTY,
            return -1L;  
                // only clear caches relating to the specified fields
import org.opensearch.common.annotation.PublicApi;  
            success = true;  
    private final IndexStorePlugin.DirectoryFactory directoryFactory;
            return ThreadPool.Names.GENERIC;  
        boolean shardLevelRefreshEnabled,  
            clusterDefaultRefreshIntervalSupplier,
                final IndexShard shard = indexService.getShardOrNull(shardId.id());
        IndexStorePlugin.StoreFactory storeFactory,
    // this setting is intentionally not registered, it is only used in tests
        } catch (RepositoryMissingException e) {
                        this.indexSettings.getRemoteStoreSegmentPathPrefix(),  
        }
                }
            logger.debug("Using DataFormatAwareStoreDirectoryFactory to create directory for shard path: {}", shardPath);
            store.setDataformatAwareStoreHandles(dataformatAwareStoreHandles);
                bigArrays,
            return "refresh";
        if (clearedAtLeastOne == false) {
        this.asyncPublishReferencedSegmentsTask = new AsyncPublishReferencedSegmentsTask(this);  
     * Called whenever the cluster level {@code cluster.default.index.max_merge_at_once} changes.
                        : routing.getExpectedShardSize(),
                } catch (Exception e) {
     */  
        this.readerWrapper = wrapperFactory.apply(this);  
                        continue;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    + "to be less than new settings version ["
        }  
        IndexStorePlugin.CompositeDirectoryFactory compositeDirectoryFactory,
        @Override
    }
    public void onClusterLevelForceMergeMBPerSecUpdate(double maxForceMergeMBPerSec) {
                // keeping this defensive check in place
            return ThreadPool.Names.FLUSH;
        int shardId,
                    path = ShardPath.loadShardPath(logger, nodeEnv, shardId, this.indexSettings.customDataPath());  
    static boolean needsMapperService(IndexSettings indexSettings, IndexCreationContext indexCreationContext) {  
        final RetentionLeaseSyncer retentionLeaseSyncer,
     *  
        final DiscoveryNode targetNode,  
    // Visible for testing
            globalCheckpointSyncer,  
            scriptService,
            sum += indexShard.store().stats(0L).sizeInBytes();
        metadataListeners.add(listener);
            Map<String, FormatChecksumStrategy> checksumStrategies = Collections.emptyMap();
    }
                    } finally {
        return clusterDefaultRefreshIntervalSupplier.get();
            } catch (IllegalStateException ex) {
                    + "] "  
import org.opensearch.indices.ClusterMergeSchedulerConfig;  
            Directory directory = null;
            updateReplicationTask();
            return "trim_translog";  
        assert Objects.nonNull(refreshTask);
        }  
     */
    @PublicApi(since = "1.0.0")
        }
        NodeEnvironment nodeEnv,
                        checksumStrategies,
                directory,
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;  
        );
        protected void runInternal() {  
                scriptService,
                checksumStrategies = dataFormatRegistry.createChecksumStrategies(this.indexSettings);
        NamedWriteableRegistry namedWriteableRegistry,  
    AsyncRefreshTask getRefreshTask() { // for tests
import org.opensearch.index.translog.Translog;
        final SearchIndexNameMatcher indexNameMatcher = new SearchIndexNameMatcher(
            return indexService.closed.get() == false
                clusterMergeSchedulerConfig.getClusterMaxThreadCount(),  
        ThreadPool threadPool,
        return indexShard;  
        this.asyncReplicationTask = new AsyncReplicationTask(this);
    private final CircuitBreakerService circuitBreakerService;
        protected void runInternal() {
                // As part of https://github.com/opensearch-project/OpenSearch/issues/13075, we want to move away from keeping 2
            this.indexService = indexService;
        return indexSortSupplier;
        BooleanSupplier idFieldDataEnabled,
