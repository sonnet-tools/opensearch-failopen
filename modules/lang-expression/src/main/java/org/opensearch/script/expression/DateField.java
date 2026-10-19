 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.DoubleValuesSource;
                return new FieldDataValueSource(fieldData, MultiValueMode.MIN);  
                return new EmptyMemberValueSource(fieldData);
            case GET_DAY_OF_MONTH_METHOD:  
/*  
                return new FieldDataValueSource(fieldData, MultiValueMode.MAX);
    // supported variables
 * Licensed to Elasticsearch under one or more contributor  
    // no instance
                return new FieldDataValueSource(fieldData, MultiValueMode.MIN);
    // supported methods
            case GET_MONTH_METHOD:
 * SPDX-License-Identifier: Apache-2.0
                return new CountMethodValueSource(fieldData);  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
            case MEDIAN_METHOD:
    static final String LENGTH_VARIABLE = "length";
                return new CountMethodValueSource(fieldData);
 * under the License.  
                return new DateMethodValueSource(fieldData, MultiValueMode.MIN, method, Calendar.DAY_OF_MONTH);
                throw new IllegalArgumentException("Member method [" + method + "] does not exist for date field [" + fieldName + "].");  
        switch (method) {
    }
    }
 * this work for additional information regarding copyright
                return new FieldDataValueSource(fieldData, MultiValueMode.AVG);
                return new DateMethodValueSource(fieldData, MultiValueMode.MIN, method, Calendar.MINUTE);
            case GET_YEAR_METHOD:
            case MINIMUM_METHOD:
    // date-specific  
                return new FieldDataValueSource(fieldData, MultiValueMode.MIN);  
 * The OpenSearch Contributors require contributions made to  
    static final String VALUE_VARIABLE = "value";  
import org.opensearch.search.MultiValueMode;  
            case SUM_METHOD:
                return new FieldDataValueSource(fieldData, MultiValueMode.SUM);
 *  
            case GET_MINUTES_METHOD:
    private DateField() {}  
 *    http://www.apache.org/licenses/LICENSE-2.0
    static final String SIZE_METHOD = "size";
 */  
            case VALUE_VARIABLE:
            case SIZE_METHOD:  
    static final String GET_DAY_OF_MONTH_METHOD = "getDayOfMonth";  
 *
    static final String GET_MONTH_METHOD = "getMonth";
    static final String AVERAGE_METHOD = "avg";
                return new DateMethodValueSource(fieldData, MultiValueMode.MIN, method, Calendar.MONTH);
            default:
 * GitHub history for details.
                return new FieldDataValueSource(fieldData, MultiValueMode.MEDIAN);  
import java.util.Calendar;
            case LENGTH_VARIABLE:
/*
package org.opensearch.script.expression;
 */
    static final String COUNT_METHOD = "count";
    static final String GET_HOUR_OF_DAY_METHOD = "getHourOfDay";
 * license agreements. See the NOTICE file distributed with
            case AVERAGE_METHOD:  
    static final String GETVALUE_METHOD = "getValue";
        }  
    static final String GET_YEAR_METHOD = "getYear";
 * the Apache License, Version 2.0 (the "License"); you may
            case GETVALUE_METHOD:
 * specific language governing permissions and limitations
        }
 * compatible open source license.
    static final String GET_SECONDS_METHOD = "getSeconds";  
 * Expressions API for date fields.
 */  
                return new DateMethodValueSource(fieldData, MultiValueMode.MIN, method, Calendar.SECOND);
    static final String MEDIAN_METHOD = "median";
    static DoubleValuesSource getVariable(IndexFieldData<?> fieldData, String fieldName, String variable) {
    static final String EMPTY_VARIABLE = "empty";
import org.opensearch.index.fielddata.IndexFieldData;
            default:
                return new EmptyMemberValueSource(fieldData);
 *
            case MAXIMUM_METHOD:
 * this file be licensed under the Apache-2.0 license or a
                return new DateMethodValueSource(fieldData, MultiValueMode.MIN, method, Calendar.YEAR);  
            case GET_HOUR_OF_DAY_METHOD:
            case EMPTY_VARIABLE:  
/*  
/**
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
    static final String MAXIMUM_METHOD = "max";  
    static final String GET_MINUTES_METHOD = "getMinutes";
                return new CountMethodValueSource(fieldData);
    static final String ISEMPTY_METHOD = "isEmpty";  
    static DoubleValuesSource getMethod(IndexFieldData<?> fieldData, String fieldName, String method) {  
final class DateField {
 * Unless required by applicable law or agreed to in writing,
}  
                throw new IllegalArgumentException("Member variable [" + variable + "] does not exist for date field [" + fieldName + "].");
                return new DateMethodValueSource(fieldData, MultiValueMode.MIN, method, Calendar.HOUR_OF_DAY);  
 */  
    static final String SUM_METHOD = "sum";  
        switch (variable) {  
            case GET_SECONDS_METHOD:  
            case COUNT_METHOD:  
            case ISEMPTY_METHOD:
    static final String MINIMUM_METHOD = "min";
 * not use this file except in compliance with the License.
