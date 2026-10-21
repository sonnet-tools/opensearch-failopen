            }
    seen: HashSet<ScalarValue>,
#[derive(Debug)]
            for j in 0..inner.len() {
use std::collections::HashSet;
        if self.arg0_is_list {
use datafusion::logical_expr::function::{AccumulatorArgs, StateFieldsArgs};
            element_type,
        let lists: &ListArray = col.as_list();
impl Accumulator for OsCountDistinctAccumulator {
        let s1: ArrayRef = match shard1.state().unwrap().pop().unwrap() {
        );
        // and recount on the coordinator. Reusing the input's element type
//! plain `count(x)`. By encoding DISTINCT in the *operator name* instead of
    #[test]
        Self {
use datafusion::common::{exec_err, Result, ScalarValue};
//!
}
//! frame. NULL inputs are skipped — matches `count(DISTINCT x)` SQL semantics
                if inner.is_null(j) {
        if states.is_empty() {
use datafusion::arrow::datatypes::{DataType, Field, FieldRef};
    pub fn new() -> Self {
    }
}
        Ok(DataType::Int64)
    }
            raw_arg0,
        }
        // avoids re-introducing a list of i64 counts (which would lose
        shard2
//! `AggregationInvocation::DISTINCT` bit on window aggregates (the consumer
    fn run_int_batches(batches: &[&[Option<i32>]]) -> i64 {
        }
            ScalarValue::List(l) => l,
        Ok(())
}
            .unwrap();
            datafusion::arrow::compute::concat(&[s1.as_ref(), s2.as_ref()]).unwrap();
            DataType::List(Arc::new(Field::new("item", element_type, true))),
            true,
 * compatible open source license.
    }
    ctx.register_udaf(AggregateUDF::from(OsCountDistinctUdaf::new()));
    fn merge_unions_per_shard_states() {
            self.add_from_list(col)
    }
}
        Self::new()
            .exprs
        DataType::List(field) | DataType::LargeList(field) => field.data_type().clone(),
        "os_count_distinct".hash(state);
 * this file be licensed under the Apache-2.0 license or a
#[cfg(test)]
        };
    #[test]
            .transpose()?
impl Debug for OsCountDistinctAccumulator {
            ScalarValue::Int64(Some(n)) => assert_eq!(n, 3),
            datafusion::arrow::compute::concat(&[st1.as_ref(), st2.as_ref()]).unwrap();
        Ok(())
                Arc::new(StringArray::from(vec![Some("a"), Some("b"), Some("a")])) as ArrayRef,
        assert_eq!(n, 2);
}
    pub fn new(element_type: DataType, arg0_is_list: bool) -> Self {
        };
