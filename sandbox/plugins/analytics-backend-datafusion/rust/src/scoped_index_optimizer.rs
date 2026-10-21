 * The OpenSearch Contributors require contributions made to
        let _ = std::fs::remove_dir_all(&dir);
        let n1: Vec<i32> = (0..ROWS).collect();
use datafusion::physical_expr::utils::collect_columns;
    metadata_cache: Arc<dyn FileMetadataCache>,
            Arc::new(Column::new("a", 0)),
        assert_eq!(
            let Some(parquet) = (config.file_source().as_ref() as &dyn std::any::Any)
    }
            let new_config = FileScanConfigBuilder::from(config.clone())
    fn schema() -> Arc<Schema> {
            stats.entries >= 1 && stats.used_bytes > 0,
//! # Replace, do NOT skip-if-present
        // No predicate, no pushed projection — nothing to scope.
            get_factory(&out),
        }
        }
        let rule = ScopedPageIndexOptimizer::new(store, cache);
                    .filter(|&i| i < num_file_cols)
//! columns, and swaps in a [`ScopedPageIndexReaderFactory`] scoped to those
        let df = ctx.sql("SELECT s0 FROM t WHERE n1 >= 4080").await.unwrap();
            // field names against the file schema would drop `status`, leaving it without a real
        let metadata_cache = ctx.runtime_env().cache_manager.get_file_metadata_cache();
                .downcast_ref::<ParquetSource>()
}
            "no predicate and no projection → nothing to scope → no factory installed"
        let (store, cache) = deps();
        "ScopedPageIndexOptimizer"
    use datafusion::execution::object_store::ObjectStoreUrl;
        assert_eq!(
            !Arc::ptr_eq(&plan, &out),
        ]))
            get_factory(&out),
    /// The rule REPLACES an already-installed factory when a predicate is present
            // Projected column NAMES — the file-schema columns this scan actually READS.
            vec!["a".to_string()],
        let parquet = parquet_for(&sch)
            Some(true),
            rows += b.unwrap().num_rows();
        assert_eq!(rows, 16, "predicate n1>=4080 must keep 16 rows");
        let config =
//! # No-op cases (left exactly as DataFusion would run them)
            // all-row-group, column-scoped page index — see the reader's docs).
        let plan = datasource_exec(parquet);
        );
//! the predicate already pushed onto its `ParquetSource`, derives the predicate
        true
    }
    use datafusion::logical_expr::Operator;
                // No projection pushed → the scan reads every column.
 * SPDX-License-Identifier: Apache-2.0
