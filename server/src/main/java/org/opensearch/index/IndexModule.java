import org.opensearch.threadpool.ThreadPool;
     *  This only works with the mmap directory, and even in that case is still
            factory = compositeDirectoryFactories.get(compositeStoreType);
            clusterDefaultMaxMergeAtOnceSupplier,
    private final IndexNameExpressionResolver expressionResolver;
    IndexEventListener freeze() { // pkg private for testing
        }
            environment,
                clusterDefaultRefreshIntervalSupplier,
            indicesFieldDataCache,
        final NodeCacheService nodeCacheService,
                BiFunction<IndexSettings, IndicesQueryCache, QueryCache> queryCacheProvider = forceQueryCacheProvider.get();
import java.util.function.BiFunction;
     * listeners go out of scope.
    }
    /**
        BigArrays bigArrays,
            };
        QueryCache queryCache = null;
    IndexerFactory getIndexerFactory() {
            ShardPath,
    );
        }
    /**
        NamedXContentRegistry xContentRegistry,
    }
    public enum TieringState {
            mapperRegistry,
        BigArrays bigArrays,
    /**
        "index.queries.cache.enabled",
            }
        "index.recovery.type",
                queryCache,
import java.util.HashMap;
            recoveryStateFactories,
            remoteStoreSettings,
        this.indexEventListeners.add(listener);
            }
            (DataFormatRegistry) null
        "",
            clusterDefaultMaxMergeAtOnceSupplier,
     * @see #INDEX_QUERY_CACHE_ENABLED_SETTING
            if (Type.containsSettingsKey(storeType)) {
        this.searchOperationListeners.add(new SearchSlowLog(indexSettings));
        );
    public static Type defaultStoreType(final boolean allowMmap) {
     */
                shardLevelRefreshEnabled.get(),
        "index.store.factory",
        NamedWriteableRegistry namedWriteableRegistry,
        final DataFormatAwareStoreDirectoryFactory dataFormatAwareStoreDirectoryFactory = getDataFormatAwareStoreDirectoryFactory(
            indicesQueryCache,
                    Store.OnClose onClose,
        return new IndexStorePlugin.DirectoryFactory() {
                segmentReplicationStatsProvider,
        DataLocalityType::getValueOf,
            },
        Client client,
     * relocated to another node the internal representation will be destroyed which includes the registered listeners.
            idFieldDataEnabled,
                indexSettings,
        }
import org.apache.lucene.index.LeafReader;
 *
import org.opensearch.script.ScriptService;
            success = true;
            return Type.NIOFS;
     * Note: an index might be created on a node multiple times. For instance if the last shard from an index is
                scriptService,
/*
import org.opensearch.index.store.Store;
            fixedRefreshIntervalSchedulingEnabled,
import org.opensearch.index.shard.SearchOperationListener;
        RecoverySettings recoverySettings,
    public static final Setting<String> INDEX_TIERING_STATE = new Setting<>(
        if (factory == null) {
 * Licensed to Elasticsearch under one or more contributor
        IndicesQueryCache indicesQueryCache,
        final CompositeIndexSettings compositeIndexSettings,
        BigArrays bigArrays,
    );
import org.opensearch.index.cache.query.DisabledQueryCache;
        Supplier<Boolean> shardLevelRefreshEnabled,
import org.opensearch.common.CheckedFunction;
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(IndexModule.class);
        final IndexNameExpressionResolver expressionResolver,
import org.opensearch.index.analysis.IndexAnalyzers;
        "default",
        }
        }
     * Forces a certain query cache to use instead of the default one. If this is set
        final IndexSettings indexSettings,
        IndicesFieldDataCache indicesFieldDataCache,
import org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory;
            clusterService,
 * </ul>
import java.util.Objects;
         * Convenience method to check whether the given {@link Settings}
            "dvm",
        HOT,
    public <T> void addSettingsUpdateConsumer(Setting<T> setting, Consumer<T> consumer, Consumer<T> validator) {
                throw new IllegalArgumentException("Unknown store type [" + storeType + "]");
     * NOTE: this method can only be called once per index. Multiple wrappers are not supported.
        if (this.frozen.compareAndSet(false, true)) {
        NamedXContentRegistry xContentRegistry,
            throw new IllegalArgumentException("Unknown recovery type [" + recoveryType + "]");
        final IndexSettings indexSettings,
        static boolean containsSettingsKey(String key) {
        if (dataFormatAwareStoreDirectoryFactories.isEmpty()) {
 *      {@link #addIndexEventListener(IndexEventListener)}</li>
        IndicesFieldDataCache indicesFieldDataCache,
                remoteDirectoryFactory,
import org.opensearch.core.xcontent.NamedXContentRegistry;
    /**
            scriptService,
    }
        Function<IndexService, CheckedFunction<DirectoryReader, DirectoryReader, IOException>> readerWrapperFactory = indexReaderWrapper
 * under the License.
        "index.store.preload",
        WARM,
    public IndexService newIndexService(
     * The function takes as parameters:<ul>
        this.searchOperationListeners.add(listener);
        IndexStorePlugin.RecoveryStateFactory factory = recoveryStateFactories.get(recoveryType);
        FS("fs"),
    /**
     * </p>
            () -> {
        private final String settingsKey;
            shardStoreDeleter,
        }
        NamedXContentRegistry xContentRegistry,
import org.opensearch.common.util.BigArrays;
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
    public static final Setting<Boolean> NODE_STORE_ALLOW_MMAP = Setting.boolSetting("node.store.allow_mmap", true, Property.NodeScope);
            null,
    public MapperService newIndexMapperService(
    public IndexService newIndexService(
import org.opensearch.index.mapper.MapperService;
        return factory;
        CircuitBreakerService circuitBreakerService,
        static {
    ) {
            if (type == null) {
    @Deprecated(forRemoval = true)
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier
            IOException> dataFormatAwareEngineFactorySupplier
     *  best-effort only. */
        Consumer<IndexShard> replicator,
            replicator,
    ) throws IOException {
     * are maintained for the entire index lifecycle on this node. Once an index is closed or deleted these
    @Deprecated(forRemoval = true)
                indexOperationListeners,
    public static final String SIMILARITY_SETTINGS_PREFIX = "index.similarity";
    /**
     * Adds an {@link IndexingOperationListener} for this index. All listeners added here
    private final NodeCacheService nodeCacheService;
import org.opensearch.Version;
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig,
            return new IndexStorePlugin.StoreFactory() {
                return type;
        BooleanSupplier idFieldDataEnabled,
        }
            public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {
        ClusterService clusterService,
                client,
            );
        final AnalysisRegistry analysisRegistry,
        for (Type type : Type.values()) {
        Supplier<Boolean> shardLevelRefreshEnabled,
    /**
     * Note: an index might be created on a node multiple times. For instance if the last shard from an index is
            environment,
        Function.identity(),
     * relocated to another node the internal representation will be destroyed which includes the registered listeners.
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.store.FsDirectoryFactory;
import org.opensearch.common.settings.Setting.Property;
        if (listener == null) {
    ) {
        IndicesQueryCache indicesQueryCache,
        final String compositeStoreType = indexSettings.getValue(INDEX_COMPOSITE_STORE_TYPE_SETTING);
        }
    /**
        RecoverySettings recoverySettings,
     * Adds an {@link SearchOperationListener} for this index. All listeners added here
        ValuesSourceRegistry valuesSourceRegistry,
                        type.getSettingsKey(),
        ClusterService clusterService,
            indicesFieldDataCache,
        this.compositeDirectoryFactories = Collections.unmodifiableMap(compositeDirectoryFactories);
                types.put(type.settingsKey, type);
    );
            return Type.HYBRIDFS;
    public IndexService newIndexService(
            idFieldDataEnabled,
import org.opensearch.common.annotation.InternalApi;
     * @deprecated Use the overload that accepts a {@code compositeEngineFactorySupplier} parameter.
    }
        public boolean isDeprecated() {
        final String recoveryType = indexSettings.getValue(INDEX_RECOVERY_TYPE_SETTING);
    }
import org.opensearch.common.annotation.ExperimentalApi;
            threadPool,
        final IndexStorePlugin.RecoveryStateFactory recoveryStateFactory = getRecoveryStateFactory(indexSettings, recoveryStateFactories);
        Type(final String settingsKey, final boolean deprecated) {
        NamedWriteableRegistry namedWriteableRegistry,
            throw new IllegalArgumentException("listener must not be null");
        Consumer<IndexShard> replicator,
            fixedRefreshIntervalSchedulingEnabled,
            IOException> dataFormatAwareEngineFactorySupplier
     */
        this.directoryFactories = Collections.unmodifiableMap(directoryFactories);
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
        false,
        }
            DataFormatAwareEngineFactory,
        if (setting == null) {
        ValuesSourceRegistry valuesSourceRegistry,
    );
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier,
     *   <li>ScriptService, for script-based similarities
