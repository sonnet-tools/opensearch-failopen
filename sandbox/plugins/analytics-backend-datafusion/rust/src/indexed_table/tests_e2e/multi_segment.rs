            );
    let rows = run_wide_segments_with_stats_pruning(specs, tree, 4).await;
            let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = (0..leaf_count)
    assert!(
        let rows = run_segments(
            rows.push((
                num_rows: n,
        .iter()
        max_rg_rows: 4,
    tmp
/// `write_wide_segment` exactly.
            object_path,
    let mut stream = df.execute_stream().await.unwrap();
//! Multi-segment tests. A shard typically holds many index segments; each
    let brand_to_ord: std::collections::HashMap<&'static str, i32> = specs
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
}
                .unwrap();
        for i in 0..parquet_meta.num_row_groups() {
// Tree shape: AND(Predicate(price > X), OR(Collector, Predicate(qty/active)))
    expected.sort();
    // Critical correctness invariant: each segment has doc IDs in [0, max_doc),
    assert_eq!(spt.rg_can_match.len(), 2, "subset-relative: 2 RGs in chunk");
async fn wide_multi_segment_collector_and_two_predicates() {
                    brand: s.brand,
        ]
        let region = match i % 3 {
                    max_collector_parallelism: 1,
    // Chunk with RG1 only (prices 40-70). Offset index = 1.
    let schema = wide_schema();
    rows.sort();
    let mut out = Vec::new();
        result_rg2.is_some(),
    let schema = wide_schema();
                Ok(_) => break,
        ]),
            brand: "oracle",
        .unwrap();
            0 => "us-east",
        cancellation_token: None,
            rows: 16,
        "RG3 (prices 120-150) should match price>60"
    let expected = wide_oracle(&specs, |i| !((i as i32) * 10 < 40));
            .unwrap();
    let df = ctx.sql("SELECT brand, price FROM t").await.unwrap();
        brand: "amazon",
            run_wide_segments_with_stats_pruning(clone_wide_specs(&specs), tree.clone(), np).await;
        evaluator: Arc::new(crate::indexed_table::eval::bitmap_tree::BitmapTreeEvaluator),
            parquet_size: size,
    for np in [1usize, 3, 5] {
            (0, "amazon".to_string(), 57),
    // the collector alone; multi-leaf trees refine via predicates).
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            match self.max_in_flight.compare_exchange_weak(
    let pruning_predicates: Arc<
    brand: &'static str,
            max_rg_rows: 4,
    let tree = BoolNode::And(vec![
    for np in [1usize, 3, 5] {
                first_row: offset,
        !prefetched.candidates.is_empty(),
            sort_min: None,
}
                .get(segment.writer_generation as usize)
            rows.push((
        "RG1 should NOT be pruned at root (OR has surviving child)"
            schema_opt = Some(meta.schema().clone());
    ]);
        .enumerate()
            BoolNode::And(vec![
        first_row: 8,
    ]);
}
/// predicate leaves on top to narrow.
        prune_tree_config: None,
        page_prune_metrics: None,
                out.push((ord as i32, s.brand.to_string(), s.base_price + m));
        segments.push(SegmentFileInfo {
            max_doc: offset,
        .await
async fn wide_multi_segment_not_and_three_column_predicates() {
    let matches = vec![vec![2, 6], vec![3, 7]];
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
    for np in [2usize, 4] {
        if schema_opt.is_none() {
        if schema_opt.is_none() {
        ) -> Result<CollectDocsResult, String> {
// Many-segment × many-RG × varied-partition tests
        let mut rgs = Vec::new();
    let mut stream = df.execute_stream().await.unwrap();
}
            ]),
                    cost_collector: 10,
        assert_eq!(rows, expected, "np={} failed", np);
    let qtys: Vec<i32> = (0..rows).map(|i| (i as i32) % 7).collect(); // 0..6 cycling
            Arc::clone(&parquet_meta),
/// Maximum fragmentation — chunks split across segments with offset RGs.
        assert_eq!(rows, expected, "partition count {} produced wrong rows", np);
                BoolNode::And(vec![
            base_price: 400,
        ]),
                region.value(i).to_string(),
    assert_eq!(rows.len(), 4, "result correctness sanity check");
fn pred_wide_int(col: &str, op: Operator, v: i32) -> BoolNode {
                    pruning_predicates: Arc::clone(&pruning_predicates),
    let mut segments: Vec<SegmentFileInfo> = Vec::new();
    // partition, triggering UnionExec + CoalescePartitionsExec in
        cost_predicate: 1,
    };
    let tmps: Vec<NamedTempFile> = specs
            max_rg_rows: 4,
    max_rg_rows: usize,
        // be observed as in_flight > 1.
        }
    // NOT is conservative in stats (always true), so actual predicate filters.
                    1 => "us-west",
    assert_eq!(
    // Tree: AND(all_brand_docs, price > 50, qty < 3)
                    brand: s.brand,
                .iter()
    );
        WideSegSpec {
        pred_wide_int("qty", Operator::Lt, 3),
            writer_generation: ord as i64,
// Collector semantics: `brand == <segment's brand>` for every doc in segment.
        }
        use std::sync::atomic::Ordering;
        "chunks within a single partition must run sequentially \
                ]),
    }
                stats_prune_tree: None, rg_index_to_pos: HashMap::new(),
    });
        evaluator_factory: factory,
async fn stats_prune_three_way_or_ordering_independence() {
        let rows = run_wide_segments(clone_wide_specs(&specs), tree.clone(), np).await;
        .iter()
            max_rg_rows: 4,
            max_rg_rows: 4,
    let rows = run_segments(five_segment_specs(), 1).await;
        store,
    // Assert: rg_can_match for position 1 (RG3, prices 120-150) should be true.
    let rows = run_segments(five_segment_specs(), 5).await;
            rows: 16,
                cur,
            ]),
        cancellation_token: None,
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
// routinely have 5-20 columns with filters spanning several of them; this
        vec![(1, "apple".to_string(), 100), (1, "apple".to_string(), 104),]
        }
// subtrees with native predicates get stats-pruned while OR subtrees
        BoolNode::Or(vec![
        let region = match i % 3 {
            min_doc: i32,
        let qty = b.column(2).as_any().downcast_ref::<Int32Array>().unwrap();
        let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
    let store: Arc<dyn object_store::ObjectStore> =
        Arc::new(move |segment, chunk, stream_metrics, stats_prune_tree| {
        .target_partitions(num_partitions)
        brand: "amazon",
        let rows =
    // Build a segment with 4 RGs of 4 rows each.
                .unwrap();
    // Assert: rg_can_match for position 0 (RG2, prices 80-110) should be true (price>60 matches).
        &rg_indices,
                    None,
impl RowGroupDocsCollector for PerSegmentCollector {
    let max_in_flight = Arc::new(std::sync::atomic::AtomicUsize::new(0));
            (1, "apple".to_string(), 101),
    };
/// Multi segment (4 segments × 4 RGs), single partition.
        ]),
}
    // stresses compute_assignments.
                pred_wide_bool("active", Operator::Eq, true),
        sort_fields: vec![],
                    collector_strategy: crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        })
    // the factory handles zero-match segments cleanly (prefetch_rg returns
        BoolNode::Or(vec![
//! - Partition assignment spanning multiple segments (`compute_assignments`
    per_segment_matches: Vec<Vec<i32>>,
    let tree = tree.push_not_down().flatten();
            arrow_schema: meta.schema().clone(),
                .map(|s| SegSpec {
    }
    let rg0 = RowGroupInfo {
    let df = ctx.sql("SELECT brand, price FROM t").await.unwrap();
    let expected = wide_oracle(&specs, |i| (i as i32) * 10 > 50 && (i as i32) % 7 < 3);
    max_rg_rows: usize,
        ),
        let qty = b.column(2).as_any().downcast_ref::<Int32Array>().unwrap();
        let parquet_meta = meta.metadata().clone();
            (0, "amazon".to_string(), 50),
    // With num_partitions=1 both segments land in one partition's
/// pick a few docs in each segment covering multiple RGs (not just RG 0),
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
    for np in [1usize, 3, 5] {
// enabled, causing `table_provider` to build `StatsPruneTree` per chunk.
        .iter()
    ));
        },
 * SPDX-License-Identifier: Apache-2.0
        let size = std::fs::metadata(&path).unwrap().len();
    };
    rows
            metadata: Arc::clone(&parquet_meta),
        Field::new("price", DataType::Int32, false),
/// set indexed by `writer_generation` (caller supplies one Vec<i32> per segment).
}
        BoolNode::Or(vec![
    assert_eq!(rows, expected);
                    page_pruner: pruner,
    // 5-chunk UnionExec+CoalescePartitionsExec. Every segment boundary
                ),
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
                .collect(),
                in_flight: Arc::clone(&in_flight),
    };
    let tree = BoolNode::And(vec![
        .target_partitions(num_partitions)
                    pruning_predicates: std::sync::Arc::new(std::collections::HashMap::new()),
        min_doc: i32,
    let specs = five_segment_specs();
        }
            _ => "eu-west",
            let matching = per_segment_matches
        let qty = (i as i32) % 7;
            ) {
    }
    let tree = BoolNode::And(vec![
    // With num_partitions=1, both segments' chunks land in the same
// ══════════════════════════════════════════════════════════════════════
    let (rows, max_in_flight) = run_two_segment_query_witness(matches, /*num_partitions*/ 2).await;
    let result_rg0 = source.prefetch_rg(&rg0, 0, 4).unwrap();
                let region = match i % 3 {
/// 2. RGs at offset indices (index > 0) are correctly handled
        },
            BoolNode::Collector { annotation_id: 0 },
//
        BoolNode::Or(vec![
    // (stats: min=40, max=70, so max > 60 → can_match=true at RG stats level)
    let per_segment_matches = Arc::new(per_segment_matches);
        collector_strategy: crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
        let rows = run_wide_segments_with_stats_pruning(
        max_in_flight, 2,
    let ctx = SessionContext::new();
                .map(|i| {
        .force_strategy(Some(FilterStrategy::BooleanMask))
    let tree = BoolNode::And(vec![
                ]),
    let has_empty = tree_prefetch.per_leaf.iter().any(|(_, bm)| bm.is_empty());
        Field::new("brand", DataType::Utf8, false),
                schema.clone(),
}
        let file = std::fs::File::open(&path).unwrap();
        .map(|s| write_wide_segment(s.brand, s.rows, s.max_rg_rows))
        Arc::new(object_store::local::LocalFileSystem::new());
                    cost_collector: 10,
                price.value(i),
            .iter()
        usize,
            rows: 16,
    let df = ctx.sql("SELECT brand, price FROM t").await.unwrap();
            row_groups: rgs,
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        for &doc in &self.matching {
    // Tree: OR(AND(price > 100, Collector0), Collector1)
    let tree = BoolNode::And(vec![
            crate::indexed_table::page_pruner::build_pruning_predicate(expr, schema.clone())
    );
            if doc >= min_doc && doc < max_doc {
            object_path,
    let expected = wide_oracle(&specs, |i| (i as i32) * 10 > 80);
        let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
    }
        .collect()
            schema_opt = Some(meta.schema().clone());
        BoolNode::Collector { annotation_id: 0 },
                Arc::new(PerSegmentCollector { matching });
    }
            pred_wide_bool("active", Operator::Eq, true),
        pred_wide_int("price", Operator::Gt, 50),
    ctx.register_table("t", provider).unwrap();
/// Single segment (4 RGs), multi partition (4 partitions → 1 RG per chunk).
        "both collectors must have per_leaf entries; got {}",
                .collect();
    let rg_indices: Vec<usize> = vec![2, 3];
            matches: vec![1, 6, 11],
        rows: 16,
    /// Matching doc IDs in segment-local space [0, rows).
    let mut stream = df.execute_stream().await.unwrap();
                })
            rgs.push(RowGroupInfo {
            row_groups: rgs,
        BoolNode::Not(inner) => collect_pred_exprs(inner, out),
        .expect("context should be TreePrefetch");
        .indexed_pushdown_filters(false)
            writer_generation: ord as i64,
    let mut rows: Vec<(i32, String, i32)> = Vec::new();
            .as_any()
    let spec = WideSegSpec {
        num_rows: 4,
    let mut segments: Vec<SegmentFileInfo> = Vec::new();
        cost_collector: 10,
        has_nonempty,
        "RG0 (prices 0-30) should be pruned by price>60"
            base_price: 200,
            Ok(eval)
                .unwrap_or_default();
    let tree = BoolNode::And(vec![
        .indexed_pushdown_filters(false)
                out[i / 64] |= 1u64 << (i % 64);
            sort_max: None,
                qty.value(i),
            offset += n;
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        "RG2 (prices 80-110) should match price>60"
            BoolNode::Or(vec![
                })
        let rows =
}
fn clone_wide_specs(specs: &[WideSegSpec]) -> Vec<WideSegSpec> {
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            arrow_schema: meta.schema().clone(),
        sort_orders: vec![],
        brand: "amazon",
    assert!(
    /// Caps row group size; smaller → more RGs per segment.
        }, // 4 RGs
        let parquet_meta = meta.metadata().clone();
            );
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        });
/// invocations of `collect_packed_u64_bitset` across *all* chunks in a
async fn five_segments_each_with_four_rgs_single_partition() {
/// wrong branch's rg_can_match to be applied — pruning rows that match via
        BoolNode::Or(vec![
            Arc::new(StringArray::from(regions)),
    );
        let meta =
        &pruning_predicates,
            .column(4)
    for np in [1usize, 2, 5] {
            metadata: Arc::clone(&parquet_meta),
            });
    }
    let result_rg3 = source2.prefetch_rg(&rg3, 12, 16).unwrap();
async fn wide_multi_segment_deep_tree_four_predicate_columns() {
            }
                .cloned()
 * compatible open source license.
        let path = tmp.path().to_path_buf();
    > = Arc::new(
    assert_eq!(with_one, with_two);
    ))
            brand: "google",
        SegSpec {
            BoolNode::And(vec![
// ── StatsPruneTree integration with offset RG indices ───────────────
                BoolNode::And(vec![
                Ordering::SeqCst,
    let tmp1 = write_segment("apple", 100, SEG1_ROWS);
    rows
            rows: 16,
/// Each chunk has rg_indices=[N] where N>0 for non-first chunks.
            Ok(out.into())
        &tree,
    // all-docs collector for this segment.
                pred_wide_int("price", Operator::Gt, 100),
                num_rows: n,
            });
    let expected = wide_oracle(&specs, |i| {
        cancellation_token: None,
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
        &schema,
        result.is_some(),
fn write_wide_segment(brand: &'static str, rows: usize, max_rg_rows: usize) -> NamedTempFile {
        BoolNode::Not(Box::new(pred_wide_int("price", Operator::Lt, 40))),
/// order-dependent pruning bugs.
// Verifies correctness when chunks have offset RG indices and when AND
            Ok(out.into())
        schema: schema.clone(),
    let pruning_predicates: HashMap<
        if schema_opt.is_none() {
                crate::indexed_table::eval::TreeBitsetSource {
        rows: 16,
        emit_row_ids: false,
        Ok(out.into())
                .map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
                index: i,
        let per_segment_matches = Arc::clone(&per_segment_matches);
    let mut leaf_exprs: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = Vec::new();
    );
        pushdown_predicate: None,
            matches: vec![3, 8, 13],
        .build();
        }
    // RG1 (prices 40-70): max=70 > 60, so stats say can-match. Not pruned.
    assert_eq!(rows, expected_for_five_segments());
    rows.sort();
        evaluator_factory: factory,
        tree_prefetch.per_leaf.len(),
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
        .build();
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = vec![
            ));
// Totally disjoint content so per-segment correctness is easy to check.
            let mut out = vec![0u64; span.div_ceil(64)];
            let ord = specs
            arrow_schema: meta.schema().clone(),
            matches: vec![1, 9, 15],
                    BoolNode::Collector { annotation_id: 2 },
struct PerSegmentCollector {
            max_doc: i32,
    let mut rows: Vec<(i32, i32, i32, String, bool)> = Vec::new();
            .collect(),
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
    let tmps: Vec<NamedTempFile> = specs
    };
    let tree = tree.push_not_down().flatten();
}
            rows: 16,
        BoolNode::Collector { annotation_id: 0 },
    assert_eq!(rows, expected);
            rows: 8,
/// RGs with prices [0..30] are stats-pruned by `price > 50`.
            rows: 16,
        page_pruner: pruner,
                        crate::indexed_table::page_pruner::PagePruneMetrics::from_stream_metrics(stream_metrics),
        "AND(price>100, Coll0) should be false for RG1"
    let tmp0 = write_segment("amazon", 50, SEG0_ROWS);
/// OR(A, B, C). Each AND branch pairs a Collector with a Predicate. One
            brand: "google",
        &schema,
async fn stats_prune_three_way_or_flatten_misalignment_regression() {
            let ord = if brand.value(i) == "amazon" { 0 } else { 1 };
        "RG3 at offset index should not be pruned"
            let span = (max_doc - min_doc) as usize;
        schema.clone(),
                Arc::clone(&segment.metadata),
    assert_eq!(
        });
            0 => "us-east",
    use crate::indexed_table::eval::RowGroupBitsetSource;
    // collector would observe `max_in_flight >= 2`. Post-fix: chunks are
/// indices in spt.children don't match ResolvedNode children, causing the
        let size = std::fs::metadata(&path).unwrap().len();
                        crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::without_metrics(),
            );
            base_price: 200,
    let max_observed = max_in_flight.load(std::sync::atomic::Ordering::SeqCst);
    while let Some(batch) = stream.next().await {
        (2, "google".to_string(), 200),
                ]),
        (0, Arc::new(AllDocs) as Arc<dyn RowGroupDocsCollector>),
 * The OpenSearch Contributors require contributions made to
    let rg1 = RowGroupInfo {
            parquet_size: size,
fn pred_wide_bool(col: &str, op: Operator, v: bool) -> BoolNode {
            rows: 16,
                    _ => "eu-west",
        let schema = schema.clone();
//
async fn run_segments(specs: Vec<SegSpec>, num_partitions: usize) -> Vec<(i32, String, i32)> {
        .collect();
    });
    // chained sequentially via `futures::stream::iter(streams).flatten()`,
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
                pred_wide_str("region", Operator::Eq, "us-east"),
        brand: "amazon",
    // depending on stats (max price in RG1 is 70 which > 60, so can_match=true).
    );
    let rg_indices_low: Vec<usize> = vec![0, 1];
        let region = b.column(3).as_any().downcast_ref::<StringArray>().unwrap();
            (0, "amazon".to_string(), 54),
                    crate::indexed_table::eval::single_collector::CollectorCallStrategy::FullRange,
//
    assert!(
                .iter()
        SegSpec {
    let ctx = SessionContext::new();
                let price = (i as i32) * 10;
            base_price: 500,
        .await;
        query_config: std::sync::Arc::new(qc),
fn wide_four_seg_specs() -> Vec<WideSegSpec> {
    // is unchanged. With num_partitions=2, the two segments' chunks land
                let qty = (i as i32) % 7;
                    tree: Arc::new(resolved),
        rows, expected,
    );
        },
                &schema,
        ]),
            pred_wide_bool("active", Operator::Eq, true),
        (4, "netflix".to_string(), 410),
            let collector: Arc<dyn RowGroupDocsCollector> =
}
                    ),
    // case — the wrapper path must not lose, duplicate, or reorder rows.
    // Both collectors have per_leaf entries. Collector0 (inside pruned AND)
            1 => "us-west",
    let file = std::fs::File::open(&path).unwrap();
            rgs.push(RowGroupInfo {
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
    let meta =
            let n = parquet_meta.row_group(i).num_rows();
    ))
    // Simulate a chunk with RGs [2, 3] (offset — doesn't start at 0).
        ]),
    }
    assert_eq!(
            matches: vec![2],
    let store: Arc<dyn object_store::ObjectStore> =
            BoolNode::And(vec![
        }
        .indexed_pushdown_filters(false)
        predicate_columns: vec![],
        ]),
                    pred_wide_str("region", Operator::Eq, "us-east"),
            let matching = per_segment_matches
        schema.clone(),
//
    // inside the chunk list is a flush-point for partitioning.rs.
    let tree = BoolNode::Or(vec![
            &self,
        first_row: 4,
// These extend the 2-segment fixture to 4-6 segments, with small RG sizes
    );
    );
            rows: 16,
            arrow_schema: meta.schema().clone(),
        for i in 0..parquet_meta.num_row_groups() {
        cancellation_token: None,
    tmp
    let prices: Vec<i32> = (0..rows).map(|i| (i as i32) * 10).collect(); // 0, 10, 20, ...
    assert!(
        },
#[derive(Debug)]
                    std::sync::Arc::new(std::collections::HashMap::new()),
async fn six_segments_some_with_no_matches() {
    );
        brand: "amazon",
        page_prune_metrics: None,
                ]),
) -> Vec<(i32, i32, i32, String, bool)> {
 *
                    std::sync::Arc::new(crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory),
    while let Some(batch) = stream.next().await {
//
            offset += n;
            Ok(eval)
            brand: "netflix",
                    None,
    // Tree: AND(price > 60, OR(Collector, qty < 2))
            BoolNode::And(vec![
                    segment.writer_generation,
    for (ord, tmp) in [&tmp0, &tmp1].iter().enumerate() {
        leaf_exprs
    #[derive(Debug)]
        },
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Boolean(Some(v))),
            brand: "google",
    let ctx = SessionContext::new();
    let expected = wide_oracle(&specs, |i| {
        stats_prune_tree: Some(Arc::new(spt)),
        collector_strategy: crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
            1,
        &schema,
                first_row: offset,
            rows.push((ord, brand.value(i).to_string(), price.value(i)));
async fn partition_count_does_not_affect_result_set() {
            writer_generation: ord as i64,
    };
            tree,
                    std::collections::HashMap::new(),
}
        &pruning_predicates,
            max_doc: offset,
                Arc::clone(&segment.metadata),
async fn stats_prune_multi_segment_single_partition() {
    let tree = BoolNode::And(vec![
    }
    );
        let size = std::fs::metadata(&path).unwrap().len();
/// so tests can compute the oracle truth without a second parquet read.
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(
        max_doc: i32,
            max_rg_rows: 4,
                pred_wide_int("price", Operator::Gt, 100),
    let with_two = run_two_segment_query(matches, /*num_partitions*/ 2).await;
        &schema,
        let b = batch.unwrap();
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        ]),
/// directly over the deterministic per-row values. Mirrors the shape of
        let file = std::fs::File::open(&path).unwrap();
    // Here: give each segment the same set of doc IDs {0, 4}. If doc-ID
    let factory: super::super::table_provider::EvaluatorFactory = {
        });
                &schema,
        )),
        .set_statistics_enabled(datafusion::parquet::file::properties::EnabledStatistics::Page)
use datafusion::arrow::array::BooleanArray;
    num_partitions: usize,
            max_rg_rows: 8,
        fn collect_packed_u64_bitset(
            matches: vec![0, 7],
            .iter()
        .unwrap();
    let brand_to_ord: std::collections::HashMap<&'static str, i32> = specs
            pred_wide_int("qty", Operator::Lt, 2),
) -> Vec<(i32, i32, i32, String, bool)> {
            Ok(out.into())
    let specs = vec![
}
                crate::indexed_table::page_pruner::build_pruning_predicate(expr, schema.clone())
    let (rows, max_in_flight) = run_two_segment_query_witness(matches, /*num_partitions*/ 1).await;
            }
        rows: 16,
    ]);
// ── Wide-schema tests ──────────────────────────────────────────────
    let schema = meta.schema().clone();
            crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::without_metrics(),
    ]);
    let orderings: Vec<BoolNode> = vec![
        index: 3,
            let pruner = Arc::new(PagePruner::new(
        query_config: std::sync::Arc::new(qc),
        store_url,
        for i in 0..b.num_rows() {
fn five_segment_specs() -> Vec<SegSpec> {
async fn run_two_segment_query(
    let mut segments: Vec<SegmentFileInfo> = Vec::new();
        }
    impl RowGroupDocsCollector for AllDocs {
}
            matches: vec![4, 9, 14],
        BoolNode::Or(vec![
            );
        tree: source.tree.clone(),
// Wide-schema multi-segment tests
        evaluator: Arc::new(crate::indexed_table::eval::bitmap_tree::BitmapTreeEvaluator),
    // Typical assignment: one segment per partition (no cross-segment
                pred_wide_str("region", Operator::Eq, "us-west"),
    ];
        ]),
            brand: "meta",
        WideSegSpec {
        vec![
            matches: vec![],
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    // None → RG skip) without hanging or producing phantom rows.
         (max concurrent collector invocations should be 1, was {})",
                prev,
            // Clone specs for each run since run_segments consumes the Vec.
    let df = ctx
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
    collect_pred_exprs(&tree, &mut leaf_exprs);
async fn stats_prune_single_segment_single_partition() {
            for i in 0..span {
        Arc<datafusion::physical_optimizer::pruning::PruningPredicate>,
    // Collector1 child should be true.
        &parquet_meta,
            rows: 16,
    while let Some(batch) = stream.next().await {
            rows: 4,
            let span = (max_doc - min_doc) as usize;
                let active = i % 2 == 0;
            .downcast_ref::<datafusion::arrow::array::BooleanArray>()
            rows: 16,
        "Collector1 should produce non-empty candidates"
        vec![(0, Arc::new(AllDocs) as Arc<dyn RowGroupDocsCollector>)];
    (rows, max_observed)
    let expected = wide_oracle(&specs, |i| i % 3 == 0 || i % 2 == 0);
        pruning_predicates: Arc::new(pruning_predicates),
            base_price: 300,
    };
        pushdown_predicate: None,
        BoolNode::Or(vec![
/// has ~16 rows and max_rg_rows=4 → 4 RGs per segment. Total across shard:
            // here use 1 collector leaf, so one pair.
        let schema = schema.clone();
    // assignment as separate `SegmentChunk`s. Pre-fix: `QueryShardExec::execute`
                first_row: offset,
    let ctx = SessionContext::new();
    assert_eq!(
/// Wide-schema segment spec. Collector leaf matches every doc whose brand
/// 3. Empty collector bitsets are produced for pruned subtrees
    let store: Arc<dyn object_store::ObjectStore> =
                    leaves: Arc::new(crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::without_metrics()),
}
    ]
async fn stats_prune_multi_segment_multi_partition() {
    specs: Vec<WideSegSpec>,
                .unwrap_or(0) as i32;
            &schema,
            matches: vec![2, 7, 12],
        rows,
        let schema = schema.clone();
        }
        for i in 0..b.num_rows() {
            parquet_size: size,
    let with_one = run_two_segment_query(matches.clone(), /*num_partitions*/ 1).await;
async fn stats_prune_direct_prefetch_asserts_pruning_and_empty_bitsets() {
        // OR(A, OR(B,C))
    BoolNode::Predicate(Arc::new(
                schema.clone(),
    out
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
        let active = b.column(4).as_any().downcast_ref::<BooleanArray>().unwrap();
        tree: Arc::new(resolved),
        Arc::clone(&parquet_meta),
        query_config: std::sync::Arc::new(qc),
        max_collector_parallelism: 1,
    max_rg_rows: usize,
    assert!(
/// Generic wide-schema runner. Builds one parquet per spec, wraps each in
            ));
        let parquet_meta = meta.metadata().clone();
///
    let per_segment_matches: Vec<Vec<i32>> = specs.iter().map(|s| s.matches.clone()).collect();
        &schema,
            (0, "amazon".to_string(), 50),
            let pruner = Arc::new(PagePruner::new(
        predicate_columns: vec![],
                    None,
/// Single segment (4 RGs of 4 rows), single partition.
        if schema_opt.is_none() {
        },
    assert_eq!(
    let factory: super::super::table_provider::EvaluatorFactory = {
            out.push((ord as i32, s.brand.to_string(), s.base_price + m));
    }
    for (ord, tmp) in tmps.iter().enumerate() {
        .iter()
    let path = tmp.path().to_path_buf();
        let parquet_meta = meta.metadata().clone();
        // OR(OR(B,C), A)
    rows: usize,
    let tree = tree.push_not_down().flatten();
        pushdown_predicate: None,
        Arc::new(object_store::local::LocalFileSystem::new());
        leaves: Arc::new(
            matches: vec![5, 10, 15],
            brand: "meta",
            rows: 32,
    let mut schema_opt: Option<SchemaRef> = None;
/// Generic multi-segment runner. Builds one parquet per spec, wires them up
        });
            // Per-segment max_doc. Both happen to be 8 here.
            max_doc: i32,
        SegSpec {
        SegSpec {
    // RG3 at absolute index 3: should NOT be pruned.
                BoolNode::Collector { annotation_id: 0 },
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        let tree = Arc::clone(&tree);
    // num_partitions=1 → all 20 RGs land in one partition, producing a
    let path = tmp.path().to_path_buf();
    // Build expected rows: for each segment, the rows at its match offsets.
        pushdown_predicate: None,
    ]);
            .filter_map(|expr| {
        spt.rg_can_match[0],
        segments.push(SegmentFileInfo {
}
                crate::indexed_table::eval::single_collector::SingleCollectorEvaluator::new(
        page_prune_metrics: None,
/// in a `ConcurrencyWitnessCollector` sharing one global high-water-mark
        result_rg0.is_none(),
/// 5 segments × 4 RGs × 4 rows = 80 rows, 20 RGs.
    let tmp = NamedTempFile::new().unwrap();
    });
                ),
            BoolNode::And(vec![
            max_rg_rows: 4,
        first_row: 12,
    let rg_index_to_pos: HashMap<usize, usize> = rg_indices
    let expected = expected_for_five_segments();
    specs: Vec<WideSegSpec>,
        stats_prune_tree: Some(Arc::new(spt_low)),
    .unwrap();
            }],
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        })
                .iter()
            }
    }
    let matches = vec![vec![2, 6], vec![3, 7]];
            BoolNode::Collector { annotation_id: 2 },
            (1, "apple".to_string(), 105),
    ];
        store_url,
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
    let mut rows: Vec<(i32, String, i32)> = Vec::new();
    ctx.register_table("t", provider).unwrap();
    assert!(
        pred_wide_int("price", Operator::Gt, 80),
    );
    let rows = run_wide_segments_with_stats_pruning(clone_wide_specs(&specs), tree, 1).await;
                .position(|s| s.brand == brand.value(i))
        .build();
    );
    // chunks). Result identity must still hold.
        cost_predicate: 1,
        schema.clone(),
}
            max_rg_rows: 4,
            global_base: 0,
    );
            &self,
        &rg_indices_low,
}
        store,
    impl RowGroupDocsCollector for AllDocs {
        .await
                first_row: offset,
    );
        BoolNode::Or(vec![
    // Per-chunk evaluator: builds a Path C TreeBitsetSource with a fresh
    write_segment_rg(brand, base_price, rows, /*max_rg_rows*/ 4)
                    0,
        .collect();
                Arc::clone(&segment.metadata),
                max_rg_rows: 4,
    let mut leaf_exprs: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = Vec::new();
    ]))
    let expected = wide_oracle(&specs, |i| (i as i32) * 10 > 80);
            }
}
        )
        vec![
                &schema,
        leaves: Arc::new(
        }
    for (ord, tmp) in [&tmp0, &tmp1].iter().enumerate() {
        let span = (max_doc - min_doc) as usize;
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
    // NOT some shard-wide concatenation. If a bug made seg0's collector see
            global_base: 0,
    };
    // RG1 (prices 40-70): price>60 might be true for row with price=70
    ]);
/// Tree: AND(price > 50, OR(Collector, qty < 3))
        let path = tmp.path().to_path_buf();
        let meta =
    let mut segments: Vec<SegmentFileInfo> = Vec::new();
        Arc::new(datafusion::physical_expr::expressions::Literal::new(
        let mut offset = 0i64;
                ord,
        let b = batch.unwrap();
        BoolNode::Collector { annotation_id: 1 },
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        sort_orders: vec![],
/// Write a 5-column segment. Deterministic per-row values driven by row index
            sort_min: None,
        (i32_i * 10 >= 100 && i32_i % 7 == 3) || (region == "us-west" && active)
        .indexed_pushdown_filters(false)
                .map(|s| SegSpec {
    let mut stream = df.execute_stream().await.unwrap();
                    None,
                    collector_strategy: crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
                out[i / 64] |= 1u64 << (i % 64);
            ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true))
            brand: "amazon",
    //
    let rg3 = RowGroupInfo {
    // in *different* partitions and DataFusion drives them concurrently,
        .force_strategy(Some(FilterStrategy::BooleanMask))
            Arc::clone(&tree),
}
        &pruning_predicates,
        let size = std::fs::metadata(&path).unwrap().len();
/// a sibling OR branch.
    }));
