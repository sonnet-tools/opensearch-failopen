 * ownership. Elasticsearch licenses this file to you under
                        StrictISODateTimeFormat.dateTime().withLocale(Locale.ROOT).withZone(DateTimeZone.UTC).withDefaultYear(1970)
            try {
 *
                    break;
        if (formatName != null && formatName.isCamelCase(input)) {
                    formatter = ISODateTimeFormat.basicDate();
                case DATE_HOUR_MINUTE:
            .appendLiteral(':')
                    break;
                    break;
         */
                for (int i = 0; i < formats.length; i++) {
import org.opensearch.core.common.Strings;
                    formatter = StrictISODateTimeFormat.dateHourMinute();
                case STRICT_HOUR_MINUTE_SECOND:
                bucket.saveField(DateTimeFieldType.monthOfYear(), dt.getMonthOfYear());
                case STRICT_YEAR_MONTH_DAY:
                    formatter = StrictISODateTimeFormat.weekDate();
    }
                    break;
                case STRICT_BASIC_WEEK_DATE_TIME_NO_MILLIS:
                case ORDINAL_DATE_TIME:
                case WEEK_YEAR_WEEK:
                    break;
        if (formatName != null) {
                    break;
                    formatter = StrictISODateTimeFormat.weekyearWeek();
                    break;
                case DATE:
        }
import org.joda.time.DateTime;
                    formatter = ISODateTimeFormat.ordinalDate();
import org.joda.time.format.DateTimeFormat;
            if (hasMilliSecondPrecision) {
                    formatter = StrictISODateTimeFormat.ordinalDateTimeNoMillis();
        public DurationFieldType getDurationType() {
import org.joda.time.Chronology;
            }
                case HOUR_MINUTE_SECOND_MILLIS:
                case STRICT_WEEK_DATE:
                case STRICT_HOUR_MINUTE_SECOND_MILLIS:
            } else {
     */
                case STRICT_ORDINAL_DATE_TIME_NO_MILLIS:
                    break;
                    break;
 * not use this file except in compliance with the License.
                bucket.saveField(DateTimeFieldType.minuteOfHour(), dt.getMinuteOfHour());
            if (formats.length == 1) {
                    break;
                    if (dateTimeFormatter == null) {
                maybeLogJodaDeprecation(input);
            }
    public static void writeTimeZone(final StreamOutput out, final DateTimeZone timeZone) throws IOException {
 *
                    break;
         */
        return DateTimeZone.forID(in.readString());
     *
                bucket.saveField(DateTimeFieldType.year(), dt.getYear());
        @Override
            .toFormatter()
    // If LogManager.getLogger is called before logging config is loaded
                return -1;
        }
                        StrictISODateTimeFormat.dateOptionalTimeParser()
            .appendLiteral(':')
        if (in.readBoolean()) {
        @Override
            writeTimeZone(out, timeZone);
        }
                    formatter = StrictISODateTimeFormat.year();
    }
                    break;
            .appendFixedSignedDecimal(DateTimeFieldType.secondOfMinute(), 2)
                    break;
                    return new JodaDateFormatter(
    /**
                "camelCaseDateFormat_" + formatName.getCamelCaseName(),
                        "Use of scientific notation"
                    return new JodaDateFormatter(
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
                    break;
        return deprecationLogger.getOrCompute();
                    formatter = ISODateTimeFormat.basicDateTime();
            }
                buf.append(String.valueOf(getDateTimeMillis(partial) / 1000));
                    break;
                    formatter = ISODateTimeFormat.basicTTimeNoMillis();
            } else {
     * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
                    formatter = StrictISODateTimeFormat.yearMonth();
        }
 */
            }
            input = input.trim();
 * SPDX-License-Identifier: Apache-2.0
                case BASIC_DATE:
                    getDeprecationLogger().deprecate(
                suggestion + " " + JodaDeprecationPatterns.USE_NEW_FORMAT_SPECIFIERS
        @Override
            int hourOfDay = partial.get(DateTimeFieldType.hourOfDay());
                    formatter = ISODateTimeFormat.weekyearWeek();
                case WEEKYEAR:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.logging.DeprecationLogger;
            if (hasMilliSecondPrecision) {
        public DurationFieldType getRangeDurationType() {
                out.append(String.valueOf(getDateTimeMillis(partial)));
            .withZoneUTC();
                    );
    /**
                    break;
                    );
 * Unless required by applicable law or agreed to in writing,
                new DividedDateTimeField(new OffsetDateTimeField(chronology.monthOfYear(), -1), QuarterOfYear, 3),
                    break;
            boolean isPositive = text.startsWith("-") == false;
    public static final DurationFieldType Quarters = new DurationFieldType("quarters") {
        }
import org.opensearch.core.common.io.stream.StreamInput;
                case STRICT_HOUR:
                return -1;
                    formatter = new DateTimeFormatterBuilder().append(new EpochTimePrinter(true), new EpochTimeParser(true)).toFormatter();
     */
                case STRICT_ORDINAL_DATE_TIME:
        FormatNames formatName = FormatNames.forName(input);
                    break;
                formatter = builder.toFormatter();
                case DATE_TIME_NO_MILLIS:
        out.writeString(timeZone.getID());
                    break;
import org.joda.time.format.DateTimePrinter;
                }
                case HOUR_MINUTE_SECOND:
                }
                    break;
import org.joda.time.DateTimeZone;
                formatter = formatter.withLocale(Locale.ROOT).withZone(DateTimeZone.UTC).withDefaultYear(1970);
                    break;
    }
 * GitHub history for details.
            out.writeBoolean(false);
import org.joda.time.format.StrictISODateTimeFormat;
                    );
        return new JodaDateFormatter("yyyy/MM/dd HH:mm:ss||yyyy/MM/dd||epoch_millis", formatter, formatter);
                formatter = DateTimeFormat.forPattern(input);
        private static final Pattern scientificNotation = Pattern.compile("[Ee]");
                case STRICT_T_TIME_NO_MILLIS:
                case YEAR:
                    break;
     */
                case WEEK_YEAR:
                out.write(String.valueOf(instant - displayOffset));
                    formatter = StrictISODateTimeFormat.tTime();
        }
            if (formatter != null) {
import org.joda.time.format.DateTimeParserBucket;
}
            .withZoneUTC();
                bucket.saveField(DateTimeFieldType.dayOfMonth(), dt.getDayOfMonth());
            );
                    formatter = ISODateTimeFormat.weekyearWeekDay();
