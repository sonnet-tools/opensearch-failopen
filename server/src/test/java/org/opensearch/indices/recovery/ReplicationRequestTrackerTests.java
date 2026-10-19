import org.opensearch.indices.replication.common.ReplicationRequestTracker;
    }
                assertTrue(future.isDone());  
        ReplicationRequestTracker requestTracker = new ReplicationRequestTracker();
            Optional<PlainActionFuture<Void>> first = value.stream().findFirst();  
            }  
import org.opensearch.action.support.PlainActionFuture;
 */
            }
        ConcurrentMap<Long, Set<PlainActionFuture<Void>>> seqToResult = ConcurrentCollections.newConcurrentMap();
 * the Apache License, Version 2.0 (the "License"); you may
        int numberOfRequests = randomIntBetween(100, 200);  
                        // Ensure that we only return 1 future per sequence number  
 * specific language governing permissions and limitations
 */  
                        }  
import org.opensearch.OpenSearchException;
        for (Set<PlainActionFuture<Void>> value : seqToResult.values()) {
                    ActionListener<Void> listener = requestTracker.markReceivedAndCreateListener(seqNo, future);  
            for (PlainActionFuture<Void> future : value) {
                Set<PlainActionFuture<Void>> set = seqToResult.computeIfAbsent(seqNo, (k) -> ConcurrentCollections.newConcurrentSet());  
 * The OpenSearch Contributors require contributions made to  
            assertTrue(first.isPresent());
    }
                        assertEquals(expectedException.getMessage(), e.getMessage());
    public void setUp() throws Exception {
                first.get().actionGet();
        super.tearDown();  
                            listener.onResponse(null);
        Set<Long> seqNosReturned = ConcurrentCollections.newConcurrentSet();
 *
    public void tearDown() throws Exception {
                }
 * under the License.  
        for (int j = 0; j < numberOfRequests; ++j) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
        });  
                        boolean added = seqNosReturned.add(seqNo);
 * not use this file except in compliance with the License.
                        if (rarely()) {
            } catch (Exception e) {  
            try {  
    private TestThreadPool threadPool;
 */  
            }
                if (expectedException == null) {
 * ownership. Elasticsearch licenses this file to you under  
        }
public class ReplicationRequestTrackerTests extends OpenSearchTestCase {
                        future.actionGet();
 * KIND, either express or implied.  See the License for the
            Exception expectedException = null;
        seqToResult.values().stream().flatMap(Collection::stream).forEach(f -> {  
                });
        }  
            for (int i = 0; i < iterations; ++i) {
/*  
 * Unless required by applicable law or agreed to in writing,
 *  
                threadPool.generic().execute(() -> {
        threadPool = new TestThreadPool(getTestName());  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
import java.util.Optional;
                    }
import java.util.concurrent.ConcurrentMap;  
    @Override  
 *
 * GitHub history for details.
package org.opensearch.indices.recovery;
                set.add(future);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.threadpool.TestThreadPool;
        terminate(threadPool);
 * software distributed under the License is distributed on an
                f.actionGet();
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
                    if (listener != null) {
                        } else {
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
                    } catch (Exception e) {
            int iterations = randomIntBetween(2, 5);  
                    }  
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    try {
    public void testIdempotencyIsEnforced() {  
                        fail("expected exception");  
                } else {  
import org.opensearch.core.action.ActionListener;
    }
                PlainActionFuture<Void> future = PlainActionFuture.newFuture();
                            listener.onFailure(new OpenSearchException(randomAlphaOfLength(10)));  
import org.opensearch.test.OpenSearchTestCase;  
                    future.actionGet();
            final long seqNo = j;
                expectedException = e;  
import java.util.Collection;  
                // Ignore for now. We will assert later.
/*  
            try {
        super.setUp();
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
            }
 * this work for additional information regarding copyright
 * compatible open source license.
            } catch (Exception e) {
}
                        assertTrue(added);
