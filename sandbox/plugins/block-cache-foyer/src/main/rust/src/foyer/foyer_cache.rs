                // Disable the in-memory tier — this cache is disk-only.
            if let Err(e) = key_index_store::delete(&self.cache_dir) {
            // This ensures the counter is restored even if this future is dropped mid-execution
    /// # Panics
        if threshold <= 0.0 {
    fn get<'a>(
                                        Ok(Ok(())) => {
    /// `removed_bytes`, and related stats.
                    }
            let mut total_removed_bytes = 0i64;
                    None
/// Increments `active_in_bytes` when created and decrements it when dropped.
    /// evicted anything.
                .used_bytes
/// | `"auto"`   | Detect at runtime: io_uring on Linux ≥ 5.1, psync otherwise (default). |
            let mut engine_config = BlockEngineConfig::new(
            .with_buffer_pool_size(buffer_pool_size_bytes)
use std::sync::atomic::{AtomicU64, AtomicUsize, Ordering};
                // disk tier (FsDevice) below.
        match close_result {
/// Return `true` if the running Linux kernel is >= `(major, minor)`.
            stale_removed += before - keys.len();
        // ── Construct instance ────────────────────────────────────────────────
                self.cache_dir.display()
    pub fn new(
        let idx = Self::index_key(raw).to_string();
    ///   is spawned). Configurable via `block_cache.foyer.key_index_sweep_interval_seconds`.
use std::path::PathBuf;
    /// # Design: no per-key validation (no `inner.contains()`)
            },
    /// already been stopped. If a `put()` happens to race with this call on the same prefix,
    /// Live-updatable sweep interval in seconds. `0` = disabled (task uses this only to sleep;
///
            tokio::runtime::Runtime::new().expect("[block-cache] failed to create Tokio runtime");
    /// Wait for the storage flusher to drain its write queue.
            self.stats.used_bytes.fetch_add(size, Ordering::Relaxed);
        buffer_pool_size_bytes: usize,
            new_secs
            stats,
            match self.inner.get(&key.as_str().to_string()).await {
             elapsed_ms={} prefix_buckets={}",
fn build_io_engine_config(choice: &str) -> Box<dyn IoEngineConfig> {
                if cache.contains(k) {
            }
    ///   the snapshot is accurate. Any minor inaccuracy from entries LRU-evicted
                                    native_bridge_common::log_debug!(
impl Drop for ActiveBytesGuard<'_> {
            let persist_stats = Arc::clone(&instance.stats);
            Ok(Err(e)) => {
        } else {
    ///
                                            );
    /// Update the sweep interval live. `0` = disable sweep. Takes effect on next sleep.
    /// via `should_skip_sweep()`.
        // disk reclaimer. inner.contains() is an in-RAM index lookup (no disk I/O).
                        tokio::select! {
        }
                // recover_key_index() this ensures disk data and key_index are consistent
    pub(crate) fn should_skip_sweep(&self) -> bool {
                for k in keys {
    /// Used to write/read `key_index.json` for persistence and recovery.
                    "[block-cache] HybridCache close TIMED OUT (30s) on shutdown — partial blocks may be lost"
    fn index_key(key: &str) -> &str {
    ///
                                }
                        .miss_bytes
        let mut total_evicted = 0usize;
    ///
/// |------------|-----------|
        // Cancel the background sweep task and persist task so they wake immediately
    }
        // Timeout prevents indefinite blocking if the flusher is stuck.
            shutdown,
            if total_removed > 0 {
                    // Derive byte size from key before removing: "path\x1Fstart-end" → end-start.
                                        &sweep_key_index, &sweep_inner, &sweep_stats, &sweep_cursor_clone,
                key_index.len()
    /// successive calls rotate fairly through all shards.
                // Foyer is a hybrid (DRAM + disk) cache; setting the memory capacity
// ── ActiveBytesGuard ─────────────────────────────────────────────────────────
                }
        // index_key() normalizes by stripping leading '/' — evict_prefix uses the same normalization.
/// key_index starts empty (same as before this feature was added).
    pub(crate) sweep_threshold_ratio: Arc<AtomicU64>,
    /// Sweep one DashMap shard per call and advance the cursor.
/// | `"psync"`  | Force synchronous pread/pwrite. Use when io_uring is restricted or when predictable syscall-level profiling is needed. |
                        .fetch_add(range_len, Ordering::Relaxed);
                    native_bridge_common::log_info!(
                                if threshold > 0.0 {
            }
///
        );
use crate::traits::BlockCache;
use dashmap::DashMap;
    /// After this returns, all previously put() entries are on SSD and findable via get().
        let elapsed_ms = t0.elapsed().as_millis() as u64;
    ///
        // Explicitly release the write lock BEFORE calling key_index.len().
                    .removed_bytes
        let is_new = self.key_index.entry(idx).or_default().insert(k);
                    e
            panic!("[block-cache] io_engine=io_uring requested but io_uring is not supported on non-Linux platforms");
                );
    /// - `block_size_bytes` — Foyer disk block size. Must be ≥ the largest entry ever
use crate::key_index_store;
/// Disk block cache with prefix-based eviction support backed by Foyer.
            instance._runtime.spawn(async move {
    /// Configured disk capacity in bytes.
use std::sync::Arc;
                        tokio::select! {
        // DashMap::len() acquires read locks on ALL shards (including this one).
        submit_queue_size_threshold_bytes: usize,
            sweep_threshold_ratio: sweep_threshold_atomic,
        // Flush partial blocks to SSD before shutdown with a timeout.
        io_engine: &str,
        key_index: &Arc<DashMap<String, HashSet<String>>>,
            #[cfg(not(target_os = "linux"))]
                    .fetch_add(total_removed, Ordering::Relaxed);
    /// All keys in the snapshot are inserted directly into `key_index` and
        self.sweep_threshold_ratio
                        let interval = if current_secs == 0 {
                );
impl Drop for FoyerCache {
                                    let ratio = used as f64 / sweep_disk_bytes as f64;
        let shard_count = shards.len();
                    );
}
                    false
            // Accumulate removed stats from key_index before wiping.
                    "[block-cache] persist task started: interval={}s",
        // Sweep cursor starts at shard 0 and advances by one per sweep call,
                    native_bridge_common::log_info!(
    /// - `persist_interval_secs` — how often (in seconds) the independent persist task
    /// - `false` when `sweep_threshold_ratio == 0.0` (threshold disabled → never skip).
use tokio_util::sync::CancellationToken;
    /// Rationale:
    #[cfg(test)]
    fn drop(&mut self) {
        }
                    return UringIoEngineConfig::new().boxed();
                    "[block-cache] HybridCache close FAILED on shutdown: {}",
        self.shutdown.cancel();
                    self.stats.hit_count.fetch_add(1, Ordering::Relaxed);
        persist_interval_secs: u64,
                            }
            .used_bytes
/// Invalid values are treated as `"auto"` with a warning.
    /// captures it by value) and in test builds via `should_skip_sweep()`.
    /// Test-only helper — lets tests verify the threshold guard logic without needing
    fn reconcile_key_index(
                        let current_secs = sweep_interval_atomic_clone.load(Ordering::Relaxed);
    }
                            _ = persist_token.cancelled() => {
            _runtime: Arc::new(rt),
    }
    ///   to run the sweep. If the ratio is below this threshold the sweep tick is skipped
            let _active_guard = ActiveBytesGuard::new(&self.stats.active_in_bytes, range_len);
                                    }
                    .removed_count
    /// a running async task or sleeping.
        "io_uring" => {
                    "[block-cache] key_index clear: failed to delete snapshot files: {}",
/// 1. By the independent periodic persist task every `persist_interval_secs` seconds
            }
    /// `object_store::Path` (no leading slash) and keys from tests or
            io_engine_for_log,
        // never fires.
    pub(crate) fn update_sweep_threshold(&self, new_ratio: f64) {
    /// one shard and advances this cursor by 1. Over `shard_count` sweep cycles the
        let normalized = prefix.trim_start_matches('/');
    /// strictly below this threshold. If so, the sweep is skipped entirely (no-op) — no
        // Compute stats before moving snapshot.index into the DashMap.
    ///   Configurable via `block_cache.foyer.io_engine`.
                }
            prefix, matching.len(), total_evicted, self.key_index.len()
    /// Test-only helper — calls [`Self::reconcile_key_index`] directly so tests can
    /// then strips any leading `/` so that keys stored by DataFusion's
        Ok(s) => s,
            key_index,
        };
/// Wraps a Foyer [`HybridCache`] configured as a disk-only store (memory tier = 1 byte),
 * The OpenSearch Contributors require contributions made to
                loop {
        Box::pin(async move {
    ///
                                    let dir_clone = persist_dir.clone();
        } else {
                                    match result {
        // and we must NOT increment used_bytes again — the caller already paid for it on the first put.
                                        Ok(Err(e)) => {
fn kernel_version_at_least(required_major: u32, required_minor: u32) -> bool {
            key
                .fetch_add(-removed_bytes, Ordering::Relaxed);
            PsyncIoEngineConfig::new().boxed()
    fn drop(&mut self) {
    pub async fn wait_for_flush(&self) {
            let sweep_inner = instance.inner.clone();
    /// - `sweep_threshold_ratio` — minimum usage ratio (`used_bytes / disk_bytes`) required
        let shards = key_index.shards();
    pub(crate) sweep_interval_secs: Arc<AtomicU64>,
                }
            native_bridge_common::log_info!(
impl<'a> ActiveBytesGuard<'a> {
            });
                );
    ///
    };
/// ## Recovery
    major > required_major || (major == required_major && minor >= required_minor)
/// disk data is recovered via `RecoverMode::Quiet`. Stale key_index entries (keys
    ///
        );
            },
    ///   flushes the key_index to disk. `0` = disabled (only `Drop` persists).
    /// current sleep interval to expire before checking the flag.
                // RecoverMode::Quiet recovers existing disk entries into Foyer's in-RAM
            // stale keys into a freshly-cleared cache.
        let raw = key.as_str();
    pub(crate) sweep_cursor: Arc<AtomicUsize>,
        if total_evicted > 0 {
                    freed_bytes += key_byte_size(k);
                                    // Panic safety: a panic in save must not kill the task.
                                    native_bridge_common::log_error!(
            new_ratio * 100.0
                    e
        self
    ///
                "disabled".to_string()
    let release = match std::fs::read_to_string("/proc/sys/kernel/osrelease") {
        if let Err(e) = key_index_store::save(&self.cache_dir, &self.key_index) {
    /// - `sweep_interval_secs` — how often (in seconds) the background sweeper prunes
                total_evicted += keys.len();
                                        }
            native_bridge_common::log_info!(
                        };
            }
use crate::range_cache::{key_byte_size, CacheKey, SEPARATOR};
            sweep_cursor,
    ///
    /// # Returns
            native_bridge_common::log_info!(
    /// is a no-op. This prevents double-counting in `used_bytes`, `eviction_bytes`,
        // Clone disk_dir only for the async closure; the original is moved into cache_dir
                    .unwrap_or_else(|_| "unknown".to_string());
        }
            );
    let minor: u32 = parts.next().and_then(|s| s.parse().ok()).unwrap_or(0);
            let mut total_removed = 0i64;
        let mut shard = shards[shard_idx].write(); // write lock on ONE shard
                            Duration::from_secs(current_secs)
        if persist_interval_secs > 0 {
    pub(crate) fn sweep_once(&self) -> usize {
        Box::pin(async {
pub(crate) struct ActiveBytesGuard<'a> {
        // scan) vs persisting (cheap file write).
    IoEngineConfig, PsyncIoEngineConfig, RecoverMode, StorageFilter,
    /// that new entry will also be evicted — which is expected, since the prefix is going away.
///    (when `used_bytes` has changed since the last write — zero-write when idle).
 * SPDX-License-Identifier: Apache-2.0
        let dir_clone = disk_dir.clone();
        native_bridge_common::log_info!("[block-cache] sweep interval updated live: {}s", new_secs);
        }
    /// - Missing file (clean startup or crash): silently treated as empty.
    /// - `io_engine` — I/O engine selection: `"auto"`, `"io_uring"`, or `"psync"`.
                self.key_index.len(),
        Err(_) => return false,
        shard.retain(|_, v| !v.get().is_empty());
    /// `used_bytes` is initialised to the sum of all their byte sizes.
                self.cache_dir.display()
                .fetch_add(freed_bytes, Ordering::Relaxed);
                let mut restart_count = 0u32;
                    .build()
    /// - `false` when `sweep_threshold_ratio > 0.0` AND `used_bytes / disk_bytes >= threshold`.
            if other != "auto" {
        let threshold = f64::from_bits(self.sweep_threshold_ratio.load(Ordering::Relaxed));
///
            native_bridge_common::log_info!(
                                let threshold = f64::from_bits(sweep_threshold_atomic_clone.load(Ordering::Relaxed));
                native_bridge_common::log_info!(
                // On a fresh directory (clean startup) Quiet behaves identically to None.
                    restart_count += 1;
            let sweep_stats = Arc::clone(&instance.stats);
    /// Minimum `used_bytes / disk_bytes` ratio required to run the key_index sweep.
    ) -> std::pin::Pin<Box<dyn std::future::Future<Output = Option<Bytes>> + Send + 'a>> {
                self.stats
            stats.used_bytes.fetch_add(-freed_bytes, Ordering::Relaxed);
    /// shard are blocked, and only for the duration of that shard's `retain()` pass.
                            _ = tokio::time::sleep(interval) => {
                                if current_secs == 0 { continue 'inner; } // disabled
            stats
        }
        // Writes the complete current key_index as the authoritative final snapshot.
    let major: u32 = parts.next().and_then(|s| s.parse().ok()).unwrap_or(0);
                    native_bridge_common::log_error!(
}
            .store(new_secs, Ordering::Relaxed);
    /// Extracts everything before the first [`SEPARATOR`] (the path prefix),
            return PsyncIoEngineConfig::new().boxed();
                                    }));
                } else {
            let sweep_interval_atomic_clone = Arc::clone(&instance.sweep_interval_secs);
use crate::stats::FoyerStatsCounter;
}
        // Unconditional final persist — graceful shutdown path.
        stale_removed
                    self.stats.miss_count.fetch_add(1, Ordering::Relaxed);
        if snapshot.is_empty() {
    pub(crate) disk_bytes: usize,
    /// Used in the background sweep task to compute `used_bytes / disk_bytes` and compare
                        "[block-cache] sweep task exited unexpectedly (restart #{})", restart_count
        instance
        // persist_interval_secs > 0 required to spawn; 0 means disabled (Drop-only persist).
        if is_new {
                                        Err(_panic_payload) => {
        instance.recover_key_index();
    /// # Failure modes (all non-fatal)
                                            last_persisted = current;
    /// Each call acquires one shard's write lock, filters out keys no longer present in
    /// # `used_bytes` initialisation
                } else {
        }
/// | `choice`   | Behaviour |
}
        }
        let sweep_cursor = Arc::new(AtomicUsize::new(0));
        }
        self._runtime.block_on(self.clear());
            .values()
    /// Construct the guard and immediately increment the counter.
        }
                _ => {
            "[block-cache] key_index recovered: total_keys={} recovered_bytes={} \
                                        }
            "[block-cache] persist interval updated live: {}s",
                    if sweep_token.is_cancelled() { return; }
                         falling back to PsyncIoEngineConfig",
                                    }
        let mut removed_bytes = 0i64;
/// error so the caller can fall back safely.
        raw.trim_start_matches('/')
        // from tokio::select! without waiting for the current sleep to expire.
    pub(crate) key_index: Arc<DashMap<String, HashSet<String>>>,
                if kernel_version_at_least(5, 1) {
            keys.retain(|k| {
        let inner = rt.block_on(async move {
    /// when the cache is lightly loaded and Foyer's disk reclaimer is unlikely to have
        let mut freed_bytes = 0i64;
        }
                    'inner: loop {
        if sweep_interval_secs > 0 {
            let sweep_threshold_atomic_clone = Arc::clone(&instance.sweep_threshold_ratio);
/// ## Persistence
                }
            self.stats
                    self.stats.hit_bytes.fetch_add(size, Ordering::Relaxed);
                                    if ratio < threshold {
        // Remove empty prefix buckets from this shard.
/// The key_index is written:
        for idx_key in &matching {
    ///
            .with_submit_queue_size_threshold(submit_queue_size_threshold_bytes);
    /// `key_index` is internally sharded by DashMap. Each sweep call processes exactly
///
                self.stats
        // If it returns false the key was already present (concurrent put / re-put after eviction)
    pub(crate) persist_interval_secs: Arc<AtomicU64>,
        block_size_bytes: usize,
        self.persist_interval_secs
    let mut parts = release.trim().split('.');
        });
                .build()
/// in O(n) without requiring Foyer to support prefix-scan semantics.
                "[block-cache] key_index recovery: no snapshot (clean startup or crash), dir={}",
        let size = data.len() as i64;
                                return;
                    other
                .storage()
        if stale_removed > 0 {
    /// during a cache stampede when two threads both miss and call `put()` for the same range —
/// Shutdown: the background sweep task and persist task are cancelled immediately via
    }
// ── I/O engine selection ──────────────────────────────────────────────────────
    ///   stale key_index entries left by the disk reclaimer. `0` = disabled (no sweep task
    }
            .index
    /// Intended for use during index or shard deletion, after new reads for the prefix have
        // Update stats here — NOT via Event::Remove — because with memory(1) entries are already
                                    let result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
                    restart_count += 1;
        let snapshot = key_index_store::load_or_empty(&self.cache_dir);
    /// meaning the background sweep task would skip this tick.
                "[block-cache] key_index_sweep: shard={} stale_removed={} freed_bytes={} key_index_size={}",
                .fetch_add(total_evicted as i64, Ordering::Relaxed);
            #[cfg(target_os = "linux")]
        native_bridge_common::log_info!(
                "[block-cache] key_index final persist FAILED on shutdown: {}",
                                native_bridge_common::log_info!("[block-cache] sweep task stopped");
            .iter()
                    );
            // _active_guard dropped here — fetch_sub runs regardless of hit/miss/cancellation
    /// `FoyerCache` is dropped.
}
                    total_removed_bytes += key_byte_size(k);
                native_bridge_common::log_info!(
            &key[..pos]
    ///
    /// after drop to verify the shutdown signal was sent.
                        release
            inner,
        }
}
    pub(crate) stats: Arc<FoyerStatsCounter>,
            persist_interval_secs: persist_interval_atomic,
                    total_removed += 1;
/// compares the major/minor version numbers. Returns `false` on any parse
    /// build the cache (e.g. insufficient disk space or invalid path).
    /// Initialised to `sum(key_byte_size(k))` for ALL keys in the snapshot. May be
    ///
                native_bridge_common::log_info!(
                FsDeviceBuilder::new(dir_clone)
    /// drive the sweep without waiting for the background timer. Does **not** apply
        // self-deadlock: len() tries to read-lock the shard we already write-lock.
                                        "[block-cache] sweep running: usage={:.2}% >= threshold={:.2}%",
            }
                    true
    }
                        "[block-cache] kernel {} — io_uring unavailable (requires >= 5.1), \
            Ok(Ok(())) => {}
    }
            native_bridge_common::log_info!("[block-cache] io_engine=psync forced by config");
            let persist_key_index = Arc::clone(&instance.key_index);
    /// - When below `sweep_threshold_ratio`, Foyer LRU is not actively evicting →
                );
                                        key_index_store::save(&dir_clone, &ki_clone)
            let persist_dir = instance.cache_dir.clone();
                );
        }
            let persist_token = instance.shutdown.clone();
                shard_idx,
            sweep_interval_secs: sweep_interval_atomic,
            let _ = self.inner.clear().await;
    }
}
                loop {
            return UringIoEngineConfig::new().boxed();
            &self.inner,
                        } else {
    /// - `true`  when `sweep_threshold_ratio > 0.0` AND `used_bytes / disk_bytes < threshold`.
            }
                    "[block-cache] unknown io_engine='{}'; falling back to auto-detect",
            total_loaded,
            );
    /// `0.0` = disabled (always sweep, preserving pre-threshold behaviour).
 * this file be licensed under the Apache-2.0 license or a
                }
                        "[block-cache] persist task exited unexpectedly (restart #{})", restart_count
            #[cfg(target_os = "linux")]
        let t0 = Instant::now();
            Err(_) => {
                                            // I/O error — do not update last_persisted, retry next tick.
            self.stats
    ///
                .with_io_engine_config(build_io_engine_config(&io_engine))
                    );
                let mut restart_count = 0u32;
                .expect("[block-cache] HybridCache build failed")
    /// entire key_index is covered, distributing lock pressure across multiple intervals
            );
                                    Self::reconcile_key_index(
    ///
    /// rather than blocking all shards in a single call.
        // after block_on returns.
            .key_index
            .filter(|e| e.key().starts_with(normalized))
                    .expect("[block-cache] FsDevice build failed"),
            "[block-cache] sweep threshold updated live: {:.0}%",
                                            native_bridge_common::log_info!(
                                        }
        sweep_interval_secs: u64,
/// | `"io_uring"` | Force io_uring. Fails at node startup if io_uring is unavailable (e.g. blocked by seccomp/AppArmor in locked-down container environments). |
/// On startup the key_index is bulk-loaded from `key_index.json` inside `disk_dir`
            )
                                            );
            "[block-cache] EVICT_PREFIX prefix='{}' matched_index_keys={} evicted_entries={} key_index_len={}",
            self.stats
        key: &'a CacheKey,
                    Some(Bytes::copy_from_slice(e.value()))
                persist_interval_secs.to_string()
        let mut instance = Self {
                            Duration::from_secs(3600) // effectively disabled: sleep 1 hour
                Ok(Some(e)) => {
    /// Trigger one shard sweep synchronously, advancing the cursor.
        let io_engine_for_log = io_engine.clone(); // clone for use in log after the closure
            &self.key_index,
        // on disk when evict_prefix() is called, so memory.remove() returns None and Event::Remove
        let close_result = self._runtime.block_on(async {
    _runtime: Arc<tokio::runtime::Runtime>,
            native_bridge_common::log_debug!(
 *
                    native_bridge_common::log_error!(
            sweep_threshold_ratio * 100.0,
    ///
    /// Live-updatable persist interval in seconds. `0` = disabled.
// ── FoyerCache ────────────────────────────────────────────────────────────────
    pub(crate) shutdown: CancellationToken,
            }
        let rt =
/// disk read completes). Without this guard, a cancelled future would leave
                            }
        } else {
                .fetch_add(removed_bytes, Ordering::Relaxed);
                    persist_interval_secs
    value: i64,
        let key_index: Arc<DashMap<String, HashSet<String>>> = Arc::new(DashMap::new());
    ///
/// Select the I/O engine based on the operator-configured `choice`.
        // No per-key inner.contains() — the sweep task corrects stale entries post-startup.
            block_size_bytes,
            if let Some((_, keys)) = self.key_index.remove(idx_key) {
impl BlockCache for FoyerCache {
                .memory(1)
        // HashSet::insert returns true only when the key is new.
        disk_bytes: usize,
        let k = raw.to_string();
            instance._runtime.spawn(async move {
#[cfg(target_os = "linux")]
    /// - Skipping `contains()` avoids O(N) hash lookups at startup.
        reinsertion_admit_all: bool,
    match choice {
                .removed_bytes
/// On crash (`Drop` not called), only the Foyer disk data is recovered;
        let recovered_bytes: i64 = snapshot
        let sweep_threshold_atomic = Arc::new(AtomicU64::new(sweep_threshold_ratio.to_bits()));
            if reinsertion_admit_all {
            let sweep_disk_bytes = disk_bytes;
    }
                }
///
///
        Self { counter, value }
            }
        Self::reconcile_key_index(
    /// `HashSet` is used (not `Vec`) so that inserting the same key twice — which can happen
                );
    }
    /// temporarily over-counted by keys Foyer LRU-evicted between the last periodic
    fn clear(&self) -> std::pin::Pin<Box<dyn std::future::Future<Output = ()> + Send + '_>> {
                    );
    ///
#[cfg(target_os = "linux")]
        // ── Spawn background sweep task ───────────────────────────────────────
    ) -> Self {
            let persist_interval = Duration::from_secs(persist_interval_secs);
            }
    /// Absolute path to the Foyer cache directory.
    #[cfg_attr(not(test), allow(dead_code))]
/// The key index allows removing all cached entries sharing a common prefix
    ) -> usize {
                "[block-cache] key_index_sweep: shard={} no stale entries, key_index_size={}",
    /// if changed to 0 while running, the task sleeps 0 s and immediately checks cancellation).
            recovered_bytes,
/// background sweeper → `eviction_count` for disk-reclaimer evictions. Thread-safe.
                engine_config = engine_config
    /// Signals the background sweep task and persist task to stop immediately when
                    let backoff_secs = std::cmp::min(1u64 << restart_count.min(6), 60);
                    // Reset sentinel on each loop entry so the first tick always persists.
}
}
    /// Spreading work across calls bounds the per-call lock-hold time to one shard's
            let sweep_token = instance.shutdown.clone();
                                let result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
impl FoyerCache {
    pub(crate) cache_dir: PathBuf,
        cursor: &Arc<AtomicUsize>,
            );
        let used = self.stats.used_bytes.load(Ordering::Relaxed).max(0) as usize;
    /// Exposed as `pub(crate)` so tests can clone the token and inspect `is_cancelled()`
                native_bridge_common::log_info!(
                "[block-cache] key_index persisted on shutdown: {} prefix buckets, dir={}",
        );
/// is cancelled mid-flight (e.g. a `tokio::select!` timeout fires before the
            let keys: &mut HashSet<String> = value.get_mut();
        // rotating through all shards over successive intervals.
        native_bridge_common::log_info!(
                    if persist_token.is_cancelled() { return; }
            disk_bytes,
        stats: &Arc<FoyerStatsCounter>,
                                            // Panic inside save — log error, continue loop.
    ///   between the last periodic persist and shutdown is corrected by the sweep
                for k in entry.value() {
pub struct FoyerCache {
    #[cfg(test)]
    }
            tokio::time::timeout(std::time::Duration::from_secs(30), self.inner.close()).await
            native_bridge_common::log_info!("[block-cache] io_engine=io_uring forced by config");
                e
                                        "[block-cache] sweep task: reconcile_key_index panicked — sweep continuing"
    /// persist and shutdown. Corrected by sweep.
        // ── Spawn independent persist task ────────────────────────────────────
        // CancellationToken is Clone and Send — cheap to share with background tasks.
    AdmitAll, BlockEngineConfig, DeviceBuilder, FsDeviceBuilder, HybridCache, HybridCacheBuilder,
            // completes). Without the guard, a cancelled future would leave active_in_bytes elevated.
    pub(crate) fn clear_sync(&self) {
    /// Example: `0.75` → only sweep when `used_bytes >= 75 %` of `disk_bytes`.
    ///   Configurable via `block_cache.foyer.key_index_persist_interval_seconds`.
        })
                    self.inner.remove(&k);
        // sweep_interval_secs > 0 required to spawn; 0 means sweep is disabled.
    /// Foyer, and releases the lock. The cursor advances by 1 modulo the shard count so
                let release = std::fs::read_to_string("/proc/sys/kernel/osrelease")
///
        &'a self,
        counter.fetch_add(value, Ordering::Relaxed);
        // of the sweep task. This allows different intervals for sweeping (expensive DashMap
             persist_interval={}s, reinsertion={}, dir={}",
                                    );
    ///
                                        ratio * 100.0, threshold * 100.0
                                    )
            .map(|e| e.key().clone())
    /// Keeps the Tokio runtime alive for the lifetime of the cache.
    /// Atomic stats counters. Exposed for FFM read via `foyer_snapshot_stats`.
        )
                                if let Err(_panic_payload) = result {
//! [`FoyerCache`] — a [`BlockCache`] implementation backed by Foyer.
            }
        let disk_dir: PathBuf = disk_dir.into();
            &self.stats,
            &self.sweep_cursor,
            });
            HybridCacheBuilder::<String, Vec<u8>>::new()
    ///
    /// its own `Arc` clone. In test builds `sweep_once()` reads it via `&self.sweep_cursor`.
    }
    /// Initialise the cache synchronously.
    #[cfg_attr(not(test), allow(dead_code))]
    }
    ///   both post-recovery and live-session stale entries uniformly.
            // "auto" — detect by kernel version (existing logic)
                }
};
        drop(shard);
