import org.opensearch.nativebridge.spi.NativeArenaPurger;
            clusterService.getClusterSettings()
        "native.jemalloc.dirty_decay_ms",
 */
                if (!p.trim().isEmpty()) {
     * How often the purge thread checks if resident memory exceeds the threshold.
 * the opensearch-heap-prof CLI tool.
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.plugins.Plugin;
        ThreadPool threadPool,
        return List.of(JEMALLOC_DIRTY_DECAY_MS, JEMALLOC_MUZZY_DECAY_MS, JEMALLOC_PURGE_INTERVAL, JEMALLOC_PURGE_THRESHOLD_PERCENT);
                this.currentThresholdPercent = percent;
        return NativeMemoryFetcher.fetch();
                    NativeArenaPurger.setThresholdBytes(computeThresholdBytes());
        // Compute purge threshold and start the Rust-side background purge thread
        // Register the heap profiler MBean first — this is pure Java and always works
     * Set to 0 to disable periodic purging entirely.
 * compatible open source license.
                }
        this.currentThresholdPercent = JEMALLOC_PURGE_THRESHOLD_PERCENT.get(settings);
    );
        }
            });
        java.util.List<String> allowedDirs = new java.util.ArrayList<>();
    }
            clusterService.getClusterSettings().addSettingsUpdateConsumer(JEMALLOC_MUZZY_DECAY_MS, NativeAllocatorConfig::setMuzzyDecayMs);
import org.opensearch.common.settings.Setting;
    public Collection<Object> createComponents(
import java.util.List;
        "native.jemalloc.purge_threshold_percent",
                });
        TimeValue.ZERO,
import org.opensearch.env.NodeEnvironment;
    public List<Setting<?>> getSettings() {
     */
    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import java.util.function.Supplier;
 */
    }
                .addSettingsUpdateConsumer(JEMALLOC_PURGE_INTERVAL, v -> NativeArenaPurger.setCheckIntervalMs(v.millis()));
    /** jemalloc muzzy page decay time (ms). Dynamically tunable — applied to all arenas at runtime. */
            }
import java.util.Collection;
            clusterService.getClusterSettings().addSettingsUpdateConsumer(JEMALLOC_DIRTY_DECAY_MS, NativeAllocatorConfig::setDirtyDecayMs);
import org.opensearch.nativebridge.spi.NativeMemoryFetcher;
 * Always-loaded module that manages runtime tuning for the native (Rust/FFM) layer.
        -1L,
        String extraPaths = System.getProperty("native.heap_prof.allowed_paths", "");
        NativeHeapProfiler.setAllowedDumpDirs(allowedDirs);
        this.currentNativeLimitBytes = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings).getBytes();
     * {@code node.native_memory.limit}. Default: 85%.
     */
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.env.Environment;
    public static final Setting<Long> JEMALLOC_MUZZY_DECAY_MS = Setting.longSetting(
import org.apache.logging.log4j.Logger;
 * Registers dynamic cluster settings and applies changes at runtime via the FFM bridge.
        NativeHeapProfiler.register();
        }
import org.opensearch.common.unit.TimeValue;
        30_000L,
     * Purge fires only when jemalloc resident exceeds this percentage of
        Setting.Property.NodeScope,
        85,
    /**
import org.opensearch.repositories.RepositoriesService;
    );
    public static final Setting<Long> JEMALLOC_DIRTY_DECAY_MS = Setting.longSetting(
    public AnalyticsBackendNativeMemoryStats memoryStats() {
import org.opensearch.nativebridge.spi.NativeAllocatorConfig;
        ClusterService clusterService,
 * The OpenSearch Contributors require contributions made to
        // Apply initial allocator values — requires native library to be loaded
        try {
        0,
    @Override
 * Also registers the NativeHeapProfiler JMX MBean for on-demand heap profiling via
        -1L,
    @Override
    public static final Setting<TimeValue> JEMALLOC_PURGE_INTERVAL = Setting.timeSetting(
        ResourceWatcherService resourceWatcherService,
            clusterService.getClusterSettings()
public class NativeBridgeModule extends Plugin {
 * this file be licensed under the Apache-2.0 license or a
 * <p>
            NativeAllocatorConfig.setDirtyDecayMs(JEMALLOC_DIRTY_DECAY_MS.get(settings));
        return currentNativeLimitBytes > 0 ? currentNativeLimitBytes * currentThresholdPercent / 100 : Long.MAX_VALUE;
        Supplier<RepositoriesService> repositoriesServiceSupplier
        NamedXContentRegistry xContentRegistry,
        30_000L,
        ScriptService scriptService,
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
                NativeArenaPurger.setThresholdBytes(computeThresholdBytes());
            // Register dynamic update listeners
    public static final Setting<Integer> JEMALLOC_PURGE_THRESHOLD_PERCENT = Setting.intSetting(
            clusterService.getClusterSettings().addSettingsUpdateConsumer(JEMALLOC_PURGE_THRESHOLD_PERCENT, percent -> {
    private volatile int currentThresholdPercent;
    @Override
    }
        "native.jemalloc.muzzy_decay_ms",
                .addSettingsUpdateConsumer(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING, limitValue -> {
        if (!NativeLibraryLoader.isLoaded()) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
    ) {
        NativeArenaPurger.init(computeThresholdBytes(), JEMALLOC_PURGE_INTERVAL.get(settings).millis());
        }
import org.opensearch.common.settings.Settings;
    /**
                    this.currentNativeLimitBytes = limitValue.getBytes();
        "native.jemalloc.purge_interval",
        Setting.Property.NodeScope,
    private static final Logger logger = LogManager.getLogger(NativeBridgeModule.class);
                    allowedDirs.add(p.trim());
            return null;
import org.opensearch.transport.client.Client;
    public void close() {
        NamedWriteableRegistry namedWriteableRegistry,
        Setting.Property.NodeScope,
/*
        // Additional paths configurable via system property (set in jvm.options)
        100,
        NodeEnvironment nodeEnvironment,
        return Collections.emptyList();
    private volatile long currentNativeLimitBytes;
        Setting.Property.Dynamic
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
            logger.warn("Native allocator config unavailable — native library may not be loaded", t);
import org.opensearch.threadpool.ThreadPool;
    }
            NativeAllocatorConfig.setMuzzyDecayMs(JEMALLOC_MUZZY_DECAY_MS.get(settings));
        Environment environment,
import org.opensearch.watcher.ResourceWatcherService;
/**
import org.apache.logging.log4j.LogManager;
    private long computeThresholdBytes() {
        Setting.Property.NodeScope,
import org.opensearch.script.ScriptService;
        if (!extraPaths.isEmpty()) {
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;
import java.util.Collections;
        TimeValue.timeValueSeconds(5),
 * SPDX-License-Identifier: Apache-2.0
    /** jemalloc dirty page decay time (ms). Dynamically tunable — applied to all arenas at runtime. */
package org.opensearch.nativebridge;
        NativeArenaPurger.stop();
        allowedDirs.add(environment.dataFiles()[0].toAbsolutePath().toString());
        } catch (Throwable t) {
import org.opensearch.cluster.service.ClusterService;
}
        Setting.Property.Dynamic
        Settings settings = environment.settings();
        Setting.Property.Dynamic
            for (String p : extraPaths.split(",")) {
 *
    );
        Client client,
        Setting.Property.Dynamic
import org.opensearch.nativebridge.spi.NativeHeapProfiler;
    );
