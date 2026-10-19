 * under the License.  
     */
 * The OpenSearch Contributors require contributions made to  
    private final Runnable onFinish;  
    private final CountDown counter;
 */
final class CountedCollector<R extends SearchPhaseResult> {  
 */
            onFinish.run();
 * Unless required by applicable law or agreed to in writing,
/*
        assert counter.isCountedDown() == false : "more operations executed than specified";  
     */
     * Forcefully counts down an operation and executes the provided runnable
 * {@link #onResult(SearchPhaseResult)} will be set to the provided result array
import org.opensearch.search.SearchShardTarget;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.search;
    }
        }
    /**
 * @opensearch.internal
 * GitHub history for details.
 *
            context.onShardFailure(shardIndex, shardTarget, e);
     */
/**
import org.opensearch.common.util.concurrent.CountDown;
     * Sets the result to the given array index and then runs {@link #countDown()}
import org.opensearch.search.SearchPhaseResult;
    void countDown() {
 *  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        this.counter = new CountDown(expectedOps);
 * KIND, either express or implied.  See the License for the
        if (counter.countDown()) {
 */
/*
        resultConsumer.consumeResult(result, this::countDown);
    /**
 * this file be licensed under the Apache-2.0 license or a
        } finally {
 * Licensed to Elasticsearch under one or more contributor  
    CountedCollector(ArraySearchPhaseResults<R> resultConsumer, int expectedOps, Runnable onFinish, SearchPhaseContext context) {  
 * not use this file except in compliance with the License.
    /**  
 * ownership. Elasticsearch licenses this file to you under  
    }
 *
}  
     * if all expected operations where executed  
 * You may obtain a copy of the License at  
        this.resultConsumer = resultConsumer;
    }
 * specific language governing permissions and limitations
            countDown();  
/*  
 */  
 * software distributed under the License is distributed on an
        this.onFinish = onFinish;  
        this.context = context;
        }  
    private final ArraySearchPhaseResults<R> resultConsumer;
        try {  
 * compatible open source license.
 * This is a simple base class to simplify fan out to shards and collect their results. Each results passed to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Escalates the failure via {@link SearchPhaseContext#onShardFailure(int, SearchShardTarget, Exception)}
import org.opensearch.common.Nullable;  
    }
 * where the given index is used to set the result on the array.
 * SPDX-License-Identifier: Apache-2.0
 *  
     * and then runs {@link #countDown()}  
 * Modifications Copyright OpenSearch Contributors. See  
    private final SearchPhaseContext context;
    void onFailure(final int shardIndex, @Nullable SearchShardTarget shardTarget, Exception e) {
    void onResult(R result) {  
