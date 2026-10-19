        }),
    /// The regression that matters: the fold must return the GLOBAL min/max, not
    #[test]
        _ => None,
    path: &ObjectPath,
    }
        let props = WriterProperties::builder().build();
        }
            }
///
    let schema = metadata.file_metadata().schema_descr();
    filter_min: i64,
/// A too-narrow range would let the coordinator skip a shard that really holds a
    #[tokio::test]
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
        let batch = RecordBatch::try_new(schema, vec![column]).unwrap();
    fn test_bounds_folds_all_row_groups_not_just_first() {
        assert_eq!(
    /// eliminates a shard whose sort column may hold one.
    fn test_bounds_merge_rejects_mixed_kinds() {
                    None => return CanMatchResult::Unknown,
            (bounds.min, bounds.max),
                Arc::new(TimestampSecondArray::from(values.to_vec()))
    /// Non-integer physical types are out of v1 scope — must report absent
            min: 10,
    #[test]
pub const VALUE_KIND_INT32: u8 = 1;
            "OR must be symmetric"
use datafusion::parquet::file::metadata::{ParquetMetaData, ParquetMetaDataReader};
        let mut writer = ArrowWriter::try_new(&mut buf, Arc::clone(&schema), None).unwrap();
        buf
}
}
/// Plain int64s (and timestamps with no logical annotation) stay [`VALUE_KIND_INT64`], a
            None => return CanMatchResult::Unknown,
    /// rather than a bogus range.
        let path = ObjectPath::from("missing.parquet");
        );
    column_name: &str,
