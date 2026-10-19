        );
 * compatible open source license.
    // the rows as ScalarValues. We can't use arrow::compute::min/max directly
    }
fn debug_assert_footer_generation_matches_catalog(
        let mut row_groups = Vec::new();
        let v = match ScalarValue::try_from_array(&*mins, i) {
    if file_schema.index_of(lead_field).is_err() {
            Field::new("score", DataType::Int32, false),
    /// (apache/datafusion#6629). Assert both orderings produce
/// Build `SegmentFileInfo` from the shard's object metas.
    }
                None => return (None, None),
            return;
            dir.path(),
        footer_gen, catalog_generation,
///   written before that field existed),
        assert!(
        };
            dir.path(),
use super::stream::RowGroupInfo;
            None => (None, None),
        .unwrap();
            &gens,
        let p1 = write_parquet(
            "a.parquet",
            arrow_schema: file_schema,
        let schema = Arc::new(Schema::new(vec![
            "parquet footer `{}` has no value (file={})",
                Arc::new(StringArray::from(vec!["x"])),
            .iter()
            Field::new("c", DataType::Int32, true),
        let store: Arc<dyn ObjectStore> = Arc::new(LocalFileSystem::new());
    // ScalarValue's PartialOrd handles all the supported types we'd see in a
        assert_eq!(merged.fields().len(), 2);
/// must have the same length.
    if object_metas.len() != writer_generations.len() {
/// (skip_metadata, coerce_int96, binary_as_string, force_view_types,
        let result = build_segments(
        "parquet footer writer_generation ({}) disagrees with catalog ({}) for file {}",
        let p1 = write_parquet(
        let metas = object_metas(store.as_ref(), &[p0, p1]).await;
    }
//!
        // regardless of schema derivation. The file_metadata_cache on the
///
        .await
            fields_ab, fields_ba,
            &[],
    }
            "b.parquet",
        let fields_ba: Vec<&str> = schema_ba
        let p0 = write_parquet(
) -> Result<(Vec<SegmentFileInfo>, arrow::datatypes::SchemaRef), String> {
        .await
            Field::new("a", DataType::Utf8, false),
            Field::new("score", DataType::Int32, false),
            .collect();
        assert_eq!(segments.len(), 2);
            .iter()
    }
        let gens: Vec<i64> = (0..metas.len() as i64).collect();
            dir.path(),
            out.push(store.head(&loc).await.unwrap());
}
            "a.parquet",
        .map_err(|e| format!("parquet metadata {}: {}", meta.location, e))?;
        ]));
        // per segment.
}
        assert_eq!(
    /// Schema evolution: seg0 lacks `created_day` that seg1 has. The
 */
    object_metas: &[object_store::ObjectMeta],
    // position. Treat that as "can't chain" — a single missing RG poisons the
        )
            ],
        let gens_ba: Vec<i64> = (0..metas_ba.len() as i64).collect();
            Arc::clone(&store),
        writer.write(&batch).unwrap();
            Arc::clone(&store),
        let store: Arc<dyn ObjectStore> = Arc::new(LocalFileSystem::new());
        for rg_idx in 0..pq_meta.num_row_groups() {
    (acc_min, acc_max)
            Err(_) => return (None, None),
        // Only runs in dev/test builds; production never depends on the footer kv.
    let mut acc_min: Option<ScalarValue> = None;
    let mut acc_max: Option<ScalarValue> = None;
    #[tokio::test]
            ],
    location: &object_store::path::Path,
        cumulative_rows += max_doc as u64;
            Arc::clone(&store),
            ],
    );
#[cfg(debug_assertions)]
            vec!["name", "score", "created_day"],
    let converter = match StatisticsConverter::try_new(
        });
            Arc::clone(&store),
    };
