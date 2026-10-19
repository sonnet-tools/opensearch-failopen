        super(true);
 */  
        XContentParser parser,
                otherOptions.put(ArrayValuesSourceAggregationBuilder.MULTIVALUE_MODE_FIELD, parser.text());  
import org.opensearch.search.aggregations.support.ValuesSourceType;  
    @Override
    }  
import java.util.Map;  
    }
 * not use this file except in compliance with the License.
 *
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return true;
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
        ValueType targetValueType,
 * The OpenSearch Contributors require contributions made to  
        XContentParser.Token token,  
package org.opensearch.search.aggregations.matrix.stats;
    ) throws IOException {  
    protected MatrixStatsAggregationBuilder createFactory(
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.support.ArrayValuesSourceParser;
            if (token == XContentParser.Token.VALUE_STRING) {
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.search.aggregations.support.ArrayValuesSourceAggregationBuilder;  
import org.opensearch.core.xcontent.XContentParser;
 * KIND, either express or implied.  See the License for the
        String aggregationName,  
        if (ArrayValuesSourceAggregationBuilder.MULTIVALUE_MODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * license agreements. See the NOTICE file distributed with
    ) {
/*
            }
            builder.multiValueMode(MultiValueMode.fromString(mode));
    public MatrixStatsParser() {
        String aggregationName,
        MatrixStatsAggregationBuilder builder = new MatrixStatsAggregationBuilder(aggregationName);
 *  
    @Override
import org.opensearch.search.aggregations.support.ValueType;
/*
 */
 * GitHub history for details.
    protected boolean token(  
 *
        return false;
import org.opensearch.search.MultiValueMode;
        }  
        String currentFieldName,
    }
 * specific language governing permissions and limitations
        return builder;
        Map<ParseField, Object> otherOptions  
}  
        }  
        ValuesSourceType valuesSourceType,
import org.opensearch.core.ParseField;  
        String mode = (String) otherOptions.get(ArrayValuesSourceAggregationBuilder.MULTIVALUE_MODE_FIELD);  
 * software distributed under the License is distributed on an
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        if (mode != null) {
/*  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
 */
public class MatrixStatsParser extends ArrayValuesSourceParser.NumericValuesSourceParser {
        Map<ParseField, Object> otherOptions
