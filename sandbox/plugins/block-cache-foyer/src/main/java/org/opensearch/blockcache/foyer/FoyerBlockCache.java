        long metaSubmitQueueSizeBytes,  
            dataBlockSizeBytes,
            return FoyerBridge.clearCache(cachePtr);  
    /**  
        if (closed.get() == false) {  
        if (bufferPoolSizeBytes <= 0) {
     * Snapshots cache statistics via FFM call to the native Foyer runtime.
        this.cachePtr = FoyerBridge.createTieredCache(
        long persistIntervalSecs
     * @param metaBlockSizeBytes        metadata cache block size  
        }  
    private static final Logger logger = LogManager.getLogger(FoyerBlockCache.class);
    public void close() {  
import java.util.Objects;  
            data.evictions(),  
            throw new IllegalArgumentException("submitQueueSizeThresholdBytes must be > 0, got: " + submitQueueSizeThresholdBytes);  
            data.diskBytesUsed(),
            FoyerBridge.evictPrefix(cachePtr, prefix);
        }
        );
        long dataDiskBytes,  
    }
     *                               Maps to {@code block_cache.foyer.key_index_persist_interval_seconds}.  
        long[] raw = FoyerBridge.snapshotStats(cachePtr);
     * @param persistIntervalSecs       persist interval; 0 = disabled  
     * @param dataDiskDir               directory for data cache  
import org.apache.logging.log4j.Logger;
     * @param sweepThresholdRatio    minimum {@code used_bytes / disk_bytes} ratio to run the sweep;
        }
            persistIntervalSecs
     * <p>In single-cache mode: section 0 = overall, section 1 = block-level (identical).
            bufferPoolSizeBytes,
    }
     * @param dataDiskBytes             data cache disk capacity
            meta.hits(),
        BlockCacheStats meta = s.metadataCacheStats();  
            FoyerBridge.destroyCache(cachePtr);
        Objects.requireNonNull(dataDiskDir, "dataDiskDir must not be null");  
    /** Metadata cache capacity in tiered mode. 0 in single-cache mode. */  
    /** Guards against double-close per the {@link AutoCloseable} contract. */  
            data.activeInBytes(),  
        if (tiered) {  
     *
    private final boolean tiered;
        }
     */
    ) {  
     * owns the cache and destroys it via {@code foyer_destroy_cache} in {@link #close()} —  
     */
        if (sweepIntervalSecs < 0) {  
     * @return a borrowed handle; never {@code null}, always {@link NativeStoreHandle#isLive()}  
     * Destroys the native cache. Idempotent — safe to call multiple times.  
        if (sweepThresholdRatio < 0.0 || sweepThresholdRatio > 1.0) {  
            meta.misses(),
        long diskBytes,  
            throw new IllegalArgumentException("metaDiskBytes must be > 0, got: " + metaDiskBytes);
        }
    }
            throw new IllegalArgumentException("dataDiskBytes must be > 0, got: " + dataDiskBytes);
        if (dataDiskBytes <= 0) {  
     * @param dataBlockSizeBytes        data cache block size
        this.tiered = false;  
        }  
        long dataSubmitQueueSizeBytes,
        String dataDiskDir,
import java.util.concurrent.atomic.AtomicBoolean;
     * @param dataSubmitQueueSizeBytes  data cache submit queue threshold  
    @Override
        long sweepIntervalSecs,
 * SPDX-License-Identifier: Apache-2.0
     * Returns a borrowed, non-owning {@link NativeStoreHandle} for this Foyer cache.
        long dataBufferPoolSizeBytes,  
            throw new IllegalArgumentException("diskDir must not be blank");  
            meta.totalBytes(),
    }
     * In tiered mode: section 0 = data cache, section 1 = metadata cache,
        );
    }
        String ioEngine,
    public FoyerBlockCache(
 * Foyer-backed implementation of {@link BlockCache}.
     * but does nothing. The raw fat pointer created by {@code foyer_create_cache} is valid for
        }
            data.misses(),  
 *
            diskDir,  
            throw new IllegalArgumentException("bufferPoolSizeBytes must be > 0, got: " + bufferPoolSizeBytes);  
            meta.removed(),
 * this file be licensed under the Apache-2.0 license or a
        this.tiered = true;  
    }  
            data.hits(),
 * compatible open source license.
     * @throws NullPointerException     if {@code diskDir} or {@code ioEngine} is null
    }  
     * @param metaDiskBytes             metadata cache disk capacity
    @Override
            dataSubmitQueueSizeBytes,  
        if (diskBytes <= 0) {
    /**  
            throw new IllegalArgumentException("diskBytes must be > 0, got: " + diskBytes);
     * In tiered mode, this is the merged (data + metadata) view.  
        }
            meta.activeInBytes()
     *                               Maps to {@code block_cache.foyer.key_index_sweep_threshold}.  
        if (tiered == false) {
            data.totalBytes(),
     * @return stats snapshot; never {@code null}
     * @param metaDiskDir               directory for metadata cache
            sweepIntervalSecs,
            FoyerBridge.updateSweepInterval(cachePtr, newSecs);
        long blockSizeBytes,
import org.opensearch.plugins.BlockCacheTieredStats;  
            dataDiskDir,  
        this.metadataDiskBytes = 0L;
     *
    /** The configured disk capacity in bytes */  
    public FoyerBlockCache(
     *                                  {@code sweepThresholdRatio} outside {@code [0.0, 1.0]},  
    public void updateSweepInterval(long newSecs) {
     * {@code overallStats()} returns merged counters.  
            meta.evictionBytes(),  
        return new NativeStoreHandle(cachePtr, ptr -> {});
        if (diskDir.isBlank()) {
    private final AtomicBoolean closed = new AtomicBoolean(false);
        if (closed.get() == false) {  
 */  
            metaBufferPoolSizeBytes,
        }
    private final long diskBytes;
            sweepThresholdRatio,  
     *                               key_index to disk; {@code 0} = disabled (only {@code Drop} persists).
            sweepIntervalSecs,
     * the entire lifetime of this {@code FoyerBlockCache} instance. {@code FoyerBlockCache}
    public BlockCacheTieredStats tieredStats() {  
            ioEngine,  
     *                                  or {@code diskDir} is blank
    }
     *
    }  
     * @param dataBufferPoolSizeBytes   data cache buffer pool
    /**
     * Create a tiered Foyer cache with separate data and metadata SSDs.  
    }  
        BlockCacheStats data = s.dataCacheStats();
        }
        long metaBufferPoolSizeBytes,
        String metaDiskDir,  
        Objects.requireNonNull(metaDiskDir, "metaDiskDir must not be null");
            FoyerBridge.updateSweepThreshold(cachePtr, newRatio);
        return tiered;
package org.opensearch.blockcache.foyer;
            throw new IllegalArgumentException("sweepIntervalSecs must be >= 0, got: " + sweepIntervalSecs);
 */
            return null;
        return foyerStats().overallStats();
            data.removed(),
     *
     * @throws IllegalStateException    if the native call fails to return a valid handle  
     * <p>The handle uses a no-op destructor — calling {@link NativeStoreHandle#close()} is safe  
     * @param persistIntervalSecs    how often (seconds) the independent persist task flushes the
    public boolean isTiered() {
            dataDiskBytes,
 * The OpenSearch Contributors require contributions made to  
    private final long cachePtr;
            ioEngine,
        if (persistIntervalSecs < 0) {  
    @Override
        // No-op destructor: this is a borrowed reference — FoyerBlockCache owns the lifecycle.
            data.hitBytes(),
        if (closed.get() == false && cachePtr > 0) {
     *                                  {@code sweepIntervalSecs < 0}, {@code persistIntervalSecs < 0},
            metaDiskDir,
        }
            blockSizeBytes,
     * @param metaBufferPoolSizeBytes   metadata cache buffer pool
    public String cacheName() {
        Objects.requireNonNull(diskDir, "diskDir must not be null");
        return new BlockCacheTieredStats(
    @Override  
        long sweepIntervalSecs,  
/**  
        long metaBlockSizeBytes,
            meta.missBytes(),
    /** Opaque {@code Box<Arc<dyn BlockCache>>} fat pointer returned by {@code foyer_create_cache}. Always positive. */  
        }  
            sweepThresholdRatio,
public final class FoyerBlockCache implements BlockCache {
     * @param diskDir                directory where Foyer stores cache data; must not be null or blank
        }
        this.dataDiskBytes = 0L;
        if (closed.get() == false) {  
            return FoyerAggregatedStats.snapshotTiered(raw, dataDiskBytes, metadataDiskBytes);
    /**
        this.dataDiskBytes = dataDiskBytes;
        }
import org.opensearch.plugins.BlockCacheConstants;
            meta.removedBytes(),
            data.removedBytes(),  
     * @param sweepIntervalSecs      background key_index sweep interval in seconds;
        double sweepThresholdRatio,  
    public void updatePersistInterval(long newSecs) {
        double sweepThresholdRatio,
        }
        this.cachePtr = FoyerBridge.createCache(
            meta.hitBytes(),  
     */
        long dataBlockSizeBytes,
     * @param metaSubmitQueueSizeBytes  metadata cache submit queue threshold
     * @param ioEngine               I/O engine: {@code "auto"}, {@code "io_uring"}, or {@code "psync"}  
        if (metaDiskBytes <= 0) {  
        if (closed.get() == false) {
    /**
     * Snapshots the full Foyer stats from the native runtime.
    }  
            persistIntervalSecs  
     */
    @Override
        return BlockCacheConstants.FOYER;  
}  
     * @param sweepIntervalSecs         sweep interval; 0 = disabled
        this.diskBytes = diskBytes;  
    /** Whether this is a tiered cache (data + metadata on separate SSDs). */  
     * @param sweepThresholdRatio       sweep threshold; 0.0 = always
            logger.info("FoyerBlockCache closed");  
     * Returns the cross-tier rollup {@link BlockCacheStats} for core consumption.
            FoyerBridge.updatePersistInterval(cachePtr, newSecs);
    /** Whether this instance is a tiered cache (data + metadata on separate SSDs). */  
        Objects.requireNonNull(ioEngine, "ioEngine must not be null");
            meta.diskBytesUsed(),  
            diskBytes,
            data.evictionBytes(),
     *                               Maps to {@code block_cache.foyer.key_index_sweep_interval_seconds}.  
        return false;
import org.opensearch.plugins.BlockCache;  
     *                               {@code 0} = disabled (no background sweep task is spawned).
     *  
            metaDiskBytes,
        return FoyerAggregatedStats.snapshot(raw, diskBytes);  
        this.diskBytes = dataDiskBytes + metaDiskBytes;  
        }
    }
            dataBufferPoolSizeBytes,
import org.opensearch.plugins.NativeStoreHandle;
/*  
        String diskDir,
     */
     *                               {@code 0.0} = disabled (always sweep).
     * callers must never free the pointer directly.
            data.missBytes(),
    ) {
            metaSubmitQueueSizeBytes,
    public void evictPrefix(String prefix) {  
    public FoyerAggregatedStats foyerStats() {
        this.metadataDiskBytes = metaDiskBytes;
     * Create the native Foyer cache and acquire its handle.
            throw new IllegalArgumentException("sweepThresholdRatio must be in [0.0, 1.0], got: " + sweepThresholdRatio);
    /**  
     * @param blockSizeBytes         Foyer disk block size in bytes; must be {@code > 0}
        long submitQueueSizeThresholdBytes,
        }
            throw new IllegalArgumentException("blockSizeBytes must be > 0, got: " + blockSizeBytes);  
    private final long metadataDiskBytes;
    @Override
    }  
 * @opensearch.experimental  
        String ioEngine,
     *
        );  
        Objects.requireNonNull(ioEngine, "ioEngine must not be null");
    }  
            meta.evictions(),
     * @param ioEngine                  I/O engine for both caches  
    @Override
    public void updateSweepThreshold(double newRatio) {
        long persistIntervalSecs
    /** Data cache capacity in tiered mode. 0 in single-cache mode. */  
import org.opensearch.plugins.BlockCacheStats;
        if (submitQueueSizeThresholdBytes <= 0) {
            metaBlockSizeBytes,  
import org.apache.logging.log4j.LogManager;
    public boolean clear() {
            throw new IllegalArgumentException("persistIntervalSecs must be >= 0, got: " + persistIntervalSecs);
        FoyerAggregatedStats s = foyerStats();
 *
     * @throws IllegalArgumentException if {@code diskBytes <= 0}, {@code blockSizeBytes <= 0},
        if (blockSizeBytes <= 0) {
    public BlockCacheStats stats() {  
     * @param diskBytes              maximum disk capacity in bytes; must be {@code > 0}  
     */  
    public NativeStoreHandle nativeCacheHandle() {  
            submitQueueSizeThresholdBytes,  
        }
        long metaDiskBytes,
        if (closed.compareAndSet(false, true)) {
        long bufferPoolSizeBytes,  
    private final long dataDiskBytes;
