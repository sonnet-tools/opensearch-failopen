        .map(|p| (p.limit(), p.used(), p.peak()))
//! Write and merge memory pools backed by `native_bridge_common::memory_pool::MemoryPool`.
    MERGE_POOL.get_or_init(|| Arc::new(MemoryPool::new("merge", usize::MAX)))
/// Returns the merge pool, initializing with a large default if not yet set.
    }
 */
    if let Some(p) = MERGE_POOL.get() {
}
pub fn write_pool() -> &'static Arc<MemoryPool> {
    WRITE_POOL.get_or_init(|| Arc::new(MemoryPool::new("write", usize::MAX)))
}
/// Returns the write pool, initializing with a large default if not yet set.
use std::sync::{Arc, OnceLock};
}
static MERGE_POOL: OnceLock<Arc<MemoryPool>> = OnceLock::new();
    MERGE_POOL.get_or_init(|| Arc::new(MemoryPool::new("merge", merge_limit)));
        p.set_limit(v);
static WRITE_POOL: OnceLock<Arc<MemoryPool>> = OnceLock::new();
/*
 *
        .map(|p| (p.limit(), p.used(), p.peak()))
    }
        .get()
    WRITE_POOL.get_or_init(|| Arc::new(MemoryPool::new("write", write_limit)));
        .get()
        .unwrap_or((0, 0, 0));
}
    [w.0, w.1, w.2, m.0, m.1, m.2]
 * compatible open source license.
    if let Some(p) = WRITE_POOL.get() {
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
}
/// Initialize write and merge pools. Called once from Java.
use native_bridge_common::memory_pool::MemoryPool;
pub fn set_merge_limit(v: usize) {
pub fn get_stats() -> [usize; 6] {
pub fn init_pools(write_limit: usize, merge_limit: usize) {
        .unwrap_or((0, 0, 0));
    let m = MERGE_POOL
pub fn set_write_limit(v: usize) {
    let w = WRITE_POOL
}
/// Returns [write_limit, write_used, write_peak, merge_limit, merge_used, merge_peak].
        p.set_limit(v);
pub fn merge_pool() -> &'static Arc<MemoryPool> {
