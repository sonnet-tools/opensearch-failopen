    /// the harness sets this value instead of the default 1024. Use a
    /// the accumulator, then collectors get a tightened range.
            force_misaligned_pages: true,
    /// Master seed for this fixture. Drives corpus and tree generation.
            "ts".to_string(),
    pub fn parallel_collectors(seed: u64) -> Self {
            phantom_columns: Vec::new(),
    /// independent per-row Bernoulli; `Clustered` inserts contiguous
            batch_size: None,
    /// boundary. Catches off-by-one bugs in `current_mask` indexing.
            num_segments: 1,
            rows_per_page: 256,
            tree_max_depth: 5,
    /// `BinaryExpr(Or, pred(a), pred(b))`. This is the predicate
            columns: default_columns(),
            min_skip_run_override: None,
                        max: 100.0,
            multi_column_or_pct: 0.0,
    /// RGs and exercise per-RG boundaries harder.
            phantom_columns: Vec::new(),
    pub fn block_boundaries(seed: u64) -> Self {
            collector_density: 0.50,
/// evaluator needs to exercise (string eq/in, int cmp, int64 cmp,
            multi_column_or_pct: 0.0,
    /// small value (e.g. 4) to force real skip runs in small RGs,
            min_skip_run_override: None,
            rows_per_row_group: 2_048,
            null_pct_overrides: std::collections::HashMap::new(),
impl FixtureConfig {
            num_segments: 1,
            force_misaligned_pages: false,
            target_partitions: 1,
        (
            force_misaligned_pages: false,
            min_skip_run_override: None,
            force_misaligned_pages: false,
        Self {
    pub multi_column_or_pct: f64,
}
    /// ones). Exercises the `PagePruner` common-grid code path where
        Self {
pub(in crate::indexed_table::tests_e2e) enum NullStrategy {
            // Row-count limit well above what byte-budget will actually
    Boolean,
    /// Exercises the grid multi-column-OR pruning path that
        (
            min_skip_run_override: Some(4),
            batch_size: Some(1),
/// produce the same corpus + same trees.
    /// collector_hint path — predicates evaluate first (cheap), narrow
            columns: default_columns(),
            target_partitions: 1,
 *
            columns: default_columns(),
            tree_max_depth: 5,
                max_len: 8,
                    },
            null_pct: 0.1,
            force_misaligned_pages: false,
    }
            seed,
                ("tiny_int".to_string(), ColumnKind::Int32 { min: 0, max: 2 }),
    }
pub(in crate::indexed_table::tests_e2e) struct FixtureConfig {
            tree_max_depth: 4,
    pub tree_max_fanout: usize,
    }
        }
                ("active".to_string(), ColumnKind::Boolean),
        overrides.insert("brand".to_string(), 1.0);
            columns: default_columns(),
    /// 1 collector leaf. Most trees produce zero matching rows,
            min_skip_run_override: None,
    pub phantom_columns: Vec<(String, ColumnKind)>,
            target_partitions: 2,
            seed,
    pub fn clustered_nulls(seed: u64) -> Self {
            },
    /// at different row counts. Exercises the `PagePruner` common-grid
    }
            null_strategy: NullStrategy::Uniform,
        ),
            rows_per_row_group: 2_048,
    /// fraction of `num_rows`. 0.01 = 1% of rows match that collector.
            num_collector_leaves: 2,
        Self {
        Self {
            num_rows: 5_000,
    pub fn small(seed: u64) -> Self {
            num_rows: 10_000,
            multi_column_or_pct: 0.0,
            rows_per_page: 4_096,
            ColumnKind::TimestampNanos {
    /// containing page per column.
                    ColumnKind::Utf8 {
    /// binary-op predicate leaves are wrapped as
    /// `PositionMap` and `min_skip_run` math gets stressed.
            null_pct: 0.1,
            tree_max_fanout: 5,
            collector_density: 0.001,
            "brand".to_string(),
//! the generated corpus.
            rows_per_page: 256,
            collector_density: 0.05,
 * The OpenSearch Contributors require contributions made to
    /// 256 rows. With `rows_per_page = 256` (default), pages are
    /// grid cells inherit stats from different pages per column.
            rows_per_page: 512,
            rows_per_page: 256,
    /// Override `min_skip_run_default` in the query config. When `Some`,
            collector_density: 0.05,
            null_strategy: NullStrategy::Uniform,
            rows_per_row_group: 1_024,
            num_rows: 10_000,
    pub fn block_granular_dense(seed: u64) -> Self {
        }
            num_segments: 4,
            collector_density: 0.05,
            null_strategy: NullStrategy::Uniform,
            num_collector_leaves: 3,
            multi_column_or_pct: 0.0,
            batch_size: None,
    /// AND(Predicate, Collector) focused: shallow trees (depth 2) with
            },
        ),
        Self {
            phantom_columns: Vec::new(),
            multi_column_or_pct: 0.0,
    Utf8 { num_distinct: usize, max_len: usize },
            min_skip_run_override: None,
    Int32 { min: i32, max: i32 },
            rows_per_row_group: 2_048,
//! One `FixtureConfig` → one parquet file written once per test. Each
    /// Float64. Generated from a `[min, max)` range.
    /// produces pages that are fully-null, fully-non-null, or
            num_rows: 10_000,
    /// Alternating clusters of nulls and non-nulls, each cluster
    /// zero-copy `prefetch_mask_buffer` fast path). Uses small data
            rows_per_page: 512,
    /// Concurrency stress: 8 partitions × 4 segments with mid-size
            num_segments: 1,
            num_rows: 50_000,
    /// Boolean.
    /// byte budget so wide-value columns flush more often than narrow
    pub null_pct: f64,
    /// `current_mask` must be built through `PositionMap` (not the
            null_pct: 0.1,
    pub fn shuffled_columns(seed: u64) -> Self {
        Self {
    }
            tree_max_depth: 5,
            columns: cols,
            null_pct_overrides: std::collections::HashMap::new(),
    /// `CoalescePartitionsExec` wrapper path in IndexedExec.
    /// List of column names that appear in the Arrow schema handed to
            columns: default_columns(),
            target_partitions: 8,
                        max_len: 8,
            phantom_columns: Vec::new(),
    /// Cardinality extremes: mix of degenerate column shapes to stress
            rows_per_page: 256,
    /// assumptions and exercises `UnionExec + CoalescePartitionsExec`
                max: 20_454,
        Self {
                    "score".to_string(),
                max_len: 8,
                ),
            columns: default_columns(),
/// `seed`; two `FixtureConfig`s with the same seed + same fields
    pub fn all_null_columns(seed: u64) -> Self {
        (
    }
            null_strategy: NullStrategy::Uniform,
            tree_max_fanout: 5,
            num_collector_leaves: 3,
            null_pct: 0.05,
}
    /// row groups the clusters straddle RG boundaries as well.
    pub null_strategy: NullStrategy,
        Self {
            rows_per_row_group: 2_048,
            seed,
            target_partitions: 1,
    /// Per-column null probability in `0.0..=1.0`.
            force_misaligned_pages: false,
        }
    /// from a `[min, max)` range.
        }
        let mut cols = default_columns();
            phantom_columns: Vec::new(),
    }
    /// Probability (0.0..=1.0) that a generated binary-op predicate
            rows_per_page: 512,
            max_collector_parallelism: None,
            batch_size: None,
    pub max_collector_parallelism: Option<usize>,
            null_pct_overrides: std::collections::HashMap::new(),
            null_pct: 0.4, // average ~40% nulls, but clustered
    /// mixed-null, exercising the grid null-count splitting rule
    vec![
            columns: default_columns(),
            target_partitions: 1,
            multi_column_or_pct: 0.0,
            num_collector_leaves: 4,
    /// Density of each Collector leaf's matching set, expressed as a
        }
            multi_column_or_pct: 0.0,
                num_distinct: 8,
}
            force_misaligned_pages: false,
        }
#[derive(Debug, Clone)]
            batch_size: None,
            null_pct: 0.5,
    /// Maximum fanout at each AND / OR node.
    /// Override max_collector_parallelism. `None` uses the harness
                    "wide_int".to_string(),
            seed,
        (
            batch_size: None,
    pub fn concurrency(seed: u64) -> Self {
            batch_size: None,
        Self {
            phantom_columns: Vec::new(),
    pub num_collector_leaves: usize,
    /// shape DataFusion's `PruningPredicate::split_conjunction`
            null_strategy: NullStrategy::Uniform,
            num_segments: 1,
                    "unique_str".to_string(),
            tree_max_fanout: 4,
            batch_size: None,
    /// data. Flushes out any cross-partition / cross-segment ordering
    /// in most presets.
    ]
    /// null_count ∈ {0, page_row_count} fast paths). With off-boundary
                ),
        }
            num_collector_leaves: 3,
    /// `cluster_len` rows long. With cluster_len ≥ rows_per_page,
            min_skip_run_override: None,
            target_partitions: 1,
    /// Shuffled columns: same as `small` but columns are in reversed
            rows_per_row_group: 2_048,
    /// Target DataFusion partitions. Values > 1 exercise the
    /// (10k rows, 2k RGs) but sets `min_skip_run_default = 4` so that
                min: 0.0,
        ),
            num_collector_leaves: 4,
/// has. Names match what tree-gen expects.
            batch_size: None,
    /// - `const_str`: 1 distinct Utf8 value (whole column identical).
            max_collector_parallelism: None,
            num_collector_leaves: 3,
            null_pct: 0.1,
            target_partitions: 1,
    /// segments via monotonically increasing `segment.first_row`.
        let mut overrides = std::collections::HashMap::new();
            tree_max_fanout: 4,
            num_segments: 1,
                    ColumnKind::Float64 {
                max: 10_000,
            force_misaligned_pages: false,
            force_misaligned_pages: false,
        // Date32 values in roughly [2020-01-01, 2025-12-31]: days since
}
            num_collector_leaves: 2,
    /// exercising the block-granular mask-alignment path.
                max: 1_735_689_600_000_000_000, // 2025-01-01T00:00:00Z
    /// fall back to `null_pct`.
        Self {
            num_rows: 8_000,
    }
    /// whichever is first. Smaller values produce more pages, exercising
            null_pct: 0.1,
/// Kinds of columns the corpus generator can produce. Kept narrow on
            null_pct_overrides: std::collections::HashMap::new(),
    /// Misaligned per-column page layouts. Forces the parquet writer
            phantom_columns: Vec::new(),
    }
            tree_max_depth: 5,
        ),
            max_collector_parallelism: None,
    /// Global doc-id is the row's index in the corpus, preserved across
                    "const_str".to_string(),
            seed,
            force_misaligned_pages: false,
    pub null_pct_overrides: std::collections::HashMap<String, f64>,
    /// different columns, rather than a single-column predicate.
                    },
            num_segments: 1,
            tree_max_depth: 5,
    /// - `unique_str`: `num_distinct = num_rows` so every value is
            min_skip_run_override: None,
    pub min_skip_run_override: Option<usize>,
            "status".to_string(),
    /// Utf8. Generated via a distinct-values pool; controls cardinality.
            null_strategy: NullStrategy::Uniform,
            null_strategy: NullStrategy::Uniform,
            rows_per_row_group: 2_048,
            multi_column_or_pct: 0.0,
            rows_per_page: 256,
    /// default (`[1, 1, 2, 4][seed % 4]`).
            seed,
                min: 18_262,
            min_skip_run_override: None,
            ColumnKind::Int64 {
            null_pct: 0.1,
    /// Small fixture for `fuzz_small`: 10k rows, handful of RGs, a few
            columns: default_columns(),
            null_strategy: NullStrategy::Clustered { cluster_len: 256 },
            collector_density: 0.05,
    /// All-null columns: `brand` and `qty` are 100% null, others at
            num_collector_leaves: 3,
            null_pct: 0.1,
            tree_max_depth: 5,
            // RG boundary (2_048) is not a multiple of cluster length
            collector_density: 0.1,
                    ColumnKind::Utf8 {
            seed,
            rows_per_page: 1_024,
    /// to produce different page boundaries for each column (achieved
    /// Number of segments (parquet files). Rows are split round-robin-ish
            num_collector_leaves: 3,
        cols.reverse();
            null_pct_overrides: std::collections::HashMap::new(),
            num_segments: 2,
            num_rows: 10_000,
            null_pct: 0.1,
    /// `PruningPredicate::split_conjunction` discards in DataFusion.
    /// Per-row Bernoulli with probability `null_pct`. Produces pages
                (
            seed,
                min: 1_704_067_200_000_000_000, // 2024-01-01T00:00:00Z
        ("active".to_string(), ColumnKind::Boolean),
            rows_per_row_group: 1_024,
            phantom_columns: Vec::new(),
            ],
 * this file be licensed under the Apache-2.0 license or a
        }
        (
            phantom_columns: Vec::new(),
    /// `run_iteration_twice`) to detect non-determinism across runs.
                num_distinct: 3,
            null_pct_overrides: std::collections::HashMap::new(),
            phantom_columns: Vec::new(),
        }
    }
            num_rows: 16_384,
        (
            phantom_columns: Vec::new(),
            max_collector_parallelism: None,
            seed,
    /// Max row-group size for the parquet writer. The writer will cut an
    pub rows_per_page: usize,
    /// - `wide_int`: Int32 across full range — opposite end.
            null_pct_overrides: std::collections::HashMap::new(),
            target_partitions: 1,
        Self {
/// Strategy for placing nulls within a generated column.
    pub target_partitions: usize,
            force_misaligned_pages: false,
    /// by disabling dictionary encoding and tightening the per-page
            tree_max_depth: 4,
            target_partitions: 1,
            rows_per_page: 256,
    /// discards at the top level but the grid pruner handles.
            rows_per_row_group: 2_048,
            },
    pub fn mid(seed: u64) -> Self {
    /// `rows_per_page` is reached or the configured byte budget is hit,
            seed,
    /// with a consistent null density; no page is ever fully-null or
    Date32 { min: i32, max: i32 },
            tree_max_depth: 2,
            num_segments: 1,
    /// Single row group: `rows_per_row_group >= num_rows` so the
            target_partitions: 1,
    ///   helps.
            null_pct_overrides: std::collections::HashMap::new(),
            batch_size: None,
            max_collector_parallelism: None,
        let num_rows = 10_000;
            "score".to_string(),
            // transition and hit the "unknown" grid-cell branch.
            phantom_columns: Vec::new(),
                        num_distinct: num_rows,
                (
    /// Timestamp(Nanosecond, None). Nanoseconds since epoch; generated
            force_misaligned_pages: false,
//! Fuzz fixture configuration — controls size, shape, and cardinality of
    /// Null-generation strategy. `Uniform` uses `null_pct` as an
    /// Multi-column OR inside a single expression: ~30% of generated
            columns: vec![
                ),
    /// the harness default (`[128, 1024, 8192][seed % 3]`).
            "qty".to_string(),
            collector_density: 0.03,
    /// Total row count across the fixture. 10_000..=50_000 for our suite.
            tree_max_fanout: 5,
            multi_column_or_pct: 0.0,
            force_misaligned_pages: false,
            // (256) + offset, so some pages span the null→non-null
    pub seed: u64,
            max_collector_parallelism: None,
            num_segments: 1,
            force_misaligned_pages: false,
    TimestampNanos { min: i64, max: i64 },
            tree_max_fanout: 4,
    }
            tree_max_fanout: 4,
    /// high collector count. Exercises the BitmapTree AND-branch
    pub batch_size: Option<usize>,
            min_skip_run_override: None,
            min_skip_run_override: None,
            null_strategy: NullStrategy::Uniform,
    pub tree_max_depth: u32,
            collector_density: 0.05,
    /// Null-heavy: ~50% null on every column, exercises 3VL everywhere.
            phantom_columns: Vec::new(),
            rows_per_row_group: 8_000,
        }
            target_partitions: 2,
    /// with realistic fan-out. Each iteration is run TWICE (via
            num_rows: 10_000,
            tree_max_fanout: 5,
    pub fn and_predicate_collector(seed: u64) -> Self {
    Float64 { min: f64, max: f64 },
            ColumnKind::Utf8 {
    /// *misaligned* per-column page layouts: dictionary encoding is
    /// budget, so columns with different per-value widths flush pages
    /// Writer's page-size limit. Parquet cuts a page when either
            rows_per_row_group: 2_048,
            num_collector_leaves: 3,
            num_collector_leaves: 1,
            columns: default_columns(),
            null_pct: 0.1,
            num_segments: 2,
        }
            ColumnKind::Utf8 {
        // epoch 1970-01-01 = ~18262..=20454.
            max_collector_parallelism: None,
                max: 100.0,
    /// Int32. Generated from a `[min, max)` value range.
            collector_density: 0.05,
    /// Maximum depth of generated trees. A depth-0 tree is a single
    /// mixed blocks (forcing grid cells that split pages across the
            columns: default_columns(),
            min_skip_run_override: None,
            force_misaligned_pages: false,
            target_partitions: 1,
            phantom_columns: Vec::new(),
            rows_per_row_group: 1_024,
            num_rows: 10_000,
                        min: i32::MIN / 2,
        }
            num_rows: 10_000,
            max_collector_parallelism: None,
                ("price".to_string(), ColumnKind::Int32 { min: 0, max: 1000 }),
        }
            rows_per_page: 256,
    /// Block-boundary focus: cuts RGs + pages at tight multiples so
        ("price".to_string(), ColumnKind::Int32 { min: 0, max: 1000 }),
    /// predicate-generation and the pruner, but do NOT exist in the
            max_collector_parallelism: None,
            num_segments: 1,
        overrides.insert("qty".to_string(), 1.0);
            phantom_columns: Vec::new(),
    pub columns: Vec<(String, ColumnKind)>,
            num_segments: 1,
            num_collector_leaves: 4,
            tree_max_fanout: 4,
            seed,
 * SPDX-License-Identifier: Apache-2.0
            tree_max_fanout: 4,
    /// even small gaps between the 10% candidate matches produce real
    /// predicates that always return TRUE on those columns.
            min_skip_run_override: None,
                        max_len: 4,
            columns: default_columns(),
    /// Always-parallel collectors: `max_collector_parallelism = 4` so
                ),
    /// Mid-size fixture for broader correctness coverage: 50k rows,
            num_collector_leaves: 4,
            num_segments: 2,
            phantom_columns: Vec::new(),
            tree_max_fanout: 5,
    /// null runs of a configured length. The clustered strategy
    /// Date32. Days since epoch; generated from a `[min, max)` range.
            seed,
    /// Number of Collector leaves the tree generator may emit. Each
            rows_per_row_group: 2_048,
            tree_max_depth: 2,
    pub num_segments: usize,
            tree_max_fanout: 2,
            min_skip_run_override: None,
            max_collector_parallelism: None,
            },
                min: 0,
            force_misaligned_pages: false,
