            IO_ENGINE,
        BLOCK_SIZE * 2,
            .used_bytes
            engine.as_ptr(),
        "evict_prefix must remove recovered shard1 entries"
        TEST_CACHE_DISK_BYTES,
            .join(crate::key_index_store::KEY_INDEX_FILENAME)
/// be identical since Foyer is single-tier (both sections mirror each other).
            TEST_SUBMIT_QUEUE_SIZE,
        cache
 * The OpenSearch Contributors require contributions made to
/// of the hit/miss outcome.
    assert!(cache.key_index.contains_key("data/file.parquet"));
    assert_eq!(Arc::strong_count(&*boxed), 2);
fn drop_cancels_the_token() {
        TEST_CACHE_DISK_BYTES,
    cache.put(&key, Bytes::from_static(b"after"));
    );
            TEST_CACHE_DISK_BYTES,
                .join(key_index_store::KEY_INDEX_FILENAME)
    let eviction_bytes_before = cache
    );
    assert_eq!(parsed["version"], 1, "version must be 1");
    const RANGE_SIZE: u64 = 1024;
        TEST_BUFFER_POOL_SIZE,
            .used_bytes
            .load(std::sync::atomic::Ordering::Relaxed),
        512,
/// The previous approach created a brand-new `tokio::runtime::Runtime` for every single
        0.0,
}
            TEST_BUFFER_POOL_SIZE,
    assert_eq!(
    // Drop cancels the token — the 'inner loop's cancelled() arm fires `return`.
    std::thread::sleep(std::time::Duration::from_millis(100));
    let removed_bytes_after = cache
fn ffm_snapshot_stats_valid_ptr_returns_zero_and_fills_buffer() {
        "data entry within the limit must be cached"
    );
        cache
    let dir = TempDir::new().unwrap();
    );
    }
            0,
        "key_index must be empty after clear() deleted the snapshot"
    // clear() calls key_index_store::delete() which removes the file.
    let used_bytes_after = cache
/// A second FoyerCache opens the same dir (recovered used_bytes > 0).
    let r2 = block_on(cache.get(&range_cache_key("/data/keep.parquet", 512, 1024)));
            false,
    let dir = TempDir::new().unwrap();
        "column index must hit"
    let used_bytes_before = cache
    assert!(result.is_some(), "cache must be usable after catch_unwind");
        "key_index.json must be > 100KB for 10k entries, got {bytes}"
    );
            .stats
    );
    let shards_with_entries = shards.iter().filter(|s| !s.read().is_empty()).count();
            0,
    );
        TEST_CACHE_BLOCK_SIZE,
        BLOCK_SIZE * 2,
    assert_eq!(result, 0);
    cache2.evict_prefix("/data/shard1");
    let dir = TempDir::new().unwrap();
fn sweep_once_removes_empty_prefix_buckets_and_updates_eviction_bytes() {
/// We simulate this by constructing an ActiveBytesGuard directly and dropping it
        "key_index must be empty on clean startup"
        "stale key must be present immediately after bulk-load recovery"
            0,
#[test]
        for i in 0..ITERATIONS {
    // decrement used_bytes.
        TEST_SUBMIT_QUEUE_SIZE,
    let removed_bytes = cache
        rc < 0,
        ".key_index.json.tmp must not exist after clean startup"
/// 3. Query: DataFusion reads data → miss → S3 → put() → data cache
        BLOCK_SIZE,
        0.0,
        Some(b"fresh".as_slice())
    cache.evict_prefix("/data/target.parquet");
        !dir.path()
    drop(cache);
    let engine = IO_ENGINE.as_bytes();
    );
    let token: CancellationToken = cache.shutdown.clone();
        Bytes::from_static(b"meta"),
            std::thread::sleep(std::time::Duration::from_millis(100));
            .eviction_count
}
        dir.path(),
        let count = cache
        0,
/// - `used_bytes` is never negative (double-subtraction would indicate stat corruption).
    assert_eq!(
        })
        true,
        false,
}
/// Populate 10k entries, call clear(), verify the key_index is empty and
    assert_eq!(
    // Two ranges: 0-100 = 100 bytes, 100-300 = 200 bytes → total 300 bytes.
///
#[test]
fn clear_on_empty_cache_does_not_change_removed_stats() {
        .used_bytes
            dir_str.as_ptr(),
            .map(|k| format!("{prefix}\x1F{}-{}", k * 4096, (k + 1) * 4096))
            .stats
    );
fn multiple_ranges_for_same_file_are_independent() {
        "key_index.json must exist after graceful shutdown"
        let deadline = std::time::Instant::now() + std::time::Duration::from_secs(5);
/// Key alignment: exact range match = hit, subset/superset = miss.
    cache.sweep_once();
        Some(b"column_index_bytes".as_slice())
            .load(std::sync::atomic::Ordering::Relaxed),
    let evictor_cache = Arc::clone(&cache);
    );
fn no_tmp_file_left_after_graceful_shutdown() {
        TEST_SUBMIT_QUEUE_SIZE,
    // Set cursor to last shard index.
/// Negative used_bytes (which can transiently occur due to relaxed ordering on
            .used_bytes
    assert!(result < 0);
    let cache = FoyerCache::new(
        block_on(tiered.metadata_cache().get(&big_key)).is_none(),
    // clear() must increment removed_count and removed_bytes from key_index
            .exists(),
    let shard_count = cache.key_index.shards().len();
    );
    }
            writer_cache.put(&key, Bytes::from_static(b"data"));
            TEST_SUBMIT_QUEUE_SIZE,
            "used_bytes must decrease after evict"
        block_on(tiered.get(&data_key)).map(|b| b.len()),
    assert_eq!(
    );
        0,
}
    // Take ownership and immediately check the strong count via a clone probe.
fn sweep_threshold_disabled_never_skips() {
        let cache = FoyerCache::new(
    }
/// even after a brief sleep, and the cache remains usable.
            .used_bytes
// ── Periodic persist task tests ──────────────────────────────────────────────
        // Drop writes key_index.json.
            .exists(),
        BLOCK_SIZE,
    };
#[test]
}
}
        .stats
            0,
    cache.evict_prefix("/data/other.parquet");
use crate::foyer::foyer_cache::FoyerCache;
        .path()
        TEST_CACHE_DISK_BYTES as i64,
        dir.path(),
        // Wait 2.5 intervals with NO new puts — used_bytes is unchanged so persist must NOT fire.
        cache.key_index.len(),
    tiered.clear_sync();
        foyer_create_cache(
            256,
        0,
    {
    assert!(ptr < 0);
    (cache, dir)
        let index = snap["index"].as_object().unwrap();
}
        cache.key_index.is_empty(),
        0
    // Inject stale keys with known sizes:
    assert_eq!(
        0,
        used_before
    for i in 0u64..TOTAL_WRITES as u64 {
        );
            native_bridge_common::error::native_error_free(-result);
        .stats
    let ptr = unsafe {
        IO_ENGINE,
#[test]
/// active_in_bytes is 0 before a get(), positive during, and 0 after.
/// foyer_snapshot_stats with null ptr returns negative.
    assert!(
    {
        );
        "empty prefix bucket must be removed"
fn sweep_once_removes_empty_prefix_buckets() {
    );
        0,
/// clear_sync() empties both tiers. This is the production entry point
    assert!(block_on(tiered.metadata_cache().get(&col_a_key)).is_none());
    // It does NOT mean the entry is gone — it is still alive on disk.
        0,
    );
/// and used_bytes must equal exactly 1× the entry size (not N× for N threads).
    // Build a DashMap with 100 prefixes × 100 keys = 10k entries.
    .unwrap();
    }
 */
        .collect();
                .unwrap();
    for p in 0..NUM_PREFIXES {
/// VM-03: zero-byte key_index.json → treated as corrupt → clean startup.
    let data_cache = Arc::new(FoyerCache::new(
    let eviction_bytes_before = cache
fn tiered_cache_put_metadata_skips_oversized_entry() {
        cache
            .load(std::sync::atomic::Ordering::Relaxed),
        data_dir.path(),
        data_misses_before
        cache.should_skip_sweep(),
            IO_ENGINE,
fn sweep_cursor_preset_is_respected() {
        .eviction_count
/// After a cursor-based sweep that removes stale keys, the cache must still
        // cache is dropped here — Drop also writes a final snapshot
    tiered.put_metadata(&s0, Bytes::from_static(b"shard0"));
    assert_eq!(
/// A single-tier FoyerCache (metadata_cache_ratio=0) inherits the
    assert!(token.is_cancelled(), "token must be cancelled after drop");
    assert_eq!(
            0.0,
        TEST_BUFFER_POOL_SIZE,
        }
    );
        .load(std::sync::atomic::Ordering::Relaxed);
            native_bridge_common::error::native_error_free(-ptr);
        IO_ENGINE,
            .exists(),
    let used = cache
    // Sections 0 and 1 are identical (Foyer is currently single-tier).
            .stats
        .key_index
        .removed_count
    // used_bytes must NOT be incremented again.
    assert!(
        let cache = FoyerCache::new(
    // Evict first 50 prefixes.
    if ptr < 0 {
#[test]
}
        0.0,  // threshold disabled
        IO_ENGINE,
        dashmap::SharedValue::new({
    assert!(result.is_none());
/// Each call to sweep_once() processes exactly one shard.
    assert!(ptr < 0);
    }
fn graceful_shutdown_snapshot_is_valid_json_with_correct_content() {
        TEST_CACHE_BLOCK_SIZE,
/// indefinitely waiting for thread allocation.
    cache.put(&key, Bytes::from_static(b"updated"));
        .load(std::sync::atomic::Ordering::Relaxed);
        "usage=100% > threshold=75%: sweep must NOT be skipped"
        .load(std::sync::atomic::Ordering::Relaxed);
/// The cache starts with an empty key_index and is fully functional.
    );
    // Second instance: recover from the snapshot.
            dir_str.as_ptr(),
            0,
    );
        .key_index
}
        put_range(&cache1, "/data/reset_test.parquet", 0, 100, &vec![0u8; 100]);
            TEST_CACHE_DISK_BYTES,
        cache.put(&key, Bytes::from_static(b"hello"));
    // Run full sweep (16 cycles to guarantee coverage).
        cache
        .collect();
        false,
#[test]
    let cache = FoyerCache::new(
        };
///
    // usage = 90% → above 75% → do NOT skip
            evictor_cache.evict_prefix("/data/file.parquet");
    let removed_bytes_before = cache
    let (cache, _dir) = test_cache();
            .key_index
        TEST_BUFFER_POOL_SIZE,
        0
//! Unit tests for [`FoyerCache`] and the FFM lifecycle API.
        .insert("data/bad.parquet-not-a-range-key".to_string());
    {
const TEST_SUBMIT_QUEUE_SIZE: usize = 2 * 1024 * 1024; // 2 MB submit queue (≥ 2× buffer pool)
    // Live key must remain; stale key must be gone.
        used >= 0,
    let key = range_cache_key("/data/file.parquet", 0, 1024);
    );
        .sweep_cursor
fn recovery_with_no_snapshot_is_clean_startup() {
#[test]
// ── key_index integrity ───────────────────────────────────────────────────────
            0,
        cache.key_index.is_empty(),
}
    }
            .used_bytes
}
            .used_bytes
    assert_eq!(result, 0, "foyer_snapshot_stats must return 0 on success");
    );
    let dir = TempDir::new().unwrap();
    // 10 fields × 2 sections = 20 longs
        cache
    };
    let dir = TempDir::new().unwrap();
    let dir = TempDir::new().unwrap();
        .store(0, std::sync::atomic::Ordering::Relaxed);
            std::thread::spawn(move || {
    );
    tiered.update_max_data_entry_size(2048);
        0,
    );
}
        put_range(&cache, "/data/evict_me.parquet", 0, 512, &vec![0u8; 512]);
    let removed_count = cache
        "active_in_bytes must be 0 after a cache miss"
}
#[test]
    cache
            false,
/// to verify no shared state leaks between lifetimes.
        0,
        false,
    let dir = TempDir::new().unwrap();
        let cache = FoyerCache::new(
        // drop(cache) here — cancels token
}
        "overall and block_level sections should be identical for single-tier Foyer"
fn tiered_cache_metadata_hit_never_probes_data_ssd() {
    let (cache, _dir) = test_cache();
#[test]
    let removed1 = cache.sweep_once();
    reader.join().expect("reader panicked");
        cache2.key_index.contains_key("data/a.parquet"),
    let dyn_cache: &dyn crate::traits::BlockCache = &cache;
    let dir = TempDir::new().unwrap();
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
            TEST_CACHE_DISK_BYTES,
        0,   // persist disabled
}
        cache
        "key must appear exactly once in key_index after overwrite (HashSet dedup); got {}",
        dir.path(),
        .removed_count
            .eviction_count
    // Inject a fake stale key for the same prefix — Foyer has never seen this key.
        cache.should_skip_sweep(),
        true,
    use std::collections::HashSet;
// ── Sweep threshold (should_skip_sweep) tests ─────────────────────────────────
        dir.path(),
// ── sweep idempotency and edge cases ─────────────────────────────────────────
        BLOCK_SIZE * 2,
        .entry("data/keep.parquet".to_string())
        .stats
            .unwrap()
        block_on(tiered.get(&big_key)).is_none(),
        block_on(cache2.clear());
fn tiered_cache_put_skips_oversized_data_entry() {
    cache
    let (cache, _dir) = test_cache();
}
        IO_ENGINE,
    cache.put(&key, Bytes::from(vec![0xFFu8; 1024]));
    let dir = TempDir::new().unwrap();
}
    let (cache, _dir) = test_cache();
        TEST_BUFFER_POOL_SIZE,
        &range_cache_key(path, 9_000_000, 10_000_000),
        .exists());
    assert!(result.is_err(), "catch_unwind must catch the panic");
    // disk=1MB, block_size=256KB (256KB ≤ 1MB — Foyer invariant satisfied).
    let small_key = range_cache_key("seg0/_0.parquet", 4096, 5120);
        "cursor must be 6 (5+1) after one sweep from preset 5"
    assert_eq!(
        let mtime_after_first =
        TEST_CACHE_BLOCK_SIZE,
            0,
        300,
        dir.path()
            "/data/big.parquet",
        dir.path()
    if result < 0 {
fn no_tmp_file_on_clean_startup() {
        .get("data/mixed.parquet")
        shards[0].read().is_empty(),
        .path()
    );
    assert_eq!(
/// 100% triggers a skip.
        bytes > 100_000,
    cache.stats.used_bytes.store(
    let dir_str = dir.path().to_str().unwrap();
        r1.as_ref().map(|b| b.len()),
        dir.path().join(key_index_store::KEY_INDEX_FILENAME),
    // Section 0 (indices 0–9) and section 1 (indices 10–19) must be identical.
/// Serialise a 10k-entry key_index to disk and verify the JSON file is non-empty,
    let (cache, _dir) = test_cache();
        .used_bytes
    block_on(cache.clear());
    // Cache must still be fully functional.
    let (cache, _dir) = test_cache();
    assert!(
    );
    }
                let key = range_cache_key(&format!("/data/file_{}.parquet", i), 0, 1024);
    // Sweeper should remove it, increment eviction_count, update eviction_bytes, and
    // Set cursor to shard 0.
        .stats
    let shard_count = cache.key_index.shards().len();
#[test]
#[test]
        cache
    // key_index stores normalized keys (no leading '/'):
    assert_eq!(
#[test]
/// and dropped. This test creates two sequential caches in the same temp dir
        cache.sweep_once();
    assert!(
        .sweep_cursor
#[test]
        }
        counter.load(std::sync::atomic::Ordering::Relaxed),
#[test]
        );
    // raced and all returned false from HashSet::insert, but never more than 1×.
        let used_after_evict = cache
        rc < 0,
                .unwrap()
    let dir = TempDir::new().unwrap();
            }
            IO_ENGINE,
    let used_after = cache
            BLOCK_SIZE as u64,
    }
    // No hang means watchdog exited cleanly.
use std::sync::Arc;
    }
/// Verify that `catch_unwind` correctly catches a panic without propagating it.
    );
    // Simulate: future cancelled (tokio::select! timeout or explicit drop).
        .get("data/shared.parquet")
        .is_none(),
    }
    // Count how many shards still have entries.
    let footer_key = range_cache_key(path, 9_990_000, 10_000_000);
    assert!(
            128 * 1024 * 1024,
}
    // recovered used_bytes=100; last_persisted starts at i64::MIN.
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
    let writer = std::thread::spawn(move || {
        "cursor raw={} must wrap: {} % {} == 0",
    );
    let (cache, _dir) = test_cache();
            0.0,
    cache.put(&fresh_key, Bytes::from_static(b"fresh"));
/// When sweep_interval_secs>0, the background task is spawned and the cache
    cache.put(&key, Bytes::copy_from_slice(&data));
        TEST_SUBMIT_QUEUE_SIZE,
// They use short intervals (1–2 seconds) and poll for the file's existence.
    );
    // Cache must remain fully usable after the concurrent activity.
    let shard2_keys = index["data/nodes/0/shard2.parquet"].as_array().unwrap();
        .key_index
    assert_eq!(
/// (FFM `foyer_clear_cache` → `clear_sync`); the async `clear()` trait method
            0.0_f64,
    // When all keys under a prefix become stale, the prefix bucket itself should be removed.
    );
            TEST_CACHE_BLOCK_SIZE,
    let stale_keys = [
        eviction_bytes_after - eviction_bytes_before,
        Bytes::from_static(b"meta"),
        .load(std::sync::atomic::Ordering::Relaxed);
    cache
                .sweep_cursor
            &cache,
    assert!(
            .stats
    );
        counter.load(std::sync::atomic::Ordering::Relaxed),
#[test]
    // Simulate the persist task catch_unwind.
    let (cache, _dir) = test_cache();
    // DashMap defaults to 64 shards on macOS — must sweep at least shard_count times.
    for i in 0u8..16 {
    assert_eq!(used_bytes_after, 0, "clear() must reset used_bytes to 0");
        "data entry exceeding max_data_entry_size must not be cached"
        false,
    );
#[test]
    );
    // foyer_snapshot_stats expects a Box<Arc<dyn BlockCache>> pointer, not Arc<FoyerCache>.
        assert_eq!(
    assert!(block_on(tiered.data_cache().get(&footer_key)).is_none());
    );
            s
        0,    // persist disabled
