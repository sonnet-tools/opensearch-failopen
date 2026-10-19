            assert_eq!(result, DataType::Int64);
/// Coerce an entire argument vector against a fixed template. Enforces arity
pub mod rex_offset;
// `./gradlew :sandbox:libs:dataformat-native:buildRustLibrary --rerun-tasks`
pub mod json_array;
    json_extract_all::register_all(ctx);
            }
// Dev note: if a freshly added UDF here fails at runtime with
    #[test]
        let result = coerce_args("multi", &observed, &template).unwrap();
    grok::register_all(ctx);
                Self::new()
            }
pub mod strftime;
        for observed in [
pub mod json_extract_all;
    json_extend::register_all(ctx);
pub mod mvfind;
pub mod rex_extract_multi;
    }
    #[test]
    json_delete::register_all(ctx);
            fn eq(&self, _: &Self) -> bool {
        assert!(err.to_string().contains("expected integer or float"));
pub mod span_bucket;
        }
        .iter()
    use super::{coerce_args, coerce_slot, CoerceMode};
    fn float64_rejects_strings() {
            DataType::Utf8View,
/// produce a `plan_err!` naming the UDF, slot index, and observed type.
#[derive(Clone, Copy, Debug)]
            DataType::LargeUtf8,
    }
        },
        CoerceMode::Date32 => match observed {
                "{udf_name}: arg {slot_index} expected date/timestamp/string, got {other:?}"
            Utf8 | LargeUtf8 | Utf8View => Ok(observed.clone()),
    date_format::register_all(ctx);
            let err = coerce_slot("s", 0, &observed, CoerceMode::Utf8).unwrap_err();
pub mod json_extract;
use datafusion::arrow::datatypes::{DataType, TimeUnit};
    #[test]
    sha1::register_all(ctx);
    Date32,
    // ── TimestampMs ────────────────────────────────────────────────────────
pub mod minspan_bucket;
    json_keys::register_all(ctx);
    }
// native dylib is stale. `sandbox/libs/dataformat-native/build.gradle` tracks
            let result = coerce_slot("f", 0, &observed, CoerceMode::Float64).unwrap();
    template
    #[test]
