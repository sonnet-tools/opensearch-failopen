}
            file_size,
                    "range[{}] {}..{} ({} bytes) must survive Foyer SSD recovery \
    let data_cache = Arc::new(FoyerCache::new(
                        .and_then(|o| c.column_index_length().map(|l| o as u64 + l as u64))
        // Read 1KB range (< 2KB threshold) — should be cached
            .collect()
            cache.metadata_cache().get(&footer_key).await.is_none(),
    let metadata_cache = Arc::new(FoyerCache::new(
//
}
            let actual_max = rg
                .min()
            if let (Some(offset), Some(length)) =
        footer_start,
        file_size,
            .unwrap();
                    end,
    // Session 1 dropped — FoyerCache::drop() calls HybridCache::close() which
/// through get_opts. This must NOT put column data bytes into metadata Foyer.
                .unwrap()
        }
        let names: Vec<String> = ids.iter().map(|i| format!("name_{}", i)).collect();
        .set_column_index_truncate_length(Some(64))
    let parquet_dir = TempDir::new().unwrap();
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        }
            .await
            "global page index range ({}..{}) must be served from metadata cache after file deletion",
    RT.get_or_init(|| tokio::runtime::Runtime::new().unwrap())
    let data_dir = TempDir::new().unwrap();
    let file_size = write_page_indexed_parquet(parquet_dir.path(), "small.parquet", 1, 11);
        }
}
            rows2, 3,
    let data_cache = Arc::new(FoyerCache::new(
            )
        0.0,
}
        drain_to_disk(&cache).await;
    ));
            footer_start,
            "get_opts must populate data cache on miss"
        false,
        "page_idx.parquet",
        let file_bytes = std::fs::read(parquet_dir.path().join("restart_meta.parquet")).unwrap();
    // Session 2: new instances, same SSD dirs — Foyer recovers
                assert!(
            if let (Some(offset), Some(length)) =
        "align.parquet",
    let parquet_dir = TempDir::new().unwrap();
use object_store::local::LocalFileSystem;
        self.staged.lock().unwrap().clear();
             proves full lifecycle: warmup → persist → recover → serve from Foyer only"
    let file_bytes = std::fs::read(parquet_dir.path().join("prod.parquet")).unwrap();
        let suffix_bytes = result.bytes().await.unwrap();
    block_on(async {
fn compute_per_rg_page_index_ranges(
        file_size,
        ranges[2],
        .with_schema(schema.clone());
        let (ctx, schema) = setup_df_session(store.clone(), "prod.parquet", "prod", None).await;
    block_on(async {
    let meta_dir = TempDir::new().unwrap();
fn block_on<F: std::future::Future>(f: F) -> F::Output {
/// Set up a DataFusion session with the store registered and a ListingTable for the given file.
                    None => Some(start..end),
            "get_ranges must populate data cache"
///
    block_on(async {
    );
        cache.put(&key, filler.clone());
            assert_eq!(
        0,
const DISK_BYTES: usize = 8 * 1024 * 1024;
            let footer_bytes = footer_bytes.clone();
        Self {
    warmup_metadata(
    }
/// Proves metadata is served from cache, not local FS: delete the local file
            ));
    staged: std::sync::Mutex<std::collections::HashMap<CacheKey, bytes::Bytes>>,
    let meta_dir = TempDir::new().unwrap();
            .unwrap();
        cache.clone(),
            .await;
    let data_dir = TempDir::new().unwrap();
                Arc::new(Int64Array::from(vals)) as Arc<dyn arrow_array::Array>
    let off_idx_range = rg
    let mut writer = ArrowWriter::try_new(file, schema.clone(), Some(props)).unwrap();
    let meta_dir = TempDir::new().unwrap();
        for (key, data) in staged.drain() {
    let footer_start = file_size.saturating_sub(64 * 1024);
    let meta_dir = TempDir::new().unwrap();
/// flaky, and what the failure looks like when it does.
            parquet_dir.path(),
        // must be on SSD before their only other source disappears.
                let end = start + length as u64;
    });
            .await
    let file_path = dir.join(filename);
        "test file must have page index data; got {} ranges",
        ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl,
        );
use std::sync::Arc;
    }
                recovered_count,
    assert_eq!(
            cache.clone(),
                    recovered.is_some(),
    cache: &TieredBlockCache,
                warmed_ranges[0].start,
            global_range.start,
        // below misses, put_metadata never runs, and the metadata_cache assert after it fails.
    static RT: std::sync::OnceLock<tokio::runtime::Runtime> = std::sync::OnceLock::new();
            for (i, (range, expected)) in warmed_ranges.iter().zip(warmed_data.iter()).enumerate() {
    // First, put only the footer into metadata cache via explicit warmup
            "column data range must NOT be in metadata cache — get_opts must not auto-populate metadata");
    block_on(drain_to_disk(&cache));
            "data must be in data cache"
            cache.clone(),
            let footer_start = file_size.saturating_sub(8 * 1024);
    metadata_bytes.push(bytes::Bytes::copy_from_slice(
        for r in &ranges {
        assert_eq!(data2[0].len(), 4096);
        assert!(
            file_size,
        file_size,
    let file_bytes = std::fs::read(parquet_dir.path().join("overflow.parquet")).unwrap();
            "must have footer + at least 1 page index range"
            parquet_dir.path(),
    // probing the metadata cache directly. This avoids flakiness from Foyer's block
            {
    let expected_key = range_cache_key("page_idx.parquet", global_range.start, global_range.end);
#[test]
    let file_path = parquet_dir.join(filename);
            "restart_meta.parquet",
/// place, and the `get` misses.
 * The OpenSearch Contributors require contributions made to
    let path = Path::from("threshold.parquet");
            setup_df_session(store.clone(), "query.parquet", "test_table", None).await;
        );
                    col_idx,
        let bytes = store.get_range(&path, large_range.clone()).await.unwrap();
        );
        // Verify the merged range is tight (start == min offset, end == max offset+length)
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
            }
        let in_meta = cache.metadata_cache().get(&key).await;
            visible.insert(key, data);
        .row_groups()
    );
/// Session 2: new Foyer instances (same SSD dirs), file deleted → DataFusion query succeeds.
/// Key alignment test: warmup via put_metadata, then DataFusion query hits cache.
    let mut ranges = crate::cache::custom_cache_manager::compute_page_index_range(metadata);
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
/// **Test 5**: get_opts probe does NOT pollute metadata Foyer with column data.
                        i, range.start, range.end
        assert_eq!(footer_after, footer);
    let parquet_dir = TempDir::new().unwrap();
/// reproducing the production symptom.
/// A test that needs a `get` to hit must therefore call [`drain_to_disk`], NOT
        let (ctx, schema) = setup_df_session(store.clone(), "deferred.parquet", "t", None).await;
            let cache_clone = cache.clone();
        file_size,
            .await
            cache.metadata_cache().get(&footer_key).await.is_some(),
        );
                    global_range.start,
    let filler = bytes::Bytes::from_static(&FILLER);
            &[footer_bytes],
    let range_bytes = bytes::Bytes::copy_from_slice(&file_bytes[start as usize..end as usize]);
        let file = std::fs::File::open(parquet_dir.path().join("restart_meta.parquet")).unwrap();
    let file_size = write_test_parquet(parquet_dir.path(), "warm.parquet", 2);
}
            "metadata must survive data cache LRU pressure"
    let data_dir = TempDir::new().unwrap();
            "range > threshold must NOT be cached"
#[test]
fn concurrent_shard_warmup_does_not_corrupt() {
/// In-session per-range persistence: warm a small (< 64 KB) page-indexed file
            handle.await.unwrap();
    );
                    assert_eq!(
    let footer_start = file_size.saturating_sub(8 * 1024);
        // Metadata untouched
///
        .block_on(f)
    // Put many metadata entries to exceed 1MB capacity.
        &cache,
    let file_size = write_test_parquet(parquet_dir.path(), "threshold.parquet", 5);
            }
/// errors occur — graceful degradation.
/// falls back to the local store, and the file it wants is gone. Flushing first — what
/// ranges into the metadata tier, drop the caches (FoyerCache::drop flushes +
#[test]
            .await
    let parquet_dir = TempDir::new().unwrap();
    let store = Arc::new(store);
    use datafusion::datasource::listing::{
    cache: Arc<dyn BlockCache>,
        assert!(result.is_ok(), "get_range must succeed");
            rows3, 3,
fn metadata_foyer_capacity_breach_graceful_degradation() {
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        let via_ranges = store.get_ranges(&path, &[0u64..4096]).await.unwrap();
    let metadata_cache = Arc::new(FoyerCache::new(
                assert!(
        assert!(
    // Set threshold to 2KB — anything larger skips caching
        let large_range = 0u64..4096.min(file_size);
        let batches3 = ctx3.sql(QUERY).await.unwrap().collect().await.unwrap();
    });
/// encompassing all column_index and offset_index data. Returns `None` if the
            cache.data_cache().get(&data_key).await.is_some(),
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        let rows2: usize = batches2.iter().map(|b| b.num_rows()).sum();
                    merged.start,
                     (prod showed only the whole-file footer surviving)",
    std::fs::remove_file(parquet_dir.path().join("page_idx.parquet")).unwrap();
    let store = create_store(
            cache.data_cache().get(&data_key).await.is_none(),
    let parquet_dir = TempDir::new().unwrap();
/// When metadata cache is full, reads still succeed via local FS / S3.
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    let file_size = write_test_parquet(parquet_dir.path(), "keyshare.parquet", 2);
        let key = range_cache_key("keyshare.parquet", 0, 4096);
        let store = create_store(
        drain_to_disk(&cache).await;
/// the fold produces ranges that cover all column metadata by checking against
/// behavior). Reads should still work for entries that survived, and no panics or
    }
        let hit = self.visible.lock().unwrap().get(key).cloned();
        let store = create_store(
    );
#[test]
        );
///
                rg_idx
    let data_dir = TempDir::new().unwrap();
        }
        "threshold.parquet",
        writer.write(&batch).unwrap();
        cache.clone(),
                store
        }
    }
        data_dir.path(),
            .map(|r| r.unwrap())
}
        file_size,
}
                    r.start,
                acc
                match acc {
        cache.clone(),
    // Session 1 dropped — Foyer flushes to SSD
            if let (Some(offset), Some(length)) =
    block_on(async {
            from_cache, original,
        if let Some(ref merged) = col_idx_range {
        "auto",
        let batches = ctx
                "concurrent read {} must match warmup bytes",
}
            let key = range_cache_key(filename, footer_start, *file_size);
    });
        ));
                all_bytes.push((start, end, bytes));
        0,
    }
                    );
    // Warmup
    parquet_dir: &std::path::Path,
                let start = offset as u64;
///      same keys stored in the cache — key alignment is correct.
        assert!(
    let schema = Arc::new(Schema::new(fields));
        &cache,
        assert_eq!(
            range: Some(object_store::GetRange::Suffix(suffix_size)),
    let data_dir = TempDir::new().unwrap();
        // Must match what we put via absolute range
    let parquet_dir = TempDir::new().unwrap();
        if let Some(r) = col_idx_range {
fn metadata_survives_restart_via_foyer_recovery() {
use object_store::{ObjectStore, ObjectStoreExt};
#[test]
        // ── Step 3: Delete local file ────────────────────────────────────────
                (col.column_index_offset(), col.column_index_length())
            store.put_metadata("warm.parquet", &[footer_start..file_size], &[footer_bytes]);
            }
    let path = Path::from("nopollute.parquet");
            let actual_min = rg
        &file_bytes[footer_start as usize..file_size as usize],
        footer_start,
// collapse that triggers the overlap.
                    global_range.end
                "repeated read of {}..{} must return same bytes",
        cache.clone(),
        assert!(
                    global_range.start,
    // No panics must have occurred. Now verify graceful degradation.
    use parquet::file::serialized_reader::SerializedFileReader;
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        warmup_metadata(
            .await
    );
}
        store.put_metadata("restart_meta.parquet", &warmed_ranges, &warmed_data);
        expected_rows = rows;
            cache.data_cache().get(&key).await.is_some(),
                assert_eq!(
    let footer_start = file_size.saturating_sub(64 * 1024);
    rg: &parquet::file::metadata::RowGroupMetaData,
            cache.clone(),
    let file_size = write_test_parquet(parquet_dir.path(), "restart.parquet", 2);
                }
                ));
            // Use saved schema from session 1 (in production, CatalogSnapshot provides this)
    ctx.register_table(table_name, Arc::new(table)).unwrap();
async fn drain_to_disk(cache: &TieredBlockCache) {
/// and offset_index_offset/length across columns per RG. This test verifies that
    }
    // Assert: the exact cache key we expect is in metadata Foyer
    assert_eq!(
/// resident, their disk write deferred until eviction releases them. A `get` right after a `put`
        // Verify each file's metadata is independently correct
    let data_dir = TempDir::new().unwrap();
            {
    let col_idx_range = rg
        "auto",
            .await
    metadata: &parquet::file::metadata::ParquetMetaData,
    let props = WriterProperties::builder()
    let parquet_dir = TempDir::new().unwrap();
    }
}
            .sql("SELECT id FROM t WHERE id < 5 ORDER BY id")
            );
        file_size,
        file_size,
        parquet_dir.path(),
        for (start, end, expected) in &entries {
    ));
        // One or both should have it — important thing is bytes are correct
                .sql("SELECT id FROM t WHERE id < 10 ORDER BY id")
        cache.flush();
