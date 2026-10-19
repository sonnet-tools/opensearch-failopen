 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 */
 * A missing agg result parsed between nodes  
 *
 * license agreements. See the NOTICE file distributed with
 */  
public class ParsedMissing extends ParsedSingleBucketAggregation implements Missing {
 * SPDX-License-Identifier: Apache-2.0
 */
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;  
 * @opensearch.internal
    }
 * Modifications Copyright OpenSearch Contributors. See  
    }  
        return MissingAggregationBuilder.NAME;
 * this work for additional information regarding copyright
/**
 * You may obtain a copy of the License at  
/*
 *
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
 *
/*
 * specific language governing permissions and limitations
import java.io.IOException;  
 *  
        return parseXContent(parser, new ParsedMissing(), name);  
}
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * not use this file except in compliance with the License.
package org.opensearch.search.aggregations.bucket.missing;
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    @Override  
    public String getType() {
    public static ParsedMissing fromXContent(XContentParser parser, final String name) throws IOException {