#[derive(Debug, Clone, Copy)]
    /// corpus generator uses `null_pct_overrides[col_name]` instead of
            seed,
    /// Clustered nulls: each column's nulls form contiguous runs of
            num_segments: 1,
            rows_per_page: 64,
            num_collector_leaves: 2,
    }
//! test fuzz loop then generates many random trees against the same
            null_pct_overrides: std::collections::HashMap::new(),
        // Timestamp in 2024 calendar year: ns since epoch.
            null_pct_overrides: std::collections::HashMap::new(),
            target_partitions: 1,
            columns: default_columns(),
    ///   extremely tight and almost every literal prunes.
    /// regime where the RowSelection has real skip runs and
            rows_per_row_group: 4_096,
#[derive(Debug, Clone, Copy)]
        }
            tree_max_fanout: 6,
            rows_per_row_group: 2_048,
    /// Empty-result stress: very low collector density (0.1%) and only
            batch_size: None,
                    },
}
    }
            multi_column_or_pct: 0.0,
    /// leaf; depth-1 allows one layer of connectives; etc.
    }
            collector_density: 0.05,
 * compatible open source license.
            min_skip_run_override: None,
        }
            tree_max_depth: 4,
            null_pct: 0.1,
fn default_columns() -> Vec<(String, ColumnKind)> {
            rows_per_page: 256,
            target_partitions: 1,
    /// path where each grid cell inherits stats from a different
            tree_max_depth: 4,
    pub rows_per_row_group: usize,
            max_collector_parallelism: None,
            ColumnKind::Date32 {
    /// fully-non-null unless `null_pct` is exactly 0 or 1.
    /// RG every `rows_per_row_group` rows; smaller values produce more
    pub fn cardinality_extremes(seed: u64) -> Self {
            target_partitions: 1,
        Self {
    pub fn multi_column_or(seed: u64) -> Self {
            rows_per_page: 256,
            tree_max_depth: 6,
            max_collector_parallelism: None,
            null_strategy: NullStrategy::Uniform,
                        max: i32::MAX / 2,
    /// columns, moderate null rate.
            rows_per_page: 256,
    /// - `tiny_int`: Int32 with range `[0, 2)` so page min/max are
            null_pct_overrides: std::collections::HashMap::new(),
    pub fn single_row_group(seed: u64) -> Self {
            multi_column_or_pct: 0.0,
            min_skip_run_override: None,
            collector_density: 0.05,
            rows_per_row_group: 100_000,
                        num_distinct: 1,
            null_pct_overrides: std::collections::HashMap::new(),
    /// Columns in order. `columns[0]` becomes the first parquet field.
            collector_density: 0.05,
//!
    }
            null_strategy: NullStrategy::Uniform,
            null_pct_overrides: std::collections::HashMap::new(),
            null_strategy: NullStrategy::Uniform,
            num_collector_leaves: 1,
            tree_max_depth: 5,
            target_partitions: 4,
    /// the global `null_pct` for that column. Columns not in the map
            columns: default_columns(),
    pub fn batch_size_one(seed: u64) -> Self {
            null_strategy: NullStrategy::Uniform,
    pub collector_density: f64,
    /// Override batch_size for the DataFusion query config. `None` uses
        ),
    Uniform,
            max_collector_parallelism: None,
        Self {
    pub fn misaligned_pages(seed: u64) -> Self {
        }
            max_collector_parallelism: None,
            phantom_columns: Vec::new(),
            null_pct_overrides: std::collections::HashMap::new(),
    pub num_rows: usize,
    /// the `PagePruner` harder.
            tree_max_fanout: 5,
    pub fn empty_result(seed: u64) -> Self {
    ///   different — page stats min == max per row, pruning rarely
            tree_max_depth: 5,
            null_strategy: NullStrategy::Uniform,
            seed,
            null_pct: 0.1,
            batch_size: None,
            // allow, so byte budget dominates.
            seed,
    /// streaming loop.
            batch_size: None,
    /// entire segment is one RG. No RG boundary transitions in the
    /// batch_size=1: stresses coalescer and mask-slicing at every row
    pub fn null_heavy(seed: u64) -> Self {
            batch_size: None,
    /// corpus-gen time so the oracle can mirror it exactly.
                // keep one of each common type for tree-gen to also have choices
            columns: default_columns(),
        Self {
            rows_per_row_group: 2_048,
        }
            tree_max_fanout: 5,
            max_collector_parallelism: Some(4),
            tree_max_depth: 5,
    /// across all three branches.
    /// entire pages are fully-null or fully-non-null. With
            multi_column_or_pct: 0.0,
        Self {
            num_rows: 10_240,
            multi_column_or_pct: 0.0,
    /// disabled and `data_page_size_limit` is set to a very small byte
            seed,
            columns: default_columns(),
    /// either fully-null or fully-non-null (exercises the
            num_rows: 10_000,
                    },
            null_strategy: NullStrategy::Uniform,
/// float cmp, bool eq + 3VL null handling everywhere).
            tree_max_fanout: 5,
    /// 10%. Exercises page stats with absent min/max and `IS NULL`
            },
    /// leaf is backed by a random RG-relative doc-id set produced at
            null_pct_overrides: std::collections::HashMap::new(),
            null_pct: 0.1,
                (
        Self {
            tree_max_depth: 4,
    /// exercising short-circuit and empty-batch paths.
            },
        Self {
            multi_column_or_pct: 0.0,
    /// When `true`, the parquet writer is configured to produce
            max_collector_parallelism: None,
    }
    /// cluster boundary).
    /// skips — no need for 100k+ row RGs.
            multi_column_or_pct: 0.0,
            max_collector_parallelism: None,
                        min: 0.0,
            num_rows: 20_000,
            multi_column_or_pct: 0.0,
    Clustered { cluster_len: usize },
            collector_density: 0.01, // very sparse → long skip runs
            "created_day".to_string(),
            num_collector_leaves: 3,
            num_segments: 1,
            num_rows: 10_000,
/// Shape of the fixture. All parameters are deterministic given the
            collector_density: 0.05,
            num_segments: 3,
//! fixture; the corpus is shared, the trees vary per iteration.
            null_pct: 0.15,
            null_strategy: NullStrategy::Uniform,
            batch_size: None,
            null_pct: 0.1,
            multi_column_or_pct: 0.3,
            null_strategy: NullStrategy::Uniform,
    }
            ColumnKind::Float64 {
            seed,
            collector_density: 0.05,
    /// across segments; each segment becomes its own `SegmentFileInfo`.
            force_misaligned_pages: false,
    /// order. Exercises the stream.rs reprojection-by-name path .
            tree_max_fanout: 5,
                (
            null_pct_overrides: std::collections::HashMap::new(),
            min_skip_run_override: None,
            batch_size: None,
        ),
            collector_density: 0.05,
                    ColumnKind::Int32 {
/*
/// purpose — the same five cover every Predicate code path our
    /// Per-column null probability overrides. When non-empty, the
            num_rows: 10_000,
    pub force_misaligned_pages: bool,
    Int64 { min: i64, max: i64 },
    /// Block-granular dense: exercises the block-granular `min_skip_run`
    /// cluster_len < rows_per_page, pages contain null/non-null
    /// Int64. Same.
    /// page pruning + stats paths.
pub(in crate::indexed_table::tests_e2e) enum ColumnKind {
    /// more RGs, more pages.
/// Default column mix — covers every Predicate code path our evaluator
            batch_size: None,
            rows_per_page: 512,
    /// leaf is wrapped as `BinaryExpr(Or, pred(a), pred(b))` over two
            num_rows,
    /// parquet files. Simulates schema drift / schema evolution. Empty
    /// `PrecomputedLeafCache` concurrent path is always exercised.
            null_pct_overrides: overrides,
 */
