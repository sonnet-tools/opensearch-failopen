}
        let col_chunk = rg_meta.column(col_idx);
use datafusion::common::{Column, ScalarValue};
    rg_idx: usize,
        }
//! is skipped entirely — saving the FFM round-trip.
                // and the bloom filter will return a false negative. DataFusion's
            ScalarValue::Utf8(Some(s)) | ScalarValue::LargeUtf8(Some(s)) => sbbf.check(s.as_str()),
        let get_result = store.get_opts(path, opts).await?;
        .ok_or("row group index out of range")?;
    }
    let mut blooms = std::collections::HashMap::new();
                // if a mismatch occurs we conservatively return `true` (may match).
        Ok(should_prune) => should_prune,
        return Ok(false); // no equality predicates → cannot bloom-prune
                // For Decimal128 the parquet writer uses the i128 in big-endian
    }
use datafusion::parquet::bloom_filter::Sbbf;
    store: &dyn ObjectStore,
use datafusion::arrow::datatypes::Schema;
        None
                continue;
    metadata: &ParquetMetaData,
            ScalarValue::Float32(Some(v)) => sbbf.check(v),
use datafusion::parquet::file::metadata::ParquetMetaData;
    }
/// (conservative: do not prune).
) -> Result<bool, Box<dyn std::error::Error + Send + Sync>> {
        None
    /// Returns `true` if the value MAY be present, `false` if it is
        };
        let col_idx = match arrow_schema
        .get(rg_idx)
    // Call the pruning predicate with our bloom-filter-backed statistics.
            ScalarValue::Int64(Some(v)) => sbbf.check(v),
    if blooms.is_empty() {
            None => continue, // column not in schema → skip
        .row_groups()
        };
                // query literal is 1.5 (scale=1, stored as 15), but Parquet
    }
    fn max_values(&self, _column: &Column) -> Option<ArrayRef> {
        None
        let sbbf = self.blooms.get(column.name())?;
        // Get the column chunk metadata for this column in this row group.
            ScalarValue::Float64(Some(v)) => sbbf.check(v),
    for col_name in &literal_cols {
) -> bool {
        let opts = GetOptions {
    fn null_counts(&self, _column: &Column) -> Option<ArrayRef> {
//! Uses the Parquet bloom filter (SBBF — Split Block Bloom Filter) embedded in
    // equality constraints (e.g., col = 'value').
                // Some parquet writers don't record length — skip this column.
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
    let literal_cols = predicate.literal_columns();
            _ => {
            ScalarValue::UInt64(Some(v)) => sbbf.check(v),
        let bf_length: u64 = match col_chunk.bloom_filter_length() {
/// Any error (missing bloom filter, I/O error, parse error) results in `false`
/*
            }
}
}
                // Parquet stores Decimal as fixed-length byte array (big-endian).
    let stats = BloomFilterStatistics { blooms };
use datafusion::physical_optimizer::pruning::{PruningPredicate, PruningStatistics};
        // Check if bloom filter metadata is available.
            .fields()
    fn check_scalar(sbbf: &Sbbf, value: &ScalarValue) -> bool {
    path: &object_store::path::Path,
use datafusion::arrow::array::{ArrayRef, BooleanArray};
/// data — all other methods return `None` so `PruningPredicate::prune` falls
    // `true` means "keep", `false` means "can prune".
//! Bloom filter pruning for indexed parquet reads.
            .iter()
    }
//! that match equality predicates. Runs AFTER page-level min/max pruning (free,
            Ok(keep.first() == Some(&false))
    // `literal_columns` returns columns where the predicate has literal
    match bloom_prune_rg_inner(store, path, metadata, arrow_schema, rg_idx, predicate).await {
    match predicate.prune(&stats) {
            // Null or unsupported type → conservatively say "may be present"
    }
    arrow_schema: &Arc<Schema>,
                // If length is not recorded, we cannot safely read.
//! the file footer to decide whether a row group can possibly contain values
        return Ok(false); // no bloom filters available → cannot prune
async fn bloom_prune_rg_inner(
    blooms: std::collections::HashMap<String, Sbbf>,
            Some(len) if len > 0 => len as u64,
}
 * SPDX-License-Identifier: Apache-2.0
                // cast coercion should normalize scales before reaching here, but
 * compatible open source license.
            ScalarValue::Binary(Some(b)) | ScalarValue::LargeBinary(Some(b)) => {
        };
/// filters. The `contained()` method is the only one that returns meaningful
                let bytes = v.to_be_bytes();
    }
    }
            })),
//!
            ScalarValue::Int32(Some(v)) => sbbf.check(v),
/// Attempt to prune a single row group using bloom filters.
        // the values can be present (definite absence).
            Some(offset) if offset >= 0 => offset as u64,
/// unavailable).
}
        }
        // Find the parquet column index for this column name.
use std::sync::Arc;
                // byte representation (16 bytes).
    predicate: &PruningPredicate,
            range: Some(GetRange::Bounded(std::ops::Range {
///
use std::collections::HashSet;
    }
        let sbbf = Sbbf::from_bytes(&bytes)?;
    }
    // Identify which columns participate in the predicate's equality checks.
            .position(|f| f.name() == col_name)
/// should be kept (bloom filter says values may be present, or bloom filter is
        let bf_offset: u64 = match col_chunk.bloom_filter_offset() {
use object_store::{GetOptions, GetRange, ObjectStore};
                sbbf.check(b.as_slice())
            Some(idx) => idx,
    // Result is a Vec<bool> with one entry per container (we have 1 container).
        match value {
                // stored value. If the Parquet column is DECIMAL(10,2) and the
            _ => true,
    predicate: &PruningPredicate,
        };
        let bytes = get_result.bytes().await?;
        // single-element BooleanArray. `true` means the bloom filter says
            ..Default::default()
            ScalarValue::Boolean(Some(v)) => sbbf.check(v),
/// Returns `true` if the row group should be PRUNED (skipped), `false` if it
        // For the single-container case (1 row group), we return a
//! If the bloom filter proves absence for all equality predicates, the row group
///
                end: bf_offset + bf_length,
    path: &object_store::path::Path,
                //
    let rg_meta = metadata
        Err(_) => false, // conservative: don't prune on error
            ScalarValue::UInt32(Some(v)) => sbbf.check(v),
    if literal_cols.is_empty() {
pub async fn bloom_prune_rg(
    arrow_schema: &Arc<Schema>,
 */
                // stored it as 150 (scale=2), the byte representations differ
                // The SBBF hashes the raw bytes that were inserted at write time.
        // Read the bloom filter bytes from the object store.
                sbbf.check(bytes.as_slice())
    fn row_counts(&self) -> Option<ArrayRef> {
//! in-memory) and BEFORE the expensive FFM collector call (Lucene, ~1-5 ms).
    /// Column name → parsed SBBF for this row group.
            _ => continue, // no bloom filter for this column
impl PruningStatistics for BloomFilterStatistics {
impl BloomFilterStatistics {
            }
        {
                start: bf_offset,
    /// Check whether a scalar value is contained in the bloom filter.
        blooms.insert(col_name.clone(), sbbf);
/// back to "cannot prune" for non-equality predicates.
    fn num_containers(&self) -> usize {
    }
        Some(BooleanArray::from(vec![any_may_match]))
    fn contained(&self, column: &Column, values: &HashSet<ScalarValue>) -> Option<BooleanArray> {
/// `PruningStatistics` implementation backed by a single row group's bloom
    fn min_values(&self, _column: &Column) -> Option<ArrayRef> {
        None
//!
        Ok(keep) => {
    rg_idx: usize,
        Err(_) => Ok(false), // evaluation error → don't prune
    /// definitely absent.
                // NOTE: This assumes the query value has the same scale as the
    }
    metadata: &ParquetMetaData,
            ScalarValue::Decimal128(Some(v), _precision, scale) => {
            // Single container: if keep[0] == false, the RG can be pruned.
        // at least one of the values MAY be present; `false` means NONE of
            }
    store: &dyn ObjectStore,
        // Parse the SBBF from the raw bytes (includes header + bitset).
 *
struct BloomFilterStatistics {
        let any_may_match = values.iter().any(|v| Self::check_scalar(sbbf, v));
        1
                let _ = scale; // used only in the comment above
