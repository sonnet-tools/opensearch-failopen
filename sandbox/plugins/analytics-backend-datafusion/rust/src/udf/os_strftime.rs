                if s > 59 {
                        pos += 1;
            hour,
        Token::F => Str(format!("{:06}", dt.nanosecond() / 1_000)),
        let last_dt = Utc.from_utc_datetime(&last.and_hms_opt(0, 0, 0).unwrap());
fn tokenize(format: &str) -> Vec<Token> {
        // %c emits the zero-padded month, matching the PPL reference (SQL-plugin
fn days_until_start(from: Weekday, start: Weekday) -> u32 {
        assert_eq!(p.to_naive().unwrap().to_string(), "2020-03-01 00:00:00");
                }
        Token::T => Str(format!(
            fmt(dt, "%Y-%m-%d %H:%i:%S", FormatMode::Time).unwrap(),
            .iter()
                return None;
pub(crate) fn format_datetime(dt: DateTime<Utc>, format: &str, mode: FormatMode) -> Option<String> {
            // Week-based tokens: consume digits, ignore value (PPL doesn't back-solve either).
    match w {
        end += 1;
    let first_start_doy = 1 + offset;
        assert!(parse_os_strftime("13:00:00", "%h:%i:%s").is_none());
            // abbreviated forms regardless of which token was specified — MySQL is lenient here
    (weekday_idx(start) + 7 - weekday_idx(from)) % 7
    W,
        assert!(parse_os_strftime("2017-10-23X00:00:00", "%Y-%m-%d %h:%i:%s").is_none());
        }
    if wn == 0 {
        Token::HLower | Token::IUpper => Str(format!("{:02}", twelve_hour(dt.hour()))),
                if !(1..=366).contains(&v) {
fn weekday_short(w: Weekday) -> &'static str {
                // MySQL accepts "00" for %h/%I/%l; Parsed::to_naive maps h12=0 → hour 0.
        let last_dt = Utc.from_utc_datetime(&last.and_hms_opt(0, 0, 0).unwrap());
}
        assert_eq!(fmt(dt, fmtstr, FormatMode::Date).unwrap(), want);
            b'w' => Some(Token::WLower),
    p
            ("10:30:45", "%H:%i:%S", "2000-01-01 10:30:45"),
pub(crate) fn parse_os_strftime(input: &str, format: &str) -> Option<Parsed> {
    }
}
/// `%v` — MySQL mode 3: Monday-first, 01..53; week 0 remaps to prior year's last week.
            dt.second(),
            let date = chrono::NaiveDate::from_yo_opt(year, doy)?;
            b'k' => Some(Token::K),
    if week_number_sunday_first(dt) == 0 {
    week_number_with_start(dt, Weekday::Sun)
        }),
        match render_token(tok, dt, mode)? {
    match s.to_ascii_uppercase().as_str() {
            b's' => Some(Token::SLower),
                while pos < input_bytes.len() && (input_bytes[pos] as char).is_whitespace() {
        Weekday::Wed => 2,
            }
            out.push(Token::Literal('%'));
        "April",
    }
        let last = chrono::NaiveDate::from_ymd_opt(dt.year() - 1, 12, 31).unwrap();
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
                let (s, np) = read_digits(input_bytes, pos, 1, 2)?;
fn read_digits(bytes: &[u8], pos: usize, min: usize, max: usize) -> Option<(u32, usize)> {
                let (_, np) = read_digits(input_bytes, pos, 1, 2)?;
            continue;
    #[test]
                    return None;
            ("2020", "%Y", "2020-01-01 00:00:00"),
            fmt(jan31, "%U %u %V %v %W %w %X %x %Y %y", FormatMode::Date).unwrap(),
fn read_am_pm(bytes: &[u8], pos: usize, f: &mut Parsed) -> Option<usize> {
    .copied()
                if !(1..=12).contains(&v) {
            .zip(needle.iter())
            $body
                    return None;
}
fn week_year_monday_first(dt: DateTime<Utc>) -> i32 {
#[cfg(test)]
// str_to_date parser: minimal recursive-descent mirroring PPL's
    pub minute: Option<u32>,
    Some(out)
                pos = np;
    Literal(char),
                if h > 23 {
            dt.minute(),
    let tokens = tokenize(format);
                let (m, np) = match_month_name(input_bytes, pos)?;
    .get(m as usize)
        }
        "March",
            }
        assert!(parse_os_strftime("", "%Y").is_none());
        Token::A => date_only!(Str(weekday_short(dt.weekday()).into())),
        1 => "st",
            hour = 23;
        let p = parse_os_strftime("September 9, 2024", "%M %d, %Y").unwrap();
    let bytes = format.as_bytes();
        };
        let fmtstr = "%a %b %c %D %d %e %f %H %h %I %i %j %k %l %M %m %p %r %S %s %T %% %P";
        Token::ULower => date_only!(Str(format!("{:02}", week_number_monday_first(dt)))),
fn match_month_name(bytes: &[u8], pos: usize) -> Option<(u32, usize)> {
                pos = np;
                out.push(Token::Literal(bytes[i + 1] as char));
            }
        assert_eq!(fmt(midnight, "%h %p", FormatMode::Date).unwrap(), "12 AM");
                if c.is_whitespace() {
            b'D' => Some(Token::D),
            return None;
    let mut i = 0;
            "AM".into()
enum Rendered {
}
            b'f' => Some(Token::F),
            }
            (None, None, _) => 0,
        // (PPL reference maps %c -> "MM", unlike stock MySQL); %P literal.
        "July",
    }
    E,
    }
                pos = np;
        assert_eq!(fmt(dt, "%U", FormatMode::Date).unwrap(), "11");
    fn sample() -> DateTime<Utc> {
        p += 1;
            .all(|(a, b)| a.eq_ignore_ascii_case(b))
        Token::XUpper => date_only!(Str(format!("{:04}", week_year_sunday_first(dt)))),
    C,
                    return None;
    let mut out = String::with_capacity(format.len() + 16);
            Token::YUpper | Token::XUpper | Token::XLower => {
        for (d, want) in [
}
        Weekday::Wed => "Wednesday",
    const SHORT: [&str; 12] = [
    #[test]
        "May",
    let mut p = pos;
                if !(1..=31).contains(&v) {
            b'c' => Some(Token::C),
        wn
        assert!(fmt(dt, "%W", FormatMode::Time).is_none());
        assert_eq!(p.to_naive().unwrap().to_string(), "2020-03-01 00:00:00");
    T,
    if wn == 0 {
    J,
    } else {
            (13, "13th"),
            }
                f.day = Some(v);
            }
        Weekday::Fri => 4,
                    return None;
    fn parse_rejects_bad_input() {
            b'M' => Some(Token::MUpper),
    #[test]
            format!("{:02}", dt.month())
}
        let date = chrono::NaiveDate::from_ymd_opt(year, month, day)?;
        Weekday::Thu => "Thursday",
        Token::UUpper => date_only!(Str(format!("{:02}", week_number_sunday_first(dt)))),
        }
        Token::P => Str(if dt.hour() < 12 {
            ),
        // DateTimeFormatterUtil maps %c -> "MM" in date mode), which differs from stock MySQL's
    VUpper,
    pub hour: Option<u32>,
            }
        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
                }
            "{:02}:{:02}:{:02} {}",
    let wn = week_number_monday_first(dt);
    while p < bytes.len() && pred(bytes[p]) {
/*
            (mo.unwrap_or(1), d.unwrap_or(1))
        assert_eq!(fmt(noon, "%h %p", FormatMode::Date).unwrap(), "12 PM");
    #[test]
fn week_number_monday_first_01(dt: DateTime<Utc>) -> u32 {
        assert_eq!(p.to_naive().unwrap().to_string(), "2017-10-23 00:00:00");
        let time = chrono::NaiveTime::from_hms_micro_opt(
            }
            Token::ILower => {
        Weekday::Tue => 1,
    match w {
            i += 1;
            self.minute.unwrap_or(0),
        let want = "Sat Jan 01 31st 31 31 012345 13 01 01 14 031 13 1 January 01 PM 01:14:15 PM 15 15 13:14:15 % P";
            "0".into()
    }
        Weekday::Sun => "Sun",
fn consume_while<F: Fn(u8) -> bool>(bytes: &[u8], pos: usize, pred: F) -> usize {
    }
fn week_number_sunday_first_01(dt: DateTime<Utc>) -> u32 {
    }
    let wn = week_number_sunday_first(dt);
        } else {
        Token::XLower => date_only!(Str(format!("{:04}", week_year_monday_first(dt)))),
    let s = std::str::from_utf8(&bytes[pos..end]).ok()?;
            y.is_some() || mo.is_some() || d.is_some() || self.day_of_year.is_some();
fn week_number_with_start(dt: DateTime<Utc>, start: Weekday) -> u32 {
                if v > 12 {
            .single()
    YUpper,
        "July",
            (None, Some(h12), Some(true)) => (h12 % 12) + 12,
        return None;
pub(crate) struct Parsed {
                }
            b'T' => Some(Token::T),
            }
            Token::B | Token::MUpper => {
}
                if matches!(tok, Token::D) {
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
    }
        if matches_ci(tail, name.as_bytes()) {
            }
        // consumed letters and month silently defaulted to 1.
    MLower,
}
                // MySQL pivots: 00-69→2000-2069, 70-99→1970-1999.
        "February",
            b'I' => Some(Token::IUpper),
    out
            b'b' => Some(Token::B),
fn week_number_monday_first(dt: DateTime<Utc>) -> u32 {
    fn parse_month_name_tokens() {
    fn parse_h12_rejects_above_twelve() {
                f.micros = Some(v);
        Token::R => Str(format!(
            None => {
}
        } else {
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
            "2020-03-15 10:30:45"
                if v > 59 {
        // Longest-first: "September" must not truncate to "Sep" with "tember…" left over.
            // PPL uses `today`; we emit the MySQL-compatible 2000-01-01 default for determinism.
            (3, "3rd"),
        let mut hour = match (self.hour, self.hour_12, self.pm) {
        }),
        );
    week_number_with_start(dt, Weekday::Mon)
    }
            b'i' => Some(Token::ILower),
        } else {
        let dt = sample();
            }
        let p = parse_os_strftime("march 1 2020", "%M %d %Y").unwrap();
    Char(char),
    .get(m as usize)
    use super::*;
                return None;
        dt.year()
            (4, "4th"),
        }
                f.month = Some(v);
                {
        "May",
fn month_full(m: u32) -> &'static str {
                    // Accept ISO-8601 `T` where the format expects whitespace.
            b'j' => Some(Token::J),
        "", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
    }
        }
        Weekday::Wed => "Wed",
                pos = np;
        assert_eq!(p.to_naive().unwrap().to_string(), "2017-10-23 00:00:00");
        Weekday::Sun => 6,
                pos = np;
                if m > 59 {
            Rendered::Str(s) => out.push_str(&s),
    fn unknown_directive_passes_through() {
    }
    }
            Some(t) => {
/// Decode a month name (full or abbreviated, case-insensitive) starting at `pos`.
        let p = parse_os_strftime("2017-10-23T00:00:00", "%Y-%m-%d %h:%i:%s").unwrap();
        "December",
                }
//! mirrors PPL's `DateTimeFormatterUtil`. `%U`/`%u` are unpadded simple Sun-/Mon-first counts;
        // testStrToDate's `'1-May-13'` / `%d-%b-%y` assertion. Without this, %b just
        let (month, day) = if let Some(doy) = self.day_of_year {
    B,
            Token::P => {
        )?;
            .unwrap();
            if pos == 0 {
        Weekday::Mon => 0,
        _ => "th",
        } else {
    fn date_mode_common_tokens() {
                    return None;
        let p = parse_os_strftime("00:00:00 AM", "%r").unwrap();
        ($body:expr) => {{
    K,
    SUpper,
        if i + 1 >= bytes.len() {
        "December",
                pos = np;
    let mut out = Vec::with_capacity(bytes.len());
    #[test]
    let mut f = Parsed::default();
        Token::VUpper => date_only!(Str(format!("{:02}", week_number_sunday_first_01(dt)))),
fn render_token(tok: Token, dt: DateTime<Utc>, mode: FormatMode) -> Option<Rendered> {
                let (m, np) = read_digits(input_bytes, pos, 1, 2)?;
        Weekday::Fri => "Fri",
                f.year = Some(if yy < 70 { 2000 + yy } else { 1900 + yy });
            b'%' => Some(Token::Literal('%')),
    #[test]
            b'd' => Some(Token::DLower),
    if (11..=13).contains(&(day % 100)) {
        }),
            // Month-name tokens back-solve to f.month (Java's `LLL`/`LLLL` formatter pattern in
            }
    #[test]
    fn parse_h12_accepts_zero() {
            (23, "23rd"),
            // derive month/day from a weekday alone (it would need a calendar context).
        Weekday::Mon => "Monday",
    Some(f)
            b'h' => Some(Token::HLower),
        "PM" => f.pm = Some(true),
    if h == 0 {
            .unwrap()
    }
    } else {
        // 1998-01-31 (Saturday): all four week tokens render `04`.
        Token::J => date_only!(Str(format!("{:03}", dt.ordinal()))),
}
        let dt = sample(); // 2020-03-15 = Sunday
    while i < bytes.len() {
            b'u' => Some(Token::ULower),
                }
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
            b'P' => Some(Token::PUpper),
    pub second: Option<u32>,
            "00".into()
        Token::L => Str(twelve_hour(dt.hour()).to_string()),
                f.hour = Some(h);
    MUpper,
fn weekday_idx(w: Weekday) -> u32 {
        }
    const FULL: [&str; 12] = [
        assert_eq!(fmt(sample(), "%Y-%q", FormatMode::Date).unwrap(), "2020-%q");
    let mut pos = 0;
                f.hour_12 = Some(v);
            (date.month(), date.day())
            Token::DLower | Token::E | Token::D => {
    pub(crate) fn to_naive(&self) -> Option<chrono::NaiveDateTime> {
                let (h, np) = read_digits(input_bytes, pos, 1, 2)?;
            }
                pos = np;
        }
        Token::WLower => date_only!(Str(dt.weekday().number_from_monday().to_string())),
}
            dt.day().to_string()
    #[test]
        assert_eq!(fmt(dt, "%v", FormatMode::Date).unwrap(), "10");
                let (h, np) = read_digits(input_bytes, pos, 1, 2)?;
                    return None;
                    return None;
use chrono::{DateTime, Datelike, TimeZone, Timelike, Utc, Weekday};
    fn ordinal_suffix_edges() {
        };
        };
            assert_eq!(fmt(dt, "%D", FormatMode::Date).unwrap(), want, "day={d}");
            pos += 1;
                if v > 23 {
        assert_eq!(
            .and_hms_micro_opt(13, 14, 15, 12_345)
        } else {
    }
        let p = parse_os_strftime("2017-10-23", "%Y-%m-%d %h:%i:%s").unwrap();
        dt.year() - 1
// Token variants map 1:1 to MySQL `%X` directives; `Literal` wraps non-directive chars.
        // An empty input (pos still 0) is a hard failure — don't let it default to all zeros.
//! `%V`/`%v` are the same with week 0 remapped to the prior year's last week.
        Token::B => date_only!(Str(month_short(dt.month()).into())),
        if pos >= input_bytes.len() {
    }
        (doy - first_start_doy) / 7 + 1
    }
                }
//! Shared MySQL format-token translator (date_format / time_format / str_to_date);
    pub pm: Option<bool>,
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
            Token::F => {
            fmt(dt, "%Y-%m-%d %H:%i:%S", FormatMode::Date).unwrap(),
        }
    for tok in tokens {
        );
}
                let (v, np) = read_digits(input_bytes, pos, 1, 4)?;
fn matches_ci(haystack: &[u8], needle: &[u8]) -> bool {
        // Time mode keeps the reference's single-"0" literal (TIME_HANDLERS maps %c -> "0").
        Token::ILower => Str(format!("{:02}", dt.minute())),
    }
}
            "00".into()
        Some(chrono::NaiveDateTime::new(date, time))
        assert!(parse_os_strftime("Foo 4 2020", "%M %d %Y").is_none());
pub(crate) enum FormatMode {
                pos = expect_literal(input_bytes, np, b':')?;
            "0000".into()
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
// DateTimeFormatterUtil.parseStringWithDateOrTime (lenient widths, trailing
        }),
                    continue;
            1_584_268_245_123_456
    PUpper,
    SLower,
            fmt(dt, "%W, %M %D, %Y", FormatMode::Date).unwrap(),
        } else {
fn ordinal_suffix(day: u32) -> &'static str {
            Token::PUpper => {
                f.second = Some(s);
        wn
    } else {
    Some(pos + 1)
}
                pos = np;
    }
                out.push(Token::Literal('%'));
        }),
            b'm' => Some(Token::MLower),
    for (i, name) in SHORT.iter().enumerate() {
            break;
        // %b (abbreviated) and %M (full) must back-solve to f.month — covers PPL
        assert_eq!(p.to_naive().unwrap().time().to_string(), "13:30:45");
 *
            (11, "11th"),
                pos = np;
    }
            (2, "2nd"),
enum Token {
        Token::YLower => Str(if time_mode {
        return None;
    }
    fn date_format_timestamp_full_token_set() {
    match w {
            twelve_hour(dt.hour()),
        let tok = match bytes[i + 1] {
        assert!(fmt(dt, "%a %H:%i", FormatMode::Time).is_none());
        format_datetime(dt, f, m)
                }
            fmt(dt, "%h:%i:%s %p", FormatMode::Date).unwrap(),
    #[test]
    }
            "00".into()
        assert_eq!(p.to_naive().unwrap().to_string(), "2017-10-23 00:00:00");
fn week_number_sunday_first(dt: DateTime<Utc>) -> u32 {
/// Differs from ISO week when Jan 1 falls Tue-Sat (MySQL keeps those days as last-of-prior-year).
            let ndt = parse_os_strftime(input, format)
 * compatible open source license.
    HUpper,
                i += 2;
        return "th";
                }
        Weekday::Mon => "Mon",
            p.to_naive().unwrap().and_utc().timestamp_micros(),
    }
    }
}
        "August",
                    pos += 1;
    let jan1 = chrono::NaiveDate::from_ymd_opt(dt.year(), 1, 1).unwrap();
        let noon = Utc.with_ymd_and_hms(2020, 1, 1, 12, 0, 0).unwrap();
            "04 04 04 04 Saturday 6 1998 1998 1998 98"
    VLower,
    macro_rules! date_only {
                f.day_of_year = Some(v);
                }
                }
    Str(String),
                f.minute = Some(m);
            Str(format!("{}{}", d, ordinal_suffix(d)))
    }
                pos += 1;
            format!("{:04}", dt.year())
            // PPL's reference DateTimeFormatterUtil decodes month names). Accept both full and
            "0".into()
}
    if pos + 2 > bytes.len() {
mod tests {
        Token::DLower => Str(if time_mode {
        Token::Literal(c) => Char(c),
        Token::SUpper | Token::SLower => Str(format!("{:02}", dt.second())),
    [
fn twelve_hour(h: u32) -> u32 {
        );
    fn twelve_hour_tokens() {
    }
            b'e' => Some(Token::E),
            Token::Literal(c) => {
 * SPDX-License-Identifier: Apache-2.0
    #[test]
        for (input, format, expected) in [
    }
            Rendered::Char(c) => out.push(c),
        Weekday::Sun => "Sunday",
        assert_eq!(
/// Returns `(month, next_pos)` on a match. Tries the longer (full) name first so
        let p = parse_os_strftime("2017-10-23 00:00:00", "%Y-%m-%d %h:%i:%s").unwrap();
        if matches_ci(tail, name.as_bytes()) {
    }
            "0000-00-00 10:30:45"
        Token::VLower => date_only!(Str(format!("{:02}", week_number_monday_first_01(dt)))),
        // Unknown name → None.
            }
    Some(pos + 2)
        if !has_date_parts && !has_time {
    use chrono::TimeZone;
                pos = expect_literal(input_bytes, np, b':')?;
    // Helper: date-only tokens in time-mode → whole render collapses to NULL.
    for (i, name) in FULL.iter().enumerate() {
 */
    UUpper,
                let (s, np) = read_digits(input_bytes, pos, 1, 2)?;
            (
 * this file be licensed under the Apache-2.0 license or a
    [
                }
            break;
    }
            b'p' => Some(Token::P),
        Weekday::Sat => "Saturday",
            }
            Token::HLower | Token::IUpper | Token::L => {
    fn parse_lenient_when_input_runs_out_before_format() {
    let offset = days_until_start(jan1.weekday(), start);
        h
        12
                let (v, np) = read_digits(input_bytes, pos, 1, 3)?;
                pos = read_am_pm(input_bytes, pos, &mut f)?;
        assert_eq!(
                .to_naive()
        if hour > 23 {
    Some(r)
        "March",
            (Some(h), _, _) => h,
            dt.minute(),
            "PM".into()
            format!("{:02}", dt.month())
        assert_eq!(
        }
        assert_eq!(p.to_naive().unwrap().time().to_string(), "00:00:00");
    } else {
            b'y' => Some(Token::YLower),
            .unwrap()
                f.year = Some(v as i32);
    IUpper,
                }
                .unwrap()
                if m > 59 {
    .copied()
    fn time_mode_masks_date_tokens() {
        Weekday::Tue => "Tue",
fn expect_literal(bytes: &[u8], pos: usize, expected: u8) -> Option<usize> {
        "September",
            }
                    }
            }
            self.micros.unwrap_or(0),
        } else {
        );
        let p = parse_os_strftime("2020-03", "%Y-%m-%d").unwrap();
        )),
                i += 2;
            (None, Some(h12), _) => h12 % 12,
    }
        Token::PUpper => Char('P'),
            (12, "12th"),
        "June",
    D,
impl Parsed {
        "August",
        }
}
        "October",
}
        ] {
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
}
        "September",
    fn week_tokens_iso_and_first_day() {
        let midnight = Utc.with_ymd_and_hms(2020, 1, 1, 0, 0, 0).unwrap();
        );
    }
            format!("{:02}", dt.day())
            Token::MLower | Token::C => {
    Date,
}
                    return None;
    DLower,
        // 2020-03-15 10:30:45.123456 UTC (Sunday)
        let ts = chrono::NaiveDate::from_ymd_opt(1998, 1, 31)
            "Sunday, March 15th, 2020"
 * The OpenSearch Contributors require contributions made to
    }
            Token::SUpper | Token::SLower => {
            // %P consumes a single literal P (mirrors the formatter's pass-through behavior)
        let p = parse_os_strftime("23-Oct-17 00:00:00", "%d-%b-%y %h:%i:%s").unwrap();
    fn parse_iso_t_separator_accepted_for_format_space() {
        Weekday::Thu => "Thu",
    #[test]
                }
        match tok {
            if dt.hour() < 12 { "AM" } else { "PM" }
        }),
        }),
        Token::E => Str(if time_mode {
                pos = np;
        Weekday::Sat => "Sat",
        // no-leading-zero %c. PPL semantics are the contract on the analytics-engine route.
}
        let p = parse_os_strftime("01:30:45 PM", "%h:%i:%s %p").unwrap();
            b'V' => Some(Token::VUpper),
// input tolerated, MySQL defaults year=2000/month=1/day=1).
}
}
    for tok in tokens {
        // PPL bug-for-bug: %w uses Mon=1..Sun=7 despite MySQL docs claiming Sun=0.
    }
        "April",
            Token::T => {
            b'a' => Some(Token::A),
            let dt = Utc.with_ymd_and_hms(2020, 1, d, 0, 0, 0).unwrap();
        "June",
            // Weekday-name tokens: consume letters without back-solving — PPL's parser doesn't
#[derive(Default, Debug)]
        let dt = chrono::Utc.from_utc_datetime(&ts);
    .unwrap_or("")
            // and PPL inherits that. Case-insensitive.
                "2020-03-15 10:30:45",
        "November",
        }
        Token::MUpper => date_only!(Str(month_full(dt.month()).into())),
        3 => "rd",
            b'r' => Some(Token::R),
                let (m, np) = read_digits(input_bytes, pos, 1, 2)?;
    #[test]
            if time_mode {
    pub year: Option<i32>,
}
        assert_eq!(ndt.to_string(), "2013-05-01 00:00:00");
        Token::D => date_only!({
    #[test]
                f.second = Some(v);
        Weekday::Sat => 5,
            self.second.unwrap_or(0),
    #[test]
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
            b'Y' => Some(Token::YUpper),
        week_number_monday_first(last_dt)
        Weekday::Thu => 3,
        let year = y.unwrap_or(2000);
            Token::R => {
                }
    pub micros: Option<u32>,
        _ => return None,
            "{:02}:{:02}:{:02}",
                    return None;
        let p = parse_os_strftime("2020-03-15 10:30:45.123456", "%Y-%m-%d %H:%i:%S.%f").unwrap();
            (21, "21st"),
    let input_bytes = input.as_bytes();
                f.hour_12 = Some(h);
            out.push(Token::Literal(bytes[i] as char));
    } else {
    }
    let r = match tok {
    pub hour_12: Option<u32>,
            Token::A | Token::W => {
        let has_date_parts =
            b'x' => Some(Token::XLower),
    .unwrap_or("")
            ("2020-03-15 extra", "%Y-%m-%d", "2020-03-15 00:00:00"),
            return Some((i as u32 + 1, pos + name.len()));
            let d = dt.day();
                }
            }
                pos = consume_while(input_bytes, pos, |b| b.is_ascii_alphabetic());
                if s > 59 {
                f.second = Some(s);
        Token::YUpper => Str(if time_mode {
        Weekday::Fri => "Friday",
        let (y, mo, d) = (self.year, self.month, self.day);
        // Input exhausted before format: trailing tokens default to zero via Parsed::to_naive.
                pos = expect_literal(input_bytes, np, b':')?;
            (1, "1st"),
    ULower,
            }
            }
                .unwrap();
                pos = np;
        "",
    ILower,
                    if pos < input_bytes.len() && input_bytes[pos] == b'T' {
/// `%V` — MySQL mode 2: Sunday-first, 01..53; week 0 remaps to prior year's last week.
    #[test]
        }
            b'v' => Some(Token::VLower),
        assert_eq!(
        }
        )),
        assert_eq!(
                pos = read_am_pm(input_bytes, pos, &mut f)?;
        "October",
        assert_eq!(p.to_naive().unwrap().to_string(), "2017-10-23 00:00:00");
                f.hour = Some(v);
        Token::W => date_only!(Str(weekday_full(dt.weekday()).into())),
fn week_year_sunday_first(dt: DateTime<Utc>) -> i32 {
        // %U/%u/%V/%v zero-padded to width 2 (MySQL docs); %v is MySQL mode 3 (Monday-first, 01..53), distinct from ISO.
                pos = np;
    Some((s.parse().ok()?, end))
                "%Y-%m-%d %H:%i:%S",
                }
    fn parse_roundtrip_and_defaults() {
                }
        Weekday::Tue => "Tuesday",
                    return None;
/// In `Time` mode, date-only numeric tokens emit MySQL's literal padding (`%d`→"00", `%Y`→"0000",
    let mut end = pos;
        // %P is non-MySQL; PPL passes the trailing letter through verbatim
fn weekday_full(w: Weekday) -> &'static str {
}
        while pos < input_bytes.len() && (input_bytes[pos] as char).is_whitespace() {
        let p = parse_os_strftime("12:00:00 AM", "%h:%i:%s %p").unwrap();
        week_number_sunday_first(last_dt)
    if pos >= bytes.len() || bytes[pos] != expected {
                if h > 12 {
                    return None;
            assert_eq!(ndt.to_string(), expected, "input={input}");
    HLower,
        Token::C => Str(if time_mode {
        "AM" => f.pm = Some(false),
}
    Time,
    }
            Token::HUpper | Token::K => {
    WLower,
            (22, "22nd"),
                    return None;
        assert_eq!(p.to_naive().unwrap().time().to_string(), "00:00:00");
        ] {
    }
            format!("{:02}", dt.year() % 100)
    #[test]
        Utc.timestamp_micros(1_584_268_245_123_456)
                let (v, np) = read_digits(input_bytes, pos, 1, 6)?;
                pos = expect_literal(input_bytes, np, b':')?;
                    return None;
    ];
                if pos >= input_bytes.len() || input_bytes[pos] as char != c {
            b'H' => Some(Token::HUpper),
            }
    pub day: Option<u32>,
}
fn month_short(m: u32) -> &'static str {
}
        assert!(parse_os_strftime("not-a-date", "%Y-%m-%d").is_none());
    P,
    }
        let ndt = p.to_naive().unwrap();
        assert!(parse_os_strftime("2020-13-01", "%Y-%m-%d").is_none());
    YLower,
        } else {
/// `%c`/`%e`→"0"); date name-tokens (`%a` `%b` `%M` `%W` `%D`) collapse the render to `None`.
            dt.second()
    if week_number_monday_first(dt) == 0 {
    }
}
        Token::K => Str(dt.hour().to_string()),
            Token::J => {
                    pos = consume_while(input_bytes, pos, |b| b.is_ascii_alphabetic());
        let jan31 = Utc.with_ymd_and_hms(1998, 1, 31, 0, 0, 0).unwrap();
        "January",
            dt.hour(),
                let yy = v as i32;
                f.minute = Some(v);
        dt.year() - 1
            Token::YLower => {
    haystack.len() >= needle.len()
    let tail = bytes.get(pos..)?;
    use Rendered::*;
        return None;
                f.minute = Some(m);
    fn parse_12hr_with_am_pm() {
        let dt = sample();
        Token::MLower => Str(if time_mode {
        // %U/%u/%V/%v render zero-padded to width 2 (matches MySQL docs and PPL DateTimeFormatterUtil).
        2 => "nd",
                if pos >= input_bytes.len()
    let s: &str = std::str::from_utf8(&bytes[pos..pos + 2]).ok()?;
    ];
        let has_time = self.hour.is_some() || self.hour_12.is_some();
    }
        );
    let doy = dt.ordinal();
                f.month = Some(m);
                if v > 59 {
    if doy < first_start_doy {
    }
                    return None;
            b'S' => Some(Token::SUpper),
        "January",
    if end - pos < min {
        }};
    R,
    fn fmt(dt: DateTime<Utc>, f: &str, m: FormatMode) -> Option<String> {
    pub month: Option<u32>,
    };
        0
    let h = h % 12;
            "10:30:45 AM"
                "2020-03-15 10:30:45",
    ]
                pos = np;
    XLower,
            b'l' => Some(Token::L),
    A,
            b'W' => Some(Token::W),
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
                    || (input_bytes[pos] != b'P' && input_bytes[pos] != b'p')
    }
        // Case-insensitive: PPL's Java `LLLL` parser tolerates lower/mixed case.
        && haystack[..needle.len()]
    None
        if bytes[i] != b'%' {
            Token::UUpper | Token::ULower | Token::VUpper | Token::VLower | Token::WLower => {
        let p = parse_os_strftime("1-May-13", "%d-%b-%y").unwrap();
    let time_mode = matches!(mode, FormatMode::Time);
        }),
        "February",
        // Full token set from CalciteDateTimeFunctionIT.testDateFormat: %c is zero-padded month
}
    pub day_of_year: Option<u32>,
        "November",
/// `%x` — year for the Monday-first 01..53 week numbering used by `%v`.
    while end < bytes.len() && end - pos < max && bytes[end].is_ascii_digit() {
    ]
    }
                pos += 1;
            (31, "31st"),
    } else {
        let last = chrono::NaiveDate::from_ymd_opt(dt.year() - 1, 12, 31).unwrap();
                }
        assert_eq!(p.to_naive().unwrap().to_string(), "2024-09-09 00:00:00");
    match day % 10 {
/// `September` doesn't get truncated to `Sep` with `tember` left as dangling input.
    L,
            _ => None,
        match tok {
}
                    return None;
        dt.year()
        Token::HUpper => Str(format!("{:02}", dt.hour())),
                pos = np;
    F,
    XUpper,
    }
    let tokens = tokenize(format);
                out.push(t);
            b'U' => Some(Token::UUpper),
            }
            return Some((i as u32 + 1, pos + name.len()));
            b'X' => Some(Token::XUpper),
    fn parse_fractional_seconds() {
