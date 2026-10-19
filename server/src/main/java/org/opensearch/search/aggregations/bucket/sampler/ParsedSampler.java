import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
 *
 * SPDX-License-Identifier: Apache-2.0
/**
 * under the License.  
}
 * You may obtain a copy of the License at  
        return parseXContent(parser, new ParsedSampler(), name);  
/*  
 * A sampler result parsed between nodes  
public class ParsedSampler extends ParsedSingleBucketAggregation implements Sampler {
 * software distributed under the License is distributed on an
 *
import org.opensearch.core.xcontent.XContentParser;  
import java.io.IOException;  
 */  
 * compatible open source license.
 */
 * specific language governing permissions and limitations
 */
    }
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String getType() {
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 *
    public static ParsedSampler fromXContent(XContentParser parser, final String name) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.search.aggregations.bucket.sampler;
 * not use this file except in compliance with the License.
 * @opensearch.internal
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 */  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        return InternalSampler.PARSER_NAME;
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    }  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
 *  
 * ownership. Elasticsearch licenses this file to you under  
