            globalCheckpointListeners.add(0, maybeMultipleInvocationProtectingListener((g, e) -> {
        doAnswer(invocationOnMock -> {
import java.util.concurrent.CountDownLatch;
        }
        assertThat(notified.get(), equalTo(numberOfListeners));
            } else {
                    @Override
                assertThat(((IndexShardClosedException) exceptions[i]).getShardId(), equalTo(shardId));
            maybeMultipleInvocationProtectingListener((g, e) -> {
            );
        }
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
                assertThat(g, equalTo(UNASSIGNED_SEQ_NO));
                reset(mockLogger);
        final GlobalCheckpointListeners.GlobalCheckpointListener globalCheckpointListener = maybeMultipleInvocationProtectingListener(
    public void testNotificationOnClosedUsesExecutor() throws IOException {
        // now shutdown
            command.run();
            } else {
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, mockLogger);
        );
import static org.mockito.Mockito.times;
    }
        globalCheckpointListeners.close();
        // wait for all the listeners to be notified
        final List<AtomicBoolean> invocations = new CopyOnWriteArrayList<>();
            globalCheckpointListeners.add(0, maybeMultipleInvocationProtectingListener((g, e) -> {
            for (int i = 0; i < numberOfIterations; i++) {
            final boolean failure = randomBoolean();
            }
        final Thread listenersThread = new Thread(() -> {
                null
                }
    }
                    notifiedListeners.put(this, g);
            (g, e) -> {
                message.getValue().getFormat(),
import org.apache.logging.log4j.message.ParameterizedMessage;
                        }
            final int index = i;
        final CountDownLatch latch = new CountDownLatch(1);
}
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.CopyOnWriteArrayList;
        for (int i = 0; i < numberOfListeners; i++) {
import static org.mockito.Mockito.doAnswer;
            final ArgumentCaptor<RuntimeException> t = ArgumentCaptor.forClass(RuntimeException.class);
        for (int i = 0; i < numberOfListeners; i++) {
                        @Override
        globalCheckpointListeners.close();
                    public Executor executor() {
            }
        1,
    }
        final long globalCheckpoint = randomLongBetween(0, Long.MAX_VALUE);
    public void testAddAfterClose() throws InterruptedException, IOException {
                    }
        }
                }
                    assertThat(((IndexShardClosedException) e).getShardId(), equalTo(shardId));
 *
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                    globalCheckpoints[index] = Long.MIN_VALUE;
        assertTrue(notified.get());
        globalCheckpointListeners.add(
            command.run();
        }
        OpenSearchExecutors.daemonThreadFactory(Settings.EMPTY, "scheduler")
    );
            final boolean failure = randomBoolean();
            globalCheckpointListeners.add(0, maybeMultipleInvocationProtectingListener((g, e) -> exceptions[index] = e), null);
                assertThat(g, equalTo(NO_OPS_PERFORMED));
        assertThat(count.get(), equalTo(1));
            failures[index] = failure;
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
import java.util.concurrent.atomic.AtomicLong;
                verify(mockLogger).warn(message.capture(), t.capture());
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
 * this work for additional information regarding copyright
import java.util.concurrent.TimeoutException;
        final Logger mockLogger = mock(Logger.class);
        int failureCount = 0;
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, mockLogger);
            globalCheckpointListeners.add(
                @Override
        notifiedListeners.clear();
                                throw new IllegalStateException("listener invoked twice");
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);
                }
                    globalCheckpoint.get(),
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
                    globalCheckpoints[index] = g;
import static org.hamcrest.Matchers.equalTo;
                }
                    if (invoked.compareAndSet(false, true) == false) {
    }
 * GitHub history for details.
                assertThat(notifiedListeners.get(listener.getKey()), equalTo(globalCheckpoint));
        assertThat(t.getValue(), instanceOf(RuntimeException.class));
                    assertThat(e, instanceOf(TimeoutException.class));
                randomLongBetween(0, globalCheckpoint),
        final ArgumentCaptor<String> message = ArgumentCaptor.forClass(String.class);
        final Map<GlobalCheckpointListeners.GlobalCheckpointListener, Long> listeners = new HashMap<>();
    }
                assertThat(notifiedListeners.get(listener.getKey()), equalTo(UNASSIGNED_SEQ_NO));
            count.incrementAndGet();
            }
            if (failures[i]) {
        final int numberOfListeners = randomIntBetween(0, 16);
        final long[] globalCheckpoints = new long[numberOfListeners];
                    notified.incrementAndGet();
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
import java.io.UncheckedIOException;
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint.get());
    }
        }
        }
                assertThat(exceptions[i], instanceOf(IndexShardClosedException.class));
        assertTrue(invoked.get());
            awaitQuietly(barrier);
        final AtomicBoolean notified = new AtomicBoolean();
 * compatible open source license.
        );
            );
                    notified.incrementAndGet();
    public void testFailingListenerAfterTimeout() throws InterruptedException {
                assertThat(e, hasToString(containsString(timeout.getStringRep())));
        }
                invoked.set(true);
                }
                public void accept(final long g, final Exception e) {
                    return executor;
    }
                    throw new RuntimeException("failure");
