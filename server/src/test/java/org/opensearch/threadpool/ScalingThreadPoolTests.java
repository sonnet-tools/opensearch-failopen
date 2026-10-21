        sizes.put(ThreadPool.Names.FLUSH, ThreadPool::halfAllocatedProcessorsMaxFive);
                        taskLatch.countDown();
                        throw new RuntimeException(e);
            processorsUsed = availableProcessors;
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor
            try {
import java.util.Map;
        if (randomBoolean()) {
        sizes.put(ThreadPool.Names.FETCH_SHARD_STORE, ThreadPool::twiceAllocatedProcessors);
                    try {
            // but if threads are not correctly idled down by the pool,
                "setting [node.processors] to value ["
import org.opensearch.common.settings.Settings;
            expectedMax = randomIntBetween(Math.max(1, core), 16);
            for (int i = 0; i < 128; i++) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            assertNull(info.getQueueSize());
            assertThat(executor, instanceOf(OpenSearchThreadPoolExecutor.class));
        sizes.put(ThreadPool.Names.GENERIC, n -> ThreadPool.boundedBy(4 * n, 128, 512));
        });
 * not use this file except in compliance with the License.
public class ScalingThreadPoolTests extends OpenSearchThreadPoolTestCase {
        try {
    private int expectedSize(final String threadPoolName, final int numberOfProcessors) {
            .filter(t -> t.getValue().equals(ThreadPool.ThreadPoolType.SCALING))
            } while (stats(threadPool, threadPoolName).getThreads() > min);
                    + "] which is more than available processors ["
            .put("thread_pool." + threadPoolName + ".max", 128)
            assertThat(info.getMin(), equalTo(core));
        final int processorsUsed;
                        throw new RuntimeException(e);
                taskLatch.await();
        }));
        sizes.put(ThreadPool.Names.TRANSLOG_SYNC, n -> 4 * n);
            .put("thread_pool." + threadPoolName + ".keep_alive", "1ms")
import static org.hamcrest.CoreMatchers.instanceOf;
            final Settings nodeSettings = Settings.builder().put(settings).put("node.name", test).build();
    public void testScalingThreadPoolConfiguration() throws InterruptedException {
        final int availableProcessors = Runtime.getRuntime().availableProcessors();
                        taskLatch.countDown();
            } catch (InterruptedException e) {
 */
        sizes.put(ThreadPool.Names.REMOTE_REFRESH_RETRY, ThreadPool::halfAllocatedProcessors);
            int threads = stats(threadPool, threadPoolName).getThreads();
            assertThat(stats.getLargest(), equalTo(size));
        final int core;
        }
            .collect(Collectors.toList());
            final CountDownLatch latch = new CountDownLatch(1);
            .stream()
        if (randomBoolean()) {
            builder.put("node.processors", processors);
            do {
import java.util.HashMap;
        ThreadPool threadPool = null;
                });
                        latch.await();
 * KIND, either express or implied.  See the License for the
                    + availableProcessors
