                    "{}: expected Utf8/LargeUtf8 input, got {other:?}",
        .get(1)
    Memk,
    )));
        assert_eq!(convert_memk("1.5m"), Some(1536.0));
    }
            kind,
            NumericConversionFn::Num,
            return None;
                    self.kind.name()
    }
    }
        self.kind.name()
static MEMK: Lazy<Regex> = Lazy::new(|| Regex::new(r"^([+\-]?\d+\.?\d*)([kmgKMG])?$").unwrap());
    Some(number * multiplier)
            NumericConversionFn::Num => convert_num(trimmed),
static MSTIME: Lazy<Regex> =
    // ── empty / whitespace / null — dispatched at the NumericConversionFn level ──
//! |----------|---------|---------|-------|
 * compatible open source license.
/// `dur2sec`, `mstime`) on a session.
                kind
    fn memk_g_suffix_multiplies_by_1024_squared() {
        }
            ColumnarValue::Scalar(ScalarValue::Utf8(opt))
                None,
    fn memk_k_suffix_is_pass_through() {
        self.kind == other.kind
pub fn register_all(ctx: &SessionContext) {
    fn mstime_rejects_malformed() {
    }
    fn eq(&self, other: &Self) -> bool {
        // 1h 1m 1s = 3661 seconds
        assert_eq!(NumericConversionFn::Auto.apply("1.5m"), Some(1536.0));
        assert_eq!(convert_dur2sec("00:00:60"), None);
impl PartialEq for NumericConversionUdf {
    fn apply(self, input: &str) -> Option<f64> {
    fn rmcomma_accepts_negative() {
}
    }
            ColumnarValue::Scalar(other) => {
    #[test]
            ),
    // ── num ────────────────────────────────────────────────────────────────
    if s.contains(',') {
            NumericConversionFn::Dur2sec => "dur2sec",
            return exec_err!(
impl Eq for NumericConversionUdf {}
}
        NumericConversionFn::Mstime,
    Dur2sec,
        }
    }
            "m" => MB_TO_KB,
    let caps = LEADING_NUMBER_WITH_UNIT.captures(s)?;
//!
    Lazy::new(|| Regex::new(r"^(?:(\d{1,2}):)?(\d{1,2})(?:\.(\d{1,3}))?$").unwrap());
            NumericConversionFn::Memk,
        assert_eq!(convert_mstime("abc"), None);
            );
            let raw = m.as_str();
            );
    fn rmunit_rejects_no_leading_number() {
        assert_eq!(convert_rmcomma("12,345.67"), Some(12345.67));
    }
    fn dur2sec_accepts_simple_hhmmss() {
        assert_eq!(NumericConversionFn::Auto.apply("abc"), None);
            return Some(n);
                kind.apply(""),
/// precision. Also accepts a pre-parsed numeric string.
            NumericConversionFn::Dur2sec,
    Some((days * 86_400 + hours * 3_600 + minutes * 60 + seconds) as f64)
    Volatility,
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
    leading.parse::<f64>().ok()
//! Each UDF takes a single `Utf8` / `LargeUtf8` input and returns `Float64` (nullable)
        // 1 day, 2h 3m 4s = 86400 + 7200 + 180 + 4 = 93784
    }
        NumericConversionFn::Dur2sec,
    let leading = caps.get(1)?.as_str();
                "{:?} should return None for whitespace-only",
    let minutes: u64 = caps
    fn rmunit_handles_scientific_notation_before_unit() {
            NumericConversionFn::Mstime,
                kind.apply("   "),
        if let Ok(n) = s.replace(',', "").parse::<f64>() {
    fn mstime_accepts_ss_only() {
            NumericConversionFn::Auto,
            )),
    Lazy::new(|| Regex::new(r"^[+\-]?[\d.].*").unwrap());
    fn name(self) -> &'static str {
        return None;
    fn mstime_rejects_seconds_over_59_in_regex_branch() {
            }
    fn name(&self) -> &str {
        }
#[derive(Debug)]
}
    }
    }
    #[test]
    #[test]
        assert_eq!(convert_rmcomma("-1,000"), Some(-1000.0));
    #[test]
    }
                let out: Float64Array = match arr.data_type() {
    #[test]
                self.kind.name(),
    fn mstime_accepts_bare_seconds_over_59_via_parse_shortcut() {
    if let Ok(n) = s.parse::<f64>() {
            NumericConversionFn::Auto => convert_memk(trimmed).or_else(|| convert_num(trimmed)),
static LEADING_NUMBER_WITH_UNIT: Lazy<Regex> =
        self.kind.hash(state);
    #[test]
    fn auto_rejects_when_both_paths_fail() {
        },
        }
                        return exec_err!(
use datafusion::arrow::datatypes::DataType;
    fn dur2sec_rejects_out_of_range_components() {
    #[test]
            "g" => GB_TO_KB,
        assert_eq!(convert_rmunit(".abc"), None);
    #[test]
        assert_eq!(convert_memk("abc"), None);
    fn hash<H: Hasher>(&self, state: &mut H) {
        return None;
    }
        assert_eq!(convert_memk("2g"), Some(2.0 * GB_TO_KB));
/// Fast-reject gate for `rmcomma`.
    #[test]
    }
impl ScalarUDFImpl for NumericConversionUdf {
        assert_eq!(convert_rmunit("100MB"), Some(100.0));
        assert_eq!(convert_memk("500k"), Some(500.0));
            NumericConversionFn::Rmunit,
            "k" => 1.0,
            NumericConversionFn::Dur2sec => convert_dur2sec(trimmed),
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
    if let Ok(n) = s.parse::<f64>() {
    }
                    DataType::LargeUtf8 => arr
        match self {
    fn new(kind: NumericConversionFn) -> Self {
//! | `auto`   | `"1.5g"` (→ 1 572 864), everything `num` accepts | same rejection set as num for non-memory inputs | Tries memk first, falls back to num. |
            );
    let multiplier = match caps.get(2).map(|m| m.as_str()) {
//! | `rmcomma`| `"12,345.67"` (→ 12345.67) | `"12abc"` (letter present) | Strips every comma, then parses; letters short-circuit to NULL. |
        assert_eq!(convert_num("3.14"), Some(3.14));
}
    let number: f64 = caps.get(1)?.as_str().parse().ok()?;
        assert_eq!(convert_num("abc"), None);
    )));
use datafusion::common::{exec_err, Result, ScalarValue};
        .ok()?;
    #[test]
        .unwrap_or("0")
        assert_eq!(convert_memk("500"), Some(500.0));
        assert_eq!(convert_mstime("00:00.500"), Some(0.5));
    #[test]
/// and an optional exponent.
    fn signature(&self) -> &Signature {
 * this file be licensed under the Apache-2.0 license or a
                        .collect(),
}
        assert_eq!(convert_mstime("02:30"), Some(150.0));
        assert_eq!(convert_memk("1.5M"), Some(1536.0));
    fn empty_string_returns_none_for_every_fn() {
        let first_byte = suffix.as_bytes()[0];
}
            NumericConversionFn::Auto => "auto",
        return None;
}
            return None;
    // ── rmcomma ────────────────────────────────────────────────────────────
        }
