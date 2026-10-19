                .fetch_add(stale_removed as i64, Ordering::Relaxed);
            .values()
            // ActiveBytesGuard increments active_in_bytes on construction and decrements it in Drop.
    /// Minimum `used_bytes / disk_bytes` ratio required to run the key_index sweep.
    /// via `should_skip_sweep()`.
            self.key_index.insert(prefix, keys);
/// compares the major/minor version numbers. Returns `false` on any parse
    pub(crate) fn sweep_once(&self) -> usize {
                // RecoverMode::Quiet recovers existing disk entries into Foyer's in-RAM
        }
        // Timeout prevents indefinite blocking if the flusher is stuck.
        native_bridge_common::log_info!(
    /// - `io_engine` — I/O engine selection: `"auto"`, `"io_uring"`, or `"psync"`.
                                    let result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
    /// Each call acquires one shard's write lock, filters out keys no longer present in
        instance.recover_key_index();
            tokio::runtime::Runtime::new().expect("[block-cache] failed to create Tokio runtime");
}
            native_bridge_common::log_info!(
            },
                            _ = sweep_token.cancelled() => {
        }
    match choice {
                .with_io_engine_config(build_io_engine_config(&io_engine))
                                if let Err(_panic_payload) = result {
                engine_config = engine_config
        };
    /// Sweep one DashMap shard per call and advance the cursor.
            PsyncIoEngineConfig::new().boxed()
                .storage()
                if cache.contains(k) {
    ///   flushes the key_index to disk. `0` = disabled (only `Drop` persists).
                                            );
    /// Test-only helper — calls [`Self::reconcile_key_index`] directly so tests can
                                }));
            let sweep_interval_atomic_clone = Arc::clone(&instance.sweep_interval_secs);
                                native_bridge_common::log_info!("[block-cache] persist task stopped");
        }
                                        key_index_store::save(&dir_clone, &ki_clone)
                    let backoff_secs = std::cmp::min(1u64 << restart_count.min(6), 60);
        // DashMap::len() acquires read locks on ALL shards (including this one).
    /// Used in the background sweep task to compute `used_bytes / disk_bytes` and compare
/// key_index starts empty (same as before this feature was added).
/// Ensures the counter is always restored even when the owning `get()` future
            prefix, matching.len(), total_evicted, self.key_index.len()
};
                    .fetch_add(total_removed_bytes, Ordering::Relaxed);
                    return UringIoEngineConfig::new().boxed();
            }
        let raw = if let Some(pos) = key.find(SEPARATOR) {
use std::path::PathBuf;
                                    Self::reconcile_key_index(
/// disk read completes). Without this guard, a cancelled future would leave
            native_bridge_common::log_info!("[block-cache] io_engine=io_uring forced by config");
        );
                persist_interval_secs.to_string()
    }
                "disabled".to_string()
        }
        // from tokio::select! without waiting for the current sleep to expire.
    /// Spreading work across calls bounds the per-call lock-hold time to one shard's
            if reinsertion_admit_all {
/// Stats: `get()` → hit/miss counts; `put()` → `used_bytes`; `evict_prefix()` → `removed_count`;
    /// shard are blocked, and only for the duration of that shard's `retain()` pass.
        let t0 = Instant::now();
            let sweep_token = instance.shutdown.clone();
    #[cfg(test)]
            let persist_interval = Duration::from_secs(persist_interval_secs);
                self.stats
                                            last_persisted = current;
            let persist_stats = Arc::clone(&instance.stats);
                        "[block-cache] kernel {} — io_uring unavailable (requires >= 5.1), \
            // (e.g. the caller uses tokio::select! with a timeout that fires before the disk read
        );
/// 2. Unconditionally in `Drop` (graceful shutdown).
    }
                FsDeviceBuilder::new(dir_clone)
            new_ratio * 100.0
                    "[block-cache] HybridCache close TIMED OUT (30s) on shutdown — partial blocks may be lost"
