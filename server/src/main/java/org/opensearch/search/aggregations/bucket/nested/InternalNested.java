 * Result of the {@link NestedAggregator}.
    @Override
 * @opensearch.internal
 *  
    public String getWriteableName() {
        return new InternalNested(name, docCount, subAggregations, getMetadata());
 * Unless required by applicable law or agreed to in writing,
 *  
/*
 * GitHub history for details.
import java.util.Map;
 */
    public InternalNested(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See  
 * You may obtain a copy of the License at  
        return NestedAggregationBuilder.NAME;
    }
        super(in);  
 * Licensed to Elasticsearch under one or more contributor  
 */  
import org.opensearch.search.aggregations.bucket.InternalSingleBucketAggregation;
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.aggregations.bucket.nested;
     * Read from a stream.  
public class InternalNested extends InternalSingleBucketAggregation implements Nested {  
    }  
 */
    }
 * ownership. Elasticsearch licenses this file to you under  
    InternalNested(String name, long docCount, InternalAggregations aggregations, Map<String, Object> metadata) {
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
     */
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
/**
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.search.aggregations.InternalAggregations;
 * software distributed under the License is distributed on an
 * under the License.  
/*
    }  
/*  
import java.io.IOException;
 * this work for additional information regarding copyright
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
}  
 *
        super(name, docCount, aggregations, metadata);
    /**
    protected InternalSingleBucketAggregation newAggregation(String name, long docCount, InternalAggregations subAggregations) {  
 * SPDX-License-Identifier: Apache-2.0
 */
