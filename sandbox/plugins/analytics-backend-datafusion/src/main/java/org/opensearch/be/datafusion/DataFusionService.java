    @Override
     * Returns the current memory pool usage in bytes.
        NativeBridge.shutdownTokioRuntimeManager();
        this.spillDirectory = builder.spillDirectory;
        /** Builds the {@link DataFusionService}. */
        releaseRuntime();
     */
        return NativeBridge.getMemoryPoolStats(getNativeRuntime().get());
    /**
    }
            logger.warn("Failed to warmup files with store", e);
        private ClusterSettings clusterSettings;
import org.opensearch.be.datafusion.stats.SpillStatsCollector;
         */
 * All per-query {@link DatafusionSearchExecEngine} instances share these resources.
        if (filePaths == null || filePaths.isEmpty()) return;
        NativeRuntimeHandle handle = runtimeHandle;
        private long spillMemoryLimit = Runtime.getRuntime().maxMemory() / 8;
     * Returns the handle to the native DataFusion global runtime.
        logger.debug(
    public DataFusionStats getStats() {
     * Existing reservations that exceed the new limit are NOT reclaimed.
     * Returns the number of available CPU threads used for the dedicated executor.
        }
/*
    /** Creates a new builder. */
            }
            coordinatorMultiplier
        );
     */
    }
     * Notifies the native cache that new files are available for caching.
            this.coordinatorMultiplier = multiplier;
            this.cpuThreads = threads;
        }
        NativeRuntimeHandle handle = runtimeHandle;
        }
            throw new IllegalStateException("DataFusionService has not been started");
    private volatile long spillMemoryLimit;
    public String getSpillDirectory() {
    /**
    public void onFilesAddedWithStore(Collection<String> filePaths, long storeBoxPtr) {
        if (handle != null) {
        try {
        );
        /**
    private void releaseRuntime() {
            logger.debug("DataFusion native runtime released");
        NativeBridge.setSpillLimit(getNativeRuntime().get(), newLimitBytes);
 * <p>
    private final ClusterSettings clusterSettings;
            }
        }
         * Sets the cluster settings for cache configuration.
 * Use {@link #builder()} to construct.
    /**
     * Returns the current memory pool limit in bytes.
        this.datanodeMultiplier = builder.datanodeMultiplier;
     */
         * Sets the maximum bytes before spilling to disk.
        NativeBridge.initTokioRuntimeManager(cpuThreads, datanodeMultiplier, coordinatorMultiplier);
            return new DataFusionService(this);
     * @param storeBoxPtr Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer from TieredStorageBridge.getObjectStoreBoxPtr
        }
        this.clusterSettings = builder.clusterSettings;
     * @throws IllegalStateException if the service has not been started
