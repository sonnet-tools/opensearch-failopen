        @Override
            return keyed;
package org.opensearch.search.aggregations;
            } else {
import org.opensearch.core.xcontent.ObjectParser;  
        public String getKeyAsString() {
                        bucket.setKeyAsString(parser.text());
                    aggregation.buckets.add(keyedBucketParser.apply(parser));  
                            Aggregation.TYPED_KEYS_DELIMITER,
    }
        protected static <B extends ParsedBucket> B parseXContent(
            }
                    aggregation.buckets.add(bucketParser.apply(parser));
        if (keyed) {  
            return bucket;  
 *  
        private Aggregations aggregations;  
 * this file be licensed under the Apache-2.0 license or a
public abstract class ParsedMultiBucketAggregation<B extends ParsedMultiBucketAggregation.Bucket> extends ParsedAggregation  
        final CheckedFunction<XContentParser, ParsedBucket, IOException> keyedBucketParser
        declareAggregationFields(objectParser);  
                // keyed bucket with RAW doc value format where the key_as_string field is not printed
 * this work for additional information regarding copyright
            return builder.field(CommonFields.KEY.getPreferredName(), getKey());
            return keyAsString;
            }
        @Override  
        }
    @Override
                }  
            return aggregations;
        }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.XContentBuilder;
            List<Aggregation> aggregations = new ArrayList<>();
                if (token == XContentParser.Token.FIELD_NAME) {  
/*  
            if (keyed) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
                            parser,  
        final CheckedFunction<XContentParser, ParsedBucket, IOException> bucketParser,  
        for (B bucket : buckets) {
 * specific language governing permissions and limitations
            final B bucket = bucketSupplier.get();
            }
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
                        );
import org.opensearch.common.CheckedBiConsumer;
        }  
                // Subclasses can override the getKeyAsString method to handle specific cases like
                } else if (token.isValue()) {
            XContentParser.Token token = parser.currentToken();
        ) throws IOException {  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentParserUtils;  
                } else if (token == XContentParser.Token.START_OBJECT) {
                    }
 *  
                while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            String currentFieldName = parser.currentName();
        private String keyAsString;
 */  
                        keyConsumer.accept(parser, bucket);  
            bucket.setKeyed(keyed);
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        }
 */
            if (keyed) {  
        }
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), getKeyAsString());  
 * The OpenSearch Contributors require contributions made to  
        @Override
                            Aggregation.class,
            }
            return builder;  
        if (keyed) {
 * compatible open source license.
                    currentFieldName = parser.currentName();
        private long docCount;
        }  
        public Aggregations getAggregations() {  
                }
    /**
            aggregations.toXContentInternal(builder, params);
                    if (CommonFields.KEY_AS_STRING.getPreferredName().equals(currentFieldName)) {  
        }
                        XContentParserUtils.parseTypedKeysObject(
    ) {
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);  
        protected void setAggregations(Aggregations aggregations) {
 * A multi-bucket agg that has been parsed
                            aggregations::add  
import java.util.function.Supplier;  
/**
import java.io.IOException;  
 * @opensearch.internal
                aggregation.keyed = false;  
        public long getDocCount() {
 *
            this.aggregations = aggregations;
        } else {
     * @opensearch.internal
            final CheckedBiConsumer<XContentParser, B, IOException> keyConsumer
            final Supplier<B> bucketSupplier,
        }
     */  
            XContentParser.Token token = parser.currentToken();  
 * Unless required by applicable law or agreed to in writing,
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {
 * Licensed to Elasticsearch under one or more contributor  
                    } else {
            if (token == XContentParser.Token.START_OBJECT) {  
            builder.endObject();
            builder.startObject(CommonFields.BUCKETS.getPreferredName());
            builder.endArray();
            return docCount;
    protected static void declareMultiBucketAggregationFields(
        protected void setDocCount(long docCount) {
import java.util.ArrayList;
        public void setKeyed(boolean keyed) {
import org.opensearch.common.CheckedFunction;
                    if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
            } else if (token == XContentParser.Token.START_ARRAY) {
                    } else if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
        protected void setKeyAsString(String keyAsString) {
                }  
        } else {
        protected boolean isKeyed() {  
        }
 * under the License.  
        }
    public abstract static class ParsedBucket implements MultiBucketsAggregation.Bucket {
 * You may obtain a copy of the License at  
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);  
        }
 */
 * SPDX-License-Identifier: Apache-2.0
/*
    protected boolean keyed = false;
        }
                    }  
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
 */  
import java.util.List;
/*  
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentParser;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        MultiBucketsAggregation {
            final boolean keyed,  
            if (keyAsString != null) {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
            builder.startArray(CommonFields.BUCKETS.getPreferredName());  
                        keyConsumer.accept(parser, bucket);  
        }, CommonFields.BUCKETS, ObjectParser.ValueType.OBJECT_ARRAY);
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
 * KIND, either express or implied.  See the License for the
            }
            this.keyed = keyed;  
        final ObjectParser<? extends ParsedMultiBucketAggregation, Void> objectParser,
     *
            this.docCount = docCount;  
            bucket.toXContent(builder, params);  
    implements
            keyToXContent(builder);
                builder.startObject();  
            bucket.setAggregations(new Aggregations(aggregations));
            final XContentParser parser,
            builder.endObject();  
 *
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        @Override  
            this.keyAsString = keyAsString;  
                aggregation.keyed = true;
 * the Apache License, Version 2.0 (the "License"); you may
        objectParser.declareField((parser, aggregation, context) -> {
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {  
        }  
        private boolean keyed;  
 * GitHub history for details.
                // out but we still need to have a string version of the key to use as the bucket's name.  
        }  
                        bucket.setDocCount(parser.longValue());
        return builder;
     * A parsed bucket  
                builder.startObject(getKeyAsString());
}  
    protected final List<B> buckets = new ArrayList<>();
