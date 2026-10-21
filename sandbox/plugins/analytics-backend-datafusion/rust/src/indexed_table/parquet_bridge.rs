                ParquetMetaDataReader::new()
    push_predicate: bool,
        }
        Arc::clone(&config.metadata),
    let schema = parquet_to_arrow_schema(file_meta.schema_descr(), file_meta.key_value_metadata())
    pub projection: Option<Vec<usize>>,
    if let Some(ref proj) = config.projection {
            );
    fn get_metadata(
/// Predicate pushdown is NOT safe here — caller applies a `BooleanMask` AFTER
                    .await
            metrics: file_metrics,
    fn create_reader(
                    .load_and_finish(&mut reader, size)
pub async fn load_parquet_metadata(
    let pq_meta = match pq_meta {
use datafusion::execution::object_store::ObjectStoreUrl;
}
    // skip page index bytes (they are loaded lazily per-column by the scoped cache).
}
        // access plan but skips all column I/O.
pub fn create_full_scan_stream(
use std::sync::atomic::{AtomicU64, Ordering};
}
    }
                .map(|cached| Arc::clone(cached.parquet_metadata()))
    let mut access_plan = ParquetAccessPlan::new_none(num_rgs);
    selection: RowSelection,
) -> std::result::Result<(SchemaRef, u64, Arc<ParquetMetaData>), String> {
//! `DataSourceExec`, `ParquetAccessPlan`, `RowGroupAccess::Selection/Scan`,
    fn get_bytes(
pub async fn load_parquet_metadata_with_meta(
    io_stats: Arc<ReadIoStats>,
    config: &RowGroupStreamConfig,
        &mut self,
            metadata: Arc::clone(&self.metadata),
    // Cache hit — return footer-only metadata without any IO.
    }
    load_parquet_metadata_with_meta(store, location, meta, metadata_cache).await
use datafusion::execution::cache::cache_manager::FileMetadataCache;
    // rows with gaps?) so the caller's post-decode mask alignment stays
    metadata: Arc<ParquetMetaData>,
        file: PartitionedFile,
use std::sync::Arc;
    }
    io_stats: Arc<ReadIoStats>,
}
        } else {
            store: Arc::clone(&self.store),
/// Like [`load_parquet_metadata`] but uses a caller-supplied [`ObjectMeta`]
            let r = store
        async move {
    create_stream_with_access_plan(config, access_plan, false)
}
    // Scoped disabled (fallback): use Optional — reads page index if it falls within
                .with_pushdown_filters(true)
        }))
        .with_parquet_file_reader_factory(reader_factory)
        None => {
            parquet_source = parquet_source
    }
            );
    store: Arc<dyn ObjectStore>,
use datafusion::common::Result;
//! lives here. `stream.rs` only uses this module's public API.
    //   - Pass the resulting `RowSelection` via
        }
/// Create a stream that reads a single row group using `RowSelection`.
}
                .map_err(|e| datafusion::parquet::errors::ParquetError::External(Box::new(e)));
/// index bytes — then store the footer in the cache for future hits.
    access_plan.set(rg_index, RowGroupAccess::Selection(selection));
    fn get_byte_ranges(
//! direct `LocalFileSystem` / `std::fs` usage — that was the PR #21164 version's
///
        partition_index: usize,
    pub file_path: String,
use datafusion_datasource::PartitionedFile;
fn record_io(stats: &ReadIoStats, dur: Duration) {
use datafusion::parquet::arrow::parquet_to_arrow_schema;
use datafusion::physical_plan::ExecutionPlan;
            let t0 = Instant::now();
    };
    let num_rgs = config.metadata.num_row_groups();
        .boxed()
}
        // with just parquet predicates
//! DataFusion parquet bridge — isolates ALL DataFusion parquet-specific API calls.
    metadata_cache: Arc<dyn FileMetadataCache>,
            r
 * SPDX-License-Identifier: Apache-2.0
        metrics: &ExecutionPlanMetricsSet,
    meta: object_store::ObjectMeta,
 */
    // semantics (does it deliver contiguous packed rows or original-position
