    public void testAsyncBlockOperationsOperationBeforeBlocked() throws InterruptedException, BrokenBarrierException {
import static org.hamcrest.Matchers.hasToString;
                        }
            assertFalse(future.isDone());
    private Releasable blockAndWait() throws InterruptedException {
                }
 * under the License.
        });
            onBlocked.set(true);
        threadPool = null;
        expectThrows(IndexShardClosedException.class, () -> permits.asyncBlockOperations(wrap(() -> {
        {
        final CyclicBarrier barrier = new CyclicBarrier(1 + 1 + operations);
        List<Thread> operationThreads = new ArrayList<>();
            }
        final CountDownLatch secondOperationComplete = new CountDownLatch(1);
        permits.close();
        assertThat(permits.getActiveOperationsCount(), equalTo(1));
                }
import static org.hamcrest.Matchers.emptyIterable;
        try (Releasable ignored = blockAndWait()) {
                        operationLatch.await();
import java.util.Collections;
            public void onResponse(Releasable releasable) {
        final CountDownLatch operationLatch = new CountDownLatch(1);
        for (int i = 0; i < operations; i++) {
                    super.onResponse(releasable);
            }
import org.opensearch.action.support.PlainActionFuture;
                public void onResponse(Releasable releasable) {
import org.opensearch.threadpool.ThreadPool;
                blockReleased.await();
        expectThrows(IndexShardClosedException.class, () -> permits.blockOperations(randomInt(10), TimeUnit.MINUTES, () -> {
                    );
            @Override
                context.putHeader("foo", "bar");
                releaseBlock.await();
        barrier.await();
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
                }
            listener1.get().close();
        final CountDownLatch secondOperationExecuting = new CountDownLatch(1);
                }
        future.get(1, TimeUnit.HOURS).close();
                }
        final AtomicBoolean blocked = new AtomicBoolean();
    @AfterClass
            }, ThreadPool.Names.GENERIC, false, "")
            thread.start();
            assertThat(permits.getActiveOperationsCount(), equalTo(1));
import java.util.concurrent.atomic.AtomicBoolean;
            try (ThreadContext.StoredContext ignore = context.newStoredContext(false)) {
        }
        List<PlainActionFuture<Releasable>> futures = new ArrayList<>();
                        super.onResponse(releasable);
    /**
            }
                        values.add(value);
        PlainActionFuture<Releasable> future = new PlainActionFuture<>();
        class DummyException extends RuntimeException {}
import static org.hamcrest.Matchers.containsInAnyOrder;
                assertNotNull(future.get(1, TimeUnit.MINUTES));
/*
                        // ok, notify future
import static org.hamcrest.Matchers.contains;
                } catch (final BrokenBarrierException | InterruptedException e) {
                permits.acquire(new ActionListener<Releasable>() {
            thread.join();
        final Thread blockingThread = new Thread(() -> {
                public void onFailure(Exception e) {
        final Thread thread = new Thread(controlledAcquire(barrier, operationExecutingLatch, operationLatch, operationCompleteLatch));
        {
        }, ThreadPool.Names.GENERIC, false, ""));
        assertThat(reference.get(), hasToString(containsString("simulated")));
            @Override
    public static void setupThreadPool() {
            futures.add(future);
                blockFinished.countDown();
                    operationExecutingLatch.countDown();
        permits.acquire(future3, ThreadPool.Names.GENERIC, true, "");
        try (Releasable ignored = blockAndWait()) {
        permits.asyncBlockOperations(new ActionListener<Releasable>() {
        permits.semaphore.release(IndexShardOperationPermits.TOTAL_PERMITS);
            try {
                    assert false;
                throw new RuntimeException(e);
                public void onResponse(Releasable releasable) {
        threadPool.generic().execute(() -> {
    }
        if (randomBoolean()) {
        );
        thread.join();
     */
            Thread thread = new Thread() {
                    public void onResponse(Releasable releasable) {
                    } catch (final InterruptedException e) {
                }
 *
                            .or(instanceOf(IndexShardClosedException.class))
                        blockAcquired.countDown();
        }
                    }
        assertTrue(delayed.get());
        };
        final AtomicReference<Exception> reference = new AtomicReference<>();
                        throw new RuntimeException();
                    latch.countDown();
        assertFalse(secondOperation.get());
public class IndexShardOperationPermitsTests extends OpenSearchTestCase {
        firstOperationThread.start();
            }
                @Override
                if (e != exception) {
            public void onResponse(final Releasable releasable) {
                    @Override
            ((OpenSearchThreadPoolExecutor) threadPool.executor(ThreadPool.Names.WRITE)).getCorePoolSize(),
import org.opensearch.test.OpenSearchTestCase;
        future1.get().close(); // check idempotence
        assertBusy(() -> {
        firstOperationCompleteLatch.await();
            blockedLatch.countDown();
        permits.asyncBlockOperations(wrap(() -> {
        CountDownLatch releaseBlock = new CountDownLatch(1);
                    onFailure(e);
            @Override
    }
 * You may obtain a copy of the License at
                @Override
        permits.asyncBlockOperations(wrap(() -> {
        firstOperationLatch.countDown();
                blockAcquired.countDown();
            boolean failingListener = randomBoolean();
        assertThat(
                        "context did not have value [bar] for header [foo]. Actual value [" + context.getHeader("foo") + "]"
        permits.acquire(future, ThreadPool.Names.GENERIC, true, "");
    public void testGetBlockWhenBlocked() throws ExecutionException, InterruptedException, TimeoutException {
        final AtomicBoolean onBlocked = new AtomicBoolean();
        final PlainActionFuture<Releasable> listener1 = new PlainActionFuture<>();
            }
            throw new IllegalArgumentException("fake error");
            secondOperationExecuting.countDown();
        CountDownLatch blockReleased = new CountDownLatch(1);
import org.opensearch.threadpool.ThreadPoolStats;
            releaseBlock.countDown();
                }
            final CountDownLatch onFailureLatch = new CountDownLatch(1);
            assertThat(messages, contains(containsString("listener2")));
        }
            }
        PlainActionFuture<Releasable> future1 = new PlainActionFuture<>();
                TimeoutException.class,
    }
}
                .put("thread_pool." + ThreadPool.Names.WRITE + ".queue_size", writeThreadPoolQueueSize)
                }
                    secondOperation.set(true);
                    assertThat("Expected no active threads in GENERIC pool", stats.getActive(), equalTo(0));
import org.junit.After;
                try (Releasable ignored = releasable) {
            IllegalStateException.class,
                return true;
            controlledAcquire(barrier, operationExecutingLatch, firstOperationLatch, firstOperationCompleteLatch)
        final CountDownLatch firstOperationCompleteLatch = new CountDownLatch(1);
        assertTrue(future3.isDone());
    }
            public void onFailure(final Exception e) {
        permits.close();
            PlainActionFuture<Releasable> future = new PlainActionFuture<Releasable>() {
        delayedOperation.await();
            listener2.get().close();
        // if we submit another operation, it should be delayed
            }
                }
    public static void shutdownThreadPool() {
        final PlainActionFuture<Releasable> listener2 = new PlainActionFuture<>();
            operationThreads.add(thread);
                onFailureLatch.countDown();
        assertThat(exception.getCause(), instanceOf(IndexShardClosedException.class));
 * Licensed to Elasticsearch under one or more contributor
                throw new AssertionError(e);
                if (contextChecker.apply(this)) {
        final CountDownLatch operationCompleteLatch = new CountDownLatch(1);
                permits.acquire(future, ThreadPool.Names.GENERIC, true, "");
                    } catch (InterruptedException e) {
                operationLatch.countDown();
    }
        assertThat(messages, containsInAnyOrder(Arrays.asList(containsString("listener1"), containsString("listener2"))));
        assertThat(permits.getActiveOperationsCount(), equalTo(0));
                );
                        operationLatch.countDown();
import java.util.ArrayList;
            }
        assertThat(permits.getActiveOperationsCount(), equalTo(0));
                    permits.close();
        final AtomicBoolean blocked = new AtomicBoolean();
        permits.acquire(future1, ThreadPool.Names.GENERIC, true, "");
        thread.join();
        }));
            } catch (InterruptedException e) {
    public void createIndexShardOperationsLock() {
        }), randomInt(10), TimeUnit.MINUTES));
    }
        thread.start();
                            throw exception;
        permits = new IndexShardOperationPermits(new ShardId("blubb", "id", 0), threadPool);
                if (contextChecker.apply(this)) {
 * specific language governing permissions and limitations
import java.util.concurrent.BrokenBarrierException;
        for (int i = 0; i < operations; i++) {
        );
    }
                @Override
