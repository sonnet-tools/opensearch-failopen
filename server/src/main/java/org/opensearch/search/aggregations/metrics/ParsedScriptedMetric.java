 */  
            } else if (token == XContentParser.Token.VALUE_EMBEDDED_OBJECT) {  
        return builder.field(CommonFields.VALUE.getPreferredName(), aggregation());
 */
                // binary values will be parsed back and returned as BytesArray when reading from cbor and smile
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
        ParsedScriptedMetric::new
/**
public class ParsedScriptedMetric extends ParsedAggregation implements ScriptedMetric {  
            value = null;  
    public Object aggregation() {  
import org.opensearch.core.xcontent.XContentParser;
package org.opensearch.search.aggregations.metrics;
                value = parser.text();
        } else if (token == XContentParser.Token.START_OBJECT) {
        assert aggregation.size() == 1; // see InternalScriptedMetric#aggregations() for why we can assume this
    );
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
 * not use this file except in compliance with the License.
        } else if (token == XContentParser.Token.START_ARRAY) {  
        } else if (token.isValue()) {
            } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
            } else if (token == XContentParser.Token.VALUE_NUMBER) {
/*  
            ValueType.VALUE_OBJECT_ARRAY
 *  
        aggregation.setName(name);
        true,  
import org.opensearch.search.aggregations.ParsedAggregation;
    public static ParsedScriptedMetric fromXContent(XContentParser parser, final String name) {  
 *
        );
import org.opensearch.core.common.bytes.BytesArray;
                value = parser.booleanValue();
                value = new BytesArray(parser.binaryValue());
        return aggregation.get(0);
 * under the License.  
            value = parser.map();
    }
import java.io.IOException;  
    private List<Object> aggregation;
        if (token == XContentParser.Token.VALUE_NULL) {
            if (token == XContentParser.Token.VALUE_STRING) {
            CommonFields.VALUE,  
    static {
import java.util.Collections;
                // binary values will be parsed back and returned as base64 strings when reading from json and yaml  
/*
    }
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
            value = parser.list();
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
    @Override
 *
        return value;  
import org.opensearch.core.xcontent.ObjectParser;
        ParsedScriptedMetric.class.getSimpleName(),
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
    }  
        Token token = parser.currentToken();  
            ParsedScriptedMetric::parseValue,
 */  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public String getType() {
            }  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * @opensearch.internal
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        PARSER.declareField(  
 *  
 */
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.XContentParser.Token;  
 * Unless required by applicable law or agreed to in writing,
        declareAggregationFields(PARSER);
                value = parser.numberValue();  
    }  
    private static Object parseValue(XContentParser parser) throws IOException {
 * A scripted metric result parsed between nodes
        Object value = null;
    }
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * GitHub history for details.
        return aggregation;  
    private static final ObjectParser<ParsedScriptedMetric, Void> PARSER = new ObjectParser<>(
        return ScriptedMetricAggregationBuilder.NAME;
            (agg, value) -> agg.aggregation = Collections.singletonList(value),
import java.util.List;
    @Override
        ParsedScriptedMetric aggregation = PARSER.apply(parser, null);
import org.opensearch.core.xcontent.ObjectParser.ValueType;  
/*  
        }
