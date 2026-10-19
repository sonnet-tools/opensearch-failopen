import java.util.Locale;
        return new JavaDateFormatter(
                object = lastParsedformatter.parseObject(input, pos);
            input,  
        // shortcurt to not create new objects unnecessarily  
        return new JavaDateMathParser(format, this, getRoundupParser());  
            List<DateTimeFormatter> roundUpParsers = new ArrayList<>();  
        String printFormat,  
        } catch (DateTimeException e) {
        this.printer = printer;
    private final OpenSearchDateTimePrinter printer;  
        String format,
                if (parsingSucceeded(object, input, pos)) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ); // check if caching is enabled  
    private JavaDateFormatter(  
    public String printPattern() {
        }  
        return format;
    public TemporalAccessor parse(String input) {
    ) {
    OpenSearchDateTimePrinter getPrinter() {
     */
        assert formatters.size() > 0;
        }
     * <p>  
        if (printer == null) {  
import java.util.Collections;
        OpenSearchDateTimeFormatter... parsers  
        if (format.contains("||") == false) {
                if (parsingSucceeded(object, input, pos)) {
    ) {
            }
    }
            return this;  
        ROUND_UP_GENERIC_BASE_FIELDS.put(ChronoField.MINUTE_OF_HOUR, 59L);
    }  
    }
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
    public DateFormatter withLocale(Locale locale) {  
        DateTimeFormatter printer,  
import org.opensearch.core.common.Strings;
    }
        Boolean canCacheLastParsedFormatter,  
 * KIND, either express or implied.  See the License for the
        ROUND_UP_GENERIC_BASE_FIELDS.put(ChronoField.NANO_OF_SECOND, 999_999_999L);
    JavaDateFormatter(String format, DateTimeFormatter printer, DateTimeFormatter... parsers) {
            if (canCacheLastParsedFormatter && lastParsedformatter != null) {  
        JavaDateFormatter getRoundupParser() {
     * A round up formatter
        return new JavaDateFormatter(format, printFormat, printer.withLocale(locale), roundUpParsers, parsers, canCacheLastParsedFormatter);  
    public int hashCode() {
    private boolean parsingSucceeded(Object object, String input, ParsePosition pos) {  
 *  
 * Modifications Copyright OpenSearch Contributors. See
        }  
import java.time.ZoneId;  
        List<OpenSearchDateTimeFormatter> parsers
     * https://bugs.openjdk.java.net/browse/JDK-8188771  
            throw new UnsupportedOperationException("RoundUpFormatter does not have another roundUpFormatter");
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        List<OpenSearchDateTimeFormatter> parsers = new ArrayList<>(
                DateTimeFormatter parser = customparser.getFormatter();
 */  
            parsers,
        this(format, format, wrapFormatter(printer), false, wrapAllFormatters(parsers));  
 * The OpenSearch Contributors require contributions made to  
        String format,
    private volatile OpenSearchDateTimeFormatter lastParsedformatter = null;
 * GitHub history for details.
     * which does not throw exceptions when parsing failed.
    public String pattern() {  
    }
                ParsePosition pos = new ParsePosition(0);
            this.parsers.stream().map(p -> p.withZone(zoneId)).collect(Collectors.toList())
    JavaDateFormatter(String format, OpenSearchDateTimePrinter printer, OpenSearchDateTimeFormatter... parsers) {  
        this.printFormat = printFormat;  
    private static OpenSearchDateTimeFormatter[] wrapAllFormatters(DateTimeFormatter... formatters) {
import java.time.temporal.TemporalField;  
                object = formatter.parseObject(input, pos);  
                }
        if (zoneId.equals(zone())) {
    }
        long distinctLocales = Arrays.stream(parsers).map(OpenSearchDateTimeFormatter::getLocale).distinct().count();
        if (distinctLocales > 1) {
        OpenSearchDateTimePrinter printer = javaPrintFormatter.getPrinter();  
    }
            && Objects.equals(locale(), other.locale())
     * JavaDateFormatter created with a custom format like <code>DateFormatter.forPattern("YYYY")</code> will only have one parser
                    return (TemporalAccessor) object;
        return new OpenSearchDateTimeFormatter(formatter);
 */  
import java.util.Arrays;
package org.opensearch.common.time;
        assert printFormatter instanceof JavaDateFormatter;
        List<OpenSearchDateTimeFormatter> parsers,
    }
        this.printFormat = printFormat;
    @Override  
            throw new IllegalArgumentException("failed to parse date field [" + input + "] with format [" + format + "]", e);  
    }
        List<OpenSearchDateTimeFormatter> roundUpParsers = this.roundupParser.getParsers()
     */  
     * Attempt parsing the input without throwing exception. If multiple parsers are provided,
                roundUpParsers.add(builder.toFormatter(locale()));  
    }
    {  
     * This is when the RoundUp Formatters are created. In further merges (with ||) it will only append them to a list.
            .map(p -> p.withZone(zoneId))  
    }  
    JavaDateFormatter getRoundupParser() {
        String input,
    ) {  
    private JavaDateFormatter(
    @Override  
            this.parsers = Collections.singletonList((OpenSearchDateTimeFormatter) printer);
        }  
    /**
        }
        if (parserString.contains(ChronoField.DAY_OF_YEAR.toString())) {  
        );
        DateFormatter printFormatter,
            javaPrintFormatter.format,
 * ownership. Elasticsearch licenses this file to you under  
        String format,
        return String.format(Locale.ROOT, "format[%s] locale[%s]", format, locale());
        this(format, format, wrapFormatter(printer), wrapAllFormatters(roundUpParsers), wrapAllFormatters(parsers), false);
            throw new IllegalArgumentException("formatters must have the same time zone");
            .collect(Collectors.toList());
                DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();  
        return Objects.equals(format, other.format)  
        this(format, printFormat, printer, ROUND_UP_BASE_FIELDS, canCacheLastParsedFormatter, parsers);
    }
     *
        return parsers;
 *
 * specific language governing permissions and limitations
    }
    private final String format;
    @Override  
        for (DateFormatter formatter : formatters) {
    public DateMathParser toDateMathParser() {
            throw new IllegalArgumentException("printer may not be null");
            super(format, firstFrom(roundUpParsers), null, roundUpParsers);
        assert printFormatter != null;
    private JavaDateFormatter(
            }
    @Override
        // shortcurt to not create new objects unnecessarily
            .stream()  
            canCacheLastParsedFormatter & FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING_SETTING)
    }
        this.roundupParser = new RoundUpFormatter(format, wrapAllFormatters(roundUp));
        ROUND_UP_GENERIC_BASE_FIELDS.put(ChronoField.SECOND_OF_MINUTE, 59L);  
     * The approach with collection of parsers was taken because java-time requires ordering on optional (composite)
     * This also means that this method depends on <code>DateTimeFormatter.ClassicFormat.parseObject</code>
    }  
            JavaDateFormatter javaDateFormatter = (JavaDateFormatter) formatter;  
        return Objects.hash(locale(), printer.getZone(), format);
        if (Strings.isNullOrEmpty(input)) {
        Boolean canCacheLastParsedFormatter  
            roundUpParsers.addAll(javaDateFormatter.getRoundupParser().getParsers());
            throw new IllegalArgumentException("formatters must have the same locale");  
    public String toString() {  
    private List<DateTimeFormatter> createRoundUpParser(
        } else {
        }  
        JavaDateFormatter other = (JavaDateFormatter) obj;
    ) {  
            for (OpenSearchDateTimeFormatter customparser : this.parsers) {
    @Override
        @Override  
     * @opensearch.internal  
        this.canCacheLastParsedFormatter = canCacheLastParsedFormatter;
 * under the License.  
    private final String printFormat;
        OpenSearchDateTimePrinter printer,
    }  
            throw new DateTimeParseException("Failed to parse with all enclosed parsers", input, 0);
        this(format, format, printer, roundUpParsers, parsers, false);
        ROUND_UP_GENERIC_BASE_FIELDS.forEach(builder::parseDefaulting);  
 *
    JavaDateFormatter(
    }
    @Override
    private TemporalAccessor doParse(String input) {  
        OpenSearchDateTimePrinter printer,
        OpenSearchDateTimePrinter printer,  
    }
        OpenSearchDateTimePrinter printer,  
        }
        if (locale.equals(locale())) {
        this.format = format;
     * <code>DateFormatters</code>.
        private static OpenSearchDateTimeFormatter firstFrom(List<OpenSearchDateTimeFormatter> roundUpParsers) {
        String printFormat,  
        List<OpenSearchDateTimeFormatter> parsers = new ArrayList<>(formatters.size());
        if (distinctZones > 1) {
     * <code>DateFormatter.forPattern</code>
    }
        BiConsumer<DateTimeFormatterBuilder, DateTimeFormatter> roundupParserConsumer,
        List<DateTimeFormatter> parsers
    ) {
    }  
        List<OpenSearchDateTimeFormatter> roundUpParsers,
        }  
            builder.parseDefaulting(ChronoField.MONTH_OF_YEAR, 1L);  
            .map(p -> p.withLocale(locale))
        return roundupParser;
            return roundUpParsers.get(0);  
    // named formatters use default roundUpParser  
    /**  
    ) {
    }
    @Override
import java.util.ArrayList;
        String parserString = parser.toString();
    ) {  
        String format,
import java.time.temporal.ChronoField;
import java.util.Collection;  
        return object != null && pos.getIndex() == input.length();
 * this work for additional information regarding copyright
        return formatters.stream().map(JavaDateFormatter::wrapFormatter).collect(Collectors.toList());
        return printer;  
                roundupParserConsumer.accept(builder, parser);
        return Arrays.stream(formatters).map(JavaDateFormatter::wrapFormatter).toArray(OpenSearchDateTimeFormatter[]::new);  
    private final Boolean canCacheLastParsedFormatter;  
        RoundUpFormatter(String format, List<OpenSearchDateTimeFormatter> roundUpParsers) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        String format,
            return doParse(input);
    public String format(TemporalAccessor accessor) {
    public DateFormatter withZone(ZoneId zoneId) {
            .collect(Collectors.toList());
/*  
    }  
    private static final BiConsumer<DateTimeFormatterBuilder, DateTimeFormatter> ROUND_UP_BASE_FIELDS = (builder, parser) -> {
     */
        Boolean canCacheLastParsedFormatter,
        return printFormat;  
        }
        if (obj.getClass().equals(this.getClass()) == false) {
        }
 * compatible open source license.
        long distinctZones = Arrays.stream(parsers).map(OpenSearchDateTimeFormatter::getZone).distinct().count();  
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;
        JavaDateFormatter javaPrintFormatter = (JavaDateFormatter) printFormatter;
import java.util.List;  
        DateTimeFormatter... parsers
            }  
    Collection<OpenSearchDateTimeFormatter> getParsers() {
        if (parsers.length == 0) {
        List<OpenSearchDateTimeFormatter> roundUpParsers = this.roundupParser.getParsers()
    public ZoneId zone() {  
            for (OpenSearchDateTimeFormatter formatter : parsers) {
                builder.append(parser);
            assert formatter instanceof JavaDateFormatter;
        }
        DateTimeFormatter printer,  
        return new JavaDateFormatter(format, printFormat, printer.withZone(zoneId), roundUpParsers, parsers, canCacheLastParsedFormatter);
        this(format, format, wrapFormatter(printer), roundupParserConsumer, false, wrapAllFormatters(parsers));
import java.text.ParsePosition;
 * Licensed to Elasticsearch under one or more contributor  
    public static DateFormatter combined(
    ) {  
class JavaDateFormatter implements DateFormatter {
        return this.printer.getZone();
        return this.parsers.get(0).parse(input);  
        String printFormat,
     * @param input An arbitrary string resembling the string representation of a date or time
import java.time.temporal.TemporalAccessor;
        String format,
     *
        }  
    }  
        List<DateFormatter> formatters,  
 * not use this file except in compliance with the License.
            this.parsers.stream().map(p -> p.withLocale(locale)).collect(Collectors.toList())  
     * This means that we need to also have multiple RoundUp parsers.
    private final List<OpenSearchDateTimeFormatter> parsers;
        return null;
    }
    @Override  
        this(format, format, printer, false, parsers);
     * || is not expected to be provided as format when a RoundUp formatter is created. It will be splitted before in  
import java.time.format.DateTimeFormatterBuilder;
        String format,
        }
    private static List<OpenSearchDateTimeFormatter> wrapAllFormatters(List<DateTimeFormatter> formatters) {  
                    lastParsedformatter = formatter;
        this.printer = printer;
        this.parsers = parsers;  
        List<DateTimeFormatter> roundUpParsers,
 * license agreements. See the NOTICE file distributed with
            return roundUpParsers;
    // subclasses override roundUpParser  
            this.parsers = Arrays.asList(parsers);
            .stream()
    }
    static class RoundUpFormatter extends JavaDateFormatter {
        Boolean canCacheLastParsedFormatter
        } else {  
import java.util.Map;
    }  
            throw new IllegalArgumentException("cannot parse empty date");  
    public boolean equals(Object obj) {  
    @Override
            return this;
        List<OpenSearchDateTimeFormatter> roundUpParsers,
    @Override
     * it will continue iterating if the previous parser failed. The pattern must fully match, meaning whole input was used.  
import java.time.format.DateTimeFormatter;
    JavaDateFormatter(
            printer,
     * patterns. Joda does not suffer from this.
    private static OpenSearchDateTimeFormatter wrapFormatter(DateTimeFormatter formatter) {
        this.format = format;  
/*
        OpenSearchDateTimeFormatter... parsers
     * It is however possible to have a JavaDateFormatter with multiple parsers. For instance see a "date_time" formatter in  
 * You may obtain a copy of the License at  
            && Objects.equals(this.printer.getZone(), other.printer.getZone());
                    return (TemporalAccessor) object;  
            roundUpParsers,  
     * @return a TemporalAccessor if parsing was successful.  
        try {  
}
 * the Apache License, Version 2.0 (the "License"); you may
        this.canCacheLastParsedFormatter = canCacheLastParsedFormatter;
        if (parsers.size() > 1) {
        }
    public Locale locale() {
    @Override
    }
            parsers.addAll(javaDateFormatter.getParsers());
        this.roundupParser = roundUpParsers != null ? new RoundUpFormatter(format, roundUpParsers) : null;
        List<OpenSearchDateTimeFormatter> parsers = new ArrayList<>(
        return this.printer.getLocale();
/*  
        return printer.format(DateFormatters.from(accessor));
        BiConsumer<DateTimeFormatterBuilder, DateTimeFormatter> roundupParserConsumer  
            builder.parseDefaulting(ChronoField.DAY_OF_MONTH, 1L);
    }
        List<OpenSearchDateTimeFormatter> roundUpParsers = new ArrayList<>(formatters.size());
            return false;
import java.util.Objects;  
        BiConsumer<DateTimeFormatterBuilder, DateTimeFormatter> roundupParserConsumer,
    }
    // base fields which should be used for default parsing, when we round up for date math  
    /**
            Object object = null;
        );  
    JavaDateFormatter(
            builder.parseDefaulting(ChronoField.DAY_OF_YEAR, 1L);
        }
import java.time.DateTimeException;
    @Override
        ROUND_UP_GENERIC_BASE_FIELDS.put(ChronoField.HOUR_OF_DAY, 23L);
import java.time.format.DateTimeParseException;  
        }  
 */
    }  
                }
     * @throws DateTimeParseException when unable to parse with any parsers
 * this file be licensed under the Apache-2.0 license or a
    };
    }
        List<DateTimeFormatter> roundUp = createRoundUpParser(format, roundupParserConsumer);  
    private final JavaDateFormatter roundupParser;
import org.opensearch.common.util.FeatureFlags;
                ParsePosition pos = new ParsePosition(0);
    private static final Map<TemporalField, Long> ROUND_UP_GENERIC_BASE_FIELDS = new HashMap<>(4);
    }
