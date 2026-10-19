    fn test_read_guard_auto_releases_on_drop() {
        assert!(!reg.remove("/nonexistent", false));
            .map(|e| (e.key().clone(), e.value().location(), e.value().size()))
// Tests
    fn local_entry() -> TieredFileEntry {
    use std::thread;
        let g2 = reg.get("/a.parquet").unwrap();
                dashmap::mapref::entry::Entry::Occupied(entry) => {
                removed
        }
    #[test]
                let barrier = Arc::clone(&barrier);
            let mut removed = 0;
                    for j in 0..100 {
    /// Per-file metadata. Key is the file path.
        self.files.retain(|key, _| {
        reg.register("a", local_entry());
            e.acquire();
                thread::spawn(move || {
        reg.register("/data/a.parquet", local_entry());
        assert_eq!(reg.len(), 1);
    // -- Register -----------------------------------------------------------
            h.join().expect("thread should not panic");
    #[test]
            .collect();
        });
    }
        assert_eq!(reg.len(), 1);
    }
        reg.register("/a.parquet", local_entry());
    fn test_register_overwrites() {
        let reg = make_registry();
        }
}
    fn test_get_returns_guard_with_correct_data() {
    fn test_update_modifies_entry() {
        assert_eq!(guard.location(), FileLocation::Remote);
        let _guard = reg.get("/a.parquet").unwrap();
        let handles: Vec<_> = (0..num_threads)
// ---------------------------------------------------------------------------
                .collect();
    // -- Get / ReadGuard ----------------------------------------------------
    #[test]
use crate::types::{FileLocation, ReadGuard, TieredFileEntry};
        reg.register("/b.parquet", local_entry());
    #[test]
    }
        Some(ReadGuard::new(entry))
// ---------------------------------------------------------------------------
        let entries = reg.entries_matching("");
        let guard2 = reg.get("/a.parquet").unwrap();
    #[test]
/*
                    removed += 1;
                let barrier = Arc::clone(&barrier);
        f.debug_struct("TieredStorageRegistry")
        let handles: Vec<_> = (0..num_threads)
                })
    }
    use std::sync::Arc;
        let key = key.strip_prefix('/').unwrap_or(key);
            .iter()
        assert_eq!(guard.remote_path(), Some("remote/a.parquet"));
        {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        reg.register("/c.parquet", local_entry());
        let key = key.strip_prefix('/').unwrap_or(key);
        let g1 = reg.get("/a.parquet").unwrap();
        let barrier = Arc::new(Barrier::new(num_threads));
        reg.register("/a.parquet", local_entry());
impl fmt::Display for TieredStorageRegistry {
//! All operations are safe for concurrent use. DashMap entry API is used for
}
use dashmap::DashMap;
                    if entry.get().ref_count() == 0 {
        }
            e.location = FileLocation::Remote;
    }
                })
            );
    fn remove_by_prefix(&self, prefix: &str, force: bool) -> usize {
        let key = key.strip_prefix('/').unwrap_or(key);
        assert_eq!(reg.len(), 0);
        } else {
        Self {
        reg.update("/nonexistent", |e| {
        // Manually acquire to simulate active reads without holding DashMap Ref.
            .collect()
        let ops_per_thread = 1000;
        assert_eq!(removed, 1);
        assert_eq!(guard.location(), FileLocation::Remote);
        assert!(!reg.remove("/a.parquet", false));
        let num_threads = 16;
        let reg = make_registry();
        });
                    }
        let reg = make_registry();
    }
        assert_eq!(entries.len(), 2);
        if let Some(mut entry) = self.files.get_mut(key) {
                    barrier.wait();
    }
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
        reg.register("/a.parquet", both_entry());
    #[test]
        reg.register("/a.parquet", local_entry());
                }
///
        drop(_guard);
        assert_eq!(reg.len(), 1);
        for h in handles {
    #[test]
        let reg = make_registry();
        // Strip leading "/" — keys are stored without leading slash
        assert_eq!(reg.len(), 0);
    fn test_remove_force_false_zero_refs() {
    #[must_use]
    pub fn entries_matching(&self, prefix: &str) -> Vec<(String, FileLocation, u64)> {
        let reg = make_registry();
        });
            match self.files.entry(key.to_string()) {
        reg.register("other/c.parquet", local_entry());
    }
    }
                .files
            self.files.retain(|key, _| {
                            drop(guard);
        drop(guard2);
        reg.register("/a.parquet", local_entry());
        let reg = make_registry();
        assert_eq!(entries2.len(), 2);
    fn remove(&self, key: &str, force: bool) -> bool {
        // Strip leading "/" — keys are stored without leading slash
        reg.register("data/a.parquet", local_entry());
        reg.update("/a.parquet", |e| {
    #[test]
use super::traits::FileRegistry;
    #[test]
                        entry.remove();
            let matching: Vec<String> = self
    }
    }
// TODO: Add PendingAction (EvictLocal/RemoveFull) and pinned fields to
        // Strip leading "/" — keys are stored without leading slash
    fn make_registry() -> TieredStorageRegistry {
        reg.register("/a.parquet", local_entry());
    #[test]
        let reg = make_registry();
    }
    }
        let reg = Arc::new(make_registry());
            // Only remove if ref_count == 0.
        reg.register("/other/c.parquet", local_entry());
        reg.register("/data/a.parquet", local_entry());
        reg.register("/data/b.parquet", local_entry());
// ---------------------------------------------------------------------------
        if removed > 0 {
    fn test_concurrent_register_different_paths() {
    }
        // Clean up.
        assert_eq!(reg.len(), 1);
        let guard = reg.get("/a.parquet").unwrap();
        assert_eq!(g2.ref_count(), 1);
            });
        assert_eq!(removed, 2);
//!
        Self::new()
    #[test]
        reg.register("/a.parquet", local_entry());
    fn test_update_nonexistent_is_noop() {
            removed
        TieredStorageRegistry::new()
        let entries = reg.entries_matching("data/");
                }
        let reg = make_registry();
        let removed = reg.remove_by_prefix("/data/", true);
        reg.register("/a.parquet", local_entry());
        }
    #[test]
    }
impl TieredStorageRegistry {
        assert!(!reg.remove("/nonexistent", true));
                    false
        }
            native_bridge_common::log_info!(
        reg.register("/a.parquet", remote_entry());
// ---------------------------------------------------------------------------
    fn test_register_remote() {
        }
    fn test_entries_matching_prefix() {
//! check-then-act patterns to prevent TOCTOU races. Atomic operations
                thread::spawn(move || {
    }
                    }
    }
    fn len(&self) -> usize {
    }
            let guard = reg.get("/a.parquet").unwrap();
    }
    fn test_remove_force_false_active_refs() {
                let reg = Arc::clone(&reg);
        let entries2 = reg.entries_matching("/");
    fn test_remove_force_true() {
        let match_all = prefix.is_empty();
        // All guards dropped, ref count should be 0.
        let prefix = prefix.strip_prefix('/').unwrap_or(prefix);
        TieredFileEntry::new(FileLocation::Local, None)
    /// If `prefix` is empty or `"/"`, returns all entries.
        } else {
        let reg = make_registry();
        assert_eq!(guard.location(), FileLocation::Remote);
                .map(|e| e.key().clone())
        reg.update("/a.parquet", |e| {
    #[test]
        let prefix = prefix.strip_prefix('/').unwrap_or(prefix);
        let removed = before.saturating_sub(self.files.len());
        assert!(reg.remove("/a.parquet", true));
// TieredStorageRegistry
        let reg = Arc::new(make_registry());
        assert_eq!(guard.ref_count(), 1); // Only this guard.
        let guard = reg.get("/a.parquet").unwrap();
        assert_eq!(reg.len(), 1);
    #[test]
            h.join().expect("thread should not panic");
            .filter(|e| match_all || e.key().starts_with(prefix))
        }
        assert_eq!(guard.ref_count(), 1);
        assert_eq!(guard2.ref_count(), 1);
        assert_eq!(entries.len(), 2);
    }
        let barrier = Arc::new(Barrier::new(num_threads));
        reg.update("/data/b.parquet", |e| {
    /// List entries matching `prefix`. Returns `(key, location)`.
    }
    }
    }
    fn test_remove_nonexistent() {
        for h in handles {
        write!(f, "TieredStorageRegistry(files={})", self.files.len())
        // prevents entry-level operations. We need to test differently.
        // After guard dropped, ref count should be 0.
            e.release();
    }
            assert_eq!(guard.ref_count(), 1);
            e.release();
    }
        let reg = make_registry();
    // -- Remove -------------------------------------------------------------
                        if let Some(guard) = reg.get("/a.parquet") {
        // Strip leading "/" — keys are stored without leading slash
            })
                .iter()
            TieredFileEntry::new(FileLocation::Remote, None),
        let guard = reg.get("/a.parquet").unwrap();
    fn test_register_both() {
    }
        let reg = make_registry();
            .collect();
        reg.register("/a.parquet", remote_entry());
            .finish()
    }
            let mut removed = 0usize;
    }
        });
use std::fmt;
                        true
        assert_eq!(reg.len(), num_threads * 100);
    }
    // -- Remove by prefix ---------------------------------------------------
impl Default for TieredStorageRegistry {
        let before = self.files.len();
    #[test]
use std::collections::HashSet;
        // Strip leading "/" — keys are stored without leading slash
}
    #[test]
                dashmap::mapref::entry::Entry::Vacant(_) => false,
                if key.starts_with(prefix) {
 *
                .filter(|e| e.key().starts_with(prefix))
/// Production file registry backed by [`DashMap`].
/// Tracks per-file metadata and provides RAII-based ref counting via
    fn test_multiple_guards_accumulate() {
impl FileRegistry for TieredStorageRegistry {
    #[test]
    fn default() -> Self {
        assert_eq!(reg.len(), 0);
        let key = key.strip_prefix('/').unwrap_or(key);
            f(entry.value_mut());
 */
            self.files.remove(key).is_some()
            .field("file_count", &self.files.len())
    ///
                }
    use std::sync::Barrier;
    #[test]
 * this file be licensed under the Apache-2.0 license or a
    #[test]
            files: DashMap::new(),
        let num_threads = 16;
 * compatible open source license.
        assert!(reg.get("/nonexistent").is_none());
//! # Thread Safety
        let reg = make_registry();
        self.files.insert(key.to_string(), value);
        self.files.len()
        }
        let guard = reg.get("/a.parquet").unwrap();
    fn both_entry() -> TieredFileEntry {
}
}
        assert_eq!(reg.len(), 1);
                        }
        if force {
        // Drop the guard first, then acquire manually.
    fn remote_entry() -> TieredFileEntry {
            "data/b.parquet",
    fn test_entries_matching_all() {
    fn test_concurrent_acquire_release_returns_to_zero() {
        let reg = make_registry();
        removed
        let entry = self.files.get(key)?;
        assert_eq!(removed, 2);
            }
    fn register(&self, key: &str, value: TieredFileEntry) {
    }
    // -- Purge stale --------------------------------------------------------
    }
        });
            }
        reg.register(
        reg.register("/a.parquet", local_entry());
            .map(|i| {
    use super::*;
}
    // -- Concurrency --------------------------------------------------------
    }
        reg.register("/a.parquet", remote_entry());
//!
        reg.register("b", local_entry());
        });
            })
    #[test]
        let removed = reg.remove_by_prefix("/data/", false);
        let removed = reg.purge_stale(&valid);
