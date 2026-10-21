        let expr = bin(p, Operator::Or, q);
            seg_arrow_schema,
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
        assert_eq!(rc1.iter().sum::<usize>(), 32, "RG1 row count");
        // columns' page boundaries. Each grid cell is a row range that
        // both we can't produce page stats for pruning.
///
        let run = |op: Operator, v: i32| -> usize {
                if let Some(last) = col_locs.last() {
            // disable it for this test.
        }
            ArrowReaderOptions::new().with_page_index(true),
        let min_arr = match converter.row_group_mins(rg_metas.iter().copied()) {
        parquet_metadata: &ParquetMetaData,
            BoolNode::And(children) => {
        let converter = match StatisticsConverter::try_new(col.name(), arrow_schema, descr) {
//! `OR(a=5, b=10)` correctly prunes a page where `a` is entirely
            // directly. Rule:
        );
struct CommonGridPageStats {
                return None;
        // rg_can_match is 3 elements (one per chunk RG), relative indexing.
            RowSelector::skip(rc)
        // dynamic-mapping schema drift.
            &rg_indices,
            };
        w.close().unwrap();
    // a DIFFERENT real file column (`neg`, all-negative). The always-true `severity >= 0`
//! - Anything it can't translate becomes `Literal(true)`. Safe
        );
            .set_statistics_enabled(EnabledStatistics::Page)
    }
            .map(|w| (w[1] - w[0]) as usize)
                    };
        use datafusion::arrow::array::Int32Array;
    /// column with a populated page index — column 0 isn't guaranteed
    // 0. We test these for safety (no crash, consistent result); real
                        builder.append_value(cell_rc as u64);
    /// instead yield `[11111]` when wrapped in `DelegationPossible`.
            24,
        // Start the writer with RG0 props and flush after the first
//! `PruningPredicate` rewrites the full boolean tree homomorphically:
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        // Sanity: as a plain Predicate the same expr prunes to [00001].
    metadata: &ParquetMetaData,
            ArrowReaderOptions::new().with_page_index(true),
        // that contains it.
            ArrowReaderOptions::new().with_page_index(true),
        assert_eq!(count_rows_kept(&sel), 16, "2 pages × 8 rows");
            DataType::Int32,
        use datafusion::physical_expr::expressions::IsNotNullExpr;
        assert_eq!(
/// expression. Returns `None` for always-true predicates (nothing to
                    32,
            schema.clone(),
            vec![true, true, true, true, true]
        row_counts: rg_metas.iter().map(|m| m.num_rows()).collect(),
        );
    /// Verifies that `build_from_bool_node` works correctly when
                leaf_predicates.insert(key, pp);
        native_bridge_common::log_debug!(
                Self {
            &rg_indices,
            let col_locs = rg_offsets.get(*parquet_col_idx)?.page_locations();
        )
/// Use for the multi-filter tree path's whole residual subtree or for
            false,
            .set_write_batch_size(8)
        &self,
        // price = 5 → page 0 only (8 rows).
        let pos = rg_index_to_pos.get(&3).unwrap();
        // Convert grid-level keep/skip to row selection using grid cell row counts
        w.write(&batch).unwrap();
    fn in_list_prunes_via_or_of_eq() {
    RowSelection::from(out)
    // ─────────────────────────────────────────────────────────────────
            .set_data_page_size_limit(100)
        let rg_meta = self.metadata.row_groups().get(rg_idx)?;
        // May be always-true (no pruning possible) → None, or may prune
                        )
    // ─────────────────────────────────────────────────────────────────
        // schema misaligns StatisticsConverter's positional column lookup under
        let props = WriterProperties::builder()
struct RgLevelStats {
            )
            ArrowReaderMetadata::load(&tmp.reopen().unwrap(), ArrowReaderOptions::new()).unwrap();
//! Thin wrapper around DataFusion's [`PruningPredicate`] and a
/// Convert a per-page keep/skip decision + per-page row counts into a
        //   OR₁(AND[01100], p3[00001]) = [01101]
            expr
                    for (r, c) in rg_can_match.iter_mut().zip(child.rg_can_match.iter()) {
    /// Keyed by column name.
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
                    page_idx += 1;
            ArrowWriter::try_new(tmp.reopen().unwrap(), parquet_schema, Some(props)).unwrap();
    }
        // prices: 0..32 (pages: 0..8, 8..16, 16..24, 24..32)
    }
        let expr: Arc<dyn PhysicalExpr> = Arc::new(IsNotNullExpr::new(col("x", 0)));
    fn count_rows_kept(sel: &RowSelection) -> usize {
    /// Uses 5 RGs (price ranges [0..9],[10..19],[20..29],[30..39],[40..49])
        // `price > 100` is definitively false for all rows; every grid
                        c.add(1);
use datafusion::physical_expr::utils::collect_columns;
        assert_eq!(spt.rg_can_match[*pos], false);
    }
                }
        let predicate_schema = Arc::new(Schema::new(vec![
///       AND         df     AND     luc     df      df        NOT
    col_stats: HashMap<String, (ArrayRef, ArrayRef, Option<ArrayRef>)>,
///    df     df          df     df                           df
        seg_arrow_schema: &SchemaRef,
 * SPDX-License-Identifier: Apache-2.0
    /// rather than reusing one RG's layout for both.
        assert_eq!(
            Err(_) => continue,
        col_stats.insert(col.name().to_string(), (min_arr, max_arr, null_counts));
    /// (`price > 45`) that, as a plain `Predicate`, would prune to `[00001]` must
            &tmp.reopen().unwrap(),
        let rg_meta = parquet_metadata.row_groups().get(rg_idx)?;
}
                Self {
                // a document contains it as a token — an unsound over-prune. Defer entirely
                    children: vec![],
            ArrowReaderOptions::new().with_page_index(true),
        let props = WriterProperties::builder()
    ) -> Self {
                col_locs[1].first_row_index
//! itself is built once per query at [`build_pruning_predicate`].
    /// Nullable column with an all-null page. Verify that `IS NULL`
        let props_rg0 = WriterProperties::builder()
    }
        let spt = StatsPruneTree::build_from_bool_node(
/// Used for segment-level, RG-level, and subtree-level pruning.
        let pp = build_pruning_predicate(&expr, schema.clone()).unwrap();
            None => {}
        );
//! **multi-column** per-RG page-stats adapter. Replaces the previous
        let pp = build_pruning_predicate(&expr, schema).unwrap();
            bin(col("price", 0), Operator::Lt, lit_int(5)),
            };
    /// ```text
        // written yet" (schema evolution).
        )?;
        let props = WriterProperties::builder()
                    })
                // over the raw source string. Evaluating those stats here prunes RGs (and
        )
        // has 8,9 < 10, so both survive. 16 rows.
            col_stats.insert(col.name().to_string(), (grid_mins, grid_maxs, grid_nulls));
#[derive(Clone)]
        .collect();
        let meta = ArrowReaderMetadata::load(
        let schema = Arc::new(Schema::new(vec![Field::new(
            &self.metadata,
                    }
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
        // absent or had no page index), pruning can't do anything useful.
        // to `(pruned_by_price) AND unknown`, which PruningPredicate
            .map(|w| (w[1] - w[0]) as usize)
        )> = Vec::new();
        let batch2 = RecordBatch::try_new(
 * The OpenSearch Contributors require contributions made to
        let (pruner, schema, _) = two_col_fixture();
    fn stats_prune_tree_five_leaf_shape() {
    }
                }
///                /                  |                  \
    let mut col_stats: HashMap<String, (ArrayRef, ArrayRef, Option<ArrayRef>)> = HashMap::new();
            bin(col("qty", 1), Operator::Gt, lit_int(125)),
                    continue;
        assert_eq!(
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        // falls within a single page of every column.
        // Root
        .unwrap();
        // layout is read from its own offset index entry. Even if the
    pub pages_pruned: Option<datafusion::physical_plan::metrics::Count>,
        let tags: Vec<String> = (0..32)
        // RG0: 32 rows, 8-row pages → 4 pages.
                last.row_count += selector.row_count;
        .unwrap();
    let num = rg_indices.len();
//! homegrown per-filter range-intersection logic, which silently dropped
        // Verify consumer-side reverse map lookup works correctly:
        let offset_index = self.metadata.offset_index()?;
    }
        // price < 5. The `extra = 10` clause evaluates to unknown for
            .build();
/// [11100] [01111]    [11100] [00111]                     [11000]
        // by writing batch1 with 8-row batches and batch2 with 16-row
    }
    }
/// Precomputed tree of per-RG match vectors built from column statistics.
                        builder.append_null();
            };
        rg_idx: usize,
        assert_eq!(run(Operator::LtEq, 7), 8);
            "OR of unreachable ranges prunes everything"
        Self {
    }
    // ─────────────────────────────────────────────────────────────────
        // Left side keeps pages 0, 3; right side keeps page 3 (24..32).
    }
                grid_page_indices
        let meta =
}
        }
    }
                        .field_with_name(col.name())
                // Performance-delegated leaves are all-true, exactly like a Collector.
            .get(column.name())
            // Per-page row counts for this column (needed to know when a
    fn selection_merges_adjacent_same_decision_pages() {
///
        let arc_meta = meta.metadata().clone();
                    // IS NULL / IS NOT NULL also can't prune.
                None => {
            }
        let pruner = PagePruner::new(
    }
            vec![false, true, true, true, true]
    }
            BoolNode::Collector { .. } => {
        if col_converters.iter().all(|(_, c)| c.is_none()) {
    /// positional column resolution in statistics-based pruning.
            .set_statistics_enabled(EnabledStatistics::Page)
    /// predicate (wrapped as a [`PruningPredicate`]).
        //   OR₂(AND[00100], luc[11111], p6[11110]) = [11111]  ← luc dominates
/// `StreamMetrics` build one via [`PagePruneMetrics::from_stream_metrics`].
use std::collections::HashMap;
    }
        // mapping correctly carries min/max through cells created by
        let keep = match pruning_predicate.prune(&stats) {
        // prunable.
#[cfg(test)]
            Field::new("tag", DataType::Utf8, false),
        w.flush().unwrap();
        let num_grid_cells = boundaries.len() - 1;
        assert_eq!(
        pruning_predicate: &PruningPredicate,
///              OR                   OR                  AND
            spt.children[1].rg_can_match,
    /// 32-row parquet with two int columns, one RG, four data pages of 8
//! - `NOT(x)` → `NOT(rewrite(x))` (via its own rules).
        let tmp = NamedTempFile::new().unwrap();
                }
        let mut counts = Vec::with_capacity(col_offsets.len());
            }
            &arc_meta,
    use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
    fn multi_col_and_intersects_pages() {
        let column_index = parquet_metadata.column_index()?;
        .filter_map(|&idx| metadata.row_groups().get(idx))
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            original_expr: Arc::clone(&expr),
            None => { /* always_true — no pruning needed */ }
        // OR₁/AND/p2
                    .iter()
/// column. min/max for each column are inherited from the page containing
    /// - `None` — pruning isn't applicable (no page index on the RG,
        let pruner = PagePruner::new(&schema, meta.metadata().clone(), schema.clone());
    }
fn eval_leaf(
            .set_max_row_group_size(32)
            ArrowReaderMetadata::load(&tmp.reopen().unwrap(), ArrowReaderOptions::new()).unwrap();
impl CommonGridPageStats {
    if rg_metas.len() != num {
        )]));
        let oi = arc_meta.offset_index().expect("offset index");
        }
        // qty<110 keeps page 0 (100..108). Intersection is empty.
            &schema,
            bin(col("price", 0), Operator::Lt, lit_int(5)),
        )
        let right = bin(col("price", 0), Operator::Gt, lit_int(24));
        w.close().unwrap();
            }
        ]));
            &boundaries,
