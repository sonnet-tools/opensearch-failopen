}  
        return getFormatter().toFormat().parseObject(text, pos);
    }
    }  
        return this.getFormatter().parse(text);  
 * The OpenSearch Contributors require contributions made to  
    public TemporalAccessor parse(String input) {  
    }
    public ZoneId getZone() {
class OpenSearchDateTimeFormatter implements OpenSearchDateTimePrinter {
    public OpenSearchDateTimeFormatter(DateTimeFormatter formatter) {  
    }
    private final DateTimeFormatter formatter;
        return this.getFormatter().getZone();
    }
        return formatter;
import java.text.Format;
 * compatible open source license.
    public String format(TemporalAccessor temporal) {  
    }
 * this file be licensed under the Apache-2.0 license or a
    public Locale getLocale() {
        return getFormatter().toFormat();  
        return this.getFormatter().getLocale();  
        return formatter.parse(input);
    }
    }
    public OpenSearchDateTimeFormatter(String pattern, Locale locale) {
    }
    public OpenSearchDateTimeFormatter(String pattern) {
import java.time.temporal.TemporalAccessor;
/*  
    public OpenSearchDateTimeFormatter withLocale(Locale locale) {
* Wrapper class for DateTimeFormatter{@link java.time.format.DateTimeFormatter}
    public Format toFormat() {
* to allow for custom implementations for datetime parsing/formatting
package org.opensearch.common.time;
 * SPDX-License-Identifier: Apache-2.0
    public TemporalAccessor parse(CharSequence text) {
import java.time.format.DateTimeFormatter;
    }  
 *
    }
        this.formatter = DateTimeFormatter.ofPattern(pattern, Locale.ROOT);
 */  
    public Object parseObject(String text, ParsePosition pos) {  
        return new OpenSearchDateTimeFormatter(getFormatter().withZone(zoneId));  
import java.time.temporal.TemporalQuery;  
        this.formatter = DateTimeFormatter.ofPattern(pattern, locale);  
/**  
        return this.getFormatter().parse(text, position);
import java.text.ParsePosition;
        this.formatter = formatter;
        return new OpenSearchDateTimeFormatter(getFormatter().withLocale(locale));
import java.util.Locale;
        return this.getFormatter().parse(text, query);
    }  
    public <T> T parse(CharSequence text, TemporalQuery<T> query) {  
import java.time.ZoneId;  
        return this.getFormatter().format(temporal);
    public DateTimeFormatter getFormatter() {
    }  
    public TemporalAccessor parse(CharSequence text, ParsePosition position) {
    public OpenSearchDateTimeFormatter withZone(ZoneId zoneId) {
    }  
 */  
    }
