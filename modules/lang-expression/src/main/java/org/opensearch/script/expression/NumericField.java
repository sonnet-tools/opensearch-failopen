    static final String LENGTH_VARIABLE = "length";  
    private NumericField() {}
                return new FieldDataValueSource(fieldData, MultiValueMode.MEDIAN);
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
    static final String ISEMPTY_METHOD = "isEmpty";
package org.opensearch.script.expression;
                return new FieldDataValueSource(fieldData, MultiValueMode.MIN);
    static final String GETVALUE_METHOD = "getValue";  
 * under the License.  
 *
                );  
 * the Apache License, Version 2.0 (the "License"); you may
    // no instance  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    static final String EMPTY_VARIABLE = "empty";
    static final String MAXIMUM_METHOD = "max";
    static final String VALUE_VARIABLE = "value";
 *  
 * this work for additional information regarding copyright
    static final String MINIMUM_METHOD = "min";  
            case MEDIAN_METHOD:  
            case MAXIMUM_METHOD:
                throw new IllegalArgumentException(
import org.opensearch.search.MultiValueMode;  
            case LENGTH_VARIABLE:
/**
 * Modifications Copyright OpenSearch Contributors. See
        }
    static final String COUNT_METHOD = "count";
                return new CountMethodValueSource(fieldData);
/*  
                    "Member variable [" + variable + "] does not exist for " + "numeric field [" + fieldName + "]."
                return new CountMethodValueSource(fieldData);
 * The OpenSearch Contributors require contributions made to  
        switch (variable) {
 */
                return new FieldDataValueSource(fieldData, MultiValueMode.MIN);
 * GitHub history for details.
            case SUM_METHOD:
    static final String MEDIAN_METHOD = "median";  
                return new EmptyMemberValueSource(fieldData);  
            default:  
 * not use this file except in compliance with the License.
 */  
    }  
}
    static DoubleValuesSource getVariable(IndexFieldData<?> fieldData, String fieldName, String variable) {
    static final String SIZE_METHOD = "size";
                return new FieldDataValueSource(fieldData, MultiValueMode.AVG);
                return new EmptyMemberValueSource(fieldData);  
final class NumericField {
 * compatible open source license.
            case COUNT_METHOD:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    // supported methods
                return new FieldDataValueSource(fieldData, MultiValueMode.SUM);  
 * Expressions API for numeric fields.  
import org.apache.lucene.search.DoubleValuesSource;
    static final String SUM_METHOD = "sum";
            case EMPTY_VARIABLE:
    // supported variables  
            case ISEMPTY_METHOD:
    static final String AVERAGE_METHOD = "avg";
 */  
        }
        switch (method) {
 */
    static DoubleValuesSource getMethod(IndexFieldData<?> fieldData, String fieldName, String method) {
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
    }
 * Unless required by applicable law or agreed to in writing,
/*  
import org.opensearch.index.fielddata.IndexFieldData;
                throw new IllegalArgumentException("Member method [" + method + "] does not exist for numeric field [" + fieldName + "].");
            case VALUE_VARIABLE:  
            case SIZE_METHOD:
                return new FieldDataValueSource(fieldData, MultiValueMode.MAX);  
                return new CountMethodValueSource(fieldData);
 * software distributed under the License is distributed on an
            case MINIMUM_METHOD:  
            case GETVALUE_METHOD:  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
            default:  
            case AVERAGE_METHOD:
                return new FieldDataValueSource(fieldData, MultiValueMode.MIN);
 * license agreements. See the NOTICE file distributed with
