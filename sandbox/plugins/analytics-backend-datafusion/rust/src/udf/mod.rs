    convert_tz::register_all(ctx);
    rex_extract::register_all(ctx);
pub mod rex_offset;
    rex_offset::register_all(ctx);
            other => {
pub mod from_unixtime;
            }
    fn int64_rejects_strings() {
}
pub(crate) use udf_identity;
    strftime::register_all(ctx);
    // via derive_schema_from_partial_plan, which builds the producer's physical plan and fails on
    rex_extract_multi::register_all(ctx);
        let template = [CoerceMode::TimestampMs, CoerceMode::Int64];
        for observed in [DataType::Utf8, DataType::LargeUtf8, DataType::Utf8View] {
        let err = coerce_slot("f", 0, &DataType::Utf8, CoerceMode::Float64).unwrap_err();
pub mod json_valid;
    json::register_all(ctx);
        );
    udf_name: &str,
    slot_index: usize,
        .iter()
pub(crate) enum CoerceMode {
    fn timestampms_accepts_every_temporal_source() {
pub mod extract;
pub mod binary_to_base64;
}
pub mod item;
        }
            fn eq(&self, _: &Self) -> bool {
    #[test]
    template
    }
            fn hash<H: std::hash::Hasher>(&self, state: &mut H) {
            assert_eq!(
        }
    width_bucket::register_all(ctx);
/// arrow target type plus the set of sources that coerce to it; invalid sources
    #[test]
            assert_eq!(result, DataType::Date32);
pub mod ip_to_string;
    //! `Date32`, `Int64`, or `Float64` inherit a proven helper rather than being
            DataType::Date64,
            "{udf_name} expects {} arguments, got {}",
pub mod time_format;
        impl PartialEq for $udf {
        },
            other => plan_err!("{udf_name}: arg {slot_index} expected string, got {other:?}"),
    Float64,
        for observed in [
    }
pub mod minspan_bucket;
pub(crate) mod json_common;
        },
        ] {
    json_keys::register_all(ctx);
        assert!(err.to_string().contains("expected date/timestamp/string"));
    mvappend::register_all(ctx);
    conversion::register_all(ctx);
pub(crate) fn coerce_args(
    // ── coerce_args ────────────────────────────────────────────────────────
            }
 *
    Date32,
        .map(|(i, mode)| coerce_slot(udf_name, i, &observed[i], *mode))
    span_bucket::register_all(ctx);
            DataType::Date32,
        }
    grok::register_all(ctx);
            DataType::UInt16,
pub mod json;
pub mod json_append;
            DataType::Float32,
            DataType::LargeUtf8,
                Ok(Int64)
            observed.len()
    };
    }
        .collect()
pub mod grok;
            Date32 | Date64 | Timestamp(_, _) | Utf8 | LargeUtf8 | Utf8View => Ok(Date32),
// "Unsupported function name: <X>" despite the Java side being wired, the
pub mod json_extend;
// and restart the OpenSearch JVM (the loaded dylib is JVM-cached).
            DataType::Int16,
            DataType::Timestamp(TimeUnit::Microsecond, Some("UTC".into())),
    item::register_all(ctx);
/// and delegates per-slot coercion to [`coerce_slot`].
    #[test]
    fn utf8_passes_string_variant_through_unchanged() {
                "CoerceMode::Utf8 should pass the variant through"
    // performance-delegation). Calcite emits these into a shard filter's substrait; they are
    fn timestampms_rejects_numeric() {
    }
    Utf8,
    binary_to_base64::register_all(ctx);
            DataType::Date32,
            );
            DataType::Int64,
pub mod mvappend;
/// slot when the input is compatible, or a planning error otherwise.
            DataType::UInt64,
            DataType::Float32,
            DataType::UInt8,
    //! `TimestampMs` and `Utf8` through its public `coerce_types`; these tests
        },
    json_extract_all::register_all(ctx);
            template.len(),
            DataType::Float64,
