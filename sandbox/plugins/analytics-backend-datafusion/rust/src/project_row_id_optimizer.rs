        false
                }
//! This approach is resilient to DataFusion's built-in optimizers pruning `row_base`
            let row_id_idx = new_schema.index_of(ROW_ID_FIELD_NAME).unwrap();
            // Rebuild the DataSourceExec to ensure both __row_id__ and row_base are in the output.
    fn name(&self) -> &str {
            let row_base_partition_idx = file_schema.fields().len();
            }
                Operator::Plus,
            for (i, field) in new_schema.fields().iter().enumerate() {
                    if !new_proj_indices.contains(&idx) {
use datafusion::physical_expr::PhysicalExpr;
    }
            // Add partition column index (row_base is at file_schema.fields().len())
//! from the scan output — we rebuild the DataSourceExec from the underlying config.
//! column), then wraps with `ProjectionExec` computing `__row_id__ + row_base`.
        &self,
            // Rebuild the DataSourceExec with new projections
//!
                DataSourceExec::from_data_source(new_config);
//! file schema, rebuilds the scan to include both `__row_id__` and `row_base` (partition
                return Ok(Transformed::no(node));
    fn optimize(
            let new_schema = new_datasource.schema();
        Ok(rewritten.data)
use datafusion::datasource::physical_plan::ParquetSource;
                Arc::new(projection) as Arc<dyn ExecutionPlan>,
            let Some(file_scan_config) = datasource_exec
                return Ok(Transformed::no(node));
 * compatible open source license.
                .downcast_ref::<FileScanConfig>()
use datafusion::logical_expr::Operator;
    fn optimizer_name() {
                    ))
        _config: &ConfigOptions,
            if partition_cols.is_empty() {
            let row_base_idx = new_schema.index_of(ROW_BASE_FIELD_NAME).unwrap();
use datafusion::physical_plan::ExecutionPlan;
    }
        let opt = ProjectRowIdOptimizer;
    fn schema_check(&self) -> bool {
            let projection = ProjectionExec::try_new(projection_exprs, new_datasource)?;
                return Ok(Transformed::no(node));
            // Check if __row_id__ exists in the file schema
    fn optimizer_schema_check_disabled() {
                TreeNodeRecursion::Continue,
                        .push((Arc::new(Column::new(field.name(), i)), field.name().clone()));
            let file_schema = file_scan_config.file_schema();
use datafusion_datasource::TableSchema;
                true,
pub struct ProjectRowIdOptimizer;
                }
//! Downcasts to `DataSourceExec` → `FileScanConfig`, checks if `__row_id__` is in the
            let mut projection_exprs: Vec<(Arc<dyn PhysicalExpr>, String)> = Vec::new();
            // Only handle DataSourceExec nodes backed by FileScanConfig
                .data_source()
 * this file be licensed under the Apache-2.0 license or a
                    projection_exprs.push((sum_expr.clone(), ROW_ID_FIELD_NAME.to_string()));
                } else if field.name() == ROW_BASE_FIELD_NAME {
        let opt = ProjectRowIdOptimizer;
            }
            let mut new_proj_indices: Vec<usize> = Vec::new();
                .with_source(new_source)
            let new_config = FileScanConfigBuilder::from(file_scan_config.clone())
        "ProjectRowIdOptimizer"
            let new_datasource: Arc<dyn ExecutionPlan> =
            let new_source = Arc::new(ParquetSource::new(new_table_schema));
            };
                    continue; // drop from output
            }
use datafusion::physical_optimizer::PhysicalOptimizerRule;
 * SPDX-License-Identifier: Apache-2.0
/*
                if field.name() == ROW_ID_FIELD_NAME {
use datafusion::physical_expr::expressions::{BinaryExpr, Column};
    #[test]
impl PhysicalOptimizerRule for ProjectRowIdOptimizer {
                if let Ok(idx) = file_schema.index_of(field.name()) {
                    continue;
            let sum_expr: Arc<dyn PhysicalExpr> = Arc::new(BinaryExpr::new(
            ))
                        "ProjectRowIdOptimizer: set projection: {}",
            let row_id_file_idx = file_schema.index_of(ROW_ID_FIELD_NAME).unwrap();
//! Physical optimizer rule for the ListingTable QTF path.
mod tests {
use datafusion_datasource::file_scan_config::{FileScanConfig, FileScanConfigBuilder};
    }
        let rewritten = plan.transform_up(|node| {
            if !new_proj_indices.contains(&row_id_file_idx) {
}
            }
 * The OpenSearch Contributors require contributions made to
            };
                .map_err(|e| {
                .as_ref()
//!
#[cfg(test)]
    #[test]
        assert_eq!(opt.name(), "ProjectRowIdOptimizer");
                })?
#[derive(Debug)]
        assert!(!opt.schema_check());
                new_proj_indices.push(row_id_file_idx);
                Arc::new(Column::new(ROW_BASE_FIELD_NAME, row_base_idx)),
                }
use datafusion::physical_plan::projection::ProjectionExec;
pub const ROW_BASE_FIELD_NAME: &str = "row_base";
                    projection_exprs
            if file_schema.index_of(ROW_ID_FIELD_NAME).is_err() {
                .with_projection_indices(Some(new_proj_indices))
            // Get the current output schema fields to determine what's projected.
            for field in current_schema.fields() {
            // Check if this DataSourceExec has partition columns (ShardTableProvider sets row_base)
                        new_proj_indices.push(idx);
            let partition_cols = file_scan_config.table_partition_cols();
                .build();
}
        plan: Arc<dyn ExecutionPlan>,
            // Build new projection indices: current projected file columns + __row_id__ + row_base
use datafusion::common::config::ConfigOptions;
                    // row_base is partition col, it'll be added below
                if field.name() == ROW_BASE_FIELD_NAME {
                Arc::new(Column::new(ROW_ID_FIELD_NAME, row_id_idx)),
            else {
            }
            ));
    ) -> Result<Arc<dyn ExecutionPlan>> {
                        e
 *
    }
use datafusion::common::Result;
        })?;
                    }
                    datafusion::error::DataFusionError::Internal(format!(
use datafusion::datasource::source::DataSourceExec;
pub use crate::ROW_ID_COLUMN_NAME as ROW_ID_FIELD_NAME;
            // Build projection: __row_id__ + row_base, drop row_base from output
                } else {
            new_proj_indices.push(row_base_partition_idx);
use datafusion::common::tree_node::{Transformed, TreeNode, TreeNodeRecursion};
            let Some(datasource_exec) = node.downcast_ref::<DataSourceExec>() else {
use std::sync::Arc;
                return Ok(Transformed::no(node));
            let new_table_schema = TableSchema::new(file_schema.clone(), partition_cols.clone());
    }
    use super::*;
            let current_schema = datasource_exec.schema();
 */
            // Ensure __row_id__ is in the projection
            Ok(Transformed::new(
