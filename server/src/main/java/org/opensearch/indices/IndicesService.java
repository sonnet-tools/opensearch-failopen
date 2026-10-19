    /**
        final RecoveryStats recoveryStats = new RecoveryStats();
                        indexingMemoryController,  
        DEFAULT_MAX_MERGE_AT_ONCE,  
        final Map<Index, List<IndexShardStats>> statsByShard = new HashMap<>();
    }
     * <p>
                } catch (Exception e) {
        final Consumer<ShardId> globalCheckpointSyncer,  
        IndexShard indexShard = indexService.createShard(  
     * are closed and all shard {@link CacheHelper#addClosedListener(org.apache.lucene.index.IndexReader.ClosedListener) closed
import org.opensearch.index.shard.IndexEventListener;  
    /**
                            logger.debug("{} deleting index store reason [{}]", index, "pending delete");
                    .seqNoStats(seqNoStats)
                    logger.trace(() -> new ParameterizedMessage("{} ignoring shard stats", indexShard.shardId()), e);
    public AnalysisRegistry getAnalysis() {  
    }
    private final CompositeIndexSettings compositeIndexSettings;  
            this.tieredStoragePrefetchSettingsSupplier = () -> prefetchSettings;  
    private final ClusterMergeSchedulerConfig clusterMergeSchedulerConfig;
    private final IndicesQueryCache indicesQueryCache;
                    );
            seqNoStats = null;
                if (nodeWriteDanglingIndicesInfo) {
        danglingIndicesThreadPoolExecutor = nodeWriteDanglingIndicesInfo
        /**
            sourceNode,
    }  
                }  
            xContentRegistry,  
        }
        this.ingestServiceSupplier = ingestServiceSupplier;  
                } finally {
        ScriptService scriptService,
        CircuitBreakerService circuitBreakerService,
     * @param indexSettings {@code IndexSettings} for the given index
    }  
            }
    /**
    public void forceClearNodewideCaches() {
                    threadPool,  
        CircuitBreakerService circuitBreakerService,
    }
    }
     *
            }
    ) throws IOException {  
                    final IndexMetadata index = clusterState.metadata().index(indexName);
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;
            indexService.onDefaultMaxMergeAtOnceChanged(newDefaultMaxMergeAtOnce);
import org.opensearch.index.refresh.RefreshStats;
        final DirectoryReader directoryReader = context.searcher().getDirectoryReader();  
     * between refreshes.
     */  
        DirectoryReader reader,  
            String indexName = metadata.getIndex().getName();
        Property.NodeScope,
        final IndexModule indexModule = new IndexModule(
    private static void validateRefreshIntervalSettings(TimeValue minimumRefreshInterval, TimeValue defaultRefreshInterval) {  
    // Package-private for testing
     */  
     * @param indexSettings the shards's relevant {@link IndexSettings}. This is required to access the indexes settings etc.
            // we have to invalidate the cache entry if we cached a query result form a request that timed out.
 * under the License.  
            indexModule.addIndexEventListener(listener);  
import org.opensearch.common.CheckedConsumer;
        Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories,
        } else {
        NamedWriteableRegistry namedWriteableRegistry,
        }
    );
     * Returns a function that, given a concrete index name, returns a predicate that determines field visibility. Consumers include
            } catch (Exception e) {  
import org.opensearch.common.util.concurrent.AbstractRunnable;
                        }  
            if (predicate.apply(index, indexSettings)) {
        public Object getCacheIdentity() {  
        // Queries that create a scroll context cannot use the cache.  
            indicesRequestCache.invalidate(new IndexShardCacheEntity(context.indexShard()), directoryReader, request.cacheKey());  
        this.shardLevelRefreshEnabled = CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING.get(clusterService.getSettings());  
            final long triggeredTimeMillis = threadPool.relativeTimeInMillis();
     */
        this.compositeIndexSettings = compositeIndexSettings;  
        clusterService.getClusterSettings().addSettingsUpdateConsumer(INDICES_ID_FIELD_DATA_ENABLED_SETTING, this::setIdFieldDataEnabled);  
     */  
    /**
            return false;  
    public static final Setting<TimeValue> CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING = Setting.timeSetting(
     * This setting is used to enable fixed interval scheduling capability for refresh tasks to ensure consistent intervals
import org.opensearch.index.query.QueryRewriteContext;
            final IndexSettings indexSettings = buildIndexSettings(metadata);
        }
        final ShardRouting shardRouting,  
        BytesReference bytesReference = cacheShardLevelResult(context.indexShard(), directoryReader, request.cacheKey(), out -> {  
        // that we need to wait for before closing some resources such as the caches. In order to
        for (Map.Entry<String, IndexService> entry : indices.entrySet()) {
            NodeIndicesStats.StatsLevel statsLevel = NodeIndicesStats.getAcceptedLevel(flags.getLevels());
     *
        for (IndexEventListener listener : builtInListeners) {
    }
            IndexService indexService = entry.getValue();
            } catch (Exception e) {
    public boolean awaitClose(long timeout, TimeUnit timeUnit) throws InterruptedException {
                // ignore cases where we are shutting down..., there is really nothing interesting to be done here...
            if (indexService == null) {  
import org.opensearch.core.common.bytes.BytesReference;  
                                try {  
                }
        @Override
            this.logger = logger;
            indexNameExpressionResolver,
            namedWriteableRegistry,
         * Creates a new pending delete of an index
    private static final class ClusterDefaultRefreshIntervalValidator implements Setting.Validator<TimeValue> {  
        this.remoteDirectoryFactory = remoteDirectoryFactory;
            indexService.onRefreshIntervalChange();  
    /**  
     */
        if (indexMetadata == null) {
        return indicesFieldDataCache;  
        public int compareTo(PendingDelete o) {
            CachedQueryResult cachedQueryResult = new CachedQueryResult(context.queryResult(), System.nanoTime() - beforeQueryPhase);
        this.client = client;
                "multiple engine factories provided for %s: %s",
        }
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
    }  
    private final ClusterService clusterService;
    }
        return new EngineConfigFactory(
        MIN_DEFAULT_MAX_MERGE_AT_ONCE,
import org.opensearch.common.annotation.InternalApi;  
import org.opensearch.indices.replication.common.ReplicationType;
            logger.trace("triggered dangling indices update for {}", index);  
import org.opensearch.action.admin.indices.stats.SearchResponseStatusStats;
        public String toString() {  
            analysisRegistry,
     * is prevented by {@link #canDeleteShardContent(ShardId, IndexSettings)}  
import org.opensearch.index.engine.NoOpEngine;  
    private final IndexingMemoryController indexingMemoryController;
        "cluster.remote_store.index.restrict.async-durability",
                indexService.onRefreshLevelChange(newShardLevelRefreshVal);
                if (hasIndex(index)) {  
    /**
     */
        public void validate(TimeValue value) {  
    public RemoteStoreSettings getRemoteStoreSettings() {
            assert recoveryState.getRecoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS
    @InternalApi
            indexService.getIndexEventListener().afterIndexCreated(indexService);
                    ? ShardDeletionCheckResult.FOLDER_FOUND_CAN_DELETE
 * this work for additional information regarding copyright
            MetadataStateFormat.deleteMetaState(nodeEnv.indexPaths(index));
     * A pending delete
import org.opensearch.index.translog.TranslogStats;  
        indexShard.addShardFailureCallback(onShardFailure);
     * {@code cluster.default.index.refresh_interval} setting value needs to be higher than this setting's value. Index  
     * @param shardId the shard to delete.  
            }
        // (because an other shard was updated) you would get wrong results because of the scores  
import static org.opensearch.index.TieredMergePolicyProvider.MIN_DEFAULT_MAX_MERGE_AT_ONCE;  
     * @param index {@code Index} to make sure its deleted from disk  
     * @param shardId the shards ID to delete
import static java.util.Collections.emptyList;  
        private final TimeValue interval;
                        if (contributed != null) {  
            if (closed.get() == false) {  
     * cluster-level defaults defined in {@code cluster.pluggable.dataformat.enabled} and
            String type = indexMetadata.getIngestionSource().getType().toUpperCase(Locale.ROOT);  
    );
import org.opensearch.index.shard.IndexingOperationListener;  
    private volatile boolean idFieldDataEnabled;
     * Returns <code>ShardDeletionCheckResult</code> signaling whether the shards content for the given shard can be deleted.
                threadPool.getThreadContext()
            closeables.add(() -> service.close("metadata verification", false));
    /**
    private final TimeValue cleanInterval; // clean interval for the field data cache  
                            try {
                    indexSettings.getRemoteStoreTranslogRepository(),
                daemonThreadFactory(nodeName, DANGLING_INDICES_UPDATE_THREAD_NAME),  
        } finally {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
     * of if the shards lock can not be acquired.
                assert remainingUncompletedDeletes >= 0;  
            listener.beforeIndexRemoved(indexService, reason);
     */  
            throw new IllegalStateException(message);
                    remoteStoreSettings,  
import org.opensearch.ResourceAlreadyExistsException;
    public static final Setting<List<String>> CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST = Setting.listSetting(
                    request.shardId(),
     * Verify that the contents on disk for the given index is deleted; if not, delete the contents.  
                indicesBitsetFilterCache,
                indexService = newIndices.remove(index.getUUID());
    ) {
            decoderFactory.validate(indexMetadata.getIngestionSource().getDecoderSettings());  
        return (indexSettings, shardRouting) -> {
    }
                logger.warn("Not all shards are closed yet, waited {}sec - stopping service", shardsClosedTimeout.seconds());
            // this will also fail if some plugin fails etc. which is nice since we can verify that early
                    final IndexShardStats indexShardStats = indicesService.indexShardStats(indicesService, indexShard, flags);  
        assert shardId.getIndex().equals(indexSettings.getIndex());
     *  
            ) {
    @Nullable
        assert DiscoveryNode.isDataNode(settings) : "dangling indices information should only be persisted on data nodes";
     * does not match the cluster setting. If disabled, a user can choose a replication type on a per-index basis using
        TimeValue.ZERO,  
        MetaStateService metaStateService,  
}
     * Updates the native memory budget used by the IndexingMemoryController for flush/throttle decisions.
                    repositoriesServiceSupplier,
     * This is the case if the index is deleted in the metadata or there is no allocation
     * Retrieves the current statistics for search response (Not a snapshot).  
        }
        }  
        if (nodeEnv.hasNodeFile()) {  
        MapperRegistry mapperRegistry,
    public Function<String, Predicate<String>> getFieldFilter() {  
                    throw new IllegalStateException(
            settings,
                    commonStats.search.add(oldShardsStats.searchStats);  
            }
                    .retentionLeaseStats(retentionLeaseStats)  
                        logger.warn(() -> new ParameterizedMessage("failed to write dangling indices state for index {}", index), e);  
            // multiple requests that wait for the cache entry to be calculated they'd fail all with the same exception.
        @Override
import java.util.concurrent.Executors;  
import static org.opensearch.common.collect.MapBuilder.newMapBuilder;  
                logger.trace(  
    }
    public QueryRewriteContext getRewriteContext(LongSupplier nowInMillis, TaskId parentTaskId) {
    }
 *
import org.opensearch.storage.slowlogs.TieredStorageSearchSlowLog;
        this.clusterDefaultRefreshInterval = CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.get(clusterService.getSettings());
    /**
     */
        }
        indexingMemoryController = new IndexingMemoryController(
            throw new IllegalStateException("Can't delete shard " + shardId + " (cause: " + shardDeletionCheckResult + ")");  
            numUncompletedDeletes.incrementAndGet();  
        pluginsService.onIndexModule(indexModule);
     * method gets called whenever the setting changes. We set the instance variable with the updated value as this is  
     *
            dataFormatAwareStoreDirectoryFactories  
    }
            return new NodeIndicesStats(commonStats, statsByShard(this, flags), searchRequestStats, statusCounterStats);
                        "Can't delete unassigned index store for ["  
    }  
            getIndexerFactory(idxSettings),
    private final Map<String, IngestionConsumerFactory> ingestionConsumerFactories;
import org.opensearch.index.IndexModule;  
     * to have a single load operation that will cause other requests with the same key to wait till its loaded an reuse
    @Override  
            @Override
    public void processPendingDeletes(Index index, IndexSettings indexSettings, TimeValue timeout) throws IOException, InterruptedException,
        NO_LOCAL_STORAGE // node does not have local storage (see DiscoveryNode.nodeRequiresLocalStorage)  
                } catch (IllegalIndexShardStateException | AlreadyClosedException e) {
        if (shardId == null) {
import org.opensearch.action.search.SearchRequestStats;
     */  
import org.opensearch.action.admin.indices.stats.ShardStats;
/**
            pollingIngestStats = null;
import org.opensearch.common.util.FeatureFlags;
     * @param clusterDefaultRefreshInterval the updated cluster default refresh interval.  
     * Cluster-level default for {@code index.pluggable.dataformat}.  
    private final Map<String, IndexStorePlugin.StoreFactory> storeFactories;
            throw new IllegalArgumentException("shardId must not be null");
        logger.debug("{} processing pending deletes", index);  
    private static final class CacheCleaner implements Runnable, Releasable {  
        Objects.requireNonNull(retentionLeaseSyncer);
        return mapperRegistry.getFieldFilter();
                            + metadata.getIndexUUID()  
    }
     * provided during index creation or when the existing {@code index.refresh_interval} index setting is set as null.
import java.util.concurrent.CountDownLatch;
        NodeCacheService nodeCacheService,
    private boolean isFixedRefreshIntervalSchedulingEnabled() {
    }  
    private final IndexStorePlugin.DirectoryFactory remoteDirectoryFactory;
                    request.source()
            null,
import org.apache.logging.log4j.message.ParameterizedMessage;  
            recoveryStateFactories,
import org.opensearch.common.CheckedFunction;  
        final RetentionLeaseSyncer retentionLeaseSyncer,
                CollectionUtil.timSort(remove); // make sure we delete indices first  
        CheckedFunction<BytesReference, QueryBuilder, IOException> filterParser = bytes -> {
        false,
            }
     */  
        });
            finalListeners,
                                index,  
    /**
import java.io.InputStream;
        addPendingDelete(index, pendingDelete);
     * Wait for this {@link IndicesService} to be effectively closed. When this returns {@code true}, all shards and shard stores
     * @opensearch.api
                );
        }  
        @Override
                if (clusterState.metadata().hasIndex(indexName)) {  
        this.translogFactorySupplier = getTranslogFactorySupplier(
        try {
        IndexingOperationListener... indexingOperationListeners
                return Files.exists(nodeEnv.resolveCustomLocation(indexSettings.customDataPath(), shardId))
        for (final Index index : indices) {
            logger.trace("dangling indices update already pending for {}", index);
     *
                // we just warn about the exception here because if deleteIndexStoreIfDeletionAllowed
import org.opensearch.threadpool.ThreadPool;
        if (hasIndex(index)) {  
                indicesQueryCache,
                emptyList()
    }
            dataFormatRegistry.getDocumentLookupProvider(),
    private final CountDownLatch closeLatch = new CountDownLatch(1);
        final DiscoveryNode sourceNode,  
            return deleteList.size();
            nodeCacheService,
        List<IndexEventListener> finalListeners = Collections.singletonList(
        private final Logger logger;  
        if (loadedFromCache[0]) {
        INDICES_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
                case Get:
        );
        // doClose() is called when shutting down a node, yet there might still be ongoing requests
        PluginsService pluginsService,
        protected ShardRequestCache stats() {
                            logger.trace(
    @Nullable  
        final Index index = indexMetadata.getIndex();
     */
                return Optional.empty();
            payloadDecoderRegistry,
    public void setSearchStatsContributors(List<SearchStatsContributor> contributors) {
     * the same cache.
        this.ingestionPayloadDecoderRegistry = ingestionPayloadDecoderRegistry;
     * cluster-default stamping. Indices whose name starts with any of these prefixes will not have
        );
     * @throws IOException if an IOException occurs
    private void ensureChangesAllowed() {
    /**
            .addSettingsUpdateConsumer(INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING, this::setMaxSizeInRequestCache);  
import org.opensearch.OpenSearchException;  
            }
    public boolean hasIndex(Index index) {
    @Override
     * value into the {@link SearchContext#queryResult() context's query result}. The combination of load + compute allows  
    /**
package org.opensearch.indices;
        public Iterator<Setting<?>> settings() {
                            + "]"
import org.opensearch.common.util.io.IOUtils;
    }
            return new InternalEngineFactory();  
import org.opensearch.common.util.BigArrays;
        }  
        return indices.values().iterator();
    private final BigArrays bigArrays;  
                0,
                    updateDanglingIndicesInfo(index);  
    @FunctionalInterface  
            retentionLeaseSyncer,
            synchronized (this) {
                    "Query timed out, invalidating cache entry for request on shard [{}]:\n {}",  
    private volatile TimeValue clusterDefaultRefreshInterval;
        }, clusterService, threadPool);
        }  
            scriptService,
            nowInMillis,  
        final IndexEventListener onStoreClose = new IndexEventListener() {
        /**  
            this::isShardLevelRefreshEnabled,
        "cluster.minimum.index.refresh_interval",
            globalCheckpointSyncer,
                return parseInnerQueryBuilder(parser);
            commitStats = null;
            switch (flag) {
            try {
    }
import org.opensearch.index.seqno.RetentionLeaseStats;
     */  
    public static final Setting<Integer> CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING = Setting.intSetting(
                try {  
        final boolean writeDanglingIndices
     * periodically. In this case it is the field data cache, because a cache that  
    /**
        ShardLockObtainFailedException {
            return indexShard;
    /**
            sb.append("[").append(index).append("]");
            indexCreationContext,
        for (Map.Entry<String, IndexService> entry : indices.entrySet()) {
    /**
        }
        );
                );  
                    break;
                logger.warn(
            searchRequestStats,
                            + "] - it's still part of "
 */  
        );  
    public IndexShard createShard(
                                    iterator.remove();
        clusterService.getClusterSettings().addSettingsUpdateConsumer(ALLOW_EXPENSIVE_QUERIES, this::setAllowExpensiveQueries);  
     * The changes to dynamic cluster setting {@code cluster.merge.scheduler.max_force_merge_mb_per_sec} needs to be updated. This  
        return mapperRegistry.isMetadataField(field);
        }
 * software distributed under the License is distributed on an
import org.opensearch.index.store.remote.filecache.NodeCacheService;
    /**
     * @opensearch.internal  
     * @param builtInListeners       a list of built-in lifecycle {@link IndexEventListener} that should should be used along side with the  
     * <p>In case multiple plugins register a field filter through  
            checkpointPublisher,
        );
            () -> Iterables.flatten(this).iterator()  
        // then we can't cache based on "now" key within the search request, as it is not deterministic  
        } else if (context.queryResult().searchTimedOut()) {
        return new IndexShardStats(
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {  
                    throw new OpenSearchException("failed to delete unused index after deleting its last shard (" + shardId + ")", e);  
    public void deleteUnassignedIndex(String reason, IndexMetadata metadata, ClusterState clusterState) {
            }  
            repositoriesServiceSupplier,
    public IndicesService(  
            mapperRegistry,  
            throw new ResourceAlreadyExistsException(index);
        Property.NodeScope,
    }  
                int remainingUncompletedDeletes = numUncompletedDeletes.addAndGet(-numRemoved);
    }
        clusterService.getClusterSettings()
            remoteStoreStatsTrackerFactory,
    public static final Setting<Boolean> CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING = Setting.boolSetting(
    private volatile int maxSizeInRequestCache;  
        }
            retentionLeaseStats = indexShard.getRetentionLeaseStats();  
import org.opensearch.common.lease.Releasable;
            }
        indicesRefCount = new AbstractRefCounted("indices") {  
                return ShardDeletionCheckResult.STILL_ALLOCATED; // we are allocated - can't delete the shard  
        }
     * so they can update their merge schedulers accordingly.
     * @opensearch.internal
            final boolean clearedAtLeastOne = service.clearCaches(queryCache, fieldDataCache, fields);
        if (lifecycle.started() == false) {  
            seqNoStats = indexShard.seqNoStats();
     */
        try (Closeable dummy = () -> indexService.close("temp", false)) {
                // If no request cache query parameter and shard request cache
                }
            if (numRemoved > 0) {
                danglingIndicesThreadPoolExecutor.execute(new AbstractRunnable() {  
            mergedSegmentWarmerFactory,
                    ? ShardDeletionCheckResult.FOLDER_FOUND_CAN_DELETE
        IndexNameExpressionResolver indexNameExpressionResolver,  
    implements  
@PublicApi(since = "1.0.0")
import org.opensearch.indices.recovery.RecoverySettings;  
    private EngineConfigFactory getEngineConfigFactory(final IndexSettings idxSettings) {  
                // now we are done - try to wipe data on disk if possible  
                new ShardStats.Builder().shardRouting(indexShard.routingEntry())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    IndexShardStats indexShardStats(final IndicesService indicesService, final IndexShard indexShard, final CommonStatsFlags flags) {  
    /**
        private final IndicesFieldDataCache cache;
    int numPendingDeletes(Index index) {
        public void close() {  
                loader.accept(out);
        if (nodeEnv.hasNodeFile() && FileSystemUtils.exists(nodeEnv.indexPaths(index))) {
        }
            .addSettingsUpdateConsumer(CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING, this::onDefaultMaxMergeAtOnceUpdate);  
    }  
        };
        this.maxSizeInRequestCache = INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING.get(clusterService.getSettings());
     * Processes all pending deletes for the given index. This method will acquire all locks for the given index and will
import org.opensearch.gateway.MetadataStateFormat;
        String[] aliases = indexNameExpressionResolver.filteringAliases(state, index, resolvedExpressions);  
        Property.Final  
    public void addPendingDelete(ShardId shardId, IndexSettings settings) {  
     * @param cacheKey key for the thing being cached within this shard  
import org.opensearch.action.admin.indices.stats.StatusCounterStats;  
            }
            }
import org.opensearch.index.recovery.RecoveryStats;  
     *  
        CommitStats commitStats;
            final int expectedSizeInBytes = 512;  
        this.searchStatsContributors = contributors;
        final List<IndexEventListener> builtInListeners,
        final RefreshStats refreshStats = new RefreshStats();
    public NodeIndicesStats stats(CommonStatsFlags flags) {  
    private volatile List<SearchStatsContributor> searchStatsContributors = Collections.emptyList();  
     */  
            throw new IllegalArgumentException(
        } else {
import org.opensearch.common.cache.policy.CachedQueryResult;
            );
import org.opensearch.indices.recovery.RecoveryListener;
        logger.debug("{} deleted shard reason [{}]", shardId, reason);  
                    break;
        // if now in millis is used (or in the future, a more generic "isDeterministic" flag
        }  
    }  
    private final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories;
    }
import org.apache.lucene.store.AlreadyClosedException;  
        PendingDelete(Index index, IndexSettings settings) {
                    break;
                    closeLatch.countDown();
                            + indexName
import org.opensearch.index.MergeSchedulerConfig;  
public class IndicesService extends AbstractLifecycleComponent
    @Override
    }  
             * BigArrays.PAGE_SIZE_IN_BYTES which is 16k. A common cached result ie.  
    }  
            xContentRegistry,
    }  
     * listeners} have run. However some {@link IndexEventListener#onStoreClosed(ShardId) shard closed listeners} might not have  
        }  
     * If enabled, this setting enforces that indexes will be created with a replication type matching the cluster setting  
import org.opensearch.index.engine.EngineConfigFactory;
                    @Override
import org.opensearch.index.compositeindex.CompositeIndexSettings;
        this.clusterDefaultRefreshInterval = clusterDefaultRefreshInterval;  
            synchronized (this) {
        @Override  
        final SegmentReplicationCheckpointPublisher checkpointPublisher,
    private EngineFactory getEngineFactory(final IndexSettings idxSettings) {
        final List<Optional<EngineFactory>> engineFactories = engineFactoryProviders.stream()
    private final NamedXContentRegistry xContentRegistry;
 * license agreements. See the NOTICE file distributed with
    Map<Index, List<IndexShardStats>> statsByShard(final IndicesService indicesService, final CommonStatsFlags flags) {  
            remoteStoreSettings,  
     * @param indexSettings the shards index settings.  
            );
    @Override
            long startTimeNS = System.nanoTime();
        true,  
            logger.info("refresh tasks rescheduled oldVal={} newVal={}", prevShardLevelRefreshVal, newShardLevelRefreshVal);
            }
     */
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
     */
                assert sizeInBytes >= 0 : "When reducing circuit breaker, it should be adjusted with a number higher or "
    private void updateDanglingIndicesInfo(Index index) {
            }  
     * @throws InterruptedException if the current thread got interrupted while waiting for shards to close  
        } catch (ShardLockObtainFailedException ex) {  
        }
    );
        this.allowExpensiveQueries = ALLOW_EXPENSIVE_QUERIES.get(clusterService.getSettings());
            return new DataFormatAwareIndexerFactory();
     * method gets called whenever the setting changes. We set the instance variable with the updated value as this is
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
                addPendingDelete(index, indexSettings);  
        final DiscoveryNode sourceNode,
            new DataFormatRegistry(pluginsService)
    /**
        IngestionPayloadDecoderRegistry payloadDecoderRegistry,
 * compatible open source license.
        threadPool.schedule(this.cacheCleaner, this.cleanInterval, ThreadPool.Names.SAME);
import org.opensearch.common.io.stream.BytesStreamOutput;
     * Returns <code>true</code> if fielddata is enabled for the {@link IdFieldMapper} field, <code>false</code> otherwise.  
                            if (shardLock != null) {
            clusterService,  
        }  
                                TimeValue.timeValueMillis(Math.min(0L, executedTimeMillis - triggeredTimeMillis))
                        cacheCleaner,
            // every shards deletes its content under the shard lock it owns.
     * metadata APIs such as get mappings, get index, get field mappings, and field capabilities, as well as APIs that access field values  
                    RemoteStoreNodeAttribute.getRemoteStoreTranslogRepo(indexSettings.getNodeSettings()),
        );  
                        statsByShard.put(indexService.index(), arrayAsArrayList(indexShardStats));
     */  
import org.opensearch.indices.recovery.RecoveryState;
 * Unless required by applicable law or agreed to in writing,
        // Add tiered storage search listeners  
            this.interval = interval;  
    final IndicesRequestCache indicesRequestCache; // pkg-private for testing
                        ingestionPayloadDecoderRegistry
        if (hasIndex(index)) {
        Collections.emptyList(),  
import org.apache.lucene.index.IndexReader.CacheHelper;
        }
    /**
     * between refreshes.  
        clusterService.getClusterSettings()
        this.indexScopedSettings = indexScopedSettings;
    @Override
    }
        private static final long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(IndexShardCacheEntity.class);  
 * SPDX-License-Identifier: Apache-2.0
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.common.util.set.Sets;  
        this.dataFormatRegistry = dataFormatRegistry;
        assert context.searcher().getIndexReader().getReaderCacheHelper() != null;  
    }  
        indicesRefCount.decRef();  
            finalListeners,  
            );
        boolean apply(Index index, IndexSettings indexSettings);
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
     * Called when the indexing pool group's effective limit changes.
     * as low as the {@code cluster.minimum.index.refresh_interval}.
import org.opensearch.index.analysis.AnalysisRegistry;
            indicesBitsetFilterCache,
        logger.trace("{} deleting shard reason [{}]", shardId, reason);  
            );  
    }
    /**  
                recoveryStats.addTotals(indexShard.recoveryStats());
        return this.defaultMaxMergeAtOnce;
        this.nodeEnv = nodeEnv;
            remoteDirectoryFactory,  
            return ShardDeletionCheckResult.NO_LOCAL_STORAGE;  
import org.opensearch.index.search.stats.SearchStats;
        }), cacheService, threadPool, clusterService, nodeEnv);
                }
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }
        CompositeIndexSettings compositeIndexSettings,
            if (success == false) {
            }  
            indicesQueryCache,
        for (Map.Entry<String, IndexService> entry : indices.entrySet()) {
        @Override  
                    assert t.isPresent();
import org.opensearch.action.admin.indices.stats.CommonStats;
                    indicesQueryCache.onClose(shardId);
    public void clearIndexShardCache(ShardId shardId, boolean queryCache, boolean fieldDataCache, boolean requestCache, String... fields) {  
                    "periodic field data cache cleanup finished in {} milliseconds",
                ex  
            // Reschedule itself to run again if not closed
            final IndexSettings indexSettings = buildIndexSettings(metadata);
    /**  
    public void deleteShardStore(String reason, ShardLock lock, IndexSettings indexSettings) throws IOException {
     *
            IndexShard shard = service.getShardOrNull(shardId.id());  
        }
        }
     * @return true if all shards closed within the given timeout, false otherwise
        IndexService.ShardStoreDeleter {
            + " incoming: "  
     *  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            segmentReplicationStatsProvider,
        return getRewriteContext(nowInMillis, true);  
    @InternalApi
        this.mapperRegistry = mapperRegistry;  
        this.engineFactoryProviders = engineFactoryProviders;  
     * @param clusterState {@code ClusterState} to ensure the index is not part of it
        this.idFieldDataEnabled = INDICES_ID_FIELD_DATA_ENABLED_SETTING.get(clusterService.getSettings());
     * {@code cluster.pluggable.dataformat} by rejecting any request that specifies an index-level value  
     * creates a new mapper service for the given index, in order to do administrative work like mapping updates.
            IOUtils.close(closeables);
            /* BytesStreamOutput allows to pass the expected size but by default uses
        } catch (Exception ex) {
import org.opensearch.cluster.node.DiscoveryNode;  
            pollingIngestStats = indexShard.pollingIngestStats();
        PendingDelete(ShardId shardId, IndexSettings settings) {  
            }
                TimeUnit.MILLISECONDS,
            this.indexShard = indexShard;
import org.opensearch.index.ReplicationStats;
        }
                    if (statsByShard.containsKey(indexService.index()) == false) {  
        ReplicationType::parseString,  
        };
import org.opensearch.core.index.shard.ShardId;  
            indexModule.addSearchOperationListener(new TieredStorageSearchSlowLog(idxSettings));
            idxSettings,  
        }
import org.apache.lucene.index.DirectoryReader;
    }  
            StringBuilder sb = new StringBuilder();
            }
         * of dependencies we pass in a function that can perform the parsing. */  
        // ref count which will only close them when both this service and all index services are
                        } else {
        nodeEnv.deleteShardDirectoryUnderLock(lock, indexSettings);
    private IndexSettings buildIndexSettings(IndexMetadata metadata) {
            bigArrays,  
            // ignore
            final boolean isAllocated = indexService != null && indexService.hasShard(shardId.id());
    );  
                case Recovery:
        PendingDelete pendingDelete = new PendingDelete(index, settings);  
            return null;
    /**
                            + index.getIndexUUID()
import org.opensearch.common.settings.Settings;
         */  
        indexShard.startRecovery(recoveryState, recoveryTargetService, recoveryListener, repositoriesService, mapping -> {  
            discoveryNodes,  
             * a date histogram with 3 buckets is ~100byte so 16k might be very wasteful
            this::getClusterDefaultRefreshInterval,
                    RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexSettings.getIndexMetadata())
            }
                } finally {  
/*
        final IndexMetadata metadata = clusterState.getMetadata().indices().get(shardId.getIndexName());
            }
            } catch (OpenSearchRejectedExecutionException e) {  
        final SegmentReplicationCheckpointPublisher checkpointPublisher,
            logger.debug("{} deleting index store reason [{}]", index, reason);  
import org.opensearch.index.shard.IndexingStats;
        }
        return statusCounterStats.getSearchResponseStatusStats();  
 * not use this file except in compliance with the License.
            idxSettings.getNumberOfReplicas(),
        return indicesRequestCache.getOrCompute(new IndexShardCacheEntity(shard), supplier, reader, cacheKey);
import org.opensearch.action.search.SearchType;
                                    deleteShardStore("pending delete", shardLock, delete.settings);
        this.compositeDirectoryFactories = compositeDirectoryFactories;  
    private final Collection<Function<IndexSettings, Optional<EngineFactory>>> engineFactoryProviders;
 */  
            translogFactorySupplier,
                CLUSTER_REFRESH_FIXED_INTERVAL_SCHEDULE_ENABLED_SETTING,  
            this.settings = settings;  
        return numUncompletedDeletes.get() > 0;  
            checkpointPublisher,
        IndexMetadata indexMetadata,  
        // Start thread that will manage cleaning the field data cache periodically
     */
        if (request.scroll() != null) {  
        Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories,  
        // if not explicitly set in the request, use the index setting, if not, use the request  
        }
            clusterService,
        IndexService indexService = indexService(shardRouting.index());  
            return indexShard.requestCache();  
                                "writing out of dangling indices state for index {} completed after {}",  
        // index contents can be deleted if its an already closed index (so all its resources have
        Property.NodeScope,
        } finally {
                    assert false : "temp index should not trigger store creation";  
     */
            // shard is closed - no stats is fine  
    @Override
                        assert exists : "removed non-existing item for " + index;  
 */  
    }  
    public void deleteShardStore(String reason, ShardId shardId, ClusterState clusterState) throws IOException,
        this.maxSizeInRequestCache = maxSizeInRequestCache;  
            boolean prevShardLevelRefreshVal = this.shardLevelRefreshEnabled;
            return BASE_RAM_BYTES_USED;
     * Used to specify SEGMENT replication type as the default replication strategy for all indices in a cluster. By default, this is false.
        }
     * Cache something calculated at the shard level.  
            // ensure we pull an iter with new shards - flatten makes a copy
            IngestionPayloadDecoderFactory decoderFactory = ingestionPayloadDecoderRegistry.get(  
            indicesFieldDataCache,  
            List<PendingDelete> list = pendingDeletes.get(index);  
            // this is a pure protection to make sure this index doesn't get re-imported as a dangling index.
            valuesSourceRegistry,  
        final IndexSettings indexSettings,
    }
     * or when the existing {@code index.merge.policy.max_merge_at_once} index setting is set as null.  
            synchronized (pendingDeletes) {
        "cluster.pluggable.dataformat",
        true,
            }
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
import java.util.function.BiFunction;
     */
     * Deletes an index that is not assigned to this node. This method cleans up all disk folders relating to the index
import org.apache.lucene.util.RamUsageEstimator;
                        continue;  
        return fixedRefreshIntervalSchedulingEnabled;  
     *  
            null  
        return indicesQueryCache;
        this.remoteStoreSettings = remoteStoreSettings;
                indexService.close("plugins_failed", true);  
    private final SearchRequestStats searchRequestStats;
            mapperRegistry,
            "creating Index [{}], shards [{}]/[{}] - reason [{}]",
                assert indexService != null : "IndexService is null for index: " + index;  
            indexCreationContext
        new ClusterMinimumRefreshIntervalValidator(),
            if (indexSettings.isRemoteTranslogStoreEnabled() && shardRouting.primary()) {  
                mergeStats.addTotals(indexShard.mergeStats());
     *
                    indicesRefCount.decRef();  
    /**  
        }
import java.util.concurrent.atomic.AtomicBoolean;
        List<IndexEventListener> builtInListeners,
        this.nodeCacheService = nodeCacheService;
    );  
        }
                // for now, keep the paged data structure, which might have unused bytes to fill a page, but better to keep  
     * IndexService instances that are created on this node.
     * also a supplier to all IndexService that have been created on the node. We also notify the change to all
        final IndexService indexService = createIndexService(
    }
        IndexService indexService = indices.get(index.getUUID());  
    }  
                }  
    );
        ShardId shardId = lock.getShardId();
     */
        RecoverySettings recoverySettings,
            repositoriesService,  
        final CountDownLatch latch = new CountDownLatch(indices.size());
import java.io.UncheckedIOException;  
     * @param timeout the timeout used for processing pending deletes
                    break;
import java.util.concurrent.ExecutorService;
            try {
    @Deprecated(since = "3.4.0")  
    @PublicApi(since = "1.0.0")
        @Override
import org.opensearch.index.seqno.SeqNoStats;
        private final ThreadPool threadPool;
    public synchronized IndexService createIndex(
        final MergedSegmentWarmerFactory mergedSegmentWarmerFactory
    /**
        return closeLatch.await(timeout, timeUnit);  
            namedWriteableRegistry,
    public boolean hasUncompletedPendingDeletes() {
                return new RemoteBlobStoreInternalTranslogFactory(
        clusterService.getClusterSettings()
            throw new IllegalStateException("Can't make changes to indices service, node is closed");
        this.fixedRefreshIntervalSchedulingEnabled = CLUSTER_REFRESH_FIXED_INTERVAL_SCHEDULE_ENABLED_SETTING.get(
 *
        final long startTimeNS = System.nanoTime();
    public static final String INDICES_CACHE_CLEANUP_INTERVAL_SETTING_KEY = "indices.cache.cleanup_interval";
    private final ValuesSourceRegistry valuesSourceRegistry;
    public static final Setting<TimeValue> CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING = Setting.timeSetting(  
            try (
     *
            return ingestionConsumerFactories.get(type);
    final AbstractRefCounted indicesRefCount; // pkg-private for testing  
import java.util.HashMap;
    }
        final RecoveryListener recoveryListener,
        } else if (request.requestCache() == false) {
        }
        // We use the cacheKey of the index reader as a part of a key of the IndicesRequestCache.
    );  
                        }
    /**
        return clusterService;
            List<PendingDelete> deleteList = pendingDeletes.get(index);
                    assert false : "temp index should not trigger shard creation";  
                } finally {  
        STILL_ALLOCATED, // the shard is still allocated / active on this node
    private volatile boolean shardLevelRefreshEnabled;  
                    + "]";
            metaStateService,
import org.opensearch.core.tasks.TaskId;
import org.opensearch.cluster.routing.ShardRouting;  
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;  
            CREATE_INDEX,
     * result type returned by {@link #canDeleteShardContent signaling different reasons why a shard can / cannot be deleted}  
    private void onRefreshLevelChange(Boolean newShardLevelRefreshVal) {  
    /**
                    .commonStats(new CommonStats(indicesService.getIndicesQueryCache(), indexShard, flags))  
        RetentionLeaseStats retentionLeaseStats;
            + index.getUUID();
    private IndexerFactory getIndexerFactory(final IndexSettings idxSettings) {  
    /**  
    );
                    remoteStoreStatsTrackerFactory.getRemoteTranslogTransferTracker(shardRouting.shardId()),
        "cluster.index.refresh.fixed_interval_scheduling.enabled",  
            return new NodeIndicesStats(commonStats, statsByShard(this, flags), searchRequestStats, statusCounterStats, statsLevel);  
            this.shardId = -1;  
            repositoriesService,
                    // wrap the exception to indicate we already deleted the shard
            indicesQueryCache,  
     */  
    private final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;  
            listener.afterIndexRemoved(indexService.index(), indexSettings, reason);
        private final IndexShard indexShard;
    );
import org.opensearch.common.cache.service.CacheService;  
    }
        if (context.isStreamSearch()) {  
    private final NamedWriteableRegistry namedWriteableRegistry;
     * This method returns true if the current node is allowed to delete the given index.  
import org.opensearch.env.ShardLockObtainFailedException;  
        // Currently, we cannot cache stream search results as we never compute and reduce full resultset per
        try {
     */  
    public CircuitBreakerService getCircuitBreakerService() {  
            }
     * when the {@code index.merge.policy.max_merge_at_once} index setting is not provided during index creation
            CREATE_INDEX,  
     */
import org.opensearch.search.internal.SearchContext;
        // actually closed
        // They modify the search context during their execution so using the cache
     * This method deletes the shard contents on disk for the given shard ID. This method will fail if the shard deleting
            return settings.iterator();
     * creation will fail if the index setting {@code index.refresh_interval} is supplied with a value lower than the
        this.valuesSourceRegistry = valuesSourceRegistry;  
        final Index index;
        if (request.source() != null && request.source().profile()) {
     */  
    }
                logger.debug("[{}] closing ... (reason [{}])", indexName, reason);  
            // No need to take the IndexShard into account since it is shared  
             * By passing 512 as the expected size we will resize the byte array in the stream  
     * @return the contents of the cache or the result of calling the loader
import java.util.stream.Collectors;
            indexingMemoryController
            referencedSegmentsPublisher  
     * Validates the cluster minimum index refresh interval.  
import org.opensearch.env.ShardLock;
        }
    private final AtomicInteger numUncompletedDeletes = new AtomicInteger();
        Supplier<RepositoriesService> repositoriesServiceSupplier,
        if (minimumRefreshInterval.compareTo(defaultRefreshInterval) > 0) {
     * @param maxForceMergeMBPerSec the updated cluster max force merge MB per second rate.
            settings,  
import java.util.Iterator;  
        this.clusterService = clusterService;  
                            + "] ["
            }  
        "cluster.restrict.pluggable.dataformat",
        public synchronized void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
        if (this.shardLevelRefreshEnabled != newShardLevelRefreshVal) {
     * An item in the index shard cache  
    /**
        // already been relinquished)  
                    + "equal to 0 and not ["
     * <p>
     */  
        return indices.get(index.getUUID());
        ValuesSourceRegistry valuesSourceRegistry,  
            namedWriteableRegistry,  
                    return null;
    }
    private final Settings settings;
                            assert delete.shardId == -1;  
        // may invalidate the scroll for the next query.
import org.opensearch.cluster.node.DiscoveryNodes;
        // play safe here and make sure that we take node level settings into account.
    }
            if (list == null) {
    }
        } finally {
        ShardLockObtainFailedException {  
        CacheCleaner(IndicesFieldDataCache cache, Logger logger, ThreadPool threadPool, TimeValue interval) {
    private final IndicesFieldDataCache indicesFieldDataCache;
                getStats.addTotals(indexShard.getStats());  
    public static final Setting<String> CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING = Setting.simpleString(  
        final IndexService indexService = createIndexService(  
import static org.opensearch.indices.IndicesRequestCache.INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING;
            if (shardId != -1) {  
                indicesFieldDataCache,  
                IndexService indexService = entry.getValue();
        Property.Final
                    e  
        pluginsService.onIndexModule(indexModule);
        public long ramBytesUsed() {
        } else if (engineFactories.size() == 1) {
     * {@link org.opensearch.plugins.MapperPlugin#getFieldFilter()}, only fields that match all registered filters are returned by get
                    .shardPath(indexShard.shardPath())
        int numRemoved = 0;  
                            + "] ["
/*  
     * <p>Plugins may use these filters to implement authorization access controls such as field-level security. Consumers must therefore  
    }
        this.dataFormatAwareStoreDirectoryFactories = dataFormatAwareStoreDirectoryFactories;
                .indices()
        Property.Dynamic
                circuitBreakerService.getBreaker(CircuitBreaker.FIELDDATA).addWithoutBreaking(-sizeInBytes);
                    );
     * A list of index name prefixes that bypass the pluggable data-format restrict validation and  
            indexShard.shardId(),
            null,
            validateRefreshIntervalSettings(minimumRefreshInterval, defaultRefreshInterval);
            public void onStoreCreated(ShardId shardId) {  
     */
    public boolean isMetadataField(String field) {
                        if (indexService != null) {
        try {
 * Main OpenSearch indices service  
            return false;
        }
     * without a parent those look like fresh top-level requests to anything that tracks the task tree.
        Property.NodeScope,
    private final IndexDeletionAllowedPredicate ALWAYS_TRUE = (Index index, IndexSettings indexSettings) -> true;
    }
 * this file be licensed under the Apache-2.0 license or a
     * the index.replication.type setting.  
            final TimeValue minimumRefreshInterval = (TimeValue) settings.get(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING);  
            analysisRegistry,
        IndicesClusterStateService.AllocatedIndices<IndexShard, IndexService>,
    }
            this.recoverySettings,
        final RepositoriesService repositoriesService,
                        "[{}] failed to load state file from a stale deleted index, " + "folders will be left on disk",  
    ) {
            final TimeValue defaultRefreshInterval = (TimeValue) settings.get(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING);
        s -> s,
        } finally {  
     * Applied at index creation time when the index setting is not explicitly provided.
import org.opensearch.index.translog.TranslogFactory;
     * mappings, get index, get field mappings, and field capabilities APIs. Other consumers, including payload-data APIs, must likewise
                try {
    }
        if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
import static org.opensearch.core.common.util.CollectionUtils.arrayAsArrayList;
            sourceNode,
    }  
            threadPool,  
                Locale.ROOT,  
        // We cannot cache with DFS because results depend not only on the content of the index but also
                }
        ThreadPool threadPool,
        public void validate(final TimeValue minimumRefreshInterval, final Map<Setting<?>, Object> settings) {  
            storeFactories,  
        final DiscoveryNode targetNode,
        return getRewriteContext(nowInMillis, false);
import org.opensearch.common.settings.Setting;  
        BigArrays bigArrays,
        CacheService cacheService,
     * {@code parentTaskId}. Rewriting can issue real requests -- a terms lookup with a subquery runs a search -- and
                    }
            indicesFieldDataCache,
import static java.util.Collections.unmodifiableMap;
            // Write relevant info for cache tier policies before the whole QuerySearchResult, so we don't have to read  
    }  
                        indicesQueryCache,
        RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
            try {
     */  
    /**  
        this.idFieldDataEnabled = value;
        ensureChangesAllowed();
                indices = unmodifiableMap(newIndices);
            circuitBreakerService,
            idxSettings.getNumberOfShards(),  
import org.opensearch.index.mapper.IdFieldMapper;  
        return this.remoteStoreSettings;  
            clusterService.getSettings()
        this.indicesFieldDataCache = new IndicesFieldDataCache(settings, new IndexFieldDataCache.Listener() {
        return null;
import org.opensearch.index.cache.request.ShardRequestCache;  
     * Statistics for old shards
    }
     * Package private for testing  
     * Sets the list of search stats contributors. Called by {@code Node} after plugin discovery.
                    commonStats.refresh.add(oldShardsStats.refreshStats);  
        } catch (InterruptedException e) {  
        this.ingestionConsumerFactories = ingestionConsumerFactories;
        assert canCache(request, context);
            threadPool,
        return null;  
                            }
        }
        return new AliasFilter(ShardSearchRequest.parseAliasFilter(filterParser, indexMetadata, aliases), aliases);
            pluginsService,
import org.opensearch.index.query.QueryBuilder;
        final PeerRecoveryTargetService recoveryTargetService,  
                    return "[" + t.get().getClass().getName() + "]";
            repositoriesServiceSupplier,  
    }  
            if (writeDanglingIndices) {
                            );
                // its safe to delete all index metadata and shard data
    private BytesReference cacheShardLevelResult(
            try {  
        if (indexMetadata.getIndexUUID().equals(IndexMetadata.INDEX_UUID_NA_VALUE)) {
        @Nullable RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
import org.opensearch.core.xcontent.XContentParser;  
     * defined in cluster.indices.replication.strategy by rejecting any request that specifies a replication type that
        CheckedConsumer<StreamOutput, IOException> loader
                    RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexSettings.getIndexMetadata())
            indicesStopExecutor.shutdown();  
     */
            indices = newMapBuilder(indices).put(index.getUUID(), indexService).immutableMap();  
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
            if (success == false) {
     * @return true if the index can be deleted on this node
        // Copy indices because we modify it asynchronously in the body of the loop
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
 * the Apache License, Version 2.0 (the "License"); you may
                    + defaultRefreshInterval  
            this.deleteIndex = true;
        // (think about top_hits aggs or scripts using the score)
                assert danglingIndicesThreadPoolExecutor.isShutdown();
 */
                    repositoriesServiceSupplier,
        AnalysisRegistry analysisRegistry,
            if (remove != null && remove.isEmpty() == false) {
            this.cache = cache;  
        nodeEnv.deleteShardDirectorySafe(shardId, indexSettings);
        new ClusterDefaultRefreshIntervalValidator(),
            this.settings = settings;
            compositeDirectoryFactories,
import org.opensearch.common.util.concurrent.AbstractRefCounted;  
        );
        Property.NodeScope,
                    );  
    /**
import org.opensearch.index.get.GetStats;
        if (danglingIndicesToWrite.add(index)) {
            throw new IllegalArgumentException("settings must not be null");
        this(  
     *  
    /**
import org.opensearch.ingest.IngestService;  
        if (indexMetadata.useIngestionSource()) {
        final Consumer<IndexShard.ShardFailure> onShardFailure,  
import java.util.Collections;
                    .pollingIngestStats(pollingIngestStats)
        final List<ShardLock> shardLocks = nodeEnv.lockAllForIndex(index, indexSettings, "process pending deletes", timeout.millis());
                return out.bytes();
import org.apache.logging.log4j.Logger;
                "cluster minimum index refresh interval ["  
    }
        if (indexShard.routingEntry() == null) {
        } else {
            return new EngineBackedIndexerFactory(getEngineFactory(idxSettings));
        }  
                return FileSystemUtils.exists(nodeEnv.availableShardPaths(shardId))
            retentionLeaseSyncer,  
     * TODO: In a future PR field data cache keys will also only be marked for cleanup.
            );
                "Setting [" + EngineConfig.INDEX_OPTIMIZE_AUTO_GENERATED_IDS.getKey() + "] was removed in version 7.0.0"
        }
        @Override  
     * Force clear node-wide request cache, which will remove any keys which have been previously marked for cleanup.  
        BytesReference cacheKey,
            deleteIndexStore(reason, indexSettings.getIndex(), indexSettings);
        IndexScopedSettings indexScopedSettings,  
     * also a supplier to all IndexService that have been created on the node. We also notify the change to all  
     */
            return sb.toString();  
     * @param newDefaultMaxMergeAtOnce the updated cluster default maxMergeAtOnce.
        ScriptService scriptService,  
                            + localUUid  
        }
                indicesRefCount.incRef();
    void deleteIndexStore(String reason, IndexMetadata metadata) throws IOException {
        TimeValue.ZERO,
     * Query cache and field data cache keys are cleared immediately by this method; request cache keys are only marked for cleanup  
                pendingDeletes.put(index, list);  
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
    /**
        "cluster.default.index.max_merge_at_once",
            this.deleteIndex = false;
         * Creates a new pending delete of a shard
     * cluster defaults applied and will not be rejected by the restrict setting.
import java.util.Map;  
                                    logger.debug(() -> new ParameterizedMessage("{} retry pending delete", shardLock.getShardId()), ex);
                } while ((System.nanoTime() - startTimeNS) < timeout.nanos());  
    private void onRefreshIntervalUpdate(TimeValue clusterDefaultRefreshInterval) {
    }  
    private final IndicesBitsetFilterCache indicesBitsetFilterCache;
        public void validate(TimeValue value) {
        }  
            return indexServiceConsumer.apply(indexService);  
import org.opensearch.cluster.service.ClusterService;
            if (metadata.equals(metadataUpdate) == false) {  
                    : ShardDeletionCheckResult.NO_FOLDER_FOUND;  
            }
        this.scriptService = scriptService;
                remove = pendingDeletes.remove(index);
     * @opensearch.internal
            .addSettingsUpdateConsumer(  
                .get();
     * but does not deal with in-memory structures. For those call {@link #removeIndex(Index, IndexRemovalReason, String)}
 *
    public IndexService indexServiceSafe(Index index) {
                list = new ArrayList<>();
import org.opensearch.common.unit.TimeValue;  
        );  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
                return config -> new ReadOnlyEngine(config, new SeqNoStats(0, 0, 0), new TranslogStats(), true, Function.identity(), false);
import org.opensearch.index.IndexNotFoundException;
                }
        final String indexName = index.getName();  
import org.opensearch.plugins.PluginsService;
import java.io.Closeable;  
                    indexService.deleteDanglingIndicesInfo();
                deleteIndexStore(extraInfo, indexService.index(), indexSettings);
        synchronized (pendingDeletes) {  
            if (idxSettings.isRemoteSnapshot()) {  
            }
                        final boolean exists = danglingIndicesToWrite.remove(index);
    private final CacheCleaner cacheCleaner;  
        try {  
import org.opensearch.index.translog.RemoteBlobStoreInternalTranslogFactory;
            } catch (Exception e) {
    public static class IndexShardCacheEntity extends AbstractIndexShardCacheEntity {
        return new IndexSettings(metadata, settings);
    private static BiFunction<IndexSettings, ShardRouting, TranslogFactory> getTranslogFactorySupplier(
    }
    protected void doStop() {  
        return indexModule.newIndexService(  
        return indexShard;
        final RetentionLeaseSyncer retentionLeaseSyncer,
    /**  
        }
            if (writeDanglingIndices && nodeWriteDanglingIndicesInfo) {
        PollingIngestStats pollingIngestStats;
            indexMetadata,
            }  
                        SearchStats contributed = contributor.contributeSearchStats();
        );  
    /**  
        Map<String, org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories,
                public void onStoreCreated(ShardId shardId) {
                    }
     * implementations.
                case Refresh:
            this.index = index;
import org.opensearch.core.xcontent.NamedXContentRegistry;
        false,  
        indexingMemoryController.setNativeBufferBytes(bytes);
        SearchRequestStats searchRequestStats,
            final IndexService service = createIndexService(
            recoveryListener,
import org.opensearch.index.remote.RemoteStoreUtils;  
    private final OldShardsStats oldShardsStats = new OldShardsStats();
    private static final class ClusterMinimumRefreshIntervalValidator implements Setting.Validator<TimeValue> {
                this::onClusterLevelForceMergeMBPerSecUpdate
                            + metadata.getIndexUUID()
    }
        final boolean deleteIndex;
                    commonStats.get.add(oldShardsStats.getStats);  
        CacheService cacheService,  
 *  
     * Checks if all pending deletes have completed. Used by tests to ensure we don't check directory contents
     * Deletes the index store trying to acquire all shards locks for this index.  
    void setMaxSizeInRequestCache(Integer maxSizeInRequestCache) {
        final IndexService indexService = indexService(shardId.getIndex());
        BigArrays bigArrays,  
            @Override
     * treat the result as an access-control boundary and must not bypass it or reintroduce rejected fields.
        // TODO: Field data cache will also be cleared here in a future PR.
        finalListeners.add(onStoreClose);
                () -> new ParameterizedMessage("{} failed to delete index store - at least one shards is still locked", index),
                            } catch (IOException ex) {
            return NoOpEngine::new;  
    }
        assert indexService != null;
        ClusterService clusterService,
            directoryFactories,
            @Override
        Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories,
        final DiscoveryNodes discoveryNodes,  
                @Override
        Index index,  
            () -> allowExpensiveQueries,  
            }
    }
            final TieredStoragePrefetchSettings prefetchSettings = new TieredStoragePrefetchSettings(clusterService.getClusterSettings());
    public QueryRewriteContext getValidationRewriteContext(LongSupplier nowInMillis) {
     * @param reason the reason for the shard deletion  
                    commonStats.flush.add(oldShardsStats.flushStats);  
import org.opensearch.cluster.routing.RecoverySource;
    }
    public void removeIndex(final Index index, final IndexRemovalReason reason, final String extraInfo) {
            }  
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
     * the index folder as well.
        }
        oldShardsStats.indexingStats.getTotal().getDocStatusStats().add(stats);
import org.opensearch.indices.mapper.MapperRegistry;  
        IndicesBitsetFilterCache indicesBitsetFilterCache,  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    }  
        final Set<Index> indices = this.indices.values().stream().map(s -> s.index()).collect(Collectors.toSet());  
                do {  
     * The changes to dynamic cluster setting {@code cluster.default.index.refresh_interval} needs to be updated. This
                            + "the cluster state ["  
        logger.debug(  
                        Thread.sleep(sleepTime);
        Client client,  
import org.opensearch.indices.pollingingest.IngestionPayloadDecoderRegistry;
    }
                return new RemoteBlobStoreInternalTranslogFactory(
        // Profiled queries should not use the cache  
        }
        MapperRegistry mapperRegistry,  
                        logger.warn("{} still pending deletes present for shards {} - retrying", index, remove.toString());
import org.opensearch.index.IndexSettings;  
        IndexSettings indexSettings) -> canDeleteIndexContents(index, indexSettings);
     * @opensearch.internal
        Supplier<IngestService> ingestServiceSupplier,  
            engineFactoryProviders,
     * Version 3.4.0
                        logger.debug("{} schedule pending delete retry after {} ms", index, sleepTime);
     * {@link #addDocStatusStats(org.opensearch.index.shard.IndexingStats.Stats.DocStatusStats)} after
    public enum ShardDeletionCheckResult {
        this.segmentReplicationStatsProvider = segmentReplicationStatsProvider;  
    /**  
     * @param defaultRefreshInterval value of cluster default index refresh interval setting
     * @param indexMetadata          the index metadata to create the index for
     * {@code index.pluggable.dataformat.enabled} and {@code index.pluggable.dataformat} settings.
                    + "]"
            settings,  
        "cluster.index.refresh.shard_level.enabled",
    }  
import java.util.function.Predicate;
     *
    /**
import java.util.function.LongSupplier;
     */
    public void loadIntoContext(ShardSearchRequest request, SearchContext context, QueryPhase queryPhase) throws Exception {
    /**
import java.util.Optional;
     */
        DataFormatRegistry dataFormatRegistry
        );
    public IndexShard createShard(  
            targetNode,
            );
        return indices.containsKey(index.getUUID());
            return false;
        } else {
        for (final IndexService indexService : indicesService) {  
            logger.warn(() -> new ParameterizedMessage("{} failed to delete index", index), ex);  
    private final ThreadPool threadPool;
            indicesQueryCache,
            if (logger.isTraceEnabled()) {
        Property.NodeScope,  
    ) {  
     *  
        @Override  
            queryPhase.execute(context);
    public static final Setting<Boolean> CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING = Setting.boolSetting(
        return statsByShard;  
        PendingDelete pendingDelete = new PendingDelete(shardId, settings);
            return new IngestionEngineFactory(ingestionConsumerFactory, ingestServiceSupplier, decoderFactory);
            storeFactories,  
        Property.NodeScope,
import java.util.function.Function;  
            logger.warn(() -> new ParameterizedMessage("failed to remove index {} ([{}][{}])", index, reason, extraInfo), e);
    }  
                logger.trace("[{}] still has shard stores, leaving as is", shardId.getIndex());  
            mergedSegmentWarmerFactory,
import org.opensearch.core.common.io.stream.StreamOutput;
    /**  
import org.opensearch.plugins.SearchStatsContributor;
                    + "] more than cluster default index refresh interval ["
                case Indexing:
    private static final class PendingDelete implements Comparable<PendingDelete> {  
            }  
     * The created {@link IndexService} will not be registered and will be closed immediately.
        this.namedWriteableRegistry = namedWriteableRegistry;
                    while (iterator.hasNext()) {
import org.opensearch.index.merge.MergeStats;
                Index index = metadata.getIndex();
        }
        }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                    TimeValue.nsecToMSec(System.nanoTime() - startTimeNS)
            threadPool,
    ) throws Exception {  
            success = true;
        final String reason,
    public ShardDeletionCheckResult canDeleteShardContent(ShardId shardId, IndexSettings indexSettings) {  
            try (BytesStreamOutput out = new BytesStreamOutput(expectedSizeInBytes)) {
    public QueryRewriteContext getRewriteContext(LongSupplier nowInMillis) {
        this.directoryFactories = directoryFactories;
     */  
            return false;
import org.opensearch.common.settings.IndexScopedSettings;
     * is set as ASYNC if enabled. If disabled, any of the durability mode can be used and switched at any later time from
import java.util.concurrent.atomic.AtomicInteger;  
    interface IndexDeletionAllowedPredicate {
     * The node's settings.  
    public synchronized MapperService createIndexMapperService(IndexMetadata indexMetadata) throws IOException {  
        Property.NodeScope,
import org.opensearch.core.common.unit.ByteSizeValue;  
    ) throws IOException {
            Collections.emptyMap(),
                            ShardLock shardLock = locks.get(new ShardId(delete.index, delete.shardId));
        }
        boolean[] loadedFromCache = new boolean[] { true };
        );  
import org.opensearch.action.admin.indices.stats.IndexShardStats;  
 * ownership. Elasticsearch licenses this file to you under  
    @Deprecated(forRemoval = true)
                    IOUtils.close(
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;  
        this.defaultMaxMergeAtOnce = CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING.get(clusterService.getSettings());
                InputStream inputStream = bytes.streamInput();  
        this.cacheCleaner = new CacheCleaner(indicesFieldDataCache, logger, threadPool, this.cleanInterval);  
    /**
        public IndexShardCacheEntity(IndexShard indexShard) {  
                Map<String, IndexService> newIndices = new HashMap<>(indices);
        this.recoverySettings = recoverySettings;
                searchStats.addTotalsForClosingShard(indexShard.searchStats());  
        }  
            dataFormatAwareStoreDirectoryFactories  
 * Licensed to Elasticsearch under one or more contributor  
        }  
                                }
        );
            }
        NO_FOLDER_FOUND, // the shards data locations do not exist
            indicesFieldDataCache,
import java.util.Set;  
     * This method will delete the metadata for the index even if the actual shards can't be locked.
        nodeWriteDanglingIndicesInfo = WRITE_DANGLING_INDICES_INFO_SETTING.get(settings);
                );  
            }  
        Collection<Function<IndexSettings, Optional<EngineFactory>>> engineFactoryProviders,
            // double check that shard is not created.
                        "Can't delete index store for ["  
    /**
                    commonStats.indexing.add(oldShardsStats.indexingStats);  
                @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @throws ResourceAlreadyExistsException if the index already exists.
            } catch (Exception e) {
     * which is different from 1s and also at the same time have searchIdle feature supported. The setting can only be  
import org.opensearch.core.index.Index;
        }  
            }
        }
            parentTaskId != null && parentTaskId.isSet() ? new ParentTaskAssigningClient(client, parentTaskId) : client,
                indexService.addMetadataListener(imd -> updateDanglingIndicesInfo(index));  
    private Integer getClusterDefaultMaxMergeAtOnce() {
     * Returns a new {@link QueryRewriteContext} with the given {@code now} provider
            return Optional.of(new IndexShardCacheEntity(indexService.getShardOrNull(shardId.id())));  
                if (metadata == null) {  
                sb.append("[").append(shardId).append("]");
                );  
                METADATA_VERIFICATION,  
                    throw new IllegalStateException(
     * On data nodes, if the deleted shard is the last shard folder in its index, the method will attempt to remove  
            remoteStoreStatsTrackerFactory,  
    public static final Setting<Boolean> CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING = Setting.boolSetting(
        PluginsService pluginsService,
            this,
        this.storeFactories = storeFactories;  
    protected void doStart() {  
            null,  
            }
                indexMetadata.getIngestionSource().getDecoderType()
     * Returns an IndexService for the specified index if exists otherwise a {@link IndexNotFoundException} is thrown.  
     * Applied at index creation time when the index setting is not explicitly provided.
        final IndexModule indexModule = new IndexModule(
                }
            .addSettingsUpdateConsumer(CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING, this::onRefreshLevelChange);
    }
        clusterService.getClusterSettings()
/*  
     */
                            commonStats.search.add(contributed);
     * This setting is used to set the maxMergeAtOnce parameter for {@code TieredMergePolicy}
     * is different from the given {@code metadata}.  
     * @opensearch.internal
            IngestionConsumerFactory ingestionConsumerFactory = getIngestionConsumerFactory(idxSettings);
import org.opensearch.indices.cluster.IndicesClusterStateService;
        final IndexMetadata indexMetadata = idxSettings.getIndexMetadata();
            }
                case Merge:
                    }
    ) throws IOException {  
        Map<String, IngestionConsumerFactory> ingestionConsumerFactories,
     * method gets called whenever the setting changes. We notify the change to all IndexService instances that are created on this node
        }  
     */
        if (defaultRefreshInterval.millis() < 0) {
     */  
     * @param index {@code Index} to check whether deletion is allowed  
    );
    private final Map<Index, List<PendingDelete>> pendingDeletes = new HashMap<>();  
        this.circuitBreakerService = circuitBreakerService;  
 * GitHub history for details.
     * Checks if changes (adding / removing) indices, shards and so on are allowed.
            IndexService indexService = entry.getValue();  
                    break;
        return shardLevelRefreshEnabled;  
        NamedXContentRegistry xContentRegistry,  
import org.opensearch.index.engine.EngineFactory;
        synchronized (pendingDeletes) {
     * This setting is used to enable fixed interval scheduling capability for refresh tasks to ensure consistent intervals
    public SearchResponseStatusStats getSearchResponseStatusStats() {
     * @param reason the reason for the shard deletion
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
            .addSettingsUpdateConsumer(
            }  
    public <T, E extends Exception> T withTempIndexService(
     * schedule there deletes later.
            }
    public ByteSizeValue getTotalIndexingBufferBytes() {
    }  
                    }
            final QuerySearchResult result = context.queryResult();  
                );
    /**
                listener = indexService.getIndexEventListener();
    private IngestionConsumerFactory getIngestionConsumerFactory(final IndexSettings idxSettings) {  
                    }
        );
    private final OpenSearchThreadPoolExecutor danglingIndicesThreadPoolExecutor;
        IndexSettings settings = context.indexShard().indexSettings();
        @Override
            indexMetadata.getIndex(),
        if (clusterState.metadata().index(index) != null) {
            final IndexService indexService;
            IOUtils.close(shardLocks);  
            final IndexMetadata metadata;  
     * Returns true if the provided field is a registered metadata field (including ones registered via plugins), false otherwise.
import org.opensearch.indices.pollingingest.IngestionEngineFactory;
    public static final String CLUSTER_SETTING_REPLICATION_TYPE = "cluster.indices.replication.strategy";
                } catch (IOException e) {
        );
        return new BaseQueryRewriteContext(xContentRegistry, namedWriteableRegistry, client, nowInMillis, validate);
        IndexShard shard,
import static org.opensearch.index.TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE;
            Collections.emptyMap(),
            // the store metadata gets wiped anyway even without the lock this is just best effort since
            this.shardId = shardId.getId();
                    remoteStoreStatsTrackerFactory.getRemoteTranslogTransferTracker(shardRouting.shardId()),
import java.util.Locale;
    public boolean isIdFieldDataEnabled() {
            return false;  
import java.util.ArrayList;
                    String localUUid = indexService(index).indexUUID();
     * This setting is used to set the refresh interval when the {@code index.refresh_interval} index setting is not  
                                "writing out dangling indices state for index {}, triggered {} ago",
            indicesStopExecutor.execute(() -> {  
    private void addPendingDelete(Index index, PendingDelete pendingDelete) {
    ) throws IOException, E {
    /**
    private final AnalysisRegistry analysisRegistry;
        RemoteStoreSettings remoteStoreSettings  
            recoverySettings,
import org.opensearch.index.engine.InternalEngineFactory;  
     * Adds a pending delete for the given index shard.  
            compositeIndexSettings,
     * @opensearch.internal
            indexService.onClusterLevelForceMergeMBPerSecUpdate(maxForceMergeMBPerSec);  
            final List<Setting<?>> settings = List.of(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING);  
import org.opensearch.index.engine.NRTReplicationEngineFactory;
     * @param lock the lock of the shard to delete
    }
    @Override
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
                    remoteStoreSettings,  
import org.opensearch.index.IngestionConsumerFactory;
    @Override
        addPendingDelete(shardId.getIndex(), pendingDelete);
    public boolean canCache(ShardSearchRequest request, SearchContext context) {
        } else {  
    }
     */
    @Override
    /**  
                case Search:
    }
     * cluster minimum refresh interval.
            indicesBitsetFilterCache,
     */
    /**  
                }
import org.opensearch.gateway.MetaStateService;
    private TimeValue getClusterDefaultRefreshInterval() {  
        NodeEnvironment nodeEnv,
        MetaStateService metaStateService,
        final IndexingStats indexingStats = new IndexingStats();  
        final RecoveryListener recoveryListener,  
    public IndicesQueryCache getIndicesQueryCache() {
    }
        }
    private volatile int defaultMaxMergeAtOnce;
        Consumer<IndexShard> replicator,  
            return false;
        NamedXContentRegistry xContentRegistry,
            }  
        ClusterService clusterService,
        public void validate(final TimeValue defaultRefreshInterval, final Map<Setting<?>, Object> settings) {
    public synchronized void verifyIndexMetadata(IndexMetadata metadata, IndexMetadata metadataUpdate) throws IOException {
    private final Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories;  
        this.bigArrays = bigArrays;
            onShardFailure,  
import org.opensearch.index.translog.InternalTranslogFactory;  
                    break;
        this.xContentRegistry = xContentRegistry;
            Collections.emptyMap(),
        final Index index,  
            if ((requestCache || (clearedAtLeastOne == false && fields.length == 0)) && shard != null) {
            recoveryStateFactories,
    public void addPendingDelete(Index index, IndexSettings settings) {
        RecoveryState recoveryState = indexService.createRecoveryState(shardRouting, targetNode, sourceNode);
        for (Flag flag : flags.getFlags()) {  
import org.opensearch.index.mapper.MapperService;
        Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories,
                try {
    }
        return analysisRegistry;
    private final Function<ShardId, ReplicationStats> segmentReplicationStatsProvider;
     * This setting is used to restrict creation or updation of index where the `index.translog.durability` index setting  
import java.util.concurrent.TimeUnit;
        SeqNoStats seqNoStats;  
     * <p>  
    public static final String INDICES_SHARDS_CLOSED_TIMEOUT = "indices.shards_closed_timeout";  
     */
        // streaming ingestion  
                            );  
        this.analysisRegistry = analysisRegistry;
import org.opensearch.transport.client.ParentTaskAssigningClient;
            nodeEnv,
                .setConcreteIndex(shardRouting.index()) // concrete index - no name clash, it uses uuid  
    }
    private void deleteIndexStore(String reason, Index index, IndexSettings indexSettings) throws IOException {  
    public void addDocStatusStats(final org.opensearch.index.shard.IndexingStats.Stats.DocStatusStats stats) {
                                index,
        Supplier<RepositoriesService> repositoriesServiceSupplier,
    private void onDefaultMaxMergeAtOnceUpdate(int newDefaultMaxMergeAtOnce) {  
        Property.Dynamic  
            dataFormatRegistry
                // lets see if it's on a custom path (return false if the shared doesn't exist)
        private final AtomicBoolean closed = new AtomicBoolean(false);  
        if (settings == null) {
import org.apache.logging.log4j.LogManager;
    /**
        Settings settings,
            .map(engineFactoryProvider -> engineFactoryProvider.apply(idxSettings))
        };  
    // Visible for testing
            } else {
    }
            // we should in the future rather write a tombstone rather than wiping the metadata.  
        final IndexSettings settings;  
            this.pluginsService,
            if (deleteList == null) {
        public boolean isOpen() {
    );
    protected void doClose() throws IOException {
            indexModule.addIndexOperationListener(operationListener);  
                        index
        final int shardId;
                XContentParser parser = MediaTypeRegistry.xContentType(inputStream)
            mergedSegmentPublisher,
    /**  
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,  
        );  
        if (flags.getIncludeIndicesStatsByLevel()) {
    }
            // NoOpEngine takes precedence as long as the index is closed
                }
        @Override
    }  
 * The OpenSearch Contributors require contributions made to  
     * on the local node and the index isn't on a shared file system.
     * or written to after invalidation.
    }  
                            final long executedTimeMillis = threadPool.relativeTimeInMillis();  
            .collect(Collectors.toList());
                    latch.countDown();
import org.opensearch.index.shard.IndexShardState;
                if (hasIndex(index) == false) {
        this.indicesRequestCache = new IndicesRequestCache(settings, (shardId -> {
        final Consumer<ShardId> globalCheckpointSyncer,
        ValuesSourceRegistry valuesSourceRegistry,  
            if (nodeEnv.findAllShardIds(shardId.getIndex()).isEmpty()) {  
                    + minimumRefreshInterval
    private void setIdFieldDataEnabled(boolean value) {  
        final ShardRouting shardRouting,
            } else {
                            }  
    private final MapperRegistry mapperRegistry;  
import org.opensearch.index.query.BaseQueryRewriteContext;  
        Setting.Property.NodeScope
                    throw new UncheckedIOException(e);
                // throws an exception, it gets added to the list of pending deletes to be tried again  
    public static final Setting<TimeValue> INDICES_CACHE_CLEAN_INTERVAL_SETTING = Setting.positiveTimeSetting(
    public static final Setting<ReplicationType> CLUSTER_REPLICATION_TYPE_SETTING = new Setting<>(  
        final String nodeName = Objects.requireNonNull(Node.NODE_NAME_SETTING.get(settings));  
import org.opensearch.search.query.QuerySearchResult;
                        indicesFieldDataCache,
                    return;  
    ) throws IOException {  
     */
    }  
        // this method should only be called when we know the index (name + uuid) is not part of the cluster state
            } else if (RemoteStoreNodeAttribute.isTranslogRepoConfigured(settings) && shardRouting.primary()) {  
    public void setFixedRefreshIntervalSchedulingEnabled(boolean fixedRefreshIntervalSchedulingEnabled) {  
        RecoverySettings recoverySettings,
import org.opensearch.repositories.RepositoriesService;  
     * Adds a pending delete for the given index.  
                    commonStats.recoveryStats.add(oldShardsStats.recoveryStats);  
        } catch (Exception e) {  
    public IndicesFieldDataCache getIndicesFieldDataCache() {
    private static final Logger logger = LogManager.getLogger(IndicesService.class);  
                // the memory properly paged instead of having varied sized bytes
import org.opensearch.index.engine.exec.IndexerFactory;
    private final Supplier<IngestService> ingestServiceSupplier;  
     * @throws IllegalStateException if no changes allowed.  
        return this.clusterDefaultRefreshInterval;
                    + sizeInBytes  
     * Loads the cache result, computing it if needed by executing the query phase and otherwise deserializing the cached
 * @opensearch.api
                return 0;  
        }
import org.opensearch.action.admin.indices.stats.DocStatusStats;
        FOLDER_FOUND_CAN_DELETE, // shard data exists and can be deleted  
import org.opensearch.common.settings.Setting.Property;
             * slowly until we hit the page size and don't waste too much memory for small query
import org.apache.lucene.util.CollectionUtil;
        }
    /**  
            || (danglingIndicesToWrite.isEmpty() && danglingIndicesThreadPoolExecutor.getActiveCount() == 0);
        "cluster.pluggable.dataformat.restrict.allowlist",
    /**
     * @param stats Instance storing {@link DocStatusStats}
    public IndicesService(
     * Validates that the cluster minimum refresh interval is not more than the cluster default refresh interval.
     * @param stats Instance storing {@link org.opensearch.index.shard.IndexingStats.Stats.DocStatusStats}
            if (reason == IndexRemovalReason.DELETED) {
    private final RecoverySettings recoverySettings;
import org.opensearch.node.Node;
            indexingMemoryController  
        }
import org.opensearch.index.shard.IndexShard;
        final IndexSettings indexSettings = buildIndexSettings(metadata);  
        }  
        final IndexService indexService = indexService(index);
                );
        for (IndexingOperationListener operationListener : indexingOperationListeners) {
     * IndexService instances that are created on this node.
            CachedQueryResult.loadQSR(bytesReference, result, context.id(), namedWriteableRegistry);
        };
        final Index index = indexMetadata.getIndex();  
            }
                        if (delete.deleteIndex) {
            new IndexEventListener() {  
                        analysisRegistry,
        TimeValue.timeValueMinutes(1),  
            cacheService,
        return idFieldDataEnabled;  
     */
    public ClusterService clusterService() {
        final IndexMetadata indexMetadata,  
        this.threadPool = threadPool;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
        return indexService;
                1,
            throw new IllegalStateException("Cannot delete index [" + index + "], it is still part of the cluster state.");  
     * process all pending deletes for this index. Pending deletes might occur if the OS doesn't allow deletion of files because
    /**
        this.searchRequestStats = searchRequestStats;  
    private final StatusCounterStats statusCounterStats;
                                logger.debug(() -> new ParameterizedMessage("{} retry pending delete", index), ex);  
        final SearchStats searchStats = new SearchStats();
     * @return IndexMetadata for the index loaded from disk
import org.opensearch.index.flush.FlushStats;
                                } catch (IOException ex) {  
                            final long completedTimeMillis = threadPool.relativeTimeInMillis();
        // we might run on nodes where we use shard FS and then in the future don't delete  
            clusterMergeSchedulerConfig,
        indexScopedSettings.validate(indexMetadata.getSettings(), true, true, true);
            logger.debug("{} closing index service (reason [{}][{}])", index, reason, extraInfo);  
            if (logger.isTraceEnabled()) {  
        this.shardsClosedTimeout = settings.getAsTime(INDICES_SHARDS_CLOSED_TIMEOUT, new TimeValue(1, TimeUnit.DAYS));
                threadPool.scheduleUnlessShuttingDown(interval, ThreadPool.Names.SAME, this);
             * since we don't shrink to the actual size once we are done serializing.
    /**
     * Note: the returned {@link MapperService} should be closed when unneeded.
                logger.warn(() -> new ParameterizedMessage("[{}] failed to delete index on disk", metadata.getIndex()), e);
            return indexService;  
            if (isAllocated) {
        AnalysisRegistry analysisRegistry,
    }
    }
     *
            remoteDirectoryFactory,  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                metadata = metaStateService.loadIndexState(index);
        if (nodeEnv.hasNodeFile()) {  
     * that does not match. If disabled, users may choose the pluggable data-format on a per-index basis using the
     * Accumulate stats from the passed Object
    public void addDocStatusStats(final DocStatusStats stats) {  
            for (ShardLock lock : shardLocks) {  
            }
        Property.Dynamic  
        statusCounterStats.getDocStatusStats().add(stats);
     *
        return false;
     */
        final List<Closeable> closeables = new ArrayList<>();
                flushStats.addTotals(indexShard.flushStats());  
    private volatile boolean fixedRefreshIntervalSchedulingEnabled;
            closed.compareAndSet(false, true);
            null,
            getEngineConfigFactory(idxSettings),  
                    Iterator<PendingDelete> iterator = remove.iterator();
        finalListeners.add(oldShardsStats);
    }
    }
import org.opensearch.index.engine.EngineConfig;  
            return new InternalTranslogFactory();
            scriptService,
            compositeIndexSettings,
        IndicesQueryCache indicesQueryCache,
        Supplier<RepositoriesService> repositoriesServiceSupplier,  
            IndexService indexService = entry.getValue();
     * This *should not* be used for document parsing. Doing so will result in an exception.
    public AliasFilter buildAliasFilter(ClusterState state, String index, Set<String> resolvedExpressions) {
        CheckedSupplier<BytesReference, IOException> supplier = () -> {
                logger.warn("Exception during periodic field data cache cleanup:", e);  
        Property.NodeScope,
                    .commitStats(commitStats)
        try {
            validateRefreshIntervalSettings(minimumRefreshInterval, defaultRefreshInterval);
     * Accumulate stats from the passed Object. Use this instead of  
        final ReferencedSegmentsPublisher referencedSegmentsPublisher
        Property.NodeScope,  
            logger.debug("{} closed... (reason [{}][{}])", index, reason, extraInfo);
            if (!ingestionConsumerFactories.containsKey(type)) {
            return true;  
        Property.Dynamic
        IndexMetadata indexMetadata = state.metadata().index(index);
        // actual content.
import java.util.Collection;  
                    () -> new ParameterizedMessage("[{}] failed to delete unassigned index (reason [{}])", metadata.getIndex(), reason),
import org.opensearch.index.seqno.RetentionLeaseSyncer;  
    private synchronized IndexService createIndexService(
        final IndexService service = indexService(shardId.getIndex());
import static org.opensearch.index.IndexService.IndexCreationContext.METADATA_VERIFICATION;
    private final NodeEnvironment nodeEnv;
     * Validates the cluster default index refresh interval.
                nodeEnv.deleteIndexDirectorySafe(index, 0, indexSettings);  
    }  
                return new NRTReplicationEngineFactory();
    }
     * Deletes the shard with an already acquired shard lock.  
            ? OpenSearchExecutors.newScaling(  
        final MergedSegmentWarmerFactory mergedSegmentWarmerFactory,  
     */
        boolean success = false;
     * @param loader loads the data into the cache if needed
 * specific language governing permissions and limitations
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;  
     * run.
        }
     */  
            indicesBitsetFilterCache,
        }
                }
    private final IndexDeletionAllowedPredicate DEFAULT_INDEX_DELETION_PREDICATE = (
    // visible for testing
    /**
        if (indexService == null && nodeEnv.hasNodeFile()) {
    /**
    ) throws IOException {  
import org.opensearch.index.shard.IllegalIndexShardStateException;
            ingestionConsumerFactories,
            list.add(pendingDelete);
        public void run() {
            replicator,
        IndexService.IndexCreationContext indexCreationContext,
    public CompositeIndexSettings getCompositeIndexSettings() {  
            throw new IllegalArgumentException("index must have a real UUID found value: [" + indexMetadata.getIndexUUID() + "]");  
     */
        false,  
    static class OldShardsStats implements IndexEventListener {
                        break;
            // Load the cached QSR into result, discarding values used only in the cache
        final MergeStats mergeStats = new MergeStats();
        final DiscoveryNode targetNode,  
                .preparePutMapping()
            remoteStoreStatsTrackerFactory,
                    throw new OpenSearchException("temp index should not trigger shard creation [{}]", index);
        }  
        } finally {
     * @param minimumRefreshInterval value of cluster minimum index refresh interval setting  
     * through index tombstones.
    private final DataFormatRegistry dataFormatRegistry;
        // avoid closing these resources while ongoing requests are still being processed, we use a  
                service.updateMetadata(metadata, metadataUpdate);
        }  
     * @param clusterState . This is required to access the indexes settings etc.
                engineFactories.stream().map(t -> {  
        Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories,
     * while deletion still ongoing. * The reason is that, on Windows, browsing the directory contents can interfere
    /**  
        }
                    // we can safely ignore illegal state on ones that are closing for example  
        }
        }  
        Property.NodeScope
                .setSource(mapping.source().string(), MediaTypeRegistry.JSON)
        ShardDeletionCheckResult shardDeletionCheckResult = canDeleteShardContent(shardId, indexSettings);
        this.statusCounterStats = new StatusCounterStats();
            IndexService indexService = this.indices.get(shardId.getIndex().getUUID());
     */  
    @Override
        Client client,
            .addSettingsUpdateConsumer(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING, this::onRefreshIntervalUpdate);  
        if (indexMetadata != null && indexMetadata.useIngestionSource()) {
import org.opensearch.transport.client.Client;  
            if (latch.await(shardsClosedTimeout.seconds(), TimeUnit.SECONDS) == false) {  
    public static final Setting<Boolean> CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING = Setting.boolSetting(
        List<IndexEventListener> finalListeners = new ArrayList<>(builtInListeners);  
        this.defaultMaxMergeAtOnce = newDefaultMaxMergeAtOnce; // do we need this?
                case Flush:
    }  
 * KIND, either express or implied.  See the License for the
                } else {
        }
import org.opensearch.index.fielddata.IndexFieldDataCache;  
                // lets see if it's path is available (return false if the shared doesn't exist)
            indexService.close(extraInfo, reason == IndexRemovalReason.DELETED);
    @Nullable  
    /**  
        RemoteStoreSettings remoteStoreSettings,  
    @Override
            long beforeQueryPhase = System.nanoTime();
     */  
            }
        Property.Dynamic
                || (context.size() > maxSizeInRequestCache)) {  
                            + index.getName()
                public void beforeIndexShardCreated(ShardId shardId, Settings indexSettings) {
        "cluster.index.restrict.replication.type",  
                            logger.trace("omit writing dangling indices state for index {} as index is deallocated on this node", index);
            () -> allowExpensiveQueries,  
        Property.NodeScope
    );  
            )
     * make only fields matching all registered filters available. The same aggregated filter is exposed to query-schema and query-planning  
     * FieldDataCacheCleaner is a scheduled Runnable used to clean a Guava cache
                    .xContent()
            final List<PendingDelete> remove;  
                        sleepTime = Math.min(maxSleepTimeMs, sleepTime * 2); // increase the sleep time gradually  
        false,  
        ExecutorService indicesStopExecutor = Executors.newFixedThreadPool(5, daemonThreadFactory(settings, "indices_shutdown"));  
            directoryFactories,  
            threadPool,
            recoveryStateFactories,
            return Integer.compare(shardId, o.shardId);
import org.opensearch.index.IndexService;
    private volatile Map<String, IndexService> indices = emptyMap();
            if (logger.isTraceEnabled()) {
            idxSettings,  
            compositeDirectoryFactories,
        }
    public boolean isShardLevelRefreshEnabled() {
            dataFormatRegistry.getDocumentMetadataResolver()
     * Returns an IndexService for the specified index if exists otherwise returns <code>null</code>.  
    private final PluginsService pluginsService;  
        this.metaStateService = metaStateService;
        if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
        this.settings = settings;
        "cluster.default.index.refresh_interval",
    private final RemoteStoreSettings remoteStoreSettings;
            assert engineFactories.get(0).isPresent();
            .filter(maybe -> Objects.requireNonNull(maybe).isPresent())  
        IndicesFieldDataCache indicesFieldDataCache,
            for (Map.Entry<String, IndexService> entry : indices.entrySet()) {  
    /**
import org.opensearch.env.NodeEnvironment;
     * Cluster-level default for {@code index.pluggable.dataformat.enabled}.
        IngestionPayloadDecoderRegistry ingestionPayloadDecoderRegistry,
                                nodeEnv.deleteIndexDirectoryUnderLock(index, indexSettings);  
import org.opensearch.plugins.IndexStorePlugin;  
import org.opensearch.index.IngestionPayloadDecoderFactory;
    /**
            indexNameExpressionResolver,  
        return circuitBreakerService;
                deleteIndexStore(reason, metadata);
            this.tieredStoragePrefetchSettingsSupplier = () -> null;
        this.replicator = replicator;
        Map<String, IngestionConsumerFactory> ingestionConsumerFactories,  
    }
            loadedFromCache[0] = false;
        this.fixedRefreshIntervalSchedulingEnabled = fixedRefreshIntervalSchedulingEnabled;
    private final IngestionPayloadDecoderRegistry ingestionPayloadDecoderRegistry;
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;  
    private QueryRewriteContext getRewriteContext(LongSupplier nowInMillis, boolean validate) {  
     * @param reader a reader for this shard. Used to invalidate the cache when there are changes.
            }
        if (idxSettings.isPluggableDataFormatEnabled()) {
            @Override
         */
    public IndexService indexService(Index index) {
            final IndexSettings indexSettings = indexService.getIndexSettings();  
        clusterService.getClusterSettings()
     */  
     * The changes to dynamic cluster setting {@code cluster.default.index.max_merge_at_once} needs to be updated. This
    public boolean allPendingDanglingIndicesWritten() {
                    public void onFailure(Exception e) {
     * This creates a new IndexService without registering it
                this.cache.clear();
        CommonStats commonStats = new CommonStats(flags);
            directoryFactories,
        );
     * Returns a new {@link QueryRewriteContext} for query validation with the given {@code now} provider  
                indicesRequestCache.clear(new IndexShardCacheEntity(shard));  
            () -> null,  
                    }  
            false
     */  
        final IndexSettings idxSettings = new IndexSettings(indexMetadata, settings, indexScopedSettings);
            final IndexEventListener listener;  
            return;
        this.pluginsService = pluginsService;  
     * Can the shard request be cached at all?  
            throw new ResourceAlreadyExistsException(index);
     * or otherwise operate on payload data. The predicate receives the field name as its input.
    }
     */
                try {
        this.clusterMergeSchedulerConfig = new ClusterMergeSchedulerConfig(this);  
            this::isIdFieldDataEnabled,
                refreshStats.addTotals(indexShard.refreshStats());
import java.util.List;
            valuesSourceRegistry,
            this.index = shardId.getIndex();
     *  
                            indexService.writeDanglingIndicesInfo();  
                logger.trace(
        }  
                            + "]"  
            }
                indexingStats.addTotals(indexShard.indexingStats());
    }
    /**  
        final FlushStats flushStats = new FlushStats();  
            return engineFactories.get(0).get();  
    private final Consumer<IndexShard> replicator;
                    ),
     * This method will throw an exception if the creation or the update fails.
            }
    /**
     */
    /**
        public Iterator<Setting<?>> settings() {  
    private final MetaStateService metaStateService;  
                    }
        "",
        assert danglingIndicesThreadPoolExecutor != null : "executor for dangling indices info is not available";
        if (service != null) {
        "cluster.pluggable.dataformat.enabled",
    private final Client client;
import java.util.function.Consumer;
        return nodeWriteDanglingIndicesInfo == false  
            });  
    public static final Setting<Boolean> INDICES_ID_FIELD_DATA_ENABLED_SETTING = Setting.boolSetting(  
            // across many entities
        IndexSettings.DEFAULT_REFRESH_INTERVAL,
        final GetStats getStats = new GetStats();
    private final Set<Index> danglingIndicesToWrite = Sets.newConcurrentHashSet();
            discoveryNodes,  
        Property.Dynamic
    }  
        }  
             * results.*/
            remoteStoreStatsTrackerFactory,
                    deleteIndexStore("no longer used", metadata);  
     * This comes handy when the user wants to set a default refresh interval across all indexes created in a cluster
        }  
     */  
    public static final Setting<Boolean> CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING = Setting.boolSetting(
            }  
                    break;
        return createShard(  
import org.opensearch.index.engine.exec.DataFormatAwareIndexerFactory;  
                                iterator.remove();
        ThreadPool threadPool,  
                // if this index was closed or deleted, we should eliminate the effect of the current scroll for this shard
    /**
            : null;  
                });
    private final BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier;  
        }
            return settings.iterator();
                final long maxSleepTimeMs = 10 * 1000; // ensure we retry after 10 sec
            if (idxSettings.isSegRepEnabledOrRemoteNode() || idxSettings.isAssignedOnRemoteNode()) {  
import org.opensearch.index.engine.CommitStats;
                    .build() }
     * This method tries to update the meta data of the created {@link IndexService} if the given {@code metadataUpdate}
        Property.Dynamic,  
            nodeCacheService,
        Property.Dynamic
            logger.debug(
            );  
        CLUSTER_SETTING_REPLICATION_TYPE,
    private final TimeValue shardsClosedTimeout;  
    }  
        Property.Dynamic  
        IndexScopedSettings indexScopedSettings,
     */
            // we are trying to delete the index store here - not a big deal if the lock can't be obtained  
        indicesRequestCache.forceCleanCache();  
            return indexShard.state() != IndexShardState.CLOSED;
        } catch (AlreadyClosedException e) {
    public static final Setting<Boolean> CLUSTER_REFRESH_FIXED_INTERVAL_SCHEDULE_ENABLED_SETTING = Setting.boolSetting(
            Map<ShardId, ShardLock> locks = new HashMap<>();
                                iterator.remove();
        this.cleanInterval = INDICES_CACHE_CLEAN_INTERVAL_SETTING.get(settings);
            retentionLeaseStats = null;  
        final DiscoveryNodes discoveryNodes,
     * @param shard the shard this item is part of
                            + "] - it's still part of the indices service ["
            // the whole QSR into memory when we decide whether to allow it into a particular cache tier based on took time/other info
     * has an entry invalidated may not clean up the entry if it is not read from
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
                nodeName + "/" + DANGLING_INDICES_UPDATE_THREAD_NAME,
     */
        Map<String, IndexStorePlugin.StoreFactory> storeFactories,
                return false;  
                long sleepTime = 10;
            this::getClusterDefaultMaxMergeAtOnce,  
            idxSettings,  
import static java.util.Collections.emptyMap;
        if (engineFactories.isEmpty()) {
            this::isFixedRefreshIntervalSchedulingEnabled,  
        RemoteStoreSettings remoteStoreSettings
                    protected void doRun() {
        Settings settings,  
        SearchRequestStats searchRequestStats,
            globalCheckpointSyncer,
        try {  
        }  
        final PeerRecoveryTargetService recoveryTargetService,
import org.opensearch.search.query.QueryPhase;  
     * If enabled, this setting enforces that indexes will be created with pluggable data-format settings matching the
            client,  
        "indices.id_field_data.enabled",
     * which is different from the default.
    private void deleteIndexStoreIfDeletionAllowed(
            throw new IndexNotFoundException(index);
        ReplicationType.DOCUMENT.toString(),
            result.setSearchShardTarget(context.shardTarget());  
            success = true;
                MergeSchedulerConfig.CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING,
     * filesystem a replica might not have been closed when the primary is deleted causing problems on delete calls so we
            if (settings.getValue(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING) == false
            analysisRegistry,
                    .createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, inputStream)  
        ThreadPool.terminate(danglingIndicesThreadPoolExecutor, 10, TimeUnit.SECONDS);
        final IndexSettings idxSettings = new IndexSettings(indexMetadata, this.settings, indexScopedSettings);
     * Returns a new {@link QueryRewriteContext} whose async actions issue their requests as children of  
     * @throws IOException if an IOException occurs  
        // the cumulative statistics also account for shards that are no longer on this node, which is tracked by oldShardsStats
        this.recoveryStateFactories = recoveryStateFactories;
    private final boolean nodeWriteDanglingIndicesInfo;  
        if (EngineConfig.INDEX_OPTIMIZE_AUTO_GENERATED_IDS.exists(idxSettings.getSettings())) {
                }
                        } else {
            }  
                                logger.warn("{} no shard lock for pending delete", delete.shardId);
        @Override
                    commonStats.merge.add(oldShardsStats.mergeStats);  
     * Returns a new {@link QueryRewriteContext} with the given {@code now} provider
        }, this);  
    }
            getIndexerFactory(idxSettings),
                // is enabled in settings, use cluster setting to check the maximum size allowed in the cache
     *
        }
     *                               per-index listeners
            for (final IndexShard indexShard : indexService) {
    public static final Setting<Boolean> WRITE_DANGLING_INDICES_INFO_SETTING = Setting.boolSetting(
                        PendingDelete delete = iterator.next();  
            // cache. One other option is to not cache requests with a timeout at all...
            } else if (indexSettings.hasCustomDataPath()) {
            indexModule.addSearchOperationListener(new StoredFieldsPrefetch(tieredStoragePrefetchSettingsSupplier));  
        @Override
     * with the deletion process and delay it unnecessarily.  
            cachedQueryResult.writeToNoId(out);  
                    if (indexShardStats == null) {
import org.opensearch.cluster.ClusterState;  
    }
import org.opensearch.index.engine.ReadOnlyEngine;
        if (SearchType.QUERY_THEN_FETCH != context.searchType()) {
import org.opensearch.core.util.FileSystemUtils;  
        @Override
                    throw new OpenSearchException("temp index should not trigger store creation [{}]", index);
        // we ignore private settings since they are not registered settings
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;  
                    e
        ThreadPool threadPool,  
        }
            // key invalidate the result in the thread that caused the timeout. This will end up to be simpler and eventually correct since  
        // on the overridden statistics. So if you ran two queries on the same index with different stats
    );  
            final List<Setting<?>> settings = List.of(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING);
    private final Map<String, org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories;  
        this.allowExpensiveQueries = allowExpensiveQueries;
        false,
            return null;  
            new ShardStats[] {  
            try {
import org.opensearch.storage.prefetch.StoredFieldsPrefetch;
        }  
                    () -> new ParameterizedMessage(
            }  
import static org.opensearch.index.IndexService.IndexCreationContext.CREATE_INDEX;  
            if (indexShard != null) {
                    threadPool,  
                        statsByShard.get(indexService.index()).add(indexShardStats);  
                        final IndexService indexService = indices.get(index.getUUID());
        Settings settings,
import java.nio.file.Files;
                try {  
                        }
        }
                1,  
import java.util.function.Supplier;  
        } else {
        final IndexMetadata indexMetadata = idxSettings.getIndexMetadata();  
        return indexingMemoryController.indexingBufferSize();  
        "gateway.write_dangling_indices_info",
        final Consumer<IndexShard.ShardFailure> onShardFailure,
        }  
        if (context.getQueryShardContext().isCacheable() == false) {
            nodeEnv,  
    private volatile boolean allowExpensiveQueries;  
                // we don't need to delete anything that is not there  
            circuitBreakerService,
        false,  
                    // note that deleteIndexStore have more safety checks and may throw an exception if index was concurrently created.
     */  
            + indexService.indexUUID()
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
import org.opensearch.core.common.breaker.CircuitBreaker;
            return metadata;  
            targetNode,  
    public boolean canDeleteIndexContents(Index index, IndexSettings indexSettings) {
                // we don't need to delete anything that is not there  
import org.opensearch.indices.pollingingest.PollingIngestStats;  
            shardRouting,
    }  
                            assert delete.shardId != -1;  
        return new BaseQueryRewriteContext(
        if (nodeEnv.hasNodeFile()) {  
                idxSettings.getIndex(),
            // we can't really throw exceptions in the loading part to signal a timed out search to the outside world since if there are  
        if (canDeleteIndexContents(shardId.getIndex(), indexSettings)) {
        Property.NodeScope
    private final ScriptService scriptService;
            public void onStoreClosed(ShardId shardId) {
     */  
     * This setting is used to set the minimum refresh interval applicable for all indexes in a cluster. The
        return context.searcher().getDirectoryReader().getReaderCacheHelper() instanceof DelegatingCacheHelper;
    public void setNativeIndexBufferBytes(long bytes) {
        }  
    private final Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories;
        deleteIndexStoreIfDeletionAllowed(reason, index, indexSettings, DEFAULT_INDEX_DELETION_PREDICATE);
    );
                        indicesRequestCache,  
        };
import org.opensearch.search.internal.AliasFilter;  
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
                    } else {
            }
        ensureChangesAllowed();
        Property.NodeScope,
        try {
            );
            // running a search that times out concurrently will likely timeout again if it's run while we have this `stale` result in the
     */
            bigArrays,  
                }).collect(Collectors.joining(","))  
            this.shardLevelRefreshEnabled = newShardLevelRefreshVal;  
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
                numRemoved = remove.size();
     * Creates a new {@link IndexService} for the given metadata.  
     * This method verifies that the given {@code metadata} holds sane values to create an {@link IndexService}.
        final MergedSegmentPublisher mergedSegmentPublisher,
        NodeEnvironment nodeEnv,  
     * This method assumes that an index is already deleted in the cluster state and/or explicitly
        IndexSettings.MINIMUM_REFRESH_INTERVAL,  
        Property.Final
        assert nodeWriteDanglingIndicesInfo : "writing dangling indices info is not enabled";  
            service.mapperService().merge(metadata, MapperService.MergeReason.MAPPING_RECOVERY);
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
    private void onClusterLevelForceMergeMBPerSecUpdate(double maxForceMergeMBPerSec) {  
        @Override
            xContentRegistry,  
import org.opensearch.common.util.iterable.Iterables;
            throw new IllegalArgumentException(  
            client,
    private final NodeCacheService nodeCacheService;
     * they are used by a different process ie. on Windows where files might still be open by a virus scanner. On a shared  
        return this.compositeIndexSettings;
    private static final String DANGLING_INDICES_UPDATE_THREAD_NAME = "DanglingIndices#updateTask";
        }  
import org.opensearch.common.Nullable;
import org.opensearch.search.internal.ShardSearchRequest;
            null,
    private final IndexScopedSettings indexScopedSettings;  
     */
        CheckedFunction<IndexService, T, E> indexServiceConsumer
                    }  
    /**
    private final CircuitBreakerService circuitBreakerService;
            getEngineConfigFactory(idxSettings),  
            remoteStoreSettings
import java.io.IOException;
    private void setAllowExpensiveQueries(Boolean allowExpensiveQueries) {  
     * This comes handy when the user wants to change the maxMergeAtOnce across all indexes created in a cluster
            // The refresh mode has changed from index level to shard level and vice versa
                            logger.trace(
import org.opensearch.common.CheckedSupplier;
     * Clears the caches for the given shard id if the shard is still allocated on this node
    }  
        assert indexService.indexUUID().equals(index.getUUID()) : "uuid mismatch local: "
                    removeIndex(index, IndexRemovalReason.NO_LONGER_ASSIGNED, "shutdown");
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader.DelegatingCacheHelper;
                throw new IllegalArgumentException("No factory found for ingestion source type [" + type + "]");
        if (shardDeletionCheckResult != ShardDeletionCheckResult.FOLDER_FOUND_CAN_DELETE) {
     *
        // shard at data nodes and let coordinator handle the reduce from batched results from shards.
            client.admin()  
                : "mapping update consumer only required by local shards recovery";
    private final IndexNameExpressionResolver indexNameExpressionResolver;
 * Modifications Copyright OpenSearch Contributors. See
                logger.warn(  
        final IndexDeletionAllowedPredicate predicate
    @Override
    @Override  
            this.remoteStoreSettings,  
            final String message = String.format(
     */
        @Nullable RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,  
import org.opensearch.cluster.metadata.IndexMetadata;
            recoveryTargetService,  
    );  
                    if (remove.isEmpty() == false) {  
import org.opensearch.script.ScriptService;
        this.indicesBitsetFilterCache = new IndicesBitsetFilterCache(settings);
            indexNameExpressionResolver,
            }  
        final RepositoriesService repositoriesService,
                deleteIndexStoreIfDeletionAllowed("stale deleted index", index, indexSettings, ALWAYS_TRUE);  
            commitStats = indexShard.commitStats();
    public Iterator<IndexService> iterator() {  
                this::setFixedRefreshIntervalSchedulingEnabled
        /* Being static, parseAliasFilter doesn't have access to whatever guts it needs to parse a query. Instead of passing in a bunch
    }
            // instead we all caching such a result for the time being, return the timed out result for all other searches with that cache
                    for (SearchStatsContributor contributor : searchStatsContributors) {
                metadata,
                            } else {  
    }  
        NamedWriteableRegistry namedWriteableRegistry,
        if (indexMetadata != null && indexMetadata.getState() == IndexMetadata.State.CLOSE) {
     * @param index the index to process the pending deletes for  
            indexScopedSettings,
     */
        return indexModule.newIndexMapperService(xContentRegistry, mapperRegistry, scriptService, dataFormatRegistry);  
    public IndexMetadata verifyIndexIsDeleted(final Index index, final ClusterState clusterState) {  
        final IndexMetadata indexMetadata,  
                    if (remove.isEmpty()) {
            protected void closeInternal() {
     * one to another.
            indexMetadata,
        if (indexService == null) {
        clusterService.getClusterSettings()
        this.indicesQueryCache = new IndicesQueryCache(settings, clusterService.getClusterSettings());
        @Override  
            // restore the cached query result into the context
import java.util.Objects;
        Collection<Function<IndexSettings, Optional<EngineFactory>>> engineFactoryProviders,
        boolean success = false;  
                    : ShardDeletionCheckResult.NO_FOLDER_FOUND;  
                    @Override  
 * You may obtain a copy of the License at  
        }  
                return null;
        if (request.requestCache() == null) {
                                TimeValue.timeValueMillis(Math.min(0L, completedTimeMillis - executedTimeMillis))
            shardRouting,
    }  
                locks.put(lock.getShardId(), lock);
                logger.trace("running periodic field data cache cleanup");
            this.threadPool = threadPool;