//!
impl PhysicalOptimizerRule for ScopedPageIndexOptimizer {
        {
use datafusion::datasource::physical_plan::{FileSource, ParquetSource};
///
            (dse.data_source().as_ref() as &dyn std::any::Any).downcast_ref::<FileScanConfig>()?;
            get_factory(&out),
            vec![
        use datafusion::parquet::arrow::ProjectionMask;
                Arc::clone(&self.store),
            get_factory(&out),
    store: Arc<dyn ObjectStore>,
            Field::new("s1", DataType::Utf8, false),
            ],
        );
/*
                .map(|p| {
    }
        })?;
                    .column_indices()
        Self {
        let rewritten = plan.transform_up(|node| {
                .set_data_page_row_count_limit(256)
//!
            Arc::new(DefaultFilesMetadataCache::new(64 * 1024 * 1024)),
    use crate::parquet_page_cache::{clear_scoped_cache_for_test, scoped_cache_stats};
                .with_projection(Some(vec![0])) // project `a` only
        let s1: Vec<String> = (0..ROWS)
        let _ = std::fs::create_dir_all(&dir);
            // Build the scoped factory and reinstall the source. The predicate is
            let projection_names: Vec<String> = match config.file_source().projection() {
        let stats = scoped_cache_stats();
        let sch = Arc::new(Schema::new(vec![
    fn datasource_exec(parquet: ParquetSource) -> Arc<dyn ExecutionPlan> {
            let new_source = parquet.clone().with_parquet_file_reader_factory(factory);
            let props = WriterProperties::builder()
        use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
                return Ok(Transformed::no(node));
            let file_schema = config.file_schema();
}
        )
            // gains nothing from scoping — skip it. A None projection (read-all) or a projection
    /// schema even when `parquet.filter()` is `None`.
    /// A projection-only scan (no predicate pushed down) still needs a scoped
                        .filter(|n| file_schema.index_of(n).is_ok())
        assert_eq!(
//!
//! just because a factory is already set. (A skip-if-present guard was the
                })
//! *which TableProvider* produced the scan. Wiring it into a specific provider
        let file_path = dir.join("data.parquet");
        let n0: Vec<i32> = (0..ROWS).collect();
            .with_collect_stat(true);
        );
            }
            .map(|r| format!("s1_{r:06}_padding_padding"))
    }
    use datafusion_datasource::table_schema::TableSchema;
use datafusion::common::tree_node::{Transformed, TreeNode};
            } else {
        Arc::new(Schema::new(vec![
        let provider = Arc::new(ListingTable::try_new(config).unwrap());
pub struct ScopedPageIndexOptimizer {
                .build();
/// `PhysicalOptimizerRule` has no access to the session; the caller constructs
            "scoped cache must have filled on the listing path: {stats:?}"
use datafusion::physical_plan::ExecutionPlan;
        assert!(
            Some(false),
            // Predicate column NAMES — empty when there's no pushed-down filter.
use object_store::ObjectStore;
                    let mut names: Vec<String> = collect_columns(p)
    }
            let Some(dse) = node.downcast_ref::<DataSourceExec>() else {
        DataSourceExec::from_data_source(config)
            // referenced file-schema column indices, which is exactly the read set we must scope to.
            .infer_schema(&ctx.state(), &table_url)
//! all-column page index every query and caches none of it.
        let plan = DataSourceExec::from_data_source(config);
            // OffsetIndex — and a column that is read but only has the single-page placeholder OI
            // `ProjectionExprs::column_indices()` walks every projection expression and returns the
        ))
            Field::new("n0", DataType::Int32, false),
            stats.misses >= 1,
                projection_names
use datafusion::common::config::ConfigOptions;
//! leaves other scan paths on DataFusion's default reader, which loads the full
            let factory = Arc::new(ScopedPageIndexReaderFactory::new(
        ]));
    use datafusion::execution::cache::DefaultFilesMetadataCache;
//! The scoped page-index loader is a property of *how we read parquet*, not of
    #[test]
                return Ok(Transformed::no(node));
            };
    }
            .with_listing_options(listing_options)
    /// End-to-end through a real `SessionContext` + stock `ListingTable`: write a
            let is_projected =
        let physical = rule.optimize(physical, &ConfigOptions::default()).unwrap();
//! reader.) The indexed path does not run this rule — it uses its own executor.
        );
            Field::new("a", DataType::Int32, false),
    fn name(&self) -> &str {
                Arc::clone(&self.metadata_cache),
        assert_eq!(
            Field::new("n1", DataType::Int32, false),
        let sch = schema(); // fields: a(0), b(1)
        let store: Arc<dyn ObjectStore> = Arc::new(object_store::local::LocalFileSystem::new());
            metadata_cache,
        Arc::new(BinaryExpr::new(
            .with_parquet_file_reader_factory(pre);
    pub fn new(store: Arc<dyn ObjectStore>, metadata_cache: Arc<dyn FileMetadataCache>) -> Self {
            // contain computed fields (e.g. `CASE WHEN status = 200 ...`) whose names are not in the
            store,
        }
//! `ListingTable`, `ShardTableProvider`, and any future parquet provider.
            (cfg.file_source().as_ref() as &dyn std::any::Any).downcast_ref::<ParquetSource>()?;
        Some(pq.parquet_file_reader_factory().is_some())
    /// page-index cache filled — proving the rule installs a working scoped reader
        use arrow::record_batch::RecordBatch;
        let ctx = SessionContext::new();
    /// of whole column chunks. The factory must be installed from the projected
            w.write(&batch).unwrap();
    }
            "precondition: a factory is present"
        let config = ListingTableConfig::new(table_url.clone())
                Arc::new(StringArray::from(s0)),
            get_factory(&plan),
        while let Some(b) = stream.next().await {
    fn optimize(
                return Ok(Transformed::no(node));
        Ok(rewritten.data)
            "first scan must register a scoped-cache miss: {stats:?}"
            get_factory(&plan),
        let out = rule.optimize(plan, &ConfigOptions::default()).unwrap();
    }
            sch.clone(),
            Arc::new(InMemory::new()),
//! columns. It runs after DataFusion's own optimizers (which is when filter
            else {
                Arc::clone(file_schema),
        let out = rule.optimize(plan, &ConfigOptions::default()).unwrap();
            .with_predicate(predicate_on_a())
            lit(5i32),
        ));
                        .map(|c| c.name().to_string())
    fn noop_without_predicate_or_projection() {
/// Installs the scoped page-index reader factory on parquet scans.
        )
            Ok(Transformed::yes(new_dse))
            Arc::clone(&store),
            "rule must rewrite the scan to install the scoped factory, replacing the default"
use datafusion::execution::cache::cache_manager::FileMetadataCache;
    #[test]
        let physical = df.create_physical_plan().await.unwrap();
    /// (DataFusion's `ParquetFormat` always pre-installs its own).
            .with_schema(resolved);
            //
        let s0: Vec<String> = (0..ROWS)
        use datafusion::datasource::listing::{
 */
        (
            .with_file_extension(".parquet")
            None,
    async fn end_to_end_listing_scan_fills_scoped_cache() {
//! Physical optimizer rule that installs the scoped page-index reader factory on
 * this file be licensed under the Apache-2.0 license or a
            // corrupts the page decode ("provided output is too small for the decompressed data").
//! **every** parquet scan in the plan — provider-agnostic.
        ctx.register_table("t", provider).unwrap();
                predicate_names,
    use datafusion::physical_expr::PhysicalExpr;
        use futures::StreamExt;
/// Carries the object store and shared metadata cache because a
        let table_url =
            let mut w = ArrowWriter::try_new(f, sch.clone(), Some(props)).unwrap();
    /// OffsetIndex so the parquet reader fetches only matched-row pages instead
//!  - A `DataSourceExec` that isn't parquet — skipped.
        );
                return Ok(Transformed::no(node));
            .unwrap();
            .collect();
        use datafusion_datasource::file_scan_config::FileScanConfigBuilder;
    /// execute, and assert (a) results are correct and (b) the shared scoped
        let pq =
/// it from the query's `RuntimeEnv`.
        crate::cache::page_index::clear_scoped_cache_for_test();
            .await
//!
use crate::scoped_page_index_reader::ScopedPageIndexReaderFactory;
            .optimize(Arc::clone(&plan), &ConfigOptions::default())
        let rule = ScopedPageIndexOptimizer::new(store, cache);
        use datafusion::prelude::SessionContext;
            Field::new("b", DataType::Int32, false),
        let dir = std::env::temp_dir().join(format!("scoped_e2e_{}", std::process::id()));
                .build();
//! This rule walks the physical plan, finds each parquet `DataSourceExec`, reads
use datafusion::common::Result;
        use datafusion::parquet::arrow::ArrowWriter;
            .collect();
            };
    use super::*;
    use arrow::datatypes::{DataType, Field, Schema};
                projection_names,
            // the projected output field names. With expression push-down the projected schema can
    }
        // Project only column `a` — no predicate.
        // n1 >= 4080 keeps rows 4080..4096 (16 rows); project the non-predicate s0.
    }
    fn installs_factory_when_predicate_present() {
            let projection_names = if is_projected {
                        .into_iter()
                Arc::new(Int32Array::from(n0)),
            Operator::Gt,
            // We must derive these from the projection's underlying column references, NOT from
            "projection-only scan must get a scoped factory for OffsetIndex scoping"
        let out = rule.optimize(plan, &ConfigOptions::default()).unwrap();
            "scoped factory present after rule"
    }
        let (store, cache) = deps();
        let resolved = listing_options
                .set_statistics_enabled(EnabledStatistics::Page)
        let parquet = parquet_for(&sch).with_predicate(predicate_on_a());
    #[test]
        let (store, cache) = deps();
    use datafusion::physical_expr::expressions::{lit, BinaryExpr, Column};
 * compatible open source license.
            if predicate_names.is_empty() && !is_projected {
//! `CachedParquetFileReaderFactory` (the full all-column page-index loader). That
        let rule = ScopedPageIndexOptimizer::new(store, cache);
            // file schema; those expressions still read the base column (`status`). Matching output
            "precondition: no factory yet"
        use arrow::array::{Int32Array, StringArray};
        &self,
//!
        ctx.register_object_store(table_url.as_ref(), Arc::clone(&store));
            .unwrap();
                    names.sort();
        );
        // Serialize on the shared guard — this asserts on the global cache.
        let _g = crate::test_process_globals::lock();
    /// We swap a reader factory only; the scan's output schema is unchanged.
        let plan = datasource_exec(parquet_for(&sch));
//! DataFusion's `ParquetFormat::create_physical_plan` ALWAYS pre-installs its own
        let mut stream =
            Field::new("s0", DataType::Utf8, false),
                Arc::new(Int32Array::from(n1)),
        assert!(
            // retained for parity but not used for RG scoping (Step 1 builds an
        );
use datafusion::datasource::source::DataSourceExec;
//!
                    names
            ListingTableUrl::parse(format!("file://{}", dir.to_str().unwrap())).unwrap();
    ) -> Result<Arc<dyn ExecutionPlan>> {
//! # Why a rule (not a TableProvider)
        let mut rows = 0usize;
                .build();
            // will build all-column OffsetIndex (existing behavior).
//! original bug that made the end-to-end listing scan never use the scoped
            // that already covers every column is not a strict subset.
}
            sch.clone(),
            };
