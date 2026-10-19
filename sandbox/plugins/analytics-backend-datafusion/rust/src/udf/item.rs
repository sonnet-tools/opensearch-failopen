        }
        if arg_types.len() != 2 {
                if !keys.is_null(j) && keys.value(j) == key {
    use super::*;
    fn returns_null_for_null_key_scalar() {
    fn coerce_types(&self, arg_types: &[DataType]) -> Result<Vec<DataType>> {
        ]);
        // inspecting arg_types[0]'s Map<…, V> value field; deferred until a
//!     `MAP[key]` convention and the legacy PPL `RegexExpression` behaviour
impl Default for ItemUdf {
            udf.return_type(&[map_dt, DataType::Utf8]).unwrap(),
use datafusion::common::{plan_err, ScalarValue};
        // First arg passes through as-is — DataFusion's substrait consumer
    }
        let entries = Arc::new(Field::new(
use datafusion::logical_expr::{
        // simpler rather than micro-optimised.
        return None;
            match row {
        let scalar_key = scalar_str(&args.args[1]);
            Some(args.args[1].clone().into_array(n)?)
    ctx.register_udf(ScalarUDF::from(ItemUdf::new()));
//! PPL `parse <field> '<regex>'` lowers each named group to
            map,
                    found = true;
            }),
        builder.finish()
        let map = build_map(vec![Some(vec![("a", "1")])]);
                "item: arg 0 expected MapArray, got {:?}",
        })?;
        // Pull it once here; column-valued keys are rare so the slow path is
            .coerce_types(&[DataType::Utf8, DataType::Utf8])
        );
                    for (k, v) in entries {
        } else {
}
            let mut found = false;
// ─── tests ──────────────────────────────────────────────────────────────────
    fn coerce_types_rejects_non_map_first_arg() {
        ));
        }
    use datafusion::arrow::datatypes::Field;
    }
        let key_target = match arg_types[1] {
            }
//!     observable "" downstream because the parse UDF stores "" rather than
    pub fn new() -> Self {
                    }
    }
        let out = run(map, ColumnarValue::Scalar(ScalarValue::Utf8(None)));
