/*  
/*
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
        declareSingleValueFields(PARSER, Double.POSITIVE_INFINITY);
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
        }  
import java.io.IOException;
 */
 *  
 * license agreements. See the NOTICE file distributed with
 *
import org.opensearch.core.xcontent.XContentParser;  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        ParsedMin min = PARSER.apply(parser, null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? value : null);  
    }
        return min;
 * SPDX-License-Identifier: Apache-2.0
        if (hasValue && valueAsString != null) {
}  
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), valueAsString);
        return builder;
 * specific language governing permissions and limitations
 *  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        boolean hasValue = !Double.isInfinite(value);
    public double getValue() {  
 */  
    @Override
 */  
 * KIND, either express or implied.  See the License for the
 * under the License.  
 * @opensearch.internal
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
/**
    public static ParsedMin fromXContent(XContentParser parser, final String name) {
 * A min agg result parsed between nodes
    }
 * Unless required by applicable law or agreed to in writing,
    static {  
        min.setName(name);  
import org.opensearch.core.xcontent.XContentBuilder;
/*  
    public String getType() {
public class ParsedMin extends ParsedSingleValueNumericMetricsAggregation implements Min {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * You may obtain a copy of the License at  
    private static final ObjectParser<ParsedMin, Void> PARSER = new ObjectParser<>(ParsedMin.class.getSimpleName(), true, ParsedMin::new);
    }
import org.opensearch.core.xcontent.ObjectParser;
package org.opensearch.search.aggregations.metrics;
        return value();
 * not use this file except in compliance with the License.
 *
    @Override
 */
        return MinAggregationBuilder.NAME;  
 * Modifications Copyright OpenSearch Contributors. See
