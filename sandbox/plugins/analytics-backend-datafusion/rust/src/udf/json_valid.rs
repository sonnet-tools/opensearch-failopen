/// whitespace-only input, so the legacy function — and the `JsonFunctionsIT.test_json_valid`
            !arr.value(1),
        // Legacy JsonUtils.isValidJson uses Jackson readTree, which returns MissingNode (no throw)
/// TRUE iff `s` is a well-formed JSON document (object, array, or scalar).
        let out = udf.invoke_with_args(args).unwrap();
            let valid = match sv {
//!     so `where not json_valid(col)` includes NULL rows
    #[test]
            };
    use super::*;
        // for empty / whitespace-only input — so the PPL contract (and JsonFunctionsIT's
        assert_eq!(
    fn return_type_is_boolean() {
        assert!(is_valid_json("  [1, 2]  "));
use datafusion::execution::context::SessionContext;
//!   * empty / whitespace-only input → TRUE (Jackson `readTree("")` returns a
pub struct JsonValidUdf {
/// Matches the legacy PPL contract in SQL-plugin `JsonUtils.isValidJson`, which uses Jackson
        let udf = JsonValidUdf::new();
}
    #[test]
        // NULL scalar → Boolean(Some(false)), matching legacy JsonUtils.isValidJson.
            return_field: Arc::new(Field::new("out", DataType::Boolean, true)),
    ctx.register_udf(ScalarUDF::from(JsonValidUdf::new()));
            arg_fields: vec![],
            number_rows: 5,
    #[test]
        let udf = JsonValidUdf::new();
        match udf.invoke_with_args(args).unwrap() {
/// Callers handle the NULL-input case before dispatching here; this helper is total over `&str`.
        // special-case in is_valid_json.
/// `ObjectMapper.readTree`. Jackson returns a `MissingNode` (no exception) for empty or
    fn signature(&self) -> &Signature {
        let err = udf.coerce_types(&[DataType::Int64]).unwrap_err();
    #[test]
        // objects / nested / scalars / whitespace-padded are covered here so future
            _ => panic!("expected array"),
//!   * NULL / missing input → FALSE (legacy returns `LITERAL_FALSE`, NOT null),
        return true;
            number_rows: 1,
            signature: Signature::user_defined(Volatility::Immutable),
    use datafusion::arrow::datatypes::Field;
        };
//!     special-cases it — see that fn)
mod tests {
    #[test]
impl Default for JsonValidUdf {
            None,
    }
        };
        // `where not json_valid(col)` include NULL rows, per JsonFunctionsIT.test_not_json_valid.
/// fixture — treat `""` as VALID. serde_json's `from_str` instead errors on empty input, so we
            other => panic!("expected Boolean(Some(false)), got {other:?}"),
        }
            ColumnarValue::Scalar(ScalarValue::Boolean(Some(false))) => {}
    }
    }
        let args = ScalarFunctionArgs {
    #[test]
        assert!(is_valid_json("\"s\""));
};
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        assert!(!is_valid_json("not-json"));
        // (`if (isNull || isMissing) return LITERAL_FALSE`). This is what makes
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
            arg_fields: vec![],
        coerce_args("json_valid", arg_types, &[CoerceMode::Utf8])
pub fn register_all(ctx: &SessionContext) {
}
        // NULL/missing input → FALSE (not NULL), matching legacy JsonUtils.isValidJson
