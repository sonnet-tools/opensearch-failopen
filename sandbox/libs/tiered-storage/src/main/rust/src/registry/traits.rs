    /// If `force=false`, only remove entries with `ref_count == 0`.
//! [`FileRegistry`] trait — interface for file tracking with RAII ref counting.
    fn register(&self, key: &str, value: TieredFileEntry);
 * The OpenSearch Contributors require contributions made to
    fn remove(&self, key: &str, force: bool) -> bool;
//! `get()` for automatic acquire/release semantics.
//! The trait is specific to [`TieredFileEntry`] and returns [`ReadGuard`] from
    fn is_empty(&self) -> bool {
    /// Remove an entry. If `force=false`, only remove if `ref_count == 0`.
 * compatible open source license.
    fn get(&self, key: &str) -> Option<ReadGuard<'_>>;
}
///
    /// Remove entries not in `valid_keys`. Returns count removed.
use std::collections::HashSet;
    /// Register or update an entry.
    }
    fn len(&self) -> usize;
    /// Get an entry with auto-acquired ref count. Guard releases on drop.
/// managed by [`ReadGuard`] — `get()` returns a guard that auto-acquires
/// Implementations must be thread-safe (`Send + Sync`). Ref counting is
    /// Update an entry in-place via a closure.
 *
    /// Number of entries.
pub trait FileRegistry: Send + Sync {
/// File registry trait for tiered storage.
/// on creation and auto-releases on drop.
 */
    fn remove_by_prefix(&self, prefix: &str, force: bool) -> usize;
    fn update(&self, key: &str, f: impl FnOnce(&mut TieredFileEntry));
    /// Check if empty.
 * this file be licensed under the Apache-2.0 license or a
    /// Returns count of entries removed.
//!
/*
    fn purge_stale(&self, valid_keys: &HashSet<String>) -> usize;
    /// Remove entries whose key starts with `prefix`.
use crate::types::{ReadGuard, TieredFileEntry};
 * SPDX-License-Identifier: Apache-2.0
        self.len() == 0
    /// Returns `true` if the entry was removed.
