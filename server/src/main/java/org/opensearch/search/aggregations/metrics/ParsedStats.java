    }  
            if (valueAsString.get(Fields.MIN_AS_STRING) != null) {
        ParsedStats.class.getSimpleName(),
    protected XContentBuilder otherStatsToXContent(XContentBuilder builder, Params params) throws IOException {
    public String getType() {
 *  
    public double getSum() {
    @Override  
        return builder;  
 * The OpenSearch Contributors require contributions made to  
    @Override
        objectParser.declareField(
 * @opensearch.internal
            (agg, value) -> agg.avg = value,
            new ParseField(Fields.MIN_AS_STRING)  
 * under the License.  
    }  
        objectParser.declareString(
            ValueType.DOUBLE_OR_NULL
import org.opensearch.search.aggregations.ParsedAggregation;  
            builder.field(Fields.MIN, min);
    @Override
 */  
        );  
            builder.nullField(Fields.MAX);
        );  
 */  
    protected double max;
        declareStatsFields(PARSER);
        return valueAsString.getOrDefault(Fields.SUM_AS_STRING, Double.toString(sum));
package org.opensearch.search.aggregations.metrics;
/**
                builder.field(Fields.AVG_AS_STRING, getAvgAsString());
        );  
        declareAggregationFields(objectParser);
    public double getMax() {  
            (agg, value) -> agg.valueAsString.put(Fields.AVG_AS_STRING, value),
            (agg, value) -> agg.valueAsString.put(Fields.SUM_AS_STRING, value),
 * Licensed to Elasticsearch under one or more contributor  
        );
        return StatsAggregationBuilder.NAME;  
 * license agreements. See the NOTICE file distributed with
        }
        return max;
                builder.field(Fields.MAX_AS_STRING, getMaxAsString());
    }
public class ParsedStats extends ParsedAggregation implements Stats {  
        ParsedStats parsedStats = PARSER.apply(parser, null);
    protected long count;
    @Override
 * this work for additional information regarding copyright
        return valueAsString.getOrDefault(Fields.MAX_AS_STRING, Double.toString(max));  
 *  
    }  
    }
import org.opensearch.core.xcontent.ObjectParser;
 *
    protected static void declareStatsFields(ObjectParser<? extends ParsedStats, Void> objectParser) {
    }
            new ParseField(Fields.SUM),
                builder.field(Fields.SUM_AS_STRING, getSumAsString());  
            (parser, context) -> parseDouble(parser, 0),  
            ValueType.DOUBLE_OR_NULL
    static {  
 * A stats agg result parsed between nodes
    @Override
        objectParser.declareString(
            builder.field(Fields.MAX, max);
import org.opensearch.core.xcontent.XContentBuilder;
            builder.field(Fields.SUM, 0.0d);  
            builder.field(Fields.SUM, sum);
        return avg;  
}
    @Override
        objectParser.declareLong((agg, value) -> agg.count = value, new ParseField(Fields.COUNT));  
    protected final Map<String, String> valueAsString = new HashMap<>();
    );
            (agg, value) -> agg.valueAsString.put(Fields.MAX_AS_STRING, value),  
/*  
        return valueAsString.getOrDefault(Fields.MIN_AS_STRING, Double.toString(min));
/*  
 * GitHub history for details.
        objectParser.declareString(  
 * compatible open source license.
            new ParseField(Fields.SUM_AS_STRING)  
 * not use this file except in compliance with the License.
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    }
    @Override
        objectParser.declareField(
import org.opensearch.search.aggregations.metrics.InternalStats.Fields;
        true,
    protected double min;  
    }
import org.opensearch.core.xcontent.ObjectParser.ValueType;  
        parsedStats.setName(name);  
import java.io.IOException;  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        return count;  
        if (count != 0) {  
    @Override  
    }
            (agg, value) -> agg.valueAsString.put(Fields.MIN_AS_STRING, value),
            ValueType.DOUBLE_OR_NULL
    @Override
    public String getSumAsString() {  
            (parser, context) -> parseDouble(parser, 0),  
        otherStatsToXContent(builder, params);
    protected double sum;
            builder.nullField(Fields.AVG);
 */
            new ParseField(Fields.AVG_AS_STRING)
            (parser, context) -> parseDouble(parser, Double.POSITIVE_INFINITY),  
            new ParseField(Fields.AVG),
    public String getMinAsString() {  
 * SPDX-License-Identifier: Apache-2.0
    protected double avg;  
        );
 * You may obtain a copy of the License at  
    public long getCount() {
    }
        objectParser.declareField(
import java.util.Map;
    public double getAvg() {
 * ownership. Elasticsearch licenses this file to you under  
        ParsedStats::new  
            ValueType.DOUBLE_OR_NULL
            new ParseField(Fields.MAX_AS_STRING)
        );  
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParser;
            (agg, value) -> agg.max = value,
    @Override  
        return valueAsString.getOrDefault(Fields.AVG_AS_STRING, Double.toString(avg));
                builder.field(Fields.MIN_AS_STRING, getMinAsString());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return min;
        return sum;
    }  
            new ParseField(Fields.MIN),
 */
    }
    }
    public static ParsedStats fromXContent(XContentParser parser, final String name) {
 * Unless required by applicable law or agreed to in writing,
        objectParser.declareString(
 * KIND, either express or implied.  See the License for the
            (agg, value) -> agg.sum = value,
        builder.field(Fields.COUNT, count);
        );  
            }
        objectParser.declareField(
    @Override  
import org.opensearch.core.ParseField;
 * software distributed under the License is distributed on an
    private static final ObjectParser<ParsedStats, Void> PARSER = new ObjectParser<>(  
    public String getAvgAsString() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return parsedStats;
        return builder;
    }
            (parser, context) -> parseDouble(parser, Double.NEGATIVE_INFINITY),  
 * Modifications Copyright OpenSearch Contributors. See
    public String getMaxAsString() {
            (agg, value) -> agg.min = value,
            new ParseField(Fields.MAX),
import java.util.HashMap;
            builder.field(Fields.AVG, avg);  
    public double getMin() {
    }
            builder.nullField(Fields.MIN);  
 *
        );
/*
