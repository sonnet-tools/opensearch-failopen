        );
        assert_eq!(
    cols: Vec<usize>,
}
//!
        const ROWS: i32 = 256;
        );
                },
        // Deprecated but the only PUBLIC column-subset decoder (arrow-rs#8643).
    /// full miss that re-decoded `price`.)
        assert!(
        let rgm = footer_meta.row_group(rg);
    }
    }
    }
    #[tokio::test]
            .unwrap();
        assert_eq!(
    /// n1∪s1∪{0}) — the shared cols (0, n1) hit; only the genuinely new projected
            .set_write_batch_size(5)
            .await
        .collect();
    Some(matrix)
            Field::new("price", DataType::Int32, false),
        assert_eq!(
            (ci().hits, ci().misses, ci().entries),
        let (store, loc) = stage(bytes.clone()).await;
        let _g = lock_process_globals();
use arrow::array::{ArrayRef, BooleanArray, UInt64Array};
        )
            Field::new("qty", DataType::Int32, false),
    }
        assert_eq!(
        #[allow(deprecated)]
            .await
        // All empty — nothing to build.
        b.append_row_count(rg.num_rows());
    // reader, our indexed pruner) index it by absolute column and dereference
        let c_n0 = resolve_predicate_parquet_columns(&schema, &fo, &["n0".to_string()], &schema);
        Bytes::from(buf)
        // No predicate columns; project qty (col 1).
            .await
            ],
        (Bytes::from(buf), schema)
        let parquet_cols: Vec<usize> = vec![];
        let _g = lock_process_globals();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        let fo = footer_only(&bytes);
                "a", "b", "c", "d", "e",
            .await
    /// derived from it is a valid full-chunk read.
    fn four_rg_parquet() -> (Bytes, SchemaRef) {
            .is_none());
        clear_scoped_cache_for_test();
            .set_statistics_enabled(EnabledStatistics::Page)
        assert_eq!(
        .collect();
        let _g = lock_process_globals();
    num_rgs: usize,
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[2])
            );
            .await
                ))
) -> Option<IndexBuffers> {
        // Second (qty) load re-read the same 2 OI cells from cache.
    predicate_cols: &[usize],
        clear_scoped_cache_for_test();
        ArrowReaderMetadata::load(
            vec![
#[cfg(test)]
            build_column_index_cells(store, location, footer_meta, &missing_col_rg_matrix).await?;
                Arc::new(Int32Array::from(prices)),
    };
            .unwrap();
        let fo = footer_only(&bytes);
        let pred_cols =
use std::ops::Range;
        // superset, also safe.
    /// `(col, rg)` cells. Uses `wide4` (1 RG) for the column axis and asserts CI
/// such index region, or — narrow path — any scoped column lacks an extent.
            .set_max_row_group_size(32)
        }
    /// where `Bytes::clone` is a refcount bump, so this is cheap and short-lived.
        let _g = lock_process_globals();
        );
    /// Evicting a file removes ALL its CI and OI cells from the caches —
        let rg = footer_meta.row_group(rg_idx);
        assert_eq!(ci().entries, 1, "only the most-recent cell fits");
    // Nothing to build when both predicate_cols and projection_cols are empty/absent.
            vec![Arc::new(Int32Array::from(vec![1, 2, 3])), Arc::new(tags)],
/// Load + graft a scoped page index: ColumnIndex for `predicate_cols` (all RGs),
}
        clear_scoped_cache_for_test();
    // Phase 1: serve every needed cell that is already cached; collect misses.
        clear_scoped_cache_for_test();
    store: &Arc<dyn ObjectStore>,
        let _g = lock_process_globals();
        }
        let props = WriterProperties::builder()
        // Scope to n1 (pred) + s0 (proj). Col 3 (s1) is scoped out → placeholder.
            &["price".to_string(), "qty".to_string()],
            .await
            ci().used_bytes <= budget,
    // the matrix, and populate the cache.
    use super::super::column_schema_resolver::{
            .unwrap(); // cell (col0)
        Self { rg, cols, chunks }
        let (bytes, schema) = two_col_parquet();
        let o = aug.offset_index().unwrap();
        assert_eq!(cols, vec![0]);
        b.build()
            columns[k].push(entry);
        let (bytes, schema) = wide4_parquet();
        let (store, loc) = stage(bytes.clone()).await;
        assert_eq!(oi().entries, 0);
            (1, 2, 2),
    /// the column chunk's REAL byte offset + size — not (0, 0). A (0, 0) placeholder
            .set_data_page_row_count_limit(1)
    debug_assert!(
            &["price".to_string()],
        let end = ph.offset as u64 + ph.compressed_page_size as u64;
        // position 0 (which is `extra` in this file).
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
            &schema,
        let (store, loc) = stage(bytes.clone()).await;
    let mut columns: Vec<OiColumn> = cols.iter().map(|_| Vec::with_capacity(num_rgs)).collect();
    // `page_locations` (`.last()`, `[0]`, `windows(2)`). An EMPTY placeholder
        );
        });
        });
        );
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
}
            .set_data_page_row_count_limit(32)
        let _g = lock_process_globals();
            "both id and tags.list.element must receive real OffsetIndexes"
    };
        .metadata()
            .set_max_row_group_size(32)
            resolve_predicate_parquet_columns(&schema, &fo, &["n1".to_string()], &schema);
            Arc::clone(&list_field),
    /// OffsetIndex → reader over-read ~2.5× the bytes on `... | stats ... by URL`.)
    /// The placeholder page must span `[col_start, col_start + col_len)` so any range
// ── OffsetIndex cache lookup + build (per `(file, col)` cell, all RGs) ───────
        let selection = RowSelection::from(vec![RowSelector::skip(16), RowSelector::select(16)]);
        let c_both = resolve_predicate_parquet_columns(
fn whole_index_region(
    #[tokio::test]
    for (i, p) in plan.iter().enumerate() {
    }
fn oi_extent(c: &ColumnChunkMetaData) -> Option<Range<u64>> {
                .column(0)
        );
            )
            }
        leaf_col: usize,
    async fn resolve_pair_equals_two_single_resolves() {
            .unwrap();
        );
        let ph = &ph_pages[0];
    predicate_cols: &[usize],
            .await
    }
