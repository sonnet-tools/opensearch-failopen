        final int size = randomIntBetween(1, OpenSearchExecutors.allocatedProcessors(Settings.EMPTY));
                    }
            // wait for the submitted tasks to be consumed by the thread
            // submissions to queue  
            // these tasks will fill the thread pool queue  
            for (int i = 0; i < size; i++) {  
                        latch.countDown();  
 * specific language governing permissions and limitations
        final String threadPoolName = randomThreadPool(ThreadPool.ThreadPoolType.FIXED);
    }
            // these tasks will consume the thread pool causing further
        // some of the fixed thread pool are bound by the number of
import static org.hamcrest.CoreMatchers.equalTo;
            .build();
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            threadPool = new ThreadPool(nodeSettings);  
 * You may obtain a copy of the License at  
            terminateThreadPoolIfNeeded(threadPool);
        if (Names.LISTENER.equals(threadPoolName)) {
            .put("thread_pool." + threadPoolName + ".queue_size", queueSize)  
        } finally {
 * license agreements. See the NOTICE file distributed with
                }  
                } catch (OpenSearchRejectedExecutionException e) {
/*  
 * this file be licensed under the Apache-2.0 license or a
}
            }  
            final CountDownLatch latch = new CountDownLatch(size);
                        block.await();
import org.opensearch.common.settings.Settings;
            // pool  
        // cores so we can not exceed that  
 *
 */
/*
package org.opensearch.threadpool;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
                threadPool.executor(threadPoolName).execute(() -> {});
            final CountDownLatch block = new CountDownLatch(1);
                    } catch (InterruptedException e) {
 */  
            assertThat(stats(threadPool, threadPoolName).getRejected(), equalTo(rejections));  
            for (int i = 0; i < queueSize; i++) {
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * this work for additional information regarding copyright
            assertSettingDeprecationsAndWarnings(new String[] { "thread_pool.listener.queue_size", "thread_pool.listener.size" });  
 *
            }  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 */  
            latch.await();
                });
        final int queueSize = randomIntBetween(1, 16);
/*  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    try {
                threadPool.executor(threadPoolName).execute(() -> {
 * compatible open source license.
        final Settings nodeSettings = Settings.builder()  
            .put("thread_pool." + threadPoolName + ".size", size)
public class FixedThreadPoolTests extends OpenSearchThreadPoolTestCase {
    public void testRejectedExecutionCounter() throws InterruptedException {  
 * Licensed to Elasticsearch under one or more contributor  
        final long rejections = randomIntBetween(1, 16);  
                try {
 * Unless required by applicable law or agreed to in writing,
            for (int i = 0; i < rejections; i++) {
        ThreadPool threadPool = null;
        }  
                    threadPool.executor(threadPoolName).execute(() -> {});  
 *  
 * not use this file except in compliance with the License.
            long counter = 0;  
import org.opensearch.threadpool.ThreadPool.Names;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.CountDownLatch;  
 * ownership. Elasticsearch licenses this file to you under  
                        fail(e.toString());  
                    counter++;
        try {
 * software distributed under the License is distributed on an
            assertThat(counter, equalTo(rejections));
 * Modifications Copyright OpenSearch Contributors. See
            }
            .put("node.name", "testRejectedExecutionCounter")
            block.countDown();  
            // these tasks will be rejected
