    // parquet file. StatisticsConverter maps a column name to a parquet index positionally,
    /// Cached pruning predicate for the current generation. `None` when the
            )
            // first call with a non-prunable snapshot) — nothing to redo.
            .unwrap(),
    /// RG stats. Generation-gated, so cheap when the filter hasn't moved.
    pub fn current_pruning_predicate(&mut self) -> Option<RgPruningContext> {
    use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
 * compatible open source license.
/// Cheap in steady state: [`should_prune_rg`] only rebuilds the
        generation
            pruning_predicate: None,
        // Table order puts `severity` at the position the file holds `neg`.
        assert!(
//! the current predicate — in which case the RG is skipped entirely.
 *
//! `docs/dynamic-filters-indexed-table-impl.md` §4b.
            .ok()
    }
//! The filter references only the SORT columns. RG statistics span *all* rows in
    }
    }
}
        let sev: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new("severity", 1));
 * The OpenSearch Contributors require contributions made to
    fn row_counts(&self) -> Option<ArrayRef> {
        );
            return generation;
    use datafusion::logical_expr::Operator;
    pruning_predicate: Option<Arc<PruningPredicate>>,
    /// True if row group `rg_idx`'s parquet statistics prove it cannot satisfy
            Field::new("neg", DataType::Int32, false),
    /// Build a pruner over `filter`. Returns `None` if `filter` is `None`
        let generation = snapshot_generation(&self.filter);
            return false;
            .ok()
                md.file_metadata().key_value_metadata(),
            self.parquet_schema,
    }
        self.converter(column)
use datafusion::parquet::arrow::arrow_reader::statistics::StatisticsConverter;
            file_schema.clone(),
    /// The conjoined dynamic filter (still containing `DynamicFilterPhysicalExpr`
use datafusion::arrow::datatypes::{Schema, SchemaRef};
        let table_schema = Arc::new(Schema::new(vec![
    seg_arrow_schema: SchemaRef,
            datafusion::parquet::arrow::parquet_to_arrow_schema(
            return generation;
        let descr = metadata.file_metadata().schema_descr();
    }
    }
}
        match self.predicate.prune(&stats) {
    ) -> datafusion::common::Result<StatisticsConverter<'a>> {
#[derive(Clone)]
        }
        None
        filter.map(|filter| Self {
            .ok()
//! regardless of how the WHERE clause was split between Lucene and parquet. See
            .and_then(|snap| {
/// read of the snapshot generation), matching DataFusion's `FilePruner`
    fn null_counts(&self, column: &Column) -> Option<ArrayRef> {
        self.pruning_predicate = snapshot_physical_expr(Arc::clone(&self.filter))
        let stats = SingleRowGroupStatistics {
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
    pub fn rg_provably_excluded(&self, metadata: &Arc<ParquetMetaData>, rg_idx: usize) -> bool {
}
        let md = ArrowReaderMetadata::load(&tmp.reopen().unwrap(), ArrowReaderOptions::new())
//! `QueryShardExec` via physical filter pushdown. The filter starts as the
    /// Refresh the cached `PruningPredicate` if the dynamic filter has changed
#[cfg(test)]
//! # Correctness
//! the TopK heap fills. [`DynamicRgPruner`] watches that filter and, per row
                predicate,
    /// The current concrete pruning predicate (snapshotting the dynamic filter
        self.cached_generation = generation;
                    .map(Arc::new)
                PruningPredicate::try_new(snap, Arc::clone(&self.full_schema))
            .ok()
            .and_then(|c| Ok(c.row_group_maxes(self.iter())?))
    arrow_schema: &'a Schema,
                seg_arrow_schema: self.seg_arrow_schema.clone(),
    fn dynamic_rg_prune_resolves_stats_against_segment_schema_under_drift() {
}
    ///
    }
//! the RG (a superset of the WHERE-passing candidates), so `RG.max <= threshold`
        ctx.rg_provably_excluded(metadata, rg_idx)
    /// Full (parquet) schema — used to build the `PruningPredicate`.
/// cloneable (`Arc` inside) and `Send`, so it can be moved into the prefetch
            .and_then(|c| Ok(c.row_group_mins(self.iter())?))
        w.close().unwrap();
            return false;
        column: &'b Column,
        // Flatten any DynamicFilterPhysicalExpr to its current concrete value.
    pub fn should_prune_rg(&mut self, metadata: &Arc<ParquetMetaData>, rg_idx: usize) -> bool {
    /// Generation of the snapshot currently cached in `pruning_predicate`.
        };
        .unwrap();
    /// that *no* row in the RG (and hence no candidate) can satisfy it.
            seg_arrow_schema: file_arrow_schema,
mod tests {
use datafusion::parquet::schema::types::SchemaDescriptor;
            .clone()
        };
            rg_meta,
            .and_then(|c| Ok(c.row_group_null_counts(self.iter())?))
//! implies no candidate in that RG can reach the top-k. Pruning is therefore
        w.write(&batch).unwrap();
        let Some(ctx) = self.current_pruning_predicate() else {
            // Same generation, but we have no predicate cached (build failed or
    use datafusion::parquet::arrow::ArrowWriter;
        ]));
    use tempfile::NamedTempFile;
        // `prune` returns one bool per container (we have exactly one). `false`
    /// (no dynamic filter was accepted), so the hot path can skip all work.
    rg_meta: &'a RowGroupMetaData,
    fn refresh(&mut self) -> u64 {
                Arc::new(Int32Array::from(vec![-9, -8, -7, -6])),
            Ok(keep) => keep.first().is_some_and(|k| !*k),
            ],
    ///
 */
    snapshot_generation, snapshot_physical_expr,
            Field::new("name", DataType::Int32, false),
//! `true` placeholder and is *tightened* at runtime (e.g. `ts > <heap-min>`) as
        };
        })
                Arc::new(Int32Array::from(vec![1, 2, 3, 4])),
                md.file_metadata().schema_descr(),
