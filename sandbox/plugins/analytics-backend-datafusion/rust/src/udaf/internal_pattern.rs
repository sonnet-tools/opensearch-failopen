fn build_struct_array(entries: &[PatternEntry], show_numbered_token: bool) -> Result<StructArray> {
            self.config.variable_count_threshold,
    }
    fn append_strings(&mut self, arr: &ArrayRef) -> Result<()> {
    }
struct AggConfig {
                let sample_inner = sample_logs_col.value(i);
            }
        vec![pattern_array, count_array, tokens_array, sample_logs_array],
impl AggConfig {
            "baz@qux.org".to_string(),
        ScalarValue::UInt16(Some(v)) => Ok(*v as usize),
            "{}: expected string column, got {:?}",
            return Ok(empty_list_struct_scalar()?);
            let Some(lit) = expr.downcast_ref::<Literal>() else {
impl PartialEq for InternalPatternUdaf {
fn tokens_map_type() -> DataType {
                    config.threshold_percentage = scalar_to_f64(lit.value())?;
        if self.buffer.is_empty() {
    let sample_logs_array: ArrayRef = Arc::new(sample_logs_builder.finish());
        StringBuilder::new(),
                if !strs.is_null(i) {
}
                | ScalarValue::UInt16(_)
    arg0_is_list: bool,
    fn merge_batch_concatenates_partial_states() {
            other => panic!("expected List, got {other:?}"),
//! ignored (no partial pre-aggregation).
}
        // Same shape repeated several times — BRAIN should merge them into
    let mut pattern_builder = StringBuilder::with_capacity(n, n * 64);
        // When show_numbered_token is true, re-run eval_samples to produce
    let struct_array = build_struct_array(entries, show_numbered_token)?;
//! Mirrors `org.opensearch.sql.calcite.udf.udaf.LogPatternAggFunction` on the
//! `Uncollect` → `flattenParsedPattern` (ITEM on each struct field), so the
}
                continue;
use std::fmt::{Debug, Formatter};
        match coord.evaluate().unwrap() {
            tokens_builder.keys().append_value(label);
/// row but as a typed Struct.
    }
    Ok(ScalarValue::List(Arc::new(array)))
        let entries = sorted_pattern_entries(stats);
    signature: Signature,
    }
//! The PPL Calcite visitor wraps this aggregate output in
            DataType::Struct(Fields::from(vec![
}
            "user 5 logged in",
    }
        }
        Field::new(
        let arg0_is_list = matches!(
        if let Some(strs) = arr
        let state_a = a.state().unwrap().pop().unwrap();
        let lists: &ListArray = arr.as_list();
            .collect()
            .exprs
        };
//! Distributed correctness: PARTIAL emits its accumulated string buffer as
            "alpha@beta.io".to_string(),
        }
            false,
        build_list_struct_scalar(&entries, self.config.show_numbered_token)
        let mut acc = InternalPatternAccumulator::new(false, AggConfig::defaults());
            other => panic!("expected List, got {other:?}"),
        }
        let scalars: Vec<ScalarValue> = self
        Ok(Box::new(InternalPatternAccumulator::new(
            for i in 0..strs.len() {
                ),
        //   trailing in sorted Argument order:
    }
            .buffer
}
    entries: &[PatternEntry],
        if let Some(expr) = acc_args.exprs.get(1) {
            arg0_type,
        ScalarValue::UInt8(Some(v)) => Ok(*v as usize),
}
}
            "hello@world.net".to_string(),
            o => panic!("expected list, got {o:?}"),
            "user 2 logged in",
}
        //   0 = field column
    }
        ]));
