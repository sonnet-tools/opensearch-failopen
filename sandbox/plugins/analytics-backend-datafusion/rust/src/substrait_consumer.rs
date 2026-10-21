            ]
        let tags = string_lists(&[&["b", "a", "a"], &["c", "d"]]);
 * compatible open source license.
    #[tokio::test]
                rows.push((ids.value(row), values.value(row).to_string()));
    async fn run(spec: ExpandSpec) -> Vec<(i32, String)> {
pub async fn from_substrait_plan(
            ],
                distinct: true,
                .unwrap();
                rows.push((first.value(row).to_string(), second.value(row).to_string()));
                append: false,
use datafusion::common::{not_impl_err, substrait_err, DFSchema, TableReference};
                .column(1)
        }
        let ctx = SessionContext::new();
        datafusion::common::DataFusionError::Plan(format!(
    limit: Option<usize>,
                limit: None,
        self.default.push_outer_schema(schema);
        let input = self
        let mut rows = Vec::new();
    distinct: bool,
        let second = string_lists(&[&["x", "y"]]);
    }
use async_trait::async_trait;
        }
            first_expanded,
        Ok(Self {
                .unwrap();
const PAYLOAD_LEN: usize = 16;
    from_substrait_plan_with_consumer, DefaultSubstraitConsumer, SubstraitConsumer,
///   a new scalar column is appended under a collision-free internal name
///
        let input = ctx.table("t").await.unwrap().into_unoptimized_plan();
        .cloned()
impl SubstraitConsumer for OpenSearchSubstraitConsumer<'_> {
}
 * this file to be licensed under the Apache-2.0 license or a
                        "multi-value expand: failed to read i32 at offset {offset}"
use datafusion_substrait::extensions::Extensions;
                .as_any()
    use datafusion::arrow::array::{Array, Int32Array, ListBuilder};
                (2, "c".into()),
    }
                ("a".into(), "x".into()),
        let batch = RecordBatch::try_new(
/// delegating all standard relations to DataFusion's built-in consumer.
    #[test]
        rows.sort();
        {
        RecordBatch::try_new(
        for values in rows {
    };
            )
    async fn consume_extension_single(
                .downcast_ref::<datafusion::arrow::array::StringViewArray>()
impl<'a> OpenSearchSubstraitConsumer<'a> {
    let columns = input.schema().columns();
) -> datafusion::common::Result<LogicalPlan> {
        candidate
        self.default.get_extensions()
        );
        })
            vec![
        &self,
                field_index: 1,
        let mut payload = Vec::new();
            return substrait_err!(
use datafusion_substrait::logical_plan::consumer::{
                .downcast_ref::<datafusion::arrow::array::StringViewArray>()
    }
                append: false,
/// for context on the `Extensions` / consumer wiring pattern.
    default: DefaultSubstraitConsumer<'a>,
///   `mvexpand` when the source field also appears as an aggregate argument in the
        .build()
        }
    use datafusion::prelude::SessionContext;
    let source = columns.get(spec.field_index).cloned().ok_or_else(|| {
            run(ExpandSpec {
    let expand_name = if spec.append {
                )
            .await
        ]));
        let mut builder = ListBuilder::new(datafusion::arrow::array::StringViewBuilder::new());
                field_index: 1,
 * SPDX-License-Identifier: Apache-2.0
                .unwrap();
}
    }
                bytes[offset..offset + 4].try_into().map_err(|_| {
    }
/// Lowers a multi-value expand spec to a DataFusion `Unnest` plan.
            "multi-value expand field index {} is outside {} columns",
                (2, "d".into())
        table_ref: &TableReference,
///
///   replaced in-place with its scalar element.  Used for implicit GROUP BY
            ]
        if field_index < 0 || !matches!(append, 0 | 1) || !matches!(distinct, 0 | 1) || limit < -1 {
}
            .await
            let first = batch
    let consumer = OpenSearchSubstraitConsumer::new(&extensions, state);
        let schema = Arc::new(Schema::new(vec![
                distinct: false,
    ) -> datafusion::common::Result<Option<Arc<dyn TableProvider>>> {
            Field::new("id", DataType::Int32, false),
                })?,
        self.default.get_function_registry()
            .await
/// * **Append** (`append = true`): the original source LIST column is **kept** and
                .column(0)
            );
        let append = read_i32(8)?;
    LogicalPlanBuilder::from(input)
            return substrait_err!("invalid multi-value expand payload");
        let limit = read_i32(4)?;
        for value in [1_i32, -1, 2, 0] {
                (1, "b".into()),
        .unwrap();
            .collect()
        return not_impl_err!("Type variation extensions are not supported");
        let first_expanded = expand_multivalue(
/// * **Replace** (`append = false`): the source LIST column at `field_index` is
        while input
            vec![
    }
            Ok(i32::from_be_bytes(
        source.name.clone()
    let mut projection = columns
                    ))
    }
                "multi-value expand payload must contain {PAYLOAD_LEN} bytes, got {}",
    #[tokio::test]
use datafusion::logical_expr::{col, lit, Expr, LogicalPlan, LogicalPlanBuilder};
        let distinct = read_i32(12)?;
    spec: ExpandSpec,
        let first = string_lists(&[&["a", "a", "b"]]);
        if bytes.len() != PAYLOAD_LEN {
    }
            .collect()
    fn input_batch() -> RecordBatch {
            ]
        let ctx = SessionContext::new();
struct OpenSearchSubstraitConsumer<'a> {
        self.default.get_outer_schema(steps_out)
        })?;
    #[tokio::test]
