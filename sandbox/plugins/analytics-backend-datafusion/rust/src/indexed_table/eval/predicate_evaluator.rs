                    native_bridge_common::log_debug!(
        let spt = StatsPruneTree {
            num_rows: 8,
pub struct PredicateOnlyEvaluator {
        );
/// Evaluator for predicate-only queries (no Collector).
    }
            return Ok(None);
    #[test]
    pub fn new(
        )
        let rg = RowGroupInfo {
        let rg = RowGroupInfo {
use super::eval_helpers::{
        let prefetched = eval
    ) -> Result<Option<BooleanArray>, String> {
            index: 0,
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
        };
    use super::*;
                    return Ok(None);
            Some(bm) if bm.is_empty() => return Ok(None),
            None,
        page_prune_metrics: Option<PagePruneMetrics>,
        assert!(eval.prefetch_rg(&rg, 0, 8).unwrap().is_none());
            children: vec![],
 */
 * this file be licensed under the Apache-2.0 license or a
        };
            stats_prune_tree,
        writer.write(&batch).unwrap();
            rg_index_to_pos,
            schema.clone(),
        // RG-level early-exit: precomputed from column stats at construction.
            &self.page_pruner,
            first_row: 0,
            .prefetch_rg(&rg, 0, 8)
        stats_prune_tree: Option<Arc<StatsPruneTree>>,
        let spt = StatsPruneTree {
    rg_index_to_pos: HashMap<usize, usize>,
    use datafusion::arrow::array::Int32Array;
                        "PredicateOnly: skipping RG {} — pruned by RG-level stats",
        page_pruner: Arc<PagePruner>,
        let eval = PredicateOnlyEvaluator::new(
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
use datafusion::physical_optimizer::pruning::PruningPredicate;
            page_pruner,
        batch_len: usize,
    pruning_predicate: Option<Arc<PruningPredicate>>,
            page_prune_metrics,
        let t = Instant::now();
            context: Box::new(()),
        &self,
    use std::sync::Arc;
        let Some(ref residual) = self.residual_expr else {
        let options = ArrowReaderOptions::new().with_page_index(true);
        _batch_offset: usize,
//!
        }))
        Self {
            self.pruning_predicate.as_ref(),
            meta.schema().clone(),
    use datafusion::parquet::arrow::ArrowWriter;
    #[test]
        _rg_state: &dyn std::any::Any,
        assert_eq!(prefetched.candidates.len(), 8);
        _position_map: &PositionMap,
        let eval = PredicateOnlyEvaluator::new(
            num_rows: 8,
        if let Some(ref spt) = self.stats_prune_tree {
    fn on_batch_mask(
            candidates,
impl PredicateOnlyEvaluator {
            None,
    }
                        rg.index
use roaring::RoaringBitmap;
        };
            first_row: 0,
}
    ) -> Self {
}
            Some(bm) => bm,
            .unwrap()
        let batch = datafusion::arrow::record_batch::RecordBatch::try_new(
    fn prefetch_rg(
        &self,
#[cfg(test)]
    use tempfile::NamedTempFile;
//! `index_filter(...)` call (no Lucene collector), only DataFusion predicates.
            .unwrap()
            meta.schema(),
use super::{PrefetchedRg, RowGroupBitsetSource};
        };
            meta.metadata().clone(),
//! Candidates default to the page-pruned universe; `on_batch_mask` evaluates
            first_row: 0,
            pruner,
        let mask_buffer = datafusion::arrow::buffer::Buffer::from_vec(packed_bits);
        rg: &RowGroupInfo,
use crate::indexed_table::row_selection::{bitmap_to_packed_bits, PositionMap};
            None,
        residual_expr: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        }
                if let Some(&false) = spt.rg_can_match.get(pos) {
 * SPDX-License-Identifier: Apache-2.0
    stats_prune_tree: Option<Arc<StatsPruneTree>>,
use crate::indexed_table::stream::RowGroupInfo;
            rg_can_match: vec![false],
    use crate::indexed_table::page_pruner::PagePruner;
//! Predicate-only evaluator — no collector, pure parquet-native filtering.
    page_pruner: Arc<PagePruner>,
 * compatible open source license.
        let tmp = NamedTempFile::new().unwrap();
        let rg = RowGroupInfo {
            children: vec![],
            rg_can_match: vec![true],
}
    fn stats_prune_tree_none_does_not_prune() {
            min_doc,
    residual_expr: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        Arc::new(PagePruner::new(
impl RowGroupBitsetSource for PredicateOnlyEvaluator {
            .expect("should have candidates");
        _max_doc: i32,
            if let Some(&pos) = self.rg_index_to_pos.get(&rg.index) {
use std::time::Instant;
        rg_index_to_pos: HashMap<usize, usize>,
            pruner,
            index: 0,
use std::collections::HashMap;
    /// Reverse map: absolute RG index → position in `rg_can_match` vectors.
        writer.close().unwrap();
        let mask_len = rg.num_rows as usize;
        );
        ))
    }
        }
        _rg_first_row: i64,
use std::sync::Arc;
};
        let page_ranges = compute_page_ranges(
        };
            residual_expr,
        let meta = ArrowReaderMetadata::load(&file, options).unwrap();
}
    }
            None,
            vec![Arc::new(Int32Array::from(vec![0i32; 8]))],
    ) -> Result<Option<PrefetchedRg>, String> {
///
        min_doc: i32,
        let eval = PredicateOnlyEvaluator::new(pruner, None, None, None, None, HashMap::new());
            .expect("should have candidates");
        let file = tmp.reopen().unwrap();
    page_prune_metrics: Option<PagePruneMetrics>,
        };
            pruning_predicate,
    #[test]
        let pruner = minimal_page_pruner();
            HashMap::from([(0, 0)]),
            eval_nanos: t.elapsed().as_nanos() as u64,
/*
 * The OpenSearch Contributors require contributions made to
        let prefetched = eval
            self.page_prune_metrics.as_ref(),
        let mut writer = ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), None).unwrap();
            mask_buffer: Some(mask_buffer),
 *
            HashMap::from([(0, 0)]),
            Some(Arc::new(spt)),
        Ok(Some(evaluate_residual(residual, batch, batch_len)?))
//! Used for `FilterClass::None` with `emit_row_ids=true`: the query has no
    fn stats_prune_tree_skips_rg_when_false() {
use crate::indexed_table::page_pruner::{PagePruneMetrics, PagePruner, StatsPruneTree};
    fn stats_prune_tree_allows_rg_when_true() {
            None,
use datafusion::arrow::record_batch::RecordBatch;
            num_rows: 8,
        Ok(Some(PrefetchedRg {
        let pruner = minimal_page_pruner();
/// Candidates = page-pruned universe. Residual predicate applied in `on_batch_mask`.
            rg,
        };
        pruning_predicate: Option<Arc<PruningPredicate>>,
                    );
            index: 0,
        let pruner = minimal_page_pruner();
    }
            Some(Arc::new(spt)),
            None => return Ok(None),
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
        .unwrap();
use datafusion::arrow::array::BooleanArray;
                }
            }
mod tests {
    }
        assert_eq!(prefetched.candidates.len(), 8);
//! only the residual predicate.
            None,
            .prefetch_rg(&rg, 0, 8)
        batch: &RecordBatch,
        let candidates = match universe_bitmap_from_page_ranges(&page_ranges, rg) {
        let packed_bits = bitmap_to_packed_bits(&candidates, mask_len as u32);
    }
    fn minimal_page_pruner() -> Arc<PagePruner> {
        );
    compute_page_ranges, evaluate_residual, universe_bitmap_from_page_ranges,