import org.opensearch.index.engine.EngineFactory;
            }
     * <p>
                valuesSourceRegistry,
            indexCreationContext,
            if (tiered != null) {
     * Adds an {@link IndexEventListener} for this index. All listeners added here
            scriptService,
     * <p>
        RecoverySettings recoverySettings,
                if (queryCacheProvider == null) {
            clusterDefaultRefreshIntervalSupplier,
        Type(final String settingsKey) {
            MapperService,
     * Adds a Setting and it's consumer for this index.
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
 * IndexModule represents the central extension point for index level custom implementations like:
import java.util.Locale;
     * are maintained for the entire index lifecycle on this node. Once an index is closed or deleted these
        IndexAnalyzers indexAnalyzers = null;
     * </p>
        }
        if (allowMmap && Constants.JRE_IS_64BIT) {
     * NOTE: this can only be set once
        Function.identity(),
        IndexService.IndexCreationContext indexCreationContext,
            if (success == false) {
import org.opensearch.index.cache.query.IndexQueryCache;
        IndicesQueryCache indicesQueryCache,
        ensureNotFrozen();
        NamedXContentRegistry xContentRegistry,
                }
    public void addSimilarity(String name, TriFunction<Settings, Version, ScriptService, Similarity> similarity) {
    ) {
                indicesFieldDataCache,
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
 *     {@link IndexModule#SIMILARITY_SETTINGS_PREFIX} prefix along with the "type" value.  For example, to reference the
            clusterDefaultRefreshIntervalSupplier,
     *
        Property.IndexScope,
        if (factory == null) {
    );
            () -> false,
    /**
     * @param indexerFactory      the engine factory
    // for test purposes only
    }
        NodeEnvironment environment,
         * Convenience method to check whether the given {@link IndexSettings}
        ValuesSourceRegistry valuesSourceRegistry,
import java.util.Set;
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
        Property.NodeScope
        DataLocalityType.FULL.name(),
        ensureNotFrozen();
     * must delegate {@link IndexReader#getReaderCacheHelper()}, {@link LeafReader#getCoreCacheHelper()}
                    break;
            clusterDefaultMaxMergeAtOnceSupplier,
            type = defaultStoreType(allowMmap);
            Collections.emptyMap(),
    }
         */
            }
            bigArrays,
        Property.IndexScope,
 * software distributed under the License is distributed on an
    public Settings getSettings() {
    }
    private static DataFormatAwareStoreDirectoryFactory getDataFormatAwareStoreDirectoryFactory(
    public static final Setting<String> INDEX_STORE_TYPE_SETTING = new Setting<>(
        if (this.frozen.get()) {
            clusterDefaultMaxMergeAtOnceSupplier,
    ) throws IOException {
        IndexService.ShardStoreDeleter shardStoreDeleter,
                default:
    public IndexModule(
                expressionResolver,
        final IndexStorePlugin.CompositeDirectoryFactory factory;
        FileCache remoteStoreFileCache
import org.opensearch.env.ShardLock;
                indexAnalyzers,
        IndicesFieldDataCache indicesFieldDataCache,
        final IndexSettings indexSettings,
        Supplier<Boolean> shardLevelRefreshEnabled,
            namedWriteableRegistry,
import java.nio.file.Path;
                throw new IllegalArgumentException("no matching store type for [" + key + "]");
            valuesSourceRegistry,
        Function.identity(),
        final Boolean allowMmap = NODE_STORE_ALLOW_MMAP.get(indexSettings.getNodeSettings());
        } else {
        "",
    public void addIndexEventListener(IndexEventListener listener) {
            final Map<String, DataLocalityType> localityTypes = new HashMap<>(values().length);
            expressionResolver,
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
                @Override
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier,
        this.dataFormatAwareStoreDirectoryFactories = Collections.unmodifiableMap(dataFormatAwareStoreDirectoryFactories);
            @Override
        } else {
        Consumer<IndexShard> replicator,
import org.opensearch.index.translog.TranslogFactory;
                dataFormatRegistry,
    }
        ensureNotFrozen();
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
            throw new IllegalArgumentException("similarity for name: [" + name + " is already registered");
        Supplier<Boolean> shardLevelRefreshEnabled,
    );
    @Deprecated(forRemoval = true)
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
     * Construct the index module for the index with the specified index settings. The index module contains extension points for plugins
    }
        public boolean match(Settings settings) {
            DataFormatAwareEngineFactory,
     * Returns the index this module is associated with
     */
        IndexService.IndexCreationContext indexCreationContext,
 * GitHub history for details.
     * @return the engine factory
        ScriptService scriptService,
                return new BucketedCompositeDirectory(factory.newDirectory(indexSettings, shardPath));
            translogFactorySupplier,
        MapperRegistry mapperRegistry,
    private final List<IndexingOperationListener> indexOperationListeners = new ArrayList<>();
        /**
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig
     * listeners go out of scope.
            "pos",
     * doing so will result in an exception.
     * wrapping was performed the provided directory reader.
 * this file be licensed under the Apache-2.0 license or a
                    factories.put(
        HYBRIDFS("hybridfs"),
    public IndexService newIndexService(
            "fdt",
    }
            throw new IllegalArgumentException("setting must not be null");
import org.opensearch.index.engine.exec.IndexerFactory;
        MMAPFS("mmapfs"),
        this.expressionResolver = expressionResolver;
            analysisRegistry,
            Objects.requireNonNull(localityType, "No locality type given.");
            clusterDefaultRefreshIntervalSupplier,
        final EngineFactory engineFactory,
        List.of(
     * and query caching is not disabled with {@code index.queries.cache.enabled}, then
     * Listeners can't be unregistered they will stay alive for the entire time the index is allocated on a node.
 * You may obtain a copy of the License at
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.logging.DeprecationLogger;
        IndexService.IndexCreationContext indexCreationContext,
        this(
     * relocated to another node the internal representation will be destroyed which includes the registered listeners.
                }
        REMOTE_SNAPSHOT("remote_snapshot");
            recoverySettings,
            circuitBreakerService,
        MapperRegistry mapperRegistry,
            shardLevelRefreshEnabled,
            replicator,
            }
     * The wrapped reader can filter out document just like delete documents etc. but must not change any term or
         * object contains an {@link #INDEX_STORE_TYPE_SETTING} set to the value of this type.
     * Note: an index might be created on a node multiple times. For instance if the last shard from an index is
            threadPool,
        RemoteStoreSettings remoteStoreSettings,
        Property.IndexScope,
            factory = indexStoreFactories.get(storeType);
        BooleanSupplier idFieldDataEnabled,
import org.apache.lucene.index.IndexReader;
                    queryCache = new IndexQueryCache(indexSettings, indicesQueryCache);
         */
            "tvd",
            remoteDirectoryFactory,
        }
            .get() == null ? (shard) -> null : indexReaderWrapper.get();
        if (indexEventListeners.contains(listener)) {
                    queryCache = queryCacheProvider.apply(indexSettings, indicesQueryCache);
            MapperService,
    public Index getIndex() {
        }
        } else {
    /**
            valuesSourceRegistry,
            indicesFieldDataCache,
import java.util.function.Supplier;
        NodeEnvironment environment,
                directoryFactory,
            s -> {},
import org.opensearch.index.engine.EngineConfigFactory;
     * @param directoryFactories the available store types
        RemoteStoreSettings remoteStoreSettings,
    }
        }
            segmentReplicationStatsProvider,
        if (storeType.isEmpty()) {
 *     {@link #addSimilarity(String, TriFunction)} while existing Providers can be referenced through Settings under the
        IndicesQueryCache indicesQueryCache,
                case NIOFS:
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig,
    ) {
     * <p>
        this.compositeIndexSettings = compositeIndexSettings;
        Consumer<IndexShard> replicator,
        if (indexOperationListeners.contains(listener)) {
            factory = DEFAULT_DIRECTORY_FACTORY;
        if (listener == null) {
                    break;
    ) {
import org.apache.lucene.index.DirectoryReader;
            segmentReplicationStatsProvider,
 * KIND, either express or implied.  See the License for the
        ThreadPool threadPool,
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
 * license agreements. See the NOTICE file distributed with
                recoverySettings,
            "nvm",
    @Deprecated(forRemoval = true)
 *     <li>{@link Similarity} - New {@link Similarity} implementations can be registered through
     * NOTE: The index reader wrapper ({@link CheckedFunction}) has a per-request lifecycle,
import org.apache.lucene.index.FilterDirectoryReader;
import org.apache.lucene.search.similarities.Similarity;
import org.opensearch.common.TriFunction;
                dataFormatAwareStoreDirectoryFactory,
            clusterService,
            LOCALITY_TYPES = Collections.unmodifiableMap(localityTypes);
            environment,
            idFieldDataEnabled,
        if (compositeStoreType.isEmpty() || compositeDirectoryFactories.isEmpty()) {
    public static final Setting<List<String>> INDEX_STORE_HYBRID_NIO_EXTENSIONS = Setting.listSetting(
     *
        Consumer<IndexShard> replicator,
        ensureNotFrozen();
@PublicApi(since = "1.0.0")
 * compatible open source license.
import java.util.concurrent.atomic.AtomicBoolean;
    }
    ) {
        final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories,
        }
        TieringState.HOT.name(),
     */
                type = null;
        Function<IndexService, CheckedFunction<DirectoryReader, DirectoryReader, IOException>> indexReaderWrapperFactory
                @Override
import org.opensearch.common.settings.Settings;
                queryCache = new DisabledQueryCache(indexSettings);
/*
    }
            xContentRegistry,
            clusterService,
        RemoteStoreSettings remoteStoreSettings,
            "cfe",
        CircuitBreakerService circuitBreakerService,
import org.opensearch.common.SetOnce;
            idFieldDataEnabled,
     * creates a new mapper service to do administrative work like mapping updates. This *should not* be used for document parsing.
        "index.store.hybrid.nio.extensions",
import org.opensearch.index.store.remote.filecache.FileCache;
        MapperRegistry mapperRegistry,
        final IndexSettings indexSettings,
/**
    public enum DataLocalityType {
            @Override
        CircuitBreakerService circuitBreakerService,
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
     * Index setting that selects a custom StoreFactory provided by plugins. If empty, the default store is used
            DataFormatAwareStoreDirectoryFactory tiered = dataFormatAwareStoreDirectoryFactories.get(
import org.opensearch.common.settings.Setting;
                mapperRegistry,
        WARM_TO_HOT;
                clusterMergeSchedulerConfig,
            throw new IllegalArgumentException("listener already added");
        /**
    private final AtomicBoolean frozen = new AtomicBoolean(false);
            ShardPath,
        this.indexReaderWrapper.set(indexReaderWrapperFactory);
    ) throws IOException {
        return indexSettings.getSettings();
            translogFactorySupplier,
        IndexService.IndexCreationContext indexCreationContext,
     * @opensearch.api
                localityTypes.put(dataLocalityType.name(), dataLocalityType);
        CheckedTriFunction<
            clusterMergeSchedulerConfig,
    private void ensureNotFrozen() {
    private final SetOnce<Function<IndexService, CheckedFunction<DirectoryReader, DirectoryReader, IOException>>> indexReaderWrapper =
     *
        final IndexStorePlugin.DirectoryFactory directoryFactory = getDirectoryFactory(indexSettings, directoryFactories);
    public static final Setting<Boolean> INDEX_QUERY_CACHE_ENABLED_SETTING = Setting.boolSetting(
        "index.tiering.state",
     */
     */
    }
        private static final Map<String, DataLocalityType> LOCALITY_TYPES;
                environment,
        Property.IndexScope,
        IndexService.ShardStoreDeleter shardStoreDeleter,
            throw new IllegalArgumentException("listener already added");
        NamedXContentRegistry xContentRegistry,
            "fdx",
        public boolean match(IndexSettings settings) {
            indexSettings,
            valuesSourceRegistry,
        MapperRegistry mapperRegistry,
     * Once the node holds at least one shard of an index all modules are reloaded and listeners are registered again.
     */
        Client client,
import org.opensearch.core.index.shard.ShardId;
     * Once the node holds at least one shard of an index all modules are reloaded and listeners are registered again.
    /**
                compositeIndexSettings,
            this.deprecated = deprecated;
            Collections.emptyMap()
            }
            }
 * this work for additional information regarding copyright
        IndicesFieldDataCache indicesFieldDataCache,
        DataFormatRegistry dataFormatRegistry
    @ExperimentalApi
public final class IndexModule {
        NamedXContentRegistry xContentRegistry,
            indicesQueryCache,
        }
        NamedWriteableRegistry namedWriteableRegistry,
    @Deprecated(forRemoval = true)
        NamedXContentRegistry xContentRegistry,
    public enum Type {
            return match(settings.getSettings());
    private static IndexStorePlugin.CompositeDirectoryFactory getCompositeDirectoryFactory(
            namedWriteableRegistry,
import org.opensearch.index.analysis.AnalysisRegistry;
        final IndexNameExpressionResolver expressionResolver,
            IndexSettings,
        }
        return newIndexService(
 *
        if (indexSettings.isWarmIndex() && indexSettings.isPluggableDataFormatEnabled()) {
        Property.NodeScope
            final DataLocalityType type = LOCALITY_TYPES.get(localityTypeName);
     * via {@link org.opensearch.plugins.PluginsService#onIndexModule(IndexModule)}.
        final IndexStorePlugin.StoreFactory factory = storeFactories.get(key);
    private final Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories;
                clusterService,
    /**
        IndexService.IndexCreationContext indexCreationContext,
        Property.NodeScope
                eventListener,
     * <p>
            for (final DataLocalityType dataLocalityType : values()) {
            "fnm",
     *   <li>version of OpenSearch when the index was created
            clusterMergeSchedulerConfig,
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
import org.apache.lucene.store.Directory;
        return newIndexService(
            replicator,
        IndicesQueryCache indicesQueryCache,
            remoteDirectoryFactory,
        MapperRegistry mapperRegistry,
            remoteStoreSettings,
                new SimilarityService(indexSettings, scriptService, similarities),
        Property.NodeScope
        final BooleanSupplier allowExpensiveQueries,
        return indexerFactory;
            Collections.emptyMap(),
            directoryFactories,
        ThreadPool threadPool,
            threadPool,
            client,
            if (indexSettings.getValue(INDEX_QUERY_CACHE_ENABLED_SETTING)) {
        NamedXContentRegistry xContentRegistry,
    public static final Setting<Boolean> IS_WARM_INDEX_SETTING = Setting.boolSetting("index.warm", false, Property.IndexScope);
            mapperRegistry,
        return dataFormatAwareStoreDirectoryFactories.get("default");
        "index.queries.cache.everything",
     * and must be an instance of {@link FilterDirectoryReader} that eventually exposes the original reader
                allowExpensiveQueries,
            indicesFieldDataCache,
        public boolean match(String setting) {
                    return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath);
     */
        RecoverySettings recoverySettings,
            "write.lock",
    public static final Setting<Boolean> INDEX_QUERY_CACHE_EVERYTHING_SETTING = Setting.boolSetting(
                DEPRECATION_LOGGER.deprecate(type.getSettingsKey(), " is deprecated and will be removed in 2.0");
            indicesBitsetFilterCache,
        final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories
        final Type type;
        }
    }
                        new RemoteSnapshotDirectoryFactory(repositoriesService, threadPool, remoteStoreFileCache)
        final Map<String, IndexStorePlugin.DirectoryFactory> factories = new HashMap<>();
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
    public void addSearchOperationListener(SearchOperationListener listener) {
            segmentReplicationStatsProvider,
                indexerFactory,
     * @param similarity SimilarityProvider to register
            client,
 *
        } else {
        IndicesBitsetFilterCache indicesBitsetFilterCache,
            }
            circuitBreakerService,
    @InternalApi
        BooleanSupplier idFieldDataEnabled,
            valuesSourceRegistry,
import org.opensearch.common.unit.TimeValue;
        ensureNotFrozen();
        NodeEnvironment environment,
        final Map<String, IndexStorePlugin.StoreFactory> storeFactories,
            indexSettings,
        BooleanSupplier idFieldDataEnabled,
        IndicesFieldDataCache indicesFieldDataCache,
        Supplier<RepositoriesService> repositoriesService,
            clusterMergeSchedulerConfig,
            xContentRegistry,
        ClusterService clusterService,
        final IndexEventListener eventListener = freeze();
            shardStoreDeleter,
        final Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories,
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
        ValuesSourceRegistry valuesSourceRegistry,
import java.util.function.Consumer;
        return factory;
import org.opensearch.index.similarity.SimilarityService;
        FULL,
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
            throw new IllegalStateException("Can't modify IndexModule once the index service has been created");
        return newIndexService(
        IndicesFieldDataCache indicesFieldDataCache,
        }
            factory = DEFAULT_COMPOSITE_DIRECTORY_FACTORY;
import org.opensearch.index.store.DefaultCompositeDirectoryFactory;
 *
            null
        similarities.put(name, similarity);
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
            if (factory == null) {
            fixedRefreshIntervalSchedulingEnabled,
    public MapperService newIndexMapperService(
        );
                replicator,
            remoteStoreSettings,
        final Map<String, IndexStorePlugin.DirectoryFactory> indexStoreFactories
        this.forceQueryCacheProvider.set(queryCacheProvider);
        }
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
        Client client,
        }
    private final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories;
                    ShardId shardId,
        final IndexSettings indexSettings,
    public void forceQueryCacheProvider(BiFunction<IndexSettings, IndicesQueryCache, QueryCache> queryCacheProvider) {
        RemoteStoreSettings remoteStoreSettings,
            throw new IllegalArgumentException("listener must not be null");
            indexCreationContext,
        NIOFS("niofs"),
                throw new IllegalArgumentException("Unknown composite store type [" + compositeStoreType + "]");
        new DefaultCompositeDirectoryFactory();
            return this.settingsKey;
            s -> null,
 */
            }
            if (factory == null) {
        ScriptService scriptService,
     */
        try {
import org.opensearch.cluster.routing.ShardRouting;
import java.util.Map;
        }
 * ownership. Elasticsearch licenses this file to you under
        IndicesQueryCache indicesQueryCache,
        if (recoveryType.isEmpty()) {
            null,
                xContentRegistry,
            null,
                case FS:
        ScriptService scriptService,
            "pay",
            namedWriteableRegistry,
        }
        Function.identity(),
        Property.IndexScope
        MapperRegistry mapperRegistry,
            shardLevelRefreshEnabled,
import org.opensearch.common.annotation.PublicApi;
            return TYPES.containsKey(key);
            } else {
            return new CompositeIndexEventListener(indexSettings, indexEventListeners);
            clusterService,
            scriptService,
            throw new IllegalArgumentException("setting must not be null");
 * not use this file except in compliance with the License.
                indexCreationContext,
 * Modifications Copyright OpenSearch Contributors. See
        IndicesBitsetFilterCache indicesBitsetFilterCache,
         */
    /**
     * @deprecated Use the overload that accepts a {@code dataFormatRegistry} parameter.
            remoteStoreSettings,
            shardLevelRefreshEnabled,
            analysisRegistry.build(indexSettings),
        return factory;
            idFieldDataEnabled,
            client,
        }
        );
        }
        private static final Map<String, Type> TYPES;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
import org.opensearch.indices.IndicesBitsetFilterCache;
            indexCreationContext,
        ClusterService clusterService,
    /**
        ThreadPool threadPool,
    @InternalApi
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
            "vem"
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier
            }
            scriptService,
            throw new IllegalArgumentException("Unknown store factory [" + key + "]");
                searchOperationListeners,
        ScriptService scriptService,
        };
        Property.NodeScope
        if (storeType.isEmpty() || Type.FS.getSettingsKey().equals(storeType)) {
        NodeEnvironment environment,
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig,
 */
                translogFactorySupplier,
        ClusterService clusterService,
                indexAnalyzers = analysisRegistry.build(indexSettings);
                ) throws IOException {
    }
            return null;
    /** Which lucene file extensions to load with nio. All others will default to mmap.
            indicesFieldDataCache,
            bigArrays,
        true,
    public static Map<String, IndexStorePlugin.DirectoryFactory> createBuiltInDirectoryFactories(
     * Listeners can't be unregistered they will stay alive for the entire time the index is allocated on a node.
                type = Type.fromSettingsKey(storeType);
                case MMAPFS:
                namedWriteableRegistry,
        public static Type fromSettingsKey(final String key) {
        eventListener.beforeIndexCreated(indexSettings.getIndex(), indexSettings.getSettings());
            remoteStoreSettings,
        this.analysisRegistry = analysisRegistry;
        this.indexOperationListeners.add(listener);
            shardStoreDeleter,
            clusterDefaultMaxMergeAtOnceSupplier
package org.opensearch.index;
        ClusterService clusterService,
        PARTIAL;
                    ShardPath shardPath,
 * specific language governing permissions and limitations
        Property.PrivateIndex
            "liv",
            threadPool,
        final Map<String, DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories
import java.util.ArrayList;
        } finally {
    private final Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories;
    }
 * @opensearch.api
import org.opensearch.index.shard.IndexShard;
            circuitBreakerService,
                TieredDataFormatAwareStoreDirectoryFactory.FACTORY_KEY
    /**
        final IndexStorePlugin.CompositeDirectoryFactory compositeDirectoryFactory = getCompositeDirectoryFactory(
            engineConfigFactory,
        final EngineConfigFactory engineConfigFactory,
    );
 *      {@link #addSettingsUpdateConsumer(Setting, Consumer)}</li>
import java.util.function.Function;
        ScriptService scriptService,
    public static final Setting<String> INDEX_RECOVERY_TYPE_SETTING = new Setting<>(
    ) throws IOException {
            null,
    );
            "dii",
     * creates a new mapper service to do administrative work like mapping updates. This *should not* be used for document parsing.
            translogFactorySupplier,
        }
    }
    private static IndexStorePlugin.RecoveryStateFactory getRecoveryStateFactory(
        MapperRegistry mapperRegistry,
            }
            remoteDirectoryFactory,
     * Returns the index {@link Settings} for this index
    }
    public IndexService newIndexService(
    private final EngineConfigFactory engineConfigFactory;
                } else {
            throw new IllegalArgumentException("Unknown locality type constant [" + localityType + "].");
            for (final Type type : values()) {
        final Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories
    private final SetOnce<BiFunction<IndexSettings, IndicesQueryCache, QueryCache>> forceQueryCacheProvider = new SetOnce<>();
        "index.composite_store.type",
     * @param analysisRegistry   the analysis registry
    ) throws IOException {
        /**
        this.recoveryStateFactories = recoveryStateFactories;
     * Listeners can't be unregistered they will stay alive for the entire time the index is allocated on a node.
        Function.identity(),
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
            return deprecated;
        /**
            return DEFAULT_RECOVERY_STATE_FACTORY;
     * Sets the factory for creating new {@link DirectoryReader} wrapper instances.
     * Adds a Setting, it's consumer and validator for this index.
    ) {
        return newIndexService(
                    IndexSettings indexSettings,
            }
        this.indexerFactory = Objects.requireNonNull(indexerFactory);
    }
        final IndexSettings indexSettings,
     */
            public Directory newDirectory(IndexSettings indexSettings, ShardPath shardPath) throws IOException {
import org.opensearch.indices.RemoteStoreSettings;
    private final Map<String, IndexStorePlugin.StoreFactory> storeFactories;
        ensureNotFrozen();
import org.opensearch.storage.directory.TieredDataFormatAwareStoreDirectoryFactory;
 * <ul>
        Function.identity(),
        final Map<String, IndexStorePlugin.StoreFactory> storeFactories
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
            return match(INDEX_STORE_TYPE_SETTING.get(settings));
    @PublicApi(since = "1.0.0")
            indicesQueryCache,
    private final Map<String, DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories;
        }
import org.apache.lucene.util.Constants;
                return tiered;
        RecoverySettings recoverySettings,
        }
        );
        NamedWriteableRegistry namedWriteableRegistry,
            throw new IllegalStateException("already frozen");
                throw new UnsupportedOperationException("no index query shard context available");
     * @param name Name of the SimilarityProvider
    ) {
            new EngineBackedIndexerFactory(engineFactory),
            TYPES = Collections.unmodifiableMap(types);
    }
        BooleanSupplier idFieldDataEnabled,
     * <p>
import org.opensearch.index.store.remote.filecache.NodeCacheService;
        final Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories,
            environment,
            translogFactorySupplier,
        "index.store.type",
     * The {@link CheckedFunction} is invoked each time a {@link Engine.Searcher} is requested to do an operation,
            segmentReplicationStatsProvider,
            bigArrays,
            indicesQueryCache,
        NodeEnvironment environment,
            xContentRegistry,
            this(settingsKey, false);
import org.apache.lucene.store.LockFactory;
import java.util.Collections;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
                IOUtils.closeWhileHandlingException(queryCache, indexAnalyzers);
import org.opensearch.index.shard.ShardPath;
            throw new IllegalArgumentException("store type [" + storeType + "] is not allowed because mmap is disabled");
    private final Set<IndexEventListener> indexEventListeners = new HashSet<>();
        Supplier<Boolean> shardLevelRefreshEnabled,
     */
            indexSettings,
            recoverySettings,
    public void setReaderWrapper(
    public static final Setting<String> INDEX_STORE_FACTORY_SETTING = new Setting<>(
        ValuesSourceRegistry valuesSourceRegistry,
    }
    private static final IndexStorePlugin.CompositeDirectoryFactory DEFAULT_COMPOSITE_DIRECTORY_FACTORY =
        ThreadPool threadPool,
        );
     *
        this.indexSettings = indexSettings;
            shardStoreDeleter,
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
                }
                clusterDefaultMaxMergeAtOnceSupplier,
        return indexSettings.getIndex();
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     *  @see <a href="https://lucene.apache.org/core/9_9_0/core/org/apache/lucene/codecs/lucene99/package-summary.html#file-names">Lucene File Extensions</a>.
        }
        public static DataLocalityType getValueOf(final String localityType) {
            final Map<String, Type> types = new HashMap<>(values().length);
        }
     * </p>
        ensureNotFrozen();
     * Index setting which used to determine how the data is cached locally fully or partially.
            return type;
        if (allowMmap == false && (type == Type.MMAPFS || type == Type.HYBRIDFS)) {
     * @deprecated Use the overload that accepts {@code indicesBitsetFilterCache} and {@code dataFormatRegistry} parameters.
            );
 *      via {@link IndexStorePlugin}</li>
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
            this.settingsKey = settingsKey;
            (DataFormatRegistry) null
        final Map<String, DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories
    private final BooleanSupplier allowExpensiveQueries;
            new SimilarityService(indexSettings, scriptService, similarities),
        return newIndexMapperService(xContentRegistry, mapperRegistry, scriptService, null);
            fixedRefreshIntervalSchedulingEnabled,
            clusterDefaultRefreshIntervalSupplier,