import java.util.concurrent.atomic.AtomicBoolean;
                        public void accept(final long g, final Exception e) {
    }
            };
                }
                }
                }
    }
 *
                    latch.countDown();
    public void testClose() throws IOException {
                    equalTo("error notifying global checkpoint listener of updated global checkpoint [{}]")
import java.util.List;
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
import java.util.concurrent.Executors;
            // synchronize ending with the listener thread and the main test thread
            assertThat(globalCheckpoints[i], equalTo(globalCheckpoint));
                    public void accept(final long g, final Exception e) {
        latch.await();
            final ArgumentCaptor<String> message = ArgumentCaptor.forClass(String.class);
                equalTo("error notifying global checkpoint listener of updated global checkpoint [{}]")
        final Executor executor = command -> {
                    assertThat(e, instanceOf(IndexShardClosedException.class));
        final CountDownLatch latch = new CountDownLatch(1);
                // these listeners will have been notified by the second global checkpoint update, and all the other listeners should not be
            }
 * You may obtain a copy of the License at
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
import static org.mockito.Mockito.any;
            assertThat(message.getValue().getParameters()[0], equalTo(globalCheckpoint));
                @Override
        final TimeValue timeout = TimeValue.timeValueNanos(Long.MAX_VALUE);
                maybeMultipleInvocationProtectingListener(new TestGlobalCheckpointListener() {
            return new GlobalCheckpointListeners.GlobalCheckpointListener() {
        final int numberOfListeners = randomIntBetween(0, 16);
        // closing should also not notify the listeners
                            if (invocation.compareAndSet(false, true) == false) {
    }
 */
            if (listener.getValue() > nextGlobalCheckpoint) {
                assertThat(t.getValue().getMessage(), equalTo("failure"));
        final int numberOfListeners = randomIntBetween(0, 16);
                assertThat(message.getValue().getParameters()[0], equalTo(globalCheckpoint));
        assertNotNull(t.getValue());
            if (failures[i]) {
    public void testListenersReadyToBeNotifiedUsesExecutor() {
import java.util.concurrent.atomic.AtomicInteger;
        globalCheckpointListeners.add(NO_OPS_PERFORMED, maybeMultipleInvocationProtectingListener(new TestGlobalCheckpointListener() {
            assertNotNull(t.getValue());
import static org.hamcrest.Matchers.instanceOf;
                failureCount++;
                assertNull(exceptions[i]);
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
        try {
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
        final Logger mockLogger = mock(Logger.class);
        final ScheduledFuture<?> future = globalCheckpointListeners.getTimeoutFuture(globalCheckpointListener);
            listeners.put(listener, waitingGlobalCheckpoint);
                @Override
 * ownership. Elasticsearch licenses this file to you under
        }
    public void testConcurrency() throws Exception {
                        }
            throw new AssertionError(e);
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, mockLogger);
                assertNull(e);
        // ensure the listener notification occurred on the executor
        final Executor executor = command -> {
        updatingThread.start();
        for (int i = 0; i < numberOfListeners; i++) {
        final long[] globalCheckpoints = new long[numberOfListeners];
            }
                    globalCheckpointListener.accept(g, e);
        final Logger mockLogger = mock(Logger.class);
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
        globalCheckpointListeners.add(NO_OPS_PERFORMED, maybeMultipleInvocationProtectingListener((g, e) -> {
        final AtomicBoolean invoked = new AtomicBoolean();
                    try {
    public void testTimeoutCancelledAfterListenerNotified() {
        final boolean[] failures = new boolean[numberOfListeners];
 * Unless required by applicable law or agreed to in writing,
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
                null
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED + 1, Long.MAX_VALUE);
                failureCount++;
        } else {
            return Runnable::run;
                }
    }
                try {
        }
                assertNotNull(t.getValue());
        for (int i = 0; i < numberOfListeners; i++) {
        // test the listeners are not invoked twice
            }
                @Override
                assertThat(globalCheckpoints[i], equalTo(globalCheckpoint));
                }
                );
            } else {
import java.util.concurrent.ScheduledThreadPoolExecutor;
        if (failureCount > 0) {
                null
                    randomBoolean() ? null : TimeValue.timeValueNanos(randomLongBetween(1, TimeUnit.MICROSECONDS.toNanos(1)))
            final boolean failure = randomBoolean();
        }
        // test the listeners are not invoked twice
            } else {
        for (int i = 0; i < numberOfListeners; i++) {
        for (final Map.Entry<GlobalCheckpointListeners.GlobalCheckpointListener, Long> listener : listeners.entrySet()) {
        updatingThread.join();
                invocations.add(invocation);
                final ArgumentCaptor<ParameterizedMessage> message = ArgumentCaptor.forClass(ParameterizedMessage.class);
        }
            }), null);
        final CountDownLatch latch = new CountDownLatch(1);
                } finally {
                    assertThat(g, equalTo(UNASSIGNED_SEQ_NO));
        final ArgumentCaptor<RuntimeException> t = ArgumentCaptor.forClass(RuntimeException.class);
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
                    }
        assertThat(notified.get(), equalTo(numberOfListeners));
                    return executor;
        // we are going to synchronize the actions of three threads: the updating thread, the listener thread, and the main test thread
        // one last update to ensure all listeners are notified
                    return globalCheckpointListener.executor();
                // these listeners should have been notified that we closed, and all the other listeners should not be
        final Executor executor = command -> {
        globalCheckpointListeners.close();
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE);
            final ArgumentCaptor<ParameterizedMessage> message = ArgumentCaptor.forClass(ParameterizedMessage.class);
            globalCheckpointListeners.add(
                        assertThat(g, equalTo(globalCheckpoint));
        scheduler.shutdown();
            latch.countDown();
                );
/*
            }), null);
                assertThat(message.getValue(), equalTo("global checkpoint listener timed out"));
            throw new RuntimeException("failure");
        final Thread updatingThread = new Thread(() -> {
                } else {
        }
        final ExecutorService executor = Executors.newFixedThreadPool(randomIntBetween(1, 8));
        for (int i = 0; i < numberOfListeners; i++) {
                    maybeMultipleInvocationProtectingListener(new TestGlobalCheckpointListener() {
            // the listener should be notified immediately
        // synchronize starting with the updating thread and the listener thread
                        throw new RuntimeException("failure");
        for (int i = 0; i < numberOfListeners; i++) {
        }
        final AtomicInteger count = new AtomicInteger();
import java.io.IOException;
        final TestGlobalCheckpointListener globalCheckpointListener
    }
                }),
import java.util.HashMap;
            final long waitingGlobalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE);
                assertNull(notifiedListeners.get(listener.getKey()));
    interface TestGlobalCheckpointListener extends GlobalCheckpointListeners.GlobalCheckpointListener {
            command.run();
    public void testTimeoutNotificationUsesExecutor() throws InterruptedException {
        }
                public void accept(final long g, final Exception e) {
                    notified.set(true);
        final AtomicInteger count = new AtomicInteger();
        final Logger mockLogger = mock(Logger.class);
            exceptions[i] = null;
            globalCheckpointListeners.add(0, maybeMultipleInvocationProtectingListener(new TestGlobalCheckpointListener() {
            globalCheckpointListeners.add(waitingGlobalCheckpoint, maybeMultipleInvocationProtectingListener(listener), null);
            assertThat(exceptions[i], instanceOf(IndexShardClosedException.class));
            if (failure) {
import java.util.concurrent.Executor;
        latch.await();
        executor.shutdown();
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE);
        });
        globalCheckpointListeners.close();
        final AtomicBoolean closed = new AtomicBoolean();
        final CyclicBarrier barrier = new CyclicBarrier(3);
        if (closed.get() == false) {
    @After
                public void accept(final long g, final Exception e) {
        for (int i = 0; i < numberOfListeners; i++) {
            assertThat(message.getValue(), equalTo("error notifying global checkpoint listener of closed shard"));
 * not use this file except in compliance with the License.
        });
                    exceptions[index] = e;
        }
import java.util.concurrent.ExecutorService;
        verify(mockLogger).warn(message.capture(), t.capture());
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
                final AtomicBoolean invocation = new AtomicBoolean();
            final int index = i;
        globalCheckpointListeners.globalCheckpointUpdated(nextGlobalCheckpoint);
        }), timeout);
    public void testTimeout() throws InterruptedException {
                // only listeners waiting on a lower global checkpoint will have been notified
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);
import java.util.concurrent.TimeUnit;
        }), timeout);
            assertThat(message.getValue().getParameters().length, equalTo(1));
                    if (failure) {
        latch.await();
            awaitQuietly(barrier);
            count.incrementAndGet();
                assertThat(t.getValue(), hasToString(containsString(timeout.getStringRep())));
                public void accept(final long g, final Exception e) {
    }
import org.opensearch.core.Assertions;
            final AtomicBoolean invoked = new AtomicBoolean();
public class GlobalCheckpointListenersTests extends OpenSearchTestCase {
 * specific language governing permissions and limitations
        for (int i = 0; i < numberOfListeners; i++) {
        final AtomicBoolean notified = new AtomicBoolean();
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);
import org.mockito.ArgumentCaptor;
        final int numberOfListeners = randomIntBetween(0, 16);
        barrier.await();
import java.util.concurrent.BrokenBarrierException;
                if (i > numberOfIterations / 2 && rarely() && closed.get() == false) {
        if (Assertions.ENABLED) {
                        globalCheckpoints[index] = Long.MIN_VALUE;
                if (failure) {
            failures[index] = failure;
        final TimeValue timeout = TimeValue.timeValueMillis(randomIntBetween(1, 50));
    public void testFailingListenerOnClose() throws IOException {
        // synchronize ending with the updating thread and the listener thread
    @FunctionalInterface
            public void accept(final long g, final Exception e) {
                    } else {
            assertNull(exceptions[i]);
            assertNotNull(message.getValue().getParameters());
        int failureCount = 0;
        globalCheckpointListeners.add(NO_OPS_PERFORMED, globalCheckpointListener, timeout);
                    assertNotNull(e);
        assertTrue(notified.get());
        assertTrue(executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS));
                    assertThat(g, equalTo(globalCheckpoint));
                assertNotNull(exceptions[i]);
            };
        globalCheckpointListeners.globalCheckpointUpdated(nextGlobalCheckpoint);
            );
                    message.getValue().getFormat(),
import org.opensearch.core.index.shard.ShardId;
                }
 *
import static org.hamcrest.Matchers.containsString;
        }
            globalCheckpointListeners.add(
            } finally {
                if (failure) {
                if (rarely() && closed.get() == false) {
        final int numberOfListeners = randomIntBetween(0, 16);
        final int numberOfIterations = randomIntBetween(1, 4096);
        for (final Map.Entry<GlobalCheckpointListeners.GlobalCheckpointListener, Long> listener : listeners.entrySet()) {
        final Map<GlobalCheckpointListeners.GlobalCheckpointListener, Long> notifiedListeners = new HashMap<>();
        final AtomicLong globalCheckpoint = new AtomicLong(NO_OPS_PERFORMED);
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
        listenersThread.join();
        final long nextGlobalCheckpoint = randomLongBetween(globalCheckpoint + 1, Long.MAX_VALUE);
                randomLongBetween(NO_OPS_PERFORMED, globalCheckpoint - 1),
            }
        final long globalCheckpoint = randomNonNegativeLong();
            count.incrementAndGet();
        }).when(mockLogger).warn(any(String.class), any(RuntimeException.class));
        assertThat(count.get(), equalTo(numberOfListeners));
                    }),
        }
            assertThat(((IndexShardClosedException) exceptions[i]).getShardId(), equalTo(shardId));
            return globalCheckpointListener;
                assertThat(globalCheckpoints[i], equalTo(globalCheckpoint));
                        assertNull(e);
                maybeMultipleInvocationProtectingListener((g, e) -> globalCheckpoints[index] = g),
import java.util.concurrent.ScheduledFuture;
        final long[] globalCheckpoints = new long[numberOfListeners];
        }
        for (int i = 0; i < numberOfListeners; i++) {
                notified.set(true);
    ) {
        final int numberOfListeners = randomIntBetween(0, 16);
 */
    }
    public void testListenersReadyToBeNotified() throws IOException {
                } else {
            }), null);
            }
            );
 * license agreements. See the NOTICE file distributed with
            verify(mockLogger, times(failureCount)).warn(message.capture(), t.capture());
        for (int i = 0; i < numberOfListeners; i++) {
 * Licensed to Elasticsearch under one or more contributor
        final TimeValue timeout = TimeValue.timeValueMillis(randomIntBetween(1, 50));
            }), null);
        }
        latch.await();
                randomLongBetween(0, globalCheckpoint),
        // test the listeners are not invoked twice
                }
