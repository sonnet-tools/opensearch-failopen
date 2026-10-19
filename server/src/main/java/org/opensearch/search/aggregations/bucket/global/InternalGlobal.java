 */
    public InternalGlobal(StreamInput in) throws IOException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * A global scope get (the document set on which we aggregate is all documents in the search context (ie. index + type)
public class InternalGlobal extends InternalSingleBucketAggregation implements Global {
import java.io.IOException;
}
    }
    }  
    protected InternalSingleBucketAggregation newAggregation(String name, long docCount, InternalAggregations subAggregations) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
    @Override  
 * The OpenSearch Contributors require contributions made to  
 * regardless the query.  
import org.opensearch.core.common.io.stream.StreamInput;  
    /**  
import org.opensearch.search.aggregations.bucket.InternalSingleBucketAggregation;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.InternalAggregations;
 */  
        return new InternalGlobal(name, docCount, subAggregations, getMetadata());
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
     * Read from a stream.
     */
 *
 * the Apache License, Version 2.0 (the "License"); you may
    }
/**
 * under the License.  
 * You may obtain a copy of the License at  
        super(in);
/*
import java.util.Map;
 * Modifications Copyright OpenSearch Contributors. See  
 *  
    }
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    public String getWriteableName() {
 * @opensearch.internal
    InternalGlobal(String name, long docCount, InternalAggregations aggregations, Map<String, Object> metadata) {
/*
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.search.aggregations.bucket.global;
/*  
 */
        super(name, docCount, aggregations, metadata);  
 * Unless required by applicable law or agreed to in writing,
 *
        return GlobalAggregationBuilder.NAME;  
 *
 */  
 * specific language governing permissions and limitations