/// | `"io_uring"` | Force io_uring. Fails at node startup if io_uring is unavailable (e.g. blocked by seccomp/AppArmor in locked-down container environments). |
                                        }
                    'inner: loop {
        "io_uring" => {
        let used = self.stats.used_bytes.load(Ordering::Relaxed).max(0) as usize;
                loop {
        native_bridge_common::log_info!("[block-cache] sweep interval updated live: {}s", new_secs);
            if let Err(e) = key_index_store::delete(&self.cache_dir) {
            native_bridge_common::log_info!(
                    total_removed += 1;
            keys.retain(|k| {
        let is_new = self.key_index.entry(idx).or_default().insert(k);
                }
    counter: &'a std::sync::atomic::AtomicI64,
        } else {
    /// `FoyerCache` is dropped.
    /// Update the sweep interval live. `0` = disable sweep. Takes effect on next sleep.
        let stats = FoyerStatsCounter::new();
                "[block-cache] key_index_sweep: shard={} no stale entries, key_index_size={}",
        // Without close(), entries smaller than block_size are lost on restart.
        native_bridge_common::log_info!(
 * compatible open source license.
        disk_dir: impl Into<PathBuf>,
        shard.retain(|_, v| !v.get().is_empty());
    /// Tracks which DashMap shard to sweep next.
    /// rather than blocking all shards in a single call.
                let mut restart_count = 0u32;
        let shard_count = shards.len();
            let persist_token = instance.shutdown.clone();
                            _ = tokio::time::sleep(persist_interval) => {
 * SPDX-License-Identifier: Apache-2.0
            "[block-cache] persist interval updated live: {}s",
        }
            native_bridge_common::log_info!(
            native_bridge_common::log_info!(
            disk_bytes,
        let close_result = self._runtime.block_on(async {
    ///
        cursor: &Arc<AtomicUsize>,
        let io_engine = io_engine.to_string();
                        release
            &self.sweep_cursor,
                                    let ratio = used as f64 / sweep_disk_bytes as f64;
                                }
                }
    /// successive calls rotate fairly through all shards.
}
                                }
                                        ratio * 100.0, threshold * 100.0
    ///   between the last periodic persist and shutdown is corrected by the sweep
                    let mut last_persisted: i64 = i64::MIN;
    /// Update the persist interval live. `0` = disable periodic persist. Takes effect on next sleep.
        // on disk when evict_prefix() is called, so memory.remove() returns None and Event::Remove
            if persist_interval_secs == 0 {
                shard_idx, stale_removed, freed_bytes, key_index.len()
        if total_evicted > 0 {
                                            native_bridge_common::log_error!(
                                            native_bridge_common::log_info!(
        if sweep_interval_secs > 0 {
    /// against `sweep_threshold_ratio`. Only accessed inside the async task closure (which
        // rotating through all shards over successive intervals.
                    .removed_bytes
    /// Atomic stats counters. Exposed for FFM read via `foyer_snapshot_stats`.
                    .fetch_add(total_removed, Ordering::Relaxed);
    }
    ///
    ///   (no-op). `0.0` = always sweep (threshold disabled). Range: `[0.0, 1.0]`.
    /// - Skipping `contains()` avoids O(N) hash lookups at startup.
            .key_index
        for idx_key in &matching {
                    restart_count += 1;
                // recover_key_index() this ensures disk data and key_index are consistent
    }
    ///
            #[cfg(target_os = "linux")]
                // On a fresh directory (clean startup) Quiet behaves identically to None.
                }
    /// Configured disk capacity in bytes.
            return false; // disabled: always sweep
        native_bridge_common::log_info!(
 *
        let inner = rt.block_on(async move {
    }
                    native_bridge_common::log_error!(
            );
use crate::traits::BlockCache;
        // Initialise used_bytes. No put() calls have happened yet so it is 0.
    pub(crate) fn new(counter: &'a std::sync::atomic::AtomicI64, value: i64) -> Self {
    pub(crate) stats: Arc<FoyerStatsCounter>,
                .eviction_bytes
    }
        } else {
        // Compute stats before moving snapshot.index into the DashMap.
            .with_block_size(block_size_bytes)
                    self.stats
use std::time::{Duration, Instant};
        // No per-key inner.contains() — the sweep task corrects stale entries post-startup.
impl Drop for ActiveBytesGuard<'_> {
    /// Trigger one shard sweep synchronously, advancing the cursor.
/// The key_index is written:
            total_loaded,
                                if current_secs == 0 { continue 'inner; } // disabled
                total_evicted += keys.len();
            );
use crate::key_index_store;
    /// Construct the guard and immediately increment the counter.
                    total_removed_bytes += key_byte_size(k);
                                            // Panic inside save — log error, continue loop.
    /// # Design: no per-key validation (no `inner.contains()`)
///
                .memory(1)
                .build()
pub(crate) struct ActiveBytesGuard<'a> {
/// disk data is recovered via `RecoverMode::Quiet`. Stale key_index entries (keys
            }
        let k = raw.to_string();
        }
                        }
        persist_interval_secs: u64,
                    .unwrap_or_else(|_| "unknown".to_string());
        let mut shard = shards[shard_idx].write(); // write lock on ONE shard
        if snapshot.is_empty() {
/// Reads `/proc/sys/kernel/osrelease` (e.g. `"5.15.0-91-generic"`) and
                "[block-cache] key_index persisted on shutdown: {} prefix buckets, dir={}",
///
            // stale keys into a freshly-cleared cache.
                    e
                    }
            }
// ── I/O engine selection ──────────────────────────────────────────────────────
        // Flush partial blocks to SSD before shutdown with a timeout.
            io_engine_for_log,
                                        "[block-cache] sweep running: usage={:.2}% >= threshold={:.2}%",
        &'a self,
/// Select the I/O engine based on the operator-configured `choice`.
        "psync" => {
                for k in entry.value() {
    ///
    /// during a cache stampede when two threads both miss and call `put()` for the same range —
/// (written on graceful shutdown and periodically by the persist task). The Foyer
        instance
                        let current_secs = sweep_interval_atomic_clone.load(Ordering::Relaxed);
 * this file be licensed under the Apache-2.0 license or a
        key: &'a CacheKey,
use foyer::UringIoEngineConfig;
                                return;
    ///   is spawned). Configurable via `block_cache.foyer.key_index_sweep_interval_seconds`.
    /// evicted anything.
            });
                                        &sweep_key_index, &sweep_inner, &sweep_stats, &sweep_cursor_clone,
            return;
            });
            match self.inner.get(&key.as_str().to_string()).await {
    /// Initialised to `sum(key_byte_size(k))` for ALL keys in the snapshot. May be
 */
            // This ensures the counter is restored even if this future is dropped mid-execution
            let _active_guard = ActiveBytesGuard::new(&self.stats.active_in_bytes, range_len);
    /// - `block_size_bytes` — Foyer disk block size. Must be ≥ the largest entry ever
                );
        // HashSet::insert returns true only when the key is new.
                                            );
        // Spawn the background key_index sweeper: removes entries silently evicted by Foyer's
    pub fn new(
        // persist_interval_secs > 0 required to spawn; 0 means disabled (Drop-only persist).
    fn as_any(&self) -> &dyn std::any::Any {
/// Shutdown: the background sweep task and persist task are cancelled immediately via
        self
                                    );
                "RejectAll"
            .iter()
                        } else {
/// | `"psync"`  | Force synchronous pread/pwrite. Use when io_uring is restricted or when predictable syscall-level profiling is needed. |
                    self.stats.hit_count.fetch_add(1, Ordering::Relaxed);
                    self.stats.miss_count.fetch_add(1, Ordering::Relaxed);
    /// a running async task or sleeping.
            sweep_interval_secs: sweep_interval_atomic,
                native_bridge_common::log_info!(
                    native_bridge_common::log_error!(
                    .with_reinsertion_filter(StorageFilter::new().with_condition(AdmitAll));
    }
    /// Live-updatable persist interval in seconds. `0` = disabled.
                                    }
    /// - `persist_interval_secs` — how often (in seconds) the independent persist task
        let shards = key_index.shards();
                            }
    fn index_key(key: &str) -> &str {
                                    let used = sweep_stats.used_bytes.load(Ordering::Relaxed).max(0) as usize;
        // Explicitly release the write lock BEFORE calling key_index.len().
    /// build the cache (e.g. insufficient disk space or invalid path).
                                    }
        // Bulk-insert each bucket: DashMap::insert only needs &self (interior mutability).
            self.stats.used_bytes.store(0, Ordering::Relaxed);
            let mut engine_config = BlockEngineConfig::new(
                .removed_count
                            }
            .store(new_secs, Ordering::Relaxed);
                        .miss_bytes
            );
                                            // I/O error — do not update last_persisted, retry next tick.
    ) -> std::pin::Pin<Box<dyn std::future::Future<Output = Option<Bytes>> + Send + 'a>> {
            sweep_threshold_ratio: sweep_threshold_atomic,
            native_bridge_common::log_debug!(
/// background sweeper → `eviction_count` for disk-reclaimer evictions. Thread-safe.
                        .fetch_add(range_len, Ordering::Relaxed);
    ///   put into the cache. Configurable via `block_cache.foyer.block_size`.
            .flat_map(|keys| keys.iter())
        });
                .removed_bytes
                                let current = persist_stats.used_bytes.load(Ordering::Relaxed);
    ///   Configurable via `block_cache.foyer.io_engine`.
    pub(crate) fn should_skip_sweep(&self) -> bool {
        self.inner.insert(k.clone(), data.to_vec());
                    "[block-cache] unknown io_engine='{}'; falling back to auto-detect",
    ) -> Self {
            stats.used_bytes.fetch_add(-freed_bytes, Ordering::Relaxed);
            .used_bytes
        });
            native_bridge_common::log_info!("[block-cache] io_engine=psync forced by config");
                                        "[block-cache] sweep task: reconcile_key_index panicked — sweep continuing"
                .fetch_add(total_evicted as i64, Ordering::Relaxed);
            Err(_) => {
            self.stats
        self.sweep_interval_secs.store(new_secs, Ordering::Relaxed);
                            }
    ///
                    .expect("[block-cache] FsDevice build failed"),
    ///
}
        let rt =
                                    native_bridge_common::log_debug!(
                    e
///
    /// DashMap locks are acquired and no shard is iterated. This avoids wasting CPU cycles
                    self.stats.hit_bytes.fetch_add(size, Ordering::Relaxed);
        native_bridge_common::log_info!(
impl BlockCache for FoyerCache {
                    );
    /// Maps each index prefix to the **set** of Foyer cache keys stored under that prefix.
            disk_dir.display()
                    .removed_count
    /// # Panics
    ///
            );
    fn get<'a>(
    /// Wait for the storage flusher to drain its write queue.
        match close_result {
    ///
    /// Clear all entries synchronously. Called from the FFM layer.
                                // Panic safety: a panic in reconcile_key_index must not kill the task.
            block_size_bytes,
            let sweep_stats = Arc::clone(&instance.stats);
            .filter(|e| e.key().starts_with(normalized))
/// | `choice`   | Behaviour |
                                return;
                .fetch_add(freed_bytes, Ordering::Relaxed);
    fn recover_key_index(&mut self) {
pub struct FoyerCache {
    /// - `true`  when `sweep_threshold_ratio > 0.0` AND `used_bytes / disk_bytes < threshold`.
use crate::stats::FoyerStatsCounter;
                "[block-cache] key_index_sweep: shard={} stale_removed={} freed_bytes={} key_index_size={}",
    let release = match std::fs::read_to_string("/proc/sys/kernel/osrelease") {
        self.stats
        }
            .index
use crate::range_cache::{key_byte_size, CacheKey, SEPARATOR};
    pub(crate) sweep_interval_secs: Arc<AtomicU64>,
                .with_engine_config(engine_config)
            #[cfg(not(target_os = "linux"))]
            disk_bytes,
    /// Update the sweep threshold ratio atomically. Takes effect on next tick.
//! [`FoyerCache`] — a [`BlockCache`] implementation backed by Foyer.
                .with_recover_mode(RecoverMode::Quiet)
/// On startup the key_index is bulk-loaded from `key_index.json` inside `disk_dir`
            instance._runtime.spawn(async move {
    /// - `disk_dir` — directory on the local SSD where Foyer stores its data files.
    /// when the cache is lightly loaded and Foyer's disk reclaimer is unlikely to have
    pub(crate) fn update_sweep_threshold(&self, new_ratio: f64) {
            elapsed_ms,
             persist_interval={}s, reinsertion={}, dir={}",
            "[block-cache] key_index recovered: total_keys={} recovered_bytes={} \
        // ── Spawn independent persist task ────────────────────────────────────
        let idx = Self::index_key(raw).to_string();
    #[cfg_attr(not(test), allow(dead_code))]
        // index_key() normalizes by stripping leading '/' — evict_prefix uses the same normalization.
                // disk tier (FsDevice) below.
        );
                    "[block-cache] key_index clear: failed to delete snapshot files: {}",
/// and a set of [`FoyerStatsCounter`] atomic counters.
    /// Entries added by `put()`. Entries removed by `evict_prefix()` and `clear()`.
                                    native_bridge_common::log_error!(
                            Duration::from_secs(3600) // effectively disabled: sleep 1 hour
        // never fires.
                                        Ok(Err(e)) => {
    /// # Parameters
///
        // Sweep cursor starts at shard 0 and advances by one per sweep call,
                native_bridge_common::log_info!(
    /// Example: `0.75` → only sweep when `used_bytes >= 75 %` of `disk_bytes`.
    /// `tokio::select!` and wake instantly on cancellation instead of waiting for the
/// ## Persistence
impl<'a> ActiveBytesGuard<'a> {
    IoEngineConfig, PsyncIoEngineConfig, RecoverMode, StorageFilter,
/// a concurrent key index that maps each index prefix to its cached entry keys,
        self.counter.fetch_sub(self.value, Ordering::Relaxed);
    #[cfg_attr(not(test), allow(dead_code))]
        let disk_dir: PathBuf = disk_dir.into();
                                native_bridge_common::log_info!("[block-cache] sweep task stopped");
    ///
                let release = release.trim();
                    "[block-cache] HybridCache close FAILED on shutdown: {}",
    ///
///
        buffer_pool_size_bytes: usize,
                    if persist_token.is_cancelled() { return; }
 * The OpenSearch Contributors require contributions made to
        block_size_bytes: usize,
        //
    /// - `false` when `sweep_threshold_ratio > 0.0` AND `used_bytes / disk_bytes >= threshold`.
///
        // sweep_interval_secs > 0 required to spawn; 0 means sweep is disabled.
                    );
            // Slightly inaccurate: stale entries (disk-reclaimer-evicted but not yet swept)
        }
// ── ActiveBytesGuard ─────────────────────────────────────────────────────────
impl Drop for FoyerCache {
                                let result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
    /// - `disk_bytes` — total disk capacity for this cache.
fn build_io_engine_config(choice: &str) -> Box<dyn IoEngineConfig> {
                loop {
            #[cfg(target_os = "linux")]
        // Normalize prefix: object_store::Path strips leading '/' when building keys,
///
        stats: &Arc<FoyerStatsCounter>,
/// |------------|-----------|
            recovered_bytes,
use bytes::Bytes;
            return PsyncIoEngineConfig::new().boxed();
    /// - Missing file (clean startup or crash): silently treated as empty.
        sweep_interval_secs: u64,
use std::sync::Arc;
    ///   stale key_index entries left by the disk reclaimer. `0` = disabled (no sweep task
        // of the sweep task. This allows different intervals for sweeping (expensive DashMap
        let size = data.len() as i64;
                    // Derive byte size from key before removing: "path\x1Fstart-end" → end-start.
        // On clean startup or crash: load_or_empty() returns empty silently.
        let key_index: Arc<DashMap<String, HashSet<String>>> = Arc::new(DashMap::new());
        if stale_removed > 0 {
            }
        // after block_on returns.
    /// current sleep interval to expire before checking the flag.
                    restart_count += 1;
                    let backoff_secs = std::cmp::min(1u64 << restart_count.min(6), 60);
    /// On each interval tick, the sweep loop checks whether the current usage ratio is
        self._runtime.block_on(self.clear());
        Err(_) => return false,
    /// Foyer, and releases the lock. The cursor advances by 1 modulo the shard count so
    /// Keeps the Tokio runtime alive for the lifetime of the cache.
        })
                for k in keys {
            stats,
                .used_bytes
                                let threshold = f64::from_bits(sweep_threshold_atomic_clone.load(Ordering::Relaxed));
        // Calling len() while still holding the write lock on shard_idx causes a
        self.sweep_threshold_ratio
            let sweep_disk_bytes = disk_bytes;
    #[cfg(test)]
                    false
            } else {
    /// `key_index` is internally sharded by DashMap. Each sweep call processes exactly
    /// - When below `sweep_threshold_ratio`, Foyer LRU is not actively evicting →
            .collect();
/// `tokio::select!` without waiting for the current sleep interval to expire.
    /// `used_bytes` is initialised to the sum of all their byte sizes.
        stale_removed
    /// - The sweep task (already built and tested) handles stale key cleanup for
                "AdmitAll"
            "[block-cache] EVICT_PREFIX prefix='{}' matched_index_keys={} evicted_entries={} key_index_len={}",
        // Writes the complete current key_index as the authoritative final snapshot.
                    );
                                }
    }
        let threshold = f64::from_bits(self.sweep_threshold_ratio.load(Ordering::Relaxed));
            if reinsertion_admit_all {
        };
/// Invalid values are treated as `"auto"` with a warning.
/// 1. By the independent periodic persist task every `persist_interval_secs` seconds
    fn drop(&mut self) {
        Box::pin(async {
    pub(crate) cache_dir: PathBuf,
        let normalized = prefix.trim_start_matches('/');
    /// # `used_bytes` initialisation
    /// Uses [`CancellationToken`] rather than `AtomicBool` so that both loops can use
            HybridCacheBuilder::<String, Vec<u8>>::new()
        // If it returns false the key was already present (concurrent put / re-put after eviction)
            }
                    'inner: loop {
}
    /// already been stopped. If a `put()` happens to race with this call on the same prefix,
    }
    /// Used to write/read `key_index.json` for persistence and recovery.
                                if threshold > 0.0 {
                e
                // Foyer is a hybrid (DRAM + disk) cache; setting the memory capacity
        if persist_interval_secs > 0 {
            if total_removed > 0 {
    let minor: u32 = parts.next().and_then(|s| s.parse().ok()).unwrap_or(0);
        let recovered_bytes: i64 = snapshot
                    "[block-cache] persist task started: interval={}s",
        let matching: Vec<String> = self
        key_index: &Arc<DashMap<String, HashSet<String>>>,
    ) -> usize {
            key
    /// entire key_index is covered, distributing lock pressure across multiple intervals
        let shard_idx = cursor.fetch_add(1, Ordering::Relaxed) % shard_count;
#[cfg(target_os = "linux")]
    /// the `sweep_threshold_ratio` guard (that lives in the async task loop).
                                    )
        // Update stats here — NOT via Event::Remove — because with memory(1) entries are already
                                    match result {
    pub async fn wait_for_flush(&self) {
    /// if changed to 0 while running, the task sleeps 0 s and immediately checks cancellation).
///
    /// captures it by value) and in test builds via `should_skip_sweep()`.
                    let size = e.value().len() as i64;
impl FoyerCache {
        for value in shard.values_mut() {
                .expect("[block-cache] HybridCache build failed")
/*
        })
    /// that new entry will also be evicted — which is expected, since the prefix is going away.
        submit_queue_size_threshold_bytes: usize,
            Ok(Err(e)) => {
                        "[block-cache] persist task exited unexpectedly (restart #{})", restart_count
                // Disable the in-memory tier — this cache is disk-only.
            let sweep_inner = instance.inner.clone();
        // ── Spawn background sweep task ───────────────────────────────────────
        let mut total_evicted = 0usize;
                                if current != last_persisted {
    /// one shard and advances this cursor by 1. Over `shard_count` sweep cycles the
        let mut freed_bytes = 0i64;
        // and we must NOT increment used_bytes again — the caller already paid for it on the first put.
        let mut instance = Self {
                } else {
                    native_bridge_common::log_info!(
                let release = std::fs::read_to_string("/proc/sys/kernel/osrelease")
    pub(crate) shutdown: CancellationToken,
            &self.stats,
    ///
            .fetch_add(recovered_bytes, Ordering::Relaxed);
        sweep_threshold_ratio: f64,
                );
    ///
    /// `object_store::Path` (no leading slash) and keys from tests or
                            }
                    .with_capacity(disk_bytes)
    /// `HashSet` is used (not `Vec`) so that inserting the same key twice — which can happen
                            Duration::from_secs(current_secs)
            let sweep_cursor_clone = Arc::clone(&instance.sweep_cursor);
            let keys: &mut HashSet<String> = value.get_mut();
    /// - `sweep_threshold_ratio` — minimum usage ratio (`used_bytes / disk_bytes`) required
            }
/// Disk block cache with prefix-based eviction support backed by Foyer.
        }
        let total_loaded: usize = snapshot.index.values().map(|s| s.len()).sum();
            &self.inner,
        let raw = key.as_str();
                self.cache_dir.display()
            panic!("[block-cache] io_engine=io_uring requested but io_uring is not supported on non-Linux platforms");
                            _ = persist_token.cancelled() => {
            }
        disk_bytes: usize,
        }
    AdmitAll, BlockEngineConfig, DeviceBuilder, FsDeviceBuilder, HybridCache, HybridCacheBuilder,
                    }
    /// - Corrupt JSON or version mismatch: logged as WARN, treated as empty.
        let persist_interval_atomic = Arc::new(AtomicU64::new(persist_interval_secs));
    /// entry count, keeping `put()` latency impact minimal — only entries in the swept
                }
                .with_name("block-cache")
        self.persist_interval_secs
    ///
        raw.trim_start_matches('/')
}
///
    ///
            stale_removed += before - keys.len();
}
            new_secs
                // index without raising an error on corrupted pages. Together with
    /// then strips any leading `/` so that keys stored by DataFusion's
                                    // Panic safety: a panic in save must not kill the task.
        Box::pin(async move {
                .await
            .sum();
            let sweep_threshold_atomic_clone = Arc::clone(&instance.sweep_threshold_ratio);
                if kernel_version_at_least(5, 1) {
                .fetch_add(removed_bytes, Ordering::Relaxed);
                                    let dir_clone = persist_dir.clone();
    _runtime: Arc<tokio::runtime::Runtime>,
            let range_len = key.range_len() as i64;
    /// `removed_bytes`, and related stats.
                                    let ki_clone = Arc::clone(&persist_key_index);
        // scan) vs persisting (cheap file write).
    }
                self.key_index.len(),
                }
                native_bridge_common::log_info!(
                    Some(Bytes::copy_from_slice(e.value()))
                    .build()
            inner,
    ///
            } else {
                .eviction_count
/// Foyer did not recover) are cleaned up by the background sweep task.
                    removed_bytes += key_byte_size(&k);
    /// # Returns
    /// Only accessed inside the async task closure (captured by value) and in test builds
        (used as f64 / self.disk_bytes as f64) < threshold
                                        continue 'inner;
        counter.fetch_add(value, Ordering::Relaxed);
    pub(crate) disk_bytes: usize,
}
                .fetch_add(-removed_bytes, Ordering::Relaxed);
                    tokio::time::sleep(Duration::from_secs(backoff_secs)).await;
                        // Read interval on each tick — allows live update without restart.
    ///
        }
            // are counted as removed here rather than as evictions. Acceptable — mirrors how
    /// persist and shutdown. Corrected by sweep.
            // Delete the persisted key_index files so the next startup does not bulk-load
                }
use dashmap::DashMap;
/// On crash (`Drop` not called), only the Foyer disk data is recovered;
use std::sync::atomic::{AtomicU64, AtomicUsize, Ordering};
                }
            // _active_guard dropped here — fetch_sub runs regardless of hit/miss/cancellation
            }
                }
            &key[..pos]
    pub(crate) persist_interval_secs: Arc<AtomicU64>,
///
                    // Reset sentinel on each loop entry so the first tick always persists.
    /// Disk-evicted keys become stale until the sweeper prunes them via `inner.contains(key)`
            &self.key_index,
        // disk reclaimer. inner.contains() is an in-RAM index lookup (no disk I/O).
                Ok(Some(e)) => {
            // Accumulate removed stats from key_index before wiping.
        } else {
#[cfg(target_os = "linux")]
                        "[block-cache] kernel {} — io_uring available, using UringIoEngineConfig",
            if other != "auto" {
            shutdown,
    /// All keys in the snapshot are inserted directly into `key_index` and
        let shutdown = CancellationToken::new();
    major > required_major || (major == required_major && minor >= required_minor)
        // Clone disk_dir only for the async closure; the original is moved into cache_dir
/// [`CancellationToken`] when the cache is dropped — both tasks wake from
    /// Test-only helper — lets tests verify the threshold guard logic without needing
                    persist_interval_secs
            stats
    /// direct path strings (with leading slash) both map to the same bucket.
    }
    /// Extracts everything before the first [`SEPARATOR`] (the path prefix),
                );
                );
                                        }
    /// meaning the background sweep task would skip this tick.
    ///   to run the sweep. If the ratio is below this threshold the sweep tick is skipped
                                    if ratio < threshold {
    /// In production builds this field is not read directly — the background task holds
            });
                        let interval = if current_secs == 0 {
        let mut stale_removed = 0usize;
    };
    inner: HybridCache<String, Vec<u8>>,
    ///
    ///
/// | `"auto"`   | Detect at runtime: io_uring on Linux ≥ 5.1, psync otherwise (default). |
    /// strictly below this threshold. If so, the sweep is skipped entirely (no-op) — no
                         falling back to PsyncIoEngineConfig",
    ///
        }
                self.stats
/// Return `true` if the running Linux kernel is >= `(major, minor)`.
    ///   the snapshot is accurate. Any minor inaccuracy from entries LRU-evicted
    /// Intended for use during index or shard deletion, after new reads for the prefix have
            }
    #[cfg_attr(not(test), allow(dead_code))]
    let major: u32 = parts.next().and_then(|s| s.parse().ok()).unwrap_or(0);
                                        Ok(Ok(())) => {
                _ => {
            self.stats
    fn drop(&mut self) {
        drop(shard);
        // Unconditional final persist — graceful shutdown path.
        // Cancel the background sweep task and persist task so they wake immediately
    /// Bulk-load the persisted key_index snapshot into the in-memory DashMap.
        Self::reconcile_key_index(
    pub(crate) fn update_persist_interval(&self, new_secs: u64) {
    pub(crate) key_index: Arc<DashMap<String, HashSet<String>>>,
                    "[block-cache] sweep task started: interval={}s", sweep_interval_secs
        let dir_clone = disk_dir.clone();
    ///   Configurable via `block_cache.foyer.key_index_sweep_threshold`.
    }
    fn clear(&self) -> std::pin::Pin<Box<dyn std::future::Future<Output = ()> + Send + '_>> {
/// `active_in_bytes` permanently elevated.
            tokio::time::timeout(std::time::Duration::from_secs(30), self.inner.close()).await
    pub(crate) fn clear_sync(&self) {
            "[block-cache] sweep threshold updated live: {:.0}%",
                        tokio::select! {
        let snapshot = key_index_store::load_or_empty(&self.cache_dir);
        // Persists the key_index whenever used_bytes changes, on a schedule independent
            let before = keys.len();
                    None
                                    }));
        let sweep_threshold_atomic = Arc::new(AtomicU64::new(sweep_threshold_ratio.to_bits()));
        native_bridge_common::log_info!(
    fn evict_prefix(&self, prefix: &str) {
    pub(crate) sweep_cursor: Arc<AtomicUsize>,
                                                "[block-cache] persist task FAILED: {}", e
    }
    /// # Failure modes (all non-fatal)
}
        other => {
    /// Absolute path to the Foyer cache directory.
use tokio_util::sync::CancellationToken;
    ///   Configurable via `block_cache.foyer.key_index_persist_interval_seconds`.
        // Bulk-load key_index from disk.
        Self { counter, value }
                key_index.len()
    }
        // Remove empty prefix buckets from this shard.
    pub(crate) fn update_sweep_interval(&self, new_secs: u64) {
            );
    /// Initialise the cache synchronously.
    /// Signals the background sweep task and persist task to stop immediately when
    }
                "[block-cache] key_index recovery: no snapshot (clean startup or crash), dir={}",
            sweep_cursor,
    /// Returns `true` if the current usage ratio is below the configured threshold,
            let mut total_removed_bytes = 0i64;
/// ## Recovery
                native_bridge_common::log_info!(
        let mut removed_bytes = 0i64;
        let sweep_cursor = Arc::new(AtomicUsize::new(0));
    /// Live-updatable sweep interval in seconds. `0` = disabled (task uses this only to sleep;
    /// - `sweep_interval_secs` — how often (in seconds) the background sweeper prunes
        // CancellationToken is Clone and Send — cheap to share with background tasks.
            instance._runtime.spawn(async move {
                // after a graceful restart.
/// error so the caller can fall back safely.
            let persist_key_index = Arc::clone(&instance.key_index);
            _runtime: Arc::new(rt),
                self.cache_dir.display()
/// in O(n) without requiring Foyer to support prefix-scan semantics.
        }
    /// Exposed as `pub(crate)` so tests can clone the token and inspect `is_cancelled()`
        }
        }
                    other
                    tokio::time::sleep(Duration::from_secs(backoff_secs)).await;
        if let Err(e) = key_index_store::save(&self.cache_dir, &self.key_index) {
                    native_bridge_common::log_info!(
        );
    /// temporarily over-counted by keys Foyer LRU-evicted between the last periodic
            sweep_threshold_ratio * 100.0,
                );
    /// its own `Arc` clone. In test builds `sweep_once()` reads it via `&self.sweep_cursor`.
    }
                                                "[block-cache] persist task: key_index_store::save panicked — persist continuing"
            .map(|e| e.key().clone())
        io_engine: &str,
            let persist_dir = instance.cache_dir.clone();
            }
    ///
            let mut total_removed = 0i64;
                    true
                } else {
            persist_interval_secs: persist_interval_atomic,
        // self-deadlock: len() tries to read-lock the shard we already write-lock.
                let mut restart_count = 0u32;
    /// after drop to verify the shutdown signal was sent.
            Ok(Ok(())) => {}
                    freed_bytes += key_byte_size(k);
        Ok(s) => s,
    ///
        cache: &HybridCache<String, Vec<u8>>,
///    (when `used_bytes` has changed since the last write — zero-write when idle).
            // FileCache.clear() uses recordRemoval() per entry.
                    if sweep_token.is_cancelled() { return; }
        )
        if is_new {
            for entry in self.key_index.iter() {
            .with_submit_queue_size_threshold(submit_queue_size_threshold_bytes);
                    self.inner.remove(&k);
use std::collections::HashSet;
    }
    /// is a no-op. This prevents double-counting in `used_bytes`, `eviction_bytes`,
                                        }
                native_bridge_common::log_info!(
        reinsertion_admit_all: bool,
            {
/// Increments `active_in_bytes` when created and decrements it when dropped.
            let sweep_key_index = Arc::clone(&instance.key_index);
    /// `0.0` = disabled (always sweep, preserving pre-threshold behaviour).
        for (prefix, keys) in snapshot.index {
                "[block-cache] key_index final persist FAILED on shutdown: {}",
                );
    /// drive the sweep without waiting for the background timer. Does **not** apply
                shard_idx,
    /// Rationale:
                        };
    /// - `false` when `sweep_threshold_ratio == 0.0` (threshold disabled → never skip).
    /// Panics if the Tokio runtime cannot be created or if Foyer fails to
/// Wraps a Foyer [`HybridCache`] configured as a disk-only store (memory tier = 1 byte),
                // to 1 byte opts out of DRAM caching. All entries go directly to the
    }
}
            .map(|k| key_byte_size(k))
                        tokio::select! {
            )
        let elapsed_ms = t0.elapsed().as_millis() as u64;
    /// After this returns, all previously put() entries are on SSD and findable via get().
            let _ = self.inner.clear().await;
        let io_engine_for_log = io_engine.clone(); // clone for use in log after the closure
            return UringIoEngineConfig::new().boxed();
            // "auto" — detect by kernel version (existing logic)
            .store(new_ratio.to_bits(), Ordering::Relaxed);
        self.shutdown.cancel();
                        }
    /// Derive the normalized index key from a cache key.
            if let Some((_, keys)) = self.key_index.remove(idx_key) {
    value: i64,
    ///   both post-recovery and live-session stale entries uniformly.
        if threshold <= 0.0 {
    let mut parts = release.trim().split('.');
    pub(crate) sweep_threshold_ratio: Arc<AtomicU64>,
// ── FoyerCache ────────────────────────────────────────────────────────────────
            self.key_index.clear();
                            _ = tokio::time::sleep(interval) => {
            stats
    /// (in-RAM index lookup, no disk I/O; false positives on hash collision are harmless).
fn kernel_version_at_least(required_major: u32, required_minor: u32) -> bool {
/// is cancelled mid-flight (e.g. a `tokio::select!` timeout fires before the
            self.stats
            },
            .with_buffer_pool_size(buffer_pool_size_bytes)
            "[block-cache] ready: disk={}B, block_size={}B, io_engine={}, sweep_threshold={:.0}%, \
/// The key index allows removing all cached entries sharing a common prefix
                    );
    }
    fn reconcile_key_index(
use foyer::{
            // completes). Without the guard, a cancelled future would leave active_in_bytes elevated.
                native_bridge_common::log_info!(
            key_index,
                        release
            cache_dir: disk_dir, // move: dir_clone was consumed by block_on, disk_dir is still owned
    ///   task within `shard_count × sweep_interval_secs` of startup.
        // ── Construct instance ────────────────────────────────────────────────
             elapsed_ms={} prefix_buckets={}",
    ///
    }
                                        Err(_panic_payload) => {
                        "[block-cache] sweep task exited unexpectedly (restart #{})", restart_count
        );
        let sweep_interval_atomic = Arc::new(AtomicU64::new(sweep_interval_secs));
    fn put(&self, key: &CacheKey, data: Bytes) {
            self.stats.used_bytes.fetch_add(size, Ordering::Relaxed);
            self.key_index.len()
                                    );
    /// - I/O error: logged as WARN, treated as empty.
        self.inner.storage().wait().await;
