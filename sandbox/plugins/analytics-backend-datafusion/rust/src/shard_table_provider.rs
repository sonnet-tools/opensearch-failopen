            vec![Arc::new(Field::new("row_base", DataType::Int64, true))],
        // ProjectRowIdOptimizer relies on the partition value matching the file's true offset.
    ) -> Result<Arc<dyn ExecutionPlan>> {
            .config
            .field("files", &self.config.files.len())
                pf = pf.with_statistics(file_stats);
 * compatible open source license.
                    num_rows: Precision::Exact(file_info.num_rows as usize),
        TableType::Base
}
use std::sync::Arc;
        // Invariant: files are ordered by ascending row_base (build_shard_files contract).
        fields.push(Arc::new(Field::new("row_base", DataType::Int64, true)));
    async fn scan(
impl std::fmt::Debug for ShardTableProvider {
        debug_assert!(
            .files
}
use datafusion::arrow::datatypes::{DataType, Field, Schema, SchemaRef};
 * SPDX-License-Identifier: Apache-2.0
        }
        let mut fields: Vec<Arc<Field>> = config.file_schema.fields().iter().cloned().collect();
pub struct ShardTableConfig {
use datafusion::datasource::TableType;
                    column_statistics: vec![
    fn schema(&self) -> SchemaRef {
    }
        );
        let file_scan_config = builder.build();
    }
                }
        let table_schema = TableSchema::new(
use datafusion_datasource::table_schema::TableSchema;
use datafusion::catalog::{Session, TableProvider};
impl ShardTableProvider {
                let file_stats = Arc::new(Statistics {
                    pf = pf.with_extensions(Arc::new(plan.clone()));
        let mut builder =
                    total_byte_size: Precision::Inexact(file_info.object_meta.size as usize),
        let row_base_idx = num_file_cols;
        let table_schema = Arc::new(Schema::new(fields));
        Self {
                    p.push(row_base_idx);
    ) -> Result<Vec<TableProviderFilterPushDown>> {
        None
    config: ShardTableConfig,
                pf.partition_values = vec![ScalarValue::Int64(Some(file_info.row_base))];
}
            .collect();
    fn supports_filters_pushdown(
use datafusion_datasource::file_scan_config::FileScanConfigBuilder;
            self.config.files.windows(2).all(|w| w[0].row_base <= w[1].row_base),
            .with_projection_indices(Some(proj_with_row_base))
            self.config.file_schema.clone(),
        // Always include the row_base partition column (index = num_file_cols)
                let mut p = proj.clone();
            FileScanConfigBuilder::new(self.config.store_url.clone(), Arc::new(parquet_source))
use datafusion::common::stats::Precision;
        f.debug_struct("ShardTableProvider")
        builder = builder
pub use crate::api::ShardFileInfo;
    fn statistics(&self) -> Option<Statistics> {
 */
        };
    }
        filters: &[&Expr],
        let parquet_source = ParquetSource::new(table_schema);
        let proj_with_row_base = match projection {
        );
#[async_trait]
    pub files: Vec<ShardFileInfo>,
                if let Some(ref plan) = file_info.access_plan {
            .finish()
    fn table_type(&self) -> TableType {
/*
use datafusion_datasource::file_groups::FileGroup;
                p
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
            }
                });
                .with_file_groups(file_groups);
//! Shard-level TableProvider with `row_base` partition column for global row ID computation.
    pub file_schema: SchemaRef,
}
            .iter()
            "ShardTableProvider: files not ordered by row_base — ProjectRowIdOptimizer would compute wrong global IDs"
}
                if !p.contains(&row_base_idx) {
    }
            config,
use datafusion::physical_plan::ExecutionPlan;
        &self,
        projection: Option<&Vec<usize>>,
use datafusion_datasource::PartitionedFile;
    pub store_url: ObjectStoreUrl,
    pub fn new(config: ShardTableConfig) -> Self {
            }
        let partitioned_files: Vec<PartitionedFile> = self
    table_schema: SchemaRef,
    }
use datafusion::datasource::source::DataSourceExec;
        Ok(DataSourceExec::from_data_source(file_scan_config))
 *
            .map(|file_info| {
                let mut pf = PartitionedFile::from(file_info.object_meta.clone());
use datafusion::logical_expr::{Expr, TableProviderFilterPushDown};
                    ],
                        datafusion::common::ColumnStatistics::new_unknown();
use datafusion::common::{Result, ScalarValue, Statistics};
        let file_groups = vec![FileGroup::new(partitioned_files)];
                p.push(row_base_idx);
                pf
            Some(proj) => {
            })
    }
        &self,
impl TableProvider for ShardTableProvider {
            None => {
pub struct ShardTableProvider {
                let mut p: Vec<usize> = (0..num_file_cols).collect();
 * this file be licensed under the Apache-2.0 license or a
        _filters: &[Expr],
use datafusion::execution::object_store::ObjectStoreUrl;
 * The OpenSearch Contributors require contributions made to
    }
        Ok(vec![TableProviderFilterPushDown::Inexact; filters.len()])
                }
use async_trait::async_trait;
        // so ProjectRowIdOptimizer can compute __row_id__ + row_base.
                p
        let num_file_cols = self.config.file_schema.fields().len();
            .map_err(|e| datafusion::error::DataFusionError::Internal(format!("{}", e)))?;
        _state: &dyn Session,
        _limit: Option<usize>,
        self.table_schema.clone()
use datafusion::datasource::physical_plan::ParquetSource;
                        num_file_cols
            table_schema,
