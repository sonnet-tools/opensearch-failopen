 * Unless required by applicable law or agreed to in writing,
    }  
/*  
 */
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
package org.opensearch.search.aggregations.bucket.global;
 * SPDX-License-Identifier: Apache-2.0
    public static ParsedGlobal fromXContent(XContentParser parser, final String name) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser;  
 *
/**
 * this file be licensed under the Apache-2.0 license or a
    }
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 *
 * ownership. Elasticsearch licenses this file to you under  
public class ParsedGlobal extends ParsedSingleBucketAggregation implements Global {
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
    @Override  
/*
    public String getType() {
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
        return GlobalAggregationBuilder.NAME;
 * A global agg result parsed between nodes  
import java.io.IOException;  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 *  
        return parseXContent(parser, new ParsedGlobal(), name);  
 *
 * compatible open source license.
 */
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 */  
 * GitHub history for details.
}
