                            null,
            }
import org.opensearch.common.UUIDs;
                            null  
        int numResultsExpected = randomIntBetween(1, consumer.getAtomicArray().length());
        }
                    assertEquals(1, context.failures.stream().filter(f -> f.shardId() == shardId).count());
        for (int i = 0; i < numResultsExpected; i++) {
    }
                    state.add(2);
                case 0:
                    final int shardId = i;  
        MockSearchPhaseContext context = new MockSearchPhaseContext(consumer.getAtomicArray().length());
/*  
 * compatible open source license.
                            shardID,
                    state.add(0);  
            int shardID = i;  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
                    fail("unknown state");
                    );
 * under the License.  
                    executor.execute(() -> {
                case 1:
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.action.search;
 * SPDX-License-Identifier: Apache-2.0
            }
                        dfsSearchResult.setSearchShardTarget(  
import org.opensearch.search.dfs.DfsSearchResult;  
import java.util.ArrayList;
                            new SearchShardTarget("foo", new ShardId("bar", "baz", shardID), null, OriginalIndices.NONE)
        ArraySearchPhaseResults<SearchPhaseResult> consumer = new ArraySearchPhaseResults<>(randomIntBetween(1, 100));
}  
                    break;
                case 0:
                    executor.execute(() -> collector.countDown());
                default:
/*
                    assertNotNull(results.get(i));
                        DfsSearchResult dfsSearchResult = new DfsSearchResult(  
 * specific language governing permissions and limitations
                case 2:
        };  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
 *  
            if (randomBoolean() && maybeFork) {  
        for (int i = numResultsExpected; i < results.length(); i++) {
                    });
        CountedCollector<SearchPhaseResult> collector = new CountedCollector<>(consumer, numResultsExpected, latch::countDown, context);
        latch.await();
 * this file be licensed under the Apache-2.0 license or a
                    break;  
        assertEquals(numResultsExpected, state.size());  
        List<Integer> state = new ArrayList<>();  
                        )
import org.opensearch.common.util.concurrent.AtomicArray;
        boolean maybeFork = randomBoolean();
import java.util.concurrent.CountDownLatch;  
import org.opensearch.test.OpenSearchTestCase;
                        );
                case 2:  
                    fail("unknown state");
                    break;
                        dfsSearchResult.setShardIndex(shardID);
                        () -> collector.onFailure(  
            switch (state.get(i)) {  
import org.opensearch.core.index.shard.ShardId;  
                new Thread(runnable).start();
import org.opensearch.search.SearchPhaseResult;
                default:  
                    break;  
                            new ShardSearchContextId(UUIDs.randomBase64UUID(), shardID),
                        collector.onResult(dfsSearchResult);  
        CountDownLatch latch = new CountDownLatch(1);  
 */
        for (int i = 0; i < numResultsExpected; i++) {
    public void testCollect() throws InterruptedException {
public class CountedCollectorTests extends OpenSearchTestCase {  
                            new RuntimeException("boom")  
                    assertEquals(i, results.get(i).getContextId().getId());  
                case 1:  
        }  
 */
            } else {  
                    assertNull(results.get(i));
                    executor.execute(
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
                    state.add(1);
            }  
            switch (randomIntBetween(0, 2)) {
 * this work for additional information regarding copyright
        AtomicArray<SearchPhaseResult> results = consumer.getAtomicArray();
import org.opensearch.search.SearchShardTarget;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
                        );
import java.util.concurrent.Executor;
        }
                runnable.run();
 * You may obtain a copy of the License at  
 *
        Executor executor = (runnable) -> {
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.OriginalIndices;  
 * software distributed under the License is distributed on an
import org.opensearch.search.internal.ShardSearchContextId;
 */  
            assertNull("index: " + i, results.get(i));  
/*
                    break;
 * GitHub history for details.
                            new SearchShardTarget("foo", new ShardId("bar", "baz", shardID), null, OriginalIndices.NONE),
                    break;
