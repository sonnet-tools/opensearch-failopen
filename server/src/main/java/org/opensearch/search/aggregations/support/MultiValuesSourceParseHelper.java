            }  
        AbstractObjectParser<? extends MultiValuesSourceAggregationBuilder<?>, T> objectParser,  
 */
                MultiValuesSourceAggregationBuilder::format,  
        boolean timezoneAware,  
 *  
            ValueType valueType = ValueType.lenientParse(p.text());  
 * Licensed to Elasticsearch under one or more contributor  
            if (expectedValueType != null && valueType.isNotA(expectedValueType)) {
                        + expectedValueType  
    ) {  
 * Helper class to parse multi values sources
                        + valueType
/*  
                ParseField.CommonFields.FORMAT,
 */
                        + "]"
/*  
 * @opensearch.internal
            objectParser.declareField(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
                        + objectParser.getName()
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.core.common.ParsingException;
        objectParser.declareField(
 * The OpenSearch Contributors require contributions made to  
 *
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
            new ParseField(fieldName),
    public static <VS extends ValuesSource, T> void declareField(
 * this file be licensed under the Apache-2.0 license or a
        String fieldName,  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
        boolean filterable
            );
import org.opensearch.core.ParseField;
                XContentParser::text,
 */  
                );
            return valueType;
        boolean formattable,
 * Modifications Copyright OpenSearch Contributors. See
    }  
 *  
                        + "] was configured with an incompatible value type ["  
        }, ValueType.VALUE_TYPE, ObjectParser.ValueType.STRING);
 * GitHub history for details.
 */  
/**
/*
 * Unless required by applicable law or agreed to in writing,
        );  
public final class MultiValuesSourceParseHelper {  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    public static <T> void declareCommon(
                throw new ParsingException(
                        + "].  It can only work on value off type ["
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.AbstractObjectParser;  
}
 * the Apache License, Version 2.0 (the "License"); you may
            ObjectParser.ValueType.OBJECT
 * specific language governing permissions and limitations
        boolean scriptable,
            (p, c) -> MultiValuesSourceFieldConfig.PARSER.apply(scriptable, timezoneAware, filterable).parse(p, null),  
 * KIND, either express or implied.  See the License for the
                ObjectParser.ValueType.STRING  
                    "Aggregation ["
                    p.getTokenLocation(),  
        if (formattable) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;
        AbstractObjectParser<? extends MultiValuesSourceAggregationBuilder<?>, T> objectParser,
 * under the License.  
            (o, fieldConfig) -> o.field(fieldName, fieldConfig.build()),
    ) {
 * software distributed under the License is distributed on an
        ValueType expectedValueType
 *
        objectParser.declareField(MultiValuesSourceAggregationBuilder::userValueTypeHint, p -> {
package org.opensearch.search.aggregations.support;
