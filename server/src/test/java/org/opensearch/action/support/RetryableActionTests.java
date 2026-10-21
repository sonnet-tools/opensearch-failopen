        assertEquals(1, executedCount.get());
    public void testRetryableActionNoRetries() {
        }
            @Override
                executedCount.getAndIncrement();
            taskQueue.getThreadPool(),
        long previousDeferredTime = 0;
        Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build();
                    if (randomBoolean()) {
                        listener.onFailure(new OpenSearchRejectedExecutionException());
                } else {
            TimeValue.timeValueMillis(10),
        expectThrows(OpenSearchException.class, future::actionGet);
            logger,
            }
        retryableAction.run();
        assertTrue(future.actionGet());
        expectThrows(OpenSearchRejectedExecutionException.class, future::actionGet);
        assertTrue(taskQueue.hasDeferredTasks());
        final AtomicInteger executedCount = new AtomicInteger();
        final AtomicInteger retryCount = new AtomicInteger();
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            }
        assertTrue(future.actionGet());
    }
        taskQueue.runAllRunnableTasks();
        final AtomicInteger retryCount = new AtomicInteger();
                if (remainingFailedCount.getAndDecrement() == 0) {
    }
    public void testRetryableActionTimeout() {
            future
    public void testRetryableActionCancelled() {
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
 * ownership. Elasticsearch licenses this file to you under
            TimeValue.timeValueMillis(10),
                listener.onResponse(true);
            logger,
        taskQueue.runAllRunnableTasks();
        taskQueue = new DeterministicTaskQueue(settings, random());
                    }
import org.opensearch.OpenSearchException;
 * The OpenSearch Contributors require contributions made to
                throw new IllegalStateException();
                return true;
        };
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
            public boolean shouldRetry(Exception e) {
            future
        long previousDeferredTime = 0;
 * Unless required by applicable law or agreed to in writing,
            }
            }
    @Before
        retryableAction.run();
            logger,
        assertEquals(1, executedCount.get());
        expectThrows(IllegalStateException.class, future::actionGet);
                return e instanceof OpenSearchRejectedExecutionException;
 * KIND, either express or implied.  See the License for the
                        throw new OpenSearchRejectedExecutionException();
            @Override
                return e instanceof OpenSearchRejectedExecutionException;
            @Override
    public void testFailedBecauseNotRetryable() {
 */
        final AtomicInteger executedCount = new AtomicInteger();
        retryableAction.run();
 * license agreements. See the NOTICE file distributed with
            public boolean shouldRetry(Exception e) {
                    throw new OpenSearchRejectedExecutionException();
            previousDeferredTime = taskQueue.getLatestDeferredExecutionTime();
 * the Apache License, Version 2.0 (the "License"); you may
            public void tryAction(ActionListener<Boolean> listener) {
    }
            TimeValue.timeValueSeconds(1),
        ) {
            final long millisBound = 10 << i;
                    } else {
            taskQueue.getThreadPool(),
import java.util.concurrent.atomic.AtomicInteger;
            }
        taskQueue.runAllRunnableTasks();
            TimeValue.timeValueSeconds(30),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            public void tryAction(ActionListener<Boolean> listener) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(
        retryableAction.cancel(new OpenSearchException("Cancelled"));
            @Override
                if (randomBoolean()) {
import org.opensearch.common.unit.TimeValue;
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(
            }
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
            TimeValue.timeValueSeconds(0),
                retryCount.getAndIncrement();
            logger,
            future
            future
        taskQueue.runAllRunnableTasks();
            public void tryAction(ActionListener<Boolean> listener) {
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            @Override
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
            TimeValue.timeValueMillis(10),
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(
            }
            public boolean shouldRetry(Exception e) {
            taskQueue.advanceTime();
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
        ) {
                executedCount.getAndIncrement();
            logger,
            }
                    listener.onFailure(new OpenSearchRejectedExecutionException());
            future
                    listener.onResponse(true);
import org.opensearch.core.action.ActionListener;
        };
            public boolean shouldRetry(Exception e) {
                return e instanceof OpenSearchRejectedExecutionException;
 * software distributed under the License is distributed on an
        taskQueue.advanceTime();
    }
            }
                }
        }
        taskQueue.runAllRunnableTasks();
