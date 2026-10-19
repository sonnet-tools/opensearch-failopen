            global_base: cumulative,
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
    let vs: Vec<i32> = (0..spec.rows as i32).collect();
    match_local_offsets: Vec<i32>,
//! above us re-sorts anyway).
        max_doc: i32,
        let schema = schema.clone();
use datafusion::arrow::array::{Int32Array, Int64Array, StringArray};
    w.close().unwrap();
    ]))
use tempfile::NamedTempFile;
                collector_strategy:
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    ) -> Result<CollectDocsResult, String> {
    ids_reversed.sort();
    // Natural order.
                let rel = (doc - min_doc) as usize;
    let tmps: Vec<NamedTempFile> = specs.iter().map(write_segment).collect();
        cancellation_token: None,
            tag: "A",
        let mut offset = 0i64;
        }, // 0, 4
                    crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::new(
        SegSpec {
                rg_index_to_pos: HashMap::new(),
}
            ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true))
            rows: 6,
    let per_gen: Vec<Vec<i32>> = specs
//! resolve to the right rows, the IDs query phase emits must agree with the
        });
    )
                schema.clone(),
        let file = std::fs::File::open(&path).unwrap();
    let mut ids: Vec<i64> = Vec::new();
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema, Some(props)).unwrap();
    w.write(&batch).unwrap();
    }
fn build_segments(tmps: &[NamedTempFile], specs: &[SegSpec]) -> (Vec<SegmentFileInfo>, SchemaRef) {
                ),
    rows: usize,
    let per_gen = Arc::new(per_gen);
                    ),
        }, // 11, 13
                index: j,
        ],
