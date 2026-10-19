pub async fn load_parquet_metadata(
        self.metrics
    fn create_reader(
    fn get_bytes(
                .map_err(|e| datafusion::parquet::errors::ParquetError::External(Box::new(e)));
    //   - Pass the resulting `RowSelection` via
    if push_predicate {
        config_builder = config_builder.with_projection_indices(Some(proj.clone()))?;
                .map_err(|e| datafusion::parquet::errors::ParquetError::External(Box::new(e)));
        self.metrics.bytes_scanned.add(total as usize);
        &mut self,
/// Avoids re-reading metadata for each row group.
    create_stream_with_access_plan(config, access_plan, push_predicate)
    if let Some(ref proj) = config.projection {
                    .with_page_index_policy(policy)
        if let Some(ref pred) = config.predicate {
    // semantics (does it deliver contiguous packed rows or original-position
    pub total_ns: AtomicU64,
/// passed into a `ParquetFileReaderFactory`) should call
    io_stats: Arc<ReadIoStats>,
        None
        async move { Ok(metadata) }.boxed()
    stats.total_ns.fetch_add(ns, Ordering::Relaxed);
        if entry.is_valid_for(&meta) {
) -> Result<(SendableRecordBatchStream, Arc<dyn ExecutionPlan>)> {
pub struct RowGroupStreamConfig {
/// Configuration for creating a per-row-group parquet stream.
    meta: object_store::ObjectMeta,
 * The OpenSearch Contributors require contributions made to
            let mut reader = ParquetObjectReader::new(Arc::clone(&store), location.clone());
    metadata_cache: Arc<dyn FileMetadataCache>,
    };
//! DataFusion parquet bridge — isolates ALL DataFusion parquet-specific API calls.
                .with_predicate(Arc::clone(pred))
use datafusion::execution::SendableRecordBatchStream;
            record_io(&io_stats, t0.elapsed());
}
    push_predicate: bool,
use datafusion::parquet::arrow::parquet_to_arrow_schema;
            let t0 = Instant::now();
use datafusion::parquet::arrow::async_reader::AsyncFileReader;
    ) -> Self {
                ParquetMetaDataReader::new()
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Vec<Bytes>>> {
            parquet_source = parquet_source
pub fn create_row_selection_stream(
/// On a cache hit the cached (footer-only) metadata is returned with no IO.
pub struct ReadIoStats {
                .with_reorder_filters(true);
}
struct CachedMetadataReader {
        &self,
    let meta = store
    metrics: ParquetFileMetrics,
//! `ParquetFileReaderFactory`, `ArrowReaderMetadata`, `ArrowReaderOptions`
    pub store: Arc<dyn ObjectStore>,
    location: &object_store::path::Path,
        let store = Arc::clone(&self.store);
    let ns = dur.as_nanos() as u64;
/// decode, so pushdown during decode would cause mask offset misalignment.
                .with_pushdown_filters(true)
                    .load_and_finish(&mut reader, size)
}
        let io_stats = Arc::clone(&self.io_stats);
use datafusion_datasource::source::DataSourceExec;
 * this file be licensed under the Apache-2.0 license or a
    load_parquet_metadata_with_meta(store, location, meta, metadata_cache).await
                CachedFileMetadataEntry::new(
    create_stream_with_access_plan(config, access_plan, false)
        }
        Ok(Box::new(CachedMetadataReader {
    ) -> datafusion::common::Result<Box<dyn AsyncFileReader + Send>> {
    access_plan: ParquetAccessPlan,
            location: file.object_meta.location.clone(),
impl ParquetFileReaderFactory for CachedMetadataReaderFactory {
use datafusion::execution::cache::cache_manager::FileMetadataCache;
            store,
    pub count: AtomicU64,
) -> Result<(SendableRecordBatchStream, Arc<dyn ExecutionPlan>)> {
        store: Arc<dyn ObjectStore>,
    stats.count.fetch_add(1, Ordering::Relaxed);
    //     range, else skip.
//! the vanilla path uses (file://, s3://, etc.).
    metadata_cache: Arc<dyn FileMetadataCache>,
pub async fn load_parquet_metadata_with_meta(
    }
    //
    pub projection: Option<Vec<usize>>,
        let metadata = Arc::clone(&self.metadata);
        }
    push_predicate: bool,
                ),
        async move {
        .boxed()
    let policy = if crate::cache::page_index::is_scoped_page_index_enabled() {
        PageIndexPolicy::Optional
                .file_metadata
    // This keeps the selector Vec small (O(pages), not O(rows)) regardless of
    } else {
        file: PartitionedFile,
        let file_metrics =
    rg_index: usize,
    }
/// Issues a `head()` to learn the file's size + last-modified. Callers that
use datafusion::parquet::file::metadata::{PageIndexPolicy, ParquetMetaDataReader};
//! direct `LocalFileSystem` / `std::fs` usage — that was the PR #21164 version's
 * compatible open source license.
        .with_enable_page_index(false);
    // today's full-scan for dense-but-clustered matches, and cheap to build
            );
        }
    pub store_url: ObjectStoreUrl,
    // Scoped enabled: skip page index bytes entirely (scoped cache handles it lazily).
/// (size + last_modified) instead of issuing a `head()`. The cache validity
    )) as Arc<dyn ParquetFileReaderFactory>;
            io_stats,
//! Everything that touches `ParquetSource`, `FileScanConfigBuilder`,
                    meta,
///
//! design and it was reworked here so the indexed path respects the same store
    let mut access_plan = ParquetAccessPlan::new_none(num_rgs);
    };
        &mut self,
    //   - For each page, select if any candidate bit falls within its row
    /// Object store the file lives in (resolved from the session's RuntimeEnv).
        }))
    // Scoped disabled (fallback): use Optional — reads page index if it falls within
/// Load footer-only parquet metadata, consulting the caller-supplied cache.
        FileScanConfigBuilder::new(config.store_url.clone(), Arc::new(parquet_source))
}
use datafusion::parquet::arrow::async_reader::ParquetObjectReader;
/// Predicate pushdown IS safe here — `RowSelection` is applied during decode,
        Self {
            metrics: file_metrics,
use datafusion::datasource::physical_plan::parquet::{
    let num_rgs = config.metadata.num_row_groups();
                    Arc::new(CachedParquetMetaData::new(Arc::clone(&fetched))),
//! lives here. `stream.rs` only uses this module's public API.
    let partitioned_file = PartitionedFile::new(config.file_path.clone(), config.file_size)
    let size = meta.size;
    store: Arc<dyn ObjectStore>,
use datafusion::datasource::physical_plan::parquet::metadata::CachedParquetMetaData;
        Arc::clone(&config.metadata),
use datafusion::arrow::datatypes::SchemaRef;
        let store = Arc::clone(&self.store);
            store: Arc::clone(&self.store),
    }
    pub predicate: Option<Arc<dyn datafusion::physical_expr::PhysicalExpr>>,
/// so the predicate sees only selected rows and indices stay aligned.
/// already hold an authoritative [`ObjectMeta`] (e.g. from the listing snapshot
    /// Object-store-relative path to the parquet file.
 *
    pub fn new(
    store: Arc<dyn ObjectStore>,
        // Empty projection (e.g. COUNT(*)) is honoured as "read no
    fn get_byte_ranges(
    config: &RowGroupStreamConfig,
///
            let t0 = Instant::now();
pub fn create_full_scan_stream(
    }
    // retains it and DataFusion's default page pruning path continues to work.
use datafusion::physical_plan::ExecutionPlan;
#[derive(Debug)]
    // the same footer fetch range, without issuing a separate IO request for it.
    // candidate density, while letting parquet skip whole pages whose row
                .downcast_ref::<CachedParquetMetaData>()
        .map_err(|e| format!("parquet_to_arrow_schema {location}: {e}"))?;
        .head(location)
/// index bytes — then store the footer in the cache for future hits.
}
    selection: RowSelection,
        let location = self.location.clone();
                .get_ranges(&location, &ranges)
                .as_any()
    pub io_stats: Arc<ReadIoStats>,
    // When disabled (fallback mode), fetch the full page index so the metadata cache
 */
use futures::FutureExt;
) -> std::result::Result<(SchemaRef, u64, Arc<ParquetMetaData>), String> {
use datafusion::execution::cache::cache_manager::CachedFileMetadataEntry;
            .add((range.end - range.start) as usize);
        // columns". Parquet delivers correct row counts via the
}
use std::sync::atomic::{AtomicU64, Ordering};
    let num_rgs = config.metadata.num_row_groups();
    // ranges are entirely outside the candidate set. Bigger I/O savings than
//! All I/O goes through the caller-supplied `object_store::ObjectStore`. No
/// Like [`load_parquet_metadata`] but uses a caller-supplied [`ObjectMeta`]
/// is needed when the caller already has it.
        &mut self,
    io_stats: Arc<ReadIoStats>,
        Arc::clone(&config.store),
use datafusion::parquet::file::metadata::ParquetMetaData;
            metadata: Arc::clone(&self.metadata),
    pub metadata: Arc<ParquetMetaData>,
                    .map_err(|e| format!("load parquet metadata {location}: {e}"))?,
) -> Result<(SendableRecordBatchStream, Arc<dyn ExecutionPlan>)> {
    }
    }
        // with just parquet predicates
    location: &object_store::path::Path,
fn record_io(stats: &ReadIoStats, dur: Duration) {
//!
            );
    ParquetAccessPlan, ParquetFileMetrics, ParquetFileReaderFactory, RowGroupAccess,
    //   - Read the RG's `offset_index` to get per-page row counts.
}
        Some(m) => m,
        .with_extensions(Arc::new(access_plan));
    pub full_schema: SchemaRef,
}
    // skip page index bytes (they are loaded lazily per-column by the scoped cache).
        range: std::ops::Range<u64>,
}
        metadata: Arc<ParquetMetaData>,
