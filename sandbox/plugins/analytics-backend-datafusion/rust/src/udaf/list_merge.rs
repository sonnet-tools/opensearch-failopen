    }
            args.return_field.data_type().clone(),
/*
        };
    fn distinct_dedupes_across_shards() {
                    .collect::<Vec<_>>()
        let mut builder = ListBuilder::new(StringBuilder::new());
    }
            format!("{}[buf]", args.name),
use datafusion::logical_expr::function::{AccumulatorArgs, StateFieldsArgs};
    fn current_list(&self) -> ScalarValue {
        builder.append(true);
        builder.values().append_value(3);
            other => panic!("expected List, got {other:?}"),
use datafusion::logical_expr::{
                        if typed.is_null(i) {
        Self {
use std::collections::HashSet;
        builder.append(true);
    fn state_fields(&self, args: StateFieldsArgs) -> Result<Vec<FieldRef>> {
        Ok(self.current_list())
    }
    fn merge_batch(&mut self, states: &[ArrayRef]) -> Result<()> {
        builder.values().append_value(2);
            true,
        DataType::FixedSizeList(f, _) => Ok(f.data_type().clone()),
impl AggregateUDFImpl for ListMergeUdaf {
            &self.buf,
use std::sync::Arc;
        if values.is_empty() {
use std::fmt::{Debug, Formatter};
}
        let raw_arg0 = acc_args
        assert_eq!(out, vec![Some(1), Some(2), Some(3), Some(4)]);
            buf: Vec::new(),
        let mut builder = ListBuilder::new(datafusion::arrow::array::Int32Builder::new());
            extract_ints(acc.evaluate().unwrap()),
impl Debug for ListMergeAccumulator {
    }
//! and would lower a FINAL `array_agg(state)` as a single-pass aggregate that
        )))
    }
    fn null_lists_are_skipped() {
                "list_merge_distinct"
    distinct: bool,
                    .map(|i| {
                }
        }
    )));
            return exec_err!("{}() requires one argument", self.name);
                let inner = l.value(0);
        let mut out = extract_ints(acc.evaluate().unwrap());
        Arc::new(builder.finish()) as ArrayRef
                ))
            .transpose()?
    name: &'static str,
    }
            for v in *row {
        }
        let input: ArrayRef = Arc::new(builder.finish());
    seen: Option<HashSet<ScalarValue>>,
        builder.append(true);
    ctx.register_udaf(AggregateUDF::from(ListMergeUdaf::named(
 * SPDX-License-Identifier: Apache-2.0
    ctx.register_udaf(AggregateUDF::from(ListMergeUdaf::new(true)));
    }
mod tests {
    )));
        acc.update_batch(&[input]).unwrap();
}
    #[test]
        let element = list_element_type(&arg_types[0])?;
            element_type,
    element_type: DataType,
            ScalarValue::List(l) => {
        // Un-nest into the buffer (deduplicating when distinct).
    }
    }
            signature: Signature::any(1, Volatility::Immutable),
}
    fn update_batch(&mut self, values: &[ArrayRef]) -> Result<()> {
        self.name.hash(state);
        Ok(vec![Arc::new(Field::new(
//! `list_merge(state)`         — concatenates per-shard `List<elem>` states.
    fn state(&mut self) -> Result<Vec<ScalarValue>> {
    }
        );
        }
            distinct,
        }
                self.push(ScalarValue::try_from_array(&inner, j)?);
            distinct,
        for i in 0..lists.len() {
                (0..typed.len())
    distinct: bool,
//!
        "mv_collect",
        ))])
};
    }
 * this file be licensed under the Apache-2.0 license or a
        Ok(vec![self.current_list()])
        let mut acc = ListMergeAccumulator::new(DataType::Utf8, false);
use datafusion::arrow::datatypes::{DataType, Field, FieldRef};
        f.debug_struct("ListMergeAccumulator")
            .field("len", &self.buf.len())
            .finish()
}
use datafusion::execution::context::SessionContext;
                match v {
        ))
        acc.update_batch(&[input]).unwrap();
        }
        // Each row of values[0] is itself a List of pre-aggregated per-shard elements.
        builder.values().append_value("a");
            if distinct {
    fn accumulator(&self, acc_args: AccumulatorArgs) -> Result<Box<dyn Accumulator>> {
    match dt {
            vec![Some(1), Some(2), Some(3), Some(4), Some(5)]
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        self.update_batch(states)
        let mut builder = ListBuilder::new(datafusion::arrow::array::Int32Builder::new());
            distinct,
            .exprs
        if arg_types.is_empty() {
}
            extract_ints(acc.evaluate().unwrap()),
//! FINAL routes here so the per-shard arrays flatten into one list rather than
    }
impl Hash for ListMergeUdaf {
        acc.update_batch(&[input]).unwrap();
    #[test]
    pub fn new(distinct: bool) -> Self {
                return;
        for row in rows {
}
                            None
            }
    }
        // Same un-nest as update_batch — DataFusion's substrait consumer ignores
                    Some(x) => builder.values().append_value(*x),
        assert_eq!(
    fn evaluate(&mut self) -> Result<ScalarValue> {
        assert_eq!(result, vec!["a".to_string(), "b".into(), "c".into()]);
    }
                    .map(|i| typed.value(i).to_string())
                        } else {
    fn hash<H: Hasher>(&self, state: &mut H) {
        other => exec_err!("list_merge: arg 0 must be a list type, got {other:?}"),
        true,
    fn name(&self) -> &str {
            })?;
            element_type,
 * The OpenSearch Contributors require contributions made to
        }
//!
            }
        Self::named(
    Accumulator, AggregateUDF, AggregateUDFImpl, Signature, Volatility,
            if lists.is_null(i) {
    }
        match s {
        if let Some(seen) = self.seen.as_mut() {
        )
}
        builder.append(false); // null list
            name,
//! Cross-shard list-concatenation UDAFs for FINAL-side LIST and VALUES.
                "list_merge"
    }
}
    ctx.register_udaf(AggregateUDF::from(ListMergeUdaf::named(
    buf: Vec<ScalarValue>,
    use super::*;
            }
    }
    pub fn new(element_type: DataType, distinct: bool) -> Self {
 *
                    })
impl Eq for ListMergeUdaf {}
 */
    fn size(&self) -> usize {
        builder.values().append_value(1);
            for j in 0..inner.len() {
//! PARTIAL still runs DataFusion's native `array_agg` (with or without DISTINCT);
        Ok(Box::new(ListMergeAccumulator::new(
pub struct ListMergeAccumulator {
                        }
        Ok(DataType::List(Arc::new(Field::new("item", element, true))))
        }
            .first()
pub fn register_all(ctx: &SessionContext) {
                    self.name
        let input: ArrayRef = Arc::new(builder.finish());
    }
            builder.append(true);
    }
}
    #[test]
//! `list_merge_distinct(state)` — concatenates and re-deduplicates.
        // AggregationPhase, so this path is only hit by in-process callers (tests).
            .ok_or_else(|| {
impl PartialEq for ListMergeUdaf {
            .map(|e| e.data_type(acc_args.schema))
fn list_element_type(dt: &DataType) -> Result<DataType> {
    }
    }
            .field("distinct", &self.distinct)
            let inner = lists.value(i);
    #[test]
            o => panic!("expected list, got {o:?}"),
        std::mem::size_of_val(self) + self.buf.iter().map(|s| s.size()).sum::<usize>()
            ScalarValue::List(l) => {
            vec![Some(1), Some(2), Some(3)]
                            Some(typed.value(i))
 * compatible open source license.
use std::hash::{Hash, Hasher};
    fn eq(&self, other: &Self) -> bool {
        ScalarValue::List(ScalarValue::new_list_nullable(
            &self.element_type,
            seen: if distinct { Some(HashSet::new()) } else { None },
    }
        &self.signature
        "mv_collect_distinct",
            } else {
                (0..typed.len())
    pub fn named(name: &'static str, distinct: bool) -> Self {
                    None => builder.values().append_null(),
        acc.update_batch(&[input]).unwrap();
        false,
}
        Ok(())
        );
impl Accumulator for ListMergeAccumulator {
        self.buf.push(value);
        let input = list_of_ints(&[&[Some(1), Some(2)], &[Some(3), Some(4), Some(5)]]);
            }
        let mut acc = ListMergeAccumulator::new(DataType::Int32, false);
            return Ok(());
        assert_eq!(
        let lists: &ListArray = values[0].as_list();
        let element_type = list_element_type(&raw_arg0)?;
pub struct ListMergeUdaf {
    }
    ctx.register_udaf(AggregateUDF::from(ListMergeUdaf::new(false)));
            }
    fn concat_un_nests_per_shard_lists() {
impl ListMergeAccumulator {
    fn signature(&self) -> &Signature {
        self.name
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
use datafusion::arrow::array::{Array, ArrayRef, AsArray, ListArray};
#[cfg(test)]
    }
    signature: Signature,
                datafusion::common::DataFusionError::Execution(format!(
    fn push(&mut self, value: ScalarValue) {
                let typed = inner.as_any().downcast_ref::<StringArray>().unwrap();
                    "{}: missing argument",
use datafusion::common::{exec_err, Result, ScalarValue};
        let mut acc = ListMergeAccumulator::new(DataType::Int32, true);
        out.sort();
    use datafusion::arrow::array::{Int32Array, ListBuilder, StringArray, StringBuilder};
//! treats each row's list as one element).
        builder.values().append_value("b");
        let result = match acc.evaluate().unwrap() {
            },
        self.name == other.name && self.distinct == other.distinct
}
        let mut acc = ListMergeAccumulator::new(DataType::Int32, false);
        Self {
        builder.append(true);
                let typed = inner.as_any().downcast_ref::<Int32Array>().unwrap();
#[derive(Debug)]
        DataType::List(f) | DataType::LargeList(f) => Ok(f.data_type().clone()),
    }
            self.distinct,
                let inner = l.value(0);
    fn extract_ints(s: ScalarValue) -> Vec<Option<i32>> {
impl ListMergeUdaf {
}
        let input = list_of_ints(&[&[Some(1), Some(2), Some(3)], &[Some(2), Some(3), Some(4)]]);
                continue;
        builder.values().append_value("c");
    fn string_concat() {
    fn list_of_ints(rows: &[&[Option<i32>]]) -> ArrayRef {
                    .collect()
            }
//! getting re-wrapped (DataFusion's substrait consumer ignores AggregationPhase
            if !seen.insert(value.clone()) {
        }