/// hit data cache on second access (simulates CachedMetadataReader::get_bytes
/// metadata from metadata_cache (never-evict) and data from data_cache.
        }
                .columns()
    // Also warmup the footer (last 8KB)
    // Read footer and compute page index ranges using the shared helper
    }
                let end = start + length as u64;
    std::fs::metadata(&file_path).unwrap().len()
                .filter_map(|c| {
        let key = range_cache_key("indexed.parquet", 0, 4096);
    let postscript_start = file_size.saturating_sub(8);
    let parquet_dir = TempDir::new().unwrap();
    }
        });
            let bytes = store.get_range(&path, *start..*end).await.unwrap();
                .await
                 (prod showed only the footer key persisting)",
        // Delete file to prove it comes from cache
                    None => Some(start..end),
                    merged.end
        }
    // Delete local file — force subsequent reads to come from cache only
/// Folds ALL columns across ALL row groups into a single contiguous range
    let reader = SerializedFileReader::new(file).unwrap();
    cache.wait_for_flush().await;
            .await
        "auto",
    }
/// 3. Delete the local Parquet file (simulates warm node with no local copy)
                .max()
    let mut entries: Vec<(u64, u64, bytes::Bytes)> = Vec::new();
/// If this test passes, key alignment is proven for ALL byte ranges across the
}
                }
                        "recovered range {} ({}..{}) bytes must match original warmup data",
    let file_size = write_test_parquet(parquet_dir.path(), "delete.parquet", 2);
        0..file_size,
    // Session 1: warmup puts metadata into metadata cache
