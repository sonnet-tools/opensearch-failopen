        };
            .iter()
    fn check_scalar(sbbf: &Sbbf, value: &ScalarValue) -> bool {
                // stored value. If the Parquet column is DECIMAL(10,2) and the
        .row_groups()
    // Call the pruning predicate with our bloom-filter-backed statistics.
            Ok(keep.first() == Some(&false))
}
            }
                // If length is not recorded, we cannot safely read.
        Err(_) => false, // conservative: don't prune on error
 * this file be licensed under the Apache-2.0 license or a
use datafusion::parquet::file::metadata::ParquetMetaData;
            Some(offset) if offset >= 0 => offset as u64,
                // query literal is 1.5 (scale=1, stored as 15), but Parquet
            }
    }
    let literal_cols = predicate.literal_columns();
        let col_idx = match arrow_schema
        None
use std::collections::HashSet;
/// `PruningStatistics` implementation backed by a single row group's bloom
    path: &object_store::path::Path,
        };
        let bf_offset: u64 = match col_chunk.bloom_filter_offset() {
use object_store::{GetOptions, GetRange, ObjectStore};
        {
        Err(_) => Ok(false), // evaluation error → don't prune
            _ => continue, // no bloom filter for this column
    metadata: &ParquetMetaData,
            // Single container: if keep[0] == false, the RG can be pruned.
                // The SBBF hashes the raw bytes that were inserted at write time.
        .get(rg_idx)
/// filters. The `contained()` method is the only one that returns meaningful
            ScalarValue::Binary(Some(b)) | ScalarValue::LargeBinary(Some(b)) => {
            ScalarValue::Float64(Some(v)) => sbbf.check(v),
            ScalarValue::UInt32(Some(v)) => sbbf.check(v),
 *
        let sbbf = self.blooms.get(column.name())?;
}
    arrow_schema: &Arc<Schema>,
            None => continue, // column not in schema → skip
    // Result is a Vec<bool> with one entry per container (we have 1 container).
async fn bloom_prune_rg_inner(
    fn max_values(&self, _column: &Column) -> Option<ArrayRef> {
    arrow_schema: &Arc<Schema>,
    metadata: &ParquetMetaData,
    let stats = BloomFilterStatistics { blooms };
        };
    path: &object_store::path::Path,
    }
}
    }
        // Check if bloom filter metadata is available.
                // if a mismatch occurs we conservatively return `true` (may match).
    }
                continue;
/// Returns `true` if the row group should be PRUNED (skipped), `false` if it
        let col_chunk = rg_meta.column(col_idx);
            ScalarValue::Utf8(Some(s)) | ScalarValue::LargeUtf8(Some(s)) => sbbf.check(s.as_str()),
