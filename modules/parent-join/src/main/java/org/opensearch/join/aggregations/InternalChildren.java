import org.opensearch.core.common.io.stream.StreamInput;
        return new InternalChildren(name, docCount, subAggregations, getMetadata());  
/*  
 * compatible open source license.
import java.util.Map;  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
     * Read from a stream.
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*
import org.opensearch.search.aggregations.InternalAggregations;
 */
    public String getWriteableName() {  
}
    /**
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import org.opensearch.search.aggregations.bucket.InternalSingleBucketAggregation;  
    }
    }
 * SPDX-License-Identifier: Apache-2.0
     */  
        super(name, docCount, aggregations, metadata);
 *  
public class InternalChildren extends InternalSingleBucketAggregation implements Children {
 */
/**
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.join.aggregations;
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * under the License.  
    @Override
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 *
        super(in);
    public InternalChildren(StreamInput in) throws IOException {
 * GitHub history for details.
    }  
 * this work for additional information regarding copyright
 * Results of the {@link ParentToChildrenAggregator}.  
    public InternalChildren(String name, long docCount, InternalAggregations aggregations, Map<String, Object> metadata) {  
    protected InternalSingleBucketAggregation newAggregation(String name, long docCount, InternalAggregations subAggregations) {
 * not use this file except in compliance with the License.
import java.io.IOException;
        return ChildrenAggregationBuilder.NAME;
 * Unless required by applicable law or agreed to in writing,
 *