pub mod json_array_length;
pub(crate) enum CoerceMode {
    fn float64_accepts_every_number() {
pub mod json_delete;
        let err = coerce_slot("i", 0, &DataType::Utf8, CoerceMode::Int64).unwrap_err();
    json_append::register_all(ctx);
    parse::register_all(ctx);
 * compatible open source license.
            DataType::Float64,
        let err = coerce_args("arity", &observed, &template).unwrap_err();
    conversion::register_all(ctx);
// and restart the OpenSearch JVM (the loaded dylib is JVM-cached).
        impl PartialEq for $udf {
            let result = coerce_slot("t", 0, &observed, CoerceMode::TimestampMs).unwrap();
    // performance-delegation). Calcite emits these into a shard filter's substrait; they are
pub mod width_bucket;
            }
        CoerceMode::Int64 => match observed {
    template: &[CoerceMode],
        }
        let err = coerce_slot("d", 0, &DataType::Float64, CoerceMode::Date32).unwrap_err();
        for observed in [DataType::Int64, DataType::Float64, DataType::Date32] {
        }
            DataType::Utf8,
        .map(|(i, mode)| coerce_slot(udf_name, i, &observed[i], *mode))
        let err = coerce_args("slot", &observed, &template).unwrap_err();
pub(crate) fn coerce_slot(
 * The OpenSearch Contributors require contributions made to
    }
            DataType::Date64,
            Timestamp(_, _) | Date32 | Date64 | Utf8 | LargeUtf8 | Utf8View => {
        }
    }
    Utf8,
            DataType::Int32,
pub mod makedate;
            other => plan_err!("{udf_name}: arg {slot_index} expected string, got {other:?}"),
                "TimestampMs should canonicalize {observed:?}"
    str_to_date::register_all(ctx);
        for observed in [
    time_format::register_all(ctx);
pub mod conv;
        impl Default for $udf {
//! have a matching YAML entry in `opensearch_scalar_functions.yaml`.
pub mod json_set;
            DataType::Timestamp(TimeUnit::Millisecond, None),
    width_bucket::register_all(ctx);
    #[test]
            DataType::Timestamp(TimeUnit::Microsecond, Some("UTC".into())),
    log::info!(
        .enumerate()
        assert!(
pub mod convert_tz;
use datafusion::execution::context::SessionContext;
/// Coerce a single argument slot. Returns the canonical target type for this
                plan_err!("{udf_name}: arg {slot_index} expected integer or float, got {other:?}")
 * this file be licensed under the Apache-2.0 license or a
    fn int64_rejects_strings() {
/// slot when the input is compatible, or a planning error otherwise.
    reduce_eval::register_all(ctx);
//! OpenSearch scalar UDFs not in DataFusion's builtins. Each registered UDF must
// UP-TO-DATE. Workaround: run
pub mod crc32;
/// Emit the `Default`, `PartialEq`, `Eq`, and `Hash` impls every stateless
        ] {
            DataType::Int16,
pub mod str_to_date;
            DataType::Date32,
        return plan_err!(
            );
        let observed = [DataType::Utf8, DataType::Int32];
        }
            DataType::Int64,
    extract::register_all(ctx);
    // ── Float64 ────────────────────────────────────────────────────────────
        "OpenSearch UDF register_all: convert_tz, conversion(numeric_conversion: num/auto/memk/rmcomma/rmunit/dur2sec/mstime, time_conversion: ctime/mktime), crc32, date_format, opensearch_extract, from_unixtime, item, json, json_append, json_array, json_array_length, json_delete, json_extend, json_extract, json_extract_all, json_keys, json_object, json_set, makedate, maketime, minspan_bucket, mvappend, mvfind, mvzip, parse, range_bucket, rex_extract, rex_extract_multi, rex_offset, sha1, span_bucket, str_to_date, strftime, time_format, width_bucket registered"
    }
mod tests {
    TimestampMs,
    use DataType::*;
    json_array::register_all(ctx);
    fn coerce_args_propagates_slot_errors() {
            other => plan_err!(
pub mod json_valid;
    mode: CoerceMode,
            DataType::Date32,
        },
    // ── Date32 ─────────────────────────────────────────────────────────────
}
            other => plan_err!(
}
            Int8 | Int16 | Int32 | Int64 | UInt8 | UInt16 | UInt32 | UInt64 | Float32 | Float64 => {
    fn date32_rejects_numeric() {
pub mod grok;
        CoerceMode::Float64 => match observed {
            DataType::Int8,
            DataType::UInt64,
        let observed = [DataType::Utf8];
pub mod rex_extract;
            }
            other => {
            err.to_string().contains("arg 1"),
    json_object::register_all(ctx);
    observed: &DataType,
pub mod from_unixtime;
}
            let result = coerce_slot("i", 0, &observed, CoerceMode::Int64).unwrap();
    //! the first caller.
                Ok(Timestamp(TimeUnit::Millisecond, None))
        let err = coerce_slot("t", 0, &DataType::Int64, CoerceMode::TimestampMs).unwrap_err();
            Date32 | Date64 | Timestamp(_, _) | Utf8 | LargeUtf8 | Utf8View => Ok(Date32),
    }
pub mod time_format;
            assert_eq!(
    }
            DataType::Date64,
    #[test]
pub mod date_format;
        },
    from_unixtime::register_all(ctx);
            DataType::Timestamp(TimeUnit::Second, None),
            DataType::Utf8,
    fn utf8_passes_string_variant_through_unchanged() {
        impl Eq for $udf {}
    //! `Date32`, `Int64`, or `Float64` inherit a proven helper rather than being
    fn coerce_args_maps_each_slot_through_its_mode() {
            assert!(err.to_string().contains("expected string"));
    udf_name: &str,
/// and delegates per-slot coercion to [`coerce_slot`].
    // ── Int64 ──────────────────────────────────────────────────────────────
            }
                "{udf_name}: arg {slot_index} expected timestamp/date/string, got {other:?}"
    json_set::register_all(ctx);
    match mode {
        let template = [CoerceMode::Utf8, CoerceMode::Utf8];
    //! cover every mode's accept + reject paths so future UDFs that pick up
    mvzip::register_all(ctx);
    ip_to_string::register_all(ctx);
    makedate::register_all(ctx);
        assert!(err.to_string().contains("expected integer or float"));
            );
    os_week::register_all(ctx);
    fn int64_accepts_every_number() {
) -> Result<DataType> {
    fn utf8_rejects_numeric_and_temporal() {
        for observed in [
        }
            DataType::Float64,
pub(crate) mod os_strftime;
            }
    fn coerce_args_rejects_arity_mismatch() {
    rex_offset::register_all(ctx);
                result, observed,
                result,
        DataType::Timestamp(TimeUnit::Millisecond, None)
    use datafusion::arrow::datatypes::{DataType, TimeUnit};
    udf_name: &str,
        assert!(err.to_string().contains("expected date/timestamp/string"));
    #[test]
pub(crate) fn coerce_args(
/// Input-type categories for UDF argument slots. Each mode declares a canonical
        let template = [CoerceMode::Utf8, CoerceMode::Int64];
    // PARSE them: a coordinator-reduce session derives the producer (shard) plan's output schema
    // ── coerce_args ────────────────────────────────────────────────────────
    }
    maketime::register_all(ctx);
            assert_eq!(result, DataType::Date32);
        }
            fn default() -> Self {
                ts_ms(),
    rex_extract::register_all(ctx);
    #[test]
        impl std::hash::Hash for $udf {
use datafusion::error::Result;
pub mod maketime;
            DataType::LargeUtf8,
            ),
    // Delegation markers (index_filter = correctness-delegation, delegation_possible =
    ctx.register_udf(crate::indexed_table::substrait_to_tree::create_index_filter_udf());
        assert!(err.to_string().contains("expected timestamp/date/string"));
pub mod item;
        );
            Int8 | Int16 | Int32 | Int64 | UInt8 | UInt16 | UInt32 | UInt64 | Float32 | Float64 => {
    fn ts_ms() -> DataType {
            assert_eq!(
    convert_tz::register_all(ctx);
    slot_index: usize,
    }
    json_array_length::register_all(ctx);
            assert_eq!(result, DataType::Float64);
    json::register_all(ctx);
/// arrow target type plus the set of sources that coerce to it; invalid sources
pub(crate) mod json_common;
                Ok(Float64)
    ($udf:ident, $name:literal) => {
    //! `TimestampMs` and `Utf8` through its public `coerce_types`; these tests
    minspan_bucket::register_all(ctx);
pub mod mvzip;
pub mod sha1;
    json_extract::register_all(ctx);
        let template = [CoerceMode::TimestampMs, CoerceMode::Int64];
            DataType::Float32,
    Float64,
    }
            let result = coerce_slot("d", 0, &observed, CoerceMode::Date32).unwrap();
            DataType::Utf8View,
            }
}
        },
pub mod pattern_parser;
    #[test]
    // ── Utf8 ───────────────────────────────────────────────────────────────
pub fn register_all(ctx: &SessionContext) {
macro_rules! udf_identity {
        for observed in [
    }
        assert!(err.to_string().contains("expects 2 arguments, got 1"));
pub mod os_week;
        for observed in [DataType::Utf8, DataType::LargeUtf8, DataType::Utf8View] {
pub mod conversion;
        ] {
            DataType::Float32,
            }
    #[test]
    // via derive_schema_from_partial_plan, which builds the producer's physical plan and fails on
pub mod binary_to_base64;
) -> Result<Vec<DataType>> {
                true
            template.len(),
 *
    // unwrapped/executed ONLY on the data-node indexed path. But every session must be able to
                Ok(Int64)
        CoerceMode::TimestampMs => match observed {
/*
#[allow(dead_code)]
            DataType::UInt32,
        .collect()
            observed.len()
    }
    rex_extract_multi::register_all(ctx);
pub mod range_bucket;
            "{udf_name} expects {} arguments, got {}",
pub mod json_append;
        },
pub mod mvappend;
            DataType::UInt32,
    strftime::register_all(ctx);
            let result = coerce_slot("s", 0, &observed, CoerceMode::Utf8).unwrap();
    // ever actually invoked (they never are off the indexed path).
                "CoerceMode::Utf8 should pass the variant through"
        }
            "error must name the failing slot index, got: {err}"
            fn hash<H: std::hash::Hasher>(&self, state: &mut H) {
    #[test]
    };
        CoerceMode::Utf8 => match observed {
    //! Direct tests for the [`CoerceMode`] helper library. `convert_tz` exercises
        assert_eq!(result, vec![ts_ms(), DataType::Int64]);
// only common/ + lib/ as inputs, so plugin-side Rust edits leave gradle
    #[test]
    #[test]
        ] {
/// UDF needs. All instances of the same UDF type are semantically identical
use datafusion::common::plan_err;
pub mod json;
            DataType::UInt8,
pub mod json_keys;
 * SPDX-License-Identifier: Apache-2.0
    fn timestampms_rejects_numeric() {
pub mod reduce_eval;
    );
    fn timestampms_accepts_every_temporal_source() {
pub mod json_extend;
pub(crate) use udf_identity;
pub mod ip_to_string;
            DataType::UInt16,
        ] {
            DataType::Int32,
 */
    item::register_all(ctx);
            ),
    fn date32_accepts_date_and_string_sources() {
            other => {
    mvappend::register_all(ctx);
    Int64,
}
        );
pub mod parse;
    ctx.register_udf(crate::indexed_table::substrait_to_tree::create_delegation_possible_udf());
// "Unsupported function name: <X>" despite the Java side being wired, the
                plan_err!("{udf_name}: arg {slot_index} expected integer or float, got {other:?}")
    }
pub mod extract;
        let err = coerce_slot("f", 0, &DataType::Utf8, CoerceMode::Float64).unwrap_err();
        let observed = [DataType::Utf8, DataType::Utf8];
    conv::register_all(ctx);
    mvfind::register_all(ctx);
}
                $name.hash(state);
/// — they compare equal and hash to a single name-derived stable value.
            DataType::Int64,
    observed: &[DataType],
    }
    range_bucket::register_all(ctx);
    // an unregistered function. Register here so all sessions can parse; the bodies still error if
pub mod json_object;
#[cfg(test)]
    json_valid::register_all(ctx);
    binary_to_base64::register_all(ctx);
        }
    pattern_parser::register_all(ctx);
    }
    if observed.len() != template.len() {
    span_bucket::register_all(ctx);
    crc32::register_all(ctx);
