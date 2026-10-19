        acc.merge_batch(&[state_array])?;
            ignore_nulls: false,
        match agg_name.as_str() {
        let mut acc = approx_distinct_udaf()
        let agg_name = match &args.args[0] {
    fn test_reduce_eval_approx_distinct() {
    }
        // Extract the Binary state
        };
    }
#[derive(Debug, PartialEq, Eq, Hash)]
        let state_array = state[0].to_array_of_size(1).unwrap();
        let state_array: ArrayRef = Arc::new(BinaryArray::from(vec![binary.value(i)]));
    fn signature(&self) -> &Signature {
        };
            "approx_distinct" => eval_approx_distinct(&state_col),
                ))
#[cfg(test)]
        let mut acc = approx_distinct_udaf().accumulator(AccumulatorArgs {
            .unwrap();
    use datafusion::functions_aggregate::approx_distinct::approx_distinct_udaf;
            .clone()]));
        // Feed some values
impl ScalarUDFImpl for ReduceEvalUdf {
            DataFusionError::Execution("reduce_eval(approx_distinct): expected Binary state".into())
                expr_fields: &[field.clone()],
fn eval_approx_distinct(state_col: &ArrayRef) -> Result<ColumnarValue> {
    ctx.register_udf(ScalarUDF::new_from_impl(ReduceEvalUdf));
use datafusion::arrow::array::{Array, ArrayRef, BinaryArray, UInt64Array};
        .ok_or_else(|| {
        .as_ref()
    }
            .accumulator(AccumulatorArgs {
            })
        }
use std::sync::Arc;
use datafusion::common::{DataFusionError, Result, ScalarValue};
                return Err(DataFusionError::Execution(
pub fn register_all(ctx: &SessionContext) {
            ColumnarValue::Array(a) => a.clone(),
                is_reversed: false,
}
        static SIG: std::sync::LazyLock<Signature> =
 * The OpenSearch Contributors require contributions made to
                schema: &schema,
        let expr: Arc<dyn datafusion::physical_plan::PhysicalExpr> = Arc::new(Column::new("x", 0));
                name: "x",
        Ok(DataType::UInt64)
 */
            other => Err(DataFusionError::Execution(format!(
/*
    Ok(ColumnarValue::Array(Arc::new(UInt64Array::from(results))))
            _ => {
    use super::*;
            expr_fields: &[field.clone()],
            _ => results.push(0),
use datafusion::execution::context::SessionContext;
    let field: Arc<Field> = Arc::new(Field::new("x", DataType::Int64, true));
        })?;
 *
        })?;
        let schema = Arc::new(datafusion::arrow::datatypes::Schema::new(vec![field
    fn name(&self) -> &str {
                order_bys: &[],
mod tests {
                    "reduce_eval: first arg must be literal agg name".into(),
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
struct ReduceEvalUdf;
            order_bys: &[],
        }
            }
}
            continue;
                let uint_arr = arr.as_any().downcast_ref::<UInt64Array>().unwrap();
        let values: ArrayRef = Arc::new(datafusion::arrow::array::Int64Array::from(vec![
    }
        // Run reduce_eval
 * compatible open source license.
    let schema = Arc::new(datafusion::arrow::datatypes::Schema::new(vec![field
}
            std::sync::LazyLock::new(|| Signature::any(2, Volatility::Immutable));
            is_reversed: false,
        .downcast_ref::<BinaryArray>()
        let field: Arc<Field> = Arc::new(Field::new("x", DataType::Int64, true));
            is_distinct: false,
    }
        // Build an HLL state by updating an accumulator
//! `reduce_eval(agg_name, state)` — evaluates an opaque aggregate's partial state
            .as_ref()
                assert_eq!(uint_arr.value(0), 5); // 5 distinct values
use datafusion::functions_aggregate::approx_distinct::approx_distinct_udaf;
}
    let mut results = Vec::with_capacity(binary.len());
        let result = eval_approx_distinct(&(Arc::new(binary.clone()) as ArrayRef)).unwrap();
                "reduce_eval: unsupported aggregate '{other}'"
        "reduce_eval"
            ))),
            return_field: ret_field.clone(),
 * SPDX-License-Identifier: Apache-2.0
                exprs: &[expr.clone()],
            }
use datafusion::logical_expr::function::AccumulatorArgs;
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        }
        match acc.evaluate()? {
            name: "x",
        if binary.is_null(i) {
            1, 2, 3, 4, 5,
            ColumnarValue::Array(arr) => {
    use datafusion::logical_expr::Accumulator;
        let ret_field: Arc<Field> = Arc::new(Field::new("r", DataType::UInt64, true));
use datafusion::physical_expr::expressions::Column;
    fn return_type(&self, _args: &[DataType]) -> Result<DataType> {
        let binary = state_array.as_any().downcast_ref::<BinaryArray>().unwrap();
            exprs: &[expr.clone()],
        .as_any()
    let ret_field: Arc<Field> = Arc::new(Field::new("r", DataType::UInt64, true));
        match result {
        let state = acc.state().unwrap();
            ColumnarValue::Scalar(ScalarValue::Utf8(Some(s))) => s.clone(),
    }
    for i in 0..binary.len() {
            schema: &schema,
        acc.update_batch(&[values]).unwrap();
        let state_col = match &args.args[1] {
    use datafusion::arrow::array::BinaryArray;
            ColumnarValue::Scalar(s) => s.to_array_of_size(args.number_rows)?,
                ignore_nulls: false,
    let expr: Arc<dyn datafusion::physical_plan::PhysicalExpr> = Arc::new(Column::new("x", 0));
                return_field: ret_field.clone(),
use datafusion::logical_expr::{
};
                is_distinct: false,
    let binary = state_col
    #[test]
//! to produce a sortable scalar. Used by the TopK rewriter's reduce Project.
        &SIG
            results.push(0u64);
            ScalarValue::UInt64(Some(v)) => results.push(v),
        ]));
        .clone()]));
        }
use datafusion::arrow::datatypes::{DataType, Field};
            _ => panic!("expected Array"),
 * this file be licensed under the Apache-2.0 license or a