//! Page-level pruning using parquet page statistics.
                }
    #[test]
            .unwrap()
        use crate::indexed_table::bool_tree::BoolNode;
    }
            BoolNode::DelegationPossible { .. } => {
        let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), file_schema, None).unwrap();
        let expr = bin(col("price", 0), Operator::Gt, lit_int(50));
    /// Per-segment arrow schema derived from parquet footer, used for
    }
        let tmp = NamedTempFile::new().unwrap();
            //     `IS NOT NULL` stay correct on the split cell.
//! conjunct.
        assert_eq!(
            &tmp.reopen().unwrap(),
        // price > 50: RG0 (0..31) → nothing, RG1 (100..131) → all.
    fn always_true_predicate_yields_none() {
        let tmp = NamedTempFile::new().unwrap();
            .map(|(_, m, _)| Arc::clone(m))
        self.col_stats
        );
        // 32 rows, 4 pages of 8 rows each. Pages 0, 2, 3 have real
            &tmp.reopen().unwrap(),
            } else {
        // Helper: build a comparison, evaluate, return rows kept.
        num_grid_cells: usize,
        // batches so the effective page row count differs in each RG.
        w.close().unwrap();
        if arrow_schema.index_of(col.name()).is_err() {
        Ok(pp) => pp,
//!
        let prices: Vec<i32> = (0..32).collect();
        );
        // Note: `price >= 0` on a column with min=0 may collapse to
    }
                Arc::new(StringArray::from(tags_refs)),
                    .collect();
        let pp = build_pruning_predicate(&expr, schema).unwrap();
            0,
    use tempfile::NamedTempFile;
    fn multi_col_or_unions_pages() {
        let plain = StatsPruneTree::build_from_bool_node(
        return vec![];
        // price IN (-10, -20, -30) — nothing in RG matches, all pages
//! - `IN`, `LIKE`, `IS NULL`, etc. handled by `PruningPredicate`'s own
            //     back to the safe (non-pruning) branch, so `IS NULL` /
            vec![
            let batch =
        if let Some(m) = metrics {
        let expr: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Boolean(Some(true))));
        // IS NOT NULL: page 1 (all-null) should be pruned → 24 rows kept.
        let columns = collect_columns(pruning_predicate.orig_expr());
        }
        // count enforcement, which we exploit here.
        let batch =
        let p2 = pred_leaf("price", Operator::GtEq, 10, &schema); // [01111]
        w.close().unwrap();
        let pp = build_pruning_predicate(&expr, schema).unwrap();
    // Multi-RG: the pruner is stateless per RG; repeated calls on
    for (k, rc) in keep.into_iter().zip(row_counts.iter().copied()) {
        let mut w =
            Field::new("severity", DataType::Int32, false),
            "AND of disjoint page sets prunes everything"
                native_bridge_common::log_debug!("StatsPruneTree: NOT node → all-true (conservative, cannot prune through negation)");
                None => {
            .set_statistics_enabled(EnabledStatistics::Page)
    }
        Some(Arc::new(arr) as ArrayRef)
            &schema,
    pub pages_total: Option<datafusion::physical_plan::metrics::Count>,
    fn two_col_fixture() -> (PagePruner, SchemaRef, Arc<ParquetMetaData>) {
                    .iter()
            // Get the raw per-page stats for this column
                            c,
        )
                Arc::new(Int32Array::from(vec![0, 5, 10, 17])),
        num_rgs: num,
        // for all 4 pages). After merging, one run of `select(32)`.
                }
        assert_eq!(
}
        let list = vec![lit_int(-10), lit_int(-20), lit_int(-30)];
            Some(last) if last.skip == selector.skip => {
        }
    /// but other columns enabled). Used for metrics and cost estimation;
        // Pages 2, 3 skipped.
            }
                let pp = build_pruning_predicate(expr, schema.clone()).unwrap();
    fn null_counts(&self, column: &Column) -> Option<ArrayRef> {
        let tmp = NamedTempFile::new().unwrap();
            Some(pp) => {
            .and_then(|(_, _, n)| n.clone())
            file_schema.clone(),
            vec![true, true, true, true, true]
        // not just because the lookup missed).
    // Edge case coverage added for common grid correctness.
            .find(|locs| !locs.is_empty())?;
    // IS NULL / IS NOT NULL — DataFusion uses null-count stats.
            left, op, right,
    metadata: Arc<ParquetMetaData>,
            "price",
            .map(|arr| Arc::new(arr) as ArrayRef);
            native_bridge_common::log_debug!(
    /// layout. Verify the pruner reads each RG's own offset index
            .build();
        return None;
            count_rows_kept(&sel),
    // ─────────────────────────────────────────────────────────────────
        let (pruner, schema, _) = two_col_fixture();
        assert_eq!(count_rows_kept(&sel0), 0, "RG0 fully pruned");
        // so `build_from_bool_node` would find it (proving we skip it deliberately,
                if let Some(ref c) = m.page_pruning_unavailable {
        }
                boundary_set.insert(loc.first_row_index);
            .row_group_null_counts(rg_metas.iter().copied())
 * compatible open source license.
        // so page 1's min≮4 → pruned). 8 rows.
            .set_statistics_enabled(EnabledStatistics::Chunk)
            &datafusion::physical_expr::expressions::Column,
        let batch = RecordBatch::try_new(
            ]),
            let mut grid_page_indices = Vec::with_capacity(num_grid_cells);
            &leaf_predicates,
                        i64::MAX
            _ => out.push(selector),
    #[test]
        col_converters: &[(
        let pp = build_pruning_predicate(&expr, schema).unwrap();
                // Collectors have no column stats — always all-true.
        let batch1 = RecordBatch::try_new(
    pub children: Vec<StatsPruneTree>,
/// Per-row-group page pruner. Owns schema + metadata references; the
                let key = Arc::as_ptr(expr) as *const () as usize;
        // price NOT IN (-100, -200) — all pages match (nothing in RG is
        }
        assert_eq!(run_count(&sel), 4, "expected select/skip/select/skip");
            vec![false, false, false, true, true]
    /// keeps that page (null_count == row_count) and `IS NOT NULL`
        // AND(p1, p2) on subset → [T,T,F] & [F,T,T] = [F,T,F]
                    // Column is in Arrow schema but absent from the
            }
        assert!(spt.children.is_empty());
        let c = col("price", 0);
                }
        self.grid_row_counts.len()
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
    /// We verify that a single-column predicate on each column still
        _values: &std::collections::HashSet<ScalarValue>,
    ) -> Option<Self> {
                    rg_can_match,
        );
        let null_counts = converter
        boundary_set.insert(0i64);
        // `PruningPredicate` treats them as unknown (conservative) while
        use datafusion::arrow::array::Int32Array;
    }
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
                        // Mixed page split across multiple grid cells:
            .collect();
        let (pruner, schema, _) = two_col_fixture();
            "price",
        // Absolute RG 3 should map to position 1 → can_match = true
        use crate::indexed_table::bool_tree::BoolNode;
                    .unwrap();
