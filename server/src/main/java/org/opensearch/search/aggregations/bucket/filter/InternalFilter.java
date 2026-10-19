 * the Apache License, Version 2.0 (the "License"); you may
        super(in);
    protected InternalSingleBucketAggregation newAggregation(String name, long docCount, InternalAggregations subAggregations) {
 *
 * compatible open source license.
 * this work for additional information regarding copyright
 *
 * Implementation of filter agg  
import org.opensearch.search.aggregations.InternalAggregations;
 */  
    }  
 * ownership. Elasticsearch licenses this file to you under  
        super(name, docCount, subAggregations, metadata);  
/**
    @Override
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;  
 * specific language governing permissions and limitations
     * Stream from a stream.
 * Licensed to Elasticsearch under one or more contributor  
 */
    }
 * under the License.  
/*  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.search.aggregations.bucket.filter;
    }
 */  
import java.io.IOException;
 * not use this file except in compliance with the License.
    @Override  
 * You may obtain a copy of the License at  
    InternalFilter(String name, long docCount, InternalAggregations subAggregations, Map<String, Object> metadata) {
}
 *  
     */
public class InternalFilter extends InternalSingleBucketAggregation implements Filter {
 * Unless required by applicable law or agreed to in writing,
        return new InternalFilter(name, docCount, subAggregations, getMetadata());
    }
/*
        return FilterAggregationBuilder.NAME;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import org.opensearch.core.common.io.stream.StreamInput;
/*  
 */  
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
    public InternalFilter(StreamInput in) throws IOException {  
 * software distributed under the License is distributed on an
    public String getWriteableName() {
    /**  
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.bucket.InternalSingleBucketAggregation;  
 * The OpenSearch Contributors require contributions made to  
