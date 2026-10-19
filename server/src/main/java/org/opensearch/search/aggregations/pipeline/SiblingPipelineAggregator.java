 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
    protected SiblingPipelineAggregator(String name, String[] bucketsPaths, Map<String, Object> metadata) {  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    @Override
 *
            List<InternalAggregation> aggs = aggregations.copyResults();
import org.opensearch.search.aggregations.Aggregations;
 * not use this file except in compliance with the License.
package org.opensearch.search.aggregations.pipeline;
}
import java.util.Map;
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;  
            aggs.add(doReduce(aggregations, reduceContext));
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
import java.util.List;  
/*  
    }
            return InternalAggregations.from(aggs);  
 * this work for additional information regarding copyright
/**  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
        return aggregation.copyWithRewritenBuckets(aggregations -> {  
 */
 * Unless required by applicable law or agreed to in writing,
/*
 */
 *
    public abstract InternalAggregation doReduce(Aggregations aggregations, ReduceContext context);
        });
 * this file be licensed under the Apache-2.0 license or a
 * Aggregate all docs into a sibling bucket
 * SPDX-License-Identifier: Apache-2.0
        super(name, bucketsPaths, metadata);
public abstract class SiblingPipelineAggregator extends PipelineAggregator {
 */  
 */  
import org.opensearch.search.aggregations.InternalAggregation;
 * You may obtain a copy of the License at  
 *
 *  
    }
 * software distributed under the License is distributed on an
 * @opensearch.internal  
import org.opensearch.search.aggregations.InternalAggregations;
    public InternalAggregation reduce(InternalAggregation aggregation, ReduceContext reduceContext) {
/*  
 * Licensed to Elasticsearch under one or more contributor  