//! # Correctness
                "PruningPredicate::try_new failed for {:?}: {}",
        ]));
    }
        let props = WriterProperties::builder()
            &schema,
                    } else {
                    "price >= 0 keeps every grid cell"
    // pruning would need a nullable-column fixture.
        // The `write_batch_size` acts as an upper bound on page row
        let (pruner, schema, _) = two_col_fixture();
    }
        assert_eq!(count_rows_kept(&sel), 16);
        Arc::new(PhysColumn::new(name, idx))
        .unwrap();
    fn misaligned_page_boundaries_prune_correctly() {
            .set_write_batch_size(8)
        };
        // Position 1 → absolute RG 3 (price [30..39]): p1=T, p2=T → AND=T
        schema: &SchemaRef,
            Field::new("price", DataType::Int32, false),
                for child in &annotated_children {
            .windows(2)
            Some(pp) => {
            .map(|(m, _, _)| Arc::clone(m))
        let (pruner, schema, _) = two_col_fixture();
/// Subtree vectors enable short-circuiting: for RG0, AND₃=[0....] so the
fn to_row_selection(keep: Vec<bool>, row_counts: &[usize]) -> RowSelection {
            &schema,
        let q_lt_110 = bin(col("qty", 1), Operator::Lt, lit_int(110));
            for &cell_start in boundaries.iter().take(num_grid_cells) {
                BoolNode::And(vec![p1.clone(), p2.clone()]),
        // OR₁/AND/p1
        use datafusion::arrow::array::StringArray;
        let expr = bin(
        use datafusion::physical_expr::expressions::IsNotNullExpr;
    fn min_values(&self, column: &Column) -> Option<ArrayRef> {
            .build();
            .collect();
        let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(v))));
            );
        let sel0 = pruner.prune_rg(&pp, 0, None).unwrap();
        let batch1 = RecordBatch::try_new(
    }
            .map(|i| format!("{}{}", i, "x".repeat(4000)))
        use datafusion::physical_expr::expressions::IsNullExpr;
        );
    }
            .map(|(_, m, _)| Arc::clone(m))
            continue;
    ///           [01101]              [11111]              [00011]
            &schema,
    use std::sync::Arc;
                // NOT is conservatively all-true: negating stats-based pruning is unsound
            "price",
                let mut builder = UInt64Array::builder(num_grid_cells);
                        .map(|f| f.data_type().clone())
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props_rg0)).unwrap();
        let mut w =
            &tmp.reopen().unwrap(),
        // so all pages get pruned.
            .set_max_row_group_size(10)
    ) -> Option<BooleanArray> {
        )
        let p5 = pred_leaf("price", Operator::GtEq, 20, &schema); // [00111]
                }
//!
            w.write(&batch).unwrap();
            .build();
    use super::*;
            "price",
                    col_converters.push((col, None));
        leaf_predicates.insert(key, build_pruning_predicate(&expr, schema.clone()).unwrap());
    fn run_count(sel: &RowSelection) -> usize {
    /// those stats here wrongly prunes RGs (and whole segments) whose string
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        use datafusion::arrow::datatypes::{DataType, Field, Schema};
//! outside `{5}` AND `b` is entirely outside `{10}`. The per-page stats
        }
            DataType::Int32,
/// Legend: `df` = Predicate leaf (parquet column stats), `luc` = Collector (always true).
        //   AND(p4[11100], p5[00111]) = [00100]
            // per-page arrays. `StatisticsConverter` already converts
use datafusion::arrow::datatypes::SchemaRef;
            .iter()
                for (cell_idx, &pidx) in grid_page_indices.iter().enumerate() {
    ) -> Arc<dyn PhysicalExpr> {
            Field::new("name", DataType::Int32, false),
    ) -> crate::indexed_table::bool_tree::BoolNode {
    #[test]
        // `Literal(true)` alone — becomes always-true after rewrite.
    /// The fix treats `DelegationPossible` as all-true, exactly like a Collector.
            .iter()
            &predicate_schema,
        let mut w =
    use datafusion::arrow::array::{Int32Array, RecordBatch};
            .set_statistics_enabled(EnabledStatistics::Page)
        let expr_false = bin(col("price", 0), Operator::Gt, lit_int(100));
            .clone();
        let expr = bin(col("price", 0), Operator::Lt, lit_int(4));
        )],
            vec![false, false, false, false, true],
            DataType::Int32,
            //   - page null_count == page_row_count → cell null_count = cell_row_count
                // Advance page_idx until this cell falls within the page
        schema: &SchemaRef,
        )]));
            DataType::Int32,
    /// fully-null page retains its IS-NOT-NULL pruning behaviour even
        // → every cell prunes → 0 rows. This verifies the grid-cell
            }
            .build();
    /// Verify the present column still prunes and the absent column
                RecordBatch::try_new(schema.clone(), vec![Arc::new(Int32Array::from(vals))])
                    // parquet file. Fill with null stats so this column
        boundary_set.insert(num_rows as i64);
    }
        assert_eq!(
        // very large values. A small page-size budget forces `tag`
                    let page_rc = page_row_counts.get(pidx).copied().unwrap_or(0);
            spt.children[0].children[0].children[0].rg_can_match,
                RecordBatch::try_new(schema.clone(), vec![Arc::new(Int32Array::from(vals))])
        let max_arr = match converter.row_group_maxes(rg_metas.iter().copied()) {
                        continue;
        ]));
        )
        // `price < 5 AND extra = 10`. Only page 0 (0..7) can contain
    let mut out: Vec<RowSelector> = Vec::with_capacity(keep.len());
            Field::new("neg", DataType::Int32, false),
    /// Returns:
        assert_eq!(run(Operator::NotEq, 5), 32);
    #[test]
    ///
        };
            vec![false, false, false, false, true]
        // two RGs end up with the same page counts, we still exercise
        // which doesn't exist in the parquet file.
            rg_idx,
    /// stores the raw source string with lexicographic min/max stats. Evaluating
            }
    /// We model this with an int column so the fixture stays simple: a predicate
                let mut rg_can_match = vec![true; num];
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        // runs: select/skip/select/skip.
            w.write(&batch).unwrap();
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
                        col_locs[page_idx + 1].first_row_index
    }
                Arc::new(Int32Array::from(vec![1, 2, 3, 4])),
        let batch2 = RecordBatch::try_new(
                collector,
        let mut w =
    #[test]
        let tree = BoolNode::And(vec![p1.clone(), p2.clone()]);
//! One `PruningPredicate::prune` call per RG. Internally evaluates the
            spt.rg_can_match,
        let pp = build_pruning_predicate(&expr, schema);
        assert_eq!(spt.children[0].children.len(), 2);
        assert_eq!(
            }
                }
        // `price` is Int32 (tiny bytes/value). `tag` is Utf8 with
//!   conservative fallback: can't prune → assume page matches.
        let expr = bin(left, Operator::And, right);
    /// Matches the tree from the doc comment on `StatsPruneTree`:
        let schema = Arc::new(Schema::new(vec![Field::new(
    fn max_values(&self, column: &Column) -> Option<ArrayRef> {
                }
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        // Position 0 → absolute RG 2 (price [20..29]): p1=T, p2=F → AND=F
                .ok()?;
                p6.clone(),
            false,
        w.write(&batch).unwrap();
        col_name: &str,
}
    seg_arrow_schema: SchemaRef,
 * this file be licensed under the Apache-2.0 license or a
        ]));
            ],
                md.file_metadata().key_value_metadata(),
            schema: schema.clone(),
        self.col_stats
        None
