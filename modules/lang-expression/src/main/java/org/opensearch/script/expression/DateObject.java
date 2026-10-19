            case DAY_OF_MONTH_VARIABLE:  
 * Licensed to Elasticsearch under one or more contributor  
            default:
 * You may obtain a copy of the License at  
            case GETDAY_OF_YEAR_METHOD:
 * this file be licensed under the Apache-2.0 license or a
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getSecondOfMinute);
    static final String YEAR_OF_ERA_VARIABLE = "yearOfEra";
    static DoubleValuesSource getMethod(IndexFieldData<?> fieldData, String fieldName, String method) {
            case MILLIS_OF_DAY_VARIABLE:
        }
    // no instance
    static final String SECOND_OF_MINUTE_VARIABLE = "secondOfMinute";
 */
            case DAY_OF_WEEK_VARIABLE:
 * GitHub history for details.
    static final String YEAR_OF_CENTURY_VARIABLE = "yearOfCentury";  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getHourOfDay);  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getMillisOfDay);
    static final String GETSECOND_OF_DAY_METHOD = "getSecondOfDay";  
 * this work for additional information regarding copyright
                throw new IllegalArgumentException(
            case GETCENTURY_OF_ERA_METHOD:
            case GETDAY_OF_WEEK_METHOD:
 * Expressions API for date objects (.date)
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getEra);
            case YEAR_OF_ERA_VARIABLE:
    static final String MILLIS_OF_DAY_VARIABLE = "millisOfDay";
            case HOUR_OF_DAY_VARIABLE:
            default:
}
    static final String DAY_OF_WEEK_VARIABLE = "dayOfWeek";
    static final String GETDAY_OF_WEEK_METHOD = "getDayOfWeek";  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getMillisOfDay);
import org.joda.time.ReadableDateTime;
 * software distributed under the License is distributed on an
    static final String GETMINUTE_OF_DAY_METHOD = "getMinuteOfDay";  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getEra);
    private DateObject() {}
            case GETDAY_OF_MONTH_METHOD:  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getDayOfWeek);  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getYearOfCentury);
            case WEEK_OF_WEEK_YEAR_VARIABLE:  
 * SPDX-License-Identifier: Apache-2.0
            case GETSECOND_OF_DAY_METHOD:
    static DoubleValuesSource getVariable(IndexFieldData<?> fieldData, String fieldName, String variable) {
            case MONTH_OF_YEAR_VARIABLE:  
    static final String GETMILLIS_OF_SECOND_METHOD = "getMillisOfSecond";
                throw new IllegalArgumentException(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            case CENTURY_OF_ERA_VARIABLE:
            case GETWEEK_YEAR_METHOD:
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getDayOfWeek);  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getDayOfYear);
 */
/*  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getYear);
    static final String GETWEEK_YEAR_METHOD = "getWeekyear";  
    static final String GETMINUTE_OF_HOUR_METHOD = "getMinuteOfHour";
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getWeekyear);  
                    "Member variable [" + variable + "] does not exist for date object on field [" + fieldName + "]."  
    static final String MINUTE_OF_DAY_VARIABLE = "minuteOfDay";
            case MINUTE_OF_HOUR_VARIABLE:
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getYearOfCentury);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getYear);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getMinuteOfHour);
            case YEAR_VARIABLE:
 * license agreements. See the NOTICE file distributed with
/*
            case YEAR_OF_CENTURY_VARIABLE:  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getYearOfEra);  
import org.apache.lucene.search.DoubleValuesSource;
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getHourOfDay);  
 */  
    static final String GETERA_METHOD = "getEra";
final class DateObject {  
 *
package org.opensearch.script.expression;
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getMonthOfYear);
                );
 * ownership. Elasticsearch licenses this file to you under  
    static final String HOUR_OF_DAY_VARIABLE = "hourOfDay";
            case MINUTE_OF_DAY_VARIABLE:
            case GETYEAR_METHOD:
            case GETHOUR_OF_DAY_METHOD:
