            .unwrap();
    cache.wait_for_flush().await;
                let key = range_cache_key("small_restart.parquet", r.start, r.end);
    );
    file_size: u64,
            if let (Some(offset), Some(length)) =
const BUFFER_POOL: usize = 8 * 1024 * 1024;
            parquet_dir.path(),
        0,
    let parquet_dir = TempDir::new().unwrap();
                .retain(|key, _| !key.as_str().starts_with(prefix));
        }
    );
    for rg in parquet_metadata.row_groups() {
            cache.metadata_cache().get(&data2_key).await.is_none(),
        "query.parquet",
        let rows3: usize = batches3.iter().map(|b| b.num_rows()).sum();
                    "recovered bytes must match the warmed bytes"
/// In-session per-range persistence: warm a small (< 64 KB) page-indexed file
        for handle in handles {
        for (col_idx, col) in rg.columns().iter().enumerate() {
    let data_dir = TempDir::new().unwrap();
    for i in 0..num_columns {
/// `cache.wait_for_flush()` on its own is NOT enough, and that is what left these tests flaky.
        file_size,
/// **Test 4**: Page index ranges match parquet crate computation.
    // Compute all metadata ranges (footer + page indexes)
    staged: std::sync::Mutex<std::collections::HashMap<CacheKey, bytes::Bytes>>,
            for (i, (range, expected)) in warmed_ranges.iter().zip(warmed_data.iter()).enumerate() {
                "RG {} column_index merged start must equal min offset",
        writer.write(&batch).unwrap();
    std::fs::remove_file(parquet_dir.path().join("ssd_only.parquet")).unwrap();
    Arc::new(TieredBlockCache::new(data_cache, metadata_cache))
    block_on(async {
                    assert_eq!(
            .get_range(&path, expected_start..file_size)
    metadata
        assert!(
}
}
    let cache = Arc::new(TieredBlockCache::new(data_cache, metadata_cache));
/// The system degrades gracefully — no panics, no errors.
                        i, range.start, range.end
        0,
        // The column data range must NOT be in metadata cache
            cache.data_cache().get(&data_key).await.is_some(),
        assert!(
        // Compute merged ranges using our shared fold helper
        SUBMIT_QUEUE,
        // Run DataFusion query — populates data Foyer with column data
#[test]
    block_on(async {
    );
    file_path: &str,
        warmed_data.push(bytes::Bytes::copy_from_slice(
        cache.clone(),
        .collect();
    // Warmup: read actual bytes and put into metadata Foyer via store.put_metadata()
        ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl,
                let end = start + length as u64;
    );
        0,
    let parquet_dir = TempDir::new().unwrap();
    });
#[test]
fn metadata_cache_full_reads_still_succeed_via_local_fs() {
    let footer_key = range_cache_key("pressure.parquet", footer_start, file_size);
/// Helper: simulates warmup — reads bytes via local FS and puts into metadata cache.
        // One or both should have it — important thing is bytes are correct
/// Proves metadata is served from cache, not local FS: delete the local file
        for (start, end, original) in &all_bytes {
    let metadata_cache = Arc::new(FoyerCache::new(
        // ── Query again: must succeed entirely from cache ────────────────────
        // Footer range (last 8KB — large enough to survive Foyer block alignment)
    let data_dir = TempDir::new().unwrap();
        "align.parquet",
/// until [`DeferredPutCache::flush`] is called.
                cached.unwrap(),
/// 2. First DataFusion query: reads column data → populates data Foyer
        // Some entries should have survived (at least the most recent ones)
            .collect()
                (col.offset_index_offset(), col.offset_index_length())
        let rows1: usize = batches.iter().map(|b| b.num_rows()).sum();
/// Requires: FoyerCache::drop() calls HybridCache::close() to flush partial blocks.
    let ranges = production_warmup_ranges(reader.metadata(), file_size);
        assert_eq!(footer_from_cache, footer);
        }
        cache.clone(),
        assert!(
                .unwrap()
        &cache,
/// `wait_for_flush()` alone, 0 of 14 with this.
    let reader = SerializedFileReader::new(file).unwrap();
        let large_key = range_cache_key("threshold.parquet", large_range.start, large_range.end);
}
    cache: &TieredBlockCache,
            .await
                    end,
            if let Some(r) = off_idx_range {
/// Build the data + metadata cache pair used by these tests.
        let data = store.get_ranges(&path, &[0u64..4096]).await.unwrap();
        let batches = df.collect().await.unwrap();
    let path = Path::from("overflow.parquet");
    let footer_start = file_size.saturating_sub(8 * 1024);
    let file = std::fs::File::create(&file_path).unwrap();
        file_size,
                );
        Some(s) => s,
            }));
///
    );
        file_size < 64 * 1024,
        .build();
    // Warmup
/// pattern but with multiple ranges including page indexes.
            cache.clone(),
        }
        );
    /// The analogue of [`drain_to_disk`]: make every staged entry findable.
            .await
        assert_eq!(footer_after, footer);
                .filter_map(|c| c.column_index_offset().map(|o| o as u64))
const DISK_BYTES: usize = 8 * 1024 * 1024;
        let result = store.get_range(&path, data_start..data_end).await;
/// Compute the single global page index range matching parquet crate's `range_for_page_index()`.
    filename: &str,
        // Read 1KB range (< 2KB threshold) — should be cached
        }
        );
        ranges.len(),
        );
        let rows1: usize = batches.iter().map(|b| b.num_rows()).sum();
                "footer must survive SSD recovery — this is the primary restart-without-S3 guarantee");
        "indexed.parquet",
            if let (Some(offset), Some(length)) =
        let names: Vec<String> = ids.iter().map(|i| format!("name_{}", i)).collect();
    });
#[test]
            rows, expected_rows,
        );
    fn evict_prefix(&self, prefix: &str) {
    });
        let data_start = 0u64;
        BUFFER_POOL,
}
    let footer_start = file_size.saturating_sub(8 * 1024);
        BUFFER_POOL,
    ranges.push(footer_start..file_size);
        }
            let footer_start = file_size.saturating_sub(8 * 1024);
                (col.column_index_offset(), col.column_index_length())
    }
    let file_bytes = std::fs::read(parquet_dir.path().join("prod.parquet")).unwrap();
        warmed_ranges.push(footer_start..file_size);
                merged.start, actual_min,
        "auto",
        store.put_metadata("small.parquet", &ranges, &fetched);
/// and offset_index_offset/length across columns per RG. This test verifies that
            }
        let filename = format!("shard_{}.parquet", i);
        key: &'a CacheKey,
    }
    let data_dir = TempDir::new().unwrap();
/// **Test 3**: Metadata Foyer capacity breach graceful degradation.
        std::fs::remove_file(parquet_dir.path().join("deferred.parquet")).unwrap();
