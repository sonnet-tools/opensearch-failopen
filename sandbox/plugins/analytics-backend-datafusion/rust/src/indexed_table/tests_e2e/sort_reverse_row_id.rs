            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
/// changes is the order in which segments are scanned (which the test ignores by
            rows: 8,
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
//! resolve to the right rows, the IDs query phase emits must agree with the
            ));
            }
        let parquet_meta = meta.metadata().clone();
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
        Field::new("v", DataType::Int32, false),
        for &doc in &self.matching {
            rows: 5,
                num_rows: n,
            Arc::new(Int32Array::from(vs)),
struct SegSpec {
            schema_opt = Some(meta.schema().clone());
        .target_partitions(1)
        pushdown_predicate: None,
    for (i, tmp) in tmps.iter().enumerate() {
    specs: &[SegSpec],
    // Natural order.
 */
        vec![
        sort_fields: vec![],
//! catalog-order `global_base` mapping fetch will compute. That holds only if
                Arc::new(LocalOffsetCollector { matching });
}
    reverse_segment_iteration_order(&mut segs_reversed);
                leaves: Arc::new(
    matching: Vec<i32>,
                index: j,
    }
            Ok(eval)
                page_pruner: pruner,
/// 4 segments. Confirms the property holds at the larger end of the test contract
            match_local_offsets: vec![0, 4],
/// 3 segments × varying match offsets. Run with natural iteration order, then reversed.
            max_doc,
    ) -> Result<CollectDocsResult, String> {
        }, // 7
    // monotonically per segment. The indexed path doesn't read them; it
    let store: Arc<dyn object_store::ObjectStore> =
    while let Some(batch) = stream.next().await {
//! `reverse_segment_iteration_order` preserves each segment's original
                .unwrap();
/// data layer; `match_local_offsets` are segment-local doc IDs that the mock
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema, Some(props)).unwrap();
            tag: "B",
            ids.push(col.value(i));
            let pruner = Arc::new(PagePruner::new(
//! Row-id stability under sort-aware segment reversal.
/// Mock collector that returns the configured local doc offsets that fall in `[min_doc, max_doc)`.
            tag: "A",
            parquet_size: size,
                let rel = (doc - min_doc) as usize;
        &self,
        }, // global ids 9, 12
fn write_segment(spec: &SegSpec) -> NamedTempFile {
        predicate_columns: vec![],
            rows: 5,
/// Build a `Vec<SegmentFileInfo>` for the given specs, including catalog-order
    match_local_offsets: Vec<i32>,
/// production fixture: the column exists and the indexed path replaces it.
    let tags: Vec<&str> = (0..spec.rows).map(|_| spec.tag).collect();
            arrow_schema: meta.schema().clone(),
    w.close().unwrap();
        })
    .unwrap();
            match_local_offsets: vec![0, 3, 7],
    fn collect_packed_u64_bitset(
    let schema = segment_schema();
    let mut segs_reversed = segs_natural;
    assert_eq!(ids_reversed, expected);
            });
}
            rows: 10,
            match_local_offsets: vec![0, 2, 4],
        if schema_opt.is_none() {
//! Why this matters: `api::fetch_by_row_ids` rebuilds segments via
    ];
        .map(|s| s.match_local_offsets.clone())
use crate::indexed_table::eval::{RowGroupBitsetSource, TreeBitsetSource};
) -> Vec<i64> {
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            let n = parquet_meta.row_group(j).num_rows();
    let vs: Vec<i32> = (0..spec.rows as i32).collect();
    let mut ids_reversed = collect_row_ids(segs_reversed, schema, &specs).await;
    let mut stream = datafusion::physical_plan::execute_stream(plan, ctx.task_ctx()).unwrap();
use futures::StreamExt;
    // this works whether segments are in natural order or reversed (it identifies the
    let tmp = NamedTempFile::new().unwrap();
    // segment by its writer_generation, which moves with the segment).
    let batch = RecordBatch::try_new(
    let mut ids_reversed = collect_row_ids(segs_reversed, schema, &specs).await;
                .cloned()
    let expected = vec![0i64, 3, 7, 9, 12, 14, 19, 23];
    ]))
    assert_eq!(ids_natural, expected, "natural-order ids");
                .get(segment.writer_generation as usize)
            global_base: cumulative,
