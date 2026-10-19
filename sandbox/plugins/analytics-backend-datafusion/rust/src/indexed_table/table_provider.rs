    pub cancellation_token: Option<tokio_util::sync::CancellationToken>,
        if phase != FilterPushdownPhase::Post {
        let descending = sort_orders
            properties: Arc::clone(&self.properties),
    projected_schema: SchemaRef,
            // When the sort-aware path fired (`advertised_ordering: Some`), the
                    combined.push(m.clone());
/// produces a `SingleCollectorEvaluator`. For the multi-filter tree path it
            // segment, and the writer's k-way-merge guarantees rows in this
        filter: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
    /// Per-query cancellation token (from the global `QUERY_REGISTRY`). Threaded
        &self,
    /// into each `IndexedExec` so `ParquetSource.with_predicate(...)` can
impl fmt::Debug for QueryShardExec {
            pmetrics.into_stream_metrics(Some(Arc::clone(&self.inner_parquet_metrics)));
        // When computing row IDs, replace the ___row_id field type with UInt64.
        None
 *
            emit_row_ids: false,
    pub object_path: object_store::path::Path,
        // `index_filter(...)` UDF whose body panics by design.
    /// Read from the parquet footer key-value metadata
            config: Arc::clone(&self.config),
    }
            let evaluator = (self.config.evaluator_factory)(
    /// Arrow schema derived from this segment's parquet footer. Computed once
    pub global_base: u64,
            &SegmentFileInfo,
    }
    }
    /// from position (global_base + rg.first_row + position_in_rg) instead of
            ));
        };
        shard.test_predicate().cloned()
                            &segment.arrow_schema,
            }
use crate::datafusion_query_config::DatafusionQueryConfig;
        // unresolvable column rather than erroring out.
            // `QueryShardExec`. Without this, `EnforceSorting` can't see that
