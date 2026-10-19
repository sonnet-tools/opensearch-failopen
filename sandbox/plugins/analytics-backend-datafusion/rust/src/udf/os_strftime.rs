        if bytes[i] != b'%' {
        }
    }
            b'T' => Some(Token::T),
        Token::HUpper => Str(format!("{:02}", dt.hour())),
    Date,
        // Time mode keeps the reference's single-"0" literal (TIME_HANDLERS maps %c -> "0").
    for tok in tokens {
fn weekday_short(w: Weekday) -> &'static str {
        Weekday::Wed => "Wednesday",
    }
        let p = parse_os_strftime("00:00:00 AM", "%r").unwrap();
    fn time_mode_masks_date_tokens() {
    MUpper,
            break;
        Token::F => Str(format!("{:06}", dt.nanosecond() / 1_000)),
            // derive month/day from a weekday alone (it would need a calendar context).
pub(crate) fn parse_os_strftime(input: &str, format: &str) -> Option<Parsed> {
                .unwrap()
    .copied()
            assert_eq!(fmt(dt, "%D", FormatMode::Date).unwrap(), want, "day={d}");
    let mut i = 0;
    }
}
            b'X' => Some(Token::XUpper),
    macro_rules! date_only {
    while i < bytes.len() {
        let midnight = Utc.with_ymd_and_hms(2020, 1, 1, 0, 0, 0).unwrap();
    fn date_mode_common_tokens() {
                // MySQL accepts "00" for %h/%I/%l; Parsed::to_naive maps h12=0 → hour 0.
        // Input exhausted before format: trailing tokens default to zero via Parsed::to_naive.
                out.push(t);
        assert_eq!(fmt(noon, "%h %p", FormatMode::Date).unwrap(), "12 PM");
        // Unknown name → None.
    pub micros: Option<u32>,
        let dt = sample();
    #[test]
}
    }
                .unwrap();
    fn parse_h12_rejects_above_twelve() {
fn week_number_sunday_first(dt: DateTime<Utc>) -> u32 {
                if pos >= input_bytes.len() || input_bytes[pos] as char != c {
        }),
        // Full token set from CalciteDateTimeFunctionIT.testDateFormat: %c is zero-padded month
            return None;
    week_number_with_start(dt, Weekday::Mon)
            Token::MLower | Token::C => {
            .unwrap();
            ),
        } else {
        dt.year()
    ILower,
        let want = "Sat Jan 01 31st 31 31 012345 13 01 01 14 031 13 1 January 01 PM 01:14:15 PM 15 15 13:14:15 % P";
                let (v, np) = read_digits(input_bytes, pos, 1, 3)?;
        assert!(parse_os_strftime("2020-13-01", "%Y-%m-%d").is_none());
    } else {
                pos = np;
                pos = np;
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
        Token::B => date_only!(Str(month_short(dt.month()).into())),
                if v > 59 {
            b'x' => Some(Token::XLower),
    J,
    if (11..=13).contains(&(day % 100)) {
        }),
        week_number_sunday_first(last_dt)
    }
            "PM".into()
            $body
    IUpper,
            // abbreviated forms regardless of which token was specified — MySQL is lenient here
    let s = std::str::from_utf8(&bytes[pos..end]).ok()?;
            }
            b'w' => Some(Token::WLower),
                if pos >= input_bytes.len()
 *
    fn parse_lenient_when_input_runs_out_before_format() {
        Weekday::Sun => "Sun",
    let input_bytes = input.as_bytes();
        end += 1;
    #[test]
        }
            }
    week_number_with_start(dt, Weekday::Sun)
        dt.year() - 1
    fn parse_month_name_tokens() {
            Token::ILower => {
    UUpper,
/// `%x` — year for the Monday-first 01..53 week numbering used by `%v`.
            (mo.unwrap_or(1), d.unwrap_or(1))
                i += 2;
            Token::Literal(c) => {
}
                    return None;
    out
        assert_eq!(p.to_naive().unwrap().to_string(), "2017-10-23 00:00:00");
            (3, "3rd"),
            b'S' => Some(Token::SUpper),
    }
 * The OpenSearch Contributors require contributions made to
}
        "",
            if pos == 0 {
 * SPDX-License-Identifier: Apache-2.0
        format_datetime(dt, f, m)
        week_number_monday_first(last_dt)
        "October",
            (None, Some(h12), _) => h12 % 12,
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
        )),
        p += 1;
    Some(pos + 2)
        let jan31 = Utc.with_ymd_and_hms(1998, 1, 31, 0, 0, 0).unwrap();
            }
    let tokens = tokenize(format);
    [
        // DateTimeFormatterUtil maps %c -> "MM" in date mode), which differs from stock MySQL's
                    return None;
        Token::PUpper => Char('P'),
                f.day_of_year = Some(v);
    }
            continue;
