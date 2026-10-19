    // ---------------------------------------
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)  
            .append(BASIC_T_TIME_FORMATTER)
        "year",
                }
        }
                    return STRICT_T_TIME;  
        .appendLiteral("W")
            .toFormatter(Locale.ROOT)
        "strict_year_month_day",
            .toFormatter(Locale.ROOT)
            .appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE)
        "hour",  
        new DateTimeFormatterBuilder().appendLiteral('T')
import java.time.temporal.TemporalAdjusters;  
        .appendLiteral('-')
                .toFormatter(Locale.ROOT)
        .withResolverStyle(ResolverStyle.STRICT);
        .toFormatter(Locale.ROOT)
        .append(HOUR_MINUTE_SECOND_FORMATTER)
     * minute. (uuuu-MM-dd'T'HH:mm:ss)
            .withResolverStyle(ResolverStyle.STRICT)
    )  
                    return STRICT_WEEKYEAR_WEEK;  
     */
                int year = getYear(accessor);
     * Returns a formatter for a full ordinal date and time, using a four
        ChronoField.YEAR,  
        .withResolverStyle(ResolverStyle.STRICT);
            .appendLiteral("T")
    // ---------------------------------------
        .withResolverStyle(ResolverStyle.STRICT);
        @Override
                    return T_TIME;
    private static final DateFormatter WEEKYEAR_WEEK = new JavaDateFormatter(
            .toFormatter(Locale.ROOT)
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
                    return DATE_OPTIONAL_TIME;  
            .append(STRICT_TIME_NO_MILLIS_BASE)
            .toFormatter(Locale.ROOT)
        .withResolverStyle(ResolverStyle.STRICT);  
     */
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
                    return BASIC_T_TIME_NO_MILLIS;
                case RFC3339_LENIENT:  
            .optionalEnd()
        2,  
        .optionalStart()
        .optionalStart()  
     */  
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)  
    /**
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
        .optionalStart()
        "date",
        .toFormatter(Locale.ROOT)
    public static ZonedDateTime from(TemporalAccessor accessor, Locale locale, ZoneId defaultZone) {  
     * fraction of second (uuuu-MM-dd'T'HH:mm:ss.SSS).  
        SignStyle.NORMAL
        .appendLiteral('T')
     * A date formatter that formats or parses a date plus an hour without an offset, such as '2011-12-03T01'.
        .toFormatter(Locale.ROOT)  
        "date_hour_minute_second_millis",
            .append(BASIC_TIME_NO_MILLIS_BASE)
    private static final DateTimeFormatter STRICT_DATE_FORMATTER = new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
     */
            if (temporal.isSupported(ChronoField.EPOCH_DAY)) {  
    // these formatters to not have any splitting characters between hours, minutes, seconds, milliseconds  
                return getFirstOfMonth(accessor).atStartOfDay(zoneId);
        .toFormatter(Locale.ROOT)  
            .toFormatter(Locale.ROOT)  
            return of(getLocalDate(accessor, locale), localTime, zoneId);
            .withResolverStyle(ResolverStyle.STRICT),
                case WEEKYEAR:  
            .withResolverStyle(ResolverStyle.STRICT),  
    private static final DateFormatter STRICT_BASIC_WEEK_DATE_TIME_NO_MILLIS = new JavaDateFormatter(  
    /*
                    return YEAR_MONTH_DAY;
        "hour_minute_second",
        new DateTimeFormatterBuilder().appendPattern("yyyyDDD")  
 * Utility of date formatters.
            .appendValue(MONTH_OF_YEAR, 2, 2, SignStyle.NOT_NEGATIVE)
 *
                case ORDINAL_DATE:  
                case STRICT_DATE_OPTIONAL_TIME_NANOS:  
        .toFormatter(Locale.ROOT)  
     * separated by a 'T' (xxxx'W'wwe'T'HHmmss.SSSX).  
            .toFormatter(Locale.ROOT)  
            .withResolverStyle(ResolverStyle.STRICT),  
                case DATE_HOUR_MINUTE_SECOND_FRACTION:
            .append(BASIC_T_TIME_FORMATTER)  
        .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(STRICT_TIME_NO_MILLIS_BASE)
                    return STRICT_ORDINAL_DATE;
        } else if (accessor.isSupported(ChronoField.INSTANT_SECONDS) && accessor.isSupported(NANO_OF_SECOND)) {  
                case BASIC_DATE:  
            .optionalEnd()
        STRICT_BASIC_WEEK_DATE_FORMATTER
        .appendFraction(NANO_OF_SECOND, 1, 9, false)
                    return STRICT_YEAR_MONTH_DAY;
     */
    /*
    // NOTE: this is not a strict formatter to retain the joda time based behaviour, even though it's named like this
    private static final DateTimeFormatter STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER = new DateTimeFormatterBuilder().append(  
        2,
    // ---------------------------------------
        .appendLiteral(':')
            .toFormatter(Locale.ROOT)
    private static final DateTimeFormatter ORDINAL_DATE_FORMATTER = new DateTimeFormatterBuilder().appendValue(
    //
     */
    //  
            .withResolverStyle(ResolverStyle.STRICT),  
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)  
            .appendZoneOrOffsetId()
        10,
     * second (HH:mm:ss.SSS).
            .toFormatter(Locale.ROOT)
        2,  
    public static final WeekFields WEEK_FIELDS_ROOT = WeekFields.of(DayOfWeek.MONDAY, 4);
     * digit week of weekyear, and one digit day of week (xxxx'W'wwe).  
     * hour, two digit second of minute, and three digit fraction of  
    );
     * Returns a ISO 8601 compatible date time formatter and parser.
    //
    // start lenient formatters  
                    return STRICT_DATE_TIME;  
            .append(STRICT_TIME_NO_MILLIS_BASE)  
            .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)  
     */  
            .toFormatter(Locale.ROOT)
    }  
                .optionalEnd()  
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        if (formatName != null && formatName.isCamelCase(input)) {
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 1, 2, SignStyle.NOT_NEGATIVE)  
            .toFormatter(Locale.ROOT)
     */  
     */
        "strict_date_hour_minute",  
        .optionalStart()
        HOUR_OF_DAY,
     */
    );  
     * Returns a basic formatter that combines a basic weekyear date and time,  
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ss.SSSZZ).
        new DateTimeFormatterBuilder().append(ORDINAL_DATE_TIME_NO_MILLIS_BASE)  
            .appendZoneOrOffsetId()
        new DateTimeFormatterBuilder().appendValue(WEEK_FIELDS_ROOT.weekBasedYear())
        if (Strings.hasLength(input)) {  
     */
        2,  
        "ordinal_date_time_no_millis",
        new DateTimeFormatterBuilder().append(BASIC_T_TIME_FORMATTER)  
     * Returns a formatter for a four digit weekyear. (YYYY)
        DateTimeFormatter.ofPattern("HH:mm", Locale.ROOT),  
    );  
        SignStyle.NOT_NEGATIVE  
        STRICT_BASIC_WEEK_DATE_PRINTER,
    /*  
        .appendLiteral('-')  
    private static final DateFormatter BASIC_TIME_NO_MILLIS = new JavaDateFormatter(
     */
    public static ZonedDateTime from(TemporalAccessor accessor, Locale locale) {
            .appendLiteral("T")
        "basic_week_date_time",  
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR)
            .withResolverStyle(ResolverStyle.STRICT)
     * Returns RFC 3339 a popular ISO 8601 profile compatible date time formatter and parser.  
        new DateTimeFormatterBuilder().append(BASIC_DATE_T)
            .toFormatter(Locale.ROOT)
        "strict_basic_week_date",  
        .appendLiteral("-W")
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)  
    private static final DateFormatter ORDINAL_DATE_TIME_NO_MILLIS = new JavaDateFormatter(  
                case HOUR_MINUTE:
    );  
                case WEEK_DATE_TIME:
    private static final DateTimeFormatter STRICT_DATE_PRINTER = new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)  
                case STRICT_DATE_TIME_NO_MILLIS:
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)  
            .appendOffset("+HH:MM", "Z")
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)  
     * time zone offset prefixed by 'T' ('T'HH:mm:ss.SSSZZ).
            .toFormatter(Locale.ROOT)
    private static final DateTimeFormatter BASIC_T_TIME_PRINTER = new DateTimeFormatterBuilder().appendLiteral("T")  
     * Returns a formatter for a two digit hour of day, two digit minute of  
     */
    )
                    return BASIC_WEEK_DATE;  
     * (uuuu-MM-dd'T'HH:mm:ss.SSSZZ).
    static final TemporalQuery<LocalDate> LOCAL_DATE_QUERY = new TemporalQuery<LocalDate>() {  
            .append(TIME_ZONE_FORMATTER_NO_COLON)  
                    return STRICT_HOUR_MINUTE_SECOND_MILLIS;  
     * of year, and two digit day of month (uuuu-MM-dd).
    private static LocalDate getFirstOfMonth(TemporalAccessor accessor) {
    private static final DateFormatter STRICT_DATE_TIME = new JavaDateFormatter(  
    /*
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
                case STRICT_HOUR_MINUTE_SECOND:
     * Returns a formatter for a two digit hour of day, two digit minute of  
            .withResolverStyle(ResolverStyle.STRICT)
}
     * Returns a formatter for a full ordinal date and time without millis,  
        DateTimeFormatter.ISO_LOCAL_DATE.withResolverStyle(ResolverStyle.LENIENT).withLocale(Locale.ROOT)  
     * separated by a 'T' (xxxx'W'wwe'T'HHmmssX).
            .appendZoneOrOffsetId()
        .toFormatter(Locale.ROOT)
            .append(HOUR_MINUTE_SECOND_FRACTION_FORMATTER)  
            .withResolverStyle(ResolverStyle.STRICT),
    //
     * A strict formatter that formats or parses a hour, minute and second, such as '09:43:25'.
        .appendFraction(NANO_OF_SECOND, 1, 9, true)  
    )
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
                    return ORDINAL_DATE_TIME;  
        STRICT_YEAR_MONTH_DAY_FORMATTER  
     * - If a zoned date time is passed, it is returned
        "basic_date",
                case BASIC_WEEK_DATE_TIME:
        .optionalStart()
        .optionalEnd()  
    );  
public class DateFormatters {
    /*  
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm", Locale.ROOT),
            .optionalEnd()
            .toFormatter(Locale.ROOT)  
        new DateTimeFormatterBuilder().append(BASIC_TIME_NO_MILLIS_BASE)
        .optionalStart()
    );
        .withResolverStyle(ResolverStyle.STRICT);  
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateFormatter WEEK_YEAR = new JavaDateFormatter(  
            .withResolverStyle(ResolverStyle.STRICT),
            .optionalEnd()
     * a date formatter with optional time, being very lenient, format is  
/*  
        .appendValue(ChronoField.DAY_OF_WEEK)
            .withResolverStyle(ResolverStyle.STRICT)
            .withResolverStyle(ResolverStyle.STRICT),
            .withZone(ZoneOffset.UTC),
        .appendLiteral('-')
            .withResolverStyle(ResolverStyle.STRICT)
     * Returns a formatter that combines a full weekyear date and time,  
        .toFormatter(Locale.ROOT)
            .optionalStart()
        .appendValue(DAY_OF_YEAR, 3)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .optionalStart()
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)  
        "strict_date_optional_time",  
        .withResolverStyle(ResolverStyle.STRICT);
        .optionalEnd()  
        public String toString() {
        new DateTimeFormatterBuilder().append(STRICT_TIME_NO_MILLIS_BASE)  
            .optionalEnd()
        .toFormatter(Locale.ROOT)  
            .optionalEnd()  
    private static final DateTimeFormatter BASIC_DATE_T = new DateTimeFormatterBuilder().append(BASIC_YEAR_MONTH_DAY_FORMATTER)  
        .appendLiteral("T")
    /*  
    private static final DateFormatter T_TIME = new JavaDateFormatter(  
     * digit week of weekyear, and one digit day of week (YYYY'W'wwe).
        STRICT_DATE_OPTIONAL_TIME_PRINTER,  
            .toFormatter(Locale.ROOT)
     * Returns a formatter that combines a full date and two digit hour of
        4,
     * Returns a formatter for a full ordinal date, using a four
        new DateTimeFormatterBuilder().append(STRICT_TIME_FORMATTER_BASE)  
            .toFormatter(Locale.ROOT)  
            .append(TIME_ZONE_FORMATTER_NO_COLON)  
     * by 'T' ('T'HH:mm:ssZZ).
    /*
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
    private static final DateFormatter WEEK_DATE_TIME = new JavaDateFormatter(
    private static final DateFormatter WEEK_DATE = new JavaDateFormatter("week_date", ISO_WEEK_DATE, WEEK_DATE_FORMATTER);
     * two digit minute of hour, and two digit second of
        .appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)  
                .appendFraction(NANO_OF_SECOND, 1, 9, true)  
        "basic_t_time",
        STRICT_DATE_PRINTER,
            .appendLiteral("T")  
            .appendZoneOrOffsetId()  
        new DateTimeFormatterBuilder().appendLiteral('T')  
    //
        2,
                    return STRICT_HOUR;
        new DateTimeFormatterBuilder().append(HOUR_MINUTE_FORMATTER)
            .withResolverStyle(ResolverStyle.STRICT)
     * week of weekyear, and one digit day of week (xxxx-'W'ww-e).  
    private static final DateTimeFormatter STRICT_WEEKYEAR_WEEK_FORMATTER = new DateTimeFormatterBuilder().appendValue(
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateFormatter BASIC_DATE = new JavaDateFormatter(
        .optionalStart()
        .appendValue(WEEK_FIELDS_ROOT.weekOfWeekBasedYear(), 2, 2, SignStyle.NOT_NEGATIVE)  
        .appendLiteral('T')
                case WEEKYEAR_WEEK_DAY:
        .appendLiteral(':')
            .toFormatter(Locale.ROOT)
            .appendOffset("+HH:MM", "Z")  
     * when YearOfEra was used instead of Year.  
            .append(BASIC_T_TIME_FORMATTER)
        ChronoField.YEAR,
                    return LocalDate.of(year, temporal.get(ChronoField.MONTH_OF_YEAR), temporal.get(ChronoField.DAY_OF_MONTH));
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .append(STRICT_TIME_PRINTER)
                case EPOCH_MICROS:
    private static final DateTimeFormatter HOUR_MINUTE_FORMATTER = new DateTimeFormatterBuilder().appendValue(  
     * Returns a basic formatter for a two digit hour of day, two digit minute
            .withResolverStyle(ResolverStyle.STRICT)  
    /*
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_NO_MILLIS_BASE)  
            .withResolverStyle(ResolverStyle.STRICT)
        .appendValue(ChronoField.DAY_OF_WEEK)  
            .appendOffset("+HH:MM", "Z")
            return (ZonedDateTime) accessor;
    private static final DateFormatter ORDINAL_DATE_TIME = new JavaDateFormatter(
     * - If no timezone is found, ZoneOffset.UTC is used  
     * Returns a basic formatter that combines a basic weekyear date and time,
            .appendValue(WEEK_FIELDS_ROOT.weekOfWeekBasedYear())
            .toFormatter(Locale.ROOT)
    private static final DateFormatter STRICT_BASIC_WEEK_DATE_TIME = new JavaDateFormatter(
        .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
        STRICT_YEAR_MONTH_DAY_FORMATTER  
            .appendZoneOrOffsetId()  
    private static final DateFormatter HOUR_MINUTE_SECOND_FRACTION = new JavaDateFormatter(  
        "strict_hour_minute_second",
        "iso8601",
        .appendLiteral(':')
        .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
                case ORDINAL_DATE_TIME:
     * hour, two digit second of minute, three digit fraction of second, and  
     * hour, two digit second of minute, andtime zone offset (HH:mm:ssZZ).
        .toFormatter(Locale.ROOT)
    private static final DateTimeFormatter STRICT_HOUR_MINUTE_SECOND_MILLIS_FORMATTER = new DateTimeFormatterBuilder().append(
            .toFormatter(Locale.ROOT)
            .appendZoneOrOffsetId()
            return localDateFromWeekBasedDate(accessor, locale);  
            .toFormatter(Locale.ROOT)  
    // Hence a lazy initialization.
        4,  
        SignStyle.EXCEEDS_PAD  
                case STRICT_WEEK_DATE_TIME_NO_MILLIS:
            .withResolverStyle(ResolverStyle.STRICT)
            .appendLiteral("-")  
     */
                    return BASIC_TIME;
    );
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        .toFormatter(Locale.ROOT)  
    }
     */
        } else if (accessor.isSupported(ChronoField.YEAR) || accessor.isSupported(ChronoField.YEAR_OF_ERA)) {  
        .appendFraction(NANO_OF_SECOND, 3, 3, true)  
        .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
            .append(T_TIME_NO_MILLIS_FORMATTER)
 *     http://www.apache.org/licenses/LICENSE-2.0
        .optionalEnd()  
        .appendLiteral('-')
        }
            .withResolverStyle(ResolverStyle.STRICT),
        .withResolverStyle(ResolverStyle.STRICT);
    // ---------------------------------------
    //
        .appendLiteral(':')  
            .toFormatter(Locale.ROOT)
                .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
            .append(STRICT_TIME_FORMATTER_BASE)
    /*
        "strict_t_time_no_millis",
import org.opensearch.common.util.LazyInitializable;  
        .withResolverStyle(ResolverStyle.STRICT);  
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)  
            .appendOffset("+HH:MM", "Z")  
                    return BASIC_TIME_NO_MILLIS;  
    private static final DateFormatter STRICT_DATE_HOUR = new JavaDateFormatter(  
    /*
        .appendLiteral(',')  
        .appendLiteral("W")
            .appendZoneOrOffsetId()
        STRICT_HOUR_MINUTE_SECOND_MILLIS_FORMATTER  
            .withResolverStyle(ResolverStyle.STRICT)
                case BASIC_TIME_NO_MILLIS:
    // ---------------------------------------  
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm", Locale.ROOT)
                case STRICT_DATE:
        return 1970;
            .withResolverStyle(ResolverStyle.STRICT),
                .with(weekFields.weekOfWeekBasedYear(), accessor.get(weekFields.weekOfWeekBasedYear()))  
        new DateTimeFormatterBuilder().appendPattern("uuuuDDD")
                case BASIC_ORDINAL_DATE:  
                    return BASIC_T_TIME;
            .optionalStart()
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
                    return STRICT_DATE_HOUR;
        .withResolverStyle(ResolverStyle.STRICT);
import java.time.ZonedDateTime;
     * @return The converted zoned date time
     * A strict formatter that formats or parses a year and a month, such as '2011-12'.
     */
            .optionalStart()
        IsoFields.WEEK_BASED_YEAR,  
    );  
    /*  
            .optionalEnd()
            } else {
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
        .append(BASIC_TIME_FORMATTER)  
    private static final DateFormatter STRICT_YEAR = new JavaDateFormatter(  
     * two digit minute of hour, and two digit second of  
        .withResolverStyle(ResolverStyle.STRICT);
     *   of the new year is chosen (reataining BWC to joda time)
        .optionalEnd()  
                    return DATE_TIME;
     * minute. (uuuu-MM-dd'T'HH:mm:ss)
                .appendOffsetId()
            .toFormatter(Locale.ROOT)  
    );  
            .withResolverStyle(ResolverStyle.STRICT),
                case YEAR_MONTH:
    )  
    );
    /*
        .toFormatter(Locale.ROOT)  
        .appendValue(DAY_OF_YEAR, 1, 3, SignStyle.NOT_NEGATIVE)  
        10,
                    return BASIC_ORDINAL_DATE_TIME_NO_MILLIS;
                    return DATE_HOUR_MINUTE_SECOND_MILLIS;
     * hour, two digit second of minute, and time zone offset (HH:mm:ssZZ).
     */
            .withResolverStyle(ResolverStyle.STRICT),  
     * weekyear, and one digit day of week. (xxxx-'W'ww-e)  
            .appendOffset("+HH:MM", "Z")
        .appendLiteral(':')
        HOUR_OF_DAY,
            .optionalStart()  
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT),  
            .toFormatter(Locale.ROOT)
        .appendLiteral("-W")  
     * This method prevents exceptions by querying the accessor for certain capabilities
     * week of weekyear, and one digit day of week (xxxx-'W'ww-e).
        new DateTimeFormatterBuilder().append(BASIC_TIME_NO_MILLIS_BASE)  
     * two digit minute of hour, two digit second of minute, and three digit
    //
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)  
        STRICT_DATE_OPTIONAL_TIME_FORMATTER_WITH_NANOS
            .withResolverStyle(ResolverStyle.STRICT),  
     * Returns a formatter for a full ordinal date and time, using a four
        "weekyear_week",  
                case STRICT_YEAR_MONTH_DAY:
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
    );
            .appendValue(HOUR_OF_DAY, 1, 2, SignStyle.NOT_NEGATIVE)  
        .withResolverStyle(ResolverStyle.STRICT);
        STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER,
     * Returns a formatter that combines a full date and time, separated by a 'T'
        .appendLiteral(':')
        .optionalEnd()
            .withResolverStyle(ResolverStyle.STRICT),
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)  
        .appendValue(IsoFields.WEEK_BASED_YEAR, 4)
        // the first two cases are the most common, so this allows us to exit early when parsing dates  
        .appendOffset("+HH:MM", "Z")  
    private static final DateTimeFormatter ORDINAL_DATE_TIME_FORMATTER_BASE = new DateTimeFormatterBuilder().append(ORDINAL_DATE_FORMATTER)
        STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER,
     * Returns a formatter for a two digit hour of day, two digit minute of
            .append(BASIC_TIME_NO_MILLIS_BASE)  
    private static final DateFormatter DATE_HOUR_MINUTE_SECOND_FRACTION = new JavaDateFormatter(  
            .toFormatter(Locale.ROOT)
    private static final DateTimeFormatter STRICT_ORDINAL_DATE_FORMATTER = new DateTimeFormatterBuilder().parseCaseInsensitive()
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT)  
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)  
     */  
    private static final DateFormatter STRICT_BASIC_WEEK_DATE = new JavaDateFormatter(
                    return BASIC_DATE_TIME_NO_MILLIS;
            }  
            .append(TIME_PREFIX)
     */
    /*
            .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)  
        .optionalStart()  
            .withResolverStyle(ResolverStyle.STRICT)  
 * KIND, either express or implied.  See the License for the
    );  
    // start strict formatters  
        }
    /*  
        public LocalDate queryFrom(TemporalAccessor temporal) {
            return localDate.atStartOfDay(zoneId);  
        new DateTimeFormatterBuilder().append(DATE_TIME_PREFIX)
        .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
     * This action assumes that we can reliably fall back to some defaults if not all parts of a
     */  
                case HOUR_MINUTE_SECOND_FRACTION:
     * digit year and three digit dayOfYear (uuuuDDD).  
        new DateTimeFormatterBuilder().appendLiteral("T")  
    private static final DateFormatter STRICT_HOUR_MINUTE_SECOND = new JavaDateFormatter(
    );
    private static final DateFormatter STRICT_T_TIME_NO_MILLIS = new JavaDateFormatter(  
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)  
        STRICT_DATE_OPTIONAL_TIME_FORMATTER
            .toFormatter(Locale.ROOT)
        STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER,
        .appendValue(ChronoField.DAY_OF_WEEK)  
        new DateTimeFormatterBuilder().appendPattern("uuuuDDD")
        .withResolverStyle(ResolverStyle.STRICT);
            .withResolverStyle(ResolverStyle.STRICT),
            .withResolverStyle(ResolverStyle.STRICT),
    );  
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)  
        new DateTimeFormatterBuilder().append(WEEK_DATE_FORMATTER)  
     * Returns a generic ISO datetime parser where the date is mandatory and the time is optional with nanosecond resolution.
        .appendLiteral('T')  
            .toFormatter(Locale.ROOT)  
    private static final DateFormatter STRICT_DATE_HOUR_MINUTE_SECOND_MILLIS = new JavaDateFormatter(  
            .append(BASIC_TIME_NO_MILLIS_BASE)  
            // this one here is lenient as well to retain joda time based bwc compatibility  
     * weekyear. (xxxx-'W'ww)  
            .appendValue(MONTH_OF_YEAR, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateTimeFormatter STRICT_ORDINAL_DATE_TIME_FORMATTER_BASE = new DateTimeFormatterBuilder().appendValue(  
                    return DATE_HOUR;
        new DateTimeFormatterBuilder().append(BASIC_TIME_FORMATTER)
     * Returns a formatter for a two digit hour of day, two digit minute of
            return accessor.get(ChronoField.YEAR);  
    );
            .toFormatter(Locale.ROOT)  
            .withResolverStyle(ResolverStyle.STRICT)
     * Returns a formatter that combines a full date and time without millis,  
            .withResolverStyle(ResolverStyle.STRICT),
        "basic_t_time_no_millis",
        .optionalEnd()
     * Returns a basic formatter that combines a basic date and time, separated
 * GitHub history for details.
        ChronoField.YEAR,
     */
    )
            .withResolverStyle(ResolverStyle.STRICT)
        .optionalStart()
        .optionalStart()
        WEEK_FIELDS_ROOT.weekBasedYear(),  
    private static final DateTimeFormatter STRICT_TIME_PRINTER = new DateTimeFormatterBuilder().appendValue(
        new DateTimeFormatterBuilder().append(TIME_PREFIX)
     * Returns a generic ISO datetime parser where the date is mandatory and the time is optional.  
            zoneId = defaultZone;
            .appendLiteral("T")
            .toFormatter(Locale.ROOT)  
            .toFormatter(Locale.ROOT)
        .withResolverStyle(ResolverStyle.STRICT);  
            .toFormatter(Locale.ROOT)  
    );
     * Returns a formatter for a two digit hour of day, two digit minute of
            .withResolverStyle(ResolverStyle.STRICT)
        new DateTimeFormatterBuilder().append(T_TIME_NO_MILLIS_FORMATTER)
            .append(STRICT_TIME_NO_MILLIS_BASE)
    private static final DateFormatter DATE_TIME = new JavaDateFormatter(
        .appendLiteral(':')
        HOUR_OF_DAY,
    );
import java.time.ZoneId;
    private static final DateTimeFormatter BASIC_DATE_TIME_PRINTER = new DateTimeFormatterBuilder().append(BASIC_YEAR_MONTH_DAY_FORMATTER)
        .toFormatter(Locale.ROOT)  
            .toFormatter(Locale.ROOT)  
        "strict_date_time_no_millis",
import static java.time.temporal.ChronoField.DAY_OF_YEAR;
        "basic_date_time_no_millis",
    );
            .withResolverStyle(ResolverStyle.STRICT),  
    private static final DateFormatter STRICT_HOUR = new JavaDateFormatter("strict_hour", DateTimeFormatter.ofPattern("HH", Locale.ROOT));
        .withResolverStyle(ResolverStyle.STRICT);
    private static final DateFormatter WEEKYEAR_WEEK_DAY = new JavaDateFormatter(
            .append(TIME_ZONE_FORMATTER_NO_COLON)  
    private static final DateTimeFormatter STRICT_ORDINAL_DATE_TIME_NO_MILLIS_BASE = new DateTimeFormatterBuilder().appendValue(
            .appendValue(DAY_OF_MONTH)
     * - If an iso based weekyear is found, but not week is specified, the first monday
    /*  
            .toFormatter(Locale.ROOT)
        .optionalStart()
        }  
            .withResolverStyle(ResolverStyle.STRICT),  
        .appendPattern("HH:mm")  
        SignStyle.EXCEEDS_PAD
        .optionalStart()
            .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)
    private static final DateTimeFormatter STRICT_DATE_OPTIONAL_TIME_FORMATTER = new DateTimeFormatterBuilder().append(
 * this file be licensed under the Apache-2.0 license or a
        .toFormatter(Locale.ROOT)
     */
     * digit year and three digit dayOfYear (uuuu-DDD'T'HH:mm:ss.SSSZZ).
                    return T_TIME_NO_MILLIS;
    private static final DateTimeFormatter HOUR_MINUTE_SECOND_MILLIS_FORMATTER = new DateTimeFormatterBuilder().appendValue(
        .withResolverStyle(ResolverStyle.STRICT);
            .append(TIME_ZONE_FORMATTER_NO_COLON)  
        STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER,
                .appendLiteral('T')
        .appendLiteral('-')
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateFormatter T_TIME_NO_MILLIS = new JavaDateFormatter(  
     */  
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
        .appendLiteral('T')
        .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
    //
    private static final DateFormatter STRICT_DATE_HOUR_MINUTE = new JavaDateFormatter(
 * @opensearch.internal  
            .withResolverStyle(ResolverStyle.STRICT),
     */
            .appendOffset("+HH:MM", "Z")
            .toFormatter(Locale.ROOT)  
    )
     *   of the day is used
    /*
        new DateTimeFormatterBuilder().append(BASIC_DATE_T)
     */
     */
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_FORMATTER_BASE)
    );
            .withResolverStyle(ResolverStyle.STRICT),  
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
        STRICT_DATE_OPTIONAL_TIME_PRINTER,
            .toFormatter(Locale.ROOT)
     * Returns a formatter that combines a full date, two digit hour of day,  
    /*  
            .append(BASIC_TIME_NO_MILLIS_BASE)
        .optionalEnd()
    /**
     */  
        "t_time_no_millis",
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
            .appendZoneOrOffsetId()
        "strict_weekyear_week_day",  
        "hour_minute_second_millis",
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)  
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)  
        if (accessor.isSupported(ChronoField.YEAR_OF_ERA)) {
    /*
                return Year.of(year).atDay(1).atStartOfDay(zoneId);
                .optionalStart()  
            .optionalStart()
                    msg,
            .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
        .optionalStart()
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_NO_MILLIS_BASE)
        .appendLiteral('T')  
        .optionalStart()
            .appendValue(WEEK_FIELDS_ROOT.weekOfWeekBasedYear())
            // missing year, falling back to the epoch and then filling
        2,  
     * Returns a formatter for a full ordinal date and time without millis,
                case STRICT_HOUR_MINUTE:
     * Returns a formatter for a four digit weekyear, two digit week of
        new DateTimeFormatterBuilder().append(DATE_TIME_PREFIX)  
    /*
            }
        .appendValue(DAY_OF_YEAR, 3, 3, SignStyle.NOT_NEGATIVE)
        STRICT_DATE_OPTIONAL_TIME_PRINTER,
    private static final DateFormatter DATE = new JavaDateFormatter(
     * offset prefixed by 'T' ('T'HHmmss.SSSZ).
            .withResolverStyle(ResolverStyle.STRICT),  
        new DateTimeFormatterBuilder().append(STRICT_TIME_PRINTER)
    );
        "strict_hour_minute",
        .optionalStart()  
        .appendLiteral('T')  
                    return HOUR_MINUTE_SECOND_FRACTION;  
        new DateTimeFormatterBuilder().appendLiteral("T")
                    return TIME;
        2,
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
                    return BASIC_WEEK_DATE_TIME_NO_MILLIS;
            .appendLiteral("T")  
            .withResolverStyle(ResolverStyle.STRICT),
     * A strict formatter that formats or parses a year, such as '2011'.
        .withResolverStyle(ResolverStyle.STRICT);
     * - If an accessor only containing of seconds and nanos is found (like epoch_millis/second)  
            .append(BASIC_TIME_NO_MILLIS_BASE)
            .appendOffset("+HH:MM", "Z")
    );
    private static final DateTimeFormatter STRICT_DATE_OPTIONAL_TIME_PRINTER_NANOS = new DateTimeFormatterBuilder().append(
        .withResolverStyle(ResolverStyle.STRICT);
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            .appendLiteral('T')
        } catch (IllegalArgumentException e) {  
            .appendZoneOrOffsetId()  
        STRICT_HOUR_MINUTE_SECOND_FORMATTER  
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)  
    private static final DateFormatter YEAR_MONTH_DAY = new JavaDateFormatter(
    private static final DateFormatter STRICT_TIME = new JavaDateFormatter(  
            .appendOffset("+HH:MM", "Z")  
     */
            .appendOffset("+HH:MM", "Z")
    ).appendLiteral('T').append(STRICT_HOUR_MINUTE_SECOND_FORMATTER).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);  
        HOUR_OF_DAY,
            .withResolverStyle(ResolverStyle.STRICT),
        () -> DeprecationLogger.getLogger(FormatNames.class)
    );
    private static final DateFormatter BASIC_T_TIME_NO_MILLIS = new JavaDateFormatter(  
            .optionalStart()
            .toFormatter(Locale.ROOT)
        "strict_t_time",
            .toFormatter(Locale.ROOT)  
        2,
            .optionalEnd()
            .toFormatter(Locale.ROOT)
import java.time.temporal.TemporalAccessor;
    private static final DateFormatter STRICT_WEEK_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
            .withResolverStyle(ResolverStyle.STRICT)
        .appendValue(DAY_OF_MONTH, 2, 2, SignStyle.NOT_NEGATIVE)
            .withResolverStyle(ResolverStyle.STRICT)
            .toFormatter(Locale.ROOT)  
        "date_hour_minute",
        .append(HOUR_MINUTE_FORMATTER)  
     */
        STRICT_YEAR_MONTH_DAY_FORMATTER  
     * hour, two digit second of minute, three digit fraction of second, and  
     */  
    }
    private static final DateFormatter TIME_NO_MILLIS = new JavaDateFormatter(  
            .appendLiteral("-")
        .optionalStart()  
            .appendLiteral("-W")  
    // only the formatter, nothing optional here
     */
        .optionalEnd()
                    return RFC3339_LENIENT_DATE_FORMATTER;
        new DateTimeFormatterBuilder().append(BASIC_TIME_FORMATTER)  
            .toFormatter(Locale.ROOT)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
     * month of year, and two digit day of month (uuuuMMdd).
            .toFormatter(Locale.ROOT)  
    );  
        HOUR_MINUTE_SECOND_MILLIS_FORMATTER  
    );
    );  
     * and two digit minute of hour. (uuuu-MM-dd'T'HH:mm)
    )