/*
    ))
        }
        let count_col = s
        let s_b: ArrayRef = match state_b {
        );
        let mut a = InternalPatternAccumulator::new(false, AggConfig::defaults());
        Arc::new(struct_array),
        for i in 0..lists.len() {
            AggConfig {
                    DataType::List(Arc::new(Field::new("item", DataType::Utf8, true))),
        }
                | ScalarValue::Decimal256(_, _, _) => {
            return Ok(());
    let mut count_builder = Int64Builder::with_capacity(n);
//!                tokens: Map<Utf8, List<Utf8>>,
        _ => exec_err!("{}: expected double literal, got {scalar:?}", NAME),
                | ScalarValue::UInt32(_)
            DataType::List(Arc::new(Field::new("item", DataType::Utf8, true))),
                        .map(|j| samples.value(j).to_string())
        offsets,
    DataType::List(Arc::new(Field::new("item", struct_element_type(), true)))
            .field("arg0_is_list", &self.arg0_is_list)
            ScalarValue::List(l) => l,
        // Optional tail: prefer parsing by Arrow type rather than position so
        ScalarValue::Float64(Some(v)) => Ok(*v),
        Field::new(FIELD_PATTERN_COUNT, DataType::Int64, true),
//! groups across shards because BRAIN's token-frequency histogram is global
//!
        Field::new(FIELD_PATTERN, DataType::Utf8, true),
fn build_list_struct_array(
        //   2 = buffer_limit     (int)   — currently ignored
    match scalar {
};
            let inner = lists.value(i);
                if !strs.is_null(i) {
    pub fn new() -> Self {
        ScalarValue::Int64(Some(v)) => Ok(*v as usize),
            (result.pattern, result.tokens)
use crate::patterns::brain::{BrainLogParser, PatternEntry};
        } else {
    fn merge_batch(&mut self, states: &[ArrayRef]) -> Result<()> {
    Array, ArrayRef, AsArray, Int64Builder, ListArray, ListBuilder, MapBuilder, MapFieldNames,
            return Ok(());
            for v in values {
                | ScalarValue::Float64(_)
            ScalarValue::List(l) => l,
    fn discovers_repeated_pattern_across_inputs() {
        let arg0_type = acc_args
        let mut b = InternalPatternAccumulator::new(false, AggConfig::defaults());
            }
    fn state(&mut self) -> Result<Vec<ScalarValue>> {
        let mut coord = InternalPatternAccumulator::new(false, AggConfig::defaults());
const FIELD_TOKENS: &str = "tokens";
        let top = &entries[0];
            .map(|i| {
                | ScalarValue::Int64(_)
        ScalarValue::Float32(Some(v)) => Ok(*v as f64),
                config.max_sample_count = scalar_to_usize(lit.value())?;
use datafusion::common::{exec_err, Result, ScalarValue};
use datafusion::arrow::buffer::OffsetBuffer;
                max_sample_count: 5,
                if !strs.is_null(i) {
}
        ScalarValue::Int32(Some(v)) => Ok(*v as usize),
}
                Field::new(
    }
                    config.variable_count_threshold = scalar_to_usize(lit.value())?;
            .append(true)
    use super::*;
    fn size(&self) -> usize {
                let inner = l.value(0);
/// arguments. The PPL layer always passes the four required positional args
impl Default for InternalPatternUdaf {
use std::hash::{Hash, Hasher};
        Arc::new(Field::new(
                let total: i64 = (0..s.len()).map(|i| count_col.value(i)).sum();
    }
 */
        if let Some(strs) = arr.as_any().downcast_ref::<StringArray>() {
        // Per-shard state is the raw collected log lines so the coordinator
/// (field, max_sample_count, buffer_limit, show_numbered_token); the optional
            logs.iter().map(|s| Some(s.to_string())).collect::<Vec<_>>(),
        };
) -> Result<ListArray> {
    fn hash<H: Hasher>(&self, state: &mut H) {
            "user 3 logged in",
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
/// Empty result — caller returns this when the accumulator never saw any non-null input.
//!   `List<Struct<pattern: Utf8, pattern_count: Int64,
            entry: "entries".to_string(),
            false,
    let item_field = Field::new("item", struct_element_type(), true);
                config.show_numbered_token = scalar_to_bool(lit.value())?;
            state_list_type(),
        ScalarValue::Int16(Some(v)) => Ok(*v as usize),
        // arg layout (positional):
            };
            .finish()
            .as_any()
                | ScalarValue::Int32(_)
            let result = eval_samples(&entry.pattern, &entry.sample_logs);
            if let Some(lit) = expr.downcast_ref::<Literal>() {
        Ok(list_struct_type())
//! sorted list of pattern groups.
            }
pub const NAME: &str = "internal_pattern";
            buffer: Vec::new(),
/// Builds a one-row `ListArray` whose single element is the per-pattern
    }
    Ok(StructArray::new(
fn scalar_to_usize(scalar: &ScalarValue) -> Result<usize> {
    }
    }
            .downcast_ref::<datafusion::arrow::array::LargeStringArray>()
    )
                    self.buffer.push(strs.value(i).to_string());
        }
            .map(|e| e.data_type(acc_args.schema))
            .field("len", &self.buffer.len())
