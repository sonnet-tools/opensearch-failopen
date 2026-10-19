            location: file.object_meta.location.clone(),
//!
                    return Ok(augmented);
        );
    location: object_store::path::Path,
            .expect("augmented metadata has offset index");
impl ScopedPageIndexReaderFactory {
//! `offset_index[rg][col]` for *its* chosen RGs — a set independent of anything
            store
        let prices: Vec<i32> = (0..32).collect();
        }))
    /// page index on demand as usual.
    }
        let projection_names = Arc::clone(&self.projection_column_names);
    predicate_column_names: Arc<Vec<String>>,
//! This factory closes that gap using the unified scoped cache
        )
            (stats.entries, stats.misses, stats.hits),
            projection_column_names: Arc::clone(&self.projection_column_names),
 * SPDX-License-Identifier: Apache-2.0
    /// Listing-snapshot metadata (size + last_modified) for `location`. Used to
            .set_max_row_group_size(32)
//! so repeated queries reuse the decoded index across both scan paths.
        let _g = lock_process_globals();
                .map_err(|e| ParquetError::External(Box::new(e)))
    /// `price`, NONE placeholder for `qty` — while keeping a REAL OffsetIndex for
struct ScopedPageIndexReader {
                .await
        range: std::ops::Range<u64>,
}
use object_store::{ObjectStore, ObjectStoreExt};
    fn metrics() -> ExecutionPlanMetricsSet {
    /// index is scoped to the predicate column (`price`) — real ColumnIndex for
    predicate_column_names: Arc<Vec<String>>,
            .add((range.end - range.start) as usize);
        let ci = meta
            schema.clone(),
        async move {
    // Crate-wide lock so all users of the one process-global scoped cache mutually exclude.
            ParquetFileMetrics::new(partition_index, file.object_meta.location.as_ref(), metrics);
            "OffsetIndex must be real for every column"
//! [`ParquetFileReaderFactory`]: the `ParquetOpener` asks the reader for metadata
        let m = metrics();
    }
            // Project both columns so the OffsetIndex is built for both (this test
        Arc::new(crate::cache::MutexFileMetadataCache::new(
                &location,
            // 1. Footer-only metadata (shared metadata-cache hit if pre-seeded).
            .expect("augmented metadata has column index");
            //    augment with a column-scoped page index. Gated on either being
        predicate: Option<Arc<dyn PhysicalExpr>>,
use crate::cache::page_index::{
        let _g = lock_process_globals();
        }
    async fn get_metadata_no_predicate_does_not_scope() {
#[cfg(test)]
    /// scoping" — `get_metadata` returns footer-only and the opener loads the
            Arc::clone(&store),
//! groups, column-scoped only — heap stays bounded because the heavy
                object_meta,
    use super::*;
    /// cache stays empty — which holds before and after 1e.
use datafusion::physical_expr::PhysicalExpr;
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
use datafusion::execution::cache::cache_manager::FileMetadataCache;
//! (no page index, decode/IO error), `get_metadata` returns the footer-only
        assert!(stats.entries >= 1 && stats.misses >= 1 && stats.used_bytes > 0);
                    &offset_cols,
    /// `load_parquet_metadata` still loads the full page index when a metadata
            fresh_cache(),
//!      (real `ColumnIndex` for predicate columns, real `OffsetIndex` for all
    }
            vec!["price".to_string()],
        .boxed()
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Bytes>> {
    fn create_reader(
///
    fn get_bytes(
            .bytes_scanned
//! # Fallback
//! `OffsetIndex` spans every RG (and that is required for correctness at read
//!   1. loads footer-only metadata (shared metadata-cache hit — see
        &self,
        crate::cache::page_index::clear_scoped_cache_for_test();
                {
/*
    }
                Arc::new(Int32Array::from(qtys)),
        let schema = Arc::new(Schema::new(vec![
        store
    }
 *
        let object_meta = self.object_meta.clone();
            .await
/// A [`ParquetFileReaderFactory`] that, on `get_metadata`, returns metadata whose
            vec![],
//!      [`crate::cache::page_index::load_scoped_page_index`]
//! The listing-table path (`ShardTableProvider` / vanilla `ListingTable`) uses
    ) -> datafusion::common::Result<Box<dyn AsyncFileReader + Send>> {
            .unwrap();
    metrics: ParquetFileMetrics,
    /// BOTH columns. Also fills the shared scoped cache.
        let (store, loc, size) = stage(bytes).await;
use prost::bytes::Bytes;
                    &footer,
                if let Some(augmented) = load_scoped_page_index_cols(
use arrow::datatypes::SchemaRef;
            vec![
            fresh_cache(),
mod tests {
            .offset_index()
        let (bytes, schema) = two_col_parquet();
//! `ColumnIndex` is scoped to predicate columns and only the cheap all-column
 * The OpenSearch Contributors require contributions made to
    #[tokio::test]
}
        assert!(
                .await
        crate::cache::page_index::clear_scoped_cache_for_test();
}
use datafusion::parquet::errors::ParquetError;
//!
        .boxed()
            None,
            let (file_arrow_schema, _size, footer) = load_parquet_metadata_with_meta(
    }
    ///
    /// parity with the indexed path, but intentionally NOT used for RG scoping
        let factory = ScopedPageIndexReaderFactory::new(
    object_meta: object_store::ObjectMeta,
}
        async move {
            metadata_cache,
            .column_index()
impl ParquetFileReaderFactory for ScopedPageIndexReaderFactory {
/// page index is scoped to the query's predicate columns. Data reads go straight
        metrics: &ExecutionPlanMetricsSet,
//!   3. returns that augmented metadata.
                Arc::clone(&store),
            ],
        let pf = PartitionedFile::new(loc.as_ref().to_string(), size);
            // `load_parquet_metadata_with_meta`).
        &mut self,
        ExecutionPlanMetricsSet::new()
//! native heap.
            !matches!(ci[0][0], ColumnIndexMetaData::NONE),
    store: Arc<dyn ObjectStore>,
//! `ParquetOpener` loads the **entire** page index (`ColumnIndex` + `OffsetIndex`
//! # Why all row groups (no RG scoping here)
//! The scoped `(file, predicate-columns)` cache is shared with the indexed path,
    /// The physical predicate (if any). Retained in the constructor signature for
    metadata_cache: Arc<dyn FileMetadataCache>,
        let pf = PartitionedFile::new(loc.as_ref().to_string(), size);
        .unwrap();
        }
        assert!(
        file: PartitionedFile,
//! via `get_metadata`, and — per `opener::load_page_index` — if the returned
//!
//! metadata and the opener loads the page index on demand exactly as today —
//! partial page index would lie to it. So the page index is built for ALL row
    projection_column_names: Arc<Vec<String>>,
                let (parquet_cols, offset_cols) = resolve_predicate_parquet_columns_pair(
                .await
            // Carry the listing's ObjectMeta so `get_metadata` resolves the footer
use datafusion::parquet::file::metadata::ParquetMetaData;
use datafusion_datasource::PartitionedFile;
            Arc::clone(&store),
                    &location,
        );
        let oi = meta
        Self {
        let m = metrics();
        let location = self.location.clone();
    /// resolve footer metadata from cache without a `head()` syscall per read.
                    &predicate_names,
        let (store, loc, size) = stage(bytes).await;
        _metadata_size_hint: Option<usize>,
    /// cache is present (DataFusion's `PageIndexPolicy::Optional`). The invariant
                .get_ranges(&location, &ranges)
                .get_range(&location, range)
            schema,
        self.metrics.bytes_scanned.add(total as usize);
use datafusion::datasource::physical_plan::parquet::{
    use object_store::path::Path as ObjPath;
    /// Two int columns (`price`, `qty`), one row group, four 8-row data pages.
    async fn stage(bytes: Bytes) -> (Arc<dyn ObjectStore>, ObjPath, u64) {
        assert!(
//! `ScopedPageIndexOptimizer` only swaps the reader factory; DataFusion still
        let batch = RecordBatch::try_new(
        let file_metrics =
            // 2. Resolve predicate + projection names → parquet leaf indices, then
    fn get_metadata(
//! page-pruner + reader then dereference `column_index[rg][col]` /
//!
//!      [`crate::indexed_table::parquet_bridge::load_parquet_metadata`]), then
    /// footer load as-is and the scoped cache is never touched.
/// to the object store.
        );
/// the same `resolve_predicate_parquet_columns` the indexed path uses, robust to
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Vec<Bytes>>> {
//! touches panics (`page_row_counts.first().unwrap()` on an empty `OffsetIndex`),
use datafusion::physical_plan::metrics::ExecutionPlanMetricsSet;
            Field::new("price", DataType::Int32, false),
    /// Note: we deliberately do NOT assert the returned metadata has no page
//!      columns), and
    /// here (see module docs).
        self.metrics
        let stats = crate::cache::page_index::scoped_cache_stats();
            "no predicate → scoped cache must be untouched"
            Ok(footer)
            .build();
            .map_err(|e| ParquetError::General(format!("footer metadata {location}: {e}")))?;
    file_schema: SchemaRef,
            //    non-empty: a projection-only query still needs a scoped OffsetIndex.
            .set_data_page_row_count_limit(8)
    use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
        let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
            }
        let mut reader = factory.create_reader(0, pf, None, &m).unwrap();
pub struct ScopedPageIndexReaderFactory {
//! ([`crate::cache::page_index`]). The seam is DataFusion's
//! we could compute here. Leaving a placeholder entry on an RG DataFusion still
//! If there are no predicate columns, or scoped augmentation fails for a file
            matches!(ci[0][1], ColumnIndexMetaData::NONE),
//! time anyway).
        metadata_cache: Arc<dyn FileMetadataCache>,
use crate::indexed_table::parquet_bridge::load_parquet_metadata_with_meta;
/// schema evolution across files (a column absent from one file is just skipped).
                )
            // from cache without a per-read `head()` syscall (see
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Arc<ParquetMetaData>>> {
use std::sync::Arc;
        let total: u64 = ranges.iter().map(|r| r.end - r.start).sum();
    predicate: Option<Arc<dyn PhysicalExpr>>,
    /// this reader guarantees with no predicate is "no scoping", i.e. the scoped
        predicate_column_names: Vec<String>,
            None,
                    &file_arrow_schema,
//!
    use datafusion::parquet::file::page_index::column_index::ColumnIndexMetaData;
        async move {
            (0, 0, 0),
                    &parquet_cols,
    use arrow::array::{Int32Array, RecordBatch};
    }
    /// File schema (no partition columns), for per-file column resolution.
        let qtys: Vec<i32> = (100..132).collect();
                    &footer,
    #[allow(dead_code)]
//! selects which row groups to scan via its OWN RG-statistics pruning, and its
        w.write(&batch).unwrap();
    store: Arc<dyn ObjectStore>,
    }
            if !predicate_names.is_empty() || !projection_names.is_empty() {
                }
    /// fall back to all-column offsets (old behavior).
        w.close().unwrap();
    fn fresh_cache() -> Arc<dyn FileMetadataCache> {
                Arc::new(Int32Array::from(prices)),
            datafusion::execution::cache::DefaultFilesMetadataCache::new(64 * 1024 * 1024),
//! for *every* column) of each surviving file, every query, and caches none of
        let (bytes, schema) = two_col_parquet();
        ))
//! `ParquetMetaData` *already* carries a page index, the opener uses it and skips
            vec!["price".to_string(), "qty".to_string()],
                    &projection_names,
    use object_store::memory::InMemory;
        );
            store,
//!   2. augments it with a page index scoped to the predicate columns via
        assert_eq!(
        let factory = ScopedPageIndexReaderFactory::new(
            .set_write_batch_size(8)
//! and its page-index gate is per-FILE (both indexes must be `Some`), so a
            )
            "predicate col (price) must have a real ColumnIndex"
                    &store,
        );
            store: Arc::clone(&self.store),
            file_schema,
        let predicate_names = Arc::clone(&self.predicate_column_names);
        partition_index: usize,
    #[tokio::test]
//! it. On wide schemas the `ColumnIndex` (per-page string min/max) dominates the
        let meta = reader.get_metadata(None).await.unwrap();
        }
            Field::new("qty", DataType::Int32, false),
use futures::future::BoxFuture;
        _options: Option<&ArrowReaderOptions>,
use datafusion::parquet::arrow::arrow_reader::ArrowReaderOptions;
            metrics: file_metrics,
 * this file be licensed under the Apache-2.0 license or a
    /// File-column names this scan PROJECTS (reads). Used to scope the
            file_schema: Arc::clone(&self.file_schema),
            //    Use the listing's ObjectMeta rather than a `head()` — the cache
        let stats = crate::cache::page_index::scoped_cache_stats();
        let _meta = reader.get_metadata(None).await.unwrap();
            schema,
};
        let loc = ObjPath::from("data.parquet");
            .await
}
        let mut buf: Vec<u8> = Vec::new();
            //    validity check only needs size + last_modified, both already known.
    /// No predicate columns → no scoping happens: `get_metadata` returns the
            predicate_column_names: Arc::clone(&self.predicate_column_names),
            "non-predicate col (qty) ColumnIndex must be a NONE placeholder"
                    &file_schema,
        let store = Arc::clone(&self.store);
        projection_column_names: Vec<String>,
    use datafusion::physical_plan::metrics::ExecutionPlanMetricsSet;
//! Scoped page-index reader factory for the **listing-table** scan path.
    /// The factory's reader must, on `get_metadata`, return metadata whose page
    file_schema: SchemaRef,
        let location = self.location.clone();
//! # Why this exists
    }
/// parquet indices: the reader resolves names → parquet leaf indices per file via
    pub fn new(
    }
    use crate::test_process_globals::lock as lock_process_globals;
 * compatible open source license.
    async fn get_metadata_returns_scoped_page_index() {
    use arrow::datatypes::{DataType, Field, Schema};
            .put(&loc, PutPayload::from_bytes(bytes))
        // IO-runtime dispatch is handled by the store wrapper around the
/// Carries predicate column *names* + the file schema rather than pre-resolved
        file_schema: SchemaRef,
        let location = self.location.clone();
//! correct, just without the scoping benefit for that file. Never a wrong result.
        let size = bytes.len() as u64;
#[derive(Debug)]
 */
        (Bytes::from(buf), schema)
    /// File-column names referenced by the query predicate. Empty means "no
//!
        let props = WriterProperties::builder()
        crate::cache::page_index::clear_scoped_cache_for_test();
        let store = Arc::clone(&self.store);
//!
//! DataFusion's default reader factory, so when page pruning is enabled the
        &mut self,
            metadata_cache: Arc::clone(&self.metadata_cache),
    projection_column_names: Arc<Vec<String>>,
        let file_schema = Arc::clone(&self.file_schema);
    use datafusion::parquet::arrow::ArrowWriter;
}
        .boxed()
    fn get_byte_ranges(
            store
//!
        );
    /// OffsetIndex to `predicate ∪ projection` instead of all columns. Empty =
    ) -> Self {
//! the full, all-column load. So our reader's `get_metadata`:
            projection_column_names: Arc::new(projection_column_names),
        store: Arc<dyn ObjectStore>,
        &mut self,
//!
            object_meta: file.object_meta.clone(),
        Ok(Box::new(ScopedPageIndexReader {
use datafusion::parquet::arrow::async_reader::AsyncFileReader;
        crate::cache::page_index::clear_scoped_cache_for_test();
impl AsyncFileReader for ScopedPageIndexReader {
            vec![],
            predicate,
    metadata_cache: Arc<dyn FileMetadataCache>,
    fn two_col_parquet() -> (Bytes, SchemaRef) {
use futures::FutureExt;
        let store = Arc::clone(&self.store);
        ]));
};
        let mut reader = factory.create_reader(0, pf, None, &m).unwrap();
        }
    load_scoped_page_index_cols, resolve_predicate_parquet_columns_pair,
        let metadata_cache = Arc::clone(&self.metadata_cache);
    /// index. Until the base metadata-cache strip lands (Step 1e), the shared
            predicate_column_names: Arc::new(predicate_column_names),
                .map_err(|e| ParquetError::External(Box::new(e)))
        // registered store, so a plain `.await` already runs on the IO runtime.
    }
            // asserts a real OffsetIndex for every column).
        ranges: Vec<std::ops::Range<u64>>,
    use object_store::{ObjectStore, ObjectStoreExt, PutPayload};
            .set_statistics_enabled(EnabledStatistics::Page)
            !oi[0][0].page_locations().is_empty() && !oi[0][1].page_locations().is_empty(),
    ParquetFileMetrics, ParquetFileReaderFactory,
        (store, loc, size)
                Arc::clone(&metadata_cache),
                );