import org.opensearch.common.CheckedRunnable;
import static org.hamcrest.Matchers.hasSize;
        });
    }
            }
            } catch (ExecutionException e) {
import org.junit.BeforeClass;
            permits.asyncBlockOperations(new ActionListener<Releasable>() {
        }
        };
        assertThat(
        secondOperationComplete.await();
            fail("Failed to find stats for the GENERIC thread pool");
            }
                    releasable.close();
        future2.get(1, TimeUnit.HOURS).close();
        final List<Thread> threads = new ArrayList<>();
        future.get().close();
            @Override
            public void onResponse(Releasable releasable) {
        // we racily submit operations and a delay, and then ensure that all operations were actually completed
            }), 30, TimeUnit.MINUTES);
        blockAcquired.await();
            ((OpenSearchThreadPoolExecutor) threadPool.executor(ThreadPool.Names.WRITE)).getQueue().remainingCapacity(),
                @Override
        assertThat(permits.getActiveOperationsCount(), equalTo(2));
        List<String> messages = permits.getActiveOperations().stream().collect(Collectors.toList());
        IndexShardClosedException exception = new IndexShardClosedException(new ShardId("blubb", "id", 0));
        assertThat(permits.getActiveOperationsCount(), equalTo(0));
         * permits to the semaphore. We wait here until all generic threads are idle as an indication that all permits have been returned to