import org.opensearch.cluster.service.ClusterService;
        }
        ThreadPool threadPool,
         * Indicates that only a subset of the data will be cached locally
                readerWrapperFactory,
    public void addIndexOperationListener(IndexingOperationListener listener) {
            client,
            clusterService,
                public Store newStore(
                circuitBreakerService,
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier,
        final EngineConfigFactory engineConfigFactory,
                    factories.put(type.getSettingsKey(), DEFAULT_DIRECTORY_FACTORY);
     * Indicates the locality of the data - whether it will be cached fully or partially
            indexSettings,
        BigArrays bigArrays,
            circuitBreakerService,
        ScriptService scriptService
        RecoverySettings recoverySettings,
        return new MapperService(
        private final boolean deprecated;
            bigArrays,
    }
                public Store newStore(
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
        this.storeFactories = storeFactories;
import java.util.HashSet;
                    IndexSettings indexSettings,
                idFieldDataEnabled,
        this.nodeCacheService = nodeCacheService;
            xContentRegistry,
                    ShardId shardId,
    ) {
     * Once the node holds at least one shard of an index all modules are reloaded and listeners are registered again.
        static {
        IndexService.ShardStoreDeleter shardStoreDeleter,
 */
            namedWriteableRegistry,
                    ShardPath shardPath
            xContentRegistry,
            threadPool,
import org.opensearch.indices.IndicesQueryCache;
        HOT_TO_WARM,
        Client client,
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
    /** On which extensions to load data into the file-system cache upon opening of files.
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier,
        Property.IndexScope,
    }
            final Type type = TYPES.get(key);
                compositeDirectoryFactory,
     * document content.
import org.opensearch.plugins.IndexStorePlugin;
        final String storeType = indexSettings.getValue(INDEX_STORE_TYPE_SETTING);
import org.opensearch.index.shard.IndexEventListener;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
     *   <li>settings for this similarity
                return factory.newFSDirectory(location, lockFactory, indexSettings);
        ensureNotFrozen();
        ThreadPool threadPool,
     */
        Property.IndexScope
     * The factory ({@link Function}) is called once the IndexService is fully constructed.
        indexSettings.getScopedSettings().addSettingsUpdateConsumer(setting, consumer);
                case REMOTE_SNAPSHOT:
        CircuitBreakerService circuitBreakerService,
        final AnalysisRegistry analysisRegistry,
 *      <li>{@link IndexEventListener} - Custom {@link IndexEventListener} instances can be registered via
        Property.IndexScope,
            shardLevelRefreshEnabled,
        return factories;
    }
        boolean success = false;
    private static IndexStorePlugin.DirectoryFactory getDirectoryFactory(
        }
        RemoteStoreSettings remoteStoreSettings,
    public IndexModule(
import org.opensearch.repositories.RepositoriesService;
    private final CompositeIndexSettings compositeIndexSettings;
import org.opensearch.index.engine.Engine;
            mapperRegistry,
                    Directory directory,
import org.opensearch.index.shard.IndexingOperationListener;
            fixedRefreshIntervalSchedulingEnabled,
import org.opensearch.indices.ClusterMergeSchedulerConfig;
 * The OpenSearch Contributors require contributions made to
            namedWriteableRegistry,
         * Indicates that all the data will be cached locally
    }
     * @param indexSettings      the index settings
        ScriptService scriptService,
         */
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
        CircuitBreakerService circuitBreakerService,
        IndexService.ShardStoreDeleter shardStoreDeleter,
     * </ul>
    }
     * Registers the given {@link Similarity} with the given name.
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
                shardStoreDeleter,
     */
        "index.store.data_locality",
     * for example search, and must return a new directory reader wrapping the provided directory reader or if no
    /**
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
            remoteDirectoryFactory,
                bigArrays,
        );
     */
    }
        Client client,
        ThreadPool threadPool,
                    Store.OnClose onClose,
        final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories
            client,
        NodeEnvironment environment,
            allowExpensiveQueries,
        Property.NodeScope
 *      <li>Settings update listener - Custom settings update listener can be registered via
import java.util.List;
        final IndexSettings indexSettings,
        if (searchOperationListeners.contains(listener)) {
        );
     */
            mapperRegistry,
 * the Apache License, Version 2.0 (the "License"); you may
            indicesQueryCache,
     *  This is an expert setting.
                nodeCacheService
 *     {@link BM25Similarity}, the configuration {@code "index.similarity.my_similarity.type : "BM25"} can be used.</li>
import org.opensearch.env.NodeEnvironment;
    /**
                    IndexStorePlugin.DirectoryFactory directoryFactory
            shardStoreDeleter,
         */
    }
     * </p>
     */
        final String key = indexSettings.getValue(INDEX_STORE_FACTORY_SETTING);
    /**
            dataFormatRegistry
    // whether to use the query cache
    ) throws IOException {
            throw new IllegalArgumentException("listener already added");
            }
import org.opensearch.core.index.Index;
        ),
            valuesSourceRegistry,
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
        IndexService.IndexCreationContext indexCreationContext,
     */
            "si",
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
 */
                threadPool,
        public String getSettingsKey() {
        if (key == null || key.isEmpty()) {
 * Unless required by applicable law or agreed to in writing,
    }
        } else {
        NamedWriteableRegistry namedWriteableRegistry,
        MapperRegistry mapperRegistry,
            remoteDirectoryFactory,
import org.apache.lucene.search.similarities.BM25Similarity;
                remoteStoreSettings,
        ValuesSourceRegistry valuesSourceRegistry,
import org.opensearch.indices.recovery.RecoverySettings;
    private static final FsDirectoryFactory DEFAULT_DIRECTORY_FACTORY = new FsDirectoryFactory();
            }
        if (similarities.containsKey(name) || SimilarityService.BUILT_IN.containsKey(name)) {
        );
import org.opensearch.index.cache.query.QueryCache;
            switch (type) {
    public IndexService newIndexService(
    /**
        }
    ) throws IOException {
        CheckedTriFunction<
        Property.IndexScope,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        RemoteStoreSettings remoteStoreSettings,
            recoverySettings,
            replicator,
        BigArrays bigArrays,
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
    }
     * Type of file system
    /**
    private static IndexStorePlugin.StoreFactory resolveStoreFactory(
     */
            indexCreationContext,
        );
     */
     * are maintained for the entire index lifecycle on this node. Once an index is closed or deleted these
        Collections.emptyList(),
     */
            bigArrays,
                    throw new IllegalStateException("No directory factory mapping for built-in type " + type);
        this.engineConfigFactory = Objects.requireNonNull(engineConfigFactory);
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
                engineConfigFactory,
        Supplier<Boolean> shardLevelRefreshEnabled,
            translogFactorySupplier,
            } else {
        Function.identity(),
        }
            "tvx",
        this.allowExpensiveQueries = allowExpensiveQueries;
            shardLevelRefreshEnabled,
         * object contains an {@link #INDEX_STORE_TYPE_SETTING} set to the value of this type.
     * listeners go out of scope.
     *
                case HYBRIDFS:
        indexSettings.getScopedSettings().addSettingsUpdateConsumer(setting, consumer, validator);
    private final IndexSettings indexSettings;
            }
            IndexSettings,
    private final IndexerFactory indexerFactory;
        }
        DataFormatRegistry dataFormatRegistry
        CircuitBreakerService circuitBreakerService,
     * The engine factory provided during construction of this index module.
    private final Map<String, TriFunction<Settings, Version, ScriptService, Similarity>> similarities = new HashMap<>();
        }
                recoveryStateFactory,
}
                resolveStoreFactory(indexSettings, storeFactories),
        IndexService.ShardStoreDeleter shardStoreDeleter,
    public static final Setting<List<String>> INDEX_STORE_PRE_LOAD_SETTING = Setting.listSetting(
     * doing so will result in an exception.
import org.opensearch.transport.client.Client;
import org.opensearch.common.CheckedTriFunction;
            clusterDefaultRefreshIntervalSupplier,
            circuitBreakerService,
     * via {@link FilterDirectoryReader#getDelegate()}.
            throw new IllegalArgumentException("listener must not be null");
            indexCreationContext,
            recoverySettings,
    );
    );
            xContentRegistry,
        SIMPLEFS("simplefs"),
     * Overload retained for binary compatibility; delegates with no pluggable data format registry.
    /**
    public static final Setting<DataLocalityType> INDEX_STORE_LOCALITY_SETTING = new Setting<>(
            if (type != null) {
    private final AnalysisRegistry analysisRegistry;
        Property.NodeScope
            mapperRegistry,
        }
    /**
import java.util.function.BooleanSupplier;
        Client client,
            environment,
import org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory;
        "",
    private final List<SearchOperationListener> searchOperationListeners = new ArrayList<>();
            return indexService;
        return newIndexService(
            recoverySettings,
            if (type.isDeprecated()) {
    public <T> void addSettingsUpdateConsumer(Setting<T> setting, Consumer<T> consumer) {
                    return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath, directoryFactory);
                case SIMPLEFS:
            compositeDirectoryFactories
            "segments_N",
        final IndexerFactory indexerFactory,
                    ShardLock shardLock,
        NamedWriteableRegistry namedWriteableRegistry,
    public static final Setting<String> INDEX_COMPOSITE_STORE_TYPE_SETTING = new Setting<>(
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
        ScriptService scriptService,
import org.opensearch.indices.mapper.MapperRegistry;
        new SetOnce<>();
    ) throws IOException {
            dataFormatAwareStoreDirectoryFactories
        /**
        IndexService.ShardStoreDeleter shardStoreDeleter,
 *      <li>{@link IndexStorePlugin.DirectoryFactory} - Custom {@link IndexStorePlugin.DirectoryFactory} instances can be registered
     * the given provider will be used.
        BooleanSupplier idFieldDataEnabled,
            if (IndexService.needsMapperService(indexSettings, indexCreationContext)) {
                    Directory directory,
            final String localityTypeName = localityType.trim().toUpperCase(Locale.ROOT);
            final IndexService indexService = new IndexService(
import java.io.IOException;
        this.indexOperationListeners.add(new IndexingSlowLog(indexSettings));
        final IndexStorePlugin.DirectoryFactory factory;
        Property.IndexScope,
                fixedRefreshIntervalSchedulingEnabled,
            (DataFormatRegistry) null
     */
import org.opensearch.indices.recovery.RecoveryState;
                    );
        if (listener == null) {
                indicesBitsetFilterCache,
import org.opensearch.index.compositeindex.CompositeIndexSettings;
import org.opensearch.index.engine.exec.DataFormatAwareEngineFactory;
            return getSettingsKey().equals(setting);
     */
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
    private static final IndexStorePlugin.RecoveryStateFactory DEFAULT_RECOVERY_STATE_FACTORY = RecoveryState::new;
     * The returned reader is closed once it goes out of scope.
            scriptService,
        final Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories,
                ) throws IOException {
        if (setting == null) {
                    ShardLock shardLock,
     * Represents the tiering state of the index.
            mapperRegistry,
/*
         * Returns true iff this settings matches the type.
        BigArrays bigArrays,
            scriptService,
        final BooleanSupplier allowExpensiveQueries,
