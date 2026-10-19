        ExecutorService pool = threadPool.executor("jvector");
            public void setVersion(Version v) {
        );
        int parallelism = 3;  
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));  
            }
        out.writeOptionalWriteable(null);
        ThreadPoolStats.Stats statsIn = new ThreadPoolStats.Stats(in);
            protected Integer compute() {
            assertEquals(100, executor.getCorePoolSize());
    public void testAssertCurrentMethodIsNotCalledRecursively() {
    public void testForkJoinPoolParallelismOne() {
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(info, holder.info);
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
            threadPool.getThreadContext().putHeader("foo", "bar");
            expectThrows(AssertionError.class, () -> factorial(between(2, 10))).getMessage(),
 * SPDX-License-Identifier: Apache-2.0
        pool.submit(() -> result.set(42)).join();  
    }
        int value = randomIntBetween(Integer.MIN_VALUE, min - 1);
        final CountDownLatch executed = new CountDownLatch(1);  
import org.opensearch.common.io.stream.BytesStreamOutput;
 */  
        assertTrue(pool.isShutdown());
        out.writeInt(1);
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
        assertThat(statsIn.getParallelism(), equalTo(9));
import static org.hamcrest.Matchers.is;  
            commonSettings = Settings.builder().put("snapshot.max", "2").put("snapshot.core", "1").put("get.size", "90").build();
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
            Exception e = expectThrows(IllegalArgumentException.class, () -> threadPool.setThreadPool(tpSettings));  
        builder.endObject();
 * the Apache License, Version 2.0 (the "License"); you may
 *
import java.util.concurrent.atomic.AtomicInteger;  
        terminate(threadPool);  
import org.opensearch.common.xcontent.XContentFactory;
    }  
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
            executorService = threadPool.executor("get");
    public void testForkJoinPoolTaskThrowsException() {  
    }
                }  
        int min = randomIntBetween(0, 32);
        } finally {
            .active(3)
            Settings bogus = Settings.builder().put("jvector.size", "99").build();  
        // 3. Test serialization for version >= 3.4.0 (parallelism is written and read)
    }
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
            assertEquals(1, executor.getCorePoolSize());  
        terminate(threadPool);
        ThreadPoolStats.Stats statsOut = new ThreadPoolStats.Stats.Builder().name("test")
        CountDownLatch latch = new CountDownLatch(expectedParallelism);
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
import java.util.concurrent.ForkJoinPool;
        assertThat(factorialForked(1, threadPool.generic()), equalTo(1));  
        } else {  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals("failed to parse value [-1] for setting [thread_pool.estimated_time_interval], must be >= [0ms]", e.getMessage());
        TestThreadPool threadPool = new TestThreadPool("test");
            .queue(2)
import static org.hamcrest.Matchers.containsString;
            @Override
        int min = randomIntBetween(0, 32);  
            long currentTime = System.currentTimeMillis();
        assertThat(statsIn.getLargest(), equalTo(5));
        assertEquals(42, result.get());
        statsIn = new ThreadPoolStats.Stats(in);
            .completed(6L)
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
        StreamInput in = out.bytes().streamInput();
        out.writeString("unknown_type");
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));  
        pool.submit(() -> result.set(42)).join();
            .largest(5)
        assertThat(statsIn.getCompleted(), equalTo(6L));  
            executor = (OpenSearchThreadPoolExecutor) executorService;
            executorService = threadPool.executor("snapshot");  
    public void testBoundedByBelowMin() {
        assertThat(ThreadPool.boundedBy(value, min, max), equalTo(min));
        assertThrows(NullPointerException.class, () -> pool.submit((Runnable) null));
            // --- Cover stats() branch for FORK_JOIN ---  
                return version;
        BytesStreamOutput out = new BytesStreamOutput();
        };  