/// many `IndexedExec`s from a single config.
                continue;
    pub max_doc: i64,
            }
    /// reuse the shared `Arc` fields verbatim.
                stream_metrics: stream_metrics.clone(),
    /// Shared by reference across fanned-out `QueryShardExec` instances.
    dyn Fn(
    pub(crate) fn test_predicate(
            predicate_columns: vec![],
//!
            Arc<dyn ExecutionPlan>,
        // BoolNode tree held by the evaluator factory already contains
            if let Some(c) = e.downcast_ref::<Column>() {
    async fn scan_predicate(
/// Direction strings are `"asc"` / `"desc"` (lowercase, as plumbed from Java).
            "QueryShardExec: partitions={}, segments={}, ordering={}",
            match projection {
            // Evaluator factory would never be invoked for this test (no segments).
        {
            for set in inner.iter() {
            };
        >,
        // UDF call would be in there (its body panics), and the
/// Invoked once per chunk per query. For the single-collector path this
            .field("segments", &self.config.segments.len())
/// Factory: build a `RowGroupBitsetSource` for one `SegmentChunk`.
use std::sync::Arc;
        f.debug_struct("QueryShardExec")
        let mut saw_column = false;
                if i > 0 {
#[cfg(test)]
    /// Both `None` when no sort field is configured, when any RG is missing
        ]));
        let layouts: Vec<SegmentLayout> = self
 * The OpenSearch Contributors require contributions made to
                if !cols.contains(&idx) {
        let row_id_col_in_full_schema = full_schema.index_of(crate::ROW_ID_COLUMN_NAME).ok();
        }
        // BoolNode in `execute_indexed_query` and stashed on the
            schema,
            // segment are in lead-key order. So this `IndexedExec` produces a
                for &idx in &self.config.predicate_columns {
                    datafusion::physical_plan::empty::EmptyExec::new(self.projected_schema.clone());
        let projected_schema = output_schema;
                .filter(|rg| rg_set.contains(&rg.index))
                store_url: self.config.store_url.clone(),
    /// Sort ordering this scan claims to produce — `Some` only when the
        }
            } else {
    /// (`opensearch.writer_generation`) at `build_segments` time.
//!             └── IndexedExec(chunk_N) ── IndexedStream ── RowGroupBitsetSource
        let target_partitions = self.config.query_config.target_partitions.max(1);
            eq_properties,
        let properties = Arc::new(PlanProperties::new(
    fn schema(&self) -> SchemaRef {
        let stream: SendableRecordBatchStream = match streams.len() {
                    .iter()
            inner_parquet_metrics: Arc::new(std::sync::Mutex::new(Vec::new())),
    /// `QueryShardExec` is a leaf (no children), so the default
            }
            store: Arc::new(object_store::local::LocalFileSystem::new()),
            )
                Some(proj) => proj
        // Require at least one resolved column — a column-free predicate (e.g.
    }
        _filters: &[Expr],
    fn supports_filters_pushdown(
        }
                evaluator: std::sync::Mutex::new(Some(evaluator)),
        //     too low, lead column projected away, or QTF row-id-emit gate).
            cancellation_token: None,
                    .position(|&idx| Some(idx) == row_id_col_in_full_schema),
    /// page pruning, dynamic filter pruning, and column schema resolution
        &self,
            FilterPushdownPhase, FilterPushdownPropagation, PushedDown,
            // `SortPreservingMergeExec` for the outer `SortExec(TopK)`.
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
                row_groups: seg.row_groups.clone(),
                accepted.push(Arc::clone(&f.filter));
                row_groups,
 */
    ///   children of top AND) as a single `PhysicalExpr`.
                statuses.push(PushedDown::No);
        // Detect __row_id__ in the output projection when emit_row_ids=true.
use datafusion::arrow::compute::SortOptions;
        // Build the LexOrdering against the projected schema. If the lead
                saw_column = true;
use super::stream::{IndexedExec, RowGroupInfo};
            projected_schema,
use super::metrics::PartitionMetrics;
impl QueryShardExec {
        saw_column && all_cols_known
        exprs.push(PhysicalSortExpr::new(phys, opts));
/// Info about a segment and its corresponding parquet file.
    pub sort_fields: Vec<String>,
    /// possible). Anything else is declined, leaving the parent's safety-net
}
            .scan(&ctx.state(), None, filters, None)
        ) -> Result<Arc<dyn RowGroupBitsetSource>, String>
            if self.dynamic_filter_is_acceptable(&f.filter) {
        } else {
    /// is cancelled. `None` for untracked queries (`context_id == 0`) and tests.
/// Nulls placement matches Lucene's convention: ASC → NULLS FIRST,
    /// `StatisticsConverter`. `None` means the segment cannot participate in
    advertised_ordering: Option<LexOrdering>,
    use datafusion::logical_expr::{col, lit};
    /// in this segment, read from parquet footer column statistics.
                None => EquivalenceProperties::new(self.projected_schema.clone()),
///
            let props = Arc::new(PlanProperties::new(
                let dir = if e.options.descending { "DESC" } else { "ASC" };
        // The pushdown predicate — the parquet-native residual to hand
                Some(proj) => Arc::new(full_schema.project(proj)?),
        };
impl fmt::Debug for IndexedTableProvider {
            && segments_chain_on_sort_key(&self.config.segments)
    /// reference sort columns; a sort on a Lucene-only / computed column (not in
        datafusion::physical_plan::filter_pushdown::FilterPushdownPropagation<
    pub arrow_schema: SchemaRef,
                schema: self.projected_schema.clone(),
 * compatible open source license.
    }
        use datafusion::physical_plan::filter_pushdown::{
//! ```text
        let plan = provider
                store: Arc::clone(&self.config.store),
        // Decide whether to use the sort-aware path: requires a configured
        "QueryShardExec"
            // input partitions are already sorted and won't substitute
    /// by `scan()`. `None` when no filters were pushed down.
        + Sync,
}
        } else {
                    if name == "output_rows" || name == "output_batches" || name == "output_bytes" {
            metrics,
    let mut exprs: Vec<PhysicalSortExpr> = Vec::with_capacity(sort_fields.len());
            None
impl Drop for QueryShardExec {
/*
//!             │
    /// only in the `Post` phase and only when every column it references is a
            projection: read_projection,
    /// at `build_segments` time by `parquet_to_arrow_schema` and reused by
            prune_tree_config: None,
}
        // Read projection = output columns (minus ___row_id) + predicate columns for evaluator.
            let eq = EquivalenceProperties::new_with_orderings(
}
            .await
        let lex_ordering = if chain_ok {
//!     IndexedTableProvider (scan)
                    let name = m.value().name();
    pub store_url: datafusion::execution::object_store::ObjectStoreUrl,
    /// projected schema). Each `IndexedExec` spawned by `execute()` advertises
            Ok(TreeNodeRecursion::Continue)
        None => "unsorted".to_string(),
                dynamic_filter: dynamic_filter.clone(),
        TableType::Base
    full_schema: SchemaRef,
            })
                self.config
                .collect();
        let chain_ok = !self.config.sort_fields.is_empty()
            (
                None => (0..full_schema.fields().len())
                object_path: segment.object_path.clone(),
            .expect("scan");
                emit_row_ids: self.config.emit_row_ids,
        Ok(self)
            let assignments = compute_assignments_one_per_segment(&self.config.segments, &layouts);
        };
//!             ├── IndexedExec(chunk_0) ── IndexedStream ── RowGroupBitsetSource
                empty.execute(0, context)?
                properties: props,
            };
//!             ├── IndexedExec(chunk_1) ── IndexedStream ── RowGroupBitsetSource
        Ok(
    config: Arc<IndexedTableConfig>,
    // QueryShardExec holds an ExecutionPlanMetricsSet (not Clone). We only
            if row_groups.is_empty() {
            )
    ) -> Self {
    }
        // `ordering=` shows whether the sort-aware path fired:
        //   - `sorted=[<col> ASC|DESC, ...]`: chain held, output_ordering
            Field::new("b", DataType::Utf8, false),
            let rg_set: HashSet<usize> = chunk.row_group_indices.iter().copied().collect();
    /// `gather_filters_for_pushdown` already returns an empty description — the
                }
                }
                let chained = futures::stream::iter(streams).flatten();
/// each backed by one or more `IndexedExec`s (chained per-chunk).
                Arc::new(Schema::new(fields))
            describe_ordering(&self.advertised_ordering),
    ///
                chunk,
            row_id_output_index: self.row_id_output_index,
        } else {
    predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
            .field("partitions", &self.config.query_config.target_partitions)
                            &rg_indices,
        }
    pub pushdown_predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
    /// `SortPreservingMergeExec` for the outer `SortExec(TopK)`.
            FilterPushdownPropagation::with_parent_pushdown_result(statuses)
                query_config: Arc::clone(&self.config.query_config),
    /// Conservative by design — a `false` here just keeps the parent's
            io_stats: Arc::new(ReadIoStats::default()),
    ) -> Result<Vec<TableProviderFilterPushDown>> {
                    return Ok(TreeNodeRecursion::Stop);
            evaluator_factory: Arc::new(|_, _, _, _| unreachable!()),
>;
                }
    }
use super::parquet_bridge::ReadIoStats;
                statuses.push(PushedDown::Yes);
            Some(cols)
        //     advertised → DataFusion can substitute SortPreservingMergeExec.
                    all_cols_known = false;
                for m in set.iter() {
        // If present, we strip it from the parquet read and compute it from position.
impl QueryShardExec {
/// `IndexedExec`, or this factory's signature. Evaluators that carry
        vec![]
                projection: self.projection.clone(),
            Field::new("a", DataType::Int32, false),
                &stream_metrics,
        let dynamic_filter: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = (!self
    /// the parquet file) is declined so we never try to prune on absent stats.
                Box::pin(RecordBatchStreamAdapter::new(schema, chained))
    /// Cumulative row count from all preceding segments. Used to compute
    /// These reference only the SORT columns, never the WHERE clause — so they
    /// Runtime dynamic filters accepted from a parent operator (typically a
    /// Parquet-native residual predicate to push into decode time via
                Partitioning::UnknownPartitioning(1),
                }
        // optimizer's chain check at `file_scan_config.rs:551` would accept,
                global_base: segment.global_base,
}
                statuses,
    projection: Option<Vec<usize>>,
    }
        // the bare `true` placeholder) carries no pruning signal.
/// `RowGroupBitsetSource` is the single seam that determines *where* tree
        self.projected_schema.clone()
            Err(_) => break,
/// # Pluggability
        // and that we're not on the QTF row-id-emit path (gated for v1).
 * SPDX-License-Identifier: Apache-2.0
}
    pub segments: Vec<SegmentFileInfo>,
        dynamic_filters: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
    EquivalenceProperties, LexOrdering, Partitioning, PhysicalSortExpr,
            .get(i)
                    .iter()
) -> Option<LexOrdering> {
        Ok(vec![TableProviderFilterPushDown::Exact; filters.len()])
            &SegmentChunk,
//! the `QueryShardExec` it wraps, and the `IndexedExec`s it spawns are
            projected_schema: self.projected_schema.clone(),
    /// Object-store-relative path to the parquet file (same as the
    for (i, field) in sort_fields.iter().enumerate() {
use datafusion::physical_optimizer::pruning::PruningPredicate;
    }
                    .map(|(tree, preds, schema)| {
    /// injected. `None` means no row ID computation (normal data path).
    }
// ── QueryShardExec ───────────────────────────────────────────────────
}
            })
                .iter()
    sort_fields: &[String],
use datafusion::catalog::{Session, TableProvider};
    pub sort_max: Option<datafusion::common::ScalarValue>,
                cancellation_token: self.config.cancellation_token.clone(),
        f.debug_struct("IndexedTableProvider")
    /// Residual physical predicate pushed down from the planner. Threaded
    /// Empty unless `handle_child_pushdown_result` accepted one.
            ));
                }
    /// Full-schema column indices referenced by BoolNode Predicate leaves.
                let mut cols = proj.clone();
use crate::indexed_table::metrics::StreamMetrics;
}
        let mut statuses = Vec::with_capacity(child_pushdown_result.parent_filters.len());
    #[tokio::test]
        let read_projection: Option<Vec<usize>> = if self.config.emit_row_ids {
///
        let full_schema = self.config.schema.clone();
    pub evaluator_factory: EvaluatorFactory,
    pub sort_orders: Vec<String>,
            projection: self.projection.clone(),
        let mut combined = self.metrics.clone_inner();
    fn schema(&self) -> SchemaRef {
                    .as_ref()
        )
    }
            Partitioning::UnknownPartitioning(assignments.len().max(1)),
pub struct IndexedTableConfig {
        // Predicates via arrow kernels in refinement). DataFusion
                        ))
            .config
    /// that crosses the FFM boundary to identify a segment on the Java side.
    fn clone_with_dynamic_filters(
//!             ▼
                None,
pub struct QueryShardExec {
            let exec_eq_props = match &self.advertised_ordering {
//!
                EmissionType::Incremental,
        ));
use datafusion::physical_plan::execution_plan::{Boundedness, EmissionType};
        for chunk in &assignment.chunks {
        }
                projected_schema.clone(),
/// cross-chunk or cross-query state (e.g. a Java-resident tree) should
pub struct SegmentFileInfo {
                fields[idx] = Field::new(crate::ROW_ID_COLUMN_NAME, DataType::Int64, false);
use datafusion::logical_expr::{Expr, TableProviderFilterPushDown};
                seg_arrow_schema: segment.arrow_schema.clone(),
        };
    /// `index.sort.field` — column names that the parquet writer used to sort
        let ctx = SessionContext::new();
                None => row_id_col_in_full_schema,
            }
use datafusion::execution::SendableRecordBatchStream;
    }
    /// rows on disk. Empty when the index has no `index.sort.field`.
        use datafusion::common::tree_node::{TreeNode, TreeNodeRecursion};
                .row_groups
    /// Writer generation for this segment — the stable per-segment identifier
        // Surface the sort-aware-path decision as a counter so it's visible in
        let provider = IndexedTableProvider::new(empty_config());
            .field("partitions", &self.assignments.len())
            .downcast_ref::<QueryShardExec>()
            descending,
    /// being read from parquet. Other projected columns are read normally.
};
                predicate: self.predicate.clone(),
        let mut accepted: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = Vec::new();
    }
}
                base
/// projected schema, mirroring DataFusion's `create_ordering`
            for (i, e) in lex.iter().enumerate() {
                    .collect(),
    /// instead of re-deriving from the footer on every access.
    fn properties(&self) -> &Arc<PlanProperties> {
            .finish()
        _state: &dyn Session,
            projection.map(|proj| {
    ///
            (assignments, eq, Some(lex))
        )
        let opts = SortOptions {
//! factory closure supplied in `IndexedTableConfig`. The provider itself,
                Some(lex) => EquivalenceProperties::new_with_orderings(
    /// parent's self-filter arrives here as `parent_filters`. We accept a filter
            streams.push(exec.execute(0, Arc::clone(&context))?);
            predicate,
        child_pushdown_result: datafusion::physical_plan::filter_pushdown::ChildPushdownResult,
pub struct IndexedTableProvider {
        };
#[derive(Debug, Clone)]
        }
    /// the same ordering so DataFusion's `EnforceSorting` can substitute
    pub row_groups: Vec<RowGroupInfo>,
    /// holds a non-`Clone` `ExecutionPlanMetricsSet`; we mint a fresh one (the
            ),
}
        // Row-group-aligned partition assignments
            );
    compute_assignments, compute_assignments_one_per_segment, segments_chain_on_sort_key,
            return Ok(FilterPushdownPropagation::with_parent_pushdown_result(
use datafusion::physical_expr::expressions::col as physical_col;
    ) -> Result<
/// One execution plan per query. Partitions into `assignments.len()` streams,
///   keep whatever prefix we built (the rest is "violated"),
                            schema,
        SchemaRef,
            } else {
            assignments,
            .finish()
            query_config: std::sync::Arc::new(
            1 => streams.into_iter().next().unwrap(),
//!             │
        };
        assert!(pred.is_none(), "no filters → no predicate");
            full_schema,
    }
            build_projected_lex_ordering(
            .is_empty())
    }
            s.push(']');
    /// Column index in the OUTPUT schema where computed `___row_id` should be
            && !self.config.emit_row_ids
use super::partitioning::{
use datafusion::datasource::TableType;
                    s.push_str(", ");
            let mut cols = output_cols;
                    if !cols.contains(&idx) {
    /// pushdown. Each is read per row-group at execution time to prune RGs
    /// shard-global row IDs: `global_base + rg.first_row + position_in_rg`.
            }
        filters: &[Expr],
    /// the chain decision (treated as "can't chain").
    }
        let ascending = !descending;
            let assignments = compute_assignments(&layouts, target_partitions);
                row_id_output_index: self.row_id_output_index,
        // Ignore DataFusion's `filters` argument. The `index_filter(...)`
            _ => {
    assignments: Vec<PartitionAssignment>,
            }
}
}
                Boundedness::Bounded,
        // the row-count partitioning. Mirror of `create_ordering` at
        .then(|| datafusion::physical_expr::utils::conjunction(self.dynamic_filters.clone()));
    pub sort_min: Option<datafusion::common::ScalarValue>,
                metrics: ExecutionPlanMetricsSet::new(),
    pub parquet_size: u64,
        // Only the Post phase carries dynamic filters; in Pre we own static
        // the full WHERE semantics.
    fn drop(&mut self) {
        self: Arc<Self>,
            && target_partitions >= self.config.segments.len();
    ) -> Option<&Arc<dyn datafusion::physical_expr::PhysicalExpr>> {
    }
            .map(|seg| SegmentLayout {
/// produces a `BitmapTreeEvaluator`-backed `TreeBitsetSource`.
            cols.sort();
                        Arc::new(StatsPruneTree::build_from_bool_node(
        let phys = match physical_col(field, projected_schema) {
    inner_parquet_metrics: Arc<std::sync::Mutex<Vec<MetricsSet>>>,
///
    /// goes through this same store resolution as vanilla — no hardcoded
use std::collections::HashSet;
        // fully handles every WHERE filter (Collectors via FFM bitsets,
use crate::search_stats::accumulate_from_exec;
            for &idx in &self.config.predicate_columns {
    /// receives from DataFusion, because DataFusion's filters include
            None
            .expect("scan returns QueryShardExec");
    fn empty_config() -> IndexedTableConfig {
        stream_metrics.io_stats = Some(Arc::clone(&self.io_stats));
    /// pushdown rewrite happens before execution, so no metrics are lost) and
    projected_schema: &SchemaRef,
use super::bool_tree::BoolNode;
        filters: &[&Expr],
/// - on first column that doesn't resolve, **break** out of the loop and
    /// `scan()` uses this rather than the `filters` argument it
/// DESC → NULLS LAST. Same as the vanilla path's `build_file_sort_order` in
    /// `FilterExec` in place — declining is always correctness-safe.
            let row_groups: Vec<RowGroupInfo> = segment
        let pmetrics = PartitionMetrics::new(&self.metrics, partition);
    properties: Arc<PlanProperties>,
    LexOrdering::new(exprs)
                Some(proj) => proj
        &self,
            EmissionType::Incremental,
            io_stats: Arc::clone(&self.io_stats),
        &self,
            // ASC → NULLS FIRST, DESC → NULLS LAST (matches Lucene + vanilla path).
    match ordering {
        };
}
                            &segment.metadata,
impl ExecutionPlan for QueryShardExec {
        }
        Arc<BoolNode>,
                &projected_schema,
        Ok(Arc::new(QueryShardExec {
        return None;
        // to `ParquetSource::with_predicate` — is derived from the
    metrics: ExecutionPlanMetricsSet,
    PartitionAssignment, SegmentChunk, SegmentLayout,
                    continue;
    }
                segment,
    fn metrics(&self) -> Option<MetricsSet> {
//! This is the ONE provider. Paths B and C differ only in the evaluator
///
    pub writer_generation: i64,
                    );
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
                }
use std::fmt;
            ordering_optimized.add(1);
            // sorted run and we advertise the same ordering as the parent
            if let Some(idx) = row_id_output_index {
        self.config.schema.clone()
        let mut all_cols_known = true;
mod tests {
            && lex_ordering.is_some()
/// Table provider. Returns a `QueryShardExec` that fans out across chunks.
        let predicate = self.config.pushdown_predicate.clone();
        // (chain held + lead column projected + non-QTF), 0 otherwise.
                metadata: Arc::clone(&segment.metadata),
use datafusion_common::DataFusionError;
};
        //   - `unsorted`: no `index.sort.field`, OR sort field set but the
        }
/// keep that state external and reference it by handle from the evaluator.
        let new_self = self.clone_with_dynamic_filters(accepted);
    /// it references must exist in our full (parquet) schema. Dynamic filters
    /// - `FilterClass::SingleCollector`: residual (non-Collector
    pub emit_row_ids: bool,
    /// Query-scoped tunables (batch_size, target_partitions, costs, …).
            };
use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
    pub query_config: Arc<DatafusionQueryConfig>,
        let assignment = self.assignments.get(partition).ok_or_else(|| {
//! ```
    ///   refinement in `on_batch_mask`; pushdown would risk invoking
        projection: Option<&Vec<usize>>,
use crate::indexed_table::page_pruner::StatsPruneTree;
            };
    /// by `execute_indexed_query`:
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
        let output_schema: SchemaRef = {
    }
    /// `ParquetSource::with_predicate`. Derived from the BoolNode tree
        // index sort, segments that chain on the lead sort key (per-segment
        }
                vec![lex.clone()],
    > {
        Arc<std::collections::HashMap<usize, Arc<PruningPredicate>>>,
            .map(|s| s.eq_ignore_ascii_case("desc"))
    fn children(&self) -> Vec<&Arc<dyn ExecutionPlan>> {
            // Build stats prune tree for segment/RG/subtree-level pruning.
            Ok(e) => e,
    /// Min/max of the LEAD `index.sort.field` column across all row groups
    sort_orders: &[String],
    /// URL of the store for DataFusion's `FileScanConfig`.
    fn handle_child_pushdown_result(
        provider: &IndexedTableProvider,
                &self.config.sort_fields,
    /// When true, the `___row_id` column in the output projection is computed
    fn statistics(&self) -> Option<Statistics> {
    use super::*;
        for f in &child_pushdown_result.parent_filters {
        // otherwise FilterExec would try to evaluate the
            inner_parquet_metrics: Arc::clone(&self.inner_parquet_metrics),
            .iter()
    /// (BoolNode tree, prebuilt PruningPredicates keyed by Arc ptr, schema)
    ) -> Result<Arc<dyn ExecutionPlan>> {
    /// - `FilterClass::Tree`: `None` (BitmapTreeEvaluator does all
        accumulate_from_exec(&self.metrics, &self.inner_parquet_metrics, &self.io_stats);
                    native_bridge_common::log_debug!(
}
    /// Rebuild this exec with accepted dynamic filters attached. `QueryShardExec`
        //
            Vec::with_capacity(assignment.chunks.len());
        // `Exact` — the BoolNode tree held by the evaluator factory
            row_id_output_index,
///
        // sort field is projected away, this returns None and we fall back to
                if !spt.rg_can_match.iter().any(|&k| k) {
//! Unified DataFusion `TableProvider` for all indexed-query paths.
        IndexedTableConfig {
                            preds,
    pub schema: SchemaRef,
            Boundedness::Bounded,
            segments: Vec::new(),
            let base: SchemaRef = match projection {
        let pred = scan_predicate(&provider, &[]).await;
        &self,
            Option<&Arc<StatsPruneTree>>,
            }
    ) -> Result<SendableRecordBatchStream> {
            .dynamic_filters
            }
            advertised_ordering: self.advertised_ordering.clone(),
    ///
    ) -> bool {
    pub fn new(config: IndexedTableConfig) -> Self {
    /// apply it during decode.
                EquivalenceProperties::new(projected_schema.clone()),
    pub metadata: Arc<ParquetMetaData>,
    /// whose parquet statistics cannot satisfy the (tightening) predicate.
/// Build a `LexOrdering` from `sort_fields` / `sort_orders` against the given
            }
                let mut fields: Vec<Field> =
fn build_projected_lex_ordering(
            }
        // min/max are disjoint), `target_partitions >= num_segments` so the
};
 * this file be licensed under the Apache-2.0 license or a
use futures::StreamExt;
                    vec![lex.clone()],
        context: Arc<datafusion::execution::TaskContext>,
        // `physical-expr/src/physical_expr.rs:134` — break on first
        if let Ok(inner) = self.inner_parquet_metrics.lock() {
use datafusion::physical_expr::{
        // WHERE semantics via the BoolNode tree and want no interference.
    fn name(&self) -> &str {
                .with_updated_node(Arc::new(new_self) as Arc<dyn ExecutionPlan>),
    fn with_new_children(
        let schema = Arc::new(Schema::new(vec![
use async_trait::async_trait;
    pub store: Arc<dyn object_store::ObjectStore>,
    /// sort-aware partitioning fired (chain holds + lead column is in the
            .field("segments", &self.config.segments.len())
        };
        let row_id_output_index: Option<usize> = if self.config.emit_row_ids {
    }
#[cfg(test)]
            )
    /// the `index_filter(...)` UDF marker whose body panics.
            full_schema: self.full_schema.clone(),
    /// True if `filter` can be used for per-RG statistics pruning: every column
    /// down to `IndexReader` so the scan cooperatively stops when the query task
            f,
use datafusion::physical_plan::{DisplayAs, DisplayFormatType, ExecutionPlan, PlanProperties};
            DataFusionError::Internal(format!("partition {} out of range", partition))
    // need to inspect `.predicate`, so read through a reference.
        Ok(stream)
    )>,
    dynamic_filters: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        };
    /// `docs/dynamic-filters-indexed-table-impl.md` §4b.
                    });
        write!(
    }
                .cloned()
            .unwrap_or(false);
                DataFusionError::Internal(format!("segment_idx {} out of range", chunk.segment_idx))
/// The closure is cloneable (stored in an `Arc`) so the provider can spawn
        &self,
                        "[segment-skip] skipping chunk — pruned by segment-level stats"
    config: Arc<IndexedTableConfig>,
            self.assignments.len(),
    /// Parallel to `sort_fields`. Each entry is `"asc"` or `"desc"` (lowercase,
        &self,
            assignments: self.assignments.clone(),
        Some(combined)
    /// `ObjectMeta.location` DataFusion uses for the vanilla `ListingTable`).
    }
                    cols.push(idx);
    }
        partition: usize,
impl IndexedTableProvider {
    Count, ExecutionPlanMetricsSet, MetricBuilder, MetricsSet,
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    /// are orthogonal to the Lucene/parquet boolean split. See
                        let rg_indices: Vec<usize> = row_groups.iter().map(|rg| rg.index).collect();
            })?;
        // config by that caller.
            dynamic_filters,
            sort_orders: vec![],
                    .prune_tree_config
    ///
            config: Arc::new(config),
        }))
                    .collect(),
        _config: &datafusion::config::ConfigOptions,
    /// Accept runtime dynamic filters (TopK / join) pushed from a parent.
impl TableProvider for IndexedTableProvider {
            0 => {
            let exec = IndexedExec {
                ),
/// but a future `JavaTreeBitsetSource` could route per-RG evaluation to
    ) -> Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>> {
                        cols.push(idx);
            .collect();
            let stats_prune_tree =
                full_schema: self.full_schema.clone(),
            advertised_ordering,
/// analytics-core via an FFM upcall without touching `IndexedStream`,
    /// LocalFileSystem. Resolved once per query from the runtime env.
                stats_prune_tree.as_ref(),
    /// Test-only accessor for the conjoined physical predicate produced
    }
    /// matches the wire format from `DataFusionPlugin`). Same length as
                    }
                    .filter(|&idx| Some(idx) != row_id_col_in_full_schema)
            s
}
    /// readable parquet column in our schema (so per-RG statistics pruning is
            self.config.segments.len(),
        Self {
                let _ = write!(&mut s, "{} {}", e.expr, dir);
impl DisplayAs for QueryShardExec {
        _limit: Option<usize>,
        });
            dynamic_filters: Vec::new(),
            .segments
    /// stats for the lead column, or when the column type isn't supported by
/// Configuration used to build an `IndexedTableProvider`.
            use std::fmt::Write;
            pushdown_predicate: None,
            if let Some(ref spt) = stats_prune_tree {
                    .copied()
            let output_cols: Vec<usize> = match projection {
    fn table_type(&self) -> TableType {
            // Segment-level skip: if no RG in the chunk can match, skip entirely.
    use datafusion::prelude::SessionContext;
                let empty =
    /// `FilterExec` and forgoes the optimization; it can never drop a row.
        } else {
                cols.sort();
            let lex = lex_ordering.unwrap();
            .map_err(|e| DataFusionError::External(e.into()))?;
    async fn scan(
            metrics: ExecutionPlanMetricsSet::new(),
//! identical across paths.
        })?;
            projection.cloned()
        let mut stream_metrics =
    io_stats: Arc<ReadIoStats>,
            &StreamMetrics,
        //     sort-aware path didn't fire (chain didn't hold, target_partitions
        if accepted.is_empty() {
        Some(lex) => {
    pub predicate_columns: Vec<usize>,
        let metrics = ExecutionPlanMetricsSet::new();
                file_size: segment.parquet_size,
        let ordering_optimized: Count =
                doc_range: Some((chunk.doc_min, chunk.doc_max)),
    async fn scan_with_no_filters_produces_none_predicate() {
                None => full_schema.clone(),
                cols
    fn execute(
        // removes the outer FilterExec, which is important because
    /// Object store for reading parquet bytes. All I/O on the indexed path
    }
            let segment = self.config.segments.get(chunk.segment_idx).ok_or_else(|| {
/// (`physical-expr/src/physical_expr.rs:134`):
        } else if self.config.predicate_columns.is_empty() {
                if self.full_schema.index_of(c.name()).is_err() {
            predicate: self.predicate.clone(),
/// evaluation happens. Today the built-in impls all walk the tree in Rust,
            return Ok(FilterPushdownPropagation::if_all(child_pushdown_result));
use datafusion::parquet::file::metadata::ParquetMetaData;
                            tree,
            properties,
        phase: datafusion::physical_plan::filter_pushdown::FilterPushdownPhase,
                    }
            nulls_first: ascending,
        if advertised_ordering.is_some() {
        + Send
        self.predicate.as_ref()
                &self.config.sort_orders,
            // chain-aware partitioning guarantees this chunk is one whole
use super::eval::RowGroupBitsetSource;
    fn dynamic_filter_is_acceptable(
    /// `sort_fields` (validated at index creation).
        let (assignments, eq_properties, advertised_ordering) = if chain_ok
    /// Query-level data for building StatsPruneTree per segment.
        let _ = filter.apply(|e| {
    ///   the `index_filter` UDF).
    ) -> Result<Arc<dyn ExecutionPlan>> {
            let mut s = String::from("sorted=[");
        use datafusion::physical_expr::expressions::Column;
                assignments,
/// - returns `None` when the prefix is empty (no useful claim to advertise).
                    base.fields().iter().map(|f| f.as_ref().clone()).collect();
    fn fmt_as(&self, _t: DisplayFormatType, f: &mut std::fmt::Formatter) -> fmt::Result {
            MetricBuilder::new(&metrics).global_counter("ordering_optimized");
        // Output schema = what DataFusion expects (includes ___row_id if projected).
                crate::datafusion_query_config::DatafusionQueryConfig::test_default(),
        }
        QueryShardExec {
    pub prune_tree_config: Option<(
    /// `SortExec`-TopK `DynamicFilterPhysicalExpr`) via physical filter
                        continue;
    }
            }
        &self.properties
use datafusion::physical_plan::metrics::{
            store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
    }
//!     QueryShardExec (1 per query, partitioned across chunks)
use datafusion::common::{Result, Statistics};
    row_id_output_index: Option<usize>,
                    .filter(|&&idx| Some(idx) != row_id_col_in_full_schema)
}
                let schema = self.projected_schema.clone();
fn describe_ordering(ordering: &Option<LexOrdering>) -> String {
        let shard = plan
        _children: Vec<Arc<dyn ExecutionPlan>>,
pub type EvaluatorFactory = Arc<
/// `session_context.rs`.
            sort_fields: vec![],
        let mut streams: Vec<SendableRecordBatchStream> =
            config: Arc::clone(&self.config),
#[async_trait]
                exec_eq_props,
                    self.projected_schema.clone(),
        // EXPLAIN ANALYZE / `metrics()` output: 1 when ordering was advertised
    if sort_fields.is_empty() {
