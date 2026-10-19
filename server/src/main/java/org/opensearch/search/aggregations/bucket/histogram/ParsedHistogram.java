            }  
     * @opensearch.internal
 */  
            parser -> ParsedBucket.fromXContent(parser, false),  
            return null;
 * license agreements. See the NOTICE file distributed with
    @Override
 * The OpenSearch Contributors require contributions made to  
        return aggregation;
        ParsedHistogram::new
 * Unless required by applicable law or agreed to in writing,
    }  
            return key;
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            String keyAsString = super.getKeyAsString();  
public class ParsedHistogram extends ParsedMultiBucketAggregation<ParsedHistogram.ParsedBucket> implements Histogram {
        return buckets;
 */  
                return Double.toString(key);
 * Modifications Copyright OpenSearch Contributors. See
     */  
/*  
/**
    }  
    public List<? extends Histogram.Bucket> getBuckets() {  
        public Object getKey() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        declareMultiBucketAggregationFields(
        public String getKeyAsString() {
        private Double key;  
 */  
    );
    static class ParsedBucket extends ParsedMultiBucketAggregation.ParsedBucket implements Histogram.Bucket {
     * Parsed bucket for a parsed histogram  
import java.io.IOException;
    public String getType() {
    @Override  
        @Override
 *
            if (keyAsString != null) {
 * ownership. Elasticsearch licenses this file to you under  
            parser -> ParsedBucket.fromXContent(parser, true)
import java.util.List;  
/*  
 * under the License.  
        return HistogramAggregationBuilder.NAME;
 * compatible open source license.
        true,  
    }
    /**
 * You may obtain a copy of the License at  
        @Override
            PARSER,
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;  
        ParsedHistogram aggregation = PARSER.parse(parser, null);  
            }  
        );
 */
        }  
        static ParsedBucket fromXContent(XContentParser parser, boolean keyed) throws IOException {
 * @opensearch.internal
    }
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        }
 * specific language governing permissions and limitations
                return keyAsString;
 * software distributed under the License is distributed on an
            if (key != null) {
 * SPDX-License-Identifier: Apache-2.0
    }  
            return parseXContent(parser, keyed, ParsedBucket::new, (p, bucket) -> bucket.key = p.doubleValue());
/*
     *
package org.opensearch.search.aggregations.bucket.histogram;
 * Licensed to Elasticsearch under one or more contributor  
    private static final ObjectParser<ParsedHistogram, Void> PARSER = new ObjectParser<>(
import org.opensearch.core.xcontent.XContentParser;
    public static ParsedHistogram fromXContent(XContentParser parser, String name) throws IOException {
        ParsedHistogram.class.getSimpleName(),
    static {  
        aggregation.setName(name);
 *
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
 * A histogram result parsed between nodes  
import org.opensearch.core.xcontent.ObjectParser;
}
 * this work for additional information regarding copyright
 *
