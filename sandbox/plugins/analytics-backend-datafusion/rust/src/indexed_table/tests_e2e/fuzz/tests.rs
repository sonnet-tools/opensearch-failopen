    run_fuzz(
    determinism: bool,
}
//!    c. Run both the oracle and the production pipeline.
    num_delegation: usize,
    .await;
}
    let master = master_seed();
/// `(correctness collector ∩ original_exprs)` set.
    run_fuzz("fuzz_null_heavy", 50, FixtureConfig::null_heavy).await;
#[tokio::test(flavor = "multi_thread")]
/// Shuffled column order: parquet file columns are in reversed order
async fn fuzz_shuffled_columns() {
#[tokio::test(flavor = "multi_thread")]
/// regardless of seed.
        2,
    .await;
/// over two different columns. Exercises the grid multi-column-OR
/// Run `iters` random iterations against a corpus built from `cfg_builder`.
//!    a. Derive a per-iteration seed from the master seed.
    )
#[tokio::test(flavor = "multi_thread")]
    for iter in 0..iters {
) {
/// Always-parallel collectors: `max_collector_parallelism = 4` so
/// int, wide int. Stresses page pruning + stats paths at both ends.
async fn fuzz_multi_column_or() {
/// `num_delegation` `DelegationPossible` leaves, wires a mock delegated-backend
}
/// range. Exercises the BitmapTree hint propagation path.
#[tokio::test(flavor = "multi_thread")]
async fn fuzz_misaligned_pages() {
/// where `original_expr` is TRUE. The AND-intersection is a no-op for correctness;
async fn run_fuzz(test_name: &str, iters: u64, cfg_builder: fn(u64) -> FixtureConfig) {
    let corpus_seed = derive_seed(master, &format!("{}_corpus", test_name), 0);
/// AND accumulator, then collectors get a tightened `collector_hint`
/// iteration is heavier.
}
/// Multi-column OR inside a single expression: ~30% of generated
        if let Err(e) = run_delegation_iteration(&corpus, &loaded, &dt, behavior).await {
async fn fuzz_all_null_columns() {
/// `prefetch_mask_buffer` and `PositionMap` in `finalize_batch`.
) {
    )
/// single grid cell inherits stats from different pages per column.
            run_iteration(&corpus, &loaded, &tree).await
#[tokio::test(flavor = "multi_thread")]
        FixtureConfig::parallel_collectors,
        };
/// collectors. Predicates evaluate first (sorted by cost), narrow the
    run_fuzz("fuzz_mid", 20, FixtureConfig::mid).await;
/// reprojection-by-name fix that fires when schemas have the same
    let corpus = build_corpus(cfg_builder(corpus_seed));
 * compatible open source license.
}
//! 1. Builds one `Corpus` per test (10k–50k rows; parquet file written once).
        FixtureConfig::concurrency,
/// Produces pages that are fully-null, fully-non-null, or mixed-null.
/// Misaligned per-column page layouts: dictionary encoding off + tight
};
        FixtureConfig::and_predicate_collector,
        let dt = generate_delegation_tree(&mut rng, &corpus, num_delegation);
/// Clustered nulls: each column's nulls form 256-row contiguous runs.
}
}
/// Delegation-passthrough: the mock delegated-backend returns *exactly* the rows
        FixtureConfig::concurrency,
    cfg_builder: fn(u64) -> FixtureConfig,
/// columns but in different order.
//!    b. Generate a random tree + collector match-set via `generate_tree`.
/// Driver for the two delegation tests: generates a SingleCollector tree with
    build_corpus, derive_seed, generate_tree, load_segment, master_seed, run_iteration,
    generate_delegation_tree, run_delegation_iteration, DelegatedBackendBehavior,
/// page byte budget so Utf8 columns flush far more often than Int32/
    run_fuzz("fuzz_single_row_group", 50, FixtureConfig::single_row_group).await;
async fn fuzz_block_granular_dense() {
}
/// compared to the table schema. Exercises the stream.rs
            run_iteration_twice(&corpus, &loaded, &tree).await
    run_delegation_fuzz(
 *
/// 50k rows, deeper trees (depth 6, fanout 6), more collectors.
//!
/// twice to detect non-determinism.
 * The OpenSearch Contributors require contributions made to
        }
        50,
        }
}
    run_fuzz("fuzz_empty_result", 50, FixtureConfig::empty_result).await;
