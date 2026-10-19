        NodeClient client
    }
    ) {
     * it is a good enough default for most cases, if not then the default should be overwritten in the request itself.
                        executeSearch(requests, responses, responseCounter, listener, relativeStartTime);
                            finish();
 * You may obtain a copy of the License at
        ClusterService clusterService,
                } else if (isCancelled(request.request.getParentTask())) {
import org.opensearch.cluster.service.ClusterService;
     */
        if (maxConcurrentSearches == MultiSearchRequest.MAX_CONCURRENT_SEARCH_REQUESTS_DEFAULT) {
             */
import org.opensearch.core.action.ActionListener;
 * compatible open source license.
public class TransportMultiSearchAction extends HandledTransportAction<MultiSearchRequest, MultiSearchResponse> {
import org.opensearch.tasks.CancellableTask;
        final AtomicInteger responseCounter = new AtomicInteger(numRequests);
     * @opensearch.internal
        clusterState.blocks().globalBlockedRaiseException(ClusterBlockLevel.READ);
     * @param responseCounter incremented on each response
                handleResponse(request.responseSlot, new MultiSearchResponse.Item(searchResponse, null));
}
        }
        return Math.max(1, numDateNodes * defaultSearchThreadPoolSize);
import org.opensearch.cluster.ClusterState;
            SearchRequest searchRequest = request.requests().get(i);
import org.opensearch.common.inject.Inject;
        final ActionListener<MultiSearchResponse> listener,
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Executes a single request from the queue of requests. When a request finishes, another request is taken from the queue. When a
     * Slots a search request
        this.clusterService = clusterService;
        final AtomicArray<MultiSearchResponse.Item> responses = new AtomicArray<>(numRequests);
    }
        // we bound the default concurrency to preserve some search thread pool capacity for other searches