import java.time.LocalTime;  
        .append(HOUR_MINUTE_FORMATTER)  
    private static final DateFormatter STRICT_WEEKYEAR_WEEK_DAY = new JavaDateFormatter(
     * ('T'HHmmssZ).
    /*
            // this one here is lenient as well to retain joda time based bwc compatibility
        STRICT_HOUR_MINUTE_SECOND_FORMATTER  
                case HOUR_MINUTE_SECOND:  
            .toFormatter(Locale.ROOT)
        .appendLiteral(':')  
import java.time.temporal.ChronoField;  
        new DateTimeFormatterBuilder().append(ORDINAL_DATE_TIME_FORMATTER_BASE)
/**  
            .withResolverStyle(ResolverStyle.STRICT),  
        .appendLiteral('-')
        "basic_week_date",
    /**
            .appendOffset("+HH:MM", "Z")
    );  
            .appendZoneOrOffsetId()  
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateFormatter ORDINAL_DATE = new JavaDateFormatter("ordinal_date", ORDINAL_DATE_PRINTER, ORDINAL_DATE_FORMATTER);
    // ---------------------------------------
        2,  
                case STRICT_DATE_HOUR_MINUTE_SECOND_FRACTION:  
                return LocalDate.of(year, accessor.get(MONTH_OF_YEAR), 1);  
        "date_hour_minute_second",
                    return EpochTime.SECONDS_FORMATTER;
                case STRICT_WEEKYEAR_WEEK:
                    return STRICT_DATE_HOUR_MINUTE_SECOND;
                case DATE_OPTIONAL_TIME:
            .appendLiteral("T")  
     * Returns a basic formatter that combines a basic date and time without millis,  
            .toFormatter(Locale.ROOT)
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        new DateTimeFormatterBuilder().appendValue(HOUR_OF_DAY, 1, 2, SignStyle.NOT_NEGATIVE)
            if (accessor.isSupported(DAY_OF_MONTH)) {  
    );  
     * Returns a formatter that combines a full date and time without millis, but with a timezone that can be optional  
        boolean isLocalTimeSet = localTime != null;
    private static final DateTimeFormatter STRICT_DATE_TIME_NO_MILLIS_FORMATTER = new DateTimeFormatterBuilder().append(
            .withResolverStyle(ResolverStyle.STRICT)
     * uuuu-MM-dd'T'HH:mm:ss.SSSZ
            .append(STRICT_TIME_NO_MILLIS_BASE)
    private static final DateTimeFormatter HOUR_MINUTE_SECOND_FORMATTER = new DateTimeFormatterBuilder().append(HOUR_MINUTE_FORMATTER)
    /*
        .withResolverStyle(ResolverStyle.STRICT);
            .toFormatter(Locale.ROOT)
     */
        new DateTimeFormatterBuilder().appendLiteral("T")
        1,  
        4,
     * existing joda time ISO date formatter
            .appendZoneOrOffsetId()
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        if (isLocalDateSet && isLocalTimeSet) {
                    return STRICT_TIME;
    );
                case BASIC_TIME:  
            .optionalEnd()
        SignStyle.EXCEEDS_PAD  
        2,  
    /*
    );
                case DATE_HOUR_MINUTE_SECOND_MILLIS:  
            .append(BASIC_TIME_NO_MILLIS_BASE)  
                    return STRICT_BASIC_WEEK_DATE_TIME_NO_MILLIS;  
            .appendOffset("+HH:MM", "Z")
    private static final DateFormatter DATE_HOUR_MINUTE_SECOND = new JavaDateFormatter(  
    private static final DateTimeFormatter TIME_ZONE_FORMATTER_NO_COLON = new DateTimeFormatterBuilder().appendOffset("+HHmm", "Z")
    );
            .append(BASIC_T_TIME_FORMATTER)  
        WeekFields weekFields = WeekFields.of(locale);
            .toFormatter(Locale.ROOT)  
        "year_month",  
        "basic_date_time",  
            .withResolverStyle(ResolverStyle.STRICT)
            .withResolverStyle(ResolverStyle.STRICT),  
            .append(BASIC_T_TIME_PRINTER)
    /*  
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)  
            .toFormatter(Locale.ROOT)
        .withResolverStyle(ResolverStyle.STRICT);
                if (temporal.isSupported(ChronoField.MONTH_OF_YEAR) && temporal.isSupported(ChronoField.DAY_OF_MONTH)) {
            .appendOffset("+HH:MM", "Z")
        new OpenSearchDateTimeFormatter(STRICT_DATE_OPTIONAL_TIME_PRINTER),  
    private static final DateFormatter BASIC_ORDINAL_DATE = new JavaDateFormatter(
        "date_optional_time",
            .appendZoneOrOffsetId()
    private static final DateFormatter YEAR_MONTH = new JavaDateFormatter(
     */
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
        .appendLiteral('T')  
            .withResolverStyle(ResolverStyle.STRICT),  
            .withResolverStyle(ResolverStyle.STRICT),  
    )
        DateTimeFormatter.ISO_LOCAL_DATE.withResolverStyle(ResolverStyle.STRICT),  
        .append(HOUR_MINUTE_FORMATTER)  
            .appendFraction(NANO_OF_SECOND, 1, 9, false)
     * (uuuu-MM-dd'T'HH:mm:ss.SSSZZ).
            .appendLiteral(':')  
            .withResolverStyle(ResolverStyle.STRICT),  
            .appendLiteral("T")
            .optionalEnd()  
            .withResolverStyle(ResolverStyle.STRICT),
     * Returns a formatter for a two digit hour of day, two digit minute of
        STRICT_BASIC_WEEK_DATE_PRINTER,
                    return STRICT_DATE_TIME_NO_MILLIS;
 * compatible open source license.
    /*
            .append(TIME_ZONE_FORMATTER_NO_COLON)  
     * separated by a 'T' (uuuu-MM-dd'T'HH:mm:ssZ).
    )
     * second (HH:mm:ss.SSS).
                );
        "strict_time_no_millis",
    );
        .toFormatter(Locale.ROOT)  
    private static final DateFormatter DATE_HOUR_MINUTE_SECOND_MILLIS = new JavaDateFormatter(
        "strict_week_date_time_no_millis",
    /*
            .append(BASIC_TIME_NO_MILLIS_BASE)
        // convert to a zoned date time! If not, we have to extend the above methods  
            .append(STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER)
            .withResolverStyle(ResolverStyle.STRICT)
    /*
                case T_TIME_NO_MILLIS:  
            .withResolverStyle(ResolverStyle.STRICT)  
        "strict_ordinal_date_time",
                case STRICT_WEEK_DATE_TIME:
    );
        .withResolverStyle(ResolverStyle.STRICT);  
        .toFormatter(Locale.ROOT)
    private static final DateFormatter STRICT_YEAR_MONTH_DAY = new JavaDateFormatter(
            .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)  
import org.opensearch.core.common.Strings;
            .withResolverStyle(ResolverStyle.STRICT),
    private static final DateFormatter HOUR_MINUTE_SECOND_MILLIS = new JavaDateFormatter(  
     * separated by a 'T' (uuuuMMdd'T'HHmmssZ).
            return accessor.get(ChronoField.YEAR_OF_ERA);  
import org.opensearch.common.SuppressForbidden;
    private static final DateFormatter STRICT_HOUR_MINUTE = new JavaDateFormatter(
    private static final DateFormatter ISO_8601 = new JavaDateFormatter(  
    /*
        10,
        new DateTimeFormatterBuilder().append(WEEK_DATE_FORMATTER)  
    private static final DateFormatter STRICT_WEEKYEAR_WEEK = new JavaDateFormatter("strict_weekyear_week", STRICT_WEEKYEAR_WEEK_FORMATTER);
     */  
            .optionalEnd()
    /*  
        .optionalEnd()
        }
     */  
    private static final DateFormatter STRICT_DATE_HOUR_MINUTE_SECOND = new JavaDateFormatter(
        HOUR_OF_DAY,
     * Returns a formatter for a two digit hour of day and two digit minute of
                case STRICT_T_TIME_NO_MILLIS:
                case STRICT_DATE_OPTIONAL_TIME:
        "ordinal_date_time",
        .optionalEnd()
        new DateTimeFormatterBuilder().append(STRICT_DATE_TIME_NO_MILLIS_FORMATTER)  
        .withResolverStyle(ResolverStyle.STRICT);
        .optionalStart()
    private static final DateTimeFormatter STRICT_TIME_FORMATTER_BASE = new DateTimeFormatterBuilder().appendValue(  
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss", Locale.ROOT)  
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
            .toFormatter(Locale.ROOT)  
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            .appendZoneOrOffsetId()  
            .toFormatter(Locale.ROOT)  
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        .optionalEnd()
                case YEAR:  
            if (accessor.isSupported(MONTH_OF_YEAR)) {
        .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)  
                    return STRICT_T_TIME_NO_MILLIS;
            .appendOffset("+HH:MM", "Z")  
    private static final DateTimeFormatter STRICT_HOUR_MINUTE_SECOND_FORMATTER = new DateTimeFormatterBuilder().appendValue(
    );
import java.time.format.ResolverStyle;
        ChronoField.YEAR,
            .append(TIME_ZONE_FORMATTER_NO_COLON)  
            .append(HOUR_MINUTE_FORMATTER)
     */  
        .toFormatter(Locale.ROOT)
     * This is not fully compatible to the existing spec, which would require far more edge cases, but merely compatible with the  
            .toFormatter(Locale.ROOT)
 */  
    /*
 * software distributed under the License is distributed on an
        .optionalEnd()
            .withResolverStyle(ResolverStyle.STRICT),
    private static final DateTimeFormatter ISO_WEEK_DATE = new DateTimeFormatterBuilder().parseCaseInsensitive()
            deprecationLogger.getOrCompute()
 * not use this file except in compliance with the License.
    // BEGIN basic time formatters
                case STRICT_HOUR:  
                    return STRICT_ORDINAL_DATE_TIME_NO_MILLIS;  
                    return STRICT_HOUR_MINUTE;  
        "strict_date_hour_minute_second_fraction",  
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)  
        new DateTimeFormatterBuilder().appendLiteral('T')
                    return BASIC_DATE;
        .appendValue(IsoFields.WEEK_BASED_YEAR, 4)  
        4,  
        DateTimeFormatter.ofPattern("uuuuDDD", Locale.ROOT)
     */
    private static final DateFormatter BASIC_WEEK_DATE_TIME_NO_MILLIS = new JavaDateFormatter(  
    /**
    );  
    /*  
    private static final LazyInitializable<DeprecationLogger, RuntimeException> deprecationLogger = new LazyInitializable(  
        .optionalEnd()
            .toFormatter(Locale.ROOT)
     */
import java.time.temporal.TemporalQueries;
        new DateTimeFormatterBuilder().append(BASIC_T_TIME_FORMATTER).append(TIME_ZONE_FORMATTER_NO_COLON).toFormatter(Locale.ROOT)
            .append(BASIC_TIME_NO_MILLIS_BASE)
    /*
            .toFormatter(Locale.ROOT)  
     * - If no month of the year is found, the first day of the year is used  
        .toFormatter(Locale.ROOT)
     * Convert a temporal accessor to a zoned date time object - as performant as possible.
 */
        .appendLiteral(':')
        .withResolverStyle(ResolverStyle.STRICT);
     * Returns a formatter for a full date as four digit year, two digit month
            .toFormatter(Locale.ROOT)  
    private static final DateFormatter TIME = new JavaDateFormatter(
     * A strict date formatter that formats or parses a date without an offset, such as '2011-12-03'.
    /*
                    return DATE_HOUR_MINUTE_SECOND_FRACTION;
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 4, SignStyle.NORMAL)  
            .toFormatter(Locale.ROOT)
    /*
            .optionalEnd()  
                // strict date formats here, must be at least 4 digits for year and two for months and two for day
        new DateTimeFormatterBuilder().append(DATE_TIME_FORMATTER)
    private static final DateFormatter STRICT_ORDINAL_DATE_TIME = new JavaDateFormatter(
        new DateTimeFormatterBuilder().appendLiteral('T')
            .appendLiteral("T")  
    );  
            .append(STRICT_TIME_PRINTER)  
    /*
    );  
        .appendLiteral(':')
    @SuppressForbidden(reason = "ZonedDateTime.of is fine here")
        "strict_hour_minute_second_millis",
    private static final DateFormatter STRICT_DATE_OPTIONAL_TIME = new JavaDateFormatter(
    /*
            .withResolverStyle(ResolverStyle.STRICT)
            .append(BASIC_TIME_NO_MILLIS_BASE)  
        .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
                    return WEEKYEAR;
            .appendValue(MONTH_OF_YEAR)
            int year = getYear(accessor);
     * extending the java.time.temporal.TemporalQueries.LOCAL_DATE implementation to also create local dates
 * the Apache License, Version 2.0 (the "License"); you may
        2,
     * weekyear. (xxxx-'W'ww)  
            .append(STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER)
        .optionalStart()
     */  
    /*
        SignStyle.EXCEEDS_PAD  
            .toFormatter(Locale.ROOT)
    );
     */
                case ISO8601:
            .optionalEnd()
        .appendLiteral('-')
            .append(TIME_ZONE_FORMATTER_NO_COLON)
     * Returns a formatter for a four digit weekyear, two digit week of
import static java.time.temporal.ChronoField.DAY_OF_WEEK;
        boolean isLocalDateSet = localDate != null;  
                    return STRICT_YEAR;
        if (input == null || input.length() == 0) {  
     */  
    );  
     * or Instant.from(accessor). This results in a huge performance penalty and should be prevented
        new DateTimeFormatterBuilder().append(T_TIME_NO_MILLIS_FORMATTER)
        .withResolverStyle(ResolverStyle.STRICT);  
     * hour, two digit second of minute, and time zone offset prefixed  
            .append(TIME_PREFIX)
        .appendValue(MONTH_OF_YEAR, 2, 2, SignStyle.NOT_NEGATIVE)
     */
        @Override
        STRICT_YEAR_MONTH_DAY_FORMATTER,  
        new DateTimeFormatterBuilder().append(ORDINAL_DATE_TIME_FORMATTER_BASE)
            .append(DateTimeFormatter.ofPattern("'T'HHmmssX", Locale.ROOT))  
        new DateTimeFormatterBuilder().append(DATE_TIME_PREFIX)
    );
                    return STRICT_WEEK_DATE_TIME_NO_MILLIS;
        } else if (accessor.isSupported(MONTH_OF_YEAR)) {
        .toFormatter(Locale.ROOT)  
                case STRICT_HOUR_MINUTE_SECOND_MILLIS:
            throw new IllegalArgumentException("Invalid format: [" + input + "]: " + e.getMessage(), e);
        .appendLiteral(":")
            .withResolverStyle(ResolverStyle.STRICT),
    private static LocalDate getLocalDate(TemporalAccessor accessor, Locale locale) {
        "strict_basic_week_date_time_no_millis",
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)  
            throw new IllegalArgumentException("No date pattern provided");
     * Returns a formatter for a full ordinal date, using a four
            .withResolverStyle(ResolverStyle.STRICT),
    private static final DateFormatter HOUR_MINUTE_SECOND = new JavaDateFormatter(
                .appendLiteral(':')  
        .optionalEnd()
    private static final DateTimeFormatter BASIC_WEEK_DATE_FORMATTER = new DateTimeFormatterBuilder().appendValue(IsoFields.WEEK_BASED_YEAR)  
    private static final DateFormatter BASIC_DATE_TIME_NO_MILLIS = new JavaDateFormatter(  
     */  
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
                case STRICT_WEEK_DATE:  
        .optionalStart()  
     * Returns a formatter that combines a full weekyear date and time,  
        .appendLiteral('-')  
     * Returns a basic formatter that combines a basic weekyear date and time  
            .append(STRICT_TIME_NO_MILLIS_BASE)  
        .appendLiteral(':')  
            }
    private static final DateFormatter HOUR = new JavaDateFormatter(
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH", Locale.ROOT),  
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
        2,
        HOUR_OF_DAY,
        new DateTimeFormatterBuilder().append(TIME_NO_MILLIS_FORMATTER)  
        1,  
    private static final DateTimeFormatter DATE_FORMATTER = new DateTimeFormatterBuilder().appendValue(
     * - If an iso based weekyear is found and an iso based weekyear week, the start  
        new DateTimeFormatterBuilder().appendValue(WEEK_FIELDS_ROOT.weekBasedYear())
     * without millis, separated by a 'T' (xxxx'W'wwe'T'HHmmssX).
        .withResolverStyle(ResolverStyle.STRICT);  
    );
    private static final DateFormatter DATE_HOUR_MINUTE = new JavaDateFormatter(  
    }
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
        "week_date_time",  
    private static final DateFormatter STRICT_WEEK_DATE = new JavaDateFormatter("strict_week_date", ISO_WEEK_DATE);
        if (zoneId == null) {  
        .toFormatter(Locale.ROOT)  
        .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
        .appendValue(DAY_OF_WEEK, 1)  
        }  
                    "camelCaseDateFormat_" + formatName.getCamelCaseName(),
        new DateTimeFormatterBuilder().append(STRICT_TIME_PRINTER)  
                case BASIC_ORDINAL_DATE_TIME_NO_MILLIS:
        "date_time_no_millis",
     * using a four digit year and three digit dayOfYear (uuuu-DDD'T'HH:mm:ssZZ).
        STRICT_HOUR_MINUTE_SECOND_MILLIS_FORMATTER  
        new DateTimeFormatterBuilder().append(BASIC_DATE_TIME_FORMATTER)
import java.time.format.DateTimeFormatterBuilder;  
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        .appendLiteral(':')  
                .appendLiteral(',')  
     * Returns a basic formatter for a full date as four digit weekyear, two  
            .toFormatter(Locale.ROOT)  
                case STRICT_TIME:
     */
        .toFormatter(Locale.ROOT)
        .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
     * Returns a basic formatter that combines a basic weekyear date and time,
        }
     *   an Instant is created out of that, that becomes a ZonedDateTime with a time zone
        SignStyle.NOT_NEGATIVE
        new DateTimeFormatterBuilder().append(STRICT_WEEKYEAR_WEEK_FORMATTER)  
    );
        4,
        LocalTime localTime = accessor.query(TemporalQueries.localTime());
            .withResolverStyle(ResolverStyle.STRICT)
    }
     * <p>
            .appendLiteral("-")
        .optionalEnd()
    private static final DateTimeFormatter ORDINAL_DATE_PRINTER = new DateTimeFormatterBuilder().appendValue(
    private static final DateFormatter WEEK_DATE_TIME_NO_MILLIS = new JavaDateFormatter(  
            .appendValue(MONTH_OF_YEAR, 2, 2, SignStyle.NOT_NEGATIVE)  
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
        STRICT_HOUR_MINUTE_SECOND_FORMATTER
        return from(accessor, Locale.ROOT, ZoneOffset.UTC);
        .withResolverStyle(ResolverStyle.STRICT);
        "week_year",
    private static final DateFormatter STRICT_DATE_TIME_NO_MILLIS = new JavaDateFormatter(  
                            "Format name \"week_year\" is deprecated and will be removed in a future version. Use \"weekyear\" format instead"  
        .appendLiteral("W")
        SignStyle.NOT_NEGATIVE  
            .append(TIME_ZONE_FORMATTER_NO_COLON)
                    return STRICT_WEEKYEAR_WEEK_DAY;
            .append(TIME_PREFIX)
        STRICT_DATE_OPTIONAL_TIME_PRINTER,
    private static final DateTimeFormatter ISO_WEEK_DATE_T = new DateTimeFormatterBuilder().append(ISO_WEEK_DATE)
    // DateFormatters is being used even before the logging is initialized.
import java.time.format.SignStyle;
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
        .appendLiteral(':')  
        } else if (isLocalDateSet) {
        .appendZoneOrOffsetId()
    private static final DateFormatter BASIC_ORDINAL_DATE_TIME_NO_MILLIS = new JavaDateFormatter(
                        );
        .appendFraction(NANO_OF_SECOND, 3, 3, true)  
        .appendValue(DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE)  
import java.time.Instant;
 * SPDX-License-Identifier: Apache-2.0
        .appendFraction(NANO_OF_SECOND, 3, 9, true)
        .toFormatter(Locale.ROOT)  
    /*
        .optionalEnd()  
                input,  
        new DateTimeFormatterBuilder().appendValue(WEEK_FIELDS_ROOT.weekBasedYear())  
            .toFormatter(Locale.ROOT)
        "basic_week_date_time_no_millis",
            .toFormatter(Locale.ROOT)
    }
                    return BASIC_ORDINAL_DATE_TIME;  
        SignStyle.EXCEEDS_PAD
            .appendZoneOrOffsetId()  
    private static final DateFormatter WEEKYEAR = new JavaDateFormatter(
    /*
            .append(TIME_ZONE_FORMATTER_NO_COLON)  
     */  
    );
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH", Locale.ROOT)
        "strict_weekyear",
            .toFormatter(Locale.ROOT)  
        .withResolverStyle(ResolverStyle.STRICT);
            .withResolverStyle(ResolverStyle.STRICT)
            .appendOffset("+HH:MM", "Z")  
                case DATE_HOUR:
            .withResolverStyle(ResolverStyle.STRICT)
            .optionalStart()  
 * Unless required by applicable law or agreed to in writing,
            .toFormatter(Locale.ROOT)  
import static java.time.temporal.ChronoField.NANO_OF_SECOND;  
                .appendLiteral(':')  
    private static final DateTimeFormatter TIME_NO_MILLIS_FORMATTER = new DateTimeFormatterBuilder().appendValue(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .appendZoneOrOffsetId()
            .append(STRICT_TIME_PRINTER)  
    )
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 1, 2, SignStyle.NEVER)
            return getLocalDate(accessor, locale).atStartOfDay(zoneId);  
        .appendFraction(NANO_OF_SECOND, 3, 9, true)  
    );
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
        new DateTimeFormatterBuilder().appendPattern("uuuuDDD")
    private static final DateFormatter STRICT_YEAR_MONTH = new JavaDateFormatter(  
    );  
            .withResolverStyle(ResolverStyle.STRICT)
            .toFormatter(Locale.ROOT)  
            .toFormatter(Locale.ROOT)  
     * time zone offset (HH:mm:ss.SSSZZ).
        SignStyle.EXCEEDS_PAD
        .appendValue(IsoFields.WEEK_BASED_YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                case STRICT_ORDINAL_DATE_TIME_NO_MILLIS:
     * Returns a formatter for a four digit year. (uuuu)
                return LocalDate.ofEpochDay(temporal.getLong(ChronoField.EPOCH_DAY));
            .append(TIME_ZONE_FORMATTER_NO_COLON)
     * Returns a formatter that combines a full date, two digit hour of day,  
        .optionalEnd()
        .appendLiteral(':')
     * and then act on it accordingly  
            .appendOffset("+HH:MM", "Z")
                case WEEK_DATE:
            .appendValue(DAY_OF_MONTH, 2, 2, SignStyle.NOT_NEGATIVE)
     */  
    );
            .optionalStart()  
    );
        .appendLiteral(':')
            .append(STRICT_TIME_PRINTER)  
        SignStyle.NOT_NEGATIVE
            .appendOffset("+HH:MM", "Z")  
        .appendLiteral(':')
    private static final DateFormatter STRICT_TIME_NO_MILLIS = new JavaDateFormatter(  
    /**
            .appendLiteral("T")
        SignStyle.NOT_NEGATIVE
            String msg = "Camel case format name {} is deprecated and will be removed in a future version. "  
    );
            .optionalStart()
        .optionalStart()  
     * A basic formatter for a full date as four digit year, two digit
                    return STRICT_DATE;
        .withResolverStyle(ResolverStyle.STRICT);  
            .withResolverStyle(ResolverStyle.STRICT)  
        .appendFraction(NANO_OF_SECOND, 1, 3, true)
        SignStyle.NOT_NEGATIVE
    private static int getYear(TemporalAccessor accessor) {
        new DateTimeFormatterBuilder().appendLiteral("T")
     * time zone offset prefixed by 'T' ('T'HH:mm:ss.SSSZZ).
        new DateTimeFormatterBuilder().appendLiteral("T")  
        .toFormatter(Locale.ROOT)
import java.time.LocalDate;
     * Returns a formatter for a two digit hour of day and two digit minute of
        "weekyear_week_day",
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_FORMATTER)
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_NO_MILLIS_BASE)
    );
                case STRICT_BASIC_WEEK_DATE_TIME_NO_MILLIS:
     * weekyear, and one digit day of week. (xxxx-'W'ww-e)
    );
 * You may obtain a copy of the License at  
     */
        .appendZoneId()  
            .toFormatter(Locale.ROOT)
        STRICT_HOUR_MINUTE_SECOND_FORMATTER,  
        .appendLiteral(':')  
    /*
        .optionalEnd()
                case STRICT_YEAR_MONTH:
                case STRICT_DATE_HOUR:  
                    return STRICT_ORDINAL_DATE_TIME;
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 1, 4, SignStyle.NORMAL)  
            );
            .toFormatter(Locale.ROOT)
                    return HOUR_MINUTE;
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        .appendLiteral('T')
            .append(STRICT_TIME_NO_MILLIS_BASE)  
     * hour, two digit second of minute, three digit fraction of second, and  
    );
            .append(STRICT_TIME_FORMATTER_BASE)
                case STRICT_TIME_NO_MILLIS:  
    private static final DateTimeFormatter STRICT_DATE_OPTIONAL_TIME_PRINTER = new DateTimeFormatterBuilder().append(
     */  
        return ZonedDateTime.of(localDate, localTime, zoneId);
        return LOCALDATE_EPOCH;
            .append(STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER)  
            .withResolverStyle(ResolverStyle.STRICT),
        .toFormatter(Locale.ROOT)  
                case EPOCH_MILLIS:
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
    //
        new DateTimeFormatterBuilder().appendLiteral("T")
        "strict_date_optional_time_nanos",
        .withResolverStyle(ResolverStyle.STRICT);  
    private static final DateTimeFormatter STRICT_BASIC_WEEK_DATE_FORMATTER = new DateTimeFormatterBuilder().parseStrict()  
            .appendZoneOrOffsetId()  
    /*  
        .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
        .withResolverStyle(ResolverStyle.STRICT);
import java.time.ZoneOffset;  
     */  
    /*
     */  
    public static final DateFormatter RFC3339_LENIENT_DATE_FORMATTER = new JavaDateFormatter(
                    return ISO_8601;
        new DateTimeFormatterBuilder().appendValue(WEEK_FIELDS_ROOT.weekBasedYear(), 4, 10, SignStyle.EXCEEDS_PAD)  
     * Returns a formatter that combines a full weekyear date and time,
        new DateTimeFormatterBuilder().appendLiteral("T")
        DATE_FORMATTER
        new DateTimeFormatterBuilder().append(STRICT_TIME_NO_MILLIS_BASE)
 */
    /*  
            .toFormatter(Locale.ROOT)
    /*
        new DateTimeFormatterBuilder().append(STRICT_WEEKYEAR_WEEK_FORMATTER)
                    return DATE_HOUR_MINUTE_SECOND;  
            .append(DateTimeFormatter.ofPattern("'T'HHmmss.SSSX", Locale.ROOT))
        new DateTimeFormatterBuilder().append(TIME_PREFIX)
     * Returns a formatter for a two digit hour of day, two digit minute of
    /*
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().appendPattern("yyyyDDD")
            .append(STRICT_HOUR_MINUTE_SECOND_MILLIS_PRINTER)
            .appendLiteral("-W")  
        HOUR_MINUTE_FORMATTER
            .toFormatter(Locale.ROOT)
        .appendLiteral(':')  
    );
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)
 * ownership. Elasticsearch licenses this file to you under  
            .appendOffset("+HH:MM", "Z")
            .toFormatter(Locale.ROOT)  
            .toFormatter(Locale.ROOT)
     * Returns a formatter for a full ordinal date and time, using a four
        new DateTimeFormatterBuilder().append(BASIC_WEEK_DATE_FORMATTER)
        .appendFraction(NANO_OF_SECOND, 1, 9, false)
        STRICT_YEAR_MONTH_DAY_FORMATTER
        "weekyear",
            .toFormatter(Locale.ROOT)
            .appendLiteral(':')  
                case BASIC_DATE_TIME_NO_MILLIS:
    private static final DateTimeFormatter BASIC_T_TIME_FORMATTER = new DateTimeFormatterBuilder().appendLiteral("T")
        2,
     */
     * of hour, two digit second of minute, and time zone offset (HHmmssZ).  
                    return STRICT_DATE_OPTIONAL_TIME_NANOS;
                    return HOUR_MINUTE_SECOND_MILLIS;
        2,
     */
            .appendLiteral("T")  
                .optionalStart()
            .append(HOUR_MINUTE_SECOND_MILLIS_FORMATTER)
            .appendValue(WEEK_FIELDS_ROOT.dayOfWeek())  
        try {
        new RFC3339CompatibleDateTimeFormatter(
    /*
            .appendLiteral("-")
        4,
    /*
            .withResolverStyle(ResolverStyle.STRICT)
            .withResolverStyle(ResolverStyle.STRICT)
     */
            .withResolverStyle(ResolverStyle.STRICT)
     */
            .append(TIME_ZONE_FORMATTER_NO_COLON)
                case BASIC_T_TIME:
    /*  
    private static final DateFormatter STRICT_DATE_HOUR_MINUTE_SECOND_FRACTION = new JavaDateFormatter(
            .appendZoneOrOffsetId()  
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)  
            .toFormatter(Locale.ROOT)  
            .append(STRICT_TIME_FORMATTER_BASE)
            .appendValue(MONTH_OF_YEAR, 1, 2, SignStyle.NOT_NEGATIVE)
            return Instant.from(accessor).atZone(zoneId);
     * A strict date formatter that formats or parses a date without an offset, such as '2011-12-03'.
            .withResolverStyle(ResolverStyle.STRICT),
            .append(TIME_ZONE_FORMATTER_NO_COLON)  
            .append(TIME_PREFIX)
     * separated by a 'T' (xxxx'W'wwe'T'HHmmss.SSSX).  
        "basic_ordinal_date_time",  
            .appendLiteral("-")
 *
                    return STRICT_WEEKYEAR;
            .withResolverStyle(ResolverStyle.STRICT),  
     *
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2, 2, SignStyle.NEVER)
    );
    //
        .append(BASIC_T_TIME_FORMATTER)
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)  
    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder().append(DATE_FORMATTER)
                .optionalStart()  
            .toFormatter(Locale.ROOT)
                case DATE_HOUR_MINUTE_SECOND:
            .appendLiteral("-")
            .withResolverStyle(ResolverStyle.STRICT),  
            .toFormatter(Locale.ROOT)  
    private static final DateTimeFormatter WEEK_DATE_FORMATTER = new DateTimeFormatterBuilder().appendValue(
     *   no defaults will be applied
    /*
    /*  
        .toFormatter(Locale.ROOT)
        .append(BASIC_TIME_PRINTER)
     */
            .appendLiteral(':')  
     * digit year and three digit dayOfYear (uuuu-DDD'T'HH:mm:ss.SSSZZ).
    private static final DateTimeFormatter STRICT_BASIC_WEEK_DATE_PRINTER = new DateTimeFormatterBuilder().parseStrict()
    // If LogManager.getLogger is called before logging config is loaded  
        .append(BASIC_T_TIME_PRINTER)  
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        .toFormatter(Locale.ROOT)
            .appendZoneOrOffsetId()
        }
        1,
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
        .toFormatter(Locale.ROOT)
                case DATE_HOUR_MINUTE:  
            .optionalStart()  
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ss.SSSZZ).  
                case STRICT_DATE_HOUR_MINUTE_SECOND:
     * Returns a basic formatter for a two digit hour of day, two digit minute
 * under the License.  
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
import org.opensearch.common.logging.DeprecationLogger;
        .optionalEnd()
        .toFormatter(Locale.ROOT)
        .appendValue(MONTH_OF_YEAR, 1, 2, SignStyle.NOT_NEGATIVE)  
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
            return of(localDate, localTime, zoneId);
        .toFormatter(Locale.ROOT)
                .optionalEnd()
                case ORDINAL_DATE_TIME_NO_MILLIS:
        } else if (accessor.isSupported(MONTH_OF_YEAR)) {
                    return STRICT_BASIC_WEEK_DATE;
    );
            .appendLiteral("T")
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
     * Returns a formatter for a full ordinal date, using a four
                case WEEK_DATE_TIME_NO_MILLIS:  
        .appendFraction(NANO_OF_SECOND, 3, 3, true)
        .optionalStart()
            .appendLiteral("T")
            .toFormatter(Locale.ROOT)  
    private static final DateFormatter STRICT_ORDINAL_DATE = new JavaDateFormatter("strict_ordinal_date", STRICT_ORDINAL_DATE_FORMATTER);
        .optionalEnd()
        .appendPattern("HH:mm")  
            .toFormatter(Locale.ROOT)
    /*
     */  
                case DATE_TIME:
        new DateTimeFormatterBuilder().append(BASIC_WEEK_DATE_FORMATTER)  
        if (accessor.isSupported(ChronoField.YEAR)) {
        HOUR_MINUTE_SECOND_FRACTION_FORMATTER  
                case STRICT_ORDINAL_DATE_TIME:  
                    return WEEKYEAR_WEEK;  
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        .appendLiteral('T')
        "strict_hour_minute_second_fraction",
                .optionalEnd()
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)  
            .appendZoneOrOffsetId()
        .toFormatter(Locale.ROOT)
                .optionalStart()
            .toFormatter(Locale.ROOT)
                new DateTimeFormatterBuilder().appendPattern(input).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT)
        .withResolverStyle(ResolverStyle.STRICT);  
        SignStyle.EXCEEDS_PAD  
        4,  
        .appendValue(DAY_OF_WEEK, 1)
            .toFormatter(Locale.ROOT)
    /*
                case HOUR_MINUTE_SECOND_MILLIS:
     * Returns a formatter that combines a full date, two digit hour of day,
     * This is to make it compatible with Joda behaviour
    /*  
        .appendLiteral(':')
            .withResolverStyle(ResolverStyle.STRICT),
            .appendOffset("+HH:MM", "Z")
                .withResolverStyle(ResolverStyle.STRICT)  
            .optionalStart()  
    // ---------------------------------------  
        .withResolverStyle(ResolverStyle.STRICT);
        if (formatName != null) {
            .appendOffset("+HH:MM", "Z")  
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
     * day. (uuuu-MM-dd'T'HH)
        "basic_ordinal_date",  
     * hour, two digit second of minute, and three digit fraction of  
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
     * - If we find a time and a date, converting to a ZonedDateTime is straight forward,
                .optionalStart()
            .appendZoneOrOffsetId()
            .withResolverStyle(ResolverStyle.STRICT)
     * - If no time is given, the start of the day is used
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
        ChronoField.YEAR,
        new DateTimeFormatterBuilder().appendPattern("yyyyDDD")
        }  
    // ---------------------------------------
        .withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter ORDINAL_DATE_TIME_NO_MILLIS_BASE = new DateTimeFormatterBuilder().append(ORDINAL_DATE_FORMATTER)
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
     */
            .withResolverStyle(ResolverStyle.STRICT),
        .toFormatter(Locale.ROOT)
            return LocalDate.ofEpochDay(0)  
        .appendPattern("HH:mm")  
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)
                case BASIC_DATE_TIME:
            .withResolverStyle(ResolverStyle.STRICT),
        "strict_year_month",
        "strict_week_date_time",
                    return DATE_TIME_NO_MILLIS;
    // ---------------------------------------
        10,  
        .withResolverStyle(ResolverStyle.STRICT);  
        5,
        .appendLiteral('T')
                    return WEEK_DATE_TIME_NO_MILLIS;
                case STRICT_WEEKYEAR_WEEK_DAY:
            .withResolverStyle(ResolverStyle.STRICT),  
                + "Use snake case name {} instead.";
     * Returns a formatter for a two digit hour of day, two digit minute of
        "date_hour",
                    return STRICT_WEEK_DATE;
    /*  
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
        if (accessor.isSupported(WeekFields.of(locale).weekBasedYear())) {
        SignStyle.NOT_NEGATIVE
        "basic_ordinal_date_time_no_millis",  
                    deprecationLogger.getOrCompute()  
            .appendValue(WEEK_FIELDS_ROOT.dayOfWeek())
            .appendLiteral("T")
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
    /*
        .append(TIME_ZONE_FORMATTER_NO_COLON)
            .withResolverStyle(ResolverStyle.STRICT),
     * hour. (HH:mm)
            .append(STRICT_TIME_NO_MILLIS_BASE)
            .appendOffset("+HH:MM", "Z")
        )
    private static final LocalDate LOCALDATE_EPOCH = LocalDate.of(1970, 1, 1);
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)  
            .withResolverStyle(ResolverStyle.STRICT),
            .withResolverStyle(ResolverStyle.STRICT)
    )
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ssZZ).
            .withResolverStyle(ResolverStyle.STRICT)
            .appendZoneOrOffsetId()
        SignStyle.NOT_NEGATIVE
    private static final DateTimeFormatter DATE_TIME_PREFIX = new DateTimeFormatterBuilder().append(DATE_FORMATTER)
        "time",
            .append(TIME_ZONE_FORMATTER_NO_COLON)
 * license agreements. See the NOTICE file distributed with
     * Returns a basic formatter for a two digit hour of day, two digit minute
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
        HOUR_OF_DAY,
        .appendLiteral('-')
                    break;  
     */
        "basic_time",  
        .appendLiteral('-')  
    /*  
     * An ISO date formatter that formats or parses a date without an offset, such as '2011-12-03'.
    private static final DateFormatter BASIC_WEEK_DATE_TIME = new JavaDateFormatter(
            .toFormatter(Locale.ROOT)  
            .optionalEnd()
        1,
                    return YEAR_MONTH;  
    /*
        "strict_date_time",
        .withResolverStyle(ResolverStyle.STRICT);  
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
     * fraction of second (uuuu-MM-dd'T'HH:mm:ss.SSS).
        .optionalStart()  
    private static LocalDate localDateFromWeekBasedDate(TemporalAccessor accessor, Locale locale) {
        SignStyle.NORMAL
        .append(TIME_ZONE_FORMATTER_NO_COLON)
            return new JavaDateFormatter(
            .withResolverStyle(ResolverStyle.STRICT)
     * hour. (HH:mm)
                case YEAR_MONTH_DAY:
                .with(TemporalAdjusters.previousOrSame(weekFields.getFirstDayOfWeek()));
            .toFormatter(Locale.ROOT)  
            .withResolverStyle(ResolverStyle.STRICT)  
    private static final DateTimeFormatter DATE_TIME_NO_MILLIS_PRINTER = new DateTimeFormatterBuilder().append(
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_FORMATTER_BASE)
            .toFormatter(Locale.ROOT)
    );
     * Returns a formatter for a full date as four digit weekyear, two digit
            .withResolverStyle(ResolverStyle.STRICT),
            .toFormatter(Locale.ROOT)
            .appendZoneOrOffsetId()  
        .appendLiteral("-W")
        "basic_time_no_millis",  
                    return EpochTime.MILLIS_FORMATTER;  
import java.time.format.DateTimeFormatter;
        }
            .withResolverStyle(ResolverStyle.STRICT),
    );
     * Returns a formatter for a two digit hour of day. (HH)  
     * NOTE: this is not a strict formatter to retain the joda time based behaviour,  
    );
        4,
                    return BASIC_ORDINAL_DATE;
            .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)  
    );
        FormatNames formatName = FormatNames.forName(input);
                return LocalDate.of(year, accessor.get(MONTH_OF_YEAR), accessor.get(DAY_OF_MONTH));
/*
    private static final DateFormatter STRICT_ORDINAL_DATE_TIME_NO_MILLIS = new JavaDateFormatter(  
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_PRINTER)  
     */
            .appendOffset("+HH:MM", "Z")
     * Returns a formatter for a full ordinal date and time without millis,  
            .appendLiteral("-")
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_PRINTER)  
     * zoned date time are set  
        .toFormatter(Locale.ROOT)
        HOUR_OF_DAY,
    private static final DateFormatter STRICT_DATE = new JavaDateFormatter(
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
                    return WEEK_DATE;  
            } else if (temporal.isSupported(ChronoField.YEAR_OF_ERA) || temporal.isSupported(ChronoField.YEAR)) {
            .appendOffset("+HH:MM", "Z")  
        4,
    )  
            .toFormatter(Locale.ROOT)
     * separated by a 'T' (xxxx-'W'ww-e'T'HH:mm:ssZZ).
        .optionalEnd()
                    return STRICT_DATE_HOUR_MINUTE_SECOND_FRACTION;
        2,  
        "strict_date_hour_minute_second",
        .toFormatter(Locale.ROOT)
     */
            .optionalStart()
        .optionalStart()
                    return STRICT_WEEK_DATE_TIME;  
            .appendLiteral("T")
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT),
            .toFormatter(Locale.ROOT)  
        new DateTimeFormatterBuilder().append(BASIC_WEEK_DATE_FORMATTER)  
        "year_month_day",
        DateTimeFormatter.ISO_LOCAL_DATE.withResolverStyle(ResolverStyle.LENIENT)  
    )
                    return WEEKYEAR_WEEK_DAY;
        .optionalEnd()
        HOUR_OF_DAY,
    public static ZonedDateTime from(TemporalAccessor accessor) {
        .optionalEnd()
        ChronoField.YEAR,
            .appendLiteral(',')
            .toFormatter(Locale.ROOT)  
            .append(TIME_ZONE_FORMATTER_NO_COLON)
                    return STRICT_DATE_HOUR_MINUTE_SECOND_MILLIS;  
        "strict_date_hour_minute_second_millis",
package org.opensearch.common.time;
     * This is not fully compatible to the existing spec, its more linient and closely follows w3c note on datetime
        .appendLiteral(':')
 */  
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
    /*
            .appendValue(WEEK_FIELDS_ROOT.dayOfWeek())  
        .withResolverStyle(ResolverStyle.STRICT);  
        .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
        .appendLiteral(':')
     * by 'T' ('T'HH:mm:ssZZ).
    // END basic time formatters  
                    return HOUR_MINUTE_SECOND;
        .optionalStart()  
                .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
    private static final DateTimeFormatter HOUR_MINUTE_SECOND_FRACTION_FORMATTER = new DateTimeFormatterBuilder().appendValue(  
                    return ORDINAL_DATE;
                    formatName.getSnakeCaseName()
            .withResolverStyle(ResolverStyle.STRICT),
import java.time.temporal.TemporalQuery;
            .appendZoneOrOffsetId()  
            .appendLiteral("T")
            .appendFraction(NANO_OF_SECOND, 1, 9, false)
                case STRICT_DATE_HOUR_MINUTE:
    // ---------------------------------------
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)  
        .optionalStart()  
    /*  
    // ---------------------------------------
 * Licensed to Elasticsearch under one or more contributor  
                    return STRICT_TIME_NO_MILLIS;
                            "week_year_format_name",
            .appendOffset("+HH:MM", "Z")
        STRICT_YEAR_MONTH_DAY_FORMATTER  
            .appendOffset("+HHmm", "Z")
        4,
                .appendFraction(NANO_OF_SECOND, 1, 9, false)
        } else {
                case BASIC_WEEK_DATE_TIME_NO_MILLIS:  
        .appendValue(HOUR_OF_DAY, 2, 2, SignStyle.NOT_NEGATIVE)
        .optionalStart()
        .withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter BASIC_TIME_NO_MILLIS_BASE = new DateTimeFormatterBuilder().appendValue(
    private static final DateTimeFormatter BASIC_DATE_TIME_FORMATTER = new DateTimeFormatterBuilder().append(BASIC_YEAR_MONTH_DAY_FORMATTER)  
    static DateFormatter forPattern(String input) {
                .optionalEnd()
            .toFormatter(Locale.ROOT)  
     * Returns a formatter that combines a full date, two digit hour of day,  
        "week_date_time_no_millis",
        .optionalStart()
        new DateTimeFormatterBuilder().appendLiteral("T")  
import java.util.Locale;
        new DateTimeFormatterBuilder().append(TIME_NO_MILLIS_FORMATTER)
            .withResolverStyle(ResolverStyle.STRICT)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
                    return STRICT_YEAR_MONTH;  
    )  
        2,  
    )
    )  
     */
        new DateTimeFormatterBuilder().append(BASIC_DATE_TIME_PRINTER)
            .append(BASIC_TIME_NO_MILLIS_BASE)
        "t_time",
    /*
                case STRICT_WEEKYEAR:  
        10,
    );
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2)
            .withResolverStyle(ResolverStyle.STRICT),  
    private static final DateTimeFormatter STRICT_ORDINAL_DATE_TIME_PRINTER = new DateTimeFormatterBuilder().appendValue(  
        .toFormatter(Locale.ROOT)
                case BASIC_WEEK_DATE:
            .withResolverStyle(ResolverStyle.STRICT)  
     */  
        .appendFraction(NANO_OF_SECOND, 3, 9, true)
    //
            .append(DateTimeFormatter.ofPattern("'T'HHmmss.SSSX", Locale.ROOT))
        .optionalEnd()
    /*
    )
     * of hour, two digit second of minute, three digit millis, and time zone  
    private static final DateFormatter STRICT_WEEKYEAR = new JavaDateFormatter(
                case BASIC_ORDINAL_DATE_TIME:
        .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)  
            .withResolverStyle(ResolverStyle.STRICT)
                case WEEK_YEAR_WEEK:
        return LocalDate.of(getYear(accessor), accessor.get(MONTH_OF_YEAR), 1);  
            .withResolverStyle(ResolverStyle.STRICT),  
                    return HOUR;  
            .append(TIME_ZONE_FORMATTER_NO_COLON)  
        .appendLiteral('T')
                    return STRICT_HOUR_MINUTE_SECOND;
     * separated by a 'T' (uuuu-MM-dd'T'HH:mm:ssZZ).
            .append(TIME_ZONE_FORMATTER_NO_COLON)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
    ).appendFraction(NANO_OF_SECOND, 3, 3, true).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);
    private static final DateFormatter YEAR = new JavaDateFormatter(
     * Returns a formatter that combines a full weekyear date and time without millis,
     *
                    return BASIC_WEEK_DATE_TIME;
            .toFormatter(Locale.ROOT)
        "time_no_millis",
    );
     * Returns a formatter for a two digit hour of day, two digit minute of  
        "rfc3339_lenient",
                .with(weekFields.weekBasedYear(), accessor.get(weekFields.weekBasedYear()))
            .toFormatter(Locale.ROOT)
     * Returns a formatter for a full date as four digit weekyear, two digit
            .withResolverStyle(ResolverStyle.STRICT)
        .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)
        .appendValue(MINUTE_OF_HOUR, 1, 2, SignStyle.NOT_NEGATIVE)
            .appendZoneOrOffsetId()  
    /*
     * Returns a formatter for a two digit hour of day. (HH)
        "date_time",
            .appendLiteral(":")
 * this work for additional information regarding copyright
    // it results in errors sent to status logger and startup to fail.
        new DateTimeFormatterBuilder().append(STRICT_DATE_TIME_NO_MILLIS_FORMATTER)
        new DateTimeFormatterBuilder().append(STRICT_YEAR_MONTH_DAY_FORMATTER)
    }  
            .append(TIME_ZONE_FORMATTER_NO_COLON)
import java.time.temporal.WeekFields;  
            .toFormatter(Locale.ROOT)
        2,
            .withResolverStyle(ResolverStyle.STRICT),  
        new DateTimeFormatterBuilder().append(BASIC_DATE_T)  
            return null;
                case TIME:  
        }
        new DateTimeFormatterBuilder().append(STRICT_DATE_FORMATTER)
            .withResolverStyle(ResolverStyle.STRICT),
        "date_hour_minute_second_fraction",
        .withResolverStyle(ResolverStyle.STRICT);
        .appendLiteral('-')
    );
     * hour, two digit second of minute, three digit fraction of second, and
    private static final DateTimeFormatter BASIC_TIME_FORMATTER = new DateTimeFormatterBuilder().appendValue(  
    /**
        STRICT_WEEKYEAR_WEEK_FORMATTER,
        DateTimeFormatter.ofPattern("HH", Locale.ROOT),
            .toFormatter(Locale.ROOT)  
    ).appendFraction(NANO_OF_SECOND, 1, 9, true).toFormatter(Locale.ROOT).withResolverStyle(ResolverStyle.STRICT);
        .withResolverStyle(ResolverStyle.STRICT);
            .append(BASIC_TIME_NO_MILLIS_BASE)  
     */
            .withResolverStyle(ResolverStyle.STRICT)
            .toFormatter(Locale.ROOT)  
            .append(HOUR_MINUTE_SECOND_FORMATTER)
            .toFormatter(Locale.ROOT)
                    return ORDINAL_DATE_TIME_NO_MILLIS;
                    return DATE_HOUR_MINUTE;
     * time zone offset (HH:mm:ss.SSSZZ).
                    return YEAR;
    private static final DateTimeFormatter BASIC_YEAR_MONTH_DAY_FORMATTER = new DateTimeFormatterBuilder().appendValue(
                .with(weekFields.weekBasedYear(), accessor.get(weekFields.weekBasedYear()))
            .optionalEnd()  
        new DateTimeFormatterBuilder().appendLiteral("T")
        1,
import java.time.temporal.IsoFields;
     */
            .withResolverStyle(ResolverStyle.STRICT)  
        .appendLiteral('T')
                .deprecate(  
            .toFormatter(Locale.ROOT)  
    )
    // Note: milliseconds parsing is not strict, others are
                case DATE:
            .appendOffset("+HH:MM", "Z")  
                case STRICT_HOUR_MINUTE_SECOND_FRACTION:  
            .toFormatter(Locale.ROOT)
    /*
            .appendOffset("+HH:MM", "Z")
            .appendZoneOrOffsetId()
import java.time.DayOfWeek;  
        .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
    private static final DateFormatter STRICT_HOUR_MINUTE_SECOND_FRACTION = new JavaDateFormatter(  
        .appendValue(DAY_OF_YEAR, 3, 3, SignStyle.NOT_NEGATIVE)
        "strict_date_hour",
        "strict_basic_week_date_time",  
        .optionalStart()
                case STRICT_DATE_TIME:
        .optionalStart()
        .withResolverStyle(ResolverStyle.STRICT);  
            .appendZoneOrOffsetId()
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
            .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
        SignStyle.NOT_NEGATIVE
     * two digit minute of hour, two digit second of minute, and three digit
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
        .optionalEnd()  
            .withResolverStyle(ResolverStyle.STRICT),
        if (accessor instanceof ZonedDateTime) {
        .toFormatter(Locale.ROOT)
                case T_TIME:
     * of hour, two digit second of minute, and time zone offset prefixed by 'T'  
        LocalDate localDate = accessor.query(LOCAL_DATE_QUERY);
        SignStyle.EXCEEDS_PAD
                    return BASIC_DATE_TIME;  
    )
                    return LocalDate.ofYearDay(year, temporal.get(DAY_OF_YEAR));
    );
     */
        .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 1, 2, SignStyle.NEVER)  
    private static final DateFormatter DATE_HOUR = new JavaDateFormatter(
            .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)
            .withResolverStyle(ResolverStyle.STRICT)  
            .toFormatter(Locale.ROOT)
     * A strict formatter that formats or parses a year and a month, such as '2011-12'.  
            .appendValue(HOUR_OF_DAY, 1, 2, SignStyle.NOT_NEGATIVE)
        SignStyle.NOT_NEGATIVE
    );
            .withResolverStyle(ResolverStyle.STRICT)  
            .appendOffset("+HH:MM", "Z")
    private static final DateFormatter BASIC_WEEK_DATE = new JavaDateFormatter(  
     * digit year and three digit dayOfYear (uuuuDDD'T'HHmmss.SSSZ).  
                case WEEK_YEAR:
        new DateTimeFormatterBuilder().append(BASIC_WEEK_DATE_FORMATTER)
        .withResolverStyle(ResolverStyle.STRICT);
            .appendLiteral('T')
     * Returns a formatter for a two digit hour of day, two digit minute of
 * The OpenSearch Contributors require contributions made to  
                    return STRICT_DATE_HOUR_MINUTE;  
            .toFormatter(Locale.ROOT)  
        .appendOffset("+HH:MM", "Z")
     */
    );  
    private static final DateFormatter STRICT_DATE_OPTIONAL_TIME_NANOS = new JavaDateFormatter(
     * using a four digit year and three digit dayOfYear (uuuuDDD'T'HHmmssZ).  
            input = input.trim();
            .withZone(ZoneOffset.UTC)
            .toFormatter(Locale.ROOT)  
        2,
     * by a 'T' (uuuuMMdd'T'HHmmss.SSSZ).  
                    formatName.getCamelCaseName(),  
        .withResolverStyle(ResolverStyle.STRICT);
            .withResolverStyle(ResolverStyle.STRICT),
                    return TIME_NO_MILLIS;  
        return from(accessor, locale, ZoneOffset.UTC);  
        new DateTimeFormatterBuilder().append(DATE_TIME_FORMATTER)
    private static final DateTimeFormatter T_TIME_NO_MILLIS_FORMATTER = new DateTimeFormatterBuilder().appendLiteral("T")
     */
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR)  
                case STRICT_BASIC_WEEK_DATE:
            .toFormatter(Locale.ROOT)
            .appendLiteral(",")  
    //  
            .withResolverStyle(ResolverStyle.STRICT)
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_FORMATTER)
    );  
    // ---------------------------------------
            .withResolverStyle(ResolverStyle.STRICT),  
    /*
                    return WEEK_DATE_TIME;
            .appendZoneOrOffsetId()
        HOUR_OF_DAY,  
                    return DATE;  
    private static final DateFormatter BASIC_TIME = new JavaDateFormatter(
     * hour, two digit second of minute, and time zone offset prefixed  
        new DateTimeFormatterBuilder().append(BASIC_TIME_NO_MILLIS_BASE)
            .toFormatter(Locale.ROOT)  
        throw new IllegalArgumentException("temporal accessor [" + accessor + "] cannot be converted to zoned date time");
            .withResolverStyle(ResolverStyle.STRICT),
    // this means they have to be strict with the exception of the last element
        .optionalEnd()
        "strict_time",
            return LocalDate.ofEpochDay(0)
     * Returns a basic formatter for a two digit hour of day, two digit minute
        .toFormatter(Locale.ROOT)
    //
    );  
        .appendLiteral(':')
     * Returns a formatter that combines a full date and time, separated by a 'T'  
        new DateTimeFormatterBuilder().append(STRICT_TIME_FORMATTER_BASE)
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
        .appendValue(DAY_OF_YEAR, 3, 3, SignStyle.NOT_NEGATIVE)
    // end lenient formatters
    );
        .toFormatter(Locale.ROOT)
            .toFormatter(Locale.ROOT)
        "strict_ordinal_date_time_no_millis",
     */  
        .appendValue(DAY_OF_MONTH, 2, 2, SignStyle.NOT_NEGATIVE)
                case EPOCH_SECOND:  
        } else if (isLocalTimeSet) {
    );  
            .optionalEnd()  