#[test]
        );
        SUBMIT_QUEUE,
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
///      same keys stored in the cache — key alignment is correct.
        let batches = ctx
    );
            assert_eq!(
            if let (Some(offset), Some(length)) =
                })
        let msg = err.to_string();
    filename: &str,
            }
            .sql("SELECT id, name FROM test_table WHERE id < 5 ORDER BY id")
    use datafusion::prelude::*;
    // Page/offset indexes per RG
                })
    let postscript_start = file_size.saturating_sub(8);
    let file_path = parquet_dir.join(filename);
    };
        .fold(None::<std::ops::Range<u64>>, |acc, col| {
/// local FS or S3 access.
            assert_eq!(
    // Session 1: warm all ranges, then drop → flush to SSD + persist key_index.
        // write buffer. Drain the flusher first — its documented post-condition is "all previously
        let data_key = range_cache_key("delete.parquet", 0, 4096);
    end: u64,
        let _ = store.get_range(&path, small_range.clone()).await.unwrap();
            "query 2 (file deleted) must succeed from cache — proves key alignment"
        // (they fall through to local FS or data cache)
    block_on(async {
    let reader = SerializedFileReader::new(file).unwrap();
        let (ctx2, _) = setup_df_session(store.clone(), "align.parquet", "t", Some(schema)).await;
        assert!(
        assert!(
    let filler = bytes::Bytes::from_static(&FILLER);
                (col.offset_index_offset(), col.offset_index_length())
    // Put many metadata entries to exceed 1MB capacity.
        parquet_dir.path(),
        "expected CI, OI, footer, postscript ranges"
            5,
                    .await
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        let (ctx, schema) = setup_df_session(store.clone(), "warm.parquet", "t", None).await;
                .unwrap()
/// Restart variant — closest to the production `key_index.json` evidence. Warm all
 * The OpenSearch Contributors require contributions made to
        // ── Step 4: Second query — must succeed entirely from cache ───────────
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        let (ctx, _schema) =
    );
        let total_rows: usize = batches.iter().map(|b| b.num_rows()).sum();
        assert!(rows1 > 0, "first query must return rows");
/// get_opts auto-populates data Foyer on miss — repeated single-range reads
        footer_start,
    let mut warmed_data: Vec<bytes::Bytes> = Vec::new();
}
            cache.metadata_cache().get(&footer_key).await.is_some(),
                .columns()
// ── New correctness-risk integration tests ─────────────────────────────────────
        );
    dir: &std::path::Path,
        BLOCK_SIZE,
                let key = range_cache_key("restart_meta.parquet", range.start, range.end);
}
                filename
                let end = start + length as u64;
                    merged.start,
        store.put_metadata(
            }
        0.0,
///
            .collect()
            cache.data_cache().get(&large_key).await.is_none(),
    });
    for i in 0..num_shards {
            "column data range must NOT be in metadata cache — get_opts must not auto-populate metadata");
        0,
    let reader = SerializedFileReader::new(file).unwrap();
        meta_dir,
        block_on(async {
                    c.column_index_offset()
            (rows, schema)
        );
        assert_eq!(total_rows, 5, "WHERE id < 5 should return 5 rows");
        // Verify footer IS in metadata cache
fn get_range_and_get_ranges_share_same_cache_key() {
                }
        if let Some(r) = col_idx_range {
///
    }
            );
fn compute_per_rg_page_index_ranges(
        // Run query — this reads column data via get_ranges → data Foyer
            "exact global page index key {}..{} must be in metadata Foyer",
        let file_bytes = std::fs::read(parquet_dir.path().join(&filename)).unwrap();
        &file_bytes[footer_start as usize..file_size as usize],
        let store = create_store(
            .await
        SUBMIT_QUEUE,
fn create_store(
    let expected = warmup_metadata(
        0.0,
    let parquet_dir = TempDir::new().unwrap();
                    merged.start,
        // Verify: entry is now in data Foyer (not metadata Foyer)
// (`<path>␟0-<size>`) — the column-index, offset-index, and 8-byte postscript
        assert_eq!(batches.iter().map(|b| b.num_rows()).sum::<usize>(), 5);
    // Create a metadata cache with very small capacity (1MB)
            .unwrap(),
#[test]
                let start = offset as u64;
                Some(cached) => {
use opensearch_tiered_storage::registry::TieredStorageRegistry;
                        start, end
                match acc {
///   1. Run DataFusion query (cold start) — all reads go to local FS and populate
        assert_eq!(rows1, 3, "query 1 must return 3 rows");
use parquet::arrow::ArrowWriter;
    let store = TieredObjectStore::new(registry, local).with_cache(cache);
                rg_idx
    let path = Path::from("suffix.parquet");
        assert!(
    use parquet::file::reader::FileReader;
use arrow_array::{Int64Array, RecordBatch, StringArray};
    }
    let file_size = write_test_parquet(parquet_dir.path(), "test.parquet", 3);
        );
    let data_dir = TempDir::new().unwrap();
    let reader = SerializedFileReader::new(file).unwrap();
    let path = Path::from("concurrent.parquet");
            assert_eq!(
        let (col_idx_range, off_idx_range) = compute_per_rg_page_index_ranges(rg);
/// recovered byte-for-byte. If the small CI/OI/postscript entries are lost on Foyer
            .await
/// Returns the SessionContext and the inferred schema. The table is registered as `table_name`.
                .filter_map(|c| {
            if let (Some(offset), Some(length)) =
                let start = offset as u64;
            in_data.is_some() || in_meta.is_some(),
            .into_iter()
        "auto",
    let meta_dir = TempDir::new().unwrap();
            footer_start,
                merged.end, actual_max,
        .with_schema(schema.clone());
    block_on(async {
                &bytes, original,
    );
        file_size,
/// It drains the storage flusher, which does nothing for an entry that has not been submitted to
        Box::pin(async {})
        let data_key = range_cache_key("nopollute.parquet", data_start, data_end);
fn compute_global_page_index_range(
                let vals: Vec<i64> = (offset..offset + 100)
    // Session 1: warmup puts metadata into metadata cache
/// exactly as production does, then assert that EACH warmed range (CI, OI, footer,
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
            }
///
// ── Helpers ─────────────────────────────────────────────────────────────────────
    let path = Path::from("page_idx.parquet");
/// ranges into the metadata tier, drop the caches (FoyerCache::drop flushes +
                && (msg.contains("NotFound") || msg.contains("No such file")),
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
#[test]
        .row_groups()
    // Use small chunk sizes that fit within our actual file size.
        assert!(
        cache.clone(),
    );
        DISK_BYTES,
        assert_eq!(data[0].len(), 4096);
    let datas: Vec<bytes::Bytes> = ranges
        let path = Path::from("small.parquet");
                );
            ));
// ── Small-file + per-range metadata persistence (prod-gap reproduction) ──────
    block_on(async {
    let parquet_dir = TempDir::new().unwrap();
    {
            .await
        .flat_map(|rg| rg.columns().iter())
    // Read file bytes for warmup
    let num_entries = (file_size / chunk_size).max(1);
        0,
        assert!(
        file_size,
        // Read file and compute page index ranges
        assert!(cache.data_cache().get(&data_key).await.is_some());
    let path = Path::from("keyshare.parquet");
/// unless the entry is present in the block engine's in-RAM index, and that index is only
///
struct DeferredPutCache {
    let parquet_metadata = reader.metadata();
        // Reads via store must not error even for ranges that missed metadata cache
        "nopollute.parquet",
        );
#[test]
/// Multiple concurrent reads of same metadata range — all succeed with same bytes.
                (col.offset_index_offset(), col.offset_index_length())
                    hits += 1;
    block_on(async {
            &[footer_bytes],
    let path = Path::from("restart.parquet");
            }
        let mut visible = self.visible.lock().unwrap();
    let listing_options = ListingOptions::new(format).with_file_extension(".parquet");
    {
                recovered_count,
// collapse that triggers the overlap.
            entries.push((start, end, data.clone()));
    for i in 0..num_entries {
            .unwrap()
    });
            let batches = ctx
        let footer_start = file_size.saturating_sub(8 * 1024);
    use parquet::file::serialized_reader::SerializedFileReader;
        .set_column_index_truncate_length(Some(64))
}
#[test]
            .collect()
        );
fn production_warmup_then_query_from_cache_only() {
        // Warmup: put footer into metadata Foyer
        file_size,
                .min()
    );
    block_on(async {
}
    rg: &parquet::file::metadata::RowGroupMetaData,
/// tier a test asserts on varies and each has its own shards.
            assert!(cache.metadata_cache().get(&footer_key).await.is_some(),
            );
            cache.data_cache().get(&small_key).await.is_some(),
    fn as_any(&self) -> &dyn std::any::Any {
/// errors occur — graceful degradation.
            cache.data_cache().get(&footer_key).await.is_none(),
        // Read footer bytes before spawning tasks
    block_on(async {
            .await
use opensearch_block_cache::tiered_block_cache::TieredBlockCache;
    let schema = Arc::new(Schema::new(vec![
                .unwrap();
    // Warmup: put with absolute range key
    }
///
    ));
                "at least the footer must survive SSD recovery (recovered {} of {} ranges)",
        let result = store
        footer_start,
            cache.metadata_cache().get(&footer_key).await.is_some(),
    let data_dir = TempDir::new().unwrap();
                rg_idx
    let meta_dir = TempDir::new().unwrap();
    let file_path = dir.join(filename);
            parquet_dir.path(),
                    "col {} offset_index {}..{} must be within global range {}..{}",
fn datafusion_query_succeeds_from_cache_after_local_file_deleted() {
    );
            "second query (file deleted) must return same rows as first — proves full cache correctness");
/// When metadata cache is full, reads still succeed via local FS / S3.
                    global_range.end
    }
/// DataFusion reads Parquet through the TieredObjectStore, executing a real SQL query.
                assert!(
        BLOCK_SIZE,
                match acc {
    // Compute ONE global merged range — matching parquet crate's range_for_page_index()
    let data_cache = Arc::new(FoyerCache::new(
        let suffix_bytes = result.bytes().await.unwrap();
                let bytes = store.get_range(&path, start..end).await.unwrap();
        assert_eq!(
    let footer_start = file_size.saturating_sub(64 * 1024);
        )
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
/// On restart, warmup re-runs. Previously warmed metadata (footer + page indexes)
    use parquet::file::serialized_reader::SerializedFileReader;
            .unwrap();
        cache.clone(),
    let meta_dir = TempDir::new().unwrap();
        });
///   - postscript: `[size - 8, size]`
        let offset = (rg * 100) as i64;
        "concurrent.parquet",
        let footer_after = store
        DISK_BYTES,
        false,
                .filter_map(|c| c.offset_index_offset().map(|o| o as u64))
        !index_ranges.is_empty(),
        .unwrap();
        None => listing_options
    let path = Path::from("indexed.parquet");
        }
    let mut index_ranges: Vec<std::ops::Range<u64>> = Vec::new();
/// ranges must be found in the cache (key alignment).
    let meta_dir = TempDir::new().unwrap();
        "delete.parquet",
        );
        // Suffix fetch should resolve to same absolute key and hit cache
                        .and_then(|o| c.column_index_length().map(|l| o as u64 + l as u64))
    let original = warmup_metadata(
        let store = create_store(
        // (served from local FS since get_opts doesn't auto-populate)
        }
                     (prod showed only the whole-file footer surviving)",
        file_size,
            bytes2, bytes1,
        "threshold.parquet",
        .set_write_batch_size(50) // force multiple pages per row group
/// Make every entry put so far readable from disk, not just from DRAM.
                let end = start + length as u64;
                "metadata for {} must be retrievable after concurrent warmup",
                .unwrap();
            "footer must be in metadata cache after warmup"
    let meta_dir = TempDir::new().unwrap();
    let metadata_cache = Arc::new(FoyerCache::new(
        // Both must return same bytes
            .await
    table_name: &str,
        BLOCK_SIZE,
    let meta_dir = TempDir::new().unwrap();
    schema: Option<Arc<Schema>>,
}
    let parquet_metadata = reader.metadata();
/// must NOT create duplicate cache entries — verify they use compatible paths.
/// Strategy:
    });
            "must have footer + at least 1 page index range"
        // Metadata untouched
                merged.start, actual_min,
/// for column chunks in IndexedExec path).
                    datas[i],
    let file = std::fs::File::create(&file_path).unwrap();
    );
        Field::new("id", DataType::Int64, false),
    }
        assert!(
                let _ = store.get_ranges(&path, &[start..end]).await;
        "ssd_only.parquet",
        .collect();
            "page index range must NOT be in data Foyer — only metadata Foyer"
    let store = create_store(
/// the recovered SSD state is sufficient to serve all reads without any
            }));
            .unwrap()
        let in_meta = cache.metadata_cache().get(&key).await;
        let bounded_bytes = store
/// the device yet — and with a DRAM capacity counted in ENTRIES across 8 shards, entries do stay
        let err = ctx2
                "RG {} offset_index merged start must equal min offset",
/// Multiple shards warming up in parallel (different files, same TieredBlockCache)
        );
        let data2_key = range_cache_key("nopollute.parquet", 100, 4196);
    let expected_rows;
        assert!(
        data_dir.path(),
        for _ in 0..10 {
        false,
/// logic as `custom_cache_manager.rs`. Then delete the local file. Reading those
            .unwrap()
                &file_bytes[r.start as usize..r.end as usize],
            .map(|c| {
        0,
            global_range.start,
                let end = start + length as u64;
        file_size,
        for (col_idx, col) in rg.columns().iter().enumerate() {
        // Data read (get_ranges) → data cache
    let parquet_dir = TempDir::new().unwrap();
        0,
        parquet_dir.path(),
    {
    }
    let table = ListingTable::try_new(config).unwrap();
    );
}
) -> Arc<TieredObjectStore> {
        "suffix.parquet",
        }
    // Create 5 parquet files simulating 5 shard warmups
                assert_eq!(
const BLOCK_SIZE: usize = 1 * 1024 * 1024;
        assert!(
#[test]
        cache.clone(),
        parquet_dir.path(),
        // source disappears, otherwise query 2 misses and hits the deleted file.
        );
            .await
                    None => Some(start..end),
    assert_eq!(
        // Verify the merged range is tight (start == min offset, end == max offset+length)
    let store = create_store(
        .iter()
    ));
        assert_eq!(
            } else {
        );
                Arc::new(Int64Array::from(vals)) as Arc<dyn arrow_array::Array>
        assert_eq!(
/// consistent, deterministic cache keys that are found on subsequent probes.
                let merged = col_idx_range.as_ref().unwrap();
        );
        let results: Vec<_> = futures::future::join_all(handles)
    );
        writer.write(&batch).unwrap();
                .unwrap();
    let file_size = write_page_indexed_parquet(parquet_dir.path(), "prod.parquet", 3, 4);
        // Read via store — local FS is gone, must succeed from metadata SSD cache
        parquet_dir.path(),
                let recovered = cache.metadata_cache().get(&key).await;
        let data_key = range_cache_key("test.parquet", 0, 4096);
                "repeated read of {}..{} must return same bytes",
/// whole-file footer key.
        "auto",
    metadata: &parquet::file::metadata::ParquetMetaData,
            }
        })
        file_size,
    // Session 1 dropped — FoyerCache::drop() calls HybridCache::close() which
}
    let parquet_dir = TempDir::new().unwrap();
/// page index ranges survive — proving the SSD recovery path works.
                "metadata for {} must not be corrupted by concurrent warmup",
        file_info.push((filename, file_size, footer_bytes));
            {
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
fn small_file_warmed_ranges_survive_restart() {
            let mut recovered_count = 0;
    let reader = SerializedFileReader::new(file).unwrap();
/// 4. Second DataFusion query: must succeed from cache alone
/// `cache.wait_for_flush()` — see that function for why the flusher drain alone leaves these tests
        0.0,
}
/// Our warmup code computes page index ranges by folding column_index_offset/length
/// file has no page index metadata.
                }
    let metadata_cache = Arc::new(FoyerCache::new(
    block_on(async {
/// Folds ALL columns across ALL row groups into a single contiguous range
/// When metadata Foyer SSD fills, new put_metadata calls may fail silently (Foyer
            let store = store.clone();
            let key = range_cache_key("overflow.parquet", start, end);
        }
                .collect()
    );
    const QUERY: &str = "SELECT id FROM t WHERE id < 3 ORDER BY id";
            .map(|r| r.unwrap())
                "warmed range {}..{} ({} bytes) must be in the metadata tier \
            .await
//! Integration tests: TieredObjectStore + TieredBlockCache with real Parquet files.
            "small_restart.parquet",
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    });
/// Note: Foyer's disk recovery may not recover every entry (small entries below
        let batches2 = ctx2
            let actual_min = rg
    cache.update_max_data_entry_size(2048);
        footer_start,
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    use parquet::file::reader::FileReader;
        for (filename, file_size, footer_bytes) in &file_info {
            assert!(
        // Spawn 5 concurrent warmup tasks
        file_size,
    let mut warmed_ranges: Vec<std::ops::Range<u64>> = Vec::new();
    }
        cache.put_metadata(&key, filler.clone());
        for r in &ranges {
                    r.end,
                r.start,
        .iter()
}
    writer.close().unwrap();
        file_size,
    // Session 2: new instances on the same SSD dirs — Foyer recovers from disk.
/// unflushed, deleting the local file makes the cache-only query fail with exactly the
            .await
    );
/// been `put` but not yet flushed is invisible to `get`. The real flusher normally wins that
        );
            }
    // Drain the flusher so both warmup puts are on SSD before the local file goes away.
    let data_dir = TempDir::new().unwrap();
            "reads must succeed regardless of metadata cache pressure"
        Field::new("name", DataType::Utf8, false),
}
        index_ranges.push(r);
        "auto",
            global_range.start, global_range.end);
use tempfile::TempDir;
use arrow::datatypes::{DataType, Field, Schema};
            .unwrap();
    let store = create_store(
        let (ctx, schema) = setup_df_session(store.clone(), "deferred.parquet", "t", None).await;
/// `NotFound` that CI reported: every cache probe misses, `TieredObjectStore::fetch_misses`
    let mut metadata_bytes: Vec<bytes::Bytes> = Vec::new();
        parquet_dir.path(),
fn metadata_foyer_capacity_breach_graceful_degradation() {
                assert!(
            let acc = if let (Some(offset), Some(length)) =
#[test]
                warmed_ranges.len()
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
            file_size,
    // Assert: the exact cache key we expect is in metadata Foyer
    let mut fields: Vec<Field> = Vec::new();
        let parquet_metadata = reader.metadata();
                .columns()
        // get_ranges puts in data_cache, get_range puts in metadata_cache
/// should be recovered from Foyer's SSD tier, not re-fetched from local FS.
    let parquet_dir = TempDir::new().unwrap();
    let file = std::fs::File::open(parquet_dir.path().join("small_restart.parquet")).unwrap();
            .unwrap();
        // Assert: page index range is NOT in data Foyer (put_metadata goes only to metadata)
        0,
            "metadata must survive data cache LRU pressure"
        data_dir.path(),
            range: Some(object_store::GetRange::Suffix(suffix_size)),
    // Write a multi-column file (5 columns, 4 row groups)
        // Now read a column data range via get_range (simulates CachedMetadataReader::get_bytes)
        assert!(
                    );
            store.put_metadata("warm.parquet", &[footer_start..file_size], &[footer_bytes]);
            "get_opts must populate data cache on miss"
                    end,
            .await
        // Drain again: put_metadata is fire-and-forget into the metadata tier.
                store
                .iter()
            // recovered data is byte-for-byte correct (verified above).
            {
    let mut file_info: Vec<(String, u64, bytes::Bytes)> = Vec::new();
/// cache whose flush point is explicit instead of a background task. With the puts still
    });
    });
                    col_idx,
                if let Some(cached) = cache.metadata_cache().get(&key).await {
/// recreate on same dirs. After recovery, verify that the majority of warmed
    let data_dir = TempDir::new().unwrap();
                result, &expected,
            handles.push(tokio::spawn(async move {
                "concurrent read {} must match warmup bytes",
        ));
use opensearch_block_cache::range_cache::{range_cache_key, CacheKey};
/// ranges via the store must succeed from cache — proving key alignment.
    let _file_size = write_page_indexed_parquet(parquet_dir.path(), "parity.parquet", 4, 5);
use object_store::path::Path;
        parquet_dir.path(),
    use parquet::file::serialized_reader::SerializedFileReader;
        assert_eq!(rows2, rows1,
        ranges[2],
    let store = create_store(
        // ── Query 1: cold start, file on local FS ────────────────────────────
#[test]
        &'a self,
    let footer_start = file_size.saturating_sub(8 * 1024);
///   - footer:     `[size - 64KB, size]`  (collapses to `[0, size]` for files < 64KB)
/// [`drain_to_disk`] does for the real cache — makes the same query succeed.
    for i in 0..64u64 {
}
                Some(saved_schema),
/// footer metadata and stores them in metadata Foyer. At query time, the same
            .unwrap();
    ctx.register_table(table_name, Arc::new(table)).unwrap();
                        .and_then(|o| c.offset_index_length().map(|l| o as u64 + l as u64))
        let (ctx2, _) =
                let start = offset as u64;
            .expect_err("unflushed puts + deleted local file must fail, not read from cache");
            .unwrap();
        0,
    );
        std::fs::remove_file(parquet_dir.path().join("prod.parquet")).unwrap();
            .sql("SELECT col_0, col_1 FROM prod WHERE col_0 < 50")
// ── Tests ───────────────────────────────────────────────────────────────────────
        &cache,
        "nopollute.parquet",
            "range < threshold must be cached"
    metadata_ranges.push(footer_start..file_size);
            .sql("SELECT col_0, col_1 FROM prod WHERE col_0 < 50")
        let batches = ctx
/// **Test 6**: Restart — no S3/local FS reads for previously warmed metadata.
        // Read same range via get_range (metadata path → metadata_cache)
                filename
    let meta_dir = TempDir::new().unwrap();
/// CI's I/O contention. Staging the bytes reproduces the same window with no timing dependency.
    }
    std::fs::metadata(&file_path).unwrap().len()
fn block_on<F: std::future::Future>(f: F) -> F::Output {
    let data_dir = TempDir::new().unwrap();
    );
    {
        block_on(async {
/// sharded 8 ways by key hash, so a handful of entries stay resident. The disk write happens when
        parquet_dir.path(),
    // ── Session 1: warmup + query (populates both caches) ────────────────────
use object_store::local::LocalFileSystem;
    let ctx = SessionContext::new();
            .await
        warmup_metadata(
        drain_to_disk(&cache).await;
    ]));
    use datafusion::datasource::file_format::parquet::ParquetFormat;
}
        // Verify metadata is now in metadata_cache
    writer.close().unwrap();
    store
            "restart_full.parquet",
                .sql("SELECT id FROM t WHERE id < 10 ORDER BY id")
        )
            parquet_dir.path(),
        let (ctx, schema) = setup_df_session(store.clone(), "prod.parquet", "prod", None).await;
    let data_dir = TempDir::new().unwrap();
        .map(|r| bytes::Bytes::copy_from_slice(&file_bytes[r.start as usize..r.end as usize]))
        let file_bytes = std::fs::read(parquet_dir.path().join("restart_meta.parquet")).unwrap();
        for (start, end, _) in &entries {
            .unwrap();
// Production logs (warm node, ~3 KB Parquet file) showed that after warmup the
    // Warmup: explicitly put metadata into metadata cache
                .iter()
fn concurrent_shard_warmup_does_not_corrupt() {
        let footer_key = range_cache_key("delete.parquet", footer_start, file_size);
        BLOCK_SIZE,
/// If this test passes, key alignment is proven for ALL byte ranges across the
    warmup_metadata(
                        "cached metadata at {}..{} must match",
        0.0,
/// Foyer may drop entries that exceed capacity (LRU hasn't run yet).
    let path = Path::from("test.parquet");
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        }
    let parquet_dir = TempDir::new().unwrap();
fn concurrent_metadata_reads_are_safe() {
            }
        parquet_dir.path(),
        // put_metadata is fire-and-forget into Foyer's disk-only storage (memory tier = 1 byte);
    let mut writer = ArrowWriter::try_new(file, schema.clone(), Some(props)).unwrap();
///
/// after warmup, then read via store — must succeed from cache.
            let start = (i * 1024) as u64;
        BLOCK_SIZE,
        parquet_dir.path(),
            "restart_full.parquet",
            cache.data_cache().get(&expected_key).await.is_none(),
    ));
        DISK_BYTES,
        // ── Step 3: Delete local file ────────────────────────────────────────
///
        let footer_bytes =
            // At least the footer should be recovered; page index ranges may or may not
        assert!(
        for (i, result) in results.iter().enumerate() {
            cache.clone(),
    block_on(async {
/// A test that needs a `get` to hit must therefore call [`drain_to_disk`], NOT
        // Read first 4KB via get_ranges (data path → data_cache)
        parquet_dir.path(),
///
        .set_max_row_group_row_count(Some(100))
    });
const SUBMIT_QUEUE: usize = 8 * 1024 * 1024;
use opensearch_tiered_storage::types::{FileLocation, TieredFileEntry};
    );
                .unwrap();
        let fetched = store.get_ranges(&path, &ranges).await.unwrap();
        for (filename, file_size, expected_bytes) in &file_info {
        expected_start,
                "t",
fn get_opts_probe_does_not_pollute_metadata_foyer() {
        BLOCK_SIZE,
        &cache,
        // Read multiple ranges — even with small metadata cache, reads succeed
    ));
                    recovered.unwrap(),
                .filter_map(|c| {
    }
            .unwrap()
            &file_bytes[footer_start as usize..file_size as usize],
        let bytes2 = store.get_range(&path, range).await.unwrap();
            let (ctx, schema) =
    // Warmup puts metadata into metadata cache
    ));
        parquet_dir.path(),
        assert_eq!(
fn data_pressure_does_not_evict_metadata() {
            .collect()
            // Use saved schema from session 1 (in production, CatalogSnapshot provides this)
    let range_data: Vec<bytes::Bytes> = index_ranges
    parquet_dir: &std::path::Path,
        0.0,
            let (col_idx_range, off_idx_range) = compute_per_rg_page_index_ranges(rg);
/// 1. Warmup: parse footer, compute page index ranges, put all into metadata Foyer
            visible: std::sync::Mutex::new(std::collections::HashMap::new()),
        // Contrast: reading via get_ranges DOES populate data cache
        let batch = RecordBatch::try_new(
        let mut handles = Vec::new();
    cache: Arc<dyn BlockCache>,
        file_size,
/// largest of its four warmed ranges (`0..13076`, the whole-file range a sub-64KB file's footer
    // alignment behavior with very small entries.
                setup_df_session(store.clone(), "restart_full.parquet", "t", None).await;
    block_on(async {
        DISK_BYTES,
            let key = range_cache_key("overflow.parquet", *start, *end);
            );
    for (rg_idx, rg) in parquet_metadata.row_groups().iter().enumerate() {
}
        "deferred.parquet",
                    None => Some(start..end),
            );
        );
                start, end);
#[test]
        parquet_dir.path(),
/// resident, their disk write deferred until eviction releases them. A `get` right after a `put`
}
    let range_bytes = bytes::Bytes::copy_from_slice(&file_bytes[start as usize..end as usize]);
    let parquet_dir = TempDir::new().unwrap();
        self.visible.lock().unwrap().clear();
/// Both Foyer instances are configured with a DRAM capacity of 1, but that does NOT opt out of
            .await
    let data_dir = TempDir::new().unwrap();
// keys were missing. These tests pin the property that EVERY warmed range must
/// that same entry can instead be evicted with its write still in flight, leaving it in neither
/// persists), then recreate on the same SSD dirs and assert EVERY warmed range is
        file_size,
        let file = std::fs::File::open(parquet_dir.path().join("restart_meta.parquet")).unwrap();
///
    }
                "RG {} offset_index merged end must equal max offset+length",
    use parquet::file::reader::FileReader;
    // Warmup
        cache.update_max_data_entry_size(8192);
                .columns()
    // First, put only the footer into metadata cache via explicit warmup
//! calls block_on() and panics if called inside an existing tokio runtime.
}
        );
    warmup_metadata(
        parquet_dir.path(),
        );
    let data_cache = Arc::new(FoyerCache::new(
            if let (Some(offset), Some(length)) =
    let file_size = write_page_indexed_parquet(parquet_dir.path(), "restart_meta.parquet", 3, 3);
            .unwrap()
                    "range[{}] {}..{} ({} bytes) must survive Foyer SSD recovery \
        }
    ));
            batches2.iter().map(|b| b.num_rows()).sum::<usize>(),
        drain_to_disk(&cache).await;
        // Dynamic update: increase threshold to 8KB — now 4KB is cached
