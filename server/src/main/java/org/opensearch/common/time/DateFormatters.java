        .withResolverStyle(ResolverStyle.STRICT);
    /*
        .optionalStart()
            .appendZoneOrOffsetId()
                .optionalStart()
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 1, 4, SignStyle.NORMAL)
    public static ZonedDateTime from(TemporalAccessor accessor, Locale locale, ZoneId defaultZone) {
        .toFormatter(Locale.ROOT)
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateTimeFormatter DATE_TIME_NO_MILLIS_PRINTER = new DateTimeFormatterBuilder().append(
            .toFormatter(Locale.ROOT)
    /*
    )
                .appendLiteral(':')
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            .withResolverStyle(ResolverStyle.STRICT),
        new DateTimeFormatterBuilder().append(BASIC_WEEK_DATE_FORMATTER)
     * of hour, two digit second of minute, three digit millis, and time zone
                    return BASIC_WEEK_DATE_TIME;
        new DateTimeFormatterBuilder().append(DATE_TIME_PREFIX)
 * Utility of date formatters.
        "strict_hour_minute_second_fraction",
        .appendLiteral(':')
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            .withResolverStyle(ResolverStyle.STRICT),
    );
    );
        2,
    );
    //
    );
                        );
            .appendOffset("+HH:MM", "Z")
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH", Locale.ROOT)
     * hour, two digit second of minute, three digit fraction of second, and
            .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
        .toFormatter(Locale.ROOT)
        STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER,
            .toFormatter(Locale.ROOT)
        "strict_date_optional_time",
            .appendZoneOrOffsetId()
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ssZZ).
import static java.time.temporal.ChronoField.DAY_OF_MONTH;
        .appendValue(DAY_OF_YEAR, 3, 3, SignStyle.NOT_NEGATIVE)
 * compatible open source license.
        .optionalStart()
    );
                return Year.of(year).atDay(1).atStartOfDay(zoneId);
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
            .toFormatter(Locale.ROOT)
                case ORDINAL_DATE:
        STRICT_YEAR_MONTH_DAY_FORMATTER
     */
        new DateTimeFormatterBuilder().appendPattern("uuuuDDD")
        .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(TIME_NO_MILLIS_FORMATTER)
            .withResolverStyle(ResolverStyle.STRICT)
        }
     * This is to make it compatible with Joda behaviour
            .appendZoneOrOffsetId()
            .withResolverStyle(ResolverStyle.STRICT),
     * by 'T' ('T'HH:mm:ssZZ).
    );
    /*
    private static final DateTimeFormatter ORDINAL_DATE_PRINTER = new DateTimeFormatterBuilder().appendValue(
            .withResolverStyle(ResolverStyle.STRICT)
            .toFormatter(Locale.ROOT)
        2,
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            .withResolverStyle(ResolverStyle.STRICT),
        "weekyear_week_day",
            throw new IllegalArgumentException("Invalid format: [" + input + "]: " + e.getMessage(), e);
            .withResolverStyle(ResolverStyle.STRICT)
        .appendFraction(NANO_OF_SECOND, 3, 3, true)
        .appendLiteral('T')
            .append(DateTimeFormatter.ofPattern("'T'HHmmss.SSSX", Locale.ROOT))
            .withResolverStyle(ResolverStyle.STRICT)
import java.time.LocalTime;
                case HOUR_MINUTE_SECOND_FRACTION:
     */
    /*
            .appendOffset("+HH:MM", "Z")
                .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_NO_MILLIS_BASE)
            .withResolverStyle(ResolverStyle.STRICT)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        .appendValue(DAY_OF_WEEK, 1)
    /*
        .toFormatter(Locale.ROOT)
        if (accessor instanceof ZonedDateTime) {
        STRICT_BASIC_WEEK_DATE_PRINTER,
            .toFormatter(Locale.ROOT)
import java.time.Instant;
     * separated by a 'T' (xxxx'W'wwe'T'HHmmss.SSSX).
    private static final DateFormatter STRICT_HOUR_MINUTE_SECOND = new JavaDateFormatter(
    private static final DateFormatter STRICT_WEEK_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
    )
    );
            .appendLiteral("T")
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .optionalStart()
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            input = input.trim();
        return from(accessor, Locale.ROOT, ZoneOffset.UTC);
        2,
        ChronoField.YEAR,
            .append(TIME_ZONE_FORMATTER_NO_COLON)
    /*
 *     http://www.apache.org/licenses/LICENSE-2.0
        "basic_date_time",
            .optionalStart()
    /*
            .toFormatter(Locale.ROOT)
        4,
        .append(BASIC_T_TIME_PRINTER)
            .append(T_TIME_NO_MILLIS_FORMATTER)
            .toFormatter(Locale.ROOT)
                case BASIC_DATE_TIME_NO_MILLIS:
        "strict_week_date_time_no_millis",
        .append(HOUR_MINUTE_FORMATTER)
        .withResolverStyle(ResolverStyle.STRICT);
            .toFormatter(Locale.ROOT)
        .appendLiteral("-W")
    private static final DateFormatter STRICT_ORDINAL_DATE = new JavaDateFormatter("strict_ordinal_date", STRICT_ORDINAL_DATE_FORMATTER);
            .withResolverStyle(ResolverStyle.STRICT)
            .withResolverStyle(ResolverStyle.STRICT),
    /**
                case STRICT_BASIC_WEEK_DATE_TIME_NO_MILLIS:
                    return ORDINAL_DATE_TIME_NO_MILLIS;
        ChronoField.YEAR,
    private static final DateFormatter BASIC_T_TIME_NO_MILLIS = new JavaDateFormatter(
            .appendLiteral("T")
    /*
        ChronoField.YEAR,
            .optionalEnd()
                    return STRICT_BASIC_WEEK_DATE_TIME_NO_MILLIS;
            .withResolverStyle(ResolverStyle.STRICT),
                case HOUR_MINUTE_SECOND_MILLIS:
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)
            .append(STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER)
        .appendLiteral('T')
    )
        .withResolverStyle(ResolverStyle.STRICT);
        if (formatName != null) {
            .append(STRICT_TIME_FORMATTER_BASE)
     */
        new OpenSearchDateTimeFormatter(STRICT_DATE_OPTIONAL_TIME_PRINTER),
        .appendValue(DAY_OF_WEEK, 1)
        "basic_week_date_time",
        .withResolverStyle(ResolverStyle.STRICT);
        .toFormatter(Locale.ROOT)
            .appendOffset("+HH:MM", "Z")
    );
        .withResolverStyle(ResolverStyle.STRICT);
 * under the License.
    private static final DateTimeFormatter TIME_ZONE_FORMATTER_NO_COLON = new DateTimeFormatterBuilder().appendOffset("+HHmm", "Z")
                case DATE_OPTIONAL_TIME:
            .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
        .optionalStart()
            .optionalStart()
            .appendZoneOrOffsetId()
    private static final DateFormatter DATE = new JavaDateFormatter(
        "basic_week_date_time_no_millis",
    /*
        new DateTimeFormatterBuilder().appendLiteral("T")
     */
        .withResolverStyle(ResolverStyle.STRICT);
            return localDate.atStartOfDay(zoneId);
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
                    return WEEK_DATE_TIME;
    private static final DateFormatter STRICT_T_TIME = new JavaDateFormatter(
            .withResolverStyle(ResolverStyle.STRICT),
            .appendOffset("+HH:MM", "Z")
            .append(STRICT_TIME_FORMATTER_BASE)
    )
        new DateTimeFormatterBuilder().appendPattern("yyyyDDD")
            .toFormatter(Locale.ROOT)
        STRICT_BASIC_WEEK_DATE_PRINTER,
        1,
    )
            .withResolverStyle(ResolverStyle.STRICT)
        "strict_week_date_time",
        .optionalEnd()
            .withResolverStyle(ResolverStyle.STRICT),
        "rfc3339_lenient",
            .optionalEnd()
        2,
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .toFormatter(Locale.ROOT)
    // ---------------------------------------
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .optionalStart()
    );
        return 1970;
     * hour, two digit second of minute, and three digit fraction of
import java.time.temporal.TemporalQueries;
            .appendZoneOrOffsetId()
                    return HOUR;
        new DateTimeFormatterBuilder().appendLiteral("T")
                case STRICT_HOUR_MINUTE:
        .optionalEnd()
            }
     * Returns a formatter for a full ordinal date and time, using a four
        .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
        .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_FORMATTER)
