            datafusion::parquet::arrow::arrow_reader::ArrowReaderOptions::new()
    Int64(Option<i64>),
            })
                }
    Date32(Option<i32>),
                    CellValue::Utf8(Some(s)) => b.append_value(s),
    num_rows: usize,
        let cfg = FixtureConfig::small(0xdeadbeef);
                    CellValue::Boolean(None) => b.append_null(),
            "misaligned_pages preset must produce columns with different page counts; \
}
    #[test]
use rand::rngs::StdRng;
            max > min,
                        let j = rng.gen_range(0..pool.len());
impl Corpus {
                    if null_mask[i] {
                    CellValue::TimestampNanos(None)
    batch: &RecordBatch,
                }
        )
    let mut start = 0usize;
        builder = builder
        );
                    CellValue::Float64(Some(x)) => b.append_value(*x),
        ));
            let mut b = Int32Builder::new();
    let mut cells: Vec<Vec<CellValue>> = Vec::with_capacity(config.columns.len());
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
    }
    Arc::new(Schema::new(fields))
//! and evaluates it against the same data.
        }
                format!("{:?}", col_b[col_b.len() - 1])
            }
    let schema = build_schema(&config);
};
                    CellValue::Int32(Some(x)) => b.append_value(*x),
        let meta = datafusion::parquet::arrow::arrow_reader::ArrowReaderMetadata::load(
///    of `cluster_len` rows. The starting block is chosen by a single
        start += count;
    let mut w = ArrowWriter::try_new(tmp.reopen().expect("reopen"), batch.schema(), Some(props))
    /// Nanoseconds since epoch.
                    _ => unreachable!("kind/cell mismatch"),
        ColumnKind::TimestampNanos { min, max } => (0..num_rows)
            config.force_misaligned_pages,
fn gen_column_cells(
            })
                    CellValue::TimestampNanos(None) => b.append_null(),
    Float64(Option<f64>),
use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
 * SPDX-License-Identifier: Apache-2.0
        // Load parquet metadata and assert > 1 RG for the small preset
 */
        ColumnKind::Date32 { .. } => {
    }
    // stays `cells` in global indexing.
    // Arrow arrays: __doc_id first, then user columns.
        let mut b = Int32Builder::new();
                }
            .collect(),
            }
 * The OpenSearch Contributors require contributions made to
    }