import org.opensearch.core.common.io.stream.StreamInput;  
        assertThat(ThreadPool.boundedBy(value, min, max), equalTo(max));  
 * You may obtain a copy of the License at  
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        ThreadPool threadPool = new TestThreadPool("test");  
 *  
        if (n <= 1) {
}
        assertCurrentMethodIsNotCalledRecursively();  
        ThreadPool.Info info = new ThreadPool.Info("jvector", ThreadPool.ThreadPoolType.FORK_JOIN, 1);
    public void testForkJoinPoolShutdown() throws Exception {
            ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
        out.setVersion(Version.V_3_3_0);  
            public void reset() throws IOException {} // required by abstract base class
            @Override
            @Override
        } finally {  
                if ("jvector".equals(stat.getName())) {
        Settings settings = Settings.builder().put("node.name", "testnode").build();
 * under the License.  
        TestThreadPool threadPool = new TestThreadPool("test");  
        try {  
        assertTrue(holder.executor() instanceof ForkJoinPool);
        assertTrue(e.getMessage().contains("Unknown ThreadPoolType"));
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
        }
            assertEquals(10, executor.getMaximumPoolSize());
        assertThat(ThreadPool.oneEighthAllocatedProcessors(32), equalTo(4));
    public void testForkJoinPoolTaskExecution() {  
        in.readString(); // name
            public void flush() throws IOException {} // required by abstract base class
                    fail();
            assertTrue("ForkJoinPool stats entry should exist", found);
        out.writeInt(1);  
        StreamInput in = out.bytes().streamInput();  
 * not use this file except in compliance with the License.
                    found = true;
        try {
            threadPool.getThreadContext().putTransient("bar", "boom");
        Settings settings = Settings.builder().put("node.name", "testnode").build();  
    public void testStatsParallelismConstructorAndToXContent() throws IOException {
        // 4. Test serialization for version < 3.4.0 (parallelism is not written, should be -1)
            assertTrue("thread pool cached absolute time " + gotTime + " is too far from real current time " + currentTime, delta < 10000);
            assertTrue(e.getMessage().contains("illegal thread_pool name"));  
    public void testForkJoinPoolParallelism() throws Exception {
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
            assertEquals(90, executor.getMaximumPoolSize());
            latch.countDown();  
        assertThat(statsIn.getParallelism(), equalTo(-1));
            // --- Cover validateSetting skip/continue for FORK_JOIN ---
    }
            executor = (OpenSearchThreadPoolExecutor) executorService;  
            .rejected(4L)
        assertEquals(expectedParallelism, ((ForkJoinPool) pool).getParallelism());
            // decrease it  
                    latch.await();  
            threadPool.setThreadPool(commonSettings);
            .parallelism(9)
        Settings forkJoinSettings = Settings.builder().put("jvector.size", "10").build();  
        in.setVersion(Version.V_3_3_0);  
            .completed(6L)
import java.util.concurrent.Future;
        Settings settings = Settings.builder().put("node.name", "testnode").build();  
 * license agreements. See the NOTICE file distributed with
    public void testValidateSettingThrowsOnUnknownThreadPoolName() {
            public void writeByte(byte b) {}
            OpenSearchThreadPoolExecutor executor = (OpenSearchThreadPoolExecutor) executorService;  
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));  
            .rejected(4L)
            }, TimeValue.timeValueMillis(randomInt(100)), randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC));  
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);  
        // ForkJoinPool does not support any config, but we still add dummy settings to trigger validateSetting
        terminate(threadPool);
import org.opensearch.Version;
    public void testForkJoinPoolRegistrationAndTaskExecution() {
                }  
            .completed(6L)  
                    assertEquals(0, stat.getThreads());
        );  
        Settings settings = Settings.builder().put("node.name", "testnode").build();
            .parallelism(-1)
import org.opensearch.core.xcontent.ToXContent;
        }
 * Licensed to Elasticsearch under one or more contributor  
            .largest(5)
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        in = out.bytes().streamInput();
        assertEquals(1, pool.getParallelism());
        assertThat(statsIn.getName(), equalTo("test"));  
        int result = pool.invoke(task);  
        }
        assertThat(ThreadPool.oneEighthAllocatedProcessors(128), equalTo(16));
    public void testForkJoinPoolRegistration() {
            .threads(1)
            executorService = threadPool.executor("get");
        expectThrows(AssertionError.class, () -> factorial(between(2, 10)));
        // Clean up
    }
                } catch (InterruptedException e) {
            .queue(2)
        }  
 * The OpenSearch Contributors require contributions made to  
    public void testSubmitAfterShutdownThrows() {
        // 1. Test the full constructor and toXContent with parallelism set
    }
                assertSame(threadPool.getThreadContext().getTransient("foo"), one);
            .active(3)  
            .completed(6L)  
            .rejected(4L)  
        Settings settings = Settings.builder().put("node.name", "testnode").build();
    }  
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");  
        int value = randomIntBetween(min, max);  
        statsOut.writeTo(out);
            @Override  
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
            .waitTimeNanos(7L)
        // Should NOT throw, because validateSetting skips ForkJoinPool types
    }
    public void testForkJoinPoolHighParallelism() {  
            Settings commonSettings = Settings.builder().put("snapshot.max", "50").put("snapshot.core", "100").build();
            return 1;
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
        assertThat(ThreadPool.boundedBy(value, min, max), equalTo(value));
    }
            assertThrows(IllegalArgumentException.class, () -> threadPool.setThreadPool(commonSettings));  
            executor = (OpenSearchThreadPoolExecutor) executorService;