/// - **Local store** — the original narrow per-entry fetch of just the scoped
            .unwrap();
    for (rg, entry) in column.iter().enumerate() {
    /// 2 columns (`price`, `qty`), 32 rows, 1 row group, 4 pages of 8 rows.
    fn kept(sel: &RowSelection) -> usize {
        clear_scoped_cache_for_test();
    async fn new_column_combination_caches_only_new_column_cells() {
            .unwrap();
    // ── baseline / correctness ────────────────────────────────────────────
    // Placeholder for columns we don't build: a SINGLE page spanning the whole row
    // `range.end - range.start` then underflows (`parquet_bridge.rs` get_byte_ranges
        let c_n0_n1 = resolve_predicate_parquet_columns(
                footer.file_metadata().schema_descr(),
    async fn fully_scoped_load_combines_both_axes() {
        let pred_cols =
            .set_write_batch_size(32)
        );
            IndexBuffers::Shared { base, bytes } => BufferChunkReader {
        assert_eq!(
async fn build_offset_index_columns(
        let s = ci();
            aug.column_index().is_none(),
            resolve_predicate_parquet_columns(&schema, &fo, &["val".to_string()], &schema);
/// Consuming version of [`scatter_offset_column`] — used after inserting into
/// is decided:
    for p in plan {
}
        let batch = built.iter().map(|cell| {
/// `ParquetMetaData.row_groups` held behind an `Arc` (see the arrow-rs change),
        .unwrap();
    PerEntry(Vec<(u64, Bytes)>),
            resolve_predicate_parquet_columns(&schema, &fo, &["n1".to_string()], &schema);
            ArrowReaderOptions::new().with_page_index(false),
                fo.file_metadata().key_value_metadata(),
        for cell in built {
        clear_scoped_cache_for_test();
            &union_schema,
    #[tokio::test]
        let batch = RecordBatch::try_new(
            .unwrap();
            .set_data_page_row_count_limit(5)
            matches!(c[0][1], ColumnIndexMetaData::NONE),
        let props = WriterProperties::builder()
            .unwrap();
    }
    if !missing.is_empty() {
    extent: ChunkExtent,
        assert_eq!((ci().hits, ci().misses), (1, 2));
        let (store, loc) = stage(bytes.clone()).await;
    /// Reader for the `i`-th plan entry. A `BufferChunkReader` is a `(u64, Bytes)`
        let (bytes, schema) = wide4_parquet(); // n0,n1,s0,s1 — 1 RG, multi-page columns
            .await
        assert_eq!(ci().misses, 1);
            budget
        let f = PagePruner::new(&schema, full, schema.clone()).prune_rg(&pp, 0, None);
            .await
        predicate_cols,
            .set_write_batch_size(8)
        if rel + length > self.bytes.len() {
        .map(|rg| (0..num_cols).map(|col| placeholder_for(rg, col)).collect())
    match acc {
                .as_any()
    size: usize,
                Arc::new(Int32Array::from(vs)),
            .await
            &footer,
        let bytes = Bytes::from(buf);
use datafusion::scalar::ScalarValue;
        clear_scoped_cache_for_test();
        // OI: empty projection → all 2 columns × 1 file → 2 OI entries.
        );
    use super::super::{
                size,
        let fo = footer_only(&bytes);
        store,
        let schema = Arc::new(Schema::new(vec![
        );
        );
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[2])
            &["price".to_string()],
        // Project s0 (col 2): offset cols = {0, 1(n1), 2(s0)} → 3 new cells.
    plan: &[RgPlan],
        );
        let budget = one_cell + one_cell / 2;
            1,
    }
    #[tokio::test]
    /// The OffsetIndex path under whole-region fetch reads the projected column
    let plan: Vec<RgPlan> = (0..num_rgs)
    store: &Arc<dyn ObjectStore>,
        let pred_cols =
            let key = CiCellKey {
    //
struct BufferChunkReader {
            hits_before + 1,
        let (store, loc) = stage(bytes.clone()).await;
}
            .set_max_row_group_size(ROWS as usize)
        let fo = footer_only(&bytes);
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
        // The UNION/table schema the query carries: `price` at position 0 — but in
    /// *union* schema.
use std::collections::{HashMap, HashSet};
        assert_eq!((ci().hits, ci().entries), (4, 4), "warm: all 4 cells hit");
/// Assemble the full-width `[rg][col]` `ColumnIndex` matrix (real cells only at
        }
        footer_meta,
    /// `page_pruner` fix treats a `NONE`-ColumnIndex column as "no usable stats"
            return None;
            set.insert(0); // page-skip metric always reads col 0
    Arc::new(rebuilt)
        );
        .map(|rg| RgPlan::new(footer_meta, rg, cols.to_vec()))
        let fo = footer_only(&bytes);
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
            "non-predicate col CI is NONE"
}
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
/// `extent` selects the index kind. `None` (→ footer-only fallback) if there is no
            .with_row_groups(vec![0])
            "second load after eviction must be a cache miss"
        assert_eq!(oi().hits, 2);
    use datafusion::parquet::arrow::ArrowWriter;
    }
    fn oi() -> ScopedCacheStats {
        .into_iter()
        // Project {1}; union {0,1} = both columns, both already cached → 2 hits.
        let list_field = Arc::new(Field::new("element", DataType::Utf8, true));
        let file_schema = Arc::new(
    /// still scoped (one CI cell per (col, rg), not one per column). Only the bytes
        );
    /// CI (all RGs) + OI column-scoped: both axes populated in one call.
    async fn evict_file_does_not_affect_other_files() {
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[1])
        pair_a.sort_unstable();
        );
            .await
        .unwrap()
    let mut out: Vec<CiCell> = Vec::with_capacity(col_rg_matrix.len());
        let (col_start, col_len) = fo.row_group(0).column(3).byte_range();
        return None;
            arrow::buffer::OffsetBuffer::new(vec![0_i32, 2, 3, 5].into()),
            .set_write_batch_size(8)
            "all-column OffsetIndex: 2 column cells, shared"
        if rg < matrix.len() {
            .unwrap();
            o[0][3].page_locations().len(),
        .unwrap();
    #[tokio::test]
            "single placeholder page starts at row 0"
    };
            .unwrap();
            Field::new("n1", DataType::Int32, false),
        let decoded = read_offset_indexes(&buffers.reader(i), &p.chunks).ok()??;
/// [`BufferChunkReader`] per decode iteration via [`IndexBuffers::reader`] — readers
    }
        clear_scoped_cache_for_test();
            .unwrap();
    fn len(&self) -> u64 {
    }
        // a budget of ~1.5 cells so a second distinct cell forces an eviction.
            "price cell reused (hit); only qty cell freshly decoded"
/// The fetched page-index bytes for a decode plan. The caller builds a transient
    }
        let (bytes, schema) = two_col_parquet();
        let mut resolved = resolve_predicate_parquet_columns(
impl BufferChunkReader {
}
        let (bytes, _schema) = two_col_parquet();
            .unwrap();
            ph.compressed_page_size as u64, col_len,
        let fo = footer_only(&bytes);
///
            ci().hits,
            .unwrap(),
        let full = full_index(&bytes);
    fn new(footer_meta: &Arc<ParquetMetaData>, rg: usize, cols: Vec<usize>) -> Self {
            .await
        assert!(
            resolved,
///   over the file's whole index region (all cols × all RGs; lenient — missing
        assert_eq!(
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_n0, &[])
    }
        _ => None, // empty or absent → OI covers all columns
            let size = rgm.column(col).column_index_length().unwrap_or(0).max(0) as usize;
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[0, 1])
                Arc::new(Int32Array::from(ids)),
            (ci().hits, ci().misses, ci().entries),
            let mut set: HashSet<usize> = HashSet::new();
use prost::bytes::{buf, Buf, Bytes};
        let (bytes, schema) = two_col_parquet();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        ]));
struct OiCell {
            } else {
            schema.clone(),
    /// second load re-reads the SAME 2 OI cells from cache (no new cells). This is
                Some(Some(
            (2, 3, 3),
use datafusion::physical_expr::PhysicalExpr;
            .await
    location: &object_store::path::Path,
        ArrowReaderMetadata, ArrowReaderOptions, RowSelection, RowSelector,
            ArrowReaderOptions::new().with_page_index(true),
    // chunk extent (`byte_range()` = dictionary/data page start + compressed size)
    }
//! projection columns, using the two process-global caches.
            all_cols
        return None;
            .build();
    read_columns_indexes, read_offset_indexes,
    async fn scoped_pruning_is_safe_superset_with_placeholdered_residual_col() {
        let hits_before = ci().hits;
        let _ = load_scoped_page_index_cols(&store_a, &loc_b, &fo, &cols, &[0, 1])
                footer.file_metadata().key_value_metadata(),
        }
            "4 RGs × col → 4 CI cells"
            "2 OI cells (col0,col1)"
    async fn scoped_index_is_predicate_scoped_for_column_index() {
        });
 * SPDX-License-Identifier: Apache-2.0
    use object_store::memory::InMemory;
            (ci().misses, ci().entries),
            &schema,
    async fn col_scoping_reduces_offset_index_bytes() {
) -> Option<Vec<CiCell>> {
            Field::new("tags", DataType::List(list_field), true),
            Field::new("id", DataType::Int32, false),
                CiCellKey {
        let fo = footer_only(&bytes);
        }
        let schema = Arc::new(Schema::new(vec![
    store: &Arc<dyn ObjectStore>,
    #[tokio::test]
        // {n0,n1}: n0 hits, n1 new.
        Ok(self.bytes.slice(rel..).reader())
            .unwrap();
/// `[base, base + bytes.len())`. The arrow-rs page-index readers call
        let scoped = union_extent(&[fo.row_group(0).column(0).clone()], ci_extent).unwrap();
        assert_eq!(pred_cols, vec![1]);
        let decoded = read_columns_indexes(&buffers.reader(i), &p.chunks).ok()??;
    }
                .downcast_ref::<Int32Array>()
            bytes: buffers.first()?.clone(),
    let plan: Vec<RgPlan> = by_rg
            },
    let len = u64::try_from(c.column_index_length()?).ok()?;
 * The OpenSearch Contributors require contributions made to
        clear_scoped_cache_for_test();
            &file_schema,
    fn footer_only(bytes: &Bytes) -> Arc<ParquetMetaData> {
    // column we scoped out — which is hard to predict across every query shape
    /// nothing"; the most-recently-used cell survives.
        let scoped_vals = read_selected_column(&bytes, &aug, 1, selection.clone()).unwrap();
        let proj = ProjectionMask::leaves(builder.parquet_schema(), [leaf_col]);
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
impl ChunkReader for BufferChunkReader {
use datafusion::physical_optimizer::pruning::{PruningPredicate, PruningStatistics};
        let c_qty = resolve_predicate_parquet_columns(&schema, &fo, &["qty".to_string()], &schema);
            "fixture must contain multiple LIST pages"
            Field::new("qty", DataType::Int32, false),
        let c_n1_s0 = resolve_predicate_parquet_columns(
            let s =
        // OffsetIndex must be real for the projected col (1) AND col 0 (loader
    // unlike the earlier (0, 0) placeholder it cannot be shared across columns. The
        clear_scoped_cache_for_test();
            .row_groups()
        assert_eq!(
            Field::new("s1", DataType::Utf8, false),
        return None;
                .unwrap();
        // price 0..32 (pages 0..8,8..16,16..24,24..32); qty 100..132 (pages
            .await
        clear_scoped_cache_for_test();
        assert_eq!(
    /// with absolute file offsets (from chunk metadata); `self.base` is the
        let mut out = Vec::new();
    offset_index: ParquetOffsetIndex,
        let built =
        // always unions in {0}); other behavior unchanged.
    size: usize,
    async fn stats_count_hits_and_misses() {
        );
            "predicate col has real CI"
            &["n1".to_string(), "s0".to_string()],
    /// set-keyed entry. `price` then `{price, qty}` → `price`'s cell is a HIT; only
        // wide4 has 256 rows / page-size 32 → real columns have multiple pages.
}
            "OffsetIndex real for every column (all-col default)"
            resolve_predicate_parquet_columns(&schema, &fo, &["n1".to_string()], &schema);
        writer.close().unwrap();
            .unwrap();
    async fn lru_evicts_over_byte_budget() {
                Arc::new(Int32Array::from(extra)),
            .iter()
        let names_b = vec!["qty".to_string(), "price".to_string()];
        ]));
        clear_scoped_cache_for_test();
            .put(&loc_b, object_store::PutPayload::from_bytes(bytes.clone()))
        assert_eq!(oi().entries, 2, "2 proj cols × 1 file");
        assert!(one_cell > 0);
    // derives the fetch byte range from this page location. A (0, 0) page makes
/// are never stored across the loop.
        )
    fn reader(&self, i: usize) -> BufferChunkReader {
    extent: ChunkExtent,
        let (bytes, schema) = four_rg_parquet();
        assert_eq!(oi().entries, 0, "OI cells must be gone after eviction");
}
        assert_eq!(scoped_vals, (116..132).collect::<Vec<i32>>());
    /// buffer resolves every scoped column's absolute offsets.
    }
            "scoped pruning must match full index"
    let mut out: Vec<OiCell> = Vec::with_capacity(cols.len());
            &schema,
        assert_eq!(pair_b, vec![0, 1]);
        clear_scoped_cache_for_test();
            ],
    /// fetched widen. `whole_index_region` is a superset of the scoped union, so the
        let (bytes, schema) = two_col_parquet();
    /// (union) schema lists `price` at a DIFFERENT position than the file's
        let mut buf: Vec<u8> = Vec::new();
    /// (Bug: the load short-circuited on empty `parquet_cols`, skipping the
        assert_eq!(oi().entries, 2, "all-columns load caches 2 column cells");
            .await
    );
        super::super::evict_file_from_scoped_cache(loc.as_ref());
    #[tokio::test]
            ],
    /// Cell-keying makes OffsetIndex reuse automatic: an all-columns load caches
            !o[0][0].page_locations().is_empty(),
            .map(|s| kept(&s));
        // end (offset+size) >= start (offset).
            .unwrap();
impl RgPlan {
            scatter_offset_column_owned(&mut matrix, cell.col, cell.data);
            .unwrap(),
    base: u64,
        assert_eq!(
        // extras post-decode. A scoped result SMALLER than full would be the real
        ]));
        let file_own_schema: SchemaRef = Arc::new(
        assert!(fo.column_index().is_none());
        let scoped = load_scoped_page_index_cols(&store, &location, &footer, &[], &resolved)
                set.insert(c);
        let built =
        clear_scoped_cache_for_test, column_index_cache_stats, offset_index_cache_stats,
        );
        single_b.sort_unstable();
        );
            .unwrap();
            .unwrap();
            (0, 1, 1),
    #[tokio::test]
        let mut single_a = resolve_predicate_parquet_columns(&schema, &fo, &names_a, &schema);
        let fo = footer_only(&bytes);
        let c = aug.column_index().unwrap();
        }
        assert_eq!(
        let (bytes, schema) = two_col_parquet();
    let build_rgs: Vec<usize> = (0..num_rgs).collect();
    data: OiColumn,
        let c_price =
            Field::new("price", DataType::Int32, false),
        assert_eq!(oi().entries, 2, "OI: 2 cols (all cols) × 1 file");
    async fn different_literals_same_column_share_cell() {
        clear_scoped_cache_for_test();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_n1_s0, &[])
            }
    }
