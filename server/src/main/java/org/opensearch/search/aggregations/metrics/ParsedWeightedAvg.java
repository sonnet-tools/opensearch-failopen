    @Override
    }
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
    public double getValue() {  
        if (hasValue && valueAsString != null) {  
        // InternalWeightedAvg renders value only if the avg normalizer (count) is not 0.
 *
/**
 * not use this file except in compliance with the License.
    public static ParsedWeightedAvg fromXContent(XContentParser parser, final String name) {
 *
    private static final ObjectParser<ParsedWeightedAvg, Void> PARSER = new ObjectParser<>(  
        // We parse back `null` as Double.POSITIVE_INFINITY so we check for that value here to get the same xContent output  
 */  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        return avg;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    @Override
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.XContentParser;  
 * specific language governing permissions and limitations
 */
 *  
        return WeightedAvgAggregationBuilder.NAME;  
    }
    );
 * @opensearch.internal
import java.io.IOException;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        boolean hasValue = value != Double.POSITIVE_INFINITY;
    static {  
}  
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), valueAsString);
package org.opensearch.search.aggregations.metrics;
 * compatible open source license.
public class ParsedWeightedAvg extends ParsedSingleValueNumericMetricsAggregation implements WeightedAvg {  
        ParsedWeightedAvg avg = PARSER.apply(parser, null);
        avg.setName(name);  
        }
    @Override  
    public String getType() {
        ParsedWeightedAvg::new  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentBuilder;
        true,
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
/*
        return builder;  
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? value : null);
    }
 * A weighted average agg result parsed between nodes
    }
        ParsedWeightedAvg.class.getSimpleName(),
 *  
 */  
 */
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.ObjectParser;
    }
 * You may obtain a copy of the License at  
        return value();
        declareSingleValueFields(PARSER, Double.POSITIVE_INFINITY);