/// metadata from metadata_cache (never-evict) and data from data_cache.
        Self {
                let start = offset as u64;
    // Session 1: warmup puts footer + page index ranges into metadata Foyer
    file_size: u64,
                    recovered_count += 1;
                warmed_data.push(bytes::Bytes::copy_from_slice(
    let cache = Arc::new(DeferredPutCache::new());
        });
        "keyshare.parquet",
        self
    // ── Step 1: Production warmup (same logic as warmup_file_with_store) ─────
        cache.clone(),
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
                    .collect();
        footer_start,
            "get_opts must NOT populate metadata Foyer"
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        1 * 1024 * 1024,
        let range = 0u64..4096;
            cache.data_cache().get(&large_key).await.is_some(),
            "data must be in data cache"
            hits, misses);
        // Confirm in metadata cache, NOT data cache
            {
    });
        // ── Query 2, no drain: this is the CI failure, deterministically ──────────────
        for rg in parquet_metadata.row_groups() {
        let via_range = store.get_range(&path, 0u64..4096).await.unwrap();
        assert!(
    let file_size = write_test_parquet(parquet_dir.path(), "restart.parquet", 2);
        let ids: Vec<i64> = (offset..offset + 100).collect();
        let reader = SerializedFileReader::new(file).unwrap();
        .build();
            let batches = ctx
use object_store::{ObjectStore, ObjectStoreExt};
    let data_cache = Arc::new(FoyerCache::new(
        Arc::new(LocalFileSystem::new_with_prefix(parquet_dir).unwrap());
                .await
/// Session 2: new Foyer instances (same SSD dirs), file deleted → DataFusion query succeeds.
        );
/*
    }
                    r.start,
            }
            .unwrap();
            file_size,
/// Strategy: warmup puts metadata ranges into metadata Foyer, drop caches,
            let filename = filename.clone();
        // Verify each file's metadata is independently correct
    let data_dir = TempDir::new().unwrap();
        .columns()
        // Step 2: Now promote the footer range to metadata_cache.
///    - Metadata (footer): served from metadata Foyer via get_opts probe
#[test]
        "auto",
/// ranges are still available from SSD. Uses the existing `metadata_survives_restart`
        false,
    let store = create_store(
            cache.metadata_cache().get(&footer_key).await.is_some(),
            let cached = cache.metadata_cache().get(&key).await;
        let (ctx, schema) = setup_df_session(store.clone(), "align.parquet", "t", None).await;
    ranges.push(postscript_start..file_size);
    // probing the metadata cache directly. This avoids flakiness from Foyer's block
            .get_range(&path, global_range.start..global_range.end)
                &file_bytes[r.start as usize..r.end as usize],
            ..Default::default()
                "restart_meta.parquet",
/// A range read via get_range (single) and get_ranges (multi with one element)
        // Drain the flusher: put_metadata is fire-and-forget, so every get below would race it.
    let props = WriterProperties::builder()
    );
) -> u64 {
        }
/// place, and the `get` misses.
                    start >= merged.start && end <= merged.end,
            }
#[test]
        &cache,
}
    let data_dir = TempDir::new().unwrap();
        assert!(result.is_ok(),
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
            } else {
    );
        "small-file footer range collapses to the whole file"
    let original_bytes = {
/// Write a Parquet file with page-level statistics (column index + offset index)
        }
        // Page index ranges
}
                cache_clone.put_metadata(&key, footer_bytes);
/// hit data cache on second access (simulates CachedMetadataReader::get_bytes
}
        .with_listing_options(listing_options)
                    start >= global_range.start && end <= global_range.end,
    let meta_dir = TempDir::new().unwrap();
                    start,
    let store = create_store(parquet_dir.path(), cache.clone(), "warm.parquet", file_size);
            metadata_bytes.push(bytes::Bytes::copy_from_slice(
    use parquet::file::serialized_reader::SerializedFileReader;
        data_dir.path(),
        &cache,
#[test]
/// Compute merged column index and offset index ranges per row group.
    let store = create_store(
        file_size,
            assert!(result.is_ok(),
    let file = std::fs::File::open(parquet_dir.path().join("parity.parquet")).unwrap();
                .await
    let mut metadata_ranges: Vec<std::ops::Range<u64>> = Vec::new();
    let path = Path::from("pressure.parquet");
        meta_dir.path(),
            warmed_ranges.len() >= 2,
/// So evict first, then drain. One filler put per shard is not enough — `drain_dram_tier` in
    // Footer
        "auto",
fn warmup_metadata(
/// individual column offsets.
    // Session 2: new instances, same SSD dirs — Foyer recovers
    let meta_dir = TempDir::new().unwrap();
        0,
    let parquet_metadata = reader.metadata();
    block_on(async {
    }
            .get_range(&path, footer_start..file_size)
                let key = range_cache_key(&filename, footer_start, file_size);
            via_ranges[0], via_range,
        file_size,
    cache.put_metadata(&key, range_bytes.clone());
                acc
                assert!(
            {
    let file_size = write_test_parquet(parquet_dir.path(), "pressure.parquet", 5);
    let table_url = ListingTableUrl::parse(&format!("file:///{}", file_path)).unwrap();
    num_row_groups: usize,
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
            "data must be evicted"
    }
        0,
            );
        }
            );
fn unflushed_cache_puts_make_query_after_delete_fail() {
    std::fs::remove_file(parquet_dir.path().join("page_idx.parquet")).unwrap();
            cache.put_metadata(&key, data);
    let footer = warmup_metadata(
    block_on(async {
        let rows2: usize = batches2.iter().map(|b| b.num_rows()).sum();
    let store = create_store(
//
                );
            .await
            let footer_bytes = footer_bytes.clone();
        .register_object_store(&url, store.clone() as Arc<dyn ObjectStore>);
    let data_dir = TempDir::new().unwrap();
///
        "page_idx.parquet",
    block_on(async {
    block_on(async {
) -> bytes::Bytes {
//!
            .await;
                    merged.end
    range_bytes
        cache.clone(),
impl DeferredPutCache {
        block_on(async {
    let file_bytes = std::fs::read(parquet_dir.path().join("small_restart.parquet")).unwrap();
/// Set up a DataFusion session with the store registered and a ListingTable for the given file.
        let small_key = range_cache_key("threshold.parquet", small_range.start, small_range.end);
            assert_eq!(
        file_size,
            );
    // NOTE: we do NOT delete the local file here. Instead, we verify recovery by
        file_size,
    use parquet::file::serialized_reader::SerializedFileReader;
    let store = create_store(
    use datafusion::datasource::listing::{
    let store = create_store(
        // Second read: hits data Foyer (no local FS needed)
    let file_size = write_page_indexed_parquet(parquet_dir.path(), "small_restart.parquet", 1, 11);
        );
    let store = create_store(
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    let footer_start = file_size.saturating_sub(8 * 1024);
    // Put metadata into metadata Foyer (production warmup step)
        assert_eq!(
            msg.contains("deferred.parquet")
        );
    }
    let col_idx_range = rg
        assert!(
                let merged = off_idx_range.as_ref().unwrap();
/// Shared runtime for test async blocks (created lazily, not inside FoyerCache::new).
        // Confirm data in data cache, NOT metadata cache
        // ── Delete local file — cache is the only source now ─────────────────
    block_on(async {
    let file_size = write_test_parquet(parquet_dir.path(), "keyshare.parquet", 2);
    // ── Session 2: new Foyer instances, file gone — query from Foyer only ────
        std::fs::remove_file(parquet_dir.path().join("align.parquet")).unwrap();
    fn get<'a>(
///      data_cache via get_opts/get_ranges. Query succeeds.
        // Read the global page index range via store — must succeed from metadata cache
    // and small max_row_group_size so we get multiple row groups.
            .collect();
    let file_bytes = std::fs::read(parquet_dir.path().join("page_idx.parquet")).unwrap();
        let footer_from_cache = store
        SUBMIT_QUEUE,
        let end = ((i + 1) * chunk_size).min(file_size);
                    &file_bytes[r.start as usize..r.end as usize],
    let meta_dir = TempDir::new().unwrap();
///   3. Run same query again — must succeed entirely from cache (data_cache populated
            setup_df_session(store.clone(), "deferred.parquet", "t", Some(schema.clone())).await;
}
    let store = create_store(
    let registry = Arc::new(TieredStorageRegistry::new());
                    );
            "range > threshold must NOT be cached"
/// the fold produces ranges that cover all column metadata by checking against
#[test]
        assert!(!batches.is_empty());
        let in_data = cache.data_cache().get(&key).await;
        // This populates data_cache with all metadata + data ranges.
             proves full lifecycle: warmup → persist → recover → serve from Foyer only"
use opensearch_block_cache::traits::BlockCache;
    // Tiny metadata cache (1MB disk, 1MB block) — will fill quickly
        if let Some(ref merged) = col_idx_range {
                (col.column_index_offset(), col.column_index_length())
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        0,
        file_size,
            .unwrap();
// land in the never-evict metadata tier, and isolate the small-file footer
            "get_ranges must NOT populate metadata cache"
        .iter()
                cache.metadata_cache().get(&key).await.is_some(),
        "auto",
    use parquet::file::reader::FileReader;
        if let Some(ref merged) = off_idx_range {
fn evict_prefix_clears_both_caches_on_shard_delete() {
fn write_test_parquet(dir: &std::path::Path, filename: &str, num_row_groups: usize) -> u64 {
        TieredFileEntry::with_size(FileLocation::Local, None, file_size),
        // Shard delete
    std::fs::remove_file(parquet_dir.path().join("restart_full.parquet")).unwrap();
            "footer must be in metadata cache"
        BUFFER_POOL,
        for i in 0..10 {
                    "RG {} col {} offset_index range {}..{} must be contained in merged {}..{}",
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
    std::fs::metadata(&file_path).unwrap().len()
///
use opensearch_tiered_storage::tiered_object_store::TieredObjectStore;
        DISK_BYTES,
    let file_size = write_test_parquet(parquet_dir.path(), "warm.parquet", 2);
}
        let batches2 = ctx2
    static RT: std::sync::OnceLock<tokio::runtime::Runtime> = std::sync::OnceLock::new();
        let _data = store.get_ranges(&path, &[0u64..4096]).await.unwrap();
///      by step 1). This proves the keys produced by DataFusion's read path are the
        &cache,
        path_str,
        let batches2 = ctx2
                recovered_count >= 1,
        assert!(result.is_ok(), "get_range must succeed");
        cache.clone(),
        false,
/// Same shape as `datafusion_query_succeeds_from_cache_after_local_file_deleted`, but with a
        file_size,
        cache.clone(),
        let (rows, schema) = block_on(async {
        file_size,
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
            vec![
    let mut entries: Vec<(u64, u64, bytes::Bytes)> = Vec::new();
        footer_start,
            let key = range_cache_key(filename, footer_start, *file_size);
                    start >= merged.start && end <= merged.end,
            assert_eq!(bytes, original_bytes, "metadata must survive restart");
}
        "overflow.parquet",
                    r.end - r.start
///
                .collect()
        let footer_bytes = bytes::Bytes::copy_from_slice(&file_bytes[footer_start as usize..]);
        if end > start && (end as usize) <= file_bytes.len() {
                }
    assert!(
    store.put_metadata("page_idx.parquet", &index_ranges, &range_data);
}
        parquet_dir.path(),
        });
    });
            .unwrap()
        );
    let meta_dir = TempDir::new().unwrap();
    let file_size = write_test_parquet(parquet_dir.path(), "overflow.parquet", 10);
        for map in [&self.staged, &self.visible] {
    let file_size = write_test_parquet(parquet_dir.path(), "align.parquet", 2);
    let parquet_dir = TempDir::new().unwrap();
    let footer_start = file_size.saturating_sub(8 * 1024);
        cache.flush();
        footer_start,
                let end = start + length as u64;
            .collect()
        // put() entries are on SSD and findable via get()" — so the verification reads are deterministic.
        let footer_key = range_cache_key("test.parquet", footer_start, file_size);
    let store = create_store(parquet_dir.path(), cache.clone(), "prod.parquet", file_size);
    block_on(async {
                warmed_ranges.push(r);
///   - CI + OI page-index whole regions (via the real `compute_page_index_range`)
            {
fn suffix_fetch_resolves_and_hits_cache() {
/// is then answered out of DRAM without the entry ever reaching the device; under full-suite load
        false,
        // First read: cache miss → local FS → populate data Foyer
            "get_ranges must populate data cache"
    let footer_start = file_size.saturating_sub(8 * 1024);
    block_on(drain_to_disk(&cache));
    let chunk_size = 1024u64; // 1KB chunks — small enough for our test file
            let actual_min = rg
        "suffix.parquet",
/// Deterministic reproduction of the flake that the [`drain_to_disk`] calls above fix.
    });
///
        let df = ctx
    }
    });
    let schema = Arc::new(Schema::new(fields));
        assert!(
    ranges
    let suffix_size = 4096u64;
/// DataFusion query succeeds entirely from cache.
        cache.clone(),
fn metadata_routed_to_metadata_cache_data_to_data_cache() {
fn datafusion_query_through_tiered_store() {
    let expected_start = file_size - suffix_size;
    let meta_dir = TempDir::new().unwrap();
            .await
                .await
        0,
    let file = std::fs::File::open(parquet_dir.path().join("page_idx.parquet")).unwrap();
/// **HIGH-CONFIDENCE TEST**: Full production warmup sequence → delete file →
                );
            setup_df_session(store.clone(), "deferred.parquet", "t", Some(schema)).await;
                (col.column_index_offset(), col.column_index_length())
                assert!(
    });
    assert_eq!(
            metadata_ranges.push(r);
    );
        "ssd_only.parquet",
    let parquet_dir = TempDir::new().unwrap();
    let parquet_dir = TempDir::new().unwrap();
///
#[test]
    let format = Arc::new(ParquetFormat::default());
            let path = path.clone();
        cache.put(&key, filler.clone());
}
}
        assert!(!bytes.is_empty());
    }
    metadata: &parquet::file::metadata::ParquetMetaData,
        );
#[test]
            .await
        let bytes1 = store.get_range(&path, range.clone()).await.unwrap();
            .get_range(&path, footer_start..file_size)
                    i,
        self.staged.lock().unwrap().clear();
use opensearch_tiered_storage::registry::traits::FileRegistry;
        self.staged.lock().unwrap().insert(key.clone(), data);
        );
        &cache,
        SUBMIT_QUEUE,
            cache.clone(),
                warmed_ranges[0].start,
        let batch = RecordBatch::try_new(schema.clone(), columns).unwrap();
    let key = range_cache_key(filename, start, end);
        let large_range = 0u64..4096.min(file_size);
            handle.await.unwrap();
                .unwrap()
            visible.insert(key, data);
    // Write a multi-column file with page indexes enabled
        };
    RT.get_or_init(|| tokio::runtime::Runtime::new().unwrap())
        parquet_dir.path(),
        SUBMIT_QUEUE,
/// enabled. Returns the file size.
                r.end - r.start
        0,
        .map(|r| bytes::Bytes::copy_from_slice(&file_bytes[r.start as usize..r.end as usize]))
    metadata_bytes.push(bytes::Bytes::copy_from_slice(
// metadata tier's key_index.json contained ONLY the whole-file footer key
    let parquet_dir = TempDir::new().unwrap();
#[test]
        assert!(cache.metadata_cache().get(&footer_key).await.is_some());
/// behavior). Reads should still work for entries that survived, and no panics or
/// **Test 1**: Page index key alignment — warmup computes page index ranges from
                    assert_eq!(
/// must not interfere. After all complete, each file's metadata is independently
    let url = url::Url::parse("file://").unwrap();
            cache.metadata_cache().get(&footer_key).await.is_some(),
/// Session 1: production warmup + DataFusion query (populates both caches)
            let start = (i * 1024) as u64;
#[allow(deprecated)]
        cache.clone(),
                let start = offset as u64;
                warmed_ranges[0].end,
        assert!(
        file_size,
    let meta_dir = TempDir::new().unwrap();
    num_columns: usize,
    }
        if let Some(r) = off_idx_range {
        // Metadata read via get_range → get_opts → cache probe HIT
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        for (key, data) in staged.drain() {
        }
            .get_range(&path, footer_start..file_size)
    let path = Path::from("ssd_only.parquet");
        // Read 4KB range (> 2KB threshold) — should NOT be cached
    let global_range = &index_ranges[0];
    const FILLER: [u8; 1024] = [0xBB; 1024];
            staged: std::sync::Mutex::new(std::collections::HashMap::new()),
        let key = range_cache_key("keyshare.parquet", 0, 4096);
            assert!(
                    global_range.start,
        .fold(None::<std::ops::Range<u64>>, |acc, col| {
    let saved_schema;
    ) -> std::pin::Pin<Box<dyn std::future::Future<Output = Option<bytes::Bytes>> + Send + 'a>>
 *
                start, end
            ],
        let store = create_store(
        &cache,
        BLOCK_SIZE,
async fn setup_df_session(
        let bytes = store.get_range(&path, large_range.clone()).await.unwrap();
    let path = Path::from("threshold.parquet");
        index_ranges.len()
    let store = create_store(
                    &file_bytes[r.start as usize..r.end as usize],
    }
) -> Option<std::ops::Range<u64>> {
    let parquet_dir = TempDir::new().unwrap();
                    end,
                None => {
            file_size,
/// block alignment may be lost), so we verify that at least the footer and some
            "restart query (file deleted, new Foyer instances) must return same rows — \
        false,
            file_size,
//! Uses `#[test]` (not `#[tokio::test]`) because FoyerCache::new() internally
                        "recovered range {} ({}..{}) bytes must match original warmup data",
                let end = start + length as u64;
    let data_dir = TempDir::new().unwrap();
        false,
    let data_dir = TempDir::new().unwrap();
    {
                match acc {
        let result = store.get_opts(&path, opts).await.unwrap();
                let start = offset as u64;
/// either way.
/// Suffix fetch resolves to correct absolute range and hits metadata cache.
/// reproducing the production symptom.
}
            let (ctx, _) = setup_df_session(
                }
            }
                    col_idx,
        assert!(hits > 0,
        }
    let file_size = write_test_parquet(parquet_dir.path(), "breach.parquet", 10);
}
                warmed_ranges.push(r);
        file_size,
            cache.data_cache().get(&key).await.is_some(),
                .max()
    let footer_start = file_size.saturating_sub(8 * 1024);
/// get_opts skips caching for ranges exceeding max_cache_entry_size.
fn create_tiered_cache(
            .await
            match cache.metadata_cache().get(&key).await {
        for (start, end, expected) in &entries {
    let file_size = write_test_parquet(parquet_dir.path(), "query.parquet", 2);
        }
    let file_size = write_page_indexed_parquet(parquet_dir.path(), "page_idx.parquet", 3, 5);
/// **HIGH-CONFIDENCE TEST**: Restart with file deleted — Foyer is the ONLY source.
        // ── Query 2: same query, file gone — must succeed from cache ─────────
    let mut ranges = crate::cache::custom_cache_manager::compute_page_index_range(metadata);
            } else {
    let props = WriterProperties::builder()
        SUBMIT_QUEUE,
        let offset = (rg * 100) as i64;
    let file_size = write_test_parquet(parquet_dir.path(), "delete.parquet", 2);
    let path = Path::from("breach.parquet");
    let file_size = write_test_parquet(parquet_dir.path(), "restart_full.parquet", 2);
}
    fn flush(&self) {
    };
                .await
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
use parquet::file::properties::WriterProperties;
/// This exercises the EXACT production path:
                acc
    let file = std::fs::File::open(parquet_dir.path().join("small.parquet")).unwrap();
                .get_range(&path, footer_start..file_size)
use std::sync::Arc;
        }
#[test]
    let file_size = write_test_parquet(parquet_dir.path(), "nopollute.parquet", 3);
        let data2 = store.get_ranges(&path, &[100u64..4196]).await.unwrap();
                .columns()
/// **Test 2**: Concurrent shard warmup does not corrupt shared metadata Foyer.
    let file_size = write_test_parquet(parquet_dir.path(), "concurrent.parquet", 2);
    // Write a large parquet file
            "after the flush the same query must succeed from cache with no local file"
            .sql(QUERY)
    let parquet_dir = TempDir::new().unwrap();
    assert!(
    let config = ListingTableConfig::new(table_url)
            cache.metadata_cache().get(&expected_key).await.is_some(),
                (col.column_index_offset(), col.column_index_length())
            assert_eq!(
        let footer_start = file_size.saturating_sub(8 * 1024);
fn warmup_put_metadata_then_datafusion_query_from_cache() {
        );
fn metadata_served_from_ssd_not_local_fs() {
    // Warmup metadata + populate data
        std::fs::remove_file(parquet_dir.path().join("warm.parquet")).unwrap();
            let actual_max = rg
                i
            "page index bytes must match warmup data byte-for-byte"
    let path = Path::from("nopollute.parquet");
        let via_ranges = store.get_ranges(&path, &[0u64..4096]).await.unwrap();
/// A [`BlockCache`] that defers publication: `put` stages bytes where `get` cannot see them
    store.registry().register(
        let (ctx3, _) =
    });
    parquet_dir: &std::path::Path,
            .await
                    rg_idx,
            parquet_dir.path(),
                    Some(a) => Some(a.start.min(start)..a.end.max(end)),
        assert_eq!(
    // Assert: the global page index range covers ALL individual column offsets
        0.0,
            );
            // get_range → get_opts → cache probe → HIT (recovered from SSD)
fn production_warmup_ranges(
                acc
        .fold(None::<std::ops::Range<u64>>, |acc, col| {
    let parquet_dir = TempDir::new().unwrap();
            cache.data_cache().get(&data_key).await.is_none(),
        // All reads succeed — no panics, no errors regardless of cache state
        SUBMIT_QUEUE,
    // (col_count=11, rg_count=1, size ≈ 3 KB).
        assert_eq!(
            parquet_dir.path(),
    data_dir: &std::path::Path,
                    None => Some(start..end),
#[test]
            let file_size = *file_size;
        let (ctx2, _) = setup_df_session(store.clone(), "warm.parquet", "t", Some(schema)).await;
            let key = range_cache_key("small.parquet", r.start, r.end);
    let store = create_store(parquet_dir.path(), cache.clone(), "test.parquet", file_size);
 */
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        // ── Warmup: read metadata through store, then promote to metadata_cache ──
}
            metadata_ranges.push(r);
    let parquet_dir = TempDir::new().unwrap();
    let num_shards = 5;
        BUFFER_POOL,
            "restart.parquet",
        );
    // ── Delete local file between sessions ───────────────────────────────────
/// DRAM caching: the default weighter counts ENTRIES, not bytes, and the in-memory cache is
        let mut hits = 0;
            {
                    None => Some(start..end),
                warmed_data.push(bytes::Bytes::copy_from_slice(
    let footer = warmup_metadata(
    block_on(drain_to_disk(&cache));
        );
///
        drain_to_disk(&cache).await;
/// Compute the warmup ranges exactly as `custom_cache_manager::warmup_file_with_store`:
    let data_cache = Arc::new(FoyerCache::new(
            {
        std::fs::remove_file(parquet_dir.path().join("indexed.parquet")).unwrap();
        0.0,
    });
        0,
    let mut writer = ArrowWriter::try_new(file, schema.clone(), Some(props)).unwrap();
    let file_size = write_page_indexed_parquet(parquet_dir.path(), "small.parquet", 1, 11);
            .unwrap()
///    - Column data: served from data Foyer via get_ranges probe
        drain_to_disk(&cache).await;
                (col.offset_index_offset(), col.offset_index_length())
            );
            })
    // 11 columns × 1 row group → a few-KB file, matching the production shape
    ));
        use object_store::GetOptions;
    let cache = Arc::new(TieredBlockCache::new(data_cache, metadata_cache));
    for rg in 0..num_row_groups {
    );
        // (full test suite) a get() issued immediately after can miss an entry still queued in the
