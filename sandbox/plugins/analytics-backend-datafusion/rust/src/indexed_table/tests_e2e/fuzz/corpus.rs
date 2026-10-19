                    CellValue::Date32(None)
        )
        let max = *page_counts_per_col.iter().max().unwrap();
        .iter()
            }
                    CellValue::Boolean(None) => b.append_null(),
            &mut rng,
                    }
    let null_mask: Vec<bool> = match null_strategy {
            *kind,
                    CellValue::Int64(Some(x)) => b.append_value(*x),
    batch: &RecordBatch,
                }
            // Debug-format match — thorough and works for every variant.
                .collect()
        assert_eq!(a.cells.len(), b.cells.len());
            .collect(),
    // contiguous slices of the single big `batch`; the oracle's view
        builder = builder
    // Split rows across `num_segments` parquet files. Row ranges are
//! iterations of a fuzz test; each iteration constructs a random tree
    /// `[0, segment_row_counts[0])`, segment 1 holds the next slice, etc.
    // then build arrow arrays from them so the parquet file and the
        col_idx,
                .map(|i| {
        .expect("arrow writer");
            let mut b = Float64Builder::new();
        let cfg = FixtureConfig::small(0xdeadbeef);
        let meta = datafusion::parquet::arrow::arrow_reader::ArrowReaderMetadata::load(
                    CellValue::Date32(Some(rng.gen_range(min..max)))
                }
/// `config.seed`.
            .collect(),
            (0..num_rows)
                    CellValue::Float64(None)
                    CellValue::Int64(None)
//! Write-once, read-many. The same `Corpus` is shared across many
    }
            ColumnKind::Utf8 { .. } => DataType::Utf8,
            let mut b = Int64Builder::new();
        // Tight byte budget + no dictionary encoding makes byte-width
                    _ => unreachable!("kind/cell mismatch"),
        NullStrategy::Clustered { cluster_len } => {
        for rg in oi {
                    CellValue::Boolean(None)
pub(in crate::indexed_table::tests_e2e) struct Corpus {
                .with_page_index(true),
            })
                }
            effective_null_pct,
/// build a pool of distinct values once, pick from it per row. Null
    let mut start = 0usize;
        let min = *page_counts_per_col.iter().min().unwrap();
    #[test]
                    CellValue::Int32(None)
    };
            Arc::new(b.finish())
    Boolean(Option<bool>),
                    CellValue::Boolean(Some(x)) => b.append_value(*x),
                    _ => unreachable!("kind/cell mismatch"),
            }
                }
        let cfg = FixtureConfig::small(0xfeed);
    null_pct: f64,
            ColumnKind::Int32 { .. } => DataType::Int32,
        );
            })
                }
            &slice,
            for v in col {
            num_distinct,
    for i in 0..num_segments {
/// One row of the corpus, kept in memory for the oracle. Mirrors the
        let file = std::fs::File::open(corpus.parquet_files[0].path()).unwrap();
            config.null_strategy,
            ColumnKind::Int64 { .. } => DataType::Int64,
fn build_schema(config: &FixtureConfig) -> SchemaRef {
            .collect(),
        ColumnKind::Float64 { min, max } => (0..num_rows)
use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
    }
        })
 * SPDX-License-Identifier: Apache-2.0
        }
            .map(|i| {
    match kind {
                    _ => unreachable!("kind/cell mismatch"),
            // pick the null-block length within the period as
    Date32(Option<i32>),
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
    let doc_id_array = {
fn random_alphanumeric(rng: &mut StdRng, max_len: usize) -> String {
///  - `Uniform`: independent per-row Bernoulli with probability
};
                    CellValue::Int32(Some(rng.gen_range(min..max)))
    ArrayRef, BooleanBuilder, Date32Builder, Float64Builder, Int32Builder, Int64Builder,
                } else {
                    CellValue::Int64(Some(rng.gen_range(min..max)))
                CellValue::Int32(Some(x)) => b.append_value(*x),
        fields.push(Field::new(name, dt, config.null_pct > 0.0));
    }
    fn corpus_respects_schema() {
    for (name, kind) in &config.columns {
                        CellValue::Utf8(None)
                } else {
            .set_dictionary_enabled(false)
        }
            }
    let mut segment_row_counts: Vec<usize> = Vec::with_capacity(num_segments);
        let oi = meta.metadata().offset_index().expect("offset index");
        ColumnKind::Utf8 { .. } => {
        arrays.push(cells_to_array(col, *kind));
                }
        ColumnKind::Int32 { min, max } => (0..num_rows)
            ColumnKind::Boolean => DataType::Boolean,
                }
    }
        ColumnKind::Boolean => {
        }
        assert!(meta.metadata().num_row_groups() > 1);
    Arc::new(Schema::new(fields))
            &file,
        let effective_null_pct = config
) -> NamedTempFile {
        ));
        .fields()
            Arc::new(b.finish())
    // oracle see *exactly* the same data.
    pub cells: Vec<Vec<CellValue>>,
            assert_eq!(
    rng: &mut StdRng,
/// Corpus = the parquet fixture + everything we need to evaluate
                .collect()
            min,
        };
    /// Column name → column index. Populated from `schema`.
 * compatible open source license.
    kind: ColumnKind,
            ColumnKind::TimestampNanos { .. } => {
    Int64(Option<i64>),
                if null_mask[i] {
    }
            datafusion::parquet::arrow::arrow_reader::ArrowReaderOptions::new()
                    _ => unreachable!("kind/cell mismatch"),
    null_strategy: NullStrategy,
}
            })
                if null_mask[i] {
                    CellValue::Int64(None) => b.append_null(),
}
    }
            );
                match v {
    let mut cells: Vec<Vec<CellValue>> = Vec::with_capacity(config.columns.len());
    match kind {
        // (10_000 / 2_048 ≈ 5 RGs).
        ColumnKind::Date32 { .. } => {
        }
        // path — a bug where column 0's page boundaries were used for
        // different per-column page counts.
            .collect(),
}
        let col = gen_column_cells(
            }
        NullStrategy::Uniform => (0..num_rows).map(|_| rng.gen::<f64>() < null_pct).collect(),
    Int32(Option<i32>),
        // Collect per-column page counts across all RGs.
    let col_idx = schema
    /// Days since epoch.
    /// Column-major ground-truth data, **global** indexing:
        ColumnKind::Utf8 {
            (0..num_rows)
/// arrow schema column-by-column. `None` = null.
            }
                if null_mask[i] {
    // Column-major: generate cells first (one Vec<CellValue> per column),
}
//! and evaluates it against the same data.
            Arc::new(b.finish())
                .map(|i| {
                } else {
    let mut arrays: Vec<ArrayRef> = Vec::with_capacity(cells.len());
        ColumnKind::Int64 { min, max } => (0..num_rows)
            config.rows_per_row_group,
    rows_per_row_group: usize,
///    columns don't correlate their null patterns).
                    CellValue::Date32(None) => b.append_null(),
            .get(name)
                    CellValue::TimestampNanos(None)
        }
            ColumnKind::Float64 { .. } => DataType::Float64,
        let corpus = build_corpus(cfg);
    let len = rng.gen_range(1..=max_len.max(1));
        let cfg = FixtureConfig::small(0x1234);
                format!("{:?}", col_b[col_b.len() - 1])
    }
    }
