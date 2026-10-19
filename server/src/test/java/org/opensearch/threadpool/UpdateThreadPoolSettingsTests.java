            );
            threadPool = new ThreadPool(nodeSettings);
            ThreadPool.Info info = info(threadPool, threadPoolName);
                .put("thread_pool." + threadPoolName + ".size", expectedSize)  
        String threadPoolName = randomThreadPool(ThreadPool.ThreadPoolType.SCALING);
            assertEquals(info(threadPool, threadPoolName).getThreadPoolType(), ThreadPool.ThreadPoolType.FIXED);
 * not use this file except in compliance with the License.
                OpenSearchExecutors.allocatedProcessors(Settings.EMPTY),  
            } else {
            assertThat(threadPool.executor(threadPoolName), instanceOf(OpenSearchThreadPoolExecutor.class));
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Settings.builder()  
        try {
            boolean foundPool2 = false;
import static org.hamcrest.Matchers.equalTo;
import java.util.Set;
                }
                .build();
    }  
            assertThat(threadPool.executor(threadPoolName), instanceOf(OpenSearchThreadPoolExecutor.class));  
    }
        } else {
            boolean foundPool1 = false;  
        assertThat(  
            assertThat(foundPool2, is(true));
        String threadPoolName = randomThreadPool(ThreadPool.ThreadPoolType.FIXED);
            );
        } finally {  
                    assertEquals(info.getThreadPoolType(), ThreadPool.ThreadPoolType.SCALING);
        );
                .put("thread_pool." + threadPoolName + ".queue_size", 1000)  
            }
        ThreadPool.ThreadPoolType correctThreadPoolType = ThreadPool.THREAD_POOL_TYPES.get(threadPoolName);
 * The OpenSearch Contributors require contributions made to  
 *
 * license agreements. See the NOTICE file distributed with
        }
 *
                            continue outer;
                tp = new ThreadPool(
    public void testShutdownNowInterrupts() throws Exception {
        final int maxSize = 1 + OpenSearchExecutors.allocatedProcessors(Settings.EMPTY);  
                    shutDownLatch.countDown();
/*  
    }
                    for (Field field : Names.class.getFields()) {
            initial,
                containsString("Failed to parse value [" + tooBig + "] for setting [thread_pool." + Names.WRITE + ".size] must be ")  
                } else {  
                .put("thread_pool." + threadPoolName + ".max", 10)  
 * You may obtain a copy of the License at  
/*
            int expectedSize = getExpectedThreadPoolSize(Settings.EMPTY, threadPoolName, 15);  
            try {  
            final CountDownLatch latch = new CountDownLatch(1);
        ThreadPool threadPool = null;  
            final CountDownLatch shutDownLatch = new CountDownLatch(1);  
    }  
            threadPool = new ThreadPool(
import java.util.concurrent.ThreadPoolExecutor;
 * Unless required by applicable law or agreed to in writing,
}
                "my_pool1",
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        }
        ThreadPool threadPool = null;  
    }
            assertThat(foundPool1, is(true));
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
 * specific language governing permissions and limitations
                );  
            terminateThreadPoolIfNeeded(threadPool);
    public void testCustomThreadPool() throws Exception {
                if ("my_pool1".equals(info.getName())) {  
 */  
    private static int getExpectedThreadPoolSize(Settings settings, String name, int size) {
                }
            threadPool.shutdownNow();
                    Thread.currentThread().interrupt();  
    public void testFixedExecutorType() throws InterruptedException {
                1,
import java.util.concurrent.CountDownLatch;  
            assertEquals(info(threadPool, threadPoolName).getThreadPoolType(), ThreadPool.ThreadPoolType.SCALING);  
                    foundPool2 = true;
import org.opensearch.common.settings.Settings;
                terminateThreadPoolIfNeeded(tp);
import java.util.concurrent.TimeUnit;
                    assertThat(info.getMax(), equalTo(1));
 */
 * GitHub history for details.
            final long expectedKeepAlive = "generic".equals(threadPoolName) ? 30 : 300;
                    foundPool1 = true;
            Settings nodeSettings = Settings.builder()
                    assertThat(info.getMin(), equalTo(1));  
        }
import java.lang.reflect.Field;
    }  
        ThreadPool threadPool = null;  
            assertThat(threadPool.executor(threadPoolName), instanceOf(OpenSearchThreadPoolExecutor.class));  
            terminateThreadPoolIfNeeded(threadPool);
            ThreadPool tp = null;
        if (Names.LISTENER.equals(threadPoolName)) {  
 * this work for additional information regarding copyright
import org.opensearch.threadpool.ThreadPool.Names;
            Settings nodeSettings = Settings.builder()
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
    private String randomThreadPoolName() {
                            // This is ok it is a default thread pool  
            return Math.min(size, OpenSearchExecutors.allocatedProcessors(settings));
            assertThat(info(threadPool, threadPoolName).getMax(), equalTo(10));  
        } finally {  
 * software distributed under the License is distributed on an
            ThreadPoolInfo groups = threadPool.info();
        if (Names.LISTENER.equals(threadPoolName)) {
        } finally {
        } finally {
import static org.hamcrest.Matchers.is;
        try {
                assertNull(info); // we don't report on the "same" thread pool
            ThreadPoolExecutor oldExecutor = (ThreadPoolExecutor) threadPool.executor(threadPoolName);
import static org.hamcrest.Matchers.instanceOf;
            final ScalingExecutorBuilder scaling = new ScalingExecutorBuilder(  
        }
                .build();
import static org.hamcrest.CoreMatchers.containsString;
                .put("node.name", "testScalingExecutorType")
            threadPool = new ThreadPool(Settings.builder().put("node.name", "testCustomThreadPool").build(), scaling, fixed);  
            latch.await(3, TimeUnit.SECONDS); // if this throws then ThreadPool#shutdownNow did not interrupt
 */  
            assertThat(((OpenSearchThreadPoolExecutor) threadPool.executor(threadPoolName)).getMaximumPoolSize(), equalTo(expectedSize));
                } else if ("my_pool2".equals(info.getName())) {  
            )
 *    http://www.apache.org/licenses/LICENSE-2.0
                .build();
        }
                .put("node.name", "testFixedExecutorType")
                    new CountDownLatch(1).await();  
 * Licensed to Elasticsearch under one or more contributor  
            threadPool = new ThreadPool(nodeSettings);  
                TimeValue.timeValueMinutes(1)
 * under the License.  
            final FixedExecutorBuilder fixed = new FixedExecutorBuilder(Settings.EMPTY, "my_pool2", 1, 1);
                    .build()  
    public void testCorrectThreadPoolTypePermittedInSettings() throws InterruptedException {  
        });
        String threadPoolName = randomThreadPool(ThreadPool.ThreadPoolType.FIXED);
package org.opensearch.threadpool;
                    .put("node.name", "testCorrectThreadPoolTypePermittedInSettings")
                assertEquals(info.getThreadPoolType(), correctThreadPoolType);
        return randomFrom(threadPoolNames.toArray(new String[0]));
    public void testScalingExecutorType() throws InterruptedException {
import org.opensearch.common.unit.TimeValue;
            }  
            if (ThreadPool.Names.SAME.equals(threadPoolName)) {  
                    latch.countDown();
            shutDownLatch.await();  
 * SPDX-License-Identifier: Apache-2.0
                // otherwise check we have the expected type  
            assertThat(info(threadPool, threadPoolName).getMin(), equalTo(expectedSize));  
public class UpdateThreadPoolSettingsTests extends OpenSearchThreadPoolTestCase {
                try {
            assertThat(info(threadPool, threadPoolName).getMax(), equalTo(expectedSize));
        }
            Settings nodeSettings = Settings.builder()
            assertThat(oldExecutor.isShutdown(), equalTo(true));  
            assertThat(info(threadPool, threadPoolName).getMin(), equalTo(expectedMinimum));
                ((OpenSearchThreadPoolExecutor) threadPool.executor(threadPoolName)).getKeepAliveTime(TimeUnit.MINUTES),
            hasToString(
            );  
        final int tooBig = randomIntBetween(1 + maxSize, Integer.MAX_VALUE);
            assertThat(((OpenSearchThreadPoolExecutor) threadPool.executor(threadPoolName)).getCorePoolSize(), equalTo(expectedSize));
                equalTo(0L)
            threadPool = new ThreadPool(nodeSettings);  
 * this file be licensed under the Apache-2.0 license or a
                        }
        } finally {
            terminateThreadPoolIfNeeded(threadPool);  
import static org.hamcrest.Matchers.hasToString;  
                    }  
    }
            return size;  
                    fail("Unexpected pool name: " + info.getName());
                    Settings.builder()
            threadPool.executor(threadPoolName).execute(() -> {  
        ThreadPool threadPool = null;  
            assertThat(oldExecutor.isTerminating() || oldExecutor.isTerminated(), equalTo(true));
            assertSettingDeprecationsAndWarnings(new String[] { "thread_pool.listener.size" });  
                    assertThat(info.getQueueSize().singles(), equalTo(1L));
                        if (info.getName().equalsIgnoreCase(field.getName())) {
 * Modifications Copyright OpenSearch Contributors. See
            assertSettingDeprecationsAndWarnings(new String[] { "thread_pool.listener.queue_size" });
        ThreadPool threadPool = null;  
        try {
        if (name.equals(ThreadPool.Names.WRITE) || name.equals(Names.SYSTEM_WRITE)) {  
    }  
            assertEquals(info(threadPool, threadPoolName).getQueueSize().getSingles(), 1000L);
            }  
        }  
            outer: for (ThreadPool.Info info : groups) {
        final IllegalArgumentException initial = expectThrows(IllegalArgumentException.class, () -> {
 *  
        try {
                } catch (InterruptedException ex) {
            terminateThreadPoolIfNeeded(threadPool);
                        .put("node.name", "testIndexingThreadPoolsMaxSize")  
    public void testWriteThreadPoolsMaxSize() throws InterruptedException {
        try {
                        .put("thread_pool." + Names.WRITE + ".size", tooBig)
            });
            assertThat(info(threadPool, threadPoolName).getKeepAlive().seconds(), equalTo(expectedKeepAlive));
        }
            } finally {
                        .build()
        Set<String> threadPoolNames = ThreadPool.THREAD_POOL_TYPES.keySet();  
            terminateThreadPoolIfNeeded(threadPool);  
            final int expectedMinimum = "generic".equals(threadPoolName) ? 4 : 1;
            // keep alive does not apply to fixed thread pools
                    assertEquals(info.getThreadPoolType(), ThreadPool.ThreadPoolType.FIXED);
                    .put("thread_pool." + threadPoolName + ".type", correctThreadPoolType.getType())
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
        // try to create a too big thread pool  
            assertThat(  
                .put("node.name", "testShutdownNowInterrupts")
        String threadPoolName = randomThreadPoolName();
