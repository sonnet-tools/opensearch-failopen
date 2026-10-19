        TEST_SUBMIT_QUEUE_SIZE,
    assert_eq!(result.as_deref(), Some(data.as_slice()));
            .stats
/// - The cache remains usable after all concurrent activity finishes.
    cache.evict_prefix("");
/// return false regardless of current usage — the sweep is never skipped.
        .used_bytes
    // evict_prefix() must update removed_bytes and decrement used_bytes via key_byte_size().
/// concurrent sweeps and evictions) must be treated as 0 — no skip.
    let (cache, _dir) = test_cache();
        std::fs::write(
    let (cache, _dir) = test_cache();
    let used_bytes_after = cache
    let result = block_on(cache.get(&key)).expect("large value should be retrievable");
        dir.path(),
    );
        "metadata entry within the limit must be cached"
            })
    // usage = exactly 75% → NOT below → do NOT skip
    put_range(&cache, "/data/a.parquet", 0, 100, b"file_a");
        foyer_create_cache(
        .eviction_bytes
    assert!(block_on(tiered.metadata_cache().get(&data_key)).is_none());
    assert!(result.is_none());
    // usage = 0 → should_skip_sweep() is true (below 99% threshold)
    );
            BLOCK_SIZE as u64,
    );
        );
    // Verify it is reflected immediately (index 6 = used_bytes).
        TEST_CACHE_BLOCK_SIZE,
        // Wait for the first persist (sentinel → current triggers it).
    assert!(
        Some(1024),
    // ── S3 fetch → populate_cache → put() → data cache ──────────────
    assert!(result.is_some(), "cache must be usable after catch_unwind");
        "key_index must have {} buckets after evicting half",
#[test]
        TEST_BUFFER_POOL_SIZE,
        .stats
}
#[test]
fn ffm_snapshot_stats_null_out_returns_error() {
        );
        TEST_CACHE_DISK_BYTES,
    cache
    );
    assert!(!cache.key_index.contains_key("data/target.parquet"));
            false,
    let path = dir.path().join(key_index_store::KEY_INDEX_FILENAME);
        shard_count,
