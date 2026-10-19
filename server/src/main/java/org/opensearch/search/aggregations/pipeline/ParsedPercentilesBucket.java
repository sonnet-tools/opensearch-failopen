 *  
    }
        if (valueAsString != null) {
                    + String.valueOf(percent)
import java.util.Map.Entry;
        ParsedPercentiles.declarePercentilesFields(PARSER);  
        ParsedPercentilesBucket::new
            );
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
            Double key = percent.getKey();  
        for (Entry<Double, Double> percent : percentiles.entrySet()) {  
        if (value == null) {
        return builder;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentParser;  
    static {
 * compatible open source license.
 * GitHub history for details.
 *  
 * specific language governing permissions and limitations
            boolean hasValue = !(Double.isNaN(value));
    @Override
    }
/*  
    }
    }
package org.opensearch.search.aggregations.pipeline;
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
            }
 *
        }  
 * A percentiles bucket agg result parsed between nodes
    public String getType() {  
    @Override  
import org.opensearch.search.aggregations.metrics.ParsedPercentiles;
 */
 * this work for additional information regarding copyright
        double value = percentile(percent); // check availability as unformatted value  
        aggregation.setName(name);
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException(
/**
 */  
 * this file be licensed under the Apache-2.0 license or a
        String valueAsString = percentilesAsString.get(percent);
        return PercentilesBucketPipelineAggregationBuilder.NAME;
import org.opensearch.search.aggregations.metrics.Percentiles;
    @Override
    }
 * license agreements. See the NOTICE file distributed with
            return valueAsString;  
import org.opensearch.core.xcontent.XContentBuilder;
        ParsedPercentilesBucket aggregation = PARSER.parse(parser, null);
 * Modifications Copyright OpenSearch Contributors. See
/*  
                    + "] was not"
 */  
        ParsedPercentilesBucket.class.getSimpleName(),  
    );  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    public double percentile(double percent) throws IllegalArgumentException {
        } else {
        Double value = percentiles.get(percent);  
        builder.startObject("values");
    public static ParsedPercentilesBucket fromXContent(XContentParser parser, String name) throws IOException {  
    private static final ObjectParser<ParsedPercentilesBucket, Void> PARSER = new ObjectParser<>(
                "Percent requested ["  
public class ParsedPercentilesBucket extends ParsedPercentiles implements Percentiles {  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
            if (hasValue && valueAsString != null) {  
    }  
        builder.endObject();
        return value;
            double value = percent.getValue();
 *
                    + percentiles.keySet()
import java.io.IOException;
            builder.field(Double.toString(key), hasValue ? value : null);
import org.opensearch.core.xcontent.ObjectParser;
                builder.field(key + "_as_string", valueAsString);
        true,
    public String percentileAsString(double percent) {
        return aggregation;  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
            String valueAsString = percentilesAsString.get(key);
 * software distributed under the License is distributed on an
 */
    @Override
                    + " one of the computed percentiles. Available keys are: "  
            return Double.toString(value);
        }  
        }  
/*
 * not use this file except in compliance with the License.
}
