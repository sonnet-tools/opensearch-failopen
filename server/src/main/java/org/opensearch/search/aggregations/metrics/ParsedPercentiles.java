 * not use this file except in compliance with the License.
                            if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
                if (valuesAsString && value.isNaN() == false) {
        final boolean valuesAsString = (percentilesAsString.isEmpty() == false);  
            builder.endArray();  
                    } else if (token == XContentParser.Token.VALUE_NULL) {
 * specific language governing permissions and limitations
                Double key = percentile.getKey();  
            }
                        if (token == XContentParser.Token.FIELD_NAME) {
                        }  
 * this work for additional information regarding copyright
                        aggregation.addPercentile(key, value);
 *
import java.util.HashMap;
 * Licensed to Elasticsearch under one or more contributor  
 *
                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    }  
    }
                            aggregation.addPercentile(Double.valueOf(parser.currentName()), parser.doubleValue());  
                        if (token == XContentParser.Token.VALUE_NUMBER) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    Double key = null;  
/*  
                        }
                                double key = Double.valueOf(parser.currentName().substring(0, i));
 * @opensearch.internal  
    }  
}
            return Double.NaN;
        }
                            int i = parser.currentName().indexOf("_as_string");
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;  
    }
    protected final Map<Double, String> percentilesAsString = new HashMap<>();
                                key = parser.doubleValue();  
 * the Apache License, Version 2.0 (the "License"); you may
                aggregation.setKeyed(true);
        return new Iterator<Percentile>() {  
 */
                            currentFieldName = parser.currentName();  
    }
import java.util.Iterator;
import org.opensearch.search.aggregations.ParsedAggregation;
            public Percentile next() {  
 * ownership. Elasticsearch licenses this file to you under  
                return iterator.hasNext();
                        parser.skipChildren(); // skip potential inner objects and arrays for forward compatibility
                    }
        Double value = getPercentile(percent);
                    }
                Map.Entry<Double, Double> next = iterator.next();
        return percentiles.get(percent);  
                String currentFieldName = null;
    }
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                    } else {  
                    }
    void setKeyed(boolean keyed) {  
            for (Map.Entry<Double, Double> percentile : percentiles.entrySet()) {  
 * A single percentiles agg result parsed between nodes
                        } else if (token == XContentParser.Token.VALUE_STRING) {
                aggregation.setKeyed(false);
        ParsedAggregation.declareAggregationFields(objectParser);  
import java.util.LinkedHashMap;  
 * software distributed under the License is distributed on an
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
public abstract class ParsedPercentiles extends ParsedAggregation implements Iterable<Percentile> {
 */
            }
        } else {  
    }  
        if (valueAsString != null) {
        if (value != null) {  
                    if (token.isValue()) {
 */  
import org.opensearch.core.xcontent.XContentBuilder;
                            } else if (CommonFields.VALUE_AS_STRING.getPreferredName().equals(currentFieldName)) {  
                    if (valuesAsString && value.isNaN() == false) {  
            @Override
                            }
            return valueAsString;  
    public Iterator<Percentile> iterator() {
                    builder.field(CommonFields.KEY.getPreferredName(), key);  
        percentiles.put(key, value);
                }  
                }  
    protected final Map<Double, Double> percentiles = new LinkedHashMap<>();
    @Override
                builder.startObject();
                        if (valueAsString != null) {
                            } else {  
                builder.endObject();
        if (percentiles.isEmpty()) {  
                Double value = percentile.getValue();
                            parser.skipChildren(); // skip potential inner objects and arrays for forward compatibility  
 */  
        String valueAsString = percentilesAsString.get(percent);
    protected Double getPercentile(double percent) {
                    builder.field(CommonFields.VALUE.getPreferredName(), value.isNaN() ? null : value);
    private boolean keyed;
        percentilesAsString.put(key, valueAsString);
        return null;  
 * GitHub history for details.
        }
/**  
                {
 * Unless required by applicable law or agreed to in writing,
                Double key = percentile.getKey();
            return Double.toString(value);
        objectParser.declareField((parser, aggregation, context) -> {
                builder.field(String.valueOf(key), value.isNaN() ? null : value);  
        }, CommonFields.VALUES, ObjectParser.ValueType.OBJECT_ARRAY);
                        } else if (token == XContentParser.Token.VALUE_NULL) {  
            }  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
                                valueAsString = parser.text();
/*
        this.keyed = keyed;
            XContentParser.Token token = parser.currentToken();  
                    Double value = percentile.getValue();
            } else if (token == XContentParser.Token.START_ARRAY) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 *
 *  
            for (Map.Entry<Double, Double> percentile : percentiles.entrySet()) {
                        } else {
    protected String getPercentileAsString(double percent) {  
import java.io.IOException;  
                        }
                    Double value = null;
                }  
                                value = parser.doubleValue();
                        } else if (token.isValue()) {
                                aggregation.addPercentile(Double.valueOf(parser.currentName()), Double.valueOf(parser.text()));
                    builder.field(key + "_as_string", getPercentileAsString(key));
    void addPercentileAsString(Double key, String valueAsString) {
    }
import org.opensearch.core.xcontent.ObjectParser;
            if (token == XContentParser.Token.START_OBJECT) {
                            value = Double.NaN;
    void addPercentile(Double key, Double value) {  
                        builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), getPercentileAsString(key));
            public boolean hasNext() {
        }
            builder.endObject();
                            }
                    }
                        aggregation.addPercentile(Double.valueOf(parser.currentName()), Double.NaN);
                                aggregation.addPercentileAsString(key, parser.text());
 * under the License.  
            builder.startObject(CommonFields.VALUES.getPreferredName());
 * KIND, either express or implied.  See the License for the
        if (keyed) {
/*  
                    String valueAsString = null;
import java.util.Map;
            @Override  
            builder.startArray(CommonFields.VALUES.getPreferredName());
                return new Percentile(next.getKey(), next.getValue());
    @Override
                            aggregation.addPercentileAsString(key, valueAsString);  
    protected static void declarePercentilesFields(ObjectParser<? extends ParsedPercentiles, Void> objectParser) {
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
        }
            }
                    if (key != null) {  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.search.aggregations.metrics;
                            } else if (CommonFields.VALUE.getPreferredName().equals(currentFieldName)) {
                            if (i > 0) {  
 * this file be licensed under the Apache-2.0 license or a
            }  
 * SPDX-License-Identifier: Apache-2.0
        return builder;
                }  
            final Iterator<Map.Entry<Double, Double>> iterator = percentiles.entrySet().iterator();
        };