use datafusion::arrow::array::{
    let mut fields: Vec<Field> = Vec::with_capacity(config.columns.len() + 1);
                    CellValue::TimestampNanos(None) => b.append_null(),
            .collect(),
                    CellValue::Float64(None) => b.append_null(),
    Utf8(Option<String>),
        .set_data_page_row_count_limit(rows_per_page)
        ColumnKind::Int64 { .. } => {
                    } else {
        ColumnKind::Date32 { min, max } => (0..num_rows)
    for (col, (_, kind)) in cells.iter().skip(1).zip(config.columns.iter()) {
        let cfg = FixtureConfig::misaligned_pages(0xabcd);
    // Arrow arrays: __doc_id first, then user columns.
}
        }
        config,
    pub col_idx: std::collections::HashMap<String, usize>,
                _ => unreachable!("__doc_id must be non-null Int32"),
        for (col_a, col_b) in a.cells.iter().zip(b.cells.iter()) {
                    _ => unreachable!("kind/cell mismatch"),
///  - `Clustered { cluster_len }`: alternating null / non-null blocks
            ColumnKind::Date32 { .. } => DataType::Date32,
                    CellValue::Int32(Some(x)) => b.append_value(*x),
                DataType::Timestamp(datafusion::arrow::datatypes::TimeUnit::Nanosecond, None)
                        let j = rng.gen_range(0..pool.len());
        assert_eq!(corpus.cells[0].len(), corpus.num_rows());
            }
    rows_per_page: usize,
            config.force_misaligned_pages,
                    CellValue::Boolean(Some(rng.gen()))
        parquet_files.push(write_parquet(
                page_counts_per_col[i] += col.page_locations().len();
            for v in col {
        );
}
use datafusion::parquet::arrow::ArrowWriter;
                    CellValue::Float64(Some(rng.gen_range(min..max)))
                if null_mask[i] {
}
            })
    }
                }
                    let pos_in_period = (i + phase) % period;
            }
        ColumnKind::Int32 { .. } => {
                }
            "misaligned_pages preset must produce columns with different page counts; \
                } else {
                    _ => unreachable!("kind/cell mismatch"),
    fn misaligned_pages_actually_misalign() {
        let mut b = Int32Builder::new();
        .set_column_encoding(
                    CellValue::Date32(Some(x)) => b.append_value(*x),
            max_len,
pub(in crate::indexed_table::tests_e2e) enum CellValue {
        let file = std::fs::File::open(corpus.parquet_files[0].path()).unwrap();
}
        );
    let tmp = NamedTempFile::new().expect("tempfile");
            datafusion::parquet::basic::Encoding::DELTA_BINARY_PACKED,
    pub parquet_files: Vec<NamedTempFile>,
                    CellValue::Utf8(Some(s)) => b.append_value(s),
        }
        let b = build_corpus(cfg);
            // Random phase so different columns don't share null
            let c: u32 = rng.gen_range(0..62);
            Arc::new(b.finish())
        .map(|i| CellValue::Int32(Some(i as i32)))
        for v in &cells[0] {
    StringBuilder, TimestampNanosecondBuilder,
            assert_eq!(format!("{:?}", col_a[0]), format!("{:?}", col_b[0]));
    /// `cells[col_idx][global_row_idx]`.
            .map(|i| {
            // boundaries. Biased per `null_pct`: a full period is
/// placement follows `null_strategy`:
//! Corpus generator: one parquet file + in-memory ground-truth view.
use rand::rngs::StdRng;
    #[test]
                .map(|_| random_alphanumeric(rng, max_len))
/// distinct-pool + take-indices pattern from DataFusion's test-utils:
            match c {
    fn corpus_is_deterministic() {
    use super::*;
            let null_per_period = null_per_period.min(period);
fn write_parquet(
/*
/// Generate one column's worth of `CellValue`s. Follows the
        start += count;
        }
    TimestampNanos(Option<i64>),
#[derive(Debug, Clone)]
                    CellValue::Utf8(None) => b.append_null(),
    arrays.push(doc_id_array);
        let dt = match kind {
            let null_per_period = (null_pct * period as f64).round() as usize;
                match v {
            Arc::new(b.finish())
                })
    let batch = RecordBatch::try_new(schema.clone(), arrays).expect("record batch");
                    CellValue::Int32(None) => b.append_null(),
        let a = build_corpus(cfg.clone());
        segment_row_counts.push(base + if i < rem { 1 } else { 0 });
                })
                } else {
                }
                    if null_mask[i] {
        .unwrap();
 * The OpenSearch Contributors require contributions made to
pub(in crate::indexed_table::tests_e2e) fn build_corpus(config: FixtureConfig) -> Corpus {
                } else {
            let pool: Vec<String> = (0..num_distinct.max(1))
    let props = builder.build();
    };
        .enumerate()
    }
            .map(|i| {
                0..=9 => (b'0' + c as u8) as char,
            .null_pct_overrides
    w.close().expect("close");
                if null_mask[i] {
            .set_data_page_size_limit(512);
        } => {
            for v in col {
    }
    #[test]
        assert_eq!(corpus.cells.len(), corpus.schema.fields().len());
                10..=35 => (b'a' + (c as u8 - 10)) as char,
            let period = 2 * cluster_len;
            datafusion::parquet::schema::types::ColumnPath::new(vec!["__doc_id".to_string()]),
    /// Nanoseconds since epoch.
            // `2 * cluster_len` (null block + non-null block). We
            }
        .collect();
            })
            max > min,
        // Force different encodings per column type to produce different
    let schema = build_schema(&config);
    // stays `cells` in global indexing.
            .map(|i| {
    #[test]
                    CellValue::TimestampNanos(Some(x)) => b.append_value(*x),
            config.num_rows,
    force_misaligned_pages: bool,
use super::config::{ColumnKind, FixtureConfig, NullStrategy};
    let mut builder = WriterProperties::builder()
            assert_eq!(col_a.len(), col_b.len());
            let mut b = Date32Builder::new();
    // harness recover row identity from returned record batches.
            .map(|i| {
 */
                format!("{:?}", col_a[col_a.len() - 1]),
            }
    pub schema: SchemaRef,
        .collect()
            Arc::new(b.finish())
///    Bernoulli draw, giving per-column independent phase (so two
            let mut b = TimestampNanosecondBuilder::new();
        }
            for (i, col) in rg.iter().enumerate() {
            .collect(),
        )
            let mut b = StringBuilder::new();
        let corpus = build_corpus(cfg);
    // Synthetic doc-id column, always non-null Int32 at column 0. Lets the
                match v {
    if force_misaligned_pages {
            .copied()
                match v {
        cells,
        segment_row_counts,
    fn corpus_produces_multi_rg_parquet() {
    let base = config.num_rows / num_segments;
fn gen_column_cells(
    // Reserve column 0 for the synthetic __doc_id.
        }
) -> Vec<CellValue> {
            for v in col {
                match v {
            page_counts_per_col
    /// Kept alive for the corpus lifetime.
    // Pre-compute the null mask. `true` = null.
    fields.push(Field::new("__doc_id", DataType::Int32, false));
                match v {
#[cfg(test)]
    }
///    of `cluster_len` rows. The starting block is chosen by a single
        .map(|(i, f)| (f.name().clone(), i))
    for (name, kind) in &config.columns {
        .collect();
        self.config.num_rows
            config.rows_per_page,
        // faster than Int32/Boolean columns, yielding genuinely
                    CellValue::Float64(Some(x)) => b.append_value(*x),
        Arc::new(b.finish()) as ArrayRef
    /// Parquet file(s) on disk, one per segment. Segment 0 holds rows
///    `null_pct`.
            &file,
                        CellValue::Utf8(Some(pool[j].clone()))
/// queries against it with a row-by-row oracle.
                }
            let phase: usize = rng.gen_range(0..period);
    num_rows: usize,
    for &count in &segment_row_counts {
            for v in col {
            datafusion::parquet::arrow::arrow_reader::ArrowReaderOptions::new()
        .set_statistics_enabled(EnabledStatistics::Page)
                .with_page_index(true),
                }
                match v {
                    CellValue::TimestampNanos(Some(rng.gen_range(min..max)))
}
    pub fn num_rows(&self) -> usize {
        ColumnKind::TimestampNanos { min, max } => (0..num_rows)
}
    w.write(batch).expect("write");
        // the flush trigger. Utf8 columns (many bytes/value) flush
    }
            })
    pub segment_row_counts: Vec<usize>,
fn cells_to_array(col: &[CellValue], kind: ColumnKind) -> ArrayRef {
    pub config: FixtureConfig,
        let corpus = build_corpus(cfg);
impl Corpus {
        ColumnKind::Float64 { .. } => {
        assert!(
                    _ => unreachable!("kind/cell mismatch"),
        // Load parquet metadata and assert > 1 RG for the small preset
        let mut page_counts_per_col: Vec<usize> = vec![0; oi[0].len()];
        .unwrap();
    let doc_id_col: Vec<CellValue> = (0..config.num_rows)
        ColumnKind::Boolean => (0..num_rows)
                if null_mask[i] {
        }
    tmp
use rand::{Rng, SeedableRng};
        ColumnKind::TimestampNanos { .. } => {
        let slice = batch.slice(start, count);
            let cluster_len = cluster_len.max(1);
                .collect();
        .map(|_| {
    let mut rng = StdRng::seed_from_u64(config.seed);
//!
use std::sync::Arc;
                    pos_in_period < null_per_period
    debug_assert_eq!(start, config.num_rows);
                _ => (b'A' + (c as u8 - 36)) as char,
        .set_max_row_group_size(rows_per_row_group)
            .unwrap_or(config.null_pct);
    (0..len)
             got identical count {} across all columns: {:?}",
    let mut w = ArrowWriter::try_new(tmp.reopen().expect("reopen"), batch.schema(), Some(props))
 * this file be licensed under the Apache-2.0 license or a
            // `round(null_pct * 2 * cluster_len)`.
                }
 *
            .map(|i| {
        }
    Float64(Option<f64>),
mod tests {
    let rem = config.num_rows % num_segments;
        let meta = datafusion::parquet::arrow::arrow_reader::ArrowReaderMetadata::load(
            }
    Corpus {
            }
use tempfile::NamedTempFile;
            Arc::new(b.finish())
            match v {
use datafusion::arrow::record_batch::RecordBatch;
/// Build a corpus from the given config. Deterministic given
        // page boundaries. This exercises the per-column page pruning
            let mut b = Int32Builder::new();
            for v in col {
    /// Row count per segment. `segment_row_counts.iter().sum() == num_rows`.
    }
    let num_segments = config.num_segments.max(1);
    cells.push(doc_id_col);
        parquet_files,
    let mut parquet_files: Vec<NamedTempFile> = Vec::with_capacity(num_segments);
            let mut b = BooleanBuilder::new();
        // all columns was only caught when encodings diverged.
        schema,
            for v in col {
        cells.push(col);