///
                native_bridge_common::log_info!(
                    "[block-cache] sweep task started: interval={}s", sweep_interval_secs
        let total_loaded: usize = snapshot.index.values().map(|s| s.len()).sum();
                    }
                                }
            cache_dir: disk_dir, // move: dir_clone was consumed by block_on, disk_dir is still owned
                                native_bridge_common::log_info!("[block-cache] persist task stopped");
            let before = keys.len();
                                    let used = sweep_stats.used_bytes.load(Ordering::Relaxed).max(0) as usize;
        // Calling len() while still holding the write lock on shard_idx causes a
                    removed_bytes += key_byte_size(&k);
            stats
                    let mut last_persisted: i64 = i64::MIN;
/// Foyer did not recover) are cleaned up by the background sweep task.
    inner: HybridCache<String, Vec<u8>>,
        // Bulk-insert each bucket: DashMap::insert only needs &self (interior mutability).
                "AdmitAll"
        (used as f64 / self.disk_bytes as f64) < threshold
    #[cfg_attr(not(test), allow(dead_code))]
        // Initialise used_bytes. No put() calls have happened yet so it is 0.
                .with_recover_mode(RecoverMode::Quiet)
    /// Tracks which DashMap shard to sweep next.
    ///   Configurable via `block_cache.foyer.key_index_sweep_threshold`.
    ///   put into the cache. Configurable via `block_cache.foyer.block_size`.
        self.counter.fetch_sub(self.value, Ordering::Relaxed);
