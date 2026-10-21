            throw new IllegalArgumentException("sweepThresholdRatio must be in [0.0, 1.0], got: " + sweepThresholdRatio);
        this.tiered = true;
            meta.removed(),
            FoyerBridge.updatePersistInterval(cachePtr, newSecs);
 * SPDX-License-Identifier: Apache-2.0
     * @param sweepThresholdRatio       sweep threshold; 0.0 = always
            dataBufferPoolSizeBytes,
        Objects.requireNonNull(metaDiskDir, "metaDiskDir must not be null");
    @Override
            metaBufferPoolSizeBytes,
    /** Data cache capacity in tiered mode. 0 in single-cache mode. */
            data.activeInBytes(),
        );
     * @param persistIntervalSecs    how often (seconds) the independent persist task flushes the
     *                                  {@code sweepThresholdRatio} outside {@code [0.0, 1.0]},
        if (dataDiskBytes <= 0) {
            FoyerBridge.updateSweepInterval(cachePtr, newSecs);
        return new NativeStoreHandle(cachePtr, ptr -> {});
            throw new IllegalArgumentException("diskDir must not be blank");
     * @param sweepIntervalSecs      background key_index sweep interval in seconds;
            diskBytes,
     * @throws IllegalStateException    if the native call fails to return a valid handle
        long metaBufferPoolSizeBytes,
     * callers must never free the pointer directly.
    public boolean isTiered() {
     * Snapshots the full Foyer stats from the native runtime.
    public void updatePersistInterval(long newSecs) {
     * @return a borrowed handle; never {@code null}, always {@link NativeStoreHandle#isLive()}
     * @param diskDir                directory where Foyer stores cache data; must not be null or blank
    private final long diskBytes;
        long sweepIntervalSecs,
            meta.missBytes(),
 * compatible open source license.
        if (persistIntervalSecs < 0) {
            meta.removedBytes(),
    public void updateSweepThreshold(double newRatio) {
            submitQueueSizeThresholdBytes,
     * @param metaBufferPoolSizeBytes   metadata cache buffer pool
            meta.hitBytes(),
    }
     * @param metaDiskBytes             metadata cache disk capacity
     *                               Maps to {@code block_cache.foyer.key_index_sweep_threshold}.
        long dataBlockSizeBytes,
    private final long cachePtr;
    @Override
        if (bufferPoolSizeBytes <= 0) {
            meta.hits(),
            dataBlockSizeBytes,
    }
        }
    }
}
            meta.misses(),
    /**
     * <p>The handle uses a no-op destructor — calling {@link NativeStoreHandle#close()} is safe
        if (diskDir.isBlank()) {
        this.diskBytes = dataDiskBytes + metaDiskBytes;
        if (closed.get() == false) {
     *                               Maps to {@code block_cache.foyer.key_index_sweep_interval_seconds}.
 * Foyer-backed implementation of {@link BlockCache}.
    ) {
        }
            data.removed(),
     */
    public FoyerBlockCache(
        long blockSizeBytes,
        this.cachePtr = FoyerBridge.createCache(
            throw new IllegalArgumentException("bufferPoolSizeBytes must be > 0, got: " + bufferPoolSizeBytes);
            blockSizeBytes,
        long dataSubmitQueueSizeBytes,
import java.util.concurrent.atomic.AtomicBoolean;
    @Override
    ) {
    }
     *
import org.apache.logging.log4j.LogManager;
        if (closed.get() == false) {
        this.cachePtr = FoyerBridge.createTieredCache(
        return new BlockCacheTieredStats(
            sweepThresholdRatio,
     * @param dataDiskDir               directory for data cache
        }
     *
            return FoyerBridge.clearCache(cachePtr);
            data.missBytes(),
        this.dataDiskBytes = dataDiskBytes;
            ioEngine,
        String diskDir,
     * In tiered mode, this is the merged (data + metadata) view.
            data.diskBytesUsed(),
            data.misses(),
        BlockCacheStats data = s.dataCacheStats();
    }
        this.diskBytes = diskBytes;
     *                               {@code 0.0} = disabled (always sweep).
     * Snapshots cache statistics via FFM call to the native Foyer runtime.
            logger.info("FoyerBlockCache closed");
        if (sweepThresholdRatio < 0.0 || sweepThresholdRatio > 1.0) {
    /**
     */
        return FoyerAggregatedStats.snapshot(raw, diskBytes);
 * @opensearch.experimental
    private final long dataDiskBytes;
        }
            throw new IllegalArgumentException("submitQueueSizeThresholdBytes must be > 0, got: " + submitQueueSizeThresholdBytes);
            data.hits(),
        if (tiered == false) {
import org.opensearch.plugins.BlockCacheStats;
     * @param dataBufferPoolSizeBytes   data cache buffer pool
     * Returns a borrowed, non-owning {@link NativeStoreHandle} for this Foyer cache.
        );
     *                               key_index to disk; {@code 0} = disabled (only {@code Drop} persists).
        if (diskBytes <= 0) {
        double sweepThresholdRatio,
import java.util.Objects;
            FoyerBridge.destroyCache(cachePtr);
     * @param dataSubmitQueueSizeBytes  data cache submit queue threshold
        double sweepThresholdRatio,
        long[] raw = FoyerBridge.snapshotStats(cachePtr);
        long metaDiskBytes,
import org.opensearch.plugins.NativeStoreHandle;
    }
    }
        if (blockSizeBytes <= 0) {
    private final boolean tiered;
            data.hitBytes(),
    private static final Logger logger = LogManager.getLogger(FoyerBlockCache.class);
            data.evictionBytes(),
import org.opensearch.plugins.BlockCacheConstants;
    @Override
     * @param diskBytes              maximum disk capacity in bytes; must be {@code > 0}
            dataDiskDir,
 *
            sweepIntervalSecs,
        FoyerAggregatedStats s = foyerStats();
    public BlockCacheTieredStats tieredStats() {
            ioEngine,
            meta.totalBytes(),
        }
     * @param dataDiskBytes             data cache disk capacity
    }
            meta.diskBytesUsed(),
    /** Metadata cache capacity in tiered mode. 0 in single-cache mode. */
     * @param blockSizeBytes         Foyer disk block size in bytes; must be {@code > 0}
            throw new IllegalArgumentException("dataDiskBytes must be > 0, got: " + dataDiskBytes);
     * Create the native Foyer cache and acquire its handle.
            persistIntervalSecs
    }
            data.removedBytes(),
        if (metaDiskBytes <= 0) {
import org.opensearch.plugins.BlockCacheTieredStats;
 * The OpenSearch Contributors require contributions made to
            return null;
        long dataBufferPoolSizeBytes,
     * @param metaSubmitQueueSizeBytes  metadata cache submit queue threshold
        String metaDiskDir,
        return BlockCacheConstants.FOYER;
        String ioEngine,
     *                               Maps to {@code block_cache.foyer.key_index_persist_interval_seconds}.
/**
import org.apache.logging.log4j.Logger;
    /**
            throw new IllegalArgumentException("diskBytes must be > 0, got: " + diskBytes);
        long bufferPoolSizeBytes,
        long diskBytes,
            dataDiskBytes,
            persistIntervalSecs
     */
    }
        long persistIntervalSecs
     */
     *
    public void close() {
        if (closed.compareAndSet(false, true)) {
        }
     * owns the cache and destroys it via {@code foyer_destroy_cache} in {@link #close()} —
        this.tiered = false;
        // No-op destructor: this is a borrowed reference — FoyerBlockCache owns the lifecycle.
     * @param persistIntervalSecs       persist interval; 0 = disabled
public final class FoyerBlockCache implements BlockCache {
    /**
     * Returns the cross-tier rollup {@link BlockCacheStats} for core consumption.
            dataSubmitQueueSizeBytes,
    }
        long sweepIntervalSecs,
        }
 */
        String ioEngine,
        if (tiered) {
        Objects.requireNonNull(ioEngine, "ioEngine must not be null");
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.BlockCache;
        return foyerStats().overallStats();
        this.dataDiskBytes = 0L;
     *                                  or {@code diskDir} is blank
     * @throws NullPointerException     if {@code diskDir} or {@code ioEngine} is null
        }
            metaBlockSizeBytes,
        Objects.requireNonNull(dataDiskDir, "dataDiskDir must not be null");
        }
        );
     * <p>In single-cache mode: section 0 = overall, section 1 = block-level (identical).
     */
     * Destroys the native cache. Idempotent — safe to call multiple times.
            throw new IllegalArgumentException("metaDiskBytes must be > 0, got: " + metaDiskBytes);
            return FoyerAggregatedStats.snapshotTiered(raw, dataDiskBytes, metadataDiskBytes);
    /** Guards against double-close per the {@link AutoCloseable} contract. */
package org.opensearch.blockcache.foyer;
     * @param metaBlockSizeBytes        metadata cache block size
    public BlockCacheStats stats() {
        if (closed.get() == false && cachePtr > 0) {
        }
            metaSubmitQueueSizeBytes,
    }
        }
     * @param sweepIntervalSecs         sweep interval; 0 = disabled
    /**
        if (submitQueueSizeThresholdBytes <= 0) {
     *                                  {@code sweepIntervalSecs < 0}, {@code persistIntervalSecs < 0},
        long submitQueueSizeThresholdBytes,
            diskDir,
            FoyerBridge.updateSweepThreshold(cachePtr, newRatio);
    public boolean clear() {
        BlockCacheStats meta = s.metadataCacheStats();
    /** Whether this is a tiered cache (data + metadata on separate SSDs). */
            FoyerBridge.evictPrefix(cachePtr, prefix);
            metaDiskBytes,
     *
     * @return stats snapshot; never {@code null}
     * Create a tiered Foyer cache with separate data and metadata SSDs.
    public FoyerBlockCache(
    @Override
        long persistIntervalSecs
    /**
            meta.evictionBytes(),
     * but does nothing. The raw fat pointer created by {@code foyer_create_cache} is valid for
        }
            meta.evictions(),
        if (closed.get() == false) {
     * @param sweepThresholdRatio    minimum {@code used_bytes / disk_bytes} ratio to run the sweep;
        }
    public void evictPrefix(String prefix) {
        long metaSubmitQueueSizeBytes,
        if (sweepIntervalSecs < 0) {
        return false;
            sweepThresholdRatio,
     * In tiered mode: section 0 = data cache, section 1 = metadata cache,
        String dataDiskDir,
 *
    /** The configured disk capacity in bytes */
        }
     *                               {@code 0} = disabled (no background sweep task is spawned).
     * the entire lifetime of this {@code FoyerBlockCache} instance. {@code FoyerBlockCache}
            sweepIntervalSecs,
        return tiered;
 */
        Objects.requireNonNull(ioEngine, "ioEngine must not be null");
    public String cacheName() {
     * @throws IllegalArgumentException if {@code diskBytes <= 0}, {@code blockSizeBytes <= 0},
        }
        Objects.requireNonNull(diskDir, "diskDir must not be null");
            throw new IllegalArgumentException("blockSizeBytes must be > 0, got: " + blockSizeBytes);
    }
            data.totalBytes(),
        }
        this.metadataDiskBytes = 0L;
     * @param metaDiskDir               directory for metadata cache
    public void updateSweepInterval(long newSecs) {
     * {@code overallStats()} returns merged counters.
    public FoyerAggregatedStats foyerStats() {
        this.metadataDiskBytes = metaDiskBytes;
            throw new IllegalArgumentException("persistIntervalSecs must be >= 0, got: " + persistIntervalSecs);
    }
        long dataDiskBytes,
    private final long metadataDiskBytes;
            bufferPoolSizeBytes,
        if (closed.get() == false) {
     *
     *
     * @param ioEngine               I/O engine: {@code "auto"}, {@code "io_uring"}, or {@code "psync"}
    private final AtomicBoolean closed = new AtomicBoolean(false);
    public NativeStoreHandle nativeCacheHandle() {
            throw new IllegalArgumentException("sweepIntervalSecs must be >= 0, got: " + sweepIntervalSecs);
        }
        long metaBlockSizeBytes,
/*
        }
            metaDiskDir,
            meta.activeInBytes()
     */
            data.evictions(),
    /** Opaque {@code Box<Arc<dyn BlockCache>>} fat pointer returned by {@code foyer_create_cache}. Always positive. */
    @Override
    @Override
    /** Whether this instance is a tiered cache (data + metadata on separate SSDs). */
     * @param ioEngine                  I/O engine for both caches
     * @param dataBlockSizeBytes        data cache block size