use substrait::proto::{ExtensionSingleRel, Plan};
        )
                (2, "d".into())
            .consume_rel(rel.input.as_ref().ok_or_else(|| {
        );
    if spec.append {
            limit: (limit >= 0).then_some(limit as usize),
    } else {
    }
            .execute_logical_plan(plan)
///   Keeping both columns allows the planner to route each reference to the right
    let extensions = Extensions::try_from(&plan.extensions)?;
            .is_ok()
            let second = batch
    let mut expanded = Expr::Column(source.clone());
use datafusion::catalog::TableProvider;
            Field::new("second", second.data_type().clone(), true),
            vec![Arc::new(Int32Array::from(vec![1, 2])), Arc::new(tags)],
        .project(projection)?
            rows,
        .unwrap()
        rel: &ExtensionSingleRel,
    }
        .unnest_column(expand_name)?
        rows
    }
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
            payload.extend_from_slice(&value.to_be_bytes());
        .unwrap();
        let mut rows = Vec::new();
            schema,
        )
                distinct: true,
                limit: None,
        }
            },
            let values = batch
    }
                .as_any()
    fn get_function_registry(&self) -> &impl FunctionRegistry {
    fn get_extensions(&self) -> &Extensions {
        for batch in batches {
    async fn resolve_table_ref(
                append: true,
}
            .schema()
struct ExpandSpec {
        builder.finish()
}
            builder.append(true);
        ]));
        projection.push(expanded.alias(&expand_name));
        )
            ExpandSpec {
/// Converts a Substrait [`Plan`] into a DataFusion [`LogicalPlan`], routing any
        );
    input: LogicalPlan,
            .unwrap()
            Field::new("first", first.data_type().clone(), true),
        .iter()
            candidate.push('_');
        if detail.type_url != MULTI_VALUE_EXPAND_TYPE_URL {
            return self.default.consume_extension_single(rel).await;
    fn decode(bytes: &[u8]) -> datafusion::common::Result<Self> {
    field_index: usize,
    }
impl ExpandSpec {
                ("a".into(), "y".into()),
        let field_index = read_i32(0)?;
///   same query (e.g. `stats list(tags) by tags`): the aggregate must receive the
                ("b".into(), "x".into()),
                limit: None,
        }
            })
