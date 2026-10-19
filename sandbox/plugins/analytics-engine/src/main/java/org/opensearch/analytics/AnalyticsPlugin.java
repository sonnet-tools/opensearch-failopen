        clusterService.getClusterSettings()
        Supplier<DiscoveryNodes> nodesInCluster
import org.opensearch.analytics.exec.QueryPlanExecutor;
        return List.of(  
    @Override
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import org.opensearch.analytics.exec.AnalyticsSearchService;  
        for (AnalyticsSearchBackendPlugin be : backEnds) {
    public AnalyticsPlugin() {}
        Setting.Property.Dynamic
    private ReaderContextStore readerContextStore;
    // the same threads. Each reduce thread blocks on a synchronous FFM call
        }  
import org.opensearch.analytics.exec.ReaderContextStore;  
        // whole budget, but no single query may exceed it — that fails fast, non-retryably). Without
        String configuredDir = clusterSettings.get(AnalyticsSettings.MPP_SHUFFLE_SPILL_DIRECTORY);  
    // queries share the coordinator allocator with no per-query cap.
        IndexNameExpressionResolver indexNameExpressionResolver,  
import org.opensearch.threadpool.FixedExecutorBuilder;
import org.opensearch.analytics.exec.action.TransportAnalyticsClearShuffleAction;
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.core.xcontent.NamedXContentRegistry;  
public class AnalyticsPlugin extends Plugin implements ExtensiblePlugin, ActionPlugin, SearchStatsContributor {  
            // ShuffleBufferManager is auto-bound by OpenSearch as a node-level component (we
import org.opensearch.common.inject.TypeLiteral;
        AnalyticsStats snapshot = statsCollector.snapshot();  
        return List.of(
import org.opensearch.analytics.exec.Scheduler;
            for (AnalyticsSearchBackendPlugin backend : backends.values()) {
        // plugin's lifecycle owns its lifetime. The Guice-bound DefaultPlanExecutor consumes
        ThreadPool threadPool,
        }
import org.opensearch.analytics.stats.RestAnalyticsStatsAction;  
        // The import staging allocator is created and closed by the search service; the handle only
    @Override  
        if (searchService != null) {
        // Resolve the spill root once from the environment's first data path (settings default ""
            // QueryScheduler.class don't fall back to a JIT binding (which would
import java.util.ArrayList;
        // exposed via _nodes/stats match Lucene's per-shard accounting (one increment
        if (configuredDir != null && configuredDir.isEmpty() == false) {  
            new ActionHandler<>(AnalyticsShuffleDataAction.INSTANCE, TransportAnalyticsShuffleDataAction.class),
        this.shuffleSpillDefaultRoot = environment.dataFiles().length > 0 ? environment.dataFiles()[0].resolve("shuffle_spill") : null;
            }).to(DefaultPlanExecutor.class);
import org.opensearch.analytics.settings.AnalyticsQuerySettings;
        long budget;
import java.util.List;
import org.opensearch.plugins.ExtensiblePlugin;
     *       runs once per stage; data node skips per-request alternative selection.</li>  
        shuffleBufferManager.setSpillConfig(effective, dir, maxBytes);  
            searchService.close();
    );
    // bounded by the DataFusion pool and phantom reservations. Size is generous
            coordinatorAllocatorHandle,  
    }
import org.opensearch.env.Environment;
import org.opensearch.index.search.stats.SearchStats;  
import org.opensearch.analytics.stats.transport.TransportAnalyticsStatsAction;
        );  
import org.opensearch.analytics.exec.action.TransportAnalyticsShuffleDataAction;  
            }  
    private final ShuffleBufferManager shuffleBufferManager = new ShuffleBufferManager();  
            List.of(analyticsFragmentSlowLog),
        int poolSize = schedulerPoolSize();
    }  
        SearchStats.Stats stats = new SearchStats.Stats.Builder().queryCount(fragments.total())
        boolean effective = enabled && dir != null;
import org.opensearch.analytics.exec.shuffle.ShuffleBufferManager;
    private Path shuffleSpillDefaultRoot;  
    /**  
    // Resolved once at startup: <path.data>/shuffle_spill, used when the spill.directory setting is
    public void loadExtensions(ExtensionLoader loader) {  
        // buffer manager is exposed both here (for Guice-injected consumers like  
            coordinatorAllocatorHandle.close();
     * for a stage:  
     *       exactly one {@link org.opensearch.analytics.planner.dag.StagePlan}; convertor
    @Override
        List<Setting<?>> settings = new ArrayList<>(AnalyticsSettings.ALL_SETTINGS);  
    private static final int SCHEDULER_QUEUE_SIZE = 200;
    private static final Logger logger = LogManager.getLogger(AnalyticsPlugin.class);
        AnalyticsStats.Fragments fragments = snapshot.fragments();
        return List.of(b -> {  
     */  
