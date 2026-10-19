        true,
 *
        @Override
/*  
    );
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 *
 * SPDX-License-Identifier: Apache-2.0
        }
     *  
 *
            return doubleAsDateTime(from);
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
            parser -> ParsedBucket.fromXContent(parser, false),
 */  
        }
import org.opensearch.core.xcontent.ObjectParser;
import java.time.ZonedDateTime;
import java.io.IOException;
        @Override
 * under the License.  
 * software distributed under the License is distributed on an
    /**
        public Object getTo() {
 */  
    static {
        public Object getFrom() {  
import java.time.Instant;
        ParsedDateRange::new  
            }  
        static ParsedBucket fromXContent(final XContentParser parser, final boolean keyed) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        return aggregation;
 * compatible open source license.
        aggregation.setName(name);  
        ParsedDateRange aggregation = PARSER.parse(parser, null);
            PARSER,
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                return null;
/**  
     * Parsed bucket for a date range
package org.opensearch.search.aggregations.bucket.range;
    public static ParsedDateRange fromXContent(XContentParser parser, String name) throws IOException {
            return doubleAsDateTime(to);  
            return parseRangeBucketXContent(parser, ParsedBucket::new, keyed);
    public String getType() {
 *  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
    @Override
public class ParsedDateRange extends ParsedRange {
 */
 * license agreements. See the NOTICE file distributed with
            return Instant.ofEpochMilli(d.longValue()).atZone(ZoneOffset.UTC);
    }
 * A date range agg result parsed between nodes
        ParsedDateRange.class.getSimpleName(),
/*
import java.time.ZoneOffset;  
        return DateRangeAggregationBuilder.NAME;  
 * The OpenSearch Contributors require contributions made to  
        }  
 * ownership. Elasticsearch licenses this file to you under  
    public static class ParsedBucket extends ParsedRange.ParsedBucket {  
        declareParsedRangeFields(  
        );
 * specific language governing permissions and limitations
     */
}
import org.opensearch.core.xcontent.XContentParser;
            parser -> ParsedBucket.fromXContent(parser, true)  
 */
    }
        private static ZonedDateTime doubleAsDateTime(Double d) {  
 * You may obtain a copy of the License at  
            if (d == null || Double.isInfinite(d)) {
    }
    private static final ObjectParser<ParsedDateRange, Void> PARSER = new ObjectParser<>(  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal  
        }
     * @opensearch.internal
