            if (expectThrowable) {
            }
            public void accept(Runnable runnable) {
            checkExecutionError(getExecuteRunner(scalingExecutor));
            willThrow,
                Thread.currentThread().interrupt();
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
                throw new Error("future error");
            1, 1, 1, TimeValue.timeValueSeconds(10), OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());
            checkExecutionException(getExecuteRunner(fjp), true);
/*
            checkExecutionError(getExecuteRunner(threadPool.executor(executor)));
            checkExecutionException(getSubmitRunner(prioritizedExecutor), false);
            OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());
        terminate(threadPool);
            }
            checkExecutionException(getExecuteRunner(prioritizedExecutor), true);
import org.opensearch.common.util.concurrent.AbstractRunnable;
            @Override
import java.util.function.Consumer;
    }
    public void testExecutionErrorOnAutoQueueFixedESThreadPoolExecutor() throws InterruptedException {
        }
        ForkJoinPool fjp = new ForkJoinPool();
                @Override
            checkExecutionError(getSubmitRunner(scalingExecutor));
        return new Consumer<Runnable>() {
        final Consumer<Optional<Throwable>> consumer) throws InterruptedException {
            checkExecutionException(getSubmitRunner(scheduler), true);
    private ThreadPool threadPool;
                        runnable.run();
            fjp.shutdownNow();
        try {
 * KIND, either express or implied.  See the License for the
                } catch (Throwable t) {
            ThreadPool.terminate(fixedExecutor, 10, TimeUnit.SECONDS);
    }
            checkExecutionException(getExecuteRunner(scheduler), true);
        } finally {
    }
import java.util.Optional;
 * compatible open source license.
                return "schedule(" + executor + ")";
        return new Consumer<Runnable>() {
import static org.hamcrest.Matchers.instanceOf;
        } finally {
                continue; // skip FORK_JOIN for these tests
        }
        runExecutionTest(
            @Override
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
 *
    Consumer<Runnable> getExecuteRunner(ExecutorService executor) {
        } finally {
            checkExecutionException(r -> prioritizedExecutor.execute(r, TimeValue.timeValueMillis(10), r), true);
        final OpenSearchThreadPoolExecutor autoQueueFixedExecutor = OpenSearchExecutors.newAutoQueueFixed("test", 1, 1,
                protected void doRun() {
        final ExecutorService directExecutorService = OpenSearchExecutors.newDirectExecutorService();
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        final OpenSearchThreadPoolExecutor fixedExecutor = OpenSearchExecutors.newFixed("test", 1, 1,
                @Override
        final CountDownLatch latch = new CountDownLatch(1);
            Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
        } finally {
            o -> {
            ThreadPool.terminate(prioritizedExecutor, 10, TimeUnit.SECONDS);
    }
            public String toString() {
            }
    public void testExecutionErrorOnScheduler() throws InterruptedException {
        final ScheduledThreadPoolExecutor scheduler = Scheduler.initScheduler(Settings.EMPTY);
        } else {
                    latch.countDown();
            }
                protected void doRun() {
            assertNotNull("No error captured from ForkJoinPool task", error);
        final Consumer<Runnable> runner,
                    assertThat(o.get(), hasToString(containsString("future exception")));
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testExecutionExceptionOnFixedESThreadPoolExecutor() throws InterruptedException {
        if (randomBoolean()) {
        checkExecutionException(getExecuteRunner(directExecutorService), true);
            // bias towards timeout
        try {
    }
        try {
        }
            @Override
import org.junit.After;
/*
        final OpenSearchThreadPoolExecutor fixedExecutor = OpenSearchExecutors.newFixed("test", 1, 1,
            Throwable error = thrown.get();
            };
            public void accept(Runnable runnable) {
 */
                consumer.accept(Optional.of(t));
                @Override
        final boolean expectThrowable,
                    thrown.set(t);
            true,
        try {
            assertTrue(error instanceof Error);
import org.opensearch.test.OpenSearchTestCase;
            logger.info("checking direct exception for {}", runner);
        }
    }
            // and is tested separately in testExecutionErrorOnForkJoinPool.
        final OpenSearchThreadPoolExecutor scalingExecutor = OpenSearchExecutors.newScaling("test", 1, 1,
                }
    public void testExecutionErrorOnDirectExecutorService() throws InterruptedException {
 * Unless required by applicable law or agreed to in writing,
            });
                    } finally {
                if (willThrow) {
                    throw new Error("future error");
                });
            };
            });
                assertTrue(o.isPresent());
