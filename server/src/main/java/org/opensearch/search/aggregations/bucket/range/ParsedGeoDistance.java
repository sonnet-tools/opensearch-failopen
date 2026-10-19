    }
package org.opensearch.search.aggregations.bucket.range;
        aggregation.setName(name);  
    );
 * not use this file except in compliance with the License.
            parser -> ParsedBucket.fromXContent(parser, true)  
        declareParsedRangeFields(  
    public String getType() {
 * Unless required by applicable law or agreed to in writing,
 */  
import java.io.IOException;
        ParsedGeoDistance aggregation = PARSER.parse(parser, null);
    static {
public class ParsedGeoDistance extends ParsedRange {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 */
    @Override
    }
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal  
        ParsedGeoDistance.class.getSimpleName(),
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
/**  
    public static class ParsedBucket extends ParsedRange.ParsedBucket {  
            parser -> ParsedBucket.fromXContent(parser, false),
 *  
}  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
            PARSER,
 * Licensed to Elasticsearch under one or more contributor  
     */
 */  
 * Modifications Copyright OpenSearch Contributors. See
     *  
import org.opensearch.core.xcontent.ObjectParser;
/*
        return GeoDistanceAggregationBuilder.NAME;  
 * You may obtain a copy of the License at  
        true,
     * @opensearch.internal
    }
 *
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
     * Parsed bucket for a geo distance
 *
        static ParsedBucket fromXContent(final XContentParser parser, final boolean keyed) throws IOException {
        return aggregation;
 * A geo distance range agg result parsed between nodes
            return parseRangeBucketXContent(parser, ParsedBucket::new, keyed);  
 */
import org.opensearch.core.xcontent.XContentParser;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
    }
    /**
        }
    private static final ObjectParser<ParsedGeoDistance, Void> PARSER = new ObjectParser<>(  
    public static ParsedGeoDistance fromXContent(XContentParser parser, String name) throws IOException {
        ParsedGeoDistance::new  
 * under the License.  
        );
 * KIND, either express or implied.  See the License for the
/*  
/*  
 * compatible open source license.
