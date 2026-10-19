    #[test]
pub struct JsonArrayLengthUdf {
    use super::*;
        }
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        // Int64 here works for literal args (Calcite const-folds and inserts a
    }
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        assert_eq!(out, DataType::Int32);
        let strings = StringArrayView::from_array(&arr)?;
        assert_eq!(json_array_len("not-json"), None);
    }
        match out {
    }
        Ok(DataType::Int32)
impl ScalarUDFImpl for JsonArrayLengthUdf {
            )))],
        assert!(arr.is_null(1));
            return Ok(ColumnarValue::Scalar(ScalarValue::Int32(len)));
    #[test]
        }
    fn signature(&self) -> &Signature {
            }
        }
impl Default for JsonArrayLengthUdf {
}
#[cfg(test)]
        .ok()
                "[1,2,3,4]".into(),
        &self.signature
    signature: Signature,
        assert!(arr.is_null(3));
            arg_fields: vec![],
            return plan_err!(
        let args = ScalarFunctionArgs {
    pub fn new() -> Self {
                None => builder.append_null(),
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
use std::sync::Arc;
        }
    fn malformed_json_returns_none() {
        .and_then(|v| v.as_array().map(|a| a.len()))
        // narrowing CAST on the project) but leaks Int64 through the column
fn json_array_len(s: &str) -> Option<i32> {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
};
    }
        let input = StringArray::from(vec![
    fn invoke_handles_nulls_malformed_and_non_array() {
        assert_eq!(json_array_len("{\"k\":1}"), None);
        if arg_types.len() != 1 {
            number_rows: 1,
    }
use datafusion::arrow::datatypes::DataType;
//! `json_array_length(value)` — length of a JSON array (parity with legacy
use datafusion::common::{plan_err, ScalarValue};
        }
        Self {
            None,
        let udf = JsonArrayLengthUdf::new();
        let args = ScalarFunctionArgs {
    #[test]
    fn invoke_scalar_input_produces_scalar_output() {
            ColumnarValue::Scalar(ScalarValue::Int32(Some(4))) => {}
}
        let out = udf.return_type(&[DataType::Utf8]).unwrap();
    }
                | ScalarValue::LargeUtf8(opt)
            return_field: Arc::new(Field::new("out", DataType::Int32, true)),
            return_field: Arc::new(Field::new("out", DataType::Int32, true)),
        assert_eq!(json_array_len("[1,2"), None);
    }
            ColumnarValue::Scalar(ScalarValue::Int32(None)) => {}
            args: vec![ColumnarValue::Scalar(ScalarValue::Utf8(None))],
                "json_array_length expects 1 argument, got {}",
}
 */
        let out = udf.invoke_with_args(args).unwrap();
        coerce_args("json_array_length", arg_types, &[CoerceMode::Utf8])
use datafusion::arrow::array::{ArrayRef, Int32Builder};
        let udf = JsonArrayLengthUdf::new();
    }
    fn default() -> Self {
            signature: Signature::user_defined(Volatility::Immutable),
        let arr = arr.as_any().downcast_ref::<Int32Array>().unwrap();
        .and_then(|len| i32::try_from(len).ok())
        // Heterogeneous array — parity with legacy Gson List parse.
    fn parses_array_returns_length() {
use super::{coerce_args, CoerceMode};
use super::json_common::StringArrayView;
 * this file be licensed under the Apache-2.0 license or a
                "json_array_length expects 1 argument, got {}",
    fn invoke_scalar_null_input_yields_scalar_null() {
use datafusion::logical_expr::{
        Self::new()
}
    fn non_array_json_returns_none() {
    ctx.register_udf(ScalarUDF::from(JsonArrayLengthUdf::new()));
/// i32 matches PPL's declared INTEGER return type; arrays exceeding i32::MAX
            args: vec![ColumnarValue::Array(Arc::new(input))],
        match out {
    #[test]
        let udf = JsonArrayLengthUdf::new();
    #[test]
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        ]);
use datafusion::error::Result;
//! `JsonArrayLengthFunctionImpl`; verified by `CalcitePPLJsonBuiltinFunctionIT.testJsonArrayLength`).
    #[test]
    }
}
        assert_eq!(json_array_len("\"scalar\""), None);
/// Returns the array length as i32, or None for malformed / non-array input.
/*
impl JsonArrayLengthUdf {
        assert_eq!(json_array_len("[]"), Some(0));
 * compatible open source license.
        for i in 0..n {
    fn coerce_types_rejects_wrong_arity() {
            let len = match sv {
        assert!(udf.coerce_types(&[]).is_err());
            args: vec![ColumnarValue::Scalar(ScalarValue::Utf8(Some(
        }
        if args.args.len() != 1 {
        };
// ─── tests ──────────────────────────────────────────────────────────────────
use datafusion::execution::context::SessionContext;
                | ScalarValue::Utf8View(opt) => opt.as_deref().and_then(json_array_len),
    #[test]
//! NULL / non-array / malformed → NULL. Only plan-time arity / type failures
        assert!(udf.coerce_types(&[DataType::Utf8, DataType::Utf8]).is_err());
        assert!(arr.is_null(2));
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        let udf = JsonArrayLengthUdf::new();
//! surface as `plan_err!`; runtime input of any content never errors.
/// elements (>2B) saturate to NULL rather than silently truncating.
            Some("[]"),
                _ => None,
            arg_fields: vec![],
            other => panic!("expected Int32(Some(4)), got {other:?}"),
 * SPDX-License-Identifier: Apache-2.0
        let mut builder = Int32Builder::with_capacity(n);
    }
                ScalarValue::Utf8(opt)
            _ => panic!("expected array"),
            Some("not-json"),
            return_field: Arc::new(Field::new("out", DataType::Int32, true)),
        let arr = match out {
            number_rows: 1,
        // Scalar fast-path: parse once, broadcast as scalar output.
        let args = ScalarFunctionArgs {
            match strings.cell(i).and_then(json_array_len) {
                Some(len) => builder.append_value(len),
                arg_types.len()
}
        }
        assert_eq!(json_array_len("[\"a\",\"b\"]"), Some(2));
mod tests {
        };
        };
            Some("[1,2,3]"),
    use datafusion::arrow::array::{Array, Int32Array, StringArray};
        assert_eq!(json_array_len("[1,\"x\",{\"k\":1}]"), Some(3));
        assert_eq!(json_array_len("42"), None);
        // path — caller sees Integer for literals, Long for column refs.
            );
        let arr = args.args[0].clone().into_array(n)?;
}
    serde_json::from_str::<Value>(s)
        assert_eq!(json_array_len("[1,2,3]"), Some(3));
        if let ColumnarValue::Scalar(sv) = &args.args[0] {
    use datafusion::arrow::datatypes::Field;
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    }
#[derive(Debug, PartialEq, Eq, Hash)]
    }
use serde_json::Value;
        };
        let n = args.number_rows;
            );
        let udf = JsonArrayLengthUdf::new();
pub fn register_all(ctx: &SessionContext) {
            arg_fields: vec![],
        assert_eq!(arr.value(4), 0);
            Some("{\"k\":1}"),
    #[test]
            };
        assert_eq!(json_array_len(""), None);
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    }
        let out = udf.invoke_with_args(args).unwrap();
 *
                args.args.len()
    }
    fn name(&self) -> &str {
            other => panic!("expected Int32(None), got {other:?}"),
        // Int32 to match PPL's INTEGER_FORCE_NULLABLE declaration. Returning
            ColumnarValue::Array(a) => a,
    fn return_type_is_int32() {
        let out = udf.invoke_with_args(args).unwrap();
            number_rows: 5,
        assert_eq!(json_array_len("null"), None);
            return plan_err!(
 * The OpenSearch Contributors require contributions made to
        "json_array_length"
        assert_eq!(arr.value(0), 3);
    }
