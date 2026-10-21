            engineConfig.indexSettings(),
    public Collection<Module> createGuiceModules() {
            ParquetDataFormat.PARQUET_DATA_FORMAT_NAME,
        return ParquetSettings.getSettings();
    @Override
    ) {
        return List.of();
                mergePool.updateStats(s[4], s[5]);
import org.opensearch.index.engine.dataformat.IndexingEngineConfig;
            PARQUET_DATA_FORMAT,
 * settings via {@link #createComponents} and passes them to the per-shard
import org.opensearch.parquet.stats.ParquetStatsProvider;
import org.opensearch.common.settings.IndexScopedSettings;
    public List<Setting<?>> getSettings() {
        Client client,
     * Current parquet writer format version, long-encoded (plugin-defined namespace; the
import org.opensearch.parquet.engine.ParquetDataFormat;
import org.opensearch.common.inject.Module;
            new ActionHandler<>(ParquetStatsActionType.INSTANCE, ParquetStatsTransportAction.class),
                }
        if (ParquetStatsProvider.getInstance() != null) {
import org.opensearch.script.ScriptService;
import org.opensearch.action.ActionRequest;
import org.opensearch.plugins.PluginComponentRegistry;
import org.opensearch.index.mapper.TextFieldMapper;
     * Constructs the {@link ParquetStatsProvider} eagerly so engines can self-register their
package org.opensearch.parquet;
            () -> ParametrizedFieldMapper.SideEffectParameter.boolParam(
            cs.addSettingsUpdateConsumer(ParquetSettings.MERGE_POOL_MAX, newMax -> RustBridge.setMergePoolLimit(newMax));
     */
            settings,
/*
    /**
                PARQUET_THREAD_POOL_NAME,
    @Override
import org.opensearch.core.xcontent.NamedXContentRegistry;
    public IndexingExecutionEngine<?, ?> indexingEngine(IndexingEngineConfig engineConfig) {
                settings,
    public Collection<Object> createComponents(
import org.opensearch.index.engine.dataformat.DataFormat;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    private static final StoreStrategy storeStrategy = new ParquetStoreStrategy();
    }
     * so contributing another parameter (for the same or different field types) is a single additional entry.
        return List.of(
import org.opensearch.arrow.spi.PoolGroup;
    @Override
 * {@link #getStoreStrategies}. The composite store layer takes it from there —
        }
            );
    /**
            Set.of(KeywordFieldMapper.CONTENT_TYPE, TextFieldMapper.CONTENT_TYPE),
        } else {
    }
    @Override
    private ArrowNativeAllocator nativeAllocator;
            );
    public static final String PARQUET_THREAD_POOL_NAME = "parquet_native_write";
    ) {
 *
        return new ParquetIndexingEngine(
            new ActionHandler<>(ParquetNodeStatsActionType.INSTANCE, ParquetNodeStatsTransportAction.class)
    public Collection<IndexCreationValidator> getIndexCreationValidators() {
    @Override
public class ParquetDataFormatPlugin extends Plugin implements DataFormatPlugin, ActionPlugin {
import org.opensearch.cluster.node.DiscoveryNodes;
    public DataFormat getDataFormat() {
            () -> ArrowSchemaBuilder.getSchema(engineConfig.mapperService()),
        );
import org.opensearch.parquet.stats.transport.ParquetStatsRestAction;
     */
import org.opensearch.env.Environment;
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        return Collections.emptyList();
        // parquet_native_write pool (queue depth / active / rejected).
        new ParquetStatsProvider();
        long writeMax = ParquetSettings.WRITE_POOL_MAX.get(this.settings);
     */
        NamedWriteableRegistry namedWriteableRegistry,
import java.util.List;
        return PARQUET_DATA_FORMAT;
    @Override
 */
import org.opensearch.watcher.ResourceWatcherService;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * this file be licensed under the Apache-2.0 license or a
/**
                OpenSearchExecutors.allocatedProcessors(settings),
     *                     building, so a new instance must be produced for each field being parsed
        DataFormatRegistry dataFormatRegistry
import java.util.Collections;
                newLimit -> RustBridge.setWritePoolLimit(newLimit)
                newMax -> nativeAllocator.setPoolLimit(ParquetSettings.POOL_WRITE, newMax)
        NamedXContentRegistry xContentRegistry,
            // reservation consults this decider (an FFM upcall); the decision runs in
     * a multibinding entry so the composite-engine plugin can discover this provider via
                ParquetSettings.MERGE_POOL_MIN.get(this.settings),
        )
        }
    public Map<String, Supplier<DataFormatDescriptor>> getFormatDescriptors(IndexSettings indexSettings, DataFormatRegistry registry) {
                PoolGroup.MERGE,
     * A mapping parameter this plugin contributes, paired with the field content types it applies to.
     * {@code Set<DataFormatStatsProvider>} injection without naming parquet directly.
import org.opensearch.parquet.store.ParquetStoreStrategy;
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
            return Map.of();
import org.opensearch.index.mapper.KeywordFieldMapper;
import java.util.Set;
import org.opensearch.repositories.RepositoriesService;
        ScriptService scriptService,
            );
 * SPDX-License-Identifier: Apache-2.0
        this.nativeAllocator = pluginComponentRegistry.getComponent(ArrowNativeAllocator.class).orElse(null);
     */
        if (parquetFormat == null) {
            cs.addSettingsUpdateConsumer(
        // Register virtual pools if allocator is available (arrow-base loaded)
                ParquetSettings.LOW_CARDINALITY_PARAM,
        long mergeMax = ParquetSettings.MERGE_POOL_MAX.get(this.settings);
import org.opensearch.parquet.stats.transport.ParquetStatsActionType;
        return List.of(new ParquetIndexCreationValidator());
    /**
        RestController restController,
        return List.copyOf(parameters);
                writePool.updateStats(s[1], s[2]);
                PARQUET_THREAD_POOL_QUEUE_SIZE,
                parameters.add(contribution.factory().get());
            )
        Environment environment,
                PoolGroup.INDEXING,
    public List<ParametrizedFieldMapper.Parameter<?>> getPluginMappingParameters(
        ClusterService clusterService,
    public static final ParquetDataFormat PARQUET_DATA_FORMAT = new ParquetDataFormat();
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.parquet.engine.ParquetIndexingEngine;
import org.opensearch.plugins.ActionPlugin;
 *
import org.opensearch.parquet.stats.transport.ParquetNodeStatsActionType;
        IndexNameExpressionResolver indexNameExpressionResolver,
            RustBridge.registerOverCommitCallbacks(nativeAllocator::tryOverCommitToken, nativeAllocator::releaseOverCommitToken);
import org.opensearch.index.engine.dataformat.DataFormatPlugin;
    /** Thread pool name for background native Parquet writes during VSR rotation. */
        // low_cardinality: when true, disables Lucene indexing (via side effect) and enables a Parquet column bloom filter.
        IndexNameExpressionResolver indexNameExpressionResolver,
            );
import org.opensearch.env.NodeEnvironment;
    @Override
        new ParameterContribution(
import org.opensearch.index.IndexCreationValidator;
    /** Initialized to EMPTY to avoid NPE if indexingEngine() is called before createComponents(). */
            () -> new DataFormatDescriptor(ParquetDataFormat.PARQUET_DATA_FORMAT_NAME, new PrecomputedChecksumStrategy())
            () -> engineConfig.mapperService().documentMapper().getVersion(),
     * @param contentTypes the core field content types (e.g. {@code keyword}, {@code text}) the parameter applies to
            NativeAllocator.VirtualPoolHandle writePool = nativeAllocator.registerVirtualPool(
     * All mapping parameters this plugin contributes. Each entry declares the field content types it applies to,
    }
                ParquetSettings.WRITE_POOL_MAX,
                newMax -> nativeAllocator.setPoolLimit(ParquetSettings.POOL_MERGE, newMax)
    }
                "thread_pool." + PARQUET_THREAD_POOL_NAME
     * trackers via the static {@code getInstance()} accessor at construction time. Also adds
 * The OpenSearch Contributors require contributions made to
    }
    }
import java.util.function.Supplier;
import org.opensearch.transport.client.Client;
    }
        ClusterSettings clusterSettings,
import java.util.ArrayList;
            // returned token is echoed back on release so the exact grant is freed.
        // Hand the node thread pool to the stats provider so per-node stats can read the live
                ParquetSettings.POOL_MERGE,
            }
        return Map.of(parquetFormat, storeStrategy);
    private Settings settings = Settings.EMPTY;
                (builder, enabled) -> {
import org.opensearch.common.settings.SettingsFilter;
            nativeAllocator.addStatsRefresher(() -> {
        RustBridge.initMemoryPools(writeMax, mergeMax);
            // No allocator — wire dynamic consumers directly to Rust pools
        this.settings = clusterService.getSettings();
                        builder.setParameterValue("index", false);
import org.opensearch.index.store.PrecomputedChecksumStrategy;
        for (ParameterContribution contribution : CONTRIBUTIONS) {
                ParquetSettings.POOL_WRITE,
 * compatible open source license.
import org.opensearch.index.mapper.ParametrizedFieldMapper;
 * <p>For tiered storage, returns a {@link ParquetStoreStrategy} from
    public static final int PARQUET_THREAD_POOL_QUEUE_SIZE = 10_000;
            });
 * OpenSearch plugin providing the Parquet data format for indexing operations.
            engineConfig.checksumStrategies().get(ParquetDataFormat.PARQUET_DATA_FORMAT_NAME),
            cs.addSettingsUpdateConsumer(
import java.util.Map;
    public static final long PARQUET_FORMAT_VERSION = 1_000_000L; // 1.0.0
        List<ParametrizedFieldMapper.Parameter<?>> parameters = new ArrayList<>();
import org.opensearch.parquet.bridge.RustBridge;
    private static final List<ParameterContribution> CONTRIBUTIONS = List.of(
import org.opensearch.cluster.service.ClusterService;
    @Override
        // Initialize native write/merge memory pools
import org.opensearch.common.settings.Settings;
            if (contribution.contentTypes().contains(contentType)) {
import org.opensearch.index.IndexSettings;
        );
        String contentType,
import org.opensearch.parquet.stats.transport.ParquetNodeStatsRestAction;
import org.opensearch.rest.RestHandler;
    ) {
        PluginComponentRegistry pluginComponentRegistry
    /**
    public ParquetDataFormatPlugin() {}
                newMin -> nativeAllocator.setPoolMin(ParquetSettings.POOL_MERGE, newMin)
import org.opensearch.rest.RestController;
 * <p>Implements {@link DataFormatPlugin} to register the Parquet format with
            engineConfig.store().shardPath(),
    @Override
 * there. The plugin stays purely declarative.
    public Map<DataFormat, StoreStrategy> getStoreStrategies(IndexSettings indexSettings, DataFormatRegistry registry) {
import java.util.Collection;
                ParquetSettings.WRITE_POOL_MIN.get(this.settings),
            // Wire dynamic setting consumers via allocator
import org.opensearch.common.settings.Setting;
import org.opensearch.threadpool.ThreadPool;
        DataFormat parquetFormat = registry.format(ParquetDataFormat.PARQUET_DATA_FORMAT_NAME);
import org.opensearch.core.action.ActionResponse;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
 * routing directory events, and closing native resources are all handled
 * construction of per-shard native registries, seeding from remote metadata,
                writeMax,
            ClusterSettings cs = clusterService.getClusterSettings();
        Settings settings,
        }
            cs.addSettingsUpdateConsumer(
        );
            );
        SettingsFilter settingsFilter,
        this.threadPool = threadPool;
            NativeAllocator.VirtualPoolHandle mergePool = nativeAllocator.registerVirtualPool(
    /** Creates a new ParquetDataFormatPlugin. */
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
            // Wire the over-commit decision to the allocator. When a native pool is full, the Rust
import org.opensearch.arrow.spi.NativeAllocator;
    }
                long[] s = RustBridge.getPoolStats();
}
            threadPool,
    }
            cs.addSettingsUpdateConsumer(
    }
            ParquetStatsProvider.getInstance().setThreadPool(threadPool);
            // ArrowNativeAllocator.tryOverCommitToken based on node-level native memory pressure; the
                ParquetSettings.MERGE_POOL_MIN,
        NodeEnvironment nodeEnvironment,
    @Override
import org.opensearch.threadpool.ExecutorBuilder;
                newLimit -> RustBridge.setMergePoolLimit(newLimit)
        ResourceWatcherService resourceWatcherService,
            ClusterSettings cs = clusterService.getClusterSettings();
                newMin -> nativeAllocator.setPoolMin(ParquetSettings.POOL_WRITE, newMin)
            nativeAllocator
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
    }
 * OpenSearch's data format framework. On node startup, captures cluster
            )
    }
            new FixedExecutorBuilder(
                    if (Boolean.TRUE.equals(enabled)) {
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
 */
                false,
import org.opensearch.plugins.ActionPlugin.ActionHandler;
            );
            () -> ParquetSettings.getLowCardinalityEnabledFields(engineConfig.mapperService()),
     * @param factory      creates a fresh parameter instance per invocation; parameters are stateful during mapper
        return List.of(
    private record ParameterContribution(Set<String> contentTypes, Supplier<ParametrizedFieldMapper.Parameter<?>> factory) {
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
        ThreadPool threadPool,
import org.opensearch.parquet.stats.transport.ParquetStatsTransportAction;
    private ThreadPool threadPool;
 * {@link ParquetIndexingEngine} instances created in {@link #indexingEngine}.
        if (nativeAllocator != null) {
import org.opensearch.index.engine.dataformat.StoreStrategy;
        }
        Supplier<RepositoriesService> repositoriesServiceSupplier,
import org.opensearch.parquet.stats.transport.ParquetNodeStatsTransportAction;
                false,
            cs.addSettingsUpdateConsumer(ParquetSettings.WRITE_POOL_MAX, newMax -> RustBridge.setWritePoolLimit(newMax));
 *
    public List<RestHandler> getRestHandlers(
                mergeMax,
import org.opensearch.threadpool.FixedExecutorBuilder;
        return List.of(new ParquetStatsRestAction(), new ParquetNodeStatsRestAction());
        IndexScopedSettings indexScopedSettings,
                    }
                ParquetSettings.MERGE_POOL_MAX,
        return Map.of(
    @Override
        // Eagerly construct the provider so the registry is populated before the engine
    );
     *
     * encoding happens to reuse {@code major * 1_000_000 + minor * 1_000 + patch} but is
        Supplier<DiscoveryNodes> nodesInCluster
        );
    }
        // and transport-action layers attempt lookups.
import org.opensearch.plugins.Plugin;
    @Override
        IndexSettings indexSettings,
                ParquetSettings.WRITE_POOL_MIN,
     * NOT a Lucene version — do not compare to Lucene-encoded versions).
import org.opensearch.parquet.fields.ArrowSchemaBuilder;
