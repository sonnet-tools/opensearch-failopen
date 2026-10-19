                    } else if (CommonFields.FROM.getPreferredName().equals(currentFieldName)) {
            parser -> ParsedBucket.fromXContent(parser, false),
            return key;  
import org.opensearch.search.aggregations.Aggregation;
            return from;
            }  
    }  
            final ParsedBucket bucket = new ParsedBucket();
 * KIND, either express or implied.  See the License for the
    public List<? extends Range.Bucket> getBuckets() {
/*
        @Override  
            bucket.setKeyed(keyed);  
        return IpRangeAggregationBuilder.NAME;  
 */  
import org.opensearch.core.xcontent.XContentParserUtils;
        }
                } else if (token.isValue()) {
            } else {  
        ParsedBinaryRange aggregation = PARSER.parse(parser, null);
                bucket.key = currentFieldName;  
                builder.startObject(key);
    }
                    } else if (CommonFields.TO.getPreferredName().equals(currentFieldName)) {  
        private String key;
        return aggregation;  
            PARSER,  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
 *    http://www.apache.org/licenses/LICENSE-2.0
        public Object getTo() {
        public String getToAsString() {
        public Object getFrom() {
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {
 * under the License.  
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        }  
            return to;
            return builder;
import java.io.IOException;  
        }
            }
 * Modifications Copyright OpenSearch Contributors. See
                        bucket.setDocCount(parser.longValue());  
    public String getType() {
        ParsedBinaryRange::new
        aggregation.setName(name);
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
 *
     * Parsed bucket for a binary range
        public String getKeyAsString() {
 *
                builder.field(CommonFields.TO.getPreferredName(), to);
        private String from;
    @Override  
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
    private static final ObjectParser<ParsedBinaryRange, Void> PARSER = new ObjectParser<>(
        @Override
 * not use this file except in compliance with the License.
    public static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements Range.Bucket {
            List<Aggregation> aggregations = new ArrayList<>();
            XContentParser.Token token = parser.currentToken();
 * A binary range agg result parsed between nodes
            }
                } else if (token == XContentParser.Token.START_OBJECT) {  
 * You may obtain a copy of the License at  
                builder.field(CommonFields.KEY.getPreferredName(), key);
import org.opensearch.search.aggregations.Aggregations;  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
            builder.endObject();  
        @Override  
import java.util.List;
                    if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {  
            if (from != null) {
                }
 * this work for additional information regarding copyright
                    XContentParserUtils.parseTypedKeysObject(
package org.opensearch.search.aggregations.bucket.range;
}
import java.util.ArrayList;
    /**  
                        Aggregation.class,
    public static ParsedBinaryRange fromXContent(XContentParser parser, String name) throws IOException {  
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        parser,
    @Override
            if (isKeyed()) {
        @Override
                    currentFieldName = parser.currentName();
            String currentFieldName = parser.currentName();
                        bucket.key = parser.text();
import org.opensearch.core.xcontent.ObjectParser;
    }  
     *
        @Override
 *
import org.opensearch.core.xcontent.XContentParser;  
 * SPDX-License-Identifier: Apache-2.0
        }
 * The OpenSearch Contributors require contributions made to  
            getAggregations().toXContentInternal(builder, params);
/*  
            bucket.setAggregations(new Aggregations(aggregations));  
                if (token == XContentParser.Token.FIELD_NAME) {  
            return key;
                builder.field(CommonFields.FROM.getPreferredName(), from);
            if (to != null) {
/*  
            return from;
        public String getFromAsString() {  
    );  
        declareMultiBucketAggregationFields(
        return buckets;
        true,
            }  
    static {
        @Override
                        bucket.to = parser.text();
     */
    }
 */  
                builder.startObject();
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 * software distributed under the License is distributed on an
                        Aggregation.TYPED_KEYS_DELIMITER,  
 * ownership. Elasticsearch licenses this file to you under  
        private String to;  
        }
 */
        @Override
 * GitHub history for details.
 */
                    }
 * compatible open source license.
            if (keyed) {
        );  
            return to;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * license agreements. See the NOTICE file distributed with
     * @opensearch.internal  
    }
        }  
        static ParsedBucket fromXContent(final XContentParser parser, final boolean keyed) throws IOException {
public class ParsedBinaryRange extends ParsedMultiBucketAggregation<ParsedBinaryRange.ParsedBucket> implements Range {
                        bucket.from = parser.text();
                    );  
        }
        }
                        aggregations::add
 *  
        ParsedBinaryRange.class.getSimpleName(),  
/**  
        public Object getKey() {  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            parser -> ParsedBucket.fromXContent(parser, true)
 * @opensearch.internal  
            return bucket;
import org.opensearch.core.xcontent.XContentBuilder;
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
