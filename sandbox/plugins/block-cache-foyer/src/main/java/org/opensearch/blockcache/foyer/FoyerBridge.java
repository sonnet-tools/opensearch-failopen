    private static final MethodHandle FOYER_EVICT_PREFIX;
            FunctionDescriptor.of(
        FOYER_CREATE_TIERED_CACHE = linker.downcallHandle(  
                call.invoke(FOYER_SNAPSHOT_STATS, ptr, out);
     * {@code FoyerAggregatedStats.Field}: HIT_COUNT, HIT_BYTES, MISS_COUNT,
    public static void updatePersistInterval(long ptr, long newSecs) {  
public final class FoyerBridge {
     *                               skipped (no-op). {@code 0.0} = disabled (always sweep).
                "Foyer tiered block cache created: dataDisk={}, metaDisk={}, dataBlockSize={}, metaBlockSize={}, "
     * @param ioEngine               I/O engine: {@code "auto"}, {@code "io_uring"}, or {@code "psync"}
            )  
                ValueLayout.JAVA_LONG   // new_secs: u64
        );
     * @param dataDiskDir                directory for data cache files  
            FunctionDescriptor.of(
        String ioEngine,
                dataDiskBytes,
            long[] result = out.toArray(ValueLayout.JAVA_LONG);
package org.opensearch.blockcache.foyer;
            )
            var engine = call.str(ioEngine);
        try (var call = new NativeCall()) {
    }
 *  
            return true;
            return false;
        // foyer_create_tiered_cache(data_disk, data_dir_ptr, data_dir_len, data_block_size,
            var dir = call.str(diskDir);  
    public static long createCache(  
                ValueLayout.JAVA_LONG    // persist_interval_secs
     */  
        }
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
                ValueLayout.JAVA_LONG,   // ptr: i64 cache handle
        long metaSubmitQueueSizeBytes,
    /**
            if (ptr <= 0) {
                blockSizeBytes,
    /** Updates the persist interval live. {@code 0} = disable. Takes effect on next sleep cycle. */
            lib.find("foyer_evict_prefix").orElseThrow(),  
     * @param sweepThresholdRatio        sweep threshold for both caches; 0.0 = always
                    result.length
     * @param metaSubmitQueueSizeBytes   metadata cache submit queue threshold in bytes
            "FFM downcall handles resolved: foyer_create_cache, foyer_create_tiered_cache, foyer_destroy_cache, "
     * @param diskBytes              maximum disk space the cache may use, in bytes
            logger.warn("foyer_snapshot_stats failed: {}", e.getMessage());
                diskBytes,
    static {
     *
     * {@code block_level} (disk tier, indices 10–19).  
    }
                sweepIntervalSecs,  
        // sweep_interval, sweep_threshold, persist_interval) -> i64
        long persistIntervalSecs  
     */  
                persistIntervalSecs
                FOYER_CREATE_CACHE,  
    private static final MethodHandle FOYER_DESTROY_CACHE;
    private static final MethodHandle FOYER_CREATE_TIERED_CACHE;
     * @throws RuntimeException if the native call returns an error (invalid ptr)
        final int bufferSize = FoyerAggregatedStats.STATS_BUFFER_SIZE;
     * {@code overall} (cross-tier rollup, indices 0–9) followed by
                ValueLayout.JAVA_LONG,   // meta_submit_queue_size_threshold_bytes  
            return new long[bufferSize];
    private static final Logger logger = LogManager.getLogger(FoyerBridge.class);
                throw new IllegalStateException("foyer_create_cache returned an invalid handle");
        FOYER_DESTROY_CACHE = linker.downcallHandle(
        long dataSubmitQueueSizeBytes,
        Linker linker = Linker.nativeLinker();  
        );
 * {@code cache_box_ptr} to {@code ts_create_tiered_object_store} — no additional  
    }
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
                diskBytes,  
        FOYER_UPDATE_PERSIST_INTERVAL = linker.downcallHandle(  
            logger.warn("foyer_update_sweep_threshold failed: {}", e.getMessage());  
                ValueLayout.JAVA_LONG,   // meta_block_size_bytes
     * @param sweepIntervalSecs          sweep interval for both caches; 0 = disabled
     * <p>Returns a {@code Box<Arc<dyn BlockCache>>} fat pointer that can be passed
     *                               key_index to disk. {@code 0} = disabled (only {@code Drop} persists).
                ValueLayout.JAVA_LONG   // ptr: i64 cache handle
        // meta_block_size, meta_buffer_pool, meta_submit_queue, io_engine_ptr, io_engine_len,
            )
     * MISS_BYTES, EVICTION_COUNT, EVICTION_BYTES, USED_BYTES, REMOVED_COUNT,  
        long diskBytes,
            logger.info("Foyer block cache cleared");
                return new long[bufferSize];  
                blockSizeBytes,
     * @param blockSizeBytes         Foyer disk block size in bytes  
     * @param metaDiskBytes              metadata cache disk capacity in bytes
        // i64 foyer_destroy_cache(i64 ptr) — 0=success, <0=error pointer  
                ValueLayout.JAVA_LONG,   // io_engine_len: u64
        long sweepIntervalSecs,
                "Foyer block cache created: diskBytes={}, blockSize={}, bufferPool={}, submitQueueThreshold={}, " + "ioEngine={}, dir={}",
            try (var call = new NativeCall()) {
        String diskDir,
        try (var call = new NativeCall()) {
            }
     * Evict all cache entries whose key starts with the given prefix.
 * {@code Box<Arc<dyn BlockCache>>} fat pointer. The handle is passed directly as
                dataBufferPoolSizeBytes,
    /**  
        );
     * @param dataSubmitQueueSizeBytes   data cache submit queue threshold in bytes  
    public static long[] snapshotStats(long ptr) {
    /** Updates the sweep threshold ratio live. {@code 0.0} = always sweep. Takes effect on next sweep tick. */  
            return ptr;  
     */
        long sweepIntervalSecs,  
                ValueLayout.JAVA_LONG,   // block_size_bytes: u64  
                ValueLayout.JAVA_DOUBLE, // sweep_threshold_ratio
 */  
 * this file be licensed under the Apache-2.0 license or a
                metaDir.len(),  
            call.invoke(FOYER_CLEAR_CACHE, ptr);  
                ValueLayout.JAVA_LONG,  // ptr: i64 cache handle
import java.lang.foreign.Linker;
                    + "ioEngine={}, dataDir={}, metaDir={}",  
            // toArray copies the entire allocated segment.
        } catch (Exception e) {  
                submitQueueSizeThresholdBytes,  
     * Destroy a cache previously created by {@link #createCache}.
     */
            lib.find("foyer_update_sweep_threshold").orElseThrow(),
    public static boolean clearCache(long ptr) {
                ValueLayout.JAVA_LONG,   // dir_len: u64
        }  
     * @param metaDiskDir                directory for metadata cache files
            );  
    /** Updates the sweep interval live. {@code 0} = disable. Takes effect on next sleep cycle. */
                    "foyer_snapshot_stats: expected {} values but got {}; "
            FunctionDescriptor.of(  
            lib.find("foyer_update_persist_interval").orElseThrow(),
            )
            }  
                metaDir.segment(),
        long blockSizeBytes,  
    }
 * SPDX-License-Identifier: Apache-2.0
        } catch (Exception e) {
        } catch (Exception e) {  
    public static long createTieredCache(  
     */
     * @param ptr the handle returned by {@link #createCache}  
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
        try (var call = new NativeCall()) {
    ) {
    private static final MethodHandle FOYER_CREATE_CACHE;  
                        + "Rust snapshot() and Java FoyerAggregatedStats.Field are out of sync",
 * FFM bridge for the Foyer block cache lifecycle.
            call.invoke(FOYER_UPDATE_SWEEP_INTERVAL, ptr, newSecs);
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error  
     *
                ValueLayout.JAVA_LONG,   // data_disk_bytes
/*  
                dataDiskBytes,
        double sweepThresholdRatio,
     *                               Maps to {@code block_cache.foyer.key_index_sweep_threshold}.
        }  
        FOYER_SNAPSHOT_STATS = linker.downcallHandle(
        String ioEngine,  
import java.lang.foreign.SymbolLookup;  
        );
 *
                // silently mismap fields, which would corrupt stats.
                ValueLayout.ADDRESS,     // io_engine_ptr: *const u8  
            FunctionDescriptor.of(  
        FOYER_CLEAR_CACHE = linker.downcallHandle(
                ValueLayout.JAVA_LONG,  // ptr: i64 cache handle  
            );  
        long metaBufferPoolSizeBytes,  
        FOYER_CREATE_CACHE = linker.downcallHandle(
                ioEngine,
     *
        // i64 foyer_snapshot_stats(i64 ptr, i64* out) — 0=success, <0=error  
                engine.segment(),
                dir.len(),  
     *                               Maps to {@code block_cache.foyer.key_index_persist_interval_seconds}.
                dataBlockSizeBytes,
            FunctionDescriptor.of(
        long dataDiskBytes,
                ValueLayout.JAVA_LONG,   // meta_dir_len  
        }
        }
            logger.info("Foyer sweep interval updated: {}s", newSecs == 0 ? "disabled" : newSecs);
     * Create a tiered Foyer block cache with separate data and metadata SSDs.  
        // i64 foyer_update_sweep_interval(i64 ptr, u64 new_secs) — 0=success, <0=error
        String dataDiskDir,
        }  
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
                    bufferSize,  
            FunctionDescriptor.of(
                metaDiskBytes,
     * @param sweepIntervalSecs      background key_index sweep interval in seconds;
     *                               the sweep. When the ratio is below this value the sweep tick is  
        } catch (Exception e) {
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();
                sweepThresholdRatio,
/**
    /**
                ValueLayout.JAVA_LONG,   // return: opaque i64 fat pointer  
    public static void updateSweepInterval(long ptr, long newSecs) {
        double sweepThresholdRatio,
                ValueLayout.JAVA_LONG   // prefix_len: u64
    public static void updateSweepThreshold(long ptr, double newRatio) {
        long persistIntervalSecs
        try (var call = new NativeCall()) {
            lib.find("foyer_create_cache").orElseThrow(),  
                ValueLayout.ADDRESS,     // meta_dir_ptr
    }
            lib.find("foyer_destroy_cache").orElseThrow(),
                + "foyer_update_sweep_interval, foyer_update_persist_interval"  
        try (var call = new NativeCall()) {
        String metaDiskDir,
            return ptr;
 *
    /**
                ValueLayout.JAVA_LONG,   // data_buffer_pool_size_bytes
        );
                dataDiskDir,  
                submitQueueSizeThresholdBytes,  
                metaBlockSizeBytes,
     * Snapshot the cache statistics from the native Foyer runtime.
                dataBlockSizeBytes,  
                engine.len(),
                ValueLayout.JAVA_DOUBLE  // new_ratio: f64  
                dataSubmitQueueSizeBytes,  
        logger.info("Foyer block cache destroyed");
 * <p>{@link #createCache} returns an opaque {@code long} handle representing a
        }  
 * wrapping is needed.
                dir.segment(),
            long ptr = call.invoke(
                ValueLayout.ADDRESS,    // prefix_ptr: *const u8
     * <p>Returns a {@code Box<Arc<dyn BlockCache>>} fat pointer that can be passed
                metaSubmitQueueSizeBytes,  
     * <p>The buffer size (20 = 10 fields × 2 sections) is derived from  
        );  
                ValueLayout.JAVA_LONG,   // meta_disk_bytes
     * directly as {@code cache_box_ptr} to {@code ts_create_tiered_object_store}.  
                ValueLayout.JAVA_LONG,   // disk_bytes: u64  
     *  
                sweepThresholdRatio,
                ValueLayout.JAVA_LONG,   // data_submit_queue_size_threshold_bytes  
    private FoyerBridge() {}  
     * Each section carries the 10 counters in the order defined by
import java.lang.invoke.MethodHandle;
                FOYER_CREATE_TIERED_CACHE,  
 *  
     *
            call.invoke(FOYER_UPDATE_SWEEP_THRESHOLD, ptr, newRatio);  
                metaBlockSizeBytes,
        // i64 foyer_evict_prefix(i64 ptr, *const u8 prefix_ptr, u64 prefix_len) — 0=success, <0=error
        );  
     *
            return result;
            logger.warn("foyer_update_persist_interval failed: {}", e.getMessage());
     * <p>Called by {@code FoyerBlockCache.evictPrefix} during shard/index deletion.  
        // data_buffer_pool, data_submit_queue, meta_disk, meta_dir_ptr, meta_dir_len,  
                ValueLayout.ADDRESS,     // io_engine_ptr
 * <p>Exposes three operations: {@link #createCache}, {@link #destroyCache},
            lib.find("foyer_create_tiered_cache").orElseThrow(),
        FOYER_EVICT_PREFIX = linker.downcallHandle(
            var out = arena.allocate(ValueLayout.JAVA_LONG, bufferSize);  
     * REMOVED_BYTES, ACTIVE_IN_BYTES.
                ValueLayout.JAVA_LONG,   // sweep_interval_secs: u64 (0 = disabled)
        FOYER_UPDATE_SWEEP_INTERVAL = linker.downcallHandle(
}
    }
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
            logger.info(
        long bufferPoolSizeBytes,
            )  
     *  
            call.invoke(FOYER_EVICT_PREFIX, ptr, p.segment(), p.len());  
     *
            FunctionDescriptor.of(
        logger.info(  
     * @param dataDiskBytes              data cache disk capacity in bytes
                throw new IllegalStateException("foyer_create_tiered_cache returned an invalid handle");
            )
     *                               {@code 0} = disabled (no background sweep task is spawned).  
            )  
import org.apache.logging.log4j.LogManager;
            logger.warn("foyer_evict_prefix failed for prefix='{}': {}", prefix, e.getMessage());
            // the removed Arena.allocateArray(ValueLayout, count).
    }  
 * compatible open source license.
        long metaDiskBytes,  
import org.opensearch.nativebridge.spi.NativeCall;  
        try (var call = new NativeCall()) {  
        );
                ioEngine,
     *                               Maps to {@code block_cache.foyer.key_index_sweep_interval_seconds}.
 * @opensearch.experimental  
            logger.warn("foyer_update_sweep_interval failed: {}", e.getMessage());
    private static final MethodHandle FOYER_UPDATE_SWEEP_THRESHOLD;  
                bufferPoolSizeBytes,
            logger.info(
import org.apache.logging.log4j.Logger;
                ValueLayout.ADDRESS,     // dir_ptr: *const u8
            var dataDir = call.str(dataDiskDir);
            long ptr = call.invoke(
     * @param diskDir                path to the directory where Foyer stores cache data
                ValueLayout.JAVA_LONG,   // meta_buffer_pool_size_bytes
            FunctionDescriptor.of(  
                metaDiskDir
                sweepIntervalSecs,  
                dataDir.len(),  
            lib.find("foyer_snapshot_stats").orElseThrow(),
                );
            }  
     * @param ptr the cache handle returned by {@link #createCache}
                ValueLayout.JAVA_LONG,   // io_engine_len
     * @throws RuntimeException if the native call fails or the directory is invalid
            var p = call.str(prefix);
            // Arena.allocate(ValueLayout, count) is the Java 22+ replacement for
                ValueLayout.JAVA_LONG,  // ptr: i64 cache handle
    /**  
    private static final MethodHandle FOYER_SNAPSHOT_STATS;  
            if (result.length != bufferSize) {  
                ValueLayout.JAVA_LONG,   // data_dir_len  
        FOYER_UPDATE_SWEEP_THRESHOLD = linker.downcallHandle(
                ValueLayout.JAVA_LONG,   // return: opaque i64 fat pointer
        }
 * and {@link #snapshotStats}.
            )  
                ValueLayout.JAVA_LONG,   // buffer_pool_size_bytes: u64
            if (ptr <= 0) {
                // Native/Java buffer size mismatch — log and return zeros rather than
     * @param ioEngine                   I/O engine for both caches  
                ValueLayout.JAVA_LONG    // persist_interval_secs: u64 (0 = disabled)
                ValueLayout.ADDRESS     // out: *mut i64, output buffer  
    public static void destroyCache(long ptr) {  
                ValueLayout.JAVA_LONG,  // ptr: i64 cache handle  
                persistIntervalSecs
            logger.info("Foyer persist interval updated: {}s", newSecs == 0 ? "disabled" : newSecs);  
        try (Arena arena = Arena.ofConfined()) {  
     * @param metaBlockSizeBytes         metadata cache block size in bytes  
            FunctionDescriptor.of(  
                bufferPoolSizeBytes,
     *
    public static void evictPrefix(long ptr, String prefix) {  
 */
     * {@link FoyerAggregatedStats#STATS_BUFFER_SIZE} and must stay in sync
     *  
     * @param dataBufferPoolSizeBytes    data cache buffer pool size in bytes
     * @param sweepThresholdRatio    minimum {@code used_bytes / disk_bytes} ratio required to run
    ) {  
                diskDir
        } catch (Exception e) {
                ValueLayout.JAVA_LONG,   // submit_queue_size_threshold_bytes: u64
                metaDiskBytes,
     * <p>Returns a {@code long[20]} buffer containing two equal-sized sections:
     *
        long submitQueueSizeThresholdBytes,
                ValueLayout.JAVA_LONG,  // return: 0=ok, <0=error
            logger.info("Foyer sweep threshold updated: {}%", (int) (newRatio * 100));
        }  
    }
                logger.error(  
     * Create a Foyer block cache.
     * Best-effort: if the native call fails, the error is logged but not propagated.
            call.invoke(FOYER_DESTROY_CACHE, ptr);
        // i64 foyer_clear_cache(i64 ptr) — 0=success, <0=error  
            var engine = call.str(ioEngine);
     * Clear all entries from the cache.
     * @param persistIntervalSecs    how often (seconds) the independent persist task flushes the  
                dataDir.segment(),
 * The OpenSearch Contributors require contributions made to  
import java.lang.foreign.FunctionDescriptor;
            lib.find("foyer_update_sweep_interval").orElseThrow(),  
    private static final MethodHandle FOYER_UPDATE_PERSIST_INTERVAL;
                ValueLayout.JAVA_LONG,   // return: 0=ok, <0=error
            lib.find("foyer_clear_cache").orElseThrow(),
                metaBufferPoolSizeBytes,
        long dataBufferPoolSizeBytes,
                ValueLayout.JAVA_LONG   // new_secs: u64
            }  
        } catch (Exception e) {  
     * @param dataBlockSizeBytes         data cache block size in bytes
        try (var call = new NativeCall()) {
            );  
import java.lang.foreign.ValueLayout;
import java.lang.foreign.Arena;  
     *  
            );
     * @param ptr    the cache handle returned by {@link #createCache}  
     */
     * directly as {@code cache_box_ptr} to {@code ts_create_tiered_object_store}.
     * @param prefix absolute path prefix (e.g. shard data path)
        try (var call = new NativeCall()) {
                ValueLayout.JAVA_LONG,   // data_block_size_bytes
        long dataBlockSizeBytes,  
     * @param persistIntervalSecs        persist interval for both caches; 0 = disabled  
     * <p>Best-effort: if the native call fails, the error is logged but not propagated.  
    /**
            )  
     * @param metaBufferPoolSizeBytes    metadata cache buffer pool size in bytes
     * with the Rust {@code foyer_snapshot_stats} implementation.
        );
                + "foyer_snapshot_stats, foyer_evict_prefix, foyer_clear_cache, foyer_update_sweep_threshold, "
            call.invoke(FOYER_UPDATE_PERSIST_INTERVAL, ptr, newSecs);
                ValueLayout.JAVA_LONG   // ptr
                ValueLayout.JAVA_DOUBLE, // sweep_threshold_ratio: f64 (0.0 = disabled)  
        );
    }
     * @return an opaque fat pointer representing the cache instance; always positive on success  
        // i64 foyer_update_persist_interval(i64 ptr, u64 new_secs) — 0=success, <0=error
        // i64 foyer_update_sweep_threshold(i64 ptr, f64 new_ratio) — 0=success, <0=error  
    private static final MethodHandle FOYER_CLEAR_CACHE;
            var metaDir = call.str(metaDiskDir);  
        long metaBlockSizeBytes,
                engine.segment(),
                ValueLayout.JAVA_LONG,   // sweep_interval_secs  
     * <p>After this call the handle is invalid and must not be used again.
    }  
    private static final MethodHandle FOYER_UPDATE_SWEEP_INTERVAL;
                ValueLayout.ADDRESS,     // data_dir_ptr
     * @return opaque handle; always positive on success
                engine.len(),
            logger.warn("foyer_clear_cache failed: {}", e.getMessage());
