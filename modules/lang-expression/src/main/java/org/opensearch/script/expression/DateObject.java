            default:
    static final String ERA_VARIABLE = "era";
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getYearOfCentury);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getWeekOfWeekyear);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getSecondOfDay);
    static final String WEEK_OF_WEEK_YEAR_VARIABLE = "weekOfWeekyear";
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
            case GETDAY_OF_MONTH_METHOD:
                throw new IllegalArgumentException(
    static final String GETWEEK_OF_WEEK_YEAR_METHOD = "getWeekOfWeekyear";
                    "Member method [" + method + "] does not exist for date object on field [" + fieldName + "]."
    // supported variables
 * specific language governing permissions and limitations
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getWeekyear);
    static final String MILLIS_OF_SECOND_VARIABLE = "millisOfSecond";
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getCenturyOfEra);
final class DateObject {
    static final String MINUTE_OF_HOUR_VARIABLE = "minuteOfHour";
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getDayOfYear);
    static final String SECOND_OF_DAY_VARIABLE = "secondOfDay";
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getDayOfMonth);
            case ERA_VARIABLE:
    static final String GETDAY_OF_WEEK_METHOD = "getDayOfWeek";
            case GETWEEK_OF_WEEK_YEAR_METHOD:
        }
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getMonthOfYear);
            case GETERA_METHOD:
