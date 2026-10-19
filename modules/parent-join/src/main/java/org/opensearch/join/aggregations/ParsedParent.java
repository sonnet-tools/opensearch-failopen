 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
/*
    public String getType() {
 *
    @Override
 * compatible open source license.
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 *
import java.io.IOException;  
 * not use this file except in compliance with the License.
    }
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
}  
public class ParsedParent extends ParsedSingleBucketAggregation implements Parent {
 * specific language governing permissions and limitations
        return ParentAggregationBuilder.NAME;  
 */
 *  
 * Licensed to Elasticsearch under one or more contributor  
/*  
    }
 * GitHub history for details.
 */
    public static ParsedParent fromXContent(XContentParser parser, final String name) throws IOException {  
package org.opensearch.join.aggregations;
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentParser;  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        return parseXContent(parser, new ParsedParent(), name);
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
 * software distributed under the License is distributed on an
/*
