        ParsedExtendedStatsBucket parsedStatsBucket = PARSER.apply(parser, null);
    static {
/**
 *
 * Licensed to Elasticsearch under one or more contributor  
    }
        return ExtendedStatsBucketPipelineAggregationBuilder.NAME;
 */  
 */  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * An extended stats agg result parsed between nodes  
 * this work for additional information regarding copyright
    }  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
    }
        ParsedExtendedStatsBucket::new
 */
        ParsedExtendedStatsBucket.class.getSimpleName(),  
public class ParsedExtendedStatsBucket extends ParsedExtendedStats implements ExtendedStatsBucket {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.ObjectParser;
/*  
 * compatible open source license.
        return parsedStatsBucket;  
        parsedStatsBucket.setName(name);
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        declareExtendedStatsFields(PARSER);  
    @Override  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    );  
/*
        true,
import org.opensearch.search.aggregations.metrics.ParsedExtendedStats;  
}
 *
    public String getType() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final ObjectParser<ParsedExtendedStatsBucket, Void> PARSER = new ObjectParser<>(
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * @opensearch.internal
 */  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 *  
    public static ParsedExtendedStatsBucket fromXContent(XContentParser parser, final String name) {  
 *
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
package org.opensearch.search.aggregations.pipeline;
 * not use this file except in compliance with the License.
