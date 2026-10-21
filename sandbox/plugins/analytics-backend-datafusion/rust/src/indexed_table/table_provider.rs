                fields[idx] = Field::new(crate::ROW_ID_COLUMN_NAME, DataType::Int64, false);
            Vec::with_capacity(assignment.chunks.len());
            advertised_ordering,
        datafusion::physical_plan::filter_pushdown::FilterPushdownPropagation<
        let opts = SortOptions {
        }
    use super::*;
            .finish()
use super::eval::RowGroupBitsetSource;
        // WHERE semantics via the BoolNode tree and want no interference.
            assignments: self.assignments.clone(),
        saw_column && all_cols_known
                &self.config.sort_orders,
            if row_groups.is_empty() {
            MetricBuilder::new(&metrics).global_counter("ordering_optimized");
        &self,
        // UDF call would be in there (its body panics), and the
impl fmt::Debug for QueryShardExec {
        // If present, we strip it from the parquet read and compute it from position.
use datafusion::physical_expr::expressions::col as physical_col;
            projection.cloned()
            if let Some(idx) = row_id_output_index {
            Err(_) => break,
    }
                store_url: self.config.store_url.clone(),
            }
        let chain_ok = !self.config.sort_fields.is_empty()
            use std::fmt::Write;
    for (i, field) in sort_fields.iter().enumerate() {
    /// Accept runtime dynamic filters (TopK / join) pushed from a parent.
        _children: Vec<Arc<dyn ExecutionPlan>>,
    /// Query-level data for building StatsPruneTree per segment.
    fn children(&self) -> Vec<&Arc<dyn ExecutionPlan>> {
            query_config: std::sync::Arc::new(
    pub sort_min: Option<datafusion::common::ScalarValue>,
    /// apply it during decode.
    /// sort-aware partitioning fired (chain holds + lead column is in the
            }
        ));
        f.debug_struct("IndexedTableProvider")
        &self,
use datafusion::datasource::TableType;
                    }
            sort_orders: vec![],
                metadata: Arc::clone(&segment.metadata),
use crate::search_stats::accumulate_from_exec;
        let mut statuses = Vec::with_capacity(child_pushdown_result.parent_filters.len());
        assert!(pred.is_none(), "no filters → no predicate");
            Arc<dyn ExecutionPlan>,
    /// Shared by reference across fanned-out `QueryShardExec` instances.
    fn table_type(&self) -> TableType {
        // Only the Post phase carries dynamic filters; in Pre we own static
    sort_fields: &[String],
    /// `FilterExec` in place — declining is always correctness-safe.
                base
    }
