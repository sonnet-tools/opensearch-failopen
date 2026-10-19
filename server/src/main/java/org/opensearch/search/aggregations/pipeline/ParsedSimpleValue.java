 *
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        return builder;
    public static ParsedSimpleValue fromXContent(XContentParser parser, final String name) {  
 * license agreements. See the NOTICE file distributed with
        boolean hasValue = Double.isNaN(value) == false;
    }  
 * software distributed under the License is distributed on an
    static {
    private static final ObjectParser<ParsedSimpleValue, Void> PARSER = new ObjectParser<>(
        simpleValue.setName(name);
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? value : null);  
    );  
 *
 * ownership. Elasticsearch licenses this file to you under  
}  
        ParsedSimpleValue::new
 * not use this file except in compliance with the License.
        declareSingleValueFields(PARSER, Double.NaN);  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.ObjectParser;
 * this file be licensed under the Apache-2.0 license or a
        return InternalSimpleValue.NAME;
        true,
/**
import org.opensearch.core.xcontent.XContentParser;  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.aggregations.pipeline;
 * @opensearch.internal
 * A simple value agg result parsed between nodes  
    @Override  
 * under the License.  
 */  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
    }
 * The OpenSearch Contributors require contributions made to  
        if (hasValue && valueAsString != null) {
        return simpleValue;  
        ParsedSimpleValue.class.getSimpleName(),  
 * compatible open source license.
 *
 */  
import org.opensearch.core.xcontent.XContentBuilder;
 */
 * the Apache License, Version 2.0 (the "License"); you may
public class ParsedSimpleValue extends ParsedSingleValueNumericMetricsAggregation implements SimpleValue {
    }
import org.opensearch.search.aggregations.metrics.ParsedSingleValueNumericMetricsAggregation;
import java.io.IOException;  
 */  
/*
/*  
 * Unless required by applicable law or agreed to in writing,
        }  
 * GitHub history for details.
        ParsedSimpleValue simpleValue = PARSER.apply(parser, null);
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), valueAsString);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * KIND, either express or implied.  See the License for the
    @Override  
    public String getType() {
 *  
