 */
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    }
    boolean hasResult(int shardIndex) {  
        assert results.get(result.getShardIndex()) == null : "shardIndex: " + result.getShardIndex() + " is already set";
    Stream<Result> getSuccessfulResults() {
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    public AtomicArray<Result> getAtomicArray() {
    }
        return results.get(shardIndex) != null;
 * this file be licensed under the Apache-2.0 license or a
    }
 */  
    @Override
    final AtomicArray<Result> results;  
import org.opensearch.common.util.concurrent.AtomicArray;
        return results.asList().stream();
 * license agreements. See the NOTICE file distributed with
 * This class acts as a basic result collection that can be extended to do on-the-fly reduction or result processing
 */
    }
        results.set(result.getShardIndex(), result);
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
/**  
 *  
 * this work for additional information regarding copyright
 *
    ArraySearchPhaseResults(int size) {
 */  
        super(size);  
        this.results = new AtomicArray<>(size);
class ArraySearchPhaseResults<Result extends SearchPhaseResult> extends SearchPhaseResults<Result> {
}
import org.opensearch.search.SearchPhaseResult;
    }  
 * compatible open source license.
        next.run();  
        return results;  
/*
 * under the License.  
 * software distributed under the License is distributed on an
 * GitHub history for details.
/*  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    void consumeResult(Result result, Runnable next) {  
 *
package org.opensearch.action.search;
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * @opensearch.internal  
import java.util.stream.Stream;