///
            "second read must return same bytes from data Foyer cache"
#[test]
        .block_on(f)
    let data_dir = TempDir::new().unwrap();
            cache.clone(),
    };
/// through get_opts. This must NOT put column data bytes into metadata Foyer.
        }
            .collect()
            .await
                    start,
        let key = range_cache_key("__drain_filler__", i * 1024, (i + 1) * 1024);
    // Read footer and compute page index ranges using the shared helper
        assert!(
        assert!(
        assert_eq!(
            cache.metadata_cache().get(&footer_key).await.is_none(),
        let batches = ctx
/// **Test 5**: get_opts probe does NOT pollute metadata Foyer with column data.
                .max()
    let parquet_dir = TempDir::new().unwrap();
        "breach.parquet",
            map.lock()
            .sql("SELECT id FROM t WHERE id < 5 ORDER BY id")
                    .unwrap()
        );
    let meta_dir = TempDir::new().unwrap();
                    "col {} column_index {}..{} must be within global range {}..{}",
    let data_dir = TempDir::new().unwrap();
        // First, let DataFusion do a full query to discover what ranges it needs.
///
                    start,
/// block-cache-foyer's own tests makes the same point — hence 64, into both tiers, since which
            ));
/// Returns two optional ranges per RG: (column_index_range, offset_index_range).
/// Warmup puts metadata via store.put_metadata(), then DataFusion query reads
        store.put_metadata("restart_meta.parquet", &warmed_ranges, &warmed_data);
        .columns()
        drain_to_disk(&cache).await;
        let hit = self.visible.lock().unwrap().get(key).cloned();