/// that reads that column irrespective of projection or predicate.
                cell.data.clone(),
            );
    use datafusion::parquet::arrow::arrow_reader::{
    async fn adding_predicate_column_reuses_existing_cell() {
            .unwrap();
                rg: p.rg,
                Arc::new(StringArray::from(s0)),
    }
    predicate_cols: &[usize],
    use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
    #[tokio::test]
    #[tokio::test]
    footer_meta: &Arc<ParquetMetaData>,
    /// fallback. Without it, `tags` receives a placeholder OffsetIndex even though
        assert_eq!(ci().entries, 0);
        let (store, loc) = stage(bytes.clone()).await;
    use datafusion::common::ScalarValue;
    /// (`parquet_cols` empty) but DOES project columns (`offset_cols` non-empty).
    /// leaf, and the residual mis-pruned → over-count.
    }
) -> Option<Arc<ParquetMetaData>> {
            size,
        // Scoped columns (predicate 1 ∪ projection 2 ∪ metric 0) carry the REAL
        // never enters the cache key.
    predicate_cols: &[usize],
            .map(|s| kept(&s));
    // them in the matrix, and populate the cache.
            .await
impl IndexBuffers {
            (1, 2, 2),
            oi().used_bytes < all_cols,
        let (store, loc) = stage(bytes.clone()).await;
        let pred_cols =
    let mut acc: Option<Range<u64>> = None;
        // Evict only file_a.
        // Superset invariant: scoped must keep AT LEAST what full keeps (never
    }
        }
    }
            col_index_matrix[cell.rg][cell.col] = cell.data;
    }
    }
        let f_kept = PagePruner::new(&schema, full, schema.clone())
        Some(p) if !p.is_empty() => Some(p),
/// single source of truth for the range key warm-population must also write.
    // Phase 2: decode the missing cells (vectored fetch grouped by RG), place
};
    }
                "RG{rg} pruning matches full"
        }
        Some(a) => a.start.min(r.start)..a.end.max(r.end),
    /// Two predicates on the SAME column with DIFFERENT literals resolve to the
    fn col(name: &str, idx: usize) -> Arc<dyn PhysicalExpr> {
    /// column is decoded.
        let (mut pair_a, mut pair_b) =
    /// Narrow (local): one scoped buffer per plan entry, aligned to `plan` order.
        resolved.sort_unstable();
            .unwrap();
        assert_eq!(pair_a, vec![0]);
            .await
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
    }
}
        assert_eq!(ci().entries, 2, "one CI cell per file");
        assert_eq!(
        let (bytes, schema) = two_col_parquet();
            .set_statistics_enabled(EnabledStatistics::Page)
        );
    location: &object_store::path::Path,
}
async fn get_or_build_offset_index(
    async fn scoped_resolution_is_per_file_under_schema_evolution() {
            if let Some(r) = extent(rgm.column(col)) {
    async fn empty_column_set_returns_none() {
            2,
            };
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
fn union_extent(chunks: &[ColumnChunkMetaData], extent: ChunkExtent) -> Option<Range<u64>> {
        // bug (lost rows). `None` = "kept everything" (no pruning) = the maximal
        let fo = footer_only(&bytes);
        clear_scoped_cache_for_test();
            }
        let o = aug.offset_index().expect("OffsetIndex must be grafted");
    let offset_index = oi_result?;
        assert_eq!(
            .unwrap();
    /// those cells hits them — no new entries, no special "collapse to all-columns
            "1 CI cell (price,rg0)"
            .await
/// `predicate_cols` × all RGs; `NONE` everywhere else) by looking up each
    }
        assert_eq!(
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        Some(proj_cols) => {
        let fo = footer_only(&bytes);
            .expect("projection-only load must produce grafted metadata (not None)");
            for &c in proj_cols {
    ))
        let (bytes, schema) = two_col_parquet();
                "page-index read [{rel}..{}) exceeds buffer of len {}",
            .await
            "col 0 OffsetIndex real (always unioned)"
    #[tokio::test]
            data: mem::take(&mut columns[k]),
        let (bytes, schema) = wide4_parquet(); // n0=0,n1=1,s0=2,s1=3 — 1 RG
            &["id".to_string(), "tags".to_string()],
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_qty, &[])
    let path: Arc<str> = Arc::from(location.as_ref());
}
        );
            vec![
        let (bytes, schema) = two_col_parquet();
            col,
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
            vec![
    location: &object_store::path::Path,
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
    let off = u64::try_from(c.offset_index_offset()?).ok()?;
            )
    for (k, &col) in cols.iter().enumerate() {
    let mut by_rg: HashMap<usize, Vec<usize>> = HashMap::new();
    /// so the parquet reader fetches only matched-row pages, not whole chunks.
        (Bytes::from(buf), schema)
            (0, 3, 3),
        .build();
    for &(col, rg) in col_rg_matrix {
        Ok(self.bytes.slice(rel..rel + length))
    /// Page pruning over a column-scoped index must be a SAFE SUPERSET of the
        let fo = footer_only(&bytes);
    footer_meta: &Arc<ParquetMetaData>,
        let (store, loc) = stage(bytes.clone()).await;
/// Each cell is keyed on `(file, col, rg)` and decoded once per file — reused
        self.base + self.bytes.len() as u64
}
        let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
    //            Predicate-only queries (empty proj_cols) still get col 0 + predicate
        let (bytes, schema) = two_col_parquet();
    fn ci() -> ScopedCacheStats {
            .await
    Some(col_index_matrix)
        return None;
            None => missing.push(col),
        }
            .set_data_page_row_count_limit(8)
                out.push(a.value(i));
        });
        ]));
    /// 4-RG file caches 4 cells (one per RG); a repeat query hits all 4.
///   columns' extents (fewer bytes; no warm tier to match).
///   fetched widen.
/// A [`ChunkReader`] over an in-memory byte buffer representing the file region
        store_a
    //   Some   → build {col 0} ∪ predicate_cols ∪ proj_cols, clamped to num_cols.
    async fn different_projections_cache_only_new_offset_columns() {
/// - **Remote/warm store** ([`is_whole_region_fetch_enabled`]) — ONE `get_ranges`
        let bytes = evolved_extra_price_parquet();
        // Warm: all 4 cells hit, entry count unchanged.
    store: &Arc<dyn ObjectStore>,
    use parquet::arrow::parquet_to_arrow_schema;
        assert_eq!(
    projection_cols: Option<&[usize]>,
            .map_err(|e| ParquetError::General(format!("offset overflow: {e}")))?;
        let fo = footer_only(&bytes);
        let offset_cols: Vec<usize> = vec![1];
            Field::new("extra", DataType::Int32, false),
            ))
    /// With whole-region fetch on, the grafted index decodes IDENTICALLY to the
    /// the wrong invariant.
        .clone()
        // The byte range a reader derives from this page must NOT underflow:
    }
        assert_eq!(ci().entries, 1);
            f.as_ref().map(kept),
        let mut single_b = resolve_predicate_parquet_columns(&schema, &fo, &names_b, &schema);
    let base = ParquetMetaData::clone(footer_meta);
/// cloned from the footer exactly once.
            1,
            (c2.hits, c2.misses, c2.entries, c2.used_bytes),
    let column_index = ci_result?;
            "scoped-out col 3 must have a single placeholder page"
            vec![
    Some(graft(footer_meta, column_index, offset_index))
            )));
}
        let s = s_kept.unwrap_or(usize::MAX);
        acc = Some(merge(acc, extent(c)?));
        writer.write(&batch).unwrap();
        let full = full_index(&bytes);
    // Each column chunk has its OWN byte offset, so the placeholder is per-(rg, col):
    /// cell-level hit/miss deltas.
        let mut writer = ArrowWriter::try_new(&mut buf, Arc::clone(&schema), Some(props)).unwrap();
            "placeholder page offset must be the real chunk start (not 0)"
    // (count/agg, SingleCollector prefetch, schema-evolved files). A one-page
        ]));
        assert_eq!((ci().hits, ci().misses, ci().entries), (0, 1, 1));
    use crate::indexed_table::page_pruner::{build_pruning_predicate, PagePruner};
    if super::is_whole_region_fetch_enabled() {
            .unwrap();
    rg: usize,
            oi().used_bytes,
            "file_b CI cell must still be cached"
        );
        let s = PagePruner::new(&schema, Arc::clone(&aug), schema.clone()).prune_rg(&pp, 0, None);
        let _g = lock_process_globals();
        // Scope the page index to `price` ONLY (mimics the predicate-scoped indexed
    .await
        let rel = self.rel(start, 0)?;
    }
        let _ = load_scoped_page_index_cols(&store_a, &loc_a, &fo, &cols, &[0, 1])
                "page-index read offset {start} precedes buffer base {}",
        assert_eq!(s.as_ref().map(kept), f.as_ref().map(kept));
        let c_price =
            &schema,
        let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
    /// sentinel" needed (the prior set-keyed design's mechanism).
            (c1.hits, c1.misses, c1.entries),
        let (store, loc) = stage(bytes.clone()).await;
        clear_scoped_cache_for_test();
        );
        Ok(out)
        let key = OiCellKey {
    /// Evicting file A does not remove cells for file B. Cross-file isolation.
    }
        Arc::new(BinaryExpr::new(col(name, idx), op, lit_int(v)))
    // Use insert_batch so all cells from this query are inserted under a single
    /// resolver used the union-schema position, scoped the page index at the wrong
            .await
            .unwrap();
    }
            (0, 1, 1),
            .await
use object_store::ObjectStore;
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[2])
        store_a
        let qtys: Vec<i32> = (100..132).collect();
        let region = whole_index_region(footer_meta, extent)?;
        let full = full_index(&bytes);
        .clone()
    #[tokio::test]
        offset_index_cache_stats()
/// an offset-index range (→ footer-only fallback).
        clear_scoped_cache_for_test();
        // FILE schema (price at index 1) so the converter matches the data.
    crate::test_process_globals::assert_held("the scoped page-index caches");
                    col: cell.col,
        use datafusion::parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
        let scoped_vals = read_selected_column(&bytes, &aug, 1, selection.clone()).unwrap();
 * compatible open source license.
        assert_eq!(cols, vec![0]);
            .build();
            for &c in predicate_cols {
fn ci_extent(c: &ColumnChunkMetaData) -> Option<Range<u64>> {
/// the resolved offset columns; empty placeholders elsewhere) from per-`(file,
 *
            vec![1],
        let (bytes, schema) = wide4_parquet(); // n0,n1,s0,s1 — 1 RG
        assert_eq!(
    #[tokio::test]
        let store_a: Arc<dyn object_store::ObjectStore> =
        assert_eq!(
        let proj_cols =
        let (store, loc) = stage(bytes.clone()).await;
                Arc::new(StringArray::from(s1)),
            .build();
        .map(|(rg, cols)| RgPlan::new(footer_meta, rg, cols))
        let props = WriterProperties::builder()
        assert_eq!(ci().hits, 1);
        assert!(
            &schema,
            &schema,
        clear_scoped_cache_for_test();
    /// (so `price` is parquet leaf **1**), 32 rows / 4 pages. Used to prove the
        set_column_index_cache_limit_for_test(budget);
        // THIS file `price` is physically leaf 1 (after `extra`).
        pair_b.sort_unstable();
            &schema,
    }
        async {
use datafusion::parquet::file::metadata::{
        clear_scoped_cache_for_test();
    fn full_index(bytes: &Bytes) -> Arc<ParquetMetaData> {
            .unwrap();
        })?;
        fetch_ranges.iter().map(|r| r.start).zip(buffers).collect(),
        let (store, loc) = stage(bytes.clone()).await;
            path: path.clone(),
    let oi_proj = match projection_cols {
        clear_scoped_cache_for_test();
    Shared { base: u64, bytes: Bytes },
use std::sync::Arc;
) -> Option<ParquetColumnIndex> {
    // scoped columns get their real OffsetIndex scattered in afterward, overwriting
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_n0_n1, &[])
            },
    acc
        let rel = self.rel(start, length)?;
            .await
            (
    )
    fn get_bytes(&self, start: u64, length: usize) -> ParquetResult<Bytes> {
        assert_eq!(pair_a, single_a, "pair predicate result must match single");
    }
        let (store, loc) = stage(bytes.clone()).await;
        ]));
    }
    /// and scoped pruning must match the full-index pruning. Previously the
}
        assert_eq!(scoped_vals, expected);
        );
///
        );
            .unwrap();
        for (k, entry) in decoded.into_iter().enumerate() {
        let _g = lock_process_globals();
    // Narrow: one scoped fetch per plan entry, reusing each entry's precomputed chunks.
        .unwrap();
        let footer = footer_only(&bytes);
            .unwrap();
            2,
        let fo = footer_only(&bytes);
            Field::new("v", DataType::Int32, false),
        let c = aug.column_index().unwrap();
}
        assert_eq!((s.hits, s.misses, s.entries, s.evictions), (3, 2, 2, 0));
        );
        let s = PagePruner::new(&file_schema, Arc::clone(&aug), file_schema.clone())
    /// Cells: predicate `price` → 1 CI cell `(col0,rg0)`; all-column OffsetIndex
            !o[0][1].page_locations().is_empty(),
        let (store, loc) = stage(bytes.clone()).await;
use std::mem;
                fo.file_metadata().schema_descr(),
        let mut buf: Vec<u8> = Vec::new();
        assert_eq!(scoped_vals, full_vals);
                base: v[i].0,
            4,
        // The scoped-out column's placeholder is a single page...
fn scatter_offset_column_owned(matrix: &mut ParquetOffsetIndex, col: usize, column: OiColumn) {
            build_pruning_predicate(&pred("price", 0, Operator::GtEq, 20), schema.clone()).unwrap();
) -> Option<Range<u64>> {
    }
        clear_scoped_cache_for_test();
    }
        clear_scoped_cache_for_test();
            (o1.hits, o1.misses, o1.entries),
        if decoded.len() != p.cols.len() {
        );
        clear_scoped_cache_for_test();
            );
