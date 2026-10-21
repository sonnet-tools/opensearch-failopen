    ) {
        Boolean canCacheLastParsedFormatter
import java.time.temporal.ChronoField;
        if (format.contains("||") == false) {
    public static DateFormatter combined(
 *
            assert formatter instanceof JavaDateFormatter;
        }
    };
        String printFormat,
    /**
        String format,
    private static final BiConsumer<DateTimeFormatterBuilder, DateTimeFormatter> ROUND_UP_BASE_FIELDS = (builder, parser) -> {
     */
    }
 * Unless required by applicable law or agreed to in writing,
        );
            return roundUpParsers;
 * ownership. Elasticsearch licenses this file to you under
    public String printPattern() {
    public TemporalAccessor parse(String input) {
        return roundupParser;
            super(format, firstFrom(roundUpParsers), null, roundUpParsers);
        List<OpenSearchDateTimeFormatter> parsers = new ArrayList<>(
        List<OpenSearchDateTimeFormatter> roundUpParsers,
     * https://bugs.openjdk.java.net/browse/JDK-8188771
    @Override
        if (zoneId.equals(zone())) {
    }
        String format,
    }
        String parserString = parser.toString();
        return new JavaDateFormatter(
     * || is not expected to be provided as format when a RoundUp formatter is created. It will be splitted before in
                    lastParsedformatter = formatter;
        String input,
     * which does not throw exceptions when parsing failed.
    }
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;
    }
        this(format, format, wrapFormatter(printer), false, wrapAllFormatters(parsers));
            builder.parseDefaulting(ChronoField.MONTH_OF_YEAR, 1L);
import java.time.temporal.TemporalAccessor;
 * Licensed to Elasticsearch under one or more contributor
        String printFormat,
        }
        OpenSearchDateTimePrinter printer,
    }
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object obj) {
        }
    }
    private final String format;
        }
    private JavaDateFormatter(
import java.util.function.BiConsumer;
                ParsePosition pos = new ParsePosition(0);
        }
            JavaDateFormatter javaDateFormatter = (JavaDateFormatter) formatter;
    ) {
     * Attempt parsing the input without throwing exception. If multiple parsers are provided,
            canCacheLastParsedFormatter & FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING_SETTING)
            roundUpParsers,
    static class RoundUpFormatter extends JavaDateFormatter {
        DateTimeFormatter... parsers
        BiConsumer<DateTimeFormatterBuilder, DateTimeFormatter> roundupParserConsumer,
     * @throws DateTimeParseException when unable to parse with any parsers
        return new JavaDateFormatter(format, printFormat, printer.withZone(zoneId), roundUpParsers, parsers, canCacheLastParsedFormatter);
        List<OpenSearchDateTimeFormatter> roundUpParsers,
                }
        return this.parsers.get(0).parse(input);
        if (distinctZones > 1) {
        long distinctZones = Arrays.stream(parsers).map(OpenSearchDateTimeFormatter::getZone).distinct().count();
            }
        List<OpenSearchDateTimeFormatter> parsers = new ArrayList<>(formatters.size());
    public ZoneId zone() {
                }
    // base fields which should be used for default parsing, when we round up for date math
            throw new IllegalArgumentException("failed to parse date field [" + input + "] with format [" + format + "]", e);
            return this;
     * <p>
    ) {
                DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;
            .stream()
 * compatible open source license.
        ROUND_UP_GENERIC_BASE_FIELDS.put(ChronoField.NANO_OF_SECOND, 999_999_999L);
    JavaDateFormatter getRoundupParser() {
 * software distributed under the License is distributed on an
        return object != null && pos.getIndex() == input.length();
        this.printer = printer;
    @Override
        }
                object = lastParsedformatter.parseObject(input, pos);
 */
        }
    private boolean parsingSucceeded(Object object, String input, ParsePosition pos) {
     * This also means that this method depends on <code>DateTimeFormatter.ClassicFormat.parseObject</code>
    ) {
        if (parsers.size() > 1) {
        if (printer == null) {
        OpenSearchDateTimePrinter printer,
        } else {
        String format,
    /**
            parsers,
    }
        return this.printer.getZone();
        this(format, format, printer, roundUpParsers, parsers, false);
            throw new IllegalArgumentException("formatters must have the same locale");
    ) {
    Collection<OpenSearchDateTimeFormatter> getParsers() {
}
        return new JavaDateMathParser(format, this, getRoundupParser());
    }
        try {
        @Override
            printer,
    public DateFormatter withLocale(Locale locale) {
/*
        assert formatters.size() > 0;
    }
import java.util.Arrays;
     * @return a TemporalAccessor if parsing was successful.
    }
import org.opensearch.common.util.FeatureFlags;
        List<OpenSearchDateTimeFormatter> parsers
        if (Strings.isNullOrEmpty(input)) {
    ) {
    }
        this.printFormat = printFormat;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            throw new DateTimeParseException("Failed to parse with all enclosed parsers", input, 0);
        String printFormat,
            javaPrintFormatter.format,
    OpenSearchDateTimePrinter getPrinter() {
 * license agreements. See the NOTICE file distributed with
        this.format = format;
    private TemporalAccessor doParse(String input) {
    private final JavaDateFormatter roundupParser;
    @Override
    private static OpenSearchDateTimeFormatter[] wrapAllFormatters(DateTimeFormatter... formatters) {
                ParsePosition pos = new ParsePosition(0);
                DateTimeFormatter parser = customparser.getFormatter();
        this.roundupParser = new RoundUpFormatter(format, wrapAllFormatters(roundUp));
        }
import java.util.Collection;
            throw new IllegalArgumentException("cannot parse empty date");
    public DateFormatter withZone(ZoneId zoneId) {
    /**
            && Objects.equals(this.printer.getZone(), other.printer.getZone());
        this.printer = printer;
        String format,
            throw new UnsupportedOperationException("RoundUpFormatter does not have another roundUpFormatter");
    private final String printFormat;
        List<DateFormatter> formatters,
            for (OpenSearchDateTimeFormatter formatter : parsers) {
            && Objects.equals(locale(), other.locale())
            this.parsers.stream().map(p -> p.withZone(zoneId)).collect(Collectors.toList())
/*
    JavaDateFormatter(String format, OpenSearchDateTimePrinter printer, OpenSearchDateTimeFormatter... parsers) {
     * JavaDateFormatter created with a custom format like <code>DateFormatter.forPattern("YYYY")</code> will only have one parser
 * You may obtain a copy of the License at
        // shortcurt to not create new objects unnecessarily
        if (parserString.contains(ChronoField.DAY_OF_YEAR.toString())) {
        RoundUpFormatter(String format, List<OpenSearchDateTimeFormatter> roundUpParsers) {
        List<OpenSearchDateTimeFormatter> roundUpParsers = new ArrayList<>(formatters.size());
    private static List<OpenSearchDateTimeFormatter> wrapAllFormatters(List<DateTimeFormatter> formatters) {
        List<DateTimeFormatter> roundUpParsers,
        List<OpenSearchDateTimeFormatter> roundUpParsers = this.roundupParser.getParsers()
    JavaDateFormatter(
class JavaDateFormatter implements DateFormatter {
                roundupParserConsumer.accept(builder, parser);
            for (OpenSearchDateTimeFormatter customparser : this.parsers) {
        this.canCacheLastParsedFormatter = canCacheLastParsedFormatter;
        private static OpenSearchDateTimeFormatter firstFrom(List<OpenSearchDateTimeFormatter> roundUpParsers) {
        DateTimeFormatter printer,
            parsers.addAll(javaDateFormatter.getParsers());
        String format,
            .map(p -> p.withZone(zoneId))
import java.util.Objects;
        this(format, format, wrapFormatter(printer), wrapAllFormatters(roundUpParsers), wrapAllFormatters(parsers), false);
        assert printFormatter instanceof JavaDateFormatter;
    }
    @Override
        ROUND_UP_GENERIC_BASE_FIELDS.put(ChronoField.MINUTE_OF_HOUR, 59L);
     */
     * @opensearch.internal
        this(format, printFormat, printer, ROUND_UP_BASE_FIELDS, canCacheLastParsedFormatter, parsers);
 * GitHub history for details.
        return printer.format(DateFormatters.from(accessor));
     * @param input An arbitrary string resembling the string representation of a date or time
     * <code>DateFormatters</code>.
        return null;
            this.parsers = Arrays.asList(parsers);
            return roundUpParsers.get(0);
     * It is however possible to have a JavaDateFormatter with multiple parsers. For instance see a "date_time" formatter in
        String format,
            if (canCacheLastParsedFormatter && lastParsedformatter != null) {
            }
        return new OpenSearchDateTimeFormatter(formatter);
 * SPDX-License-Identifier: Apache-2.0
        ROUND_UP_GENERIC_BASE_FIELDS.put(ChronoField.HOUR_OF_DAY, 23L);
        }
            .map(p -> p.withLocale(locale))
        ); // check if caching is enabled
        }
        JavaDateFormatter other = (JavaDateFormatter) obj;
        OpenSearchDateTimePrinter printer,
    public int hashCode() {
            return this;
import java.time.ZoneId;
    @Override
        return String.format(Locale.ROOT, "format[%s] locale[%s]", format, locale());
    private JavaDateFormatter(
import java.util.ArrayList;
    ) {
        this(format, format, printer, false, parsers);
        this.parsers = parsers;
        }
    private JavaDateFormatter(
                builder.append(parser);
        List<OpenSearchDateTimeFormatter> parsers,
        // shortcurt to not create new objects unnecessarily
            Object object = null;
        JavaDateFormatter javaPrintFormatter = (JavaDateFormatter) printFormatter;
    }
    }
        return printFormat;
                    return (TemporalAccessor) object;
                if (parsingSucceeded(object, input, pos)) {
            throw new IllegalArgumentException("formatters must have the same time zone");
        }
    }
     * patterns. Joda does not suffer from this.