pub mod rex_extract_multi;
/// Coerce a single argument slot. Returns the canonical target type for this
                true
    extract::register_all(ctx);
    json_extract::register_all(ctx);
        assert!(err.to_string().contains("expected integer or float"));
                "TimestampMs should canonicalize {observed:?}"
            let result = coerce_slot("f", 0, &observed, CoerceMode::Float64).unwrap();
    os_week::register_all(ctx);
            Utf8 | LargeUtf8 | Utf8View => Ok(observed.clone()),
    // Delegation markers (index_filter = correctness-delegation, delegation_possible =
        assert!(
    fn coerce_args_maps_each_slot_through_its_mode() {
        for observed in [DataType::Int64, DataType::Float64, DataType::Date32] {
pub fn register_all(ctx: &SessionContext) {
use datafusion::execution::context::SessionContext;
            DataType::UInt32,
            Int8 | Int16 | Int32 | Int64 | UInt8 | UInt16 | UInt32 | UInt64 | Float32 | Float64 => {
) -> Result<DataType> {
                $name.hash(state);
}
        }
        let err = coerce_args("slot", &observed, &template).unwrap_err();
    fn utf8_rejects_numeric_and_temporal() {
#[cfg(test)]
    }
    fn float64_accepts_every_number() {
    use datafusion::arrow::datatypes::{DataType, TimeUnit};
        for observed in [
        assert!(err.to_string().contains("expects 2 arguments, got 1"));
            assert!(err.to_string().contains("expected string"));
use datafusion::error::Result;
    // ever actually invoked (they never are off the indexed path).
    // ── Float64 ────────────────────────────────────────────────────────────
            assert_eq!(result, DataType::Int64);
}
    // ── Int64 ──────────────────────────────────────────────────────────────
                Ok(Float64)
    json_delete::register_all(ctx);
    #[test]
    if observed.len() != template.len() {
        CoerceMode::Float64 => match observed {
pub mod rex_extract;
pub(crate) fn coerce_slot(
// only common/ + lib/ as inputs, so plugin-side Rust edits leave gradle
    }
 * SPDX-License-Identifier: Apache-2.0
// UP-TO-DATE. Workaround: run
    pattern_parser::register_all(ctx);
pub mod reduce_eval;
    crc32::register_all(ctx);
        let observed = [DataType::Utf8, DataType::Int32];
        .enumerate()
    );
            ),
pub mod conv;
pub mod date_format;
#[derive(Clone, Copy, Debug)]
/// Emit the `Default`, `PartialEq`, `Eq`, and `Hash` impls every stateless
        }
    }
 * compatible open source license.
            DataType::Utf8,
pub mod crc32;
            DataType::Timestamp(TimeUnit::Second, None),
    mvzip::register_all(ctx);
        for observed in [
pub mod json_delete;
        DataType::Timestamp(TimeUnit::Millisecond, None)
        assert_eq!(result, vec![ts_ms(), DataType::Int64]);
            DataType::Utf8View,
            }
                plan_err!("{udf_name}: arg {slot_index} expected integer or float, got {other:?}")
            DataType::Int64,
        assert!(err.to_string().contains("expected integer or float"));
    log::info!(
    match mode {
                result, observed,
        }
    mvfind::register_all(ctx);
    }
            let result = coerce_slot("d", 0, &observed, CoerceMode::Date32).unwrap();
pub mod span_bucket;
        return plan_err!(
    //! the first caller.
    #[test]
            DataType::Int32,
    Int64,
        assert!(err.to_string().contains("expected timestamp/date/string"));
            }
pub mod range_bucket;
            let result = coerce_slot("t", 0, &observed, CoerceMode::TimestampMs).unwrap();
        let observed = [DataType::Utf8, DataType::Utf8];
            DataType::Date64,
    time_format::register_all(ctx);
            let result = coerce_slot("i", 0, &observed, CoerceMode::Int64).unwrap();
// native dylib is stale. `sandbox/libs/dataformat-native/build.gradle` tracks
// Dev note: if a freshly added UDF here fails at runtime with
    // ── Date32 ─────────────────────────────────────────────────────────────
 * The OpenSearch Contributors require contributions made to
    }
            ),
    mode: CoerceMode,
    sha1::register_all(ctx);
    observed: &[DataType],
            DataType::Int8,
    ctx.register_udf(crate::indexed_table::substrait_to_tree::create_delegation_possible_udf());
    fn date32_accepts_date_and_string_sources() {
    observed: &DataType,
    fn coerce_args_propagates_slot_errors() {
pub mod json_array_length;
    maketime::register_all(ctx);
                "{udf_name}: arg {slot_index} expected timestamp/date/string, got {other:?}"
        impl Eq for $udf {}
                Self::new()
    #[test]
    #[test]
macro_rules! udf_identity {
            err.to_string().contains("arg 1"),
    #[test]
    use super::{coerce_args, coerce_slot, CoerceMode};
        let err = coerce_slot("d", 0, &DataType::Float64, CoerceMode::Date32).unwrap_err();
    minspan_bucket::register_all(ctx);
pub mod mvfind;
            Timestamp(_, _) | Date32 | Date64 | Utf8 | LargeUtf8 | Utf8View => {
    template: &[CoerceMode],
                plan_err!("{udf_name}: arg {slot_index} expected integer or float, got {other:?}")
/// produce a `plan_err!` naming the UDF, slot index, and observed type.
pub mod width_bucket;
        let observed = [DataType::Utf8];
    reduce_eval::register_all(ctx);
pub mod maketime;
            DataType::UInt32,
    }
    fn coerce_args_rejects_arity_mismatch() {
    }
    }
            }
    json_array_length::register_all(ctx);
/// Coerce an entire argument vector against a fixed template. Enforces arity
    str_to_date::register_all(ctx);
    ip_to_string::register_all(ctx);
                "{udf_name}: arg {slot_index} expected date/timestamp/string, got {other:?}"
}
    json_extend::register_all(ctx);
