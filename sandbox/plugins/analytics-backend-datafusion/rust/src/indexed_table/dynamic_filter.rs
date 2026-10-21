            &column.name,
            self.parquet_schema,
//!
    fn num_containers(&self) -> usize {
pub struct RgPruningContext {
    pub fn new(
//!
 * compatible open source license.
    filter: Arc<dyn PhysicalExpr>,
            .clone();
        seg_arrow_schema: SchemaRef,
        }
            return generation;
            parquet_schema: descr,
/// Watches a pushed-down dynamic filter and prunes row groups whose parquet
            "severity >= 0 is always true for this segment; it must not be pruned under schema drift"
        ]));
 */
        match self.predicate.prune(&stats) {
    parquet_schema: &'a SchemaDescriptor,
            .ok()
        let table_schema = Arc::new(Schema::new(vec![
/// `spawn_blocking` closure to gate the Lucene eval.
    cached_generation: u64,
//! `docs/dynamic-filters-indexed-table-impl.md` §4b.
    /// `PruningPredicate` can't handle) — in which case we never prune.
    }
    /// Generation of the snapshot currently cached in `pruning_predicate`.
        let Some(ctx) = self.current_pruning_predicate() else {
use datafusion::physical_expr_common::physical_expr::{
        );
//! group, decides whether the RG's parquet statistics prove it cannot satisfy
    /// Per-segment arrow schema derived from parquet footer.
        let sev: Arc<dyn PhysicalExpr> = Arc::new(PhysColumn::new("severity", 1));
//!
    }
        let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), file_schema, None).unwrap();
        assert!(
        };
            !ctx.rg_provably_excluded(&md, 0),
    }
impl PruningStatistics for SingleRowGroupStatistics<'_> {
        self.cached_generation = generation;
    pub fn current_pruning_predicate(&mut self) -> Option<RgPruningContext> {
                    .map(Arc::new)
        let counts: UInt64Array = std::iter::once(Some(self.rg_meta.num_rows() as u64)).collect();
//! implies no candidate in that RG can reach the top-k. Pruning is therefore
//! the RG (a superset of the WHERE-passing candidates), so `RG.max <= threshold`
            pruning_predicate: None,
}
    ///
impl RgPruningContext {
    /// Handed to the prefetch closure so an RG can be excluded *before* the
        };
    /// Per-segment arrow schema derived from parquet footer.
/// statistics cannot satisfy the current (tightening) predicate.
    snapshot_generation, snapshot_physical_expr,
        .unwrap();
            return false;
    // parquet file. StatisticsConverter maps a column name to a parquet index positionally,
impl<'a> SingleRowGroupStatistics<'a> {
    pruning_predicate: Option<Arc<PruningPredicate>>,
    /// Build a pruner over `filter`. Returns `None` if `filter` is `None`
use datafusion::parquet::arrow::arrow_reader::statistics::StatisticsConverter;
    /// Cached pruning predicate for the current generation. `None` when the
            .unwrap()
    /// Conservative — returns `false` (scan the RG) on any uncertainty: missing
            .metadata()
        w.write(&batch).unwrap();
    seg_arrow_schema: SchemaRef,
                Arc::new(Int32Array::from(vec![0, 5, 10, 17])),
        let predicate = Arc::new(PruningPredicate::try_new(expr, table_schema.clone()).unwrap());
    full_schema: SchemaRef,
        None
//! Runtime dynamic-filter pruning for the indexed scan.
        let zero: Arc<dyn PhysicalExpr> = Arc::new(Literal::new(ScalarValue::Int32(Some(0))));
/// `PruningStatistics` over a single parquet row group (one container). Mirrors
use datafusion::parquet::schema::types::SchemaDescriptor;
                seg_arrow_schema: self.seg_arrow_schema.clone(),
            file_schema.clone(),
//! The filter references only the SORT columns. RG statistics span *all* rows in
            Field::new("severity", DataType::Int32, false),
            seg_arrow_schema: file_arrow_schema,
            Ok(keep) => keep.first().is_some_and(|k| !*k),
    fn iter(&'a self) -> impl Iterator<Item = &'a RowGroupMetaData> + 'a {
        }
use datafusion::arrow::array::{ArrayRef, BooleanArray, UInt64Array};
//! regardless of how the WHERE clause was split between Lucene and parquet. See
        let descr = metadata.file_metadata().schema_descr();
            self.arrow_schema,
            Field::new("name", DataType::Int32, false),
impl DynamicRgPruner {
    arrow_schema: &'a Schema,
        Ok(StatisticsConverter::try_new(
    /// that *no* row in the RG (and hence no candidate) can satisfy it.
    }
                    .ok()
    ) -> datafusion::common::Result<StatisticsConverter<'a>> {
            .and_then(|c| Ok(c.row_group_maxes(self.iter())?))
            predicate,
#[derive(Clone)]
            });
