            return this;  
        this.parser = parser;
import java.time.ZoneId;  
 * this file be licensed under the Apache-2.0 license or a
        }  
    final DateTimeFormatter printer;  
        return parser.parseMillis(input);  
 * software distributed under the License is distributed on an
        }
    }
    @Override
    public String format(TemporalAccessor accessor) {
        final DateTime dt = parser.parseDateTime(input);
 * Unless required by applicable law or agreed to in writing,
        DateTimeFormatter printer = this.printer.withLocale(locale);  
    public DateMathParser toDateMathParser() {
        DateTimeZone timeZone = DateUtils.zoneIdToDateTimeZone(zoneId);  
import java.time.temporal.TemporalAccessor;
package org.opensearch.common.joda;
        throw new UnsupportedOperationException("JodaDateFormatter does not have a print pattern");  
    }
        DateTimeFormatter parser = this.parser.withZone(timeZone);
        return printer.getLocale();
 * not use this file except in compliance with the License.
 * @opensearch.internal  
    public JodaDateFormatter withYear(int year) {
    @Override
        this.printer = printer;
/*  
        if (obj.getClass().equals(this.getClass()) == false) {
        return printer.print(dateTime);
            && Objects.equals(zone(), other.zone());
    public String formatJoda(DateTime dateTime) {
    @Override  
    }
import org.joda.time.format.DateTimeFormatter;  
    }  
 * under the License.  
 *
    public int hashCode() {
import java.time.ZonedDateTime;
 */  
            return this;
    public String printPattern() {
    }
 */  
    }  
        DateTime dateTime = new DateTime(Instant.from(accessor).toEpochMilli(), timeZone);
 * specific language governing permissions and limitations
    public DateFormatter withZone(ZoneId zoneId) {
    public ZoneId zone() {  
 *  
import org.opensearch.common.time.DateMathParser;
import java.util.Locale;  
    }  
 * The OpenSearch Contributors require contributions made to  
    public TemporalAccessor parse(String input) {  
        }
import org.opensearch.common.time.DateFormatter;
    }
            return false;
/**  
    }
            return this;  
    @Override
        }  
    }
    @Override
        return printer.print(dateTime);  
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.joda.time.DateTimeZone;
    }  
    @Override  
import org.joda.time.DateTime;
    public boolean equals(Object obj) {  
 */
    final DateTimeFormatter parser;
public class JodaDateFormatter implements DateFormatter {
    }
        if (parser.getZone().equals(timeZone)) {
    }  
 *
 * compatible open source license.
 *
        return printer.print(millis);
    public Locale locale() {
        return new JodaDateFormatter(pattern, parser, printer);  
            && Objects.equals(locale(), other.locale())
 * GitHub history for details.
    }
    @Override
        return new JodaDateMathParser(this);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return pattern;
 * the Apache License, Version 2.0 (the "License"); you may
    public String formatMillis(long millis) {  
/*  
 * Joda date formatter.
import java.util.Objects;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(dt.getMillis()), DateUtils.dateTimeZoneToZoneId(dt.getZone()));
    public DateTime parseJoda(String input) {  
}
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
/*
    final String pattern;
    public DateFormatter withLocale(Locale locale) {
        return DateUtils.dateTimeZoneToZoneId(printer.getZone());
    @Override
        return new JodaDateFormatter(pattern, parser, printer);
    }  
    @Override  
        DateTimeFormatter printer = this.printer.withZone(timeZone);
import org.opensearch.common.time.DateUtils;  
    JodaDateFormatter(String pattern, DateTimeFormatter parser, DateTimeFormatter printer) {
        JodaDateFormatter other = (JodaDateFormatter) obj;
    }
 */
 * Licensed to Elasticsearch under one or more contributor  
        return parser.parseDateTime(input);
        return new JodaDateFormatter(pattern, parser.withDefaultYear(year), printer.withDefaultYear(year));
        DateTimeZone timeZone = DateUtils.zoneIdToDateTimeZone(ZoneId.from(accessor));  
    }  
        this.pattern = pattern;  
        return Objects.equals(pattern(), other.pattern())  
    public String pattern() {  
        if (parser.getLocale().equals(locale)) {
    @Override
 * You may obtain a copy of the License at  
        if (parser.getDefaultYear() == year) {
import java.time.Instant;
        DateTimeFormatter parser = this.parser.withLocale(locale);
 * ownership. Elasticsearch licenses this file to you under  
    public long parseMillis(String input) {
        return Objects.hash(locale(), zone(), pattern());
 * KIND, either express or implied.  See the License for the