async fn read_footer(
            (merged.min, merged.max),
        let schema = Arc::new(Schema::new(vec![Field::new("host", DataType::Utf8, false)]));
            &[1_700_000_000_000_000_000],
}
            max: self.max.max(other.max),
        };
    #[test]
    for i in 0..schema.num_columns() {
        writer.close().unwrap();
        let metadata = metadata_from_bytes(&data);
                    Some(false) => continue,
    let descriptor = schema.column(col_idx);
        // Empty row groups hold no values, so missing statistics here aren't a gap.
/// Unlike [`CanMatchResult`], which may stop at the first hit, this is a **fold**:
            CanMatchResult::No
    // ---- sort bounds (fold) ----
        let data = build_test_parquet(&[100, 200, 300]);
/// Fold min/max of `column_name` by reading the footer via ObjectStore.
/// but scaled 10⁶ apart, so sharing one kind would let the coordinator compare millis
            .unwrap();
pub fn sort_bounds_with_metadata(metadata: &ParquetMetaData, column_name: &str) -> Option<Bounds> {
        writer.close().unwrap();
        let reader = SerializedFileReader::new(Bytes::from(data.to_vec())).unwrap();
        assert!(
        assert!(
pub fn can_match_range_with_metadata(
            .unwrap();
            has_nulls,
            &metadata_from_bytes(&build_timestamp_parquet(
        let metadata = metadata_from_bytes(&data);
    }
use object_store::path::Path as ObjectPath;
        assert_eq!(bounds.max, 1000, "max must come from the THIRD row group");
        assert!(
    column_name: &str,
            has_nulls: true,
            }
    #[test]
fn bounds_from_stats(stats: &Statistics, descriptor: &ColumnDescriptor) -> Option<Bounds> {
/// top-N row, so a partial fold reports absent rather than approximate.
        buf
///
    }
    async fn test_bounds_via_object_store() {
    }
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
}
            value_kind: VALUE_KIND_INT64,
        }
    #[test]
///
    fn test_disjoint_below() {
    let metadata = read_footer(store, path, file_size).await.ok()?;
        use arrow::array::Int32Array;
    use super::*;
            CanMatchResult::Yes
        let merged = a.merge(b).unwrap();
            .await
/// do not renumber. Mirrored by `ShardSortBounds` on the Java side.
            can_match_range_with_metadata(&metadata, "ts", 200, 300),
        assert!(sort_bounds_with_metadata(&metadata, "host").is_none());
        writer.write(&batch).unwrap();
            .unwrap();
        writer.write(&batch).unwrap();
        // after each batch so row-group boundaries are exactly the slices.
    CanMatchResult::No
        _ => VALUE_KIND_INT64,
    }
            arrow::datatypes::TimeUnit::Microsecond,
        let mut buf = Vec::new();
            CanMatchResult::Yes
        },
            let batch = RecordBatch::try_new(
/// every row group of every file has to be visited, or the range isn't shard-wide.
        assert_eq!(
            arrow::datatypes::TimeUnit::Millisecond,
            min: *s.min_opt()?,
        let path = ObjectPath::from("missing.parquet");
    use datafusion::parquet::file::reader::FileReader;
    pub has_nulls: bool,
    #[test]
        let clean = Bounds {
            Some(rg_min <= filter_max && rg_max >= filter_min)
    file_size: usize,
    /// the same shape `date` and `date_nanos` produce.
/// Cache-miss path; works on local disk and S3 alike.
            (100, 600),
        assert_eq!(bounds.min, 100);
        let mut writer = ArrowWriter::try_new(&mut buf, Arc::clone(&schema), None).unwrap();
        let props = WriterProperties::builder().build();
            has_nulls: self.has_nulls || other.has_nulls,
                vec![Arc::new(Int64Array::from(group.to_vec()))],
    path: &ObjectPath,
        let mut buf = Vec::new();
            min: self.min.min(other.min),
            writer.write(&batch).unwrap();
    match stats {
            let rg_min = *s.min_opt()? as i64;
            TimeUnit::MICROS => VALUE_KIND_INT64_MICROS,
        );
            RecordBatch::try_new(schema, vec![Arc::new(Int32Array::from(vec![5, 42]))]).unwrap();
        let metadata = metadata_from_bytes(&data);
                match overlaps {
        Statistics::Int32(s) => Some(Bounds {
        let metadata = metadata_from_bytes(&buf);
            value_kind: VALUE_KIND_INT64,
                Arc::new(TimestampMicrosecondArray::from(values.to_vec()))
        let data = build_nullable_parquet(&[None, None, None]);
/// Narrows a physically-`Int64` column to its logical value domain.
        let path = ObjectPath::from("test.parquet");
            let rg_min = *s.min_opt()?;
                    Some(true) => return CanMatchResult::Yes,
        writer.close().unwrap();
    async fn test_via_store_file_not_found() {
        assert_eq!(result, CanMatchResult::Yes);
    };
    column_name: &str,
        Some(idx) => idx,
        let metadata = metadata_from_bytes(&data);
        let mut buf = Vec::new();
    }
            false,
        )]));
        let mut writer = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
    #[test]
) -> Option<usize> {
        Some(LogicalType::Timestamp { unit, .. }) => match unit {
        assert_eq!(bounds.value_kind, VALUE_KIND_INT32);
/// Core fold: visits EVERY row group, no short-circuit. One row group without usable
    match descriptor.logical_type_ref() {
            arrow::datatypes::TimeUnit::Millisecond => {
        assert!(a.merge(b).is_none());
    let col_idx = match find_column_index(schema, column_name) {
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
    fn build_nullable_parquet(values: &[Option<i64>]) -> Vec<u8> {
    #[tokio::test]
        assert!(
/// Extract min/max from one row group's statistics. Same supported physical types as
    folded
        let schema = Arc::new(Schema::new(vec![Field::new("n", DataType::Int32, false)]));
        let rg = metadata.row_group(rg_idx);
            continue;
        );
fn evaluate_metadata(
    }
    }
        let result =
        assert_eq!(
/// statistics collapses the whole file to `None` — a bound from a subset of row groups
        assert!(
    #[test]
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
use datafusion::parquet::file::statistics::Statistics;
        writer.close().unwrap();
 * SPDX-License-Identifier: Apache-2.0
/// Read parquet footer from ObjectStore using ParquetMetaDataReader.
///
    fn test_bounds_merge_ors_has_nulls() {
    }
        ));
fn check_overlap(stats: &Statistics, filter_min: i64, filter_max: i64) -> Option<bool> {
            bounds.merge(millis).is_none(),
        let metadata = metadata_from_bytes(&data);
        use arrow::array::{
                arrow::datatypes::TimeUnit::Millisecond,
    if num_row_groups == 0 {
        );
    /// fabricate a range (a `0..0` would order the shard first and be wrong).
) -> Option<Bounds> {
pub const VALUE_KIND_INT64_MICROS: u8 = 4;
    Unknown,
        let path = ObjectPath::from("bounds.parquet");
use datafusion::parquet::arrow::async_reader::ParquetObjectReader;
        let data = build_test_parquet(&[100, 200, 300]);
        let metadata = metadata_from_bytes(&data);
/// [`check_overlap`]; anything else yields `None`.
    let mut folded: Option<Bounds> = None;
        let mut writer = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
    }
            )
        let stats = rg.column(col_idx).statistics()?;
                RecordBatch::try_new(Arc::clone(&schema), vec![Arc::new(Int64Array::from(group))])
    /// Guards the millis-vs-nanos bug: both are parquet `Int64`, so a physical-type-only
    /// is what a range comparison needs.
            .is_none());
        match col.statistics() {
    schema: &datafusion::parquet::schema::types::SchemaDescriptor,
    let num_row_groups = metadata.num_row_groups();
        assert_eq!(bounds.max, 300);
        Ok(m) => m,
        ));
            has_nulls: false,
            can_match_range_via_store(Arc::clone(&store), &path, file_size, "ts", 400, 500).await;
    filter_min: i64,
    fn test_exact_boundary() {
        );
        _ => None,
            can_match_range_via_store(Arc::clone(&store), &path, file_size, "ts", 150, 250).await;
    #[test]
 *
        .unwrap();
    fn build_multi_row_group_parquet(groups: &[&[i64]]) -> Vec<u8> {
    filter_max: i64,
    fn metadata_from_bytes(data: &[u8]) -> ParquetMetaData {
}
    }
        let column: arrow::array::ArrayRef = match unit {
        let schema = Arc::new(Schema::new(vec![Field::new(
    }
        assert_eq!(
            min: *s.min_opt()? as i64,
    fn test_bounds_no_nulls_when_all_present() {
    for rg_idx in 0..num_row_groups {
            "nulls on either side must survive the merge"
            value_kind: VALUE_KIND_INT32,
            arrow::datatypes::TimeUnit::Nanosecond => {
            min: 1,
    #[test]
        );
    /// eliminate a shard that could hold a top-ranked null.
use datafusion::parquet::schema::types::ColumnDescriptor;
            "ts",
        );
        );
            CanMatchResult::No
            "millis and nanos must not share a value kind"
        let rg_bounds = bounds_from_stats(stats, &descriptor)?;
    fn test_bounds_unsupported_type() {
    fn build_test_parquet(values: &[i64]) -> Vec<u8> {
            bounds.has_nulls,
    }
/// against nanos. Hence the separate timestamp kinds.
        use arrow::array::StringArray;
        let metadata = metadata_from_bytes(&data);
#[cfg(test)]
            .unwrap();
            .unwrap();
    }
            value_kind: self.value_kind,
//! Can-match evaluation using parquet row-group statistics.
            value_kind: VALUE_KIND_INT64,
}
        buf
/// An all-null column has no min/max, so this returns `None` rather than a made-up range.
    /// One row group per slice in `groups`, so the fold has to visit them all.
            .put(&path, PutPayload::from_bytes(Bytes::from(data)))
        None => return CanMatchResult::Unknown,
            CanMatchResult::Unknown
            dirty.merge(clean).unwrap().has_nulls,
    fold_bounds(&metadata, column_name)
    #[test]
        let mut writer = ArrowWriter::try_new(&mut buf, schema.clone(), None).unwrap();
        );
            None => rg_bounds,
            writer.flush().unwrap();
    fn test_bounds_detects_nulls() {
    }
    }
/// Evaluate can-match using pre-loaded ParquetMetaData (from cache).
                Arc::new(TimestampNanosecondArray::from(values.to_vec()))
            min: 50,
//! Checks whether any row group in a parquet file has column statistics that
        Statistics::Int64(s) => {
pub enum CanMatchResult {
    #[test]
        store
            max: 9,
        assert_eq!(result, CanMatchResult::Unknown);
    use datafusion::parquet::file::properties::WriterProperties;
                let overlaps = check_overlap(stats, filter_min, filter_max);
        );
    /// domain — which is what stops it being compared against a millis column.
            Some(rg_min <= filter_max && rg_max >= filter_min)
    let schema = file_metadata.schema_descr();
            has_nulls: false,
        let batch = RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(values.to_vec()))])
    }
    #[tokio::test]
        );
        let metadata = metadata_from_bytes(&data);
        let file_size = data.len();
    evaluate_metadata(&metadata, column_name, filter_min, filter_max)
    }
    // ---- has_nulls ----
    let has_nulls = stats.null_count_opt().map_or(true, |n| n > 0);
    /// Widens `self` to cover `other`. `None` if they're different value domains,
}
            "fixture must produce multiple row groups"
    }
    filter_max: i64,
    use datafusion::parquet::arrow::ArrowWriter;
        assert_eq!(bounds.min, 100);
    /// One null-bearing row group taints the whole fold: the coordinator must never
        );
            has_nulls: false,
    fn test_bounds_missing_column() {
    #[test]
/// Physical type alone isn't enough: `date` and `date_nanos` are both parquet `Int64`
                &[100],
    use bytes::Bytes;
        }),
}
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
            value_kind: int64_value_kind(descriptor),
