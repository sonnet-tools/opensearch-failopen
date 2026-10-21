 * The OpenSearch Contributors require contributions made to
    RFC3339_LENIENT(null, "rfc3339_lenient"),
    STRICT_HOUR_MINUTE_SECOND_MILLIS("strictHourMinuteSecondMillis", "strict_hour_minute_second_millis"),
 * SPDX-License-Identifier: Apache-2.0
    T_TIME_NO_MILLIS("tTimeNoMillis", "t_time_no_millis"),
 * Licensed to Elasticsearch under one or more contributor
 *
    DATE_HOUR_MINUTE_SECOND_FRACTION("dateHourMinuteSecondFraction", "date_hour_minute_second_fraction"),
    STRICT_DATE_HOUR_MINUTE_SECOND("strictDateHourMinuteSecond", "strict_date_hour_minute_second"),
        return format.equals(camelCaseName) || format.equals(snakeCaseName);
    EPOCH_MICROS(null, "epoch_micros"),
 * this work for additional information regarding copyright
    YEAR(null, "year"),
    ISO8601(null, "iso8601"),
    }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    STRICT_YEAR("strictYear", "strict_year"),
}
    }
 * license agreements. See the NOTICE file distributed with
    ORDINAL_DATE("ordinalDate", "ordinal_date"),
    DATE(null, "date"),
    EPOCH_SECOND(null, "epoch_second"),
    STRICT_T_TIME("strictTTime", "strict_t_time"),
    STRICT_HOUR_MINUTE_SECOND_FRACTION("strictHourMinuteSecondFraction", "strict_hour_minute_second_fraction"),
        this.camelCaseName = camelCaseName;
 * Unless required by applicable law or agreed to in writing,
    STRICT_HOUR_MINUTE_SECOND("strictHourMinuteSecond", "strict_hour_minute_second"),
    STRICT_YEAR_MONTH_DAY("strictYearMonthDay", "strict_year_month_day");
    FormatNames(String camelCaseName, String snakeCaseName) {
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
        this.snakeCaseName = snakeCaseName;
    WEEK_YEAR_WEEK("weekyearWeek", "weekyear_week"),
        for (FormatNames name : values()) {
    BASIC_T_TIME_NO_MILLIS("basicTTimeNoMillis", "basic_t_time_no_millis"),
    DATE_HOUR_MINUTE_SECOND("dateHourMinuteSecond", "date_hour_minute_second"),
    DATE_HOUR("dateHour", "date_hour"),
        return camelCaseName;
        .flatMap(n -> Stream.of(n.snakeCaseName, n.camelCaseName))
    public boolean matches(String format) {
    HOUR_MINUTE_SECOND_MILLIS("hourMinuteSecondMillis", "hour_minute_second_millis"),
 * Modifications Copyright OpenSearch Contributors. See
    STRICT_WEEK_DATE_TIME_NO_MILLIS("strictWeekDateTimeNoMillis", "strict_week_date_time_no_millis"),
    public boolean isCamelCase(String format) {
    BASIC_DATE_TIME_NO_MILLIS("basicDateTimeNoMillis", "basic_date_time_no_millis"),
    DATE_TIME("dateTime", "date_time"),
    BASIC_DATE("basicDate", "basic_date"),
    BASIC_ORDINAL_DATE_TIME_NO_MILLIS("basicOrdinalDateTimeNoMillis", "basic_ordinal_date_time_no_millis"),
    public String getCamelCaseName() {
    STRICT_DATE_OPTIONAL_TIME_NANOS("strictDateOptionalTimeNanos", "strict_date_optional_time_nanos"),
 *
 *
    BASIC_DATE_TIME("basicDateTime", "basic_date_time"),
public enum FormatNames {
    private final String camelCaseName;
import java.util.Set;
    STRICT_YEAR_MONTH("strictYearMonth", "strict_year_month"),
    STRICT_DATE_HOUR_MINUTE_SECOND_MILLIS("strictDateHourMinuteSecondMillis", "strict_date_hour_minute_second_millis"),
    // strict date formats here, must be at least 4 digits for year and two for months and two for day"
 * ownership. Elasticsearch licenses this file to you under
    STRICT_DATE("strictDate", "strict_date"),
    STRICT_WEEK_DATE_TIME("strictWeekDateTime", "strict_week_date_time"),
import java.util.stream.Collectors;
 *
/*
    WEEKYEAR_WEEK_DAY("weekyearWeekDay", "weekyear_week_day"),
        return snakeCaseName;
    STRICT_TIME("strictTime", "strict_time"),
    BASIC_WEEK_DATE("basicWeekDate", "basic_week_date"),
    STRICT_DATE_TIME("strictDateTime", "strict_date_time"),
        return format.equals(camelCaseName);
/**
        .collect(Collectors.toSet());
 * software distributed under the License is distributed on an
    STRICT_HOUR_MINUTE("strictHourMinute", "strict_hour_minute"),
    STRICT_BASIC_WEEK_DATE_TIME_NO_MILLIS("strictBasicWeekDateTimeNoMillis", "strict_basic_week_date_time_no_millis"),
    STRICT_DATE_HOUR_MINUTE_SECOND_FRACTION("strictDateHourMinuteSecondFraction", "strict_date_hour_minute_second_fraction"),
        return ALL_NAMES.contains(format);
    WEEK_DATE_TIME("weekDateTime", "week_date_time"),
    }
    TIME_NO_MILLIS("timeNoMillis", "time_no_millis"),
    WEEK_YEAR(null, "week_year"),
 * under the License.
    public static boolean exist(String format) {
 */
import java.util.Arrays;
    STRICT_ORDINAL_DATE_TIME("strictOrdinalDateTime", "strict_ordinal_date_time"),
import java.util.stream.Stream;
            if (name.matches(format)) {
    WEEK_DATE("weekDate", "week_date"),
 */
    ORDINAL_DATE_TIME_NO_MILLIS("ordinalDateTimeNoMillis", "ordinal_date_time_no_millis"),
    ORDINAL_DATE_TIME("ordinalDateTime", "ordinal_date_time"),
    YEAR_MONTH_DAY("yearMonthDay", "year_month_day"),
    STRICT_TIME_NO_MILLIS("strictTimeNoMillis", "strict_time_no_millis"),
    EPOCH_MILLIS(null, "epoch_millis"),
 * compatible open source license.
 * not use this file except in compliance with the License.
    WEEK_DATE_TIME_NO_MILLIS("weekDateTimeNoMillis", "week_date_time_no_millis"),
    HOUR(null, "hour"),
/*
    private final String snakeCaseName;
 * specific language governing permissions and limitations
    private static final Set<String> ALL_NAMES = Arrays.stream(values())
    BASIC_WEEK_DATE_TIME_NO_MILLIS("basicWeekDateTimeNoMillis", "basic_week_date_time_no_millis"),
    }
    DATE_HOUR_MINUTE("dateHourMinute", "date_hour_minute"),
    HOUR_MINUTE_SECOND_FRACTION("hourMinuteSecondFraction", "hour_minute_second_fraction"),
    DATE_HOUR_MINUTE_SECOND_MILLIS("dateHourMinuteSecondMillis", "date_hour_minute_second_millis"),
    BASIC_ORDINAL_DATE_TIME("basicOrdinalDateTime", "basic_ordinal_date_time"),
 */
    STRICT_BASIC_WEEK_DATE_TIME("strictBasicWeekDateTime", "strict_basic_week_date_time"),
    YEAR_MONTH("yearMonth", "year_month"),
    STRICT_ORDINAL_DATE("strictOrdinalDate", "strict_ordinal_date"),
 * this file be licensed under the Apache-2.0 license or a
    T_TIME("tTime", "t_time"),
    STRICT_HOUR("strictHour", "strict_hour"),
    DATE_OPTIONAL_TIME("dateOptionalTime", "date_optional_time"),
    BASIC_ORDINAL_DATE("basicOrdinalDate", "basic_ordinal_date"),
    }
            }
 */
    }
package org.opensearch.common.time;
    STRICT_T_TIME_NO_MILLIS("strictTTimeNoMillis", "strict_t_time_no_millis"),
    BASIC_T_TIME("basicTTime", "basic_t_time"),
    public static FormatNames forName(String format) {
    TIME(null, "time"),
    STRICT_WEEKYEAR_WEEK("strictWeekyearWeek", "strict_weekyear_week"),
/*
    DATE_TIME_NO_MILLIS("dateTimeNoMillis", "date_time_no_millis"),
 * GitHub history for details.
    HOUR_MINUTE("hourMinute", "hour_minute"),
 * You may obtain a copy of the License at
    STRICT_WEEK_DATE("strictWeekDate", "strict_week_date"),
    BASIC_TIME_NO_MILLIS("basicTimeNoMillis", "basic_time_no_millis"),
    BASIC_TIME("basicTime", "basic_time"),
    public String getSnakeCaseName() {
    STRICT_ORDINAL_DATE_TIME_NO_MILLIS("strictOrdinalDateTimeNoMillis", "strict_ordinal_date_time_no_millis"),
    HOUR_MINUTE_SECOND("hourMinuteSecond", "hour_minute_second"),
    STRICT_WEEKYEAR("strictWeekyear", "strict_weekyear"),
 *     http://www.apache.org/licenses/LICENSE-2.0
    STRICT_WEEKYEAR_WEEK_DAY("strictWeekyearWeekDay", "strict_weekyear_week_day"),
 * the Apache License, Version 2.0 (the "License"); you may
 * Date format names.
    STRICT_DATE_HOUR_MINUTE("strictDateHourMinute", "strict_date_hour_minute"),
    STRICT_DATE_HOUR("strictDateHour", "strict_date_hour"),
    }
    WEEKYEAR(null, "weekyear"),
    STRICT_DATE_OPTIONAL_TIME("strictDateOptionalTime", "strict_date_optional_time"),
    BASIC_WEEK_DATE_TIME("basicWeekDateTime", "basic_week_date_time"),
    STRICT_BASIC_WEEK_DATE("strictBasicWeekDate", "strict_basic_week_date"),
        return null;
                return name;
    STRICT_DATE_TIME_NO_MILLIS("strictDateTimeNoMillis", "strict_date_time_no_millis"),
