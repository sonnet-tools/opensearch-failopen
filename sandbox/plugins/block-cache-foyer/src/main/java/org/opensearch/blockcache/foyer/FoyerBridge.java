package org.opensearch.blockcache.foyer;
                ValueLayout.JAVA_LONG,   // buffer_pool_size_bytes: u64
    ) {
     * <p>Returns a {@code Box<Arc<dyn BlockCache>>} fat pointer that can be passed
            long ptr = call.invoke(
     * REMOVED_BYTES, ACTIVE_IN_BYTES.
        // data_buffer_pool, data_submit_queue, meta_disk, meta_dir_ptr, meta_dir_len,
                );
                dataDiskBytes,
        } catch (Exception e) {
                    bufferSize,
    }
 *
                sweepIntervalSecs,
                sweepThresholdRatio,
        long persistIntervalSecs
                ValueLayout.JAVA_LONG,   // data_disk_bytes
     */
            );
                ValueLayout.ADDRESS,     // meta_dir_ptr
    /**
 */
        long dataDiskBytes,
 * The OpenSearch Contributors require contributions made to
            FunctionDescriptor.of(
            lib.find("foyer_create_tiered_cache").orElseThrow(),
     * @param dataSubmitQueueSizeBytes   data cache submit queue threshold in bytes
        try (var call = new NativeCall()) {
        String dataDiskDir,
        // i64 foyer_clear_cache(i64 ptr) — 0=success, <0=error
     * @param sweepThresholdRatio    minimum {@code used_bytes / disk_bytes} ratio required to run
    private static final MethodHandle FOYER_DESTROY_CACHE;
     * <p>The buffer size (20 = 10 fields × 2 sections) is derived from
     * @param ioEngine                   I/O engine for both caches
        try (var call = new NativeCall()) {
                // Native/Java buffer size mismatch — log and return zeros rather than
        double sweepThresholdRatio,
    }
            }
        FOYER_SNAPSHOT_STATS = linker.downcallHandle(
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();
            // the removed Arena.allocateArray(ValueLayout, count).
        long sweepIntervalSecs,
        logger.info(
     * directly as {@code cache_box_ptr} to {@code ts_create_tiered_object_store}.
        try (var call = new NativeCall()) {
        // i64 foyer_evict_prefix(i64 ptr, *const u8 prefix_ptr, u64 prefix_len) — 0=success, <0=error
                engine.segment(),
import java.lang.foreign.FunctionDescriptor;
                ValueLayout.JAVA_LONG   // ptr
     * @param sweepIntervalSecs          sweep interval for both caches; 0 = disabled
                ValueLayout.JAVA_LONG,   // return: 0=ok, <0=error
            long ptr = call.invoke(
     *
     * @param dataBufferPoolSizeBytes    data cache buffer pool size in bytes
        }
 */
                metaDiskBytes,
import java.lang.invoke.MethodHandle;
                        + "Rust snapshot() and Java FoyerAggregatedStats.Field are out of sync",
 * <p>Exposes three operations: {@link #createCache}, {@link #destroyCache},
    /** Updates the sweep threshold ratio live. {@code 0.0} = always sweep. Takes effect on next sweep tick. */
    public static long createTieredCache(
    private static final MethodHandle FOYER_UPDATE_PERSIST_INTERVAL;
                FOYER_CREATE_CACHE,
                ValueLayout.JAVA_LONG    // persist_interval_secs: u64 (0 = disabled)
        try (Arena arena = Arena.ofConfined()) {
            )
        String ioEngine,
                blockSizeBytes,
     * Create a tiered Foyer block cache with separate data and metadata SSDs.
                "Foyer tiered block cache created: dataDisk={}, metaDisk={}, dataBlockSize={}, metaBlockSize={}, "
                ValueLayout.JAVA_LONG,   // meta_disk_bytes
            if (ptr <= 0) {
     */
        long metaBufferPoolSizeBytes,
        FOYER_CREATE_CACHE = linker.downcallHandle(
     * @return opaque handle; always positive on success
     * @param metaDiskBytes              metadata cache disk capacity in bytes
            if (ptr <= 0) {
            lib.find("foyer_update_sweep_interval").orElseThrow(),
import org.opensearch.nativebridge.spi.NativeCall;
     * @throws RuntimeException if the native call returns an error (invalid ptr)
     *                               key_index to disk. {@code 0} = disabled (only {@code Drop} persists).
     * @param metaBlockSizeBytes         metadata cache block size in bytes
                ValueLayout.JAVA_LONG,   // meta_block_size_bytes
            // Arena.allocate(ValueLayout, count) is the Java 22+ replacement for
            logger.info("Foyer block cache cleared");
            )
     * @param persistIntervalSecs    how often (seconds) the independent persist task flushes the
            FunctionDescriptor.of(
                ValueLayout.JAVA_DOUBLE  // new_ratio: f64
                ValueLayout.JAVA_LONG   // new_secs: u64
     *                               Maps to {@code block_cache.foyer.key_index_sweep_interval_seconds}.
            }
        String ioEngine,
     * <p>Returns a {@code long[20]} buffer containing two equal-sized sections:
import org.apache.logging.log4j.Logger;
     *
            logger.warn("foyer_update_sweep_interval failed: {}", e.getMessage());
    /**
     *
        try (var call = new NativeCall()) {
                ValueLayout.ADDRESS,     // io_engine_ptr: *const u8
 * compatible open source license.
            var out = arena.allocate(ValueLayout.JAVA_LONG, bufferSize);
                ValueLayout.JAVA_LONG   // ptr: i64 cache handle
        long blockSizeBytes,
     *
            "FFM downcall handles resolved: foyer_create_cache, foyer_create_tiered_cache, foyer_destroy_cache, "
            lib.find("foyer_clear_cache").orElseThrow(),
    }
            logger.warn("foyer_update_persist_interval failed: {}", e.getMessage());
            lib.find("foyer_update_sweep_threshold").orElseThrow(),
            FunctionDescriptor.of(
        long metaSubmitQueueSizeBytes,
 * <p>{@link #createCache} returns an opaque {@code long} handle representing a
        long dataBufferPoolSizeBytes,
                ValueLayout.JAVA_LONG    // persist_interval_secs
        );
        long metaBlockSizeBytes,
     * <p>Returns a {@code Box<Arc<dyn BlockCache>>} fat pointer that can be passed
                dataDiskBytes,
    private static final MethodHandle FOYER_EVICT_PREFIX;
            logger.info("Foyer persist interval updated: {}s", newSecs == 0 ? "disabled" : newSecs);
            var engine = call.str(ioEngine);
     */
        FOYER_UPDATE_SWEEP_THRESHOLD = linker.downcallHandle(
            );
    private static final MethodHandle FOYER_UPDATE_SWEEP_INTERVAL;
                dir.segment(),
        FOYER_DESTROY_CACHE = linker.downcallHandle(
            logger.info(
                ValueLayout.ADDRESS,     // io_engine_ptr
                ValueLayout.JAVA_LONG,   // submit_queue_size_threshold_bytes: u64
 *
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
            FunctionDescriptor.of(
        } catch (Exception e) {
                ValueLayout.JAVA_LONG,  // ptr: i64 cache handle
            logger.warn("foyer_update_sweep_threshold failed: {}", e.getMessage());
                sweepThresholdRatio,
 *
        long diskBytes,
                dataDir.segment(),
                persistIntervalSecs
        }
 *
            )
                dataBlockSizeBytes,
     * directly as {@code cache_box_ptr} to {@code ts_create_tiered_object_store}.
        // i64 foyer_destroy_cache(i64 ptr) — 0=success, <0=error pointer
     * with the Rust {@code foyer_snapshot_stats} implementation.
     * {@code block_level} (disk tier, indices 10–19).
    public static void updateSweepThreshold(long ptr, double newRatio) {
                dataDiskDir,
            }
                throw new IllegalStateException("foyer_create_tiered_cache returned an invalid handle");
            call.invoke(FOYER_DESTROY_CACHE, ptr);
     * Create a Foyer block cache.
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
                "Foyer block cache created: diskBytes={}, blockSize={}, bufferPool={}, submitQueueThreshold={}, " + "ioEngine={}, dir={}",
     * @param blockSizeBytes         Foyer disk block size in bytes
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
        FOYER_CREATE_TIERED_CACHE = linker.downcallHandle(
    public static boolean clearCache(long ptr) {
            return ptr;
                ValueLayout.JAVA_LONG,  // ptr: i64 cache handle
        // sweep_interval, sweep_threshold, persist_interval) -> i64
        FOYER_UPDATE_PERSIST_INTERVAL = linker.downcallHandle(
     * @param metaBufferPoolSizeBytes    metadata cache buffer pool size in bytes
     *                               skipped (no-op). {@code 0.0} = disabled (always sweep).
    static {
            return ptr;
        }
                metaDiskDir
    /**
    private static final Logger logger = LogManager.getLogger(FoyerBridge.class);
                metaSubmitQueueSizeBytes,
            call.invoke(FOYER_CLEAR_CACHE, ptr);
    private static final MethodHandle FOYER_SNAPSHOT_STATS;
 * FFM bridge for the Foyer block cache lifecycle.
                submitQueueSizeThresholdBytes,
    private static final MethodHandle FOYER_CREATE_CACHE;
     * @param ptr    the cache handle returned by {@link #createCache}
            var engine = call.str(ioEngine);
     * @param sweepIntervalSecs      background key_index sweep interval in seconds;
                ValueLayout.JAVA_LONG,   // data_buffer_pool_size_bytes
     * @param dataBlockSizeBytes         data cache block size in bytes
     * {@link FoyerAggregatedStats#STATS_BUFFER_SIZE} and must stay in sync
                engine.len(),
                sweepIntervalSecs,
        );
        // i64 foyer_update_persist_interval(i64 ptr, u64 new_secs) — 0=success, <0=error
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
                dataBlockSizeBytes,
                metaDir.len(),
                // silently mismap fields, which would corrupt stats.
            lib.find("foyer_update_persist_interval").orElseThrow(),
     * Best-effort: if the native call fails, the error is logged but not propagated.
        // meta_block_size, meta_buffer_pool, meta_submit_queue, io_engine_ptr, io_engine_len,
    public static long[] snapshotStats(long ptr) {
                metaBlockSizeBytes,
            try (var call = new NativeCall()) {
     */
            FunctionDescriptor.of(
                metaBufferPoolSizeBytes,
                engine.len(),
    public static long createCache(
        logger.info("Foyer block cache destroyed");
                ValueLayout.ADDRESS,    // prefix_ptr: *const u8
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
                ValueLayout.JAVA_LONG,   // sweep_interval_secs: u64 (0 = disabled)
    }
            }
        Linker linker = Linker.nativeLinker();
                ValueLayout.JAVA_LONG,   // sweep_interval_secs
     * @param metaDiskDir                directory for metadata cache files
            return false;
                + "foyer_snapshot_stats, foyer_evict_prefix, foyer_clear_cache, foyer_update_sweep_threshold, "
                dataBufferPoolSizeBytes,
    }
        );
            logger.info(
        String diskDir,
     *                               Maps to {@code block_cache.foyer.key_index_sweep_threshold}.
/*
 * and {@link #snapshotStats}.
                engine.segment(),
                logger.error(
                ValueLayout.JAVA_LONG,   // data_submit_queue_size_threshold_bytes
     * Snapshot the cache statistics from the native Foyer runtime.
        }
            )
    public static void evictPrefix(long ptr, String prefix) {
                    + "ioEngine={}, dataDir={}, metaDir={}",
                ValueLayout.JAVA_LONG,   // data_dir_len
     * @param diskDir                path to the directory where Foyer stores cache data
    private static final MethodHandle FOYER_UPDATE_SWEEP_THRESHOLD;
     * Each section carries the 10 counters in the order defined by
    private static final MethodHandle FOYER_CLEAR_CACHE;
                bufferPoolSizeBytes,
     *
                + "foyer_update_sweep_interval, foyer_update_persist_interval"
                ValueLayout.JAVA_DOUBLE, // sweep_threshold_ratio: f64 (0.0 = disabled)
        long dataSubmitQueueSizeBytes,
        long submitQueueSizeThresholdBytes,
        } catch (Exception e) {
import java.lang.foreign.Linker;
    /**
    }
    ) {
     * @param ptr the cache handle returned by {@link #createCache}
 * wrapping is needed.
                ValueLayout.JAVA_LONG,  // ptr: i64 cache handle
     * Evict all cache entries whose key starts with the given prefix.
     *                               the sweep. When the ratio is below this value the sweep tick is
/**
     */
        } catch (Exception e) {
     * @return an opaque fat pointer representing the cache instance; always positive on success
     *
        );
        FOYER_UPDATE_SWEEP_INTERVAL = linker.downcallHandle(
                diskBytes,
                return new long[bufferSize];
            return true;
     * @param metaSubmitQueueSizeBytes   metadata cache submit queue threshold in bytes
            call.invoke(FOYER_EVICT_PREFIX, ptr, p.segment(), p.len());
                diskBytes,
                ValueLayout.JAVA_DOUBLE, // sweep_threshold_ratio
     * @param ptr the handle returned by {@link #createCache}
            FunctionDescriptor.of(
                ValueLayout.JAVA_LONG,   // io_engine_len
                    "foyer_snapshot_stats: expected {} values but got {}; "
     * @param dataDiskDir                directory for data cache files
        long bufferPoolSizeBytes,
                throw new IllegalStateException("foyer_create_cache returned an invalid handle");
        );
                submitQueueSizeThresholdBytes,
     *
     *
                ValueLayout.JAVA_LONG,   // data_block_size_bytes
                dir.len(),
        FOYER_CLEAR_CACHE = linker.downcallHandle(
    private FoyerBridge() {}
                ValueLayout.JAVA_LONG,   // meta_submit_queue_size_threshold_bytes
     * {@code overall} (cross-tier rollup, indices 0–9) followed by
            )
                ioEngine,
            logger.info("Foyer sweep threshold updated: {}%", (int) (newRatio * 100));
    }
                metaBlockSizeBytes,
    /** Updates the sweep interval live. {@code 0} = disable. Takes effect on next sleep cycle. */
     *                               {@code 0} = disabled (no background sweep task is spawned).
                ValueLayout.JAVA_LONG   // prefix_len: u64
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
    public static void updateSweepInterval(long ptr, long newSecs) {
                metaDiskBytes,
        long sweepIntervalSecs,
                ValueLayout.JAVA_LONG,   // io_engine_len: u64
     * @param prefix absolute path prefix (e.g. shard data path)
                ioEngine,
     * <p>Best-effort: if the native call fails, the error is logged but not propagated.
        }
        try (var call = new NativeCall()) {
     * @param sweepThresholdRatio        sweep threshold for both caches; 0.0 = always
            logger.warn("foyer_clear_cache failed: {}", e.getMessage());
                dataDir.len(),
     * @param persistIntervalSecs        persist interval for both caches; 0 = disabled
            FunctionDescriptor.of(
            var metaDir = call.str(metaDiskDir);
            lib.find("foyer_evict_prefix").orElseThrow(),
        final int bufferSize = FoyerAggregatedStats.STATS_BUFFER_SIZE;
     * Clear all entries from the cache.
     * MISS_BYTES, EVICTION_COUNT, EVICTION_BYTES, USED_BYTES, REMOVED_COUNT,
                blockSizeBytes,
                dataSubmitQueueSizeBytes,
                ValueLayout.ADDRESS,     // dir_ptr: *const u8
            call.invoke(FOYER_UPDATE_PERSIST_INTERVAL, ptr, newSecs);
                FOYER_CREATE_TIERED_CACHE,
                ValueLayout.JAVA_LONG,   // return: opaque i64 fat pointer
        }
            var p = call.str(prefix);
        );
        try (var call = new NativeCall()) {
 * SPDX-License-Identifier: Apache-2.0
     *
}
                metaDir.segment(),
                ValueLayout.JAVA_LONG,   // meta_buffer_pool_size_bytes
            logger.info("Foyer sweep interval updated: {}s", newSecs == 0 ? "disabled" : newSecs);
            return new long[bufferSize];
            lib.find("foyer_destroy_cache").orElseThrow(),
     * @param dataDiskBytes              data cache disk capacity in bytes
        long metaDiskBytes,
                ValueLayout.JAVA_LONG,  // ptr: i64 cache handle
    }
 * this file be licensed under the Apache-2.0 license or a
                ValueLayout.JAVA_LONG,   // meta_dir_len
    }
        );
                ValueLayout.JAVA_LONG,   // ptr: i64 cache handle
                ValueLayout.JAVA_LONG   // new_secs: u64
            FunctionDescriptor.of(
        try (var call = new NativeCall()) {
    /**
        FOYER_EVICT_PREFIX = linker.downcallHandle(
    /** Updates the persist interval live. {@code 0} = disable. Takes effect on next sleep cycle. */
                ValueLayout.JAVA_LONG,   // dir_len: u64
     * <p>After this call the handle is invalid and must not be used again.
                    result.length
import java.lang.foreign.SymbolLookup;
            long[] result = out.toArray(ValueLayout.JAVA_LONG);
            )
        // i64 foyer_snapshot_stats(i64 ptr, i64* out) — 0=success, <0=error
            lib.find("foyer_create_cache").orElseThrow(),
public final class FoyerBridge {
     * @param diskBytes              maximum disk space the cache may use, in bytes
     *
                diskDir
            return result;
            call.invoke(FOYER_UPDATE_SWEEP_INTERVAL, ptr, newSecs);
        String metaDiskDir,
            logger.warn("foyer_evict_prefix failed for prefix='{}': {}", prefix, e.getMessage());
    private static final MethodHandle FOYER_CREATE_TIERED_CACHE;
    public static void updatePersistInterval(long ptr, long newSecs) {
 * {@code cache_box_ptr} to {@code ts_create_tiered_object_store} — no additional
     * @throws RuntimeException if the native call fails or the directory is invalid
        double sweepThresholdRatio,
        } catch (Exception e) {
                persistIntervalSecs
 * @opensearch.experimental
        } catch (Exception e) {
                ValueLayout.JAVA_LONG,   // disk_bytes: u64
            );
                call.invoke(FOYER_SNAPSHOT_STATS, ptr, out);
            FunctionDescriptor.of(
        );
        // i64 foyer_update_sweep_threshold(i64 ptr, f64 new_ratio) — 0=success, <0=error
            )
     * {@code FoyerAggregatedStats.Field}: HIT_COUNT, HIT_BYTES, MISS_COUNT,
    }
            var dataDir = call.str(dataDiskDir);
import java.lang.foreign.ValueLayout;
     */
        );
     * Destroy a cache previously created by {@link #createCache}.
                bufferPoolSizeBytes,
                ValueLayout.ADDRESS     // out: *mut i64, output buffer
            );
            call.invoke(FOYER_UPDATE_SWEEP_THRESHOLD, ptr, newRatio);
            logger.warn("foyer_snapshot_stats failed: {}", e.getMessage());
     *
     * @param ioEngine               I/O engine: {@code "auto"}, {@code "io_uring"}, or {@code "psync"}
        long persistIntervalSecs
                ValueLayout.JAVA_LONG,   // return: opaque i64 fat pointer
                ValueLayout.ADDRESS,     // data_dir_ptr
            var dir = call.str(diskDir);
     *
        );
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
        }
        }
        }
        // i64 foyer_update_sweep_interval(i64 ptr, u64 new_secs) — 0=success, <0=error
    /**
     *                               Maps to {@code block_cache.foyer.key_index_persist_interval_seconds}.
     * <p>Called by {@code FoyerBlockCache.evictPrefix} during shard/index deletion.
            lib.find("foyer_snapshot_stats").orElseThrow(),
 * {@code Box<Arc<dyn BlockCache>>} fat pointer. The handle is passed directly as
            // toArray copies the entire allocated segment.
    public static void destroyCache(long ptr) {
            )
        long dataBlockSizeBytes,
import org.apache.logging.log4j.LogManager;
        // foyer_create_tiered_cache(data_disk, data_dir_ptr, data_dir_len, data_block_size,
            if (result.length != bufferSize) {
            )
import java.lang.foreign.Arena;
                ValueLayout.JAVA_LONG,   // block_size_bytes: u64