//!
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
    }
    let mut reader = ParquetObjectReader::new(store, path.clone()).with_file_size(size);
/// Fold min/max of `column_name` from pre-loaded metadata (cache hit, zero I/O).
            can_match_range_with_metadata(&metadata, "ts", 150, 250),
        if rg.num_rows() == 0 {
///
        assert_eq!(
/// generic integer domain distinct from every timestamp domain.
            let batch =
        };
            writer.write(&batch).unwrap();
            metadata.num_row_groups() > 1,
/// Check if the row-group column statistics overlap with [filter_min, filter_max].
        let mut writer = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
        reader.metadata().clone()
    #[test]
/// Value domain the min/max came from. Part of the Java/Rust wire contract —
                Arc::new(TimestampMillisecondArray::from(values.to_vec()))
        let metadata = metadata_from_bytes(&data);
            "merge must widen in both directions"
fn fold_bounds(metadata: &ParquetMetaData, column_name: &str) -> Option<Bounds> {
        return None;
            "all-null column must yield no bounds, not a fabricated range"
    let file_metadata = metadata.file_metadata();
//! overlap with a given range `[filter_min, filter_max]`. Used by the coordinator
            TimeUnit::MILLIS => VALUE_KIND_INT64_MILLIS,
    fn test_overlaps_yes() {
    No,
    column_name: &str,
pub const VALUE_KIND_INT64_NANOS: u8 = 5;
    /// Nulls do not affect the range: min/max describe the non-null values, which
    use arrow::datatypes::{DataType, Field, Schema};
    /// True when any row group holds a null, or when the null count is unknown. Under
    // ---- value_kind carries the logical timestamp unit ----
        return CanMatchResult::No;
    /// kind would let the coordinator compare values 10⁶ apart and skip the wrong shards.
            let rg_max = *s.max_opt()? as i64;
        let result =
}
        .map_err(|e| format!("metadata read failed: {e}"))
            millis_bounds.value_kind, nanos_bounds.value_kind,
}
            metadata.num_row_groups() > 1,
        )
        );
        );
        }
