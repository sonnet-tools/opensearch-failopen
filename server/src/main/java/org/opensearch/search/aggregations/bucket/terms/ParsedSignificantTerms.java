            bucket.subsetSize = aggregation.subsetSize;
 * GitHub history for details.
    @Override
            builder.startObject();
                        bucket.subsetDf = value;  
        @Override
        final String name
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
                    }  
        }  
        return buckets.stream().map(bucket -> (SignificantTerms.Bucket) bucket).collect(Collectors.toList()).iterator();  
        protected abstract XContentBuilder keyToXContent(XContentBuilder builder) throws IOException;  
 * @opensearch.internal  
    }
                    } else if (InternalSignificantTerms.SCORE.equals(currentFieldName)) {
        public long getSupersetDf() {
                    } else if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
            return getSubsetDf();
import org.opensearch.core.ParseField;
            bucketMap = buckets.stream().collect(Collectors.toMap(SignificantTerms.Bucket::getKeyAsString, Function.identity()));
        return buckets;
            builder.endObject();
    static <T extends ParsedSignificantTerms> T parseSignificantTermsXContent(  
        public long getDocCount() {  
        @Override
            getAggregations().toXContentInternal(builder, params);  
 *  
}
                    currentFieldName = parser.currentName();
        public long getSupersetSize() {
        @Override  
                        long value = parser.longValue();
            bucket.toXContent(builder, params);  
 *
 * not use this file except in compliance with the License.
    protected long getSupersetSize() {
    }
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
import java.util.function.Function;  
        builder.field(InternalMappedSignificantTerms.BG_COUNT, supersetSize);  
        return aggregation;
                    XContentParserUtils.parseTypedKeysObject(
    public List<? extends SignificantTerms.Bucket> getBuckets() {
        objectParser.declareLong((parsedTerms, value) -> parsedTerms.subsetSize = value, CommonFields.DOC_COUNT);  
            return supersetSize;  
    @Override  
            return bucket;
        @Override
                        bucket.setKeyAsString(parser.text());
 * the Apache License, Version 2.0 (the "License"); you may
            final CheckedBiConsumer<XContentParser, B, IOException> keyConsumer
import org.opensearch.common.CheckedSupplier;  
 * software distributed under the License is distributed on an
                        parser,  
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.core.xcontent.XContentBuilder;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        ) throws IOException {  
 * this work for additional information regarding copyright
        for (ParsedBucket bucket : aggregation.buckets) {  
 * specific language governing permissions and limitations
        );
 * KIND, either express or implied.  See the License for the
        T aggregation = aggregationSupplier.get();
            bucket.setAggregations(new Aggregations(aggregations));
        @Override  
                        Aggregation.class,
                    } else if (InternalSignificantTerms.BG_COUNT.equals(currentFieldName)) {
            }  
            return builder;
    ) throws IOException {  
/*
        protected long subsetSize;  
    }  
                        bucket.supersetDf = parser.longValue();
        public long getSubsetSize() {
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
        objectParser.declareLong(
        }  
    @Override  
                } else if (token == XContentParser.Token.START_OBJECT) {
    }
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
 *
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;
import java.util.List;
 *
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            keyToXContent(builder);
        return subsetSize;
        static <B extends ParsedBucket> B parseSignificantTermsBucketXContent(
                    if (CommonFields.KEY_AS_STRING.getPreferredName().equals(currentFieldName)) {  
            final XContentParser parser,  
import org.opensearch.common.CheckedFunction;
import org.opensearch.common.CheckedBiConsumer;
        SignificantTerms {
        return supersetSize;  
 */  
        }
 * Licensed to Elasticsearch under one or more contributor  
    static void declareParsedSignificantTermsFields(
 * license agreements. See the NOTICE file distributed with
/*  
        @Override
import org.opensearch.search.aggregations.Aggregations;
        @Override
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
            new ParseField(InternalMappedSignificantTerms.BG_COUNT)  
     */
 */  
import java.util.stream.Collectors;
        final CheckedFunction<XContentParser, ParsedSignificantTerms.ParsedBucket, IOException> bucketParser  
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {
                } else if (token.isValue()) {
        final CheckedSupplier<T, IOException> aggregationSupplier,
        }  
        return bucketMap.get(term);
        aggregation.setName(name);
    protected long getSubsetSize() {
 */
    public abstract static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements SignificantTerms.Bucket {  
    }
                        bucket.score = parser.doubleValue();  
        }
        }
        @Override
        final ObjectParser<? extends ParsedSignificantTerms, Void> objectParser,
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            builder.field(InternalSignificantTerms.SCORE, getSignificanceScore());
        }
        protected long supersetSize;
                }
            builder.field(InternalSignificantTerms.BG_COUNT, getSupersetDf());
        protected long subsetDf;
    protected long subsetSize;
            String currentFieldName = parser.currentName();
        }  
                if (token == XContentParser.Token.FIELD_NAME) {  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
        }  
        public long getSubsetDf() {
            return score;
    protected long supersetSize;
 * Modifications Copyright OpenSearch Contributors. See
/**  
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), subsetSize);
import org.opensearch.core.xcontent.XContentParserUtils;
    public Iterator<SignificantTerms.Bucket> iterator() {
        builder.endArray();
        protected double score;  
            final List<Aggregation> aggregations = new ArrayList<>();
 * A significant terms result parsed between nodes
            bucket.supersetSize = aggregation.supersetSize;
            (parsedTerms, value) -> parsedTerms.supersetSize = value,
public abstract class ParsedSignificantTerms extends ParsedMultiBucketAggregation<ParsedSignificantTerms.ParsedBucket>
     * @opensearch.internal
            final B bucket,
        protected long supersetDf;
    implements  
    ) {
import java.util.Iterator;  
                    );
                        keyConsumer.accept(parser, bucket);  
     * Parsed bucket for significant values
            return subsetSize;
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());  
    }
        if (bucketMap == null) {
        }
                        Aggregation.TYPED_KEYS_DELIMITER,
    public SignificantTerms.Bucket getBucketByKey(String term) {  
        public double getSignificanceScore() {  
        declareMultiBucketAggregationFields(objectParser, bucketParser::apply, bucketParser::apply);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentParser;
                        aggregations::add  
import java.io.IOException;
    /**
    private Map<String, ParsedBucket> bucketMap;  
            return subsetDf;  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        return builder;  
            return supersetDf;
 */
        for (SignificantTerms.Bucket bucket : buckets) {
import org.opensearch.search.aggregations.Aggregation;  
    }  
/*  
    }
package org.opensearch.search.aggregations.bucket.terms;
                        bucket.setDocCount(value);
            XContentParser.Token token;  
 * compatible open source license.
     *  
