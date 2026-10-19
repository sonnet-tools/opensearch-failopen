        public String getKey() {
            }  
/*
            return builder;
                bucket.key = currentFieldName;  
        }
    }  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override  
     * @opensearch.internal  
import java.util.HashMap;
            if (keyed) {
import java.util.Map;
                    currentFieldName = parser.currentName();
        true,
 */  
    static {
            } else {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
        return aggregation;  
            if (isKeyed()) {  
 * The OpenSearch Contributors require contributions made to  
            builder.endObject();
    public List<? extends Filters.Bucket> getBuckets() {
                } else if (token == XContentParser.Token.START_OBJECT) {  
            String currentFieldName = parser.currentName();  
            }
                bucket.key = String.valueOf(i);
import org.opensearch.core.xcontent.XContentBuilder;
    }
        @Override
    public String getType() {  
 * not use this file except in compliance with the License.
        }
 *
 *  
 * Modifications Copyright OpenSearch Contributors. See
            }
                        Aggregation.TYPED_KEYS_DELIMITER,  
        static ParsedBucket fromXContent(XContentParser parser, boolean keyed) throws IOException {
        aggregation.setName(name);
                        parser,
import org.opensearch.search.aggregations.Aggregations;  
/**
    private Map<String, ParsedBucket> bucketMap;  
        private String key;
 */  
import org.opensearch.core.xcontent.XContentParserUtils;
        return bucketMap.get(key);
            int i = 0;
 * Unless required by applicable law or agreed to in writing,
            for (ParsedBucket bucket : buckets) {
                builder.startObject();  
            parser -> ParsedBucket.fromXContent(parser, true)
            }
        public String getKeyAsString() {  
    }
package org.opensearch.search.aggregations.bucket.filter;
        return buckets;  
            return key;
 */
 * compatible open source license.
 * You may obtain a copy of the License at  
        return FiltersAggregationBuilder.NAME;
import java.util.List;  
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
public class ParsedFilters extends ParsedMultiBucketAggregation<ParsedFilters.ParsedBucket> implements Filters {
    private static final ObjectParser<ParsedFilters, Void> PARSER = new ObjectParser<>(
            return key;
        ParsedFilters.class.getSimpleName(),  
            bucket.setAggregations(new Aggregations(aggregations));  
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), getDocCount());
/*  
                if (token == XContentParser.Token.FIELD_NAME) {  
import java.util.ArrayList;
 *
 * under the License.  
    @Override
                } else if (token.isValue()) {
            List<Aggregation> aggregations = new ArrayList<>();
 *
 * SPDX-License-Identifier: Apache-2.0
                }
        declareMultiBucketAggregationFields(
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
                ensureExpectedToken(XContentParser.Token.FIELD_NAME, token, parser);
        }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    }
        if (aggregation.keyed == false) {
                        aggregations::add
    public ParsedBucket getBucketByKey(String key) {
    }
        }  
    public static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements Filters.Bucket {
        if (bucketMap == null) {
 * GitHub history for details.
                    );  
            parser -> ParsedBucket.fromXContent(parser, false),
 * the Apache License, Version 2.0 (the "License"); you may
            final ParsedBucket bucket = new ParsedBucket();  
        @Override
                        Aggregation.class,
    @Override
 * A filters agg result parsed between nodes  
            for (ParsedBucket bucket : aggregation.buckets) {  
     */
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
/*  
        );  
                bucketMap.put(bucket.getKey(), bucket);
                i++;  
            bucketMap = new HashMap<>(buckets.size());  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.search.aggregations.Aggregation;
        // in case this is not a keyed aggregation, we need to add numeric keys to the buckets  
                assert bucket.key == null;
                        bucket.setDocCount(parser.longValue());
import org.opensearch.core.xcontent.ObjectParser;
            }
            getAggregations().toXContentInternal(builder, params);  
 * this work for additional information regarding copyright
        ParsedFilters aggregation = PARSER.parse(parser, null);
        }  
        }
            PARSER,  
 * KIND, either express or implied.  See the License for the
}
import org.opensearch.core.xcontent.XContentParser;  
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
        ParsedFilters::new
                    XContentParserUtils.parseTypedKeysObject(
    @Override  
 * specific language governing permissions and limitations
     * Parsed bucket for the parsed filters agg
            return bucket;
    );  
    }  
    public static ParsedFilters fromXContent(XContentParser parser, String name) throws IOException {  
            XContentParser.Token token = parser.currentToken();
                    if (CommonFields.DOC_COUNT.getPreferredName().equals(currentFieldName)) {  
    /**  
                builder.startObject(key);
            bucket.setKeyed(keyed);
     *