use foyer::UringIoEngineConfig;
            .map(|k| key_byte_size(k))
            if persist_interval_secs == 0 {
/// `tokio::select!` without waiting for the current sleep interval to expire.
                .await
            .flat_map(|keys| keys.iter())
            });
            // FileCache.clear() uses recordRemoval() per entry.
    /// (in-RAM index lookup, no disk I/O; false positives on hash collision are harmless).
/// and a set of [`FoyerStatsCounter`] atomic counters.
            } else {
        for value in shard.values_mut() {
        // Spawn the background key_index sweeper: removes entries silently evicted by Foyer's
                // index without raising an error on corrupted pages. Together with
    /// Bulk-load the persisted key_index snapshot into the in-memory DashMap.
    }
use bytes::Bytes;
            // are counted as removed here rather than as evictions. Acceptable — mirrors how
    /// against `sweep_threshold_ratio`. Only accessed inside the async task closure (which
                        }
        let shutdown = CancellationToken::new();
        sweep_threshold_ratio: f64,
                                }));
    ///   (no-op). `0.0` = always sweep (threshold disabled). Range: `[0.0, 1.0]`.
            // ActiveBytesGuard increments active_in_bytes on construction and decrements it in Drop.
    }
/// (written on graceful shutdown and periodically by the persist task). The Foyer
        })
                // after a graceful restart.
        self.sweep_interval_secs.store(new_secs, Ordering::Relaxed);
            let range_len = key.range_len() as i64;
        let stats = FoyerStatsCounter::new();
        disk_dir: impl Into<PathBuf>,
    /// Derive the normalized index key from a cache key.
        self.inner.insert(k.clone(), data.to_vec());
            self.stats.used_bytes.store(0, Ordering::Relaxed);
    /// Uses [`CancellationToken`] rather than `AtomicBool` so that both loops can use
    /// Panics if the Tokio runtime cannot be created or if Foyer fails to
 */
    /// Disk-evicted keys become stale until the sweeper prunes them via `inner.contains(key)`
                            _ = sweep_token.cancelled() => {
                    tokio::time::sleep(Duration::from_secs(backoff_secs)).await;
                .fetch_add(stale_removed as i64, Ordering::Relaxed);
    /// Clear all entries synchronously. Called from the FFM layer.
        other => {
                    let size = e.value().len() as i64;
            .store(new_ratio.to_bits(), Ordering::Relaxed);
                                            native_bridge_common::log_error!(
        let persist_interval_atomic = Arc::new(AtomicU64::new(persist_interval_secs));
                                if current != last_persisted {
                            _ = tokio::time::sleep(persist_interval) => {
            self.key_index.clear();
            // Slightly inaccurate: stale entries (disk-reclaimer-evicted but not yet swept)
    ///
                .with_engine_config(engine_config)
                "RejectAll"
        };
    /// Only accessed inside the async task closure (captured by value) and in test builds
        // Persists the key_index whenever used_bytes changes, on a schedule independent
                shard_idx, stale_removed, freed_bytes, key_index.len()
    /// Maps each index prefix to the **set** of Foyer cache keys stored under that prefix.
        });
                .removed_count
                                return;
    fn as_any(&self) -> &dyn std::any::Any {
        native_bridge_common::log_info!(
    /// - `disk_dir` — directory on the local SSD where Foyer stores its data files.
            {
        self.stats
                    'inner: loop {
        // Normalize prefix: object_store::Path strips leading '/' when building keys,
        self.inner.storage().wait().await;
            let sweep_key_index = Arc::clone(&instance.key_index);
    ///
            } else {
    ///   task within `shard_count × sweep_interval_secs` of startup.
    /// the `sweep_threshold_ratio` guard (that lives in the async task loop).
                    .with_capacity(disk_bytes)
                native_bridge_common::log_info!(
    }
            );
    pub(crate) fn update_sweep_interval(&self, new_secs: u64) {
                                                "[block-cache] persist task: key_index_store::save panicked — persist continuing"
                    .fetch_add(total_removed_bytes, Ordering::Relaxed);
    /// On each interval tick, the sweep loop checks whether the current usage ratio is
            // Delete the persisted key_index files so the next startup does not bulk-load
///
            .with_block_size(block_size_bytes)
                }
            return;
                    tokio::time::sleep(Duration::from_secs(backoff_secs)).await;
    /// # Parameters
/// [`CancellationToken`] when the cache is dropped — both tasks wake from
                        "[block-cache] kernel {} — io_uring available, using UringIoEngineConfig",
        );
                    self.stats
            disk_dir.display()
 * compatible open source license.
            .collect();
        cache: &HybridCache<String, Vec<u8>>,
    }
    /// Update the persist interval live. `0` = disable periodic persist. Takes effect on next sleep.
                                    let ki_clone = Arc::clone(&persist_key_index);
    }
        for (prefix, keys) in snapshot.index {
    /// In production builds this field is not read directly — the background task holds
    /// DashMap locks are acquired and no shard is iterated. This avoids wasting CPU cycles
    /// direct path strings (with leading slash) both map to the same bucket.
    /// Returns `true` if the current usage ratio is below the configured threshold,
            disk_bytes,
    pub(crate) fn update_persist_interval(&self, new_secs: u64) {
            .fetch_add(recovered_bytes, Ordering::Relaxed);
        let mut stale_removed = 0usize;
        let matching: Vec<String> = self
                                    );
/// 2. Unconditionally in `Drop` (graceful shutdown).
            "[block-cache] ready: disk={}B, block_size={}B, io_engine={}, sweep_threshold={:.0}%, \
        );
        let io_engine = io_engine.to_string();
        }
                // to 1 byte opts out of DRAM caching. All entries go directly to the
        }
