        let mut rows = Vec::new();
        )
#[async_trait]
 * this file to be licensed under the Apache-2.0 license or a
                    datafusion::common::DataFusionError::Substrait(format!(
                        "multi-value expand: failed to read i32 at offset {offset}"
            ]
    use datafusion::datasource::MemTable;
        Ok(Self {
) -> datafusion::common::Result<LogicalPlan> {
) -> datafusion::common::Result<LogicalPlan> {
        .unwrap();
    state: &SessionState,
            }
    plan: &Plan,
        rows
        for batch in batches {
}
        let batch = input_batch();
///   Keeping both columns allows the planner to route each reference to the right
            .collect()
                field_index: 2,
            ))
        ))
        assert_eq!(
            ]
            .await
    ) -> datafusion::common::Result<Option<Arc<dyn TableProvider>>> {
        .build()
use datafusion::functions_nested::expr_fn::{array_distinct, array_slice};
            default: DefaultSubstraitConsumer::new(extensions, state),
                ("a".into(), "y".into()),
        .unwrap()
        }
        let batches = ctx
                .unwrap();
            .await
        let input = self
    }
        expanded = array_slice(expanded, lit(1_i64), lit(limit as i64), None);
            Ok(i32::from_be_bytes(
fn expand_multivalue(
                .column(2)
    }
                limit: None,
#[cfg(test)]
            spec.field_index,
        let batch = RecordBatch::try_new(
        let tags = string_lists(&[&["b", "a", "a"], &["c", "d"]]);
    if !extensions.type_variations.is_empty() {
///   same query (e.g. `stats list(tags) by tags`): the aggregate must receive the
    fn payload_validation_rejects_invalid_flags() {
                Arc::new(second),
impl<'a> OpenSearchSubstraitConsumer<'a> {
                distinct: true,
                })?,
        })?;
///   a new scalar column is appended under a collision-free internal name
                (2, "c".into()),
    #[test]
    input: LogicalPlan,
        for values in rows {
            Field::new("tags", tags.data_type().clone(), true),
                append: false,
    let columns = input.schema().columns();
    fn pop_outer_schema(&self) {
/// The overall structure mirrors the upstream DataFusion entry-point; see
                .unwrap();
            columns.len()
            Field::new("id", DataType::Int32, false),
mod tests {
            let values = batch
                .as_any()
            run(ExpandSpec {
        let mut rows = Vec::new();
        projection[spec.field_index] = expanded.alias(&expand_name);
    async fn consume_extension_single(
///   replaced in-place with its scalar element.  Used for implicit GROUP BY
        builder.finish()
        datafusion::common::DataFusionError::Plan(format!(
const PAYLOAD_LEN: usize = 16;
        }
use async_trait::async_trait;
                distinct: true,
        let input = ctx.table("t").await.unwrap().into_unoptimized_plan();
        }
        &self,
        self.default.get_function_registry()
        let table = MemTable::try_new(batch.schema(), vec![vec![batch]]).unwrap();
            .field_with_unqualified_name(&candidate)
            input,
            }
                limit: None,
    }
        candidate
        }
            .unwrap();
            .await?;
            .schema()
        ctx.register_table("t", Arc::new(table)).unwrap();
        let mut payload = Vec::new();
    use datafusion::arrow::array::{Array, Int32Array, ListBuilder};
        }
        expanded = array_distinct(expanded);
        assert_eq!(
        let second = string_lists(&[&["x", "y"]]);
        .iter()
        )
    let extensions = Extensions::try_from(&plan.extensions)?;
        let append = read_i32(8)?;
///
        let limit = read_i32(4)?;
///
            let ids = batch
    fn string_lists(rows: &[&[&str]]) -> datafusion::arrow::array::ListArray {
            first_expanded,
    #[tokio::test]
        table_ref: &TableReference,
    let consumer = OpenSearchSubstraitConsumer::new(&extensions, state);
            ExpandSpec {
                Arc::new(Int32Array::from(vec![1])),
            schema,
    }
                limit: Some(2),
    spec: ExpandSpec,
            }
 */
            datafusion::common::DataFusionError::Plan(
                .column(1)
        expand_multivalue(input, ExpandSpec::decode(&detail.value)?)
    async fn sequential_group_expansion_forms_cartesian_product() {
        {
    }
            vec![Arc::new(Int32Array::from(vec![1, 2])), Arc::new(tags)],
                (1, "b".into()),
}
                .column(0)
    async fn group_expand_replaces_list_and_deduplicates_within_document() {
    fn get_outer_schema(&self, steps_out: usize) -> Option<Arc<DFSchema>> {
/// Lowers a multi-value expand spec to a DataFusion `Unnest` plan.
            )
/// * **Append** (`append = true`): the original source LIST column is **kept** and
            .await
            ExpandSpec {
            })
            return substrait_err!(
}
    }
            })?)
                "ExtensionSingleRel missing detail".to_string(),
        if detail.type_url != MULTI_VALUE_EXPAND_TYPE_URL {
        let mut candidate = format!("___mvexpand_{}", spec.field_index);
            vec![
    }
pub const MULTI_VALUE_EXPAND_TYPE_URL: &str = "opensearch://analytics/multi_value_expand/v1";
    }
        }
        for value in [1_i32, -1, 2, 0] {
    from_substrait_plan_with_consumer(&consumer, plan).await
    let mut expanded = Expr::Column(source.clone());
use substrait::proto::{ExtensionSingleRel, Plan};
            vec![
/// * **Replace** (`append = false`): the source LIST column at `field_index` is
            ],
            schema,
        let first = string_lists(&[&["a", "a", "b"]]);
                (2, "d".into())
    }
    async fn run(spec: ExpandSpec) -> Vec<(i32, String)> {
            let first = batch
    from_substrait_plan_with_consumer, DefaultSubstraitConsumer, SubstraitConsumer,
                .downcast_ref::<Int32Array>()
            limit: (limit >= 0).then_some(limit as usize),
 * compatible open source license.
        let batches = ctx
    }
                rows.push((ids.value(row), values.value(row).to_string()));
    }
    }
                datafusion::common::DataFusionError::Plan(
            Field::new("second", second.data_type().clone(), true),
/*
                (1, "a".into()),
        let mut builder = ListBuilder::new(datafusion::arrow::array::StringViewBuilder::new());
        let first_expanded = expand_multivalue(
struct OpenSearchSubstraitConsumer<'a> {
    } else {
            Field::new("first", first.data_type().clone(), true),
        let plan = expand_multivalue(input, spec).unwrap();
    if spec.distinct {
pub async fn from_substrait_plan(
        self.default.get_outer_schema(steps_out)
///   expansion where the downstream aggregate already references the same column
        );
        .unwrap();
                .as_any()
            .is_ok()
        );
        )
    distinct: bool,
    fn new(extensions: &'a Extensions, state: &'a SessionState) -> Self {
}
            .unwrap()
        &self,
        let schema = Arc::new(Schema::new(vec![
                field_index: 1,
///
    #[tokio::test]
        self.default.pop_outer_schema();
        let read_i32 = |offset: usize| -> datafusion::common::Result<i32> {
        Self {
                append: false,
    } else {
                builder.values().append_value(*value);
        let ctx = SessionContext::new();
                distinct: true,
                field_index: 1,
use datafusion::logical_expr::{col, lit, Expr, LogicalPlan, LogicalPlanBuilder};
/// OpenSearch extension relations through [`OpenSearchSubstraitConsumer`] while
                .downcast_ref::<datafusion::arrow::array::StringViewArray>()
                bytes.len()
    let expand_name = if spec.append {
                .as_any()
            "multi-value expand field index {} is outside {} columns",
///   (`___mvexpand_<N>`), which is then unnested.  This is required for explicit
        )
            .execute_logical_plan(plan)
        .collect::<Vec<_>>();
            })
                ("b".into(), "y".into()),
    append: bool,
            vec![
///   position.
        if field_index < 0 || !matches!(append, 0 | 1) || !matches!(distinct, 0 | 1) || limit < -1 {
    fn get_extensions(&self) -> &Extensions {
            .consume_rel(rel.input.as_ref().ok_or_else(|| {
        let schema = Arc::new(Schema::new(vec![
    fn push_outer_schema(&self, schema: Arc<DFSchema>) {
            distinct: distinct == 1,
        assert_eq!(
        assert!(ExpandSpec::decode(&payload).is_err());
            let second = batch
impl SubstraitConsumer for OpenSearchSubstraitConsumer<'_> {
}
            return substrait_err!("invalid multi-value expand payload");
    if let Some(limit) = spec.limit {
    }
        }
                ("a".into(), "x".into()),
                ("b".into(), "x".into()),
            append: append == 1,
            builder.append(true);
        self.default.push_outer_schema(schema);
}
            for row in 0..batch.num_rows() {
    })?;
        .map(Expr::Column)
            return self.default.consume_extension_single(rel).await;
            .await,
 * The OpenSearch Contributors require contributions made to
            },
        self.default.get_extensions()
                field_index: 1,
                append: false,
        .project(projection)?
            for row in 0..batch.num_rows() {
            },
/// delegating all standard relations to DataFusion's built-in consumer.
            Field::new("id", DataType::Int32, false),
            .await
use datafusion::catalog::TableProvider;
                "multi-value expand payload must contain {PAYLOAD_LEN} bytes, got {}",
    async fn explicit_expand_appends_elements_and_honors_per_document_limit() {
        rel: &ExtensionSingleRel,
    }
    }
                Arc::new(first),
                    ))
        let table = MemTable::try_new(batch.schema(), vec![vec![batch]]).unwrap();
                append: true,
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
                .downcast_ref::<datafusion::arrow::array::StringViewArray>()
            .collect()
        let distinct = read_i32(12)?;
///
            .execute_logical_plan(plan)
            .unwrap();
    limit: Option<usize>,
            );
            ]
    #[tokio::test]
    use datafusion::arrow::record_batch::RecordBatch;
    LogicalPlanBuilder::from(input)
        projection.push(expanded.alias(&expand_name));
use std::sync::Arc;
    ) -> datafusion::common::Result<LogicalPlan> {
/// <https://github.com/apache/datafusion/blob/branch-55/datafusion/substrait/src/logical_plan/consumer/plan.rs#L28-L40>
            vec![
                (2, "d".into())
        ]));
        );
    let source = columns.get(spec.field_index).cloned().ok_or_else(|| {
                distinct: false,
        .cloned()
        while input
};
                (1, "a".into()),
    field_index: usize,
        }
    fn input_batch() -> RecordBatch {
        ]));
                .downcast_ref::<datafusion::arrow::array::StringViewArray>()
            .await,
                )
///   `mvexpand` when the source field also appears as an aggregate argument in the
            payload.extend_from_slice(&value.to_be_bytes());
        rows.sort();
use datafusion::common::{not_impl_err, substrait_err, DFSchema, TableReference};
    let mut projection = columns
        }
}
    fn decode(bytes: &[u8]) -> datafusion::common::Result<Self> {
/// Converts a Substrait [`Plan`] into a DataFusion [`LogicalPlan`], routing any
                bytes[offset..offset + 4].try_into().map_err(|_| {
    async fn resolve_table_ref(
        .unwrap();
                (1, "b".into()),
        return not_impl_err!("Type variation extensions are not supported");
    use datafusion::prelude::SessionContext;
            .unwrap()
                .column(if spec.append { 2 } else { 1 })
 * SPDX-License-Identifier: Apache-2.0
    };
use datafusion_substrait::extensions::Extensions;
        RecordBatch::try_new(
impl ExpandSpec {
struct ExpandSpec {
    }
            rows,
        .unnest_column(expand_name)?
    }
                (2, "c".into()),
    }
        let input = ctx.table("t").await.unwrap().into_unoptimized_plan();
    }
    fn get_function_registry(&self) -> &impl FunctionRegistry {
        if bytes.len() != PAYLOAD_LEN {
    }
use datafusion::execution::{FunctionRegistry, SessionState};
///   original LIST values while the GROUP BY key expands to individual elements.
}
/// Two modes are supported, controlled by [`ExpandSpec::append`]:
use datafusion_substrait::logical_plan::consumer::{
            run(ExpandSpec {
                rows.push((first.value(row).to_string(), second.value(row).to_string()));
        let plan = expand_multivalue(
        let ctx = SessionContext::new();
                .as_any()
        };
        })
        source.name.clone()
            for value in *values {
                .unwrap();
    use super::*;
    if spec.append {
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
 *
        self.default.resolve_table_ref(table_ref).await
            field_index: field_index as usize,
    default: DefaultSubstraitConsumer<'a>,
        for batch in batches {
            candidate.push('_');
        let detail = rel.detail.as_ref().ok_or_else(|| {
        ctx.register_table("t", Arc::new(table)).unwrap();
                .unwrap();
/// for context on the `Extensions` / consumer wiring pattern.
                    "multi-value expand missing input".to_string(),
                limit: None,
        let field_index = read_i32(0)?;
///   physical column.
