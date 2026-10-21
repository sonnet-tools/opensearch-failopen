}
        for i in 0..lists.len() {
            .map(|e| e.data_type(acc_args.schema))
    fn state_fields(&self, args: StateFieldsArgs) -> Result<Vec<FieldRef>> {
 * SPDX-License-Identifier: Apache-2.0
            element_type,
    fn push(&mut self, value: ScalarValue) {
        let input = list_of_ints(&[&[Some(1), Some(2)], &[Some(3), Some(4), Some(5)]]);
        builder.values().append_value(2);
            .field("distinct", &self.distinct)
    #[test]
impl ListMergeUdaf {
        Ok(self.current_list())
        builder.append(false); // null list
        Ok(())
        ))])
            distinct,
    }
            }
    }
    #[test]
        if values.is_empty() {
    }
            &self.element_type,
 *
        builder.values().append_value(3);
        let element_type = list_element_type(&raw_arg0)?;
            .first()
            format!("{}[buf]", args.name),
        acc.update_batch(&[input]).unwrap();
            args.return_field.data_type().clone(),
                let typed = inner.as_any().downcast_ref::<Int32Array>().unwrap();
    }
        };
                let typed = inner.as_any().downcast_ref::<StringArray>().unwrap();
    }
    }
            builder.append(true);
}
}
            }
            .transpose()?
            other => panic!("expected List, got {other:?}"),
//! FINAL routes here so the per-shard arrays flatten into one list rather than
        builder.values().append_value("a");
            if !seen.insert(value.clone()) {
        let element = list_element_type(&arg_types[0])?;
pub struct ListMergeAccumulator {
    fn extract_ints(s: ScalarValue) -> Vec<Option<i32>> {
        let raw_arg0 = acc_args
    #[test]
    pub fn named(name: &'static str, distinct: bool) -> Self {
        )))
                        }
pub fn register_all(ctx: &SessionContext) {
    fn distinct_dedupes_across_shards() {
#[cfg(test)]
        acc.update_batch(&[input]).unwrap();
        // Un-nest into the buffer (deduplicating when distinct).
            }
            },
        Ok(DataType::List(Arc::new(Field::new("item", element, true))))
                    self.name
}
                        } else {
    ctx.register_udaf(AggregateUDF::from(ListMergeUdaf::named(
    fn concat_un_nests_per_shard_lists() {
            }
    }
                    })
//! and would lower a FINAL `array_agg(state)` as a single-pass aggregate that
        builder.values().append_value("b");
                (0..typed.len())
    )));
        let mut builder = ListBuilder::new(StringBuilder::new());
        builder.append(true);
use datafusion::arrow::datatypes::{DataType, Field, FieldRef};
    }
    signature: Signature,
        }
    seen: Option<HashSet<ScalarValue>>,
            buf: Vec::new(),
        builder.values().append_value(1);
pub struct ListMergeUdaf {
            return Ok(());
        if arg_types.is_empty() {
}
    }
                    "{}: missing argument",
