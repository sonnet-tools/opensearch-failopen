    }
        };
            eval_nanos: t.elapsed().as_nanos() as u64,
    }
    #[test]
    ) -> Result<Option<PrefetchedRg>, String> {
    ) -> Self {
        );
    fn stats_prune_tree_none_does_not_prune() {
        let batch = datafusion::arrow::record_batch::RecordBatch::try_new(
        assert_eq!(prefetched.candidates.len(), 8);
    fn minimal_page_pruner() -> Arc<PagePruner> {
        let meta = ArrowReaderMetadata::load(&file, options).unwrap();
    stats_prune_tree: Option<Arc<StatsPruneTree>>,
        let spt = StatsPruneTree {
use datafusion::arrow::array::BooleanArray;
        let options = ArrowReaderOptions::new().with_page_index(true);
        let prefetched = eval
 *
use roaring::RoaringBitmap;
        stats_prune_tree: Option<Arc<StatsPruneTree>>,
    ) -> Result<Option<BooleanArray>, String> {
                }
use crate::indexed_table::row_selection::{bitmap_to_packed_bits, PositionMap};
            meta.schema(),
    compute_page_ranges, evaluate_residual, universe_bitmap_from_page_ranges,
//! Predicate-only evaluator — no collector, pure parquet-native filtering.
            page_prune_metrics,
        let rg = RowGroupInfo {
 * compatible open source license.
        Self {
    #[test]
        );
use datafusion::physical_optimizer::pruning::PruningPredicate;
        let rg = RowGroupInfo {
            .prefetch_rg(&rg, 0, 8)
        batch_len: usize,
use crate::indexed_table::stream::RowGroupInfo;
        let Some(ref residual) = self.residual_expr else {
        .unwrap();
    }
            schema.clone(),
        let eval = PredicateOnlyEvaluator::new(
            pruning_predicate,
        _rg_state: &dyn std::any::Any,
//! only the residual predicate.
use super::eval_helpers::{
            self.pruning_predicate.as_ref(),
impl PredicateOnlyEvaluator {
        let mask_len = rg.num_rows as usize;
        };
        page_pruner: Arc<PagePruner>,
            HashMap::from([(0, 0)]),
        rg: &RowGroupInfo,
            None,
use std::time::Instant;
            }
};
}
            index: 0,
            stats_prune_tree,
        assert!(eval.prefetch_rg(&rg, 0, 8).unwrap().is_none());
    /// Reverse map: absolute RG index → position in `rg_can_match` vectors.
            meta.metadata().clone(),
//! `index_filter(...)` call (no Lucene collector), only DataFusion predicates.
        let pruner = minimal_page_pruner();
                    return Ok(None);
        min_doc: i32,
                    );
#[cfg(test)]
        ))
        };
        assert_eq!(prefetched.candidates.len(), 8);
            .unwrap()
}
            first_row: 0,
            index: 0,
            min_doc,
        let spt = StatsPruneTree {
    use crate::indexed_table::page_pruner::PagePruner;
        let rg = RowGroupInfo {
    fn stats_prune_tree_allows_rg_when_true() {
        }
            None,
            page_pruner,
            mask_buffer: Some(mask_buffer),
            Some(bm) if bm.is_empty() => return Ok(None),
        if let Some(ref spt) = self.stats_prune_tree {
        }
            meta.schema().clone(),
use std::collections::HashMap;
//! Candidates default to the page-pruned universe; `on_batch_mask` evaluates
            index: 0,
        batch: &RecordBatch,
        Ok(Some(PrefetchedRg {
            .unwrap()
    rg_index_to_pos: HashMap<usize, usize>,
    use datafusion::arrow::array::Int32Array;
            HashMap::from([(0, 0)]),
        let tmp = NamedTempFile::new().unwrap();
            children: vec![],
        &self,
            pruner,
        let mut writer = ArrowWriter::try_new(tmp.reopen().unwrap(), schema.clone(), None).unwrap();
        let t = Instant::now();
 */
        _position_map: &PositionMap,
use datafusion::arrow::record_batch::RecordBatch;
        };
    #[test]
///
        writer.write(&batch).unwrap();
            num_rows: 8,
            rg_can_match: vec![true],
//!
            if let Some(&pos) = self.rg_index_to_pos.get(&rg.index) {
            None => return Ok(None),
            rg_index_to_pos,
impl RowGroupBitsetSource for PredicateOnlyEvaluator {
        };
            self.page_prune_metrics.as_ref(),
    fn prefetch_rg(
//! Used for `FilterClass::None` with `emit_row_ids=true`: the query has no
/*
        let schema = Arc::new(Schema::new(vec![Field::new("a", DataType::Int32, false)]));
            num_rows: 8,
        )
        );
        _batch_offset: usize,
    pub fn new(
        _max_doc: i32,
        let prefetched = eval
            pruner,
use crate::indexed_table::page_pruner::{PagePruneMetrics, PagePruner, StatsPruneTree};
        Arc::new(PagePruner::new(
        let eval = PredicateOnlyEvaluator::new(
        let pruner = minimal_page_pruner();
            return Ok(None);
        &self,
        Ok(Some(evaluate_residual(residual, batch, batch_len)?))
        };
    use datafusion::parquet::arrow::ArrowWriter;
pub struct PredicateOnlyEvaluator {
        pruning_predicate: Option<Arc<PruningPredicate>>,
    }
            rg_can_match: vec![false],
        rg_index_to_pos: HashMap<usize, usize>,
        }))
        let eval = PredicateOnlyEvaluator::new(pruner, None, None, None, None, HashMap::new());
            .expect("should have candidates");
            Some(Arc::new(spt)),
        let file = tmp.reopen().unwrap();
            Some(bm) => bm,
    }
            num_rows: 8,
            first_row: 0,
        };
            context: Box::new(()),
            &self.page_pruner,
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
            Some(Arc::new(spt)),
    }
    page_pruner: Arc<PagePruner>,
use std::sync::Arc;
    use tempfile::NamedTempFile;
            None,
/// Evaluator for predicate-only queries (no Collector).
    fn stats_prune_tree_skips_rg_when_false() {
        page_prune_metrics: Option<PagePruneMetrics>,
mod tests {
            first_row: 0,
        writer.close().unwrap();
    residual_expr: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        let page_ranges = compute_page_ranges(
    pruning_predicate: Option<Arc<PruningPredicate>>,
            rg,
    use super::*;
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
            None,
            .expect("should have candidates");
 * SPDX-License-Identifier: Apache-2.0
        let mask_buffer = datafusion::arrow::buffer::Buffer::from_vec(packed_bits);
        // RG-level early-exit: precomputed from column stats at construction.
        let pruner = minimal_page_pruner();
        let candidates = match universe_bitmap_from_page_ranges(&page_ranges, rg) {
        residual_expr: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
            candidates,
 * this file be licensed under the Apache-2.0 license or a
    fn on_batch_mask(
            vec![Arc::new(Int32Array::from(vec![0i32; 8]))],
    }
            None,
            .prefetch_rg(&rg, 0, 8)
        _rg_first_row: i64,
        let packed_bits = bitmap_to_packed_bits(&candidates, mask_len as u32);
/// Candidates = page-pruned universe. Residual predicate applied in `on_batch_mask`.
                if let Some(&false) = spt.rg_can_match.get(pos) {
 * The OpenSearch Contributors require contributions made to
            children: vec![],
}
                        rg.index
    page_prune_metrics: Option<PagePruneMetrics>,
            residual_expr,
                        "PredicateOnly: skipping RG {} — pruned by RG-level stats",
}
            None,
use super::{PrefetchedRg, RowGroupBitsetSource};
    use std::sync::Arc;
                    native_bridge_common::log_debug!(
