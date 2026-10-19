        final AtomicBoolean rejected = new AtomicBoolean();
            }  
 *
            .build();  
 * Modifications Copyright OpenSearch Contributors. See
}  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testRejectedExecutionExceptionContainsNodeName() {  
                assertThat(e, hasToString(containsString("name = es-thread-pool-executor-tests/" + executor + ", ")));
    protected Settings nodeSettings() {
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.containsString;
                }  
        assertTrue(rejected.get());  
        latch.countDown();
            protected void doRun() throws Exception {  
 */
        }
 * not use this file except in compliance with the License.
    }
        for (int i = 0; i < fill; i++) {  
 */  
        node().injector().getInstance(ThreadPool.class).executor(executor).execute(new AbstractRunnable() {
            node().injector().getInstance(ThreadPool.class).executor(executor).execute(() -> {
/*
            .put("node.name", "es-thread-pool-executor-tests")
 *
import java.util.concurrent.atomic.AtomicBoolean;  
 * specific language governing permissions and limitations
 */  
 * SPDX-License-Identifier: Apache-2.0
            .put("thread_pool.search.queue_size", 1)
            public void onRejection(final Exception e) {  
 * the Apache License, Version 2.0 (the "License"); you may
                try {
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
    }
                    latch.await();  
/*  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
package org.opensearch.common.util.concurrent;
 * Licensed to Elasticsearch under one or more contributor  
        });  
        return Settings.builder()  
 * ownership. Elasticsearch licenses this file to you under  
    }
 *  
                    throw new RuntimeException(e);
        runThreadPoolExecutorTest(1, ThreadPool.Names.WRITE);
/*  
            .put("thread_pool.search.size", 1)
            public void onFailure(final Exception e) {
            .put("thread_pool.write.size", 1)
            }
            });
 * this work for additional information regarding copyright
            @Override
 * compatible open source license.
            .put("thread_pool.write.queue_size", 0)  
import org.opensearch.common.settings.Settings;
                rejected.set(true);
 * license agreements. See the NOTICE file distributed with
            @Override  
    @Override
 * this file be licensed under the Apache-2.0 license or a
    private void runThreadPoolExecutorTest(final int fill, final String executor) {
            }  
import static org.hamcrest.Matchers.hasToString;  
import org.opensearch.threadpool.ThreadPool;  
 * KIND, either express or implied.  See the License for the
 * under the License.  
                } catch (final InterruptedException e) {
        runThreadPoolExecutorTest(2, ThreadPool.Names.SEARCH);  
        // we test a fixed and an auto-queue executor but not scaling since it does not reject
            @Override
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.CountDownLatch;
public class OpenSearchThreadPoolExecutorTests extends OpenSearchSingleNodeTestCase {
        final CountDownLatch latch = new CountDownLatch(1);
