        });
                try {
                    shutDownLatch.countDown();
            terminateThreadPoolIfNeeded(threadPool);
            threadPool = new ThreadPool(nodeSettings);
    }
            assertThat(info(threadPool, threadPoolName).getMax(), equalTo(10));
        );
}
            assertThat(threadPool.executor(threadPoolName), instanceOf(OpenSearchThreadPoolExecutor.class));
            assertThat(((OpenSearchThreadPoolExecutor) threadPool.executor(threadPoolName)).getCorePoolSize(), equalTo(expectedSize));
                TimeValue.timeValueMinutes(1)
            outer: for (ThreadPool.Info info : groups) {
    public void testWriteThreadPoolsMaxSize() throws InterruptedException {
                    foundPool2 = true;
            assertThat(
        ThreadPool threadPool = null;
import org.opensearch.common.unit.TimeValue;
                .put("thread_pool." + threadPoolName + ".max", 10)
        try {
    }
    private static int getExpectedThreadPoolSize(Settings settings, String name, int size) {
        }
            assertThat(foundPool2, is(true));
import static org.hamcrest.Matchers.equalTo;
            assertSettingDeprecationsAndWarnings(new String[] { "thread_pool.listener.queue_size" });
            threadPool.executor(threadPoolName).execute(() -> {
                .put("node.name", "testShutdownNowInterrupts")
            assertThat(((OpenSearchThreadPoolExecutor) threadPool.executor(threadPoolName)).getMaximumPoolSize(), equalTo(expectedSize));
 * The OpenSearch Contributors require contributions made to
            assertThat(oldExecutor.isTerminating() || oldExecutor.isTerminated(), equalTo(true));
            );
    public void testShutdownNowInterrupts() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        } finally {
package org.opensearch.threadpool;
 * not use this file except in compliance with the License.
            );
                equalTo(0L)
import java.lang.reflect.Field;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                OpenSearchExecutors.allocatedProcessors(Settings.EMPTY),
                .build();
import static org.hamcrest.Matchers.instanceOf;
            assertThat(info(threadPool, threadPoolName).getMin(), equalTo(expectedMinimum));
                    }
        } finally {
                        if (info.getName().equalsIgnoreCase(field.getName())) {
                .build();
            final int expectedMinimum = "generic".equals(threadPoolName) ? 4 : 1;
                    .put("thread_pool." + threadPoolName + ".type", correctThreadPoolType.getType())
import java.util.Set;
        ThreadPool.ThreadPoolType correctThreadPoolType = ThreadPool.THREAD_POOL_TYPES.get(threadPoolName);
            } else {
                "my_pool1",
 */
            return size;
/*
        // try to create a too big thread pool
    }
            final long expectedKeepAlive = "generic".equals(threadPoolName) ? 30 : 300;
            latch.await(3, TimeUnit.SECONDS); // if this throws then ThreadPool#shutdownNow did not interrupt
                1,
import static org.hamcrest.Matchers.hasToString;
                            // This is ok it is a default thread pool
        try {
            if (ThreadPool.Names.SAME.equals(threadPoolName)) {
import org.opensearch.common.settings.Settings;
                    foundPool1 = true;
 * license agreements. See the NOTICE file distributed with
            threadPool.shutdownNow();
                        }
 *
    public void testCustomThreadPool() throws Exception {
            Settings nodeSettings = Settings.builder()
    }
        String threadPoolName = randomThreadPool(ThreadPool.ThreadPoolType.SCALING);
        } finally {
                .put("node.name", "testFixedExecutorType")
            terminateThreadPoolIfNeeded(threadPool);
            threadPool = new ThreadPool(Settings.builder().put("node.name", "testCustomThreadPool").build(), scaling, fixed);
                    Thread.currentThread().interrupt();
                ((OpenSearchThreadPoolExecutor) threadPool.executor(threadPoolName)).getKeepAliveTime(TimeUnit.MINUTES),
            } finally {
                }
                            continue outer;
        ThreadPool threadPool = null;
                        .build()
            try {
        if (Names.LISTENER.equals(threadPoolName)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                } catch (InterruptedException ex) {
            assertThat(oldExecutor.isShutdown(), equalTo(true));
 * Unless required by applicable law or agreed to in writing,
                } else {
        } finally {
            shutDownLatch.await();
    }
                    assertThat(info.getMin(), equalTo(1));
                    .put("node.name", "testCorrectThreadPoolTypePermittedInSettings")
            Settings nodeSettings = Settings.builder()
            threadPool = new ThreadPool(nodeSettings);
                containsString("Failed to parse value [" + tooBig + "] for setting [thread_pool." + Names.WRITE + ".size] must be ")
            boolean foundPool1 = false;
 * the Apache License, Version 2.0 (the "License"); you may
    }
                // otherwise check we have the expected type
        final int tooBig = randomIntBetween(1 + maxSize, Integer.MAX_VALUE);
        }
        ThreadPool threadPool = null;
            terminateThreadPoolIfNeeded(threadPool);
        final IllegalArgumentException initial = expectThrows(IllegalArgumentException.class, () -> {
            assertEquals(info(threadPool, threadPoolName).getQueueSize().getSingles(), 1000L);
                if ("my_pool1".equals(info.getName())) {
                assertNull(info); // we don't report on the "same" thread pool
            Settings nodeSettings = Settings.builder()
        ThreadPool threadPool = null;
        Set<String> threadPoolNames = ThreadPool.THREAD_POOL_TYPES.keySet();
            assertThat(info(threadPool, threadPoolName).getKeepAlive().seconds(), equalTo(expectedKeepAlive));
    public void testFixedExecutorType() throws InterruptedException {
import static org.hamcrest.CoreMatchers.containsString;
 * ownership. Elasticsearch licenses this file to you under
        }
    public void testCorrectThreadPoolTypePermittedInSettings() throws InterruptedException {
                    Settings.builder()
 * this work for additional information regarding copyright
            ThreadPool tp = null;
            terminateThreadPoolIfNeeded(threadPool);
            // keep alive does not apply to fixed thread pools
    }
                    assertEquals(info.getThreadPoolType(), ThreadPool.ThreadPoolType.SCALING);
 * Licensed to Elasticsearch under one or more contributor
                Settings.builder()
        if (Names.LISTENER.equals(threadPoolName)) {
        }
        }
                assertEquals(info.getThreadPoolType(), correctThreadPoolType);
    public void testScalingExecutorType() throws InterruptedException {
    }
                .put("node.name", "testScalingExecutorType")
import java.util.concurrent.CountDownLatch;
            assertThat(info(threadPool, threadPoolName).getMin(), equalTo(expectedSize));
        try {
 * under the License.
            hasToString(
            );
        assertThat(
        try {
 * GitHub history for details.
 * You may obtain a copy of the License at
            threadPool = new ThreadPool(nodeSettings);
            assertThat(threadPool.executor(threadPoolName), instanceOf(OpenSearchThreadPoolExecutor.class));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String threadPoolName = randomThreadPool(ThreadPool.ThreadPoolType.FIXED);
            terminateThreadPoolIfNeeded(threadPool);
            assertThat(info(threadPool, threadPoolName).getMax(), equalTo(expectedSize));
                    assertThat(info.getMax(), equalTo(1));
            )
import java.util.concurrent.ThreadPoolExecutor;
 *
                .build();
            ThreadPool.Info info = info(threadPool, threadPoolName);
 *
            threadPool = new ThreadPool(
        } finally {
 * software distributed under the License is distributed on an
            final ScalingExecutorBuilder scaling = new ScalingExecutorBuilder(
        ThreadPool threadPool = null;
        String threadPoolName = randomThreadPoolName();
 */
                terminateThreadPoolIfNeeded(tp);
            assertEquals(info(threadPool, threadPoolName).getThreadPoolType(), ThreadPool.ThreadPoolType.FIXED);
                } else if ("my_pool2".equals(info.getName())) {
        }
/*
 */
            ThreadPoolExecutor oldExecutor = (ThreadPoolExecutor) threadPool.executor(threadPoolName);
 * SPDX-License-Identifier: Apache-2.0
            int expectedSize = getExpectedThreadPoolSize(Settings.EMPTY, threadPoolName, 15);
        }
 * compatible open source license.
        } else {
            }
                );
                    fail("Unexpected pool name: " + info.getName());
                    for (Field field : Names.class.getFields()) {
            assertThat(foundPool1, is(true));
 * specific language governing permissions and limitations
            final CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.TimeUnit;
                    latch.countDown();
                    assertThat(info.getQueueSize().singles(), equalTo(1L));
        return randomFrom(threadPoolNames.toArray(new String[0]));
                    assertEquals(info.getThreadPoolType(), ThreadPool.ThreadPoolType.FIXED);
            });