/// timestamp from a nanosecond one — both are physically `Int64`.
            can_match_range_with_metadata(&metadata, "nonexistent", 0, 1000),
            Some(stats) => {
            let rg_max = *s.max_opt()?;
    fn test_bounds_ignores_nulls_in_range() {
mod tests {
    fn test_bounds_millis_and_nanos_have_distinct_value_kinds() {
    pub min: i64,
    };
) -> Result<ParquetMetaData, String> {
        let nanos = metadata_from_bytes(&build_timestamp_parquet(
            "a column holding a null must report has_nulls"
    }
        assert!(sort_bounds_via_store(store, &path, 100, "ts")
    pub value_kind: u8,
            arrow::datatypes::TimeUnit::Nanosecond,
        let data = build_test_parquet(&[100, 200]);
    }
                Arc::clone(&schema),
    ParquetMetaDataReader::new()
}
    None
        assert_eq!(bounds.min, 100, "min must come from the SECOND row group");
        let mut buf = Vec::new();
    async fn test_via_object_store() {
        };
 * compatible open source license.
pub const VALUE_KIND_INT64: u8 = 2;
            // Nulls on either side make the folded range null-bearing.
        }
/// would be narrower than the truth.
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
    // `true` costs one extra shard scan, a wrong `false` drops rows.
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
        let data = build_nullable_parquet(&[Some(100), None, Some(300)]);
        let col = rg.column(col_idx);
/// Result of a can-match evaluation.
        );
            has_nulls: false,
) -> CanMatchResult {
    }
            .await
    #[test]
    /// the first row group's. `evaluate_metadata` short-circuits here; the fold
            arrow::datatypes::TimeUnit::Microsecond => {
            return None;
        let millis = metadata_from_bytes(&build_timestamp_parquet(
            &[1_700_000_000_000],
    pub fn merge(self, other: Bounds) -> Option<Bounds> {
    evaluate_metadata(metadata, column_name, filter_min, filter_max)
pub async fn can_match_range_via_store(
    /// Shard provably cannot match — prune it.
        let dirty = Bounds {
    if num_row_groups == 0 {
        .await
        let metadata = metadata_from_bytes(&data);
/// Shard-wide min/max of one column.
        writer.close().unwrap();
    file_size: usize,
        let b = Bounds {
    use arrow::array::Int64Array;
        let data = build_multi_row_group_parquet(&[&[500, 600], &[100, 200]]);
            writer.flush().unwrap();
    fn test_bounds_int32_value_kind() {
    /// where a combined range would be meaningless.
/// apart — harmless for ordering, wrong results once shards get skipped on it.
    metadata: &ParquetMetaData,
        });
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
        assert_eq!(bounds.max, 300);
use object_store::ObjectStore;
            TimestampSecondArray,
                }
        };
    }
    #[test]
            "a fully-populated column must report has_nulls == false"
        if self.value_kind != other.value_kind {
        );
        let rg = metadata.row_group(rg_idx);
pub const VALUE_KIND_INT64_MILLIS: u8 = 3;
        assert_eq!(millis_bounds.value_kind, VALUE_KIND_INT64_MILLIS);
    }
            max: 2,
    use arrow::record_batch::RecordBatch;
            TimeUnit::NANOS => VALUE_KIND_INT64_NANOS,
/// Zero I/O — hot path when the metadata cache has the footer.
    // An unknown null count can't prove the column is null-free, so assume nulls: a wrong
    }
            .put(&path, PutPayload::from_bytes(Bytes::from(data)))
fn int64_value_kind(descriptor: &ColumnDescriptor) -> u8 {
        assert_eq!(
        };
    fn test_bounds_plain_int64_keeps_generic_kind() {
        let schema = Arc::new(Schema::new(vec![Field::new("ts", DataType::Int64, false)]));
) -> CanMatchResult {
            "ts",
/// `descriptor` supplies the column's logical type, the only thing separating a millisecond
    }
    metadata: &ParquetMetaData,
            return Some(i);
/*
        }
            }
 * The OpenSearch Contributors require contributions made to
            }
    }
    column_name: &str,
/// Works uniformly on local disk (hot nodes) and S3 (warm nodes).
            min: 0,
        for group in groups {
    }
    let col_idx = find_column_index(schema, column_name)?;
    fold_bounds(metadata, column_name)
        let metadata = metadata_from_bytes(&buf);
impl Bounds {
        let data = build_test_parquet(&[100, 200, 300]);
            "a null in the SECOND row group must taint the fold"
        if schema.column(i).name() == column_name {
            }
        let data = build_test_parquet(&[100, 200]);
            max: 4,
    let num_row_groups = metadata.num_row_groups();
            max: *s.max_opt()?,
    }
        buf
    fn test_bounds_merge_widens_range() {
    use datafusion::parquet::file::serialized_reader::SerializedFileReader;
            (10, 90),
        let a = Bounds {
pub async fn sort_bounds_via_store(
    /// must not.
    }
            .await
    }
/// parquet `Int64`. One kind for both would let the coordinator compare bounds scaled 10⁶
    fn test_bounds_micros_value_kind() {
            millis_bounds.merge(nanos_bounds).is_none(),
            has_nulls,
        let bounds = sort_bounds_via_store(Arc::clone(&store), &path, file_size, "ts")
    path: &ObjectPath,
            max: 90,
            max: 2,
        let data = build_test_parquet(&[100, 200]);
        };
    #[test]
        let mut buf = Vec::new();
        store
        let metadata = metadata_from_bytes(&data);
    /// Unable to determine — treat as Yes (fail-open).
//! to prune shards before fragment dispatch.
        let data = build_test_parquet(&[100, 200, 300]);
    use object_store::{ObjectStoreExt, PutPayload};
        assert_eq!(nanos_bounds.value_kind, VALUE_KIND_INT64_NANOS);
pub struct Bounds {
/// Core evaluation logic shared by both paths.
        Statistics::Int64(s) => Some(Bounds {
        let metadata = metadata_from_bytes(&data);
            )),
        };
        writer.write(&batch).unwrap();
}
            .unwrap();
        let a = Bounds {
        let mut buf = Vec::new();
        let batch =
        let schema = Arc::new(Schema::new(vec![Field::new("ts", DataType::Int64, false)]));
        };
            can_match_range_with_metadata(&metadata, "ts", 400, 500),
        let metadata = metadata_from_bytes(&data);
        assert!(
/// Evaluate can-match by reading the parquet footer via ObjectStore.
    let size = file_size as u64;
        assert_eq!(bounds.value_kind, VALUE_KIND_INT64);
        let data = build_nullable_parquet(&[Some(100), None, Some(300)]);
        assert_eq!(bounds.value_kind, VALUE_KIND_INT64_MICROS);
                    .unwrap();
    #[tokio::test]
    async fn test_bounds_via_store_file_not_found() {
            Some(acc) => acc.merge(rg_bounds)?,
            value_kind: VALUE_KIND_INT64,
/// Find column index by name in the parquet schema.
            "plain int64 must not merge with a millis timestamp"
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
            can_match_range_with_metadata(&metadata, "ts", 0, 50),
        let millis = sort_bounds_with_metadata(
/// `date` writes `Timestamp(MILLIS)` and `date_nanos` writes `Timestamp(NANOS)`, both as
        assert!(sort_bounds_with_metadata(&metadata, "nonexistent").is_none());
            clean.merge(dirty).unwrap().has_nulls,
            "store path must fold too"
}
            max: 60,
    Yes,
    pub max: i64,
        Some(Bounds {
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
        let b = Bounds {
            bounds.has_nulls,
///
        let mut buf = Vec::new();
            min: 1,
            &[1_700_000_000_000_000],
    }
        }
            sort_bounds_with_metadata(&metadata, "ts").is_none(),
        .load_and_finish(&mut reader, size)
        let result = can_match_range_via_store(store, &path, 100, "ts", 0, 100).await;
        let props = WriterProperties::builder().build();
 */
    fn test_disjoint_above() {
        assert!(
    /// An all-null column has no min/max at all. Must report absent rather than
        for group in [vec![Some(1i64), Some(2)], vec![Some(3), None]] {
    match stats {
            DataType::Timestamp(unit, None),
) -> CanMatchResult {
        );
        let millis_bounds = sort_bounds_with_metadata(&millis, "ts").unwrap();
        let batch = RecordBatch::try_new(schema, vec![Arc::new(StringArray::from(vec!["a", "b"]))])
    /// `NULLS FIRST` a null outranks every real value, so the coordinator never
 * this file be licensed under the Apache-2.0 license or a
        writer.write(&batch).unwrap();
        assert!(
        );
        writer.close().unwrap();
        let nanos_bounds = sort_bounds_with_metadata(&nanos, "ts").unwrap();
        let data = build_test_parquet(&[100, 200, 300]);
    }
        folded = Some(match folded {
        }
        assert_eq!(result, CanMatchResult::No);
    store: Arc<dyn ObjectStore>,
        writer.write(&batch).unwrap();
        let schema = Arc::new(Schema::new(vec![Field::new("ts", DataType::Int64, true)]));
    }
    let metadata = match read_footer(store, path, file_size).await {
        // max_row_group_size=1 would split each batch; instead flush explicitly
    #[test]
use datafusion::parquet::basic::{LogicalType, TimeUnit};
        assert_eq!(
    fn test_bounds_all_null_column_reports_absent() {
}
        ));
            value_kind: VALUE_KIND_INT64,
        }
    store: Arc<dyn ObjectStore>,
        let metadata = metadata_from_bytes(&build_timestamp_parquet(
        let schema = Arc::new(Schema::new(vec![Field::new("ts", DataType::Int64, true)]));
    #[test]
            .await
        assert!(
    fn test_bounds_nulls_in_later_row_group_taint_the_fold() {
    }
    }
use std::sync::Arc;
        assert!(
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
        assert_eq!(bounds.value_kind, VALUE_KIND_INT64);
    store: Arc<dyn ObjectStore>,
        let file_size = data.len();
        Statistics::Int32(s) => {
    filter_max: i64,
    #[test]
            bounds.has_nulls == false,
}
        let data = build_test_parquet(&[100, 200, 300]);
            TimestampMicrosecondArray, TimestampMillisecondArray, TimestampNanosecondArray,
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
        let data = build_multi_row_group_parquet(&[&[500, 600], &[100, 200], &[900, 1000]]);
            "fixture must produce multiple row groups to be meaningful"
        writer.close().unwrap();
        })
            "merging across timestamp units must be refused"
    /// Arrow `Timestamp(unit)` writes parquet `Int64` annotated with that logical unit —
    fn test_bounds_single_row_group() {
    filter_min: i64,
            value_kind: VALUE_KIND_INT32,
        assert_ne!(
            arrow::datatypes::TimeUnit::Second => {
    fn test_column_not_found() {
fn find_column_index(
            has_nulls: false,
    #[test]
    }
        let metadata = metadata_from_bytes(&buf);
    /// Shard may match — keep it.
        let bounds = sort_bounds_with_metadata(&metadata, "ts").unwrap();
        assert_eq!((bounds.min, bounds.max), (5, 42));
            min: 3,
        Err(_) => return CanMatchResult::Unknown,
        let bounds = sort_bounds_with_metadata(&metadata, "n").unwrap();
            .unwrap();
        let mut writer = ArrowWriter::try_new(&mut buf, schema.clone(), None).unwrap();
            max: *s.max_opt()? as i64,
    use object_store::memory::InMemory;
        let batch = RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(values.to_vec()))])
    fn build_timestamp_parquet(unit: arrow::datatypes::TimeUnit, values: &[i64]) -> Vec<u8> {
    for rg_idx in 0..num_row_groups {
        let data = build_test_parquet(&[100, 200]);
    /// A null in ANY row group taints the shard-wide fold, even when the first group is clean.
    /// A plain `long` column has no timestamp annotation, so it keeps the generic int64
    file_size: usize,
    }
