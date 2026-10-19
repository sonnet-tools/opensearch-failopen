import org.opensearch.cluster.metadata.IndexMetadata;
            if (indexMetadata != null && IndexSettings.MAX_SLICES_PER_SCROLL.get(indexMetadata.getSettings()) < totalSlices) {
import org.opensearch.core.index.Index;  
     * characteristics of the source indices. A request with {@code "auto"} slices may end up being sliced or
     */
    static <Request extends AbstractBulkByScrollRequest<Request>> void initTaskState(  
 * the Apache License, Version 2.0 (the "License"); you may
            client.execute(action, requestForSlice, sliceListener);
                slicedSource = request.source().shallowCopy().slice(sliceBuilder);
        }
            workerAction.run();
        ActionType<BulkByScrollResponse> action,
        ActionListener<BulkByScrollResponse> listener  
            });  
        Runnable workerAction
     * <p>  
    ) {
 */  
                if (request.source().slice() != null) {
                slicedSource = new SearchSourceBuilder().slice(sliceBuilder);  
import org.opensearch.action.ActionType;
import org.opensearch.transport.client.Client;  
    /**
     * If slices are set as {@code "auto"}, this method will resolve that to a specific number based on
    ) {
        }
        String localNodeId,  
import org.opensearch.cluster.metadata.Metadata;  
                public void onResponse(ClusterSearchShardsResponse response) {  
        } else if (task.isWorker()) {  
        } else {
}
            public void onResponse(Void aVoid) {  
                public void onFailure(Exception e) {  
     */
            }
                    setWorkerCount(request, task, countSlicesBasedOnShards(response));
        BulkByScrollTask task,  
            }
     * copies of this request so don't change them.
        Request request,  
        int leastShards = counts.isEmpty() ? 1 : Collections.min(counts);
            );  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * If slices are set as {@code "auto"}, this class will resolve that to a specific number based on characteristics of the source
    }  
    ) {
import org.opensearch.search.slice.SliceBuilder;
        } else {
     * <p>  
                }
            SearchRequest searchRequest = new SearchRequest(request);
 * software distributed under the License is distributed on an
        ActionListener<BulkByScrollResponse> listener,
     * This method can only be called after the task state is initialized {@link #initTaskState}.
            } else {
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;  
     * <p>  
        Metadata metadata,  
import org.opensearch.core.tasks.TaskId;
        return Math.min(leastShards, AUTO_SLICE_CEILING);
import java.util.Arrays;
    }  
        Client client,
     */
            throw new AssertionError("Task should have been initialized at this point.");  
        BulkByScrollTask task,
 * Modifications Copyright OpenSearch Contributors. See
                    throw new IllegalStateException("Can't slice a request that already has a slice configuration");  
                }  
                        + IndexSettings.MAX_SLICES_PER_SCROLL.getKey()
                    listener.onResponse(null);
    }
 * You may obtain a copy of the License at  
 * under the License.  
        LeaderBulkByScrollTaskState worker = task.getLeaderState();  
        Client client,  
            setWorkerCount(request, task, configuredSlices);
        ActionType<BulkByScrollResponse> action,
     * Takes an action and a {@link BulkByScrollTask} and runs it with regard to whether this task is a  
 * The OpenSearch Contributors require contributions made to  
     * slice and sent.
 *  
                        + "This limit can be set by changing the ["  
    ) {  
 * Licensed to Elasticsearch under one or more contributor  
    }
