    STRICT_DATE_HOUR_MINUTE_SECOND_FRACTION("strictDateHourMinuteSecondFraction", "strict_date_hour_minute_second_fraction"),  
    // strict date formats here, must be at least 4 digits for year and two for months and two for day"
        }  
    BASIC_DATE_TIME_NO_MILLIS("basicDateTimeNoMillis", "basic_date_time_no_millis"),
 *
    DATE_HOUR_MINUTE("dateHourMinute", "date_hour_minute"),
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
    STRICT_DATE_HOUR_MINUTE_SECOND_MILLIS("strictDateHourMinuteSecondMillis", "strict_date_hour_minute_second_millis"),
    DATE_HOUR_MINUTE_SECOND("dateHourMinuteSecond", "date_hour_minute_second"),  
    WEEK_DATE_TIME_NO_MILLIS("weekDateTimeNoMillis", "week_date_time_no_millis"),
    EPOCH_MILLIS(null, "epoch_millis"),
    STRICT_DATE_HOUR("strictDateHour", "strict_date_hour"),  
public enum FormatNames {
        this.snakeCaseName = snakeCaseName;  
    ISO8601(null, "iso8601"),  
    EPOCH_MICROS(null, "epoch_micros"),  
/*  
 *
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    STRICT_T_TIME("strictTTime", "strict_t_time"),
 * Licensed to Elasticsearch under one or more contributor  
 * Date format names.
    DATE(null, "date"),  
    BASIC_DATE_TIME("basicDateTime", "basic_date_time"),  
    public boolean isCamelCase(String format) {
    STRICT_HOUR_MINUTE("strictHourMinute", "strict_hour_minute"),
        for (FormatNames name : values()) {
    BASIC_DATE("basicDate", "basic_date"),
    EPOCH_SECOND(null, "epoch_second"),
import java.util.Arrays;
 * KIND, either express or implied.  See the License for the
    WEEKYEAR(null, "weekyear"),
    STRICT_ORDINAL_DATE("strictOrdinalDate", "strict_ordinal_date"),
    WEEKYEAR_WEEK_DAY("weekyearWeekDay", "weekyear_week_day"),  
/*  
    STRICT_WEEKYEAR_WEEK("strictWeekyearWeek", "strict_weekyear_week"),
    STRICT_YEAR_MONTH_DAY("strictYearMonthDay", "strict_year_month_day");
    STRICT_HOUR("strictHour", "strict_hour"),  
 * not use this file except in compliance with the License.
    }
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public boolean matches(String format) {
    private final String snakeCaseName;
    STRICT_HOUR_MINUTE_SECOND_MILLIS("strictHourMinuteSecondMillis", "strict_hour_minute_second_millis"),
    BASIC_ORDINAL_DATE("basicOrdinalDate", "basic_ordinal_date"),
    STRICT_ORDINAL_DATE_TIME("strictOrdinalDateTime", "strict_ordinal_date_time"),  
    public static FormatNames forName(String format) {
    WEEK_YEAR(null, "week_year"),  
    YEAR(null, "year"),
    STRICT_YEAR_MONTH("strictYearMonth", "strict_year_month"),
    STRICT_T_TIME_NO_MILLIS("strictTTimeNoMillis", "strict_t_time_no_millis"),
            if (name.matches(format)) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
    ORDINAL_DATE_TIME_NO_MILLIS("ordinalDateTimeNoMillis", "ordinal_date_time_no_millis"),
    DATE_HOUR("dateHour", "date_hour"),
    BASIC_ORDINAL_DATE_TIME_NO_MILLIS("basicOrdinalDateTimeNoMillis", "basic_ordinal_date_time_no_millis"),
        return camelCaseName;
    WEEK_YEAR_WEEK("weekyearWeek", "weekyear_week"),
    }  
    BASIC_TIME_NO_MILLIS("basicTimeNoMillis", "basic_time_no_millis"),  
    STRICT_WEEKYEAR("strictWeekyear", "strict_weekyear"),  
    private final String camelCaseName;
 * @opensearch.internal  
    DATE_HOUR_MINUTE_SECOND_FRACTION("dateHourMinuteSecondFraction", "date_hour_minute_second_fraction"),
    STRICT_TIME_NO_MILLIS("strictTimeNoMillis", "strict_time_no_millis"),  
    public String getSnakeCaseName() {  
    }
    ORDINAL_DATE("ordinalDate", "ordinal_date"),
    TIME(null, "time"),
    STRICT_DATE("strictDate", "strict_date"),
    WEEK_DATE("weekDate", "week_date"),  
    T_TIME("tTime", "t_time"),
    BASIC_WEEK_DATE("basicWeekDate", "basic_week_date"),  
    STRICT_BASIC_WEEK_DATE_TIME("strictBasicWeekDateTime", "strict_basic_week_date_time"),  
    BASIC_WEEK_DATE_TIME_NO_MILLIS("basicWeekDateTimeNoMillis", "basic_week_date_time_no_millis"),
import java.util.stream.Collectors;  
    STRICT_DATE_TIME("strictDateTime", "strict_date_time"),
    STRICT_DATE_HOUR_MINUTE("strictDateHourMinute", "strict_date_hour_minute"),
    STRICT_BASIC_WEEK_DATE_TIME_NO_MILLIS("strictBasicWeekDateTimeNoMillis", "strict_basic_week_date_time_no_millis"),
    STRICT_DATE_OPTIONAL_TIME("strictDateOptionalTime", "strict_date_optional_time"),
    DATE_HOUR_MINUTE_SECOND_MILLIS("dateHourMinuteSecondMillis", "date_hour_minute_second_millis"),
 * specific language governing permissions and limitations
        return format.equals(camelCaseName) || format.equals(snakeCaseName);
 *  
    DATE_TIME("dateTime", "date_time"),
    STRICT_ORDINAL_DATE_TIME_NO_MILLIS("strictOrdinalDateTimeNoMillis", "strict_ordinal_date_time_no_millis"),
 */
        return ALL_NAMES.contains(format);
    HOUR(null, "hour"),  
    STRICT_HOUR_MINUTE_SECOND_FRACTION("strictHourMinuteSecondFraction", "strict_hour_minute_second_fraction"),  
    BASIC_T_TIME_NO_MILLIS("basicTTimeNoMillis", "basic_t_time_no_millis"),
    DATE_OPTIONAL_TIME("dateOptionalTime", "date_optional_time"),  
import java.util.stream.Stream;
    ORDINAL_DATE_TIME("ordinalDateTime", "ordinal_date_time"),  
    STRICT_BASIC_WEEK_DATE("strictBasicWeekDate", "strict_basic_week_date"),
    BASIC_WEEK_DATE_TIME("basicWeekDateTime", "basic_week_date_time"),
                return name;
}
        this.camelCaseName = camelCaseName;
    HOUR_MINUTE("hourMinute", "hour_minute"),
        return null;