import java.util.concurrent.TimeUnit;
    }
            runnable = new AbstractRunnable() {
    }
                assertTrue("Only one message allowed", throwableReference.compareAndSet(null, e));
            OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());
    public void testExecutionExceptionOnScheduler() throws InterruptedException {
    public void testExecutionErrorOnFixedESThreadPoolExecutor() throws InterruptedException {
        }
            runnable,
        } finally {
            10, TimeUnit.SECONDS, OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());
import java.util.concurrent.ScheduledThreadPoolExecutor;
        }
            public String toString() {
            @Override
                @Override
                }
        } else {
            runner,
        };
            }
import org.opensearch.common.unit.TimeValue;
            ThreadPool.terminate(autoQueueFixedExecutor, 10, TimeUnit.SECONDS);
        final PrioritizedOpenSearchThreadPoolExecutor prioritizedExecutor = OpenSearchExecutors.newSinglePrioritizing("test",
        final Runnable runnable;
    }
                } finally {
                return;
            checkExecutionException(getExecuteRunner(fixedExecutor), true);
            });
            checkExecutionError(r -> scheduler.schedule(r, randomFrom(0, 1), TimeUnit.MILLISECONDS));
            willThrow = expectException;
            fjp.execute(() -> {
        final boolean willThrow;
        };
            ThreadPool.terminate(prioritizedExecutor, 10, TimeUnit.SECONDS);
                }
            // bias towards timeout
            logger.info("checking abstract runnable exception for {}", runner);
import org.opensearch.common.settings.Settings;
            Scheduler.terminate(scheduler, 10, TimeUnit.SECONDS);
            OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext(), threadPool.scheduler());
                    assertThat(o.get(), instanceOf(IllegalStateException.class));
    public void testExecutionExceptionOnForkJoinPool() throws InterruptedException {
            // since this is the semi-internal SafeScheduledThreadPoolExecutor that is being used,
            checkExecutionException(getSubmitRunner(fixedExecutor), false);
            ThreadPool.terminate(autoQueueFixedExecutor, 10, TimeUnit.SECONDS);
        final ScheduledThreadPoolExecutor scheduler = Scheduler.initScheduler(Settings.EMPTY);
            assertTrue("Timeout waiting for ForkJoinPool task", latch.await(5, TimeUnit.SECONDS));
import static org.hamcrest.Matchers.containsString;
 * Licensed to Elasticsearch under one or more contributor
}
            try {
        } finally {
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
 * software distributed under the License is distributed on an
        final Runnable runnable;
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
            }