import java.util.Collections;  
                }
        }
        TaskId parentTaskId = new TaskId(localNodeId, task.getId());
            @Override
 * not use this file except in compliance with the License.
    ) {  
    private static <Request extends AbstractBulkByScrollRequest<Request>> void sendSubRequests(
                throw new IllegalArgumentException(
                        + "be less than ["  
 * compatible open source license.
import org.opensearch.search.builder.SearchSourceBuilder;
    static SearchRequest[] sliceIntoSubRequests(SearchRequest request, String field, int times) {  
                @Override
    private BulkByScrollParallelizationHelper() {}
/**  
 * this work for additional information regarding copyright
                        + "] index"
            IndexMetadata indexMetadata = metadata.index(index);  
package org.opensearch.index.reindex;
        for (String index : request.getSearchRequest().indices()) {
 * license agreements. See the NOTICE file distributed with
        }  
import java.util.Map;
        DiscoveryNode node,
    /**
     * {@link #executeSlicedAction}
        BulkByScrollTask task,
                r -> worker.onSliceResponse(listener, slice.source().slice().getId(), r),
            }  
     * leader or worker.
        }
 * SPDX-License-Identifier: Apache-2.0
            task.setWorkerCount(slices);
            SearchSourceBuilder slicedSource;
            ActionListener<BulkByScrollResponse> sliceListener = ActionListener.wrap(  
            .collect(Collectors.toMap(group -> group.getShardId().getIndex(), group -> 1, (sum, term) -> sum + term));
 * this file be licensed under the Apache-2.0 license or a
                listener.onFailure(e);  
        DiscoveryNode node,
            public void onFailure(Exception e) {
    }  
            slices[slice] = searchRequest;  
    static <Request extends AbstractBulkByScrollRequest<Request>> void executeSlicedAction(  
     * the local node. If the request is sliced (i.e. the number of slices is more than 1), then a subrequest will be created for each
import org.opensearch.index.mapper.IdFieldMapper;  
     * Takes a {@link BulkByScrollTask} and ensures that its initial task state (leader or worker) is set.
     * This method is equivalent to calling {@link #initTaskState} followed by {@link #executeSlicedAction}
     * If the request is not sliced (i.e. the number of slices is 1), the worker action in the given {@link Runnable} will be started on  
                    listener.onFailure(e);
            client.admin().cluster().searchShards(shardsRequest, new ActionListener<ClusterSearchShardsResponse>() {
        ActionListener<Void> listener
            sendSubRequests(metadata, client, action, node.getId(), task, request, listener);
                        + totalSlices
     * Slice a search request into {@code times} separate search requests slicing on {@code field}. Note that the slices are *shallow*  
        Metadata metadata,
/*  
     * created for each slice and sent.
        Client client,  
        int configuredSlices = request.getSlices();  
     * <p>  
        Request request,
    private static <Request extends AbstractBulkByScrollRequest<Request>> void setWorkerCount(
 */
        initTaskState(task, request, client, new ActionListener<Void>() {
/*  
        BulkByScrollTask task,
     * <p>
 */  
 * ownership. Elasticsearch licenses this file to you under  
    }  
    static <Request extends AbstractBulkByScrollRequest<Request>> void startSlicedAction(  
            if (request.source() == null) {
        Runnable workerAction
/*
        SearchRequest[] slices = new SearchRequest[times];
import java.util.HashSet;
class BulkByScrollParallelizationHelper {  
        return slices;
        if (configuredSlices == AbstractBulkByScrollRequest.AUTO_SLICES) {
     * unsliced. This method does not execute the action. In order to execute the action see  
            Integer sliceId = sliceBuilder == null ? null : sliceBuilder.getId();
 *
    private static int countSlicesBasedOnShards(ClusterSearchShardsResponse response) {  
        ActionListener<BulkByScrollResponse> listener,
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
 * specific language governing permissions and limitations
        Request request,
        Metadata metadata,
            shardsRequest.indices(request.getSearchRequest().indices());  
        BulkByScrollTask task,  
    /**
            Request requestForSlice = request.forSlice(parentTaskId, slice, totalSlices);
            @Override
        if (slices > 1) {  
    static final int AUTO_SLICE_CEILING = 20;
import org.opensearch.cluster.node.DiscoveryNode;
            searchRequest.source(slicedSource);
     * indices. A request with {@code "auto"} slices may end up being sliced or unsliced.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.IndexSettings;
                        + " level setting."  
     */
                @Override
        Map<Index, Integer> countsByIndex = Arrays.stream(response.getGroups())
                        + "] is too large. It must "
        Client client,  
import java.util.stream.Collectors;
            listener.onResponse(null);  
 * Unless required by applicable law or agreed to in writing,
        }  
            }
        Request request,
                e -> worker.onSliceFailure(listener, slice.source().slice().getId(), e)
        for (final SearchRequest slice : sliceIntoSubRequests(request.getSearchRequest(), IdFieldMapper.NAME, totalSlices)) {  
            // TODO move the request to the correct node. maybe here or somehow do it as part of startup for reindex in general....
        if (task.isLeader()) {
        Request request,
    }
     * Takes an action created by a {@link BulkByScrollTask} and runs it with regard to whether the request is sliced or not.
 * GitHub history for details.
     * node. If the task is a leader (i.e. the number of slices is more than 1), then a subrequest will be
                    "The number of slices ["  
            SliceBuilder sliceBuilder = request.getSearchRequest().source().slice();  
        });
            task.setWorker(request.getRequestsPerSecond(), sliceId);
                );
 * KIND, either express or implied.  See the License for the
import java.util.Set;  
        } else {
     * If this task is a worker, the worker action in the given {@link Runnable} will be started on the local  
                        + IndexSettings.MAX_SLICES_PER_SCROLL.get(indexMetadata.getSettings())
    /**  
import org.opensearch.action.search.SearchRequest;
        for (int slice = 0; slice < times; slice++) {
        ActionType<BulkByScrollResponse> action,
import org.opensearch.core.action.ActionListener;
 */
 * Helps parallelize reindex requests using sliced scrolls.
                executeSlicedAction(metadata, task, request, action, listener, client, node, workerAction);
 *
     * <p>
            ClusterSearchShardsRequest shardsRequest = new ClusterSearchShardsRequest();
            SliceBuilder sliceBuilder = new SliceBuilder(field, slice, times);  
                        + "]. "
        Set<Integer> counts = new HashSet<>(countsByIndex.values());  
        int totalSlices = worker.getSlices();
        int slices
