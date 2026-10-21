        );
        let entries = Arc::new(Field::new(
    }
                .downcast_ref::<StringArray>()
        // hits this, since the named-group identifier is a string literal).
            match row {
                "item: arg 0 expected MapArray, got {:?}",
                }
        // ITEM already produces it with the right shape. Second arg
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
            StringBuilder::new(),
            DataType::Utf8
        let key_arr: Option<&StringArray> = key_arr_ref
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
            args: vec![ColumnarValue::Array(Arc::new(map)), key],
    signature: Signature,
        let n = map.len();
        };
        );
//! Semantics:
            udf.return_type(&[map_dt, DataType::Utf8]).unwrap(),
        }
                .as_any()
            Some(vec![("a", "3")]),
                .ok_or_else(|| DataFusionError::Internal("item: map keys are not Utf8".into()))?;
    }
            // the underlying StructArray. Walk those entries linearly looking
        );
        );
    #[test]
//!     observable "" downstream because the parse UDF stores "" rather than
        Self::new()
        let out = run(
    #[test]
            map,
 * compatible open source license.
use datafusion::common::{plan_err, ScalarValue};
        assert!(out.is_null(0));
        // second Map producer needs it.
        // canonicalises to Utf8 so column-valued keys (string view, large
    fn returns_null_for_null_key_scalar() {
            number_rows: n,
    use datafusion::arrow::datatypes::Field;
                if !keys.is_null(j) && keys.value(j) == key {
            // MapArray entries for row i live at offsets[i]..offsets[i+1] of
        // Inner value type is what we return — the only producer in scope is
        }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
            let key: &str = match (&scalar_key, key_arr) {
            ColumnarValue::Scalar(ScalarValue::Utf8(Some("a".into()))),
                        builder.append_null();
    fn default() -> Self {
                    found = true;
#[derive(Debug, PartialEq, Eq, Hash)]
            ))
        // Fast-path the common case: literal key (every PPL parse → ITEM call
        }
    }
        let key = Arc::new(Field::new("key", DataType::Utf8, false));
        let udf = ItemUdf::new();
        "item"
impl ScalarUDFImpl for ItemUdf {
                    break;
            Some(args.args[1].clone().into_array(n)?)
    }
            Some(vec![("a", "1"), ("b", "2")]),
                Some(entries) => {
            }
        return None;
use datafusion::logical_expr::{
//! adapter — keep this UDF focused so the error message stays specific.
                        builder.keys().append_value(k);
            let mut found = false;
            map,
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
                    builder.append(true).unwrap();
                (None, Some(a)) if !a.is_null(i) => a.value(i),
        let key_target = match arg_types[1] {
//!     that produces "" for absent groups; PPL adapts this to the same
        }
            DataType::Struct(vec![key, value].into()),
        builder.finish()
//!
            false,
            DataFusionError::Internal(format!(
                None => {
        // First arg passes through as-is — DataFusion's substrait consumer
    };
                }
        }
        // `parse` (utf8 values), so we hard-code Utf8 here. Generalising means
    }
            DataType::Struct(vec![key, value].into()),
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
            }
    pub fn new() -> Self {
    fn coerce_types_rejects_non_string_key() {
                map_arr.data_type(),
//! target for Calcite's `SqlStdOperatorTable.ITEM` operator on map operands.
        if arg_types.len() != 2 {
                builder.append_null();
        let key = Arc::new(Field::new("key", DataType::Utf8, false));
    }
                    }
            ref other => return plan_err!("item: arg 1 must be a string key, got {other:?}"),
        let n = args.number_rows;
    }
//!   * Map cell is null → NULL output.
use datafusion::execution::context::SessionContext;
        assert_eq!(
        let udf = ItemUdf::new();
        let out = run(map, ColumnarValue::Scalar(ScalarValue::Utf8(None)));
                value: "value".to_string(),
        let map = build_map(vec![Some(vec![("a", "1"), ("b", "2")])]);
        let out = run(
                .as_any()
        if args.args.len() != 2 {
                .downcast_ref::<StringArray>()
use datafusion::arrow::datatypes::DataType;
        let map_dt = map.data_type().clone();
    }
        for i in 0..n {
        for row in rows {
        let out = udf.invoke_with_args(args).unwrap();
        }
            };
            return plan_err!("item expects 2 arguments, got {}", args.args.len());
        ));
