 */
/*  
 * not use this file except in compliance with the License.
 * @opensearch.internal
package org.opensearch.search.aggregations.bucket.sampler;
import java.util.Map;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.bucket.InternalSingleBucketAggregation;
 */
/*
     * Read from a stream.
import org.opensearch.core.common.io.stream.StreamInput;  
}  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
    @Override
        return PARSER_NAME;
    @Override  
    /**  
import org.opensearch.search.aggregations.InternalAggregations;
/*
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
 *
    public String getWriteableName() {
        return new InternalSampler(name, docCount, subAggregations, metadata);
 * this file be licensed under the Apache-2.0 license or a
        return NAME;  
 * software distributed under the License is distributed on an
    // InternalSampler and UnmappedSampler share the same parser name, so we use this when identifying the aggregation type
    }
    public String getType() {
 *  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    public static final String PARSER_NAME = "sampler";  
 * Implementation of sampler bucket
 */  
/**
    protected InternalSingleBucketAggregation newAggregation(String name, long docCount, InternalAggregations subAggregations) {  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
        super(in);
 * KIND, either express or implied.  See the License for the
    @Override
 * GitHub history for details.
public class InternalSampler extends InternalSingleBucketAggregation implements Sampler {  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
    }
    InternalSampler(String name, long docCount, InternalAggregations subAggregations, Map<String, Object> metadata) {
    public static final String NAME = "mapped_sampler";
 * ownership. Elasticsearch licenses this file to you under  
     */
    }
 * license agreements. See the NOTICE file distributed with
        super(name, docCount, subAggregations, metadata);  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public InternalSampler(StreamInput in) throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See  
    }  
 * compatible open source license.