import org.opensearch.core.tasks.TaskId;
     * @param requests the queue of multi-search requests to execute
     * request is executed, a permit is taken on the specified semaphore, and released as each request completes.
        SearchRequestSlot(SearchRequest request, int responseSlot) {
 */
import org.opensearch.threadpool.ThreadPool;
 * this file be licensed under the Apache-2.0 license or a
    private final NodeClient client;
    private final int allocatedProcessors;
import java.util.concurrent.ConcurrentLinkedQueue;
                        // we are on a different thread (we went asynchronous), it's safe to recurse
        }
        this.client = client;
    void executeSearch(
                    SearchRequestSlot request;
            private void handleResponse(final int responseSlot, final MultiSearchResponse.Item item) {
        }
        final Thread thread = Thread.currentThread();
            public void onResponse(final SearchResponse searchResponse) {
    static int defaultMaxConcurrentSearches(final int allocatedProcessors, final ClusterState state) {
import org.opensearch.tasks.Task;
            CancellableTask task = taskManager.getCancellableTask(taskId.getId());
import org.opensearch.common.util.concurrent.AtomicArray;
    private final ThreadPool threadPool;
                        );
                    finish();
    private final LongSupplier relativeTimeProvider;
    }
        final long relativeStartTime
             * invoked here. Thus, it can be the case that we poll here and the queue was empty.
 * Perform action for a multi search
        /*
        if (taskId.isSet()) {
        this.relativeTimeProvider = relativeTimeProvider;
 * GitHub history for details.
        NodeClient client
        final Queue<SearchRequestSlot> requests,
        TransportService transportService,
                    assert requests.isEmpty();
 * software distributed under the License is distributed on an
            public void onFailure(final Exception e) {
        }
        this.threadPool = threadPool;
    private boolean isCancelled(TaskId taskId) {
            searchRequest.setParentTask(client.getLocalNodeId(), task.getId());
        int numDateNodes = state.getNodes().getDataNodes().size();
    @Inject
import java.util.function.LongSupplier;
        this.allocatedProcessors = OpenSearchExecutors.allocatedProcessors(settings);
        this.relativeTimeProvider = System::nanoTime;
        final int defaultSearchThreadPoolSize = Math.min(ThreadPool.searchThreadPoolSize(allocatedProcessors), 10);
    protected void doExecute(Task task, MultiSearchRequest request, ActionListener<MultiSearchResponse> listener) {
/*
        LongSupplier relativeTimeProvider,
        }
        for (int i = 0; i < request.requests().size(); i++) {
    /*
                        // we are on the same thread, we need to fork to another thread to avoid recursive stack overflow on a single thread
    }
 *
            return;
        super(MultiSearchAction.NAME, transportService, actionFilters, (Writeable.Reader<MultiSearchRequest>) MultiSearchRequest::new);
        SearchRequestSlot request = requests.poll();
     */
         * back on the same thread that attempted to execute the search request. At this point, or any other point where we come back on the
     *
             * Builds how long it took to execute the msearch.
 * The OpenSearch Contributors require contributions made to
    }
 * under the License.
        ThreadPool threadPool,
            }
                    new MultiSearchResponse(responses.toArray(new MultiSearchResponse.Item[responses.length()]), buildTookInMillis())
         */
            private void finish() {
        int numConcurrentSearches = Math.min(numRequests, maxConcurrentSearches);
/*
                listener.onResponse(
            private long buildTookInMillis() {
    static final class SearchRequestSlot {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private final ClusterService clusterService;
        this.threadPool = threadPool;
                    while ((request = requests.poll()) != null) {
 * specific language governing permissions and limitations
        });
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.tasks.TaskCancelledException;
        ThreadPool threadPool,
        int numRequests = request.requests().size();
/**
        int maxConcurrentSearches = request.maxConcurrentSearchRequests();
            }
                return TimeUnit.NANOSECONDS.toMillis(relativeTimeProvider.getAsLong() - relativeStartTime);
 * license agreements. See the NOTICE file distributed with
 */
                        responses.set(
     * This is not perfect and makes a big assumption, that all nodes have the same thread pool size / have the number of processors and
/*
        final AtomicArray<MultiSearchResponse.Item> responses,
                            .execute(() -> executeSearch(requests, responses, responseCounter, listener, relativeStartTime));
import java.util.concurrent.atomic.AtomicInteger;
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
import java.util.Queue;
            }
        }
                            request.responseSlot,
        client.search(request.request, new ActionListener<SearchResponse>() {
 *
                handleResponse(request.responseSlot, new MultiSearchResponse.Item(null, e));
        int allocatedProcessors,
                    }
    @Override
    ) {
 */
                    if (thread == Thread.currentThread()) {
            maxConcurrentSearches = defaultMaxConcurrentSearches(allocatedProcessors, clusterState);
            }
                    } else {
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.common.settings.Settings;
             */
            }
        ActionFilters actionFilters,
            @Override
package org.opensearch.action.search;
            this.request = request;
             * earlier requests that have already completed will poll from the queue too and they could complete before later polls are
                        if (responseCounter.decrementAndGet() == 0) {
        Settings settings,
     * @param listener the listener attached to the multi-search request
                if (responseCounter.decrementAndGet() == 0) {
        TransportService transportService,
    /**
                            new MultiSearchResponse.Item(null, new TaskCancelledException("Parent task was cancelled"))
    ) {
            searchRequestSlots.add(new SearchRequestSlot(searchRequest, i));
                }
             * The number of times that we poll an item from the queue here is the minimum of the number of requests and the maximum number
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
 */
            /*
    TransportMultiSearchAction(
         * or we do not (this can happen if the request does not resolve to any shards). If we do not go asynchronous, we are going to come
                    }
        return false;
    public TransportMultiSearchAction(
        super(MultiSearchAction.NAME, transportService, actionFilters, (Writeable.Reader<MultiSearchRequest>) MultiSearchRequest::new);
 * KIND, either express or implied.  See the License for the
                        threadPool.generic()
        this.client = client;
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterService clusterService,
import java.util.concurrent.TimeUnit;
                responses.set(responseSlot, item);
                            assert requests.isEmpty();
            return task != null && task.isCancelled();
         * same thread as when the request was submitted, we should not recurse lest we might descend into a stack overflow. To avoid this,
                        }
        final long relativeStartTime = relativeTimeProvider.getAsLong();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.Writeable;
 * @opensearch.internal
            /**
             * that we only poll here no more times than the number of requests. However, this is not the only consumer of this queue as
                );
             * of concurrent requests. At first glance, it appears that we should never poll from the queue and not obtain a request given
        final SearchRequest request;
    /**
            this.responseSlot = responseSlot;
 *
 *
import org.opensearch.action.support.HandledTransportAction;
import org.opensearch.transport.TransportService;
        final int responseSlot;
            @Override
import org.opensearch.transport.client.node.NodeClient;
         * when we handle the response rather than going recursive, we fork to another thread, otherwise we recurse.
        Queue<SearchRequestSlot> searchRequestSlots = new ConcurrentLinkedQueue<>();
import org.opensearch.action.support.ActionFilters;
                    // Drain the rest of the queue
            executeSearch(searchRequestSlots, responses, responseCounter, listener, relativeStartTime);
     *
        ActionFilters actionFilters,
                } else {
 * Licensed to Elasticsearch under one or more contributor
 * Unless required by applicable law or agreed to in writing,
     */
    }
     * @param responses atomic array to hold the responses corresponding to each search request slot
        if (request == null) {
    }
 * Modifications Copyright OpenSearch Contributors. See
        final AtomicInteger responseCounter,
        for (int i = 0; i < numConcurrentSearches; i++) {
        this.allocatedProcessors = allocatedProcessors;
        ClusterState clusterState = clusterService.state();
        this.clusterService = clusterService;
     * that shard of the indices the search requests go to are more or less evenly distributed across all nodes in the cluster. But I think
         * With a request in hand, we are now prepared to execute the search request. There are two possibilities, either we go asynchronous
