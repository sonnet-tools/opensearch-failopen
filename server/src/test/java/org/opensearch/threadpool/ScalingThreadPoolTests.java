    }
        final int availableProcessors = Runtime.getRuntime().availableProcessors();  
            final int processors = randomIntBetween(1, 64);
            keepAlive = "generic".equals(threadPoolName) ? 30 : 300; // the defaults
        if (processorsUsed > availableProcessors) {
            );  
            final ThreadPoolStats.Stats stats = stats(threadPool, threadPoolName);  
                taskLatch.await();
        sizes.put(ThreadPool.Names.FETCH_SHARD_STARTED, ThreadPool::twiceAllocatedProcessors);
            .build();
        ThreadPool threadPool = null;
        final Map<String, Function<Integer, Integer>> sizes = new HashMap<>();
    private int expectedSize(final String threadPoolName, final int numberOfProcessors) {
            maxBasedOnNumberOfProcessors = expectedSize(threadPoolName, processors);
        sizes.put(ThreadPool.Names.MERGE, n -> n);  
import java.util.concurrent.Executor;
/*  
            assertThat(stats.getQueue(), equalTo(numberOfTasks - size));
        sizes.put(ThreadPool.Names.FLUSH, ThreadPool::halfAllocatedProcessorsMaxFive);
            for (int i = 0; i < 128; i++) {  
            assertThat(openSearchThreadPoolExecutor.getQueue().remainingCapacity(), equalTo(Integer.MAX_VALUE));  
import java.util.concurrent.TimeUnit;  
        } else {
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
            final CountDownLatch latch = new CountDownLatch(1);
 * SPDX-License-Identifier: Apache-2.0
                    + availableProcessors
        } else {
            // this while loop is the core of this test; if threads
 * this work for additional information regarding copyright
    }
        sizes.put(ThreadPool.Names.REFRESH, ThreadPool::halfAllocatedProcessorsMaxTen);  
            assertEquals(128, threads);
    }
        sizes.put(ThreadPool.Names.FETCH_SHARD_STORE, ThreadPool::twiceAllocatedProcessors);
        });  
        });  
import java.util.Collection;
    }
        return ThreadPool.THREAD_POOL_TYPES.entrySet()  
import static org.hamcrest.CoreMatchers.instanceOf;
                        latch.await();  
 */
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
                    + "] which is more than available processors ["  
        if (randomBoolean()) {
            .put("thread_pool." + threadPoolName + ".keep_alive", "1ms")
            builder.put("node.processors", processors);  
 * The OpenSearch Contributors require contributions made to  
        sizes.put(ThreadPool.Names.REMOTE_DOWNLOAD, ThreadPool::twiceAllocatedProcessors);
            final String test = Thread.currentThread().getStackTrace()[2].getMethodName();
    }  
                spinForAtLeastOneMillisecond();
            }  
        final Settings.Builder builder = Settings.builder();
    public void testScalingThreadPoolConfiguration() throws InterruptedException {
/*  
                        latch.await();
 */  
        final Settings settings = Settings.builder()
            // down  
            final CountDownLatch taskLatch = new CountDownLatch(numberOfTasks);
        }