use datafusion::parquet::errors::{ParquetError, Result as ParquetResult};
        );
            .build();
        let fo = footer_only(&bytes);
        out.push(OiCell {
}
    // ── fixtures + expr helpers ──────────────────────────────────────────
        let fo = footer_only(&bytes);
        let prices: Vec<i32> = (0..32).collect();
                set.insert(c);
        let scoped_vals = read_selected_column(&bytes, &aug, 1, selection.clone()).unwrap();
        let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
        assert_eq!(pair_b, single_b, "pair projection result must match single");
        let schema = Arc::new(Schema::new(vec![
            }
        let fo = footer_only(&bytes);
enum IndexBuffers {
                    rg: cell.rg,
    let off = u64::try_from(c.column_index_offset()?).ok()?;
        assert!(
                Some(None)
        if rg < matrix.len() {
        let _g = lock_process_globals();
            }
        let expected: Vec<i32> = (116..132).collect();
        for rg in 0..4 {
    /// shared buffer must contain every scoped column's absolute offsets.
        let names_a = vec!["price".to_string()];
    #[tokio::test]
        let pp = build_pruning_predicate(&residual, schema.clone()).unwrap();
    }
            .unwrap();
            .await
        let rel = start.checked_sub(self.base).ok_or_else(|| {
                rel + length,
/// on. Clones the footer to get an owned value for the builder — but with
            full_list_pages > 1,
        )
/// column-chunk metadata. On wide / many-row-group files (e.g. textbench's
    /// that root. `StatisticsConverter::parquet_column_index()` deliberately
        // file_b's cells are still hits.
        let n1: Vec<i32> = (0..ROWS).collect();
        );
        let f = PagePruner::new(&file_schema, full, file_schema.clone()).prune_rg(&pp, 0, None);
        location,
        );
    if buffers.len() != fetch_ranges.len() {
        let fo = footer_only(&bytes);
        assert_eq!(scoped_vals, full_vals);
        // Measure one CI cell (predicate `price` = col0 at the single RG), then set
        Arc::new(Literal::new(ScalarValue::Int32(Some(v))))
        assert_eq!(
        while let Some(next) = reader.next() {
            "scoped page pruning must be a safe superset of full ({} kept) but kept fewer ({})",
    async fn scoped_pruning_matches_full_index() {
    /// full-index pruning — never drop a row the full index would keep (that
        single_a.sort_unstable();
/// The resolved offset-column set is `predicate ∪ projection ∪ {0}` (`projection_cols
                o[0][c].page_locations().len(),
    #[tokio::test]
            assert_eq!(
    /// first predicate already decoded, instead of re-decoding it inside a new
    if num_rgs == 0 {
        let (store, loc) = stage(bytes.clone()).await;
    #[tokio::test]
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
            Some(column) => scatter_offset_column(&mut matrix, col, &column),
        clear_scoped_cache_for_test();
            &fo,
        );
            parquet_to_arrow_schema(
    /// The scoped load must still build the OffsetIndex for the projected column
    // ── Eviction on file deletion ─────────────────────────────────────────────
    // CI and OI IO run concurrently — wall time = max(ci, oi) not their sum.
            ci().entries,
        let (bytes, _schema) = two_col_parquet(); // price=col0, qty=col1
        COLUMN_INDEX_CACHE.insert_batch(batch);
    /// The cell-keying payoff: a predicate that ADDS a column reuses the cell the
    fn two_col_parquet() -> (Bytes, SchemaRef) {
            .unwrap();
                cell.rg < col_index_matrix.len() && cell.col < col_index_matrix[cell.rg].len(),
        assert_eq!(
        let c_qty = resolve_predicate_parquet_columns(&schema, &fo, &["qty".to_string()], &schema);
        );
        }
        // ...whose coordinates equal the real column chunk byte range from the footer.
    }
        let full_vals = read_selected_column(&bytes, &full, 1, selection).unwrap();
        let _g = lock_process_globals();
    }
    /// is a one-page non-panicking OffsetIndex placeholder with a `NONE`
    location: &object_store::path::Path,
    async fn whole_region_fetch_matches_full_index_and_stays_scoped() {
        set_whole_region_fetch_enabled(true);
    #[tokio::test]
        let (store, loc) = stage(bytes.clone()).await;
        let batch = built.iter().map(|cell| {
                bytes: v[i].1.clone(),
            col,
        assert_eq!((ci().hits, ci().misses), (1, 1));
        );
        let _g = lock_process_globals();
use datafusion::parquet::arrow::arrow_reader::statistics::StatisticsConverter;
        let loc_a = object_store::path::Path::from("file_a.parquet");
    let mut missing: Vec<usize> = Vec::new();
        let rel = usize::try_from(rel)
    if num_rgs == 0 {
        );
    fn evolved_extra_price_parquet() -> Bytes {
        let fo = footer_only(&bytes);
        // Project s1 (col 3): offset cols = {0, 1, 3}. Cols 0 & 1 hit; col 3 new.
/// The only thing that differs between the CI and OI fetch paths.
            .unwrap();
                self.base
    ///
        let _g = lock_process_globals();
            .map(|rg| rg.column(col).offset_index_length().unwrap_or(0).max(0) as usize)
            .set_statistics_enabled(EnabledStatistics::Page)
                Arc::new(Int32Array::from(n1)),
        },
    //            regardless of what the query projects or filters on.
/// Fetch the page-index bytes for a decode plan. The single place the fetch strategy
    /// cells. Project {s0} (offset cols n1∪s0∪{0}), then {s1} (offset cols
    #[tokio::test]
            .unwrap();
            s.as_ref().map(kept),
                base: *base,
            .unwrap();
    }
        w.write(&batch).unwrap();
            .unwrap();
    /// The hazard this guards: with the page index scoped to `price` only, `qty`
            (o2.hits, o2.misses, o2.entries, o2.used_bytes),
        .collect();
        );
        assert_eq!(
        fetch_ranges.push(union_extent(&p.chunks, extent)?);
        let fo = footer_only(&bytes);
    // → "subtract with overflow" / release "capacity overflow"). Spanning the real
        // Pruning identical to the full index.
            resolve_predicate_parquet_columns(&schema, &fo, &["id".to_string()], &schema);
        );
        );
        return None;
            .await
        clear_scoped_cache_for_test();
        by_rg.entry(rg).or_default().push(col);
            &fo,
/// row group so each RG's columns share one vectored fetch + decode. `None` if
    fn wide4_parquet() -> (Bytes, SchemaRef) {
    /// correctly (same bytes as the full index), proving the shared whole-region
            debug_assert!(
            "price cell decoded"
            base: region.start,
/// ~403-col, ~64-RG footers) that deep copy was ~60ms/query; sharing makes the
struct RgPlan {
    let mut fetch_ranges: Vec<Range<u64>> = Vec::with_capacity(plan.len());
    // Same `cols` on every RG (read-time safety). Fetch, then decode scoped per RG.
        let ids: Vec<i32> = (0..40).collect();
    /// A projected nested Arrow field must resolve to every Parquet leaf under
///   columns skipped). Matches the range key eager warm-population writes, so a
    fn rel(&self, start: u64, length: usize) -> ParquetResult<usize> {
    if off_cols.is_empty() {
        assert!(
        // path). `qty` therefore gets the one-page placeholder + NONE ColumnIndex.
impl Length for BufferChunkReader {
        clear_scoped_cache_for_test();
        let full_vals = read_selected_column(&bytes, &full, 1, selection).unwrap();
        return None;
            out.push(CiCell {
        let (c2, o2) = (ci(), oi());
            Arc::new(BinaryExpr::new(price_ge, Operator::And, qty_le));
    ) -> std::result::Result<Vec<i32>, String> {
    let len = u64::try_from(c.offset_index_length()?).ok()?;
        let (store, loc) = stage(bytes.clone()).await;
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[])
    // placeholder is always safe to dereference and makes pruning conservatively
/// byte extents) and the decode (to pass to `read_*_indexes`), so `chunks` is
    location: &object_store::path::Path,
    // `match() | sort | head` that page-selects the projected columns), arrow
        clear_scoped_cache_for_test();
    }
    /// `range.end - range.start` then underflows ("subtract with overflow" in debug /
            .set_max_row_group_size(10)
            "placeholder page size must be the real chunk compressed size (not 0)"
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["id".to_string()], &schema);
    rg: usize,
        assert!(
        let one_cell = ci().used_bytes;
        // Must resolve to the file's TRUE leaf for `price` = 1, NOT the union
            if predicate_cols.is_empty() {
            .with_projection(proj)
        let (bytes, schema) = two_col_parquet();
    async fn list_projection_resolves_to_its_parquet_leaf() {
) -> Arc<ParquetMetaData> {
    /// the whole point of cell-keying: a column's index is stored once per file.
    #[tokio::test]
        // Both predicates are on `price` (col 0) — only the literal differs, which
        .unwrap();
            ])),
            (2, 4, 4),
        let _g = lock_process_globals();
    let rebuilt = base
        // `price` pages: 0..8,8..16,16..24,24..32; `price >= 20` keeps the last two
            .build();
    /// the scan reads it, and the page reader treats a whole chunk as one page.
                rg,
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &proj_cols)
        clear_scoped_cache_for_test();
            .await
/// One row group's decode unit: the scoped columns and their precomputed chunk
/// OffsetIndex for `projection_cols` (∪ predicate ∪ col 0). This is the single
/// `get_bytes(absolute_offset, len)`; we translate into the buffer.
        clear_scoped_cache_for_test();
            s >= f,
        let (bytes, schema) = two_col_parquet();
///   warmed file is a hit instead of remote IO. All entries share that one buffer;
            "n0 reused; n1 new"
            ph.offset as u64, col_start,
        let buffers = store
    let num_rgs = footer_meta.num_row_groups();
        let _g = lock_process_globals();
    }
        clear_scoped_cache_for_test();
    }
        }
    /// CI cells are keyed per `(file, col, rg)`. Loading a predicate column on a
        // The most-recently-used cell (qty/col1) must still be a hit.
            .await
/// production entry point used by both the listing path (`ScopedPageIndexReaderFactory`)
                    col: cell.col,
 * this file be licensed under the Apache-2.0 license or a
        assert_eq!(s.as_ref().map(kept), Some(16));
            (1, 1, 1, c1.used_bytes)
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
    }
    }
        let selection = RowSelection::from(vec![RowSelector::skip(16), RowSelector::select(16)]);
    /// `qty`'s cell is freshly decoded. (Under the old set-keyed cache this was a
            }
        clear_scoped_cache_for_test();
    //            Col 0 is always included because the page-skip metric reads it
            (oi().hits, oi().misses, oi().entries),
        let mut buf: Vec<u8> = Vec::new();
        w.write(&batch).unwrap();
    // preserved (still "can't prune"), just with coordinates arrow can subtract.
            oi().entries,
        let c_price =
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[1])
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[3])
        let (bytes, schema) = two_col_parquet();
    /// actually reads that column (e.g. `match() | sort | head`), and the read path's
}
        assert!(
        Ok(rel)
            return None;
    let num_rgs = footer_meta.num_row_groups();
                real_pages,
            ph_pages.len(),
    // panics those (`page_locations.last().unwrap()` etc.) if any path touches a
        );
}
        let (store, loc) = stage(bytes.clone()).await;
        let fo = footer_only(&bytes);
    }
    #[tokio::test]
/// the cache so we move rather than clone the per-RG entries.
        resolve_predicate_parquet_columns, resolve_predicate_parquet_columns_pair,
        let _g = lock_process_globals();
            .unwrap();
    bytes: Bytes,
    // write-lock acquisition — avoids per-cell lock overhead and runs eviction
    }
        let all_cols = oi().used_bytes;
        assert_eq!(ci().entries, 1, "only file_a's CI cell removed");
        // not the (scoped) plan.
    //            columns; projection-only queries get col 0 + projected columns.
            match COLUMN_INDEX_CACHE.get(&key) {
        assert!(!matches!(c[0][0], ColumnIndexMetaData::NONE), "RG0 real CI");
}
        let fo = footer_only(&bytes);
    }
        let full = full_index(&bytes);
    /// Second identical load is a pure hit in BOTH caches; no new cells/bytes.
/// `(file, col, rg)` cell in the cache and decoding only the cells that miss.
            )
    let mut acc: Option<Range<u64>> = None;
            .unwrap();
