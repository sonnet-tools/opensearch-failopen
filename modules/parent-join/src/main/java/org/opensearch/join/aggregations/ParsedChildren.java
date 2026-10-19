 * Modifications Copyright OpenSearch Contributors. See  
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * not use this file except in compliance with the License.
/*
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        return ChildrenAggregationBuilder.NAME;  
import org.opensearch.core.xcontent.XContentParser;  
package org.opensearch.join.aggregations;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * under the License.  
 *
 * Unless required by applicable law or agreed to in writing,
 */  
 * specific language governing permissions and limitations
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
}  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
        return parseXContent(parser, new ParsedChildren(), name);
 * this work for additional information regarding copyright
    public static ParsedChildren fromXContent(XContentParser parser, final String name) throws IOException {  
 *
    public String getType() {
 * KIND, either express or implied.  See the License for the
import java.io.IOException;  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
    }
/*  
 */
public class ParsedChildren extends ParsedSingleBucketAggregation implements Children {
    }