//!
    fn contained(&self, _column: &Column, _values: &HashSet<ScalarValue>) -> Option<BooleanArray> {
        // means "provably cannot match" → safe to skip. Any error => keep.
        seg_arrow_schema: SchemaRef,
/// discipline.
    use datafusion::arrow::datatypes::{DataType, Field};
/*
        self.converter(column)
///
            &column.name,
    fn converter<'b>(
            self.arrow_schema,
    /// `u64::MAX` means "nothing cached yet" (forces a build on first use).
        let expr: Arc<dyn PhysicalExpr> = Arc::new(BinaryExpr::new(sev, Operator::GtEq, zero));
pub struct RgPruningContext {
    fn num_containers(&self) -> usize {
    cached_generation: u64,
        )
        let ctx = RgPruningContext {
            .metadata()
            Field::new("neg", DataType::Int32, false),
/// `spawn_blocking` closure to gate the Lucene eval.
/// `PruningStatistics` over a single parquet row group (one container). Mirrors
use datafusion::physical_expr_common::physical_expr::{
        let file_schema = Arc::new(Schema::new(vec![
pub struct DynamicRgPruner {
    // neg's stats (max < 0) and wrongly prunes the whole RG. Resolving against the segment's
impl RgPruningContext {
    parquet_schema: &'a SchemaDescriptor,
            Field::new("name", DataType::Int32, false),
        let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), file_schema, None).unwrap();
 * this file be licensed under the Apache-2.0 license or a
        self.pruning_predicate
    seg_arrow_schema: SchemaRef,
    /// Per-segment arrow schema derived from parquet footer.
    #[test]
    /// nodes). Snapshotted on demand to a concrete predicate.
    }
            arrow_schema: &self.seg_arrow_schema,
    }
}
        let Some(rg_meta) = metadata.row_groups().get(rg_idx) else {
//! Runtime dynamic-filter pruning for the indexed scan.
struct SingleRowGroupStatistics<'a> {
    }
/// A snapshotted pruning predicate plus the schema to evaluate it. Cheaply
    filter: Arc<dyn PhysicalExpr>,
use datafusion::arrow::array::{ArrayRef, BooleanArray, UInt64Array};
    /// snapshot couldn't be turned into a pruning predicate (e.g. an expression
    full_schema: SchemaRef,
    }
};
//! group, decides whether the RG's parquet statistics prove it cannot satisfy
    }
    fn iter(&'a self) -> impl Iterator<Item = &'a RowGroupMetaData> + 'a {
        Ok(StatisticsConverter::try_new(
    // (here `neg`, all-negative). The always-true dynamic filter `severity >= 0` then reads
        filter: Option<Arc<dyn PhysicalExpr>>,
    /// Handed to the prefetch closure so an RG can be excluded *before* the
            Field::new("severity", DataType::Int32, false),
use std::collections::HashSet;
            });
 * SPDX-License-Identifier: Apache-2.0
            Field::new("severity", DataType::Int32, false),
    pub fn new(
use datafusion::physical_optimizer::pruning::{PruningPredicate, PruningStatistics};
            "severity >= 0 is always true for this segment; it must not be pruned under schema drift"
    predicate: Arc<PruningPredicate>,
        }
            !ctx.rg_provably_excluded(&md, 0),
            .clone();
        let file_arrow_schema = Arc::new(
    use datafusion::arrow::array::{Int32Array, RecordBatch};
impl DynamicRgPruner {
    // so resolving `severity` against the table schema lands on a DIFFERENT real file column
    /// since the last call. Cheap when unchanged (just an atomic generation
            seg_arrow_schema,
    /// True if row group `rg_idx` can be skipped: the current predicate proves
        let batch = RecordBatch::try_new(
    /// stats, non-prunable predicate, or evaluation error. Never skips on doubt.
use datafusion::common::{Column, ScalarValue};
    ) -> Option<Self> {
use datafusion::physical_expr::PhysicalExpr;
        self.converter(column)
            Err(_) => false,
            filter,
        if generation == self.cached_generation && self.pruning_predicate.is_some() {
    /// (expensive) Lucene/FFM eval runs. `None` when no prunable predicate is
impl PruningStatistics for SingleRowGroupStatistics<'_> {
    /// Conservative — returns `false` (scan the RG) on any uncertainty: missing
        1
//! A parent `SortExec`-TopK (or join) pushes a `DynamicFilterPhysicalExpr` into
}
            .map(|counts| Arc::new(counts) as ArrayRef)
    /// at its tightening so far), plus the schema needed to evaluate it against
            cached_generation: u64::MAX,
            parquet_schema: descr,
    use super::*;
        full_schema: SchemaRef,
                Arc::new(Int32Array::from(vec![0, 5, 10, 17])),
        let predicate = Arc::new(PruningPredicate::try_new(expr, table_schema.clone()).unwrap());
/// `PruningPredicate` when the filter's generation actually changes (an atomic
        self.refresh();
        let counts: UInt64Array = std::iter::once(Some(self.rg_meta.num_rows() as u64)).collect();
        if generation == self.cached_generation {
        Some(Arc::new(counts) as ArrayRef)
            full_schema,
        ]));
    }
}
        )?)
use std::sync::Arc;
    fn min_values(&self, column: &Column) -> Option<ArrayRef> {
/// (`datasource-parquet/src/row_group_filter.rs`) but scoped to exactly one RG.
//! conservative: we may miss a skip, but never drop a qualifying row. This holds
        let zero: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(0))));
        };
            predicate,
        &'a self,
    /// `PruningPredicate` can't handle) — in which case we never prune.
    /// read). Returns the current generation.
        );
    /// the predicate. Conservative: `false` on any missing stats / error.
/// DataFusion's private `RowGroupPruningStatistics`
            vec![
    /// available yet.
            })
            .map(|predicate| RgPruningContext {
    /// Per-segment arrow schema derived from parquet footer.
        let tmp = NamedTempFile::new().unwrap();
}
//!
    fn max_values(&self, column: &Column) -> Option<ArrayRef> {
    }
        std::iter::once(self.rg_meta)
                    .ok()
use datafusion::parquet::file::metadata::{ParquetMetaData, RowGroupMetaData};
impl<'a> SingleRowGroupStatistics<'a> {
/// Watches a pushed-down dynamic filter and prunes row groups whose parquet
    // own schema reads the real `severity` stats and keeps the RG.
        }
/// statistics cannot satisfy the current (tightening) predicate.
        // File order: name, neg, severity.
            .unwrap()
    // Schema drift: the table schema orders columns differently from the segment's own
//!
