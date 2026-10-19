 * specific language governing permissions and limitations
package org.opensearch.join.aggregations;
    public String getWriteableName() {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.InternalAggregations;
 */
 */  
     * Read from a stream.
/*  
}
 * ownership. Elasticsearch licenses this file to you under  
        return ParentAggregationBuilder.NAME;
     */  
 * Results of the {@link ChildrenToParentAggregator}.  
import java.io.IOException;
        super(name, docCount, aggregations, metadata);
    @Override
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamInput;
 *  
 * GitHub history for details.
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.bucket.InternalSingleBucketAggregation;  
    protected InternalSingleBucketAggregation newAggregation(String name, long docCount, InternalAggregations subAggregations) {
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    @Override
public class InternalParent extends InternalSingleBucketAggregation implements Parent {
 * Unless required by applicable law or agreed to in writing,
    }
 * You may obtain a copy of the License at  
 */  
    public InternalParent(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
/*
        super(in);
    }
 *
    }  
        return new InternalParent(name, docCount, subAggregations, getMetadata());  
import java.util.Map;  
 * Modifications Copyright OpenSearch Contributors. See
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
    /**
    public InternalParent(String name, long docCount, InternalAggregations aggregations, Map<String, Object> metadata) {  
    }
/*  
