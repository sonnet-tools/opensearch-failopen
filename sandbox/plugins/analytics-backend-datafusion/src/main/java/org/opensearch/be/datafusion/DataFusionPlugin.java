import org.opensearch.core.xcontent.NamedXContentRegistry;
        IndexNameExpressionResolver indexNameExpressionResolver,
            CircuitBreaker.Durability.TRANSIENT,
                cm.updateSizeLimit(CacheUtils.CacheType.STATISTICS, statsLimit);
            }
     * directory on the same disk as the OpenSearch process.
        int metaPct = CacheSettings.FOOTER_METADATA_CACHE_PERCENT.get(updated);
     * Creates the DataFusion plugin.
 * The OpenSearch Contributors require contributions made to
        ResourceWatcherService resourceWatcherService,
     */
        1,
     * spill-limit default reads this setting, so it must be initialized first.
     * but the new value only takes effect after a node restart — the live update consumer
            executionSpill,
     */
     * Returns the {@link GetService} , throwing IllegalStateException if not initialized.
            return DefaultExtensionCatalog.DEFAULT_COLLECTION.merge(delegationExtensions)
        // Pull index.sort.field / index.sort.order off IndexSettings so the native reader can declare
        // Settings built from the cycle's new values, so reading each setting from it is correct.
                cm.updateSizeLimit(CacheUtils.CacheType.METADATA, metaLimit);
            return Long.toString(Long.MAX_VALUE);
        NamedWriteableRegistry namedWriteableRegistry,
            return;
     * don't surface bad data.
    public String name() {
            throw new IllegalArgumentException("Setting [datafusion.spill_directory] is not a valid path: [" + value + "]", e);
    }