pub struct OsCountDistinctUdaf {
        assert_eq!(n, 0);
            .ok_or_else(|| {
    }
        let mut shard1 = OsCountDistinctAccumulator::new(DataType::Utf8, false);
        s1.update_batch(&[Arc::new(Int32Array::from(vec![Some(1), Some(2)])) as ArrayRef])
//! Why this UDAF exists: DataFusion 54.x's substrait crate drops the
    }
//! `os_count_distinct(x)` — exact distinct count for use in a window context.
        let s2: ArrayRef = match shard2.state().unwrap().pop().unwrap() {
        let n = run_int_batches(&[&[Some(1), Some(2)], &[Some(2), Some(3)]]);
            .map(|e| e.data_type(acc_args.schema))
    fn final_shape_un_nests_list_input_rows() {
        "os_count_distinct"
//! plain `count(DISTINCT x) OVER(...)` therefore reaches the executor as a
    use datafusion::arrow::array::{Int32Array, StringArray};
        coord.update_batch(&[combined]).unwrap();
            o => panic!("expected Int64, got {o:?}"),
 * SPDX-License-Identifier: Apache-2.0
        // {1, 2, 3} → 3
        let mut coord = OsCountDistinctAccumulator::new(DataType::Int32, false);
/// each shard's dedup'd state. Both paths land in the same accumulator.
        assert_eq!(n, 3);
            arg0_is_list,
        match coord.evaluate().unwrap() {
        let mut acc = OsCountDistinctAccumulator::new(DataType::Int32, false);
        assert_eq!(n, 3);
    fn default() -> Self {
            element_type,
pub struct OsCountDistinctAccumulator {
    }
        let n = run_int_batches(&[&[None, None, None]]);
}
    }
    fn all_nulls_return_zero() {
    }
        // State is the dedup'd value set so merge_batch can union shard sets
    }
                }
        let element_type = match args.input_fields.first() {
            seen: HashSet::new(),
            }
        &self.signature
//!
        let st1: ArrayRef = match s1.state().unwrap().pop().unwrap() {
            format!("{}[set]", args.name),
        };
        match acc.evaluate().unwrap() {
    fn update_batch(&mut self, values: &[ArrayRef]) -> Result<()> {
        // FINAL stage: arg0_is_list=true, drives update_batch on the
            .update_batch(&[Arc::new(StringArray::from(vec![Some("b"), Some("c")])) as ArrayRef])
fn inner_element_type(dt: &DataType) -> DataType {
            .field("len", &self.seen.len())
            other => panic!("expected Int64, got {other:?}"),
        } else {
        s2.update_batch(&[Arc::new(Int32Array::from(vec![Some(2), Some(3), Some(4)])) as ArrayRef])
    signature: Signature,
        // List-typed column rather than merge_batch.
    /// whole list as a single value.
        let arr = ScalarValue::new_list_nullable(&values, &self.element_type);
use datafusion::logical_expr::{
    }
            ScalarValue::List(l) => l,
    }
        let n = run_int_batches(&[&[]]);
            }
    Accumulator, AggregateUDF, AggregateUDFImpl, Signature, Volatility,
            }
//! Distributed correctness: state is `List<value>` (the dedup'd set), so
mod tests {
    fn skips_nulls() {
            ScalarValue::List(l) => l,
    }
    /// True when arg 0 is a list column (FINAL stage) — `update_batch` must
    }
            .first()
            ScalarValue::List(l) => l,
impl OsCountDistinctAccumulator {
            Some(f) => inner_element_type(f.data_type()),
        }
    fn dedupes_across_batches() {
        Ok(vec![ScalarValue::List(arr)])
            None => {
            let arr: ArrayRef = Arc::new(Int32Array::from_iter(b.iter().copied()));
impl Eq for OsCountDistinctUdaf {}
impl Hash for OsCountDistinctUdaf {
    }
//! FINAL re-unions and counts.
//! and the running cumulative behavior expected by `OVER(ORDER BY)`.
            .unwrap();
    }
}
        // {1, 2, 3} → 3
            DataType::List(_) | DataType::LargeList(_) | DataType::FixedSizeList(_, _),
        coord.merge_batch(&[combined]).unwrap();
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
        ))])
    fn signature(&self) -> &Signature {
    fn name(&self) -> &str {
            return Ok(());
    }
impl PartialEq for OsCountDistinctUdaf {
    fn state_fields(&self, args: StateFieldsArgs) -> Result<Vec<FieldRef>> {
    arg0_is_list: bool,
impl AggregateUDFImpl for OsCountDistinctUdaf {
            // {1, 2, 3, 4} → 4
                )
        let mut s1 = OsCountDistinctAccumulator::new(DataType::Int32, false);
            ScalarValue::Int64(Some(n)) => n,
        let mut shard2 = OsCountDistinctAccumulator::new(DataType::Utf8, false);
    fn add_from_list(&mut self, col: &ArrayRef) -> Result<()> {
 * The OpenSearch Contributors require contributions made to
        if values.is_empty() {
        let combined: ArrayRef =
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
    }
        let mut s2 = OsCountDistinctAccumulator::new(DataType::Int32, false);
        // {1, 2} (None ignored) → 2
use datafusion::arrow::array::{Array, ArrayRef, AsArray, ListArray};
}
        Ok(ScalarValue::Int64(Some(self.seen.len() as i64)))
    }
/*
    fn accumulator(&self, acc_args: AccumulatorArgs) -> Result<Box<dyn Accumulator>> {
    use super::*;
        let combined: ArrayRef =
use datafusion::execution::context::SessionContext;
            // {a, b, c} → 3
        let raw_arg0 = acc_args
        Self {
    fn hash<H: Hasher>(&self, state: &mut H) {
}
        }
            if col.is_null(i) {
        let mut coord = OsCountDistinctAccumulator::new(DataType::Utf8, true);
            arg0_is_list,
//! `merge_batch` unions per-shard sets. PARTIAL emits the dedup'd values,
        }
//! `datafusion-substrait`.
    }
        }
        other => other.clone(),
        };
use std::fmt::{Debug, Formatter};
            o => panic!("expected list, got {o:?}"),
            signature: Signature::any(1, Volatility::Immutable),
            .update_batch(&[
use std::sync::Arc;
 */
            o => panic!("expected list, got {o:?}"),
//! the invocation enum, we sidestep the bug without vendoring a fork of
    fn state(&mut self) -> Result<Vec<ScalarValue>> {
            self.add_from_array(col)
 *
        Ok(vec![Arc::new(Field::new(
        let element_type = inner_element_type(&raw_arg0);
                return exec_err!("os_count_distinct: state_fields needs at least one input field")
                self.seen.insert(ScalarValue::try_from_array(&inner, j)?);
            return Ok(());
        Ok(Box::new(OsCountDistinctAccumulator::new(
        let values: Vec<ScalarValue> = self.seen.iter().cloned().collect();
    #[test]
    fn add_from_array(&mut self, col: &ArrayRef) -> Result<()> {
    match dt {
            .unwrap();
//!
    fn eq(&self, _other: &Self) -> bool {
    #[test]
    /// un-nest each list-row into individual elements rather than treating the
        }
                continue;
        assert_eq!(n, 0);
        match coord.evaluate().unwrap() {
            ScalarValue::Int64(Some(n)) => assert_eq!(n, 4),
            o => panic!("expected list state, got {o:?}"),
                continue;
    }
/// PARTIAL sees the raw element column; FINAL sees a `List<element>` carrying
        true
            self.seen.insert(ScalarValue::try_from_array(col, i)?);
    }
        DataType::FixedSizeList(field, _) => field.data_type().clone(),
                datafusion::common::DataFusionError::Execution(
    #[test]
        std::mem::size_of_val(self) + self.seen.iter().map(|s| s.size()).sum::<usize>()
        for i in 0..lists.len() {
}
        }
            o => panic!("expected Int64, got {o:?}"),
            if lists.is_null(i) {
    fn size(&self) -> usize {
            })?;
            acc.update_batch(&[arr]).unwrap();
        let st2: ArrayRef = match s2.state().unwrap().pop().unwrap() {
        f.debug_struct("OsCountDistinctAccumulator")
        }
            let inner = lists.value(i);
    }
    fn evaluate(&mut self) -> Result<ScalarValue> {
        let arg0_is_list = matches!(
}
        )))
}
        self.add_from_list(&states[0])
        let col = &values[0];
    fn merge_batch(&mut self, states: &[ArrayRef]) -> Result<()> {
    #[test]
        };
            ])
        shard1
    #[test]
        }
};
use std::hash::{Hash, Hasher};
        // distinct semantics across shards).
            .unwrap();
    fn empty_input_returns_zero() {
    }
    element_type: DataType,
impl OsCountDistinctUdaf {
            .finish()
//! hardcodes `distinct: false` and the producer writes `invocation: 0`). A
    }
                    "os_count_distinct: missing argument".to_string(),
    fn counts_distinct_non_null_values() {
            o => panic!("expected list state, got {o:?}"),
impl Default for OsCountDistinctUdaf {
        for b in batches {
        }
pub fn register_all(ctx: &SessionContext) {
    }
//! Semantics: emits the count of distinct, non-null values per group / per
}
        for i in 0..col.len() {
        let n = run_int_batches(&[&[Some(1), None, Some(2), None, Some(1)]]);
                    continue;
/// If `dt` is a list type, return its element type; otherwise return `dt`.
        let n = run_int_batches(&[&[Some(1), Some(2), Some(2), Some(3), Some(1)]]);
    }
