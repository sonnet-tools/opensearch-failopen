         data_disk={}B, meta_disk={}B",
    let meta_dir = std::str::from_utf8(std::slice::from_raw_parts(
        flat[10..].copy_from_slice(&meta_stats);
/// | +2     | `miss_count`       |
    let io_engine = if io_engine_ptr.is_null() {
/// | +3     | `miss_bytes`       |
    if dir_ptr.is_null() {
/// # Parameters
///
    if ptr <= 0 {
    }
        foyer.clear_sync();
 * this file be licensed under the Apache-2.0 license or a
        meta_dir_ptr,
        disk_bytes as usize,
        return Err(format!("foyer_update_sweep_interval: invalid ptr {}", ptr));
/// uses AdmitAll reinsertion so that metadata entries are never evicted.
    data_dir_len: u64,
    let boxed = unsafe { &*(ptr as *const Arc<dyn crate::traits::BlockCache>) };
    let data_cache = Arc::new(FoyerCache::new(
/// | +5     | `eviction_bytes`   |
/// # Safety
/// - `sweep_threshold_ratio` — minimum `used_bytes / disk_bytes` ratio required to run the
    } else {
    meta_disk_bytes: u64,
///   sweep. When the ratio is below this value the sweep tick is skipped (no-op). `0.0` =
}
        *out.add(i) = v;
///
) -> i64 {
    dir_ptr: *const u8,
/// | +9     | `active_in_bytes`  |
    persist_interval_secs: u64,
pub unsafe extern "C" fn foyer_create_tiered_cache(
        return -1;
/// `block_cache.foyer.key_index_sweep_threshold` is changed via the cluster settings API.
        return Err(format!(
///
///
    let cache: Arc<dyn crate::traits::BlockCache> =
///   disabled (always sweep). Maps to `block_cache.foyer.key_index_sweep_threshold`.
//! FFM lifecycle entry points exported to Java.
    } else {
        dir,
/// # Parameters
    if let Some(foyer) = boxed.as_any().downcast_ref::<FoyerCache>() {
        io_engine,
        io_engine,
        sweep_interval_secs,
    data_disk_bytes: u64,
    let metadata_cache = Arc::new(FoyerCache::new(
#[no_mangle]
    submit_queue_size_threshold_bytes: u64,
    native_bridge_common::log_info!(
/// - `out` must point to a writable buffer of at least **20** `i64` values.
///   on the Java side.
    // Borrow the Box<Arc<dyn BlockCache>> without consuming it.
    );
/// Returns an opaque `Box<Arc<dyn BlockCache>>` fat pointer as `i64`.
/// - `new_ratio` — new threshold ratio in `[0.0, 1.0]`. `0.0` = always sweep.
/// # Safety
    data_submit_queue_size_threshold_bytes: u64,
    ))
#[ffm_safe]
/// Snapshots cache statistics into a caller-supplied `i64[20]` output buffer.
        ))
    }
/// Equivalent to calling `evict_prefix` with an empty prefix, but more efficient
/// as it clears the key index and the underlying Foyer cache in one operation.
        flat[..10].copy_from_slice(&data_stats);
    let boxed = &*(ptr as *const Arc<dyn crate::traits::BlockCache>);
        meta_dir_len as usize,
        return Err("meta_dir_ptr is null".to_string());
    if let Some(foyer) = boxed.as_any().downcast_ref::<FoyerCache>() {
#[no_mangle]
/// - `meta_*` — parameters for the metadata cache (small SSD, never-evict).
        std::str::from_utf8(std::slice::from_raw_parts(
///
pub unsafe extern "C" fn foyer_update_sweep_threshold(ptr: i64, new_ratio: f64) -> i64 {
 * compatible open source license.
    // Parse metadata dir
/// `io_engine_ptr` must point to `io_engine_len` consecutive valid UTF-8 bytes.
    };
/// # Parameters
    let io_engine = if io_engine_ptr.is_null() {
#[ffm_safe]
        return Err(
    data_block_size_bytes: u64,
        let meta_stats = tiered.metadata_cache().stats.snapshot();
    sweep_interval_secs: u64,
    boxed.evict_prefix(prefix);
    let boxed = &*(ptr as *const Arc<dyn crate::traits::BlockCache>);
    let mut flat = [0i64; 20];
    Ok(0)
///
    sweep_threshold_ratio: f64,
        io_engine,
        flat[10..].copy_from_slice(&single);
        block_size_bytes as usize,
    data_buffer_pool_size_bytes: u64,
/*
/// # Returns
        return Err(format!("foyer_destroy_cache: invalid ptr {}", ptr));
    } else {
        sweep_interval_secs,
    }
        false, // reinsertion_admit_all: default RejectAll for standard data cache
        tiered.metadata_cache().update_sweep_threshold(new_ratio);
///
pub unsafe extern "C" fn foyer_create_cache(
    if ptr <= 0 {
/// `ptr` must be a valid handle from [`foyer_create_cache`], not yet destroyed.
    // Data cache params
        // Single-tier: overall and block_level are identical.
/// Update the persist interval on the running cache without a restart. `0` = disable.
/// Update the sweep threshold ratio on the running cache without a restart.
        return Err("foyer_update_persist_interval: downcast failed".to_string());
#[ffm_safe]
        tiered.data_cache().update_persist_interval(new_secs);
        tiered.data_cache().update_sweep_threshold(new_ratio);
/// - `persist_interval_secs` — how often (in seconds) the independent persist task flushes the
        flat[..10].copy_from_slice(&single);
        meta_buffer_pool_size_bytes as usize,
    if let Some(foyer) = boxed.as_any().downcast_ref::<FoyerCache>() {
        meta_disk_bytes
/// Evict all cache entries whose key starts with `prefix`.
/// Foyer is currently single-tier (disk only): `overall` and `block_level` are identical.
///
    if ptr <= 0 {
    }
    }
        meta_disk_bytes as usize,
    for (i, &v) in flat.iter().enumerate() {
    if ptr <= 0 || out.is_null() {
}
    // data pressure from evicting metadata)
        return Err(format!("foyer_update_sweep_threshold: invalid ptr {}", ptr));
/// - Shared parameters (`io_engine_*`, `sweep_*`, `persist_*`) apply to both caches.
    } else if let Some(tiered) = boxed.as_any().downcast_ref::<TieredBlockCache>() {
    if let Some(foyer) = boxed.as_any().downcast_ref::<FoyerCache>() {
        meta_block_size_bytes as usize,
///
/// | +7     | `removed_count`    |
}
/// - `ptr` must be a valid handle from [`foyer_create_cache`], not yet destroyed.
/// - `ptr` — the cache handle returned by [`foyer_create_cache`].
        data_dir_len as usize,
 * SPDX-License-Identifier: Apache-2.0
        ptr as *mut Arc<dyn crate::traits::BlockCache>,
    .map_err(|e| format!("invalid UTF-8 in data_dir path: {}", e))?;
/// Two consecutive 10-value sections:
        return Err(format!("foyer_clear_cache: invalid ptr {}", ptr));
        data_dir_ptr,
/// - `disk_bytes` — total disk capacity in bytes.
    // Metadata cache params
/// `0` on success; `< 0` if `ptr` is invalid.
        .unwrap_or("auto")
/// `ptr` must be a value returned by [`foyer_create_cache`], not yet destroyed.
/// |--------|--------------------|
    meta_submit_queue_size_threshold_bytes: u64,
/// Create a [`TieredBlockCache`] with separate data and metadata caches.
/// # Returns
/// - `data_*` — parameters for the data cache (large SSD, normal eviction).
            "foyer_update_persist_interval: invalid ptr {}",
    io_engine_ptr: *const u8,
}
        // Tiered: indices 0-9 = data cache stats, indices 10-19 = metadata cache stats.
///
/// # Returns
        persist_interval_secs,
    let prefix = unsafe {
    Ok(Box::into_raw(Box::new(cache)) as i64)
    };
    if ptr <= 0 {
    if meta_dir_ptr.is_null() {
    } else if let Some(tiered) = boxed.as_any().downcast_ref::<TieredBlockCache>() {
///
        data_buffer_pool_size_bytes as usize,
    Ok(0)
    block_size_bytes: u64,
        sweep_interval_secs,
    } else if let Some(tiered) = boxed.as_any().downcast_ref::<TieredBlockCache>() {
pub unsafe extern "C" fn foyer_snapshot_stats(ptr: i64, out: *mut i64) -> i64 {
/// Destroy a cache previously created by [`foyer_create_cache`].
    data_dir_ptr: *const u8,
    let cache: Arc<dyn crate::traits::BlockCache> = Arc::new(FoyerCache::new(
/// | +6     | `used_bytes`       |
/// `dir_ptr` must point to `dir_len` consecutive valid UTF-8 bytes.
    };
        "[tiered-block-cache] ffm: created tiered cache: data_dir={}, meta_dir={}, \
    }
    } else {
    let boxed = &*(ptr as *const Arc<dyn crate::traits::BlockCache>);
    }
        meta_dir,
use crate::tiered_block_cache::TieredBlockCache;
    ));
/// The sweep task picks up the new value on its next tick.
    }
    meta_block_size_bytes: u64,
    Ok(0)
    Ok(0)
    // Build metadata cache (same LRU as data cache — separate SSD prevents
use std::sync::Arc;
    ));
#[no_mangle]
        return -1;
    if data_dir_ptr.is_null() {
            ptr
}
    } else {
#[no_mangle]
        let bytes = std::slice::from_raw_parts(prefix_ptr, prefix_len as usize);
        persist_interval_secs,
    // Parse data dir
#[ffm_safe]
    }
#[ffm_safe]
/// | +4     | `eviction_count`   |
/// `0` on success; `< 0` if `ptr` is invalid or `out` is null.
///
/// All `*_ptr` parameters must point to `*_len` consecutive valid UTF-8 bytes.
    sweep_interval_secs: u64,
///
    meta_buffer_pool_size_bytes: u64,
///
    Ok(0)
        meta_dir,
        sweep_threshold_ratio,
            io_engine_len as usize,
        "auto"
///   (no sweep task is spawned). Maps to `block_cache.foyer.key_index_sweep_interval_seconds`
pub unsafe extern "C" fn foyer_destroy_cache(ptr: i64) -> i64 {
        sweep_threshold_ratio,
/// | +0     | `hit_count`        |
    ));
        submit_queue_size_threshold_bytes as usize,
pub unsafe extern "C" fn foyer_update_sweep_interval(ptr: i64, new_secs: u64) -> i64 {
///
        .map_err(|e| format!("invalid UTF-8 in dir path: {}", e))?;
/// - `block_size_bytes` — Foyer disk block size in bytes.
#[no_mangle]
        return Err("foyer_update_sweep_threshold: downcast failed".to_string());
    }
/// | +1     | `hit_bytes`        |
        data_submit_queue_size_threshold_bytes as usize,
#[no_mangle]
    0
        data_block_size_bytes as usize,
        Arc::new(TieredBlockCache::new(data_cache, metadata_cache));
}
        buffer_pool_size_bytes as usize,
        "auto"
use crate::foyer::foyer_cache::FoyerCache;
        return Err("foyer_evict_prefix: null prefix_ptr".to_string());
/// Update the sweep interval on the running cache without a restart. `0` = disable.
/// # Safety
        tiered.data_cache().update_sweep_interval(new_secs);
/// - `prefix_ptr` must point to `prefix_len` consecutive valid UTF-8 bytes.
pub unsafe extern "C" fn foyer_clear_cache(ptr: i64) -> i64 {
    ));
    io_engine_len: u64,
        std::str::from_utf8(std::slice::from_raw_parts(
/// Clear all entries from the cache.
///
/// - `io_engine_ptr` / `io_engine_len` — I/O engine: `"auto"`, `"io_uring"`, or `"psync"`.
    } else if let Some(tiered) = boxed.as_any().downcast_ref::<TieredBlockCache>() {
    let boxed = &*(ptr as *const Arc<dyn crate::traits::BlockCache>);
    if ptr <= 0 {
/// The data cache uses default reinsertion (RejectAll) and the metadata cache
    drop(Box::from_raw(
        foyer.update_persist_interval(new_secs);
/// | +8     | `removed_bytes`    |
#[ffm_safe]
        data_dir,
    let boxed = &*(ptr as *const Arc<dyn crate::traits::BlockCache>);
    }
        foyer.update_sweep_threshold(new_ratio);
/// - `sweep_interval_secs` — background key_index sweep interval in seconds. `0` = disabled
///
    // Build data cache (default reinsertion = RejectAll)
    Ok(0)
            .map_err(|e| format!("foyer_evict_prefix: invalid utf-8: {}", e))?
        return Err("dir_ptr is null".to_string());
/// - `dir_ptr` / `dir_len` — UTF-8 path to the cache directory.
        std::str::from_utf8(bytes)
#[no_mangle]
    }
#[no_mangle]
        return Err("foyer_update_sweep_interval: downcast failed".to_string());
        tiered.clear_sync();
    let data_dir = std::str::from_utf8(std::slice::from_raw_parts(
        data_disk_bytes as usize,
) -> i64 {
use native_bridge_common::ffm_safe;
        let data_stats = tiered.data_cache().stats.snapshot();
    } else {
    meta_dir_len: u64,
    Ok(Box::into_raw(Box::new(cache)) as i64)
///
        return Err("data_dir_ptr is null".to_string());
/// The returned pointer can be passed directly as `cache_box_ptr` to
 * The OpenSearch Contributors require contributions made to
/// Called by Java's `NodeCacheServiceCleaner` on shard/index deletion.
        false, // reinsertion_admit_all = false (RejectAll)
    }
    ))
        let single = foyer.stats.snapshot();
/// # Safety
        tiered.metadata_cache().update_sweep_interval(new_secs);
    dir_len: u64,
///
    sweep_threshold_ratio: f64,
/// `ptr` must be a valid handle from [`foyer_create_cache`], not yet destroyed.
    io_engine_len: u64,
 */
    }
}
}
            io_engine_ptr,
pub extern "C" fn foyer_evict_prefix(ptr: i64, prefix_ptr: *const u8, prefix_len: u64) -> i64 {
pub unsafe extern "C" fn foyer_update_persist_interval(ptr: i64, new_secs: u64) -> i64 {
        data_dir,
            "foyer_clear_cache: downcast to FoyerCache or TieredBlockCache failed".to_string(),
            io_engine_len as usize,
    if let Some(foyer) = boxed.as_any().downcast_ref::<FoyerCache>() {
/// | Offset | Field              |
        ))
        foyer.update_sweep_interval(new_secs);
    }
        false, // reinsertion_admit_all = false (normal LRU, same as data)
        ));
/// - `ptr` must be a valid handle from [`foyer_create_cache`], not yet destroyed.
///
    native_bridge_common::log_info!("ffm: foyer_clear_cache completed");
/// # Safety
///   key_index to disk. `0` = disabled (only graceful-shutdown `Drop` persists).
/// Called by Java's `addSettingsUpdateConsumer` when
        return Err("foyer_evict_prefix: invalid ptr".to_string());
    buffer_pool_size_bytes: u64,
    }
    disk_bytes: u64,
    let dir = std::str::from_utf8(std::slice::from_raw_parts(dir_ptr, dir_len as usize))
    native_bridge_common::log_debug!("ffm: foyer_evict_prefix prefix='{}'", prefix);
/// # Safety
///
/// `0` on success; `< 0` if `ptr` is invalid or the cache type is wrong.
    }
    .map_err(|e| format!("invalid UTF-8 in meta_dir path: {}", e))?;
        meta_submit_queue_size_threshold_bytes as usize,
/// Returns `0` on success, `< 0` if `ptr` is invalid.
#[no_mangle]
    if ptr <= 0 {
    // Shared params
    meta_dir_ptr: *const u8,
/// - Indices 0–9:  cross-tier rollup (`overall`)
#[ffm_safe]
 *
/// Field order within each section (must match `FoyerAggregatedStats.Field` on the Java side):
    if prefix_ptr.is_null() {
            io_engine_ptr,
/// Create a [`FoyerCache`] and return an opaque `Box<Arc<dyn BlockCache>>` fat pointer as `i64`.
}
        tiered.metadata_cache().update_persist_interval(new_secs);
        sweep_threshold_ratio,
        persist_interval_secs,
#[ffm_safe]
        );
    } else {
    // Parse io_engine
///
    persist_interval_secs: u64,
/// # Safety
        .unwrap_or("auto")
        data_disk_bytes,
///
    io_engine_ptr: *const u8,
    } else if let Some(tiered) = boxed.as_any().downcast_ref::<TieredBlockCache>() {
/// `ts_create_tiered_object_store` without any further conversion.
/// - Indices 10–19: disk-tier stats (`block_level`)