struct LocalOffsetCollector {
    assert_eq!(ids_natural, expected);
        &self,
                page_pruner: pruner,
                        _stream_metrics,
                evaluator: Arc::new(BitmapTreeEvaluator),
                cost_predicate: 1,
            ids.push(col.value(i));
    reverse_segment_iteration_order(&mut segs_reversed);
            rows: 5,
                .unwrap_or_default();
    let specs = vec![
            max_doc,
                        _stream_metrics.ffm_collector_calls.clone(),
/// production fixture: the column exists and the indexed path replaces it.
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderMetadata, ArrowReaderOptions};
        SegSpec {
        schema: schema.clone(),
        .force_strategy(Some(FilterStrategy::BooleanMask))
            match_local_offsets: vec![1, 3],
    ];
        SegSpec {
    // Reversed iteration order (the optimization's effect). Per-segment global_base
use std::sync::Arc;
use crate::indexed_table::stream::{FilterStrategy, RowGroupInfo};
    // recomputes IDs from position. They're written so the column is valid.
        segments,
    let row_ids: Vec<i64> = (0..spec.rows as i64).collect();
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            metadata: Arc::clone(&parquet_meta),
/*
                page_prune_metrics: Some(
            let pruner = Arc::new(PagePruner::new(
    assert_eq!(ids_reversed, expected);
            writer_generation: i as i64,
        SegSpec {
use std::collections::HashMap;
        SegSpec {
        prune_tree_config: None,
        "reversed-order ids — same shard-global IDs as natural"
        let max_doc = offset;
 * SPDX-License-Identifier: Apache-2.0
    let mut segs = Vec::new();
//! that changes is the order in which segments are processed (which the TopK
            Arc::new(Int64Array::from(row_ids)),
    // EvaluatorFactory selects the matching set for the segment it's asked about — so
//!
/// (`global_base + rg.first_row + position_in_rg`). This test mirrors the
/// `global_base` cumulation matches catalog order on every segment.
/// The set of emitted `__row_id__` values must be identical — the only thing reversal
            object_path,
        query_config: Arc::new(qc),
    let tmp = NamedTempFile::new().unwrap();
fn segment_schema() -> SchemaRef {
            tag: "B",
            match_local_offsets: vec![0, 4],
                out[rel / 64] |= 1u64 << (rel % 64);
        let span = (max_doc - min_doc) as usize;
}
        if schema_opt.is_none() {
            tag: "C",
            rgs.push(RowGroupInfo {
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
use crate::indexed_table::bool_tree::BoolNode;
        let meta =
        })
        sort_fields: vec![],
use crate::indexed_executor::reverse_segment_iteration_order;
    ids_natural.sort();
            let tree = tree.push_not_down();
use crate::indexed_table::table_provider::{
        .set_max_row_group_size(4)
    let batch = RecordBatch::try_new(
        }, // global ids 9, 12
use datafusion::parquet::arrow::ArrowWriter;
            rows: 5,
            let tree = BoolNode::Collector { annotation_id: 0 };
                .get(segment.writer_generation as usize)
        Field::new(crate::ROW_ID_COLUMN_NAME, DataType::Int64, false),
//! Why this matters: `api::fetch_by_row_ids` rebuilds segments via
    // is preserved by `reverse_segment_iteration_order` — the central invariant.
    // Segment-local IDs (0..rows) — production writer also stamps these
//! `reverse_segment_iteration_order` preserves each segment's original
        .collect();
//! `build_segments(ShardView.object_metas, ShardView.writer_generations)` —
    fn collect_packed_u64_bitset(
            match_local_offsets: vec![1, 4],
            let n = parquet_meta.row_group(j).num_rows();
    let mut ids_reversed = collect_row_ids(segs_reversed, schema, &specs).await;
async fn three_segments_row_ids_invariant_under_reversal() {
        Arc::new(object_store::local::LocalFileSystem::new());
    let schema = segment_schema();
}
 * compatible open source license.
                    ),
        vec![
    // this works whether segments are in natural order or reversed (it identifies the
        SegSpec {
        }, // 7
 */
fn write_segment(spec: &SegSpec) -> NamedTempFile {
/// shard-global value per matching row.
            arrow_schema: meta.schema().clone(),
            match_local_offsets: vec![2],
    matching: Vec<i32>,
/// `emit_row_ids: true` and recomputes shard-global IDs from per-segment position
        }, // global ids 0, 3, 7
    );
    assert_eq!(ids_natural, expected, "natural-order ids");
                cost_collector: 10,
    Arc::new(Schema::new(vec![
    let ctx = SessionContext::new();
        evaluator_factory: factory,
                max_collector_parallelism: 1,
            ));
struct SegSpec {
            tag: "B",
        .target_partitions(1)
        let path = tmp.path().to_path_buf();
/// One segment's worth of synthetic rows. `tag` distinguishes segments at the
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        }
#[derive(Debug)]
            rows: 10,
/// Collect emitted `__row_id__` values for the given segment vec.
async fn four_segments_row_ids_invariant_under_reversal() {
        let col = b.column(0).as_any().downcast_ref::<Int64Array>().unwrap();
    let (segs_natural, schema) = build_segments(&tmps, &specs);
    // segment by its writer_generation, which moves with the segment).
    assert_eq!(
        for j in 0..parquet_meta.num_row_groups() {
}
                    crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
 * The OpenSearch Contributors require contributions made to
            match_local_offsets: vec![0, 5, 9],
            Arc::new(Int32Array::from(vs)),
        let mut rgs = Vec::new();
            row_groups: rgs,
                    crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(
        }, // 15, 17, 19
/// `global_base` so `__row_id__ = global_base + local_pos` resolves to a unique
            sort_max: None,
        emit_row_ids: true,
    let specs = vec![
 * this file be licensed under the Apache-2.0 license or a
        schema.clone(),
    let mut segs_reversed = segs_natural;
    let mut schema_opt: Option<SchemaRef> = None;
            Arc::new(StringArray::from(tags)),
            offset += n;
/// Mock collector that returns the configured local doc offsets that fall in `[min_doc, max_doc)`.
    for (i, tmp) in tmps.iter().enumerate() {
/// Per the writer-side invariant, every parquet segment carries the `__row_id__`
        }, // global ids 14, 19, 23
    let mut ids_natural = collect_row_ids(segs_natural.clone(), schema.clone(), &specs).await;
    // One collector per segment, keyed by writer_generation == segment ord at build time.
                Arc::clone(&segment.metadata),
        .iter()
        .map(|s| s.match_local_offsets.clone())
        for &doc in &self.matching {
/// Build a `Vec<SegmentFileInfo>` for the given specs, including catalog-order
                num_rows: n,
};
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
    let store: Arc<dyn object_store::ObjectStore> =
//! Row-id stability under sort-aware segment reversal.
        }
use futures::StreamExt;
    let mut ids_natural = collect_row_ids(segs_natural.clone(), schema.clone(), &specs).await;
use crate::indexed_table::eval::bitmap_tree::BitmapTreeEvaluator;
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        sort_orders: vec![],
    segments: Vec<SegmentFileInfo>,
    }
            match_local_offsets: vec![0, 3, 7],
    IndexedTableConfig, IndexedTableProvider, SegmentFileInfo,
                ),
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
            if doc >= min_doc && doc < max_doc {
/// data layer; `match_local_offsets` are segment-local doc IDs that the mock
async fn collect_row_ids(
            tag: "A",
        ids_reversed, expected,
        Ok(out.into())
    let mut segs_reversed = segs_natural;
            let matching = per_gen
            }
    .unwrap();
) -> Vec<i64> {
    let plan = df.create_physical_plan().await.unwrap();
        }
                .cloned()
    }));