/// Measured on `small_file_warmup_persists_every_range_to_metadata_tier`, which fails on the
    let data_dir = TempDir::new().unwrap();
}
    {
                    .get_range(&path, footer_start..file_size)
                merged.end, actual_max,
        let mut misses = 0;
fn restart_with_file_deleted_query_succeeds_from_foyer_only() {
        false,
            suffix_bytes, bounded_bytes,
    let ranges = production_warmup_ranges(reader.metadata(), file_size);
/// This models Foyer's disk-only behaviour deterministically. In Foyer, a lookup returns a miss
    let metadata_cache = Arc::new(FoyerCache::new(
                .iter()
    let parquet_dir = TempDir::new().unwrap();
        let columns: Vec<Arc<dyn arrow_array::Array>> = (0..num_columns)
    // Drain the flusher so the warmup put is on SSD before its only other source disappears.
        BUFFER_POOL,
    let store = create_store(
    let file_size = write_test_parquet(parquet_dir.path(), "deferred.parquet", 2);
            &[footer_start..file_size],
    );
                .unwrap();
/// After warmup, the local file is deleted to prove all reads come from cache.
            .collect()
        let batches = ctx.sql(QUERY).await.unwrap().collect().await.unwrap();
        let opts = GetOptions {
        let mut staged = self.staged.lock().unwrap();
///
            assert!(
        "small.parquet",
        // insert() returns before the storage flusher persists the entry. Under heavy parallel load
            let end = start + 102400;
    let meta_dir = TempDir::new().unwrap();
///
    // Session 2: new Foyer instances on same directories — should recover from SSD
    let meta_dir = TempDir::new().unwrap();
    });
    );
        Box::pin(async move { hit })
                let footer_start = file_size.saturating_sub(8 * 1024);
    use parquet::file::serialized_reader::SerializedFileReader;
        parquet_dir.path(),
    fn put(&self, key: &CacheKey, data: bytes::Bytes) {
            .await
            let result = store.get_range(&path, *start..*end).await;
        let batches3 = ctx3.sql(QUERY).await.unwrap().collect().await.unwrap();
    let file_size = write_test_parquet(parquet_dir.path(), "threshold.parquet", 5);
            file_size,
        );
        let bytes = result.unwrap();
    block_on(async {
        2 * 1024 * 1024,
            "must serve from SSD cache after local deletion"
        }
            bytes::Bytes::copy_from_slice(&file_bytes[footer_start as usize..file_size as usize]);
///   2. Delete local file.
            if end <= file_size {
    // Set threshold to 2KB — anything larger skips caching
            .sql("SELECT id FROM t WHERE id < 3 ORDER BY id")
        let _ = store.get_range(&path, large_range.clone()).await.unwrap();
        let key = range_cache_key("indexed.parquet", 0, 4096);
fn page_index_ranges_match_parquet_crate_computation() {
        data_dir,
            rows3, 3,
    // Write a larger file to have enough data to fill cache
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        assert_eq!(
    warmup_metadata(
async fn drain_to_disk(cache: &TieredBlockCache) {
/// encompassing all column_index and offset_index data. Returns `None` if the
) -> Arc<TieredBlockCache> {
        parquet_dir.path(),
        .iter()
    let parquet_dir = TempDir::new().unwrap();
 * this file be licensed under the Apache-2.0 license or a
    let meta_dir = TempDir::new().unwrap();
        // Fill data cache to trigger eviction
                    rg_idx,
        );
        .iter()
        let rows2: usize = batches2.iter().map(|b| b.num_rows()).sum();
            "metadata must be evicted"
    let meta_dir = TempDir::new().unwrap();
///
        0..file_size,
            batches.iter().map(|b| b.num_rows()).sum::<usize>()
    }
            let actual_max = rg
    let parquet_dir = TempDir::new().unwrap();
        file_size,
            }
        let store = create_store(
    let parquet_dir = TempDir::new().unwrap();
    let schema = match schema {
        parquet_dir.path(),
                Arc::new(Int64Array::from(ids)),
    let footer_start = file_size.saturating_sub(8 * 1024);
                match acc {
                    start,
                 (prod showed only the footer key persisting)",
/// Fill data cache beyond capacity, verify metadata is untouched.
    ));
            rows2, 3,
        // ── Query 1: file present. Populates the cache — every put is staged, not visible ──
    // No panics must have occurred. Now verify graceful degradation.
}
            if end <= file_size {
    // Also warmup the footer (last 8KB)
    }
                }
            "footer must NOT be in data cache"
    let local: Arc<dyn ObjectStore> =
        let file_bytes = std::fs::read(parquet_dir.path().join("restart_full.parquet")).unwrap();
            );
    let store = create_store(
            .unwrap();
                rg_idx
#[test]
}
    let cache = Arc::new(TieredBlockCache::new(data_cache, metadata_cache));
    let store = create_store(
    visible: std::sync::Mutex<std::collections::HashMap<CacheKey, bytes::Bytes>>,
                *expected_bytes,
    let file = std::fs::File::open(parquet_dir.path().join("prod.parquet")).unwrap();
        let (ctx2, _) = setup_df_session(store.clone(), "prod.parquet", "prod", Some(schema)).await;
            let cache_clone = cache.clone();
/// Key alignment test: warmup via put_metadata, then DataFusion query hits cache.
                .await
            .unwrap();
            "data must NOT be in metadata cache"
        store.evict_path("delete.parquet");
}
        "test file must have page index data; got {} ranges",
    );
    let file_size = write_test_parquet(parquet_dir.path(), "indexed.parquet", 3);
    block_on(async {
        4,
    let parquet_dir = TempDir::new().unwrap();
}
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
            let data = bytes::Bytes::copy_from_slice(&file_bytes[start as usize..end as usize]);
    block_on(async {
        // Delete file to prove it comes from cache
        );
            "global page index range ({}..{}) must be served from metadata cache after file deletion",
        let small_range = 0u64..1024.min(file_size);
            "restart_meta.parquet",
        // ── Delete local file — all subsequent reads must come from cache ────
 * compatible open source license.
        "concurrent.parquet",
        let mut handles = Vec::new();
                cached.is_some(),
    // Root-cause quirk: for a sub-64KB file the footer range is the whole file.
/// postscript) is individually present in the metadata tier — not just the
#[test]
    let file_size = write_test_parquet(parquet_dir.path(), "ssd_only.parquet", 2);
            .sql("SELECT id FROM t WHERE id < 3 ORDER BY id")
            "query after file deletion must succeed from cache (metadata in metadata_cache)"
/// an entry is RELEASED by DRAM eviction, not at insert time, and `put`/`insert` is fire-and-forget
fn page_index_key_alignment_warmup_matches_query_time() {
        // Drain the flusher first: the warmup put_metadata and the first query's data puts
/// full stack: warmup → DataFusion → TieredObjectStore → TieredBlockCache → Foyer.
    (ctx, schema)
        if let Some(footer_bytes) = cache.get(&footer_key).await {
            setup_df_session(store.clone(), "query.parquet", "test_table", None).await;
            metadata_bytes.push(bytes::Bytes::copy_from_slice(
) -> (Option<std::ops::Range<u64>>, Option<std::ops::Range<u64>>) {
#[allow(deprecated)]
            let footer_key = range_cache_key(
        .set_max_row_group_row_count(Some(100))
    let file_bytes = std::fs::read(parquet_dir.path().join("overflow.parquet")).unwrap();
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        "fixture must be smaller than the 64KB footer prefetch"
        parquet_dir.path(),
        // Drain the flusher first: query 1's puts must be on SSD before their only other
                        &cached, expected,
        cache.clone(),
        BUFFER_POOL,
    // Delete local file — force subsequent reads to come from cache only
            global_range.end
    });
            // critical for restart without S3 calls.
    use parquet::file::reader::FileReader;
            }
        assert!(expected_rows > 0);
        // Wait for all warmups to complete
            schema.clone(),
    ));
    // Session 1 dropped — Foyer flushes to SSD
        "page_idx.parquet",
    use parquet::file::reader::FileReader;
                .unwrap();
        // Put all ranges into metadata Foyer
    store.put_metadata("prod.parquet", &metadata_ranges, &metadata_bytes);
                "restart_full.parquet",
 * SPDX-License-Identifier: Apache-2.0
        let store = create_store(
            } else {
        // The key is the same regardless of path
    let meta_dir = TempDir::new().unwrap();
/// Strategy: warmup puts page index ranges into metadata Foyer using the same fold
        let file_size = write_test_parquet(parquet_dir.path(), &filename, 2 + i);
    );
///
    fn clear(&self) -> std::pin::Pin<Box<dyn std::future::Future<Output = ()> + Send + '_>> {
/// SSD recovery while the larger footer survives, this fails on those ranges —
    path_str: &str,
            }
        let footer_start = file_size.saturating_sub(64 * 1024);
    let path = Path::from("delete.parquet");
    );
                let start = offset as u64;
    );
                );
            .await;
            if let (Some(offset), Some(length)) =
                    global_range.end
        // below misses, put_metadata never runs, and the metadata_cache assert after it fails.
    store: Arc<TieredObjectStore>,
    let data_dir = TempDir::new().unwrap();
/// correct and retrievable.
        store.put_metadata("small_restart.parquet", &ranges, &datas);
                .min()
    for rg in 0..num_row_groups {
    });
                    col_idx,
    let file_size = write_test_parquet(parquet_dir.path(), "suffix.parquet", 2);
                .unwrap();
    let file_bytes = std::fs::read(&file_path).unwrap();
        // Repeated reads also succeed (from local FS — get_opts does not auto-populate cache)
        let data_end = 4096u64;
    let meta_dir = TempDir::new().unwrap();
