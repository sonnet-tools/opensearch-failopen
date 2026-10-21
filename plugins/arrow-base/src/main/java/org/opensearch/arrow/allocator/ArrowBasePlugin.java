        // Register dynamic consumers for threshold changes
        Setting.Property.Dynamic
import java.util.concurrent.ScheduledExecutorService;
import org.opensearch.script.ScriptService;
        RestController restController,
        });
    ArrowNativeAllocator buildAllocator(Settings settings, ClusterSettings cs, Supplier<Long> budgetSupplier) {
     * Constructs the allocator and wires its pools and the rebalancer.
    @Override
        Supplier<NativeAllocatorPoolStats> statsSupplier = () -> allocator != null ? allocator.stats() : null;
        s -> derivePoolMinDefault(s, 2),
    static String derivePoolMaxDefault(Settings settings, int percent) {
import org.opensearch.threadpool.Scheduler;
            SHRINK_FACTOR_SETTING.getDefault(Settings.EMPTY)
        // pool stays bounded strictly below the wall and over-budget allocations circuit-break within the pool.
        allocator.getOrCreatePool(
    static final double OVERCOMMIT_PRESSURE_THRESHOLD_MIN = 0.0;
    public static final Setting<Double> OVERCOMMIT_PRESSURE_THRESHOLD_SETTING = Setting.doubleSetting(
    private void updateRebalanceInterval(long newInterval) {
        if (v < 0) {
    static final double DEFAULT_OVERCOMMIT_PRESSURE_THRESHOLD = 70.0;
            if (r != null) r.setPressureThreshold(value);
    );
        allocator.setMaxConcurrentOverCommits(OVERCOMMIT_MAX_CONCURRENT_SETTING.get(settings));
        0.0,
        NativeAllocatorPoolConfig.SETTING_QUERY_MAX,
    public static final Setting<Double> IDLE_THRESHOLD_SETTING = Setting.doubleSetting(
        cs.addSettingsUpdateConsumer(REBALANCER_ENABLED_SETTING, enabled -> {
        Setting.Property.Dynamic
    public static final Setting<Boolean> REBALANCER_ENABLED_SETTING = Setting.boolSetting(
        allocator.getOrCreatePool(
    /**
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_INGEST_MAX),
    );
        "native.allocator.rebalance.interval_seconds",
    private volatile ScheduledExecutorService rebalancerScheduler;
    }
        }
        ScriptService scriptService,
    }
    /** Default node native-memory pressure % at/above which over-commit is refused. */
    /** Pool utilization below this means pool can give back capacity. */
    static long maxDirectMemoryBytes() {
        Supplier<RepositoriesService> repositoriesServiceSupplier
import org.opensearch.watcher.ResourceWatcherService;
        if (intervalSeconds <= 0) return;
        0.0,
        };
    /**
    static final double OVERCOMMIT_PRESSURE_THRESHOLD_MAX = 100.0;
        0.50,
            return PlatformDependent.maxDirectMemory();
import java.util.Collection;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        }
        // Register dynamic consumer for interval changes
import java.util.List;
    private static long parseNonNegativeLong(String s, String settingName) {
        NativeMemoryRebalancer nativeRebalancer = new NativeMemoryRebalancer(
        executor.setRemoveOnCancelPolicy(true);
import org.opensearch.plugin.stats.NativeAllocatorStatsRegistry;
                allocator.resetAllPoolsToMax();
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_QUERY_MAX),
        // own limit stops guarding allocations and the only remaining ceiling is the JVM-wide direct-memory
import org.opensearch.plugins.ActionPlugin;
        }
        Client client,
        Setting.Property.Dynamic
        ThreadPool threadPool,
     */
        Setting.Property.Dynamic
        "native.allocator.rebalancer.idle_threshold",
        cancelRebalanceTask();
        rebalanceTask = rebalancerScheduler.scheduleAtFixedRate(nativeRebalancer, intervalSeconds, intervalSeconds, TimeUnit.SECONDS);
            NativeMemoryRebalancer r = this.rebalancer;
    }
    private synchronized void cancelRebalanceTask() {
            FLIGHT_MAX_SETTING,
    public List<Setting<?>> getSettings() {
        cs.addSettingsUpdateConsumer(QUERY_MAX_SETTING, newMax -> allocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_QUERY, newMax));
                startRebalancer(allocator, budgetSupplier, cs.get(REBALANCE_INTERVAL_SETTING));
        // Register dynamic consumer for rebalancer enable/disable
            allocator.setBudget(nativeBudget);
            throw new IllegalArgumentException("Setting [" + settingName + "] must be >= 0, got " + v);
        IndexNameExpressionResolver indexNameExpressionResolver,
        NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX,
        long v = Long.parseLong(s);
        // and fails as a hard OutOfDirectMemoryError instead of a contained, per-pool OutOfMemoryException.
            allocator,
        return List.of(built, new NativeAllocatorStatsRegistry(statsSupplier, built::setNativeMemoryPressureSupplier));
import org.opensearch.env.NodeEnvironment;
            rebalancerScheduler = null;
 * Top-level plugin that owns the unified Arrow-backed native memory allocator.
import org.opensearch.common.settings.IndexScopedSettings;
        Setting.Property.NodeScope,
        // MaxDirectMemorySize itself is unavailable (should not happen on a supported JVM); preserve the
    );
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
            return a != null ? a.stats() : null;
import org.opensearch.plugins.ExtensiblePlugin;
        Setting.Property.Dynamic
    /** Node native-memory pressure % at/above which over-commit is refused. */
    static String derivePoolMinDefault(Settings settings, int percent) {
            allocator = null;
    }
import org.opensearch.env.Environment;
        Setting.Property.NodeScope,
package org.opensearch.arrow.allocator;
    /** Interval in seconds between pool rebalance cycles. 0 disables rebalancing. */
        // Set up the rebalancer if enabled
        if (REBALANCER_ENABLED_SETTING.get(settings)) {
    @Override
            rebalancerScheduler.shutdownNow();
    /** Default for {@link #OVERCOMMIT_ENABLED_SETTING}: the over-commit fallback is on by default. */
        s -> derivePoolMinDefault(s, 2),
    static final boolean DEFAULT_OVERCOMMIT_ENABLED = true;
    );
        OVERCOMMIT_PRESSURE_THRESHOLD_MAX,
        // budget (MaxDirectMemorySize). A burst of concurrent allocations then exhausts that shared budget
    // ─── Private helpers ─────────────────────────────────────────────────────────
        });
import org.opensearch.common.settings.Setting;
        allocator.setOverCommitPressureThreshold(OVERCOMMIT_PRESSURE_THRESHOLD_SETTING.get(settings));
    /** Maximum bytes the ingest pool can burst to. Default is 3% of budget on warm nodes, 5% otherwise. */
    /** Default max concurrent over-commits: half the available processors (at least one). */
        );
            OVERCOMMIT_ENABLED_SETTING,
    );
        Runtime.getRuntime().availableProcessors() / 4
            NativeMemoryRebalancer r = this.rebalancer;
            return "0";
/*
        Supplier<NativeAllocatorPoolStats> statsSupplier = () -> {
            FLIGHT_MIN_SETTING.get(settings),
        if (rebalancerScheduler != null) {
        SettingsFilter settingsFilter,
    );
            rebalanceTask = null;
            INGEST_MAX_SETTING,
        long nativeBudget = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings).getBytes();
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_INGEST_MIN),
    static final int DEFAULT_OVERCOMMIT_MAX_CONCURRENT = Math.max(
    }
        Setting.Property.Dynamic
        "native.allocator.overcommit.max_concurrent",
        1.0,
        Setting.Property.NodeScope,
        Setting.Property.NodeScope,
        cs.addSettingsUpdateConsumer(QUERY_MIN_SETTING, newMin -> allocator.setPoolMin(NativeAllocatorPoolConfig.POOL_QUERY, newMin));
    @Override
        });
    private volatile NativeMemoryRebalancer rebalancer;
        Setting.Property.NodeScope,
        if (allocator != null) {
 * compatible open source license.
            QUERY_MIN_SETTING,
            PoolGroup.INDEXING
     */
            PoolGroup.TRANSPORT
        return v;
            OVERCOMMIT_MAX_CONCURRENT_SETTING
import org.opensearch.arrow.spi.PoolGroup;
import org.opensearch.cluster.service.ClusterService;
    /** Maximum bytes the query pool can allocate. Default is 5% of budget. */
        s -> derivePoolMaxDefault(s, 5),
            PoolGroup.SEARCH
    /** Minimum guaranteed bytes for the Flight pool. Default is 2% of budget. */
        NamedXContentRegistry xContentRegistry,
        s -> derivePoolMinDefault(s, DiscoveryNode.isWarmNode(s) ? 1 : 2),
        s -> derivePoolMaxDefault(s, DiscoveryNode.isWarmNode(s) ? 3 : 5),
import org.opensearch.common.settings.ClusterSettings;
        Setting.Property.NodeScope
import org.opensearch.common.util.concurrent.FutureUtils;
 * SPDX-License-Identifier: Apache-2.0
        validateMinMax(NativeAllocatorPoolConfig.POOL_INGEST, INGEST_MIN_SETTING.get(settings), INGEST_MAX_SETTING.get(settings));
        cs.addSettingsUpdateConsumer(FLIGHT_MIN_SETTING, newMin -> allocator.setPoolMin(NativeAllocatorPoolConfig.POOL_FLIGHT, newMin));
    );
import org.opensearch.plugins.Plugin;
    );
            .getBytes();
    }
        Setting.Property.NodeScope,
            FLIGHT_MIN_SETTING,
        OVERCOMMIT_MAX_CONCURRENT_MIN,
import java.util.concurrent.TimeUnit;
import org.opensearch.rest.RestHandler;
        ClusterSettings cs = clusterService.getClusterSettings();
        }
        long budget = budgetSupplier.get();
        // Set budget for validation
        NodeEnvironment nodeEnvironment,
 */
    /** Lower bound (and floor) for the max-concurrent over-commit setting. */
        }
    public static final Setting<Boolean> OVERCOMMIT_ENABLED_SETTING = Setting.boolSetting(
    /** Factor to shrink idle pools by (new limit = limit * (1 - shrink_factor)). */
    );
        ResourceWatcherService resourceWatcherService,
            budgetSupplier,
