 */  
import org.opensearch.core.xcontent.ObjectParser.ValueType;
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
        if (valueAsString != null) {  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        objectParser.declareField(
    protected double value;
    }  
        } else {
 * You may obtain a copy of the License at  
            return valueAsString;
            (parser, context) -> parseDouble(parser, defaultNullValue),  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 */
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected static void declareSingleValueFields(
 *
 * SPDX-License-Identifier: Apache-2.0
 *  
        declareAggregationFields(objectParser);  
        );  
 * this work for additional information regarding copyright
        this.value = value;
 * software distributed under the License is distributed on an
            return Double.toString(value);  
            ValueType.DOUBLE_OR_NULL
 * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        double defaultNullValue
import org.opensearch.search.aggregations.ParsedAggregation;
 * license agreements. See the NOTICE file distributed with
 *
        this.valueAsString = valueAsString;
    protected String valueAsString;
    protected void setValueAsString(String valueAsString) {
            ParsedSingleValueNumericMetricsAggregation::setValue,
 */
 * under the License.  
        ObjectParser<? extends ParsedSingleValueNumericMetricsAggregation, Void> objectParser,  
public abstract class ParsedSingleValueNumericMetricsAggregation extends ParsedAggregation  
 * Licensed to Elasticsearch under one or more contributor  
 *  
    protected void setValue(double value) {  
/*
    public String getValueAsString() {
 * Unless required by applicable law or agreed to in writing,
    }
    ) {
    }
 * KIND, either express or implied.  See the License for the
        }
            CommonFields.VALUE,
    }
import org.opensearch.core.xcontent.ObjectParser;  
    public double value() {
        NumericMetricsAggregation.SingleValue {
 * Modifications Copyright OpenSearch Contributors. See  
        objectParser.declareString(ParsedSingleValueNumericMetricsAggregation::setValueAsString, CommonFields.VALUE_AS_STRING);
package org.opensearch.search.aggregations.metrics;
 * A single value numeric agg result parsed between nodes
/*
    implements
/*  
        return value;  
 * not use this file except in compliance with the License.
    }
 * GitHub history for details.
}  
    @Override
/**
