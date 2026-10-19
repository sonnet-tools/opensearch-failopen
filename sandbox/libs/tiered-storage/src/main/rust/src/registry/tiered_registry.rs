            self.files.retain(|key, _| {
// ---------------------------------------------------------------------------
    }
    }
        let reg = make_registry();
    #[test]
    #[test]
    }
        let entries = reg.entries_matching("data/");
            let mut removed = 0;
        let handles: Vec<_> = (0..num_threads)
        let barrier = Arc::new(Barrier::new(num_threads));
        removed
        // prevents entry-level operations. We need to test differently.
        reg.update("/data/b.parquet", |e| {
/// [`ReadGuard`].
        reg.register("/a.parquet", local_entry());
        assert!(reg.remove("/a.parquet", true));
        }
        });
        if force {
    }
    /// List entries matching `prefix`. Returns `(key, location)`.
use crate::types::{FileLocation, ReadGuard, TieredFileEntry};
        assert_eq!(guard.ref_count(), 1); // Only this guard.
            e.acquire();
            .field("file_count", &self.files.len())
            .map(|_| {
                    barrier.wait();
use std::collections::HashSet;
    }
        Self::new()
    fn test_remove_force_false_zero_refs() {
        reg.register("/a.parquet", both_entry());
            .iter()
            })
            .map(|e| (e.key().clone(), e.value().location(), e.value().size()))
    }
        if removed > 0 {
    #[test]
        assert_eq!(entries2.len(), 2);
    }
                            drop(guard);
                let reg = Arc::clone(&reg);
    }
        drop(g1);
        let prefix = prefix.strip_prefix('/').unwrap_or(prefix);
        // Strip leading "/" — keys are stored without leading slash
