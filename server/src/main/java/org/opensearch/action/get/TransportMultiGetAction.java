        final Map<ShardId, MultiGetShardRequest> shardRequests = new HashMap<>();
 *
                }
 */
        return metadata.isSegmentReplicationEnabled(indexName) && realtime && preference == null;
}  
                .shardId();
        Map<ShardId, MultiGetShardRequest> shardRequests
import org.opensearch.core.index.shard.ShardId;  
                shardRequest = new MultiGetShardRequest(request, shardId.getIndexName(), shardId.getId());
    }
 * SPDX-License-Identifier: Apache-2.0
                    listener.onResponse(new MultiGetResponse(responses.toArray(new MultiGetItemResponse[responses.length()])));
                    continue;
                    // create failures for all relevant requests
            String concreteSingleIndex;  
    }
            // only failures..  
 * Modifications Copyright OpenSearch Contributors. See
                .getShards(clusterState, concreteSingleIndex, item.id(), item.routing(), null)  
import org.opensearch.tasks.Task;
            }  
 * this file be licensed under the Apache-2.0 license or a
    ) {
import java.util.concurrent.atomic.AtomicInteger;  
                        responses.set(response.locations.get(i), itemResponse);
                responses.set(i, newItemFailure(item.index(), item.id(), e));
 */  
import org.opensearch.common.util.concurrent.AtomicArray;
                public void onResponse(MultiGetShardResponse response) {
 */
                    }  
 * @opensearch.internal  
                continue;
        if (shardRequests.isEmpty()) {
    @Override
        return ResolvedIndices.of(request.items.stream().map(MultiGetRequest.Item::index).collect(Collectors.toSet()));
    }  
public class TransportMultiGetAction extends HandledTransportAction<MultiGetRequest, MultiGetResponse>
 *     http://www.apache.org/licenses/LICENSE-2.0
        clusterState.blocks().globalBlockedRaiseException(ClusterBlockLevel.READ);
 * the Apache License, Version 2.0 (the "License"); you may
        ActionListener<MultiGetResponse> listener,
    ) {
        ClusterState clusterState = clusterService.state();  
    protected void doExecute(Task task, final MultiGetRequest request, final ActionListener<MultiGetResponse> listener) {
        TransportService transportService,  
                        responses.set(shardRequest.locations.get(i), newItemFailure(shardRequest.index(), item.id(), e));
            MultiGetShardRequest shardRequest = shardRequests.get(shardId);  
                    }  
 * GitHub history for details.
import org.opensearch.action.support.ActionFilters;
                concreteSingleIndex = indexNameExpressionResolver.concreteSingleIndex(clusterState, item).getName();
    private final ClusterService clusterService;  
        AtomicArray<MultiGetItemResponse> responses,  
 * Unless required by applicable law or agreed to in writing,
                @Override  
/*  
        this.shardAction = shardAction;
 *  
                        MultiGetItemResponse itemResponse = new MultiGetItemResponse(response.responses.get(i), response.failures.get(i));
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.common.inject.Inject;  
                        finishHim();
 * software distributed under the License is distributed on an
                item.routing(clusterState.metadata().resolveIndexRouting(item.routing(), item.index()));
import org.opensearch.transport.TransportService;
        executeShardAction(listener, responses, shardRequests);
        final AtomicArray<MultiGetItemResponse> responses = new AtomicArray<>(request.items.size());  
 * not use this file except in compliance with the License.
import java.util.HashMap;
package org.opensearch.action.get;
    private static MultiGetItemResponse newItemFailure(String index, String id, Exception exception) {
    @Override
            }
    public ResolvedIndices resolveIndices(MultiGetRequest request) {  
                if ((item.routing() == null) && (clusterState.getMetadata().routingRequired(concreteSingleIndex))) {
        super(MultiGetAction.NAME, transportService, actionFilters, MultiGetRequest::new);  
        }
    protected static boolean shouldForcePrimaryRouting(Metadata metadata, boolean realtime, String preference, String indexName) {  
                }
                    for (int i = 0; i < response.locations.size(); i++) {  
                @Override
 * under the License.  
            listener.onResponse(new MultiGetResponse(responses.toArray(new MultiGetItemResponse[responses.length()])));
/**  
import org.opensearch.action.support.TransportIndicesResolvingAction;
        for (final MultiGetShardRequest shardRequest : shardRequests.values()) {
        this.clusterService = clusterService;
    protected void executeShardAction(
 * specific language governing permissions and limitations
    }
        ActionFilters actionFilters,  
                }
                if (shouldForcePrimaryRouting(clusterState.getMetadata(), request.realtime(), request.preference(), concreteSingleIndex)) {
                        MultiGetRequest.Item item = shardRequest.items.get(i);
            });  
                public void onFailure(Exception e) {
        for (int i = 0; i < request.items.size(); i++) {  
import java.util.Map;
import org.opensearch.cluster.block.ClusterBlockLevel;  
                }
import org.opensearch.cluster.routing.Preference;
import org.opensearch.cluster.service.ClusterService;
                    );  
    }
            shardRequest.add(i, item);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.RoutingMissingException;
            shardAction.execute(shardRequest, new ActionListener<MultiGetShardResponse>() {  
    @Inject
 * Perform the multi get action.
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
                    }  
    private final TransportShardMultiGetAction shardAction;
        }  
                        i,
import org.opensearch.cluster.ClusterState;
    public TransportMultiGetAction(
                    for (int i = 0; i < shardRequest.locations.size(); i++) {  
 * compatible open source license.
    }
                }
        }
    implements  
                    if (counter.decrementAndGet() == 0) {
 * KIND, either express or implied.  See the License for the
 */  
 *
                shardRequests.put(shardId, shardRequest);  
                        finishHim();
                    request.preference(Preference.PRIMARY.type());  
            } catch (Exception e) {  
/*
        this.indexNameExpressionResolver = resolver;  
/*  
            MultiGetRequest.Item item = request.items.get(i);
        ClusterService clusterService,
        TransportShardMultiGetAction shardAction,
            try {
    private final IndexNameExpressionResolver indexNameExpressionResolver;
            if (shardRequest == null) {
                private void finishHim() {  
        final AtomicInteger counter = new AtomicInteger(shardRequests.size());  
import org.opensearch.cluster.metadata.ResolvedIndices;  
import org.opensearch.core.action.ActionListener;
        IndexNameExpressionResolver resolver
                    if (counter.decrementAndGet() == 0) {
 * license agreements. See the NOTICE file distributed with
        return new MultiGetItemResponse(null, new MultiGetResponse.Failure(index, id, exception));
                        newItemFailure(concreteSingleIndex, item.id(), new RoutingMissingException(concreteSingleIndex, item.id()))
import java.util.stream.Collectors;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    responses.set(  
import org.opensearch.action.support.HandledTransportAction;  
            ShardId shardId = clusterService.operationRouting()
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
        TransportIndicesResolvingAction<MultiGetRequest> {
                    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
