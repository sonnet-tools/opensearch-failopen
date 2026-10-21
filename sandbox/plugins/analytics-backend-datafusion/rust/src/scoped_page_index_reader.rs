struct ScopedPageIndexReader {
//! native heap.
            }
//!      [`crate::indexed_table::parquet_bridge::load_parquet_metadata`]), then
    /// resolve footer metadata from cache without a `head()` syscall per read.
                if let Some(augmented) = load_scoped_page_index_cols(
//! selects which row groups to scan via its OWN RG-statistics pruning, and its
            "non-predicate col (qty) ColumnIndex must be a NONE placeholder"
        let mut reader = factory.create_reader(0, pf, None, &m).unwrap();
//! time anyway).
            .put(&loc, PutPayload::from_bytes(bytes))
            .expect("augmented metadata has offset index");
        let mut reader = factory.create_reader(0, pf, None, &m).unwrap();
        }))
            // from cache without a per-read `head()` syscall (see
    }
            store: Arc::clone(&self.store),
        assert!(stats.entries >= 1 && stats.misses >= 1 && stats.used_bytes > 0);
            fresh_cache(),
                }
    object_meta: object_store::ObjectMeta,
    use datafusion::parquet::file::page_index::column_index::ColumnIndexMetaData;
            .add((range.end - range.start) as usize);
