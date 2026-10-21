///
/// Foyer is currently single-tier (disk only): `overall` and `block_level` are identical.
        tiered.clear_sync();
    }
    if let Some(foyer) = boxed.as_any().downcast_ref::<FoyerCache>() {
/// Called by Java's `addSettingsUpdateConsumer` when
    meta_dir_len: u64,
        data_disk_bytes,
    0
        return Err(format!("foyer_update_sweep_threshold: invalid ptr {}", ptr));
pub unsafe extern "C" fn foyer_snapshot_stats(ptr: i64, out: *mut i64) -> i64 {
        return Err(format!(
        return Err(
/// Field order within each section (must match `FoyerAggregatedStats.Field` on the Java side):
    if dir_ptr.is_null() {
/// Clear all entries from the cache.
/// `dir_ptr` must point to `dir_len` consecutive valid UTF-8 bytes.
        ))
    } else if let Some(tiered) = boxed.as_any().downcast_ref::<TieredBlockCache>() {
    persist_interval_secs: u64,
        false, // reinsertion_admit_all = false (normal LRU, same as data)
/// The data cache uses default reinsertion (RejectAll) and the metadata cache
        return Err(format!("foyer_destroy_cache: invalid ptr {}", ptr));
    Ok(0)
    }
#[ffm_safe]
}
    if ptr <= 0 {
    } else {
    }
    io_engine_ptr: *const u8,
        tiered.data_cache().update_sweep_threshold(new_ratio);
        io_engine,
    ))
/// Create a [`TieredBlockCache`] with separate data and metadata caches.
    };
        foyer.update_sweep_interval(new_secs);
#[no_mangle]
/// | +0     | `hit_count`        |
/// `ts_create_tiered_object_store` without any further conversion.
 * this file be licensed under the Apache-2.0 license or a
    if ptr <= 0 || out.is_null() {
    data_dir_ptr: *const u8,
/// - `ptr` must be a valid handle from [`foyer_create_cache`], not yet destroyed.
/// # Safety
    if let Some(foyer) = boxed.as_any().downcast_ref::<FoyerCache>() {
use crate::foyer::foyer_cache::FoyerCache;
    sweep_threshold_ratio: f64,
    disk_bytes: u64,
}
        ))
        tiered.metadata_cache().update_sweep_interval(new_secs);
    }
    boxed.evict_prefix(prefix);
    // data pressure from evicting metadata)
    let dir = std::str::from_utf8(std::slice::from_raw_parts(dir_ptr, dir_len as usize))
    if ptr <= 0 {
    dir_ptr: *const u8,
    );
    }
    if let Some(foyer) = boxed.as_any().downcast_ref::<FoyerCache>() {
///
#[no_mangle]
///
        meta_dir,
    native_bridge_common::log_info!("ffm: foyer_clear_cache completed");
    drop(Box::from_raw(
/// | Offset | Field              |
    }
        return -1;
#[no_mangle]
/// | +5     | `eviction_bytes`   |
) -> i64 {
    } else {
///
    ));
