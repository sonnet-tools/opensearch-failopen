 * the Apache License, Version 2.0 (the "License"); you may
                }  
 * GitHub history for details.
            final CountDownLatch listenerCalled = new CountDownLatch(1);
 * compatible open source license.
public class ListenableActionFutureTests extends OpenSearchTestCase {
                    error.set(e);
            Thread networkThread = new Thread(new AbstractRunnable() {
 * ownership. Elasticsearch licenses this file to you under  
/*
                }  
    public void testListenerIsCallableFromNetworkThreads() throws Throwable {
import org.opensearch.transport.Transports;
}
                public void onResponse(Object o) {
 * KIND, either express or implied.  See the License for the
        ThreadPool threadPool = new TestThreadPool("testListenerIsCallableFromNetworkThreads");
 */
            final AtomicReference<Throwable> error = new AtomicReference<>();  
            networkThread.join();  
            future.addListener(new ActionListener<Object>() {
            }, Transports.TEST_MOCK_TRANSPORT_THREAD_PREFIX + "_testListenerIsCallableFromNetworkThread");
                @Override
 *  
                    listenerCalled.countDown();
    }
            });
                    listenerCalled.countDown();  
 * this file be licensed under the Apache-2.0 license or a
 */
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
                    future.onResponse(response);
            }
                }  
                public void onFailure(Exception e) {  
                throw error.get();  
 *
 * not use this file except in compliance with the License.
                @Override  
            networkThread.start();
                    listenerCalled.countDown();
 * license agreements. See the NOTICE file distributed with
                @Override  
            if (error.get() != null) {
package org.opensearch.action.support;
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.concurrent.atomic.AtomicReference;  
 * specific language governing permissions and limitations
        } finally {
                public void onFailure(Exception e) {
 * You may obtain a copy of the License at  
            listenerCalled.await();
import java.util.concurrent.CountDownLatch;
 */  
            final PlainListenableActionFuture<Object> future = PlainListenableActionFuture.newListenableFuture();
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
                    error.set(e);
 * software distributed under the License is distributed on an
            ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);  
 * this work for additional information regarding copyright
 *
            final Object response = new Object();
 * SPDX-License-Identifier: Apache-2.0
        }
 * Unless required by applicable law or agreed to in writing,
import java.util.concurrent.TimeUnit;
import org.opensearch.threadpool.TestThreadPool;  
 * under the License.  
import org.opensearch.threadpool.ThreadPool;
        try {  
import org.opensearch.test.OpenSearchTestCase;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
                @Override  
                protected void doRun() throws Exception {
import org.opensearch.common.util.concurrent.AbstractRunnable;  
import org.opensearch.core.action.ActionListener;