//! [`load_scoped_page_index_cols`] is the single public entry point — it loads
        let full = full_index(&bytes);
            .unwrap();
    attach_scoped_page_index_to_metadata(
    if predicate_cols.iter().any(|&i| i >= num_cols) {
                path: path.clone(),
        .unwrap();
        let rgm = footer_meta.row_group(p.rg);
        let (store, loc) = stage(bytes.clone()).await;
/// metadata. Built once per RG and used by BOTH the fetch (to union the chunks'
        // the placeholdered `qty` — that's safe; the residual mask removes the
        assert_eq!(
        clear_scoped_cache_for_test();
            .unwrap();
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
            Field::new("price", DataType::Int32, false),
        ArrowReaderMetadata::load(
        // All 4 RGs built for the predicate column (id = col 0).
        // {n0}: 1 new cell.
    /// Wide (remote): every plan entry decodes from the ONE whole-region buffer.
    ColumnChunkMetaData, OffsetIndexBuilder, ParquetColumnIndex, ParquetMetaData,
        );
        assert_eq!(oi().hits, 2);
    // ── cache behavior: hits, independence, eviction ──────────────────────
    async fn footer_only_has_no_page_index() {
    }
            ci().used_bytes,
    /// makes arrow derive a fetch byte range with `end < start` when a row selection
            .await
        );
        assert!(
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_qty, &[])
}
        .map(|_| (0..num_cols).map(|_| ColumnIndexMetaData::NONE).collect())
        // CI: 4 RGs × 1 pred col = 4 cells; OI: {id(0), val(1)} × 1 file = 2 cells.
    // Resolve which columns need a real OffsetIndex:
                acc = Some(merge(acc, r));
        clear_scoped_cache_for_test();
        let batch = RecordBatch::try_new(
            .unwrap();
        let file_schema: SchemaRef = Arc::new(Schema::new(vec![
        let fo = footer_only(&bytes);
    }
}
            "derived range must not underflow (end >= start)"
            s
            .await
        );
type ChunkExtent = fn(&ColumnChunkMetaData) -> Option<Range<u64>>;
            matrix[rg][col] = entry;
        return Some(IndexBuffers::Shared {
            !o[0][0].page_locations().is_empty() && !o[0][1].page_locations().is_empty(),
            debug_assert!(
            .await
    let off_cols: Vec<usize> = match projection_cols {
        let residual: Arc<dyn PhysicalExpr> =
                PagePruner::new(&schema, Arc::clone(&full), schema.clone()).prune_rg(&pp, rg, None);
            .unwrap();
        let c_price =
            .unwrap();
    }
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        let batch = RecordBatch::try_new(
        // Cold: 4 RGs × 1 predicate col → 4 CI misses, 4 CI entries.
        (store, loc)
    projection_cols: Option<&[usize]>,
/// Assemble the full-width `[rg][col]` `OffsetIndex` matrix (real entries only at
        let s0: Vec<String> = (0..ROWS).map(|r| format!("s0_{r:05}_padpadpad")).collect();
        let (store, loc) = stage(bytes.clone()).await;
            &schema,
        assert_eq!(
    chunks: Vec<ColumnChunkMetaData>,
        ScopedCacheStats,
        let rgm = footer_meta.row_group(rg);
    /// Regression for the schema-evolution wrong-count bug: when the query's
            cols,
            (2, 2, 2, o1.used_bytes)
        // fewer). It keeps more here (16 vs 0) because it correctly cannot prune
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &parquet_cols, &offset_cols)
        );
        clear_scoped_cache_for_test();
    col: usize,
        let pp =
    use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
    location: &object_store::path::Path,
        let _g = lock_process_globals();
            .await
            IndexBuffers::PerEntry(v) => BufferChunkReader {
/// `(file, col)`, so it is decoded once per file and reused across every query
        let schema = Arc::new(Schema::new(vec![
async fn get_or_build_column_index(
            .with_row_selection(selection)
        let arm = ArrowReaderMetadata::try_new(Arc::clone(meta), ArrowReaderOptions::new())
        );
        assert_eq!(oi().entries, 2);
    }
    use arrow::datatypes::{DataType, Field, Schema};
        set_whole_region_fetch_enabled(true);
        )
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
fn merge(acc: Option<Range<u64>>, r: Range<u64>) -> Range<u64> {
    // ── Whole-region fetch (remote/warm stores) ───────────────────────────────
    /// Regression: the single-page placeholder for a scoped-OUT column must carry
    // Phase 1: serve cached columns; collect misses.
    // Initially filled NONE for all RGs and all cols - as placeholders
    footer_meta: &Arc<ParquetMetaData>,
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
    for rg in 0..footer_meta.num_row_groups() {
    for &rg in &build_rgs {
    /// one; the cache never exceeds its limit and never degrades to "cache
    let num_cols = footer_meta.file_metadata().schema_descr().num_columns();
        // Warm: 1 CI cell (price,rg0) + 2 OI cells (col0, col1).
    // (0, 0). When a row selection actually READS a placeholdered column (e.g. a
        let o = aug.offset_index().unwrap();
                data: entry,
/// without one (lenient). The whole-file index region for the wide fetch — the
    #[tokio::test]
/// cached cell is a column's OffsetIndex across **all** row groups, keyed only on
            .unwrap();
        // Evict the file.
        assert_eq!(oi().entries, 2, "only file_a's OI cells removed");
    let buffers = fetch_index_buffers(store, location, footer_meta, &plan, ci_extent).await?;
                col,
        let chunks = cols.iter().map(|&i| rgm.column(i).clone()).collect();
        store
        let fo = footer_only(&bytes);
    footer_meta: &Arc<ParquetMetaData>,
                "column index out of bounds (num_cols={num_cols}): {set:?}"
        let _g = lock_process_globals();
            ci().hits,
            .await
            .await
            ph.first_row_index, 0,
        bytes: &Bytes,
        assert!(c1.used_bytes > 0 && o1.used_bytes > 0);
                col,
        assert!(ci().evictions >= 1, "the LRU cell must have evicted");
            Field::new("extra", DataType::Int32, false),
        // page index; the rest carry a single whole-RG placeholder page (non-empty
        assert!(
        // pages (rows 16..32 = 16 rows). Build the pruning predicate against the
            .prune_rg(&pp, 0, None)
            &file_own_schema,
            .unwrap();
    footer_meta: &Arc<ParquetMetaData>,
            .await
        "predicate_cols contains out-of-bounds index (num_cols={num_cols}): {predicate_cols:?}"
        if decoded.len() != cols.len() {
    //   None   → no explicit projection, read everything → all columns get a real entry.
            col_start > 0 && col_len > 0,
                s.as_ref().map(kept),
        let pp =
    Some(off..off + len)
    /// physical layout, the predicate must still resolve to the file's TRUE leaf
            "CI bytes {} must stay within {}",
            resolve_predicate_parquet_columns_pair(&schema, &fo, &names_a, &names_b, &schema);
            ParquetError::General(format!(
        use datafusion::parquet::arrow::ProjectionMask;
    location: &object_store::path::Path,
    async fn rg_scoped_key_includes_surviving_rgs() {
            .map_err(|e| format!("build reader: {e}"))?;
            &bytes.clone(),
    async fn whole_region_fetch_offset_index_reads_match_full() {
                set.iter().all(|&c| c < num_cols),
    /// Schema-evolution fixture: a file whose physical layout is `[extra, price]`
            2,
/// The page-index extent (byte offset..end) of one column chunk, for one index kind.
        );
        let size = footer_meta
    // Phase 2: decode the missing columns (each spanning all RGs), scatter into
            &["n0".to_string(), "n1".to_string()],
            build_pruning_predicate(&pred("id", 0, Operator::GtEq, 20), schema.clone()).unwrap();
    async fn col_scoping_full_coverage_collapses_to_all_columns_entry() {
            let batch = next.map_err(|e| format!("read batch: {e}"))?;
/// across every query that filters on the same column regardless of predicates.
            "distinct predicate cells: (price,rg0) + (qty,rg0)"
    async fn stage(bytes: Bytes) -> (Arc<dyn ObjectStore>, ObjPath) {
        let _g = lock_process_globals();
            &bytes.clone(),
        let hits_before = ci().hits;
        clear_scoped_cache_for_test();
    }
    /// The fork's `read_columns_indexes`/`read_offset_indexes` call `get_bytes`
fn graft(
    use object_store::{ObjectStoreExt, PutPayload};
        let fo = footer_only(&bytes);
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
        match OFFSET_INDEX_CACHE.get(&key) {
/// Range-read + decode the requested `(col, rg)` ColumnIndex cells, grouping by
            .unwrap();
        clear_scoped_cache_for_test();
        let (bytes, schema) = four_rg_parquet();
        let full = full_index(&bytes);
        let mut buf: Vec<u8> = Vec::new();
use datafusion::parquet::file::page_index::index_reader::{
        let prices: Vec<i32> = (0..32).collect();
        let mut buf = Vec::new();
use super::cache_keys::{CiCellKey, OiCellKey, OiColumn};
        OFFSET_INDEX_CACHE.insert_batch(batch);
            !matches!(c[0][0], ColumnIndexMetaData::NONE),
            .map_err(|e| format!("try_new metadata: {e}"))?;
///
            (4, 4),
        let cols = resolve_predicate_parquet_columns(
            .await
    footer_meta: &Arc<ParquetMetaData>,
    store: &Arc<dyn ObjectStore>,
    }
        super::super::evict_file_from_scoped_cache(loc_a.as_ref());
    for &col in &off_cols {
        .set_column_index(column_index)
/// `min(start)..max(end)` over EVERY `(col, rg)` chunk's `extent`, skipping columns
            matches!(c[0][1], ColumnIndexMetaData::NONE),
    // An empty projection slice means "no specific projection" → treat as None (all columns).
            .sum();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        );
        let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
    use super::*;
    use arrow::array::{Int32Array, RecordBatch};
        assert!(!matches!(c[2][0], ColumnIndexMetaData::NONE), "RG2 real CI");
        let c = aug.column_index().unwrap();
                None => missing_col_rg_matrix.push((col, rg)),
        let pred_cols =
        None => r,
        let _g = lock_process_globals();
    footer_meta: &Arc<ParquetMetaData>,
        // pathologically large column can't wrap the cast.
        #[allow(deprecated)]
    Some(off..off + len)
        }
        scoped_cache_stats, set_column_index_cache_limit_for_test, set_whole_region_fetch_enabled,
    data: ColumnIndexMetaData,
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[1])
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_both, &[])
            full_list_pages,
        column_index_cache_stats()
            .ok()?;
    }
        let s_kept = PagePruner::new(&schema, Arc::clone(&aug), schema.clone())
        let c_qty = resolve_predicate_parquet_columns(&schema, &fo, &["qty".to_string()], &schema);
    async fn distinct_predicates_share_offset_index() {
            &footer_only(&bytes),
        // Predicate now covers {price, qty}: price's cell hits, qty's cell misses.
                Arc::new(Int32Array::from(prices)),
    async fn second_load_is_cache_hit() {
            schema.clone(),
            0,
            vec![0, 1],
        )
    };
        let full = full_index(&bytes);
            .set_statistics_enabled(EnabledStatistics::Page)
        assert_eq!(
    async fn evict_file_clears_all_cells_for_that_path() {
};
                PagePruner::new(&schema, Arc::clone(&aug), schema.clone()).prune_rg(&pp, rg, None);
    /// The combined payoff across BOTH axes: a second query that adds a new
    store: &Arc<dyn ObjectStore>,
        let (store, location) = stage(bytes).await;
) -> Option<ParquetOffsetIndex> {
                Arc::new(Int32Array::from(qtys)),
            (ci().hits, ci().misses, ci().entries),
            .unwrap();
            )
        assert!(
        w.close().unwrap();
            ],
                },
            1,
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_qty, &[])
        for &c in &[0usize, 1, 2] {
                    path: path.clone(),
                "cell ({}, {}) out of matrix bounds ({num_rgs} rgs, {num_cols} cols)",
    /// narrow path: scoped pruning still matches the full index, and the decode is
            f,
        assert_eq!(
        let n0: Vec<i32> = (0..ROWS).collect();
            .await
        );
            .put(&loc, PutPayload::from_bytes(bytes))
    let (ci_result, oi_result) = tokio::join!(
        assert!(fo.offset_index().is_none());
    // arrow compute a range whose `end < start`, and the read path's
            .set_statistics_enabled(EnabledStatistics::Page)
    type T = buf::Reader<Bytes>;
    // Use insert_batch: all missing OI columns for this query in one lock acquisition.
    /// ColumnIndex. If the pruner TRUSTED that placeholder's (absent) stats it
        clear_scoped_cache_for_test();
        let (bytes, schema) = two_col_parquet();
// ── ColumnIndex cache lookup + build (per `(file, col, rg)` cell) ────────────
                cell.size,
    use datafusion::physical_expr::PhysicalExpr;
        for col in 0..num_cols {
            None,
            .unwrap();
        let union_schema: SchemaRef = Arc::new(Schema::new(vec![
        w.close().unwrap();
    #[tokio::test]
        .metadata()
///
    /// returns `None` for nested types, so the resolver needs its own root-to-leaf
        let pred_cols =
    /// 4 columns (2 int `n0`,`n1` + 2 wide string `s0`,`s1`), 1 RG, multiple pages.
    /// OffsetIndex equivalent: different projections cache only the new column
async fn fetch_index_buffers(
        assert!(real_pages > 1, "fixture should have multi-page columns");
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["id".to_string()], &schema);
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_qty, &[])
        sel.iter().filter(|s| !s.skip).map(|s| s.row_count).sum()
///   only the scoped columns are decoded out, so heap is unchanged — just the bytes
        clear_scoped_cache_for_test();
}
            &schema,
        clear_scoped_cache_for_test();
            Field::new("id", DataType::Int32, false),
        let _g = lock_process_globals();
            "n1 reused; s0 new"
        let (store, loc) = stage(bytes.clone()).await;
    // always scoped to the requested columns.
    }
        assert_eq!((ci().hits, ci().misses), (0, 1));
        let fo = footer_only(&bytes);
async fn build_column_index_cells(
        let schema = Arc::new(Schema::new(vec![
                f.as_ref().map(kept),
        clear_scoped_cache_for_test();
    // Per-column accumulator: one OiColumn slot per requested col, filled RG by RG.
        w.close().unwrap();
    for c in chunks {
    /// never prunes on `qty`, so the scoped result stays a conservative superset.
        assert!(
    #[tokio::test]
            parquet::arrow::parquet_to_arrow_schema(
    }
    /// same `(file, col)` parquet column, so they share the one CI cell — predicate
    /// (the default) → 2 OI cells (one per column).
            Field::new("n0", DataType::Int32, false),
        (Bytes::from(buf), schema)
    // full-width `[rg][col]` matrix; consumers (DataFusion's page pruner, arrow's
    col: usize,
            .await
    column_index: Option<ParquetColumnIndex>,
            .await
        let loc = ObjPath::from("data.parquet");
    /// absolute start of the fetched buffer, so `start - base` gives the
        match self {
/// Fetch the page-index bytes for a decode plan and return one [`BufferChunkReader`]
    // keep the whole RG (1 page = all rows → can't prune), never a wrong result.
        let batch = RecordBatch::try_new(
                "col {c} (pred/proj/metric) real OI"
    /// sized to hold ~1.5 cells, loading two distinct column cells evicts the LRU
    /// cells are SHARED. Both loads default to the all-column OffsetIndex, so the
}
        // Decode stayed scoped: 4 RGs × 1 predicate col = 4 CI cells (not all columns).
        .set_offset_index(Some(offset_index))
        clear_scoped_cache_for_test();
    }
        }
use parquet::file::page_index::offset_index::OffsetIndexMetaData;
            Field::new("price", DataType::Int32, false),
        );
            matrix[rg][col] = entry.clone();
    /// Regression: a match()-only query has NO residual predicate columns
    async fn scoped_index_reads_non_predicate_projected_column() {
mod tests {
        w.write(&batch).unwrap();
        b.append_offset_and_size(col_start as i64, size);
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[2])
        let price_ge = pred("price", 0, Operator::GtEq, 16);
            Arc::clone(&schema),
        let mut reader = builder
    #[tokio::test]
    // group, NOT an empty page-locations list. A scoped OffsetIndex is grafted as a
        .collect();
/// row group (read-time safety — see [`OiCellKey`]). `None` if any column lacks
    // The pair-resolve must return exactly what two separate single-name resolves
/// that clone is a refcount bump, not a deep copy of every row group's
    #[tokio::test]
    let num_cols = footer_meta.file_metadata().schema_descr().num_columns();
        let mut b = OffsetIndexBuilder::new();
    };
            .await
            .await
            2,
                cell.size,
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
pub async fn load_scoped_page_index_cols(
                bytes: bytes.clone(),
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        let (store, loc) = stage(bytes.clone()).await;
        assert!(load_scoped_page_index_cols(&store, &loc, &fo, &[], &[])
            .prune_rg(&pp, 0, None);
    let path: Arc<str> = Arc::from(location.as_ref());
        // qty <= 115 (full keeps pages 0,1) → full intersection prunes to 0 rows.
    ParquetOffsetIndex,
    #[tokio::test]
    footer_meta: &Arc<ParquetMetaData>,
    // these placeholders.
            .await
        // Reload — must be a miss, not a hit from stale cache.
        None => (0..num_cols).collect(),
/// path requires all requested columns to have an index, else footer-only fallback).
        );
    }
async fn attach_scoped_page_index_to_metadata(
        // Stage two identical files at different paths.
    /// would build a bogus single-page grid for `qty` and could mis-prune. The
    for (i, p) in plan.iter().enumerate() {
    /// a subsequent load for the same path is a miss, not a stale hit.
        w.write(&batch).unwrap();
//! Page-index load entry points and their supporting internals.
        let props = WriterProperties::builder()
        let builder = ParquetRecordBatchReaderBuilder::new_with_metadata(bytes.clone(), arm);
    let buffers = store.get_ranges(location, &fetch_ranges).await.ok()?;
            .set_data_page_row_count_limit(8)
        for &col in predicate_cols {
            .await
        let (bytes, _schema) = two_col_parquet();
            ci().entries,
        assert_eq!(oi().entries, 4, "two OI cells per file");
    /// "capacity overflow" in release; see indexed_table/parquet_bridge.rs get_byte_ranges).
/// Union of `extent` across `chunks`; any missing extent bails to `None` (the narrow
        let (bytes, schema) = wide4_parquet();
    }
    /// position within `self.bytes`.
use arrow::datatypes::SchemaRef;
    }
        let (bytes, schema) = two_col_parquet();
        assert_eq!(
    use object_store::path::Path as ObjPath;
    /// 4 row groups of 10 rows (`id` 0..40, `v` = id*2), page size 5.
    #[tokio::test]
    }
        let (col_start, col_len) = rg.column(col_idx).byte_range();
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
    /// predicate→leaf resolution does NOT depend on a column's position in a wider
        Arc::new(PhysColumn::new(name, idx))
        Some(projection_cols),
        assert_eq!(
            ci().misses,
            "col-scoped OI {} < all-col {}",
            region.start <= scoped.start && region.end >= scoped.end,
    async fn col_scoped_offset_index_only_for_requested_columns() {
        }
    // ── Step 2: column-scoping the OffsetIndex ────────────────────────────
        set_whole_region_fetch_enabled(false);
            .await
        let region = whole_index_region(&fo, ci_extent).unwrap();
        // {n1,s0}: n1 hits, s0 new.
        // Whole region spans ALL cols × ALL RGs, so it's derived from the footer,
            ci().entries,
    if predicate_cols.is_empty() && oi_proj.is_none() && projection_cols.is_some() {
            .await
        // Residual references BOTH columns: price >= 16 (full keeps pages 2,3) AND
    };
        let (c1, o1) = (ci(), oi());
    let placeholder_for = |rg_idx: usize, col_idx: usize| -> OffsetIndexMetaData {
            .unwrap();
        let full_vals = read_selected_column(&bytes, &full_index(&bytes), 1, selection).unwrap();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[0, 1])
            Field::new("s0", DataType::Utf8, false),
    let mut missing_col_rg_matrix: Vec<(usize, usize)> = Vec::new(); // (col, rg)
            .await
                .ok_or("projected column was not Int32")?;
        clear_scoped_cache_for_test();
    // makes any derived range a valid full-chunk read — the one-page semantics are
        )
}
        .unwrap()
    }
use datafusion::parquet::file::reader::{ChunkReader, Length};
    projection_cols: &[usize],
            (
        // compressed_page_size is i32; clamp the (already-bounded) chunk length so a
            "projected LIST leaf must use its real OffsetIndex, not a one-page placeholder"
        assert_eq!(ci().entries, 0, "CI cells must be gone after eviction");
        get_or_build_offset_index(store, location, footer_meta, predicate_cols, oi_proj),
    col_rg_matrix: &[(usize, usize)],
    acc
    }
        );
            oi().entries,
                OiCellKey {
            .unwrap();
            .unwrap(); // cell (col1) → evicts col0
        ]));
            scoped.offset_index().unwrap()[0][1].page_locations().len(),
        use arrow::array::StringArray;
        let cols = resolve_predicate_parquet_columns(
            .await
            .await
        let fo = footer_only(&bytes);
                cell.data.clone(),
        for (entry, &col) in decoded.into_iter().zip(p.cols.iter()) {
                self.bytes.len()
        let tags = arrow::array::ListArray::new(
            build_offset_index_columns(store, location, footer_meta, &missing, num_rgs).await?;
        assert_eq!(scoped_vals, expected);
/*
    if !missing_col_rg_matrix.is_empty() {
            "col 3 (scoped out) OI is a single-page placeholder, not real and not empty"
    /// residual mask drops them post-decode), so equality is NOT required and is
    }
            "covered columns reuse their cells, no new entries"
    /// Distinct predicate columns → distinct CI cells, but the OffsetIndex column
        // No predicate → no ColumnIndex grafted.
    use datafusion::logical_expr::Operator;
    fn get_read(&self, start: u64) -> ParquetResult<Self::T> {
/// Range-read + decode the OffsetIndex for each requested column across **every**
        let _g = lock_process_globals();
    /// per-column cells, and a later column-scoped load whose set is covered by
            .await
        let loc_b = object_store::path::Path::from("file_b.parquet");
        let (store, loc) = stage(bytes.clone()).await;
            let a = batch
        let batch = RecordBatch::try_new(
            "projected col qty has real OffsetIndex"
        // so any consumer dereference is safe — never empty, which would panic).
                cell.col,
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
            );
    /// predicate column AND scans a wider RG set decodes only the genuinely new
                Some(cell) => col_index_matrix[rg][col] = cell,
        let _g = lock_process_globals();
        let (bytes, schema) = two_col_parquet();
            let f =
            &fo,
        );
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_qty, &[])
    cols: &[usize],
    #[tokio::test]
            (ci().hits, ci().misses, ci().entries),
        let _ = load_scoped_page_index_cols(&store_a, &loc_b, &fo, &cols, &[0, 1])
    store: &Arc<dyn ObjectStore>,
    /// Translate an absolute file offset `start` to a buffer-relative index.
            "price must resolve to its per-file leaf (1), not union pos 0"
        w.close().unwrap();
    fn read_selected_column(
            .await
            });
        let vs: Vec<i32> = (0..40).map(|x| x * 2).collect();
        clear_scoped_cache_for_test();
        );
        let extra: Vec<i32> = (1000..1032).collect();
        let o = aug.offset_index().unwrap();
            (oi().hits, oi().misses, oi().entries),
    async fn col_scoped_reads_projected_non_predicate_column() {
struct CiCell {
            "decode scoped to predicate col despite wide fetch"
) -> Option<Vec<OiCell>> {
use super::{COLUMN_INDEX_CACHE, OFFSET_INDEX_CACHE};
    }
            .unwrap();
            schema.clone(),
        assert!(
            .prune_rg(&pp, 0, None)
            .await
            "non-predicate col stays NONE"
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        for cell in built {
        assert_eq!(
    /// (like a schema-evolution-absent column) → it contributes "unknown" and
        };
            "same column → one cell regardless of literal"
        let (store, loc) = stage(bytes.clone()).await;
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[])
        let real_pages = full.offset_index().unwrap()[0][0].page_locations().len();
        predicate_cols.iter().all(|&i| i < num_cols),
            .set_write_batch_size(1)
            return Err(ParquetError::General(format!(
        let (bytes, schema) = two_col_parquet();
            .unwrap();
            "fixture sanity: real chunk has non-zero offset+size"
        }
    }
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
    fn pred(name: &str, idx: usize, op: Operator, v: i32) -> Arc<dyn PhysicalExpr> {
    // return — it only shares the per-file arrow-schema derivation, nothing else.
/// any requested column lacks a column-index range (→ footer-only fallback).
        .into_builder()
) -> Option<Arc<ParquetMetaData>> {
    /// would be an under-count / lost result). It MAY keep extra rows (the
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
    /// *value* never multiplies cache entries. (`status>=400` vs `status>=100`.)
    // exactly once after the batch rather than once per cell.
/// Build a fresh `ParquetMetaData` = `footer` with the page-index pair grafted
        let pp =
        }
            .get_ranges(location, std::slice::from_ref(&region))
        let (store, loc) = stage(bytes.clone()).await;
/// == None` → all columns); see [`OiCellKey`] for why each must be real. Each
    fn lit_int(v: i32) -> Arc<dyn PhysicalExpr> {
    Some(out)
    let mut matrix: ParquetOffsetIndex = (0..num_rgs)
            .build()
        let _g = lock_process_globals();
            resolve_predicate_parquet_columns(&schema, &fo, &["n1".to_string()], &schema);
        let (store, loc) = stage(bytes.clone()).await;
            .await
            "no predicate → ColumnIndex absent"
        )
        assert_eq!(s.as_ref().map(kept), Some(16));
        assert!(
        let qty_le = pred("qty", 1, Operator::LtEq, 115);
        let selection = RowSelection::from(vec![RowSelector::skip(16), RowSelector::select(16)]);
                cell.rg,
    }
        let f = f_kept.unwrap_or(usize::MAX);
 */
    }
        assert_eq!(
        let (bytes, schema) = four_rg_parquet(); // id, v — 4 RGs, multi-page
    #[cfg(test)]
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
            for i in 0..a.len() {
    /// CI hit/miss accounting across two predicate-column sets.
        // Whole CI region is a strict superset of the scoped `id`-only union.
        meta: &Arc<ParquetMetaData>,
        assert!(
        let fo = footer_only(&bytes);
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
    }
            "no hits — eviction prevented serving stale data"
    let num_cols = footer_meta.file_metadata().schema_descr().num_columns();
    #[tokio::test]
        assert_eq!(ci().hits, hits_before + 1, "MRU cell must remain cached");
        let props = WriterProperties::builder()
        let expected: Vec<i32> = (116..132).collect();
            build_pruning_predicate(&pred("price", 1, Operator::GtEq, 20), file_schema.clone())
    }
    Some(out)
        }
use datafusion::parquet::file::page_index::column_index::ColumnIndexMetaData;
    );
            "cols 0,1,2"
}
    async fn projection_only_builds_offset_index_without_predicate() {
            schema.clone(),
        // 100..108,108..116,116..124,124..132). 1 RG, 4 pages each.
    let buffers = fetch_index_buffers(store, location, footer_meta, &plan, oi_extent).await?;
        let pred_cols =
        let _g = lock_process_globals();
        );
            set.into_iter().filter(|&c| c < num_cols).collect()
                    get_or_build_column_index(store, location, footer_meta, predicate_cols).await?,
//! the ColumnIndex for predicate columns (all RGs) and the OffsetIndex for
            &fo,
        let full_list_pages = full.offset_index().unwrap()[0][1].page_locations().len();
            "region superset of scoped"
/// and the indexed executor augmentation loop.
        let size = i32::try_from(col_len).unwrap_or(i32::MAX);
        assert_eq!(scoped_vals, full_vals);
    // The single page MUST carry the column chunk's REAL byte offset+size, not
        let full = full_index(&bytes);
                    path: path.clone(),
            Arc::new(object_store::memory::InMemory::new());
        let _g = lock_process_globals();
        set_whole_region_fetch_enabled(false);
    Some(IndexBuffers::PerEntry(
                Arc::new(Int32Array::from(n0)),
            .put(&loc_a, object_store::PutPayload::from_bytes(bytes.clone()))
        let ph_pages = o[0][3].page_locations();
    use crate::test_process_globals::lock as lock_process_globals;
    for (rg, entry) in column.into_iter().enumerate() {
            "cols 0,1 reused (2 hits); only col 3 freshly decoded"
    async fn placeholder_offset_index_spans_real_chunk_byte_range() {
        assert_eq!(ci().entries, 4, "4 RGs × 1 pred col");
        clear_scoped_cache_for_test();
            Arc::new(arrow::array::StringArray::from(vec![
        let _g = lock_process_globals();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
        clear_scoped_cache_for_test();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
            (0, 2, 2),
    /// Byte-bounded LRU on the (now cell-keyed) ColumnIndex cache: with the budget
            assert_eq!(
        let s1: Vec<String> = (0..ROWS).map(|r| format!("s1_{r:05}_padpadpad")).collect();
    // Fetch (wide whole-region on remote, narrow per-RG on local). Decode below is
        selection: RowSelection,
/// Place a column's all-RG OffsetIndex (indexed by RG) into the matrix at `col`.
    footer_meta: &Arc<ParquetMetaData>,
fn scatter_offset_column(matrix: &mut ParquetOffsetIndex, col: usize, column: &OiColumn) {
        let _g = lock_process_globals();
/// graft effectively free.
/// col)` cells, decoding only the columns that miss.
    let mut col_index_matrix: ParquetColumnIndex = (0..num_rgs)
            end >= ph.offset as u64,
        let fo = footer_only(&bytes);
            Field::new("extra", DataType::Int32, false),
