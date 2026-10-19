                .as_ref()
        let sch = Arc::new(Schema::new(vec![
//! just because a factory is already set. (A skip-if-present guard was the
            "scoped factory present after rule"
//!  - A parquet scan with no predicate, or whose predicate references no file
    #[test]
        let plan = datasource_exec(parquet);
        let rule = ScopedPageIndexOptimizer::new(store, cache);
                !projection_names.is_empty() && projection_names.len() < num_file_cols;
            // field names against the file schema would drop `status`, leaving it without a real
        use datafusion_datasource::file_scan_config::FileScanConfigBuilder;
        .unwrap();
    /// parquet file, register it, plan `SELECT s0 WHERE n1 >= k`, apply the rule,
            .with_collect_stat(true);
    pub fn new(store: Arc<dyn ObjectStore>, metadata_cache: Arc<dyn FileMetadataCache>) -> Self {
    use datafusion::physical_expr::expressions::{lit, BinaryExpr, Column};
    fn datasource_exec(parquet: ParquetSource) -> Arc<dyn ExecutionPlan> {
            else {
            ListingTableUrl::parse(format!("file://{}", dir.to_str().unwrap())).unwrap();
        );
    }
}
        let n1: Vec<i32> = (0..ROWS).collect();
            let num_file_cols = file_schema.fields().len();
    /// The rule REPLACES an already-installed factory when a predicate is present
        use arrow::record_batch::RecordBatch;
            // all-row-group, column-scoped page index — see the reader's docs).
    fn deps() -> (Arc<dyn ObjectStore>, Arc<dyn FileMetadataCache>) {
            (cfg.file_source().as_ref() as &dyn std::any::Any).downcast_ref::<ParquetSource>()?;
    fn schema_check(&self) -> bool {
            "projection-only scan must get a scoped factory for OffsetIndex scoping"
            let mut predicate_names: Vec<String> = predicate
            .map(|r| format!("s0_{r:06}_padding_padding"))
//! **every** parquet scan in the plan — provider-agnostic.
    fn get_factory(plan: &Arc<dyn ExecutionPlan>) -> Option<bool> {
        (
        Arc::new(Schema::new(vec![
        let df = ctx.sql("SELECT s0 FROM t WHERE n1 >= 4080").await.unwrap();
            .await
        assert_eq!(rows, 16, "predicate n1>=4080 must keep 16 rows");
            store,
    use datafusion_datasource::table_schema::TableSchema;
        DataSourceExec::from_data_source(config)
}
            Some(true),
        while let Some(b) = stream.next().await {
        );
                return Ok(Transformed::no(node));
            Arc::new(DefaultFilesMetadataCache::new(64 * 1024 * 1024)),
    store: Arc<dyn ObjectStore>,
            w.close().unwrap();
        let _g = crate::test_process_globals::lock();
        let out = rule.optimize(plan, &ConfigOptions::default()).unwrap();
                        .into_iter()
            // Build the scoped factory and reinstall the source. The predicate is
 * The OpenSearch Contributors require contributions made to
        let (store, cache) = deps();
        }
        let rule = ScopedPageIndexOptimizer::new(store, cache);
        assert!(
use datafusion::physical_optimizer::PhysicalOptimizerRule;
                predicate_names,
            Some(true),
//! # Why a rule (not a TableProvider)
            // Predicate column NAMES — empty when there's no pushed-down filter.
        use datafusion::prelude::SessionContext;
                .build();
//!
        assert_eq!(
                .map(|p| {
                Arc::new(StringArray::from(s0)),
            let Some(dse) = node.downcast_ref::<DataSourceExec>() else {
        use arrow::array::{Int32Array, StringArray};
        clear_scoped_cache_for_test();
        );
        let rule = ScopedPageIndexOptimizer::new(Arc::clone(&store), metadata_cache);
    }
        let plan = datasource_exec(parquet);
                .build();
            .with_file_extension(".parquet")
//! is exactly the factory we want to replace, so this rule does not skip a scan
    /// of whole column chunks. The factory must be installed from the projected
        let (store, cache) = deps();
        const ROWS: i32 = 4096;
    fn schema() -> Arc<Schema> {
use datafusion::execution::cache::cache_manager::FileMetadataCache;
/// it from the query's `RuntimeEnv`.
        let rule = ScopedPageIndexOptimizer::new(store, cache);
        use futures::StreamExt;
use datafusion::physical_plan::ExecutionPlan;
//! DataFusion's `ParquetFormat::create_physical_plan` ALWAYS pre-installs its own
use datafusion::datasource::source::DataSourceExec;
            .unwrap();
use datafusion::common::config::ConfigOptions;
            "precondition: a factory is present"
    use datafusion::logical_expr::Operator;
            // We must derive these from the projection's underlying column references, NOT from
                Arc::clone(&self.store),
            get_factory(&out),
            Field::new("b", DataType::Int32, false),
            Some(true),
            vec!["a".to_string()],
        ));
        Arc::new(BinaryExpr::new(
                    .into_iter()
        );
        let provider = Arc::new(ListingTable::try_new(config).unwrap());
        let pq =
            .collect();
            None,
    }
                Arc::clone(&self.metadata_cache),
    /// A projection-only scan (no predicate pushed down) still needs a scoped
            stats.entries >= 1 && stats.used_bytes > 0,
            sch.clone(),
                .build();
        };
            metadata_cache,
        let physical = rule.optimize(physical, &ConfigOptions::default()).unwrap();
        assert!(
        );
/// Carries the object store and shared metadata cache because a
    async fn end_to_end_listing_scan_fills_scoped_cache() {
    }
            !Arc::ptr_eq(&plan, &out),
        use datafusion::parquet::file::properties::{EnabledStatistics, WriterProperties};
        let mut stream =
            ListingOptions, ListingTable, ListingTableConfig, ListingTableUrl,
use datafusion::common::Result;
        let config =
            ],
                .set_statistics_enabled(EnabledStatistics::Page)
            .collect();
/// `PhysicalOptimizerRule` has no access to the session; the caller constructs
//! # No-op cases (left exactly as DataFusion would run them)
    fn installs_factory_when_predicate_present() {
    use datafusion::execution::object_store::ObjectStoreUrl;
        assert!(
            get_factory(&out),
    /// execute, and assert (a) results are correct and (b) the shared scoped
                .with_projection(Some(vec![0])) // project `a` only
            let props = WriterProperties::builder()
            let Some(parquet) = (config.file_source().as_ref() as &dyn std::any::Any)
    #[test]
                .with_source(Arc::new(new_source))
            get_factory(&plan),
        );
                projection_names,
//! # Replace, do NOT skip-if-present
        ctx.register_object_store(table_url.as_ref(), Arc::clone(&store));
            };
            };
                    .collect(),
        {
        "ScopedPageIndexOptimizer"
        let dse = plan.downcast_ref::<DataSourceExec>()?;
        )
            // retained for parity but not used for RG scoping (Step 1 builds an
            Field::new("n0", DataType::Int32, false),
                Some(proj) => proj
            "scoped cache must have filled on the listing path: {stats:?}"
            let mut w = ArrowWriter::try_new(f, sch.clone(), Some(props)).unwrap();
        use datafusion::parquet::arrow::ArrowWriter;
        Ok(rewritten.data)
    fn predicate_on_a() -> Arc<dyn PhysicalExpr> {
//! columns, and swaps in a [`ScopedPageIndexReaderFactory`] scoped to those
        ctx.register_table("t", provider).unwrap();
//! This rule walks the physical plan, finds each parquet `DataSourceExec`, reads
            .with_parquet_file_reader_factory(pre);
            // corrupts the page decode ("provided output is too small for the decompressed data").
        _config: &ConfigOptions,
            .with_predicate(predicate_on_a())
            Some(true),
                projection_names
                // No projection pushed → the scan reads every column.
            Ok(Transformed::yes(new_dse))
            let new_config = FileScanConfigBuilder::from(config.clone())
            Arc::clone(&store),
        );
/// Installs the scoped page-index reader factory on parquet scans.
        let _ = std::fs::remove_dir_all(&dir);
                Arc::new(Int32Array::from(n1)),
mod tests {
    use object_store::memory::InMemory;
            stats.misses >= 1,
}
        let ctx = SessionContext::new();
        let out = rule
                        .collect();
    }
pub struct ScopedPageIndexOptimizer {
            FileScanConfigBuilder::new(ObjectStoreUrl::local_filesystem(), Arc::new(parquet))
//!
            datafusion::physical_plan::execute_stream(physical, ctx.task_ctx()).unwrap();
            Field::new("s0", DataType::Utf8, false),
//!
        );
            "rule must rewrite the scan to install the scoped factory, replacing the default"
            .with_listing_options(listing_options)
    }
            // file schema; those expressions still read the base column (`status`). Matching output
///
        // n1 >= 4080 keeps rows 4080..4096 (16 rows); project the non-predicate s0.
    }
        let rule = ScopedPageIndexOptimizer::new(store, cache);
            Arc::new(InMemory::new()),
//! `ListingTable`, `ShardTableProvider`, and any future parquet provider.
    }
        let s0: Vec<String> = (0..ROWS)
        let plan = DataSourceExec::from_data_source(config);
    fn name(&self) -> &str {
            // OffsetIndex — and a column that is read but only has the single-page placeholder OI
//! pushdown has populated `ParquetSource::predicate`), so it works uniformly for
//! `CachedParquetFileReaderFactory` (the full all-column page-index loader). That
//! columns. It runs after DataFusion's own optimizers (which is when filter
                Arc::new(StringArray::from(s1)),
#[cfg(test)]
    use datafusion::physical_expr::PhysicalExpr;
        let table_url =
        // Serialize on the shared guard — this asserts on the global cache.
            // the projected output field names. With expression push-down the projected schema can
            // will build all-column OffsetIndex (existing behavior).
    use arrow::datatypes::{DataType, Field, Schema};
        let out = rule.optimize(plan, &ConfigOptions::default()).unwrap();
    fn replaces_existing_default_factory() {
            sch.clone(),
        let metadata_cache = ctx.runtime_env().cache_manager.get_file_metadata_cache();
            let predicate = parquet.filter();
        let out = rule.optimize(plan, &ConfigOptions::default()).unwrap();
#[derive(Debug)]
        let sch = schema();
            let new_source = parquet.clone().with_parquet_file_reader_factory(factory);
            get_factory(&out),
            // Pass empty projection when the scan reads all columns — the factory
    }
    fn parquet_for(sch: &Arc<Schema>) -> ParquetSource {
        ]))
            };
        assert_eq!(
        assert_eq!(
            Field::new("n1", DataType::Int32, false),
            .with_schema(resolved);
//!
            Operator::Gt,
            // referenced file-schema column indices, which is exactly the read set we must scope to.
            "optimizer must install a scoped reader factory when a predicate is present"
//! Physical optimizer rule that installs the scoped page-index reader factory on
//! The scoped page-index loader is a property of *how we read parquet*, not of
        let config =
//! original bug that made the end-to-end listing scan never use the scoped
            ));
                })
            let Some(config) = dse.data_source().as_ref().downcast_ref::<FileScanConfig>() else {
        plan: Arc<dyn ExecutionPlan>,
            (dse.data_source().as_ref() as &dyn std::any::Any).downcast_ref::<FileScanConfig>()?;
        let stats = scoped_cache_stats();
use datafusion::physical_expr::utils::collect_columns;
    /// OffsetIndex so the parquet reader fetches only matched-row pages instead
//! *which TableProvider* produced the scan. Wiring it into a specific provider
                    .filter(|&i| i < num_file_cols)
            let new_dse: Arc<dyn ExecutionPlan> = DataSourceExec::from_data_source(new_config);
impl PhysicalOptimizerRule for ScopedPageIndexOptimizer {
                return Ok(Transformed::no(node));
    /// schema even when `parquet.filter()` is `None`.
        assert_eq!(
            if predicate_names.is_empty() && !is_projected {
            Some(false),
            };
        )
        // Project only column `a` — no predicate.
    #[tokio::test]
//!    columns — skipped (nothing to scope; the opener loads on demand as today).
    /// (DataFusion's `ParquetFormat` always pre-installs its own).
                    names
use crate::scoped_page_index_reader::ScopedPageIndexReaderFactory;
 */
                return Ok(Transformed::no(node));
            w.write(&batch).unwrap();
                Arc::new(Int32Array::from(n0)),
        let parquet = parquet_for(&sch);
            // Projected column NAMES — the file-schema columns this scan actually READS.
//!
    #[test]
use datafusion::common::tree_node::{Transformed, TreeNode};
        }
        let s1: Vec<String> = (0..ROWS)
        ))
        // No predicate, no pushed projection — nothing to scope.
        let store: Arc<dyn ObjectStore> = Arc::new(object_store::local::LocalFileSystem::new());
                .unwrap_or_default();
        );
 * this file be licensed under the Apache-2.0 license or a
        let n0: Vec<i32> = (0..ROWS).collect();