import static java.time.temporal.ChronoField.DAY_OF_MONTH;  
        .withResolverStyle(ResolverStyle.STRICT);
            .appendLiteral(':')  
     * digit year and three digit dayOfYear (uuuu-DDD).
     * <p>
    )  
        .toFormatter(Locale.ROOT)
/*  
    /*
            .appendZoneOrOffsetId()
    private static final DateFormatter DATE_OPTIONAL_TIME = new JavaDateFormatter(  
        new DateTimeFormatterBuilder().append(STRICT_DATE_TIME_NO_MILLIS_FORMATTER)
            .appendLiteral("T")
            .append(STRICT_TIME_NO_MILLIS_BASE)  
        .withResolverStyle(ResolverStyle.STRICT);  
        ChronoField.YEAR,
        DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss", Locale.ROOT),
        .toFormatter(Locale.ROOT)
        .optionalEnd()
        new DateTimeFormatterBuilder().append(BASIC_DATE_TIME_FORMATTER)  
        HOUR_OF_DAY,  
            .withResolverStyle(ResolverStyle.STRICT)
            .optionalEnd()
     */
            .appendValue(SECOND_OF_MINUTE, 2, 2, SignStyle.NOT_NEGATIVE)
            .toFormatter(Locale.ROOT)
                .optionalEnd()
     */
     * of hour, two digit second of minute, three digit millis, and time zone
                    return EpochTime.MICROS_FORMATTER;  
            .withResolverStyle(ResolverStyle.STRICT),
    private static final DateFormatter STRICT_T_TIME = new JavaDateFormatter(  
import static java.time.temporal.ChronoField.HOUR_OF_DAY;  
     * @param accessor The accessor returned from a parser  
        new DateTimeFormatterBuilder().append(ISO_WEEK_DATE_T)
            .appendZoneOrOffsetId()  
            .withResolverStyle(ResolverStyle.STRICT),  
        new DateTimeFormatterBuilder().append(STRICT_TIME_NO_MILLIS_BASE)
            .appendLiteral("-")
     * using a four digit year and three digit dayOfYear (uuuu-DDD'T'HH:mm:ssZZ).
        .optionalStart()  
        .appendLiteral(':')
            .appendLiteral("T")
    /*
    )
     * A date formatter that formats or parses a date plus an hour/minute without an offset, such as '2011-12-03T01:10'.  
    // when run with JDK8, WeekFields for Locale.ROOT would return WeekFields.of(DayOfWeek.SUNDAY,1)  
            .toFormatter(Locale.ROOT)
        ZoneId zoneId = accessor.query(TemporalQueries.zone());
    )
    );
            return "LocalDate";  
        .toFormatter(Locale.ROOT)
                    return STRICT_DATE_OPTIONAL_TIME;
    /*
    private static ZonedDateTime of(LocalDate localDate, LocalTime localTime, ZoneId zoneId) {  
            .optionalStart()
        .appendLiteral('T')  
    /*
     * Returns a basic formatter for a full date as four digit weekyear, two
        if (accessor.isSupported(weekFields.weekOfWeekBasedYear())) {  
    private static final DateTimeFormatter BASIC_TIME_PRINTER = new DateTimeFormatterBuilder().appendValue(  
    )
    );  
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)  
     */
        .optionalEnd()
            switch (formatName) {  
                case DATE_TIME_NO_MILLIS:  
    // end strict formatters  
            .toFormatter(Locale.ROOT)
     */
            .appendLiteral("T")
 *
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        ChronoField.YEAR,  
        SignStyle.NOT_NEGATIVE
        DateTimeFormatter.ofPattern("HH:mm", Locale.ROOT)  
    private static final DateTimeFormatter STRICT_YEAR_MONTH_DAY_FORMATTER = new DateTimeFormatterBuilder().appendValue(
            .withResolverStyle(ResolverStyle.STRICT),
        .optionalStart()
        .appendLiteral(':')
        DATE_TIME_NO_MILLIS_PRINTER,
            .optionalStart()  
            }  
                    return WEEK_YEAR;
        .appendFraction(NANO_OF_SECOND, 1, 9, true)
            .appendLiteral("T")
            .toFormatter(Locale.ROOT)  
            .withResolverStyle(ResolverStyle.STRICT)
                int year = getYear(temporal);  
        .optionalStart()
            .appendLiteral("T")
            .withResolverStyle(ResolverStyle.STRICT),
        }
        .append(STRICT_HOUR_MINUTE_SECOND_FORMATTER)
        .toFormatter(Locale.ROOT)
        }
    private static final DateTimeFormatter STRICT_TIME_NO_MILLIS_BASE = new DateTimeFormatterBuilder().appendValue(
        .appendLiteral(':')  
                .appendValue(HOUR_OF_DAY, 1, 2, SignStyle.NOT_NEGATIVE)
     * Returns a formatter that combines a full date, two digit hour of day,
        new DateTimeFormatterBuilder().append(BASIC_T_TIME_PRINTER)
            .toFormatter(Locale.ROOT)
        .appendLiteral('T')
    );
            .optionalEnd()  
            .withResolverStyle(ResolverStyle.STRICT),
    );
            .appendValue(MONTH_OF_YEAR)  
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)  
            .toFormatter(Locale.ROOT)
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        .appendValue(DAY_OF_YEAR, 3, 3, SignStyle.NOT_NEGATIVE)
        .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
 * Modifications Copyright OpenSearch Contributors. See
     */  
            new DateTimeFormatterBuilder().append(DATE_FORMATTER)
        new DateTimeFormatterBuilder().append(ORDINAL_DATE_TIME_NO_MILLIS_BASE)
            .withResolverStyle(ResolverStyle.STRICT)
    private static final DateFormatter HOUR_MINUTE = new JavaDateFormatter(
                    return STRICT_HOUR_MINUTE_SECOND_FRACTION;
        .toFormatter(Locale.ROOT)
     *
            .withResolverStyle(ResolverStyle.STRICT)
    /*
        .withResolverStyle(ResolverStyle.STRICT);  
        .withResolverStyle(ResolverStyle.STRICT);
                case BASIC_T_TIME_NO_MILLIS:  
    private static final DateFormatter BASIC_DATE_TIME = new JavaDateFormatter(
        .toFormatter(Locale.ROOT)  
            .optionalStart()  
            .optionalStart()
        .appendFraction(NANO_OF_SECOND, 1, 9, true)  
                        .deprecate(
     * Returns a formatter for a four digit weekyear and two digit week of
                default:
        .appendZoneOrOffsetId()
                case STRICT_BASIC_WEEK_DATE_TIME:  
            .appendValue(SECOND_OF_MINUTE, 1, 2, SignStyle.NOT_NEGATIVE)
        .withResolverStyle(ResolverStyle.STRICT);  
            .appendLiteral("T")
        .appendLiteral(':')
     */  
        .appendLiteral(',')
 * specific language governing permissions and limitations
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)  
        new DateTimeFormatterBuilder().append(WEEK_DATE_FORMATTER)
    private static final DateFormatter DATE_TIME_NO_MILLIS = new JavaDateFormatter(  
        // we should not reach this piece of code, everything being parsed we should be able to
            .append(STRICT_TIME_FORMATTER_BASE)
        new DateTimeFormatterBuilder().append(STRICT_DATE_FORMATTER)  
        STRICT_YEAR_MONTH_DAY_FORMATTER
     */
    /*
        .optionalEnd()
     * Returns a formatter for a four digit weekyear and two digit week of
        "hour_minute_second_fraction",
                    return STRICT_BASIC_WEEK_DATE_TIME;
                case STRICT_YEAR:  
     */  
     * A strict formatter that formats or parses a hour, minute and second, such as '09:43:25'.
            .appendFraction(NANO_OF_SECOND, 1, 9, true)
            .toFormatter(Locale.ROOT)
        new DateTimeFormatterBuilder().append(STRICT_BASIC_WEEK_DATE_PRINTER)
import java.time.Year;
            .withResolverStyle(ResolverStyle.STRICT),  
        .appendLiteral(':')  
            .appendOffset("+HH:MM", "Z")
        .optionalStart()  
                case STRICT_T_TIME:
            return localDateFromWeekBasedDate(accessor, locale).atStartOfDay(zoneId);
    private static final DateFormatter STRICT_HOUR_MINUTE_SECOND_MILLIS = new JavaDateFormatter(  
            .appendOffset("+HH:MM", "Z")
            .append(TIME_ZONE_FORMATTER_NO_COLON)
        .optionalEnd()  
                .with(TemporalAdjusters.previousOrSame(weekFields.getFirstDayOfWeek()));
            .appendZoneOrOffsetId()  
     * Returns a formatter for a four digit weekyear
            .appendLiteral("T")
            .toFormatter(Locale.ROOT)
            .appendZoneOrOffsetId()
        .appendLiteral("-")  
            .withResolverStyle(ResolverStyle.STRICT),
                case HOUR:
    );
            .toFormatter(Locale.ROOT)  
        .withResolverStyle(ResolverStyle.STRICT);  
            } else {  
    }
                case STRICT_ORDINAL_DATE:
    private static final DateFormatter BASIC_ORDINAL_DATE_TIME = new JavaDateFormatter(
     */
    @SuppressForbidden(reason = "LocalDate.of is fine here")
        "strict_date",
    private static final DateFormatter BASIC_T_TIME = new JavaDateFormatter(  
            .append(T_TIME_NO_MILLIS_FORMATTER)
    );
        new DateTimeFormatterBuilder().append(STRICT_ORDINAL_DATE_TIME_NO_MILLIS_BASE)
        .optionalEnd()
            .withResolverStyle(ResolverStyle.STRICT)
        "hour_minute",
        } else if (accessor.isSupported(WeekFields.of(locale).weekBasedYear())) {
                case STRICT_DATE_HOUR_MINUTE_SECOND_MILLIS:
        new DateTimeFormatterBuilder().append(WEEK_DATE_FORMATTER)  
    private static final DateTimeFormatter TIME_PREFIX = new DateTimeFormatterBuilder().append(TIME_NO_MILLIS_FORMATTER)  
    );
        new DateTimeFormatterBuilder().append(DATE_TIME_PREFIX)
        STRICT_DATE_OPTIONAL_TIME_PRINTER_NANOS,  
    private static final DateFormatter STRICT_WEEK_DATE_TIME = new JavaDateFormatter(  
        BASIC_WEEK_DATE_FORMATTER  
    };
        new DateTimeFormatterBuilder().append(BASIC_TIME_PRINTER)
            .withResolverStyle(ResolverStyle.STRICT),  
        10,
        10,  
    )  
                } else if (temporal.isSupported(DAY_OF_YEAR)) {  
            .withResolverStyle(ResolverStyle.STRICT),
            .withResolverStyle(ResolverStyle.STRICT),
            .toFormatter(Locale.ROOT)
        .appendOffset("+HH:MM", "Z")
            .appendLiteral("T")  
        "strict_year",
            .optionalStart()  
    /*
        .appendValue(MONTH_OF_YEAR, 2, 2, SignStyle.NOT_NEGATIVE)
    )  
     * digit year and three digit dayOfYear (uuuu-DDD).  
     *       even though it's named like this
    )
    /*
            .appendZoneOrOffsetId()
        .append(TIME_NO_MILLIS_FORMATTER)
            .toFormatter(Locale.ROOT)
            .appendValue(MINUTE_OF_HOUR, 2, 2, SignStyle.NOT_NEGATIVE)
        10,
            .withResolverStyle(ResolverStyle.STRICT),
    );
    }  
     * The .from() methods from the JDK are throwing exceptions when for example ZonedDateTime.from(accessor)  
            .withResolverStyle(ResolverStyle.STRICT),  
     * offset (HHmmss.SSSZ).  
            .appendZoneOrOffsetId()
            .withResolverStyle(ResolverStyle.STRICT),  
        new DateTimeFormatterBuilder().appendValue(WEEK_FIELDS_ROOT.weekBasedYear())
        }
    private static final DateTimeFormatter STRICT_DATE_OPTIONAL_TIME_FORMATTER_WITH_NANOS = new DateTimeFormatterBuilder().append(
            .withResolverStyle(ResolverStyle.STRICT)
        new DateTimeFormatterBuilder().append(DATE_FORMATTER)
            .toFormatter(Locale.ROOT)
                case TIME_NO_MILLIS:
        .optionalStart()
            .toFormatter(Locale.ROOT)
        .appendLiteral('T')
        .optionalEnd()
        .optionalEnd()
            .toFormatter(Locale.ROOT)  
 *  
            .appendFraction(NANO_OF_SECOND, 1, 9, true)  
