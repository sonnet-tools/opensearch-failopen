    if buffers.len() != fetch_ranges.len() {
        );
/// Assemble the full-width `[rg][col]` `OffsetIndex` matrix (real entries only at
        assert_eq!(ci().entries, 0, "CI cells must be gone after eviction");
        let _g = lock_process_globals();
        assert_eq!(
        assert_eq!((ci().hits, ci().misses, ci().entries), (0, 1, 1));
    /// first predicate already decoded, instead of re-decoding it inside a new
            "single placeholder page starts at row 0"
        let end = ph.offset as u64 + ph.compressed_page_size as u64;
            &["id".to_string(), "tags".to_string()],
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &parquet_cols, &offset_cols)
        let prices: Vec<i32> = (0..32).collect();
            .unwrap();
    use datafusion::common::ScalarValue;
            "derived range must not underflow (end >= start)"
            .unwrap();
        let (store, loc) = stage(bytes.clone()).await;
        let full = full_index(&bytes);
        // All empty — nothing to build.
        let proj = ProjectionMask::leaves(builder.parquet_schema(), [leaf_col]);
        assert_eq!(
        assert_eq!(
            .await
            .unwrap();
            Some(column) => scatter_offset_column(&mut matrix, col, &column),
    /// fallback. Without it, `tags` receives a placeholder OffsetIndex even though
    }
/// `predicate_cols` × all RGs; `NONE` everywhere else) by looking up each
    #[tokio::test]
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &proj_cols)
/// `ParquetMetaData.row_groups` held behind an `Arc` (see the arrow-rs change),
            build_pruning_predicate(&pred("id", 0, Operator::GtEq, 20), schema.clone()).unwrap();
            matrix[rg][col] = entry.clone();
            s
    }
    let num_cols = footer_meta.file_metadata().schema_descr().num_columns();
    let len = u64::try_from(c.offset_index_length()?).ok()?;
        let (bytes, schema) = two_col_parquet();
            .unwrap();
    // `range.end - range.start` then underflows (`parquet_bridge.rs` get_byte_ranges
        let f_kept = PagePruner::new(&schema, full, schema.clone())
            .await
}
        Some(a) => a.start.min(r.start)..a.end.max(r.end),
            .await
/// The resolved offset-column set is `predicate ∪ projection ∪ {0}` (`projection_cols
        // Project s1 (col 3): offset cols = {0, 1, 3}. Cols 0 & 1 hit; col 3 new.
        let rel = start.checked_sub(self.base).ok_or_else(|| {
            &schema,
        let (store, loc) = stage(bytes.clone()).await;
}
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[2])
        let ph = &ph_pages[0];
            );
    }
        assert_eq!(
    // `match() | sort | head` that page-selects the projected columns), arrow
        clear_scoped_cache_for_test();
        let scoped = load_scoped_page_index_cols(&store, &location, &footer, &[], &resolved)
        let (store, loc) = stage(bytes.clone()).await;
        assert_eq!(oi().entries, 4, "two OI cells per file");
            Field::new("extra", DataType::Int32, false),
            oi().entries,
        set_whole_region_fetch_enabled(false);
        let fo = footer_only(&bytes);
        let (bytes, schema) = two_col_parquet();
    extent: ChunkExtent,
        clear_scoped_cache_for_test();
    projection_cols: Option<&[usize]>,
        let ids: Vec<i32> = (0..40).collect();
    async fn footer_only_has_no_page_index() {
        set_whole_region_fetch_enabled(true);
    /// shared buffer must contain every scoped column's absolute offsets.
    use object_store::path::Path as ObjPath;
            );
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
    #[cfg(test)]
        let _g = lock_process_globals();
    /// still scoped (one CI cell per (col, rg), not one per column). Only the bytes
    }
        w.write(&batch).unwrap();
            "placeholder page offset must be the real chunk start (not 0)"
    use super::*;
    }
        let (bytes, schema) = wide4_parquet();
) -> Option<ParquetOffsetIndex> {
        let (store, loc) = stage(bytes.clone()).await;
        ]));
    let mut columns: Vec<OiColumn> = cols.iter().map(|_| Vec::with_capacity(num_rgs)).collect();
}
/// that reads that column irrespective of projection or predicate.
/// - **Local store** — the original narrow per-entry fetch of just the scoped
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_qty, &[])
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
        clear_scoped_cache_for_test();
        let full_vals = read_selected_column(&bytes, &full, 1, selection).unwrap();
            .await
            .build()
        let file_schema = Arc::new(
        let c = aug.column_index().unwrap();
 */
/// The page-index extent (byte offset..end) of one column chunk, for one index kind.
            hits_before + 1,
            .await
            .await
            "non-predicate col CI is NONE"
        let (store, loc) = stage(bytes.clone()).await;
    read_columns_indexes, read_offset_indexes,
    column_index: Option<ParquetColumnIndex>,
        offset_index_cache_stats()
    #[tokio::test]
        let vs: Vec<i32> = (0..40).map(|x| x * 2).collect();
        let fo = footer_only(&bytes);
            4,
        let built =
        assert_eq!(
            .build();
///
        let fo = footer_only(&bytes);
            .build();
        let o = aug.offset_index().unwrap();
            col_start > 0 && col_len > 0,
    location: &object_store::path::Path,
                .column(0)
                .as_any()
    }
        // wide4 has 256 rows / page-size 32 → real columns have multiple pages.
        let pp =
        ]));
use datafusion::parquet::file::reader::{ChunkReader, Length};
        sel.iter().filter(|s| !s.skip).map(|s| s.row_count).sum()
            ArrowReaderOptions::new().with_page_index(false),
            .expect("projection-only load must produce grafted metadata (not None)");
        let selection = RowSelection::from(vec![RowSelector::skip(16), RowSelector::select(16)]);
            .unwrap();
            ])),
    fn new(footer_meta: &Arc<ParquetMetaData>, rg: usize, cols: Vec<usize>) -> Self {
        // pages (rows 16..32 = 16 rows). Build the pruning predicate against the
        .collect();
    /// (the default) → 2 OI cells (one per column).
            .unwrap();
        assert_eq!(s.as_ref().map(kept), f.as_ref().map(kept));
            "scoped page pruning must be a safe superset of full ({} kept) but kept fewer ({})",
            .await
            &schema,
        // qty <= 115 (full keeps pages 0,1) → full intersection prunes to 0 rows.
            .unwrap();
            Field::new("price", DataType::Int32, false),
            !matches!(c[0][0], ColumnIndexMetaData::NONE),
    // An empty projection slice means "no specific projection" → treat as None (all columns).
    //            Col 0 is always included because the page-skip metric reads it
    /// would be an under-count / lost result). It MAY keep extra rows (the
        clear_scoped_cache_for_test();
        assert!(
            path: path.clone(),
    #[tokio::test]
    }
    /// set-keyed entry. `price` then `{price, qty}` → `price`'s cell is a HIT; only
        let proj_cols =
        );
/// Range-read + decode the requested `(col, rg)` ColumnIndex cells, grouping by
            .unwrap();
        );
    // ── baseline / correctness ────────────────────────────────────────────
    // The pair-resolve must return exactly what two separate single-name resolves
fn ci_extent(c: &ColumnChunkMetaData) -> Option<Range<u64>> {
        Some(p) if !p.is_empty() => Some(p),
    async fn distinct_predicates_share_offset_index() {
            .await
        );
            .set_write_batch_size(8)
        assert_eq!(
        let fo = footer_only(&bytes);
            resolve_predicate_parquet_columns(&schema, &fo, &["n1".to_string()], &schema);
    }
    // Phase 1: serve every needed cell that is already cached; collect misses.
    /// a subsequent load for the same path is a miss, not a stale hit.
        // OffsetIndex must be real for the projected col (1) AND col 0 (loader
        let expected: Vec<i32> = (116..132).collect();
        // Residual references BOTH columns: price >= 16 (full keeps pages 2,3) AND
        assert!(
    location: &object_store::path::Path,
    let oi_proj = match projection_cols {
    let num_cols = footer_meta.file_metadata().schema_descr().num_columns();
            (0, 1, 1),
            .await
        let _g = lock_process_globals();
        let s = PagePruner::new(&schema, Arc::clone(&aug), schema.clone()).prune_rg(&pp, 0, None);
        let (bytes, _schema) = two_col_parquet();
        );
            arrow::buffer::OffsetBuffer::new(vec![0_i32, 2, 3, 5].into()),
        let pred_cols =
        let pred_cols =
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        let full = full_index(&bytes);
            "fixture sanity: real chunk has non-zero offset+size"
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
            .await
    /// returns `None` for nested types, so the resolver needs its own root-to-leaf
            Field::new("id", DataType::Int32, false),
        // never enters the cache key.
            .unwrap();
    // Phase 1: serve cached columns; collect misses.
fn union_extent(chunks: &[ColumnChunkMetaData], extent: ChunkExtent) -> Option<Range<u64>> {
/// metadata. Built once per RG and used by BOTH the fetch (to union the chunks'
}
                self.base
    #[tokio::test]
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_qty, &[])
        assert!(
            "price must resolve to its per-file leaf (1), not union pos 0"
///
    size: usize,
use prost::bytes::{buf, Buf, Bytes};
        let (bytes, schema) = two_col_parquet();
            resolve_predicate_parquet_columns(&schema, &fo, &["n1".to_string()], &schema);
        assert!(
                    path: path.clone(),
        );
        let rgm = footer_meta.row_group(rg);
        );
        // {n0,n1}: n0 hits, n1 new.
) -> Option<IndexBuffers> {
        // The UNION/table schema the query carries: `price` at position 0 — but in
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[3])
    rg: usize,
        let expected: Vec<i32> = (116..132).collect();
    async fn rg_scoped_key_includes_surviving_rgs() {
    }
        let names_a = vec!["price".to_string()];
        );
        assert!(
/// `(file, col, rg)` cell in the cache and decoding only the cells that miss.
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_n0, &[])
    /// "capacity overflow" in release; see indexed_table/parquet_bridge.rs get_byte_ranges).
        w.close().unwrap();
    /// The OffsetIndex path under whole-region fetch reads the projected column
            vec![
use std::collections::{HashMap, HashSet};
/// - **Remote/warm store** ([`is_whole_region_fetch_enabled`]) — ONE `get_ranges`
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        let _g = lock_process_globals();
    bytes: Bytes,
            .unwrap();
        writer.close().unwrap();
        let o = aug.offset_index().unwrap();
    }
            ],
    };
        assert_eq!(scoped_vals, expected);
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_n0_n1, &[])
            (oi().hits, oi().misses, oi().entries),
            .await
        // Stage two identical files at different paths.
        w.close().unwrap();
        return None;
    // (count/agg, SingleCollector prefetch, schema-evolved files). A one-page
