 *
        )))
    element_type: DataType,
        }
}
            .field("len", &self.seen.len())
        let mut s2 = OsCountDistinctAccumulator::new(DataType::Int32, false);
        let st2: ArrayRef = match s2.state().unwrap().pop().unwrap() {
            }
            o => panic!("expected Int64, got {o:?}"),
//!
    /// un-nest each list-row into individual elements rather than treating the
    use datafusion::arrow::array::{Int32Array, StringArray};
        match acc.evaluate().unwrap() {
                continue;
                    "os_count_distinct: missing argument".to_string(),
            ScalarValue::Int64(Some(n)) => n,
//! `AggregationInvocation::DISTINCT` bit on window aggregates (the consumer
        // {1, 2} (None ignored) → 2
        s1.update_batch(&[Arc::new(Int32Array::from(vec![Some(1), Some(2)])) as ArrayRef])
                    continue;
    }
    }
    #[test]
    pub fn new() -> Self {
    fn default() -> Self {
            }
    fn name(&self) -> &str {
        }
impl Debug for OsCountDistinctAccumulator {
        };
        let mut s1 = OsCountDistinctAccumulator::new(DataType::Int32, false);
}
        let n = run_int_batches(&[&[]]);
                return exec_err!("os_count_distinct: state_fields needs at least one input field")
    fn merge_unions_per_shard_states() {
//! FINAL re-unions and counts.
pub struct OsCountDistinctAccumulator {
impl Accumulator for OsCountDistinctAccumulator {
        // List-typed column rather than merge_batch.
        };
            }
        let raw_arg0 = acc_args
            .transpose()?
impl Default for OsCountDistinctUdaf {
    use super::*;
        Self {
//! `os_count_distinct(x)` — exact distinct count for use in a window context.
            if col.is_null(i) {
//!
            arg0_is_list,
                datafusion::common::DataFusionError::Execution(
    #[test]
        // avoids re-introducing a list of i64 counts (which would lose
    }
}
use std::hash::{Hash, Hasher};
    }
        shard1
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        Ok(DataType::Int64)
        let element_type = inner_element_type(&raw_arg0);
use datafusion::logical_expr::{
    #[test]
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
 * SPDX-License-Identifier: Apache-2.0
            .ok_or_else(|| {
    }
        Ok(vec![ScalarValue::List(arr)])
//! plain `count(DISTINCT x) OVER(...)` therefore reaches the executor as a
            self.add_from_list(col)
        Ok(())
        DataType::FixedSizeList(field, _) => field.data_type().clone(),
            return Ok(());
            // {1, 2, 3, 4} → 4
use datafusion::arrow::datatypes::{DataType, Field, FieldRef};
            o => panic!("expected list state, got {o:?}"),
        "os_count_distinct".hash(state);
            element_type,
//! frame. NULL inputs are skipped — matches `count(DISTINCT x)` SQL semantics
//! `merge_batch` unions per-shard sets. PARTIAL emits the dedup'd values,
}
            .unwrap();
        Ok(Box::new(OsCountDistinctAccumulator::new(
 * this file be licensed under the Apache-2.0 license or a
    }
            ScalarValue::List(l) => l,
        }
        f.debug_struct("OsCountDistinctAccumulator")
        // State is the dedup'd value set so merge_batch can union shard sets
        coord.merge_batch(&[combined]).unwrap();
        true
#[cfg(test)]
            signature: Signature::any(1, Volatility::Immutable),
            ScalarValue::List(l) => l,
impl OsCountDistinctUdaf {
            .first()
        for i in 0..col.len() {
        }
        if values.is_empty() {
    #[test]
}
        assert_eq!(n, 2);
    }
        }
            .exprs
    }
    fn signature(&self) -> &Signature {
use std::sync::Arc;
            o => panic!("expected list, got {o:?}"),
            .unwrap();
    fn run_int_batches(batches: &[&[Option<i32>]]) -> i64 {
        };
    }
            o => panic!("expected Int64, got {o:?}"),
    }
        let lists: &ListArray = col.as_list();
    ctx.register_udaf(AggregateUDF::from(OsCountDistinctUdaf::new()));
    fn dedupes_across_batches() {
    #[test]
            ScalarValue::Int64(Some(n)) => assert_eq!(n, 3),
                Arc::new(StringArray::from(vec![Some("a"), Some("b"), Some("a")])) as ArrayRef,
    }
    }
            ])
            .unwrap();
        let st1: ArrayRef = match s1.state().unwrap().pop().unwrap() {
        );
    /// whole list as a single value.
            ScalarValue::List(l) => l,
    arg0_is_list: bool,
}
//! and the running cumulative behavior expected by `OVER(ORDER BY)`.
impl OsCountDistinctAccumulator {
            datafusion::arrow::compute::concat(&[st1.as_ref(), st2.as_ref()]).unwrap();
    fn skips_nulls() {
    }
        Ok(vec![Arc::new(Field::new(
                continue;
 * compatible open source license.
        Self::new()
    }
    fn empty_input_returns_zero() {
        for b in batches {
        }
}
    fn state_fields(&self, args: StateFieldsArgs) -> Result<Vec<FieldRef>> {
    fn merge_batch(&mut self, states: &[ArrayRef]) -> Result<()> {
        other => other.clone(),
 */
    }
        self.add_from_list(&states[0])
        assert_eq!(n, 0);
use datafusion::arrow::array::{Array, ArrayRef, AsArray, ListArray};
        let arr = ScalarValue::new_list_nullable(&values, &self.element_type);
        for i in 0..lists.len() {
                }
use std::collections::HashSet;
    pub fn new(element_type: DataType, arg0_is_list: bool) -> Self {
    }
            acc.update_batch(&[arr]).unwrap();
impl PartialEq for OsCountDistinctUdaf {
            seen: HashSet::new(),
            DataType::List(Arc::new(Field::new("item", element_type, true))),
        let mut coord = OsCountDistinctAccumulator::new(DataType::Int32, false);
    }
            ScalarValue::List(l) => l,
        // {1, 2, 3} → 3
        match coord.evaluate().unwrap() {
            .map(|e| e.data_type(acc_args.schema))
        match coord.evaluate().unwrap() {
        let s1: ArrayRef = match shard1.state().unwrap().pop().unwrap() {
        let combined: ArrayRef =
        }
    fn final_shape_un_nests_list_input_rows() {
            ScalarValue::Int64(Some(n)) => assert_eq!(n, 4),
        let col = &values[0];
            .update_batch(&[Arc::new(StringArray::from(vec![Some("b"), Some("c")])) as ArrayRef])
use datafusion::logical_expr::function::{AccumulatorArgs, StateFieldsArgs};
        let values: Vec<ScalarValue> = self.seen.iter().cloned().collect();
    fn size(&self) -> usize {
            Some(f) => inner_element_type(f.data_type()),
pub struct OsCountDistinctUdaf {
            arg0_is_list,
        assert_eq!(n, 3);
pub fn register_all(ctx: &SessionContext) {
            true,
    fn counts_distinct_non_null_values() {
impl AggregateUDFImpl for OsCountDistinctUdaf {
mod tests {
/// If `dt` is a list type, return its element type; otherwise return `dt`.
//! Why this UDAF exists: DataFusion 54.x's substrait crate drops the
    fn add_from_array(&mut self, col: &ArrayRef) -> Result<()> {
    match dt {
    }
//! Distributed correctness: state is `List<value>` (the dedup'd set), so
        &self.signature
use std::fmt::{Debug, Formatter};
    }
 * The OpenSearch Contributors require contributions made to
        Ok(ScalarValue::Int64(Some(self.seen.len() as i64)))
        coord.update_batch(&[combined]).unwrap();
}
}
/// PARTIAL sees the raw element column; FINAL sees a `List<element>` carrying
            None => {
//! hardcodes `distinct: false` and the producer writes `invocation: 0`). A
        // {1, 2, 3} → 3
            element_type,
                if inner.is_null(j) {
            datafusion::arrow::compute::concat(&[s1.as_ref(), s2.as_ref()]).unwrap();
        // and recount on the coordinator. Reusing the input's element type
        Self {
    }
        let arg0_is_list = matches!(
use datafusion::common::{exec_err, Result, ScalarValue};
}
        let s2: ArrayRef = match shard2.state().unwrap().pop().unwrap() {
    }
    /// True when arg 0 is a list column (FINAL stage) — `update_batch` must
        Ok(())
            if lists.is_null(i) {
            .unwrap();
    }
    Accumulator, AggregateUDF, AggregateUDFImpl, Signature, Volatility,
}
            let inner = lists.value(i);
}
            }
        let n = run_int_batches(&[&[Some(1), None, Some(2), None, Some(1)]]);
//! `datafusion-substrait`.
        DataType::List(field) | DataType::LargeList(field) => field.data_type().clone(),
    }
            return Ok(());
                self.seen.insert(ScalarValue::try_from_array(&inner, j)?);
    fn all_nulls_return_zero() {
fn inner_element_type(dt: &DataType) -> DataType {
/*
            raw_arg0,
            format!("{}[set]", args.name),
                )
        // FINAL stage: arg0_is_list=true, drives update_batch on the
    fn evaluate(&mut self) -> Result<ScalarValue> {
        std::mem::size_of_val(self) + self.seen.iter().map(|s| s.size()).sum::<usize>()
//! plain `count(x)`. By encoding DISTINCT in the *operator name* instead of
            o => panic!("expected list, got {o:?}"),
            self.add_from_array(col)
        } else {
    fn add_from_list(&mut self, col: &ArrayRef) -> Result<()> {
    signature: Signature,
        ))])
            .update_batch(&[
        shard2
        };
            o => panic!("expected list state, got {o:?}"),
        let mut acc = OsCountDistinctAccumulator::new(DataType::Int32, false);
        };
    }
    seen: HashSet<ScalarValue>,
    fn accumulator(&self, acc_args: AccumulatorArgs) -> Result<Box<dyn Accumulator>> {
    fn hash<H: Hasher>(&self, state: &mut H) {
            other => panic!("expected Int64, got {other:?}"),
        }
        "os_count_distinct"
            let arr: ArrayRef = Arc::new(Int32Array::from_iter(b.iter().copied()));
        let n = run_int_batches(&[&[Some(1), Some(2), Some(2), Some(3), Some(1)]]);
            // {a, b, c} → 3
            self.seen.insert(ScalarValue::try_from_array(col, i)?);
    fn state(&mut self) -> Result<Vec<ScalarValue>> {
        let n = run_int_batches(&[&[None, None, None]]);
        let mut shard2 = OsCountDistinctAccumulator::new(DataType::Utf8, false);
        let combined: ArrayRef =
        let mut shard1 = OsCountDistinctAccumulator::new(DataType::Utf8, false);
        }
    fn eq(&self, _other: &Self) -> bool {
        assert_eq!(n, 0);
        assert_eq!(n, 3);
use datafusion::execution::context::SessionContext;
            for j in 0..inner.len() {
            .finish()
        if states.is_empty() {
        s2.update_batch(&[Arc::new(Int32Array::from(vec![Some(2), Some(3), Some(4)])) as ArrayRef])
};
        // distinct semantics across shards).
        let n = run_int_batches(&[&[Some(1), Some(2)], &[Some(2), Some(3)]]);
        let element_type = match args.input_fields.first() {
            DataType::List(_) | DataType::LargeList(_) | DataType::FixedSizeList(_, _),
impl Hash for OsCountDistinctUdaf {
#[derive(Debug)]
        if self.arg0_is_list {
/// each shard's dedup'd state. Both paths land in the same accumulator.
    }
    }
//! Semantics: emits the count of distinct, non-null values per group / per
    #[test]
    #[test]
            })?;
//!
    fn update_batch(&mut self, values: &[ArrayRef]) -> Result<()> {
//! the invocation enum, we sidestep the bug without vendoring a fork of
impl Eq for OsCountDistinctUdaf {}
        let mut coord = OsCountDistinctAccumulator::new(DataType::Utf8, true);
    }
        }
}
        }