//! | Function | Accepts | Rejects | Notes |
    Rmcomma,
static STARTS_WITH_SIGN_OR_DIGIT: Lazy<Regex> =
    }
    }
            NumericConversionFn::Memk => convert_memk(trimmed),
 * SPDX-License-Identifier: Apache-2.0
                        .iter()
                        .map(|opt| opt.and_then(|s| self.kind.apply(s)))
/// `memk(x)` — memory-unit conversion. Returns KB.
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
static CONTAINS_LETTER: Lazy<Regex> = Lazy::new(|| Regex::new(r"[a-zA-Z]").unwrap());
        if args.args.len() != 1 {
    ColumnarValue, ScalarFunctionArgs, ScalarUDF, ScalarUDFImpl, Signature, TypeSignature,
            _ => 1.0,
                        .as_string::<i64>()
        .unwrap_or("0")
    }
fn convert_rmcomma(s: &str) -> Option<f64> {
    #[test]
        assert_eq!(convert_dur2sec("00:60:00"), None);
                    }
 * The OpenSearch Contributors require contributions made to
    // ── dur2sec ────────────────────────────────────────────────────────────
/// Optional `MM:` prefix, required `SS`, optional `.SSS`.
        }
        assert_eq!(convert_mstime("00:00.5"), Some(0.5));
        })