//! `offset_index[rg][col]` for *its* chosen RGs — a set independent of anything
    fn get_bytes(
    /// here (see module docs).
 * The OpenSearch Contributors require contributions made to
                    &parquet_cols,
//! the full, all-column load. So our reader's `get_metadata`:
            .await
        &mut self,
        );
        let loc = ObjPath::from("data.parquet");
        crate::cache::page_index::clear_scoped_cache_for_test();
    #[tokio::test]
            //    augment with a column-scoped page index. Gated on either being
    async fn stage(bytes: Bytes) -> (Arc<dyn ObjectStore>, ObjPath, u64) {
            "predicate col (price) must have a real ColumnIndex"
            let (file_arrow_schema, _size, footer) = load_parquet_metadata_with_meta(
//! touches panics (`page_row_counts.first().unwrap()` on an empty `OffsetIndex`),
        predicate: Option<Arc<dyn PhysicalExpr>>,
    file_schema: SchemaRef,
            .set_max_row_group_size(32)
        let file_metrics =
            predicate,
    use object_store::path::Path as ObjPath;
    }
            Field::new("qty", DataType::Int32, false),
            predicate_column_names: Arc::clone(&self.predicate_column_names),
    predicate_column_names: Arc<Vec<String>>,
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Arc<ParquetMetaData>>> {
        .boxed()
    use object_store::{ObjectStore, ObjectStoreExt, PutPayload};
    fn get_byte_ranges(
        partition_index: usize,
        let metadata_cache = Arc::clone(&self.metadata_cache);
    fn fresh_cache() -> Arc<dyn FileMetadataCache> {
    /// index is scoped to the predicate column (`price`) — real ColumnIndex for
        );
//!   1. loads footer-only metadata (shared metadata-cache hit — see
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Vec<Bytes>>> {
        let stats = crate::cache::page_index::scoped_cache_stats();
        Ok(Box::new(ScopedPageIndexReader {
            location: file.object_meta.location.clone(),
            Arc::clone(&store),
                object_meta,
//! # Why all row groups (no RG scoping here)
impl ParquetFileReaderFactory for ScopedPageIndexReaderFactory {
use datafusion::parquet::arrow::async_reader::AsyncFileReader;
        // IO-runtime dispatch is handled by the store wrapper around the
    #[tokio::test]
            .expect("augmented metadata has column index");
        let factory = ScopedPageIndexReaderFactory::new(
    /// cache is present (DataFusion's `PageIndexPolicy::Optional`). The invariant
/// to the object store.
        predicate_column_names: Vec<String>,
    /// BOTH columns. Also fills the shared scoped cache.
//!
impl AsyncFileReader for ScopedPageIndexReader {
use futures::FutureExt;
    ///
    use arrow::datatypes::{DataType, Field, Schema};
            projection_column_names: Arc::new(projection_column_names),
        let (bytes, schema) = two_col_parquet();
                let (parquet_cols, offset_cols) = resolve_predicate_parquet_columns_pair(
                Arc::clone(&metadata_cache),
            .bytes_scanned
        &mut self,
//!
//! metadata and the opener loads the page index on demand exactly as today —
        let size = bytes.len() as u64;
}
        let _g = lock_process_globals();
    /// The physical predicate (if any). Retained in the constructor signature for
//!
        let factory = ScopedPageIndexReaderFactory::new(
//! This factory closes that gap using the unified scoped cache
    use arrow::array::{Int32Array, RecordBatch};
        let projection_names = Arc::clone(&self.projection_column_names);
//!   2. augments it with a page index scoped to the predicate columns via
    use datafusion::parquet::arrow::ArrowWriter;
            //    validity check only needs size + last_modified, both already known.
            // 2. Resolve predicate + projection names → parquet leaf indices, then
mod tests {
/// A [`ParquetFileReaderFactory`] that, on `get_metadata`, returns metadata whose
        // registered store, so a plain `.await` already runs on the IO runtime.
//! DataFusion's default reader factory, so when page pruning is enabled the
 * SPDX-License-Identifier: Apache-2.0
        let batch = RecordBatch::try_new(
};
        self.metrics.bytes_scanned.add(total as usize);
    }
    /// this reader guarantees with no predicate is "no scoping", i.e. the scoped
//!
    projection_column_names: Arc<Vec<String>>,
        let (store, loc, size) = stage(bytes).await;
            vec!["price".to_string()],
            metadata_cache: Arc::clone(&self.metadata_cache),
                Arc::new(Int32Array::from(qtys)),
            vec![],
            None,
        let store = Arc::clone(&self.store);
        let meta = reader.get_metadata(None).await.unwrap();
    }
        (Bytes::from(buf), schema)
        assert!(
    /// OffsetIndex to `predicate ∪ projection` instead of all columns. Empty =
        let file_schema = Arc::clone(&self.file_schema);
//!
        .boxed()
                .await
    load_scoped_page_index_cols, resolve_predicate_parquet_columns_pair,
    /// Listing-snapshot metadata (size + last_modified) for `location`. Used to
            // 1. Footer-only metadata (shared metadata-cache hit if pre-seeded).
    ) -> BoxFuture<'_, datafusion::parquet::errors::Result<Bytes>> {
                Arc::clone(&store),
/// parquet indices: the reader resolves names → parquet leaf indices per file via
            projection_column_names: Arc::clone(&self.projection_column_names),
    use object_store::memory::InMemory;
#[derive(Debug)]
}
            .unwrap();
                    return Ok(augmented);
        );
            metrics: file_metrics,
//! correct, just without the scoping benefit for that file. Never a wrong result.
    async fn get_metadata_no_predicate_does_not_scope() {
//! partial page index would lie to it. So the page index is built for ALL row
//! for *every* column) of each surviving file, every query, and caches none of
        assert_eq!(
        }
    }
        ExecutionPlanMetricsSet::new()
        ranges: Vec<std::ops::Range<u64>>,
//! The listing-table path (`ShardTableProvider` / vanilla `ListingTable`) uses
                Arc::new(Int32Array::from(prices)),
//! via `get_metadata`, and — per `opener::load_page_index` — if the returned
        let mut buf: Vec<u8> = Vec::new();
            datafusion::execution::cache::DefaultFilesMetadataCache::new(64 * 1024 * 1024),
    /// File schema (no partition columns), for per-file column resolution.
                    &file_arrow_schema,
};
            .await
//!      (real `ColumnIndex` for predicate columns, real `OffsetIndex` for all
    /// `load_parquet_metadata` still loads the full page index when a metadata
            // `load_parquet_metadata_with_meta`).
    pub fn new(
        let store = Arc::clone(&self.store);
            "no predicate → scoped cache must be untouched"
        let total: u64 = ranges.iter().map(|r| r.end - r.start).sum();
        assert!(
//!
        let mut w = ArrowWriter::try_new(&mut buf, schema.clone(), Some(props)).unwrap();
            ],
        _options: Option<&ArrowReaderOptions>,
        async move {
        ]));
    }
                .await
//! groups, column-scoped only — heap stays bounded because the heavy
        let location = self.location.clone();
/// schema evolution across files (a column absent from one file is just skipped).
use crate::indexed_table::parquet_bridge::load_parquet_metadata_with_meta;
use datafusion::datasource::physical_plan::parquet::{
    // Crate-wide lock so all users of the one process-global scoped cache mutually exclude.
        metadata_cache: Arc<dyn FileMetadataCache>,
    /// File-column names this scan PROJECTS (reads). Used to scope the
            object_meta: file.object_meta.clone(),
//! # Fallback
    file_schema: SchemaRef,
        w.write(&batch).unwrap();
    /// cache stays empty — which holds before and after 1e.
//! `ParquetOpener` loads the **entire** page index (`ColumnIndex` + `OffsetIndex`
/// Carries predicate column *names* + the file schema rather than pre-resolved
        let predicate_names = Arc::clone(&self.predicate_column_names);
    /// File-column names referenced by the query predicate. Empty means "no
        assert!(
    metrics: ParquetFileMetrics,
        let object_meta = self.object_meta.clone();
        ))
    /// fall back to all-column offsets (old behavior).
    location: object_store::path::Path,
            file_schema,
        let schema = Arc::new(Schema::new(vec![
//!
    /// `price`, NONE placeholder for `qty` — while keeping a REAL OffsetIndex for
            ParquetFileMetrics::new(partition_index, file.object_meta.location.as_ref(), metrics);
        crate::cache::page_index::clear_scoped_cache_for_test();
            predicate_column_names: Arc::new(predicate_column_names),
        async move {
//! (no page index, decode/IO error), `get_metadata` returns the footer-only
 *
        store
            Arc::clone(&store),
                .await
        );
        let m = metrics();
            !oi[0][0].page_locations().is_empty() && !oi[0][1].page_locations().is_empty(),
        let pf = PartitionedFile::new(loc.as_ref().to_string(), size);
        let _g = lock_process_globals();
        crate::cache::page_index::clear_scoped_cache_for_test();
//! If there are no predicate columns, or scoped augmentation fails for a file
            // Project both columns so the OffsetIndex is built for both (this test
                &location,
            .column_index()
    ) -> datafusion::common::Result<Box<dyn AsyncFileReader + Send>> {
    metadata_cache: Arc<dyn FileMetadataCache>,
    fn get_metadata(
//!
//! and its page-index gate is per-FILE (both indexes must be `Some`), so a
    async fn get_metadata_returns_scoped_page_index() {
        }
    /// No predicate columns → no scoping happens: `get_metadata` returns the
            // Carry the listing's ObjectMeta so `get_metadata` resolves the footer
        )
    projection_column_names: Arc<Vec<String>>,
}
                .get_ranges(&location, &ranges)
    ParquetFileMetrics, ParquetFileReaderFactory,
    }
    fn create_reader(
//! The scoped `(file, predicate-columns)` cache is shared with the indexed path,
    /// The factory's reader must, on `get_metadata`, return metadata whose page
/*
            vec![],
///
            schema.clone(),
//!   3. returns that augmented metadata.
        .unwrap();
//! `ParquetMetaData` *already* carries a page index, the opener uses it and skips
//! ([`crate::cache::page_index`]). The seam is DataFusion's
use object_store::{ObjectStore, ObjectStoreExt};
            vec!["price".to_string(), "qty".to_string()],
        let location = self.location.clone();
        w.close().unwrap();
        _metadata_size_hint: Option<usize>,
        }
        &mut self,
    ) -> Self {
        let (bytes, schema) = two_col_parquet();
            Field::new("price", DataType::Int32, false),
    /// Two int columns (`price`, `qty`), one row group, four 8-row data pages.
//! it. On wide schemas the `ColumnIndex` (per-page string min/max) dominates the
        Self {
impl ScopedPageIndexReaderFactory {
                    &predicate_names,
use datafusion::physical_expr::PhysicalExpr;
            file_schema: Arc::clone(&self.file_schema),
    /// scoping" — `get_metadata` returns footer-only and the opener loads the
            (0, 0, 0),
                {
            Ok(footer)
            !matches!(ci[0][0], ColumnIndexMetaData::NONE),
        let props = WriterProperties::builder()
        let m = metrics();
            )
}
use datafusion_datasource::PartitionedFile;
            None,
    predicate_column_names: Arc<Vec<String>>,
            schema,
            vec![
                .map_err(|e| ParquetError::External(Box::new(e)))
//! so repeated queries reuse the decoded index across both scan paths.
}
                    &store,
        self.metrics
    #[allow(dead_code)]
        range: std::ops::Range<u64>,
        let qtys: Vec<i32> = (100..132).collect();
use datafusion::physical_plan::metrics::ExecutionPlanMetricsSet;
use datafusion::parquet::arrow::arrow_reader::ArrowReaderOptions;
//! # Why this exists
                    &location,
    fn metrics() -> ExecutionPlanMetricsSet {
        (store, loc, size)
//!
    /// index. Until the base metadata-cache strip lands (Step 1e), the shared
            matches!(ci[0][1], ColumnIndexMetaData::NONE),
 * compatible open source license.
                .map_err(|e| ParquetError::External(Box::new(e)))
            .map_err(|e| ParquetError::General(format!("footer metadata {location}: {e}")))?;
use prost::bytes::Bytes;
                    &footer,
//! `ColumnIndex` is scoped to predicate columns and only the cheap all-column
use futures::future::BoxFuture;
        let pf = PartitionedFile::new(loc.as_ref().to_string(), size);
use arrow::datatypes::SchemaRef;
    /// page index on demand as usual.
        let _meta = reader.get_metadata(None).await.unwrap();
    }
        metrics: &ExecutionPlanMetricsSet,
            store
use std::sync::Arc;
//! page-pruner + reader then dereference `column_index[rg][col]` /
    use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
                    &projection_names,
use crate::cache::page_index::{
    }
    }
                .get_range(&location, range)
    store: Arc<dyn ObjectStore>,
 */
    /// parity with the indexed path, but intentionally NOT used for RG scoping
        crate::cache::page_index::clear_scoped_cache_for_test();
            store
//! `OffsetIndex` spans every RG (and that is required for correctness at read
        }
//! [`ParquetFileReaderFactory`]: the `ParquetOpener` asks the reader for metadata
    use super::*;
                );
        &self,
            .set_write_batch_size(8)
            (stats.entries, stats.misses, stats.hits),
    fn two_col_parquet() -> (Bytes, SchemaRef) {
            "OffsetIndex must be real for every column"
            fresh_cache(),
        );
/// page index is scoped to the query's predicate columns. Data reads go straight
                )
        file: PartitionedFile,
    /// Note: we deliberately do NOT assert the returned metadata has no page
//! we could compute here. Leaving a placeholder entry on an RG DataFusion still
    }
    use datafusion::physical_plan::metrics::ExecutionPlanMetricsSet;
use datafusion::parquet::file::metadata::ParquetMetaData;
        let location = self.location.clone();
            store,
        store: Arc<dyn ObjectStore>,
            //    non-empty: a projection-only query still needs a scoped OffsetIndex.
                    &offset_cols,
use datafusion::parquet::errors::ParquetError;
    store: Arc<dyn ObjectStore>,
#[cfg(test)]
//!      [`crate::cache::page_index::load_scoped_page_index`]
pub struct ScopedPageIndexReaderFactory {
        let (store, loc, size) = stage(bytes).await;
        );
            metadata_cache,
    predicate: Option<Arc<dyn PhysicalExpr>>,
        let oi = meta
use datafusion::execution::cache::cache_manager::FileMetadataCache;
            .offset_index()
//!      columns), and
//! `ScopedPageIndexOptimizer` only swaps the reader factory; DataFusion still
        .boxed()
            schema,
    use crate::test_process_globals::lock as lock_process_globals;
                    &footer,
 * this file be licensed under the Apache-2.0 license or a
/// the same `resolve_predicate_parquet_columns` the indexed path uses, robust to
//! Scoped page-index reader factory for the **listing-table** scan path.
            .build();
        projection_column_names: Vec<String>,
        async move {
        let ci = meta
                    &file_schema,
            //    Use the listing's ObjectMeta rather than a `head()` — the cache
            .set_data_page_row_count_limit(8)
        let prices: Vec<i32> = (0..32).collect();
            .set_statistics_enabled(EnabledStatistics::Page)
        let stats = crate::cache::page_index::scoped_cache_stats();
            if !predicate_names.is_empty() || !projection_names.is_empty() {
    metadata_cache: Arc<dyn FileMetadataCache>,
        let store = Arc::clone(&self.store);
            // asserts a real OffsetIndex for every column).
        Arc::new(crate::cache::MutexFileMetadataCache::new(
        file_schema: SchemaRef,
}
    /// footer load as-is and the scoped cache is never touched.
