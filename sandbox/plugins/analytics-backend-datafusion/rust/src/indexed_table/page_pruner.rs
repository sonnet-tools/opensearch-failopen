        w.write(&batch).unwrap();
}
        let pp = build_pruning_predicate(&expr, schema).unwrap();
            let batch =
                Arc::new(Int32Array::from(vec![-9, -8, -7, -6])),
                // because stats give a superset, and inverting a superset is a subset.
        let min_arr = match converter.row_group_mins(rg_metas.iter().copied()) {
        rg_idx: usize,
                native_bridge_common::log_debug!("StatsPruneTree: NOT node → all-true (conservative, cannot prune through negation)");
                if let Some(m) = metrics {
        let batch = RecordBatch::try_new(
    /// Columns with misaligned per-column page boundaries. Each column's
            BoolNode::And(vec![p7.clone(), BoolNode::Not(Box::new(p8.clone()))]),
        )
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            "price",
                md.file_metadata().key_value_metadata(),
        // price > -1: every page qualifies (`price_min < -1` is false
    /// bounds exclude the term even though a document contains it as a token.
        );
            .map(|w| (w[1] - w[0]) as usize)
            .set_write_batch_size(8)
        let left = bin(
        if col_converters.iter().all(|(_, c)| c.is_none()) {
    col_stats: HashMap<String, (ArrayRef, ArrayRef, Option<ArrayRef>)>,
                RecordBatch::try_new(schema.clone(), vec![Arc::new(Int32Array::from(vals))])
                    rg_can_match: vec![true; num],
            0,
    /// The fix treats `DelegationPossible` as all-true, exactly like a Collector.
    metadata: &ParquetMetaData,
        let mut w =
            .set_max_row_group_size(32)
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
        let p1 = pred_leaf("price", Operator::Lt, 30, &schema); // [11100]
                    col_converters.push((col, None));
            &tmp.reopen().unwrap(),
        let expr = bin(left, Operator::And, right);
    seg_arrow_schema: SchemaRef,
        // The underlying expr: `price > 45` → prunes to [00001] as a plain Predicate.
            "IS NULL must keep the all-null page and prune the others"
        return vec![];
            "RG0: only page 0 (min=0, max=7) overlaps price<4"
                    let data_type = arrow_schema
            .set_data_page_row_count_limit(8)
            "severity >= 0 is always true; eval_leaf must not prune under schema drift"
        let props = WriterProperties::builder()
            DataType::Int32,
            &tmp.reopen().unwrap(),
    for col in &columns {
            false,
    rg_indices: &[usize],
    /// but other columns enabled). Used for metrics and cost estimation;
            0,
        assert_eq!(
    fn max_values(&self, column: &Column) -> Option<ArrayRef> {
            spt.children[0].children[0].children[0].rg_can_match,
            DataType::Int32,
                    })
    ///              OR                   OR                  AND
            let grid_maxs = take(&maxs, &indices, None).ok()?;
    fn all_six_comparison_ops_prune_correctly() {
//! rewritten expression against per-page min/max/null-count arrays;
/// Result: only RG4 survives. NOT is always [11111] because inverting
/// column. min/max for each column are inherited from the page containing
        let pruner = PagePruner::new(&schema, Arc::clone(&arc_meta), schema.clone());
    // Schema drift: the table schema orders columns differently from the segment's own
        // price > 20 AND qty < 110: price>20 keeps pages 2,3 (16..32);
//!
    }
        //   AND(p4[11100], p5[00111]) = [00100]
        // But `price >= 5` (pages 1, 2, 3) evaluates to definitively
                    v.push((pair[1].first_row_index - pair[0].first_row_index) as usize);
    fn stats_prune_tree_five_leaf_shape() {
    // IN / NOT IN — DataFusion expands to OR / AND of equalities and
                Self {
                    children: vec![],
        let (pruner, schema, _) = two_col_fixture();
        _values: &std::collections::HashSet<ScalarValue>,
    pub fn prune_rg(
                    .iter()
        let md = ArrowReaderMetadata::load(&tmp.reopen().unwrap(), ArrowReaderOptions::new())
        // Absolute RG 0 (not in chunk) should have no entry
        // dynamic-mapping schema drift.
                grid_page_indices
        // Build PruningPredicates for all df leaves.
            .set_statistics_enabled(EnabledStatistics::Page)
            ArrowReaderMetadata::load(&tmp.reopen().unwrap(), ArrowReaderOptions::new()).unwrap();
        let tag_pages = oi[0][1].page_locations().len();
        let pruner = PagePruner::new(&schema, meta.metadata().clone(), schema.clone());
                };
        // price > 24 → page 3 (24..31, max 31 > 24). 8 rows.
        let right = bin(col("price", 0), Operator::Gt, lit_int(24));
            let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        let pp = build_pruning_predicate(&expr, schema).unwrap();
) -> Vec<bool> {
    }
        let expr = bin(col("price", 0), Operator::Gt, lit_int(-1));
    fn multi_col_or_unions_pages() {
        // falls within a single page of every column.
/// [11100] [01111]    [11100] [00111]                     [11000]
        }
            &delegated,
    fn stats_prune_tree_offset_rg_indices() {
            )
        let expr = bin(col("price", 0), Operator::Eq, lit_int(5));
        // Child 1: OR₂ — luc makes it all-true
        let rg_meta = parquet_metadata.row_groups().get(rg_idx)?;
        assert_eq!(
                        )
        )
/// Evaluate a single predicate against RG-level column stats for the given RGs.
            .iter()
            }
///          /       \          /     |     \          /       \
        // For each column, build min/max/null_count arrays aligned to
        let batch =
                }
        Some(Self {
    }
            predicate_schema.clone(),
        let delegated = BoolNode::DelegationPossible {
    schema: &SchemaRef,
        let p5 = pred_leaf("price", Operator::GtEq, 20, &schema); // [00111]
    /// column with a populated page index — column 0 isn't guaranteed
}
    #[test]
                .data_page_null_counts(column_index, offset_index, [&rg_idx])
    fn misaligned_page_boundaries_prune_correctly() {
            spt.children[0].children[0].children[1].rg_can_match,
            let batch =
    }
        );
    ) -> Option<BooleanArray> {
            false,
                RecordBatch::try_new(schema.clone(), vec![Arc::new(Int32Array::from(vals))])
        // (price < 5 OR qty > 125) AND price > 24
/// Use for the multi-filter tree path's whole residual subtree or for
            .set_max_row_group_size(32)
            .map(|(m, _, _)| Arc::clone(m))
    let rg_metas: Vec<_> = rg_indices
            .collect();
                        // All values in the page are null → all values
        };
        &self,
        );
        // Pages 2, 3 skipped.
            false,
    match pruning_predicate.prune(&stats) {
    // then reads neg's stats (max < 0) and `eval_leaf` wrongly prunes the RG. Resolving
            Ok(arr) => arr,
            .clone();
                            c,
        assert_eq!(run(Operator::NotEq, 5), 32);
            "price > 100 must prune the entire RG regardless of tag layout"
        let p_gt_20 = bin(col("price", 0), Operator::Gt, lit_int(20));
            }
            vec![
        Err(_) => vec![true; num],
            .get(column.name())
            datafusion::physical_expr::expressions::in_list(c, list, &true, &schema).unwrap();
            .unwrap()
                BoolNode::And(vec![p1.clone(), p2.clone()]),
        let schema = Arc::new(Schema::new(vec![Field::new(
        let (pruner, schema, _) = two_col_fixture();
    #[test]
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        .collect();
    pub rg_can_match: Vec<bool>,
        // so all pages get pruned.
        let expr = bin(col("severity", 1), Operator::GtEq, lit_int(0));
        // count is file-wide. Simulate "different per-RG page layouts"
            .set_write_batch_size(1)
                    .collect();
            tag_pages
    };
            let mut next_page_start = if col_locs.len() > 1 {
        // price < -100: no page could match.
/// Build an [`PruningPredicate`] from an arbitrary physical boolean
        assert_eq!(count_rows_kept(&sel), 0);
            .set_data_page_row_count_limit(8)
    #[test]
        let expr: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Boolean(Some(true))));
    // ─────────────────────────────────────────────────────────────────
        );
        w.close().unwrap();
        assert_eq!(count_rows_kept(&sel), 8);
            };
        .unwrap();
        let mut leaf_predicates: HashMap<usize, Arc<PruningPredicate>> = HashMap::new();
        let meta = ArrowReaderMetadata::load(
                // a document contains it as a token — an unsound over-prune. Defer entirely
    /// Prune an RG to a [`RowSelection`] using an arbitrary boolean
        );
        // both we can't produce page stats for pruning.
                }
        }
use datafusion::physical_optimizer::pruning::{PruningPredicate, PruningStatistics};
        counts.push(num_rows - col_offsets.last()?.first_row_index as usize);
/// bitmap-tree walk skips that entire subtree (no FFM collector calls).
        // Convert grid-level keep/skip to row selection using grid cell row counts
        let rg_meta = self.metadata.row_groups().get(rg_idx)?;
                Some(oi) => oi.page_locations(),
                }
/// expression. Returns `None` for always-true predicates (nothing to
    num_rgs: usize,
        let vals: Vec<Option<i32>> = (0..32)
    // ─────────────────────────────────────────────────────────────────
            //     back to the safe (non-pruning) branch, so `IS NULL` /
        .unwrap();