/// Without the fix, branch0's pruning would incorrectly affect branch1.
        evaluator: Arc::new(crate::indexed_table::eval::bitmap_tree::BitmapTreeEvaluator),
    let rows = run_two_segment_query(vec![vec![0, 4], vec![0, 4]], 2).await;
        let region = b.column(3).as_any().downcast_ref::<StringArray>().unwrap();
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema, Some(props)).unwrap();
    // Assert: prefetch_rg for RG0 (offset index 0, pruned) returns None.
        cancellation_token: None,
}
/// Variant of `run_two_segment_query` that wraps each segment's collector
    assert!(
    let spt_low = StatsPruneTree::build_from_bool_node(
            Arc::new(Int32Array::from(prices)),
        let region = match i % 3 {
    let mut rows: Vec<(i32, String, i32)> = Vec::new();
            let leaf_count = tree.collector_leaf_count();
        rows: 16,
                    pred_wide_int("qty", Operator::Gt, 5),
        })
    // Collector1 always matches → OR always has candidates.
        })
        max_rg_rows: 4,
        Arc::new(object_store::local::LocalFileSystem::new());
        .downcast_ref::<crate::indexed_table::eval::TreePrefetch>()
    // RG2 at absolute index 2: should NOT be pruned (prices 80-110, all > 60).
            max_doc: offset,
 * this file be licensed under the Apache-2.0 license or a
    let tree = Arc::new(tree.push_not_down().flatten());
        ]),
        .enumerate()
