        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        // Register a ForkJoinPool-based executor in ThreadPool
            Settings commonSettings = Settings.builder().put("snapshot.max", "50").put("snapshot.core", "100").build();
    }
                } catch (InterruptedException e) {
        assertThat(json, containsString("\"parallelism\":8"));
    }
        ThreadPool.ExecutorHolder holder = new ThreadPool.ExecutorHolder(pool, info);
    }
        pool.submit(() -> result.set(42)).join();
            .threads(1)
        assertThrows(NullPointerException.class, () -> pool.submit((Runnable) null));
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
                counter.incrementAndGet();
import org.opensearch.common.unit.TimeValue;
            threadPool.getThreadContext().putHeader("bar", "boom");
    }
        terminate(threadPool);
        ThreadPoolStats.Stats statsIn = new ThreadPoolStats.Stats(in);
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
        BytesStreamOutput out = new BytesStreamOutput();
        latch.await(5, TimeUnit.SECONDS);
            .build();
 * this work for additional information regarding copyright
        json = builder.toString();
    public void testForkJoinPoolHighParallelism() {
        BytesStreamOutput out = new BytesStreamOutput();
        // Use an explicit older version < 3.0.0
        builder.endObject();
            executor = (OpenSearchThreadPoolExecutor) executorService;
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
                latch.countDown();
        // 4. Test serialization for version < 3.4.0 (parallelism is not written, should be -1)
        TestThreadPool threadPool = new TestThreadPool("test");
        };
        threadPool.shutdown();
        assertThat(
            }