/// `LogPatternAggFunction.value()`'s ordering.
            "expected 5 in top group, got {entries:?}"
                _ => continue,
impl InternalPatternUdaf {
                    .as_any()
        match out {
    #[test]
        ),
    show_numbered_token: bool,
            true,
use crate::patterns::eval::eval_samples;
    let array = build_list_struct_array(entries, show_numbered_token)?;
    fn defaults() -> Self {
#[derive(Debug, Clone)]
impl Hash for InternalPatternUdaf {
            .downcast_ref::<datafusion::arrow::array::StringViewArray>()
/// The complete return type of `internal_pattern`: List<Struct<…>>.
            }
            match lit.value() {
/// Tunable BRAIN parameters extracted from the aggregate call's literal
        None,
        // one group with count = number of repeats.
    let mut tokens_builder = MapBuilder::with_capacity(
            })
        if values.is_empty() {
                ScalarValue::Float32(_)
pub struct InternalPatternUdaf {
                assert_eq!(total, 5, "merge should preserve all 5 lines");
        ];
            .first()
        }
        self.append_list(&states[0])
        acc.update_batch(&[arr]).unwrap();
use crate::patterns::{DEFAULT_FREQUENCY_THRESHOLD_PERCENTAGE, DEFAULT_VARIABLE_COUNT_THRESHOLD};
fn scalar_to_f64(scalar: &ScalarValue) -> Result<f64> {
        _ => exec_err!("{}: expected boolean literal, got {scalar:?}", NAME),
/// stays raw (`<*>@<*>.<*>`).
        } else {
        NAME.hash(state);
        }
    fn append_list(&mut self, arr: &ArrayRef) -> Result<()> {
        }
                variable_count_threshold: DEFAULT_VARIABLE_COUNT_THRESHOLD,
use datafusion::logical_expr::function::{AccumulatorArgs, StateFieldsArgs};
) -> Result<ScalarValue> {
        ScalarValue::UInt32(Some(v)) => Ok(*v as usize),
}
}
fn build_list_struct_scalar(
mod tests {
            max_sample_count: 10,
impl Accumulator for InternalPatternAccumulator {
//!                sample_logs: List<Utf8>>>`
                }
use datafusion::logical_expr::{
            }
    #[test]
}
            self.append_strings(col)
                    .column(1)
//! `evaluate()` runs `BrainLogParser::parse_all_log_patterns` and emits the
        );
    }
        // wildcard pattern + this group's sample logs.
        let (pattern_str, tokens_map) = if show_numbered_token {
        let state_b = b.state().unwrap().pop().unwrap();
fn sorted_pattern_entries(stats: HashMap<String, PatternEntry>) -> Vec<PatternEntry> {
            .as_any()
    buffer: Vec<String>,
        {
//! parameter is accepted for parity with the Java signature but currently
impl AggregateUDFImpl for InternalPatternUdaf {
use std::collections::HashMap;
    use datafusion::arrow::array::AsArray;
fn state_list_type() -> DataType {
        ScalarValue::UInt64(Some(v)) => Ok(*v as usize),
                    pattern_count: count_col.value(i) as u64,
        false,
            datafusion::arrow::compute::concat(&[s_a.as_ref(), s_b.as_ref()]).unwrap();
            ScalarValue::List(l) => {
    }
            },
    }
        // variable_count_threshold second) doesn't lock us in.
    entries: &[PatternEntry],
            NAME,
    Fields::from(vec![
        struct_fields(),
            ScalarValue::List(l) => assert_eq!(l.value(0).len(), 0),
        if states.is_empty() {
        _ => exec_err!("{}: expected integer literal, got {scalar:?}", NAME),
        Ok(vec![self.current_state()])
    let offsets = OffsetBuffer::new(vec![0i32, entries.len() as i32].into());
/// Sort the BRAIN stats by descending pattern_count to match
        Self {
//! full corpus matches the Java single-pass behaviour. The `buffer_limit`
//! tuple shape after expansion is one row per pattern group with
            }
        for s in &entry.sample_logs {
        );
use std::sync::Arc;
fn scalar_to_bool(scalar: &ScalarValue) -> Result<bool> {
    DataType::Map(
    let tokens_array: ArrayRef = Arc::new(tokens_builder.finish());
    }
        sample_logs_builder.append(true);
    match scalar {
            self.config.threshold_percentage,
}
            .as_any()
    let array = build_list_struct_array(&[], false)?;
        tokens_builder
        let mut config = Self::defaults();
            for i in 0..strs.len() {
        let arr1: ArrayRef = Arc::new(StringArray::from(vec![
}
}
                    pattern: pattern_col.value(i).to_string(),
                continue;
#[derive(Debug)]
//! used by PPL's `patterns ... method=BRAIN` in aggregation mode.
                    self.buffer.push(strs.value(i).to_string());
        let config = AggConfig::from_args(&acc_args)?;
    let mut sample_logs_builder = ListBuilder::new(StringBuilder::new());
    }
            for i in 0..strs.len() {
}
    fn accumulator(&self, acc_args: AccumulatorArgs) -> Result<Box<dyn Accumulator>> {
        //   3 = show_numbered_token (bool)
//! Output Arrow shape:
    Ok(ScalarValue::List(Arc::new(array)))
const FIELD_PATTERN: &str = "pattern";
        let pattern_col = s.column(0).as_any().downcast_ref::<StringArray>().unwrap();
        let mut parser = BrainLogParser::with_thresholds(
                ))
                    NAME
        };
    }
 * this file be licensed under the Apache-2.0 license or a
//! Java path's `ImmutableMap.of(...)` rows.
impl Debug for InternalPatternAccumulator {
            ScalarValue::List(l) => l,
impl Eq for InternalPatternUdaf {}
 * The OpenSearch Contributors require contributions made to
    }
            variable_count_threshold: DEFAULT_VARIABLE_COUNT_THRESHOLD,
        Self {
            DataType::List(_) | DataType::LargeList(_) | DataType::FixedSizeList(_, _)
/// `ImmutableMap.of(PATTERN, ..., PATTERN_COUNT, ..., TOKENS, ..., SAMPLE_LOGS, ...)`
    Ok(ListArray::new(
        }
                    .unwrap();
            show_numbered_token: false,
    }
            "user 1 logged in",
//! `evaluate()` over the concatenated corpus. We do not pre-merge pattern
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
    let n = entries.len();
        let entries = run(&logs, false);
        std::mem::size_of_val(self) + self.buffer.iter().map(|s| s.capacity()).sum::<usize>()
}
use datafusion::arrow::array::{
        ))])
    fn update_batch(&mut self, values: &[ArrayRef]) -> Result<()> {
        Ok(())
    ctx.register_udaf(AggregateUDF::from(InternalPatternUdaf::new()));
        let s = inner.as_any().downcast_ref::<StructArray>().unwrap();
            sample_logs_builder.values().append_value(s);
}
            "unrelated noise",
    );
//!
        coord.merge_batch(&[combined]).unwrap();
        ));
        let combined: ArrayRef =
            signature: Signature::variadic_any(Volatility::Immutable),
                    .downcast_ref::<datafusion::arrow::array::Int64Array>()
        )))
    #[test]
            o => panic!("expected list, got {o:?}"),
            return Ok(());
                let count_col = s
        exec_err!(
fn empty_list_struct_scalar() -> Result<ScalarValue> {
                    "{}: missing first argument",
//! `(pattern, pattern_count, tokens, sample_logs)` columns — matching the
        ]));
        if self.arg0_is_list {
        let stats = parser.parse_all_log_patterns(&self.buffer, self.config.max_sample_count);
#[cfg(test)]
const FIELD_SAMPLE_LOGS: &str = "sample_logs";
    /// Java path's arrival-order behaviour.
    fn evaluate(&mut self) -> Result<ScalarValue> {
    }
            value: "value".to_string(),
use datafusion::physical_expr::expressions::Literal;
/// Build a single-row `List<Struct<…>>` scalar containing the per-pattern
        // can run the BRAIN parser once over the full corpus.
//!
        let sample_logs_col = s.column(3).as_list::<i32>();
    }
}
    show_numbered_token: bool,
