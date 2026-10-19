    CanMatchResult::No
    fn test_bounds_unsupported_type() {
        );
        let metadata = metadata_from_bytes(&build_timestamp_parquet(
        Statistics::Int64(s) => Some(Bounds {
    let col_idx = match find_column_index(schema, column_name) {
        return CanMatchResult::No;
    column_name: &str,
            &[1_700_000_000_000],
            "all-null column must yield no bounds, not a fabricated range"
 * this file be licensed under the Apache-2.0 license or a
    let metadata = read_footer(store, path, file_size).await.ok()?;
    }
        assert_eq!(bounds.value_kind, VALUE_KIND_INT64);
        assert_eq!(nanos_bounds.value_kind, VALUE_KIND_INT64_NANOS);
        let data = build_test_parquet(&[100, 200, 300]);
            max: 90,
pub const VALUE_KIND_INT32: u8 = 1;
        }),
            value_kind: int64_value_kind(descriptor),
                    Some(true) => return CanMatchResult::Yes,
    async fn test_bounds_via_object_store() {
    let file_metadata = metadata.file_metadata();
        store
pub fn sort_bounds_with_metadata(metadata: &ParquetMetaData, column_name: &str) -> Option<Bounds> {
            value_kind: VALUE_KIND_INT64,
        let schema = Arc::new(Schema::new(vec![Field::new("ts", DataType::Int64, true)]));
    /// One null-bearing row group taints the whole fold: the coordinator must never
        assert_eq!(bounds.min, 100);
    use object_store::memory::InMemory;
/// Extract min/max from one row group's statistics. Same supported physical types as
        .load_and_finish(&mut reader, size)
            has_nulls: false,
        assert_ne!(
            arrow::datatypes::TimeUnit::Microsecond => {
    };
            sort_bounds_with_metadata(&metadata, "ts").is_none(),
        }),
        assert!(sort_bounds_via_store(store, &path, 100, "ts")
    }
            Some(rg_min <= filter_max && rg_max >= filter_min)
//! Can-match evaluation using parquet row-group statistics.
            .await
) -> Option<Bounds> {
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
        let result =
/// timestamp from a nanosecond one — both are physically `Int64`.
            "a column holding a null must report has_nulls"
/*
            has_nulls: false,
    async fn test_via_object_store() {
            min: self.min.min(other.min),
        assert!(
/// Result of a can-match evaluation.
impl Bounds {
        // max_row_group_size=1 would split each batch; instead flush explicitly
//! to prune shards before fragment dispatch.
        for group in groups {
        }
    }
/// An all-null column has no min/max, so this returns `None` rather than a made-up range.
        let bounds = sort_bounds_via_store(Arc::clone(&store), &path, file_size, "ts")
/// Fold min/max of `column_name` from pre-loaded metadata (cache hit, zero I/O).
    filter_max: i64,
    No,
    if num_row_groups == 0 {
        return None;
    #[tokio::test]
    }
    }
/// every row group of every file has to be visited, or the range isn't shard-wide.
        let millis = sort_bounds_with_metadata(
use datafusion::parquet::basic::{LogicalType, TimeUnit};
    for i in 0..schema.num_columns() {
    fn metadata_from_bytes(data: &[u8]) -> ParquetMetaData {
    }
                Arc::clone(&schema),
            bounds.merge(millis).is_none(),
    /// must not.
/// Physical type alone isn't enough: `date` and `date_nanos` are both parquet `Int64`
            &[1_700_000_000_000_000],
    }
        writer.close().unwrap();
pub struct Bounds {
fn check_overlap(stats: &Statistics, filter_min: i64, filter_max: i64) -> Option<bool> {
        )
    // An unknown null count can't prove the column is null-free, so assume nulls: a wrong
            .unwrap();
    }
        if rg.num_rows() == 0 {
    path: &ObjectPath,
        );
/// Plain int64s (and timestamps with no logical annotation) stay [`VALUE_KIND_INT64`], a
        let mut writer = ArrowWriter::try_new(&mut buf, Arc::clone(&schema), None).unwrap();
    Yes,
    file_size: usize,
        buf
        )]));
        };
    use datafusion::parquet::arrow::ArrowWriter;
        let metadata = metadata_from_bytes(&data);
            min: 50,
        assert_eq!(result, CanMatchResult::Unknown);
                    .unwrap();
            .unwrap();
    /// Nulls do not affect the range: min/max describe the non-null values, which
/// Fold min/max of `column_name` by reading the footer via ObjectStore.
            max: 9,
            "merging across timestamp units must be refused"
        let mut buf = Vec::new();
    #[test]
use datafusion::parquet::file::statistics::Statistics;
    }
        Statistics::Int64(s) => {
            metadata.num_row_groups() > 1,
pub fn can_match_range_with_metadata(
    store: Arc<dyn ObjectStore>,
        let metadata = metadata_from_bytes(&data);
    fn build_nullable_parquet(values: &[Option<i64>]) -> Vec<u8> {
/// Evaluate can-match by reading the parquet footer via ObjectStore.
        let data = build_multi_row_group_parquet(&[&[500, 600], &[100, 200], &[900, 1000]]);
///
        let batch =
        writer.write(&batch).unwrap();
        },
            has_nulls,
        assert!(
    }
    };
        ));
    #[test]
    /// fabricate a range (a `0..0` would order the shard first and be wrong).
        reader.metadata().clone()
/// Read parquet footer from ObjectStore using ParquetMetaDataReader.
    #[test]
                Arc::new(TimestampSecondArray::from(values.to_vec()))
            CanMatchResult::Yes
            max: *s.max_opt()?,
    use super::*;
        writer.write(&batch).unwrap();
fn evaluate_metadata(
use datafusion::parquet::file::metadata::{ParquetMetaData, ParquetMetaDataReader};
        let reader = SerializedFileReader::new(Bytes::from(data.to_vec())).unwrap();
    let col_idx = find_column_index(schema, column_name)?;
) -> Result<ParquetMetaData, String> {
        let metadata = metadata_from_bytes(&buf);
    }
        let millis_bounds = sort_bounds_with_metadata(&millis, "ts").unwrap();
        let b = Bounds {
        };
            can_match_range_with_metadata(&metadata, "nonexistent", 0, 1000),
        assert_eq!(result, CanMatchResult::No);
        assert!(
}
        assert_eq!(
    pub value_kind: u8,
        assert!(
            bounds.has_nulls == false,
        }
            let rg_min = *s.min_opt()? as i64;
        let props = WriterProperties::builder().build();
    for rg_idx in 0..num_row_groups {
        _ => None,
            (bounds.min, bounds.max),
        buf
    let num_row_groups = metadata.num_row_groups();
}
    }
/// do not renumber. Mirrored by `ShardSortBounds` on the Java side.
    }
            DataType::Timestamp(unit, None),
        let path = ObjectPath::from("missing.parquet");
            millis_bounds.merge(nanos_bounds).is_none(),
        assert!(
    #[test]
    /// Non-integer physical types are out of v1 scope — must report absent
/// would be narrower than the truth.
        assert_eq!(bounds.max, 300);
            can_match_range_with_metadata(&metadata, "ts", 150, 250),
/// apart — harmless for ordering, wrong results once shards get skipped on it.
    path: &ObjectPath,
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
async fn read_footer(
pub enum CanMatchResult {
        });
        };
    folded
            let batch =
/// Check if the row-group column statistics overlap with [filter_min, filter_max].
        .await
        assert!(
            )
    /// kind would let the coordinator compare values 10⁶ apart and skip the wrong shards.
///
        );
                    None => return CanMatchResult::Unknown,
pub const VALUE_KIND_INT64_MILLIS: u8 = 3;
}
            let batch = RecordBatch::try_new(
            .await
    fn test_bounds_plain_int64_keeps_generic_kind() {
            max: *s.max_opt()? as i64,
    }
            (100, 600),
            can_match_range_with_metadata(&metadata, "ts", 400, 500),
                Arc::new(TimestampMillisecondArray::from(values.to_vec()))
            arrow::datatypes::TimeUnit::Microsecond,
    pub max: i64,
            min: *s.min_opt()?,
        .map_err(|e| format!("metadata read failed: {e}"))
    #[test]
        let data = build_test_parquet(&[100, 200, 300]);
#[cfg(test)]
        );
    }
        let path = ObjectPath::from("bounds.parquet");
        }
            has_nulls: false,
    for rg_idx in 0..num_row_groups {
        let schema = Arc::new(Schema::new(vec![Field::new(
        let metadata = metadata_from_bytes(&data);
use std::sync::Arc;
    /// `NULLS FIRST` a null outranks every real value, so the coordinator never
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
    file_size: usize,
    match descriptor.logical_type_ref() {
    filter_min: i64,
                arrow::datatypes::TimeUnit::Millisecond,
    evaluate_metadata(&metadata, column_name, filter_min, filter_max)
            has_nulls: false,
) -> CanMatchResult {
        writer.write(&batch).unwrap();
    schema: &datafusion::parquet::schema::types::SchemaDescriptor,
use object_store::ObjectStore;
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
        Ok(m) => m,
            "ts",
        assert!(a.merge(b).is_none());
            "plain int64 must not merge with a millis timestamp"
pub const VALUE_KIND_INT64_NANOS: u8 = 5;
}
 * The OpenSearch Contributors require contributions made to
        writer.close().unwrap();
            min: 10,
        );
    }
        let mut buf = Vec::new();
    // `true` costs one extra shard scan, a wrong `false` drops rows.
    fn test_bounds_nulls_in_later_row_group_taint_the_fold() {
/// against nanos. Hence the separate timestamp kinds.
        assert_eq!(bounds.max, 1000, "max must come from the THIRD row group");
            continue;
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
    fn test_column_not_found() {
}
            metadata.num_row_groups() > 1,
    /// Widens `self` to cover `other`. `None` if they're different value domains,
            max: 4,
            (10, 90),
        let mut buf = Vec::new();
        folded = Some(match folded {
            max: self.max.max(other.max),
            min: 3,
        writer.close().unwrap();
            Some(acc) => acc.merge(rg_bounds)?,
/// A too-narrow range would let the coordinator skip a shard that really holds a
        let metadata = metadata_from_bytes(&data);
    /// eliminates a shard whose sort column may hold one.
        let rg_bounds = bounds_from_stats(stats, &descriptor)?;
    fn test_bounds_single_row_group() {
    }
        assert_eq!(bounds.value_kind, VALUE_KIND_INT64_MICROS);
        };
                RecordBatch::try_new(Arc::clone(&schema), vec![Arc::new(Int64Array::from(group))])
}
    /// A plain `long` column has no timestamp annotation, so it keeps the generic int64
        let data = build_test_parquet(&[100, 200]);
}
        let column: arrow::array::ArrayRef = match unit {
        assert!(
            .unwrap();
    column_name: &str,
        let mut buf = Vec::new();
        let metadata = metadata_from_bytes(&data);
    #[test]
/// Narrows a physically-`Int64` column to its logical value domain.
            min: 0,
            "merge must widen in both directions"
    #[tokio::test]
    }
        let data = build_test_parquet(&[100, 200]);
        let data = build_multi_row_group_parquet(&[&[500, 600], &[100, 200]]);
        assert_eq!(
            "OR must be symmetric"
        assert_eq!(
    let mut folded: Option<Bounds> = None;
    /// Arrow `Timestamp(unit)` writes parquet `Int64` annotated with that logical unit —
    #[test]
            CanMatchResult::Unknown
    #[tokio::test]
        let metadata = metadata_from_bytes(&data);
//!
            return Some(i);
        writer.write(&batch).unwrap();
    /// eliminate a shard that could hold a top-ranked null.
        assert_eq!(result, CanMatchResult::Yes);
            "nulls on either side must survive the merge"
}
    }
        writer.close().unwrap();
/// Shard-wide min/max of one column.
            .unwrap();
pub const VALUE_KIND_INT64_MICROS: u8 = 4;
        let a = Bounds {
        let batch = RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(values.to_vec()))])
            arrow::datatypes::TimeUnit::Millisecond => {
        let metadata = metadata_from_bytes(&data);
        );
    metadata: &ParquetMetaData,
            TimestampSecondArray,
        assert_eq!(
            TimestampMicrosecondArray, TimestampMillisecondArray, TimestampNanosecondArray,
    Unknown,
    }
            let rg_min = *s.min_opt()?;
    }
    use arrow::array::Int64Array;
        assert_eq!(bounds.max, 300);
    let has_nulls = stats.null_count_opt().map_or(true, |n| n > 0);
    fold_bounds(&metadata, column_name)
            arrow::datatypes::TimeUnit::Millisecond,
        let col = rg.column(col_idx);
            can_match_range_with_metadata(&metadata, "ts", 0, 50),
    fn build_multi_row_group_parquet(groups: &[&[i64]]) -> Vec<u8> {
            &metadata_from_bytes(&build_timestamp_parquet(
        use arrow::array::{
}
    #[test]
        let metadata = metadata_from_bytes(&data);
    /// is what a range comparison needs.
    use object_store::{ObjectStoreExt, PutPayload};
        };
fn bounds_from_stats(stats: &Statistics, descriptor: &ColumnDescriptor) -> Option<Bounds> {
//! Checks whether any row group in a parquet file has column statistics that
fn find_column_index(
    fn test_bounds_ignores_nulls_in_range() {
    /// rather than a bogus range.
    let mut reader = ParquetObjectReader::new(store, path.clone()).with_file_size(size);
/// Find column index by name in the parquet schema.
    }
            None => rg_bounds,
use datafusion::parquet::schema::types::ColumnDescriptor;
    // ---- has_nulls ----
    use datafusion::parquet::file::serialized_reader::SerializedFileReader;
    /// where a combined range would be meaningless.
mod tests {
            TimeUnit::MILLIS => VALUE_KIND_INT64_MILLIS,
            "ts",
    /// Unable to determine — treat as Yes (fail-open).
///
    #[test]
pub async fn can_match_range_via_store(
    filter_min: i64,
    #[test]
    column_name: &str,
        );
        let props = WriterProperties::builder().build();
            (merged.min, merged.max),
    /// domain — which is what stops it being compared against a millis column.
    let schema = metadata.file_metadata().schema_descr();
            value_kind: VALUE_KIND_INT64,
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
    let descriptor = schema.column(col_idx);
) -> Option<usize> {
        let metadata = metadata_from_bytes(&data);
                match overlaps {
    fn build_timestamp_parquet(unit: arrow::datatypes::TimeUnit, values: &[i64]) -> Vec<u8> {
}
    #[test]
        assert_eq!(
    }
            writer.write(&batch).unwrap();
            None => return CanMatchResult::Unknown,
        let data = build_test_parquet(&[100, 200]);
        Some(idx) => idx,
) -> CanMatchResult {
        Err(_) => return CanMatchResult::Unknown,
}
        );
/// parquet `Int64`. One kind for both would let the coordinator compare bounds scaled 10⁶
fn fold_bounds(metadata: &ParquetMetaData, column_name: &str) -> Option<Bounds> {
            .put(&path, PutPayload::from_bytes(Bytes::from(data)))
    pub has_nulls: bool,
    }
        );
        let mut writer = ArrowWriter::try_new(&mut buf, Arc::clone(&schema), None).unwrap();
            )),
            value_kind: VALUE_KIND_INT64,
            Some(stats) => {
    None
    fn test_bounds_folds_all_row_groups_not_just_first() {
    fn test_bounds_merge_ors_has_nulls() {
        let schema = Arc::new(Schema::new(vec![Field::new("ts", DataType::Int64, false)]));
    filter_min: i64,
            has_nulls,
    }
        store
    let size = file_size as u64;
/// Core fold: visits EVERY row group, no short-circuit. One row group without usable
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
    }
            millis_bounds.value_kind, nanos_bounds.value_kind,
    fn test_bounds_millis_and_nanos_have_distinct_value_kinds() {
    fn test_bounds_micros_value_kind() {
    fn test_overlaps_yes() {
    /// the same shape `date` and `date_nanos` produce.
        let metadata = metadata_from_bytes(&buf);
        if self.value_kind != other.value_kind {
        let mut buf = Vec::new();
    fn test_bounds_all_null_column_reports_absent() {
            min: 1,
    #[tokio::test]
    let metadata = match read_footer(store, path, file_size).await {
            min: 1,
        }
        }
///
                Arc::new(TimestampMicrosecondArray::from(values.to_vec()))
        let stats = rg.column(col_idx).statistics()?;
        ));
        );
    /// Shard provably cannot match — prune it.
    }
    store: Arc<dyn ObjectStore>,
            let rg_max = *s.max_opt()?;
    evaluate_metadata(metadata, column_name, filter_min, filter_max)
        );
    }
/// generic integer domain distinct from every timestamp domain.
            CanMatchResult::No
            .await
            can_match_range_via_store(Arc::clone(&store), &path, file_size, "ts", 400, 500).await;
        let data = build_nullable_parquet(&[None, None, None]);
        let data = build_test_parquet(&[100, 200, 300]);
 *
    filter_max: i64,
        use arrow::array::StringArray;
fn int64_value_kind(descriptor: &ColumnDescriptor) -> u8 {
        let schema = Arc::new(Schema::new(vec![Field::new("n", DataType::Int32, false)]));
        assert_eq!(bounds.value_kind, VALUE_KIND_INT32);
        let metadata = metadata_from_bytes(&data);
        assert!(
            max: 2,
        Statistics::Int32(s) => Some(Bounds {
        let batch = RecordBatch::try_new(schema, vec![column]).unwrap();
            max: 60,
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
/// Cache-miss path; works on local disk and S3 alike.
            clean.merge(dirty).unwrap().has_nulls,
        }
            max: 2,
        let a = Bounds {
        Statistics::Int32(s) => {
        let props = WriterProperties::builder().build();
            false,
/// Zero I/O — hot path when the metadata cache has the footer.
        );
    match stats {
        };
    #[test]
            arrow::datatypes::TimeUnit::Second => {
        );
        // Empty row groups hold no values, so missing statistics here aren't a gap.
    fn test_bounds_int32_value_kind() {
            &[1_700_000_000_000_000_000],
    /// One row group per slice in `groups`, so the fold has to visit them all.
            can_match_range_via_store(Arc::clone(&store), &path, file_size, "ts", 150, 250).await;
    async fn test_bounds_via_store_file_not_found() {
 * compatible open source license.
            let rg_max = *s.max_opt()? as i64;
}
        let path = ObjectPath::from("test.parquet");
        let millis = metadata_from_bytes(&build_timestamp_parquet(
        let dirty = Bounds {
        assert!(
        );
        for group in [vec![Some(1i64), Some(2)], vec![Some(3), None]] {
            arrow::datatypes::TimeUnit::Nanosecond => {
        .unwrap();
        let metadata = metadata_from_bytes(&data);
    fn test_bounds_detects_nulls() {
        let mut writer = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
            .is_none());
        _ => None,
        buf
        let mut writer = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
    filter_max: i64,
            Some(rg_min <= filter_max && rg_max >= filter_min)
            return None;
        use arrow::array::Int32Array;
        let result =
            "millis and nanos must not share a value kind"
        writer.write(&batch).unwrap();
        assert!(sort_bounds_with_metadata(&metadata, "host").is_none());
        );
use datafusion::parquet::arrow::async_reader::ParquetObjectReader;
        let bounds = sort_bounds_with_metadata(&metadata, "n").unwrap();
        let schema = Arc::new(Schema::new(vec![Field::new("ts", DataType::Int64, false)]));
        );
/// Works uniformly on local disk (hot nodes) and S3 (warm nodes).
    fn test_bounds_missing_column() {
        let data = build_test_parquet(&[100, 200, 300]);
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
pub async fn sort_bounds_via_store(
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
/// Evaluate can-match using pre-loaded ParquetMetaData (from cache).
    use datafusion::parquet::file::reader::FileReader;
    // ---- sort bounds (fold) ----
    use datafusion::parquet::file::properties::WriterProperties;
                    Some(false) => continue,
    #[test]
use object_store::path::Path as ObjectPath;
            "a null in the SECOND row group must taint the fold"
        buf
    use arrow::record_batch::RecordBatch;
/// statistics collapses the whole file to `None` — a bound from a subset of row groups
    pub fn merge(self, other: Bounds) -> Option<Bounds> {
    #[test]
        }
    /// Shard may match — keep it.
            .unwrap();
    /// An all-null column has no min/max at all. Must report absent rather than
            writer.write(&batch).unwrap();
            RecordBatch::try_new(schema, vec![Arc::new(Int32Array::from(vec![5, 42]))]).unwrap();
    store: Arc<dyn ObjectStore>,
            // Nulls on either side make the folded range null-bearing.
            TimeUnit::MICROS => VALUE_KIND_INT64_MICROS,
        Some(Bounds {
        );
        let data = build_nullable_parquet(&[Some(100), None, Some(300)]);
    /// the first row group's. `evaluate_metadata` short-circuits here; the fold
    fn test_bounds_merge_rejects_mixed_kinds() {
    pub min: i64,
        let data = build_test_parquet(&[100, 200, 300]);
            arrow::datatypes::TimeUnit::Nanosecond,
    #[test]
    metadata: &ParquetMetaData,
                vec![Arc::new(Int64Array::from(group.to_vec()))],
        assert_eq!((bounds.min, bounds.max), (5, 42));
    #[test]
            value_kind: VALUE_KIND_INT64,
    column_name: &str,
///
    #[test]
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
    }
    fold_bounds(metadata, column_name)
                &[100],
}
    /// True when any row group holds a null, or when the null count is unknown. Under
                let overlaps = check_overlap(stats, filter_min, filter_max);
        })
        let rg = metadata.row_group(rg_idx);
    if num_row_groups == 0 {
) -> CanMatchResult {
        );
            }
            has_nulls: self.has_nulls || other.has_nulls,
        };
        ));
/// Core evaluation logic shared by both paths.
            .await
        let b = Bounds {
            dirty.merge(clean).unwrap().has_nulls,
        let batch = RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(values.to_vec()))])
    fn test_bounds_no_nulls_when_all_present() {
/// Unlike [`CanMatchResult`], which may stop at the first hit, this is a **fold**:
    #[test]
            min: *s.min_opt()? as i64,
        let batch = RecordBatch::try_new(schema, vec![Arc::new(StringArray::from(vec!["a", "b"]))])
            }
        let rg = metadata.row_group(rg_idx);
    async fn test_via_store_file_not_found() {
            has_nulls: true,
        let nanos_bounds = sort_bounds_with_metadata(&nanos, "ts").unwrap();
    }
    use arrow::datatypes::{DataType, Field, Schema};
            value_kind: VALUE_KIND_INT32,
 */
pub const VALUE_KIND_INT64: u8 = 2;
    #[test]
    let num_row_groups = metadata.num_row_groups();
        Some(LogicalType::Timestamp { unit, .. }) => match unit {
            writer.flush().unwrap();
    /// Guards the millis-vs-nanos bug: both are parquet `Int64`, so a physical-type-only
        writer.close().unwrap();
            bounds.has_nulls,
        assert!(sort_bounds_with_metadata(&metadata, "nonexistent").is_none());
            "store path must fold too"
    ParquetMetaDataReader::new()
        // after each batch so row-group boundaries are exactly the slices.
        if schema.column(i).name() == column_name {
        let schema = Arc::new(Schema::new(vec![Field::new("host", DataType::Utf8, false)]));
            value_kind: VALUE_KIND_INT32,
    path: &ObjectPath,
    fn test_exact_boundary() {
            .put(&path, PutPayload::from_bytes(Bytes::from(data)))
                Arc::new(TimestampNanosecondArray::from(values.to_vec()))
}
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
        assert!(
    file_size: usize,
        let mut writer = ArrowWriter::try_new(&mut buf, schema.clone(), None).unwrap();
    }
    }
                }
            "fixture must produce multiple row groups to be meaningful"
        let data = build_test_parquet(&[100, 200]);
        let file_size = data.len();
        };
            "fixture must produce multiple row groups"
        let file_size = data.len();
        let result = can_match_range_via_store(store, &path, 100, "ts", 0, 100).await;
        assert_eq!(bounds.value_kind, VALUE_KIND_INT64);
        assert_eq!(bounds.min, 100);
            CanMatchResult::Yes
            bounds.has_nulls,
            "a fully-populated column must report has_nulls == false"
            }
    use bytes::Bytes;
        let mut buf = Vec::new();
        None => return CanMatchResult::Unknown,
            can_match_range_with_metadata(&metadata, "ts", 200, 300),
    /// A null in ANY row group taints the shard-wide fold, even when the first group is clean.
        let data = build_test_parquet(&[100, 200, 300]);
            TimeUnit::NANOS => VALUE_KIND_INT64_NANOS,
        let mut buf = Vec::new();
            value_kind: VALUE_KIND_INT64,
        match col.statistics() {
        let clean = Bounds {
        assert_eq!(
        assert_eq!(
//! overlap with a given range `[filter_min, filter_max]`. Used by the coordinator
        let mut writer = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
 * SPDX-License-Identifier: Apache-2.0
            .unwrap();
        }
        assert_eq!(millis_bounds.value_kind, VALUE_KIND_INT64_MILLIS);
    fn test_disjoint_above() {
            has_nulls: false,
    fn test_bounds_merge_widens_range() {
    #[test]
        let data = build_nullable_parquet(&[Some(100), None, Some(300)]);
/// top-N row, so a partial fold reports absent rather than approximate.
    }
        _ => VALUE_KIND_INT64,
        let metadata = metadata_from_bytes(&data);
/// `descriptor` supplies the column's logical type, the only thing separating a millisecond
            .unwrap();
        writer.close().unwrap();
        let mut writer = ArrowWriter::try_new(&mut buf, schema.clone(), None).unwrap();
    }
            CanMatchResult::No
        let nanos = metadata_from_bytes(&build_timestamp_parquet(
        let schema = Arc::new(Schema::new(vec![Field::new("ts", DataType::Int64, true)]));
/// Value domain the min/max came from. Part of the Java/Rust wire contract —
        let metadata = metadata_from_bytes(&data);
        assert_eq!(bounds.min, 100, "min must come from the SECOND row group");
    }
    }
    #[test]
    match stats {
/// `date` writes `Timestamp(MILLIS)` and `date_nanos` writes `Timestamp(NANOS)`, both as
        writer.close().unwrap();
}
    }
///
            writer.flush().unwrap();
            }
        let merged = a.merge(b).unwrap();
/// but scaled 10⁶ apart, so sharing one kind would let the coordinator compare millis
    /// The regression that matters: the fold must return the GLOBAL min/max, not
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
    let schema = file_metadata.schema_descr();
    }
    }
/// [`check_overlap`]; anything else yields `None`.
    // ---- value_kind carries the logical timestamp unit ----
    column_name: &str,
            value_kind: self.value_kind,
        let metadata = metadata_from_bytes(&buf);
    fn test_disjoint_below() {
    fn build_test_parquet(values: &[i64]) -> Vec<u8> {
            }
        let path = ObjectPath::from("missing.parquet");