/// a Path C `TreeBitsetSource` with the caller-supplied tree + predicates,
        assert_eq!(rows, expected, "np={} failed", np);
            writer_generation: ord as i64,
    // doc_max=16 instead of 8, it would try to match docs 8..16 which don't
                .get(segment.writer_generation as usize)
/// can assert on set equality regardless of partition/chunk ordering.
        .iter()
    ) -> Result<CollectDocsResult, String> {
        let path = tmp.path().to_path_buf();
        (4, "netflix".to_string(), 405),
        index: 0,
    let mut stream = df.execute_stream().await.unwrap();
    let specs = wide_four_seg_specs();
    let pruner = Arc::new(PagePruner::new(
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
            sort_max: None,
        "pruned Collector0 should have an empty bitmap in per_leaf"
///
        &tree,
            BoolNode::Or(vec![
    // Build evaluator and call prefetch_rg for RG1.
}
    // one task per child stream and drives them concurrently — the witness
    let per_segment_matches = Arc::new(per_segment_matches);
    };
                    crate::indexed_table::eval::single_collector::CollectorCallStrategy::FullRange,
    let expected = wide_oracle(&specs, |i| {
    w.write(&batch).unwrap();
            rgs.push(RowGroupInfo {
        segments.push(SegmentFileInfo {
        .sql("SELECT brand, price, qty, region, active FROM t")
            ));
    let rg_index_to_pos: HashMap<usize, usize> = rg_indices
                })
    // Build as nested OR(OR(A,B), C) — this is how convert_expr produces it
/// exercised.
    .unwrap();
            Arc::clone(&pruning_predicates),
            pred_wide_int("qty", Operator::Lt, 3),
    let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> =
            BoolNode::Collector { annotation_id: 0 },
// Mirrors the failing PPL pattern.
            base_price: 0,
        SegSpec {
            rows: 16,
            rgs.push(RowGroupInfo {
    ]));
            offset += n;
}
                BoolNode::And(vec![
}
            _ => "eu-west",
            crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::without_metrics(),
        segments.push(SegmentFileInfo {
    struct AllDocs;
            if pred(i) {
        (2, "google".to_string(), 208),
        stats_prune_tree: Some(Arc::new(spt)),
        pushdown_predicate: None,
        rg_index_to_pos: rg_indices_low
}
    rows
// containing collectors still produce empty bitmaps.
        max_in_flight, 1,
        segments,
        let mut rgs = Vec::new();
            let collector: Arc<dyn RowGroupDocsCollector> =
    // Root OR should still be true (Collector1 child is always-true).
        usize,
        let max_in_flight = Arc::clone(&max_in_flight);
async fn stats_prune_asserts_empty_collector_bitset_in_pruned_subtree() {
                BoolNode::And(vec![
    // QueryShardExec::execute. Results must be identical to the 2-partition
            Ok(out.into())
        // OR(OR(A,B), C)
/// single query. Used to witness whether `QueryShardExec::execute`
    let tree = Arc::new(tree);
        store_url,
        for i in 0..parquet_meta.num_row_groups() {
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        &parquet_meta,
                    max_rg_rows: s.max_rg_rows,
) -> (Vec<(i32, String, i32)>, usize) {
                BoolNode::Collector { annotation_id: 0 },
            run_wide_segments_with_stats_pruning(clone_wide_specs(&specs), tree.clone(), np).await;
        let mut offset = 0i64;
            ));
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            rows: 16,
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
        BoolNode::DelegationPossible { original_expr, .. } => out.push(Arc::clone(original_expr)),
    ctx.register_table("t", provider).unwrap();
    // `QueryShardExec` exposes via `Partitioning::UnknownPartitioning(N)`
    // This is expected: stats pruning is conservative.
        )
    let expected = wide_oracle(&specs, |i| {
    );
    let rg_indices: Vec<usize> = vec![1];
    let expected = wide_oracle(&specs, |i| (i as i32) * 10 > 50);
        .collect();
///
            brand: "google",
    use crate::indexed_table::page_pruner::StatsPruneTree;
    let schema = wide_schema();
    while let Some(batch) = stream.next().await {
                    cost_predicate: 1,
    );
        ]),
    let df = ctx
}
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
            matches: vec![],
                schema.clone(),
    }
        let per_segment_matches = Arc::clone(&per_segment_matches);
                .iter()
}
    // Collector1 (surviving) must have NON-EMPTY bitmap.
                    rows: s.rows,
            brand: "apple",
/// Build the 2-segment table provider. Each segment gets its own matching
    brand: &'static str,
                    Some(collector), pruner, None, None, None, None,
    }];
            }
        store_url,
    );
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(
        .iter()
                    tree: Arc::new(resolved),
                    0,
        BoolNode::Or(vec![
    ];
        emit_row_ids: false,
        })
    let specs = vec![WideSegSpec {
        WideSegSpec {
    BoolNode::Predicate(Arc::new(
            object_path,
        .iter()
        .force_strategy(Some(FilterStrategy::BooleanMask))
            base_price: 0,
                    pred_wide_int("qty", Operator::Gt, 5),
}
        ],
    tree: BoolNode,
        },
            base_price: 300,
    let expected = wide_oracle(&specs, |i| (i as i32) * 10 > 50);
        datafusion::physical_expr::expressions::BinaryExpr::new(left, op, right),
            matches: vec![0, 8],
    matching: Vec<i32>,
        &self,
/// Collector that wraps `PerSegmentCollector` and tracks concurrent
        .indexed_pushdown_filters(false)
                    std::collections::HashMap::new(),
        ) -> Result<CollectDocsResult, String> {
    specs: &[WideSegSpec],
                    std::sync::Arc::new(std::collections::HashMap::new()),
                .unwrap();
    // Segment 1: match docs {1, 5} → apple rows at prices 101, 105
    assert_eq!(rows, expected);
    let prefetched = result_rg2.unwrap();
    > = leaf_exprs
}
}
        )),
    );
        assert_eq!(rows, expected, "np={} failed", np);
            (1, "apple".to_string(), 100),
    }
        },
        prune_tree_config: Some((
    Arc::new(Schema::new(vec![
    let meta =
        emit_row_ids: false,
        .force_strategy(Some(FilterStrategy::BooleanMask))
            np,
        let rows = run_segments(
                ]),
        ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true)).unwrap();
                out.push((ord as i32, price, qty, region.to_string(), active));
        SegSpec {
            let collector: Arc<dyn RowGroupDocsCollector> = Arc::new(ConcurrencyWitnessCollector {
    assert_eq!(rows.len(), 4, "result correctness sanity check");
        .collect();
    let rg1 = RowGroupInfo {
    };
            matches: vec![3, 11],
    assert!(
    let mut expected = expected;
            ));
//!
            max_rg_rows: 4,
// ══════════════════════════════════════════════════════════════════════
    rows: usize,
        let pruning_predicates = Arc::clone(&pruning_predicates);
        SegSpec {
) -> Vec<(i32, i32, i32, String, bool)> {
            let span = (max_doc - min_doc) as usize;
    pred: F,
    let rows = run_two_segment_query(vec![vec![], vec![0, 4]], 2).await;
}
            })
    // Now build source for chunk [2,3] — both survive. Verify offset lookup works.
            ]),
    max_in_flight: Arc<std::sync::atomic::AtomicUsize>,
            ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true))
            ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true))