//! un-nests received per-shard buffers in `merge_batch` and runs the parser at
        ScalarValue::Decimal128(Some(v), _, scale) => Ok(*v as f64 / 10f64.powi(*scale as i32)),
    fn eq(&self, _other: &Self) -> bool {
                }
        // the alphabetical PPL ordering (frequency_threshold_percentage first,
/// StructArray with `entries.len()` rows.
/// to numbered-token form (`<token1>@<token2>.<token3>`) and the tokens map
        }
        )
                show_numbered_token,
                threshold_percentage: DEFAULT_FREQUENCY_THRESHOLD_PERCENTAGE,
    pub fn new(arg0_is_list: bool, config: AggConfig) -> Self {
        (0..s.len())
}
        let inner = list.value(0);
        Some(MapFieldNames {
fn struct_element_type() -> DataType {
            }
use datafusion::arrow::datatypes::{DataType, Field, FieldRef, Fields};
        Arc::new(item_field),
        }
/// Arrow shape for one pattern-group element. Matches the Java path's
}
/// Per-shard state shape — `List<Utf8>` carrying the raw collected log lines.
            .collect();
            })?;
            self.append_strings(&inner)?;
            o => panic!("expected list, got {o:?}"),
    fn state_fields(&self, args: StateFieldsArgs) -> Result<Vec<FieldRef>> {
            top.pattern_count, 5,
                }
                    true,
            FIELD_SAMPLE_LOGS,
