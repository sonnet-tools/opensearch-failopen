        assertTrue(executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS));  
            if (failures[i]) {
        listenersThread.join();
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);  
                    @Override  
            }),
import static org.hamcrest.Matchers.equalTo;
                    try {
                    notified.incrementAndGet();
    );  
 * this file be licensed under the Apache-2.0 license or a
                }),
            assertThat(message.getValue(), equalTo("error notifying global checkpoint listener of closed shard"));
        for (int i = 0; i < numberOfListeners; i++) {
                    assertThat(e, instanceOf(IndexShardClosedException.class));
            awaitQuietly(barrier);
            assertThat(t.getValue().getMessage(), equalTo("failure"));
        final Thread listenersThread = new Thread(() -> {
            globalCheckpointListeners.add(0, maybeMultipleInvocationProtectingListener((g, e) -> {
            barrier.await();
        for (int i = 0; i < numberOfListeners; i++) {  
                assertThat(message.getValue().getParameters()[0], equalTo(globalCheckpoint));  
 * Modifications Copyright OpenSearch Contributors. See
                        globalCheckpoints[index] = globalCheckpoint;  
                    if (failure) {
        if (failureCount > 0) {
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED + 1, Long.MAX_VALUE);
                        @Override  
            assertThat(message.getValue().getParameters()[0], equalTo(globalCheckpoint));
                @Override
            for (int i = 0; i < numberOfIterations; i++) {
        final AtomicBoolean notified = new AtomicBoolean();
    interface TestGlobalCheckpointListener extends GlobalCheckpointListeners.GlobalCheckpointListener {  
                    globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint.incrementAndGet());
    private void awaitQuietly(final CyclicBarrier barrier) {  
        }  
        }), timeout);  
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
            final ArgumentCaptor<ParameterizedMessage> message = ArgumentCaptor.forClass(ParameterizedMessage.class);
        final TimeValue timeout = TimeValue.timeValueNanos(Long.MAX_VALUE);
        globalCheckpointListeners.close();  
                verify(mockLogger).trace(message.capture(), t.capture());
            // synchronize ending with the updating thread and the main test thread
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
            latch.countDown();  
                randomLongBetween(0, globalCheckpoint),  
                        notified.incrementAndGet();
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint.get());
            for (int i = 0; i < numberOfIterations; i++) {
        executor.shutdown();
        }
                if (rarely() && closed.get() == false) {
        final AtomicInteger count = new AtomicInteger();
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
        final Logger mockLogger = mock(Logger.class);  
                }
        assertThat(count.get(), equalTo(numberOfListeners));
    }
                } else {
                public void accept(final long g, final Exception e) {
 */  
import static org.hamcrest.Matchers.instanceOf;
                // sometimes this will notify the listener immediately
        assertThat(count.get(), equalTo(numberOfListeners));
        }
            exceptions[i] = null;  
                    throw new RuntimeException("failure");  
        // now shutdown
 *  
        for (final Map.Entry<GlobalCheckpointListeners.GlobalCheckpointListener, Long> listener : listeners.entrySet()) {
                public Executor executor() {
        final TimeValue timeout = TimeValue.timeValueMillis(randomIntBetween(1, 50));
            // the listener should be notified immediately
import java.util.concurrent.TimeUnit;  
            }
import java.util.concurrent.atomic.AtomicLong;
                    message.getValue().getFormat(),
            }
        }
                    if (invoked.compareAndSet(false, true) == false) {  
                    globalCheckpointListener.accept(g, e);  
                }
        }
            if (failures[i]) {  
        latch.await();
                }  
        final AtomicInteger count = new AtomicInteger();  
                final AtomicBoolean invocation = new AtomicBoolean();
import org.mockito.ArgumentCaptor;  
                }  
                    throw new RuntimeException("failure");
    public void testTimeoutCancelledAfterListenerNotified() {  
        }
    public void testConcurrency() throws Exception {
            globalCheckpointListeners.add(
    public void testFailingListenerReadyToBeNotified() {
            assertNotNull(exceptions[i]);
        assertNotNull(future);
        for (int i = 0; i < numberOfListeners; i++) {
                    }
import java.util.concurrent.CopyOnWriteArrayList;
        }
import java.util.concurrent.CyclicBarrier;  
            assertThat(globalCheckpoints[i], equalTo(globalCheckpoint));  
            final AtomicBoolean invoked = new AtomicBoolean();
    public void testTimeoutNotificationUsesExecutor() throws InterruptedException {  
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);  
            if (failure) {  
                    assertThat(g, equalTo(UNASSIGNED_SEQ_NO));  
                return executor;
                assertThat(((IndexShardClosedException) exceptions[i]).getShardId(), equalTo(shardId));
    }  
        latch.await();
            awaitQuietly(barrier);  
        }  
        final int numberOfListeners = randomIntBetween(0, 16);  
            return globalCheckpointListener;
                globalCheckpointListeners.add(
                    } catch (final IOException e) {  
        final List<AtomicBoolean> invocations = new CopyOnWriteArrayList<>();  
        // closing should also not notify the listeners  
            globalCheckpointListeners.add(0, maybeMultipleInvocationProtectingListener((g, e) -> exceptions[index] = e), null);
                failureCount++;
            assertNull(exceptions[i]);
                assertThat(globalCheckpoints[i], equalTo(Long.MIN_VALUE));
        assertThat(count.get(), equalTo(1));
        globalCheckpointListeners.close();  
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);
            assertThat(t.getValue().getMessage(), equalTo("failure"));
        final AtomicInteger count = new AtomicInteger();  
                    latch.countDown();  
                @Override
 * not use this file except in compliance with the License.
            assertThat(exceptions[i], instanceOf(IndexShardClosedException.class));  
import java.util.concurrent.Executors;  
                }  
                }  
                failureCount++;
        }  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    @FunctionalInterface
        );  