fn active_bytes_guard_zero_value_is_noop() {
    put_range(&cache, "/data/file.parquet", 0, 100, b"second");
fn sweep_once_removes_stale_keys_and_updates_eviction_count() {
            .load(std::sync::atomic::Ordering::Relaxed),
            invalid_utf8.len() as u64,
    let writer = std::thread::spawn(move || {
            IO_ENGINE,
            .stats
    };
            .load(std::sync::atomic::Ordering::Relaxed),
        .key_index
        let mtime_after =
        shard_count - 1
/// get() checks metadata cache first — so on warm restart (Foyer recovered
        "threshold=1.0, usage=99.9%: sweep must be skipped"
        IO_ENGINE,
        let cache = FoyerCache::new(
            engine.len() as u64,
    use dashmap::DashMap;
    assert_eq!(result.as_deref(), Some(data.as_slice()));
        0,
}
            if std::time::Instant::now() >= deadline {
            prefix,
/// Inject a stale key into shard 0 and a different stale key into shard 1.
    let key = range_cache_key("/data/file.parquet", 0, 1024);
}
        TEST_CACHE_BLOCK_SIZE,
        let contents =
    };
        assert_eq!(result, 0);
        eviction_bytes_after_2, 0,
        {
    const KEYS_PER_PREFIX: usize = 100;
    );
                cache.put(&key, Bytes::from(vec![0xABu8; RANGE_SIZE as usize]));
            BLOCK_SIZE,
    if ptr < 0 {
            dir.path(),
            0,
    assert_eq!(
    let destroy_rc = unsafe { foyer_destroy_cache(ptr) };
    let (cache, _dir) = test_cache(); // sweep_interval_secs=0 → no task spawned
#[test]
fn concurrent_evict_and_put_does_not_panic() {
        assert!(result.iter().all(|&b| b == i));
    let key = range_cache_key("seg0/_0.parquet", 9990000, 10000000);
/// Note: whether a specific entry ends up present or absent after this test is intentionally
// ── Watchdog and panic recovery tests ────────────────────────────────────────
    );
        };
    // Clear via the public async API.
        0.99,
        block_on(cache.get(&range_cache_key("/data/target.parquet", 0, 4096))),
fn persist_task_catch_unwind_does_not_kill_loop_on_panic() {
    let shards = cache.key_index.shards();
        "removed_count: 2 entries evicted"
    );
    let data_hits_before = tiered.data_cache().stats.hit_count.load(Ordering::Relaxed);
    // Put something so the sweep has a non-trivial key_index to process.
        cache2.key_index.contains_key("data/kept.parquet"),
            512,
        cache.key_index.insert(prefix, keys);
                .join(key_index_store::KEY_INDEX_FILENAME)
}
    let (cache, _dir) = test_cache();
        cache.key_index.is_empty(),
        cache
    assert!(
            TEST_CACHE_BLOCK_SIZE,
            dir.path()
        remaining, 1,
    // First tick: i64::MIN != 100 → persist fires → mtime advances.
    put_range(&cache, "/data/file.parquet", 100, 200, b"more");
            .load(std::sync::atomic::Ordering::Relaxed)
    let engine = IO_ENGINE.as_bytes();
    // on disk. key_index must retain the entry either way so evict_prefix() still works.
    assert!(
    assert_eq!(after_count, 1, "only the live key must remain after sweep");
    // Drop the box — this calls foyer_destroy internally via Arc drop.
        used_after < used_before,
    // Inject stale keys directly into shards 0 and 1.
        0,
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
#[test]
        &out[0..10],
            .active_in_bytes
    const THREAD_COUNT: usize = 8;
        TEST_CACHE_BLOCK_SIZE,
        false,
}
}
    assert!(
#[test]
        .load(std::sync::atomic::Ordering::Relaxed);
    assert!(block_on(tiered.data_cache().get(&col_a_key)).is_some());
fn sweep_once_returns_zero_when_all_entries_still_on_disk() {
        .stats
            invalid_utf8.as_ptr(),
        );
            0,
    let rc = unsafe { crate::foyer::ffm::foyer_snapshot_stats(raw_ptr, out.as_mut_ptr()) };
        !cache2.key_index.contains_key("data/evicted.parquet"),
    );
    // Raise the bound → same entry now admitted.
    assert_eq!(
        dir.path(),
        let keys: HashSet<String> = (0..KEYS_PER_PREFIX)
            false,
            s
    let b_count = cache2
        .used_bytes
                .unwrap()
            128 * 1024 * 1024,
            0,
    put_range(&cache, "/data/a.parquet", 0, 100, b"a");
    assert_eq!(shard2_keys.len(), 1, "shard2 must have 1 key");
#[test]
            TEST_BUFFER_POOL_SIZE,
/// CR-05 simulation: simulate a crash by using `std::mem::forget` to prevent Drop.
    );
    assert_eq!(shard1_keys.len(), 2, "shard1 must have 2 keys");
    tiered.put(&data_key, Bytes::from(vec![0xAA; 2_000_000]));
#[test]
    assert_eq!(
        unsafe {
    cache
    let col_a_key = range_cache_key("seg0/_0.parquet", 0, 2097152);
        0,
            if std::time::Instant::now() >= deadline {
/// call put(). With the old Vec-based key_index, this created two copies of the key,
        .sweep_cursor
            TEST_CACHE_BLOCK_SIZE,
    assert_eq!(
    // evict_prefix must still clean up correctly and increment removed_count.
    let (cache, _dir) = test_cache();
    assert!(
    tiered.put(&col_a_key, Bytes::from_static(b"col_a_data"));
const TEST_CACHE_BLOCK_SIZE: usize = 1 * 1024 * 1024; // 1 MB block size (must be ≤ disk)
            writer_cache.put(&key, Bytes::from_static(b"data"));
}
    assert_eq!(index.len(), 2, "must have 2 prefix buckets");
    assert!(block_on(tiered.get(&range_cache_key(path, 0, 1000000))).is_none());
            .load(std::sync::atomic::Ordering::Relaxed),
        .map(|v| v.len())
            out[i]
            128 * 1024 * 1024,
fn active_in_bytes_is_zero_before_and_after_get() {
        count_after_first, 1,
    let cache2 = FoyerCache::new(
                .exists(),
    );
    block_on(cache.clear());
/// Preset to shard_count - 1, one more call brings raw value to shard_count,
// These tests exercise Fix 1 (catch_unwind) and Fix 4 (watchdog outer loop)
}
        "usage=50% < threshold=75%: sweep must be skipped"
        "zero-byte snapshot must produce empty key_index (clean startup)"
    cache.evict_prefix("/never/inserted.parquet");
        assert!(!cache.key_index.contains_key("data/evicted.parquet"));
    assert!(
        0,
            engine.len() as u64,
        .load(std::sync::atomic::Ordering::Relaxed);
    assert!(
            engine.as_ptr(),
#[test]
        cache.key_index.contains_key("data/file.parquet"),
            (BLOCK_SIZE * 2) as u64,
    // 10 fields × 2 sections = 20 longs
    );
            false,
        // Record mtime after first persist.
    cache.evict_prefix("/data/file.parquet");
        "first put must add exactly 1 entry to key_index"
    let (cache, _dir) = test_cache();
        .unwrap_or(0);
// ── Duplicate key / HashSet deduplication tests ───────────────────────────────
        "shard2 must be untouched"
    );
            .stats
            IO_ENGINE,
#[test]
    let (cache, _dir) = test_cache();
    );
    );
    assert_eq!(
        TEST_CACHE_BLOCK_SIZE,
    // Therefore key_index must RETAIN all keys after DRAM eviction pressure.
        );
        "token must not be cancelled before drop"
    let cache = FoyerCache::new(
            TEST_BUFFER_POOL_SIZE,
    );
    // We don't spin up an actual cache for the "first session" here because
        let key = format!("{}\x1F0-100", prefix);
        .stats
    cache.evict_prefix("/data/target.parquet");
    );
    let dir = TempDir::new().unwrap();
        TEST_SUBMIT_QUEUE_SIZE,
    // Short sweep interval: the inner loop fires at least once within 2s.
#[test]
            0.0,
        false,
    assert!(
    cache.put(&key, Bytes::from(vec![0u8; 1024]));
fn sweep_threshold_skips_when_usage_below_threshold() {
    let shard_count = shards.len();
 * compatible open source license.
    drop(g1);
        let byte_size: i64 = keys
    put_range(&cache, "/data/a.parquet", 0, 4096, b"range0");
        "used_bytes must be exactly {} after {} concurrent puts of the same key; got {}",
        unsafe {
        .entry("data/file.parquet".to_string())
    assert_eq!(removed, 1, "stale malformed key must be removed");
        TEST_BUFFER_POOL_SIZE,
#[test]
    // One sweep_once() call must process exactly one shard.
/// The key_index.json must NOT be written (or must be old) since Drop is skipped.
    let key1 = "stale_shard1\x1F0-200".to_string();
    let result = unsafe { foyer_snapshot_stats(ptr, buf.as_mut_ptr()) };
/// The values at index 0 (overall hit_count) and index 7 (block_level hit_count) should
        TEST_CACHE_DISK_BYTES,
}
    let counter = AtomicI64::new(42);
        0.0,
    assert_eq!(
        cache
use bytes::Bytes;
        cache
    );
        // Drop writes and renames.
    assert_eq!(cache.key_index.len(), 4, "4 prefix buckets injected");
    );
fn snapshot_stats_two_sections_identical_for_single_tier() {
            .join(key_index_store::KEY_INDEX_FILENAME)
    // Subset → miss (different key)
    put_range(&cache, "/data/file.parquet", 0, 100, b"real");
        let cache2 = FoyerCache::new(
        "used_bytes must not decrease on overwrite"
        "data miss on first access"
    // DashMap defaults to 64 shards on macOS; we must sweep at least shard_count times.
    put_range(&cache, "/data/a.parquet", 4096, 8192, b"range1");
            BLOCK_SIZE as u64,
}
        )
            .exists(),
    );
            TEST_CACHE_BLOCK_SIZE,
    let key_count = loop {
        0.0,
/// Size bounds update dynamically — raising the limit admits a previously
        "dropping g1 (100) must leave 300"
        );
#[test]
        .extend(vec![fake1, fake2]);
    let shard_count = cache.key_index.shards().len();
}
        false,
            BLOCK_SIZE as u64,
/// The cursor wraps correctly at the shard count boundary.
            .load(std::sync::atomic::Ordering::Relaxed),
        .stats
#[test]
    // Verify neither file exists before creating the cache.
    drop(cache);
    put_range(&cache, "/data/target.parquet", 0, 4096, b"new");
        "key_index.json must be written on Drop"
        serde_json::from_str(&contents).expect("key_index.json must be valid JSON");
    let (cache, _dir) = test_cache();
        "getter must reflect the updated bound"
            let key = range_cache_key("/data/shared.parquet", i * 100, (i + 1) * 100);
}
/// the inner loop fires at least once before drop.
    assert_eq!(destroy_rc, 0);
        dir.path(),
            &vec![0u8; 128],
    dyn_cache.put_metadata(&key, Bytes::from_static(b"footer"));
    let result = unsafe { foyer_destroy_cache(-1) };
    assert!(
    {
        false,
/// Simulates exactly what the sweep task does when `reconcile_key_index` panics:
        std::sync::atomic::Ordering::Relaxed,
    assert!(
        // Drop writes key_index.json with used_bytes=100.
// for both the sweep task and the persist task.
            .load(std::sync::atomic::Ordering::Relaxed);
/// worker threads, quickly exhausting the macOS thread limit and causing tests to block
const IO_ENGINE: &str = "auto";
        let cache = FoyerCache::new(
    );
                .unwrap();
            TEST_BUFFER_POOL_SIZE,
                .load(std::sync::atomic::Ordering::Relaxed)
            (i + 1) * CHUNK_SIZE as u64,
        // Real-looking key — Foyer won't have it either, but it's valid format.
    }
            dir.path(),
            0.0_f64,
#[test]
        TEST_SUBMIT_QUEUE_SIZE,
        .load(std::sync::atomic::Ordering::Relaxed);
    let dir = TempDir::new().unwrap();
/// evict_prefix() followed by Drop: the evicted prefix must NOT appear in the
    // No hang, no panic expected.
        dir.path()
        1.0,
                break true;
    let dir = TempDir::new().unwrap();
        put_range(&cache, "/data/kept.parquet", 0, 512, &vec![0u8; 512]);
    assert_eq!(
            })
                .path()
    let dir = TempDir::new().unwrap();
        assert_ne!(v, i64::MIN, "buf[{}] was not written", i);
/// When sweep_threshold_ratio == 0.0 (disabled), should_skip_sweep() must always
    assert!(
#[test]
/// from the snapshot — not just entries added in the current session.
    assert_eq!(
        "empty prefix bucket must be removed after sweep"
    );
        dash.insert(prefix, keys);
    // Verify metadata is in metadata_cache, not data_cache
        .or_default()
        true,
/// foyer_create_cache returns a pointer that can be cloned (passed to multiple TieredObjectStores)
    assert_eq!(
        cache.key_index.is_empty(),
    assert!(
    let removed = cache.sweep_once();
    tiered.put(&key, Bytes::from(vec![0x22; 4096]));
    let snap = cache.stats.snapshot();
    while !dir
/// when the cancellation token fires. Uses a short 1-second interval so
        0,
///
/// causing double-counting in removed_bytes and eviction_bytes.
        eviction_bytes_before,
    let used = cache2
        TEST_SUBMIT_QUEUE_SIZE,
        block_on(
        let prefix = format!("data/nodes/0/shard_{p:04}/segment.parquet");
#[test]
        Some(b"range0".as_slice())
#[test]
    for h in handles {
        &range_cache_key(path, 9000000, 10000000),
#[test]
    assert!(
    assert!(
    // DashMap defaults to 64 shards on macOS — must sweep at least shard_count times.
            TEST_BUFFER_POOL_SIZE,
        dir.path(),
    (tiered, data_dir, meta_dir)
        .stats
    );
        0.0,
        cache.key_index.is_empty(),
    let used_before = cache
    // Write entries into the first cache instance.
        .unwrap_or(0);
    assert!(block_on(cache.get(&range_cache_key("/data/a.parquet", 0, 100))).is_none());
        cache.put(&key, Bytes::copy_from_slice(&chunk));
        0,
        cache.sweep_once();
    let count = cache
    assert_eq!(
fn sweep_cursor_wraps_at_shard_count() {
    put_range(&cache, "/data/a.parquet", 0, 100, b"file_a");
    let s1 = range_cache_key("seg1/_0.parquet", 9000, 10000);
}
    assert!(
            .load(std::sync::atomic::Ordering::Relaxed),
    assert_eq!(
            "out[{i}] should be 0 for a fresh cache, got {}",
        0,
        TEST_SUBMIT_QUEUE_SIZE,
            .modified()
/// fires and the get() future is abandoned.
    assert_eq!(
        dash.insert(prefix, keys);
        400,
            1,
    let dir_str = dir.path().to_str().unwrap();
        TEST_CACHE_BLOCK_SIZE,
        let cache = FoyerCache::new(
    // "data/f.parquet\x1F0-100"   → 100 bytes
fn get_returns_none_for_wrong_range_on_known_path() {
        cache.key_index.insert(prefix, keys);
        .load(std::sync::atomic::Ordering::Relaxed);
    // Cache must still be fully functional.
                cache.put(&key, Bytes::copy_from_slice(&vec![i as u8; 1024]));
        false,
/// put() (normal path from TieredObjectStore::populate_cache) routes to data cache.
#[test]
/// When usage is strictly below the threshold, should_skip_sweep() returns true.
    // Session 2: open with persist_interval=1s.
/// Dropping a cache with an active sweep task must not panic.
        0,
        block_on(tiered.get(&col_idx_key)).is_some(),
/// sweep_once() ignores the threshold — it calls reconcile_key_index directly.
        std::sync::atomic::Ordering::Relaxed,
    let cache2 = FoyerCache::new(
        0,
    }
        "negative used_bytes must be clamped to 0; ratio 0.0 < threshold 0.5 → skip"
    let engine = IO_ENGINE.as_bytes();
            .sum();
    );
    std::thread::sleep(std::time::Duration::from_millis(50));
    // Write a 10k-entry snapshot.
        NUM_PREFIXES * KEYS_PER_PREFIX,
/// PP-04: persist task does NOT write key_index.json when used_bytes has not changed
        false,
        "usage=90% > threshold=75%: sweep must NOT be skipped"
        .used_bytes
    // usage = 100% → above 75% → do NOT skip
            .stats
        &cache,
            false,
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
    // get() probes metadata cache first → hit
#[test]
            .removed_count
            .used_bytes
            .stats
        assert_eq!(result.as_deref(), Some(b"hello".as_slice()));
    let after_count = cache
            dir_str.len() as u64,
        .key_index
        0,
}
    let engine = IO_ENGINE.as_bytes();
        128 * 1024 * 1024,
            .load(std::sync::atomic::Ordering::Relaxed),
    );
    let dir = TempDir::new().expect("failed to create temp dir");
        .map(|v| v.len())
    );
        0,
        block_on(cache.get(&range_cache_key("/data/a.parquet", 0, 4096))).as_deref(),
}
        used, 600,
/// put_metadata() routes to metadata cache; get() finds it there.
    );
fn ffm_create_returns_positive_pointer() {
        .block_on(f)
/// Dropping a cache with sweep_interval_secs=0 (no sweep task) must not panic.
}
}
#[test]
        TEST_CACHE_DISK_BYTES,
        put_range(
    );
    {
        used_bytes_after - used_bytes_before,
    tiered.evict_prefix("seg0/");
            .join(key_index_store::KEY_INDEX_FILENAME)
    let writer_cache = Arc::clone(&cache);
    // Each key is unique so it hashes to a predictable shard via the raw write.
    cache.put(&key, Bytes::from(vec![0u8; 512]));
        0, // sweep disabled
    tiered.put(&small_key, Bytes::from(vec![0xCD; 1024])); // 1KB <= 2KB → cached
        "cursor must point to shard 1 after sweeping shard 0"
        0,
        false,
        0.0, // threshold disabled — sweep runs every tick
    );
    // Assert it is absent while the cache is still alive (before Drop).
// ── put + get round-trip ──────────────────────────────────────────────────────
    );
    }
fn active_in_bytes_is_zero_after_cache_miss() {
    // Parse and validate structure.
#[test]
fn ffm_create_destroy_lifecycle_no_leak() {
        "data/a.parquet must be in key_index after recovery"
        block_on(tiered.get(&key)).map(|b| b.len()),
        "shard 1 must be untouched after sweeping shard 0"
    );
        TEST_CACHE_BLOCK_SIZE,
    }));
            tiered
    assert!(
        TEST_CACHE_DISK_BYTES,
    assert_eq!(b_count, 1, "data/b.parquet must have 1 key");
        1024
}
    {
}
/// clear() deletes key_index.json so the next startup does not load stale keys.
/// This test verifies:
    );
    assert!(
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
        0.75,
        "data/b.parquet must be in key_index after recovery"
        ("data/delta.parquet", "data/delta.parquet\x1F0-400"),
    let fake1 = "data/gone.parquet\x1F0-100".to_string();
fn used_bytes_is_correct_after_put_then_evict() {
            mtime_after > mtime_before,
    assert_eq!(
    let count = cache
        let dir_str = dir.path().to_str().unwrap();
    );
            dir_str.len() as u64,
            "key_index.json must be written by persist task within 5s"
}
        count, 1,
}
        0,
    // The watchdog outer loop must NOT re-enter because `return` exits the closure.
            engine.as_ptr(),
        .removed_bytes
        "key_index.json must not exist after simulated crash (Drop skipped)"
    );
#[test]
            .load(std::sync::atomic::Ordering::Relaxed),
        Some(512),
    // (not 2), because HashSet::insert is idempotent for duplicate keys.
            TEST_CACHE_BLOCK_SIZE,
        block_on(cache.get(&range_cache_key("/data/c.parquet", 0, 100))).as_deref(),
/// No .tmp file should exist after either graceful shutdown or periodic persist.
        TEST_CACHE_DISK_BYTES,
    let dir = TempDir::new().unwrap();
    let cache = FoyerCache::new(
        IO_ENGINE,
            false,
        "dropping g2 (200) must leave 100+300=400"
        assert!(
/// return false regardless of current usage — the sweep is never skipped.
    tiered.put_metadata(&footer_key, Bytes::from_static(b"footer_bytes"));
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
    let evictor = std::thread::spawn(move || {
            (BLOCK_SIZE * 2) as u64,
/// not asserted — both outcomes are valid per the method's documented behaviour.
}
        IO_ENGINE,
        }
    assert_eq!(counter.load(std::sync::atomic::Ordering::Relaxed), 4096);
            "persist task must NOT rewrite key_index.json when cache is idle (used_bytes unchanged)");
// ── evict_prefix ──────────────────────────────────────────────────────────────
fn clear_updates_removed_count_and_removed_bytes() {
fn concurrent_put_and_evict_same_prefix_does_not_corrupt() {
    let cache2 = FoyerCache::new(
        .store(below, std::sync::atomic::Ordering::Relaxed);
    assert_eq!(
        "precondition: threshold guard would skip"
    // On startup, no .tmp should be created or left behind.
        loaded.index.len(),
            IO_ENGINE,
    );
    // Create a new cache from the same dir — should bulk-load the snapshot.
    // Third instance: must start with an empty key_index (clear deleted the stale snapshot).
    // Manually replicate the catch_unwind logic from the sweep task.
        TEST_CACHE_DISK_BYTES,
#[test]
            0.0,
    );
    shards[1].write().insert(
        // Single put to trigger the first persist.
    writer.join().expect("writer panicked");
    // Interpret as Box<Arc<dyn BlockCache>> — if the pointer type is wrong this will crash.
    put_range(&cache, "/data/crash.parquet", 0, 512, &vec![0u8; 512]);
            }),
    assert_eq!(
/// active_in_bytes is 0 even after a cache miss — the guard restores it regardless
    assert!(block_on(tiered.metadata_cache().get(&footer_key)).is_some());
#[test]
        "key_index must still contain entry — no background task should have modified it"
        );
    let (cache, _dir) = test_cache();
            BLOCK_SIZE,
    // A key without a parseable range (key_byte_size returns 0) must still be
        put_range(
            0,
    cache.put(&key, Bytes::from_static(b"version_1"));
        TEST_CACHE_BLOCK_SIZE,
        foyer_create_cache(
    );
        true,
        block_on(cache.get(&range_cache_key("/data/a.parquet", 8192, 12288))).as_deref(),
    );
        0,
    assert!(block_on(cache.get(&range_cache_key("/data/b.parquet", 0, 100))).is_none());
    assert!(block_on(tiered.data_cache().get(&data_key)).is_some());
const TEST_BUFFER_POOL_SIZE: usize = 1 * 1024 * 1024; // 1 MB buffer pool (≥ block_size)
    drop(cache);
    // Simulate a transient underflow (negative used_bytes) — should be clamped to 0.
        use std::collections::{HashMap, HashSet};
        std::thread::sleep(std::time::Duration::from_millis(3000));
#[test]
        &buf[..10],
    const NUM_PREFIXES: usize = 100;
    // First put: key must be added to key_index.
            0,
    assert_eq!(
            .load(std::sync::atomic::Ordering::Relaxed),
        counter.load(std::sync::atomic::Ordering::Relaxed),
        IO_ENGINE,
            TEST_SUBMIT_QUEUE_SIZE,
    // Reaching here means the task stopped cleanly.
        .stats
        false,
        .load(std::sync::atomic::Ordering::Relaxed);
        removed_before,
        TEST_BUFFER_POOL_SIZE,
        .map(|v| v.len())
    let data_dir = TempDir::new().expect("data temp dir");
            BLOCK_SIZE * 2,
        "must have {NUM_PREFIXES} prefix buckets"
        dir.path(),
        );
        .stats
    // All threads race to put the same key — simulates a cache stampede after a miss.
/// A corrupt key_index.json (invalid JSON) is treated as a clean startup.
        false,
    for i in 0..shard_count {
        TEST_BUFFER_POOL_SIZE,
            i
        "put_metadata default must route to the single cache and be retrievable via get()"
        .load(std::sync::atomic::Ordering::Relaxed);
    // get() misses metadata cache, hits data cache
        .used_bytes
    // Simulate crash: forget the cache — Drop is NOT called.
    assert!(
        "metadata entry exceeding max_metadata_entry_size must not be cached"
            (BLOCK_SIZE * 2) as u64,
}
    let shard2 = Arc::clone(boxed);
        0.0,
    );
fn clear_removes_all_entries() {
    assert!(result < 0);
    let path = dir.path().join(key_index_store::KEY_INDEX_FILENAME);
            .sum();
    {
    block_on(cache.clear());
    {
    // key_index must have exactly 1 entry for this key, not THREAD_COUNT.
        .used_bytes
}
        0.0,
    // no task is spawned. The key_index must still contain the entry.
    let big_key = range_cache_key("seg0/_0.parquet", 0, 4096);
        false,
/// over the same dir — verify the key_index is bulk-loaded correctly.
    assert_eq!(
    assert_eq!(
    let removed_before = cache
            1,
    );
    let loaded = key_index_store::load_or_empty(dir.path());
    assert_eq!(
        .load(std::sync::atomic::Ordering::Relaxed);
fn sweep_disabled_when_interval_is_zero() {
        "4KB admitted after raising bound to 8KB"
        .used_bytes
// ── disk / capacity cases ─────────────────────────────────────────────────────
    let eviction_bytes_after_2 = cache
        .stats
    assert!(
        .stats
        cache.key_index.is_empty(),
        .store(0, std::sync::atomic::Ordering::Relaxed);
    assert_eq!(
    assert_eq!(removed2, 0, "no stale entries on second sweep");
            .used_bytes
    let result = block_on(cache.get(&key));
            TEST_BUFFER_POOL_SIZE,
    for p in 0..NUM_PREFIXES {
    );
}
            writer_cache.put(&key, Bytes::from(vec![0u8; 100]));
    cache
    cache
            .removed_count
fn sweep_once_is_idempotent_for_real_entries() {
        0,
    // Inject one unique stale key per shard directly via raw shard access.
            "first persist must have fired"
            let mut s = std::collections::HashSet::new();
    // We only care that drop() cancels it cleanly.
fn tiered_cache_get_finds_metadata_without_reregistration() {
        .eviction_bytes
    cache
///
    let cache2 = FoyerCache::new(
fn clear_on_empty_cache_is_safe() {
        0,
        .load(std::sync::atomic::Ordering::Relaxed);
            .path()
            1,
        .stats
    );
                128 * 1024 * 1024,
    let (cache, _dir) = test_cache();
        dir.path(),
    assert!(block_on(tiered.get(&range_cache_key(path, 9000000, 10000000))).is_none());
/// of the watchdog outer loop, so the first tick after recovery always persists.
        TEST_SUBMIT_QUEUE_SIZE,
    let engine = IO_ENGINE.as_bytes();
        .unwrap();
    let dir_str = dir.path().to_str().unwrap();
#[test]
}
            .load(std::sync::atomic::Ordering::Relaxed),
        .load(std::sync::atomic::Ordering::Relaxed);
        "active_in_bytes must be 0 before any get()"
    );
        THREAD_COUNT, count
    // used_bytes starts at 0, put adds size, evict_prefix subtracts — net result = 0.
    let data: Vec<u8> = (0u32..1_000_000).map(|i| (i % 251) as u8).collect();
    let eviction_count_before = cache
    put_range(&cache, "/data/keep.parquet", 0, 512, &vec![0xAAu8; 512]);
    // Create and drop a cache to write key_index.json.
            dir.path(),
            TEST_SUBMIT_QUEUE_SIZE,
    assert!(
        block_on(cache.get(&range_cache_key("/data/a.parquet", 4096, 8192))).as_deref(),
            .used_bytes
        256 * 1024,
    let cache3 = FoyerCache::new(
    for _ in 0..shard_count {
        Some(256),
// ── get miss cases ────────────────────────────────────────────────────────────
    let removed_before = cache
    // Drop cancels token — persist task stops via `return` in cancelled() arm.
#[test]
    // key_index.json must exist after graceful shutdown.
            dashmap::SharedValue::new({
    assert_eq!(
    cache.sweep_once();
            0.0,
    let clone = Arc::clone(&*boxed);
        false,
#[test]
    let cache2 = FoyerCache::new(
    let (cache, _dir) = test_cache();
#[test]
        cache.should_skip_sweep(),
    assert_eq!(Arc::strong_count(boxed), 4, "1 (box) + 3 shards");
            TEST_SUBMIT_QUEUE_SIZE,
            512,
    );
    let (cache, _dir) = test_cache();
    cache.evict_prefix("/data/file.parquet");
    use std::sync::atomic::AtomicI64;
        "foyer_snapshot_stats with ptr=0 should return < 0, got {rc}"
/// foyer_snapshot_stats with null out buffer returns negative.
        dir.path()
        .join(key_index_store::KEY_INDEX_FILENAME)
    let snap_exists = dir
            }
    let shards = cache.key_index.shards();
            "data/f.parquet\x1F0-100".to_string(),
#[test]
    // Writes 4 × 512KB = 2MB total into a 2MB cache to exercise near-capacity behaviour.
        put_range(&cache, "/data/file.parquet", 0, 100, &vec![0u8; 100]);
    }
        raw % shard_count,
    );
        assert!(
            .map(|k| crate::range_cache::key_byte_size(k))
        TEST_CACHE_DISK_BYTES,
        0,
    cache.put(&key, Bytes::from_static(b"original"));
            .load(std::sync::atomic::Ordering::Relaxed)
    // ── Query 2: same data → hit from data cache ─────────────────────
        removed_before
#[test]
    let half = (TEST_CACHE_DISK_BYTES / 2) as i64;
    let writer_cache = Arc::clone(&cache);
        .store(half, std::sync::atomic::Ordering::Relaxed);
    assert!(
    let dir_str = dir.path().to_str().unwrap();
    assert_eq!(
}
/// explicit sizes and are unaffected by these constants.
        );
        0,
        TEST_BUFFER_POOL_SIZE,
}
        .eviction_bytes
        "eviction_count must increase for the stale key removed by sweep"
    // usage = 0 → should_skip_sweep() is true (below 99% threshold)
            TEST_CACHE_DISK_BYTES,
fn tiered_cache_key_alignment_warmup_matches_query() {
        false,
/// by checking file existence before Drop is called.
        .used_bytes
#[test]
            .path()
            })
    let _ = unsafe { Box::from_raw(raw_ptr as *mut Arc<dyn crate::traits::BlockCache>) };
        TEST_CACHE_BLOCK_SIZE,
        TEST_CACHE_DISK_BYTES,
    assert!(
    // key_index stores normalized keys (no leading '/'):
        .exists()
    let result = block_on(cache.get(&key)).expect("large value should be retrievable");
    let key = range_cache_key("seg0/_0.parquet", 0, 64);
        1,   // 1-second interval
    let index = parsed["index"]
#[test]
        "exactly one shard must have been swept; {} of {} shards still have entries (expected {})",
        r2.as_ref().map(|b| b.len()),
        -300,
}
    put_range(&cache, "/data/target.parquet", 8192, 12288, b"range2");
        .store(-100, std::sync::atomic::Ordering::Relaxed);
        for i in 0u64..100 {
        0.0,
        )
    // put_range stores exactly (end - start) bytes, so key_byte_size() == data.len().
#[test]
        shard_count - 1,
#[test]
        0,
        "key was never inserted — should be a miss"
        Some(b"file_b".as_slice())
            TEST_CACHE_BLOCK_SIZE,
    // DashMap hashes keys to one of N shards (N=64 on macOS); sweep_once() processes ONE shard
    tiered.put_metadata(&col_idx_key, Bytes::from_static(b"column_index_bytes"));
#[test]
    cache.put(&key, Bytes::from(vec![0xAAu8; 512]));
        )
        block_on(tiered.get(&col_idx_key)).as_deref(),
    assert_eq!(
            BLOCK_SIZE as u64,
        let key = range_cache_key(
        .load(std::sync::atomic::Ordering::Relaxed);
        .used_bytes
    assert_eq!(
        panic!("simulated reconcile_key_index panic");
    let data = vec![0xABu8; 1024];
            0,
        "key_index.json must exist after first Drop"
        "used_bytes must be 512 after first put"
    );
        key_count, TOTAL_WRITES,
    let dir = TempDir::new().unwrap();
        let keys: HashSet<String> = (0..KEYS_PER_PREFIX)
    assert_eq!(
        .entry("data/mixed.parquet".to_string())
    let metadata_cache = Arc::new(FoyerCache::new(
        512,
    // Set a high threshold so should_skip_sweep() returns true
    );
    let reader_cache = Arc::clone(&cache);
#[test]
            .stats
}
    for h in handles {
    }
    }
    assert!(ptr > 0);
        // 3 ranges: 100 + 200 + 300 = 600 bytes total.
}
        removed, 1,
        1,
    let cache = FoyerCache::new(
        cache
    assert!(block_on(cache.get(&range_cache_key("/data/other.parquet", 0, 100))).is_some());
        TEST_CACHE_DISK_BYTES,
            16 * 1024 * 1024,
        .stats
        .load(std::sync::atomic::Ordering::Relaxed);
        .store(above, std::sync::atomic::Ordering::Relaxed);
    assert!(ptr > 0);
    put_range(&cache, "/data/file.parquet", 0, 1024, &vec![0u8; 1024]);
        assert!(
}
        block_on(tiered.get(&col_a_key)).as_deref(),
fn key_index_serialization_with_10k_entries() {
            0.0_f64,
    assert_eq!(
    tiered.put_metadata(
        .map(|v| v.len())
    {
fn ffm_create_with_null_ptr_returns_error() {
fn recovery_stale_snapshot_keys_cleaned_by_sweep() {
        assert_eq!(mtime_after_first, mtime_after_idle,
    );
        dir.path(),
            dir.path(),
        false,
        cache
        })
            .exists(),
    let parsed: serde_json::Value =
    tiered.evict_prefix(path);
            TEST_CACHE_DISK_BYTES,
    assert_eq!(counter.load(std::sync::atomic::Ordering::Relaxed), 600);
            256,
// ── FFM lifecycle ─────────────────────────────────────────────────────────────
    }
    assert!(!cache.key_index.contains_key("data/file.parquet"));
        0,
            &cache,
// ── Test helpers ──────────────────────────────────────────────────────────────
        !cache.key_index.contains_key("data/gone.parquet"),
    // Real key is still in key_index.
    // Shrink the bound so the test stays small (no multi-MB allocations).
    const KEYS_PER_PREFIX: usize = 100;
}
            .load(std::sync::atomic::Ordering::Relaxed),
        .stats
    let cache = Arc::new(cache);
    // Writes 8 × 256KB = 2MB total into a 1MB cache to trigger LRU eviction pressure.
        .load(std::sync::atomic::Ordering::Relaxed);
    );
/// On a data key miss (not in either cache), metadata cache is still probed
    let path = "seg0/_0.parquet";
        0,
        false,
    let (cache, _dir) = test_cache();
fn cache_functional_before_drop() {
    let cache = FoyerCache::new(
        cache.key_index.len(),
            engine.as_ptr(),
    put_range(&cache, "/data/b.parquet", 0, 200, b"persist_data");
    cache.put(&key, Bytes::from_static(data));
    // drop cancels the sleeping task immediately via cancelled() branch
            out[i], 0,
    let dir = TempDir::new().unwrap();
// Design note: recovery uses bulk-load (no per-key inner.contains() validation).
/// without double-free. After all clones drop, the FoyerCache is freed exactly once.
        .or_default()
#[test]
        tiered.max_data_entry_size(),
#[test]
        );
        "evicted prefix must not appear in recovered key_index"
    let count_after_first = cache
}
    // used_bytes = 100% of disk
    cache.put(&key, Bytes::copy_from_slice(&data));
            .stats
    put_range(&cache, "/data/b.parquet", 0, 100, b"b");
        TEST_BUFFER_POOL_SIZE,
    assert!(block_on(tiered.metadata_cache().get(&data_key)).is_none());
    );
    );
    // Event::Replace fires only when the old value is still in the 1-byte DRAM tier at
        TEST_SUBMIT_QUEUE_SIZE,
        false,
    let result = block_on(cache.get(&range_cache_key("/never/inserted.parquet", 0, 100)));
            > eviction_count_before,
fn persist_task_fires_after_evict_prefix_changes_used_bytes() {
    assert_eq!(result.as_ref(), data.as_slice());
    assert_eq!(
    const CHUNK_SIZE: usize = 256 * 1024;
            .used_bytes
// ── Sweep cursor tests ───────────────────────────────────────────────────────
/// After the guard is dropped the counter must return exactly to its original value.
    ));
                let mut s = std::collections::HashSet::new();
        TEST_SUBMIT_QUEUE_SIZE,
        "stale_shard0".to_string(),
#[test]
    }));
            if std::time::Instant::now() >= deadline {
#[test]
    const NUM_PREFIXES: usize = 100;
// ── KeyIndexListener behaviour ────────────────────────────────────────────────
    // With HashSet key_index, putting the same key twice must result in exactly 1 entry
            .sweep_cursor
        }
    );
/// startup. All prefix buckets and keys are present immediately after new().
    // Panic must be caught — not propagated.
            .stats
            TEST_BUFFER_POOL_SIZE,
    if result < 0 {
    // Shard 1 must still have its stale key.
}
    let used_before = cache
        0,
        .load(std::sync::atomic::Ordering::Relaxed);
        .get("data/file.parquet")
        0,
            .eviction_bytes
            .stats
        0.0,
fn drop_with_active_sweep_task_does_not_panic() {
    let cache = FoyerCache::new(
    );
/// Full DataFusion query simulation:
            TEST_CACHE_BLOCK_SIZE,
    }
        64 * 1024 * 1024,
    );
    put_range(&cache, "/data/c.parquet", 0, 100, b"file_c");
        let mut index: HashMap<String, HashSet<String>> = HashMap::new();
/// When usage is at or above the threshold, should_skip_sweep() returns false.
            0.0,
    let counter = AtomicI64::new(0);
        0,
        IO_ENGINE,
    let mut out = [0i64; 14];
        0.0,
fn persist_task_with_active_watchdog_stops_cleanly_on_cancel() {
}
        TEST_BUFFER_POOL_SIZE,
    let key = range_cache_key("/data/file.parquet", 0, 512);
    );
            IO_ENGINE,
    // usage = 50% → below 75% → skip
        .get_or_init(|| tokio::runtime::Runtime::new().expect("shared test runtime"))
    );
        shards[i].write().insert(
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
    let dash: DashMap<String, HashSet<String>> = DashMap::new();
#[test]
        0.0,
        .key_index
    // guard dropped here
    let (cache, _dir) = test_cache();
        .load(std::sync::atomic::Ordering::Relaxed);
        ("data/beta.parquet", "data/beta.parquet\x1F0-200"),
    let fresh_key = range_cache_key("/data/file.parquet", 0, 100);
    // Simulate prior session: metadata was put via put_metadata
    std::thread::sleep(std::time::Duration::from_millis(1200));
    let deadline = std::time::Instant::now() + std::time::Duration::from_secs(5);
        dir.path(),
        .insert(fake_key.clone());
/// The pointer can be reinterpreted as Box<Arc<dyn BlockCache>> and the Arc's
        .used_bytes
// ── ActiveBytesGuard tests ────────────────────────────────────────────────────
    );
    let (cache, _dir) = test_cache();
    let engine = IO_ENGINE.as_bytes();
    }
            .stats
            .stats
        IO_ENGINE,
        !dir.path()
        .load(std::sync::atomic::Ordering::Relaxed);
    let (cache, _dir) = test_cache();
        "/data/persist_watchdog.parquet",
fn key_index_recovery_with_10k_entries() {
// ── evict_prefix stats correctness ───────────────────────────────────────────
#[test]
fn simulated_crash_skip_drop_no_final_persist() {
/// Stress test for the concurrent `put()` + `evict_prefix()` scenario described in the
                dir_str.as_ptr(),
        0
    // get() finds it — no re-registration needed (metadata cache probed first)
        0,
            0.0_f64,
    // Create a fresh Foyer cache over the same dir. Foyer has no data for "data/stale.parquet".
    // Create a second cache and call clear().
    for p in 0..NUM_PREFIXES {
    );
        0
        .unwrap_or(0);
        before_count, 2,
    assert!(!contents.is_empty(), "key_index.json must not be empty");
        &out[10..20],
        false,
// These tests exercise the full put → Drop (persist) → new (recover) cycle.
        IO_ENGINE,
    let result = block_on(cache.get(&range_cache_key("/data/file.parquet", 0, 100)));
        TEST_CACHE_BLOCK_SIZE,
        .removed_count
    assert!(
}
        .eviction_bytes
    let mut out = [i64::MAX; 20];
                .modified()
        3600, // 1-hour interval — task sleeps, drop cancels it immediately
    let rc = unsafe { crate::foyer::ffm::foyer_snapshot_stats(ptr, out.as_mut_ptr()) };
            .stats
    // This simulates a node with only Drop-based persistence.
    }
        "used_bytes must decrease after bulk evict_prefix"
            0,
fn sweep_threshold_runs_when_usage_at_or_above_threshold() {
/// exactly one shard's stale key is removed; all other shards still have their stale key.
            0,
    );
            s.insert(key0);
    // Eviction stats must have been updated for the stale key.
    );
    evictor.join().expect("evictor panicked");
            .stats
            &vec![0u8; 256],
        .stats
            &cache,
    put_range(&cache, "/data/file.parquet", 0, 100, &vec![0u8; 100]);
            .join(key_index_store::KEY_INDEX_FILENAME)
    assert!(
            0,
    assert_eq!(
    assert_eq!(
        while !dir
        .used_bytes
        total_keys,
            .used_bytes
        "used_bytes must be > 0 after put"
    let used_after_v2 = cache
    drop(g3);
/// Even when should_skip_sweep() returns true, sweep_once() still sweeps.
    assert!(cache.key_index.contains_key("data/file.parquet"));
            .load(std::sync::atomic::Ordering::Relaxed),
    const NUM_PREFIXES: usize = 100;
        shard_count,
}
        cache.should_skip_sweep(),
    // Save.
#[test]
#[test]
        Some(4096),
    // Verify it is reflected immediately (index 6 = used_bytes).
        .used_bytes
        "eviction_bytes must reflect the byte size of stale entries (parsed from key)"
    assert_eq!(eviction_bytes_after_1, 0);
                % 16,
fn test_cache() -> (FoyerCache, TempDir) {
    );
        Some(b"range2".as_slice())
        TOTAL_WRITES, key_count
    );
    let key = range_cache_key("seg0/_0.parquet", 9990000, 10000000);
        used_before - 300,
        IO_ENGINE,
    assert!(
        0.5,
        Some(b"footer_bytes".as_slice())
    );
    cache.put(&key, Bytes::from(vec![0xABu8; 512]));
            engine.len() as u64,
// Stale entries from the snapshot are corrected lazily by the sweep task.
#[test]
fn zero_byte_snapshot_file_treated_as_corrupt() {
    let (cache, _dir) = test_cache();
        b"{{corrupt}}",
    let dir = TempDir::new().unwrap();
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
        let prefix = format!("shard_test_{}", i);
        std::sync::atomic::Ordering::Relaxed,
    assert_eq!(removed, 2);
    // Sweeper should remove nothing.
        used_bytes, RANGE_SIZE as i64,
    // Calling sweep_once() twice on live entries must not double-decrement stats.
    let cache = FoyerCache::new(
        drop(cache2);
        .load(std::sync::atomic::Ordering::Relaxed);
        .path()
    //
        .stats
            BLOCK_SIZE as u64,
#[test]
            0,
    // After Drop, key_index.json must exist.
        "key_index must have {} buckets after evicting half",
    put_range(&cache, "/data/file.parquet", 0, 100, b"first");
        .unwrap_or(0);
        }
fn tiered_cache_size_bound_update_takes_effect_immediately() {
        .removed_bytes
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
        let json = serde_json::to_string(&snap).unwrap();
        .stats
            0,
            .entry(prefix.to_string())
/// between the 2nd and 3rd ticks when no puts happen.
            (BLOCK_SIZE * 2) as u64,
        TEST_BUFFER_POOL_SIZE,
            .exists()
            BLOCK_SIZE as u64,
        IO_ENGINE,
            .unwrap();
            TEST_CACHE_DISK_BYTES,
    // usage = max(−100, 0) / disk = 0 / disk = 0.0 < 0.5 → skip
    let (cache, _dir) = test_cache();
    assert!(
    );
        cache2.key_index.is_empty(),
        .map(|i| {
        cache
        "used_bytes must be decremented by freed bytes when sweeper removes stale entries"
///
    // Busy-assert: poll until all TOTAL_WRITES keys appear in key_index or deadline expires.
        .load(std::sync::atomic::Ordering::Relaxed);
    tiered.put_metadata(&key, Bytes::from_static(b"footer"));
    // ── Query: data read → miss first time ───────────────────────────
#[test]
        eviction_bytes_before + 200,
    for p in 0..NUM_PREFIXES {
        "dropping g3 (300) must leave 0"
    assert!(!dir
        }
        let cache2 = FoyerCache::new(
fn tiered_cache_total_miss_returns_none() {
        }
fn after_evict_prefix_new_put_is_retrievable() {
            0.0, // threshold disabled
        .stats
        .stats
            .active_in_bytes
/// 1. Shard init: warmup puts metadata via put_metadata()
        }
/// Dropping a get() future before it completes simulates future cancellation.
/// rejected entry on the next put.
}
        IO_ENGINE,
        shards_with_entries,
        .map(|v| v.len())
/// I/O engine for all test caches.
        // Wait up to 3 intervals for the next persist.
    // Simulate: future starts, guard created, active_in_bytes incremented.
    let below = ((TEST_CACHE_DISK_BYTES as f64 * 0.749) as i64);
    );
    let above = ((TEST_CACHE_DISK_BYTES as f64 * 0.90) as i64);
    );
        0,
fn cache_is_usable_after_clear() {
        .key_index
        "first range must still be readable after sweep"
    let dir = TempDir::new().unwrap();
        ".key_index.json.tmp must not exist after graceful shutdown (rename completed)"
    ));
    let used_after_v1 = cache
    assert_eq!(
    assert!(
        put_range(&cache, "/data/periodic.parquet", 0, 512, &vec![0u8; 512]);
        IO_ENGINE,
            .map(|v| v.len())
    put_range(&cache, "/data/file.parquet", 0, 100, b"before");
            let _ = block_on(reader_cache.get(&key));
        cache.evict_prefix("/data/evict_me.parquet");
        0.0, // threshold disabled
    assert_eq!(Arc::strong_count(&*boxed), 1);
    assert_eq!(
        put_range(&cache, "/data/b.parquet", 0, 256, &vec![0u8; 256]);
//
    key_index_store::save(&dir.path(), &cache.key_index).unwrap();
        .is_none(),
        TEST_CACHE_BLOCK_SIZE,
            TEST_BUFFER_POOL_SIZE,
            .exists(),
    // Node-level close: destroy the original Box.
}
    cache
    );
        .used_bytes
            0,
    let boxed: Box<Arc<dyn BlockCache>> = unsafe { Box::from_raw(ptr as *mut Arc<dyn BlockCache>) };
    );
    let guard = ActiveBytesGuard::new(&counter, 4096);
    ];
        )
        let cache1 = FoyerCache::new(
/// tokio::select! and it exits cleanly.
    assert!(block_on(cache.get(&range_cache_key("/data/file.parquet", 0, 99))).is_none());
/// put_metadata() skips entries larger than max_metadata_entry_size — oversized
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
        .eviction_bytes
    )
    assert!(
        .map(|v| v.len())
        "removed_count must increase after evict_prefix"
    assert_eq!(
    let (cache, _dir) = test_cache();
    );
        );
        false,
    let dir = TempDir::new().unwrap();
    {
}
}
    let dir = TempDir::new().unwrap();
        // Direct shard write bypasses DashMap's hashing — we control exactly which shard gets the key.
    );
// ── Background sweeper tests ──────────────────────────────────────────────────
            .eviction_bytes
    // A freshly created cache has no hits, misses, evictions, used bytes, or active reads.
}
    // key_index.json must still NOT exist (Drop was skipped).
    assert_eq!(
            BLOCK_SIZE as u64,
    let dir = TempDir::new().unwrap();
/// `block_on()` invocation. With 109 tests running in parallel, each calling `block_on()`
    // Inject stale keys under several different prefixes (they will hash to different shards).
    let stale_key = "data/mixed.parquet\x1F999000-999100".to_string();
    let dir = TempDir::new().unwrap();
        // Drop is called here — final persist happens.
    cache.put(
    );
        "key_index.json must be written by Drop even when persist task is disabled"
        BLOCK_SIZE,
    assert_eq!(
    assert_eq!(
            cache
            .join(key_index_store::KEY_INDEX_FILENAME)
    let fake1 = "data/gone.parquet\x1F0-100".to_string();
/// This confirms cancel() was actually called and not skipped.
}
/// the child token — it is a no-op in that case.
fn recovery_key_index_bulk_loaded_after_graceful_shutdown() {
    let cache = Arc::new(cache);
        false,
/// leaves the live keys in place, and correctly updates eviction stats.
    cache.evict_prefix("/data/file.parquet");
fn persist_task_writes_snapshot_within_interval() {
/// Stale entries in the recovered snapshot (keys that Foyer did not recover due
    assert!(
    // But sweep_once() bypasses the guard and still sweeps
/// (interval is very long); we only verify the cache is usable while the task
        tiered.data_cache().stats.hit_count.load(Ordering::Relaxed),
    let expected_total = NUM_PREFIXES * KEYS_PER_PREFIX;
/// first (miss) then data cache (miss) — both miss, returns None. Caller goes to S3.
            IO_ENGINE,
        .map(|v| v.len())
}
    assert!(
            0,
        .stats
    assert!(
        TEST_SUBMIT_QUEUE_SIZE,
fn sweep_cursor_advances_by_one_per_call() {
                .unwrap()
        "no stale entries expected immediately after put"
    );
/// The cache is usable throughout — stale keys don't cause panics or incorrect
fn key_index_has_no_entry_for_evicted_file() {
        // Drop of cache2 writes an empty key_index.json (empty key_index after clear).
        let deadline = std::time::Instant::now() + std::time::Duration::from_secs(5);
fn put_same_key_twice_does_not_duplicate_key_index_entry() {
    assert!(
    );
#[test]
            false,
            0.0,
fn tiered_cache_put_routes_to_data_cache() {
        IO_ENGINE,
        !token.is_cancelled(),
        cache
    // No prior cache instance — key_index.json does not exist.
        "key_index must have {NUM_PREFIXES} buckets after recovery"
    }
/// `lru_eviction_retains_keys_in_key_index`, etc.) create their own caches with
            .load(std::sync::atomic::Ordering::Relaxed),
    // used_bytes counter is updated synchronously on put().
    // Guard drops here — must restore counter to 0 even without the async block completing.
        );
        removed_bytes_before + 300,
        "used_bytes must be > 0 after populating {NUM_PREFIXES} prefixes"
    // removed cleanly — no panic, no stats corruption.
        0,
#[test]
/// used_bytes is 0, cache is fully functional.
fn drop_without_sweep_task_does_not_panic() {
        0,
}
//
    assert_eq!(
use crate::tiered_block_cache::TieredBlockCache;
    // New puts and gets must work normally after sweep.
            .join(key_index_store::KEY_INDEX_TMP_FILENAME)
}
    );
        .eviction_bytes
    let before_count = cache
        cache
        "key_index must be empty after all stale keys are swept"
/// Note: this test uses a 2-second interval and checks mtime doesn't advance
    let key = range_cache_key("seg0/_0.parquet", 5000000, 6000000);
    assert_eq!(
/// evict half the prefixes, and verify used_bytes decrements correctly.
fn key_index_evict_prefix_bulk_with_10k_entries() {
    // used_bytes is a monotonically-increasing counter (total bytes ever inserted).
        0,
        "removed_bytes: 100 + 200 = 300"
    assert!(
    // rather than using a fixed sleep — avoids flakiness on slow CI machines.
#[test]
        block_on(tiered.get(&s1)).as_deref(),
    let (cache, _dir) = test_cache();
    assert_eq!(
fn tiered_cache_evict_prefix_cleans_both_caches() {
        removed_count_after,
    put_range(&cache, "/data/b.parquet", 0, 100, b"b");
    evictor.join().expect("evictor panicked");
        assert_eq!(
        IO_ENGINE,
        while !dir
            .collect();
    let rc = unsafe { crate::foyer::ffm::foyer_snapshot_stats(0, out.as_mut_ptr()) };
    let _box = unsafe { Box::from_raw(ptr as *mut Arc<dyn BlockCache>) };
    let (cache, _dir) = test_cache();
        let result = block_on(cache.get(&key)).expect("entry should be retrievable");
    put_range(&cache, "/data/file.parquet", 0, 100, &vec![0u8; 100]);
    let (cache, _dir) = test_cache();
    });
    // No panic, no assertion failure → shutdown was clean.
    // One call sweeps shard 0 only.
    put_range(&cache, "/data/file.parquet", 0, 100, b"after");
        .entry("data/gone.parquet".to_string())
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
/// evict_prefix removes entries from both caches.
    // Reset cursor to shard 0 for a predictable starting point.
#[test]
        let snap: serde_json::Value = serde_json::from_str(&contents).unwrap();
        IO_ENGINE,
///   init than 64 MB), large enough for all non-capacity-pressure tests.
    });
    let (cache, _dir) = test_cache();
            engine.len() as u64,
            TEST_CACHE_BLOCK_SIZE,
    let engine = IO_ENGINE.as_bytes();
            false,
        .map(|_| {
    let chunk = vec![0u8; 512 * 1024];
    );
        IO_ENGINE,
}
        );
    let (cache, _dir) = test_cache();
    put_range(&cache, "/data/file.parquet", 0, 1024, &vec![0u8; 1024]);
            false,
        )
    // disk = 4MB, threshold = 0.75 (75%)
    );
    // Session 1: put data and let Drop write key_index.json.
        .entry("data/file.parquet".to_string())
/// (idle cache). The sentinel `i64::MIN` forces the first tick to always persist,
        cache.key_index.len(),
#[test]
        let mtime_after = std::fs::metadata(dir.path().join(key_index_store::KEY_INDEX_FILENAME))
            0,
fn key_index_is_empty_after_clear() {
}
    // Loop shard_count times to guarantee all shards are visited.
                .modified()
            .iter()
    drop(guard);
    assert!(
    let handles: Vec<_> = (0..THREAD_COUNT)
        "active_in_bytes must be 0 after get() completes"
        Bytes::copy_from_slice(data),
    assert_eq!(
    assert_eq!(
            evictor_cache.evict_prefix("/data/shard.parquet");
    // threshold = 0.0: disabled — always sweep
            dir_str.len() as u64,
            dir.path(),
        .as_object()
///
/// foyer_snapshot_stats returns 0 on a valid cache pointer and writes 14 i64 values.
            dir_str.len() as u64,
    put_range(&cache, "/data/b.parquet", 0, 100, b"file_b");
        dir.path(),
        .stats
            native_bridge_common::error::native_error_free(-result);
        "used_bytes should be 1024 after a single 1KB put"
        false,
        foyer_create_cache(
    std::thread::sleep(std::time::Duration::from_millis(100));
        cache2
        count_after_second, 1,
    block_on(cache.clear());
        .load(std::sync::atomic::Ordering::Relaxed);
    cache.stats.used_bytes.store(
}
}
}
            0,
    let (cache, _dir) = test_cache();
            1,   // persist every 1 second
    }
    assert_eq!(
fn ffm_destroy_with_zero_ptr_returns_error() {
        0,
            IO_ENGINE,
}
    let (cache, _dir) = test_cache();
 * SPDX-License-Identifier: Apache-2.0
}
            .stats
    block_on(cache.clear());
    let (cache, _dir) = test_cache();
    );
fn lru_eviction_retains_keys_in_key_index() {
    let key = range_cache_key("/data/file.parquet", 0, 512);
            TEST_SUBMIT_QUEUE_SIZE,
/// key_index.json is deleted.
    // Evictor: repeatedly evicts the same prefix — simulates a shard deletion racing
        Some(b"file_c".as_slice())
    // Shards close.
        0,
            TEST_SUBMIT_QUEUE_SIZE,
    let invalid_utf8 = [0xFF, 0xFE, 0xFD];
        dir.path(),
        r3.as_ref().map(|b| b.len()),
        .get("data/b.parquet")
fn recovery_clear_deletes_snapshot_file() {
        "clear() must count 2 removed entries"
fn persist_task_last_persisted_reset_forces_persist_after_recovery() {
    assert!(
        let mtime_after_idle =
            "persist task must rewrite key_index.json after evict_prefix() changed used_bytes"
        put_range(&cache, "/data/f.parquet", 0, 100, &vec![0u8; 100]);
    let removed2 = cache.sweep_once();
    assert_eq!(result.as_deref(), Some(b"second".as_slice()));
    );
            0,
/// A shard containing both live and stale keys: sweep removes only the stale keys,
fn snapshot_stats_returns_zero_for_fresh_cache() {
    });
    assert!(!cache.key_index.contains_key("data/target.parquet"));
        put_range(&cache, "/data/keep_me.parquet", 0, 512, &vec![0u8; 512]);
        !cache
    let dir = TempDir::new().unwrap();
fn ffm_create_cache_ptr_cloneable_for_multiple_shards() {
    assert!(
        )
    }
fn sweep_once_does_not_touch_other_shards() {
#[test]
fn snapshot_stats_used_bytes_reflects_put() {
        "eviction_bytes must reflect both stale keys (100 + 100 = 200)"
        .join(key_index_store::KEY_INDEX_FILENAME)
    let fake2 = "data/gone.parquet\x1F100-200".to_string();
                .data_cache()
    tiered.put(&key, Bytes::from(vec![0x11; 4096]));
        total_removed += cache.sweep_once();
    let dir = TempDir::new().unwrap();
    // After get() completes: guard has been dropped, counter back to 0.
    // Loop shard_count times to guarantee the shard containing the fake key is visited.
            TEST_SUBMIT_QUEUE_SIZE,
    );
            "key_index.json must NOT exist while cache is alive with persist_interval=0"
        NUM_PREFIXES * KEYS_PER_PREFIX
    // Key_index now has 2 keys for the prefix: 1 live + 1 stale.
        dir.path()
fn ffm_destroy_with_negative_ptr_returns_error() {
        }
        );
    assert_eq!(a_count, 2, "data/a.parquet must have 2 keys");
    // Data cache untouched
            0,
}
            engine.as_ptr(),
fn snapshot_stats_null_out_via_created_cache() {
        512,
        let key = range_cache_key("/data/file.parquet", 0, 100);
fn persist_task_not_spawned_when_interval_is_zero() {
        0,
            TEST_CACHE_BLOCK_SIZE,
/// metadata SSD), metadata is found without any re-registration.
        cache2.key_index.contains_key("data/shard2/file.parquet"),
            engine.len() as u64,
        );
        cache
    );
            128 * 1024 * 1024,
    use std::collections::HashSet;
            TEST_CACHE_DISK_BYTES,
    // Evict one shard — only that shard's entry must be removed.
    let remaining = cache
        .key_index
    );
        Some(b"shard1".as_slice())
    );
        .exists());
#[test]
    assert_eq!(removed, 0);
    let key = range_cache_key("/data/file.parquet", 0, 1024);
    let cache = FoyerCache::new(
        dir.path(),
            .active_in_bytes
        0,
}
                .modified()
// ── concurrent access ─────────────────────────────────────────────────────────
    std::fs::write(
    let reader = std::thread::spawn(move || {
    assert_eq!(Arc::strong_count(boxed), 1, "only the box remains");
/// The guard's Drop impl must restore active_in_bytes to 0.
        .stats
        }),
        false,
    block_on(cache.clear());
    // Let the sweep fire at least once.
            .join(key_index_store::KEY_INDEX_FILENAME)
    assert!(ptr > 0);
            TEST_SUBMIT_QUEUE_SIZE,
#[test]
    );
    // Two files, one range each: 0-100 = 100 bytes, 0-200 = 200 bytes → total 300 bytes, 2 entries.
    // Next startup: key_index starts empty (clean startup path).
        &range_cache_key(path, 0, 1_000_000),
        cache.sweep_once();
}
            dir_str.len() as u64,
        cache.should_skip_sweep(),
    );
    const KEYS_PER_PREFIX: usize = 100;
        true,
        .stats
/// `evict_prefix` is a scan-then-remove operation: it collects matching key_index entries
    );
        .get("data/a.parquet")
            engine.len() as u64,
            let key = range_cache_key("/data/shared.parquet", i * 100, (i + 1) * 100);
        cache
        total_removed, 4,
        // Wait for first persist (sentinel fires on first tick).
    let (cache, _dir) = test_cache();
            0.0,
    );
    assert!(
#[test]
    let shard1_keys = index["data/nodes/0/shard1.parquet"].as_array().unwrap();
fn put_same_key_twice_replaces_value() {
            tiered
            BLOCK_SIZE as u64,
fn sweep_task_with_active_watchdog_stops_cleanly_on_cancel() {
        dir.path(),
        // Drop persists.
    let dir_str = dir.path().to_str().unwrap();
    {
    );
/// After the call the cursor is `preset + 1`.
            if dir
/// Inject one stale key per shard (using raw shard access). After a single sweep_once()
}
    assert_eq!(
        300,
        let _guard = ActiveBytesGuard::new(&counter, 512);
    cache.put(&key, Bytes::from(vec![0u8; 1024]));
            > 0,
    put_range(&cache, "/data/mixed.parquet", 0, 1024, &vec![0u8; 1024]);
        cache
            dir.path().join(key_index_store::KEY_INDEX_FILENAME),
    use tokio_util::sync::CancellationToken;
        }
    // Cache must be fully functional.
            .key_index
    assert_eq!(
}
/// respond correctly to put() and get() operations — no functional regression.
#[test]
        .load(std::sync::atomic::Ordering::Relaxed);
    let result = unsafe { foyer_destroy_cache(ptr) };
    }
        block_on(tiered.get(&small_key)).map(|b| b.len()),
        "usage=74.9% < threshold=75%: sweep must be skipped"
        NUM_PREFIXES,
            0,
    );
        TEST_BUFFER_POOL_SIZE,
            TEST_SUBMIT_QUEUE_SIZE,
            i % 16,
        &range_cache_key(path, start, end),
/// On the next startup, the cache recovers from whatever was last periodically persisted
}
    // Poll for key_index.json — the persist task must write it within 5s.
    // Fake key range: 99999–100000 = 1 byte. key_byte_size() parses this from the key string.
    // Foyer's async flusher writes to disk asynchronously after put(); we wait for it
