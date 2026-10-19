 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                } else if (token.isValue()) {
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {
    public List<? extends Terms.Bucket> getBuckets() {
        objectParser.declareLong(
                        Aggregation.TYPED_KEYS_DELIMITER,
 * this file be licensed under the Apache-2.0 license or a
            getAggregations().toXContentInternal(builder, params);
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                    );
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            keyToXContent(builder);  
 *  
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.startObject();
            return builder;
                if (token == XContentParser.Token.FIELD_NAME) {  
import org.opensearch.common.CheckedFunction;
    ) {  
        boolean showDocCountError = false;
import java.util.List;
/*  
 * not use this file except in compliance with the License.
    @Override  
import static org.opensearch.search.aggregations.bucket.terms.InternalTerms.DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME;
 *
    }
                    } else if (DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME.getPreferredName().equals(currentFieldName)) {
        }
        declareMultiBucketAggregationFields(objectParser, bucketParser::apply, bucketParser::apply);
            (parsedTerms, value) -> parsedTerms.docCountErrorUpperBound = value,  
 * license agreements. See the NOTICE file distributed with
                }  
                    }
        builder.field(SUM_OF_OTHER_DOC_COUNTS.getPreferredName(), getSumOfOtherDocCounts());  
            bucket.toXContent(builder, params);  
        return sumOtherDocCount;  
/**
                    keyConsumer.accept(parser, bucket);
import java.util.function.Supplier;
 * the Apache License, Version 2.0 (the "License"); you may
        return null;  
                builder.field(DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME.getPreferredName(), getDocCountError());  
            DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME
        final ObjectParser<? extends ParsedTerms, Void> objectParser,
        return docCountErrorUpperBound;
    protected long docCountErrorUpperBound;
        builder.endArray();
}  
                        aggregations::add
            final XContentParser parser,
import org.opensearch.core.xcontent.ObjectParser;  
 */
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
 * this work for additional information regarding copyright
 */  
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;  
        protected long docCountError;
                        bucket.setKeyAsString(parser.text());
                    if (CommonFields.KEY_AS_STRING.getPreferredName().equals(currentFieldName)) {  
 * ownership. Elasticsearch licenses this file to you under  
        }
import java.io.IOException;
                        Aggregation.class,  
                        bucket.showDocCountError = true;  
        final CheckedFunction<XContentParser, ParsedBucket, IOException> bucketParser
        );
        objectParser.declareLong((parsedTerms, value) -> parsedTerms.sumOtherDocCount = value, SUM_OF_OTHER_DOC_COUNTS);  
            final Supplier<B> bucketSupplier,  
            return bucket;  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    }
     * Base parsed bucket
    public abstract static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements Terms.Bucket {
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.common.CheckedBiConsumer;
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public Terms.Bucket getBucketByKey(String term) {  
                        parser,
                return bucket;  
/*  
                    && CommonFields.KEY.getPreferredName().equals(currentFieldName)) {  
            if (showDocCountError) {
            final List<Aggregation> aggregations = new ArrayList<>();
    }
            if (bucket.getKeyAsString().equals(term)) {
    public long getSumOfOtherDocCounts() {
package org.opensearch.search.aggregations.bucket.terms;
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
                    currentFieldName = parser.currentName();
            final B bucket = bucketSupplier.get();
import org.opensearch.search.aggregations.Aggregations;
        }
 * The OpenSearch Contributors require contributions made to  
     */
import static org.opensearch.search.aggregations.bucket.terms.InternalTerms.SUM_OF_OTHER_DOC_COUNTS;
            bucket.setAggregations(new Aggregations(aggregations));
    @Override  
import org.opensearch.core.xcontent.XContentParserUtils;  
                        bucket.docCountError = parser.longValue();
/*
    public long getDocCountError() {  
import org.opensearch.core.xcontent.XContentBuilder;
        builder.field(DOC_COUNT_ERROR_UPPER_BOUND_FIELD_NAME.getPreferredName(), getDocCountError());
        ) throws IOException {
 * compatible open source license.
 *
                } else if (token == XContentParser.Token.START_OBJECT) {
        public long getDocCountError() {
 * software distributed under the License is distributed on an
 * A terms result parsed between nodes
        static <B extends ParsedBucket> B parseTermsBucketXContent(
 */  
            builder.endObject();  
            }
    }
    }  
    @Override
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
            }
    /**  
            }
        }
import java.util.ArrayList;  
        return builder;  
    @Override
 * under the License.  
        @Override
            return docCountError;  
            final CheckedBiConsumer<XContentParser, B, IOException> keyConsumer
        for (Terms.Bucket bucket : getBuckets()) {
        @Override  
    protected long sumOtherDocCount;  
 *  
     * @opensearch.internal  
        for (Terms.Bucket bucket : getBuckets()) {
 * GitHub history for details.
    static void declareParsedTermsFields(  
    }
import org.opensearch.search.aggregations.Aggregation;
public abstract class ParsedTerms extends ParsedMultiBucketAggregation<ParsedTerms.ParsedBucket> implements Terms {  
                    XContentParserUtils.parseTypedKeysObject(  
                if ((token.isValue() || token == XContentParser.Token.START_ARRAY)
 */
    }
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
                // field value could be list, e.g. multi_terms aggregation.
        return buckets;
 * You may obtain a copy of the License at  
            XContentParser.Token token;
                        bucket.setDocCount(parser.longValue());  
     *
        }
            String currentFieldName = parser.currentName();
 * Modifications Copyright OpenSearch Contributors. See