use std::sync::Arc;
        .enumerate()
        .collect();
                .map(|_| random_alphanumeric(rng, max_len))
    pub fn num_rows(&self) -> usize {
            .map(|i| {
        // different per-column page counts.
                    CellValue::Int64(Some(x)) => b.append_value(*x),
        assert_eq!(corpus.cells[0].len(), corpus.num_rows());
        ColumnKind::Utf8 { .. } => {
        } => {
use datafusion::arrow::array::{
            &slice,
            for v in col {
        // Force different encodings per column type to produce different
            assert_eq!(col_a.len(), col_b.len());
                10..=35 => (b'a' + (c as u8 - 10)) as char,
            Arc::new(b.finish())
            .set_dictionary_enabled(false)
            }
    // Synthetic doc-id column, always non-null Int32 at column 0. Lets the
fn build_schema(config: &FixtureConfig) -> SchemaRef {
        ColumnKind::Boolean => (0..num_rows)
            }
                    CellValue::TimestampNanos(Some(rng.gen_range(min..max)))
            // pick the null-block length within the period as
                .with_page_index(true),
        fields.push(Field::new(name, dt, config.null_pct > 0.0));
                }
                } else {
                        CellValue::Utf8(None)
                    CellValue::Int32(None)
    };
                } else {
        // the flush trigger. Utf8 columns (many bytes/value) flush
        ColumnKind::TimestampNanos { .. } => {
                })
                }
            .copied()
    pub col_idx: std::collections::HashMap<String, usize>,
            assert_eq!(format!("{:?}", col_a[0]), format!("{:?}", col_b[0]));
            let pool: Vec<String> = (0..num_distinct.max(1))
            .null_pct_overrides
                0..=9 => (b'0' + c as u8) as char,
pub(in crate::indexed_table::tests_e2e) enum CellValue {
        let mut page_counts_per_col: Vec<usize> = vec![0; oi[0].len()];
        // faster than Int32/Boolean columns, yielding genuinely
                    CellValue::TimestampNanos(Some(x)) => b.append_value(*x),
                match v {
    let base = config.num_rows / num_segments;
    let mut parquet_files: Vec<NamedTempFile> = Vec::with_capacity(num_segments);
use rand::{Rng, SeedableRng};
            ColumnKind::Date32 { .. } => DataType::Date32,
            Arc::new(b.finish())
            datafusion::parquet::basic::Encoding::DELTA_BINARY_PACKED,
                } else {
                    _ => unreachable!("kind/cell mismatch"),
        let cfg = FixtureConfig::small(0xfeed);
use datafusion::parquet::arrow::ArrowWriter;
                .collect()
        .unwrap();
///    columns don't correlate their null patterns).
        let cfg = FixtureConfig::misaligned_pages(0xabcd);
    }
        );
        // all columns was only caught when encodings diverged.
        let file = std::fs::File::open(corpus.parquet_files[0].path()).unwrap();
    // then build arrow arrays from them so the parquet file and the
        col_idx,
    let mut arrays: Vec<ArrayRef> = Vec::with_capacity(cells.len());
        };
            .collect(),
                match v {
    #[test]
                }
    Corpus {
    }
}
/// queries against it with a row-by-row oracle.
                }
            let mut b = BooleanBuilder::new();
            for (i, col) in rg.iter().enumerate() {
            })
        let dt = match kind {
    null_strategy: NullStrategy,
            .collect(),
            for v in col {
        // Collect per-column page counts across all RGs.
}
            // Random phase so different columns don't share null
                    CellValue::Date32(None)
            config.rows_per_page,
            .map(|i| {
            ColumnKind::Utf8 { .. } => DataType::Utf8,
        for rg in oi {
    }
use super::config::{ColumnKind, FixtureConfig, NullStrategy};
    let col_idx = schema
        }
}
        .map(|(i, f)| (f.name().clone(), i))
        assert!(meta.metadata().num_row_groups() > 1);
            }
            ColumnKind::TimestampNanos { .. } => {
        self.config.num_rows
            ColumnKind::Int32 { .. } => DataType::Int32,
        .unwrap();
        assert_eq!(a.cells.len(), b.cells.len());
            let mut b = Date32Builder::new();
 * this file be licensed under the Apache-2.0 license or a
    Utf8(Option<String>),
fn random_alphanumeric(rng: &mut StdRng, max_len: usize) -> String {
                .collect();
        .map(|i| CellValue::Int32(Some(i as i32)))
        }
    kind: ColumnKind,
        segment_row_counts,
            for v in col {
    /// `cells[col_idx][global_row_idx]`.
    // Split rows across `num_segments` parquet files. Row ranges are
                page_counts_per_col[i] += col.page_locations().len();
                match v {
    pub schema: SchemaRef,
                .with_page_index(true),
        cells.push(col);
    /// Column name → column index. Populated from `schema`.
    let len = rng.gen_range(1..=max_len.max(1));
                    CellValue::Utf8(None) => b.append_null(),
        ColumnKind::Int64 { .. } => {
        ColumnKind::Utf8 {
            config.rows_per_row_group,
    arrays.push(doc_id_array);
    if force_misaligned_pages {
                if null_mask[i] {
            min,
                    CellValue::Int64(None)
            // `2 * cluster_len` (null block + non-null block). We
    Int32(Option<i32>),
            for v in col {
        let cfg = FixtureConfig::small(0x1234);
        ColumnKind::Boolean => {
        ColumnKind::Float64 { min, max } => (0..num_rows)
            }
            let cluster_len = cluster_len.max(1);
        ColumnKind::Date32 { min, max } => (0..num_rows)
/*
            let null_per_period = null_per_period.min(period);
                .collect()
///    Bernoulli draw, giving per-column independent phase (so two
    rows_per_page: usize,
            page_counts_per_col
        let corpus = build_corpus(cfg);
    null_pct: f64,
            // boundaries. Biased per `null_pct`: a full period is
//! iterations of a fuzz test; each iteration constructs a random tree
            let period = 2 * cluster_len;
        // Tight byte budget + no dictionary encoding makes byte-width
        config,
    /// Kept alive for the corpus lifetime.
) -> Vec<CellValue> {
    /// Days since epoch.
    let rem = config.num_rows % num_segments;
    pub parquet_files: Vec<NamedTempFile>,
        .iter()
    let mut builder = WriterProperties::builder()
        }
            .map(|i| {
                        CellValue::Utf8(Some(pool[j].clone()))
            (0..num_rows)
        let b = build_corpus(cfg);
fn cells_to_array(col: &[CellValue], kind: ColumnKind) -> ArrayRef {
        )
                }
                .map(|i| {
    debug_assert_eq!(start, config.num_rows);
    #[test]
            for v in col {
    for (col, (_, kind)) in cells.iter().skip(1).zip(config.columns.iter()) {
            Arc::new(b.finish())
    // Column-major: generate cells first (one Vec<CellValue> per column),
            }
/// build a pool of distinct values once, pick from it per row. Null
/// Generate one column's worth of `CellValue`s. Follows the
            match v {
                    CellValue::Int64(None) => b.append_null(),
                if null_mask[i] {
        let corpus = build_corpus(cfg);
            assert_eq!(
                } else {
        schema,
        assert_eq!(corpus.cells.len(), corpus.schema.fields().len());
    }
    use super::*;
        .map(|_| {
        let file = std::fs::File::open(corpus.parquet_files[0].path()).unwrap();
use tempfile::NamedTempFile;
                    let pos_in_period = (i + phase) % period;
                } else {
            );
            .unwrap_or(config.null_pct);
                    _ => unreachable!("kind/cell mismatch"),
                    CellValue::Boolean(Some(x)) => b.append_value(*x),
        .fields()
//! Write-once, read-many. The same `Corpus` is shared across many
    StringBuilder, TimestampNanosecondBuilder,
///  - `Uniform`: independent per-row Bernoulli with probability
 *
            &file,
        }
                    CellValue::Float64(None)
    w.write(batch).expect("write");
        })
mod tests {
    pub config: FixtureConfig,
        }
    let doc_id_array = {
        for (col_a, col_b) in a.cells.iter().zip(b.cells.iter()) {
//! Corpus generator: one parquet file + in-memory ground-truth view.
                if null_mask[i] {
                    CellValue::Int32(Some(rng.gen_range(min..max)))
    }
/// distinct-pool + take-indices pattern from DataFusion's test-utils:
            datafusion::parquet::schema::types::ColumnPath::new(vec!["__doc_id".to_string()]),
    w.close().expect("close");
            // Debug-format match — thorough and works for every variant.
                    _ => unreachable!("kind/cell mismatch"),
            .set_data_page_size_limit(512);
                })
    ArrayRef, BooleanBuilder, Date32Builder, Float64Builder, Int32Builder, Int64Builder,
        }
    /// Row count per segment. `segment_row_counts.iter().sum() == num_rows`.
                _ => (b'A' + (c as u8 - 36)) as char,
    (0..len)
            let c: u32 = rng.gen_range(0..62);
                    CellValue::Date32(None) => b.append_null(),
    let props = builder.build();
    fn corpus_is_deterministic() {
        .expect("arrow writer");
/// placement follows `null_strategy`:
            ColumnKind::Int64 { .. } => DataType::Int64,
                match v {
}
    }
        }
    pub cells: Vec<Vec<CellValue>>,
            let mut b = Int64Builder::new();
            .map(|i| {
            }
        let oi = meta.metadata().offset_index().expect("offset index");
        ColumnKind::Int32 { min, max } => (0..num_rows)
            Arc::new(b.finish())
            (0..num_rows)
        NullStrategy::Uniform => (0..num_rows).map(|_| rng.gen::<f64>() < null_pct).collect(),
    // contiguous slices of the single big `batch`; the oracle's view
    let num_segments = config.num_segments.max(1);
            let mut b = Float64Builder::new();
        assert!(
    pub segment_row_counts: Vec<usize>,
}
    }
/// arrow schema column-by-column. `None` = null.
            .get(name)
///  - `Clustered { cluster_len }`: alternating null / non-null blocks
    force_misaligned_pages: bool,
            let null_per_period = (null_pct * period as f64).round() as usize;
                _ => unreachable!("__doc_id must be non-null Int32"),
        let min = *page_counts_per_col.iter().min().unwrap();
        Arc::new(b.finish()) as ArrayRef
            for v in col {
                .map(|i| {
                if null_mask[i] {
        }
/// Corpus = the parquet fixture + everything we need to evaluate
        .collect();
                    CellValue::Int32(None) => b.append_null(),
            Arc::new(b.finish())
                    CellValue::Date32(Some(rng.gen_range(min..max)))
    /// Column-major ground-truth data, **global** indexing:
        arrays.push(cells_to_array(col, *kind));
        let col = gen_column_cells(
            for v in col {
}
            }
            effective_null_pct,
    }
    tmp
                }
                }
        cells,
    rng: &mut StdRng,
            &file,
                    _ => unreachable!("kind/cell mismatch"),
            .map(|i| {
            })
///    `null_pct`.
                    CellValue::Float64(Some(rng.gen_range(min..max)))
) -> NamedTempFile {
            .map(|i| {
            let mut b = TimestampNanosecondBuilder::new();
                    _ => unreachable!("kind/cell mismatch"),
            .collect(),
    }
pub(in crate::indexed_table::tests_e2e) struct Corpus {
                }
    for i in 0..num_segments {
                }
        }
                if null_mask[i] {
            let mut b = StringBuilder::new();
    match kind {
            max_len,
            // `round(null_pct * 2 * cluster_len)`.
    }
    fn corpus_respects_schema() {
}
            ColumnKind::Boolean => DataType::Boolean,
                    _ => unreachable!("kind/cell mismatch"),
        let effective_null_pct = config
    for (name, kind) in &config.columns {
        segment_row_counts.push(base + if i < rem { 1 } else { 0 });
            ColumnKind::Float64 { .. } => DataType::Float64,
    for (name, kind) in &config.columns {
        ColumnKind::Int32 { .. } => {
pub(in crate::indexed_table::tests_e2e) fn build_corpus(config: FixtureConfig) -> Corpus {
use datafusion::arrow::record_batch::RecordBatch;
                if null_mask[i] {
                CellValue::Int32(Some(x)) => b.append_value(*x),
    /// Parquet file(s) on disk, one per segment. Segment 0 holds rows
                    CellValue::Int64(Some(rng.gen_range(min..max)))
        }
            }
                    pos_in_period < null_per_period
//!
    // oracle see *exactly* the same data.
    }
    let batch = RecordBatch::try_new(schema.clone(), arrays).expect("record batch");
            config.num_rows,
            *kind,
            })
            Arc::new(b.finish())
    fn corpus_produces_multi_rg_parquet() {
            Arc::new(b.finish())
        .set_max_row_group_size(rows_per_row_group)
    #[test]
            config.null_strategy,
#[derive(Debug, Clone)]
                match v {
            &mut rng,
 * compatible open source license.
    // harness recover row identity from returned record batches.
    let mut rng = StdRng::seed_from_u64(config.seed);
                    }
    rows_per_row_group: usize,
        parquet_files.push(write_parquet(
                    CellValue::Float64(None) => b.append_null(),
            datafusion::parquet::arrow::arrow_reader::ArrowReaderOptions::new()
        let corpus = build_corpus(cfg);
        // (10_000 / 2_048 ≈ 5 RGs).
            }
        // page boundaries. This exercises the per-column page pruning
            let phase: usize = rng.gen_range(0..period);
/// Build a corpus from the given config. Deterministic given
        let a = build_corpus(cfg.clone());
    let null_mask: Vec<bool> = match null_strategy {
    Boolean(Option<bool>),
            .collect(),
}
        let max = *page_counts_per_col.iter().max().unwrap();
    cells.push(doc_id_col);
    let tmp = NamedTempFile::new().expect("tempfile");
        parquet_files,
}
    match kind {
             got identical count {} across all columns: {:?}",
#[cfg(test)]
/// `config.seed`.
                    } else {
        );
    };
    // Reserve column 0 for the synthetic __doc_id.
            })
                format!("{:?}", col_a[col_a.len() - 1]),
    let mut segment_row_counts: Vec<usize> = Vec::with_capacity(num_segments);
/// One row of the corpus, kept in memory for the oracle. Mirrors the
        ColumnKind::Float64 { .. } => {
        let meta = datafusion::parquet::arrow::arrow_reader::ArrowReaderMetadata::load(
        ColumnKind::Int64 { min, max } => (0..num_rows)
        // path — a bug where column 0's page boundaries were used for
        for v in &cells[0] {
        .set_data_page_row_count_limit(rows_per_page)
                } else {
        .set_statistics_enabled(EnabledStatistics::Page)
                    CellValue::Boolean(None)
            match c {
                match v {
    for &count in &segment_row_counts {
                match v {
        NullStrategy::Clustered { cluster_len } => {
        let slice = batch.slice(start, count);
    TimestampNanos(Option<i64>),
            num_distinct,
fn write_parquet(
                }
    let doc_id_col: Vec<CellValue> = (0..config.num_rows)
            .collect(),
        }
                    CellValue::Boolean(Some(rng.gen()))
    // Pre-compute the null mask. `true` = null.
        .set_column_encoding(
                DataType::Timestamp(datafusion::arrow::datatypes::TimeUnit::Nanosecond, None)
    /// `[0, segment_row_counts[0])`, segment 1 holds the next slice, etc.
    let mut fields: Vec<Field> = Vec::with_capacity(config.columns.len() + 1);
        .collect()
                    CellValue::Date32(Some(x)) => b.append_value(*x),
    fields.push(Field::new("__doc_id", DataType::Int32, false));
    fn misaligned_pages_actually_misalign() {
