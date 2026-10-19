 * GitHub history for details.
                        Aggregation.TYPED_KEYS_DELIMITER,  
                return bucket;
 * specific language governing permissions and limitations
                        Aggregation.class,
 *
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {  
    @Override  
        }  
        }  
import org.opensearch.common.CheckedBiConsumer;
 * not use this file except in compliance with the License.
    }  
            bucket.setAggregations(new Aggregations(aggregations));  
                } else if (token.isValue()) {
 * The OpenSearch Contributors require contributions made to  
            final CheckedBiConsumer<XContentParser, B, IOException> keyConsumer
        final ObjectParser<? extends ParsedRareTerms, Void> objectParser,  
 * @opensearch.internal
        }
            }
            String currentFieldName = parser.currentName();  
            keyToXContent(builder);
        return buckets;  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
            final List<Aggregation> aggregations = new ArrayList<>();  
import org.opensearch.core.xcontent.XContentParser;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
import java.util.function.Supplier;
                }
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;  
 * KIND, either express or implied.  See the License for the
 *  
            XContentParser.Token token;
        declareMultiBucketAggregationFields(objectParser, bucketParser::apply, bucketParser::apply);  
import org.opensearch.core.xcontent.XContentBuilder;
                    }
                    XContentParserUtils.parseTypedKeysObject(
package org.opensearch.search.aggregations.bucket.terms;
            final Supplier<B> bucketSupplier,
 * this work for additional information regarding copyright
            builder.startObject();  
/*  
 * Unless required by applicable law or agreed to in writing,
                        parser,
    @Override
/*  
        static <B extends ParsedBucket> B parseRareTermsBucketXContent(
            if (bucket.getKeyAsString().equals(term)) {  
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
import org.opensearch.search.aggregations.Aggregations;
    ) {
    }
 * under the License.  
            final B bucket = bucketSupplier.get();
            bucket.toXContent(builder, params);
 * software distributed under the License is distributed on an
            final XContentParser parser,  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    );  
 * ownership. Elasticsearch licenses this file to you under  
                        bucket.setKeyAsString(parser.text());  
                        keyConsumer.accept(parser, bucket);
                        aggregations::add
/*
        for (RareTerms.Bucket bucket : getBuckets()) {
import org.opensearch.common.CheckedFunction;
        @Override
        }  
    public List<? extends RareTerms.Bucket> getBuckets() {
                    if (CommonFields.KEY_AS_STRING.getPreferredName().equals(currentFieldName)) {
 *
}
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ObjectParser;  
    static void declareParsedTermsFields(
            builder.endObject();
public abstract class ParsedRareTerms extends ParsedMultiBucketAggregation<ParsedRareTerms.ParsedBucket> implements RareTerms {  
 *  
import org.opensearch.search.aggregations.Aggregation;
import org.opensearch.core.xcontent.XContentParserUtils;  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * compatible open source license.
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
    }
 */
 * A rare term result parsed between nodes
        ) throws IOException {  
     * Parsed Bucket for rare term values
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.ArrayList;  
    public abstract static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements RareTerms.Bucket {
        builder.endArray();
                    currentFieldName = parser.currentName();  
            return bucket;
            }
        final CheckedFunction<XContentParser, ParsedBucket, IOException> bucketParser
import java.util.List;
    }  
    }
     *
     * @opensearch.internal  
        return builder;
            getAggregations().toXContentInternal(builder, params);  
 * license agreements. See the NOTICE file distributed with
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        builder.startArray(CommonFields.BUCKETS.getPreferredName());  
    /**  
                    } else if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
        return null;
                        bucket.setDocCount(parser.longValue());
            return builder;
     */
    public RareTerms.Bucket getBucketByKey(String term) {
/**
                if (token == XContentParser.Token.FIELD_NAME) {
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
                } else if (token == XContentParser.Token.START_OBJECT) {  
 * You may obtain a copy of the License at  
        for (RareTerms.Bucket bucket : getBuckets()) {
 * Modifications Copyright OpenSearch Contributors. See