/// to exercise the trait default explicitly.
        dir.path()
    use crate::traits::BlockCache;
    assert_eq!(
        "oversized metadata must not reach the metadata tier"
        .load(std::sync::atomic::Ordering::Relaxed);
fn tiered_cache_multiple_shards_are_independent() {
        512 * 1024,
    // Extended version of sweep_once_removes_empty_prefix_buckets that also checks bytes.
        TEST_CACHE_BLOCK_SIZE,
    cache
        foyer_create_cache(
    let result = block_on(cache.get(&range_cache_key("/data/file.parquet", 0, 100)));
        Bytes::from_static(b"data"),
                break;
        TEST_CACHE_DISK_BYTES,
        0.0,
        .stats
        block_on(cache.get(&range_cache_key("/data/a.parquet", 0, 100))).as_deref(),
///
            false,
#[test]
        dir.path(),
        0.0,
    // usage = 99.9% → still below 100% → skip
        "must have {expected_total} total keys"
                s.insert(key);
        .load(std::sync::atomic::Ordering::Relaxed);
        0.0,
            .collect();
        .unwrap_or(0);
            0,
        0
        0,
        TEST_BUFFER_POOL_SIZE,
        .used_bytes
        dir.path(),
fn recovery_used_bytes_initialized_from_snapshot() {
        // Drop persists the remaining key_index (only kept.parquet).
        .insert("data/file.parquet\x1F0-100".to_string());
    // The cache must still be fully functional after the simulated panic.
    use std::sync::atomic::AtomicI64;
            .used_bytes
    assert!(!dir
    );
    let removed_after = cache
    let dir = TempDir::new().unwrap();
    );
        .eviction_count
        TEST_CACHE_DISK_BYTES,
    for i in 0..20 {
}
        cache.key_index.is_empty(),
    // usage = exactly 75% → NOT below → do NOT skip
        // Evict one prefix before shutdown.
            0.0,
    assert!(!snap_exists, "key_index.json must be deleted by clear()");
        );
            dir.path(),
        "stale key must be gone after sweep"
/// sweep_interval_secs=0 must not spawn a sweep task.
        2048,
                .modified()
    // Data length matches the key range (100 bytes each) so key_byte_size() and data.len()
    assert_eq!(
/// immediately after new() — before any put() is called.
/// Shared Tokio runtime for all `block_on()` calls in tests.
        "real key must remain in key_index after sweep"
    );
#[test]
#[test]
        .extend(vec![fake1, fake2]);
            .used_bytes
            0,
///
fn multiple_files_are_independent() {
        0,   // no persist task
    let boxed = Box::new(std::sync::Arc::clone(&cache_trait));
    for (i, &v) in buf.iter().enumerate() {
        .stats
        let cache = FoyerCache::new(
        removed_bytes,
    let cache = Arc::new(cache);
        .insert(stale_key.clone());
    );
fn put_range(cache: &FoyerCache, path: &str, start: u64, end: u64, data: &[u8]) {
/// to LRU eviction before the last persist) are cleaned up by sweep_once().
/// the configured bound (used by TieredObjectStore::get_opts to avoid buffering).
static TEST_RUNTIME: std::sync::OnceLock<tokio::runtime::Runtime> = std::sync::OnceLock::new();
        .used_bytes
            dir.path(),
fn foyer_cache_put_metadata_default_routes_to_put() {
}
        TEST_BUFFER_POOL_SIZE,
    );
#[test]
        0.0,
    let used_bytes_before = cache
    put_range(&cache, "/data/file.parquet", 100, 300, &vec![0u8; 200]);
            ["data/stale.parquet\x1F0-512".to_string()].into(),
        foyer_create_cache(
    assert_eq!(
/// With HashSet, the second insert is a no-op.
}
            std::fs::metadata(dir.path().join(key_index_store::KEY_INDEX_FILENAME))
                BLOCK_SIZE as u64,
    // disk=2MB ≥ block_size=512KB (Foyer invariant: block_size ≤ disk).
    }
}
            foyer_create_cache(
// ── clear ─────────────────────────────────────────────────────────────────────
/// Block size and disk capacity for FFM/integration tests that need a large Foyer instance.
        "used_bytes must be 0 after clear"
#[test]
    put_range(&cache, "/data/a.parquet", 0, 100, b"a");
        .join(key_index_store::KEY_INDEX_TMP_FILENAME)
        .load(std::sync::atomic::Ordering::Relaxed);
            .join(key_index_store::KEY_INDEX_FILENAME)
    let (cache, _dir) = test_cache();
        .load(std::sync::atomic::Ordering::Relaxed);
    assert!(
    assert_eq!(removed1, 0, "no stale entries on first sweep");
    let dir = TempDir::new().unwrap();
    // Run enough sweeps to guarantee the shard containing "data/mixed.parquet" is processed.
        0,
    assert!(result.is_some());
    let snap = cache.stats.snapshot();
    }
#[test]
}
                dir_str.len() as u64,
            "counter must be 512 while guard is alive"
    // Total stale bytes = 300
        .stats
        used
        0.0,
        0,
    );
        cache
}
        TEST_SUBMIT_QUEUE_SIZE,
    );
            TEST_SUBMIT_QUEUE_SIZE,