impl BlockCache for DeferredPutCache {
            !all_bytes.is_empty(),
        });
        assert_eq!(rows1, 3, "query 1 must return 3 rows");
                        &cached, expected,
        // must be on SSD before their only other source disappears.
            assert_eq!(
                }
    block_on(async {
        });
    let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
        meta_dir.path(),
            .infer_schema(&ctx.state(), &table_url)
        let cache = create_tiered_cache(data_dir.path(), meta_dir.path());
            .await
use opensearch_block_cache::foyer::foyer_cache::FoyerCache;
                    misses += 1;
            };
            cache.data_cache().get(&data2_key).await.is_some(),
            "range must be cached in at least one tier"
            cache.metadata_cache().get(&key).await.is_none(),
                    start >= global_range.start && end <= global_range.end,
                ));
                    global_range.start,
            file_size,
            "first read must populate data Foyer"
    let expected_key = range_cache_key("page_idx.parquet", global_range.start, global_range.end);
        assert_eq!(data2[0].len(), 4096);
            "suffix fetch must resolve to same bytes as bounded range"
    (col_idx_range, off_idx_range)
            );
            "footer must be in metadata_cache after put_metadata"
        );
    let store = Arc::new(store);
    // Enable page-level statistics by setting write_page_index(true)
        parquet_dir.path(),
        let (col_idx_range, off_idx_range) = compute_per_rg_page_index_ranges(rg);
                .sql("SELECT id FROM t WHERE id < 10 ORDER BY id")
    let parquet_dir = TempDir::new().unwrap();
                    c.offset_index_offset()
                let end = start + length as u64;
        );
            let end = start + 4096;
                    col_idx,
    let data_dir = TempDir::new().unwrap();
            parquet_dir.path(),
            "expected the NotFound that CI reported, got: {msg}"
) -> (datafusion::prelude::SessionContext, Arc<Schema>) {
        0.0,
            // depending on Foyer's block packing. The key correctness guarantee is that
            &cache,
    let data_dir = TempDir::new().unwrap();
    let data_dir = TempDir::new().unwrap();
            cache.metadata_cache().get(&data_key).await.is_none(),
    if let Some(r) = compute_global_page_index_range(parquet_metadata) {
}
/// This proves that across a full restart (new process, new Foyer instances),
    }
                ));
        assert!(
            let bytes = store.get_range(&path, *start..*end).await.unwrap();
    let meta_dir = TempDir::new().unwrap();
    {
                acc
        file_size,
            for (i, r) in ranges.iter().enumerate() {
        // This goes through get_opts path
        );
            let bytes = store
    let off_idx_range = rg
        assert!(cache.metadata_cache().get(&data_key).await.is_none(),
/// This validates that get_opts (metadata path) and get_ranges (data path) produce
                rg_idx
/// written by the storage flusher once the block has reached the device — so an entry that has
            "at least some metadata entries must survive capacity pressure (got {} hits, {} misses)",
        );
        assert!(
        let footer_key = range_cache_key("warm.parquet", footer_start, file_size);
                    recovered.is_some(),
        parquet_dir.path(),
        // Drain first: query 1's data-tier puts are fire-and-forget, so without this the read
    for rg in parquet_metadata.row_groups() {
        let rows = block_on(async {
        // ── Query 3, after the drain: succeeds from cache alone ───────────────────────
        let footer_start = file_size.saturating_sub(64 * 1024);
                store.clone(),
    });
/// At query time, column data reads via CachedMetadataReader::get_bytes() go
        footer_start,
    ctx.runtime_env()
                "RG {} column_index merged end must equal max offset+length",
    // ── Step 2: First DataFusion query (populates data Foyer with column data) ──
            {
fn get_opts_populates_data_cache_on_miss() {
/// falls back to the local store, and the file it wants is gone. Flushing first — what
        "pressure.parquet",
                assert!(
            let rows = batches.iter().map(|b| b.num_rows()).sum::<usize>();
/// flaky, and what the failure looks like when it does.
        parquet_dir.path(),
        // Must match what we put via absolute range
/// 3. Delete the local Parquet file (simulates warm node with no local copy)
    fn new() -> Self {
            cache.clone(),
            bytes, range_data[0],
                r.end,
    let store = create_store(
    let file_path = dir.join(filename);
/// collapses to — the widest write window): 2 of 10 full-suite rounds failed with
        BLOCK_SIZE,
                    end,
    meta_dir: &std::path::Path,
    assert!(file_size < 64 * 1024);
        cache.clone(),
            .sql("SELECT id FROM t WHERE id < 5 ORDER BY id")
        assert_eq!(bytes1.len(), 4096);
    warmup_metadata(
/// race within microseconds, which is why the tests here pass on an idle machine and fail under
        "pressure.parquet",
                Arc::new(StringArray::from(names)),
        cache.clone(),
        // Verify that every individual column's range is fully contained within the merged range
        BUFFER_POOL,
///
        meta_dir.path(),
        parquet_dir.path(),
        }
                let end = start + length as u64;
) -> Vec<std::ops::Range<u64>> {
        );
                "get_range({}..{}) must succeed (graceful degradation) even under capacity pressure",
        });
fn restart_no_s3_for_previously_warmed_metadata() {
        let mut all_bytes = Vec::new();
        });
        parquet_dir.path(),
        "test.parquet",
        "auto",
            "restart_full.parquet",
        drain_to_disk(&cache).await;
            if let (Some(offset), Some(length)) =
        assert!(
        let from_cache = store
            "after threshold increase, 4KB range must be cached"
                    .map(|v| v + (c as i64 * 1000))
                all_bytes.push((start, end, bytes));
        }
///
            "restart.parquet",
    // Delete local file — all reads must come from metadata cache
fn write_page_indexed_parquet(
                let start = offset as u64;
                );
        }
                    merged.end
        file_size,
            )
            assert_eq!(
        let rows1: usize = batches.iter().map(|b| b.num_rows()).sum();
    let meta_dir = TempDir::new().unwrap();
        BUFFER_POOL,
        0,
    let meta_dir = TempDir::new().unwrap();
    let footer_start = file_size.saturating_sub(64 * 1024);
    {
            "get_range and get_ranges must return same bytes"
            handles.push(tokio::spawn(async move {
            cache.data_cache().get(&data_key).await.is_some(),
        for i in 0..20 {
        cache.clone(),
        "delete.parquet",
fn get_opts_skips_caching_for_large_ranges() {
///
/// Only warmup's explicit put_metadata() should populate metadata Foyer.
fn metadata_survives_restart_via_foyer_recovery() {
        fields.push(Field::new(format!("col_{}", i), DataType::Int64, false));
    let data_dir = TempDir::new().unwrap();
        saved_schema = schema;
/// The threshold is configurable and dynamically updatable.
        1 * 1024 * 1024,
            // The footer (range 0) must survive — it is the largest entry and most
fn small_file_warmup_persists_every_range_to_metadata_tier() {
        let start = i * chunk_size;
}
        expected_rows = rows;
        let footer_key = range_cache_key("nopollute.parquet", footer_start, file_size);
    // Must have a page index range (proves our test file has page indexes)
            .collect();
                    "RG {} col {} column_index range {}..{} must be contained in merged {}..{}",
#[test]
                .iter()
        assert!(
        cache.clone(),
                }
    let parquet_dir = TempDir::new().unwrap();
    start: u64,
            from_cache, original,
    // flushes partial blocks to SSD. No sleep needed.
    }
            if let Some(r) = col_idx_range {
        );