/*
        final int maxSize = 1 + OpenSearchExecutors.allocatedProcessors(Settings.EMPTY);
            boolean foundPool2 = false;
 * Modifications Copyright OpenSearch Contributors. See
        try {
                .put("thread_pool." + threadPoolName + ".size", expectedSize)
                    new CountDownLatch(1).await();
import static org.hamcrest.Matchers.is;
        }
            assertEquals(info(threadPool, threadPoolName).getThreadPoolType(), ThreadPool.ThreadPoolType.SCALING);
                tp = new ThreadPool(
            ThreadPoolInfo groups = threadPool.info();
                    .build()
 * KIND, either express or implied.  See the License for the
            }
            }
        if (name.equals(ThreadPool.Names.WRITE) || name.equals(Names.SYSTEM_WRITE)) {
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
                        .put("thread_pool." + Names.WRITE + ".size", tooBig)
                }
            final FixedExecutorBuilder fixed = new FixedExecutorBuilder(Settings.EMPTY, "my_pool2", 1, 1);
public class UpdateThreadPoolSettingsTests extends OpenSearchThreadPoolTestCase {
    private String randomThreadPoolName() {
        String threadPoolName = randomThreadPool(ThreadPool.ThreadPoolType.FIXED);
import org.opensearch.threadpool.ThreadPool.Names;
                        .put("node.name", "testIndexingThreadPoolsMaxSize")
            return Math.min(size, OpenSearchExecutors.allocatedProcessors(settings));
            assertThat(threadPool.executor(threadPoolName), instanceOf(OpenSearchThreadPoolExecutor.class));
            assertSettingDeprecationsAndWarnings(new String[] { "thread_pool.listener.size" });
            final CountDownLatch shutDownLatch = new CountDownLatch(1);
            initial,
                .put("thread_pool." + threadPoolName + ".queue_size", 1000)