/// `lru_eviction_retains_keys_in_key_index`, etc.) create their own caches with
/// Verified indirectly: the key_index is not modified by any background activity
        TEST_CACHE_DISK_BYTES,
        cache.sweep_once();
            TEST_CACHE_DISK_BYTES,
        !dir.path()
            BLOCK_SIZE as u64,
    );
        let cache = FoyerCache::new(
        "key_index must be empty after clear()"
        !cache
            1,
#[test]
    // usage = exactly 100% → ratio = 1.0 = threshold → NOT below → do NOT skip
            BLOCK_SIZE as u64,
    assert!(result.is_err(), "catch_unwind must catch the save panic");
                .join(key_index_store::KEY_INDEX_FILENAME)
    );
    );
            std::thread::sleep(std::time::Duration::from_millis(100));
        {
        "dropping g1 (100) must leave 300"
    let dir = TempDir::new().unwrap();
    assert!(
            0,
    assert_eq!(
        IO_ENGINE,
        used_bytes_before - 1,
/// Verifies the byte-size accounting is accurate through the shard-based path.
    );
        assert!(
        "stale key must have been removed"
        true,
            .load(std::sync::atomic::Ordering::Relaxed),
    const ITERATIONS: u64 = 100;
        false,
        0,
    );
            .fetch_add(byte_size, std::sync::atomic::Ordering::Relaxed);
        false,
    assert!(
        .or_default()
        0,
        2048,
    let key = range_cache_key("seg0/_0.parquet", 9990000, 10000000);
    cache
            TEST_CACHE_DISK_BYTES,
            dir.path(),
        eviction_bytes_after_2, 0,
        block_on(tiered.get(&key)).map(|b| b.len()),
            IO_ENGINE,
fn persist_task_last_persisted_reset_forces_persist_after_recovery() {
        "no stale entries expected immediately after put"
        "all 4 stale keys must be removed within shard_count sweep cycles"
    // shard1 should have 2 keys, shard2 should have 1.
    let result = block_on(cache.get(&fresh_key));
    // Write a 10k-entry snapshot.
}
        TEST_CACHE_BLOCK_SIZE,
        "put_metadata default must route to the single cache and be retrievable via get()"
        );
        "shard 0 must be empty after sweep"
        cache2.key_index.contains_key("data/kept.parquet"),
    let ptr = unsafe {
        let index = snap["index"].as_object().unwrap();
            TEST_BUFFER_POOL_SIZE,
        used_bytes_before - 200,
fn evict_prefix_removes_all_ranges_for_file() {
        0,
    // evict_prefix must still clean up correctly and increment removed_count.
    // No hang, no panic expected.
    // recovered used_bytes=100; last_persisted starts at i64::MIN.
    );
}
#[test]
            TEST_BUFFER_POOL_SIZE,
        "real key must remain in key_index after sweep"
        0.0,
    );
    for _ in 0..3 {
            0,
        .load(std::sync::atomic::Ordering::Relaxed);
        removed_bytes,
        rc < 0,
    std::thread::sleep(std::time::Duration::from_millis(100));
}
    let footer_key = range_cache_key("seg0/_0.parquet", 9990000, 10000000);
}
    // Put a real key so the prefix bucket exists.
        assert_eq!(
    assert!(
fn persist_task_writes_snapshot_within_interval() {
        cache.key_index.insert(prefix, keys);
    // First tick: i64::MIN != 100 → persist fires → mtime advances.
    let used_after = cache
    assert!(block_on(tiered.data_cache().get(&data_key)).is_some());
    assert_eq!(
    assert!(
fn key_index_is_empty_after_clear() {
/// We simulate this by constructing an ActiveBytesGuard directly and dropping it
    let dir = TempDir::new().unwrap();
#[test]
        TEST_SUBMIT_QUEUE_SIZE,
///
            TEST_BUFFER_POOL_SIZE,
        dir.path(),
    let (cache, _dir) = test_cache();
            false,
        foyer_create_cache(
        cache3.key_index.is_empty(),
    );
        TEST_BUFFER_POOL_SIZE,
            .iter()
    let writer_cache = Arc::clone(&cache);
        std::thread::sleep(std::time::Duration::from_millis(100));
        );
        "oversized metadata must not reach the metadata tier"
            0,
        dir.path(),
    );
}
        0.0,
    put_range(
        .load(std::sync::atomic::Ordering::Relaxed);
#[test]
    cache
fn block_on<F: std::future::Future>(f: F) -> F::Output {
        )
        0,
        .collect();
        0,
        // Drop calls save() — writes key_index.json
            .exists(),
        BLOCK_SIZE * 2,
            IO_ENGINE,
    let ptr = unsafe {
    assert_eq!(
        "used_bytes must return to 0 after evicting all entries"
    assert_eq!(
        }
        cache.should_skip_sweep(),
}
        .removed_count
/// Foyer only stores one entry. With HashSet, the second insert returns false and
        "stale key must be present immediately after bulk-load recovery"
    let shard_count = cache.key_index.shards().len();
        IO_ENGINE,
    const THREAD_COUNT: usize = 8;
            std::thread::sleep(std::time::Duration::from_millis(100));
        "stale_shard0".to_string(),
            TEST_CACHE_DISK_BYTES,
                .unwrap();
        block_on(cache.get(&range_cache_key("/data/a.parquet", 0, 100))).as_deref(),
    );
    let a_count = cache2
        0.0,
        .key_index
/// metadata is never written, bounding memory for pathological (wide-schema) files.
        cache
#[test]
            writer_cache.put(&key, Bytes::from_static(b"data"));
            dir_str.as_ptr(),
}
    let guard = ActiveBytesGuard::new(&counter, 4096);
        cache
///
    };
    );
        TEST_BUFFER_POOL_SIZE,
fn sweep_once_does_not_touch_other_shards() {
    }
            .unwrap();
    let ptr = unsafe {
        let cache = FoyerCache::new(
        "key_index must be intact after simulated panic"
            out[i], 0,
        .map(|v| v.len())
    let (cache, _dir) = test_cache();
            false,
            tiered
    assert_eq!(
    let fake_key = "data/file.parquet\x1F99999-100000".to_string();
    assert_eq!(
        .used_bytes
    assert!(
        0.0,
        dir.path(),
    assert!(
        dashmap::SharedValue::new({
    assert_eq!(Arc::strong_count(boxed), 1, "only the box remains");
    let (cache, _dir) = test_cache();
            128,
    // Build a cache with persist_interval=0 (no periodic persist either).
}
        eviction_bytes_before + 1,
                BLOCK_SIZE as u64,
        .removed_count
    let (cache, _dir) = test_cache();
        );
            .load(std::sync::atomic::Ordering::Relaxed),
            TEST_SUBMIT_QUEUE_SIZE,
        0,
        .load(std::sync::atomic::Ordering::Relaxed);
        0
            dir_str.len() as u64,
// ── Duplicate key / HashSet deduplication tests ───────────────────────────────
        TEST_CACHE_DISK_BYTES,
}
    while !dir
        let cache = FoyerCache::new(
}
    );
        .get("data/file.parquet")
fn tiered_cache_put_skips_oversized_data_entry() {
        .eviction_count
        TEST_SUBMIT_QUEUE_SIZE,
            .load(std::sync::atomic::Ordering::Relaxed),
    let _box = unsafe { Box::from_raw(ptr as *mut Arc<dyn BlockCache>) };
    let writer = std::thread::spawn(move || {
    );
    // Sweeper should remove it, increment eviction_count, update eviction_bytes, and
    // Sections 0 and 1 are identical (Foyer is currently single-tier).
        .used_bytes
        removed_before
    // raced and all returned false from HashSet::insert, but never more than 1×.
        .removed_count
    assert!(cache2.key_index.contains_key("data/shard2/file.parquet"));
    // Put two real entries.
        TEST_BUFFER_POOL_SIZE,
            "/data/nodes/0/shard1.parquet",
    );
        "data/a.parquet must be in key_index after recovery"
        foyer_create_cache(
    for p in 0..NUM_PREFIXES {
fn clear_on_empty_cache_does_not_change_removed_stats() {
/// Inject a stale key into shard 0 and a different stale key into shard 1.
fn ffm_create_destroy_lifecycle_no_leak() {
        dir.path(),
            256,
    (tiered, data_dir, meta_dir)
    );
    let key = range_cache_key("/data/file.parquet", 0, 100);
//
        );
    assert_eq!(
    let dir = TempDir::new().unwrap();
#[test]
}
        0.0,
    let cache = FoyerCache::new(
    );
    let engine = IO_ENGINE.as_bytes();
        TEST_SUBMIT_QUEUE_SIZE,
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
    // overwrite time. With memory(1), this is near-zero frequency — entries are already
        .used_bytes
    );
        IO_ENGINE,
    cache.put(&key, Bytes::copy_from_slice(&data));
            .exists()
/// The cursor wraps correctly at the shard count boundary.
        .stats
        used_after,
        false,
    });
    tiered.put(
    );
        let prefix = format!("data/nodes/0/shard_{p:04}/segment.parquet");
    // With HashSet key_index, putting the same key twice must result in exactly 1 entry
/// After a cursor-based sweep that removes stale keys, the cache must still
        assert_eq!(mtime_after_first, mtime_after_idle,
    // Panic must be caught — not propagated.
/// A sweep of shard N must not modify shard N+1.
        .load(std::sync::atomic::Ordering::Relaxed);
    tiered.put_metadata(
// ── concurrent access ─────────────────────────────────────────────────────────
        ".key_index.json.tmp must not exist after graceful shutdown (rename completed)"
        cache
        0,
    cache.stats.used_bytes.store(
/// Concurrent stampede: multiple threads put the same key simultaneously.
/// Putting the same key twice must not create duplicate entries in key_index.
    );
    assert_eq!(parsed["version"], 1, "version must be 1");
fn active_bytes_guard_increments_and_decrements() {
    // All threads race to put the same key — simulates a cache stampede after a miss.
        drop(cache2);
#[test]
        put_range(&cache, "/data/evict_me.parquet", 0, 512, &vec![0u8; 512]);
    let dir = TempDir::new().unwrap();
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
            .load(std::sync::atomic::Ordering::Relaxed),
            TEST_CACHE_DISK_BYTES,
    assert_eq!(destroy_rc, 0);
        TEST_SUBMIT_QUEUE_SIZE,
    let cache = FoyerCache::new(
        rc < 0,
fn event_remove_after_evict_prefix_does_not_panic_or_corrupt_key_index() {
        dir.path(),
        .or_default()
    // No i64::MIN values — the buffer was fully written.
        .stats
    // ── Query 2: same data → hit from data cache ─────────────────────
    // After get() completes: guard has been dropped, counter back to 0.
        result.is_none(),
    );
        block_on(tiered.get(&footer_key)).is_some(),
    let dir = TempDir::new().unwrap();
    tiered.clear_sync();
        "dropping g2 (200) must leave 100+300=400"
    let shard_count = cache.key_index.shards().len();
        let result = block_on(cache.get(&key)).expect("entry should be retrievable");
    // Session 1: put data and let Drop write key_index.json.
const TEST_CACHE_DISK_BYTES: usize = 4 * 1024 * 1024; // 4 MB disk capacity
}
        IO_ENGINE,
        TEST_CACHE_DISK_BYTES,
            0,
    // Write entries into the first cache instance.
    let result = block_on(cache.get(&key));
        !dir.path()
    // guard dropped here
        "key_index must be empty after simulated crash with no prior snapshot"
        cache
    .unwrap();
            .or_default()
    let dir = TempDir::new().unwrap();
    let path = "seg0/_0.parquet";
    let key = range_cache_key("/data/file.parquet", 0, 1024);
            TEST_SUBMIT_QUEUE_SIZE,
    tiered.put(&data_key, Bytes::from(vec![0xAA; 2_000_000]));
fn ffm_create_with_invalid_utf8_returns_error() {
        "evicted prefix must not appear in recovered key_index"
    let result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
        "empty prefix bucket must be removed"
        IO_ENGINE,
    let engine = IO_ENGINE.as_bytes();
    assert_eq!(
fn key_index_has_no_entry_for_evicted_file() {
#[test]
    );
    evictor.join().expect("evictor panicked");
    // key_index must have exactly 1 entry for this key, not THREAD_COUNT.
#[test]
    let (cache, _dir) = test_cache();
    let shard1 = Arc::clone(boxed);
    // used_bytes: at most 1× the entry size. It may be less if the second-N puts
        used, 600,
        eviction_bytes_before + 200,
    let engine = IO_ENGINE.as_bytes();
#[test]
    );
        .expect("index must be a JSON object");
        .eviction_bytes
#[test]
        cache.sweep_once();
            0.0_f64,
    );
        IO_ENGINE,
    );
        for _ in 0..ITERATIONS {
            .stats
            .collect();
        let key = range_cache_key("/data/file.parquet", 0, 100);
    drop(shard1);
    );
    assert_eq!(removed, 1, "sweep must remove the 1 stale key");
///
            if std::time::Instant::now() >= deadline {
                s
        Some(b"range2".as_slice())
fn sweep_cursor_wraps_at_shard_count() {
        )
    use std::collections::HashSet;
    assert_eq!(
    assert!(cache.key_index.contains_key("data/other.parquet"));
    std::thread::sleep(std::time::Duration::from_millis(100));
    assert!(
        "usage=0% < threshold=75%: sweep must be skipped"
/// foyer_snapshot_stats with null ptr returns negative.
            .join(key_index_store::KEY_INDEX_FILENAME)
        .unwrap();
        put_range(
    // Shard 0 must be clean.
    );
fn snapshot_stats_null_out_via_created_cache() {
    assert_eq!(
    let ptr = unsafe {
        !shards[1].read().is_empty(),
        .used_bytes
        TEST_CACHE_BLOCK_SIZE,
///
        .or_default()
    }
        }
        panic!("simulated reconcile_key_index panic");
    assert!(
    drop(cache);
#[test]
            .used_bytes
        "shard 1 must be untouched after sweeping shard 0"
    let data_dir = TempDir::new().expect("data temp dir");
            0,
    );
#[test]
#[test]
    );
            .sum();
        TEST_CACHE_DISK_BYTES,
    // Cache must remain fully usable after the concurrent activity.
        BLOCK_SIZE * 2,
            invalid_utf8.as_ptr(),
    let result = block_on(cache.get(&range_cache_key("/never/inserted.parquet", 0, 100)));
    assert!(
    let dash: DashMap<String, HashSet<String>> = DashMap::new();
    }
            .stats
    let dir = TempDir::new().unwrap();
}
    assert_eq!(
/// (idle cache). The sentinel `i64::MIN` forces the first tick to always persist,
    writer.join().expect("writer panicked");
        Some(b"col_a_data".as_slice())
    drop(shard2);
    use std::collections::HashSet;
            dir.path(),
        dir.path(),
    // Inject stale keys with known sizes:
        2 * 1024 * 1024,
        let prefix = format!("data/nodes/0/shard_{p:04}/segment.parquet");
    assert_eq!(
    // usage = 74.9% → below 75% → skip
    assert_eq!(
            .stats
/// The values at index 0 (overall hit_count) and index 7 (block_level hit_count) should
/// the configured bound (used by TieredObjectStore::get_opts to avoid buffering).
// ── evict_prefix ──────────────────────────────────────────────────────────────
    }
        let prefix = format!("data/nodes/0/shard_{p:04}/segment.parquet");
        0,
const TEST_BUFFER_POOL_SIZE: usize = 1 * 1024 * 1024; // 1 MB buffer pool (≥ block_size)
    // disk = 4MB, threshold = 0.75 (75%)
/// Scenario: cache stampede — two threads both miss for the same byte range and both
        0,
        .used_bytes
            TEST_CACHE_DISK_BYTES,
    );
    assert_eq!(
fn multiple_ranges_for_same_file_are_independent() {
        TEST_CACHE_DISK_BYTES,
        TEST_CACHE_DISK_BYTES,
        TEST_CACHE_DISK_BYTES,
        "key_index.json must exist after graceful shutdown"
fn evict_prefix_twice_is_safe() {
    );
        0,
        );
use crate::foyer::foyer_cache::FoyerCache;
        raw % shard_count,
        panic!("simulated key_index_store::save panic");
    let used_before = cache
            .map(|k| crate::range_cache::key_byte_size(k))
        TEST_CACHE_DISK_BYTES,
        .key_index
#[test]
            .modified()
    let dir = TempDir::new().unwrap();
    }
            TEST_SUBMIT_QUEUE_SIZE,
        TEST_CACHE_BLOCK_SIZE,
            .join(key_index_store::KEY_INDEX_FILENAME)
    );
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
        IO_ENGINE,
        let cache2 = FoyerCache::new(
}
    ];
        "file must exist before clear"
        TEST_CACHE_DISK_BYTES,
        .store(below, std::sync::atomic::Ordering::Relaxed);
    let dir = TempDir::new().unwrap();
    );
            IO_ENGINE,
    let cache = FoyerCache::new(
    // Assert it is absent while the cache is still alive (before Drop).
    // Run full sweep (16 cycles to guarantee coverage).
    let evictor = std::thread::spawn(move || {
    );
        dir.path(),
        512,
    // It does NOT mean the entry is gone — it is still alive on disk.
        .stats
}
    );
fn ffm_snapshot_stats_null_ptr_returns_error() {
#[test]
/// tokio::select! and it exits cleanly.
    assert_eq!(
}
    assert_eq!(result.as_ref(), data.as_slice());
        );
        assert_eq!(
    tiered.put_metadata(&small_key, Bytes::from(vec![0xCD; 1024])); // 1KB <= 2KB → cached
    // Second put of the same key — Foyer upserts the value, key_index is unchanged.
fn persist_task_fires_after_evict_prefix_changes_used_bytes() {
    assert!(
    assert_eq!(
    let eviction_bytes_before = cache
    assert_eq!(
            .stats
    assert!(cache.key_index.is_empty());
    let big_key = range_cache_key("seg0/_0.parquet", 0, 4096);
    tiered.put_metadata(&s0, Bytes::from_static(b"shard0"));
    assert_eq!(removed, 2);
    );
}
    let big_key = range_cache_key("seg0/_0.parquet", 0, 4096);
/// Block size and disk capacity for FFM/integration tests that need a large Foyer instance.
    assert_eq!(
    assert_eq!(
        0,
        TEST_SUBMIT_QUEUE_SIZE,
            .used_bytes
            mtime_after > mtime_before,
    assert!(block_on(cache.get(&range_cache_key("/data/file.parquet", 200, 300))).is_none());
                .join(key_index_store::KEY_INDEX_FILENAME)
    let rc = unsafe { crate::foyer::ffm::foyer_snapshot_stats(ptr, out.as_mut_ptr()) };
}
        assert!(
// ── get miss cases ────────────────────────────────────────────────────────────
            }
    // Count how many shards still have entries.
        let snap: serde_json::Value = serde_json::from_str(&contents).unwrap();
        .used_bytes
        TEST_CACHE_BLOCK_SIZE,
            0.0_f64,
        "key_index.json must not exist before Drop"
    };
            BLOCK_SIZE as u64,
            .eviction_count
    let cache = Arc::new(cache);
        cache.put(&key, Bytes::from_static(b"hello"));
    // Node-level close: destroy the original Box.
}
#[test]
    let result = unsafe { foyer_snapshot_stats(0, buf.as_mut_ptr()) };
        TEST_CACHE_DISK_BYTES,
        .store(above, std::sync::atomic::Ordering::Relaxed);
        "evict_prefix must remove recovered shard1 entries"
    let dir = TempDir::new().unwrap();
        false,
            (BLOCK_SIZE * 2) as u64,
        .map(|i| {
        BLOCK_SIZE,
    let engine = IO_ENGINE.as_bytes();
            dir.path(),
    // Set a high threshold so should_skip_sweep() returns true
    let key = range_cache_key("seg0/_0.parquet", 9990000, 10000000);
    );
            0.0,
        TEST_BUFFER_POOL_SIZE,
#[test]
        put_range(&cache, "/data/shard2/file.parquet", 0, 512, &vec![0u8; 512]);
    }
        let cache = FoyerCache::new(
            false,
    assert!(
        .unwrap_or(0);
    assert!(block_on(tiered.metadata_cache().get(&footer_key)).is_some());
        0.0,
        !dir.path()
            .unwrap()
    );
            if std::time::Instant::now() >= deadline {
            "persist task must NOT rewrite key_index.json when cache is idle (used_bytes unchanged)");
        .entry("data/bad.parquet".to_string())
}
    let mut out = [i64::MAX; 20];
            .key_index
        removed_after > removed_before,
        .key_index
    let result = block_on(tiered.get(&key));
    );
#[test]
    // Preset to shard 5.
    assert_eq!(a_count, 2, "data/a.parquet must have 2 keys");
    assert_eq!(
            BLOCK_SIZE as u64,
    let below = ((TEST_CACHE_DISK_BYTES as f64 * 0.749) as i64);
    assert_eq!(
///
    let cache = Arc::new(cache);
        .eviction_bytes
        0
    );
fn recovery_with_corrupt_snapshot_starts_empty() {
        .used_bytes
/// explicit sizes and are unaffected by these constants.
    // Two ranges: 0-100 = 100 bytes, 100-300 = 200 bytes → total 300 bytes.
        .entry("data/file.parquet".to_string())
/// Full DataFusion query simulation:
            0.0_f64,
// for both the sweep task and the persist task.
    let eviction_bytes_before = cache
        false,
    let cache = FoyerCache::new(
        0.0,
}
        .unwrap_or(0);
            .get("data/mixed.parquet")
        assert!(
/// Inject one stale key per shard (using raw shard access). After a single sweep_once()
            0,
fn evict_prefix_on_nonexistent_prefix_is_noop() {
            .used_bytes
    let dir = TempDir::new().unwrap();
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
}
    let shard3 = Arc::clone(boxed);
    assert!(
fn recovery_clear_deletes_snapshot_file() {
fn multiple_files_are_independent() {
        .removed_bytes
    let (cache, _dir) = test_cache();
    // used_bytes = 0 (empty cache)
        assert!(
    let dir = TempDir::new().unwrap();
    assert_eq!(
    );
        removed_bytes_after,
            TEST_CACHE_BLOCK_SIZE,
        .load(std::sync::atomic::Ordering::Relaxed);
        count_after_second, 1,
    assert!(
    let data: Vec<u8> = (0u32..1_000_000).map(|i| (i % 251) as u8).collect();
    cache.evict_prefix("/data/file.parquet");
            TEST_BUFFER_POOL_SIZE,
        counter.load(std::sync::atomic::Ordering::Relaxed),
        total_removed, 4,
    // Loop shard_count times to guarantee all shards are visited.
        assert_eq!(result, 0);
    put_range(&cache, "/data/a.parquet", 0, 100, b"a");
#[test]
            dir.path(),
        "cursor must start at 0"
    // with an in-flight read that triggers a put().
            .stats
}
    let key0 = "stale_shard0\x1F0-100".to_string();
        cache.should_skip_sweep(),
    for _ in 0..shard_count {
        TEST_CACHE_BLOCK_SIZE,
            TEST_SUBMIT_QUEUE_SIZE,
    let (cache, _dir) = test_cache();
    let eviction_bytes_before = cache
}
    drop(g1);
        TEST_CACHE_DISK_BYTES,
        true,
}
    tiered.put_metadata(&footer_key, Bytes::from_static(b"footer_bytes"));
        TEST_BUFFER_POOL_SIZE,
    assert!(!cache.key_index.contains_key("data/target.parquet"));
        "used_bytes should be 1024 after a single 1KB put"
            .load(std::sync::atomic::Ordering::Relaxed),
fn concurrent_put_and_evict_same_prefix_does_not_corrupt() {
        "key_index.json must be > 100KB for 10k entries, got {bytes}"
    // "data/f.parquet\x1F0-100"   → 100 bytes
    let path = dir.path().join(key_index_store::KEY_INDEX_FILENAME);
            .eviction_bytes
            )
            TEST_CACHE_BLOCK_SIZE,
    );
    let result = block_on(cache.get(&key));
    }
}
fn concurrent_puts_to_different_files_do_not_corrupt() {
/// The guard increments the counter on construction and decrements it on drop.
            engine.as_ptr(),
    let removed_before = cache
///
/// Each sweep_once() processes exactly one shard and advances the cursor.
    );
        shards[0].read().is_empty(),
        "first range must still be readable after sweep"
/// With HashSet, the second insert is a no-op.
    );
    // on disk. key_index must retain the entry either way so evict_prefix() still works.
        .load(std::sync::atomic::Ordering::Relaxed);
    assert_eq!(destroy_rc, 0);
        put_range(&cache, "/data/a.parquet", 512, 1024, &vec![0u8; 512]);
 * compatible open source license.
            &cache,
    // Inject only fake keys for a prefix — no real entries.
}
    );
    cache.put(&key, Bytes::from_static(b"version_1"));
    // Poll for key_index.json — the persist task must write it within 5s.
        .entry("data/gone.parquet".to_string())
                break;
            0,
        TEST_BUFFER_POOL_SIZE,
        .stats
        cache
    assert!(ptr > 0);
    // DashMap defaults to 64 shards on macOS — must sweep at least shard_count times.
        block_on(cache2.clear());
    let (cache, _dir) = test_cache();
    let key = range_cache_key("/data/file.parquet", 0, 512);
        256 * 1024,
    // used_bytes = 100% of disk
    let (cache, _dir) = test_cache();
        }
        Some(512),
    let rc = unsafe { crate::foyer::ffm::foyer_snapshot_stats(0, out.as_mut_ptr()) };
            .stats
}
            .insert(key.to_string());
            0,
    );
        0,
        0,
            .used_bytes
        TEST_SUBMIT_QUEUE_SIZE,
    assert_eq!(
        "getter must reflect the updated bound"
    put_range(&cache, "/data/b.parquet", 0, 100, b"b");
    let g2 = ActiveBytesGuard::new(&counter, 200);
            > eviction_count_before,
            false,
            .load(std::sync::atomic::Ordering::Relaxed),
#[test]
    let cache2 = FoyerCache::new(
        TEST_SUBMIT_QUEUE_SIZE,
// ── ActiveBytesGuard tests ────────────────────────────────────────────────────
fn sweep_cursor_eventually_removes_all_stale_keys_across_multiple_calls() {
            .exists(),
/// The pointer can be reinterpreted as Box<Arc<dyn BlockCache>> and the Arc's
    let dir = TempDir::new().unwrap();
        cache
fn used_bytes_is_correct_after_put_then_evict() {
    {
    assert!(!contents.is_empty(), "key_index.json must not be empty");
//! Unit tests for [`FoyerCache`] and the FFM lifecycle API.
    let dir = TempDir::new().unwrap();
    let data_key = range_cache_key(path, 0, 2_000_000);
    let bytes = std::fs::metadata(&path).unwrap().len();
/// worker threads, quickly exhausting the macOS thread limit and causing tests to block
    // No prior cache instance — key_index.json does not exist.
    assert!(ptr > 0);
#[test]
        "/data/persist_watchdog.parquet",
    // Use a large interval so the task never actually fires during the test.
fn sweep_threshold_negative_used_bytes_treated_as_zero() {
        let count = cache
fn sweep_once_is_idempotent_for_real_entries() {
}
            0,
        Some(4096),
}
    // Short sweep interval: the inner loop fires at least once within 2s.
        // Real-looking key — Foyer won't have it either, but it's valid format.
fn persist_task_catch_unwind_does_not_kill_loop_on_panic() {
        .as_object()
        false,
/// PP-04: persist task does NOT write key_index.json when used_bytes has not changed
            dir.path(),
// ── FFM lifecycle ─────────────────────────────────────────────────────────────
        .load(std::sync::atomic::Ordering::Relaxed);
            .unwrap();
}
    // But sweep_once() bypasses the guard and still sweeps
    // No hang means watchdog exited cleanly.
        let mtime_before =
        .stats
#[test]
    const NUM_PREFIXES: usize = 100;
    // Tight bound → rejected.
    );
    // Reset cursor to shard 0 for a predictable starting point.
    let (cache, _dir) = test_cache();
    // Event::Replace fires only when the old value is still in the 1-byte DRAM tier at
            .load(std::sync::atomic::Ordering::Relaxed),
#[test]
    );
        bytes > 100_000,
        0,
            appeared,
    let dir = TempDir::new().unwrap();
        TEST_SUBMIT_QUEUE_SIZE,
    // The file itself must be readable JSON above a minimum size.
    let snap_exists = dir
    drop(g3);
            dir_str.len() as u64,
                .exists(),
    // Loop shard_count times to guarantee the shard containing the fake key is visited.
        block_on(tiered.metadata_cache().get(&big_key)).is_none(),
        cache.key_index.is_empty(),
    // Manually replicate the catch_unwind logic from the sweep task.
            engine.as_ptr(),
    assert!(ptr > 0);
    );
            .join(key_index_store::KEY_INDEX_FILENAME)
        cache
    tiered.put(&big_key, Bytes::from(vec![0xAB; 4096])); // 4KB > 2KB → skipped
    let (cache, _dir) = test_cache();
    let shard_count = cache.key_index.shards().len();
    );
    use std::collections::HashSet;
    );
    );
        let prefix = format!("data/nodes/0/shard_{p:04}/segment.parquet");
    // used_bytes starts at 0, put adds size, evict_prefix subtracts — net result = 0.
    // and reset used_bytes to 0, mirroring FileCache.clear() recordRemoval semantics.
        .entry("data/keep.parquet".to_string())
            .join(key_index_store::KEY_INDEX_FILENAME)
    );
    let key = range_cache_key("/data/file.parquet", 0, 1024);
    let result = unsafe { foyer_snapshot_stats(ptr, buf.as_mut_ptr()) };
        data_misses_before
        index.insert(
            .removed_count
            0.0_f64,
}
    let after_count = cache
    // We only care that drop() cancels it cleanly.
}
#[test]
    put_range(&cache, "/data/target.parquet", 0, 100, b"target");
        for i in 0u64..100 {
    put_range(&cache, "/data/new.parquet", 0, 256, &vec![0xCCu8; 256]);
        0,
    let dir_str = dir.path().to_str().unwrap();
        total_keys, expected_total,
        &cache,
    cache
                0,
        1,   // 1-second interval
    // Load back and verify.
        let json = serde_json::to_string(&snap).unwrap();
        TEST_CACHE_DISK_BYTES,
        cache.key_index.contains_key("data/stale.parquet"),
        TEST_CACHE_BLOCK_SIZE,
fn tiered_cache_metadata_hit_never_probes_data_ssd() {
fn recovery_with_no_snapshot_is_clean_startup() {
            dir.path(),
    block_on(cache.clear());
    evictor.join().expect("evictor panicked");
    let removed2 = cache.sweep_once();
        "negative used_bytes must be clamped to 0; ratio 0.0 < threshold 0.5 → skip"
    let dir_str = dir.path().to_str().unwrap();
            engine.len() as u64,
        std::sync::atomic::Ordering::Relaxed,
    // Writes 8 × 256KB = 2MB total into a 1MB cache to trigger LRU eviction pressure.
#[test]
/// Clean startup (no key_index.json) is a no-op: key_index starts empty,
        std::thread::sleep(std::time::Duration::from_millis(2000));
    let dir = TempDir::new().unwrap();
fn ffm_destroy_with_negative_ptr_returns_error() {
        );
        for i in 0u64..100 {
    drop(clone);
    // 10 fields × 2 sections = 20 longs
    assert_eq!(
    );
        used_before - 300,
        block_on(
    );
        0.0,
/// fires and the get() future is abandoned.
/// Serialise a 10k-entry key_index to disk and verify the JSON file is non-empty,
    assert!(shards.len() >= 2, "test requires at least 2 shards");
    assert!(
    };
/// After 16 calls the cursor has wrapped through all shards (0..15).
        dash.insert(prefix, keys);
        0,
        "overall and block_level sections must be identical"
    let key = range_cache_key("/data/file.parquet", 0, 1024);
#[test]
                .modified()
    // Sweeper should remove nothing.
    tiered.update_max_data_entry_size(1024);
            engine.len() as u64,
    assert_eq!(
#[test]
    let used_bytes_after = cache
// ── KeyIndexListener behaviour ────────────────────────────────────────────────
    // get() probes metadata cache first → hit
    assert!(cache.key_index.contains_key("data/file.parquet"));
fn after_evict_prefix_new_put_is_retrievable() {
        .load(std::sync::atomic::Ordering::Relaxed);
        dir.path(),
        6,
    let token: CancellationToken = cache.shutdown.clone();
/// Negative used_bytes (which can transiently occur due to relaxed ordering on
            IO_ENGINE,
}
        "usage=50% < threshold=75%: sweep must be skipped"
/// The guard's Drop impl must restore active_in_bytes to 0.
        .key_index
#[test]
    );
        false,
        "stale key must be removed by sweep_once() even when threshold would skip"
    // No subtraction happens on replace because Event::Replace almost never fires.
        TEST_CACHE_BLOCK_SIZE,
    use std::collections::HashSet;
    let dir = TempDir::new().unwrap();
    use crate::traits::BlockCache;
        TEST_SUBMIT_QUEUE_SIZE,
}
    // key_byte_size returns 0 for malformed key — eviction_bytes unchanged.
    assert!(ptr > 0);
// ── evict_prefix stats correctness ───────────────────────────────────────────
        );
    let key = range_cache_key("/data/large.parquet", 0, data.len() as u64);
    tiered.put_metadata(&key, Bytes::from_static(b"footer"));
/// Dropping a get() future before it completes simulates future cancellation.
}
            s
            "cursor must be {} after {} calls",
            native_bridge_common::error::native_error_free(-result);
        );
    // Verify neither file exists before creating the cache.
        cache.should_skip_sweep(),
            0,
    assert!(block_on(cache.get(&range_cache_key("/data/file.parquet", 1, 100))).is_none());
        "data entry within the limit must be cached"
    let (cache, _dir) = test_cache();
use std::sync::Arc;
/// the inner loop fires at least once before drop.
}
/// per-`FoyerCache` runtimes created by `FoyerCache::new()`. Each runtime spawns OS-level
        1.0,
#[test]
    let used = cache2
    if result < 0 {
        block_on(tiered.get(&range_cache_key("seg0/_0.parquet", 7_500_000, 9_000_000))).is_none()
    block_on(cache.clear());
        dir.path(),
            .exists()
        TEST_CACHE_BLOCK_SIZE,
        .load(std::sync::atomic::Ordering::Relaxed);
        0
    );
/// A shard containing both live and stale keys: sweep removes only the stale keys,
        block_on(cache.get(&range_cache_key("/data/a.parquet", 8192, 12288))).as_deref(),
    // key_index.json must exist after graceful shutdown.
        BLOCK_SIZE,
            0,
            break;
    assert!(block_on(cache.get(&range_cache_key("/data/other.parquet", 0, 100))).is_some());
            0,
    tiered.update_max_data_entry_size(8192);
    // Shard 1 must still have its stale key.
            .exists(),
    );
    // Clone the token before drop so we can inspect it after.
    {
    assert!(
    // No panic, no assertion failure → shutdown was clean.
        false,
/// foyer_snapshot_stats with null out buffer returns negative.
    cache.put(&fresh_key, Bytes::from_static(b"fresh"));
        "usage=90% > threshold=75%: sweep must NOT be skipped"
        let prefix = format!("shard_test_{}", i);
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
        .store(exact, std::sync::atomic::Ordering::Relaxed);
    };
    for _ in 0..16 {
    let result = unsafe { foyer_destroy_cache(-1) };
            &vec![0u8; 256],
        0,
    assert_eq!(
        ]);
    // usage = 90% → above 75% → do NOT skip
    );
        foyer_create_cache(
        }
