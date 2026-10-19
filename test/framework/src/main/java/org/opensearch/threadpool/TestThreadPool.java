        blockingLatch.countDown();
        AtomicReference<RunnableTaskExecutionListener> runnableTaskListener,  
        if (rejectingExecutor != null) {
}  
 * specific language governing permissions and limitations
            return rejectingExecutor;  
        ExecutorBuilder<?>... customBuilders
        Settings settings,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.node.Node;  
 * not use this file except in compliance with the License.
        }  
                blockingLatch.await();
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
            createRejectingExecutor();
import java.util.concurrent.ThreadPoolExecutor;
 * SPDX-License-Identifier: Apache-2.0
        super(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), name).put(settings).build(), runnableTaskListener, customBuilders);  
import java.util.concurrent.CountDownLatch;
        this(name, Settings.EMPTY, customBuilders);
    @Override
import java.util.concurrent.atomic.AtomicReference;  
        AtomicReference<RunnableTaskExecutionListener> runnableTaskListener,
            return;
            startedLatch.await();
public class TestThreadPool extends ThreadPool {
        }
 * KIND, either express or implied.  See the License for the
/*  
        try {  
    public void shutdown() {  
        blockingLatch.countDown();
        String name,  
package org.opensearch.threadpool;
    ) {  
import java.util.concurrent.ThreadFactory;
        super.shutdown();
    private volatile boolean returnRejectingExecutor = false;
        this(name, settings, null, customBuilders);  
        }
        this(name, Settings.EMPTY, runnableTaskListener, customBuilders);
 */  
        returnRejectingExecutor = true;
 *
    public TestThreadPool(
 *  
import java.util.concurrent.ExecutorService;  
 */  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    @Override  
    public void stopForcingRejections() {
    public TestThreadPool(String name, Settings settings, ExecutorBuilder<?>... customBuilders) {
/*  
        }  
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        returnRejectingExecutor = false;
 * Licensed to Elasticsearch under one or more contributor  
    }  
    }
            throw new RuntimeException(e);  
                throw new RuntimeException(e);  
            } catch (InterruptedException e) {
    }
 * You may obtain a copy of the License at  
 */
    }
    public void startForcingRejections() {  
    private synchronized void createRejectingExecutor() {
            rejectingExecutor.shutdown();  
                startedLatch.countDown();  
        CountDownLatch startedLatch = new CountDownLatch(1);  
        } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            return super.executor(name);
    public TestThreadPool(String name, ExecutorBuilder<?>... customBuilders) {
    ) {
            rejectingExecutor.shutdownNow();  
            try {
 * compatible open source license.
 * software distributed under the License is distributed on an
    private final CountDownLatch blockingLatch = new CountDownLatch(1);
        String name,
    public ExecutorService executor(String name) {
    public TestThreadPool(  
        if (returnRejectingExecutor) {
    @Override
    public void shutdownNow() {  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
        if (rejectingExecutor == null) {
        if (rejectingExecutor != null) {  
        }
        if (rejectingExecutor != null) {
        rejectingExecutor = OpenSearchExecutors.newFixed("rejecting", 1, 0, factory, getThreadContext());
    }
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
        ThreadFactory factory = OpenSearchExecutors.daemonThreadFactory("reject_thread");  
        });
        } catch (InterruptedException e) {
 *
/*
    }  
        super.shutdownNow();
 * the Apache License, Version 2.0 (the "License"); you may
        rejectingExecutor.execute(() -> {
    }  
            }
    }  
        ExecutorBuilder<?>... customBuilders
    }
    private volatile ThreadPoolExecutor rejectingExecutor;  
        }