fn concurrent_stampede_same_key_does_not_duplicate_key_index() {
#[test]
    );
        TEST_CACHE_DISK_BYTES,
    );
        "threshold=1.0, usage=100%: sweep must NOT be skipped"
        cache
    );
        TEST_CACHE_BLOCK_SIZE,
    key_index_store::save(dir.path(), &dash).unwrap();
    cache
        dir.path(),
/// used_bytes is only incremented on the first (genuine) insert.
                engine.as_ptr(),
        dir.path(),
        .key_index
        .map(|v| v.len())
        let cache = FoyerCache::new(
            break count;
    let g1 = ActiveBytesGuard::new(&counter, 100);
#[test]
    assert!(ptr > 0);
    assert!(
        cache.should_skip_sweep(),
        TEST_CACHE_DISK_BYTES,
    // Fake key range 99999-100000 = 1 byte.
            BLOCK_SIZE as u64,
    );
    );
    put_range(&cache, "/data/a.parquet", 0, 100, &vec![0u8; 100]);
/// put() skips data entries larger than max_data_entry_size; the getter reflects
    );
        );
    let result = block_on(cache.get(&key));
        0.0,
    // put() must not panic — entry presence is not asserted (depends on timing).
/// After 16 calls the cursor has wrapped through all shards (0..15).
    cache
        "4KB rejected under 1KB bound"
            native_bridge_common::error::native_error_free(-ptr);
            dir_str.len() as u64,
        cache3.key_index.is_empty(),
        .stats
    // Clone the token before drop so we can inspect it after.
}
        cache.should_skip_sweep(),
    let used_bytes_after = cache
        256,
            .sweep_cursor
}
    let (cache, _dir) = test_cache();
        foyer_create_cache(
///   entry) while staying well under the 4 MB disk cap.
        );
    // Second put of the same key — Foyer upserts the value, key_index is unchanged.
    let result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
        );
        0,
        block_on(tiered.data_cache().get(&small_key)).is_some(),
        "clear() on empty cache must not increment removed_count"
    );
    );
}
        cache
    }
        TEST_CACHE_BLOCK_SIZE,
        TEST_CACHE_BLOCK_SIZE,
                s
            dir.path(),
            dir.path(),
            .sweep_cursor
    let ptr = unsafe {
            .eviction_bytes
        put_range(&cache, "/data/idle.parquet", 0, 100, &vec![0u8; 100]);
    // Preset to shard 5.
        put_range(&cache, "/data/a.parquet", 512, 1024, &vec![0u8; 512]);
fn sweep_cursor_eventually_removes_all_stale_keys_across_multiple_calls() {
    let (cache, _dir) = test_cache();
        block_on(tiered.get(&footer_key)).is_some(),
        0,
            .used_bytes
        raw,
    let cache = FoyerCache::new(
        0,
    put_range(
    tiered.put_metadata(&key, Bytes::from_static(b"old_footer"));
        0.0,
    let cache = Arc::new(cache);
        .stats
    cache.stats.used_bytes.store(
        "metadata tier must be empty after clear_sync()"
    let counter = AtomicI64::new(0);
        "used_bytes must return to 0 after evicting all entries"
        1 * 1024 * 1024,
        cache
    put_range(&cache, "/data/target.parquet", 0, 100, b"data");
        "eviction_bytes must not change across two sweeps of live entries"
    std::thread::sleep(std::time::Duration::from_millis(100));
    const TOTAL_WRITES: usize = 8;
    // After sweeping all shards, the stale key is removed (inner.contains() returns false).
        0,
        "key_index must be empty after stale keys are swept"
            s.insert(key1);
    let dir = TempDir::new().unwrap();
        cache.should_skip_sweep(),
        );
        .path()
    put_range(&cache, "/data/file.parquet", 0, 100, b"fresh");
#[test]
    );
    // Run shard_count sweep cycles to guarantee all shards are covered exactly once.
    let shard_count = cache.key_index.shards().len();
        TEST_CACHE_BLOCK_SIZE,
    assert!(
}
        .extend(vec![
        IO_ENGINE,
    let key = range_cache_key("/data/large.parquet", 0, data.len() as u64);
    let (cache, _dir) = test_cache();
    let (cache, _dir) = test_cache();
    assert!(
            10,
            TEST_BUFFER_POOL_SIZE,
    let result = unsafe { foyer_destroy_cache(0) };
        .used_bytes
    let eviction_bytes_before = cache
/// Disk capacity for the default `test_cache()` helper.
    assert_eq!(removed, 1, "sweep must remove the 1 stale key");
    );
        false,
    // usage = exactly 100% → ratio = 1.0 = threshold → NOT below → do NOT skip
/// With the old Vec approach, two puts added `size` to used_bytes twice even though
            std::thread::spawn(move || {
        removed_after > removed_before,
    writer.join().expect("writer panicked");
        .unwrap_or(0);
    let key = range_cache_key("/data/file.parquet", 0, 100);
        // Drop calls save() — writes key_index.json
    drop(shard2);
        TEST_CACHE_DISK_BYTES,
            .fetch_add(byte_size, std::sync::atomic::Ordering::Relaxed);
    let contents = std::fs::read_to_string(&path).unwrap();
        TEST_SUBMIT_QUEUE_SIZE,
fn recovery_with_corrupt_snapshot_starts_empty() {
    // Put a real entry: key is live in Foyer.
    // The file itself must be readable JSON above a minimum size.
    let (cache, _dir) = test_cache();
    let eviction_bytes_after_1 = cache
            .exists(),
    // used_bytes must never go negative — that would indicate double-subtraction of stats.
            "cursor must be {} after {} calls",
    }
}
        TEST_CACHE_DISK_BYTES,
        let dir = TempDir::new().unwrap();
fn ffm_create_cache_returns_fat_ptr_with_strong_count_one() {
    );
#[test]
        TEST_BUFFER_POOL_SIZE,
    );
    );
        "non-evicted prefix must still appear after recovery"
}
        ]);
fn evict_prefix_on_nonexistent_prefix_is_noop() {
///
        }),
    cache.evict_prefix("");
        "used_bytes must be 600 (sum of all recovered key ranges) after recovery"
    for i in 0u64..4 {
        .or_default()
    );
            dir.path(),
            128 * 1024 * 1024,
    let dir = TempDir::new().unwrap();
}
    // Verify data is in data_cache only
    drop(cache); // calls shutdown.cancel() — must be a no-op
    let (cache, _dir) = test_cache();