/// Called by Java's `NodeCacheServiceCleaner` on shard/index deletion.
/// - `block_size_bytes` — Foyer disk block size in bytes.
        *out.add(i) = v;
    }
    if data_dir_ptr.is_null() {
        return Err("foyer_evict_prefix: invalid ptr".to_string());
///
#[no_mangle]
    native_bridge_common::log_info!(
    ));
    } else {
///
    let cache: Arc<dyn crate::traits::BlockCache> =
        disk_bytes as usize,
        "[tiered-block-cache] ffm: created tiered cache: data_dir={}, meta_dir={}, \
        return Err("dir_ptr is null".to_string());
        std::str::from_utf8(bytes)
    let boxed = &*(ptr as *const Arc<dyn crate::traits::BlockCache>);
    if ptr <= 0 {
    Ok(0)
///   key_index to disk. `0` = disabled (only graceful-shutdown `Drop` persists).
///   on the Java side.
        data_dir_len as usize,
/*
    } else if let Some(tiered) = boxed.as_any().downcast_ref::<TieredBlockCache>() {
/// Update the persist interval on the running cache without a restart. `0` = disable.
        meta_submit_queue_size_threshold_bytes as usize,
    data_disk_bytes: u64,
    }
        std::str::from_utf8(std::slice::from_raw_parts(
/// # Returns
) -> i64 {
    Ok(0)
            io_engine_len as usize,
/// - Shared parameters (`io_engine_*`, `sweep_*`, `persist_*`) apply to both caches.
        tiered.metadata_cache().update_sweep_threshold(new_ratio);
/// The returned pointer can be passed directly as `cache_box_ptr` to
/// - `dir_ptr` / `dir_len` — UTF-8 path to the cache directory.
///
        foyer.update_sweep_threshold(new_ratio);
pub unsafe extern "C" fn foyer_update_sweep_threshold(ptr: i64, new_ratio: f64) -> i64 {
        ));
/// - `disk_bytes` — total disk capacity in bytes.
            "foyer_clear_cache: downcast to FoyerCache or TieredBlockCache failed".to_string(),
/// # Parameters
    .map_err(|e| format!("invalid UTF-8 in meta_dir path: {}", e))?;
        false, // reinsertion_admit_all: default RejectAll for standard data cache
        return Err("data_dir_ptr is null".to_string());
        flat[10..].copy_from_slice(&meta_stats);
        .map_err(|e| format!("invalid UTF-8 in dir path: {}", e))?;
///   (no sweep task is spawned). Maps to `block_cache.foyer.key_index_sweep_interval_seconds`
    meta_buffer_pool_size_bytes: u64,
        sweep_threshold_ratio,
}
    let boxed = &*(ptr as *const Arc<dyn crate::traits::BlockCache>);
    submit_queue_size_threshold_bytes: u64,
/// Returns an opaque `Box<Arc<dyn BlockCache>>` fat pointer as `i64`.
/// `0` on success; `< 0` if `ptr` is invalid or the cache type is wrong.
/// Snapshots cache statistics into a caller-supplied `i64[20]` output buffer.
        return Err("foyer_update_sweep_threshold: downcast failed".to_string());
        meta_block_size_bytes as usize,
        tiered.data_cache().update_sweep_interval(new_secs);
/// Evict all cache entries whose key starts with `prefix`.
        sweep_interval_secs,
    // Parse metadata dir
    io_engine_ptr: *const u8,
/// - Indices 0–9:  cross-tier rollup (`overall`)
/// - `persist_interval_secs` — how often (in seconds) the independent persist task flushes the
use crate::tiered_block_cache::TieredBlockCache;
pub extern "C" fn foyer_evict_prefix(ptr: i64, prefix_ptr: *const u8, prefix_len: u64) -> i64 {
    } else {
/// - `sweep_threshold_ratio` — minimum `used_bytes / disk_bytes` ratio required to run the
    if ptr <= 0 {
    } else {
    } else if let Some(tiered) = boxed.as_any().downcast_ref::<TieredBlockCache>() {
/// Update the sweep threshold ratio on the running cache without a restart.
///
    if ptr <= 0 {
/// |--------|--------------------|
        flat[..10].copy_from_slice(&single);
    ));
        sweep_interval_secs,
/// - `ptr` must be a valid handle from [`foyer_create_cache`], not yet destroyed.
    let metadata_cache = Arc::new(FoyerCache::new(
/// Update the sweep interval on the running cache without a restart. `0` = disable.
/// The sweep task picks up the new value on its next tick.
/// # Returns
/// # Parameters
        .unwrap_or("auto")
    } else {
    let boxed = &*(ptr as *const Arc<dyn crate::traits::BlockCache>);
    ));
    meta_submit_queue_size_threshold_bytes: u64,
/// `ptr` must be a value returned by [`foyer_create_cache`], not yet destroyed.
///
}
///
            .map_err(|e| format!("foyer_evict_prefix: invalid utf-8: {}", e))?
        data_dir,
        meta_dir,
#[ffm_safe]
/// `io_engine_ptr` must point to `io_engine_len` consecutive valid UTF-8 bytes.
 * compatible open source license.
/// - Indices 10–19: disk-tier stats (`block_level`)
    }
            io_engine_ptr,
        foyer.update_persist_interval(new_secs);
    if let Some(foyer) = boxed.as_any().downcast_ref::<FoyerCache>() {
/// | +2     | `miss_count`       |
        buffer_pool_size_bytes as usize,
/// # Safety
/// | +1     | `hit_bytes`        |
//! FFM lifecycle entry points exported to Java.
        data_dir,
use std::sync::Arc;
/// `0` on success; `< 0` if `ptr` is invalid or `out` is null.
    dir_len: u64,
        meta_disk_bytes
    meta_dir_ptr: *const u8,
    // Data cache params
        flat[..10].copy_from_slice(&data_stats);
        block_size_bytes as usize,
    } else if let Some(tiered) = boxed.as_any().downcast_ref::<TieredBlockCache>() {
        return -1;
        tiered.metadata_cache().update_persist_interval(new_secs);
        sweep_interval_secs,
}
    Ok(0)
    let boxed = &*(ptr as *const Arc<dyn crate::traits::BlockCache>);
#[ffm_safe]
/// - `io_engine_ptr` / `io_engine_len` — I/O engine: `"auto"`, `"io_uring"`, or `"psync"`.
    data_dir_len: u64,
/// # Safety
    }
/// | +6     | `used_bytes`       |
///
         data_disk={}B, meta_disk={}B",
    data_submit_queue_size_threshold_bytes: u64,
    }
    if let Some(foyer) = boxed.as_any().downcast_ref::<FoyerCache>() {
///
///
        return Err("foyer_update_sweep_interval: downcast failed".to_string());
    }
/// - `prefix_ptr` must point to `prefix_len` consecutive valid UTF-8 bytes.
        "auto"
/// - `meta_*` — parameters for the metadata cache (small SSD, never-evict).
    persist_interval_secs: u64,
/// | +7     | `removed_count`    |
/// # Parameters
    sweep_threshold_ratio: f64,
        );
/// `0` on success; `< 0` if `ptr` is invalid.
        data_dir_ptr,
    let io_engine = if io_engine_ptr.is_null() {
    native_bridge_common::log_debug!("ffm: foyer_evict_prefix prefix='{}'", prefix);
            "foyer_update_persist_interval: invalid ptr {}",
        tiered.data_cache().update_persist_interval(new_secs);
        meta_buffer_pool_size_bytes as usize,
/// # Safety
///
    // Metadata cache params
    };
        persist_interval_secs,
/// `ptr` must be a valid handle from [`foyer_create_cache`], not yet destroyed.
    block_size_bytes: u64,
/// | +4     | `eviction_count`   |
    let cache: Arc<dyn crate::traits::BlockCache> = Arc::new(FoyerCache::new(
        return Err("meta_dir_ptr is null".to_string());
    let meta_dir = std::str::from_utf8(std::slice::from_raw_parts(
    }
/// Returns `0` on success, `< 0` if `ptr` is invalid.
    ))
/// # Safety
    }
        io_engine,
    data_block_size_bytes: u64,
pub unsafe extern "C" fn foyer_update_sweep_interval(ptr: i64, new_secs: u64) -> i64 {
    if ptr <= 0 {
///
    sweep_interval_secs: u64,
    // Borrow the Box<Arc<dyn BlockCache>> without consuming it.
/// uses AdmitAll reinsertion so that metadata entries are never evicted.
/// # Safety
///
}
}
    .map_err(|e| format!("invalid UTF-8 in data_dir path: {}", e))?;
        meta_disk_bytes as usize,
    // Shared params
 * The OpenSearch Contributors require contributions made to
///
        data_block_size_bytes as usize,
    let boxed = &*(ptr as *const Arc<dyn crate::traits::BlockCache>);
pub unsafe extern "C" fn foyer_clear_cache(ptr: i64) -> i64 {
#[ffm_safe]
    meta_block_size_bytes: u64,
use native_bridge_common::ffm_safe;
    }
///   disabled (always sweep). Maps to `block_cache.foyer.key_index_sweep_threshold`.
        meta_dir_ptr,
    meta_disk_bytes: u64,
    buffer_pool_size_bytes: u64,
    }
pub unsafe extern "C" fn foyer_create_tiered_cache(
        let meta_stats = tiered.metadata_cache().stats.snapshot();
/// | +9     | `active_in_bytes`  |
        // Single-tier: overall and block_level are identical.
        let single = foyer.stats.snapshot();
/// as it clears the key index and the underlying Foyer cache in one operation.
}
/// `block_cache.foyer.key_index_sweep_threshold` is changed via the cluster settings API.
#[no_mangle]
        // Tiered: indices 0-9 = data cache stats, indices 10-19 = metadata cache stats.
/// - `new_ratio` — new threshold ratio in `[0.0, 1.0]`. `0.0` = always sweep.
    for (i, &v) in flat.iter().enumerate() {
    let prefix = unsafe {
/// Create a [`FoyerCache`] and return an opaque `Box<Arc<dyn BlockCache>>` fat pointer as `i64`.
/// Equivalent to calling `evict_prefix` with an empty prefix, but more efficient
    Ok(Box::into_raw(Box::new(cache)) as i64)
        data_disk_bytes as usize,
/// - `data_*` — parameters for the data cache (large SSD, normal eviction).
/// - `sweep_interval_secs` — background key_index sweep interval in seconds. `0` = disabled
/// | +3     | `miss_bytes`       |
    Ok(Box::into_raw(Box::new(cache)) as i64)
/// | +8     | `removed_bytes`    |
///
#[ffm_safe]
        let bytes = std::slice::from_raw_parts(prefix_ptr, prefix_len as usize);
    if meta_dir_ptr.is_null() {
/// - `ptr` — the cache handle returned by [`foyer_create_cache`].
        return Err(format!("foyer_update_sweep_interval: invalid ptr {}", ptr));
}
pub unsafe extern "C" fn foyer_create_cache(
    };
        meta_dir_len as usize,
pub unsafe extern "C" fn foyer_destroy_cache(ptr: i64) -> i64 {
#[no_mangle]
        "auto"
    if prefix_ptr.is_null() {
    Ok(0)
#[no_mangle]
    let data_cache = Arc::new(FoyerCache::new(
        .unwrap_or("auto")
        return Err(format!("foyer_clear_cache: invalid ptr {}", ptr));
        persist_interval_secs,
    // Build data cache (default reinsertion = RejectAll)
        io_engine,
        Arc::new(TieredBlockCache::new(data_cache, metadata_cache));
///
        std::str::from_utf8(std::slice::from_raw_parts(
    let boxed = unsafe { &*(ptr as *const Arc<dyn crate::traits::BlockCache>) };
        persist_interval_secs,
pub unsafe extern "C" fn foyer_update_persist_interval(ptr: i64, new_secs: u64) -> i64 {
    } else if let Some(tiered) = boxed.as_any().downcast_ref::<TieredBlockCache>() {
        foyer.clear_sync();
///   sweep. When the ratio is below this value the sweep tick is skipped (no-op). `0.0` =
            io_engine_len as usize,
/// # Returns
///
    data_buffer_pool_size_bytes: u64,
        return Err("foyer_update_persist_interval: downcast failed".to_string());
        false, // reinsertion_admit_all = false (RejectAll)
        data_buffer_pool_size_bytes as usize,
/// - `out` must point to a writable buffer of at least **20** `i64` values.
    // Parse data dir
            ptr
    // Parse io_engine
        data_submit_queue_size_threshold_bytes as usize,
/// # Safety
#[ffm_safe]
#[ffm_safe]
    let data_dir = std::str::from_utf8(std::slice::from_raw_parts(
        ptr as *mut Arc<dyn crate::traits::BlockCache>,
    let io_engine = if io_engine_ptr.is_null() {
        return Err("foyer_evict_prefix: null prefix_ptr".to_string());
        dir,
    let mut flat = [0i64; 20];
/// Destroy a cache previously created by [`foyer_create_cache`].
        submit_queue_size_threshold_bytes as usize,
 */
/// Two consecutive 10-value sections:
            io_engine_ptr,
        let data_stats = tiered.data_cache().stats.snapshot();
#[no_mangle]
        sweep_threshold_ratio,
    // Build metadata cache (same LRU as data cache — separate SSD prevents
/// All `*_ptr` parameters must point to `*_len` consecutive valid UTF-8 bytes.
    Ok(0)
#[no_mangle]
    }
    } else {
        flat[10..].copy_from_slice(&single);
 * SPDX-License-Identifier: Apache-2.0
///
    sweep_interval_secs: u64,
#[ffm_safe]
        sweep_threshold_ratio,
 *
/// `ptr` must be a valid handle from [`foyer_create_cache`], not yet destroyed.
///
///
    io_engine_len: u64,
    io_engine_len: u64,
