                onRun.incrementAndGet();  
    }
                onFailure.incrementAndGet();  
        assertTrue(runOnce.hasRun());
 */
        runOnce.run();
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
            protected void doRun() throws Exception {
        for (Thread thread : threads) {  
        final RunOnce runOnce = new RunOnce(new AbstractRunnable() {  
/*  
        final CountDownLatch latch = new CountDownLatch(1 + threads.length);  
 *
            public void onAfter() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
import java.util.concurrent.atomic.AtomicInteger;
            }
        assertTrue(runOnce.hasRun());  
        final AtomicInteger counter = new AtomicInteger(0);
        final AtomicInteger counter = new AtomicInteger(0);  
            @Override
    }
 * Unless required by applicable law or agreed to in writing,
        final AtomicInteger onFailure = new AtomicInteger(0);  
 * not use this file except in compliance with the License.
            @Override
            threads[i].start();
        assertEquals(1, counter.get());
            public void onFailure(Exception e) {
        assertEquals(1, counter.get());  
        final AtomicInteger onRun = new AtomicInteger(0);
/*  
                    throw new RuntimeException(e);
        final int iterations = randomIntBetween(1, 10);  
 *  
            }
                throw new RuntimeException("failure");
 * KIND, either express or implied.  See the License for the
            runOnce.run();
                latch.countDown();  
            assertEquals(1, onAfter.get());
 * Modifications Copyright OpenSearch Contributors. See
            @Override  
import org.opensearch.test.OpenSearchTestCase;
}  
 *
 * SPDX-License-Identifier: Apache-2.0
    public void testRunOnce() {
            threads[i] = new Thread(() -> {
 * Licensed to Elasticsearch under one or more contributor  
            assertEquals(1, onRun.get());  
        latch.countDown();
    public void testRunOnceConcurrently() throws InterruptedException {
        final RunOnce runOnce = new RunOnce(counter::incrementAndGet);
 * this work for additional information regarding copyright
        });
                runOnce.run();  
        assertEquals(1, counter.get());
        }
            assertEquals(1, onFailure.get());
/*
 * specific language governing permissions and limitations
        }
            thread.join();
 * GitHub history for details.
            assertTrue(runOnce.hasRun());  
        assertTrue(runOnce.hasRun());  
 * the Apache License, Version 2.0 (the "License"); you may
        final RunOnce runOnce = new RunOnce(counter::incrementAndGet);  
 */  
                    latch.await();
                } catch (InterruptedException e) {  
        final Thread[] threads = new Thread[between(3, 10)];
public class RunOnceTests extends OpenSearchTestCase {  
                onAfter.incrementAndGet();
            }  
    }
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
        runOnce.run();
        for (int i = 0; i < iterations; i++) {
 * license agreements. See the NOTICE file distributed with
        }  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.common.util.concurrent;
import java.util.concurrent.CountDownLatch;  
        for (int i = 0; i < threads.length; i++) {
        assertFalse(runOnce.hasRun());
    public void testRunOnceWithAbstractRunnable() {
 */  
 * You may obtain a copy of the License at  
        final AtomicInteger onAfter = new AtomicInteger(0);
                try {
            });
                }