/// `[D+]HH:MM:SS` — optional day count prefix separated by `+`.
    #[test]
                    TypeSignature::Exact(vec![DataType::LargeUtf8]),
        return Some(n);
mod tests {
    #[test]
    fn num_accepts_plain_decimal() {
        for kind in [
        assert_eq!(convert_dur2sec("01:01:01"), Some(3661.0));
    let caps = MSTIME.captures(s)?;
    };
        assert_eq!(convert_rmunit("1.5e2kg"), Some(150.0));
    fn rmcomma_strips_and_parses() {
            padded[..3].parse::<f64>().unwrap_or(0.0) / 1_000.0
    )));
    Auto,
    }
    }
    #[test]
#[cfg(test)]
        assert_eq!(convert_mstime("00:60"), None);
    #[test]
 */
    // Leading-number-plus-unit-suffix fallback: extract the numeric prefix only when the suffix
        assert_eq!(NumericConversionFn::Auto.apply("3.14"), Some(3.14));
                "{} expects exactly 1 argument, got {}",
        assert_eq!(NumericConversionFn::Auto.apply("1,234"), Some(1234.0));
        .parse()
use std::hash::{Hash, Hasher};
    let seconds: u64 = caps.get(4)?.as_str().parse().ok()?;
impl Hash for NumericConversionUdf {
        Some(unit) => match unit.to_ascii_lowercase().as_str() {
    fn num_extracts_leading_number_from_unit_suffix() {
            NumericConversionFn::Mstime => "mstime",
        let suffix = caps.get(2)?.as_str().trim();
    }
        assert_eq!(convert_mstime("60"), Some(60.0));
            return leading.parse::<f64>().ok();
            NumericConversionFn::Rmcomma => convert_rmcomma(trimmed),
        NumericConversionFn::Auto,
        }
        NumericConversionFn::Rmcomma,
use once_cell::sync::Lazy;
                "{:?} should return None for empty",
//! | `memk`   | `"500k"`, `"1.5m"`, `"2g"`, `"500"` (bare number → KB) | `"1.5t"`, `"abc"` | k / bare → value as-is, m → ×1024, g → ×1024². |
        assert_eq!(convert_dur2sec("1:2"), None);
    fn dur2sec_accepts_pre_parsed_number() {
//! | `rmunit` | `"100MB"` (→ 100), `"-3.14cm"`, `"1.5e2kg"` | `"abc"`, `".mb"` (no leading number) | Regex-extracts the leading numeric token and parses. |
    #[test]
        let leading = caps.get(1)?.as_str();
    }
    if !STARTS_WITH_SIGN_OR_DIGIT.is_match(s) {
use regex::Regex;
    fn mstime_accepts_mm_ss() {
                kind
            }
        assert_eq!(convert_memk("1.5t"), None);
pub struct NumericConversionUdf {
    // ── mstime ─────────────────────────────────────────────────────────────
    fn auto_falls_back_to_num() {
    fn dur2sec_rejects_malformed() {
                    TypeSignature::Exact(vec![DataType::Utf8]),
            NumericConversionFn::Memk => "memk",
    }
    Some((minutes * 60 + seconds) as f64 + millis)
    use super::*;
        if suffix.is_empty() {
    #[test]
}
}
            | ColumnarValue::Scalar(ScalarValue::LargeUtf8(opt)) => Ok(ColumnarValue::Scalar(
    }
    }
    if seconds >= 60 {
    }
    )));
    #[test]
    Mstime,
                        .map(|opt| opt.and_then(|s| self.kind.apply(s)))
    s.replace(',', "").parse::<f64>().ok()
}
}
    }
/// Gatekeeper for `num`.
        NumericConversionFn::Rmunit,
        return None;
        assert_eq!(convert_rmcomma("1a"), None);
                ScalarValue::Float64(opt.as_ref().and_then(|s| self.kind.apply(s))),
                args.args.len()
    Lazy::new(|| Regex::new(r"^([+\-]?(?:\d+\.?\d*|\.\d+)(?:[eE][+\-]?\d+)?)(.*)$").unwrap());
