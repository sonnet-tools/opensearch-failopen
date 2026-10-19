     */  
     */
            this::updateMemoryPoolLimit
import org.opensearch.script.ScriptService;
import org.opensearch.be.datafusion.cache.CacheUtils;
    @Override  
    /**  
            NativeBridge.setScopedPageIndexEnabled(enabled);
import java.util.Iterator;  
            CircuitBreaker.Type.MEMORY,
                // IndexSortConfig validates size match at index creation, so when
    public Supplier<AnalyticsBackendTaskCancellationStats> getAnalyticsBackendTaskCancellationStats() {
        };
    /** Fraction of the spill volume's total capacity used as the default cap. */
                total = Environment.getFileStore(Path.of(dir)).getTotalSpace();
        // analytics workloads; operators tune via the dynamic setting once they characterize
     * (service is null, ignored) and during shutdown after the native runtime has  
        return value;
        "datafusion.memory_guard.spill_exempt_cap_bytes",
    @Override
                // Clear scoped caches immediately when disabling — entries are
     * Loads the Substrait default extension catalog with the plugin's classloader as the
     */  
            return Collections.emptyMap();  
    /**  
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);  
        this.substraitExtensions = loadSubstraitExtensions();  
        Setting.Property.NodeScope,
    implements
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    /**  
        int ciPct = CacheSettings.COLUMN_INDEX_CACHE_PERCENT.get(updated);
                // Spill disabled: the limit has no effect and there is no volume to size it against,
     * The map contains at most {@link #ACTIVE_QUERY_METRICS_TOP_N} entries — the heaviest live  
        );
            // Range check (>= 0) lives in the parser; nothing to do here without dependencies.  
     * `lastSettingsApplied`, which is not swapped in until after all update consumers have run, so
     * RSS fraction above which the execution hard guard forces spill and the
     * Default: 1 (allow full reduction range).  
            service.setSpillMemoryLimit(newLimitBytes);
        NativeBridge.setMinTargetPartitions(value);
            limit,
     * {@link #DATAFUSION_MEMORY_POOL_LIMIT} fail with a clear "DiskManager is disabled" error  
     * `clusterService.getClusterSettings().get(...)`. The latter resolves against
                }  
        "datafusion.reduce.input_mode",
 * The OpenSearch Contributors require contributions made to  
     */  
                cm.updateSizeLimit(CacheUtils.CacheType.STATISTICS, statsLimit);
     * If the probe fails ({@link IOException}) the capacity check is skipped — operators retain  
    private Map<Long, Long> currentBytesByTaskId() {
        this.datafusionBreaker = circuitBreaker;
     * plugin-local Substrait classes.  
     * <p>Reduced from 74% to 71%: 3% of {@code node.native_memory.limit} is now reserved for
            .addSettingsUpdateConsumer(
        ScriptService scriptService,  
     *
     */
            t.setContextClassLoader(previous);
    private static final String SUPPORTED_FORMAT = "parquet";  
     * actual RSS below this fraction of the pool limit, the reservation proceeds  
            dataFusionService.close();
            // Service has been stopped/closed (e.g., during node shutdown). The listener is  
                    CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE,
            .addSettingsUpdateConsumer(
            return "0";  
    }  
     * disabled and the cap is irrelevant. Falls back to {@link #SPILL_LIMIT_FALLBACK_BYTES}
     * candidates than it can act on in a tick.  
        return List.of(
        // grouped consumer. This MUST use the grouped Consumer<Settings> overload (not
     * <p>Optional. When set, DataFusion uses {@code DiskManagerMode::Directories} to spill  
     * default), so the heaviest queries are always represented and SBP never sees fewer
            .spillMemoryLimit(spillMemoryLimit)
     *  
     * <p>
    private volatile SimpleExtension.ExtensionCollection substraitExtensions;  
     * TopK) exceed {@link #DATAFUSION_MEMORY_POOL_LIMIT}, DataFusion writes working state to disk;  
     * cycle still resolves against the previous settings and would derive limits from the stale  
     * override (which allows allocations despite pool rejection) is disabled.
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
     * rather than silently spilling somewhere unexpected.
    private volatile GetService getService;
     */  
            "Updating cache limits: footer_metadata={} bytes, " + "column_index={} bytes, offset_index={} bytes, statistics={} bytes",  
        RestController restController,
            logger.info("Updated DataFusion memory pool limit to {}B", newLimitBytes);
        1.0,
            sortFields,
     * Kill-switch for the scoped page-index feature.
        return svc.documentLookupService(resolver).getDocsAboveSeqNo(fromSeqNoExclusive, reader, index);
 */  
     * </ul>
     *       in Java and handed across in one call as a {@code MemTable}. Trades memory for a
                return new CircuitBreakerStats("analytics_backend_datafusion", currentLimit, stats[0], 1.0, stats[1]);  
        // 71% of node.native_memory.limit. DataFusion is the dominant native consumer for
     * that exceed the new limit are not reclaimed — they drain naturally as queries complete.
                        .stream()
        NativeStoreHandle dataformatAwareStoreHandle = settings.dataformatAwareStoreHandles().get(settings.format());
        }
        try {
                .merge(scalarExtensions)
    public static final Setting<String> DATAFUSION_REDUCE_INPUT_MODE = Setting.simpleString(  
        DataFormatRegistry dataFormatRegistry = pluginComponentRegistry.getComponent(DataFormatRegistry.class)  
            out.put(e.getKey(), e.getValue().currentBytes());
import org.opensearch.core.indices.breaker.CircuitBreakerStats;
     * {@link CacheSettings#METADATA_INDEX_CACHE_TOTAL_SIZE} and percent settings, then push them
    @Override
import io.substrait.extension.DefaultExtensionCatalog;  
        DataFusionPlugin::deriveSpillLimitDefault,  
     *   <li>When the file store cannot be probed (transient FS hiccup after boot probe),  
     */  
        Setting.Property.NodeScope,  
     */
        IndexNameExpressionResolver indexNameExpressionResolver,
        },
        ResourceWatcherService resourceWatcherService,
        NamedWriteableRegistry namedWriteableRegistry,
            logger.debug("DataFusion service not yet initialized; ignoring memory pool limit update to {}B", newLimitBytes);
     *   <li>If spill is enabled, the value must not exceed the spill volume's total capacity
            DATAFUSION_MEMORY_GUARD_EXECUTION_CRITICAL_THRESHOLD.get(settings)  
        double executionSpill = DATAFUSION_MEMORY_GUARD_EXECUTION_SPILL_THRESHOLD.get(updated);
    );  
            SimpleExtension.ExtensionCollection scalarExtensions = SimpleExtension.load(List.of("/opensearch_scalar_functions.yaml"));
        NativeAllocator.VirtualPoolHandle dfPool = nativeAllocator.registerVirtualPool(
    /**
        Setting.Property.NodeScope,
        "datafusion.memory_pool_limit_bytes",
        // The grouped consumer receives a Settings built from the cycle's new (`current`) settings,
    public DocumentLookupResult getById(Engine.Get get, IndexReaderProvider.Reader reader, Index index, DocumentMetadataResolver resolver)
                        .toList();  
    );
            }  
        NativeBridge.setMinTargetPartitions(DATAFUSION_MIN_TARGET_PARTITIONS.get(settings));
        );
            return Long.toString(Long.MAX_VALUE);
     *   <li>{@code streaming} (default) — use {@link DatafusionReduceSink}: each batch is pushed
     * adaptive reduction (the budget system will never reduce below this floor).
                if (IndexSortConfig.INDEX_SORT_ORDER_SETTING.exists(rawSettings)) {
        DataFusionService service = dataFusionService;
        // Pull index.sort.field / index.sort.order off IndexSettings so the native reader can declare  
        s -> {  
        // Settings built from the cycle's new values, so reading each setting from it is correct.
     * Admission threshold for the jemalloc memory guard (0.0–1.0).
     * Project the active-query metrics map down to {@code taskId -> currentBytes} for the
        IndexScopedSettings indexScopedSettings,
    public static final Setting<Integer> DATAFUSION_MIN_TARGET_PARTITIONS = Setting.intSetting(
     * <p>Each entry mirrors one {@code QueryTracker} on the Rust side — current and peak memory
     * re-reading mid-cycle would yield the stale/previous value (the root cause of thresholds  
        String dir = DATAFUSION_SPILL_DIRECTORY.get(settings);
import org.opensearch.common.settings.SettingsFilter;
    }  
     * <p>Existence and writability are checked at boot time by the core
        }  
    static String validateSpillDirectory(String value) {
        );
        if (service == null) {
                "Updated DataFusion spill memory limit to {}B at the cluster level; the loaded native library does not "  
    private static final int ACTIVE_QUERY_METRICS_TOP_N = 10;
     * Spill directory used by DataFusion's {@code DiskManager} for intermediate state when  
     * funded by 2% from the operator pool and 1% from the unmanaged headroom (which expanded  
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
                    CacheSettings.FOOTER_METADATA_CACHE_PERCENT,
     * don't surface bad data.
    /**
        DocumentMetadataResolver resolver
     */  
        double admissionThrottle = DATAFUSION_MEMORY_GUARD_ADMISSION_THROTTLE_THRESHOLD.get(updated);
import java.util.HashMap;
    /**
    }
            Settings rawSettings = indexSettings.getSettings();
                // useless in fallback mode and would waste native heap.
public class DataFusionPlugin extends Plugin
        Setting.Property.NodeScope,  
    /**
                    DATAFUSION_MEMORY_GUARD_EXECUTION_CRITICAL_THRESHOLD
    public List<RestHandler> getRestHandlers(  
        "datafusion.memory_guard.execution.critical_threshold",  
import org.opensearch.common.logging.Loggers;  
            if (!"streaming".equals(v) && !"memtable".equals(v)) {
     * thread context classloader. Jackson polymorphic deserialization (used by Substrait  
                NativeBridge.clearColumnIndexCache();  
        long pool = Math.max(0L, nativeLimit.getBytes() * 71 / 100);
     * Creates the DataFusion plugin.
        Setting.Property.NodeScope,  
     * Computes the default for {@link #DATAFUSION_MEMORY_POOL_LIMIT} as 71% of  
            try {  
        return Long.toString(pool);
    }
        NativeBridge.setMemoryGuardThresholds(
    /**
     *  
            return Collections.emptyList();
import org.opensearch.core.common.breaker.CircuitBreaker;
     *  
        ClusterSettings clusterSettings,  
        }
     * backpressure native-memory tracker. One FFM snapshot per call, capped at
import org.opensearch.be.datafusion.action.stats.TransportDataFusionStatsAction;
    }
        "streaming",
     *
        Setting.Property.NodeScope,
        Map<Long, QueryExecutionMetrics> metrics = getTopQueriesByMemory();
            admissionReject,
            try {  
    }  
    static final long SPILL_LIMIT_FALLBACK_BYTES = 8L * 1024 * 1024 * 1024;  
     */
    /**
        4,
    /**
            if (dir == null) {  
    @Override
 * <p>
        return dataFusionService;
    }  
     * <p>
import org.opensearch.index.IndexSortConfig;
     * Recompute absolute ColumnIndex and OffsetIndex cache limits from the updated  
     * Safe to call during plugin startup before {@link #createComponents} returns
import java.nio.file.FileStore;  
import org.opensearch.core.index.Index;
        return List.of(SUPPORTED_FORMAT);  
        // DocumentMetadataResolver is supplied per-call by the engine, so it is not needed here.
import org.apache.logging.log4j.Logger;
            nativeAllocator.setPoolLimit(DatafusionSettings.POOL_DATAFUSION, newMax);
        if (getService != null) {  
        int metaPct = CacheSettings.FOOTER_METADATA_CACHE_PERCENT.get(updated);
        GetService svc = getService;
        List<Setting<?>> settings = new ArrayList<>(DatafusionSettings.NODE_SCOPED_SETTINGS);  
        int statsPct = CacheSettings.STATISTICS_CACHE_PERCENT.get(updated);
        return result;
import org.opensearch.search.backpressure.trackers.NativeMemoryUsageTracker;
     */
            NativeBridge.updateConcurrencyGate("fragment_executor", newMax);  
            executionCritical  
     * {@code Node.assertCanWritePluginHealthPaths} probe (which consumes the path returned  
        }
import org.opensearch.repositories.RepositoriesService;
        nativeAllocator.addStatsRefresher(() -> {
            }
import org.opensearch.nativebridge.spi.RustLoggerBridge;
    }
            if (v < 0) {
        throws IOException {  
                long currentLimit = dataFusionService != null ? dataFusionService.getMemoryPoolLimit() : limit;
    }
            }
     * defaults in `updated`, so passing all four every time is correct.
     *
     * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}, falling back to
        );
        this.getService = new GetService(this);
     * this setting caps how much disk space that staging can consume.
     * at full parallelism (false-positive override). Lower = more conservative.
    public EngineReaderManager<DatafusionReader> createReaderManager(ReaderManagerConfig settings) throws IOException {
import org.apache.logging.log4j.LogManager;
    @Override
        },
        if (dir == null || dir.isEmpty()) {
     * budget (an off-by-one update).
        }
import org.opensearch.index.engine.exec.EngineReaderManager;  
    );  
     * {@link Long#MAX_VALUE} when AC is unconfigured.
     * Package-private for testing.  
     * budget, not a memory budget, so the default is derived from the disk volume itself rather
     * Disk-staging budget for DataFusion spill. When in-memory operations (HashAggregate, Sort,
    ) {
        "datafusion.memory_guard.admission_throttle_threshold",
     *       spill is disabled and the cap is irrelevant.</li>  
            AnalyticsBackendNativeMemoryStats s = NativeMemoryFetcher.fetch();  
     * <p>Returns the bytes-as-string representation expected by the {@link Setting} parser.  
            executionSpill,
    @Override
        Map<Long, Long> out = new HashMap<>(metrics.size());  
     * <p>Spill is a disk budget, so the default is derived from the disk volume itself
            dataformatAwareStoreHandle,
        dataFusionService = DataFusionService.builder()
        }
    @Override
        long statsLimit = total * statsPct / 100;
import org.opensearch.core.action.ActionResponse;  
            ciLimit,
                // so accept any value rather than rejecting startup over an inert setting.
        long memoryPoolLimit = DATAFUSION_MEMORY_POOL_LIMIT.get(settings);
            .orElseThrow(() -> new IllegalStateException("NativeAllocator is not available; arrow-base plugin must be installed"));  
import org.opensearch.env.NodeEnvironment;
    }
import org.opensearch.watcher.ResourceWatcherService;  
        }  
        } catch (IOException e) {
        ClassLoader previous = t.getContextClassLoader();
     *
     * Selects how the coordinator-reduce sink hands shard responses to the native runtime.  
     * (reduced from 74% to fund the 3% parquet cache budget).
            long total;
                dir = "";
import java.util.Collection;  
        // Recompute and push absolute cache limits whenever the total budget or any
    @Override  
                .merge(arithmeticOverloads);
     * <p>Reads each value from the {@code updated} Settings supplied by the grouped settings-update
        String dir = DATAFUSION_SPILL_DIRECTORY.get(settings);
        "datafusion.memory_guard.execution.spill_threshold",  
        Setting.Property.NodeScope,
            if (!enabled) {  
 * this file be licensed under the Apache-2.0 license or a
        // so reading each threshold from it yields the value just set.
package org.opensearch.be.datafusion;
        Thread t = Thread.currentThread();  
            }
import org.opensearch.index.engine.Engine;
        return new DatafusionReaderManager(  
    );
            }  
        }
        long oiLimit = total * oiPct / 100;  
     */  
     * Snapshot the native DataFusion per-query registry and return a {@code contextId -> metrics}  
     */
     *       through a tokio mpsc, the native plan polls inputs as it executes.</li>  
        return "datafusion";  
    /**
     * cancellation budget on {@code SearchBackpressureService} ({@code cancellation_burst}
     * <p>Dynamic: changes take effect for new allocations only. Existing reservations  
}
        List<String> sortFields = List.of();  
        });
        for (Map.Entry<Long, QueryExecutionMetrics> e : metrics.entrySet()) {
    }
            DATAFUSION_MEMORY_POOL_LIMIT.get(settings),
        // an apply cycle the per-setting getter resolves against `lastSettingsApplied`, which the
            // isSpillLimitDynamic() guard above should make this unreachable, but defend  
            // against a race between probe and call.
     *       (probed live via {@link FileStore#getTotalSpace()}).</li>
    public static final Setting<Integer> DATAFUSION_REDUCE_TARGET_PARTITIONS = Setting.intSetting(  
        "datafusion.min_target_partitions",  
     *       returns {@link #SPILL_LIMIT_FALLBACK_BYTES} — a conservative 8 GiB.</li>
        DocumentLookupProvider {
        0L,  
        536870912L,
    }
    public BreakerSettings getCircuitBreaker(Settings settings) {
        Setting.Property.NodeScope,
     * from 21% to 20% of off-heap via the 79→80% change to
        Setting.Property.Final
 * Analytics query capabilities are declared in {@link DataFusionAnalyticsBackendPlugin},
            try {
import org.opensearch.search.sort.SortOrder;  
        // The total-size budget and the four sub-cache percentages together determine the
     * <p>Declared before {@link #DATAFUSION_SPILL_MEMORY_LIMIT} because the {@code Setting}  
    public List<DocumentLookupResult> getDocsAboveSeqNo(
            return;
                    DATAFUSION_MEMORY_GUARD_ADMISSION_REJECT_THRESHOLD,
import java.util.List;
            .memoryPoolLimit(memoryPoolLimit)  
     * cluster-settings update is accepted unconditionally because the value is read at next
        return getService.documentLookupService(resolver).getById(get.id(), reader, index);
    private volatile DataFormatRegistry dataFormatRegistry;
        Map<Long, QueryExecutionMetrics> result = NativeBridge.getTopNQueriesByMemory(ACTIVE_QUERY_METRICS_TOP_N);  
     * map. Returns an empty map when the service is not yet running (startup) or has been stopped
     * <p>Dynamic only when the loaded native library exports {@code df_set_spill_limit}
        Setting.Property.Dynamic
    ) throws IOException {
        }  
        0.0,
     */
     * margin into the framework's hard cap.
        return new BreakerSettings(  
import org.opensearch.common.settings.Setting;  
            Path.of(value).toAbsolutePath().normalize();  
        clusterService.getClusterSettings().addSettingsUpdateConsumer(DatafusionSettings.CONCURRENCY_DATANODE_MULTIPLIER, multiplier -> {
                    DATAFUSION_MEMORY_GUARD_EXECUTION_SPILL_THRESHOLD,  
        clusterService.getClusterSettings()
     *  
        );
                throw new IllegalArgumentException("datafusion.reduce.input_mode must be 'streaming' or 'memtable', got: " + v);
        try {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            if (total <= 0) {
     *  
        DocumentMetadataResolver resolver  
        // file sort order to DataFusion. Empty lists when the index has no index sort configured.
        0.75,  
        return datafusionSettings;
     *
            .addSettingsUpdateConsumer(DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP, NativeBridge::setSpillExemptCapBytes);  
     */
        return List.of(Path.of(dir));
import java.util.ArrayList;
        // Wire dynamic concurrency gate multiplier settings
        }  
    /** Fallback when the spill volume's capacity cannot be probed. 8 GiB. */
                );
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
    );
    public static final Setting<Double> DATAFUSION_MEMORY_GUARD_ADMISSION_THROTTLE_THRESHOLD = Setting.doubleSetting(
        }
    static String deriveSpillLimitDefault(Settings settings) {  
            if (dataFusionService != null) {
        NativeMemoryUsageTracker.setSnapshotSupplier(this::currentBytesByTaskId);  
        double admissionReject = DATAFUSION_MEMORY_GUARD_ADMISSION_REJECT_THRESHOLD.get(updated);  
     * Returns an empty map when the service isn't running, so startup/shutdown races
     *       {@link FileStore#getTotalSpace() total space}.</li>
        List<String> sortOrders = List.of();
    /**  
     */
            return Collections.emptyMap();
        Setting.Property.Dynamic  
        // can short-circuit format!() for suppressed levels without polling.  
            }  
            CacheManager cm = service.getCacheManager();
     * (see {@link org.opensearch.be.datafusion.nativelib.NativeBridge#isSpillLimitDynamic()}).
import java.io.IOException;
    /**
     * node startup. Package-private for testing.
            }
 *
        GetService svc = getService;
            DatafusionSettings.POOL_DATAFUSION,  
     *
     * Validates {@link #DATAFUSION_SPILL_DIRECTORY}. Empty (the unset sentinel) is accepted
        return clusterService;  
            return;  
        return List.copyOf(settings);
    }  
        1,  
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;
import org.opensearch.cluster.node.DiscoveryNodes;
        } catch (java.nio.file.InvalidPathException e) {
     * <p><strong>Default: 80% of the spill volume's total disk capacity.</strong> Spill is a disk  
        // settings framework only swaps in AFTER all update consumers have run — so a callback that
import java.util.function.Supplier;
     */
        DataFusionService service = dataFusionService;
    /**
        GetService getService = getServiceOrThrow();
        }
        // Push Rust log level whenever any logger.* cluster setting changes, so Rust macros
            DATAFUSION_MEMORY_GUARD_EXECUTION_SPILL_THRESHOLD.get(settings),
        logger.info("Updated DataFusion min_target_partitions to {}", value);
                return;
    }  
     * builds from the cycle's new settings — rather than re-reading via  
     * order Rust drained the bounded min-heap (unspecified but stable per snapshot).
     * When false, the scoped CI/OI caches are bypassed and the metadata cache
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        NativeBridge.setMemoryGuardThresholds(admissionThrottle, admissionReject, executionSpill, executionCritical);  
        }  
     * queries by {@code current_bytes}, selected on the Rust side. Iteration order matches the
     *   <li>If spill is disabled (empty directory), the limit is a no-op and any value is accepted —
        s -> {
    public void setCircuitBreaker(CircuitBreaker circuitBreaker) {  
            "Updated DataFusion memory guard thresholds: admission_throttle={}, admission_reject={}, execution_spill={}, execution_critical={}",
    }  
                sortFields = List.copyOf(fields);
     * preserve pre-AC behaviour rather than make up a number from JVM heap (which is a  
            new ActionHandler<>(
import org.opensearch.index.IndexSettings;  
/**  
     *       simpler input lifecycle with no cross-runtime spawn or oneshot machinery.</li>  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    public void close() throws IOException {
        // absolute CI/OI limits, so they are wired through a single grouped Consumer<Settings>.
import org.opensearch.plugins.Plugin;
     * been released (service throws {@link IllegalStateException}, caught and logged).
     * Default 536870912 (512MB) expressed in raw bytes. Live-tunable — takes effect on the next  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        }
    @Override
     * Default: 0.85.  
    }
        Supplier<RepositoriesService> repositoriesServiceSupplier,  
     * consumer — NOT via {@code clusterService.getClusterSettings().get(...)}, which during an apply
        // re-reads sees the stale/previous value and would push defaults instead of the new value.  
            );  
    /**
     * Get-by-id entry point. Delegates to {@link GetService}, which fetches the row through the native runtime.
            .addAffixUpdateConsumer(Loggers.LOG_LEVEL_SETTING, (namespace, level) -> RustLoggerBridge.pushLevel(), (k, v) -> {});
    }  
        );
    }
            SimpleExtension.ExtensionCollection delegationExtensions = SimpleExtension.load(List.of("/delegation_functions.yaml"));
     * to native. Validates that percentages sum to 100 before applying.
     * - Hard guard (pre-CAS): forces spill when pool accounting lags jemalloc (recoverable)
            .orElseThrow(() -> new IllegalStateException("DataFormatRegistry is not available during DataFusion initialization"));
        "datafusion.scoped_page_index.enabled",  
     * Returns the {@link GetService} , throwing IllegalStateException if not initialized.
        }
    private void recomputePageCacheLimits(org.opensearch.common.settings.Settings updated) {  
        if (svc == null) {  
    );
    }
        logger.debug("DataFusion plugin initialized — memory pool {}B, spill limit {}B", memoryPoolLimit, spillMemoryLimit);
        } catch (IllegalStateException e) {  
            DatafusionSettings.DATAFUSION_MEMORY_POOL_MIN,
        this.dataFormatRegistry = dataFormatRegistry;
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
        if (service != null) {  
            if (cm != null) {
     * separate, already-allocated region with no relation to native-memory sizing).
            oiLimit,  
        // Expose per-task native-memory usage to search backpressure.
     * (shutdown), so callers never see a half-initialized view.
    /**
            SimpleExtension.ExtensionCollection arithmeticOverloads = SimpleExtension.load(  
import org.opensearch.transport.client.Client;
        }
    static final class SpillLimitValidator implements Setting.Validator<Long> {  
     * <p>{@code Final} because DataFusion's {@code DiskManager} is built once at runtime  
        if (logger.isDebugEnabled()) {
    SimpleExtension.ExtensionCollection getSubstraitExtensions() {
            new ActionHandler<>(DataFusionStatsActionType.INSTANCE, TransportDataFusionStatsAction.class),  
        });  
        } catch (IllegalStateException e) {
    // DocumentLookupProvider implementation. Construction deferred until the DataFusion service is live.  
            sortOrders  
        Settings settings = environment.settings();  
    void updateMemoryPoolLimit(long newLimitBytes) {
            logger.debug("native memory snapshot: {} active queries", out.size());
            logger.warn("Ignoring memory pool limit update to {}B; service is not running", newLimitBytes);  
    private static SimpleExtension.ExtensionCollection loadSubstraitExtensions() {
    /**
    /**  
        int oiPct = CacheSettings.OFFSET_INDEX_CACHE_PERCENT.get(updated);  
import org.opensearch.index.engine.exec.IndexReaderProvider;
        long total = CacheSettings.METADATA_INDEX_CACHE_TOTAL_SIZE.get(updated).getBytes();
        1,
     * than from physical RAM or the off-heap carve-out. This sizes correctly on both supported
     */  
     */
    /**
            logger.info("Updated DataFusion spill memory limit to {}B", newLimitBytes);
    ) {
        IndexNameExpressionResolver indexNameExpressionResolver,  
     *   <li>When set, returns {@link #SPILL_LIMIT_FRACTION} of the spill volume's
                return new AnalyticsBackendNativeMemoryStats(-1, -1, 0);
    public static final Setting<Double> DATAFUSION_MEMORY_GUARD_ADMISSION_REJECT_THRESHOLD = Setting.doubleSetting(  
import org.opensearch.be.datafusion.action.stats.DataFusionStatsActionType;
    }
            CircuitBreaker.Durability.TRANSIENT,
            PoolGroup.SEARCH,  
        if (dataFusionService == null) {
     * <ul>
        NativeBridge.setOffsetIndexCacheLimit(oiLimit);
        0.95,
     * Computes the default for {@link #DATAFUSION_SPILL_MEMORY_LIMIT}.
     * logs a warning in that case.
            return DefaultExtensionCatalog.DEFAULT_COLLECTION.merge(delegationExtensions)  
import org.opensearch.plugins.NativeStoreHandle;  
 * Owns the {@link DataFusionService} lifecycle (memory pool, native runtime).  
            admissionThrottle,  
     * Memory pool limit for the DataFusion runtime.  
    @Override
     * Default: 0.75.
            );
    private volatile ClusterService clusterService;
                )
        true,
            }
        ActionPlugin,
        Function.identity(),
                return NativeBridge.nativeNodeStats();
     */
        int cpuThreads = DataFusionService.cpuThreadCount();
    void updateSpillMemoryLimit(long newLimitBytes) {
        NamedXContentRegistry xContentRegistry,
            if (dir.isEmpty()) {  
    /**
        // cluster settings API take effect without restarting the node.
        Environment environment,
     * silently not updating at runtime). Unchanged thresholds are filled with their registered
        // Apply initial values  
        public void validate(Long value, Map<Setting<?>, Object> dependencies) {
        return out;
        });
                List.of(  
                logger.info("Scoped page-index disabled: cleared CI and OI caches");
        DataFusionPlugin::deriveMemoryPoolLimitDefault,
            settings.shardPath(),
        }
     */
    /**
        });
import org.opensearch.arrow.spi.PoolGroup;
     * Default: 0.85.
     */  
                    DATAFUSION_MEMORY_GUARD_ADMISSION_THROTTLE_THRESHOLD,
     */
        logger.info(
                NativeBridge.clearOffsetIndexCache();
    @Override  
     * retains the full page index (fallback mode). Default: true.  
     * When memory pressure forces partition reduction, this is the lowest value allowed.  
        if (nativeLimit.getBytes() <= 0) {
     * <p>The fraction is taken straight from {@code node.native_memory.limit}, not from
import io.substrait.extension.SimpleExtension;
        }
        "datafusion.memory_guard.admission_reject_threshold",
                cm.updateSizeLimit(CacheUtils.CacheType.METADATA, metaLimit);  
    }
        v -> {  
import org.opensearch.rest.RestController;
        // Two consumers downstream:
    /**
        Client client,
            String dir = (String) dependencies.get(DATAFUSION_SPILL_DIRECTORY);
        Setting.Property.Dynamic
        if (value == null || value.isEmpty()) {
            return Long.toString((long) (total * SPILL_LIMIT_FRACTION));
            DatafusionSettings.DATAFUSION_MEMORY_POOL_MIN.get(settings),
            .spillDirectory(spillDir)
        }
     * When the symbol is absent the setting can still be updated at the cluster level,  
     * plugin context the TCCL is typically the server classloader, which cannot see the
        try {
    private static final Logger logger = LogManager.getLogger(DataFusionPlugin.class);  
    public List<String> getSupportedFormats() {
        // ORDER BY runs counter to the catalog direction.
            }  
        long ciLimit = total * ciPct / 100;
        // re-reads via getClusterSettings().get() sees the stale/previous value and pushes the  
                List.of("/opensearch_arithmetic_overloads.yaml")
    @Override
     * {@code limit - buffer_percent}. {@code buffer_percent} is an admission-control throttle
        });  
        }
     * (8 GiB) when the spill volume cannot be probed.
    private volatile CircuitBreaker datafusionBreaker;
import org.opensearch.arrow.spi.NativeAllocator;  
        CacheSettings.validatePercentSum(metaPct, oiPct, ciPct, statsPct);  
        // - Indexed path: indexed_executor reverses segment iteration when the query's leading
                    sortOrders = fields.stream().map(f -> "asc").toList();
     * patterns: a dedicated EBS volume mounted at the spill directory, or the spill  
    public DataFusionPlugin() {}
     * If the AC limit is unset (== 0), the default is {@link Long#MAX_VALUE} — unbounded — to
        Index index,
        // Build the get-by-id service now that the DataFusion runtime is live. The  
     *
import org.opensearch.plugins.PluginComponentRegistry;
     * deployment patterns: a dedicated EBS volume mounted at the spill directory, or the spill  
            SimpleExtension.ExtensionCollection arrayExtensions = SimpleExtension.load(List.of("/opensearch_array_functions.yaml"));  
     * Pushes the four memory-guard thresholds to the native pool. Reads each value from the
    @Override
            () -> {  
        clusterService.getClusterSettings().addSettingsUpdateConsumer(DATAFUSION_MIN_TARGET_PARTITIONS, this::updateMinTargetPartitions);
     * Takes effect for new allocations only. In-flight reservations that already
        logger.info(
            long v = Long.parseLong(s);
        return Collections.singletonList(dataFusionService);  
        1.0,  
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;  
     * Protects running queries from new arrivals when memory is elevated.  
     * <ul>
     */
        NativeBridge.setScopedPageIndexEnabled(SCOPED_PAGE_INDEX_ENABLED.get(settings));
        }
        0.85,
            logger.debug("DataFusion service not yet initialized; ignoring spill limit update to {}B", newLimitBytes);
    /**
        clusterService.getClusterSettings()
        Setting.Property.Dynamic  
            return Collections.emptyMap();
                    sortOrders = IndexSortConfig.INDEX_SORT_ORDER_SETTING.get(rawSettings)  
     * `updated` Settings supplied by the grouped settings-update consumer — which the framework
import org.opensearch.indices.breaker.BreakerSettings;  
            return v;  
        // their workload.  
        };
        @Override  
import org.opensearch.plugins.ActionPlugin;  
     * Minimum target partitions floor for the adaptive budget system.
        String spillDir = DATAFUSION_SPILL_DIRECTORY.get(settings);  
        Setting.Property.Dynamic
    ClusterService getClusterService() {
        Setting.Property.NodeScope,
    DatafusionSettings getDatafusionSettings() {  
        if (!service.isSpillLimitDynamic()) {
     *  
    @Override
        clusterSettings.addSettingsUpdateConsumer(DATAFUSION_MEMORY_POOL_LIMIT, newMax -> {  
     * {@code FsHealthService}. This validator only constrains the syntactic form of the setting.
        if (metrics.isEmpty()) {  
     *  
        // This MUST use the grouped overload (not `v -> recompute(getClusterSettings())`): during  
        settings.addAll(DatafusionSettings.INDEX_SCOPED_SETTINGS);
    public static final Setting<Long> DATAFUSION_SPILL_MEMORY_LIMIT = new Setting<>(
                long usage = dataFusionService.getMemoryPoolUsage();  
        public Iterator<Setting<?>> settings() {  
import org.opensearch.action.ActionRequest;  
 * which is SPI-discovered and receives this plugin instance via its constructor.
        // Wire the dynamic spill limit setting to the native runtime so updates via the
    /**
     * can collectively borrow above the spill threshold while staying below the 95% critical limit.
    /**
    );
     * and signals that spill should be disabled. Non-empty values must parse as a {@link Path}.  
import org.opensearch.common.settings.Settings;
            }
        Setting.Property.Dynamic
    );  
            if (v < 0) {  
     * <p>
            }  
        return List.of(new RestDataFusionStatsAction(), new org.opensearch.be.datafusion.action.stats.RestClearCacheAction());  
    void updateMinTargetPartitions(int value) {  
    }
            logger.warn(
            }
        32,
    }
     *       the capacity check has no volume to probe, so it is skipped.</li>  
     * to load its {@code SimpleExtension} subclasses) consults the TCCL; in an OpenSearch
     * Applies a new spill memory limit to the running DataFusion runtime when the loaded
        );
    }
        if (svc == null) return List.of();  
        1.0,  
                .merge(windowExtensions)
        try {
        return svc.documentLookupService(resolver).getVersionMetadata(id, reader, index);
    }  
                    "Setting [datafusion.spill_memory_limit_bytes]=" + value + " exceeds spill volume capacity (" + total + " bytes)"  
        PluginComponentRegistry pluginComponentRegistry
     *
import org.opensearch.common.settings.ClusterSettings;
     */  
            } catch (Exception e) {
     *   <li>When {@link #DATAFUSION_SPILL_DIRECTORY} is unset (empty), returns {@code "0"} —
     * the same off-heap budget admission control throttles against. The DataFusion Rust
        if (logger.isDebugEnabled()) {
    public static final Setting<Boolean> SCOPED_PAGE_INDEX_ENABLED = Setting.boolSetting(
        SettingsFilter settingsFilter,
    public static final Setting<Long> DATAFUSION_MEMORY_POOL_LIMIT = new Setting<>(  
        // limit derived from the OLD budget (an off-by-one update). The grouped consumer receives a
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
        Setting.Property.Dynamic  
     * the DataFusion parquet caches (footer metadata, ColumnIndex, OffsetIndex). That 3% is
     * startup; changing the directory mid-flight would orphan in-progress spill files.
     * {@link #ACTIVE_QUERY_METRICS_TOP_N} entries (the heaviest live queries).  
        1,
     * constructor evaluates the default-value supplier eagerly (under {@code -ea}); the
        Index index,  
            DATAFUSION_MEMORY_GUARD_ADMISSION_REJECT_THRESHOLD.get(settings),
     * Default: 0.95.  
        clusterService.getClusterSettings()  
        long limit = DATAFUSION_MEMORY_POOL_LIMIT.get(settings);
        return () -> {
        Settings settings,
            return value;  
        dataFusionService.start();  
     * </ul>
        "datafusion.spill_directory",
        clusterService.getClusterSettings().addSettingsUpdateConsumer(SCOPED_PAGE_INDEX_ENABLED, enabled -> {
     * Cap on entries returned by {@link #getTopQueriesByMemory()}. Equal to the per-tick  
            );  
    public static final Setting<Double> DATAFUSION_MEMORY_GUARD_EXECUTION_SPILL_THRESHOLD = Setting.doubleSetting(
                // boot-time default derivation.
        }
            throw new IllegalArgumentException("Setting [datafusion.spill_directory] is not a valid path: [" + value + "]", e);
        );
            SimpleExtension.ExtensionCollection windowExtensions = SimpleExtension.load(List.of("/opensearch_window_functions.yaml"));
     * RSS fraction at which memory is considered critical. Serves dual purpose:  
        new SpillLimitValidator(),
            // still registered on ClusterSettings because there is no removeSettingsUpdateConsumer
        IndexReaderProvider.Reader reader,
     * rather than from physical RAM. This sizes correctly on both supported deployment
     * exceed the new limit are not reclaimed and drain as queries complete.  
    @Override  
     * Total in-flight allocation in bytes allowed through the 85% spill gate by spillable consumers  
    private GetService getServiceOrThrow() {
        this.clusterService = clusterService;
                this::recomputePageCacheLimits,
            // API; swallow the race so cluster-state application does not log a spurious failure.
 * Main plugin class for the DataFusion native engine integration.
            } catch (IOException e) {
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
        // settings framework only swaps in AFTER all update consumers have run — so a callback that
        return svc;  
     * <ul>
            "analytics_backend_datafusion",
    private void updateMemoryGuardThresholds(Settings updated) {
        }  
import org.opensearch.analytics.spi.QueryExecutionMetrics;
        }  
            DATAFUSION_MEMORY_GUARD_ADMISSION_THROTTLE_THRESHOLD.get(settings),  
        Setting.Property.Dynamic
     * the probe is a single syscall (~µs), so caching is not worth the bookkeeping cost.
            if (!fields.isEmpty()) {  
import java.nio.file.Path;
     *
            service.setMemoryPoolLimit(newLimitBytes);  
        if (indexSettings != null) {  
        DataFusionPlugin::validateSpillDirectory,
     * {@code ResourceTrackerSettings.deriveNativeMemoryLimitDefault}).
            }
        } finally {  
     * by {@link #getAdditionalHealthPaths(Settings)}), and at runtime by
     * directory on the same disk as the OpenSearch process.
        clusterSettings.addSettingsUpdateConsumer(
    }
     * partitioning model), so the default takes 71% of {@code node.native_memory.limit}  
            )
            int newMax = Math.max(1, (int) (cpuThreads * multiplier));
    }  
    public static final Setting<Double> DATAFUSION_MEMORY_GUARD_EXECUTION_CRITICAL_THRESHOLD = Setting.doubleSetting(
     * directory on the same disk as the OpenSearch process.
     * <p>When unset, the default is derived from the admission-control native-memory budget
import org.opensearch.be.datafusion.cache.CacheManager;
    static final double SPILL_LIMIT_FRACTION = 0.90;  
        IndexSettings indexSettings = settings.indexSettings();
            .build();
                // every field defaults to asc — matches IndexSortConfig behavior.
    DataFusionService getDataFusionService() {
                )  
            t.setContextClassLoader(DataFusionPlugin.class.getClassLoader());  
        Supplier<DiscoveryNodes> nodesInCluster
    );  
        clusterService.getClusterSettings().addSettingsUpdateConsumer(DATAFUSION_SPILL_MEMORY_LIMIT, this::updateSpillMemoryLimit);  
            newMin -> nativeAllocator.setPoolMin(DatafusionSettings.POOL_DATAFUSION, newMin)  
        Setting.Property.Dynamic
        }  
            return;
        "datafusion.reduce.target_partitions",
        @Override
    private volatile DataFusionService dataFusionService;
import org.opensearch.common.settings.IndexScopedSettings;
            SimpleExtension.ExtensionCollection aggregateExtensions = SimpleExtension.load(List.of("/opensearch_aggregate_functions.yaml"));
        return substraitExtensions;  
     * margin, not a framework budget reduction; subtracting it here would collapse AC's safety  
        Setting.Property.NodeScope,  
            }
     */  
                } else {
 */  
            settings.format(),
        NativeBridge.setColumnIndexCacheLimit(ciLimit);  
     * Validates {@link #DATAFUSION_SPILL_MEMORY_LIMIT} against {@link #DATAFUSION_SPILL_DIRECTORY}:  
        if (dir == null || dir.isEmpty()) {
     * ({@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}), which is  
            }
     * Number of partitions used by the coordinator-reduce DataFusion plan.
            long v = Long.parseLong(s);
     * allocation decision.
     * operators (HashAggregate, Sort, TopK) exceed {@link #DATAFUSION_MEMORY_POOL_LIMIT}.
                    CacheSettings.STATISTICS_CACHE_PERCENT
     * <p>When {@link #DATAFUSION_SPILL_DIRECTORY} is unset (empty), returns {@code 0} — spill is  
            logger.warn("Ignoring spill memory limit update to {}B; service is not running", newLimitBytes);
        }  
            .clusterSettings(clusterService.getClusterSettings())
     * More partitions = more parallelism = more memory (each partition holds its own hash table).  
            dataFusionService,  
     * When pool accounting rejects a phantom reservation but jemalloc reports
                return new AnalyticsBackendTaskCancellationStats(0, 0, 0, 0);  
     */
    public List<Setting<?>> getSettings() {
        CircuitBreakerPlugin,  
        if (service == null) {  
        public void validate(Long value) {
    }
                return NativeMemoryFetcher.fetch();  
        long fromSeqNoExclusive,  
    public Supplier<AnalyticsBackendNativeMemoryStats> getAnalyticsBackendNativeMemoryStats() {  
     * {@code DiskManagerMode::Disabled} — spill is off and queries that exceed
        0.0,
                long[] stats = dataFusionService != null ? dataFusionService.getMemoryPoolStats() : new long[] { 0, 0 };
            updateMemoryPoolLimit(newMax);
                return Long.toString(SPILL_LIMIT_FALLBACK_BYTES);
        NodeEnvironment nodeEnvironment,  
    );
    public Map<Long, QueryExecutionMetrics> getTopQueriesByMemory() {
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                    CacheSettings.OFFSET_INDEX_CACHE_PERCENT,  
/*  
            logger.warn("Ignoring spill memory limit update to {}B; native runtime does not support live updates", newLimitBytes);
            return new long[] { s.getAllocatedBytes(), s.getResidentBytes() };
import org.opensearch.rest.RestHandler;  
        // `v -> updateMemoryGuardThresholds()` re-reading via getClusterSettings().get()): during  
            metaLimit,
        Setting.Property.Dynamic  
            1.0,  
        // Wire dynamic setting consumers for pool min/max
    }  
import java.util.Map;
import org.opensearch.threadpool.ThreadPool;
        NativeBridge.setReduceTargetPartitions(DATAFUSION_REDUCE_TARGET_PARTITIONS.get(settings));
     * Applies a new memory pool limit to the running DataFusion runtime.  
import org.opensearch.core.common.unit.ByteSizeValue;  
        0.0,
import org.opensearch.env.Environment;
            long total = Environment.getFileStore(Path.of(dir)).getTotalSpace();  
     * to the configured path. When unset (empty), DataFusion runs in
     * Setting this equal to the configured target_partitions effectively disables
    public static final Setting<Long> DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP = Setting.longSetting(  
    public Collection<Object> createComponents(
     * runtime is the dominant native-memory consumer for analytics workloads (see PR #21732
import org.opensearch.nativebridge.spi.NativeMemoryFetcher;
import org.opensearch.index.get.DocumentLookupResult;
                // Probe failed — skip the capacity check. Same fail-open behavior as the  
    public List<Path> getAdditionalHealthPaths(Settings settings) {  
            return List.<Setting<?>>of(DATAFUSION_SPILL_DIRECTORY).iterator();
import java.util.Collections;
        // - Vanilla path: ListingOptions.with_file_sort_order so the planner can drop SortExec.  
     * so they can finish spilling before the pool rejects them. Bounds how much concurrent spilling
        0.85,
            );
            return List.of();  
                    CacheSettings.COLUMN_INDEX_CACHE_PERCENT,
    static String deriveMemoryPoolLimitDefault(Settings settings) {
                org.opensearch.be.datafusion.action.stats.ClearCacheActionType.INSTANCE,
            getService.close();
        DataFusionService service = dataFusionService;  
    public DocumentLookupResult getVersionMetadata(  
    private volatile DatafusionSettings datafusionSettings;
     * reservation, wall time, and whether the query has completed but not yet been drained.
    public static final Setting<String> DATAFUSION_SPILL_DIRECTORY = new Setting<>(
        new Setting.SimpleKey("datafusion.spill_memory_limit_bytes"),
     * native library exports {@code df_set_spill_limit}; otherwise emits a warning. The  
        ClusterService clusterService,  
    );
        return () -> {
        // sub-cache percentage changes. Validates that percentages sum to 100 first.  
     * </ul>  
    }  
     * the ability to set the cap; only the safety-net validation is disabled.
                throw new IllegalArgumentException("Setting [datafusion.memory_pool_limit_bytes] must be >= 0, got " + v);  
                // index.sort.order is set its length equals fields.length. When omitted,  
            if (total > 0 && value > total) {
        String id,
    /**
        NativeMemoryUsageTracker.setNativeMemoryBudgetSupplier(() -> DATAFUSION_MEMORY_POOL_LIMIT.get(clusterService.getSettings()));
                newLimitBytes
        if (dataFusionService != null) {  
        if (dataFusionService == null) {  
        "",  
import org.opensearch.cluster.service.ClusterService;
                dfPool.updateStats(usage, usage);
    }
import org.opensearch.be.datafusion.cache.CacheSettings;  
        NativeAllocator nativeAllocator = pluginComponentRegistry.getComponent(NativeAllocator.class)
        Setting.Property.Dynamic
                        .map(o -> o == SortOrder.DESC ? "desc" : "asc")
import org.opensearch.plugins.SearchBackEndPlugin;  
        0.0,  
     * but the new value only takes effect after a node restart — the live update consumer
            .addSettingsUpdateConsumer(DATAFUSION_REDUCE_TARGET_PARTITIONS, NativeBridge::setReduceTargetPartitions);  
        // an apply cycle the per-setting getter resolves against `lastSettingsApplied`, which the
     * Probes the filesystem on each validate call. Cluster-settings updates are infrequent and
            List<String> fields = IndexSortConfig.INDEX_SORT_FIELD_SETTING.get(rawSettings);
    public String name() {
     *   <li>{@code memtable} — use {@link DatafusionMemtableReduceSink}: all batches are buffered
        SearchBackEndPlugin<DatafusionReader>,  
        this.datafusionSettings = new DatafusionSettings(clusterService);  
                throw new IllegalArgumentException(
     * Lower values reduce peak memory at the cost of slower single-query latency.
     * - Cancel path (post-CAS-fail): terminates query when spill can't help (last resort)
        Setting.Property.NodeScope,
            statsLimit
        Setting.Property.NodeScope,
    }
import org.opensearch.plugins.DocumentLookupProvider;
        // The four memory-guard thresholds are pushed to the native pool together via a single
        try {  
        AnalyticsSearchBackendPlugin,
        double executionCritical = DATAFUSION_MEMORY_GUARD_EXECUTION_CRITICAL_THRESHOLD.get(updated);
        nativeAllocator.setNativeMemoryStatsSupplier(() -> {
    }
        NativeBridge.setSpillExemptCapBytes(DATAFUSION_MEMORY_GUARD_SPILL_EXEMPT_CAP.get(settings));  
                this::updateMemoryGuardThresholds,
    @Override
    }
            return Long.toString(SPILL_LIMIT_FALLBACK_BYTES);  
        } catch (UnsupportedOperationException e) {
    /**
            logger.debug("getTopQueriesByMemory: {} entries from native registry", result.size());
        }
import org.opensearch.be.datafusion.action.stats.RestDataFusionStatsAction;  
            .datanodeMultiplier(DatafusionSettings.CONCURRENCY_DATANODE_MULTIPLIER.get(settings))  
        },  
     * RSS fraction above which new queries are rejected (429 backpressure).
    DataFormatRegistry getDataFormatRegistry() {  
                return;  
        clusterService.getClusterSettings()
        ThreadPool threadPool,
        clusterService.getClusterSettings()  
        if (dataFusionService == null) {  
                org.opensearch.be.datafusion.action.stats.TransportClearCacheAction.class  
            } catch (Exception e) {
        long spillMemoryLimit = DATAFUSION_SPILL_MEMORY_LIMIT.get(settings);
                .merge(arrayExtensions)
            throw new IllegalStateException("GetService is not initialized. ");
                    + "support runtime spill resize, so the new value will only take effect after a node restart",
        IndexReaderProvider.Reader reader,
                throw new IllegalArgumentException("Setting [datafusion.spill_memory_limit_bytes] must be >= 0, got " + v);
        long metaLimit = total * metaPct / 100;
        GetService svc = getServiceOrThrow();  
                List.of(  
     * spill-limit default reads this setting, so it must be initialized first.
                .merge(aggregateExtensions)  
import org.opensearch.plugins.CircuitBreakerPlugin;
import java.util.function.Function;  
            return v;
        @Override
    );
    ) throws IOException {
        return dataFormatRegistry;
        1.0,