/// analytics-core via an FFM upcall without touching `IndexedStream`,
        accumulate_from_exec(&self.metrics, &self.inner_parquet_metrics, &self.io_stats);
    // QueryShardExec holds an ExecutionPlanMetricsSet (not Clone). We only
    /// `docs/dynamic-filters-indexed-table-impl.md` §4b.
    /// projected schema). Each `IndexedExec` spawned by `execute()` advertises
    /// Min/max of the LEAD `index.sort.field` column across all row groups
    fn schema(&self) -> SchemaRef {
    }
            match projection {
/// The closure is cloneable (stored in an `Arc`) so the provider can spawn
    }
    ///
    /// Conservative by design — a `false` here just keeps the parent's
                    .as_ref()
    /// the chain decision (treated as "can't chain").
            let assignments = compute_assignments(&layouts, target_partitions);
    /// the same ordering so DataFusion's `EnforceSorting` can substitute
            let eq = EquivalenceProperties::new_with_orderings(
    ///   children of top AND) as a single `PhysicalExpr`.
            projection.map(|proj| {
    config: Arc<IndexedTableConfig>,
        };
fn build_projected_lex_ordering(
                Box::pin(RecordBatchStreamAdapter::new(schema, chained))
                if !spt.rg_can_match.iter().any(|&k| k) {
            properties: Arc::clone(&self.properties),
                            preds,
                full_schema: self.full_schema.clone(),
                .row_groups
    /// is cancelled. `None` for untracked queries (`context_id == 0`) and tests.
        let mut accepted: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = Vec::new();
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
//!
    dynamic_filters: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
    /// the parquet file) is declined so we never try to prune on absent stats.
    }
            )
            // `SortPreservingMergeExec` for the outer `SortExec(TopK)`.
                        cols.push(idx);
        } else if self.config.predicate_columns.is_empty() {
//! the `QueryShardExec` it wraps, and the `IndexedExec`s it spawns are
                .collect();
use datafusion::physical_optimizer::pruning::PruningPredicate;
            return Ok(FilterPushdownPropagation::with_parent_pushdown_result(
    ///
            f,
        Ok(vec![TableProviderFilterPushDown::Exact; filters.len()])
                }
        // the full WHERE semantics.
    /// it references must exist in our full (parquet) schema. Dynamic filters
                    .prune_tree_config
}
                    if name == "output_rows" || name == "output_batches" || name == "output_bytes" {
mod tests {
            }
            Boundedness::Bounded,
#[async_trait]
    ///   the `index_filter` UDF).
    /// Read from the parquet footer key-value metadata
                            tree,
        vec![]
        };
                    .map(|(tree, preds, schema)| {
    /// `QueryShardExec` is a leaf (no children), so the default
        };
            })?;
            Some(cols)
            pushdown_predicate: None,
        write!(
                let dir = if e.options.descending { "DESC" } else { "ASC" };
    full_schema: SchemaRef,
                if !cols.contains(&idx) {
        };
    use datafusion::logical_expr::{col, lit};
        // to `ParquetSource::with_predicate` — is derived from the
                .filter(|rg| rg_set.contains(&rg.index))
        Ok(
        &self.properties
            describe_ordering(&self.advertised_ordering),
                Partitioning::UnknownPartitioning(1),
        let mut all_cols_known = true;
            }
    /// whose parquet statistics cannot satisfy the (tightening) predicate.
        // Ignore DataFusion's `filters` argument. The `index_filter(...)`
                    .collect(),
                        let rg_indices: Vec<usize> = row_groups.iter().map(|rg| rg.index).collect();
        }
    /// Test-only accessor for the conjoined physical predicate produced
            }
                schema: self.projected_schema.clone(),
    Count, ExecutionPlanMetricsSet, MetricBuilder, MetricsSet,
            full_schema: self.full_schema.clone(),
                Boundedness::Bounded,
        Ok(self)
/// produces a `SingleCollectorEvaluator`. For the multi-filter tree path it
    /// Per-query cancellation token (from the global `QUERY_REGISTRY`). Threaded
use datafusion::parquet::file::metadata::ParquetMetaData;
        })?;
    /// - `FilterClass::Tree`: `None` (BitmapTreeEvaluator does all
        } else {
        let (assignments, eq_properties, advertised_ordering) = if chain_ok
    /// shard-global row IDs: `global_base + rg.first_row + position_in_rg`.
                projected_schema.clone(),
    pub emit_row_ids: bool,
        // `physical-expr/src/physical_expr.rs:134` — break on first
    /// goes through this same store resolution as vanilla — no hardcoded
                    }
        + Send
    }
        let projected_schema = output_schema;
    /// instead of re-deriving from the footer on every access.
                projection: self.projection.clone(),
                stream_metrics: stream_metrics.clone(),
 *
            segments: Vec::new(),
            projection: self.projection.clone(),
                .iter()
            })
            row_id_output_index,
        // the bare `true` placeholder) carries no pruning signal.
        return None;
                exec_eq_props,
use super::metrics::PartitionMetrics;
            };
        // `Exact` — the BoolNode tree held by the evaluator factory
            .field("partitions", &self.assignments.len())
            properties,