/// Deep tree with NOT under multi-partition multi-segment.
        Arc::new(object_store::local::LocalFileSystem::new());
fn wide_schema() -> SchemaRef {
    // The same query under different partition counts must produce identical
    // locality is correct, seg0 returns amazon rows at prices 50, 54 AND
    per_segment_matches: Vec<Vec<i32>>,
                    rows: s.rows,
use super::*;
async fn run_wide_segments(
        let mut out = Vec::new();
}
/// Data: 16 rows, 4 RGs of 4 rows each.
/// Tree: OR(AND(Collector0, price > 100), AND(Collector1, region = "us-east"), AND(Collector2, qty > 5))
            max_rg_rows: 4,
    // Deliberately uneven: seg0 has 2 RGs, seg1 has 4 RGs, seg2 has 1 RG,
                crate::indexed_table::eval::single_collector::SingleCollectorEvaluator::new(
    let prices: Vec<i32> = (0..rows).map(|i| base_price + i as i32).collect();
    for (ord, tmp) in tmps.iter().enumerate() {
                    rg_index_to_pos,
        let path = tmp.path().to_path_buf();
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
                        crate::indexed_table::eval::bitmap_tree::BitmapTreeEvaluator,
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        let cur = self.in_flight.fetch_add(1, Ordering::SeqCst) + 1;
    }
        first_row: 4,
                    base_price: s.base_price,
        .sql("SELECT brand, price, qty, region, active FROM t")
        let mut offset = 0i64;
                Arc::clone(&segment.metadata),
        .collect();
            max_rg_rows: 4,
            rgs.push(RowGroupInfo {
         concurrently (expected max_in_flight=2, was {})",
                num_rows: n,
                max_in_flight: Arc::clone(&max_in_flight),
/// RG0 and RG1 should be pruned (max price < 60). RG2 and RG3 survive.
        out
            Arc::new(BooleanArray::from(actives)),
        let qty = (i as i32) % 7;
//! becomes one parquet file and one `SegmentFileInfo`. This module exercises:
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    // Tree: AND(collector, OR(AND(price >= 100, qty = 3), AND(region == "us-west", active == true)))
    // so the witness collector should observe `max_in_flight == 2`.
        })
struct ConcurrencyWitnessCollector {
        BoolNode::Or(vec![
                &schema,
                Arc::clone(&segment.metadata),
            writer_generation: ord as i64,
    );
        for i in 0..parquet_meta.num_row_groups() {
        num_rows: 4,
        !(i32_i * 10 < 30) && i32_i % 7 > 2 && i % 3 != 2
    for np in [1usize, 2, 3, 4, 5] {
        let b = batch.unwrap();
            let ord = *brand_to_ord.get(brand.value(i)).expect("known brand");
    let mut rows: Vec<(i32, i32, i32, String, bool)> = Vec::new();
/// so partition assignment that packs RGs across segment boundaries gets
    }));
    let factory: super::super::table_provider::EvaluatorFactory = {
        sort_fields: vec![],
        max_rg_rows: 4,
    for (ord, s) in specs.iter().enumerate() {
            sort_max: None,
    // collector) is ever in flight → `max_in_flight == 1`.
            pred_wide_str("region", Operator::Eq, "us-east"),
        fn collect_packed_u64_bitset(
            ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true))
                crate::indexed_table::eval::single_collector::SingleCollectorEvaluator::new(
    out.sort();
        pred_wide_int("qty", Operator::Gt, 2),
            1 => "us-west",
            rows.push((ord, brand.value(i).to_string(), price.value(i)));
const SEG0_ROWS: usize = 8;
    let mut schema_opt: Option<SchemaRef> = None;
    w.close().unwrap();
// ── Two-segment fixture ───────────────────────────────────────────────
    // seg3 has 8 RGs. Total ~60 rows across 15 RGs. Uneven fan-out
        .map(|i| match i % 3 {
/// used for StatsPruneTree is not normalized (push_not_down + flatten), child
            brand: "amazon",
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
            let pruner = Arc::new(PagePruner::new(
        .force_strategy(Some(FilterStrategy::BooleanMask))
///   regions: us-east,us-west,eu-west,us-east | us-west,eu-west,us-east,us-west | ...
                Arc::new(PerSegmentCollector { matching });
                .unwrap();
async fn single_partition_runs_chunks_sequentially_no_inner_parallelism() {
        evaluator_factory: factory,
    fn collect_packed_u64_bitset(
        }, // 2 RGs
                ]),
                price.value(i),
                    pred_wide_str("region", Operator::Eq, "us-east"),
    let brands: Vec<&str> = (0..rows).map(|_| brand).collect();
            BoolNode::Collector { annotation_id: 0 },
// ── Tests ─────────────────────────────────────────────────────────
        }
            sort_min: None,
                rows: 16,
            _ => "eu-west",
    #[derive(Debug)]
                    BoolNode::Collector { annotation_id: 2 },
    let store: Arc<dyn object_store::ObjectStore> =
        min_doc: i32,
    let tree_arc = Arc::new(tree);
            for i in 0..span {
            max_rg_rows: 4,
// Predicate leaves: generated by the test, evaluated via Path C tree walker.
        Field::new("qty", DataType::Int32, false),
            global_base: 0,
                .unwrap_or_default();
        let result = self.inner.collect_packed_u64_bitset(min_doc, max_doc);
                    None,
    ctx.register_table("t", provider).unwrap();
/// Five-segment fixture used across the partition-sweep tests. Each segment
            max_rg_rows: 4,
        "RG1 (max price=70) should not be stats-pruned"
    match tree {
    // seg1 returns apple rows at prices 100, 104. If the implementation
    rows.sort();
}
async fn run_two_segment_query_witness(
        let i32_i = i as i32;
    let batch = RecordBatch::try_new(
        },
        "surviving Collector1 should have a non-empty bitmap in per_leaf"
    collect_pred_exprs(&tree, &mut leaf_exprs);
    );
    };
    );
        Field::new("active", DataType::Boolean, false),
            Ok(eval)
    let tmp = NamedTempFile::new().unwrap();
///
    for (ord, s) in specs.iter().enumerate() {
        max_in_flight,
        Arc<datafusion::physical_optimizer::pruning::PruningPredicate>,
    let source = crate::indexed_table::eval::TreeBitsetSource {
    ];
            sort_min: None,
            row_groups: rgs,
            1 => "us-west",
    assert!(
    use crate::indexed_table::page_pruner::StatsPruneTree;
///
    for np in [1usize, 2, 4] {
            row_groups: rgs,
        index: 1,
        max_rg_rows: 4,
            }
        .target_partitions(num_partitions)
                        i as i32,
// These tests exercise the full pipeline with `prune_tree_config: Some(...)`
            global_base: 0,
    // gets empty bitmap from skip_dfs_with_empty_bitmaps (no FFM call).
                index: i,
            ]),
) {
    let prefetched = result.unwrap();
    collect_pred_exprs(&tree, &mut leaf_exprs);
        "cross-partition parallelism should still let both segments run \
//
        emit_row_ids: false,
    let schema = schema_opt.unwrap();
        let rows = run_wide_segments(clone_wide_specs(&specs), tree.clone(), np).await;
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
        let active = b
            metadata: Arc::clone(&parquet_meta),
        }
                    base_price: s.base_price,
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
        let mut out = vec![0u64; span.div_ceil(64)];
                    BoolNode::Collector { annotation_id: 1 },
    assert!(
    );
    BoolNode::Predicate(Arc::new(
        WideSegSpec {
    tree: &BoolNode,
                crate::indexed_table::eval::TreeBitsetSource {
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
    let specs = vec![WideSegSpec {
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
                BoolNode::Collector { annotation_id: 2 },
        },
            pred_wide_int("qty", Operator::Gt, 5),
        num_rows: 4,
                brand: "amazon",
        schema: schema.clone(),
///
            max_doc: offset,
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    // from `A OR B OR C` (left-associative binary OR).
            &self,
            brand: s.brand,
        let meta =
            max_rg_rows: 4,
        ]),
        BoolNode::And(c) | BoolNode::Or(c) => c.iter().for_each(|ch| collect_pred_exprs(ch, out)),
        let tree = Arc::clone(&tree);
            max_rg_rows: 4,
    }
            let mut out = vec![0u64; span.div_ceil(64)];
        },
        sort_fields: vec![],
        .build();
    // wrapped them in `UnionExec` + `CoalescePartitionsExec`, which spawns
            1 => "us-west",
    let rows = run_segments(five_segment_specs(), 3).await;
    rows.sort();
            BoolNode::Collector { annotation_id: 0 },
        .target_partitions(num_partitions)
    }
            schema_opt = Some(meta.schema().clone());
            let resolved = tree.resolve(&per_leaf)?;
}
    // Realistic shard: 6 segments, but only half contribute matches. Ensures
        SegSpec {
    let expected: Vec<(i32, String, i32)> = {
        .enumerate()
// Schema: (brand Utf8, price Int32, qty Int32, region Utf8, active Boolean).
        }
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
    ));
        let meta =
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
        max_collector_parallelism: 1,
                    (
    // Segment 0: match docs {0, 3, 7} → amazon rows at prices 50, 53, 57
            max_rg_rows: 4,
        predicate_columns: vec![],
        price > 100 || region == "us-east" || qty > 5
            offset += n;
/// RG0: price max=30 → price>100 pruned. RG0 has region="us-east" rows → branch1 should match.
        let active = i % 2 == 0;
    let parquet_meta = meta.metadata().clone();
        result
            max_doc: i32,
    // Sweep partition counts; result should be stable.
                },
            object_path,
        predicate_columns: vec![],
            Ok(eval)
        self.in_flight.fetch_sub(1, Ordering::SeqCst);
        SegSpec {
    let tree = BoolNode::And(vec![
            BoolNode::Collector { annotation_id: 0 },
        index: 1,
        (0, "amazon".to_string(), 11),
                pred_wide_int("price", Operator::GtEq, 100),
    w.close().unwrap();
            0 => "us-east",
    let specs = wide_four_seg_specs();
        &schema,
    num_partitions: usize,
            });
    assert!(
    let source = crate::indexed_table::eval::TreeBitsetSource {
    // Candidates should be non-empty (Collector1 matches all docs).
            brand: "apple",
            max_doc: offset,
    num_partitions: usize,
        BoolNode::Collector { annotation_id: 0 },
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        Arc::clone(&parquet_meta),
/// AND(NOT(price < 40), OR(Collector, qty >= 5))
async fn two_segments_each_contributes_its_own_docs() {
            let resolved = tree.resolve(&per_leaf)?;
    let mut out = Vec::new();
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
            metadata: Arc::clone(&parquet_meta),
            rows: 16,
                    std::sync::Arc::new(std::collections::HashMap::new()),
        .map(|(i, s)| (s.brand, i as i32))
                    segment.writer_generation,
        .map(|s| write_wide_segment(s.brand, s.rows, s.max_rg_rows))
            brand: "apple",
        }
// The earlier tests use a 2-column schema (brand, price). Production shards
            BoolNode::Collector { annotation_id: 0 },
    assert!(
fn pred_wide_str(col: &str, op: Operator, v: &str) -> BoolNode {
            metadata: Arc::clone(&parquet_meta),
        ]),
    // prices: [0,10,20,30], [40,50,60,70], [80,90,100,110], [120,130,140,150]
    let specs = wide_four_seg_specs();
        // Hold the slot long enough that any genuine parallelism would
            (1, "apple".to_string(), 104),
                    matches: s.matches.clone(),
        collector_strategy: crate::indexed_table::eval::CollectorCallStrategy::TightenOuterBounds,
    let schema = wide_schema();
        !prefetched.candidates.is_empty(),
        },
            max_rg_rows: 4,
        let parquet_meta = meta.metadata().clone();
async fn five_segments_each_with_four_rgs_five_partitions() {
            global_base: 0,
                out[i / 64] |= 1u64 << (i % 64);
    let right: Arc<dyn datafusion::physical_expr::PhysicalExpr> =
    // num_partitions=5, total_rows=80 → rows_per_partition=16 (ceil).
        fn collect_packed_u64_bitset(
    // Downcast context to TreePrefetch to inspect per_leaf bitmaps.
                page_prune_metrics: None,
    // Wire SegmentFileInfos.
                    Some(collector), pruner, None, None, None, None,
    let specs = vec![WideSegSpec {
    // matching set is pulled from `per_segment_matches[segment.writer_generation]`,
                schema.clone(),
    let qc = crate::datafusion_query_config::DatafusionQueryConfig::builder()
        first_row: 0,
/// Descriptor of a segment fixture for `run_segments`.
                BoolNode::And(vec![
    // exist in its file and we'd get wrong/missing rows.
            BoolNode::And(vec![
            pred_wide_int("qty", Operator::GtEq, 5),
async fn stats_prune_single_segment_multi_partition() {
    ]);
    }));
    let in_flight = Arc::new(std::sync::atomic::AtomicUsize::new(0));
        SegSpec {
    let specs = wide_four_seg_specs();
        }
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        page_pruner: Arc::new(PagePruner::new(
        BoolNode::Collector { annotation_id: 0 },
    vec![
        2,
// Segment 1: 8 rows of `apple` brand (prices 100..108).
        // Update high-water-mark with a CAS loop.
    }
        prune_tree_config: None,
    let result = source.prefetch_rg(&rg1, 4, 8).unwrap();
}
    let tmp0 = write_segment("amazon", 50, SEG0_ROWS);
        .build();
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
        }
        store,
/// and tree AND(price > 60, OR(Collector, qty < 2)).
    }
        rg_index_to_pos: rg_index_to_pos,
///   prices: 0,10,20,30 | 40,50,60,70 | 80,90,100,110 | 120,130,140,150
        if schema_opt.is_none() {
            brand: "meta",
// (on `brand`) with 1-3 predicate leaves on numeric/string/boolean columns.
    struct AllDocs;
/// the generations it was built for so tests can confirm the evaluator factory called
        rg_index_to_pos,
        let size = std::fs::metadata(&path).unwrap().len();
            .map(|(pos, &idx)| (idx, pos))
//
        page_pruner: pruner,
    // Now simulate a chunk with RGs [0, 1] — these SHOULD be pruned.
    out.sort();
        segments,
            let mut out = vec![0u64; span.div_ceil(64)];
        spt.rg_can_match[1],
    let factory: super::super::table_provider::EvaluatorFactory = {
        let in_flight = Arc::clone(&in_flight);
    let store: Arc<dyn object_store::ObjectStore> =
    let col_idx = schema.index_of(col).expect("wide column");
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
        }, // 8 RGs
        Field::new("price", DataType::Int32, false),
            matches: vec![0, 5, 10, 15],
    // Tree: AND(all_brand_docs, OR(region == "us-east", active == true))
    assert!(
    impl RowGroupDocsCollector for AllDocs {
                let rel = (doc - min_doc) as usize;
        .collect();
            base_price: 400,
    }];
    let specs = vec![WideSegSpec {
    w.write(&batch).unwrap();
/// All segments in one partition — verifies stats pruning across segments.
        query_config: std::sync::Arc::new(qc),
                    )
            schema.clone(),
            rows: 16,
            rows.push((ord, brand.value(i).to_string(), price.value(i)));
        ]),
    matches: Vec<i32>,
    vec![
                out[i / 64] |= 1u64 << (i % 64);
    // AND child should be false (price>100 fails for RG1 max=70).
        for i in 0..b.num_rows() {
                })
                    pred_wide_str("region", Operator::Eq, "us-east"),
        for (ord, s) in specs.iter().enumerate() {
    struct AllDocs;
            parquet_size: size,
    }
        while cur > prev {
    out: &mut Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
    let spec = WideSegSpec {
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
    let has_nonempty = tree_prefetch.per_leaf.iter().any(|(_, bm)| !bm.is_empty());
    let specs = wide_four_seg_specs();
                    max_rg_rows: s.max_rg_rows,
        };
        })
    let actives: Vec<bool> = (0..rows).map(|i| i % 2 == 0).collect();
        ),
            object_path,
        rows,
    let rows = run_segments(specs, 3).await;
        out.sort();
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
            sort_min: None,
    let specs = five_segment_specs();
/// Scenario: 3-way OR built as nested OR(OR(A,B), C) — after flatten becomes
    let props = datafusion::parquet::file::properties::WriterProperties::builder()
/// Uses a single segment with 4 RGs (prices [0..30],[30..70],[70..110],[110..150])
#[derive(Debug)]
async fn run_wide_segments_with_stats_pruning(
    // so wrong writer_generation propagation would immediately produce wrong rows.
/// 1. RGs with stats that prove no-match return `None` (pruned)
    let schema = schema_opt.unwrap();
/*
            base_price: 0,
        pred_wide_int("price", Operator::Gt, 50),
        ) -> Result<CollectDocsResult, String> {
            base_price: 100,
        tree_prefetch.per_leaf.len()
                    crate::indexed_table::eval::single_collector::CollectorCallStrategy::FullRange,
                .enumerate()
        let mut rgs = Vec::new();
            }
        let file = std::fs::File::open(&path).unwrap();
        datafusion::physical_expr::expressions::Column::new(col, col_idx),
/// Write a parquet segment with a configurable max-row-group-size so tests
/// a non-pruned branch still appear in results regardless of clause ordering.
        SegSpec {
        max_rg_rows: 4,
    };
    ]
            crate::indexed_table::page_pruner::build_pruning_predicate(expr, schema.clone())
            sort_max: None,
    }];
                inner: PerSegmentCollector { matching },
        pred_wide_int("price", Operator::Gt, 80),
    tree: BoolNode,
    let result_rg1 = source.prefetch_rg(&rg1, 4, 8).unwrap();
        (0, "amazon".to_string(), 3),
                pred_wide_int("price", Operator::Gt, 100),
            let rg_index_to_pos: HashMap<usize, usize> = chunk
    }
    let pruning_predicates: HashMap<
    let source2 = crate::indexed_table::eval::TreeBitsetSource {
            let leaf_count = tree.collector_leaf_count();
            specs
    };
        store,
        !spt_low.rg_can_match[0],
            Ok(eval)
            max_rg_rows: 4,
        .map(|(pos, &idx)| (idx, pos))
                num_rows: n,
}
        let file = std::fs::File::open(&path).unwrap();
}
    let mut schema_opt: Option<SchemaRef> = None;
                index: i,
        &schema,
    });
        pred_wide_str("region", Operator::NotEq, "eu-west"),
                        Arc::new(AllDocs) as Arc<dyn RowGroupDocsCollector>,
    specs
}
            BoolNode::Collector { annotation_id: 0 },
    while let Some(batch) = stream.next().await {
// to 5. Goal: stress the interaction between partitioning, chunk packing,
        BoolNode::And(vec![
        .collect();
        &tree,
        rows: 16,
    // RG0 (prices 0-30): price>60 → false → AND=false
    }));
        for i in 0..b.num_rows() {
        assert_eq!(rows, expected, "np={} failed", np);
}
            let per_leaf: Vec<(i32, Arc<dyn RowGroupDocsCollector>)> = (0..leaf_count)
            });
            offset += n;
    ) -> Result<CollectDocsResult, String> {
    )
    for np in [2usize, 3, 5, 8] {
            pred_wide_bool("active", Operator::Eq, true),
        num_rows: 4,
    inner: PerSegmentCollector,
        "3-way OR with nested structure must produce correct results after flatten"
        for i in 0..b.num_rows() {
    // Verify the collector bitmap is non-empty (all docs match).
        max_doc: i32,
    assert!(spt.children[1].rg_can_match[0], "Collector1 should be true");
        .map(|s| write_segment_rg(s.brand, s.base_price, s.rows, s.max_rg_rows))
            Arc::new(StringArray::from(brands)),
    base_price: i32,
/// Oracle: compute expected rows by running the same boolean predicate
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
        evaluator_factory: factory,
/// Collector1 survives → RG not skipped → refinement runs.
}
}
        segments.push(SegmentFileInfo {
        }, // 1 RG
        "RG0 should be pruned by stats (price>60 fails for prices 0-30)"
    let rows = run_wide_segments_with_stats_pruning(specs, tree, 1).await;
        }
    impl RowGroupDocsCollector for AllDocs {
                    cost_predicate: 1,
            sort_max: None,
            schema_opt = Some(meta.schema().clone());
        for &m in &s.matches {
            );
            pred_wide_int("qty", Operator::Lt, 3),
            crate::indexed_table::eval::bitmap_tree::CollectorLeafBitmaps::without_metrics(),
                active.value(i),
    let spt = StatsPruneTree::build_from_bool_node(
// ══════════════════════════════════════════════════════════════════════
    let parquet_meta = meta.metadata().clone();
                Ordering::SeqCst,
                    page_prune_metrics: Some(
    // Build a TreeBitsetSource with the offset chunk [2,3] and call prefetch_rg.
            });
    for (idx, tree) in orderings.into_iter().enumerate() {
        num_rows: 4,
async fn two_segments_doc_ids_are_segment_local() {
        BoolNode::Or(vec![
        assert_eq!(rows, expected, "np={} failed", np);
            let matching = per_segment_matches
    let tree = BoolNode::And(vec![
        BoolNode::And(vec![
 */
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
            for i in 0..span {
                region.value(i).to_string(),
        let mut rgs = Vec::new();
        let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
/// Directly exercises `prefetch_rg` to assert:
    for (ord, tmp) in tmps.iter().enumerate() {
            for &m in &s.matches {
    }
    let mut segments: Vec<SegmentFileInfo> = Vec::new();
            .collect(),
/// equals the segment's brand (i.e. all docs in that segment). Tests layer
    let matches = vec![vec![2, 6], vec![3, 7]];
    ]);
        let price = b.column(1).as_any().downcast_ref::<Int32Array>().unwrap();
            Arc::new(Int32Array::from(qtys)),
    assert_eq!(
            for i in 0..span {
    let specs = wide_four_seg_specs();
            brand: "netflix",
                    segment.writer_generation,
                .collect(),
        })
    num_partitions: usize,
    let tmps: Vec<NamedTempFile> = specs
        (1, Arc::new(AllDocs) as Arc<dyn RowGroupDocsCollector>),
        SegSpec {
        .filter_map(|expr| {
            pred_wide_int("price", Operator::Gt, 100),
                ord,
    let rows = run_two_segment_query(vec![vec![0, 3, 7], vec![1, 5]], /*num_partitions*/ 2).await;
                    evaluator: Arc::new(
                    Some(collector), pruner, None, None, None, None,
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
        prune_tree_config: None,
        let file = std::fs::File::open(&path).unwrap();
fn wide_oracle<F: Fn(usize) -> bool>(
        .build();
            ScalarValue::Utf8(Some(v.to_string())),
    // row sets (modulo ordering, which we normalize by sort).
async fn wide_multi_segment_or_of_predicates_under_collector() {
async fn stats_prune_multi_segment_multi_partition_with_not() {
// section widens to 5 cols and exercises trees that mix a collector leaf
                },
        Field::new("region", DataType::Utf8, false),
async fn five_segments_each_with_four_rgs_three_partitions() {
}
        }
        HashMap<usize, Arc<datafusion::physical_optimizer::pruning::PruningPredicate>>,
/// us with the right per-segment identity.
        evaluator_factory: factory,
        rows,
fn write_segment(brand: &'static str, base_price: i32, rows: usize) -> NamedTempFile {
        pred_wide_int("price", Operator::Gt, 50),
    );
/// Multi segment (4 segments × 4 RGs), multi partition (2, 3, 5, 8).
            schema.clone(),
        "OR root should be true (Collector1 always matches)"
        index: 2,
    rows.sort();
        sort_orders: vec![],
            schema_opt = Some(meta.schema().clone());
    let resolved = Arc::new(tree).resolve(&per_leaf).unwrap();
        prune_tree_config: None,
            np,
            ]),
            ]),
        .context
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
            let n = parquet_meta.row_group(i).num_rows();
    let file = std::fs::File::open(&path).unwrap();
    ]);
        });
    let result_rg2 = source2.prefetch_rg(&rg2, 8, 12).unwrap();
        .map(|(pos, &idx)| (idx, pos))
    base_price: i32,
        }
/// Collector0 must have an empty per_leaf entry.
    // so only the currently-active chunk's `prefetch_rg` (and therefore the
        assert_eq!(rows, expected, "np={} failed", np);
            brand: "meta",
            &self,
        .iter()
    assert_eq!(parquet_meta.num_row_groups(), 4);
            Arc::new(Int32Array::from(prices)),
            brand: "amazon",
                .map(|(pos, &idx)| (idx, pos))
const SEG1_ROWS: usize = 8;
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(
            min_doc: i32,
                BoolNode::Collector { annotation_id: 0 },
    }
            let pruner = Arc::new(PagePruner::new(
                BoolNode::Collector { annotation_id: 1 },
            let n = parquet_meta.row_group(i).num_rows();
        let path = tmp.path().to_path_buf();
// so each segment has multiple RGs, and exercise `num_partitions` from 1
        sort_fields: vec![],
    assert_eq!(with_one.len(), 4);
    let col_idx = schema.index_of(col).expect("wide column");
    let mut schema_opt: Option<SchemaRef> = None;
        &self,
        })
        leaves: Arc::new(
/// Regression test for the flatten-misalignment bug: when the BoolNode tree
        &schema,
            ));
        "RG2 at offset index should not be pruned"
        .set_max_row_group_size(max_rg_rows)
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(
        .enumerate()
    let left: Arc<dyn datafusion::physical_expr::PhysicalExpr> = Arc::new(
                    std::sync::Arc::new(crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory),
    in_flight: Arc<std::sync::atomic::AtomicUsize>,
        Arc::new(object_store::local::LocalFileSystem::new());
        SegSpec {
        "RG2 should have non-empty candidates"
    }
/// collector inside it gets an empty bitmap in `per_leaf`.
        let per_segment_matches = Arc::clone(&per_segment_matches);
                    leaves: Arc::new(
            ]),
    }
        rows: 16,
            specs
//! - Per-segment doc ID locality (each segment has its own `[0, max_doc)`).
            rows: 16,
            // One (provider_key, collector) per Collector leaf — our trees
        let i32_i = i as i32;
            let mut out = vec![0u64; span.div_ceil(64)];
    assert_eq!(rows, expected_for_five_segments());
                .cloned()
        let b = batch.unwrap();
                    0 => "us-east",
            Arc::new(StringArray::from(brands)),
        BoolNode::Not(Box::new(pred_wide_int("price", Operator::Lt, 30))),
    }
async fn cross_partition_parallelism_is_preserved() {
    let schema = meta.schema().clone();
    let specs = wide_four_seg_specs();
    let schema = schema_opt.unwrap();
) -> NamedTempFile {
                index: i,
            let pruner = Arc::new(PagePruner::new(
                    evaluator: Arc::new(crate::indexed_table::eval::bitmap_tree::BitmapTreeEvaluator),
        segments,
}
        let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
        max_in_flight,
    ))
        for i in 0..s.rows {
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
/// Tree: OR(AND(price > 100, Collector0), Collector1)
        }
                    page_pruner: pruner,
    let tree = BoolNode::And(vec![
    // Tree: AND(all_brand_docs, NOT(price < 30), qty > 2, region != "eu-west")
}
        tree: Arc::new(resolved),
        schema.clone(),
                .map(|i| {
                .row_group_indices
                index: i,
        SegSpec {
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
async fn two_segments_empty_collector_in_one_segment() {
        .iter()
            });
}
) -> Vec<(i32, String, i32)> {
        },
    // Collector matches all docs; OR(all, qty<3) = all; so just price > 50.
        &rg_indices,
}
    );