import org.opensearch.cluster.node.DiscoveryNodes;
    /** Upper bound for the over-commit pressure threshold setting. */
        // max_concurrent is a static (non-dynamic) setting applied once at startup.
}
        return List.of(new ArrowBaseStatsAction(statsSupplier));
import org.opensearch.transport.client.Client;
        5L,
    );
    public Collection<Object> createComponents(
        true,
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX),
        );
            PRESSURE_THRESHOLD_SETTING.getDefault(Settings.EMPTY),
    private volatile ArrowNativeAllocator allocator;
        ArrowNativeAllocator allocator = new ArrowNativeAllocator();
        Setting.Property.NodeScope,
    // ─── Plugin lifecycle ────────────────────────────────────────────────────────
        // Create pools (always start at max)
        if (rebalancerScheduler != null) {
        cs.addSettingsUpdateConsumer(IDLE_THRESHOLD_SETTING, value -> {
    );
                cancelRebalanceTask();
    }
    /** Creates the plugin. */
        OVERCOMMIT_PRESSURE_THRESHOLD_MIN,
        Setting.Property.NodeScope,
 * <p>All Arrow-consuming plugins extend this plugin to share one
        Environment environment,
 */
        Supplier<DiscoveryNodes> nodesInCluster
        allocator.setOverCommitEnabled(OVERCOMMIT_ENABLED_SETTING.get(settings));
        allocator.getOrCreatePool(
        Setting.Property.Dynamic
import org.opensearch.core.xcontent.NamedXContentRegistry;
            if (enabled == false) {
        // node.native_memory.limit could not be derived (e.g. a restricted container where physical-memory
        );
            INGEST_MAX_SETTING.get(settings),
        DEFAULT_OVERCOMMIT_PRESSURE_THRESHOLD,
    private synchronized void startRebalancer(ArrowNativeAllocator allocator, Supplier<Long> budgetSupplier, long intervalSeconds) {
    }
        Setting.Property.Dynamic
    public static final Setting<Long> FLIGHT_MIN_SETTING = new Setting<>(
            INGEST_MIN_SETTING,
        "native.allocator.rebalancer.enabled",
            REBALANCER_ENABLED_SETTING,
        validateMinMax(NativeAllocatorPoolConfig.POOL_QUERY, QUERY_MIN_SETTING.get(settings), QUERY_MAX_SETTING.get(settings));
        "native.allocator.overcommit.enabled",
            rebalanceTask = rebalancerScheduler.scheduleAtFixedRate(rebalancer, newInterval, newInterval, TimeUnit.SECONDS);
        if (budget <= 0) return;
        IndexScopedSettings indexScopedSettings,
            t.setDaemon(true);
        s -> derivePoolMaxDefault(s, 5),
    }
        // Register dynamic setting consumers for min/max changes
     * defaults to half the available processors.
        Setting.Property.NodeScope,
        Supplier<Long> budgetSupplier = () -> ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(clusterService.getSettings())
 * this file be licensed under the Apache-2.0 license or a
        Setting.Property.NodeScope,
        Setting.Property.Dynamic
            QUERY_MAX_SETTING.get(settings),
            NativeAllocatorPoolConfig.POOL_FLIGHT,
        cs.addSettingsUpdateConsumer(REBALANCE_INTERVAL_SETTING, this::updateRebalanceInterval);
            return Long.toString(Math.max(0L, nativeLimit.getBytes() * percent / 100));
    // ─── Package-private (visible for tests) ─────────────────────────────────────
        "native.allocator.rebalancer.shrink_factor",
        ScheduledFuture<?> existing = rebalanceTask;
    /** Whether the NativeMemoryRebalancer is enabled. */
        });
        }
            allocator.close();
    }
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            QUERY_MIN_SETTING.get(settings),
        OVERCOMMIT_MAX_CONCURRENT_MIN,
        }
        return allocator;
        this.rebalancerScheduler = executor;
    static final int OVERCOMMIT_MAX_CONCURRENT_MIN = 1;
        IndexNameExpressionResolver indexNameExpressionResolver,
    @Override
        cs.addSettingsUpdateConsumer(FLIGHT_MAX_SETTING, newMax -> allocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_FLIGHT, newMax));
