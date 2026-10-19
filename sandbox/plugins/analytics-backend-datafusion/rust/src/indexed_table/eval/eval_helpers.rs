    pruning_predicate: Option<&Arc<PruningPredicate>>,
                        ranges.push((abs_min, abs_max));
use std::sync::Arc;
use roaring::RoaringBitmap;
    page_prune_metrics: Option<&PagePruneMetrics>,
                bm.insert_range(lo..hi);
        .transform(|node| {
use datafusion::physical_optimizer::pruning::PruningPredicate;
            Some(bm)
                        rg_pos += s.row_count as i64;
}
    page_pruner: &PagePruner,
        page_pruner
    })
pub fn compute_page_ranges(
                    }
            for (r_min, r_max) in r {
                    let new_col: Arc<dyn PhysicalExpr> = Arc::new(Column::new(col.name(), idx));
                }
/// Returns `Some(vec![])` if all pages are pruned (RG can be skipped).
    array
            }
        }
            Ok(Transformed::no(node))
/// Remap column references in a PhysicalExpr to match the batch schema.
            use datafusion::common::tree_node::Transformed;
use datafusion::physical_expr::PhysicalExpr;
            .map(|sel| {
        }
 *
    let remapped = remap_expr_to_batch(residual, batch)?;
/// Build a candidate bitmap from page-pruned ranges (universe — all surviving pages).
                    return Ok(Transformed::yes(new_col));
        .ok_or_else(|| "evaluate_residual: did not produce BooleanArray".to_string())
    rg: &RowGroupInfo,
            if let Some(col) = node.downcast_ref::<Column>() {
                        let abs_max = min_doc + rg_pos as i32 + s.row_count as i32;
                let lo = (*r_min as i64 - rg.first_row) as u32;
use datafusion::arrow::record_batch::RecordBatch;
    rg: &RowGroupInfo,
        .as_any()
pub fn remap_expr_to_batch(
            let mut bm = RoaringBitmap::new();
    pruning_predicate.and_then(|pp| {
pub fn universe_bitmap_from_page_ranges(
        .map(|t| t.data)
use crate::indexed_table::stream::RowGroupInfo;
        .map_err(|e| format!("evaluate_residual: {}", e))?;
                    if s.skip {
}
        .map_err(|e| format!("evaluate_residual into_array: {}", e))?;
                        let abs_min = min_doc + rg_pos as i32;
 * SPDX-License-Identifier: Apache-2.0
                }
/// The expression may reference columns by index in the full table schema,
use datafusion::arrow::array::BooleanArray;
        None => {
/*
 * compatible open source license.
    let batch_schema = batch.schema();
    batch: &RecordBatch,
/// Returns `None` if all pages were pruned.
) -> Option<RoaringBitmap> {
    }
    residual: &Arc<dyn PhysicalExpr>,
/// Evaluate a residual predicate against a batch, returning a BooleanArray mask.
        .downcast_ref::<BooleanArray>()
    expr.clone()
    page_ranges: &Option<Vec<(i32, i32)>>,
        .into_array(batch_len)
            }
        .evaluate(batch)
            .prune_rg(pp, rg.index, page_prune_metrics)
            bm.insert_range(0..rg.num_rows as u32);
    min_doc: i32,
    expr: &Arc<dyn PhysicalExpr>,
                let mut rg_pos: i64 = 0;
//! Shared helpers for evaluators (SingleCollector, PredicateOnly, Tree).
/// Returns `None` if no pruning predicate is available (all rows pass).
}
                let hi = (*r_max as i64 - rg.first_row) as u32;
}
        .cloned()
 * The OpenSearch Contributors require contributions made to
    let array = value
        Some(r) => {
    let value = remapped
        })
use datafusion::physical_expr::expressions::Column;
                for s in sel.iter() {
 */
                        rg_pos += s.row_count as i64;
/// Compute page-pruned ranges for a row group.
            Some(bm)
        Some(r) if r.is_empty() => None,
) -> Option<Vec<(i32, i32)>> {
    batch: &RecordBatch,
) -> Result<BooleanArray, String> {
                if let Ok(idx) = batch_schema.index_of(col.name()) {
    batch_len: usize,
            let mut bm = RoaringBitmap::new();
                let mut ranges = Vec::new();
pub fn evaluate_residual(
            })
                    } else {
use crate::indexed_table::page_pruner::{PagePruneMetrics, PagePruner};
/// but the batch only contains projected columns. This rewrites Column
) -> Result<Arc<dyn PhysicalExpr>, String> {
                ranges
use datafusion::common::tree_node::TreeNode;
        .map_err(|e| format!("remap_expr_to_batch: {}", e))
    match page_ranges {
 * this file be licensed under the Apache-2.0 license or a
/// expressions to use the batch's field positions by name lookup.