/// [`ReadGuard`].
                if self.remove(key, false) {
        });
                    for _ in 0..ops_per_thread {
            e.location = FileLocation::Remote;
        let valid: HashSet<String> = ["/a.parquet".to_string()].into_iter().collect();
#[cfg(test)]
    fn test_get_nonexistent_returns_none() {
        assert_eq!(g2.ref_count(), 2);
            removed
                        false
        reg.register("/data/b.parquet", local_entry());
//! [`TieredStorageRegistry`] — concrete registry for tiered storage.
    }
        // Clean up.
        let reg = make_registry();
mod tests {
                    true
        );
    #[must_use]
        // Can't remove while guard is held — but guard holds a Ref which
    }
 * SPDX-License-Identifier: Apache-2.0
//! (SeqCst) are used for `active_reads`.
        if force {
    // -- Update -------------------------------------------------------------
pub struct TieredStorageRegistry {
    }
    fn test_remove_force_true_with_active_refs() {
                        reg.register(&format!("/t{}/f{}.parquet", i, j), local_entry());
        assert_eq!(reg.len(), 0);
                let reg = Arc::clone(&reg);
                } else {
        drop(g1);
        reg.register("/a.parquet", local_entry());
        let reg = make_registry();
                    barrier.wait();
    }
            e.acquire();
    fn get(&self, key: &str) -> Option<ReadGuard<'_>> {
    #[test]
    }
        reg.update("/a.parquet", |e| {
    files: DashMap<String, TieredFileEntry>,
// -- FileRegistry trait impl ------------------------------------------------
            .map(|_| {
// TieredFileEntry when eviction lifecycle is needed for the write path.
        let reg = make_registry();
        assert!(reg.remove("/a.parquet", true));
        let reg = make_registry();
    pub fn new() -> Self {
        self.files
        TieredFileEntry::new(FileLocation::Remote, Some(Arc::from("remote/a.parquet")))
    /// Create a new empty registry.
        // This guard is the only one, so ref_count == 1.
}
        });
        let reg = make_registry();
        reg.update("/a.parquet", |e| {
    // -- entries_matching ---------------------------------------------------
    }
impl fmt::Debug for TieredStorageRegistry {
        // Strip leading "/" — keys are stored without leading slash
    fn purge_stale(&self, valid_keys: &HashSet<String>) -> usize {
    fn test_purge_stale_removes_unknown() {
        drop(g2);
 * The OpenSearch Contributors require contributions made to
    fn test_remove_by_prefix_force() {
            // Check both with and without leading "/" since callers may pass either form
        let reg = make_registry();
                    } else {
    fn test_register_local() {
                    removed += 1;
        assert_eq!(reg.len(), 1);
            e.acquire();
    fn test_remove_by_prefix_no_force_skips_active() {
        TieredFileEntry::new(FileLocation::Remote, Some(Arc::from("remote/a.parquet")))
    fn update(&self, key: &str, f: impl FnOnce(&mut TieredFileEntry)) {
        native_bridge_common::log_info!("TieredStorageRegistry: created");
                    }
        reg.register("/a.parquet", local_entry());
                "TieredStorageRegistry: purge_stale removed {} entries",
    #[test]
        assert!(reg.remove("/a.parquet", false));
        reg.register("/a.parquet", local_entry());
        reg.update("/data/b.parquet", |e| {
        let reg = make_registry();
            for key in &matching {
            valid_keys.contains(key.as_str()) || valid_keys.contains(&format!("/{}", key))
        assert_eq!(reg.len(), 1);
