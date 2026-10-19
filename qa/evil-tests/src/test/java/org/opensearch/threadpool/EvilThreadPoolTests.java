                }  
            Thread.setDefaultUncaughtExceptionHandler((t, e) -> {  
    public void testExecutionErrorOnScheduler() throws InterruptedException {  
        ForkJoinPool fjp = new ForkJoinPool();
        };
 * You may obtain a copy of the License at  
    public void testExecutionErrorOnSinglePrioritizingThreadPoolExecutor() throws InterruptedException {
        final ScheduledThreadPoolExecutor scheduler = Scheduler.initScheduler(Settings.EMPTY);
    public void testExecutionExceptionOnForkJoinPool() throws InterruptedException {  
            checkExecutionException(getExecuteRunner(autoQueueFixedExecutor), true);
            willThrow = expectException;
                executor.submit(runnable);
        try {
            Scheduler.terminate(scheduler, 10, TimeUnit.SECONDS);
        } finally {  
    public void testExecutionErrorOnScalingESThreadPoolExecutor() throws InterruptedException {  
        } finally {  
        try {
        }
    }  
            }
    }
        }
}  
        }
        for (String executor : ThreadPool.THREAD_POOL_TYPES.keySet()) {
    @After
        }
        try {
                });  
            ThreadPool.terminate(scalingExecutor, 10, TimeUnit.SECONDS);
            });  
        final Consumer<Optional<Throwable>> consumer) throws InterruptedException {  
        threadPool = new TestThreadPool(EvilThreadPoolTests.class.getName());
            o -> {
    public void setUpThreadPool() {  
                Thread.currentThread().interrupt();  
            checkExecutionException(getSubmitRunner(prioritizedExecutor), false);
    }  
    }
            ThreadPool.terminate(prioritizedExecutor, 10, TimeUnit.SECONDS);
            }
    public void testExecutionErrorOnAutoQueueFixedESThreadPoolExecutor() throws InterruptedException {
            }
            final CountDownLatch supplierLatch = new CountDownLatch(1);  
        } finally {  
            assertEquals("future error", error.getMessage());
        }
                uncaughtExceptionHandlerLatch.countDown();  
            };  
        final AtomicReference<Throwable> thrown = new AtomicReference<>();
            fjp.awaitTermination(10, TimeUnit.SECONDS);
            checkExecutionError(getScheduleRunner(executor));  
            fjp.shutdownNow();  
    }  
        }
        final OpenSearchThreadPoolExecutor fixedExecutor = OpenSearchExecutors.newFixed("test", 1, 1,
        }  
            checkExecutionException(getSubmitRunner(fjp), false);
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            checkExecutionError(getSubmitRunner(scalingExecutor));
                return "schedule(" + executor + ")";  
        final OpenSearchThreadPoolExecutor scalingExecutor = OpenSearchExecutors.newScaling("test", 1, 1,
        final OpenSearchThreadPoolExecutor fixedExecutor = OpenSearchExecutors.newFixed("test", 1, 1,
            assertTrue("Timeout waiting for ForkJoinPool task", latch.await(5, TimeUnit.SECONDS));  
            fjp.shutdownNow();
            supplierLatch.await();  
            o -> {
 * not use this file except in compliance with the License.
 *
            checkExecutionError(getSubmitRunner(autoQueueFixedExecutor));
        } finally {
                continue; // skip FORK_JOIN for these tests
            // since this is the semi-internal SafeScheduledThreadPoolExecutor that is being used,
                    assertThat(o.get(), hasToString(containsString("future exception")));  
        runExecutionTest(
            checkExecutionError(r -> prioritizedExecutor.execute(delayMillis(r, 10), TimeValue.ZERO, r));
            checkExecutionError(getExecuteRunner(threadPool.executor(executor)));
        }
        final CountDownLatch uncaughtExceptionHandlerLatch = new CountDownLatch(1);  
        } finally {
            checkExecutionError(getSubmitRunner(prioritizedExecutor));  
            ThreadPool.terminate(autoQueueFixedExecutor, 10, TimeUnit.SECONDS);  
                assertThat(o.get(), instanceOf(Error.class));
                    throw new Error("future error");  
        }  
import java.util.concurrent.ForkJoinPool;
                assertTrue(expectThrowable);
        } else {  
                throw new Error("future error");
        } finally {
public class EvilThreadPoolTests extends OpenSearchTestCase {
            checkExecutionError(getExecuteRunner(prioritizedExecutor));
                consumer.accept(Optional.of(t));
            if (ThreadPool.THREAD_POOL_TYPES.get(executor) == ThreadPool.ThreadPoolType.FORK_JOIN) {
        } finally {
            checkExecutionError(getSubmitRunner(fixedExecutor));  
        try {
                runner.accept(() -> {  
            runnable = new AbstractRunnable() {
            // bias towards no timeout.
            public String toString() {
            };
                    if (o.get() instanceof Error) throw (Error) o.get();
            @Override  
            // ForkJoinPool is skipped here because it does not support all ThreadPoolExecutor features or APIs,
    }
/*
        }  
            checkExecutionException(getExecuteRunner(threadPool.executor(executor)), true);
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
            checkExecutionException(getExecuteRunner(fjp), true);  
            willThrow,  
            r.run();
import static org.hamcrest.Matchers.containsString;  
                } finally {  
            ThreadPool.terminate(prioritizedExecutor, 10, TimeUnit.SECONDS);
                executor.execute(runnable);  
    }
                    try {
                    throw new IllegalStateException("future exception");
            OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());  
                protected void doRun() {  
        final OpenSearchThreadPoolExecutor scalingExecutor = OpenSearchExecutors.newScaling("test", 1, 1,
import java.util.Optional;
            assertTrue(error instanceof Error);
    public void testExecutionErrorOnForkJoinPool() throws Exception {
        final PrioritizedOpenSearchThreadPoolExecutor prioritizedExecutor = OpenSearchExecutors.newSinglePrioritizing("test",
        try {
    private ThreadPool threadPool;  
            // bias towards no timeout.
        };  
        final ScheduledThreadPoolExecutor scheduler = Scheduler.initScheduler(Settings.EMPTY);  
            checkExecutionError(getSubmitRunner(threadPool.executor(executor)));
            // bias towards timeout
            checkExecutionException(getSubmitRunner(fixedExecutor), false);  
            fjp.awaitTermination(10, TimeUnit.SECONDS);
                @Override
            checkExecutionException(r -> prioritizedExecutor.execute(r, TimeValue.ZERO, r), true);  
            }
        terminate(threadPool);  
        final AtomicReference<Throwable> throwableReference = new AtomicReference<>();
        };
            runner,
            }
        try {
        if (randomBoolean()) {  
            10, TimeUnit.SECONDS, OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());
            runnable = () -> {
 */  
        }
        } finally {
        logger.info("checking error for {}", runner);  
    }
import static org.hamcrest.Matchers.hasToString;
    }
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            }
                uncaughtExceptionHandlerLatch.await();  
            logger.info("checking abstract runnable exception for {}", runner);
    }
import org.opensearch.common.unit.TimeValue;
            checkExecutionException(getExecuteRunner(prioritizedExecutor), true);  
    }  
        };  
        final Runnable runnable;
                    assertThat(o.get(), instanceOf(IllegalStateException.class));
            checkExecutionException(getScheduleRunner(executor), true);  
        try {  
            runner,
            }  
            // fixed_auto_queue_size wraps stuff into TimedRunnable, which is an AbstractRunnable  
                continue; // skip FORK_JOIN for these tests
    }
        try {
            // Wait up to 5 seconds for the task to complete
 * this work for additional information regarding copyright
    Consumer<Runnable> getExecuteRunner(ExecutorService executor) {
    private void checkExecutionError(Consumer<Runnable> runner) throws InterruptedException {
                return;  
 * GitHub history for details.
        checkExecutionException(getExecuteRunner(directExecutorService), true);  
            1, 1, 1, TimeValue.timeValueSeconds(10), OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());
            checkExecutionError(r -> prioritizedExecutor.execute(r, TimeValue.ZERO, r));
            // race whether timeout or success (but typically biased towards success)  
 */
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
import org.junit.After;
 */  
    public void tearDownThreadPool() {
        final Consumer<Runnable> runner,  
 * Modifications Copyright OpenSearch Contributors. See
            1, 1, 1, TimeValue.timeValueSeconds(10), OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());
        final Runnable runnable,
            try {  
            if (ThreadPool.THREAD_POOL_TYPES.get(executor) == ThreadPool.ThreadPoolType.FORK_JOIN) {
                }
        final ExecutorService directExecutorService = OpenSearchExecutors.newDirectExecutorService();
 *    http://www.apache.org/licenses/LICENSE-2.0
            ThreadPool.terminate(scalingExecutor, 10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
        final ExecutorService directExecutorService = OpenSearchExecutors.newDirectExecutorService();
            willThrow = false;
import java.util.concurrent.ScheduledThreadPoolExecutor;
                try {
            fjp.execute(() -> {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            runnable = new AbstractRunnable() {
                assertTrue(o.isPresent());  
    @Before
            @Override
        }  
        try {
            }  
            checkExecutionError(r -> prioritizedExecutor.execute(r, TimeValue.timeValueMillis(10), r));  
    public void testExecutionExceptionOnDefaultThreadPoolTypes() throws InterruptedException {  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;  
            true,
    public void testExecutionErrorOnFixedESThreadPoolExecutor() throws InterruptedException {
            } catch (Throwable t) {
 * KIND, either express or implied.  See the License for the
    public void testExecutionExceptionOnFixedESThreadPoolExecutor() throws InterruptedException {
                protected void doRun() {
 * The OpenSearch Contributors require contributions made to  
        } finally {  
        } else {  
                threadPool.schedule(runnable, randomFrom(TimeValue.ZERO, TimeValue.timeValueMillis(1)), executor);
            OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext(), threadPool.scheduler());
 * ownership. Elasticsearch licenses this file to you under  
import java.util.function.Consumer;
            if (expectThrowable) {
            checkExecutionError(r -> scheduler.schedule(r, randomFrom(0, 1), TimeUnit.MILLISECONDS));
            });  
        if (randomBoolean()) {
                        supplierLatch.countDown();
            @Override
    }  
                return "executor(" + executor + ").execute()";
    }
    }
        runExecutionTest(  
                }
            // here, it's ok for the exception not to bubble up. Accessing the future will yield the exception  
            public String toString() {  
        for (String executor : ThreadPool.THREAD_POOL_TYPES.keySet()) {
            // and is tested separately in testExecutionErrorOnForkJoinPool.  
            // ForkJoinPool is skipped here because it does not support all ThreadPoolExecutor features or APIs,
                public void onFailure(Exception e) {  
            public void accept(Runnable runnable) {
 *  
 * specific language governing permissions and limitations
        return new Consumer<Runnable>() {  
    private Runnable delayMillis(Runnable r, int ms) {
            runnable = () -> {  
                    throw new Error("future error");  
            runnable,
            }
                    thrown.set(t);
        }  
        } finally {
    private void checkExecutionException(Consumer<Runnable> runner, boolean expectException) throws InterruptedException {  
            @Override  
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
                throw new IllegalStateException("future exception");  
                return "executor(" + executor + ").submit()";
            ThreadPool.terminate(autoQueueFixedExecutor, 10, TimeUnit.SECONDS);
    }  
            public String toString() {
    }
            ThreadPool.terminate(fixedExecutor, 10, TimeUnit.SECONDS);
            checkExecutionError(getExecuteRunner(autoQueueFixedExecutor));  
    }
import static org.hamcrest.Matchers.instanceOf;
            logger.info("checking direct exception for {}", runner);
            Throwable error = thrown.get();
                    }
    public void testExecutionExceptionOnScheduler() throws InterruptedException {
                    latch.countDown();
            OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());  
        final Runnable runnable;
            checkExecutionException(r -> prioritizedExecutor.execute(delayMillis(r, 10), TimeValue.ZERO, r), true);
        final OpenSearchThreadPoolExecutor autoQueueFixedExecutor = OpenSearchExecutors.newAutoQueueFixed("test", 1, 1,  
        final OpenSearchThreadPoolExecutor autoQueueFixedExecutor = OpenSearchExecutors.newAutoQueueFixed("test", 1, 1,  
            // which also logs exceptions for schedule calls.
                        runnable.run();
            checkExecutionException(getExecuteRunner(scheduler), true);
            public void accept(Runnable runnable) {  
        final CountDownLatch latch = new CountDownLatch(1);
        checkExecutionError(getExecuteRunner(directExecutorService));  
        final boolean expectThrowable,
            checkExecutionException(getSubmitRunner(scheduler), true);  
        return () -> {
        try {
import java.util.concurrent.atomic.AtomicReference;  
/*  
                }
            };
        }
            // and is tested separately in testExecutionErrorOnForkJoinPool.  
                    } finally {  
            // bias towards timeout  
 * SPDX-License-Identifier: Apache-2.0
            };
import java.util.concurrent.TimeUnit;  
    }
            Scheduler.terminate(scheduler, 10, TimeUnit.SECONDS);  
            }  
            OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext(), threadPool.scheduler());  
        try {  
                assertEquals(willThrow, o.isPresent());
            checkExecutionException(r -> scheduler.schedule(r, randomFrom(0, 1), TimeUnit.MILLISECONDS), true);
    public void testExecutionExceptionOnDirectExecutorService() throws InterruptedException {
                Thread.sleep(ms);
            ThreadPool.terminate(fixedExecutor, 10, TimeUnit.SECONDS);
    public void testExecutionExceptionOnSinglePrioritizingThreadPoolExecutor() throws InterruptedException {
                } catch (Throwable t) {
    }
    }  
        try {  
                assertTrue("Only one message allowed", throwableReference.compareAndSet(null, e));
 * Licensed to Elasticsearch under one or more contributor  
import java.util.concurrent.CountDownLatch;  
        final boolean willThrow;
                @Override
            public void accept(Runnable runnable) {
    public void testExecutionExceptionOnScalingESThreadPoolExecutor() throws InterruptedException {  
    public void testExecutionErrorOnDefaultThreadPoolTypes() throws InterruptedException {  
            consumer.accept(Optional.ofNullable(throwableReference.get()));  
        }
            @Override
        }
                public void onFailure(Exception e) {
                if (willThrow) {  
    public void testExecutionExceptionOnAutoQueueFixedESThreadPoolExecutor() throws InterruptedException {
package org.opensearch.threadpool;
        } finally {
            checkExecutionError(getExecuteRunner(fixedExecutor));
            checkExecutionException(getExecuteRunner(scalingExecutor), true);
            10, TimeUnit.SECONDS, OpenSearchExecutors.daemonThreadFactory("test"), threadPool.getThreadContext());
 * under the License.  
                }
                }
            try {
            // while submit does return a Future, we choose to log exceptions anyway,  
 *
        final PrioritizedOpenSearchThreadPoolExecutor prioritizedExecutor = OpenSearchExecutors.newSinglePrioritizing("test",  
            runnable,  
import org.opensearch.common.settings.Settings;
            checkExecutionError(getExecuteRunner(scalingExecutor));
        } finally {  
            checkExecutionException(getSubmitRunner(threadPool.executor(executor)), false);
            });
    }  
import org.junit.Before;  
        }  
                @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            checkExecutionException(getExecuteRunner(fixedExecutor), true);
        ForkJoinPool fjp = new ForkJoinPool(8);  
                @Override  
 * compatible open source license.
        try {
            checkExecutionException(getSubmitRunner(scalingExecutor), false);
    Consumer<Runnable> getScheduleRunner(String executor) {  
            checkExecutionException(r -> prioritizedExecutor.execute(r, TimeValue.timeValueMillis(10), r), true);
        } finally {  
            }  
    public void testExecutionErrorOnDirectExecutorService() throws InterruptedException {
            checkExecutionError(getExecuteRunner(scheduler));  
        checkExecutionError(getSubmitRunner(directExecutorService));
            checkExecutionException(getSubmitRunner(autoQueueFixedExecutor), false);
    }
        return new Consumer<Runnable>() {
                assertThat(o.get(), hasToString(containsString("future error")));
        return new Consumer<Runnable>() {
    private void runExecutionTest(
            });
            // race whether timeout or success (but typically biased towards success)
    Consumer<Runnable> getSubmitRunner(ExecutorService executor) {
 * Unless required by applicable law or agreed to in writing,
        checkExecutionException(getSubmitRunner(directExecutorService), false);
import java.util.concurrent.ExecutorService;
            @Override
    }
            assertNotNull("No error captured from ForkJoinPool task", error);  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            checkExecutionError(getSubmitRunner(scheduler));
/*  
    }