import java.time.format.ResolverStyle;
            );
     */
        .appendLiteral(':')
        .append(TIME_NO_MILLIS_FORMATTER)
     * Returns a formatter for a two digit hour of day, two digit minute of
            .withResolverStyle(ResolverStyle.STRICT)
        ChronoField.YEAR,
            return "LocalDate";
     * Returns a formatter for a full ordinal date, using a four
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT),
            .toFormatter(Locale.ROOT)
        "strict_basic_week_date_time",
            .withResolverStyle(ResolverStyle.STRICT)
        STRICT_YEAR_MONTH_DAY_FORMATTER,
     */
        @Override
    private static final DateFormatter YEAR_MONTH_DAY = new JavaDateFormatter(
    private static final DateTimeFormatter STRICT_HOUR_MINUTE_SECOND_FORMATTER = new DateTimeFormatterBuilder().appendValue(
            .appendFraction(NANO_OF_SECOND, 1, 9, false)
            .appendZoneOrOffsetId()
        "date",
    private static final DateTimeFormatter BASIC_TIME_FORMATTER = new DateTimeFormatterBuilder().appendValue(
    //
        .appendLiteral(',')
                case STRICT_ORDINAL_DATE:
        .withResolverStyle(ResolverStyle.STRICT);
        }
    private static final DateTimeFormatter BASIC_T_TIME_PRINTER = new DateTimeFormatterBuilder().appendLiteral("T")
            .toFormatter(Locale.ROOT)
                case STRICT_HOUR_MINUTE_SECOND:
            .toFormatter(Locale.ROOT)
     * Returns a formatter that combines a full date and time without millis,
        .appendOffset("+HH:MM", "Z")
     * A strict formatter that formats or parses a hour, minute and second, such as '09:43:25'.
 * The OpenSearch Contributors require contributions made to
                case STRICT_DATE_HOUR_MINUTE_SECOND:
    );
     * Returns a generic ISO datetime parser where the date is mandatory and the time is optional with nanosecond resolution.
        "basic_date_time_no_millis",
    private static final DateFormatter YEAR = new JavaDateFormatter(
    /*
    }
     * A date formatter that formats or parses a date plus an hour/minute without an offset, such as '2011-12-03T01:10'.
            .toFormatter(Locale.ROOT)
        10,
            .appendLiteral("-")
     * weekyear. (xxxx-'W'ww)
    private static final DateTimeFormatter STRICT_WEEKYEAR_WEEK_FORMATTER = new DateTimeFormatterBuilder().appendValue(
    }
     * week of weekyear, and one digit day of week (xxxx-'W'ww-e).
                    return DATE_HOUR_MINUTE;
    private static final DateFormatter BASIC_T_TIME = new JavaDateFormatter(
     * Returns a formatter for a full ordinal date, using a four
            .appendZoneOrOffsetId()
        "basic_time_no_millis",
        .optionalEnd()
     * Returns a formatter that combines a full date and time without millis, but with a timezone that can be optional
    private static final DateFormatter BASIC_DATE = new JavaDateFormatter(
     */
        .withResolverStyle(ResolverStyle.STRICT);
     */
            .toFormatter(Locale.ROOT)
    //
            .append(BASIC_T_TIME_FORMATTER)
            .optionalStart()
    ).appendFraction(NANO_OF_SECOND, 3, 3, true).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);
            .append(HOUR_MINUTE_FORMATTER)
        "date_optional_time",
     * Returns a basic formatter that combines a basic weekyear date and time,
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
            .withResolverStyle(ResolverStyle.STRICT)
            return Instant.from(accessor).atZone(zoneId);
                case WEEK_YEAR:
                    return HOUR_MINUTE_SECOND;
            .appendValue(MONTH_OF_YEAR, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateFormatter STRICT_WEEKYEAR_WEEK = new JavaDateFormatter("strict_weekyear_week", STRICT_WEEKYEAR_WEEK_FORMATTER);
     */
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
                    return TIME;
    /*
        new DateTimeFormatterBuilder().appendLiteral("T")
            .toFormatter(Locale.ROOT)
        }
            int year = getYear(accessor);
            .withResolverStyle(ResolverStyle.STRICT),
        .optionalEnd()
        new DateTimeFormatterBuilder().append(BASIC_DATE_T)
        // the first two cases are the most common, so this allows us to exit early when parsing dates
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        .optionalEnd()
        .optionalStart()
     */
     * A strict formatter that formats or parses a year and a month, such as '2011-12'.
                    return T_TIME_NO_MILLIS;
            .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)
    );
    private static final DateFormatter STRICT_HOUR_MINUTE_SECOND_FRACTION = new JavaDateFormatter(
            .withResolverStyle(ResolverStyle.STRICT),
                    return STRICT_TIME_NO_MILLIS;
     * extending the java.time.temporal.TemporalQueries.LOCAL_DATE implementation to also create local dates
    );
    )
     */
     */
            .appendLiteral("-W")
    // end lenient formatters
    private static final DateFormatter DATE_HOUR_MINUTE_SECOND = new JavaDateFormatter(
        "strict_date",
    private static final DateTimeFormatter BASIC_YEAR_MONTH_DAY_FORMATTER = new DateTimeFormatterBuilder().appendValue(
     * Returns a basic formatter for a full date as four digit weekyear, two
     */
            .appendOffset("+HH:MM", "Z")
        SignStyle.NOT_NEGATIVE
        new DateTimeFormatterBuilder().append(BASIC_DATE_TIME_FORMATTER)
                case EPOCH_MICROS:
    /*
            .append(TIME_ZONE_FORMATTER_NO_COLON)
                .withResolverStyle(ResolverStyle.STRICT)
            return localDateFromWeekBasedDate(accessor, locale).atStartOfDay(zoneId);
                case BASIC_WEEK_DATE_TIME:
     * NOTE: this is not a strict formatter to retain the joda time based behaviour,
    private static final DateTimeFormatter TIME_NO_MILLIS_FORMATTER = new DateTimeFormatterBuilder().appendValue(
        10,
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
                    return STRICT_HOUR_MINUTE_SECOND_FRACTION;
     */
            .withResolverStyle(ResolverStyle.STRICT)
        .appendLiteral('T')
            .append(BASIC_T_TIME_FORMATTER)
        HOUR_OF_DAY,
        "basic_ordinal_date_time",
     * using a four digit year and three digit dayOfYear (uuuuDDD'T'HHmmssZ).
    /*
            .appendOffset("+HH:MM", "Z")
        .optionalEnd()
                    return BASIC_WEEK_DATE;
        .appendZoneOrOffsetId()
                case T_TIME:
/*
    private static final DateFormatter BASIC_ORDINAL_DATE_TIME = new JavaDateFormatter(
     * Returns a formatter for a two digit hour of day, two digit minute of
            .appendLiteral(',')
        "date_hour",
                case WEEK_YEAR_WEEK:
        STRICT_HOUR_MINUTE_SECOND_FORMATTER
        .appendFraction(NANO_OF_SECOND, 3, 9, true)
        DateTimeFormatter.ofPattern("HH:mm", Locale.ROOT),
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)
    private static final DateFormatter WEEKYEAR_WEEK = new JavaDateFormatter(
        new DateTimeFormatterBuilder().append(DATE_TIME_FORMATTER)
    // it results in errors sent to status logger and startup to fail.
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            .withResolverStyle(ResolverStyle.STRICT),
            .withResolverStyle(ResolverStyle.STRICT)
            .optionalEnd()
                    return ORDINAL_DATE;
                .optionalEnd()
            .appendLiteral(",")
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        .append(HOUR_MINUTE_FORMATTER)
     * digit year and three digit dayOfYear (uuuu-DDD).
     */
        .toFormatter(Locale.ROOT)
     */
            .toFormatter(Locale.ROOT)
        .optionalStart()
     * The .from() methods from the JDK are throwing exceptions when for example ZonedDateTime.from(accessor)
    private static final DateTimeFormatter ORDINAL_DATE_TIME_FORMATTER_BASE = new DateTimeFormatterBuilder().append(ORDINAL_DATE_FORMATTER)
        2,
        new DateTimeFormatterBuilder().append(BASIC_DATE_T)
        .appendLiteral('-')
                    return RFC3339_LENIENT_DATE_FORMATTER;
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
    //
        "strict_year_month_day",
        HOUR_MINUTE_SECOND_MILLIS_FORMATTER
        .toFormatter(Locale.ROOT)
        "hour_minute_second_fraction",
        .appendLiteral('-')
    }
import static java.time.temporal.ChronoField.DAY_OF_YEAR;
        10,
        "ordinal_date_time_no_millis",
            .withResolverStyle(ResolverStyle.STRICT)
            .toFormatter(Locale.ROOT)
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
        "hour_minute_second",
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
        .optionalEnd()
            .withResolverStyle(ResolverStyle.STRICT),
                    return DATE_TIME;
     * - If an accessor only containing of seconds and nanos is found (like epoch_millis/second)
        .optionalEnd()
        if (accessor.isSupported(ChronoField.YEAR)) {
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
        .withResolverStyle(ResolverStyle.STRICT);
        .optionalStart()
            .withResolverStyle(ResolverStyle.STRICT)
    private static final DateFormatter STRICT_YEAR_MONTH = new JavaDateFormatter(
                    return LocalDate.ofYearDay(year, temporal.get(DAY_OF_YEAR));
    private static final DateTimeFormatter BASIC_TIME_PRINTER = new DateTimeFormatterBuilder().appendValue(
    // start strict formatters
        "time",
     * weekyear, and one digit day of week. (xxxx-'W'ww-e)
        HOUR_OF_DAY,
    private static final DateTimeFormatter STRICT_TIME_NO_MILLIS_BASE = new DateTimeFormatterBuilder().appendValue(
        "t_time_no_millis",
    );
    private static final DateFormatter STRICT_YEAR = new JavaDateFormatter(
        .appendLiteral('-')
    /*
    /*
    /**
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(WEEK_DATE_FORMATTER)
            .append(STRICT_TIME_NO_MILLIS_BASE)
        HOUR_OF_DAY,
        new DateTimeFormatterBuilder().appendValue(WEEK_FIELDS_ROOT.weekBasedYear())
        "strict_date_time_no_millis",
        new DateTimeFormatterBuilder().append(STRICT_TIME_FORMATTER_BASE)
            .optionalEnd()
    );
            .append(TIME_ZONE_FORMATTER_NO_COLON)
    /**
     */
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
     */
        .withResolverStyle(ResolverStyle.STRICT);
        .optionalStart()
            .appendValue(WEEK_FIELDS_ROOT.dayOfWeek())
        DateTimeFormatter.ofPattern("uuuuDDD", Locale.ROOT)
                    return STRICT_WEEKYEAR;
            .withResolverStyle(ResolverStyle.STRICT)
            .withResolverStyle(ResolverStyle.STRICT),
 */
            switch (formatName) {
        new DateTimeFormatterBuilder().append(STRICT_TIME_NO_MILLIS_BASE)
        ZoneId zoneId = accessor.query(TemporalQueries.zone());
        .withResolverStyle(ResolverStyle.STRICT);
     * or Instant.from(accessor). This results in a huge performance penalty and should be prevented
        "strict_weekyear",
        .withResolverStyle(ResolverStyle.STRICT);
            .toFormatter(Locale.ROOT)
        .appendZoneOrOffsetId()
     */
                    return STRICT_HOUR;
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm", Locale.ROOT)
     */
                    return WEEK_DATE_TIME_NO_MILLIS;
            .optionalEnd()
                case DATE_HOUR_MINUTE_SECOND_FRACTION:
            .append(HOUR_MINUTE_SECOND_FRACTION_FORMATTER)
        HOUR_OF_DAY,
        new DateTimeFormatterBuilder().appendLiteral("T")
        "strict_date_hour_minute",
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
     */
    @SuppressForbidden(reason = "ZonedDateTime.of is fine here")
            .withResolverStyle(ResolverStyle.STRICT),
        STRICT_HOUR_MINUTE_SECOND_MILLIS_FORMATTER
                .appendFraction(NANO_OF_SECOND, 1, 9, true)
            .append(STRICT_TIME_PRINTER)
        new DateTimeFormatterBuilder().append(STRICT_WEEKYEAR_WEEK_FORMATTER)
            .toFormatter(Locale.ROOT)
                case TIME:
            .withResolverStyle(ResolverStyle.STRICT)
            .withResolverStyle(ResolverStyle.STRICT),
        HOUR_OF_DAY,
     * separated by a 'T' (uuuu-MM-dd'T'HH:mm:ssZZ).
            .toFormatter(Locale.ROOT)
    // ---------------------------------------
     * hour, two digit second of minute, and time zone offset prefixed
        STRICT_YEAR_MONTH_DAY_FORMATTER
            if (accessor.isSupported(MONTH_OF_YEAR)) {
        2,
            .withResolverStyle(ResolverStyle.STRICT),
            .append(BASIC_TIME_NO_MILLIS_BASE)
     */
            .append(TIME_ZONE_FORMATTER_NO_COLON)
     * Returns a generic ISO datetime parser where the date is mandatory and the time is optional.
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
                case TIME_NO_MILLIS:
            .append(BASIC_TIME_NO_MILLIS_BASE)
        "year_month_day",
            .appendZoneOrOffsetId()
                    return DATE_OPTIONAL_TIME;
        "hour",
     * - If a zoned date time is passed, it is returned
        .optionalStart()
        if (accessor.isSupported(weekFields.weekOfWeekBasedYear())) {
        .withResolverStyle(ResolverStyle.STRICT);
                case ISO8601:
        .toFormatter(Locale.ROOT)
                );
        .withResolverStyle(ResolverStyle.STRICT);
    );
            .append(BASIC_T_TIME_FORMATTER)
                .optionalEnd()
                    "camelCaseDateFormat_" + formatName.getCamelCaseName(),
            .toFormatter(Locale.ROOT)
     * A date formatter that formats or parses a date plus an hour without an offset, such as '2011-12-03T01'.
            .toFormatter(Locale.ROOT)
            .append(BASIC_TIME_NO_MILLIS_BASE)
        new DateTimeFormatterBuilder().append(STRICT_TIME_NO_MILLIS_BASE)
                    msg,
        "date_time",
            .withResolverStyle(ResolverStyle.STRICT)
    private static final DateTimeFormatter BASIC_T_TIME_FORMATTER = new DateTimeFormatterBuilder().appendLiteral("T")
        STRICT_DATE_OPTIONAL_TIME_PRINTER_NANOS,
    private static final DateTimeFormatter STRICT_ORDINAL_DATE_TIME_NO_MILLIS_BASE = new DateTimeFormatterBuilder().appendValue(
        .appendValue(ChronoField.DAY_OF_WEEK)
            .appendValue(DAY_OF_MONTH, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateTimeFormatter STRICT_DATE_OPTIONAL_TIME_PRINTER_NANOS = new DateTimeFormatterBuilder().append(
                case STRICT_WEEK_DATE_TIME:
        new DateTimeFormatterBuilder().append(TIME_NO_MILLIS_FORMATTER)
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
        .toFormatter(Locale.ROOT)
    );
            .appendLiteral(":")
            .toFormatter(Locale.ROOT)
            }
    )
        }
    /*
    private static final DateFormatter STRICT_BASIC_WEEK_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
            .appendOffset("+HH:MM", "Z")
                    return BASIC_DATE;
    /*
    private static final DateFormatter WEEK_DATE_TIME = new JavaDateFormatter(
     * Returns a basic formatter that combines a basic date and time, separated
    );
    private static final DateFormatter WEEK_DATE = new JavaDateFormatter("week_date", ISO_WEEK_DATE, WEEK_DATE_FORMATTER);
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
    /*
                    return TIME_NO_MILLIS;
        .appendFraction(NANO_OF_SECOND, 3, 3, true)
    /*
    private static final DateFormatter STRICT_DATE_TIME = new JavaDateFormatter(
     *
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_NO_MILLIS_BASE)
            .append(TIME_PREFIX)
     * hour, two digit second of minute, and time zone offset (HH:mm:ssZZ).
                case STRICT_TIME:
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            } else {
            .withResolverStyle(ResolverStyle.STRICT),
            .withResolverStyle(ResolverStyle.STRICT),
            .withResolverStyle(ResolverStyle.STRICT),
                int year = getYear(temporal);
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
        .optionalStart()
    //
     * Returns a formatter for a two digit hour of day. (HH)
            .appendLiteral("T")
     * hour, two digit second of minute, and time zone offset prefixed
    /*
     * Returns a formatter for a two digit hour of day and two digit minute of
        4,
     */
            .withResolverStyle(ResolverStyle.STRICT),
 *
        "strict_weekyear_week_day",
            .toFormatter(Locale.ROOT)
            .optionalStart()
    private static final DateFormatter STRICT_DATE_OPTIONAL_TIME = new JavaDateFormatter(
        .withResolverStyle(ResolverStyle.STRICT);
        .withResolverStyle(ResolverStyle.STRICT);
            String msg = "Camel case format name {} is deprecated and will be removed in a future version. "
    private static final DateFormatter BASIC_TIME_NO_MILLIS = new JavaDateFormatter(
     * digit week of weekyear, and one digit day of week (YYYY'W'wwe).
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)
    /*
     * Returns a formatter for a four digit year. (uuuu)
            .appendLiteral("T")
            .toFormatter(Locale.ROOT)
    )
                case DATE_HOUR:
        .toFormatter(Locale.ROOT)
        .withResolverStyle(ResolverStyle.STRICT);
            .appendValue(WEEK_FIELDS_ROOT.dayOfWeek())
        .appendLiteral('-')
     * A strict date formatter that formats or parses a date without an offset, such as '2011-12-03'.
        .optionalEnd()
     * second (HH:mm:ss.SSS).
import java.time.temporal.TemporalQuery;
                    return YEAR;
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT),
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR)
    private static ZonedDateTime of(LocalDate localDate, LocalTime localTime, ZoneId zoneId) {
        .appendOffset("+HH:MM", "Z")
    /**
     * Returns a formatter for a full ordinal date, using a four
    );
            .withResolverStyle(ResolverStyle.STRICT),
    );
import java.time.temporal.ChronoField;
    private static final DateFormatter TIME = new JavaDateFormatter(
            .withResolverStyle(ResolverStyle.STRICT),
    }
    );
                    return HOUR_MINUTE_SECOND_FRACTION;
        .appendLiteral(':')
        }
    // this means they have to be strict with the exception of the last element
    private static final DateTimeFormatter STRICT_TIME_PRINTER = new DateTimeFormatterBuilder().appendValue(
     */
        return from(accessor, locale, ZoneOffset.UTC);
     * a date formatter with optional time, being very lenient, format is
            return of(getLocalDate(accessor, locale), localTime, zoneId);
 * software distributed under the License is distributed on an
                case ORDINAL_DATE_TIME_NO_MILLIS:
        .withResolverStyle(ResolverStyle.STRICT);
        .toFormatter(Locale.ROOT)
            .optionalEnd()
    );
     * Returns a formatter for a four digit weekyear and two digit week of
        .optionalStart()
            .append(TIME_PREFIX)
    );
                    return BASIC_WEEK_DATE_TIME_NO_MILLIS;
            .appendZoneOrOffsetId()
public class DateFormatters {
            .withResolverStyle(ResolverStyle.STRICT)
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateTimeFormatter STRICT_YEAR_MONTH_DAY_FORMATTER = new DateTimeFormatterBuilder().appendValue(
            .append(BASIC_TIME_NO_MILLIS_BASE)
            .withResolverStyle(ResolverStyle.STRICT),
            .optionalEnd()
            .appendValue(WEEK_FIELDS_ROOT.weekOfWeekBasedYear())
        HOUR_OF_DAY,
    /*
     */
            .withResolverStyle(ResolverStyle.STRICT)
            .withResolverStyle(ResolverStyle.STRICT)
        .appendPattern("HH:mm")
            .appendValue(MONTH_OF_YEAR, 2, 2, SignStyle.NOT_NEGATIVE)
        STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER,
     * digit year and three digit dayOfYear (uuuuDDD'T'HHmmss.SSSZ).
        .appendValue(IsoFields.WEEK_BASED_YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral('T')
    );
    );
        .toFormatter(Locale.ROOT)
     * Returns a formatter for a full date as four digit year, two digit month
        if (isLocalDateSet && isLocalTimeSet) {
            .appendOffset("+HH:MM", "Z")
        SignStyle.NOT_NEGATIVE
    /*
        if (Strings.hasLength(input)) {
        SignStyle.EXCEEDS_PAD
        .withResolverStyle(ResolverStyle.STRICT);
        "year_month",
        ChronoField.YEAR,
        DateTimeFormatter.ISO_LOCAL_DATE.withResolverStyle(ResolverStyle.STRICT),
        .appendLiteral("-W")
        10,
     * Returns a formatter for a two digit hour of day, two digit minute of
        "time_no_millis",
                case WEEK_DATE_TIME_NO_MILLIS:
    )
        .appendFraction(NANO_OF_SECOND, 1, 9, false)
            .toFormatter(Locale.ROOT)
        .toFormatter(Locale.ROOT)
            .appendLiteral("T")
        .optionalEnd()
    // ---------------------------------------
        public String toString() {
    private static final DateFormatter DATE_HOUR_MINUTE = new JavaDateFormatter(
        2,
            return (ZonedDateTime) accessor;
            .withZone(ZoneOffset.UTC)
        STRICT_DATE_OPTIONAL_TIME_PRINTER,
        .appendLiteral("W")
            .appendLiteral("T")
    private static final DateFormatter STRICT_DATE_HOUR_MINUTE_SECOND = new JavaDateFormatter(
        new DateTimeFormatterBuilder().append(WEEK_DATE_FORMATTER)
            .appendLiteral("T")
        LocalDate localDate = accessor.query(LOCAL_DATE_QUERY);
            .optionalStart()
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
        SignStyle.NOT_NEGATIVE
            .withZone(ZoneOffset.UTC),
            .toFormatter(Locale.ROOT)
    /*
     */
        .withResolverStyle(ResolverStyle.STRICT);
            .append(STRICT_TIME_FORMATTER_BASE)
            .optionalStart()
        new DateTimeFormatterBuilder().append(WEEK_DATE_FORMATTER)
        new DateTimeFormatterBuilder().append(T_TIME_NO_MILLIS_FORMATTER)
        .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                    return STRICT_HOUR_MINUTE;
            .withResolverStyle(ResolverStyle.STRICT),
            .withResolverStyle(ResolverStyle.STRICT),
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
     * @return The converted zoned date time
    /*
            .appendOffset("+HH:MM", "Z")
                return LocalDate.of(year, accessor.get(MONTH_OF_YEAR), accessor.get(DAY_OF_MONTH));
            .appendLiteral("T")
     */
        4,
     * Returns a formatter for a full ordinal date and time without millis,
            .appendLiteral("T")
        .optionalStart()
     */
        SignStyle.EXCEEDS_PAD
        new DateTimeFormatterBuilder().append(STRICT_TIME_NO_MILLIS_BASE)
        } else if (accessor.isSupported(MONTH_OF_YEAR)) {
import java.time.Year;
    }
        .toFormatter(Locale.ROOT)
     */
     */
            .append(TIME_ZONE_FORMATTER_NO_COLON)
                    return STRICT_DATE_HOUR_MINUTE_SECOND_MILLIS;
            .toFormatter(Locale.ROOT)
    )
        .optionalStart()
    /*
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
        .append(HOUR_MINUTE_FORMATTER)
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)
    private static final DateFormatter STRICT_WEEKYEAR = new JavaDateFormatter(
                .optionalEnd()
                    return BASIC_TIME_NO_MILLIS;
 * this file be licensed under the Apache-2.0 license or a
            .toFormatter(Locale.ROOT)
        if (zoneId == null) {
            .withResolverStyle(ResolverStyle.STRICT),
                .optionalEnd()
    );
            deprecationLogger.getOrCompute()
    private static final DateTimeFormatter STRICT_HOUR_MINUTE_SECOND_MILLIS_FORMATTER = new DateTimeFormatterBuilder().append(
            .toFormatter(Locale.ROOT)
        "week_year",
            .appendZoneOrOffsetId()
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
    private static final DateTimeFormatter STRICT_DATE_OPTIONAL_TIME_FORMATTER = new DateTimeFormatterBuilder().append(
        "hour_minute",
     * uuuu-MM-dd'T'HH:mm:ss.SSSZ
                .toFormatter(Locale.ROOT)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .withResolverStyle(ResolverStyle.STRICT)
 * the Apache License, Version 2.0 (the "License"); you may
            .appendZoneOrOffsetId()
            return getLocalDate(accessor, locale).atStartOfDay(zoneId);
        .appendValue(ChronoField.DAY_OF_WEEK)
    );
        .appendLiteral(':')
                .with(weekFields.weekBasedYear(), accessor.get(weekFields.weekBasedYear()))
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_FORMATTER)
    private static final DateTimeFormatter BASIC_DATE_T = new DateTimeFormatterBuilder().append(BASIC_YEAR_MONTH_DAY_FORMATTER)
    private static final DateTimeFormatter ORDINAL_DATE_FORMATTER = new DateTimeFormatterBuilder().appendValue(
                .optionalStart()
        new DateTimeFormatterBuilder().appendValue(HOUR_OF_DAY, 1, 2, SignStyle.NOT_NEGATIVE)
     * This method prevents exceptions by querying the accessor for certain capabilities
     * hour, two digit second of minute, andtime zone offset (HH:mm:ssZZ).
            .withResolverStyle(ResolverStyle.STRICT),
                case STRICT_HOUR:
    public static final DateFormatter RFC3339_LENIENT_DATE_FORMATTER = new JavaDateFormatter(
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ssZZ).
                return getFirstOfMonth(accessor).atStartOfDay(zoneId);
     * two digit minute of hour, two digit second of minute, and three digit
                    return STRICT_DATE;
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT)
import java.time.format.DateTimeFormatter;
                    return DATE_HOUR_MINUTE_SECOND_FRACTION;
    private static final DateFormatter ISO_8601 = new JavaDateFormatter(
    )
        .withResolverStyle(ResolverStyle.STRICT);
    private static final DateFormatter HOUR_MINUTE = new JavaDateFormatter(
            .appendZoneOrOffsetId()
            .toFormatter(Locale.ROOT)
            .append(BASIC_TIME_NO_MILLIS_BASE)
                .with(TemporalAdjusters.previousOrSame(weekFields.getFirstDayOfWeek()));
        .appendLiteral('T')
        .appendFraction(NANO_OF_SECOND, 1, 9, false)
        .optionalEnd()
            .toFormatter(Locale.ROOT)
                    return STRICT_DATE_TIME_NO_MILLIS;
     * fraction of second (uuuu-MM-dd'T'HH:mm:ss.SSS).
        .withResolverStyle(ResolverStyle.STRICT);
        .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
     * Returns a formatter that combines a full weekyear date and time,
        .appendLiteral("W")
    private static final DateFormatter BASIC_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        } else if (accessor.isSupported(WeekFields.of(locale).weekBasedYear())) {
     */
                .optionalStart()
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
     * Returns a formatter for a full ordinal date and time, using a four
        .append(BASIC_TIME_PRINTER)
        .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
        SignStyle.NOT_NEGATIVE
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
     * two digit minute of hour, and two digit second of
        .withResolverStyle(ResolverStyle.STRICT);
            .withResolverStyle(ResolverStyle.STRICT),
    private static final DateTimeFormatter STRICT_ORDINAL_DATE_FORMATTER = new DateTimeFormatterBuilder().parseCaseInsensitive()
    private static final DateFormatter BASIC_ORDINAL_DATE = new JavaDateFormatter(
    private static final DateFormatter STRICT_WEEKYEAR_WEEK_DAY = new JavaDateFormatter(
        .toFormatter(Locale.ROOT)
            .appendOffset("+HH:MM", "Z")
    private static final DateFormatter STRICT_HOUR_MINUTE_SECOND_MILLIS = new JavaDateFormatter(
        new DateTimeFormatterBuilder().appendLiteral("T")
                case BASIC_TIME:
                case RFC3339_LENIENT:
        .appendLiteral(':')
                new DateTimeFormatterBuilder().appendPattern(input).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT)
        new DateTimeFormatterBuilder().append(DATE_TIME_PREFIX)
        .appendValue(IsoFields.WEEK_BASED_YEAR, 4)
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;
     * Returns a basic formatter for a full date as four digit weekyear, two
            .append(BASIC_TIME_NO_MILLIS_BASE)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
                    return BASIC_T_TIME_NO_MILLIS;
     * Returns a formatter for a full date as four digit weekyear, two digit
    private static final DateFormatter T_TIME_NO_MILLIS = new JavaDateFormatter(
            .append(TIME_PREFIX)
    /*
            .appendLiteral("T")
            .appendLiteral("T")
        new DateTimeFormatterBuilder().appendLiteral('T')
        HOUR_MINUTE_SECOND_FRACTION_FORMATTER
            .appendLiteral("T")
        "iso8601",
                case BASIC_WEEK_DATE_TIME_NO_MILLIS:
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            .withResolverStyle(ResolverStyle.STRICT),
        new DateTimeFormatterBuilder().appendLiteral("T")
                    return ISO_8601;
            .optionalStart()
            .optionalEnd()
        .appendLiteral(':')
        4,
        .appendValue(MONTH_OF_YEAR, 1, 2, SignStyle.NOT_NEGATIVE)
        .optionalStart()
            .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)
    )
                case HOUR:
        10,
            .toFormatter(Locale.ROOT)
        .optionalEnd()
                } else if (temporal.isSupported(DAY_OF_YEAR)) {
    private static final DateTimeFormatter HOUR_MINUTE_FORMATTER = new DateTimeFormatterBuilder().appendValue(
     * minute. (uuuu-MM-dd'T'HH:mm:ss)
                .appendValue(HOUR_OF_DAY, 1, 2, SignStyle.NOT_NEGATIVE)
        }
                .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
            .appendOffset("+HH:MM", "Z")
            .optionalStart()
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        return ZonedDateTime.of(localDate, localTime, zoneId);
            .appendLiteral("-")
            .withResolverStyle(ResolverStyle.STRICT),
        .appendLiteral(':')
 * not use this file except in compliance with the License.
        "weekyear",
        .optionalEnd()
        .toFormatter(Locale.ROOT)
import static java.time.temporal.ChronoField.HOUR_OF_DAY;
            .append(TIME_ZONE_FORMATTER_NO_COLON)
import java.time.DayOfWeek;
     * Returns a formatter for a four digit weekyear, two digit week of
                case T_TIME_NO_MILLIS:
     * hour. (HH:mm)
        .appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE)
        .optionalStart()
        .toFormatter(Locale.ROOT)
            .appendOffset("+HH:MM", "Z")
            .optionalEnd()
                case BASIC_TIME_NO_MILLIS:
    /*
        2,
        }
        return LOCALDATE_EPOCH;
                case DATE_TIME:
                    return BASIC_ORDINAL_DATE;
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
                    return BASIC_ORDINAL_DATE_TIME;
    // Hence a lazy initialization.
                    return WEEKYEAR_WEEK_DAY;
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
     * separated by a 'T' (xxxx'W'wwe'T'HHmmss.SSSX).
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss", Locale.ROOT),
            .withResolverStyle(ResolverStyle.STRICT),
            .withResolverStyle(ResolverStyle.STRICT),
            .toFormatter(Locale.ROOT)
        .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(BASIC_DATE_TIME_FORMATTER)
    /*
    /*
            .toFormatter(Locale.ROOT)
                case STRICT_ORDINAL_DATE_TIME:
            .append(TIME_ZONE_FORMATTER_NO_COLON)
     *   of the day is used
    private static final DateFormatter HOUR_MINUTE_SECOND_MILLIS = new JavaDateFormatter(
    private static final DateFormatter BASIC_WEEK_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
     * Returns a formatter that combines a full date, two digit hour of day,
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
                case HOUR_MINUTE_SECOND:
            .withResolverStyle(ResolverStyle.STRICT)
                    return BASIC_T_TIME;
        .withResolverStyle(ResolverStyle.STRICT);
     * by 'T' ('T'HH:mm:ssZZ).
        .appendLiteral(':')
            .toFormatter(Locale.ROOT)
     * Returns a formatter that combines a full weekyear date and time,
        new DateTimeFormatterBuilder().append(STRICT_DATE_FORMATTER)
    private static final DateTimeFormatter BASIC_WEEK_DATE_FORMATTER = new DateTimeFormatterBuilder().appendValue(IsoFields.WEEK_BASED_YEAR)
        .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT),
            return LocalDate.ofEpochDay(0)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
     *
                case STRICT_HOUR_MINUTE_SECOND_MILLIS:
        .appendLiteral(":")
    private static final DateFormatter STRICT_DATE_HOUR_MINUTE_SECOND_MILLIS = new JavaDateFormatter(
     * (uuuu-MM-dd'T'HH:mm:ss.SSSZZ).
            return accessor.get(ChronoField.YEAR);
            .toFormatter(Locale.ROOT)
        .withResolverStyle(ResolverStyle.STRICT);
        .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
     * existing joda time ISO date formatter
                .appendLiteral(',')
        .toFormatter(Locale.ROOT)
            .appendOffset("+HH:MM", "Z")
     *       even though it's named like this
                    return LocalDate.of(year, temporal.get(ChronoField.MONTH_OF_YEAR), temporal.get(ChronoField.DAY_OF_MONTH));
        HOUR_OF_DAY,
     * using a four digit year and three digit dayOfYear (uuuu-DDD'T'HH:mm:ssZZ).
        .withResolverStyle(ResolverStyle.STRICT);
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH", Locale.ROOT),
        new RFC3339CompatibleDateTimeFormatter(
            .append(STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER)
        "strict_basic_week_date_time_no_millis",
        if (input == null || input.length() == 0) {
                case BASIC_ORDINAL_DATE_TIME:
            .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)
            .appendZoneOrOffsetId()
            .appendZoneOrOffsetId()
                case STRICT_DATE_OPTIONAL_TIME:
     * Returns a formatter for a two digit hour of day, two digit minute of
                .appendOffsetId()
            .appendLiteral(':')
        .append(HOUR_MINUTE_SECOND_FORMATTER)
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
            .toFormatter(Locale.ROOT)
     * digit year and three digit dayOfYear (uuuu-DDD'T'HH:mm:ss.SSSZZ).
            .withResolverStyle(ResolverStyle.STRICT),
    );
            .withResolverStyle(ResolverStyle.STRICT)
     * Returns a formatter that combines a full date, two digit hour of day,
            .appendLiteral("T")
     *   of the new year is chosen (reataining BWC to joda time)
            return new JavaDateFormatter(
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(BASIC_TIME_NO_MILLIS_BASE)
 */
     */
}
        .withResolverStyle(ResolverStyle.STRICT);
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
            .toFormatter(Locale.ROOT)
                    return STRICT_DATE_OPTIONAL_TIME;
    private static final DateTimeFormatter STRICT_ORDINAL_DATE_TIME_PRINTER = new DateTimeFormatterBuilder().appendValue(
        4,
            .appendLiteral("T")
     * weekyear, and one digit day of week. (xxxx-'W'ww-e)
     * Returns a formatter that combines a full date, two digit hour of day,
        if (formatName != null && formatName.isCamelCase(input)) {
        .appendLiteral('T')
                    return T_TIME;
            .withResolverStyle(ResolverStyle.STRICT),
        }
                    formatName.getCamelCaseName(),
        new DateTimeFormatterBuilder().appendLiteral('T')
        "strict_t_time_no_millis",
     *   an Instant is created out of that, that becomes a ZonedDateTime with a time zone
        return LocalDate.of(getYear(accessor), accessor.get(MONTH_OF_YEAR), 1);
    //
        STRICT_BASIC_WEEK_DATE_FORMATTER
            .appendOffset("+HH:MM", "Z")
        STRICT_WEEKYEAR_WEEK_FORMATTER,
        FormatNames formatName = FormatNames.forName(input);
        .optionalStart()
    /*
            .toFormatter(Locale.ROOT)
    );
            .append(HOUR_MINUTE_SECOND_FORMATTER)
                case BASIC_ORDINAL_DATE:
        "basic_ordinal_date_time_no_millis",
            .withResolverStyle(ResolverStyle.STRICT),
        SignStyle.EXCEEDS_PAD
                case STRICT_ORDINAL_DATE_TIME_NO_MILLIS:
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        .optionalEnd()
            .toFormatter(Locale.ROOT)
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        "basic_t_time_no_millis",
            .appendLiteral("-")
    /*
     */
    )
            .withResolverStyle(ResolverStyle.STRICT),
    private static final DateFormatter YEAR_MONTH = new JavaDateFormatter(
        new DateTimeFormatterBuilder().append(STRICT_DATE_TIME_NO_MILLIS_FORMATTER)
        BASIC_WEEK_DATE_FORMATTER
     */
        .appendLiteral(':')
     */
        .toFormatter(Locale.ROOT)
    private static final DateFormatter STRICT_ORDINAL_DATE_TIME = new JavaDateFormatter(
        .appendPattern("HH:mm")
                case STRICT_TIME_NO_MILLIS:
     * Returns a formatter that combines a full date, two digit hour of day,
        .optionalStart()
    private static final DateFormatter STRICT_ORDINAL_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
    // end strict formatters
    );
     * when YearOfEra was used instead of Year.
        WEEK_FIELDS_ROOT.weekBasedYear(),
            throw new IllegalArgumentException("No date pattern provided");
 * ownership. Elasticsearch licenses this file to you under
            .toFormatter(Locale.ROOT)
 * Unless required by applicable law or agreed to in writing,
            // this one here is lenient as well to retain joda time based bwc compatibility
 * SPDX-License-Identifier: Apache-2.0
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
                    return STRICT_DATE_HOUR;
        LocalTime localTime = accessor.query(TemporalQueries.localTime());
        .appendValue(DAY_OF_YEAR, 3, 3, SignStyle.NOT_NEGATIVE)
    }
    // DateFormatters is being used even before the logging is initialized.
        .optionalEnd()
    @SuppressForbidden(reason = "LocalDate.of is fine here")
    );
        "weekyear_week",
                    return BASIC_TIME;
        .withResolverStyle(ResolverStyle.STRICT);
            .toFormatter(Locale.ROOT)
        IsoFields.WEEK_BASED_YEAR,
        .appendLiteral(':')
    private static final DateFormatter BASIC_DATE_TIME = new JavaDateFormatter(
        try {
            .appendZoneOrOffsetId()
        .optionalStart()
            .appendOffset("+HH:MM", "Z")
        .appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
     * separated by a 'T' (xxxx'W'wwe'T'HHmmssX).
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        ChronoField.YEAR,
import java.time.format.SignStyle;
        .toFormatter(Locale.ROOT)
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
        .optionalEnd()
        // convert to a zoned date time! If not, we have to extend the above methods
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            // this one here is lenient as well to retain joda time based bwc compatibility
        STRICT_DATE_OPTIONAL_TIME_PRINTER,
    private static LocalDate localDateFromWeekBasedDate(TemporalAccessor accessor, Locale locale) {
     */
            .withResolverStyle(ResolverStyle.STRICT)
        .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
    )
    );
        .withResolverStyle(ResolverStyle.STRICT);
        new DateTimeFormatterBuilder().append(BASIC_WEEK_DATE_FORMATTER)
        HOUR_MINUTE_FORMATTER
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 4, SignStyle.NORMAL)
                .with(weekFields.weekOfWeekBasedYear(), accessor.get(weekFields.weekOfWeekBasedYear()))
            .toFormatter(Locale.ROOT)
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
        boolean isLocalTimeSet = localTime != null;
            .withResolverStyle(ResolverStyle.STRICT)
            .optionalStart()
        new DateTimeFormatterBuilder().appendLiteral('T')
    /*
                case STRICT_T_TIME_NO_MILLIS:
        .toFormatter(Locale.ROOT)
    /*
                    return WEEKYEAR;
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2, 2, SignStyle.NEVER)
            .toFormatter(Locale.ROOT)
    private static final DateTimeFormatter DATE_TIME_PREFIX = new DateTimeFormatterBuilder().append(DATE_FORMATTER)
        .appendLiteral("W")
    );
     * day. (uuuu-MM-dd'T'HH)
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR)
    );
     */
            .append(TIME_PREFIX)
        .optionalStart()
            .appendZoneOrOffsetId()
            return null;
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
        .withResolverStyle(ResolverStyle.STRICT);
    );
     * Returns a formatter for a two digit hour of day. (HH)
        )
            .appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE)
        .toFormatter(Locale.ROOT)
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
        .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
            .withResolverStyle(ResolverStyle.STRICT)
    /*
                            "Format name \"week_year\" is deprecated and will be removed in a future version. Use \"weekyear\" format instead"
            .appendLiteral(':')
            .toFormatter(Locale.ROOT)
    )
            .withResolverStyle(ResolverStyle.STRICT),
    )
                case STRICT_DATE_HOUR_MINUTE:
import java.time.temporal.TemporalAdjusters;
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
            .append(DateTimeFormatter.ofPattern("'T'HHmmssX", Locale.ROOT))
                case WEEK_DATE:
    );
        }
    );
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
     * second (HH:mm:ss.SSS).
            .appendLiteral("T")
            .toFormatter(Locale.ROOT)
     */
        .appendLiteral(':')
    private static final DateFormatter T_TIME = new JavaDateFormatter(
            .withResolverStyle(ResolverStyle.STRICT)
    private static final DateFormatter WEEK_YEAR = new JavaDateFormatter(
            .appendValue(MONTH_OF_YEAR)
        STRICT_DATE_PRINTER,
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder().appendValue(
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        boolean isLocalDateSet = localDate != null;
        1,
        .appendLiteral(':')
            return localDateFromWeekBasedDate(accessor, locale);
            .appendLiteral("-")
            .optionalEnd()
            .appendOffset("+HH:MM", "Z")
            .withResolverStyle(ResolverStyle.STRICT)
            .toFormatter(Locale.ROOT)
        .withResolverStyle(ResolverStyle.STRICT);
        HOUR_OF_DAY,
            .append(BASIC_TIME_NO_MILLIS_BASE)
            .withResolverStyle(ResolverStyle.STRICT)
     */
        .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ss.SSSZZ).
        }
        .appendLiteral('-')
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_NO_MILLIS_BASE)
    /*
     * Returns a formatter that combines a full weekyear date and time,
    );
     * time zone offset prefixed by 'T' ('T'HH:mm:ss.SSSZZ).
            .appendZoneOrOffsetId()
        "strict_t_time",
    private static final DateTimeFormatter STRICT_ORDINAL_DATE_TIME_FORMATTER_BASE = new DateTimeFormatterBuilder().appendValue(
            .append(TIME_ZONE_FORMATTER_NO_COLON)
     */
    /*
        ChronoField.YEAR,
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_PRINTER)
        HOUR_OF_DAY,
        new DateTimeFormatterBuilder().appendPattern("yyyyDDD")
     * Returns a basic formatter that combines a basic weekyear date and time,
        "year",
        "strict_basic_week_date",
    );
            .appendLiteral("T")
            .appendOffset("+HH:MM", "Z")
            .appendZoneOrOffsetId()
     */
    private static final DateFormatter STRICT_DATE_HOUR = new JavaDateFormatter(
            .toFormatter(Locale.ROOT)
    /*
        new DateTimeFormatterBuilder().append(HOUR_MINUTE_FORMATTER)
     * - If an iso based weekyear is found, but not week is specified, the first monday
                    return STRICT_HOUR_MINUTE_SECOND;
    // ---------------------------------------
    private static final DateTimeFormatter STRICT_TIME_FORMATTER_BASE = new DateTimeFormatterBuilder().appendValue(
            .toFormatter(Locale.ROOT)
    );
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 1, 2, SignStyle.NEVER)
    private static final DateFormatter STRICT_DATE_HOUR_MINUTE = new JavaDateFormatter(
                    return DATE_TIME_NO_MILLIS;
            .withResolverStyle(ResolverStyle.STRICT),
        ChronoField.YEAR,
                    return STRICT_YEAR_MONTH;
                + "Use snake case name {} instead.";
            .withResolverStyle(ResolverStyle.STRICT),
    ).appendFraction(NANO_OF_SECOND, 1, 9, true).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);
            .withResolverStyle(ResolverStyle.STRICT)
    );
        } else if (accessor.isSupported(MONTH_OF_YEAR)) {
     */
            .withResolverStyle(ResolverStyle.STRICT)
        .appendFraction(NANO_OF_SECOND, 3, 9, true)
     * digit year and three digit dayOfYear (uuuu-DDD).
                    break;
            .toFormatter(Locale.ROOT)
                input,
     * Returns a basic formatter that combines a basic date and time without millis,
    private static final DateFormatter BASIC_WEEK_DATE = new JavaDateFormatter(
        new DateTimeFormatterBuilder().appendLiteral("T")
            .appendLiteral("-")
        .appendLiteral('T')
            .toFormatter(Locale.ROOT)
     * month of year, and two digit day of month (uuuuMMdd).
        .optionalEnd()
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
    private static LocalDate getFirstOfMonth(TemporalAccessor accessor) {
        // we should not reach this piece of code, everything being parsed we should be able to
        "basic_time",
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
        .appendLiteral(':')
            .append(BASIC_TIME_NO_MILLIS_BASE)
            .toFormatter(Locale.ROOT)
     * Returns a formatter for a two digit hour of day, two digit minute of
        .withResolverStyle(ResolverStyle.STRICT);
    );
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
            .withResolverStyle(ResolverStyle.STRICT)
            .append(STRICT_TIME_PRINTER)
     * Returns a formatter for a two digit hour of day, two digit minute of
 * specific language governing permissions and limitations
        }
        1,
    )
     */
            .appendZoneOrOffsetId()
        .append(BASIC_T_TIME_FORMATTER)
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
            .appendValue(MONTH_OF_YEAR, 1, 2, SignStyle.NOT_NEGATIVE)
                case ORDINAL_DATE_TIME:
    )
     * Returns a formatter for a full date as four digit weekyear, two digit
    // END basic time formatters
    /*
    public static final WeekFields WEEK_FIELDS_ROOT = WeekFields.of(DayOfWeek.MONDAY, 4);
                int year = getYear(accessor);
        .appendLiteral('T')
        .withResolverStyle(ResolverStyle.STRICT);
    ).appendLiteral('T').append(STRICT_HOUR_MINUTE_SECOND_FORMATTER).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);
        .appendValue(DAY_OF_MONTH, 2, 2, SignStyle.NOT_NEGATIVE)
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
    private static final DateFormatter STRICT_HOUR = new JavaDateFormatter("strict_hour", DateTimeFormatter.ofPattern("HH", Locale.ROOT));
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
                    return STRICT_YEAR_MONTH_DAY;
        "strict_date_time",
        .toFormatter(Locale.ROOT)
     */
        WeekFields weekFields = WeekFields.of(locale);
     * - If no time is given, the start of the day is used
        .appendLiteral('-')
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        .appendLiteral('T')
                    return STRICT_WEEK_DATE;
        .append(BASIC_TIME_FORMATTER)
                    return STRICT_DATE_HOUR_MINUTE;
    // these formatters to not have any splitting characters between hours, minutes, seconds, milliseconds
            .toFormatter(Locale.ROOT)
    );
    private static final DateFormatter ORDINAL_DATE_TIME = new JavaDateFormatter(
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        2,
/*
            .append(STRICT_TIME_FORMATTER_BASE)
     * Returns a formatter for a four digit weekyear
                case STRICT_WEEKYEAR:
    // ---------------------------------------
            .appendLiteral("T")
            .toFormatter(Locale.ROOT)
    /*
    // NOTE: this is not a strict formatter to retain the joda time based behaviour, even though it's named like this
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
        .withResolverStyle(ResolverStyle.STRICT);
                    return STRICT_T_TIME_NO_MILLIS;
        .appendLiteral('T')
        .optionalEnd()
            .append(STRICT_TIME_PRINTER)
        .appendLiteral('T')
    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder().append(DATE_FORMATTER)
            .append(BASIC_TIME_NO_MILLIS_BASE)
 * Licensed to Elasticsearch under one or more contributor
        new DateTimeFormatterBuilder().append(ORDINAL_DATE_TIME_NO_MILLIS_BASE)
     */
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
        .optionalStart()
    }
        DATE_FORMATTER
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
            .optionalStart()
    private static final DateTimeFormatter T_TIME_NO_MILLIS_FORMATTER = new DateTimeFormatterBuilder().appendLiteral("T")
     * This is not fully compatible to the existing spec, its more linient and closely follows w3c note on datetime
     * using a four digit year and three digit dayOfYear (uuuu-DDD'T'HH:mm:ssZZ).
            .toFormatter(Locale.ROOT)