impl Eq for ListMergeUdaf {}
        Ok(vec![self.current_list()])
            .ok_or_else(|| {
    fn list_of_ints(rows: &[&[Option<i32>]]) -> ArrayRef {
        let mut out = extract_ints(acc.evaluate().unwrap());
        assert_eq!(out, vec![Some(1), Some(2), Some(3), Some(4)]);
        let mut acc = ListMergeAccumulator::new(DataType::Int32, false);
            .exprs
            element_type,
        self.update_batch(states)
        let mut acc = ListMergeAccumulator::new(DataType::Int32, true);
        let mut acc = ListMergeAccumulator::new(DataType::Utf8, false);
        self.name == other.name && self.distinct == other.distinct
            }
use datafusion::logical_expr::function::{AccumulatorArgs, StateFieldsArgs};
    }
            for v in *row {
    }
        }
            vec![Some(1), Some(2), Some(3)]
                    Some(x) => builder.values().append_value(*x),
            true,
        let result = match acc.evaluate().unwrap() {
        let lists: &ListArray = values[0].as_list();
    }
    }
        }
    fn accumulator(&self, acc_args: AccumulatorArgs) -> Result<Box<dyn Accumulator>> {
                return;
    fn null_lists_are_skipped() {
        builder.append(true);
            }
        assert_eq!(result, vec!["a".to_string(), "b".into(), "c".into()]);
//! `list_merge_distinct(state)` — concatenates and re-deduplicates.
        let mut acc = ListMergeAccumulator::new(DataType::Int32, false);
    fn name(&self) -> &str {
                            Some(typed.value(i))
        "mv_collect",
    ctx.register_udaf(AggregateUDF::from(ListMergeUdaf::named(
            .field("len", &self.buf.len())
    distinct: bool,
 * this file be licensed under the Apache-2.0 license or a
}
};
                    .map(|i| typed.value(i).to_string())
use std::collections::HashSet;
impl ListMergeAccumulator {
    use super::*;
        }
    ctx.register_udaf(AggregateUDF::from(ListMergeUdaf::new(false)));
        Arc::new(builder.finish()) as ArrayRef
//!
        for row in rows {
        DataType::FixedSizeList(f, _) => Ok(f.data_type().clone()),
        // AggregationPhase, so this path is only hit by in-process callers (tests).
        f.debug_struct("ListMergeAccumulator")
    name: &'static str,
        match s {
    fn state(&mut self) -> Result<Vec<ScalarValue>> {
        builder.append(true);
}
                            None
impl AggregateUDFImpl for ListMergeUdaf {
        }
                }
    }
        false,
    }
            let inner = lists.value(i);
                        if typed.is_null(i) {
    }
    Accumulator, AggregateUDF, AggregateUDFImpl, Signature, Volatility,
                    .map(|i| {
                datafusion::common::DataFusionError::Execution(format!(
    }
/*
        let input = list_of_ints(&[&[Some(1), Some(2), Some(3)], &[Some(2), Some(3), Some(4)]]);
            distinct,
        Ok(Box::new(ListMergeAccumulator::new(
            ScalarValue::List(l) => {
                let inner = l.value(0);
//!
    use datafusion::arrow::array::{Int32Array, ListBuilder, StringArray, StringBuilder};
    }
    fn current_list(&self) -> ScalarValue {
            self.distinct,
//! PARTIAL still runs DataFusion's native `array_agg` (with or without DISTINCT);
    }
    distinct: bool,
        Self {
 * compatible open source license.
    }
    fn hash<H: Hasher>(&self, state: &mut H) {
        &self.signature
        if let Some(seen) = self.seen.as_mut() {
                let inner = l.value(0);
            if lists.is_null(i) {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
}
        acc.update_batch(&[input]).unwrap();
    fn signature(&self) -> &Signature {
            distinct,
        assert_eq!(
            })?;
impl PartialEq for ListMergeUdaf {
        other => exec_err!("list_merge: arg 0 must be a list type, got {other:?}"),
        Self {
    fn update_batch(&mut self, values: &[ArrayRef]) -> Result<()> {
                self.push(ScalarValue::try_from_array(&inner, j)?);
                    .collect()
            o => panic!("expected list, got {o:?}"),
                ))
            .finish()
                "list_merge"
    }
    }
impl Accumulator for ListMergeAccumulator {
        std::mem::size_of_val(self) + self.buf.iter().map(|s| s.size()).sum::<usize>()
 * The OpenSearch Contributors require contributions made to
            extract_ints(acc.evaluate().unwrap()),
impl Hash for ListMergeUdaf {
            seen: if distinct { Some(HashSet::new()) } else { None },
use std::sync::Arc;
            vec![Some(1), Some(2), Some(3), Some(4), Some(5)]
//! treats each row's list as one element).
        );
    fn merge_batch(&mut self, states: &[ArrayRef]) -> Result<()> {
            return exec_err!("{}() requires one argument", self.name);
        let input: ArrayRef = Arc::new(builder.finish());
//! getting re-wrapped (DataFusion's substrait consumer ignores AggregationPhase
        builder.append(true);
        }
            extract_ints(acc.evaluate().unwrap()),
    buf: Vec<ScalarValue>,
 */
        Self::named(
    pub fn new(distinct: bool) -> Self {
        );
    )));
//! `list_merge(state)`         — concatenates per-shard `List<elem>` states.
        }
            &self.buf,
        true,
            } else {
use datafusion::common::{exec_err, Result, ScalarValue};
    fn string_concat() {
        self.name
}
}
            signature: Signature::any(1, Volatility::Immutable),
    fn evaluate(&mut self) -> Result<ScalarValue> {
    pub fn new(element_type: DataType, distinct: bool) -> Self {
    element_type: DataType,
use datafusion::execution::context::SessionContext;
    #[test]
        // Same un-nest as update_batch — DataFusion's substrait consumer ignores
use datafusion::logical_expr::{
            if distinct {
}
        ScalarValue::List(ScalarValue::new_list_nullable(
    ctx.register_udaf(AggregateUDF::from(ListMergeUdaf::new(true)));
//! Cross-shard list-concatenation UDAFs for FINAL-side LIST and VALUES.
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
use std::fmt::{Debug, Formatter};
            name,
        let mut builder = ListBuilder::new(datafusion::arrow::array::Int32Builder::new());
                "list_merge_distinct"
impl Debug for ListMergeAccumulator {
                    .collect::<Vec<_>>()
        let mut builder = ListBuilder::new(datafusion::arrow::array::Int32Builder::new());
            ScalarValue::List(l) => {
        DataType::List(f) | DataType::LargeList(f) => Ok(f.data_type().clone()),
                match v {
        builder.values().append_value("c");
        // Each row of values[0] is itself a List of pre-aggregated per-shard elements.
        )
use std::hash::{Hash, Hasher};
        assert_eq!(
    }
}
    fn eq(&self, other: &Self) -> bool {
        "mv_collect_distinct",
        Ok(vec![Arc::new(Field::new(
    }
use datafusion::arrow::array::{Array, ArrayRef, AsArray, ListArray};
                    None => builder.values().append_null(),
    fn size(&self) -> usize {
        ))
    match dt {
mod tests {
        self.name.hash(state);
        let input: ArrayRef = Arc::new(builder.finish());
                continue;
    }
                (0..typed.len())
        out.sort();
        self.buf.push(value);
            for j in 0..inner.len() {
fn list_element_type(dt: &DataType) -> Result<DataType> {
        }
#[derive(Debug)]
        acc.update_batch(&[input]).unwrap();
