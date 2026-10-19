import org.opensearch.script.ScriptService;  
        -1L,
import org.apache.logging.log4j.Logger;
        java.util.List<String> allowedDirs = new java.util.ArrayList<>();
    public List<Setting<?>> getSettings() {  
 * Always-loaded module that manages runtime tuning for the native (Rust/FFM) layer.
        Supplier<RepositoriesService> repositoriesServiceSupplier  
 */  
import org.opensearch.nativebridge.spi.NativeAllocatorConfig;  
    public static final Setting<TimeValue> JEMALLOC_PURGE_INTERVAL = Setting.timeSetting(
import org.opensearch.threadpool.ThreadPool;
    /** jemalloc muzzy page decay time (ms). Dynamically tunable — applied to all arenas at runtime. */  
import java.util.Collections;  
        "native.jemalloc.purge_threshold_percent",
        return currentNativeLimitBytes > 0 ? currentNativeLimitBytes * currentThresholdPercent / 100 : Long.MAX_VALUE;
            clusterService.getClusterSettings().addSettingsUpdateConsumer(JEMALLOC_PURGE_THRESHOLD_PERCENT, percent -> {
        Setting.Property.NodeScope,  
        IndexNameExpressionResolver indexNameExpressionResolver,
        this.currentNativeLimitBytes = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings).getBytes();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        Setting.Property.Dynamic  
 * this file be licensed under the Apache-2.0 license or a
                    allowedDirs.add(p.trim());
        }
import org.opensearch.nativebridge.spi.NativeLibraryLoader;  
        ClusterService clusterService,  
        // Apply initial allocator values — requires native library to be loaded  
import org.opensearch.plugins.Plugin;
    @Override
import org.opensearch.watcher.ResourceWatcherService;  
        NativeHeapProfiler.register();
    private volatile long currentNativeLimitBytes;  
        return List.of(JEMALLOC_DIRTY_DECAY_MS, JEMALLOC_MUZZY_DECAY_MS, JEMALLOC_PURGE_INTERVAL, JEMALLOC_PURGE_THRESHOLD_PERCENT);
            NativeAllocatorConfig.setMuzzyDecayMs(JEMALLOC_MUZZY_DECAY_MS.get(settings));  
            }
        NamedXContentRegistry xContentRegistry,
import org.opensearch.cluster.service.ClusterService;
                this.currentThresholdPercent = percent;
        // Register the heap profiler MBean first — this is pure Java and always works  
        -1L,
        0,
    @Override
        this.currentThresholdPercent = JEMALLOC_PURGE_THRESHOLD_PERCENT.get(settings);  
        allowedDirs.add(environment.dataFiles()[0].toAbsolutePath().toString());
        if (!NativeLibraryLoader.isLoaded()) {  
    ) {
 * Registers dynamic cluster settings and applies changes at runtime via the FFM bridge.
                if (!p.trim().isEmpty()) {
            clusterService.getClusterSettings().addSettingsUpdateConsumer(JEMALLOC_DIRTY_DECAY_MS, NativeAllocatorConfig::setDirtyDecayMs);  
    /**  
    );
        85,  
            for (String p : extraPaths.split(",")) {  
    public static final Setting<Integer> JEMALLOC_PURGE_THRESHOLD_PERCENT = Setting.intSetting(
    /** jemalloc dirty page decay time (ms). Dynamically tunable — applied to all arenas at runtime. */  
    public AnalyticsBackendNativeMemoryStats memoryStats() {
    }
        Setting.Property.NodeScope,
                .addSettingsUpdateConsumer(JEMALLOC_PURGE_INTERVAL, v -> NativeArenaPurger.setCheckIntervalMs(v.millis()));  
            return null;
import org.opensearch.nativebridge.spi.NativeMemoryFetcher;
import java.util.Collection;
import org.opensearch.transport.client.Client;
                .addSettingsUpdateConsumer(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING, limitValue -> {  
}
        Setting.Property.Dynamic  
    /**  
        TimeValue.ZERO,
 *
        // Compute purge threshold and start the Rust-side background purge thread
        NativeArenaPurger.init(computeThresholdBytes(), JEMALLOC_PURGE_INTERVAL.get(settings).millis());
            clusterService.getClusterSettings()
        Settings settings = environment.settings();
     */  
            clusterService.getClusterSettings()
 * The OpenSearch Contributors require contributions made to  
 * the opensearch-heap-prof CLI tool.  
import org.opensearch.env.NodeEnvironment;
        ScriptService scriptService,  
        if (!extraPaths.isEmpty()) {
    public static final Setting<Long> JEMALLOC_DIRTY_DECAY_MS = Setting.longSetting(
/**
public class NativeBridgeModule extends Plugin {
        30_000L,  
    );
 * <p>  
 * compatible open source license.
        100,
    );
        Client client,
import org.opensearch.env.Environment;
            logger.warn("Native allocator config unavailable — native library may not be loaded", t);
                NativeArenaPurger.setThresholdBytes(computeThresholdBytes());  
                    NativeArenaPurger.setThresholdBytes(computeThresholdBytes());
                });  
        ResourceWatcherService resourceWatcherService,
import org.opensearch.repositories.RepositoriesService;
     */  
            });
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    public Collection<Object> createComponents(
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
import java.util.function.Supplier;
    }
import org.apache.logging.log4j.LogManager;
        "native.jemalloc.dirty_decay_ms",
            NativeAllocatorConfig.setDirtyDecayMs(JEMALLOC_DIRTY_DECAY_MS.get(settings));
        } catch (Throwable t) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;  
    }  
        return NativeMemoryFetcher.fetch();  
import org.opensearch.common.settings.Setting;
        // Additional paths configurable via system property (set in jvm.options)  
        NamedWriteableRegistry namedWriteableRegistry,
            clusterService.getClusterSettings().addSettingsUpdateConsumer(JEMALLOC_MUZZY_DECAY_MS, NativeAllocatorConfig::setMuzzyDecayMs);
    private volatile int currentThresholdPercent;
        "native.jemalloc.muzzy_decay_ms",
 * Also registers the NativeHeapProfiler JMX MBean for on-demand heap profiling via
import java.util.List;
                    this.currentNativeLimitBytes = limitValue.getBytes();
    public void close() {
        }  
        Setting.Property.Dynamic  
        Setting.Property.NodeScope,
     * {@code node.native_memory.limit}. Default: 85%.
import org.opensearch.common.unit.TimeValue;
            // Register dynamic update listeners
 */
        30_000L,  
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    }  
        String extraPaths = System.getProperty("native.heap_prof.allowed_paths", "");
        Environment environment,
        "native.jemalloc.purge_interval",
package org.opensearch.nativebridge;
        Setting.Property.Dynamic
        TimeValue.timeValueSeconds(5),  
    public static final Setting<Long> JEMALLOC_MUZZY_DECAY_MS = Setting.longSetting(
import org.opensearch.nativebridge.spi.NativeArenaPurger;
    private long computeThresholdBytes() {
     * Set to 0 to disable periodic purging entirely.
     * Purge fires only when jemalloc resident exceeds this percentage of
                }  
        NodeEnvironment nodeEnvironment,  
        try {
import org.opensearch.common.settings.Settings;  
        ThreadPool threadPool,
        NativeArenaPurger.stop();  
    private static final Logger logger = LogManager.getLogger(NativeBridgeModule.class);
    }
     * How often the purge thread checks if resident memory exceeds the threshold.
        Setting.Property.NodeScope,
/*  
    );
        NativeHeapProfiler.setAllowedDumpDirs(allowedDirs);  
import org.opensearch.nativebridge.spi.NativeHeapProfiler;
    @Override  
        return Collections.emptyList();
