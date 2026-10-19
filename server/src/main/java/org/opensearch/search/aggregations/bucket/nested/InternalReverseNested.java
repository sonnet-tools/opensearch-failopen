    public InternalReverseNested(String name, long docCount, InternalAggregations aggregations, Map<String, Object> metadata) {
 *  
 */
 * Modifications Copyright OpenSearch Contributors. See  
        return ReverseNestedAggregationBuilder.NAME;
import org.opensearch.search.aggregations.bucket.InternalSingleBucketAggregation;
/**
        return new InternalReverseNested(name, docCount, subAggregations, getMetadata());
 * this work for additional information regarding copyright
 */
package org.opensearch.search.aggregations.bucket.nested;
 * SPDX-License-Identifier: Apache-2.0
    }  
 *
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
    }
    @Override  
 *  
 * Result of the {@link ReverseNestedAggregator}.
    /**
 * license agreements. See the NOTICE file distributed with
    public String getWriteableName() {
}  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * compatible open source license.
import org.opensearch.search.aggregations.InternalAggregations;
 * @opensearch.internal
     * Read from a stream.  
        super(name, docCount, aggregations, metadata);
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
 * specific language governing permissions and limitations
 */
 * software distributed under the License is distributed on an
public class InternalReverseNested extends InternalSingleBucketAggregation implements ReverseNested {  
/*
        super(in);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
    public InternalReverseNested(StreamInput in) throws IOException {
    @Override
    }
import java.util.Map;
    }  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
import org.opensearch.core.common.io.stream.StreamInput;  
    protected InternalSingleBucketAggregation newAggregation(String name, long docCount, InternalAggregations subAggregations) {  
/*
/*  
