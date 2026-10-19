impl ScalarUDFImpl for PatternParserUdf {
    signature: Signature,
    }
/// Used by {@link PatternParserGetFieldUdf} to expose two single-field
            ColumnarValue::Array(arr) => arr,
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        assert_eq!(fields.len(), 2);
            pattern_builder.append_value(&r.pattern);
/// consumer's "Direct reference StructField with child" limitation on
        array: arr.as_ref(),
    }
}
                        "{} arg 1: List element must be string, got {:?}",
    )));
        n,
            PatternField::Pattern => 0,
    Tokens,
use crate::udf::udf_identity;
    }
                let results: Vec<PatternResult> = (0..n)
                    self.field.udf_name(),
}
        match args.args[1].data_type() {
        let tokens_col = s.column(1);
        let column_index = match self.field {
            Utf8Kind::Std => Some(
        }
const FIELD_TOKENS: &str = "tokens";
            ),
 * compatible open source license.
#[cfg(test)]
        if arg_types.len() != 2 {
                }
#[derive(Debug)]
}
            let value_builder = map_builder.values().values();
                                    Some(inner_strings.value(j).to_string())
//! implemented here yet — its operand types route through the AggregateUDF /
    array: &'a dyn Array,
mod tests {
                );
//! named struct-field access. The downstream `flattenParsedPattern` step in
                let list = field_arr
                    "value",
    };
/// nested struct field access.
impl Eq for PatternParserGetFieldUdf {}
        assert_eq!(fields[0].name(), "pattern");
