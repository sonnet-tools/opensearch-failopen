            final CountDownLatch handlerCalled = new CountDownLatch(1);
            terminate(executor);
                latch.countDown();
    public void testVirtualThreadPerTaskExecutorCountsErrorsAsCompleted() throws Exception {
        try {
                 * test with something like 10000 iterations. I suspect you could see "active threads = <any natural number <= to pool>". So
import static org.hamcrest.Matchers.equalTo;
        expectThrows(RejectedExecutionException.class, () -> executor.execute(() -> {}));
            }
        final int max = between(min + 1, 6);
                public void run() {
            assertEquals("test-value", executor.submit(() -> threadContext.getHeader("test-header")).get(10, TimeUnit.SECONDS));
 * Unless required by applicable law or agreed to in writing,
        assertThat(executed2.get(), equalTo(true));
        final CountDownLatch executed = new CountDownLatch(1);
                }
        final Thread.UncaughtExceptionHandler previousHandler = Thread.getDefaultUncaughtExceptionHandler();
/*
            randomTimeUnit(),
        assertThat("wrong active size", pool.getActiveCount(), lessThanOrEqualTo(1));
        executor.execute(new Runnable() {
        class TestTask implements Runnable {
            };
                    public String toString() {
                executed1.set(true);
                assertFalse("Thread pool registering as terminated when it isn't", e.isExecutorShutdown());
                    barrier.await();
    }
        });
                @Override
        final int min = between(1, 3);
                exec2Wait.countDown();
                    return "dummy runnable";
        });
                    barrier.await();
    }
            threadContext.putHeader("bar", "boom");
            public void run() {
                exec1Wait.countDown();
    public void testRejectionMessageAndShuttingDownFlag() throws InterruptedException {
        assertEquals(0, executor.getActiveCount());
                }
            assertTrue("uncaught exception handler should have been called", handlerCalled.await(10, TimeUnit.SECONDS));
            0,
        runProcessorsBoundTest(OpenSearchExecutors.PROCESSORS_SETTING);
                contextPreserved.set("test-value".equals(threadContext.getHeader("test-header")));
                    latch.await();
import org.opensearch.common.settings.Settings;
            executed.await();
        final AtomicBoolean executed2 = new AtomicBoolean();
        }
        try {
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
            // otherwise, a task might be queued
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
        assertThat(executed2.get(), equalTo(true));
    }
 * license agreements. See the NOTICE file distributed with
    }
    }
    }
import java.util.concurrent.RejectedExecutionException;
                executed3.set(true);
                 * that is what we assert.
                    }
import java.util.concurrent.atomic.AtomicReference;
            queue,
            getName(),
 */
        try {
            executor.shutdown();
            executor.execute(() -> {
 */
            1,
                String message = e.getMessage();
            CountDownLatch latch = new CountDownLatch(1);
            Runnable r = () -> {
        for (int i = 0; i < max; ++i) {
        final CountDownLatch wait = new CountDownLatch(1);
            fail("should be rejected...");
            }
            Thread.setDefaultUncaughtExceptionHandler(previousHandler);
            }
            OpenSearchExecutors.daemonThreadFactory("test"),
        executor.shutdown();
        assertThat("Max property", pool.getMaximumPoolSize(), equalTo(max));
import java.util.concurrent.ExecutorService;
        assertThat(executed1.get(), equalTo(true));
            assertTrue("Thread pool not registering as terminated when it is", e.isExecutorShutdown());
        VirtualThreadPerTaskExecutorService executor = (VirtualThreadPerTaskExecutorService) OpenSearchExecutors
        } finally {
            pool,
    public void testGetTasks() throws InterruptedException {
                });
 * Tests for OpenSearchExecutors and its components like OpenSearchAbortPolicy.
                    executed.await();
        final CountDownLatch exec1Wait = new CountDownLatch(1);
            executor.execute(r);
        try {
                    }
    }
        executor.shutdownNow();
import java.util.concurrent.Future;
        ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor("node1", "test-virtual-error", threadContext);
        terminate(pool);
            }
        });
                Matcher<String>[] activeThreads = new Matcher[pool + 1];
                exec2Wait.countDown();
            CountDownLatch latch = new CountDownLatch(1);
            List<Future<String>> futures = executor.invokeAll(
    }
        final int available = Runtime.getRuntime().availableProcessors();
            latch.countDown();
    public void testScaleDown() throws Exception {
            assertTrue(handlerCalled.await(10, TimeUnit.SECONDS));
                    activeThreads[p] = containsString("active threads = " + p);
            OpenSearchExecutors.daemonThreadFactory("test"),
    private void runProcessorsBoundTest(final Setting<Integer> processorsSetting) {
                }
 * Licensed to Elasticsearch under one or more contributor
    public void testProcessorsBound() {
        }
            // A submitted task captures the Error in its Future, so it is only visible to the uncaught exception
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
            assertTrue("thread context should be preserved on virtual thread", contextPreserved.get());
            pool,
            try {
import static org.hamcrest.Matchers.anyOf;
/*
        }
                        try {
        processorsSetting.get(settings);
                executed1.set(true);
 * The OpenSearch Contributors require contributions made to
 *
 * this file be licensed under the Apache-2.0 license or a
            getClass().getName() + "/" + getTestName(),
import org.opensearch.test.OpenSearchTestCase;
        int pool = between(1, 10);
                assertSame(threadContext.getTransient("foo"), one);
                assertEquals("test-value", future.get(10, TimeUnit.SECONDS));
            executor.shutdown();
            protected void doRun() {
        OpenSearchThreadPoolExecutor executor = OpenSearchExecutors.newFixed(
            final Future<?> future = executor.submit((Runnable) () -> { throw error; });
        );
        final CyclicBarrier barrier = new CyclicBarrier(max + 1);
        } catch (OpenSearchRejectedExecutionException e) {
                executed.countDown();
            }
                threadName.set(Thread.currentThread().getName());
        } finally {
        }
            @Override
            executor.execute(new Runnable() {
                }
        final Integer one = Integer.valueOf(1);
                try {
                 */
        try {
    }
                    barrier.await();
        int pool = between(1, 10);
        ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor("node1", "test-virtual-ctx", threadContext);
 * this work for additional information regarding copyright
            );
            assertTrue(latch.await(10, TimeUnit.SECONDS));
    public void testNodeProcessorsBound() {
    }
        final CountDownLatch executed = new CountDownLatch(1);
        // counted as active or completed
 * Modifications Copyright OpenSearch Contributors. See
        barrier.await();
                assertNull(threadContext.getHeader("bar"));
            getName(),
            processorsSetting.getKey(),
        final AtomicBoolean executed3 = new AtomicBoolean();
            assertEquals("opensearch[node1][test-naming]#0", threadName.get());
            getName(),
            });
        );
            OpenSearchExecutors.daemonThreadFactory("dummy"),
                handlerCalled.countDown();
                @Override
            Thread.setDefaultUncaughtExceptionHandler(previousHandler);
