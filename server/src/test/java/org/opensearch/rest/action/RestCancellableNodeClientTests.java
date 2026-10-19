                    closeLatch.countDown();
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        listener.onResponse(null);
                for (int j = 0; j < numTasks; j++) {  
    }  
            assertEquals(totalSearches, testClient.searchRequests.get());
 */  
     * This test verifies the behaviour when the channel gets closed. The channel is expected to be  
                int numTasks = randomIntBetween(1, 5);  
            this.timeout = timeout;
                int numTasks = randomIntBetween(1, 30);  
        }
                        listener.onFailure(new IllegalStateException());  
 * under the License.  
                totalSearches += numTasks;
            return null;
                }  
        }  
            }
            assertEquals(totalSearches, nodeClient.cancelledTasks.size());
    public void stopThreadPool() {
                }
     * where we may end up registering a close listener multiple times to the channel, but the channel is already closed hence only  
        TestClient(Settings settings, ThreadPool threadPool, boolean timeout) {
import java.util.concurrent.atomic.AtomicInteger;  
                    futures.add(actionFuture);
    public void testChannelAlreadyClosed() {  
                for (int j = 0; j < numTasks; j++) {  
                    Task task = request.createTask(counter.getAndIncrement(), "cancel_task", action.name(), null, Collections.emptyMap());
            return null;  
                    PlainListenableActionFuture<SearchResponse> actionFuture = PlainListenableActionFuture.newListenableFuture();
        try (TestClient testClient = new TestClient(Settings.EMPTY, threadPool, false)) {  
        private void awaitClose() throws InterruptedException {  
                    RestCancellableNodeClient client = new RestCancellableNodeClient(testClient, channel);
                        }
                totalSearches += numTasks;
    }  
import org.opensearch.action.ActionRequest;
        }
        @Override
     * This test verified what happens when a request comes through yet its corresponding http channel is already closed.
            for (Future<?> future : futures) {
                    } else {
                boolean failure = randomBoolean();  
    }  
        private final AtomicReference<ActionListener<Void>> closeListener = new AtomicReference<>();
            }
import org.junit.Before;  
import org.opensearch.core.tasks.TaskId;  
                    Task searchTask = request.createTask(counter.getAndIncrement(), "search", action.name(), null, Collections.emptyMap());
                    client.execute(SearchAction.INSTANCE, new SearchRequest(), null);
    /**  
                        // test that cancel tasks is best effort, failure received are not propagated  
            closeLatch.await();
/*  
            int initialHttpChannels = RestCancellableNodeClient.getNumChannels();
                            listener.onResponse(null);
        }
            // if the channel is already closed, the listener gets notified immediately, from the same thread.  
                }  
            int totalSearches = 0;
import org.opensearch.action.search.SearchResponse;
            }  
                assertEquals(numTasks, RestCancellableNodeClient.getNumTasks(channel));  
                if (closeListener.compareAndSet(null, listener) == false) {
            }  
        }
                            // make sure that search is sometimes also called from the same thread before the task is returned
                    throw new IllegalStateException("close listener already set, only one is allowed!");
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksAction;  
                TestHttpChannel channel = new TestHttpChannel();
        private final Set<TaskId> cancelledTasks = new CopyOnWriteArraySet<>();
        public InetSocketAddress getRemoteAddress() {
        public void sendResponse(HttpResponse response, ActionListener<Void> listener) {}
        @Override
import org.opensearch.common.settings.Settings;  
        }
 * KIND, either express or implied.  See the License for the
        try (TestClient nodeClient = new TestClient(Settings.EMPTY, threadPool, true)) {
import org.opensearch.tasks.Task;  
 *
import java.util.concurrent.Future;  
 * the Apache License, Version 2.0 (the "License"); you may
}
import org.opensearch.threadpool.ThreadPool;  
import org.junit.After;
                future.get();
                throw new IllegalStateException("channel already closed!");
    private static class TestClient extends NodeClient {
            assertEquals(initialHttpChannels, RestCancellableNodeClient.getNumChannels());
    /**  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.ActionType;
                channels.add(channel);
            int totalSearches = 0;
                    CancelTasksRequest cancelTasksRequest = (CancelTasksRequest) request;  
     * associated with its corresponding channel. Either way, we need to make sure that no tasks are left in the map.  
import java.util.ArrayList;  
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
    /**
        threadPool = new TestThreadPool(RestCancellableNodeClientTests.class.getName());
            // no channels get closed in this test, hence we expect as many channels as we created in the map
 * The OpenSearch Contributors require contributions made to  
            Request request,
    }
import org.opensearch.transport.client.node.NodeClient;
            assertEquals(totalSearches, nodeClient.searchRequests.get());
                default:
                            threadPool().generic().submit(() -> listener.onResponse(null));
                case CancelTasksAction.NAME:
    }
        public <Request extends ActionRequest, Response extends ActionResponse> Task executeLocally(
                        } else {  
        private final boolean timeout;  
            ActionListener<Response> listener
import java.util.concurrent.CountDownLatch;
                    }  
    }
            assertEquals(totalSearches, testClient.cancelledTasks.size());
 * Modifications Copyright OpenSearch Contributors. See
        }
            return open.get();
 * not use this file except in compliance with the License.
                TestHttpChannel channel = new TestHttpChannel();  
    private ThreadPool threadPool;  
        @Override  
            if (listener != null) {
            List<TestHttpChannel> channels = new ArrayList<>(numChannels);
 *  
 * ownership. Elasticsearch licenses this file to you under  
                TestHttpChannel channel = new TestHttpChannel();
     * the newly added listener will be invoked at registration time.
            for (int i = 0; i < numChannels; i++) {
import org.opensearch.action.search.SearchAction;
        @Override
            List<Future<?>> futures = new ArrayList<>();  
        }  
    @After
                channel.awaitClose();
     */
                    }  
            } else {  
                // no need to wait here, there will be no close listener registered, nothing to wait for.
import org.opensearch.test.OpenSearchTestCase;
        public void addCloseListener(ActionListener<Void> listener) {
     * Through the {@link TestClient} we simulate a scenario where the task may complete even before it has been
        private final CountDownLatch closeLatch = new CountDownLatch(1);
 */
    private class TestHttpChannel implements HttpChannel {
import java.net.InetSocketAddress;
import java.util.Set;  
                RestCancellableNodeClient client = new RestCancellableNodeClient(testClient, channel);
                    if (randomBoolean()) {  
            ActionListener<Void> listener = closeListener.get();
            assertEquals(initialHttpChannels, RestCancellableNodeClient.getNumChannels());  
     */
package org.opensearch.rest.action;
            int initialHttpChannels = RestCancellableNodeClient.getNumChannels();
                    return task;
                case SearchAction.NAME:
            if (open.compareAndSet(true, false) == false) {
        }  
            for (int i = 0; i < numChannels; i++) {
        public void close() {  
    public void testCompletedTasks() throws Exception {
                    searchRequests.incrementAndGet();  
            switch (action.name()) {
        public InetSocketAddress getLocalAddress() {
    }  
import org.opensearch.core.action.ActionListener;
 * Unless required by applicable law or agreed to in writing,
                listener.onResponse(null);
 * You may obtain a copy of the License at  
import org.opensearch.core.action.ActionResponse;
                });
            int numChannels = randomIntBetween(1, 30);  
                        listener.onResponse(null);
        private final AtomicLong counter = new AtomicLong(0);  
            }  
            assertEquals(initialHttpChannels + numChannels, RestCancellableNodeClient.getNumChannels());
                threadPool.generic().submit(() -> {
            assertEquals(0, RestCancellableNodeClient.getNumTasks());  
        @Override
        private final AtomicBoolean open = new AtomicBoolean(true);  
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
            int totalSearches = 0;
            }
            for (int i = 0; i < numChannels; i++) {  
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.Collections;
                channel.close();
 * GitHub history for details.
                    } else {
        @Override
                for (int j = 0; j < numTasks; j++) {  
        @Override
                    assertTrue("tried to cancel the same task more than once", cancelledTasks.add(cancelTasksRequest.getTaskId()));
 * this work for additional information regarding copyright
            ActionType<Response> action,  
 * compatible open source license.
 */  
        public boolean isOpen() {  
        }
                        if (rarely()) {  
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);  
     * removed and all of its corresponding tasks get cancelled.
            }
 * specific language governing permissions and limitations
        private final AtomicInteger searchRequests = new AtomicInteger(0);
        }  
                    }
public class RestCancellableNodeClientTests extends OpenSearchTestCase {
        try (TestClient testClient = new TestClient(Settings.EMPTY, threadPool, true)) {
                    threadPool.generic().submit(() -> client.execute(SearchAction.INSTANCE, new SearchRequest(), actionFuture));  
import org.opensearch.action.search.SearchRequest;  
/*  
                    if (timeout == false) {
import java.util.concurrent.atomic.AtomicLong;
        @Override
                int numTasks = randomIntBetween(1, 30);  
            assertEquals(totalSearches, testClient.searchRequests.get());  
            return "node";
 * this file be licensed under the Apache-2.0 license or a
            }
     * The close listener is straight-away executed, the task is cancelled. This can even happen multiple times, it's the only case
    public void createThreadPool() {  
import org.opensearch.action.support.PlainListenableActionFuture;
                    return searchTask;
            int numChannels = randomIntBetween(1, 30);
            assertEquals(initialHttpChannels + numChannels, RestCancellableNodeClient.getNumChannels());
 *
 * software distributed under the License is distributed on an
    public void testCancelledTasks() throws Exception {  
            for (TestHttpChannel channel : channels) {  
            if (open.get() == false) {
            close();
            super(settings, threadPool);  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
                    client.execute(SearchAction.INSTANCE, new SearchRequest(), null);
                }
        ) {  
            int initialHttpChannels = RestCancellableNodeClient.getNumChannels();
                        listener.onFailure(new IllegalStateException());
                totalSearches += numTasks;
            int numChannels = randomIntBetween(1, 30);  
     * This test verifies that no tasks are left in the map where channels and their corresponding tasks are tracked.
/*
import java.util.List;
                    // here the channel will be first registered, then straight-away removed from the map as the close listener is invoked
        }
        public String getLocalNodeId() {  
                    if (failure) {
    @Before
import java.util.concurrent.atomic.AtomicBoolean;
                RestCancellableNodeClient client = new RestCancellableNodeClient(nodeClient, channel);
import org.opensearch.http.HttpChannel;
import org.opensearch.threadpool.TestThreadPool;
            }  
                    throw new UnsupportedOperationException();  
import org.opensearch.http.HttpResponse;
 *    http://www.apache.org/licenses/LICENSE-2.0
