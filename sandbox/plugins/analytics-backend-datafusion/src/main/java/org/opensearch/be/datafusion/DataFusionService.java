            return this;  
     * Returns the cache manager, or null if caching is not configured.  
        this.coordinatorMultiplier = builder.coordinatorMultiplier;
    @Override
            nativeStats.getAdaptiveBudgetStats(),  
    }
        return NativeBridge.getMemoryPoolUsage(getNativeRuntime().get());
            return this;  
    /**
    public void setMemoryPoolLimit(long newLimitBytes) {  
    private final double coordinatorMultiplier;
            this.cpuThreads = threads;
     * mirror used by {@link #buildSpillStats()} so {@code spill.disk_reserved_bytes}
 *
        }
    /** Handle to the native DataFusion global runtime (memory pool + cache). */
     * (populating Foyer caches) and puts into heap cache. For warm nodes where  
     */
     * When false, {@link #setSpillMemoryLimit(long)} will throw and cluster-state  
     */  
        if (filePaths == null || filePaths.isEmpty()) return;
        try {  
    }
        public Builder spillMemoryLimit(long bytes) {
    /**
    protected void doClose() throws IOException {  
    public void onFilesAddedWithStore(Collection<String> filePaths, long storeBoxPtr) {  
    /**  
            logger.warn("Failed to register new files with native cache", e);  
    /** Creates a new builder. */
            NativeBridge.cacheManagerRemoveFiles(runtimeHandle.get(), filePaths.toArray(new String[0]));
     * Sets the memory pool limit at runtime. Takes effect for new allocations only.
         */  
        }
    public DataFusionStats getStats() {  
     */  
    }
     */
    }
    public long getMemoryPoolLimit() {
     * otherwise throws {@link UnsupportedOperationException}. Also updates the Java-side  
import org.opensearch.be.datafusion.cache.CacheUtils;
        if (clusterSettings != null) {
        if (filePaths == null || filePaths.isEmpty()) return;
     */
        );  
            datanodeMultiplier,
         */  
     * <p>
    /**
        } catch (Exception e) {  
    /**  
        public Builder coordinatorMultiplier(double multiplier) {
import org.opensearch.common.settings.ClusterSettings;
        this.spillDirectory = builder.spillDirectory;
 */  
    }
     */  
 * <p>
    }
 * <p>  
    protected void doStart() {
        }
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
/*  
    }
     */  
        private double coordinatorMultiplier = 1.0;
        NativeRuntimeHandle handle = runtimeHandle;
 * Node-level service managing the DataFusion native runtime lifecycle.
     */  
            spill,
        public Builder clusterSettings(ClusterSettings clusterSettings) {
            this.clusterSettings = clusterSettings;
     * duplicate log entries.
            nativeStats.getNativeExecutorsStats(),
         * Sets the number of CPU threads for the dedicated executor.
        this.clusterSettings = builder.clusterSettings;
            return this;  
    public static class Builder {
         */  
    /**
     * @param filePaths absolute paths of the new files
     */
    private final int cpuThreads;
            throw new IllegalStateException("DataFusionService has not been started");
    private static final Logger logger = LogManager.getLogger(DataFusionService.class);  
    /**
import org.opensearch.be.datafusion.cache.NativeCacheManagerHandle;
        } catch (Exception e) {
    public long getSpillMemoryLimit() {  
     * files are on S3, this routes through the registry to remote storage.
            runtimeHandle = null;
     * updates of {@code datafusion.spill_memory_limit_bytes} have no live effect.
     * @return the current {@link DataFusionStats}
                cacheHandle.close();
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        }
 * SPDX-License-Identifier: Apache-2.0
     * This is the value used to compute concurrency gate permit counts (cpu_threads × multiplier).  
     */
import org.opensearch.be.datafusion.stats.SpillStats;
 * compatible open source license.
    @Override  
        try {
            logger.warn("Failed to evict deleted files from native cache", e);  
package org.opensearch.be.datafusion;
        public Builder cpuThreads(int threads) {
import org.apache.logging.log4j.LogManager;
        }  
            this.coordinatorMultiplier = multiplier;
        return NativeBridge.getMemoryPoolLimit(getNativeRuntime().get());
            coordinatorMultiplier
         * Sets the directory for spill files.
     * reflects the new value on the next stats read.
        logger.debug("Stopping DataFusion service");
            cpuThreads,  
     * Sets the spill memory limit at runtime. Requires {@link #isSpillLimitDynamic()};
 * and the DataFusion global runtime (memory pool, disk spill, cache).
        }
        NativeBridge.shutdownTokioRuntimeManager();
        } finally {
    /**  
        return NativeBridge.isSpillLimitDynamic();
        return spillDirectory;
    public static int cpuThreadCount() {
        return handle;  
        try {  
     * Builder for {@link DataFusionService}.
            return this;  
            this.runtimeHandle = new NativeRuntimeHandle(ptr);
     */
    }
    }
        }  
            this.spillMemoryLimit = bytes;
        private long memoryPoolLimit = Runtime.getRuntime().maxMemory() / 4;
     * The user-visible info-level log line is emitted by the caller in
        public DataFusionService build() {
        }
     * Warmup files through the TieredObjectStore — reads metadata via the store
     */
    }
        public Builder memoryPoolLimit(long bytes) {
    /**  
            logger.warn("Failed to warmup files with store", e);
        public Builder spillDirectory(String path) {
    private final long memoryPoolLimit;
     *
            releaseRuntime();  
    }  
    public void onFilesDeleted(Collection<String> filePaths) {
     * Existing reservations that exceed the new limit are NOT reclaimed.  
        try {
     * @throws IllegalStateException if the service has not been started
        if (handle == null) {  
    }
    /**
    /**  
            throw new IllegalStateException("DataFusionService has not been started");
    public long getMemoryPoolUsage() {  
            logger.debug("DataFusion native runtime released");  
        /** Sets the datanode concurrency gate multiplier. */  
    private volatile long spillMemoryLimit;  
        }
            "Tokio runtime manager initialized with {} CPU threads, datanode multiplier {}, coordinator multiplier {}",
        logger.debug("DataFusion service stopped");
        );
        /**  
        return new Builder();
            throw e;
    private void releaseRuntime() {
    private final ClusterSettings clusterSettings;
     * as {@code spill.disk_reserved_bytes} via {@link #buildSpillStats()}. Volatile so  
    private final String spillDirectory;
     *  
        NativeRuntimeHandle handle = runtimeHandle;
     * stats readers see updates from the cluster-settings consumer thread without locking.
        logger.debug("DataFusion service started — memory pool {}B, spill limit {}B", memoryPoolLimit, spillMemoryLimit);
import org.opensearch.be.datafusion.cache.CacheManager;  
        return new DataFusionStats(  
        private double datanodeMultiplier = 1.0;  
     * {@code DataFusionPlugin.updateMemoryPoolLimit}; this method is silent to avoid  
}
     *
        DataFusionStats nativeStats = NativeBridge.stats(runtimeHandle.get());
        this.spillMemoryLimit = newLimitBytes;  
     * @param storeBoxPtr Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer from TieredStorageBridge.getObjectStoreBoxPtr
    }  
        return NativeBridge.getMemoryPoolStats(getNativeRuntime().get());
         */  
        private Builder() {}
        }
        private String spillDirectory = System.getProperty("java.io.tmpdir");
        }  
            this.memoryPoolLimit = bytes;
    /**
            cacheManagerPtr = cacheHandle.getPointer();  
     * Notifies the native cache that new files are available for caching.
            nativeStats.getFragmentExecutorGateStats(),
        long cacheManagerPtr = 0L;
    public long[] getMemoryPoolStats() {  
        /**  
import org.opensearch.be.datafusion.stats.SpillStatsCollector;  
    public static Builder builder() {  
import org.opensearch.be.datafusion.stats.DataFusionStats;
     * means spill is disabled (DataFusion built with {@code DiskManagerMode::Disabled}).
     * @param filePaths absolute paths of the deleted files
        logger.debug(
            this.datanodeMultiplier = multiplier;
    public void setSpillMemoryLimit(long newLimitBytes) {
            NativeBridge.cacheManagerAddFilesWithStore(runtimeHandle.get(), storeBoxPtr, filePaths.toArray(new String[0]));  
        /**  
            if (cacheHandle != null) {
     * native runtime's spill cap. Updated by {@link #setSpillMemoryLimit(long)}; surfaced
            if (cacheHandle != null) {
            return this;  
        NativeBridge.setMemoryPoolLimit(getNativeRuntime().get(), newLimitBytes);
     * configured spill memory limit. Package-private so unit tests can verify the wiring  
        }
     * Builds a {@link SpillStats} snapshot from the configured spill directory and the
    public String getSpillDirectory() {
        return spillMemoryLimit;
        } catch (Exception e) {
     * Returns the current memory pool usage in bytes.
     * Notifies the native cache that files have been deleted and should be evicted.
    private volatile NativeRuntimeHandle runtimeHandle;
    }
        this.spillMemoryLimit = builder.spillMemoryLimit;  
    }
        if (handle != null) {  
         * Sets the cluster settings for cache configuration.
        private ClusterSettings clusterSettings;
            nativeStats.getCacheStats(),
    /** Cache manager for pre-warming and managing native caches. */
     * Returns true if the loaded native library can update the spill cap at runtime.
    public NativeRuntimeHandle getNativeRuntime() {
         * @param path spill directory
        /** Builds the {@link DataFusionService}. */  
    @Override
        }
        /** Sets the coordinator concurrency gate multiplier. */  
        this.memoryPoolLimit = builder.memoryPoolLimit;
        private int cpuThreads = Runtime.getRuntime().availableProcessors();
    // Cache management (node-level, delegates to native runtime)  
        return Runtime.getRuntime().availableProcessors();  
    private final double datanodeMultiplier;  
        return SpillStatsCollector.collect(spillDirectory, spillMemoryLimit);
        logger.debug("Starting DataFusion service");