import java.time.temporal.TemporalAccessor;
        .appendLiteral(':')
     * fraction of second (uuuu-MM-dd'T'HH:mm:ss.SSS).
                    return ORDINAL_DATE_TIME;
     * minute. (uuuu-MM-dd'T'HH:mm:ss)
     * (uuuu-MM-dd'T'HH:mm:ss.SSSZZ).
            .appendZoneOrOffsetId()
        .optionalStart()
     * Returns a formatter for a full ordinal date and time without millis,
            .toFormatter(Locale.ROOT)
        5,
            .withResolverStyle(ResolverStyle.STRICT),
     * Returns a formatter for a two digit hour of day and two digit minute of
    )
            .withResolverStyle(ResolverStyle.STRICT),
        .appendValue(MONTH_OF_YEAR, 2, 2, SignStyle.NOT_NEGATIVE)
            .append(STRICT_TIME_NO_MILLIS_BASE)
        "basic_t_time",
    private static final DateFormatter BASIC_TIME = new JavaDateFormatter(
        "strict_ordinal_date_time_no_millis",
     * This is not fully compatible to the existing spec, which would require far more edge cases, but merely compatible with the
            .appendLiteral("T")
     * Returns a formatter that combines a full date and time, separated by a 'T'
        () -> DeprecationLogger.getLogger(FormatNames.class)
    );
    private static final DateFormatter HOUR = new JavaDateFormatter(
     * zoned date time are set
            .appendZoneOrOffsetId()
            .appendZoneOrOffsetId()
    private static final DateFormatter WEEKYEAR_WEEK_DAY = new JavaDateFormatter(
    private static final DateFormatter STRICT_DATE_OPTIONAL_TIME_NANOS = new JavaDateFormatter(
            .toFormatter(Locale.ROOT)
        .appendLiteral(':')
        .withResolverStyle(ResolverStyle.STRICT);
        .optionalStart()
     * This action assumes that we can reliably fall back to some defaults if not all parts of a
    );
            .withResolverStyle(ResolverStyle.STRICT)
        "week_date_time_no_millis",
        if (accessor.isSupported(WeekFields.of(locale).weekBasedYear())) {
        .toFormatter(Locale.ROOT)
        .appendOffset("+HH:MM", "Z")
                .appendLiteral(':')
        .withResolverStyle(ResolverStyle.STRICT);
            .withResolverStyle(ResolverStyle.STRICT),
            .toFormatter(Locale.ROOT)
    private static final DateTimeFormatter BASIC_DATE_TIME_PRINTER = new DateTimeFormatterBuilder().append(BASIC_YEAR_MONTH_DAY_FORMATTER)
        .appendLiteral(':')
        } else {
        1,
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
    );
        STRICT_HOUR_MINUTE_SECOND_MILLIS_FORMATTER
        .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
        "strict_time",
            // missing year, falling back to the epoch and then filling
     */
                    return BASIC_DATE_TIME;
        SignStyle.NOT_NEGATIVE
        .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
 *
        .withResolverStyle(ResolverStyle.STRICT);
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
import java.time.LocalDate;
            .appendZoneOrOffsetId()
    /*
            new DateTimeFormatterBuilder().append(DATE_FORMATTER)
            .append(STRICT_TIME_NO_MILLIS_BASE)
    private static final DateFormatter STRICT_DATE = new JavaDateFormatter(
    private static final DateFormatter WEEK_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
            .appendValue(HOUR_OF_DAY, 1, 2, SignStyle.NOT_NEGATIVE)
    /*
        .optionalEnd()
     * Returns a formatter for a two digit hour of day, two digit minute of
        2,
    );
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateTimeFormatter HOUR_MINUTE_SECOND_FRACTION_FORMATTER = new DateTimeFormatterBuilder().appendValue(
        new DateTimeFormatterBuilder().appendLiteral("T")
        "date_hour_minute",
            zoneId = defaultZone;
     */
            .withResolverStyle(ResolverStyle.STRICT)
        .appendLiteral('-')
        new DateTimeFormatterBuilder().append(STRICT_WEEKYEAR_WEEK_FORMATTER)
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_PRINTER)
        "strict_hour_minute",
        .appendLiteral('-')
        STRICT_DATE_OPTIONAL_TIME_PRINTER,
     * An ISO date formatter that formats or parses a date without an offset, such as '2011-12-03'.
    private static final DateFormatter STRICT_DATE_HOUR_MINUTE_SECOND_FRACTION = new JavaDateFormatter(
                .with(TemporalAdjusters.previousOrSame(weekFields.getFirstDayOfWeek()));
        "hour_minute_second_millis",
        4,
import java.time.ZoneId;
            .withResolverStyle(ResolverStyle.STRICT),
        new DateTimeFormatterBuilder().append(BASIC_DATE_T)
    );
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .appendLiteral("T")
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_FORMATTER_BASE)
    private static final DateFormatter BASIC_ORDINAL_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
            .appendOffset("+HH:MM", "Z")
        SignStyle.NOT_NEGATIVE
        SignStyle.EXCEEDS_PAD
    private static final DateFormatter DATE_HOUR_MINUTE_SECOND_MILLIS = new JavaDateFormatter(
                    return STRICT_BASIC_WEEK_DATE_TIME;
    }
        DATE_TIME_NO_MILLIS_PRINTER,
            if (accessor.isSupported(DAY_OF_MONTH)) {
    /*
     * Returns a basic formatter for a two digit hour of day, two digit minute
     * Returns a basic formatter for a two digit hour of day, two digit minute
                .optionalStart()
            .append(TIME_ZONE_FORMATTER_NO_COLON)
     */
        .optionalEnd()
        .withResolverStyle(ResolverStyle.STRICT);
            .appendFraction(NANO_OF_SECOND, 1, 9, false)
        "strict_year_month",
        .withResolverStyle(ResolverStyle.STRICT);
    );
     * offset prefixed by 'T' ('T'HHmmss.SSSZ).
 *
        .optionalEnd()
        2,
        new DateTimeFormatterBuilder().appendValue(WEEK_FIELDS_ROOT.weekBasedYear())
        "strict_date_hour",
            .withResolverStyle(ResolverStyle.STRICT),
            .toFormatter(Locale.ROOT)
 * Modifications Copyright OpenSearch Contributors. See
     */
            .toFormatter(Locale.ROOT)
        .optionalEnd()
    )
            .optionalEnd()
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .withResolverStyle(ResolverStyle.STRICT)
        .appendLiteral('-')
        .appendPattern("HH:mm")
     * digit year and three digit dayOfYear (uuuuDDD).
        .appendLiteral(':')
        .optionalEnd()
        .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
        new DateTimeFormatterBuilder().appendLiteral("T")
        STRICT_YEAR_MONTH_DAY_FORMATTER
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2)
            .toFormatter(Locale.ROOT)
     * Returns a formatter for a two digit hour of day, two digit minute of
    };
     * ('T'HHmmssZ).
        .toFormatter(Locale.ROOT)
                case STRICT_DATE_TIME_NO_MILLIS:
