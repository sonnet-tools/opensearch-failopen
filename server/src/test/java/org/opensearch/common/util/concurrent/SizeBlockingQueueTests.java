 * Unless required by applicable law or agreed to in writing,
        assertThat(maxSize.get(), equalTo(capacity));
        queueOfferThread.join();
                    throw new RuntimeException(e);
}
        queueOfferThread.start();
        final CyclicBarrier barrier = new CyclicBarrier(2);
                }  
        final Thread queueOfferThread = new Thread(() -> {
 * specific language governing permissions and limitations
/*
 * under the License.  
package org.opensearch.common.util.concurrent;
        // the maximum size of the queue should be equal to the capacity
            sizeBlockingQueue.offer(i);
import static org.hamcrest.Matchers.equalTo;  
import java.util.concurrent.BlockingQueue;
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.BrokenBarrierException;
 * Licensed to Elasticsearch under one or more contributor  
 *  
/*  
            }
                maxSize.set(Math.max(maxSize.get(), sizeBlockingQueue.size()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    barrier.await();  
        queueSizeThread.start();
        final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(capacity);
                } catch (final BrokenBarrierException | InterruptedException e) {
 * software distributed under the License is distributed on an
import java.util.concurrent.CyclicBarrier;  
    }  
 * compatible open source license.
     * previously failed when the size of the queue was incremented and exposed externally even though the item offered to the queue was  
        // this thread will try to offer items to the queue while the queue size thread is polling the size
        final SizeBlockingQueue<Integer> sizeBlockingQueue = new SizeBlockingQueue<>(blockingQueue, capacity);  
 */  
     */
 * ownership. Elasticsearch licenses this file to you under  
                try {
        for (int i = 0; i < capacity; i++) {  
import java.util.concurrent.ArrayBlockingQueue;  
    /*
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * this work for additional information regarding copyright
     * never actually added to the queue.
 */
        }
        final AtomicInteger maxSize = new AtomicInteger();
                    // synchronize each iteration of checking the size with each iteration of offering, each iteration is a race
 * You may obtain a copy of the License at  
public class SizeBlockingQueueTests extends OpenSearchTestCase {
 * license agreements. See the NOTICE file distributed with
 *
            }
 * KIND, either express or implied.  See the License for the
            for (int i = 0; i < iterations; i++) {  
                try {
        final int capacity = randomIntBetween(1, 32);
import java.util.concurrent.atomic.AtomicInteger;
                    throw new RuntimeException(e);
 */  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        // wait for the threads to finish  
        });  
        final Thread queueSizeThread = new Thread(() -> {
        });  
                    barrier.await();  
     * Tests that the size of a queue remains at most the capacity while offers are made to a queue when at capacity. This test would have
                sizeBlockingQueue.offer(capacity + i);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
            for (int i = 0; i < iterations; i++) {  
        queueSizeThread.join();
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
        // this thread will repeatedly poll the size of the queue keeping track of the maximum size that it sees  
                } catch (final BrokenBarrierException | InterruptedException e) {
        // fill the queue to capacity
                    // synchronize each iteration of checking the size with each iteration of offering, each iteration is a race
                }  
        final int iterations = 1 << 16;
    public void testQueueSize() throws InterruptedException {  