//! pushdown has populated `ParquetSource::predicate`), so it works uniformly for
        assert!(
        assert_eq!(
            };
use datafusion::physical_optimizer::PhysicalOptimizerRule;
            // Only scope when there's something to scope to. A full-schema scan with no predicate
            ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl,
        let parquet = parquet_for(&sch);
                    .into_iter()
mod tests {
        let sch = schema();
                None => Vec::new(),
                    .map(|i| file_schema.field(i).name().to_string())
            FileScanConfigBuilder::new(ObjectStoreUrl::local_filesystem(), Arc::new(parquet))
        let config =
    }
//!    columns — skipped (nothing to scope; the opener loads on demand as today).
                .with_source(Arc::new(new_source))
//!
        use datafusion::datasource::file_format::parquet::ParquetFormat;
        let out = rule
                .build();
                Some(proj) => proj
#[cfg(test)]
    fn installs_factory_for_projection_only_scan() {
    fn replaces_existing_default_factory() {
                !projection_names.is_empty() && projection_names.len() < num_file_cols;
    fn deps() -> (Arc<dyn ObjectStore>, Arc<dyn FileMetadataCache>) {
            Some(true),
        );
            vec!["a".to_string()],
            // Pass empty projection when the scan reads all columns — the factory
            Some(true),
        );
        let rule = ScopedPageIndexOptimizer::new(store, cache);
            Some(false),
        clear_scoped_cache_for_test();
            let mut predicate_names: Vec<String> = predicate
            "optimizer must install a scoped reader factory when a predicate is present"
                Arc::new(StringArray::from(s1)),
            let num_file_cols = file_schema.fields().len();
    /// on the vanilla listing path.
}
        let dse = plan.downcast_ref::<DataSourceExec>()?;
    #[test]
        let plan = datasource_exec(parquet);
        let cfg =
    fn get_factory(plan: &Arc<dyn ExecutionPlan>) -> Option<bool> {
                predicate,
#[derive(Debug)]
    }
        let listing_options = ListingOptions::new(Arc::new(ParquetFormat::new()))
            let new_dse: Arc<dyn ExecutionPlan> = DataSourceExec::from_data_source(new_config);
    use object_store::memory::InMemory;
        let (store, cache) = deps();
impl ScopedPageIndexOptimizer {
            FileScanConfigBuilder::new(ObjectStoreUrl::local_filesystem(), Arc::new(parquet))
        let pre = Arc::new(ScopedPageIndexReaderFactory::new(
        let sch = schema();
use datafusion_datasource::file_scan_config::{FileScanConfig, FileScanConfigBuilder};
    #[tokio::test]
        assert_eq!(
    /// parquet file, register it, plan `SELECT s0 WHERE n1 >= k`, apply the rule,
            Some(true),
        let sch = schema();
        let batch = RecordBatch::try_new(
            let predicate = parquet.filter();
            };
        let rule = ScopedPageIndexOptimizer::new(Arc::clone(&store), metadata_cache);
                Vec::new()
                .as_ref()
            let Some(config) = dse.data_source().as_ref().downcast_ref::<FileScanConfig>() else {
            let f = std::fs::File::create(&file_path).unwrap();
//!  - A parquet scan with no predicate, or whose predicate references no file
            w.close().unwrap();
        .unwrap();
use std::sync::Arc;
    }
                .set_write_batch_size(256)
    fn predicate_on_a() -> Arc<dyn PhysicalExpr> {
            .map(|r| format!("s0_{r:06}_padding_padding"))
            ));
                    .collect(),
            datafusion::physical_plan::execute_stream(physical, ctx.task_ctx()).unwrap();
        };
//! is exactly the factory we want to replace, so this rule does not skip a scan
        plan: Arc<dyn ExecutionPlan>,
                .unwrap_or_default();
        const ROWS: i32 = 4096;
    }
        ParquetSource::new(TableSchema::new(sch.clone(), vec![]))
                    names.dedup();
            Arc::clone(&cache),
    fn parquet_for(sch: &Arc<Schema>) -> ParquetSource {
                        .collect();
    fn schema_check(&self) -> bool {
 *
        _config: &ConfigOptions,
