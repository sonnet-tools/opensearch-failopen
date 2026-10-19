        for (int i = 0; i < request.requests().size(); i++) {
        final ActionListener<MultiSearchResponse> listener,  
import java.util.concurrent.TimeUnit;
             * earlier requests that have already completed will poll from the queue too and they could complete before later polls are  
    }
     * it is a good enough default for most cases, if not then the default should be overwritten in the request itself.
            maxConcurrentSearches = defaultMaxConcurrentSearches(allocatedProcessors, clusterState);
 * specific language governing permissions and limitations
        this.threadPool = threadPool;
         * same thread as when the request was submitted, we should not recurse lest we might descend into a stack overflow. To avoid this,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    static int defaultMaxConcurrentSearches(final int allocatedProcessors, final ClusterState state) {
    void executeSearch(
     * @param requests the queue of multi-search requests to execute  
                        // we are on the same thread, we need to fork to another thread to avoid recursive stack overflow on a single thread  
        final Thread thread = Thread.currentThread();
                    assert requests.isEmpty();
            /*
        Queue<SearchRequestSlot> searchRequestSlots = new ConcurrentLinkedQueue<>();
                        threadPool.generic()
            @Override
                    }  
     * Slots a search request
        ClusterService clusterService,  
             * that we only poll here no more times than the number of requests. However, this is not the only consumer of this queue as
import java.util.function.LongSupplier;  
            private void finish() {
            CancellableTask task = taskManager.getCancellableTask(taskId.getId());  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
            }  
            private long buildTookInMillis() {
            /**
/**
     * request is executed, a permit is taken on the specified semaphore, and released as each request completes.
import org.opensearch.common.inject.Inject;  
        }
/*  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.service.ClusterService;
            return;  
 * The OpenSearch Contributors require contributions made to  
             */
    ) {
         * or we do not (this can happen if the request does not resolve to any shards). If we do not go asynchronous, we are going to come
import java.util.concurrent.atomic.AtomicInteger;
        final AtomicInteger responseCounter,
import org.opensearch.core.tasks.TaskId;
        this.threadPool = threadPool;  
                listener.onResponse(
import org.opensearch.tasks.CancellableTask;
            private void handleResponse(final int responseSlot, final MultiSearchResponse.Item item) {
import org.opensearch.core.tasks.TaskCancelledException;  
        final Queue<SearchRequestSlot> requests,  
    }  
        this.relativeTimeProvider = relativeTimeProvider;  
            }
                    while ((request = requests.poll()) != null) {  
        this.client = client;
 * ownership. Elasticsearch licenses this file to you under  
        TransportService transportService,
     * This is not perfect and makes a big assumption, that all nodes have the same thread pool size / have the number of processors and  
 * under the License.  
    private boolean isCancelled(TaskId taskId) {
        final int responseSlot;
 *
        final AtomicArray<MultiSearchResponse.Item> responses,
import org.opensearch.transport.client.node.NodeClient;  
 *
import org.opensearch.common.util.concurrent.AtomicArray;
     * @param listener the listener attached to the multi-search request  
        ClusterState clusterState = clusterService.state();
        this.allocatedProcessors = allocatedProcessors;
                        // we are on a different thread (we went asynchronous), it's safe to recurse
                }
import org.opensearch.cluster.ClusterState;  
                            finish();
 * Unless required by applicable law or agreed to in writing,
        this.relativeTimeProvider = System::nanoTime;
import org.opensearch.cluster.block.ClusterBlockLevel;
                    finish();
                    SearchRequestSlot request;
        int allocatedProcessors,
        final long relativeStartTime = relativeTimeProvider.getAsLong();  
    TransportMultiSearchAction(
        int maxConcurrentSearches = request.maxConcurrentSearchRequests();
        ThreadPool threadPool,  
 */  
             * Builds how long it took to execute the msearch.
 * @opensearch.internal
    ) {
        client.search(request.request, new ActionListener<SearchResponse>() {
        this.clusterService = clusterService;
        }
    private final int allocatedProcessors;  
        NodeClient client  
        ClusterService clusterService,
        if (maxConcurrentSearches == MultiSearchRequest.MAX_CONCURRENT_SEARCH_REQUESTS_DEFAULT) {  
        int numDateNodes = state.getNodes().getDataNodes().size();
                    // Drain the rest of the queue
import org.opensearch.action.support.HandledTransportAction;
        });
        SearchRequestSlot(SearchRequest request, int responseSlot) {
        clusterState.blocks().globalBlockedRaiseException(ClusterBlockLevel.READ);  
                );
                if (responseCounter.decrementAndGet() == 0) {  
import org.opensearch.action.support.ActionFilters;
        for (int i = 0; i < numConcurrentSearches; i++) {  
             * invoked here. Thus, it can be the case that we poll here and the queue was empty.
    protected void doExecute(Task task, MultiSearchRequest request, ActionListener<MultiSearchResponse> listener) {
                            new MultiSearchResponse.Item(null, new TaskCancelledException("Parent task was cancelled"))  
        this.clusterService = clusterService;
         */  
/*
                return TimeUnit.NANOSECONDS.toMillis(relativeTimeProvider.getAsLong() - relativeStartTime);
        LongSupplier relativeTimeProvider,
                        responses.set(
    }  
            public void onResponse(final SearchResponse searchResponse) {
 * Perform action for a multi search  
            }  
        final AtomicArray<MultiSearchResponse.Item> responses = new AtomicArray<>(numRequests);  
                            assert requests.isEmpty();  
     * @param responses atomic array to hold the responses corresponding to each search request slot
                        if (responseCounter.decrementAndGet() == 0) {
    @Inject  
     */
         * With a request in hand, we are now prepared to execute the search request. There are two possibilities, either we go asynchronous
            }
                    if (thread == Thread.currentThread()) {
    /**
    }
        return false;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.TransportService;
            this.request = request;
        if (request == null) {
            SearchRequest searchRequest = request.requests().get(i);  
 *  
        final SearchRequest request;
                        executeSearch(requests, responses, responseCounter, listener, relativeStartTime);
        if (taskId.isSet()) {
     */  
        int numRequests = request.requests().size();
        return Math.max(1, numDateNodes * defaultSearchThreadPoolSize);
        }
    private final LongSupplier relativeTimeProvider;  
 * this work for additional information regarding copyright
                    }  
     * @opensearch.internal  
                            .execute(() -> executeSearch(requests, responses, responseCounter, listener, relativeStartTime));
         * back on the same thread that attempted to execute the search request. At this point, or any other point where we come back on the  
            searchRequest.setParentTask(client.getLocalNodeId(), task.getId());
             * The number of times that we poll an item from the queue here is the minimum of the number of requests and the maximum number  
 * not use this file except in compliance with the License.
        super(MultiSearchAction.NAME, transportService, actionFilters, (Writeable.Reader<MultiSearchRequest>) MultiSearchRequest::new);  
            executeSearch(searchRequestSlots, responses, responseCounter, listener, relativeStartTime);
        NodeClient client
     * Executes a single request from the queue of requests. When a request finishes, another request is taken from the queue. When a  
            searchRequestSlots.add(new SearchRequestSlot(searchRequest, i));
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
    private final ThreadPool threadPool;
    private final ClusterService clusterService;
                    new MultiSearchResponse(responses.toArray(new MultiSearchResponse.Item[responses.length()]), buildTookInMillis())  
 */  
    private final NodeClient client;
                        }
 * Modifications Copyright OpenSearch Contributors. See
        int numConcurrentSearches = Math.min(numRequests, maxConcurrentSearches);
public class TransportMultiSearchAction extends HandledTransportAction<MultiSearchRequest, MultiSearchResponse> {
            this.responseSlot = responseSlot;  
import java.util.Queue;
    public TransportMultiSearchAction(
        final long relativeStartTime
        final int defaultSearchThreadPoolSize = Math.min(ThreadPool.searchThreadPoolSize(allocatedProcessors), 10);
            public void onFailure(final Exception e) {  
    }
                        );
            return task != null && task.isCancelled();
 */
                responses.set(responseSlot, item);
import org.opensearch.tasks.Task;  
import java.util.concurrent.ConcurrentLinkedQueue;  
 * You may obtain a copy of the License at  
        this.allocatedProcessors = OpenSearchExecutors.allocatedProcessors(settings);  
            @Override  
     *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        this.client = client;
                handleResponse(request.responseSlot, new MultiSearchResponse.Item(null, e));
import org.opensearch.threadpool.ThreadPool;
        Settings settings,
    /*
                } else if (isCancelled(request.request.getParentTask())) {  
             * of concurrent requests. At first glance, it appears that we should never poll from the queue and not obtain a request given
        ActionFilters actionFilters,  
/*  
        TransportService transportService,
     *
    ) {
 * the Apache License, Version 2.0 (the "License"); you may
        final AtomicInteger responseCounter = new AtomicInteger(numRequests);
                } else {
    static final class SearchRequestSlot {
        }
        }
    }
             */  
    /**  
     * that shard of the indices the search requests go to are more or less evenly distributed across all nodes in the cluster. But I think
                handleResponse(request.responseSlot, new MultiSearchResponse.Item(searchResponse, null));
        /*  
import org.opensearch.core.action.ActionListener;
 * KIND, either express or implied.  See the License for the
        // we bound the default concurrency to preserve some search thread pool capacity for other searches  
        SearchRequestSlot request = requests.poll();  
        ThreadPool threadPool,  
        }  
    }  
    @Override
import org.opensearch.core.common.io.stream.Writeable;
 * software distributed under the License is distributed on an
        super(MultiSearchAction.NAME, transportService, actionFilters, (Writeable.Reader<MultiSearchRequest>) MultiSearchRequest::new);
                            request.responseSlot,
 * GitHub history for details.
        ActionFilters actionFilters,
     * @param responseCounter incremented on each response
package org.opensearch.action.search;
     */
         * when we handle the response rather than going recursive, we fork to another thread, otherwise we recurse.
}  
            }
 * Licensed to Elasticsearch under one or more contributor  
                    } else {  