import java.util.concurrent.TimeUnit;
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        int result = pool.invoke(task);
            long delta = Math.abs(gotTime - currentTime);
        ForkJoinPool pool = new ForkJoinPool(1);
            @Override
            boolean found = false;
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
    }
        terminate(threadPool);
        threadPool.setThreadPool(forkJoinSettings);
            .waitTimeNanos(7L)
        } finally {
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
            .parallelism(-1)
            .active(3)
            latch.countDown();
import java.util.concurrent.ExecutorService;
        in.readString(); // name
                    assertEquals(0, stat.getActive());
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals("fixed", typeStr);
        assertEquals(expectedParallelism, pool.getParallelism());
        };
            Settings unknown = Settings.builder().put("notarealthreadpool.size", 1).build();
    }
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        builder = XContentFactory.jsonBuilder();
            executed.await();
        assertThat(statsIn.getThreads(), equalTo(1));
            executorService = threadPool.executor("get");
        assertEquals(42, result.get());
        assertThat(factorialForked(1, threadPool.generic()), equalTo(1));
            .waitTimeNanos(7L)
        // 2. Test with parallelism = -1 (should not output the field)
        assertThat(ThreadPool.oneEighthAllocatedProcessors(4), equalTo(1));
 * Unless required by applicable law or agreed to in writing,
        statsIn = new ThreadPoolStats.Stats(in);
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
            ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
    int factorialForked(int n, ExecutorService executor) {
        terminate(threadPool);
        assertTrue(holder.executor() instanceof ForkJoinPool);
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        assertThat(statsIn.getQueue(), equalTo(2));
        assertThat(statsIn.getParallelism(), equalTo(-1));
    }
            public void writeBytes(byte[] b, int offset, int length) {}
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        threadPool.shutdown();
            assertEquals(10, executor.getMaximumPoolSize());
            Settings commonSettings = Settings.builder().put("snapshot.max", "10").put("snapshot.core", "2").put("get.size", "100").build();
        assertThat(statsIn.getRejected(), equalTo(4L));
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(100, executor.getCorePoolSize());
            }
        for (int i = 0; i < expectedParallelism; i++) {
                return 123;
    public void testStatsAndValidateSettingForForkJoinPool() {
            // increase it
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
            threadPool.schedule(() -> {
                    assertEquals(0, stat.getRejected());
            assertEquals(100, executor.getMaximumPoolSize());
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
        final CountDownLatch executed = new CountDownLatch(1);
            public void close() throws IOException {} // required by abstract base class
import static org.opensearch.threadpool.ThreadPool.assertCurrentMethodIsNotCalledRecursively;
                    fail();
            terminate(threadPool);
        terminate(threadPool);
        AtomicInteger counter = new AtomicInteger(0);
                    assertEquals(-1, stat.getWaitTimeNanos());
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
        try {
        in.setVersion(Version.fromString("2.9.0"));
    }
 * KIND, either express or implied.  See the License for the
        // 3. Test serialization for version >= 3.4.0 (parallelism is written and read)
        assertCurrentMethodIsNotCalledRecursively();
    public void testAssertCurrentMethodIsNotCalledRecursively() {
    }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        assertEquals(123, result);
        StreamInput in = out.bytes().streamInput();
            .parallelism(-1)
            @Override
    }
        assertThat(factorialForked(10, threadPool.generic()), equalTo(3628800));
        Settings settings = Settings.builder().put("node.name", "testnode").build();
import java.util.concurrent.RejectedExecutionException;
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
        out = new BytesStreamOutput();
        TestThreadPool threadPool = new TestThreadPool("test");
            private Version version = Version.CURRENT;
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", parallelism));
            threadPool.getThreadContext().putTransient("bar", "boom");
            .queue(2)
            expectThrows(AssertionError.class, () -> factorial(between(2, 10))).getMessage(),
        AtomicInteger result = new AtomicInteger(0);
        ThreadPool.Info info = new ThreadPool.Info("foo", ThreadPool.ThreadPoolType.RESIZABLE, 1);
            .threads(1)
import org.opensearch.core.xcontent.ToXContent;
    public void testValidateSettingThrowsOnUnknownThreadPoolName() {
                    assertEquals(0, stat.getQueue());
            OpenSearchThreadPoolExecutor executor = (OpenSearchThreadPoolExecutor) executorService;
        threadPool.shutdown();
        out.writeOptionalWriteable(null);
    }
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
            equalTo("org.opensearch.threadpool.ThreadPoolTests#factorial is called recursively")
            });
        assertTrue(e.getMessage().contains("Unknown ThreadPoolType"));
        ThreadPoolStats.Stats statsIn = new ThreadPoolStats.Stats(in);
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
        try {
            ThreadPoolStats stats = threadPool.stats();
            equalTo("org.opensearch.threadpool.ThreadPoolTests#factorialForked is called recursively")
        Future<?> future = pool.submit(() -> { throw new RuntimeException("fail!"); });
package org.opensearch.threadpool;
        // Clean up
            }
            @Override
            assertEquals(90, executor.getMaximumPoolSize());
 * under the License.
        builder.endObject();
        out.writeString("foo");
            Exception e = expectThrows(IllegalArgumentException.class, () -> threadPool.setThreadPool(unknown));
 */
import static org.hamcrest.Matchers.containsString;
        pool.submit(() -> result.set(42)).join();
                    latch.await();
            .rejected(4L)
        assertThat(statsIn.getName(), equalTo("test"));
        assertThat(ThreadPool.oneEighthAllocatedProcessors(32), equalTo(4));
        assertThat(statsIn.getParallelism(), equalTo(9));
        TestThreadPool threadPool = new TestThreadPool("test");
 * this file be licensed under the Apache-2.0 license or a
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
            .completed(6L)
    public void testExecutorHolderAcceptsForkJoinPool() {
 * software distributed under the License is distributed on an
        statsOut.writeTo(out);
        assertThat(statsIn.getLargest(), equalTo(5));
            .largest(5)
            terminate(threadPool);
        }
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
        assertEquals(-1, statsIn.getParallelism());
        terminate(threadPool);
import java.util.concurrent.ExecutionException;
 *
        assertEquals(expectedParallelism, ((ForkJoinPool) pool).getParallelism());
        int min = randomIntBetween(0, 32);
            .completed(6L)
    }
        assertThat(statsIn.getActive(), equalTo(3));
        } else {
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
        }
        Settings settings = Settings.builder().put("thread_pool.estimated_time_interval", -1).build();
            // --- Cover stats() branch for FORK_JOIN ---
import static org.hamcrest.Matchers.is;
        StreamInput in = out.bytes().streamInput();
        in.setVersion(Version.V_3_4_0);
        out.writeInt(1);
    }
            threadPool.setThreadPool(commonSettings);
            .active(3)
        info.writeTo(out);
            .queue(2)
            .build();
