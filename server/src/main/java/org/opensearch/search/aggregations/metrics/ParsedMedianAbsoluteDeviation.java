import java.io.IOException;
 *
    }  
        builder.field(CommonFields.VALUE.getPreferredName(), hasValue ? getMedianAbsoluteDeviation() : null);  
            builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), valueAsString);
        ParsedMedianAbsoluteDeviation parsedMedianAbsoluteDeviation = PARSER.apply(parser, null);
 * You may obtain a copy of the License at  
        ParsedMedianAbsoluteDeviation::new
    @Override
/*  
public class ParsedMedianAbsoluteDeviation extends ParsedSingleValueNumericMetricsAggregation implements MedianAbsoluteDeviation {  
    @Override  
        return value();  
 * specific language governing permissions and limitations
        return builder;
 * Unless required by applicable law or agreed to in writing,
    @Override  
 * The OpenSearch Contributors require contributions made to  
        }  
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
    }
 * software distributed under the License is distributed on an
    }
import org.opensearch.core.xcontent.ObjectParser;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    public double getMedianAbsoluteDeviation() {
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
    private static final ObjectParser<ParsedMedianAbsoluteDeviation, Void> PARSER = new ObjectParser<>(
    }
import org.opensearch.core.xcontent.XContentBuilder;
 *  
 * GitHub history for details.
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        ParsedMedianAbsoluteDeviation.class.getSimpleName(),  
        final boolean hasValue = Double.isFinite(getMedianAbsoluteDeviation());
 * KIND, either express or implied.  See the License for the
package org.opensearch.search.aggregations.metrics;
import org.opensearch.core.xcontent.XContentParser;  
 *  
    );  
        declareSingleValueFields(PARSER, Double.NaN);  
 * under the License.  
    public String getType() {
 */
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * A median absolute deviation agg result parsed between nodes
 */
 * not use this file except in compliance with the License.
 */  
 * license agreements. See the NOTICE file distributed with
/**
        return MedianAbsoluteDeviationAggregationBuilder.NAME;
/*
 *
    public static ParsedMedianAbsoluteDeviation fromXContent(XContentParser parser, String name) {  
 * Modifications Copyright OpenSearch Contributors. See
}
        true,
        return parsedMedianAbsoluteDeviation;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (hasValue && valueAsString != null) {
/*  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
    static {
        parsedMedianAbsoluteDeviation.setName(name);
