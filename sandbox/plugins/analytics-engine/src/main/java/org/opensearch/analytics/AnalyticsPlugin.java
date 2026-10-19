            // transport handlers and is only legal to call once per node).
     * Resolve the node-level shuffle byte budget from {@code percent}% of the JVM max heap and apply
            for (AnalyticsSearchBackendPlugin backend : backends.values()) {
    @Override
    }
        return Math.max(2, Runtime.getRuntime().availableProcessors() / 2);
     *       whenever it can run the stage end-to-end (today: count fast path). Stage ships
        RestController restController,
        int poolSize = schedulerPoolSize();
            budget = Long.MAX_VALUE;
        settings.add(COORDINATOR_BUFFER_LIMIT);
            // re-instantiate AnalyticsSearchTransportService, whose ctor registers
        Settings settings,
        "analytics.coordinator.buffer_limit",
        ScriptService scriptService,
        }
            }
        // TODO: re-wire once operatorTable() is added back to AnalyticsSearchBackendPlugin
        0L,
        Path dir;
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        clusterService.getClusterSettings()
            // TransportAnalyticsShuffleDataAction, and AnalyticsSearchService all see the same
    @Override
}
    private static final Logger logger = LogManager.getLogger(AnalyticsPlugin.class);
    // Per-query coordinator allocator cap in bytes. 0 (default) → no per-query child allocator;
    private static final int REDUCE_POOL_SIZE = Math.max(8, Runtime.getRuntime().availableProcessors() * 4);
            budget = maxHeap == Long.MAX_VALUE ? Long.MAX_VALUE : (long) (maxHeap * (percent / 100.0));
        // rate by the shard fan-out factor and drops most queries' latency (the
     *       exactly one {@link org.opensearch.analytics.planner.dag.StagePlan}; convertor
import org.opensearch.cluster.node.DiscoveryNodes;
        applyShuffleSpillConfig(clusterService.getClusterSettings());
     */
        if (enabled && dir == null) {
     * resolver would silently bypass those checks.
    @Override
        );
        String configuredDir = clusterSettings.get(AnalyticsSettings.MPP_SHUFFLE_SPILL_DIRECTORY);
    // queries share the coordinator allocator with no per-query cap.
import java.util.Collection;
import org.opensearch.index.search.stats.SearchStats;
        }
        ClusterSettings cs = clusterService.getClusterSettings();
        @Override
        IndexNameExpressionResolver indexNameExpressionResolver,
    }
    }
import org.opensearch.analytics.exec.action.AnalyticsQueryAction;
        logger.info("[analytics] hash-shuffle node budget set to {}% of max heap = {} bytes", percent, budget);
            backEndsByName.put(be.name(), be);
     * {@code <path.data>/shuffle_spill}. When spill is enabled but no spill root can be resolved (no
        long budget;
        public Exception convertException(Exception e) {
    private final List<AnalyticsSearchBackendPlugin> backEnds = new ArrayList<>();
 *
    @SuppressWarnings("rawtypes")
        analyticsSearchSlowLog = new AnalyticsSearchSlowLog(clusterService);
        // Resolve the spill root once from the environment's first data path (settings default ""
            capabilityRegistry,
     * Default implementation of {@link EngineContextProvider}. The {@link IndexNameExpressionResolver}
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;
        );
    }
        // Wire the node-level shuffle budget from settings (initial value + dynamic updates). The
    private AnalyticsSearchSlowLog analyticsSearchSlowLog;
        // counts matching Lucene's onPreQueryPhase semantics.
        // AnalyticsSearchService's allocator is owned and closed by this plugin.
     * it to the manager. Node budget == per-query max: a lone query may use the whole budget, but a
     * Controls the metadata-only driver vs. value-producing peer choice when both are viable
     *       alternatives are dropped from every stage. A/B comparison knob and regression
        0L,
        public QueryRequestContext getContext() {
import org.opensearch.plugins.PluginComponentRegistry;
    }