/// comparing sorted sets).
//! catalog-order `global_base` mapping fetch will compute. That holds only if
            tag: "C",
//! Pins the contract that lets QTF compose with the reversal optimization:
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(TreeBitsetSource {
/// 4 segments. Confirms the property holds at the larger end of the test contract
use crate::indexed_table::index::CollectDocsResult;
use crate::indexed_table::page_pruner::PagePruner;
    reverse_segment_iteration_order(&mut segs_reversed);
/// 3 segments × varying match offsets. Run with natural iteration order, then reversed.
            let collector: Arc<dyn RowGroupDocsCollector> =
        Field::new("tag", DataType::Utf8, false),
        store_url,
    let mut cumulative: u64 = 0;
    let tmps: Vec<NamedTempFile> = specs.iter().map(write_segment).collect();
    let tags: Vec<&str> = (0..spec.rows).map(|_| spec.tag).collect();
        store,
            // Single-collector tree.
                leaves: Arc::new(
use crate::indexed_table::index::RowGroupDocsCollector;
    let df = ctx.sql("SELECT \"__row_id__\" FROM t").await.unwrap();
            schema_opt = Some(meta.schema().clone());
                &schema,
/// collector will return as matches.
        min_doc: i32,
                pruning_predicates: Arc::new(std::collections::HashMap::new()),
//!
            Ok(eval)
            rows: 5,
use datafusion::arrow::record_batch::RecordBatch;
//! `__row_id__` values get emitted for the same matching rows. The only thing
    ids_reversed.sort();
    let (segs_natural, schema) = build_segments(&tmps, &specs);
//! reversing the iteration order of `Vec<SegmentFileInfo>` must NOT change which
        .build();
        let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
}
}
//! `global_base`, which is exactly what these tests verify end-to-end.
    let expected = vec![0i64, 3, 7, 9, 12, 14, 19, 23];
            let resolved = tree.resolve(&[(0, collector)])?;
            rows: 5,
    let factory: super::super::table_provider::EvaluatorFactory = {
        Field::new("v", DataType::Int32, false),
            sort_min: None,
        cumulative += specs[i].rows as u64;
        pushdown_predicate: None,
            rows: 8,
    ids
    ];
                Arc::new(LocalOffsetCollector { matching });
    (segs, schema_opt.unwrap())
        let mut out = vec![0u64; span.div_ceil(64)];
    tmp
/// column. The indexed scan path strips it from the read projection when
            });
    specs: &[SegSpec],
 *
                first_row: offset,
    let expected = vec![0i64, 4, 7, 11, 13, 15, 17, 19];
    let mut ids_reversed = collect_row_ids(segs_reversed, schema, &specs).await;
        SegSpec {
        let b = batch.unwrap();
/// changes is the order in which segments are scanned (which the test ignores by
        let size = std::fs::metadata(&path).unwrap().len();
        .build();
        }
        let per_gen = Arc::clone(&per_gen);
use crate::indexed_table::eval::{RowGroupBitsetSource, TreeBitsetSource};
/// (the IT runs with 2-4 segments per shard depending on doc routing) and that
    schema: SchemaRef,
            tag: "D",
impl RowGroupDocsCollector for LocalOffsetCollector {
        for i in 0..b.num_rows() {
    // monotonically per segment. The indexed path doesn't read them; it
        segs.push(SegmentFileInfo {
                .unwrap();
}
}
use datafusion::execution::context::SessionContext;
            });
    tag: &'static str,
    ctx.register_table("t", provider).unwrap();
    while let Some(batch) = stream.next().await {
    ids_natural.sort();
                tree: Arc::new(resolved),
        predicate_columns: vec![],
            match_local_offsets: vec![0, 2, 4],
//! always in catalog order, never reversed. For QTF query→fetch round-trip to
        .indexed_pushdown_filters(false)
        let parquet_meta = meta.metadata().clone();
                stats_prune_tree: None,
    let mut stream = datafusion::physical_plan::execute_stream(plan, ctx.task_ctx()).unwrap();
    }
}
    };
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
            parquet_size: size,