fn week_year_monday_first(dt: DateTime<Utc>) -> i32 {
        _ => "th",
            b'c' => Some(Token::C),
        }),
                let (m, np) = read_digits(input_bytes, pos, 1, 2)?;
    }
/// `%V` — MySQL mode 2: Sunday-first, 01..53; week 0 remaps to prior year's last week.
        "January",
                out.push(Token::Literal(bytes[i + 1] as char));
        Utc.timestamp_micros(1_584_268_245_123_456)
            out.push(Token::Literal(bytes[i] as char));
        assert_eq!(
        let time = chrono::NaiveTime::from_hms_micro_opt(
fn weekday_idx(w: Weekday) -> u32 {
}
        // no-leading-zero %c. PPL semantics are the contract on the analytics-engine route.
    let time_mode = matches!(mode, FormatMode::Time);
/// `September` doesn't get truncated to `Sep` with `tember` left as dangling input.
        "February",
    let tail = bytes.get(pos..)?;
                }
        // testStrToDate's `'1-May-13'` / `%d-%b-%y` assertion. Without this, %b just
            .iter()
    let jan1 = chrono::NaiveDate::from_ymd_opt(dt.year(), 1, 1).unwrap();
    }
    }
    R,
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
/*
            (Some(h), _, _) => h,
        for (input, format, expected) in [
                    || (input_bytes[pos] != b'P' && input_bytes[pos] != b'p')
                    return None;
    fn week_tokens_iso_and_first_day() {
        (doy - first_start_doy) / 7 + 1
                    return None;
            p.to_naive().unwrap().and_utc().timestamp_micros(),
        match tok {
            (1, "1st"),
        Weekday::Tue => "Tuesday",
    }
    L,
            }
        "August",
            Some(t) => {
fn match_month_name(bytes: &[u8], pos: usize) -> Option<(u32, usize)> {
                pos = expect_literal(input_bytes, np, b':')?;
            b's' => Some(Token::SLower),
}
            fmt(jan31, "%U %u %V %v %W %w %X %x %Y %y", FormatMode::Date).unwrap(),
        } else {
    #[test]
            }
        assert!(parse_os_strftime("", "%Y").is_none());
        let p = parse_os_strftime("1-May-13", "%d-%b-%y").unwrap();
                if !(1..=366).contains(&v) {
    HUpper,
fn week_year_sunday_first(dt: DateTime<Utc>) -> i32 {
            }
                }
        assert_eq!(fmt(dt, "%U", FormatMode::Date).unwrap(), "11");
            b'i' => Some(Token::ILower),
            return Some((i as u32 + 1, pos + name.len()));
    fn parse_roundtrip_and_defaults() {
            format!("{:02}", dt.year() % 100)
            i += 1;
                pos = np;
                    return None;
        let p = parse_os_strftime("2017-10-23 00:00:00", "%Y-%m-%d %h:%i:%s").unwrap();
}
        Weekday::Sat => "Saturday",
        return None;
                }
                    return None;
            "0000-00-00 10:30:45"
                    return None;
            b'W' => Some(Token::W),
/// In `Time` mode, date-only numeric tokens emit MySQL's literal padding (`%d`→"00", `%Y`→"0000",
                }
            Token::YLower => {
// Token variants map 1:1 to MySQL `%X` directives; `Literal` wraps non-directive chars.
}
    let r = match tok {
        }
            }
    .unwrap_or("")
    ]
            self.micros.unwrap_or(0),
        } else {
                pos = np;
        ] {
/// Decode a month name (full or abbreviated, case-insensitive) starting at `pos`.
            twelve_hour(dt.hour()),
                f.month = Some(v);
    fn date_format_timestamp_full_token_set() {
                pos += 1;
            b'l' => Some(Token::L),
    E,
 * this file be licensed under the Apache-2.0 license or a
                pos = np;
            let ndt = parse_os_strftime(input, format)
    Some(r)
    #[test]
    match w {
            Rendered::Str(s) => out.push_str(&s),
                f.minute = Some(m);
        Token::ILower => Str(format!("{:02}", dt.minute())),
    }
        12
        let last_dt = Utc.from_utc_datetime(&last.and_hms_opt(0, 0, 0).unwrap());
        match render_token(tok, dt, mode)? {
            // Weekday-name tokens: consume letters without back-solving — PPL's parser doesn't
        let has_date_parts =
    #[test]
        let last = chrono::NaiveDate::from_ymd_opt(dt.year() - 1, 12, 31).unwrap();
            }
        dt.year() - 1
        assert_eq!(p.to_naive().unwrap().to_string(), "2020-03-01 00:00:00");
fn ordinal_suffix(day: u32) -> &'static str {
        let dt = sample(); // 2020-03-15 = Sunday
        let p = parse_os_strftime("2017-10-23", "%Y-%m-%d %h:%i:%s").unwrap();
                let yy = v as i32;
    if week_number_monday_first(dt) == 0 {
                pos = expect_literal(input_bytes, np, b':')?;
        Weekday::Mon => "Monday",
        Token::K => Str(dt.hour().to_string()),
    fn parse_h12_accepts_zero() {
            (
        "February",
    }
                    // Accept ISO-8601 `T` where the format expects whitespace.
    fn parse_fractional_seconds() {
// input tolerated, MySQL defaults year=2000/month=1/day=1).
        // Longest-first: "September" must not truncate to "Sep" with "tember…" left over.
}
        Token::P => Str(if dt.hour() < 12 {
                "%Y-%m-%d %H:%i:%S",
    }
    }
                if v > 12 {
    #[test]
        "April",
        1 => "st",
    }
            b'b' => Some(Token::B),
                if v > 23 {
            .single()
fn render_token(tok: Token, dt: DateTime<Utc>, mode: FormatMode) -> Option<Rendered> {
        Token::W => date_only!(Str(weekday_full(dt.weekday()).into())),
                while pos < input_bytes.len() && (input_bytes[pos] as char).is_whitespace() {
        ($body:expr) => {{
                pos = np;
    // Helper: date-only tokens in time-mode → whole render collapses to NULL.
fn matches_ci(haystack: &[u8], needle: &[u8]) -> bool {
            "0".into()
    pub minute: Option<u32>,
                f.day = Some(v);
                }
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
}
            }
    VLower,
        && haystack[..needle.len()]
    if h == 0 {
}
            ("10:30:45", "%H:%i:%S", "2000-01-01 10:30:45"),
    let mut pos = 0;
        Weekday::Fri => "Friday",
            // %P consumes a single literal P (mirrors the formatter's pass-through behavior)
    let mut out = Vec::with_capacity(bytes.len());
    None
            format!("{:02}", dt.month())
                f.second = Some(s);
        assert!(parse_os_strftime("13:00:00", "%h:%i:%s").is_none());
}
    #[test]
        }
    if wn == 0 {
    if end - pos < min {
    }
    B,
        let p = parse_os_strftime("01:30:45 PM", "%h:%i:%s %p").unwrap();
        // %P is non-MySQL; PPL passes the trailing letter through verbatim
                f.micros = Some(v);
        "PM" => f.pm = Some(true),
        Weekday::Tue => "Tue",
                // MySQL pivots: 00-69→2000-2069, 70-99→1970-1999.
    match w {
    fn sample() -> DateTime<Utc> {
}
            b'f' => Some(Token::F),
        Token::SUpper | Token::SLower => Str(format!("{:02}", dt.second())),
    }
            }
    MLower,
                "2020-03-15 10:30:45",
            Token::SUpper | Token::SLower => {
    }
        let mut hour = match (self.hour, self.hour_12, self.pm) {
        ] {
            (12, "12th"),
                }
            }
    }
        "November",
            Token::HUpper | Token::K => {
                f.minute = Some(v);
            Token::P => {
                let (v, np) = read_digits(input_bytes, pos, 1, 6)?;
                if c.is_whitespace() {
        Token::MUpper => date_only!(Str(month_full(dt.month()).into())),
            (11, "11th"),
    const FULL: [&str; 12] = [
        assert_eq!(p.to_naive().unwrap().to_string(), "2017-10-23 00:00:00");
            (13, "13th"),
    K,
                }
            (2, "2nd"),
    .get(m as usize)
        }
    fn fmt(dt: DateTime<Utc>, f: &str, m: FormatMode) -> Option<String> {
        Token::UUpper => date_only!(Str(format!("{:02}", week_number_sunday_first(dt)))),
        assert_eq!(fmt(dt, "%v", FormatMode::Date).unwrap(), "10");
            }
    Str(String),
            b'h' => Some(Token::HLower),
        }};
    }
    match day % 10 {
                }
            Rendered::Char(c) => out.push(c),
fn twelve_hour(h: u32) -> u32 {
    let tokens = tokenize(format);
        _ => return None,
    p
}
    #[test]
    let mut f = Parsed::default();
            // Month-name tokens back-solve to f.month (Java's `LLL`/`LLLL` formatter pattern in
                pos = consume_while(input_bytes, pos, |b| b.is_ascii_alphabetic());
    VUpper,
    #[test]
                f.year = Some(if yy < 70 { 2000 + yy } else { 1900 + yy });
        return None;
    } else {
        let (month, day) = if let Some(doy) = self.day_of_year {
    A,
        } else {
        Weekday::Wed => "Wed",
    haystack.len() >= needle.len()
            b'M' => Some(Token::MUpper),
            fmt(dt, "%Y-%m-%d %H:%i:%S", FormatMode::Time).unwrap(),
    Some(pos + 1)
        }
                pos = np;
        assert_eq!(p.to_naive().unwrap().time().to_string(), "00:00:00");
                if matches!(tok, Token::D) {
#[cfg(test)]
    pub(crate) fn to_naive(&self) -> Option<chrono::NaiveDateTime> {
                pos = expect_literal(input_bytes, np, b':')?;
                .to_naive()
            Token::A | Token::W => {
/// Returns `(month, next_pos)` on a match. Tries the longer (full) name first so
            b'u' => Some(Token::ULower),
    SUpper,
        Token::T => Str(format!(
    Literal(char),
                    return None;
        while pos < input_bytes.len() && (input_bytes[pos] as char).is_whitespace() {
        2 => "nd",
        Token::A => date_only!(Str(weekday_short(dt.weekday()).into())),
pub(crate) struct Parsed {
            break;
        "October",
                    if pos < input_bytes.len() && input_bytes[pos] == b'T' {
        if !has_date_parts && !has_time {
        assert_eq!(
    }
                }
        "", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
    }
            .zip(needle.iter())
                }
        }
            Token::PUpper => {
    let mut p = pos;
            }
                {
                if h > 23 {
    }
            }
                f.hour_12 = Some(v);
        let noon = Utc.with_ymd_and_hms(2020, 1, 1, 12, 0, 0).unwrap();
    pub year: Option<i32>,
                    return None;
        assert!(parse_os_strftime("2017-10-23X00:00:00", "%Y-%m-%d %h:%i:%s").is_none());
impl Parsed {
        Token::HLower | Token::IUpper => Str(format!("{:02}", twelve_hour(dt.hour()))),
        );
                f.month = Some(m);
    HLower,
        "July",
            // and PPL inherits that. Case-insensitive.
    fn ordinal_suffix_edges() {
            }
        Weekday::Thu => "Thursday",
            "0".into()
        Token::XLower => date_only!(Str(format!("{:04}", week_year_monday_first(dt)))),
        );
        );
                    return None;
    SLower,
    #[test]
    XLower,
fn read_digits(bytes: &[u8], pos: usize, min: usize, max: usize) -> Option<(u32, usize)> {
        "March",
    }
        0
}
        }),
        Token::VUpper => date_only!(Str(format!("{:02}", week_number_sunday_first_01(dt)))),
    }
    .copied()
                    pos += 1;
            "00".into()
            }
        }),
        let p = parse_os_strftime("2020-03", "%Y-%m-%d").unwrap();
        }
                    return None;
            .unwrap()
                let (m, np) = read_digits(input_bytes, pos, 1, 2)?;
        "April",
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
        assert_eq!(p.to_naive().unwrap().to_string(), "2017-10-23 00:00:00");
        let fmtstr = "%a %b %c %D %d %e %f %H %h %I %i %j %k %l %M %m %p %r %S %s %T %% %P";
                if h > 12 {
        wn
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
        // %c emits the zero-padded month, matching the PPL reference (SQL-plugin
        "May",
            "00".into()
    F,
    } else {
        Token::DLower => Str(if time_mode {
        "December",
}
        assert_eq!(fmt(sample(), "%Y-%q", FormatMode::Date).unwrap(), "2020-%q");
            format!("{:02}", dt.day())
fn days_until_start(from: Weekday, start: Weekday) -> u32 {
        let year = y.unwrap_or(2000);
    use Rendered::*;
            b'p' => Some(Token::P),
    #[test]
                if m > 59 {
    ];
        "June",
        // %b (abbreviated) and %M (full) must back-solve to f.month — covers PPL
}
    }
fn week_number_monday_first(dt: DateTime<Utc>) -> u32 {
        Some(chrono::NaiveDateTime::new(date, time))
        if matches_ci(tail, name.as_bytes()) {
                let (s, np) = read_digits(input_bytes, pos, 1, 2)?;
                }
                let (s, np) = read_digits(input_bytes, pos, 1, 2)?;
            b'r' => Some(Token::R),
fn expect_literal(bytes: &[u8], pos: usize, expected: u8) -> Option<usize> {
        }
                if v > 59 {
        }
            assert_eq!(ndt.to_string(), expected, "input={input}");
                    }
        assert_eq!(p.to_naive().unwrap().to_string(), "2017-10-23 00:00:00");
            .unwrap()
            None => {
        for (d, want) in [
            hour = 23;
        assert_eq!(
    }
        let p = parse_os_strftime("23-Oct-17 00:00:00", "%d-%b-%y %h:%i:%s").unwrap();
}
    } else {
    if doy < first_start_doy {
        // 2020-03-15 10:30:45.123456 UTC (Sunday)
                f.hour = Some(h);
            b'Y' => Some(Token::YUpper),
                pos = np;
            dt.minute(),
            b'H' => Some(Token::HUpper),
        let last_dt = Utc.from_utc_datetime(&last.and_hms_opt(0, 0, 0).unwrap());
}
        }),
            Token::T => {
        let p = parse_os_strftime("September 9, 2024", "%M %d, %Y").unwrap();
        3 => "rd",
        assert_eq!(p.to_naive().unwrap().time().to_string(), "00:00:00");
        let p = parse_os_strftime("2020-03-15 10:30:45.123456", "%Y-%m-%d %H:%i:%S.%f").unwrap();
            b'j' => Some(Token::J),
            (23, "23rd"),
                }
/// Differs from ISO week when Jan 1 falls Tue-Sat (MySQL keeps those days as last-of-prior-year).
 * compatible open source license.
                let (h, np) = read_digits(input_bytes, pos, 1, 2)?;
        );
            }
    fn parse_iso_t_separator_accepted_for_format_space() {
    }
    }
            "Sunday, March 15th, 2020"
        Weekday::Sat => "Sat",
            out.push(Token::Literal('%'));
            b'v' => Some(Token::VLower),
        dt.year()
        assert_eq!(
                out.push(Token::Literal('%'));
            Token::F => {
        if matches_ci(tail, name.as_bytes()) {
                        pos += 1;
            }
            (None, Some(h12), Some(true)) => (h12 % 12) + 12,
                pos = np;
}
            self.second.unwrap_or(0),
            }
            (4, "4th"),
            b'k' => Some(Token::K),
            pos += 1;
        };
                pos = np;
                }
//! `%V`/`%v` are the same with week 0 remapped to the prior year's last week.
    pub pm: Option<bool>,
    let mut end = pos;
                }
                pos = read_am_pm(input_bytes, pos, &mut f)?;
fn weekday_full(w: Weekday) -> &'static str {
            fmt(dt, "%W, %M %D, %Y", FormatMode::Date).unwrap(),
}
        return None;
    match w {
            ("2020-03-15 extra", "%Y-%m-%d", "2020-03-15 00:00:00"),
            dt.second(),
        let dt = sample();
        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
            (date.month(), date.day())
        match tok {
        Token::YLower => Str(if time_mode {
        return "th";
                let (h, np) = read_digits(input_bytes, pos, 1, 2)?;
    pub day_of_year: Option<u32>,
                }
            b'a' => Some(Token::A),
        let last = chrono::NaiveDate::from_ymd_opt(dt.year() - 1, 12, 31).unwrap();
        assert!(parse_os_strftime("not-a-date", "%Y-%m-%d").is_none());
fn consume_while<F: Fn(u8) -> bool>(bytes: &[u8], pos: usize, pred: F) -> usize {
        } else {
                    return None;
    ULower,
}
    #[test]
        Weekday::Thu => "Thu",
            "2020-03-15 10:30:45"
        assert_eq!(p.to_naive().unwrap().to_string(), "2024-09-09 00:00:00");
        wn
        )),
    pub day: Option<u32>,
                "2020-03-15 10:30:45",
            fmt(dt, "%h:%i:%s %p", FormatMode::Date).unwrap(),
}
                f.second = Some(s);
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
    WLower,
#[derive(Default, Debug)]
            // PPL uses `today`; we emit the MySQL-compatible 2000-01-01 default for determinism.
 */
        Weekday::Sat => 5,
            "04 04 04 04 Saturday 6 1998 1998 1998 98"
    while p < bytes.len() && pred(bytes[p]) {
        Weekday::Wed => 2,
    let wn = week_number_sunday_first(dt);
        Token::L => Str(twelve_hour(dt.hour()).to_string()),
                    return None;
            format!("{:02}", dt.month())
    pub second: Option<u32>,
            ("2020", "%Y", "2020-01-01 00:00:00"),
            dt.hour(),
                f.hour = Some(v);
                    return None;
            b'd' => Some(Token::DLower),
                return None;
    }
                i += 2;
        Token::J => date_only!(Str(format!("{:03}", dt.ordinal()))),
    if wn == 0 {
        }
        if hour > 23 {
fn month_short(m: u32) -> &'static str {
        Token::ULower => date_only!(Str(format!("{:02}", week_number_monday_first(dt)))),
    Time,
        let has_time = self.hour.is_some() || self.hour_12.is_some();
                    pos = consume_while(input_bytes, pos, |b| b.is_ascii_alphabetic());
            if dt.hour() < 12 { "AM" } else { "PM" }
        Weekday::Tue => 1,
            let date = chrono::NaiveDate::from_yo_opt(year, doy)?;
}
        let ndt = p.to_naive().unwrap();
        assert!(parse_os_strftime("Foo 4 2020", "%M %d %Y").is_none());
    }
            1_584_268_245_123_456
    }
}
                }
        assert_eq!(fmt(dt, fmtstr, FormatMode::Date).unwrap(), want);
}
                pos = np;
        Weekday::Sun => 6,
                return None;
            "00".into()
                f.minute = Some(m);
        "March",
            dt.day().to_string()
    }
    fn parse_rejects_bad_input() {
    Some(f)
            b'%' => Some(Token::Literal('%')),
        Weekday::Fri => 4,
}
        assert_eq!(fmt(midnight, "%h %p", FormatMode::Date).unwrap(), "12 AM");
}
        "September",
            dt.second()
