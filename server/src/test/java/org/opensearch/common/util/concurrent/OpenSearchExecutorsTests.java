     */
        final Settings settings = Settings.builder().put(processorsSetting.getKey(), processors).build();
            threadContext
            });
        final Thread.UncaughtExceptionHandler previousHandler = Thread.getDefaultUncaughtExceptionHandler();
                executor.execute(new Runnable() {
        final AtomicBoolean executed3 = new AtomicBoolean();  
}
        assertThat("wrong pool size", pool.getPoolSize(), lessThanOrEqualTo(1));
        try {
                assertNull(threadContext.getHeader("bar"));
        int actions = queue + pool;
                assertEquals("a task that dies with an Error still counts as completed", 1L, executor.getCompletedTaskCount());
import java.util.concurrent.RejectedExecutionException;
        final int min = between(1, 3);
            OpenSearchExecutors.daemonThreadFactory("dummy"),
        try {
import java.util.concurrent.atomic.AtomicReference;  
        );
        terminate(pool);  
        } finally {  
                latch.countDown();
                    }  
import static org.hamcrest.Matchers.containsString;  
        expectThrows(RejectedExecutionException.class, () -> executor.execute(() -> {}));
        } catch (OpenSearchRejectedExecutionException e) {  
                public String toString() {  
            }  
            getClass().getName() + "/" + getTestName(),
            latch.await();
            pool,
    }
        final CountDownLatch latch = new CountDownLatch(1);  
                }
            threadContext  
                assertThat(message, containsString("queued tasks = " + queue));  
            @Override  
                    @Override
        try {  
            executor.execute(() -> {
            AtomicReference<String> threadName = new AtomicReference<>();
                threadName.set(Thread.currentThread().getName());
                assertThat(message, containsString("queue capacity = " + queue));  
                throw new AssertionError(e);
        terminate(pool);
        final CountDownLatch latch = new CountDownLatch(10);
import java.util.Locale;
            OpenSearchExecutors.daemonThreadFactory("test"),
                    executed3.set(true);
 */  
                        return "dummy runnable";  
                    @Override
            assertSame(error, uncaught.get());
                executed1.set(true);  
        }  
            getName(),  
            Runnable r = () -> {
                assertNull(threadContext.getTransient("bar"));
            List<Future<String>> futures = executor.invokeAll(
            between(1, 100),
                    latch.await();
            assertEquals("opensearch[node1][test-naming]#0", threadName.get());  
import org.opensearch.test.OpenSearchTestCase;
            assertThat(message, containsString("on OpenSearchThreadPoolExecutor[name = " + getName()));  
            0,  
        int pool = between(1, 10);  
        VirtualThreadPerTaskExecutorService executor = (VirtualThreadPerTaskExecutorService) OpenSearchExecutors
                handlerCalled.countDown();
        );
                assertEquals("test-value", future.get(10, TimeUnit.SECONDS));
                assertThat(message, containsString("of dummy runnable"));
        VirtualThreadPerTaskExecutorService executor = (VirtualThreadPerTaskExecutorService) OpenSearchExecutors
/*  
            threadContext
            Locale.ROOT,
        exec1Wait.await();
import java.util.concurrent.CountDownLatch;  
    }
                } catch (Exception e) {  
            // threads follow the same opensearch[node][pool]#N convention used for platform threads
            }
            Thread.setDefaultUncaughtExceptionHandler((t, e) -> handlerCalled.countDown());
                return true;  
        }
            executed.await();
            @Override
        int queue = between(0, 100);  
    public void testScaleUpWithSpawningTask() throws Exception {  
            1,
        barrier.await();
        try {
            threadContext
        ThreadPoolExecutor pool = OpenSearchExecutors.newScaling(  
    public void testVirtualThreadPerTaskExecutorCountsErrorsAsCompleted() throws Exception {
        } finally {
        assertThat("Max property", pool.getMaximumPoolSize(), equalTo(max));  
            threadContext.putHeader("test-header", "test-value");
            try {  
                        try {
                executed2.set(true);
 * GitHub history for details.
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));  
            Thread.setDefaultUncaughtExceptionHandler(previousHandler);
        try {  
                }  
import java.util.concurrent.ExecutorService;  
/**
import static org.hamcrest.Matchers.lessThan;
            final CountDownLatch handlerCalled = new CountDownLatch(1);  
            }
            } catch (OpenSearchRejectedExecutionException e) {
            CountDownLatch latch = new CountDownLatch(1);
                    wait.await();  
        OpenSearchThreadPoolExecutor executor = OpenSearchExecutors.newFixed(
            // otherwise, a task might be queued  
                executed3.set(true);  
            assertEquals(
public class OpenSearchExecutorsTests extends OpenSearchTestCase {
            executor.getTasks().forEach((runnable) -> assertSame(runnable, r));  
 * specific language governing permissions and limitations
            between(1, 100),
                assertEquals("a task that dies with an Error must not leak the active count", 0, executor.getActiveCount());
        wait.countDown();  
            pool.execute(() -> {
            });  
                            latch.await();
            @Override
 * license agreements. See the NOTICE file distributed with
                String message = e.getMessage();  
            min,
        final CountDownLatch exec2Wait = new CountDownLatch(1);  
    public void testVirtualThreadPerTaskExecutorPreservesThreadContext() throws Exception {
        }
    }
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
                @SuppressWarnings("unchecked")  
            getClass().getName() + "/" + getTestName(),  
                uncaught.set(e);  
        );  
        executor.shutdownNow();
                    throw new RuntimeException(e);
            1,
            assertThat(message, containsString("[Terminated"));
    }  
    }  
import java.util.concurrent.CyclicBarrier;
    public void testGetTasks() throws InterruptedException {
        barrier.await();
            executed.countDown();
            threadContext.putTransient("bar", "boom");
        try {
                    barrier.await();
        final CountDownLatch latch = new CountDownLatch(1);
            executor.execute(() -> {
                    barrier.await();
            threadContext
    }
            OpenSearchExecutors.daemonThreadFactory("dummy"),
        assertThat("wrong active size", pool.getActiveCount(), equalTo(max));  
            AtomicBoolean isVirtual = new AtomicBoolean();  
            assertTrue(latch.await(10, TimeUnit.SECONDS));
    }
                assertThat(message, anyOf(activeThreads));
            public void run() {  
        for (int i = 0; i < max; ++i) {  
        );
                    activeThreads[p] = containsString("active threads = " + p);  
    /**  
                assertThat(message, containsString("completed tasks = 0"));
            max,
            }  
            randomTimeUnit(),
                contextPreserved.set("test-value".equals(threadContext.getHeader("test-header")));
                    throw new AssertionError(e);
        final CyclicBarrier barrier = new CyclicBarrier(max + 1);  
                try {
            1,
            );
        int pool = between(1, 10);
    public void testVirtualThreadPerTaskExecutorThreadNaming() throws Exception {
            latch.await();
            processorsSetting.getKey(),
        wait.countDown();
import java.util.concurrent.TimeUnit;
                    // Doesn't matter is going to be rejected
            1,
            });  
            // handler if the executor rethrows it on the executing thread.  
import java.util.concurrent.Future;
 * this work for additional information regarding copyright
        ThreadPoolExecutor pool = OpenSearchExecutors.newScaling(
        } else {
            deprecatedSettings = new Setting<?>[0];
        final CountDownLatch exec3Wait = new CountDownLatch(1);
        assertThat("Min property", pool.getCorePoolSize(), equalTo(0));
                        }
            public void run() {
        pool.execute(new TestTask());
                }
                @Override  
        assertThat(executed1.get(), equalTo(true));  
/*  
        OpenSearchThreadPoolExecutor executor = OpenSearchExecutors.newFixed(  
        assertThat("Max property", pool.getMaximumPoolSize(), equalTo(max));
            });
            assertTrue("thread context should be preserved on virtual thread", contextPreserved.get());  
            latch.countDown();
        }  
        executor.execute(new Runnable() {
            }
            assertEquals("test-value", executor.submit(() -> threadContext.getHeader("test-header")).get(10, TimeUnit.SECONDS));
            min,
                    wait.await();
            1,  
            assertThat(message, containsString("queued tasks = 0"));
    }  
        processorsSetting.get(settings);  
                } catch (InterruptedException e) {
 * KIND, either express or implied.  See the License for the
        final int max = between(min + 1, 6);
    }
                exec3Wait.countDown();
 * Tests for OpenSearchExecutors and its components like OpenSearchAbortPolicy.  
            executor.shutdown();
                            throw new RuntimeException(e);
                "test-value",  
import java.util.List;
            assertTrue(latch.await(10, TimeUnit.SECONDS));
        final ThreadPoolExecutor pool = OpenSearchExecutors.newScaling(
    }
                latch.countDown();  
        try {
 * ownership. Elasticsearch licenses this file to you under  
            assertSame(error, e.getCause());  
        latch.await();  
    }
        exec1Wait.await();  
    public void testScaleUp() throws Exception {
            .newVirtualThreadPerTaskExecutor("node1", "test-virtual-error-count", threadContext);  
        }  
            assertThat(message, containsString("active threads = 0"));  
import org.opensearch.common.settings.Setting;
        } finally {
        int queue = between(0, 100);
        } finally {
            executor.shutdown();
        );  
import java.util.concurrent.ExecutionException;
        assertThat(executed2.get(), equalTo(true));
                    barrier.await();  
        OpenSearchThreadPoolExecutor executor = OpenSearchExecutors.newFixed(  
            executor.execute(() -> {
                }
    public void testFixedRejected() throws Exception {
        assertSettingDeprecationsAndWarnings(deprecatedSettings, expectedWarning);
        executor.execute(new Runnable() {
            threadContext  
            }  
            protected void doRun() {
                assertFalse("Thread pool registering as terminated when it isn't", e.isExecutorShutdown());
                fail("Didn't get a rejection when we expected one.");  
            OpenSearchExecutors.daemonThreadFactory("dummy"),
            assertTrue(latch.await(10, TimeUnit.SECONDS));
        });
 * Modifications Copyright OpenSearch Contributors. See
    }
        for (int i = 0; i < max; ++i) {
        int pool = between(1, 10);
            getName(),
            OpenSearchExecutors.daemonThreadFactory("test"),  
        executor.execute(new Runnable() {
            queue,
                    throw new RuntimeException(e);
            @Override  
        });
            });
    }
        ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor("node1", "test-virtual", threadContext);  
        assertThat(executed2.get(), equalTo(true));
        ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor("node1", "test-virtual-ctx", threadContext);
                    executed.await();
        try {
        final CyclicBarrier barrier = new CyclicBarrier(max + 1);
 * Licensed to Elasticsearch under one or more contributor  
                Matcher<String>[] activeThreads = new Matcher[pool + 1];
                    fail();
        executor.shutdown();  
            // otherwise, a task might be queued
                isVirtual.set(Thread.currentThread().isVirtual());
 *
            pool.execute(() -> {
        int queue = between(0, 100);
            });
                    public void run() {  
                }
    public void testVirtualThreadPerTaskExecutorPreservesThreadContextForCallable() throws Exception {
                executed1.set(true);
        assertThat(executed1.get(), equalTo(true));  
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));  
 * not use this file except in compliance with the License.
            // wait until thread executes this task  
            assertBusy(() -> {  
    }
        return getClass().getName() + "/" + getTestName();
            getName(),
                exec2Wait.countDown();
    private void runProcessorsBoundTest(final Setting<Integer> processorsSetting) {
            latch.countDown();
            assertTrue(handlerCalled.await(10, TimeUnit.SECONDS));  
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));  
            threadContext
            Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
                @Override  
                executor.execute(new Runnable() {
        } finally {
                }
            executor.execute(() -> {  
        barrier.await();
        }
    public void testProcessorsBound() {
import static org.hamcrest.Matchers.equalTo;
                @Override
            terminate(executor);
            final CountDownLatch latch = new CountDownLatch(1);  
 */
        final AtomicBoolean executed2 = new AtomicBoolean();
        runProcessorsBoundTest(OpenSearchExecutors.PROCESSORS_SETTING);
        } finally {  
        threadContext.putHeader("foo", "bar");  
            .newVirtualThreadPerTaskExecutor("node1", "test-virtual-reject", threadContext);
        OpenSearchThreadPoolExecutor executor = OpenSearchExecutors.newFixed(  
    public void testVirtualThreadPerTaskExecutorRethrowsErrors() throws Exception {
    public void testRejectionMessageAndShuttingDownFlag() throws InterruptedException {
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
        final Setting<?>[] deprecatedSettings;
 */
                executed2.set(true);
/*
                latch.countDown();
    public void testVirtualThreadPerTaskExecutor() throws Exception {
        try {
            public void run() {
            String message = e.getMessage();
 * this file be licensed under the Apache-2.0 license or a
                exec1Wait.countDown();
        assertThat("wrong pool size", pool.getPoolSize(), equalTo(max));
    public void testFixedForcedExecution() throws Exception {
                assertThat(message, containsString("[Running"));
        if (processorsSetting.getProperties().contains(Setting.Property.Deprecated)) {
        final CountDownLatch wait = new CountDownLatch(1);
        }  
                } catch (Exception e) {
        assertThat(executed3.get(), equalTo(false));
                assertEquals(threadContext.getHeader("foo"), "bar");
            CountDownLatch latch = new CountDownLatch(1);
            // wait until thread executes this task
            threadContext.putHeader("test-header", "test-value");
            assertThat(message, containsString("of dummy runnable"));
                }  
        assertBusy(() -> {
            });  
            threadContext.putHeader("bar", "boom");  
        OpenSearchThreadPoolExecutor executor = OpenSearchExecutors.newFixed(
                } catch (InterruptedException e) {  
            @Override
        }
                try {  
                        } catch (InterruptedException e) {  
            @Override  
            fail("Didn't get a rejection when we expected one.");
                try {
        final AtomicBoolean executed2 = new AtomicBoolean();  
 *
        executor.execute(new AbstractRunnable() {  
                 * While you'd expect all threads in the pool to be active when the queue gets long enough to cause rejections this isn't  
        final Integer one = Integer.valueOf(1);
        }  
                 * test with something like 10000 iterations. I suspect you could see "active threads = <any natural number <= to pool>". So  
            threadContext
        });
        } finally {
            executor.execute(r);
            executor.shutdown();
            TimeUnit.MILLISECONDS,
                latch.countDown();
        assertThat("wrong pool size", pool.getPoolSize(), equalTo(max));  
            fail("should be rejected...");
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
    }  
            queue,  
 * the Apache License, Version 2.0 (the "License"); you may
        final AtomicBoolean executed3 = new AtomicBoolean();
        final int processors = randomIntBetween(available + 1, Integer.MAX_VALUE);
        final CountDownLatch exec1Wait = new CountDownLatch(1);  
                try {
            assertTrue("task should run on a virtual thread", isVirtual.get());  
        try {
package org.opensearch.common.util.concurrent;
 *     http://www.apache.org/licenses/LICENSE-2.0
        } finally {
            final CountDownLatch handlerCalled = new CountDownLatch(1);
            "setting [%s] to value [%d] which is more than available processors [%d] is deprecated",  
            OpenSearchExecutors.daemonThreadFactory("test"),  
            OpenSearchExecutors.daemonThreadFactory("test"),
            assertThat("wrong active count", pool.getActiveCount(), equalTo(0));  
                executor.invokeAny(List.of(() -> threadContext.getHeader("test-header"), () -> threadContext.getHeader("test-header")))
            }
        barrier.await();
            public void run() {
            @Override
        executor.execute(new Runnable() {
        assertEquals(0L, executor.getCompletedTaskCount());
                    pool.execute(TestTask.this);
        }
            latch.await();
    public void testVirtualThreadPerTaskExecutorDoesNotLeakActiveCountOnRejection() throws Exception {  
            assertThat("idle threads didn't shrink below max. (" + pool.getPoolSize() + ")", pool.getPoolSize(), lessThan(max));
                } catch (InterruptedException e) {
                if (latch.getCount() > 0) {  
        assertThat("Max property", pool.getMaximumPoolSize(), equalTo(1));
                 * always the case. Sometimes you'll see "active threads = <pool - 1>", presumably because one of those threads has finished
                }  
        return TimeUnit.values()[between(0, TimeUnit.values().length - 1)];
                    public void run() {  
                    return "dummy runnable";
                try {  
            for (Future<String> future : futures) {
        final CountDownLatch wait = new CountDownLatch(1);  
    }
            randomTimeUnit(),  
                    throw new AssertionError(e);
        final AtomicBoolean executed1 = new AtomicBoolean();  
                try {
        final CountDownLatch executed = new CountDownLatch(1);
            for (int i = 0; i < actions; i++) {  
            // all is well
        threadContext.putTransient("foo", one);
            executor.shutdown();
        final CountDownLatch executed = new CountDownLatch(1);
            getName(),
import java.util.concurrent.ThreadPoolExecutor;  
                List.of(() -> threadContext.getHeader("test-header"), () -> threadContext.getHeader("test-header"))
            deprecatedSettings = new Setting<?>[] { processorsSetting };  
        exec2Wait.await();
                        // Doesn't matter is going to be rejected
            final Future<?> future = executor.submit((Runnable) () -> { throw error; });
            pool,
            terminate(executor);  
        terminate(pool);  
            assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
        exec3Wait.await();
    private String getName() {
                } catch (InterruptedException e) {  
        ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor("node1", "test-virtual-error", threadContext);  
 * SPDX-License-Identifier: Apache-2.0
                assertThat(message, containsString("on OpenSearchThreadPoolExecutor[name = " + getName()));
        });  
                    }
                exec2Wait.countDown();  
                latch.countDown();  
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    @Override
            ExecutionException e = expectThrows(ExecutionException.class, () -> future.get(10, TimeUnit.SECONDS));
                for (int p = 0; p <= pool; p++) {
            OpenSearchExecutors.daemonThreadFactory("test"),
        try {  
            executor.execute(new Runnable() {
    public void testScaleDown() throws Exception {  
            executor.shutdown();  
                    }
            assertThat(message, containsString("queue capacity = " + queue));
        }
                }  
        assertEquals(0, executor.getActiveCount());  
            executor.execute(new Runnable() {
                exec1Wait.countDown();
                /*
    }  
        );
            public void run() {  
        assertTrue(executor.awaitTermination(10, TimeUnit.SECONDS));
            max,  
    public void testNodeProcessorsBound() {  
    }
            });
import org.opensearch.common.settings.Settings;
                    fail();  
                }
        } catch (OpenSearchRejectedExecutionException e) {
        );
        assertThat("wrong active size", pool.getActiveCount(), lessThanOrEqualTo(1));  
        final String expectedWarning = String.format(
        assertThat("Min property", pool.getCorePoolSize(), equalTo(min));
            );  
                executed.countDown();  
            executor.submit((Runnable) () -> { throw new Error("expected"); });
        terminate(executor);
                latch.countDown();  
        exec2Wait.await();  
                public void run() {
            assertTrue("Thread pool not registering as terminated when it is", e.isExecutorShutdown());  
        final CountDownLatch exec2Wait = new CountDownLatch(1);
            final CountDownLatch latch = new CountDownLatch(1);
        runProcessorsBoundTest(OpenSearchExecutors.NODE_PROCESSORS_SETTING);
        );  
            latch.countDown();
            final AtomicReference<Throwable> uncaught = new AtomicReference<>();  
                 * that is what we assert.
        final Thread.UncaughtExceptionHandler previousHandler = Thread.getDefaultUncaughtExceptionHandler();
 * The OpenSearch Contributors require contributions made to  
            });
                assertSame(threadContext.getTransient("foo"), one);  
            getName(),
 * You may obtain a copy of the License at  
                    barrier.await();
        ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor("node1", "test-virtual-callable", threadContext);
            AtomicBoolean contextPreserved = new AtomicBoolean();  
                 */
        });
    }
        final CountDownLatch latch = new CountDownLatch(1);  
        assertThat("wrong active size", pool.getActiveCount(), equalTo(max));
     * The test case is adapted from https://bugs.openjdk.org/browse/JDK-8323659 reproducer.
                public void run() {
            final Error error = new Error("expected");
 * compatible open source license.
 * under the License.  
 */  
            public boolean isForceExecution() {
        // counted as active or completed
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
        class TestTask implements Runnable {
        }
import org.hamcrest.Matcher;
            @Override  
import java.util.concurrent.atomic.AtomicBoolean;
                });
            between(1, 100),  
 * software distributed under the License is distributed on an
        assertThat("Min property", pool.getCorePoolSize(), equalTo(min));  
            CountDownLatch latch = new CountDownLatch(1);
            Thread.setDefaultUncaughtExceptionHandler(previousHandler);
            assertThat(message, containsString("completed tasks = " + actions));
        }
            processors,
            };  
            terminate(executor);
        // a thread-per-task executor rejects submissions once shut down; the task never runs, so it must not be  
            }
        }  
            }  
        });
    }  
        final AtomicBoolean executed1 = new AtomicBoolean();
            executor.shutdown();  
                });
                 * its current task but has yet to pick up another task. You too can reproduce this by adding the @Repeat annotation to this
            public void onFailure(Exception e) {
        }
        final CountDownLatch exec1Wait = new CountDownLatch(1);
        ExecutorService executor = OpenSearchExecutors.newVirtualThreadPerTaskExecutor("node1", "test-naming", threadContext);
    public void testInheritContext() throws InterruptedException {  
            pool,  
    private TimeUnit randomTimeUnit() {  
 * Unless required by applicable law or agreed to in writing,
            });  
            }  
        assertThat(executed3.get(), equalTo(true));
        } finally {  
                latch.countDown();  
import static org.hamcrest.Matchers.anyOf;
                }
    private final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        final int min = between(1, 3);
            // rethrowErrors throws past the task body, so only a finally block keeps the counters consistent
                    public String toString() {
            }
        final int available = Runtime.getRuntime().availableProcessors();  
            assertTrue("uncaught exception handler should have been called", handlerCalled.await(10, TimeUnit.SECONDS));  
        final int max = between(min + 1, 6);  
            getClass().getName() + "/" + getTestName(),
            // A submitted task captures the Error in its Future, so it is only visible to the uncaught exception
 *  
            queue,  
            available  
            latch.countDown();
