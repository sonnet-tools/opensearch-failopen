            num_rows: 10_000,
    ///   extremely tight and almost every literal prunes.
            ColumnKind::Int64 {
 * this file be licensed under the Apache-2.0 license or a
            columns: default_columns(),
    TimestampNanos { min: i64, max: i64 },
            batch_size: None,
    /// `BinaryExpr(Or, pred(a), pred(b))`. This is the predicate
            seed,
    /// discards at the top level but the grid pruner handles.
            null_pct_overrides: overrides,
    /// - `wide_int`: Int32 across full range — opposite end.
    ]
            rows_per_page: 256,
/// Shape of the fixture. All parameters are deterministic given the
    pub fn shuffled_columns(seed: u64) -> Self {
            rows_per_row_group: 1_024,
    pub target_partitions: usize,
            collector_density: 0.05,
    /// Columns in order. `columns[0]` becomes the first parquet field.
            rows_per_row_group: 2_048,
            null_pct_overrides: std::collections::HashMap::new(),
            rows_per_row_group: 1_024,
        }
    /// Override `min_skip_run_default` in the query config. When `Some`,
    /// path where each grid cell inherits stats from a different
            tree_max_depth: 5,
    /// assumptions and exercises `UnionExec + CoalescePartitionsExec`
            rows_per_row_group: 2_048,
    /// at different row counts. Exercises the `PagePruner` common-grid
    }
        }
            phantom_columns: Vec::new(),
        Self {
}
    Float64 { min: f64, max: f64 },
    /// Maximum depth of generated trees. A depth-0 tree is a single
            columns: default_columns(),
        Self {
    /// row groups the clusters straddle RG boundaries as well.
            rows_per_page: 512,
            rows_per_page: 256,
            null_pct_overrides: std::collections::HashMap::new(),
            seed,
    /// Null-heavy: ~50% null on every column, exercises 3VL everywhere.
            tree_max_fanout: 5,
    /// leaf is backed by a random RG-relative doc-id set produced at
    /// Small fixture for `fuzz_small`: 10k rows, handful of RGs, a few
            batch_size: None,
            tree_max_depth: 5,
    }
            null_strategy: NullStrategy::Uniform,
    /// AND(Predicate, Collector) focused: shallow trees (depth 2) with
            force_misaligned_pages: false,
    pub fn cardinality_extremes(seed: u64) -> Self {
    /// `rows_per_page` is reached or the configured byte budget is hit,
            num_collector_leaves: 2,
        Self {
    /// Multi-column OR inside a single expression: ~30% of generated
                (
                (
            target_partitions: 2,
//! Fuzz fixture configuration — controls size, shape, and cardinality of
    pub fn multi_column_or(seed: u64) -> Self {
            multi_column_or_pct: 0.0,
    }
                ("price".to_string(), ColumnKind::Int32 { min: 0, max: 1000 }),
 * compatible open source license.
            },
                    },
            ColumnKind::Utf8 {
            multi_column_or_pct: 0.0,
            max_collector_parallelism: None,
                max: 1_735_689_600_000_000_000, // 2025-01-01T00:00:00Z
            null_strategy: NullStrategy::Uniform,
            tree_max_depth: 5,
            null_pct_overrides: std::collections::HashMap::new(),
            max_collector_parallelism: None,
            force_misaligned_pages: false,
            seed,
            min_skip_run_override: None,
/// Strategy for placing nulls within a generated column.
    /// the `PagePruner` harder.
            "score".to_string(),
        ),
    /// skips — no need for 100k+ row RGs.
    /// Probability (0.0..=1.0) that a generated binary-op predicate
    /// either fully-null or fully-non-null (exercises the
            null_pct: 0.05,
    pub seed: u64,
            min_skip_run_override: None,
            rows_per_row_group: 2_048,
            rows_per_page: 1_024,
            null_strategy: NullStrategy::Uniform,
    /// - `const_str`: 1 distinct Utf8 value (whole column identical).
            multi_column_or_pct: 0.0,
    /// disabled and `data_page_size_limit` is set to a very small byte
    /// Int64. Same.
            num_segments: 1,
        Self {
            seed,
 * The OpenSearch Contributors require contributions made to
    /// default (`[1, 1, 2, 4][seed % 4]`).
    pub fn all_null_columns(seed: u64) -> Self {
            ColumnKind::Utf8 {
                min: 0.0,
                    },
    /// shape DataFusion's `PruningPredicate::split_conjunction`
    /// regime where the RowSelection has real skip runs and
    /// Null-generation strategy. `Uniform` uses `null_pct` as an
            null_pct: 0.1,
            num_rows: 20_000,
fn default_columns() -> Vec<(String, ColumnKind)> {
    /// the harness sets this value instead of the default 1024. Use a
    /// parquet files. Simulates schema drift / schema evolution. Empty
            null_strategy: NullStrategy::Uniform,
            tree_max_fanout: 6,
            seed,
}
    /// Clustered nulls: each column's nulls form contiguous runs of
    /// to produce different page boundaries for each column (achieved
    /// across all three branches.
    /// ones). Exercises the `PagePruner` common-grid code path where
    pub force_misaligned_pages: bool,
                min: 0,
            "brand".to_string(),
            null_pct_overrides: std::collections::HashMap::new(),
            tree_max_depth: 5,
            batch_size: None,
            null_strategy: NullStrategy::Uniform,
            min_skip_run_override: None,
            max_collector_parallelism: None,
            rows_per_page: 256,
            tree_max_depth: 4,
            phantom_columns: Vec::new(),
        }
            batch_size: None,
            phantom_columns: Vec::new(),
    /// data. Flushes out any cross-partition / cross-segment ordering
            num_rows: 10_000,
            num_rows: 10_000,
    pub rows_per_row_group: usize,
    /// boundary. Catches off-by-one bugs in `current_mask` indexing.
            rows_per_row_group: 8_000,
        }
 * SPDX-License-Identifier: Apache-2.0
            num_collector_leaves: 3,
        (
    /// cluster_len < rows_per_page, pages contain null/non-null
            num_collector_leaves: 4,
    /// null_count ∈ {0, page_row_count} fast paths). With off-boundary
            batch_size: None,
            collector_density: 0.05,
            null_pct_overrides: std::collections::HashMap::new(),
    pub fn clustered_nulls(seed: u64) -> Self {
    /// Global doc-id is the row's index in the corpus, preserved across
            "created_day".to_string(),
            rows_per_row_group: 2_048,
        ),
            tree_max_depth: 4,
    }
        Self {
    /// independent per-row Bernoulli; `Clustered` inserts contiguous
            "qty".to_string(),
            target_partitions: 1,
    pub max_collector_parallelism: Option<usize>,
    /// segments via monotonically increasing `segment.first_row`.
            collector_density: 0.05,
    /// batch_size=1: stresses coalescer and mask-slicing at every row
            ],
            multi_column_or_pct: 0.0,
            multi_column_or_pct: 0.0,
            multi_column_or_pct: 0.0,
            multi_column_or_pct: 0.0,
        Self {
                ("active".to_string(), ColumnKind::Boolean),
            null_pct: 0.1,
            num_collector_leaves: 4,
    /// Empty-result stress: very low collector density (0.1%) and only
    /// Block-boundary focus: cuts RGs + pages at tight multiples so
    /// Override max_collector_parallelism. `None` uses the harness
            columns: default_columns(),
        ),
            phantom_columns: Vec::new(),
            columns: default_columns(),
    }
            num_rows: 10_240,
    Int32 { min: i32, max: i32 },
            min_skip_run_override: None,
            columns: default_columns(),
                ),
    pub tree_max_fanout: usize,
            min_skip_run_override: None,
    }
            rows_per_page: 256,
    /// Exercises the grid multi-column-OR pruning path that
    /// `cluster_len` rows long. With cluster_len ≥ rows_per_page,
    }
    /// order. Exercises the stream.rs reprojection-by-name path .
            collector_density: 0.1,
                        min: i32::MIN / 2,
            seed,
            max_collector_parallelism: None,
    /// Per-column null probability in `0.0..=1.0`.
            seed,
            },
            batch_size: None,
            multi_column_or_pct: 0.0,
    /// predicates that always return TRUE on those columns.
            null_pct_overrides: std::collections::HashMap::new(),
            force_misaligned_pages: false,
        (
            columns: default_columns(),
    /// Alternating clusters of nulls and non-nulls, each cluster
                    ColumnKind::Utf8 {
            batch_size: None,
            },
    /// Shuffled columns: same as `small` but columns are in reversed
            tree_max_depth: 2,
            target_partitions: 1,
    /// grid cells inherit stats from different pages per column.
            null_pct_overrides: std::collections::HashMap::new(),
            collector_density: 0.03,
            tree_max_fanout: 4,
    pub fn misaligned_pages(seed: u64) -> Self {
}
            max_collector_parallelism: None,
    /// Block-granular dense: exercises the block-granular `min_skip_run`
            ColumnKind::Date32 {
            force_misaligned_pages: false,
        Self {
        ),
            tree_max_fanout: 2,
            phantom_columns: Vec::new(),
            num_segments: 1,
/// has. Names match what tree-gen expects.
            phantom_columns: Vec::new(),
    /// with a consistent null density; no page is ever fully-null or
    }
            seed,
                    ColumnKind::Utf8 {
            min_skip_run_override: None,
            rows_per_page: 512,
    /// in most presets.
        ("active".to_string(), ColumnKind::Boolean),
            num_segments: 1,
            num_collector_leaves: 3,
    /// containing page per column.
        Self {
            tree_max_depth: 5,
            // Row-count limit well above what byte-budget will actually
    pub phantom_columns: Vec<(String, ColumnKind)>,
        (
    pub fn and_predicate_collector(seed: u64) -> Self {
    pub collector_density: f64,
    }
/// float cmp, bool eq + 3VL null handling everywhere).
    pub fn block_boundaries(seed: u64) -> Self {
            max_collector_parallelism: None,
        }
            collector_density: 0.01, // very sparse → long skip runs
            rows_per_row_group: 2_048,
            null_pct: 0.4, // average ~40% nulls, but clustered
            collector_density: 0.05,
            batch_size: None,
            seed,
            tree_max_depth: 4,
            tree_max_depth: 4,
    /// Utf8. Generated via a distinct-values pool; controls cardinality.
            null_pct: 0.1,
            target_partitions: 1,
        (
        ),
    /// Writer's page-size limit. Parquet cuts a page when either
        }
            target_partitions: 8,
#[derive(Debug, Clone, Copy)]
                    "wide_int".to_string(),
    /// different columns, rather than a single-column predicate.
            // allow, so byte budget dominates.
pub(in crate::indexed_table::tests_e2e) struct FixtureConfig {
                        max_len: 8,
        (
            rows_per_row_group: 100_000,
            target_partitions: 1,
            null_pct: 0.1,
pub(in crate::indexed_table::tests_e2e) enum ColumnKind {
            collector_density: 0.05,
#[derive(Debug, Clone)]
            seed,
            rows_per_row_group: 2_048,
            target_partitions: 4,
                max: 20_454,
            null_strategy: NullStrategy::Uniform,
    pub num_collector_leaves: usize,
            tree_max_fanout: 5,
    /// exercising the block-granular mask-alignment path.
                max_len: 8,
            num_segments: 2,
    pub fn single_row_group(seed: u64) -> Self {
            rows_per_row_group: 2_048,
    pub num_segments: usize,
            batch_size: None,
            tree_max_fanout: 5,
            null_pct: 0.1,
    /// `current_mask` must be built through `PositionMap` (not the
            tree_max_fanout: 4,
            columns: default_columns(),
            tree_max_fanout: 5,
    /// mixed blocks (forcing grid cells that split pages across the
    /// mixed-null, exercising the grid null-count splitting rule
                    },
/*
            num_collector_leaves: 3,
            null_pct: 0.1,
            seed,
                num_distinct: 3,
        Self {
            multi_column_or_pct: 0.3,
        Self {
            tree_max_depth: 2,
    /// Boolean.
            null_pct_overrides: std::collections::HashMap::new(),
            num_segments: 3,
            },
            // (256) + offset, so some pages span the null→non-null
                ("tiny_int".to_string(), ColumnKind::Int32 { min: 0, max: 2 }),
            columns: default_columns(),
/// purpose — the same five cover every Predicate code path our
            collector_density: 0.05,
    }
            null_pct_overrides: std::collections::HashMap::new(),
            multi_column_or_pct: 0.0,
            null_pct_overrides: std::collections::HashMap::new(),
            force_misaligned_pages: false,
            min_skip_run_override: None,
    /// Master seed for this fixture. Drives corpus and tree generation.
                        max_len: 4,
            target_partitions: 1,
    /// Number of segments (parquet files). Rows are split round-robin-ish
//! fixture; the corpus is shared, the trees vary per iteration.
                max_len: 8,
    /// 1 collector leaf. Most trees produce zero matching rows,
            null_strategy: NullStrategy::Uniform,
    pub fn parallel_collectors(seed: u64) -> Self {
            columns: default_columns(),
//!
    }
            num_segments: 1,
            null_strategy: NullStrategy::Uniform,
 *
            phantom_columns: Vec::new(),
            collector_density: 0.05,
    }
            columns: cols,
    /// more RGs, more pages.
    /// cluster boundary).
            tree_max_fanout: 4,
            force_misaligned_pages: false,
    Int64 { min: i64, max: i64 },
            ColumnKind::Float64 {
            phantom_columns: Vec::new(),
            force_misaligned_pages: false,
            rows_per_page: 256,
            num_collector_leaves: 3,
    /// *misaligned* per-column page layouts: dictionary encoding is
            columns: default_columns(),
                // keep one of each common type for tree-gen to also have choices
            tree_max_fanout: 5,
            multi_column_or_pct: 0.0,
    pub min_skip_run_override: Option<usize>,
            rows_per_row_group: 2_048,
        }
        overrides.insert("qty".to_string(), 1.0);
    pub fn mid(seed: u64) -> Self {
    /// the global `null_pct` for that column. Columns not in the map
            null_pct_overrides: std::collections::HashMap::new(),
            batch_size: None,
    /// `PruningPredicate::split_conjunction` discards in DataFusion.
    /// Density of each Collector leaf's matching set, expressed as a
    /// All-null columns: `brand` and `qty` are 100% null, others at
        let mut cols = default_columns();
    /// Date32. Days since epoch; generated from a `[min, max)` range.
    /// entire segment is one RG. No RG boundary transitions in the
    /// collector_hint path — predicates evaluate first (cheap), narrow
                num_distinct: 8,
            max_collector_parallelism: None,
                (
            num_collector_leaves: 2,
                        max: i32::MAX / 2,
            "ts".to_string(),
            max_collector_parallelism: None,
            multi_column_or_pct: 0.0,
impl FixtureConfig {
            force_misaligned_pages: false,
    /// streaming loop.
            num_rows: 8_000,
            num_rows: 10_000,
            null_strategy: NullStrategy::Uniform,
    /// `CoalescePartitionsExec` wrapper path in IndexedExec.
    }
    pub batch_size: Option<usize>,
            rows_per_page: 64,
            num_segments: 2,
            num_segments: 4,
                min: 1_704_067_200_000_000_000, // 2024-01-01T00:00:00Z
            null_strategy: NullStrategy::Uniform,
    pub rows_per_page: usize,
            seed,
            num_rows: 16_384,
            rows_per_page: 4_096,
                    ColumnKind::Float64 {
            columns: default_columns(),
    /// 10%. Exercises page stats with absent min/max and `IS NULL`
            collector_density: 0.05,
            max_collector_parallelism: None,
    /// leaf; depth-1 allows one layer of connectives; etc.
            num_segments: 1,
            tree_max_depth: 4,
            num_rows: 10_000,
    ///   different — page stats min == max per row, pruning rarely
            seed,
            target_partitions: 1,
            max_collector_parallelism: None,
            tree_max_depth: 5,
        }
            rows_per_page: 256,
            min_skip_run_override: None,
            num_rows: 50_000,
        }
            tree_max_fanout: 5,
            target_partitions: 1,
    /// page pruning + stats paths.
            num_rows: 10_000,
        Self {
            force_misaligned_pages: false,
                        max: 100.0,
            num_collector_leaves: 1,
        }
    /// Maximum fanout at each AND / OR node.
            collector_density: 0.05,
    /// fraction of `num_rows`. 0.01 = 1% of rows match that collector.
            collector_density: 0.50,
            max_collector_parallelism: Some(4),
        Self {
        // epoch 1970-01-01 = ~18262..=20454.
        (
        cols.reverse();
    /// Mid-size fixture for broader correctness coverage: 50k rows,
            num_segments: 1,
            tree_max_depth: 6,
            null_pct_overrides: std::collections::HashMap::new(),
            "status".to_string(),
            phantom_columns: Vec::new(),
    /// even small gaps between the 10% candidate matches produce real
    Uniform,
            min_skip_run_override: None,
    /// Misaligned per-column page layouts. Forces the parquet writer
            seed,
        }
 */
            target_partitions: 1,
            phantom_columns: Vec::new(),
    pub columns: Vec<(String, ColumnKind)>,
    /// exercising short-circuit and empty-batch paths.
    /// Timestamp(Nanosecond, None). Nanoseconds since epoch; generated
    /// Target DataFusion partitions. Values > 1 exercise the
    /// Concurrency stress: 8 partitions × 4 segments with mid-size
    Utf8 { num_distinct: usize, max_len: usize },
        Self {
/// Default column mix — covers every Predicate code path our evaluator
            min_skip_run_override: Some(4),
    /// Per-row Bernoulli with probability `null_pct`. Produces pages
            },
            null_strategy: NullStrategy::Uniform,
            null_pct: 0.1,
            null_pct: 0.15,
    ///   helps.
            tree_max_depth: 5,
    /// byte budget so wide-value columns flush more often than narrow
    pub fn small(seed: u64) -> Self {
                    "const_str".to_string(),
            force_misaligned_pages: false,
            phantom_columns: Vec::new(),
            batch_size: None,
            num_collector_leaves: 3,
            num_rows: 10_000,
                ),
            force_misaligned_pages: false,
            min_skip_run_override: None,
    /// zero-copy `prefetch_mask_buffer` fast path). Uses small data
            multi_column_or_pct: 0.0,
            columns: default_columns(),
        let mut overrides = std::collections::HashMap::new();
                    ColumnKind::Int32 {
            seed,
            rows_per_page: 256,
            target_partitions: 2,
    /// (10k rows, 2k RGs) but sets `min_skip_run_default = 4` so that
/// produce the same corpus + same trees.
    /// Float64. Generated from a `[min, max)` range.
            force_misaligned_pages: false,
                        num_distinct: num_rows,
            null_pct: 0.1,
            num_segments: 1,
    /// Number of Collector leaves the tree generator may emit. Each
        Self {
    pub fn empty_result(seed: u64) -> Self {
    /// small value (e.g. 4) to force real skip runs in small RGs,
            num_segments: 1,
    Date32 { min: i32, max: i32 },
    /// across segments; each segment becomes its own `SegmentFileInfo`.
            num_collector_leaves: 3,
    /// predicate-generation and the pruner, but do NOT exist in the
    pub fn null_heavy(seed: u64) -> Self {
    pub fn block_granular_dense(seed: u64) -> Self {
            rows_per_row_group: 4_096,
    /// the accumulator, then collectors get a tightened range.
            multi_column_or_pct: 0.0,
            null_strategy: NullStrategy::Uniform,
            batch_size: None,
pub(in crate::indexed_table::tests_e2e) enum NullStrategy {
            num_rows: 10_000,
            null_pct_overrides: std::collections::HashMap::new(),
            null_pct_overrides: std::collections::HashMap::new(),
    /// Override batch_size for the DataFusion query config. `None` uses
            min_skip_run_override: None,
            phantom_columns: Vec::new(),
            min_skip_run_override: None,
            },
        }
    pub fn batch_size_one(seed: u64) -> Self {
            collector_density: 0.001,
    pub tree_max_depth: u32,
    /// columns, moderate null rate.
            tree_max_depth: 5,
            seed,
    /// Cardinality extremes: mix of degenerate column shapes to stress
    /// produces pages that are fully-null, fully-non-null, or
                    "unique_str".to_string(),
    /// whichever is first. Smaller values produce more pages, exercising
            num_segments: 1,
            columns: default_columns(),
        ),
    pub null_pct: f64,
    vec![
            min_skip_run_override: None,
            multi_column_or_pct: 0.0,
    /// `PrecomputedLeafCache` concurrent path is always exercised.
    pub num_rows: usize,
            num_segments: 2,
            batch_size: None,
        }
            rows_per_page: 512,
                        min: 0.0,
            collector_density: 0.05,
                max: 10_000,
            num_segments: 1,
            phantom_columns: Vec::new(),
        ("price".to_string(), ColumnKind::Int32 { min: 0, max: 1000 }),
        }
        overrides.insert("brand".to_string(), 1.0);
    }
        }
    /// Per-column null probability overrides. When non-empty, the
            null_pct: 0.1,
    Clustered { cluster_len: usize },
            num_collector_leaves: 2,
            // RG boundary (2_048) is not a multiple of cluster length
            rows_per_row_group: 2_048,
    /// the harness default (`[128, 1024, 8192][seed % 3]`).
            columns: default_columns(),
    /// binary-op predicate leaves are wrapped as
            force_misaligned_pages: false,
            tree_max_fanout: 5,
            num_collector_leaves: 4,
    /// with realistic fan-out. Each iteration is run TWICE (via
            rows_per_row_group: 2_048,
}
            collector_density: 0.05,
            num_rows: 5_000,
            rows_per_page: 256,
            null_strategy: NullStrategy::Uniform,
            num_collector_leaves: 3,
/// Kinds of columns the corpus generator can produce. Kept narrow on
    pub null_pct_overrides: std::collections::HashMap<String, f64>,
                    },
            min_skip_run_override: None,
            batch_size: None,
            target_partitions: 1,
            max_collector_parallelism: None,
    }
    /// Max row-group size for the parquet writer. The writer will cut an
            target_partitions: 1,
            phantom_columns: Vec::new(),
            null_pct: 0.1,
            rows_per_row_group: 1_024,
    /// When `true`, the parquet writer is configured to produce
        // Timestamp in 2024 calendar year: ns since epoch.
            min_skip_run_override: None,
    Boolean,
    /// 256 rows. With `rows_per_page = 256` (default), pages are
    /// `PositionMap` and `min_skip_run` math gets stressed.
            tree_max_depth: 5,
            force_misaligned_pages: false,
            seed,
            max_collector_parallelism: None,
    /// - `unique_str`: `num_distinct = num_rows` so every value is
    /// Single row group: `rows_per_row_group >= num_rows` so the
//! test fuzz loop then generates many random trees against the same
            num_rows: 10_000,
    /// entire pages are fully-null or fully-non-null. With
        // Date32 values in roughly [2020-01-01, 2025-12-31]: days since
            columns: default_columns(),
    /// by disabling dictionary encoding and tightening the per-page
            max_collector_parallelism: None,
                max: 100.0,
            target_partitions: 1,
    /// leaf is wrapped as `BinaryExpr(Or, pred(a), pred(b))` over two
        }
    /// - `tiny_int`: Int32 with range `[0, 2)` so page min/max are
            batch_size: None,
            target_partitions: 1,
    /// Always-parallel collectors: `max_collector_parallelism = 4` so
            force_misaligned_pages: false,
            ColumnKind::TimestampNanos {
    pub multi_column_or_pct: f64,
            batch_size: Some(1),
            columns: vec![
    }
                    "score".to_string(),
    /// corpus-gen time so the oracle can mirror it exactly.
            tree_max_fanout: 4,
                (
    /// Int32. Generated from a `[min, max)` value range.
            null_pct: 0.5,
    /// fully-non-null unless `null_pct` is exactly 0 or 1.
            num_rows,
        Self {
            max_collector_parallelism: None,
            force_misaligned_pages: true,
            num_rows: 10_000,
            phantom_columns: Vec::new(),
            max_collector_parallelism: None,
    pub null_strategy: NullStrategy,
            batch_size: None,
            num_segments: 1,
            target_partitions: 1,
            null_strategy: NullStrategy::Uniform,
            phantom_columns: Vec::new(),
    /// Total row count across the fixture. 10_000..=50_000 for our suite.
            rows_per_row_group: 2_048,
            tree_max_fanout: 4,
    /// List of column names that appear in the Arrow schema handed to
            tree_max_fanout: 5,
        }
    /// corpus generator uses `null_pct_overrides[col_name]` instead of
    /// fall back to `null_pct`.
    /// RGs and exercise per-RG boundaries harder.
            null_pct_overrides: std::collections::HashMap::new(),
            // transition and hit the "unknown" grid-cell branch.
        Self {
            tree_max_fanout: 4,
            min_skip_run_override: None,
            num_collector_leaves: 1,
            num_segments: 1,
            tree_max_fanout: 5,
            multi_column_or_pct: 0.0,
    pub fn concurrency(seed: u64) -> Self {
    /// null runs of a configured length. The clustered strategy
    }
}
        Self {
            num_collector_leaves: 4,
    /// high collector count. Exercises the BitmapTree AND-branch
            multi_column_or_pct: 0.0,
//! One `FixtureConfig` → one parquet file written once per test. Each
            null_pct_overrides: std::collections::HashMap::new(),
//! the generated corpus.
            num_collector_leaves: 3,
            null_strategy: NullStrategy::Uniform,
        let num_rows = 10_000;
    /// from a `[min, max)` range.
            collector_density: 0.05,
/// `seed`; two `FixtureConfig`s with the same seed + same fields
            null_strategy: NullStrategy::Clustered { cluster_len: 256 },
    /// RG every `rows_per_row_group` rows; smaller values produce more
            phantom_columns: Vec::new(),
                ),
            null_pct: 0.1,
            rows_per_page: 256,
            max_collector_parallelism: None,
    /// budget, so columns with different per-value widths flush pages
            rows_per_page: 256,
            null_pct: 0.1,
    /// `run_iteration_twice`) to detect non-determinism across runs.
                ),
                        num_distinct: 1,
/// evaluator needs to exercise (string eq/in, int cmp, int64 cmp,
#[derive(Debug, Clone, Copy)]
            null_strategy: NullStrategy::Uniform,
            null_pct: 0.1,
                min: 18_262,
            rows_per_page: 512,
            force_misaligned_pages: false,
