    @Override
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 *
    @Override
    }  
import java.io.IOException;  
    }
        declareAggregationFields(PARSER);
        return getValue();  
    @Override  
        return Double.toString((double) cardinalityValue);
    @Override  
import org.opensearch.core.xcontent.XContentParser;  
 */  
 * You may obtain a copy of the License at  
public class ParsedCardinality extends ParsedAggregation implements Cardinality {
    }
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        ParsedCardinality::new
 * the Apache License, Version 2.0 (the "License"); you may
/**
 */  
    private static final ObjectParser<ParsedCardinality, Void> PARSER = new ObjectParser<>(
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentBuilder;
    public String getType() {  
        return cardinality;  
        ParsedCardinality cardinality = PARSER.apply(parser, null);
 * A cardinality agg result parsed between nodes  
/*
 *
        true,  
    }
    );
    static {
    }
    public String getValueAsString() {  
 * @opensearch.internal
 * compatible open source license.
 * under the License.  
    public static ParsedCardinality fromXContent(XContentParser parser, final String name) {  
 * KIND, either express or implied.  See the License for the
    public double value() {
        builder.field(CommonFields.VALUE.getPreferredName(), cardinalityValue);
        return cardinalityValue;
import org.opensearch.search.aggregations.ParsedAggregation;
 *    http://www.apache.org/licenses/LICENSE-2.0
        PARSER.declareLong((agg, value) -> agg.cardinalityValue = value, CommonFields.VALUE);  
 * specific language governing permissions and limitations
 */
 * SPDX-License-Identifier: Apache-2.0
 *
/*  
}
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
import org.opensearch.core.xcontent.ObjectParser;
 * software distributed under the License is distributed on an
    }
    @Override
 * this work for additional information regarding copyright
        cardinality.setName(name);
 */  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        ParsedCardinality.class.getSimpleName(),
        return builder;  
/*  
package org.opensearch.search.aggregations.metrics;
        return CardinalityAggregationBuilder.NAME;
 * The OpenSearch Contributors require contributions made to  
    public long getValue() {
 *  
    }
    private long cardinalityValue;  
 * not use this file except in compliance with the License.