import org.opensearch.common.unit.TimeValue;
                @Override
        for (int i = 0; i < numberOfListeners; i++) {
import java.util.concurrent.TimeoutException;
                        throw new RuntimeException("failure");
                }
        for (int i = 0; i < numberOfListeners; i++) {
    }
            } else {  
        try {
            globalCheckpointListeners.add(0, maybeMultipleInvocationProtectingListener(new TestGlobalCheckpointListener() {
        }), timeout);
 * Licensed to Elasticsearch under one or more contributor  
                    assertNull(e);
                );  
import java.util.concurrent.BrokenBarrierException;  
        final TimeValue timeout = TimeValue.timeValueMillis(randomIntBetween(1, 50));
        final int numberOfListeners = randomIntBetween(0, 64);
import java.util.concurrent.atomic.AtomicInteger;  
        globalCheckpointListeners.globalCheckpointUpdated(nextGlobalCheckpoint);
        for (int i = 0; i < numberOfListeners; i++) {  
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, mockLogger);  
        }  
            public void accept(final long g, final Exception e) {  
import java.util.concurrent.atomic.AtomicBoolean;
        final ExecutorService executor = Executors.newFixedThreadPool(randomIntBetween(1, 8));
            count.incrementAndGet();
                randomLongBetween(NO_OPS_PERFORMED, globalCheckpoint - 1),  
        final AtomicInteger count = new AtomicInteger();  
        updatingThread.join();
        } else {
            );
