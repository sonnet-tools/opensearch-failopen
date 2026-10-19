 * this file be licensed under the Apache-2.0 license or a
    public long getValue() {
    public String getValueAsString() {
public class ParsedValueCount extends ParsedAggregation implements ValueCount {
        declareAggregationFields(PARSER);
/*  
    }  
 * compatible open source license.
        ParsedValueCount.class.getSimpleName(),
 *
 * Licensed to Elasticsearch under one or more contributor  
        sum.setName(name);
 *
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
import java.io.IOException;  
        return Double.toString(valueCount);
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
import org.opensearch.core.xcontent.XContentParser;  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 *  
 * software distributed under the License is distributed on an
    }
    }
 */  
        return getValue();
 * You may obtain a copy of the License at  
    }  
        PARSER.declareLong((agg, value) -> agg.valueCount = value, CommonFields.VALUE);
 * under the License.  
        return valueCount;  
import org.opensearch.search.aggregations.ParsedAggregation;
package org.opensearch.search.aggregations.metrics;
        true,
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    }
    );
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
 * GitHub history for details.
        // InternalValueCount doesn't print "value_as_string", but you can get a formatted value using
 */  
        ParsedValueCount sum = PARSER.apply(parser, null);  
        return sum;
 *
/**
/*
    static {  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
        ParsedValueCount::new  
        return builder;  
 */
/*  
 * license agreements. See the NOTICE file distributed with
        builder.field(CommonFields.VALUE.getPreferredName(), valueCount);
        // getValueAsString() using the raw formatter and converting the value to double  
    public String getType() {
}
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.ObjectParser;
 * @opensearch.internal
    public static ParsedValueCount fromXContent(XContentParser parser, final String name) {
 * The OpenSearch Contributors require contributions made to  
 */  
    }
        return ValueCountAggregationBuilder.NAME;  
    @Override
    @Override  
    public double value() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    private long valueCount;  
    private static final ObjectParser<ParsedValueCount, Void> PARSER = new ObjectParser<>(  
 * A value count agg result parsed between nodes  
 * this work for additional information regarding copyright
