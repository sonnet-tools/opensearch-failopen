    public void testRetryableActionNoRetries() {
        assertEquals(1, executedCount.get());  
        };
            }
        taskQueue.runAllRunnableTasks();
        ) {  
        taskQueue.runAllRunnableTasks();
            taskQueue.getThreadPool(),
            TimeValue.timeValueSeconds(30),
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
            TimeValue.timeValueSeconds(1),  
 * not use this file except in compliance with the License.
                    listener.onResponse(true);
            public void tryAction(ActionListener<Boolean> listener) {
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(
        retryableAction.run();
            logger,
        Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build();
                executedCount.getAndIncrement();
                return e instanceof OpenSearchRejectedExecutionException;
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(  
            @Override
            future
        }  
import org.opensearch.common.unit.TimeValue;
        retryableAction.run();  
        };  
            public boolean shouldRetry(Exception e) {  
            TimeValue.timeValueSeconds(30),
            TimeValue.timeValueMillis(10),
import org.junit.Before;
    public void testTimeoutOfZeroMeansNoRetry() {
        expectThrows(OpenSearchException.class, future::actionGet);
        assertTrue(future.actionGet());
        long previousDeferredTime = 0;
                        throw new OpenSearchRejectedExecutionException();
                    throw new OpenSearchRejectedExecutionException();  
    public void setUp() throws Exception {
            previousDeferredTime = deferredExecutionTime;
        retryableAction.run();  
            logger,
            assertThat(deferredExecutionTime, lessThanOrEqualTo(millisBound + previousDeferredTime));
            }
        ) {
            }  
        long previousDeferredTime = 0;  
/*  
            @Override  
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
 * specific language governing permissions and limitations
            taskQueue.advanceTime();
        ) {
    @Before
        assertTrue(taskQueue.hasDeferredTasks());  
            future
import static org.hamcrest.Matchers.lessThanOrEqualTo;
 * ownership. Elasticsearch licenses this file to you under  
    }
                return e instanceof OpenSearchRejectedExecutionException;
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
            public boolean shouldRetry(Exception e) {
            @Override
        assertFalse(taskQueue.hasRunnableTasks());  
        };
            }
            public void tryAction(ActionListener<Boolean> listener) {  
            }
 * the Apache License, Version 2.0 (the "License"); you may
/*
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
            }
            public boolean shouldRetry(Exception e) {
 */
 */  
 * GitHub history for details.
        assertEquals(expectedRetryCount, retryCount.get());
 * Licensed to Elasticsearch under one or more contributor  
            logger,  
        super.setUp();  
                if (executedCount.incrementAndGet() == 1) {
            public void tryAction(ActionListener<Boolean> listener) {
        retryableAction.run();  
            @Override
        expectThrows(IllegalStateException.class, future::actionGet);  
 *
                }
 * You may obtain a copy of the License at  
            taskQueue.advanceTime();  
}
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(  
    private DeterministicTaskQueue taskQueue;
            @Override  
        while (previousDeferredTime < 1000) {
                if (randomBoolean()) {  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.OpenSearchException;
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
                return e instanceof OpenSearchRejectedExecutionException;  
        retryableAction.cancel(new OpenSearchException("Cancelled"));  
        assertTrue(future.actionGet());
            @Override
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
 *  
                } else {  
            logger,
                return true;  
        taskQueue.advanceTime();
            TimeValue.timeValueMillis(10),  
 *
            logger,  
            TimeValue.timeValueMillis(10),
            future
            TimeValue.timeValueSeconds(0),  
 * The OpenSearch Contributors require contributions made to  
                }
public class RetryableActionTests extends OpenSearchTestCase {  
            final long deferredExecutionTime = taskQueue.getLatestDeferredExecutionTime();
import java.util.concurrent.atomic.AtomicInteger;
            taskQueue.getThreadPool(),
 * license agreements. See the NOTICE file distributed with
                    throw new OpenSearchRejectedExecutionException();
            TimeValue.timeValueMillis(10),
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
        retryableAction.run();
        assertEquals(1, executedCount.get());
            logger,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        };
    }  
        final AtomicInteger retryCount = new AtomicInteger();  
            TimeValue.timeValueSeconds(30),
import org.opensearch.common.settings.Settings;  
            future  
    public void testRetryableActionWillRetry() {
            public boolean shouldRetry(Exception e) {
            future
                retryCount.getAndIncrement();  
import org.opensearch.core.action.ActionListener;
                } else {  
        expectThrows(OpenSearchRejectedExecutionException.class, future::actionGet);
        final AtomicInteger retryCount = new AtomicInteger();
            public void tryAction(ActionListener<Boolean> listener) {
        taskQueue.runAllRunnableTasks();
 * compatible open source license.
                throw new OpenSearchRejectedExecutionException();
        }
 * software distributed under the License is distributed on an
 */  
            TimeValue.timeValueMillis(10),  
    public void testRetryableActionCancelled() {  
        taskQueue = new DeterministicTaskQueue(settings, random());
        final AtomicInteger executedCount = new AtomicInteger();  
            @Override
        ) {
            TimeValue.timeValueSeconds(30),  
        };  
        assertEquals(1, executedCount.get());  
                }  
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(
 * this work for additional information regarding copyright
            taskQueue.getThreadPool(),
            final long millisBound = 10 << i;  
                    listener.onFailure(new OpenSearchRejectedExecutionException());
        ) {  
        final AtomicInteger executedCount = new AtomicInteger();
            taskQueue.getThreadPool(),
                retryCount.getAndIncrement();
            }
        };
            }  
            }
import static org.opensearch.node.Node.NODE_NAME_SETTING;  
/*  
                    }
        taskQueue.runAllRunnableTasks();
            previousDeferredTime = taskQueue.getLatestDeferredExecutionTime();  
            assertTrue(taskQueue.hasDeferredTasks());
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
        ) {
                executedCount.getAndIncrement();  
                    } else {  
    }
        assertEquals(1, executedCount.get());
 * under the License.  
        retryableAction.run();
                return e instanceof OpenSearchRejectedExecutionException;  
            }
        for (int i = 0; i < expectedRetryCount; ++i) {  
        int expectedRetryCount = randomIntBetween(1, 8);
        // A second run will not occur because it is cancelled  
        taskQueue.runAllRunnableTasks();
        expectThrows(OpenSearchRejectedExecutionException.class, future::actionGet);
            public void tryAction(ActionListener<Boolean> listener) {
        final AtomicInteger remainingFailedCount = new AtomicInteger(expectedRetryCount);  
            future
        final AtomicInteger executedCount = new AtomicInteger();
            public boolean shouldRetry(Exception e) {
    public void testFailedBecauseNotRetryable() {
            }
            @Override
            taskQueue.getThreadPool(),
            taskQueue.getThreadPool(),  
                    listener.onResponse(true);
    }  
            public boolean shouldRetry(Exception e) {
                return e instanceof OpenSearchRejectedExecutionException;
            public void tryAction(ActionListener<Boolean> listener) {  
                if (remainingFailedCount.getAndDecrement() == 0) {
            taskQueue.runAllRunnableTasks();
 * Modifications Copyright OpenSearch Contributors. See
            taskQueue.runAllRunnableTasks();
        final AtomicInteger executedCount = new AtomicInteger();  
                        listener.onFailure(new OpenSearchRejectedExecutionException());
        taskQueue.runAllRunnableTasks();  
 * SPDX-License-Identifier: Apache-2.0
    }
            TimeValue.timeValueMillis(10),
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.support;
        taskQueue.runAllRunnableTasks();
            @Override
            @Override
            }
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();  
    }  
                throw new IllegalStateException();  
                    if (randomBoolean()) {
    }  
            @Override
    public void testRetryableActionTimeout() {
                } else {
        assertFalse(taskQueue.hasDeferredTasks());
                listener.onResponse(true);
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(
            @Override  
 * KIND, either express or implied.  See the License for the
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(
            assertTrue(taskQueue.hasDeferredTasks());
                executedCount.getAndIncrement();  
