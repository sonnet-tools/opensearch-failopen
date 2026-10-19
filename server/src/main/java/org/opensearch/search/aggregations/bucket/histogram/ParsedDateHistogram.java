    }  
 * not use this file except in compliance with the License.
            return null;
 */
            parser -> ParsedBucket.fromXContent(parser, true)
 * SPDX-License-Identifier: Apache-2.0
            PARSER,
        static ParsedBucket fromXContent(XContentParser parser, boolean keyed) throws IOException {  
        @Override
     *
        public String getKeyAsString() {
    private static final ObjectParser<ParsedDateHistogram, Void> PARSER = new ObjectParser<>(
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
            return builder.field(CommonFields.KEY.getPreferredName(), key);  
 *
    public static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements Histogram.Bucket {
 * specific language governing permissions and limitations
 * GitHub history for details.
     */  
            if (key != null) {
        ParsedDateHistogram::new
                return keyAsString;
        true,  
import java.time.ZoneOffset;
import org.opensearch.core.xcontent.ObjectParser;
    }  
 * license agreements. See the NOTICE file distributed with
    }
        ParsedDateHistogram.class.getSimpleName(),
}
        public Object getKey() {  
        return aggregation;
     * @opensearch.internal
        }
package org.opensearch.search.aggregations.bucket.histogram;
        return buckets;
                return Long.toString(key);
        }
            if (keyAsString != null) {
                return Instant.ofEpochMilli(key).atZone(ZoneOffset.UTC);
import java.util.List;  
import java.io.IOException;  
            }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
/*
 *
            return parseXContent(parser, keyed, ParsedBucket::new, (p, bucket) -> bucket.key = p.longValue());
    public List<? extends Histogram.Bucket> getBuckets() {  
    @Override  
            }  
import java.time.Instant;
 */  
    public String getType() {
        private Long key;  
    @Override
    public static ParsedDateHistogram fromXContent(XContentParser parser, String name) throws IOException {
 * @opensearch.internal
        return DateHistogramAggregationBuilder.NAME;
 *
     * Parsed Bucket for a parsed date histogram  
        aggregation.setName(name);
        @Override
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentBuilder;
 * ownership. Elasticsearch licenses this file to you under  
    }  
            }  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    }  
        @Override
public class ParsedDateHistogram extends ParsedMultiBucketAggregation<ParsedDateHistogram.ParsedBucket> implements Histogram {
 * Licensed to Elasticsearch under one or more contributor  
        }
        ParsedDateHistogram aggregation = PARSER.parse(parser, null);  
/*  
        declareMultiBucketAggregationFields(
 * Unless required by applicable law or agreed to in writing,
            return null;
    static {  
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
/**
 *  
 * compatible open source license.
    );
 * software distributed under the License is distributed on an
            parser -> ParsedBucket.fromXContent(parser, false),  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    /**
            if (key != null) {
 * A date histogram result parsed between nodes  
            String keyAsString = super.getKeyAsString();  
        }
/*  
import org.opensearch.core.xcontent.XContentParser;  
        );