import org.opensearch.common.util.concurrent.FutureUtils;
        in.setVersion(Version.fromString("2.9.0"));  
            .largest(5)
 * Modifications Copyright OpenSearch Contributors. See
/*  
        assertEquals(42, result.get());  
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
    }  
        try {
            ThreadPoolStats stats = threadPool.stats();
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
        ThreadPool.ExecutorHolder holder = new ThreadPool.ExecutorHolder(pool, info);  
        terminate(threadPool);  
    }
            assertEquals(100, executor.getMaximumPoolSize());  
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", parallelism));
    public void testForkJoinPoolRecursiveTask() {
            final Integer one = Integer.valueOf(1);
            .build();  
        terminate(threadPool);  
        }  
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
    }  
            public void writeBytes(byte[] b) {}
        AtomicInteger counter = new AtomicInteger(0);  
            .threads(1)  
        TestThreadPool threadPool = new TestThreadPool("test");
        final CountDownLatch latch = new CountDownLatch(1);
        TestThreadPool threadPool = new TestThreadPool("test");  
                latch.countDown();
            Exception e = expectThrows(IllegalArgumentException.class, () -> threadPool.setThreadPool(unknown));
        try {
                assertNull(threadPool.getThreadContext().getHeader("bar"));  
        in.setVersion(Version.CURRENT);
        out.setVersion(Version.fromString("2.9.0"));
            // increase it
        assertThat(statsIn.getQueue(), equalTo(2));
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));
        in.setVersion(Version.V_3_4_0);
            .parallelism(-1)
    }
            .threads(1)  
        BytesStreamOutput out = new BytesStreamOutput();  
import java.util.concurrent.TimeUnit;
        // Use an explicit older version < 3.0.0
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);  
            terminate(threadPool);
    public void testBoundedByBetweenMinAndMax() {  
        out.writeOptionalTimeValue(null);
            expectThrows(AssertionError.class, () -> factorialForked(between(2, 10), OpenSearchExecutors.newDirectExecutorService()))  
 *
                    assertEquals(-1, stat.getWaitTimeNanos());
            @Override
    }
            .queue(2)
        threadPool.shutdown();  
    public void testValidateSettingSkipsForkJoinPool() {
        for (int i = 0; i < expectedParallelism; i++) {
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
        in.setVersion(Version.V_3_4_0);
        int value = randomIntBetween(max + 1, Integer.MAX_VALUE);
    public void testOneEighthAllocatedProcessors() {  
            .build();
        assertThat(json.contains("parallelism"), is(false));  
        info.writeTo(out);  
        if (n <= 1) {
        builder.startObject();
        BytesStreamOutput out = new BytesStreamOutput();  
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));  
        } finally {
    int factorial(int n) {
            .threads(1)
    }
package org.opensearch.threadpool;
    public void testStatsAndValidateSettingForForkJoinPool() {  
        ThreadPoolStats.Stats statsIn = new ThreadPoolStats.Stats(in);
            .waitTimeNanos(7L)  
                    assertEquals(0, stat.getCompleted());  
        pool.shutdown();  
        out.writeString("foo");  
        terminate(threadPool);
        assertThrows(ExecutionException.class, () -> future.get());  
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", expectedParallelism));  
            .build();
import static org.opensearch.threadpool.ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING;
    public void testForkJoinPoolNullTask() {  
        stats.toXContent(builder, ToXContent.EMPTY_PARAMS);  
            private Version version = Version.CURRENT;
    }
import org.opensearch.common.settings.Settings;  
        assertThat(json, containsString("\"parallelism\":8"));  
            }  
        builder.startObject();
 */  
    }  
    public void testStatsSerializationParallelismNegativeValue() throws IOException {
    }
            assertEquals(2, executor.getMaximumPoolSize());
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
        StreamInput in = out.bytes().streamInput();
        Settings settings = Settings.builder().put("thread_pool.estimated_time_interval", -1).build();  
        assertThat(statsIn.getThreads(), equalTo(1));
        assertThat(factorial(1), equalTo(1)); // is not called recursively  
        XContentBuilder builder = XContentFactory.jsonBuilder();
        assertThat(ThreadPool.oneEighthAllocatedProcessors(1), equalTo(1));
    int factorialForked(int n, ExecutorService executor) {
        try {  
        out = new BytesStreamOutput();
            threadPool.setThreadPool(commonSettings);
                this.version = v;
        Settings settings = Settings.builder().put("node.name", "testnode").build();
import java.util.concurrent.ExecutorService;  
            public void writeBytes(byte[] b, int offset, int length) {}
            @Override  
        assertThat(
        Exception e = expectThrows(IllegalArgumentException.class, () -> new ThreadPool.Info(in));  
        String typeStr = in.readString();
            terminate(threadPool);  
        builder = XContentFactory.jsonBuilder();
        AtomicInteger result = new AtomicInteger(0);
                assertEquals(threadPool.getThreadContext().getHeader("foo"), "bar");
        assertNotNull(pool);  
            // the delta can be large, we just care it is the same order of magnitude
            Settings tpSettings = Settings.builder().put("notarealthreadpool.size", 1).build();
    public void testEstimatedTimeIntervalSettingAcceptsOnlyZeroAndPositiveTime() {
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
            .waitTimeNanos(7L)  
            ExecutorService executorService = threadPool.executor("snapshot");
        assertThat(factorialForked(10, threadPool.generic()), equalTo(3628800));
            threadPool.getThreadContext().putHeader("bar", "boom");
            long delta = Math.abs(gotTime - currentTime);  
                try {
import java.util.concurrent.ExecutionException;
        assertThat(ThreadPool.oneEighthAllocatedProcessors(4), equalTo(1));
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);  
    public void testBoundedByAboveMax() {
    public void testInheritContextOnSchedule() throws InterruptedException {
        TestThreadPool threadPool = new TestThreadPool("test");
            public Version getVersion() {  
import java.util.concurrent.RecursiveTask;  
 * Unless required by applicable law or agreed to in writing,
            @Override
            terminate(threadPool);
        Settings settings = Settings.builder().put("node.name", "testnode").build();
import org.opensearch.common.unit.TimeValue;
        info.writeTo(out);
        threadPool.shutdown();  
        statsOut.writeTo(out);
            return 1;
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
        // Register a ForkJoinPool-based executor in ThreadPool
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        ThreadPoolStats.Stats statsOut = new ThreadPoolStats.Stats.Builder().name("test")
        RecursiveTask<Integer> task = new RecursiveTask<>() {  
                counter.incrementAndGet();
    }  
        Exception e = expectThrows(IllegalArgumentException.class, () -> ESTIMATED_TIME_INTERVAL_SETTING.get(settings));
            @Override  
            });  
            for (ThreadPoolStats.Stats stat : stats) {  
        out.setVersion(Version.CURRENT);
        threadPool.shutdown();
        } finally {
            // Also cover the branch in validateSetting that throws for unknown thread pool name  
        } finally {  
    public void testInfoStreamInputThrowsOnUnknownTypeAndNewVersion() throws IOException {  
            .active(3)  
public class ThreadPoolTests extends OpenSearchTestCase {
 * specific language governing permissions and limitations
 */
 * this file be licensed under the Apache-2.0 license or a
    }
        }
        // 2. Test with parallelism = -1 (should not output the field)
        assertThat(ThreadPool.oneEighthAllocatedProcessors(8), equalTo(1));  
            threadPool.schedule(() -> {
                    assertEquals(parallelism, stat.getParallelism());
        ThreadPoolStats.Stats stats = new ThreadPoolStats.Stats.Builder().name("test")  
        Settings settings = Settings.builder().put("node.name", "testnode").build();
            @Override  
/*  
            .active(3)
import static org.hamcrest.CoreMatchers.equalTo;
            equalTo("org.opensearch.threadpool.ThreadPoolTests#factorial is called recursively")  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        stats = new ThreadPoolStats.Stats.Builder().name("test")  
            .largest(5)
                return 123;  
        BytesStreamOutput out = new BytesStreamOutput();  
import java.io.IOException;  
                .getMessage(),
    public void testStatsSerializationParallelismVersion() throws IOException {  
            assertThat(e.getMessage(), containsString("illegal thread_pool name"));
        // This will exercise the normal serialization logic for ForkJoinPool and current version  
        out.setVersion(Version.CURRENT);
            .build();  
        statsOut.writeTo(out);
        threadPool.shutdown();
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.concurrent.RejectedExecutionException;
            long gotTime = threadPool.absoluteTimeInMillis();
    }
        threadPool.shutdown();  
        try {
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");
    }
        } finally {
            return n * factorial(n - 1);
        int expectedParallelism = 32;
        int max = randomIntBetween(min + 1, 64);  
            boolean found = false;
        terminate(threadPool);  
        terminate(threadPool);
        };
        String json = builder.toString();
                assertNull(threadPool.getThreadContext().getTransient("bar"));
        // Setup minimal settings with node name  
        assertThat(
            Settings unknown = Settings.builder().put("notarealthreadpool.size", 1).build();
            .waitTimeNanos(7L)
            }
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);
            .rejected(4L)  
            assertEquals(2, executor.getCorePoolSize());
        return n * FutureUtils.get(executor.submit(() -> factorialForked(n - 1, executor)));
    }
    public void testThreadPoolResizeFail() {
    }
        AtomicInteger result = new AtomicInteger(0);
import java.util.concurrent.CountDownLatch;
        ForkJoinPool pool = new ForkJoinPool(1);
        threadPool.setThreadPool(forkJoinSettings);  
    }  
 * software distributed under the License is distributed on an
import static org.opensearch.threadpool.ThreadPool.assertCurrentMethodIsNotCalledRecursively;  
            .queue(2)
            pool.submit(() -> {  
        json = builder.toString();
        assertEquals(-1, statsIn.getParallelism());  
 * KIND, either express or implied.  See the License for the
            Settings commonSettings = Settings.builder().put("snapshot.max", "10").put("snapshot.core", "2").put("get.size", "100").build();  
        latch.await(5, TimeUnit.SECONDS);
    public void testThreadPoolResize() {
        ThreadPool threadPool = new ThreadPool(settings, new ForkJoinPoolExecutorBuilder("jvector", 1));  
    }  
            .parallelism(8)
        builder.endObject();
            threadPool.getThreadContext().putTransient("foo", one);  
    }
        out.setVersion(Version.V_3_4_0);
        int expectedParallelism = OpenSearchExecutors.allocatedProcessors(settings);  
 * this work for additional information regarding copyright
        assertThat(statsIn.getWaitTimeNanos(), equalTo(7L));
        StreamOutput out = new StreamOutput() {  
            equalTo("org.opensearch.threadpool.ThreadPoolTests#factorialForked is called recursively")
    public void testAbsoluteTime() throws Exception {
        ThreadPool.Info info = new ThreadPool.Info("jvector", ThreadPool.ThreadPoolType.FORK_JOIN, 1);
        Settings settings = Settings.builder().put("node.name", "testnode").build();
        ThreadPool.Info info = new ThreadPool.Info("foo", ThreadPool.ThreadPoolType.RESIZABLE, 1);
        ForkJoinPool pool = (ForkJoinPool) threadPool.executor("jvector");  
        assertCurrentMethodIsNotCalledRecursively();  
        assertEquals("fixed", typeStr);  
        int min = randomIntBetween(0, 32);
        int max = randomIntBetween(min + 1, 64);
            assertEquals(90, executor.getCorePoolSize());
        }  
        assertTrue(pool instanceof ForkJoinPool);
        Future<?> future = pool.submit(() -> { throw new RuntimeException("fail!"); });
        out.setVersion(Version.V_3_4_0);
        int max = randomIntBetween(min + 1, 64);
                    assertEquals(0, stat.getRejected());
        StreamInput in = out.bytes().streamInput();  
        Settings settings = Settings.builder().put("node.name", "testnode").build();
 * compatible open source license.
            terminate(threadPool);
            }
    }
        }
        assertThrows(RejectedExecutionException.class, () -> pool.submit(() -> {}));
                    assertEquals(0, stat.getActive());  
                executed.countDown();
        assertEquals(expectedParallelism, pool.getParallelism());
        assertThat(statsIn.getRejected(), equalTo(4L));
        assertEquals(expectedParallelism, counter.get());  
    }
            // We intentionally supply a bogus config for jvector. Should hit the continue branch and NOT throw.
            terminate(threadPool);
/*
                    assertEquals(0, stat.getQueue());
    public void testThreadPoolInfoWriteToForkJoinCurrentVersion() throws IOException {  
            latch.countDown();  
    }
        assertThat(statsIn.getActive(), equalTo(3));  
    public void testInfoWriteToWritesFixedForResizableOnOldVersion() throws IOException {
                    assertEquals(0, stat.getLargest());
        assertEquals(123, result);
            public void close() throws IOException {} // required by abstract base class
            threadPool.setThreadPool(bogus); // Should not throw!
 * GitHub history for details.
            executed.await();
    }  
    public void testExecutorHolderAcceptsForkJoinPool() {  