/**
         * Sets the maximum bytes for the DataFusion memory pool.
    /**
        }  
         * @param threads CPU thread count
     * Returns the current memory pool limit in bytes.
            }
     */
     * Returns the spill memory limit (in bytes) this service was configured with.  
    }
        if (runtimeHandle == null) {
    }  
        private long spillMemoryLimit = Runtime.getRuntime().maxMemory() / 8;  
        }
 * All per-query {@link DatafusionSearchExecEngine} instances share these resources.  
            return this;  
        SpillStats spill = buildSpillStats();
        }  
    SpillStats buildSpillStats() {  
         * Sets the maximum bytes before spilling to disk.
    /**
        NativeBridge.initTokioRuntimeManager(cpuThreads, datanodeMultiplier, coordinatorMultiplier);  
     */
            this.spillDirectory = path;
    }
    }  
    /**
import org.apache.logging.log4j.Logger;
 * The OpenSearch Contributors require contributions made to  
    /** Returns [usage_bytes, tripped_count] from the native memory pool. Single FFM call. */
 * Initializes the Tokio runtime manager (dedicated CPU + IO thread pools)
    }  
 * Use {@link #builder()} to construct.
 */  
    public boolean isSpillLimitDynamic() {  
            cacheHandle = CacheUtils.createCacheConfig(clusterSettings);
public class DataFusionService extends AbstractLifecycleComponent {
        return cacheManager;  
         * @param clusterSettings the cluster settings
     * @param filePaths absolute paths of the files to warm  
            this.cacheManager = new CacheManager(runtimeHandle);
         */  
 * this file be licensed under the Apache-2.0 license or a
         * @param bytes spill limit
        if (clusterSettings != null) {
     */  
            }  
    /**
     * Returns the number of available CPU threads used for the dedicated executor.
        public Builder datanodeMultiplier(double multiplier) {
            nativeStats.getSearchStats()  
        }
     * without starting the native runtime.
        /**  
            return new DataFusionService(this);
     * Mirrors the dynamic {@code datafusion.spill_memory_limit_bytes} setting and the
        }
    private volatile CacheManager cacheManager;
    }  
    /**
     */  
     * Returns the latest native executor stats, collected fresh from JNI on every call.
        this.datanodeMultiplier = builder.datanodeMultiplier;  
            return this;  
        releaseRuntime();
        } catch (Exception e) {
    protected void doStop() {  
        if (filePaths == null || filePaths.isEmpty()) return;
         * @param bytes memory limit
        NativeCacheManagerHandle cacheHandle = null;  
    }
        this.cpuThreads = builder.cpuThreads;
     * Returns the handle to the native DataFusion global runtime.  
        try {  
import java.util.Collection;
import java.io.IOException;
    }
            NativeBridge.cacheManagerAddFiles(runtimeHandle.get(), filePaths.toArray(new String[0]));
            long ptr = NativeBridge.createGlobalRuntime(memoryPoolLimit, cacheManagerPtr, spillDirectory, spillMemoryLimit);
    private DataFusionService(Builder builder) {
            handle.close();
                cacheHandle.markConsumed();  
    public void onFilesAdded(Collection<String> filePaths) {
    public CacheManager getCacheManager() {
        /**  
            NativeBridge.shutdownTokioRuntimeManager();
     * Surfaced for the {@code spill.disk_reserved_bytes} stat.
     */
     * Returns the spill directory this service was configured with. Empty string
        NativeBridge.setSpillLimit(getNativeRuntime().get(), newLimitBytes);