import org.opensearch.common.settings.ClusterSettings;
    /**
        private double coordinatorMultiplier = 1.0;
        }
        private long memoryPoolLimit = Runtime.getRuntime().maxMemory() / 4;
    /**
     * stats readers see updates from the cluster-settings consumer thread without locking.
    }
        return NativeBridge.isSpillLimitDynamic();
    public void setSpillMemoryLimit(long newLimitBytes) {
     * Builds a {@link SpillStats} snapshot from the configured spill directory and the
        }
    /**
        /**
     * @param filePaths absolute paths of the deleted files
     * @param filePaths absolute paths of the new files
     * as {@code spill.disk_reserved_bytes} via {@link #buildSpillStats()}. Volatile so
import org.opensearch.be.datafusion.cache.CacheManager;
        public DataFusionService build() {
        private double datanodeMultiplier = 1.0;
     * Notifies the native cache that files have been deleted and should be evicted.
        try {
}
         * @param bytes memory limit
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
     */
            NativeBridge.shutdownTokioRuntimeManager();
    }
 */
     * Returns the spill directory this service was configured with. Empty string
     * updates of {@code datafusion.spill_memory_limit_bytes} have no live effect.
    private volatile NativeRuntimeHandle runtimeHandle;
    /**
            return this;
                cacheHandle.markConsumed();
            return this;
     * files are on S3, this routes through the registry to remote storage.
    public static int cpuThreadCount() {
        /**
import org.opensearch.be.datafusion.stats.SpillStats;
    public long getMemoryPoolUsage() {
        } finally {
    public NativeRuntimeHandle getNativeRuntime() {
    }
     * duplicate log entries.
import org.apache.logging.log4j.LogManager;
     */
    /**
    /**
     * The user-visible info-level log line is emitted by the caller in
import org.apache.logging.log4j.Logger;
         */
    }
        }
     * Returns the spill memory limit (in bytes) this service was configured with.
        } catch (Exception e) {
        } catch (Exception e) {
            NativeBridge.cacheManagerRemoveFiles(runtimeHandle.get(), filePaths.toArray(new String[0]));
        return handle;
        public Builder coordinatorMultiplier(double multiplier) {
            long ptr = NativeBridge.createGlobalRuntime(memoryPoolLimit, cacheManagerPtr, spillDirectory, spillMemoryLimit);
            logger.warn("Failed to evict deleted files from native cache", e);
        }
 * and the DataFusion global runtime (memory pool, disk spill, cache).
    private final String spillDirectory;
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        if (handle == null) {
    public long getMemoryPoolLimit() {
        public Builder memoryPoolLimit(long bytes) {
            this.spillMemoryLimit = bytes;
            datanodeMultiplier,
    protected void doStop() {
import java.util.Collection;
        private Builder() {}
 * this file be licensed under the Apache-2.0 license or a
     */
    // Cache management (node-level, delegates to native runtime)
            spill,
        }
import org.opensearch.be.datafusion.cache.CacheUtils;
        logger.debug("Stopping DataFusion service");
    }
        }
package org.opensearch.be.datafusion;
     */
     */
     */
            nativeStats.getSearchStats()
     * Returns the latest native executor stats, collected fresh from JNI on every call.
            this.spillDirectory = path;
 * compatible open source license.
import org.opensearch.be.datafusion.cache.NativeCacheManagerHandle;
        return cacheManager;
            nativeStats.getCacheStats(),
         * Sets the number of CPU threads for the dedicated executor.
    }
        return new Builder();
    }
    }
        public Builder clusterSettings(ClusterSettings clusterSettings) {
        if (filePaths == null || filePaths.isEmpty()) return;
     *
     * Returns true if the loaded native library can update the spill cap at runtime.
    public void onFilesAdded(Collection<String> filePaths) {
            this.clusterSettings = clusterSettings;
         * Sets the directory for spill files.
                cacheHandle.close();
        NativeCacheManagerHandle cacheHandle = null;
     */
    }
        return new DataFusionStats(
            nativeStats.getAdaptiveBudgetStats(),
         * @param bytes spill limit
     */
        if (clusterSettings != null) {
 * Node-level service managing the DataFusion native runtime lifecycle.
     */
    public boolean isSpillLimitDynamic() {
         */
    private static final Logger logger = LogManager.getLogger(DataFusionService.class);
        }
    }
    /** Handle to the native DataFusion global runtime (memory pool + cache). */
    /** Returns [usage_bytes, tripped_count] from the native memory pool. Single FFM call. */
    }
    public void onFilesDeleted(Collection<String> filePaths) {
     * Mirrors the dynamic {@code datafusion.spill_memory_limit_bytes} setting and the
            return this;
        long cacheManagerPtr = 0L;
    }
            runtimeHandle = null;
        }
     * Sets the spill memory limit at runtime. Requires {@link #isSpillLimitDynamic()};
        logger.debug("DataFusion service started — memory pool {}B, spill limit {}B", memoryPoolLimit, spillMemoryLimit);
            nativeStats.getFragmentExecutorGateStats(),
 * SPDX-License-Identifier: Apache-2.0
    /** Cache manager for pre-warming and managing native caches. */
     * @param filePaths absolute paths of the files to warm
    /**
        return Runtime.getRuntime().availableProcessors();
         * Sets the maximum bytes for the DataFusion memory pool.
    private final double datanodeMultiplier;
        this.spillMemoryLimit = newLimitBytes;
        return spillMemoryLimit;
    /**
            return this;
    public static class Builder {
    public long getSpillMemoryLimit() {
     * mirror used by {@link #buildSpillStats()} so {@code spill.disk_reserved_bytes}
        if (clusterSettings != null) {
        if (filePaths == null || filePaths.isEmpty()) return;
    /**
    /**
    private final double coordinatorMultiplier;
            nativeStats.getNativeExecutorsStats(),
            if (cacheHandle != null) {
            return this;
        }
        return spillDirectory;
            return this;
    }
        return SpillStatsCollector.collect(spillDirectory, spillMemoryLimit);
        private int cpuThreads = Runtime.getRuntime().availableProcessors();
    }
    }
    /**
    }
            throw new IllegalStateException("DataFusionService has not been started");
            this.runtimeHandle = new NativeRuntimeHandle(ptr);
     * Surfaced for the {@code spill.disk_reserved_bytes} stat.
            cacheHandle = CacheUtils.createCacheConfig(clusterSettings);
    @Override
     * native runtime's spill cap. Updated by {@link #setSpillMemoryLimit(long)}; surfaced
    private DataFusionService(Builder builder) {
        public Builder spillDirectory(String path) {
        this.cpuThreads = builder.cpuThreads;
     * Warmup files through the TieredObjectStore — reads metadata via the store
    protected void doStart() {
    private final long memoryPoolLimit;
     * reflects the new value on the next stats read.
        this.coordinatorMultiplier = builder.coordinatorMultiplier;
 * <p>
     * When false, {@link #setSpillMemoryLimit(long)} will throw and cluster-state
     * This is the value used to compute concurrency gate permit counts (cpu_threads × multiplier).
    private final int cpuThreads;
        return NativeBridge.getMemoryPoolUsage(getNativeRuntime().get());
     * @return the current {@link DataFusionStats}
    }
        public Builder cpuThreads(int threads) {
        DataFusionStats nativeStats = NativeBridge.stats(runtimeHandle.get());
            "Tokio runtime manager initialized with {} CPU threads, datanode multiplier {}, coordinator multiplier {}",
    /**
            throw e;
            if (cacheHandle != null) {
        }
    }
            NativeBridge.cacheManagerAddFiles(runtimeHandle.get(), filePaths.toArray(new String[0]));
        try {
     */
            releaseRuntime();
    public static Builder builder() {
        /**
     * means spill is disabled (DataFusion built with {@code DiskManagerMode::Disabled}).
        this.spillMemoryLimit = builder.spillMemoryLimit;
         * @param path spill directory
 * The OpenSearch Contributors require contributions made to
     * Sets the memory pool limit at runtime. Takes effect for new allocations only.
     */
     * {@code DataFusionPlugin.updateMemoryPoolLimit}; this method is silent to avoid
    @Override
     *
        logger.debug("DataFusion service stopped");
         */
         * @param threads CPU thread count
         */
     */
        private String spillDirectory = System.getProperty("java.io.tmpdir");
     * (populating Foyer caches) and puts into heap cache. For warm nodes where
            this.datanodeMultiplier = multiplier;
            this.cacheManager = new CacheManager(runtimeHandle);
            NativeBridge.cacheManagerAddFilesWithStore(runtimeHandle.get(), storeBoxPtr, filePaths.toArray(new String[0]));
    }
        public Builder spillMemoryLimit(long bytes) {
    }
import org.opensearch.be.datafusion.stats.DataFusionStats;
     * Returns the cache manager, or null if caching is not configured.
     * <p>
     * configured spill memory limit. Package-private so unit tests can verify the wiring
     * Builder for {@link DataFusionService}.
        if (runtimeHandle == null) {
            cacheManagerPtr = cacheHandle.getPointer();
        /** Sets the coordinator concurrency gate multiplier. */
        }
    SpillStats buildSpillStats() {
        public Builder datanodeMultiplier(double multiplier) {
            cpuThreads,
        try {
        NativeBridge.setMemoryPoolLimit(getNativeRuntime().get(), newLimitBytes);
    /**
        logger.debug("Starting DataFusion service");
         * @param clusterSettings the cluster settings
     * without starting the native runtime.
        this.memoryPoolLimit = builder.memoryPoolLimit;
    public CacheManager getCacheManager() {
        try {
        SpillStats spill = buildSpillStats();
            return this;
        /** Sets the datanode concurrency gate multiplier. */
            handle.close();
 * Initializes the Tokio runtime manager (dedicated CPU + IO thread pools)
/**
public class DataFusionService extends AbstractLifecycleComponent {
        }
            this.memoryPoolLimit = bytes;
        /**
     */
import java.io.IOException;
        } catch (Exception e) {
            logger.warn("Failed to register new files with native cache", e);
     */
     * otherwise throws {@link UnsupportedOperationException}. Also updates the Java-side
    private volatile CacheManager cacheManager;
 *
    public long[] getMemoryPoolStats() {
 */
     *
    /**
        return NativeBridge.getMemoryPoolLimit(getNativeRuntime().get());
    protected void doClose() throws IOException {
    }
    public void setMemoryPoolLimit(long newLimitBytes) {
        }
        } catch (Exception e) {
