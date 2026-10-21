        Metadata metadata,
            workerAction.run();
        DiscoveryNode node,
        } else if (task.isWorker()) {
                public void onFailure(Exception e) {
 */
            public void onResponse(Void aVoid) {
        int slices
     * <p>
                        + "be less than ["
            // TODO move the request to the correct node. maybe here or somehow do it as part of startup for reindex in general....
import org.opensearch.core.index.Index;
     * If slices are set as {@code "auto"}, this method will resolve that to a specific number based on
class BulkByScrollParallelizationHelper {
    ) {
    private BulkByScrollParallelizationHelper() {}
                );
            setWorkerCount(request, task, configuredSlices);
import java.util.Set;
        Client client,
 * under the License.
            task.setWorker(request.getRequestsPerSecond(), sliceId);
import org.opensearch.cluster.node.DiscoveryNode;
            }
     * {@link #executeSlicedAction}
 *
    ) {
        BulkByScrollTask task,
 * Unless required by applicable law or agreed to in writing,
     * Takes an action and a {@link BulkByScrollTask} and runs it with regard to whether this task is a
    /**
        String localNodeId,
                    "The number of slices ["
        }
    }
        Set<Integer> counts = new HashSet<>(countsByIndex.values());
     * node. If the task is a leader (i.e. the number of slices is more than 1), then a subrequest will be
            slices[slice] = searchRequest;
                @Override
     */
        } else {
    static <Request extends AbstractBulkByScrollRequest<Request>> void startSlicedAction(
        for (int slice = 0; slice < times; slice++) {
        ActionType<BulkByScrollResponse> action,
        ActionType<BulkByScrollResponse> action,
import org.opensearch.core.tasks.TaskId;
                @Override
import org.opensearch.action.search.SearchRequest;
        ActionListener<Void> listener
        Request request,
     * If slices are set as {@code "auto"}, this class will resolve that to a specific number based on characteristics of the source
        if (slices > 1) {
package org.opensearch.index.reindex;
        BulkByScrollTask task,
                r -> worker.onSliceResponse(listener, slice.source().slice().getId(), r),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        + IndexSettings.MAX_SLICES_PER_SCROLL.getKey()
            searchRequest.source(slicedSource);
    }
            task.setWorkerCount(slices);
        Metadata metadata,
        Request request,
        Metadata metadata,
    ) {
        Request request,
     * Takes an action created by a {@link BulkByScrollTask} and runs it with regard to whether the request is sliced or not.
    }
            if (indexMetadata != null && IndexSettings.MAX_SLICES_PER_SCROLL.get(indexMetadata.getSettings()) < totalSlices) {
        BulkByScrollTask task,
import java.util.Arrays;
        for (final SearchRequest slice : sliceIntoSubRequests(request.getSearchRequest(), IdFieldMapper.NAME, totalSlices)) {
            SearchSourceBuilder slicedSource;
 * Modifications Copyright OpenSearch Contributors. See
                    setWorkerCount(request, task, countSlicesBasedOnShards(response));
        SearchRequest[] slices = new SearchRequest[times];
        Request request,
        }
        for (String index : request.getSearchRequest().indices()) {
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
            @Override
/*
                e -> worker.onSliceFailure(listener, slice.source().slice().getId(), e)
            IndexMetadata indexMetadata = metadata.index(index);
     * If the request is not sliced (i.e. the number of slices is 1), the worker action in the given {@link Runnable} will be started on
     * leader or worker.
        return slices;
                        + "This limit can be set by changing the ["
import org.opensearch.core.action.ActionListener;
        int totalSlices = worker.getSlices();
                slicedSource = new SearchSourceBuilder().slice(sliceBuilder);
     * This method is equivalent to calling {@link #initTaskState} followed by {@link #executeSlicedAction}
                listener.onFailure(e);
import org.opensearch.action.ActionType;
    static <Request extends AbstractBulkByScrollRequest<Request>> void executeSlicedAction(
            .collect(Collectors.toMap(group -> group.getShardId().getIndex(), group -> 1, (sum, term) -> sum + term));
            throw new AssertionError("Task should have been initialized at this point.");
        LeaderBulkByScrollTaskState worker = task.getLeaderState();
     */
        DiscoveryNode node,
            } else {
     * <p>
import org.opensearch.index.mapper.IdFieldMapper;
     * characteristics of the source indices. A request with {@code "auto"} slices may end up being sliced or
            SliceBuilder sliceBuilder = request.getSearchRequest().source().slice();
}
    private static int countSlicesBasedOnShards(ClusterSearchShardsResponse response) {
     * copies of this request so don't change them.
        if (configuredSlices == AbstractBulkByScrollRequest.AUTO_SLICES) {
 */
    static SearchRequest[] sliceIntoSubRequests(SearchRequest request, String field, int times) {
        });
     * This method can only be called after the task state is initialized {@link #initTaskState}.
    }
                }
import java.util.HashSet;
import java.util.Collections;
    /**
        } else {
 */
        } else {
                executeSlicedAction(metadata, task, request, action, listener, client, node, workerAction);
                public void onResponse(ClusterSearchShardsResponse response) {
 * SPDX-License-Identifier: Apache-2.0
 */
 * The OpenSearch Contributors require contributions made to
 * not use this file except in compliance with the License.
/**
                        + " level setting."
/*
        }
                }
        ActionListener<BulkByScrollResponse> listener,
            }
        int leastShards = counts.isEmpty() ? 1 : Collections.min(counts);
import org.opensearch.cluster.metadata.Metadata;
    private static <Request extends AbstractBulkByScrollRequest<Request>> void setWorkerCount(
     * <p>
            SearchRequest searchRequest = new SearchRequest(request);
            );
        if (task.isLeader()) {
 * GitHub history for details.
     * <p>
            }
import org.opensearch.search.slice.SliceBuilder;
    private static <Request extends AbstractBulkByScrollRequest<Request>> void sendSubRequests(
        initTaskState(task, request, client, new ActionListener<Void>() {
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexMetadata;
 * specific language governing permissions and limitations
    ) {
            shardsRequest.indices(request.getSearchRequest().indices());
            ClusterSearchShardsRequest shardsRequest = new ClusterSearchShardsRequest();
     * slice and sent.
/*
     * <p>
     * unsliced. This method does not execute the action. In order to execute the action see
            Request requestForSlice = request.forSlice(parentTaskId, slice, totalSlices);
        Runnable workerAction
            }
        ActionListener<BulkByScrollResponse> listener
        }
     */
    }
 * software distributed under the License is distributed on an
        Map<Index, Integer> countsByIndex = Arrays.stream(response.getGroups())
                    listener.onFailure(e);
            listener.onResponse(null);
 * this file be licensed under the Apache-2.0 license or a
            });
        Client client,
            sendSubRequests(metadata, client, action, node.getId(), task, request, listener);
import org.opensearch.index.IndexSettings;
 * Helps parallelize reindex requests using sliced scrolls.
 * the Apache License, Version 2.0 (the "License"); you may
        Client client,
 *
    static <Request extends AbstractBulkByScrollRequest<Request>> void initTaskState(
     * Slice a search request into {@code times} separate search requests slicing on {@code field}. Note that the slices are *shallow*
        }
            public void onFailure(Exception e) {
                    listener.onResponse(null);
        }
 * ownership. Elasticsearch licenses this file to you under
                slicedSource = request.source().shallowCopy().slice(sliceBuilder);
import org.opensearch.search.builder.SearchSourceBuilder;
    }
    }
            Integer sliceId = sliceBuilder == null ? null : sliceBuilder.getId();
                }
     * If this task is a worker, the worker action in the given {@link Runnable} will be started on the local
 *    http://www.apache.org/licenses/LICENSE-2.0
    ) {
     * <p>
                        + IndexSettings.MAX_SLICES_PER_SCROLL.get(indexMetadata.getSettings())
            SliceBuilder sliceBuilder = new SliceBuilder(field, slice, times);
 *
                if (request.source().slice() != null) {
            client.admin().cluster().searchShards(shardsRequest, new ActionListener<ClusterSearchShardsResponse>() {
     * indices. A request with {@code "auto"} slices may end up being sliced or unsliced.
        int configuredSlices = request.getSlices();
                        + "]. "
 * license agreements. See the NOTICE file distributed with
                    throw new IllegalStateException("Can't slice a request that already has a slice configuration");
        Client client,
    /**
        ActionType<BulkByScrollResponse> action,
 * KIND, either express or implied.  See the License for the
     * created for each slice and sent.
            @Override
 * this work for additional information regarding copyright
                throw new IllegalArgumentException(
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
                        + "] is too large. It must "
     * the local node. If the request is sliced (i.e. the number of slices is more than 1), then a subrequest will be created for each
            if (request.source() == null) {
     */
     * Takes a {@link BulkByScrollTask} and ensures that its initial task state (leader or worker) is set.
        return Math.min(leastShards, AUTO_SLICE_CEILING);
        BulkByScrollTask task,
                        + totalSlices
        BulkByScrollTask task,
        ActionListener<BulkByScrollResponse> listener,
            client.execute(action, requestForSlice, sliceListener);
import java.util.stream.Collectors;
        Runnable workerAction
 * You may obtain a copy of the License at
        Request request,
import java.util.Map;
    /**
            ActionListener<BulkByScrollResponse> sliceListener = ActionListener.wrap(
        TaskId parentTaskId = new TaskId(localNodeId, task.getId());
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.transport.client.Client;
    static final int AUTO_SLICE_CEILING = 20;
                        + "] index"