/*
                public void onFailure(Exception e) {
    }
            }
                    assertThat(
        future.get(1, TimeUnit.HOURS).close();
        releaseBlock.countDown();
        boolean closeAfterBlocking = randomBoolean();
            try {
            final int value = i;
                throw new RuntimeException(e);
        assertFalse(delayed.get());
                    try {
            }, ThreadPool.Names.GENERIC, false, "");
            ((OpenSearchThreadPoolExecutor) threadPool.executor(ThreadPool.Names.WRITE)).getMaximumPoolSize(),
            // the write thread pool uses a bounded size and can get rejections, see setupThreadPool
        final CountDownLatch firstOperationLatch = new CountDownLatch(1);
 * compatible open source license.
                @Override
 * GitHub history for details.
                    releasable.close();
                );
        final CountDownLatch operationExecutingLatch,
                    }
        assertFalse(future.isDone());
        PlainActionFuture<Releasable> future2 = new PlainActionFuture<>();
                        future.onFailure(dummyException);
                        either(instanceOf(DummyException.class)).or(instanceOf(OpenSearchRejectedExecutionException.class))
import java.util.concurrent.atomic.AtomicReference;
        final AtomicBoolean secondOperation = new AtomicBoolean();
        final CountDownLatch blockedLatch = new CountDownLatch(1);
        final Thread secondOperationThread = new Thread(() -> {
        final CountDownLatch releaseBlock = new CountDownLatch(1);
        permits.acquire(future, ThreadPool.Names.GENERIC, true, "");
                    new IllegalStateException(
    ) {
import java.util.concurrent.ExecutionException;
        final CountDownLatch releaseBlock = new CountDownLatch(1);
            }, 1, TimeUnit.MILLISECONDS);
            permits.acquire(new ActionListener<Releasable>() {
            listener1.get().close();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.Matchers.equalTo;
                    @Override
            } catch (final BrokenBarrierException | InterruptedException e) {
                }
                () -> permits.blockOperations(1, TimeUnit.MILLISECONDS, () -> {})
                    assertThat(
     * <ul>
 * ownership. Elasticsearch licenses this file to you under
        // check that all operations completed
 * not use this file except in compliance with the License.
    @BeforeClass
            thread.start();
                } catch (final Exception e) {
import java.util.stream.Collectors;
                blockReleased.countDown();
                    }
            assertThat(e, hasToString(containsString("timeout while blocking operations")));
                    try {
                try {
            });
        PlainActionFuture<Releasable> future = new PlainActionFuture<>();
                    );
            } catch (final BrokenBarrierException | InterruptedException e) {
            public void onResponse(Releasable releasable) {
        PlainActionFuture<Releasable> future2 = new PlainActionFuture<Releasable>() {
            } else {
 */
 * the Apache License, Version 2.0 (the "License"); you may
     * <li>counts down the {@code operationCompleteLatch} after releasing the permit</li>
                        assertTrue(failingListener);
                    throw new RuntimeException(e);
            @Override
        }
            } else if ("baz".equals(context.getTransient("bar")) == false) {
                }
 * The OpenSearch Contributors require contributions made to
        return () -> {
        secondOperationThread.join();
        assertThat(permits.getActiveOperations(), emptyIterable());
                        releasable.close();
        }
                    if (failingListener) {
    public void testActiveOperationsCount() throws ExecutionException, InterruptedException {
        try (Releasable ignored = blockAndWait()) {
            return false;
                    } else {
        }), 30, TimeUnit.MINUTES);
        final CountDownLatch onFailureLatch = new CountDownLatch(1);
                    }
                    )
            if ("bar".equals(context.getHeader("foo")) == false) {
        };
                }
     * Tests that the ThreadContext is restored when a operation is executed after it has been delayed due to a block
        final Thread firstOperationThread = new Thread(
    }
        future3.get().close();
    public void testBlockIfClosed() {
                barrier.await();
        assertThat(permits.getActiveOperationsCount(), equalTo(1));
                        releaseBlock.await();
import org.opensearch.common.lease.Releasable;
            throw new IllegalArgumentException("fake error");
            public void onFailure(Exception e) {
        blockAcquired.await();
            // we preserve the thread context here so that we have a different context in the call to acquire than the context present
     * <li>waits on the {@code barrier} before acquiring a permit</li>
        assertThat(e, hasToString(containsString("failed to obtain permit but operations are not delayed")));
            };
            public void onResponse(Releasable releasable) {
        assertTrue(values.contains(operations));
    }
        assertFalse(onBlocked.get());
import java.util.Set;
    /**
                    assert false;
            }
                        e.getCause(),
        } else {
            blocked.set(true);
        final CountDownLatch operationLatch,
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            messages = permits.getActiveOperations().stream().collect(Collectors.toList());
        for (Thread thread : operationThreads) {
        CountDownLatch blockFinished = new CountDownLatch(1);
        firstOperationThread.join();
            releaseBlock.await();
        assertThat(
            public void onFailure(final Exception e) {
     * <li>counts down the {@code operationExecutingLatch} when it acquires the permit</li>
                }, ThreadPool.Names.GENERIC, false, "");
                    try {
        /*
        try (Releasable ignored = blockAndWait()) {
    }
        assertTrue(blocked.get());
                public void onFailure(Exception e) {
            assertTrue(values.contains(i));
    private Runnable controlledAcquire(
        }
        );
                releasable.close();
     * Returns an operation that acquires a permit and synchronizes in the following manner:
                });
        operationCompleteLatch.await();
        );
        blockingThread.join();
                values.add(operations);
    public void testTimeout() throws BrokenBarrierException, InterruptedException {
        }), 30, TimeUnit.MINUTES);
            blockAcquired.countDown();
                listener.onFailure(
    public void testAsyncBlockOperationsOperationWhileBlocked() throws InterruptedException {
import static org.hamcrest.Matchers.either;
            listener2.get().close();
     * <li>waits on the {@code operationLatch} before releasing the permit</li>
import java.util.function.Function;
        permits.acquire(listener2, null, false, "listener2");
            permits.asyncBlockOperations(wrap(() -> {
        };
                    releasable.close();
                public void onResponse(Releasable releasable) {
        );
                    throw new RuntimeException(e);
 *
 * SPDX-License-Identifier: Apache-2.0
            messages = permits.getActiveOperations().stream().collect(Collectors.toList());
    public void testAsyncBlockOperationsRace() throws Exception {
        blockedLatch.await();
            assertThat(permits.getActiveOperationsCount(), equalTo(1));
                @Override
    }
         * the semaphore.
        }
                throw new RuntimeException(e);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            assertThat(reference.get(), hasToString(containsString("timeout while blocking operations")));
 * software distributed under the License is distributed on an
            @Override
            assertFalse(future.isDone());
                if (ThreadPool.Names.GENERIC.equals(stats.getName())) {
                    public void onFailure(Exception e) {
            String threadPoolName = randomFrom(ThreadPool.Names.WRITE, ThreadPool.Names.GENERIC);
            "IndexShardOperationPermitsTests",
            @Override
        permits.acquire(future2, ThreadPool.Names.GENERIC, true, "");
        threadPool.generic().execute(() -> {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    public void testAllOperationsInvoked() throws InterruptedException, TimeoutException {
     */
package org.opensearch.index.shard;
            }), 30, TimeUnit.MINUTES);
                    secondOperationComplete.countDown();
        final CountDownLatch operationExecutingLatch = new CountDownLatch(1);
