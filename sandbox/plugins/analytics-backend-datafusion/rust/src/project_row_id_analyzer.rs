                        let qualifier = scan.projected_schema.qualified_field(0).0.cloned();
impl AnalyzerRule for ProjectRowIdAnalyzer {
                                    datafusion::error::DataFusionError::Internal(format!(
                        proj.push(row_id_idx);
//!
                                    false,
                                false,
                    );
        })?;
 * this file be licensed under the Apache-2.0 license or a
pub use crate::ROW_ID_COLUMN_NAME as ROW_ID_FIELD_NAME;
                    let mut new_exprs = p.expr.to_vec();
#[derive(Debug)]
                                    ))
            _ => Ok(Transformed::no(node)),
}
use datafusion::error::Result;
use datafusion::logical_expr::{col, Expr, LogicalPlan};
                                },
                    .input
//!
    pub fn new() -> Self {
//! the query plan when available in the source schema. Runs BEFORE physical optimization,
                                    e
            LogicalPlan::Projection(p) => {
                            Some(q) => DFSchema::try_from_qualified_schema(
                    return Ok(Transformed::yes(new_proj));
//! Project Row ID Analyzer
use datafusion::arrow::datatypes::{DataType, Field, Schema};
                    table_name: scan.table_name.clone(),
                        } else {
                            p.schema.clone()
                    let new_proj = LogicalPlan::Projection(
                        if p.schema
 */
                    let merged_schema =
                    .expr
                    projected_schema: Arc::new(new_projected_schema),
                            let row_id_schema = DFSchema::try_from_qualified_schema(
                                )]),
                                    "ProjectRowIdAnalyzer: create projection: {}",
                                })?;
                                    false,
    }
                let mut new_projected_schema = (*scan.projected_schema).clone();
/*
                                        e
                                datafusion::error::DataFusionError::Internal(format!(
//! column. This analyzer ensures `__row_id__` (and implicitly `row_base`) survive into
    fn name(&self) -> &str {
                        {
                    .iter()
                            })?,
                    let row_id_idx = scan.source.schema().index_of(ROW_ID_FIELD_NAME).unwrap();
                                DataType::Int64,
                                )]),
                            None => DFSchema::try_from(Schema::new(vec![Field::new(
    fn analyze(&self, plan: LogicalPlan, _config: &ConfigOptions) -> Result<LogicalPlan> {
//! the physical plan where `ProjectRowIdOptimizer` computes `__row_id__ + row_base`.
            }
                    let row_id_schema = {
use datafusion::config::ConfigOptions;
        let rewritten = plan.transform_up(|node| match &node {
                    .projection
                Ok(Transformed::no(node))
impl ProjectRowIdAnalyzer {
                            .index_of_column(&Column::from_name(ROW_ID_FIELD_NAME))
                    .unwrap_or_else(|| (0..scan.projected_schema.fields().len()).collect());
                            )]))?,
                            )?;
                                        e
 * The OpenSearch Contributors require contributions made to
    }
//! For the ListingTable QTF path: `ShardTableProvider` exposes `row_base` as a partition
            }
        "project_row_id_analyzer"
                            .is_ok()
                if !already_has_row_id && input_has_row_id {
                    .schema()
                                    datafusion::error::DataFusionError::Internal(format!(
                                    ))
                            )?)
                    new_exprs.push(col(ROW_ID_FIELD_NAME));
                    fetch: scan.fetch,
                                &Schema::new(vec![Field::new(
pub struct ProjectRowIdAnalyzer;
                                        "ProjectRowIdAnalyzer: join schema: {}",
        Ok(rewritten.data)
                                new_projected_schema.join(&row_id_schema).map_err(|e| {
                    .clone()
use datafusion_expr::Projection;
    }
                let input_has_row_id = p
                        }
                    .any(|e| matches!(e, Expr::Column(c) if c.name == ROW_ID_FIELD_NAME));
                });
                    .index_of_column(&Column::from_name(ROW_ID_FIELD_NAME))
        Self {}
                    source: scan.source.clone(),
                        }
                    };
                    .is_ok();
                                ROW_ID_FIELD_NAME,
                                        "ProjectRowIdAnalyzer: join projection schema: {}",
                        };
                    }
                                    ROW_ID_FIELD_NAME,
                                &Schema::new(vec![Field::new(
                    if !proj.contains(&row_id_idx) {
                                ))
                            .map_err(|e| {
                                    DataType::Int64,
                let mut proj = scan
use datafusion::common::tree_node::{Transformed, TreeNode};
 *
                        match qualifier {
            LogicalPlan::TableScan(scan) => {
                let already_has_row_id = p
                        if let Some(q) = qualifier {
use std::sync::Arc;
                        Projection::try_new_with_schema(new_exprs, p.input.clone(), merged_schema)
                                q,
 * compatible open source license.
}
                                    ROW_ID_FIELD_NAME,
                }
use datafusion::common::{Column, DFSchema};
                                    DataType::Int64,
                            Arc::new(p.schema.as_ref().clone().join(&row_id_schema).map_err(
                let new_scan = LogicalPlan::TableScan(datafusion_expr::TableScan {
                        let qualifier = p.schema.qualified_field(0).0.cloned();
                }
                                q,
 * SPDX-License-Identifier: Apache-2.0
                                |e| {
//! so the column survives all pruning passes.
                Ok(Transformed::yes(new_scan))
                    projection: Some(proj),
use datafusion::optimizer::AnalyzerRule;
                            )?,
                if scan.source.schema().index_of(ROW_ID_FIELD_NAME).is_ok() {
//! Logical-level analyzer rule that ensures `__row_id__` is always projected through
                            new_projected_schema =
                    filters: scan.filters.clone(),
