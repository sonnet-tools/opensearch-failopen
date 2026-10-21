/*
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
                    currentFieldName = parser.currentName();
        public String getKeyAsString() {
     *
                            Aggregation.TYPED_KEYS_DELIMITER,
                        );
        }
            builder.endObject();
    protected final List<B> buckets = new ArrayList<>();
/*
                }
        objectParser.declareField((parser, aggregation, context) -> {
 *
 */
                    aggregation.buckets.add(bucketParser.apply(parser));
                    }
        }
import java.io.IOException;
        final CheckedFunction<XContentParser, ParsedBucket, IOException> keyedBucketParser
        }
        }
import java.util.ArrayList;
    implements
            bucket.setAggregations(new Aggregations(aggregations));
        private long docCount;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
            }
        return builder;
            } else if (token == XContentParser.Token.START_ARRAY) {
 * Licensed to Elasticsearch under one or more contributor
            String currentFieldName = parser.currentName();
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
        public long getDocCount() {
                        bucket.setKeyAsString(parser.text());
            return keyAsString;
            builder.startArray(CommonFields.BUCKETS.getPreferredName());
        private String keyAsString;
            }
        }
                            aggregations::add
            bucket.toXContent(builder, params);
            return builder;
 * You may obtain a copy of the License at
            } else {
    }
        protected static <B extends ParsedBucket> B parseXContent(
            this.aggregations = aggregations;
            final CheckedBiConsumer<XContentParser, B, IOException> keyConsumer
                } else if (token.isValue()) {
            if (token == XContentParser.Token.START_OBJECT) {
                // Subclasses can override the getKeyAsString method to handle specific cases like
    protected boolean keyed = false;
                        keyConsumer.accept(parser, bucket);
 * SPDX-License-Identifier: Apache-2.0
                builder.startObject(getKeyAsString());
 *
        }
                }
import java.util.List;
        }
        if (keyed) {
 * @opensearch.internal
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
import org.opensearch.common.CheckedFunction;
                // out but we still need to have a string version of the key to use as the bucket's name.
        @Override
    @Override
        if (keyed) {
public abstract class ParsedMultiBucketAggregation<B extends ParsedMultiBucketAggregation.Bucket> extends ParsedAggregation
                }
/*
        ) throws IOException {
        }
        }, CommonFields.BUCKETS, ObjectParser.ValueType.OBJECT_ARRAY);
                // keyed bucket with RAW doc value format where the key_as_string field is not printed
     * @opensearch.internal
            bucket.setKeyed(keyed);
        @Override
 * ownership. Elasticsearch licenses this file to you under
 * software distributed under the License is distributed on an
        protected void setKeyAsString(String keyAsString) {
 * GitHub history for details.
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());
            final boolean keyed,
        } else {
        @Override
                builder.startObject();
 * this work for additional information regarding copyright
/**
            this.keyed = keyed;
            if (keyAsString != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                            Aggregation.class,
        }
    protected static void declareMultiBucketAggregationFields(
            if (keyed) {
import org.opensearch.core.xcontent.XContentBuilder;
        }
        private Aggregations aggregations;
                } else if (token == XContentParser.Token.START_OBJECT) {
            XContentParser.Token token = parser.currentToken();
        }
        MultiBucketsAggregation {
     * A parsed bucket
import org.opensearch.core.xcontent.ObjectParser;
}
        for (B bucket : buckets) {
            return aggregations;
        }
 *
            }
    }
 */
    public abstract static class ParsedBucket implements MultiBucketsAggregation.Bucket {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        protected void setDocCount(long docCount) {
    /**
    }
                    if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
                if (token == XContentParser.Token.FIELD_NAME) {
 */
                    } else if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
        protected boolean isKeyed() {
        final CheckedFunction<XContentParser, ParsedBucket, IOException> bucketParser,
            builder.startObject(CommonFields.BUCKETS.getPreferredName());
            }
            final XContentParser parser,
                    if (CommonFields.KEY_AS_STRING.getPreferredName().equals(currentFieldName)) {
        private boolean keyed;
        declareAggregationFields(objectParser);
            builder.endObject();
            final B bucket = bucketSupplier.get();
            this.docCount = docCount;
 * A multi-bucket agg that has been parsed
 */
                while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            return builder.field(CommonFields.KEY.getPreferredName(), getKey());
import java.util.function.Supplier;
 * not use this file except in compliance with the License.
            return bucket;
import org.opensearch.core.xcontent.XContentParserUtils;
                    aggregation.buckets.add(keyedBucketParser.apply(parser));
                        keyConsumer.accept(parser, bucket);
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {
 * KIND, either express or implied.  See the License for the
 *
            aggregations.toXContentInternal(builder, params);
     */
        }
        public Aggregations getAggregations() {
                        XContentParserUtils.parseTypedKeysObject(
            final Supplier<B> bucketSupplier,
                aggregation.keyed = true;
    ) {
            this.keyAsString = keyAsString;
                    } else {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.aggregations;
        @Override
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
            return docCount;
        final ObjectParser<? extends ParsedMultiBucketAggregation, Void> objectParser,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
                aggregation.keyed = false;
                            parser,
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
            keyToXContent(builder);
                    }
        }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentParser;
            builder.endArray();
import org.opensearch.common.CheckedBiConsumer;
            if (keyed) {
        protected void setAggregations(Aggregations aggregations) {
        public void setKeyed(boolean keyed) {
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
        } else {
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            XContentParser.Token token = parser.currentToken();
 * under the License.
            List<Aggregation> aggregations = new ArrayList<>();
            return keyed;
                        bucket.setDocCount(parser.longValue());
