import org.opensearch.search.aggregations.Aggregation;
            this.maxAsString = maxAsString;  
            getAggregations().toXContentInternal(builder, params);
        return VariableWidthHistogramAggregationBuilder.NAME;
                    } else if (CommonFields.MIN.getPreferredName().equals(currentFieldName)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return key;  
            return bucket;
    public static ParsedVariableWidthHistogram fromXContent(XContentParser parser, String name) throws IOException {
            if (isKeyed()) {  
        ParsedVariableWidthHistogram aggregation = PARSER.parse(parser, null);  
                builder.field(CommonFields.MAX_AS_STRING.getPreferredName(), maxAsString);
}  
        }
        aggregation.setName(name);
            }
                    }  
            return null;
            if (keyed) {
        }
 * Licensed to Elasticsearch under one or more contributor  
            if (super.getKeyAsString() != null) {
                        bucket.setMax(parser.doubleValue());
        ParsedVariableWidthHistogram::new
        public Object getKey() {
                        bucket.setDocCount(parser.longValue());  
                        bucket.setMinAsString(parser.text());
            bucket.setKeyed(keyed);
    }  
/*  
            }  
            List<Aggregation> aggregations = new ArrayList<>();  
            parser -> ParsedBucket.fromXContent(parser, true)
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
     *
/*  
                            aggregations::add
     * @opensearch.internal
package org.opensearch.search.aggregations.bucket.histogram;
                } else if (token.isValue()) {
            if (maxAsString != null) {
            String keyAsString = super.getKeyAsString();
        private Double min;
            bucket.setAggregations(new Aggregations(aggregations));  
 * @opensearch.internal  
            this.max = max;
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContentParserUtils;
 */
            if (max != null) {
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {
                    if (CommonFields.KEY_AS_STRING.getPreferredName().equals(currentFieldName)) {
            String currentFieldName = parser.currentName();  
            final ParsedBucket bucket = new ParsedBucket();  
            if (min != null) {
/**  
                        XContentParserUtils.parseTypedKeysObject(  
 *
 * under the License.  
/*
            }
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }  
 * You may obtain a copy of the License at  
 *  
            return null;  
        public String getMaxAsString() {
                return Double.toString(max);  
                    } else if (CommonFields.MAX_AS_STRING.getPreferredName().equals(currentFieldName)) {
                        bucket.key = parser.doubleValue();
                builder.startObject();  
 * GitHub history for details.
        public void setMax(Double max) {
            if (key != null) {  
        public double getMin() {
 * A variable width histogram result parsed between nodes
            if (minAsString != null) {
        true,  
import org.opensearch.search.aggregations.Aggregations;  
        public String getMinAsString() {  
        private String maxAsString;
import org.opensearch.core.xcontent.XContentParser;  
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());  
                            Aggregation.TYPED_KEYS_DELIMITER,
        public void setMin(Double min) {  
public class ParsedVariableWidthHistogram extends ParsedMultiBucketAggregation<ParsedVariableWidthHistogram.ParsedBucket>
        }  
            return min;  
import java.util.List;
                    } else if (CommonFields.MIN_AS_STRING.getPreferredName().equals(currentFieldName)) {  
        }
            }
            keyToXContent(builder);
            }
    @Override  
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
 */  
        }
                return maxAsString;  
                    } else if (CommonFields.MAX.getPreferredName().equals(currentFieldName)) {  
     */  
    private static ObjectParser<ParsedVariableWidthHistogram, Void> PARSER = new ObjectParser<>(
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    );
                        bucket.setMin(parser.doubleValue());  
        }
        static ParsedBucket fromXContent(XContentParser parser, boolean keyed) throws IOException {
            } else {
        @Override
 * ownership. Elasticsearch licenses this file to you under  
            builder.field(CommonFields.MAX.getPreferredName(), getMax());
 * The OpenSearch Contributors require contributions made to  
            }  
    public String getType() {
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
            XContentParser.Token token = parser.currentToken();
                            parser,
            builder.endObject();
                        bucket.setMaxAsString(parser.text());
 *
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());  
        @Override  
 * software distributed under the License is distributed on an
import java.io.IOException;  
        private Double key;
                } else if (token == XContentParser.Token.START_OBJECT) {
            }  
                            Aggregation.class,  
            }
    public List<? extends Histogram.Bucket> getBuckets() {  
            return builder;  
 * Modifications Copyright OpenSearch Contributors. See
    }
 */
            if (keyAsString != null) {  
        return buckets;
                builder.field(CommonFields.MIN_AS_STRING.getPreferredName(), minAsString);
        ParsedVariableWidthHistogram.class.getSimpleName(),
        }
            PARSER,
        }
     * Parsed bucket for a parsed variable width histogram  
 * SPDX-License-Identifier: Apache-2.0
                return Double.toString(min);
    }
                    if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {  
                    } else {
                return Double.toString(key);
        public String getKeyAsString() {
        }  
                    } else if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
        }  
 * not use this file except in compliance with the License.
        @Override
        }
            }
            if (maxAsString != null) {
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
            builder.field(CommonFields.MIN.getPreferredName(), getMin());  
                return keyAsString;
                    currentFieldName = parser.currentName();  
            return null;
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
            }
    @Override
                    }
                        );
    /**
        public double getMax() {  
        }
        public void setMaxAsString(String maxAsString) {
 */  
        private String minAsString;
        private Double max;
                return minAsString;
        public void setMinAsString(String minAsString) {
import org.opensearch.core.xcontent.ObjectParser;
        declareMultiBucketAggregationFields(
 * this file be licensed under the Apache-2.0 license or a
        );
import java.util.ArrayList;
                if (token == XContentParser.Token.FIELD_NAME) {
                        bucket.setKeyAsString(parser.text());  
            return max;
    }  
        Histogram {
                builder.startObject(getKeyAsString());
            if (minAsString != null) {  
import org.opensearch.core.xcontent.XContentBuilder;
                        bucket.key = parser.doubleValue();
    implements  
            parser -> ParsedBucket.fromXContent(parser, false),  
 * specific language governing permissions and limitations
        return aggregation;
    public static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements Histogram.Bucket {
 *
            this.min = min;
 * license agreements. See the NOTICE file distributed with
            this.minAsString = minAsString;
    static {  
            }
                }