/// Directly asserts that when a subtree under OR is stats-pruned, the
                schema.clone(),
    let rg2 = RowGroupInfo {
        fn collect_packed_u64_bitset(
/// and returns all passing rows as tagged tuples.
                    std::sync::Arc::new(crate::indexed_table::eval::single_collector::FfmDelegatedBackendCollectorFactory),
    let ctx = SessionContext::new();
    );
/// Brands are distinct per segment so results stay attributable. Matches
        pred_wide_int("price", Operator::Gt, 60),
    );
                    BoolNode::Collector { annotation_id: 1 },
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
        let meta =
        assert_eq!(rows, expected, "ordering {} produced wrong results", idx);
        ]),
async fn four_segments_mixed_rg_sizes() {
        pruning_predicates: source.pruning_predicates.clone(),
                    BoolNode::Collector { annotation_id: 0 },
            ]),
    ]);
        max_rg_rows: 4,
/// counter. Returns `(rows, max_in_flight_observed)`.
        let schema = schema.clone();
    let brands: Vec<&str> = (0..rows).map(|_| brand).collect();
fn write_segment_rg(
struct WideSegSpec {
    let tree_prefetch = prefetched
/// Same as above but tests different clause orderings to ensure no
            ArrowReaderMetadata::load(&file, ArrowReaderOptions::new().with_page_index(true))
        sort_orders: vec![],
            (0, "amazon".to_string(), 53),
            BoolNode::Or(vec![
    };
    let tmp = write_wide_segment(spec.brand, spec.rows, spec.max_rg_rows);
                    matches: s.matches.clone(),
    let tmp = write_wide_segment(spec.brand, spec.rows, spec.max_rg_rows);
        }
        brand: "amazon",
fn collect_pred_exprs(
        predicate_columns: vec![],
                    std::collections::HashMap::new(),
    );
        .build();
        .set_max_row_group_size(max_rg_rows)
        cost_collector: 10,
        spt.rg_can_match[0],
                .get(segment.writer_generation as usize)
            let span = (max_doc - min_doc) as usize;
        Arc::new(move |segment, _chunk, _stream_metrics, _stats_prune_tree| {
                    ),
                    None,
    }
impl RowGroupDocsCollector for ConcurrencyWitnessCollector {
        .target_partitions(num_partitions)
    let pruner = Arc::new(PagePruner::new(
        .collect();
// Segment 0: 8 rows of `amazon` brand (prices 50..58).
        .await;
/// as SegmentFileInfo's, runs a SELECT over the whole table. Returns
    #[derive(Debug)]
                    max_collector_parallelism: 1,
    let schema = schema_opt.unwrap();
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    > = leaf_exprs
        .await;
            min_doc: i32,
}
            0 => "us-east",
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    ]);
    assert_eq!(rows, expected_for_five_segments());
        Field::new("brand", DataType::Utf8, false),
    let provider = Arc::new(IndexedTableProvider::new(IndexedTableConfig {
/// For RG1 (prices 40-70): AND subtree is pruned (price>100 fails).
    let col_idx = schema.index_of(col).expect("wide column");
    let tmp1 = write_segment("apple", 100, SEG1_ROWS);
    let mut w = ArrowWriter::try_new(tmp.reopen().unwrap(), schema, Some(props)).unwrap();
    // All 3 orderings of a nested OR that flatten differently.
    let mut leaf_exprs: Vec<Arc<dyn datafusion::physical_expr::PhysicalExpr>> = Vec::new();
        let mut offset = 0i64;
            rows: 16,
        let rows = run_wide_segments(clone_wide_specs(&specs), tree.clone(), np).await;
        .map(|(i, s)| (s.brand, i as i32))
                out[rel / 64] |= 1u64 << (rel % 64);
        },
    let tree = BoolNode::Or(vec![
    #[derive(Debug)]
            let ord = if brand.value(i) == "amazon" { 0 } else { 1 };
        price > 100 || region == "us-east" || qty > 5
        vec![
            row_groups: rgs,
            }
        ),
    struct AllDocs;
                .unwrap_or_default();
/// runs the per-chunk streams in parallel within one partition.
    };
    let rows = run_wide_segments_with_stats_pruning(specs, tree, 1).await;
            min_doc: i32,
        }
        for i in 0..parquet_meta.num_row_groups() {
    let regions: Vec<&str> = (0..rows)
    // Segment 0: no matches. Segment 1: docs {0, 4}.
                pred_wide_int("qty", Operator::Eq, 3),
        (4, "netflix".to_string(), 415),
    fn collect_packed_u64_bitset(
        store,
//!   emits multi-chunk partitions → `UnionExec + CoalescePartitionsExec`
                num_rows: n,
            max_rg_rows: 4,
                active.value(i),
    ]);
        cost_predicate: 1,
        pruning_predicates: Arc::new(pruning_predicates),
    assert_eq!(rows, expected);
/// `(writer_generation_inferred_from_brand, brand, price)` triples sorted so tests
    );
}
    let resolved = tree_arc.resolve(&per_leaf).unwrap();
    // Oracle: row matches if (price > 100) OR (region == "us-east") OR (qty > 5)
        emit_row_ids: false,
    }
            let n = parquet_meta.row_group(i).num_rows();
    // Collector: every doc in the segment matches (one-leaf trees then use
        let schema = schema.clone();
        vec![
        .filter_map(|expr| {
        BoolNode::Predicate(expr) => out.push(Arc::clone(expr)),
                BoolNode::And(vec![
        .collect();
    }
    // Factory produces a single-collector evaluator per chunk. The collector's
        };
    let schema = Arc::new(Schema::new(vec![
}
        let b = batch.unwrap();
        SegSpec {
        }
//! - Two segments in one shard (different content, same schema).
// and per-segment lifetime.
    );
//!   wrapper path in `QueryShardExec::execute`).
                qty.value(i),
                ),
        .map(|s| WideSegSpec {
        store_url,
fn expected_for_five_segments() -> Vec<(i32, String, i32)> {
        let mut rgs = Vec::new();
    let per_segment_matches = Arc::new(per_segment_matches);
                .unwrap();
            let n = parquet_meta.row_group(i).num_rows();
        &parquet_meta,
    // Build pruning predicates.
    };
                first_row: offset,
        std::thread::sleep(std::time::Duration::from_millis(25));
                    let c: Arc<dyn RowGroupDocsCollector> = Arc::new(AllDocs);
    assert!(
}
        }
            max_doc: i32,
        BoolNode::Collector { .. } => {}
        )
        },
    }];
    let specs = vec![
                    ),
            max_rg_rows: s.max_rg_rows,
        !spt.children[0].rg_can_match[0],
    // RG1 at absolute index 1: NOT pruned at root (OR is true).
