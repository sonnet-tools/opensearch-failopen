        }
                int numTasks = randomIntBetween(1, 30);
                channels.add(channel);
                    } else {
/*
            assertEquals(0, RestCancellableNodeClient.getNumTasks());
import org.opensearch.action.search.SearchResponse;
        }
            // if the channel is already closed, the listener gets notified immediately, from the same thread.
        public void sendResponse(HttpResponse response, ActionListener<Void> listener) {}
     * associated with its corresponding channel. Either way, we need to make sure that no tasks are left in the map.
        try (TestClient testClient = new TestClient(Settings.EMPTY, threadPool, false)) {
import java.util.concurrent.CountDownLatch;
 * KIND, either express or implied.  See the License for the
     * This test verifies that no tasks are left in the map where channels and their corresponding tasks are tracked.
        private final AtomicInteger searchRequests = new AtomicInteger(0);
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(initialHttpChannels, RestCancellableNodeClient.getNumChannels());
    public void testCancelledTasks() throws Exception {
            for (Future<?> future : futures) {
 *
 */
        @Override
import org.opensearch.threadpool.TestThreadPool;
            ActionListener<Response> listener
                    throw new UnsupportedOperationException();
import org.opensearch.common.settings.Settings;
                    if (timeout == false) {
                case SearchAction.NAME:
import org.junit.Before;
 * SPDX-License-Identifier: Apache-2.0
                totalSearches += numTasks;
import org.opensearch.test.OpenSearchTestCase;
     * the newly added listener will be invoked at registration time.
import java.util.concurrent.atomic.AtomicLong;
            // no channels get closed in this test, hence we expect as many channels as we created in the map
            assertEquals(initialHttpChannels, RestCancellableNodeClient.getNumChannels());
    }
                    throw new IllegalStateException("close listener already set, only one is allowed!");
                        listener.onResponse(null);
        }
                TestHttpChannel channel = new TestHttpChannel();
            List<TestHttpChannel> channels = new ArrayList<>(numChannels);
        public InetSocketAddress getLocalAddress() {
                    closeLatch.countDown();
    public void stopThreadPool() {
                totalSearches += numTasks;
            for (int i = 0; i < numChannels; i++) {
                            // make sure that search is sometimes also called from the same thread before the task is returned
                if (closeListener.compareAndSet(null, listener) == false) {
     */
import java.net.InetSocketAddress;
            return "node";
import java.util.concurrent.atomic.AtomicReference;
                    // here the channel will be first registered, then straight-away removed from the map as the close listener is invoked
 * this work for additional information regarding copyright
                totalSearches += numTasks;
            int totalSearches = 0;
                    return searchTask;
        public boolean isOpen() {
                int numTasks = randomIntBetween(1, 30);
            ActionListener<Void> listener = closeListener.get();
        @Override
                TestHttpChannel channel = new TestHttpChannel();
import org.junit.After;
                default:
                RestCancellableNodeClient client = new RestCancellableNodeClient(nodeClient, channel);
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
                int numTasks = randomIntBetween(1, 5);
        }
            List<Future<?>> futures = new ArrayList<>();
 * ownership. Elasticsearch licenses this file to you under
            int initialHttpChannels = RestCancellableNodeClient.getNumChannels();
package org.opensearch.rest.action;
import org.opensearch.http.HttpChannel;
     * Through the {@link TestClient} we simulate a scenario where the task may complete even before it has been
            }
            if (open.compareAndSet(true, false) == false) {
/*
                    if (randomBoolean()) {
            return open.get();
import java.util.concurrent.CopyOnWriteArraySet;
    private static class TestClient extends NodeClient {
                // no need to wait here, there will be no close listener registered, nothing to wait for.
    }
    }
            int totalSearches = 0;
        private final AtomicLong counter = new AtomicLong(0);
                    if (failure) {
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
            for (int i = 0; i < numChannels; i++) {
        private final AtomicReference<ActionListener<Void>> closeListener = new AtomicReference<>();
        @Override
        try (TestClient testClient = new TestClient(Settings.EMPTY, threadPool, true)) {
            closeLatch.await();
 * You may obtain a copy of the License at
import java.util.Collections;
import java.util.concurrent.TimeUnit;
 */
     * The close listener is straight-away executed, the task is cancelled. This can even happen multiple times, it's the only case
            if (open.get() == false) {
        }
            return null;
                    futures.add(actionFuture);
        public void close() {
            assertEquals(totalSearches, nodeClient.cancelledTasks.size());
                    return task;
                assertEquals(numTasks, RestCancellableNodeClient.getNumTasks(channel));
 * GitHub history for details.
import org.opensearch.action.search.SearchRequest;
    }
        @Override
import org.opensearch.action.support.PlainListenableActionFuture;
            close();
import org.opensearch.action.search.SearchAction;
                throw new IllegalStateException("channel already closed!");
            }
import org.opensearch.http.HttpResponse;
}
            return null;
            int numChannels = randomIntBetween(1, 30);
            int initialHttpChannels = RestCancellableNodeClient.getNumChannels();
        public String getLocalNodeId() {
                            listener.onResponse(null);
        }
        }
    public void testCompletedTasks() throws Exception {
    }
                channel.awaitClose();
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
            assertEquals(totalSearches, testClient.searchRequests.get());
 *
            }
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;
            if (listener != null) {
    public void testChannelAlreadyClosed() {
    public void createThreadPool() {
            super(settings, threadPool);
import org.opensearch.action.ActionRequest;
 */
        try (TestClient nodeClient = new TestClient(Settings.EMPTY, threadPool, true)) {
            }
                        listener.onFailure(new IllegalStateException());
 *
    private class TestHttpChannel implements HttpChannel {
                future.get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.concurrent.atomic.AtomicInteger;
                }
 * Licensed to Elasticsearch under one or more contributor
     * This test verified what happens when a request comes through yet its corresponding http channel is already closed.
import org.opensearch.core.action.ActionResponse;
            assertEquals(initialHttpChannels + numChannels, RestCancellableNodeClient.getNumChannels());
            assertEquals(totalSearches, nodeClient.searchRequests.get());
public class RestCancellableNodeClientTests extends OpenSearchTestCase {
     * This test verifies the behaviour when the channel gets closed. The channel is expected to be
    @Before
import org.opensearch.tasks.Task;
                });
                    }
            assertEquals(totalSearches, testClient.searchRequests.get());
        @Override
     */
                    }
        public void addCloseListener(ActionListener<Void> listener) {
                    Task searchTask = request.createTask(counter.getAndIncrement(), "search", action.name(), null, Collections.emptyMap());
                        listener.onFailure(new IllegalStateException());
    /**
                    }
            }
    /**
                }
            switch (action.name()) {
                    searchRequests.incrementAndGet();
import java.util.concurrent.Future;
import org.opensearch.threadpool.ThreadPool;
        }
            int numChannels = randomIntBetween(1, 30);
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksAction;
            int initialHttpChannels = RestCancellableNodeClient.getNumChannels();
import org.opensearch.action.ActionType;
        private final boolean timeout;
                for (int j = 0; j < numTasks; j++) {
            }
     */
            for (int i = 0; i < numChannels; i++) {
                    client.execute(SearchAction.INSTANCE, new SearchRequest(), null);
            } else {
    @After
 * compatible open source license.
                threadPool.generic().submit(() -> {
        private final CountDownLatch closeLatch = new CountDownLatch(1);
                boolean failure = randomBoolean();
    }
 * The OpenSearch Contributors require contributions made to
 * not use this file except in compliance with the License.
                    PlainListenableActionFuture<SearchResponse> actionFuture = PlainListenableActionFuture.newListenableFuture();
                        } else {
                for (int j = 0; j < numTasks; j++) {
                }
                TestHttpChannel channel = new TestHttpChannel();
            }
        @Override
import java.util.List;
            int totalSearches = 0;
     * where we may end up registering a close listener multiple times to the channel, but the channel is already closed hence only
                listener.onResponse(null);
        }
                    client.execute(SearchAction.INSTANCE, new SearchRequest(), null);
            Request request,
    /**
                    } else {
        }
        private final Set<TaskId> cancelledTasks = new CopyOnWriteArraySet<>();
import java.util.ArrayList;
            }
import java.util.concurrent.atomic.AtomicBoolean;
        }
        public <Request extends ActionRequest, Response extends ActionResponse> Task executeLocally(
                for (int j = 0; j < numTasks; j++) {
                    RestCancellableNodeClient client = new RestCancellableNodeClient(testClient, channel);
                RestCancellableNodeClient client = new RestCancellableNodeClient(testClient, channel);
            ActionType<Response> action,
                    threadPool.generic().submit(() -> client.execute(SearchAction.INSTANCE, new SearchRequest(), actionFuture));
            }
                        if (rarely()) {
    }
                case CancelTasksAction.NAME:
/*
        ) {
        TestClient(Settings settings, ThreadPool threadPool, boolean timeout) {
            assertEquals(initialHttpChannels + numChannels, RestCancellableNodeClient.getNumChannels());
    private ThreadPool threadPool;
import org.opensearch.core.action.ActionListener;
                        listener.onResponse(null);
        private void awaitClose() throws InterruptedException {
 * Unless required by applicable law or agreed to in writing,
        @Override
                    Task task = request.createTask(counter.getAndIncrement(), "cancel_task", action.name(), null, Collections.emptyMap());
                        // test that cancel tasks is best effort, failure received are not propagated
            int numChannels = randomIntBetween(1, 30);
            assertEquals(totalSearches, testClient.cancelledTasks.size());
        }
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
 * under the License.
            for (TestHttpChannel channel : channels) {
import org.opensearch.core.tasks.TaskId;
                    assertTrue("tried to cancel the same task more than once", cancelledTasks.add(cancelTasksRequest.getTaskId()));
        @Override
     * removed and all of its corresponding tasks get cancelled.
        public InetSocketAddress getRemoteAddress() {
                        }
        private final AtomicBoolean open = new AtomicBoolean(true);
                    CancelTasksRequest cancelTasksRequest = (CancelTasksRequest) request;
                channel.close();
            this.timeout = timeout;
import org.opensearch.transport.client.node.NodeClient;
 * specific language governing permissions and limitations
                            threadPool().generic().submit(() -> listener.onResponse(null));
                }
        threadPool = new TestThreadPool(RestCancellableNodeClientTests.class.getName());
