 * compatible open source license.
    }
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
 *
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.InternalAggregations;
    protected InternalSingleBucketAggregation newAggregation(String name, long docCount, InternalAggregations subAggregations) {  
 */
 * KIND, either express or implied.  See the License for the
package org.opensearch.search.aggregations.bucket.missing;
 * GitHub history for details.
 * Missing single bucket agg
        super(name, docCount, aggregations, metadata);
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
        return new InternalMissing(name, docCount, subAggregations, getMetadata());
/**
 * not use this file except in compliance with the License.
     */
    }  
    public String getWriteableName() {
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;
 * under the License.  
 * @opensearch.internal
/*
    }  
     * Read from a stream.  
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
 */
/*  
    InternalMissing(String name, long docCount, InternalAggregations aggregations, Map<String, Object> metadata) {
 *  
/*
public class InternalMissing extends InternalSingleBucketAggregation implements Missing {  
    public InternalMissing(StreamInput in) throws IOException {
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 */
        super(in);  
 *
        return MissingAggregationBuilder.NAME;
    }
 *  
    /**
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.bucket.InternalSingleBucketAggregation;
import org.opensearch.core.common.io.stream.StreamInput;  
