pub extern "C" fn ts_destroy_object_store_box_ptr(ptr: i64) -> i64 {
        return Err("ts_destroy_tiered_object_store: null pointer (0)".to_string());
        store.set_remote(remote_arc);
    cache_box_ptr: i64,
        return Err(format!("negative string length: {}", len));
    if len < 0 {
/// Arc pointer. This is the format that `df_create_reader` and warmup paths expect — a boxed
// ---------------------------------------------------------------------------
            lines.len()
            Some(Arc::from(remote_path_str))
//! created internally — no separate pointers exposed to Java.
///
/// The caller must ensure `ptr` points to `len` valid UTF-8 bytes.
    );
        .map_err(|e| format!("ts_register_files entries: {}", e))?;
        registry.register(path, entry);
    count: i32,
    }
        return Err(format!(
    let store = unsafe { arc_from_ptr(store_ptr) }?;
    Ok(0)
        // IMPORTANT: Do NOT consume the Box — the pointer is node-level and shared
        let remote_path_str = lines[i * 3 + 1];
///
    let bytes = slice::from_raw_parts(ptr, len as usize);
 * this file be licensed under the Apache-2.0 license or a
///
pub extern "C" fn ts_get_object_store_box_ptr(tiered_store_ptr: i64) -> i64 {
            "ts_register_files: expected {} lines ({}*3) but got {}",
/// - `local_store_box_ptr`: if non-zero, a `Box<Arc<dyn ObjectStore>>` pointer for local I/O.
 *
    }
use std::sync::Arc;
use crate::registry::FileRegistry;
    // Coerce to MetadataCachingStore trait object and box it
///   plugin. The Arc is cloned (ownership is NOT taken — the pointer remains valid for the
        ));
        let size: u64 = size_str.parse().unwrap_or(0);
/// Create a [`TieredObjectStore`] with optional local and remote object stores.
    if lines.len() < expected {
    let lines: Vec<&str> = entries_str.split('\n').collect();
    let raw = ptr as *const TieredObjectStore;
    let expected = (count as usize) * 3;
    // Increment strong count so we don't consume the original Arc
    let ptr = Box::into_raw(boxed) as i64;
use object_store::ObjectStore;
#[ffm_safe]
/// # Safety
use crate::registry::TieredStorageRegistry;
pub extern "C" fn ts_register_files(
) -> i64 {
    unsafe { Arc::increment_strong_count(tiered_store_ptr as *const TieredObjectStore) };
    let path = unsafe { str_from_raw(path_ptr, path_len) }
/// `local_store_box_ptr=0` creates a default `LocalFileSystem`. For per-shard
#[no_mangle]
// ---------------------------------------------------------------------------
/// `count`: number of file triplets (entries_len contains 3*count lines).
mod tests;
    let path = path.strip_prefix('/').unwrap_or(path);
use crate::tiered_object_store::{MetadataCachingStore, TieredObjectStore};
// TODO (writable warm): add ts_get_file_location when LOCAL routing is needed.
    native_bridge_common::log_debug!(
#[ffm_safe]
/// `ts_destroy_object_store_box_ptr`.
/// stores, Java passes 0 and DataFusion uses absolute paths to resolve files.
    }
        let remote_arc = Arc::clone(remote_box);
        "ffm: ts_register_files count={}, location={}",
    if remote_store_box_ptr != NULL_PTR {
        // Strip leading "/" — object_store::Path normalizes paths without leading slash
use opensearch_block_cache::traits::BlockCache;
) -> i64 {
    Ok(0)
//! `TieredStorageRegistry` (file registry) and local `ObjectStore` are
    Ok(Arc::from_raw(raw))
        file_location
/// Each call creates a new Box with its own Arc clone — caller must free with
// TODO (writable warm): add ts_register_file for single-file registration (afterSyncToRemote).
    Arc::increment_strong_count(raw);
}
    if ptr.is_null() {
        let path = path.strip_prefix('/').unwrap_or(path);
            None
    let store = unsafe { arc_from_ptr(store_ptr) }?;
        let entry = crate::types::TieredFileEntry::with_size(file_location, remote_arc, size);
    }
pub extern "C" fn ts_create_tiered_object_store(
///
/// fat pointer to the trait object. `MetadataCachingStore: ObjectStore`, so all `ObjectStore`
    store.registry().remove(path, false);
/// Destroy a `Box<Arc<dyn MetadataCachingStore>>` pointer returned by
    };
    let ptr = Arc::into_raw(Arc::new(store)) as i64;
    Ok(ptr)
///
    remote_store_box_ptr: i64,
// ---------------------------------------------------------------------------
use native_bridge_common::ffm_safe;
}
/// - `cache_box_ptr`: if non-zero, a `Box<Arc<dyn BlockCache>>` pointer from a block cache
    if ptr == NULL_PTR {
    }
const NULL_PTR: i64 = 0;
    let registry = store.registry();
    // Strip leading "/" — object_store::Path normalizes paths without leading slash
#[ffm_safe]
/// Reconstruct an `Arc<TieredObjectStore>` from a raw pointer without
        return Err("ts_destroy_object_store_box_ptr: null pointer (0)".to_string());
use std::str;
    if tiered_store_ptr == NULL_PTR {
        let size_str = lines[i * 3 + 2];
}
}
///
    } else {
    location: i32,
        native_bridge_common::log_info!("ffm: ts_create_tiered_object_store: block cache wired");
//! FFM bridge for tiered storage.
    entries_ptr: *const u8,
        .map_err(|e| format!("ts_remove_file path: {}", e))?;
    local_store_box_ptr: i64,
#[cfg(test)]
#[no_mangle]
use std::slice;
/// Register a file in the TieredObjectStore's registry.
/// - `remote_store_box_ptr`: if non-zero, a `Box<Arc<dyn ObjectStore>>` pointer from a repository
/// methods remain available; in addition, callers can invoke `put_metadata` to promote bytes
#[no_mangle]
/// Remove a file from the registry.
/// Batch register files in the TieredObjectStore's registry.
    entries_len: i64,
    native_bridge_common::log_debug!("ffm: ts_remove_file path='{}'", path);
            count,
        let path = lines[i * 3];
///   node lifetime). If 0, no block cache is attached.
    }
    for i in 0..(count as usize) {
        } else {
/// `entries_ptr`/`entries_len`: UTF-8 string with newline-delimited pairs:
    Ok(0)
// Public FFM exports
/// Returns a `Box<Arc<dyn MetadataCachingStore>>` pointer from an existing TieredObjectStore
    str::from_utf8(bytes).map_err(|e| format!("invalid UTF-8: {}", e))
        .ok_or_else(|| format!("ts_register_files: invalid location {}", location))?;
#[no_mangle]
    native_bridge_common::log_info!("ffm: ts_destroy_tiered_object_store: ok");
    Ok(0)
}
unsafe fn str_from_raw<'a>(ptr: *const u8, len: i64) -> Result<&'a str, String> {
    }
        cache_box_ptr != NULL_PTR