enum Token {
        Token::Literal(c) => Char(c),
        } else {
        assert_eq!(p.to_naive().unwrap().time().to_string(), "13:30:45");
        assert!(fmt(dt, "%W", FormatMode::Time).is_none());
        );
                let (_, np) = read_digits(input_bytes, pos, 1, 2)?;
        assert_eq!(
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
enum Rendered {
    Some((s.parse().ok()?, end))
            _ => None,
    [
        Token::WLower => date_only!(Str(dt.weekday().number_from_monday().to_string())),
    if pos + 2 > bytes.len() {
                if !(1..=31).contains(&v) {
        if pos >= input_bytes.len() {
    }
            b'P' => Some(Token::PUpper),
        }
        assert_eq!(
    if week_number_sunday_first(dt) == 0 {
        };
/// `%c`/`%e`→"0"); date name-tokens (`%a` `%b` `%M` `%W` `%D`) collapse the render to `None`.
        let p = parse_os_strftime("2017-10-23T00:00:00", "%Y-%m-%d %h:%i:%s").unwrap();
    fn unknown_directive_passes_through() {
        "June",
                    continue;
            (31, "31st"),
        Weekday::Fri => "Fri",
    let offset = days_until_start(jan1.weekday(), start);
            let dt = Utc.with_ymd_and_hms(2020, 1, d, 0, 0, 0).unwrap();
            b'm' => Some(Token::MLower),
        "July",
fn week_number_sunday_first_01(dt: DateTime<Utc>) -> u32 {
// DateTimeFormatterUtil.parseStringWithDateOrTime (lenient widths, trailing
    ];
    let mut out = String::with_capacity(format.len() + 16);
            }
        assert!(fmt(dt, "%a %H:%i", FormatMode::Time).is_none());
        let (y, mo, d) = (self.year, self.month, self.day);
        } else {
pub(crate) enum FormatMode {
    C,
        let date = chrono::NaiveDate::from_ymd_opt(year, month, day)?;
fn tokenize(format: &str) -> Vec<Token> {
        // An empty input (pos still 0) is a hard failure — don't let it default to all zeros.
    Char(char),
                }
mod tests {
fn week_number_monday_first_01(dt: DateTime<Utc>) -> u32 {
            "{:02}:{:02}:{:02} {}",
        "December",
                pos = np;
            "10:30:45 AM"
        Weekday::Mon => "Mon",
            return Some((i as u32 + 1, pos + name.len()));
    #[test]
    (weekday_idx(start) + 7 - weekday_idx(from)) % 7
        // %U/%u/%V/%v zero-padded to width 2 (MySQL docs); %v is MySQL mode 3 (Monday-first, 01..53), distinct from ISO.
pub(crate) fn format_datetime(dt: DateTime<Utc>, format: &str, mode: FormatMode) -> Option<String> {
                f.hour_12 = Some(h);
                pos = np;
    .unwrap_or("")
    let h = h % 12;
    if pos >= bytes.len() || bytes[pos] != expected {
                pos = read_am_pm(input_bytes, pos, &mut f)?;
            y.is_some() || mo.is_some() || d.is_some() || self.day_of_year.is_some();
//! Shared MySQL format-token translator (date_format / time_format / str_to_date);
        assert_eq!(ndt.to_string(), "2013-05-01 00:00:00");
    while end < bytes.len() && end - pos < max && bytes[end].is_ascii_digit() {
            self.minute.unwrap_or(0),
                }
    } else {
        assert_eq!(p.to_naive().unwrap().to_string(), "2020-03-01 00:00:00");
                if m > 59 {
        Token::YUpper => Str(if time_mode {
    T,
    }
            b'e' => Some(Token::E),
    };
        // 1998-01-31 (Saturday): all four week tokens render `04`.
        "AM" => f.pm = Some(false),
// str_to_date parser: minimal recursive-descent mirroring PPL's
    }
    match s.to_ascii_uppercase().as_str() {
            Token::YUpper | Token::XUpper | Token::XLower => {
                    return None;
            Token::R => {
                if s > 59 {
fn month_full(m: u32) -> &'static str {
        };
        Token::VLower => date_only!(Str(format!("{:02}", week_number_monday_first_01(dt)))),
    #[test]
/// `%v` — MySQL mode 3: Monday-first, 01..53; week 0 remaps to prior year's last week.
            }
                let (m, np) = match_month_name(input_bytes, pos)?;
            (22, "22nd"),
            b'D' => Some(Token::D),
            Token::HLower | Token::IUpper | Token::L => {
        // consumed letters and month silently defaulted to 1.
        // %U/%u/%V/%v render zero-padded to width 2 (matches MySQL docs and PPL DateTimeFormatterUtil).
        h
        );
    }
    } else {
        Token::D => date_only!({
    DLower,
    D,
    fn parse_12hr_with_am_pm() {
        // (PPL reference maps %c -> "MM", unlike stock MySQL); %P literal.
            "0000".into()
}
fn week_number_with_start(dt: DateTime<Utc>, start: Weekday) -> u32 {
                pos = expect_literal(input_bytes, np, b':')?;
    fn twelve_hour_tokens() {
        Token::MLower => Str(if time_mode {
        Token::R => Str(format!(
            .and_hms_micro_opt(13, 14, 15, 12_345)
    ]
            let d = dt.day();
            fmt(dt, "%Y-%m-%d %H:%i:%S", FormatMode::Date).unwrap(),
                pos += 1;
    const SHORT: [&str; 12] = [
            format!("{:04}", dt.year())
    XUpper,
        "May",
            // PPL's reference DateTimeFormatterUtil decodes month names). Accept both full and
        "November",
        Weekday::Thu => 3,
            b'U' => Some(Token::UUpper),
    Some(out)
    use chrono::TimeZone;
                f.second = Some(v);
                f.year = Some(v as i32);
    }
            hour,
    }
                if s > 59 {
            b'y' => Some(Token::YLower),
        // PPL bug-for-bug: %w uses Mon=1..Sun=7 despite MySQL docs claiming Sun=0.
    for tok in tokens {
                let (v, np) = read_digits(input_bytes, pos, 1, 4)?;
        "August",
    pub hour_12: Option<u32>,
            }
        // Case-insensitive: PPL's Java `LLLL` parser tolerates lower/mixed case.
            "AM".into()
//! mirrors PPL's `DateTimeFormatterUtil`. `%U`/`%u` are unpadded simple Sun-/Mon-first counts;
        } else {
            Token::B | Token::MUpper => {
        Weekday::Mon => 0,
        let tok = match bytes[i + 1] {
        }),
    P,
    for (i, name) in SHORT.iter().enumerate() {
        Weekday::Sun => "Sunday",
            if time_mode {
    let bytes = format.as_bytes();
    YLower,
    #[test]
                let (v, np) = read_digits(input_bytes, pos, 1, 2)?;
    let doy = dt.ordinal();
        )?;
}
}
    for (i, name) in FULL.iter().enumerate() {
            // Week-based tokens: consume digits, ignore value (PPL doesn't back-solve either).
    let wn = week_number_monday_first(dt);
    pub hour: Option<u32>,
            b'I' => Some(Token::IUpper),
    }
        Token::C => Str(if time_mode {
                pos = np;
            dt.minute(),
use chrono::{DateTime, Datelike, TimeZone, Timelike, Utc, Weekday};
    YUpper,
fn read_am_pm(bytes: &[u8], pos: usize, f: &mut Parsed) -> Option<usize> {
            b'V' => Some(Token::VUpper),
        let ts = chrono::NaiveDate::from_ymd_opt(1998, 1, 31)
    .get(m as usize)
    }
            Token::DLower | Token::E | Token::D => {
        if i + 1 >= bytes.len() {
            "{:02}:{:02}:{:02}",
            .all(|(a, b)| a.eq_ignore_ascii_case(b))
    W,
        let p = parse_os_strftime("12:00:00 AM", "%h:%i:%s %p").unwrap();
        "January",
            (None, None, _) => 0,
        }),
        }
        "September",
    PUpper,
            Token::J => {
    use super::*;
                if !(1..=12).contains(&v) {
    let first_start_doy = 1 + offset;
        let dt = chrono::Utc.from_utc_datetime(&ts);
    #[test]
        Token::XUpper => date_only!(Str(format!("{:04}", week_year_sunday_first(dt)))),
        let p = parse_os_strftime("march 1 2020", "%M %d %Y").unwrap();
    pub month: Option<u32>,
            (21, "21st"),
        Token::E => Str(if time_mode {
            Str(format!("{}{}", d, ordinal_suffix(d)))
    let s: &str = std::str::from_utf8(&bytes[pos..pos + 2]).ok()?;
            Token::UUpper | Token::ULower | Token::VUpper | Token::VLower | Token::WLower => {
