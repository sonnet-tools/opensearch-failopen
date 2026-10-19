            throw new IllegalArgumentException("supersetFreq > supersetSize, in " + scoreFunctionName);
 *  
 * software distributed under the License is distributed on an
        }  
     * Provides a hook for subclasses to provide a version of the heuristic
     * @return a version of this heuristic suitable for execution
 * this work for additional information regarding copyright
     */
     * @param reduceContext the reduce context on the coordinating node  
 * license agreements. See the NOTICE file distributed with
                "Frequencies of subset and superset must be positive in " + scoreFunctionName + ".getScore()"
 *
            throw new IllegalArgumentException("subsetFreq > subsetSize, in " + scoreFunctionName);
 * not use this file except in compliance with the License.
            throw new IllegalArgumentException(  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    public SignificanceHeuristic rewrite(QueryShardContext queryShardContext) {
     * @return a version of this heuristic suitable for execution
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.ToXContentFragment;
 * Heuristic for that {@link SignificantTerms} uses to pick out significant terms.
 */
     * @param queryShardContext the shard context on the data node
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
/**
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.internal
    public SignificanceHeuristic rewrite(InternalAggregation.ReduceContext reduceContext) {  
        if (subsetFreq < 0 || subsetSize < 0 || supersetFreq < 0 || supersetSize < 0) {
     * prepared for execution on data on a shard.  
/*
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        String scoreFunctionName  
    }  
     * @param subsetFreq   The frequency of the term in the selected sample
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this;
        }  
/*  
     * Provides a hook for subclasses to provide a version of the heuristic
     */  
        long supersetSize,
        }  
            );
    /**
    }
import org.opensearch.search.aggregations.InternalAggregation;
        long supersetFreq,
 */  
 * Modifications Copyright OpenSearch Contributors. See
    public abstract double getScore(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize);
     * @param supersetFreq The frequency of the term in the superset from which the sample was taken
import org.opensearch.search.aggregations.bucket.terms.SignificantTerms;
    /**  
    protected void checkFrequencyValidity(
        return this;
package org.opensearch.search.aggregations.bucket.terms.heuristic;
}
    }
        long subsetSize,  
     * @return a "significance" score  
 * GitHub history for details.
     * @param supersetSize The size of the superset from which the sample was taken  (typically number of docs)
     * @param subsetSize   The size of the selected sample (typically number of docs)  
     * prepared for execution on data on the coordinating node.
import org.opensearch.index.query.QueryShardContext;  
        if (subsetFreq > subsetSize) {
public abstract class SignificanceHeuristic implements NamedWriteable, ToXContentFragment {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * under the License.  
    ) {
import org.opensearch.core.common.io.stream.NamedWriteable;
 * The OpenSearch Contributors require contributions made to  
 *
/*  
 * You may obtain a copy of the License at  
 *  
     */
    /**
        long subsetFreq,
        if (supersetFreq > supersetSize) {
