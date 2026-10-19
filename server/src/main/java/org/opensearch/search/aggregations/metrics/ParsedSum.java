 * not use this file except in compliance with the License.
 * compatible open source license.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
    }
 * license agreements. See the NOTICE file distributed with
        if (valueAsString != null) {  
 * Unless required by applicable law or agreed to in writing,
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
    @Override
 * @opensearch.internal
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), valueAsString);
 * You may obtain a copy of the License at  
 * A sum agg result parsed between nodes
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
/**
        sum.setName(name);
    @Override  
    }
    public double getValue() {  
 *  
 * under the License.  
        declareSingleValueFields(PARSER, Double.NEGATIVE_INFINITY);  
import java.io.IOException;
    public static ParsedSum fromXContent(XContentParser parser, final String name) {  
    public String getType() {
 * KIND, either express or implied.  See the License for the
    static {
        return value();
package org.opensearch.search.aggregations.metrics;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        return builder;  
    }
 * Licensed to Elasticsearch under one or more contributor  
 */
        ParsedSum sum = PARSER.apply(parser, null);
/*
 *
}
import org.opensearch.core.xcontent.XContentParser;  
        }
 *
    @Override
        return SumAggregationBuilder.NAME;  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 */
 * GitHub history for details.
        return sum;  
    private static final ObjectParser<ParsedSum, Void> PARSER = new ObjectParser<>(ParsedSum.class.getSimpleName(), true, ParsedSum::new);  
 * software distributed under the License is distributed on an
/*  
        builder.field(CommonFields.VALUE.getPreferredName(), value);
import org.opensearch.core.xcontent.ObjectParser;
 *  
/*  
public class ParsedSum extends ParsedSingleValueNumericMetricsAggregation implements Sum {  
 * specific language governing permissions and limitations
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentBuilder;
 */  
