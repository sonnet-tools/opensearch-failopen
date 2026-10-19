            rebalancerScheduler.shutdownNow();  
        OVERCOMMIT_MAX_CONCURRENT_MIN,  
        return List.of(built, new NativeAllocatorStatsRegistry(statsSupplier, built::setNativeMemoryPressureSupplier));
import org.opensearch.common.settings.SettingsFilter;
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_FLIGHT_MIN),
        Setting.Property.Dynamic
    /** Node native-memory pressure % at/above which over-commit is refused. */
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
        "native.allocator.overcommit.enabled",
    public List<RestHandler> getRestHandlers(
        );
        Setting.Property.NodeScope,  
        Supplier<DiscoveryNodes> nodesInCluster  
    );
     * Maximum number of concurrently over-committing operations. Static (node-scope, non-dynamic);  
import org.opensearch.threadpool.Scheduler;
/*  
    // ─── Instance state ──────────────────────────────────────────────────────────
    // ─── Private helpers ─────────────────────────────────────────────────────────
        cs.addSettingsUpdateConsumer(OVERCOMMIT_ENABLED_SETTING, allocator::setOverCommitEnabled);
        if (rebalancerScheduler != null) {
import org.opensearch.common.util.concurrent.FutureUtils;  
import java.util.concurrent.TimeUnit;
        return allocator;
        s -> derivePoolMaxDefault(s, DiscoveryNode.isWarmNode(s) ? 3 : 5),
    /** Whether the NativeMemoryRebalancer is enabled. */
            if (enabled == false) {  
        IndexScopedSettings indexScopedSettings,  
        cancelRebalanceTask();  
    );