/// so we verify that a second interval tick with no puts does not change the mtime.
        Some(512),
    let dir = TempDir::new().unwrap();
///
        put_range(&cache, "/data/f.parquet", 0, 100, &vec![0u8; 100]);
    unsafe { foyer_destroy_cache(ptr) };
    let evictor_cache = Arc::clone(&cache);
            IO_ENGINE,
// ── Recovery / persistence integration tests ─────────────────────────────────
    {
            0,
            0,
        // Evict one prefix before shutdown.
    );
        .unwrap_or(0);
            {
    }
    let cache = Arc::new(cache);
    assert!(block_on(tiered.data_cache().get(&footer_key)).is_none());
        .stats
        Bytes::from_static(b"meta"),
    let dir = TempDir::new().unwrap();
fn drop_without_sweep_task_does_not_panic() {
const BLOCK_SIZE: usize = 64 * 1024 * 1024; // 64 MB — used by FFM tests (disk=64MB) and large_value test
        dir.path(),
        put_range(&cache, "/data/f.parquet", 300, 600, &vec![0u8; 300]);
        .load(std::sync::atomic::Ordering::Relaxed);
    );
            > 0,
        assert_eq!(result.as_deref(), Some(b"hello".as_slice()));
    drop(boxed);
#[test]
            TEST_CACHE_DISK_BYTES,
fn clear_removes_all_entries() {
    {
        let used_after_evict = cache
            0,
        );
            0, // disabled
        data_hits_before
        .exists());
        &range_cache_key(path, 9_000_000, 10_000_000),
        !cache2.key_index.contains_key("data/shard1/file.parquet"),
    // Clone to bump strong count by 1 — original was 1, now 2.
    // Two files, one range each: 0-100 = 100 bytes, 0-200 = 200 bytes → total 300 bytes, 2 entries.
        IO_ENGINE,
            })
    tiered.put_metadata(&big_key, Bytes::from(vec![0xAB; 4096])); // 4KB > 2KB → skipped
        !cache.key_index.contains_key("data/gone.parquet"),
        .stats
fn key_index_clear_with_10k_entries() {
        TEST_CACHE_BLOCK_SIZE,
        NUM_PREFIXES,
        eviction_bytes_after - eviction_bytes_before,
    );
            .sweep_cursor
    tiered.evict_prefix("seg0/");
    writer.join().expect("writer panicked");
/// rejected entry on the next put.
#[test]
        false,
    }
    assert_eq!(
        .removed_count
    let col_a_key = range_cache_key("seg0/_0.parquet", 0, 2097152);
            .join(key_index_store::KEY_INDEX_FILENAME)
    assert_eq!(
    // usage = 100% → above 75% → do NOT skip
    {
    assert_eq!(
#[test]
        .store(shard_count - 1, std::sync::atomic::Ordering::Relaxed);
    // Calling sweep_once() twice on live entries must not double-decrement stats.
            .join(crate::key_index_store::KEY_INDEX_FILENAME)
            .exists(),
    let deadline = std::time::Instant::now() + std::time::Duration::from_secs(5);
            .load(std::sync::atomic::Ordering::Relaxed),
        .join(key_index_store::KEY_INDEX_FILENAME)
            16 * 1024 * 1024,
    // Drop _box — strong count reaches 0, FoyerCache freed.
            0.0_f64,
        shard_count
        "4KB rejected under 1KB bound"
        );
}
            .stats
        .eviction_count
    cache
            i % 16,
        cache.should_skip_sweep(),
            0,
fn ffm_create_with_null_ptr_returns_error() {
                .unwrap();
}
        0,
}
    );
// They use short intervals (1–2 seconds) and poll for the file's existence.
            0,
        false,
        "threshold=0.0: should never skip even when cache is empty"
        .map(|v| v.len())
        0.0,
        .is_none(),
#[test]
        dir.path().join(key_index_store::KEY_INDEX_FILENAME),
        count
    let mut buf = [i64::MIN; 20];
}
    );
        dir.path(),
        TEST_SUBMIT_QUEUE_SIZE,
        .removed_bytes
    shards[1].write().insert(
    // rather than using a fixed sleep — avoids flakiness on slow CI machines.
    );
        total_removed += cache.sweep_once();
fn snapshot_stats_two_sections_identical_for_single_tier() {
    let cache = FoyerCache::new(
/// Using a single shared runtime for all test `block_on()` calls reduces the total runtime
            IO_ENGINE,
    let (cache, _dir) = test_cache();
    assert!(ptr < 0);
            0.0,
    let reader = std::thread::spawn(move || {
            TEST_CACHE_BLOCK_SIZE,
}
            writer_cache.put(&key, Bytes::from_static(b"data"));
            out[i]
    let counter = AtomicI64::new(0);
}
    let (cache, _dir) = test_cache(); // sweep_interval_secs=0 → no task spawned
        "data/b.parquet must be in key_index after recovery"
        "empty prefix bucket must be removed after sweep"
        0,
    let index = parsed["index"]
        .stats
        TEST_CACHE_DISK_BYTES,
            .load(std::sync::atomic::Ordering::Relaxed),
    put_range(&cache, "/data/file.parquet", 100, 200, b"more");
        "key_index must be empty after clear() deleted the snapshot"
    cache
    }
#[test]
            writer_cache.put(&key, Bytes::from(vec![0u8; 100]));
    let removed = cache.sweep_once();
            false,
                dir_str.as_ptr(),
    // Set cursor to shard 0.
        "data tier must be empty after clear_sync()"
    let (cache, _dir) = test_cache();
    // ── Verify isolation ─────────────────────────────────────────────
        0,
// to disk every `persist_interval_secs` seconds when `used_bytes` has changed.
        .stats
        IO_ENGINE,
    put_range(&cache, "/data/a.parquet", 0, 4096, b"range0");
        0,
    // Cache must still be fully functional.
const IO_ENGINE: &str = "auto";
            TEST_BUFFER_POOL_SIZE,
    assert_eq!(
        TEST_SUBMIT_QUEUE_SIZE,
    );
    cache.evict_prefix("/data/file.parquet");
            0,
        .stats
            IO_ENGINE,
            &vec![0u8; 256],
            TEST_SUBMIT_QUEUE_SIZE,
#[test]
    put_range(&cache, "/data/file.parquet", 0, 100, b"after");
        "eviction_bytes must not change across two sweeps of live entries"
    );
    // When all keys under a prefix become stale, the prefix bucket itself should be removed.
        .used_bytes
    let remaining = cache
    for _ in 0..shard_count {
            .key_index
            .load(std::sync::atomic::Ordering::Relaxed),
}
            IO_ENGINE,
        removed, 1,
    let fake1 = "data/gone.parquet\x1F0-100".to_string();
        // Drop persists.
            IO_ENGINE,
        cache.should_skip_sweep(),
    let writer_cache = Arc::clone(&cache);
        false,
            TEST_CACHE_DISK_BYTES,
        )
        before_count, 2,
    }
    assert!(
            "key_index.json must NOT exist while cache is alive with persist_interval=0"
    assert_eq!(shard2_keys.len(), 1, "shard2 must have 1 key");
            .stats
            .active_in_bytes
        TEST_CACHE_DISK_BYTES as i64,
        .stats
    );
fn tiered_cache_evict_prefix_cleans_both_caches() {
/// put_metadata still lands in the one cache. Dispatched via `&dyn BlockCache`
#[test]
        cache.key_index.is_empty(),
        TEST_BUFFER_POOL_SIZE,
            .active_in_bytes
/// Size bounds update dynamically — raising the limit admits a previously
    put_range(&cache, "/data/file.parquet", 0, 1024, &vec![0u8; 1024]);
        unsafe {
#[test]
        TEST_SUBMIT_QUEUE_SIZE,
            native_bridge_common::error::native_error_free(-result);
}
}
        "used_bytes must be 0 after clear"
    assert!(!dir
    }
    let count_after_first = cache
        cache
                .path()
#[test]
    let ptr = unsafe {
    let cache = FoyerCache::new(
        .used_bytes
        );
            0,
        .load(std::sync::atomic::Ordering::Relaxed);
    );
    );
    use std::sync::atomic::AtomicI64;
            .load(std::sync::atomic::Ordering::Relaxed),
