                parameters.add(contribution.factory().get());
    }
                ParquetSettings.WRITE_POOL_MIN,
            return Map.of();
import org.opensearch.parquet.bridge.RustBridge;  
        IndexScopedSettings indexScopedSettings,  
                ParquetSettings.MERGE_POOL_MIN,  
    private ThreadPool threadPool;
 * there. The plugin stays purely declarative.
    public List<RestHandler> getRestHandlers(
            engineConfig.indexSettings(),
    }
                newMax -> nativeAllocator.setPoolLimit(ParquetSettings.POOL_MERGE, newMax)  
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
import org.opensearch.parquet.stats.transport.ParquetNodeStatsTransportAction;
        ThreadPool threadPool,  
import org.opensearch.repositories.RepositoriesService;
            );
        return Collections.emptyList();
     * Current parquet writer format version, long-encoded (plugin-defined namespace; the  
            nativeAllocator.addStatsRefresher(() -> {
 * {@link ParquetIndexingEngine} instances created in {@link #indexingEngine}.
    private record ParameterContribution(Set<String> contentTypes, Supplier<ParametrizedFieldMapper.Parameter<?>> factory) {
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
                mergePool.updateStats(s[4], s[5]);
package org.opensearch.parquet;
    public DataFormat getDataFormat() {
    /** Initialized to EMPTY to avoid NPE if indexingEngine() is called before createComponents(). */  
import org.opensearch.rest.RestHandler;  
import org.opensearch.parquet.stats.transport.ParquetNodeStatsRestAction;  
            ParquetDataFormat.PARQUET_DATA_FORMAT_NAME,
    }
    public List<ParametrizedFieldMapper.Parameter<?>> getPluginMappingParameters(
            // ArrowNativeAllocator.tryOverCommitToken based on node-level native memory pressure; the  
        // Hand the node thread pool to the stats provider so per-node stats can read the live
        String contentType,  
                ParquetSettings.POOL_WRITE,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * this file be licensed under the Apache-2.0 license or a
     */  
    public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(IndexSettings indexSettings, DataFormatRegistry registry) {  
    ) {
        this.nativeAllocator = pluginComponentRegistry.getComponent(ArrowNativeAllocator.class).orElse(null);  
     * All mapping parameters this plugin contributes. Each entry declares the field content types it applies to,
            }
    }  
        );
 * routing directory events, and closing native resources are all handled  
            )
            () -> ArrowSchemaBuilder.getSchema(engineConfig.mapperService()),
        // low_cardinality: when true, disables Lucene indexing (via side effect) and enables a Parquet column bloom filter.  
import org.opensearch.index.IndexSettings;  
 * OpenSearch plugin providing the Parquet data format for indexing operations.
import org.opensearch.plugins.PluginComponentRegistry;  
        new ParameterContribution(
                false,  
     */
            )  
                ParquetSettings.WRITE_POOL_MAX,  
import org.opensearch.common.settings.IndexScopedSettings;
/*  
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.common.settings.Setting;
import org.opensearch.index.engine.dataformat.DataFormatPlugin;  
            threadPool,
                    if (Boolean.TRUE.equals(enabled)) {
        return List.of(
import org.opensearch.common.inject.Module;
import org.opensearch.transport.client.Client;
        } else {  
            NativeAllocator.VirtualPoolHandle mergePool = nativeAllocator.registerVirtualPool(
import org.opensearch.core.action.ActionResponse;  
        ClusterSettings clusterSettings,
    @Override
                ParquetSettings.MERGE_POOL_MIN.get(this.settings),  
                PARQUET_THREAD_POOL_NAME,
            ParquetStatsProvider.getInstance().setThreadPool(threadPool);
            cs.addSettingsUpdateConsumer(
        return List.of();
}
            // returned token is echoed back on release so the exact grant is freed.
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {  
                writeMax,  
import org.opensearch.watcher.ResourceWatcherService;  
        return List.of(
                ParquetSettings.MERGE_POOL_MAX,
                long[] s = RustBridge.getPoolStats();
        Settings settings,  
            new ActionHandler<>(ParquetNodeStatsActionType.INSTANCE, ParquetNodeStatsTransportAction.class)  
     *
     *                     building, so a new instance must be produced for each field being parsed
import org.opensearch.parquet.fields.ArrowSchemaBuilder;  
    @Override  
    public static final int PARQUET_THREAD_POOL_QUEUE_SIZE = 10_000;  
    public Collection<IndexCreationValidator> getIndexCreationValidators() {
                (builder, enabled) -> {
    ) {  
        Supplier<RepositoriesService> repositoriesServiceSupplier,
                }
    public static final String PARQUET_THREAD_POOL_NAME = "parquet_native_write";
        // parquet_native_write pool (queue depth / active / rejected).
import org.opensearch.env.Environment;  
public class ParquetDataFormatPlugin extends Plugin implements DataFormatPlugin, ActionPlugin {  
import org.opensearch.arrow.spi.NativeAllocator;  
        return List.of(new ParquetIndexCreationValidator());
 *
                ParquetSettings.POOL_MERGE,
 * <p>For tiered storage, returns a {@link ParquetStoreStrategy} from  
        PluginComponentRegistry pluginComponentRegistry  
                settings,  
import org.opensearch.plugins.ActionPlugin.ActionHandler;
            cs.addSettingsUpdateConsumer(  
            engineConfig.checksumStrategies().get(ParquetDataFormat.PARQUET_DATA_FORMAT_NAME),  
import org.opensearch.common.settings.ClusterSettings;  
import org.opensearch.threadpool.ThreadPool;
            cs.addSettingsUpdateConsumer(
    public Map<DataFormat, StoreStrategy> getStoreStrategies(IndexSettings indexSettings, DataFormatRegistry registry) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
                newMin -> nativeAllocator.setPoolMin(ParquetSettings.POOL_WRITE, newMin)
            cs.addSettingsUpdateConsumer(
    private ArrowNativeAllocator nativeAllocator;  
        return new ParquetIndexingEngine(  
            // reservation consults this decider (an FFM upcall); the decision runs in
            cs.addSettingsUpdateConsumer(ParquetSettings.MERGE_POOL_MAX, newMax -> RustBridge.setMergePoolLimit(newMax));
import org.opensearch.index.mapper.TextFieldMapper;
import org.opensearch.parquet.engine.ParquetDataFormat;
                OpenSearchExecutors.allocatedProcessors(settings),
import org.opensearch.index.mapper.ParametrizedFieldMapper;  
            () -> ParametrizedFieldMapper.SideEffectParameter.boolParam(  
        return Map.of(parquetFormat, storeStrategy);
        if (ParquetStatsProvider.getInstance() != null) {  
        ScriptService scriptService,
import org.opensearch.parquet.stats.transport.ParquetNodeStatsActionType;
        this.settings = clusterService.getSettings();
                        builder.setParameterValue("index", false);  
        DataFormatRegistry dataFormatRegistry
        // Register virtual pools if allocator is available (arrow-base loaded)
        RustBridge.initMemoryPools(writeMax, mergeMax);
        // and transport-action layers attempt lookups.  
    @Override
                newLimit -> RustBridge.setWritePoolLimit(newLimit)
import org.opensearch.threadpool.ExecutorBuilder;
    @Override  
import org.opensearch.index.mapper.KeywordFieldMapper;
 */
                PoolGroup.INDEXING,
        ClusterService clusterService,
    public Collection<Module> createGuiceModules() {
import java.util.Map;  
import java.util.ArrayList;
        NamedXContentRegistry xContentRegistry,  
        }
    /**
     * encoding happens to reuse {@code major * 1_000_000 + minor * 1_000 + patch} but is
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        return Map.of(
    }
            );
        for (ParameterContribution contribution : CONTRIBUTIONS) {
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {  
    }
                writePool.updateStats(s[1], s[2]);  
import org.opensearch.script.ScriptService;
                ParquetSettings.LOW_CARDINALITY_PARAM,
                PoolGroup.MERGE,
            });
     */
    private Settings settings = Settings.EMPTY;
    private static final List<ParameterContribution> CONTRIBUTIONS = List.of(
     */  
    public ParquetDataFormatPlugin() {}  
import org.opensearch.parquet.store.ParquetStoreStrategy;
     * a multibinding entry so the composite-engine plugin can discover this provider via  
    @Override
        );  
    }
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
        if (parquetFormat == null) {
     * @param factory      creates a fresh parameter instance per invocation; parameters are stateful during mapper
            );  
import org.opensearch.threadpool.FixedExecutorBuilder;  
        ResourceWatcherService resourceWatcherService,
    public List<Setting<?>> getSettings() {
            ClusterSettings cs = clusterService.getClusterSettings();
        Client client,
        long writeMax = ParquetSettings.WRITE_POOL_MAX.get(this.settings);  
 * compatible open source license.
        return List.copyOf(parameters);
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.index.engine.dataformat.StoreStrategy;
    }  
    }
import java.util.Collection;  
        // Initialize native write/merge memory pools
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;  
    }
    @Override
            () -> engineConfig.mapperService().documentMapper().getVersion(),
            nativeAllocator
        // Eagerly construct the provider so the registry is populated before the engine
 */  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    public static final long PARQUET_FORMAT_VERSION = 1_000_000L; // 1.0.0
    /**  
            () -> ParquetSettings.getLowCardinalityEnabledFields(engineConfig.mapperService()),  
import org.opensearch.parquet.stats.transport.ParquetStatsRestAction;  
    /** Thread pool name for background native Parquet writes during VSR rotation. */  
    @Override
            PARQUET_DATA_FORMAT,
        return ParquetSettings.getSettings();  
                PARQUET_THREAD_POOL_QUEUE_SIZE,  