/// A collector whose matching set is parameterised by writer_generation: it records
            let ord = *brand_to_ord.get(brand.value(i)).expect("known brand");
        sort_orders: vec![],
async fn two_segments_single_partition_exercises_union_coalesce_path() {
        ));
            base_price: 100,
/// Predicate is prunable by RG stats. The test verifies that rows matching
                pred_wide_int("qty", Operator::Gt, 5),
/// can produce multi-RG-per-segment layouts.
    }
    // Collector0 (inside pruned AND subtree) must have EMPTY bitmap.
                .cloned()
    let batch = RecordBatch::try_new(
            ]),
        let mut offset = 0i64;
        .iter()
    let schema = schema_opt.unwrap();
    let expected = vec![
        ],
            .enumerate()
        schema: schema.clone(),
    ];
        segments,
                    pred_wide_int("price", Operator::Gt, 100),
                &schema,
    rows: usize,
            matches: vec![0, 12, 24, 31],
        let rows = run_wide_segments(clone_wide_specs(&specs), tree.clone(), np).await;
            ]),
        schema: schema.clone(),
    brand: &'static str,
                Err(p) => prev = p,
        ) -> Result<CollectDocsResult, String> {
        datafusion::physical_expr::expressions::Literal::new(ScalarValue::Int32(Some(v))),
    rows
#[tokio::test(flavor = "multi_thread", worker_threads = 4)]
            brand: "apple",
        let price = (i as i32) * 10;
            parquet_size: size,
    let spt = StatsPruneTree::build_from_bool_node(
                .collect();
        schema: schema.clone(),
    // Assert: prefetch_rg for RG1 at offset index 1 — may or may not be pruned
    );
            ));