/// One execution plan per query. Partitions into `assignments.len()` streams,
///
    sort_orders: &[String],
        if phase != FilterPushdownPhase::Post {
    pub sort_orders: Vec<String>,
        // The pushdown predicate — the parquet-native residual to hand
    pub max_doc: i64,
                Some(proj) => Arc::new(full_schema.project(proj)?),
            &SegmentChunk,
            sort_fields: vec![],
///
                }
    /// from position (global_base + rg.first_row + position_in_rg) instead of
    ///   refinement in `on_batch_mask`; pushdown would risk invoking
        }
    fn drop(&mut self) {
            if let Some(c) = e.downcast_ref::<Column>() {
                    .filter(|&&idx| Some(idx) != row_id_col_in_full_schema)
                    .filter(|&idx| Some(idx) != row_id_col_in_full_schema)
    /// `ParquetSource::with_predicate`. Derived from the BoolNode tree
/// # Pluggability
use async_trait::async_trait;
    pub row_groups: Vec<RowGroupInfo>,
    /// holds a non-`Clone` `ExecutionPlanMetricsSet`; we mint a fresh one (the
}
        let provider = IndexedTableProvider::new(empty_config());
            row_id_output_index: self.row_id_output_index,
    pub pushdown_predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        //   - `sorted=[<col> ASC|DESC, ...]`: chain held, output_ordering
                doc_range: Some((chunk.doc_min, chunk.doc_max)),
            }
                    .copied()
        };
            };
        });
        _state: &dyn Session,
    inner_parquet_metrics: Arc<std::sync::Mutex<Vec<MetricsSet>>>,
                    );
        let _ = filter.apply(|e| {
    /// matches the wire format from `DataFusionPlugin`). Same length as
            predicate: self.predicate.clone(),
        exprs.push(PhysicalSortExpr::new(phys, opts));
        // Build the LexOrdering against the projected schema. If the lead
impl QueryShardExec {
            .expect("scan");
                predicate: self.predicate.clone(),
        let ascending = !descending;
            Ok(TreeNodeRecursion::Continue)
    /// Both `None` when no sort field is configured, when any RG is missing
            ordering_optimized.add(1);
        )
                let mut fields: Vec<Field> =
    /// Empty unless `handle_child_pushdown_result` accepted one.
        Some(combined)
    /// - `FilterClass::SingleCollector`: residual (non-Collector
        };
/// evaluation happens. Today the built-in impls all walk the tree in Rust,
        // Decide whether to use the sort-aware path: requires a configured
/// Info about a segment and its corresponding parquet file.
            io_stats: Arc::clone(&self.io_stats),
    fn statistics(&self) -> Option<Statistics> {
    pub schema: SchemaRef,
                            &segment.metadata,
    }
        let plan = provider
            projection: read_projection,
                        "[segment-skip] skipping chunk — pruned by segment-level stats"
}
    let mut exprs: Vec<PhysicalSortExpr> = Vec::with_capacity(sort_fields.len());
                }
    #[tokio::test]
            return Ok(FilterPushdownPropagation::if_all(child_pushdown_result));
        use datafusion::common::tree_node::{TreeNode, TreeNodeRecursion};
 * The OpenSearch Contributors require contributions made to
        let row_id_output_index: Option<usize> = if self.config.emit_row_ids {
// ── QueryShardExec ───────────────────────────────────────────────────
impl DisplayAs for QueryShardExec {
pub struct IndexedTableConfig {
                metrics: ExecutionPlanMetricsSet::new(),
            .downcast_ref::<QueryShardExec>()
    }
                ),
use datafusion::physical_plan::metrics::{
    pub writer_generation: i64,
    fn execute(
            let props = Arc::new(PlanProperties::new(
        >,
    /// These reference only the SORT columns, never the WHERE clause — so they
        }))
}
    }
        &self,
        // `ordering=` shows whether the sort-aware path fired:
    }
            for &idx in &self.config.predicate_columns {
            assignments,
    }
        // `index_filter(...)` UDF whose body panics by design.
    fn supports_filters_pushdown(
                let _ = write!(&mut s, "{} {}", e.expr, dir);
            .map(|s| s.eq_ignore_ascii_case("desc"))
            }
    ) -> Result<
        TableType::Base
    advertised_ordering: Option<LexOrdering>,
        // optimizer's chain check at `file_scan_config.rs:551` would accept,
        &self,
    async fn scan_with_no_filters_produces_none_predicate() {
impl Drop for QueryShardExec {
                            &rg_indices,
        //
    fn dynamic_filter_is_acceptable(
    compute_assignments, compute_assignments_one_per_segment, segments_chain_on_sort_key,
            // `QueryShardExec`. Without this, `EnforceSorting` can't see that
            nulls_first: ascending,
        QueryShardExec {
    /// rows on disk. Empty when the index has no `index.sort.field`.
//! Unified DataFusion `TableProvider` for all indexed-query paths.
                row_groups: seg.row_groups.clone(),
        for chunk in &assignment.chunks {
            .finish()
};
pub struct SegmentFileInfo {
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
    pub object_path: object_store::path::Path,
    pub metadata: Arc<ParquetMetaData>,
    ) -> bool {
                self.config
            )
    projected_schema: SchemaRef,
            }
        "QueryShardExec"
                chunk,
    /// parent's self-filter arrives here as `parent_filters`. We accept a filter
    }
    match ordering {
                    });
                EmissionType::Incremental,
    }
        let full_schema = self.config.schema.clone();
    pub cancellation_token: Option<tokio_util::sync::CancellationToken>,
        // Surface the sort-aware-path decision as a counter so it's visible in
                }
        let pmetrics = PartitionMetrics::new(&self.metrics, partition);
    pub parquet_size: u64,
    ) -> Result<SendableRecordBatchStream> {
            FilterPushdownPhase, FilterPushdownPropagation, PushedDown,
/// but a future `JavaTreeBitsetSource` could route per-RG evaluation to
        let output_schema: SchemaRef = {
        // Output schema = what DataFusion expects (includes ___row_id if projected).
    ///
                statuses.push(PushedDown::Yes);
            let evaluator = (self.config.evaluator_factory)(
            config: Arc::clone(&self.config),
            predicate,
    /// by `scan()`. `None` when no filters were pushed down.
/// (`physical-expr/src/physical_expr.rs:134`):
            metrics: ExecutionPlanMetricsSet::new(),
                seg_arrow_schema: segment.arrow_schema.clone(),
        provider: &IndexedTableProvider,
    /// into each `IndexedExec` so `ParquetSource.with_predicate(...)` can
            ));
        if let Ok(inner) = self.inner_parquet_metrics.lock() {
}
        };
        Arc<BoolNode>,
        let ordering_optimized: Count =
            // segment are in lead-key order. So this `IndexedExec` produces a
    projected_schema: &SchemaRef,
        let metrics = ExecutionPlanMetricsSet::new();
                DataFusionError::Internal(format!("segment_idx {} out of range", chunk.segment_idx))
                cols
    }
    }
        partition: usize,
