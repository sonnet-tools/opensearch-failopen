/// must have the same length.
            },
    }
        );
/// reduce them to a per-segment (min-of-mins, max-of-maxes) pair.
        let ctx = SessionContext::new();
/*
    /// Two segments with identical schemas: the union equals that
        let result = build_segments(
        let gens_ba: Vec<i64> = (0..metas_ba.len() as i64).collect();
use super::stream::RowGroupInfo;
            Arc::clone(&store),
    (acc_min, acc_max)
        let metas_ab = object_metas(store.as_ref(), &[p0.clone(), p1.clone()]).await;
    });
            "union must contain every field across segments in first-seen order"
        assert_eq!(created_day.data_type(), &DataType::Int32);
    let schema = FileFormat::infer_schema(&format, state, &store, object_metas)
            names,
        return Err(format!(
        )
use super::parquet_bridge;
            return;
        for p in paths {
        );
                Arc::new(Int32Array::from(vec![Some(42)])),
    let converter = match StatisticsConverter::try_new(
    // multi-value field share the same LIST storage shape from their first generation.
const WRITER_GENERATION_KEY: &str = "opensearch.writer_generation";
        );
    };
            Field::new("a", DataType::Utf8, false),
        file_schema,
        ]));
        .await
        Ok(c) => c,
        let gens: Vec<i64> = (0..metas.len() as i64).collect();
    }
/// Returns `(None, None)` when:
            object_path: meta.location.clone(),
        .map_err(|e| format!("infer_schema union: {}", e))?;
        )
    // position. Treat that as "can't chain" — a single missing RG poisons the
    if mins.null_count() > 0 || maxes.null_count() > 0 {
    sort_fields: &[String],
    #[tokio::test]
        let mut row_groups = Vec::new();
    for (seg_ord, meta) in object_metas.iter().enumerate() {
        // Only runs in dev/test builds; production never depends on the footer kv.
        footer_gen, catalog_generation, location
            "build_segments: object_metas ({}) and writer_generations ({}) must have the same length",
            "b.parquet",
            .collect();
    let maxes = match converter.row_group_maxes(row_groups.iter()) {
    ) -> Vec<object_store::ObjectMeta> {
/// Read the writer generation out of a parquet footer's key-value metadata and panic if
            "field from only-one-segment must be nullable in the union"
            default_metadata_cache(),
        let writer_generation = writer_generations[seg_ord];
            "a.parquet",
            dir.path(),
        let created_day = merged.field_with_name("created_day").unwrap();
        assert_eq!(segments.len(), 2);
            "error must originate from infer_schema path, got: {}",
            vec![
    for i in 0..maxes.len() {
    };
use datafusion::parquet::arrow::arrow_reader::statistics::StatisticsConverter;
    }
        }
        };
        )
use datafusion::execution::cache::cache_manager::FileMetadataCache;
        let fields_ab: Vec<&str> = schema_ab
        }
    #[tokio::test]
        return Err("No parquet files provided".to_string());
        debug_assert_footer_generation_matches_catalog(&pq_meta, writer_generation, &meta.location);
/// Build `SegmentFileInfo` from the shard's object metas.
        )
    async fn object_metas(
        path
            vec![Arc::new(Int32Array::from(vec![1]))],
) {
    use datafusion::execution::cache::DefaultFilesMetadataCache;
        let p1 = write_parquet(
#[cfg(debug_assertions)]
 * The OpenSearch Contributors require contributions made to
use datafusion::catalog::Session;
    for i in 0..mins.len() {
    use object_store::{
            &[],
            dir.path(),
use std::sync::Arc;
/// - any RG lacks stats for the column (one missing RG → "can't chain").
/// per-file stats; we operate at the RG-within-a-segment granularity instead.
        store: &dyn ObjectStore,
            row_groups,
        Ok(arr) => arr,
        ]));
        let (_segments, merged) = build_segments(
            vec![
        // None,None when no sort field is configured, when the column isn't in this
        let dir = tempdir().unwrap();
 *
        let p0 = write_parquet(
            schema_a,
    #[tokio::test]
        let v = match ScalarValue::try_from_array(&*mins, i) {
        let wide = Arc::new(Schema::new(vec![
    // Reduce the per-RG stat arrays to (min-of-mins, max-of-maxes) by walking
            // Older files written before the writer started stamping the kv have no kv block at
}
    }
            dir.path(),
            WRITER_GENERATION_KEY, location
        let file = std::fs::File::create(&path).unwrap();
        pq_meta.file_metadata().schema_descr(),
        .unwrap();
    /// Mirror of what `CacheManager::try_new` auto-installs when no custom
    // force_view_types does not recursively rewrite LIST children.
            &metas,
            msg
            "parquet footer `{}` has no value (file={})",
    use super::*;
    ) {
        let p0 = write_parquet(
        // file's schema, when the type isn't supported by `StatisticsConverter`, or
///
/// production read path.
        let msg = result.unwrap_err();
/// We do get all `ParquetFormat` knobs
    }
        let mut out = Vec::new();
            let num_rows = pq_meta.row_group(rg_idx).num_rows();
        .await
            &gens_ab,
        panic!(
    use arrow_array::{Int32Array, RecordBatch, StringArray};
            // all. We don't fail here — older files predate the assertion contract.
    };
        let path = dir.join(filename);
        .await
        let ctx = SessionContext::new();
    if row_groups.is_empty() {
 */
                Arc::new(Int32Array::from(vec![1])),
