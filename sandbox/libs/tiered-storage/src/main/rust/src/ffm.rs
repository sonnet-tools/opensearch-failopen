    if tiered_store_ptr == NULL_PTR {
/// `ts_destroy_object_store_box_ptr`.
        // across multiple shards. Clone the Arc out of the Box without taking ownership.
/// Create a [`TieredObjectStore`] with optional local and remote object stores.
#[ffm_safe]
    store.evict_path(path);
        return Err("null string pointer".to_string());
#[no_mangle]
    if lines.len() < expected {
        "ffm: ts_register_files count={}, location={}",
            lines.len()
    unsafe { Arc::increment_strong_count(tiered_store_ptr as *const TieredObjectStore) };
/// `location`: 0=Local, 1=Remote — applied to all files in the batch.
/// stores, Java passes 0 and DataFusion uses absolute paths to resolve files.
use crate::types::FileLocation;
        let cache_box = unsafe { &*(cache_box_ptr as *const Arc<dyn BlockCache>) };
/// Destroy a [`TieredObjectStore`].
        registry.register(path, entry);
#[ffm_safe]
///
/// Create a `TieredObjectStore` with optional local and remote stores.
#[no_mangle]
        *unsafe { Box::from_raw(local_store_box_ptr as *mut Arc<dyn ObjectStore>) }
/// Remove a file from the registry.
        return Err("null store pointer (0)".to_string());
use object_store::ObjectStore;
    // Coerce to MetadataCachingStore trait object and box it
/// Decode a UTF-8 string from a raw pointer and length.
 * this file be licensed under the Apache-2.0 license or a
        let remote_arc: Option<Arc<str>> = if remote_path_str.is_empty() {
/// `ts_get_object_store_box_ptr`. Drops the Box and decrements the Arc strong count.
    // Strip leading "/" — object_store::Path normalizes paths without leading slash
    let file_location = FileLocation::from_u8(location as u8)
/// Destroy a `Box<Arc<dyn MetadataCachingStore>>` pointer returned by
        // IMPORTANT: Do NOT consume the Box — the pointer is node-level and shared
/// Returns a `Box<Arc<dyn MetadataCachingStore>>` pointer from an existing TieredObjectStore
///
    native_bridge_common::log_info!(
// ---------------------------------------------------------------------------
    if remote_store_box_ptr != NULL_PTR {
    }
            Some(Arc::from(remote_path_str))
    }
    let mut store = TieredObjectStore::new(file_registry, local);
/*
/// `entries_ptr`/`entries_len`: UTF-8 string with newline-delimited pairs:
        .map_err(|e| format!("ts_register_files entries: {}", e))?;
///   If 0, creates a default `LocalFileSystem::new()`.
pub extern "C" fn ts_remove_file(store_ptr: i64, path_ptr: *const u8, path_len: i64) -> i64 {
        .map_err(|e| format!("ts_remove_file path: {}", e))?;
    let registry = store.registry();
#[ffm_safe]
        file_location
    let raw = ptr as *const TieredObjectStore;
// ---------------------------------------------------------------------------
        "ffm: ts_create_tiered_object_store cache_wired={}",
    store.registry().remove(path, false);
pub extern "C" fn ts_register_files(
///   node lifetime). If 0, no block cache is attached.
/// Each triplet is (path, remotePath, size). For Local files, remotePath can be empty.
    let path = unsafe { str_from_raw(path_ptr, path_len) }
    }
    let _store = unsafe { Arc::from_raw(ptr as *const TieredObjectStore) };
unsafe fn arc_from_ptr(ptr: i64) -> Result<Arc<TieredObjectStore>, String> {
    if ptr == NULL_PTR {
    let expected = (count as usize) * 3;
/// `count`: number of file triplets (entries_len contains 3*count lines).
        let remote_box = unsafe { &*(remote_store_box_ptr as *const Arc<dyn ObjectStore>) };
    Ok(0)
        return Err(format!("negative string length: {}", len));
 * SPDX-License-Identifier: Apache-2.0
    let entries_str = unsafe { str_from_raw(entries_ptr, entries_len) }
/// methods remain available; in addition, callers can invoke `put_metadata` to promote bytes
unsafe fn str_from_raw<'a>(ptr: *const u8, len: i64) -> Result<&'a str, String> {
        } else {
    }
///
    );
// ---------------------------------------------------------------------------
    }
/// consuming ownership. Increments the strong count so the caller's
    let store = unsafe { arc_from_ptr(store_ptr) }?;
}
            count,
    native_bridge_common::log_debug!("ffm: ts_remove_file path='{}'", path);
///
        let remote_arc = Arc::clone(remote_box);
/// Reconstruct an `Arc<TieredObjectStore>` from a raw pointer without
pub extern "C" fn ts_create_tiered_object_store(
// TODO (writable warm): add ts_register_file for single-file registration (afterSyncToRemote).
}
}
        let size_str = lines[i * 3 + 2];
        cache_box_ptr != NULL_PTR
    let ptr = Box::into_raw(boxed) as i64;
    let file_registry = Arc::new(TieredStorageRegistry::new());
// TODO (writable warm): add ts_add_remote_store_ptr for late-binding remote store.
///
}
        let size: u64 = size_str.parse().unwrap_or(0);
        return Err("ts_get_object_store_box_ptr: null pointer".to_string());
        };
        let path = path.strip_prefix('/').unwrap_or(path);
    }
    let _boxed = unsafe { Box::from_raw(ptr as *mut Arc<dyn MetadataCachingStore>) };
#[no_mangle]
}
// File registry operations via TieredObjectStore pointer
 *
    Ok(ptr)
/// Batch register files in the TieredObjectStore's registry.
    native_bridge_common::log_info!("ffm: ts_destroy_object_store_box_ptr: ok");
pub extern "C" fn ts_destroy_tiered_object_store(ptr: i64) -> i64 {
#[no_mangle]
/// `Arc<TieredObjectStore>`.
}
/// # Safety
    remote_store_box_ptr: i64,
    }
    let boxed: Box<Arc<dyn MetadataCachingStore>> = Box::new(arc as Arc<dyn MetadataCachingStore>);
/// `ptr` must have been produced by `Arc::into_raw` on a live
use std::sync::Arc;
        return Err("ts_destroy_object_store_box_ptr: null pointer (0)".to_string());
    };
    if ptr.is_null() {
        .ok_or_else(|| format!("ts_register_files: invalid location {}", location))?;
//! created internally — no separate pointers exposed to Java.
use native_bridge_common::ffm_safe;
mod tests;
    native_bridge_common::log_info!("ffm: ts_destroy_tiered_object_store: ok");
    str::from_utf8(bytes).map_err(|e| format!("invalid UTF-8: {}", e))
        let remote_path_str = lines[i * 3 + 1];
    let local: Arc<dyn ObjectStore> = if local_store_box_ptr != NULL_PTR {
    for i in 0..(count as usize) {
/// # Safety
        let path = lines[i * 3];
    store_ptr: i64,
    } else {
        let entry = crate::types::TieredFileEntry::with_size(file_location, remote_arc, size);
use std::slice;
///
    Ok(ptr)
    let lines: Vec<&str> = entries_str.split('\n').collect();
/// `local_store_box_ptr=0` creates a default `LocalFileSystem`. For per-shard
 * The OpenSearch Contributors require contributions made to
    // Increment strong count so we don't consume the original Arc
/// into the never-evict metadata tier.
        // Strip leading "/" — object_store::Path normalizes paths without leading slash
/// - `cache_box_ptr`: if non-zero, a `Box<Arc<dyn BlockCache>>` pointer from a block cache
///   plugin. The Arc is cloned (ownership is NOT taken — the pointer remains valid for other
) -> i64 {
    if cache_box_ptr != NULL_PTR {
#[path = "ffm_tests.rs"]
        store = store.with_cache(Arc::clone(cache_box));
        native_bridge_common::log_info!("ffm: ts_create_tiered_object_store: block cache wired");
use crate::tiered_object_store::{MetadataCachingStore, TieredObjectStore};
        return Err("ts_destroy_tiered_object_store: null pointer (0)".to_string());
///
/// Also drops the internally-owned `TieredStorageRegistry`.
const NULL_PTR: i64 = 0;
/// fat pointer to the trait object. `MetadataCachingStore: ObjectStore`, so all `ObjectStore`
///
    location: i32,
use std::str;
    if len < 0 {
    }
    Ok(0)
    cache_box_ptr: i64,
///   plugin. The Arc is cloned (ownership is NOT taken — the pointer remains valid for the
#[no_mangle]
 */
pub extern "C" fn ts_get_object_store_box_ptr(tiered_store_ptr: i64) -> i64 {
    let bytes = slice::from_raw_parts(ptr, len as usize);
    );
            None
    let ptr = Arc::into_raw(Arc::new(store)) as i64;
/// Each call creates a new Box with its own Arc clone — caller must free with
    let path = path.strip_prefix('/').unwrap_or(path);
    entries_ptr: *const u8,
        store.set_remote(remote_arc);
        unsafe { Arc::from_raw(tiered_store_ptr as *const TieredObjectStore) };
            "ts_register_files: expected {} lines ({}*3) but got {}",
) -> i64 {
 * compatible open source license.
    let arc: Arc<TieredObjectStore> =
    native_bridge_common::log_info!("ffm: ts_get_object_store_box_ptr: ok");
    native_bridge_common::log_debug!(
//! FFM bridge for tiered storage.
}
    count: i32,
        Arc::new(object_store::local::LocalFileSystem::new())
/// Arc pointer. This is the format that `df_create_reader` and warmup paths expect — a boxed
    let store = unsafe { arc_from_ptr(store_ptr) }?;
    if ptr == NULL_PTR {
        count,
}
    if ptr == NULL_PTR {
/// - `local_store_box_ptr`: if non-zero, a `Box<Arc<dyn ObjectStore>>` pointer for local I/O.
    }
        return Err(format!(
// ---------------------------------------------------------------------------
#[ffm_safe]
// Public FFM exports
pub extern "C" fn ts_destroy_object_store_box_ptr(ptr: i64) -> i64 {
    }
    Ok(Arc::from_raw(raw))
/// - `remote_store_box_ptr`: if non-zero, a `Box<Arc<dyn ObjectStore>>` pointer from a repository
// TODO (writable warm): add ts_get_file_location when LOCAL routing is needed.
    entries_len: i64,
use crate::registry::FileRegistry;
    local_store_box_ptr: i64,
//!
/// copy remains valid.
use crate::registry::TieredStorageRegistry;
#[ffm_safe]
    Ok(0)
#[ffm_safe]
/// The caller must ensure `ptr` points to `len` valid UTF-8 bytes.
    Ok(0)
/// Register a file in the TieredObjectStore's registry.
        ));
use opensearch_block_cache::traits::BlockCache;
#[cfg(test)]
//! `TieredStorageRegistry` (file registry) and local `ObjectStore` are
            expected,
///   shards). If 0, no remote store.
/// `"path1\nremotePath1\nsize1\npath2\nremotePath2\nsize2\n..."`.
    Arc::increment_strong_count(raw);
#[no_mangle]