/*
 *
            TimeValue.timeValueMillis(10),
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(
            @Override
            assertTrue(taskQueue.hasDeferredTasks());
        retryableAction.run();
/*
            }
package org.opensearch.action.support;
 * You may obtain a copy of the License at
    public void testTimeoutOfZeroMeansNoRetry() {
            }
        assertEquals(1, executedCount.get());
}
    }
        };
        taskQueue.runAllRunnableTasks();
            @Override
        taskQueue.runAllRunnableTasks();
        ) {
            @Override
            previousDeferredTime = deferredExecutionTime;
                } else {
                return e instanceof OpenSearchRejectedExecutionException;
 * GitHub history for details.
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(
    public void setUp() throws Exception {
                executedCount.getAndIncrement();
            TimeValue.timeValueMillis(10),
                }
            taskQueue.advanceTime();
 * compatible open source license.
            @Override
    }
        };
 * Licensed to Elasticsearch under one or more contributor
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            public void tryAction(ActionListener<Boolean> listener) {
            }
            TimeValue.timeValueSeconds(30),
 * Modifications Copyright OpenSearch Contributors. See
                if (executedCount.incrementAndGet() == 1) {
        for (int i = 0; i < expectedRetryCount; ++i) {
        retryableAction.run();
            public void tryAction(ActionListener<Boolean> listener) {
                } else {
        assertEquals(expectedRetryCount, retryCount.get());
        ) {
        };
    public void testRetryableActionWillRetry() {
        assertFalse(taskQueue.hasDeferredTasks());
        // A second run will not occur because it is cancelled
 * this file be licensed under the Apache-2.0 license or a
 *
            logger,
            @Override
 * under the License.
                throw new OpenSearchRejectedExecutionException();
    }
            TimeValue.timeValueSeconds(30),
 *
        ) {
                    listener.onResponse(true);
                    throw new OpenSearchRejectedExecutionException();
        };
        ) {
            assertThat(deferredExecutionTime, lessThanOrEqualTo(millisBound + previousDeferredTime));
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
            TimeValue.timeValueSeconds(30),
            future
                retryCount.getAndIncrement();
            taskQueue.getThreadPool(),
        final RetryableAction<Boolean> retryableAction = new RetryableAction<Boolean>(
            public boolean shouldRetry(Exception e) {
                }
    private DeterministicTaskQueue taskQueue;
            taskQueue.getThreadPool(),
                return e instanceof OpenSearchRejectedExecutionException;
 * specific language governing permissions and limitations
/*
        final PlainActionFuture<Boolean> future = PlainActionFuture.newFuture();
 */
        final AtomicInteger executedCount = new AtomicInteger();
        final AtomicInteger executedCount = new AtomicInteger();
        while (previousDeferredTime < 1000) {
 */
            @Override
        retryableAction.run();
            taskQueue.getThreadPool(),
            taskQueue.runAllRunnableTasks();
            public boolean shouldRetry(Exception e) {
import org.opensearch.test.OpenSearchTestCase;
            assertTrue(taskQueue.hasDeferredTasks());
            TimeValue.timeValueMillis(10),
            taskQueue.getThreadPool(),
            public void tryAction(ActionListener<Boolean> listener) {
        assertFalse(taskQueue.hasRunnableTasks());
import org.junit.Before;
        int expectedRetryCount = randomIntBetween(1, 8);
        final AtomicInteger remainingFailedCount = new AtomicInteger(expectedRetryCount);
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
            taskQueue.runAllRunnableTasks();
            @Override
            final long deferredExecutionTime = taskQueue.getLatestDeferredExecutionTime();
        assertEquals(1, executedCount.get());
public class RetryableActionTests extends OpenSearchTestCase {
        super.setUp();
        expectThrows(OpenSearchRejectedExecutionException.class, future::actionGet);
 * not use this file except in compliance with the License.