/// prune) or translation failures (safe fallback: no pruning).
    }
        // Leaf predicates and their expected rg_can_match bitsets:
    }
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        // IS NULL: only the all-null page keeps rows → 8 rows.
            "price",
    use datafusion::logical_expr::Operator;
            vec![true, true, true, true, true]
                            metadata,
    }
    fn row_counts(&self) -> Option<ArrayRef> {
                    };
        let props = WriterProperties::builder()
        assert_eq!(
        // the parquet file (schema evolution) contribute no boundaries —
                    } else if page_nc == page_rc {
            .row_group_null_counts(rg_metas.iter().copied())
        })
mod tests {
    fn missing_column_does_not_disable_other_columns() {
            0,
            Operator::Gt,
    fn is_not_null_over_non_nullable_column_keeps_everything() {
///              OR                   OR                  AND
        let p2 = pred_leaf("price", Operator::GtEq, 30, &schema);
    /// ```
        w.close().unwrap();
            &leaf_predicates,
                    .iter()
        .unwrap();
        // Helper: build a comparison, evaluate, return rows kept.
        }
                    // parquet file. Fill with null stats so this column
        // price < 5. The `extra = 10` clause evaluates to unknown for
        assert_eq!(meta.metadata().num_row_groups(), 2);
        );
        // prunable.
                        .unwrap_or(datafusion::arrow::datatypes::DataType::Null);
            8,
        let col_idx = schema.index_of(col_name).unwrap();
    /// prunes correctly despite the union grid containing extra cell
        let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), file_schema, None).unwrap();
            seg_arrow_schema,
//! # Per-RG cost
                .ok();
    }
                }
use datafusion::parquet::file::metadata::ParquetMetaData;
impl CommonGridPageStats {
        //   NOT(p8[11000]) = [11111]  ← conservative
    // ─────────────────────────────────────────────────────────────────
        let p4 = pred_leaf("price", Operator::Lt, 25, &schema); // [11100]
        )
            Arc::new(PhysColumn::new("price", 0)),
    /// page layout is independent; the common grid unions the boundaries.
    }
    fn build(
        // Sanity check that the two columns have different page counts.
                }
//! `PruningPredicate` rewrites the full boolean tree homomorphically:
        // `Literal(true)` alone — becomes always-true after rewrite.
                Arc::new(Int32Array::from(prices)),