fn ffm_snapshot_stats_null_out_returns_error() {
            0,
        );
            TEST_SUBMIT_QUEUE_SIZE,
#[test]
                .get(&range_cache_key(path, 9_000_000, 10_000_000))
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
        TEST_BUFFER_POOL_SIZE,
/// Verify that the sweep task with the watchdog outer loop stops cleanly
    }
        IO_ENGINE,
        .stats
/// After dropping a cache, its CancellationToken is cancelled (is_cancelled() == true).
        "active_in_bytes must be restored to 0 when get() future is cancelled mid-flight"
            .join(key_index_store::KEY_INDEX_FILENAME)
        TEST_CACHE_BLOCK_SIZE,
        .removed_count
    put_range(&cache, "/data/keep.parquet", 512, 1024, &vec![0xBBu8; 512]);
        NUM_PREFIXES,
        TEST_SUBMIT_QUEUE_SIZE,
        TEST_CACHE_DISK_BYTES,
        0,
    assert_eq!(
        cache.key_index.contains_key("data/stale.parquet"),
    let (cache, _dir) = test_cache();
        let key = range_cache_key("/data/file.parquet", i * 524288, (i + 1) * 524288);
        !cache.key_index.contains_key("data/stale.parquet"),
                .get(&range_cache_key(path, 0, 1_000_000))
    );
        block_on(tiered.get(&key)).is_none(),