/// Strategy:
        let store = create_store(
    let original_bytes = {
        );
                warmed_ranges[0].end,
fn unflushed_cache_puts_make_query_after_delete_fail() {
    let parquet_dir = TempDir::new().unwrap();
    let store = create_store(parquet_dir.path(), cache.clone(), "prod.parquet", file_size);
///   - postscript: `[size - 8, size]`
            if let Some(r) = col_idx_range {
        None => listing_options
struct DeferredPutCache {
/// tier a test asserts on varies and each has its own shards.
    let path = Path::from("test.parquet");
        "nopollute.parquet",
            "after the flush the same query must succeed from cache with no local file"
        // This goes through get_opts path
        assert!(cache.metadata_cache().get(&footer_key).await.is_some());
        let (col_idx_range, off_idx_range) = compute_per_rg_page_index_ranges(rg);
/// consistent, deterministic cache keys that are found on subsequent probes.
}
    let parquet_dir = TempDir::new().unwrap();
        parquet_dir.path(),
        BUFFER_POOL,
            .sql("SELECT id, name FROM test_table WHERE id < 5 ORDER BY id")
    let parquet_metadata = reader.metadata();
///
            );
#[test]
        0.0,
        .flat_map(|rg| rg.columns().iter())
        "auto",
        Box::pin(async {})
    visible: std::sync::Mutex<std::collections::HashMap<CacheKey, bytes::Bytes>>,
        0,
/// **HIGH-CONFIDENCE TEST**: Restart with file deleted — Foyer is the ONLY source.
            );
/// either way.
    // Compute all metadata ranges (footer + page indexes)
            "footer must be in metadata_cache after put_metadata"
        cache.clone(),
        parquet_dir.path(),
    fn as_any(&self) -> &dyn std::any::Any {
    store.registry().register(
        0.0,
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        0,
#[test]
}
                let start = offset as u64;
        cache.clone(),
impl BlockCache for DeferredPutCache {
        let rows2: usize = batches2.iter().map(|b| b.num_rows()).sum();
        let fetched = store.get_ranges(&path, &ranges).await.unwrap();
/// Suffix fetch resolves to correct absolute range and hits metadata cache.
#[test]
                cached.unwrap(),
            cache.data_cache().get(&large_key).await.is_some(),
        parquet_dir.path(),
    let store = create_store(
        store.put_metadata("small_restart.parquet", &ranges, &datas);
        0.0,
        // put_metadata is fire-and-forget into Foyer's disk-only storage (memory tier = 1 byte);
        .build();
        );
        assert_eq!(total_rows, 5, "WHERE id < 5 should return 5 rows");
    let reader = SerializedFileReader::new(file).unwrap();
    let suffix_size = 4096u64;
/// block-cache-foyer's own tests makes the same point — hence 64, into both tiers, since which
        // insert() returns before the storage flusher persists the entry. Under heavy parallel load
                None => {
            .get_range(&path, footer_start..file_size)
        // Drain first: query 1's data-tier puts are fire-and-forget, so without this the read
        file_size,
            );
                .collect()
            .unwrap();
    });
        assert!(rows1 > 0, "first query must return rows");
                (col.offset_index_offset(), col.offset_index_length())
    let footer = warmup_metadata(
            }
        let bytes2 = store.get_range(&path, range).await.unwrap();
        );
    let file_size = write_test_parquet(parquet_dir.path(), "pressure.parquet", 5);
        assert!(!batches.is_empty());
    let original = warmup_metadata(
// ── Tests ───────────────────────────────────────────────────────────────────────
        // ── Query again: must succeed entirely from cache ────────────────────
    let data_dir = TempDir::new().unwrap();
impl DeferredPutCache {
            hits, misses);
    block_on(async {
/// is then answered out of DRAM without the entry ever reaching the device; under full-suite load
fn metadata_cache_full_reads_still_succeed_via_local_fs() {
    let file_size = write_test_parquet(parquet_dir.path(), "concurrent.parquet", 2);
    let store = create_store(
        0,
        let bytes = result.unwrap();
        // Fill data cache to trigger eviction
        "delete.parquet",
            let result = store.get_range(&path, *start..*end).await;
        let file_bytes = std::fs::read(parquet_dir.path().join("restart_full.parquet")).unwrap();
        SUBMIT_QUEUE,
// keys were missing. These tests pin the property that EVERY warmed range must
/// pattern but with multiple ranges including page indexes.
                warmed_data.push(bytes::Bytes::copy_from_slice(
    block_on(async {
        // Read footer bytes before spawning tasks
    };
            let end = start + 102400;
            "restart_full.parquet",
    let store = create_store(
                .unwrap();
            cache.data_cache().get(&large_key).await.is_none(),
            let end = start + 4096;
        Some(s) => s,
    const FILLER: [u8; 1024] = [0xBB; 1024];
    let file = std::fs::File::open(parquet_dir.path().join("small.parquet")).unwrap();
            }
        assert!(!bytes.is_empty());
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    // Warmup metadata + populate data
                warmed_ranges.push(r);
        DISK_BYTES,
            .sql("SELECT col_0, col_1 FROM prod WHERE col_0 < 50")
    let meta_dir = TempDir::new().unwrap();
        // Both must return same bytes
                    "recovered bytes must match the warmed bytes"
        }
        "breach.parquet",
    let file_size = write_page_indexed_parquet(parquet_dir.path(), "small_restart.parquet", 1, 11);
    dir: &std::path::Path,
        assert!(
            msg.contains("deferred.parquet")
            .unwrap(),
                let end = start + length as u64;
    let format = Arc::new(ParquetFormat::default());
                let start = offset as u64;
}
    };
        "auto",
        assert!(
            .map(|c| {
/// 4. Second DataFusion query: must succeed from cache alone
        "small-file footer range collapses to the whole file"
/// **Test 6**: Restart — no S3/local FS reads for previously warmed metadata.
        // ── Query 2: same query, file gone — must succeed from cache ─────────
fn restart_with_file_deleted_query_succeeds_from_foyer_only() {
    let data_dir = TempDir::new().unwrap();
        let msg = err.to_string();
/// page index ranges survive — proving the SSD recovery path works.
fn get_range_and_get_ranges_share_same_cache_key() {
/// This exercises the EXACT production path:
    let mut fields: Vec<Field> = Vec::new();
            "reads must succeed regardless of metadata cache pressure"
}
                .filter_map(|c| c.column_index_offset().map(|o| o as u64))
        // First, let DataFusion do a full query to discover what ranges it needs.
            .unwrap()
    table_name: &str,
#[test]
    {
            } else {
            .infer_schema(&ctx.state(), &table_url)
        let rows3: usize = batches3.iter().map(|b| b.num_rows()).sum();
/// `wait_for_flush()` alone, 0 of 14 with this.
        SUBMIT_QUEUE,
            setup_df_session(store.clone(), "deferred.parquet", "t", Some(schema.clone())).await;
                .iter()
        "suffix.parquet",
    let path = Path::from("breach.parquet");
        BUFFER_POOL,
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
            cache.metadata_cache().get(&footer_key).await.is_some(),
//!
        parquet_dir.path(),
            assert_eq!(
/// recovered byte-for-byte. If the small CI/OI/postscript entries are lost on Foyer
    let data_dir = TempDir::new().unwrap();
        );
/// get_opts auto-populates data Foyer on miss — repeated single-range reads
            "get_ranges must NOT populate metadata cache"
                    merged.start,
        1 * 1024 * 1024,
    let parquet_metadata = reader.metadata();
        assert!(
fn datafusion_query_succeeds_from_cache_after_local_file_deleted() {
            .sql("SELECT id FROM t WHERE id < 3 ORDER BY id")
/// whole-file footer key.
///
    // ── Step 1: Production warmup (same logic as warmup_file_with_store) ─────
        BUFFER_POOL,
                merged.start, actual_min,
///
                    start >= merged.start && end <= merged.end,
    let path = Path::from("indexed.parquet");
            .collect();
        }
        SUBMIT_QUEUE,
                let end = start + length as u64;
        assert!(expected_rows > 0);
    // Assert: the global page index range covers ALL individual column offsets
            .unwrap();
        file_size,
    let datas: Vec<bytes::Bytes> = ranges
        parquet_dir.path(),
    let mut index_ranges: Vec<std::ops::Range<u64>> = Vec::new();
        BLOCK_SIZE,
            }
                    recovered.unwrap(),
        if let Some(ref merged) = off_idx_range {
    let file_size = write_test_parquet(parquet_dir.path(), "overflow.parquet", 10);
        SUBMIT_QUEUE,
            }
/// correct and retrievable.
        "auto",
/// persists), then recreate on the same SSD dirs and assert EVERY warmed range is
            .await
        }
                let end = start + length as u64;
    ranges.push(postscript_start..file_size);
            }));
    fn new() -> Self {
            in_data.is_some() || in_meta.is_some(),
        .columns()
        // Some entries should have survived (at least the most recent ones)
                "restart_meta.parquet",
                (col.column_index_offset(), col.column_index_length())
    // 11 columns × 1 row group → a few-KB file, matching the production shape
    block_on(async {
                cached.is_some(),
        .columns()
        assert!(
                "metadata for {} must be retrievable after concurrent warmup",
                let start = offset as u64;
            let filename = filename.clone();
            cache.metadata_cache().get(&footer_key).await.is_some(),
        let (ctx2, _) = setup_df_session(store.clone(), "warm.parquet", "t", Some(schema)).await;
            .sql(QUERY)
    }
            );
        cache.clone(),
///    - Column data: served from data Foyer via get_ranges probe
                Some(saved_schema),
        );
                    global_range.end
    let num_shards = 5;
    let file_size = write_test_parquet(parquet_dir.path(), "indexed.parquet", 3);
        // Read the global page index range via store — must succeed from metadata cache
    cache.put_metadata(&key, range_bytes.clone());
                    .unwrap()
            "range < threshold must be cached"
            .unwrap()
/// Returns two optional ranges per RG: (column_index_range, offset_index_range).
fn concurrent_metadata_reads_are_safe() {
        // Drain the flusher first: the warmup put_metadata and the first query's data puts
            );
/// At query time, column data reads via CachedMetadataReader::get_bytes() go
    );
                    c.column_index_offset()
    );
        assert!(
    let store = create_store(
        DISK_BYTES,
        parquet_dir.path(),
        parquet_dir.path(),
    });
                "metadata for {} must not be corrupted by concurrent warmup",
        Field::new("name", DataType::Utf8, false),
/// Session 1: production warmup + DataFusion query (populates both caches)
        });
use opensearch_block_cache::traits::BlockCache;
    // Session 1: warm all ranges, then drop → flush to SSD + persist key_index.
    let store = create_store(
    });
        let rows1: usize = batches.iter().map(|b| b.num_rows()).sum();
// metadata tier's key_index.json contained ONLY the whole-file footer key
        let results: Vec<_> = futures::future::join_all(handles)
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        assert!(cache.metadata_cache().get(&data_key).await.is_none(),
            if let (Some(offset), Some(length)) =
            global_range.start, global_range.end);
                merged.end, actual_max,
        BLOCK_SIZE,
                    start,
    for (rg_idx, rg) in parquet_metadata.row_groups().iter().enumerate() {
                        &cached, expected,
/// SSD recovery while the larger footer survives, this fails on those ranges —
    let data_dir = TempDir::new().unwrap();
        parquet_dir.path(),
    let path = Path::from("overflow.parquet");
            if end <= file_size {
/// logic as `custom_cache_manager.rs`. Then delete the local file. Reading those
                let start = offset as u64;
        for rg in parquet_metadata.row_groups() {
            if let (Some(offset), Some(length)) =
    let parquet_dir = TempDir::new().unwrap();
            cache.clone(),
        // Run query — this reads column data via get_ranges → data Foyer
    let parquet_dir = TempDir::new().unwrap();
                recovered_count >= 1,
                })
    // Delete local file — all reads must come from metadata cache
    let path = Path::from("pressure.parquet");
        );
/// Restart variant — closest to the production `key_index.json` evidence. Warm all
    let key = range_cache_key(filename, start, end);
                let start = offset as u64;
) -> u64 {
        false,
}
    });
    // Drain the flusher so both warmup puts are on SSD before the local file goes away.
    // Write a multi-column file (5 columns, 4 row groups)
    let path = Path::from("page_idx.parquet");
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
            .unwrap();
        // Read first 4KB via get_ranges (data path → data_cache)
#[test]
fn evict_prefix_clears_both_caches_on_shard_delete() {
            "data must NOT be in metadata cache"
    }
        let data = store.get_ranges(&path, &[0u64..4096]).await.unwrap();
        let mut staged = self.staged.lock().unwrap();
#[test]
    let footer_start = file_size.saturating_sub(8 * 1024);
    let chunk_size = 1024u64; // 1KB chunks — small enough for our test file
        file_size,
/// This validates that get_opts (metadata path) and get_ranges (data path) produce
}
                .unwrap()
#[test]
    let data_dir = TempDir::new().unwrap();
            parquet_dir.path(),
    store: Arc<TieredObjectStore>,
        key: &'a CacheKey,
        assert!(cache.data_cache().get(&data_key).await.is_some());
/// The threshold is configurable and dynamically updatable.
            let key = range_cache_key("small.parquet", r.start, r.end);
        // Footer range (last 8KB — large enough to survive Foyer block alignment)
        let bounded_bytes = store
    // Page/offset indexes per RG
    let cache = Arc::new(TieredBlockCache::new(data_cache, metadata_cache));
            "page index range must NOT be in data Foyer — only metadata Foyer"
        // Drain the flusher: put_metadata is fire-and-forget, so every get below would race it.
        if let Some(footer_bytes) = cache.get(&footer_key).await {
    });
            }
            } else {
    let parquet_dir = TempDir::new().unwrap();
                (col.offset_index_offset(), col.offset_index_length())
        let in_data = cache.data_cache().get(&key).await;
                Arc::new(Int64Array::from(ids)),
            visible: std::sync::Mutex::new(std::collections::HashMap::new()),
        parquet_dir.path(),
                "restart_full.parquet",
    let meta_dir = TempDir::new().unwrap();
/// an entry is RELEASED by DRAM eviction, not at insert time, and `put`/`insert` is fire-and-forget
            (rows, schema)
    }
                let start = offset as u64;
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    );
        // Suffix fetch should resolve to same absolute key and hit cache
