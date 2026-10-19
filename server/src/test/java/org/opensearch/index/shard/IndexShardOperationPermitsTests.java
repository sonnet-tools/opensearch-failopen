        });  
                        releaseBlock.await();
 * not use this file except in compliance with the License.
 * GitHub history for details.
                permits.acquire(new ActionListener<Releasable>() {
     * @param operationLatch          the latch to wait on before releasing the permit
    }
        assertFalse(delayed.get());  
                    assert false;
            };  
                public void onFailure(Exception e) {  
            }, ThreadPool.Names.GENERIC, false, "");  
                permits.acquire(future, ThreadPool.Names.GENERIC, true, "");
        operationLatch.countDown();  
        assertTrue(values.contains(operations));
import java.util.concurrent.TimeoutException;
        blockingThread.start();  
    }
                }  
            assertFalse(blocked.get());
            } catch (final BrokenBarrierException | InterruptedException e) {  
            final TimeoutException e = expectThrows(
                }
import static org.hamcrest.Matchers.equalTo;
                    try {
import org.opensearch.threadpool.ThreadPoolStats;  
        for (int i = 0; i < operations; i++) {
            try {
     * <li>counts down the {@code operationExecutingLatch} when it acquires the permit</li>
     * <li>counts down the {@code operationCompleteLatch} after releasing the permit</li>  
 * license agreements. See the NOTICE file distributed with
                if (closeAfterBlocking) {  
import org.opensearch.common.CheckedRunnable;
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
        try (Releasable ignored = blockAndWait()) {
import static org.hamcrest.Matchers.instanceOf;
        for (Thread thread : operationThreads) {
            }
                    super.onResponse(releasable);  
                throw new RuntimeException(e);
            messages = permits.getActiveOperations().stream().collect(Collectors.toList());
        final Thread secondOperationThread = new Thread(() -> {
        try (Releasable ignored = blockAndWait()) {
            public void onResponse(Releasable releasable) {  
        }), randomInt(10), TimeUnit.MINUTES));  
                        releasable.close();
    }
        for (int i = 0; i < numThreads; i++) {
                try {
        } else {  
                if (contextChecker.apply(this)) {
        expectThrows(IndexShardClosedException.class, () -> permits.asyncBlockOperations(wrap(() -> {
 * Unless required by applicable law or agreed to in writing,
        permits.acquire(future2, ThreadPool.Names.GENERIC, true, "");
            equalTo(writeThreadPoolSize)
        final CountDownLatch blockAcquired = new CountDownLatch(1);
                });
                        either(instanceOf(DummyException.class)).or(instanceOf(OpenSearchRejectedExecutionException.class))
                    releasable.close();
            ((OpenSearchThreadPoolExecutor) threadPool.executor(ThreadPool.Names.WRITE)).getQueue().remainingCapacity(),  
                blocked.set(true);  
                        either(instanceOf(DummyException.class)).or(instanceOf(OpenSearchRejectedExecutionException.class))
        }
            blocked.set(true);  
        secondOperationExecuting.await();
        boolean throwsException = randomBoolean();  
        }, 10, TimeUnit.MINUTES);
            permits.acquire(future, ThreadPool.Names.GENERIC, true, "");  
        PlainActionFuture<Releasable> future = new PlainActionFuture<Releasable>() {
                return true;
        final CountDownLatch operationCompleteLatch = new CountDownLatch(1);  
    private static ActionListener<Releasable> wrap(final CheckedRunnable<Exception> onResponse) {  
                delayedOperation.countDown();  
        assertThat(permits.getActiveOperationsCount(), equalTo(0));
        CountDownLatch releaseBlock = new CountDownLatch(1);
    }
        threadPool.generic().execute(() -> {
                blockFinished.countDown();
 * The OpenSearch Contributors require contributions made to  
            thread.start();  
 * this work for additional information regarding copyright
                        future.onFailure(dummyException);  
        });
                @Override  
            assertThat(messages, contains(containsString("listener2")));
        onFailureLatch.await();  
                @Override
                latch.await();  
            } catch (InterruptedException e) {
                    }
                    } else {
            } finally {
                throw new AssertionError(e);
        for (Thread thread : operationThreads) {
            }  
        barrier.await();
        assertThat(exception.getCause(), instanceOf(IndexShardClosedException.class));
        final CountDownLatch secondOperationComplete = new CountDownLatch(1);
        };  
        final Thread thread = new Thread(controlledAcquire(barrier, operationExecutingLatch, operationLatch, operationCompleteLatch));
                public void run() {
            threads.add(thread);
                    }  
        final Function<ActionListener<Releasable>, Boolean> contextChecker = (listener) -> {
        permits.close();  
            @Override
    }  
        blockAcquired.await();
            public void onFailure(final Exception e) {
        permits.acquire(future3, ThreadPool.Names.GENERIC, true, "");  
        final AtomicBoolean onBlocked = new AtomicBoolean();
                }  
                if (ThreadPool.Names.GENERIC.equals(stats.getName())) {
            permits.acquire(future, ThreadPool.Names.GENERIC, true, "");  
                context.putTransient("bar", "baz");  
                @Override
            listener2.get().close();
        return () -> {  
import java.util.ArrayList;  
        operationExecutingLatch.await();
                operationLatch.countDown();  
        assertThat(reference.get(), hasToString(containsString("simulated")));
                @Override
                        e.getCause(),  
        );
            }, ThreadPool.Names.GENERIC, false, "")  
            ((OpenSearchThreadPoolExecutor) threadPool.executor(ThreadPool.Names.WRITE)).getCorePoolSize(),
        blockAcquired.await();
    public void testAsyncBlockOperationsOperationWhileBlocked() throws InterruptedException {
            }
                    throw new RuntimeException(e);  
        // if we submit another operation, it should be delayed  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        thread.join();
        int numThreads = 10;
        assertFalse(future.isDone());  
     * <li>waits on the {@code operationLatch} before releasing the permit</li>
                    secondOperationComplete.countDown();
import org.opensearch.common.lease.Releasable;
                    try {
                        // ok, notify future
                barrier.await();  
        );
                    }
        }), 30, TimeUnit.MINUTES);  
                        operationLatch.await();
        }
 * You may obtain a copy of the License at  
            // we preserve the thread context here so that we have a different context in the call to acquire than the context present
    }
    public void testBlockIfClosed() {
            assertThat(permits.getActiveOperationsCount(), equalTo(1));
            assertFalse(future.isDone());
                    } catch (final InterruptedException e) {  
                    )
        }
                    } catch (InterruptedException e) {
 * under the License.  
        // an operation that is submitted while there is a delay in place should be delayed
import org.junit.After;
            @Override  
 * compatible open source license.
                .put("thread_pool." + ThreadPool.Names.WRITE + ".size", writeThreadPoolSize)
import org.junit.AfterClass;
        future1.get().close(); // check idempotence
                            .or(instanceOf(IndexShardClosedException.class))
        future.get(1, TimeUnit.HOURS).close();
                }, ThreadPool.Names.GENERIC, false, "");
            }
    }
                        assertTrue(failingListener);
            try {
        final int operations = scaledRandomIntBetween(1, 64);  
                onFailureLatch.countDown();  
import java.util.concurrent.BrokenBarrierException;
}
        assertTrue(future1.isDone());
                values.add(operations);
     * @param operationExecutingLatch the latch to countdown after acquiring the permit
        final Thread thread = new Thread(() -> permits.acquire(new ActionListener<Releasable>() {
    ) {
        assertThat(
        future1.get().close();  
                } catch (final Exception e) {  
                blockAndWait().close();
        try (Releasable ignored = blockAndWait()) {
            @Override  
        firstOperationCompleteLatch.await();
                @Override
    }
            releaseBlock.countDown();
        }
                public void onResponse(Releasable releasable) {
 * this file be licensed under the Apache-2.0 license or a
        assertThat(permits.getActiveOperationsCount(), equalTo(2));
                @Override  
        boolean closeAfterBlocking = randomBoolean();
                () -> permits.blockOperations(1, TimeUnit.MILLISECONDS, () -> {})  
                );
                    throw new RuntimeException(e);
            };  
                }  
                barrier.await();
import org.opensearch.action.support.PlainActionFuture;  
        future.get(1, TimeUnit.HOURS).close();  
                    releasable.close();
                        e.getCause(),  
            IllegalStateException.class,
        permits.acquire(listener2, null, false, "listener2");
            }
                .build()  
            @Override
        assertTrue(secondOperation.get());
        IndexShardClosedException exception = new IndexShardClosedException(new ShardId("blubb", "id", 0));
    public void testGetBlockWhenBlocked() throws ExecutionException, InterruptedException, TimeoutException {  
        return new ActionListener<Releasable>() {
         * permits to the semaphore. We wait here until all generic threads are idle as an indication that all permits have been returned to
        blockFinished.await();
                throw new RuntimeException(e);
        return () -> {  
        firstOperationThread.join();  
    @BeforeClass  
    /**  
        assertFalse(onBlocked.get());
                        values.add(value);
        secondOperationComplete.await();  
                context.putHeader("foo", "bar");
                    assertThat("Expected no active threads in GENERIC pool", stats.getActive(), equalTo(0));
        assertThat(permits.getActiveOperationsCount(), equalTo(1));
        final CountDownLatch operationLatch,  
                public void onFailure(Exception e) {  
    public void testAllOperationsInvoked() throws InterruptedException, TimeoutException {
import java.util.concurrent.atomic.AtomicBoolean;  
            assertThat(e, hasToString(containsString("timeout while blocking operations")));
        int writeThreadPoolSize = randomIntBetween(1, 2);
import java.util.stream.Collectors;  
                permits.blockOperations(1, TimeUnit.MINUTES, () -> {
            for (final ThreadPoolStats.Stats stats : threadPool.stats()) {  
                    onFailureLatch.countDown();
        List<PlainActionFuture<Releasable>> futures = new ArrayList<>();  
                }  
import static org.hamcrest.Matchers.containsInAnyOrder;  
        assertTrue(future3.isDone());
        threadPool = new TestThreadPool(
                public void onResponse(Releasable releasable) {
        {
        delayedOperation.await();
        barrier.await();
    public void testOperationsIfClosed() {  
            permits.acquire(new ActionListener<Releasable>() {  
    public void checkNoInflightOperations() {
            ((OpenSearchThreadPoolExecutor) threadPool.executor(ThreadPool.Names.WRITE)).getMaximumPoolSize(),
        }
        final IllegalStateException e = expectThrows(  
        final CountDownLatch operationLatch = new CountDownLatch(1 + operations);
     * </ul>
        assertThat(messages, containsInAnyOrder(Arrays.asList(containsString("listener1"), containsString("listener2"))));  
                    reference.set(e);
        permits.close();
     * @return a controllable runnable that acquires a permit
/*  
        for (final Thread thread : threads) {
     * @param operationCompleteLatch  the latch to countdown after releasing the permit  
                    operationCompleteLatch.countDown();
        };  
     * @param barrier                 the barrier to wait on  
                        throw new DummyException();
            onBlocked.set(true);
import org.opensearch.threadpool.ThreadPool;
        final AtomicBoolean blocked = new AtomicBoolean();
                    onFailure(e);
        permits.acquire(listener1, null, false, "listener1");
                    public void onFailure(Exception e) {
        PlainActionFuture<Releasable> future2 = new PlainActionFuture<>();
            }, 1, TimeUnit.MILLISECONDS);
        PlainActionFuture<Releasable> future1 = new PlainActionFuture<>();
                delayed.set(true);
    }  
            listener1.get().close();  
        thread.start();
        assertThat(permits.getActiveOperations(), emptyIterable());  
            public void onResponse(Releasable releasable) {
        blockAcquired.await();
        // we racily submit operations and a delay, and then ensure that all operations were actually completed
    }
            }
 * the Apache License, Version 2.0 (the "License"); you may
            throw new IllegalArgumentException("fake error");
 */
                releaseBlock.await();
import org.opensearch.test.OpenSearchTestCase;  
        assertThat(permits.getActiveOperationsCount(), equalTo(2));  
            throw new IllegalArgumentException("fake error");
            equalTo(writeThreadPoolSize)  
                }  
        permits.acquire(future, ThreadPool.Names.GENERIC, true, "");
                }
                        operationLatch.countDown();  
 *
        PlainActionFuture<Releasable> future = new PlainActionFuture<>();
                    assertThat(
            permits.asyncBlockOperations(new ActionListener<Releasable>() {
        // check that all operations completed
                }
                public void onResponse(Releasable releasable) {
        if (randomBoolean()) {
        int writeThreadPoolQueueSize = randomIntBetween(1, 2);  
                    releasable.close();
     */
                    secondOperation.set(true);  
        final CountDownLatch operationExecutingLatch = new CountDownLatch(1);  
 *     http://www.apache.org/licenses/LICENSE-2.0
            blockAcquired.countDown();
        final CountDownLatch operationLatch = new CountDownLatch(1);
                }  
                releasable.close();
            listener2.get().close();
    public void createIndexShardOperationsLock() {  
            } catch (Exception e) {  
            }), 30, TimeUnit.MINUTES);
        }), 30, TimeUnit.MINUTES);  
    private Runnable controlledAcquire(  
        releaseBlock.countDown();
            public void onResponse(Releasable releasable) {  
import static org.hamcrest.Matchers.either;
            final CountDownLatch onFailureLatch = new CountDownLatch(1);
                } else {
        assertThat(permits.getActiveOperationsCount(), equalTo(1));  
            permits.acquire(new ActionListener<Releasable>() {  
        releaseBlock.countDown();
        PlainActionFuture<Releasable> future = new PlainActionFuture<>();
        assertTrue(delayed.get());  
                    }
                    onResponse.run();
    @After
            if ("bar".equals(context.getHeader("foo")) == false) {  
        final CountDownLatch onFailureLatch = new CountDownLatch(1);  
                assertNotNull(future.get(1, TimeUnit.MINUTES));
        try (Releasable ignored = blockAndWait()) {
    }
                if (e != exception) {
        final CountDownLatch secondOperationExecuting = new CountDownLatch(1);
        );  
        final CountDownLatch blockedLatch = new CountDownLatch(1);
    public void testPermitTraceCapturing() throws ExecutionException, InterruptedException {  
                    throw new RuntimeException(e);
            assertFalse(future.isDone());
                    }
                    barrier.await();  
        assertBusy(() -> {
                    );
import org.opensearch.common.settings.Settings;  
import org.opensearch.core.index.shard.ShardId;
                    latch.countDown();  
package org.opensearch.index.shard;
                    }
            assertThat(reference.get(), hasToString(containsString("timeout while blocking operations")));  
 * specific language governing permissions and limitations
            String threadPoolName = randomFrom(ThreadPool.Names.WRITE, ThreadPool.Names.GENERIC);  
            }
                }  
                blockReleased.await();  
                        blockAcquired.countDown();  
        };
        }  
        barrier.await();
                }
                    assertThat(
        permits.acquire(future, ThreadPool.Names.GENERIC, true, "");  
        thread.join();
        permits.asyncBlockOperations(wrap(() -> {  
        for (PlainActionFuture<Releasable> future : futures) {  
            final AtomicReference<Exception> reference = new AtomicReference<>();  
        for (int i = 0; i < operations; i++) {
        threadPool.generic().execute(() -> {
            releaseBlock.await();
        // now we will delay operations while the first operation is still executing (because it is latched)  
            @Override
        assertTrue(blocked.get());
        assertThat(permits.getActiveOperationsCount(), equalTo(1));
        }
            futures.add(future);
        secondOperationThread.start();
import java.util.Arrays;
         */
            public void onFailure(final Exception e) {  
            } else {  
 */  
                public void onFailure(final Exception e) {  
            return false;  
        }  
                @Override
import java.util.concurrent.CyclicBarrier;
    }
            fail("Failed to find stats for the GENERIC thread pool");  
                        throw new RuntimeException(e);
        future2.get().close();
    public void testActiveOperationsCount() throws ExecutionException, InterruptedException {
            PlainActionFuture<Releasable> future = new PlainActionFuture<Releasable>() {
                    @Override
                throw new RuntimeException(e);
            try {  
            messages = permits.getActiveOperations().stream().collect(Collectors.toList());  
        }  
        }
import java.util.concurrent.ExecutionException;  
            }, ThreadPool.Names.GENERIC, false, "");
     * <li>waits on the {@code barrier} before acquiring a permit</li>  
        CountDownLatch latch = new CountDownLatch(numThreads / 4);
                    try {
     * Tests that the ThreadContext is restored when a operation is executed after it has been delayed due to a block
                    public void onResponse(Releasable releasable) {  
        assertThat(  
        }  
        final CyclicBarrier barrier = new CyclicBarrier(2);  
            try {
            final int value = i;  
            }
        assertTrue(future.isDone());
        }, ThreadPool.Names.GENERIC, false, ""));
                        "context did not have value [bar] for header [foo]. Actual value [" + context.getHeader("foo") + "]"  
    @Before
                public void onResponse(Releasable releasable) {
                    super.onResponse(releasable);
            } catch (InterruptedException e) {  
                    releasable.close();  
    }
                if (contextChecker.apply(this)) {
import java.util.concurrent.ConcurrentHashMap;  
        List<String> messages = permits.getActiveOperations().stream().collect(Collectors.toList());
        final CyclicBarrier barrier,
        }  
                    permits.close();
        operationCompleteLatch.await();
        final CyclicBarrier barrier = new CyclicBarrier(2);
        });
        assertTrue(onBlocked.get());
 */
    public void testAsyncBlockOperationsRace() throws Exception {
import static org.hamcrest.Matchers.containsString;
                try (Releasable ignored = releasable) {
            @Override
import java.util.Set;
import java.util.function.Function;
        future.get().close();  
        PlainActionFuture<Releasable> future = new PlainActionFuture<>();
            @Override
                blockReleased.countDown();
                        permits.acquire(future, threadPoolName, forceExecution, "");
    }  
            assertFalse(future.isDone());
        };
     * <ul>
        final Thread firstOperationThread = new Thread(  
 * KIND, either express or implied.  See the License for the
        final ThreadContext context = threadPool.getThreadContext();
                );
            assertTrue(values.contains(i));  
                }
import org.junit.BeforeClass;
import static org.hamcrest.Matchers.hasToString;  
public class IndexShardOperationPermitsTests extends OpenSearchTestCase {  
                    @Override  
            thread.start();  
import org.opensearch.threadpool.TestThreadPool;
 * ownership. Elasticsearch licenses this file to you under  
    public void testTimeout() throws BrokenBarrierException, InterruptedException {
        permits.asyncBlockOperations(new ActionListener<Releasable>() {
        final CountDownLatch releaseBlock = new CountDownLatch(1);  
                        super.onResponse(releasable);  
        expectThrows(IndexShardClosedException.class, () -> permits.blockOperations(randomInt(10), TimeUnit.MINUTES, () -> {
        CountDownLatch blockAcquired = new CountDownLatch(1);  
            secondOperationExecuting.countDown();
            }  
    public void testOperationsDelayedIfBlock() throws ExecutionException, InterruptedException, TimeoutException {  
            }  
            }
import java.util.List;  
    }  
        class DummyException extends RuntimeException {}
     *
            thread.join();
                    return;  
                    throw new RuntimeException("simulated");
 * Licensed to Elasticsearch under one or more contributor  
            Settings.builder()  
                try (Releasable ignored = releasable) {
        final CountDownLatch operationCompleteLatch
            public void onResponse(Releasable releasable) {  
    public void testOperationsInvokedImmediatelyIfNoBlock() throws ExecutionException, InterruptedException {
        final AtomicBoolean delayed = new AtomicBoolean();  
    public void testThreadContextPreservedIfBlock() throws ExecutionException, InterruptedException, TimeoutException {  
                            throw exception;  
                    new IllegalStateException(
        operationLatch.await();
         * The block operation is executed on another thread and the operations can have completed before this thread has returned all the
/*
        });
    }
        assertThat(threadPool.executor(ThreadPool.Names.WRITE), instanceOf(OpenSearchThreadPoolExecutor.class));
            assertThat(messages, contains(containsString("listener1")));
            final Thread thread = new Thread(() -> {
 * Modifications Copyright OpenSearch Contributors. See  
                    )
                    } catch (DummyException dummyException) {  
    @AfterClass
        assertThat(permits.semaphore.availablePermits(), equalTo(Integer.MAX_VALUE));  
                }
    public static void setupThreadPool() {
        }));  
        future.get(1, TimeUnit.HOURS).close();  
        future3.get().close();  
            permits.asyncBlockOperations(wrap(() -> {
            onFailureLatch.await();
                if (closeAfterBlocking) {
        final CountDownLatch blockAcquired = new CountDownLatch(1);
        secondOperationThread.join();
        }
                }
        PlainActionFuture<Releasable> future = new PlainActionFuture<>();  
                permits.acquire(future2, null, true, "");  
        operationExecutingLatch.await();
        assertThat(permits.getActiveOperationsCount(), equalTo(1));
        assertThat(permits.getActiveOperationsCount(), equalTo(0));
        final AtomicBoolean blocked = new AtomicBoolean();
import org.junit.Before;  
        blockedLatch.await();  
        final CountDownLatch firstOperationCompleteLatch = new CountDownLatch(1);
            assertThat(messages, hasSize(1));
        assertThat(e, hasToString(containsString("failed to obtain permit but operations are not delayed")));
        final CyclicBarrier barrier = new CyclicBarrier(1 + 1 + operations);
        assertTrue(future2.isDone());  
import org.opensearch.core.action.ActionListener;  
                        "context did not have value [baz] for transient [bar]. Actual value [" + context.getTransient("bar") + "]"  
        final Set<Integer> values = Collections.newSetFromMap(new ConcurrentHashMap<>());  
import static org.hamcrest.Matchers.hasSize;
            boolean failingListener = randomBoolean();
            assertThat(permits.getActiveOperationsCount(), equalTo(1));
 *
        blockingThread.join();
        };  
        permits.semaphore.tryAcquire(IndexShardOperationPermits.TOTAL_PERMITS, 1, TimeUnit.SECONDS);
        firstOperationLatch.countDown();
                        }
        final AtomicReference<Exception> reference = new AtomicReference<>();
        threadPool = null;
            }
                    if (failingListener) {  
                    operationExecutingLatch.countDown();  
                public void onResponse(Releasable releasable) {
        PlainActionFuture<Releasable> future2 = new PlainActionFuture<Releasable>() {
        );
     * Returns an operation that acquires a permit and synchronizes in the following manner:
    }
import java.util.Collections;
            }
 *  
            }  
                }
            );
            }), 30, TimeUnit.MINUTES);  
        final List<Thread> threads = new ArrayList<>();
                        if (throwsException) {
        assertTrue(blocked.get());
    /**  
    public static void shutdownThreadPool() {  
import org.opensearch.common.util.concurrent.ThreadContext;
                listener.onFailure(
            @Override  
        CountDownLatch blockFinished = new CountDownLatch(1);  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        assertFalse(secondOperation.get());
        });
    public void testAsyncBlockOperationsOperationBeforeBlocked() throws InterruptedException, BrokenBarrierException {
                TimeoutException.class,
            public void onFailure(Exception e) {
        );
        CountDownLatch blockReleased = new CountDownLatch(1);
                @Override  
            assertThat(permits.getActiveOperationsCount(), equalTo(IndexShard.OPERATIONS_BLOCKED));
            operationThreads.add(thread);
                        throw new RuntimeException();  
            equalTo(writeThreadPoolQueueSize)
                    assert false;
        final Thread blockingThread = new Thread(() -> {
    private IndexShardOperationPermits permits;
    }
import static org.hamcrest.Matchers.contains;
        PlainActionFuture<Releasable> future3 = new PlainActionFuture<>();
            } else if ("baz".equals(context.getTransient("bar")) == false) {  
 * SPDX-License-Identifier: Apache-2.0
        future2.get(1, TimeUnit.HOURS).close();
            // the write thread pool uses a bounded size and can get rejections, see setupThreadPool
        }  
        ExecutionException exception = expectThrows(ExecutionException.class, future::get);
    public void testNoPermitsRemaining() throws InterruptedException {
                .put("thread_pool." + ThreadPool.Names.WRITE + ".queue_size", writeThreadPoolQueueSize)
            try (ThreadContext.StoredContext ignore = context.newStoredContext(false)) {
        /*  
                    new IllegalStateException(
        assertThat(reference.get(), instanceOf(RuntimeException.class));
                // test both with and without a executor name
                }
        List<Thread> operationThreads = new ArrayList<>();
        {  
    private Releasable blockAndWait() throws InterruptedException {
            listener1.get().close();  
                listener.onFailure(
            // when the releasable is closed  
    }  
        assertThat(
        );
            try {
        firstOperationThread.start();  
    }
    private static ThreadPool threadPool;
        boolean forceExecution = randomBoolean();  
        final CountDownLatch firstOperationLatch = new CountDownLatch(1);
            Thread thread = new Thread() {
        thread.start();  
            }
import java.util.concurrent.TimeUnit;
        final AtomicBoolean secondOperation = new AtomicBoolean();  
            permits.asyncBlockOperations(wrap(() -> {
        permits.semaphore.release(IndexShardOperationPermits.TOTAL_PERMITS);  
                }  
        final CountDownLatch operationExecutingLatch,
                throw new RuntimeException(e);
            controlledAcquire(barrier, operationExecutingLatch, firstOperationLatch, firstOperationCompleteLatch)
        assertThat(messages, hasSize(2));
            });
                } catch (final BrokenBarrierException | InterruptedException e) {
            public void onResponse(final Releasable releasable) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
            }  
        final CountDownLatch releaseBlock = new CountDownLatch(1);  
        permits = new IndexShardOperationPermits(new ShardId("blubb", "id", 0), threadPool);
         * the semaphore.  
            blockedLatch.countDown();
        permits.asyncBlockOperations(wrap(() -> {
                    throw new RuntimeException(e);
        permits.acquire(future1, ThreadPool.Names.GENERIC, true, "");  
    }
                public void onFailure(Exception e) {
            thread.join();  
import java.util.concurrent.atomic.AtomicReference;
    public void testAsyncBlockOperationsOnFailure() throws InterruptedException {
 * software distributed under the License is distributed on an
        final CountDownLatch operationExecutingLatch = new CountDownLatch(1);
            } catch (ExecutionException e) {  
            () -> this.permits.acquire(new ActionListener<Releasable>() {
                }
                reference.set(e);
        };
                    );  
        assertThat(permits.getActiveOperationsCount(), equalTo(0));
            } catch (final BrokenBarrierException | InterruptedException e) {
        final PlainActionFuture<Releasable> listener2 = new PlainActionFuture<>();  
                }  
                @Override
        assertThat(permits.getActiveOperationsCount(), equalTo(0));
            }
        final CountDownLatch delayedOperation = new CountDownLatch(1);
import static org.hamcrest.Matchers.emptyIterable;  
            try {
        final PlainActionFuture<Releasable> listener1 = new PlainActionFuture<>();
/*
                blockAcquired.countDown();
            assertThat(messages, hasSize(1));  
    }  
import java.util.concurrent.CountDownLatch;
            "IndexShardOperationPermitsTests",