/// to exercise the trait default explicitly.
#[test]
    assert_eq!(
        removed, 1,
    );
        .used_bytes
        foyer_create_cache(
        put_range(
fn sweep_threshold_disabled_never_skips() {
                .exists(),
fn sweep_disabled_when_interval_is_zero() {
fn sweep_once_on_empty_cache_is_noop() {
        false,
        cache
    }
            BLOCK_SIZE as u64,
fn simulated_crash_skip_drop_no_final_persist() {
        dir.path()
        3600,
        cache.should_skip_sweep(),
        .sweep_cursor
    );
    );
        false,
    assert_eq!(
// These tests exercise the full put → Drop (persist) → new (recover) cycle.
            .eviction_bytes
        512,
        TEST_BUFFER_POOL_SIZE,
            }
        dir.path(),
    assert_eq!(
        cache.key_index.is_empty(),
        "used_bytes must still be 512 after second put of the same key (no double-count)"
        0,
        assert!(
    {
        count_after_second
    assert_eq!(result.as_deref(), Some(b"second".as_slice()));
            evictor_cache.evict_prefix("/data/file.parquet");
    let dir = TempDir::new().unwrap();
    assert!(
        data_dir.path(),
    let cache = FoyerCache::new(
        1 * 1024 * 1024,
/// After all threads finish, key_index must contain exactly 1 entry for the key,
            .load(std::sync::atomic::Ordering::Relaxed),
            64 * 1024 * 1024,
/// Populate 10k entries directly into the key_index (simulating cache puts),
    assert!(
fn recovery_evicted_prefix_not_persisted() {
    let r1 = block_on(cache.get(&range_cache_key("/data/keep.parquet", 0, 512)));
    // Put a real entry: key is live in Foyer.
#[test]
            TEST_BUFFER_POOL_SIZE,
        TEST_SUBMIT_QUEUE_SIZE,
/// When usage is strictly below the threshold, should_skip_sweep() returns true.
    assert_eq!(
        .join(key_index_store::KEY_INDEX_FILENAME)
    }
/// behavior; they just occupy key_index until swept.
/// sweep_interval_secs=0 must not spawn a sweep task.
    let dir = TempDir::new().unwrap();
#[test]
fn active_bytes_guard_multiple_concurrent_guards() {
    let engine = IO_ENGINE.as_bytes();
    assert_eq!(
/// used_bytes is initialized from the snapshot on recovery.
                break true;
    let cache = FoyerCache::new(
#[test]
        "stale_shard1".to_string(),
    assert!(cache.key_index.contains_key("data/file.parquet"));
        !token.is_cancelled(),
    );
    let dir = TempDir::new().unwrap();
/// Build a 10k-entry snapshot, write it to disk, then create a new FoyerCache
            TEST_SUBMIT_QUEUE_SIZE,
        .map(|v| v.len())
/// Threshold of 1.0 means "only sweep when cache is 100% full" — any usage below
    let used_bytes = cache
    let key_count = loop {
    assert_eq!(
#[test]
        loaded.index.len(),
            .collect();
}
}
    assert!(
            .stats
 * this file be licensed under the Apache-2.0 license or a
    assert!(
        unsafe {
    let removed_count_before = cache
/// Stress test for the concurrent `put()` + `evict_prefix()` scenario described in the
    );
    );
    put_range(&cache, "/data/b.parquet", 0, 200, &vec![0u8; 200]);
        "used_bytes must decrease after bulk evict_prefix"
}
fn persist_task_not_spawned_when_interval_is_zero() {
        NUM_PREFIXES * KEYS_PER_PREFIX,
/// used_bytes must not be double-counted when the same key is put twice.
        .insert("data/keep.parquet\x1F9000-9100".to_string());
    let clone = Arc::clone(&*boxed);
        IO_ENGINE,
// ── key_index integrity ───────────────────────────────────────────────────────
    // key_index stores normalized keys (no leading '/'):
/// Note: whether a specific entry ends up present or absent after this test is intentionally
        TEST_CACHE_BLOCK_SIZE,
    assert_eq!(
        IO_ENGINE,
/// put() skips data entries larger than max_data_entry_size; the getter reflects
        // drop(cache) here — cancels token
            engine.len() as u64,
/// The cache is usable throughout — stale keys don't cause panics or incorrect
            &vec![0u8; 128],
        .load(std::sync::atomic::Ordering::Relaxed);
}
    );
    key_index_store::save(dir.path(), &dash).unwrap();
            let key = range_cache_key("/data/file.parquet", i * 100, (i + 1) * 100);
    assert_eq!(result, 0);
    const NUM_PREFIXES: usize = 100;
        "eviction_count must increase for the stale key removed by sweep"
}
            .load(std::sync::atomic::Ordering::Relaxed),
    assert_eq!(eviction_bytes_after_1, 0);
        ("data/gamma.parquet", "data/gamma.parquet\x1F0-300"),
        )
    const RANGE_SIZE: u64 = 1024;
}
        let byte_size: i64 = keys
        "exactly one shard must have been swept; {} of {} shards still have entries (expected {})",
        "key_index must be empty on clean startup"
    // Inject a stale key
fn cache_is_usable_after_clear() {
    assert!(
        .load(std::sync::atomic::Ordering::Relaxed);
        .eviction_bytes
    block_on(cache.clear());
    let eviction_count_before = cache
        .eviction_bytes
        removed_bytes_before + 300,
            "data/f.parquet\x1F0-100".to_string(),
use crate::tiered_block_cache::TieredBlockCache;
fn clear_updates_removed_count_and_removed_bytes() {
    let col_idx_key = range_cache_key("seg0/_0.parquet", 8000000, 8500000);
    let cache = FoyerCache::new(
use std::sync::atomic::Ordering;
    // Create and drop a cache to write key_index.json.
    );
            counter.load(std::sync::atomic::Ordering::Relaxed),
        0,
    put_range(&cache, "/data/file.parquet", 100, 200, b"more");
    let dir = TempDir::new().unwrap();
        0.0,
            .active_in_bytes
    // Subset → miss (different key)
        "cursor raw={} must wrap: {} % {} == 0",
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
    cache.put(&key, Bytes::from_static(data));
    assert!(
    let used_bytes_before = cache
        "key_index.json must exist after session 1 Drop"
    std::mem::forget(cache);
/// `BlockCache::put_metadata` default, which routes to put() — so warmup's
#[test]
            TEST_CACHE_BLOCK_SIZE,
    // One call sweeps shard 0 only.
/// Tests that explicitly exercise capacity pressure (`put_and_get_work_after_cache_nears_capacity`,
        block_on(tiered.get(&big_key)).is_none(),
    // Two fake keys: 0-100 (100 bytes) and 100-200 (100 bytes) = 200 bytes total.
    );
    put_range(&cache, "/data/file.parquet", 100, 300, &vec![0u8; 200]);
}
        .key_index
            .stats
        false,
            dir.path(),
            invalid_utf8.len() as u64,
/// foyer_create_cache returns a pointer that can be cloned (passed to multiple TieredObjectStores)
    cache
        )
    let stale_key = "data/mixed.parquet\x1F999000-999100".to_string();
    );
        .sweep_cursor
    tiered.put_metadata(&key, Bytes::from_static(b"old_footer"));
    let evictor_cache = Arc::clone(&cache);
        .collect();
#[test]
        128 * 1024 * 1024,
    );
        raw,
#[test]
    // New puts and gets must work normally after sweep.
    let removed_count = cache
    );
        "non-evicted prefix must still appear after recovery"
/// No .tmp file should exist after either graceful shutdown or periodic persist.
        .insert("data/bad.parquet-not-a-range-key".to_string());
        foyer_create_cache(
        0,
    let rc = unsafe { crate::foyer::ffm::foyer_snapshot_stats(ptr, std::ptr::null_mut()) };
fn put_and_get_work_after_cache_nears_capacity() {
        BLOCK_SIZE,
#[test]
    assert!(cache.key_index.is_empty());
    let used_bytes_before = cache
    let dir = TempDir::new().unwrap();
            .eviction_count
            TEST_CACHE_BLOCK_SIZE,
        let _guard = ActiveBytesGuard::new(&counter, 512);
    for i in 1usize..=16 {
            engine.as_ptr(),
    );
    assert_eq!(
    assert_eq!(Arc::strong_count(&*boxed), 1);
    tiered.update_max_metadata_entry_size(2048);
    let (cache, _dir) = test_cache();
        .removed_count
        .path()
            .used_bytes
#[test]
    );
        );
        TEST_BUFFER_POOL_SIZE,
}
        0.0,
    assert_eq!(
    let used_after = cache
        dir.path(),
    let mut out = [0i64; 14];
            "persist task must rewrite key_index.json after evict_prefix() changed used_bytes"
    // Run shard_count sweep cycles to guarantee all shards are covered exactly once.
/// put_metadata() routes to metadata cache; get() finds it there.
        .get("data/file.parquet")
}
        .load(std::sync::atomic::Ordering::Relaxed);
/// PP-05: persist fires after evict_prefix() because used_bytes changes.
        .used_bytes
        block_on(tiered.get(&col_idx_key)).is_some(),
        "sweep_once() must sweep regardless of threshold"
        TEST_SUBMIT_QUEUE_SIZE,
/// - Block size: 1 MB — accommodates `large_value_round_trips_correctly` (≈976 KB
        .map(|v| v.len())
    tiered.put_metadata(&col_idx_key, Bytes::from(vec![0xC; 500_000]));
    );
/// parallel test execution practical.
    tiered.put_metadata(&col_idx_key, Bytes::from_static(b"column_index_bytes"));
            BLOCK_SIZE as u64,
        );
        3600, // 1-hour interval — task sleeps, drop cancels it immediately
        "key_index must have {NUM_PREFIXES} buckets after recovery"
/// leaves the live keys in place, and correctly updates eviction stats.
    let removed_bytes = cache
    let cache = FoyerCache::new(
        false,
        shard_count - 1,
        let cache = FoyerCache::new(
/// of the watchdog outer loop, so the first tick after recovery always persists.
    assert!(
    let (cache, _dir) = test_cache();
        "key_index must be empty after clear"
        "overall and block_level sections should be identical for single-tier Foyer"
    let cache2 = FoyerCache::new(
            false,
    assert_eq!(
        let key = range_cache_key(&format!("/data/file_{}.parquet", i), 0, 1024);
#[test]
    cache.put(&key, Bytes::copy_from_slice(&data));
        TEST_CACHE_BLOCK_SIZE,
                0.0_f64,
            false,
    tiered.put(&col_a_key, Bytes::from_static(b"col_a_data"));
        used_bytes_after - used_bytes_before,
/// 3. Query: DataFusion reads data → miss → S3 → put() → data cache
#[test]
    drop(shard3);
    );
    dyn_cache.put_metadata(&key, Bytes::from_static(b"footer"));
        false,
    //
        let cache = FoyerCache::new(
    );
            .used_bytes
        assert!(result.iter().all(|&b| b == i));
            .map(|k| format!("{prefix}\x1F{}-{}", k * 4096, (k + 1) * 4096))
    let fake2 = "data/gone.parquet\x1F100-200".to_string();
        .stats
fn key_index_evict_prefix_bulk_with_10k_entries() {
    let small_key = range_cache_key("seg0/_0.parquet", 4096, 5120);
    let writer_cache = Arc::clone(&cache);
    assert_eq!(b_count, 1, "data/b.parquet must have 1 key");
    );
    }
            &cache,
    );
        cache.key_index.is_empty(),
    let small_key = range_cache_key("seg0/_0.parquet", 0, 1024);
fn put_same_key_twice_replaces_value() {
    assert_eq!(
    let (cache, _dir) = test_cache();
            "persist task must fire on first tick after recovery (last_persisted=MIN != recovered used_bytes)"
/// be identical since Foyer is single-tier (both sections mirror each other).
    let used = cache
            .join(key_index_store::KEY_INDEX_FILENAME)
        h.join().expect("thread panicked");
    // Verify foyer_snapshot_stats returns < 0 when out pointer is null.
    // removed cleanly — no panic, no stats corruption.
            0,
    assert_eq!(
#[test]
/// After dropping a cache, its CancellationToken is cancelled (is_cancelled() == true).
    {
    for p in 0..NUM_PREFIXES / 2 {
        IO_ENGINE,
        0,
            dir_str.len() as u64,
/// active_in_bytes is 0 even after a cache miss — the guard restores it regardless
    // DashMap defaults to 64 shards on macOS — must sweep at least shard_count times.
        .stats
        .stats
            .load(std::sync::atomic::Ordering::Relaxed)
        counter.load(std::sync::atomic::Ordering::Relaxed),
        // Drop persists.
            TEST_BUFFER_POOL_SIZE,
        .stats
}
    );
    tiered.put_metadata(&key, Bytes::from(vec![0xC; 500_000]));
            dir_str.as_ptr(),
        false,
    let (cache, _dir) = test_cache();
    assert_eq!(
        put_range(&cache, "/data/file.parquet", 0, 100, &vec![0u8; 100]);
    assert!(
    ));
        "new put after sweep must be retrievable"
    assert!(block_on(cache.get(&range_cache_key("/data/b.parquet", 0, 100))).is_none());
            TEST_CACHE_DISK_BYTES,
        IO_ENGINE,
}
            BLOCK_SIZE as u64,
            256,
        "key_index.json must be written on Drop"
        let deadline = std::time::Instant::now() + std::time::Duration::from_secs(5);
    // Session 2: open with persist_interval=1s.
    TEST_RUNTIME
    );
    );
            TEST_CACHE_BLOCK_SIZE,
    let removed_before = cache
        .join(key_index_store::KEY_INDEX_TMP_FILENAME)
        IO_ENGINE,
        "used_bytes must be 600 (sum of all recovered key ranges) after recovery"
        .or_default()
    // Verify metadata is in metadata_cache, not data_cache
        dir.path()
            .sweep_cursor
    put_range(&cache, "/data/target.parquet", 8192, 12288, b"range2");
    // Fake key range 99999-100000 = 1 byte.
            dir.path(),
#[test]
        tiered.data_cache().stats.miss_count.load(Ordering::Relaxed),
    // Each key is unique so it hashes to a predictable shard via the raw write.
        cache
        "first put must add exactly 1 entry to key_index"
    );
            i
        .used_bytes
    let count_after_second = cache
            0.0,
        cache.should_skip_sweep(),
    );
            TEST_CACHE_DISK_BYTES,
    let shard_count = cache.key_index.shards().len();
        0,
    cache.put(&key, Bytes::from(vec![0xAAu8; 512]));
        }
    let dir = TempDir::new().unwrap();
    drop(cache);
        .used_bytes
}
    {
            TEST_SUBMIT_QUEUE_SIZE,
/// early — the same code path the guard follows when a tokio::select! timeout
    assert!(
}
            .key_index
            "/data/nodes/0/shard1.parquet",
    // Bulk-loaded snapshot has the stale key — used_bytes is temporarily over-counted.
        .or_default()
    assert_eq!(
                128 * 1024 * 1024,
    let dir_str = dir.path().to_str().unwrap();
            0.0,
        .load(std::sync::atomic::Ordering::Relaxed);
        false,
    );
/// `block_on()` invocation. With 109 tests running in parallel, each calling `block_on()`
    // get() misses metadata cache, hits data cache
fn sweep_cursor_cache_remains_functional_after_sweep() {
    let fake2 = "data/gone.parquet\x1F100-200".to_string();
/// (interval is very long); we only verify the cache is usable while the task
        TEST_CACHE_BLOCK_SIZE,
    // used_bytes grows monotonically: v2 was added on top of v1 (no reliable subtraction).
            128 * 1024 * 1024,
        let cache = FoyerCache::new(
    let shard_count = cache.key_index.shards().len();
    let eviction_bytes_after = cache
            .unwrap()
        block_on(dyn_cache.get(&key)).as_deref(),
use crate::foyer::ffm::{foyer_create_cache, foyer_destroy_cache};
    );
    assert_eq!(result.as_deref(), Some(b"after".as_slice()));
        );
/// Must be kept in sync: block_size (BLOCK_SIZE) ≤ disk_bytes (any test using this constant).
        block_on(
            .stats
    let chunk = vec![0xABu8; CHUNK_SIZE];
        .load(std::sync::atomic::Ordering::Relaxed);
    );
///
    assert_eq!(
        .stats
    assert_eq!(
    );
    let data_cache = Arc::new(FoyerCache::new(
    cache.evict_prefix("/data/file.parquet");
}
}
        "counter must return to 0 after guard is dropped"
                0,
        cache.key_index.len(),
fn lru_eviction_retains_keys_in_key_index() {
        assert_ne!(v, i64::MIN, "buf[{}] was not written", i);
            0,
    let shards = cache.key_index.shards();
    assert_eq!(
        "/data/watchdog_test.parquet",
    // clear() must increment removed_count and removed_bytes from key_index
}
    );
/// foyer_snapshot_stats returns 0 on a valid cache pointer and writes 14 i64 values.
    let chunk = vec![0u8; 512 * 1024];
    assert_eq!(
/// Metadata hit does not touch data cache SSD.
            .load(std::sync::atomic::Ordering::Relaxed),
            "counter must be 512 while guard is alive"
    );
fn sweep_cursor_preset_is_respected() {
    assert_eq!(
            .used_bytes
    let key = range_cache_key("/data/file.parquet", 0, 1024);
            .stats
        0.5,
        0.0,
        "used_bytes must decrease by 300 after eviction"
    let shard_count = shards.len();
        1,
    // Eviction stats must have been updated for the stale key.
    // Simulate a transient underflow (negative used_bytes) — should be clamped to 0.
        .stats
        .load(std::sync::atomic::Ordering::Relaxed);
    // ── Warmup: put metadata explicitly ──────────────────────────────
/// ST-04: no .tmp file exists on clean startup (fresh dir).
        "cursor must point to shard 1 after sweeping shard 0"
    key_index_store::save(&dir.path(), &cache.key_index).unwrap();
fn cache_functional_before_drop() {
    let invalid_utf8 = [0xFF, 0xFE, 0xFD];
// ── clear ─────────────────────────────────────────────────────────────────────
            .sum();
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
}
#[test]
    tiered.evict_prefix(path);
        TEST_SUBMIT_QUEUE_SIZE,
        block_on(tiered.get(&key)).is_none(),
        Some(b"footer_bytes".as_slice())
    assert!(
fn key_index_serialization_with_10k_entries() {
    put_range(&cache, "/data/file.parquet", 0, 100, b"first");
    );
            .stats
            TEST_CACHE_BLOCK_SIZE,
        "usage=75% == threshold=75%: sweep must NOT be skipped"
    let fresh_key = range_cache_key("/data/file.parquet", 0, 100);
    );
        0,
#[test]
        block_on(tiered.get(&data_key)).is_none(),
        cache
        0,    // persist disabled
        TEST_CACHE_BLOCK_SIZE,
    // threshold = 0.0: disabled — always sweep
    // Drop the box — this calls foyer_destroy internally via Arc drop.
    use std::sync::atomic::AtomicI64;
    );
    assert!(result < 0);
        .key_index
            false,
            0,
        cache
            .load(std::sync::atomic::Ordering::Relaxed),
        false,
#[test]
        .removed_count
        meta_dir.path(),
    // Put an entry so used_bytes becomes non-zero, then confirm sections match.
        cache
    let shard_count = cache.key_index.shards().len();
    // All entries were just put — they are on disk and inner.contains() returns true.
        block_on(cache.get(&range_cache_key("/data/b.parquet", 0, 100))).as_deref(),
/// under a read lock, releases all locks, then removes them. A `put()` that runs between
        "second put of same key must NOT add a duplicate entry (HashSet dedup); got {}",
        assert_eq!(snap["version"], 1, "snapshot must have version=1");
    let shard_count = cache.key_index.shards().len();
        false,
        "sweeper should have removed the 1 fake/stale key"
        .store(half, std::sync::atomic::Ordering::Relaxed);
        put_range(&cache, "/data/a.parquet", 0, 512, &vec![0u8; 512]);
    let count = cache
#[test]
        TEST_BUFFER_POOL_SIZE,
    assert_eq!(after_count, 1, "only the live key must remain after sweep");
        "threshold=0.0: should never skip even when cache is 100% full"
#[test]
    // 2 keys for a.parquet + 1 key for b.parquet = 3 total.
fn sweep_cursor_removes_stale_but_preserves_live_keys_in_same_prefix() {
    let ptr = unsafe {
        dir.path(),
        // Drop persists the remaining key_index (only kept.parquet).
    // A freshly created cache has no hits, misses, evictions, used bytes, or active reads.
        }
#[test]
#[test]
        {
            TEST_CACHE_BLOCK_SIZE,
            }),
        .key_index
            dir.path(),
        THREAD_COUNT, count
        "shard2 must be untouched"
        256,
        .path()
            .load(std::sync::atomic::Ordering::Relaxed),
    cache
fn snapshot_stats_used_bytes_reflects_put() {
    assert!(
    use std::sync::atomic::AtomicI64;
fn put_same_key_twice_does_not_double_count_used_bytes() {
        dir.path(),
            .stats
    block_on(cache.clear());
    cache.put(&key, Bytes::from(vec![0xABu8; 512]));
        dir.path()
    // per call, so we need N calls to cover all shards exactly once.
            i * CHUNK_SIZE as u64,
    // Key_index now has 2 keys for the prefix: 1 live + 1 stale.
            0,
    // Total stale bytes = 300
/// After the guard is dropped the counter must return exactly to its original value.
    cache
    }
    assert!(
                cache.put(&key, Bytes::copy_from_slice(&vec![i as u8; 1024]));
        cache.should_skip_sweep(),
    );
        removed_count,
    );
    cache.put(&key, Bytes::from_static(b"version_2"));
    for h in handles {
    let dir = TempDir::new().unwrap();
            .stats
        block_on(cache.clear());
            dir.path(),
/// call put(). With the old Vec-based key_index, this created two copies of the key,
/// is sleeping in tokio::select!.
#[test]
    let (cache, _dir) = test_cache();
        TEST_BUFFER_POOL_SIZE,
/// Verifies that key_index.json is written by the periodic task (not just by Drop)
        0,
        dir.path(),
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
    assert_eq!(
        "used_bytes must be exactly {} after {} concurrent puts of the same key; got {}",
        let key = range_cache_key(
/// Preset to shard_count - 1, one more call brings raw value to shard_count,
        cache
        &range_cache_key(path, start, end),
    drop(cache); // calls shutdown.cancel() — must be a no-op
    let path = "seg0/_0.parquet";
        "key_index.json must exist after graceful shutdown"
        NUM_PREFIXES,
            .unwrap_or(false),
    let key = range_cache_key("/data/never_inserted.parquet", 0, 512);
    assert_eq!(
            .map(|v| v.len())
    assert!(
        "corrupt snapshot must produce empty key_index"
            .used_bytes
    let deadline = std::time::Instant::now() + std::time::Duration::from_secs(5);
    // One sweep_once() call must process exactly one shard.
            std::fs::metadata(dir.path().join(crate::key_index_store::KEY_INDEX_FILENAME))
    let metadata_cache = Arc::new(FoyerCache::new(
    let (cache, _dir) = test_cache();
    let cache_trait: Arc<dyn crate::traits::BlockCache> = std::sync::Arc::new(cache);
//
        .extend(vec![
#[test]
// These tests exercise Fix 1 (catch_unwind) and Fix 4 (watchdog outer loop)
                .unwrap();
        TEST_SUBMIT_QUEUE_SIZE,
    }
        TEST_CACHE_DISK_BYTES,
        IO_ENGINE,
        0,
            .stats
    assert!(
    let dir = TempDir::new().expect("failed to create temp dir");
    };
/// `evict_prefix` is a scan-then-remove operation: it collects matching key_index entries
    let (cache, _dir) = test_cache();
    assert_eq!(used_bytes_after, 0, "clear() must reset used_bytes to 0");
        .exists()
    key_index_store::save(dir.path(), &dash).unwrap();
    for _ in 0..shard_count {
}
    );
        assert_eq!(counter.load(std::sync::atomic::Ordering::Relaxed), 42);
        let mtime_after =
    let shard1_keys = index["data/nodes/0/shard1.parquet"].as_array().unwrap();
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
/// A second FoyerCache opens the same dir (recovered used_bytes > 0).
    for i in 0u64..4 {
fn no_tmp_file_on_clean_startup() {
fn tiered_cache_put_metadata_routes_to_metadata_cache() {
        IO_ENGINE,
}
    let used_bytes_before = cache
            .exists(),
        );
    assert_eq!(
        TEST_CACHE_BLOCK_SIZE,
        .store(-100, std::sync::atomic::Ordering::Relaxed);
 * SPDX-License-Identifier: Apache-2.0
        .entry("data/gone.parquet".to_string())
///
#[test]
    cache.sweep_once();
        // persist_interval=1s: task should fire within ~2s of a put().
fn tiered_cache_size_bound_update_takes_effect_immediately() {
        &out[10..20],
    );
                .load(std::sync::atomic::Ordering::Relaxed)
        .load(std::sync::atomic::Ordering::Relaxed);
        BLOCK_SIZE,
    assert!(
    let key = range_cache_key("seg0/_0.parquet", 0, 64);
        block_on(cache.get(&range_cache_key("/data/a.parquet", 0, 4096))).as_deref(),
            dir.path(),
/// Each call to sweep_once() processes exactly one shard.
        unsafe {
    assert_eq!(
#[test]
fn key_index_recovery_with_10k_entries() {
    // Verify data is in data_cache only
        std::thread::sleep(std::time::Duration::from_millis(2500));
        .unwrap_or(0);
/*
fn sweep_enabled_cache_is_usable_while_task_sleeping() {
        .used_bytes
    let snap = cache.stats.snapshot();
        0,   // no sweep task
    );
            .stats
        .is_none(),
        put_range(&cache, "/data/idle.parquet", 0, 100, &vec![0u8; 100]);
        let prefix = format!("data/nodes/0/shard_{p:04}/segment.parquet");
    assert_eq!(rc, 0);
    // Writer: continuously caches new ranges under the same prefix.
fn ffm_snapshot_stats_valid_ptr_returns_zero_and_fills_buffer() {
            engine.len() as u64,
        .eviction_bytes
        .used_bytes
    // no task is spawned. The key_index must still contain the entry.
        dir.path()
            .used_bytes
}
    let dir = TempDir::new().unwrap();
    );
        let result = block_on(cache.get(&key));
    let result = block_on(cache.get(&range_cache_key("/data/file.parquet", 0, 100)));
        cache.key_index.insert(prefix, keys);
            engine.as_ptr(),
    }
    let reader_cache = Arc::clone(&cache);
        snap[6], 1024,
        cache
    for p in 0..NUM_PREFIXES {
    let cache = FoyerCache::new(
    // drop cancels the sleeping task immediately via cancelled() branch
#[test]
        0.0, // threshold disabled — sweep runs every tick
            .used_bytes
/// Even though used_bytes is non-zero, last_persisted starts at i64::MIN ≠ used_bytes,
 */
        cache
    cache
        0,
        false,
fn sweep_once_removes_empty_prefix_buckets() {
fn evict_prefix_on_nonexistent_prefix_does_not_change_stats() {
/// The file should NOT exist until Drop is called.
    cache.evict_prefix("/data/target.parquet");
    // Latest value must be readable.
            .load(std::sync::atomic::Ordering::Relaxed),
// ─── 10k-scale key_index tests ────────────────────────────────────────────────
        IO_ENGINE,
    );
        "4KB admitted after raising bound to 8KB"
    );
        "key was never inserted — should be a miss"
    // Snapshot via the FFM function.
        .insert("data/file.parquet\x1F0-100".to_string());
        TEST_BUFFER_POOL_SIZE,
    cache.evict_prefix("/never/inserted.parquet");
        RANGE_SIZE, THREAD_COUNT, used_bytes
    let boxed: Box<Arc<dyn BlockCache>> = unsafe { Box::from_raw(ptr as *mut Arc<dyn BlockCache>) };
            engine.as_ptr(),
    let (cache, _dir) = test_cache();
    // Inject a fake key that Foyer has never seen — inner.contains() will return false.
    assert!(!cache.key_index.contains_key("data/file.parquet"));
    let (cache, _dir) = test_cache();
        // Single put to trigger the first persist.
    put_range(&cache, "/data/file.parquet", 0, 1024, &vec![0u8; 1024]);
}
    {
    );
    );
    let cache = FoyerCache::new(
        0,   // persist disabled
            engine.len() as u64,
fn ffm_create_cache_ptr_cloneable_for_multiple_shards() {
static TEST_RUNTIME: std::sync::OnceLock<tokio::runtime::Runtime> = std::sync::OnceLock::new();
        .stats
            BLOCK_SIZE as u64,
        .used_bytes
    let dir = TempDir::new().unwrap();
}
        .load(std::sync::atomic::Ordering::Relaxed);
            .exists(),
        .stats
        "token must not be cancelled before drop"
        TEST_BUFFER_POOL_SIZE,
    let writer = std::thread::spawn(move || {
    //
fn tiered_cache_clear_empties_both_tiers() {
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
    // Superset → miss (different key)
    put_range(&cache, "/data/b.parquet", 0, 200, b"persist_data");
        let _guard = ActiveBytesGuard::new(&counter, 0);
            let mut s = std::collections::HashSet::new();
    cache.stats.used_bytes.store(
        .stats
    assert!(block_on(tiered.metadata_cache().get(&small_key)).is_some());
        dir.path(),
#[test]
// ── Watchdog and panic recovery tests ────────────────────────────────────────
    // After sweeping all shards, the stale key is removed (inner.contains() returns false).
            .used_bytes
    assert_eq!(rc, 0, "foyer_snapshot_stats should return 0 on success");
    // Simulate prior session: metadata was put via put_metadata
use tempfile::TempDir;
        0,
        .stats
            false,
        foyer_create_cache(
        TEST_CACHE_DISK_BYTES,
            prefix,
        counter.load(std::sync::atomic::Ordering::Relaxed),
    // Take ownership and immediately check the strong count via a clone probe.
        removed_bytes_before + 300,
        false,
            (i + 1) * CHUNK_SIZE as u64,
    let cache = FoyerCache::new(
/// `evict_prefix()` doc comment.
// ── Shutdown / CancellationToken tests ───────────────────────────────────────
        .load(std::sync::atomic::Ordering::Relaxed);
}
        0,
    assert_eq!(
/// by checking file existence before Drop is called.
    let result = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
#[test]
        .load(std::sync::atomic::Ordering::Relaxed);
// They use real FoyerCache instances and TempDir.
        .stats
//
/// multiple times, this produced hundreds of separate Tokio runtimes — on top of the
    // usage = max(−100, 0) / disk = 0 / disk = 0.0 < 0.5 → skip
    put_range(&cache, "/data/mixed.parquet", 0, 1024, &vec![0u8; 1024]);
fn sweep_once_stale_key_with_malformed_range_does_not_panic() {
        IO_ENGINE,
        block_on(tiered.get(&data_key)).map(|b| b.len()),
                engine.len() as u64,
#[test]
    let dir = TempDir::new().unwrap();
    cache
        0,
    );
        cache.evict_prefix(&prefix);
    // Shards close.
}
/// the child token — it is a no-op in that case.
/// to verify no shared state leaks between lifetimes.
fn tiered_cache_put_metadata_skips_oversized_entry() {
            engine.as_ptr(),
    cache
        // Evict one prefix — changes used_bytes so next tick must persist.
    // Manually write a snapshot with a mix of valid and fake stale keys.
            foyer_create_cache(
        );
    );
    let (cache, _dir) = test_cache();
        cache.key_index.contains_key("data/b.parquet"),
        IO_ENGINE,
    );
#[test]
        .load(std::sync::atomic::Ordering::Relaxed);
        TEST_CACHE_BLOCK_SIZE,
    {
/// Graceful restart: key_index is persisted on Drop and bulk-loaded on the next
    let dash: DashMap<String, HashSet<String>> = DashMap::new();
        IO_ENGINE,
    tiered.put(
            .stats
    // Live key must remain; stale key must be gone.
            .join(key_index_store::KEY_INDEX_TMP_FILENAME)
/// (or starts empty if periodic persist was also disabled).
    );
}
        used_before > 0,
    // Simulate: future starts, guard created, active_in_bytes incremented.
    let col_idx_key = range_cache_key(path, 8_000_000, 8_500_000);
    );
        "key_index must still contain entry — no background task should have modified it"
fn tiered_cache_multiple_shards_are_independent() {
    assert!(
            0.0,
        }),
            std::fs::metadata(dir.path().join(key_index_store::KEY_INDEX_FILENAME))
    }
    tiered.put(&key, Bytes::from(vec![0x22; 4096]));
            engine.len() as u64,
        Some(b"file_a".as_slice())
            0,
        TEST_CACHE_DISK_BYTES as i64,
}
    for (prefix, key) in &stale_keys {
        0
        "active_in_bytes must be restored to 0 when get() future is cancelled mid-flight"
    cache.evict_prefix("/data/file.parquet");
        .get("data/mixed.parquet")
        TEST_SUBMIT_QUEUE_SIZE,
        path.exists(),
    let cache3 = FoyerCache::new(
            BLOCK_SIZE as u64,
        );
    let removed1 = cache.sweep_once();
        false,
            0,
        cache
    put_range(&cache, "/data/other.parquet", 0, 100, b"other");
    assert_eq!(
            0.0,
        TEST_BUFFER_POOL_SIZE,
            .stats
    );
        "eviction_count must be incremented for stale entries removed by sweeper"
        let cache = FoyerCache::new(
    // key_index stores normalized keys (no leading '/'):
        // Wait up to 3 intervals for the next persist.
/// so the first persist tick MUST fire and update the snapshot mtime.
/// put() (normal path from TieredObjectStore::populate_cache) routes to data cache.
            .exists(),
/// I/O engine for all test caches.
        Bytes::copy_from_slice(data),
    let cache = FoyerCache::new(
    );
            .join(key_index_store::KEY_INDEX_FILENAME)
// ── Test helpers ──────────────────────────────────────────────────────────────
            IO_ENGINE,
            BLOCK_SIZE as u64,
        .used_bytes
    assert_eq!(
    assert!(
    assert_eq!(
}
    // The background sweeper handles truly-gone disk entries via inner.contains().
        serde_json::from_str(&contents).expect("key_index.json must be valid JSON");
}
fn get_returns_exact_bytes_that_were_put() {
        put_range(&cache, "/data/b.parquet", 0, 256, &vec![0u8; 256]);
#[test]
        TEST_BUFFER_POOL_SIZE,
    };
            .removed_count
        let result = unsafe { foyer_destroy_cache(ptr) };
    std::fs::write(dir.path().join(key_index_store::KEY_INDEX_FILENAME), b"").unwrap();
            .load(std::sync::atomic::Ordering::Relaxed),
    let (cache, _dir) = test_cache();
                .unwrap()
}
        .stats
    assert_eq!(
/// - Disk: 4 MB — small enough to keep parallel test disk I/O fast (~64× faster
        0,
        0.0, // threshold disabled
        "column index must hit"
    let data = vec![0xABu8; 1024];
        .extend(vec![fake1, fake2]);
        512 * 1024,
#[test]
    }
        dir.path()
        0.0,
fn tiered_cache_key_alignment_warmup_matches_query() {
                dir_str.len() as u64,
            }
            .load(std::sync::atomic::Ordering::Relaxed),
            .stats
    assert_eq!(
    let dir = TempDir::new().unwrap();
        cache
    let cache = FoyerCache::new(
/// and used_bytes must equal exactly 1× the entry size (not N× for N threads).
    let mut out = [0i64; 20];
/// CR-05 simulation: simulate a crash by using `std::mem::forget` to prevent Drop.
}
    });
        .load(std::sync::atomic::Ordering::Relaxed);
#[test]
    // Evictor: repeatedly evicts the same prefix — simulates a shard deletion racing
            .load(std::sync::atomic::Ordering::Relaxed),
    let (cache, _dir) = test_cache();
    assert_eq!(
        count, 1,
    assert!(!snap_exists, "key_index.json must be deleted by clear()");
        .stats
    // Parse and validate structure.
    let dir_str = dir.path().to_str().unwrap();
    std::fs::write(
fn sweep_threshold_runs_when_usage_at_or_above_threshold() {
/// between the 2nd and 3rd ticks when no puts happen.
    assert_eq!(removed1, 0, "no stale entries on first sweep");
    );
            0.0_f64,
            TEST_CACHE_DISK_BYTES,
    const TOTAL_WRITES: usize = 8;
        .unwrap_or(0);
    let destroy_rc = unsafe { foyer_destroy_cache(ptr) };
            .map(|k| format!("{prefix}\x1F{}-{}", k * 4096, (k + 1) * 4096))
        let cache2 = FoyerCache::new(
    let (cache, _dir) = test_cache();
        "key_index must contain exactly 1 entry after {} concurrent puts of the same key; got {}",
            .iter()
        TEST_SUBMIT_QUEUE_SIZE,
    drop(cache);
    tiered.put(&key, Bytes::from(vec![0x11; 4096]));
            1,
    assert!(result < 0);
fn active_bytes_guard_zero_value_is_noop() {
    assert_eq!(
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
        .extend(vec![fake1, fake2]);
                .exists()
    assert!(
            0.0_f64,
        0,
    assert_eq!(Arc::strong_count(boxed), 4, "1 (box) + 3 shards");
        let mtime_after = std::fs::metadata(dir.path().join(key_index_store::KEY_INDEX_FILENAME))
        "used_bytes must be > 0 after put"
    let s0 = range_cache_key("seg0/_0.parquet", 9000, 10000);
    use std::sync::atomic::AtomicI64;
    assert!(
        count_after_first, 1,
        Some(b"file_c".as_slice())
            0.0,
    cache.evict_prefix("/data/file.parquet");
    assert!(cache.key_index.contains_key("data/file.parquet"));
    // used_bytes counter is updated synchronously on put().
        false,
    // used_bytes must never go negative — that would indicate double-subtraction of stats.
    // 16 sweep calls — cursor increments on each (modulo 16 internally via fetch_add).
        TEST_BUFFER_POOL_SIZE,
        put_range(&cache, "/data/keep_me.parquet", 0, 512, &vec![0u8; 512]);
        "eviction_bytes must reflect 100 + 200 = 300 bytes for the two stale keys"
    let parsed: serde_json::Value =
        };
        512,
        TEST_SUBMIT_QUEUE_SIZE,
        used_after_v2 >= used_after_v1,
    let eviction_count_before = cache
        true,
        !dir.path()
        .stats
#[test]
    assert_eq!(
        TEST_BUFFER_POOL_SIZE,
    let dir = TempDir::new().unwrap();
        "threshold=1.0, usage=99.9%: sweep must be skipped"
/// The sum of key_byte_size for all recovered keys must equal used_bytes
    let writer = std::thread::spawn(move || {
    let engine = IO_ENGINE.as_bytes();
        cache.should_skip_sweep(),
        "used_bytes must not be negative after concurrent put/evict; got {}",
            .stats
    // Simulate: future cancelled (tokio::select! timeout or explicit drop).
    }
#[test]
        512 * 1024,
        0,
        dir.path(),
/// respond correctly to put() and get() operations — no functional regression.
        removed_count_after,
        .stats
const TEST_SUBMIT_QUEUE_SIZE: usize = 2 * 1024 * 1024; // 2 MB submit queue (≥ 2× buffer pool)
// ── put + get round-trip ──────────────────────────────────────────────────────
    let dir = TempDir::new().unwrap();
        .load(std::sync::atomic::Ordering::Relaxed);
        .get("data/b.parquet")
    cache.stats.used_bytes.store(
        b"{{corrupt}}",
    let (cache, _dir) = test_cache();
            native_bridge_common::error::native_error_free(-ptr);
    // Drop cancels token — persist task stops via `return` in cancelled() arm.
    assert!(block_on(cache.get(&range_cache_key("/data/target.parquet", 0, 100))).is_none());
    assert!(
        TEST_BUFFER_POOL_SIZE,
    put_range(&cache, "/data/file.parquet", 0, 100, b"real");
}
        Some(Bytes::from_static(b"new"))
                .metadata_cache()
}
    );
        TEST_CACHE_BLOCK_SIZE,
        .stats
    for i in 0u8..16 {
}
        TEST_CACHE_BLOCK_SIZE,
    put_range(&cache, "/data/c.parquet", 0, 100, b"file_c");
    assert!(
    );
    // usage = 99.9% → still below 100% → skip
    let (cache, _dir) = test_cache();
    // Create a fresh Foyer cache over the same dir. Foyer has no data for "data/stale.parquet".
fn concurrent_evict_and_put_does_not_panic() {
        TEST_SUBMIT_QUEUE_SIZE,
    let g1 = ActiveBytesGuard::new(&counter, 100);
        // Verify the content is valid (not just an empty file).
/// Set cursor to shard 0. After one sweep_once(), shard 0 is clean but shard 1 is untouched.
            std::fs::read_to_string(dir.path().join(key_index_store::KEY_INDEX_FILENAME)).unwrap();
        .join(crate::key_index_store::KEY_INDEX_FILENAME)
/// correctly iterates shards and removes all stale entries over multiple passes.
#[test]
    // Evict one shard — only that shard's entry must be removed.
}
        &vec![0u8; 256],
            .join(key_index_store::KEY_INDEX_FILENAME)
    let data = vec![0xABu8; 1024];
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
#[test]
            .load(std::sync::atomic::Ordering::Relaxed)
    assert_eq!(
}
        cache
    put_range(&cache, "/data/a.parquet", 0, 100, b"a");
    assert!(ptr > 0);
    );
#[test]
    }
    // Exact same range → hit
        "active_in_bytes must be 0 after get() completes"
        .load(std::sync::atomic::Ordering::Relaxed);
        Some(b"fresh".as_slice())
    // Extended version of sweep_once_removes_empty_prefix_buckets that also checks bytes.
        );
fn concurrent_put_and_get_same_file_does_not_panic() {
        IO_ENGINE,
        // Drop writes key_index.json with used_bytes=100.
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
    assert!(
/// - No panic or deadlock under concurrent load.
        let dir = TempDir::new().unwrap();
    }
}
    let (cache, _dir) = test_cache();
        let mtime_after_first =
    let used_after_v2 = cache
/// After the call the cursor is `preset + 1`.
    assert_eq!(
        "used_bytes must be > 0 after populating {NUM_PREFIXES} prefixes"
}
    assert_eq!(counter.load(std::sync::atomic::Ordering::Relaxed), 4096);
    // Evict first 50 prefixes.
    // Run enough sweeps to cover all shards.
    assert!(result < 0);
            0,
    cache.put(&key, Bytes::from(vec![0u8; 512]));
        assert!(ptr > 0);
            .sweep_cursor
            .active_in_bytes
            let cache = Arc::clone(&cache);
    let dir = TempDir::new().unwrap();
/// 100% triggers a skip.
/// 2. Query: DataFusion reads metadata → hit from metadata cache (probed first)
        1024
    }
    let result = unsafe { foyer_destroy_cache(0) };
            TEST_CACHE_DISK_BYTES,
}
            if dir
        );
                let mut s = std::collections::HashSet::new();
#[test]
    let result = unsafe { foyer_destroy_cache(ptr) };
/// (FFM `foyer_clear_cache` → `clear_sync`); the async `clear()` trait method
        TEST_BUFFER_POOL_SIZE,
            dir.path().join(key_index_store::KEY_INDEX_FILENAME),
fn large_value_round_trips_correctly() {
    put_range(&cache, "/data/crash.parquet", 0, 512, &vec![0u8; 512]);
        cache.key_index.len(),
/// This confirms cancel() was actually called and not skipped.
        cache
/// evict_prefix removes entries from both caches.
    assert_eq!(
            engine.len() as u64,
        0,
            (BLOCK_SIZE * 2) as u64,
    );
    assert_eq!(
            s.insert(key1);
/// startup. All prefix buckets and keys are present immediately after new().
    );
            BLOCK_SIZE,
    assert_eq!(
        if std::time::Instant::now() >= deadline {
/// 1. Shard init: warmup puts metadata via put_metadata()
/// Dropping a cache with sweep_interval_secs=0 (no sweep task) must not panic.
        TEST_CACHE_DISK_BYTES,
    );
        // Wait for first persist (sentinel fires on first tick).
    // DashMap hashes keys to one of N shards (N=64 on macOS); sweep_once() processes ONE shard
    );
    );
fn drop_with_active_sweep_task_does_not_panic() {
    assert_eq!(result, 0, "foyer_snapshot_stats must return 0 on success");
    assert!(
fn tiered_cache_full_datafusion_query_simulation() {
            0,
        Some(2_000_000)
            used_after_evict < 1024,
    // Therefore key_index must RETAIN all keys after DRAM eviction pressure.
            TEST_CACHE_DISK_BYTES,
fn active_in_bytes_is_zero_after_cache_miss() {
        0,
fn get_returns_none_for_unknown_key() {
    }
            (BLOCK_SIZE * 2) as u64,
    assert!(ptr < 0);
    );
        0,
    );
        0.0,
        "clear() must count 2 removed entries"
        used_bytes, RANGE_SIZE as i64,
    );
    // Drop cancels the token — the 'inner loop's cancelled() arm fires `return`.
        .entry("data/file.parquet".to_string())
        eviction_count_before + 1,
    let shards = cache.key_index.shards();
    // Interpret as Box<Arc<dyn BlockCache>> — if the pointer type is wrong this will crash.
        }
        .map(|v| v.len())
        cache.sweep_once();
// Design note: recovery uses bulk-load (no per-key inner.contains() validation).
            0.0,
                .unwrap();
            16 * 1024 * 1024,
    // Cache must be fully functional.
        0,
    assert!(
    };
/// parses cleanly, and contains every prefix that was inserted.
        "key_index.json must be written by Drop even when persist task is disabled"
const TEST_CACHE_BLOCK_SIZE: usize = 1 * 1024 * 1024; // 1 MB block size (must be ≤ disk)
    // Shrink the bound so the test stays small (no multi-MB allocations).
        Some(b"range1".as_slice())
            TEST_CACHE_BLOCK_SIZE,
    for (i, &v) in buf.iter().enumerate() {
    let dir = TempDir::new().unwrap();
}
        block_on(cache.get(&range_cache_key("/data/file.parquet", 0, 100))).as_deref(),
            "key_index.json must be written by persist task within 5s"
/// The previous approach created a brand-new `tokio::runtime::Runtime` for every single
}
        0.99,
}
use crate::traits::BlockCache;
        dir.path(),
    );
    );
        Some(b"range0".as_slice())
        .exists());
    // Cache must still be fully functional.
        false,
    assert!(block_on(tiered.get(&key)).is_none());
        .sweep_cursor
    for p in 0..NUM_PREFIXES {
        let cache = FoyerCache::new(
            .join(key_index_store::KEY_INDEX_TMP_FILENAME)
}
            128 * 1024 * 1024,
        r1.as_ref().map(|b| b.len()),
    // Second instance: recover from the snapshot.
        cache
/// Simulates exactly what the sweep task does when `reconcile_key_index` panics:
            engine.len() as u64,
/// immediately after new() — before any put() is called.
                .modified()
        .key_index
    put_range(&cache, "/data/file.parquet", 0, 100, b"before");
    );
        used
/// The key_index.json must NOT be written (or must be old) since Drop is skipped.
        .path()
        0,
        .unwrap_or(0);
            512,
    // 10 fields × 2 sections = 20 longs
    assert_eq!(
    const KEYS_PER_PREFIX: usize = 100;
    );
/// A corrupt key_index.json (invalid JSON) is treated as a clean startup.
        std::sync::atomic::Ordering::Relaxed,
        512 * 1024,
        256 * 1024,
    // 10 fields × 2 sections = 20 longs
        put_range(&cache, "/data/file.parquet", 0, 100, b"data");
    cache
        "key_index must be empty after stale keys are swept"
    assert!(!cache.key_index.contains_key("data/file.parquet"));
        0.0,
    tiered.put_metadata(&s1, Bytes::from_static(b"shard1"));
    // The watchdog outer loop must NOT re-enter because `return` exits the closure.
        0
        let cache = FoyerCache::new(
    {
    assert!(result.is_some());
    let g3 = ActiveBytesGuard::new(&counter, 300);
        block_on(cache.get(&range_cache_key("/data/a.parquet", 4096, 8192))).as_deref(),
        TEST_CACHE_DISK_BYTES,
}
        TEST_BUFFER_POOL_SIZE,
    cache.sweep_once();
            1,
        put_range(&cache, "/data/f.parquet", 100, 300, &vec![0u8; 200]);
use crate::key_index_store;
#[test]
        Bytes::from_static(b"meta"),
/// This test verifies:
    cache.put(&key, Bytes::from(vec![0u8; 512]));
    cache
            128 * 1024 * 1024,
        block_on(tiered.get(&footer_key)).as_deref(),
            .exists(),
/// put_metadata() skips entries larger than max_metadata_entry_size — oversized
            dir_str.len() as u64,
            "/data/big.parquet",
    let (cache, _dir) = test_cache();
    let key = range_cache_key("/data/file.parquet", 0, 512);
    let (cache, _dir) = test_cache();
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
            native_bridge_common::error::native_error_free(-ptr);
        TEST_CACHE_DISK_BYTES,
    put_range(
        .key_index
// ── Sweep threshold (should_skip_sweep) tests ─────────────────────────────────
        .load(std::sync::atomic::Ordering::Relaxed);
    }
    let tiered = TieredBlockCache::new(data_cache, metadata_cache);
    assert_eq!(removed2, 0, "no stale entries on second sweep");
            .stats
    block_on(cache.clear());
            mtime_after > mtime_before,
            dir.path()
            0,
        cache.key_index.is_empty(),
    cache
    let cache = FoyerCache::new(
            .get("data/big.parquet")
    // Save.
        "foyer_snapshot_stats with null out should return < 0, got {rc}"
        true,
        0,
    // Inject stale keys directly into shards 0 and 1.
    let shard_count = cache.key_index.shards().len();
    assert_eq!(index.len(), 2, "must have 2 prefix buckets");
    assert!(
    );
    put_range(&cache, "/data/a.parquet", 8192, 12288, b"range2");
    const KEYS_PER_PREFIX: usize = 100;
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
    assert!(block_on(tiered.get(&range_cache_key(path, 9000000, 10000000))).is_none());
        }
        "removed_count must increase after evict_prefix"
            512,
    let removed_count_after = cache
/// internally delegates to it.
        block_on(tiered.get(&key)).as_deref(),
    let (cache, _dir) = test_cache();
        TEST_SUBMIT_QUEUE_SIZE,
    for p in 0..NUM_PREFIXES {
        ".key_index.json.tmp must not exist after clean startup"
        "eviction_bytes must reflect both stale keys (100 + 100 = 200)"
    );
/// Presetting the cursor and calling sweep_once() must process shard `cursor % 16`.
            BLOCK_SIZE,
    assert_eq!(
/// expected outcome when a prefix is being deleted.
/// evict_prefix() followed by Drop: the evicted prefix must NOT appear in the
        r3.as_ref().map(|b| b.len()),
fn recovery_used_bytes_initialized_from_snapshot() {
        "foyer_snapshot_stats with ptr=0 should return < 0, got {rc}"
    }
    // agree — this keeps used_bytes accounting consistent between put() and evict_prefix().
    let data = b"hello foyer cache";
    // Clean up the Box.
            .stats
        .key_index
    let shard_count = cache.key_index.shards().len();
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
#[test]
    // Data cache untouched
/// the scan and the remove will have its entry included in the eviction — this is the
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
#[test]
        BLOCK_SIZE,
    );
    use tokio_util::sync::CancellationToken;
    let half = (TEST_CACHE_DISK_BYTES / 2) as i64;
    let removed = cache.sweep_once();
            .load(std::sync::atomic::Ordering::Relaxed),
            0,
            0,
        TEST_SUBMIT_QUEUE_SIZE,
/// count from O(tests × calls) to O(tests) — one per `FoyerCache` plus this one — making
    let loaded = key_index_store::load_or_empty(dir.path());
            0,
    }
            0,
        // Drop of cache2 writes an empty key_index.json (empty key_index after clear).
    cache.put(&key, Bytes::from_static(b"updated"));
        shards_with_entries,
        tiered.max_data_entry_size(),
    let used_before = cache
            0,
    // ── Query: data read → miss first time ───────────────────────────
    let (cache, _dir) = test_cache();
        Some(256),
    let (cache, _dir) = test_cache();
        .stats
// ── foyer_snapshot_stats tests ───────────────────────────────────────────────
// These tests build a 10k-entry key_index in-process (no OS cluster, no fd pressure).
    let stale_keys = [
            TEST_CACHE_DISK_BYTES,
        NUM_PREFIXES * KEYS_PER_PREFIX
    tiered.put_metadata(&footer_key, Bytes::from(vec![0xF; 10_000]));
/// evict half the prefixes, and verify used_bytes decrements correctly.
/// used_bytes is only incremented on the first (genuine) insert.
    let (cache, _dir) = test_cache();
    );
    // Busy-assert: poll until all TOTAL_WRITES keys appear in key_index or deadline expires.
            std::thread::spawn(move || {
    let (cache, _dir) = test_cache();
    let removed_bytes_before = cache
    let shard2_keys = index["data/nodes/0/shard2.parquet"].as_array().unwrap();
    let used_before = cache
        dir.path(),
        .key_index
        .or_default()
        put_range(&cache, "/data/kept.parquet", 0, 512, &vec![0u8; 512]);
    // used_bytes is a monotonically-increasing counter (total bytes ever inserted).
            let key = range_cache_key("/data/shared.parquet", i * 100, (i + 1) * 100);
    std::thread::sleep(std::time::Duration::from_millis(50));
    );
    // key_index.json does NOT exist yet (no periodic persist, Drop not called).
        &buf[10..],
            0,
        .stats
    );
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
    }
            dir_str.len() as u64,
    let (cache, _dir) = test_cache();
            TEST_BUFFER_POOL_SIZE,
        .load(std::sync::atomic::Ordering::Relaxed);
    let removed_count_before = cache
        .unwrap_or(0);
            .exists(),
        put_range(&cache, "/data/file.parquet", 0, 100, &vec![0u8; 100]);
            BLOCK_SIZE as u64,
    assert!(
            TEST_BUFFER_POOL_SIZE,
/// over the same dir — verify the key_index is bulk-loaded correctly.
        0, // sweep disabled
    // Data length matches the key range (100 bytes each) so key_byte_size() and data.len()
    assert!(block_on(tiered.metadata_cache().get(&footer_key)).is_some());
    );
    put_range(&cache, "/data/file.parquet", 0, 100, b"second");
    let result = block_on(cache.get(&range_cache_key("/data/file.parquet", 0, 100)));
        cache.key_index.contains_key("data/file.parquet"),
    let key1 = "stale_shard1\x1F0-200".to_string();
    // We don't spin up an actual cache for the "first session" here because
    let eviction_bytes_after_2 = cache
    let eviction_bytes_after_1 = cache
        .stats
    assert!(
fn sweep_task_catch_unwind_does_not_kill_loop_on_panic() {
        .stats
    );
            10,
#[test]
#[test]
        );
fn sweep_threshold_one_skips_unless_completely_full() {
    };
        !cache.key_index.contains_key("data/bad.parquet"),
    // disk=1MB, block_size=256KB (256KB ≤ 1MB — Foyer invariant satisfied).
        cache.key_index.len(),
    assert_eq!(
        let cache1 = FoyerCache::new(
        Some(b"footer".as_slice()),
    let exact = ((TEST_CACHE_DISK_BYTES as f64 * 0.75) as i64);
    let shard_count = cache.key_index.shards().len();
                .data_cache()
}
        assert_eq!(
/// foyer_create_cache returns a fat Box<Arc<dyn BlockCache>> pointer.
    let result = block_on(cache.get(&key));
        let ptr = unsafe {
        .key_index
        block_on(tiered.data_cache().get(&small_key)).is_some(),
            BLOCK_SIZE * 2,
                break;
            0.0,
}
        assert!(
        dir.path(),
    let removed_bytes_before = cache
            .exists(),
    assert!(
        let deadline = std::time::Instant::now() + std::time::Duration::from_secs(5);
            dir_str.as_ptr(),
    assert_eq!(
/// Verify the design contract: `last_persisted` is reset to `i64::MIN` at the top
fn recovery_key_index_bulk_loaded_after_graceful_shutdown() {
    assert!(
    // ── Query: metadata reads → hit (metadata cache probed first) ────
        .load(std::sync::atomic::Ordering::Relaxed);
        !cache2.key_index.contains_key("data/evicted.parquet"),
        ("data/beta.parquet", "data/beta.parquet\x1F0-200"),
    cache.evict_prefix("/data/target.parquet");
        "cursor must be 6 (5+1) after one sweep from preset 5"
                .unwrap()
            std::fs::metadata(dir.path().join(crate::key_index_store::KEY_INDEX_FILENAME))
 * The OpenSearch Contributors require contributions made to
            std::thread::spawn(move || {
    );
        while !dir
        let keys: HashSet<String> = (0..KEYS_PER_PREFIX)
        cache.put(&key, Bytes::copy_from_slice(&chunk));
    // Simulate crash: forget the cache — Drop is NOT called.
        0,
/// The sweep task holds a cloned CancellationToken; cancel() unblocks it from
    // Second put with same key (simulates cache stampede or re-put after eviction).
}
        removed_before,
    );
    let dyn_cache: &dyn crate::traits::BlockCache = &cache;
    // Both prefix buckets must be present immediately after new().
    assert!(
        )
        dashmap::SharedValue::new({
        "active_in_bytes must be 0 after a cache miss"
    cache.put(
/// Simulates exactly what the persist task does when `key_index_store::save` panics.
        dir.path(),
    );
    // Inject one unique stale key per shard directly via raw shard access.
        false,
/// 4. Query 2: same data → hit from data cache
        0,
        &vec![0u8; 512],
}
    );
        .key_index
    assert!(cache.key_index.contains_key("data/file.parquet"));
        if count >= TOTAL_WRITES || std::time::Instant::now() >= deadline {
    );
    let total_keys: usize = loaded.index.values().map(|v| v.len()).sum();
        cache.key_index.is_empty(),
            0,
#[test]
        Bytes::from_static(b"data"),
        TEST_CACHE_DISK_BYTES,
/// first (miss) then data cache (miss) — both miss, returns None. Caller goes to S3.
        false,
        0.0,
/// sweep_once() ignores the threshold — it calls reconcile_key_index directly.
    cache.put(&key, Bytes::from(vec![0u8; 1024]));
        &range_cache_key(path, 0, 1_000_000),
            dir_str.len() as u64,
                break false;
    put_range(&cache, "/data/file.parquet", 0, 100, &vec![0u8; 100]);
    }));
    assert!(
    tiered.put_metadata(
    let dir = TempDir::new().unwrap();
        ("data/alpha.parquet", "data/alpha.parquet\x1F0-100"),
    let shards_with_entries = shards.iter().filter(|s| !s.read().is_empty()).count();
        TEST_BUFFER_POOL_SIZE,
    }
use crate::range_cache::range_cache_key;
    cache
        foyer_create_cache(
/// which modulo shard_count == 0 (back to shard 0).
            false,
        eviction_bytes_before,
            .load(std::sync::atomic::Ordering::Relaxed),
    assert_eq!(shard1_keys.len(), 2, "shard1 must have 2 keys");
        }
}
    let removed_after = cache
            TEST_CACHE_BLOCK_SIZE,
        TEST_BUFFER_POOL_SIZE,
        // Record mtime after first persist.
    assert!(block_on(tiered.metadata_cache().get(&col_a_key)).is_none());
#[test]
    let counter = AtomicI64::new(42);
        0.0,
        )
    // foyer_snapshot_stats expects a Box<Arc<dyn BlockCache>> pointer, not Arc<FoyerCache>.
                .modified()
        Some(b"file_b".as_slice())
    {
        "usage=100% > threshold=75%: sweep must NOT be skipped"
    // DashMap defaults to 64 shards on macOS; we must sweep at least shard_count times.
#[test]
            .load(std::sync::atomic::Ordering::Relaxed),
        .stats
    assert!(!dir
        for _ in 0..50 {
        .map(|_| {
    for i in 0..20 {
    assert!(
fn persist_task_with_active_watchdog_stops_cleanly_on_cancel() {
        0,
fn sweep_cursor_advances_by_one_per_call() {
/// even after a brief sleep, and the cache remains usable.
        );
    // used_bytes must NOT be incremented again.
            false,
        let appeared = loop {
    let data_misses_before = tiered.data_cache().stats.miss_count.load(Ordering::Relaxed);
    let boxed = unsafe { &*(ptr as *const Arc<dyn BlockCache>) };
        // Wait 2 seconds — file must NOT appear (no persist task).
    );
        .load(std::sync::atomic::Ordering::Relaxed);
        0,
fn evict_prefix_does_not_affect_other_files() {
    let footer_key = range_cache_key(path, 9_990_000, 10_000_000);
        std::sync::atomic::Ordering::Relaxed,
    let counter = AtomicI64::new(0);
        "data entry exceeding max_data_entry_size must not be cached"
    assert_eq!(
fn evict_prefix_updates_removed_bytes_and_used_bytes() {
    );
        &buf[..10],
    for i in 0u64..TOTAL_WRITES as u64 {
#[test]
            .stats
/// indefinitely waiting for thread allocation.
    let fake1 = "data/gone.parquet\x1F0-100".to_string();
            .unwrap_or(0);
    );
fn persist_task_does_not_fire_when_cache_idle() {
#[test]
/// Stale entries in the recovered snapshot (keys that Foyer did not recover due
        for i in 0..ITERATIONS {
    // Inject a malformed stale key — no separator, Foyer has never seen it.
        .stats
    );
    {
    assert_eq!(result.as_deref(), Some(b"fresh".as_slice()));
fn tiered_test_cache() -> (TieredBlockCache, TempDir, TempDir) {
/// The cache starts with an empty key_index and is fully functional.
            IO_ENGINE,
fn put_range(cache: &FoyerCache, path: &str, start: u64, end: u64, data: &[u8]) {
        )
        total_keys,
        cache
    });
        use std::collections::{HashMap, HashSet};
use crate::foyer::foyer_cache::ActiveBytesGuard;
        TEST_CACHE_DISK_BYTES,
    let (cache, _dir) = test_cache();
}
    {
        dash.insert(prefix, keys);
        false,
        };
            0.0_f64,
    //
        false,
        let keys: HashSet<String> = (0..KEYS_PER_PREFIX)
    // Before get(): active_in_bytes must be 0.
/// Multiple guards at the same time accumulate correctly and each restores its
    )
    );
        while !dir
/// from the snapshot — not just entries added in the current session.
#[test]
        0,   // no persist task
        false,
        "used_bytes must be decremented by freed bytes when sweeper removes stale entries"
    );
        .insert(fake_key.clone());
    let raw_ptr = Box::into_raw(boxed) as i64;
    );
        Some(b"shard1".as_slice())
                s.insert(key);
/// exactly one shard's stale key is removed; all other shards still have their stale key.
        BLOCK_SIZE * 2,
    // "data/f.parquet\x1F100-300" → 200 bytes
    assert_eq!(result.as_deref(), Some(b"updated".as_slice()));
        "zero-byte snapshot must produce empty key_index (clean startup)"
        .load(std::sync::atomic::Ordering::Relaxed);
    let engine = IO_ENGINE.as_bytes();
    // decrement used_bytes.
        )
    // clear() calls key_index_store::delete() which removes the file.
        true,
    // Write an empty file.
        .used_bytes
/// used_bytes is 0, cache is fully functional.
/// to LRU eviction before the last persist) are cleaned up by sweep_once().
        used >= 0,
        true,
    // Create a second cache and call clear().
    // we need to inject keys that Foyer will not have recovered.
    );
    let ptr = unsafe {
    assert!(
        false,
    }
    {
        .or_default()
            0,
            TEST_SUBMIT_QUEUE_SIZE,
}
        0,
    );
    );
        std::thread::sleep(std::time::Duration::from_millis(20));
    let dir_str = dir.path().to_str().unwrap();
        0
    );
            &cache,
    // Simulate 3 shards each cloning the Arc (as ts_create_tiered_object_store would).
    // (not 2), because HashSet::insert is idempotent for duplicate keys.
        "active_in_bytes must be 0 before any get()"
        "used_bytes must decrease by 300 when stale keys are swept"
        .stats
    put_range(&cache, "/data/other.parquet", 0, 100, b"other");
        0,
    let cache = FoyerCache::new(
        // Direct shard write bypasses DashMap's hashing — we control exactly which shard gets the key.
        }
        Bytes::from_static(b"data"),
    assert!(
            std::thread::sleep(std::time::Duration::from_millis(100));
    let (cache, _dir) = test_cache();
        &cache,
    );
/// Populate 10k entries, call clear(), verify the key_index is empty and
    let removed_bytes_after = cache
    let cache2 = FoyerCache::new(
/// Dropping a cache with an active sweep task must not panic.
        IO_ENGINE,
    {
#[test]
#[test]
            (BLOCK_SIZE * 2) as u64,
fn active_bytes_guard_drop_on_cancellation_restores_counter() {
            .used_bytes
// ── Background sweeper tests ──────────────────────────────────────────────────
        .load(std::sync::atomic::Ordering::Relaxed);
            .join(key_index_store::KEY_INDEX_FILENAME)
        0,
        block_on(tiered.get(&col_a_key)).as_deref(),
    let r3 = block_on(cache.get(&range_cache_key("/data/new.parquet", 0, 256)));
    );
        snap[6], 1024,
            BLOCK_SIZE as u64,
    );
}
        "removed_bytes: 100 + 200 = 300"
    let (cache, _dir) = test_cache();
    );
    assert_eq!(removed, 1, "only the stale key in shard 0 must be removed");
        counter.load(std::sync::atomic::Ordering::Relaxed),
        IO_ENGINE,
/// VM-03: zero-byte key_index.json → treated as corrupt → clean startup.
    );
#[test]
    cache
    let handles: Vec<_> = (0..THREAD_COUNT)
            dir_str.as_ptr(),
#[test]
    let (cache, _dir) = test_cache();
    put_range(&cache, "/data/file.parquet", 0, 100, &vec![0u8; 100]);
    drop(cache);
        .map(|v| v.len())
    );
    assert!(!dir
            TEST_CACHE_BLOCK_SIZE,
    // Cache is still usable.
                let key = range_cache_key("/data/shared.parquet", 0, RANGE_SIZE);
    put_range(&cache, "/data/keep.parquet", 0, 512, &vec![0xAAu8; 512]);
    // Build a DashMap with 100 prefixes × 100 keys = 10k entries.
    cache.sweep_once(); // processes shard (shard_count - 1), cursor becomes shard_count
        block_on(cache.get(&range_cache_key("/data/target.parquet", 0, 4096))),
            .stats
    put_range(&cache, "/data/a.parquet", 0, 100, &vec![0u8; 100]);
    let result = block_on(cache.get(&range_cache_key("/data/file.parquet", 0, 100)));
    // Run enough sweeps to guarantee the shard containing "data/mixed.parquet" is processed.
        &out[0..10],
    }
            .fetch_add(byte_size, std::sync::atomic::Ordering::Relaxed);
        false,
#[test]
        // Wait 2s for the first persist tick.
    assert_eq!(removed, 1, "stale malformed key must be removed");
    );
    assert_eq!(removed, 0);
        block_on(tiered.get(&small_key)).map(|b| b.len()),
        .get("data/file.parquet")
    );
#[test]
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
/// clear_sync() empties both tiers. This is the production entry point
///
use bytes::Bytes;
fn recovery_evict_prefix_works_on_recovered_keys() {
    assert_eq!(
        .stats
    });
    // Persist first so there's a file to delete.
    let dir = TempDir::new().unwrap();
    );
    assert!(
fn concurrent_stampede_same_key_does_not_duplicate_key_index() {
/// With the old Vec approach, two puts added `size` to used_bytes twice even though
        cache
        let snap = key_index_store::KeyIndexSnapshot { version: 1, index };
    let r2 = block_on(cache.get(&range_cache_key("/data/keep.parquet", 512, 1024)));
            .path()
        cache.key_index.is_empty(),
/// persisted snapshot and therefore must NOT be loaded on the next startup.
        std::thread::sleep(std::time::Duration::from_millis(3000));
        TEST_CACHE_DISK_BYTES as i64,
fn test_cache() -> (FoyerCache, TempDir) {
    );
            dashmap::SharedValue::new({
        .stats
            break count;
            0,
    assert!(
    assert_eq!(Arc::strong_count(&*boxed), 2);
    let counter = AtomicI64::new(0);
    // get() finds it — no re-registration needed (metadata cache probed first)
            128 * 1024 * 1024,
    // Simulate the persist task catch_unwind.
fn active_in_bytes_is_zero_before_and_after_get() {
#[test]
            0,
    assert_eq!(
    // After Drop, key_index.json must exist.
        dir.path(),
        }),
    assert_eq!(
fn sweep_once_removes_stale_keys_and_updates_eviction_count() {
        .insert(stale_key.clone());
        "key must appear exactly once in key_index after overwrite (HashSet dedup); got {}",
    put_range(&cache, "/data/target.parquet", 0, 4096, b"range0");
/// When sweep_threshold_ratio == 0.0 (disabled), should_skip_sweep() must always
        .store(0, std::sync::atomic::Ordering::Relaxed);
    let cache = FoyerCache::new(
fn foyer_cache_put_metadata_default_routes_to_put() {
}
#[test]
    // A key without a parseable range (key_byte_size returns 0) must still be
/// Verify that `catch_unwind` correctly catches a panic in the persist path.
            0.0,
        // Drop writes key_index.json.
            (BLOCK_SIZE * 2) as u64,
///
            TEST_SUBMIT_QUEUE_SIZE,
        removed, 0,
    let dir = TempDir::new().unwrap();
            BLOCK_SIZE as u64,
        let keys: HashSet<String> = (0..KEYS_PER_PREFIX)
    const KEYS_PER_PREFIX: usize = 100;
        0
        .stats
}
        0,
        "used_bytes must not decrease on overwrite"
        300,
            IO_ENGINE,
    );
#[test]
/// Verify that `catch_unwind` correctly catches a panic without propagating it.
        ("data/delta.parquet", "data/delta.parquet\x1F0-400"),
    // Writes 4 × 512KB = 2MB total into a 2MB cache to exercise near-capacity behaviour.
/// Multiple shards — evicting one doesn't affect others.
    }
        .stats
    assert!(block_on(tiered.get(&range_cache_key(path, 0, 1000000))).is_none());
        let cache = FoyerCache::new(
/// clear() deletes key_index.json so the next startup does not load stale keys.
    assert_eq!(
                let key = range_cache_key(&format!("/data/file_{}.parquet", i), 0, 1024);
    let dir = TempDir::new().unwrap();
}
        0.0,
            (BLOCK_SIZE * 2) as u64,
            let key = range_cache_key("/data/shared.parquet", i * 100, (i + 1) * 100);
#[test]
    assert!(!cache.key_index.contains_key("data/gone.parquet"));
    );
    // usage = 50% → below 75% → skip
}
            .entry(prefix.to_string())
        0.0,  // threshold disabled
    // Clear via the public async API.
    assert!(
    );
        .entry("data/mixed.parquet".to_string())
        .sweep_cursor
    assert!(
        used_after < used_before,
        TEST_BUFFER_POOL_SIZE,
        );
        NUM_PREFIXES / 2,
}
    block_on(cache.clear());
fn get_returns_none_for_wrong_range_on_known_path() {
#[test]
        0,
    cache.evict_prefix("/data/file.parquet");
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
    let (cache, _dir) = test_cache();
    let cache = FoyerCache::new(
        .removed_bytes
        .key_index
        })
            0,
fn sweep_threshold_skips_when_usage_below_threshold() {
    // On startup, no .tmp should be created or left behind.
        .store(5, std::sync::atomic::Ordering::Relaxed);
fn tiered_cache_put_routes_to_data_cache() {
            0.0,
    // Next startup: key_index starts empty (clean startup path).
        .map(|v| v.len())
            std::ptr::null(),
        dir.path(),
    const NUM_PREFIXES: usize = 100;
        dir.path()
    // Guard drops here — must restore counter to 0 even without the async block completing.
        "clear() must count 100 + 200 = 300 removed bytes"
fn drop_cancels_the_token() {
        .stats
    let evictor = std::thread::spawn(move || {
    use crate::traits::BlockCache;
    assert_eq!(
            dir.path(),
        .removed_count
    let key = range_cache_key("/data/file.parquet", 0, 100);
        cache.evict_prefix("/data/file.parquet");
            "data/stale.parquet".to_string(),
    assert_eq!(
    let before_count = cache
/// Verify that the persist task with the watchdog outer loop stops cleanly
    let dir = TempDir::new().unwrap();
            let cache = Arc::clone(&cache);
        "all {} keys must remain in key_index after DRAM eviction (entries still on disk); got {}",
        }
        .load(std::sync::atomic::Ordering::Relaxed);
    std::thread::sleep(std::time::Duration::from_millis(100));
    let cache = FoyerCache::new(
    let dir = TempDir::new().unwrap();
        cache2.key_index.contains_key("data/a.parquet"),
    let destroy_rc = unsafe { foyer_destroy_cache(ptr) };
    );
            .map(|k| crate::range_cache::key_byte_size(k))
    let mut buf = [0i64; 14];
/// key_index.json is deleted.
    put_range(&cache, "/data/a.parquet", 4096, 8192, b"range1");
/// - `used_bytes` is never negative (double-subtraction would indicate stat corruption).
    );
    // disk = 4MB, threshold = 0.75 (75%)
    cache
            .stats
        dir.path(),
                .get(&range_cache_key(path, 9_000_000, 10_000_000))
        let deadline = std::time::Instant::now() + std::time::Duration::from_secs(5);
}
    assert_eq!(cache.key_index.len(), 4, "4 prefix buckets injected");
    let snap = cache.stats.snapshot();
    put_range(&cache, "/data/b.parquet", 0, 100, b"file_b");
#[test]
    // Put something so the sweep has a non-trivial key_index to process.
    let path = "seg0/_0.parquet";
        "removed_count: 2 entries evicted"
        "persist task must have written key_index.json before drop"
// These tests exercise the independent persist task that flushes the key_index
/// When sweep_interval_secs>0, the background task is spawned and the cache
///   entry) while staying well under the 4 MB disk cap.
    // disk=2MB ≥ block_size=512KB (Foyer invariant: block_size ≤ disk).
        h.join().expect("thread panicked");
    let (cache, _dir) = test_cache();
    );
    let cache = FoyerCache::new(
            dir.path(),
        cache.sweep_once();
            std::fs::metadata(dir.path().join(key_index_store::KEY_INDEX_FILENAME))
    assert_eq!(
    let cache = FoyerCache::new(
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
        removed_count_before + 2,
        0,
        cache.should_skip_sweep(),
    );
        .join(key_index_store::KEY_INDEX_FILENAME)
        dir.path(),
        TEST_CACHE_BLOCK_SIZE,
        .load(std::sync::atomic::Ordering::Relaxed);
    let engine = IO_ENGINE.as_bytes();
    cache.put(&key, Bytes::from(vec![0u8; 1024]));
        TEST_CACHE_BLOCK_SIZE,
    assert!(ptr > 0);
        .used_bytes
        128 * 1024 * 1024,
        "second range must still be readable after sweep"
}
    let above = ((TEST_CACHE_DISK_BYTES as f64 * 0.90) as i64);
        "threshold=1.0, usage=100%: sweep must NOT be skipped"
        IO_ENGINE,
/// causing double-counting in removed_bytes and eviction_bytes.
        0,
    // Foyer is currently disk-only (single tier): overall == block_level.
    );
            BLOCK_SIZE as u64,
        remaining, 1,
/// not asserted — both outcomes are valid per the method's documented behaviour.
            .stats
    let (cache, _dir) = test_cache();
/// Key alignment: exact range match = hit, subset/superset = miss.
        "clear() on empty cache must not increment removed_count"
        TEST_SUBMIT_QUEUE_SIZE,
// ── Periodic persist task tests ──────────────────────────────────────────────
// ── TieredBlockCache tests ──────────────────────────────────────────────────────
            TEST_SUBMIT_QUEUE_SIZE,
/// when the cancellation token fires. Uses a short 1-second interval so
    cache2.evict_prefix("/data/shard1");
        cache.should_skip_sweep(),
    }
        block_on(cache.get(&range_cache_key("/data/c.parquet", 0, 100))).as_deref(),
        TEST_CACHE_BLOCK_SIZE,
/// and dropped. This test creates two sequential caches in the same temp dir
                .modified()
/// get() checks metadata cache first — so on warm restart (Foyer recovered
}
        key_count, TOTAL_WRITES,
    // Foyer's async flusher writes to disk asynchronously after put(); we wait for it
    cache.evict_prefix("/data/target.parquet");
#[test]
fn replace_event_key_index_retains_entry() {
/// The cursor sweep correctly updates eviction_bytes when removing stale keys.
        1024 * 1024,
        "must have {expected_total} total keys"
    // After clear() the key_index.json is deleted; Drop will write an empty one.
            TEST_SUBMIT_QUEUE_SIZE,
//
        // cache is dropped here — Drop also writes a final snapshot
    assert!(block_on(cache.get(&range_cache_key("/data/file.parquet", 0, 99))).is_none());
    }
            .load(std::sync::atomic::Ordering::Relaxed),
        300,
        let dir_str = dir.path().to_str().unwrap();
    let mut total_removed = 0usize;
        1, // 1-second persist interval
    let (cache, _dir) = test_cache();
///
        0,
    cache.put(&key, Bytes::copy_from_slice(&data));
        .store(0, std::sync::atomic::Ordering::Relaxed);
    assert_eq!(result.as_ref().map(|b| b.len()), Some(512));
    cache.put(&key, Bytes::from(vec![0xFFu8; 1024]));
        cache.evict_prefix("/data/evict_me.parquet");
            IO_ENGINE,
        TEST_CACHE_BLOCK_SIZE,
    );
        used_before
            .used_bytes
            0.0,
        IO_ENGINE,
            .used_bytes
        shard_count - 1
    assert!(block_on(tiered.get(&s0)).is_none());
}
fn sweep_task_with_active_watchdog_stops_cleanly_on_cancel() {
        BLOCK_SIZE,
#[test]
        0,
        dir.path(),
#[test]
/// Cache remains fully functional (put/get/evict/clear) after having been used
    // Range: 99999-100000 → 1 byte, parseable by key_byte_size().
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
fn no_tmp_file_left_after_graceful_shutdown() {
/// own contribution when dropped.
/// metadata SSD), metadata is found without any re-registration.
        TEST_CACHE_BLOCK_SIZE,
    );
        .store(0, std::sync::atomic::Ordering::Relaxed);
        shards[i].write().insert(
}
#[test]
///
        assert!(!index.is_empty(), "snapshot must contain the put() entries");
    assert!(
        unsafe {
        put_range(&cache, "/data/periodic.parquet", 0, 512, &vec![0u8; 512]);
            .map(|k| format!("{prefix}\x1F{}-{}", k * 4096, (k + 1) * 4096))
/// The CancellationToken.cancel() call in Drop is safe even when no task holds
        cache.evict_prefix("/data/evicted.parquet");
    }
    let key = range_cache_key("/data/shard.parquet", 999_000, 999_100);
            0.0, // threshold disabled
            TEST_CACHE_BLOCK_SIZE,
            (BLOCK_SIZE * 2) as u64,
            TEST_BUFFER_POOL_SIZE,
/// the closure panics, `catch_unwind` returns `Err`, and the cache stays usable.
            .used_bytes
}
        // persist_interval=0: only Drop persists.
        counter.load(std::sync::atomic::Ordering::Relaxed),
}
    assert_eq!(
}
        let keys: HashSet<String> = (0..KEYS_PER_PREFIX)
    let key = range_cache_key("/data/file.parquet", 0, 100);
        }
        IO_ENGINE,
#[test]
    for h in handles {
    });
    assert!(
    }
            ["data/stale.parquet\x1F0-512".to_string()].into(),
    assert!(
    cache
    }
        .load(std::sync::atomic::Ordering::Relaxed);
        .unwrap_or(0);
    // Real key is still in key_index.
    let cache = FoyerCache::new(
        cache2.key_index.contains_key("data/b.parquet"),
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
            TEST_CACHE_BLOCK_SIZE,
    assert!(block_on(tiered.data_cache().get(&footer_key)).is_none());
        TEST_CACHE_BLOCK_SIZE,
            s
    let (cache, _dir) = test_cache();
 *
        }
        0.75,
    tiered.put(&small_key, Bytes::from(vec![0xCD; 1024])); // 1KB <= 2KB → cached
}
        TEST_CACHE_DISK_BYTES,
    assert!(
            dir.path(),
        0,
        0,
    assert!(block_on(cache.get(&range_cache_key("/data/a.parquet", 0, 100))).is_none());
            128 * 1024 * 1024,
    // Section 0 (indices 0–9) and section 1 (indices 10–19) must be identical.
        let contents =
            "first persist must have fired"
        false,
            let mut s = std::collections::HashSet::new();
    let key = range_cache_key("/data/file.parquet", 0, 512);
    }
        "key_index must be empty after all stale keys are swept"
fn put_same_key_twice_does_not_duplicate_key_index_entry() {
        IO_ENGINE,
        IO_ENGINE,
            0.0,
    );
    );
/// Shared Tokio runtime for all `block_on()` calls in tests.
        0,
fn ffm_create_returns_positive_pointer() {
        let mtime_after_idle =
fn sweep_once_removes_empty_prefix_buckets_and_updates_eviction_bytes() {
    ));
fn recovery_stale_snapshot_keys_cleaned_by_sweep() {
        IO_ENGINE,
    let key = range_cache_key("seg0/_0.parquet", 5000000, 6000000);
        .load(std::sync::atomic::Ordering::Relaxed);
    assert_eq!(
        .stats
    assert_eq!(
    );
            .load(std::sync::atomic::Ordering::Relaxed),
#[test]
    assert_eq!(
/// after enough sweep_once() cycles. This test verifies the cursor-based sweep
        .load(std::sync::atomic::Ordering::Relaxed);
        // Record mtime written by Drop of session 1.
    const NUM_PREFIXES: usize = 100;
    // Inject a fake stale key for the same prefix — Foyer has never seen this key.
        block_on(tiered.get(&big_key)).is_none(),
                .sweep_cursor
            .collect();
            0,
            json.as_bytes(),
        // Drop writes key_index.json.
        0.0,
        cache2.key_index.contains_key("data/shard2/file.parquet"),
        .used_bytes
            1,   // persist every 1 second
}
    // Reaching here means the task stopped cleanly.
        -300,
#[test]
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
    // Real entries must still be retrievable after sweep.
        dir.path(),
    assert_eq!(
    cache.evict_prefix("/data/file.parquet");
            0,
    drop(guard);
            IO_ENGINE,
    reader.join().expect("reader panicked");
#[test]
    assert_eq!(
        r2.as_ref().map(|b| b.len()),
    assert!(
        .unwrap_or(0);
#[test]
/// After recovery, evict_prefix() correctly removes entries that were loaded
            .join(key_index_store::KEY_INDEX_TMP_FILENAME)
    let data_hits_before = tiered.data_cache().stats.hit_count.load(Ordering::Relaxed);
    // First put: key must be added to key_index.
            TEST_SUBMIT_QUEUE_SIZE,
        )
}
            .used_bytes
fn tiered_cache_total_miss_returns_none() {
#[test]
        .load(std::sync::atomic::Ordering::Relaxed);
            evictor_cache.evict_prefix("/data/shard.parquet");
        );
///
    {
fn snapshot_stats_returns_zero_for_fresh_cache() {
    assert_eq!(removed, 2);
#[test]
    put_range(&cache, "/data/file.parquet", 0, 100, b"data");
                .join(key_index_store::KEY_INDEX_FILENAME)
            .stats
    );
    // Third instance: must start with an empty key_index (clear deleted the stale snapshot).
        TEST_CACHE_DISK_BYTES,
        cache
// ── disk / capacity cases ─────────────────────────────────────────────────────
        Some(b"old_footer".as_slice())
        0,
        // Poll for key_index.json to appear (written by the persist task, not Drop).
            dir_str.as_ptr(),
    put_range(&cache, "/data/b.parquet", 0, 100, b"b");
        "stale key must be gone after sweep"
    let (cache, _dir) = test_cache();
    // Let the sweep fire at least once.
    // Both sections are identical (single-tier: overall mirrors block_level).
    let meta_dir = TempDir::new().expect("metadata temp dir");
    put_range(&cache, "/data/target.parquet", 0, 100, b"data");
        cache
    };
    assert_eq!(
    assert_eq!(counter.load(std::sync::atomic::Ordering::Relaxed), 42);
        let cache = FoyerCache::new(
    cache.evict_prefix("/data/other.parquet");
    let engine = IO_ENGINE.as_bytes();
        "used_bytes should be 1024 after a single 1KB put"
/// Even when should_skip_sweep() returns true, sweep_once() still sweeps.
    let (cache, _dir) = test_cache(); // sweep_interval_secs=0
        .eviction_bytes
            .collect();
            TEST_BUFFER_POOL_SIZE,
        .sweep_cursor
fn zero_byte_snapshot_file_treated_as_corrupt() {
/// A single-tier FoyerCache (metadata_cache_ratio=0) inherits the
        put_range(
        0,
    }
    let removed_before = cache
    let cache = Arc::new(cache);
}
        true,
/// PP-01 / PP-06: persist task starts when interval > 0 and is absent when interval = 0.
}
/// This validates that the guard integrates correctly with the full cache.
/// PP-06: persist disabled when interval=0 — no persist task spawned.
    let (cache, _dir) = test_cache();
            0.0,
    put_range(&cache, "/data/target.parquet", 4096, 8192, b"range1");
        cache
    let cache = Arc::new(cache);
            TEST_BUFFER_POOL_SIZE,
    assert_eq!(
                .get(&range_cache_key(path, 0, 1_000_000))
}
    // Inject stale keys under several different prefixes (they will hash to different shards).
        .exists();
    let result = block_on(cache.get(&key));
        .used_bytes
        cache
        for i in 0u64..50 {
    shards[0].write().insert(
    use dashmap::DashMap;
        // Drop is called here — final persist happens.
        TEST_BUFFER_POOL_SIZE,
        "eviction_bytes must not change for malformed (size=0) key"
            let key = range_cache_key("/data/shard.parquet", i * 100, (i + 1) * 100);
            TEST_CACHE_DISK_BYTES,
        0,
        "key_index.json must not exist after simulated crash (Drop skipped)"
    // If a sweep task were running it might prune entries, but since sweep=0
    assert_eq!(
}
    if result < 0 {
        0.0,
            IO_ENGINE,
        .stats
        assert!(!cache.key_index.contains_key("data/evicted.parquet"));
    block_on(cache.clear());
        0.0,
        raw,
        "data miss on first access"
    assert!(result.is_err(), "catch_unwind must catch the panic");
        "usage=74.9% < threshold=75%: sweep must be skipped"
fn ffm_destroy_with_zero_ptr_returns_error() {
        cache
        block_on(tiered.get(&range_cache_key("seg0/_0.parquet", 8_000_000, 8_500_000))).is_some()
        .get("data/mixed.parquet")
                .unwrap()
    assert_eq!(
    assert_eq!(
    put_range(&cache, "/data/keep.parquet", 512, 1024, &vec![0xBBu8; 512]);
            dir_str.as_ptr(),
    let used_after_v1 = cache
        "should have 1 live + 1 stale key before sweep"
    );
    assert!(cache2.key_index.contains_key("data/shard1/file.parquet"));
            TEST_SUBMIT_QUEUE_SIZE,
/// active_in_bytes is 0 before a get(), positive during, and 0 after.
    );
        0.0,
    // Event::Evict fires when an entry leaves the 1-byte DRAM tier and is written to disk.
    let eviction_bytes_before = cache
    let result = block_on(cache.get(&key));
/// On the next startup, the cache recovers from whatever was last periodically persisted
    let removed = cache.sweep_once();
///   init than 64 MB), large enough for all non-capacity-pressure tests.
    // Also inject a fake stale key.
}
fn snapshot_stats_returns_error_for_invalid_ptr() {
        // persist_interval=1s
            TEST_BUFFER_POOL_SIZE,
        IO_ENGINE,
fn clear_on_empty_cache_is_safe() {
    if ptr < 0 {
/// Stale keys injected across multiple prefix buckets are all eventually removed
    assert_eq!(counter.load(std::sync::atomic::Ordering::Relaxed), 600);
    let b_count = cache2
#[test]
            false,
fn sweep_once_processes_exactly_one_shard() {
fn sweep_once_returns_zero_when_all_entries_still_on_disk() {
    put_range(&cache, "/data/target.parquet", 0, 4096, b"new");
    cache.put(&key, Bytes::from_static(b"original"));
            !dir.path()
    let dir = TempDir::new().unwrap();
    {
            cache
#[test]
        .get("data/file.parquet")
            "used_bytes must decrease after evict"
/// Verify that the sweep task with the watchdog outer loop stops cleanly
}
            (BLOCK_SIZE * 2) as u64,
        cache2
        TEST_CACHE_DISK_BYTES,
        put_range(&cache1, "/data/reset_test.parquet", 0, 100, &vec![0u8; 100]);
        // 3 ranges: 100 + 200 + 300 = 600 bytes total.
        IO_ENGINE,
        .key_index
    drop(cache); // shutdown.cancel() wakes the select! branch → task exits
        block_on(tiered.get(&range_cache_key("seg0/_0.parquet", 8_000_000, 8_250_000))).is_none()
        false,
/// Must satisfy: TEST_CACHE_BLOCK_SIZE ≤ TEST_CACHE_DISK_BYTES (Foyer invariant).
/// Disk capacity for the default `test_cache()` helper.
    assert_eq!(
    // Set cursor to last shard index.
/// When usage is at or above the threshold, should_skip_sweep() returns false.
/// Note: this test uses a 2-second interval and checks mtime doesn't advance
        .path()
            engine.as_ptr(),
    if ptr < 0 {
    );
    let count = cache
        &range_cache_key(path, 9000000, 10000000),
            0,   // sweep disabled
    );
            .join(crate::key_index_store::KEY_INDEX_FILENAME)
                .unwrap()
            TEST_CACHE_BLOCK_SIZE,
    );
    let s1 = range_cache_key("seg1/_0.parquet", 9000, 10000);
            .modified()
    assert_eq!(
            "/data/nodes/0/shard2.parquet",
    assert_eq!(
        .entry("data/f.parquet".to_string())
                BLOCK_SIZE as u64,
        cache.put(&key, Bytes::copy_from_slice(&chunk));
            .path()
        ".key_index.json.tmp must not exist after graceful shutdown"
            TEST_SUBMIT_QUEUE_SIZE,
        TOTAL_WRITES, key_count
    const KEYS_PER_PREFIX: usize = 100;
    let expected_total = NUM_PREFIXES * KEYS_PER_PREFIX;
        .block_on(f)
        "footer must hit"
        .map(|v| v.len())
        // Wait 2.5 intervals with NO new puts — used_bytes is unchanged so persist must NOT fire.
        let key = range_cache_key("/data/file.parquet", i * 524288, (i + 1) * 524288);
    // key_index.json must still NOT exist (Drop was skipped).
            engine.as_ptr(),
        );
    block_on(cache.get(&key));
        "dropping g3 (300) must leave 0"
        0,
    assert!(
    let key = range_cache_key("seg0/_0.parquet", 8_000_000, 8_500_000);
    let dir_str = dir.path().to_str().unwrap();
                cache.put(&key, Bytes::from(vec![0xABu8; RANGE_SIZE as usize]));
        "eviction_bytes must reflect the byte size of stale entries (parsed from key)"
            "data/f.parquet\x1F100-300".to_string(),
        cache.should_skip_sweep(),
    assert_eq!(result.as_deref(), Some(b"version_2".as_slice()));
/// without double-free. After all clones drop, the FoyerCache is freed exactly once.
    let removed: usize = (0..shard_count).map(|_| cache.sweep_once()).sum();
    assert_eq!(
}
        "key_index.json must exist after first Drop"
            false,
    // This simulates a node with only Drop-based persistence.
fn sweep_cursor_eviction_bytes_correctly_tracked() {
            i % 16,
// Stale entries from the snapshot are corrected lazily by the sweep task.
        put_range(&cache, "/data/evicted.parquet", 0, 512, &vec![0u8; 512]);
#[test]
    let cache2 = FoyerCache::new(
        .key_index
        "precondition: threshold guard would skip"
    let (cache, _dir) = test_cache();
            .eviction_bytes
        !cache.key_index.contains_key("data/stale.parquet"),
    writer.join().expect("writer panicked");
    assert_eq!(
            .used_bytes
                (BLOCK_SIZE * 2) as u64,
    // Raise the bound → same entry now admitted.
            .load(std::sync::atomic::Ordering::Relaxed);
    let (cache, _dir) = test_cache();
    let (cache, _dir) = test_cache();
    );
    let raw = cache
    let (cache, _dir) = test_cache();
        0.75,
    // The cache must still be fully functional after the simulated panic.
fn tiered_cache_get_finds_metadata_without_reregistration() {
        NUM_PREFIXES / 2
    tiered.update_max_data_entry_size(2048);
        .store(almost_full, std::sync::atomic::Ordering::Relaxed);
    let dir = TempDir::new().unwrap();
            .map(|v| v.contains(&stale_key))
/// strong count is exactly 1 immediately after creation.
#[test]
            .load(std::sync::atomic::Ordering::Relaxed),
    for i in 0..shard_count {
    );
    let key = range_cache_key("seg0/_0.parquet", 0, 4096);
    let shard2 = Arc::clone(boxed);
    cache.put(&key, Bytes::from_static(b"after"));
        "must have {NUM_PREFIXES} prefix buckets"
fn graceful_shutdown_snapshot_is_valid_json_with_correct_content() {
        .get_or_init(|| tokio::runtime::Runtime::new().expect("shared test runtime"))
        TEST_SUBMIT_QUEUE_SIZE,
        .path()
}
        removed_count_before + 2,
    );
        .map(|v| v.len())
    assert_eq!(
        false,
    std::thread::sleep(std::time::Duration::from_millis(1200));
            let _ = block_on(reader_cache.get(&key));
#[test]
        );
    }));
    assert!(token.is_cancelled(), "token must be cancelled after drop");
    );
            if std::time::Instant::now() >= deadline {
    use dashmap::DashMap;
    });
    let handles: Vec<_> = (0..16)
            }
        shards_with_entries,
/// continues to function normally. We do not wait for the sweep to fire
        "used_bytes must decrease by 200"
        TEST_BUFFER_POOL_SIZE,
    );
    put_range(&cache, "/data/file.parquet", 0, 100, b"fresh");
use crate::foyer::ffm::foyer_snapshot_stats;
    {
    let total_keys: usize = cache.key_index.iter().map(|e| e.value().len()).sum();
        &range_cache_key(path, 0, 1000000),
        )
fn sweep_once_ignores_threshold_guard() {
        );
    // Fake key range: 99999–100000 = 1 byte. key_byte_size() parses this from the key string.
        })
        .removed_bytes
    assert_eq!(
#[test]
    assert_eq!(
/// of the hit/miss outcome.
    }
            dir.path(),
        0,
                % 16,
        "must have {} total keys after recovery",
            TEST_BUFFER_POOL_SIZE,
        tiered.data_cache().stats.hit_count.load(Ordering::Relaxed),
            tiered
    let contents = std::fs::read_to_string(&path).unwrap();
    // Create a new cache from the same dir — should bulk-load the snapshot.
    let rc = unsafe { crate::foyer::ffm::foyer_snapshot_stats(raw_ptr, out.as_mut_ptr()) };
    );
            .used_bytes
fn ffm_create_cache_returns_fat_ptr_with_strong_count_one() {
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
            s.insert(key0);
}
        block_on(tiered.get(&col_idx_key)).as_deref(),
        TEST_CACHE_BLOCK_SIZE,
    drop(g2);
    );
    let _ = unsafe { Box::from_raw(raw_ptr as *mut Arc<dyn crate::traits::BlockCache>) };
        count, 1,
    const CHUNK_SIZE: usize = 256 * 1024;
            BLOCK_SIZE as u64,
}
        !dir.path()
/// On a data key miss (not in either cache), metadata cache is still probed
    }
    let ptr = unsafe {
    // put_range stores exactly (end - start) bytes, so key_byte_size() == data.len().
        Some(b"column_index_bytes".as_slice())
    let almost_full = ((TEST_CACHE_DISK_BYTES as f64 * 0.999) as i64);
            .exists(),
        cache
        "metadata tier must be empty after clear_sync()"
        .key_index
/// A guard with value 0 is a no-op — counter stays unchanged.
        "used_bytes must be 512 after first put"
        put_range(&cache, "/data/shard1/file.parquet", 0, 512, &vec![0u8; 512]);
        let mtime_before = std::fs::metadata(dir.path().join(key_index_store::KEY_INDEX_FILENAME))
    );
        block_on(tiered.get(&s1)).as_deref(),
    assert_eq!(
#[test]
}
    // Inject a fake key into key_index that doesn't exist in Foyer's disk index.
    }
#[test]
            false,
    );
    );
        let mut index: HashMap<String, HashSet<String>> = HashMap::new();
        TEST_CACHE_DISK_BYTES,
            0,
    // put() must not panic — entry presence is not asserted (depends on timing).
        cache
            128 * 1024 * 1024,
        TEST_CACHE_BLOCK_SIZE,
            .load(std::sync::atomic::Ordering::Relaxed),
        cache2.key_index.is_empty(),
#[test]
        }
        .get("data/shared.parquet")
        0,
        .exists());
        64 * 1024 * 1024,
// ── Sweep cursor tests ───────────────────────────────────────────────────────
            .map(|k| format!("{prefix}\x1F{}-{}", k * 4096, (k + 1) * 4096))
        "metadata entry exceeding max_metadata_entry_size must not be cached"
        0.0,
        TEST_SUBMIT_QUEUE_SIZE,
        .get("data/a.parquet")
        dir.path()
        .removed_count
    // usage = 0% → below 75% → skip
/// GS-03 / GS-04: verify key_index.json content is valid JSON with correct version and index.
            "out[{i}] should be 0 for a fresh cache, got {}",
/// when the cancellation token fires. Waits for at least one persist to happen.
    // Directly populate the key_index (bypasses actual Foyer disk, tests key_index logic only).
}
        // Drop writes and renames.
    let (tiered, _data_dir, _meta_dir) = tiered_test_cache();
        );
}
// ── sweep idempotency and edge cases ─────────────────────────────────────────
    let boxed = Box::new(std::sync::Arc::clone(&cache_trait));
                engine.as_ptr(),
        std::thread::sleep(std::time::Duration::from_millis(2000));
        0,
    let cache2 = FoyerCache::new(
        false,
        400,
        TEST_CACHE_DISK_BYTES,
    assert!(block_on(tiered.data_cache().get(&col_a_key)).is_some());
            .exists(),
        .or_default()
    assert!(
        let byte_size: i64 = keys
        .stats
        cache
    );
        0,
        let key = format!("{}\x1F0-100", prefix);
    assert_eq!(
    (cache, dir)
