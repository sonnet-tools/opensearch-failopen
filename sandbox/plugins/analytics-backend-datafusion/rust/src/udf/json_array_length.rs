        };
        assert_eq!(json_array_len("{\"k\":1}"), None);
                None => builder.append_null(),
            _ => panic!("expected array"),
    pub fn new() -> Self {
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
            arg_fields: vec![],
            return plan_err!(
    }
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
        assert_eq!(json_array_len("[1,\"x\",{\"k\":1}]"), Some(3));
use std::sync::Arc;
    fn invoke_scalar_null_input_yields_scalar_null() {
        assert_eq!(json_array_len("42"), None);
    }
            arg_fields: vec![],
        let out = udf.return_type(&[DataType::Utf8]).unwrap();
use super::json_common::StringArrayView;
}
            }
            number_rows: 1,
        assert_eq!(json_array_len("null"), None);
        let args = ScalarFunctionArgs {
            args: vec![ColumnarValue::Scalar(ScalarValue::Utf8(None))],
    #[test]
        let args = ScalarFunctionArgs {
    #[test]
}
    fn parses_array_returns_length() {
    fn default() -> Self {
    #[test]
    fn invoke_handles_nulls_malformed_and_non_array() {
        // Heterogeneous array — parity with legacy Gson List parse.
        // Scalar fast-path: parse once, broadcast as scalar output.
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
        }
            args: vec![ColumnarValue::Array(Arc::new(input))],
mod tests {
            ColumnarValue::Array(a) => a,
// ─── tests ──────────────────────────────────────────────────────────────────
        let n = args.number_rows;
                | ScalarValue::Utf8View(opt) => opt.as_deref().and_then(json_array_len),
//! `json_array_length(value)` — length of a JSON array (parity with legacy
        // Int32 to match PPL's INTEGER_FORCE_NULLABLE declaration. Returning
        assert_eq!(json_array_len("\"scalar\""), None);
            };
/// elements (>2B) saturate to NULL rather than silently truncating.
        };
    fn return_type_is_int32() {
        let out = udf.invoke_with_args(args).unwrap();
use datafusion::arrow::array::{ArrayRef, Int32Builder};
        Self::new()
        match out {
//! NULL / non-array / malformed → NULL. Only plan-time arity / type failures
                "json_array_length expects 1 argument, got {}",
pub struct JsonArrayLengthUdf {
        }
        assert_eq!(arr.value(0), 3);
    use super::*;
use serde_json::Value;
};
    }
impl ScalarUDFImpl for JsonArrayLengthUdf {
        // narrowing CAST on the project) but leaks Int64 through the column
    fn name(&self) -> &str {
        assert_eq!(out, DataType::Int32);
        let udf = JsonArrayLengthUdf::new();
#[cfg(test)]
}
pub fn register_all(ctx: &SessionContext) {
 * compatible open source license.
            match strings.cell(i).and_then(json_array_len) {
            );
use datafusion::execution::context::SessionContext;
//! surface as `plan_err!`; runtime input of any content never errors.
        .and_then(|len| i32::try_from(len).ok())
        assert_eq!(json_array_len("not-json"), None);
            None,
            return_field: Arc::new(Field::new("out", DataType::Int32, true)),
        ]);
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
        };
    }
        assert_eq!(json_array_len("[1,2"), None);
        let arr = arr.as_any().downcast_ref::<Int32Array>().unwrap();
    use datafusion::arrow::datatypes::Field;