struct SegSpec {
        result_rg3.is_some(),
            rows: s.rows,
            base_price: 200,
        result_rg1.is_some(),
        let mut prev = self.max_in_flight.load(Ordering::SeqCst);
        BoolNode::Or(vec![
                    0,
                    stats_prune_tree: stats_prune_tree.cloned(),
            arrow_schema: meta.schema().clone(),
    assert_eq!(
        sort_fields: vec![],
        let price = (i as i32) * 10;
            BoolNode::And(vec![
            _ => "eu-west",
            let eval: Arc<dyn RowGroupBitsetSource> = Arc::new(
        };
        cost_collector: 10,
                    BoolNode::Collector { annotation_id: 1 },
        }
// ══════════════════════════════════════════════════════════════════════
                .collect();
                };
    let mut schema_opt: Option<SchemaRef> = None;
                    (i as i32, c)
            brand: "amazon",
        ]
    ctx.register_table("t", provider).unwrap();
    // Sanity-check the inverse: the cross-partition parallelism that
            vec![WideSegSpec {
        let object_path = object_store::path::Path::from(path.to_string_lossy().as_ref());
    // Collector0 is under AND with a predicate that fails for low-price RGs.
//! - `writer_generation != 0` propagation through collectors.
        max_collector_parallelism: 1,
        has_empty,
            // Infer writer_generation by brand for verification purposes.
    )
    out
        query_config: std::sync::Arc::new(qc),
#[tokio::test(flavor = "multi_thread", worker_threads = 2)]
    let factory: super::super::table_provider::EvaluatorFactory = {
        assert_eq!(rows, expected, "np={} failed", np);
            base_price: 300,
///   qtys: 0,1,2,3 | 4,5,6,0 | 1,2,3,4 | 5,6,0,1
        let brand = b.column(0).as_any().downcast_ref::<StringArray>().unwrap();
            base_price: 100,
    }));
                    .map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
        segments,
    // mixed up doc-ID spaces, results would differ.
    let store_url = datafusion::execution::object_store::ObjectStoreUrl::local_filesystem();
                .map(|pp| (Arc::as_ptr(expr) as *const () as usize, pp))
        .collect();
            matches: vec![],