import io.substrait.extension.SimpleExtension;
     * Snapshot the native DataFusion per-query registry and return a {@code contextId -> metrics}
    public List<Setting<?>> getSettings() {
     *
     * constructor evaluates the default-value supplier eagerly (under {@code -ea}); the
            int newMax = Math.max(1, (int) (cpuThreads * multiplier));
        String spillDir = DATAFUSION_SPILL_DIRECTORY.get(settings);
        return new DatafusionReaderManager(
     *
            sortOrders
            admissionReject,
            return Long.toString(SPILL_LIMIT_FALLBACK_BYTES);
        new SpillLimitValidator(),
            return List.<Setting<?>>of(DATAFUSION_SPILL_DIRECTORY).iterator();
    SimpleExtension.ExtensionCollection getSubstraitExtensions() {
        // Wire dynamic concurrency gate multiplier settings
     * </ul>
        // This MUST use the grouped overload (not `v -> recompute(getClusterSettings())`): during
    }
    public Supplier<AnalyticsBackendTaskCancellationStats> getAnalyticsBackendTaskCancellationStats() {
     * </ul>
        "datafusion.reduce.input_mode",
            DATAFUSION_MEMORY_GUARD_EXECUTION_CRITICAL_THRESHOLD.get(settings)
     *       spill is disabled and the cap is irrelevant.</li>
                throw new IllegalArgumentException("Setting [datafusion.spill_memory_limit_bytes] must be >= 0, got " + v);
    );
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
            limit,
            Path.of(value).toAbsolutePath().normalize();
        } catch (IOException e) {
        IndexNameExpressionResolver indexNameExpressionResolver,
    void updateSpillMemoryLimit(long newLimitBytes) {
     * Validates {@link #DATAFUSION_SPILL_MEMORY_LIMIT} against {@link #DATAFUSION_SPILL_DIRECTORY}:
        Setting.Property.Dynamic
                List.of(
     * When memory pressure forces partition reduction, this is the lowest value allowed.
     * Applies a new memory pool limit to the running DataFusion runtime.
            long total = Environment.getFileStore(Path.of(dir)).getTotalSpace();
     * <p>
            return Collections.emptyMap();
    }
     * operators (HashAggregate, Sort, TopK) exceed {@link #DATAFUSION_MEMORY_POOL_LIMIT}.
}
     * Pushes the four memory-guard thresholds to the native pool. Reads each value from the
    );
 */
    /**
    /**
        this.dataFormatRegistry = dataFormatRegistry;
            );
     * deployment patterns: a dedicated EBS volume mounted at the spill directory, or the spill
    /**
        if (indexSettings != null) {
            // Range check (>= 0) lives in the parser; nothing to do here without dependencies.
import org.opensearch.cluster.node.DiscoveryNodes;
        String id,
import org.opensearch.cluster.service.ClusterService;
     * budget (an off-by-one update).
                // Clear scoped caches immediately when disabling — entries are
        NativeBridge.setMinTargetPartitions(DATAFUSION_MIN_TARGET_PARTITIONS.get(settings));
        if (logger.isDebugEnabled()) {
                        .stream()
    public static final Setting<Integer> DATAFUSION_REDUCE_TARGET_PARTITIONS = Setting.intSetting(
            "analytics_backend_datafusion",
     * Returns an empty map when the service isn't running, so startup/shutdown races
                long currentLimit = dataFusionService != null ? dataFusionService.getMemoryPoolLimit() : limit;
        List<String> sortOrders = List.of();
        if (svc == null) return List.of();
     * Applies a new spill memory limit to the running DataFusion runtime when the loaded
     * startup; changing the directory mid-flight would orphan in-progress spill files.
        IndexSettings indexSettings = settings.indexSettings();
import org.opensearch.env.Environment;
     * can collectively borrow above the spill threshold while staying below the 95% critical limit.
     * (shutdown), so callers never see a half-initialized view.
            logger.debug("native memory snapshot: {} active queries", out.size());
        // limit derived from the OLD budget (an off-by-one update). The grouped consumer receives a
import java.io.IOException;
        // cluster settings API take effect without restarting the node.
        // can short-circuit format!() for suppressed levels without polling.
        ScriptService scriptService,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
     * (reduced from 74% to fund the 3% parquet cache budget).
        "datafusion.spill_directory",
        // - Indexed path: indexed_executor reverses segment iteration when the query's leading
     *
    }
    );
 */
        // Two consumers downstream:
            .spillMemoryLimit(spillMemoryLimit)
    // DocumentLookupProvider implementation. Construction deferred until the DataFusion service is live.
import org.opensearch.index.get.DocumentLookupResult;
     * silently not updating at runtime). Unchanged thresholds are filled with their registered
        }
            if (!enabled) {
     */
     * Cap on entries returned by {@link #getTopQueriesByMemory()}. Equal to the per-tick
        clusterService.getClusterSettings()
     * reservation, wall time, and whether the query has completed but not yet been drained.
    }
                    DATAFUSION_MEMORY_GUARD_EXECUTION_CRITICAL_THRESHOLD
        for (Map.Entry<Long, QueryExecutionMetrics> e : metrics.entrySet()) {
                    DATAFUSION_MEMORY_GUARD_ADMISSION_THROTTLE_THRESHOLD,
    private volatile ClusterService clusterService;
        DocumentMetadataResolver resolver
     * that exceed the new limit are not reclaimed — they drain naturally as queries complete.
        536870912L,
                // IndexSortConfig validates size match at index creation, so when
     * RSS fraction above which the execution hard guard forces spill and the
                    sortOrders = IndexSortConfig.INDEX_SORT_ORDER_SETTING.get(rawSettings)
     * Probes the filesystem on each validate call. Cluster-settings updates are infrequent and
     */
     * Disk-staging budget for DataFusion spill. When in-memory operations (HashAggregate, Sort,
    public void setCircuitBreaker(CircuitBreaker circuitBreaker) {
            sortFields,
        Setting.Property.NodeScope,
        if (metrics.isEmpty()) {
            "Updating cache limits: footer_metadata={} bytes, " + "column_index={} bytes, offset_index={} bytes, statistics={} bytes",
        this.substraitExtensions = loadSubstraitExtensions();
            SimpleExtension.ExtensionCollection windowExtensions = SimpleExtension.load(List.of("/opensearch_window_functions.yaml"));
            }
        }
            getService.close();
     * Default: 0.85.
     *   <li>If spill is enabled, the value must not exceed the spill volume's total capacity
    private volatile CircuitBreaker datafusionBreaker;
    public DocumentLookupResult getById(Engine.Get get, IndexReaderProvider.Reader reader, Index index, DocumentMetadataResolver resolver)
        DataFusionPlugin::validateSpillDirectory,
     * {@code limit - buffer_percent}. {@code buffer_percent} is an admission-control throttle
    public static final Setting<Double> DATAFUSION_MEMORY_GUARD_EXECUTION_CRITICAL_THRESHOLD = Setting.doubleSetting(
        1.0,
    static String deriveMemoryPoolLimitDefault(Settings settings) {
     * (service is null, ignored) and during shutdown after the native runtime has
     * so they can finish spilling before the pool rejects them. Bounds how much concurrent spilling
    DataFusionService getDataFusionService() {
     * {@code DiskManagerMode::Disabled} — spill is off and queries that exceed
    /**
     * {@link Long#MAX_VALUE} when AC is unconfigured.
        long limit = DATAFUSION_MEMORY_POOL_LIMIT.get(settings);
     */
    implements
        nativeAllocator.addStatsRefresher(() -> {
            service.setSpillMemoryLimit(newLimitBytes);
        public Iterator<Setting<?>> settings() {
        }
import org.opensearch.plugins.DocumentLookupProvider;
            )
        settings.addAll(DatafusionSettings.INDEX_SCOPED_SETTINGS);
    @Override
import org.opensearch.plugins.CircuitBreakerPlugin;
     * Takes effect for new allocations only. In-flight reservations that already
        "datafusion.memory_guard.execution.critical_threshold",
     * {@link #ACTIVE_QUERY_METRICS_TOP_N} entries (the heaviest live queries).
    private void updateMemoryGuardThresholds(Settings updated) {
import org.opensearch.core.common.breaker.CircuitBreaker;
            if (total <= 0) {
        // Wire the dynamic spill limit setting to the native runtime so updates via the
    }
        // their workload.
            logger.warn("Ignoring memory pool limit update to {}B; service is not running", newLimitBytes);
        clusterService.getClusterSettings()
     * Admission threshold for the jemalloc memory guard (0.0–1.0).
        DataFusionService service = dataFusionService;
        0.75,
import java.util.function.Supplier;
            return Long.toString((long) (total * SPILL_LIMIT_FRACTION));
    /**
    }
    }
        }
                    CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE,
     * defaults in `updated`, so passing all four every time is correct.
        GetService svc = getServiceOrThrow();
     * (see {@link org.opensearch.be.datafusion.nativelib.NativeBridge#isSpillLimitDynamic()}).
            logger.warn("Ignoring spill memory limit update to {}B; service is not running", newLimitBytes);
    /**
        );
     *   <li>{@code streaming} (default) — use {@link DatafusionReduceSink}: each batch is pushed
    public List<String> getSupportedFormats() {
            try {
                sortFields = List.copyOf(fields);
    @Override
        DataFusionPlugin::deriveMemoryPoolLimitDefault,
            return Collections.emptyMap();
            return new long[] { s.getAllocatedBytes(), s.getResidentBytes() };
        double executionSpill = DATAFUSION_MEMORY_GUARD_EXECUTION_SPILL_THRESHOLD.get(updated);
            .build();
        }
        NativeMemoryUsageTracker.setSnapshotSupplier(this::currentBytesByTaskId);
    public static final Setting<Double> DATAFUSION_MEMORY_GUARD_ADMISSION_THROTTLE_THRESHOLD = Setting.doubleSetting(
        return Collections.singletonList(dataFusionService);
        // re-reads via getClusterSettings().get() sees the stale/previous value and pushes the
        clusterService.getClusterSettings().addSettingsUpdateConsumer(DatafusionSettings.CONCURRENCY_DATANODE_MULTIPLIER, multiplier -> {
     * and signals that spill should be disabled. Non-empty values must parse as a {@link Path}.
                    + "support runtime spill resize, so the new value will only take effect after a node restart",
        String dir = DATAFUSION_SPILL_DIRECTORY.get(settings);
        // file sort order to DataFusion. Empty lists when the index has no index sort configured.
     * plugin context the TCCL is typically the server classloader, which cannot see the
import org.opensearch.nativebridge.spi.NativeMemoryFetcher;
     * When pool accounting rejects a phantom reservation but jemalloc reports
        }
        // Apply initial values
        CircuitBreakerPlugin,
    static final double SPILL_LIMIT_FRACTION = 0.90;
        }
     *   <li>{@code memtable} — use {@link DatafusionMemtableReduceSink}: all batches are buffered
     * Number of partitions used by the coordinator-reduce DataFusion plan.
            DATAFUSION_MEMORY_GUARD_ADMISSION_REJECT_THRESHOLD.get(settings),
        Environment environment,
        dataFusionService = DataFusionService.builder()
        }
    /**
            nativeAllocator.setPoolLimit(DatafusionSettings.POOL_DATAFUSION, newMax);
        Setting.Property.Dynamic
     * TopK) exceed {@link #DATAFUSION_MEMORY_POOL_LIMIT}, DataFusion writes working state to disk;
        if (service != null) {
 * Analytics query capabilities are declared in {@link DataFusionAnalyticsBackendPlugin},
        32,
     * Lower values reduce peak memory at the cost of slower single-query latency.
                this::recomputePageCacheLimits,
    static final long SPILL_LIMIT_FALLBACK_BYTES = 8L * 1024 * 1024 * 1024;
 *
    }
     * If the probe fails ({@link IOException}) the capacity check is skipped — operators retain
        try {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        ClassLoader previous = t.getContextClassLoader();
    /**
     * Computes the default for {@link #DATAFUSION_MEMORY_POOL_LIMIT} as 71% of
        return "datafusion";
                org.opensearch.be.datafusion.action.stats.TransportClearCacheAction.class
        return svc.documentLookupService(resolver).getVersionMetadata(id, reader, index);
import org.opensearch.index.IndexSortConfig;
        @Override
import org.opensearch.common.logging.Loggers;
     * Memory pool limit for the DataFusion runtime.
                return NativeBridge.nativeNodeStats();
        NamedXContentRegistry xContentRegistry,
        return datafusionSettings;
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * SPDX-License-Identifier: Apache-2.0
        clusterService.getClusterSettings()
    /**
        NativeAllocator.VirtualPoolHandle dfPool = nativeAllocator.registerVirtualPool(
    /**
    }
     * {@code ResourceTrackerSettings.deriveNativeMemoryLimitDefault}).
        Map<Long, Long> out = new HashMap<>(metrics.size());
        Setting.Property.NodeScope,
            metaLimit,
     * Loads the Substrait default extension catalog with the plugin's classloader as the
        long spillMemoryLimit = DATAFUSION_SPILL_MEMORY_LIMIT.get(settings);
import org.opensearch.common.settings.ClusterSettings;
        "datafusion.memory_guard.execution.spill_threshold",
     * the DataFusion parquet caches (footer metadata, ColumnIndex, OffsetIndex). That 3% is
    /**
        }
            return "0";
    private Map<Long, Long> currentBytesByTaskId() {
     * `lastSettingsApplied`, which is not swapped in until after all update consumers have run, so
import org.opensearch.watcher.ResourceWatcherService;
                        .map(o -> o == SortOrder.DESC ? "desc" : "asc")
    /**
        Supplier<RepositoriesService> repositoriesServiceSupplier,
 * <p>
     */
        Setting.Property.NodeScope,
            if (cm != null) {
            long v = Long.parseLong(s);
     *
        Function.identity(),
     * <p>Optional. When set, DataFusion uses {@code DiskManagerMode::Directories} to spill
    }
     * Spill directory used by DataFusion's {@code DiskManager} for intermediate state when
        NativeBridge.setMemoryGuardThresholds(
        },
     * default), so the heaviest queries are always represented and SBP never sees fewer
            CacheManager cm = service.getCacheManager();
        if (nativeLimit.getBytes() <= 0) {
import org.opensearch.core.indices.breaker.CircuitBreakerStats;
    static final class SpillLimitValidator implements Setting.Validator<Long> {
        // DocumentMetadataResolver is supplied per-call by the engine, so it is not needed here.
        1.0,
        NativeBridge.setMemoryGuardThresholds(admissionThrottle, admissionReject, executionSpill, executionCritical);
        NodeEnvironment nodeEnvironment,
    /**
            // still registered on ClusterSettings because there is no removeSettingsUpdateConsumer
     */
        });
    @Override
                throw new IllegalArgumentException(
        NativeBridge.setColumnIndexCacheLimit(ciLimit);
     * Selects how the coordinator-reduce sink hands shard responses to the native runtime.
     * Kill-switch for the scoped page-index feature.
            if (total > 0 && value > total) {
     * margin into the framework's hard cap.
        NativeBridge.setReduceTargetPartitions(DATAFUSION_REDUCE_TARGET_PARTITIONS.get(settings));
import org.opensearch.index.engine.exec.EngineReaderManager;
     *
import java.util.ArrayList;
     * this setting caps how much disk space that staging can consume.
        Setting.Property.NodeScope,
     *
    DatafusionSettings getDatafusionSettings() {
     * plugin-local Substrait classes.
     * ({@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}), which is
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
    @Override
    public void close() throws IOException {
            t.setContextClassLoader(DataFusionPlugin.class.getClassLoader());
     * separate, already-allocated region with no relation to native-memory sizing).
    }
    /**
     *   <li>When set, returns {@link #SPILL_LIMIT_FRACTION} of the spill volume's
            .datanodeMultiplier(DatafusionSettings.CONCURRENCY_DATANODE_MULTIPLIER.get(settings))
        long pool = Math.max(0L, nativeLimit.getBytes() * 71 / 100);
            SimpleExtension.ExtensionCollection delegationExtensions = SimpleExtension.load(List.of("/delegation_functions.yaml"));
    private volatile DataFormatRegistry dataFormatRegistry;
     * <ul>
        Setting.Property.NodeScope,
            SimpleExtension.ExtensionCollection aggregateExtensions = SimpleExtension.load(List.of("/opensearch_aggregate_functions.yaml"));
        NativeBridge.setSpillExemptCapBytes(DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP.get(settings));
    }
            }
        nativeAllocator.setNativeMemoryStatsSupplier(() -> {
    public static final Setting<Boolean> SCOPED_PAGE_INDEX_ENABLED = Setting.boolSetting(
    }
                if (IndexSortConfig.INDEX_SORT_ORDER_SETTING.exists(rawSettings)) {
        if (!service.isSpillLimitDynamic()) {
import org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker;
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
    public Map<Long, QueryExecutionMetrics> getTopQueriesByMemory() {
     * Package-private for testing.
                    DATAFUSION_MEMORY_GUARD_EXECUTION_SPILL_THRESHOLD,
    @Override
     * cycle still resolves against the previous settings and would derive limits from the stale
        // Recompute and push absolute cache limits whenever the total budget or any
        clusterSettings.addSettingsUpdateConsumer(DATAFUSION_MEMORY_POOL_LIMIT, newMax -> {
     * Protects running queries from new arrivals when memory is elevated.
        });
                // index.sort.order is set its length equals fields.length. When omitted,
        DataFusionService service = dataFusionService;
        "datafusion.memory_guard.admission_reject_threshold",
     * {@code FsHealthService}. This validator only constrains the syntactic form of the setting.
                    CacheSettings.COLUMN_INDEX_CACHE_PERCENT,
        });
        0L,
     * preserve pre-AC behaviour rather than make up a number from JVM heap (which is a
        // The four memory-guard thresholds are pushed to the native pool together via a single
    private static final int ACTIVE_QUERY_METRICS_TOP_N = 10;
            return;
     * <p>Dynamic: changes take effect for new allocations only. Existing reservations
    /**
     * than from physical RAM or the off-heap carve-out. This sizes correctly on both supported
import org.opensearch.rest.RestHandler;
        GetService svc = getService;
        if (dir == null || dir.isEmpty()) {
        double admissionThrottle = DATAFUSION_MEMORY_GUARD_ADMISSION_THROTTLE_THRESHOLD.get(updated);
                return new AnalyticsBackendTaskCancellationStats(0, 0, 0, 0);
    }
            .memoryPoolLimit(memoryPoolLimit)
        } finally {
     * funded by 2% from the operator pool and 1% from the unmanaged headroom (which expanded
        Setting.Property.NodeScope,
        return substraitExtensions;
        this.datafusionSettings = new DatafusionSettings(clusterService);
import java.util.HashMap;
        1.0,
     * <p>Returns the bytes-as-string representation expected by the {@link Setting} parser.
import org.opensearch.core.common.unit.ByteSizeValue;
    private static final Logger logger = LogManager.getLogger(DataFusionPlugin.class);
     * margin, not a framework budget reduction; subtracting it here would collapse AC's safety
     */
        Map<Long, QueryExecutionMetrics> metrics = getTopQueriesByMemory();
     * <p>Reduced from 74% to 71%: 3% of {@code node.native_memory.limit} is now reserved for
     * cluster-settings update is accepted unconditionally because the value is read at next
    static String validateSpillDirectory(String value) {
            DATAFUSION_MEMORY_GUARD_ADMISSION_THROTTLE_THRESHOLD.get(settings),
    public List<DocumentLookupResult> getDocsAboveSeqNo(
     * retains the full page index (fallback mode). Default: true.
            }
        ClusterService clusterService,
            }
        }
        return new BreakerSettings(
     */
                )
                dfPool.updateStats(usage, usage);
     *
     */
     *       in Java and handed across in one call as a {@code MemTable}. Trades memory for a
    @Override
     *   <li>When {@link #DATAFUSION_SPILL_DIRECTORY} is unset (empty), returns {@code "0"} —
    );
            if (dir == null) {
import org.opensearch.arrow.spi.NativeAllocator;
        // The total-size budget and the four sub-cache percentages together determine the
/**
            } catch (IOException e) {
import org.opensearch.index.engine.exec.IndexReaderProvider;
    public static final Setting<Double> DATAFUSION_MEMORY_GUARD_EXECUTION_SPILL_THRESHOLD = Setting.doubleSetting(
                return Long.toString(SPILL_LIMIT_FALLBACK_BYTES);
            } catch (Exception e) {
import org.opensearch.rest.RestController;
        logger.info(
        GetService svc = getService;
        true,
        // The grouped consumer receives a Settings built from the cycle's new (`current`) settings,
     *       {@link FileStore#getTotalSpace() total space}.</li>
                    DATAFUSION_MEMORY_GUARD_ADMISSION_REJECT_THRESHOLD,
                );
        "datafusion.scoped_page_index.enabled",
/*
        return result;
import org.opensearch.be.datafusion.action.stats.RestDataFusionStatsAction;
        new Setting.SimpleKey("datafusion.spill_memory_limit_bytes"),
    /**
        );
            String dir = (String) dependencies.get(DATAFUSION_SPILL_DIRECTORY);
        if (logger.isDebugEnabled()) {
            newMin -> nativeAllocator.setPoolMin(DatafusionSettings.POOL_DATAFUSION, newMin)
import org.opensearch.env.NodeEnvironment;
        Setting.Property.Dynamic
import org.opensearch.nativebridge.spi.RustLoggerBridge;
     * <ul>
            return List.of();
                return NativeMemoryFetcher.fetch();
import org.opensearch.threadpool.ThreadPool;
            }
     * disabled and the cap is irrelevant. Falls back to {@link #SPILL_LIMIT_FALLBACK_BYTES}
    ) {
    private volatile GetService getService;
        Setting.Property.NodeScope,
                dir = "";
                return new CircuitBreakerStats("analytics_backend_datafusion", currentLimit, stats[0], 1.0, stats[1]);
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
     * allocation decision.
            NativeBridge.updateConcurrencyGate("fragment_executor", newMax);
            throw new IllegalStateException("GetService is not initialized. ");
        throws IOException {
     * partitioning model), so the default takes 71% of {@code node.native_memory.limit}
            .addSettingsUpdateConsumer(DATAFUSION_REDUCE_TARGET_PARTITIONS, NativeBridge::setReduceTargetPartitions);
        Setting.Property.Dynamic
        }
     * queries by {@code current_bytes}, selected on the Rust side. Iteration order matches the
     * actual RSS below this fraction of the pool limit, the reservation proceeds
     * RSS fraction at which memory is considered critical. Serves dual purpose:
        }
    ) throws IOException {
        public void validate(Long value) {
        double executionCritical = DATAFUSION_MEMORY_GUARD_EXECUTION_CRITICAL_THRESHOLD.get(updated);
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        );
        }
import org.opensearch.plugins.PluginComponentRegistry;
    ClusterService getClusterService() {
            DATAFUSION_MEMORY_POOL_LIMIT.get(settings),
    private void recomputePageCacheLimits(org.opensearch.common.settings.Settings updated) {
     * Project the active-query metrics map down to {@code taskId -> currentBytes} for the
        s -> {
            // Service has been stopped/closed (e.g., during node shutdown). The listener is
     * builds from the cycle's new settings — rather than re-reading via
    /**
                .merge(scalarExtensions)
            .addAffixUpdateConsumer(Loggers.LOG_LEVEL_SETTING, (namespace, level) -> RustLoggerBridge.pushLevel(), (k, v) -> {});
     * <p>
    }
            return v;
    public Collection<Object> createComponents(
        0.85,
        return svc.documentLookupService(resolver).getDocsAboveSeqNo(fromSeqNoExclusive, reader, index);
    private GetService getServiceOrThrow() {
        this.datafusionBreaker = circuitBreaker;
            service.setMemoryPoolLimit(newLimitBytes);
        logger.info(
                        .toList();
        1,
            logger.warn(
        // so reading each threshold from it yields the value just set.
     *   <li>If spill is disabled (empty directory), the limit is a no-op and any value is accepted —
        public void validate(Long value, Map<Setting<?>, Object> dependencies) {
        // 71% of node.native_memory.limit. DataFusion is the dominant native consumer for
    private volatile DataFusionService dataFusionService;
    }
 * which is SPI-discovered and receives this plugin instance via its constructor.
        SearchBackEndPlugin<DatafusionReader>,
        return clusterService;
    }
        this.clusterService = clusterService;
            DatafusionSettings.POOL_DATAFUSION,
     *       returns {@link #SPILL_LIMIT_FALLBACK_BYTES} — a conservative 8 GiB.</li>
        long statsLimit = total * statsPct / 100;
    }
     * order Rust drained the bounded min-heap (unspecified but stable per snapshot).
            return Collections.emptyList();
    private static SimpleExtension.ExtensionCollection loadSubstraitExtensions() {
        // settings framework only swaps in AFTER all update consumers have run — so a callback that
        // Expose per-task native-memory usage to search backpressure.
    }
        // absolute CI/OI limits, so they are wired through a single grouped Consumer<Settings>.
            oiLimit,
        "streaming",
        if (dir == null || dir.isEmpty()) {
import org.opensearch.transport.client.Client;
     */
    /**
        // ORDER BY runs counter to the catalog direction.
    public static final Setting<Integer> DATAFUSION_MIN_TARGET_PARTITIONS = Setting.intSetting(
            logger.info("Updated DataFusion spill memory limit to {}B", newLimitBytes);
                // useless in fallback mode and would waste native heap.
                return new AnalyticsBackendNativeMemoryStats(-1, -1, 0);
     *
            new ActionHandler<>(
        IndexScopedSettings indexScopedSettings,
        return () -> {
     */
    }
        DataFormatRegistry dataFormatRegistry = pluginComponentRegistry.getComponent(DataFormatRegistry.class)
     * `updated` Settings supplied by the grouped settings-update consumer — which the framework
        NativeBridge.setMinTargetPartitions(value);
        int cpuThreads = DataFusionService.cpuThreadCount();
     * adaptive reduction (the budget system will never reduce below this floor).
    public List<RestHandler> getRestHandlers(
    void updateMinTargetPartitions(int value) {
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
     * <ul>
        1,
    }
                throw new IllegalArgumentException("Setting [datafusion.memory_pool_limit_bytes] must be >= 0, got " + v);
            logger.warn("Ignoring spill memory limit update to {}B; native runtime does not support live updates", newLimitBytes);
        GetService getService = getServiceOrThrow();
     */
            Settings rawSettings = indexSettings.getSettings();
                return;
     * - Cancel path (post-CAS-fail): terminates query when spill can't help (last resort)
            logger.info("Updated DataFusion memory pool limit to {}B", newLimitBytes);
                // Spill disabled: the limit has no effect and there is no volume to size it against,
     */
    }
import org.opensearch.be.datafusion.cache.CacheManager;
            return v;
        long oiLimit = total * oiPct / 100;
        PluginComponentRegistry pluginComponentRegistry
                // boot-time default derivation.
        return List.copyOf(settings);
            dataFusionService.close();
    }
        long ciLimit = total * ciPct / 100;
     * Setting this equal to the configured target_partitions effectively disables
        Setting.Property.Dynamic
            if (!"streaming".equals(v) && !"memtable".equals(v)) {
                List.of(
        if (dataFusionService != null) {
        }
    public Supplier<AnalyticsBackendNativeMemoryStats> getAnalyticsBackendNativeMemoryStats() {
    );
    public static final Setting<Long> DATAFUSION_MEMORY_POOL_LIMIT = new Setting<>(
            logger.debug("DataFusion service not yet initialized; ignoring memory pool limit update to {}B", newLimitBytes);
        try {
     * <p>When unset, the default is derived from the admission-control native-memory budget
        return out;
     * the probe is a single syscall (~µs), so caching is not worth the bookkeeping cost.
import org.opensearch.core.index.Index;
        Setting.Property.Dynamic
        AnalyticsSearchBackendPlugin,
        Setting.Property.Dynamic
        DataFusionService service = dataFusionService;
                long usage = dataFusionService.getMemoryPoolUsage();
        @Override
 * compatible open source license.
        long fromSeqNoExclusive,
        Setting.Property.NodeScope,
        ActionPlugin,
        Setting.Property.NodeScope,
            settings.shardPath(),
     *       simpler input lifecycle with no cross-runtime spawn or oneshot machinery.</li>
        CacheSettings.validatePercentSum(metaPct, oiPct, ciPct, statsPct);
        List<Setting<?>> settings = new ArrayList<>(DatafusionSettings.NODE_SCOPED_SETTINGS);
    /**
    }
        // Push Rust log level whenever any logger.* cluster setting changes, so Rust macros
     * Recompute absolute ColumnIndex and OffsetIndex cache limits from the updated
        // grouped consumer. This MUST use the grouped Consumer<Settings> overload (not
                throw new IllegalArgumentException("datafusion.reduce.input_mode must be 'streaming' or 'memtable', got: " + v);
        return dataFusionService;
        DataFusionPlugin::deriveSpillLimitDefault,
import java.util.Map;
import org.opensearch.arrow.spi.PoolGroup;
            }
     *
import java.nio.file.FileStore;
        }
        if (service == null) {
     * {@link CacheSettings#METADATA_INDEX_CACHE_TOTAL_SIZE} and percent settings, then push them
     * <p>Spill is a disk budget, so the default is derived from the disk volume itself
        if (service == null) {
     *   <li>When the file store cannot be probed (transient FS hiccup after boot probe),
        ClusterSettings clusterSettings,
     * candidates than it can act on in a tick.
        0.85,
    }
                long[] stats = dataFusionService != null ? dataFusionService.getMemoryPoolStats() : new long[] { 0, 0 };
        } catch (IllegalStateException e) {
    @Override
            long total;
                .merge(arrayExtensions)
     * Default: 0.95.
    );
            SimpleExtension.ExtensionCollection arithmeticOverloads = SimpleExtension.load(
        logger.info("Updated DataFusion min_target_partitions to {}", value);
                org.opensearch.be.datafusion.action.stats.ClearCacheActionType.INSTANCE,
     * <p>The fraction is taken straight from {@code node.native_memory.limit}, not from
     * logs a warning in that case.
     */
     * {@link #DATAFUSION_MEMORY_POOL_LIMIT} fail with a clear "DiskManager is disabled" error
        "datafusion.memory_guard.spill_exempt_cap_bytes",
import org.opensearch.common.settings.IndexScopedSettings;
     * <p>Dynamic only when the loaded native library exports {@code df_set_spill_limit}
     *
import io.substrait.extension.DefaultExtensionCatalog;
        "datafusion.memory_pool_limit_bytes",
     * Get-by-id entry point. Delegates to {@link GetService}, which fetches the row through the native runtime.
import org.opensearch.script.ScriptService;
import org.opensearch.plugins.Plugin;
        clusterService.getClusterSettings().addSettingsUpdateConsumer(DATAFUSION_SPILL_MEMORY_LIMIT, this::updateSpillMemoryLimit);
            .spillDirectory(spillDir)
    private static final String SUPPORTED_FORMAT = "parquet";
import java.util.List;
        if (value == null || value.isEmpty()) {
import org.opensearch.plugins.SearchBackEndPlugin;
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> DATAFUSION_MEMORY_POOL_LIMIT.get(clusterService.getSettings()));
        IndexReaderProvider.Reader reader,
                    CacheSettings.FOOTER_METADATA_CACHE_PERCENT,
        SettingsFilter settingsFilter,
        }
    public static final Setting<String> DATAFUSION_SPILL_DIRECTORY = new Setting<>(
            // against a race between probe and call.
            return value;
    );
        Setting.Property.Dynamic
    ) throws IOException {
        int statsPct = CacheSettings.STATISTICS_CACHE_PERCENT.get(updated);
            );
        );
        0.0,
        double admissionReject = DATAFUSION_MEMORY_GUARD_ADMISSION_REJECT_THRESHOLD.get(updated);
        Index index,
    );
        }
        }
     */
            if (dir.isEmpty()) {
     * Default: 1 (allow full reduction range).
            } catch (Exception e) {
    /**
        4,
     *
    @Override
    private volatile SimpleExtension.ExtensionCollection substraitExtensions;
     * When false, the scoped CI/OI caches are bypassed and the metadata cache
     */
     * <p>
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
                // Probe failed — skip the capacity check. Same fail-open behavior as the
     * override (which allows allocations despite pool rejection) is disabled.
     * More partitions = more parallelism = more memory (each partition holds its own hash table).
     * directory on the same disk as the OpenSearch process.
        return svc;
            DATAFUSION_MEMORY_GUARD_EXECUTION_SPILL_THRESHOLD.get(settings),
        DocumentMetadataResolver resolver
     */
import org.opensearch.search.sort.SortOrder;
    );
     *       the capacity check has no volume to probe, so it is skipped.</li>
    /** Fallback when the spill volume's capacity cannot be probed. 8 GiB. */
        clusterService.getClusterSettings().addSettingsUpdateConsumer(DATAFUSION_MIN_TARGET_PARTITIONS, this::updateMinTargetPartitions);
        ThreadPool threadPool,
     * Computes the default for {@link #DATAFUSION_SPILL_MEMORY_LIMIT}.
        try {
    }
import org.opensearch.be.datafusion.cache.CacheUtils;
            CircuitBreaker.Type.MEMORY,
        Setting.Property.Final
                NativeBridge.clearOffsetIndexCache();
        if (svc == null) {
        Settings settings = environment.settings();
import java.util.function.Function;
    /**
            .addSettingsUpdateConsumer(
        RestController restController,
import org.opensearch.be.datafusion.action.stats.DataFusionStatsActionType;
        0.0,
     * The map contains at most {@link #ACTIVE_QUERY_METRICS_TOP_N} entries — the heaviest live
     * If the AC limit is unset (== 0), the default is {@link Long#MAX_VALUE} — unbounded — to
        );
                logger.info("Scoped page-index disabled: cleared CI and OI caches");
        // Wire dynamic setting consumers for pool min/max
        if (dataFusionService == null) {
import org.opensearch.index.engine.Engine;
            new ActionHandler<>(DataFusionStatsActionType.INSTANCE, TransportDataFusionStatsAction.class),
                    "Setting [datafusion.spill_memory_limit_bytes]=" + value + " exceeds spill volume capacity (" + total + " bytes)"
     * - Hard guard (pre-CAS): forces spill when pool accounting lags jemalloc (recoverable)
        IndexReaderProvider.Reader reader,
        // `v -> updateMemoryGuardThresholds()` re-reading via getClusterSettings().get()): during
    }
    /**
            NativeBridge.setScopedPageIndexEnabled(enabled);
     * node startup. Package-private for testing.
        return List.of(Path.of(dir));
     * thread context classloader. Jackson polymorphic deserialization (used by Substrait
    }
    private volatile DatafusionSettings datafusionSettings;
            if (v < 0) {
        );
            if (!fields.isEmpty()) {
        Setting.Property.NodeScope,
            // API; swallow the race so cluster-state application does not log a spurious failure.
            );
     * by {@link #getAdditionalHealthPaths(Settings)}), and at runtime by
        clusterService.getClusterSettings()
     * <p>Declared before {@link #DATAFUSION_SPILL_MEMORY_LIMIT} because the {@code Setting}
     *       through a tokio mpsc, the native plan polls inputs as it executes.</li>
     * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}, falling back to
            }
     * to load its {@code SimpleExtension} subclasses) consults the TCCL; in an OpenSearch
                    sortOrders = fields.stream().map(f -> "asc").toList();
            if (v < 0) {
        }
     * backpressure native-memory tracker. One FFM snapshot per call, capped at
        return Long.toString(pool);
import org.apache.logging.log4j.LogManager;
     */
        // an apply cycle the per-setting getter resolves against `lastSettingsApplied`, which the
     */
    @Override
    /**
        1.0,
        },
                    CacheSettings.STATISTICS_CACHE_PERCENT
        clusterService.getClusterSettings().addSettingsUpdateConsumer(SCOPED_PAGE_INDEX_ENABLED, enabled -> {
                )
     * RSS fraction above which new queries are rejected (429 backpressure).
import java.util.Collection;
            }
package org.opensearch.be.datafusion;
    /** Fraction of the spill volume's total capacity used as the default cap. */
     * patterns: a dedicated EBS volume mounted at the spill directory, or the spill
    @Override
     * {@code Node.assertCanWritePluginHealthPaths} probe (which consumes the path returned
import org.apache.logging.log4j.Logger;
        try {
        Supplier<DiscoveryNodes> nodesInCluster
            t.setContextClassLoader(previous);
     *       (probed live via {@link FileStore#getTotalSpace()}).</li>
     * native library exports {@code df_set_spill_limit}; otherwise emits a warning. The
    }
import java.nio.file.Path;
        try {
            if (dataFusionService != null) {
     * exceed the new limit are not reclaimed and drain as queries complete.
            }
    public BreakerSettings getCircuitBreaker(Settings settings) {
                NativeBridge.clearColumnIndexCache();
        // settings framework only swaps in AFTER all update consumers have run — so a callback that
        "datafusion.reduce.target_partitions",
        }
     * <p>Existence and writability are checked at boot time by the core
     * <p>Each entry mirrors one {@code QueryTracker} on the Rust side — current and peak memory
                total = Environment.getFileStore(Path.of(dir)).getTotalSpace();
        0.0,
        return dataFormatRegistry;
                    CacheSettings.OFFSET_INDEX_CACHE_PERCENT,
        // - Vanilla path: ListingOptions.with_file_sort_order so the planner can drop SortExec.
 * Main plugin class for the DataFusion native engine integration.
import java.util.Collections;
    @Override
     *
     * <p>Reads each value from the {@code updated} Settings supplied by the grouped settings-update
    );
import org.opensearch.indices.breaker.BreakerSettings;
     * runtime is the dominant native-memory consumer for analytics workloads (see PR #21732
                }
    /**
     */
import org.opensearch.plugins.ActionPlugin;
        clusterService.getClusterSettings()
        if (dataFusionService == null) {
        "datafusion.memory_guard.admission_throttle_threshold",
     * at full parallelism (false-positive override). Lower = more conservative.
        return getService.documentLookupService(resolver).getById(get.id(), reader, index);
import org.opensearch.common.settings.Settings;
     * cancellation budget on {@code SearchBackpressureService} ({@code cancellation_burst}
            return Collections.emptyMap();
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
            AnalyticsBackendNativeMemoryStats s = NativeMemoryFetcher.fetch();
            long v = Long.parseLong(s);
            try {
     * from 21% to 20% of off-heap via the 79→80% change to
            settings.format(),
import org.opensearch.action.ActionRequest;
        dataFusionService.start();
     * Default: 0.75.
    @Override
import org.opensearch.core.action.ActionResponse;
    public DocumentLookupResult getVersionMetadata(
import org.opensearch.be.datafusion.action.stats.TransportDataFusionStatsAction;
        Index index,
     */
        "",
        // an apply cycle the per-setting getter resolves against `lastSettingsApplied`, which the
        // re-reads sees the stale/previous value and would push defaults instead of the new value.
            SimpleExtension.ExtensionCollection arrayExtensions = SimpleExtension.load(List.of("/opensearch_array_functions.yaml"));
     * <p>{@code Final} because DataFusion's {@code DiskManager} is built once at runtime
        int ciPct = CacheSettings.COLUMN_INDEX_CACHE_PERCENT.get(updated);
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
        });
            updateMemoryPoolLimit(newMax);
        }
import org.opensearch.repositories.RepositoriesService;
        }
     * Safe to call during plugin startup before {@link #createComponents} returns
            admissionThrottle,
        },
                // so accept any value rather than rejecting startup over an inert setting.
        long memoryPoolLimit = DATAFUSION_MEMORY_POOL_LIMIT.get(settings);
        return value;
        Setting.Property.Dynamic
    public static final Setting<String> DATAFUSION_REDUCE_INPUT_MODE = Setting.simpleString(
     */
            try {
        }
        Client client,
        List<String> sortFields = List.of();
                .merge(aggregateExtensions)
     */
        0.0,
            DatafusionSettings.DATAFUSION_MEMORY_POOL_MIN.get(settings),
        });
        return () -> {
                // every field defaults to asc — matches IndexSortConfig behavior.
        int oiPct = CacheSettings.OFFSET_INDEX_CACHE_PERCENT.get(updated);
            .addSettingsUpdateConsumer(DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP, NativeBridge::setSpillExemptCapBytes);
        NativeBridge.setOffsetIndexCacheLimit(oiLimit);
     * `clusterService.getClusterSettings().get(...)`. The latter resolves against
    public static final Setting<Long> DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP = Setting.longSetting(
            1.0,
        Setting.Property.Dynamic
    }
        "datafusion.min_target_partitions",
    ) {
            () -> {
            }
        // analytics workloads; operators tune via the dynamic setting once they characterize
            }
        Setting.Property.NodeScope,
            .clusterSettings(clusterService.getClusterSettings())
    @Override
     *
     * been released (service throws {@link IllegalStateException}, caught and logged).
        }
            List<String> fields = IndexSortConfig.INDEX_SORT_FIELD_SETTING.get(rawSettings);
     * consumer — NOT via {@code clusterService.getClusterSettings().get(...)}, which during an apply
import org.opensearch.common.settings.Setting;
import org.opensearch.plugins.NativeStoreHandle;
 * Owns the {@link DataFusionService} lifecycle (memory pool, native runtime).
        Map<Long, QueryExecutionMetrics> result = NativeBridge.getTopNQueriesByMemory(ACTIVE_QUERY_METRICS_TOP_N);
        NativeStoreHandle dataformatAwareStoreHandle = settings.dataformatAwareStoreHandles().get(settings.format());
        Thread t = Thread.currentThread();
        return List.of(
            .addSettingsUpdateConsumer(
    /**
     * Validates {@link #DATAFUSION_SPILL_DIRECTORY}. Empty (the unset sentinel) is accepted
    }
        @Override
            dataFusionService,
            statsLimit
     */
            );
        NativeBridge.setScopedPageIndexEnabled(SCOPED_PAGE_INDEX_ENABLED.get(settings));
            .orElseThrow(() -> new IllegalStateException("DataFormatRegistry is not available during DataFusion initialization"));
            SimpleExtension.ExtensionCollection scalarExtensions = SimpleExtension.load(List.of("/opensearch_scalar_functions.yaml"));
     *
     * Default 536870912 (512MB) expressed in raw bytes. Live-tunable — takes effect on the next
            executionCritical
                "Updated DataFusion spill memory limit to {}B at the cluster level; the loaded native library does not "
    );
    /**
        };
        );
     * Default: 0.85.
    /**
        String dir = DATAFUSION_SPILL_DIRECTORY.get(settings);
            PoolGroup.SEARCH,
    public DataFusionPlugin() {}
        } catch (java.nio.file.InvalidPathException e) {
     * Total in-flight allocation in bytes allowed through the 85% spill gate by spillable consumers
        this.getService = new GetService(this);
            return;
                List.of("/opensearch_arithmetic_overloads.yaml")
            }
                .merge(windowExtensions)
     *
    public List<Path> getAdditionalHealthPaths(Settings settings) {
     */
import org.opensearch.index.IndexSettings;
import org.opensearch.analytics.spi.QueryExecutionMetrics;
    public static final Setting<Long> DATAFUSION_SPILL_MEMORY_LIMIT = new Setting<>(
     * (8 GiB) when the spill volume cannot be probed.
    }
     * When the symbol is absent the setting can still be updated at the cluster level,
            out.put(e.getKey(), e.getValue().currentBytes());
            // isSpillLimitDynamic() guard above should make this unreachable, but defend
        );
        0.95,
    void updateMemoryPoolLimit(long newLimitBytes) {
     * to the configured path. When unset (empty), DataFusion runs in
     * the ability to set the cap; only the safety-net validation is disabled.
        }
     * re-reading mid-cycle would yield the stale/previous value (the root cause of thresholds
    static String deriveSpillLimitDefault(Settings settings) {
     * budget, not a memory budget, so the default is derived from the disk volume itself rather
    }
            }
                } else {
            "Updated DataFusion memory guard thresholds: admission_throttle={}, admission_reject={}, execution_spill={}, execution_critical={}",
        v -> {
     *
    @Override
import org.opensearch.be.datafusion.cache.CacheSettings;
        return List.of(SUPPORTED_FORMAT);
    );
    DataFormatRegistry getDataFormatRegistry() {
            }
                return;
        }
        long total = CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE.get(updated).getBytes();
     * rather than silently spilling somewhere unexpected.
     * map. Returns an empty map when the service is not yet running (startup) or has been stopped
            logger.debug("getTopQueriesByMemory: {} entries from native registry", result.size());
     * to native. Validates that percentages sum to 100 before applying.
        };
public class DataFusionPlugin extends Plugin
        // sub-cache percentage changes. Validates that percentages sum to 100 first.
        logger.debug("DataFusion plugin initialized — memory pool {}B, spill limit {}B", memoryPoolLimit, spillMemoryLimit);
        s -> {
     * the same off-heap budget admission control throttles against. The DataFusion Rust
        return List.of(new RestDataFusionStatsAction(), new org.opensearch.be.datafusion.action.stats.RestClearCacheAction());
            logger.debug("DataFusion service not yet initialized; ignoring spill limit update to {}B", newLimitBytes);
        NativeAllocator nativeAllocator = pluginComponentRegistry.getComponent(NativeAllocator.class)
        if (getService != null) {
            .orElseThrow(() -> new IllegalStateException("NativeAllocator is not available; arrow-base plugin must be installed"));
     * </ul>
        Setting.Property.Dynamic
            DatafusionSettings.DATAFUSION_MEMORY_POOL_MIN,
import org.opensearch.common.settings.SettingsFilter;
     */
     * <p>When {@link #DATAFUSION_SPILL_DIRECTORY} is unset (empty), returns {@code 0} — spill is
     * rather than from physical RAM. This sizes correctly on both supported deployment
        } catch (UnsupportedOperationException e) {
        // Build the get-by-id service now that the DataFusion runtime is live. The
        } catch (IllegalStateException e) {
        DocumentLookupProvider {
    public EngineReaderManager<DatafusionReader> createReaderManager(ReaderManagerConfig settings) throws IOException {
    @Override
        long metaLimit = total * metaPct / 100;
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
     * Minimum target partitions floor for the adaptive budget system.
     * <p><strong>Default: 80% of the spill volume's total disk capacity.</strong> Spill is a disk
                this::updateMemoryGuardThresholds,
        Setting.Property.NodeScope,
import java.util.Iterator;
            this::updateMemoryPoolLimit
    public static final Setting<Double> DATAFUSION_MEMORY_GUARD_ADMISSION_REJECT_THRESHOLD = Setting.doubleSetting(
        clusterSettings.addSettingsUpdateConsumer(
            dataformatAwareStoreHandle,
        Settings settings,
        }
            ciLimit,
                newLimitBytes
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;
        if (dataFusionService == null) {
                .merge(arithmeticOverloads);