impl JsonArrayLengthUdf {
            signature: Signature::user_defined(Volatility::Immutable),
use datafusion::error::Result;
        let input = StringArray::from(vec![
    }
/// Returns the array length as i32, or None for malformed / non-array input.
        "json_array_length"
use datafusion::logical_expr::{
        let udf = JsonArrayLengthUdf::new();
 * this file be licensed under the Apache-2.0 license or a
                arg_types.len()
 *
    fn signature(&self) -> &Signature {
        .ok()
        match out {
            number_rows: 5,
        let out = udf.invoke_with_args(args).unwrap();
    fn invoke_scalar_input_produces_scalar_output() {
    #[test]
        let out = udf.invoke_with_args(args).unwrap();
}
fn json_array_len(s: &str) -> Option<i32> {
                args.args.len()
use datafusion::arrow::datatypes::DataType;
        assert_eq!(json_array_len(""), None);
            ColumnarValue::Scalar(ScalarValue::Int32(Some(4))) => {}
        let mut builder = Int32Builder::with_capacity(n);
 * SPDX-License-Identifier: Apache-2.0
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
            return_field: Arc::new(Field::new("out", DataType::Int32, true)),
                _ => None,
            Some("[1,2,3]"),
                "json_array_length expects 1 argument, got {}",
        if let ColumnarValue::Scalar(sv) = &args.args[0] {
                | ScalarValue::LargeUtf8(opt)
        Ok(DataType::Int32)
        let strings = StringArrayView::from_array(&arr)?;
        for i in 0..n {
/*
        assert_eq!(json_array_len("[1,2,3]"), Some(3));
        assert!(arr.is_null(2));
            Some("not-json"),
        }
                "[1,2,3,4]".into(),
        }
        .and_then(|v| v.as_array().map(|a| a.len()))
        assert_eq!(json_array_len("[]"), Some(0));
impl Default for JsonArrayLengthUdf {
}
        // Int64 here works for literal args (Calcite const-folds and inserts a
use super::{coerce_args, CoerceMode};
#[derive(Debug, PartialEq, Eq, Hash)]
            return_field: Arc::new(Field::new("out", DataType::Int32, true)),
    }
            arg_fields: vec![],
        // path — caller sees Integer for literals, Long for column refs.
        assert!(udf.coerce_types(&[]).is_err());
    serde_json::from_str::<Value>(s)
        let args = ScalarFunctionArgs {
            Some("{\"k\":1}"),
        let udf = JsonArrayLengthUdf::new();
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
            );
}
 */
    }
        assert!(arr.is_null(1));
        };
    fn coerce_types_rejects_wrong_arity() {
            let len = match sv {
                Some(len) => builder.append_value(len),
        if arg_types.len() != 1 {
        let udf = JsonArrayLengthUdf::new();
            number_rows: 1,
}
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
    ctx.register_udf(ScalarUDF::from(JsonArrayLengthUdf::new()));
    }
            )))],
    #[test]
    }
    }
    #[test]
        let arr = args.args[0].clone().into_array(n)?;
    }
            args: vec![ColumnarValue::Scalar(ScalarValue::Utf8(Some(
        assert!(udf.coerce_types(&[DataType::Utf8, DataType::Utf8]).is_err());
        let udf = JsonArrayLengthUdf::new();
    }
    signature: Signature,
/// i32 matches PPL's declared INTEGER return type; arrays exceeding i32::MAX
        let arr = match out {
        &self.signature
                ScalarValue::Utf8(opt)
            Some("[]"),
        Self {
    #[test]
        assert_eq!(json_array_len("[\"a\",\"b\"]"), Some(2));
    }
        }
        }
        assert!(arr.is_null(3));
            other => panic!("expected Int32(Some(4)), got {other:?}"),
use datafusion::common::{plan_err, ScalarValue};
            return plan_err!(
 * The OpenSearch Contributors require contributions made to
    fn non_array_json_returns_none() {
            other => panic!("expected Int32(None), got {other:?}"),
    #[test]
//! `JsonArrayLengthFunctionImpl`; verified by `CalcitePPLJsonBuiltinFunctionIT.testJsonArrayLength`).
        assert_eq!(arr.value(4), 0);
        }
            ColumnarValue::Scalar(ScalarValue::Int32(None)) => {}
        if args.args.len() != 1 {
    fn malformed_json_returns_none() {
    }
    }
            return Ok(ColumnarValue::Scalar(ScalarValue::Int32(len)));
    use datafusion::arrow::array::{Array, Int32Array, StringArray};
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        coerce_args("json_array_length", arg_types, &[CoerceMode::Utf8])
