    }
    inner: Box<dyn Accumulator>,
        // Materialize as StringArray — consistent hashing via StringHLLAccumulator
    fn size(&self) -> usize {
            let inner = approx_distinct_udaf().inner().accumulator(utf8_args)?;
use datafusion::arrow::array::{Array, ArrayRef, StringArray, StringViewArray};
}
//! TODO: Evaluate if DF's UDAF extension points (e.g. AccumulatorArgs overrides or
pub fn register_all(ctx: &SessionContext) {
use datafusion::logical_expr::function::{AccumulatorArgs, StateFieldsArgs};
    fn update_batch(&mut self, values: &[ArrayRef]) -> Result<()> {
use datafusion::functions_aggregate::approx_distinct::approx_distinct_udaf;
//!       custom PhysicalOptimizerRule to inject CastExec) can avoid same-name overrides.
/*
                schema: acc_args.schema,
            signature: Signature::any(1, Volatility::Immutable),
                return_field: acc_args.return_field,
                ignore_nulls: acc_args.ignore_nulls,
    fn evaluate(&mut self) -> Result<ScalarValue> {
        if matches!(data_type, DataType::Utf8View) {
    }
        let data_type = acc_args.expr_fields[0].data_type();
        self.inner.size()
    }
#[derive(Debug)]
use datafusion::logical_expr::{Accumulator, AggregateUDFImpl, Signature, Volatility};
        None
use datafusion::scalar::ScalarValue;
    ctx.register_udaf(datafusion::logical_expr::AggregateUDF::from(
                name: acc_args.name,
                is_distinct: acc_args.is_distinct,
 * this file be licensed under the Apache-2.0 license or a
    fn signature(&self) -> &Signature {
impl AggregateUDFImpl for SafeApproxDistinct {
impl Accumulator for Utf8ViewToUtf8Accumulator {
struct SafeApproxDistinct {
    fn merge_batch(&mut self, states: &[ArrayRef]) -> Result<()> {
use datafusion::execution::context::SessionContext;
        "approx_distinct"
 *
    fn state(&mut self) -> Result<Vec<ScalarValue>> {
    fn accumulator(&self, acc_args: AccumulatorArgs) -> Result<Box<dyn Accumulator>> {
        let view_array: &StringViewArray = downcast_value!(values[0], StringViewArray);
 * compatible open source license.
use std::sync::Arc;
 * The OpenSearch Contributors require contributions made to
    }
}
            let utf8_args = AccumulatorArgs {
        }
#[derive(Debug, PartialEq, Eq, Hash)]
}
use datafusion::common::{downcast_value, Result};
    signature: Signature,
//! by routing Utf8View through consistent &str hashing.
    ));
            Ok(Box::new(Utf8ViewToUtf8Accumulator { inner }))
    fn return_type(&self, args: &[DataType]) -> Result<DataType> {
}
    }
            // Wrap DF's Utf8 accumulator, feed it materialized &str from StringViewArray
        self.inner.merge_batch(states)
 * SPDX-License-Identifier: Apache-2.0
}
                is_reversed: acc_args.is_reversed,
/// Wraps DF's Utf8 HLL accumulator, converting Utf8View batches to StringArray on the fly.
//! Safe `approx_distinct` override — fixes https://github.com/apache/datafusion/pull/21064
 */
        Self {
        approx_distinct_udaf().inner().state_fields(args)
        }
    }
            approx_distinct_udaf().inner().accumulator(acc_args)
use datafusion::arrow::datatypes::{DataType, Field, FieldRef};
                order_bys: acc_args.order_bys,
//!
            .update_batch(&[Arc::new(string_array) as ArrayRef])
        self.inner.state()
        SafeApproxDistinct::new(),
    }
                expr_fields: &[Arc::new(Field::new("x", DataType::Utf8, true))],
impl SafeApproxDistinct {
    fn state_fields(&self, args: StateFieldsArgs) -> Result<Vec<FieldRef>> {
struct Utf8ViewToUtf8Accumulator {
    fn new() -> Self {
        let string_array: StringArray = view_array.iter().collect();
        &self.signature
    }
        approx_distinct_udaf().inner().return_type(args)
    fn name(&self) -> &str {
                exprs: acc_args.exprs,
    }
    }
        } else {
}
    fn documentation(&self) -> Option<&datafusion::logical_expr::Documentation> {
            };
        self.inner.evaluate()
    }
    }
//! TODO: Remove once fixed upstream (likely DataFusion v55/v56).
        self.inner
