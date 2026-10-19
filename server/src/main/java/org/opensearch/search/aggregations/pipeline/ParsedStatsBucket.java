import org.opensearch.search.aggregations.metrics.ParsedStats;  
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        ParsedStatsBucket parsedStatsBucket = PARSER.apply(parser, null);
        return parsedStatsBucket;  
 * this work for additional information regarding copyright
        ParsedStatsBucket::new
 *
import org.opensearch.core.xcontent.ObjectParser;
/*  
    );  
 * under the License.  
public class ParsedStatsBucket extends ParsedStats implements StatsBucket {
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 *  
 * Unless required by applicable law or agreed to in writing,
 * A stats agg result parsed between nodes  
 * SPDX-License-Identifier: Apache-2.0
 */
        declareStatsFields(PARSER);  
 * The OpenSearch Contributors require contributions made to  
 *
        parsedStatsBucket.setName(name);
    }
    }  
package org.opensearch.search.aggregations.pipeline;
 * GitHub history for details.
 */  
 *
 * You may obtain a copy of the License at  
    private static final ObjectParser<ParsedStatsBucket, Void> PARSER = new ObjectParser<>(
    public String getType() {
/*  
/**
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
    static {
        true,
 * ownership. Elasticsearch licenses this file to you under  
        ParsedStatsBucket.class.getSimpleName(),  
    }
        return StatsBucketPipelineAggregationBuilder.NAME;
 * license agreements. See the NOTICE file distributed with
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParser;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
    public static ParsedStatsBucket fromXContent(XContentParser parser, final String name) {  
}