import java.util.List;
    public Locale locale() {
    }
        this.roundupParser = roundUpParsers != null ? new RoundUpFormatter(format, roundUpParsers) : null;
        Boolean canCacheLastParsedFormatter
        String format,
        return Objects.hash(locale(), printer.getZone(), format);
        BiConsumer<DateTimeFormatterBuilder, DateTimeFormatter> roundupParserConsumer,
    }
import java.time.format.DateTimeFormatterBuilder;
        } else {
 * this work for additional information regarding copyright
        return parsers;
 *     http://www.apache.org/licenses/LICENSE-2.0
    ) {
package org.opensearch.common.time;
            }
 *
    }
    public String format(TemporalAccessor accessor) {
import java.util.Locale;
 * specific language governing permissions and limitations
import java.util.HashMap;
        BiConsumer<DateTimeFormatterBuilder, DateTimeFormatter> roundupParserConsumer
 *
 */
        this.format = format;
    JavaDateFormatter(
    }
                roundUpParsers.add(builder.toFormatter(locale()));
        } catch (DateTimeException e) {
        long distinctLocales = Arrays.stream(parsers).map(OpenSearchDateTimeFormatter::getLocale).distinct().count();
    private volatile OpenSearchDateTimeFormatter lastParsedformatter = null;
 */
     * <code>DateFormatter.forPattern</code>
            List<DateTimeFormatter> roundUpParsers = new ArrayList<>();
    {
import java.util.Collections;
            return false;
        if (locale.equals(locale())) {
    // named formatters use default roundUpParser
import java.time.DateTimeException;
    }
     * it will continue iterating if the previous parser failed. The pattern must fully match, meaning whole input was used.
            .stream()
import org.opensearch.core.common.Strings;
    }
            throw new IllegalArgumentException("printer may not be null");
        for (DateFormatter formatter : formatters) {
        if (obj.getClass().equals(this.getClass()) == false) {
    private static OpenSearchDateTimeFormatter wrapFormatter(DateTimeFormatter formatter) {
        return formatters.stream().map(JavaDateFormatter::wrapFormatter).collect(Collectors.toList());
    private static final Map<TemporalField, Long> ROUND_UP_GENERIC_BASE_FIELDS = new HashMap<>(4);
    }
            return doParse(input);
        JavaDateFormatter getRoundupParser() {
        this.canCacheLastParsedFormatter = canCacheLastParsedFormatter;
    JavaDateFormatter(
 * The OpenSearch Contributors require contributions made to
    }
    }
        this.printFormat = printFormat;
        return Objects.equals(format, other.format)
            roundUpParsers.addAll(javaDateFormatter.getRoundupParser().getParsers());
    }
    }
    private final Boolean canCacheLastParsedFormatter;
    @Override
import java.time.format.DateTimeFormatter;
        }
    }
    }
        List<OpenSearchDateTimeFormatter> parsers = new ArrayList<>(
                object = formatter.parseObject(input, pos);
            .collect(Collectors.toList());
    private final List<OpenSearchDateTimeFormatter> parsers;
            .collect(Collectors.toList());
    JavaDateFormatter(String format, DateTimeFormatter printer, DateTimeFormatter... parsers) {
    private List<DateTimeFormatter> createRoundUpParser(
    }
        DateTimeFormatter printer,
        List<OpenSearchDateTimeFormatter> roundUpParsers = this.roundupParser.getParsers()
 * the Apache License, Version 2.0 (the "License"); you may
        return format;
    public DateMathParser toDateMathParser() {
        if (distinctLocales > 1) {
        ROUND_UP_GENERIC_BASE_FIELDS.put(ChronoField.SECOND_OF_MINUTE, 59L);
    }
        OpenSearchDateTimeFormatter... parsers
        return this.printer.getLocale();
import java.text.ParsePosition;
    @Override
        ROUND_UP_GENERIC_BASE_FIELDS.forEach(builder::parseDefaulting);
     * The approach with collection of parsers was taken because java-time requires ordering on optional (composite)
    @Override
        DateFormatter printFormatter,
        OpenSearchDateTimePrinter printer = javaPrintFormatter.getPrinter();
 * this file be licensed under the Apache-2.0 license or a
        Boolean canCacheLastParsedFormatter,
    public String pattern() {
            input,
            this.parsers = Collections.singletonList((OpenSearchDateTimeFormatter) printer);
                    return (TemporalAccessor) object;
        List<DateTimeFormatter> parsers
        }
        OpenSearchDateTimePrinter printer,
        );
        OpenSearchDateTimeFormatter... parsers
    @Override
     *
    }
    public String toString() {
     */
     * A round up formatter
        return printer;
        Boolean canCacheLastParsedFormatter,
 * not use this file except in compliance with the License.
        if (parsers.length == 0) {
    // subclasses override roundUpParser
     * This is when the RoundUp Formatters are created. In further merges (with ||) it will only append them to a list.
                if (parsingSucceeded(object, input, pos)) {
        }
     * This means that we need to also have multiple RoundUp parsers.
            builder.parseDefaulting(ChronoField.DAY_OF_YEAR, 1L);
import java.time.temporal.TemporalField;
        assert printFormatter != null;
        return Arrays.stream(formatters).map(JavaDateFormatter::wrapFormatter).toArray(OpenSearchDateTimeFormatter[]::new);
            builder.parseDefaulting(ChronoField.DAY_OF_MONTH, 1L);
        }
        return new JavaDateFormatter(format, printFormat, printer.withLocale(locale), roundUpParsers, parsers, canCacheLastParsedFormatter);
        List<DateTimeFormatter> roundUp = createRoundUpParser(format, roundupParserConsumer);
            this.parsers.stream().map(p -> p.withLocale(locale)).collect(Collectors.toList())
        this(format, format, wrapFormatter(printer), roundupParserConsumer, false, wrapAllFormatters(parsers));
    @Override
    @Override
    private final OpenSearchDateTimePrinter printer;
/*
    @Override
 * under the License.
     *