import org.opensearch.plugins.Plugin;  
            ctx,
import org.opensearch.rest.RestHandler;
        );  
        }  
            searchService.getImportStagingAllocator()  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                if (converted != e) {  
        // after createComponents) and into AnalyticsSearchTransportService. The shuffle
        RestController restController,
    ) {
        cs.addSettingsUpdateConsumer(AnalyticsSettings.MPP_SHUFFLE_SPILL_ENABLED, enabled -> applyShuffleSpillConfig(cs));
import org.opensearch.analytics.exec.AnalyticsFragmentSlowLog;
import org.apache.logging.log4j.Logger;  
import org.opensearch.analytics.exec.action.AnalyticsShuffleDataAction;
 * compatible open source license.
import org.opensearch.core.action.ActionResponse;
        analyticsFragmentSlowLog = new AnalyticsFragmentSlowLog();
    public List<Setting<?>> getSettings() {
        // Contribute per-shard fragment task counts so the node-level search counters  
import org.opensearch.common.settings.IndexScopedSettings;  
        cs.addSettingsUpdateConsumer(AnalyticsSettings.MPP_SHUFFLE_SPILL_MAX_BYTES, max -> applyShuffleSpillConfig(cs));
            .addSettingsUpdateConsumer(ReaderContextStore.READER_CONTEXT_KEEP_ALIVE, readerContextStore::setKeepAlive);  
        logger.info("[analytics] hash-shuffle node budget set to {}% of max heap = {} bytes", percent, budget);  
        // (a HandledTransportAction registered via getActions() — constructed by Guice
        analyticsSearchSlowLog = new AnalyticsSearchSlowLog(clusterService);
            new ActionHandler<>(AnalyticsQueryAction.INSTANCE, DefaultPlanExecutor.class),  
import org.opensearch.watcher.ResourceWatcherService;
            new ActionHandler<>(AnalyticsClearShuffleAction.INSTANCE, TransportAnalyticsClearShuffleAction.class),
import org.opensearch.analytics.exec.DefaultPlanExecutor;  
     *   <li>{@code true} (default) — collapse to the metadata-only alternative (e.g. Lucene)  
        return List.copyOf(settings);  
        // SHARD_FRAGMENT execution's per-shard StageTasks, giving per-shard
import org.opensearch.plugins.PluginComponentRegistry;
import org.opensearch.arrow.allocator.ArrowNativeAllocator;  
        0L,
        return SqlOperatorTables.of();
     *   <li>{@code false} — force the value-producing backend (DataFusion). All metadata-only
    private AnalyticsSearchService searchService;
            nativeAllocator.getPoolAllocator(NativeAllocatorPoolConfig.POOL_QUERY).newChildAllocator("coordinator", 0, Long.MAX_VALUE),
import org.opensearch.common.settings.SettingsFilter;  
import org.opensearch.analytics.stats.AnalyticsStats;
        applyShuffleSpillConfig(clusterService.getClusterSettings());  
            // return the singleton instance from createComponents), so DefaultPlanExecutor,
        "analytics.coordinator.buffer_limit",  
     *       escape hatch.</li>  
    private AnalyticsFragmentSlowLog analyticsFragmentSlowLog;
        // input on-heap as byte[] until the node OOMs (the inert-cap bug; observed on TPC-H q17 sf=10).  
import org.apache.logging.log4j.LogManager;
        DefaultEngineContextProvider ctx = new DefaultEngineContextProvider(clusterService, indexNameExpressionResolver, backEndsByName);  
    /**
        settings.addAll(AnalyticsQuerySettings.all());
    // left at its empty default. Null only when the node has no data path (never in practice).
     *
        long maxBytes = clusterSettings.get(AnalyticsSettings.MPP_SHUFFLE_SPILL_MAX_BYTES);
        // Returned as components so Guice can inject them into DefaultPlanExecutor  
 *
        // AnalyticsSearchService's allocator is owned and closed by this plugin.
}
    private void applyShuffleSpillConfig(ClusterSettings clusterSettings) {
            capabilityRegistry,  
        "analytics.planner.prefer_metadata_driver",
import org.apache.calcite.sql.util.SqlOperatorTables;
            budget = maxHeap == Long.MAX_VALUE ? Long.MAX_VALUE : (long) (maxHeap * (percent / 100.0));  
 */
    // Per-query coordinator allocator cap in bytes. 0 (default) → no per-query child allocator;  
    public List<RestHandler> getRestHandlers(  
     * single query whose footprint exceeds it fails fast (non-retryable). {@code percent==0} disables  
            return getContext(clusterService.state());
 * and wire query back-end extensions via SPI.
     * startup and on any of the three spill settings changing.
     * <ul>
    private CoordinatorAllocatorHandle coordinatorAllocatorHandle;  
    @Override  
            .addSettingsUpdateConsumer(AnalyticsSettings.MPP_SHUFFLE_NODE_BUDGET_PERCENT, this::applyShuffleBudget);  
    private final MppStrategyMetrics mppStrategyMetrics = new MppStrategyMetrics();
import org.opensearch.common.inject.Module;  
        Environment environment,  
            b.bind(QueryScheduler.class).asEagerSingleton();
        NamedWriteableRegistry namedWriteableRegistry,
    @Override
        SettingsFilter settingsFilter,
        //  
        searchService.setShuffleBufferRegistry(shuffleBufferManager);
        // carries it so the coordinator-reduce path stages its imports on the same node-scoped allocator.  
        }
    public SearchStats contributeSearchStats() {
        Setting.Property.NodeScope,  
            // collide with the auto-bind ("already configured at _unknown_").
        readerContextStore = new ReaderContextStore(threadPool);
     * </ul>
    // so the thread pool isn't the throughput bottleneck.
     *       whenever it can run the stage end-to-end (today: count fast path). Stage ships
        // Wire the node-level shuffle budget from settings (initial value + dynamic updates). The
        searchService = new AnalyticsSearchService(  
        @Override  
import org.opensearch.rest.RestController;
            readerContextStore
        return List.of(  
import org.opensearch.plugins.SearchStatsContributor;
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
     *       alternatives are dropped from every stage. A/B comparison knob and regression
import java.util.Map;  
        Setting.Property.Dynamic
            dir = Path.of(configuredDir);
     * Default implementation of {@link EngineContextProvider}. The {@link IndexNameExpressionResolver}  
import org.opensearch.analytics.settings.AnalyticsApproximationSettings;
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;  
        public QueryRequestContext getContext() {
import org.opensearch.analytics.planner.CapabilityRegistry;  
import org.opensearch.analytics.stats.AnalyticsStatsCollector;
        Client client,  
     */  
    }  
/*  
    public static final String SCHEDULER_THREAD_POOL_NAME = "analytics_scheduler";
        );  
        cs.addSettingsUpdateConsumer(AnalyticsSettings.MPP_SHUFFLE_SPILL_DIRECTORY, dir -> applyShuffleSpillConfig(cs));  
    }  
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
    @Override  
import org.opensearch.cluster.ClusterState;
    public void close() {  
            b.bind(Scheduler.class).to(QueryScheduler.class);  
        ArrowNativeAllocator nativeAllocator = pluginComponentRegistry.getComponent(ArrowNativeAllocator.class)
            return null;  
     * data path), spill is left OFF (the manager falls back to the fail-fast budget path). Called at
import org.opensearch.analytics.planner.FieldStorageResolver;
import java.util.LinkedHashMap;
            b.bind(EngineContextProvider.class).to(DefaultEngineContextProvider.class);  
        // a per-query budget breach stays the fail-fast throw (behavior unchanged).
 * SPDX-License-Identifier: Apache-2.0
        // spill config from settings (initial value + dynamic updates). Default OFF — when disabled  
            logger.info("[analytics] hash-shuffle spill enabled={}, dir={}, max_bytes={}", effective, dir, maxBytes);
        true,
            .queryTimeInMillis(fragments.elapsedMs().sumMs())  
        // rate by the shard fan-out factor and drops most queries' latency (the
        // 0 when stage timestamps aren't populated). The SHARD_FRAGMENT stage
import org.opensearch.analytics.exec.join.MppStrategyMetrics;
    }
     * {@code <path.data>/shuffle_spill}. When spill is enabled but no spill root can be resolved (no  
import java.util.function.Supplier;
        );
    }  
            nativeAllocator,  
    @Override
        } else {
    }
import org.opensearch.common.settings.Settings;
        settings.add(PREFER_METADATA_DRIVER);
            // TransportAnalyticsShuffleDataAction, and AnalyticsSearchService all see the same  
        Setting.Property.NodeScope,  
import org.opensearch.threadpool.ThreadPool;  
    // pool, preventing deadlock when reduces and local shard fragments compete for
    public static final Setting<Long> COORDINATOR_BUFFER_LIMIT = Setting.longSetting(
        }
        // per shard query phase, not per user query).
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;  
        clusterService.getClusterSettings()
     * it to the manager. Node budget == per-query max: a lone query may use the whole budget, but a
        // it via the handle without taking on close responsibility — mirroring how  
     * Controls the metadata-only driver vs. value-producing peer choice when both are viable
        // counts matching Lucene's onPreQueryPhase semantics.
 * this file be licensed under the Apache-2.0 license or a
    private SqlOperatorTable aggregateOperatorTables() {  
    // (streamNext) with negligible CPU usage — memory is the real constraint,  
        if (coordinatorAllocatorHandle != null) {
            backEndsByName,
                }
        }
            // re-instantiate AnalyticsSearchTransportService, whose ctor registers  
    public Collection<Module> createGuiceModules() {
    /**
                Exception converted = backend.convertException(e);
import org.opensearch.analytics.exec.CoordinatorAllocatorHandle;
     * is the cluster's resolver — built by the OpenSearch server with security-plugin extensions,
import org.opensearch.analytics.exec.action.AnalyticsQueryAction;  
            // transport handlers and is only legal to call once per node).
        Path dir;
    public static final String REDUCE_THREAD_POOL_NAME = "analytics_reduce";
            budget = Long.MAX_VALUE;  
        NamedXContentRegistry xContentRegistry,
 *  
        ClusterSettings cs = clusterService.getClusterSettings();
        public QueryRequestContext getContext(ClusterState clusterState) {
            return new QueryRequestContext(clusterState, schema);  
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
    }
        settings.addAll(AnalyticsApproximationSettings.all());
        if (fragments == null || fragments.total() == 0) {
                    return converted;
        public Exception convertException(Exception e) {  
        @Override  
        // bucket counts 1-per-(query, node-hosting-shards), still missing the
import org.opensearch.analytics.exec.action.AnalyticsClearShuffleAction;
        shuffleBufferManager.setBudgets(budget, budget);
        AnalyticsSearchBackendPlugin> backends) implements EngineContextProvider {
            new FixedExecutorBuilder(settings, SCHEDULER_THREAD_POOL_NAME, poolSize, SCHEDULER_QUEUE_SIZE, "analytics"),
        Map<String, AnalyticsSearchBackendPlugin> backEndsByName = new LinkedHashMap<>();  
        ClusterService clusterService,
            statsCollector
import org.opensearch.action.ActionRequest;
    }
        applyShuffleBudget(clusterService.getClusterSettings().get(AnalyticsSettings.MPP_SHUFFLE_NODE_BUDGET_PERCENT));
        }
        // this the manager's budget stays Long.MAX_VALUE and a large shuffle accumulates its whole
        } else {
/**  
        // per-shard granularity Lucene reports. fragments.total walks each  
import org.opensearch.transport.client.Client;
import java.util.Collection;  
    );
 * Analytics engine hub. Implements {@link ExtensiblePlugin} to discover
        });  
            searchService,
    @Override
        // DefaultPlanExecutor) and via createGuiceModules' toInstance binding so the
    // The reduce pool exists to isolate coordinator-reduce drains from the SEARCH  
    public static final Setting<Boolean> PREFER_METADATA_DRIVER = Setting.boolSetting(  
        }
     * the budget (Long.MAX_VALUE — pre-fix behavior). Called at startup and on dynamic updates.
    private static final int REDUCE_POOL_SIZE = Math.max(8, Runtime.getRuntime().availableProcessors() * 4);  
    ) {  
import org.opensearch.script.ScriptService;  
            analyticsSearchSlowLog,
        return List.of(new RestMppStrategyStatsAction(mppStrategyMetrics), new RestAnalyticsStatsAction());  
            b.bind(new TypeLiteral<QueryPlanExecutor<RelNode, Iterable<Object[]>>>() {
import org.opensearch.env.NodeEnvironment;
        // budget is a percent of max heap; node budget == per-query max (a lone query may use the  
        backEnds.addAll(loader.loadExtensions(AnalyticsSearchBackendPlugin.class));
     */
        );
            namedWriteableRegistry,
        ScriptService scriptService,
            shuffleBufferManager,
import org.apache.calcite.schema.SchemaPlus;
    private void applyShuffleBudget(int percent) {  
     * Resolve and apply the hash-shuffle disk-spill config from current settings. The directory is
            logger.warn("[analytics] hash-shuffle spill requested but no data path is available; spill stays disabled");
import org.opensearch.threadpool.ExecutorBuilder;
        }  
import org.apache.calcite.rel.RelNode;
    }
        } else {  
        // transport handler that populates buffers from the wire side sees the same instance.
            .orElseThrow(() -> new IllegalStateException("ArrowNativeAllocator not available; arrow-base plugin must be installed"));
 */  
    }
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.analytics.exec.QueryScheduler;
            mppStrategyMetrics,
import org.opensearch.repositories.RepositoriesService;  
            long maxHeap = Runtime.getRuntime().maxMemory();
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
    public Collection<Object> createComponents(
     * Resolve the node-level shuffle byte budget from {@code percent}% of the JVM max heap and apply
            return e;
        // Build the coordinator allocator under POOL_QUERY here, in the plugin, so that the
        // means "use <path.data>/shuffle_spill"); a non-empty setting overrides it. Then wire the
    @SuppressWarnings("unchecked")
import org.opensearch.common.settings.Setting;
        IndexScopedSettings indexScopedSettings,
    }
    private final List<AnalyticsSearchBackendPlugin> backEnds = new ArrayList<>();  
            new FixedExecutorBuilder(settings, REDUCE_THREAD_POOL_NAME, REDUCE_POOL_SIZE, REDUCE_QUEUE_SIZE, "analytics_reduce")
        return Math.max(2, Runtime.getRuntime().availableProcessors() / 2);
     * the {@code analytics.mpp.shuffle.spill.directory} setting when non-empty, else
        ClusterSettings clusterSettings,  
        return new SearchStats(stats, 0, null);
     */
        NodeEnvironment nodeEnvironment,
    }
import org.opensearch.analytics.stats.transport.AnalyticsStatsAction;
import org.opensearch.plugins.ActionPlugin;
    private AnalyticsSearchSlowLog analyticsSearchSlowLog;
     * Creates a new analytics engine hub plugin.
        settings.add(ReaderContextStore.READER_CONTEXT_KEEP_ALIVE);  
        Settings settings,
    static int schedulerPoolSize() {  
        CapabilityRegistry capabilityRegistry = new CapabilityRegistry(backEnds, FieldStorageResolver::new);
    @SuppressWarnings("rawtypes")
import java.nio.file.Path;
            // Singleton bind on the concrete class so node-injector lookups for
            .build();
    @Override
        Supplier<RepositoriesService> repositoriesServiceSupplier,
import org.opensearch.analytics.rest.RestMppStrategyStatsAction;
        coordinatorAllocatorHandle = new CoordinatorAllocatorHandle(
        if (percent <= 0) {
            dir = shuffleSpillDefaultRoot;  
     * resolver would silently bypass those checks.  
            SchemaPlus schema = OpenSearchSchemaBuilder.buildSchema(clusterState, indexNameExpressionResolver);
        boolean enabled = clusterSettings.get(AnalyticsSettings.MPP_SHUFFLE_SPILL_ENABLED);
        @Override
    private final AnalyticsStatsCollector statsCollector = new AnalyticsStatsCollector();
        ResourceWatcherService resourceWatcherService,  
        }  
    /**
            backEndsByName.put(be.name(), be);
    /**  
            new ActionHandler<>(AnalyticsStatsAction.INSTANCE, TransportAnalyticsStatsAction.class)  
        String,  
    }
package org.opensearch.analytics;
        // TODO: re-wire once operatorTable() is added back to AnalyticsSearchBackendPlugin
        IndexNameExpressionResolver indexNameExpressionResolver,  
        searchService.setShuffleSenderDeps(client, threadPool, clusterService);
        if (enabled && dir == null) {
        PluginComponentRegistry pluginComponentRegistry
        0L,
        // start/end window in AnalyticsStatsCollector#recordExecution is commonly  
        // The queries.elapsed_ms bucket counts 1-per-query, which undercounts the
    private static final int REDUCE_QUEUE_SIZE = 200;
import org.apache.calcite.sql.SqlOperatorTable;  
        settings.add(COORDINATOR_BUFFER_LIMIT);
    record DefaultEngineContextProvider(ClusterService clusterService, IndexNameExpressionResolver indexNameExpressionResolver, Map<
import org.opensearch.cluster.service.ClusterService;
     * system-index access checks, and ThreadContext threading. Building schemas with a fresh
import org.opensearch.analytics.exec.AnalyticsSearchSlowLog;
     */
            // node-local registry. No explicit Guice binding needed here — adding one would