pub mod makedate;
            "error must name the failing slot index, got: {err}"
    ($udf:ident, $name:literal) => {
) -> Result<Vec<DataType>> {
pub mod json_keys;
            other => plan_err!(
    //! Direct tests for the [`CoerceMode`] helper library. `convert_tz` exercises
        let err = coerce_slot("i", 0, &DataType::Utf8, CoerceMode::Int64).unwrap_err();
    }
    json_set::register_all(ctx);
use datafusion::arrow::datatypes::{DataType, TimeUnit};
pub mod conversion;
/// Input-type categories for UDF argument slots. Each mode declares a canonical
/*
//! OpenSearch scalar UDFs not in DataFusion's builtins. Each registered UDF must
            DataType::Int32,
    fn int64_accepts_every_number() {
    fn date32_rejects_numeric() {
            other => plan_err!(
            assert_eq!(
pub mod pattern_parser;
    conv::register_all(ctx);
            other => {
    //! cover every mode's accept + reject paths so future UDFs that pick up
        }
        impl Default for $udf {
pub mod mvzip;
/// — they compare equal and hash to a single name-derived stable value.
    json_object::register_all(ctx);
            DataType::Timestamp(TimeUnit::Millisecond, None),
        CoerceMode::Utf8 => match observed {
                ts_ms(),
    // PARSE them: a coordinator-reduce session derives the producer (shard) plan's output schema
pub mod os_week;
        impl std::hash::Hash for $udf {
    makedate::register_all(ctx);
}
        "OpenSearch UDF register_all: convert_tz, conversion(numeric_conversion: num/auto/memk/rmcomma/rmunit/dur2sec/mstime, time_conversion: ctime/mktime), crc32, date_format, opensearch_extract, from_unixtime, item, json, json_append, json_array, json_array_length, json_delete, json_extend, json_extract, json_extract_all, json_keys, json_object, json_set, makedate, maketime, minspan_bucket, mvappend, mvfind, mvzip, parse, range_bucket, rex_extract, rex_extract_multi, rex_offset, sha1, span_bucket, str_to_date, strftime, time_format, width_bucket registered"
            DataType::Float64,
        CoerceMode::TimestampMs => match observed {
        CoerceMode::Int64 => match observed {
        },
        );
    // unwrapped/executed ONLY on the data-node indexed path. But every session must be able to
    // an unregistered function. Register here so all sessions can parse; the bodies still error if
pub mod parse;
        for observed in [
#[allow(dead_code)]
pub mod sha1;
/// UDF needs. All instances of the same UDF type are semantically identical
            }
        ] {
use datafusion::common::plan_err;
    #[test]
            DataType::Utf8,
            fn default() -> Self {
    #[test]
        }
pub mod convert_tz;
    // ── TimestampMs ────────────────────────────────────────────────────────
            }
                result,
            DataType::Utf8View,
        ] {
pub mod json_object;
    ctx.register_udf(crate::indexed_table::substrait_to_tree::create_index_filter_udf());
pub mod json_extract;
        let template = [CoerceMode::Utf8, CoerceMode::Utf8];
    date_format::register_all(ctx);
    parse::register_all(ctx);
    json_append::register_all(ctx);
    // ── Utf8 ───────────────────────────────────────────────────────────────
pub mod str_to_date;
    TimestampMs,
//! have a matching YAML entry in `opensearch_scalar_functions.yaml`.
            let err = coerce_slot("s", 0, &observed, CoerceMode::Utf8).unwrap_err();
    #[test]
pub mod strftime;
    #[test]
    }
    udf_name: &str,
pub mod json_extract_all;
pub mod json_set;
            );
mod tests {
            }
        let template = [CoerceMode::Utf8, CoerceMode::Int64];
        let err = coerce_slot("t", 0, &DataType::Int64, CoerceMode::TimestampMs).unwrap_err();
    #[test]
    }
        CoerceMode::Date32 => match observed {
                Ok(Timestamp(TimeUnit::Millisecond, None))
    }
    use DataType::*;
    fn ts_ms() -> DataType {
            DataType::LargeUtf8,
            let result = coerce_slot("s", 0, &observed, CoerceMode::Utf8).unwrap();
    fn float64_rejects_strings() {
        ] {
    json_valid::register_all(ctx);
pub(crate) mod os_strftime;
    json_array::register_all(ctx);
        },
    from_unixtime::register_all(ctx);
 * this file be licensed under the Apache-2.0 license or a
            assert_eq!(result, DataType::Float64);
            Int8 | Int16 | Int32 | Int64 | UInt8 | UInt16 | UInt32 | UInt64 | Float32 | Float64 => {
pub mod json_array;
        let err = coerce_args("arity", &observed, &template).unwrap_err();
    range_bucket::register_all(ctx);
        }
 */
// `./gradlew :sandbox:libs:dataformat-native:buildRustLibrary --rerun-tasks`
        let result = coerce_args("multi", &observed, &template).unwrap();
