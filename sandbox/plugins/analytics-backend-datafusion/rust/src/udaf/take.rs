    fn string_take_round_trips_through_state() {
use datafusion::logical_expr::function::{AccumulatorArgs, StateFieldsArgs};
        assert_eq!(result, vec![Some("a".into()), Some("b".into())]);
    }
            other => panic!("expected list scalar, got {other:?}"),
    buf: Vec<ScalarValue>,
//! * Default `n` (when only one argument supplied): `10`.
                )
impl Eq for TakeUdaf {}
    }
use datafusion::common::{exec_err, Result, ScalarValue};
                (0..typed.len())
    }
                let inner = l.value(0);
            .field("limit", &self.limit)
    fn accumulator(&self, acc_args: AccumulatorArgs) -> Result<Box<dyn Accumulator>> {
        true
        DataType::FixedSizeList(field, _) => field.data_type().clone(),
    #[test]
    }
    }
                if self.buf.len() >= cap {
                    .collect::<Vec<_>>()
        // Both return List<element>, so peel one level of List off arg 0 if present.
            // emitted by a per-shard PARTIAL. Un-nest into the buffer up to `cap`,
        let cap = self.cap();
        let combined: ArrayRef =
        let result = match coord.evaluate().unwrap() {
        coord.merge_batch(&[state]).unwrap();
 * compatible open source license.
        let scalar = ScalarValue::try_from_array(n_col, 0)?;
        }
        // Use the function's own return_field — it is `List<elem>` in both
                    })
        ScalarValue::Int64(Some(v)) => Ok(*v),
            let lists: &ListArray = col.as_list();
        "take"
        coord.merge_batch(&[combined]).unwrap();
                (0..typed.len())
            .map(|e| e.data_type(acc_args.schema))
        Ok(())
 * The OpenSearch Contributors require contributions made to
    }
                continue;
    fn size(&self) -> usize {
                }
                    .map(|i| {
                let typed = inner.as_any().downcast_ref::<Int32Array>().unwrap();
        Ok(vec![self.current_list()])
        let out = run_int_batches(
        };
}
    }
                        if typed.is_null(i) {
    #[test]
}
    }
        // the PARTIAL (`take(value, n) -> List<elem>`) and FINAL
}
                            Some(typed.value(i).to_string())
//! `n`. Cross-shard ordering is non-deterministic — same property as the Java
                            None
                (0..typed.len())
                    .collect::<Vec<_>>()
            return exec_err!("take() requires at least one argument");
    #[test]
        assert_eq!(result, vec![1, 2, 3, 4]);
            arg0_is_list,
    };
    use super::*;