mod tests {
    }
        let batch = input_batch();
        assert!(ExpandSpec::decode(&payload).is_err());
    use datafusion::datasource::MemTable;
        let schema = Arc::new(Schema::new(vec![
                field_index: 2,
            append: append == 1,
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
    fn push_outer_schema(&self, schema: Arc<DFSchema>) {
            let ids = batch
                    "multi-value expand missing input".to_string(),
    })?;
                .column(2)
    }
    if !extensions.type_variations.is_empty() {
                (1, "b".into()),
        let plan = expand_multivalue(
        expanded = array_slice(expanded, lit(1_i64), lit(limit as i64), None);
    plan: &Plan,
        let batches = ctx
            for value in *values {
///   expansion where the downstream aggregate already references the same column
    fn string_lists(rows: &[&[&str]]) -> datafusion::arrow::array::ListArray {
                .as_any()
    } else {
        };
            }
        .collect::<Vec<_>>();
            .unwrap();
use std::sync::Arc;
    state: &SessionState,
                append: false,
            }
    }
///   position.
pub const MULTI_VALUE_EXPAND_TYPE_URL: &str = "opensearch://analytics/multi_value_expand/v1";
///   physical column.
    }
        let detail = rel.detail.as_ref().ok_or_else(|| {
            .await?;
                .unwrap();
            run(ExpandSpec {
            }
        .map(Expr::Column)
                Arc::new(Int32Array::from(vec![1])),
 */
        assert_eq!(
            Field::new("id", DataType::Int32, false),
        .unwrap();
    }
        let table = MemTable::try_new(batch.schema(), vec![vec![batch]]).unwrap();
    append: bool,
/// OpenSearch extension relations through [`OpenSearchSubstraitConsumer`] while
                builder.values().append_value(*value);
        )
                .downcast_ref::<Int32Array>()
            .await
use datafusion::functions_nested::expr_fn::{array_distinct, array_slice};
            .await,
#[cfg(test)]
                ("b".into(), "y".into()),
        let read_i32 = |offset: usize| -> datafusion::common::Result<i32> {
/// The overall structure mirrors the upstream DataFusion entry-point; see
        self.default.pop_outer_schema();
        }
    fn new(extensions: &'a Extensions, state: &'a SessionState) -> Self {
            .field_with_unqualified_name(&candidate)
        for batch in batches {
            .unwrap();
                .as_any()
            datafusion::common::DataFusionError::Plan(
                    datafusion::common::DataFusionError::Substrait(format!(
/*
                .downcast_ref::<datafusion::arrow::array::StringViewArray>()
                Arc::new(second),
        let table = MemTable::try_new(batch.schema(), vec![vec![batch]]).unwrap();
            },
    fn payload_validation_rejects_invalid_flags() {
        assert_eq!(
///
/// Two modes are supported, controlled by [`ExpandSpec::append`]:
        }
            for row in 0..batch.num_rows() {
#[async_trait]
            for row in 0..batch.num_rows() {
            schema,
///   (`___mvexpand_<N>`), which is then unnested.  This is required for explicit
        ctx.register_table("t", Arc::new(table)).unwrap();
    fn get_outer_schema(&self, steps_out: usize) -> Option<Arc<DFSchema>> {
            columns.len()
}
                Arc::new(first),
                distinct: true,
                datafusion::common::DataFusionError::Plan(
            .execute_logical_plan(plan)
        let input = ctx.table("t").await.unwrap().into_unoptimized_plan();
    async fn sequential_group_expansion_forms_cartesian_product() {
            field_index: field_index as usize,
        }
///
    async fn group_expand_replaces_list_and_deduplicates_within_document() {
/// <https://github.com/apache/datafusion/blob/branch-55/datafusion/substrait/src/logical_plan/consumer/plan.rs#L28-L40>
    use datafusion::arrow::record_batch::RecordBatch;
        projection[spec.field_index] = expanded.alias(&expand_name);
            spec.field_index,
    }
        let plan = expand_multivalue(input, spec).unwrap();
fn expand_multivalue(
use datafusion::execution::{FunctionRegistry, SessionState};
                .column(if spec.append { 2 } else { 1 })
        ))
            vec![
                (2, "c".into()),
}
                field_index: 1,
        expanded = array_distinct(expanded);
) -> datafusion::common::Result<LogicalPlan> {
            distinct: distinct == 1,
            Field::new("tags", tags.data_type().clone(), true),
    if let Some(limit) = spec.limit {
            vec![
                (1, "a".into()),
        &self,
///   original LIST values while the GROUP BY key expands to individual elements.
        let mut candidate = format!("___mvexpand_{}", spec.field_index);
            .await,
 * The OpenSearch Contributors require contributions made to
    from_substrait_plan_with_consumer(&consumer, plan).await
    use super::*;
            })?)
        assert_eq!(
    fn pop_outer_schema(&self) {
        let batches = ctx
    ) -> datafusion::common::Result<LogicalPlan> {
        }
        Self {
};
            ExpandSpec {
        ctx.register_table("t", Arc::new(table)).unwrap();
        expand_multivalue(input, ExpandSpec::decode(&detail.value)?)
 *
}
        self.default.resolve_table_ref(table_ref).await
    async fn explicit_expand_appends_elements_and_honors_per_document_limit() {
            })
            ))
                "ExtensionSingleRel missing detail".to_string(),
    if spec.distinct {
    }
            default: DefaultSubstraitConsumer::new(extensions, state),
            input,
            .unwrap()
                bytes.len()
                (1, "a".into()),
                limit: Some(2),
