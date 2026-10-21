}
        let udf = JsonValidUdf::new();
        assert_eq!(
        assert!(is_valid_json("{\"k\":1}"));
        );
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        for t in [DataType::Utf8, DataType::LargeUtf8, DataType::Utf8View] {
            udf.return_type(&[DataType::Utf8]).unwrap(),
        assert!(err.to_string().contains("expected string"));
            builder.append_value(strings.cell(i).map(is_valid_json).unwrap_or(false));
 * The OpenSearch Contributors require contributions made to
        };
        // special-case in is_valid_json.
    use super::*;
        // NULL/missing input → FALSE (not NULL), matching legacy JsonUtils.isValidJson
    fn invoke_column_null_input_is_false() {
    fn coerce_types_rejects_non_string() {
        // (`if (isNull || isMissing) return LITERAL_FALSE`). This is what makes
    if s.trim().is_empty() {
    #[test]
            let valid = match sv {
    ctx.register_udf(ScalarUDF::from(JsonValidUdf::new()));
use super::{coerce_args, CoerceMode};
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
//! `json_valid(value)` — TRUE iff the input parses as JSON.
        for i in 0..n {
            !arr.value(1),
        }
use datafusion::arrow::array::{ArrayRef, BooleanBuilder};
    fn coerce_types_rejects_wrong_arity() {
        Self {
            "NULL input → FALSE (legacy JsonUtils.isValidJson)"
            return_field: Arc::new(Field::new("out", DataType::Boolean, true)),
}
 */
        assert!(udf.coerce_types(&[DataType::Utf8, DataType::Utf8]).is_err());
        match udf.invoke_with_args(args).unwrap() {
    fn default() -> Self {
//!
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
//!   * empty / whitespace-only input → TRUE (Jackson `readTree("")` returns a
    }
    }
            None,
        assert!(is_valid_json("  [1, 2]  "));
        );
            number_rows: 1,
            signature: Signature::user_defined(Volatility::Immutable),
            ColumnarValue::Scalar(ScalarValue::Boolean(Some(false))) => {}
        let out = udf.invoke_with_args(args).unwrap();
    }
        // "json empty string" fixture row) treats these as VALID. serde would reject them, hence the
    }
            return Ok(ColumnarValue::Scalar(ScalarValue::Boolean(Some(valid))));
            };
    #[test]
use std::sync::Arc;
    fn coerce_types_accepts_string_variants() {
#[cfg(test)]
        let udf = JsonValidUdf::new();
    }
use datafusion::arrow::datatypes::DataType;
        // Empty string is VALID per the legacy Jackson contract (see empty_and_whitespace_are_valid).
fn is_valid_json(s: &str) -> bool {
    fn parses_every_json_shape_as_valid() {
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        "json_valid"
    }
        let arr = args.args[0].clone().into_array(n)?;
        if arg_types.len() != 1 {
        assert!(is_valid_json(""));
            number_rows: 5,
        let err = udf.coerce_types(&[DataType::Int64]).unwrap_err();
            assert_eq!(
        };
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    }
        let args = ScalarFunctionArgs {
    #[test]
            args: vec![ColumnarValue::Array(Arc::new(input))],
/// TRUE iff `s` is a well-formed JSON document (object, array, or scalar).
//! `ObjectMapper.readTree`), which is the runtime behind the PPL `json_valid`
    #[test]
    fn empty_and_whitespace_are_valid() {
            args: vec![ColumnarValue::Scalar(ScalarValue::Utf8(None))],
            other => panic!("expected Boolean(Some(false)), got {other:?}"),
        assert!(!is_valid_json("{\"invalid\": \"json\""));
    }
        assert!(
impl Default for JsonValidUdf {
    #[test]
    }
        // CoerceMode::Utf8 preserves the observed string type (Utf8/LargeUtf8/Utf8View);
        match udf.invoke_with_args(args).unwrap() {
    }
use serde_json::Value;
}
        assert!(is_valid_json("[1,2,3,4]"));
            );
            // NULL row → FALSE (legacy JsonUtils.isValidJson returns FALSE for null/missing),
        assert!(is_valid_json("null"));
/// Callers handle the NULL-input case before dispatching here; this helper is total over `&str`.
    serde_json::from_str::<Value>(s).is_ok()
use datafusion::common::{plan_err, ScalarValue};
        assert!(is_valid_json("   "));
            )))],
