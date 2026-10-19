    run_fuzz("fuzz_misaligned_pages", 50, FixtureConfig::misaligned_pages).await;
        25,
}
    run_fuzz(
/// silently let an off-by-one in that arithmetic pass.
/// 50% null across every column. Exercises 3VL combinators under
/// collectors. Predicates evaluate first (sorted by cost), narrow the
                test_name, iter, iter_seed, master, e, master, test_name,
    run_fuzz("fuzz_empty_result", 50, FixtureConfig::empty_result).await;
/// `current_mask` indexing.
                "delegation fuzz {} iter={} seed={:016x} master={:016x}: {}\n\
/// Empty-result stress: 0.1% collector density + single collector.
}
    run_fuzz("fuzz_shuffled_columns", 50, FixtureConfig::shuffled_columns).await;
/// `num_delegation` `DelegationPossible` leaves, wires a mock delegated-backend
) {
        "fuzz_cardinality_extremes",
/// `(correctness collector ∩ original_exprs)` set.
    let corpus_seed = derive_seed(master, &format!("{}_corpus", test_name), 0);
    test_name: &str,
async fn fuzz_clustered_nulls() {
        let mut rng = StdRng::seed_from_u64(iter_seed);
use rand::SeedableRng;
//!    a. Derive a per-iteration seed from the master seed.
//! 2. Runs N random iterations against that corpus. Per iteration:
/// must filter out the extras. Proves the delegated-backend bitset is *advisory*
/// transitions in the streaming loop.
    run_fuzz("fuzz_clustered_nulls", 50, FixtureConfig::clustered_nulls).await;
        if let Err(e) = run_delegation_iteration(&corpus, &loaded, &dt, behavior).await {
#[tokio::test(flavor = "multi_thread")]
/// where `original_expr` is TRUE. The AND-intersection is a no-op for correctness;
        50,
/// `rg.first_row != 0` — this is the regime where the peer-bitmap offset math
    .await;
/// backstop. Same multi-segment fixture as the passthrough variant.
#[tokio::test(flavor = "multi_thread")]
/// Delegation-passthrough: the mock delegated-backend returns *exactly* the rows
//!
    run_fuzz("fuzz_multi_column_or", 50, FixtureConfig::multi_column_or).await;
/// (`0 / page_row_count / unknown`) across all three branches.
#[tokio::test(flavor = "multi_thread")]
    )
/// AND(Predicate, Collector) focused: shallow depth-2 trees with 4
/// heavy UNKNOWN propagation.
    run_delegation_fuzz(
async fn fuzz_single_row_group() {
use super::delegation::{
//! On failure the panic message includes the outer master seed, the
#[tokio::test(flavor = "multi_thread")]
}
        FixtureConfig::concurrency,
//! 1. Builds one `Corpus` per test (10k–50k rows; parquet file written once).
//! `INDEXED_E2E_SEED=<hex> cargo test <test_name>`.
    )
    build_corpus, derive_seed, generate_tree, load_segment, master_seed, run_iteration,
#[tokio::test(flavor = "multi_thread")]
    )
async fn fuzz_misaligned_pages() {
async fn fuzz_small() {
        25,
    generate_delegation_tree, run_delegation_iteration, DelegatedBackendBehavior,
/// very sparse Collector matches to produce long skip-runs).
///
/// stats with absent min/max and `IS NULL` predicates that always
/// int, wide int. Stresses page pruning + stats paths at both ends.
#[tokio::test(flavor = "multi_thread")]
/// iteration is heavier.
        FixtureConfig::concurrency,
}
//!
    run_fuzz("fuzz_all_null_columns", 50, FixtureConfig::all_null_columns).await;
    let master = master_seed();
    .await;
                 reproduce: INDEXED_E2E_SEED={:016x} cargo test {}",
    iters: u64,
/// `prefetch_mask_buffer` and `PositionMap` in `finalize_batch`.
/// single grid cell inherits stats from different pages per column.
/// density. Auto strategy picks block-granular `min_skip_run` (selectivity
        DelegatedBackendBehavior::Sloppy,
        DelegatedBackendBehavior::Passthrough,
async fn fuzz_block_granular_dense() {
}
        let iter_seed = derive_seed(master, test_name, iter);
/// binary-op predicate leaves are wrapped as `BinaryExpr(Or, a<5, b>10)`
    let corpus = build_corpus(cfg_builder(corpus_seed));
}
}
        50,
async fn fuzz_all_null_columns() {
}
/// pruning path that DataFusion's `split_conjunction` discards.
/// collector keyed by annotation_id, and asserts the result equals the canonical
    let loaded = load_segment(&corpus);
/// Misaligned per-column page layouts: dictionary encoding off + tight
 * compatible open source license.
/// Multi-column OR inside a single expression: ~30% of generated
}
#[tokio::test(flavor = "multi_thread")]
/// Primary mixed-workload sweep; runs fewer iterations because each
        }
    let master = master_seed();
    run_fuzz_with(test_name, iters, cfg_builder, /*determinism=*/ false).await;
        "fuzz_concurrency",