use datafusion::arrow::array::{Array, ArrayRef, BooleanArray, Int64Array};
            count_rows_kept(&sel),
        let props = WriterProperties::builder()
    /// boundaries contributed by the *other* column.
                            rg_indices,
                        continue;
        let q = bin(col("qty", 1), Operator::Gt, lit_int(999));
            datafusion::physical_expr::expressions::in_list(c, list, &false, &schema).unwrap();
        };
    // ─────────────────────────────────────────────────────────────────
            count_rows_kept(&sel),
        // qty<110 keeps page 0 (100..108). Intersection is empty.
        let expr = bin(p_lt_5, Operator::Or, q_gt_125);
    /// Count the number of selector runs in the selection — useful to
    // Helper: build a `BoolNode::Predicate(expr)` from a (col, op, value).
        )],
                            rg_indices,
    for (k, rc) in keep.into_iter().zip(row_counts.iter().copied()) {
    fn count_rows_kept(sel: &RowSelection) -> usize {
        let pp = build_pruning_predicate(&expr, schema);
                            leaf_predicates,
    }
        let expr = bin(col("price", 0), Operator::Gt, lit_int(50));
            };
        assert_eq!(
        // `price < 5 AND extra = 10`. Only page 0 (0..7) can contain
                    }
    }
            8,
        );
            pages_total: sm.pages_total.clone(),
        assert_eq!(count_rows_kept(&sel), 16, "2 pages × 8 rows");
            } else {
            let indices = datafusion::arrow::array::UInt32Array::from(
                );
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            &schema,
        match out.last_mut() {
            Field::new("severity", DataType::Int32, false),
        // → every cell prunes → 0 rows. This verifies the grid-cell
        let expr: Arc<dyn PhysicalExpr> = Arc::new(IsNotNullExpr::new(col("x", 0)));
            }
        let pp = build_pruning_predicate(&expr, schema).unwrap();
            .build();
            // Null count splitting: a page's `null_count` applies to the
    /// Verify the present column still prunes and the absent column
//! adapter below answers stats queries for any column in the file.
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            Field::new("price", DataType::Int32, false),
                expr,
        Err(e) => {
                if let Some(ref c) = m.page_pruning_unavailable {
/// Each grid cell is a row range that falls within a single page of every
        let pp = build_pruning_predicate(&expr, schema).unwrap();
pub fn build_pruning_predicate(
/// the single-collector path's residual (non-Collector portion).
        let meta = ArrowReaderMetadata::load(
#[cfg(test)]
            &arc_meta,
            ],
    fn two_col_fixture() -> (PagePruner, SchemaRef, Arc<ParquetMetaData>) {
        let file_arrow_schema: SchemaRef = Arc::new(
    #[test]
        // every cell (absent column → all-null stats), so AND collapses
    /// - `Some(selection)` — per-page keep/skip over the RG. An empty
                }
        assert_eq!(count_rows_kept(&sel), 16);
                    rg_can_match: vec![true; num],
        // AND₃/NOT/p8
///   - AND(df[11100], df[00111]) = [00100]
        )))
            vec![
    fn min_values(&self, column: &Column) -> Option<ArrayRef> {
            Err(_) => continue,
        let props = WriterProperties::builder()
            if let BoolNode::Predicate(expr) = node {
    fn nullable_all_null_page_prunes_is_not_null() {
            BoolNode::Not(child) => {
                    let mins = datafusion::arrow::array::new_null_array(&data_type, num_grid_cells);
        w.write(&batch1).unwrap();
                Arc::new(Int32Array::from(prices)),
    /// is a *token* match evaluated by the peer backend, but the parquet column
            let page_row_counts: Vec<usize> = {
                        Self::build_from_bool_node(
    // prunes homomorphically. Our substrait path doesn't emit IN today
    // Resolve stats against the segment's OWN parquet schema, not the full table
        };
        // columns' page boundaries. Each grid cell is a row range that
        rg_indices: &[usize],
        let pp = build_pruning_predicate(&expr, schema).unwrap();
    ) -> Arc<dyn PhysicalExpr> {
/// Returns a `Vec<bool>` aligned to `rg_indices`.
        let null_counts = converter
    let num = rg_indices.len();
        let meta =
        )]));
        let expr = bin(p, Operator::Or, q);
                leaf_predicates.insert(key, pp);
}
    #[test]
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
                md.file_metadata().schema_descr(),
        let schema = Arc::new(Schema::new(vec![Field::new("x", DataType::Int32, true)]));
    /// Returns:
        self.num_rgs
            spt.children[0].children[1].rg_can_match,
    }
            .set_statistics_enabled(EnabledStatistics::Page)
        assert_eq!(run(Operator::Lt, 10), 16);
    fn max_values(&self, column: &Column) -> Option<ArrayRef> {
            spt.children[2].children[1].children[0].rg_can_match,
            // Map each grid cell to the page that contains it, then
        let arr = Int64Array::from_iter_values(self.row_counts.iter().copied());
        self.col_stats
        let meta = ArrowReaderMetadata::load(
                let key = Arc::as_ptr(expr) as *const () as usize;
        assert_eq!(run(Operator::GtEq, 24), 8);
        .unwrap();
    }
 * The OpenSearch Contributors require contributions made to
                    let page_rc = page_row_counts.get(pidx).copied().unwrap_or(0);
            .map(|(_, m, _)| Arc::clone(m))
        let props = WriterProperties::builder()
    let seg_arrow_schema = Arc::clone(seg_arrow_schema);
        let pp = build_pruning_predicate(&expr, schema).unwrap();
            DataType::Int32,
        // page layout. We can't truly swap writer properties mid-file
        let boundaries: Vec<i64> = boundary_set.into_iter().collect();
/// merged.
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            "PruningPredicate collapsed to always_true for {:?}",
            "price",
            bin(col("price", 0), Operator::Lt, lit_int(5)),
        .unwrap();
    fn bin(
        }
        let schema = Arc::new(Schema::new(vec![Field::new(
        // always-true at predicate-construction time.
            .set_max_row_group_size(10)
            vec![true, true, true, false, false]
        // count enforcement, which we exploit here.
                    let cell_rc = grid_row_counts[cell_idx];
            8,
        w.write(&batch2).unwrap();
            use datafusion::arrow::compute::take;
        boundary_set.insert(num_rows as i64);
        // Absolute RG 3 should map to position 1 → can_match = true
            annotation_id: 7,
                    col_converters.push((col, None));
        let pp = build_pruning_predicate(&expr, schema).unwrap();
    /// fully-null page retains its IS-NOT-NULL pruning behaviour even
        // their grid-cell stats are filled with Arrow-nulls later so
        };
//! - `AND(x, y)` → `AND(rewrite(x), rewrite(y))`.
            ]),
    /// Uses 5 RGs (price ranges [0..9],[10..19],[20..29],[30..39],[40..49])
            Arc::new(Literal::new(ScalarValue::Int32(Some(45)))),
    ///
        let pp = build_pruning_predicate(&expr, table_schema.clone()).unwrap();
    fn nested_and_of_or_of_different_columns() {
                    rg_can_match: vec![true; num],
        let meta = ArrowReaderMetadata::load(
        w.close().unwrap();
        w.flush().unwrap();
            let (converter, parquet_col_idx) = match maybe_cv {
                collector,
        row_counts: rg_metas.iter().map(|m| m.num_rows()).collect(),
//!
        leaf_predicates.insert(key, build_pruning_predicate(&expr, schema.clone()).unwrap());
            Field::new("extra", DataType::Int32, true),
            "DelegationPossible must be all-true (peer-backend semantics)"
        let batch = RecordBatch::try_new(
                    child,
            "OR of unreachable ranges prunes everything"
    };
            ],
        Arc::new(Literal::new(ScalarValue::Int32(Some(v))))
        assert_eq!(spt.rg_can_match[*pos], false);
        w.close().unwrap();
        )
        let schema = Arc::new(Schema::new(vec![Field::new(
        assert!(pp.is_none());
fn to_row_selection(keep: Vec<bool>, row_counts: &[usize]) -> RowSelection {
    // Row-selection shape (adjacent merging, whole-RG, empty).
        let (pruner, schema, _) = two_col_fixture();
            let converter = match StatisticsConverter::try_new(col.name(), &seg_arrow_schema, descr)
                native_bridge_common::log_debug!("page pruning error for rg {}: {}", rg_idx, e);
    #[test]
            //     `IS NOT NULL` stay correct on the split cell.
    let pruning_predicate = match PruningPredicate::try_new(Arc::clone(expr), schema) {
        )?;
    // 0. We test these for safety (no crash, consistent result); real
                // NOT is conservatively all-true: negating stats-based pruning is unsound
        // rg_offsets.get(1), not the first RG.
            file_schema.clone(),
                    .unwrap();
            vec![false, false, false, false, true],
        let arc_meta = meta.metadata().clone();
        let c = col("price", 0);
    /// contains RGs [2,3,4] out of a 5-RG file). The `rg_can_match`
            BoolNode::Or(children) => {
            let vals: Vec<i32> = (i * 10..(i + 1) * 10).collect();
                v
        // The easiest way to get different per-RG page layouts is to
    }
            //     (all values are null → every sub-cell is all-null)
                let mut builder = UInt64Array::builder(num_grid_cells);
            }
        }
#[cfg(test)]
        op: Operator,
        assert_eq!(count_rows_kept(&sel), 32);
        use crate::indexed_table::bool_tree::BoolNode;
        self.metadata.column_index()?;
    if pruning_predicate.always_true() {
        let pp = build_pruning_predicate(&expr, predicate_schema).unwrap();
                c.add(pruned);
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
///
            }
        assert_eq!(
    }
        let batch = RecordBatch::try_new(
        let p2 = pred_leaf("price", Operator::GtEq, 10, &schema); // [01111]
                Self {
                    // Column not in Arrow schema either — nothing we can
                Arc::new(Int32Array::from(vec![1, 2, 3, 4])),
            Operator::Or,
            &leaf_predicates,
        use crate::indexed_table::bool_tree::BoolNode;
            &arc_meta,
                        builder.append_value(0);
            Err(_) => continue,
pub struct StatsPruneTree {
        assert!(spt.children.is_empty());
    /// to have one (e.g., a BYTE_ARRAY column with page-index disabled
//! **multi-column** per-RG page-stats adapter. Replaces the previous
            .set_data_page_row_count_limit(32)
        use crate::indexed_table::bool_tree::BoolNode;
        let expr = bin(p_gt_20, Operator::And, q_lt_110);
                    rg_indices,
                }
        sel.iter().filter(|s| !s.skip).map(|s| s.row_count).sum()
            .set_data_page_size_limit(100)
        let max_arr = match converter.row_group_maxes(rg_metas.iter().copied()) {
        }
/// or `PruningPredicate::prune` error will never cause data loss — the RG will
        let pp = build_pruning_predicate(&expr, schema);
                    32,
//! Crucially, the rewrite preserves boolean structure, so
        let (pruner, schema, _) = two_col_fixture();
///                /                  |                  \
    }
    fn null_counts(&self, column: &Column) -> Option<ArrayRef> {
use datafusion::common::{Column, ScalarValue};
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        // The `write_batch_size` acts as an upper bound on page row
    // against the segment's own schema reads the real `severity` stats and keeps it.
        (pruner, schema, arc_meta)
    ///
    #[test]
impl PagePruner {
        )
        native_bridge_common::log_debug!(
        let expr_false = bin(col("price", 0), Operator::Gt, lit_int(100));
        )
            .set_write_batch_size(8)
        }
        assert_eq!(count_rows_kept(&sel1), 0, "RG1: no page has values < 4");
    seg_arrow_schema: &SchemaRef,
        let (pruner, schema, _) = two_col_fixture();
        //   Root AND(OR₁[01101], OR₂[11111], AND₃[00011]) = [00001]
    /// prunes it. With the common-grid null-count splitting fix, a
                    children: annotated_children,
        w.close().unwrap();
use std::sync::Arc;
        None
        let mut w =
                    children: vec![],
        // two RGs end up with the same page counts, we still exercise
        ]));
    ///     [01100]    [00001] [00100] [11111] [11110] [00011]   [11111]
        return vec![true; num];
        let meta =
    fn num_containers(&self) -> usize {
            vec![Arc::new(Int32Array::from((100..132).collect::<Vec<i32>>()))],
            meta.metadata().clone(),
        let tags: Vec<String> = (0..32)
        w.close().unwrap();
                // over the raw source string. Evaluating those stats here prunes RGs (and
        );
    ///                                  AND
        // per-RG lookup because `page_row_counts(1)` is computed from
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            let batch =
            "price",
        // Intersection: page 3 only → 8 rows.
        // If no referenced column contributed real page boundaries (all
            .ok()
        let list = vec![lit_int(-100), lit_int(-200)];
        };
        let batch = RecordBatch::try_new(
                }
        match pp {
                Self {
///
    /// instead yield `[11111]` when wrapped in `DelegationPossible`.
        let mut w =
        let arr = Int64Array::from_iter_values(self.grid_row_counts.iter().map(|c| *c as i64));
                }
        // to `(pruned_by_price) AND unknown`, which PruningPredicate
        let (pruner, schema, _) = two_col_fixture();
}
) -> Option<Arc<PruningPredicate>> {
                    col_stats.insert(col.name().to_string(), (mins, maxs, None));
    RowSelection::from(out)
        );
        let rg_indices: Vec<usize> = (0..5).collect();
        );
        use datafusion::arrow::array::Int32Array;
            "control: plain Predicate is stats-prunable"
            price_pages,
            .map(|w| (w[1] - w[0]) as usize)
        let schema = Arc::new(Schema::new(vec![
        // ArrowWriter doesn't support mid-file prop changes; page row
                    Some(pp) => eval_leaf(pp, metadata, schema, rg_indices, seg_arrow_schema),
        for i in 0..5i32 {
    }
        // price < 5 OR qty > 125: price<5 keeps page 0 (0..8);
            &arc_meta,
            "price",
                            seg_arrow_schema,
            // per-page arrays. `StatisticsConverter` already converts
                    count_rows_kept(&sel),
    }
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        // A predicate that's structurally unusable for pruning — e.g.,
    }
    fn selection_empty_when_no_page_survives() {
            vec![Arc::new(Int32Array::from((0..32).collect::<Vec<i32>>()))],
            for loc in col_locs {
        let schema = Arc::new(Schema::new(vec![Field::new(
    }
    /// Motivation: for analyzed text/match_only_text fields, `field = 'laptop'`
    fn multi_rg_fixture_prunes_each_rg_independently() {
impl PruningStatistics for CommonGridPageStats {
    // schema drift) — yielding null stats that prune RGs that actually match.
        let column_index = parquet_metadata.column_index()?;
    fn lit_int(v: i32) -> Arc<dyn PhysicalExpr> {
//!   rewriters.
        );
    fn in_list_prunes_via_or_of_eq() {
    // All six comparison operators, to pin down the supported surface.
            &tmp.reopen().unwrap(),
        );
            // Build grid-aligned min/max arrays by indexing into the
    // schema. StatisticsConverter maps a column name to a parquet index positionally
            datafusion::physical_expr::expressions::in_list(c, list, &false, &schema).unwrap();
    /// [11100] [01111]    [11100] [00111]                     [11000]
                }
    fn contained(
            .map(|oi| oi.page_locations())
        for (col, maybe_cv) in col_converters {
        // price = 5 → page 0 only (8 rows).
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        assert_eq!(count_rows_kept(&sel), 8);
        w.write(&batch).unwrap();
    // IS NULL / IS NOT NULL — DataFusion uses null-count stats.
///
    }
            native_bridge_common::log_debug!(
        let mut w =
        // so `build_from_bool_node` would find it (proving we skip it deliberately,
                None => {
        )]));
                        // Mixed page split across multiple grid cells:
        assert_eq!(
                }
    fn col(name: &str, idx: usize) -> Arc<dyn PhysicalExpr> {
        _values: &std::collections::HashSet<ScalarValue>,
        // AND₃/NOT → always true
        // Arrow schema handed to the pruner includes both columns —
        .unwrap();
    // we cover it here for future callers and as a regression fence.
                    if pidx >= page_ncs.len() || page_ncs.is_null(pidx) {
    use datafusion::parquet::arrow::ArrowWriter;
            spt.children[2].rg_can_match,
        let mut w =
            .get(column.name())
    ///      /   \              /   \                              |
            Field::new("qty", DataType::Int32, false),
            .unwrap(),
        let expr = bin(
    /// `rg_indices` is a subset that doesn't start at 0 (e.g. chunk
            w.write(&batch).unwrap();
        crate::indexed_table::bool_tree::BoolNode::Predicate(Arc::new(BinaryExpr::new(
        // `price` is Int32 (tiny bytes/value). `tag` is Utf8 with
//! Thin wrapper around DataFusion's [`PruningPredicate`] and a
        metrics: Option<&PagePruneMetrics>,
        col_stats,
        // price IN (-10, -20, -30) — nothing in RG matches, all pages
    row_counts: Vec<i64>,
            .set_statistics_enabled(EnabledStatistics::Page)
            if let Some(m) = metrics {
    // ─────────────────────────────────────────────────────────────────
        let tmp = NamedTempFile::new().unwrap();
            spt.children[2].children[0].rg_can_match,
        )
                for pair in col_locs.windows(2) {
                let pp = build_pruning_predicate(expr, schema.clone()).unwrap();
    }
    fn min_values(&self, column: &Column) -> Option<ArrayRef> {
            Field::new("name", DataType::Int32, false),
        ]));
        let list = vec![lit_int(5), lit_int(20)];
        assert_eq!(run_count(&sel), 4, "expected select/skip/select/skip");
                leaf_predicates.insert(key, pp);
        let (pruner, schema, _) = two_col_fixture();
        schema: &SchemaRef,
                    "StatsPruneTree: Collector node → all-true (no column stats available)"
    /// contributes "unknown" stats without disabling pruning for the RG.
        assert_eq!(run_count(&sel), 1, "all-select should coalesce");
    #[test]
                Arc::new(builder.finish()) as ArrayRef
    ///           [01101]              [11111]              [00011]
            vec![true],
    }
            &col_converters,
        let descr = self.metadata.file_metadata().schema_descr();
            }
        // Actually: page 0 (0..7) certainly has < 10, page 1 (8..15)
        // which doesn't exist in the parquet file.
            // every row for `tag`. Dictionary encoding would collapse
///   - AND(df[11100], df[01111]) = [01100]
}
        // 32 rows, 4 pages of 8 rows each. Pages 0, 2, 3 have real
            Some(pp) => {
        .unwrap();
            .set_write_batch_size(8)
                Arc::new(Int32Array::from(qtys)),
    // Requires a schema with nullable columns to emit useful pruning.
}
    fn in_list_empty_match_prunes_everything() {
                let mut rg_can_match = vec![false; num];
        // that contains it.
        // price < 35 → full file would be [T,T,T,T,F]; subset [2,3,4] → [T,T,F]
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        assert_eq!(
        )
            for &cell_start in boundaries.iter().take(num_grid_cells) {
        let pruner = PagePruner::new(
//!
//! - `OR(x, y)` → `OR(rewrite(x), rewrite(y))`.
            &schema,
            col_converters.push((col, Some((converter, parquet_col_idx))));
///   - AND₃(df[00011], NOT[11111]) = [00011]
    Some(Arc::new(pruning_predicate))
                None => {
#[derive(Default, Clone)]
#[derive(Clone)]
            &schema,
        // Pages 0 and 1 survive, 2 and 3 pruned.
        for pair in col_offsets.windows(2) {
        ]);
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        // Build the pruning predicate under the SAME Arc identity used by the tree,
    // Our fixture columns are non-nullable, so null_counts are always
            return None;
        let tmp = NamedTempFile::new().unwrap();
    fn is_null_over_non_nullable_column_keeps_nothing() {
    }
        // price IN (5, 20) — picks pages 0 (contains 5) and 2 (contains
        &self,
            let vals: Vec<i32> = (i * 10..(i + 1) * 10).collect();
    // ─────────────────────────────────────────────────────────────────
        assert_eq!(run(Operator::Gt, 24), 8);
    /// Return per-page row counts for the given RG. Uses the first
    fn multi_col_and_intersects_pages() {
                    .collect();
        w.flush().unwrap();
                let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        Some(to_row_selection(keep, &grid_row_counts))
            if let Some(ref c) = m.pages_total {
    /// (schema drift: the predicate's Arrow schema has an extra column).
            None => {}
        assert_eq!(
            Field::new("tag", DataType::Utf8, false),
        // RG1 (100..131) keeps no page. 0 rows.
            ArrowReaderOptions::new().with_page_index(true),
    /// when split across grid cells.
                let mut rg_can_match = vec![true; num];
            false,
    #[test]
                    // Column not present in the parquet file. Provide
    use datafusion::arrow::array::{Int32Array, RecordBatch};
    use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
            page_pruning_unavailable: sm.page_pruning_unavailable.clone(),
        );
            .windows(2)
    /// (`price > 45`) that, as a plain `Predicate`, would prune to `[00001]` must
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            ],
            .set_dictionary_enabled(false)
            .set_write_batch_size(8)
    /// Predicate references a column absent from the parquet file
                        builder.append_null();
                // whole segments) whose min/max string bounds exclude the term even though
                    metadata,
    /// `original_expr` looks stats-prunable against the parquet column.
    ///          /       \          /     |     \          /       \
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            .set_max_row_group_size(10)
pub struct PagePruneMetrics {
        let converter = match StatisticsConverter::try_new(col.name(), arrow_schema, descr) {
///   - NOT(df[11000]) = [11111]  ← conservative: can't prune through negation
        let p6 = pred_leaf("price", Operator::Lt, 40, &schema); // [11110]
                let key = Arc::as_ptr(expr) as *const () as usize;
            let mins = converter
    fn multi_col_or_both_miss_prunes_everything() {
    }
    fn selection_alternating_pages_keeps_run_granularity() {
                    next_page_start = if page_idx + 1 < col_locs.len() {
                assert_eq!(
    // pruning would need a nullable-column fixture.
            schema.clone(),
        assert_eq!(count_rows_kept(&sel), 32);
    /// 32-row parquet with two int columns, one RG, four data pages of 8
        assert!(rg_index_to_pos.get(&0).is_none());
        // batch to close RG0.
            // Extreme byte budget forces a page flush after nearly
        let list = vec![lit_int(5), lit_int(15)];
                "PruningPredicate::try_new failed for {:?}: {}",
            &self.metadata,
            ArrowReaderOptions::new().with_page_index(true),
            spt.children[0].children[0].rg_can_match,
            ArrowWriter::try_new(tmp.reopen().unwrap(), parquet_schema, Some(props)).unwrap();
                        builder.append_null();
            BoolNode::Or(vec![
        self.col_stats
        let spt = StatsPruneTree::build_from_bool_node(
                }
        assert_eq!(
        let tags_refs: Vec<&str> = tags.iter().map(String::as_str).collect();
        assert_eq!(spt.rg_can_match, vec![false, false, false, false, true]);
        let batch1 = RecordBatch::try_new(
        // price < 10 → pages 0, 1 (max of page 1 is 15, min is 8 < 10).
                // to the peer backend rather than trusting raw-string stats.
        // by writing batch1 with 8-row batches and batch2 with 16-row
        let key = Arc::as_ptr(&expr) as *const () as usize;
        // OR₁/p3
            .map(|arr| Arc::new(arr) as ArrayRef);
    #[test]
                assert_eq!(count_rows_kept(&sel), 32);
        }
        .unwrap();
        // for all 4 pages). After merging, one run of `select(32)`.
    }
        )]));
        );
                last.row_count += selector.row_count;
    }
        let (pruner, schema, _) = two_col_fixture();
        // OR₁/AND/p2
        };
            };
            // Get the raw per-page stats for this column
        let expr =
                boundary_set.insert(loc.first_row_index);
            Ok(arr) => arr,
            count_rows_kept(&sel0),
            .windows(2)
        assert_eq!(run_count(&sel), 1, "single skip run covers the whole RG");
        // to keep everything → Some with 32 rows. Both are correct.
        Arc::new(BinaryExpr::new(l, op, r))
//! itself is built once per query at [`build_pruning_predicate`].
        schema: &SchemaRef,
        .iter()
        }
        // price >= 30 → full file would be [F,F,F,T,T]; subset [2,3,4] → [F,T,T]
    }
    fn pred_leaf(
            // directly. Rule:
impl PagePruneMetrics {
    }
            // page is "all null": `null_count == page_row_count`).
            }
}
            .set_write_batch_size(8)
        match pp {
        let tree = BoolNode::And(vec![p1.clone(), p2.clone()]);
                    continue;
        let pos = rg_index_to_pos.get(&2).unwrap();
    #[test]
        let mut col_converters: Vec<(
        None
/// that grid cell.
                native_bridge_common::log_debug!(
        // (0..31) keeps only page 0 (max=7 ≥ 4, but page 1 has min=8
        let mut w =
                p3.clone(),
    ///
        )> = Vec::new();
    #[test]
        let plain = StatsPruneTree::build_from_bool_node(
            &tree,
        let (_, schema, _) = two_col_fixture();
        op: Operator,
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props_rg0)).unwrap();
        )
                    }
    pub pages_pruned: Option<datafusion::physical_plan::metrics::Count>,
                        Self::build_from_bool_node(
            &boundaries,
        assert_eq!(count_rows_kept(&sel), 0);
        rg_idx: usize,
        let expr: Arc<dyn PhysicalExpr> = Arc::new(IsNullExpr::new(col("price", 0)));
            w.write(&batch).unwrap();
        let arc_meta = meta.metadata().clone();
        Some(Arc::new(arr) as ArrayRef)
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
        };
    col_stats: HashMap<String, (ArrayRef, ArrayRef, Option<ArrayRef>)>,
        let batch2 = RecordBatch::try_new(
//!
                    for (r, c) in rg_can_match.iter_mut().zip(child.rg_can_match.iter()) {
            .set_statistics_enabled(EnabledStatistics::Chunk)
    use tempfile::NamedTempFile;
        let grid_row_counts: Vec<usize> = boundaries
            let grid_nulls: Option<ArrayRef> = page_null_counts.map(|page_ncs| {
                Arc::new(StringArray::from(tags_refs)),
            rg_idx,
    fn multi_rg_different_page_layouts_per_rg() {
}
        assert_eq!(spt.children.len(), 3);
            let mut grid_page_indices = Vec::with_capacity(num_grid_cells);
/// `StreamMetrics` build one via [`PagePruneMetrics::from_stream_metrics`].
        // very large values. A small page-size budget forces `tag`
            &datafusion::physical_expr::expressions::Column,
        // Start the writer with RG0 props and flush after the first
                    .unwrap();
        let num_rows = rg_meta.num_rows() as usize;
    pub fn page_row_counts(&self, rg_idx: usize) -> Option<Vec<usize>> {
    ///   selection means no page can match; a single whole-RG `select`
            count_rows_kept(&sel),
                }
fn eval_leaf(
 */
    }
        let tmp = NamedTempFile::new().unwrap();
            24,
            vec![false, true, true, true, true]
            BoolNode::Predicate(expr) => {
            let pruned = keep.iter().filter(|k| !**k).count();
    // different RGs of the same metadata handle each correctly.
        let expr: Arc<dyn PhysicalExpr> = Arc::new(IsNotNullExpr::new(col("price", 0)));
            .metadata()
        let parquet_schema = Arc::new(Schema::new(vec![Field::new(
                .data_page_mins(column_index, offset_index, [&rg_idx])
        let stats = CommonGridPageStats::build(
        let spt = StatsPruneTree::build_from_bool_node(
        // 5 RGs: price [0..9], [10..19], [20..29], [30..39], [40..49]
                    None => vec![true; num],
        assert_eq!(rc1.iter().sum::<usize>(), 32, "RG1 row count");
            _ => out.push(selector),
pub struct PagePruner {
    /// ```text
        );
        assert_eq!(
        // not just because the lookup missed).
                e
        // Resolve against the segment's own schema (see eval_leaf): the full table
            }
        // Root
            ArrowReaderOptions::new().with_page_index(true),
        );
    /// rows each. Page-level stats enabled.
            let expr = bin(col("price", 0), op, lit_int(v));
                    seg_arrow_schema,
        // written yet" (schema evolution).
        assert!(
        assert_eq!(spt.rg_can_match[*pos], true);
            .set_data_page_row_count_limit(8)
//! - `IN`, `LIKE`, `IS NULL`, etc. handled by `PruningPredicate`'s own
 * compatible open source license.
        let seg_arrow_schema = Arc::clone(&self.seg_arrow_schema);
    }
                        .field_with_name(col.name())
        assert_eq!(run(Operator::LtEq, 7), 8);
                    children: vec![annotated_child],
            &arc_meta,
/// Page statistics aligned to a common grid across all referenced columns.
    }
    }
impl PruningStatistics for RgLevelStats {
        }
            .set_max_row_group_size(32)
        let rg_offsets = offset_index.get(rg_idx)?;
                            schema,
    }
                c.add(keep.len());
        ]));
        for col in &columns {
        use datafusion::arrow::array::Int32Array;
    }
            "price",
        w.write(&batch2).unwrap();
            let page_null_counts = converter
        assert_eq!(arc_meta.num_row_groups(), 5);
/// Per-call counter bundle for [`PagePruner::prune_rg`]. Callers with
            //   - page null_count == 0        → cell null_count = 0
        let num_rows = rg_meta.num_rows() as usize;
        .unwrap();
                    if page_nc == 0 {
            &rg_indices,
        let pp = build_pruning_predicate(&expr, schema.clone()).unwrap();
                RecordBatch::try_new(schema.clone(), vec![Arc::new(Int32Array::from(vals))])
        let q_lt_110 = bin(col("qty", 1), Operator::Lt, lit_int(110));
            .set_statistics_enabled(EnabledStatistics::Page)
///   - Root AND(OR₁[01101], OR₂[11111], AND₃[00011]) = [00001]
        assert_eq!(meta.metadata().num_row_groups(), 2);
            .map(|i| format!("{}{}", i, "x".repeat(4000)))
    /// predicate (wrapped as a [`PruningPredicate`]).
    }
            RowSelector::skip(rc)
    /// absolute RGs 2,3,4. Consumers use a reverse map to translate.
            count_rows_kept(&sel)
                Some(cv) => cv,
            ArrowReaderOptions::new().with_page_index(true),
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        .filter_map(|&idx| metadata.row_groups().get(idx))
        }
            }
    pub children: Vec<StatsPruneTree>,
        assert_eq!(
use datafusion::parquet::arrow::arrow_reader::{RowSelection, RowSelector};
        assert_eq!(spt.children[2].children.len(), 2);
        let c = col("price", 0);
        // Absolute RG 2 should map to position 0 → can_match = false
        .unwrap();
        // treats as "can't prove false" → keeps the page (conservative).
                    schema,
        col_name: &str,
            .get(column.name())
        // Early-exit if the file lacks a column/page index; without
/// Precomputed tree of per-RG match vectors built from column statistics.
                    .map(|i| *i as u32)
        // Verify page_row_counts returns a valid layout for each RG.
    // ─────────────────────────────────────────────────────────────────
            datafusion::physical_expr::expressions::in_list(c, list, &false, &schema).unwrap();
        );
    use std::sync::Arc;
/// compacted `RowSelection`. Adjacent runs of the same decision are
        let tmp = NamedTempFile::new().unwrap();
        // to flush frequently while `price` stays as one page.
        );
    /// Nullable column with an all-null page. Verify that `IS NULL`
        );
            ArrowReaderOptions::new().with_page_index(true),
    }
                    }
        .unwrap();
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
        // has 8,9 < 10, so both survive. 16 rows.
                native_bridge_common::log_debug!(
                    .map(|c| {
            &self.schema,
        // Build a common page grid from the union of all referenced
            None => { /* always_true — no pruning needed */ }
                        // in any sub-cell are null too.
            &BoolNode::Predicate(Arc::clone(&expr)),
                    // see type-compatible nulls (treated as "unknown"
    // Multi-RG: the pruner is stateless per RG; repeated calls on
                    continue;
                        *r &= c;
                );
        assert_eq!(
//! each array is read once per column per predicate. `PruningPredicate`
        // so page 1's min≮4 → pruned). 8 rows.
            &schema,
//! - `a = v` → `a_min ≤ v AND a_max ≥ v` (page could contain `v`).
        let expr =
    let stats = RgLevelStats {
            .find(|locs| !locs.is_empty())?;
        // price >= 24 → page 3 (24..31). 8 rows.
        num_rgs: num,
        w.write(&batch).unwrap();
    // ─────────────────────────────────────────────────────────────────
impl StatsPruneTree {
    // (parquet crate `parquet_column`), so passing the full schema reads the wrong /
        );
        let file_schema = Arc::new(Schema::new(vec![
            // `take` propagates correctly.
    }
            .set_max_row_group_size(32)
        .unwrap();
            };
    }
            .build();
        // false regardless of `extra`, so those pages are still pruned.
    /// A `DelegationPossible` leaf must NOT be stats-pruned, even when its
}
        // prices: 0..32 (pages: 0..8, 8..16, 16..24, 24..32)
                }
        let p3 = pred_leaf("price", Operator::Gt, 45, &schema); // [00001]
        Some(counts)
                            c,
        let pp = build_pruning_predicate(&expr, schema).unwrap();
/// per query by [`build_pruning_predicate`].
    #[test]
///     [01100]    [00001] [00100] [11111] [11110] [00011]   [11111]
    #[test]
                .ok()?;
                    } else {
        let mut leaf_predicates: HashMap<usize, Arc<PruningPredicate>> = HashMap::new();
        use datafusion::physical_expr::expressions::IsNotNullExpr;
            .iter()
/// than falsely pruning. This means a stats extraction failure, missing column,
    // but `build_pruning_predicate` accepts arbitrary PhysicalExprs, so
    fn num_containers(&self) -> usize {
                // Performance-delegated leaves are all-true, exactly like a Collector.
 * this file be licensed under the Apache-2.0 license or a
                    // Column is in Arrow schema but absent from the
        // 5 RGs: price [0..9], [10..19], [20..29], [30..39], [40..49]
            &tmp.reopen().unwrap(),
                    }
        let props = WriterProperties::builder()
        }
            left, op, right,
        let expr = bin(col("price", 0), Operator::Lt, lit_int(4));
            //     (no nulls anywhere in the page → none in any sub-cell)
        let rg_offsets = offset_index.get(rg_idx)?;
        ]));
///
        let tmp = NamedTempFile::new().unwrap();
    use super::*;
        // schema misaligns StatisticsConverter's positional column lookup under
        let tree = BoolNode::And(vec![
//! outside `{5}` AND `b` is entirely outside `{10}`. The per-page stats
                while page_idx + 1 < col_locs.len() && cell_start >= next_page_start {
        // Keep 2 pages × 8 rows = 16.
            &tree,
            &leaf_predicates,
        let pruner = PagePruner::new(&schema, Arc::clone(&arc_meta), schema.clone());
            }
            vec![Arc::new(Int32Array::from((0..32).collect::<Vec<i32>>()))],
        ]));
        Arc::new(PhysColumn::new(name, idx))
                if let Some(last) = col_locs.last() {
//! homegrown per-filter range-intersection logic, which silently dropped
            eval_leaf(&pp, &md, &table_schema, &[0], &file_arrow_schema),
        assert_eq!(
        let expr =
                        i64::MAX
///
            return None;
use std::collections::HashMap;
        assert_eq!(
                let key = Arc::as_ptr(expr) as *const () as usize;
        // cell keeps → 32 rows. Same shape, opposite outcome.
        Self {
    /// layout. Verify the pruner reads each RG's own offset index
///      /   \              /   \                              |
                    children: annotated_children,
                    children: vec![],
        let p7 = pred_leaf("price", Operator::Gt, 30, &schema); // [00011]
                .data_page_maxes(column_index, offset_index, [&rg_idx])
    if col_stats.is_empty() {
            .set_max_row_group_size(10)
        let pruner = PagePruner::new(&schema, meta.metadata().clone(), schema.clone());
        // Tree: AND(OR(AND(p1,p2), p3), OR(AND(p4,p5), Collector, p6), AND(p7, NOT(p8)))
                Self {
            }
        )
        }
//!
    }
                    .map(|c| {
        let pruner = PagePruner::new(&schema, meta.metadata().clone(), schema.clone());
use datafusion::parquet::arrow::arrow_reader::statistics::StatisticsConverter;
        w.close().unwrap();
            RowSelector::select(rc)
            Field::new("name", DataType::Int32, false),
    // ─────────────────────────────────────────────────────────────────
                    })
        self.col_stats
                return None;
        node: &super::bool_tree::BoolNode,
    if rg_metas.len() != num {
        // with the public API; fall back to asserting that each RG's
    pruning_predicate: &PruningPredicate,
        match node {
        let props_rg0 = WriterProperties::builder()
        let tmp = NamedTempFile::new().unwrap();
                    // for every grid cell). Null_counts is `None` so
            vec![false, false, false, true, true]
                );
    ) -> crate::indexed_table::bool_tree::BoolNode {
    /// Per-RG: `false` means this subtree provably can't match that RG.
    ) -> Option<Self> {
        // price <= 7 → page 0 only (max 7 ≤ 7; page 1 min 8 > 7). 8 rows.
        let schema = Arc::new(Schema::new(vec![Field::new(
    let mut out: Vec<RowSelector> = Vec::with_capacity(keep.len());
                let mut v = Vec::with_capacity(col_locs.len());
                }
        }
            .build();
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            .set_statistics_enabled(EnabledStatistics::Chunk)
        // batches so the effective page row count differs in each RG.
                BoolNode::And(vec![p4.clone(), p5.clone()]),
    pub fn new(
        let mut w =
    ///   evaluation error, etc.). Caller treats as "scan the whole RG."
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
        let q_gt_125 = bin(col("qty", 1), Operator::Gt, lit_int(125));
            parquet_schema.clone(),
use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
///                                [00001]
        let offset_index = parquet_metadata.offset_index()?;
            vec![true, true, true, true, true]
    }
    let mut col_stats: HashMap<String, (ArrayRef, ArrayRef, Option<ArrayRef>)> = HashMap::new();
    // ─────────────────────────────────────────────────────────────────
    /// - `None` — pruning isn't applicable (no page index on the RG,
            Field::new("neg", DataType::Int32, false),
            //   - otherwise                    → cell null_count = null (unknown)
        for i in 0..5i32 {
    grid_row_counts: Vec<usize>,
    fn stats_prune_tree_delegation_possible_is_all_true() {
        let arc_meta = meta.metadata().clone();
                Self {
        // `price > 100` is definitively false for all rows; every grid
            .get(column.name())
            &datafusion::physical_expr::expressions::Column,
            let vals: Vec<i32> = (i * 10..(i + 1) * 10).collect();
            .set_max_row_group_size(32)
        // Verify consumer-side reverse map lookup works correctly:
        let table_schema = Arc::new(Schema::new(vec![
    }
        _column: &Column,
        assert_eq!(
/// ```
        let mut leaf_predicates: HashMap<usize, Arc<PruningPredicate>> = HashMap::new();
            &schema,
    fn always_true_predicate_yields_none() {
        r: Arc<dyn PhysicalExpr>,
        use super::bool_tree::BoolNode;
    #[test]
        let tmp = NamedTempFile::new().unwrap();
        let num = rg_indices.len();
        sel.iter().count()
//! - Anything it can't translate becomes `Literal(true)`. Safe
                    "StatsPruneTree: DelegationPossible node → all-true (peer-backend semantics, raw-string stats unsound)"
            let mut page_idx = 0usize;
            ArrowReaderOptions::new().with_page_index(true),
    // no column when the segment's schema is narrower or reordered (dynamic-mapping
    // ─────────────────────────────────────────────────────────────────
            .map(|i| if (8..16).contains(&i) { None } else { Some(i) })
        let meta =
            let col_locs = match rg_offsets.get(parquet_col_idx) {
            return None;
        )]));
    #[test]
                    // do. Treat as absent (fills with nulls).
        // Fixture columns are non-nullable; IS NULL can never be true,
        // Verify bottom-up:
                    rg_can_match,
                use datafusion::arrow::array::UInt64Array;
        let schema = Arc::new(Schema::new(vec![
        let (pruner, schema, _) = two_col_fixture();
        use datafusion::arrow::array::{Int32Array, RecordBatch};
    fn row_counts(&self) -> Option<ArrayRef> {
    #[test]
            num_grid_cells,
        if arrow_schema.index_of(col.name()).is_err() {
        return vec![true; num];
    /// keeps that page (null_count == row_count) and `IS NOT NULL`
    ) -> Self {
    }
        // AND₃/p7
            );
        let run = |op: Operator, v: i32| -> usize {
    #[test]
        }
            spt.children[1].rg_can_match,
        let expr = bin(col("price", 0), Operator::Lt, lit_int(-100));
        let rg_offsets = offset_index.get(rg_idx)?;
    ///                /                  |                  \
                }
                    page_idx += 1;
                let rg_can_match = match leaf_predicates.get(&key) {
}
                let annotated_child = Self::build_from_bool_node(
        let collector = BoolNode::Collector { annotation_id: 0 };
            w.write(&batch).unwrap();
    ) -> Option<RowSelection> {
    }
        // Sanity: as a plain Predicate the same expr prunes to [00001].
                            leaf_predicates,
            if let Some(ref c) = m.pages_pruned {
        .unwrap();
        let prices: Vec<i32> = (0..32).collect();
            // disable it for this test.
            metadata,
    pub fn build_from_bool_node(
        let sel1 = pruner.prune_rg(&pp, 1, None).unwrap();
        col_stats.insert(col.name().to_string(), (min_arr, max_arr, null_counts));
        assert_eq!(rc0.iter().sum::<usize>(), 32, "RG0 row count");
        // OR₁/AND/p1
        // absent or had no page index), pruning can't do anything useful.
        let num_rows = rg_meta.num_rows() as usize;
                Arc::new(Int32Array::from(vec![0, 5, 10, 17])),
            Field::new("neg", DataType::Int32, false),
        let (pruner, schema, _) = two_col_fixture();
            false,
            &schema,
                        // can't attribute null_count exactly. Mark as
        ));
        assert_eq!(
        assert_eq!(count_rows_kept(&sel), 16);
            .map(|(_, m, _)| Arc::clone(m))
        // price < -1 OR qty > 999: neither can hold on any page.
        let pp = build_pruning_predicate(&expr, schema).unwrap();
    /// stores the raw source string with lexicographic min/max stats. Evaluating
            ArrowReaderMetadata::load(&tmp.reopen().unwrap(), ArrowReaderOptions::new()).unwrap();
                Err(_) => {
    }
        // price > 50: RG0 (0..31) → nothing, RG1 (100..131) → all.
                    rg_can_match,
            let pp = build_pruning_predicate(&expr, schema.clone()).unwrap();
        );
        let mut w =
struct RgLevelStats {
    pub pages_total: Option<datafusion::physical_plan::metrics::Count>,
        let rg_meta = self.metadata.row_groups().get(rg_idx)?;
    #[test]
                }
                            schema,
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        // < 0), so every page kept.
            }
            Some(last) if last.skip == selector.skip => {
        let prices: Vec<i32> = (0..32).collect();
        let expr: Arc<dyn PhysicalExpr> = Arc::new(IsNullExpr::new(col("x", 0)));
/// Subtree vectors enable short-circuiting: for RG0, AND₃=[0....] so the
                    col_converters.push((col, None));
        let sel1 = pruner.prune_rg(&pp, 1, None).unwrap();
    /// Keyed by column name.
                        *r |= c;
            // part of a page, the page's null count can't be attributed
        }
        let pp = build_pruning_predicate(&expr, schema).unwrap();
        w.write(&batch).unwrap();
                    let page_nc = page_ncs.value(pidx) as usize;
/// simply not be skipped.
            Field::new("severity", DataType::Int32, false),
        let props = WriterProperties::builder()
    #[test]
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
            &tmp.reopen().unwrap(),
            vec![false, true, true, false, true]
            &rg_indices,
    ///       AND         df     AND     luc     df      df        NOT
                Ok(c) => c,
                let sel = pruner.prune_rg(&pp, 0, None).unwrap();
    #[test]
        }
        // layout is read from its own offset index entry. Even if the
use datafusion::physical_expr::PhysicalExpr;
        parquet_metadata: &ParquetMetaData,
        w.close().unwrap();
            vec![
        Ok(pp) => pp,
        );
/// Bottom-up:
                let annotated_children: Vec<_> = children
        let (pruner, schema, _) = two_col_fixture();
        }
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
        Ok(keep) => keep,
    pub page_pruning_unavailable: Option<datafusion::physical_plan::metrics::Count>,
    }
    }
        w.write(&batch1).unwrap();
            .map(|(m, _, _)| Arc::clone(m))
        );
        let p_lt_5 = bin(col("price", 0), Operator::Lt, lit_int(5));
            );
        );
            vec![Arc::new(Int32Array::from((0..32).collect::<Vec<i32>>()))],
        let arc_meta = meta.metadata().clone();
                    c.add(1);
            let maxs = converter
        );
        );
        // the common grid. Each grid cell inherits stats from the page
/// # Example: 5 RGs, 9 leaves
    ///   means every page is kept.
    ) -> Self {
            });
///                                  AND
    // ─────────────────────────────────────────────────────────────────
    if columns.is_empty() {
}
                        c.add(1);
            Ok(k) => k,
            let parquet_col_idx = match converter.parquet_column_index() {
    /// Verifies that `build_from_bool_node` works correctly when
        assert_eq!(run(Operator::Eq, 5), 8);
            //   - page null_count == page_row_count → cell null_count = cell_row_count
        let col_offsets = rg_offsets
        let right: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(v))));
            DataType::Int32,
        let batch1 = RecordBatch::try_new(
        let offset_index = self.metadata.offset_index()?;
    fn run_count(sel: &RowSelection) -> usize {
            // the strings to small indices, defeating the budget, so
    /// We model this with an int column so the fixture stays simple: a predicate
        let pp = build_pruning_predicate(&expr_false, schema.clone()).unwrap();
        // Build a 2-RG parquet so we can exercise rg_idx=0 and rg_idx=1
    fn contained(
            .get(column.name())
                    v.push(num_rows - last.first_row_index as usize);
/// stats-based pruning is unsound (superset inverted = subset).
        assert_eq!(
        if keep.len() != grid_row_counts.len() {
/// pruning expression itself lives in a [`PruningPredicate`] built once
        // price = 5: only page 0 (0..8) overlaps.
        let spt = StatsPruneTree::build_from_bool_node(
                    continue;
        for node in [&p1, &p2] {
        self.grid_row_counts.len()
                for child in &annotated_children {
/// ```text
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            .set_statistics_enabled(EnabledStatistics::Chunk)
                    let maxs = datafusion::arrow::array::new_null_array(&data_type, num_grid_cells);
        w.close().unwrap();
            .collect();
                let pp = build_pruning_predicate(expr, schema.clone()).unwrap();
            datafusion::parquet::arrow::parquet_to_arrow_schema(
    // a DIFFERENT real file column (`neg`, all-negative). The always-true `severity >= 0`
            bin(col("price", 0), Operator::Lt, lit_int(5)),
        //   AND₃(p7[00011], NOT[11111]) = [00011]
            .get(column.name())
        //   OR₁(AND[01100], p3[00001]) = [01101]
        // For RG1, write in a single larger batch so it hits a bigger
//! Page-level pruning using parquet page statistics.
        col_converters: &[(
        let pp = build_pruning_predicate(&expr_true, schema);
        let mut w =
            &tmp.reopen().unwrap(),
                            metadata,
            BoolNode::And(children) => {
        )]));
        // qtys:   100..132 (pages: 100..108, 108..116, 116..124, 124..132)
        // 20), skips pages 1 and 3. Two alternating patterns → four
            RecordBatch::try_new(schema.clone(), vec![Arc::new(Int32Array::from(vals))]).unwrap();
        let rg_indices: Vec<usize> = vec![2, 3, 4];
            spt.children[0].rg_can_match,
    // Edge case coverage added for common grid correctness.
                        builder.append_value(cell_rc as u64);
            &leaf_predicates,
            counts.push((pair[1].first_row_index - pair[0].first_row_index) as usize);
            &schema,
//!   conservative fallback: can't prune → assume page matches.
/// Per-row-group page pruner. Owns schema + metadata references; the
        w.close().unwrap();
            Field::new("price", DataType::Int32, false),
            "IS NOT NULL must prune the all-null page"
        let expr_true = bin(col("price", 0), Operator::GtEq, lit_int(0));
            &predicate_schema,
                );
        let columns = collect_columns(pruning_predicate.orig_expr());
            // `null_pages = true` entries into Arrow nulls, which
    /// rather than reusing one RG's layout for both.
        )
/// Each node shows its `rg_can_match` bitset: `[RG0, RG1, RG2, RG3, RG4]`.
        // Position 0 → absolute RG 2 (price [20..29]): p1=T, p2=F → AND=F
        let p1 = pred_leaf("price", Operator::Lt, 35, &schema);
//! - `NOT(x)` → `NOT(rewrite(x))` (via its own rules).
        &self,
        v: i32,
        num_grid_cells: usize,
        let offset_index = self.metadata.offset_index()?;
            &rg_indices,
//! unsupported expression shapes and could mis-prune `OR(...)` inside a
        // values (0..7, 16..23, 24..31); page 1 (rows 8..15) is all-null.
        // 5 RGs: price [0..9], [10..19], [20..29], [30..39], [40..49]
        // runs: select/skip/select/skip.
        // Note: `price >= 0` on a column with min=0 may collapse to
//! # Correctness
    }
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
    /// different columns in the same RG may have different page layouts,
    ///
        let tmp = NamedTempFile::new().unwrap();
        let expr: Arc<dyn PhysicalExpr> = Arc::new(BinaryExpr::new(
    /// vector should be 3 elements long, indexed 0..2 mapping to
            Some(pp) => {
            .build();
        assert_eq!(
                        )
    }
        let num_grid_cells = boundaries.len() - 1;
            // Per-page row counts for this column (needed to know when a
            schema.clone(),
            .set_data_page_row_count_limit(8)
                    // is "unknown" but others still prune.
            price_pages != tag_pages,
            }
        // mapping correctly carries min/max through cells created by
                grid_page_indices.push(page_idx);
    ///                                [00001]
            col_stats,
                        col_locs[page_idx + 1].first_row_index
                    .iter()
            //     `PruningPredicate` treats a null as "unknown" and falls
            // whole page, not to any sub-range of it. When a cell is only
        // Child 2: AND₃
        let tmp = NamedTempFile::new().unwrap();
    pub fn from_stream_metrics(sm: &crate::indexed_table::metrics::StreamMetrics) -> Self {
            };
            {
 *
        )]));
            }
            // replicate that page's stats to the grid cell.
        );
        // Child 0: OR₁
        _column: &Column,
use datafusion::arrow::datatypes::SchemaRef;
 * SPDX-License-Identifier: Apache-2.0
        let (pruner, schema, _) = two_col_fixture();
        let expr =
    fn null_counts(&self, column: &Column) -> Option<ArrayRef> {
        let qtys: Vec<i32> = (100..132).collect();
        // cell inherits stats from the single price page (min=0, max=31)
        let c = col("price", 0);
            schema.clone(),
        assert_eq!(arc_meta.num_row_groups(), 5);
        // File has only `price`. The predicate also references `extra`,
        // still allowing other columns to prune.
    /// We verify that a single-column predicate on each column still
            &schema,
        l: Arc<dyn PhysicalExpr>,
///   - OR₁(AND[01100], df[00001]) = [01101]
                    leaf_predicates,
        // Left side keeps pages 0, 3; right side keeps page 3 (24..32).
            return None;
                    for (r, c) in rg_can_match.iter_mut().zip(child.rg_can_match.iter()) {
            BoolNode::Or(vec![
    }
    /// Per-column min/max/null arrays, all of length `num_grid_cells`.
        // Prune `price < 4` against each RG independently. RG0
        // OR₁/AND
            Operator::And,
            .set_max_row_group_size(32)
            "price-side pruning still applies even though extra is absent"
            spt.rg_can_match,
            Field::new("price", DataType::Int32, false),
            vec![false, false, false, false, true]
    /// verify `to_row_selection` merges adjacent same-decision pages.
        );
            .set_data_page_row_count_limit(8)
            Option<(StatisticsConverter<'_>, usize)>,
        use datafusion::physical_expr::expressions::IsNullExpr;
    #[test]
                p6.clone(),
        let rg_index_to_pos: HashMap<usize, usize> = rg_indices
        return vec![true; num];
        boundaries: &[i64],
        );
        Some(Arc::new(arr) as ArrayRef)
            Err(e) => {
        // the *other* column's boundaries.
        seg_arrow_schema: &SchemaRef,
        let mut col_stats = HashMap::new();
        let arc_meta = meta.metadata().clone();
        let left: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new(col_name, col_idx));
    schema: SchemaRef,
        .unwrap();
        // RG1: 32 rows, 16-row pages → 2 pages.
    /// so this is an approximation good enough for counting.
        // this simulates "predicate knows about a column we haven't
        // May be always-true (no pruning possible) → None, or may prune
        self.col_stats
    fn not_in_list_prunes_via_and_of_neq() {
            .map(|(pos, &idx)| (idx, pos))
            .collect();
                        .map(|f| f.data_type().clone())
///       AND         df     AND     luc     df      df        NOT
}
        use datafusion::arrow::array::StringArray;
    }
    /// Per-segment arrow schema derived from parquet footer, used for
        let meta = ArrowReaderMetadata::load(
                        // unknown so `PruningPredicate` stays conservative.
/*
        let keep = match pruning_predicate.prune(&stats) {
        arrow_schema: &SchemaRef,
        let price_pages = oi[0][0].page_locations().len();
        self.col_stats
    /// those stats here wrongly prunes RGs (and whole segments) whose string
                i64::MAX
        let oi = arc_meta.offset_index().expect("offset index");
}
                Self {
        w.write(&batch).unwrap();
        )
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
                    }
                    rg_can_match,
        // price IN (5, 15). price=5 → page 0, price=15 → page 1.
        assert_eq!(spt.children[0].children.len(), 2);
        let sel = pruner.prune_rg(&pp, 0, None).unwrap();
            .set_statistics_enabled(EnabledStatistics::Page)
            ]),
        let sel0 = pruner.prune_rg(&pp, 0, None).unwrap();
            schema.clone(),
        let (pruner, schema, _) = two_col_fixture();
    fn single_col_eq_prunes_to_overlapping_page() {
    ///
            original_expr: Arc::clone(&expr),
        let c = col("price", 0);
            .build();
        if let Some(m) = metrics {
/// Used for segment-level, RG-level, and subtree-level pruning.
                // peer backend's semantics — for analyzed text/match_only_text fields
        // with the same `PagePruner`.
        let mut counts = Vec::with_capacity(col_offsets.len());
        let p = bin(col("price", 0), Operator::Lt, lit_int(-1));
        assert_eq!(count_rows_kept(&sel), 0);
        return None;
        //   OR₂(AND[00100], luc[11111], p6[11110]) = [11111]  ← luc dominates
/// Conservative on any error: returns `true` (can-match) for every RG rather
    fn selection_merges_adjacent_same_decision_pages() {
        }
            bin(col("qty", 1), Operator::Gt, lit_int(125)),
///
}
        pruning_predicate: &PruningPredicate,
                    .unwrap();
            .collect();
        let sel0 = pruner.prune_rg(&pp, 0, None).unwrap();
            &rg_indices,
        for node in [&p1, &p2, &p3, &p4, &p5, &p6, &p7, &p8] {
                // equality is a *token* match, but parquet column stats are lexicographic
            }
    /// Matches the tree from the doc comment on `StatsPruneTree`:
        let meta = ArrowReaderMetadata::load(
        }
    }
        seg_arrow_schema: SchemaRef,
        assert_eq!(count_rows_kept(&sel0), 0, "RG0 fully pruned");
    if num == 0 {
            vec![Arc::new(Int32Array::from((100..132).collect::<Vec<i32>>()))],
///    df     df          df     df                           df
            count_rows_kept(&sel),
        if columns.is_empty() {
        let rg_indices: Vec<usize> = (0..5).collect();
        // change writer props between flushes.
    // ─────────────────────────────────────────────────────────────────
//! One `PruningPredicate::prune` call per RG. Internally evaluates the
            "AND of disjoint page sets prunes everything"
                .ok()?;
        // Position 1 → absolute RG 3 (price [30..39]): p1=T, p2=T → AND=T
            .and_then(|(_, _, n)| n.clone())
    }
//! conjunct.
                None => {
                // A `DelegationPossible` predicate (e.g. `field = 'laptop'`) carries the
        // Columns referenced by the predicate that are NOT present in
                    .collect::<Vec<_>>(),
            expr
        // rg_can_match is 3 elements (one per chunk RG), relative indexing.
        //
        let mut boundary_set = std::collections::BTreeSet::new();
    #[test]
            vec![false, true, true, false, false]
            false,
        metadata: Arc<ParquetMetaData>,
        // AND(p1, p2) on subset → [T,T,F] & [F,T,T] = [F,T,F]
        // price NOT IN (-100, -200) — all pages match (nothing in RG is
        }
    let columns = collect_columns(pruning_predicate.orig_expr());
                            seg_arrow_schema,
        let rc1 = pruner.page_row_counts(1).unwrap();
            ArrowReaderMetadata::load(&tmp.reopen().unwrap(), ArrowReaderOptions::new()).unwrap();
}
    ) -> Option<BooleanArray> {
        // qty>125 keeps page 3 (124..132). Union keeps pages 0 and 3.
            .enumerate()
    fn eval_leaf_resolves_stats_against_segment_schema_under_drift() {
            BoolNode::Collector { .. } => {
            BoolNode::DelegationPossible { .. } => {
                for child in &annotated_children {
            let col_locs = rg_offsets.get(*parquet_col_idx)?.page_locations();
    let descr = metadata.file_metadata().schema_descr();
            .build();
        assert_eq!(
                    // IS NULL / IS NOT NULL also can't prune.
        let p8 = pred_leaf("price", Operator::Lt, 15, &schema); // [11000]
    // parquet file, so resolving `severity` positionally against the table schema lands on
        // As a DelegationPossible leaf, the same expr must NOT prune.
        // IS NOT NULL: page 1 (all-null) should be pruned → 24 rows kept.
//!
        let pos = rg_index_to_pos.get(&3).unwrap();
    /// positional column resolution in statistics-based pruning.
        leaf_predicates: &HashMap<usize, Arc<PruningPredicate>>,
        // price != 5 → likely all pages (not prunable: every page has
        )
        assert_eq!(arc_meta.num_row_groups(), 5);
        metadata: &ParquetMetaData,
            count_rows_kept(&sel),
                    // schema so `PruningPredicate`'s comparison kernels
        if num_grid_cells == 0 {
///
        // Position 2 → absolute RG 4 (price [40..49]): p1=F, p2=T → AND=F
        let batch2 = RecordBatch::try_new(
            plain.rg_can_match,
            return None;
            continue;
        assert_eq!(count_rows_kept(&sel1), 32, "RG1 fully kept");
        } else {
            schema.clone(),
                Some(idx) => idx,
        // `PruningPredicate` treats them as unknown (conservative) while
            pages_pruned: sm.pages_pruned.clone(),
        use datafusion::physical_expr::expressions::IsNullExpr;
            schema: schema.clone(),
                // Advance page_idx until this cell falls within the page
            }
        );
        // ~4 KiB per tag so the byte budget triggers many page flushes.
    ///    df     df          df     df                           df
            "fixture must produce misaligned per-column page layouts; got price={} tag={}",
                    if let Some(ref c) = m.page_pruning_unavailable {
/// Convert a per-page keep/skip decision + per-page row counts into a
///           [01101]              [11111]              [00011]
                    "price >= 0 keeps every grid cell"
        boundary_set.insert(0i64);
            Option<(StatisticsConverter<'_>, usize)>,
            .set_statistics_enabled(EnabledStatistics::Page)
            let grid_mins = take(&mins, &indices, None).ok()?;
        self.col_stats
    let arrow_schema = seg_arrow_schema.as_ref();
                    // all-null min/max arrays typed to match the Arrow
    #[test]
struct CommonGridPageStats {
            vec![true, true, false, false, false]
        let rc0 = pruner.page_row_counts(0).unwrap();
            .build();
        // Chunk only has RGs [2, 3, 4] (prices [20..49])
        // RG0: 32 rows, 8-row pages → 4 pages.
        use datafusion::physical_expr::expressions::IsNotNullExpr;
    /// to verify the full shape and bitset propagation.
                for (cell_idx, &pidx) in grid_page_indices.iter().enumerate() {
        let props = WriterProperties::builder()
        use datafusion::arrow::array::Int32Array;
            spt.children[2].children[1].rg_can_match,
        // `price >= 0` is definitively true for all rows; every grid
        use datafusion::arrow::datatypes::{DataType, Field, Schema};
            Ok(c) => c,
        let selector = if k {
            .build();
                let annotated_children: Vec<_> = children
                    continue;
    }
        // values != 5). 32 rows.
            if let BoolNode::Predicate(expr) = node {
            };
        Self {
            ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), Some(props)).unwrap();
        let tmp = NamedTempFile::new().unwrap();
        let list = vec![lit_int(-10), lit_int(-20), lit_int(-30)];
        schema: &SchemaRef,
    /// Multi-RG fixture where each RG has a different per-page row
            Err(_) => continue,
    }
            }
///   - OR₂(AND[00100], luc[11111], df[11110]) = [11111]  ← luc dominates
            schema.clone(),
        assert_eq!(
            .build();
        //   AND(p1[11100], p2[01111]) = [01100]
            .collect();
    }
        let (pruner, schema, _) = two_col_fixture();
    schema: SchemaRef,
/// Legend: `df` = Predicate leaf (parquet column stats), `luc` = Collector (always true).
            vec![false, false, false, true, true]
        let predicate_schema = Arc::new(Schema::new(vec![
//! `OR(a=5, b=10)` correctly prunes a page where `a` is entirely
            vec![true, true, true, true, true],
        assert_eq!(spt.rg_can_match, vec![false, true, false]);
use datafusion::physical_expr::utils::collect_columns;
                col_locs[1].first_row_index
            grid_row_counts,
    }
                }
            .and_then(|(_, _, n)| n.clone())
        )
        let grid_row_counts: Vec<usize> = boundaries
            col_stats.insert(col.name().to_string(), (grid_mins, grid_maxs, grid_nulls));
            DataType::Int32,
            count_rows_kept(&sel),
    expr: &Arc<dyn PhysicalExpr>,
        for i in 0..5i32 {
            DataType::Int32,
    metadata: Arc<ParquetMetaData>,
                // Collectors have no column stats — always all-true.
            bin(col("extra", 1), Operator::Eq, lit_int(10)),
                    } else {
        assert_eq!(spt.rg_can_match.len(), 3);