import org.opensearch.cluster.service.ClusterService;
        }  
        )
     * Constructs the {@link ParquetStatsProvider} eagerly so engines can self-register their
 *
                newLimit -> RustBridge.setMergePoolLimit(newLimit)  
                newMin -> nativeAllocator.setPoolMin(ParquetSettings.POOL_MERGE, newMin)
import org.opensearch.arrow.spi.PoolGroup;
import org.opensearch.rest.RestController;
            // No allocator — wire dynamic consumers directly to Rust pools
import java.util.List;
                newMax -> nativeAllocator.setPoolLimit(ParquetSettings.POOL_WRITE, newMax)
import org.opensearch.common.settings.Settings;  
    @Override
    }  
            );
        List<ParametrizedFieldMapper.Parameter<?>> parameters = new ArrayList<>();
        RestController restController,
 * construction of per-shard native registries, seeding from remote metadata,
 * OpenSearch's data format framework. On node startup, captures cluster
            if (contribution.contentTypes().contains(contentType)) {  
import org.opensearch.parquet.stats.transport.ParquetStatsTransportAction;
import org.opensearch.index.store.PrecomputedChecksumStrategy;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * <p>Implements {@link DataFormatPlugin} to register the Parquet format with
import org.opensearch.parquet.engine.ParquetIndexingEngine;
import org.opensearch.plugins.ActionPlugin;  
    @Override
                    }
 * settings via {@link #createComponents} and passes them to the per-shard  
    /** Creates a new ParquetDataFormatPlugin. */
 * The OpenSearch Contributors require contributions made to  
     * so contributing another parameter (for the same or different field types) is a single additional entry.  
 * SPDX-License-Identifier: Apache-2.0
    @Override
            ClusterSettings cs = clusterService.getClusterSettings();
        IndexSettings indexSettings,
    }  
        Supplier<DiscoveryNodes> nodesInCluster  
    }
        return PARQUET_DATA_FORMAT;  