/// check ([`CachedFileMetadataEntry::is_valid_for`]) only consults `size` and
    }
    metadata: Arc<ParquetMetaData>,
    // rows with gaps?) so the caller's post-decode mask alignment stays
    let pq_meta = if let Some(entry) = metadata_cache.get(location) {
use futures::future::BoxFuture;
            r
pub struct CachedMetadataReaderFactory {
                    .await
use datafusion::parquet::arrow::arrow_reader::{ArrowReaderOptions, RowSelection};
/// Predicate pushdown is NOT safe here — caller applies a `BooleanMask` AFTER
/*
            record_io(&io_stats, t0.elapsed());
/// + `fstat` syscall per call on local stores, which adds up under repeated
    /// URL of the store for DataFusion's `FileScanConfig`.
impl AsyncFileReader for CachedMetadataReader {
    fn get_metadata(
            metadata_cache.put(
            io_stats: Arc::clone(&self.io_stats),
        _options: Option<&ArrowReaderOptions>,
    // Cache hit — return footer-only metadata without any IO.
    metadata: Arc<ParquetMetaData>,
/// `last_modified`, both present in the listing's `ObjectMeta`, so no `head()`
//! `DataSourceExec`, `ParquetAccessPlan`, `RowGroupAccess::Selection/Scan`,
    let mut access_plan = ParquetAccessPlan::new_none(num_rgs);
 * SPDX-License-Identifier: Apache-2.0
use prost::bytes::Bytes;
    Ok((stream, exec))
            None
///
    access_plan.set(rg_index, RowGroupAccess::Scan);
    // for any selectivity — unifying today's split between `RowSelection`
    rg_index: usize,
            metadata,
    //     `RowGroupAccess::Selection(selection)`.
            entry
    // strategy (<3%) and `BooleanMask` strategy (≥3%).
    config: &RowGroupStreamConfig,
            let r = store
use std::time::{Duration, Instant};
            .with_file(partitioned_file);
}
    let schema = parquet_to_arrow_schema(file_meta.schema_descr(), file_meta.key_value_metadata())
/// Shared accumulator for object-store read wall-time.
            fetched
        ranges: Vec<std::ops::Range<u64>>,
fn create_stream_with_access_plan(
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Bytes>> {
    let stream = exec.execute(0, ctx)?;
    // TODO(page-boundary-selection): replace `Scan` with a `Selection` built
use datafusion::common::Result;
    // from the caller's candidate bitmap at page boundaries. The idea:
            r
/// [`load_parquet_metadata_with_meta`] instead — the `head()` is a `File::open`
    access_plan.set(rg_index, RowGroupAccess::Selection(selection));
            .bytes_scanned
/// Create a stream that reads a single row group using `RowSelection`.
        .boxed()
    let reader_factory = Arc::new(CachedMetadataReaderFactory::new(
        // access plan but skips all column I/O.
        let io_stats = Arc::clone(&self.io_stats);
/// Factory that creates parquet readers with pre-cached metadata.
        io_stats: Arc<ReadIoStats>,
use std::sync::Arc;
    // correct. Documented in `pr-reviews/EVALUATOR_HANDOFF.md`.
    let exec: Arc<dyn ExecutionPlan> = DataSourceExec::from_data_source(config_builder.build());
        .with_parquet_file_reader_factory(reader_factory)
}
            let fetched = Arc::new(
// ── Parquet Metadata Loading ─────────────────────────────────────────
}
    let ctx = Arc::new(datafusion::execution::TaskContext::default());
    pub file_path: String,
use datafusion_datasource::file_scan_config::FileScanConfigBuilder;
        PageIndexPolicy::Skip
    let mut config_builder =
    Ok((Arc::new(schema), size, pq_meta))
        async move {
use datafusion_datasource::PartitionedFile;
        Arc::clone(&config.io_stats),
    };
    let mut parquet_source = ParquetSource::new(config.full_schema.clone())
#[derive(Debug, Default)]
        let total: u64 = ranges.iter().map(|r| r.end - r.start).sum();
use datafusion::physical_plan::metrics::ExecutionPlanMetricsSet;
    let pq_meta = match pq_meta {
        .await
    } else {
) -> std::result::Result<(SchemaRef, u64, Arc<ParquetMetaData>), String> {
        }
    store: Arc<dyn ObjectStore>,
        }
                .get_range(&location, range)
        }
    location: object_store::path::Path,
};
/// On a cache miss we fetch with `PageIndexPolicy::Skip` — never fetching page
///
//!
/// per-file reader creation.
        // cannot use page index because we have collector bitset matches that are not visible
    let file_meta = pq_meta.file_metadata();
    // Cache miss — fetch metadata. When the scoped page-index cache is enabled,
        partition_index: usize,
use datafusion::datasource::physical_plan::ParquetSource;
        let location = self.location.clone();
                .await
            let r = store
        None => {
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Arc<ParquetMetaData>>> {
    config: &RowGroupStreamConfig,
///
                .map(|cached| Arc::clone(cached.parquet_metadata()))
    store: Arc<dyn ObjectStore>,
        .map_err(|e| format!("object-store head {location}: {e}"))?;
}
            ParquetFileMetrics::new(partition_index, file.object_meta.location.as_ref(), metrics);
        _metadata_size_hint: Option<usize>,
    pub file_size: u64,
use datafusion::execution::object_store::ObjectStoreUrl;
        } else {
        metrics: &ExecutionPlanMetricsSet,
use object_store::{ObjectStore, ObjectStoreExt};
                .await
    // Before implementing, verify parquet-rs's `Selection` delivery
                location,
impl CachedMetadataReaderFactory {
/// Create a stream that reads a single row group with full scan.