//! (`writer_generations[i]` is the generation of `object_metas[i]`). The values originate
            Field::new("score", DataType::Int32, false),
    };
    /// union must include every field, first-seen-order, with the
    let mins = match converter.row_group_mins(row_groups.iter()) {
                Arc::new(Int32Array::from(vec![3])),
///
 * The OpenSearch Contributors require contributions made to
    /// Incompatible types (Int32 vs Int64 on the same field name) is
    let row_groups = pq_meta.row_groups();
use datafusion::common::ScalarValue;
        let mut writer = ArrowWriter::try_new(file, schema, None).unwrap();
use super::parquet_bridge;
            Field::new("name", DataType::Utf8, false),
            None => v,
        )
        let metas = object_metas(store.as_ref(), &[p0, p1]).await;
        let p0 = write_parquet(
//! `create_reader` → `ShardView.writer_generations` → `SessionContextHandle` →
        Ok(arr) => arr,
        let schema_a = Arc::new(Schema::new(vec![
/// - any RG lacks stats for the column (one missing RG → "can't chain").
                Some(std::cmp::Ordering::Less) | Some(std::cmp::Ordering::Equal) => prev,
        return Err(format!(
    file_schema: &arrow::datatypes::SchemaRef,
        );
        .unwrap();
    }
        paths: &[std::path::PathBuf],
                Some(std::cmp::Ordering::Greater) => v,
                Arc::new(Int32Array::from(vec![Some(2)])),
    let schema = crate::schema_coerce::transform_schema_to_view_recursive(schema.as_ref());
        ]));
    use datafusion::parquet::arrow::ArrowWriter;
            None => v,
    let footer_gen: i64 = value.parse().unwrap_or_else(|e| {
//! over the object store.
        let (segments, merged) = build_segments(
            offset += num_rows;
                Arc::new(Int32Array::from(vec![2])),
        return (None, None);
        let wide = Arc::new(Schema::new(vec![
        let names: Vec<&str> = merged.fields().iter().map(|f| f.name().as_str()).collect();
            Field::new("a", DataType::Utf8, false),
        filename: &str,
    }
        );
        let store: Arc<dyn ObjectStore> = Arc::new(LocalFileSystem::new());
use datafusion::parquet::file::metadata::ParquetMetaData;
        Ok(arr) => arr,
            Some(prev) => match prev.partial_cmp(&v) {
    ) {
        .unwrap();
    // multi-value field share the same LIST storage shape from their first generation.
/// - `StatisticsConverter::try_new` rejects the type (logical types whose
    /// Write a parquet file with the given schema + arrays into `dir`
                Arc::new(Int32Array::from(vec![1, 2])),
        )
    store: Arc<dyn object_store::ObjectStore>,
        let (sort_min, sort_max) = match sort_fields.first() {
        assert_eq!(created_day.data_type(), &DataType::Int32);
    /// shard-read boundary rather than silently at decode time.
            vec![
            object_metas.len(),
    writer_generations: &[i64],
        let dir = tempdir().unwrap();
            ],
            let loc = ObjectPath::from(p.to_string_lossy().as_ref());
    sort_fields: &[String],
    for (seg_ord, meta) in object_metas.iter().enumerate() {
        return (None, None);
            "schema order must not depend on object-meta input ordering"
/// Parquet footer kv key under which the writer stamps the writer generation.
        let dir = tempdir().unwrap();
                Arc::new(Int32Array::from(vec![1])),
        ),
            "field from only-one-segment must be nullable in the union"
            Some(prev) => match prev.partial_cmp(&v) {
        );
) {
/// production read path.
        segments.push(SegmentFileInfo {
            &gens,
    /// bubble the error up. Catches accidental type widening at the
    metadata_cache: Arc<dyn FileMetadataCache>,
            default_metadata_cache(),
                Arc::new(Int32Array::from(vec![Some(42)])),
/// Returns `(None, None)` when:
/// The returned schema is the **union across all segment parquet files**,
}
    // sort key (Int64/Date32/Date64/Timestamp/Utf8/etc.).
    }
    // If any RG lacks stats, both arrays will have null entries at that
    let value = match kv.value.as_ref() {
            },
            "b.parquet",
use super::table_provider::SegmentFileInfo;
        let (file_schema, size, pq_meta) = parquet_bridge::load_parquet_metadata_with_meta(
            schema_b,
//! Writer generation comes from the caller as a parallel slice
            "build_segments: object_metas ({}) and writer_generations ({}) must have the same length",
        );
            dir.path(),
                Some(std::cmp::Ordering::Less) => v,
            default_metadata_cache(),
const WRITER_GENERATION_KEY: &str = "opensearch.writer_generation";
        footer_gen, catalog_generation, location
    /// under `filename`. Returns the absolute filesystem path.
            Field::new("name", DataType::Utf8, false),
    /// Determinism: schema merge is invariant under object-store
    pq_meta: &ParquetMetaData,
        let mut offset: i64 = 0;
        // file's schema, when the type isn't supported by `StatisticsConverter`, or
    /// identical field order.
    };
        file_schema,
            let num_rows = pq_meta.row_group(rg_idx).num_rows();
        }
                first_row: offset,
        let dir = tempdir().unwrap();
    // Delegate to DataFusion's canonical schema inference. All files for a predefined
        assert!(
//! `build_segments`. The catalog is the authoritative source.
        )
#[cfg(test)]
        );
        let msg = result.unwrap_err();
}
            &metas_ab,
        let metas_ba = object_metas(store.as_ref(), &[p1, p0]).await;
        let gens_ab: Vec<i64> = (0..metas_ab.len() as i64).collect();
            &metas_ba,
            "a.parquet",
    for i in 0..mins.len() {
            &metas,
        }
            // all. We don't fail here — older files predate the assertion contract.
        store: &dyn ObjectStore,
use std::sync::Arc;
        let writer_generation = writer_generations[seg_ord];
            .fields()
    });
            WRITER_GENERATION_KEY, location
            created_day.is_nullable(),
            Err(_) => return (None, None),
            vec![
        for p in paths {
            Ok(v) => v,
        )
    use tempfile::tempdir;
//! in the Java-side catalog snapshot via `WriterFileSet.writerGeneration` and flow through
            schema.clone(),
    // force_view_types does not recursively rewrite LIST children.
        acc_min = Some(match acc_min.take() {
            Arc::clone(&metadata_cache),
        let gens: Vec<i64> = (0..metas.len() as i64).collect();
            row_groups.push(RowGroupInfo {
        lead_field,
    ) -> Vec<object_store::ObjectMeta> {
            "union must contain every field across segments in first-seen order"
    if mins.null_count() > 0 || maxes.null_count() > 0 {
        let max_doc = offset;
 * SPDX-License-Identifier: Apache-2.0
            narrow.clone(),
            default_metadata_cache(),
        // None,None when no sort field is configured, when the column isn't in this
        None => return,
            parquet_size: size,
            .map(|f| f.name().as_str())
    };
        #[cfg(debug_assertions)]
        let s_i32 = Arc::new(Schema::new(vec![Field::new("n", DataType::Int32, false)]));
    let mut segments = Vec::with_capacity(object_metas.len());
            &ctx.state(),
        out
        ));
        Err(_) => return (None, None),
        acc_max = Some(match acc_max.take() {
            s_i64,
        Arc::new(DefaultFilesMetadataCache::new(50 * 1024 * 1024))
            Some(lead) => compute_segment_sort_bounds(lead, &file_schema, &pq_meta),
            vec![
    async fn identical_schemas_merge_to_themselves() {
        });
    #[tokio::test]
        debug_assert_footer_generation_matches_catalog(&pq_meta, writer_generation, &meta.location);
        let ctx = SessionContext::new();
        arrays: Vec<Arc<dyn arrow::array::Array>>,
            Field::new("created_day", DataType::Int32, true),
/// We do get all `ParquetFormat` knobs
    async fn merge_is_deterministic_across_input_ordering() {
    /// the local filesystem object store.
mod tests {
/*
    }
            .map(|f| f.name().as_str())
    }
    use super::*;
    let maxes = match converter.row_group_maxes(row_groups.iter()) {
        return Err("No parquet files provided".to_string());
                index: rg_idx,
use datafusion::catalog::Session;
        let (_, schema_ab) = build_segments(
        );
        let p1 = write_parquet(
    async fn object_metas(
 * this file be licensed under the Apache-2.0 license or a
    ) -> std::path::PathBuf {
            "conflicting Int32 / Int64 on same field name must fail at schema-union time"
        dir: &std::path::Path,
            sort_max,
        assert_eq!(merged.field(1).name(), "score");
/// Mirrors how DataFusion's `MinMaxStatistics::new_from_files` aggregates
        // Compute per-segment min/max on the LEAD `index.sort.field` column.
            Field::new("name", DataType::Utf8, false),
            vec![
        let created_day = merged.field_with_name("created_day").unwrap();
            vec![Arc::new(arrow_array::Int64Array::from(vec![2i64]))],
        };
        // at `file_scan_config.rs:1347-1363` (chain check).
        let fields_ab: Vec<&str> = schema_ab
        );
        let v = match ScalarValue::try_from_array(&*maxes, i) {
        let batch = RecordBatch::try_new(schema.clone(), arrays).unwrap();
            default_metadata_cache(),
    }
            max_doc,
    fn write_parquet(
                Arc::new(StringArray::from(vec!["y"])),
    #[tokio::test]
    /// Build `[ObjectMeta]` pointing at the given absolute paths via
        pq_meta.file_metadata().schema_descr(),
            Ok(v) => v,
            &meta.location,
        let (_segments, merged) = build_segments(
        );
            writer_generation,
        panic!(
        .await
    };
    /// default, which is fine for default writers that emit none).
use datafusion::parquet::arrow::arrow_reader::statistics::StatisticsConverter;
            object_path: meta.location.clone(),
) -> (Option<ScalarValue>, Option<ScalarValue>) {
            vec![Arc::new(Int32Array::from(vec![1]))],
    assert_eq!(
        let store: Arc<dyn ObjectStore> = Arc::new(LocalFileSystem::new());
            "a.parquet",
        );
            schema_a,
    use arrow_array::{Int32Array, RecordBatch, StringArray};
    let schema = FileFormat::infer_schema(&format, state, &store, object_metas)
    #[tokio::test]
        path
        )
            "parquet footer `{}` not parseable as i64 [{}] (file={}): {}",
    // whole-segment claim because we can't prove a chain across RGs.
use datafusion::execution::cache::cache_manager::FileMetadataCache;
            vec![
            .collect();
    Ok((segments, schema))
    catalog_generation: i64,
        let global_base = cumulative_rows;
            "b.parquet",
        let p1 = write_parquet(
        let gens: Vec<i64> = (0..metas.len() as i64).collect();
        // Debug-only cross-check: the writer also stamps the generation into the parquet
    pq_meta: &ParquetMetaData,
        });
                Some(std::cmp::Ordering::Greater) | Some(std::cmp::Ordering::Equal) => prev,
/// computed by `ParquetFormat::infer_schema` — the same function
    /// listing order. `ParquetFormat` sorts by location before merge
        assert!(
        Ok(c) => c,
                Arc::new(StringArray::from(vec!["x"])),
        .await
            &ctx.state(),
    };
            metadata: pq_meta,
        let path = dir.join(filename);
        }
                Arc::new(StringArray::from(vec!["y"])),
            &ctx.state(),
#[cfg(debug_assertions)]
            },
            WRITER_GENERATION_KEY, value, location, e
            &gens_ab,
        assert_eq!(
    }
    /// non-null.
    let schema = crate::schema_coerce::coerce_inferred_schema(Arc::new(schema));
            msg
        ]));
            "error must originate from infer_schema path, got: {}",
            Arc::clone(&store),
        Some(kv) => kv,
                Arc::new(StringArray::from(vec!["z"])),
///
        let file = std::fs::File::create(&path).unwrap();
                None => return (None, None),
            writer_generations.len()
        );
            sort_min,
            &[],
        // when any RG is missing stats. The per-RG min/max → segment min/max
        )
    async fn incompatible_types_on_same_field_error() {
                num_rows,
        let p0 = write_parquet(
            });
            &ctx.state(),
            &metas,
        .map_err(|e| format!("infer_schema union: {}", e))?;
            &gens_ba,
    /// "new" field nullable because seg0 didn't declare it as
            row_groups,
/// reduce them to a per-segment (min-of-mins, max-of-maxes) pair.
///
            dir.path(),
            s_i32,
        Err(_) => return (None, None),
    /// metadata cache is configured.
    /// Mirror of what `CacheManager::try_new` auto-installs when no custom
            .fields()
        let ctx = SessionContext::new();
            dir.path(),
        ]));
        local::LocalFileSystem, path::Path as ObjectPath, ObjectStore, ObjectStoreExt,
            msg.contains("infer_schema union"),
        None => {
        assert_eq!(merged.field(0).name(), "name");
/// `ListingTable` uses.
/// - `lead_field` is absent from this file's arrow schema (segment was
        return (None, None);
        // Per-segment parquet metadata (RG info, page index) — still needed
    /// schema (field-level metadata stripped per `skip_metadata`
        .await
        // footer load resolves from cache without a redundant `head()` syscall
        schema: arrow::datatypes::SchemaRef,
        );
            &[],
            &gens,
            wide.clone(),
        writer.close().unwrap();
        .await
            &metas,
        None => panic!(
    for i in 0..maxes.len() {
        // `meta` is the authoritative listing snapshot — pass it through so the
fn compute_segment_sort_bounds(
/// Must match `parquet-data-format`'s `WRITER_GENERATION_KEY`.
            &[],
    let kv = match kvs.iter().find(|kv| kv.key == WRITER_GENERATION_KEY) {
        let s_i64 = Arc::new(Schema::new(vec![Field::new("n", DataType::Int64, false)]));
use datafusion::datasource::file_format::FileFormat;
            // Older files written before the writer started stamping the kv have no kv block at
        let schema_b = Arc::new(Schema::new(vec![
    lead_field: &str,
    fn default_metadata_cache() -> Arc<dyn FileMetadataCache> {
            vec![
        let ctx = SessionContext::new();
    }
                Arc::new(Int32Array::from(vec![1])),
/// per-file stats; we operate at the RG-within-a-segment granularity instead.
            Field::new("b", DataType::Int32, false),
    use arrow::datatypes::{DataType, Field, Schema};
pub async fn build_segments(
    };
    use datafusion::execution::cache::DefaultFilesMetadataCache;
            names,
    state: &dyn Session,
        let metas_ab = object_metas(store.as_ref(), &[p0.clone(), p1.clone()]).await;
//! Build `SegmentFileInfo`s from the query's object_metas by reading parquet metadata
        .unwrap();
    // Reduce the per-RG stat arrays to (min-of-mins, max-of-maxes) by walking
        let dir = tempdir().unwrap();
    let kvs = match pq_meta.file_metadata().key_value_metadata() {
        ]));
        // aggregation mirrors what DataFusion's `validated_output_ordering` does
use datafusion::datasource::file_format::parquet::ParquetFormat;
        let narrow = Arc::new(Schema::new(vec![
        .await;
            default_metadata_cache(),
    /// a fail-fast: the Arrow `Schema::try_merge` rejects it, and we
    async fn union_contains_fields_from_all_segments() {
    let mut cumulative_rows: u64 = 0;
/// Read the writer generation out of a parquet footer's key-value metadata and panic if
        // both are pointed at the same object location, so this isn't a
 *
            global_base,
    use datafusion::execution::context::SessionContext;
    if object_metas.is_empty() {
/// file_metadata_cache, meta_fetch_concurrency, parquet_encryption)
        );
            &ctx.state(),
            "b.parquet",
    let format = ParquetFormat::default().with_force_view_types(true);
                Arc::new(StringArray::from(vec!["x", "y"])),
        Err(_) => return (None, None),
        };
        let (_, schema_ba) = build_segments(
    if row_groups.is_empty() {
    }
    }
            dir.path(),
        let metas = object_metas(store.as_ref(), &[p0, p1]).await;
            Arc::clone(&store),
        let ctx = SessionContext::new();
//! # Source of truth: the catalog snapshot
        // footer. If the catalog and the footer disagree, that's a writer-side regression.
        // RuntimeEnv that `infer_schema` uses below shares this data when
///
            meta.clone(),
    /// Two segments with identical schemas: the union equals that
        // duplicated cold fetch in practice.
///   parquet-side stats can't decode losslessly),
            ],
//!
/// `writer_generations[i]` is the writer generation of `object_metas[i]`. Both slices
        let p0 = write_parquet(
    use object_store::{
            &[],
            schema.clone(),
            result.is_err(),
        Some(v) => v,
            dir.path(),
/// Read per-RG min/max stats for `lead_field` from the parquet footer and
    // because the result type isn't a ScalarValue without a per-DataType match.
            ],
        Some(kvs) => kvs,
        let mut out = Vec::new();
/// it disagrees with what the catalog provided. Debug-only assertion — never on the