/// Decode a UTF-8 string from a raw pointer and length.
        let remote_arc: Option<Arc<str>> = if remote_path_str.is_empty() {
    let entries_str = unsafe { str_from_raw(entries_ptr, entries_len) }
        *unsafe { Box::from_raw(local_store_box_ptr as *mut Arc<dyn ObjectStore>) }
///
/// Also drops the internally-owned `TieredStorageRegistry`.
/// `location`: 0=Local, 1=Remote — applied to all files in the batch.
        // across multiple shards. Clone the Arc out of the Box without taking ownership.
    if cache_box_ptr != NULL_PTR {
            expected,
#[ffm_safe]
    store.evict_path(path);
#[ffm_safe]
/// `ts_get_object_store_box_ptr`. Drops the Box and decrements the Arc strong count.
}
}
//!
        let remote_box = unsafe { &*(remote_store_box_ptr as *const Arc<dyn ObjectStore>) };
        Arc::new(object_store::local::LocalFileSystem::new())
        return Err("null store pointer (0)".to_string());
    let mut store = TieredObjectStore::new(file_registry, local);
#[path = "ffm_tests.rs"]
#[ffm_safe]
/// Destroy a [`TieredObjectStore`].
    if ptr == NULL_PTR {
    let boxed: Box<Arc<dyn MetadataCachingStore>> = Box::new(arc as Arc<dyn MetadataCachingStore>);
 */
///   shards). If 0, no remote store.
/// `"path1\nremotePath1\nsize1\npath2\nremotePath2\nsize2\n..."`.
    let file_registry = Arc::new(TieredStorageRegistry::new());
        "ffm: ts_create_tiered_object_store cache_wired={}",
    native_bridge_common::log_info!("ffm: ts_get_object_store_box_ptr: ok");
/// `Arc<TieredObjectStore>`.
    }
    let local: Arc<dyn ObjectStore> = if local_store_box_ptr != NULL_PTR {
    }
    Ok(ptr)
/// Each triplet is (path, remotePath, size). For Local files, remotePath can be empty.
/// consuming ownership. Increments the strong count so the caller's
        count,
        return Err("null string pointer".to_string());
    native_bridge_common::log_info!("ffm: ts_destroy_object_store_box_ptr: ok");
/*
    native_bridge_common::log_info!(
/// into the never-evict metadata tier.
        unsafe { Arc::from_raw(tiered_store_ptr as *const TieredObjectStore) };
    let file_location = FileLocation::from_u8(location as u8)
        let cache_box = unsafe { &*(cache_box_ptr as *const Arc<dyn BlockCache>) };
/// Create a `TieredObjectStore` with optional local and remote stores.
    let arc: Arc<TieredObjectStore> =
 * compatible open source license.
}
/// # Safety
    store_ptr: i64,
// File registry operations via TieredObjectStore pointer
use crate::types::FileLocation;
// ---------------------------------------------------------------------------
#[no_mangle]
///   plugin. The Arc is cloned (ownership is NOT taken — the pointer remains valid for other
// TODO (writable warm): add ts_add_remote_store_ptr for late-binding remote store.
#[no_mangle]
        };
///
 * The OpenSearch Contributors require contributions made to
    if ptr == NULL_PTR {
///   If 0, creates a default `LocalFileSystem::new()`.
unsafe fn arc_from_ptr(ptr: i64) -> Result<Arc<TieredObjectStore>, String> {
pub extern "C" fn ts_remove_file(store_ptr: i64, path_ptr: *const u8, path_len: i64) -> i64 {
 * SPDX-License-Identifier: Apache-2.0
    let _store = unsafe { Arc::from_raw(ptr as *const TieredObjectStore) };
/// `ptr` must have been produced by `Arc::into_raw` on a live
    let _boxed = unsafe { Box::from_raw(ptr as *mut Arc<dyn MetadataCachingStore>) };
/// copy remains valid.
pub extern "C" fn ts_destroy_tiered_object_store(ptr: i64) -> i64 {
    }
    );
        store = store.with_cache(Arc::clone(cache_box));
        return Err("ts_get_object_store_box_ptr: null pointer".to_string());