//!
///   parquet-side stats can't decode losslessly),
    /// identical field order.
                Arc::new(Int32Array::from(vec![1])),
            created_day.is_nullable(),
        let store: Arc<dyn ObjectStore> = Arc::new(LocalFileSystem::new());
        assert_eq!(
    /// "new" field nullable because seg0 didn't declare it as
            vec![
            .map(|f| f.name().as_str())
            Field::new("name", DataType::Utf8, false),
            "schema order must not depend on object-meta input ordering"
/// The returned schema is the **union across all segment parquet files**,
        // duplicated cold fetch in practice.
        let ctx = SessionContext::new();
    /// Determinism: schema merge is invariant under object-store
            dir.path(),
            dir.path(),
 * compatible open source license.
        Ok(arr) => arr,
        .unwrap();
            ],
            "b.parquet",
        let (_, schema_ba) = build_segments(
 * this file be licensed under the Apache-2.0 license or a
            sort_max,
    // sort key (Int64/Date32/Date64/Timestamp/Utf8/etc.).
        let store: Arc<dyn ObjectStore> = Arc::new(LocalFileSystem::new());
            vec![Arc::new(arrow_array::Int64Array::from(vec![2i64]))],
        )
        assert!(
        "parquet footer writer_generation ({}) disagrees with catalog ({}) for file {}",
fn compute_segment_sort_bounds(
        arrays: Vec<Arc<dyn arrow::array::Array>>,
            dir.path(),
            schema.clone(),
            writer_generations.len()
use datafusion::datasource::file_format::FileFormat;
            arrow_schema: file_schema,
    let mut acc_min: Option<ScalarValue> = None;
        let p1 = write_parquet(
            dir.path(),
    let mut segments = Vec::with_capacity(object_metas.len());
                num_rows,
        // RuntimeEnv that `infer_schema` uses below shares this data when
            &metas,
        let dir = tempdir().unwrap();
use datafusion::parquet::file::metadata::ParquetMetaData;
            "parquet footer `{}` not parseable as i64 [{}] (file={}): {}",
            Err(_) => return (None, None),
}
        let v = match ScalarValue::try_from_array(&*maxes, i) {
    Ok((segments, schema))
mod tests {
            writer_generation,
        .await
            "b.parquet",
        assert!(
        ]));
                Arc::new(StringArray::from(vec!["x"])),
            .map(|f| f.name().as_str())
    };
            global_base,
        assert_eq!(
                Arc::new(StringArray::from(vec!["z"])),
            s_i64,
        ));
            let loc = ObjectPath::from(p.to_string_lossy().as_ref());
        let global_base = cumulative_rows;
            &meta.location,
            schema.clone(),
    }
        });
    }
        cumulative_rows += max_doc as u64;
            out.push(store.head(&loc).await.unwrap());
        Some(kv) => kv,
///
    /// union must include every field, first-seen-order, with the
/// - `StatisticsConverter::try_new` rejects the type (logical types whose
                Arc::new(StringArray::from(vec!["x", "y"])),
