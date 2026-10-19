 * Modifications Copyright OpenSearch Contributors. See  
 * @opensearch.internal
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
/**
 *
/*
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
/*
 * compatible open source license.
        return ReverseNestedAggregationBuilder.NAME;
 * KIND, either express or implied.  See the License for the
}
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * A reverse nested agg result parsed between nodes  
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 *  
    }
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
import org.opensearch.core.xcontent.XContentParser;  
        return parseXContent(parser, new ParsedReverseNested(), name);  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
public class ParsedReverseNested extends ParsedSingleBucketAggregation implements ReverseNested {
 */
package org.opensearch.search.aggregations.bucket.nested;
 */  
 * under the License.  
/*  
    public static ParsedReverseNested fromXContent(XContentParser parser, final String name) throws IOException {
    public String getType() {
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 */
    }  