// Tests
                .collect();
        assert_eq!(guard.location(), FileLocation::Remote);
            .collect();
            files: DashMap::new(),
        self.files.retain(|key, _| {
        reg.register("other/c.parquet", local_entry());
        assert_eq!(guard2.ref_count(), 1);
    }
impl FileRegistry for TieredStorageRegistry {
        assert_eq!(reg.len(), 1);
impl fmt::Debug for TieredStorageRegistry {
                .iter()
// -- FileRegistry trait impl ------------------------------------------------
        for h in handles {
        assert_eq!(reg.len(), 0);
    fn test_remove_force_true_with_active_refs() {
        });
        if let Some(mut entry) = self.files.get_mut(key) {
    fn default() -> Self {
    }
    // -- Update -------------------------------------------------------------
    fn test_remove_nonexistent() {
        let reg = make_registry();
        } else {
    }
//! check-then-act patterns to prevent TOCTOU races. Atomic operations
        assert_eq!(removed, 2);
pub struct TieredStorageRegistry {
        let guard = reg.get("/a.parquet").unwrap();
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    fn test_register_remote() {
    #[test]
                    true
        let reg = make_registry();
        // All guards dropped, ref count should be 0.
            .collect();
        reg.register("/a.parquet", local_entry());
    use super::*;
        let guard2 = reg.get("/a.parquet").unwrap();
            self.files.remove(key).is_some()
            e.location = FileLocation::Remote;
// TieredFileEntry when eviction lifecycle is needed for the write path.
                thread::spawn(move || {
        drop(guard2);
    fn remote_entry() -> TieredFileEntry {
        drop(_guard);
        let before = self.files.len();
            removed
        TieredFileEntry::new(FileLocation::Remote, Some(Arc::from("remote/a.parquet")))
 */
        reg.register("/other/c.parquet", local_entry());
    fn both_entry() -> TieredFileEntry {
//! # Thread Safety
        let reg = make_registry();
        {
    #[test]
                    }
//! [`TieredStorageRegistry`] — concrete registry for tiered storage.
            e.acquire();
            native_bridge_common::log_info!(
use std::fmt;
        let reg = make_registry();
        let reg = make_registry();
        let barrier = Arc::new(Barrier::new(num_threads));
    fn test_remove_by_prefix_force() {
    }
        assert!(!reg.remove("/nonexistent", false));
        assert!(!reg.remove("/a.parquet", false));
///
        self.files.insert(key.to_string(), value);
    #[test]
                    for j in 0..100 {
    fn get(&self, key: &str) -> Option<ReadGuard<'_>> {
        assert_eq!(reg.len(), 1);
    fn register(&self, key: &str, value: TieredFileEntry) {
    #[test]
        let entry = self.files.get(key)?;
        let reg = make_registry();
    }
        assert!(reg.get("/nonexistent").is_none());
        reg.register("/a.parquet", remote_entry());
        reg.register("/a.parquet", local_entry());
                dashmap::mapref::entry::Entry::Occupied(entry) => {
    // -- Get / ReadGuard ----------------------------------------------------
    fn test_remove_by_prefix_no_force_skips_active() {
        assert_eq!(guard.location(), FileLocation::Remote);
            TieredFileEntry::new(FileLocation::Remote, None),
    // -- Remove by prefix ---------------------------------------------------
    fn test_register_local() {
    #[test]
//!
        assert_eq!(guard.location(), FileLocation::Remote);
    use std::thread;
                    for _ in 0..ops_per_thread {
}
        reg.register("a", local_entry());
 * SPDX-License-Identifier: Apache-2.0
                if key.starts_with(prefix) {
        assert_eq!(entries.len(), 2);
                }
}
        assert_eq!(g2.ref_count(), 2);
            for key in &matching {
    #[test]
    }
// ---------------------------------------------------------------------------
        drop(g2);
                    removed += 1;
        let reg = make_registry();
        // Strip leading "/" — keys are stored without leading slash
        Self {
}
        reg.register("/a.parquet", local_entry());
            match self.files.entry(key.to_string()) {
        reg.update("/a.parquet", |e| {
    use std::sync::Barrier;
                .filter(|e| e.key().starts_with(prefix))
    // -- Concurrency --------------------------------------------------------
                    barrier.wait();
    // -- Remove -------------------------------------------------------------
        let entries2 = reg.entries_matching("/");
    fn test_remove_force_true() {
        reg.register("/a.parquet", local_entry());
impl TieredStorageRegistry {
                .files
    fn test_update_modifies_entry() {
        // Strip leading "/" — keys are stored without leading slash
    }
        let reg = make_registry();
    }
                    }
        self.files.len()
            // Check both with and without leading "/" since callers may pass either form
        let entries = reg.entries_matching("");
    }
        }
            h.join().expect("thread should not panic");
    }
    pub fn entries_matching(&self, prefix: &str) -> Vec<(String, FileLocation, u64)> {
    fn len(&self) -> usize {
        assert_eq!(reg.len(), 0);
            assert_eq!(guard.ref_count(), 1);
    use std::sync::Arc;
        assert_eq!(reg.len(), 1);
        assert_eq!(reg.len(), num_threads * 100);
        if force {
        let key = key.strip_prefix('/').unwrap_or(key);
            }
impl Default for TieredStorageRegistry {
    fn purge_stale(&self, valid_keys: &HashSet<String>) -> usize {
    }
    #[test]
    }
        });
    fn update(&self, key: &str, f: impl FnOnce(&mut TieredFileEntry)) {
    fn remove_by_prefix(&self, prefix: &str, force: bool) -> usize {
        let reg = make_registry();
        let guard = reg.get("/a.parquet").unwrap();
        reg.update("/a.parquet", |e| {
    // -- Register -----------------------------------------------------------
            // Only remove if ref_count == 0.
    // -- entries_matching ---------------------------------------------------
    }
    }
    #[test]
        }
        reg.update("/data/b.parquet", |e| {
        assert_eq!(reg.len(), 0);
        assert_eq!(g2.ref_count(), 1);
    fn test_concurrent_acquire_release_returns_to_zero() {
        let guard = reg.get("/a.parquet").unwrap();
        let reg = make_registry();
//! (SeqCst) are used for `active_reads`.
        let _guard = reg.get("/a.parquet").unwrap();
    pub fn new() -> Self {
        assert_eq!(removed, 1);
                })
        );
    #[test]
        // Drop the guard first, then acquire manually.
    #[test]
impl fmt::Display for TieredStorageRegistry {
                .map(|e| e.key().clone())
                    false
    fn test_multiple_guards_accumulate() {
        let handles: Vec<_> = (0..num_threads)
        write!(f, "TieredStorageRegistry(files={})", self.files.len())
/// Production file registry backed by [`DashMap`].
        for h in handles {
                }
mod tests {
 *
    fn local_entry() -> TieredFileEntry {
    #[test]
            e.location = FileLocation::Remote;
        let match_all = prefix.is_empty();
        let key = key.strip_prefix('/').unwrap_or(key);
        let guard = reg.get("/a.parquet").unwrap();
                let barrier = Arc::clone(&barrier);
        } else {
    #[test]
        reg.register("/data/b.parquet", local_entry());
    fn test_read_guard_auto_releases_on_drop() {
 * this file be licensed under the Apache-2.0 license or a
        assert_eq!(reg.len(), 1);
    }
            valid_keys.contains(key.as_str()) || valid_keys.contains(&format!("/{}", key))
 * compatible open source license.
        assert_eq!(reg.len(), 1);
use dashmap::DashMap;
    ///
        reg.register("/c.parquet", local_entry());
}
        // Manually acquire to simulate active reads without holding DashMap Ref.
        assert!(!reg.remove("/nonexistent", true));
    #[must_use]
        let reg = make_registry();
        reg.register("/data/a.parquet", local_entry());
                "TieredStorageRegistry: purge_stale removed {} entries",
        });
    }
        }
        let num_threads = 16;
    #[test]
// TieredStorageRegistry
        TieredFileEntry::new(FileLocation::Remote, Some(Arc::from("remote/a.parquet")))
                        entry.remove();
        TieredStorageRegistry::new()
/// Tracks per-file metadata and provides RAII-based ref counting via
            }
        // After guard dropped, ref count should be 0.
        let reg = make_registry();
        assert_eq!(entries.len(), 2);
            removed
            .filter(|e| match_all || e.key().starts_with(prefix))
        }
    fn test_entries_matching_prefix() {
        native_bridge_common::log_info!("TieredStorageRegistry: created");
    fn test_get_nonexistent_returns_none() {
        let g2 = reg.get("/a.parquet").unwrap();
        }
                thread::spawn(move || {
        reg.register("/a.parquet", local_entry());
    // -- Purge stale --------------------------------------------------------
        assert_eq!(reg.len(), 1);
        let reg = make_registry();
    /// If `prefix` is empty or `"/"`, returns all entries.
    }
    fn test_register_overwrites() {
            f(entry.value_mut());
                        reg.register(&format!("/t{}/f{}.parquet", i, j), local_entry());
        let valid: HashSet<String> = ["/a.parquet".to_string()].into_iter().collect();
    #[test]
        reg.register("data/a.parquet", local_entry());
    #[test]
        let key = key.strip_prefix('/').unwrap_or(key);
        assert_eq!(removed, 2);
        let reg = make_registry();
                        }
    }
    }
/*
            })
// ---------------------------------------------------------------------------
        reg.register("/a.parquet", remote_entry());
        // Strip leading "/" — keys are stored without leading slash
                        false
        reg.update("/nonexistent", |e| {
    /// Create a new empty registry.
    }
                    } else {
                    }
    }
                }
        // Strip leading "/" — keys are stored without leading slash
        reg.update("/a.parquet", |e| {
    fn make_registry() -> TieredStorageRegistry {
        assert_eq!(guard.remote_path(), Some("remote/a.parquet"));
        let reg = Arc::new(make_registry());
        Some(ReadGuard::new(entry))
            .finish()
            h.join().expect("thread should not panic");
#[cfg(test)]
    #[test]
    #[test]
        reg.register("/a.parquet", local_entry());
        assert_eq!(reg.len(), 0);
    }
            .collect()
        reg.register("/a.parquet", local_entry());
        let reg = make_registry();
}
        assert_eq!(guard.ref_count(), 1);
            e.release();
//!
        let ops_per_thread = 1000;
}
    fn test_remove_force_false_active_refs() {
        let key = key.strip_prefix('/').unwrap_or(key);
        let num_threads = 16;
            );
    }
    fn test_entries_matching_all() {
 * The OpenSearch Contributors require contributions made to
            let matching: Vec<String> = self
        reg.register("/data/b.parquet", local_entry());
        assert_eq!(reg.len(), 1);
        assert_eq!(reg.len(), 1);
                let reg = Arc::clone(&reg);
                } else {
        reg.register("/b.parquet", local_entry());
        }
        reg.register("/a.parquet", local_entry());
        // Clean up.
                removed
        self.files
                    removed += 1;
                        if let Some(guard) = reg.get("/a.parquet") {
        let prefix = prefix.strip_prefix('/').unwrap_or(prefix);
        reg.register("/data/a.parquet", local_entry());
            });
                        true
        reg.update("/a.parquet", |e| {
//! All operations are safe for concurrent use. DashMap entry API is used for
    }
        let reg = make_registry();
        reg.register(
                if self.remove(key, false) {
    }
        let reg = make_registry();
        // Strip leading "/" — keys are stored without leading slash
    }
            "data/b.parquet",
        let removed = before.saturating_sub(self.files.len());
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        // Clean up.
// ---------------------------------------------------------------------------
        reg.register("/a.parquet", local_entry());
    #[test]
        // This guard is the only one, so ref_count == 1.
        let reg = Arc::new(make_registry());
        }
            e.release();
    fn remove(&self, key: &str, force: bool) -> bool {
}
                    if entry.get().ref_count() == 0 {
    }
    }
        assert!(reg.remove("/a.parquet", true));
// TODO: Add PendingAction (EvictLocal/RemoveFull) and pinned fields to
        f.debug_struct("TieredStorageRegistry")
        let reg = make_registry();
    }
        let removed = reg.remove_by_prefix("/data/", false);
        reg.register("b", local_entry());
            let mut removed = 0usize;
    fn test_purge_stale_removes_unknown() {
        let removed = reg.remove_by_prefix("/data/", true);
            e.acquire();
        });
                let barrier = Arc::clone(&barrier);
        });
        });
    fn test_register_both() {
    files: DashMap<String, TieredFileEntry>,
        assert!(reg.remove("/a.parquet", false));
            let guard = reg.get("/a.parquet").unwrap();
        reg.register("/a.parquet", local_entry());
        TieredFileEntry::new(FileLocation::Local, None)
        reg.register("/a.parquet", remote_entry());
                dashmap::mapref::entry::Entry::Vacant(_) => false,
            .map(|i| {
        });
    fn test_update_nonexistent_is_noop() {
    fn test_concurrent_register_different_paths() {
    /// Per-file metadata. Key is the file path.
        let removed = reg.purge_stale(&valid);
    #[must_use]
    #[test]
                })
use super::traits::FileRegistry;
        let g1 = reg.get("/a.parquet").unwrap();
        // Can't remove while guard is held — but guard holds a Ref which
    }
        let reg = make_registry();
    fn test_get_returns_guard_with_correct_data() {