//!   * Key not present in the map → SQL NULL output (matches Calcite's
        }
        let err = udf.coerce_types(&[map_dt, DataType::Int32]).unwrap_err();
    fn returns_null_for_null_map_cell() {
        // simpler rather than micro-optimised.
            .unwrap_err();
        );
 * The OpenSearch Contributors require contributions made to
        match out {
        })?;
        let map = map_arr.as_any().downcast_ref::<MapArray>().ok_or_else(|| {
        let map_arr = args.args[0].clone().into_array(n)?;
                (Some(k), _) => k.as_str(),
        if arg_types.len() != 2 {
    fn return_type_is_value_type_of_map() {
 */
impl Default for ItemUdf {
    }
        let args = ScalarFunctionArgs {
            "entries",
/*
            arg_fields: vec![],
        let scalar_key = scalar_str(&args.args[1]);
            .coerce_types(&[DataType::Utf8, DataType::Utf8])
        }
use datafusion::arrow::array::{Array, ArrayRef, MapArray, StringArray, StringBuilder};
    }
                    builder.append_null();
            None
        assert!(err.to_string().contains("must be a string key"));
//! emits the array form on the parse path, and array indexing doesn't share an
            opt.clone()
    }
            // for the requested key. Linear walk is fine for the parse use
    fn returns_null_for_absent_key() {
                    for (k, v) in entries {
            if !found {
        // string) work uniformly.
//! `INTERNAL_ITEM(INTERNAL_PARSE(...), '<group>')`, which DataFusionFragmentConvertor
        Ok(vec![arg_types[0].clone(), key_target])
 *
        let key_arr = StringArray::from(vec![Some("b"), Some("a")]);
 * this file be licensed under the Apache-2.0 license or a
pub struct ItemUdf {
//! routes to this UDF via the `item` extension name.
        };
            .as_ref()
    ctx.register_udf(ScalarUDF::from(ItemUdf::new()));
            // case because the map has at most a handful of named groups.
            "entries",
    #[test]
    use super::*;
    #[test]
        ]);
                        builder.values().append_value(v);
    #[test]
    use datafusion::arrow::array::{MapBuilder, MapFieldNames};
//!   * Key cell is null → NULL output (no entry can match a NULL key).
            return_field: Arc::new(Field::new("out", DataType::Utf8, true)),
//! `parse` UDF). Calcite's `ITEM` is also defined on arrays, but PPL never
//!     `MAP[key]` convention and the legacy PPL `RegexExpression` behaviour
                entry: "entries".to_string(),
//! PPL `parse <field> '<regex>'` lowers each named group to
        let out = run(
                .column(1)
    }
}
                _ => {
    }
    fn coerce_types_rejects_non_map_first_arg() {
    }
        let value = Arc::new(Field::new("value", DataType::Utf8, true));
        let udf = ItemUdf::new();
use std::sync::Arc;
        let value = Arc::new(Field::new("value", DataType::Utf8, true));
//!     omitting the key, but `item` itself stays NULL-on-absent for any
}
        let mut builder = StringBuilder::with_capacity(n, 0);
//! Scope: maps from utf8 keys to utf8 values only (the type produced by the
        // Pull it once here; column-valued keys are rare so the slow path is
    fn name(&self) -> &str {
            let values = entries
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        &self.signature
    let ColumnarValue::Scalar(sv) = cv else {
        let err = udf
}
        let key_arr_ref: Option<ArrayRef> = if scalar_key.is_none() {
    fn returns_value_for_present_key() {
// ─── tests ──────────────────────────────────────────────────────────────────
}
        Ok(DataType::Utf8)
 * SPDX-License-Identifier: Apache-2.0
        let mut builder = MapBuilder::new(
        let _ = map_dt;
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
#[cfg(test)]
                }
                }
    }
    #[test]
            _ => panic!("expected array"),
//! `item(map, key)` — extract a value from a `map<utf8, utf8>` by key. Lowering
            }
    #[test]
        // inspecting arg_types[0]'s Map<…, V> value field; deferred until a
        let out = run(map, ColumnarValue::Array(Arc::new(key_arr)));
}
};
fn scalar_str(cv: &ColumnarValue) -> Option<String> {
}
                .ok_or_else(|| DataFusionError::Internal("item: map values are not Utf8".into()))?;
        if !matches!(arg_types[0], DataType::Map(_, _)) {
        let map = build_map(vec![Some(vec![("a", "1")])]);
            return plan_err!("item expects 2 arguments, got {}", arg_types.len());
        assert_eq!(out.value(1), "3");
                .column(0)
    fn handles_column_valued_keys_per_row() {
        assert!(out.is_null(0));
use datafusion::error::{DataFusionError, Result};
        let map = build_map(vec![
        } else {
    fn build_map(rows: Vec<Option<Vec<(&str, &str)>>>) -> MapArray {
            if map.is_null(i) {
            return plan_err!("item expects 2 arguments, got {}", arg_types.len());
            let entries = map.value(i);
                    }
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        // can't reconstruct a Map<…, …> through CoerceMode and Calcite's
            Some(MapFieldNames {
        let udf = ItemUdf::new();
        ));
    }
            ColumnarValue::Scalar(ScalarValue::Utf8(Some("missing".into()))),
                    } else {
        let map = build_map(vec![Some(vec![("a", "1")])]);
                    continue;
        }
            StringBuilder::new(),
            .and_then(|a| a.as_any().downcast_ref::<StringArray>());
}
pub fn register_all(ctx: &SessionContext) {
        assert_eq!(out.value(0), "2");
            for j in 0..entries.len() {
    }
mod tests {
                    builder.append(false).unwrap();
                continue;
            false,
            return plan_err!("item: arg 0 must be a Map type, got {:?}", arg_types[0]);
            }
        Self {
        assert!(out.is_null(0));
        let entries = Arc::new(Field::new(
                builder.append_null();
    fn run(map: MapArray, key: ColumnarValue) -> StringArray {
    }
                        builder.append_value(values.value(j));
            }),
                key: "key".to_string(),
impl ItemUdf {
            let keys = entries
                    if values.is_null(j) {
        };
        _ => None,
            signature: Signature::user_defined(Volatility::Immutable),
    #[test]
//!
    fn signature(&self) -> &Signature {
            map,
        assert!(err.to_string().contains("must be a Map type"));
        let map_dt = DataType::Map(entries, false);
            ColumnarValue::Array(a) => a.as_any().downcast_ref::<StringArray>().unwrap().clone(),
            ColumnarValue::Scalar(ScalarValue::Utf8(Some("a".into()))),
        let map_dt = DataType::Map(entries, false);
        assert_eq!(out.value(0), "1");
//!     other Map producer).
        let map = build_map(vec![None]);
    match sv {
