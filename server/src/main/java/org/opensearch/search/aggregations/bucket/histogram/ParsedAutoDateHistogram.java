                return keyAsString;  
 * software distributed under the License is distributed on an
import org.opensearch.core.ParseField;
 */
import java.time.Instant;
        ParsedAutoDateHistogram.class.getSimpleName(),
    }  
        public String getKeyAsString() {  
    private static final ObjectParser<ParsedAutoDateHistogram, Void> PARSER = new ObjectParser<>(  
            if (keyAsString != null) {
/*  
 * A auto date histogram result parsed between nodes
        return interval;  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
    }
            if (key != null) {
    public static ParsedAutoDateHistogram fromXContent(XContentParser parser, String name) throws IOException {
    public void setInterval(String interval) {  
 * this file be licensed under the Apache-2.0 license or a
        @Override
     * A parsed bucket for a parsed auto date histogram agg
    @Override
        static ParsedBucket fromXContent(XContentParser parser, boolean keyed) throws IOException {
 * You may obtain a copy of the License at  
import java.util.List;
    @Override
 */
        builder = super.doXContentBody(builder, params);
            return null;
 * ownership. Elasticsearch licenses this file to you under  
     * @opensearch.internal  
        builder.field("interval", getInterval());
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
        true,
        }
    }  
/**  
        }  
/*  
        protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {  
                return Long.toString(key);  
                return Instant.ofEpochMilli(key).atZone(ZoneOffset.UTC);  
/*
        return aggregation;
import java.io.IOException;
        ParsedAutoDateHistogram aggregation = PARSER.parse(parser, null);  
     *
 * GitHub history for details.
            parser -> ParsedBucket.fromXContent(parser, false),
            }
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    );
        public Object getKey() {
import org.opensearch.core.xcontent.ObjectParser;
    }
 *
        return AutoDateHistogramAggregationBuilder.NAME;  
import org.opensearch.core.xcontent.XContentBuilder;  
        private Long key;
     */
import org.opensearch.core.xcontent.XContentParser;
 * Unless required by applicable law or agreed to in writing,
 *  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            parser -> ParsedBucket.fromXContent(parser, true)  
 *
        @Override  
 * under the License.  
    public List<? extends Histogram.Bucket> getBuckets() {
        }  
public class ParsedAutoDateHistogram extends ParsedMultiBucketAggregation<ParsedAutoDateHistogram.ParsedBucket> implements Histogram {
}
    public String getType() {
        }  
    static {
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search.aggregations.bucket.histogram;
 * KIND, either express or implied.  See the License for the
            if (key != null) {
        ParsedAutoDateHistogram::new  
            String keyAsString = super.getKeyAsString();
            }
    /**  
        PARSER.declareString((parsed, value) -> parsed.interval = value, new ParseField("interval"));
            return null;
            return builder.field(CommonFields.KEY.getPreferredName(), key);
        return builder;  
            PARSER,
    public String getInterval() {
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
 * not use this file except in compliance with the License.
    }
        return buckets;  
 * this work for additional information regarding copyright
        aggregation.setName(name);
 * specific language governing permissions and limitations
 * @opensearch.internal  
        @Override
        declareMultiBucketAggregationFields(  
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
    public static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements Histogram.Bucket {
    @Override
    }
        );
import java.time.ZoneOffset;  
 * Licensed to Elasticsearch under one or more contributor  
        this.interval = interval;
    private String interval;  
            return parseXContent(parser, keyed, ParsedBucket::new, (p, bucket) -> bucket.key = p.longValue());
 */  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
