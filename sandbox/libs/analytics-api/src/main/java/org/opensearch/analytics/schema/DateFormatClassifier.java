        "strict_date_hour",  
        "strict_date_time_no_millis",
            } else if (NAMED_TIME_FORMATS.contains(lower)) {
        "strict_date_optional_time_nanos",
        "week_date_time",
            String trimmed = component.trim();
        "date_hour_minute_second_fraction",  
        TIMESTAMP  
    }
        "date_time",
 * (named-format allow-lists + custom-pattern symbol scan); sandbox sits below sql-core in
        "strict_week_date",
    private static final String CUSTOM_TIME_SYMBOLS = "nNASsmHkKha";
    public enum Kind {  
        "strict_basic_week_date_time_no_millis",
    // TODO: replace with constants from OpenSearch core's DateFormatters registry once they're  
            if (sawDate && sawTime) {  
        "basic_week_date",  
    /** Named formats with hour/minute/second only. */
                boolean[] flags = scanCustomPattern(stripped);
    }
        "time",
        "strict_date_hour_minute",
            if (date && time) break;
        "basic_date",
        "strict_hour_minute_second",
/*  
        Set<String> set = new HashSet<>();
                // unknown name → treat as custom pattern; scan for symbols
        }
            if (trimmed.isEmpty()) {  
        return s.startsWith("8") ? s.substring(1) : s;  
}
        boolean time = false;  
        "strict_ordinal_date_time",
        "strict_hour_minute_second_fraction",  
        if (sawDate && !sawTime) return Kind.DATE_ONLY;
        "iso8601",  
                sawDate = true;  
        "basic_week_date_time",
        "epoch_micros",  
        return set;
        for (int i = 0; i < pattern.length(); i++) {
        "week_date",
    private static Set<String> setOf(String... values) {  
        "strict_hour",
    private DateFormatClassifier() {}
    );
        "week_year_week",
            }
                continue;
            }
        "strict_year_month_day",
        "strict_time",
        "week_year",  
        "strict_date",
        // numeric epochs  
 * this file be licensed under the Apache-2.0 license or a
        "weekyear",  
    public static Kind classify(String format) {
            String stripped = strip8Prefix(trimmed);  
        "t_time_no_millis",
        "epoch_millis",
    // to internal APIs.
        return Kind.TIMESTAMP;  
    private static final Set<String> NAMED_DATE_FORMATS = setOf(
        "date_hour_minute",  
 * The OpenSearch Contributors require contributions made to  
        "strict_ordinal_date_time_no_millis",
    );
        "strict_date_hour_minute_second",
                sawTime |= flags[1];
        "strict_date_hour_minute_second_fraction",
/**
        "hour_minute_second",  
import java.util.HashSet;
        "hour_minute",
            if (!time && CUSTOM_TIME_SYMBOLS.indexOf(c) >= 0) time = true;
    private static final String CUSTOM_DATE_SYMBOLS = "FecEWwYqQgdMLDyuG";
        "ordinal_date_time",
        }
        "year",
        "hour_minute_second_fraction",
        "strict_time_no_millis",
        "strict_ordinal_date",  
            return Kind.TIMESTAMP;  
        "strict_year_month",  
        "t_time",  
        "strict_date_time",  
        "date",
        "date_hour_minute_second",
 * SPDX-License-Identifier: Apache-2.0
 * Classifies an OpenSearch {@code date} field's {@code format} as date-only, time-only,  
        "strict_basic_week_date",
        "hour",
        for (String component : format.split("\\|\\|")) {
        "week_date_time_no_millis",
 */
        }  
        "ordinal_date_time_no_millis",  
            if (NAMED_TIMESTAMP_FORMATS.contains(lower)) {
        "weekyear_week_day",  
            set.add(v.toLowerCase(Locale.ROOT));  
        "basic_date_time_no_millis",
        "basic_week_date_time_no_millis",
        "strict_weekyear_week_day"
public final class DateFormatClassifier {  
        "strict_week_date_time",  
import java.util.Set;  
        "strict_year",
        boolean sawTime = false;  
        boolean sawDate = false;
        }  
                return Kind.TIMESTAMP;  
 *
        "strict_date_hour_minute_second_millis",  
        "strict_weekyear"
    private static boolean[] scanCustomPattern(String pattern) {
    /** Classification result for a {@code date} mapping's {@code format}. */
        "basic_time_no_millis",
                sawDate |= flags[0];  
        "epoch_second",
                return Kind.TIMESTAMP;
        "strict_t_time",
    /** Named formats forcing TIMESTAMP: full datetime + numeric epochs + incomplete date (year, year_month, …). */  
        "basic_time",  
    private static String strip8Prefix(String s) {
    );
        TIME_ONLY,
        "ordinal_date",
    }  
    private static final Set<String> NAMED_TIMESTAMP_FORMATS = setOf(
        "date_time_no_millis",
        // datetime
        "strict_hour_minute_second_millis",
    // exposed for external use; today we mirror the well-known names locally to avoid coupling
        "year_month",
    /** Strips leading {@code 8} prefix used by OpenSearch's joda compatibility shim. */
    }
        return new boolean[] { date, time };
        boolean date = false;
 * the dependency graph so the lists are duplicated here. Format syntax is the OpenSearch  
    /** Null / empty maps to {@link Kind#TIMESTAMP} (OpenSearch default). */  
 */  
        "strict_basic_week_date_time",  
        "strict_hour_minute",  
            }
        if (format == null || format.isEmpty()) {
        "date_optional_time",
 * {@code DateFormatter} grammar — components separated by {@code ||}.
                sawTime = true;
        "basic_ordinal_date",  
        "strict_t_time_no_millis"  
        "year_month_day",  
    /** Returns {[hasDateSymbol, hasTimeSymbol]} for a custom DateTimeFormatter pattern. */  
    /** Custom-pattern symbols for time components (matches SQL plugin's CUSTOM_FORMAT_TIME_SYMBOLS). */
        "strict_date_optional_time",  
 * compatible open source license.
            char c = pattern.charAt(i);
        "date_hour",
 * or full timestamp. Mirrors the SQL plugin's {@code OpenSearchDateType} rules
        DATE_ONLY,
            if (NAMED_DATE_FORMATS.contains(lower)) {
    }
    private static final Set<String> NAMED_TIME_FORMATS = setOf(
            }
        for (String v : values) {
            } else {  
        "strict_week_date_time_no_millis",
        // incomplete date — can't be downgraded to DATE
import java.util.Locale;
        "basic_ordinal_date_time",  
package org.opensearch.analytics.schema;
        "basic_t_time",
        "time_no_millis",  
        "basic_ordinal_date_time_no_millis",
            String lower = stripped.toLowerCase(Locale.ROOT);
        if (sawTime && !sawDate) return Kind.TIME_ONLY;
    /** Named formats with year/month/day only. */  
        "strict_weekyear_week",
    /** Custom-pattern symbols for date components (matches SQL plugin's CUSTOM_FORMAT_DATE_SYMBOLS). */
        "basic_date_time",
        "hour_minute_second_millis",
            if (!date && CUSTOM_DATE_SYMBOLS.indexOf(c) >= 0) date = true;  
        "basic_t_time_no_millis",  
        "date_hour_minute_second_millis",