use crate::foyer::foyer_cache::ActiveBytesGuard;
}
            let cache = Arc::clone(&cache);
        cache
    let a_count = cache2
            TEST_CACHE_DISK_BYTES,
    let result = block_on(cache.get(&range_cache_key("/data/file.parquet", 0, 100)));
/// strong count is exactly 1 immediately after creation.
        put_range(&cache, "/data/file.parquet", 0, 100, b"data");
        cache.sweep_once();
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
#[test]
        index.insert(
        TEST_CACHE_DISK_BYTES as i64,
    );
    // Put two real entries.
        panic!("simulated key_index_store::save panic");
    let removed_count_before = cache
/// Cache remains fully functional (put/get/evict/clear) after having been used
        "should have 1 live + 1 stale key before sweep"
#[test]
    assert_eq!(
            dir_str.as_ptr(),
    drop(shard1);
    const KEYS_PER_PREFIX: usize = 100;
            .unwrap();
/// After recovery, evict_prefix() correctly removes entries that were loaded
        .stats
        removed_count,
        "sweeper should have removed the 1 fake/stale key"
                let key = range_cache_key("/data/shared.parquet", 0, RANGE_SIZE);
#[test]
    cache.evict_prefix("/data/target.parquet");
        .or_default()
        block_on(tiered.get(&footer_key)).as_deref(),
    assert_eq!(
        block_on(tiered.get(&key)).as_deref(),
        h.join().expect("thread panicked");
        .or_default()
    assert!(cache.key_index.contains_key("data/file.parquet"));
    {
    const ITERATIONS: u64 = 100;
        }
    block_on(cache.clear());
    );
    assert!(!cache.key_index.contains_key("data/gone.parquet"));
        cache.evict_prefix("/data/file.parquet");
    assert_eq!(counter.load(std::sync::atomic::Ordering::Relaxed), 42);
    );
        .expect("index must be a JSON object");
            dir.path(),
/// Stale keys injected across multiple prefix buckets are all eventually removed
            dir_str.as_ptr(),
    let removed = cache.sweep_once();
    // Clone to bump strong count by 1 — original was 1, now 2.
/// after enough sweep_once() cycles. This test verifies the cursor-based sweep
/// Presetting the cursor and calling sweep_once() must process shard `cursor % 16`.
        TEST_SUBMIT_QUEUE_SIZE,
    let result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
    };
        .unwrap_or(0);
    assert!(cache2.key_index.contains_key("data/shard1/file.parquet"));
            TEST_CACHE_DISK_BYTES,
#[test]
            TEST_CACHE_BLOCK_SIZE,
            .or_default()
            0,
        TEST_CACHE_DISK_BYTES,
        TEST_SUBMIT_QUEUE_SIZE,
        &vec![0u8; 256],
    assert_eq!(
    let meta_dir = TempDir::new().expect("metadata temp dir");
            .stats
    );
/// the scan and the remove will have its entry included in the eviction — this is the
 *
    cache.evict_prefix("/data/file.parquet");
}
            TEST_CACHE_BLOCK_SIZE,
fn evict_prefix_twice_is_safe() {
    );
        256 * 1024,
    );
    let shard_count = cache.key_index.shards().len();
        assert!(
        block_on(tiered.get(&range_cache_key("seg0/_0.parquet", 8_000_000, 8_250_000))).is_none()
    let cache = FoyerCache::new(
            .join(key_index_store::KEY_INDEX_TMP_FILENAME)
        dir.path(),
    };
    assert_eq!(
    );
    cache
        raw,
            .unwrap_or(0);
    );
        eviction_count_before + 1,
            dir.path(),
///
///
            (BLOCK_SIZE * 2) as u64,
        .join(key_index_store::KEY_INDEX_FILENAME)
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
fn concurrent_put_and_get_same_file_does_not_panic() {
    assert_eq!(
        "all {} keys must remain in key_index after DRAM eviction (entries still on disk); got {}",
    }
    assert!(
        "clear() must count 100 + 200 = 300 removed bytes"
        .sweep_cursor
    let fake2 = "data/gone.parquet\x1F100-200".to_string();
    // 16 sweep calls — cursor increments on each (modulo 16 internally via fetch_add).
        cache2.key_index.contains_key("data/b.parquet"),
    );
    );
    // Range: 99999-100000 → 1 byte, parseable by key_byte_size().
        let appeared = loop {
        false,
    );
fn sweep_enabled_cache_is_usable_while_task_sleeping() {
            0,
    assert!(block_on(cache.get(&range_cache_key("/data/file.parquet", 200, 300))).is_none());
        .unwrap_or(0);
        );
    }
        IO_ENGINE,
        TEST_CACHE_DISK_BYTES,
/// multiple times, this produced hundreds of separate Tokio runtimes — on top of the
        0,
        "key_index must be empty after clear()"
    let eviction_bytes_after = cache
            let mut s = std::collections::HashSet::new();
    let key = range_cache_key("/data/file.parquet", 0, 100);
    assert!(block_on(tiered.get(&s0)).is_none());
            .stats
        .load(std::sync::atomic::Ordering::Relaxed);
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
/// so we verify that a second interval tick with no puts does not change the mtime.
    tiered.put(
    assert!(
        TEST_CACHE_BLOCK_SIZE,
    let cache = FoyerCache::new(
    );
        "sweep_once() must sweep regardless of threshold"
            .load(std::sync::atomic::Ordering::Relaxed),
    assert_eq!(
        dir.path(),
/// The sum of key_byte_size for all recovered keys must equal used_bytes
        std::thread::sleep(std::time::Duration::from_millis(100));
    );
            0.0_f64,
    for p in 0..NUM_PREFIXES / 2 {
        false,
    let engine = IO_ENGINE.as_bytes();
            }
    assert!(
    }
        TEST_SUBMIT_QUEUE_SIZE,
        TEST_BUFFER_POOL_SIZE,
    let bytes = std::fs::metadata(&path).unwrap().len();
    );
    tiered.put_metadata(&big_key, Bytes::from(vec![0xAB; 4096])); // 4KB > 2KB → skipped
#[test]
fn event_remove_after_evict_prefix_does_not_panic_or_corrupt_key_index() {
        for _ in 0..ITERATIONS {
        2 * 1024 * 1024,
    use dashmap::DashMap;
            .stats
        assert!(!index.is_empty(), "snapshot must contain the put() entries");
    // Load back and verify.
        .removed_count
        );
}
        cache.evict_prefix(&prefix);
            }
    assert!(result < 0);
            .load(std::sync::atomic::Ordering::Relaxed),
            engine.as_ptr(),
    );
        let key = range_cache_key(&format!("/data/file_{}.parquet", i), 0, 1024);
    // Inject a stale key
        used_after,
    let data_misses_before = tiered.data_cache().stats.miss_count.load(Ordering::Relaxed);
            0,
            used_after_evict < 1024,
fn key_index_clear_with_10k_entries() {
    };
    assert_eq!(
    drop(shard3);
        "eviction_count must be incremented for stale entries removed by sweeper"
/// Tests that explicitly exercise capacity pressure (`put_and_get_work_after_cache_nears_capacity`,
        count_after_second
    tiered.put(&big_key, Bytes::from(vec![0xAB; 4096])); // 4KB > 2KB → skipped
    let count_after_second = cache
#[test]
    let big_key = range_cache_key("seg0/_0.parquet", 0, 4096);
        counter.load(std::sync::atomic::Ordering::Relaxed),
        for i in 0u64..50 {
fn active_bytes_guard_multiple_concurrent_guards() {
    );
        dir.path()
    cache.evict_prefix("/data/file.parquet");
    // Both prefix buckets must be present immediately after new().
        cache
                0,
    put_range(&cache, "/data/b.parquet", 0, 200, &vec![0u8; 200]);
}
    // Snapshot via the FFM function.
        TEST_BUFFER_POOL_SIZE,
            IO_ENGINE,
}
            dir.path(),
        count, 1,
    let key = range_cache_key("/data/file.parquet", 0, 1024);
#[test]
        "stale key must be removed by sweep_once() even when threshold would skip"
    tiered.put_metadata(&key, Bytes::from(vec![0xC; 500_000]));
        0.0,
const BLOCK_SIZE: usize = 64 * 1024 * 1024; // 64 MB — used by FFM tests (disk=64MB) and large_value test
        assert_eq!(counter.load(std::sync::atomic::Ordering::Relaxed), 42);
    assert_eq!(
        Some(1024),
            0.0_f64,
        TEST_BUFFER_POOL_SIZE,
        .stats
            .stats
        let ptr = unsafe {
            .stats
            0,
            "data/stale.parquet".to_string(),
    let shard_count = cache.key_index.shards().len();
        TEST_BUFFER_POOL_SIZE,
        .used_bytes
        "second put of same key must NOT add a duplicate entry (HashSet dedup); got {}",
            BLOCK_SIZE as u64,
        .insert("data/keep.parquet\x1F9000-9100".to_string());
/// (or starts empty if periodic persist was also disabled).
    assert!(cache.key_index.contains_key("data/other.parquet"));
    // ── S3 fetch → populate_cache → put() → data cache ──────────────
    // 2 keys for a.parquet + 1 key for b.parquet = 3 total.
        assert_eq!(
}
        removed_count_before + 2,
        assert!(ptr > 0);
        "used_bytes must not be negative after concurrent put/evict; got {}",
            let key = range_cache_key("/data/shard.parquet", i * 100, (i + 1) * 100);
        cache.should_skip_sweep(),
fn recovery_evict_prefix_works_on_recovered_keys() {
}
    std::fs::write(dir.path().join(key_index_store::KEY_INDEX_FILENAME), b"").unwrap();
        put_range(&cache, "/data/f.parquet", 100, 300, &vec![0u8; 200]);
    }
    let mut total_removed = 0usize;
    assert_eq!(
#[test]
            std::fs::metadata(dir.path().join(key_index_store::KEY_INDEX_FILENAME))
        block_on(tiered.get(&big_key)).is_none(),
        snap[6], 1024,
            dir.path(),
        block_on(tiered.get(&range_cache_key("seg0/_0.parquet", 7_500_000, 9_000_000))).is_none()
        0,
    drop(cache);
    let dash: DashMap<String, HashSet<String>> = DashMap::new();
    put_range(&cache, "/data/new.parquet", 0, 256, &vec![0xCCu8; 256]);
    {
/// behavior; they just occupy key_index until swept.
            (BLOCK_SIZE * 2) as u64,
        "must have {} total keys after recovery",
        h.join().expect("thread panicked");
        0
        TEST_CACHE_DISK_BYTES,
        );
    assert_eq!(
/// Verify that `catch_unwind` correctly catches a panic in the persist path.
    //
    assert!(
    // Event::Evict fires when an entry leaves the 1-byte DRAM tier and is written to disk.
    }
#[test]
        put_range(
    unsafe { foyer_destroy_cache(ptr) };
/// Even though used_bytes is non-zero, last_persisted starts at i64::MIN ≠ used_bytes,
    }
            0.0,
    assert_eq!(
/// 4. Query 2: same data → hit from data cache
/// Multiple shards — evicting one doesn't affect others.
        TEST_SUBMIT_QUEUE_SIZE,
/// Verifies the byte-size accounting is accurate through the shard-based path.
    );
    assert!(!dir
// ─── 10k-scale key_index tests ────────────────────────────────────────────────
            0.0,
/// correctly iterates shards and removes all stale entries over multiple passes.
    );
    // with an in-flight read that triggers a put().
    let ptr = unsafe {
/// A guard with value 0 is a no-op — counter stays unchanged.
        .eviction_bytes
        "second range must still be readable after sweep"
        0.75,
/// The cursor sweep correctly updates eviction_bytes when removing stale keys.
#[test]
    block_on(cache.get(&key));
        BLOCK_SIZE,
    let tiered = TieredBlockCache::new(data_cache, metadata_cache);
            .get("data/big.parquet")
            std::fs::metadata(dir.path().join(crate::key_index_store::KEY_INDEX_FILENAME))
    // Drop _box — strong count reaches 0, FoyerCache freed.
    );
        "used_bytes must still be 512 after second put of the same key (no double-count)"
    );
            0,
    let dir = TempDir::new().unwrap();
    let ptr = unsafe {
    let key = range_cache_key("/data/file.parquet", 0, 100);
        1024 * 1024,
        .get("data/file.parquet")
fn evict_prefix_does_not_affect_other_files() {
    drop(boxed);
    };
            &vec![0u8; 256],
//
        IO_ENGINE,
        block_on(tiered.get(&range_cache_key("seg0/_0.parquet", 8_000_000, 8_500_000))).is_some()
            0, // disabled
    // Superset → miss (different key)
use tempfile::TempDir;
        assert_eq!(snap["version"], 1, "snapshot must have version=1");
    // All entries were just put — they are on disk and inner.contains() returns true.
        !shards[1].read().is_empty(),
    let (cache, _dir) = test_cache();
    // Real entries must still be retrievable after sweep.
    use std::sync::atomic::AtomicI64;
            TEST_CACHE_BLOCK_SIZE,
        .key_index
        false,
                (BLOCK_SIZE * 2) as u64,
        RANGE_SIZE, THREAD_COUNT, used_bytes
        Some(b"file_a".as_slice())
        let cache = FoyerCache::new(
        TEST_CACHE_DISK_BYTES,
    tiered.update_max_metadata_entry_size(2048);
        TEST_BUFFER_POOL_SIZE,
    assert_eq!(
            TEST_BUFFER_POOL_SIZE,
/// Verify the design contract: `last_persisted` is reset to `i64::MIN` at the top
        .stats
    let mut out = [0i64; 20];
    );
    cache
fn tiered_cache_full_datafusion_query_simulation() {
            .exists(),
}
        &buf[10..],
        "overall and block_level sections must be identical"
        "usage=75% == threshold=75%: sweep must NOT be skipped"
        IO_ENGINE,
        3600,
        TEST_BUFFER_POOL_SIZE,
    let (cache, _dir) = test_cache();
            BLOCK_SIZE as u64,
        IO_ENGINE,
            IO_ENGINE,
fn sweep_threshold_negative_used_bytes_treated_as_zero() {
use std::sync::atomic::Ordering;
            let cache = Arc::clone(&cache);
    // No subtraction happens on replace because Event::Replace almost never fires.
            std::ptr::null(),
        let cache = FoyerCache::new(
fn sweep_threshold_one_skips_unless_completely_full() {
#[test]
        .store(exact, std::sync::atomic::Ordering::Relaxed);
            0,
        }
        !cache2.key_index.contains_key("data/shard1/file.parquet"),
        .load(std::sync::atomic::Ordering::Relaxed);
    let result = block_on(tiered.get(&key));
    let handles: Vec<_> = (0..16)
}
/// Verified indirectly: the key_index is not modified by any background activity
        0,
            std::thread::sleep(std::time::Duration::from_millis(100));
    let ptr = unsafe {
        cache
    });
fn put_same_key_twice_does_not_double_count_used_bytes() {
            engine.as_ptr(),
    let shard1 = Arc::clone(boxed);
        )
            TEST_CACHE_DISK_BYTES,
    let result = block_on(cache.get(&key));
            .load(std::sync::atomic::Ordering::Relaxed),
                break;
    // Before get(): active_in_bytes must be 0.
        TEST_CACHE_BLOCK_SIZE,
        )
    assert!(shards.len() >= 2, "test requires at least 2 shards");
    let dir = TempDir::new().unwrap();
        );
    // Clean up the Box.
        std::fs::write(
            TEST_BUFFER_POOL_SIZE,
    put_range(&cache, "/data/other.parquet", 0, 100, b"other");
        false,
            .exists(),
        "key_index.json must exist after graceful shutdown"
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
#[test]
        dir.path(),
    // Exact same range → hit
    // shard1 should have 2 keys, shard2 should have 1.
#[test]
}
    assert_eq!(
    let chunk = vec![0xABu8; CHUNK_SIZE];
    );
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
/// Putting the same key twice must not create duplicate entries in key_index.
    let data = vec![0xABu8; 1024];
            .join(key_index_store::KEY_INDEX_FILENAME)
    }
    let removed_count_before = cache
            0,
    }
        // persist_interval=1s: task should fire within ~2s of a put().