#[tokio::test(flavor = "multi_thread")]
            run_iteration_twice(&corpus, &loaded, &tree).await
        2,
#[tokio::test(flavor = "multi_thread")]
}
/// reprojection-by-name fix that fires when schemas have the same
    }
/// regardless of seed.
    )
}
        let iter_seed = derive_seed(master, test_name, iter);
        100,
        FixtureConfig::block_granular_dense,
    }
    let corpus_seed = derive_seed(master, &format!("{}_corpus", test_name), 0);
        let result = if determinism {
/// return TRUE on those columns.
        2,
                test_name, iter, iter_seed, master, e, master, test_name,
    run_fuzz(
/// Most trees produce zero matching rows, exercising short-circuit
    .await;
//!    b. Generate a random tree + collector match-set via `generate_tree`.
        "fuzz_block_granular_dense",
/// Run `iters` random iterations against a corpus built from `cfg_builder`.
/// Always-parallel collectors: `max_collector_parallelism = 4` so
}
async fn fuzz_shuffled_columns() {
}
/// Concurrency stress: 4 segments × 8 partitions. Each iteration runs
/// — DataFusion's native predicate evaluation is the authoritative correctness
    cfg_builder: fn(u64) -> FixtureConfig,
/// AND accumulator, then collectors get a tightened `collector_hint`
        /*determinism=*/ true,
#[tokio::test(flavor = "multi_thread")]
        FixtureConfig::concurrency,
        25,
}
    for iter in 0..iters {
/// Shuffled column order: parquet file columns are in reversed order
                 reproduce: INDEXED_E2E_SEED={:016x} cargo test {}",
    run_fuzz(
/// Single row group: entire segment is one RG. No RG boundary
}
) {
/// Tight RG + page boundaries (16k rows, 1024 per RG, 64 per page,
    run_fuzz("fuzz_mid", 20, FixtureConfig::mid).await;
#[tokio::test(flavor = "multi_thread")]
/// Exercises `min_skip_run` + `PositionMap`.
        let mut rng = StdRng::seed_from_u64(iter_seed);
}
//!    c. Run both the oracle and the production pipeline.
async fn fuzz_delegation_passthrough() {
        };
