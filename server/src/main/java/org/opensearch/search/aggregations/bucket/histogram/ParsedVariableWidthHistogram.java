        }
                        );
    public static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements Histogram.Bucket {
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * specific language governing permissions and limitations
        ParsedVariableWidthHistogram::new
                return Double.toString(key);
        @Override
        Histogram {
            return bucket;
            builder.field(CommonFields.MAX.getPreferredName(), getMax());
        public double getMin() {
            if (max != null) {
        ParsedVariableWidthHistogram.class.getSimpleName(),
            }
    implements
import org.opensearch.search.aggregations.Aggregations;
                return Double.toString(max);
 */
            PARSER,
                    } else if (CommonFields.MAX.getPreferredName().equals(currentFieldName)) {
            return null;
                            Aggregation.class,
        public void setMin(Double min) {
 */
     *
        }
            if (keyAsString != null) {
        public void setMaxAsString(String maxAsString) {
            }
 * Modifications Copyright OpenSearch Contributors. See
            if (key != null) {
                    } else if (CommonFields.MIN.getPreferredName().equals(currentFieldName)) {
            }
        declareMultiBucketAggregationFields(
                builder.field(CommonFields.MIN_AS_STRING.getPreferredName(), minAsString);
        }
                    } else if (CommonFields.MIN_AS_STRING.getPreferredName().equals(currentFieldName)) {
import java.util.ArrayList;
            }
import java.util.List;
            return null;
        }
 * software distributed under the License is distributed on an
                        bucket.setKeyAsString(parser.text());
            XContentParser.Token token = parser.currentToken();
            final ParsedBucket bucket = new ParsedBucket();
        }
        @Override
        static ParsedBucket fromXContent(XContentParser parser, boolean keyed) throws IOException {
            String currentFieldName = parser.currentName();
 *
            parser -> ParsedBucket.fromXContent(parser, false),
/*
    }
                return Double.toString(min);
                            aggregations::add
        public String getKeyAsString() {
            }
 * @opensearch.internal
            return min;
        }
            }
            String keyAsString = super.getKeyAsString();
}
            builder.endObject();
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                            parser,
            }
            } else {
 * The OpenSearch Contributors require contributions made to
        public void setMinAsString(String minAsString) {
        }
        aggregation.setName(name);
                    }
            this.minAsString = minAsString;
            parser -> ParsedBucket.fromXContent(parser, true)
                        XContentParserUtils.parseTypedKeysObject(
                    currentFieldName = parser.currentName();
                    } else {
                    if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        bucket.setMin(parser.doubleValue());
 * under the License.
        private Double key;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
package org.opensearch.search.aggregations.bucket.histogram;
 * compatible open source license.
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());
    }
            if (maxAsString != null) {
import org.opensearch.core.xcontent.XContentBuilder;
            this.max = max;
        ParsedVariableWidthHistogram aggregation = PARSER.parse(parser, null);
public class ParsedVariableWidthHistogram extends ParsedMultiBucketAggregation<ParsedVariableWidthHistogram.ParsedBucket>
            builder.field(CommonFields.MIN.getPreferredName(), getMin());
            bucket.setAggregations(new Aggregations(aggregations));
                return keyAsString;
            if (minAsString != null) {
 * Licensed to Elasticsearch under one or more contributor
        private String minAsString;
                        bucket.key = parser.doubleValue();
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        public void setMax(Double max) {
/*
        private Double min;
    private static ObjectParser<ParsedVariableWidthHistogram, Void> PARSER = new ObjectParser<>(
    }
            return key;
            List<Aggregation> aggregations = new ArrayList<>();
/**
        public double getMax() {
    /**
            bucket.setKeyed(keyed);
     * Parsed bucket for a parsed variable width histogram
                return minAsString;
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.XContentParserUtils;
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
 *
import java.io.IOException;
                    } else if (CommonFields.MAX_AS_STRING.getPreferredName().equals(currentFieldName)) {
        return aggregation;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                builder.startObject(getKeyAsString());
                    }
 * SPDX-License-Identifier: Apache-2.0
    public static ParsedVariableWidthHistogram fromXContent(XContentParser parser, String name) throws IOException {
 * not use this file except in compliance with the License.
                        bucket.key = parser.doubleValue();
 * ownership. Elasticsearch licenses this file to you under
        }
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
            return null;
 * A variable width histogram result parsed between nodes
        }
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
            }
 * You may obtain a copy of the License at
                } else if (token.isValue()) {
            this.maxAsString = maxAsString;
            }
                } else if (token == XContentParser.Token.START_OBJECT) {
import org.opensearch.search.aggregations.Aggregation;
        return VariableWidthHistogramAggregationBuilder.NAME;
    }
            if (min != null) {
        public Object getKey() {
     * @opensearch.internal
        @Override
        private String maxAsString;
        }
                        bucket.setMaxAsString(parser.text());
            return builder;
            keyToXContent(builder);
        return buckets;
     */
            }
        }
    public List<? extends Histogram.Bucket> getBuckets() {
                }
                        bucket.setMinAsString(parser.text());
 *
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
            if (super.getKeyAsString() != null) {
            if (maxAsString != null) {
                builder.startObject();
    public String getType() {
            return max;
import org.opensearch.core.xcontent.ObjectParser;
            getAggregations().toXContentInternal(builder, params);
                    } else if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
                            Aggregation.TYPED_KEYS_DELIMITER,
            this.min = min;
 *
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
                    if (CommonFields.KEY_AS_STRING.getPreferredName().equals(currentFieldName)) {
            if (isKeyed()) {
        private Double max;
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
                builder.field(CommonFields.MAX_AS_STRING.getPreferredName(), maxAsString);
        public String getMaxAsString() {
                        bucket.setMax(parser.doubleValue());
        public String getMinAsString() {
                if (token == XContentParser.Token.FIELD_NAME) {
                        bucket.setDocCount(parser.longValue());
    @Override
    static {
                return maxAsString;
        true,
 * this work for additional information regarding copyright
            if (keyed) {
 */
        );
    }
    );
    @Override
            }
 */
            if (minAsString != null) {
            }
