    let multiplier = match caps.get(2).map(|m| m.as_str()) {
    fn num_extracts_leading_number_from_unit_suffix() {
    Some((minutes * 60 + seconds) as f64 + millis)
 *
    }
/// Which conversion function this UDF instance implements.
    }
        assert_eq!(convert_mstime("45"), Some(45.0));
                    }
            }
            _ => 1.0,
#[cfg(test)]
    #[test]
        return None;
    fn hash<H: Hasher>(&self, state: &mut H) {
    #[test]
    )));
        assert_eq!(convert_mstime("1:2:3"), None);
    #[test]
impl ScalarUDFImpl for NumericConversionUdf {
        assert_eq!(convert_memk("500K"), Some(500.0));
use datafusion::logical_expr::{
        .unwrap_or(0.0);
    }
/// `memk(x)` — memory-unit conversion. Returns KB.
// ── Per-function implementations ───────────────────────────────────────────────────────────
    }
                Volatility::Immutable,
        return None;
        assert_eq!(convert_dur2sec("00:00:60"), None);
    #[test]
    #[test]
        assert_eq!(convert_num("a123"), None);
use datafusion::common::{exec_err, Result, ScalarValue};
    #[test]
pub fn register_all(ctx: &SessionContext) {
    use super::*;
static LEADING_NUMBER_WITH_UNIT: Lazy<Regex> =
    fn auto_falls_back_to_num() {
#[derive(Debug)]
        assert_eq!(convert_rmcomma("1a"), None);
 * SPDX-License-Identifier: Apache-2.0
            return None;
/// Captures an optional sign, the numeric body (one of `digits`, `digits.digits`, `digits.`, or `.digits`),
use regex::Regex;
    #[test]
            ColumnarValue::Scalar(other) => {
    Volatility,
fn convert_dur2sec(s: &str) -> Option<f64> {
    fn mstime_accepts_mm_ss() {
    }
static MEMK: Lazy<Regex> = Lazy::new(|| Regex::new(r"^([+\-]?\d+\.?\d*)([kmgKMG])?$").unwrap());
    fn name(&self) -> &str {
 */
/// Register every conversion UDF (`num`, `auto`, `memk`, `rmcomma`, `rmunit`,
/// `dur2sec(x)` — `[D+]HH:MM:SS` duration → total seconds as double. Also accepts a pre-parsed
/// precision. Also accepts a pre-parsed numeric string.
fn convert_num(s: &str) -> Option<f64> {
        NumericConversionFn::Num,
                kind
    }
            );
                    other => {
        .unwrap_or("0")
/// Optional `MM:` prefix, required `SS`, optional `.SSS`.
impl NumericConversionFn {
                padded.push('0');
                    DataType::LargeUtf8 => arr
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
        .ok()?;
        assert_eq!(convert_rmunit("-3.14cm"), Some(-3.14));
//! | `num`    | `"3.14"`, `"1,234"`, `"100MB"` (→ 100), `"3e2"` | `"abc"`, `"1abc"` (no unit separator), `".mb"` | Strict numeric; leading-number-plus-unit fallback requires the suffix to start with a non-digit/non-dot character. |
        return Some(n);
        assert_eq!(convert_memk("1.5m"), Some(1536.0));
            "g" => GB_TO_KB,
    // ── num ────────────────────────────────────────────────────────────────
        assert_eq!(convert_dur2sec("1+02:03:04"), Some(93784.0));
                    TypeSignature::Exact(vec![DataType::LargeUtf8]),
//! Each UDF takes a single `Utf8` / `LargeUtf8` input and returns `Float64` (nullable)
        None => 1.0,
/// `dur2sec`, `mstime`) on a session.
    }
    }
    )));
/// and an optional exponent.
            NumericConversionFn::Rmunit => "rmunit",
        Ok(DataType::Float64)
        assert_eq!(convert_memk("500"), Some(500.0));
        assert_eq!(convert_rmunit("1.5e2kg"), Some(150.0));
        assert_eq!(convert_mstime("60"), Some(60.0));
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
                kind.apply("   "),
        return Some(n);
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
        .ok()?;
    fn empty_string_returns_none_for_every_fn() {
    fn rmcomma_strips_and_parses() {
            )),
        Some(unit) => match unit.to_ascii_lowercase().as_str() {
        let leading = caps.get(1)?.as_str();
    #[test]
            let mut padded = String::with_capacity(3);
                    "{}: expected Utf8/LargeUtf8 input, got {other:?}",
        let suffix = caps.get(2)?.as_str().trim();
                        );
            NumericConversionFn::Rmunit => convert_rmunit(trimmed),
    if s.contains(',') {
                exec_err!(
    Lazy::new(|| Regex::new(r"^([+\-]?(?:\d+\.?\d*|\.\d+)(?:[eE][+\-]?\d+)?)(.*)$").unwrap());
    }
    fn auto_rejects_when_both_paths_fail() {
const GB_TO_KB: f64 = 1024.0 * 1024.0;
    fn mstime_rejects_seconds_over_59_in_regex_branch() {
    }
/// Shared UDF type — one instance per function, keyed by `NumericConversionFn`.
        assert_eq!(convert_mstime("00:00.5"), Some(0.5));
        assert_eq!(NumericConversionFn::Auto.apply("abc"), None);
        .parse()
    }
            }
        assert_eq!(convert_mstime("00:00.500"), Some(0.5));
            padded[..3].parse::<f64>().unwrap_or(0.0) / 1_000.0
    #[test]
//! |----------|---------|---------|-------|
    }
        for kind in [
            | ColumnarValue::Scalar(ScalarValue::LargeUtf8(opt)) => Ok(ColumnarValue::Scalar(
fn convert_memk(s: &str) -> Option<f64> {
    // ── rmunit ─────────────────────────────────────────────────────────────
                            self.kind.name()
            ),
/// numeric string (e.g. `"3600"`) and returns it verbatim.
}
    #[test]
                        return exec_err!(
    let minutes: u64 = caps.get(3)?.as_str().parse().ok()?;
    fn num_rejects_space_separated_digit_run() {
}
    #[test]
            NumericConversionFn::Memk => convert_memk(trimmed),
        assert_eq!(convert_mstime("00:00.123"), Some(0.123));
static DUR2SEC: Lazy<Regex> =
    }
    // ── rmcomma ────────────────────────────────────────────────────────────
        match &args.args[0] {
        // 1 day, 2h 3m 4s = 86400 + 7200 + 180 + 4 = 93784
use std::hash::{Hash, Hasher};
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
/*
            NumericConversionFn::Rmunit,
    }
    }
            NumericConversionFn::Mstime => convert_mstime(trimmed),
        })
                self.kind.name(),
/// `rmunit(x)` — extract the leading numeric token and parse.
    let number: f64 = caps.get(1)?.as_str().parse().ok()?;
        .unwrap_or("0")
    fn rmcomma_accepts_negative() {
        }
// same NumericConversionFn are semantically interchangeable.
        Self {
    }
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
    fn name(self) -> &'static str {
            NumericConversionFn::Num => convert_num(trimmed),
    }
    fn memk_rejects_unknown_suffix() {
    /// Dispatch the per-row implementation. `None` output propagates through as NULL.
 * compatible open source license.
    // ── mstime ─────────────────────────────────────────────────────────────
impl PartialEq for NumericConversionUdf {
    }
    }
    fn memk_k_suffix_is_pass_through() {
            // zero-pads to 3 digits before parsing
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
    }
    }
            NumericConversionFn::Memk,
                    TypeSignature::Exact(vec![DataType::Utf8]),
    }
    let caps = MSTIME.captures(s)?;
        }
fn convert_rmunit(s: &str) -> Option<f64> {
        assert_eq!(convert_num("123 456"), None);
        assert_eq!(convert_rmunit("abc"), None);
    fn mstime_rejects_malformed() {
    }
        .get(3)
    if !STARTS_WITH_SIGN_OR_DIGIT.is_match(s) {
        if trimmed.is_empty() {
            for _ in raw.len()..3 {
    Memk,
            NumericConversionFn::Memk => "memk",
        assert_eq!(convert_num("100MB"), Some(100.0));
    // Leading-number-plus-unit-suffix fallback: extract the numeric prefix only when the suffix
        assert_eq!(NumericConversionFn::Auto.apply("3.14"), Some(3.14));
                        .as_string::<i64>()
    fn rmcomma_rejects_letters() {
/// Gatekeeper for `num`.
    }
        }
    None
            NumericConversionFn::Rmcomma => convert_rmcomma(trimmed),
/// `rmcomma(x)` — strip commas, then parse. NULL if letters are present.
                        .map(|opt| opt.and_then(|s| self.kind.apply(s)))
    #[test]
                kind.apply(""),
}
            let raw = m.as_str();
    #[test]
            NumericConversionFn::Num,
            NumericConversionFn::Rmcomma,
    let days: u64 = caps
    fn num_rejects_letter_prefix() {
}
    }
                Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
        self.kind.name()
}
    Lazy::new(|| Regex::new(r"^(?:(\d+)\+)?(\d{1,2}):(\d{1,2}):(\d{1,2})$").unwrap());
            NumericConversionFn::Dur2sec => "dur2sec",
//! | `memk`   | `"500k"`, `"1.5m"`, `"2g"`, `"500"` (bare number → KB) | `"1.5t"`, `"abc"` | k / bare → value as-is, m → ×1024, g → ×1024². |
        let has_unit = !first_byte.is_ascii_digit() && first_byte != b'.';
        let trimmed = input.trim();
        .map(|m| m.as_str())
        assert_eq!(convert_num("1,234.5"), Some(1234.5));
/// `mstime(x)` — `[MM:]SS.SSS` time-of-day → total seconds (double) with millisecond
    };
        }
    #[test]
        // 1h 1m 1s = 3661 seconds
/// `num(x)` — strict parse with comma-strip + leading-number-plus-unit-suffix fallback.
        return Some(n);
    #[test]
    let caps = DUR2SEC.captures(s)?;
    }
static MSTIME: Lazy<Regex> =
impl Eq for NumericConversionUdf {}
    fn num_accepts_scientific_notation() {
mod tests {
            NumericConversionFn::Mstime,
            ColumnarValue::Scalar(ScalarValue::Utf8(opt))
        &self.signature
 * The OpenSearch Contributors require contributions made to
        assert_eq!(convert_memk("500k"), Some(500.0));
/// Optional sign, number body, optional unit in {k,m,g} (case-insensitive). Bare number with no unit is accepted.
    // ── auto ───────────────────────────────────────────────────────────────
    fn rmunit_extracts_leading_number() {
    #[test]
    Rmunit,
        assert_eq!(convert_mstime("02:30"), Some(150.0));
            NumericConversionFn::Auto,
        NumericConversionFn::Mstime,
    Rmcomma,
    kind: NumericConversionFn,
    fn dur2sec_rejects_malformed() {
    }
                args.args.len()
    }
    // ── empty / whitespace / null — dispatched at the NumericConversionFn level ──
    // ── memk ───────────────────────────────────────────────────────────────
        assert_eq!(convert_rmcomma("12,345abc"), None);
        assert_eq!(convert_num("1e3"), Some(1000.0));
    if hours >= 24 || minutes >= 60 || seconds >= 60 {
    #[test]
    #[test]
    Lazy::new(|| Regex::new(r"^(?:(\d{1,2}):)?(\d{1,2})(?:\.(\d{1,3}))?$").unwrap());
    }
//! | `rmunit` | `"100MB"` (→ 100), `"-3.14cm"`, `"1.5e2kg"` | `"abc"`, `".mb"` (no leading number) | Regex-extracts the leading numeric token and parses. |
        }
                };
    if let Ok(n) = s.parse::<f64>() {
    fn num_strips_commas_when_needed() {
use datafusion::arrow::datatypes::DataType;
//! conversion functions: `num`, `auto`, `memk`, `rmcomma`, `rmunit`, `dur2sec`, `mstime`
    #[test]
    fn rmunit_handles_pure_number() {
    fn signature(&self) -> &Signature {
//! | Function | Accepts | Rejects | Notes |
    #[test]
        self.kind == other.kind
}
    #[test]
        assert_eq!(convert_num("abc"), None);
    }
    fn dur2sec_rejects_out_of_range_components() {
    Dur2sec,
        if args.args.len() != 1 {
        if suffix.is_empty() {
    #[test]
const MB_TO_KB: f64 = 1024.0;
    }
        assert_eq!(convert_mstime("3.14"), Some(3.14));
        .map(|m| {
    fn mstime_accepts_bare_seconds_over_59_via_parse_shortcut() {
    )));
    }
        assert_eq!(convert_dur2sec("24:00:00"), None);
                let out: Float64Array = match arr.data_type() {
enum NumericConversionFn {
}
            "k" => 1.0,
        }
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
        NumericConversionFn::Memk,
    #[test]
    }
    #[test]
        }
    #[test]
    fn memk_g_suffix_multiplies_by_1024_squared() {
//! | `auto`   | `"1.5g"` (→ 1 572 864), everything `num` accepts | same rejection set as num for non-memory inputs | Tries memk first, falls back to num. |
            signature: Signature::one_of(
    }
    }
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
pub struct NumericConversionUdf {
}
    Auto,
                )
        if has_unit {
    }
            );
        assert_eq!(convert_dur2sec("3600"), Some(3600.0));
    fn mstime_accepts_pre_parsed_double() {
        }
            NumericConversionFn::Rmcomma => "rmcomma",
            NumericConversionFn::Dur2sec,
    #[test]
        assert_eq!(NumericConversionFn::Auto.apply("1.5m"), Some(1536.0));
    }
    }
use datafusion::arrow::array::{Array, ArrayRef, AsArray, Float64Array};
/// `[D+]HH:MM:SS` — optional day count prefix separated by `+`.
    )));
        let first_byte = suffix.as_bytes()[0];
// ScalarUDFImpl requires DynEq+DynHash. Function identity is `kind` — two instances of the
        ] {
    fn dur2sec_accepts_simple_hhmmss() {
fn convert_rmcomma(s: &str) -> Option<f64> {
        match self {
                kind
            "m" => MB_TO_KB,
            NumericConversionFn::Auto => "auto",
        assert_eq!(convert_rmunit("100MB"), Some(100.0));
    #[test]
}
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
        .get(1)
                        .map(|opt| opt.and_then(|s| self.kind.apply(s)))
    }
fn convert_mstime(s: &str) -> Option<f64> {
        .get(1)
use once_cell::sync::Lazy;
            return Some(n);
    fn dur2sec_accepts_days_prefix() {
        .map(|m| m.as_str())
        assert_eq!(convert_memk("1.5t"), None);
//!
    // starts with a non-digit, non-dot character.
    }
    )));
            NumericConversionFn::Mstime => "mstime",
    if let Ok(n) = s.parse::<f64>() {
        }
                vec![
/// Fast-reject gate for `rmcomma`.
    fn memk_m_suffix_multiplies_by_1024() {
    }
        assert_eq!(convert_rmcomma("-1,000"), Some(-1000.0));
            assert_eq!(
        assert_eq!(convert_memk("abc"), None);
                        .collect(),
        },
        self.kind.hash(state);
        assert_eq!(convert_dur2sec("01:01:01"), Some(3661.0));
    }
                None,
};
    fn eq(&self, other: &Self) -> bool {
    }
    #[test]
//! | `rmcomma`| `"12,345.67"` (→ 12345.67) | `"12abc"` (letter present) | Strips every comma, then parses; letters short-circuit to NULL. |
                        .iter()
    }
    if let Some(caps) = LEADING_NUMBER_WITH_UNIT.captures(s) {
    fn memk_bare_number_is_kb() {
    fn dur2sec_accepts_pre_parsed_number() {
    if seconds >= 60 {
}
        NumericConversionFn::Rmcomma,
            return leading.parse::<f64>().ok();
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
        }
    Mstime,
    }
            NumericConversionFn::Dur2sec => convert_dur2sec(trimmed),
    let leading = caps.get(1)?.as_str();
    fn rmunit_handles_scientific_notation_before_unit() {
        assert_eq!(convert_dur2sec("1:2"), None);
static CONTAINS_LETTER: Lazy<Regex> = Lazy::new(|| Regex::new(r"[a-zA-Z]").unwrap());
            }
use datafusion::execution::context::SessionContext;
                "{:?} should return None for whitespace-only",
    }
            );
                    DataType::Utf8 => arr
    Lazy::new(|| Regex::new(r"^[+\-]?[\d.].*").unwrap());
                None,
            assert_eq!(
                        .collect(),
    fn mstime_accepts_ss_with_millis() {
    #[test]
    s.replace(',', "").parse::<f64>().ok()
    #[test]
                    self.kind.name()
                        .iter()
    let seconds: u64 = caps.get(2)?.as_str().parse().ok()?;
        assert_eq!(convert_memk("1.5M"), Some(1536.0));
        NumericConversionFn::Rmunit,
                        .as_string::<i32>()
        assert_eq!(convert_rmunit(".abc"), None);
    let millis = caps
        assert_eq!(convert_dur2sec("not-a-duration"), None);
impl NumericConversionUdf {
                "{} expects exactly 1 argument, got {}",
    }
        .parse()
    }
//!
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
    #[test]
                "{:?} should return None for empty",
}
    )));
        NumericConversionFn::Dur2sec,
    if let Ok(n) = s.parse::<f64>() {
    // ── dur2sec ────────────────────────────────────────────────────────────
        return None;
    let caps = MEMK.captures(s)?;
        match self {
    let seconds: u64 = caps.get(4)?.as_str().parse().ok()?;
    #[test]
    if CONTAINS_LETTER.is_match(s) {
    }
            ColumnarValue::Array(arr) => {
    }
        assert_eq!(convert_num("3.14"), Some(3.14));
            padded.push_str(raw);
        NumericConversionFn::Auto,
    let caps = LEADING_NUMBER_WITH_UNIT.captures(s)?;
    let hours: u64 = caps.get(2)?.as_str().parse().ok()?;
    leading.parse::<f64>().ok()
    Num,
                ],
use std::sync::Arc;
    #[test]
        assert_eq!(convert_rmunit("42"), Some(42.0));
        return None;
    )));
    fn num_accepts_plain_decimal() {
            kind,
            NumericConversionFn::Num => "num",
        assert_eq!(convert_mstime("abc"), None);
    let minutes: u64 = caps
            return exec_err!(
        assert_eq!(convert_memk("2g"), Some(2.0 * GB_TO_KB));
static STARTS_WITH_SIGN_OR_DIGIT: Lazy<Regex> =
    Some((days * 86_400 + hours * 3_600 + minutes * 60 + seconds) as f64)
    fn apply(self, input: &str) -> Option<f64> {
}
}
    }
                            "{}: expected Utf8 array, got {other:?}",
}
            return None;
    #[test]
                ScalarValue::Float64(opt.as_ref().and_then(|s| self.kind.apply(s))),
        assert_eq!(convert_dur2sec("00:60:00"), None);
            NumericConversionFn::Auto => convert_memk(trimmed).or_else(|| convert_num(trimmed)),
        assert_eq!(convert_num("-3.5%"), Some(-3.5));
    fn mstime_accepts_ss_only() {
}
    fn rmunit_rejects_no_leading_number() {
    Some(number * multiplier)
        assert_eq!(convert_mstime("00:60"), None);
    fn auto_prefers_memk_over_num() {
        if let Ok(n) = s.replace(',', "").parse::<f64>() {
impl Hash for NumericConversionUdf {
    }
    signature: Signature,
    fn new(kind: NumericConversionFn) -> Self {
        assert_eq!(convert_rmcomma("12,345.67"), Some(12345.67));
 * this file be licensed under the Apache-2.0 license or a
        assert_eq!(NumericConversionFn::Auto.apply("1,234"), Some(1234.0));