/*
            .unwrap(),
use datafusion::parquet::file::metadata::{ParquetMetaData, RowGroupMetaData};
    /// stats, non-prunable predicate, or evaluation error. Never skips on doubt.
        let file_schema = Arc::new(Schema::new(vec![
        self.converter(column)
pub struct DynamicRgPruner {
}
    /// True if row group `rg_idx`'s parquet statistics prove it cannot satisfy
//! the TopK heap fills. [`DynamicRgPruner`] watches that filter and, per row
                predicate,
        ]));
            .and_then(|c| Ok(c.row_group_null_counts(self.iter())?))
//! conservative: we may miss a skip, but never drop a qualifying row. This holds
    use datafusion::arrow::datatypes::{DataType, Field};
    pub fn should_prune_rg(&mut self, metadata: &Arc<ParquetMetaData>, rg_idx: usize) -> bool {
    // own schema reads the real `severity` stats and keeps the RG.
            .ok()
            Field::new("name", DataType::Int32, false),
/// read of the snapshot generation), matching DataFusion's `FilePruner`
        let ctx = RgPruningContext {
 * SPDX-License-Identifier: Apache-2.0
/// `PruningPredicate` when the filter's generation actually changes (an atomic
        self.refresh();
/// Cheap in steady state: [`should_prune_rg`] only rebuilds the
use std::sync::Arc;
    use datafusion::physical_expr::expressions::{BinaryExpr, Column as PhysColumn, Literal};
    // (here `neg`, all-negative). The always-true dynamic filter `severity >= 0` then reads
        let batch = RecordBatch::try_new(
        self.pruning_predicate
    }
    fn dynamic_rg_prune_resolves_stats_against_segment_schema_under_drift() {
 * this file be licensed under the Apache-2.0 license or a
    }
///
    }
    use datafusion::arrow::array::{Int32Array, RecordBatch};
        // `prune` returns one bool per container (we have exactly one). `false`
use datafusion::common::{Column, ScalarValue};
    // Schema drift: the table schema orders columns differently from the segment's own
        self.converter(column)
            .clone()
        let stats = SingleRowGroupStatistics {
                Arc::new(Int32Array::from(vec![1, 2, 3, 4])),
        std::iter::once(self.rg_meta)
#[cfg(test)]
    /// `u64::MAX` means "nothing cached yet" (forces a build on first use).
            .and_then(|snap| {
}
/// cloneable (`Arc` inside) and `Send`, so it can be moved into the prefetch
            vec![
}
    use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
        };
    ) -> Option<Self> {
        filter: Option<Arc<dyn PhysicalExpr>>,
            return false;
    predicate: Arc<PruningPredicate>,
    }
    /// The conjoined dynamic filter (still containing `DynamicFilterPhysicalExpr`
    /// at its tightening so far), plus the schema needed to evaluate it against
        )
    /// Full (parquet) schema — used to build the `PruningPredicate`.
}
            return generation;
            // first call with a non-prunable snapshot) — nothing to redo.
    }
use std::collections::HashSet;
/// DataFusion's private `RowGroupPruningStatistics`
            cached_generation: u64::MAX,
    rg_meta: &'a RowGroupMetaData,
struct SingleRowGroupStatistics<'a> {
    }
            .map(|counts| Arc::new(counts) as ArrayRef)
    }
            datafusion::parquet::arrow::parquet_to_arrow_schema(
        Some(Arc::new(counts) as ArrayRef)
        })
mod tests {
//! A parent `SortExec`-TopK (or join) pushes a `DynamicFilterPhysicalExpr` into
        // Flatten any DynamicFilterPhysicalExpr to its current concrete value.
            Field::new("severity", DataType::Int32, false),
                md.file_metadata().schema_descr(),
    ///
//! `QueryShardExec` via physical filter pushdown. The filter starts as the
            arrow_schema: &self.seg_arrow_schema,
/// A snapshotted pruning predicate plus the schema to evaluate it. Cheaply
    // so resolving `severity` against the table schema lands on a DIFFERENT real file column
    fn min_values(&self, column: &Column) -> Option<ArrayRef> {
        if generation == self.cached_generation && self.pruning_predicate.is_some() {
        );
//! # Correctness
    fn null_counts(&self, column: &Column) -> Option<ArrayRef> {
}
};
//! `true` placeholder and is *tightened* at runtime (e.g. `ts > <heap-min>`) as
        let generation = snapshot_generation(&self.filter);
        generation
        if generation == self.cached_generation {
        let tmp = NamedTempFile::new().unwrap();
    }
            Field::new("neg", DataType::Int32, false),
    /// available yet.
    /// True if row group `rg_idx` can be skipped: the current predicate proves
            rg_meta,
/// (`datasource-parquet/src/row_group_filter.rs`) but scoped to exactly one RG.
            Field::new("neg", DataType::Int32, false),
        let md = ArrowReaderMetadata::load(&tmp.reopen().unwrap(), ArrowReaderOptions::new())
            full_schema,
            )
            filter,
    /// (no dynamic filter was accepted), so the hot path can skip all work.
            .ok()
        &'a self,
    /// nodes). Snapshotted on demand to a concrete predicate.
}
    fn converter<'b>(
use datafusion::arrow::datatypes::{Schema, SchemaRef};
    /// Refresh the cached `PruningPredicate` if the dynamic filter has changed
    fn contained(&self, _column: &Column, _values: &HashSet<ScalarValue>) -> Option<BooleanArray> {
use datafusion::physical_expr::PhysicalExpr;
        // File order: name, neg, severity.
    }
//! the current predicate — in which case the RG is skipped entirely.
    /// read). Returns the current generation.
        // means "provably cannot match" → safe to skip. Any error => keep.
            })
    use super::*;
    /// since the last call. Cheap when unchanged (just an atomic generation
        self.pruning_predicate = snapshot_physical_expr(Arc::clone(&self.filter))
            .ok()
        full_schema: SchemaRef,
                PruningPredicate::try_new(snap, Arc::clone(&self.full_schema))
    pub fn rg_provably_excluded(&self, metadata: &Arc<ParquetMetaData>, rg_idx: usize) -> bool {
        self.converter(column)
    /// The current concrete pruning predicate (snapshotting the dynamic filter
    fn refresh(&mut self) -> u64 {
    use tempfile::NamedTempFile;
    fn max_values(&self, column: &Column) -> Option<ArrayRef> {
            .map(|predicate| RgPruningContext {
    // neg's stats (max < 0) and wrongly prunes the whole RG. Resolving against the segment's
    /// (expensive) Lucene/FFM eval runs. `None` when no prunable predicate is
    /// the predicate. Conservative: `false` on any missing stats / error.
        column: &'b Column,
        let expr: Arc<dyn PhysicalExpr> = Arc::new(BinaryExpr::new(sev, Operator::GtEq, zero));
    use datafusion::logical_expr::Operator;
    /// RG stats. Generation-gated, so cheap when the filter hasn't moved.
            .and_then(|c| Ok(c.row_group_mins(self.iter())?))
    #[test]
            Err(_) => false,
                md.file_metadata().key_value_metadata(),
    seg_arrow_schema: SchemaRef,
        )?)
 *
    use datafusion::parquet::arrow::ArrowWriter;
        let Some(rg_meta) = metadata.row_groups().get(rg_idx) else {
    }
}
        };
            // Same generation, but we have no predicate cached (build failed or
 * The OpenSearch Contributors require contributions made to
        }
        1
        w.close().unwrap();
        ctx.rg_provably_excluded(metadata, rg_idx)
        // Table order puts `severity` at the position the file holds `neg`.
use datafusion::physical_optimizer::pruning::{PruningPredicate, PruningStatistics};
        let file_arrow_schema = Arc::new(
            seg_arrow_schema,
        filter.map(|filter| Self {
    fn row_counts(&self) -> Option<ArrayRef> {
/// discipline.
            ],
                Arc::new(Int32Array::from(vec![-9, -8, -7, -6])),
    /// snapshot couldn't be turned into a pruning predicate (e.g. an expression