import static org.mockito.Mockito.doAnswer;  
        final Thread updatingThread = new Thread(() -> {
            assertThat(((IndexShardClosedException) exceptions[i]).getShardId(), equalTo(shardId));
        }
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
            };  
        for (int i = 0; i < numberOfListeners; i++) {
 * license agreements. See the NOTICE file distributed with
                null
                @Override  
    public void testFailingListenerOnClose() throws IOException {
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE);
                assertThat(t.getValue().getMessage(), equalTo("failure"));
 */
                    return globalCheckpointListener.executor();
            public Executor executor() {
            verify(mockLogger, times(failureCount)).warn(message.capture(), t.capture());
    ) {  
                maybeMultipleInvocationProtectingListener((g, e) -> globalCheckpoints[index] = g),
                            }  
            final boolean failure = randomBoolean();
            globalCheckpointListeners.add(NO_OPS_PERFORMED, maybeMultipleInvocationProtectingListener(new TestGlobalCheckpointListener() {
        for (int i = 0; i < numberOfListeners; i++) {
        assertThat(message.getValue(), equalTo("error notifying global checkpoint listener of timeout"));  
        final Map<GlobalCheckpointListeners.GlobalCheckpointListener, Long> notifiedListeners = new HashMap<>();  
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE);
            }), null);
                    }),  
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
        latch.await();
        doAnswer(invocationOnMock -> {
        final AtomicBoolean invoked = new AtomicBoolean();  
        });  
                }),
            return new GlobalCheckpointListeners.GlobalCheckpointListener() {  
        assertTrue(invoked.get());
            assertNotNull(t.getValue());  
            } else {  
import org.opensearch.core.index.Index;
        globalCheckpointListeners.add(NO_OPS_PERFORMED, maybeMultipleInvocationProtectingListener((g, e) -> {
        final Map<GlobalCheckpointListeners.GlobalCheckpointListener, Long> listeners = new HashMap<>();
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);  
                    closed.set(true);  
        final CountDownLatch latch = new CountDownLatch(1);  
 * GitHub history for details.
        globalCheckpointListeners.add(
            awaitQuietly(barrier);  
        // closing should also not notify the listeners
                assertThat(globalCheckpoints[i], equalTo(globalCheckpoint));
            final int index = i;  
                    return executor;
    public void testNotificationOnClosedUsesExecutor() throws IOException {
        globalCheckpointListeners.add(NO_OPS_PERFORMED, maybeMultipleInvocationProtectingListener((g, e) -> {
                    notified.set(true);
public class GlobalCheckpointListenersTests extends OpenSearchTestCase {  
    }
import org.junit.After;
        final int numberOfListeners = randomIntBetween(0, 16);  
        int failureCount = 0;
                        }
            final int index = i;
            } catch (Exception caught) {
                    }
                final ArgumentCaptor<String> message = ArgumentCaptor.forClass(String.class);
import static org.mockito.Mockito.verify;
                        return executor;
            final int index = i;
            null
    public void testListenersReadyToBeNotifiedUsesExecutor() {
        // synchronize starting with the updating thread and the listener thread  
    }
        globalCheckpointListeners.close();
            final TestGlobalCheckpointListener listener = new TestGlobalCheckpointListener() {
import java.io.UncheckedIOException;
import java.util.concurrent.CountDownLatch;
            }
            globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint.incrementAndGet());  
        }
            count.incrementAndGet();  
import org.opensearch.threadpool.Scheduler;
        for (int i = 0; i < numberOfListeners; i++) {
        final long[] globalCheckpoints = new long[numberOfListeners];
            }
        }  
        final TestGlobalCheckpointListener globalCheckpointListener
        listenersThread.start();
                assertThat(e, hasToString(containsString(timeout.getStringRep())));
                                throw new IllegalStateException("listener invoked twice");
                notified.set(true);
        final Executor executor = command -> {
            @Override
        // we are going to synchronize the actions of three threads: the updating thread, the listener thread, and the main test thread  
        globalCheckpointListeners.globalCheckpointUpdated(nextGlobalCheckpoint);
        final CountDownLatch latch = new CountDownLatch(1);
            command.run();
        final long globalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE - 1);
                    return executor;  
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
 *
    private final ScheduledThreadPoolExecutor scheduler = new Scheduler.SafeScheduledThreadPoolExecutor(  
            failures[index] = failure;  
    private GlobalCheckpointListeners.GlobalCheckpointListener maybeMultipleInvocationProtectingListener(
    }  
            }
        assertThat(globalCheckpointListeners.pendingListeners(), equalTo(0));
        assertThat(t.getValue().getMessage(), equalTo("failure"));  
    public void testAddAfterClose() throws InterruptedException, IOException {
    }  
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);  
                @Override  
            final long waitingGlobalCheckpoint = randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE);
                assertThat(notifiedListeners.get(listener.getKey()), equalTo(globalCheckpoint));
            assertBusy(() -> assertTrue(invocation.get()));
        final int numberOfListeners = randomIntBetween(0, 16);  
        assertThat(notified.get(), equalTo(numberOfListeners));
 * software distributed under the License is distributed on an
                if (failure) {
 * specific language governing permissions and limitations
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
    public void testFailingListenerAfterTimeout() throws InterruptedException {
                    notifiedListeners.put(this, g);  
        final int numberOfListeners = randomIntBetween(0, 16);
 * under the License.  
            globalCheckpointListeners.add(0, maybeMultipleInvocationProtectingListener((g, e) -> {
        assertTrue(notified.get());
        globalCheckpointListeners.close();  
        final int numberOfIterations = randomIntBetween(1, 4096);
            throw new AssertionError(e);
            } else {  
        final long nextGlobalCheckpoint = randomLongBetween(globalCheckpoint + 1, Long.MAX_VALUE);  
                assertNull(notifiedListeners.get(listener.getKey()));
            }  
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);  
                assertNull(notifiedListeners.get(listener.getKey()));
                @Override
                    }  
        for (int i = 0; i < numberOfListeners; i++) {
                    public void accept(final long g, final Exception e) {  
        final Executor executor = command -> {
            throw new RuntimeException("failure");  
        1,
            globalCheckpointListeners.add(
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);  
                        assertNull(e);  
                invoked.set(true);
                    notified.incrementAndGet();
        for (int i = 0; i < numberOfListeners; i++) {  
        };
                assertNull(exceptions[i]);  
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, mockLogger);
            command.run();  
        final AtomicBoolean closed = new AtomicBoolean();  
        // test the listeners are not invoked twice
        final Executor executor = command -> {
        for (final Map.Entry<GlobalCheckpointListeners.GlobalCheckpointListener, Long> listener : listeners.entrySet()) {
 * Unless required by applicable law or agreed to in writing,
                    equalTo("error notifying global checkpoint listener of updated global checkpoint [{}]")
                        globalCheckpointListeners.close();
        barrier.await();  
            if (failures[i]) {  
        final long[] globalCheckpoints = new long[numberOfListeners];
import static org.mockito.Mockito.mock;
}
                    assertThat(g, equalTo(globalCheckpoint));  
        int failureCount = 0;
        final GlobalCheckpointListeners.GlobalCheckpointListener globalCheckpointListener = maybeMultipleInvocationProtectingListener(  
        }), timeout);
                invocations.add(invocation);  
                maybeMultipleInvocationProtectingListener(new TestGlobalCheckpointListener() {
 * SPDX-License-Identifier: Apache-2.0
    }  
        final ArgumentCaptor<String> message = ArgumentCaptor.forClass(String.class);  
                assertNotNull(exceptions[i]);
                // only listeners waiting on a lower global checkpoint will have been notified  
                }
                // these listeners should have been notified that we closed, and all the other listeners should not be
        };
                assertThat(t.getValue(), hasToString(containsString(timeout.getStringRep())));  
        final Logger mockLogger = mock(Logger.class);  
    public void testNotificationUsesExecutor() {
        scheduler.shutdown();
        final long nextGlobalCheckpoint = randomLongBetween(1 + globalCheckpoint, Long.MAX_VALUE);  
        verify(mockLogger).warn(message.capture(), t.capture());
            } finally {  
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, mockLogger);  
        } catch (final BrokenBarrierException | InterruptedException e) {  
            // synchronize starting with the updating thread and the main test thread
        final long[] globalCheckpoints = new long[numberOfListeners];
                latch.countDown();
import static org.hamcrest.Matchers.hasToString;  
    public void shutdownScheduler() {  
                assertNull(e);  
        }  
                    exceptions[index] = e;
            return Runnable::run;  
        globalCheckpointListeners.add(NO_OPS_PERFORMED, maybeMultipleInvocationProtectingListener(new TestGlobalCheckpointListener() {
            (g, e) -> {
    @After
        final AtomicInteger notified = new AtomicInteger();
        barrier.await();
        final Logger mockLogger = mock(Logger.class);
        for (int i = 0; i < numberOfListeners; i++) {
                randomLongBetween(0, globalCheckpoint),  
        assertThat(count.get(), equalTo(numberOfListeners));
        globalCheckpointListeners.close();
        for (int i = 0; i < numberOfListeners; i++) {
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, mockLogger);
    }  
                    }
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);  
            );
            };  
        }  
                assertThat(notifiedListeners.get(listener.getKey()), equalTo(UNASSIGNED_SEQ_NO));
                assertThat(globalCheckpoints[i], equalTo(Long.MIN_VALUE));
    }
import java.util.concurrent.ScheduledThreadPoolExecutor;
        for (int i = 0; i < numberOfListeners; i++) {
    public void testTimeout() throws InterruptedException {
    }  
/*
package org.opensearch.index.shard;
import static org.hamcrest.Matchers.containsString;
                );
        assertTrue(notified.get());  
            if (listener.getValue() > nextGlobalCheckpoint) {  
        assertNotNull(t.getValue());
                message.getValue().getFormat(),  
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.core.Assertions;  
        final int numberOfListeners = randomIntBetween(0, 16);  
        for (int i = 0; i < numberOfListeners; i++) {
import java.util.List;
                } finally {
        if (Assertions.ENABLED) {
                        throw new UncheckedIOException(e);
        final Exception[] exceptions = new Exception[numberOfListeners];
import static org.mockito.Mockito.reset;
        final CountDownLatch latch = new CountDownLatch(1);  
                    assertThat(((IndexShardClosedException) e).getShardId(), equalTo(shardId));
            command.run();  
            }), null);
            }), null);
    public void testListenersReadyToBeNotified() throws IOException {  
        // wait for all the listeners to be notified  
                // these listeners will have been notified by the second global checkpoint update, and all the other listeners should not be
            }
        }  
                    assertThat(e, instanceOf(TimeoutException.class));
            // synchronize starting with the listener thread and the main test thread
        assertThat(t.getValue(), instanceOf(RuntimeException.class));
                assertNotNull(message.getValue().getParameters());
        final int numberOfListeners = randomIntBetween(0, 16);  
        globalCheckpointListeners.close();
                assertNull(notifiedListeners.get(listener.getKey()));  
 *
    }
                null  
import java.util.concurrent.ExecutorService;
        }
        for (final Map.Entry<GlobalCheckpointListeners.GlobalCheckpointListener, Long> listener : listeners.entrySet()) {
        }
                        public Executor executor() {
        final Logger mockLogger = mock(Logger.class);
        }
                assertThat(message.getValue(), equalTo("global checkpoint listener timed out"));
            }  
                        public void accept(final long g, final Exception e) {  
            assertThat(
        notifiedListeners.clear();
        final Executor executor = command -> {
            }
            }
            if (listener.getValue() <= globalCheckpoint) {
import java.util.concurrent.Executor;
        }  
            } else {  
 * the Apache License, Version 2.0 (the "License"); you may
        // one last update to ensure all listeners are notified
        globalCheckpointListeners.globalCheckpointUpdated(globalCheckpoint);
        for (int i = 0; i < numberOfListeners; i++) {  
        for (int i = 0; i < numberOfListeners; i++) {  
        final int numberOfListeners = randomIntBetween(0, 16);  
                if (i > numberOfIterations / 2 && rarely() && closed.get() == false) {
                    }
        final int numberOfListeners = randomIntBetween(0, 16);
                    @Override
                assertThat(globalCheckpoints[i], equalTo(globalCheckpoint));
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
                    public Executor executor() {
        final Logger mockLogger = mock(Logger.class);  
import org.apache.logging.log4j.Logger;
    public void testGlobalCheckpointUpdated() throws IOException {
        globalCheckpointListeners.close();
            assertNotNull(message.getValue().getParameters());  
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);
        for (final AtomicBoolean invocation : invocations) {
            maybeMultipleInvocationProtectingListener((g, e) -> {
 * You may obtain a copy of the License at  
            return null;
        final boolean[] failures = new boolean[numberOfListeners];
        final ScheduledFuture<?> future = globalCheckpointListeners.getTimeoutFuture(globalCheckpointListener);
            failures[index] = failure;  
            if (failures[i]) {
            final ArgumentCaptor<RuntimeException> t = ArgumentCaptor.forClass(RuntimeException.class);  
 * ownership. Elasticsearch licenses this file to you under  
            );  
                }
        final CyclicBarrier barrier = new CyclicBarrier(3);
                public void accept(final long g, final Exception e) {
                try {
        final Exception[] exceptions = new Exception[numberOfListeners];
        );
                assertThat(g, equalTo(NO_OPS_PERFORMED));
            count.incrementAndGet();
        default Executor executor() {
            count.incrementAndGet();
                    assertThat(g, equalTo(UNASSIGNED_SEQ_NO));
/*  
        final ArgumentCaptor<RuntimeException> t = ArgumentCaptor.forClass(RuntimeException.class);
        }  
        final boolean[] failures = new boolean[numberOfListeners];
                public void accept(final long g, final Exception e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
                assertNotNull(t.getValue());
        for (int i = 0; i < numberOfListeners; i++) {  
import java.util.Map;
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, mockLogger);
            globalCheckpointListeners.add(waitingGlobalCheckpoint, maybeMultipleInvocationProtectingListener(listener), null);  
        assertTrue(future.isCancelled());
    }  
            } else {
            verify(mockLogger, times(failureCount)).warn(message.capture(), t.capture());
import static org.mockito.Mockito.times;  
                null  
        final long globalCheckpoint = randomLongBetween(0, Long.MAX_VALUE);
        notifiedListeners.clear();  
                    maybeMultipleInvocationProtectingListener(new TestGlobalCheckpointListener() {
            // synchronize ending with the listener thread and the main test thread
 */  
    private final ShardId shardId = new ShardId(new Index("index", "uuid"), 0);
        final CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.common.settings.Settings;  
        // test the listeners are not invoked twice
                } else {
                        @Override
    }  
        }
import static org.mockito.Mockito.any;
            }
            final boolean failure = randomBoolean();
                    globalCheckpoints[index] = Long.MIN_VALUE;  
                            return executor;
                fail(e.getMessage());
            assertThat(message.getValue().getParameters().length, equalTo(1));
        latch.await();
                }
                assertThat(exceptions[i], instanceOf(IndexShardClosedException.class));  
    }
            command.run();  
                            if (invocation.compareAndSet(false, true) == false) {
                    assertNotNull(e);  
            if (listener.getValue() > globalCheckpoint && listener.getValue() <= nextGlobalCheckpoint) {  
            @Override  
        }  
        globalCheckpointListeners.add(NO_OPS_PERFORMED, globalCheckpointListener, timeout);  
            }), null);
                public Executor executor() {
    public void testFailingListenerOnUpdate() {
/*  
                if (failure) {
                assertThat(e, instanceOf(TimeoutException.class));  
                    } else {
            assertNotNull(t.getValue());  
        OpenSearchExecutors.daemonThreadFactory(Settings.EMPTY, "scheduler")
            final boolean failure = randomBoolean();
            );
        }
import org.opensearch.core.index.shard.ShardId;
        final AtomicBoolean notified = new AtomicBoolean();  
            final int index = i;
            listeners.put(listener, waitingGlobalCheckpoint);
 * KIND, either express or implied.  See the License for the
        }  
    public void testClose() throws IOException {  
            }
import java.util.concurrent.ScheduledFuture;
        if (closed.get() == false) {
                public Executor executor() {  
        final TimeValue timeout = TimeValue.timeValueMillis(randomIntBetween(1, 50));
        }).when(mockLogger).warn(any(String.class), any(RuntimeException.class));
 * compatible open source license.
                maybeMultipleInvocationProtectingListener((g, e) -> {
                final ArgumentCaptor<RuntimeException> t = ArgumentCaptor.forClass(RuntimeException.class);  
                    globalCheckpoint.get(),  
                        }  
        updatingThread.start();
            randomLongBetween(NO_OPS_PERFORMED, Long.MAX_VALUE),  
        // test the listeners are not invoked twice
        }
            assertThat(globalCheckpoints[index], equalTo(globalCheckpoint));
import java.io.IOException;
            final int index = i;  
    }
        }
                latch.countDown();  
        });
                        throw new AssertionError("listener invoked twice");
        assertThat(notified.get(), equalTo(numberOfListeners));
                    globalCheckpoints[index] = g;  
    }
            // the listener should be notified immediately
            try {  
                final ArgumentCaptor<TimeoutException> t = ArgumentCaptor.forClass(TimeoutException.class);  
            }
            final ArgumentCaptor<RuntimeException> t = ArgumentCaptor.forClass(RuntimeException.class);  
    }  
        };
                }  
                reset(mockLogger);
        // ensure the listener notification occurred on the executor  
                assertThat(message.getValue().getParameters().length, equalTo(1));
                @Override
                final ArgumentCaptor<ParameterizedMessage> message = ArgumentCaptor.forClass(ParameterizedMessage.class);
                verify(mockLogger).warn(message.capture(), t.capture());
                assertThat(  
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);
        final AtomicInteger notified = new AtomicInteger();
                        globalCheckpoints[index] = Long.MIN_VALUE;  
import java.util.HashMap;  
        final AtomicInteger notified = new AtomicInteger();
            awaitQuietly(barrier);  
        globalCheckpointListeners.globalCheckpointUpdated(NO_OPS_PERFORMED);  
                    randomBoolean() ? null : TimeValue.timeValueNanos(randomLongBetween(1, TimeUnit.MICROSECONDS.toNanos(1)))
                        assertThat(g, equalTo(globalCheckpoint));
        };
            globalCheckpointListeners.add(
        final GlobalCheckpointListeners globalCheckpointListeners = new GlobalCheckpointListeners(shardId, scheduler, logger);  
        }
                }
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
        final AtomicLong globalCheckpoint = new AtomicLong(NO_OPS_PERFORMED);
    }  
import org.apache.logging.log4j.message.ParameterizedMessage;
            } else {
                public void accept(final long g, final Exception e) {  
                assertThat(notifiedListeners.get(listener.getKey()), equalTo(nextGlobalCheckpoint));
            final ArgumentCaptor<String> message = ArgumentCaptor.forClass(String.class);
                assertThat(g, equalTo(UNASSIGNED_SEQ_NO));
        // synchronize ending with the updating thread and the listener thread
            }
                equalTo("error notifying global checkpoint listener of updated global checkpoint [{}]")
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
        assertThat(notified.get(), equalTo(numberOfListeners));  
        if (failureCount > 0) {
            assertThat(globalCheckpoints[i], equalTo(globalCheckpoint));  
        final long globalCheckpoint = randomNonNegativeLong();  