/// Optional sign, number body, optional unit in {k,m,g} (case-insensitive). Bare number with no unit is accepted.
    #[test]
    #[test]
    // ── memk ───────────────────────────────────────────────────────────────
        return Some(n);
    }
    if let Some(caps) = LEADING_NUMBER_WITH_UNIT.captures(s) {
                    other => {
        .get(3)
    if CONTAINS_LETTER.is_match(s) {
                        .iter()
    fn num_strips_commas_when_needed() {
/// `mstime(x)` — `[MM:]SS.SSS` time-of-day → total seconds (double) with millisecond
    }
    }
        assert_eq!(convert_dur2sec("24:00:00"), None);
fn convert_rmunit(s: &str) -> Option<f64> {
    }
    fn dur2sec_accepts_days_prefix() {
impl NumericConversionFn {
        &self.signature
static DUR2SEC: Lazy<Regex> =
                            "{}: expected Utf8 array, got {other:?}",
    signature: Signature,
    }
                )
    }
                Volatility::Immutable,
                        .collect(),
    // starts with a non-digit, non-dot character.
    Lazy::new(|| Regex::new(r"^(?:(\d+)\+)?(\d{1,2}):(\d{1,2}):(\d{1,2})$").unwrap());
    #[test]
                            self.kind.name()
                        );
        .parse()
            NumericConversionFn::Rmcomma => "rmcomma",
    }
        match &args.args[0] {
    #[test]
enum NumericConversionFn {
            }
    }
    }
            signature: Signature::one_of(
// same NumericConversionFn are semantically interchangeable.
        assert_eq!(convert_num("a123"), None);
        NumericConversionFn::Memk,
            // zero-pads to 3 digits before parsing
    }
        .ok()?;
        .unwrap_or(0.0);
        .get(1)
    None
    // ── rmunit ─────────────────────────────────────────────────────────────
    }
    fn return_type(&self, _arg_types: &[DataType]) -> Result<DataType> {
        let has_unit = !first_byte.is_ascii_digit() && first_byte != b'.';
    #[test]
};
        return Some(n);
        assert_eq!(convert_mstime("1:2:3"), None);
/// Which conversion function this UDF instance implements.
    /// Dispatch the per-row implementation. `None` output propagates through as NULL.
    #[test]
    #[test]
        assert_eq!(convert_memk("500K"), Some(500.0));
    fn rmcomma_rejects_letters() {
/// Captures an optional sign, the numeric body (one of `digits`, `digits.digits`, `digits.`, or `.digits`),
    fn memk_m_suffix_multiplies_by_1024() {
    }
    if let Ok(n) = s.parse::<f64>() {
                };
    // ── auto ───────────────────────────────────────────────────────────────
            ColumnarValue::Array(arr) => {
    fn memk_rejects_unknown_suffix() {
// ── Per-function implementations ───────────────────────────────────────────────────────────
    let caps = DUR2SEC.captures(s)?;
        assert_eq!(convert_rmcomma("12,345abc"), None);
        ] {
    )));
    let caps = MEMK.captures(s)?;