/*
 */
            for (int i = 0; i < numberOfTasks; i++) {
        } else {
 *
 * Unless required by applicable law or agreed to in writing,
    }
            // threads in the pool will drop to the min for the pool
            );
        });
            final CountDownLatch taskLatch = new CountDownLatch(128);
    public void testScalingThreadPoolIsBounded() throws InterruptedException {
                        latch.await();
            }
 * specific language governing permissions and limitations
        if (randomBoolean()) {
            maxBasedOnNumberOfProcessors = expectedSize(threadPoolName, processors);
            latch.countDown();
        runScalingThreadPoolTest(settings, ((clusterSettings, threadPool) -> {
        final int expectedMax;
            try {
            // are correctly idled down by the pool, the number of
            assertEquals(128, threads);
        final int size = randomIntBetween(32, 512);
            assertThat(openSearchThreadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS), equalTo(keepAlive));
                threadPool.executor(threadPoolName).execute(() -> {
                    }
import java.util.concurrent.CountDownLatch;
 *
import org.opensearch.common.settings.ClusterSettings;
        sizes.put(ThreadPool.Names.REMOTE_PURGE, ThreadPool::halfAllocatedProcessors);
            final OpenSearchThreadPoolExecutor openSearchThreadPoolExecutor = (OpenSearchThreadPoolExecutor) executor;
        sizes.put(ThreadPool.Names.WARMER, ThreadPool::halfAllocatedProcessorsMaxFive);
            .map(e -> new String[] { e.getKey() })
            assertThat(openSearchThreadPoolExecutor.getCorePoolSize(), equalTo(core));
        sizes.put(ThreadPool.Names.SNAPSHOT_DELETION, n -> ThreadPool.boundedBy(4 * n, 64, 256));
                    try {
        final int min = "generic".equals(threadPoolName) ? 4 : 1;
        this.threadPoolName = threadPoolName;
            final ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                spinForAtLeastOneMillisecond();
import java.util.concurrent.TimeUnit;
            core = "generic".equals(threadPoolName) ? 4 : 1; // the defaults
            final Executor executor = threadPool.executor(threadPoolName);
            assertThat(stats.getQueue(), equalTo(numberOfTasks - size));
            maxBasedOnNumberOfProcessors = expectedSize(threadPoolName, availableProcessors);
            builder.put("thread_pool." + threadPoolName + ".keep_alive", keepAlive + "s");
package org.opensearch.threadpool;
                throw new RuntimeException(e);
        sizes.put(ThreadPool.Names.REFRESH, ThreadPool::halfAllocatedProcessorsMaxTen);
            core = randomIntBetween(0, 8);
            assertThat(info.getKeepAlive().seconds(), equalTo(keepAlive));
import java.util.function.Function;
            terminateThreadPoolIfNeeded(threadPool);
            builder.put("thread_pool." + threadPoolName + ".core", core);
/*
    }
            final ThreadPoolStats.Stats stats = stats(threadPool, threadPoolName);
            assertWarnings(
            }
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        }
 * ownership. Elasticsearch licenses this file to you under
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
            threadPool = new ThreadPool(nodeSettings);
 */
 * this work for additional information regarding copyright
            final int numberOfTasks = 2 * size;
    }
}
                threadPool.executor(threadPoolName).execute(() -> {
        } else {
            assertThat(openSearchThreadPoolExecutor.getMaximumPoolSize(), equalTo(expectedMax));
        final Map<String, Function<Integer, Integer>> sizes = new HashMap<>();
        final int maxBasedOnNumberOfProcessors;
        return sizes.get(threadPoolName).apply(numberOfProcessors);
            final String test = Thread.currentThread().getStackTrace()[2].getMethodName();
            // this test will just timeout waiting for them to idle
        if (maxBasedOnNumberOfProcessors < core || randomBoolean()) {
        }
    }
    public void runScalingThreadPoolTest(final Settings settings, final BiConsumer<ClusterSettings, ThreadPool> consumer)
        } finally {
        sizes.put(ThreadPool.Names.TRANSLOG_TRANSFER, ThreadPool::halfAllocatedProcessors);
        runScalingThreadPoolTest(settings, (clusterSettings, threadPool) -> {
                    } catch (final InterruptedException e) {
 * license agreements. See the NOTICE file distributed with
            processorsUsed = processors;
                throw new RuntimeException(e);
import java.util.stream.Collectors;
                taskLatch.await();
        final Settings settings = Settings.builder()
    public void testScalingThreadPoolThreadsAreTerminatedAfterKeepAlive() throws InterruptedException {
    }
        } else {
            keepAlive = randomIntBetween(1, 300);
        sizes.put(ThreadPool.Names.REMOTE_RECOVERY, ThreadPool::twiceAllocatedProcessors);
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
    }
        final long keepAlive;
                    }
        if (processorsUsed > availableProcessors) {
 * You may obtain a copy of the License at
                    } catch (final InterruptedException e) {
    @ParametersFactory
            // down
                });
        runScalingThreadPoolTest(builder.build(), (clusterSettings, threadPool) -> {
 * software distributed under the License is distributed on an
            expectedMax = maxBasedOnNumberOfProcessors;
/*
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
        sizes.put(ThreadPool.Names.MERGE, n -> n);
        throws InterruptedException {
            }
    public static Collection<Object[]> scalingThreadPools() {
            keepAlive = "generic".equals(threadPoolName) ? 30 : 300; // the defaults
        sizes.put(ThreadPool.Names.FETCH_SHARD_STARTED, ThreadPool::twiceAllocatedProcessors);
            assertThat(openSearchThreadPoolExecutor.getQueue().remainingCapacity(), equalTo(Integer.MAX_VALUE));
            latch.countDown();
        }
            .build();
    }
            final int processors = randomIntBetween(1, 64);
        } else {
            }
                    + processorsUsed
        sizes.put(ThreadPool.Names.SNAPSHOT, ThreadPool::halfAllocatedProcessorsMaxFive);
        return ThreadPool.THREAD_POOL_TYPES.entrySet()
        }
            final CountDownLatch taskLatch = new CountDownLatch(numberOfTasks);
            consumer.accept(clusterSettings, threadPool);
import static org.hamcrest.Matchers.equalTo;
    private final String threadPoolName;
import java.util.Collection;
 * The OpenSearch Contributors require contributions made to
            // this while loop is the core of this test; if threads
        final Settings settings = Settings.builder().put("thread_pool." + threadPoolName + ".max", size).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
        final Settings.Builder builder = Settings.builder();
            final CountDownLatch latch = new CountDownLatch(1);
            final ThreadPool.Info info = info(threadPool, threadPoolName);
                    + "] is deprecated"
 *
    public ScalingThreadPoolTests(String threadPoolName) {
        sizes.put(ThreadPool.Names.REMOTE_DOWNLOAD, ThreadPool::twiceAllocatedProcessors);
            builder.put("thread_pool." + threadPoolName + ".max", expectedMax);
import java.util.function.BiConsumer;
        }
            assertThat(info.getThreadPoolType(), equalTo(ThreadPool.ThreadPoolType.SCALING));
            assertThat(info.getMax(), equalTo(expectedMax));
        sizes.put(ThreadPool.Names.MANAGEMENT, n -> 5);
            assertThat(info.getName(), equalTo(threadPoolName));
import java.util.concurrent.Executor;
            } catch (InterruptedException e) {