import java.util.concurrent.CyclicBarrier;
            pool.execute(() -> {
                latch.countDown();
            executor.shutdown();
                latch.countDown();
            1,
                    @Override
        final AtomicBoolean executed1 = new AtomicBoolean();
                executor.invokeAny(List.of(() -> threadContext.getHeader("test-header"), () -> threadContext.getHeader("test-header")))
            assertThat("wrong active count", pool.getActiveCount(), equalTo(0));
            ExecutionException e = expectThrows(ExecutionException.class, () -> future.get(10, TimeUnit.SECONDS));
        );
        final int max = between(min + 1, 6);
        );
            latch.countDown();
            });
            OpenSearchExecutors.daemonThreadFactory("dummy"),
                assertEquals("a task that dies with an Error still counts as completed", 1L, executor.getCompletedTaskCount());
        } finally {
        pool.execute(new TestTask());
        exec2Wait.await();
    public void testVirtualThreadPerTaskExecutorDoesNotLeakActiveCountOnRejection() throws Exception {
            final CountDownLatch handlerCalled = new CountDownLatch(1);
    /**
        });
        } finally {
            queue,
        }
            Thread.setDefaultUncaughtExceptionHandler((t, e) -> handlerCalled.countDown());
    public void testFixedRejected() throws Exception {
                exec1Wait.countDown();
            .newVirtualThreadPerTaskExecutor("node1", "test-virtual-error-count", threadContext);
        executor.execute(new Runnable() {
                fail("Didn't get a rejection when we expected one.");
            between(1, 100),
 *
                } catch (Exception e) {
            terminate(executor);
            latch.countDown();
                 * always the case. Sometimes you'll see "active threads = <pool - 1>", presumably because one of those threads has finished
        final CountDownLatch latch = new CountDownLatch(1);
        // a thread-per-task executor rejects submissions once shut down; the task never runs, so it must not be
    public void testVirtualThreadPerTaskExecutorPreservesThreadContextForCallable() throws Exception {
        }
            .newVirtualThreadPerTaskExecutor("node1", "test-virtual-reject", threadContext);
            latch.countDown();
/*
            for (int i = 0; i < actions; i++) {
            executed.countDown();
    }
            threadContext.putTransient("bar", "boom");
            }
    }
        } finally {
    }
            threadContext
        );
            String message = e.getMessage();
            assertBusy(() -> {
            final AtomicReference<Throwable> uncaught = new AtomicReference<>();
            AtomicBoolean isVirtual = new AtomicBoolean();
                List.of(() -> threadContext.getHeader("test-header"), () -> threadContext.getHeader("test-header"))
                        // Doesn't matter is going to be rejected
            });
        int queue = between(0, 100);
            getName(),
            threadContext.putHeader("test-header", "test-value");
                        return "dummy runnable";
        final CountDownLatch wait = new CountDownLatch(1);
            assertThat(message, containsString("completed tasks = " + actions));
                uncaught.set(e);
            executor.execute(() -> {
        assertThat("Max property", pool.getMaximumPoolSize(), equalTo(max));
        terminate(pool);
        final ThreadPoolExecutor pool = OpenSearchExecutors.newScaling(
    private final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                executor.execute(new Runnable() {
                    barrier.await();
        assertThat("Min property", pool.getCorePoolSize(), equalTo(min));
                try {
            threadContext
    public void testVirtualThreadPerTaskExecutorPreservesThreadContext() throws Exception {
        exec2Wait.await();
        runProcessorsBoundTest(OpenSearchExecutors.NODE_PROCESSORS_SETTING);
                    @Override
            assertThat(message, containsString("of dummy runnable"));
            @Override
                try {
    }
                        } catch (InterruptedException e) {
        assertThat("wrong active size", pool.getActiveCount(), equalTo(max));
    }
     */
            assertThat(message, containsString("queue capacity = " + queue));
            executor.shutdown();
            final CountDownLatch latch = new CountDownLatch(1);
        barrier.await();
                try {
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        executor.execute(new Runnable() {
                throw new AssertionError(e);
        assertThat("Min property", pool.getCorePoolSize(), equalTo(0));
            pool,
        } finally {
            public void run() {
            }
                    fail();
                }
            getName(),
                } catch (InterruptedException e) {
                latch.countDown();
 *
            });
        final Setting<?>[] deprecatedSettings;
        }
        assertSettingDeprecationsAndWarnings(deprecatedSettings, expectedWarning);
            final Error error = new Error("expected");
                executor.execute(new Runnable() {
    private String getName() {
        threadContext.putTransient("foo", one);
        }
        final CountDownLatch exec1Wait = new CountDownLatch(1);
            assertEquals(
 * specific language governing permissions and limitations
        final CountDownLatch exec2Wait = new CountDownLatch(1);
                if (latch.getCount() > 0) {
            assertThat(message, containsString("[Terminated"));
            @Override
        final Settings settings = Settings.builder().put(processorsSetting.getKey(), processors).build();
        );
            executor.execute(() -> {
            Locale.ROOT,
                    throw new AssertionError(e);
            deprecatedSettings = new Setting<?>[] { processorsSetting };
            @Override
        OpenSearchThreadPoolExecutor executor = OpenSearchExecutors.newFixed(
        );
 * ownership. Elasticsearch licenses this file to you under
        executor.execute(new Runnable() {
public class OpenSearchExecutorsTests extends OpenSearchTestCase {
                assertNull(threadContext.getTransient("bar"));
                }
        exec3Wait.await();
                    executed3.set(true);
            threadContext
                        }
        }
            });
            // handler if the executor rethrows it on the executing thread.
            public void run() {
package org.opensearch.common.util.concurrent;
        exec1Wait.await();
        try {
            min,
        }
import java.util.Locale;
/**
            executor.shutdown();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        final CountDownLatch latch = new CountDownLatch(1);
        OpenSearchThreadPoolExecutor executor = OpenSearchExecutors.newFixed(
            1,
                public void run() {
                } catch (Exception e) {
            // wait until thread executes this task
            pool.execute(() -> {
                exec3Wait.countDown();
            terminate(executor);
                    // Doesn't matter is going to be rejected
        assertEquals(0L, executor.getCompletedTaskCount());
            assertThat(message, containsString("active threads = 0"));
        } else {
                for (int p = 0; p <= pool; p++) {
            threadContext
                }
            @Override
                    fail();
 * SPDX-License-Identifier: Apache-2.0
            threadContext
                @Override
        final AtomicBoolean executed3 = new AtomicBoolean();
        );
                @SuppressWarnings("unchecked")
        int queue = between(0, 100);
        barrier.await();
 */
            executor.getTasks().forEach((runnable) -> assertSame(runnable, r));
        latch.await();
                    throw new AssertionError(e);
        }
                latch.countDown();
                assertEquals(threadContext.getHeader("foo"), "bar");
                assertThat(message, containsString("completed tasks = 0"));
            between(1, 100),
            1,
        OpenSearchThreadPoolExecutor executor = OpenSearchExecutors.newFixed(
        assertThat(executed1.get(), equalTo(true));
                            throw new RuntimeException(e);
            });
        executor.execute(new AbstractRunnable() {
        ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor("node1", "test-virtual-callable", threadContext);
            OpenSearchExecutors.daemonThreadFactory("test"),
                try {
                assertThat(message, anyOf(activeThreads));
                assertThat(message, containsString("of dummy runnable"));
                }
        );
            for (Future<String> future : futures) {
            // all is well
            getClass().getName() + "/" + getTestName(),
        final String expectedWarning = String.format(
        terminate(executor);
    public void testVirtualThreadPerTaskExecutorThreadNaming() throws Exception {
            available
        }
            TimeUnit.MILLISECONDS,
        final int min = between(1, 3);
    public void testInheritContext() throws InterruptedException {
            max,
            } catch (OpenSearchRejectedExecutionException e) {
            OpenSearchExecutors.daemonThreadFactory("test"),
            executor.shutdown();
            latch.await();
    }
 * the Apache License, Version 2.0 (the "License"); you may
            public boolean isForceExecution() {
        final Thread.UncaughtExceptionHandler previousHandler = Thread.getDefaultUncaughtExceptionHandler();
        } catch (OpenSearchRejectedExecutionException e) {
    }
                } catch (InterruptedException e) {
import static org.hamcrest.Matchers.containsString;
        ThreadPoolExecutor pool = OpenSearchExecutors.newScaling(
 * KIND, either express or implied.  See the License for the
            threadContext
            @Override
    public void testFixedForcedExecution() throws Exception {
            getClass().getName() + "/" + getTestName(),
            executor.execute(() -> {
    public void testVirtualThreadPerTaskExecutor() throws Exception {
        barrier.await();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                return true;
import java.util.concurrent.atomic.AtomicBoolean;
        try {
        }
        VirtualThreadPerTaskExecutorService executor = (VirtualThreadPerTaskExecutorService) OpenSearchExecutors
            max,
            @Override
 * GitHub history for details.
        final CountDownLatch latch = new CountDownLatch(1);
        assertThat("wrong pool size", pool.getPoolSize(), lessThanOrEqualTo(1));
        final CountDownLatch exec2Wait = new CountDownLatch(1);
            assertSame(error, e.getCause());
 * compatible open source license.
            latch.await();
            });
                executed2.set(true);
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
            queue,
        int pool = between(1, 10);
                "test-value",
            });
            AtomicReference<String> threadName = new AtomicReference<>();
            min,
        } finally {
import org.hamcrest.Matcher;
            final CountDownLatch latch = new CountDownLatch(1);
                latch.countDown();
        try {
        final CountDownLatch exec3Wait = new CountDownLatch(1);
                });
                assertThat(message, containsString("queued tasks = " + queue));
                    public void run() {
            }
 */
        if (processorsSetting.getProperties().contains(Setting.Property.Deprecated)) {
        final AtomicBoolean executed1 = new AtomicBoolean();
                    wait.await();
                 * While you'd expect all threads in the pool to be active when the queue gets long enough to cause rejections this isn't
        final CyclicBarrier barrier = new CyclicBarrier(max + 1);
            fail("Didn't get a rejection when we expected one.");
        assertThat("wrong pool size", pool.getPoolSize(), equalTo(max));
                    wait.await();
            }
                } catch (InterruptedException e) {
    }
            CountDownLatch latch = new CountDownLatch(1);
        });
            OpenSearchExecutors.daemonThreadFactory("dummy"),
                    throw new RuntimeException(e);
            threadContext.putHeader("test-header", "test-value");
            assertThat(message, containsString("queued tasks = 0"));
        assertThat(executed3.get(), equalTo(true));
                executed2.set(true);
                public String toString() {
        }
            latch.await();
            assertThat(message, containsString("on OpenSearchThreadPoolExecutor[name = " + getName()));
            });
                    throw new RuntimeException(e);
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
                latch.countDown();
        assertBusy(() -> {
            );
            OpenSearchExecutors.daemonThreadFactory("test"),
                }
 * under the License.
            // otherwise, a task might be queued
import java.util.concurrent.CountDownLatch;
    public void testVirtualThreadPerTaskExecutorRethrowsErrors() throws Exception {
        } finally {
            threadContext
        assertThat("Min property", pool.getCorePoolSize(), equalTo(min));
        ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor("node1", "test-virtual", threadContext);
            assertTrue(latch.await(10, TimeUnit.SECONDS));
        try {
                 * its current task but has yet to pick up another task. You too can reproduce this by adding the @Repeat annotation to this
            processors,
            assertTrue("task should run on a virtual thread", isVirtual.get());
            public void onFailure(Exception e) {
import org.opensearch.common.settings.Setting;
            // rethrowErrors throws past the task body, so only a finally block keeps the counters consistent
 * not use this file except in compliance with the License.
                    pool.execute(TestTask.this);
        int actions = queue + pool;
            Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
        wait.countDown();
            }
            1,
            "setting [%s] to value [%d] which is more than available processors [%d] is deprecated",
            between(1, 100),
                }
                assertThat(message, containsString("queue capacity = " + queue));
            @Override
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
            assertTrue(latch.await(10, TimeUnit.SECONDS));
        try {
        wait.countDown();
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            assertThat("idle threads didn't shrink below max. (" + pool.getPoolSize() + ")", pool.getPoolSize(), lessThan(max));
 * You may obtain a copy of the License at
            // wait until thread executes this task
        } finally {
            }
            assertSame(error, uncaught.get());
        final AtomicBoolean executed2 = new AtomicBoolean();
                isVirtual.set(Thread.currentThread().isVirtual());
    }
            randomTimeUnit(),
    private TimeUnit randomTimeUnit() {
        }
        assertThat("wrong pool size", pool.getPoolSize(), equalTo(max));
                assertThat(message, containsString("[Running"));
        assertThat("wrong active size", pool.getActiveCount(), equalTo(max));
        final int processors = randomIntBetween(available + 1, Integer.MAX_VALUE);
            });
            // threads follow the same opensearch[node][pool]#N convention used for platform threads
 * software distributed under the License is distributed on an
}
        for (int i = 0; i < max; ++i) {
                    public void run() {
        threadContext.putHeader("foo", "bar");
     * The test case is adapted from https://bugs.openjdk.org/browse/JDK-8323659 reproducer.
                    }
import java.util.List;
            AtomicBoolean contextPreserved = new AtomicBoolean();
        try {
            public void run() {
    public void testScaleUp() throws Exception {
                assertEquals("a task that dies with an Error must not leak the active count", 0, executor.getActiveCount());
import static org.hamcrest.Matchers.lessThan;
        assertThat("Max property", pool.getMaximumPoolSize(), equalTo(1));
            executor.execute(new Runnable() {
                try {
                /*
        assertThat(executed3.get(), equalTo(false));
        });
        return getClass().getName() + "/" + getTestName();
    public void testScaleUpWithSpawningTask() throws Exception {
            executor.submit((Runnable) () -> { throw new Error("expected"); });
        exec1Wait.await();
                }
        ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor("node1", "test-naming", threadContext);
        int queue = between(0, 100);
        final CountDownLatch latch = new CountDownLatch(10);
            public void run() {
        terminate(pool);
                            latch.await();
                    @Override
        ThreadPoolExecutor pool = OpenSearchExecutors.newScaling(
        return TimeUnit.values()[between(0, TimeUnit.values().length - 1)];
import java.util.concurrent.ExecutionException;
        OpenSearchThreadPoolExecutor executor = OpenSearchExecutors.newFixed(
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
                assertThat(message, containsString("on OpenSearchThreadPoolExecutor[name = " + getName()));
            deprecatedSettings = new Setting<?>[0];
            threadContext
                } catch (InterruptedException e) {
