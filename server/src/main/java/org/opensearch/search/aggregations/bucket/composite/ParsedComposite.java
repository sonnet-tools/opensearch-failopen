 * specific language governing permissions and limitations
/*
    public static ParsedComposite fromXContent(XContentParser parser, String name) throws IOException {
        if (aggregation.afterKey == null && aggregation.getBuckets().size() > 0) {
    }
        declareMultiBucketAggregationFields(PARSER, parser -> ParsedComposite.ParsedBucket.fromXContent(parser), parser -> null);  
 *
    /**  
    @Override  
        @Override
import java.io.IOException;
    public Map<String, Object> afterKey() {
 * Unless required by applicable law or agreed to in writing,
        this.afterKey = afterKey;
 */  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;  
 */  
        return CompositeAggregationBuilder.NAME;
        public Map<String, Object> getKey() {
        public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
             */  
import org.opensearch.core.xcontent.XContentParser;
        true,
        @Override
            return key;  
        }
    public static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements CompositeAggregation.Bucket {
        ParsedComposite::new
    }
              Previous versions (< 6.3) don't send <code>afterKey</code>
        aggregation.setName(name);
        }
    @Override
    }
            new ParseField("after_key"),  
    }
 * @opensearch.internal
     * @opensearch.internal  
              in the response so we set it as the last returned buckets.
            (p, c) -> p.mapOrdered(),
        return aggregation;  
            return key.toString();
    }
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
            return afterKey;
 * Modifications Copyright OpenSearch Contributors. See
        }
        return CompositeAggregation.toXContentFragment(this, builder, params);  
        }
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
/*  
        );
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
            throw new UnsupportedOperationException("not implemented");  
import java.util.List;
 * this work for additional information regarding copyright
        }
/**
import java.util.Map;  
    }
        if (afterKey != null) {  
        return buckets.size() > 0 ? buckets.get(buckets.size() - 1).getKey() : null;  
        ParsedComposite aggregation = PARSER.parse(parser, null);  
    public List<ParsedBucket> getBuckets() {  
public class ParsedComposite extends ParsedMultiBucketAggregation<ParsedComposite.ParsedBucket> implements CompositeAggregation {
            /*  
 * You may obtain a copy of the License at  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 */  
              See {@link CompositeAggregation#bucketToXContent}
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
}
    public String getType() {
        }
    }  
 * GitHub history for details.
 *
/*  
        public String getKeyAsString() {  
            return parseXContent(parser, false, ParsedBucket::new, (p, bucket) -> bucket.setKey(p.mapOrdered()));
    @Override
            aggregation.setAfterKey(aggregation.getBuckets().get(aggregation.getBuckets().size() - 1).key);
import org.opensearch.core.ParseField;
        PARSER.declareField(  
 * A composite result parsed between nodes  
        void setKey(Map<String, Object> key) {  
             */
            ObjectParser.ValueType.OBJECT
 * the Apache License, Version 2.0 (the "License"); you may
            /*  
    private static final ObjectParser<ParsedComposite, Void> PARSER = new ObjectParser<>(
        return buckets;
import org.opensearch.core.xcontent.ObjectParser;
        static ParsedComposite.ParsedBucket fromXContent(XContentParser parser) throws IOException {  
    );  
        }
 */
     *
    private void setAfterKey(Map<String, Object> afterKey) {  
        ParsedComposite.class.getSimpleName(),  
        private Map<String, Object> key;  
    private Map<String, Object> afterKey;  
     * Parsed bucket for the parsed composite agg
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
package org.opensearch.search.aggregations.bucket.composite;
            ParsedComposite::setAfterKey,
     */
            this.key = key;
 *  
 * Licensed to Elasticsearch under one or more contributor  
    static {