import org.opensearch.cluster.node.DiscoveryNode;
    public static final Setting<Long> REBALANCE_INTERVAL_SETTING = Setting.longSetting(
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
        Setting.Property.Dynamic
        ByteSizeValue nativeLimit = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
            INGEST_MIN_SETTING.get(settings),
            } else {
        NamedWriteableRegistry namedWriteableRegistry,
            ArrowNativeAllocator a = this.allocator;
        DEFAULT_OVERCOMMIT_MAX_CONCURRENT,
        Settings settings,
    public static final Setting<Integer> OVERCOMMIT_MAX_CONCURRENT_SETTING = Setting.intSetting(
        NativeAllocatorPoolConfig.SETTING_INGEST_MAX,
    private volatile ScheduledFuture<?> rebalanceTask;
        cs.addSettingsUpdateConsumer(SHRINK_FACTOR_SETTING, value -> {
        if (nativeLimit.getBytes() <= 0) {
        }
import org.opensearch.arrow.spi.NativeAllocatorPoolConfig;
    public void close() throws IOException {
    /** JVM {@code -XX:MaxDirectMemorySize} in bytes, or -1 when it cannot be determined. */
    /** Lower bound for the over-commit pressure threshold setting. */
        });
/**
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
 * The OpenSearch Contributors require contributions made to
        if (existing != null) {
    public static final Setting<Long> INGEST_MIN_SETTING = new Setting<>(
            startRebalancer(allocator, budgetSupplier, REBALANCE_INTERVAL_SETTING.get(settings));
        // historical unbounded behaviour rather than accidentally pinning the pool to 0.
        Setting.Property.NodeScope,
    );
            QUERY_MAX_SETTING,
        ClusterSettings clusterSettings,
        0.10,
        rebalancer = null;
    // ─── Instance state ──────────────────────────────────────────────────────────
        cs.addSettingsUpdateConsumer(INGEST_MIN_SETTING, newMin -> allocator.setPoolMin(NativeAllocatorPoolConfig.POOL_INGEST, newMin));
public class ArrowBasePlugin extends Plugin implements ExtensiblePlugin, ActionPlugin {
            rebalancerScheduler.shutdown();
        return List.of(
 *
        cs.addSettingsUpdateConsumer(PRESSURE_THRESHOLD_SETTING, value -> {
import org.opensearch.repositories.RepositoriesService;
            }
import java.util.concurrent.ScheduledFuture;
            return Long.toString(Math.max(0L, maxDirect * percent / 100));
            throw new IllegalArgumentException("Pool '" + poolName + "' min (" + min + ") exceeds max (" + max + ")");
        ArrowNativeAllocator built = buildAllocator(settings, cs, budgetSupplier);
        cs.addSettingsUpdateConsumer(OVERCOMMIT_PRESSURE_THRESHOLD_SETTING, allocator::setOverCommitPressureThreshold);
    public static final Setting<Long> QUERY_MIN_SETTING = new Setting<>(
    /** Minimum guaranteed bytes for the query pool. Default is 2% of budget. */
        Setting.Property.NodeScope,
        );
            PRESSURE_THRESHOLD_SETTING,
        ClusterService clusterService,
    ) {
            FLIGHT_MAX_SETTING.get(settings),
        cs.addSettingsUpdateConsumer(OVERCOMMIT_ENABLED_SETTING, allocator::setOverCommitEnabled);
        0.0,
        Settings settings = environment.settings();
        // probing returns 0). Falling back to Long.MAX_VALUE would leave the pool UNBOUNDED, so the pool's
        // Validate min < max for each pool
        } catch (Throwable t) {
            NativeAllocatorPoolConfig.POOL_INGEST,
    public List<RestHandler> getRestHandlers(
        "native.allocator.rebalancer.pressure_threshold",
        Scheduler.SafeScheduledThreadPoolExecutor executor = new Scheduler.SafeScheduledThreadPoolExecutor(1, r -> {
        0.75,
            OVERCOMMIT_PRESSURE_THRESHOLD_SETTING,
import org.opensearch.common.settings.Settings;
    public static final Setting<Long> INGEST_MAX_SETTING = new Setting<>(
        cs.addSettingsUpdateConsumer(INGEST_MAX_SETTING, newMax -> allocator.setPoolLimit(NativeAllocatorPoolConfig.POOL_INGEST, newMax));
            FutureUtils.cancel(existing);
        }
    );
     * Maximum number of concurrently over-committing operations. Static (node-scope, non-dynamic);
        NativeAllocatorPoolConfig.SETTING_INGEST_MIN,
        // Fall back to the same percentage of MaxDirectMemorySize (always known - it is a JVM setting) so the
            IDLE_THRESHOLD_SETTING,
        Setting.Property.Dynamic
    private static void validateMinMax(String poolName, long min, long max) {
        if (maxDirect > 0) {
import java.io.IOException;
            if (r != null) r.setShrinkFactor(value);
        long maxDirect = maxDirectMemoryBytes();
        try {
import java.util.function.Supplier;
            return t;
    }
    public static final Setting<Double> SHRINK_FACTOR_SETTING = Setting.doubleSetting(
        validateMinMax(NativeAllocatorPoolConfig.POOL_FLIGHT, FLIGHT_MIN_SETTING.get(settings), FLIGHT_MAX_SETTING.get(settings));
    /** Minimum guaranteed bytes for the ingest pool. Default is 1% of budget on warm nodes, 2% otherwise. */
            return -1L;
    // ─── Settings ────────────────────────────────────────────────────────────────
import org.opensearch.threadpool.ThreadPool;
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_FLIGHT_MIN),
    }
        if (nativeBudget > 0) {
    );
        }
        if (min > max) {
        Setting.Property.NodeScope,
import org.opensearch.common.settings.SettingsFilter;
        );
    /** Feature gate for the over-commit fallback when a pool is full. Default on. */
 *
        NativeAllocatorPoolConfig.SETTING_QUERY_MIN,
    public static final Setting<Long> FLIGHT_MAX_SETTING = new Setting<>(
            NativeAllocatorPoolConfig.POOL_QUERY,
            IDLE_THRESHOLD_SETTING.getDefault(Settings.EMPTY),
            SHRINK_FACTOR_SETTING,
        NativeAllocatorPoolConfig.SETTING_FLIGHT_MIN,
    ) {
    public static final Setting<Long> QUERY_MAX_SETTING = new Setting<>(
            NativeMemoryRebalancer r = this.rebalancer;
        if (rebalancer != null || rebalancerScheduler != null) return;
        }
        0L,
import io.netty.util.internal.PlatformDependent;
        s -> parseNonNegativeLong(s, NativeAllocatorPoolConfig.SETTING_QUERY_MIN),
import org.opensearch.core.common.unit.ByteSizeValue;
        return Long.toString(Math.max(0L, nativeLimit.getBytes() * percent / 100));
    public ArrowBasePlugin() {}
 * {@link ArrowNativeAllocator} and its classloader.
        Setting.Property.Dynamic
        // Over-commit admission: apply initial values and register dynamic consumers.
import org.opensearch.rest.RestController;
    public static final Setting<Double> PRESSURE_THRESHOLD_SETTING = Setting.doubleSetting(
            REBALANCE_INTERVAL_SETTING,
        }
        if (newInterval > 0 && rebalancerScheduler != null && rebalancer != null) {
    /** Maximum bytes the Flight pool can burst to. Default is 5% of budget. */
        1.0,
            if (r != null) r.setIdleThreshold(value);
    );
            Thread t = new Thread(r, "native-allocator-rebalancer");
        this.rebalancer = nativeRebalancer;
        DEFAULT_OVERCOMMIT_ENABLED,
        this.allocator = built;
        }
        Setting.Property.Dynamic
        "native.allocator.overcommit.pressure_threshold",
        return Long.toString(Long.MAX_VALUE);
    /** Pool utilization above this triggers growth. */
        if (nativeLimit.getBytes() > 0) {
        1.0,
