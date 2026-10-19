                    break;
            final IndexService indexService = new IndexService(  
            () -> false,  
        static boolean containsSettingsKey(String key) {  
        ensureNotFrozen();
        final IndexStorePlugin.CompositeDirectoryFactory compositeDirectoryFactory = getCompositeDirectoryFactory(
    /**  
     * and query caching is not disabled with {@code index.queries.cache.enabled}, then
        final IndexStorePlugin.DirectoryFactory factory;
import org.opensearch.common.settings.Setting.Property;
        IndicesQueryCache indicesQueryCache,
            new SimilarityService(indexSettings, scriptService, similarities),
    public IndexService newIndexService(  
public final class IndexModule {
        this.indexSettings = indexSettings;
import org.opensearch.threadpool.ThreadPool;
            throw new IllegalArgumentException("Unknown locality type constant [" + localityType + "].");  
    ) throws IOException {
            recoverySettings,
     */
            return this.settingsKey;
    @InternalApi  
        MapperRegistry mapperRegistry,
/*
 *     <li>{@link Similarity} - New {@link Similarity} implementations can be registered through
        if (allowMmap == false && (type == Type.MMAPFS || type == Type.HYBRIDFS)) {
            .get() == null ? (shard) -> null : indexReaderWrapper.get();
        ThreadPool threadPool,
            throw new IllegalArgumentException("listener already added");
        ClusterService clusterService,  
    @Deprecated(forRemoval = true)
        final IndexerFactory indexerFactory,
                new SimilarityService(indexSettings, scriptService, similarities),
        ValuesSourceRegistry valuesSourceRegistry,
     * Listeners can't be unregistered they will stay alive for the entire time the index is allocated on a node.
        if (factory == null) {
        ClusterService clusterService,
    }  
import org.opensearch.index.shard.ShardPath;
import org.opensearch.cluster.service.ClusterService;
    }
            for (final DataLocalityType dataLocalityType : values()) {
     * creates a new mapper service to do administrative work like mapping updates. This *should not* be used for document parsing.
        if (compositeStoreType.isEmpty() || compositeDirectoryFactories.isEmpty()) {
        NamedXContentRegistry xContentRegistry,
    public void addIndexEventListener(IndexEventListener listener) {  
    private static DataFormatAwareStoreDirectoryFactory getDataFormatAwareStoreDirectoryFactory(  
            indexCreationContext,
            }
     * Adds an {@link SearchOperationListener} for this index. All listeners added here
    );  
            environment,  
        boolean success = false;  
            segmentReplicationStatsProvider,
            indexCreationContext,  
import org.opensearch.common.unit.TimeValue;
        return newIndexService(
            indicesFieldDataCache,  
     * @see #INDEX_QUERY_CACHE_ENABLED_SETTING
                return new BucketedCompositeDirectory(factory.newDirectory(indexSettings, shardPath));  
        } else {
    public enum Type {
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
        );
        Supplier<RepositoriesService> repositoriesService,
     * </p>  
     * Sets the factory for creating new {@link DirectoryReader} wrapper instances.  
        IndicesQueryCache indicesQueryCache,
        Consumer<IndexShard> replicator,
        HYBRIDFS("hybridfs"),
    @Deprecated(forRemoval = true)
    public static final Setting<String> INDEX_TIERING_STATE = new Setting<>(
            scriptService,  
                    ShardPath shardPath,  
    }
import java.util.Set;
        "index.store.data_locality",  
     * Note: an index might be created on a node multiple times. For instance if the last shard from an index is
        Property.IndexScope,
            shardStoreDeleter,
    /**
            MapperService,  
            client,  
            Collections.emptyMap(),
 *  
        ScriptService scriptService,
        final DataFormatAwareStoreDirectoryFactory dataFormatAwareStoreDirectoryFactory = getDataFormatAwareStoreDirectoryFactory(
    /**  
        REMOTE_SNAPSHOT("remote_snapshot");
     */
            "write.lock",
    }
import org.opensearch.index.store.remote.filecache.FileCache;  
    private final IndexerFactory indexerFactory;
    public IndexModule(
     * Listeners can't be unregistered they will stay alive for the entire time the index is allocated on a node.
    );
        ensureNotFrozen();
            if (factory == null) {
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier,
        IndicesFieldDataCache indicesFieldDataCache,
     */
import org.opensearch.index.shard.SearchOperationListener;
        final Map<String, IndexStorePlugin.StoreFactory> storeFactories,
        }
 *      via {@link IndexStorePlugin}</li>  
    );
import org.opensearch.script.ScriptService;
        MapperRegistry mapperRegistry,
            indicesQueryCache,  
        DataFormatRegistry dataFormatRegistry
            dataFormatAwareStoreDirectoryFactories
    }
        ClusterService clusterService,  
                    Directory directory,  
    /**
        IndexStorePlugin.RecoveryStateFactory factory = recoveryStateFactories.get(recoveryType);
        "",
            environment,
        this.engineConfigFactory = Objects.requireNonNull(engineConfigFactory);
        );
            engineConfigFactory,  
            if (IndexService.needsMapperService(indexSettings, indexCreationContext)) {  
    public static final Setting<List<String>> INDEX_STORE_PRE_LOAD_SETTING = Setting.listSetting(
        RemoteStoreSettings remoteStoreSettings,
            analysisRegistry,
        RecoverySettings recoverySettings,
     * Adds a Setting and it's consumer for this index.
    }
     * Forces a certain query cache to use instead of the default one. If this is set  
            clusterDefaultMaxMergeAtOnceSupplier,
            }
        }
    /**
        private final String settingsKey;  
                fixedRefreshIntervalSchedulingEnabled,  
            scriptService,
    }  
                dataFormatAwareStoreDirectoryFactory,
        final BooleanSupplier allowExpensiveQueries,
        this.dataFormatAwareStoreDirectoryFactories = Collections.unmodifiableMap(dataFormatAwareStoreDirectoryFactories);  
            }
import java.util.Locale;
        similarities.put(name, similarity);
            clusterDefaultRefreshIntervalSupplier,
            }  
            xContentRegistry,
                segmentReplicationStatsProvider,  
            ShardPath,  
            return match(INDEX_STORE_TYPE_SETTING.get(settings));
            mapperRegistry,
 */
                throw new IllegalArgumentException("Unknown composite store type [" + compositeStoreType + "]");  
 *      {@link #addSettingsUpdateConsumer(Setting, Consumer)}</li>
        Property.IndexScope  
     *
                        type.getSettingsKey(),
    ) throws IOException {
        }
            idFieldDataEnabled,  
            replicator,  
        IndexService.IndexCreationContext indexCreationContext,
    }
 * Unless required by applicable law or agreed to in writing,
     * <p>  
            if (indexSettings.getValue(INDEX_QUERY_CACHE_ENABLED_SETTING)) {
        ScriptService scriptService,
                type = Type.fromSettingsKey(storeType);  
            xContentRegistry,  
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier,
        }
            return getSettingsKey().equals(setting);
    private void ensureNotFrozen() {  
         * Convenience method to check whether the given {@link IndexSettings}
        if (searchOperationListeners.contains(listener)) {
        MapperRegistry mapperRegistry,  
        IndicesQueryCache indicesQueryCache,
            }  
     * Adds an {@link IndexEventListener} for this index. All listeners added here
                remoteDirectoryFactory,
            type = defaultStoreType(allowMmap);  
import org.apache.lucene.store.LockFactory;
        final IndexStorePlugin.DirectoryFactory directoryFactory = getDirectoryFactory(indexSettings, directoryFactories);  
            indicesQueryCache,
        Type(final String settingsKey) {  
        Supplier<Boolean> shardLevelRefreshEnabled,
        IndexService.ShardStoreDeleter shardStoreDeleter,
            indexCreationContext,  
        DataFormatRegistry dataFormatRegistry  
    );  
            translogFactorySupplier,  
    public static final Setting<String> INDEX_RECOVERY_TYPE_SETTING = new Setting<>(  
    private final Set<IndexEventListener> indexEventListeners = new HashSet<>();
        SIMPLEFS("simplefs"),
        Property.IndexScope
     * Note: an index might be created on a node multiple times. For instance if the last shard from an index is  
     * <p>
     * The function takes as parameters:<ul>  
    private final AtomicBoolean frozen = new AtomicBoolean(false);
        if (indexOperationListeners.contains(listener)) {  
        this.indexEventListeners.add(listener);  
                replicator,
            translogFactorySupplier,
    public void addIndexOperationListener(IndexingOperationListener listener) {
     * <p>  
        final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories  
            }
import org.opensearch.common.settings.Settings;  
        final IndexSettings indexSettings,
        IndexService.IndexCreationContext indexCreationContext,
        if (listener == null) {  
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        MapperRegistry mapperRegistry,  
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
        NamedWriteableRegistry namedWriteableRegistry,  
            throw new IllegalArgumentException("Unknown recovery type [" + recoveryType + "]");  
            return deprecated;  
        public boolean match(String setting) {  
    private final Map<String, DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories;  
import java.util.ArrayList;  
     * </ul>
        final IndexSettings indexSettings,
        ensureNotFrozen();
        this.indexerFactory = Objects.requireNonNull(indexerFactory);  
            if (type == null) {  
            indicesFieldDataCache,
        final NodeCacheService nodeCacheService,  
            remoteDirectoryFactory,
            shardLevelRefreshEnabled,  
     * and must be an instance of {@link FilterDirectoryReader} that eventually exposes the original reader
     * @param indexSettings      the index settings
        Property.IndexScope,
                case FS:
        return factories;
        if (storeType.isEmpty() || Type.FS.getSettingsKey().equals(storeType)) {
     * The engine factory provided during construction of this index module.
            throw new IllegalArgumentException("Unknown store factory [" + key + "]");  
            client,
        return factory;  
            threadPool,
        Property.IndexScope,
        if (storeType.isEmpty()) {  
     * listeners go out of scope.  
                }
                TieredDataFormatAwareStoreDirectoryFactory.FACTORY_KEY  
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
            }  
        /**  
     * NOTE: this can only be set once  
        return indexerFactory;
        Function.identity(),  
    /**  
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
     * NOTE: The index reader wrapper ({@link CheckedFunction}) has a per-request lifecycle,  
    }  
        this.forceQueryCacheProvider.set(queryCacheProvider);  
    public static final Setting<Boolean> INDEX_QUERY_CACHE_EVERYTHING_SETTING = Setting.boolSetting(  
        } else {  
        }  
import org.apache.lucene.index.LeafReader;
            fixedRefreshIntervalSchedulingEnabled,
    public void addSearchOperationListener(SearchOperationListener listener) {
import org.opensearch.Version;
    // whether to use the query cache
        RecoverySettings recoverySettings,  
            null,
                default:  
        final Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories,  
import org.opensearch.common.settings.Setting;
            switch (type) {
                searchOperationListeners,
            clusterService,
        }
        Function<IndexService, CheckedFunction<DirectoryReader, DirectoryReader, IOException>> readerWrapperFactory = indexReaderWrapper  
            clusterService,
        WARM_TO_HOT;
    @Deprecated(forRemoval = true)
                recoveryStateFactory,  
        ClusterService clusterService,  
     */
                ) throws IOException {
            }
            remoteDirectoryFactory,
            "pay",  
        ScriptService scriptService,  
                readerWrapperFactory,
            bigArrays,
    private final List<SearchOperationListener> searchOperationListeners = new ArrayList<>();
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        private final boolean deprecated;
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
        final IndexEventListener eventListener = freeze();
    );  
        ThreadPool threadPool,
     * @deprecated Use the overload that accepts a {@code compositeEngineFactorySupplier} parameter.  
            xContentRegistry,
    );
            "fdt",
                case SIMPLEFS:  
            "liv",
    }  
    public enum DataLocalityType {  
            indexCreationContext,  
        CircuitBreakerService circuitBreakerService,
            namedWriteableRegistry,
    @Deprecated(forRemoval = true)
 * not use this file except in compliance with the License.
import org.apache.lucene.index.IndexReader;  
    private final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories;
                clusterService,
                } else {  
        NodeEnvironment environment,  
 *
     * <p>
     */
        return newIndexService(
     */
import org.opensearch.env.ShardLock;
     * Once the node holds at least one shard of an index all modules are reloaded and listeners are registered again.
        }
        final EngineConfigFactory engineConfigFactory,
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
     *  This is an expert setting.
                namedWriteableRegistry,
                    return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath);
        } finally {  
        final IndexNameExpressionResolver expressionResolver,
        this.searchOperationListeners.add(listener);
        BooleanSupplier idFieldDataEnabled,  
        "index.queries.cache.everything",
 * The OpenSearch Contributors require contributions made to  
        Supplier<Boolean> shardLevelRefreshEnabled,
import org.opensearch.cluster.routing.ShardRouting;  
        Client client,
        ClusterService clusterService,  
    /**
        "index.store.type",  
        RemoteStoreSettings remoteStoreSettings,  
                    queryCache = queryCacheProvider.apply(indexSettings, indicesQueryCache);
                public Store newStore(  
        if (recoveryType.isEmpty()) {  
            idFieldDataEnabled,
     * The factory ({@link Function}) is called once the IndexService is fully constructed.
            null
            recoveryStateFactories,
import org.apache.lucene.store.Directory;
        Collections.emptyList(),
        }
        }
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
        ScriptService scriptService,
        IndexService.IndexCreationContext indexCreationContext,
        Property.IndexScope,
                case HYBRIDFS:
        if (this.frozen.get()) {
 * Licensed to Elasticsearch under one or more contributor  
            scriptService,
        IndicesBitsetFilterCache indicesBitsetFilterCache,  
                indicesFieldDataCache,  
    public static final Setting<Boolean> INDEX_QUERY_CACHE_ENABLED_SETTING = Setting.boolSetting(
            Collections.emptyMap()  
import org.apache.lucene.util.Constants;  
     */
                case REMOTE_SNAPSHOT:  
     */
                    ShardId shardId,
                allowExpensiveQueries,  
         * Returns true iff this settings matches the type.
    /**
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,  
            success = true;
            "tvx",  
        indexSettings.getScopedSettings().addSettingsUpdateConsumer(setting, consumer, validator);
 * You may obtain a copy of the License at  
            namedWriteableRegistry,
        NamedWriteableRegistry namedWriteableRegistry,
        NamedWriteableRegistry namedWriteableRegistry,
                    queryCache = new IndexQueryCache(indexSettings, indicesQueryCache);
    public <T> void addSettingsUpdateConsumer(Setting<T> setting, Consumer<T> consumer, Consumer<T> validator) {  
        Property.NodeScope
     * via {@link org.opensearch.plugins.PluginsService#onIndexModule(IndexModule)}.
        final EngineFactory engineFactory,
            remoteDirectoryFactory,
    private final Map<String, TriFunction<Settings, Version, ScriptService, Similarity>> similarities = new HashMap<>();  
        RemoteStoreSettings remoteStoreSettings,
            if (type != null) {  
            @Override  
    }
        Property.NodeScope
    @InternalApi  
        NamedXContentRegistry xContentRegistry,
            IndexSettings,
    private final AnalysisRegistry analysisRegistry;  
        "index.store.factory",
        }  
        ensureNotFrozen();
            valuesSourceRegistry,  
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier  
     * Type of file system
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,  
     * document content.
 *     {@link #addSimilarity(String, TriFunction)} while existing Providers can be referenced through Settings under the
        NamedXContentRegistry xContentRegistry,  
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,  
        Function.identity(),  
        PARTIAL;
        ScriptService scriptService,
        IndexService.IndexCreationContext indexCreationContext,
     * </p>
                scriptService,
        IndexService.IndexCreationContext indexCreationContext,
        final BooleanSupplier allowExpensiveQueries,
            null,
import org.opensearch.core.index.Index;
                ) throws IOException {
    }
     * Indicates the locality of the data - whether it will be cached fully or partially
            indicesFieldDataCache,
    public enum TieringState {
        this.analysisRegistry = analysisRegistry;
            recoverySettings,
     *  This only works with the mmap directory, and even in that case is still  
                    return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath, directoryFactory);  
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,
        } else {
            indicesQueryCache,
        if (similarities.containsKey(name) || SimilarityService.BUILT_IN.containsKey(name)) {
        public boolean isDeprecated() {
                circuitBreakerService,
            "dvm",
                if (queryCacheProvider == null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IOException> dataFormatAwareEngineFactorySupplier  
        NamedWriteableRegistry namedWriteableRegistry,
        this.compositeIndexSettings = compositeIndexSettings;  
import org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory;
        );
            shardLevelRefreshEnabled,
        /**  
                type = null;
        final Map<String, IndexStorePlugin.DirectoryFactory> factories = new HashMap<>();
                }
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
 * license agreements. See the NOTICE file distributed with
        NamedWriteableRegistry namedWriteableRegistry,
/*  
            remoteStoreSettings,
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier,  
        final String storeType = indexSettings.getValue(INDEX_STORE_TYPE_SETTING);
            replicator,
        }
import java.nio.file.Path;
                expressionResolver,
     * Once the node holds at least one shard of an index all modules are reloaded and listeners are registered again.
        }
        MapperRegistry mapperRegistry,
        return newIndexService(
            segmentReplicationStatsProvider,  
            shardStoreDeleter,
                engineConfigFactory,  
            scriptService,
                return tiered;  
                    throw new IllegalStateException("No directory factory mapping for built-in type " + type);
        final IndexSettings indexSettings,
        }
                valuesSourceRegistry,
    }
            translogFactorySupplier,
        Property.IndexScope,  
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
        if (setting == null) {  
         * Convenience method to check whether the given {@link Settings}
import java.util.HashMap;
     * listeners go out of scope.
        }
        this.allowExpensiveQueries = allowExpensiveQueries;
        return new IndexStorePlugin.DirectoryFactory() {  
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(IndexModule.class);  
                types.put(type.settingsKey, type);
            namedWriteableRegistry,
        };
        CheckedTriFunction<
        RemoteStoreSettings remoteStoreSettings,
    }
        new DefaultCompositeDirectoryFactory();
 * GitHub history for details.
     * <p>  
     * the given provider will be used.
     */
        MapperRegistry mapperRegistry,  
     */  
     * @return the engine factory
            recoverySettings,  
        if (factory == null) {
            segmentReplicationStatsProvider,
            final Type type = TYPES.get(key);
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        Property.NodeScope
            circuitBreakerService,  
import org.opensearch.env.NodeEnvironment;  
            valuesSourceRegistry,  
        BigArrays bigArrays,  
        }
        final IndexNameExpressionResolver expressionResolver,  
            }
            } else {  
import org.apache.lucene.search.similarities.Similarity;  
        ValuesSourceRegistry valuesSourceRegistry,
                bigArrays,
            throw new IllegalArgumentException("listener already added");
        final Map<String, IndexStorePlugin.StoreFactory> storeFactories
        }
            indicesBitsetFilterCache,  
 * Modifications Copyright OpenSearch Contributors. See
            threadPool,
     * NOTE: this method can only be called once per index. Multiple wrappers are not supported.
    /**  
import org.opensearch.index.compositeindex.CompositeIndexSettings;
            final DataLocalityType type = LOCALITY_TYPES.get(localityTypeName);
     * doing so will result in an exception.
        }
            threadPool,  
import org.opensearch.indices.recovery.RecoveryState;
                indexAnalyzers = analysisRegistry.build(indexSettings);
            dataFormatRegistry
        final IndexStorePlugin.StoreFactory factory = storeFactories.get(key);
    private static final FsDirectoryFactory DEFAULT_DIRECTORY_FACTORY = new FsDirectoryFactory();
    /**
                translogFactorySupplier,
        Function.identity(),
            clusterDefaultMaxMergeAtOnceSupplier,  
import org.opensearch.index.shard.IndexShard;
     */
        NamedXContentRegistry xContentRegistry,  
                compositeDirectoryFactory,  
     */  
        RecoverySettings recoverySettings,
        NodeEnvironment environment,
            bigArrays,
            client,  
     *  @see <a href="https://lucene.apache.org/core/9_9_0/core/org/apache/lucene/codecs/lucene99/package-summary.html#file-names">Lucene File Extensions</a>.
 * <ul>  
     * The {@link CheckedFunction} is invoked each time a {@link Engine.Searcher} is requested to do an operation,
 *      <li>{@link IndexEventListener} - Custom {@link IndexEventListener} instances can be registered via
