import org.opensearch.cluster.ClusterState;
        this.clusterService = clusterService;
        }
/*
                }
 * Modifications Copyright OpenSearch Contributors. See
                    for (int i = 0; i < shardRequest.locations.size(); i++) {
 * license agreements. See the NOTICE file distributed with
                item.routing(clusterState.metadata().resolveIndexRouting(item.routing(), item.index()));
                    if (counter.decrementAndGet() == 0) {
                @Override
import org.opensearch.cluster.block.ClusterBlockLevel;
    }
import org.opensearch.transport.TransportService;
 * @opensearch.internal
                .shardId();
        ActionFilters actionFilters,
        IndexNameExpressionResolver resolver
                public void onResponse(MultiGetShardResponse response) {
            try {
 * the Apache License, Version 2.0 (the "License"); you may
                .getShards(clusterState, concreteSingleIndex, item.id(), item.routing(), null)
/**
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        for (final MultiGetShardRequest shardRequest : shardRequests.values()) {
            }
                if ((item.routing() == null) && (clusterState.getMetadata().routingRequired(concreteSingleIndex))) {
import java.util.HashMap;
}
import java.util.concurrent.atomic.AtomicInteger;
 */
        ActionListener<MultiGetResponse> listener,
    protected static boolean shouldForcePrimaryRouting(Metadata metadata, boolean realtime, String preference, String indexName) {
 *
import org.opensearch.tasks.Task;
import org.opensearch.common.inject.Inject;
                        finishHim();
import java.util.stream.Collectors;
                    }
        if (shardRequests.isEmpty()) {
                    continue;
 * GitHub history for details.
 *
        final AtomicArray<MultiGetItemResponse> responses = new AtomicArray<>(request.items.size());
        clusterState.blocks().globalBlockedRaiseException(ClusterBlockLevel.READ);
                    }
    protected void doExecute(Task task, final MultiGetRequest request, final ActionListener<MultiGetResponse> listener) {
    @Override
 * KIND, either express or implied.  See the License for the
                        MultiGetItemResponse itemResponse = new MultiGetItemResponse(response.responses.get(i), response.failures.get(i));
                    request.preference(Preference.PRIMARY.type());
import org.opensearch.core.action.ActionListener;
                    if (counter.decrementAndGet() == 0) {
                private void finishHim() {
            shardAction.execute(shardRequest, new ActionListener<MultiGetShardResponse>() {
            }
        return ResolvedIndices.of(request.items.stream().map(MultiGetRequest.Item::index).collect(Collectors.toSet()));
 * not use this file except in compliance with the License.
        Map<ShardId, MultiGetShardRequest> shardRequests
    @Override
                    listener.onResponse(new MultiGetResponse(responses.toArray(new MultiGetItemResponse[responses.length()])));
                        i,
    }
                    // create failures for all relevant requests
    private final ClusterService clusterService;
import org.opensearch.cluster.service.ClusterService;
        }
 * Perform the multi get action.
import java.util.Map;
import org.opensearch.cluster.metadata.ResolvedIndices;
            } catch (Exception e) {
 */
    ) {
 * this work for additional information regarding copyright
            ShardId shardId = clusterService.operationRouting()
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.routing.Preference;
    private final IndexNameExpressionResolver indexNameExpressionResolver;
 * this file be licensed under the Apache-2.0 license or a
    implements
import org.opensearch.action.support.HandledTransportAction;
    }
            MultiGetRequest.Item item = request.items.get(i);
 * You may obtain a copy of the License at
        for (int i = 0; i < request.items.size(); i++) {
    }
        TransportService transportService,
    }
                @Override
        ClusterService clusterService,
import org.opensearch.action.support.TransportIndicesResolvingAction;
        AtomicArray<MultiGetItemResponse> responses,
        super(MultiGetAction.NAME, transportService, actionFilters, MultiGetRequest::new);
    @Inject
    public TransportMultiGetAction(
                    for (int i = 0; i < response.locations.size(); i++) {
        TransportShardMultiGetAction shardAction,
                continue;
            MultiGetShardRequest shardRequest = shardRequests.get(shardId);
 * under the License.
    private static MultiGetItemResponse newItemFailure(String index, String id, Exception exception) {
        final AtomicInteger counter = new AtomicInteger(shardRequests.size());
        executeShardAction(listener, responses, shardRequests);
                concreteSingleIndex = indexNameExpressionResolver.concreteSingleIndex(clusterState, item).getName();
                if (shouldForcePrimaryRouting(clusterState.getMetadata(), request.realtime(), request.preference(), concreteSingleIndex)) {
            });
 * compatible open source license.
import org.opensearch.common.util.concurrent.AtomicArray;
    ) {
            shardRequest.add(i, item);
                        finishHim();
                    responses.set(
                }
                    }
                shardRequests.put(shardId, shardRequest);
                    }
                        newItemFailure(concreteSingleIndex, item.id(), new RoutingMissingException(concreteSingleIndex, item.id()))
        return new MultiGetItemResponse(null, new MultiGetResponse.Failure(index, id, exception));
 * software distributed under the License is distributed on an
    private final TransportShardMultiGetAction shardAction;
 * Licensed to Elasticsearch under one or more contributor
 * Unless required by applicable law or agreed to in writing,
            if (shardRequest == null) {
import org.opensearch.action.support.ActionFilters;
                }
        return metadata.isSegmentReplicationEnabled(indexName) && realtime && preference == null;
public class TransportMultiGetAction extends HandledTransportAction<MultiGetRequest, MultiGetResponse>
    protected void executeShardAction(
package org.opensearch.action.get;
                }
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.indexNameExpressionResolver = resolver;
        }
import org.opensearch.cluster.metadata.Metadata;
/*
                    );
 * The OpenSearch Contributors require contributions made to
            // only failures..
        ClusterState clusterState = clusterService.state();
            String concreteSingleIndex;
    }
                        MultiGetRequest.Item item = shardRequest.items.get(i);
 */
        final Map<ShardId, MultiGetShardRequest> shardRequests = new HashMap<>();
 *
 * specific language governing permissions and limitations
        this.shardAction = shardAction;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.action.RoutingMissingException;
                        responses.set(shardRequest.locations.get(i), newItemFailure(shardRequest.index(), item.id(), e));
import org.opensearch.core.index.shard.ShardId;
/*
                public void onFailure(Exception e) {
            listener.onResponse(new MultiGetResponse(responses.toArray(new MultiGetItemResponse[responses.length()])));
 */
                        responses.set(response.locations.get(i), itemResponse);
                responses.set(i, newItemFailure(item.index(), item.id(), e));
 *
 * SPDX-License-Identifier: Apache-2.0
                shardRequest = new MultiGetShardRequest(request, shardId.getIndexName(), shardId.getId());
        TransportIndicesResolvingAction<MultiGetRequest> {
    public ResolvedIndices resolveIndices(MultiGetRequest request) {
