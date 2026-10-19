public class ParsedRange extends ParsedMultiBucketAggregation<ParsedRange.ParsedBucket> implements Range {
            builder.endObject();
 * Modifications Copyright OpenSearch Contributors. See
                        Aggregation.class,
            if (Double.isInfinite(from) == false) {
                    builder.field(CommonFields.TO_AS_STRING.getPreferredName(), toAsString);
            if (keyed) {
 *
                    } else if (CommonFields.FROM.getPreferredName().equals(currentFieldName)) {
        final ObjectParser<? extends ParsedRange, Void> objectParser,
 * this work for additional information regarding copyright
                    }
            }
    }
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
/**
    }
 * compatible open source license.
    public List<? extends Range.Bucket> getBuckets() {
            return from;
            }
                    );
 * @opensearch.internal
        public Object getTo() {
                        bucket.toAsString = parser.text();
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
                        aggregations::add
        }
                if (toAsString != null) {
            bucket.setAggregations(new Aggregations(aggregations));
        protected String key;
                    currentFieldName = parser.currentName();
 */
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                if (fromAsString != null) {
        final CheckedFunction<XContentParser, ParsedBucket, IOException> keyedBucketParser
        public String getKey() {
                    XContentParserUtils.parseTypedKeysObject(
import org.opensearch.search.aggregations.Aggregations;
        @Override
                builder.field(CommonFields.KEY.getPreferredName(), key);
        public String getKeyAsString() {
import java.io.IOException;
                    builder.field(CommonFields.FROM_AS_STRING.getPreferredName(), fromAsString);
        public String getFromAsString() {
 * specific language governing permissions and limitations
        );
 * The OpenSearch Contributors require contributions made to
 * not use this file except in compliance with the License.
            String currentFieldName = parser.currentName();
        @Override
            }
            return to;
                    } else if (CommonFields.TO.getPreferredName().equals(currentFieldName)) {
        return aggregation;
            final boolean keyed
     * @opensearch.internal
            final XContentParser parser,
        }
                builder.startObject(key);
            }
                        bucket.setDocCount(parser.longValue());
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.CheckedFunction;
 * SPDX-License-Identifier: Apache-2.0
            }
        protected static <B extends ParsedBucket> B parseRangeBucketXContent(
                builder.startObject();
 * this file be licensed under the Apache-2.0 license or a
        }
 */
        protected String fromAsString;
        aggregation.setName(name);
                    if (CommonFields.KEY_AS_STRING.getPreferredName().equals(currentFieldName)) {
 * Unless required by applicable law or agreed to in writing,
 *
    }
        ) throws IOException {
            List<Aggregation> aggregations = new ArrayList<>();
import org.opensearch.core.xcontent.XContentBuilder;
        }
            } else {
     */
import org.opensearch.core.xcontent.XContentParserUtils;
import org.opensearch.search.aggregations.Aggregation;
 * KIND, either express or implied.  See the License for the
 * A range agg result parsed between nodes
        static ParsedBucket fromXContent(final XContentParser parser, final boolean keyed) throws IOException {
                } else if (token.isValue()) {
            PARSER,
    );
                        Aggregation.TYPED_KEYS_DELIMITER,
        ParsedRange.class.getSimpleName(),
        protected double to = Double.POSITIVE_INFINITY;
            if (isKeyed()) {
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
package org.opensearch.search.aggregations.bucket.range;
            return doubleAsString(to);
        declareParsedRangeFields(
            if (fromAsString != null) {
            parser -> ParsedBucket.fromXContent(parser, false),
                } else if (token == XContentParser.Token.START_OBJECT) {
        }
        @Override
        ParsedRange::new
        protected double from = Double.NEGATIVE_INFINITY;
            }
 * software distributed under the License is distributed on an
                        bucket.key = parser.text();
            getAggregations().toXContentInternal(builder, params);
                        bucket.from = parser.doubleValue();
            }
                if (token == XContentParser.Token.FIELD_NAME) {
            return doubleAsString(from);
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        }
 * ownership. Elasticsearch licenses this file to you under
 *
    public String getType() {
    static {
    private static final ObjectParser<ParsedRange, Void> PARSER = new ObjectParser<>(
/*
        @Override
import org.opensearch.core.xcontent.XContentParser;
/*
                    } else if (CommonFields.TO_AS_STRING.getPreferredName().equals(currentFieldName)) {
            bucket.setKeyed(keyed);
    public static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements Range.Bucket {
        ParsedRange aggregation = PARSER.parse(parser, null);
            return key;
        @Override
     *
                return keyAsString;
     * Parsed bucket for a range
 *    http://www.apache.org/licenses/LICENSE-2.0
    ) {
            String keyAsString = super.getKeyAsString();
            return builder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
        @Override
        protected String toAsString;
        return buckets;
                        parser,
                    } else if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
        return RangeAggregationBuilder.NAME;
                builder.field(CommonFields.TO.getPreferredName(), to);
import java.util.ArrayList;
                return toAsString;
                }
            return bucket;
            if (Double.isInfinite(to) == false) {
            XContentParser.Token token = parser.currentToken();
        declareMultiBucketAggregationFields(objectParser, bucketParser::apply, keyedBucketParser::apply);
            parser -> ParsedBucket.fromXContent(parser, true)
                        bucket.setKeyAsString(parser.text());
            final B bucket = bucketSupplier.get();
 */
        }
        public Object getFrom() {
                bucket.key = currentFieldName;
            }
        }
            return parseRangeBucketXContent(parser, ParsedBucket::new, keyed);
            return getKeyAsString();
 * under the License.
            return Double.isInfinite(d) ? null : Double.toString(d);
 */
    @Override
    /**
        public String getToAsString() {
import org.opensearch.core.xcontent.ObjectParser;
        true,
            if (keyAsString != null) {
    }
 *
                        bucket.fromAsString = parser.text();
    protected static void declareParsedRangeFields(
 * GitHub history for details.
    public static ParsedRange fromXContent(XContentParser parser, String name) throws IOException {
 * license agreements. See the NOTICE file distributed with
/*
import java.util.function.Supplier;
                builder.field(CommonFields.FROM.getPreferredName(), from);
        }
 * You may obtain a copy of the License at
        final CheckedFunction<XContentParser, ParsedBucket, IOException> bucketParser,
    @Override
                }
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
        private static String doubleAsString(double d) {
                return fromAsString;
            final Supplier<B> bucketSupplier,
        }
            if (toAsString != null) {
import java.util.List;
 * the Apache License, Version 2.0 (the "License"); you may
                    } else if (CommonFields.FROM_AS_STRING.getPreferredName().equals(currentFieldName)) {
    }
    }
        @Override
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {
}
                        bucket.to = parser.doubleValue();
