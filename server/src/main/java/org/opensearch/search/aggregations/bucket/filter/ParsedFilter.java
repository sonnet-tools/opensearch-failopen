    public static ParsedFilter fromXContent(XContentParser parser, final String name) throws IOException {
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
public class ParsedFilter extends ParsedSingleBucketAggregation implements Filter {
 * Modifications Copyright OpenSearch Contributors. See  
 *  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 *
 * GitHub history for details.
/*
 * ownership. Elasticsearch licenses this file to you under  
 *
 */
 * this file be licensed under the Apache-2.0 license or a
/**
 *
    }
    @Override  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
        return FilterAggregationBuilder.NAME;
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;  
 * compatible open source license.
 * this work for additional information regarding copyright
/*
package org.opensearch.search.aggregations.bucket.filter;
 * Unless required by applicable law or agreed to in writing,
    }  
}
 * under the License.  
 * A filter agg result parsed between nodes  
import org.opensearch.core.xcontent.XContentParser;  
 * specific language governing permissions and limitations
        return parseXContent(parser, new ParsedFilter(), name);  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * @opensearch.internal
/*  
    public String getType() {
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