use datafusion::error::Result;
        let input = StringArray::from(vec![
use super::json_common::StringArrayView;
                | ScalarValue::LargeUtf8(opt)
        // callers do not discover Jackson parity edges empirically.
        // Legacy JsonUtils.isValidJson uses Jackson readTree, which returns MissingNode (no throw)
//!     `MissingNode` without throwing; serde rejects it, so `is_valid_json`
                ScalarValue::Utf8(opt)
        assert!(!arr.value(2));
        assert!(udf.coerce_types(&[]).is_err());
 * compatible open source license.
        let udf = JsonValidUdf::new();
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        }
        coerce_args("json_valid", arg_types, &[CoerceMode::Utf8])
        // for empty / whitespace-only input — so the PPL contract (and JsonFunctionsIT's
        assert!(!is_valid_json("[1,2"));
/// whitespace-only input, so the legacy function — and the `JsonFunctionsIT.test_json_valid`
        if args.args.len() != 1 {
mod tests {
        let mut builder = BooleanBuilder::with_capacity(n);
    }
//! Parity target: the legacy SQL-plugin `JsonUtils.isValidJson` (Jackson
/// `ObjectMapper.readTree`. Jackson returns a `MissingNode` (no exception) for empty or
                _ => false,
pub fn register_all(ctx: &SessionContext) {
        // Utf8 / LargeUtf8 / Utf8View — StringArrayView reads all three uniformly.
/// Matches the legacy PPL contract in SQL-plugin `JsonUtils.isValidJson`, which uses Jackson
        // CoerceMode::Utf8 preserves the observed string type, so the input may be
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    #[test]
            DataType::Boolean
    #[test]
        assert!(arr.value(3));
 * this file be licensed under the Apache-2.0 license or a
    signature: Signature,
        // NULL scalar → Boolean(Some(false)), matching legacy JsonUtils.isValidJson.
            Some(""),
                udf.coerce_types(std::slice::from_ref(&t)).unwrap(),
//! the `JsonFunctionsIT` suite asserts against. Contract:
        let arr = arr.as_any().downcast_ref::<BooleanArray>().unwrap();
        }
    }
        assert!(is_valid_json("{\"a\":[1,{\"b\":null}]}"));
impl ScalarUDFImpl for JsonValidUdf {
            Some("{\"invalid\": \"json\""),
//!     so `where not json_valid(col)` includes NULL rows
            // NULL input → FALSE (not NULL), matching the legacy SQL-plugin
}
use datafusion::logical_expr::{
    fn signature(&self) -> &Signature {
        // the StringArrayView reader handles all three at execution time.
            args: vec![ColumnarValue::Scalar(ScalarValue::Utf8(Some(
    pub fn new() -> Self {
        let udf = JsonValidUdf::new();
        let udf = JsonValidUdf::new();
        }
    }
        };
            arg_fields: vec![],
        let n = args.number_rows;
        assert!(arr.value(0));
        // Legacy CalcitePPLJsonBuiltinFunctionIT.testJsonValid pins array input;
        Ok(DataType::Boolean)
/// fixture — treat `""` as VALID. serde_json's `from_str` instead errors on empty input, so we
        assert!(is_valid_json("true"));
    }
        assert!(!is_valid_json("not-json"));
        // objects / nested / scalars / whitespace-padded are covered here so future
            ColumnarValue::Array(a) => a,
            // so `where not json_valid(col)` includes NULL rows as the IT expects.
#[derive(Debug, PartialEq, Eq, Hash)]
}
}
/// special-case empty/whitespace to preserve parity; all other inputs use serde's RFC 8259 parse.
pub struct JsonValidUdf {
/*
            return plan_err!("json_valid expects 1 argument, got {}", args.args.len());
        let udf = JsonValidUdf::new();
 *
        }
    fn invoke_scalar_null_is_false() {
    }
        let arr = match out {
                vec![t.clone()]
    #[test]
    fn return_type_is_boolean() {
        let strings = StringArrayView::from_array(&arr)?;
// ─── tests ──────────────────────────────────────────────────────────────────
        // `where not json_valid(col)` include NULL rows, per JsonFunctionsIT.test_not_json_valid.
//!   * malformed input → FALSE
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        };
            number_rows: 1,
}
 * SPDX-License-Identifier: Apache-2.0
    fn invoke_scalar_input_produces_scalar_output() {
            return_field: Arc::new(Field::new("out", DataType::Boolean, true)),
//!     special-cases it — see that fn)
    }
        &self.signature
        Self::new()
//!   * NULL / missing input → FALSE (legacy returns `LITERAL_FALSE`, NOT null),
        assert!(arr.value(4));
            return_field: Arc::new(Field::new("out", DataType::Boolean, true)),
            return plan_err!("json_valid expects 1 argument, got {}", arg_types.len());
        let udf = JsonValidUdf::new();
            // JsonUtils.isValidJson: `if (isNull || isMissing) return LITERAL_FALSE`.
    }
                | ScalarValue::Utf8View(opt) => opt.as_deref().map(is_valid_json).unwrap_or(false),
        let args = ScalarFunctionArgs {
        if let ColumnarValue::Scalar(sv) = &args.args[0] {
            Some("42"),
    }
        // Pinned against legacy IT's {"invalid": "json"} case + garbage.
            ColumnarValue::Scalar(ScalarValue::Boolean(Some(true))) => {}
            other => panic!("expected Boolean(Some(true)), got {other:?}"),
            _ => panic!("expected array"),
        return true;
        let args = ScalarFunctionArgs {
    #[test]
    // Jackson readTree("") / readTree("   ") → MissingNode (valid); serde would reject. Match legacy.
        assert!(!arr.is_null(1), "NULL input must produce FALSE, not NULL");
};
            arg_fields: vec![],
        }
        assert!(is_valid_json("\"s\""));
    fn rejects_malformed() {
impl JsonValidUdf {
    #[test]
//!   * valid JSON → TRUE
        }
                "[1,2,3,4]".into(),
use datafusion::execution::context::SessionContext;
    use datafusion::arrow::array::{Array, BooleanArray, StringArray};
            Some("[1,2,3,4]"),
        assert!(is_valid_json("42"));
        ]);
    fn name(&self) -> &str {
        }
    use datafusion::arrow::datatypes::Field;
            arg_fields: vec![],