import org.opensearch.common.settings.Settings;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            } while (stats(threadPool, threadPoolName).getThreads() > min);  
            do {
            .map(e -> new String[] { e.getKey() })  
            latch.countDown();  
 * this file be licensed under the Apache-2.0 license or a
                throw new RuntimeException(e);
import java.util.HashMap;
                        throw new RuntimeException(e);  
import java.util.function.Function;
 * Modifications Copyright OpenSearch Contributors. See
        } finally {  
 * KIND, either express or implied.  See the License for the
package org.opensearch.threadpool;
                taskLatch.await();
        sizes.put(ThreadPool.Names.SNAPSHOT, ThreadPool::halfAllocatedProcessorsMaxFive);
        }  
        runScalingThreadPoolTest(settings, (clusterSettings, threadPool) -> {
        }
 * specific language governing permissions and limitations
        final int maxBasedOnNumberOfProcessors;
        runScalingThreadPoolTest(settings, ((clusterSettings, threadPool) -> {  
import java.util.concurrent.CountDownLatch;
            final CountDownLatch taskLatch = new CountDownLatch(128);
            assertThat(openSearchThreadPoolExecutor.getMaximumPoolSize(), equalTo(expectedMax));
        sizes.put(ThreadPool.Names.TRANSLOG_SYNC, n -> 4 * n);
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
            processorsUsed = availableProcessors;
        runScalingThreadPoolTest(builder.build(), (clusterSettings, threadPool) -> {
 * under the License.  
            try {
        if (randomBoolean()) {  
            builder.put("thread_pool." + threadPoolName + ".core", core);
        }
        final int expectedMax;
        sizes.put(ThreadPool.Names.REMOTE_RECOVERY, ThreadPool::twiceAllocatedProcessors);
                    + processorsUsed
            consumer.accept(clusterSettings, threadPool);
            .collect(Collectors.toList());
                threadPool.executor(threadPoolName).execute(() -> {  
        throws InterruptedException {
        sizes.put(ThreadPool.Names.GENERIC, n -> ThreadPool.boundedBy(4 * n, 128, 512));  
                        taskLatch.countDown();
            assertThat(info.getKeepAlive().seconds(), equalTo(keepAlive));
    }
        } else {
            expectedMax = randomIntBetween(Math.max(1, core), 16);  
            assertThat(executor, instanceOf(OpenSearchThreadPoolExecutor.class));
            maxBasedOnNumberOfProcessors = expectedSize(threadPoolName, availableProcessors);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
            } catch (InterruptedException e) {  
        try {  
    @ParametersFactory
            for (int i = 0; i < numberOfTasks; i++) {
            keepAlive = randomIntBetween(1, 300);
    public void testScalingThreadPoolThreadsAreTerminatedAfterKeepAlive() throws InterruptedException {  
                "setting [node.processors] to value ["
            final ClusterSettings clusterSettings = new ClusterSettings(nodeSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            core = "generic".equals(threadPoolName) ? 4 : 1; // the defaults  
        this.threadPoolName = threadPoolName;
            terminateThreadPoolIfNeeded(threadPool);
    public static Collection<Object[]> scalingThreadPools() {
                    }  
            }
            latch.countDown();  
                    try {
    private final String threadPoolName;
        sizes.put(ThreadPool.Names.SNAPSHOT_DELETION, n -> ThreadPool.boundedBy(4 * n, 64, 256));  
        final int core;
            } catch (InterruptedException e) {  
            processorsUsed = processors;
        sizes.put(ThreadPool.Names.TRANSLOG_TRANSFER, ThreadPool::halfAllocatedProcessors);  
                    try {
                    }
}
 *
                        taskLatch.countDown();  
        if (maxBasedOnNumberOfProcessors < core || randomBoolean()) {
import java.util.function.BiConsumer;
import java.util.Map;  
            assertThat(info.getMin(), equalTo(core));
 * compatible open source license.
            try {
        final int size = randomIntBetween(32, 512);
            .filter(t -> t.getValue().equals(ThreadPool.ThreadPoolType.SCALING))
            int threads = stats(threadPool, threadPoolName).getThreads();
    }
            }
                threadPool.executor(threadPoolName).execute(() -> {
            builder.put("thread_pool." + threadPoolName + ".keep_alive", keepAlive + "s");  
                    } catch (final InterruptedException e) {
                        throw new RuntimeException(e);
        sizes.put(ThreadPool.Names.WARMER, ThreadPool::halfAllocatedProcessorsMaxFive);
            final ThreadPool.Info info = info(threadPool, threadPoolName);  
 *
            threadPool = new ThreadPool(nodeSettings);  
        sizes.put(ThreadPool.Names.REMOTE_REFRESH_RETRY, ThreadPool::halfAllocatedProcessors);  
public class ScalingThreadPoolTests extends OpenSearchThreadPoolTestCase {
            final OpenSearchThreadPoolExecutor openSearchThreadPoolExecutor = (OpenSearchThreadPoolExecutor) executor;
        final int processorsUsed;
            core = randomIntBetween(0, 8);  
 * not use this file except in compliance with the License.
        } else {
/*
        sizes.put(ThreadPool.Names.REMOTE_PURGE, ThreadPool::halfAllocatedProcessors);
            // threads in the pool will drop to the min for the pool  
            // this test will just timeout waiting for them to idle
            }
            final CountDownLatch latch = new CountDownLatch(1);
            assertThat(info.getName(), equalTo(threadPoolName));
                    + "] is deprecated"
        final int min = "generic".equals(threadPoolName) ? 4 : 1;
            assertThat(openSearchThreadPoolExecutor.getCorePoolSize(), equalTo(core));  
            final Settings nodeSettings = Settings.builder().put(settings).put("node.name", test).build();
            assertThat(stats.getLargest(), equalTo(size));
                throw new RuntimeException(e);
        final long keepAlive;  
            assertWarnings(  
            assertThat(openSearchThreadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS), equalTo(keepAlive));  
 *  
            final int numberOfTasks = 2 * size;  
            .put("thread_pool." + threadPoolName + ".max", 128)  
 * software distributed under the License is distributed on an
 * GitHub history for details.
            assertThat(info.getThreadPoolType(), equalTo(ThreadPool.ThreadPoolType.SCALING));  
                });
        final Settings settings = Settings.builder().put("thread_pool." + threadPoolName + ".max", size).build();  
import static org.hamcrest.Matchers.equalTo;  
            expectedMax = maxBasedOnNumberOfProcessors;  
            // but if threads are not correctly idled down by the pool,
 * You may obtain a copy of the License at  
        }
                });
import java.util.stream.Collectors;  
                    } catch (final InterruptedException e) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.put("thread_pool." + threadPoolName + ".max", expectedMax);
 */  
            assertThat(info.getMax(), equalTo(expectedMax));
    public void testScalingThreadPoolIsBounded() throws InterruptedException {
            final Executor executor = threadPool.executor(threadPoolName);  
            assertNull(info.getQueueSize());
        }));  
        if (randomBoolean()) {
        sizes.put(ThreadPool.Names.MANAGEMENT, n -> 5);
    public ScalingThreadPoolTests(String threadPoolName) {  
            .stream()
import org.opensearch.common.settings.ClusterSettings;  
        return sizes.get(threadPoolName).apply(numberOfProcessors);
            // are correctly idled down by the pool, the number of
    public void runScalingThreadPoolTest(final Settings settings, final BiConsumer<ClusterSettings, ThreadPool> consumer)  