/*
                    }
                    builder.append(false).unwrap();
#[derive(Debug, PartialEq, Eq, Hash)]
    fn default() -> Self {
        // canonicalises to Utf8 so column-valued keys (string view, large
            config_options: Arc::new(datafusion::config::ConfigOptions::new()),
            ref other => return plan_err!("item: arg 1 must be a string key, got {other:?}"),
            let keys = entries
use datafusion::arrow::array::{Array, ArrayRef, MapArray, StringArray, StringBuilder};
            ))
                        builder.append_null();
            StringBuilder::new(),
        // hits this, since the named-group identifier is a string literal).
                }
        let key = Arc::new(Field::new("key", DataType::Utf8, false));
                        builder.keys().append_value(k);
        let n = map.len();
        let key_arr_ref: Option<ArrayRef> = if scalar_key.is_none() {
    };
                    } else {
    }
                .as_any()
                _ => {
    fn return_type_is_value_type_of_map() {
use datafusion::error::{DataFusionError, Result};
        }
        };
        let n = args.number_rows;
            "entries",
        if arg_types.len() != 2 {
            ColumnarValue::Array(a) => a.as_any().downcast_ref::<StringArray>().unwrap().clone(),
            if map.is_null(i) {
            opt.clone()
                    break;
        let map = build_map(vec![Some(vec![("a", "1")])]);
                .as_any()
        let mut builder = StringBuilder::with_capacity(n, 0);
        let map = build_map(vec![Some(vec![("a", "1"), ("b", "2")])]);
    #[test]
        let out = run(map, ColumnarValue::Array(Arc::new(key_arr)));
//! `item(map, key)` — extract a value from a `map<utf8, utf8>` by key. Lowering
use datafusion::arrow::datatypes::DataType;
        assert_eq!(out.value(0), "2");
            .unwrap_err();
                }
            return plan_err!("item expects 2 arguments, got {}", arg_types.len());
}
                Some(entries) => {
    }
        let map_dt = map.data_type().clone();
        let key = Arc::new(Field::new("key", DataType::Utf8, false));
    }
        ));
        let udf = ItemUdf::new();
    match sv {
        // ITEM already produces it with the right shape. Second arg
    }
#[cfg(test)]
                (None, Some(a)) if !a.is_null(i) => a.value(i),
        // Inner value type is what we return — the only producer in scope is
                entry: "entries".to_string(),
            let key: &str = match (&scalar_key, key_arr) {
        let map_arr = args.args[0].clone().into_array(n)?;
                        builder.append_value(values.value(j));
            Some(vec![("a", "1"), ("b", "2")]),
    }
    fn returns_null_for_absent_key() {
    }
            // the underlying StructArray. Walk those entries linearly looking
        let _ = map_dt;
 * SPDX-License-Identifier: Apache-2.0
            args: vec![ColumnarValue::Array(Arc::new(map)), key],
//!   * Key cell is null → NULL output (no entry can match a NULL key).
        );
            DataType::Struct(vec![key, value].into()),
        // second Map producer needs it.
        let args = ScalarFunctionArgs {
            // for the requested key. Linear walk is fine for the parse use
        let udf = ItemUdf::new();
            ColumnarValue::Scalar(ScalarValue::Utf8(Some("a".into()))),
    }
    #[test]
    fn name(&self) -> &str {
        Self::new()
fn scalar_str(cv: &ColumnarValue) -> Option<String> {
                None => {
            if !found {
                (Some(k), _) => k.as_str(),
        let err = udf.coerce_types(&[map_dt, DataType::Int32]).unwrap_err();
pub struct ItemUdf {
                value: "value".to_string(),
pub fn register_all(ctx: &SessionContext) {
            DataType::Utf8 | DataType::LargeUtf8 | DataType::Utf8View => DataType::Utf8,
        let value = Arc::new(Field::new("value", DataType::Utf8, true));
        }
//! `INTERNAL_ITEM(INTERNAL_PARSE(...), '<group>')`, which DataFusionFragmentConvertor
//! adapter — keep this UDF focused so the error message stays specific.
            let values = entries
        Ok(vec![arg_types[0].clone(), key_target])
            arg_fields: vec![],
            // case because the map has at most a handful of named groups.
                .downcast_ref::<StringArray>()
        "item"
            false,
use std::sync::Arc;
                .ok_or_else(|| DataFusionError::Internal("item: map keys are not Utf8".into()))?;
    }
        for i in 0..n {
                builder.append_null();
impl ScalarUDFImpl for ItemUdf {
            _ => panic!("expected array"),
}
    }
//! `parse` UDF). Calcite's `ITEM` is also defined on arrays, but PPL never
    fn run(map: MapArray, key: ColumnarValue) -> StringArray {
            false,
            number_rows: n,
            None
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
                }
}
            "entries",
        );
        let map = build_map(vec![
 *
    #[test]
            return plan_err!("item: arg 0 must be a Map type, got {:?}", arg_types[0]);
    let ColumnarValue::Scalar(sv) = cv else {
        let entries = Arc::new(Field::new(
        let map_dt = DataType::Map(entries, false);
            }
}
        if args.args.len() != 2 {
 * The OpenSearch Contributors require contributions made to
        Self {
//! target for Calcite's `SqlStdOperatorTable.ITEM` operator on map operands.
}
            return plan_err!("item expects 2 arguments, got {}", args.args.len());
    #[test]
//!
            }
            };
        assert_eq!(out.value(1), "3");
        let map_dt = DataType::Map(entries, false);
        let mut builder = MapBuilder::new(
    }
    signature: Signature,
        assert!(out.is_null(0));
    #[test]
    }
        let key_arr: Option<&StringArray> = key_arr_ref
        let out = run(
        let key_arr = StringArray::from(vec![Some("b"), Some("a")]);
        // Fast-path the common case: literal key (every PPL parse → ITEM call
                continue;
    }
        // string) work uniformly.
        }
            map,
            Some(MapFieldNames {
        if !matches!(arg_types[0], DataType::Map(_, _)) {
            ColumnarValue::Scalar(ScalarValue::Utf8(Some("a".into()))),
                    builder.append(true).unwrap();
        assert_eq!(
                }
//!     other Map producer).
        };
    }
//!   * Map cell is null → NULL output.
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, Volatility,
            signature: Signature::user_defined(Volatility::Immutable),
            for j in 0..entries.len() {
    use datafusion::arrow::array::{MapBuilder, MapFieldNames};
            return_field: Arc::new(Field::new("out", DataType::Utf8, true)),
                .column(1)
    fn signature(&self) -> &Signature {
        let err = udf
                key: "key".to_string(),
        assert!(err.to_string().contains("must be a Map type"));
    #[test]
};
//!     that produces "" for absent groups; PPL adapts this to the same
    fn coerce_types_rejects_non_string_key() {
//!
                .column(0)
}
        let map = build_map(vec![None]);
        );
        Ok(DataType::Utf8)
impl ItemUdf {
        let udf = ItemUdf::new();
    fn handles_column_valued_keys_per_row() {
            DataType::Utf8
            DataType::Struct(vec![key, value].into()),
                    builder.append_null();
        Ok(ColumnarValue::Array(Arc::new(builder.finish()) as ArrayRef))
        ScalarValue::Utf8(opt) | ScalarValue::LargeUtf8(opt) | ScalarValue::Utf8View(opt) => {
            StringBuilder::new(),
//! routes to this UDF via the `item` extension name.
        };
//! emits the array form on the parse path, and array indexing doesn't share an
use datafusion::execution::context::SessionContext;
            .as_ref()
        let out = run(
        let out = udf.invoke_with_args(args).unwrap();
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        &self.signature
        let value = Arc::new(Field::new("value", DataType::Utf8, true));
        }
    }
        }
        match out {
//!   * Key not present in the map → SQL NULL output (matches Calcite's
                map_arr.data_type(),
            // MapArray entries for row i live at offsets[i]..offsets[i+1] of
            Some(vec![("a", "3")]),
                    continue;
                    if values.is_null(j) {
        let map = map_arr.as_any().downcast_ref::<MapArray>().ok_or_else(|| {
        }
            DataFusionError::Internal(format!(
        assert!(out.is_null(0));
    #[test]
            map,
 */
                        builder.values().append_value(v);
    fn build_map(rows: Vec<Option<Vec<(&str, &str)>>>) -> MapArray {
    fn returns_null_for_null_map_cell() {
        let out = run(
        // can't reconstruct a Map<…, …> through CoerceMode and Calcite's
        assert_eq!(out.value(0), "1");
//! Scope: maps from utf8 keys to utf8 values only (the type produced by the
        assert!(out.is_null(0));
        );
                .downcast_ref::<StringArray>()
    fn returns_value_for_present_key() {
mod tests {
        let udf = ItemUdf::new();
    #[test]
        _ => None,
        for row in rows {
            }
//!     omitting the key, but `item` itself stays NULL-on-absent for any
    fn return_type(&self, arg_types: &[DataType]) -> Result<DataType> {
//! Semantics:
        assert!(err.to_string().contains("must be a string key"));
                builder.append_null();
                .ok_or_else(|| DataFusionError::Internal("item: map values are not Utf8".into()))?;
            ColumnarValue::Scalar(ScalarValue::Utf8(Some("missing".into()))),
        }
    }
            .and_then(|a| a.as_any().downcast_ref::<StringArray>());
        // `parse` (utf8 values), so we hard-code Utf8 here. Generalising means
            return plan_err!("item expects 2 arguments, got {}", arg_types.len());
            let entries = map.value(i);