async fn collect_row_ids(
    let mut ids_natural = collect_row_ids(segs_natural.clone(), schema.clone(), &specs).await;
            rgs.push(RowGroupInfo {
    // Segment-local IDs (0..rows) — production writer also stamps these
    };
use datafusion::execution::context::SessionContext;
        cancellation_token: None,
                        _stream_metrics.ffm_collector_calls.clone(),
    reverse_segment_iteration_order(&mut segs_reversed);
    segments: Vec<SegmentFileInfo>,
            rows: 6,
    }
}
use datafusion::arrow::array::{Int32Array, Int64Array, StringArray};
    let (segs_natural, schema) = build_segments(&tmps, &specs);
            let matching = per_gen
    Arc::new(Schema::new(vec![
 * The OpenSearch Contributors require contributions made to
        let mut rgs = Vec::new();
    ];
    // EvaluatorFactory selects the matching set for the segment it's asked about — so
use std::collections::HashMap;
        for j in 0..parquet_meta.num_row_groups() {
async fn three_segments_row_ids_invariant_under_reversal() {
use crate::indexed_table::table_provider::{
//!
    let row_ids: Vec<i64> = (0..spec.rows as i64).collect();
    let tmps: Vec<NamedTempFile> = specs.iter().map(write_segment).collect();
        let per_gen = Arc::clone(&per_gen);
    tag: &'static str,
        "reversed-order ids — same shard-global IDs as natural"
    let mut ids_natural = collect_row_ids(segs_natural.clone(), schema.clone(), &specs).await;
fn segment_schema() -> SchemaRef {
        Field::new("tag", DataType::Utf8, false),
    let mut segs_reversed = segs_natural;
        schema.clone(),
async fn four_segments_row_ids_invariant_under_reversal() {
    let mut schema_opt: Option<SchemaRef> = None;
        SegSpec {
        }, // global ids 0, 3, 7
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
            object_path,
            tag: "C",
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        let col = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
                ),
/// shard-global value per matching row.
        ids_reversed, expected,
use crate::indexed_table::bool_tree::BoolNode;
    }));
}
            match_local_offsets: vec![2],
    let per_gen: Vec<Vec<i32>> = specs
    let specs = vec![
                Arc::clone(&segment.metadata),
            let tree = BoolNode::Collector { annotation_id: 0 };
    let per_gen = Arc::new(per_gen);
        query_config: Arc::new(qc),
        .indexed_pushdown_filters(false)
        }, // 11, 13
                cost_collector: 10,
        .force_strategy(Some(FilterStrategy::BooleanMask))
            let tree = tree.push_not_down();
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
            sort_min: None,
    w.write(&batch).unwrap();
    // is preserved by `reverse_segment_iteration_order` — the central invariant.
use datafusion::parquet::arrow::ArrowWriter;
/// (`global_base + rg.first_row + position_in_rg`). This test mirrors the
}
            row_groups: rgs,
        let schema = schema.clone();
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
/*
    // Reversed iteration order (the optimization's effect). Per-segment global_base
struct LocalOffsetCollector {
        segments,
        }
    ids_natural.sort();
        ],
use tempfile::NamedTempFile;
                tree: Arc::new(resolved),
                stats_prune_tree: None,
        });
    rows: usize,
    schema: SchemaRef,
    // recomputes IDs from position. They're written so the column is valid.
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
        prune_tree_config: None,
    assert_eq!(
                    ),
use datafusion::arrow::record_batch::RecordBatch;
}
            rows: 5,
            // Single-collector tree.
impl RowGroupDocsCollector for LocalOffsetCollector {
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
/// One segment's worth of synthetic rows. `tag` distinguishes segments at the
    (segs, schema_opt.unwrap())
        let meta =
//! reversing the iteration order of `Vec<SegmentFileInfo>` must NOT change which
/// `emit_row_ids: true` and recomputes shard-global IDs from per-segment position
            Arc::new(StringArray::from(tags)),
                collector_strategy:
        store,
        segs.push(SegmentFileInfo {
    // One collector per segment, keyed by writer_generation == segment ord at build time.
use crate::indexed_table::index::CollectDocsResult;
        let path = tmp.path().to_path_buf();
        let mut offset = 0i64;
            });
    let expected = vec![0i64, 4, 7, 11, 13, 15, 17, 19];
//! Pins the contract that lets QTF compose with the reversal optimization:
}
        let span = (max_doc - min_doc) as usize;
                rg_index_to_pos: HashMap::new(),
//! `build_segments(ShardView.object_metas, ShardView.writer_generations)` —
        }, // global ids 14, 19, 23
                .unwrap_or_default();
            tag: "C",
    let plan = df.create_physical_plan().await.unwrap();
    IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
        }
use std::sync::Arc;
    let mut cumulative: u64 = 0;
        }, // 15, 17, 19
                first_row: offset,
        SegSpec {
    )
            rows: 5,
            offset += n;
    let mut segs = Vec::new();
    let mut ids: Vec<i64> = Vec::new();
/// `global_base` so `__row_id__ = global_base + local_pos` resolves to a unique
use crate::indexed_executor::reverse_segment_iteration_order;
        let max_doc = offset;
};
 * compatible open source license.
    );
/// The set of emitted `__row_id__` values must be identical — the only thing reversal
#[derive(Debug)]
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
                schema.clone(),
        store_url,
//! above us re-sorts anyway).
    ctx.register_table("t", provider).unwrap();
}
//!
//! always in catalog order, never reversed. For QTF query→fetch round-trip to
        Arc::new(object_store::local::LocalFileSystem::new());
            let resolved = tree.resolve(&[(0, collector)])?;
            tag: "A",
        emit_row_ids: true,
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
/// column. The indexed scan path strips it from the read projection when
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
        .build();
        schema: schema.clone(),
        }
    ids_reversed.sort();
use crate::indexed_table::index::RowGroupDocsCollector;
/// `global_base` cumulation matches catalog order on every segment.
        }, // 0, 4
                &schema,
                out[rel / 64] |= 1u64 << (rel % 64);
}
            metadata: Arc::clone(&parquet_meta),
            match_local_offsets: vec![0, 5, 9],
        Field::new(crate::ROW_ID_COLUMN_NAME, DataType::Int64, false),
        .iter()
                page_prune_metrics: Some(
/// (the IT runs with 2-4 segments per shard depending on doc routing) and that
                ),
    ids_natural.sort();
            match_local_offsets: vec![1, 3],
        }
        sort_orders: vec![],
/// collector will return as matches.
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        .build();
fn build_segments(tmps: &[NamedTempFile], specs: &[SegSpec]) -> (Vec<SegmentFileInfo>, SchemaRef) {
 *
//! that changes is the order in which segments are processed (which the TopK
    let (segs_natural, schema) = build_segments(&tmps, &specs);
/// Collect emitted `__row_id__` values for the given segment vec.
        cumulative += specs[i].rows as u64;
use crate::indexed_table::page_pruner::PagePruner;
    let specs = vec![
                        _stream_metrics,
        .set_max_row_group_size(4)
/// Per the writer-side invariant, every parquet segment carries the `__row_id__`
        SegSpec {
/// comparing sorted sets).
        let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
use crate::indexed_table::stream::{FilterStrategy, RowGroupInfo};
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    let factory: super::super::table_provider::EvaluatorFactory = {
    ids
//! `global_base`, which is exactly what these tests verify end-to-end.
    let ctx = SessionContext::new();
            ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true))
            match_local_offsets: vec![1, 4],
                    ),
        let mut out = vec![0u64; span.div_ceil(64)];
        let size = std::fs::metadata(&path).unwrap().len();
        min_doc: i32,
            tag: "D",
        Ok(out.into())
    }
 * this file be licensed under the Apache-2.0 license or a
                max_collector_parallelism: 1,
        let b = batch.unwrap();
            let collector: Arc<dyn RowGroupDocsCollector> =
            tag: "B",
//! `__row_id__` values get emitted for the same matching rows. The only thing
        SegSpec {
        SegSpec {
                cost_predicate: 1,
        SegSpec {
                evaluator: Arc::new(BitmapTreeEvaluator),
 * SPDX-License-Identifier: Apache-2.0
        .collect();
    ids_reversed.sort();
use crate::indexed_table::eval::bitmap_tree::BitmapTreeEvaluator;
        max_doc: i32,
    let tmps: Vec<NamedTempFile> = specs.iter().map(write_segment).collect();
            sort_max: None,
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
            writer_generation: i as i64,
        let file = std::fs::File::open(&path).unwrap();
        for i in 0..b.num_rows() {
        evaluator_factory: factory,
    tmp
    assert_eq!(ids_natural, expected);
            Arc::new(Int64Array::from(row_ids)),
            if doc >= min_doc && doc < max_doc {
        SegSpec {