///
    pq_meta: &ParquetMetaData,
    let mins = match converter.row_group_mins(row_groups.iter()) {
                first_row: offset,
        footer_gen, catalog_generation,
        // footer load resolves from cache without a redundant `head()` syscall
#[cfg(debug_assertions)]
                Some(std::cmp::Ordering::Less) | Some(std::cmp::Ordering::Equal) => prev,
            &gens,
//! (`writer_generations[i]` is the generation of `object_metas[i]`). The values originate
        acc_min = Some(match acc_min.take() {
    async fn merge_is_deterministic_across_input_ordering() {
    use datafusion::execution::context::SessionContext;
//! # Source of truth: the catalog snapshot
        Err(_) => return (None, None),
            &metas_ab,
///   written before that field existed),
            Ok(v) => v,
    if object_metas.len() != writer_generations.len() {
    use tempfile::tempdir;
            "conflicting Int32 / Int64 on same field name must fail at schema-union time"
            &ctx.state(),
            "a.parquet",
        #[cfg(debug_assertions)]
    let kv = match kvs.iter().find(|kv| kv.key == WRITER_GENERATION_KEY) {
        return (None, None);
 * SPDX-License-Identifier: Apache-2.0
/// file_metadata_cache, meta_fetch_concurrency, parquet_encryption)
        // Debug-only cross-check: the writer also stamps the generation into the parquet
            Field::new("b", DataType::Int32, false),
        Err(_) => return (None, None),
            ],
        segments.push(SegmentFileInfo {
            ],
        None => return,
        writer.close().unwrap();
            result.is_err(),
        let max_doc = offset;
            object_metas.len(),
            fields_ab, fields_ba,
    let schema = crate::schema_coerce::coerce_inferred_schema(Arc::new(schema));
        let dir = tempdir().unwrap();
        local::LocalFileSystem, path::Path as ObjectPath, ObjectStore, ObjectStoreExt,
    catalog_generation: i64,
        )
        // both are pointed at the same object location, so this isn't a
    /// (apache/datafusion#6629). Assert both orderings produce
use super::table_provider::SegmentFileInfo;
    );
pub async fn build_segments(
        // at `file_scan_config.rs:1347-1363` (chain check).
///
        let s_i32 = Arc::new(Schema::new(vec![Field::new("n", DataType::Int32, false)]));
/// computed by `ParquetFormat::infer_schema` — the same function
//! in the Java-side catalog snapshot via `WriterFileSet.writerGeneration` and flow through
                None => return (None, None),
        let metas = object_metas(store.as_ref(), &[p0, p1]).await;
            metadata: pq_meta,
    /// Incompatible types (Int32 vs Int64 on the same field name) is
                Arc::new(StringArray::from(vec!["y"])),
}
        );
    };
        // footer. If the catalog and the footer disagree, that's a writer-side regression.
    let kvs = match pq_meta.file_metadata().key_value_metadata() {
    /// the local filesystem object store.
            });
            .fields()
        None => {
        let p1 = write_parquet(
//! Build `SegmentFileInfo`s from the query's object_metas by reading parquet metadata
            Some(prev) => match prev.partial_cmp(&v) {
        let p0 = write_parquet(
            Arc::clone(&store),
            default_metadata_cache(),
                Some(std::cmp::Ordering::Greater) | Some(std::cmp::Ordering::Equal) => prev,
///
                Arc::new(Int32Array::from(vec![1, 2])),
        });
            row_groups.push(RowGroupInfo {
        dir: &std::path::Path,
            None => v,
        paths: &[std::path::PathBuf],
        Some(v) => v,
        let gens: Vec<i64> = (0..metas.len() as i64).collect();
        let (sort_min, sort_max) = match sort_fields.first() {
        let metas = object_metas(store.as_ref(), &[p0, p1]).await;
//! Writer generation comes from the caller as a parallel slice
        let (file_schema, size, pq_meta) = parquet_bridge::load_parquet_metadata_with_meta(
        lead_field,
    if object_metas.is_empty() {
        schema: arrow::datatypes::SchemaRef,
    lead_field: &str,
            .fields()
    let format = ParquetFormat::default().with_force_view_types(true);
        let dir = tempdir().unwrap();
            Arc::clone(&store),
use datafusion::common::ScalarValue;
            vec!["name", "score", "created_day"],
        .await
        for rg_idx in 0..pq_meta.num_row_groups() {
    }
        };
        let metas = object_metas(store.as_ref(), &[p0, p1]).await;
        let schema_a = Arc::new(Schema::new(vec![
    };
                index: rg_idx,
    /// bubble the error up. Catches accidental type widening at the
        });
/// Parquet footer kv key under which the writer stamps the writer generation.
        ]));
        };
        let p0 = write_parquet(
    // ScalarValue's PartialOrd handles all the supported types we'd see in a
        let s_i64 = Arc::new(Schema::new(vec![Field::new("n", DataType::Int64, false)]));
        let ctx = SessionContext::new();
    /// Write a parquet file with the given schema + arrays into `dir`
        );
    /// shard-read boundary rather than silently at decode time.
            Field::new("c", DataType::Int32, true),
        let store: Arc<dyn ObjectStore> = Arc::new(LocalFileSystem::new());
    };
        );
    location: &object_store::path::Path,
        Err(_) => return (None, None),
        // when any RG is missing stats. The per-RG min/max → segment min/max
    }
        let gens_ab: Vec<i64> = (0..metas_ab.len() as i64).collect();
        writer.write(&batch).unwrap();
    use datafusion::parquet::arrow::ArrowWriter;
                Arc::new(Int32Array::from(vec![2])),
        assert!(
) -> (Option<ScalarValue>, Option<ScalarValue>) {
/// Must match `parquet-data-format`'s `WRITER_GENERATION_KEY`.
        acc_max = Some(match acc_max.take() {
            "a.parquet",
            Some(lead) => compute_segment_sort_bounds(lead, &file_schema, &pq_meta),
            narrow.clone(),
        Some(kvs) => kvs,
    /// Schema evolution: seg0 lacks `created_day` that seg1 has. The
            Ok(v) => v,
            WRITER_GENERATION_KEY, value, location, e
        let schema_b = Arc::new(Schema::new(vec![
    fn write_parquet(
            &ctx.state(),
            vec![
        let (segments, merged) = build_segments(
        let narrow = Arc::new(Schema::new(vec![
    }
            &[],
    /// Build `[ObjectMeta]` pointing at the given absolute paths via
                Some(std::cmp::Ordering::Less) => v,
/// - `lead_field` is absent from this file's arrow schema (segment was
        .unwrap();
    file_schema: &arrow::datatypes::SchemaRef,
            Arc::clone(&store),
        .unwrap();
        let metas_ba = object_metas(store.as_ref(), &[p1, p0]).await;
            &[],
        );
    }
        let batch = RecordBatch::try_new(schema.clone(), arrays).unwrap();
            default_metadata_cache(),
    }
            Field::new("score", DataType::Int32, false),
            msg.contains("infer_schema union"),
) -> Result<(Vec<SegmentFileInfo>, arrow::datatypes::SchemaRef), String> {
#[cfg(test)]
/// `writer_generations[i]` is the writer generation of `object_metas[i]`. Both slices
            &metas_ba,
        out
            ],
            s_i32,
    #[tokio::test]
            Field::new("score", DataType::Int32, false),
                Some(std::cmp::Ordering::Greater) => v,
    store: Arc<dyn object_store::ObjectStore>,
//! `build_segments`. The catalog is the authoritative source.
        let fields_ba: Vec<&str> = schema_ba
    }
        filename: &str,
        // aggregation mirrors what DataFusion's `validated_output_ordering` does
    }
    if file_schema.index_of(lead_field).is_err() {
        // per segment.
/// (skip_metadata, coerce_int96, binary_as_string, force_view_types,
    let value = match kv.value.as_ref() {
    // because the result type isn't a ScalarValue without a per-DataType match.
    /// default, which is fine for default writers that emit none).
    let mut acc_max: Option<ScalarValue> = None;
        // `meta` is the authoritative listing snapshot — pass it through so the
                None => return (None, None),
    writer_generations: &[i64],
        let (_, schema_ab) = build_segments(
            Err(_) => return (None, None),
        // Compute per-segment min/max on the LEAD `index.sort.field` column.
            offset += num_rows;
    /// metadata cache is configured.
            &[],
        )
            &gens,
            None => (None, None),
        );
            meta.clone(),
            Arc::clone(&store),
        let mut offset: i64 = 0;
/// `ListingTable` uses.
            Some(prev) => match prev.partial_cmp(&v) {
            &[],
        let mut writer = ArrowWriter::try_new(file, schema, None).unwrap();
            .iter()
        );
            &ctx.state(),
            &ctx.state(),
    async fn incompatible_types_on_same_field_error() {
        ]));
            "b.parquet",
            wide.clone(),
            ],
    fn default_metadata_cache() -> Arc<dyn FileMetadataCache> {
        assert_eq!(merged.field(1).name(), "score");
    // If any RG lacks stats, both arrays will have null entries at that
                Arc::new(Int32Array::from(vec![3])),
            Field::new("name", DataType::Utf8, false),
            .collect();
            ],
    }
            "a.parquet",
    pq_meta: &ParquetMetaData,
/// Read per-RG min/max stats for `lead_field` from the parquet footer and
                Arc::new(StringArray::from(vec!["x"])),
        ),
            &ctx.state(),
    use arrow::datatypes::{DataType, Field, Schema};
        let store: Arc<dyn ObjectStore> = Arc::new(LocalFileSystem::new());
            Arc::clone(&metadata_cache),
            &gens_ba,
        Arc::new(DefaultFilesMetadataCache::new(50 * 1024 * 1024))
use datafusion::datasource::file_format::parquet::ParquetFormat;
    let schema = crate::schema_coerce::transform_schema_to_view_recursive(schema.as_ref());
        assert_eq!(merged.fields().len(), 2);
        .await;
        let gens: Vec<i64> = (0..metas.len() as i64).collect();
            .iter()
    /// under `filename`. Returns the absolute filesystem path.
    object_metas: &[object_store::ObjectMeta],
            Arc::clone(&store),
    async fn union_contains_fields_from_all_segments() {
            sort_min,
            schema_b,
            Field::new("score", DataType::Int32, false),
        return (None, None);
    /// non-null.
            },
        );
    // Delegate to DataFusion's canonical schema inference. All files for a predefined
    let footer_gen: i64 = value.parse().unwrap_or_else(|e| {
//! over the object store.
        }
            &metas,
            vec![
            dir.path(),
/// it disagrees with what the catalog provided. Debug-only assertion — never on the
        assert_eq!(merged.field(0).name(), "name");
                Arc::new(StringArray::from(vec!["y"])),
        let names: Vec<&str> = merged.fields().iter().map(|f| f.name().as_str()).collect();
        );
    /// listing order. `ParquetFormat` sorts by location before merge
        .map_err(|e| format!("parquet metadata {}: {}", meta.location, e))?;
        let schema = Arc::new(Schema::new(vec![
    let mut cumulative_rows: u64 = 0;
//!
    /// schema (field-level metadata stripped per `skip_metadata`
            Field::new("name", DataType::Utf8, false),
    assert_eq!(
        // Per-segment parquet metadata (RG info, page index) — still needed
        // regardless of schema derivation. The file_metadata_cache on the
            max_doc,
            Field::new("a", DataType::Utf8, false),
//! `create_reader` → `ShardView.writer_generations` → `SessionContextHandle` →
                Arc::new(Int32Array::from(vec![Some(2)])),
    /// a fail-fast: the Arrow `Schema::try_merge` rejects it, and we
        return (None, None);
        .await
            vec![
    metadata_cache: Arc<dyn FileMetadataCache>,
            &gens,
        );
        let p1 = write_parquet(
            default_metadata_cache(),
    // the rows as ScalarValues. We can't use arrow::compute::min/max directly
            default_metadata_cache(),
        );
            parquet_size: size,
/// Mirrors how DataFusion's `MinMaxStatistics::new_from_files` aggregates
    async fn identical_schemas_merge_to_themselves() {
            None => v,
    // whole-segment claim because we can't prove a chain across RGs.
            Field::new("created_day", DataType::Int32, true),
        None => panic!(
    let row_groups = pq_meta.row_groups();
fn debug_assert_footer_generation_matches_catalog(
    ) -> std::path::PathBuf {
    state: &dyn Session,
}