import static org.mockito.Mockito.verify;
                assertNotNull(message.getValue().getParameters());
        final Executor executor = command -> {
                        throw new AssertionError("listener invoked twice");
                        notified.incrementAndGet();
            if (failures[i]) {
                assertThat(e, instanceOf(TimeoutException.class));
            // synchronize starting with the listener thread and the main test thread
        final long nextGlobalCheckpoint = randomLongBetween(1 + globalCheckpoint, Long.MAX_VALUE);
 * the Apache License, Version 2.0 (the "License"); you may
            }
                public Executor executor() {
        }
        }
        if (failureCount > 0) {
                }),
                    throw new RuntimeException("failure");
                public Executor executor() {
            assertThat(t.getValue().getMessage(), equalTo("failure"));
        for (final AtomicBoolean invocation : invocations) {
            } else {
                assertThat(globalCheckpoints[i], equalTo(Long.MIN_VALUE));
        }
            }),
                    }
    private void awaitQuietly(final CyclicBarrier barrier) {
            awaitQuietly(barrier);
import static org.mockito.Mockito.reset;
                        globalCheckpoints[index] = globalCheckpoint;
import java.util.Map;
            null
                    globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint.incrementAndGet());
                assertThat(
        default Executor executor() {
 */
                    closed.set(true);
                assertThat(globalCheckpoints[i], equalTo(Long.MIN_VALUE));
            } catch (Exception caught) {
        final CountDownLatch latch = new CountDownLatch(1);
            globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint.incrementAndGet());
        globalCheckpointListeners.close();
        final int numberOfListeners = randomIntBetween(0, 16);
                    } catch (final IOException e) {
                @Override
                        throw new UncheckedIOException(e);
        globalCheckpointListeners.add(NO_OPS_PERFORMED, maybeMultipleInvocationProtectingListener((g, e) -> {
        }
            assertBusy(() -> assertTrue(invocation.get()));
            } else {
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
    private final ScheduledThreadPoolExecutor scheduler = new Scheduler.SafeScheduledThreadPoolExecutor(
                    }
                fail(e.getMessage());
        globalCheckpointListeners.close();
        assertNotNull(future);
                    @Override
            assertThat(
        assertThat(message.getValue(), equalTo("error notifying global checkpoint listener of timeout"));
            final ArgumentCaptor<RuntimeException> t = ArgumentCaptor.forClass(RuntimeException.class);
import static org.hamcrest.Matchers.hasToString;
                final ArgumentCaptor<TimeoutException> t = ArgumentCaptor.forClass(TimeoutException.class);
            final int index = i;
            final int index = i;
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
        }
            barrier.await();
                @Override
        }
        final int numberOfListeners = randomIntBetween(0, 64);
import java.util.concurrent.CyclicBarrier;
            }
import org.opensearch.core.index.Index;
            if (failures[i]) {
package org.opensearch.index.shard;
        for (int i = 0; i < numberOfListeners; i++) {
            // synchronize starting with the updating thread and the main test thread
                latch.countDown();
                    assertThat(g, equalTo(UNASSIGNED_SEQ_NO));
        // closing should also not notify the listeners
 * under the License.
        }), timeout);
                return executor;
            @Override