fn struct_data_type() -> DataType {
            })?;
    let struct_fields = Fields::from(vec![
        other => {
        NAME
                Ok(ColumnarValue::Array(build_struct_array(&results)?))
}
                    other
                NAME,
//!     substrings.
        )),
            .map_err(|e| datafusion::error::DataFusionError::ArrowError(Box::new(e), None))?;
            entry: "entries".to_string(),
 */
        Arc::new(Field::new(
pub struct PatternParserUdf {
        let s = arr.as_any().downcast_ref::<StructArray>().unwrap();
        let second = match &arg_types[1] {
    Array, ArrayRef, GenericListArray, ListArray, ListBuilder, MapBuilder, MapFieldNames,
                            NAME
//! Return type is a Struct with two fields:
        let s = struct_array
            PatternField::Tokens => "pattern_parser_get_tokens",
/*
impl ScalarUDFImpl for PatternParserGetFieldUdf {
            PatternField::Pattern => "pattern_parser_get_pattern",
}
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
    })
            Utf8Kind::View => Some(
        }
                    "{} expected StructArray from base pattern_parser",
                        NAME,
        }
 *
                ))
            return None;
    }
        // Same operand shape as PatternParserUdf — delegate.
        self.field.udf_name()
                arg_types.len()
use std::sync::Arc;
impl PatternField {
            map_builder.values().append(true);
        let pattern_arr = args.args[0].clone().into_array(n)?;
}
    fn signature(&self) -> &Signature {
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
            field,
                other
}
        self.field.udf_name().hash(state);
    fn return_type(&self) -> DataType {
        }
        let arr = build_struct_array(&results).unwrap();
                "{} expects 2 arguments at invoke time, got {}",
                    DataType::List(Arc::new(Field::new("item", DataType::Utf8, true)))
                        other
//! `evalSamples` when the second operand is a `List<String>`). The Java side
        if self.array.is_null(i) {
 * SPDX-License-Identifier: Apache-2.0
        }
    Pattern,
            PatternField::Pattern => DataType::Utf8,
                                    None
                        };
            DataType::List(inner) | DataType::LargeList(inner) => match inner.data_type() {
    #[test]
        for (label, values) in r.tokens.iter() {
        assert_eq!(fields[0].data_type(), &DataType::Utf8);
            .ok_or_else(|| {
        &self.signature
                args.args.len()
            // invoke_with_args time based on actual Arrow shape.
            );
                    .as_any()
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
use crate::patterns::{eval_field, eval_samples, PatternResult};
//! Calcite's `ITEM(struct, "pattern")` with a constant string key resolves to
}
/// returns only one of the two output fields as a scalar value, sidestepping
        match self {
    )
        match self.kind {
                NAME,
    }
    for r in results {
        let dt = struct_data_type();
        assert_eq!(fields[1].name(), "tokens");
                return plan_err!(
                    .ok_or_else(|| {
        // insertion order, and HashMap<>'s iteration is unspecified —
/// `Option<&str>` getter. Mirrors a private helper used elsewhere in the udf
            }
            ),
                    .downcast_ref::<datafusion::arrow::array::StringViewArray>()?
        }
                    .collect();
                        if list.is_null(i) {
    kind: Utf8Kind,
        PatternField::Tokens,
    use datafusion::arrow::array::{Array, AsArray, BooleanArray};
/// Arrow shape for the result struct. Two fixed fields: `pattern` (Utf8) and
                    .value(i),
    }
        match self {
        self.field == other.field
                );
            other => {
        // extract the requested field column from the resulting struct array.
    signature: Signature,
    pub fn new(field: PatternField) -> Self {
    )));
//!     `"<token1>@<token2>.<token3>"`).
        Self {
        // Map keys are token labels in insertion order; values are the
    ctx.register_udf(ScalarUDF::from(PatternParserUdf::new()));
            .append(true)
            other => plan_err!(
                        ))
use datafusion::common::{plan_err, ScalarValue};
                Field::new("key", DataType::Utf8, false),
use datafusion::logical_expr::{
    ctx.register_udf(ScalarUDF::from(PatternParserGetFieldUdf::new(
    }
/// scalar UDFs ({@code pattern_parser_get_pattern},
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
};
            ),
//!   * `tokens` — Map<VARCHAR, List<VARCHAR>> — labeled lists of extracted
            );
}
        };
    }
    }
                                }
        if r.pattern.is_empty() {
            key: "key".to_string(),
    let pattern_array: ArrayRef = Arc::new(pattern_builder.finish());
        }
/// Which field of the pattern-parser result to return as a scalar value.
                let field_arr = args.args[1].clone().into_array(n)?;
        other => plan_err!("{} arg {}: expected string, got {:?}", udf, slot, other),
                    .downcast_ref::<datafusion::arrow::array::StringArray>()?
                other => {
        Field::new(FIELD_PATTERN, DataType::Utf8, true),
                DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => {
//! Mirrors `PatternParserFunctionImpl.evalField` (and dispatches to
        Some(MapFieldNames {
                                if inner_strings.is_null(j) {
        };
udf_identity!(PatternParserUdf, "pattern_parser");
//!   * `pattern` — VARCHAR — the numbered-token rewrite (e.g.
    Ok(Arc::new(struct_array) as ArrayRef)
use datafusion::execution::context::SessionContext;
    ctx.register_udf(ScalarUDF::from(PatternParserGetFieldUdf::new(
    StringArray, StringBuilder, StructArray,
};
impl PartialEq for PatternParserGetFieldUdf {
    fn signature(&self) -> &Signature {
        kind,
                return plan_err!(
        // so any iteration order is acceptable here.
}
            DataType::List(_) | DataType::LargeList(_) => {
        Field::new(FIELD_PATTERN, DataType::Utf8, true),
        Ok(self.field.return_type())
    let struct_array = StructArray::new(struct_fields, vec![pattern_array, tokens_array], None);
                    .downcast_ref::<datafusion::arrow::array::LargeStringArray>()?
            .downcast_ref::<StructArray>()
            ),
/// Field names used in the returned Arrow struct.
    fn eq(&self, other: &Self) -> bool {
    let tokens_array: ArrayRef = Arc::new(map_builder.finish());
            return plan_err!(
                NAME,
                let field_arr = args.args[1].clone().into_array(n)?;
    fn hash<H: std::hash::Hasher>(&self, state: &mut H) {
        Field::new(FIELD_TOKENS, tokens_map_type(), true),
        }
            "entries",
                Field::new(
                ),
}
    DataType::Struct(Fields::from(vec![
                        eval_samples(pattern, &samples)
    }
    ]))
                value_builder.append_value(v);
            signature: Signature::user_defined(Volatility::Immutable),
    }
        };
//! the PPL Calcite visitor consumes both fields via ITEM.
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
    pub fn new() -> Self {
        let results = vec![eval_field("<*>@<*>.<*>", "amberduke@pyrami.com")];
/// Assemble the StructArray from a per-row vector of PatternResult.
    fn name(&self) -> &str {
    DataType::Map(
                    "{} expected ColumnarValue::Array from base pattern_parser, got {:?}",
        let first = utf8_or_err(NAME, 0, &arg_types[0])?;
                    .downcast_ref::<ListArray>()
        DataType::Utf8 => Utf8Kind::Std,
        DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => Ok(DataType::Utf8),
        map_builder
                slot,
            },
            false,
    }
//!
                            Some(p) => p,
            panic!("expected struct, got {:?}", dt);
}
                        (Some(p), Some(f)) => eval_field(p, f),
        DataType::LargeUtf8 => Utf8Kind::Large,
fn read_utf8<'a>(udf: &str, slot: usize, arr: &'a ArrayRef) -> Result<Utf8View<'a>> {
const FIELD_PATTERN: &str = "pattern";
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
pub fn register_all(ctx: &SessionContext) {
/// Per-row Utf8 view that flattens Utf8 / LargeUtf8 / Utf8View into a common
 * The OpenSearch Contributors require contributions made to
//! WindowUDF path.
        if args.args.len() != 2 {
        let pattern_strings = read_utf8(NAME, 0, &pattern_arr)?;
}
        &self.signature
    let mut map_builder = MapBuilder::with_capacity(
}
            Utf8Kind::Large => Some(
struct Utf8View<'a> {
}
                            })
            );
                    .value(i),
            map_builder.keys().append_value(label);
impl<'a> Utf8View<'a> {
                        let inner = list.value(i);
    }
        let pattern_col = s.column(0).as_any().downcast_ref::<StringArray>().unwrap();
                            .collect();
    Large,
    let n = results.len();
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
            ])),
//! `pattern_parser(pattern, field)` — wraps PPL's `PATTERN_PARSER` UDF.
        // Delegate to the base UDF to compute the per-row PatternResult, then
}
enum PatternField {
                    .as_any()
}
            PatternField::Tokens => tokens_map_type(),
                Ok(ColumnarValue::Array(build_struct_array(&results)?))
    fn build_struct_array_populates_pattern_and_tokens_for_email_evalfield() {
                let field_strings = read_utf8(NAME, 1, &field_arr)?;
            DataType::Struct(Fields::from(vec![
                    return plan_err!(
    fn udf_name(&self) -> &'static str {
    );
    for r in &results.iter().collect::<Vec<_>>() {
enum Utf8Kind {
}
                            return PatternResult::empty();
                    .as_any()
/// tree but kept inline because the shapes differ per UDF.
/// Per-field accessor wrapper. Runs the same `pattern_parser` logic but
    ]);
                            .filter_map(|j| {
pub struct PatternParserGetFieldUdf {
use datafusion::error::Result;
                let results: Vec<PatternResult> = (0..n)
                    DataType::List(Arc::new(Field::new("item", DataType::Utf8, true))),
                self.array
        } else {
}
    fn get(&self, i: usize) -> Option<&str> {
 * this file be licensed under the Apache-2.0 license or a
        }
                            "{} arg 1: expected ListArray<string>",
}
            }
    }
                self.array
                    self.field.udf_name()
fn utf8_or_err(udf: &str, slot: usize, dt: &DataType) -> Result<DataType> {
    }
        let n = args.number_rows;
        }),
    fn name(&self) -> &str {
//!
                    .value(i),
                    "{} arg 1: expected string or List<string>, got {:?}",
                "{} expects 2 arguments (pattern, field|sample_logs), got {}",
//! INTERNAL_PATTERN window function (separate milestone) and isn't
use datafusion::arrow::buffer::{NullBuffer, OffsetBuffer};
        Self {
    Std,
            for v in values {
        ListBuilder::new(StringBuilder::new()),
            }
        }
        }
    }
        StringBuilder::new(),
        let DataType::Struct(fields) = dt else {
                            None => return PatternResult::empty(),
                    })
                }
    let kind = match arr.data_type() {
                    NAME,
                            Some(arr) => arr,
            // user_defined coercion — operand types are dispatched at
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => {
                udf,
                            None => return PatternResult::empty(),
                        _ => PatternResult::empty(),
impl std::hash::Hash for PatternParserGetFieldUdf {
                    .map(|i| {
                    })
                "{} arg {}: expected string array, got {:?}",
        Ok(ColumnarValue::Array(Arc::clone(s.column(column_index))))
        let struct_result = PatternParserUdf::new().invoke_with_args(args)?;
    }
fn tokens_map_type() -> DataType {
    match dt {
        DataType::Utf8View => Utf8Kind::View,
    }
/// {@code pattern_parser_get_tokens}) that bypass DataFusion's substrait
use datafusion::arrow::array::{
                self.array
            PatternField::Tokens => 1,
    #[test]
                        }
                    .map(|i| match (pattern_strings.get(i), field_strings.get(i)) {
            }
        };
                        };
        assert_eq!(pattern_col.value(0), "<token1>@<token2>.<token3>");
    fn struct_data_type_has_pattern_and_tokens_fields() {
        PatternParserUdf::new().coerce_types(arg_types)
    }
/// `tokens` (Map<Utf8, List<Utf8>>). Calcite's ITEM lowering with a constant
    // Field 2: tokens (Map<Utf8, List<Utf8>>)
    }
            .as_any()
        }
    let mut pattern_builder = StringBuilder::with_capacity(n, n * 32);
                    .as_any()
                    true,
                    })?;
        Ok(vec![first, second])
        PatternField::Pattern,
    }
        // dependent and asserted via Map.equals on the JVM side anyway.
        // accumulated list of substrings. ImmutableMap.of in Java preserves
                other
            return plan_err!(
                        let samples: Vec<String> = (0..inner_strings.len())
            return plan_err!(
    // Field 1: pattern (Utf8)
    field: PatternField,
        false,
fn build_struct_array(results: &[PatternResult]) -> Result<ArrayRef> {
                    );
            signature: Signature::user_defined(Volatility::Immutable),
            pattern_builder.append_value("");
        // Just sanity-check non-empty tokens; precise key ordering is HashMap-
//!
                datafusion::error::DataFusionError::Plan(format!(
        Ok(struct_data_type())
    Ok(Utf8View {
            other => {
                "{} arg 1: expected string or List<string>, got {:?}",
use datafusion::arrow::datatypes::{DataType, Field, Fields};
                        let inner_strings = match inner.as_any().downcast_ref::<StringArray>() {
                    other
/// the need for downstream struct-field access entirely.
#[derive(Debug)]
            value: "value".to_string(),
    use super::*;
                        datafusion::error::DataFusionError::Plan(format!(
                                } else {
                        let pattern = match pattern_strings.get(i) {
/// key resolves to named struct field access on this shape.
impl PatternParserGetFieldUdf {
pub const NAME: &str = "pattern_parser";
        Field::new(FIELD_TOKENS, tokens_map_type(), true),
//! also has an `evalAgg` shape for BRAIN label mode; that case needs the
        let struct_array = match struct_result {
                    .collect();
            }
        // CalcitePPLPatternsIT compares via Map.equals which is content-only,
    }
    View,
        assert!(tokens_col.len() == 1);
impl PatternParserUdf {
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