/// `rmcomma(x)` — strip commas, then parse. NULL if letters are present.
    #[test]
            NumericConversionFn::Mstime => convert_mstime(trimmed),
        assert_eq!(convert_mstime("00:00.123"), Some(0.123));
    }
        .map(|m| m.as_str())
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
}
    fn mstime_accepts_ss_with_millis() {
        let trimmed = input.trim();
const MB_TO_KB: f64 = 1024.0;
use datafusion::logical_expr::{
use datafusion::arrow::array::{Array, ArrayRef, AsArray, Float64Array};
                        .as_string::<i32>()
        assert_eq!(convert_mstime("45"), Some(45.0));
    }
        NumericConversionFn::Num,
        .map(|m| {
            let mut padded = String::with_capacity(3);
        .map(|m| m.as_str())
            NumericConversionFn::Rmcomma,
    Num,
    #[test]
    fn num_rejects_letter_prefix() {
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
/// `dur2sec(x)` — `[D+]HH:MM:SS` duration → total seconds as double. Also accepts a pre-parsed
        assert_eq!(convert_num("-3.5%"), Some(-3.5));
fn convert_dur2sec(s: &str) -> Option<f64> {
                Ok(ColumnarValue::Array(Arc::new(out) as ArrayRef))
    let millis = caps
        assert_eq!(convert_rmunit("abc"), None);
            NumericConversionFn::Num => "num",
        match self {
        }
    }
        Self {
}
    let seconds: u64 = caps.get(2)?.as_str().parse().ok()?;
    fn mstime_accepts_pre_parsed_double() {
/// Register every conversion UDF (`num`, `auto`, `memk`, `rmcomma`, `rmunit`,
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
        None => 1.0,
    let minutes: u64 = caps.get(3)?.as_str().parse().ok()?;
                    DataType::Utf8 => arr
/// numeric string (e.g. `"3600"`) and returns it verbatim.
        assert_eq!(convert_num("100MB"), Some(100.0));
    }
            NumericConversionFn::Rmunit => convert_rmunit(trimmed),
                padded.push('0');
    fn num_rejects_space_separated_digit_run() {
                exec_err!(
        assert_eq!(convert_dur2sec("not-a-duration"), None);
        assert_eq!(convert_rmunit("-3.14cm"), Some(-3.14));
/// `rmunit(x)` — extract the leading numeric token and parse.
use datafusion::execution::context::SessionContext;
        assert_eq!(convert_dur2sec("1+02:03:04"), Some(93784.0));
    }
    }
// ScalarUDFImpl requires DynEq+DynHash. Function identity is `kind` — two instances of the
    fn rmunit_handles_pure_number() {
    Rmunit,
    kind: NumericConversionFn,
//! | `num`    | `"3.14"`, `"1,234"`, `"100MB"` (→ 100), `"3e2"` | `"abc"`, `"1abc"` (no unit separator), `".mb"` | Strict numeric; leading-number-plus-unit fallback requires the suffix to start with a non-digit/non-dot character. |
use std::sync::Arc;
    }
            for _ in raw.len()..3 {
    }
}
//! conversion functions: `num`, `auto`, `memk`, `rmcomma`, `rmunit`, `dur2sec`, `mstime`
    fn memk_bare_number_is_kb() {
fn convert_num(s: &str) -> Option<f64> {
    }
        }
    #[test]
    }
fn convert_memk(s: &str) -> Option<f64> {
    if hours >= 24 || minutes >= 60 || seconds >= 60 {
            NumericConversionFn::Rmunit => "rmunit",
impl NumericConversionUdf {
    }
        assert_eq!(convert_num("1e3"), Some(1000.0));
        if has_unit {
    #[test]
    let days: u64 = caps
    fn auto_prefers_memk_over_num() {
        assert_eq!(convert_mstime("3.14"), Some(3.14));
                vec![
            assert_eq!(
    #[test]
    }
/// `num(x)` — strict parse with comma-strip + leading-number-plus-unit-suffix fallback.
const GB_TO_KB: f64 = 1024.0 * 1024.0;
        if trimmed.is_empty() {
    ctx.register_udf(ScalarUDF::from(NumericConversionUdf::new(
            padded.push_str(raw);
        assert_eq!(convert_num("123 456"), None);
/*
        assert_eq!(convert_num("1,234.5"), Some(1234.5));
    let hours: u64 = caps.get(2)?.as_str().parse().ok()?;
fn convert_mstime(s: &str) -> Option<f64> {
    fn rmunit_extracts_leading_number() {
/// Shared UDF type — one instance per function, keyed by `NumericConversionFn`.
        }
    fn invoke_with_args(&self, args: ScalarFunctionArgs) -> Result<ColumnarValue> {
    )));
    }
    #[test]
                None,
                ],
    )));
}
    #[test]
        Ok(DataType::Float64)
    }
        assert_eq!(convert_dur2sec("3600"), Some(3600.0));
        assert_eq!(convert_rmunit("42"), Some(42.0));
//!
    #[test]
            assert_eq!(
 *
    fn num_accepts_scientific_notation() {