import java.util.concurrent.atomic.AtomicBoolean;  
        final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories
            if (Type.containsSettingsKey(storeType)) {
            null,
    }
 * KIND, either express or implied.  See the License for the
    public static Map<String, IndexStorePlugin.DirectoryFactory> createBuiltInDirectoryFactories(  
                throw new UnsupportedOperationException("no index query shard context available");
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier,
            this.deprecated = deprecated;  
import org.opensearch.common.util.io.IOUtils;  
        } else {
import org.opensearch.index.analysis.AnalysisRegistry;
            if (factory == null) {
        IndicesFieldDataCache indicesFieldDataCache,
        NodeEnvironment environment,
            if (tiered != null) {
        final String recoveryType = indexSettings.getValue(INDEX_RECOVERY_TYPE_SETTING);
        }  
                    IndexSettings indexSettings,
    }
            (DataFormatRegistry) null
        IndicesQueryCache indicesQueryCache,
            remoteDirectoryFactory,
        if (setting == null) {
            shardLevelRefreshEnabled,
        return indexSettings.getSettings();  
            "tvd",
     * Returns the index this module is associated with
        if (dataFormatAwareStoreDirectoryFactories.isEmpty()) {
                    factories.put(type.getSettingsKey(), DEFAULT_DIRECTORY_FACTORY);
    public void forceQueryCacheProvider(BiFunction<IndexSettings, IndicesQueryCache, QueryCache> queryCacheProvider) {
                return type;
        ),
import org.opensearch.common.annotation.InternalApi;
        IndicesQueryCache indicesQueryCache,
        final IndexStorePlugin.CompositeDirectoryFactory factory;  
        IndexService.IndexCreationContext indexCreationContext,
        WARM,
        Supplier<Integer> clusterDefaultMaxMergeAtOnceSupplier
            replicator,
            final String localityTypeName = localityType.trim().toUpperCase(Locale.ROOT);
import org.opensearch.index.mapper.MapperService;  
                mapperRegistry,
        final IndexSettings indexSettings,
            ShardPath,
            factory = DEFAULT_COMPOSITE_DIRECTORY_FACTORY;
        Property.NodeScope  
     * @param analysisRegistry   the analysis registry
import org.opensearch.common.logging.DeprecationLogger;  
        BigArrays bigArrays,  
    /** Which lucene file extensions to load with nio. All others will default to mmap.  
        IndicesQueryCache indicesQueryCache,  
    private final SetOnce<BiFunction<IndexSettings, IndicesQueryCache, QueryCache>> forceQueryCacheProvider = new SetOnce<>();
            mapperRegistry,
        final String compositeStoreType = indexSettings.getValue(INDEX_COMPOSITE_STORE_TYPE_SETTING);
        MMAPFS("mmapfs"),
import org.opensearch.indices.recovery.RecoverySettings;  
        Property.IndexScope,
            remoteStoreSettings,
        FULL,
        this.indexOperationListeners.add(listener);
                    ShardLock shardLock,
    }  
import org.opensearch.transport.client.Client;
        );  
                BiFunction<IndexSettings, IndicesQueryCache, QueryCache> queryCacheProvider = forceQueryCacheProvider.get();  
    /**
     * doing so will result in an exception.
     * The wrapped reader can filter out document just like delete documents etc. but must not change any term or
            factory = DEFAULT_DIRECTORY_FACTORY;
        NamedXContentRegistry xContentRegistry,  
            clusterDefaultRefreshIntervalSupplier,  
            throw new IllegalArgumentException("listener must not be null");
import java.util.List;
            () -> {  
            );  
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
    ) {  
        true,
    public MapperService newIndexMapperService(  
            "vem"
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,  
                clusterDefaultMaxMergeAtOnceSupplier,
            throw new IllegalArgumentException("store type [" + storeType + "] is not allowed because mmap is disabled");  
        new SetOnce<>();
    public static final Setting<Boolean> NODE_STORE_ALLOW_MMAP = Setting.boolSetting("node.store.allow_mmap", true, Property.NodeScope);  
    public MapperService newIndexMapperService(  
                    ShardLock shardLock,
        IndexService.ShardStoreDeleter shardStoreDeleter,
        BooleanSupplier idFieldDataEnabled,  
        );
    // for test purposes only
     * must delegate {@link IndexReader#getReaderCacheHelper()}, {@link LeafReader#getCoreCacheHelper()}
        "index.composite_store.type",
 *
        Client client,
            shardStoreDeleter,  
                    break;
         * object contains an {@link #INDEX_STORE_TYPE_SETTING} set to the value of this type.
     */  
        final Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories  
            valuesSourceRegistry,
        BooleanSupplier idFieldDataEnabled,  
                threadPool,  
            fixedRefreshIntervalSchedulingEnabled,
            s -> null,  
            DataFormatAwareEngineFactory,
        "",
     * creates a new mapper service to do administrative work like mapping updates. This *should not* be used for document parsing.  
        IndexStorePlugin.DirectoryFactory remoteDirectoryFactory,
        NodeEnvironment environment,
                    IndexStorePlugin.DirectoryFactory directoryFactory
            "fnm",
                environment,  
        final Map<String, DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories
    public static final Setting<List<String>> INDEX_STORE_HYBRID_NIO_EXTENSIONS = Setting.listSetting(
 * compatible open source license.
        IndicesFieldDataCache indicesFieldDataCache,
        IndexService.ShardStoreDeleter shardStoreDeleter,
import org.opensearch.indices.RemoteStoreSettings;  
    @Deprecated(forRemoval = true)
import org.opensearch.index.engine.Engine;
            namedWriteableRegistry,  
            indicesQueryCache,  
     */
        ScriptService scriptService,
        return newIndexMapperService(xContentRegistry, mapperRegistry, scriptService, null);
    public static final Setting<DataLocalityType> INDEX_STORE_LOCALITY_SETTING = new Setting<>(
        Supplier<Boolean> shardLevelRefreshEnabled,  
     * </p>
        Supplier<Boolean> shardLevelRefreshEnabled,  
        this.indexReaderWrapper.set(indexReaderWrapperFactory);
        );
    }
        BigArrays bigArrays,  
                indicesBitsetFilterCache,
        static {  
        final IndexSettings indexSettings,
                xContentRegistry,
     *   <li>ScriptService, for script-based similarities  
     * Construct the index module for the index with the specified index settings. The index module contains extension points for plugins
        NIOFS("niofs"),  
            "si",  
            indexSettings,  
import org.opensearch.common.SetOnce;
        BooleanSupplier idFieldDataEnabled,
         */  
        return new MapperService(  
    }
    private static IndexStorePlugin.StoreFactory resolveStoreFactory(  
    private final CompositeIndexSettings compositeIndexSettings;
        return factory;
            bigArrays,
     * are maintained for the entire index lifecycle on this node. Once an index is closed or deleted these
/*  
     *  
    }  
import org.opensearch.indices.IndicesBitsetFilterCache;
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
    /**
            return Type.HYBRIDFS;  
                public Store newStore(  
     */
    }  
     * @deprecated Use the overload that accepts a {@code dataFormatRegistry} parameter.  
            final Map<String, DataLocalityType> localityTypes = new HashMap<>(values().length);
        return factory;  
import org.opensearch.common.CheckedTriFunction;  
            idFieldDataEnabled,
 * this file be licensed under the Apache-2.0 license or a
            return type;  
        IndicesFieldDataCache indicesFieldDataCache,
    ) {
import org.opensearch.index.similarity.SimilarityService;  
            clusterDefaultMaxMergeAtOnceSupplier
    ) {
        }  
     *   <li>version of OpenSearch when the index was created
        return dataFormatAwareStoreDirectoryFactories.get("default");  
    public static final Setting<String> INDEX_STORE_TYPE_SETTING = new Setting<>(
                case NIOFS:  
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
            return TYPES.containsKey(key);
        NamedWriteableRegistry namedWriteableRegistry,
import org.apache.lucene.index.FilterDirectoryReader;
        final AnalysisRegistry analysisRegistry,  
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig,
                    Directory directory,  
                DEPRECATION_LOGGER.deprecate(type.getSettingsKey(), " is deprecated and will be removed in 2.0");
        IndexService.ShardStoreDeleter shardStoreDeleter,
            environment,  
            "segments_N",
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
     * are maintained for the entire index lifecycle on this node. Once an index is closed or deleted these
        Consumer<IndexShard> replicator,  
    private final EngineConfigFactory engineConfigFactory;
            shardLevelRefreshEnabled,
                indexAnalyzers,
    private final List<IndexingOperationListener> indexOperationListeners = new ArrayList<>();  
        final IndexSettings indexSettings,
    public IndexModule(
            remoteStoreSettings,
import org.opensearch.common.annotation.PublicApi;
    public static Type defaultStoreType(final boolean allowMmap) {
                    );
        Client client,
        if (listener == null) {
            public Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException {
import org.opensearch.common.TriFunction;
        );
        }  
            }
            circuitBreakerService,
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
    private static final IndexStorePlugin.CompositeDirectoryFactory DEFAULT_COMPOSITE_DIRECTORY_FACTORY =  
import org.opensearch.index.engine.EngineConfigFactory;  
        ThreadPool threadPool,
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig,  
 * this work for additional information regarding copyright
            final Map<String, Type> types = new HashMap<>(values().length);  
    );
        ThreadPool threadPool,
 *      {@link #addIndexEventListener(IndexEventListener)}</li>
            for (final Type type : values()) {
        Supplier<Boolean> fixedRefreshIntervalSchedulingEnabled,
            (DataFormatRegistry) null
            environment,
            clusterDefaultMaxMergeAtOnceSupplier,
}  
        final Map<String, IndexStorePlugin.RecoveryStateFactory> recoveryStateFactories,
            indexSettings,
            client,  
import org.opensearch.indices.mapper.MapperRegistry;
                    ShardId shardId,
        DataLocalityType.FULL.name(),
 *      <li>{@link IndexStorePlugin.DirectoryFactory} - Custom {@link IndexStorePlugin.DirectoryFactory} instances can be registered
import java.util.Collections;
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
        public static DataLocalityType getValueOf(final String localityType) {
 * IndexModule represents the central extension point for index level custom implementations like:
        NodeEnvironment environment,
    private final SetOnce<Function<IndexService, CheckedFunction<DirectoryReader, DirectoryReader, IOException>>> indexReaderWrapper =  
            TYPES = Collections.unmodifiableMap(types);
        IndexAnalyzers indexAnalyzers = null;
     *
            }  
            clusterMergeSchedulerConfig,  
            expressionResolver,
import java.util.function.Supplier;
            return new IndexStorePlugin.StoreFactory() {  
     */
        }
    public IndexService newIndexService(  
import org.opensearch.index.shard.IndexEventListener;
                return factory.newFSDirectory(location, lockFactory, indexSettings);
         * Indicates that only a subset of the data will be cached locally  
        Function<IndexService, CheckedFunction<DirectoryReader, DirectoryReader, IOException>> indexReaderWrapperFactory
        FS("fs"),  
        if (key == null || key.isEmpty()) {
        BooleanSupplier idFieldDataEnabled,
 * </ul>
        BigArrays bigArrays,
        }
        NamedXContentRegistry xContentRegistry,  
            indexSettings,  
            idFieldDataEnabled,
        this.compositeDirectoryFactories = Collections.unmodifiableMap(compositeDirectoryFactories);
        ValuesSourceRegistry valuesSourceRegistry,
import org.opensearch.index.cache.query.QueryCache;  
    @ExperimentalApi  
     * Returns the index {@link Settings} for this index  
        MapperRegistry mapperRegistry,  
     * @param indexerFactory      the engine factory  
                queryCache = new DisabledQueryCache(indexSettings);
        false,
     * @param name Name of the SimilarityProvider  
 * the Apache License, Version 2.0 (the "License"); you may
     */
            remoteStoreSettings,  
            indicesFieldDataCache,  
     * Index setting that selects a custom StoreFactory provided by plugins. If empty, the default store is used
            fixedRefreshIntervalSchedulingEnabled,
     *   <li>settings for this similarity
        final IndexStorePlugin.RecoveryStateFactory recoveryStateFactory = getRecoveryStateFactory(indexSettings, recoveryStateFactories);  
    );
import org.opensearch.common.util.BigArrays;
     * relocated to another node the internal representation will be destroyed which includes the registered listeners.
    }
import org.opensearch.index.store.DataFormatAwareStoreDirectoryFactory;
        NodeEnvironment environment,
        ensureNotFrozen();
        public boolean match(IndexSettings settings) {
    /**
            threadPool,  
        Client client,
                remoteStoreSettings,  
    ) {  
        }  
import org.opensearch.index.cache.query.DisabledQueryCache;
        BigArrays bigArrays,  
import org.opensearch.indices.ClusterMergeSchedulerConfig;  
        if (indexEventListeners.contains(listener)) {
 *     {@link IndexModule#SIMILARITY_SETTINGS_PREFIX} prefix along with the "type" value.  For example, to reference the  
            }
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
                    Store.OnClose onClose,
            Collections.emptyMap(),  
            clusterMergeSchedulerConfig,
            mapperRegistry,
                shardLevelRefreshEnabled.get(),
            indicesQueryCache,
 * @opensearch.api
                directoryFactory,
     * Note: an index might be created on a node multiple times. For instance if the last shard from an index is
            recoverySettings,
    }
        return newIndexService(
     * Once the node holds at least one shard of an index all modules are reloaded and listeners are registered again.  
            indexSettings,
        /**
            shardStoreDeleter,  
    /**  
            indexCreationContext,
            throw new IllegalArgumentException("listener already added");  
    public Settings getSettings() {
                }  
            DataFormatAwareEngineFactory,  
            clusterService,
        RecoverySettings recoverySettings,
        public boolean match(Settings settings) {
            null,
    /**
        }
     * Adds a Setting, it's consumer and validator for this index.
        RecoverySettings recoverySettings,
            clusterMergeSchedulerConfig,  
     */
            xContentRegistry,
import org.opensearch.plugins.IndexStorePlugin;
            public Directory newDirectory(IndexSettings indexSettings, ShardPath shardPath) throws IOException {
import java.util.Map;  
        Function.identity(),  
            directoryFactories,
    private final Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories;
        Supplier<TimeValue> clusterDefaultRefreshIntervalSupplier,
        /**
        ScriptService scriptService,  
     * are maintained for the entire index lifecycle on this node. Once an index is closed or deleted these  
            mapperRegistry,
     * Represents the tiering state of the index.
     * @param similarity SimilarityProvider to register
                resolveStoreFactory(indexSettings, storeFactories),
        final Type type;  
    private final NodeCacheService nodeCacheService;  
        this.directoryFactories = Collections.unmodifiableMap(directoryFactories);
            clusterService,
            mapperRegistry,
                shardStoreDeleter,  
        return newIndexService(
 */
        }
        "index.queries.cache.enabled",  
            circuitBreakerService,
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,  
            translogFactorySupplier,
            new EngineBackedIndexerFactory(engineFactory),
        final Boolean allowMmap = NODE_STORE_ALLOW_MMAP.get(indexSettings.getNodeSettings());
     * @opensearch.api
    );
        Property.IndexScope,  
                dataFormatRegistry,  
            fixedRefreshIntervalSchedulingEnabled,  
            s -> {},
                indexerFactory,
     */  
        Consumer<IndexShard> replicator,
        this.recoveryStateFactories = recoveryStateFactories;  
        BigArrays bigArrays,  
            clusterService,
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig,
        this.nodeCacheService = nodeCacheService;
            IndexSettings,
    private static IndexStorePlugin.RecoveryStateFactory getRecoveryStateFactory(  
import java.util.function.Consumer;  
    ) throws IOException {  
     * @param directoryFactories the available store types
import java.util.Objects;
        final CompositeIndexSettings compositeIndexSettings,
    /**
import org.apache.lucene.search.similarities.BM25Similarity;
            client,
        IndexService.ShardStoreDeleter shardStoreDeleter,
        IndicesFieldDataCache indicesFieldDataCache,
                compositeIndexSettings,
        ensureNotFrozen();
    }
    ) {  
        return indexSettings.getIndex();
        this.expressionResolver = expressionResolver;
        IndicesBitsetFilterCache indicesBitsetFilterCache,
    }
    public static final Setting<Boolean> IS_WARM_INDEX_SETTING = Setting.boolSetting("index.warm", false, Property.IndexScope);
import org.opensearch.common.CheckedFunction;
package org.opensearch.index;
                indexCreationContext,
        TieringState.HOT.name(),  
    public void setReaderWrapper(
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
            circuitBreakerService,
        }
            (DataFormatRegistry) null  
                    IndexSettings indexSettings,
 * SPDX-License-Identifier: Apache-2.0
        if (allowMmap && Constants.JRE_IS_64BIT) {
                    factories.put(
     * via {@link FilterDirectoryReader#getDelegate()}.  
            } else {
    private final Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories;
import org.opensearch.repositories.RepositoriesService;  
                idFieldDataEnabled,
        IndexService.ShardStoreDeleter shardStoreDeleter,
    private static IndexStorePlugin.DirectoryFactory getDirectoryFactory(
 *  
    ) throws IOException {
    public IndexService newIndexService(  
        if (this.frozen.compareAndSet(false, true)) {  
import org.opensearch.index.engine.EngineFactory;
        Function.identity(),
            shardStoreDeleter,  
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
            };
         */
        BooleanSupplier idFieldDataEnabled,  
        Supplier<Boolean> shardLevelRefreshEnabled,  
        Consumer<IndexShard> replicator,  
        "index.tiering.state",
import org.opensearch.index.store.FsDirectoryFactory;  
                nodeCacheService
            this(settingsKey, false);
            }
            if (type.isDeprecated()) {  
        HOT_TO_WARM,  
            throw new IllegalArgumentException("setting must not be null");
            Objects.requireNonNull(localityType, "No locality type given.");  
        ValuesSourceRegistry valuesSourceRegistry,
    /**
    ) {
 *      <li>Settings update listener - Custom settings update listener can be registered via  
    public static final String SIMILARITY_SETTINGS_PREFIX = "index.similarity";
            DataFormatAwareStoreDirectoryFactory tiered = dataFormatAwareStoreDirectoryFactories.get(
    }
        Client client,
        Function.identity(),
        RemoteStoreSettings remoteStoreSettings,
                recoverySettings,
     * for example search, and must return a new directory reader wrapping the provided directory reader or if no
     * Index setting which used to determine how the data is cached locally fully or partially.  
    }  
        Property.NodeScope
            valuesSourceRegistry,
            clusterDefaultRefreshIntervalSupplier,
                queryCache,
        NamedXContentRegistry xContentRegistry,  
            clusterDefaultRefreshIntervalSupplier,
    /**
import org.opensearch.index.store.remote.filecache.NodeCacheService;
        final IndexSettings indexSettings,
            replicator,  
            bigArrays,
            xContentRegistry,
                clusterDefaultRefreshIntervalSupplier,
            "dii",  
        final AnalysisRegistry analysisRegistry,  
    /**  
            valuesSourceRegistry,
import org.opensearch.core.index.shard.ShardId;  
        MapperRegistry mapperRegistry,  
     */
        ValuesSourceRegistry valuesSourceRegistry,  
        public static Type fromSettingsKey(final String key) {
    IndexEventListener freeze() { // pkg private for testing
            bigArrays,
            throw new IllegalArgumentException("setting must not be null");  
            translogFactorySupplier,  
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,  
     *  
            recoverySettings,  
        ThreadPool threadPool,
        Property.PrivateIndex  
            },
            }  
            factory = compositeDirectoryFactories.get(compositeStoreType);
    /**
    private final IndexNameExpressionResolver expressionResolver;
 */  
     * listeners go out of scope.
        final String key = indexSettings.getValue(INDEX_STORE_FACTORY_SETTING);
            namedWriteableRegistry,
    }
     * Listeners can't be unregistered they will stay alive for the entire time the index is allocated on a node.  
                    ShardPath shardPath  
            analysisRegistry.build(indexSettings),
            idFieldDataEnabled,  
            scriptService,
    /**  
        ScriptService scriptService  
        "",
        CircuitBreakerService circuitBreakerService,
    public static final Setting<String> INDEX_COMPOSITE_STORE_TYPE_SETTING = new Setting<>(
        FileCache remoteStoreFileCache  
    }  
        RecoverySettings recoverySettings,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.common.annotation.ExperimentalApi;  
     */  
        Type(final String settingsKey, final boolean deprecated) {
        if (indexSettings.isWarmIndex() && indexSettings.isPluggableDataFormatEnabled()) {
                throw new IllegalArgumentException("no matching store type for [" + key + "]");
        public String getSettingsKey() {
        ensureNotFrozen();
import org.opensearch.index.store.DefaultCompositeDirectoryFactory;
        Function<ShardId, ReplicationStats> segmentReplicationStatsProvider,
            LOCALITY_TYPES = Collections.unmodifiableMap(localityTypes);
 */  
     * relocated to another node the internal representation will be destroyed which includes the registered listeners.
        }
        try {
        ThreadPool threadPool,
import java.util.function.BooleanSupplier;
     * Adds an {@link IndexingOperationListener} for this index. All listeners added here  
        this.storeFactories = storeFactories;
            throw new IllegalStateException("Can't modify IndexModule once the index service has been created");
import org.opensearch.index.shard.IndexingOperationListener;  
import org.opensearch.index.analysis.IndexAnalyzers;  
        for (Type type : Type.values()) {  
                clusterMergeSchedulerConfig,
    private final Map<String, IndexStorePlugin.StoreFactory> storeFactories;
                throw new IllegalArgumentException("Unknown store type [" + storeType + "]");
        );
            );
                    Store.OnClose onClose,
        Property.NodeScope
            return Type.NIOFS;
            circuitBreakerService,  
            return DEFAULT_RECOVERY_STATE_FACTORY;
        CircuitBreakerService circuitBreakerService,  
import org.opensearch.index.store.Store;
        this(
     * Registers the given {@link Similarity} with the given name.
            "cfe",
                eventListener,  
                @Override
        "index.store.preload",  
    public Index getIndex() {  
    /**  
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,  
    public void addSimilarity(String name, TriFunction<Settings, Version, ScriptService, Similarity> similarity) {  
    public IndexService newIndexService(  
            shardLevelRefreshEnabled,  
     * The returned reader is closed once it goes out of scope.
    ) throws IOException {
    private final BooleanSupplier allowExpensiveQueries;  
        }  
import org.opensearch.index.translog.TranslogFactory;
            "pos",
            "nvm",
            clusterDefaultMaxMergeAtOnceSupplier,
            MapperService,
                localityTypes.put(dataLocalityType.name(), dataLocalityType);  
    }
        this.indexOperationListeners.add(new IndexingSlowLog(indexSettings));  
        this.searchOperationListeners.add(new SearchSlowLog(indexSettings));
        Function.identity(),
import java.util.HashSet;  
    );  
/**
        private static final Map<String, Type> TYPES;  
            scriptService,  
    /** On which extensions to load data into the file-system cache upon opening of files.
            indicesFieldDataCache,  
    IndexerFactory getIndexerFactory() {  
            return new CompositeIndexEventListener(indexSettings, indexEventListeners);
            environment,
     */
import org.opensearch.index.engine.exec.IndexerFactory;
            throw new IllegalArgumentException("listener must not be null");  
        );
        final Map<String, IndexStorePlugin.CompositeDirectoryFactory> compositeDirectoryFactories,
    ) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.indices.IndicesQueryCache;
    public <T> void addSettingsUpdateConsumer(Setting<T> setting, Consumer<T> consumer) {
        private static final Map<String, DataLocalityType> LOCALITY_TYPES;
            IOException> dataFormatAwareEngineFactorySupplier
                indexSettings,
import org.opensearch.storage.directory.TieredDataFormatAwareStoreDirectoryFactory;  
    @PublicApi(since = "1.0.0")  
                indexOperationListeners,  
    ) {  
     */
                case MMAPFS:
        }
         */
            this.settingsKey = settingsKey;
        ValuesSourceRegistry valuesSourceRegistry,
        RemoteStoreSettings remoteStoreSettings,
        if (listener == null) {
            throw new IllegalArgumentException("similarity for name: [" + name + " is already registered");  
        }  
            clusterDefaultRefreshIntervalSupplier,  
    public IndexService newIndexService(  
        final Map<String, IndexStorePlugin.DirectoryFactory> directoryFactories,  
        Client client,
import org.opensearch.index.cache.query.IndexQueryCache;
            remoteDirectoryFactory,  
    ) {  
            }
        CircuitBreakerService circuitBreakerService,
import java.util.function.BiFunction;
        CircuitBreakerService circuitBreakerService,
    public IndexService newIndexService(
        List.of(  
import org.apache.lucene.index.DirectoryReader;
        IndicesFieldDataCache indicesFieldDataCache,
            mapperRegistry,
     *  best-effort only. */
    private static IndexStorePlugin.CompositeDirectoryFactory getCompositeDirectoryFactory(
        indexSettings.getScopedSettings().addSettingsUpdateConsumer(setting, consumer);  
         */  
        }  
            return match(settings.getSettings());  
         * object contains an {@link #INDEX_STORE_TYPE_SETTING} set to the value of this type.  
    }  
        ClusterMergeSchedulerConfig clusterMergeSchedulerConfig  
        static {
            throw new IllegalArgumentException("listener must not be null");
        eventListener.beforeIndexCreated(indexSettings.getIndex(), indexSettings.getSettings());
        NamedXContentRegistry xContentRegistry,
        }
            "fdx",  
        CircuitBreakerService circuitBreakerService,
    ) throws IOException {
            @Override
    ) {
     * Overload retained for binary compatibility; delegates with no pluggable data format registry.
            segmentReplicationStatsProvider,
            remoteStoreSettings,
     * relocated to another node the internal representation will be destroyed which includes the registered listeners.  
            xContentRegistry,
        ThreadPool threadPool,
        }  
        ClusterService clusterService,  
        Consumer<IndexShard> replicator,  
            if (success == false) {
         * Indicates that all the data will be cached locally
            return indexService;
     * </p>
        /**
            return null;
                IOUtils.closeWhileHandlingException(queryCache, indexAnalyzers);
        ensureNotFrozen();  
         */
        HOT,
        Property.NodeScope
@PublicApi(since = "1.0.0")  
    ) throws IOException {
        Supplier<Boolean> shardLevelRefreshEnabled,  
                        new RemoteSnapshotDirectoryFactory(repositoriesService, threadPool, remoteStoreFileCache)  
        } else {
        Property.IndexScope,  
     * wrapping was performed the provided directory reader.  
        CheckedTriFunction<
        final Map<String, DataFormatAwareStoreDirectoryFactory> dataFormatAwareStoreDirectoryFactories
                client,  
        DataLocalityType::getValueOf,
        }
    public static final Setting<String> INDEX_STORE_FACTORY_SETTING = new Setting<>(  
        }
        "default",  
                @Override
import java.util.function.Function;
import org.opensearch.index.engine.exec.DataFormatAwareEngineFactory;  
 * specific language governing permissions and limitations
import java.io.IOException;
        "index.store.hybrid.nio.extensions",
        BiFunction<IndexSettings, ShardRouting, TranslogFactory> translogFactorySupplier,  
            fixedRefreshIntervalSchedulingEnabled,
        "index.recovery.type",
            allowExpensiveQueries,  
    private final IndexSettings indexSettings;
        final EngineConfigFactory engineConfigFactory,
            compositeDirectoryFactories  
        final Map<String, IndexStorePlugin.DirectoryFactory> indexStoreFactories  
        QueryCache queryCache = null;
            factory = indexStoreFactories.get(storeType);  
    }
     * @deprecated Use the overload that accepts {@code indicesBitsetFilterCache} and {@code dataFormatRegistry} parameters.  
     *  
 * software distributed under the License is distributed on an
            threadPool,  
    private static final IndexStorePlugin.RecoveryStateFactory DEFAULT_RECOVERY_STATE_FACTORY = RecoveryState::new;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }  
        }
 *     {@link BM25Similarity}, the configuration {@code "index.similarity.my_similarity.type : "BM25"} can be used.</li>
            throw new IllegalStateException("already frozen");  
