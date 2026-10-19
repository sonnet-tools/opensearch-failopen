            }
                    currentFieldName = parser.currentName();  
 *
                        Aggregation.class,  
            }
                        bucket.fromAsString = parser.text();
            String currentFieldName = parser.currentName();
        return aggregation;
    /**
/*
        return RangeAggregationBuilder.NAME;
        }
                builder.field(CommonFields.FROM.getPreferredName(), from);  
        static ParsedBucket fromXContent(final XContentParser parser, final boolean keyed) throws IOException {  
                        bucket.from = parser.doubleValue();  
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal
            final boolean keyed  
            final B bucket = bucketSupplier.get();
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
        }
            bucket.setKeyed(keyed);  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        declareMultiBucketAggregationFields(objectParser, bucketParser::apply, keyedBucketParser::apply);  
            bucket.setAggregations(new Aggregations(aggregations));
 */  
        }
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
        ParsedRange::new  
import org.opensearch.search.aggregations.Aggregations;
     * Parsed bucket for a range
 * Unless required by applicable law or agreed to in writing,
            return doubleAsString(to);  
                }  
 */
 *
    }
                if (fromAsString != null) {
            if (toAsString != null) {  
        }  
    public String getType() {
        final CheckedFunction<XContentParser, ParsedBucket, IOException> bucketParser,  
     * @opensearch.internal
            return Double.isInfinite(d) ? null : Double.toString(d);  
            parser -> ParsedBucket.fromXContent(parser, true)  
        return buckets;
            final Supplier<B> bucketSupplier,
            return parseRangeBucketXContent(parser, ParsedBucket::new, keyed);
                    } else if (CommonFields.TO.getPreferredName().equals(currentFieldName)) {  
 *
    ) {
        final ObjectParser<? extends ParsedRange, Void> objectParser,
        true,
    }  
            XContentParser.Token token = parser.currentToken();
            if (Double.isInfinite(to) == false) {
 *  
            return getKeyAsString();
 * GitHub history for details.
    }
 * this work for additional information regarding copyright
        protected double from = Double.NEGATIVE_INFINITY;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.common.CheckedFunction;
            if (Double.isInfinite(from) == false) {
import java.util.ArrayList;
        ParsedRange.class.getSimpleName(),
            return builder;
                return keyAsString;
                        bucket.setKeyAsString(parser.text());  
 * specific language governing permissions and limitations
        );
    @Override  
 * A range agg result parsed between nodes  
import org.opensearch.core.xcontent.XContentParser;
            return bucket;  
                if (toAsString != null) {
                        bucket.key = parser.text();
            List<Aggregation> aggregations = new ArrayList<>();  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    } else if (CommonFields.FROM_AS_STRING.getPreferredName().equals(currentFieldName)) {
            }
import java.util.List;  
        @Override
        }
            final XContentParser parser,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public Object getFrom() {
    public static ParsedRange fromXContent(XContentParser parser, String name) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;  
                    } else if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
        ParsedRange aggregation = PARSER.parse(parser, null);
        @Override
     *  
                        bucket.to = parser.doubleValue();
                builder.startObject(key);  
    static {
 * not use this file except in compliance with the License.
            PARSER,
            parser -> ParsedBucket.fromXContent(parser, false),
        public String getFromAsString() {
            return from;  
        }
        }
                return fromAsString;  
                }  
                builder.field(CommonFields.KEY.getPreferredName(), key);  
                    );
                return toAsString;
                    XContentParserUtils.parseTypedKeysObject(  
        ) throws IOException {
                        bucket.setDocCount(parser.longValue());
 */  
            builder.endObject();
 * compatible open source license.
        @Override  
        final CheckedFunction<XContentParser, ParsedBucket, IOException> keyedBucketParser
public class ParsedRange extends ParsedMultiBucketAggregation<ParsedRange.ParsedBucket> implements Range {
        protected static <B extends ParsedBucket> B parseRangeBucketXContent(  
    }  
                        aggregations::add
        }
    }
        @Override  
            }
                } else if (token.isValue()) {
                        parser,
        private static String doubleAsString(double d) {
 * SPDX-License-Identifier: Apache-2.0
        @Override
    @Override
            if (keyAsString != null) {
 * Modifications Copyright OpenSearch Contributors. See
/*  
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {  
import org.opensearch.search.aggregations.Aggregation;  
    }
        protected String key;
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
            String keyAsString = super.getKeyAsString();  
            getAggregations().toXContentInternal(builder, params);  
package org.opensearch.search.aggregations.bucket.range;
        declareParsedRangeFields(  
            if (fromAsString != null) {
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
            return to;
}
            }
import java.io.IOException;
                bucket.key = currentFieldName;
            return doubleAsString(from);
    );
 * under the License.  
    protected static void declareParsedRangeFields(
                    builder.field(CommonFields.FROM_AS_STRING.getPreferredName(), fromAsString);
        public String getToAsString() {
        }
        @Override
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);  
    public List<? extends Range.Bucket> getBuckets() {  
                }  
 */  
            if (isKeyed()) {
        protected String fromAsString;
        protected String toAsString;  
            if (keyed) {  
                builder.field(CommonFields.TO.getPreferredName(), to);  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
                        bucket.toAsString = parser.text();  
                    builder.field(CommonFields.TO_AS_STRING.getPreferredName(), toAsString);
        aggregation.setName(name);  
                } else if (token == XContentParser.Token.START_OBJECT) {
        public String getKey() {  
                builder.startObject();
        public String getKeyAsString() {
            }
 * You may obtain a copy of the License at  
                    } else if (CommonFields.FROM.getPreferredName().equals(currentFieldName)) {
import org.opensearch.core.xcontent.XContentParserUtils;
                    } else if (CommonFields.TO_AS_STRING.getPreferredName().equals(currentFieldName)) {
 * ownership. Elasticsearch licenses this file to you under  
import java.util.function.Supplier;
                if (token == XContentParser.Token.FIELD_NAME) {
/*  
/**
     */
        public Object getTo() {  
                        Aggregation.TYPED_KEYS_DELIMITER,
            }  
                    if (CommonFields.KEY_AS_STRING.getPreferredName().equals(currentFieldName)) {
 * this file be licensed under the Apache-2.0 license or a
    private static final ObjectParser<ParsedRange, Void> PARSER = new ObjectParser<>(  
        @Override
        protected double to = Double.POSITIVE_INFINITY;
            } else {
 * Licensed to Elasticsearch under one or more contributor  
            return key;
                    }
            }
    public static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements Range.Bucket {  
import org.opensearch.core.xcontent.ObjectParser;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
        }  
