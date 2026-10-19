    @Override  
 */
 * under the License.  
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        return NestedAggregationBuilder.NAME;
/*  
 *
    }
 *
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;  
/**
 * KIND, either express or implied.  See the License for the
 */  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
 */
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
    public String getType() {
}
    }  
 */  
 * A nested agg result parsed between nodes  
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 *  
        return parseXContent(parser, new ParsedNested(), name);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 *
 * Licensed to Elasticsearch under one or more contributor  
/*
 * not use this file except in compliance with the License.
    public static ParsedNested fromXContent(XContentParser parser, final String name) throws IOException {
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.search.aggregations.bucket.nested;
import org.opensearch.core.xcontent.XContentParser;  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
public class ParsedNested extends ParsedSingleBucketAggregation implements Nested {