///   - OR₂(AND[00100], luc[11111], df[11110]) = [11111]  ← luc dominates
        // change writer props between flushes.
            Field::new("name", DataType::Int32, false),
                    metadata,
        let meta = ArrowReaderMetadata::load(
        // price < -1 OR qty > 999: neither can hold on any page.
        assert_eq!(count_rows_kept(&sel), 16);
        // Sanity check that the two columns have different page counts.
            false,
                    "StatsPruneTree: DelegationPossible node → all-true (peer-backend semantics, raw-string stats unsound)"
        // price < 5 OR qty > 125: price<5 keeps page 0 (0..8);
            "severity >= 0 is always true; eval_leaf must not prune under schema drift"
                grid_page_indices.push(page_idx);
        let sel0 = pruner.prune_rg(&pp, 0, None).unwrap();
            ],
            "price",
            &arc_meta,
) -> Option<Arc<PruningPredicate>> {
                Self {
            pages_total: sm.pages_total.clone(),
    expr: &Arc<dyn PhysicalExpr>,
        let arc_meta = meta.metadata().clone();
    grid_row_counts: Vec<usize>,
                            leaf_predicates,
                Arc::new(Int32Array::from(vec![-9, -8, -7, -6])),
            .get(column.name())
                Some(idx) => idx,
            schema.clone(),
            }
        let tmp = NamedTempFile::new().unwrap();
        // 5 RGs: price [0..9], [10..19], [20..29], [30..39], [40..49]
            vec![Arc::new(Int32Array::from((0..32).collect::<Vec<i32>>()))],
        op: Operator,
        let batch = RecordBatch::try_new(
        Ok(keep) => keep,
    #[test]
        // to flush frequently while `price` stays as one page.
            .build();
                }
        // Child 2: AND₃
        match pp {
        let pp = build_pruning_predicate(&expr, schema).unwrap();
                    children: annotated_children,
            // `take` propagates correctly.
        metadata: Arc<ParquetMetaData>,
use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
    fn eval_leaf_resolves_stats_against_segment_schema_under_drift() {
    /// `rg_indices` is a subset that doesn't start at 0 (e.g. chunk
        // price < 35 → full file would be [T,T,T,T,F]; subset [2,3,4] → [T,T,F]
            Operator::And,
        }
            count_rows_kept(&sel),
            let expr = bin(col("price", 0), op, lit_int(v));
                }
    }
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
    fn contained(
        let p_lt_5 = bin(col("price", 0), Operator::Lt, lit_int(5));
    fn col(name: &str, idx: usize) -> Arc<dyn PhysicalExpr> {
        let props = WriterProperties::builder()
    Some(Arc::new(pruning_predicate))
            vec![true, true, true, false, false]
                        // unknown so `PruningPredicate` stays conservative.
            // part of a page, the page's null count can't be attributed
    /// Per-RG: `false` means this subtree provably can't match that RG.
        // price > -1: every page qualifies (`price_min < -1` is false
    // different RGs of the same metadata handle each correctly.
        for i in 0..5i32 {
        Arc::new(Literal::new(ScalarValue::Int32(Some(v))))
        w.write(&batch).unwrap();
///
            BoolNode::Predicate(expr) => {
                Self {
        let mut w =
                        builder.append_null();
/// than falsely pruning. This means a stats extraction failure, missing column,
        let expr =
    ///                                  AND
/// Build an [`PruningPredicate`] from an arbitrary physical boolean
        }
        w.write(&batch2).unwrap();
            "DelegationPossible must be all-true (peer-backend semantics)"
    /// page layout is independent; the common grid unions the boundaries.
        let price_pages = oi[0][0].page_locations().len();
        let expr_true = bin(col("price", 0), Operator::GtEq, lit_int(0));
                    .collect();
        let meta = ArrowReaderMetadata::load(
    ///    df     df          df     df                           df
                    // see type-compatible nulls (treated as "unknown"
pub struct PagePruneMetrics {
        // Arrow schema handed to the pruner includes both columns —
    /// Count the number of selector runs in the selection — useful to
        use crate::indexed_table::bool_tree::BoolNode;
    }
        let pruner = PagePruner::new(&schema, meta.metadata().clone(), schema.clone());
            spt.children[2].children[1].children[0].rg_can_match,
    }
        let num_rows = rg_meta.num_rows() as usize;
                    rg_can_match: vec![true; num],
            let grid_maxs = take(&maxs, &indices, None).ok()?;
        let offset_index = self.metadata.offset_index()?;
        boundaries: &[i64],
        // AND₃/NOT → always true
//! - `OR(x, y)` → `OR(rewrite(x), rewrite(y))`.
        let props = WriterProperties::builder()
        &self,
        let p4 = pred_leaf("price", Operator::Lt, 25, &schema); // [11100]
                    }
    ///                /                  |                  \
    pub fn build_from_bool_node(
        assert_eq!(run_count(&sel), 1, "single skip run covers the whole RG");
        // Actually: page 0 (0..7) certainly has < 10, page 1 (8..15)
    // ─────────────────────────────────────────────────────────────────
            //   - page null_count == 0        → cell null_count = 0
/// simply not be skipped.
    #[test]
        .unwrap();
    }
            &tree,
        }
        assert_eq!(arc_meta.num_row_groups(), 5);
}
            BoolNode::Or(vec![
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
                RecordBatch::try_new(schema.clone(), vec![Arc::new(Int32Array::from(vals))])
    }
        assert_eq!(
            .map(|(pos, &idx)| (idx, pos))
        return vec![true; num];
        r: Arc<dyn PhysicalExpr>,
        assert_eq!(count_rows_kept(&sel), 0);
        // Fixture columns are non-nullable; IS NULL can never be true,
            .set_data_page_row_count_limit(8)
            let converter = match StatisticsConverter::try_new(col.name(), &seg_arrow_schema, descr)
        // Build the pruning predicate under the SAME Arc identity used by the tree,
                            schema,
        for pair in col_offsets.windows(2) {
    fn single_col_eq_prunes_to_overlapping_page() {
            col_converters.push((col, Some((converter, parquet_col_idx))));
    #[test]
        w.flush().unwrap();
            };
                    col_stats.insert(col.name().to_string(), (mins, maxs, None));
        .unwrap();
    ///      /   \              /   \                              |
}
            .collect();
            tag_pages
    #[test]
    /// ```
        assert_eq!(run(Operator::Lt, 10), 16);
///
        let q = bin(col("qty", 1), Operator::Gt, lit_int(999));
//!
/// # Example: 5 RGs, 9 leaves
        );
        assert_eq!(
            metadata,
            Field::new("price", DataType::Int32, false),
        let list = vec![lit_int(5), lit_int(15)];
                    col_converters.push((col, None));
        )
    ///       AND         df     AND     luc     df      df        NOT
        assert_eq!(rc0.iter().sum::<usize>(), 32, "RG0 row count");
        );
    ///                                [00001]
        };
                        Self::build_from_bool_node(
        counts.push(num_rows - col_offsets.last()?.first_row_index as usize);
                    // Column not present in the parquet file. Provide
                }
    }
            price_pages,
    /// boundaries contributed by the *other* column.
        v: i32,
        // Verify bottom-up:
    for col in &columns {
        let vals: Vec<Option<i32>> = (0..32)
    ///
            &schema,
    }
    fn bin(
                        )
        let pos = rg_index_to_pos.get(&2).unwrap();
        .unwrap();
    }
        );
                let annotated_children: Vec<_> = children
            .enumerate()
        rg_idx: usize,
        assert_eq!(run(Operator::Eq, 5), 8);
            .map(|i| if (8..16).contains(&i) { None } else { Some(i) })
                    child,
        //   Root AND(OR₁[01101], OR₂[11111], AND₃[00011]) = [00001]
            let vals: Vec<i32> = (i * 10..(i + 1) * 10).collect();
            .collect();
        let left = bin(
        if num_grid_cells == 0 {
            .set_data_page_row_count_limit(8)
        let c = col("price", 0);
        let mut boundary_set = std::collections::BTreeSet::new();
        // RG1: 32 rows, 16-row pages → 2 pages.
    }
        .unwrap();
                native_bridge_common::log_debug!("page pruning error for rg {}: {}", rg_idx, e);
            let maxs = converter
            {
        let rg_offsets = offset_index.get(rg_idx)?;
    /// prunes correctly despite the union grid containing extra cell
                    rg_can_match,
        let md = ArrowReaderMetadata::load(&tmp.reopen().unwrap(), ArrowReaderOptions::new())
        let pruner = PagePruner::new(&schema, Arc::clone(&arc_meta), schema.clone());
            Ok(arr) => arr,
        assert_eq!(count_rows_kept(&sel), 8);
        // If no referenced column contributed real page boundaries (all
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
            }
        let expr = bin(col("severity", 1), Operator::GtEq, lit_int(0));
        assert_eq!(meta.metadata().num_row_groups(), 2);
                    if pidx >= page_ncs.len() || page_ncs.is_null(pidx) {
            //     `PruningPredicate` treats a null as "unknown" and falls
        )
        None
            col_stats,
            BoolNode::Or(vec![
        };
        let expr = bin(col("price", 0), Operator::Eq, lit_int(5));
        w.write(&batch).unwrap();
//! - `a = v` → `a_min ≤ v AND a_max ≥ v` (page could contain `v`).
        w.write(&batch2).unwrap();
            .set_max_row_group_size(10)
            BoolNode::Or(children) => {
        let pp = build_pruning_predicate(&expr_true, schema);
            eval_leaf(&pp, &md, &table_schema, &[0], &file_arrow_schema),
            RecordBatch::try_new(schema.clone(), vec![Arc::new(Int32Array::from(vals))]).unwrap();
            // Null count splitting: a page's `null_count` applies to the
#[derive(Default, Clone)]
                    continue;
        let (_, schema, _) = two_col_fixture();
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        // Leaf predicates and their expected rg_can_match bitsets:
    // we cover it here for future callers and as a regression fence.
            vec![true, true, false, false, false]
            let batch =
//! each array is read once per column per predicate. `PruningPredicate`
            Field::new("neg", DataType::Int32, false),
///                                  AND
    /// [11100] [01111]    [11100] [00111]                     [11000]
        let expr = bin(p_gt_20, Operator::And, q_lt_110);
    fn max_values(&self, column: &Column) -> Option<ArrayRef> {
    num_rgs: usize,
        // Intersection: page 3 only → 8 rows.
        let qtys: Vec<i32> = (100..132).collect();
        for col in &columns {
        )))
            let parquet_col_idx = match converter.parquet_column_index() {
        let p2 = pred_leaf("price", Operator::GtEq, 30, &schema);
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
    }
        self.col_stats
                    .map(|c| {
            vec![true],
        // < 0), so every page kept.
    /// bounds exclude the term even though a document contains it as a token.
        // always-true at predicate-construction time.
        let collector = BoolNode::Collector { annotation_id: 0 };
        .iter()
            Operator::Or,
        //
        w.close().unwrap();
            vec![
                use datafusion::arrow::array::UInt64Array;
        let rg_indices: Vec<usize> = (0..5).collect();
                Self {
                    c.add(1);
                while page_idx + 1 < col_locs.len() && cell_start >= next_page_start {
            .set_statistics_enabled(EnabledStatistics::Chunk)
                    children: annotated_children,
    fn selection_empty_when_no_page_survives() {
                    } else {
        use super::bool_tree::BoolNode;
            bin(col("extra", 1), Operator::Eq, lit_int(10)),
        // For RG1, write in a single larger batch so it hits a bigger
        // Chunk only has RGs [2, 3, 4] (prices [20..49])
        );
            plain.rg_can_match,
        assert!(
        let pruner = PagePruner::new(&schema, meta.metadata().clone(), schema.clone());
    }
    if num == 0 {
        use datafusion::arrow::array::Int32Array;
        // Absolute RG 0 (not in chunk) should have no entry
        // page layout. We can't truly swap writer properties mid-file
        // rg_offsets.get(1), not the first RG.
        //   AND₃(p7[00011], NOT[11111]) = [00011]
            vec![false, true, true, false, false]
        self.col_stats
        ]));
        let selector = if k {
            let col_locs = match rg_offsets.get(parquet_col_idx) {
        // price > 24 → page 3 (24..31, max 31 > 24). 8 rows.
                    })
        assert_eq!(count_rows_kept(&sel), 8);
    fn null_counts(&self, column: &Column) -> Option<ArrayRef> {
///   - AND₃(df[00011], NOT[11111]) = [00011]
        let rg_meta = self.metadata.row_groups().get(rg_idx)?;
        }
        //   AND(p1[11100], p2[01111]) = [01100]
        let key = Arc::as_ptr(&expr) as *const () as usize;
                // equality is a *token* match, but parquet column stats are lexicographic
        let p8 = pred_leaf("price", Operator::Lt, 15, &schema); // [11000]
            &datafusion::physical_expr::expressions::Column,
            &tmp.reopen().unwrap(),
        let rg_indices: Vec<usize> = (0..5).collect();
        }
        // A predicate that's structurally unusable for pruning — e.g.,
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        // (price < 5 OR qty > 125) AND price > 24
                    let maxs = datafusion::arrow::array::new_null_array(&data_type, num_grid_cells);
    fn min_values(&self, column: &Column) -> Option<ArrayRef> {
            count_rows_kept(&sel),
    // Requires a schema with nullable columns to emit useful pruning.
    }
        assert_eq!(spt.children[2].children.len(), 2);
use datafusion::physical_optimizer::pruning::{PruningPredicate, PruningStatistics};
        metrics: Option<&PagePruneMetrics>,
        let props = WriterProperties::builder()
        // The underlying expr: `price > 45` → prunes to [00001] as a plain Predicate.
            count_rows_kept(&sel)
    if col_stats.is_empty() {
    }
/// Page statistics aligned to a common grid across all referenced columns.
            &arc_meta,
    fn selection_alternating_pages_keeps_run_granularity() {
        let num_rows = rg_meta.num_rows() as usize;
        // cell keeps → 32 rows. Same shape, opposite outcome.
                // because stats give a superset, and inverting a superset is a subset.
                Ok(c) => c,
    /// when split across grid cells.
    fn nullable_all_null_page_prunes_is_not_null() {
        let sel1 = pruner.prune_rg(&pp, 1, None).unwrap();
                BoolNode::And(vec![p4.clone(), p5.clone()]),
                    for (r, c) in rg_can_match.iter_mut().zip(child.rg_can_match.iter()) {
impl PruningStatistics for RgLevelStats {
    // schema drift) — yielding null stats that prune RGs that actually match.
        crate::indexed_table::bool_tree::BoolNode::Predicate(Arc::new(BinaryExpr::new(
        w.close().unwrap();
            // Extreme byte budget forces a page flush after nearly
            let vals: Vec<i32> = (i * 10..(i + 1) * 10).collect();
        let expr = bin(p_lt_5, Operator::Or, q_gt_125);
    #[test]
        // As a DelegationPossible leaf, the same expr must NOT prune.
        match pp {
            &rg_indices,
    }
        let mut w =
        } else {
        assert_eq!(
    // ─────────────────────────────────────────────────────────────────
        // still allowing other columns to prune.
        let pp = build_pruning_predicate(&expr, schema).unwrap();
            .build();
                    rg_can_match,
        Arc::new(BinaryExpr::new(l, op, r))
        sel.iter().count()
    }
                    children: vec![annotated_child],
        let pp = build_pruning_predicate(&expr_false, schema.clone()).unwrap();
///
///           [01101]              [11111]              [00011]
        let pp = build_pruning_predicate(&expr, predicate_schema).unwrap();
            vec![true, true, true, true, true],
        let mut col_stats = HashMap::new();
        // with the same `PagePruner`.
//! - `AND(x, y)` → `AND(rewrite(x), rewrite(y))`.
            predicate_schema.clone(),
/// Each grid cell is a row range that falls within a single page of every
                    v.push(num_rows - last.first_row_index as usize);
            BoolNode::Not(child) => {
            &schema,
        // every cell (absent column → all-null stats), so AND collapses
    /// Motivation: for analyzed text/match_only_text fields, `field = 'laptop'`
        assert_eq!(spt.rg_can_match, vec![false, true, false]);
                };
        // For each column, build min/max/null_count arrays aligned to
        let grid_row_counts: Vec<usize> = boundaries
                None => {
                    next_page_start = if page_idx + 1 < col_locs.len() {
///     [01100]    [00001] [00100] [11111] [11110] [00011]   [11111]
        // Prune `price < 4` against each RG independently. RG0
                c.add(keep.len());
            }
    #[test]
            count_rows_kept(&sel),
        let (pruner, schema, _) = two_col_fixture();
            annotation_id: 7,
                c.add(pruned);
                let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        ]);
            let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        let expr: Arc<dyn PhysicalExpr> = Arc::new(IsNotNullExpr::new(col("price", 0)));
                Self {
        return vec![true; num];
    // parquet file, so resolving `severity` positionally against the table schema lands on
            Field::new("severity", DataType::Int32, false),
    fn num_containers(&self) -> usize {
                if let Some(m) = metrics {
    #[test]
    // but `build_pruning_predicate` accepts arbitrary PhysicalExprs, so
#[cfg(test)]
        use datafusion::physical_expr::expressions::IsNullExpr;
            vec![false, true, true, false, true]
            "fixture must produce misaligned per-column page layouts; got price={} tag={}",
        assert!(rg_index_to_pos.get(&0).is_none());
        seg_arrow_schema: SchemaRef,
    }
    // no column when the segment's schema is narrower or reordered (dynamic-mapping
//!
        // price IN (5, 20) — picks pages 0 (contains 5) and 2 (contains
        let tmp = NamedTempFile::new().unwrap();
    /// contributes "unknown" stats without disabling pruning for the RG.
        let mut w =
        assert_eq!(count_rows_kept(&sel1), 32, "RG1 fully kept");
/// stats-based pruning is unsound (superset inverted = subset).
/// Per-call counter bundle for [`PagePruner::prune_rg`]. Callers with
impl PruningStatistics for CommonGridPageStats {
        // treats as "can't prove false" → keeps the page (conservative).
            Arc::new(Literal::new(ScalarValue::Int32(Some(45)))),
                p3.clone(),
        };
            }
        // false regardless of `extra`, so those pages are still pruned.
            vec![Arc::new(Int32Array::from((100..132).collect::<Vec<i32>>()))],
            Ok(c) => c,
        // count is file-wide. Simulate "different per-RG page layouts"
        let (pruner, schema, _) = two_col_fixture();
        (pruner, schema, arc_meta)
            let pruned = keep.iter().filter(|k| !**k).count();
            ArrowReaderOptions::new().with_page_index(true),
            "IS NOT NULL must prune the all-null page"
        .unwrap();
        Err(e) => {
                );
            );
            RowSelector::select(rc)
        let tmp = NamedTempFile::new().unwrap();
        // ArrowWriter doesn't support mid-file prop changes; page row
        let descr = self.metadata.file_metadata().schema_descr();
        let expr =
                let annotated_children: Vec<_> = children
        w.close().unwrap();
        }
                Err(_) => {
            .get(column.name())
                Arc::new(builder.finish()) as ArrayRef
    fn in_list_empty_match_prunes_everything() {
        let pruner = PagePruner::new(&schema, Arc::clone(&arc_meta), schema.clone());
        // the parquet file (schema evolution) contribute no boundaries —
    /// absolute RGs 2,3,4. Consumers use a reverse map to translate.
    if pruning_predicate.always_true() {
        let mut leaf_predicates: HashMap<usize, Arc<PruningPredicate>> = HashMap::new();
                    children: vec![],
            spt.children[2].children[0].rg_can_match,
            //     (all values are null → every sub-cell is all-null)
            .set_data_page_row_count_limit(32)
                    .collect::<Vec<_>>(),
        assert_eq!(
            .map(|(m, _, _)| Arc::clone(m))
    /// prunes it. With the common-grid null-count splitting fix, a
        // price IN (5, 15). price=5 → page 0, price=15 → page 1.
            schema.clone(),
        let batch = RecordBatch::try_new(
            }
                let rg_can_match = match leaf_predicates.get(&key) {
    col_stats: HashMap<String, (ArrayRef, ArrayRef, Option<ArrayRef>)>,
            vec![Arc::new(Int32Array::from((0..32).collect::<Vec<i32>>()))],
            .set_max_row_group_size(32)
        let boundaries: Vec<i64> = boundary_set.into_iter().collect();
    /// verify `to_row_selection` merges adjacent same-decision pages.
            false,
                    if page_nc == 0 {
        if columns.is_empty() {
            vec![false, false, false, true, true]
/// Returns a `Vec<bool>` aligned to `rg_indices`.
    /// contains RGs [2,3,4] out of a 5-RG file). The `rg_can_match`
        let expr: Arc<dyn PhysicalExpr> = Arc::new(IsNullExpr::new(col("price", 0)));
        arrow_schema: &SchemaRef,
            &self.schema,
        let seg_arrow_schema = Arc::clone(&self.seg_arrow_schema);
            ],
                    let mins = datafusion::arrow::array::new_null_array(&data_type, num_grid_cells);
    /// Columns with misaligned per-column page boundaries. Each column's
        );
    // Resolve stats against the segment's OWN parquet schema, not the full table
        assert_eq!(count_rows_kept(&sel), 0);
        for node in [&p1, &p2, &p3, &p4, &p5, &p6, &p7, &p8] {
        // Verify page_row_counts returns a valid layout for each RG.
        }
        );
        assert_eq!(count_rows_kept(&sel), 0);
            Field::new("extra", DataType::Int32, true),
            };
                    Some(pp) => eval_leaf(pp, metadata, schema, rg_indices, seg_arrow_schema),
        assert_eq!(
        return vec![true; num];
            .set_max_row_group_size(32)
        let schema = Arc::new(Schema::new(vec![Field::new("x", DataType::Int32, true)]));
                .data_page_mins(column_index, offset_index, [&rg_idx])
    /// - `Some(selection)` — per-page keep/skip over the RG. An empty
        let rg_indices: Vec<usize> = vec![2, 3, 4];
///                                [00001]
            spt.children[0].rg_can_match,
        assert_eq!(run(Operator::GtEq, 24), 8);
    let seg_arrow_schema = Arc::clone(seg_arrow_schema);
        }
        );
        let arr = Int64Array::from_iter_values(self.grid_row_counts.iter().map(|c| *c as i64));
use datafusion::parquet::arrow::arrow_reader::statistics::StatisticsConverter;
//!   rewriters.
                            seg_arrow_schema,
        let tmp = NamedTempFile::new().unwrap();
    let arrow_schema = seg_arrow_schema.as_ref();
/// merged.
            let vals: Vec<i32> = (i * 10..(i + 1) * 10).collect();
        // Build a common page grid from the union of all referenced
        assert!(pp.is_none());
        use datafusion::arrow::array::{Int32Array, RecordBatch};
                Arc::new(Int32Array::from(qtys)),
                    let cell_rc = grid_row_counts[cell_idx];
            "IS NULL must keep the all-null page and prune the others"
}
                    v.push((pair[1].first_row_index - pair[0].first_row_index) as usize);
                assert_eq!(
        let c = col("price", 0);
        let pp = build_pruning_predicate(&expr, schema).unwrap();
                    }
                            rg_indices,
    // All six comparison operators, to pin down the supported surface.
        _column: &Column,
/// Evaluate a single predicate against RG-level column stats for the given RGs.
        let meta = ArrowReaderMetadata::load(
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        let expr =
        )]));
impl StatsPruneTree {
        let (pruner, schema, _) = two_col_fixture();
            "price > 100 must prune the entire RG regardless of tag layout"
        let batch = RecordBatch::try_new(
        // File has only `price`. The predicate also references `extra`,
        .unwrap();
                );
        };
///          /       \          /     |     \          /       \
                .data_page_maxes(column_index, offset_index, [&rg_idx])
        w.write(&batch1).unwrap();
            .set_write_batch_size(8)
//! # Per-RG cost
                    children: vec![],
            let pp = build_pruning_predicate(&expr, schema.clone()).unwrap();
        let rc0 = pruner.page_row_counts(0).unwrap();
    schema: SchemaRef,
}
        // OR₁/p3
    ) -> Self {
        // this simulates "predicate knows about a column we haven't
                }
        assert_eq!(spt.rg_can_match[*pos], true);
        let num = rg_indices.len();
///   - AND(df[11100], df[01111]) = [01100]
}
    // ─────────────────────────────────────────────────────────────────
        );
                Some(oi) => oi.page_locations(),
        // The easiest way to get different per-RG page layouts is to
        schema: &SchemaRef,
    // Schema drift: the table schema orders columns differently from the segment's own
            &tmp.reopen().unwrap(),
pub struct PagePruner {
        // qtys:   100..132 (pages: 100..108, 108..116, 116..124, 124..132)
    #[test]
        // values != 5). 32 rows.
    #[test]
        );
    pub fn from_stream_metrics(sm: &crate::indexed_table::metrics::StreamMetrics) -> Self {
}
    #[test]
        // to keep everything → Some with 32 rows. Both are correct.
    ///
            8,
        Err(_) => vec![true; num],
        _values: &std::collections::HashSet<ScalarValue>,
        rg_indices: &[usize],
                Arc::new(Int32Array::from(prices)),
            false,
            parquet_schema.clone(),
    #[test]
        );
        let mut w =
    ) -> Option<BooleanArray> {
                let mut rg_can_match = vec![false; num];
                    None => vec![true; num],
            .set_dictionary_enabled(false)
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        )
        let prices: Vec<i32> = (0..32).collect();
            // replicate that page's stats to the grid cell.
    }
    #[test]
        let rg_offsets = offset_index.get(rg_idx)?;
        Some(Arc::new(arr) as ArrayRef)
        for node in [&p1, &p2] {
        assert_eq!(count_rows_kept(&sel), 32);
        let parquet_schema = Arc::new(Schema::new(vec![Field::new(
    ///   evaluation error, etc.). Caller treats as "scan the whole RG."
        )
                        // in any sub-cell are null too.
        &self,
                Some(cv) => cv,
    fn nested_and_of_or_of_different_columns() {
            datafusion::parquet::arrow::parquet_to_arrow_schema(
pub struct StatsPruneTree {
                for child in &annotated_children {
            .set_data_page_row_count_limit(8)
        metadata: &ParquetMetaData,
            count_rows_kept(&sel),
                }
/// bitmap-tree walk skips that entire subtree (no FFM collector calls).
            .set_data_page_row_count_limit(8)
            schema.clone(),
            &leaf_predicates,
            w.write(&batch).unwrap();
                        // All values in the page are null → all values
                i64::MAX
        //   NOT(p8[11000]) = [11111]  ← conservative
        if keep.len() != grid_row_counts.len() {
        // AND₃/NOT/p8
        let expr = bin(col("price", 0), Operator::Gt, lit_int(-1));
        let tmp = NamedTempFile::new().unwrap();
            }
impl PagePruneMetrics {
            spt.children[2].children[1].rg_can_match,
            return None;
            .windows(2)
        let arc_meta = meta.metadata().clone();
            let grid_nulls: Option<ArrayRef> = page_null_counts.map(|page_ncs| {
        // per-RG lookup because `page_row_counts(1)` is computed from
                .ok()?;
            // the strings to small indices, defeating the budget, so
    fn stats_prune_tree_delegation_possible_is_all_true() {
        // Keep 2 pages × 8 rows = 16.
            datafusion::physical_expr::expressions::in_list(c, list, &false, &schema).unwrap();
            Err(_) => continue,
        let schema = Arc::new(Schema::new(vec![
        // 5 RGs: price [0..9], [10..19], [20..29], [30..39], [40..49]
    // ─────────────────────────────────────────────────────────────────
//!
    fn num_containers(&self) -> usize {
                for pair in col_locs.windows(2) {
        );
        .unwrap();
            &BoolNode::Predicate(Arc::clone(&expr)),
    /// Per-column min/max/null arrays, all of length `num_grid_cells`.
        );
    fn is_null_over_non_nullable_column_keeps_nothing() {
            let page_row_counts: Vec<usize> = {
            let grid_mins = take(&mins, &indices, None).ok()?;
    #[test]
                        *r &= c;
                    .unwrap();
            &delegated,
                    } else if page_nc == page_rc {
            .set_max_row_group_size(32)
            Err(_) => continue,
                    .map(|c| {
        Some(Self {
        let p7 = pred_leaf("price", Operator::Gt, 30, &schema); // [00011]
                    }
            schema.clone(),
    // Our fixture columns are non-nullable, so null_counts are always
            return None;
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
    /// (schema drift: the predicate's Arrow schema has an extra column).
/// ```text
        assert_eq!(spt.rg_can_match, vec![false, false, false, false, true]);
        let spt = StatsPruneTree::build_from_bool_node(
    fn contained(
        // Position 2 → absolute RG 4 (price [40..49]): p1=F, p2=T → AND=F
                    seg_arrow_schema,
        // Build a 2-RG parquet so we can exercise rg_idx=0 and rg_idx=1
        // price < 10 → pages 0, 1 (max of page 1 is 15, min is 8 < 10).
        .unwrap();
        })
        let (pruner, schema, _) = two_col_fixture();
            //   - otherwise                    → cell null_count = null (unknown)
    }
        }
                    count_rows_kept(&sel),
        // batch to close RG0.
                    // do. Treat as absent (fills with nulls).
    // Row-selection shape (adjacent merging, whole-RG, empty).
        let (pruner, schema, _) = two_col_fixture();
    ///
        );
            ArrowReaderMetadata::load(&tmp.reopen().unwrap(), ArrowReaderOptions::new()).unwrap();
    rg_indices: &[usize],
    fn lit_int(v: i32) -> Arc<dyn PhysicalExpr> {
        // price != 5 → likely all pages (not prunable: every page has
            Arc::new(PhysColumn::new("price", 0)),
            .get(column.name())
/*
        // Pages 0 and 1 survive, 2 and 3 pruned.
            let indices = datafusion::arrow::array::UInt32Array::from(
    ///     [01100]    [00001] [00100] [11111] [11110] [00011]   [11111]
}
            Field::new("price", DataType::Int32, false),
            if let Some(ref c) = m.pages_pruned {
            8,
            Option<(StatisticsConverter<'_>, usize)>,
            //     (no nulls anywhere in the page → none in any sub-cell)
}
    fn build(
        w.write(&batch1).unwrap();
        );
            return None;
    #[test]
        w.close().unwrap();
    // Helper: build a `BoolNode::Predicate(expr)` from a (col, op, value).
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        let mut col_converters: Vec<(
            .set_statistics_enabled(EnabledStatistics::Page)
            .set_max_row_group_size(32)
        let schema = Arc::new(Schema::new(vec![Field::new(
        self.col_stats
        // price = 5: only page 0 (0..8) overlaps.
        }
    fn all_six_comparison_ops_prune_correctly() {
                let mut v = Vec::with_capacity(col_locs.len());
    /// so this is an approximation good enough for counting.
        ));
    /// different columns in the same RG may have different page layouts,
        let offset_index = parquet_metadata.offset_index()?;
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
    fn multi_col_or_both_miss_prunes_everything() {
            &rg_indices,
    }
            schema.clone(),
    }
//! Crucially, the rewrite preserves boolean structure, so
            // Map each grid cell to the page that contains it, then
            ]),
            "PruningPredicate collapsed to always_true for {:?}",
/// pruning expression itself lives in a [`PruningPredicate`] built once
        let p = bin(col("price", 0), Operator::Lt, lit_int(-1));
    };
            spt.children[2].rg_can_match,
                Arc::new(Int32Array::from(prices)),
mod tests {
    #[test]
    /// to have one (e.g., a BYTE_ARRAY column with page-index disabled
    ///   selection means no page can match; a single whole-RG `select`
        let rc1 = pruner.page_row_counts(1).unwrap();
        let delegated = BoolNode::DelegationPossible {
        let p6 = pred_leaf("price", Operator::Lt, 40, &schema); // [11110]
        let left: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new(col_name, col_idx));
    ) -> Option<RowSelection> {
                    // schema so `PruningPredicate`'s comparison kernels
        let q_gt_125 = bin(col("qty", 1), Operator::Gt, lit_int(125));
    // IN / NOT IN — DataFusion expands to OR / AND of equalities and
        let p1 = pred_leaf("price", Operator::Lt, 35, &schema);
/// prune) or translation failures (safe fallback: no pruning).
    fn stats_prune_tree_offset_rg_indices() {
            &schema,
        let (pruner, schema, _) = two_col_fixture();
                        *r |= c;
        )]));
/// Bottom-up:
            count_rows_kept(&sel),
        let c = col("price", 0);
                    }
                .ok();
                    .unwrap();
                    rg_indices,
        // price <= 7 → page 0 only (max 7 ≤ 7; page 1 min 8 > 7). 8 rows.
            "price",
}
        let (pruner, schema, _) = two_col_fixture();
 *
            &tree,
///   - Root AND(OR₁[01101], OR₂[11111], AND₃[00011]) = [00001]
                    let data_type = arrow_schema
        let rg_offsets = offset_index.get(rg_idx)?;
        leaf_predicates: &HashMap<usize, Arc<PruningPredicate>>,
        );
        // the *other* column's boundaries.
) -> Vec<bool> {
use std::sync::Arc;
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
                        builder.append_value(0);
        match node {
///   - NOT(df[11000]) = [11111]  ← conservative: can't prune through negation
        )]));
            &arc_meta,
            datafusion::physical_expr::expressions::in_list(c, list, &false, &schema).unwrap();
        // Early-exit if the file lacks a column/page index; without
        );
    fn is_not_null_over_non_nullable_column_keeps_everything() {
                md.file_metadata().schema_descr(),
        let arr = Int64Array::from_iter_values(self.row_counts.iter().copied());
            .set_data_page_row_count_limit(8)
        for i in 0..5i32 {
        .unwrap();
        let list = vec![lit_int(5), lit_int(20)];
}
    }
                            seg_arrow_schema,
            pages_pruned: sm.pages_pruned.clone(),
            // every row for `tag`. Dictionary encoding would collapse
        // `price >= 0` is definitively true for all rows; every grid
        let tag_pages = oi[0][1].page_locations().len();
            Ok(k) => k,
    let stats = RgLevelStats {
        // Columns referenced by the predicate that are NOT present in
        let mut w =
/// per query by [`build_pruning_predicate`].
        let (pruner, schema, _) = two_col_fixture();
            .build();
///      /   \              /   \                              |
        assert_eq!(
        // Child 1: OR₂ — luc makes it all-true
    let descr = metadata.file_metadata().schema_descr();
            }
///   - AND(df[11100], df[00111]) = [00100]
            &leaf_predicates,
    /// vector should be 3 elements long, indexed 0..2 mapping to
    pruning_predicate: &PruningPredicate,
        );
        self.col_stats
    fn pred_leaf(
        // Absolute RG 2 should map to position 0 → can_match = false
        // price >= 24 → page 3 (24..31). 8 rows.
        let sel1 = pruner.prune_rg(&pp, 1, None).unwrap();
                    continue;
impl PagePruner {
            0,
    #[test]
//! unsupported expression shapes and could mis-prune `OR(...)` inside a
        Some(to_row_selection(keep, &grid_row_counts))
use datafusion::arrow::array::{Array, ArrayRef, BooleanArray, Int64Array};
            "price-side pruning still applies even though extra is absent"
        _column: &Column,
    // against the segment's own schema reads the real `severity` stats and keeps it.
    #[test]
        let meta = ArrowReaderMetadata::load(
                    "StatsPruneTree: Collector node → all-true (no column stats available)"
            }
                            metadata,
        let tree = BoolNode::And(vec![
                        Self::build_from_bool_node(
        let tags_refs: Vec<&str> = tags.iter().map(String::as_str).collect();
                native_bridge_common::log_debug!(
            false,
    // schema. StatisticsConverter maps a column name to a parquet index positionally
            "RG0: only page 0 (min=0, max=7) overlaps price<4"
        // Build PruningPredicates for all df leaves.
//!
    }
    ///
            BoolNode::And(vec![p7.clone(), BoolNode::Not(Box::new(p8.clone()))]),
        // But `price >= 5` (pages 1, 2, 3) evaluates to definitively
/// Each node shows its `rg_can_match` bitset: `[RG0, RG1, RG2, RG3, RG4]`.
        // 5 RGs: price [0..9], [10..19], [20..29], [30..39], [40..49]
            let page_null_counts = converter
    let rg_metas: Vec<_> = rg_indices
            use datafusion::arrow::compute::take;
        w.close().unwrap();
        .unwrap();
            let (converter, parquet_col_idx) = match maybe_cv {
    if columns.is_empty() {
            if let BoolNode::Predicate(expr) = node {
            .set_write_batch_size(8)
/// Conservative on any error: returns `true` (can-match) for every RG rather
                }
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
    pub fn page_row_counts(&self, rg_idx: usize) -> Option<Vec<usize>> {
//! rewritten expression against per-page min/max/null-count arrays;
                v
                // whole segments) whose min/max string bounds exclude the term even though
            let batch =
        assert_eq!(
            if let Some(ref c) = m.pages_total {
            .map(|oi| oi.page_locations())
                let key = Arc::as_ptr(expr) as *const () as usize;
    /// Multi-RG fixture where each RG has a different per-page row
            .and_then(|(_, _, n)| n.clone())
            num_grid_cells,
        match out.last_mut() {
            let mut page_idx = 0usize;
                        .unwrap_or(datafusion::arrow::datatypes::DataType::Null);
        let expr = bin(col("price", 0), Operator::Lt, lit_int(-100));
        let mut leaf_predicates: HashMap<usize, Arc<PruningPredicate>> = HashMap::new();
        let pp = build_pruning_predicate(&expr, schema).unwrap();
    // then reads neg's stats (max < 0) and `eval_leaf` wrongly prunes the RG. Resolving
            .set_statistics_enabled(EnabledStatistics::Chunk)
        assert_eq!(spt.rg_can_match.len(), 3);
    }
            if let BoolNode::Predicate(expr) = node {
    /// is a *token* match evaluated by the peer backend, but the parquet column
                    // is "unknown" but others still prune.
            Ok(arr) => arr,
        // OR₁/AND
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        )
    // ─────────────────────────────────────────────────────────────────
    }
    seg_arrow_schema: &SchemaRef,
        w.write(&batch).unwrap();
    // ─────────────────────────────────────────────────────────────────
                    .iter()
    schema: SchemaRef,
            .set_max_row_group_size(32)
        let tmp = NamedTempFile::new().unwrap();
            .get(column.name())
    fn multi_rg_different_page_layouts_per_rg() {
    /// rows each. Page-level stats enabled.
        let stats = CommonGridPageStats::build(
        assert_eq!(meta.metadata().num_row_groups(), 2);
            .ok()
    fn row_counts(&self) -> Option<ArrayRef> {
        // price > 20 AND qty < 110: price>20 keeps pages 2,3 (16..32);
    /// A `DelegationPossible` leaf must NOT be stats-pruned, even when its
        w.close().unwrap();
    /// Prune an RG to a [`RowSelection`] using an arbitrary boolean
        let list = vec![lit_int(-100), lit_int(-200)];
            spt.children[0].children[1].rg_can_match,
        let props = WriterProperties::builder()
    };
            .unwrap(),
        // 20), skips pages 1 and 3. Two alternating patterns → four
    use datafusion::logical_expr::Operator;
                let pp = build_pruning_predicate(expr, schema.clone()).unwrap();
            "control: plain Predicate is stats-prunable"
        let schema = Arc::new(Schema::new(vec![Field::new(
                            metadata,
use datafusion::common::{Column, ScalarValue};
    fn row_counts(&self) -> Option<ArrayRef> {
            Operator::Gt,
        assert_eq!(arc_meta.num_row_groups(), 5);
    }
        // their grid-cell stats are filled with Arrow-nulls later so
        let pp = build_pruning_predicate(&expr, schema).unwrap();
                            c,
                    let page_nc = page_ncs.value(pidx) as usize;
                }
            &leaf_predicates,
    /// `original_expr` looks stats-prunable against the parquet column.
        );
        let p_gt_20 = bin(col("price", 0), Operator::Gt, lit_int(20));
            let mins = converter
        self.metadata.column_index()?;
        for (col, maybe_cv) in col_converters {
        );
        );
        col_stats,
                let sel = pruner.prune_rg(&pp, 0, None).unwrap();
/// compacted `RowSelection`. Adjacent runs of the same decision are
    row_counts: Vec<i64>,
        assert_eq!(spt.children.len(), 3);
        // price >= 30 → full file would be [F,F,F,T,T]; subset [2,3,4] → [F,T,T]
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
    ///          /       \          /     |     \          /       \
    match pruning_predicate.prune(&stats) {
            for loc in col_locs {
            // whole page, not to any sub-range of it. When a cell is only
            vec![Arc::new(Int32Array::from((100..132).collect::<Vec<i32>>()))],
        // qty>125 keeps page 3 (124..132). Union keeps pages 0 and 3.
 */
    pub page_pruning_unavailable: Option<datafusion::physical_plan::metrics::Count>,
                }
        // price < -100: no page could match.
    // ─────────────────────────────────────────────────────────────────
    }
            DataType::Int32,
        op: Operator,
    // ─────────────────────────────────────────────────────────────────
        let schema = Arc::new(Schema::new(vec![
//! adapter below answers stats queries for any column in the file.
        // values (0..7, 16..23, 24..31); page 1 (rows 8..15) is all-null.
        let schema = Arc::new(Schema::new(vec![Field::new(
        let meta =
    use datafusion::parquet::arrow::ArrowWriter;
            price_pages != tag_pages,
    }
            .set_statistics_enabled(EnabledStatistics::Page)
        );
use datafusion::parquet::file::metadata::ParquetMetaData;
        assert_eq!(
        // RG1 (100..131) keeps no page. 0 rows.
        let col_offsets = rg_offsets
        let grid_row_counts: Vec<usize> = boundaries
    schema: &SchemaRef,
    #[test]
            8,
        assert_eq!(
                expr,
            .set_max_row_group_size(10)
        for i in 0..5i32 {
            vec![
                    col_converters.push((col, None));
                            rg_indices,
        }
        assert_eq!(arc_meta.num_row_groups(), 5);
                leaf_predicates.insert(key, pp);
        };
    // ─────────────────────────────────────────────────────────────────
    }
            counts.push((pair[1].first_row_index - pair[0].first_row_index) as usize);
            let mut next_page_start = if col_locs.len() > 1 {
                    // for every grid cell). Null_counts is `None` so
                // to the peer backend rather than trusting raw-string stats.
            datafusion::physical_expr::expressions::in_list(c, list, &true, &schema).unwrap();
        node: &super::bool_tree::BoolNode,
///   - OR₁(AND[01100], df[00001]) = [01101]
        assert_eq!(
            .metadata()
    pub fn prune_rg(
        let expr: Arc<dyn PhysicalExpr> = Arc::new(IsNullExpr::new(col("x", 0)));
            };
        let table_schema = Arc::new(Schema::new(vec![
        self.num_rgs
use datafusion::physical_expr::PhysicalExpr;
        let arc_meta = meta.metadata().clone();
        // AND₃/p7
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
                let annotated_child = Self::build_from_bool_node(
        }
    fn not_in_list_prunes_via_and_of_neq() {
            vec![Arc::new(Int32Array::from((0..32).collect::<Vec<i32>>()))],
        let expr: Arc<dyn PhysicalExpr> = Arc::new(BinaryExpr::new(
    // (parquet crate `parquet_column`), so passing the full schema reads the wrong /
            DataType::Int32,
            grid_row_counts,
                }
        l: Arc<dyn PhysicalExpr>,
            Err(e) => {
            datafusion::physical_expr::expressions::in_list(c, list, &false, &schema).unwrap();
    /// to verify the full shape and bitset propagation.
                    rg_can_match: vec![true; num],
use datafusion::parquet::arrow::arrow_reader::{RowSelection, RowSelector};
                            schema,
    }
        );
            return None;
    fn missing_column_does_not_disable_other_columns() {
        Self {
        // cell inherits stats from the single price page (min=0, max=31)
                            leaf_predicates,
            .set_write_batch_size(8)
        // (0..31) keeps only page 0 (max=7 ≥ 4, but page 1 has min=8
            page_pruning_unavailable: sm.page_pruning_unavailable.clone(),
                    if let Some(ref c) = m.page_pruning_unavailable {
        sel.iter().filter(|s| !s.skip).map(|s| s.row_count).sum()
        let pp = build_pruning_predicate(&expr, schema);
        )
        let mut leaf_predicates: HashMap<usize, Arc<PruningPredicate>> = HashMap::new();
/// Result: only RG4 survives. NOT is always [11111] because inverting
/// that grid cell.
    fn multi_rg_fixture_prunes_each_rg_independently() {
/// or `PruningPredicate::prune` error will never cause data loss — the RG will
    }
        )]));
        let rg_index_to_pos: HashMap<usize, usize> = rg_indices
        let arc_meta = meta.metadata().clone();
        )
                );
    pub rg_can_match: Vec<bool>,
            spt.children[0].children[0].rg_can_match,
                .data_page_null_counts(column_index, offset_index, [&rg_idx])
    let pruning_predicate = match PruningPredicate::try_new(Arc::clone(expr), schema) {
    /// Predicate references a column absent from the parquet file
        assert_eq!(
            .set_write_batch_size(1)
    ///   means every page is kept.
            0,
                    schema,
        assert_eq!(count_rows_kept(&sel1), 0, "RG1: no page has values < 4");
        assert_eq!(count_rows_kept(&sel), 32);
    pub fn new(
    let columns = collect_columns(pruning_predicate.orig_expr());
        let num_rows = rg_meta.num_rows() as usize;
        let (pruner, schema, _) = two_col_fixture();
            .build();
            // page is "all null": `null_count == page_row_count`).
        // Child 0: OR₁
}
            }
                    leaf_predicates,
        let file_schema = Arc::new(Schema::new(vec![
///
pub fn build_pruning_predicate(
                let key = Arc::as_ptr(expr) as *const () as usize;
/// ```
        // with the public API; fall back to asserting that each RG's
        }
        // IS NULL: only the all-null page keeps rows → 8 rows.
            spt.children[0].children[0].children[1].rg_can_match,
                // peer backend's semantics — for analyzed text/match_only_text fields
        assert_eq!(run(Operator::Gt, 24), 8);
        // Tree: AND(OR(AND(p1,p2), p3), OR(AND(p4,p5), Collector, p6), AND(p7, NOT(p8)))
                        // can't attribute null_count exactly. Mark as
                    rg_can_match: vec![true; num],
            if let Some(m) = metrics {
        Some(counts)
                );
    #[test]
/// the single-collector path's residual (non-Collector portion).
        assert_eq!(
///
        assert_eq!(run_count(&sel), 1, "all-select should coalesce");
                    continue;
            count_rows_kept(&sel0),
        // ~4 KiB per tag so the byte budget triggers many page flushes.
                e
        let p1 = pred_leaf("price", Operator::Lt, 30, &schema); // [11100]
            });
        let file_arrow_schema: SchemaRef = Arc::new(
    /// Return per-page row counts for the given RG. Uses the first
        // Resolve against the segment's own schema (see eval_leaf): the full table
        let col_idx = schema.index_of(col_name).unwrap();
        let expr =
                // A `DelegationPossible` predicate (e.g. `field = 'laptop'`) carries the
            meta.metadata().clone(),
        let meta = ArrowReaderMetadata::load(
                    .map(|i| *i as u32)
        let p3 = pred_leaf("price", Operator::Gt, 45, &schema); // [00001]
            &col_converters,
                    // Column not in Arrow schema either — nothing we can
        let spt = StatsPruneTree::build_from_bool_node(
            .get(column.name())
                    // all-null min/max arrays typed to match the Arrow
                native_bridge_common::log_debug!(
            Option<(StatisticsConverter<'_>, usize)>,
    // prunes homomorphically. Our substrait path doesn't emit IN today
        .unwrap();
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
            // Build grid-aligned min/max arrays by indexing into the
            // `null_pages = true` entries into Arrow nulls, which
            return None;
            Field::new("qty", DataType::Int32, false),
            .collect();
        let pp = build_pruning_predicate(&expr, table_schema.clone()).unwrap();
            ArrowReaderOptions::new().with_page_index(true),
    ///              OR                   OR                  AND
        // the common grid. Each grid cell inherits stats from the page
        let meta =
        )
                assert_eq!(count_rows_kept(&sel), 32);