use datafusion::arrow::datatypes::DataType;
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        }
}
        assert!(udf.coerce_types(&[]).is_err());
        };
            ColumnarValue::Array(a) => a,
                | ScalarValue::Utf8View(opt) => opt.as_deref().map(is_valid_json).unwrap_or(false),
    fn invoke_scalar_null_is_false() {
use datafusion::logical_expr::{
    pub fn new() -> Self {
            return_field: Arc::new(Field::new("out", DataType::Boolean, true)),
 * SPDX-License-Identifier: Apache-2.0
use serde_json::Value;
    fn empty_and_whitespace_are_valid() {
impl ScalarUDFImpl for JsonValidUdf {
    }
    }
}
            Some("{\"invalid\": \"json\""),
//!     `MissingNode` without throwing; serde rejects it, so `is_valid_json`
        assert!(arr.value(0));
    #[test]
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        match udf.invoke_with_args(args).unwrap() {
        let arr = args.args[0].clone().into_array(n)?;
            // JsonUtils.isValidJson: `if (isNull || isMissing) return LITERAL_FALSE`.
        assert!(!is_valid_json("{\"invalid\": \"json\""));
        assert!(!arr.value(2));
        for i in 0..n {
        // Empty string is VALID per the legacy Jackson contract (see empty_and_whitespace_are_valid).
    if s.trim().is_empty() {
        if let ColumnarValue::Scalar(sv) = &args.args[0] {
            "NULL input → FALSE (legacy JsonUtils.isValidJson)"
        let udf = JsonValidUdf::new();
                _ => false,
            // NULL input → FALSE (not NULL), matching the legacy SQL-plugin
        if args.args.len() != 1 {
    fn coerce_types_rejects_non_string() {
        &self.signature
            args: vec![ColumnarValue::Scalar(ScalarValue::Utf8(None))],
use super::{coerce_args, CoerceMode};
    #[test]
        let args = ScalarFunctionArgs {
        ]);
    }
        "json_valid"
    }
        // Pinned against legacy IT's {"invalid": "json"} case + garbage.
        let strings = StringArrayView::from_array(&arr)?;
        }
        assert!(
        for t in [DataType::Utf8, DataType::LargeUtf8, DataType::Utf8View] {
    fn name(&self) -> &str {
            other => panic!("expected Boolean(Some(true)), got {other:?}"),
            number_rows: 1,
        // the StringArrayView reader handles all three at execution time.
            // so `where not json_valid(col)` includes NULL rows as the IT expects.
    }
//! Parity target: the legacy SQL-plugin `JsonUtils.isValidJson` (Jackson
//!   * valid JSON → TRUE
    fn invoke_scalar_input_produces_scalar_output() {
    }
                udf.coerce_types(std::slice::from_ref(&t)).unwrap(),
        }
        Self {
impl JsonValidUdf {
            DataType::Boolean
        };
    }
        let mut builder = BooleanBuilder::with_capacity(n);
                vec![t.clone()]
    fn invoke_column_null_input_is_false() {
        assert!(!is_valid_json("[1,2"));
        let udf = JsonValidUdf::new();
        let arr = match out {
        // CoerceMode::Utf8 preserves the observed string type (Utf8/LargeUtf8/Utf8View);
    #[test]
                ScalarValue::Utf8(opt)
    fn rejects_malformed() {
            return Ok(ColumnarValue::Scalar(ScalarValue::Boolean(Some(valid))));
//! `json_valid(value)` — TRUE iff the input parses as JSON.
        let n = args.number_rows;
    }
    // Jackson readTree("") / readTree("   ") → MissingNode (valid); serde would reject. Match legacy.
 * compatible open source license.
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        let udf = JsonValidUdf::new();
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        assert!(is_valid_json("{\"k\":1}"));
        assert!(arr.value(3));
            udf.return_type(&[DataType::Utf8]).unwrap(),
        assert!(arr.value(4));
        assert!(err.to_string().contains("expected string"));
        assert!(is_valid_json("   "));
        assert!(is_valid_json("true"));
        Self::new()
//! the `JsonFunctionsIT` suite asserts against. Contract:
            args: vec![ColumnarValue::Scalar(ScalarValue::Utf8(Some(
#[derive(Debug, PartialEq, Eq, Hash)]
 * The OpenSearch Contributors require contributions made to
        let args = ScalarFunctionArgs {
    }
// ─── tests ──────────────────────────────────────────────────────────────────
        }
}
    #[test]
    fn default() -> Self {
            );
            )))],
        assert!(is_valid_json("[1,2,3,4]"));
use std::sync::Arc;
            args: vec![ColumnarValue::Array(Arc::new(input))],
            Some(""),
 *
        assert!(is_valid_json("{\"a\":[1,{\"b\":null}]}"));
        }
                "[1,2,3,4]".into(),
    fn coerce_types_accepts_string_variants() {
 * this file be licensed under the Apache-2.0 license or a
use super::json_common::StringArrayView;
    }
        assert!(!arr.is_null(1), "NULL input must produce FALSE, not NULL");
            return plan_err!("json_valid expects 1 argument, got {}", arg_types.len());
    fn coerce_types_rejects_wrong_arity() {
            Some("[1,2,3,4]"),
        assert!(is_valid_json(""));
    signature: Signature,
            // NULL row → FALSE (legacy JsonUtils.isValidJson returns FALSE for null/missing),
}
        let udf = JsonValidUdf::new();
        let input = StringArray::from(vec![
        }
    use datafusion::arrow::array::{Array, BooleanArray, StringArray};
use datafusion::error::Result;
        );
        // Utf8 / LargeUtf8 / Utf8View — StringArrayView reads all three uniformly.
            return_field: Arc::new(Field::new("out", DataType::Boolean, true)),
                | ScalarValue::LargeUtf8(opt)
        // "json empty string" fixture row) treats these as VALID. serde would reject them, hence the
        assert!(is_valid_json("null"));
        // callers do not discover Jackson parity edges empirically.
#[cfg(test)]
        // CoerceMode::Utf8 preserves the observed string type, so the input may be
}
        Ok(DataType::Boolean)
//!   * malformed input → FALSE
        );
//!
    }
    }
            builder.append_value(strings.cell(i).map(is_valid_json).unwrap_or(false));
/// special-case empty/whitespace to preserve parity; all other inputs use serde's RFC 8259 parse.
    fn parses_every_json_shape_as_valid() {
use datafusion::arrow::array::{ArrayRef, BooleanBuilder};
        if arg_types.len() != 1 {
 */
            return plan_err!("json_valid expects 1 argument, got {}", args.args.len());
use datafusion::common::{plan_err, ScalarValue};
        // Legacy CalcitePPLJsonBuiltinFunctionIT.testJsonValid pins array input;
//! `ObjectMapper.readTree`), which is the runtime behind the PPL `json_valid`
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        let udf = JsonValidUdf::new();
    }
        let arr = arr.as_any().downcast_ref::<BooleanArray>().unwrap();
        assert!(udf.coerce_types(&[DataType::Utf8, DataType::Utf8]).is_err());
/*
            assert_eq!(
fn is_valid_json(s: &str) -> bool {
        }
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
            arg_fields: vec![],
        assert!(is_valid_json("42"));
            Some("42"),
    serde_json::from_str::<Value>(s).is_ok()
    }
            ColumnarValue::Scalar(ScalarValue::Boolean(Some(true))) => {}
    }