import org.apache.logging.log4j.Logger;
                            }
        final AtomicInteger notified = new AtomicInteger();
    public void testGlobalCheckpointUpdated() throws IOException {
        for (int i = 0; i < numberOfListeners; i++) {
            assertNotNull(exceptions[i]);
        assertThat(count.get(), equalTo(numberOfListeners));
        final AtomicInteger count = new AtomicInteger();
            }
    public void shutdownScheduler() {
            count.incrementAndGet();
            }
            for (int i = 0; i < numberOfIterations; i++) {
 * SPDX-License-Identifier: Apache-2.0
                assertThat(notifiedListeners.get(listener.getKey()), equalTo(nextGlobalCheckpoint));
            randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE),
            final int index = i;
    private GlobalCheckpointListeners.GlobalCheckpointListener maybeMultipleInvocationProtectingListener(
                final ArgumentCaptor<RuntimeException> t = ArgumentCaptor.forClass(RuntimeException.class);
        }
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, mockLogger);
            assertNotNull(t.getValue());
/*
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, mockLogger);
            assertThat(t.getValue().getMessage(), equalTo("failure"));
        };
        };
        }
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE - 1);
                        globalCheckpointListeners.close();
        final Exception[] exceptions = new Exception[numberOfListeners];
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);
            if (listener.getValue() > globalCheckpoint && listener.getValue() <= nextGlobalCheckpoint) {
    }
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
        assertThat(notified.get(), equalTo(numberOfListeners));
 * software distributed under the License is distributed on an
            assertThat(globalCheckpoints[i], equalTo(globalCheckpoint));
        listenersThread.start();
                maybeMultipleInvocationProtectingListener((g, e) -> {
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
            }
import org.opensearch.common.settings.Settings;
        assertTrue(future.isCancelled());
import static org.mockito.Mockito.mock;
        };
        final AtomicInteger notified = new AtomicInteger();
            final TestGlobalCheckpointListener listener = new TestGlobalCheckpointListener() {
        }
            globalCheckpointListeners.add(NO_OPS_PERFORMED, maybeMultipleInvocationProtectingListener(new TestGlobalCheckpointListener() {
import org.opensearch.common.unit.TimeValue;
        for (int i = 0; i < numberOfListeners; i++) {
            try {
        final int numberOfListeners = randomIntBetween(0, 16);
            assertThat(globalCheckpoints[index], equalTo(globalCheckpoint));
                public Executor executor() {
 * this file be licensed under the Apache-2.0 license or a
                        public Executor executor() {
        globalCheckpointListeners.close();
import org.opensearch.threadpool.Scheduler;
        assertThat(count.get(), equalTo(numberOfListeners));
        final TimeValue timeout = TimeValue.timeValueMillis(randomIntBetween(1, 50));
            awaitQuietly(barrier);
        assertThat(t.getValue().getMessage(), equalTo("failure"));
                assertNull(notifiedListeners.get(listener.getKey()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final AtomicInteger notified = new AtomicInteger();
            if (listener.getValue() <= globalCheckpoint) {
        notifiedListeners.clear();
            return null;
                verify(mockLogger).trace(message.capture(), t.capture());
        final Logger mockLogger = mock(Logger.class);
        final Exception[] exceptions = new Exception[numberOfListeners];
        for (int i = 0; i < numberOfListeners; i++) {
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
import org.opensearch.test.OpenSearchTestCase;
                    }
        assertThat(globalCheckpointListeners.pendingListeners(), equalTo(0));
                    assertNull(e);
        barrier.await();
        for (int i = 0; i < numberOfListeners; i++) {
        };
            // synchronize ending with the updating thread and the main test thread
            // the listener should be notified immediately
import org.junit.After;
    }
        for (int i = 0; i < numberOfListeners; i++) {
                assertNull(notifiedListeners.get(listener.getKey()));
    private final ShardId shardId = new ShardId(new Index("index", "uuid"), 0);
                        return executor;
                            return executor;
    }
    public void testNotificationUsesExecutor() {
    public void testFailingListenerReadyToBeNotified() {
                latch.countDown();
 * Modifications Copyright OpenSearch Contributors. See
        final boolean[] failures = new boolean[numberOfListeners];
                @Override
            command.run();
                globalCheckpointListeners.add(
    public void testFailingListenerOnUpdate() {
                final ArgumentCaptor<String> message = ArgumentCaptor.forClass(String.class);
            @Override
                        @Override
            public Executor executor() {
    }
        } catch (final BrokenBarrierException | InterruptedException e) {
                assertThat(message.getValue().getParameters().length, equalTo(1));
    }
/*
 * The OpenSearch Contributors require contributions made to
        final AtomicInteger count = new AtomicInteger();
                // sometimes this will notify the listener immediately
            verify(mockLogger, times(failureCount)).warn(message.capture(), t.capture());
        for (int i = 0; i < numberOfListeners; i++) {
        for (final Map.Entry<GlobalCheckpointListeners.GlobalCheckpointListener, Long> listener : listeners.entrySet()) {