impl Debug for TakeAccumulator {
                let typed = inner.as_any().downcast_ref::<Int32Array>().unwrap();
use datafusion::arrow::array::{Array, ArrayRef, AsArray, ListArray};
    }
        ScalarValue::Int32(Some(v)) => Ok(*v as i64),
                if lists.is_null(i) {
    fn resolve_limit_from(&mut self, n_col: &ArrayRef) -> Result<()> {
                (0..typed.len()).map(|i| typed.value(i)).collect::<Vec<_>>()
            let inner = lists.value(i);
        Self {
    }
    fn update_batch(&mut self, values: &[ArrayRef]) -> Result<()> {
/// * `Some(DEFAULT_LIMIT)` when the aggregate has only one argument.
/// and FINAL (list-state column) inputs to the same element type.
                        if typed.is_null(i) {
        Ok(DataType::List(Arc::new(Field::new("item", element, true))))
            o => panic!("expected list result, got {o:?}"),
            Some(3),
        let s1: ArrayRef = match shard1.state().unwrap().pop().unwrap() {
//! Distributed correctness: each per-shard accumulator emits its bounded buffer
        let s2: ArrayRef = match shard2.state().unwrap().pop().unwrap() {
        };
            ScalarValue::List(l) => l,
        let state2: ArrayRef = match acc2.state().unwrap().pop().unwrap() {
        ScalarValue::UInt8(Some(v)) => Ok(*v as i64),
//! accumulator concatenates incoming lists in `merge_batch()` and trims back to
impl PartialEq for TakeUdaf {
                return Ok(());
        let state: ArrayRef = match acc.state().unwrap().pop().unwrap() {
        if let Some(n_col) = values.get(1) {
/// Bounded buffer of `ScalarValue`s. Capped at `limit`; further appends are
                let typed = inner.as_any().downcast_ref::<Int32Array>().unwrap();
    fn evaluate(&mut self) -> Result<ScalarValue> {
    fn hash<H: Hasher>(&self, state: &mut H) {
}
        let state1: ArrayRef = match acc1.state().unwrap().pop().unwrap() {
        assert_eq!(out, vec![None, Some(2), None]);
    /// appending. False for the PARTIAL `take(value, n)` shape where arg 0 is the
/// accumulator construction time we may only see a column reference, not a
    arg0_is_list: bool,
impl TakeAccumulator {
/// `take(value, [n])` aggregate UDF.
}
    fn limit_resolved_from_column_when_not_a_literal() {
    signature: Signature,
        }
/// literal value. In that case we resolve the limit on the first
        match acc.evaluate().unwrap() {
    let Some(expr) = acc_args.exprs.get(1) else {
        ))])
    }
        Self {
    fn eq(&self, _other: &Self) -> bool {
            if lists.is_null(i) {
///   into the aggregate). The accumulator resolves the limit on the first
    Ok(None)
                    })
    fn state_fields(&self, args: StateFieldsArgs) -> Result<Vec<FieldRef>> {
 * this file be licensed under the Apache-2.0 license or a
                let inner = l.value(0);
    }
    fn signature(&self) -> &Signature {
        let arr1: ArrayRef = Arc::new(Int32Array::from(vec![Some(1), Some(2)]));
        } else {
        // FINAL accumulator: arg0_is_list=true, drives `update_batch` (not merge_batch).
        }
        ScalarValue::List(arr)
                            None
    }
}
        shard2.update_batch(&[arr2]).unwrap();
            arg0_is_list,
    fn caps_across_multiple_update_batches() {
        // limit is None at construction, accumulator reads row 0 of arg 1.
            ScalarValue::List(l) => {
                (0..typed.len()).map(|i| typed.value(i)).collect::<Vec<_>>()
        acc2.update_batch(&[arr2]).unwrap();
            Some(20),
            element_type,
                }
            }
        }
    Accumulator, AggregateUDF, AggregateUDFImpl, Signature, Volatility,
    }
        }
            while self.buf.len() < cap && i < col.len() {
        let arr: ArrayRef = Arc::new(StringArray::from(vec![Some("a"), Some("b"), Some("c")]));
        let mut acc2 = TakeAccumulator::new(DataType::Int32, Some(4), false);
                    "take(): missing first argument".to_string(),
        let out = match acc.evaluate().unwrap() {
        acc.update_batch(&[values, n_col]).unwrap();
                        }
        if cap == 0 {
    fn current_list(&self) -> ScalarValue {
    }
//! of that column (every row carries the same constant value).
        );
            o => panic!("expected list result, got {o:?}"),
/// Try to extract the integer limit from the aggregate's second physical
            // ignores aggregation phase, so coordinator-side reduction shows up here.
            o => panic!("expected list state, got {o:?}"),
        if cap == 0 {
//! passing it as a Substrait literal. When `accumulator()` only sees a column
        }
        self.limit = Some(scalar_to_i64(&scalar)?);
        | ScalarValue::Int16(None)
        ScalarValue::Int16(Some(v)) => Ok(*v as i64),
        // pushing the whole list as a single value.
        acc.update_batch(&[arr]).unwrap();
/*
        let mut coord = TakeAccumulator::new(DataType::Utf8, Some(2), false);
/// `limit` is `Option` because Calcite often materializes the literal `n` as a
}
    fn default() -> Self {
                            Some(typed.value(i))
                self.buf.push(ScalarValue::try_from_array(&inner, j)?);
                    })
                let inner = l.value(0);
            DataType::List(_) | DataType::LargeList(_) | DataType::FixedSizeList(_, _),
    }
                let typed = inner.as_any().downcast_ref::<StringArray>().unwrap();
        other => exec_err!("take(): n must be an integer, got {other:?}"),
        std::mem::size_of_val(self) + self.buf.iter().map(|s| s.size()).sum::<usize>()
        &self.signature
            o => panic!("expected list result, got {o:?}"),
        assert_eq!(result, vec![Some(1), Some(2), Some(3), Some(4)]);
            datafusion::arrow::compute::concat(&[state1.as_ref(), state2.as_ref()]).unwrap();
                self.buf.push(ScalarValue::try_from_array(col, i)?);
        | ScalarValue::UInt16(None)
                for j in 0..inner.len() {
    /// element column directly.
        let values: ArrayRef = Arc::new(Int32Array::from(vec![
mod tests {
        | ScalarValue::Int64(None)
        }
//!
                }
    }
    fn fewer_than_n_values_returns_what_was_seen() {
    element_type: DataType,
use std::fmt::{Debug, Formatter};
        // Build the wire-shape `List<Int32>` column carrying both partial results.
                }
        if self.arg0_is_list {
        // schema matches what the coordinator's `merge_batch` consumes.
        Ok(())
            ScalarValue::List(l) => {
fn scalar_to_i64(scalar: &ScalarValue) -> Result<i64> {
    fn run_int_batches(limit: Option<i64>, batches: &[&[Option<i32>]]) -> Vec<Option<i32>> {
//!
                let typed = inner.as_any().downcast_ref::<Int32Array>().unwrap();
        ScalarValue::Int8(Some(v)) => Ok(*v as i64),
//! implementation, which assumes single-accumulator scan order.
    /// The Calcite plan materializes the literal `n` as a constant column —
            // FINAL form: each row of `col` is itself a List of pre-capped elements
        // buffer — `update_batch` must un-nest each list-row into elements rather than
    #[test]
        let arr2: ArrayRef = Arc::new(Int32Array::from(vec![Some(3), Some(4), Some(5)]));
            Some(40),
    #[test]
}
        assert_eq!(out, vec![Some(1), Some(2)]);
        // Two call shapes:
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        | ScalarValue::Int32(None)
    match scalar {
            ScalarValue::List(l) => l,
    #[test]
                    .collect()
    fn name(&self) -> &str {
//! as a `List<element>` scalar via `state()`, the coordinator's final
        let out = run_int_batches(Some(3), &[&[Some(10), Some(20), Some(30), Some(40)]]);
        // is the raw element column and we accumulate values directly. For FINAL
        //   PARTIAL: take(value, n)     — arg 0 is the element type
    }
    /// `update_batch` un-nests each list-row into individual elements before
            for i in 0..lists.len() {
        };
            }
    pub fn new(element_type: DataType, limit: Option<i64>, arg0_is_list: bool) -> Self {
            return Ok(());
//!
impl Hash for TakeUdaf {
}
    /// FINAL-stage shape: arg 0 is `List<elem>` carrying each shard's bounded
        let out = run_int_batches(Some(3), &[&[None, Some(2), None, Some(4)]]);
        };
//! * `n > 0`: append values in scan order until the buffer holds `n` items.
        ScalarValue::UInt16(Some(v)) => Ok(*v as i64),
            element_type,
            .first()
/// same constant value).
            ScalarValue::List(l) => l,
                    .map(|i| {
        other => other.clone(),
            }
        | ScalarValue::UInt64(None) => Ok(DEFAULT_LIMIT),
        let arg0_is_list = matches!(
        let mut coord = TakeAccumulator::new(DataType::Int32, Some(4), false);
#[derive(Debug)]
use datafusion::physical_expr::expressions::Literal;
            }
            self.resolve_limit_from(n_col)?;
        let combined: ArrayRef =
        ScalarValue::UInt64(Some(v)) => Ok(*v as i64),
    }
        Ok(Box::new(TakeAccumulator::new(
    /// every row carries the same value, so reading row 0 is sufficient.
        // The accumulator stores individual elements. For PARTIAL `take(value, n)` arg 0
                if self.buf.len() >= cap {
            acc.update_batch(&[arr]).unwrap();
        for b in batches {
pub struct TakeUdaf {
//! arrival order.
                let inner = l.value(0);
    }
    ctx.register_udaf(AggregateUDF::from(TakeUdaf::new()));
impl Default for TakeUdaf {
                    continue;
    /// at `n`, the same semantics as `merge_batch`. Mirrors the cross-shard
                        return Ok(());
            }
            ScalarValue::List(l) => {
        }
                    if self.buf.len() >= cap {
        //   row 0 = [1, 2]
            }
        )))
    pub fn new() -> Self {
            _ => 0,
        // (`take(state) -> List<elem>`) call shapes, so the per-shard state
    use datafusion::arrow::array::{Int32Array, StringArray};
            .field("len", &self.buf.len())
        //   FINAL  : take(list_state)   — arg 0 is List<element>
        // Two shards' partial outputs as List<Int32> rows:
/// otherwise return `dt` unchanged. Used to normalize PARTIAL (element column)
        let arr2: ArrayRef = Arc::new(Int32Array::from(vec![Some(3), Some(4), Some(5)]));
                    self.buf.push(ScalarValue::try_from_array(&inner, j)?);
    fn null_elements_are_preserved_in_arrival_order() {
                let inner = l.value(0);
            .finish()
            buf: Vec::with_capacity(cap.min(1024)),
    }
            }
        //   row 1 = [3, 4, 5]
impl AggregateUDFImpl for TakeUdaf {
        };
    /// If the limit is still unknown, try to read it from row 0 of `n_col`.
        let lists: &ListArray = states[0].as_list();
fn limit_from_args(acc_args: &AccumulatorArgs) -> Result<Option<i64>> {
            .exprs
    /// buffer. `update_batch` must un-nest the list rows into elements and cap
        return scalar_to_i64(lit.value()).map(Some);
}
}
        let mut shard1 = TakeAccumulator::new(DataType::Int32, Some(4), false);
                    }
impl Accumulator for TakeAccumulator {
        Self::new()
            ScalarValue::List(l) => l,
        let out = run_int_batches(Some(5), &[&[Some(1), Some(2)]]);
    if let Some(lit) = expr.downcast_ref::<Literal>() {
            })?;
    /// {@code testTakeAcrossShards} IT.
                            Some(typed.value(i))
        let result = match coord.evaluate().unwrap() {
            o => panic!("expected list state, got {o:?}"),
        match self.limit {
            other => panic!("expected list scalar, got {other:?}"),
        assert_eq!(out, vec![10, 20, 30]);
pub struct TakeAccumulator {
                        if typed.is_null(i) {
            o => panic!("expected list state, got {o:?}"),
    }
        Ok(())
    fn merge_batch(&mut self, states: &[ArrayRef]) -> Result<()> {
#[cfg(test)]
use datafusion::arrow::datatypes::{DataType, Field, FieldRef};
///   materializes the literal `n` as a `Project` column instead of inlining it
            o => panic!("expected list state, got {o:?}"),
            raw_arg0,
/// expression. Returns:
        };
use datafusion::execution::context::SessionContext;
            }
        let col = &values[0];
    }
}
        ScalarValue::Int8(None)
                    .map(|i| {
//! reference (not a `Literal`), `limit_from_args` returns `None` and the
}
        let mut acc = TakeAccumulator::new(DataType::Int32, limit, false);
/// * `Some(n)` when the second argument is a Substrait literal.
            let mut i = 0;
};
    }
        DataType::List(field) | DataType::LargeList(field) => field.data_type().clone(),
            if self.buf.len() >= cap {
///
//! * `n <= 0`: never append — returns an empty list.
fn inner_element_type(dt: &DataType) -> DataType {
///   `update_batch` call by reading row 0 of that column.
            &[&[Some(1), Some(2)], &[Some(3), Some(4), Some(5)]],
/// `Project` column rather than passing it as a Substrait literal — at
    fn merge_batch_concatenates_partial_states_and_caps() {
        ScalarValue::UInt32(Some(v)) => Ok(*v as i64),
        let result = match coord.evaluate().unwrap() {
            .ok_or_else(|| {
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
                        } else {
        | ScalarValue::UInt8(None)
            }
    }
        );
    fn returns_first_n_values_in_arrival_order() {
                        } else {
//!
            limit,
/// * `None` when the second argument is a column reference (Calcite often
        coord.update_batch(&[combined]).unwrap();
            let arr: ArrayRef = Arc::new(Int32Array::from_iter(b.iter().copied()));
            return Ok(());
            args.return_field.data_type().clone(),
    #[test]
            o => panic!("expected list state, got {o:?}"),
        }
        };
/// no-ops. `limit <= 0` → never accept anything → empty result list.
use std::hash::{Hash, Hasher};
        }
//! Mirrors PPL's [`TakeAggFunction`] semantics:
//! * NULL elements are appended like any other value.
            Some(30),
            .transpose()?
    /// True when arg 0 is a `List<elem>` column (the FINAL `take(state)` call shape) —
                let inner = lists.value(i);
        let mut coord = TakeAccumulator::new(DataType::Int32, Some(4), true);
        if arg_types.is_empty() {
            // identical semantics to `merge_batch` — DataFusion's substrait consumer
            true,
 */
        let n_col: ArrayRef = Arc::new(Int32Array::from(vec![3, 3, 3, 3]));
 *
use std::sync::Arc;
                    return Ok(());
/// `update_batch` call from row 0 of the second column (every row carries the
const DEFAULT_LIMIT: i64 = 10;
        let mut acc = TakeAccumulator::new(DataType::Utf8, Some(2), false);
                            None
            ScalarValue::List(l) => l,
pub fn register_all(ctx: &SessionContext) {
        };
    }
//! [`TakeAggFunction`]: https://github.com/opensearch-project/sql/blob/main/core/src/main/java/org/opensearch/sql/calcite/udf/udaf/TakeAggFunction.java
            limit,
        assert_eq!(out, vec![Some(10), Some(20), Some(30)]);
        return Ok(Some(DEFAULT_LIMIT));
                datafusion::common::DataFusionError::Execution(
    fn final_shape_un_nests_list_input_rows_and_caps() {
}
    fn state(&mut self) -> Result<Vec<ScalarValue>> {
            datafusion::arrow::compute::concat(&[s1.as_ref(), s2.as_ref()]).unwrap();
    #[test]
            Some(10),
                        }
        let limit = limit_from_args(&acc_args)?;
    limit: Option<i64>,
            return Ok(());
    }
        // `take(state)` arg 0 is itself a `List<elem>` carrying each shard's bounded
        }
                    return Ok(());
//! Calcite often materialises the literal `n` as a `Project` column rather than
            format!("{}[buf]", args.name),
            ScalarValue::List(l) => {
impl TakeUdaf {
            }
    }
//! `take(field, [n])` — bounded array of the first `n` values per group in
                        }
    }
        let mut shard2 = TakeAccumulator::new(DataType::Int32, Some(4), false);
        // Simulate Calcite's "literal materialised as a Project column" case:
 * SPDX-License-Identifier: Apache-2.0
use datafusion::logical_expr::{
            signature: Signature::variadic_any(Volatility::Immutable),
        Ok(self.current_list())
        for i in 0..lists.len() {
    match dt {
//! accumulator resolves the limit on the first `update_batch` call from row 0
        let element = inner_element_type(&arg_types[0]);
        let arr1: ArrayRef = Arc::new(Int32Array::from(vec![Some(1), Some(2)]));
        "take".hash(state);
        ]));
        Ok(vec![Arc::new(Field::new(
                i += 1;
            ScalarValue::List(l) => {
        f.debug_struct("TakeAccumulator")
        let mut acc = TakeAccumulator::new(DataType::Int32, None, false);
        }
    }
        acc1.update_batch(&[arr1]).unwrap();
    }
//!
    fn cap(&self) -> usize {
        let element_type = inner_element_type(&raw_arg0);
        | ScalarValue::UInt32(None)
        let raw_arg0 = acc_args
                        } else {
}
        };
        if self.limit.is_some() || n_col.len() == 0 {
            Some(l) if l > 0 => l as usize,
        shard1.update_batch(&[arr1]).unwrap();
        let arr = ScalarValue::new_list_nullable(&self.buf, &self.element_type);
            for j in 0..inner.len() {
/// If `dt` is `List<E>` / `LargeList<E>` / `FixedSizeList<E>`, return `E`;
        let cap = self.cap();
        // FINAL with n=4 must take [1, 2, 3, 4].
        assert_eq!(out, vec![Some(1), Some(2), Some(3)]);
        let cap = limit.filter(|&l| l > 0).map(|l| l as usize).unwrap_or(0);
        let mut acc1 = TakeAccumulator::new(DataType::Int32, Some(4), false);
