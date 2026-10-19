    }
 */  
        assertTrue(future.isDone());
    public void testListenableFutureNotifiesListeners() {  
                    }  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final AtomicInteger numResponses = new AtomicInteger(0);
        if (executorService != null) {
 * compatible open source license.
    public void testConcurrentListenerRegistrationAndCompletion() throws BrokenBarrierException, InterruptedException {
        assertEquals(numberOfThreads - 1, numResponses.get());
                        logger.info("listener {} added", threadNum);
        }  
            1000,
 *  
/*  
                } catch (InterruptedException | BrokenBarrierException e) {
                        }), executorService, threadContext);
 * Modifications Copyright OpenSearch Contributors. See
                        future.addListener(ActionListener.wrap(s -> {  
                OpenSearchExecutors.newDirectExecutorService(),
        assertEquals(numberOfListeners, notifications.get());
                        logger.info("adding listener {}", threadNum);
    }
        final int completingThread = randomIntBetween(0, numberOfThreads - 1);  
            );  
                ActionListener.wrap(notifications::incrementAndGet),  
        final CountDownLatch listenersLatch = new CountDownLatch(numberOfThreads - 1);
                        // execution of the listeners instead of actually going async
        );
        assertEquals(0, numExceptions.get());
                try {  
            final int threadNum = i;  
        AtomicInteger notifications = new AtomicInteger(0);
 * this file be licensed under the Apache-2.0 license or a
        ListenableFuture<String> future = new ListenableFuture<>();  
            threadContext
 * under the License.  
 * KIND, either express or implied.  See the License for the
public class ListenableFutureTests extends OpenSearchTestCase {  
        future.onResponse("");  
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);  
            Thread thread = new Thread(() -> {
    private ExecutorService executorService;
 */
package org.opensearch.common.util.concurrent;
            future.addListener(ActionListener.wrap(s -> fail("this should never be called"), e -> {
 *     http://www.apache.org/licenses/LICENSE-2.0
                        final int waitTime = randomIntBetween(0, 50);
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
        final int numberOfListeners = scaledRandomIntBetween(1, 12);  
import org.junit.After;
                    } else {
            }), OpenSearchExecutors.newDirectExecutorService(), threadContext);
                    throw new AssertionError(e);  
                            listenersLatch.countDown();  
    public void stopExecutorService() throws InterruptedException {  
                        logger.info("completing the future after sleeping {}ms", waitTime);
    public void testListenableFutureNotifiesListenersOnException() {
        }
}
 *
 * The OpenSearch Contributors require contributions made to  
        }  
                            logger.error(new ParameterizedMessage("listener {} caught unexpected exception", threadNum), e);
/*  
import java.util.concurrent.CountDownLatch;
            thread.start();  
        executorService = OpenSearchExecutors.newFixed(
import java.util.concurrent.BrokenBarrierException;
        }
                    if (threadNum == completingThread) {
        final Exception exception = new RuntimeException();  
import java.util.concurrent.atomic.AtomicInteger;
                        logger.info("future received response");  
                            assertEquals("", s);
        for (int i = 0; i < numberOfThreads; i++) {
        final AtomicInteger numExceptions = new AtomicInteger(0);  
    @After
                        Thread.sleep(waitTime);  
                            numExceptions.incrementAndGet();
 * GitHub history for details.
                    barrier.await();
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < numberOfListeners; i++) {
 * You may obtain a copy of the License at  
    }  
 * Unless required by applicable law or agreed to in writing,
 */  
    }  
                            listenersLatch.countDown();
                        future.onResponse("");
        assertEquals(numberOfListeners, notifications.get());  
        listenersLatch.await();
        final ListenableFuture<String> future = new ListenableFuture<>();
import org.apache.logging.log4j.message.ParameterizedMessage;
import java.util.concurrent.CyclicBarrier;  
import org.opensearch.core.action.ActionListener;  
 *
        AtomicInteger notifications = new AtomicInteger(0);
/*
 * the Apache License, Version 2.0 (the "License"); you may
                            logger.info("listener {} received value {}", threadNum, s);
    private ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
            });
        ListenableFuture<String> future = new ListenableFuture<>();
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.is;
        assertTrue(future.isDone());
        barrier.await();
            future.addListener(
        future.onFailure(exception);
                        }, e -> {  
                notifications.incrementAndGet();
            "testConcurrentListenerRegistrationAndCompletion",  
                    barrier.await();
 * not use this file except in compliance with the License.
                        // we need to do more than just call onResponse as this often results in synchronous  
        for (int i = 0; i < numberOfListeners; i++) {
 * software distributed under the License is distributed on an
                            assertThat(threadContext.getTransient("key"), is(threadNum));  
            OpenSearchExecutors.daemonThreadFactory("listener"),  
                threadContext.putTransient("key", threadNum);
                assertEquals(exception, e);  
 * specific language governing permissions and limitations
            numberOfThreads,
                            numResponses.incrementAndGet();
                }
        barrier.await();  
import java.util.concurrent.ExecutorService;
            terminate(executorService);
                threadContext
        final int numberOfThreads = scaledRandomIntBetween(2, 32);
import org.opensearch.test.OpenSearchTestCase;
        final int numberOfListeners = scaledRandomIntBetween(1, 12);
 * this work for additional information regarding copyright