import org.opensearch.parquet.stats.transport.ParquetStatsActionType;
        DataFormat parquetFormat = registry.format(ParquetDataFormat.PARQUET_DATA_FORMAT_NAME);  
            settings,
            // Wire dynamic setting consumers via allocator  
        }
import java.util.Set;
    );
            RustBridge.registerOverCommitCallbacks(nativeAllocator::tryOverCommitToken, nativeAllocator::releaseOverCommitToken);
    @Override
import org.opensearch.action.ActionRequest;
                false,
 *  
        Environment environment,
import java.util.function.Supplier;
     * trackers via the static {@code getInstance()} accessor at construction time. Also adds
        );
        this.threadPool = threadPool;  
                "thread_pool." + PARQUET_THREAD_POOL_NAME
     * NOT a Lucene version — do not compare to Lucene-encoded versions).
                ParquetSettings.WRITE_POOL_MIN.get(this.settings),
            engineConfig.store().shardPath(),  
     * {@code Set<DataFormatStatsProvider>} injection without naming parquet directly.
            );
import org.opensearch.index.engine.dataformat.DataFormat;
import org.opensearch.plugins.Plugin;
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig engineConfig) {
    public static final ParquetDataFormat PARQUET_DATA_FORMAT = new ParquetDataFormat();
        new ParquetStatsProvider();
        SettingsFilter settingsFilter,
        NamedWriteableRegistry namedWriteableRegistry,  
        NodeEnvironment nodeEnvironment,
    /**
            NativeAllocator.VirtualPoolHandle writePool = nativeAllocator.registerVirtualPool(  
    public Collection<Object> createComponents(  
import org.opensearch.index.IndexCreationValidator;
            new ActionHandler<>(ParquetStatsActionType.INSTANCE, ParquetStatsTransportAction.class),
    ) {
import org.opensearch.cluster.node.DiscoveryNodes;  
            () -> new DataFormatDescriptor(ParquetDataFormat.PARQUET_DATA_FORMAT_NAME, new PrecomputedChecksumStrategy())  
            // Wire the over-commit decision to the allocator. When a native pool is full, the Rust
        if (nativeAllocator != null) {
 * {@link #getStoreStrategies}. The composite store layer takes it from there —
        return List.of(new ParquetStatsRestAction(), new ParquetNodeStatsRestAction());
            Set.of(KeywordFieldMapper.CONTENT_TYPE, TextFieldMapper.CONTENT_TYPE),
import java.util.Collections;
    private static final StoreStrategy storeStrategy = new ParquetStoreStrategy();
     * @param contentTypes the core field content types (e.g. {@code keyword}, {@code text}) the parameter applies to  
        }  
    /**  
import org.opensearch.common.settings.SettingsFilter;
            new FixedExecutorBuilder(
        );
/**
import org.opensearch.env.NodeEnvironment;
            cs.addSettingsUpdateConsumer(ParquetSettings.WRITE_POOL_MAX, newMax -> RustBridge.setWritePoolLimit(newMax));  
            );  
        long mergeMax = ParquetSettings.MERGE_POOL_MAX.get(this.settings);
     * A mapping parameter this plugin contributes, paired with the field content types it applies to.
    @Override
import org.opensearch.parquet.stats.ParquetStatsProvider;
                mergeMax,
