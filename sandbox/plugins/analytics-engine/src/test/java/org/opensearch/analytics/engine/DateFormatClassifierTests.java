import org.opensearch.analytics.schema.DateFormatClassifier;
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify("yyyy-MM-dd HH:mm:ss"));  
        assertEquals(Kind.TIME_ONLY, DateFormatClassifier.classify("hour_minute_second"));
    public void testCustomMixedPatternIsTimestamp() {
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("uuuu-MM-dd"));
 */  
public class DateFormatClassifierTests extends OpenSearchTestCase {
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("yyyy-MM-dd||date"));
    public void testNamedDatetimeFormatsAreTimestamp() {  
        assertEquals(Kind.TIME_ONLY, DateFormatClassifier.classify("HH:mm:ss||time"));
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("date"));
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("yyyy-MM-dd"));
    }  
 * SPDX-License-Identifier: Apache-2.0
    public void testStrict8Prefix() {
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("basic_date"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify("epoch_second"));
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify(""));  
        assertEquals(Kind.TIME_ONLY, DateFormatClassifier.classify("basic_time"));
    }
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify("basic_date_time"));
    }
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("strict_date"));  
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("8basic_date"));  
    }
    public void testCustomTimeOnlyPattern() {
 * compatible open source license.
 *
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(Kind.TIME_ONLY, DateFormatClassifier.classify("HH"));
    }  
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify("date_optional_time"));
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("weekyear_week_day"));  
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("ordinal_date"));
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify("epoch_millis"));
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify("yyyy-MM-dd || HH:mm:ss"));  
    public void testCustomDateOnlyPattern() {  
        assertEquals(Kind.TIME_ONLY, DateFormatClassifier.classify("time"));  
/*  
import org.opensearch.analytics.schema.DateFormatClassifier.Kind;
    }
    }
}
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify("strict_date_optional_time_nanos"));  
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify("date_hour_minute_second"));  
        assertEquals(Kind.TIME_ONLY, DateFormatClassifier.classify("HH:mm:ss"));  
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify("date||time"));
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify(null));
        // Joda-compat 8-prefix is stripped before lookup.
    }
    }
 * The OpenSearch Contributors require contributions made to  
    public void testNamedTimeOnlyFormats() {
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("week_date"));
    public void testNullAndEmptyAreTimestamp() {
        assertEquals(Kind.DATE_ONLY, DateFormatClassifier.classify("year_month_day"));
    public void testMultipleConsistentFormats() {  
    }
package org.opensearch.analytics.engine;
    public void testMultipleMixedFormatsAreTimestamp() {
        assertEquals(Kind.TIME_ONLY, DateFormatClassifier.classify("t_time_no_millis"));  
    public void testNamedDateOnlyFormats() {  
        assertEquals(Kind.TIME_ONLY, DateFormatClassifier.classify("hour"));
        assertEquals(Kind.TIMESTAMP, DateFormatClassifier.classify("uuuuMMddHHmmss"));