//! is skipped entirely — saving the FFM round-trip.
    let rg_meta = metadata
                // cast coercion should normalize scales before reaching here, but
 * compatible open source license.
    fn num_containers(&self) -> usize {
        // Parse the SBBF from the raw bytes (includes header + bitset).
    /// definitely absent.
        // Read the bloom filter bytes from the object store.
    predicate: &PruningPredicate,
use datafusion::arrow::datatypes::Schema;
        1
//!
        let any_may_match = values.iter().any(|v| Self::check_scalar(sbbf, v));
use datafusion::common::{Column, ScalarValue};
    // equality constraints (e.g., col = 'value').
                // NOTE: This assumes the query value has the same scale as the
    fn row_counts(&self) -> Option<ArrayRef> {
                //
    blooms: std::collections::HashMap<String, Sbbf>,
            range: Some(GetRange::Bounded(std::ops::Range {
    fn min_values(&self, _column: &Column) -> Option<ArrayRef> {
    match predicate.prune(&stats) {
    if blooms.is_empty() {
        let bf_length: u64 = match col_chunk.bloom_filter_length() {
/// (conservative: do not prune).
/// should be kept (bloom filter says values may be present, or bloom filter is
    fn null_counts(&self, _column: &Column) -> Option<ArrayRef> {
        blooms.insert(col_name.clone(), sbbf);
        Ok(keep) => {
                sbbf.check(bytes.as_slice())
        let opts = GetOptions {
pub async fn bloom_prune_rg(
        Ok(should_prune) => should_prune,
    }
        // Find the parquet column index for this column name.
    }
    match bloom_prune_rg_inner(store, path, metadata, arrow_schema, rg_idx, predicate).await {
    // `literal_columns` returns columns where the predicate has literal
/// unavailable).
                let bytes = v.to_be_bytes();
                // stored it as 150 (scale=2), the byte representations differ
        return Ok(false); // no bloom filters available → cannot prune
            // Null or unsupported type → conservatively say "may be present"
            })),
    /// Column name → parsed SBBF for this row group.
            _ => {
    fn contained(&self, column: &Column, values: &HashSet<ScalarValue>) -> Option<BooleanArray> {
                // For Decimal128 the parquet writer uses the i128 in big-endian
    }
            Some(idx) => idx,
            _ => true,
        match value {
/// back to "cannot prune" for non-equality predicates.
        // Get the column chunk metadata for this column in this row group.
        let sbbf = Sbbf::from_bytes(&bytes)?;
        // For the single-container case (1 row group), we return a
//!
/// Any error (missing bloom filter, I/O error, parse error) results in `false`
        .ok_or("row group index out of range")?;
        None
impl PruningStatistics for BloomFilterStatistics {
        // at least one of the values MAY be present; `false` means NONE of
        None
    // Identify which columns participate in the predicate's equality checks.
            ..Default::default()
        }
use datafusion::arrow::array::{ArrayRef, BooleanArray};
    predicate: &PruningPredicate,
    rg_idx: usize,
    }
use datafusion::parquet::bloom_filter::Sbbf;
        let get_result = store.get_opts(path, opts).await?;
 */
impl BloomFilterStatistics {
            }
            Some(len) if len > 0 => len as u64,
/*
/// data — all other methods return `None` so `PruningPredicate::prune` falls
//! that match equality predicates. Runs AFTER page-level min/max pruning (free,
use datafusion::physical_optimizer::pruning::{PruningPredicate, PruningStatistics};
        }
        };
                // and the bloom filter will return a false negative. DataFusion's
        Some(BooleanArray::from(vec![any_may_match]))
//! in-memory) and BEFORE the expensive FFM collector call (Lucene, ~1-5 ms).
///
    }
                sbbf.check(b.as_slice())
            ScalarValue::Float32(Some(v)) => sbbf.check(v),
    /// Returns `true` if the value MAY be present, `false` if it is
    }
        None
///
        let bytes = get_result.bytes().await?;
            .position(|f| f.name() == col_name)
struct BloomFilterStatistics {
            ScalarValue::Decimal128(Some(v), _precision, scale) => {
                // Some parquet writers don't record length — skip this column.
 * SPDX-License-Identifier: Apache-2.0
use std::sync::Arc;
                start: bf_offset,
    /// Check whether a scalar value is contained in the bloom filter.
    store: &dyn ObjectStore,
    // `true` means "keep", `false` means "can prune".
            ScalarValue::Int32(Some(v)) => sbbf.check(v),
//! Uses the Parquet bloom filter (SBBF — Split Block Bloom Filter) embedded in
            .fields()
}
//! If the bloom filter proves absence for all equality predicates, the row group
) -> Result<bool, Box<dyn std::error::Error + Send + Sync>> {
                let _ = scale; // used only in the comment above
            ScalarValue::UInt64(Some(v)) => sbbf.check(v),
    if literal_cols.is_empty() {
        // the values can be present (definite absence).
/// Attempt to prune a single row group using bloom filters.
    for col_name in &literal_cols {
    rg_idx: usize,
    }
            ScalarValue::Int64(Some(v)) => sbbf.check(v),
//! the file footer to decide whether a row group can possibly contain values
            ScalarValue::Boolean(Some(v)) => sbbf.check(v),
//! Bloom filter pruning for indexed parquet reads.
                // Parquet stores Decimal as fixed-length byte array (big-endian).
                // byte representation (16 bytes).
}
        // single-element BooleanArray. `true` means the bloom filter says
 * The OpenSearch Contributors require contributions made to
                end: bf_offset + bf_length,
    let mut blooms = std::collections::HashMap::new();
) -> bool {
    store: &dyn ObjectStore,
        return Ok(false); // no equality predicates → cannot bloom-prune
    }