use std::time::{Duration, Instant};
    /// Update the sweep threshold ratio atomically. Takes effect on next tick.
                        release
                            }
        let sweep_interval_atomic = Arc::new(AtomicU64::new(sweep_interval_secs));
            if reinsertion_admit_all {
        "psync" => {
                                let current = persist_stats.used_bytes.load(Ordering::Relaxed);
                                }
                .with_name("block-cache")
    fn put(&self, key: &CacheKey, data: Bytes) {
    }
    /// - I/O error: logged as WARN, treated as empty.
                        // Read interval on each tick — allows live update without restart.
            return false; // disabled: always sweep
        native_bridge_common::log_info!(
    counter: &'a std::sync::atomic::AtomicI64,
/// Ensures the counter is always restored even when the owning `get()` future
        //
    /// - `disk_bytes` — total disk capacity for this cache.
                    .with_reinsertion_filter(StorageFilter::new().with_condition(AdmitAll));
                .eviction_bytes
        // Bulk-load key_index from disk.
                    let backoff_secs = std::cmp::min(1u64 << restart_count.min(6), 60);
            let sweep_cursor_clone = Arc::clone(&instance.sweep_cursor);
/// a concurrent key index that maps each index prefix to its cached entry keys,
                .eviction_count
            elapsed_ms,
        let shard_idx = cursor.fetch_add(1, Ordering::Relaxed) % shard_count;
            // (e.g. the caller uses tokio::select! with a timeout that fires before the disk read
                                // Panic safety: a panic in reconcile_key_index must not kill the task.
            self.key_index.insert(prefix, keys);
        }
        // Without close(), entries smaller than block_size are lost on restart.
///
/// Reads `/proc/sys/kernel/osrelease` (e.g. `"5.15.0-91-generic"`) and
    /// Entries added by `put()`. Entries removed by `evict_prefix()` and `clear()`.
/*
                                        continue 'inner;
use std::collections::HashSet;
    pub(crate) fn new(counter: &'a std::sync::atomic::AtomicI64, value: i64) -> Self {
        let raw = if let Some(pos) = key.find(SEPARATOR) {
                                                "[block-cache] persist task FAILED: {}", e
    /// - The sweep task (already built and tested) handles stale key cleanup for
/// Stats: `get()` → hit/miss counts; `put()` → `used_bytes`; `evict_prefix()` → `removed_count`;
    ///
    /// `tokio::select!` and wake instantly on cancellation instead of waiting for the
                let release = release.trim();
            self.key_index.len()
use foyer::{
    fn recover_key_index(&mut self) {
    }
        native_bridge_common::log_info!(
        // On clean startup or crash: load_or_empty() returns empty silently.
/// `active_in_bytes` permanently elevated.
    /// entry count, keeping `put()` latency impact minimal — only entries in the swept
    fn evict_prefix(&self, prefix: &str) {
                            }
            .sum();
    /// - Corrupt JSON or version mismatch: logged as WARN, treated as empty.
            for entry in self.key_index.iter() {
                        }