/// keep that state external and reference it by handle from the evaluator.
        // removes the outer FilterExec, which is important because
    }
            1 => streams.into_iter().next().unwrap(),
        // min/max are disjoint), `target_partitions >= num_segments` so the
        Some(lex) => {
}
            .map_err(|e| DataFusionError::External(e.into()))?;
use std::collections::HashSet;
            // When the sort-aware path fired (`advertised_ordering: Some`), the
pub struct QueryShardExec {
                    combined.push(m.clone());
            build_projected_lex_ordering(
            }
            .expect("scan returns QueryShardExec");
    fn clone_with_dynamic_filters(
            "QueryShardExec: partitions={}, segments={}, ordering={}",
            config: Arc::clone(&self.config),
    pub query_config: Arc<DatafusionQueryConfig>,
    /// Parallel to `sort_fields`. Each entry is `"asc"` or `"desc"` (lowercase,
//!             ├── IndexedExec(chunk_0) ── IndexedStream ── RowGroupBitsetSource
impl IndexedTableProvider {
            } else {
        let mut saw_column = false;
            // Segment-level skip: if no RG in the chunk can match, skip entirely.
        // sort field is projected away, this returns None and we fall back to
//! identical across paths.
            0 => {
use datafusion::common::{Result, Statistics};
            .dynamic_filters
/// `IndexedExec`, or this factory's signature. Evaluators that carry
    /// `gather_filters_for_pushdown` already returns an empty description — the
        projection: Option<&Vec<usize>>,
use datafusion::physical_plan::execution_plan::{Boundedness, EmissionType};
/// Invoked once per chunk per query. For the single-collector path this
impl fmt::Debug for IndexedTableProvider {
    }
//!             ▼
        Ok(Arc::new(QueryShardExec {
            let rg_set: HashSet<usize> = chunk.row_group_indices.iter().copied().collect();
            FilterPushdownPropagation::with_parent_pushdown_result(statuses)
        } else {
}
        // the row-count partitioning. Mirror of `create_ordering` at
        shard.test_predicate().cloned()
        filters: &[&Expr],
            config: Arc::new(config),
            if self.dynamic_filter_is_acceptable(&f.filter) {
                    return Ok(TreeNodeRecursion::Stop);
        let stream: SendableRecordBatchStream = match streams.len() {
            full_schema,
                    all_cols_known = false;
    fn with_new_children(
/// produces a `BitmapTreeEvaluator`-backed `TreeBitsetSource`.
            emit_row_ids: false,
                .cloned()
    LexOrdering::new(exprs)
        let phys = match physical_col(field, projected_schema) {
        Arc<std::collections::HashMap<usize, Arc<PruningPredicate>>>,
            };
use datafusion::physical_expr::{
use super::stream::{IndexedExec, RowGroupInfo};
                    self.projected_schema.clone(),
//!             │
    async fn scan(
    /// reuse the shared `Arc` fields verbatim.
use futures::StreamExt;
    ) -> Option<&Arc<dyn datafusion::physical_expr::PhysicalExpr>> {
        let target_partitions = self.config.query_config.target_partitions.max(1);
    use datafusion::prelude::SessionContext;
//! factory closure supplied in `IndexedTableConfig`. The provider itself,
    config: Arc<IndexedTableConfig>,
                            &segment.arrow_schema,
    ) -> Result<Vec<TableProviderFilterPushDown>> {
        &self,
            // Build stats prune tree for segment/RG/subtree-level pruning.
                    base.fields().iter().map(|f| f.as_ref().clone()).collect();
}
        let layouts: Vec<SegmentLayout> = self
            eq_properties,
        }
        &self,
                &projected_schema,
use super::parquet_bridge::ReadIoStats;
    /// down to `IndexReader` so the scan cooperatively stops when the query task
            pmetrics.into_stream_metrics(Some(Arc::clone(&self.inner_parquet_metrics)));
            store: Arc::new(object_store::local::LocalFileSystem::new()),
}
pub type EvaluatorFactory = Arc<
            } else {
            && !self.config.emit_row_ids
    /// Object-store-relative path to the parquet file (same as the
        let predicate = self.config.pushdown_predicate.clone();
                Some(lex) => EquivalenceProperties::new_with_orderings(
    /// URL of the store for DataFusion's `FileScanConfig`.
        // index sort, segments that chain on the lead sort key (per-segment
                &stream_metrics,
                properties: props,
        ]));
    fn fmt_as(&self, _t: DisplayFormatType, f: &mut std::fmt::Formatter) -> fmt::Result {
        self.config.schema.clone()
    fn name(&self) -> &str {
                }
            })
    fn schema(&self) -> SchemaRef {
        None
            ),
        let mut combined = self.metrics.clone_inner();
    /// possible). Anything else is declined, leaving the parent's safety-net
        None => "unsorted".to_string(),
                file_size: segment.parquet_size,
    /// being read from parquet. Other projected columns are read normally.
            // sorted run and we advertise the same ordering as the parent
use datafusion::arrow::compute::SortOptions;
        ) -> Result<Arc<dyn RowGroupBitsetSource>, String>
            if let Some(ref spt) = stats_prune_tree {
    /// Full-schema column indices referenced by BoolNode Predicate leaves.
use crate::datafusion_query_config::DatafusionQueryConfig;
    pub arrow_schema: SchemaRef,
            .iter()
            streams.push(exec.execute(0, Arc::clone(&context))?);
use super::bool_tree::BoolNode;
>;
            // input partitions are already sorted and won't substitute
    metrics: ExecutionPlanMetricsSet,
            _ => {
            .unwrap_or(false);
            .field("partitions", &self.config.query_config.target_partitions)
            let exec = IndexedExec {
        {
    > {
        _filters: &[Expr],
                segment,
    ) -> Result<Arc<dyn ExecutionPlan>> {
    }
    /// are orthogonal to the Lucene/parquet boolean split. See
//!     QueryShardExec (1 per query, partitioned across chunks)
//! ```text
 */
        // (chain held + lead column projected + non-QTF), 0 otherwise.
/// `session_context.rs`.
/// `RowGroupBitsetSource` is the single seam that determines *where* tree
            let mut s = String::from("sorted=[");
                for &idx in &self.config.predicate_columns {
    fn properties(&self) -> &Arc<PlanProperties> {
                None,
        }
        let mut stream_metrics =
        // config by that caller.
                    .collect(),
            dynamic_filters,
            dynamic_filters: Vec::new(),
            && segments_chain_on_sort_key(&self.config.segments)
//!     IndexedTableProvider (scan)
        if advertised_ordering.is_some() {
    }
        if accepted.is_empty() {
                }
                for m in set.iter() {
    pub store: Arc<dyn object_store::ObjectStore>,
                None => full_schema.clone(),
    properties: Arc<PlanProperties>,
    /// Residual physical predicate pushed down from the planner. Threaded
            .map(|seg| SegmentLayout {
            cancellation_token: None,
            self.assignments.len(),
            // Evaluator factory would never be invoked for this test (no segments).
        let row_id_col_in_full_schema = full_schema.index_of(crate::ROW_ID_COLUMN_NAME).ok();
    // need to inspect `.predicate`, so read through a reference.
        for f in &child_pushdown_result.parent_filters {
        // unresolvable column rather than erroring out.
                        Arc::new(StatsPruneTree::build_from_bool_node(
                statuses.push(PushedDown::No);
///
            Option<&Arc<StatsPruneTree>>,
                    let name = m.value().name();
                saw_column = true;
    /// Parquet-native residual predicate to push into decode time via
}
        phase: datafusion::physical_plan::filter_pushdown::FilterPushdownPhase,
    }
    ) -> Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>> {
            cols.sort();
            .is_empty())
//!             └── IndexedExec(chunk_N) ── IndexedStream ── RowGroupBitsetSource
                let schema = self.projected_schema.clone();
///
/// each backed by one or more `IndexedExec`s (chained per-chunk).
    /// readable parquet column in our schema (so per-RG statistics pruning is
    }
/// cross-chunk or cross-query state (e.g. a Java-resident tree) should
        let read_projection: Option<Vec<usize>> = if self.config.emit_row_ids {
        let mut streams: Vec<SendableRecordBatchStream> =
///
            let lex = lex_ordering.unwrap();
    PartitionAssignment, SegmentChunk, SegmentLayout,
use crate::indexed_table::metrics::StreamMetrics;
    if sort_fields.is_empty() {
            let segment = self.config.segments.get(chunk.segment_idx).ok_or_else(|| {
            ));
/// Factory: build a `RowGroupBitsetSource` for one `SegmentChunk`.
        )
            // ASC → NULLS FIRST, DESC → NULLS LAST (matches Lucene + vanilla path).
                    datafusion::physical_plan::empty::EmptyExec::new(self.projected_schema.clone());
                    .iter()
            )
                query_config: Arc::clone(&self.config.query_config),
    /// Rebuild this exec with accepted dynamic filters attached. `QueryShardExec`
        //     advertised → DataFusion can substitute SortPreservingMergeExec.
use datafusion::execution::SendableRecordBatchStream;
            inner_parquet_metrics: Arc::clone(&self.inner_parquet_metrics),
                assignments,
            None
    /// stats for the lead column, or when the column type isn't supported by
            .field("segments", &self.config.segments.len())
        // BoolNode tree held by the evaluator factory already contains
        IndexedTableConfig {
        let properties = Arc::new(PlanProperties::new(
                        ))
            predicate_columns: vec![],
                empty.execute(0, context)?
                    vec![lex.clone()],
    /// `scan()` uses this rather than the `filters` argument it
    fn handle_child_pushdown_result(
            for set in inner.iter() {
        }
        // EXPLAIN ANALYZE / `metrics()` output: 1 when ordering was advertised
            // segment, and the writer's k-way-merge guarantees rows in this
impl QueryShardExec {
#[derive(Debug, Clone)]
    pub store_url: datafusion::execution::object_store::ObjectStoreUrl,
            io_stats: Arc::new(ReadIoStats::default()),
        let dynamic_filter: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = (!self
        let assignment = self.assignments.get(partition).ok_or_else(|| {
            DataFusionError::Internal(format!("partition {} out of range", partition))
//!
    /// (`opensearch.writer_generation`) at `build_segments` time.
                    cols.push(idx);
    /// injected. `None` means no row ID computation (normal data path).
                    native_bridge_common::log_debug!(
            .field("segments", &self.config.segments.len())
    /// `SortPreservingMergeExec` for the outer `SortExec(TopK)`.
        };
};
        }
    /// `index.sort.field` — column names that the parquet writer used to sort
        //     sort-aware path didn't fire (chain didn't hold, target_partitions
            Ok(e) => e,
use datafusion::logical_expr::{Expr, TableProviderFilterPushDown};
            .collect();
            .scan(&ctx.state(), None, filters, None)
                evaluator: std::sync::Mutex::new(Some(evaluator)),
                    .iter()
    /// reference sort columns; a sort on a Lucene-only / computed column (not in
            store_url: datafusion::execution::object_store::ObjectStoreUrl::local_filesystem(),
    /// LocalFileSystem. Resolved once per query from the runtime env.
use std::sync::Arc;
    ) -> Result<Arc<dyn ExecutionPlan>> {
            );
        let new_self = self.clone_with_dynamic_filters(accepted);
            }
use datafusion::physical_plan::stream::RecordBatchStreamAdapter;
                Some(proj) => proj
            Partitioning::UnknownPartitioning(assignments.len().max(1)),
    /// Sort ordering this scan claims to produce — `Some` only when the
    /// at `build_segments` time by `parquet_to_arrow_schema` and reused by
            &SegmentFileInfo,
    }
                dynamic_filter: dynamic_filter.clone(),
                let chained = futures::stream::iter(streams).flatten();
        // When computing row IDs, replace the ___row_id field type with UInt64.
    /// Object store for reading parquet bytes. All I/O on the indexed path
            let exec_eq_props = match &self.advertised_ordering {
            s.push(']');
            .get(i)
}
    /// `FilterExec` and forgoes the optimization; it can never drop a row.
    fn empty_config() -> IndexedTableConfig {
                .with_updated_node(Arc::new(new_self) as Arc<dyn ExecutionPlan>),
        // BoolNode in `execute_indexed_query` and stashed on the
        &self,
    }
        let ctx = SessionContext::new();
/// Build a `LexOrdering` from `sort_fields` / `sort_orders` against the given
            metrics,
    row_id_output_index: Option<usize>,
/// projected schema, mirroring DataFusion's `create_ordering`
            }
    }
            prune_tree_config: None,
    /// Query-scoped tunables (batch_size, target_partitions, costs, …).
        child_pushdown_result: datafusion::physical_plan::filter_pushdown::ChildPushdownResult,
                stats_prune_tree.as_ref(),
    ///
        let shard = plan
            None
        Self {
    assignments: Vec<PartitionAssignment>,
            let mut cols = output_cols;
/// Table provider. Returns a `QueryShardExec` that fans out across chunks.
use crate::indexed_table::page_pruner::StatsPruneTree;
}
    }
}
        let lex_ordering = if chain_ok {
/// DESC → NULLS LAST. Same as the vanilla path's `build_file_sort_order` in
                Some(proj) => proj
    pub(crate) fn test_predicate(
            let assignments = compute_assignments_one_per_segment(&self.config.segments, &layouts);
        context: Arc<datafusion::execution::TaskContext>,
    pub segments: Vec<SegmentFileInfo>,
                EquivalenceProperties::new(projected_schema.clone()),
                object_path: segment.object_path.clone(),
        .then(|| datafusion::physical_expr::utils::conjunction(self.dynamic_filters.clone()));
                        continue;
        self.projected_schema.clone()
                    .position(|&idx| Some(idx) == row_id_col_in_full_schema),
) -> Option<LexOrdering> {
            (
                if self.full_schema.index_of(c.name()).is_err() {
            evaluator_factory: Arc::new(|_, _, _, _| unreachable!()),
        // Predicates via arrow kernels in refinement). DataFusion
        // Detect __row_id__ in the output projection when emit_row_ids=true.
    /// Runtime dynamic filters accepted from a parent operator (typically a
            .await
            .segments
        _limit: Option<usize>,
            EmissionType::Incremental,
    pub global_base: u64,
use datafusion_common::DataFusionError;
        self: Arc<Self>,
    /// that crosses the FFM boundary to identify a segment on the Java side.
/// Nulls placement matches Lucene's convention: ASC → NULLS FIRST,
use datafusion::catalog::{Session, TableProvider};
                Arc::new(Schema::new(fields))
    /// `StatisticsConverter`. `None` means the segment cannot participate in
                None => EquivalenceProperties::new(self.projected_schema.clone()),
}
//!             │
    /// `ObjectMeta.location` DataFusion uses for the vanilla `ListingTable`).
            && lex_ordering.is_some()
    /// receives from DataFusion, because DataFusion's filters include
                statuses,
        // Row-group-aligned partition assignments
    /// (BoolNode tree, prebuilt PruningPredicates keyed by Arc ptr, schema)
        let descending = sort_orders
}
    pub sort_max: Option<datafusion::common::ScalarValue>,
                    if !cols.contains(&idx) {
/// - returns `None` when the prefix is empty (no useful claim to advertise).
/// many `IndexedExec`s from a single config.
    /// Writer generation for this segment — the stable per-segment identifier
    pub fn new(config: IndexedTableConfig) -> Self {
use super::partitioning::{
    pub predicate_columns: Vec<usize>,
        + Sync,
        let pred = scan_predicate(&provider, &[]).await;
            self.config.segments.len(),
            let stats_prune_tree =
        dynamic_filters: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
                emit_row_ids: self.config.emit_row_ids,
    pub evaluator_factory: EvaluatorFactory,
        // otherwise FilterExec would try to evaluate the
use std::fmt;
    /// Cumulative row count from all preceding segments. Used to compute
                &self.config.sort_fields,
        }
        self.predicate.as_ref()
    io_stats: Arc<ReadIoStats>,
 * compatible open source license.
        //     too low, lead column projected away, or QTF row-id-emit gate).
    /// pushdown rewrite happens before execution, so no metrics are lost) and
    /// page pruning, dynamic filter pruning, and column schema resolution
            projected_schema,
                let mut cols = proj.clone();
        Ok(stream)
        filters: &[Expr],
            inner_parquet_metrics: Arc::new(std::sync::Mutex::new(Vec::new())),
/*
        SchemaRef,
        //   - `unsorted`: no `index.sort.field`, OR sort field set but the
                cancellation_token: self.config.cancellation_token.clone(),
                cols.sort();
    pub sort_fields: Vec<String>,
            };
                row_id_output_index: self.row_id_output_index,
    /// Column index in the OUTPUT schema where computed `___row_id` should be
    /// True if `filter` can be used for per-RG statistics pruning: every column
            let base: SchemaRef = match projection {
                store: Arc::clone(&self.config.store),
    /// by `execute_indexed_query`:
            projected_schema: self.projected_schema.clone(),
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
            advertised_ordering: self.advertised_ordering.clone(),
    /// the `index_filter(...)` UDF marker whose body panics.
                            schema,
    async fn scan_predicate(
            &StreamMetrics,
    predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
use datafusion::physical_plan::{DisplayAs, DisplayFormatType, ExecutionPlan, PlanProperties};
    /// only in the `Post` phase and only when every column it references is a
            s
        use datafusion::physical_expr::expressions::Column;
                None => (0..full_schema.fields().len())
        } else {
impl ExecutionPlan for QueryShardExec {
                if i > 0 {
        } else {
        stream_metrics.io_stats = Some(Arc::clone(&self.io_stats));
                row_groups,
            && target_partitions >= self.config.segments.len();
            descending,
        let schema = Arc::new(Schema::new(vec![
 * SPDX-License-Identifier: Apache-2.0
        // Read projection = output columns (minus ___row_id) + predicate columns for evaluator.
    /// Arrow schema derived from this segment's parquet footer. Computed once
        // Require at least one resolved column — a column-free predicate (e.g.
                None => row_id_col_in_full_schema,
    ) -> Self {
/// Direction strings are `"asc"` / `"desc"` (lowercase, as plumbed from Java).
        // fully handles every WHERE filter (Collectors via FFM bitsets,
    }
pub struct IndexedTableProvider {
    dyn Fn(
 * this file be licensed under the Apache-2.0 license or a
        f.debug_struct("QueryShardExec")
#[cfg(test)]
                continue;
/// - on first column that doesn't resolve, **break** out of the loop and
/// Configuration used to build an `IndexedTableProvider`.
    /// `SortExec`-TopK `DynamicFilterPhysicalExpr`) via physical filter
}
    /// pushdown. Each is read per row-group at execution time to prune RGs
    projection: Option<Vec<usize>>,
                vec![lex.clone()],
                global_base: segment.global_base,
                crate::datafusion_query_config::DatafusionQueryConfig::test_default(),
    pub prune_tree_config: Option<(
        }
                accepted.push(Arc::clone(&f.filter));
        _config: &datafusion::config::ConfigOptions,
    /// When true, the `___row_id` column in the output projection is computed
    EquivalenceProperties, LexOrdering, Partitioning, PhysicalSortExpr,
            for (i, e) in lex.iter().enumerate() {
fn describe_ordering(ordering: &Option<LexOrdering>) -> String {
    fn fmt(&self, f: &mut fmt::Formatter<'_>) -> fmt::Result {
    fn metrics(&self) -> Option<MetricsSet> {
            let row_groups: Vec<RowGroupInfo> = segment
///   keep whatever prefix we built (the rest is "violated"),
        filter: &Arc<dyn datafusion::physical_expr::PhysicalExpr>,
};
//! ```
impl TableProvider for IndexedTableProvider {
            .config
            let output_cols: Vec<usize> = match projection {
    }
//!             ├── IndexedExec(chunk_1) ── IndexedStream ── RowGroupBitsetSource
            Field::new("b", DataType::Utf8, false),
            (assignments, eq, Some(lex))
            Field::new("a", DataType::Int32, false),
            // chain-aware partitioning guarantees this chunk is one whole
            schema,
#[cfg(test)]
                    s.push_str(", ");
        // and that we're not on the QTF row-id-emit path (gated for v1).
        };
    /// in this segment, read from parquet footer column statistics.
        use datafusion::physical_plan::filter_pushdown::{
    )>,
                let empty =
    /// `sort_fields` (validated at index creation).
//! This is the ONE provider. Paths B and C differ only in the evaluator
        }
                    continue;
