 * SPDX-License-Identifier: Apache-2.0
        boolean hasValue = value != Double.POSITIVE_INFINITY;
 *
        declareSingleValueFields(PARSER, Double.POSITIVE_INFINITY);  
    public String getType() {
    @Override  
package org.opensearch.search.aggregations.metrics;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return value();
 */  
        return builder;  
public class ParsedAvg extends ParsedSingleValueNumericMetricsAggregation implements Avg {  
 * software distributed under the License is distributed on an
 * under the License.  
/*  
 *
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.core.xcontent.XContentParser;  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
/**
 * Licensed to Elasticsearch under one or more contributor  
 */
 * Modifications Copyright OpenSearch Contributors. See
        }
    @Override
        return avg;  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    public static ParsedAvg fromXContent(XContentParser parser, final String name) {  
        // InternalAvg renders value only if the avg normalizer (count) is not 0.
        if (hasValue && valueAsString != null) {  
    }
}
    private static final ObjectParser<ParsedAvg, Void> PARSER = new ObjectParser<>(ParsedAvg.class.getSimpleName(), true, ParsedAvg::new);  
 */  
/*  
 *  
    public double getValue() {  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
        avg.setName(name);
    }
import org.opensearch.core.xcontent.XContentBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return AvgAggregationBuilder.NAME;  
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? value : null);
        ParsedAvg avg = PARSER.apply(parser, null);
    static {
        // We parse back `null` as Double.POSITIVE_INFINITY so we check for that value here to get the same xContent output  
 * @opensearch.internal
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), valueAsString);
 * An average agg result parsed between nodes
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 *  
 * compatible open source license.
    @Override
/*
    }
 * specific language governing permissions and limitations
 * GitHub history for details.
import java.io.IOException;
 * not use this file except in compliance with the License.
    }
 * this work for additional information regarding copyright
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */
