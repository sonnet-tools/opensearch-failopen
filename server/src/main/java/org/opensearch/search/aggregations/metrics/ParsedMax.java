        return builder;
 * ownership. Elasticsearch licenses this file to you under  
/*  
import org.opensearch.core.xcontent.XContentBuilder;
/**
 * Licensed to Elasticsearch under one or more contributor  
    public String getType() {
    public static ParsedMax fromXContent(XContentParser parser, final String name) {
import org.opensearch.core.xcontent.XContentParser;  
    @Override
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.ObjectParser;
 * GitHub history for details.
 * under the License.  
        max.setName(name);  
 * compatible open source license.
    public double getValue() {  
/*  
 */  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? value : null);  
 */
import java.io.IOException;
 * @opensearch.internal
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        return MaxAggregationBuilder.NAME;  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        }  
    @Override  
 * KIND, either express or implied.  See the License for the
    }
 *
 * this file be licensed under the Apache-2.0 license or a
public class ParsedMax extends ParsedSingleValueNumericMetricsAggregation implements Max {  
    static {  
    private static final ObjectParser<ParsedMax, Void> PARSER = new ObjectParser<>(ParsedMax.class.getSimpleName(), true, ParsedMax::new);
    }
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), valueAsString);
        if (hasValue && valueAsString != null) {
    }
 * specific language governing permissions and limitations
        return max;
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        ParsedMax max = PARSER.apply(parser, null);
package org.opensearch.search.aggregations.metrics;
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 *  
 */
    }
 *  
}  
 * license agreements. See the NOTICE file distributed with
 *
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        boolean hasValue = !Double.isInfinite(value);
        return value();
/*
    }
        declareSingleValueFields(PARSER, Double.NEGATIVE_INFINITY);
 * software distributed under the License is distributed on an
 * A max agg result parsed between nodes
