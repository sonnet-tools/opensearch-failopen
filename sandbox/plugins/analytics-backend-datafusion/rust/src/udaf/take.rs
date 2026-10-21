//! * Default `n` (when only one argument supplied): `10`.
    #[test]
    fn update_batch(&mut self, values: &[ArrayRef]) -> Result<()> {
/*
    pub fn new(element_type: DataType, limit: Option<i64>, arg0_is_list: bool) -> Self {
            format!("{}[buf]", args.name),
fn limit_from_args(acc_args: &AccumulatorArgs) -> Result<Option<i64>> {
    /// {@code testTakeAcrossShards} IT.
    }
            ScalarValue::List(l) => l,
        match acc.evaluate().unwrap() {
            }
        let arr2: ArrayRef = Arc::new(Int32Array::from(vec![Some(3), Some(4), Some(5)]));
//! implementation, which assumes single-accumulator scan order.
                    return Ok(());
        }
        };
    }
        //   row 1 = [3, 4, 5]
            arg0_is_list,
                (0..typed.len())
            Some(30),
    }
    fn returns_first_n_values_in_arrival_order() {
            let arr: ArrayRef = Arc::new(Int32Array::from_iter(b.iter().copied()));
impl Hash for TakeUdaf {
const DEFAULT_LIMIT: i64 = 10;
    }
        // `take(state)` arg 0 is itself a `List<elem>` carrying each shard's bounded
                    "take(): missing first argument".to_string(),
        std::mem::size_of_val(self) + self.buf.iter().map(|s| s.size()).sum::<usize>()
                        }
                let typed = inner.as_any().downcast_ref::<StringArray>().unwrap();
        Ok(())
}
        coord.update_batch(&[combined]).unwrap();
        other => exec_err!("take(): n must be an integer, got {other:?}"),
        };
    fn size(&self) -> usize {
/// * `Some(n)` when the second argument is a Substrait literal.
                            Some(typed.value(i))
        let out = run_int_batches(Some(3), &[&[Some(10), Some(20), Some(30), Some(40)]]);
            let lists: &ListArray = col.as_list();
            o => panic!("expected list result, got {o:?}"),
    }
    #[test]
#[cfg(test)]
            }
//! `take(field, [n])` — bounded array of the first `n` values per group in
//!
        other => other.clone(),
        let raw_arg0 = acc_args
    fn caps_across_multiple_update_batches() {
        };
        assert_eq!(result, vec![Some(1), Some(2), Some(3), Some(4)]);
        shard2.update_batch(&[arr2]).unwrap();
    }
//! Distributed correctness: each per-shard accumulator emits its bounded buffer
        let state: ArrayRef = match acc.state().unwrap().pop().unwrap() {
        // Both return List<element>, so peel one level of List off arg 0 if present.
        // FINAL with n=4 must take [1, 2, 3, 4].
            }
                }
/// and FINAL (list-state column) inputs to the same element type.
            }
        ScalarValue::Int32(Some(v)) => Ok(*v as i64),
        DataType::FixedSizeList(field, _) => field.data_type().clone(),
        assert_eq!(out, vec![10, 20, 30]);
    #[test]
            o => panic!("expected list result, got {o:?}"),
use std::sync::Arc;
    buf: Vec<ScalarValue>,
                        if typed.is_null(i) {
        let state1: ArrayRef = match acc1.state().unwrap().pop().unwrap() {
    /// If the limit is still unknown, try to read it from row 0 of `n_col`.
            o => panic!("expected list state, got {o:?}"),
        Ok(vec![self.current_list()])
    fn limit_resolved_from_column_when_not_a_literal() {
            .ok_or_else(|| {
}
        // Simulate Calcite's "literal materialised as a Project column" case:
        coord.merge_batch(&[combined]).unwrap();
        acc.update_batch(&[arr]).unwrap();
                    })
        ScalarValue::UInt8(Some(v)) => Ok(*v as i64),
        let lists: &ListArray = states[0].as_list();
    }
        ScalarValue::Int64(Some(v)) => Ok(*v),
    match scalar {
        self.limit = Some(scalar_to_i64(&scalar)?);
/// If `dt` is `List<E>` / `LargeList<E>` / `FixedSizeList<E>`, return `E`;
    fn string_take_round_trips_through_state() {
            o => panic!("expected list result, got {o:?}"),
//! reference (not a `Literal`), `limit_from_args` returns `None` and the
                        }
                let typed = inner.as_any().downcast_ref::<Int32Array>().unwrap();
/// accumulator construction time we may only see a column reference, not a
        //   PARTIAL: take(value, n)     — arg 0 is the element type
                let inner = l.value(0);
use datafusion::execution::context::SessionContext;
                    }
                (0..typed.len())
/// `Project` column rather than passing it as a Substrait literal — at
            .map(|e| e.data_type(acc_args.schema))
            return Ok(());
            // identical semantics to `merge_batch` — DataFusion's substrait consumer
            }
                if self.buf.len() >= cap {
        let values: ArrayRef = Arc::new(Int32Array::from(vec![
//! of that column (every row carries the same constant value).
        // Two call shapes:
pub fn register_all(ctx: &SessionContext) {
        };
        let out = match acc.evaluate().unwrap() {
    }
            if self.buf.len() >= cap {
                datafusion::common::DataFusionError::Execution(
        let out = run_int_batches(Some(3), &[&[None, Some(2), None, Some(4)]]);
            for i in 0..lists.len() {
    fn fewer_than_n_values_returns_what_was_seen() {
            return exec_err!("take() requires at least one argument");
            buf: Vec::with_capacity(cap.min(1024)),
/// literal value. In that case we resolve the limit on the first
        let result = match coord.evaluate().unwrap() {
fn scalar_to_i64(scalar: &ScalarValue) -> Result<i64> {
}
    /// element column directly.
/// Try to extract the integer limit from the aggregate's second physical
 * SPDX-License-Identifier: Apache-2.0
    #[test]
                        }
                continue;
    fn cap(&self) -> usize {
    #[test]
            return Ok(());
                        if typed.is_null(i) {
            Some(40),
                }
            acc.update_batch(&[arr]).unwrap();
        assert_eq!(result, vec![Some("a".into()), Some("b".into())]);
            other => panic!("expected list scalar, got {other:?}"),
        }
            Some(l) if l > 0 => l as usize,
//! * `n <= 0`: never append — returns an empty list.
            DataType::List(_) | DataType::LargeList(_) | DataType::FixedSizeList(_, _),
}
        // schema matches what the coordinator's `merge_batch` consumes.
///   into the aggregate). The accumulator resolves the limit on the first
///
            limit,
        //   FINAL  : take(list_state)   — arg 0 is List<element>
                }
    ctx.register_udaf(AggregateUDF::from(TakeUdaf::new()));
            ScalarValue::List(l) => l,
//!
            .transpose()?
}
        };
        | ScalarValue::UInt32(None)
            ScalarValue::List(l) => {
    #[test]
        | ScalarValue::UInt8(None)
    }
        let s1: ArrayRef = match shard1.state().unwrap().pop().unwrap() {
                self.buf.push(ScalarValue::try_from_array(&inner, j)?);
        // buffer — `update_batch` must un-nest each list-row into elements rather than
    fn name(&self) -> &str {
            let inner = lists.value(i);
        // FINAL accumulator: arg0_is_list=true, drives `update_batch` (not merge_batch).
        | ScalarValue::Int64(None)
                        } else {
        let arr1: ArrayRef = Arc::new(Int32Array::from(vec![Some(1), Some(2)]));
use datafusion::logical_expr::function::{AccumulatorArgs, StateFieldsArgs};
        let cap = self.cap();
                        } else {
                    })
                    .collect::<Vec<_>>()
        let n_col: ArrayRef = Arc::new(Int32Array::from(vec![3, 3, 3, 3]));
        let mut shard1 = TakeAccumulator::new(DataType::Int32, Some(4), false);
        let arr = ScalarValue::new_list_nullable(&self.buf, &self.element_type);
    fn signature(&self) -> &Signature {
        }
        }
                }
                let typed = inner.as_any().downcast_ref::<Int32Array>().unwrap();
        let scalar = ScalarValue::try_from_array(n_col, 0)?;
                let typed = inner.as_any().downcast_ref::<Int32Array>().unwrap();
    /// at `n`, the same semantics as `merge_batch`. Mirrors the cross-shard
            element_type,
        return Ok(Some(DEFAULT_LIMIT));
                let inner = lists.value(i);
        ScalarValue::Int8(None)
                self.buf.push(ScalarValue::try_from_array(col, i)?);
                let typed = inner.as_any().downcast_ref::<Int32Array>().unwrap();
                    .collect()
            while self.buf.len() < cap && i < col.len() {
}
        // (`take(state) -> List<elem>`) call shapes, so the per-shard state
///   materializes the literal `n` as a `Project` column instead of inlining it
            }
//! accumulator resolves the limit on the first `update_batch` call from row 0
//! `n`. Cross-shard ordering is non-deterministic — same property as the Java
            // FINAL form: each row of `col` is itself a List of pre-capped elements
        let mut acc = TakeAccumulator::new(DataType::Int32, None, false);
        );
 *
impl Eq for TakeUdaf {}
        Ok(self.current_list())
            Some(10),
        let combined: ArrayRef =
/// `limit` is `Option` because Calcite often materializes the literal `n` as a
        }
                    continue;
    }
    use super::*;
            .field("limit", &self.limit)
    /// The Calcite plan materializes the literal `n` as a constant column —
    /// buffer. `update_batch` must un-nest the list rows into elements and cap
    /// appending. False for the PARTIAL `take(value, n)` shape where arg 0 is the
        }
        let result = match coord.evaluate().unwrap() {
    fn eq(&self, _other: &Self) -> bool {
        let cap = limit.filter(|&l| l > 0).map(|l| l as usize).unwrap_or(0);
        }
                    })
        }
    }
    fn merge_batch_concatenates_partial_states_and_caps() {
        )))
}
        Ok(())
        "take"
            o => panic!("expected list state, got {o:?}"),
impl Debug for TakeAccumulator {
        ScalarValue::UInt32(Some(v)) => Ok(*v as i64),
            arg0_is_list,
}
    fn merge_batch(&mut self, states: &[ArrayRef]) -> Result<()> {
    pub fn new() -> Self {
            self.resolve_limit_from(n_col)?;
}
                (0..typed.len()).map(|i| typed.value(i)).collect::<Vec<_>>()
    }
//! Mirrors PPL's [`TakeAggFunction`] semantics:
    /// True when arg 0 is a `List<elem>` column (the FINAL `take(state)` call shape) —
    if let Some(lit) = expr.downcast_ref::<Literal>() {
    match dt {
//! * NULL elements are appended like any other value.
            o => panic!("expected list state, got {o:?}"),
        let s2: ArrayRef = match shard2.state().unwrap().pop().unwrap() {
        //   row 0 = [1, 2]
        }
            ScalarValue::List(l) => {
        Ok(DataType::List(Arc::new(Field::new("item", element, true))))
/// no-ops. `limit <= 0` → never accept anything → empty result list.
    fn current_list(&self) -> ScalarValue {
        | ScalarValue::UInt64(None) => Ok(DEFAULT_LIMIT),
                    .map(|i| {
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
            o => panic!("expected list state, got {o:?}"),
    }
/// Bounded buffer of `ScalarValue`s. Capped at `limit`; further appends are
}
    /// every row carries the same value, so reading row 0 is sufficient.
        let element_type = inner_element_type(&raw_arg0);
        // pushing the whole list as a single value.
        "take".hash(state);
 */
                        } else {
}
            .exprs
        };
    }
                let inner = l.value(0);
    }
                        if typed.is_null(i) {
//! as a `List<element>` scalar via `state()`, the coordinator's final
                i += 1;
        let arg0_is_list = matches!(
        if cap == 0 {
            let mut i = 0;
        Ok(vec![Arc::new(Field::new(
            Some(3),
/// * `None` when the second argument is a column reference (Calcite often
        let out = run_int_batches(Some(5), &[&[Some(1), Some(2)]]);
            ScalarValue::List(l) => l,
///   `update_batch` call by reading row 0 of that column.
    }
            signature: Signature::variadic_any(Volatility::Immutable),
        let mut acc = TakeAccumulator::new(DataType::Utf8, Some(2), false);
        return scalar_to_i64(lit.value()).map(Some);
            datafusion::arrow::compute::concat(&[state1.as_ref(), state2.as_ref()]).unwrap();
    signature: Signature,
    limit: Option<i64>,
impl Accumulator for TakeAccumulator {
        // is the raw element column and we accumulate values directly. For FINAL
/// * `Some(DEFAULT_LIMIT)` when the aggregate has only one argument.
        true
        ))])
        if self.arg0_is_list {
    fn state(&mut self) -> Result<Vec<ScalarValue>> {
        let element = inner_element_type(&arg_types[0]);
    fn resolve_limit_from(&mut self, n_col: &ArrayRef) -> Result<()> {
        shard1.update_batch(&[arr1]).unwrap();
            _ => 0,
//! accumulator concatenates incoming lists in `merge_batch()` and trims back to
        ScalarValue::Int16(Some(v)) => Ok(*v as i64),
    let Some(expr) = acc_args.exprs.get(1) else {
        for b in batches {
            datafusion::arrow::compute::concat(&[s1.as_ref(), s2.as_ref()]).unwrap();
        let mut acc = TakeAccumulator::new(DataType::Int32, limit, false);
//!
            raw_arg0,
        let mut acc2 = TakeAccumulator::new(DataType::Int32, Some(4), false);
                    .collect::<Vec<_>>()
mod tests {
            ScalarValue::List(l) => l,
    fn default() -> Self {
    arg0_is_list: bool,
                            Some(typed.value(i))
            .finish()
        assert_eq!(out, vec![Some(1), Some(2)]);
}
    }
        let mut shard2 = TakeAccumulator::new(DataType::Int32, Some(4), false);
        let state2: ArrayRef = match acc2.state().unwrap().pop().unwrap() {
        };
//!
pub struct TakeAccumulator {
use datafusion::arrow::array::{Array, ArrayRef, AsArray, ListArray};
            ScalarValue::List(l) => {
            ScalarValue::List(l) => {
    fn state_fields(&self, args: StateFieldsArgs) -> Result<Vec<FieldRef>> {
/// `take(value, [n])` aggregate UDF.
        ScalarValue::Int8(Some(v)) => Ok(*v as i64),
                if self.buf.len() >= cap {
                    if self.buf.len() >= cap {
//!
    }
use datafusion::common::{exec_err, Result, ScalarValue};
impl TakeAccumulator {
    fn hash<H: Hasher>(&self, state: &mut H) {
        ]));
    }
    Accumulator, AggregateUDF, AggregateUDFImpl, Signature, Volatility,
 * The OpenSearch Contributors require contributions made to
        }
//! passing it as a Substrait literal. When `accumulator()` only sees a column
        let mut coord = TakeAccumulator::new(DataType::Utf8, Some(2), false);
                            None
                if lists.is_null(i) {
    fn run_int_batches(limit: Option<i64>, batches: &[&[Option<i32>]]) -> Vec<Option<i32>> {
            return Ok(());
    Ok(None)
/// same constant value).
    }
        Ok(Box::new(TakeAccumulator::new(
        ScalarValue::UInt64(Some(v)) => Ok(*v as i64),
            // ignores aggregation phase, so coordinator-side reduction shows up here.
        // The accumulator stores individual elements. For PARTIAL `take(value, n)` arg 0
    #[test]
            .first()
    fn null_elements_are_preserved_in_arrival_order() {
        DataType::List(field) | DataType::LargeList(field) => field.data_type().clone(),
        acc.update_batch(&[values, n_col]).unwrap();
            for j in 0..inner.len() {
        Self {
/// otherwise return `dt` unchanged. Used to normalize PARTIAL (element column)
                for j in 0..inner.len() {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
    fn evaluate(&mut self) -> Result<ScalarValue> {
            }
                (0..typed.len()).map(|i| typed.value(i)).collect::<Vec<_>>()
            if lists.is_null(i) {
        f.debug_struct("TakeAccumulator")
};
#[derive(Debug)]
    use datafusion::arrow::array::{Int32Array, StringArray};
        Self::new()
            }
        let mut acc1 = TakeAccumulator::new(DataType::Int32, Some(4), false);
    fn final_shape_un_nests_list_input_rows_and_caps() {
                    .map(|i| {
        let result = match coord.evaluate().unwrap() {
                let inner = l.value(0);
                )
//! Calcite often materialises the literal `n` as a `Project` column rather than
                    return Ok(());
            // emitted by a per-shard PARTIAL. Un-nest into the buffer up to `cap`,
        | ScalarValue::Int16(None)
    }
        if self.limit.is_some() || n_col.len() == 0 {
        // limit is None at construction, accumulator reads row 0 of arg 1.
            }
        let cap = self.cap();
                            None
}
        if let Some(n_col) = values.get(1) {
    }
        coord.merge_batch(&[state]).unwrap();
    fn accumulator(&self, acc_args: AccumulatorArgs) -> Result<Box<dyn Accumulator>> {
        assert_eq!(out, vec![Some(10), Some(20), Some(30)]);
            Some(20),
            o => panic!("expected list state, got {o:?}"),
    }
 * this file be licensed under the Apache-2.0 license or a
        // the PARTIAL (`take(value, n) -> List<elem>`) and FINAL
}
        Self {
            &[&[Some(1), Some(2)], &[Some(3), Some(4), Some(5)]],
    }
    }
/// expression. Returns:
    }
use datafusion::physical_expr::expressions::Literal;
        let limit = limit_from_args(&acc_args)?;
            .field("len", &self.buf.len())
impl TakeUdaf {
        acc1.update_batch(&[arr1]).unwrap();
fn inner_element_type(dt: &DataType) -> DataType {
    #[test]
            }
        assert_eq!(result, vec![1, 2, 3, 4]);
impl Default for TakeUdaf {
                    self.buf.push(ScalarValue::try_from_array(&inner, j)?);
        | ScalarValue::UInt16(None)
    element_type: DataType,
            other => panic!("expected list scalar, got {other:?}"),
        // Use the function's own return_field — it is `List<elem>` in both
            true,
//! arrival order.
        assert_eq!(out, vec![Some(1), Some(2), Some(3)]);
impl AggregateUDFImpl for TakeUdaf {
}
        let arr1: ArrayRef = Arc::new(Int32Array::from(vec![Some(1), Some(2)]));
        // Two shards' partial outputs as List<Int32> rows:
//! [`TakeAggFunction`]: https://github.com/opensearch-project/sql/blob/main/core/src/main/java/org/opensearch/sql/calcite/udf/udaf/TakeAggFunction.java
 * compatible open source license.
    }
    /// `update_batch` un-nests each list-row into individual elements before
        assert_eq!(out, vec![None, Some(2), None]);
impl PartialEq for TakeUdaf {
            element_type,
        }
use datafusion::arrow::datatypes::{DataType, Field, FieldRef};
    }
                let inner = l.value(0);
        let out = run_int_batches(
                            Some(typed.value(i).to_string())
                (0..typed.len())
                let inner = l.value(0);
    }
use std::fmt::{Debug, Formatter};
        let arr: ArrayRef = Arc::new(StringArray::from(vec![Some("a"), Some("b"), Some("c")]));
        }
        match self.limit {
        };
        let arr2: ArrayRef = Arc::new(Int32Array::from(vec![Some(3), Some(4), Some(5)]));
        if cap == 0 {
        );
        let combined: ArrayRef =
        ScalarValue::List(arr)
        Ok(())
    }
                        return Ok(());
            })?;
        let mut coord = TakeAccumulator::new(DataType::Int32, Some(4), false);
            ScalarValue::List(l) => l,
    }
        } else {
                            None
            limit,
        for i in 0..lists.len() {
/// `update_batch` call from row 0 of the second column (every row carries the
    };
use std::hash::{Hash, Hasher};
        let col = &values[0];
                    .map(|i| {
            ScalarValue::List(l) => {
        | ScalarValue::Int32(None)
        acc2.update_batch(&[arr2]).unwrap();
                return Ok(());
    /// FINAL-stage shape: arg 0 is `List<elem>` carrying each shard's bounded
            args.return_field.data_type().clone(),
        };
        &self.signature
pub struct TakeUdaf {
//! * `n > 0`: append values in scan order until the buffer holds `n` items.
        ScalarValue::UInt16(Some(v)) => Ok(*v as i64),
        // Build the wire-shape `List<Int32>` column carrying both partial results.
        let mut coord = TakeAccumulator::new(DataType::Int32, Some(4), true);
use datafusion::logical_expr::{
        if arg_types.is_empty() {