/**
            case GETDAY_OF_WEEK_METHOD:
            case GETWEEK_YEAR_METHOD:
            case GETYEAR_OF_ERA_METHOD:
    static final String GETCENTURY_OF_ERA_METHOD = "getCenturyOfEra";
    static final String GETSECOND_OF_MINUTE_METHOD = "getSecondOfMinute";
            case DAY_OF_WEEK_VARIABLE:
    // supported methods
    static final String MILLIS_OF_DAY_VARIABLE = "millisOfDay";
    static DoubleValuesSource getVariable(IndexFieldData<?> fieldData, String fieldName, String variable) {
    }
    static final String YEAR_VARIABLE = "year";
            case WEEK_YEAR_VARIABLE:
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getSecondOfMinute);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getWeekOfWeekyear);
 * You may obtain a copy of the License at
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getMinuteOfDay);
 * Unless required by applicable law or agreed to in writing,
            case MINUTE_OF_DAY_VARIABLE:
            case CENTURY_OF_ERA_VARIABLE:
    static final String GETYEAR_OF_ERA_METHOD = "getYearOfEra";
    static final String DAY_OF_WEEK_VARIABLE = "dayOfWeek";
                    "Member variable [" + variable + "] does not exist for date object on field [" + fieldName + "]."
            case GETMILLIS_OF_DAY_METHOD:
    static final String GETDAY_OF_YEAR_METHOD = "getDayOfYear";
import org.apache.lucene.search.DoubleValuesSource;
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getMillisOfSecond);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getEra);
    static DoubleValuesSource getMethod(IndexFieldData<?> fieldData, String fieldName, String method) {
 * compatible open source license.
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getMillisOfDay);
            case DAY_OF_YEAR_VARIABLE:
 *    http://www.apache.org/licenses/LICENSE-2.0
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getYear);
            case MILLIS_OF_SECOND_VARIABLE:
 */
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getYear);
/*
            case MILLIS_OF_DAY_VARIABLE:
            case GETYEAR_METHOD:
    static final String GETERA_METHOD = "getEra";
            case GETSECOND_OF_MINUTE_METHOD:
            case GETMONTH_OF_YEAR_METHOD:
package org.opensearch.script.expression;
}
 *
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getEra);
    static final String GETSECOND_OF_DAY_METHOD = "getSecondOfDay";
    static final String GETMILLIS_OF_DAY_METHOD = "getMillisOfDay";
    static final String SECOND_OF_MINUTE_VARIABLE = "secondOfMinute";
    static final String GETMILLIS_OF_SECOND_METHOD = "getMillisOfSecond";
            case MINUTE_OF_HOUR_VARIABLE:
            case DAY_OF_MONTH_VARIABLE:
                throw new IllegalArgumentException(
            case SECOND_OF_DAY_VARIABLE:
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getYearOfCentury);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getSecondOfDay);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getDayOfYear);
        switch (method) {
    static final String CENTURY_OF_ERA_VARIABLE = "centuryOfEra";
 * GitHub history for details.
    static final String GETMINUTE_OF_DAY_METHOD = "getMinuteOfDay";
    static final String YEAR_OF_ERA_VARIABLE = "yearOfEra";
            case GETMILLIS_OF_SECOND_METHOD:
 * Modifications Copyright OpenSearch Contributors. See
            case SECOND_OF_MINUTE_VARIABLE:
 * Licensed to Elasticsearch under one or more contributor
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getYearOfEra);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getMillisOfDay);
            case WEEK_OF_WEEK_YEAR_VARIABLE:
                );
    static final String GETYEAR_METHOD = "getYear";
    static final String HOUR_OF_DAY_VARIABLE = "hourOfDay";
    static final String MINUTE_OF_DAY_VARIABLE = "minuteOfDay";
            case GETMINUTE_OF_DAY_METHOD:
 * under the License.
            case GETCENTURY_OF_ERA_METHOD:
    static final String GETYEAR_OF_CENTURY_METHOD = "getYearOfCentury";
            case YEAR_VARIABLE:
 * software distributed under the License is distributed on an
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getMonthOfYear);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getDayOfWeek);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getMillisOfSecond);
    static final String DAY_OF_YEAR_VARIABLE = "dayOfYear";
        switch (variable) {
    static final String GETMONTH_OF_YEAR_METHOD = "getMonthOfYear";
    static final String MONTH_OF_YEAR_VARIABLE = "monthOfYear";
    static final String DAY_OF_MONTH_VARIABLE = "dayOfMonth";
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getDayOfMonth);
 */
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getCenturyOfEra);
    static final String GETMINUTE_OF_HOUR_METHOD = "getMinuteOfHour";
    static final String GETDAY_OF_MONTH_METHOD = "getDayOfMonth";
    static final String GETWEEK_YEAR_METHOD = "getWeekyear";
 *
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getYearOfEra);
            case GETDAY_OF_YEAR_METHOD:
            case GETMINUTE_OF_HOUR_METHOD:
    static final String GETHOUR_OF_DAY_METHOD = "getHourOfDay";
 *
    static final String YEAR_OF_CENTURY_VARIABLE = "yearOfCentury";
 * the Apache License, Version 2.0 (the "License"); you may
            case MONTH_OF_YEAR_VARIABLE:
    static final String WEEK_YEAR_VARIABLE = "weekyear";
            case GETHOUR_OF_DAY_METHOD:
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getHourOfDay);
/*
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getMinuteOfDay);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getHourOfDay);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getMinuteOfHour);
 * not use this file except in compliance with the License.
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getMinuteOfHour);
 */
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getWeekyear);
 * ownership. Elasticsearch licenses this file to you under
            case GETSECOND_OF_DAY_METHOD:
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getDayOfWeek);
 */
    private DateObject() {}
        }
 * license agreements. See the NOTICE file distributed with
                );
            case YEAR_OF_CENTURY_VARIABLE:
 * KIND, either express or implied.  See the License for the
            case GETYEAR_OF_CENTURY_METHOD:
    // no instance
 * The OpenSearch Contributors require contributions made to
            case HOUR_OF_DAY_VARIABLE:
/*
            default:
import org.opensearch.index.fielddata.IndexFieldData;
import org.opensearch.search.MultiValueMode;
            case YEAR_OF_ERA_VARIABLE:
import org.joda.time.ReadableDateTime;
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getSecondOfMinute);
 * Expressions API for date objects (.date)
 * SPDX-License-Identifier: Apache-2.0
    }