import java.util.concurrent.CyclicBarrier;
 * license agreements. See the NOTICE file distributed with
     *
        }
            try {
        }
                delayed.set(true);
 * this work for additional information regarding copyright
        future.get(1, TimeUnit.HOURS).close();
                        permits.acquire(future, threadPoolName, forceExecution, "");
                        if (throwsException) {
        );
        final CyclicBarrier barrier = new CyclicBarrier(2);
            threads.add(thread);
        assertThat(permits.semaphore.availablePermits(), equalTo(Integer.MAX_VALUE));
    }
            try {
        final Function<ActionListener<Releasable>, Boolean> contextChecker = (listener) -> {
        thread.start();
            }
                } else {
                latch.await();
import org.junit.Before;
        final CyclicBarrier barrier,
                }
        };
        final CountDownLatch operationCompleteLatch
                }
        final CyclicBarrier barrier = new CyclicBarrier(2);
            }, ThreadPool.Names.GENERIC, false, "");
    private IndexShardOperationPermits permits;
            } catch (InterruptedException e) {
import static org.hamcrest.Matchers.instanceOf;
        assertTrue(blocked.get());
        final CountDownLatch blockAcquired = new CountDownLatch(1);
                .put("thread_pool." + ThreadPool.Names.WRITE + ".size", writeThreadPoolSize)
            for (final ThreadPoolStats.Stats stats : threadPool.stats()) {
                    throw new RuntimeException(e);
                }
        releaseBlock.countDown();
                // test both with and without a executor name
                try (Releasable ignored = releasable) {
                context.putTransient("bar", "baz");
     * </ul>
import org.junit.AfterClass;
        CountDownLatch latch = new CountDownLatch(numThreads / 4);
                if (closeAfterBlocking) {
            permits.acquire(future, ThreadPool.Names.GENERIC, true, "");
        PlainActionFuture<Releasable> future = new PlainActionFuture<>();
                    throw new RuntimeException("simulated");
    public void testThreadContextPreservedIfBlock() throws ExecutionException, InterruptedException, TimeoutException {
        final IllegalStateException e = expectThrows(
        assertThat(permits.getActiveOperationsCount(), equalTo(0));
                }
        for (PlainActionFuture<Releasable> future : futures) {
                    onFailureLatch.countDown();
                @Override
        assertTrue(secondOperation.get());
        PlainActionFuture<Releasable> future = new PlainActionFuture<>();
        final AtomicBoolean delayed = new AtomicBoolean();
import org.opensearch.common.settings.Settings;
            final AtomicReference<Exception> reference = new AtomicReference<>();
    public void testOperationsInvokedImmediatelyIfNoBlock() throws ExecutionException, InterruptedException {
                    super.onResponse(releasable);
        blockAcquired.await();
        final CountDownLatch blockAcquired = new CountDownLatch(1);
        CountDownLatch blockAcquired = new CountDownLatch(1);
 * Unless required by applicable law or agreed to in writing,
        future1.get().close();
     * @param barrier                 the barrier to wait on
        final CountDownLatch operationExecutingLatch = new CountDownLatch(1);
            final TimeoutException e = expectThrows(
    }
        onFailureLatch.await();
            assertFalse(blocked.get());
import java.util.concurrent.ConcurrentHashMap;
                    throw new RuntimeException(e);
                    releasable.close();
        }
import org.opensearch.common.util.concurrent.ThreadContext;
            };
                public void run() {
                    new IllegalStateException(
        operationExecutingLatch.await();
                }
     * @return a controllable runnable that acquires a permit
            final Thread thread = new Thread(() -> {
        permits.acquire(listener1, null, false, "listener1");
                if (closeAfterBlocking) {
        for (final Thread thread : threads) {
            try {
        };
    public void testPermitTraceCapturing() throws ExecutionException, InterruptedException {
        assertTrue(future1.isDone());
                        either(instanceOf(DummyException.class)).or(instanceOf(OpenSearchRejectedExecutionException.class))
import static org.hamcrest.Matchers.containsString;
    @After
        secondOperationThread.start();
        assertTrue(onBlocked.get());
import org.opensearch.core.action.ActionListener;
                    onResponse.run();
            }
    }
        PlainActionFuture<Releasable> future = new PlainActionFuture<Releasable>() {
                public void onResponse(Releasable releasable) {
        final int operations = scaledRandomIntBetween(1, 64);
import java.util.concurrent.CountDownLatch;
        });
        operationExecutingLatch.await();
    public void testOperationsIfClosed() {
            permits.asyncBlockOperations(wrap(() -> {
                    }
import java.util.List;
                    barrier.await();
 *
    }
        int writeThreadPoolQueueSize = randomIntBetween(1, 2);
 */
            try {
            );
                        e.getCause(),
            }
            }
        final CountDownLatch delayedOperation = new CountDownLatch(1);
    private static ThreadPool threadPool;
    }
 * this file be licensed under the Apache-2.0 license or a
                        throw new DummyException();
                permits.acquire(future2, null, true, "");
                permits.blockOperations(1, TimeUnit.MINUTES, () -> {
                blocked.set(true);
        threadPool = new TestThreadPool(
        assertThat(permits.getActiveOperationsCount(), equalTo(1));
                    return;
        operationLatch.countDown();
        assertTrue(future2.isDone());
            thread.join();
                throw new RuntimeException(e);
        // now we will delay operations while the first operation is still executing (because it is latched)
        boolean forceExecution = randomBoolean();
        secondOperationExecuting.await();
        }
 */
            assertThat(permits.getActiveOperationsCount(), equalTo(IndexShard.OPERATIONS_BLOCKED));
            equalTo(writeThreadPoolSize)
        permits.semaphore.tryAcquire(IndexShardOperationPermits.TOTAL_PERMITS, 1, TimeUnit.SECONDS);
        future2.get().close();
        return () -> {
                        "context did not have value [baz] for transient [bar]. Actual value [" + context.getTransient("bar") + "]"
    public void testOperationsDelayedIfBlock() throws ExecutionException, InterruptedException, TimeoutException {
import java.util.concurrent.TimeUnit;
                blockAndWait().close();
        barrier.await();
                delayedOperation.countDown();
import java.util.concurrent.TimeoutException;
     * @param operationLatch          the latch to wait on before releasing the permit
        assertThat(reference.get(), instanceOf(RuntimeException.class));
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.index.shard.ShardId;
            assertThat(messages, contains(containsString("listener1")));
         * The block operation is executed on another thread and the operations can have completed before this thread has returned all the
        });
                @Override
        assertTrue(future.isDone());
                    )
        barrier.await();
    public void checkNoInflightOperations() {
        return new ActionListener<Releasable>() {
    @Before
        operationLatch.await();
        blockingThread.start();
        // an operation that is submitted while there is a delay in place should be delayed
        for (int i = 0; i < numThreads; i++) {
        int writeThreadPoolSize = randomIntBetween(1, 2);
        assertThat(messages, hasSize(2));
        blockFinished.await();
                public void onResponse(Releasable releasable) {
            equalTo(writeThreadPoolQueueSize)
            permits.acquire(future, ThreadPool.Names.GENERIC, true, "");
    private static ActionListener<Releasable> wrap(final CheckedRunnable<Exception> onResponse) {
            // when the releasable is closed
            permits.acquire(new ActionListener<Releasable>() {
        boolean throwsException = randomBoolean();
                    } catch (DummyException dummyException) {
        final CountDownLatch operationLatch = new CountDownLatch(1 + operations);
                    operationCompleteLatch.countDown();
                }
            () -> this.permits.acquire(new ActionListener<Releasable>() {
                    }
            equalTo(writeThreadPoolSize)
 * Modifications Copyright OpenSearch Contributors. See
        }
            } finally {
            onFailureLatch.await();
                barrier.await();
                .build()
        ExecutionException exception = expectThrows(ExecutionException.class, future::get);
                listener.onFailure(
        assertThat(permits.getActiveOperationsCount(), equalTo(2));
/*
        assertThat(threadPool.executor(ThreadPool.Names.WRITE), instanceOf(OpenSearchThreadPoolExecutor.class));
        });
        final Thread thread = new Thread(() -> permits.acquire(new ActionListener<Releasable>() {
     * @param operationExecutingLatch the latch to countdown after acquiring the permit
        }, 10, TimeUnit.MINUTES);
import java.util.Arrays;
        }
        for (Thread thread : operationThreads) {
                public void onFailure(final Exception e) {
            assertFalse(future.isDone());
        final ThreadContext context = threadPool.getThreadContext();
            } catch (Exception e) {
            @Override
            assertThat(messages, hasSize(1));
            assertThat(messages, hasSize(1));
    }
                    reference.set(e);
                reference.set(e);
        PlainActionFuture<Releasable> future3 = new PlainActionFuture<>();
                }
    public void testNoPermitsRemaining() throws InterruptedException {
        final Set<Integer> values = Collections.newSetFromMap(new ConcurrentHashMap<>());
    }
    public void testAsyncBlockOperationsOnFailure() throws InterruptedException {
import org.opensearch.threadpool.TestThreadPool;
    }
     * @param operationCompleteLatch  the latch to countdown after releasing the permit
            Settings.builder()
         */
                @Override
        assertThat(permits.getActiveOperationsCount(), equalTo(1));
        int numThreads = 10;
            }
                        throw new RuntimeException(e);