//! and pattern equality is corpus-dependent — running the parser once on the
    show_numbered_token: bool,
            "user 4 logged in",
        //   1 = max_sample_count (int)
 * compatible open source license.
        }),
        for expr in acc_args.exprs.iter().skip(4) {
    variable_count_threshold: usize,
        None,
            arr.data_type()
            .map_err(|e| datafusion::error::DataFusionError::ArrowError(Box::new(e), None))?;
            tokens_builder.values().append(true);
            .ok_or_else(|| {
}
    fn name(&self) -> &str {
                }
    entries.sort_by(|a, b| b.pattern_count.cmp(&a.pattern_count));
                    sample_logs: (0..samples.len())
        ListBuilder::new(StringBuilder::new()),
        //     frequency_threshold_percentage (double)
                }
/// trailing pair (threshold_percentage, variable_count_threshold) is sorted by
        }
            config,
            .map(|s| ScalarValue::Utf8(Some(s.clone())))
    }
        };
    fn run(logs: &[&str], show_numbered_token: bool) -> Vec<PatternEntry> {
                let s = inner.as_any().downcast_ref::<StructArray>().unwrap();
        b.update_batch(&[arr2]).unwrap();
        let list = match result {
            true,
}
        }
    }
pub fn register_all(ctx: &SessionContext) {
    DataType::Struct(struct_fields())
            return Ok(());
                datafusion::common::DataFusionError::Execution(format!(
/// groups. When `show_numbered_token` is true, the pattern string is rewritten
        true
        // the numbered pattern string and tokens map from the BRAIN-derived
            key: "key".to_string(),
    for entry in entries {
        let s_a: ArrayRef = match state_a {
}
    /// Collected raw log lines — order-preserving so sample_logs match the
        let out = acc.evaluate().unwrap();
    }
            .column(1)
    let mut entries: Vec<PatternEntry> = stats.into_values().collect();
                | ScalarValue::UInt64(_) => {
 * SPDX-License-Identifier: Apache-2.0
        NAME
        //     variable_count_threshold       (int)
    fn returns_empty_list_when_no_logs_seen() {
        for (label, values) in tokens_map.iter() {
    threshold_percentage: f64,
                    "value",
        &self.signature
            format!("{}[buf]", args.name),
    config: AggConfig,
            .unwrap();
            let value_builder = tokens_builder.values().values();
    fn from_args(acc_args: &AccumulatorArgs) -> Result<Self> {
        }
    }
            self.append_list(col)
 *
    fn signature(&self) -> &Signature {
        Ok(vec![Arc::new(Field::new(
        let result = acc.evaluate().unwrap();
impl InternalPatternAccumulator {
fn list_struct_type() -> DataType {
        }
const FIELD_PATTERN_COUNT: &str = "pattern_count";
        a.update_batch(&[arr1]).unwrap();
};
//! `List<Utf8>` state via `state()`; the coordinator's FINAL accumulator
        if let Some(strs) = arr
                    self.buffer.push(strs.value(i).to_string());
            ])),
                let samples = sample_inner.as_any().downcast_ref::<StringArray>().unwrap();
            "entries",
        );
    }
        Self::new()
        Field::new(FIELD_TOKENS, tokens_map_type(), true),
        }
    }
        ScalarValue::Int8(Some(v)) => Ok(*v as usize),
    ))
            .downcast_ref::<datafusion::arrow::array::Int64Array>()
    max_sample_count: usize,
            if let Some(lit) = expr.downcast_ref::<Literal>() {
        Self {
        count_builder.append_value(entry.pattern_count as i64);
            threshold_percentage: DEFAULT_FREQUENCY_THRESHOLD_PERCENTAGE,
//!
        let mut acc = InternalPatternAccumulator::new(
            .transpose()?
}
            (entry.pattern.clone(), HashMap::new())
    fn default() -> Self {
                Field::new("key", DataType::Utf8, false),
    Accumulator, AggregateUDF, AggregateUDFImpl, Signature, Volatility,
/// argument name and appended only when set.
        ScalarValue::Boolean(Some(v)) => Ok(*v),
            arg0_is_list,
    fn current_state(&self) -> ScalarValue {
                | ScalarValue::UInt8(_)
            arg0_is_list,
        // Stitch the two per-shard list states into one ListArray and feed to FINAL.
}
    }
        pattern_builder.append_value(&pattern_str);
        let logs = [
        let arr2: ArrayRef = Arc::new(StringArray::from(vec![
        f.debug_struct("InternalPatternAccumulator")
        if let Some(expr) = acc_args.exprs.get(3) {
pub struct InternalPatternAccumulator {
        Ok(config)
        )),
                }
            "foo@bar.com".to_string(),
    let count_array: ArrayRef = Arc::new(count_builder.finish());
    DataType::List(Arc::new(Field::new("item", DataType::Utf8, true)))
        n,
                | ScalarValue::Int16(_)
            if lists.is_null(i) {
//! SQL plugin side. Collects all source-field strings per group, then on
use datafusion::execution::context::SessionContext;
        {
                value_builder.append_value(v);
//! `internal_pattern(field, max_sample_count, buffer_limit, show_numbered_token,
            }
            "ck@example.dev".to_string(),
        }
            return Ok(());
    ])
                PatternEntry {
            }
            // FINAL form: arg 0 is List<Utf8> carrying each shard's PARTIAL state.
                        .collect(),
        let arr: ArrayRef = Arc::new(StringArray::from(
    entries
                | ScalarValue::Decimal128(_, _, _)
        let col = &values[0];
    match scalar {
        ScalarValue::List(ScalarValue::new_list_nullable(&scalars, &DataType::Utf8))
        assert_eq!(
    StringArray, StringBuilder, StructArray,
            config,
//!  [threshold_percentage], [variable_count_threshold])` — BRAIN aggregate UDF
fn struct_fields() -> Fields {
/// captures the extracted variables; otherwise tokens is empty and pattern
                ScalarValue::Int8(_)
    let pattern_array: ArrayRef = Arc::new(pattern_builder.finish());
            .iter()