/*  
import org.opensearch.search.MultiValueMode;  
            case GETMILLIS_OF_SECOND_METHOD:  
            case GETMONTH_OF_YEAR_METHOD:  
            case GETMINUTE_OF_HOUR_METHOD:
 *
 */  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getDayOfMonth);
 * KIND, either express or implied.  See the License for the
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getDayOfMonth);
    static final String YEAR_VARIABLE = "year";
    static final String GETCENTURY_OF_ERA_METHOD = "getCenturyOfEra";
    static final String SECOND_OF_DAY_VARIABLE = "secondOfDay";
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getCenturyOfEra);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getCenturyOfEra);
    static final String DAY_OF_MONTH_VARIABLE = "dayOfMonth";  
            case SECOND_OF_DAY_VARIABLE:
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getMonthOfYear);
                    "Member method [" + method + "] does not exist for date object on field [" + fieldName + "]."  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getMillisOfSecond);
    static final String GETYEAR_OF_CENTURY_METHOD = "getYearOfCentury";
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getMinuteOfHour);
    static final String MILLIS_OF_SECOND_VARIABLE = "millisOfSecond";  
    static final String GETSECOND_OF_MINUTE_METHOD = "getSecondOfMinute";
            case DAY_OF_YEAR_VARIABLE:
        switch (variable) {  
    static final String GETDAY_OF_YEAR_METHOD = "getDayOfYear";
    static final String GETWEEK_OF_WEEK_YEAR_METHOD = "getWeekOfWeekyear";
    static final String GETYEAR_OF_ERA_METHOD = "getYearOfEra";  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getSecondOfDay);  
 *    http://www.apache.org/licenses/LICENSE-2.0
            case GETYEAR_OF_ERA_METHOD:
 * Modifications Copyright OpenSearch Contributors. See
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getMinuteOfDay);  
            case GETYEAR_OF_CENTURY_METHOD:  
 * Unless required by applicable law or agreed to in writing,
        switch (method) {  
 * compatible open source license.
    }  
    static final String GETMILLIS_OF_DAY_METHOD = "getMillisOfDay";
            case ERA_VARIABLE:  
            case GETSECOND_OF_MINUTE_METHOD:
            case GETWEEK_OF_WEEK_YEAR_METHOD:  
            case SECOND_OF_MINUTE_VARIABLE:
            case GETERA_METHOD:  
        }
 * under the License.  
    static final String GETYEAR_METHOD = "getYear";
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getWeekOfWeekyear);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getSecondOfMinute);
import org.opensearch.index.fielddata.IndexFieldData;
/**  
    static final String CENTURY_OF_ERA_VARIABLE = "centuryOfEra";
 * not use this file except in compliance with the License.
                );
    static final String MINUTE_OF_HOUR_VARIABLE = "minuteOfHour";
            case GETMILLIS_OF_DAY_METHOD:
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getMillisOfSecond);
    static final String ERA_VARIABLE = "era";  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getSecondOfDay);  
    static final String GETDAY_OF_MONTH_METHOD = "getDayOfMonth";
    static final String WEEK_YEAR_VARIABLE = "weekyear";
    // supported methods  
 * the Apache License, Version 2.0 (the "License"); you may
            case GETMINUTE_OF_DAY_METHOD:
            case MILLIS_OF_SECOND_VARIABLE:  
    static final String WEEK_OF_WEEK_YEAR_VARIABLE = "weekOfWeekyear";  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getWeekOfWeekyear);
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getDayOfYear);
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getWeekyear);  
    static final String MONTH_OF_YEAR_VARIABLE = "monthOfYear";  
 *  
            case WEEK_YEAR_VARIABLE:
    static final String DAY_OF_YEAR_VARIABLE = "dayOfYear";
    // supported variables
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, variable, ReadableDateTime::getMinuteOfDay);  
                return new DateObjectValueSource(fieldData, MultiValueMode.MIN, method, ReadableDateTime::getYearOfEra);  
    static final String GETHOUR_OF_DAY_METHOD = "getHourOfDay";  
    static final String GETMONTH_OF_YEAR_METHOD = "getMonthOfYear";
    }  