import org.opensearch.arrow.spi.PoolGroup;
import org.opensearch.plugins.ActionPlugin;  
import org.opensearch.script.ScriptService;  
    static final boolean DEFAULT_OVERCOMMIT_ENABLED = true;
    );
    }
        cs.addSettingsUpdateConsumer(FLIGHT_MAX_SETTING, newMax -> allocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_FLIGHT, newMax));
            Thread t = new Thread(r, "native-allocator-rebalancer");  
            rebalanceTask = rebalancerScheduler.scheduleAtFixedRate(rebalancer, newInterval, newInterval, TimeUnit.SECONDS);
            budgetSupplier,
    public static final Setting<Long> QUERY_MIN_SETTING = new Setting<>(
        cs.addSettingsUpdateConsumer(IDLE_THRESHOLD_SETTING, value -> {  
        Setting.Property.Dynamic
    /** Feature gate for the over-commit fallback when a pool is full. Default on. */
        cs.addSettingsUpdateConsumer(SHRINK_FACTOR_SETTING, value -> {
        NativeMemoryRebalancer nativeRebalancer = new NativeMemoryRebalancer(
        ClusterService clusterService,
            REBALANCER_ENABLED_SETTING,  
        if (nativeLimit.getBytes() <= 0) {
    /** JVM {@code -XX:MaxDirectMemorySize} in bytes, or -1 when it cannot be determined. */  
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_QUERY_MIN),
        Setting.Property.NodeScope,
    public static final Setting<Double> PRESSURE_THRESHOLD_SETTING = Setting.doubleSetting(
        Setting.Property.Dynamic  
        }
    public static final Setting<Long> INGEST_MAX_SETTING = new Setting<>(
            QUERY_MIN_SETTING,  
    public static final Setting<Long> FLIGHT_MIN_SETTING = new Setting<>(
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_INGEST_MIN),
            NativeMemoryRebalancer r = this.rebalancer;
        allocator.getOrCreatePool(
    ) {
    public static final Setting<Long> QUERY_MAX_SETTING = new Setting<>(
        0.0,
        s -> derivePoolMinDefault(s, 2),
        if (REBALANCER_ENABLED_SETTING.get(settings)) {  
import org.opensearch.plugins.Plugin;
        // node.native_memory.limit could not be derived (e.g. a restricted container where physical-memory
        s -> derivePoolMaxDefault(s, 5),
        if (maxDirect > 0) {
        );
    public void close() throws IOException {
        ResourceWatcherService resourceWatcherService,  
    public static final Setting<Long> REBALANCE_INTERVAL_SETTING = Setting.longSetting(
        } catch (Throwable t) {
        NamedWriteableRegistry namedWriteableRegistry,
 * The OpenSearch Contributors require contributions made to  
        Setting.Property.NodeScope,  
        cs.addSettingsUpdateConsumer(INGEST_MIN_SETTING, newMin -> allocator.setPoolMin(NativeAllocatorPoolConfig.POOL_INGEST, newMin));
            return PlatformDependent.maxDirectMemory();  
            rebalanceTask = null;
    }
import org.opensearch.env.Environment;
            } else {  
        // Set up the rebalancer if enabled
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        }
        Setting.Property.NodeScope,  
        0.0,  
import org.opensearch.common.settings.IndexScopedSettings;
    /** Default node native-memory pressure % at/above which over-commit is refused. */  
        cs.addSettingsUpdateConsumer(FLIGHT_MIN_SETTING, newMin -> allocator.setPoolMin(NativeAllocatorPoolConfig.POOL_FLIGHT, newMin));  
            QUERY_MAX_SETTING.get(settings),
    private volatile ScheduledExecutorService rebalancerScheduler;
        // probing returns 0). Falling back to Long.MAX_VALUE would leave the pool UNBOUNDED, so the pool's  
import org.opensearch.plugin.stats.NativeAllocatorStatsRegistry;
        "native.allocator.rebalance.interval_seconds",  
 * {@link ArrowNativeAllocator} and its classloader.
        // Register dynamic consumers for threshold changes
            return "0";  
    /** Creates the plugin. */  
 *  
    }
        ScriptService scriptService,
        OVERCOMMIT_PRESSURE_THRESHOLD_MIN,
    public Collection<Object> createComponents(
    /** Lower bound for the over-commit pressure threshold setting. */
        1.0,  
        s -> derivePoolMaxDefault(s, 5),
    }  
    }  
    }
    );
    );
        }  
        NativeAllocatorPoolConfig.SETTING_QUERY_MAX,  
        }
import org.opensearch.threadpool.ThreadPool;
        long maxDirect = maxDirectMemoryBytes();  
        Scheduler.SafeScheduledThreadPoolExecutor executor = new Scheduler.SafeScheduledThreadPoolExecutor(1, r -> {
            OVERCOMMIT_ENABLED_SETTING,
    @Override
        Setting.Property.NodeScope,
import org.opensearch.core.common.unit.ByteSizeValue;
        return Long.toString(Math.max(0L, nativeLimit.getBytes() * percent / 100));
        }  
    private volatile ScheduledFuture<?> rebalanceTask;
    /** Factor to shrink idle pools by (new limit = limit * (1 - shrink_factor)). */  
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
        // own limit stops guarding allocations and the only remaining ceiling is the JVM-wide direct-memory
            NativeAllocatorPoolConfig.POOL_INGEST,
        if (min > max) {
    static String derivePoolMaxDefault(Settings settings, int percent) {  
            }
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_INGEST_MAX),
        NativeAllocatorPoolConfig.SETTING_INGEST_MAX,  
        long v = Long.parseLong(s);  
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;  
        SettingsFilter settingsFilter,
        ThreadPool threadPool,
    }
        );  
        DEFAULT_OVERCOMMIT_PRESSURE_THRESHOLD,
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.node.DiscoveryNodes;
     * Constructs the allocator and wires its pools and the rebalancer.
    private static void validateMinMax(String poolName, long min, long max) {  
            throw new IllegalArgumentException("Setting [" + settingName + "] must be >= 0, got " + v);
    public static final Setting<Long> INGEST_MIN_SETTING = new Setting<>(
            IDLE_THRESHOLD_SETTING.getDefault(Settings.EMPTY),  
        validateMinMax(NativeAllocatorPoolConfig.POOL_FLIGHT, FLIGHT_MIN_SETTING.get(settings), FLIGHT_MAX_SETTING.get(settings));
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
        // Set budget for validation
    }  
            return Long.toString(Math.max(0L, maxDirect * percent / 100));
    /** Maximum bytes the Flight pool can burst to. Default is 5% of budget. */
        Settings settings = environment.settings();  
                allocator.resetAllPoolsToMax();
            return t;
        this.rebalancerScheduler = executor;
import org.opensearch.transport.client.Client;  
import java.io.IOException;  
        if (nativeBudget > 0) {  
        ClusterSettings clusterSettings,
import org.opensearch.plugins.ExtensiblePlugin;
    /**
        Setting.Property.NodeScope,
    private void updateRebalanceInterval(long newInterval) {
        try {
    /** Minimum guaranteed bytes for the query pool. Default is 2% of budget. */
        0.50,
    );
    /** Pool utilization below this means pool can give back capacity. */
        }  
        Supplier<RepositoriesService> repositoriesServiceSupplier
}  
        Setting.Property.Dynamic
        Setting.Property.Dynamic
        return List.of(
    );  
    @Override
            OVERCOMMIT_MAX_CONCURRENT_SETTING  
    public static final Setting<Boolean> REBALANCER_ENABLED_SETTING = Setting.boolSetting(  
import io.netty.util.internal.PlatformDependent;
            PoolGroup.INDEXING
            return -1L;
        validateMinMax(NativeAllocatorPoolConfig.POOL_QUERY, QUERY_MIN_SETTING.get(settings), QUERY_MAX_SETTING.get(settings));
    static final int OVERCOMMIT_MAX_CONCURRENT_MIN = 1;
import org.opensearch.watcher.ResourceWatcherService;
        0.0,
            SHRINK_FACTOR_SETTING.getDefault(Settings.EMPTY)
import org.opensearch.rest.RestController;
import java.util.Collection;
            PoolGroup.TRANSPORT
    }  
        cs.addSettingsUpdateConsumer(REBALANCER_ENABLED_SETTING, enabled -> {
        return v;
        cs.addSettingsUpdateConsumer(PRESSURE_THRESHOLD_SETTING, value -> {
        Setting.Property.NodeScope,  
    );
        // budget (MaxDirectMemorySize). A burst of concurrent allocations then exhausts that shared budget
        }  
            INGEST_MIN_SETTING.get(settings),  
        "native.allocator.rebalancer.pressure_threshold",  
    private synchronized void startRebalancer(ArrowNativeAllocator allocator, Supplier<Long> budgetSupplier, long intervalSeconds) {
        allocator.setOverCommitPressureThreshold(OVERCOMMIT_PRESSURE_THRESHOLD_SETTING.get(settings));
        rebalanceTask = rebalancerScheduler.scheduleAtFixedRate(nativeRebalancer, intervalSeconds, intervalSeconds, TimeUnit.SECONDS);
        }
        5L,
            FLIGHT_MAX_SETTING.get(settings),
        Supplier<NativeAllocatorPoolStats> statsSupplier = () -> {
        ArrowNativeAllocator allocator = new ArrowNativeAllocator();
            return Long.toString(Math.max(0L, nativeLimit.getBytes() * percent / 100));  
            rebalancerScheduler = null;
        NativeAllocatorPoolConfig.SETTING_FLIGHT_MIN,  
            INGEST_MAX_SETTING.get(settings),
        // max_concurrent is a static (non-dynamic) setting applied once at startup.  
        Environment environment,  
        Setting.Property.Dynamic
        true,
        NativeAllocatorPoolConfig.SETTING_QUERY_MIN,  
            OVERCOMMIT_PRESSURE_THRESHOLD_SETTING,
        Setting.Property.NodeScope,  
        Setting.Property.NodeScope,  
            NativeMemoryRebalancer r = this.rebalancer;  
            allocator = null;
        // pool stays bounded strictly below the wall and over-budget allocations circuit-break within the pool.
        executor.setRemoveOnCancelPolicy(true);
            INGEST_MAX_SETTING,
        Supplier<NativeAllocatorPoolStats> statsSupplier = () -> allocator != null ? allocator.stats() : null;
        NativeAllocatorPoolConfig.SETTING_INGEST_MIN,  
    );
    /** Pool utilization above this triggers growth. */
    static final double OVERCOMMIT_PRESSURE_THRESHOLD_MIN = 0.0;  
    static final double OVERCOMMIT_PRESSURE_THRESHOLD_MAX = 100.0;
        1.0,
        DEFAULT_OVERCOMMIT_MAX_CONCURRENT,
 *
        if (rebalancerScheduler != null) {
    /** Minimum guaranteed bytes for the Flight pool. Default is 2% of budget. */
    ) {
        Setting.Property.Dynamic
        Setting.Property.Dynamic
import org.opensearch.common.settings.ClusterSettings;
        0.10,  
    /** Minimum guaranteed bytes for the ingest pool. Default is 1% of budget on warm nodes, 2% otherwise. */
        });  
            PRESSURE_THRESHOLD_SETTING.getDefault(Settings.EMPTY),
import org.opensearch.repositories.RepositoriesService;  
        Supplier<Long> budgetSupplier = () -> ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(clusterService.getSettings())
     */  
        "native.allocator.overcommit.pressure_threshold",  
        if (nativeLimit.getBytes() > 0) {
            INGEST_MIN_SETTING,
        Setting.Property.Dynamic
        if (intervalSeconds <= 0) return;  
import java.util.List;
        RestController restController,
        Setting.Property.Dynamic
    /** Maximum bytes the ingest pool can burst to. Default is 3% of budget on warm nodes, 5% otherwise. */
        NodeEnvironment nodeEnvironment,
            if (r != null) r.setShrinkFactor(value);  
public class ArrowBasePlugin extends Plugin implements ExtensiblePlugin, ActionPlugin {
        if (rebalancer != null || rebalancerScheduler != null) return;
    );
        Setting.Property.NodeScope,  
        // and fails as a hard OutOfDirectMemoryError instead of a contained, per-pool OutOfMemoryException.  
    );  
            allocator.setBudget(nativeBudget);
    public ArrowBasePlugin() {}
        // Register dynamic setting consumers for min/max changes
    private volatile NativeMemoryRebalancer rebalancer;  
        });  
        }
        cs.addSettingsUpdateConsumer(QUERY_MAX_SETTING, newMax -> allocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_QUERY, newMax));
        Setting.Property.Dynamic
        }  
        cs.addSettingsUpdateConsumer(INGEST_MAX_SETTING, newMax -> allocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_INGEST, newMax));  
    /** Interval in seconds between pool rebalance cycles. 0 disables rebalancing. */
    public static final Setting<Double> IDLE_THRESHOLD_SETTING = Setting.doubleSetting(  
        0L,
package org.opensearch.arrow.allocator;
    // ─── Plugin lifecycle ────────────────────────────────────────────────────────
            FLIGHT_MAX_SETTING,  
    @Override  
        cs.addSettingsUpdateConsumer(OVERCOMMIT_PRESSURE_THRESHOLD_SETTING, allocator::setOverCommitPressureThreshold);  
        "native.allocator.rebalancer.idle_threshold",
        // Create pools (always start at max)  
        }
    public static final Setting<Long> FLIGHT_MAX_SETTING = new Setting<>(
import org.opensearch.common.settings.Settings;
                startRebalancer(allocator, budgetSupplier, cs.get(REBALANCE_INTERVAL_SETTING));
    public static final Setting<Double> SHRINK_FACTOR_SETTING = Setting.doubleSetting(
        NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX,  
        if (budget <= 0) return;
        Setting.Property.NodeScope,  
        ArrowNativeAllocator built = buildAllocator(settings, cs, budgetSupplier);
        IndexNameExpressionResolver indexNameExpressionResolver,
    public List<Setting<?>> getSettings() {  
 * this file be licensed under the Apache-2.0 license or a
        // Register dynamic consumer for rebalancer enable/disable
    /**
        if (existing != null) {  
 */  
        ClusterSettings cs = clusterService.getClusterSettings();
        long budget = budgetSupplier.get();
    /** Lower bound (and floor) for the max-concurrent over-commit setting. */  
        1.0,
        }  
            NativeMemoryRebalancer r = this.rebalancer;
        if (newInterval > 0 && rebalancerScheduler != null && rebalancer != null) {
        // MaxDirectMemorySize itself is unavailable (should not happen on a supported JVM); preserve the
    ArrowNativeAllocator buildAllocator(Settings settings, ClusterSettings cs, Supplier<Long> budgetSupplier) {
        s -> derivePoolMinDefault(s, DiscoveryNode.isWarmNode(s) ? 1 : 2),
        if (v < 0) {
        };
    );
        validateMinMax(NativeAllocatorPoolConfig.POOL_INGEST, INGEST_MIN_SETTING.get(settings), INGEST_MAX_SETTING.get(settings));  
            allocator.close();  
     */
 */  
import org.opensearch.common.settings.Setting;  
    static String derivePoolMinDefault(Settings settings, int percent) {  
import org.opensearch.cluster.service.ClusterService;  
            if (r != null) r.setPressureThreshold(value);
            NativeAllocatorPoolConfig.POOL_FLIGHT,
        IndexNameExpressionResolver indexNameExpressionResolver,  
        ScheduledFuture<?> existing = rebalanceTask;
    }
        0.75,
        // Validate min < max for each pool
        });  
        Client client,  
        this.rebalancer = nativeRebalancer;  
        // Over-commit admission: apply initial values and register dynamic consumers.  
     * defaults to half the available processors.
    }  
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX),
        return Long.toString(Long.MAX_VALUE);  
            PRESSURE_THRESHOLD_SETTING,
        Setting.Property.NodeScope