///
        Some(m) => m,
                .await
    if push_predicate {
/// is needed when the caller already has it.
                .get_ranges(&location, &ranges)
        // columns". Parquet delivers correct row counts via the
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderOptions, RowSelection};
    // correct. Documented in `pr-reviews/EVALUATOR_HANDOFF.md`.
        async move { Ok(metadata) }.boxed()
        }
) -> std::result::Result<(SchemaRef, u64, Arc<ParquetMetaData>), String> {
impl CachedMetadataReaderFactory {
//! `ParquetFileReaderFactory`, `ArrowReaderMetadata`, `ArrowReaderOptions`
use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
    config: &RowGroupStreamConfig,
use futures::FutureExt;
use datafusion::parquet::arrow::async_reader::ParquetObjectReader;
/// Configuration for creating a per-row-group parquet stream.
    // strategy (<3%) and `BooleanMask` strategy (≥3%).
 * compatible open source license.
    config: &RowGroupStreamConfig,
    rg_index: usize,
    let stream = exec.execute(0, ctx)?;
        FileScanConfigBuilder::new(config.store_url.clone(), Arc::new(parquet_source))
pub struct RowGroupStreamConfig {
    let pq_meta = if let Some(entry) = metadata_cache.get(location) {
                .map_err(|e| datafusion::parquet::errors::ParquetError::External(Box::new(e)));
use datafusion::parquet::file::metadata::{PageIndexPolicy, ParquetMetaDataReader};
///
    }
    //   - Read the RG's `offset_index` to get per-page row counts.
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Arc<ParquetMetaData>>> {
    store: Arc<dyn ObjectStore>,
        config_builder = config_builder.with_projection_indices(Some(proj.clone()))?;
/// Shared accumulator for object-store read wall-time.
                .with_predicate(Arc::clone(pred))
#[derive(Debug, Default)]
    access_plan: ParquetAccessPlan,
#[derive(Debug)]
    let ctx = Arc::new(datafusion::execution::TaskContext::default());
            io_stats,
    push_predicate: bool,
struct CachedMetadataReader {
    metrics: ParquetFileMetrics,
                .with_reorder_filters(true);
use datafusion::execution::SendableRecordBatchStream;
    let file_meta = pq_meta.file_metadata();
    // the same footer fetch range, without issuing a separate IO request for it.
    store: Arc<dyn ObjectStore>,
    let size = meta.size;
        async move {
/// Factory that creates parquet readers with pre-cached metadata.
/// + `fstat` syscall per call on local stores, which adds up under repeated
use datafusion::parquet::arrow::async_reader::AsyncFileReader;
/// On a cache hit the cached (footer-only) metadata is returned with no IO.
 * The OpenSearch Contributors require contributions made to
        let store = Arc::clone(&self.store);
// ── Parquet Metadata Loading ─────────────────────────────────────────
//! All I/O goes through the caller-supplied `object_store::ObjectStore`. No
        .head(location)
        metadata: Arc<ParquetMetaData>,
use std::time::{Duration, Instant};
    //     `RowGroupAccess::Selection(selection)`.
                .file_metadata
        Self {
/// decode, so pushdown during decode would cause mask offset misalignment.
        if let Some(ref pred) = config.predicate {
        if entry.is_valid_for(&meta) {
    location: &object_store::path::Path,
};
    location: object_store::path::Path,
            record_io(&io_stats, t0.elapsed());
    };
    pub count: AtomicU64,
    store: Arc<dyn ObjectStore>,
    pub store: Arc<dyn ObjectStore>,
        // cannot use page index because we have collector bitset matches that are not visible
//! design and it was reworked here so the indexed path respects the same store
    // retains it and DataFusion's default page pruning path continues to work.
    /// Object store the file lives in (resolved from the session's RuntimeEnv).
    }
    Ok((Arc::new(schema), size, pq_meta))
        self.metrics
/// [`load_parquet_metadata_with_meta`] instead — the `head()` is a `File::open`
                CachedFileMetadataEntry::new(
    create_stream_with_access_plan(config, access_plan, push_predicate)
            let fetched = Arc::new(
            metadata,
        let io_stats = Arc::clone(&self.io_stats);
/*
                location,
/// passed into a `ParquetFileReaderFactory`) should call
}
                    Arc::new(CachedParquetMetaData::new(Arc::clone(&fetched))),
    let mut access_plan = ParquetAccessPlan::new_none(num_rgs);
            let t0 = Instant::now();
    )) as Arc<dyn ParquetFileReaderFactory>;
            location: file.object_meta.location.clone(),
}
                    .map_err(|e| format!("load parquet metadata {location}: {e}"))?,
    // Before implementing, verify parquet-rs's `Selection` delivery
use datafusion::parquet::file::metadata::ParquetMetaData;
                .downcast_ref::<CachedParquetMetaData>()
        Arc::clone(&config.io_stats),
            .bytes_scanned
            None
use datafusion::datasource::physical_plan::parquet::{
    // ranges are entirely outside the candidate set. Bigger I/O savings than
    let meta = store
impl AsyncFileReader for CachedMetadataReader {
use datafusion_datasource::source::DataSourceExec;
    location: &object_store::path::Path,
                ),
    let policy = if crate::cache::page_index::is_scoped_page_index_enabled() {
    let partitioned_file = PartitionedFile::new(config.file_path.clone(), config.file_size)
            ParquetFileMetrics::new(partition_index, file.object_meta.location.as_ref(), metrics);
        Ok(Box::new(CachedMetadataReader {
}
        let io_stats = Arc::clone(&self.io_stats);
    ParquetAccessPlan, ParquetFileMetrics, ParquetFileReaderFactory, RowGroupAccess,
use prost::bytes::Bytes;
    } else {
    stats.count.fetch_add(1, Ordering::Relaxed);
    access_plan.set(rg_index, RowGroupAccess::Scan);
            store,
        PageIndexPolicy::Optional
        // Empty projection (e.g. COUNT(*)) is honoured as "read no
    /// URL of the store for DataFusion's `FileScanConfig`.
 * this file be licensed under the Apache-2.0 license or a
/// `last_modified`, both present in the listing's `ObjectMeta`, so no `head()`
            .with_file(partitioned_file);
    /// Object-store-relative path to the parquet file.
        ranges: Vec<std::ops::Range<u64>>,
        .map_err(|e| format!("parquet_to_arrow_schema {location}: {e}"))?;
        _options: Option<&ArrowReaderOptions>,
use datafusion::execution::cache::cache_manager::CachedFileMetadataEntry;
    // Scoped enabled: skip page index bytes entirely (scoped cache handles it lazily).
/// On a cache miss we fetch with `PageIndexPolicy::Skip` — never fetching page
        _metadata_size_hint: Option<usize>,
) -> Result<(SendableRecordBatchStream, Arc<dyn ExecutionPlan>)> {
    Ok((stream, exec))
    //   - For each page, select if any candidate bit falls within its row
    //
/// so the predicate sees only selected rows and indices stay aligned.
            record_io(&io_stats, t0.elapsed());
) -> Result<(SendableRecordBatchStream, Arc<dyn ExecutionPlan>)> {
                    .with_page_index_policy(policy)
        let location = self.location.clone();
    let exec: Arc<dyn ExecutionPlan> = DataSourceExec::from_data_source(config_builder.build());
        None
                .as_any()
fn create_stream_with_access_plan(
    };
    // TODO(page-boundary-selection): replace `Scan` with a `Selection` built
    let mut config_builder =
            io_stats: Arc::clone(&self.io_stats),
    pub full_schema: SchemaRef,
    // Cache miss — fetch metadata. When the scoped page-index cache is enabled,
/// Load footer-only parquet metadata, consulting the caller-supplied cache.
            r
use object_store::{ObjectStore, ObjectStoreExt};
        .with_enable_page_index(false);
impl ParquetFileReaderFactory for CachedMetadataReaderFactory {
        Arc::clone(&config.store),
            fetched
use datafusion::datasource::physical_plan::ParquetSource;
//! Everything that touches `ParquetSource`, `FileScanConfigBuilder`,
                .await
pub fn create_row_selection_stream(
//! the vanilla path uses (file://, s3://, etc.).
 *
    ) -> Self {
        }
            .add((range.end - range.start) as usize);
    // from the caller's candidate bitmap at page boundaries. The idea:
        let store = Arc::clone(&self.store);
    // This keeps the selector Vec small (O(pages), not O(rows)) regardless of
    // candidate density, while letting parquet skip whole pages whose row
    pub total_ns: AtomicU64,
        let total: u64 = ranges.iter().map(|r| r.end - r.start).sum();
    // When disabled (fallback mode), fetch the full page index so the metadata cache
    let mut parquet_source = ParquetSource::new(config.full_schema.clone())
/// Issues a `head()` to learn the file's size + last-modified. Callers that
    pub metadata: Arc<ParquetMetaData>,
}
        &self,
        let metadata = Arc::clone(&self.metadata);
        .boxed()
}
    }
) -> Result<(SendableRecordBatchStream, Arc<dyn ExecutionPlan>)> {
    pub store_url: ObjectStoreUrl,
    let reader_factory = Arc::new(CachedMetadataReaderFactory::new(
    ) -> datafusion::common::Result<Box<dyn AsyncFileReader + Send>> {
            let mut reader = ParquetObjectReader::new(Arc::clone(&store), location.clone());
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Bytes>> {
/// Predicate pushdown IS safe here — `RowSelection` is applied during decode,
//!
use futures::future::BoxFuture;
        let file_metrics =
        .map_err(|e| format!("object-store head {location}: {e}"))?;
    //     range, else skip.
            entry
                    meta,
/// Avoids re-reading metadata for each row group.
pub struct CachedMetadataReaderFactory {
pub struct ReadIoStats {
        &mut self,
///
        store: Arc<dyn ObjectStore>,
            let r = store
        let location = self.location.clone();
/// check ([`CachedFileMetadataEntry::is_valid_for`]) only consults `size` and
    pub io_stats: Arc<ReadIoStats>,
///
//!
        .with_extensions(Arc::new(access_plan));
    let num_rgs = config.metadata.num_row_groups();
/// per-file reader creation.
}
                .get_range(&location, range)
/// (size + last_modified) instead of issuing a `head()`. The cache validity
    // for any selectivity — unifying today's split between `RowSelection`
        io_stats: Arc<ReadIoStats>,
    metadata: Arc<ParquetMetaData>,
        .await
        range: std::ops::Range<u64>,
    stats.total_ns.fetch_add(ns, Ordering::Relaxed);
        &mut self,
        PageIndexPolicy::Skip
use datafusion::arrow::datatypes::SchemaRef;
use datafusion_datasource::file_scan_config::FileScanConfigBuilder;
    } else {
    metadata_cache: Arc<dyn FileMetadataCache>,
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Vec<Bytes>>> {
    pub fn new(
            metadata_cache.put(
    pub file_size: u64,
    // today's full-scan for dense-but-clustered matches, and cheap to build
use datafusion::physical_plan::metrics::ExecutionPlanMetricsSet;
    pub predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
        }
    rg_index: usize,
/// Create a stream that reads a single row group with full scan.
/// already hold an authoritative [`ObjectMeta`] (e.g. from the listing snapshot
        }
        self.metrics.bytes_scanned.add(total as usize);
    let ns = dur.as_nanos() as u64;