use opensearch_tiered_storage::types::{FileLocation, TieredFileEntry};
    // alignment behavior with very small entries.
    let data_dir = TempDir::new().unwrap();
///
        // Step 2: Now promote the footer range to metadata_cache.
        // ── Query 1: file present. Populates the cache — every put is staged, not visible ──
        BUFFER_POOL,
                .retain(|key, _| !key.as_str().starts_with(prefix));
    let path = Path::from("concurrent.parquet");
        assert_eq!(
    block_on(async {
        "small.parquet",
                acc
                let key = range_cache_key(&filename, footer_start, file_size);
//! Uses `#[test]` (not `#[tokio::test]`) because FoyerCache::new() internally
    let schema = Arc::new(Schema::new(vec![
        .iter()
    for i in 0..num_columns {
        let batch = RecordBatch::try_new(schema.clone(), columns).unwrap();
    // (col_count=11, rg_count=1, size ≈ 3 KB).
        if end > start && (end as usize) <= file_bytes.len() {
            .await
    {
        cache.update_max_data_entry_size(8192);
            }
/// full stack: warmup → DataFusion → TieredObjectStore → TieredBlockCache → Foyer.
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
//! Integration tests: TieredObjectStore + TieredBlockCache with real Parquet files.
/// Deterministic reproduction of the flake that the [`drain_to_disk`] calls above fix.
            .await
        // Wait for all warmups to complete
        assert!(
    let meta_dir = TempDir::new().unwrap();
    let meta_dir = TempDir::new().unwrap();
    let meta_dir = TempDir::new().unwrap();
                    col_idx,
        "ssd_only.parquet",
        let footer_bytes = bytes::Bytes::copy_from_slice(&file_bytes[footer_start as usize..]);
        let batches2 = ctx2
/// Compute the warmup ranges exactly as `custom_cache_manager::warmup_file_with_store`:
            if let (Some(offset), Some(length)) =
        );
        assert!(
                .max()
            map.lock()
    );
    });
            "second query (file deleted) must return same rows as first — proves full cache correctness");
            bytes, range_data[0],
    if let Some(r) = compute_global_page_index_range(parquet_metadata) {
        footer_start,
fn production_warmup_ranges(
    // Tiny metadata cache (1MB disk, 1MB block) — will fill quickly
    metadata_ranges.push(footer_start..file_size);
        let mut all_bytes = Vec::new();
                    .get_range(&path, footer_start..file_size)
        let mut handles = Vec::new();
        assert_eq!(data[0].len(), 4096);
            let start = (i * 1024) as u64;
    let file_bytes = std::fs::read(parquet_dir.path().join("page_idx.parquet")).unwrap();
const BUFFER_POOL: usize = 8 * 1024 * 1024;
fn get_opts_probe_does_not_pollute_metadata_foyer() {
}
        assert!(
}
            let start = (i * 1024) as u64;
        drain_to_disk(&cache).await;
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    let store = create_store(
                "RG {} column_index merged end must equal max offset+length",
            "query after file deletion must succeed from cache (metadata in metadata_cache)"
                rg_idx
                    col_idx,
    let mut metadata_ranges: Vec<std::ops::Range<u64>> = Vec::new();
}
    }
        let opts = GetOptions {
            .into_iter()
    });
                "RG {} offset_index merged end must equal max offset+length",
            assert_eq!(
        let footer_start = file_size.saturating_sub(64 * 1024);
        assert!(
                }
                    None => Some(start..end),
            "must serve from SSD cache after local deletion"
    let meta_dir = TempDir::new().unwrap();
            .sql("SELECT col_0, col_1 FROM prod WHERE col_0 < 50")
            if let (Some(offset), Some(length)) =
#[test]
                let _ = store.get_ranges(&path, &[start..end]).await;
        0,
    fn get<'a>(
        // ── Warmup: read metadata through store, then promote to metadata_cache ──
    let cache = Arc::new(TieredBlockCache::new(data_cache, metadata_cache));
        2 * 1024 * 1024,
        let result = store.get_opts(&path, opts).await.unwrap();
/// `NotFound` that CI reported: every cache probe misses, `TieredObjectStore::fetch_misses`
    for rg in parquet_metadata.row_groups() {
            let acc = if let (Some(offset), Some(length)) =
        index_ranges.push(r);
                (col.column_index_offset(), col.column_index_length())
            ..Default::default()
        // Page index ranges
                assert!(
                    &file_bytes[r.start as usize..r.end as usize],
                "get_range({}..{}) must succeed (graceful degradation) even under capacity pressure",
            let mut recovered_count = 0;
    );
/// DataFusion reads Parquet through the TieredObjectStore, executing a real SQL query.
/// until [`DeferredPutCache::flush`] is called.
    ) -> std::pin::Pin<Box<dyn std::future::Future<Output = Option<bytes::Bytes>> + Send + 'a>>
            .collect()
use opensearch_block_cache::tiered_block_cache::TieredBlockCache;
        "overflow.parquet",
        )
    file_size: u64,
            "suffix fetch must resolve to same bytes as bounded range"
    let file_bytes = std::fs::read(parquet_dir.path().join("small_restart.parquet")).unwrap();
            // recovered data is byte-for-byte correct (verified above).
///   3. Run same query again — must succeed entirely from cache (data_cache populated
        // Read multiple ranges — even with small metadata cache, reads succeed
fn page_index_key_alignment_warmup_matches_query_time() {
            metadata_ranges.push(r);
        // ── Query 2, no drain: this is the CI failure, deterministically ──────────────
}
#[allow(deprecated)]
                    &file_bytes[r.start as usize..r.end as usize],
        // Assert: page index range is NOT in data Foyer (put_metadata goes only to metadata)
            .collect()
        assert!(
    ]));
    let store = create_store(parquet_dir.path(), cache.clone(), "test.parquet", file_size);
        assert!(
    data_dir: &std::path::Path,
///
        let (ctx, schema) = setup_df_session(store.clone(), "warm.parquet", "t", None).await;
        SUBMIT_QUEUE,
        // First read: cache miss → local FS → populate data Foyer
            file_size,
            5,
        let err = ctx2
        );
            }
        "nopollute.parquet",
use opensearch_block_cache::range_cache::{range_cache_key, CacheKey};
    let footer_start = file_size.saturating_sub(8 * 1024);
    path_str: &str,
        let data_key = range_cache_key("test.parquet", 0, 4096);
        let start = i * chunk_size;
}
            let file_size = *file_size;
                let start = offset as u64;
    let file = std::fs::File::open(parquet_dir.path().join("page_idx.parquet")).unwrap();
            .await
    });
    let file_path = dir.join(filename);
        // ── Delete local file — cache is the only source now ─────────────────
        warmed_ranges.push(footer_start..file_size);
        "test.parquet",
    let data_dir = TempDir::new().unwrap();
            file_size,
    use parquet::file::reader::FileReader;
        fields.push(Field::new(format!("col_{}", i), DataType::Int64, false));
        cache.clone(),
            "restart.parquet",
        let footer_bytes =
        4,
        let data_key = range_cache_key("nopollute.parquet", data_start, data_end);
use parquet::file::properties::WriterProperties;
/// the recovered SSD state is sufficient to serve all reads without any
                let end = start + length as u64;
        ranges.len(),
                .sql("SELECT id FROM t WHERE id < 10 ORDER BY id")
                merged.start, actual_min,
    // Write a multi-column file with page indexes enabled
/// unless the entry is present in the block engine's in-RAM index, and that index is only
    let parquet_dir = TempDir::new().unwrap();
    {
        block_on(async {
        std::fs::remove_file(parquet_dir.path().join("prod.parquet")).unwrap();
        footer_start,
        footer_start,
                &file_bytes[r.start as usize..r.end as usize],
        // Now read a column data range via get_range (simulates CachedMetadataReader::get_bytes)
    let parquet_dir = TempDir::new().unwrap();
    use datafusion::datasource::file_format::parquet::ParquetFormat;
        // Second read: hits data Foyer (no local FS needed)
///   - footer:     `[size - 64KB, size]`  (collapses to `[0, size]` for files < 64KB)
                "RG {} offset_index merged start must equal min offset",
        .set_write_batch_size(50) // force multiple pages per row group
    let table = ListingTable::try_new(config).unwrap();
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    let cache = Arc::new(DeferredPutCache::new());
    use parquet::file::reader::FileReader;
                (col.offset_index_offset(), col.offset_index_length())
#[test]
}
        Field::new("id", DataType::Int64, false),
        }
    use parquet::file::serialized_reader::SerializedFileReader;
///
                "RG {} column_index merged start must equal min offset",
        );
                    col_idx,
    filename: &str,
///
        );
    let listing_options = ListingOptions::new(format).with_file_extension(".parquet");
        // Spawn 5 concurrent warmup tasks
                &file_bytes[r.start as usize..r.end as usize],
                    start >= global_range.start && end <= global_range.end,
    store.put_metadata("page_idx.parquet", &index_ranges, &range_data);
                    c.offset_index_offset()
/// After warmup, the local file is deleted to prove all reads come from cache.
        0,
        false,
                .unwrap();
/// Requires: FoyerCache::drop() calls HybridCache::close() to flush partial blocks.
            {
}
    let data_cache = Arc::new(FoyerCache::new(
        0,
        });
        file_size,
    }
            "exact global page index key {}..{} must be in metadata Foyer",
                .filter_map(|c| c.offset_index_offset().map(|o| o as u64))
        0.0,
    use datafusion::prelude::*;
            "footer must NOT be in data cache"
///
        .map(|r| bytes::Bytes::copy_from_slice(&file_bytes[r.start as usize..r.end as usize]))
fn get_opts_populates_data_cache_on_miss() {
            .await
            .await
            "restart_full.parquet",
    block_on(drain_to_disk(&cache));
/// Helper: simulates warmup — reads bytes via local FS and puts into metadata cache.
        );