import java.util.concurrent.ScheduledFuture;
    }
            FLIGHT_MIN_SETTING,
        cs.addSettingsUpdateConsumer(QUERY_MIN_SETTING, newMin -> allocator.setPoolMin(NativeAllocatorPoolConfig.POOL_QUERY, newMin));
            REBALANCE_INTERVAL_SETTING,
        OVERCOMMIT_PRESSURE_THRESHOLD_MAX,  
    );
        Setting.Property.Dynamic
        OVERCOMMIT_MAX_CONCURRENT_MIN,
    /** Upper bound for the over-commit pressure threshold setting. */
            QUERY_MIN_SETTING.get(settings),  
 * <p>All Arrow-consuming plugins extend this plugin to share one
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_QUERY_MAX),
import java.util.concurrent.ScheduledExecutorService;  
        s -> derivePoolMinDefault(s, 2),
        Settings settings,  
            allocator,  
    public static final Setting<Integer> OVERCOMMIT_MAX_CONCURRENT_SETTING = Setting.intSetting(  
    static final int DEFAULT_OVERCOMMIT_MAX_CONCURRENT = Math.max(  
        NamedXContentRegistry xContentRegistry,
            FLIGHT_MIN_SETTING.get(settings),  
        allocator.getOrCreatePool(
    );  
    private volatile ArrowNativeAllocator allocator;  
import java.util.function.Supplier;  
            if (r != null) r.setIdleThreshold(value);
    private synchronized void cancelRebalanceTask() {
    static long maxDirectMemoryBytes() {
            IDLE_THRESHOLD_SETTING,
    /** Maximum bytes the query pool can allocate. Default is 5% of budget. */
    static final double DEFAULT_OVERCOMMIT_PRESSURE_THRESHOLD = 70.0;
        return List.of(new ArrowBaseStatsAction(statsSupplier));  
        Setting.Property.NodeScope,  
 * Top-level plugin that owns the unified Arrow-backed native memory allocator.
        }
 * SPDX-License-Identifier: Apache-2.0
            QUERY_MAX_SETTING,
/**
        rebalancer = null;
        "native.allocator.rebalancer.shrink_factor",
        Setting.Property.NodeScope,  
        allocator.setMaxConcurrentOverCommits(OVERCOMMIT_MAX_CONCURRENT_SETTING.get(settings));
import org.opensearch.rest.RestHandler;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            NativeAllocatorPoolConfig.POOL_QUERY,
import org.opensearch.env.NodeEnvironment;
            ArrowNativeAllocator a = this.allocator;
            PoolGroup.SEARCH
        long nativeBudget = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings).getBytes();
        this.allocator = built;
 * compatible open source license.
        DEFAULT_OVERCOMMIT_ENABLED,
            return a != null ? a.stats() : null;  
        // Fall back to the same percentage of MaxDirectMemorySize (always known - it is a JVM setting) so the
        cs.addSettingsUpdateConsumer(REBALANCE_INTERVAL_SETTING, this::updateRebalanceInterval);
                cancelRebalanceTask();
        // historical unbounded behaviour rather than accidentally pinning the pool to 0.
    public static final Setting<Double> OVERCOMMIT_PRESSURE_THRESHOLD_SETTING = Setting.doubleSetting(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        });
            throw new IllegalArgumentException("Pool '" + poolName + "' min (" + min + ") exceeds max (" + max + ")");
        allocator.setOverCommitEnabled(OVERCOMMIT_ENABLED_SETTING.get(settings));
        if (allocator != null) {
        });
    /** Default for {@link #OVERCOMMIT_ENABLED_SETTING}: the over-commit fallback is on by default. */
    @Override
        );  
    }
            SHRINK_FACTOR_SETTING,  
            .getBytes();  
        // Register dynamic consumer for interval changes
        "native.allocator.overcommit.max_concurrent",
        allocator.getOrCreatePool(
            startRebalancer(allocator, budgetSupplier, REBALANCE_INTERVAL_SETTING.get(settings));
            t.setDaemon(true);
        Setting.Property.Dynamic
    private static long parseNonNegativeLong(String s, String settingName) {
    // ─── Settings ────────────────────────────────────────────────────────────────  
            FutureUtils.cancel(existing);
    // ─── Package-private (visible for tests) ─────────────────────────────────────
    public static final Setting<Boolean> OVERCOMMIT_ENABLED_SETTING = Setting.boolSetting(  
        "native.allocator.rebalancer.enabled",
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
        Runtime.getRuntime().availableProcessors() / 4
            rebalancerScheduler.shutdown();  
        );  
    /** Default max concurrent over-commits: half the available processors (at least one). */
    );