import java.time.temporal.WeekFields;
    /*
    );
     * A strict formatter that formats or parses a year, such as '2011'.
            .toFormatter(Locale.ROOT)
                // strict date formats here, must be at least 4 digits for year and two for months and two for day
    private static final DateTimeFormatter STRICT_DATE_PRINTER = new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
            .appendLiteral("-")
     * Returns a basic formatter that combines a basic weekyear date and time,
        new DateTimeFormatterBuilder().append(BASIC_TIME_PRINTER)
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
    private static final LazyInitializable<DeprecationLogger, RuntimeException> deprecationLogger = new LazyInitializable(
    /*
                case STRICT_DATE_OPTIONAL_TIME_NANOS:
import java.util.Locale;
            .appendOffset("+HH:MM", "Z")
     * Returns a formatter for a two digit hour of day, two digit minute of
        .optionalStart()
     * Returns a formatter for a full ordinal date and time without millis,
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        new DateTimeFormatterBuilder().append(DATE_TIME_FORMATTER)
            .withResolverStyle(ResolverStyle.STRICT),
    private static final DateFormatter STRICT_T_TIME_NO_MILLIS = new JavaDateFormatter(
    private static final DateTimeFormatter STRICT_DATE_OPTIONAL_TIME_PRINTER = new DateTimeFormatterBuilder().append(
        .appendFraction(NANO_OF_SECOND, 3, 3, true)
     */
        .appendLiteral('-')
                case BASIC_DATE:
    /*
        .optionalEnd()
        SignStyle.NORMAL
    /*
        STRICT_HOUR_MINUTE_SECOND_FORMATTER,
     * two digit minute of hour, two digit second of minute, and three digit
    //
        .optionalEnd()
        } catch (IllegalArgumentException e) {
                }
            .optionalStart()
        .appendValue(DAY_OF_YEAR, 3, 3, SignStyle.NOT_NEGATIVE)
    // start lenient formatters
        .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
        new DateTimeFormatterBuilder().append(STRICT_TIME_FORMATTER_BASE)
        new DateTimeFormatterBuilder().append(TIME_PREFIX)
     */
                case STRICT_YEAR:
            .toFormatter(Locale.ROOT)
                    return WEEK_YEAR;
        .toFormatter(Locale.ROOT)
            .appendLiteral("T")
                    return STRICT_YEAR;
                        .deprecate(
     * A basic formatter for a full date as four digit year, two digit
            .toFormatter(Locale.ROOT)
            .append(STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER)
            .withResolverStyle(ResolverStyle.STRICT),
    private static final DateTimeFormatter BASIC_TIME_NO_MILLIS_BASE = new DateTimeFormatterBuilder().appendValue(
            .append(STRICT_TIME_NO_MILLIS_BASE)
     */
        .appendValue(DAY_OF_MONTH, 2, 2, SignStyle.NOT_NEGATIVE)
        .withResolverStyle(ResolverStyle.STRICT);
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            .toFormatter(Locale.ROOT)
     * week of weekyear, and one digit day of week (xxxx-'W'ww-e).
        .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
        new DateTimeFormatterBuilder().append(TIME_PREFIX)
     */
                case STRICT_DATE_HOUR:
        "strict_year",
    );
        .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT),
    private static final DateTimeFormatter ISO_WEEK_DATE_T = new DateTimeFormatterBuilder().append(ISO_WEEK_DATE)
            .withResolverStyle(ResolverStyle.STRICT),
     */
            .append(BASIC_TIME_NO_MILLIS_BASE)
            .appendLiteral(':')
                    return STRICT_DATE_HOUR_MINUTE_SECOND_FRACTION;
                    return STRICT_DATE_HOUR_MINUTE_SECOND;
        "strict_date_hour_minute_second_fraction",
        .optionalEnd()
            .toFormatter(Locale.ROOT)
    private static final DateFormatter STRICT_TIME = new JavaDateFormatter(
    )
            .optionalEnd()
            .appendZoneOrOffsetId()
            .appendLiteral("T")
    //
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(BASIC_TIME_FORMATTER)
     */
                case WEEKYEAR_WEEK_DAY:
    static DateFormatter forPattern(String input) {
            return accessor.get(ChronoField.YEAR_OF_ERA);
    );
            .toFormatter(Locale.ROOT)
        .appendLiteral(':')
     */
     */
        SignStyle.NOT_NEGATIVE
        .optionalEnd()
        .withResolverStyle(ResolverStyle.STRICT);
        .optionalStart()
     * weekyear. (xxxx-'W'ww)
     * Returns a formatter for a full ordinal date and time, using a four
     * Returns a formatter that combines a full date, two digit hour of day,
        2,
                case STRICT_WEEKYEAR_WEEK:
        "basic_ordinal_date",
            .optionalStart()
            .toFormatter(Locale.ROOT)
        .optionalStart()
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)
        new DateTimeFormatterBuilder().append(STRICT_TIME_NO_MILLIS_BASE)
            .toFormatter(Locale.ROOT)
            .appendOffset("+HH:MM", "Z")
            .withResolverStyle(ResolverStyle.STRICT),
        "date_hour_minute_second_fraction",
                    deprecationLogger.getOrCompute()
        .appendLiteral("-W")
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(DATE_TIME_PREFIX)
                return LocalDate.of(year, accessor.get(MONTH_OF_YEAR), 1);
        2,
        DateTimeFormatter.ofPattern("HH", Locale.ROOT),
    )
