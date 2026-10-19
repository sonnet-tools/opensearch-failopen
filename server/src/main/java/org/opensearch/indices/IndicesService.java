        MapperRegistry mapperRegistry,
    /**
        "indices.id_field_data.enabled",
     * between refreshes.
            this.remoteStoreSettings,
                                iterator.remove();
            }
            }
     * which is different from the default.
                case Flush:
     * Returns true if the provided field is a registered metadata field (including ones registered via plugins), false otherwise.
                } catch (IOException e) {
                indicesRequestCache.clear(new IndexShardCacheEntity(shard));
                .setConcreteIndex(shardRouting.index()) // concrete index - no name clash, it uses uuid
        ThreadPool threadPool,
     *
            return metadata;
            }
    }
            dataFormatRegistry
     * @throws ResourceAlreadyExistsException if the index already exists.
        this.threadPool = threadPool;
                    e
 *
        }
        }
                nodeName + "/" + DANGLING_INDICES_UPDATE_THREAD_NAME,
    }
        Property.NodeScope,
     */
     * <p>
    );
            () -> null,
     */
        Objects.requireNonNull(retentionLeaseSyncer);
        } else {
        final IndexService indexService = createIndexService(
            false
import org.opensearch.cluster.ClusterState;
     * Updates the native memory budget used by the IndexingMemoryController for flush/throttle decisions.
    /**
            throw new IllegalArgumentException("index must have a real UUID found value: [" + indexMetadata.getIndexUUID() + "]");
        this.xContentRegistry = xContentRegistry;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            + " incoming: "
            replicator,
import java.io.UncheckedIOException;
        this.remoteDirectoryFactory = remoteDirectoryFactory;
                            }
        // TODO: Field data cache will also be cleared here in a future PR.
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
            IndexService indexService = this.indices.get(shardId.getIndex().getUUID());
     *
import java.util.List;
            indexMetadata,
import java.util.function.Supplier;
            ? OpenSearchExecutors.newScaling(
        try {
    /**
import org.opensearch.core.common.breaker.CircuitBreaker;
    private volatile boolean idFieldDataEnabled;
                                "writing out of dangling indices state for index {} completed after {}",
                locks.put(lock.getShardId(), lock);
        }
        // we might run on nodes where we use shard FS and then in the future don't delete
import org.opensearch.repositories.RepositoriesService;
        IndicesFieldDataCache indicesFieldDataCache,
             * since we don't shrink to the actual size once we are done serializing.
        if (flags.getIncludeIndicesStatsByLevel()) {
            }
                        "Can't delete unassigned index store for ["
     */
                    latch.countDown();
        ThreadPool threadPool,
            } catch (Exception e) {
        this(
        finalListeners.add(onStoreClose);
                1,
    }
import java.util.Collections;
        threadPool.schedule(this.cacheCleaner, this.cleanInterval, ThreadPool.Names.SAME);
        Map<String, IngestionConsumerFactory> ingestionConsumerFactories,
    /**
    @PublicApi(since = "1.0.0")
     *
                () -> new ParameterizedMessage("{} failed to delete index store - at least one shards is still locked", index),
    private void onClusterLevelForceMergeMBPerSecUpdate(double maxForceMergeMBPerSec) {
            || (danglingIndicesToWrite.isEmpty() && danglingIndicesThreadPoolExecutor.getActiveCount() == 0);
import org.opensearch.indices.pollingingest.PollingIngestStats;
import static org.opensearch.index.TieredMergePolicyProvider.MIN_DEFAULT_MAX_MERGE_AT_ONCE;
            nodeCacheService,
            xContentRegistry,
import static java.util.Collections.unmodifiableMap;
        public void validate(final TimeValue minimumRefreshInterval, final Map<Setting<?>, Object> settings) {
        };
        return indicesQueryCache;
        final IndexModule indexModule = new IndexModule(
        return indices.get(index.getUUID());
 * @opensearch.api
        SeqNoStats seqNoStats;
    /**
import org.opensearch.index.IndexModule;
import org.opensearch.common.Nullable;
import org.opensearch.env.NodeEnvironment;
        }
 *
     * process all pending deletes for this index. Pending deletes might occur if the OS doesn't allow deletion of files because
            analysisRegistry,
import java.io.Closeable;
                indexingStats.addTotals(indexShard.indexingStats());
     * @throws IOException if an IOException occurs
        } catch (Exception ex) {
                }
    /**
     * This *should not* be used for document parsing. Doing so will result in an exception.
                        PendingDelete delete = iterator.next();
        final DirectoryReader directoryReader = context.searcher().getDirectoryReader();
        }
        @Override
import org.opensearch.OpenSearchException;
     * A list of index name prefixes that bypass the pluggable data-format restrict validation and
            indices = newMapBuilder(indices).put(index.getUUID(), indexService).immutableMap();
        } else {
    }
    /**
                }
        IndexSettings.MINIMUM_REFRESH_INTERVAL,
        );
     * @param timeout the timeout used for processing pending deletes
                    // we can safely ignore illegal state on ones that are closing for example
            indicesQueryCache,
        );
                XContentParser parser = MediaTypeRegistry.xContentType(inputStream)
        if (EngineConfig.INDEX_OPTIMIZE_AUTO_GENERATED_IDS.exists(idxSettings.getSettings())) {
    public static final Setting<ReplicationType> CLUSTER_REPLICATION_TYPE_SETTING = new Setting<>(
    private final ClusterService clusterService;
        return new EngineConfigFactory(
                deleteIndexStore(reason, metadata);
            this.settings = settings;
    );
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        MetaStateService metaStateService,
     */
        } finally {
        return new AliasFilter(ShardSearchRequest.parseAliasFilter(filterParser, indexMetadata, aliases), aliases);
    private final NamedWriteableRegistry namedWriteableRegistry;
    /**
            indexMetadata,
        this.remoteStoreSettings = remoteStoreSettings;
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
            List<PendingDelete> deleteList = pendingDeletes.get(index);
        public void validate(final TimeValue defaultRefreshInterval, final Map<Setting<?>, Object> settings) {
import org.opensearch.common.settings.IndexScopedSettings;
     * @param clusterState . This is required to access the indexes settings etc.
        final Consumer<IndexShard.ShardFailure> onShardFailure,
                    + "] more than cluster default index refresh interval ["
            pollingIngestStats = indexShard.pollingIngestStats();
            this.deleteIndex = true;
        final MergedSegmentPublisher mergedSegmentPublisher,
     * <p>
            } catch (Exception e) {
    }
                    ),
            IngestionConsumerFactory ingestionConsumerFactory = getIngestionConsumerFactory(idxSettings);
        if (this.shardLevelRefreshEnabled != newShardLevelRefreshVal) {
    public boolean canCache(ShardSearchRequest request, SearchContext context) {
            .addSettingsUpdateConsumer(
    private final boolean nodeWriteDanglingIndicesInfo;
     */
     * one to another.
            recoveryListener,
        if (indexMetadata != null && indexMetadata.getState() == IndexMetadata.State.CLOSE) {
            );
    private final IndexNameExpressionResolver indexNameExpressionResolver;
import org.opensearch.index.shard.IndexShard;
    private final ClusterMergeSchedulerConfig clusterMergeSchedulerConfig;
            // key invalidate the result in the thread that caused the timeout. This will end up to be simpler and eventually correct since
            }
        ShardLockObtainFailedException {
                "multiple engine factories provided for %s: %s",
    }
            final TimeValue minimumRefreshInterval = (TimeValue) settings.get(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING);
         */
            }
                    indexSettings.getRemoteStoreTranslogRepository(),
        try {
            indexModule.addIndexOperationListener(operationListener);
        return clusterService;
     */
        if (nodeEnv.hasNodeFile()) {
            public void onStoreClosed(ShardId shardId) {
        } catch (ShardLockObtainFailedException ex) {
            }
        BytesReference cacheKey,
            } else {
    public void deleteShardStore(String reason, ShardId shardId, ClusterState clusterState) throws IOException,
        }
     * cluster minimum refresh interval.
        if (request.source() != null && request.source().profile()) {
                mergeStats.addTotals(indexShard.mergeStats());
            indicesFieldDataCache,
            }
    public boolean isShardLevelRefreshEnabled() {
import org.opensearch.common.cache.policy.CachedQueryResult;
            throw new ResourceAlreadyExistsException(index);
     */
import java.util.function.BiFunction;
    public NodeIndicesStats stats(CommonStatsFlags flags) {
        this.allowExpensiveQueries = ALLOW_EXPENSIVE_QUERIES.get(clusterService.getSettings());
        }
    private final Collection<Function<IndexSettings, Optional<EngineFactory>>> engineFactoryProviders;
                        statsByShard.put(indexService.index(), arrayAsArrayList(indexShardStats));
     * Returns an IndexService for the specified index if exists otherwise a {@link IndexNotFoundException} is thrown.
                                try {
            null,
        clusterService.getClusterSettings()
                sb.append("[").append(shardId).append("]");
            for (final IndexShard indexShard : indexService) {
        }
            finalListeners,
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
    private final CircuitBreakerService circuitBreakerService;
        public IndexShardCacheEntity(IndexShard indexShard) {
    }
            return sb.toString();
import static java.util.Collections.emptyList;
            finalListeners,
        }
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                    remoteStoreSettings,
        PendingDelete(ShardId shardId, IndexSettings settings) {
            remoteStoreStatsTrackerFactory,
            this.index = shardId.getIndex();
        if (nodeEnv.hasNodeFile()) {
        } finally {
        addPendingDelete(index, pendingDelete);
        if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
import org.opensearch.index.refresh.RefreshStats;
import java.util.function.Consumer;
            StringBuilder sb = new StringBuilder();
        final MergedSegmentWarmerFactory mergedSegmentWarmerFactory,
            if (writeDanglingIndices) {
    public boolean allPendingDanglingIndicesWritten() {
                }).collect(Collectors.joining(","))
    public static final Setting<Boolean> CLUSTER_PLUGGABLE_DATAFORMAT_ENABLED_SETTING = Setting.boolSetting(
            .map(engineFactoryProvider -> engineFactoryProvider.apply(idxSettings))
    private final NamedXContentRegistry xContentRegistry;
        if (indexMetadata.useIngestionSource()) {
        indexingMemoryController.setNativeBufferBytes(bytes);
        Supplier<RepositoriesService> repositoriesServiceSupplier,
        final SegmentReplicationCheckpointPublisher checkpointPublisher,
        final List<Closeable> closeables = new ArrayList<>();
import org.opensearch.core.util.FileSystemUtils;
            this::getClusterDefaultMaxMergeAtOnce,
        }
                        indicesFieldDataCache,
                try {
        logger.debug("{} processing pending deletes", index);
        }
        return indexShard;
                indexMetadata.getIngestionSource().getDecoderType()
        assert DiscoveryNode.isDataNode(settings) : "dangling indices information should only be persisted on data nodes";
     */
        @Override
            null
        return (indexSettings, shardRouting) -> {
        MIN_DEFAULT_MAX_MERGE_AT_ONCE,
            return new NodeIndicesStats(commonStats, statsByShard(this, flags), searchRequestStats, statusCounterStats);
            this,
    // Package-private for testing
                : "mapping update consumer only required by local shards recovery";
            : null;
        final RecoveryListener recoveryListener,
        nodeEnv.deleteShardDirectoryUnderLock(lock, indexSettings);
    /**
            }
            MetadataStateFormat.deleteMetaState(nodeEnv.indexPaths(index));
            } catch (OpenSearchRejectedExecutionException e) {
        this.fixedRefreshIntervalSchedulingEnabled = fixedRefreshIntervalSchedulingEnabled;
            final TieredStoragePrefetchSettings prefetchSettings = new TieredStoragePrefetchSettings(clusterService.getClusterSettings());
        }
        assert indexService != null;
        }
            mapperRegistry,
        }
    private final Function<ShardId, ReplicationStats> segmentReplicationStatsProvider;
                Index index = metadata.getIndex();
                this::onClusterLevelForceMergeMBPerSecUpdate
            // the whole QSR into memory when we decide whether to allow it into a particular cache tier based on took time/other info
    }
 * this work for additional information regarding copyright
                    commonStats.recoveryStats.add(oldShardsStats.recoveryStats);
        Property.NodeScope,
        final DiscoveryNodes discoveryNodes,
import org.opensearch.index.engine.EngineConfig;
package org.opensearch.indices;
                        logger.warn("{} still pending deletes present for shards {} - retrying", index, remove.toString());
        Property.Dynamic
     * This method assumes that an index is already deleted in the cluster state and/or explicitly
     * value into the {@link SearchContext#queryResult() context's query result}. The combination of load + compute allows
    /**
 * Licensed to Elasticsearch under one or more contributor
     * @opensearch.api
     * is different from the given {@code metadata}.
     * @param lock the lock of the shard to delete
            final IndexMetadata metadata;
    private final IndicesFieldDataCache indicesFieldDataCache;
        this.segmentReplicationStatsProvider = segmentReplicationStatsProvider;
     * Processes all pending deletes for the given index. This method will acquire all locks for the given index and will
    public void setSearchStatsContributors(List<SearchStatsContributor> contributors) {
            }
            remoteDirectoryFactory,
    private final BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier;
                }
                }
        true,
        }
 * KIND, either express or implied.  See the License for the
     * cluster-default stamping. Indices whose name starts with any of these prefixes will not have
import org.opensearch.index.engine.ReadOnlyEngine;
                // lets see if it's on a custom path (return false if the shared doesn't exist)
     */
            compositeIndexSettings,
                    assert false : "temp index should not trigger store creation";
import org.opensearch.common.cache.service.CacheService;
        ensureChangesAllowed();
/*
        clusterService.getClusterSettings().addSettingsUpdateConsumer(ALLOW_EXPENSIVE_QUERIES, this::setAllowExpensiveQueries);
            indexNameExpressionResolver,
    public static final Setting<Boolean> CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING = Setting.boolSetting(
            indexService.close(extraInfo, reason == IndexRemovalReason.DELETED);
        Map<String, IngestionConsumerFactory> ingestionConsumerFactories,
import org.opensearch.common.util.BigArrays;
                    throw new OpenSearchException("failed to delete unused index after deleting its last shard (" + shardId + ")", e);
        logger.debug("{} deleted shard reason [{}]", shardId, reason);
        this.allowExpensiveQueries = allowExpensiveQueries;
     * Returns <code>true</code> if fielddata is enabled for the {@link IdFieldMapper} field, <code>false</code> otherwise.
import org.opensearch.node.Node;
        );
            throw new IllegalStateException(message);
            valuesSourceRegistry,
            return null;
 * license agreements. See the NOTICE file distributed with
                    .commonStats(new CommonStats(indicesService.getIndicesQueryCache(), indexShard, flags))
                    RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexSettings.getIndexMetadata())
            return Optional.of(new IndexShardCacheEntity(indexService.getShardOrNull(shardId.id())));
import java.util.Optional;
    @Nullable
                return 0;
                pendingDeletes.put(index, list);
                nodeEnv.deleteIndexDirectorySafe(index, 0, indexSettings);
import org.opensearch.core.common.io.stream.StreamOutput;
    public boolean canDeleteIndexContents(Index index, IndexSettings indexSettings) {
            new ShardStats[] {
                assert sizeInBytes >= 0 : "When reducing circuit breaker, it should be adjusted with a number higher or "
    private final ScriptService scriptService;
                                logger.warn("{} no shard lock for pending delete", delete.shardId);
    }
                        sleepTime = Math.min(maxSleepTimeMs, sleepTime * 2); // increase the sleep time gradually
     */
                            assert delete.shardId != -1;
     * Applied at index creation time when the index setting is not explicitly provided.
            if (isAllocated) {
    }
                // we don't need to delete anything that is not there
     * they are used by a different process ie. on Windows where files might still be open by a virus scanner. On a shared
import java.util.Objects;
            shardRouting,
        return mapperRegistry.isMetadataField(field);
             * results.*/
            xContentRegistry,
    }
        BigArrays bigArrays,
    void deleteIndexStore(String reason, IndexMetadata metadata) throws IOException {
import java.util.concurrent.atomic.AtomicInteger;
 * Modifications Copyright OpenSearch Contributors. See
     * to have a single load operation that will cause other requests with the same key to wait till its loaded an reuse
        Property.NodeScope,
    }
                    IOUtils.close(
                    ? ShardDeletionCheckResult.FOLDER_FOUND_CAN_DELETE
            }
    private final IndexDeletionAllowedPredicate ALWAYS_TRUE = (Index index, IndexSettings indexSettings) -> true;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
    /**
        final IndexMetadata indexMetadata,
 * the Apache License, Version 2.0 (the "License"); you may
                }
            globalCheckpointSyncer,
            numUncompletedDeletes.incrementAndGet();
                // throws an exception, it gets added to the list of pending deletes to be tried again
            engineFactoryProviders,
        } else if (context.queryResult().searchTimedOut()) {
        } else {
import org.opensearch.common.settings.Setting.Property;
        };
    /**
        }
                if (hasIndex(index) == false) {
     * @throws InterruptedException if the current thread got interrupted while waiting for shards to close
    /**
        );
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader.DelegatingCacheHelper;
        assert nodeWriteDanglingIndicesInfo : "writing dangling indices info is not enabled";
        IndexSettings.DEFAULT_REFRESH_INTERVAL,
        return indices.containsKey(index.getUUID());
    public IndexShard createShard(
            .addSettingsUpdateConsumer(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING, this::onRefreshIntervalUpdate);
    public void clearIndexShardCache(ShardId shardId, boolean queryCache, boolean fieldDataCache, boolean requestCache, String... fields) {
        this.defaultMaxMergeAtOnce = CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING.get(clusterService.getSettings());
    /**
        Consumer<IndexShard> replicator,
                    @Override
            return indexServiceConsumer.apply(indexService);
        return this.clusterDefaultRefreshInterval;
            }
            directoryFactories,
        }), cacheService, threadPool, clusterService, nodeEnv);
     */
        public void validate(TimeValue value) {
                            + index.getName()
        false,
                    while (iterator.hasNext()) {
                    break;
     * Statistics for old shards
        // index contents can be deleted if its an already closed index (so all its resources have
                                }
            final IndexSettings indexSettings = indexService.getIndexSettings();
    private final AnalysisRegistry analysisRegistry;
    );
        indexingMemoryController = new IndexingMemoryController(
        final IndexSettings indexSettings = buildIndexSettings(metadata);
        final IndexMetadata metadata = clusterState.getMetadata().indices().get(shardId.getIndexName());
            () -> allowExpensiveQueries,
        NO_LOCAL_STORAGE // node does not have local storage (see DiscoveryNode.nodeRequiresLocalStorage)
            segmentReplicationStatsProvider,
        s -> s,
        for (IndexingOperationListener operationListener : indexingOperationListeners) {
            final long triggeredTimeMillis = threadPool.relativeTimeInMillis();
        String[] aliases = indexNameExpressionResolver.filteringAliases(state, index, resolvedExpressions);
                                iterator.remove();
import org.opensearch.common.util.concurrent.AbstractRefCounted;
        RecoverySettings recoverySettings,
            idxSettings.getNumberOfShards(),
                    commonStats.indexing.add(oldShardsStats.indexingStats);
    }
     * Cluster-level default for {@code index.pluggable.dataformat}.
        IndexService indexService = indices.get(index.getUUID());
                // if this index was closed or deleted, we should eliminate the effect of the current scroll for this shard
import org.opensearch.index.query.QueryBuilder;
        CompositeIndexSettings compositeIndexSettings,
    private static final class ClusterDefaultRefreshIntervalValidator implements Setting.Validator<TimeValue> {
            return false;
        if (request.requestCache() == null) {
    }
import java.util.concurrent.atomic.AtomicBoolean;
        this.storeFactories = storeFactories;
     * has an entry invalidated may not clean up the entry if it is not read from
        if (indexMetadata == null) {
        Settings settings,
     * result type returned by {@link #canDeleteShardContent signaling different reasons why a shard can / cannot be deleted}
            }
            idxSettings,
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
        @Override
        for (final IndexService indexService : indicesService) {
import org.opensearch.index.IndexService;
            // Reschedule itself to run again if not closed
                                    iterator.remove();
    }
                }
    }
    public IndicesService(
import org.opensearch.action.admin.indices.stats.CommonStats;
            synchronized (this) {
            this.cache = cache;
    }
            }
            new IndexEventListener() {
        }
            dataFormatRegistry.getDocumentMetadataResolver()
    }
import org.opensearch.common.CheckedSupplier;
     *
     * @opensearch.internal
        IndexMetadata indexMetadata,
     * Called when the indexing pool group's effective limit changes.
import static org.opensearch.common.collect.MapBuilder.newMapBuilder;
    }
        Settings settings,
        this.engineFactoryProviders = engineFactoryProviders;
     * implementations.
        Property.Dynamic
    private final BigArrays bigArrays;
    /**
    public void setNativeIndexBufferBytes(long bytes) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.gateway.MetadataStateFormat;
import org.opensearch.common.settings.Setting;
            null,
            service.mapperService().merge(metadata, MapperService.MergeReason.MAPPING_RECOVERY);
}
import static org.opensearch.index.TieredMergePolicyProvider.DEFAULT_MAX_MERGE_AT_ONCE;
        return new IndexSettings(metadata, settings);
    public IndicesQueryCache getIndicesQueryCache() {
        this.client = client;
            circuitBreakerService,
                // for now, keep the paged data structure, which might have unused bytes to fill a page, but better to keep
import static java.util.Collections.emptyMap;
     */
        this.settings = settings;
     * @throws IOException if an IOException occurs
                        if (contributed != null) {
    private static final class CacheCleaner implements Runnable, Releasable {
            }
    private final Settings settings;
     * method gets called whenever the setting changes. We set the instance variable with the updated value as this is
            retentionLeaseSyncer,
    private final DataFormatRegistry dataFormatRegistry;
import org.opensearch.common.util.concurrent.AbstractRunnable;
        RetentionLeaseStats retentionLeaseStats;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            this.pluginsService,
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
                listener = indexService.getIndexEventListener();
        nodeWriteDanglingIndicesInfo = WRITE_DANGLING_INDICES_INFO_SETTING.get(settings);
     */
    private final Map<String, IndexStorePlugin.StoreFactory> storeFactories;
                // ignore cases where we are shutting down..., there is really nothing interesting to be done here...
     * with the deletion process and delay it unnecessarily.
        IngestionPayloadDecoderRegistry ingestionPayloadDecoderRegistry,
            this.logger = logger;
     * Creates a new {@link IndexService} for the given metadata.
    }
                CLUSTER_REFRESH_FIXED_INTERVAL_SCHEDULE_ENABLED_SETTING,
     *
        this.replicator = replicator;
        final IndexService indexService = indexService(index);
                                nodeEnv.deleteIndexDirectoryUnderLock(index, indexSettings);
        ShardId shardId = lock.getShardId();
        DataFormatRegistry dataFormatRegistry
        if (nodeEnv.hasNodeFile() && FileSystemUtils.exists(nodeEnv.indexPaths(index))) {
            .filter(maybe -> Objects.requireNonNull(maybe).isPresent())
        final PeerRecoveryTargetService recoveryTargetService,
import java.util.HashMap;
 */
        }
        return null;
            @Override
    private final Consumer<IndexShard> replicator;
            }
            List<PendingDelete> list = pendingDeletes.get(index);
import org.opensearch.index.mapper.MapperService;
            remoteStoreStatsTrackerFactory,
        this.translogFactorySupplier = getTranslogFactorySupplier(
        "cluster.minimum.index.refresh_interval",
                    .seqNoStats(seqNoStats)
                service.updateMetadata(metadata, metadataUpdate);
            if (settings.getValue(IndicesRequestCache.INDEX_CACHE_REQUEST_ENABLED_SETTING) == false
        if (hasIndex(index)) {
                    "periodic field data cache cleanup finished in {} milliseconds",
            throw new IllegalArgumentException(
            try (
        @Override
            final IndexEventListener listener;
        // then we can't cache based on "now" key within the search request, as it is not deterministic
    public Iterator<IndexService> iterator() {
        IndexSettings settings = context.indexShard().indexSettings();
import org.opensearch.index.engine.EngineFactory;
    public boolean hasIndex(Index index) {
import org.opensearch.env.ShardLock;
import java.util.Iterator;
                            + localUUid
    private final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories;
     *
        public boolean isOpen() {
                    : ShardDeletionCheckResult.NO_FOLDER_FOUND;
                            + "] - it's still part of "
import org.opensearch.cluster.routing.ShardRouting;
        private final Logger logger;
    @Override
                    indexService.deleteDanglingIndicesInfo();
                                } catch (IOException ex) {
     * schedule there deletes later.
                recoveryStats.addTotals(indexShard.recoveryStats());
                // now we are done - try to wipe data on disk if possible
    }
    @Override
            commitStats = null;
            compositeIndexSettings,
    private void ensureChangesAllowed() {
        final DiscoveryNode targetNode,
        try {
    private volatile boolean shardLevelRefreshEnabled;
        // if now in millis is used (or in the future, a more generic "isDeterministic" flag
        @Override
            CREATE_INDEX,
    }
    }
        Map<String, org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories,
    private static final String DANGLING_INDICES_UPDATE_THREAD_NAME = "DanglingIndices#updateTask";
        Property.NodeScope,
        }
            getEngineConfigFactory(idxSettings),
            final IndexService indexService;
    private final Map<Index, List<PendingDelete>> pendingDeletes = new HashMap<>();
     */
     */
            );
    private final IngestionPayloadDecoderRegistry ingestionPayloadDecoderRegistry;
        this.cleanInterval = INDICES_CACHE_CLEAN_INTERVAL_SETTING.get(settings);
    private volatile int maxSizeInRequestCache;
            final IndexSettings indexSettings = buildIndexSettings(metadata);
     * @param maxForceMergeMBPerSec the updated cluster max force merge MB per second rate.
            recoveryStateFactories,
     * @param loader loads the data into the cache if needed
     *                               per-index listeners
        IndicesClusterStateService.AllocatedIndices<IndexShard, IndexService>,
import java.util.concurrent.TimeUnit;
 * Main OpenSearch indices service
                searchStats.addTotalsForClosingShard(indexShard.searchStats());
            public void onStoreCreated(ShardId shardId) {
     * Deletes the shard with an already acquired shard lock.
            closeables.add(() -> service.close("metadata verification", false));
            seqNoStats = null;
    @Override
                        cacheCleaner,
        "cluster.restrict.pluggable.dataformat",
     * the index.replication.type setting.
            repositoriesService,
        clusterService.getClusterSettings().addSettingsUpdateConsumer(INDICES_ID_FIELD_DATA_ENABLED_SETTING, this::setIdFieldDataEnabled);
            IndexShard shard = service.getShardOrNull(shardId.id());
    /**
        ThreadPool.terminate(danglingIndicesThreadPoolExecutor, 10, TimeUnit.SECONDS);
     * Retrieves the current statistics for search response (Not a snapshot).
            IOUtils.close(shardLocks);
    Map<Index, List<IndexShardStats>> statsByShard(final IndicesService indicesService, final CommonStatsFlags flags) {
                    public void onFailure(Exception e) {
        PollingIngestStats pollingIngestStats;
        }
                    remoteStoreStatsTrackerFactory.getRemoteTranslogTransferTracker(shardRouting.shardId()),
import org.opensearch.core.xcontent.MediaTypeRegistry;
     * Used to specify SEGMENT replication type as the default replication strategy for all indices in a cluster. By default, this is false.
            mergedSegmentPublisher,
        this.indicesFieldDataCache = new IndicesFieldDataCache(settings, new IndexFieldDataCache.Listener() {
     */
            dataFormatAwareStoreDirectoryFactories
                daemonThreadFactory(nodeName, DANGLING_INDICES_UPDATE_THREAD_NAME),
        // actual content.
    private final TimeValue cleanInterval; // clean interval for the field data cache
        // (think about top_hits aggs or scripts using the score)
import org.opensearch.action.admin.indices.stats.CommonStatsFlags.Flag;
        Property.NodeScope,
    private final PluginsService pluginsService;
import java.io.InputStream;
        return closeLatch.await(timeout, timeUnit);
            nodeEnv,
        int numRemoved = 0;
                remove = pendingDeletes.remove(index);
    /**
            referencedSegmentsPublisher
        CacheCleaner(IndicesFieldDataCache cache, Logger logger, ThreadPool threadPool, TimeValue interval) {
                        final IndexService indexService = indices.get(index.getUUID());
            this::isFixedRefreshIntervalSchedulingEnabled,
    ) throws IOException, E {
                        ingestionPayloadDecoderRegistry
        final DiscoveryNode targetNode,
            }
    );
     */
        "cluster.index.refresh.fixed_interval_scheduling.enabled",
     * @param stats Instance storing {@link DocStatusStats}
            if (shardId != -1) {
        if (SearchType.QUERY_THEN_FETCH != context.searchType()) {
        indexShard.addShardFailureCallback(onShardFailure);
     * The changes to dynamic cluster setting {@code cluster.default.index.refresh_interval} needs to be updated. This
        return indicesRequestCache.getOrCompute(new IndexShardCacheEntity(shard), supplier, reader, cacheKey);
    );
        Property.Dynamic
                            + "]"
            .addSettingsUpdateConsumer(CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING, this::onRefreshLevelChange);
    public QueryRewriteContext getRewriteContext(LongSupplier nowInMillis, TaskId parentTaskId) {
     * This method deletes the shard contents on disk for the given shard ID. This method will fail if the shard deleting
        @Nullable RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
        false,
        }
     * On data nodes, if the deleted shard is the last shard folder in its index, the method will attempt to remove
     * TODO: In a future PR field data cache keys will also only be marked for cleanup.
        Property.NodeScope
                return ShardDeletionCheckResult.STILL_ALLOCATED; // we are allocated - can't delete the shard
        try {
            /* BytesStreamOutput allows to pass the expected size but by default uses
        "cluster.index.restrict.replication.type",
        return statsByShard;
            if ((requestCache || (clearedAtLeastOne == false && fields.length == 0)) && shard != null) {
            // this is a pure protection to make sure this index doesn't get re-imported as a dangling index.
            remoteStoreSettings
    @Override
        this.dataFormatAwareStoreDirectoryFactories = dataFormatAwareStoreDirectoryFactories;
                        break;
    }
        return indexModule.newIndexService(
     * which is different from 1s and also at the same time have searchIdle feature supported. The setting can only be
            }
                            + metadata.getIndexUUID()
        ReplicationType.DOCUMENT.toString(),
import org.opensearch.storage.prefetch.StoredFieldsPrefetch;
                            + index.getIndexUUID()
            @Override
        if (canDeleteIndexContents(shardId.getIndex(), indexSettings)) {
            throw new IllegalArgumentException(
        return idFieldDataEnabled;
    }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        }
        final MergeStats mergeStats = new MergeStats();
import org.opensearch.indices.recovery.RecoverySettings;
                try {
            discoveryNodes,
     * @param reason the reason for the shard deletion
    interface IndexDeletionAllowedPredicate {
                logger.debug("[{}] closing ... (reason [{}])", indexName, reason);
            indexModule.addIndexEventListener(listener);
    private final Client client;
     * {@code cluster.default.index.refresh_interval} setting value needs to be higher than this setting's value. Index
        Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories,
            metaStateService,
        final RepositoriesService repositoriesService,
            recoveryStateFactories,
            pollingIngestStats = null;
        this.pluginsService = pluginsService;
            try {
                    final IndexMetadata index = clusterState.metadata().index(indexName);
        "cluster.default.index.max_merge_at_once",
import org.opensearch.index.engine.exec.DataFormatAwareIndexerFactory;
    }
        @Override
                metadata = metaStateService.loadIndexState(index);
    private final NodeEnvironment nodeEnv;
                    );
            targetNode,
                    remoteStoreSettings,
        );
                case Refresh:
    public IndexMetadata verifyIndexIsDeleted(final Index index, final ClusterState clusterState) {
        // Queries that create a scroll context cannot use the cache.
            }
    }
        final IndexModule indexModule = new IndexModule(
             * a date histogram with 3 buckets is ~100byte so 16k might be very wasteful
     * @opensearch.internal
        false,
        @Override
                    + minimumRefreshInterval
        NamedWriteableRegistry namedWriteableRegistry,
        } catch (Exception e) {
            this.shardId = shardId.getId();
                logger.trace(
                    if (indexShardStats == null) {
        IndexScopedSettings indexScopedSettings,
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.daemonThreadFactory;
import org.opensearch.index.merge.MergeStats;
            this::isIdFieldDataEnabled,
            );
     * This setting is used to set the refresh interval when the {@code index.refresh_interval} index setting is not
    private boolean isFixedRefreshIntervalSchedulingEnabled() {
     * This comes handy when the user wants to change the maxMergeAtOnce across all indexes created in a cluster
    }
            // restore the cached query result into the context
            if (metadata.equals(metadataUpdate) == false) {
                case Recovery:
        if (context.getQueryShardContext().isCacheable() == false) {
        try {
            return false;
    }
             * slowly until we hit the page size and don't waste too much memory for small query
import org.opensearch.action.admin.indices.stats.ShardStats;
                        logger.debug("{} schedule pending delete retry after {} ms", index, sleepTime);
        this.shardLevelRefreshEnabled = CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING.get(clusterService.getSettings());
        clusterService.getClusterSettings()
     * Loads the cache result, computing it if needed by executing the query phase and otherwise deserializing the cached
                    commonStats.merge.add(oldShardsStats.mergeStats);
            settings,
                            logger.trace(
 * specific language governing permissions and limitations
    public static final String INDICES_CACHE_CLEANUP_INTERVAL_SETTING_KEY = "indices.cache.cleanup_interval";
        DirectoryReader reader,
        public void close() {
        CacheService cacheService,
            this::getClusterDefaultRefreshInterval,
        IndexNameExpressionResolver indexNameExpressionResolver,
    @Override
        Setting.Property.NodeScope
        }
     * creates a new mapper service for the given index, in order to do administrative work like mapping updates.
            return indexShard.state() != IndexShardState.CLOSED;
     * without a parent those look like fresh top-level requests to anything that tracks the task tree.
                            final long executedTimeMillis = threadPool.relativeTimeInMillis();
 * under the License.
import java.util.Map;
            String type = indexMetadata.getIngestionSource().getType().toUpperCase(Locale.ROOT);
        final IndexService service = indexService(shardId.getIndex());
    public void setFixedRefreshIntervalSchedulingEnabled(boolean fixedRefreshIntervalSchedulingEnabled) {
    final AbstractRefCounted indicesRefCount; // pkg-private for testing
        ScriptService scriptService,
            idxSettings,
     * Returns a new {@link QueryRewriteContext} whose async actions issue their requests as children of
import org.opensearch.index.remote.RemoteStoreUtils;
import org.opensearch.index.translog.TranslogStats;
    private final SearchRequestStats searchRequestStats;
    public void forceClearNodewideCaches() {
        if (request.scroll() != null) {
            this.recoverySettings,
            for (Map.Entry<String, IndexService> entry : indices.entrySet()) {
     * method gets called whenever the setting changes. We set the instance variable with the updated value as this is
import java.util.concurrent.CountDownLatch;
        RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
            nodeCacheService,
            );
            indicesBitsetFilterCache,
            indexService.getIndexEventListener().afterIndexCreated(indexService);
import org.apache.lucene.store.AlreadyClosedException;
        Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories,
        }
        final String indexName = index.getName();
    public SearchResponseStatusStats getSearchResponseStatusStats() {
        boolean success = false;
    }
            if (indexService == null) {
            // Load the cached QSR into result, discarding values used only in the cache
                    commonStats.refresh.add(oldShardsStats.refreshStats);
        IndexSettings indexSettings) -> canDeleteIndexContents(index, indexSettings);
            }
                // we don't need to delete anything that is not there
        final RetentionLeaseSyncer retentionLeaseSyncer,
    void setMaxSizeInRequestCache(Integer maxSizeInRequestCache) {
import org.opensearch.common.unit.TimeValue;
import org.opensearch.index.mapper.IdFieldMapper;
    public boolean awaitClose(long timeout, TimeUnit timeUnit) throws InterruptedException {
            // instead we all caching such a result for the time being, return the timed out result for all other searches with that cache
        final IndexMetadata indexMetadata,
        this.analysisRegistry = analysisRegistry;
     * If enabled, this setting enforces that indexes will be created with a replication type matching the cluster setting
        PluginsService pluginsService,
    /**
     * @param indexSettings {@code IndexSettings} for the given index
        try (Closeable dummy = () -> indexService.close("temp", false)) {
    }
    public void addDocStatusStats(final DocStatusStats stats) {
     * Applied at index creation time when the index setting is not explicitly provided.
/*
    @Nullable
                    }
        return circuitBreakerService;
    private final TimeValue shardsClosedTimeout;
        this.fixedRefreshIntervalSchedulingEnabled = CLUSTER_REFRESH_FIXED_INTERVAL_SCHEDULE_ENABLED_SETTING.get(
            final List<Setting<?>> settings = List.of(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING);
import org.apache.lucene.index.IndexReader.CacheHelper;
                                logger.debug(() -> new ParameterizedMessage("{} retry pending delete", index), ex);
        this.dataFormatRegistry = dataFormatRegistry;
                indicesBitsetFilterCache,
        IndexService.IndexCreationContext indexCreationContext,
            }
                list = new ArrayList<>();
     * @param builtInListeners       a list of built-in lifecycle {@link IndexEventListener} that should should be used along side with the
        }
                    commonStats.get.add(oldShardsStats.getStats);
        RecoveryState recoveryState = indexService.createRecoveryState(shardRouting, targetNode, sourceNode);
    private final StatusCounterStats statusCounterStats;
        final List<Optional<EngineFactory>> engineFactories = engineFactoryProviders.stream()
                InputStream inputStream = bytes.streamInput();
                    Iterator<PendingDelete> iterator = remove.iterator();
            pluginsService,
import org.opensearch.index.IngestionConsumerFactory;
        );
import org.opensearch.index.ReplicationStats;
                    );
    @Override
import java.util.function.LongSupplier;
    }
                    .commitStats(commitStats)
            if (idxSettings.isSegRepEnabledOrRemoteNode() || idxSettings.isAssignedOnRemoteNode()) {
    private void addPendingDelete(Index index, PendingDelete pendingDelete) {
@PublicApi(since = "1.0.0")
        }
     * @param cacheKey key for the thing being cached within this shard
        assert indexService.indexUUID().equals(index.getUUID()) : "uuid mismatch local: "
     */
        }
                            commonStats.search.add(contributed);
     */
            success = true;
            logger.warn(() -> new ParameterizedMessage("failed to remove index {} ([{}][{}])", index, reason, extraInfo), e);
     * @return the contents of the cache or the result of calling the loader
        boolean[] loadedFromCache = new boolean[] { true };
        }
            client,
    }
import org.opensearch.index.analysis.AnalysisRegistry;
import org.opensearch.index.store.remote.filecache.NodeCacheService;
            seqNoStats = indexShard.seqNoStats();
import org.opensearch.storage.slowlogs.TieredStorageSearchSlowLog;
import org.opensearch.common.util.set.Sets;
     * This method tries to update the meta data of the created {@link IndexService} if the given {@code metadataUpdate}
    private static final class PendingDelete implements Comparable<PendingDelete> {
                    }
        SearchRequestStats searchRequestStats,
        return this.defaultMaxMergeAtOnce;
    static class OldShardsStats implements IndexEventListener {
     * @opensearch.internal
        final int shardId;
                CollectionUtil.timSort(remove); // make sure we delete indices first
    private void setAllowExpensiveQueries(Boolean allowExpensiveQueries) {
        final IndexSettings idxSettings = new IndexSettings(indexMetadata, settings, indexScopedSettings);
        if (nodeEnv.hasNodeFile()) {
        this.searchRequestStats = searchRequestStats;
            }
    // visible for testing
                    .retentionLeaseStats(retentionLeaseStats)
            if (list == null) {
        false,
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
    private final CacheCleaner cacheCleaner;
    public ByteSizeValue getTotalIndexingBufferBytes() {
        Client client,
        this.clusterDefaultRefreshInterval = clusterDefaultRefreshInterval;
            final String message = String.format(
            nodeEnv,
        } else if (request.requestCache() == false) {
        // They modify the search context during their execution so using the cache
                            if (shardLock != null) {
                    repositoriesServiceSupplier,
    public ShardDeletionCheckResult canDeleteShardContent(ShardId shardId, IndexSettings indexSettings) {
        ValuesSourceRegistry valuesSourceRegistry,
                        } else {
        // shard at data nodes and let coordinator handle the reduce from batched results from shards.
                }
    }
        Property.NodeScope,
        return this.remoteStoreSettings;
        IndexNameExpressionResolver indexNameExpressionResolver,
            return BASE_RAM_BYTES_USED;
     */
    public static final String INDICES_SHARDS_CLOSED_TIMEOUT = "indices.shards_closed_timeout";
     */
        // We cannot cache with DFS because results depend not only on the content of the index but also
                assert indexService != null : "IndexService is null for index: " + index;
        this.compositeIndexSettings = compositeIndexSettings;
     */
        "",
        // may invalidate the scroll for the next query.
        clusterService.getClusterSettings()
        }
        } catch (InterruptedException e) {
                final long maxSleepTimeMs = 10 * 1000; // ensure we retry after 10 sec
            idxSettings.getNumberOfReplicas(),
     * This is the case if the index is deleted in the metadata or there is no allocation
                logger.trace("[{}] still has shard stores, leaving as is", shardId.getIndex());
                            + "] ["
    public void loadIntoContext(ShardSearchRequest request, SearchContext context, QueryPhase queryPhase) throws Exception {
                @Override
        this.recoveryStateFactories = recoveryStateFactories;
        if (indexShard.routingEntry() == null) {
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
        Collection<Function<IndexSettings, Optional<EngineFactory>>> engineFactoryProviders,
                    + sizeInBytes
        RemoteStoreSettings remoteStoreSettings
            storeFactories,
            getIndexerFactory(idxSettings),
            indexService.onRefreshIntervalChange();
        STILL_ALLOCATED, // the shard is still allocated / active on this node
        MetaStateService metaStateService,
        Property.Dynamic
    private volatile int defaultMaxMergeAtOnce;
        };
        }
                case Search:
                }
        // avoid closing these resources while ongoing requests are still being processed, we use a
        final MergedSegmentWarmerFactory mergedSegmentWarmerFactory
            circuitBreakerService,
        private final IndexShard indexShard;
import org.opensearch.action.admin.indices.stats.DocStatusStats;
            bigArrays,
                    return null;
                    + "]"
     *
            // we have to invalidate the cache entry if we cached a query result form a request that timed out.
                        if (delete.deleteIndex) {
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
    ) {
     */
            xContentRegistry,
            indexCreationContext
        Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories,
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
import org.opensearch.common.CheckedConsumer;
            this.threadPool = threadPool;
        this.idFieldDataEnabled = value;
        this.searchStatsContributors = contributors;
            return null;
            // shard is closed - no stats is fine
            indicesStopExecutor.execute(() -> {
import org.apache.logging.log4j.Logger;
        Property.NodeScope,
                new ShardStats.Builder().shardRouting(indexShard.routingEntry())
            if (logger.isTraceEnabled()) {
        final String reason,
            namedWriteableRegistry,
                metadata,
            clusterService.getSettings()
                // If no request cache query parameter and shard request cache
            threadPool,
    ) throws IOException {
import org.opensearch.index.translog.RemoteBlobStoreInternalTranslogFactory;
        return indicesFieldDataCache;
        this.ingestServiceSupplier = ingestServiceSupplier;
        pluginsService.onIndexModule(indexModule);
                indicesFieldDataCache,
                            ShardLock shardLock = locks.get(new ShardId(delete.index, delete.shardId));
        final IndexMetadata indexMetadata = idxSettings.getIndexMetadata();
/*
    }
            indexModule.addSearchOperationListener(new StoredFieldsPrefetch(tieredStoragePrefetchSettingsSupplier));
     * Deletes an index that is not assigned to this node. This method cleans up all disk folders relating to the index
        TimeValue.timeValueMinutes(1),
     * Adds a pending delete for the given index.
                    threadPool,
            }
            logger.debug(
     * Validates the cluster default index refresh interval.
 */
        final ReferencedSegmentsPublisher referencedSegmentsPublisher
    public static final Setting<TimeValue> INDICES_CACHE_CLEAN_INTERVAL_SETTING = Setting.positiveTimeSetting(
        CommitStats commitStats;
     * @opensearch.internal
            this.indexShard = indexShard;
    }
     * Force clear node-wide request cache, which will remove any keys which have been previously marked for cleanup.
import org.opensearch.cluster.routing.RecoverySource;
        return indexingMemoryController.indexingBufferSize();
                indexService.addMetadataListener(imd -> updateDanglingIndicesInfo(index));
    }
    private EngineFactory getEngineFactory(final IndexSettings idxSettings) {
            success = true;
        return indexService;
    private final IndexingMemoryController indexingMemoryController;
    private volatile TimeValue clusterDefaultRefreshInterval;
        } finally {
        public void run() {
                    .pollingIngestStats(pollingIngestStats)
    private static void validateRefreshIntervalSettings(TimeValue minimumRefreshInterval, TimeValue defaultRefreshInterval) {
        }
import org.apache.lucene.index.DirectoryReader;
        this.ingestionConsumerFactories = ingestionConsumerFactories;
     */
    /**
        if (defaultRefreshInterval.millis() < 0) {
        @Override
import java.util.Locale;
                                index,
                Map<String, IndexService> newIndices = new HashMap<>(indices);
        }
        if (indexMetadata != null && indexMetadata.useIngestionSource()) {
    );
        Map<String, IndexStorePlugin.StoreFactory> storeFactories,
            }
        final boolean writeDanglingIndices
     * run.
    /**
                ex
                    break;
    public static final Setting<Integer> CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING = Setting.intSetting(
        true,
    /**
     * If enabled, this setting enforces that indexes will be created with pluggable data-format settings matching the
        Supplier<RepositoriesService> repositoriesServiceSupplier,
        } else {
                threadPool.getThreadContext()
            // The refresh mode has changed from index level to shard level and vice versa
    }
            // every shards deletes its content under the shard lock it owns.
     */
            for (ShardLock lock : shardLocks) {
     * when the {@code index.merge.policy.max_merge_at_once} index setting is not provided during index creation
                            logger.debug("{} deleting index store reason [{}]", index, "pending delete");
            indexCreationContext,
            return indexShard;
                                    deleteShardStore("pending delete", shardLock, delete.settings);
import org.opensearch.indices.pollingingest.IngestionEngineFactory;
        RecoverySettings recoverySettings,
    protected void doStart() {
                );
        if (lifecycle.started() == false) {
                }
    }
import java.util.stream.Collectors;
        oldShardsStats.indexingStats.getTotal().getDocStatusStats().add(stats);
        return numUncompletedDeletes.get() > 0;
            synchronized (this) {
        final IndexEventListener onStoreClose = new IndexEventListener() {
                indexService.close("plugins_failed", true);
     * Note: the returned {@link MapperService} should be closed when unneeded.
                    // note that deleteIndexStore have more safety checks and may throw an exception if index was concurrently created.
                    if (remove.isEmpty()) {
            if (writeDanglingIndices && nodeWriteDanglingIndicesInfo) {
import org.opensearch.core.index.Index;
            boolean prevShardLevelRefreshVal = this.shardLevelRefreshEnabled;
    }
                engineFactories.stream().map(t -> {
        // on the overridden statistics. So if you ran two queries on the same index with different stats
            logger.debug("{} closed... (reason [{}][{}])", index, reason, extraInfo);
        } catch (AlreadyClosedException e) {
        } else {
     */
            null,
     */
        }
    public static final Setting<TimeValue> CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING = Setting.timeSetting(
        public Iterator<Setting<?>> settings() {
    private static BiFunction<IndexSettings, ShardRouting, TranslogFactory> getTranslogFactorySupplier(
            try {
 * compatible open source license.
        IngestionPayloadDecoderRegistry payloadDecoderRegistry,
        Property.NodeScope,
            return new DataFormatAwareIndexerFactory();
                return new RemoteBlobStoreInternalTranslogFactory(
        @Override
     * <p>Plugins may use these filters to implement authorization access controls such as field-level security. Consumers must therefore
        SearchRequestStats searchRequestStats,
        danglingIndicesThreadPoolExecutor = nodeWriteDanglingIndicesInfo
    private final OpenSearchThreadPoolExecutor danglingIndicesThreadPoolExecutor;
            return new NodeIndicesStats(commonStats, statsByShard(this, flags), searchRequestStats, statusCounterStats, statsLevel);
    ) throws IOException {
    public IndexService indexService(Index index) {
            Collections.emptyMap(),
    final IndicesRequestCache indicesRequestCache; // pkg-private for testing
    }
            }
    }
            compositeDirectoryFactories,
import org.opensearch.index.shard.IndexingOperationListener;
        private final AtomicBoolean closed = new AtomicBoolean(false);
     * This method returns true if the current node is allowed to delete the given index.
    @Deprecated(since = "3.4.0")
import org.opensearch.index.engine.NRTReplicationEngineFactory;
        indicesRefCount.decRef();
                    + "equal to 0 and not ["
        nodeEnv.deleteShardDirectorySafe(shardId, indexSettings);
    }
        // We use the cacheKey of the index reader as a part of a key of the IndicesRequestCache.
            retentionLeaseSyncer,
     * @param minimumRefreshInterval value of cluster minimum index refresh interval setting
            analysisRegistry,
            threadPool,
            return false;
                int remainingUncompletedDeletes = numUncompletedDeletes.addAndGet(-numRemoved);
            this.shardId = -1;
                TimeUnit.MILLISECONDS,
        final List<ShardLock> shardLocks = nodeEnv.lockAllForIndex(index, indexSettings, "process pending deletes", timeout.millis());
            logger.trace("triggered dangling indices update for {}", index);
        if (engineFactories.isEmpty()) {
                case Indexing:
        }
     */
    /**
    private void deleteIndexStoreIfDeletionAllowed(
        CheckedConsumer<StreamOutput, IOException> loader
            indexService.onClusterLevelForceMergeMBPerSecUpdate(maxForceMergeMBPerSec);
            if (reason == IndexRemovalReason.DELETED) {
    public IndexShard createShard(
 * The OpenSearch Contributors require contributions made to
        });
                        assert exists : "removed non-existing item for " + index;
        CheckedSupplier<BytesReference, IOException> supplier = () -> {
            }
                );
        IndicesQueryCache indicesQueryCache,
            storeFactories,
     * periodically. In this case it is the field data cache, because a cache that
        PendingDelete pendingDelete = new PendingDelete(shardId, settings);
public class IndicesService extends AbstractLifecycleComponent
            clusterService,
        logger.trace("{} deleting shard reason [{}]", shardId, reason);
        addPendingDelete(shardId.getIndex(), pendingDelete);
                    }
                } finally {
        /* Being static, parseAliasFilter doesn't have access to whatever guts it needs to parse a query. Instead of passing in a bunch
                            assert delete.shardId == -1;
    );
     * metadata APIs such as get mappings, get index, get field mappings, and field capabilities, as well as APIs that access field values
     * make only fields matching all registered filters available. The same aggregated filter is exposed to query-schema and query-planning
        }
     * through index tombstones.
import org.opensearch.index.IngestionPayloadDecoderFactory;
                    throw new OpenSearchException("temp index should not trigger shard creation [{}]", index);
            ingestionConsumerFactories,
    }
        clusterService.getClusterSettings()
            globalCheckpointSyncer,
        }
    @Override
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import org.opensearch.cluster.service.ClusterService;
        Settings settings,
     */
            return NoOpEngine::new;
    private IndexSettings buildIndexSettings(IndexMetadata metadata) {
     * the index folder as well.
            validateRefreshIntervalSettings(minimumRefreshInterval, defaultRefreshInterval);
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
                    commonStats.flush.add(oldShardsStats.flushStats);
                        index
                            + metadata.getIndexUUID()
    }
        Index index,
    /**
     * @return true if all shards closed within the given timeout, false otherwise
     * Returns a new {@link QueryRewriteContext} for query validation with the given {@code now} provider
            "creating Index [{}], shards [{}]/[{}] - reason [{}]",
     *
        this.indexScopedSettings = indexScopedSettings;
     * of if the shards lock can not be acquired.
    public QueryRewriteContext getRewriteContext(LongSupplier nowInMillis) {
import static org.opensearch.core.common.util.CollectionUtils.arrayAsArrayList;
            indexShard.shardId(),
            return settings.iterator();
        for (Map.Entry<String, IndexService> entry : indices.entrySet()) {
         * of dependencies we pass in a function that can perform the parsing. */
    }
     * mappings, get index, get field mappings, and field capabilities APIs. Other consumers, including payload-data APIs, must likewise
        deleteIndexStoreIfDeletionAllowed(reason, index, indexSettings, DEFAULT_INDEX_DELETION_PREDICATE);
                            + "] - it's still part of the indices service ["
import org.opensearch.indices.recovery.RecoveryState;
        ExecutorService indicesStopExecutor = Executors.newFixedThreadPool(5, daemonThreadFactory(settings, "indices_shutdown"));
            return ingestionConsumerFactories.get(type);
    public void deleteUnassignedIndex(String reason, IndexMetadata metadata, ClusterState clusterState) {
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
import org.opensearch.common.annotation.PublicApi;
                deleteIndexStore(extraInfo, indexService.index(), indexSettings);
            }
                    protected void doRun() {
     * Can the shard request be cached at all?
    public static class IndexShardCacheEntity extends AbstractIndexShardCacheEntity {
                    .shardPath(indexShard.shardPath())
    }
     * or otherwise operate on payload data. The predicate receives the field name as its input.
        // already been relinquished)
            valuesSourceRegistry,
import org.apache.logging.log4j.LogManager;
        for (Map.Entry<String, IndexService> entry : indices.entrySet()) {
        }
        return mapperRegistry.getFieldFilter();
        Supplier<IngestService> ingestServiceSupplier,
            IOUtils.close(closeables);
     * Validates the cluster minimum index refresh interval.
            indicesRequestCache.invalidate(new IndexShardCacheEntity(context.indexShard()), directoryReader, request.cacheKey());
                .indices()
            logger.debug("{} closing index service (reason [{}][{}])", index, reason, extraInfo);
    /**
        this.defaultMaxMergeAtOnce = newDefaultMaxMergeAtOnce; // do we need this?
        private final IndicesFieldDataCache cache;
     * treat the result as an access-control boundary and must not bypass it or reintroduce rejected fields.
            indexService.onDefaultMaxMergeAtOnceChanged(newDefaultMaxMergeAtOnce);
        this.metaStateService = metaStateService;
     */
     *
     * @param shard the shard this item is part of
        final PeerRecoveryTargetService recoveryTargetService,
            return false;
    }
    public static final Setting<Boolean> WRITE_DANGLING_INDICES_INFO_SETTING = Setting.boolSetting(
            );
        Collections.emptyList(),
    /**
        }
    @FunctionalInterface
     */
    public static final Setting<Boolean> CLUSTER_REMOTE_INDEX_RESTRICT_ASYNC_DURABILITY_SETTING = Setting.boolSetting(
import java.util.concurrent.ExecutorService;
        // actually closed
     * between refreshes.
        } else if (engineFactories.size() == 1) {
            mapperRegistry,
        AnalysisRegistry analysisRegistry,
import org.opensearch.index.get.GetStats;
    }
                deleteIndexStoreIfDeletionAllowed("stale deleted index", index, indexSettings, ALWAYS_TRUE);
        Property.NodeScope,
            return new InternalTranslogFactory();
    }
     * This setting is used to enable fixed interval scheduling capability for refresh tasks to ensure consistent intervals
    private final RecoverySettings recoverySettings;
                case Merge:
        @Override
            recoveryTargetService,
            IngestionPayloadDecoderFactory decoderFactory = ingestionPayloadDecoderRegistry.get(
    );
        }
import org.opensearch.script.ScriptService;
        // that we need to wait for before closing some resources such as the caches. In order to
     * Returns a new {@link QueryRewriteContext} with the given {@code now} provider
    }
            retentionLeaseStats = indexShard.getRetentionLeaseStats();
        this.statusCounterStats = new StatusCounterStats();
                return Files.exists(nodeEnv.resolveCustomLocation(indexSettings.customDataPath(), shardId))
     * @param stats Instance storing {@link org.opensearch.index.shard.IndexingStats.Stats.DocStatusStats}
                } catch (IllegalIndexShardStateException | AlreadyClosedException e) {
    /**
            // cache. One other option is to not cache requests with a timeout at all...
        CLUSTER_SETTING_REPLICATION_TYPE,
                    ? ShardDeletionCheckResult.FOLDER_FOUND_CAN_DELETE
            new DataFormatRegistry(pluginsService)
        IndexService.ShardStoreDeleter {
            .addSettingsUpdateConsumer(INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING, this::setMaxSizeInRequestCache);
            // we can't really throw exceptions in the loading part to signal a timed out search to the outside world since if there are
    public void deleteShardStore(String reason, ShardLock lock, IndexSettings indexSettings) throws IOException {
            analysisRegistry,
        public synchronized void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
                danglingIndicesThreadPoolExecutor.execute(new AbstractRunnable() {
            // ensure we pull an iter with new shards - flatten makes a copy
    private final IndexDeletionAllowedPredicate DEFAULT_INDEX_DELETION_PREDICATE = (
            sb.append("[").append(index).append("]");
        final Map<Index, List<IndexShardStats>> statsByShard = new HashMap<>();
        if (settings == null) {
        final IndexSettings idxSettings = new IndexSettings(indexMetadata, this.settings, indexScopedSettings);
     */
    private final IndicesQueryCache indicesQueryCache;
     */
                METADATA_VERIFICATION,
     * This method will throw an exception if the creation or the update fails.
                        final boolean exists = danglingIndicesToWrite.remove(index);
    }
                    logger.trace(() -> new ParameterizedMessage("{} ignoring shard stats", indexShard.shardId()), e);
        this.mapperRegistry = mapperRegistry;
        for (IndexEventListener listener : builtInListeners) {
            scriptService,
        if (indexService == null) {
    /**
        final List<IndexEventListener> builtInListeners,
            @Override
                    throw new OpenSearchException("temp index should not trigger store creation [{}]", index);
                    } else {
                    () -> new ParameterizedMessage(
            nowInMillis,
        Property.NodeScope
        return getRewriteContext(nowInMillis, true);
            deleteIndexStore(reason, indexSettings.getIndex(), indexSettings);
        assert danglingIndicesThreadPoolExecutor != null : "executor for dangling indices info is not available";
    public void removeIndex(final Index index, final IndexRemovalReason reason, final String extraInfo) {
            }
     * cluster defaults applied and will not be rejected by the restrict setting.
        final boolean deleteIndex;
                    closeLatch.countDown();
        this.circuitBreakerService = circuitBreakerService;
     * {@link #addDocStatusStats(org.opensearch.index.shard.IndexingStats.Stats.DocStatusStats)} after
     */
                    return "[" + t.get().getClass().getName() + "]";
    ) throws IOException {
            if (deleteList == null) {
                .setSource(mapping.source().string(), MediaTypeRegistry.JSON)
                }
        CheckedFunction<IndexService, T, E> indexServiceConsumer
            this.tieredStoragePrefetchSettingsSupplier = () -> null;
                logger.warn(() -> new ParameterizedMessage("[{}] failed to delete index on disk", metadata.getIndex()), e);
                    }
        CircuitBreakerService circuitBreakerService,
     * IndexService instances that are created on this node.
        INDICES_CACHE_CLEANUP_INTERVAL_SETTING_KEY,
                        "[{}] failed to load state file from a stale deleted index, " + "folders will be left on disk",
                }
        }
        }
        for (Map.Entry<String, IndexService> entry : indices.entrySet()) {
     * @param indexSettings the shards index settings.
            null,
                    remoteStoreStatsTrackerFactory.getRemoteTranslogTransferTracker(shardRouting.shardId()),
            .addSettingsUpdateConsumer(CLUSTER_DEFAULT_INDEX_MAX_MERGE_AT_ONCE_SETTING, this::onDefaultMaxMergeAtOnceUpdate);
        if (danglingIndicesToWrite.add(index)) {
    /**
import org.opensearch.action.admin.indices.stats.SearchResponseStatusStats;
     * @param reason the reason for the shard deletion
     * or when the existing {@code index.merge.policy.max_merge_at_once} index setting is set as null.
                || (context.size() > maxSizeInRequestCache)) {
     * Cluster-level default for {@code index.pluggable.dataformat.enabled}.
    private void updateDanglingIndicesInfo(Index index) {
            Map<ShardId, ShardLock> locks = new HashMap<>();
        return new BaseQueryRewriteContext(
        };
import org.opensearch.core.xcontent.XContentParser;
    public <T, E extends Exception> T withTempIndexService(
    private final Supplier<IngestService> ingestServiceSupplier;
        false,
    private final Map<String, IngestionConsumerFactory> ingestionConsumerFactories;
                return parseInnerQueryBuilder(parser);
                "cluster minimum index refresh interval ["
import org.opensearch.search.internal.ShardSearchRequest;
    @Override
            }
            if (indexSettings.isRemoteTranslogStoreEnabled() && shardRouting.primary()) {
     * Query cache and field data cache keys are cleared immediately by this method; request cache keys are only marked for cleanup
import org.opensearch.index.MergeSchedulerConfig;
     * {@code parentTaskId}. Rewriting can issue real requests -- a terms lookup with a subquery runs a search -- and
     * @param newDefaultMaxMergeAtOnce the updated cluster default maxMergeAtOnce.
            repositoriesServiceSupplier,
                        if (indexService != null) {
     * Checks if changes (adding / removing) indices, shards and so on are allowed.
     * is set as ASYNC if enabled. If disabled, any of the durability mode can be used and switched at any later time from
                return null;
        }
        Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories,
            decoderFactory.validate(indexMetadata.getIngestionSource().getDecoderSettings());
    /**
        "cluster.remote_store.index.restrict.async-durability",
    /**
     */
                    for (SearchStatsContributor contributor : searchStatsContributors) {
        final FlushStats flushStats = new FlushStats();
     * This creates a new IndexService without registering it
        "cluster.pluggable.dataformat.enabled",
            checkpointPublisher,
            assert engineFactories.get(0).isPresent();
     * IndexService instances that are created on this node.
     * @return IndexMetadata for the index loaded from disk
    ) {
        );
        Property.NodeScope,
    /**
        BigArrays bigArrays,
            }
        @Override
                IndexService indexService = entry.getValue();
            public void onRemoval(ShardId shardId, String fieldName, boolean wasEvicted, long sizeInBytes) {
    /**
        // the cumulative statistics also account for shards that are no longer on this node, which is tracked by oldShardsStats
        this.nodeEnv = nodeEnv;
            }
            if (idxSettings.isRemoteSnapshot()) {
            }
        // Profiled queries should not use the cache
        );
                logger.warn(
    public static final Setting<Boolean> INDICES_ID_FIELD_DATA_ENABLED_SETTING = Setting.boolSetting(
            this.settings = settings;
        @Override
            getEngineConfigFactory(idxSettings),
    private EngineConfigFactory getEngineConfigFactory(final IndexSettings idxSettings) {
            IndexService indexService = entry.getValue();
        final SegmentReplicationCheckpointPublisher checkpointPublisher,
        }
        this.compositeDirectoryFactories = compositeDirectoryFactories;
        Property.Final
                    request.shardId(),
        if (indexMetadata.getIndexUUID().equals(IndexMetadata.INDEX_UUID_NA_VALUE)) {
        if (loadedFromCache[0]) {
import static org.opensearch.index.IndexService.IndexCreationContext.METADATA_VERIFICATION;
        };
            recoverySettings,
import org.opensearch.indices.pollingingest.IngestionPayloadDecoderRegistry;
            return Integer.compare(shardId, o.shardId);
            }
        }
        this.ingestionPayloadDecoderRegistry = ingestionPayloadDecoderRegistry;
            throw new IndexNotFoundException(index);
    /**
            throw new IllegalArgumentException("settings must not be null");
            targetNode,
            this.interval = interval;
            if (indexShard != null) {
            }
        PendingDelete(Index index, IndexSettings settings) {
                // is enabled in settings, use cluster setting to check the maximum size allowed in the cache
        }
                return new NRTReplicationEngineFactory();
import java.nio.file.Files;
     * The node's settings.
        this.nodeCacheService = nodeCacheService;
import org.opensearch.index.engine.EngineConfigFactory;
        }
     * Verify that the contents on disk for the given index is deleted; if not, delete the contents.
            }
     * This method verifies that the given {@code metadata} holds sane values to create an {@link IndexService}.
            loadedFromCache[0] = false;
    public AnalysisRegistry getAnalysis() {
import org.opensearch.index.shard.IndexShardState;
import org.opensearch.common.util.iterable.Iterables;
        "cluster.default.index.refresh_interval",
            list.add(pendingDelete);
        final RetentionLeaseSyncer retentionLeaseSyncer,
            commitStats = indexShard.commitStats();
        final ShardRouting shardRouting,
    ) throws Exception {
        }
    }
        final Index index,
            if (closed.get() == false) {
     * This comes handy when the user wants to set a default refresh interval across all indexes created in a cluster
        }
        NodeEnvironment nodeEnv,
            repositoriesService,
            final IndexSettings indexSettings = buildIndexSettings(metadata);
 * You may obtain a copy of the License at
            try {
        @Override
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
            }
     * This method will delete the metadata for the index even if the actual shards can't be locked.
    /**
        this.maxSizeInRequestCache = maxSizeInRequestCache;
                    String localUUid = indexService(index).indexUUID();
                idxSettings.getIndex(),
        return indices.values().iterator();
            return indexService;
                addPendingDelete(index, indexSettings);
     */
            client,
    private final Set<Index> danglingIndicesToWrite = Sets.newConcurrentHashSet();
                try {
        final Index index = indexMetadata.getIndex();
            indexModule.addSearchOperationListener(new TieredStorageSearchSlowLog(idxSettings));
    }
                "Setting [" + EngineConfig.INDEX_OPTIMIZE_AUTO_GENERATED_IDS.getKey() + "] was removed in version 7.0.0"
            namedWriteableRegistry,
                    "Query timed out, invalidating cache entry for request on shard [{}]:\n {}",
        IndexService indexService = indexService(shardRouting.index());
        this.valuesSourceRegistry = valuesSourceRegistry;
        MapperRegistry mapperRegistry,
                if (metadata == null) {
     * on the local node and the index isn't on a shared file system.
            if (numRemoved > 0) {
            }
                                    logger.debug(() -> new ParameterizedMessage("{} retry pending delete", shardLock.getShardId()), ex);
        }
        final RecoveryListener recoveryListener,
import org.opensearch.index.shard.IndexingStats;
            CREATE_INDEX,
             * By passing 512 as the expected size we will resize the byte array in the stream
        assert context.searcher().getIndexReader().getReaderCacheHelper() != null;
    }
         * Creates a new pending delete of a shard
            // this will also fail if some plugin fails etc. which is nice since we can verify that early
import org.opensearch.indices.recovery.RecoveryListener;
        public long ramBytesUsed() {
        }
        return new IndexShardStats(
    }
            searchRequestStats,
    }
     */
        this.indexNameExpressionResolver = indexNameExpressionResolver;
        // play safe here and make sure that we take node level settings into account.
        return fixedRefreshIntervalSchedulingEnabled;
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
     * while deletion still ongoing. * The reason is that, on Windows, browsing the directory contents can interfere
     * This setting is used to enable fixed interval scheduling capability for refresh tasks to ensure consistent intervals
    public boolean isMetadataField(String field) {
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
                case Get:
    public static final Setting<Boolean> CLUSTER_INDEX_RESTRICT_REPLICATION_TYPE_SETTING = Setting.boolSetting(
            compositeDirectoryFactories,
    public void addPendingDelete(ShardId shardId, IndexSettings settings) {
        // we ignore private settings since they are not registered settings
                );
import org.opensearch.index.flush.FlushStats;
        IndicesBitsetFilterCache indicesBitsetFilterCache,
    @Override
    private IngestionConsumerFactory getIngestionConsumerFactory(final IndexSettings idxSettings) {
        final IndexSettings indexSettings,
            payloadDecoderRegistry,
     * Clears the caches for the given shard id if the shard is still allocated on this node
     * are closed and all shard {@link CacheHelper#addClosedListener(org.apache.lucene.index.IndexReader.ClosedListener) closed
    private final ThreadPool threadPool;
    /**
            indicesFieldDataCache,
    ) throws IOException {
            return false;
     *
import org.apache.lucene.util.RamUsageEstimator;
    public IndicesFieldDataCache getIndicesFieldDataCache() {
            return true;
    public static final Setting<List<String>> CLUSTER_PLUGGABLE_DATAFORMAT_RESTRICT_ALLOWLIST = Setting.listSetting(
import org.opensearch.action.admin.indices.stats.IndexShardStats;
     */
     * @param clusterState {@code ClusterState} to ensure the index is not part of it
                );
     */
        Property.Final
        final DiscoveryNode sourceNode,
                        statsByShard.get(indexService.index()).add(indexShardStats);
    }
            final List<PendingDelete> remove;
    IndexShardStats indexShardStats(final IndicesService indicesService, final IndexShard indexShard, final CommonStatsFlags flags) {
                            );
import org.opensearch.search.internal.AliasFilter;
        CircuitBreakerService circuitBreakerService,
                } finally {
import org.opensearch.action.admin.indices.stats.StatusCounterStats;
    public void addPendingDelete(Index index, IndexSettings settings) {
                loader.accept(out);
        new ClusterDefaultRefreshIntervalValidator(),
    public enum ShardDeletionCheckResult {
import org.opensearch.indices.cluster.IndicesClusterStateService;
    public synchronized void verifyIndexMetadata(IndexMetadata metadata, IndexMetadata metadataUpdate) throws IOException {
    private final ValuesSourceRegistry valuesSourceRegistry;
        final IndexDeletionAllowedPredicate predicate
                    .xContent()
        /**
            long startTimeNS = System.nanoTime();
    private final Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories;
     * {@code index.pluggable.dataformat.enabled} and {@code index.pluggable.dataformat} settings.
import org.opensearch.index.engine.CommitStats;
            // across many entities
    }
            if (!ingestionConsumerFactories.containsKey(type)) {
                            + indexName
     * @param clusterDefaultRefreshInterval the updated cluster default refresh interval.
                try {
                    @Override
        }, this);
    );
            + index.getUUID();
        IndexShard indexShard = indexService.createShard(
        ThreadPool threadPool,
     * FieldDataCacheCleaner is a scheduled Runnable used to clean a Guava cache
    private BytesReference cacheShardLevelResult(
        );
        indexShard.startRecovery(recoveryState, recoveryTargetService, recoveryListener, repositoriesService, mapping -> {
                emptyList()
        }
            indicesQueryCache,
        );
        boolean success = false;
                if (nodeWriteDanglingIndicesInfo) {
            if (success == false) {
            retentionLeaseStats = null;
        final CountDownLatch latch = new CountDownLatch(indices.size());
import org.opensearch.index.search.stats.SearchStats;
                return FileSystemUtils.exists(nodeEnv.availableShardPaths(shardId))
        Property.NodeScope
    );
                    commonStats.search.add(oldShardsStats.searchStats);
     * Returns an IndexService for the specified index if exists otherwise returns <code>null</code>.
                threadPool.scheduleUnlessShuttingDown(interval, ThreadPool.Names.SAME, this);
     * <p>
     * the same cache.
import org.opensearch.index.compositeindex.CompositeIndexSettings;
    public CompositeIndexSettings getCompositeIndexSettings() {
            }
                        "Can't delete index store for ["
import org.opensearch.index.IndexNotFoundException;
        CommonStats commonStats = new CommonStats(flags);
import static org.opensearch.indices.IndicesRequestCache.INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING;
        final RefreshStats refreshStats = new RefreshStats();
        this.indicesBitsetFilterCache = new IndicesBitsetFilterCache(settings);
        final DiscoveryNodes discoveryNodes,
                circuitBreakerService.getBreaker(CircuitBreaker.FIELDDATA).addWithoutBreaking(-sizeInBytes);
                    }
                throw new IllegalArgumentException("No factory found for ingestion source type [" + type + "]");
     * @param indexMetadata          the index metadata to create the index for
            indicesBitsetFilterCache,
    );
                // we just warn about the exception here because if deleteIndexStoreIfDeletionAllowed
        NodeCacheService nodeCacheService,
    );
        this.bigArrays = bigArrays;
            listener.afterIndexRemoved(indexService.index(), indexSettings, reason);
            throw new IllegalStateException("Can't delete shard " + shardId + " (cause: " + shardDeletionCheckResult + ")");
                    indicesRefCount.decRef();
        assert shardId.getIndex().equals(indexSettings.getIndex());
     * Returns a new {@link QueryRewriteContext} with the given {@code now} provider
                    RemoteStoreNodeAttribute.getRemoteStoreTranslogRepo(indexSettings.getNodeSettings()),
    private volatile List<SearchStatsContributor> searchStatsContributors = Collections.emptyList();
 * ownership. Elasticsearch licenses this file to you under
     * defined in cluster.indices.replication.strategy by rejecting any request that specifies a replication type that
    @Deprecated(forRemoval = true)
                    final IndexShardStats indexShardStats = indicesService.indexShardStats(indicesService, indexShard, flags);
    );
    private volatile boolean fixedRefreshIntervalSchedulingEnabled;
    /**
        NodeEnvironment nodeEnv,
    private Integer getClusterDefaultMaxMergeAtOnce() {
                            + "the cluster state ["
            null,
        // streaming ingestion
            }
        final RecoveryStats recoveryStats = new RecoveryStats();
        AnalysisRegistry analysisRegistry,
    public CircuitBreakerService getCircuitBreakerService() {
     *
import org.opensearch.cluster.node.DiscoveryNodes;
     */
import org.opensearch.common.CheckedFunction;
        );
        final String nodeName = Objects.requireNonNull(Node.NODE_NAME_SETTING.get(settings));
            cachedQueryResult.writeToNoId(out);
    @Override
    }
        Property.Final
import org.opensearch.common.lease.Releasable;
            indicesFieldDataCache,
            validateRefreshIntervalSettings(minimumRefreshInterval, defaultRefreshInterval);
                );
    public AliasFilter buildAliasFilter(ClusterState state, String index, Set<String> resolvedExpressions) {
        }
    }
import org.opensearch.common.settings.Settings;
                    RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexSettings.getIndexMetadata())
            parentTaskId != null && parentTaskId.isSet() ? new ParentTaskAssigningClient(client, parentTaskId) : client,
                    // wrap the exception to indicate we already deleted the shard
            final QuerySearchResult result = context.queryResult();
     */
     * Package private for testing
     */
            // running a search that times out concurrently will likely timeout again if it's run while we have this `stale` result in the
        Property.Dynamic
        this.maxSizeInRequestCache = INDICES_REQUEST_CACHE_MAX_SIZE_ALLOWED_IN_CACHE_SETTING.get(clusterService.getSettings());
        if (shardId == null) {
    /**
        public int compareTo(PendingDelete o) {
        }
                } finally {
                        indicesRequestCache,
        this.indicesRequestCache = new IndicesRequestCache(settings, (shardId -> {
import org.opensearch.index.fielddata.IndexFieldDataCache;
    implements
    private final RemoteStoreSettings remoteStoreSettings;
     * @param index {@code Index} to make sure its deleted from disk
        );
        // this method should only be called when we know the index (name + uuid) is not part of the cluster state
     * Accumulate stats from the passed Object
        if (hasIndex(index)) {
import org.opensearch.index.translog.TranslogFactory;
                    () -> new ParameterizedMessage("[{}] failed to delete unassigned index (reason [{}])", metadata.getIndex(), reason),
    /**
    ) {
        PluginsService pluginsService,
    public void processPendingDeletes(Index index, IndexSettings indexSettings, TimeValue timeout) throws IOException, InterruptedException,
                logger.trace(
        ShardDeletionCheckResult shardDeletionCheckResult = canDeleteShardContent(shardId, indexSettings);
     * @return true if the index can be deleted on this node
            remoteStoreStatsTrackerFactory,
    private final IndexScopedSettings indexScopedSettings;
     * @param indexSettings the shards's relevant {@link IndexSettings}. This is required to access the indexes settings etc.
    private final Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories;
            final List<Setting<?>> settings = List.of(CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING);
                indicesQueryCache,
        // Currently, we cannot cache stream search results as we never compute and reduce full resultset per
            // multiple requests that wait for the cache entry to be calculated they'd fail all with the same exception.
                    return;
        CacheService cacheService,
        ShardLockObtainFailedException {
            return indexShard.requestCache();
    private void onDefaultMaxMergeAtOnceUpdate(int newDefaultMaxMergeAtOnce) {
                        continue;
    private final MetaStateService metaStateService;
import org.opensearch.index.cache.request.ShardRequestCache;
                            }
     * that does not match. If disabled, users may choose the pluggable data-format on a per-index basis using the
        this.indicesQueryCache = new IndicesQueryCache(settings, clusterService.getClusterSettings());
    protected void doClose() throws IOException {
            // Write relevant info for cache tier policies before the whole QuerySearchResult, so we don't have to read
                    break;
     * also a supplier to all IndexService that have been created on the node. We also notify the change to all
        @Override
    }
        final Set<Index> indices = this.indices.values().stream().map(s -> s.index()).collect(Collectors.toSet());
        @Override
        for (final Index index : indices) {
     */
import java.util.concurrent.Executors;
            } else if (indexSettings.hasCustomDataPath()) {
            @Override
                                index,
    }
                    threadPool,
     *
            this::isShardLevelRefreshEnabled,
        Property.Dynamic
     * @param shardId the shards ID to delete
                assert remainingUncompletedDeletes >= 0;
    public boolean isIdFieldDataEnabled() {
            return settings.iterator();
                    request.source()
 */
        "cluster.pluggable.dataformat.restrict.allowlist",
        ClusterService clusterService,
            getIndexerFactory(idxSettings),
        boolean apply(Index index, IndexSettings indexSettings);
            listener.beforeIndexRemoved(indexService, reason);
import org.opensearch.index.IndexSettings;
     * This setting is used to set the minimum refresh interval applicable for all indexes in a cluster. The
        NamedWriteableRegistry namedWriteableRegistry,
     * @param index the index to process the pending deletes for
            }
        final Consumer<IndexShard.ShardFailure> onShardFailure,
 *
    }
import org.apache.logging.log4j.message.ParameterizedMessage;
                return false;
                    removeIndex(index, IndexRemovalReason.NO_LONGER_ASSIGNED, "shutdown");
            return engineFactories.get(0).get();
                    break;
        return new BaseQueryRewriteContext(xContentRegistry, namedWriteableRegistry, client, nowInMillis, validate);
import org.opensearch.index.engine.NoOpEngine;
            return new IngestionEngineFactory(ingestionConsumerFactory, ingestServiceSupplier, decoderFactory);
        final ShardRouting shardRouting,
    @Override
            dataFormatAwareStoreDirectoryFactories
        if (shardDeletionCheckResult != ShardDeletionCheckResult.FOLDER_FOUND_CAN_DELETE) {
                } else {
                                TimeValue.timeValueMillis(Math.min(0L, completedTimeMillis - executedTimeMillis))
import java.util.Collection;
        }
        // Copy indices because we modify it asynchronously in the body of the loop
import org.opensearch.common.util.io.IOUtils;
            cacheService,
        return statusCounterStats.getSearchResponseStatusStats();
            }
            }
    public QueryRewriteContext getValidationRewriteContext(LongSupplier nowInMillis) {
            final boolean isAllocated = indexService != null && indexService.hasShard(shardId.id());
            if (predicate.apply(index, indexSettings)) {
     */
                .preparePutMapping()
            closed.compareAndSet(false, true);
import org.opensearch.search.query.QuerySearchResult;
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
    /**
        ensureChangesAllowed();
            remoteStoreStatsTrackerFactory,
        this.idFieldDataEnabled = INDICES_ID_FIELD_DATA_ENABLED_SETTING.get(clusterService.getSettings());
/**
            // we are trying to delete the index store here - not a big deal if the lock can't be obtained
    public synchronized IndexService createIndex(
            .collect(Collectors.toList());
     * as low as the {@code cluster.minimum.index.refresh_interval}.
            settings,
         * Creates a new pending delete of an index
    /**
        final SearchStats searchStats = new SearchStats();
import org.opensearch.plugins.IndexStorePlugin;
        }
                        logger.warn(() -> new ParameterizedMessage("failed to write dangling indices state for index {}", index), e);
 * software distributed under the License is distributed on an
import org.opensearch.indices.mapper.MapperRegistry;
     */
        }
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
                    if (remove.isEmpty() == false) {
                            logger.trace(
                            );
        }
        synchronized (pendingDeletes) {
        ScriptService scriptService,
            logger.info("refresh tasks rescheduled oldVal={} newVal={}", prevShardLevelRefreshVal, newShardLevelRefreshVal);
    private static final Logger logger = LogManager.getLogger(IndicesService.class);
                } catch (Exception e) {
        return nodeWriteDanglingIndicesInfo == false
    /**
            } else if (RemoteStoreNodeAttribute.isTranslogRepoConfigured(settings) && shardRouting.primary()) {
            CachedQueryResult cachedQueryResult = new CachedQueryResult(context.queryResult(), System.nanoTime() - beforeQueryPhase);
                            + "] ["
    }
            shardRouting,
        final IndexingStats indexingStats = new IndexingStats();
                    repositoriesServiceSupplier,
        final IndexService indexService = indexService(shardId.getIndex());
        final GetStats getStats = new GetStats();
        // doClose() is called when shutting down a node, yet there might still be ongoing requests
                }
            settings,
    /**
     * filesystem a replica might not have been closed when the primary is deleted causing problems on delete calls so we
import org.opensearch.gateway.MetaStateService;
            // we should in the future rather write a tombstone rather than wiping the metadata.
            threadPool,
            if (nodeEnv.findAllShardIds(shardId.getIndex()).isEmpty()) {
            try (BytesStreamOutput out = new BytesStreamOutput(expectedSizeInBytes)) {
    private synchronized IndexService createIndexService(
        final Index index;
                // the memory properly paged instead of having varied sized bytes
 * this file be licensed under the Apache-2.0 license or a
        "cluster.pluggable.dataformat",
     * @opensearch.internal
                do {
            onShardFailure,
     * Version 3.4.0
    public static final String CLUSTER_SETTING_REPLICATION_TYPE = "cluster.indices.replication.strategy";
     * Returns <code>ShardDeletionCheckResult</code> signaling whether the shards content for the given shard can be deleted.
        return context.searcher().getDirectoryReader().getReaderCacheHelper() instanceof DelegatingCacheHelper;
            repositoriesServiceSupplier,
        ReplicationType::parseString,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.apache.lucene.util.CollectionUtil;
    public RemoteStoreSettings getRemoteStoreSettings() {
import org.opensearch.core.common.unit.ByteSizeValue;
                return Optional.empty();
            remoteStoreSettings,
    /**
            directoryFactories,
            );
     * @opensearch.internal
     * listeners} have run. However some {@link IndexEventListener#onStoreClosed(ShardId) shard closed listeners} might not have
    int numPendingDeletes(Index index) {
                indexService.onRefreshLevelChange(newShardLevelRefreshVal);
     * The changes to dynamic cluster setting {@code cluster.merge.scheduler.max_force_merge_mb_per_sec} needs to be updated. This
        "gateway.write_dangling_indices_info",
     * or written to after invalidation.
            indexMetadata.getIndex(),
            if (logger.isTraceEnabled()) {
import java.util.function.Predicate;
    /**
 * SPDX-License-Identifier: Apache-2.0
    }
            }
        }
            indexingMemoryController
    private volatile Map<String, IndexService> indices = emptyMap();
     */
import org.opensearch.index.engine.exec.IndexerFactory;
            return deleteList.size();
            mergedSegmentWarmerFactory,
                    }
     *
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
            final IndexService service = createIndexService(
    public static final Setting<Boolean> CLUSTER_RESTRICT_PLUGGABLE_DATAFORMAT_SETTING = Setting.boolSetting(
     */
        }
    /**
                );
            logger.debug("{} deleting index store reason [{}]", index, reason);
                    }
    private void onRefreshIntervalUpdate(TimeValue clusterDefaultRefreshInterval) {
                MergeSchedulerConfig.CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING,
     */
            final TimeValue defaultRefreshInterval = (TimeValue) settings.get(CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING);
            () -> allowExpensiveQueries,
        }
 * GitHub history for details.
    /**
        );
                    assert t.isPresent();
                return config -> new ReadOnlyEngine(config, new SeqNoStats(0, 0, 0), new TranslogStats(), true, Function.identity(), false);
        } finally {
    ) throws IOException {
            namedWriteableRegistry,
            // NoOpEngine takes precedence as long as the index is closed
    }
import org.opensearch.search.query.QueryPhase;
        TimeValue.ZERO,
        DEFAULT_MAX_MERGE_AT_ONCE,
    @InternalApi
        PendingDelete pendingDelete = new PendingDelete(index, settings);
    }
        }
        public String toString() {
import org.opensearch.index.query.QueryRewriteContext;
        }
    }
        return indexModule.newIndexMapperService(xContentRegistry, mapperRegistry, scriptService, dataFormatRegistry);
        IndexShard shard,
        new ClusterMinimumRefreshIntervalValidator(),
     * provided during index creation or when the existing {@code index.refresh_interval} index setting is set as null.
            remoteDirectoryFactory,
    private final NodeCacheService nodeCacheService;
            // No need to take the IndexShard into account since it is shared
 * not use this file except in compliance with the License.
     * An item in the index shard cache
import org.opensearch.plugins.SearchStatsContributor;
     *
            final boolean clearedAtLeastOne = service.clearCaches(queryCache, fieldDataCache, fields);
        final IndexService indexService = createIndexService(
            if (remove != null && remove.isEmpty() == false) {
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
        indexScopedSettings.validate(indexMetadata.getSettings(), true, true, true);
        }
    }
     */
                // lets see if it's path is available (return false if the shared doesn't exist)
        if (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG)) {
     */
    /**
        List<IndexEventListener> finalListeners = Collections.singletonList(
        final Consumer<ShardId> globalCheckpointSyncer,
    public static final Setting<TimeValue> CLUSTER_MINIMUM_INDEX_REFRESH_INTERVAL_SETTING = Setting.timeSetting(
                // its safe to delete all index metadata and shard data
    // Visible for testing
        this.recoverySettings = recoverySettings;
    /**
                                TimeValue.timeValueMillis(Math.min(0L, executedTimeMillis - triggeredTimeMillis))
            translogFactorySupplier,
    private final MapperRegistry mapperRegistry;
            CachedQueryResult.loadQSR(bytesReference, result, context.id(), namedWriteableRegistry);
                    break;
        return getRewriteContext(nowInMillis, false);
            );
        }
    private final OldShardsStats oldShardsStats = new OldShardsStats();
    private final IndicesBitsetFilterCache indicesBitsetFilterCache;
                    break;
        this.scriptService = scriptService;
            }
     */
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        for (Flag flag : flags.getFlags()) {
        IndexMetadata indexMetadata = state.metadata().index(index);
    private TimeValue getClusterDefaultRefreshInterval() {
    private void deleteIndexStore(String reason, Index index, IndexSettings indexSettings) throws IOException {
    private IndexerFactory getIndexerFactory(final IndexSettings idxSettings) {
    public IndicesService(
        IndexScopedSettings indexScopedSettings,
        this.cacheCleaner = new CacheCleaner(indicesFieldDataCache, logger, threadPool, this.cleanInterval);
     * Sets the list of search stats contributors. Called by {@code Node} after plugin discovery.
            } catch (Exception e) {
     */
import org.opensearch.index.shard.IllegalIndexShardStateException;
    private static final class ClusterMinimumRefreshIntervalValidator implements Setting.Validator<TimeValue> {
                indices = unmodifiableMap(newIndices);
                indexService = newIndices.remove(index.getUUID());
        indicesRequestCache.forceCleanCache();
            if (success == false) {
     * This setting is used to restrict creation or updation of index where the `index.translog.durability` index setting
            client.admin()
     * Accumulate stats from the passed Object. Use this instead of
            idxSettings,
     * This setting is used to set the maxMergeAtOnce parameter for {@code TieredMergePolicy}
                    + defaultRefreshInterval
    }
            () -> Iterables.flatten(this).iterator()
            this.deleteIndex = false;
    }
     * does not match the cluster setting. If disabled, a user can choose a replication type on a per-index basis using
     */
            IndexService indexService = entry.getValue();
    }
                1,
            try {
                    updateDanglingIndicesInfo(index);
            ) {
 *
            checkpointPublisher,
                Locale.ROOT,
import org.opensearch.transport.client.Client;
    }
     * Checks if all pending deletes have completed. Used by tests to ensure we don't check directory contents
        final IndexSettings settings;
            }
            throw new IllegalStateException("Cannot delete index [" + index + "], it is still part of the cluster state.");
import org.opensearch.search.internal.SearchContext;
                        indexingMemoryController,
    }
     */
    }
                        indicesQueryCache,
        NO_FOLDER_FOUND, // the shards data locations do not exist
            });
        // Start thread that will manage cleaning the field data cache periodically
     * <p>In case multiple plugins register a field filter through
        Supplier<RepositoriesService> repositoriesServiceSupplier,
import org.opensearch.index.query.BaseQueryRewriteContext;
    public static final Setting<Boolean> CLUSTER_REFRESH_FIXED_INTERVAL_SCHEDULE_ENABLED_SETTING = Setting.boolSetting(
    }
                public void onStoreCreated(ShardId shardId) {
        public void validate(TimeValue value) {
    /**
    private QueryRewriteContext getRewriteContext(LongSupplier nowInMillis, boolean validate) {
     */
    @InternalApi
    @Override
            threadPool,
        CheckedFunction<BytesReference, QueryBuilder, IOException> filterParser = bytes -> {
     * Deletes the index store trying to acquire all shards locks for this index.
    /**
                logger.warn("Not all shards are closed yet, waited {}sec - stopping service", shardsClosedTimeout.seconds());
 * Unless required by applicable law or agreed to in writing,
            mergedSegmentWarmerFactory,
import org.opensearch.index.engine.InternalEngineFactory;
import org.opensearch.common.annotation.InternalApi;
            .addSettingsUpdateConsumer(
     *
                        analysisRegistry,
    @Nullable
            indexingMemoryController
                    deleteIndexStore("no longer used", metadata);
                logger.warn(
     * {@code cluster.pluggable.dataformat} by rejecting any request that specifies an index-level value
        this.clusterService = clusterService;
import org.opensearch.transport.client.ParentTaskAssigningClient;
        FOLDER_FOUND_CAN_DELETE, // shard data exists and can be deleted
            switch (flag) {
import org.opensearch.common.io.stream.BytesStreamOutput;
     * A pending delete
                    assert false : "temp index should not trigger shard creation";
                return new RemoteBlobStoreInternalTranslogFactory(
        // if not explicitly set in the request, use the index setting, if not, use the request
    }
import org.opensearch.core.tasks.TaskId;
                0,
     * Adds a pending delete for the given index shard.
     *
import org.opensearch.index.seqno.RetentionLeaseStats;
     * The created {@link IndexService} will not be registered and will be closed immediately.
            return;
                    : ShardDeletionCheckResult.NO_FOLDER_FOUND;
        );
        }
        statusCounterStats.getDocStatusStats().add(stats);
        NamedXContentRegistry xContentRegistry,
        return shardLevelRefreshEnabled;
    }
                    TimeValue.nsecToMSec(System.nanoTime() - startTimeNS)
import org.opensearch.index.seqno.SeqNoStats;
import org.opensearch.core.xcontent.NamedXContentRegistry;
    @Override
                            } catch (IOException ex) {
                this.cache.clear();
        }
        clusterService.getClusterSettings()
    public static final Setting<String> CLUSTER_PLUGGABLE_DATAFORMAT_VALUE_SETTING = Setting.simpleString(
                logger.warn("Exception during periodic field data cache cleanup:", e);
    private final Map<String, org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories;
        private static final long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(IndexShardCacheEntity.class);
    public void addDocStatusStats(final org.opensearch.index.shard.IndexingStats.Stats.DocStatusStats stats) {
            sourceNode,
        assert canCache(request, context);
            + indexService.indexUUID()
         */
            } catch (Exception e) {
     * @param reader a reader for this shard. Used to invalidate the cache when there are changes.
                    .build() }
            indexNameExpressionResolver,
import org.opensearch.env.ShardLockObtainFailedException;
        try {
            sourceNode,
    }
                } while ((System.nanoTime() - startTimeNS) < timeout.nanos());
     * Validates that the cluster minimum refresh interval is not more than the cluster default refresh interval.
                try {
    }
                    .createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, inputStream)
                        }
            this.index = index;
        Property.Dynamic
                    e
        }
     */
        Property.Dynamic,
        final DiscoveryNode sourceNode,
        clusterService.getClusterSettings()
    }
import org.opensearch.threadpool.ThreadPool;
            if (logger.isTraceEnabled()) {
        }
                        SearchStats contributed = contributor.contributeSearchStats();
            Collections.emptyMap(),
            scriptService,
        }
    public IndexService indexServiceSafe(Index index) {
    }
    /**
        } finally {
        BytesReference bytesReference = cacheShardLevelResult(context.indexShard(), directoryReader, request.cacheKey(), out -> {
        synchronized (pendingDeletes) {
        if (service != null) {
                indicesRefCount.incRef();
             * BigArrays.PAGE_SIZE_IN_BYTES which is 16k. A common cached result ie.
        return analysisRegistry;
        final Consumer<ShardId> globalCheckpointSyncer,
import org.opensearch.plugins.PluginsService;
                            final long completedTimeMillis = threadPool.relativeTimeInMillis();
        private final ThreadPool threadPool;
            final int expectedSizeInBytes = 512;
        }, clusterService, threadPool);
        this.clusterDefaultRefreshInterval = CLUSTER_DEFAULT_INDEX_REFRESH_INTERVAL_SETTING.get(clusterService.getSettings());
            this.shardLevelRefreshEnabled = newShardLevelRefreshVal;
import org.opensearch.common.util.FeatureFlags;
        } else {
                if (hasIndex(index)) {
     */
import org.opensearch.cluster.metadata.IndexMetadata;
 *    http://www.apache.org/licenses/LICENSE-2.0
     * method gets called whenever the setting changes. We notify the change to all IndexService instances that are created on this node
        NamedXContentRegistry xContentRegistry,
    private volatile boolean allowExpensiveQueries;
                getStats.addTotals(indexShard.getStats());
                return out.bytes();
            String indexName = metadata.getIndex().getName();
import org.opensearch.index.shard.IndexEventListener;
        List<IndexEventListener> builtInListeners,
                        }
            this.tieredStoragePrefetchSettingsSupplier = () -> prefetchSettings;
        final Index index = indexMetadata.getIndex();
            }
     * Cache something calculated at the shard level.
            );
                    throw new UncheckedIOException(e);
     * Wait for this {@link IndicesService} to be effectively closed. When this returns {@code true}, all shards and shard stores
    private final AtomicInteger numUncompletedDeletes = new AtomicInteger();
    /**
            result.setSearchShardTarget(context.shardTarget());
    public synchronized MapperService createIndexMapperService(IndexMetadata indexMetadata) throws IOException {
        return null;
        IndexingOperationListener... indexingOperationListeners
        this.directoryFactories = directoryFactories;
            bigArrays,
        return this.compositeIndexSettings;
            synchronized (pendingDeletes) {
        }
    private final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;
            assert recoveryState.getRecoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS
        // ref count which will only close them when both this service and all index services are
            clusterService,
        "cluster.index.refresh.shard_level.enabled",
        Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories,
            return new EngineBackedIndexerFactory(getEngineFactory(idxSettings));
        );
    /**
        }
        // Add tiered storage search listeners
                    if (statsByShard.containsKey(indexService.index()) == false) {
        pluginsService.onIndexModule(indexModule);
                            indexService.writeDanglingIndicesInfo();
                public void beforeIndexShardCreated(ShardId shardId, Settings indexSettings) {
        final RepositoriesService repositoriesService,
     * @param index {@code Index} to check whether deletion is allowed
        List<IndexEventListener> finalListeners = new ArrayList<>(builtInListeners);
        this.clusterMergeSchedulerConfig = new ClusterMergeSchedulerConfig(this);
import java.util.ArrayList;
            queryPhase.execute(context);
            } else {
            return false;
            NodeIndicesStats.StatsLevel statsLevel = NodeIndicesStats.getAcceptedLevel(flags.getLevels());
            )
     *
    /**
     * so they can update their merge schedulers accordingly.
            indexScopedSettings,
            logger.trace("dangling indices update already pending for {}", index);
            directoryFactories,
import org.opensearch.core.common.bytes.BytesReference;
    /**
    }
     * creation will fail if the index setting {@code index.refresh_interval} is supplied with a value lower than the
    /**
        }
        indicesRefCount = new AbstractRefCounted("indices") {
    public Function<String, Predicate<String>> getFieldFilter() {
    }
                        Thread.sleep(sleepTime);
import org.opensearch.core.index.shard.ShardId;
     * but does not deal with in-memory structures. For those call {@link #removeIndex(Index, IndexRemovalReason, String)}
        Collection<Function<IndexSettings, Optional<EngineFactory>>> engineFactoryProviders,
        /**
            dataFormatRegistry.getDocumentLookupProvider(),
        }
    private void onRefreshLevelChange(Boolean newShardLevelRefreshVal) {
    /**
import org.opensearch.action.search.SearchRequestStats;
            try {
        TimeValue.ZERO,
                            logger.trace("omit writing dangling indices state for index {} as index is deallocated on this node", index);
     */
    private final CountDownLatch closeLatch = new CountDownLatch(1);
                    throw new IllegalStateException(
            indexNameExpressionResolver,
        this.shardsClosedTimeout = settings.getAsTime(INDICES_SHARDS_CLOSED_TIMEOUT, new TimeValue(1, TimeUnit.DAYS));
        RemoteStoreSettings remoteStoreSettings
    private void setIdFieldDataEnabled(boolean value) {
        logger.debug(
        public Iterator<Setting<?>> settings() {
        if (context.isStreamSearch()) {
        if (clusterState.metadata().index(index) != null) {
     * also a supplier to all IndexService that have been created on the node. We also notify the change to all
        return false;
        Property.Dynamic
        }
            throw new IllegalStateException("Can't make changes to indices service, node is closed");
 */
            // the store metadata gets wiped anyway even without the lock this is just best effort since
            return new InternalEngineFactory();
    }
import org.opensearch.ingest.IngestService;
                refreshStats.addTotals(indexShard.refreshStats());
        if (idxSettings.isPluggableDataFormatEnabled()) {
        RemoteStoreSettings remoteStoreSettings,
            discoveryNodes,
     * is prevented by {@link #canDeleteShardContent(ShardId, IndexSettings)}
        if (minimumRefreshInterval.compareTo(defaultRefreshInterval) > 0) {
        this.namedWriteableRegistry = namedWriteableRegistry;
            IndexService indexService = entry.getValue();
        false,
     * The changes to dynamic cluster setting {@code cluster.default.index.max_merge_at_once} needs to be updated. This
     * cluster-level defaults defined in {@code cluster.pluggable.dataformat.enabled} and
import java.util.Set;
    /**
                numRemoved = remove.size();
                    + "]";
    public boolean hasUncompletedPendingDeletes() {
        Client client,
     * {@link org.opensearch.plugins.MapperPlugin#getFieldFilter()}, only fields that match all registered filters are returned by get
import org.opensearch.action.search.SearchType;
            if (latch.await(shardsClosedTimeout.seconds(), TimeUnit.SECONDS) == false) {
                    }
            indicesBitsetFilterCache,
        return createShard(
                            } else {
    /**
                        }
            Collections.emptyMap(),
        public Object getCacheIdentity() {
        try {
    }
            indicesQueryCache,
            throw new ResourceAlreadyExistsException(index);
            return ShardDeletionCheckResult.NO_LOCAL_STORAGE;
                                "writing out dangling indices state for index {}, triggered {} ago",
        final IndexMetadata indexMetadata = idxSettings.getIndexMetadata();
     *
    );
                            try {
                logger.trace("running periodic field data cache cleanup");
            indicesStopExecutor.shutdown();
                    );
    }
import org.opensearch.indices.replication.common.ReplicationType;
        private final TimeValue interval;
    }
     * @param shardId the shard to delete.
     *
                            + "]"
        if (indexService == null && nodeEnv.hasNodeFile()) {
            // double check that shard is not created.
import java.util.function.Function;
import org.opensearch.ResourceAlreadyExistsException;
    }
    );
                    throw new IllegalStateException(
        ValuesSourceRegistry valuesSourceRegistry,
                flushStats.addTotals(indexShard.flushStats());
                    indicesQueryCache.onClose(shardId);
    public ClusterService clusterService() {
    /**
        }
                long sleepTime = 10;
                if (clusterState.metadata().hasIndex(indexName)) {
    }
            logger.warn(() -> new ParameterizedMessage("{} failed to delete index", index), ex);
            clusterMergeSchedulerConfig,
            recoveryStateFactories,
    private final CompositeIndexSettings compositeIndexSettings;
     */
                    break;
import org.opensearch.index.recovery.RecoveryStats;
        finalListeners.add(oldShardsStats);
    }
        protected ShardRequestCache stats() {
import static org.opensearch.index.IndexService.IndexCreationContext.CREATE_INDEX;
            throw new IllegalArgumentException("shardId must not be null");
                assert danglingIndicesThreadPoolExecutor.isShutdown();
    private final IndexStorePlugin.DirectoryFactory remoteDirectoryFactory;
        final long startTimeNS = System.nanoTime();
            long beforeQueryPhase = System.nanoTime();
import org.opensearch.index.translog.InternalTranslogFactory;
                this::setFixedRefreshIntervalSchedulingEnabled
        final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
                });
import org.opensearch.cluster.node.DiscoveryNode;
     * Returns a function that, given a concrete index name, returns a predicate that determines field visibility. Consumers include
                .get();
     * @throws IllegalStateException if no changes allowed.
        ClusterService clusterService,
        Property.NodeScope,
    protected void doStop() {
        // (because an other shard was updated) you would get wrong results because of the scores
            protected void closeInternal() {
     * @param defaultRefreshInterval value of cluster default index refresh interval setting
        @Nullable RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory,
        );
     */
                        } else {
import java.io.IOException;
            // ignore
                @Override
import org.opensearch.index.seqno.RetentionLeaseSyncer;
