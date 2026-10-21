    match scalar {
        Some(MapFieldNames {
use datafusion::arrow::array::{
                show_numbered_token,
                max_sample_count: 5,
}
    DataType::List(Arc::new(Field::new("item", struct_element_type(), true)))
pub const NAME: &str = "internal_pattern";
}
        //   3 = show_numbered_token (bool)
            true,
            variable_count_threshold: DEFAULT_VARIABLE_COUNT_THRESHOLD,
    match scalar {
        )),
        // arg layout (positional):
                let s = inner.as_any().downcast_ref::<StructArray>().unwrap();
        Field::new(
                    config.threshold_percentage = scalar_to_f64(lit.value())?;
                ))
    show_numbered_token: bool,
    fn append_list(&mut self, arr: &ArrayRef) -> Result<()> {
        for (label, values) in tokens_map.iter() {
) -> Result<ListArray> {
            o => panic!("expected list, got {o:?}"),
        let s_a: ArrayRef = match state_a {
            },
        StringBuilder::new(),
        let stats = parser.parse_all_log_patterns(&self.buffer, self.config.max_sample_count);
            .iter()
        // one group with count = number of repeats.
            for i in 0..strs.len() {
            threshold_percentage: DEFAULT_FREQUENCY_THRESHOLD_PERCENTAGE,
fn struct_element_type() -> DataType {
            "user 5 logged in",
fn build_list_struct_scalar(
            let Some(lit) = expr.downcast_ref::<Literal>() else {
    variable_count_threshold: usize,
}
        acc.update_batch(&[arr]).unwrap();
            .as_any()
        if self.buffer.is_empty() {
        let arr: ArrayRef = Arc::new(StringArray::from(
        let inner = list.value(0);
            .unwrap();
    fn from_args(acc_args: &AccumulatorArgs) -> Result<Self> {
    show_numbered_token: bool,
        let mut coord = InternalPatternAccumulator::new(false, AggConfig::defaults());
fn tokens_map_type() -> DataType {
            max_sample_count: 10,
impl AggregateUDFImpl for InternalPatternUdaf {
use crate::patterns::eval::eval_samples;
            .field("arg0_is_list", &self.arg0_is_list)
        ScalarValue::Int64(Some(v)) => Ok(*v as usize),
        let result = acc.evaluate().unwrap();
        //   0 = field column
                Field::new(
    fn run(logs: &[&str], show_numbered_token: bool) -> Vec<PatternEntry> {
        //     variable_count_threshold       (int)
            "alpha@beta.io".to_string(),
        if let Some(strs) = arr
}
            tokens_builder.keys().append_value(label);
/// StructArray with `entries.len()` rows.
                ScalarValue::Float32(_)
        ScalarValue::UInt16(Some(v)) => Ok(*v as usize),
}
            config,
            .buffer
                    .downcast_ref::<datafusion::arrow::array::Int64Array>()
    let offsets = OffsetBuffer::new(vec![0i32, entries.len() as i32].into());
    let struct_array = build_struct_array(entries, show_numbered_token)?;
//! `internal_pattern(field, max_sample_count, buffer_limit, show_numbered_token,
    }
) -> Result<ScalarValue> {
            .downcast_ref::<datafusion::arrow::array::StringViewArray>()
                if !strs.is_null(i) {
    }
    }
            self.config.variable_count_threshold,
                    pattern_count: count_col.value(i) as u64,
        Field::new(FIELD_TOKENS, tokens_map_type(), true),
        Ok(vec![Arc::new(Field::new(
        }
use std::hash::{Hash, Hasher};
        ));
        a.update_batch(&[arr1]).unwrap();
        ]));
    use datafusion::arrow::array::AsArray;
            true,
use std::collections::HashMap;
                }
            format!("{}[buf]", args.name),
        if let Some(strs) = arr
/// Builds a one-row `ListArray` whose single element is the per-pattern
            .first()
}
    }
        let pattern_col = s.column(0).as_any().downcast_ref::<StringArray>().unwrap();
    fn state(&mut self) -> Result<Vec<ScalarValue>> {
        for i in 0..lists.len() {
fn scalar_to_bool(scalar: &ScalarValue) -> Result<bool> {
//! used by PPL's `patterns ... method=BRAIN` in aggregation mode.
            return Ok(());
        );
        // variable_count_threshold second) doesn't lock us in.
    let tokens_array: ArrayRef = Arc::new(tokens_builder.finish());
    Ok(ScalarValue::List(Arc::new(array)))
                if !strs.is_null(i) {
            self.config.threshold_percentage,
        }
        //   2 = buffer_limit     (int)   — currently ignored
    let sample_logs_array: ArrayRef = Arc::new(sample_logs_builder.finish());
                        .collect(),
//! groups across shards because BRAIN's token-frequency histogram is global
use crate::patterns::{DEFAULT_FREQUENCY_THRESHOLD_PERCENTAGE, DEFAULT_VARIABLE_COUNT_THRESHOLD};
        }
                        .map(|j| samples.value(j).to_string())
}
//! SQL plugin side. Collects all source-field strings per group, then on
        let logs = [
            state_list_type(),
        }
            ScalarValue::List(l) => assert_eq!(l.value(0).len(), 0),
//! `List<Utf8>` state via `state()`; the coordinator's FINAL accumulator
/// trailing pair (threshold_percentage, variable_count_threshold) is sorted by
    }
use datafusion::logical_expr::{
        }
                PatternEntry {
        }
        ScalarValue::UInt64(Some(v)) => Ok(*v as usize),
            config,
}
        Ok(())
        &self.signature
        ]));
            })?;