fn write_test_parquet(dir: &std::path::Path, filename: &str, num_row_groups: usize) -> u64 {
        );
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        .build();
                );
    }
        file_size,
        "auto",
    fn evict_prefix(&self, prefix: &str) {
    // Root-cause quirk: for a sub-64KB file the footer range is the whole file.
        for i in 0..20 {
    let data_dir = TempDir::new().unwrap();
                .columns()
                        start, end
                .min()
            "restart query (file deleted, new Foyer instances) must return same rows — \
        "indexed.parquet",
        parquet_dir.path(),
            }
///   1. Run DataFusion query (cold start) — all reads go to local FS and populate
fn compute_global_page_index_range(
        parquet_dir.path(),
        let (ctx, schema) = setup_df_session(store.clone(), "align.parquet", "t", None).await;
/// Returns the SessionContext and the inferred schema. The table is registered as `table_name`.
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
use arrow::datatypes::{DataType, Field, Schema};
        "fixture must be smaller than the 64KB footer prefetch"
    ));
        writer.write(&batch).unwrap();
        // Confirm data in data cache, NOT metadata cache
/// written by the storage flusher once the block has reached the device — so an entry that has
            batches2.iter().map(|b| b.num_rows()).sum::<usize>(),
    assert!(
    // Session 2: new Foyer instances on same directories — should recover from SSD
        let range = 0u64..4096;
                .await
        &'a self,
            cache.data_cache().get(&small_key).await.is_some(),
    // Must have a page index range (proves our test file has page indexes)
        for map in [&self.staged, &self.visible] {
        let (ctx, _schema) =
            global_range.end
    let meta_dir = TempDir::new().unwrap();
            cache.metadata_cache().get(&footer_key).await.is_some(),
        );
fn write_page_indexed_parquet(
    std::fs::metadata(&file_path).unwrap().len()
                warmed_ranges.push(r);
    start: u64,
            handles.push(tokio::spawn(async move {
    let data_dir = TempDir::new().unwrap();
        let footer_start = file_size.saturating_sub(8 * 1024);
            schema.clone(),
            );
/// It drains the storage flusher, which does nothing for an entry that has not been submitted to
        &cache,
fn small_file_warmed_ranges_survive_restart() {
        .map(|r| bytes::Bytes::copy_from_slice(&file_bytes[r.start as usize..r.end as usize]))
            // The footer (range 0) must survive — it is the largest entry and most
/// 2. First DataFusion query: reads column data → populates data Foyer
        parquet_dir.path(),
        for i in 0..10 {
/// Build the data + metadata cache pair used by these tests.
    let path = Path::from("delete.parquet");
        let (ctx2, _) =
                    start,
    use parquet::file::reader::FileReader;
            !all_bytes.is_empty(),
#[test]
    let store = create_store(parquet_dir.path(), cache.clone(), "warm.parquet", file_size);
        };
) -> Arc<TieredBlockCache> {
            cache.data_cache().get(&data2_key).await.is_some(),
    let store = create_store(
            cache.put_metadata(&key, data);
            batches.iter().map(|b| b.num_rows()).sum::<usize>()
    let schema = match schema {
    block_on(async {
            match cache.metadata_cache().get(&key).await {
            .sql("SELECT id FROM t WHERE id < 3 ORDER BY id")
            };
            .unwrap()
                .unwrap();
/// **Test 4**: Page index ranges match parquet crate computation.
        &cache,
/// Our warmup code computes page index ranges by folding column_index_offset/length
        !index_ranges.is_empty(),
    num_row_groups: usize,
        meta_dir.path(),
                r.end,
        // Metadata read via get_range → get_opts → cache probe HIT
/// `cache.wait_for_flush()` on its own is NOT enough, and that is what left these tests flaky.
        .fold(None::<std::ops::Range<u64>>, |acc, col| {
        "deferred.parquet",
        // ── Query 3, after the drain: succeeds from cache alone ───────────────────────
    let meta_dir = TempDir::new().unwrap();
        std::fs::remove_file(parquet_dir.path().join("indexed.parquet")).unwrap();
        }
            "get_opts must NOT populate metadata Foyer"
            .await
                let footer_start = file_size.saturating_sub(8 * 1024);
            ],
        std::fs::remove_file(parquet_dir.path().join("deferred.parquet")).unwrap();
use arrow_array::{Int64Array, RecordBatch, StringArray};
            let key = range_cache_key("overflow.parquet", start, end);
        assert_eq!(batches.iter().map(|b| b.num_rows()).sum::<usize>(), 5);
    // Footer
    let store = create_store(
        }
        saved_schema = schema;
        let batches = ctx
        let footer_after = store
                .await
                })
                assert!(
            assert!(result.is_ok(),
/// unflushed, deleting the local file makes the cache-only query fail with exactly the
        DISK_BYTES,
        .set_max_row_group_row_count(Some(100))
        meta_dir.path(),
    let meta_dir = TempDir::new().unwrap();
    let reader = SerializedFileReader::new(file).unwrap();
        cache.clone(),
}
    let parquet_dir = TempDir::new().unwrap();
            // At least the footer should be recovered; page index ranges may or may not
    }
        let data_start = 0u64;
                let end = start + length as u64;
                    None => Some(start..end),
/// that same entry can instead be evicted with its write still in flight, leaving it in neither
        );
        // Verify: entry is now in data Foyer (not metadata Foyer)
        // get_ranges puts in data_cache, get_range puts in metadata_cache
    parquet_dir: &std::path::Path,
    block_on(async {
                    );
/// been `put` but not yet flushed is invisible to `get`. The real flusher normally wins that
    {
        let store = create_store(
                    start >= global_range.start && end <= global_range.end,
            via_ranges[0], via_range,
 * SPDX-License-Identifier: Apache-2.0
fn create_tiered_cache(
    let store = create_store(
    );
/// Measured on `small_file_warmup_persists_every_range_to_metadata_tier`, which fails on the
        let batches = ctx.sql(QUERY).await.unwrap().collect().await.unwrap();
///
    let mut warmed_ranges: Vec<std::ops::Range<u64>> = Vec::new();
        );
    block_on(async {
///
            .unwrap();
        let _ = store.get_range(&path, small_range.clone()).await.unwrap();
    let local: Arc<dyn ObjectStore> =
) -> Option<std::ops::Range<u64>> {
fn data_pressure_does_not_evict_metadata() {
            for (i, r) in ranges.iter().enumerate() {
        cache.clone(),
        "concurrent.parquet",
                let vals: Vec<i64> = (offset..offset + 100)
    let file_size = write_test_parquet(parquet_dir.path(), "test.parquet", 3);
        );
        );
            let actual_min = rg
    let reader = SerializedFileReader::new(file).unwrap();
/// file has no page index metadata.
                    end,
    ranges.push(footer_start..file_size);
    // ── Step 2: First DataFusion query (populates data Foyer with column data) ──
            assert_eq!(bytes, original_bytes, "metadata must survive restart");
        file_size,
 * compatible open source license.
            .await;
///
///   2. Delete local file.
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        assert!(
        // The column data range must NOT be in metadata cache
    let file_size = write_test_parquet(parquet_dir.path(), "nopollute.parquet", 3);
    // ── Session 2: new Foyer instances, file gone — query from Foyer only ────
        let data_end = 4096u64;
        let df = ctx
        assert!(
                setup_df_session(store.clone(), "restart_full.parquet", "t", None).await;
    let parquet_dir = TempDir::new().unwrap();
/// Compute merged column index and offset index ranges per row group.
// Production logs (warm node, ~3 KB Parquet file) showed that after warmup the
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
///
            // get_range → get_opts → cache probe → HIT (recovered from SSD)
    ));
#[test]
        parquet_dir.path(),
        let rows = block_on(async {
        self
            let (col_idx_range, off_idx_range) = compute_per_rg_page_index_ranges(rg);
            let cached = cache.metadata_cache().get(&key).await;
        "concurrent.parquet",
        cache.clone(),
    );
    );
/// get_opts skips caching for ranges exceeding max_cache_entry_size.
    block_on(async {
// ── New correctness-risk integration tests ─────────────────────────────────────
        );
) -> (Option<std::ops::Range<u64>>, Option<std::ops::Range<u64>>) {
    let meta_dir = TempDir::new().unwrap();
            .unwrap()
            {
        );
    let data_dir = TempDir::new().unwrap();
        file_size,
                );
///
                    r.end,
                filename
        let result = store.get_range(&path, data_start..data_end).await;
        &cache,
        for (filename, file_size, footer_bytes) in &file_info {
    // Warmup puts metadata into metadata cache
fn warmup_metadata(
 */
        &cache,
    let store = TieredObjectStore::new(registry, local).with_cache(cache);
            "query 2 (file deleted) must succeed from cache — proves key alignment"
use parquet::arrow::ArrowWriter;
fn metadata_routed_to_metadata_cache_data_to_data_cache() {
    );
) -> bytes::Bytes {
        file_size,
#[test]
        data_dir.path(),
        BUFFER_POOL,
            .get_range(&path, global_range.start..global_range.end)
            parquet_dir.path(),
            .unwrap();
        file_size,
/// enabled. Returns the file size.
            "restart_full.parquet",
/// Write a Parquet file with page-level statistics (column index + offset index)
    for rg in parquet_metadata.row_groups() {
            } else {
    let file_size = write_test_parquet(parquet_dir.path(), "suffix.parquet", 2);
        false,
fn page_index_ranges_match_parquet_crate_computation() {
            {
    // Drain the flusher so the warmup put is on SSD before its only other source disappears.
                assert!(
    let meta_dir = TempDir::new().unwrap();
        // Data read (get_ranges) → data cache
fn small_file_warmup_persists_every_range_to_metadata_tier() {
        meta_dir.path(),
        }
        let total_rows: usize = batches.iter().map(|b| b.num_rows()).sum();
        .collect();
                "t",
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    let store = create_store(
        store.put_metadata("small.parquet", &ranges, &fetched);
    let mut writer = ArrowWriter::try_new(file, schema.clone(), Some(props)).unwrap();
    block_on(async {
        // Warmup: put footer into metadata Foyer
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        false,
// land in the never-evict metadata tier, and isolate the small-file footer
        "page_idx.parquet",
/// **Test 1**: Page index key alignment — warmup computes page index ranges from
    }
        // Dynamic update: increase threshold to 8KB — now 4KB is cached
            "metadata must be evicted"
        );
        file_info.push((filename, file_size, footer_bytes));
        // ── Step 4: Second query — must succeed entirely from cache ───────────
    );
                    recovered_count += 1;
            let data = bytes::Bytes::copy_from_slice(&file_bytes[start as usize..end as usize]);
    let store = create_store(
            ));
        let via_range = store.get_range(&path, 0u64..4096).await.unwrap();
///      data_cache via get_opts/get_ranges. Query succeeds.
        file_size,
    let file_size = write_page_indexed_parquet(parquet_dir.path(), "restart_meta.parquet", 3, 3);
    });
        .with_listing_options(listing_options)
        0,
        let footer_start = file_size.saturating_sub(64 * 1024);
/// This models Foyer's disk-only behaviour deterministically. In Foyer, a lookup returns a miss
        assert_eq!(
/// block alignment may be lost), so we verify that at least the footer and some
        .fold(None::<std::ops::Range<u64>>, |acc, col| {
        file_size,
        }
    filename: &str,
        assert_eq!(
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    let expected_start = file_size - suffix_size;
    });
/// for column chunks in IndexedExec path).
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
            if end <= file_size {
        store.evict_path("delete.parquet");
    let table_url = ListingTableUrl::parse(&format!("file:///{}", file_path)).unwrap();
    // Use small chunk sizes that fit within our actual file size.
        block_on(async {
    );
            assert_eq!(
        let (col_idx_range, off_idx_range) = compute_per_rg_page_index_ranges(rg);
    use parquet::file::reader::FileReader;
            cache.metadata_cache().get(&data_key).await.is_none(),
    use parquet::file::serialized_reader::SerializedFileReader;
        file_size,
        BLOCK_SIZE,
            rows, expected_rows,
        for (col_idx, col) in rg.columns().iter().enumerate() {
        );
/// after warmup, then read via store — must succeed from cache.
use tempfile::TempDir;
        assert_eq!(rows2, rows1,
    {
        let mut handles = Vec::new();
            let rows = batches.iter().map(|b| b.num_rows()).sum::<usize>();
            let (ctx, _) = setup_df_session(
        assert_eq!(rows1, 3, "query 1 must return 3 rows");
        let _ = store.get_range(&path, large_range.clone()).await.unwrap();
    end: u64,
        false,
        // ── Query 1: cold start, file on local FS ────────────────────────────
///
    let expected_rows;
    }
        footer_start,
/// When metadata Foyer SSD fills, new put_metadata calls may fail silently (Foyer
        0.0,
    let meta_dir = TempDir::new().unwrap();
        );
        let footer_start = file_size.saturating_sub(8 * 1024);
                        .and_then(|o| c.offset_index_length().map(|l| o as u64 + l as u64))
                );
        false,
        let columns: Vec<Arc<dyn arrow_array::Array>> = (0..num_columns)
                ));
            handles.push(tokio::spawn(async move {
        cache.clone(),
    let file = std::fs::File::create(&file_path).unwrap();
            file_size,
        // Verify that every individual column's range is fully contained within the merged range
    let config = ListingTableConfig::new(table_url)
            .get_range(&path, footer_start..file_size)
            let footer_key = range_cache_key(
    }
                cache.metadata_cache().get(&key).await.is_some(),
        assert_eq!(bytes1.len(), 4096);
            .unwrap()
    ));
        parquet_dir.path(),
    warmup_metadata(
            cache.data_cache().get(&data_key).await.is_some(),
}
fn get_opts_skips_caching_for_large_ranges() {
                match acc {
            warmed_ranges.len() >= 2,
/*
    block_on(async {
#[test]
                    .await
        }
    let ranges = production_warmup_ranges(reader.metadata(), file_size);
            .await
/// `cache.wait_for_flush()` — see that function for why the flusher drain alone leaves these tests
    ));
                .iter()
const SUBMIT_QUEUE: usize = 8 * 1024 * 1024;
    );
        SUBMIT_QUEUE,
    let store = create_store(
                    start,
        if let Some(r) = off_idx_range {
                    misses += 1;
        let small_key = range_cache_key("threshold.parquet", small_range.start, small_range.end);
        assert_eq!(
            .get_range(&path, expected_start..file_size)
/// This proves that across a full restart (new process, new Foyer instances),
    let parquet_dir = TempDir::new().unwrap();
    let footer_start = file_size.saturating_sub(8 * 1024);
 * this file be licensed under the Apache-2.0 license or a
            assert!(cache.metadata_cache().get(&footer_key).await.is_some(),
/// So evict first, then drain. One filler put per shard is not enough — `drain_dram_tier` in
        "keyshare.parquet",
            cache.clone(),
}
    for rg in 0..num_row_groups {
    let store = create_store(
/// The system degrades gracefully — no panics, no errors.
        let batches = df.collect().await.unwrap();
            &[footer_start..file_size],
    let parquet_dir = TempDir::new().unwrap();
                "warmed range {}..{} ({} bytes) must be in the metadata tier \
                .unwrap();
        );
    );
        );
        for (start, end, _) in &entries {
        false,
    let file_size = write_page_indexed_parquet(parquet_dir.path(), "page_idx.parquet", 3, 5);
            );
        let footer_key = range_cache_key("nopollute.parquet", footer_start, file_size);
        path_str,
        assert!(result.is_ok(),
    });
        parquet_dir.path(),
    let parquet_dir = TempDir::new().unwrap();
        for handle in handles {
    let mut file_info: Vec<(String, u64, bytes::Bytes)> = Vec::new();
    let data_dir = TempDir::new().unwrap();
            }
        &cache,
        // Confirm in metadata cache, NOT data cache
    let file_size = write_test_parquet(parquet_dir.path(), "align.parquet", 2);
    let ctx = SessionContext::new();
/// DRAM caching: the default weighter counts ENTRIES, not bytes, and the in-memory cache is
        "suffix.parquet",
            .collect()
            "first read must populate data Foyer"
use opensearch_tiered_storage::registry::traits::FileRegistry;
    (ctx, schema)
        let rows1: usize = batches.iter().map(|b| b.num_rows()).sum();
        });
        assert!(
        // Run DataFusion query — populates data Foyer with column data
    for rg in 0..num_row_groups {
                "footer must survive SSD recovery — this is the primary restart-without-S3 guarantee");
    let metadata_cache = Arc::new(FoyerCache::new(
#[test]
        BUFFER_POOL,
    let file_size = write_test_parquet(parquet_dir.path(), "deferred.parquet", 2);
            // depending on Foyer's block packing. The key correctness guarantee is that
        data_dir.path(),
        .iter()
        let data2 = store.get_ranges(&path, &[100u64..4196]).await.unwrap();
/// individual column offsets.
    metadata
            cache.metadata_cache().get(&data2_key).await.is_none(),
}
        "ssd_only.parquet",
        0,
        // Verify footer IS in metadata cache
/// CI's I/O contention. Staging the bytes reproduces the same window with no timing dependency.
                let merged = off_idx_range.as_ref().unwrap();
                start, end
        cache.put_metadata(&key, filler.clone());
    range_bytes
        // Shard delete
        for (col_idx, col) in rg.columns().iter().enumerate() {
    for i in 0..num_shards {
    // Session 2: new instances on the same SSD dirs — Foyer recovers from disk.
            entries.push((start, end, data.clone()));
use opensearch_block_cache::foyer::foyer_cache::FoyerCache;
        let large_key = range_cache_key("threshold.parquet", large_range.start, large_range.end);
    std::fs::remove_file(parquet_dir.path().join("ssd_only.parquet")).unwrap();
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    let mut warmed_data: Vec<bytes::Bytes> = Vec::new();
        parquet_dir.path(),
        std::fs::remove_file(parquet_dir.path().join("align.parquet")).unwrap();
            "footer must be in metadata cache after warmup"
        Arc::new(LocalFileSystem::new_with_prefix(parquet_dir).unwrap());
        parquet_dir.path(),
        0.0,
        let file_size = write_test_parquet(parquet_dir.path(), &filename, 2 + i);
    writer.close().unwrap();
                let key = range_cache_key("small_restart.parquet", r.start, r.end);
    block_on(async {
    };
            "after threshold increase, 4KB range must be cached"
///
    assert!(file_size < 64 * 1024);
    );
}
                let end = start + length as u64;
    );
                r.start,
    let footer_start = file_size.saturating_sub(8 * 1024);
/// Same shape as `datafusion_query_succeeds_from_cache_after_local_file_deleted`, but with a
                );
    let path = Path::from("suffix.parquet");
    let props = WriterProperties::builder()
    // flushes partial blocks to SSD. No sleep needed.
        meta_dir,
    let meta_dir = TempDir::new().unwrap();
/// Shared runtime for test async blocks (created lazily, not inside FoyerCache::new).
            metadata_bytes.push(bytes::Bytes::copy_from_slice(
        0,
    block_on(async {
        "pressure.parquet",
/// DataFusion query succeeds entirely from cache.
        let (ctx3, _) =
#[test]
        DISK_BYTES,
        self.staged.lock().unwrap().insert(key.clone(), data);
        0.0,
            "second read must return same bytes from data Foyer cache"
    file_size: u64,
        drain_to_disk(&cache).await;
        for _ in 0..10 {
    block_on(async {
        self.visible.lock().unwrap().clear();
        // Read via store — local FS is gone, must succeed from metadata SSD cache
    // Compute ONE global merged range — matching parquet crate's range_for_page_index()
                );
        })
    ));
    const QUERY: &str = "SELECT id FROM t WHERE id < 3 ORDER BY id";
    // Write a larger file to have enough data to fill cache
    }
        let data2_key = range_cache_key("nopollute.parquet", 100, 4196);
        }
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
/// should be recovered from Foyer's SSD tier, not re-fetched from local FS.
fn datafusion_query_through_tiered_store() {
        let batches = ctx
        );
        // Reads via store must not error even for ranges that missed metadata cache
                warmed_ranges.len()
                let key = range_cache_key("restart_meta.parquet", range.start, range.end);
/// Multiple shards warming up in parallel (different files, same TieredBlockCache)
    cache.update_max_data_entry_size(2048);
///
        let key = range_cache_key("__drain_filler__", i * 1024, (i + 1) * 1024);
    // Enable page-level statistics by setting write_page_index(true)
        // Put all ranges into metadata Foyer
    let file_size = write_test_parquet(parquet_dir.path(), "restart_full.parquet", 2);
/// race within microseconds, which is why the tests here pass on an idle machine and fail under
            .collect()
    let data_dir = TempDir::new().unwrap();
            "range must be cached in at least one tier"
fn create_store(
        // write buffer. Drain the flusher first — its documented post-condition is "all previously
                "at least the footer must survive SSD recovery (recovered {} of {} ranges)",
            assert_eq!(
        .collect();
            "small_restart.parquet",
                result, &expected,
/// **Test 3**: Metadata Foyer capacity breach graceful degradation.
                    rg_idx,
        }
            let store = store.clone();
    let meta_dir = TempDir::new().unwrap();
            assert_eq!(
            cache.metadata_cache().get(&expected_key).await.is_some(),
/// **HIGH-CONFIDENCE TEST**: Full production warmup sequence → delete file →
    let expected = warmup_metadata(
                Arc::new(StringArray::from(names)),
    let footer_key = range_cache_key("pressure.parquet", footer_start, file_size);
            metadata_bytes.push(bytes::Bytes::copy_from_slice(
    let data_dir = TempDir::new().unwrap();
        let batch = RecordBatch::try_new(
    fn flush(&self) {
#[test]
            metadata_ranges.push(r);
            let batches = ctx
        assert_eq!(
        }
// ── Helpers ─────────────────────────────────────────────────────────────────────
            let path = path.clone();
            &cache,
    let parquet_dir = TempDir::new().unwrap();
    let _file_size = write_page_indexed_parquet(parquet_dir.path(), "parity.parquet", 4, 5);
        );
    });
    let path = Path::from("keyshare.parquet");
        // Drain the flusher first: query 1's puts must be on SSD before their only other
        // (served from local FS since get_opts doesn't auto-populate)
    let data_cache = Arc::new(FoyerCache::new(
        // (they fall through to local FS or data cache)
#[test]
        1 * 1024 * 1024,
            suffix_bytes, bounded_bytes,
    let footer = warmup_metadata(
        assert!(
        // Contrast: reading via get_ranges DOES populate data cache
                );
                .await
            bytes2, bytes1,
    meta_dir: &std::path::Path,
                warmed_data.push(bytes::Bytes::copy_from_slice(
/// ranges must be found in the cache (key alignment).
///
/// sharded 8 ways by key hash, so a handful of entries stay resident. The disk write happens when
    let meta_dir = TempDir::new().unwrap();
            let actual_max = rg
    {
        SUBMIT_QUEUE,
    let mut metadata_bytes: Vec<bytes::Bytes> = Vec::new();
        let data_key = range_cache_key("delete.parquet", 0, 4096);
        let footer_from_cache = store
        assert_eq!(
/// Only warmup's explicit put_metadata() should populate metadata Foyer.
    let footer_start = file_size.saturating_sub(8 * 1024);
            .unwrap();
        assert!(
        BLOCK_SIZE,
///
async fn setup_df_session(
            .get_range(&path, footer_start..file_size)
                acc
/// A range read via get_range (single) and get_ranges (multi with one element)
        let (ctx2, _) = setup_df_session(store.clone(), "align.parquet", "t", Some(schema)).await;
        "query.parquet",
                }
                    end,
    }
        let mut visible = self.visible.lock().unwrap();
    warmup_metadata(
// (`<path>␟0-<size>`) — the column-index, offset-index, and 8-byte postscript
                (col.column_index_offset(), col.column_index_length())
    // ── Delete local file between sessions ───────────────────────────────────
///   - CI + OI page-index whole regions (via the real `compute_page_index_range`)
    );
        drain_to_disk(&cache).await;
                .collect()
            parquet_dir.path(),
    {
    let file_size = write_test_parquet(parquet_dir.path(), "ssd_only.parquet", 2);
        // Repeated reads also succeed (from local FS — get_opts does not auto-populate cache)
    let file_size = write_test_parquet(parquet_dir.path(), "query.parquet", 2);
fn metadata_served_from_ssd_not_local_fs() {
        "auto",
        let offset = (rg * 100) as i64;
        parquet_dir.path(),
/// **Test 2**: Concurrent shard warmup does not corrupt shared metadata Foyer.
        cache.clone(),
use object_store::path::Path;
        0,
    let meta_dir = TempDir::new().unwrap();
    // NOTE: we do NOT delete the local file here. Instead, we verify recovery by
        // This populates data_cache with all metadata + data ranges.
    {
    use parquet::file::reader::FileReader;
                .unwrap();
        // Read same range via get_range (metadata path → metadata_cache)
                    r.end - r.start
 *
    // Read file bytes for warmup
        );
        SUBMIT_QUEUE,
    });
        use object_store::GetOptions;
        let small_range = 0u64..1024.min(file_size);
                rg_idx
                        &cached, expected,
        0,
// ── Small-file + per-range metadata persistence (prod-gap reproduction) ──────
        parquet_dir.path(),
    let footer_start = file_size.saturating_sub(8 * 1024);
///      by step 1). This proves the keys produced by DataFusion's read path are the
            "at least some metadata entries must survive capacity pressure (got {} hits, {} misses)",
        }
/// footer metadata and stores them in metadata Foyer. At query time, the same
        )
/// postscript) is individually present in the metadata tier — not just the
        BLOCK_SIZE,
    for i in 0..64u64 {
    let file = std::fs::File::open(parquet_dir.path().join("small_restart.parquet")).unwrap();
    let file_size = write_page_indexed_parquet(parquet_dir.path(), "prod.parquet", 3, 4);
            .await
    let parquet_dir = TempDir::new().unwrap();
                    i,
/// Make every entry put so far readable from disk, not just from DRAM.
        assert!(
#[allow(deprecated)]
    });
        Box::pin(async move { hit })
/// Note: Foyer's disk recovery may not recover every entry (small entries below
#[test]
    let parquet_dir = TempDir::new().unwrap();
                    rg_idx,
fn warmup_put_metadata_then_datafusion_query_from_cache() {
        for (filename, file_size, expected_bytes) in &file_info {
        .iter()
        "pressure.parquet",
        assert_eq!(
            .expect_err("unflushed puts + deleted local file must fail, not read from cache");
    let store = create_store(
    use parquet::file::serialized_reader::SerializedFileReader;
    );
        parquet_dir.path(),
        .set_max_row_group_row_count(Some(100))
        }
    let saved_schema;
        0,
    ctx.runtime_env()
    let parquet_dir = TempDir::new().unwrap();
            }
        0,
#[test]
                    datas[i],
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    // Warmup: explicitly put metadata into metadata cache
}
        "expected CI, OI, footer, postscript ranges"
    let meta_dir = TempDir::new().unwrap();
        BUFFER_POOL,
                .unwrap()
                acc
    store.put_metadata("prod.parquet", &metadata_ranges, &metadata_bytes);
                .filter_map(|c| {
        // Read file and compute page index ranges
            .sql("SELECT id FROM t WHERE id < 5 ORDER BY id")
                let bytes = store.get_range(&path, start..end).await.unwrap();
    let parquet_metadata = reader.metadata();
                let merged = col_idx_range.as_ref().unwrap();
                store.clone(),
        let (rows, schema) = block_on(async {
    block_on(async {
            .await
        );
            cache.data_cache().get(&footer_key).await.is_none(),
        let mut hits = 0;
fn suffix_fetch_resolves_and_hits_cache() {
            "get_range and get_ranges must return same bytes"
                }
                        "cached metadata at {}..{} must match",
    let file_bytes = std::fs::read(&file_path).unwrap();
                match acc {
    writer.close().unwrap();
    let parquet_dir = TempDir::new().unwrap();
///
    assert!(
            let key = range_cache_key("overflow.parquet", *start, *end);
                    "col {} offset_index {}..{} must be within global range {}..{}",
    );
    for i in 0..num_entries {
        block_on(async {
            .unwrap();
                &bytes, original,
    let data_dir = TempDir::new().unwrap();
        // Read 4KB range (> 2KB threshold) — should NOT be cached
}
/// Both Foyer instances are configured with a DRAM capacity of 1, but that does NOT opt out of
        let ids: Vec<i64> = (offset..offset + 100).collect();
        );
/// ranges are still available from SSD. Uses the existing `metadata_survives_restart`
            );
                    hits += 1;
            assert!(
}
    }
    schema: Option<Arc<Schema>>,
        let end = ((i + 1) * chunk_size).min(file_size);
        .register_object_store(&url, store.clone() as Arc<dyn ObjectStore>);
/// Warmup puts metadata via store.put_metadata(), then DataFusion query reads
                start, end);
    let cache = Arc::new(TieredBlockCache::new(data_cache, metadata_cache));
/// Multiple concurrent reads of same metadata range — all succeed with same bytes.
        BLOCK_SIZE,
        let batches2 = ctx2
                    end,
    let data_dir = TempDir::new().unwrap();
        footer_start,
    let file = std::fs::File::open(parquet_dir.path().join("prod.parquet")).unwrap();
        });
            "expected the NotFound that CI reported, got: {msg}"
            })
/// On restart, warmup re-runs. Previously warmed metadata (footer + page indexes)
) -> Arc<TieredObjectStore> {
        expected_start,
                (col.offset_index_offset(), col.offset_index_length())
            let bytes = store
        });
    // ── Session 1: warmup + query (populates both caches) ────────────────────
    });
    use parquet::file::reader::FileReader;
            .await
                .await
        let footer_key = range_cache_key("warm.parquet", footer_start, file_size);
    let meta_dir = TempDir::new().unwrap();
        // Compute merged ranges using our shared fold helper
/// the device yet — and with a DRAM capacity counted in ENTRIES across 8 shards, entries do stay
    std::fs::remove_file(parquet_dir.path().join("restart_full.parquet")).unwrap();
    fn put(&self, key: &CacheKey, data: bytes::Bytes) {
    let range_data: Vec<bytes::Bytes> = index_ranges
/// Fill data cache beyond capacity, verify metadata is untouched.
    let store = create_store(
/// Foyer may drop entries that exceed capacity (LRU hasn't run yet).
                .iter()
}
                rg_idx
    let path = Path::from("ssd_only.parquet");
        }
                i
    let num_entries = (file_size / chunk_size).max(1);
}
            let (ctx, schema) =
                filename
        assert!(hits > 0,
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        file_size,
        assert_eq!(rows1, 3, "query 1 must return 3 rows");
        assert!(
    // Warmup
            .unwrap();
            &file_bytes[footer_start as usize..file_size as usize],
/// Strategy: warmup puts page index ranges into metadata Foyer using the same fold
        .iter()
        assert!(
}
use opensearch_tiered_storage::tiered_object_store::TieredObjectStore;
    );
    store
    });
                    .map(|v| v + (c as i64 * 1000))
        // Drain again: put_metadata is fire-and-forget into the metadata tier.
            assert_eq!(
        BLOCK_SIZE,
                let recovered = cache.metadata_cache().get(&key).await;
    num_columns: usize,
                .columns()
        assert_eq!(
    // Warmup: read actual bytes and put into metadata Foyer via store.put_metadata()
fn restart_no_s3_for_previously_warmed_metadata() {
            .unwrap();
            let batches = ctx
                    .collect();
                .get_range(&path, footer_start..file_size)
    );
    let ranges = production_warmup_ranges(reader.metadata(), file_size);
        DISK_BYTES,
            assert!(
    file_path: &str,
/// local FS or S3 access.
                    start,
) -> (datafusion::prelude::SessionContext, Arc<Schema>) {
        file_size,
            .collect();
    );
        "delete.parquet",
            .await
    let footer_start = file_size.saturating_sub(8 * 1024);
/// exactly as production does, then assert that EACH warmed range (CI, OI, footer,
        parquet_dir.path(),
    // Session 1: warmup puts footer + page index ranges into metadata Foyer
        let parquet_metadata = reader.metadata();
    ));
                if let Some(cached) = cache.metadata_cache().get(&key).await {
        // All reads succeed — no panics, no errors regardless of cache state
    let file_size = write_test_parquet(parquet_dir.path(), "breach.parquet", 10);
            cache.metadata_cache().get(&key).await.is_none(),
        .unwrap();
/// must NOT create duplicate cache entries — verify they use compatible paths.
    let data_dir = TempDir::new().unwrap();
/// ranges via the store must succeed from cache — proving key alignment.
        // ── Delete local file — all subsequent reads must come from cache ────
        TieredFileEntry::with_size(FileLocation::Local, None, file_size),
        .fold(None::<std::ops::Range<u64>>, |acc, col| {
        BLOCK_SIZE,
            "footer must be in metadata cache"
///
        data_dir,
            .await
                    "col {} column_index {}..{} must be within global range {}..{}",
            .unwrap()
        BUFFER_POOL,
            .collect()
    );
    block_on(async {
/// 1. Warmup: parse footer, compute page index ranges, put all into metadata Foyer
        let bytes1 = store.get_range(&path, range.clone()).await.unwrap();
        warmed_data.push(bytes::Bytes::copy_from_slice(
///
            {
#[test]
    block_on(async {
                }
        let _data = store.get_ranges(&path, &[0u64..4096]).await.unwrap();
    let registry = Arc::new(TieredStorageRegistry::new());
    // Write a large parquet file
    Arc::new(TieredBlockCache::new(data_cache, metadata_cache))
            "restart.parquet",
/// collapses to — the widest write window): 2 of 10 full-suite rounds failed with
        let batches2 = ctx2
    let global_range = &index_ranges[0];
    let meta_dir = TempDir::new().unwrap();
        );
                .iter()
            {
        let file_bytes = std::fs::read(parquet_dir.path().join(&filename)).unwrap();
        parquet_dir.path(),
    use parquet::file::serialized_reader::SerializedFileReader;
        let rows1: usize = batches.iter().map(|b| b.num_rows()).sum();
    use parquet::file::serialized_reader::SerializedFileReader;
        cache.clone(),
    let reader = SerializedFileReader::new(file).unwrap();
        cache.clone(),
        let path = Path::from("small.parquet");
        drain_to_disk(&cache).await;
) -> Vec<std::ops::Range<u64>> {
        let offset = (rg * 100) as i64;
            file_size,
    let url = url::Url::parse("file://").unwrap();
                .columns()
    block_on(async {
        file_size,
///    - Metadata (footer): served from metadata Foyer via get_opts probe
/// Compute the single global page index range matching parquet crate's `range_for_page_index()`.
        let filename = format!("shard_{}.parquet", i);
/// Strategy: warmup puts metadata ranges into metadata Foyer, drop caches,
        );
        std::fs::remove_file(parquet_dir.path().join("warm.parquet")).unwrap();
        // put() entries are on SSD and findable via get()" — so the verification reads are deterministic.
        let reader = SerializedFileReader::new(file).unwrap();
        let result = store
/// cache whose flush point is explicit instead of a background task. With the puts still
                    start >= merged.start && end <= merged.end,
    let data_dir = TempDir::new().unwrap();
}
        for (start, end, original) in &all_bytes {
                .unwrap();
            cache.data_cache().get(&expected_key).await.is_none(),
        index_ranges.len()
    // Create 5 parquet files simulating 5 shard warmups
}
        file_size < 64 * 1024,
        // Verify metadata is now in metadata_cache
        );
            }
/// [`drain_to_disk`] does for the real cache — makes the same query succeed.
            );
            .await
                r.end - r.start
        // source disappears, otherwise query 2 misses and hits the deleted file.
                && (msg.contains("NotFound") || msg.contains("No such file")),
            .unwrap()
    /// The analogue of [`drain_to_disk`]: make every staged entry findable.
        store.put_metadata(
    // Create a metadata cache with very small capacity (1MB)
    });
            setup_df_session(store.clone(), "deferred.parquet", "t", Some(schema)).await;
                .unwrap();
                *expected_bytes,
    ));
    }
///
        let footer_key = range_cache_key("test.parquet", footer_start, file_size);
            parquet_dir.path(),
const BLOCK_SIZE: usize = 1 * 1024 * 1024;
        assert_eq!(footer_from_cache, footer);
        for (i, result) in results.iter().enumerate() {
        cache.clone(),
    let file = std::fs::File::create(&file_path).unwrap();
                Some(cached) => {
    });
        file_size,
                }
        parquet_dir.path(),
    fn clear(&self) -> std::pin::Pin<Box<dyn std::future::Future<Output = ()> + Send + '_>> {
    let file = std::fs::File::open(parquet_dir.path().join("parity.parquet")).unwrap();
            "data must be evicted"
        &cache,
fn production_warmup_then_query_from_cache_only() {
            "page index bytes must match warmup data byte-for-byte"
            if let Some(r) = off_idx_range {
                    merged.end
            staged: std::sync::Mutex::new(std::collections::HashMap::new()),
        let mut misses = 0;
use opensearch_tiered_storage::registry::TieredStorageRegistry;
    // Put metadata into metadata Foyer (production warmup step)
        let (ctx2, _) = setup_df_session(store.clone(), "prod.parquet", "prod", Some(schema)).await;
    // Warmup: put with absolute range key
    // and small max_row_group_size so we get multiple row groups.
    (col_idx_range, off_idx_range)
                    "RG {} col {} column_index range {}..{} must be contained in merged {}..{}",
    warmup_metadata(
                    "RG {} col {} offset_index range {}..{} must be contained in merged {}..{}",
        let store = create_store(
        });
/// largest of its four warmed ranges (`0..13076`, the whole-file range a sub-64KB file's footer
        .iter()
        let footer_key = range_cache_key("delete.parquet", footer_start, file_size);
/// recreate on same dirs. After recovery, verify that the majority of warmed
    metadata: &parquet::file::metadata::ParquetMetaData,
                match acc {
            {
    let path = Path::from("restart.parquet");
            );
    );
            vec![
        // (full test suite) a get() issued immediately after can miss an entry still queued in the
    ranges
            bytes::Bytes::copy_from_slice(&file_bytes[footer_start as usize..file_size as usize]);
    );
            // critical for restart without S3 calls.
        0,
        // The key is the same regardless of path
            } else {
            assert!(
        let from_cache = store
            .collect()
        );
            }));
                    assert_eq!(
        }
}
}
//! calls block_on() and panics if called inside an existing tokio runtime.
    let metadata_cache = Arc::new(FoyerCache::new(
                cache_clone.put_metadata(&key, footer_bytes);
/// must not interfere. After all complete, each file's metadata is independently
        file_size,
/// A [`BlockCache`] that defers publication: `put` stages bytes where `get` cannot see them
                merged.end, actual_max,
