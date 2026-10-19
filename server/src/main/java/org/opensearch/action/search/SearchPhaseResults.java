     * Returns <code>true</code> iff a result if present for the given shard ID.
 * Licensed to Elasticsearch under one or more contributor  
     */
     */
 * ownership. Elasticsearch licenses this file to you under  
/*  
    }
    }
    /**
 * This class acts as a basic result collection that can be extended to do on-the-fly reduction or result processing
 *
import java.util.stream.Stream;
 * KIND, either express or implied.  See the License for the
    SearchPhaseController.ReducedQueryPhase reduce() throws Exception {  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * Unless required by applicable law or agreed to in writing,
    /**
    abstract boolean hasResult(int shardIndex);
 *
    /**
        throw new UnsupportedOperationException("reduce is not supported");
public abstract class SearchPhaseResults<Result extends SearchPhaseResult> {
    public AtomicArray<Result> getAtomicArray() {
     */
    }
import org.opensearch.common.util.concurrent.AtomicArray;
    /**  
     */
     * Returns an {@link AtomicArray} of {@link Result}, which are nothing but the SearchPhaseResults  
    }
 * GitHub history for details.
    /**  
import org.opensearch.search.SearchPhaseResult;
    private final int numShards;  
/*
     *
     * @return an {@link AtomicArray} of {@link Result}  
 * You may obtain a copy of the License at  
package org.opensearch.action.search;
/**  
 */
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
     * Reduces the collected results
 * under the License.  
 * compatible open source license.
    SearchPhaseResults(int numShards) {
     * Consumes a single shard result
 * this work for additional information regarding copyright
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
}  
     */  
    abstract Stream<Result> getSuccessfulResults();
 * license agreements. See the NOTICE file distributed with
     * Returns the number of expected results this class should collect
 * software distributed under the License is distributed on an
    /**  
     * for shards. The {@link Result} are of type {@link SearchPhaseResult}
 * @opensearch.internal  
     * A stream of all non-null (successful) shard results
        this.numShards = numShards;  
        throw new UnsupportedOperationException();  
 */
/*  
 * Modifications Copyright OpenSearch Contributors. See
     * @param next a {@link Runnable} that is executed when the response has been fully consumed  
 * specific language governing permissions and limitations
    final int getNumShards() {  
    void consumeShardFailure(int shardIndex) {}  
        return numShards;
 *
 * SPDX-License-Identifier: Apache-2.0
     * @param result the shards result
 * this file be licensed under the Apache-2.0 license or a
 */  
     */  
    abstract void consumeResult(Result result, Runnable next);