import java.util.concurrent.atomic.AtomicReference;
        final OpenSearchThreadPoolExecutor autoQueueFixedExecutor = OpenSearchExecutors.newAutoQueueFixed("test", 1, 1,
            runnable = () -> {
            1, 1, 1, TimeValue.timeValueSeconds(10), OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());
                }
            runnable,
            // ForkJoinPool is skipped here because it does not support all ThreadPoolExecutor features or APIs,
            public void accept(Runnable runnable) {
        final OpenSearchThreadPoolExecutor scalingExecutor = OpenSearchExecutors.newScaling("test", 1, 1,
            // Wait up to 5 seconds for the task to complete
 * under the License.
        }
        try {
            fjp.awaitTermination(10, TimeUnit.SECONDS);
        try {
import org.junit.Before;
            assertEquals("future error", error.getMessage());
    }
    }
        } finally {
            checkExecutionError(r -> prioritizedExecutor.execute(r, TimeValue.timeValueMillis(10), r));
            ThreadPool.terminate(scalingExecutor, 10, TimeUnit.SECONDS);
                    try {
    public void tearDownThreadPool() {
    }
    }
            checkExecutionError(r -> prioritizedExecutor.execute(r, TimeValue.ZERO, r));
            10, TimeUnit.SECONDS, OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());
    private void checkExecutionException(Consumer<Runnable> runner, boolean expectException) throws InterruptedException {
    }
                executor.submit(runnable);
 * this file be licensed under the Apache-2.0 license or a
        try {
    private void runExecutionTest(
    public void testExecutionErrorOnDefaultThreadPoolTypes() throws InterruptedException {
    }
            // fixed_auto_queue_size wraps stuff into TimedRunnable, which is an AbstractRunnable
        try {
    private Runnable delayMillis(Runnable r, int ms) {
    }
        } finally {
            checkExecutionError(getSubmitRunner(autoQueueFixedExecutor));
 * license agreements. See the NOTICE file distributed with
 */
                return "executor(" + executor + ").submit()";
        } finally {
            checkExecutionException(r -> scheduler.schedule(r, randomFrom(0, 1), TimeUnit.MILLISECONDS), true);
        final PrioritizedOpenSearchThreadPoolExecutor prioritizedExecutor = OpenSearchExecutors.newSinglePrioritizing("test",
            final CountDownLatch supplierLatch = new CountDownLatch(1);
                }
            checkExecutionError(getSubmitRunner(scheduler));
        }
                    throw new IllegalStateException("future exception");
 * ownership. Elasticsearch licenses this file to you under
import java.util.concurrent.CountDownLatch;
            }
    }
            }
        for (String executor : ThreadPool.THREAD_POOL_TYPES.keySet()) {
            checkExecutionException(getExecuteRunner(scalingExecutor), true);
        return () -> {
        logger.info("checking error for {}", runner);
            r.run();
    public void testExecutionExceptionOnScalingESThreadPoolExecutor() throws InterruptedException {
            checkExecutionException(getSubmitRunner(fjp), false);
    public void testExecutionErrorOnSinglePrioritizingThreadPoolExecutor() throws InterruptedException {
import java.util.concurrent.ExecutorService;
    }
 * the Apache License, Version 2.0 (the "License"); you may
            fjp.shutdownNow();
        } finally {
            @Override
    public void testExecutionExceptionOnDefaultThreadPoolTypes() throws InterruptedException {
            };
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.hasToString;
                executor.execute(runnable);
            checkExecutionException(r -> prioritizedExecutor.execute(r, TimeValue.ZERO, r), true);
            supplierLatch.await();
 * specific language governing permissions and limitations
        };
    }
            checkExecutionError(getExecuteRunner(fixedExecutor));
                    throw new Error("future error");
                assertThat(o.get(), hasToString(containsString("future error")));
            runner,
            checkExecutionError(getSubmitRunner(threadPool.executor(executor)));
            checkExecutionError(getExecuteRunner(scheduler));
 *
        final ExecutorService directExecutorService = OpenSearchExecutors.newDirectExecutorService();
    }
            // ForkJoinPool is skipped here because it does not support all ThreadPoolExecutor features or APIs,
 * You may obtain a copy of the License at
            checkExecutionException(r -> prioritizedExecutor.execute(delayMillis(r, 10), TimeValue.ZERO, r), true);
                public void onFailure(Exception e) {
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                    }
        return new Consumer<Runnable>() {
    @After
        final CountDownLatch uncaughtExceptionHandlerLatch = new CountDownLatch(1);
                public void onFailure(Exception e) {
                Thread.sleep(ms);
        try {
            checkExecutionError(getExecuteRunner(autoQueueFixedExecutor));
            } catch (InterruptedException e) {
            // here, it's ok for the exception not to bubble up. Accessing the future will yield the exception
            @Override
        }
        checkExecutionError(getExecuteRunner(directExecutorService));
    public void testExecutionErrorOnForkJoinPool() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
    public void setUpThreadPool() {
 * this work for additional information regarding copyright
 *
                continue; // skip FORK_JOIN for these tests
 * Modifications Copyright OpenSearch Contributors. See
        }
            checkExecutionError(getScheduleRunner(executor));
            checkExecutionException(getExecuteRunner(autoQueueFixedExecutor), true);
            public String toString() {
    public void testExecutionErrorOnScalingESThreadPoolExecutor() throws InterruptedException {
        checkExecutionException(getSubmitRunner(directExecutorService), false);
                throw new IllegalStateException("future exception");
            // bias towards no timeout.
        ForkJoinPool fjp = new ForkJoinPool(8);
 * GitHub history for details.
        };
            }
                assertThat(o.get(), instanceOf(Error.class));
            if (ThreadPool.THREAD_POOL_TYPES.get(executor) == ThreadPool.ThreadPoolType.FORK_JOIN) {
        }
    Consumer<Runnable> getSubmitRunner(ExecutorService executor) {
            // which also logs exceptions for schedule calls.
    }
            // race whether timeout or success (but typically biased towards success)
        }
        final Runnable runnable,
            try {
                assertEquals(willThrow, o.isPresent());
        runExecutionTest(
    public void testExecutionExceptionOnDirectExecutorService() throws InterruptedException {
                runner.accept(() -> {
            // while submit does return a Future, we choose to log exceptions anyway,
            checkExecutionError(getExecuteRunner(prioritizedExecutor));
        checkExecutionError(getSubmitRunner(directExecutorService));
    }
            }
            checkExecutionException(getExecuteRunner(threadPool.executor(executor)), true);
            checkExecutionError(getSubmitRunner(prioritizedExecutor));
        }
    private void checkExecutionError(Consumer<Runnable> runner) throws InterruptedException {
                uncaughtExceptionHandlerLatch.countDown();
            checkExecutionError(r -> prioritizedExecutor.execute(delayMillis(r, 10), TimeValue.ZERO, r));
            checkExecutionException(getSubmitRunner(threadPool.executor(executor)), false);
            if (ThreadPool.THREAD_POOL_TYPES.get(executor) == ThreadPool.ThreadPoolType.FORK_JOIN) {
        } finally {
            };
            consumer.accept(Optional.ofNullable(throwableReference.get()));
            // bias towards no timeout.
public class EvilThreadPoolTests extends OpenSearchTestCase {
            });
    }
                return "executor(" + executor + ").execute()";
    public void testExecutionExceptionOnSinglePrioritizingThreadPoolExecutor() throws InterruptedException {
                    if (o.get() instanceof Error) throw (Error) o.get();
                threadPool.schedule(runnable, randomFrom(TimeValue.ZERO, TimeValue.timeValueMillis(1)), executor);
            o -> {
            } catch (Throwable t) {
            checkExecutionException(getSubmitRunner(autoQueueFixedExecutor), false);
            checkExecutionException(getScheduleRunner(executor), true);
            runnable = () -> {
                assertTrue(expectThrowable);
            Scheduler.terminate(scheduler, 10, TimeUnit.SECONDS);
    }
        try {
                try {
            ThreadPool.terminate(scalingExecutor, 10, TimeUnit.SECONDS);
                }
            fjp.awaitTermination(10, TimeUnit.SECONDS);
        }
            ThreadPool.terminate(fixedExecutor, 10, TimeUnit.SECONDS);
    @Before
        for (String executor : ThreadPool.THREAD_POOL_TYPES.keySet()) {
        }
            // race whether timeout or success (but typically biased towards success)
        } finally {
            checkExecutionError(getSubmitRunner(fixedExecutor));
            // and is tested separately in testExecutionErrorOnForkJoinPool.
        threadPool = new TestThreadPool(EvilThreadPoolTests.class.getName());
        } finally {
        try {
import java.util.concurrent.ForkJoinPool;
        }
        try {
            OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext(), threadPool.scheduler());
        final AtomicReference<Throwable> thrown = new AtomicReference<>();
                uncaughtExceptionHandlerLatch.await();
            runnable = new AbstractRunnable() {
 * The OpenSearch Contributors require contributions made to
            willThrow = false;
                        supplierLatch.countDown();
/*
package org.opensearch.threadpool;
            checkExecutionException(getSubmitRunner(scalingExecutor), false);
        if (randomBoolean()) {
    Consumer<Runnable> getScheduleRunner(String executor) {
    }
        try {
            }
    public void testExecutionExceptionOnAutoQueueFixedESThreadPoolExecutor() throws InterruptedException {