fn evict_prefix_removes_all_ranges_for_file() {
// ── foyer_snapshot_stats tests ───────────────────────────────────────────────
            appeared,
/// GS-03 / GS-04: verify key_index.json content is valid JSON with correct version and index.
    cache.put(&key, Bytes::copy_from_slice(&data));
    // Latest value must be readable.
            IO_ENGINE,
    put_range(&cache, "/data/target.parquet", 0, 100, b"target");
            .collect();
    let used_bytes_before = cache
        Some(Bytes::from_static(b"new"))
    let key = range_cache_key("/data/file.parquet", 0, 512);
            .join(key_index_store::KEY_INDEX_TMP_FILENAME)
            BLOCK_SIZE as u64,
    }
            json.as_bytes(),
        cache.should_skip_sweep(),
    let (cache, _dir) = test_cache();
    put_range(&cache, "/data/other.parquet", 0, 100, b"other");
    );
    assert_eq!(
// ── Shutdown / CancellationToken tests ───────────────────────────────────────
            .insert(key.to_string());
}
    );
/// Using a single shared runtime for all test `block_on()` calls reduces the total runtime
    );
        .unwrap_or(0);
fn get_returns_exact_bytes_that_were_put() {
    );
/// PP-06: persist disabled when interval=0 — no persist task spawned.
            .exists(),
    assert_eq!(
    assert!(cache.key_index.is_empty());
    let ptr = unsafe {
    cache.put(&key, Bytes::from_static(b"version_2"));
        0,
            mtime_after > mtime_before,
    assert_eq!(
    assert!(
/// `BlockCache::put_metadata` default, which routes to put() — so warmup's
    assert!(ptr > 0);
    // ── Verify isolation ─────────────────────────────────────────────
    // usage = 0% → below 75% → skip
    assert!(
    drop(g2);
}
            "/data/nodes/0/shard2.parquet",
        TEST_BUFFER_POOL_SIZE,
    assert_eq!(
    for _ in 0..shard_count {
    let (cache, _dir) = test_cache();
}
        removed_bytes_before + 300,
            .iter()
        // Drop writes key_index.json.
    // Use a large interval so the task never actually fires during the test.
            .map(|k| crate::range_cache::key_byte_size(k))
    assert_eq!(
fn sweep_cursor_eviction_bytes_correctly_tracked() {
fn sweep_once_ignores_threshold_guard() {
    assert!(cache2.key_index.contains_key("data/shard2/file.parquet"));
        0,
    tiered.put_metadata(&small_key, Bytes::from(vec![0xCD; 1024])); // 1KB <= 2KB → cached
    assert_eq!(result.as_ref().map(|b| b.len()), Some(512));
/// Metadata hit does not touch data cache SSD.
        .get("data/file.parquet")
        TEST_CACHE_DISK_BYTES,
        .load(std::sync::atomic::Ordering::Relaxed);
    );
/// own contribution when dropped.
    // ── Query: metadata reads → hit (metadata cache probed first) ────
}
    let path = "seg0/_0.parquet";
    // Two fake keys: 0-100 (100 bytes) and 100-200 (100 bytes) = 200 bytes total.
        .key_index
        // Evict one prefix — changes used_bytes so next tick must persist.
    assert_eq!(
        "corrupt snapshot must produce empty key_index"
#[test]
        .key_index
    let dir = TempDir::new().unwrap();
        TEST_CACHE_DISK_BYTES,
///
    let dir = TempDir::new().unwrap();
        used_before > 0,
/// the closure panics, `catch_unwind` returns `Err`, and the cache stays usable.
    // Shard 0 must be clean.
    let dir = TempDir::new().unwrap();
fn get_returns_none_for_unknown_key() {
        cache
        .stats
    );
    let ptr = unsafe {
}
        .key_index
    // agree — this keeps used_bytes accounting consistent between put() and evict_prefix().
    );
        512 * 1024,
/// The guard increments the counter on construction and decrements it on drop.
fn ffm_snapshot_stats_null_ptr_returns_error() {
fn sweep_once_on_empty_cache_is_noop() {
    let cache = Arc::new(cache);
/// used_bytes is initialized from the snapshot on recovery.
        eviction_bytes_before + 1,
    );
    assert_eq!(
        .eviction_bytes
    );
    );
    assert!(
        tiered.data_cache().stats.miss_count.load(Ordering::Relaxed),
/// - No panic or deadlock under concurrent load.
}
}
    );
        {
    drop(cache); // shutdown.cancel() wakes the select! branch → task exits
/// Graceful restart: key_index is persisted on Drop and bulk-loaded on the next
        "file must exist before clear"
        let keys: HashSet<String> = (0..KEYS_PER_PREFIX)
    let key = range_cache_key("seg0/_0.parquet", 0, 4096);
    );
            std::fs::read_to_string(dir.path().join(key_index_store::KEY_INDEX_FILENAME)).unwrap();
        put_range(&cache, "/data/shard2/file.parquet", 0, 512, &vec![0u8; 512]);
        .removed_count
        "/data/watchdog_test.parquet",
        let byte_size: i64 = keys
    // 10 fields × 2 sections = 20 longs
    let cache = FoyerCache::new(
        put_range(&cache, "/data/a.parquet", 0, 512, &vec![0u8; 512]);
        let mtime_before = std::fs::metadata(dir.path().join(key_index_store::KEY_INDEX_FILENAME))
fn evict_prefix_updates_removed_bytes_and_used_bytes() {
        !dir.path()
            .collect();
        .stats
        let prefix = format!("data/nodes/0/shard_{p:04}/segment.parquet");
    assert!(cache.key_index.is_empty());
        "key_index must be intact after simulated panic"
    assert_eq!(removed, 2);
        TEST_SUBMIT_QUEUE_SIZE,
                .unwrap();
    let (cache, _dir) = test_cache();
        "stale key must have been removed"
    key_index_store::save(dir.path(), &dash).unwrap();
    // If a sweep task were running it might prune entries, but since sweep=0
            false,
    put_range(&cache, "/data/target.parquet", 0, 4096, b"range0");
        cache
    assert!(
#[test]
/// Populate 10k entries directly into the key_index (simulating cache puts),
    {
    let (cache, _dir) = test_cache(); // sweep_interval_secs=0
    let key = range_cache_key("seg0/_0.parquet", 8_000_000, 8_500_000);
    assert_eq!(
    tiered.put_metadata(&s1, Bytes::from_static(b"shard1"));
    assert_eq!(rc, 0);
    // disk = 4MB, threshold = 0.75 (75%)
        !dir.path()
        0,
        .removed_bytes
    let raw = cache
    cache
                break false;
}
    assert_eq!(
        dir.path(),
            counter.load(std::sync::atomic::Ordering::Relaxed),
    let cache = FoyerCache::new(
    let g3 = ActiveBytesGuard::new(&counter, 300);
    assert_eq!(
    // we need to inject keys that Foyer will not have recovered.
/// persisted snapshot and therefore must NOT be loaded on the next startup.
#[test]
        cache
            .load(std::sync::atomic::Ordering::Relaxed),
        unsafe {
    let writer = std::thread::spawn(move || {
    let (cache, _dir) = test_cache();
    assert!(
        0,
        0,
#[test]
        .entry("data/f.parquet".to_string())
        !dir.path()
                .unwrap()
    assert_eq!(result.as_deref(), Some(b"version_2".as_slice()));
    // used_bytes grows monotonically: v2 was added on top of v1 (no reliable subtraction).
    );
        let prefix = format!("data/nodes/0/shard_{p:04}/segment.parquet");
        "key_index must be empty after simulated crash with no prior snapshot"
        Some(b"old_footer".as_slice())
    });
        .join(crate::key_index_store::KEY_INDEX_FILENAME)
#[test]
        put_range(&cache, "/data/file.parquet", 0, 100, &vec![0u8; 100]);
/// Simulates exactly what the persist task does when `key_index_store::save` panics.
            .load(std::sync::atomic::Ordering::Relaxed),
        if std::time::Instant::now() >= deadline {
                .join(key_index_store::KEY_INDEX_FILENAME)
fn ffm_create_with_invalid_utf8_returns_error() {
use crate::range_cache::range_cache_key;
        BLOCK_SIZE,
        .used_bytes
        .load(std::sync::atomic::Ordering::Relaxed);
#[test]
            .load(std::sync::atomic::Ordering::Relaxed),
            .stats
    let data = b"hello foyer cache";
    let key = range_cache_key("/data/never_inserted.parquet", 0, 512);
/// metadata is never written, bounding memory for pathological (wide-schema) files.
        false,
        std::thread::sleep(std::time::Duration::from_millis(2000));
fn tiered_test_cache() -> (TieredBlockCache, TempDir, TempDir) {
        "key_index must be empty after clear"
    );
    let dir = TempDir::new().unwrap();
        total_keys, expected_total,
    // Run enough sweeps to cover all shards.
/// put_metadata still lands in the one cache. Dispatched via `&dyn BlockCache`
        "used_bytes must decrease by 300 after eviction"
// to disk every `persist_interval_secs` seconds when `used_bytes` has changed.
        Some(b"footer".as_slice()),
fn persist_task_does_not_fire_when_cache_idle() {
    let col_idx_key = range_cache_key("seg0/_0.parquet", 8000000, 8500000);
fn active_bytes_guard_increments_and_decrements() {
        TEST_SUBMIT_QUEUE_SIZE,
#[test]
    let footer_key = range_cache_key("seg0/_0.parquet", 9990000, 10000000);
    assert!(cache.key_index.contains_key("data/file.parquet"));
}
    shards[0].write().insert(
                .exists()
/// parallel test execution practical.
    // evict_prefix() must update removed_bytes and decrement used_bytes via key_byte_size().
    );
        removed_count_before + 2,
    assert_eq!(
        IO_ENGINE,
    //
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
        512 * 1024,
        .or_default()
    let dir = TempDir::new().unwrap();
        "threshold=0.0: should never skip even when cache is empty"
// These tests build a 10k-entry key_index in-process (no OS cluster, no fd pressure).
        let mtime_before =
    );
        6,
use crate::foyer::ffm::{foyer_create_cache, foyer_destroy_cache};
        "shard 0 must be empty after sweep"
        assert!(
    );
        "footer must hit"
        dir.path(),
    assert!(result.is_err(), "catch_unwind must catch the save panic");
    assert!(ptr > 0);
 * this file be licensed under the Apache-2.0 license or a
    let exact = ((TEST_CACHE_DISK_BYTES as f64 * 0.75) as i64);
        let snap = key_index_store::KeyIndexSnapshot { version: 1, index };
        .stats
/// PP-01 / PP-06: persist task starts when interval > 0 and is absent when interval = 0.
            IO_ENGINE,
    // The background sweeper handles truly-gone disk entries via inner.contains().
    assert_eq!(
        let prefix = format!("data/nodes/0/shard_{p:04}/segment.parquet");
    );
            0.0,
            TEST_BUFFER_POOL_SIZE,
            0,
    let used_before = cache
        let cache = FoyerCache::new(
        .store(0, std::sync::atomic::Ordering::Relaxed);
            .join(crate::key_index_store::KEY_INDEX_FILENAME)
#[test]
        cache
            .load(std::sync::atomic::Ordering::Relaxed),
fn snapshot_stats_returns_error_for_invalid_ptr() {
        TEST_BUFFER_POOL_SIZE,
        TEST_SUBMIT_QUEUE_SIZE,
        TEST_BUFFER_POOL_SIZE,
        ("data/gamma.parquet", "data/gamma.parquet\x1F0-300"),
        .stats
        cache.evict_prefix("/data/evicted.parquet");
        assert!(
#[test]
        block_on(tiered.get(&data_key)).is_none(),
}
            .used_bytes
fn sweep_cursor_removes_stale_but_preserves_live_keys_in_same_prefix() {
fn sweep_task_catch_unwind_does_not_kill_loop_on_panic() {
    let writer_cache = Arc::clone(&cache);
        "usage=0% < threshold=75%: sweep must be skipped"
    );
            false,
    {
            0,
            .load(std::sync::atomic::Ordering::Relaxed),
#[test]
#[test]
/// The CancellationToken.cancel() call in Drop is safe even when no task holds
/// so the first persist tick MUST fire and update the snapshot mtime.
    );
    assert_eq!(
        0,
        false,
    );
    );
            0,
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
fn replace_event_key_index_retains_entry() {
#[test]
/// internally delegates to it.
    use std::sync::atomic::AtomicI64;
            BLOCK_SIZE as u64,
/// Each sweep_once() processes exactly one shard and advances the cursor.
        cache.put(&key, Bytes::copy_from_slice(&chunk));
    cache
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
    assert!(
            0,
    tiered.put_metadata(
        // Poll for key_index.json to appear (written by the persist task, not Drop).
    // Also inject a fake stale key.
        block_on(cache.get(&range_cache_key("/data/b.parquet", 0, 100))).as_deref(),
            TEST_SUBMIT_QUEUE_SIZE,
/// - The cache remains usable after all concurrent activity finishes.
    let ptr = unsafe {
    assert!(!cache.key_index.contains_key("data/target.parquet"));
    for _ in 0..shard_count {
/// under a read lock, releases all locks, then removes them. A `put()` that runs between
            dir_str.as_ptr(),
        .stats
        );
            .load(std::sync::atomic::Ordering::Relaxed),
    // Bulk-loaded snapshot has the stale key — used_bytes is temporarily over-counted.
    let shard_count = cache.key_index.shards().len();
    );
    );
    {
        foyer_create_cache(
    put_range(&cache, "/data/file.parquet", 100, 200, b"more");
        block_on(cache.clear());
}
    // Put an entry so used_bytes becomes non-zero, then confirm sections match.
        0,
            TEST_BUFFER_POOL_SIZE,
        TEST_SUBMIT_QUEUE_SIZE,
        false,
    cache
    // per call, so we need N calls to cover all shards exactly once.
    tiered.put_metadata(&col_idx_key, Bytes::from(vec![0xC; 500_000]));
        Some(b"col_a_data".as_slice())
    let cache = FoyerCache::new(
use crate::foyer::ffm::foyer_snapshot_stats;
    assert_eq!(removed, 1, "only the stale key in shard 0 must be removed");
            {
    cache.sweep_once(); // processes shard (shard_count - 1), cursor becomes shard_count
    // key_index.json does NOT exist yet (no periodic persist, Drop not called).
    let g2 = ActiveBytesGuard::new(&counter, 200);
#[test]
            .exists()
        data_hits_before
            IO_ENGINE,
        "used_bytes should be 1024 after a single 1KB put"
/// - Disk: 4 MB — small enough to keep parallel test disk I/O fast (~64× faster
        shard_count
    );
    let total_keys: usize = loaded.index.values().map(|v| v.len()).sum();
        .stats
fn put_and_get_work_after_cache_nears_capacity() {
        IO_ENGINE,
    };
        TEST_CACHE_BLOCK_SIZE,
        unsafe {
    let (cache, _dir) = test_cache();
            "persist task must fire on first tick after recovery (last_persisted=MIN != recovered used_bytes)"
        .key_index
    assert!(block_on(cache.get(&range_cache_key("/data/target.parquet", 0, 100))).is_none());
fn sweep_cursor_cache_remains_functional_after_sweep() {
            .stats
        Bytes::from_static(b"data"),
    TEST_RUNTIME
            .used_bytes
        put_range(&cache, "/data/shard1/file.parquet", 0, 512, &vec![0u8; 512]);
fn tiered_cache_clear_empties_both_tiers() {
        block_on(cache.get(&range_cache_key("/data/file.parquet", 0, 100))).as_deref(),
    );
    }
            16 * 1024 * 1024,
        snap[6], 1024,
        .key_index
        .key_index
            .unwrap()
        "eviction_bytes must not change for malformed (size=0) key"
        // Record mtime written by Drop of session 1.
        "stale_shard1".to_string(),
            128 * 1024 * 1024,
        TEST_SUBMIT_QUEUE_SIZE,
    let cache_trait: Arc<dyn crate::traits::BlockCache> = std::sync::Arc::new(cache);
    {
    let mut buf = [i64::MIN; 20];
    );
        .removed_count
    let eviction_bytes_before = cache
        0,   // no sweep task
fn sweep_once_processes_exactly_one_shard() {
        TEST_CACHE_BLOCK_SIZE,
    );
    // "data/f.parquet\x1F100-300" → 200 bytes
            TEST_CACHE_DISK_BYTES,
        128 * 1024 * 1024,
/// `evict_prefix()` doc comment.
            .key_index
            TEST_BUFFER_POOL_SIZE,
    assert_eq!(
        .used_bytes
        .exists());
        0.0,
    let removed_count_after = cache
    writer.join().expect("writer panicked");
            64 * 1024 * 1024,
            .exists(),
            TEST_CACHE_DISK_BYTES,
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
}
    let cache = FoyerCache::new(
#[test]
        let _guard = ActiveBytesGuard::new(&counter, 0);
        0
        "used_bytes must decrease by 300 when stale keys are swept"
    );
/// The sweep task holds a cloned CancellationToken; cancel() unblocks it from
    // Persist first so there's a file to delete.
fn tiered_cache_put_metadata_routes_to_metadata_cache() {
        .load(std::sync::atomic::Ordering::Relaxed);
///
#[test]
    let cache = FoyerCache::new(
        // Verify the content is valid (not just an empty file).
}
        cache.should_skip_sweep(),
    tiered.update_max_data_entry_size(8192);
    // and reset used_bytes to 0, mirroring FileCache.clear() recordRemoval semantics.
        "eviction_bytes must reflect 100 + 200 = 300 bytes for the two stale keys"
    assert_eq!(
#[test]
            TEST_CACHE_BLOCK_SIZE,
                .unwrap();
    );
        if count >= TOTAL_WRITES || std::time::Instant::now() >= deadline {
    assert!(
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
        "new put after sweep must be retrievable"
        dir.path(),
    // Writer: continuously caches new ranges under the same prefix.
/// Verify that the persist task with the watchdog outer loop stops cleanly
/// parses cleanly, and contains every prefix that was inserted.
}
            .active_in_bytes
            0.0_f64,
            .used_bytes
/// when the cancellation token fires. Waits for at least one persist to happen.
#[test]
            std::thread::sleep(std::time::Duration::from_millis(100));
        // Wait 2s for the first persist tick.
            .load(std::sync::atomic::Ordering::Relaxed),
#[test]
        for i in 0u64..100 {
#[test]
    assert!(block_on(tiered.data_cache().get(&footer_key)).is_none());
    let rc = unsafe { crate::foyer::ffm::foyer_snapshot_stats(ptr, std::ptr::null_mut()) };
            .exists(),
        "all 4 stale keys must be removed within shard_count sweep cycles"
    let boxed = unsafe { &*(ptr as *const Arc<dyn BlockCache>) };
    // Second put with same key (simulates cache stampede or re-put after eviction).
    assert_eq!(
    );
        .load(std::sync::atomic::Ordering::Relaxed);
        "counter must return to 0 after guard is dropped"
    cache.evict_prefix("/data/file.parquet");
    cache
    let cache = FoyerCache::new(
    assert_eq!(
/// A sweep of shard N must not modify shard N+1.
        put_range(&cache, "/data/f.parquet", 300, 600, &vec![0u8; 300]);
//
}
    let eviction_count_before = cache
        .store(almost_full, std::sync::atomic::Ordering::Relaxed);
/// early — the same code path the guard follows when a tokio::select! timeout
        .get("data/file.parquet")
        &cache,
    assert_eq!(
    // ── Warmup: put metadata explicitly ──────────────────────────────
            TEST_SUBMIT_QUEUE_SIZE,
        0,
    let (cache, _dir) = test_cache();
    let result = unsafe { foyer_snapshot_stats(0, buf.as_mut_ptr()) };
}
        TEST_CACHE_BLOCK_SIZE,
    );
        removed, 0,
        !cache.key_index.contains_key("data/bad.parquet"),
        Some(2_000_000)
            0,
    assert_eq!(
            BLOCK_SIZE as u64,
        "key_index.json must not exist before Drop"
        put_range(&cache, "/data/evicted.parquet", 0, 512, &vec![0u8; 512]);
        TEST_CACHE_DISK_BYTES,
        // Drop persists.
    assert_eq!(
        TEST_CACHE_BLOCK_SIZE,
            TEST_CACHE_DISK_BYTES,
    let result = block_on(cache.get(&key));
        // persist_interval=0: only Drop persists.
        used_bytes_before - 200,
        result.is_none(),
        .stats
        for _ in 0..50 {
        IO_ENGINE,
        .get("data/mixed.parquet")
/// Threshold of 1.0 means "only sweep when cache is 100% full" — any usage below
            .map(|k| format!("{prefix}\x1F{}-{}", k * 4096, (k + 1) * 4096))
        std::thread::sleep(std::time::Duration::from_millis(2000));
}
            BLOCK_SIZE as u64,
        }
    assert_eq!(result.as_deref(), Some(b"fresh".as_slice()));
    let dir = TempDir::new().unwrap();
    let path = "seg0/_0.parquet";
        dir.path(),
    let mut buf = [0i64; 14];
    let shard3 = Arc::clone(boxed);
#[test]
        false,
    let almost_full = ((TEST_CACHE_DISK_BYTES as f64 * 0.999) as i64);
    );
    let used_after = cache
            .used_bytes
    put_range(
    let s0 = range_cache_key("seg0/_0.parquet", 9000, 10000);
    // used_bytes = 0 (empty cache)
    let col_idx_key = range_cache_key(path, 8_000_000, 8_500_000);
    );
    // After clear() the key_index.json is deleted; Drop will write an empty one.
/// 2. Query: DataFusion reads metadata → hit from metadata cache (probed first)
        cache.should_skip_sweep(),
        removed, 1,
        .entry("data/gone.parquet".to_string())
        .stats
            .unwrap_or(false),
    let destroy_rc = unsafe { foyer_destroy_cache(ptr) };
        0,
            (BLOCK_SIZE * 2) as u64,
/// Must be kept in sync: block_size (BLOCK_SIZE) ≤ disk_bytes (any test using this constant).
/// Verifies that key_index.json is written by the periodic task (not just by Drop)
    let dir = TempDir::new().unwrap();
fn block_on<F: std::future::Future>(f: F) -> F::Output {
    // Verify foyer_snapshot_stats returns < 0 when out pointer is null.
// ── TieredBlockCache tests ──────────────────────────────────────────────────────
        IO_ENGINE,
    // Inject a fake key that Foyer has never seen — inner.contains() will return false.
        shards_with_entries,
    // Both sections are identical (single-tier: overall mirrors block_level).
        false,
    tiered.put_metadata(&footer_key, Bytes::from(vec![0xF; 10_000]));
    let small_key = range_cache_key("seg0/_0.parquet", 0, 1024);
fn sweep_once_stale_key_with_malformed_range_does_not_panic() {
/// is sleeping in tokio::select!.
            TEST_CACHE_DISK_BYTES,
        let keys: HashSet<String> = (0..KEYS_PER_PREFIX)
            0,
            false,
            let key = range_cache_key("/data/file.parquet", i * 100, (i + 1) * 100);
#[test]
            IO_ENGINE,
        .removed_count
/// After all threads finish, key_index must contain exactly 1 entry for the key,
        true,
#[test]
    assert_eq!(
    );
            engine.len() as u64,
    );
        TEST_BUFFER_POOL_SIZE,
/// Foyer only stores one entry. With HashSet, the second insert returns false and
    let counter = AtomicI64::new(0);
        .used_bytes
// These tests exercise the independent persist task that flushes the key_index
        cache
    assert!(
        )
        // Wait for the first persist (sentinel → current triggers it).
    assert_eq!(
    assert_eq!(destroy_rc, 0);
    // Inject a fake key into key_index that doesn't exist in Foyer's disk index.
/// PP-05: persist fires after evict_prefix() because used_bytes changes.
        0,
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
    use std::collections::HashSet;
        "data tier must be empty after clear_sync()"
/// Build a 10k-entry snapshot, write it to disk, then create a new FoyerCache
        "foyer_snapshot_stats with null out should return < 0, got {rc}"
            i % 16,
        std::thread::sleep(std::time::Duration::from_millis(2500));
}
            "/data/nodes/0/shard1.parquet",
    );
    );
    let r1 = block_on(cache.get(&range_cache_key("/data/keep.parquet", 0, 512)));
            .stats
        let result = block_on(cache.get(&key));
        .entry("data/bad.parquet".to_string())
            .map(|k| format!("{prefix}\x1F{}-{}", k * 4096, (k + 1) * 4096))
        block_on(dyn_cache.get(&key)).as_deref(),
            0.0_f64,
    }
    use std::collections::HashSet;
        &range_cache_key(path, 0, 1000000),
}
    put_range(&cache, "/data/a.parquet", 8192, 12288, b"range2");
            engine.as_ptr(),
    // overwrite time. With memory(1), this is near-zero frequency — entries are already
/// used_bytes must not be double-counted when the same key is put twice.
        meta_dir.path(),
}
        );
        "metadata entry within the limit must be cached"
        ".key_index.json.tmp must not exist after graceful shutdown"
    // Cache is still usable.
    assert_eq!(result.as_deref(), Some(b"updated".as_slice()));
    let key = range_cache_key("/data/shard.parquet", 999_000, 999_100);
                BLOCK_SIZE as u64,
    let path = dir.path().join(key_index_store::KEY_INDEX_FILENAME);
            engine.len() as u64,
        IO_ENGINE,
    assert_eq!(
#[test]
        .exists();
    let used_bytes = cache
        NUM_PREFIXES / 2,
    let removed_before = cache
/// per-`FoyerCache` runtimes created by `FoyerCache::new()`. Each runtime spawns OS-level
        .path()
    }
    // Directly populate the key_index (bypasses actual Foyer disk, tests key_index logic only).
use crate::key_index_store;
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
            .load(std::sync::atomic::Ordering::Relaxed),
        .or_default()
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
    assert!(
        "key_index must contain exactly 1 entry after {} concurrent puts of the same key; got {}",
            dir_str.as_ptr(),
    // Manually write a snapshot with a mix of valid and fake stale keys.
    assert_eq!(
        );
    // usage = 74.9% → below 75% → skip
        .load(std::sync::atomic::Ordering::Relaxed);
}
                0.0_f64,
            .map(|k| format!("{prefix}\x1F{}-{}", k * 4096, (k + 1) * 4096))
        "cursor must start at 0"
            128,
            .stats
    cache.put(&key, Bytes::from(vec![0u8; 512]));
    );
    let dir = TempDir::new().unwrap();
        TEST_CACHE_BLOCK_SIZE,
    assert!(
    let dir = TempDir::new().unwrap();
    let cache = FoyerCache::new(
    assert!(block_on(cache.get(&range_cache_key("/data/file.parquet", 1, 100))).is_none());
        .map(|v| v.len())
            .stats
    tiered.update_max_data_entry_size(1024);
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
        .stats
#[test]
        TEST_SUBMIT_QUEUE_SIZE,
        0.0,
        )
        .sweep_cursor
        count
}
    let removed_bytes_before = cache
    tiered.put(
        IO_ENGINE,
        TEST_SUBMIT_QUEUE_SIZE,
    put_range(&cache, "/data/target.parquet", 4096, 8192, b"range1");
///
    let evictor_cache = Arc::clone(&cache);
/// This validates that the guard integrates correctly with the full cache.
        .key_index
        0,
        "threshold=0.0: should never skip even when cache is 100% full"
            false,
/// continues to function normally. We do not wait for the sweep to fire
        0,
const TEST_CACHE_DISK_BYTES: usize = 4 * 1024 * 1024; // 4 MB disk capacity
            BLOCK_SIZE as u64,
    // key_byte_size returns 0 for malformed key — eviction_bytes unchanged.
            .load(std::sync::atomic::Ordering::Relaxed),
}
        false,
        ("data/alpha.parquet", "data/alpha.parquet\x1F0-100"),
    );
        .used_bytes
            break;
    assert!(block_on(tiered.get(&key)).is_none());
        foyer_create_cache(
    let dir = TempDir::new().unwrap();
    let raw_ptr = Box::into_raw(boxed) as i64;
            "data/f.parquet\x1F100-300".to_string(),
    );
    // Build a cache with persist_interval=0 (no periodic persist either).
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
        // Wait 2 seconds — file must NOT appear (no persist task).
    assert_eq!(
            .modified()
    assert!(
fn recovery_evicted_prefix_not_persisted() {
    let dir_str = dir.path().to_str().unwrap();
        dir.path(),
    // Inject only fake keys for a prefix — no real entries.
        .removed_bytes
        path.exists(),
        TEST_CACHE_BLOCK_SIZE,
        true,
            .join(key_index_store::KEY_INDEX_FILENAME)
    let cache = FoyerCache::new(
    cache
    let (cache, _dir) = test_cache();
    );
        .load(std::sync::atomic::Ordering::Relaxed);
        }
        0.0,
    cache
        1, // 1-second persist interval
    let (cache, _dir) = test_cache();
        used_after_v2 >= used_after_v1,
            i * CHUNK_SIZE as u64,
        let result = unsafe { foyer_destroy_cache(ptr) };
    cache.evict_prefix("/data/file.parquet");
    }
fn large_value_round_trips_correctly() {
        .load(std::sync::atomic::Ordering::Relaxed);
        let cache = FoyerCache::new(
            TEST_CACHE_BLOCK_SIZE,
            0.0,
        .store(shard_count - 1, std::sync::atomic::Ordering::Relaxed);
    let cache = FoyerCache::new(
    let cache = FoyerCache::new(
            !dir.path()
        .or_default()
    std::mem::forget(cache);
            .get("data/mixed.parquet")
            .map(|v| v.contains(&stale_key))
fn evict_prefix_on_nonexistent_prefix_does_not_change_stats() {
    let engine = IO_ENGINE.as_bytes();
            0,   // sweep disabled
        .load(std::sync::atomic::Ordering::Relaxed);
use crate::traits::BlockCache;
            .fetch_add(byte_size, std::sync::atomic::Ordering::Relaxed);
/// - Block size: 1 MB — accommodates `large_value_round_trips_correctly` (≈976 KB
// They use real FoyerCache instances and TempDir.
        TEST_CACHE_DISK_BYTES,
        TEST_CACHE_DISK_BYTES as i64,
    let (cache, _dir) = test_cache();
        cache
        cache.key_index.contains_key("data/b.parquet"),
fn concurrent_puts_to_different_files_do_not_corrupt() {
    assert!(!cache.key_index.contains_key("data/file.parquet"));
        NUM_PREFIXES / 2
        "key_index.json must exist after session 1 Drop"
        dir.path(),
                engine.len() as u64,
    let r3 = block_on(cache.get(&range_cache_key("/data/new.parquet", 0, 256)));
    });
}
    }
        )
            0.0,
    assert!(block_on(tiered.metadata_cache().get(&small_key)).is_some());
        .store(5, std::sync::atomic::Ordering::Relaxed);
    let shard_count = cache.key_index.shards().len();
            .stats
        dir.path(),
        0,
        0.0,
    assert_eq!(result.as_deref(), Some(b"after".as_slice()));
}
    assert_eq!(
    assert!(
    let dir = TempDir::new().unwrap();
/// foyer_create_cache returns a fat Box<Arc<dyn BlockCache>> pointer.
#[test]
            .stats
        "persist task must have written key_index.json before drop"
    assert_eq!(
            )
        let prefix = format!("data/nodes/0/shard_{p:04}/segment.parquet");
    let (cache, _dir) = test_cache();
        dashmap::SharedValue::new({
    let shard_count = cache.key_index.shards().len();
        block_on(
/// Must satisfy: TEST_CACHE_BLOCK_SIZE ≤ TEST_CACHE_DISK_BYTES (Foyer invariant).
    for (prefix, key) in &stale_keys {
    // used_bytes: at most 1× the entry size. It may be less if the second-N puts
/// count from O(tests × calls) to O(tests) — one per `FoyerCache` plus this one — making
        // persist_interval=1s
    assert_eq!(
            false,
    drop(clone);
    assert_eq!(
    let data_key = range_cache_key(path, 0, 2_000_000);
            std::fs::metadata(dir.path().join(crate::key_index_store::KEY_INDEX_FILENAME))
    let key0 = "stale_shard0\x1F0-100".to_string();
    let shard_count = cache.key_index.shards().len();
    let result = block_on(cache.get(&fresh_key));
/// Multiple guards at the same time accumulate correctly and each restores its
        TEST_SUBMIT_QUEUE_SIZE,
        "used_bytes must decrease by 200"
/// Set cursor to shard 0. After one sweep_once(), shard 0 is clean but shard 1 is untouched.
    // Write an empty file.
        BLOCK_SIZE,
    // Tight bound → rejected.
        let deadline = std::time::Instant::now() + std::time::Duration::from_secs(5);
/// ST-04: no .tmp file exists on clean startup (fresh dir).
    // No i64::MIN values — the buffer was fully written.
    const NUM_PREFIXES: usize = 100;
    for _ in 0..3 {
#[test]
        removed_bytes_after,
    assert_eq!(rc, 0, "foyer_snapshot_stats should return 0 on success");
/// Scenario: cache stampede — two threads both miss for the same byte range and both
// ── Recovery / persistence integration tests ─────────────────────────────────
    );
    for i in 1usize..=16 {
        &vec![0u8; 512],
    // Put a real key so the prefix bucket exists.
}
    let fake_key = "data/file.parquet\x1F99999-100000".to_string();
                .metadata_cache()
        Some(512),
                .exists(),
/// Clean startup (no key_index.json) is a no-op: key_index starts empty,
    );
            dir.path(),
/// The file should NOT exist until Drop is called.
    let cache = FoyerCache::new(
    {
    // Inject a malformed stale key — no separator, Foyer has never seen it.
            "/data/nodes/0/shard1.parquet",
            0,
        TEST_CACHE_DISK_BYTES,
    let result = block_on(cache.get(&key));
        counter.load(std::sync::atomic::Ordering::Relaxed),
    let evictor = std::thread::spawn(move || {
    use crate::traits::BlockCache;
        0,
        .stats
/// concurrent sweeps and evictions) must be treated as 0 — no skip.
                0,
    let (cache, _dir) = test_cache();
}
    let deadline = std::time::Instant::now() + std::time::Duration::from_secs(5);
        Some(b"range1".as_slice())
    {
        );
/// Concurrent stampede: multiple threads put the same key simultaneously.
    for _ in 0..16 {
        used_bytes_before - 1,
    let (cache, _dir) = test_cache();
    assert!(block_on(tiered.metadata_cache().get(&footer_key)).is_some());
        );
/// expected outcome when a prefix is being deleted.
        .used_bytes
    );
/// which modulo shard_count == 0 (back to shard 0).
    // Foyer is currently disk-only (single tier): overall == block_level.
        false,
    let removed = cache.sweep_once();
    let total_keys: usize = cache.key_index.iter().map(|e| e.value().len()).sum();
    // Simulate 3 shards each cloning the Arc (as ts_create_tiered_object_store would).
fn active_bytes_guard_drop_on_cancellation_restores_counter() {
/*
        std::thread::sleep(std::time::Duration::from_millis(20));
            (BLOCK_SIZE * 2) as u64,