impl ScopedPageIndexOptimizer {
    }
        Some(pq.parquet_file_reader_factory().is_some())
            let file_schema = config.file_schema();
        let sch = schema(); // fields: a(0), b(1)
            get_factory(&plan),
            vec!["a".to_string()],
/*
//!
    }
//! all-column page index every query and caches none of it.
            Some(false),
        &self,
                    names.dedup();
        ]));
        let dir = std::env::temp_dir().join(format!("scoped_e2e_{}", std::process::id()));
                Vec::new()
            Arc::clone(&cache),
            let projection_names: Vec<String> = match config.file_source().projection() {
        let listing_options = ListingOptions::new(Arc::new(ParquetFormat::new()))
    /// We swap a reader factory only; the scan's output schema is unchanged.
    metadata_cache: Arc<dyn FileMetadataCache>,
        let mut rows = 0usize;
        let (store, cache) = deps();
            vec![
        let plan = datasource_exec(parquet_for(&sch));
            .unwrap();
            rows += b.unwrap().num_rows();
            .map(|r| format!("s1_{r:06}_padding_padding"))
            // contain computed fields (e.g. `CASE WHEN status = 200 ...`) whose names are not in the
    /// End-to-end through a real `SessionContext` + stock `ListingTable`: write a
//!  - A `DataSourceExec` that isn't parquet — skipped.
        let sch = schema();
        let pre = Arc::new(ScopedPageIndexReaderFactory::new(
        let config = ListingTableConfig::new(table_url.clone())
            "precondition: no factory yet"
                Arc::clone(file_schema),
            // Only scope when there's something to scope to. A full-schema scan with no predicate
 * SPDX-License-Identifier: Apache-2.0
    fn noop_without_predicate_or_projection() {
            // that already covers every column is not a strict subset.
            FileScanConfigBuilder::new(ObjectStoreUrl::local_filesystem(), Arc::new(parquet))
use object_store::ObjectStore;
        use datafusion::datasource::listing::{
//! leaves other scan paths on DataFusion's default reader, which loads the full
    #[test]
}
    ) -> Result<Arc<dyn ExecutionPlan>> {
            Field::new("a", DataType::Int32, false),
        }
            "no predicate and no projection → nothing to scope → no factory installed"
        let sch = schema();
    }
use datafusion::datasource::physical_plan::{FileSource, ParquetSource};
//! reader.) The indexed path does not run this rule — it uses its own executor.
            // `ProjectionExprs::column_indices()` walks every projection expression and returns the
    }
            "first scan must register a scoped-cache miss: {stats:?}"
                        .filter(|n| file_schema.index_of(n).is_ok())
            Arc::new(Column::new("a", 0)),
                .build();
                .set_write_batch_size(256)
        let cfg =
            let projection_names = if is_projected {
        let parquet = parquet_for(&sch)
            // gains nothing from scoping — skip it. A None projection (read-all) or a projection
        let (store, cache) = deps();
                predicate,
        })?;
                return Ok(Transformed::no(node));
    use crate::parquet_page_cache::{clear_scoped_cache_for_test, scoped_cache_stats};
    }
        ParquetSource::new(TableSchema::new(sch.clone(), vec![]))
            let factory = Arc::new(ScopedPageIndexReaderFactory::new(
use datafusion_datasource::file_scan_config::{FileScanConfig, FileScanConfigBuilder};
    fn installs_factory_for_projection_only_scan() {
    use super::*;
                None => Vec::new(),
            let is_projected =
                    let mut names: Vec<String> = collect_columns(p)
    }
        assert_eq!(
                        .map(|c| c.name().to_string())
            //
        assert_eq!(
        let file_path = dir.join("data.parquet");
                .downcast_ref::<ParquetSource>()
    fn optimize(
        true
            .optimize(Arc::clone(&plan), &ConfigOptions::default())
        let _ = std::fs::create_dir_all(&dir);
        let rewritten = plan.transform_up(|node| {
            .infer_schema(&ctx.state(), &table_url)
        use datafusion::parquet::arrow::ProjectionMask;
use std::sync::Arc;
            } else {
//! the predicate already pushed onto its `ParquetSource`, derives the predicate
            lit(5i32),
        let parquet = parquet_for(&sch).with_predicate(predicate_on_a());
                    .column_indices()
            }
        Self {
                .set_data_page_row_count_limit(256)
        crate::cache::page_index::clear_scoped_cache_for_test();
//!
    /// page-index cache filled — proving the rule installs a working scoped reader
    /// on the vanilla listing path.
 *
        use datafusion::datasource::file_format::parquet::ParquetFormat;
            get_factory(&out),
            let f = std::fs::File::create(&file_path).unwrap();
                    .map(|i| file_schema.field(i).name().to_string())
 * compatible open source license.
        let batch = RecordBatch::try_new(
                    names.sort();
            Field::new("s1", DataType::Utf8, false),
    use datafusion::execution::cache::DefaultFilesMetadataCache;
            };
        let physical = df.create_physical_plan().await.unwrap();
        let resolved = listing_options