import java.time.ZonedDateTime;
        .toFormatter(Locale.ROOT)
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
    );
     * Returns a formatter for a four digit weekyear, two digit week of
                    return BASIC_ORDINAL_DATE_TIME_NO_MILLIS;
        STRICT_YEAR_MONTH_DAY_FORMATTER
                    return HOUR_MINUTE;
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
            .append(BASIC_TIME_NO_MILLIS_BASE)
    );
     * Returns RFC 3339 a popular ISO 8601 profile compatible date time formatter and parser.
     */
        if (accessor.isSupported(ChronoField.YEAR_OF_ERA)) {
                    return STRICT_ORDINAL_DATE_TIME;
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .append(DateTimeFormatter.ofPattern("'T'HHmmss.SSSX", Locale.ROOT))
        "date_hour_minute_second_millis",
            .optionalEnd()
        STRICT_DATE_OPTIONAL_TIME_PRINTER,
            .optionalEnd()
    /*
            .append(TIME_ZONE_FORMATTER_NO_COLON)
    private static final DateFormatter DATE_HOUR = new JavaDateFormatter(
        .appendValue(IsoFields.WEEK_BASED_YEAR, 4)
    );
     * - If no timezone is found, ZoneOffset.UTC is used
        4,
        4,
    );
import org.opensearch.common.SuppressForbidden;
        .optionalEnd()
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
    /*
        .optionalEnd()
        .optionalStart()
                case STRICT_BASIC_WEEK_DATE:
            .withResolverStyle(ResolverStyle.STRICT),
                    return EpochTime.MICROS_FORMATTER;
            .appendZoneOrOffsetId()
        public LocalDate queryFrom(TemporalAccessor temporal) {
            } else {
            .append(STRICT_TIME_NO_MILLIS_BASE)
        1,
                    return STRICT_ORDINAL_DATE;
            .toFormatter(Locale.ROOT)
/**
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)
    private static final DateFormatter STRICT_TIME_NO_MILLIS = new JavaDateFormatter(
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 1, 2, SignStyle.NOT_NEGATIVE)
                    return DATE_HOUR_MINUTE_SECOND;
        .appendFraction(NANO_OF_SECOND, 3, 9, true)
            .withResolverStyle(ResolverStyle.STRICT),
            .withResolverStyle(ResolverStyle.STRICT),
        .optionalEnd()
        .toFormatter(Locale.ROOT)
            .appendZoneOrOffsetId()
            .appendValue(WEEK_FIELDS_ROOT.dayOfWeek())
            .appendValue(MONTH_OF_YEAR)
    private static final DateFormatter ORDINAL_DATE = new JavaDateFormatter("ordinal_date", ORDINAL_DATE_PRINTER, ORDINAL_DATE_FORMATTER);
     */
        "date_time_no_millis",
    /*
     */
            .appendOffset("+HHmm", "Z")
            .appendOffset("+HH:MM", "Z")
    private static int getYear(TemporalAccessor accessor) {
    private static final DateFormatter DATE_OPTIONAL_TIME = new JavaDateFormatter(
        2,
            .withResolverStyle(ResolverStyle.STRICT),
    /*
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
            .optionalStart()
     */
    );
                case STRICT_HOUR_MINUTE_SECOND_FRACTION:
     * and then act on it accordingly
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm", Locale.ROOT),
        new DateTimeFormatterBuilder().append(DATE_TIME_PREFIX)
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
        "basic_date",
            .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
        .appendLiteral('T')
    );
     * separated by a 'T' (uuuuMMdd'T'HHmmssZ).
        .withResolverStyle(ResolverStyle.STRICT);
    )
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
        .appendLiteral(':')
    public static ZonedDateTime from(TemporalAccessor accessor, Locale locale) {
        .toFormatter(Locale.ROOT)
        "ordinal_date_time",
            .append(T_TIME_NO_MILLIS_FORMATTER)
 */
    // ---------------------------------------
    /*
                case STRICT_YEAR_MONTH:
        "t_time",
                case BASIC_T_TIME:
    /*
    private static final DateFormatter STRICT_WEEK_DATE_TIME = new JavaDateFormatter(
        .optionalStart()
    /*
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
        HOUR_OF_DAY,
            .withResolverStyle(ResolverStyle.STRICT),
    );
        .appendLiteral("-")
            .toFormatter(Locale.ROOT)
        .optionalStart()
            .withResolverStyle(ResolverStyle.STRICT)
        .withResolverStyle(ResolverStyle.STRICT);
     */
                case YEAR_MONTH:
        new DateTimeFormatterBuilder().append(BASIC_TIME_NO_MILLIS_BASE)
        10,
     * hour, two digit second of minute, three digit fraction of second, and
     * Returns a basic formatter that combines a basic weekyear date and time
    private static final DateTimeFormatter WEEK_DATE_FORMATTER = new DateTimeFormatterBuilder().appendValue(
    // ---------------------------------------
                            "week_year_format_name",
            .withResolverStyle(ResolverStyle.STRICT)
            .appendOffset("+HH:MM", "Z")
                case STRICT_WEEK_DATE:
        new DateTimeFormatterBuilder().append(BASIC_T_TIME_PRINTER)
        new DateTimeFormatterBuilder().append(BASIC_T_TIME_FORMATTER)
        new DateTimeFormatterBuilder().append(T_TIME_NO_MILLIS_FORMATTER)
    /*
     * Returns a basic formatter for a two digit hour of day, two digit minute
     * <p>
     */
     *
            .append(STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER)
            .appendValue(DAY_OF_MONTH)
    private static final DateFormatter STRICT_HOUR_MINUTE = new JavaDateFormatter(
        }
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(ORDINAL_DATE_TIME_FORMATTER_BASE)
            .optionalStart()
        STRICT_YEAR_MONTH_DAY_FORMATTER
            .toFormatter(Locale.ROOT)
            .append(HOUR_MINUTE_SECOND_MILLIS_FORMATTER)
            }
            .toFormatter(Locale.ROOT)
        STRICT_YEAR_MONTH_DAY_FORMATTER
        .withResolverStyle(ResolverStyle.STRICT);
        .withResolverStyle(ResolverStyle.STRICT);
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT),
import org.opensearch.common.logging.DeprecationLogger;
    // ---------------------------------------
        .appendLiteral(':')
        10,
        "strict_time_no_millis",
            .withResolverStyle(ResolverStyle.STRICT)
        STRICT_HOUR_MINUTE_SECOND_FORMATTER
            .toFormatter(Locale.ROOT)
            .appendZoneOrOffsetId()
    /*
    private static final DateTimeFormatter HOUR_MINUTE_SECOND_MILLIS_FORMATTER = new DateTimeFormatterBuilder().appendValue(
        .appendValue(DAY_OF_YEAR, 3, 3, SignStyle.NOT_NEGATIVE)
    /*
                    return DATE_HOUR_MINUTE_SECOND_MILLIS;
 * GitHub history for details.
    // when run with JDK8, WeekFields for Locale.ROOT would return WeekFields.of(DayOfWeek.SUNDAY,1)
        new DateTimeFormatterBuilder().append(STRICT_TIME_PRINTER)
    private static final DateTimeFormatter STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER = new DateTimeFormatterBuilder().append(
    private static final DateTimeFormatter STRICT_DATE_TIME_NO_MILLIS_FORMATTER = new DateTimeFormatterBuilder().append(
     * hour, two digit second of minute, three digit fraction of second, and
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss", Locale.ROOT)
    );
        .appendLiteral(':')
            .append(STRICT_TIME_PRINTER)
                    return HOUR_MINUTE_SECOND_MILLIS;
    private static LocalDate getLocalDate(TemporalAccessor accessor, Locale locale) {
        .optionalEnd()
     */
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
     */
            if (temporal.isSupported(ChronoField.EPOCH_DAY)) {
        } else if (isLocalDateSet) {
     * time zone offset (HH:mm:ss.SSSZZ).
        new DateTimeFormatterBuilder().append(BASIC_TIME_NO_MILLIS_BASE)
    /*
            .withResolverStyle(ResolverStyle.STRICT)
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
        new DateTimeFormatterBuilder().appendPattern("yyyyDDD")
        .optionalStart()
                .with(weekFields.weekBasedYear(), accessor.get(weekFields.weekBasedYear()))
     * by a 'T' (uuuuMMdd'T'HHmmss.SSSZ).
            .append(BASIC_T_TIME_FORMATTER)
    );
     */
        "strict_date_hour_minute_second",
            .appendValue(WEEK_FIELDS_ROOT.weekOfWeekBasedYear())
    /*
        .appendLiteral(':')
    public static ZonedDateTime from(TemporalAccessor accessor) {
        }
            .withResolverStyle(ResolverStyle.STRICT),
     */
            .optionalStart()
                    return STRICT_DATE_TIME;
    // ---------------------------------------
     * Returns a formatter for a four digit weekyear. (YYYY)
            .appendOffset("+HH:MM", "Z")
        2,
     */
    )
        .appendZoneId()
            .append(STRICT_TIME_NO_MILLIS_BASE)
        new DateTimeFormatterBuilder().appendPattern("uuuuDDD")
                case DATE_TIME_NO_MILLIS:
        @Override
                    return STRICT_BASIC_WEEK_DATE;
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            return of(localDate, localTime, zoneId);
                case BASIC_T_TIME_NO_MILLIS:
     * Returns a formatter that combines a full date and two digit hour of
    /*
     */
    private static final DateFormatter HOUR_MINUTE_SECOND = new JavaDateFormatter(
/*
     * Returns a formatter that combines a full weekyear date and time without millis,
                case BASIC_WEEK_DATE:
        new DateTimeFormatterBuilder().append(BASIC_DATE_TIME_PRINTER)
                case YEAR_MONTH_DAY:
     *   no defaults will be applied
                    return STRICT_T_TIME;
            .withResolverStyle(ResolverStyle.STRICT)
    // BEGIN basic time formatters
            .appendOffset("+HH:MM", "Z")
     * A strict formatter that formats or parses a year and a month, such as '2011-12'.
            .toFormatter(Locale.ROOT)
     * offset (HHmmss.SSSZ).
                    return STRICT_TIME;
        .appendLiteral(',')
        .optionalStart()
        "strict_ordinal_date_time",
        .toFormatter(Locale.ROOT)
                    return BASIC_DATE_TIME_NO_MILLIS;
     * A strict formatter that formats or parses a hour, minute and second, such as '09:43:25'.
        new DateTimeFormatterBuilder().append(STRICT_TIME_PRINTER)
        .toFormatter(Locale.ROOT)
     */
            .appendZoneOrOffsetId()
        2,
     * without millis, separated by a 'T' (xxxx'W'wwe'T'HHmmssX).
        .appendFraction(NANO_OF_SECOND, 1, 3, true)
            .appendLiteral("T")
     * hour, two digit second of minute, and three digit fraction of
            .toFormatter(Locale.ROOT)
    private static final DateTimeFormatter STRICT_DATE_OPTIONAL_TIME_FORMATTER_WITH_NANOS = new DateTimeFormatterBuilder().append(
    private static final DateTimeFormatter BASIC_DATE_TIME_FORMATTER = new DateTimeFormatterBuilder().append(BASIC_YEAR_MONTH_DAY_FORMATTER)
            .withResolverStyle(ResolverStyle.STRICT)
            .toFormatter(Locale.ROOT)
    );
    /**
            .toFormatter(Locale.ROOT)
        .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
import java.time.format.DateTimeFormatterBuilder;
            .withResolverStyle(ResolverStyle.STRICT)
        DateTimeFormatter.ofPattern("HH:mm", Locale.ROOT)
        STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER,
            .toFormatter(Locale.ROOT)
    // If LogManager.getLogger is called before logging config is loaded
        "date_hour_minute_second",
    private static final DateFormatter STRICT_WEEK_DATE = new JavaDateFormatter("strict_week_date", ISO_WEEK_DATE);
                    return WEEKYEAR_WEEK;
            .appendZoneOrOffsetId()
        throw new IllegalArgumentException("temporal accessor [" + accessor + "] cannot be converted to zoned date time");
import static java.time.temporal.ChronoField.NANO_OF_SECOND;
        .toFormatter(Locale.ROOT)
        .optionalStart()
        .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)
        .appendLiteral(':')
        .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)
                case BASIC_ORDINAL_DATE_TIME_NO_MILLIS:
        SignStyle.EXCEEDS_PAD
    /*
     * Returns a ISO 8601 compatible date time formatter and parser.
        .toFormatter(Locale.ROOT)
    /*
     * - If an iso based weekyear is found and an iso based weekyear week, the start
        "strict_date_hour_minute_second_millis",
                .optionalStart()
            .append(TIME_ZONE_FORMATTER_NO_COLON)
import org.opensearch.core.common.Strings;
    //
        .appendLiteral('T')
                    formatName.getSnakeCaseName()
        .appendLiteral(':')
 */
            .appendLiteral("-")
     * Returns a formatter for a two digit hour of day, two digit minute of
                case STRICT_WEEK_DATE_TIME_NO_MILLIS:
            .withResolverStyle(ResolverStyle.STRICT),
            .toFormatter(Locale.ROOT)
                case STRICT_YEAR_MONTH_DAY:
            .appendOffset("+HH:MM", "Z")
                    return STRICT_WEEKYEAR_WEEK;
    private static final DateFormatter DATE_TIME_NO_MILLIS = new JavaDateFormatter(
package org.opensearch.common.time;
            .withResolverStyle(ResolverStyle.STRICT),
            .appendLiteral(':')
     * - If we find a time and a date, converting to a ZonedDateTime is straight forward,
                case STRICT_DATE:
        .appendValue(WEEK_FIELDS_ROOT.weekOfWeekBasedYear(), 2, 2, SignStyle.NOT_NEGATIVE)
     * of hour, two digit second of minute, three digit millis, and time zone
        .optionalStart()
            .appendOffset("+HH:MM", "Z")
     * of year, and two digit day of month (uuuu-MM-dd).
        SignStyle.NOT_NEGATIVE
            .toFormatter(Locale.ROOT)
     * hour, two digit second of minute, three digit fraction of second, and
            .optionalStart()
import java.time.ZoneOffset;
        "week_date_time",
            .toFormatter(Locale.ROOT)
     * @param accessor The accessor returned from a parser
            .withResolverStyle(ResolverStyle.STRICT)
    private static final DateFormatter ORDINAL_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
                    return EpochTime.SECONDS_FORMATTER;
            .optionalEnd()
        new DateTimeFormatterBuilder().append(ORDINAL_DATE_TIME_NO_MILLIS_BASE)
                    return YEAR_MONTH_DAY;
        STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER,
    // ---------------------------------------
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_NO_MILLIS_BASE)
            .withResolverStyle(ResolverStyle.STRICT),
     * of hour, two digit second of minute, and time zone offset prefixed by 'T'
            .withResolverStyle(ResolverStyle.STRICT),
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
    /*
        new DateTimeFormatterBuilder().appendValue(WEEK_FIELDS_ROOT.weekBasedYear(), 4, 10, SignStyle.EXCEEDS_PAD)
import java.time.temporal.IsoFields;
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        HOUR_OF_DAY,
    }
    private static final DateFormatter HOUR_MINUTE_SECOND_FRACTION = new JavaDateFormatter(
        DateTimeFormatter.ISO_LOCAL_DATE.withResolverStyle(ResolverStyle.LENIENT)
        new DateTimeFormatterBuilder().appendValue(WEEK_FIELDS_ROOT.weekBasedYear())
                .appendFraction(NANO_OF_SECOND, 1, 9, false)
            .appendZoneOrOffsetId()
 * @opensearch.internal
     * time zone offset (HH:mm:ss.SSSZZ).
        10,
        .appendLiteral('-')
            .toFormatter(Locale.ROOT)
     * time zone offset prefixed by 'T' ('T'HH:mm:ss.SSSZZ).
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
    /*
        .withResolverStyle(ResolverStyle.STRICT);
    /**
        .appendLiteral('T')
            .withResolverStyle(ResolverStyle.STRICT),
                case DATE_HOUR_MINUTE_SECOND_MILLIS:
                case STRICT_T_TIME:
            .toFormatter(Locale.ROOT)
            }
        new DateTimeFormatterBuilder().append(ORDINAL_DATE_TIME_FORMATTER_BASE)
            .withResolverStyle(ResolverStyle.STRICT)
     * Returns a formatter that combines a full date and time, separated by a 'T'
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
        .appendValue(DAY_OF_YEAR, 1, 3, SignStyle.NOT_NEGATIVE)
    );
                case STRICT_WEEKYEAR_WEEK_DAY:
     * digit week of weekyear, and one digit day of week (xxxx'W'wwe).
                case HOUR_MINUTE:
        new DateTimeFormatterBuilder().appendLiteral('T')
        new DateTimeFormatterBuilder().append(BASIC_TIME_FORMATTER)
            .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
    private static final DateTimeFormatter ISO_WEEK_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive()
                case YEAR:
    //
        .appendLiteral("T")
            .withResolverStyle(ResolverStyle.STRICT),
                    return DATE;
        } else if (accessor.isSupported(ChronoField.YEAR) || accessor.isSupported(ChronoField.YEAR_OF_ERA)) {
     * A strict date formatter that formats or parses a date without an offset, such as '2011-12-03'.
            .optionalEnd()
    private static final DateTimeFormatter STRICT_DATE_FORMATTER = new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
        new DateTimeFormatterBuilder().appendValue(WEEK_FIELDS_ROOT.weekBasedYear())
                    return WEEK_DATE;
        SignStyle.NORMAL
    // ---------------------------------------
            .append(BASIC_T_TIME_PRINTER)
    );
        .toFormatter(Locale.ROOT)
        "strict_hour_minute_second_millis",
import org.opensearch.common.util.LazyInitializable;
                default:
                    return STRICT_HOUR_MINUTE_SECOND_MILLIS;
    // ---------------------------------------
    );
    private static final DateFormatter STRICT_YEAR_MONTH_DAY = new JavaDateFormatter(
            .toFormatter(Locale.ROOT)
        4,
        new DateTimeFormatterBuilder().append(STRICT_DATE_FORMATTER)
                    return STRICT_WEEKYEAR_WEEK_DAY;
    static final TemporalQuery<LocalDate> LOCAL_DATE_QUERY = new TemporalQuery<LocalDate>() {
 * this work for additional information regarding copyright
     * two digit minute of hour, and two digit second of
        SignStyle.EXCEEDS_PAD
    private static final DateTimeFormatter ORDINAL_DATE_TIME_NO_MILLIS_BASE = new DateTimeFormatterBuilder().append(ORDINAL_DATE_FORMATTER)
     * Returns a formatter for a four digit weekyear and two digit week of
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
                case STRICT_DATE_HOUR_MINUTE_SECOND_FRACTION:
    //
    // Note: milliseconds parsing is not strict, others are
            .toFormatter(Locale.ROOT)
    );
     * - If no month of the year is found, the first day of the year is used
        new DateTimeFormatterBuilder().append(BASIC_T_TIME_FORMATTER).append(TIME_ZONE_FORMATTER_NO_COLON).toFormatter(Locale.ROOT)
     */
            .toFormatter(Locale.ROOT)
     */
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
     */
            .append(TIME_ZONE_FORMATTER_NO_COLON)
    );
        .withResolverStyle(ResolverStyle.STRICT);
        SignStyle.NOT_NEGATIVE
        .appendLiteral(':')
            .withResolverStyle(ResolverStyle.STRICT)
    private static final DateFormatter BASIC_WEEK_DATE_TIME = new JavaDateFormatter(
    private static final DateTimeFormatter STRICT_BASIC_WEEK_DATE_PRINTER = new DateTimeFormatterBuilder().parseStrict()
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
        SignStyle.NOT_NEGATIVE
     */
        "strict_date_optional_time_nanos",
    /*
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
            .optionalEnd()
    private static final DateFormatter DATE_HOUR_MINUTE_SECOND_FRACTION = new JavaDateFormatter(
            .appendLiteral('T')
    // only the formatter, nothing optional here
    private static final DateFormatter DATE_TIME = new JavaDateFormatter(
                if (temporal.isSupported(ChronoField.MONTH_OF_YEAR) && temporal.isSupported(ChronoField.DAY_OF_MONTH)) {
        .appendLiteral('T')
    /*
                    return EpochTime.MILLIS_FORMATTER;
    private static final DateFormatter WEEKYEAR = new JavaDateFormatter(
    private static final LocalDate LOCALDATE_EPOCH = LocalDate.of(1970, 1, 1);
            .append(STRICT_TIME_NO_MILLIS_BASE)
    /*
        .appendValue(DAY_OF_YEAR, 3)
    );
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_FORMATTER_BASE)
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ss.SSSZZ).
            .optionalEnd()
        } else if (isLocalTimeSet) {
                    return STRICT_WEEK_DATE_TIME_NO_MILLIS;
                case STRICT_DATE_TIME:
     * Convert a temporal accessor to a zoned date time object - as performant as possible.
    private static final DateFormatter STRICT_BASIC_WEEK_DATE = new JavaDateFormatter(
        2,
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
        .optionalEnd()
                    return STRICT_ORDINAL_DATE_TIME_NO_MILLIS;
    );
        "basic_week_date",
        new DateTimeFormatterBuilder().append(STRICT_DATE_TIME_NO_MILLIS_FORMATTER)
    private static final DateTimeFormatter TIME_PREFIX = new DateTimeFormatterBuilder().append(TIME_NO_MILLIS_FORMATTER)
        STRICT_HOUR_MINUTE_SECOND_FORMATTER
            .appendZoneOrOffsetId()
        .appendLiteral('T')
        SignStyle.EXCEEDS_PAD
    /*
        .optionalStart()
            .withResolverStyle(ResolverStyle.STRICT),
    //
            .appendValue(HOUR_OF_DAY, 1, 2, SignStyle.NOT_NEGATIVE)
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
 *
 * You may obtain a copy of the License at
            .withResolverStyle(ResolverStyle.STRICT)
     * digit year and three digit dayOfYear (uuuu-DDD'T'HH:mm:ss.SSSZZ).
            .toFormatter(Locale.ROOT)
        STRICT_DATE_OPTIONAL_TIME_FORMATTER
                case DATE:
            .appendValue(MONTH_OF_YEAR, 2, 2, SignStyle.NOT_NEGATIVE)
    );
            .withResolverStyle(ResolverStyle.STRICT),
            .appendLiteral("-")
        STRICT_DATE_OPTIONAL_TIME_FORMATTER_WITH_NANOS
                case DATE_HOUR_MINUTE:
        new DateTimeFormatterBuilder().append(WEEK_DATE_FORMATTER)
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
    );
    );
        .append(TIME_ZONE_FORMATTER_NO_COLON)
            .toFormatter(Locale.ROOT)
            .appendZoneOrOffsetId()
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
            .toFormatter(Locale.ROOT)
    );
     * and two digit minute of hour. (uuuu-MM-dd'T'HH:mm)
        .optionalStart()
            .appendOffset("+HH:MM", "Z")
    private static final DateFormatter STRICT_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
        SignStyle.NOT_NEGATIVE
            .toFormatter(Locale.ROOT)
    );
                .optionalEnd()
    private static final DateFormatter TIME_NO_MILLIS = new JavaDateFormatter(
        .appendValue(ChronoField.DAY_OF_WEEK)
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 1, 2, SignStyle.NEVER)
                case BASIC_DATE_TIME:
     */
 * KIND, either express or implied.  See the License for the
                case DATE_HOUR_MINUTE_SECOND:
        .toFormatter(Locale.ROOT)
        .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(BASIC_WEEK_DATE_FORMATTER)
        DateTimeFormatter.ISO_LOCAL_DATE.withResolverStyle(ResolverStyle.LENIENT).withLocale(Locale.ROOT)
                case WEEK_DATE_TIME:
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().appendPattern("uuuuDDD")
                    return STRICT_DATE_OPTIONAL_TIME_NANOS;
            .withResolverStyle(ResolverStyle.STRICT)
            return LocalDate.ofEpochDay(0)
            .toFormatter(Locale.ROOT)
    private static final DateTimeFormatter HOUR_MINUTE_SECOND_FORMATTER = new DateTimeFormatterBuilder().append(HOUR_MINUTE_FORMATTER)
            .withResolverStyle(ResolverStyle.STRICT)
        .optionalEnd()
        SignStyle.EXCEEDS_PAD
     * <p>
        new DateTimeFormatterBuilder().append(STRICT_DATE_TIME_NO_MILLIS_FORMATTER)
        "strict_hour_minute_second",
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
        } else if (accessor.isSupported(ChronoField.INSTANT_SECONDS) && accessor.isSupported(NANO_OF_SECOND)) {
    /*
    )
            .append(STRICT_TIME_NO_MILLIS_BASE)
                case WEEKYEAR:
    );
                case STRICT_BASIC_WEEK_DATE_TIME:
     * of hour, two digit second of minute, and time zone offset (HHmmssZ).
    /*
        .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT),
            .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        .append(TIME_ZONE_FORMATTER_NO_COLON)
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
                case EPOCH_SECOND:
     */
     * Returns a basic formatter for a two digit hour of day, two digit minute
            } else if (temporal.isSupported(ChronoField.YEAR_OF_ERA) || temporal.isSupported(ChronoField.YEAR)) {
    /*
    );
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
            .withResolverStyle(ResolverStyle.STRICT)
        .appendValue(MONTH_OF_YEAR, 2, 2, SignStyle.NOT_NEGATIVE)
    )
        .appendLiteral(':')
                case EPOCH_MILLIS:
        2,
                .deprecate(
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                    return DATE_HOUR;
            .withResolverStyle(ResolverStyle.STRICT),
import static java.time.temporal.ChronoField.DAY_OF_WEEK;
    private static final DateTimeFormatter STRICT_BASIC_WEEK_DATE_FORMATTER = new DateTimeFormatterBuilder().parseStrict()
    //
                    return YEAR_MONTH;
        .appendLiteral(':')
                    return STRICT_WEEK_DATE_TIME;
                return LocalDate.ofEpochDay(temporal.getLong(ChronoField.EPOCH_DAY));
            .appendOffset("+HH:MM", "Z")
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        }
 * license agreements. See the NOTICE file distributed with
            .appendLiteral("-W")
     * separated by a 'T' (uuuu-MM-dd'T'HH:mm:ssZ).
                case STRICT_DATE_HOUR_MINUTE_SECOND_MILLIS:
            .appendZoneOrOffsetId()
        4,
        .optionalStart()
            .appendLiteral("T")
     * hour. (HH:mm)
     */
        new DateTimeFormatterBuilder().append(BASIC_WEEK_DATE_FORMATTER)
    private static final DateFormatter STRICT_BASIC_WEEK_DATE_TIME = new JavaDateFormatter(
        .toFormatter(Locale.ROOT)
            .appendLiteral('T')