/// Column-cardinality extremes: const Utf8, unique-per-row Utf8, narrow
/// backstop. Same multi-segment fixture as the passthrough variant.
    run_delegation_fuzz(
                test_name, iter, iter_seed, master, e, master, test_name,
/// proves the gate + intersection don't lose rows on the happy path.
async fn fuzz_clustered_nulls() {
/// Exercises the `PagePruner` grid null-count splitting rule
/// density. Auto strategy picks block-granular `min_skip_run` (selectivity
/// `current_mask` indexing.
}
        100,
        "fuzz_block_granular_dense",
}
async fn fuzz_batch_size_one() {
    run_fuzz(
//! Top-level randomized fuzz tests. Each test:
#[tokio::test(flavor = "multi_thread")]
    run_fuzz("fuzz_small", 100, FixtureConfig::small).await;
        let iter_seed = derive_seed(master, test_name, iter);
        50,
}
    }
/// Single row group: entire segment is one RG. No RG boundary
async fn fuzz_small() {
///
        "fuzz_delegation_sloppy",
/// Block-granular dense: 200k rows in 100k-row RGs with 50% collector
#[tokio::test(flavor = "multi_thread")]
#[tokio::test(flavor = "multi_thread")]
//! per-iteration seed, and the tree, so failures reproduce via
/// return TRUE on those columns.
    iters: u64,
#[tokio::test(flavor = "multi_thread")]
use rand::SeedableRng;
}
/// must filter out the extras. Proves the delegated-backend bitset is *advisory*
}
        let result = if determinism {
    )
/// Sloppy delegated backend: returns TRUE-rows + ~30% extras. Residual FilterExec
}
/// Concurrency stress: 4 segments × 8 partitions. Each iteration runs
    test_name: &str,
    )
/// Boolean. Exercises `PagePruner`'s common-grid code path where a
//! 2. Runs N random iterations against that corpus. Per iteration:
                 reproduce: INDEXED_E2E_SEED={:016x} cargo test {}",