import org.opensearch.analytics.stats.transport.TransportAnalyticsStatsAction;
    ) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    /**
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
    public static final Setting<Boolean> PREFER_METADATA_DRIVER = Setting.boolSetting(
            analyticsSearchSlowLog,
     * system-index access checks, and ThreadContext threading. Building schemas with a fresh
import org.opensearch.rest.RestController;
        true,
        Supplier<DiscoveryNodes> nodesInCluster
import org.opensearch.common.inject.Module;
        @Override
import org.opensearch.plugins.Plugin;
            return e;
        shuffleBufferManager.setBudgets(budget, budget);
        return List.of(new RestMppStrategyStatsAction(mppStrategyMetrics), new RestAnalyticsStatsAction());
        Environment environment,
     * the {@code analytics.mpp.shuffle.spill.directory} setting when non-empty, else
        analyticsFragmentSlowLog = new AnalyticsFragmentSlowLog();
 */
    }
    public List<RestHandler> getRestHandlers(
            // ShuffleBufferManager is auto-bound by OpenSearch as a node-level component (we
        // transport handler that populates buffers from the wire side sees the same instance.
            b.bind(EngineContextProvider.class).to(DefaultEngineContextProvider.class);
    // Resolved once at startup: <path.data>/shuffle_spill, used when the spill.directory setting is
                    return converted;
        // Returned as components so Guice can inject them into DefaultPlanExecutor
        return List.of(
 * this file be licensed under the Apache-2.0 license or a
            List.of(analyticsFragmentSlowLog),
     * <ul>
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
        if (percent <= 0) {
        }
        backEnds.addAll(loader.loadExtensions(AnalyticsSearchBackendPlugin.class));
        settings.add(ReaderContextStore.READER_CONTEXT_KEEP_ALIVE);
        boolean enabled = clusterSettings.get(AnalyticsSettings.MPP_SHUFFLE_SPILL_ENABLED);
     * is the cluster's resolver — built by the OpenSearch server with security-plugin extensions,
import org.opensearch.analytics.settings.AnalyticsApproximationSettings;
import org.opensearch.watcher.ResourceWatcherService;
    private Path shuffleSpillDefaultRoot;
    public AnalyticsPlugin() {}
        //
        coordinatorAllocatorHandle = new CoordinatorAllocatorHandle(
        }
    static int schedulerPoolSize() {
        SettingsFilter settingsFilter,
        // SHARD_FRAGMENT execution's per-shard StageTasks, giving per-shard
        applyShuffleBudget(clusterService.getClusterSettings().get(AnalyticsSettings.MPP_SHUFFLE_NODE_BUDGET_PERCENT));
        // this the manager's budget stays Long.MAX_VALUE and a large shuffle accumulates its whole
            readerContextStore
     */
        // budget is a percent of max heap; node budget == per-query max (a lone query may use the
    /**
        PluginComponentRegistry pluginComponentRegistry
        // carries it so the coordinator-reduce path stages its imports on the same node-scoped allocator.
    }
            namedWriteableRegistry,
        cs.addSettingsUpdateConsumer(AnalyticsSettings.MPP_SHUFFLE_SPILL_MAX_BYTES, max -> applyShuffleSpillConfig(cs));
/**
import org.opensearch.analytics.rest.RestMppStrategyStatsAction;
        searchService.setShuffleBufferRegistry(shuffleBufferManager);
            .addSettingsUpdateConsumer(ReaderContextStore.READER_CONTEXT_KEEP_ALIVE, readerContextStore::setKeepAlive);
        "analytics.planner.prefer_metadata_driver",
     * </ul>
        );
        ThreadPool threadPool,
import org.opensearch.analytics.exec.action.AnalyticsClearShuffleAction;
        // start/end window in AnalyticsStatsCollector#recordExecution is commonly
import org.opensearch.arrow.allocator.ArrowNativeAllocator;
        String,
            new FixedExecutorBuilder(settings, REDUCE_THREAD_POOL_NAME, REDUCE_POOL_SIZE, REDUCE_QUEUE_SIZE, "analytics_reduce")
import org.apache.calcite.rel.RelNode;
import org.opensearch.analytics.exec.shuffle.ShuffleBufferManager;
            }).to(DefaultPlanExecutor.class);
import org.opensearch.analytics.exec.action.TransportAnalyticsShuffleDataAction;
 * Analytics engine hub. Implements {@link ExtensiblePlugin} to discover
            b.bind(Scheduler.class).to(QueryScheduler.class);
            new ActionHandler<>(AnalyticsShuffleDataAction.INSTANCE, TransportAnalyticsShuffleDataAction.class),
        public QueryRequestContext getContext(ClusterState clusterState) {
            // Singleton bind on the concrete class so node-injector lookups for
import org.opensearch.threadpool.FixedExecutorBuilder;
    @Override
        NamedXContentRegistry xContentRegistry,
        settings.addAll(AnalyticsApproximationSettings.all());
import org.opensearch.analytics.exec.join.MppStrategyMetrics;
    }
 * and wire query back-end extensions via SPI.
            coordinatorAllocatorHandle,
            searchService,
        } else {
            new ActionHandler<>(AnalyticsStatsAction.INSTANCE, TransportAnalyticsStatsAction.class)
    public static final String REDUCE_THREAD_POOL_NAME = "analytics_reduce";
        for (AnalyticsSearchBackendPlugin be : backEnds) {
        } else {
        long maxBytes = clusterSettings.get(AnalyticsSettings.MPP_SHUFFLE_SPILL_MAX_BYTES);
    @Override
    private AnalyticsSearchService searchService;
        ClusterService clusterService,
    private static final int SCHEDULER_QUEUE_SIZE = 200;
        return List.of(b -> {
        );
import org.opensearch.cluster.service.ClusterService;
        NamedWriteableRegistry namedWriteableRegistry,
    private ReaderContextStore readerContextStore;
import java.util.function.Supplier;
        boolean effective = enabled && dir != null;
    record DefaultEngineContextProvider(ClusterService clusterService, IndexNameExpressionResolver indexNameExpressionResolver, Map<
    private CoordinatorAllocatorHandle coordinatorAllocatorHandle;
    @Override
import java.util.ArrayList;
    // pool, preventing deadlock when reduces and local shard fragments compete for
import org.opensearch.analytics.exec.QueryScheduler;
    private final AnalyticsStatsCollector statsCollector = new AnalyticsStatsCollector();
                }
    @Override
            logger.info("[analytics] hash-shuffle spill enabled={}, dir={}, max_bytes={}", effective, dir, maxBytes);
    public void loadExtensions(ExtensionLoader loader) {
import org.opensearch.analytics.exec.DefaultPlanExecutor;
    public List<Setting<?>> getSettings() {
            ctx,
        // spill config from settings (initial value + dynamic updates). Default OFF — when disabled
import org.opensearch.common.settings.Settings;
    private final ShuffleBufferManager shuffleBufferManager = new ShuffleBufferManager();
        // Build the coordinator allocator under POOL_QUERY here, in the plugin, so that the
            .build();
        List<Setting<?>> settings = new ArrayList<>(AnalyticsSettings.ALL_SETTINGS);
            mppStrategyMetrics,
            .queryTimeInMillis(fragments.elapsedMs().sumMs())
        cs.addSettingsUpdateConsumer(AnalyticsSettings.MPP_SHUFFLE_SPILL_ENABLED, enabled -> applyShuffleSpillConfig(cs));
        AnalyticsStats.Fragments fragments = snapshot.fragments();
    // bounded by the DataFusion pool and phantom reservations. Size is generous
        // per-shard granularity Lucene reports. fragments.total walks each
        Setting.Property.Dynamic
    public static final Setting<Long> COORDINATOR_BUFFER_LIMIT = Setting.longSetting(
            return null;
    // The reduce pool exists to isolate coordinator-reduce drains from the SEARCH
        });
     * for a stage:
        if (fragments == null || fragments.total() == 0) {
            b.bind(QueryScheduler.class).asEagerSingleton();
import org.apache.logging.log4j.LogManager;
     *       escape hatch.</li>
            nativeAllocator,
import org.opensearch.common.settings.Setting;
        Setting.Property.NodeScope,
    public Collection<Module> createGuiceModules() {
     * data path), spill is left OFF (the manager falls back to the fail-fast budget path). Called at
import org.opensearch.analytics.exec.QueryPlanExecutor;
    // (streamNext) with negligible CPU usage — memory is the real constraint,
            statsCollector
        if (searchService != null) {
    private void applyShuffleSpillConfig(ClusterSettings clusterSettings) {
        // exposed via _nodes/stats match Lucene's per-shard accounting (one increment
import org.opensearch.plugins.SearchStatsContributor;
 * The OpenSearch Contributors require contributions made to
    ) {
    }
        }
        cs.addSettingsUpdateConsumer(AnalyticsSettings.MPP_SHUFFLE_SPILL_DIRECTORY, dir -> applyShuffleSpillConfig(cs));
        Client client,
        AnalyticsSearchBackendPlugin> backends) implements EngineContextProvider {
    // so the thread pool isn't the throughput bottleneck.
    private static final int REDUCE_QUEUE_SIZE = 200;
import org.apache.logging.log4j.Logger;
    private AnalyticsFragmentSlowLog analyticsFragmentSlowLog;
        );
        this.shuffleSpillDefaultRoot = environment.dataFiles().length > 0 ? environment.dataFiles()[0].resolve("shuffle_spill") : null;
import org.opensearch.transport.client.Client;
            coordinatorAllocatorHandle.close();
import org.opensearch.common.inject.TypeLiteral;
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        // bucket counts 1-per-(query, node-hosting-shards), still missing the
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
 */
import org.opensearch.threadpool.ExecutorBuilder;
            // return the singleton instance from createComponents), so DefaultPlanExecutor,
import java.nio.file.Path;
            dir = shuffleSpillDefaultRoot;
    public static final String SCHEDULER_THREAD_POOL_NAME = "analytics_scheduler";
            // QueryScheduler.class don't fall back to a JIT binding (which would
    }
                if (converted != e) {
    }
import org.apache.calcite.sql.util.SqlOperatorTables;
        return SqlOperatorTables.of();
        // after createComponents) and into AnalyticsSearchTransportService. The shuffle
 *
import java.util.Map;
import org.opensearch.common.settings.SettingsFilter;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                Exception converted = backend.convertException(e);
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.env.Environment;
            new ActionHandler<>(AnalyticsClearShuffleAction.INSTANCE, TransportAnalyticsClearShuffleAction.class),
import org.opensearch.analytics.exec.Scheduler;
        // it via the handle without taking on close responsibility — mirroring how
        readerContextStore = new ReaderContextStore(threadPool);
            b.bind(new TypeLiteral<QueryPlanExecutor<RelNode, Iterable<Object[]>>>() {
import java.util.LinkedHashMap;
     * startup and on any of the three spill settings changing.
 * @opensearch.internal
        IndexNameExpressionResolver indexNameExpressionResolver,
        DefaultEngineContextProvider ctx = new DefaultEngineContextProvider(clusterService, indexNameExpressionResolver, backEndsByName);
        Setting.Property.NodeScope,
import org.opensearch.plugins.ExtensiblePlugin;
            logger.warn("[analytics] hash-shuffle spill requested but no data path is available; spill stays disabled");
    @Override
        // (a HandledTransportAction registered via getActions() — constructed by Guice
    public void close() {
import org.opensearch.analytics.stats.transport.AnalyticsStatsAction;
        searchService = new AnalyticsSearchService(
            // node-local registry. No explicit Guice binding needed here — adding one would
        NodeEnvironment nodeEnvironment,
        return new SearchStats(stats, 0, null);
        ResourceWatcherService resourceWatcherService,
    public SearchStats contributeSearchStats() {
        IndexScopedSettings indexScopedSettings,
            searchService.getImportStagingAllocator()
import org.opensearch.rest.RestHandler;
        // The import staging allocator is created and closed by the search service; the handle only
     */
        } else {
        // 0 when stage timestamps aren't populated). The SHARD_FRAGMENT stage
        // per shard query phase, not per user query).
    public Collection<Object> createComponents(
    );
import org.opensearch.analytics.exec.AnalyticsSearchService;
    /**
        clusterService.getClusterSettings()
    // the same threads. Each reduce thread blocks on a synchronous FFM call
import org.opensearch.analytics.exec.action.TransportAnalyticsClearShuffleAction;
        return List.copyOf(settings);
        settings.add(PREFER_METADATA_DRIVER);
            return getContext(clusterService.state());
import org.apache.calcite.sql.SqlOperatorTable;
        SearchStats.Stats stats = new SearchStats.Stats.Builder().queryCount(fragments.total())
/*
     */
public class AnalyticsPlugin extends Plugin implements ExtensiblePlugin, ActionPlugin, SearchStatsContributor {
        searchService.setShuffleSenderDeps(client, threadPool, clusterService);
 * compatible open source license.
    /**
    private void applyShuffleBudget(int percent) {
        // The queries.elapsed_ms bucket counts 1-per-query, which undercounts the
import org.opensearch.analytics.planner.CapabilityRegistry;
        ClusterSettings clusterSettings,
    private final MppStrategyMetrics mppStrategyMetrics = new MppStrategyMetrics();
        AnalyticsStats snapshot = statsCollector.snapshot();
    // left at its empty default. Null only when the node has no data path (never in practice).
    );
import org.opensearch.threadpool.ThreadPool;
            new FixedExecutorBuilder(settings, SCHEDULER_THREAD_POOL_NAME, poolSize, SCHEDULER_QUEUE_SIZE, "analytics"),
            backEndsByName,
        // plugin's lifecycle owns its lifetime. The Guice-bound DefaultPlanExecutor consumes
import org.opensearch.core.action.ActionResponse;
            .addSettingsUpdateConsumer(AnalyticsSettings.MPP_SHUFFLE_NODE_BUDGET_PERCENT, this::applyShuffleBudget);
import org.opensearch.analytics.planner.FieldStorageResolver;
import org.opensearch.analytics.exec.action.AnalyticsShuffleDataAction;
        if (coordinatorAllocatorHandle != null) {
    @Override
import org.opensearch.analytics.exec.CoordinatorAllocatorHandle;
        return List.of(
        settings.addAll(AnalyticsQuerySettings.all());
import org.apache.calcite.schema.SchemaPlus;
        // whole budget, but no single query may exceed it — that fails fast, non-retryably). Without
    @SuppressWarnings("unchecked")
        @Override
import org.opensearch.plugins.ActionPlugin;
            SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState, indexNameExpressionResolver);
        Setting.Property.Dynamic
        // DefaultPlanExecutor) and via createGuiceModules' toInstance binding so the
import org.opensearch.analytics.exec.AnalyticsFragmentSlowLog;
        // input on-heap as byte[] until the node OOMs (the inert-cap bug; observed on TPC-H q17 sf=10).
    private SqlOperatorTable aggregateOperatorTables() {
     *   <li>{@code true} (default) — collapse to the metadata-only alternative (e.g. Lucene)
import org.opensearch.common.settings.ClusterSettings;
        }
package org.opensearch.analytics;
import org.opensearch.analytics.stats.RestAnalyticsStatsAction;
    /**
        shuffleBufferManager.setSpillConfig(effective, dir, maxBytes);
import org.opensearch.analytics.exec.AnalyticsSearchSlowLog;
        // a per-query budget breach stays the fail-fast throw (behavior unchanged).
import org.opensearch.script.ScriptService;
     * single query whose footprint exceeds it fails fast (non-retryable). {@code percent==0} disables
import org.opensearch.action.ActionRequest;
        }
     * Resolve and apply the hash-shuffle disk-spill config from current settings. The directory is
import org.opensearch.core.xcontent.NamedXContentRegistry;
     *       runs once per stage; data node skips per-request alternative selection.</li>
            // collide with the auto-bind ("already configured at _unknown_").
        CapabilityRegistry capabilityRegistry = new CapabilityRegistry(backEnds, FieldStorageResolver::new);
        // Contribute per-shard fragment task counts so the node-level search counters
        Map<String, AnalyticsSearchBackendPlugin> backEndsByName = new LinkedHashMap<>();
        if (configuredDir != null && configuredDir.isEmpty() == false) {
        ArrowNativeAllocator nativeAllocator = pluginComponentRegistry.getComponent(ArrowNativeAllocator.class)
            nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY).newChildAllocator("coordinator", 0, Long.MAX_VALUE),
            return new QueryRequestContext(clusterState, schema);
     */
        Supplier<RepositoriesService> repositoriesServiceSupplier,
import org.opensearch.env.NodeEnvironment;
        }
import org.opensearch.analytics.stats.AnalyticsStatsCollector;
        return List.of(
        }
     * the budget (Long.MAX_VALUE — pre-fix behavior). Called at startup and on dynamic updates.
        // buffer manager is exposed both here (for Guice-injected consumers like
        }
import org.opensearch.cluster.ClusterState;
            .orElseThrow(() -> new IllegalStateException("ArrowNativeAllocator not available; arrow-base plugin must be installed"));
     *
            long maxHeap = Runtime.getRuntime().maxMemory();
            searchService.close();
     *   <li>{@code false} — force the value-producing backend (DataFusion). All metadata-only
import org.opensearch.common.settings.IndexScopedSettings;
import org.opensearch.analytics.exec.ReaderContextStore;
    }
            new ActionHandler<>(AnalyticsQueryAction.INSTANCE, DefaultPlanExecutor.class),
            shuffleBufferManager,
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
    }
import org.opensearch.analytics.stats.AnalyticsStats;
     * Creates a new analytics engine hub plugin.
        // means "use <path.data>/shuffle_spill"); a non-empty setting overrides it. Then wire the
            dir = Path.of(configuredDir);
    }
