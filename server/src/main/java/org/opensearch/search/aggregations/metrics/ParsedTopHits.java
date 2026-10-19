 * license agreements. See the NOTICE file distributed with
 */  
 */
 *  
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    @Override  
    }  
 * compatible open source license.
            new ParseField(SearchHits.Fields.HITS)
 * GitHub history for details.
    public static ParsedTopHits fromXContent(XContentParser parser, String name) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
import org.opensearch.core.xcontent.ObjectParser;
public class ParsedTopHits extends ParsedAggregation implements TopHits {  
    public String getType() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return searchHits.toXContent(builder, params);
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    public SearchHits getHits() {
    @Override
    @Override
        ParsedTopHits::new
        aggregation.setName(name);
        true,  
    private static final ObjectParser<ParsedTopHits, Void> PARSER = new ObjectParser<>(
        return aggregation;  
/*  
import org.opensearch.core.ParseField;
    );
import org.opensearch.core.xcontent.XContentParser;
        return TopHitsAggregationBuilder.NAME;  
import org.opensearch.core.xcontent.XContentBuilder;  
}
 *
        ParsedTopHits aggregation = PARSER.parse(parser, null);
    static {  
 *
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    }
        return searchHits;
    }
package org.opensearch.search.aggregations.metrics;
 * A top_hits agg result parsed between nodes
 * specific language governing permissions and limitations
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
            (topHit, searchHits) -> topHit.searchHits = searchHits,  
/*
        );  
        PARSER.declareObject(
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
/**
 *  
 * ownership. Elasticsearch licenses this file to you under  
/*  
import org.opensearch.search.aggregations.ParsedAggregation;  
            (parser, context) -> SearchHits.fromXContent(parser),
import org.opensearch.search.SearchHits;
 * The OpenSearch Contributors require contributions made to  
 */
 * this file be licensed under the Apache-2.0 license or a
        declareAggregationFields(PARSER);
 * under the License.  
        ParsedTopHits.class.getSimpleName(),
 * @opensearch.internal
    private SearchHits searchHits;
    }