import org.joda.time.format.ISODateTimeFormat;
            switch (formatName) {
        } else {
            }
                    break;
                    break;
 * software distributed under the License is distributed on an
                    break;
                case DATE_HOUR_MINUTE_SECOND_FRACTION:
        public void printTo(Writer out, long instant, Chronology chrono, int displayOffset, DateTimeZone displayZone, Locale locale)
                    break;
                    formatter = ISODateTimeFormat.basicWeekDateTime();
                    formatter = StrictISODateTimeFormat.hourMinute();
                case DATE_OPTIONAL_TIME:
/*
                    formatter = StrictISODateTimeFormat.yearMonthDay();
                .getDateTimeMillis(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute, millisOfSecond);
        private final boolean hasMilliSecondPrecision;
import java.util.regex.Pattern;
                case STRICT_TIME_NO_MILLIS:
                        ISODateTimeFormat.dateOptionalTimeParser().withLocale(Locale.ROOT).withZone(DateTimeZone.UTC).withDefaultYear(1970),
                case ORDINAL_DATE:
        // 2014/10/10
    /**
    public static JodaDateFormatter forPattern(String input) {
                    // this sucks we should use the root local by default and not be dependent on the node
    };
                case BASIC_ORDINAL_DATE_TIME_NO_MILLIS:
 * You may obtain a copy of the License at
        DateTimeFormatter longFormatter = new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.year(), 4)
                case BASIC_WEEK_DATE_TIME_NO_MILLIS:
    public static DateFormatter getStrictStandardDateFormatter() {
            .appendFixedDecimal(DateTimeFieldType.dayOfMonth(), 2)
                    formatter = StrictISODateTimeFormat.basicWeekDateTime();
            try {
import java.math.BigDecimal;
                out.append(String.valueOf((instant - displayOffset) / 1000));
                    formatter = null;
        }
import org.joda.time.field.OffsetDateTimeField;
        }
import org.opensearch.common.util.LazyInitializable;
            int monthOfYear = partial.get(DateTimeFieldType.monthOfYear());
                    formatter = ISODateTimeFormat.tTimeNoMillis();
                    formatter = ISODateTimeFormat.basicWeekDate();
                case BASIC_DATE_TIME:
                throw new IllegalArgumentException("time_zone must be UTC for format [" + format + "]");
     * Read a {@linkplain DateTimeZone} from a {@linkplain StreamInput}.
@Deprecated
                        dateTimeFormatter = currentFormatter.printer;
        /**
        formatter = formatter.withLocale(Locale.ROOT).withZone(DateTimeZone.UTC).withDefaultYear(1970);
                DateTimeFormatter dateTimeFormatter = null;
    }
                    break;
                formatName.getSnakeCaseName()
                case WEEK_DATE_TIME:
                    formatter = StrictISODateTimeFormat.dateHourMinuteSecond();
                bucket.saveField(DateTimeFieldType.hourOfDay(), dt.getHourOfDay());
                    formatter = ISODateTimeFormat.basicOrdinalDateTime();
                    formatter = ISODateTimeFormat.weekyear();
                    formatter = ISODateTimeFormat.weekyear();
import org.opensearch.common.time.DateFormatter;
    // it results in errors sent to status logger and startup to fail.
                case STRICT_WEEKYEAR_WEEK:
         * {@link DateTimeFormatter#printTo(Appendable, long, Chronology)} when using a time zone.
                    break;
    // Joda.forPattern could be used even before the logging is initialized.
            );
    public static final DateTimeFieldType QuarterOfYear = new DateTimeFieldType("quarterOfYear") {
                );
                    formatter = StrictISODateTimeFormat.hour();
        public EpochTimeParser(boolean hasMilliSecondPrecision) {
 * under the License.
                }
                    break;
import org.joda.time.DurationFieldType;
        DateTimeFormatter formatter;
                    formatter = ISODateTimeFormat.basicOrdinalDate();
                            + " in epoch time formats is deprecated and will not be supported in the next major version of OpenSearch."
            .appendLiteral('/')
                msg,
 */
                "joda-pattern-deprecation",
                    formatter = ISODateTimeFormat.dateHourMinuteSecondMillis();
                    break;
            return DurationFieldType.years();
                    break;
            return partial.getChronology()
        @Override
                case DATE_TIME:
import org.joda.time.format.DateTimeParser;
            if (hasMilliSecondPrecision) {
            .appendLiteral('/')
                case STRICT_DATE:
        }
                    parsers[i] = currentParser.getParser();
        }
            out.writeBoolean(true);
        }
                case EPOCH_SECOND:
                long millis = new BigDecimal(text).longValue() * factor;
        }
                    break;
        public void printTo(StringBuffer buf, long instant, Chronology chrono, int displayOffset, DateTimeZone displayZone, Locale locale) {
 * The OpenSearch Contributors require contributions made to
                case BASIC_WEEK_DATE_TIME:
        }
    /**
    public static DateTimeZone readTimeZone(final StreamInput in) throws IOException {
                    break;
                    break;
        }
                case STRICT_BASIC_WEEK_DATE:
            String[] formats = Strings.delimitedListToStringArray(input, "||");
            .appendLiteral('/')
                case DATE_HOUR:
            } catch (IllegalArgumentException e) {
            .appendFixedDecimal(DateTimeFieldType.monthOfYear(), 2)
    private static DeprecationLogger getDeprecationLogger() {
            throws IOException {
                    break;
                    formatter = StrictISODateTimeFormat.basicWeekDateTimeNoMillis();
                case HOUR:
                    getDeprecationLogger().deprecate(
                case STRICT_ORDINAL_DATE:
                    formatter = StrictISODateTimeFormat.tTimeNoMillis();
    public static class EpochTimePrinter implements DateTimePrinter {
                    }
        // formatName is already resolved above via FormatNames.forName(input); switch on the enum directly.
            }
            .appendLiteral(' ')
import java.io.IOException;
                    formatter = ISODateTimeFormat.weekDateTime();
                    break;
/*
        if (JodaDeprecationPatterns.isDeprecatedPattern(format)) {
            .appendLiteral('/')
                    formatter = ISODateTimeFormat.yearMonth();
                case DATE_HOUR_MINUTE_SECOND:
                    formatter = ISODateTimeFormat.weekDate();
                    break;
            return DateTimeZone.forID(in.readString());
    );
import org.joda.time.ReadablePartial;
                        "Use of negative values"
    public static void writeOptionalTimeZone(final StreamOutput out, final DateTimeZone timeZone) throws IOException {
        private boolean hasMilliSecondPrecision;
            String suggestion = JodaDeprecationPatterns.formatSuggestion(format);
            } catch (Exception e) {
                case STRICT_DATE_HOUR_MINUTE_SECOND_FRACTION:
     */
                    break;
                        input,
                bucket.saveField(DateTimeFieldType.secondOfMinute(), dt.getSecondOfMinute());
                    break;
                + "Use snake case name {} instead.";
                case BASIC_TIME:
import org.joda.time.field.DividedDateTimeField;
                case STRICT_HOUR_MINUTE:
            } else {
                case BASIC_T_TIME:
            return hasMilliSecondPrecision ? 19 : 16;
        }
        if (timeZone == null) {
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
        private long getDateTimeMillis(ReadablePartial partial) {
        }
                    formatter = ISODateTimeFormat.tTime();
        DateTimeFormatter formatter = builder.toFormatter().withLocale(Locale.ROOT).withZone(DateTimeZone.UTC).withDefaultYear(1970);
                    formatter = StrictISODateTimeFormat.dateHourMinuteSecondFraction();
     * Epoch timer printer
                    // this sucks we should use the root local by default and not be dependent on the node
 * this file be licensed under the Apache-2.0 license or a
            this.hasMilliSecondPrecision = hasMilliSecondPrecision;
            }
    private static final LazyInitializable<DeprecationLogger, RuntimeException> deprecationLogger = new LazyInitializable(
        @Override
 * license agreements. See the NOTICE file distributed with
                case STRICT_DATE_HOUR_MINUTE_SECOND:
                case BASIC_WEEK_DATE:
                buf.append(String.valueOf(getDateTimeMillis(partial)));
                    break;
                default:
                case TIME_NO_MILLIS:
                    formatter = StrictISODateTimeFormat.weekyear();
                    getDeprecationLogger().deprecate(
        public int parseInto(DateTimeParserBucket bucket, String text, int position) {
                case WEEK_DATE_TIME_NO_MILLIS:
                        "epoch-scientific-notation",
import org.joda.time.format.DateTimeFormatterBuilder;
                    break;
                    formatter = ISODateTimeFormat.weekDateTimeNoMillis();
                    formatter = ISODateTimeFormat.hour();
        if (input == null || input.length() == 0) {
                // strict date formats here, must be at least 4 digits for year and two for months and two for day
 *
     * Parses a joda based pattern, including some named ones (similar to the built in Joda ISO ones).
                    break;
            throw new IllegalArgumentException("No date pattern provided");
                    break;
                case YEAR_MONTH_DAY:
    }
            );
                    break;
                    formatter = ISODateTimeFormat.hourMinuteSecond();
         * We adjust the instant by displayOffset to adjust for the offset that might have been added in
                    break;
            int minuteOfHour = partial.get(DateTimeFieldType.minuteOfHour());
    }
                    break;
                    // fall through to the pattern-based path below.
            int millisOfSecond = partial.get(DateTimeFieldType.millisOfSecond());
    }
        /**
                1
            this.hasMilliSecondPrecision = hasMilliSecondPrecision;
                DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder().append(
                    // formatName is non-null but has no Joda formatter (e.g. ISO8601, RFC3339_LENIENT, EPOCH_MICROS);
            }
            .appendFixedDecimal(DateTimeFieldType.monthOfYear(), 2)
                    formatter = ISODateTimeFormat.hourMinuteSecondMillis();
                throw new IllegalArgumentException("Invalid format: [" + input + "]: " + e.getMessage(), e);
                    formatter = StrictISODateTimeFormat.time();
 * the Apache License, Version 2.0 (the "License"); you may
                    break;
         * We adjust the instant by displayOffset to adjust for the offset that might have been added in
                    formatter = StrictISODateTimeFormat.dateHour();
                    break;
        }
                    formatter = ISODateTimeFormat.dateHourMinute();
                    break;
                case BASIC_TIME_NO_MILLIS:
            return text.length();
                    break;
public class Joda {
                    formatter = ISODateTimeFormat.hourMinute();
 * specific language governing permissions and limitations
                        .toFormatter();
                    formatter = StrictISODateTimeFormat.weekDateTimeNoMillis();
            .appendFixedSignedDecimal(DateTimeFieldType.minuteOfHour(), 2)
 *     http://www.apache.org/licenses/LICENSE-2.0
                    formatter = StrictISODateTimeFormat.hourMinuteSecond();
        @Override
                    formatter = StrictISODateTimeFormat.basicWeekDate();
                    formatter = ISODateTimeFormat.hourMinuteSecondFraction();
            return Quarters;
                    break;
                    formatter = ISODateTimeFormat.basicWeekDateTimeNoMillis();
        public DurationField getField(Chronology chronology) {
                        ISODateTimeFormat.dateTime().withLocale(Locale.ROOT).withZone(DateTimeZone.UTC).withDefaultYear(1970)
                            .withZone(DateTimeZone.UTC)
    public static class EpochTimeParser implements DateTimeParser {
                buf.append((instant - displayOffset) / 1000);
    // Hence a lazy initialization.
                    parsers
                case STRICT_DATE_HOUR:
                    formatter = StrictISODateTimeFormat.dateHourMinuteSecondMillis();
                case STRICT_DATE_OPTIONAL_TIME:
                    formatter = ISODateTimeFormat.timeNoMillis();
/**
                    break;
    public static DateTimeZone readOptionalTimeZone(final StreamInput in) throws IOException {
                case TIME:
import java.io.Writer;
                case STRICT_DATE_HOUR_MINUTE_SECOND_MILLIS:
                case STRICT_HOUR_MINUTE_SECOND_FRACTION:
                    formatter = ISODateTimeFormat.dateTime();
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder().append(
                    break;
                        "week_year_format_name",
                case BASIC_T_TIME_NO_MILLIS:
                case DATE_HOUR_MINUTE_SECOND_MILLIS:
        if (Strings.hasLength(input) && input.contains("||")) {
                out.append(String.valueOf(getDateTimeMillis(partial) / 1000));
        }
                    break;
                    break;
    }
                    break;
                case EPOCH_MILLIS:
                case BASIC_ORDINAL_DATE:
                    break;
                        input,
        public void printTo(StringBuffer buf, ReadablePartial partial, Locale locale) {
        public void printTo(Writer out, ReadablePartial partial, Locale locale) throws IOException {
        }
            new DateTimeParser[] { longFormatter.getParser(), shortFormatter.getParser(), new EpochTimeParser(true) }
            }
                case STRICT_WEEK_DATE_TIME:
import org.joda.time.format.DateTimeFormatter;
    }
                return new JodaDateFormatter(input, formatter, formatter);
            String msg = "Camel case format name {} is deprecated and will be removed in a future version. "
import org.joda.time.DateTimeField;
        () -> DeprecationLogger.getLogger(Joda.class)
                case STRICT_T_TIME:
                    break;
        public int estimatePrintedLength() {
        return null;
     * @opensearch.internal
 * this work for additional information regarding copyright
                    formatter = ISODateTimeFormat.basicOrdinalDateTimeNoMillis();
                if (scientificNotation.matcher(text).find()) {
                    break;
                        "epoch-negative",
     */
            } else if (isPositive && isTooLong) {
                case ORDINAL_DATE_TIME_NO_MILLIS:
                    formatter = StrictISODateTimeFormat.hourMinuteSecondMillis();
                DateTime dt = new DateTime(millis, DateTimeZone.UTC);
                case STRICT_TIME:
                    formatter = ISODateTimeFormat.dateHour();
                            .withDefaultYear(1970),
package org.opensearch.common.joda;
        );
 * Licensed to Elasticsearch under one or more contributor
                formatName.getCamelCaseName(),
                    break;
        }
    }
                case BASIC_ORDINAL_DATE_TIME:
                    formatter = ISODateTimeFormat.basicTimeNoMillis();
            return new OffsetDateTimeField(
                    break;
            getDeprecationLogger().deprecate(
                case BASIC_DATE_TIME_NO_MILLIS:
                            + " in epoch time formats is deprecated and will not be supported in the next major version of OpenSearch."
                    break;
        @Override
        public int estimateParsedLength() {
                    formatter = new DateTimeFormatterBuilder().append(new EpochTimePrinter(false), new EpochTimeParser(false))
        // 2014/10/10 12:12:12
        @Override
                    break;
     * parses epcoch timers
                    break;
        @Override
    /**
     * Read an optional {@linkplain DateTimeZone}.
                    formatter = StrictISODateTimeFormat.dateTimeNoMillis();
        @Override
                    formatter = ISODateTimeFormat.ordinalDateTimeNoMillis();
                    formatter = ISODateTimeFormat.date();
                    formatter = StrictISODateTimeFormat.weekDateTime();
            int firstDotIndex = text.indexOf('.');
     *
                case YEAR_MONTH:
                case HOUR_MINUTE_SECOND_FRACTION:
                    break;
 * @deprecated
                case T_TIME_NO_MILLIS:
                case HOUR_MINUTE:
                case STRICT_BASIC_WEEK_DATE_TIME:
                    break;
        public EpochTimePrinter(boolean hasMilliSecondPrecision) {
                case STRICT_YEAR_MONTH:
 *
 */
            boolean isTooLong = (firstDotIndex == -1 ? text.length() : firstDotIndex) > estimateParsedLength();
        public DateTimeField getField(Chronology chronology) {
                    formatter = ISODateTimeFormat.basicTTime();
            int dayOfMonth = partial.get(DateTimeFieldType.dayOfMonth());
    };
                bucket.setZone(DateTimeZone.UTC);
                    break;
        } else {
        return new JodaDateFormatter(input, formatter, formatter);
                    break;
import org.opensearch.core.common.io.stream.StreamOutput;
        }
                case STRICT_WEEKYEAR_WEEK_DAY:
            } else {
                    formatter = StrictISODateTimeFormat.ordinalDateTime();
                case STRICT_WEEK_DATE_TIME_NO_MILLIS:
                    );
            int secondOfMinute = partial.get(DateTimeFieldType.secondOfMinute());
                    break;
                    JodaDateFormatter currentFormatter = forPattern(formats[i]);
                    formatter = ISODateTimeFormat.year();
                // check for deprecations, but after it has parsed correctly so invalid values aren't counted as deprecated
                    break;
            .toFormatter()
                    formatter = ISODateTimeFormat.dateHourMinuteSecond();
                case WEEK_DATE:
                String format = hasMilliSecondPrecision ? "epoch_millis" : "epoch_second";
            } else {
                    DateTimeFormatter currentParser = currentFormatter.parser;
            .appendFixedDecimal(DateTimeFieldType.dayOfMonth(), 2)
                    break;
                    );
                case STRICT_DATE_HOUR_MINUTE:
 * Joda class.
                    break;
                    formatter = ISODateTimeFormat.ordinalDateTime();
                    formatter = StrictISODateTimeFormat.hourMinuteSecondFraction();
                    // in this case, we have a separate parser and printer since the dataOptionalTimeParser can't print
            getDeprecationLogger().deprecate(
                case WEEKYEAR_WEEK_DAY:
            int year = partial.get(DateTimeFieldType.year());
                if (millis < 0) {
         * {@link DateTimeFormatter#printTo(Appendable, long, Chronology)} when using a time zone.
                    formatter = ISODateTimeFormat.time();
                    break;
 *
        @Override
                buf.append(instant - displayOffset);
        }
                case STRICT_YEAR:
                    formatter = ISODateTimeFormat.dateHourMinuteSecondFraction();
                    formatter = StrictISODateTimeFormat.dateTime();
                    formatter = StrictISODateTimeFormat.timeNoMillis();
                    break;
                    formatter = StrictISODateTimeFormat.weekyearWeekDay();
                        "Format name \"week_year\" is deprecated and will be removed in a future version. Use \"weekyear\" format instead"
                case STRICT_WEEKYEAR:
            }
                formatter = forPattern(input).parser;
            DateTimeParser[] parsers = new DateTimeParser[formats.length];
                    dateTimeFormatter.withZone(DateTimeZone.UTC).getPrinter(),
                    formatter = ISODateTimeFormat.basicTime();
                case T_TIME:
            .appendFixedSignedDecimal(DateTimeFieldType.hourOfDay(), 2)
            int factor = hasMilliSecondPrecision ? 1 : 1000;
                bucket.saveField(DateTimeFieldType.millisOfSecond(), dt.getMillisOfSecond());
            return new ScaledDurationField(chronology.months(), Quarters, 3);
                            .withLocale(Locale.ROOT)
                case STRICT_DATE_TIME_NO_MILLIS:
                    formatter = StrictISODateTimeFormat.date();
 */
                case STRICT_DATE_TIME:
            return hasMilliSecondPrecision ? 19 : 16;
                    formatter = ISODateTimeFormat.dateTimeNoMillis();
                    break;
                    break;
                    break;
            longFormatter.withZone(DateTimeZone.UTC).getPrinter(),
                    formatter = ISODateTimeFormat.basicDateTimeNoMillis();
        if (Strings.hasLength(input)) {
                    formatter = StrictISODateTimeFormat.ordinalDate();
import org.opensearch.common.time.FormatNames;
 * compatible open source license.
            if (hasMilliSecondPrecision) {
        DateTimeFormatter shortFormatter = new DateTimeFormatterBuilder().appendFixedDecimal(DateTimeFieldType.year(), 4)
                    // in this case, we have a separate parser and printer since the dataOptionalTimeParser can't print
import org.joda.time.field.ScaledDurationField;
            if (bucket.getZone() != DateTimeZone.UTC) {
                    formatter = ISODateTimeFormat.yearMonthDay();
                    break;
/*
import java.util.Locale;
    private static void maybeLogJodaDeprecation(String format) {