#[tokio::test(flavor = "multi_thread")]
    }
            panic!(
    run_fuzz(
    run_fuzz("fuzz_multi_column_or", 50, FixtureConfig::multi_column_or).await;
#[tokio::test(flavor = "multi_thread")]
    run_fuzz_with(test_name, iters, cfg_builder, /*determinism=*/ false).await;
}
        if let Err(e) = result {
        let mut rng = StdRng::seed_from_u64(iter_seed);
    let corpus_seed = derive_seed(master, &format!("{}_corpus", test_name), 0);
#[tokio::test(flavor = "multi_thread")]
#[tokio::test(flavor = "multi_thread")]
/// — DataFusion's native predicate evaluation is the authoritative correctness
/*
        "fuzz_and_predicate_collector",
/// wide-selectivity queries and catches mask-alignment bugs between
/// heavy UNKNOWN propagation.
async fn run_fuzz_with(
    let loaded = load_segment(&corpus);
        FixtureConfig::concurrency,
/// All-null columns: `brand` and `qty` are 100% null. Exercises page
        let iter_seed = derive_seed(master, test_name, iter);
    run_fuzz("fuzz_all_null_columns", 50, FixtureConfig::all_null_columns).await;
    )
/// stats with absent min/max and `IS NULL` predicates that always
async fn fuzz_and_predicate_collector() {
        DelegatedBackendBehavior::Passthrough,
    )
                 reproduce: INDEXED_E2E_SEED={:016x} cargo test {}",
/// and empty-batch paths in the streaming pipeline.
        2,
use super::{
async fn fuzz_mid() {
/// collector keyed by annotation_id, and asserts the result equals the canonical
/// AND(Predicate, Collector) focused: shallow depth-2 trees with 4
        FixtureConfig::block_granular_dense,
    run_fuzz("fuzz_clustered_nulls", 50, FixtureConfig::clustered_nulls).await;
/// Uses `concurrency` (4 segments × 8 partitions) so segments after the first have
/// mask-slicing at every row boundary — catches off-by-one bugs in
    let master = master_seed();
        let tree = generate_tree(&mut rng, &corpus);
/// pruning path that DataFusion's `split_conjunction` discards.
//!
#[tokio::test(flavor = "multi_thread")]
/// Primary mixed-workload sweep; runs fewer iterations because each
 * this file be licensed under the Apache-2.0 license or a
        } else {
        25,
/// `rg.first_row != 0` — this is the regime where the peer-bitmap offset math
use rand::rngs::StdRng;
async fn fuzz_parallel_collectors() {
#[tokio::test(flavor = "multi_thread")]
/// batch_size=1: every row is its own batch. Stresses coalescer and
async fn fuzz_null_heavy() {
            panic!(
#[tokio::test(flavor = "multi_thread")]
        "fuzz_concurrency",
            );
async fn fuzz_delegation_sloppy() {
    behavior: DelegatedBackendBehavior,
async fn fuzz_cardinality_extremes() {
    )
                test_name, iter, iter_seed, master, e, master, test_name,
async fn fuzz_delegation_passthrough() {
    .await;
    run_fuzz(
        DelegatedBackendBehavior::Sloppy,
/// Exercises `min_skip_run` + `PositionMap`.
}
//!    d. Assert the doc-id sets match.
    .await;
        "fuzz_cardinality_extremes",
/// (`0 / page_row_count / unknown`) across all three branches.
#[tokio::test(flavor = "multi_thread")]
/// Empty-result stress: 0.1% collector density + single collector.
    cfg_builder: fn(u64) -> FixtureConfig,
        "fuzz_delegation_passthrough",
/// silently let an off-by-one in that arithmetic pass.
    run_fuzz("fuzz_misaligned_pages", 50, FixtureConfig::misaligned_pages).await;
async fn fuzz_single_row_group() {
        25,
    let corpus = build_corpus(cfg_builder(corpus_seed));
async fn run_delegation_fuzz(
};
    iters: u64,
#[tokio::test(flavor = "multi_thread")]
/// (> 1024 rows) survive coalescing. This is the production regime for
async fn fuzz_empty_result() {
    run_fuzz("fuzz_batch_size_one", 50, FixtureConfig::batch_size_one).await;
        /*determinism=*/ true,
    run_fuzz("fuzz_block_boundaries", 50, FixtureConfig::block_boundaries).await;
    for iter in 0..iters {
/// Most trees produce zero matching rows, exercising short-circuit
        let mut rng = StdRng::seed_from_u64(iter_seed);
                "delegation fuzz {} iter={} seed={:016x} master={:016x}: {}\n\
}
}
    .await;
                "fuzz {} iter={} seed={:016x} master={:016x}: {}\n\
 */
    run_fuzz_with(
    let loaded = load_segment(&corpus);
#[tokio::test(flavor = "multi_thread")]
    .await;
/// 50% null across every column. Exercises 3VL combinators under
    run_fuzz("fuzz_shuffled_columns", 50, FixtureConfig::shuffled_columns).await;
//! `INDEXED_E2E_SEED=<hex> cargo test <test_name>`.
async fn fuzz_concurrency() {
 * SPDX-License-Identifier: Apache-2.0
/// Primary correctness sweep.
/// Tight RG + page boundaries (16k rows, 1024 per RG, 64 per page,
/// `PrecomputedLeafCache` concurrent path is always exercised,
            );
        50,
    run_iteration_twice, FixtureConfig,
        25,
        "fuzz_parallel_collectors",
}
    test_name: &str,
async fn fuzz_block_boundaries() {
/// transitions in the streaming loop.
/// 10k rows, small trees (depth 3, fanout 3), 100 iterations.
/// (`min_doc - rg.first_row`) actually does work. A single-segment fixture would
/// very sparse Collector matches to produce long skip-runs).
        FixtureConfig::cardinality_extremes,
}
use super::delegation::{
}
    .await;
/// binary-op predicate leaves are wrapped as `BinaryExpr(Or, a<5, b>10)`
//! On failure the panic message includes the outer master seed, the
/// well above 3% threshold), and the large RGs ensure real skip runs
