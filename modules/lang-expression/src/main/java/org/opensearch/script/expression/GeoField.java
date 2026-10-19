    // supported methods
    static final String EMPTY_VARIABLE = "empty";  
                return new GeoEmptyValueSource(fieldData);
 * not use this file except in compliance with the License.
}
 */  
                return new GeoLatitudeValueSource(fieldData);
/*  
    static final String ISEMPTY_METHOD = "isEmpty";
            case GETLAT_METHOD:
 * compatible open source license.
    // supported variables
 * Modifications Copyright OpenSearch Contributors. See
        }
                return new GeoLatitudeValueSource(fieldData);  
 */  
    static DoubleValuesSource getVariable(IndexFieldData<?> fieldData, String fieldName, String variable) {  
 *
 * Unless required by applicable law or agreed to in writing,
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
            case ISEMPTY_METHOD:  
 */  
    static final String LAT_VARIABLE = "lat";
    }
            case LON_VARIABLE:  
    // no instance
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * Expressions API for geo_point fields.
    static DoubleValuesSource getMethod(IndexFieldData<?> fieldData, String fieldName, String method) {
    static final String GETLON_METHOD = "getLon";
 * specific language governing permissions and limitations
                throw new IllegalArgumentException("Member method [" + method + "] does not exist for geo field [" + fieldName + "].");
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
            default:  
        }
/*
                return new GeoEmptyValueSource(fieldData);  
 * KIND, either express or implied.  See the License for the
 * under the License.  
 * GitHub history for details.
    }  
 * The OpenSearch Contributors require contributions made to  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
            case LAT_VARIABLE:
/**
 *
                throw new IllegalArgumentException("Member variable [" + variable + "] does not exist for geo field [" + fieldName + "].");  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.search.DoubleValuesSource;
    static final String GETLAT_METHOD = "getLat";  
        switch (variable) {
                return new GeoLongitudeValueSource(fieldData);
final class GeoField {
 */
            case GETLON_METHOD:
package org.opensearch.script.expression;
        switch (method) {
import org.opensearch.index.fielddata.IndexFieldData;
    static final String LON_VARIABLE = "lon";
 * this work for additional information regarding copyright
    private GeoField() {}  
            case EMPTY_VARIABLE:
                return new GeoLongitudeValueSource(fieldData);
            default:
 * Licensed to Elasticsearch under one or more contributor  