#[tokio::test(flavor = "multi_thread")]
 * SPDX-License-Identifier: Apache-2.0
    )
    run_fuzz("fuzz_batch_size_one", 50, FixtureConfig::batch_size_one).await;
            panic!(
async fn fuzz_delegation_sloppy() {
    run_fuzz("fuzz_null_heavy", 50, FixtureConfig::null_heavy).await;
/// Clustered nulls: each column's nulls form 256-row contiguous runs.
async fn fuzz_and_predicate_collector() {
/// All-null columns: `brand` and `qty` are 100% null. Exercises page
/// twice to detect non-determinism.
    iters: u64,
async fn fuzz_concurrency() {
    .await;
        FixtureConfig::parallel_collectors,
            );
/// 50k rows, deeper trees (depth 6, fanout 6), more collectors.
        } else {
/// over two different columns. Exercises the grid multi-column-OR
    test_name: &str,
};
//!    d. Assert the doc-id sets match.
/// (> 1024 rows) survive coalescing. This is the production regime for
/// (`min_doc - rg.first_row`) actually does work. A single-segment fixture would
    let corpus = build_corpus(cfg_builder(corpus_seed));
        }
            panic!(
/// Primary correctness sweep.
async fn fuzz_empty_result() {
        let dt = generate_delegation_tree(&mut rng, &corpus, num_delegation);
    run_iteration_twice, FixtureConfig,
    cfg_builder: fn(u64) -> FixtureConfig,
async fn fuzz_mid() {
#[tokio::test(flavor = "multi_thread")]
/// and empty-batch paths in the streaming pipeline.
        "fuzz_delegation_passthrough",
        50,
}
#[tokio::test(flavor = "multi_thread")]
    .await;
#[tokio::test(flavor = "multi_thread")]
 * The OpenSearch Contributors require contributions made to
        "fuzz_parallel_collectors",
//! per-iteration seed, and the tree, so failures reproduce via
    run_fuzz("fuzz_block_boundaries", 50, FixtureConfig::block_boundaries).await;
/// Boolean. Exercises `PagePruner`'s common-grid code path where a
    .await;
/// Sloppy delegated backend: returns TRUE-rows + ~30% extras. Residual FilterExec
/// proves the gate + intersection don't lose rows on the happy path.
    )
        "fuzz_and_predicate_collector",
}
/*
async fn fuzz_parallel_collectors() {
async fn fuzz_block_boundaries() {
/// batch_size=1: every row is its own batch. Stresses coalescer and
    run_fuzz_with(
/// `PrecomputedLeafCache` concurrent path is always exercised,
use super::{
async fn fuzz_multi_column_or() {
/// compared to the table schema. Exercises the stream.rs
                "fuzz {} iter={} seed={:016x} master={:016x}: {}\n\
}
/// range. Exercises the BitmapTree hint propagation path.
    for iter in 0..iters {
    run_delegation_fuzz(
            run_iteration(&corpus, &loaded, &tree).await
/// mask-slicing at every row boundary — catches off-by-one bugs in
async fn run_delegation_fuzz(
        FixtureConfig::cardinality_extremes,
/// 10k rows, small trees (depth 3, fanout 3), 100 iterations.
    )
    .await;
        if let Err(e) = result {
/// well above 3% threshold), and the large RGs ensure real skip runs
 *
/// page byte budget so Utf8 columns flush far more often than Int32/
};
#[tokio::test(flavor = "multi_thread")]
}
#[tokio::test(flavor = "multi_thread")]
/// columns but in different order.
/// wide-selectivity queries and catches mask-alignment bugs between
#[tokio::test(flavor = "multi_thread")]
use rand::rngs::StdRng;
    run_fuzz(
 */
            );
#[tokio::test(flavor = "multi_thread")]
//! Top-level randomized fuzz tests. Each test:
/// Exercises the `PagePruner` grid null-count splitting rule
/// Produces pages that are fully-null, fully-non-null, or mixed-null.
async fn fuzz_cardinality_extremes() {
/// Column-cardinality extremes: const Utf8, unique-per-row Utf8, narrow
}
        let tree = generate_tree(&mut rng, &corpus);
/// Uses `concurrency` (4 segments × 8 partitions) so segments after the first have
async fn run_fuzz(test_name: &str, iters: u64, cfg_builder: fn(u64) -> FixtureConfig) {
    let loaded = load_segment(&corpus);
    determinism: bool,
    num_delegation: usize,
        "fuzz_delegation_sloppy",
    run_fuzz("fuzz_small", 100, FixtureConfig::small).await;
    run_fuzz("fuzz_single_row_group", 50, FixtureConfig::single_row_group).await;
/// Block-granular dense: 200k rows in 100k-row RGs with 50% collector
        FixtureConfig::and_predicate_collector,
async fn run_fuzz_with(
async fn fuzz_null_heavy() {
async fn fuzz_batch_size_one() {
}
 * this file be licensed under the Apache-2.0 license or a
    behavior: DelegatedBackendBehavior,
/// Driver for the two delegation tests: generates a SingleCollector tree with