//! projection columns, using the two process-global caches.
        if decoded.len() != p.cols.len() {
        writer.write(&batch).unwrap();
            &fo,
    }
        let c_qty = resolve_predicate_parquet_columns(&schema, &fo, &["qty".to_string()], &schema);
        let s = s_kept.unwrap_or(usize::MAX);
        let c_both = resolve_predicate_parquet_columns(
                },
            Field::new("extra", DataType::Int32, false),
    use object_store::memory::InMemory;
        let bytes = evolved_extra_price_parquet();
            .await
        ArrowReaderMetadata::load(
        clear_scoped_cache_for_test();
            .await
            }
            (
            "non-predicate col stays NONE"
        let (bytes, schema) = two_col_parquet();
/*
        };
    let mut missing_col_rg_matrix: Vec<(usize, usize)> = Vec::new(); // (col, rg)
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_n1_s0, &[])
    // Narrow: one scoped fetch per plan entry, reusing each entry's precomputed chunks.
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[1])
            (2, 3, 3),
    fn get_read(&self, start: u64) -> ParquetResult<Self::T> {
/// single source of truth for the range key warm-population must also write.
        }
        )
        let _g = lock_process_globals();
    let mut acc: Option<Range<u64>> = None;
            let a = batch
        let n1: Vec<i32> = (0..ROWS).collect();
    #[tokio::test]
    async fn placeholder_offset_index_spans_real_chunk_byte_range() {
    .await
    acc
    // Placeholder for columns we don't build: a SINGLE page spanning the whole row
            .await
    }
        let _g = lock_process_globals();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
        );
            .unwrap();
            };
            vec![1],
                data: entry,
        let prices: Vec<i32> = (0..32).collect();
        clear_scoped_cache_for_test();
            .set_write_batch_size(1)
        let decoded = read_offset_indexes(&buffers.reader(i), &p.chunks).ok()??;
                    get_or_build_column_index(store, location, footer_meta, predicate_cols).await?,
        );
}
            .await
    async fn scoped_pruning_matches_full_index() {
}
}
    }
            "CI bytes {} must stay within {}",
use parquet::file::page_index::offset_index::OffsetIndexMetaData;
        let mut buf: Vec<u8> = Vec::new();
    // full-width `[rg][col]` matrix; consumers (DataFusion's page pruner, arrow's
    // preserved (still "can't prune"), just with coordinates arrow can subtract.
/// Assemble the full-width `[rg][col]` `ColumnIndex` matrix (real cells only at
    /// would build a bogus single-page grid for `qty` and could mis-prune. The
        let qty_le = pred("qty", 1, Operator::LtEq, 115);
            (1, 1, 1, c1.used_bytes)
        let (bytes, schema) = two_col_parquet();
        let decoded = read_columns_indexes(&buffers.reader(i), &p.chunks).ok()??;
    // keep the whole RG (1 page = all rows → can't prune), never a wrong result.
        // page index; the rest carry a single whole-RG placeholder page (non-empty
        let fo = footer_only(&bytes);
/// The only thing that differs between the CI and OI fetch paths.
                    col: cell.col,
    footer_meta: &Arc<ParquetMetaData>,
        let fo = footer_only(&bytes);
    }
        let _g = lock_process_globals();
///   only the scoped columns are decoded out, so heap is unchanged — just the bytes
    /// (union) schema lists `price` at a DIFFERENT position than the file's
    Some(off..off + len)
            "decode scoped to predicate col despite wide fetch"
            Field::new("s1", DataType::Utf8, false),
        let pred_cols =
        clear_scoped_cache_for_test();
        // position 0 (which is `extra` in this file).
/// Load + graft a scoped page index: ColumnIndex for `predicate_cols` (all RGs),
    // makes any derived range a valid full-chunk read — the one-page semantics are
        // The scoped-out column's placeholder is a single page...
        b.append_row_count(rg.num_rows());
        assert_eq!(oi().hits, 2);
 * this file be licensed under the Apache-2.0 license or a
                "column index out of bounds (num_cols={num_cols}): {set:?}"
    }
            .await
}
        },
        leaf_col: usize,
        assert!(
        let n0: Vec<i32> = (0..ROWS).collect();
) -> Option<Arc<ParquetMetaData>> {
        let batch = RecordBatch::try_new(
            "price cell decoded"
    use super::super::{
            .map(|s| kept(&s));
        get_or_build_offset_index(store, location, footer_meta, predicate_cols, oi_proj),
    use super::super::column_schema_resolver::{
        assert_eq!(
        let full = full_index(&bytes);
        .unwrap();
    //            Predicate-only queries (empty proj_cols) still get col 0 + predicate
}
    #[tokio::test]
        b.append_offset_and_size(col_start as i64, size);
        );
    plan: &[RgPlan],
            "distinct predicate cells: (price,rg0) + (qty,rg0)"
                    rg: cell.rg,
            vec![0, 1],
            for &c in predicate_cols {
        clear_scoped_cache_for_test();
            .unwrap();
    /// Regression: a match()-only query has NO residual predicate columns
    // always scoped to the requested columns.
    #[tokio::test]
    for rg in 0..footer_meta.num_row_groups() {
        let f = PagePruner::new(&file_schema, full, file_schema.clone()).prune_rg(&pp, 0, None);
        clear_scoped_cache_for_test();
    for p in plan {
///   warmed file is a hit instead of remote IO. All entries share that one buffer;
                footer.file_metadata().schema_descr(),
        let fo = footer_only(&bytes);
    async fn col_scoped_offset_index_only_for_requested_columns() {
    let buffers = fetch_index_buffers(store, location, footer_meta, &plan, ci_extent).await?;
        // Scope to n1 (pred) + s0 (proj). Col 3 (s1) is scoped out → placeholder.
        match self {
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_qty, &[])
        let scoped_vals = read_selected_column(&bytes, &aug, 1, selection.clone()).unwrap();
        let _g = lock_process_globals();
            } else {
            )
    fn rel(&self, start: u64, length: usize) -> ParquetResult<usize> {
            .await
            .set_write_batch_size(8)
    /// OffsetIndex → reader over-read ~2.5× the bytes on `... | stats ... by URL`.)
        .collect();
        .build();
        let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
                cell.data.clone(),
        clear_scoped_cache_for_test();
            if predicate_cols.is_empty() {
            IndexBuffers::PerEntry(v) => BufferChunkReader {
struct OiCell {
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
    /// `qty`'s cell is freshly decoded. (Under the old set-keyed cache this was a
    /// position within `self.bytes`.
            parquet_to_arrow_schema(
        // a budget of ~1.5 cells so a second distinct cell forces an eviction.
    }
            matches!(c[0][1], ColumnIndexMetaData::NONE),
//! the ColumnIndex for predicate columns (all RGs) and the OffsetIndex for
    /// n1∪s1∪{0}) — the shared cols (0, n1) hit; only the genuinely new projected
    /// nothing"; the most-recently-used cell survives.
        .map(|_| (0..num_cols).map(|_| ColumnIndexMetaData::NONE).collect())
        .map(|rg| (0..num_cols).map(|col| placeholder_for(rg, col)).collect())
impl IndexBuffers {
    col: usize,
        let _g = lock_process_globals();
//! [`load_scoped_page_index_cols`] is the single public entry point — it loads
            .unwrap();
}
        );
    async fn scoped_pruning_is_safe_superset_with_placeholdered_residual_col() {
            .unwrap();
        let qtys: Vec<i32> = (100..132).collect();
        let (bytes, schema) = two_col_parquet();
    let offset_index = oi_result?;
    let placeholder_for = |rg_idx: usize, col_idx: usize| -> OffsetIndexMetaData {
    #[tokio::test]
        Ok(rel)
/// are never stored across the loop.
        assert_eq!(oi().entries, 2, "all-columns load caches 2 column cells");
        super::super::evict_file_from_scoped_cache(loc_a.as_ref());
    // Phase 2: decode the missing cells (vectored fetch grouped by RG), place
            }
        let names_b = vec!["qty".to_string(), "price".to_string()];
            "all-column OffsetIndex: 2 column cells, shared"
        let o = aug.offset_index().expect("OffsetIndex must be grafted");
///   columns' extents (fewer bytes; no warm tier to match).
            ci().used_bytes <= budget,
        let (c1, o1) = (ci(), oi());
        );
    /// The scoped load must still build the OffsetIndex for the projected column
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
    data: OiColumn,
        }
            .await
    /// predicate column AND scans a wider RG set decodes only the genuinely new
        ScopedCacheStats,
    }
            &file_schema,
            let mut set: HashSet<usize> = HashSet::new();
            .unwrap(),
        assert_eq!(
        let mut b = OffsetIndexBuilder::new();
                size,
    store: &Arc<dyn ObjectStore>,
            }
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["id".to_string()], &schema);
            .unwrap();
        let _ = load_scoped_page_index_cols(&store_a, &loc_a, &fo, &cols, &[0, 1])
                Arc::new(Int32Array::from(vs)),
        clear_scoped_cache_for_test();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[])
    }
    extent: ChunkExtent,
        );
///
            "no predicate → ColumnIndex absent"
    footer_meta: &Arc<ParquetMetaData>,
            Field::new("tags", DataType::List(list_field), true),
        assert!(
            "scoped pruning must match full index"
use object_store::ObjectStore;
        #[allow(deprecated)]
        let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
            base: region.start,
use datafusion::parquet::file::metadata::{
    // Use insert_batch so all cells from this query are inserted under a single
        let tags = arrow::array::ListArray::new(
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        let rgm = footer_meta.row_group(p.rg);
            resolve_predicate_parquet_columns(&schema, &fo, &["n1".to_string()], &schema);
        .unwrap()
struct RgPlan {
    // the matrix, and populate the cache.
    predicate_cols: &[usize],
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_qty, &[])
    fn two_col_parquet() -> (Bytes, SchemaRef) {
/// `extent` selects the index kind. `None` (→ footer-only fallback) if there is no
            "file_b CI cell must still be cached"
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[0, 1])
        let ph_pages = o[0][3].page_locations();
    fn reader(&self, i: usize) -> BufferChunkReader {
        }
            )
    /// *value* never multiplies cache entries. (`status>=400` vs `status>=100`.)
            full_list_pages,
        );
        let mut out = Vec::new();
        }
            .await
            )
    use datafusion::physical_expr::PhysicalExpr;
        let cols = resolve_predicate_parquet_columns(
    /// ColumnIndex. If the pruner TRUSTED that placeholder's (absent) stats it
    }
        )
            .unwrap();
            "covered columns reuse their cells, no new entries"
                cell.data.clone(),
        let props = WriterProperties::builder()
        let _g = lock_process_globals();
    ))
            "region superset of scoped"
        let hits_before = ci().hits;
    PerEntry(Vec<(u64, Bytes)>),
    Some(out)
    store: &Arc<dyn ObjectStore>,
        let (bytes, schema) = two_col_parquet();
    // CI and OI IO run concurrently — wall time = max(ci, oi) not their sum.
        let full_vals = read_selected_column(&bytes, &full_index(&bytes), 1, selection).unwrap();
    }
    /// Regression: the single-page placeholder for a scoped-OUT column must carry
/// A [`ChunkReader`] over an in-memory byte buffer representing the file region
        let props = WriterProperties::builder()
            0,
            &schema,
        clear_scoped_cache_for_test();
            });
        assert!(
    let mut out: Vec<OiCell> = Vec::with_capacity(cols.len());
            set.insert(0); // page-skip metric always reads col 0
        Ok(out)
    /// Two predicates on the SAME column with DIFFERENT literals resolve to the
        clear_scoped_cache_for_test();
        // Both predicates are on `price` (col 0) — only the literal differs, which
        );
            .unwrap();
            "fixture must contain multiple LIST pages"
            resolve_predicate_parquet_columns_pair(&schema, &fo, &names_a, &names_b, &schema);
}
        let c_n0 = resolve_predicate_parquet_columns(&schema, &fo, &["n0".to_string()], &schema);
    /// OffsetIndex equivalent: different projections cache only the new column
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[1])
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
                OiCellKey {
        // price 0..32 (pages 0..8,8..16,16..24,24..32); qty 100..132 (pages
            }
        let fo = footer_only(&bytes);
        Ok(self.bytes.slice(rel..).reader())
            .unwrap();
    let off = u64::try_from(c.column_index_offset()?).ok()?;
    location: &object_store::path::Path,
        let (store, loc) = stage(bytes.clone()).await;
    #[tokio::test]
    // arrow compute a range whose `end < start`, and the read path's
            schema.clone(),
use super::cache_keys::{CiCellKey, OiCellKey, OiColumn};
        assert_eq!(ci().entries, 1);
        let pp = build_pruning_predicate(&residual, schema.clone()).unwrap();
        let _g = lock_process_globals();
    }
        let mut buf: Vec<u8> = Vec::new();
        if decoded.len() != cols.len() {
        let _g = lock_process_globals();
        footer_meta,
        // Must resolve to the file's TRUE leaf for `price` = 1, NOT the union
            .prune_rg(&pp, 0, None)
            ],
            .await
    for (rg, entry) in column.iter().enumerate() {
/// OffsetIndex for `projection_cols` (∪ predicate ∪ col 0). This is the single
        let file_schema: SchemaRef = Arc::new(Schema::new(vec![
    }
            ci().misses,
        bytes: &Bytes,
    async fn scoped_index_reads_non_predicate_projected_column() {
        let batch = built.iter().map(|cell| {
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        let _ = load_scoped_page_index_cols(&store_a, &loc_b, &fo, &cols, &[0, 1])
        let _g = lock_process_globals();
        assert_eq!(ci().entries, 0);
        meta: &Arc<ParquetMetaData>,
        #[allow(deprecated)]
    // return — it only shares the per-file arrow-schema derivation, nothing else.
    }
        assert_eq!(oi().entries, 0, "OI cells must be gone after eviction");
    for &rg in &build_rgs {
        assert!(!matches!(c[0][0], ColumnIndexMetaData::NONE), "RG0 real CI");
/// Union of `extent` across `chunks`; any missing extent bails to `None` (the narrow
fn whole_index_region(
    }
            .await
            return None;
    }
    async fn adding_predicate_column_reuses_existing_cell() {
            let batch = next.map_err(|e| format!("read batch: {e}"))?;
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        let pred_cols =
            (ci().hits, ci().misses, ci().entries),
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
    #[tokio::test]
use datafusion::parquet::file::page_index::index_reader::{
        let all_cols = oi().used_bytes;
        let mut reader = builder
            "col 0 OffsetIndex real (always unioned)"
        let _g = lock_process_globals();
        );
            .with_projection(proj)
            Arc::new(arrow::array::StringArray::from(vec![
        assert_eq!(
        let fo = footer_only(&bytes);
            ph.first_row_index, 0,
            .set_statistics_enabled(EnabledStatistics::Page)
        // Project {1}; union {0,1} = both columns, both already cached → 2 hits.
        // the placeholdered `qty` — that's safe; the residual mask removes the
    for (k, &col) in cols.iter().enumerate() {
    let mut col_index_matrix: ParquetColumnIndex = (0..num_rgs)
    #[tokio::test]
/// and the indexed executor augmentation loop.
                PagePruner::new(&schema, Arc::clone(&full), schema.clone()).prune_rg(&pp, rg, None);
                out.push(a.value(i));
        let rel = self.rel(start, 0)?;
        let footer = footer_only(&bytes);
            assert_eq!(
        clear_scoped_cache_for_test();
    // → "subtract with overflow" / release "capacity overflow"). Spanning the real
        let props = WriterProperties::builder()
    /// sentinel" needed (the prior set-keyed design's mechanism).
        let fo = footer_only(&bytes);
fn merge(acc: Option<Range<u64>>, r: Range<u64>) -> Range<u64> {
            .await
            size,
}
        let schema = Arc::new(Schema::new(vec![
        pair_b.sort_unstable();
    };
        );
/// column-chunk metadata. On wide / many-row-group files (e.g. textbench's
        // FILE schema (price at index 1) so the converter matches the data.
    }
            ParquetError::General(format!(
        let (store, loc) = stage(bytes.clone()).await;
            oi().used_bytes < all_cols,
) -> Option<Range<u64>> {
            (4, 4),
        w.write(&batch).unwrap();
    // Each column chunk has its OWN byte offset, so the placeholder is per-(rg, col):
    async fn evict_file_does_not_affect_other_files() {
    store: &Arc<dyn ObjectStore>,
        // fewer). It keeps more here (16 vs 0) because it correctly cannot prune
        None => r,
    async fn different_literals_same_column_share_cell() {
            .set_statistics_enabled(EnabledStatistics::Page)
                .unwrap();
    for (rg, entry) in column.into_iter().enumerate() {
        // `price` pages: 0..8,8..16,16..24,24..32; `price >= 20` keeps the last two
            "scoped-out col 3 must have a single placeholder page"
    ColumnChunkMetaData, OffsetIndexBuilder, ParquetColumnIndex, ParquetMetaData,
            .set_max_row_group_size(32)
}
        while let Some(next) = reader.next() {
        let price_ge = pred("price", 0, Operator::GtEq, 16);
        let size = footer_meta
            scatter_offset_column_owned(&mut matrix, cell.col, cell.data);
    }
                .ok_or("projected column was not Int32")?;
            .unwrap();
/// production entry point used by both the listing path (`ScopedPageIndexReaderFactory`)
            .await
    /// cell-level hit/miss deltas.
        .metadata()
            &footer_only(&bytes),
                cell.col,
            .unwrap();
            .unwrap();
use std::ops::Range;
    for c in chunks {
        scoped_cache_stats, set_column_index_cache_limit_for_test, set_whole_region_fetch_enabled,
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[2])
    async fn scoped_resolution_is_per_file_under_schema_evolution() {
            .await
        assert_eq!(oi().entries, 2, "2 proj cols × 1 file");
        let (store, loc) = stage(bytes.clone()).await;
            ph_pages.len(),
use datafusion::physical_expr::PhysicalExpr;
    fn four_rg_parquet() -> (Bytes, SchemaRef) {
    use datafusion::parquet::arrow::arrow_reader::{
    fn kept(sel: &RowSelection) -> usize {
        let parquet_cols: Vec<usize> = vec![];
/// without one (lenient). The whole-file index region for the wide fetch — the
        let buffers = store
        let residual: Arc<dyn PhysicalExpr> =
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["id".to_string()], &schema);
        (Bytes::from(buf), schema)
    }
    }
        let (store, loc) = stage(bytes.clone()).await;
        store_a
        assert!(
            build_column_index_cells(store, location, footer_meta, &missing_col_rg_matrix).await?;
        // path). `qty` therefore gets the one-page placeholder + NONE ColumnIndex.
            .await
            None,
    footer_meta: &Arc<ParquetMetaData>,
        predicate_cols.iter().all(|&i| i < num_cols),
            "second load after eviction must be a cache miss"
/// Each cell is keyed on `(file, col, rg)` and decoded once per file — reused
            .unwrap();
) -> Option<Arc<ParquetMetaData>> {
        Arc::new(PhysColumn::new(name, idx))
            .ok()?;
            .await
            ci().hits,
        );
/// across every query that filters on the same column regardless of predicates.
        let one_cell = ci().used_bytes;
        );
) -> Option<Vec<OiCell>> {
/// cached cell is a column's OffsetIndex across **all** row groups, keyed only on
    // ── Whole-region fetch (remote/warm stores) ───────────────────────────────
            "projected col qty has real OffsetIndex"
        assert!(one_cell > 0);
        let (bytes, schema) = two_col_parquet();
        let (bytes, schema) = two_col_parquet();
/// row group so each RG's columns share one vectored fetch + decode. `None` if
        for &c in &[0usize, 1, 2] {
        // Second (qty) load re-read the same 2 OI cells from cache.
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        let schema = Arc::new(Schema::new(vec![
    projection_cols: &[usize],
        }
    }
        let fo = footer_only(&bytes);
            },
            .unwrap();
            .map_err(|e| ParquetError::General(format!("offset overflow: {e}")))?;
    // Initially filled NONE for all RGs and all cols - as placeholders
        );
    let mut fetch_ranges: Vec<Range<u64>> = Vec::with_capacity(plan.len());
mod tests {
    }
    }
    /// CI cells are keyed per `(file, col, rg)`. Loading a predicate column on a
    }
    acc
    let rebuilt = base
// ── ColumnIndex cache lookup + build (per `(file, col, rg)` cell) ────────────
    }
            Field::new("id", DataType::Int32, false),
            .with_row_selection(selection)
        .set_offset_index(Some(offset_index))
            .await
        ArrowReaderMetadata::load(
    Some(off..off + len)
            "2 OI cells (col0,col1)"
    // chunk extent (`byte_range()` = dictionary/data page start + compressed size)
        // Evict only file_a.
            .set_statistics_enabled(EnabledStatistics::Page)
            columns[k].push(entry);
    #[tokio::test]
            .map(|s| kept(&s));
        // Project s0 (col 2): offset cols = {0, 1(n1), 2(s0)} → 3 new cells.
            &["price".to_string(), "qty".to_string()],
        let batch = RecordBatch::try_new(
                Arc::new(Int32Array::from(qtys)),
            1,
/// the cache so we move rather than clone the per-RG entries.
                Some(Some(
            (c2.hits, c2.misses, c2.entries, c2.used_bytes),
    /// column is decoded.
                    path: path.clone(),
        }
        assert_eq!(oi().entries, 2, "only file_a's OI cells removed");
        // Measure one CI cell (predicate `price` = col0 at the single RG), then set
            "cols 0,1 reused (2 hits); only col 3 freshly decoded"
            f,
        );
    }
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[])
            &bytes.clone(),
///
    }
    }
        selection: RowSelection,
    if predicate_cols.iter().any(|&i| i >= num_cols) {
        let s0: Vec<String> = (0..ROWS).map(|r| format!("s0_{r:05}_padpadpad")).collect();
        clear_scoped_cache_for_test();
/// Fetch the page-index bytes for a decode plan and return one [`BufferChunkReader`]
        let (col_start, col_len) = fo.row_group(0).column(3).byte_range();
            .await
        // Pruning identical to the full index.
            let s =
        assert!(
                fo.file_metadata().key_value_metadata(),
        assert_eq!(scoped_vals, full_vals);
        fetch_ranges.push(union_extent(&p.chunks, extent)?);
    /// *union* schema.
            scoped.offset_index().unwrap()[0][1].page_locations().len(),
    type T = buf::Reader<Bytes>;
        let (store, loc) = stage(bytes.clone()).await;
    let mut by_rg: HashMap<usize, Vec<usize>> = HashMap::new();
    async fn new_column_combination_caches_only_new_column_cells() {
    /// derived from it is a valid full-chunk read.
    }
    #[tokio::test]
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
        _ => None, // empty or absent → OI covers all columns
            schema.clone(),
            .prune_rg(&pp, 0, None)
                PagePruner::new(&schema, Arc::clone(&aug), schema.clone()).prune_rg(&pp, rg, None);
    size: usize,
        clear_scoped_cache_for_test();
        );
            "OffsetIndex real for every column (all-col default)"
            .set_data_page_row_count_limit(8)
            (2, 2, 2, o1.used_bytes)
    Some(graft(footer_meta, column_index, offset_index))
        }
    /// residual mask drops them post-decode), so equality is NOT required and is
        clear_scoped_cache_for_test();
            vec![Arc::new(Int32Array::from(vec![1, 2, 3])), Arc::new(tags)],
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[0, 1])
/// such index region, or — narrow path — any scoped column lacks an extent.
/// row group (read-time safety — see [`OiCellKey`]). `None` if any column lacks
                Arc::new(Int32Array::from(prices)),
        // Cold: 4 RGs × 1 predicate col → 4 CI misses, 4 CI entries.
                "a", "b", "c", "d", "e",
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        );
    #[tokio::test]
    Some(matrix)
    async fn resolve_pair_equals_two_single_resolves() {
    /// the scan reads it, and the page reader treats a whole chunk as one page.
    /// never prunes on `qty`, so the scoped result stays a conservative superset.
    #[tokio::test]
        clear_scoped_cache_for_test();
        let pred_cols =
        let c_price =
                f.as_ref().map(kept),
        assert!(
        return None;
                Arc::new(StringArray::from(s0)),
        for &col in predicate_cols {
        );
        use datafusion::parquet::arrow::ProjectionMask;
        // file_b's cells are still hits.
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
                o[0][c].page_locations().len(),
    // ── fixtures + expr helpers ──────────────────────────────────────────
            .prune_rg(&pp, 0, None);
            .await
    async fn scoped_index_is_predicate_scoped_for_column_index() {
/// Build a fresh `ParquetMetaData` = `footer` with the page-index pair grafted
        let pp =
///   columns skipped). Matches the range key eager warm-population writes, so a
        let full = full_index(&bytes);
    // group, NOT an empty page-locations list. A scoped OffsetIndex is grafted as a
    // The single page MUST carry the column chunk's REAL byte offset+size, not
    ) -> std::result::Result<Vec<i32>, String> {
    async fn whole_region_fetch_offset_index_reads_match_full() {
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
            (ci().hits, ci().misses, ci().entries),
        // end (offset+size) >= start (offset).
                set.iter().all(|&c| c < num_cols),
        assert_eq!(pair_b, vec![0, 1]);
        let offset_cols: Vec<usize> = vec![1];
            debug_assert!(
    /// Schema-evolution fixture: a file whose physical layout is `[extra, price]`
            .await
            .await
        // Whole region spans ALL cols × ALL RGs, so it's derived from the footer,
        let schema = Arc::new(Schema::new(vec![
        clear_scoped_cache_for_test();
        clear_scoped_cache_for_test();
/// `min(start)..max(end)` over EVERY `(col, rg)` chunk's `extent`, skipping columns
    fn wide4_parquet() -> (Bytes, SchemaRef) {
        );
        clear_scoped_cache_for_test();
        );
            IndexBuffers::Shared { base, bytes } => BufferChunkReader {
            "both id and tags.list.element must receive real OffsetIndexes"
        let s = PagePruner::new(&file_schema, Arc::clone(&aug), file_schema.clone())
        let fo = footer_only(&bytes);
    };
    use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
        );
        let c = aug.column_index().unwrap();
    //   None   → no explicit projection, read everything → all columns get a real entry.
    if !missing.is_empty() {
    /// Evicting file A does not remove cells for file B. Cross-file isolation.
    /// full-index pruning — never drop a row the full index would keep (that
        for cell in built {
        let file_own_schema: SchemaRef = Arc::new(
                cell.size,
        for (entry, &col) in decoded.into_iter().zip(p.cols.iter()) {
        }
        let c_qty = resolve_predicate_parquet_columns(&schema, &fo, &["qty".to_string()], &schema);
                "col {c} (pred/proj/metric) real OI"
            Field::new("price", DataType::Int32, false),
        assert_eq!(
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        let fo = footer_only(&bytes);
        let rel = self.rel(start, length)?;
    //   Some   → build {col 0} ∪ predicate_cols ∪ proj_cols, clamped to num_cols.
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
            !o[0][0].page_locations().is_empty(),
            for &c in proj_cols {
        w.close().unwrap();
        assert!(
            .await
    /// Regression for the schema-evolution wrong-count bug: when the query's
/// [`BufferChunkReader`] per decode iteration via [`IndexBuffers::reader`] — readers
        );
            .await
        let _g = lock_process_globals();
            &fo,
    cols: &[usize],
        let schema = Arc::new(Schema::new(vec![
                Arc::new(Int32Array::from(ids)),
) -> Option<ParquetColumnIndex> {
        );
/// on. Clones the footer to get an owned value for the builder — but with
        let fo = footer_only(&bytes);
    /// The cell-keying payoff: a predicate that ADDS a column reuses the cell the
        .unwrap();
        // Warm: 1 CI cell (price,rg0) + 2 OI cells (col0, col1).
        clear_scoped_cache_for_test();
        let batch = RecordBatch::try_new(
                col,
    }
        let fo = footer_only(&bytes);
            .set_max_row_group_size(10)
    // write-lock acquisition — avoids per-cell lock overhead and runs eviction
        let s1: Vec<String> = (0..ROWS).map(|r| format!("s1_{r:05}_padpadpad")).collect();
        let (bytes, schema) = two_col_parquet();
    footer_meta: &Arc<ParquetMetaData>,
        clear_scoped_cache_for_test();
            .get_ranges(location, std::slice::from_ref(&region))
        }
            resolved,
        let (bytes, schema) = two_col_parquet();
    async fn stats_count_hits_and_misses() {
        )
        assert_eq!(s.as_ref().map(kept), Some(16));
        let (store, loc) = stage(bytes.clone()).await;
            end >= ph.offset as u64,
    /// the column chunk's REAL byte offset + size — not (0, 0). A (0, 0) placeholder
    use crate::test_process_globals::lock as lock_process_globals;
    predicate_cols: &[usize],
        })?;
        fetch_ranges.iter().map(|r| r.start).zip(buffers).collect(),
            )));
                },
    let num_rgs = footer_meta.num_row_groups();
use arrow::array::{ArrayRef, BooleanArray, UInt64Array};
        // No predicate → no ColumnIndex grafted.
        // The most-recently-used cell (qty/col1) must still be a hit.
        let _g = lock_process_globals();
    /// predicate→leaf resolution does NOT depend on a column's position in a wider
            (1, 2, 2),
        let fo = footer_only(&bytes);
    footer_meta: &Arc<ParquetMetaData>,
    // exactly once after the batch rather than once per cell.
            ))
            for i in 0..a.len() {
            .await
    // column we scoped out — which is hard to predict across every query shape
        if rg < matrix.len() {
        }
        let _g = lock_process_globals();
    #[tokio::test]
        let fo = footer_only(&bytes);
            vec![
        return None;
            &schema,
        );
                footer.file_metadata().key_value_metadata(),
/// `get_bytes(absolute_offset, len)`; we translate into the buffer.
        clear_scoped_cache_for_test();
            .sum();
        clear_scoped_cache_for_test();
}
    fn footer_only(bytes: &Bytes) -> Arc<ParquetMetaData> {
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
    /// same `(file, col)` parquet column, so they share the one CI cell — predicate
            .is_none());
        let extra: Vec<i32> = (1000..1032).collect();
        let schema = Arc::new(Schema::new(vec![
            .iter()
    if !missing_col_rg_matrix.is_empty() {
        clear_scoped_cache_for_test();
    /// With whole-region fetch on, the grafted index decodes IDENTICALLY to the
            "same column → one cell regardless of literal"
    #[tokio::test]
async fn get_or_build_column_index(
    /// Cell-keying makes OffsetIndex reuse automatic: an all-columns load caches
                Arc::new(Int32Array::from(prices)),
        );
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
        let _ = load_scoped_page_index_cols(&store_a, &loc_b, &fo, &cols, &[0, 1])
        assert_eq!(
        // 100..108,108..116,116..124,124..132). 1 RG, 4 pages each.
        assert!(fo.column_index().is_none());
                col,
    }
            out.push(CiCell {
            Arc::new(BinaryExpr::new(price_ge, Operator::And, qty_le));
    }
        let scoped = union_extent(&[fo.row_group(0).column(0).clone()], ci_extent).unwrap();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_price, &[])
/// One row group's decode unit: the scoped columns and their precomputed chunk
    }
}
            ph.offset as u64, col_start,
        let arm = ArrowReaderMetadata::try_new(Arc::clone(meta), ArrowReaderOptions::new())
            (o1.hits, o1.misses, o1.entries),
        let region = whole_index_region(footer_meta, extent)?;
        return None;
    let mut acc: Option<Range<u64>> = None;
            .await
        let rgm = footer_meta.row_group(rg);
            &["price".to_string()],
        assert_eq!((ci().hits, ci().misses), (1, 1));
        .collect();
        resolved.sort_unstable();
        assert!(load_scoped_page_index_cols(&store, &loc, &fo, &[], &[])
) -> Option<Vec<CiCell>> {
    /// The combined payoff across BOTH axes: a second query that adds a new
            ci().entries,
            .unwrap();
        assert_eq!(
    /// is a one-page non-panicking OffsetIndex placeholder with a `NONE`
        assert_eq!(
                base: *base,
        Some(proj_cols) => {
        assert_eq!(ci().misses, 1);
            .await
        // compressed_page_size is i32; clamp the (already-bounded) chunk length so a
        assert_eq!(s.as_ref().map(kept), Some(16));
            let size = rgm.column(col).column_index_length().unwrap_or(0).max(0) as usize;
        assert_eq!(
        );
            .await
};
            }
fn scatter_offset_column(matrix: &mut ParquetOffsetIndex, col: usize, column: &OiColumn) {
    /// Cells: predicate `price` → 1 CI cell `(col0,rg0)`; all-column OffsetIndex
    async fn col_scoping_reduces_offset_index_bytes() {
        );
        assert_eq!((ci().hits, ci().entries), (4, 4), "warm: all 4 cells hit");
    store: &Arc<dyn ObjectStore>,
        pair_a.sort_unstable();
        clear_scoped_cache_for_test, column_index_cache_stats, offset_index_cache_stats,
/// byte extents) and the decode (to pass to `read_*_indexes`), so `chunks` is
    )
        let full_vals = read_selected_column(&bytes, &full, 1, selection).unwrap();
            .unwrap();
    /// Evicting a file removes ALL its CI and OI cells from the caches —
    }
        let full = full_index(&bytes);
            .unwrap();
    use datafusion::parquet::arrow::ArrowWriter;
            assert_eq!(
            !o[0][1].page_locations().is_empty(),
        let (bytes, schema) = wide4_parquet(); // n0,n1,s0,s1 — 1 RG, multi-page columns
        single_b.sort_unstable();
        assert_eq!(
            &file_own_schema,
                Arc::new(Int32Array::from(extra)),
        let (bytes, schema) = two_col_parquet();
    // Fetch (wide whole-region on remote, narrow per-RG on local). Decode below is
            );
    // Same `cols` on every RG (read-time safety). Fetch, then decode scoped per RG.
fn graft(
    }
                Some(None)
    projection_cols: Option<&[usize]>,
/// ~403-col, ~64-RG footers) that deep copy was ~60ms/query; sharing makes the
async fn attach_scoped_page_index_to_metadata(
            .unwrap();
        assert_eq!(ci().hits, hits_before + 1, "MRU cell must remain cached");
    }
            Arc::clone(&schema),
        Arc::new(Literal::new(ScalarValue::Int32(Some(v))))
        assert_eq!(
            .unwrap();
        // Predicate now covers {price, qty}: price's cell hits, qty's cell misses.
            Field::new("n1", DataType::Int32, false),
    // ── Eviction on file deletion ─────────────────────────────────────────────
    }
    /// Second identical load is a pure hit in BOTH caches; no new cells/bytes.
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_both, &[])
        assert_eq!(
    // them in the matrix, and populate the cache.
        // Superset invariant: scoped must keep AT LEAST what full keeps (never
                Arc::new(Int32Array::from(n1)),
            (ci().hits, ci().misses, ci().entries),
 *
        let budget = one_cell + one_cell / 2;
        let _g = lock_process_globals();
            o[0][3].page_locations().len(),
    location: &object_store::path::Path,
    let mut out: Vec<CiCell> = Vec::with_capacity(col_rg_matrix.len());
            .unwrap();
                None => missing_col_rg_matrix.push((col, rg)),
    // (0, 0). When a row selection actually READS a placeholdered column (e.g. a
            (0, 2, 2),
        assert_eq!(ci().entries, 1, "only file_a's CI cell removed");
            matrix[rg][col] = entry;
    fn ci() -> ScopedCacheStats {
        assert_eq!(ci().hits, 1);
        let _g = lock_process_globals();
        assert!(
            Arc::clone(&list_field),
        None => (0..num_cols).collect(),
    /// resolver used the union-schema position, scoped the page index at the wrong
            .set_data_page_row_count_limit(1)
}
    use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
                set.insert(c);
        // bug (lost rows). `None` = "kept everything" (no pruning) = the maximal
        let (bytes, schema) = four_rg_parquet();
        .clone()
            .unwrap(),
            budget
    /// absolute start of the fetched buffer, so `start - base` gives the
        // always unions in {0}); other behavior unchanged.
        let mut single_a = resolve_predicate_parquet_columns(&schema, &fo, &names_a, &schema);
    location: &object_store::path::Path,
    /// The fork's `read_columns_indexes`/`read_offset_indexes` call `get_bytes`
    ParquetOffsetIndex,
    /// `range.end - range.start` then underflows ("subtract with overflow" in debug /
async fn build_column_index_cells(
        assert_eq!(scoped_vals, (116..132).collect::<Vec<i32>>());
            oi().used_bytes,
            .unwrap();
            build_pruning_predicate(&pred("price", 1, Operator::GtEq, 20), file_schema.clone())
    let path: Arc<str> = Arc::from(location.as_ref());
            .build();
    #[tokio::test]
            (ci().hits, ci().misses, ci().entries),
    footer_meta: &Arc<ParquetMetaData>,
        .map(|(rg, cols)| RgPlan::new(footer_meta, rg, cols))
        assert!(
    let num_rgs = footer_meta.num_row_groups();
        clear_scoped_cache_for_test();
use datafusion::scalar::ScalarValue;
        let selection = RowSelection::from(vec![RowSelector::skip(16), RowSelector::select(16)]);
    footer_meta: &Arc<ParquetMetaData>,
        acc = Some(merge(acc, extent(c)?));
    /// Translate an absolute file offset `start` to a buffer-relative index.
            &schema,
        super::super::evict_file_from_scoped_cache(loc.as_ref());
        assert!(c1.used_bytes > 0 && o1.used_bytes > 0);
    //            regardless of what the query projects or filters on.
        let fo = footer_only(&bytes);
            build_offset_index_columns(store, location, footer_meta, &missing, num_rgs).await?;
        let c_price =
        // The byte range a reader derives from this page must NOT underflow:
    /// correctly (same bytes as the full index), proving the shared whole-region
        let mut buf: Vec<u8> = Vec::new();
        if rg < matrix.len() {
            );
            .await
            resolve_predicate_parquet_columns(&schema, &fo, &["n1".to_string()], &schema);
#[cfg(test)]
/// == None` → all columns); see [`OiCellKey`] for why each must be real. Each
        assert_eq!((ci().hits, ci().misses), (0, 1));
        ]));
    use crate::indexed_table::page_pruner::{build_pruning_predicate, PagePruner};
            .set_statistics_enabled(EnabledStatistics::Page)
        for (k, entry) in decoded.into_iter().enumerate() {
    }
    async fn list_projection_resolves_to_its_parquet_leaf() {
        let fo = footer_only(&bytes);
        assert_eq!(scoped_vals, expected);
        clear_scoped_cache_for_test();
            "1 CI cell (price,rg0)"
        let (store, loc) = stage(bytes.clone()).await;
            .set_write_batch_size(32)
    }
    async fn projection_only_builds_offset_index_without_predicate() {
                bytes: bytes.clone(),
use super::{COLUMN_INDEX_CACHE, OFFSET_INDEX_CACHE};
}
        let (bytes, schema) = wide4_parquet(); // n0,n1,s0,s1 — 1 RG
    //            columns; projection-only queries get col 0 + projected columns.
        let c_price =
                "cell ({}, {}) out of matrix bounds ({num_rgs} rgs, {num_cols} cols)",
    // Resolve which columns need a real OffsetIndex:
    }
    // reader, our indexed pruner) index it by absolute column and dereference
    let mut missing: Vec<usize> = Vec::new();
        assert_eq!(oi().entries, 2, "OI: 2 cols (all cols) × 1 file");
}
    for &col in &off_cols {
            .set_statistics_enabled(EnabledStatistics::Page)
/// Consuming version of [`scatter_offset_column`] — used after inserting into
/// The fetched page-index bytes for a decode plan. The caller builds a transient
        set_whole_region_fetch_enabled(true);
impl BufferChunkReader {
            .unwrap();
    }
    store: &Arc<dyn ObjectStore>,
        "predicate_cols contains out-of-bounds index (num_cols={num_cols}): {predicate_cols:?}"
    async fn whole_region_fetch_matches_full_index_and_stays_scoped() {
            (o2.hits, o2.misses, o2.entries, o2.used_bytes),
            .await
        clear_scoped_cache_for_test();
    /// Narrow (local): one scoped buffer per plan entry, aligned to `plan` order.
    /// full miss that re-decoded `price`.)
        let (store, loc) = stage(bytes.clone()).await;
        });
    // Phase 2: decode the missing columns (each spanning all RGs), scatter into
        let full = full_index(&bytes);
//!
    rg: usize,
        ArrowReaderMetadata, ArrowReaderOptions, RowSelection, RowSelector,
        let (store, loc) = stage(bytes.clone()).await;
        );
    }
        assert_eq!(cols, vec![0]);
            .unwrap();
            .unwrap();
}
    /// cells. Project {s0} (offset cols n1∪s0∪{0}), then {s1} (offset cols
        w.write(&batch).unwrap();
        let (store, loc) = stage(bytes.clone()).await;
            ArrowReaderOptions::new().with_page_index(true),
        return Some(IndexBuffers::Shared {
        let (store, loc) = stage(bytes.clone()).await;
                cell.rg,
    use object_store::{ObjectStoreExt, PutPayload};
//! Page-index load entry points and their supporting internals.
    /// 4-RG file caches 4 cells (one per RG); a repeat query hits all 4.
            .with_row_groups(vec![0])
    #[tokio::test]
    data: ColumnIndexMetaData,
    /// fetched widen. `whole_index_region` is a superset of the scoped union, so the
        location,
            .await
        let (bytes, schema) = four_rg_parquet();
        let props = WriterProperties::builder()
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
            match COLUMN_INDEX_CACHE.get(&key) {
            .await
    // derives the fetch byte range from this page location. A (0, 0) page makes
use datafusion::physical_optimizer::pruning::{PruningPredicate, PruningStatistics};
    /// where `Bytes::clone` is a refcount bump, so this is cheap and short-lived.
        let (store, loc) = stage(bytes.clone()).await;
        // Scope the page index to `price` ONLY (mimics the predicate-scoped indexed
            (1, 2, 2),
        .unwrap();
            .unwrap();
            ci().used_bytes,
        return None;
            2,
            .unwrap();
    /// CI (all RGs) + OI column-scoped: both axes populated in one call.
        clear_scoped_cache_for_test();
    match acc {
async fn get_or_build_offset_index(
// ── OffsetIndex cache lookup + build (per `(file, col)` cell, all RGs) ───────
            (oi().hits, oi().misses, oi().entries),
        // CI: 4 RGs × 1 pred col = 4 cells; OI: {id(0), val(1)} × 1 file = 2 cells.
        let s_kept = PagePruner::new(&schema, Arc::clone(&aug), schema.clone())
        assert_eq!(
        );
pub async fn load_scoped_page_index_cols(
    location: &object_store::path::Path,
    }
}
            .unwrap();
        );
        column_index_cache_stats()
        clear_scoped_cache_for_test();
                Arc::new(StringArray::from(s1)),
        let fo = footer_only(&bytes);
    /// (`parquet_cols` empty) but DOES project columns (`offset_cols` non-empty).
            schema.clone(),
        let full_list_pages = full.offset_index().unwrap()[0][1].page_locations().len();
        );
            &union_schema,
        });
        }
    /// Page pruning over a column-scoped index must be a SAFE SUPERSET of the
                path: path.clone(),
            .await
    }
        let s = ci();
        let (store, loc) = stage(bytes.clone()).await;
    /// cells are SHARED. Both loads default to the all-column OffsetIndex, so the
        OFFSET_INDEX_CACHE.insert_batch(batch);
    store: &Arc<dyn ObjectStore>,
                "RG{rg} pruning matches full"
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        let c_price =
        );
///   fetched widen.
/// graft effectively free.
            1,
        let (bytes, _schema) = two_col_parquet(); // price=col0, qty=col1
        store,
        let fo = footer_only(&bytes);
        });
                    col: cell.col,
            .build();
    async fn fully_scoped_load_combines_both_axes() {
                real_pages,
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        assert!(ci().evictions >= 1, "the LRU cell must have evicted");
        clear_scoped_cache_for_test();
    #[tokio::test]
        assert_eq!(
        let fo = footer_only(&bytes);
        clear_scoped_cache_for_test();
        )
        .into_builder()
        )
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        assert_eq!(pred_cols, vec![1]);
    //
            .set_max_row_group_size(ROWS as usize)
        // Whole CI region is a strict superset of the scoped `id`-only union.
async fn fetch_index_buffers(
    col: usize,
        let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
            vec![
    #[tokio::test]
    let mut matrix: ParquetOffsetIndex = (0..num_rgs)
}
        let c_n0_n1 = resolve_predicate_parquet_columns(
    }
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        assert_eq!(oi().entries, 0);
        w.close().unwrap();
            schema.clone(),
                cell.size,
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[2])
        }
        let bytes = Bytes::from(buf);
        let list_field = Arc::new(Field::new("element", DataType::Utf8, true));
        let (bytes, schema) = two_col_parquet();
        assert_eq!(pair_a, single_a, "pair predicate result must match single");
use datafusion::parquet::arrow::arrow_reader::statistics::StatisticsConverter;
            resolve_predicate_parquet_columns(&schema, &fo, &["id".to_string()], &schema);
            .await
        clear_scoped_cache_for_test();
                Arc::new(Int32Array::from(n0)),
        let loc = ObjPath::from("data.parquet");
    cols: Vec<usize>,
            .unwrap();
        let builder = ParquetRecordBatchReaderBuilder::new_with_metadata(bytes.clone(), arm);
        const ROWS: i32 = 256;
        let _g = lock_process_globals();
) -> Arc<ParquetMetaData> {
    footer_meta: &Arc<ParquetMetaData>,
    // Nothing to build when both predicate_cols and projection_cols are empty/absent.
        .clone()
/// Fetch the page-index bytes for a decode plan. The single place the fetch strategy
                rg,
                "page-index read offset {start} precedes buffer base {}",
    let (ci_result, oi_result) = tokio::join!(
            matches!(c[0][1], ColumnIndexMetaData::NONE),
            .await
        // extras post-decode. A scoped result SMALLER than full would be the real
            &["price".to_string()],
    /// physical layout, the predicate must still resolve to the file's TRUE leaf
        let f = f_kept.unwrap_or(usize::MAX);
        let built =
                cell.rg < col_index_matrix.len() && cell.col < col_index_matrix[cell.rg].len(),
                acc = Some(merge(acc, r));
use std::mem;
            .set_max_row_group_size(32)
            &footer,
        let batch = RecordBatch::try_new(
                .downcast_ref::<Int32Array>()
    use datafusion::logical_expr::Operator;
        let batch = built.iter().map(|cell| {
        let rg = footer_meta.row_group(rg_idx);
            Field::new("price", DataType::Int32, false),
impl ChunkReader for BufferChunkReader {
        let pred_cols =
    for &(col, rg) in col_rg_matrix {
        );
/// the resolved offset columns; empty placeholders elsewhere) from per-`(file,
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[2])
        let c_qty = resolve_predicate_parquet_columns(&schema, &fo, &["qty".to_string()], &schema);
        // No predicate columns; project qty (col 1).
    /// narrow path: scoped pruning still matches the full index, and the decode is
 * The OpenSearch Contributors require contributions made to
/// an offset-index range (→ footer-only fallback).
            s >= f,
            &schema,
        // pathologically large column can't wrap the cast.
    if super::is_whole_region_fetch_enabled() {
        let f = PagePruner::new(&schema, full, schema.clone()).prune_rg(&pp, 0, None);
        );
        (Bytes::from(buf), schema)
        let (store, loc) = stage(bytes.clone()).await;
    let num_cols = footer_meta.file_metadata().schema_descr().num_columns();
        let (bytes, schema) = two_col_parquet();
        assert_eq!(ci().entries, 1, "only the most-recent cell fits");
fn oi_extent(c: &ColumnChunkMetaData) -> Option<Range<u64>> {
            col,
    use arrow::array::{Int32Array, RecordBatch};
    }
        // ...whose coordinates equal the real column chunk byte range from the footer.
        .unwrap();
            .await
        clear_scoped_cache_for_test();
    }
    };
        assert_eq!(
        assert_eq!(pair_a, vec![0]);
        });
        use arrow::array::StringArray;
 * SPDX-License-Identifier: Apache-2.0
        }
                set.insert(c);
        // Evict the file.
        // Scoped columns (predicate 1 ∪ projection 2 ∪ metric 0) carry the REAL
            full_list_pages > 1,
    /// Distinct predicate columns → distinct CI cells, but the OffsetIndex column
            (ci().misses, ci().entries),
    fn evolved_extra_price_parquet() -> Bytes {
    // ── Step 2: column-scoping the OffsetIndex ────────────────────────────
            (0, 3, 3),
        );
    use arrow::datatypes::{DataType, Field, Schema};
    );
    /// with absolute file offsets (from chunk metadata); `self.base` is the
        let mut writer = ArrowWriter::try_new(&mut buf, Arc::clone(&schema), Some(props)).unwrap();
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &c_qty, &[])
    Some(IndexBuffers::PerEntry(
        );
        assert_eq!(cols, vec![0]);
            bytes: buffers.first()?.clone(),
        );
        let loc_b = object_store::path::Path::from("file_b.parquet");
            2,
            let key = CiCellKey {
        .set_column_index(column_index)
            .unwrap();
            let f =
use std::sync::Arc;
    async fn col_scoping_full_coverage_collapses_to_all_columns_entry() {
        self.base + self.bytes.len() as u64
            Field::new("price", DataType::Int32, false),
    #[tokio::test]
        ]));
        (store, loc)
        );
        let (store, loc) = stage(bytes.clone()).await;
    /// (Bug: the load short-circuited on empty `parquet_cols`, skipping the
            oi().entries,
    let len = u64::try_from(c.column_index_length()?).ok()?;
            .unwrap();
            resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
            debug_assert!(
        .into_iter()
    Some(out)
            ],
    /// so the parquet reader fetches only matched-row pages, not whole chunks.
    if num_rgs == 0 {
    if num_rgs == 0 {
            col_index_matrix[cell.rg][cell.col] = cell.data;
    let buffers = store.get_ranges(location, &fetch_ranges).await.ok()?;
    async fn col_scoped_reads_projected_non_predicate_column() {
        let (store, location) = stage(bytes).await;
        assert_eq!(oi().entries, 2);
        let batch = RecordBatch::try_new(
        Some(projection_cols),
    }
            "n1 reused; s0 new"
        let loc_a = object_store::path::Path::from("file_a.parquet");
                "page-index read [{rel}..{}) exceeds buffer of len {}",
            "projected LIST leaf must use its real OffsetIndex, not a one-page placeholder"
    /// Byte-bounded LRU on the (now cell-keyed) ColumnIndex cache: with the budget
            .put(&loc_b, object_store::PutPayload::from_bytes(bytes.clone()))
        let fo = footer_only(&bytes);
            Field::new("extra", DataType::Int32, false),
        match OFFSET_INDEX_CACHE.get(&key) {
        // superset, also safe.
        let _g = lock_process_globals();
    }
    #[tokio::test]
        assert_eq!(scoped_vals, full_vals);
}
        )
        .metadata()
        ]));
            },
    // placeholder is always safe to dereference and makes pruning conservatively
    for (i, p) in plan.iter().enumerate() {
            2,
        assert_eq!((s.hits, s.misses, s.entries, s.evictions), (3, 2, 2, 0));
    #[tokio::test]
    /// The hazard this guards: with the page index scoped to `price` only, `qty`
    }
        let (store, loc) = stage(bytes.clone()).await;
    }
        let (store, loc) = stage(bytes.clone()).await;
            &schema,
    }
    fn full_index(bytes: &Bytes) -> Arc<ParquetMetaData> {
                ))
    let path: Arc<str> = Arc::from(location.as_ref());
            )
        // Decode stayed scoped: 4 RGs × 1 predicate col = 4 CI cells (not all columns).
        let cols = resolve_predicate_parquet_columns(
/// that clone is a refcount bump, not a deep copy of every row group's
    /// those cells hits them — no new entries, no special "collapse to all-columns
            Field::new("n0", DataType::Int32, false),
    /// 4 columns (2 int `n0`,`n1` + 2 wide string `s0`,`s1`), 1 RG, multiple pages.
            .set_data_page_row_count_limit(32)
            build_pruning_predicate(&pred("price", 0, Operator::GtEq, 20), schema.clone()).unwrap();
    /// CI hit/miss accounting across two predicate-column sets.
            resolve_predicate_parquet_columns(&schema, &fo, &["val".to_string()], &schema);
            (
        let o = aug.offset_index().unwrap();
        let (bytes, schema) = four_rg_parquet(); // id, v — 4 RGs, multi-page
        clear_scoped_cache_for_test();
/// path requires all requested columns to have an index, else footer-only fallback).
        store_a
    /// (like a schema-evolution-absent column) → it contributes "unknown" and
};
        let (mut pair_a, mut pair_b) =
            .row_groups()
                bytes: v[i].1.clone(),
        out.push(OiCell {
            &schema,
        }
        clear_scoped_cache_for_test();
        return None;
    }
        for rg in 0..4 {
/// col)` cells, decoding only the columns that miss.
            vec![
    // scoped columns get their real OffsetIndex scattered in afterward, overwriting
/// `(file, col)`, so it is decoded once per file and reused across every query
    // these placeholders.
        let mut single_b = resolve_predicate_parquet_columns(&schema, &fo, &names_b, &schema);
        let mut buf = Vec::new();
    #[tokio::test]
            None => missing.push(col),
            cols,
    /// second load re-reads the SAME 2 OI cells from cache (no new cells). This is
        assert_eq!(
        let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
    // Per-column accumulator: one OiColumn slot per requested col, filled RG by RG.
        assert_eq!(
    // panics those (`page_locations.last().unwrap()` etc.) if any path touches a
            .await
        );
        clear_scoped_cache_for_test();
        let fo = footer_only(&bytes);
        let scoped_vals = read_selected_column(&bytes, &aug, 1, selection.clone()).unwrap();
    }
                self.bytes.len()
        let rel = usize::try_from(rel)
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &pred_cols, &[1])
///   over the file's whole index region (all cols × all RGs; lenient — missing
        for cell in built {
            .map(|rg| rg.column(col).offset_index_length().unwrap_or(0).max(0) as usize)
}
        b.build()
    /// (so `price` is parquet leaf **1**), 32 rows / 4 pages. Used to prove the
            return Err(ParquetError::General(format!(
        let _g = lock_process_globals();
        // Deprecated but the only PUBLIC column-subset decoder (arrow-rs#8643).
        );
    }
            .set_write_batch_size(5)
        .unwrap()
    fn read_selected_column(
        let props = WriterProperties::builder()
    /// buffer resolves every scoped column's absolute offsets.
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
            .unwrap();
enum IndexBuffers {
    chunks: Vec<ColumnChunkMetaData>,
    num_rgs: usize,
        let (bytes, schema) = two_col_parquet();
    async fn different_projections_cache_only_new_offset_columns() {
    Shared { base: u64, bytes: Bytes },
            ci().hits,
        let _ = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
            ph.compressed_page_size as u64, col_len,
        // Reload — must be a miss, not a hit from stale cache.
        assert_eq!(
        w.write(&batch).unwrap();
            .unwrap();
        );
    use parquet::arrow::parquet_to_arrow_schema;
        let full = full_index(&bytes);
            .build();
            "predicate col has real CI"
            }
        let cols = resolve_predicate_parquet_columns(&schema, &fo, &["price".to_string()], &schema);
        let chunks = cols.iter().map(|&i| rgm.column(i).clone()).collect();
    }
        by_rg.entry(rg).or_default().push(col);
        Self { rg, cols, chunks }
/// Place a column's all-RG OffsetIndex (indexed by RG) into the matrix at `col`.
        let store_a: Arc<dyn object_store::ObjectStore> =
    attach_scoped_page_index_to_metadata(
            Field::new("qty", DataType::Int32, false),
                rel + length,
    /// that root. `StatisticsConverter::parquet_column_index()` deliberately
        set_column_index_cache_limit_for_test(budget);
/// `[base, base + bytes.len())`. The arrow-rs page-index readers call
        clear_scoped_cache_for_test();
            .unwrap(); // cell (col1) → evicts col0
        let pred_cols =
            set.into_iter().filter(|&c| c < num_cols).collect()
        // All 4 RGs built for the predicate column (id = col 0).
impl Length for BufferChunkReader {
    footer_meta: &Arc<ParquetMetaData>,
            2,
        single_a.sort_unstable();
        .unwrap();
    predicate_cols: &[usize],
        let real_pages = full.offset_index().unwrap()[0][0].page_locations().len();
        let c = aug.column_index().unwrap();
            "price cell reused (hit); only qty cell freshly decoded"
                s.as_ref().map(kept),
    let column_index = ci_result?;
        clear_scoped_cache_for_test();
    base: u64,
    /// Reader for the `i`-th plan entry. A `BufferChunkReader` is a `(u64, Bytes)`
        assert_eq!(
    fn col(name: &str, idx: usize) -> Arc<dyn PhysicalExpr> {
    /// 4 row groups of 10 rows (`id` 0..40, `v` = id*2), page size 5.
        let fo = footer_only(&bytes);
        let (c2, o2) = (ci(), oi());
        clear_scoped_cache_for_test();
    let off = u64::try_from(c.offset_index_offset()?).ok()?;
    /// sized to hold ~1.5 cells, loading two distinct column cells evicts the LRU
        (Bytes::from(buf), schema)
        assert!(!matches!(c[2][0], ColumnIndexMetaData::NONE), "RG2 real CI");
            return None;
        assert_eq!(scoped_vals, full_vals);
async fn build_offset_index_columns(
    debug_assert!(
                base: v[i].0,
        assert_eq!(ci().entries, 4, "4 RGs × 1 pred col");
                rg: p.rg,
            !o[0][0].page_locations().is_empty() && !o[0][1].page_locations().is_empty(),
    if off_cols.is_empty() {
    fn oi() -> ScopedCacheStats {
    }
                fo.file_metadata().schema_descr(),
    fn get_bytes(&self, start: u64, length: usize) -> ParquetResult<Bytes> {
                CiCellKey {
/// cloned from the footer exactly once.
            .await
    }
            .put(&loc_a, object_store::PutPayload::from_bytes(bytes.clone()))
    #[tokio::test]
        let region = whole_index_region(&fo, ci_extent).unwrap();
            .map_err(|e| format!("try_new metadata: {e}"))?;
        // THIS file `price` is physically leaf 1 (after `extra`).
            &schema,
/// any requested column lacks a column-index range (→ footer-only fallback).
        // not the (scoped) plan.
        assert_eq!(
    /// `page_pruner` fix treats a `NONE`-ColumnIndex column as "no usable stats"
        let scoped_vals = read_selected_column(&bytes, &aug, 1, selection.clone()).unwrap();
            (0, 1, 1),
            ci().entries,
/// is decided:
    store: &Arc<dyn ObjectStore>,
    let plan: Vec<RgPlan> = (0..num_rgs)
        let (bytes, schema) = wide4_parquet();
        for col in 0..num_cols {
        // OI: empty projection → all 2 columns × 1 file → 2 OI entries.
        async {
            "cols 0,1,2"
        Bytes::from(buf)
        assert_eq!((ci().hits, ci().misses), (1, 2));
    #[tokio::test]
    /// per-column cells, and a later column-scoped load whose set is covered by
        let (store, loc) = stage(bytes.clone()).await;
            &["n0".to_string(), "n1".to_string()],
    async fn empty_column_set_returns_none() {
    };
use datafusion::parquet::errors::{ParquetError, Result as ParquetResult};
            ],
            .await
    /// the whole point of cell-keying: a column's index is stored once per file.
        let full = full_index(&bytes);
    /// The placeholder page must span `[col_start, col_start + col_len)` so any range
            data: mem::take(&mut columns[k]),
        let fo = footer_only(&bytes);
            ci().entries,
    let base = ParquetMetaData::clone(footer_meta);
    #[tokio::test]
        let _g = lock_process_globals();
            all_cols
    offset_index: ParquetOffsetIndex,
    async fn evict_file_clears_all_cells_for_that_path() {
        clear_scoped_cache_for_test();
        resolve_predicate_parquet_columns, resolve_predicate_parquet_columns_pair,
 * compatible open source license.
        let fo = footer_only(&bytes);
            Field::new("s0", DataType::Utf8, false),
impl RgPlan {
        set_whole_region_fetch_enabled(false);
                Some(cell) => col_index_matrix[rg][col] = cell,
            f.as_ref().map(kept),
    let off_cols: Vec<usize> = match projection_cols {
    async fn lru_evicts_over_byte_budget() {
            .put(&loc, PutPayload::from_bytes(bytes))
struct CiCell {
    if predicate_cols.is_empty() && oi_proj.is_none() && projection_cols.is_some() {
        assert_eq!(
            region.start <= scoped.start && region.end >= scoped.end,
            .set_data_page_row_count_limit(5)
        )
            col,
    /// leaf, and the residual mis-pruned → over-count.
        store
            "4 RGs × col → 4 CI cells"
    let build_rgs: Vec<usize> = (0..num_rgs).collect();
        // {n0}: 1 new cell.
            .await
        // so any consumer dereference is safe — never empty, which would panic).
        assert_eq!(pair_b, single_b, "pair projection result must match single");
    }
    let buffers = fetch_index_buffers(store, location, footer_meta, &plan, oi_extent).await?;
        let _g = lock_process_globals();
        );
        let (col_start, col_len) = rg.column(col_idx).byte_range();
            aug.column_index().is_none(),
        let (bytes, _schema) = two_col_parquet();
        // Warm: all 4 cells hit, entry count unchanged.
        }
        assert!(real_pages > 1, "fixture should have multi-page columns");
        let hits_before = ci().hits;
        let (bytes, schema) = wide4_parquet(); // n0=0,n1=1,s0=2,s1=3 — 1 RG
    /// `(col, rg)` cells. Uses `wide4` (1 RG) for the column axis and asserts CI
        use datafusion::parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
    for (i, p) in plan.iter().enumerate() {
        );
            &bytes.clone(),
    location: &object_store::path::Path,
            (c1.hits, c1.misses, c1.entries),
            parquet::arrow::parquet_to_arrow_schema(
        ]));
        let _g = lock_process_globals();
            s.as_ref().map(kept),
        predicate_cols,
        assert!(fo.offset_index().is_none());
        Arc::new(BinaryExpr::new(col(name, idx), op, lit_int(v)))
            "no hits — eviction prevented serving stale data"
    // `page_locations` (`.last()`, `[0]`, `windows(2)`). An EMPTY placeholder
    /// the wrong invariant.
        assert_eq!(
        let size = i32::try_from(col_len).unwrap_or(i32::MAX);
    /// makes arrow derive a fetch byte range with `end < start` when a row selection
        let c_n1_s0 = resolve_predicate_parquet_columns(
    async fn second_load_is_cache_hit() {
        );
}
        let _g = lock_process_globals();
            .unwrap();
    // unlike the earlier (0, 0) placeholder it cannot be shared across columns. The
struct BufferChunkReader {
    crate::test_process_globals::assert_held("the scoped page-index caches");
            .unwrap();
            (2, 4, 4),
            .unwrap();
    // ── cache behavior: hits, independence, eviction ──────────────────────
        let mut buf: Vec<u8> = Vec::new();
        let key = OiCellKey {
    );
        let union_schema: SchemaRef = Arc::new(Schema::new(vec![
        clear_scoped_cache_for_test();
            if let Some(r) = extent(rgm.column(col)) {
        COLUMN_INDEX_CACHE.insert_batch(batch);
    fn pred(name: &str, idx: usize, op: Operator, v: i32) -> Arc<dyn PhysicalExpr> {
            "col 3 (scoped out) OI is a single-page placeholder, not real and not empty"
    };
        assert_eq!(ci().entries, 2, "one CI cell per file");
    col_rg_matrix: &[(usize, usize)],
    Some(col_index_matrix)
    fn len(&self) -> u64 {
            .await
}
        let aug = load_scoped_page_index_cols(&store, &loc, &fo, &cols, &[])
        let (store, loc) = stage(bytes.clone()).await;
/// Range-read + decode the OffsetIndex for each requested column across **every**
            .unwrap(); // cell (col0)
            "n0 reused; n1 new"
    Arc::new(rebuilt)
        }
type ChunkExtent = fn(&ColumnChunkMetaData) -> Option<Range<u64>>;
    /// 2 columns (`price`, `qty`), 32 rows, 1 row group, 4 pages of 8 rows.
        let selection = RowSelection::from(vec![RowSelector::skip(16), RowSelector::select(16)]);
    async fn stage(bytes: Bytes) -> (Arc<dyn ObjectStore>, ObjPath) {
}
    predicate_cols: &[usize],
use arrow::datatypes::SchemaRef;
        let (bytes, schema) = two_col_parquet();
        let fo = footer_only(&bytes);
            &fo,
            &fo,
        let mut resolved = resolve_predicate_parquet_columns(
        let _g = lock_process_globals();
        let (store, loc) = stage(bytes.clone()).await;
    }
            Field::new("qty", DataType::Int32, false),
            Arc::new(object_store::memory::InMemory::new());
            .map_err(|e| format!("build reader: {e}"))?;
    fn lit_int(v: i32) -> Arc<dyn PhysicalExpr> {
        let pp =
        assert_eq!(
            1,
            "col-scoped OI {} < all-col {}",
    /// one; the cache never exceeds its limit and never degrades to "cache
fn scatter_offset_column_owned(matrix: &mut ParquetOffsetIndex, col: usize, column: OiColumn) {
        ]));
use datafusion::parquet::file::page_index::column_index::ColumnIndexMetaData;
            .unwrap();
        .map(|rg| RgPlan::new(footer_meta, rg, cols.to_vec()))
        Ok(self.bytes.slice(rel..rel + length))
        clear_scoped_cache_for_test();
        .collect();
        }
    // Use insert_batch: all missing OI columns for this query in one lock acquisition.
    /// A projected nested Arrow field must resolve to every Parquet leaf under
            &["n1".to_string(), "s0".to_string()],
            .unwrap();
        if rel + length > self.bytes.len() {
        clear_scoped_cache_for_test();
    }
        // {n1,s0}: n1 hits, s0 new.
            Field::new("v", DataType::Int32, false),
    /// Wide (remote): every plan entry decodes from the ONE whole-region buffer.
        assert_eq!(oi().hits, 2);
    /// and scoped pruning must match the full-index pruning. Previously the
            .set_data_page_row_count_limit(8)
            .await
            "placeholder page size must be the real chunk compressed size (not 0)"
    let plan: Vec<RgPlan> = by_rg
    /// actually reads that column (e.g. `match() | sort | head`), and the read path's
    #[tokio::test]
    ///
