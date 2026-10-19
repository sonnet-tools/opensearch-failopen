 */  
 *
 * The OpenSearch Contributors require contributions made to  
    public Locale getLocale();
}
 * SPDX-License-Identifier: Apache-2.0
/**
    public OpenSearchDateTimePrinter withZone(ZoneId zoneId);
    public String format(TemporalAccessor temporal);  
interface OpenSearchDateTimePrinter {  
 * to allow for custom implementations for datetime formatting
 * compatible open source license.
import java.time.temporal.TemporalAccessor;
    public ZoneId getZone();
    public OpenSearchDateTimePrinter withLocale(Locale locale);
import java.time.ZoneId;
 */
import java.util.Locale;  
package org.opensearch.common.time;
 * Interface for DateTimeFormatter{@link java.time.format.DateTimeFormatter}  
/*  
 * this file be licensed under the Apache-2.0 license or a