import org.opensearch.Version;
    public void testForkJoinPoolParallelism() throws Exception {
        threadPool.shutdown();
        assertThat(
    public void testThreadPoolResize() {
        if (n <= 1) {
            .completed(6L)
        assertNotNull(pool);
                this.version = v;
    public void testForkJoinPoolRegistrationAndTaskExecution() {
            commonSettings = Settings.builder().put("snapshot.max", "2").put("snapshot.core", "1").put("get.size", "90").build();
                assertNull(threadPool.getThreadContext().getTransient("bar"));
            // We intentionally supply a bogus config for jvector. Should hit the continue branch and NOT throw.
            long gotTime = threadPool.absoluteTimeInMillis();
        out.setVersion(Version.CURRENT);
/*
    }
        in.setVersion(Version.CURRENT);
                }
    public void testForkJoinPoolNullTask() {
/*
    }
 *
import java.util.concurrent.atomic.AtomicInteger;
    public void testBoundedByAboveMax() {
        ThreadPoolStats.Stats statsOut = new ThreadPoolStats.Stats.Builder().name("test")
    public void testStatsSerializationParallelismNegativeValue() throws IOException {
        ThreadPool threadPool = new TestThreadPool("test");
        return n * FutureUtils.get(executor.submit(() -> factorialForked(n - 1, executor)));
            .build();
            .largest(5)
        final CountDownLatch latch = new CountDownLatch(1);
        try {
        assertEquals(expectedParallelism, counter.get());
        String typeStr = in.readString();
        in = out.bytes().streamInput();
        out.setVersion(Version.CURRENT);
    public void testForkJoinPoolShutdown() throws Exception {
        out.setVersion(Version.V_3_4_0);
        int value = randomIntBetween(min, max);
            for (ThreadPoolStats.Stats stat : stats) {
        Settings settings = Settings.builder().put("node.name", "testnode").build();
            threadPool.getThreadContext().putHeader("foo", "bar");
        assertEquals(info, holder.info);
    public void testThreadPoolInfoWriteToForkJoinCurrentVersion() throws IOException {
    public void testForkJoinPoolRecursiveTask() {
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
            @Override
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", 1));
        assertThat(statsIn.getWaitTimeNanos(), equalTo(7L));
    public void testForkJoinPoolParallelismOne() {
import java.util.concurrent.RecursiveTask;
}
        assertThrows(ExecutionException.class, () -> future.get());
        );
        } finally {
        int value = randomIntBetween(max + 1, Integer.MAX_VALUE);
public class ThreadPoolTests extends OpenSearchTestCase {
            @Override
            terminate(threadPool);
        // Should NOT throw, because validateSetting skips ForkJoinPool types
            Settings bogus = Settings.builder().put("jvector.size", "99").build();
        String json = builder.toString();
            .largest(5)
            .active(3)
        StreamOutput out = new StreamOutput() {
            public void writeBytes(byte[] b) {}
import org.opensearch.core.common.io.stream.StreamOutput;
            assertEquals(2, executor.getCorePoolSize());
            .parallelism(9)
        int max = randomIntBetween(min + 1, 64);
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
        int expectedParallelism = 32;
    }
    public void testForkJoinPoolTaskThrowsException() {
            .completed(6L)
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.settings.Settings;
                assertSame(threadPool.getThreadContext().getTransient("foo"), one);
 * specific language governing permissions and limitations
            return 1;
        in.setVersion(Version.V_3_3_0);
    public void testValidateSettingSkipsForkJoinPool() {
        int max = randomIntBetween(min + 1, 64);
        in.setVersion(Version.V_3_4_0);
        TestThreadPool threadPool = new TestThreadPool("test");
        } finally {
            threadPool.getThreadContext().putTransient("foo", one);
    int factorial(int n) {
            .rejected(4L)
        }
        int max = randomIntBetween(min + 1, 64);
        // 1. Test the full constructor and toXContent with parallelism set
        assertEquals(42, result.get());
        out.writeInt(1);
    }
            public Version getVersion() {
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            threadPool.setThreadPool(commonSettings);
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
import org.opensearch.test.OpenSearchTestCase;
        terminate(threadPool);
            terminate(threadPool);
    public void testThreadPoolResizeFail() {
        ExecutorService pool = threadPool.executor("jvector");
    public void testForkJoinPoolTaskExecution() {
    }
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
                if ("jvector".equals(stat.getName())) {
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        Settings settings = Settings.builder().put("node.name", "testnode").build();
    public void testBoundedByBelowMin() {
        );
            .waitTimeNanos(7L)
        statsOut.writeTo(out);
        assertEquals("failed to parse value [-1] for setting [thread_pool.estimated_time_interval], must be >= [0ms]", e.getMessage());
            public void setVersion(Version v) {
        ThreadPool.Info info = new ThreadPool.Info("jvector", ThreadPool.ThreadPoolType.FORK_JOIN, 1);
            .rejected(4L)
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
            assertEquals(2, executor.getMaximumPoolSize());
        builder.startObject();
            executor = (OpenSearchThreadPoolExecutor) executorService;
            assertTrue(e.getMessage().contains("illegal thread_pool name"));
 *
                    assertEquals(0, stat.getCompleted());
            assertEquals(90, executor.getCorePoolSize());
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
        }
        Settings settings = Settings.builder().put("node.name", "testnode").build();
    public void testForkJoinPoolRegistration() {
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
        assertThat(ThreadPool.boundedBy(value, min, max), equalTo(max));
import java.util.concurrent.CountDownLatch;
                    found = true;
            expectThrows(AssertionError.class, () -> factorialForked(between(2, 10), OpenSearchExecutors.newDirectExecutorService()))
 */
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals(1, pool.getParallelism());
        int min = randomIntBetween(0, 32);
    }
            executorService = threadPool.executor("get");
 * compatible open source license.
        out.setVersion(Version.fromString("2.9.0"));
    }
 * not use this file except in compliance with the License.
        StreamInput in = out.bytes().streamInput();
import static org.opensearch.threadpool.ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING;
            threadPool.setThreadPool(bogus); // Should not throw!
 * Modifications Copyright OpenSearch Contributors. See
        // This will exercise the normal serialization logic for ForkJoinPool and current version
                assertEquals(threadPool.getThreadContext().getHeader("foo"), "bar");
    public void testBoundedByBetweenMinAndMax() {
                return version;
        }
 * GitHub history for details.
            Exception e = expectThrows(IllegalArgumentException.class, () -> threadPool.setThreadPool(tpSettings));
    }
        Exception e = expectThrows(IllegalArgumentException.class, () -> ESTIMATED_TIME_INTERVAL_SETTING.get(settings));
        assertCurrentMethodIsNotCalledRecursively();
    }
import java.util.concurrent.ForkJoinPool;
        StreamInput in = out.bytes().streamInput();
            long currentTime = System.currentTimeMillis();
                    assertEquals(0, stat.getLargest());
            ExecutorService executorService = threadPool.executor("snapshot");
        builder.startObject();
    }
            .waitTimeNanos(7L)
            @Override
            }, TimeValue.timeValueMillis(randomInt(100)), randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC));
        try {
                    assertEquals(parallelism, stat.getParallelism());
        // ForkJoinPool does not support any config, but we still add dummy settings to trigger validateSetting
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            assertTrue("ForkJoinPool stats entry should exist", found);
    }
        } finally {
import java.util.concurrent.Future;
            .parallelism(8)
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
    public void testInheritContextOnSchedule() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(expectedParallelism);
            @Override
        assertThat(factorial(1), equalTo(1)); // is not called recursively
            .queue(2)
 * license agreements. See the NOTICE file distributed with
    }
            assertThat(e.getMessage(), containsString("illegal thread_pool name"));
            return 1;
            .active(3)
            terminate(threadPool);
            // the delta can be large, we just care it is the same order of magnitude
        }
    }
        }
            pool.submit(() -> {
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
        assertThrows(RejectedExecutionException.class, () -> pool.submit(() -> {}));
                }
            .queue(2)
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
            assertEquals(1, executor.getCorePoolSize());
        threadPool.shutdown();
            public void writeByte(byte b) {}
                try {
            public void flush() throws IOException {} // required by abstract base class
        Settings settings = Settings.builder().put("node.name", "testnode").build();
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
            return n * factorial(n - 1);
            executorService = threadPool.executor("snapshot");
                .getMessage(),
        int parallelism = 3;
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
        ThreadPoolStats.Stats statsOut = new ThreadPoolStats.Stats.Builder().name("test")
 * You may obtain a copy of the License at
        } finally {
            .threads(1)
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
            protected Integer compute() {
        Settings settings = Settings.builder().put("node.name", "testnode").build();
            // Also cover the branch in validateSetting that throws for unknown thread pool name
        ThreadPool.Info info = new ThreadPool.Info("jvector", ThreadPool.ThreadPoolType.FORK_JOIN, 1);
        assertThat(ThreadPool.boundedBy(value, min, max), equalTo(min));
            // decrease it
            @Override
            assertTrue("thread pool cached absolute time " + gotTime + " is too far from real current time " + currentTime, delta < 10000);
        expectThrows(AssertionError.class, () -> factorial(between(2, 10)));
    }
        out.setVersion(Version.V_3_3_0);
                executed.countDown();
        if (n <= 1) {
            }
            assertThrows(IllegalArgumentException.class, () -> threadPool.setThreadPool(commonSettings));
        XContentBuilder builder = XContentFactory.jsonBuilder();
    public void testSubmitAfterShutdownThrows() {
import org.opensearch.common.util.concurrent.FutureUtils;
    }
                    assertEquals(0, stat.getThreads());
/*
        int value = randomIntBetween(Integer.MIN_VALUE, min - 1);
 * the Apache License, Version 2.0 (the "License"); you may
            .rejected(4L)
 * The OpenSearch Contributors require contributions made to
    public void testInfoStreamInputThrowsOnUnknownTypeAndNewVersion() throws IOException {
            public void reset() throws IOException {} // required by abstract base class
        statsOut.writeTo(out);
        info.writeTo(out);
            Settings tpSettings = Settings.builder().put("notarealthreadpool.size", 1).build();
    }
        try {
        assertThat(json.contains("parallelism"), is(false));
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        stats = new ThreadPoolStats.Stats.Builder().name("test")
        Settings forkJoinSettings = Settings.builder().put("jvector.size", "10").build();
        out.writeOptionalTimeValue(null);
    }
    public void testStatsSerializationParallelismVersion() throws IOException {
            latch.countDown();
        assertThat(ThreadPool.boundedBy(value, min, max), equalTo(value));
        try {
        } finally {
        ThreadPoolStats.Stats stats = new ThreadPoolStats.Stats.Builder().name("test")
        }
import org.opensearch.core.common.io.stream.StreamInput;
        assertTrue(pool instanceof ForkJoinPool);
            .build();
        assertThat(ThreadPool.oneEighthAllocatedProcessors(1), equalTo(1));
        assertThat(ThreadPool.oneEighthAllocatedProcessors(8), equalTo(1));
            .largest(5)
                assertNull(threadPool.getThreadContext().getHeader("bar"));
    public void testStatsParallelismConstructorAndToXContent() throws IOException {
        }
        out.setVersion(Version.V_3_4_0);
        out.writeString("unknown_type");
            @Override
    public void testInfoWriteToWritesFixedForResizableOnOldVersion() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
        pool.shutdown();
        BytesStreamOutput out = new BytesStreamOutput();
        terminate(threadPool);
        AtomicInteger result = new AtomicInteger(0);
    public void testAbsoluteTime() throws Exception {
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertThat(statsIn.getCompleted(), equalTo(6L));
        RecursiveTask<Integer> task = new RecursiveTask<>() {
            .threads(1)
        Exception e = expectThrows(IllegalArgumentException.class, () -> new ThreadPool.Info(in));
 */
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
    }
        terminate(threadPool);
        TestThreadPool threadPool = new TestThreadPool("test");
            executor = (OpenSearchThreadPoolExecutor) executorService;
            final Integer one = Integer.valueOf(1);
import org.opensearch.common.xcontent.XContentFactory;
            // --- Cover validateSetting skip/continue for FORK_JOIN ---
    public void testEstimatedTimeIntervalSettingAcceptsOnlyZeroAndPositiveTime() {
    }
    public void testOneEighthAllocatedProcessors() {
    }
        int min = randomIntBetween(0, 32);
        // Setup minimal settings with node name
        assertThat(ThreadPool.oneEighthAllocatedProcessors(128), equalTo(16));
        assertTrue(pool.isShutdown());
import static org.hamcrest.CoreMatchers.equalTo;