//!  [threshold_percentage], [variable_count_threshold])` — BRAIN aggregate UDF
    }
                }
#[derive(Debug, Clone)]
        // wildcard pattern + this group's sample logs.
                }
}
        Self {
                let sample_inner = sample_logs_col.value(i);
        }
        for s in &entry.sample_logs {
};
        {
            }
        Self {
}
                let total: i64 = (0..s.len()).map(|i| count_col.value(i)).sum();
    entries: &[PatternEntry],
            "entries",
    fn name(&self) -> &str {
            arr.data_type()
        if values.is_empty() {
//! un-nests received per-shard buffers in `merge_batch` and runs the parser at
//! Java path's `ImmutableMap.of(...)` rows.
        if let Some(strs) = arr.as_any().downcast_ref::<StringArray>() {
            value: "value".to_string(),
            .map(|e| e.data_type(acc_args.schema))
//!                sample_logs: List<Utf8>>>`
                ),
        ScalarValue::List(ScalarValue::new_list_nullable(&scalars, &DataType::Utf8))
                    true,
        // When show_numbered_token is true, re-run eval_samples to produce
            return Ok(());
        }
    }
/// argument name and appended only when set.
        ListBuilder::new(StringBuilder::new()),
}
    }
        let entries = run(&logs, false);
}
            .map(|s| ScalarValue::Utf8(Some(s.clone())))
            }
        exec_err!(
/// `ImmutableMap.of(PATTERN, ..., PATTERN_COUNT, ..., TOKENS, ..., SAMPLE_LOGS, ...)`
 *
use datafusion::arrow::datatypes::{DataType, Field, FieldRef, Fields};
                let samples = sample_inner.as_any().downcast_ref::<StringArray>().unwrap();
        Ok(Box::new(InternalPatternAccumulator::new(
            .exprs
        let scalars: Vec<ScalarValue> = self
        }
    threshold_percentage: f64,
}
//!
            }
use datafusion::common::{exec_err, Result, ScalarValue};
                    self.buffer.push(strs.value(i).to_string());
        let mut config = Self::defaults();
            arg0_type,
            (entry.pattern.clone(), HashMap::new())
            self.append_strings(&inner)?;
    }
            self.append_strings(col)
        )))
                config.max_sample_count = scalar_to_usize(lit.value())?;
                    config.variable_count_threshold = scalar_to_usize(lit.value())?;
    /// Collected raw log lines — order-preserving so sample_logs match the
    fn signature(&self) -> &Signature {
        let (pattern_str, tokens_map) = if show_numbered_token {
            if lists.is_null(i) {
    let item_field = Field::new("item", struct_element_type(), true);
        let arg0_type = acc_args
            false,
    buffer: Vec<String>,
                variable_count_threshold: DEFAULT_VARIABLE_COUNT_THRESHOLD,
//! `Uncollect` → `flattenParsedPattern` (ITEM on each struct field), so the
        let out = acc.evaluate().unwrap();
        Self::new()
    fn defaults() -> Self {
fn sorted_pattern_entries(stats: HashMap<String, PatternEntry>) -> Vec<PatternEntry> {
        )
//!
}
//! and pattern equality is corpus-dependent — running the parser once on the
 */
        };
    arg0_is_list: bool,
        let s_b: ArrayRef = match state_b {
            tokens_builder.values().append(true);
                Field::new("key", DataType::Utf8, false),
    let mut entries: Vec<PatternEntry> = stats.into_values().collect();
    match scalar {
        let lists: &ListArray = arr.as_list();
            let inner = lists.value(i);
    )
        ScalarValue::Float64(Some(v)) => Ok(*v),
                | ScalarValue::Float64(_)
    fn merge_batch(&mut self, states: &[ArrayRef]) -> Result<()> {
    let mut sample_logs_builder = ListBuilder::new(StringBuilder::new());
}
    fn evaluate(&mut self) -> Result<ScalarValue> {
                }
    Ok(ScalarValue::List(Arc::new(array)))
                    DataType::List(Arc::new(Field::new("item", DataType::Utf8, true))),
    DataType::Struct(struct_fields())
                | ScalarValue::UInt32(_)
            other => panic!("expected List, got {other:?}"),
                if !strs.is_null(i) {
    }
/// to numbered-token form (`<token1>@<token2>.<token3>`) and the tokens map
        sample_logs_builder.append(true);
#[cfg(test)]
            FIELD_SAMPLE_LOGS,
                _ => continue,
            }
    signature: Signature,
            .collect();
        std::mem::size_of_val(self) + self.buffer.iter().map(|s| s.capacity()).sum::<usize>()
        if let Some(expr) = acc_args.exprs.get(3) {
            .transpose()?
            .column(1)
    }
use datafusion::arrow::buffer::OffsetBuffer;
            .downcast_ref::<datafusion::arrow::array::LargeStringArray>()
fn scalar_to_f64(scalar: &ScalarValue) -> Result<f64> {
            "user 2 logged in",
            ScalarValue::List(l) => l,
                    "value",
    /// Java path's arrival-order behaviour.
        match coord.evaluate().unwrap() {
    }
/// Empty result — caller returns this when the accumulator never saw any non-null input.
            "unrelated noise",
}
    fn discovers_repeated_pattern_across_inputs() {
            "foo@bar.com".to_string(),
            for i in 0..strs.len() {
            "user 4 logged in",
}
    fn eq(&self, _other: &Self) -> bool {
            DataType::List(Arc::new(Field::new("item", DataType::Utf8, true))),
            "ck@example.dev".to_string(),
    }
        pattern_builder.append_value(&pattern_str);
impl AggConfig {
            ScalarValue::List(l) => l,
    StringArray, StringBuilder, StructArray,
        // Stitch the two per-shard list states into one ListArray and feed to FINAL.
            "baz@qux.org".to_string(),
//!
        if let Some(expr) = acc_args.exprs.get(1) {
        }
impl Default for InternalPatternUdaf {
            match lit.value() {
    entries: &[PatternEntry],
            .as_any()
fn scalar_to_usize(scalar: &ScalarValue) -> Result<usize> {
        _ => exec_err!("{}: expected integer literal, got {scalar:?}", NAME),
    let array = build_list_struct_array(entries, show_numbered_token)?;
impl PartialEq for InternalPatternUdaf {
            entry: "entries".to_string(),
        true
            }
pub struct InternalPatternUdaf {
        Field::new(FIELD_PATTERN, DataType::Utf8, true),
            "user 3 logged in",
//! parameter is accepted for parity with the Java signature but currently
        let sample_logs_col = s.column(3).as_list::<i32>();
/// groups. When `show_numbered_token` is true, the pattern string is rewritten
        coord.merge_batch(&[combined]).unwrap();
                    .column(1)
        Ok(config)
            if let Some(lit) = expr.downcast_ref::<Literal>() {
        ScalarValue::Int8(Some(v)) => Ok(*v as usize),
        ScalarValue::UInt8(Some(v)) => Ok(*v as usize),
        {
            o => panic!("expected list, got {o:?}"),
        let state_b = b.state().unwrap().pop().unwrap();
        Arc::new(item_field),
    ctx.register_udaf(AggregateUDF::from(InternalPatternUdaf::new()));
        ScalarValue::Int16(Some(v)) => Ok(*v as usize),
        Field::new(FIELD_PATTERN_COUNT, DataType::Int64, true),
            }
            .map_err(|e| datafusion::error::DataFusionError::ArrowError(Box::new(e), None))?;
 * this file be licensed under the Apache-2.0 license or a
                assert_eq!(total, 5, "merge should preserve all 5 lines");
    entries.sort_by(|a, b| b.pattern_count.cmp(&a.pattern_count));
    Accumulator, AggregateUDF, AggregateUDFImpl, Signature, Volatility,
        NAME
const FIELD_PATTERN_COUNT: &str = "pattern_count";
        _ => exec_err!("{}: expected boolean literal, got {scalar:?}", NAME),
            ScalarValue::List(l) => l,
use std::fmt::{Debug, Formatter};
            (result.pattern, result.tokens)
        }
    use super::*;
            buffer: Vec::new(),
        let count_col = s
        let mut b = InternalPatternAccumulator::new(false, AggConfig::defaults());
        } else {
/*
//! Mirrors `org.opensearch.sql.calcite.udf.udaf.LogPatternAggFunction` on the
                | ScalarValue::Int16(_)
        Self {
        }
}
        );
        None,
            ScalarValue::List(l) => {
            top.pattern_count, 5,
    }
            datafusion::arrow::compute::concat(&[s_a.as_ref(), s_b.as_ref()]).unwrap();
        f.debug_struct("InternalPatternAccumulator")
//! `evaluate()` over the concatenated corpus. We do not pre-merge pattern
/// captures the extracted variables; otherwise tokens is empty and pattern
        if self.arg0_is_list {
    Ok(ListArray::new(
    fn hash<H: Hasher>(&self, state: &mut H) {
impl Debug for InternalPatternAccumulator {
}
use datafusion::physical_expr::expressions::Literal;
fn state_list_type() -> DataType {
//! tuple shape after expansion is one row per pattern group with
pub fn register_all(ctx: &SessionContext) {
    fn size(&self) -> usize {
            AggConfig {
    pub fn new(arg0_is_list: bool, config: AggConfig) -> Self {
            "user 1 logged in",
    fn merge_batch_concatenates_partial_states() {
                }
            for i in 0..strs.len() {
//! Distributed correctness: PARTIAL emits its accumulated string buffer as
//!
            NAME,
        }),
        ScalarValue::Float32(Some(v)) => Ok(*v as f64),
}
            return Ok(());
        for expr in acc_args.exprs.iter().skip(4) {
        };
    }
        ScalarValue::Decimal128(Some(v), _, scale) => Ok(*v as f64 / 10f64.powi(*scale as i32)),
impl Accumulator for InternalPatternAccumulator {
        Arc::new(struct_array),
use crate::patterns::brain::{BrainLogParser, PatternEntry};
const FIELD_SAMPLE_LOGS: &str = "sample_logs";
            return Ok(());
fn build_list_struct_array(
            key: "key".to_string(),
                | ScalarValue::Int32(_)
use datafusion::execution::context::SessionContext;
use std::sync::Arc;
}
                value_builder.append_value(v);
    }
        Ok(vec![self.current_state()])
    }
//! `(pattern, pattern_count, tokens, sample_logs)` columns — matching the
        let top = &entries[0];
    ))
        let config = AggConfig::from_args(&acc_args)?;
            "expected 5 in top group, got {entries:?}"
    fn current_state(&self) -> ScalarValue {
        ScalarValue::UInt32(Some(v)) => Ok(*v as usize),
        None,
        if states.is_empty() {
    pub fn new() -> Self {
                | ScalarValue::UInt64(_) => {
        tokens_builder
        let s = inner.as_any().downcast_ref::<StructArray>().unwrap();
        ),
        ScalarValue::Boolean(Some(v)) => Ok(*v),
                | ScalarValue::Decimal256(_, _, _) => {
        // Per-shard state is the raw collected log lines so the coordinator
 * compatible open source license.
//! full corpus matches the Java single-pass behaviour. The `buffer_limit`
        let mut parser = BrainLogParser::with_thresholds(
    }
            if let Some(lit) = expr.downcast_ref::<Literal>() {
                }
    }
            .collect()
            self.append_list(col)
            return Ok(());
        let mut a = InternalPatternAccumulator::new(false, AggConfig::defaults());
use datafusion::logical_expr::function::{AccumulatorArgs, StateFieldsArgs};
                    self.buffer.push(strs.value(i).to_string());
    #[test]
        //   1 = max_sample_count (int)
struct AggConfig {
pub struct InternalPatternAccumulator {
    }
    Array, ArrayRef, AsArray, Int64Builder, ListArray, ListBuilder, MapBuilder, MapFieldNames,
            .map(|i| {
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
        n,
            // FINAL form: arg 0 is List<Utf8> carrying each shard's PARTIAL state.
                    "{}: missing first argument",
    let count_array: ArrayRef = Arc::new(count_builder.finish());
                    .unwrap();
mod tests {
            "{}: expected string column, got {:?}",
                let count_col = s
//!   `List<Struct<pattern: Utf8, pattern_count: Int64,
/// Arrow shape for one pattern-group element. Matches the Java path's
                | ScalarValue::UInt8(_)
            for v in values {
            logs.iter().map(|s| Some(s.to_string())).collect::<Vec<_>>(),
    Fields::from(vec![
        Ok(list_struct_type())
const FIELD_PATTERN: &str = "pattern";
}
        count_builder.append_value(entry.pattern_count as i64);
    let mut count_builder = Int64Builder::with_capacity(n);
    entries
        (0..s.len())
        }
        }
        } else {
        let arr1: ArrayRef = Arc::new(StringArray::from(vec![
            false,
    fn append_strings(&mut self, arr: &ArrayRef) -> Result<()> {
    for entry in entries {
        let entries = sorted_pattern_entries(stats);
            }
        self.append_list(&states[0])
        NAME.hash(state);
        }
        );
    }
    ])
            other => panic!("expected List, got {other:?}"),
                    .as_any()
/// Sort the BRAIN stats by descending pattern_count to match
            })
/// Build a single-row `List<Struct<…>>` scalar containing the per-pattern
        let col = &values[0];
    let mut pattern_builder = StringBuilder::with_capacity(n, n * 64);
}
            .downcast_ref::<datafusion::arrow::array::Int64Array>()
        // the alphabetical PPL ordering (frequency_threshold_percentage first,
/// (field, max_sample_count, buffer_limit, show_numbered_token); the optional
                    self.buffer.push(strs.value(i).to_string());
        let arr2: ArrayRef = Arc::new(StringArray::from(vec![
            .ok_or_else(|| {
    }
    }
        offsets,
/// The complete return type of `internal_pattern`: List<Struct<…>>.
    }
    }
}
impl InternalPatternAccumulator {
        let list = match result {
//! `evaluate()` runs `BrainLogParser::parse_all_log_patterns` and emits the
    fn returns_empty_list_when_no_logs_seen() {
            .append(true)
    let mut tokens_builder = MapBuilder::with_capacity(
    #[test]
    ))
/// Per-shard state shape — `List<Utf8>` carrying the raw collected log lines.
 * The OpenSearch Contributors require contributions made to
    }
            }
            }
        // Same shape repeated several times — BRAIN should merge them into
    fn default() -> Self {
        let arg0_is_list = matches!(
        assert_eq!(
        };
            .finish()
        false,
/// row but as a typed Struct.
                    pattern: pattern_col.value(i).to_string(),
            let value_builder = tokens_builder.values().values();
        match out {
        vec![pattern_array, count_array, tokens_array, sample_logs_array],
        // Optional tail: prefer parsing by Arrow type rather than position so
//!                tokens: Map<Utf8, List<Utf8>>,
                | ScalarValue::Decimal128(_, _, _)
fn list_struct_type() -> DataType {
    fn state_fields(&self, args: StateFieldsArgs) -> Result<Vec<FieldRef>> {
}
impl Eq for InternalPatternUdaf {}
        // can run the BRAIN parser once over the full corpus.
                let inner = l.value(0);
        let combined: ArrayRef =
    }
impl Hash for InternalPatternUdaf {
            .field("len", &self.buffer.len())
                threshold_percentage: DEFAULT_FREQUENCY_THRESHOLD_PERCENTAGE,
            "hello@world.net".to_string(),
        _ => exec_err!("{}: expected double literal, got {scalar:?}", NAME),
        );
                continue;
    let n = entries.len();
    let array = build_list_struct_array(&[], false)?;
            arg0_is_list,
                continue;
            };
    let pattern_array: ArrayRef = Arc::new(pattern_builder.finish());
            ])),
                    NAME
        }
#[derive(Debug)]
 * SPDX-License-Identifier: Apache-2.0
    }
//! ignored (no partial pre-aggregation).
fn build_struct_array(entries: &[PatternEntry], show_numbered_token: bool) -> Result<StructArray> {
//! sorted list of pattern groups.
impl InternalPatternUdaf {
                    sample_logs: (0..samples.len())
            arg0_is_list,
        ScalarValue::Int32(Some(v)) => Ok(*v as usize),
    }
        Arc::new(Field::new(
    DataType::List(Arc::new(Field::new("item", DataType::Utf8, true)))
//! Output Arrow shape:
        // the numbered pattern string and tokens map from the BRAIN-derived
//! The PPL Calcite visitor wraps this aggregate output in
/// arguments. The PPL layer always passes the four required positional args
        };
}
    );
    max_sample_count: usize,
                datafusion::common::DataFusionError::Execution(format!(
            let result = eval_samples(&entry.pattern, &entry.sample_logs);
fn empty_list_struct_scalar() -> Result<ScalarValue> {
        build_list_struct_scalar(&entries, self.config.show_numbered_token)
            sample_logs_builder.values().append_value(s);
            DataType::Struct(Fields::from(vec![
/// `LogPatternAggFunction.value()`'s ordering.
                | ScalarValue::Int64(_)
        }
            return Ok(empty_list_struct_scalar()?);
    fn accumulator(&self, acc_args: AccumulatorArgs) -> Result<Box<dyn Accumulator>> {
                ScalarValue::Int8(_)
    config: AggConfig,
    show_numbered_token: bool,
    fn update_batch(&mut self, values: &[ArrayRef]) -> Result<()> {
}
};
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        let mut acc = InternalPatternAccumulator::new(
    DataType::Map(
        let state_a = a.state().unwrap().pop().unwrap();
const FIELD_TOKENS: &str = "tokens";
        ))])
            .as_any()
/// Tunable BRAIN parameters extracted from the aggregate call's literal
        b.update_batch(&[arr2]).unwrap();
            o => panic!("expected list, got {o:?}"),
                config.show_numbered_token = scalar_to_bool(lit.value())?;
        }
        ];
                | ScalarValue::UInt16(_)
        let mut acc = InternalPatternAccumulator::new(false, AggConfig::defaults());
fn struct_fields() -> Fields {
            signature: Signature::variadic_any(Volatility::Immutable),
    #[test]
/// stays raw (`<*>@<*>.<*>`).
        //     frequency_threshold_percentage (double)
    Ok(StructArray::new(
        //   trailing in sorted Argument order:
        struct_fields(),
            DataType::List(_) | DataType::LargeList(_) | DataType::FixedSizeList(_, _)
            show_numbered_token: false,