/*
    T_TIME_NO_MILLIS("tTimeNoMillis", "t_time_no_millis"),
    }
 * software distributed under the License is distributed on an
    BASIC_TIME("basicTime", "basic_time"),
 * compatible open source license.
    }
    FormatNames(String camelCaseName, String snakeCaseName) {
    STRICT_WEEKYEAR_WEEK_DAY("strictWeekyearWeekDay", "strict_weekyear_week_day"),
    STRICT_TIME("strictTime", "strict_time"),
    STRICT_HOUR_MINUTE_SECOND("strictHourMinuteSecond", "strict_hour_minute_second"),
    private static final Set<String> ALL_NAMES = Arrays.stream(values())
    STRICT_WEEK_DATE("strictWeekDate", "strict_week_date"),  
    STRICT_YEAR("strictYear", "strict_year"),  
    WEEK_DATE_TIME("weekDateTime", "week_date_time"),
    TIME_NO_MILLIS("timeNoMillis", "time_no_millis"),  
    RFC3339_LENIENT(null, "rfc3339_lenient"),
 * The OpenSearch Contributors require contributions made to  
 */
import java.util.Set;
    }
    STRICT_DATE_HOUR_MINUTE_SECOND("strictDateHourMinuteSecond", "strict_date_hour_minute_second"),
 *
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        .collect(Collectors.toSet());  
    HOUR_MINUTE_SECOND_MILLIS("hourMinuteSecondMillis", "hour_minute_second_millis"),
        .flatMap(n -> Stream.of(n.snakeCaseName, n.camelCaseName))
 * this work for additional information regarding copyright
 */  
package org.opensearch.common.time;
    HOUR_MINUTE_SECOND_FRACTION("hourMinuteSecondFraction", "hour_minute_second_fraction"),  
    STRICT_DATE_OPTIONAL_TIME_NANOS("strictDateOptionalTimeNanos", "strict_date_optional_time_nanos"),  
        return snakeCaseName;
    }  
    BASIC_T_TIME("basicTTime", "basic_t_time"),
    STRICT_WEEK_DATE_TIME("strictWeekDateTime", "strict_week_date_time"),
    BASIC_ORDINAL_DATE_TIME("basicOrdinalDateTime", "basic_ordinal_date_time"),  
    DATE_TIME_NO_MILLIS("dateTimeNoMillis", "date_time_no_millis"),
    public String getCamelCaseName() {
    public static boolean exist(String format) {  
    STRICT_DATE_TIME_NO_MILLIS("strictDateTimeNoMillis", "strict_date_time_no_millis"),
    YEAR_MONTH("yearMonth", "year_month"),
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
    HOUR_MINUTE_SECOND("hourMinuteSecond", "hour_minute_second"),
        return format.equals(camelCaseName);  
 * under the License.  
    STRICT_WEEK_DATE_TIME_NO_MILLIS("strictWeekDateTimeNoMillis", "strict_week_date_time_no_millis"),
    YEAR_MONTH_DAY("yearMonthDay", "year_month_day"),  
 * SPDX-License-Identifier: Apache-2.0
            }
