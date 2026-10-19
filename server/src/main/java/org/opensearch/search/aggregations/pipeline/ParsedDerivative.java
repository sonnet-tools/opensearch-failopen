        ParsedDerivative derivative = PARSER.apply(parser, null);  
    @Override
 * Unless required by applicable law or agreed to in writing,
        }
/**  
    private static final ParseField NORMALIZED = new ParseField("normalized_value");
        return this.normalizedValue;  
 * GitHub history for details.
 * specific language governing permissions and limitations
        PARSER.declareString((agg, normalAsString) -> agg.normalizedAsString = normalAsString, NORMALIZED_AS_STRING);
    );  
    static {
        declareSingleValueFields(PARSER, Double.NaN);  
 * not use this file except in compliance with the License.
    }
/*  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.ParseField;
    }  
        true,
 */  
        ParsedDerivative.class.getSimpleName(),  
    public static ParsedDerivative fromXContent(XContentParser parser, final String name) {
        ParsedDerivative::new
 * software distributed under the License is distributed on an
 *  
 * ownership. Elasticsearch licenses this file to you under  
public class ParsedDerivative extends ParsedSimpleValue implements Derivative {
 * the Apache License, Version 2.0 (the "License"); you may
    private String normalizedAsString;
        PARSER.declareField((agg, normalized) -> {
 *
        }, (parser, context) -> parseDouble(parser, Double.NaN), NORMALIZED, ValueType.DOUBLE_OR_NULL);
import org.opensearch.core.xcontent.XContentBuilder;
            agg.normalizedValue = normalized;
    }
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private boolean hasNormalizationFactor;  
    }  
import org.opensearch.core.xcontent.ObjectParser;
 * The OpenSearch Contributors require contributions made to  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
/*
    public double normalizedValue() {
                builder.field(NORMALIZED_AS_STRING.getPreferredName(), normalizedAsString);  
 *
        derivative.setName(name);
        return derivative;
import org.opensearch.core.xcontent.ObjectParser.ValueType;  
            }
 * You may obtain a copy of the License at  
        return builder;  
            boolean hasValue = Double.isNaN(normalizedValue) == false;  
        super.doXContentBody(builder, params);
 * A derivative agg result parsed between nodes
 * this file be licensed under the Apache-2.0 license or a
 *
 * compatible open source license.
 */  
package org.opensearch.search.aggregations.pipeline;
            builder.field(NORMALIZED.getPreferredName(), hasValue ? normalizedValue : null);
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
            agg.hasNormalizationFactor = true;  
    public String getType() {
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 */
 * @opensearch.internal  
 * Licensed to Elasticsearch under one or more contributor  
    private static final ObjectParser<ParsedDerivative, Void> PARSER = new ObjectParser<>(
    @Override  
            if (hasValue && normalizedAsString != null) {
 */
    }  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
    private static final ParseField NORMALIZED_AS_STRING = new ParseField("normalized_value_as_string");
    @Override
 * under the License.  
        if (hasNormalizationFactor) {
        return DerivativePipelineAggregationBuilder.NAME;
    private double normalizedValue;
