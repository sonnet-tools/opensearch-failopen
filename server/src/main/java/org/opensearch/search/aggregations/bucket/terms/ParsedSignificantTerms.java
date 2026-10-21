        for (ParsedBucket bucket : aggregation.buckets) {
        public long getSubsetSize() {
            bucket.toXContent(builder, params);
    static <T extends ParsedSignificantTerms> T parseSignificantTermsXContent(
 *
                        bucket.score = parser.doubleValue();
        }
 * You may obtain a copy of the License at
        builder.field(InternalMappedSignificantTerms.BG_COUNT, supersetSize);
import java.util.Map;
/*
        }
import java.io.IOException;
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        @Override
        }
        final ObjectParser<? extends ParsedSignificantTerms, Void> objectParser,
        return bucketMap.get(term);
                        Aggregation.class,
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
     * @opensearch.internal
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
                        long value = parser.longValue();
            return supersetDf;
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
            return score;
    implements
            final XContentParser parser,
import org.opensearch.search.aggregations.Aggregation;
                        aggregations::add
import org.opensearch.core.xcontent.ObjectParser;
            keyToXContent(builder);
            getAggregations().toXContentInternal(builder, params);
        builder.field(CommonFields.DOC_COUNT.getPreferredName(), subsetSize);
        SignificantTerms {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
                        keyConsumer.accept(parser, bucket);
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
     */
 */
/*
                    );
                    XContentParserUtils.parseTypedKeysObject(
 * under the License.
        objectParser.declareLong((parsedTerms, value) -> parsedTerms.subsetSize = value, CommonFields.DOC_COUNT);
        builder.endArray();
        );
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
                } else if (token.isValue()) {
import org.opensearch.search.aggregations.Aggregations;
            builder.endObject();
        protected long supersetDf;
    protected long getSubsetSize() {
import java.util.List;
    ) {
import java.util.ArrayList;
        return buckets;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            final B bucket,
        protected long supersetSize;
        static <B extends ParsedBucket> B parseSignificantTermsBucketXContent(
     * Parsed bucket for significant values
 */
                    } else if (InternalSignificantTerms.BG_COUNT.equals(currentFieldName)) {
public abstract class ParsedSignificantTerms extends ParsedMultiBucketAggregation<ParsedSignificantTerms.ParsedBucket>
        }
        for (SignificantTerms.Bucket bucket : buckets) {
        @Override
        objectParser.declareLong(
        aggregation.setName(name);
 * KIND, either express or implied.  See the License for the
 * A significant terms result parsed between nodes
        if (bucketMap == null) {
    protected long getSupersetSize() {
                } else if (token == XContentParser.Token.START_OBJECT) {
                    } else if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {
            return builder;
                    }
        protected long subsetSize;
import org.opensearch.core.xcontent.XContentParser;
            bucket.supersetSize = aggregation.supersetSize;
 *
import java.util.function.Function;
 *
 * The OpenSearch Contributors require contributions made to
        final CheckedSupplier<T, IOException> aggregationSupplier,
        return builder;
        }
                    } else if (InternalSignificantTerms.SCORE.equals(currentFieldName)) {
/**
                    currentFieldName = parser.currentName();
    private Map<String, ParsedBucket> bucketMap;
 *
    }
        public long getSupersetDf() {
 * this work for additional information regarding copyright
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
            XContentParser.Token token;
            new ParseField(InternalMappedSignificantTerms.BG_COUNT)
    public SignificantTerms.Bucket getBucketByKey(String term) {
                    } else if (CommonFields.KEY.getPreferredName().equals(currentFieldName)) {
        }
     *
 * ownership. Elasticsearch licenses this file to you under
            bucket.subsetSize = aggregation.subsetSize;
    protected long supersetSize;
        @Override
import org.opensearch.core.ParseField;
            return subsetSize;
            return getSubsetDf();
        return aggregation;
    protected long subsetSize;
                    if (CommonFields.KEY_AS_STRING.getPreferredName().equals(currentFieldName)) {
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
            final CheckedBiConsumer<XContentParser, B, IOException> keyConsumer
                        Aggregation.TYPED_KEYS_DELIMITER,
        }
        protected double score;
 *    http://www.apache.org/licenses/LICENSE-2.0
            return subsetDf;
    }
import org.opensearch.common.CheckedBiConsumer;
            bucketMap = buckets.stream().collect(Collectors.toMap(SignificantTerms.Bucket::getKeyAsString, Function.identity()));
        T aggregation = aggregationSupplier.get();
/*
 * compatible open source license.
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
                        bucket.subsetDf = value;
            builder.field(InternalSignificantTerms.BG_COUNT, getSupersetDf());
    public List<? extends SignificantTerms.Bucket> getBuckets() {
 * Licensed to Elasticsearch under one or more contributor
    /**
                        bucket.supersetDf = parser.longValue();
            builder.startObject();
        final String name
        public long getDocCount() {
import org.opensearch.common.CheckedSupplier;
        protected long subsetDf;
            bucket.setAggregations(new Aggregations(aggregations));
        declareMultiBucketAggregationFields(objectParser, bucketParser::apply, bucketParser::apply);
 * not use this file except in compliance with the License.
        @Override
import org.opensearch.common.CheckedFunction;
        }
    ) throws IOException {
        return buckets.stream().map(bucket -> (SignificantTerms.Bucket) bucket).collect(Collectors.toList()).iterator();
            (parsedTerms, value) -> parsedTerms.supersetSize = value,
    @Override
    }
                if (token == XContentParser.Token.FIELD_NAME) {
            final List<Aggregation> aggregations = new ArrayList<>();
        return supersetSize;
            String currentFieldName = parser.currentName();
package org.opensearch.search.aggregations.bucket.terms;
            return supersetSize;
    }
 * license agreements. See the NOTICE file distributed with
        public double getSignificanceScore() {
import java.util.Iterator;
 */
    @Override
        @Override
 * @opensearch.internal
        protected abstract XContentBuilder keyToXContent(XContentBuilder builder) throws IOException;
    }
import org.opensearch.core.xcontent.XContentParserUtils;
    }
                }
        public long getSupersetSize() {
        @Override
                        bucket.setDocCount(value);
 * software distributed under the License is distributed on an
        final CheckedFunction<XContentParser, ParsedSignificantTerms.ParsedBucket, IOException> bucketParser
import java.util.stream.Collectors;
            }
        return subsetSize;
        }
        ) throws IOException {
}
        public long getSubsetDf() {
 */
    static void declareParsedSignificantTermsFields(
                        bucket.setKeyAsString(parser.text());
    }
        @Override
    @Override
            return bucket;
                        parser,
        }
    public Iterator<SignificantTerms.Bucket> iterator() {
            builder.field(InternalSignificantTerms.SCORE, getSignificanceScore());
    public abstract static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements SignificantTerms.Bucket {
