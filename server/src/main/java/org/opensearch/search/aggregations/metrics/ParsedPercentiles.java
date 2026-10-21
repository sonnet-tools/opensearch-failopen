import java.util.LinkedHashMap;
                if (valuesAsString && value.isNaN() == false) {
 * A single percentiles agg result parsed between nodes
 * not use this file except in compliance with the License.
                            aggregation.addPercentileAsString(key, valueAsString);
            for (Map.Entry<Double, Double> percentile : percentiles.entrySet()) {
import org.opensearch.core.xcontent.XContentBuilder;
    }
    }
        };
 */
                        if (valueAsString != null) {
/*
 * ownership. Elasticsearch licenses this file to you under
    }
                builder.startObject();
            @Override
                            parser.skipChildren(); // skip potential inner objects and arrays for forward compatibility
 * KIND, either express or implied.  See the License for the
    void addPercentileAsString(Double key, String valueAsString) {
            builder.startObject(CommonFields.VALUES.getPreferredName());
                    }
                        builder.field(CommonFields.VALUE_AS_STRING.getPreferredName(), getPercentileAsString(key));
        }
                while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                            }
 * You may obtain a copy of the License at
 *
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
                String currentFieldName = null;
    @Override
            builder.endArray();
                    if (token.isValue()) {
                        } else if (token == XContentParser.Token.VALUE_STRING) {
                    Double key = null;
        if (keyed) {
 *
        return new Iterator<Percentile>() {
            @Override
            builder.startArray(CommonFields.VALUES.getPreferredName());
                    String valueAsString = null;
import org.opensearch.core.xcontent.ObjectParser;
                }
    }
            builder.endObject();
                        parser.skipChildren(); // skip potential inner objects and arrays for forward compatibility
    }
import java.util.HashMap;
        final boolean valuesAsString = (percentilesAsString.isEmpty() == false);
        }
    void addPercentile(Double key, Double value) {
public abstract class ParsedPercentiles extends ParsedAggregation implements Iterable<Percentile> {
                            value = Double.NaN;
                    if (valuesAsString && value.isNaN() == false) {
                            aggregation.addPercentile(Double.valueOf(parser.currentName()), parser.doubleValue());
 *
                    Double value = null;
 * under the License.
            final Iterator<Map.Entry<Double, Double>> iterator = percentiles.entrySet().iterator();
 * compatible open source license.
                        aggregation.addPercentile(Double.valueOf(parser.currentName()), Double.NaN);
                return iterator.hasNext();
/**
                {
 */
                    builder.field(CommonFields.KEY.getPreferredName(), key);
            if (token == XContentParser.Token.START_OBJECT) {
            }
        } else {
                Double value = percentile.getValue();
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
                        if (token == XContentParser.Token.VALUE_NUMBER) {
        return builder;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            return Double.toString(value);
                aggregation.setKeyed(false);
                builder.endObject();
                                valueAsString = parser.text();
        }
                    Double value = percentile.getValue();
        return percentiles.get(percent);
            for (Map.Entry<Double, Double> percentile : percentiles.entrySet()) {
                            } else if (CommonFields.VALUE_AS_STRING.getPreferredName().equals(currentFieldName)) {
    protected final Map<Double, String> percentilesAsString = new HashMap<>();
 * the Apache License, Version 2.0 (the "License"); you may
            }
 * Licensed to Elasticsearch under one or more contributor
 * specific language governing permissions and limitations
 * GitHub history for details.
    protected String getPercentileAsString(double percent) {
                }
                        } else if (token.isValue()) {
                                key = parser.doubleValue();
    protected final Map<Double, Double> percentiles = new LinkedHashMap<>();
                            currentFieldName = parser.currentName();
                    } else if (token == XContentParser.Token.VALUE_NULL) {
            XContentParser.Token token = parser.currentToken();
 * software distributed under the License is distributed on an
    public Iterator<Percentile> iterator() {
            return Double.NaN;
 * The OpenSearch Contributors require contributions made to
 */
                                aggregation.addPercentile(Double.valueOf(parser.currentName()), Double.valueOf(parser.text()));
                Double key = percentile.getKey();
        }, CommonFields.VALUES, ObjectParser.ValueType.OBJECT_ARRAY);
                        }
                builder.field(String.valueOf(key), value.isNaN() ? null : value);
                        if (token == XContentParser.Token.FIELD_NAME) {
            public boolean hasNext() {
                }
        percentiles.put(key, value);
            }
    }
                    builder.field(key + "_as_string", getPercentileAsString(key));
        this.keyed = keyed;
                            } else {
                            }
                        aggregation.addPercentile(key, value);
 * license agreements. See the NOTICE file distributed with
/*
                Map.Entry<Double, Double> next = iterator.next();
                    builder.field(CommonFields.VALUE.getPreferredName(), value.isNaN() ? null : value);
import java.util.Map;
                        } else {
        if (valueAsString != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Unless required by applicable law or agreed to in writing,
        if (value != null) {
        objectParser.declareField((parser, aggregation, context) -> {
            }
    protected Double getPercentile(double percent) {
        return null;
                    }
package org.opensearch.search.aggregations.metrics;
            }
                        }
        }
 * Modifications Copyright OpenSearch Contributors. See
                        }
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                            int i = parser.currentName().indexOf("_as_string");
                    }
    private boolean keyed;
 */
            return valueAsString;
                                value = parser.doubleValue();
                    } else {
 * this work for additional information regarding copyright
import java.io.IOException;
    }
                                aggregation.addPercentileAsString(key, parser.text());
                            if (i > 0) {
                return new Percentile(next.getKey(), next.getValue());
 *
                    }
                            } else if (CommonFields.VALUE.getPreferredName().equals(currentFieldName)) {
 * this file be licensed under the Apache-2.0 license or a
            public Percentile next() {
                aggregation.setKeyed(true);
        ParsedAggregation.declareAggregationFields(objectParser);
    void setKeyed(boolean keyed) {
    protected static void declarePercentilesFields(ObjectParser<? extends ParsedPercentiles, Void> objectParser) {
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                                double key = Double.valueOf(parser.currentName().substring(0, i));
        percentilesAsString.put(key, valueAsString);
    @Override
        Double value = getPercentile(percent);
import org.opensearch.core.xcontent.XContentParser;
        if (percentiles.isEmpty()) {
                            if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
/*
                        } else if (token == XContentParser.Token.VALUE_NULL) {
                    if (key != null) {
import java.util.Iterator;
}
                }
        String valueAsString = percentilesAsString.get(percent);
                Double key = percentile.getKey();
import org.opensearch.search.aggregations.ParsedAggregation;
            } else if (token == XContentParser.Token.START_ARRAY) {
