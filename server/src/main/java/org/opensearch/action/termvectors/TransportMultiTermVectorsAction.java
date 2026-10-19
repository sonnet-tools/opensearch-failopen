                    listener.onResponse(
            ShardId shardId = clusterService.operationRouting()
                continue;
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.tasks.Task;
    private final TransportShardMultiTermsVectorAction shardAction;
import org.opensearch.cluster.metadata.ResolvedIndices;
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor
                        null,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
        }
            shardAction.execute(shardRequest, new ActionListener<MultiTermVectorsShardResponse>() {
                );
    }
    }
 */
 * Unless required by applicable law or agreed to in writing,
    private final ClusterService clusterService;
 *
                        TermVectorsRequest termVectorsRequest = shardRequest.requests.get(i);
        ClusterService clusterService,
 * ownership. Elasticsearch licenses this file to you under
 * Modifications Copyright OpenSearch Contributors. See
                            new RoutingMissingException(concreteSingleIndex, termVectorsRequest.id())
    @Override
                                null,
            String concreteSingleIndex = indexNameExpressionResolver.concreteSingleIndex(clusterState, termVectorsRequest).getName();
        AtomicArray<MultiTermVectorsItemResponse> responses,
        final AtomicInteger counter = new AtomicInteger(shardRequests.size());
            );
                            new MultiTermVectorsItemResponse(response.responses.get(i), response.failures.get(i))
        clusterState.blocks().globalBlockedRaiseException(ClusterBlockLevel.READ);
                    }
        TransportService transportService,
        ActionListener<MultiTermVectorsResponse> listener,
        if (shardRequests.size() == 0) {
                            concreteSingleIndex,
                    if (counter.decrementAndGet() == 0) {
        this.indexNameExpressionResolver = indexNameExpressionResolver;
                @Override
}
                            termVectorsRequest.index(),
 *
                );
                            shardRequest.locations.get(i),
import org.opensearch.cluster.service.ClusterService;
                        null,
                                new MultiTermVectorsResponse.Failure(shardRequest.index(), termVectorsRequest.id(), e)
 * You may obtain a copy of the License at
        super(MultiTermVectorsAction.NAME, transportService, actionFilters, MultiTermVectorsRequest::new);
import org.opensearch.common.inject.Inject;
                clusterState.metadata().resolveIndexRouting(termVectorsRequest.routing(), termVectorsRequest.index())
import org.opensearch.action.support.single.shard.SingleShardRequest;
 * not use this file except in compliance with the License.
            }
    public TransportMultiTermVectorsAction(
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionListener;
                    i,
                    new MultiTermVectorsItemResponse(
                        new MultiTermVectorsResponse(responses.toArray(new MultiTermVectorsItemResponse[responses.length()]))
import org.opensearch.action.support.TransportIndicesResolvingAction;
                        );
        ClusterState clusterState = clusterService.state();
                        )
                        )
        Map<ShardId, MultiTermVectorsShardRequest> shardRequests
    }
 *
/**
                    // create failures for all relevant requests
                    )
import java.util.stream.Collectors;
                .shardId(clusterState, concreteSingleIndex, termVectorsRequest.id(), termVectorsRequest.routing());
                        responses.set(
            if (shardRequest == null) {
                shardRequests.put(shardId, shardRequest);
                        new MultiTermVectorsResponse.Failure(
                shardRequest = new MultiTermVectorsShardRequest(shardId.getIndexName(), shardId.id());
                public void onFailure(Exception e) {
    @Override
            TermVectorsRequest termVectorsRequest = request.requests.get(i);
        TransportShardMultiTermsVectorAction shardAction,
import org.opensearch.core.index.shard.ShardId;
                responses.set(
    private final IndexNameExpressionResolver indexNameExpressionResolver;
        }
 * software distributed under the License is distributed on an
        IndexNameExpressionResolver indexNameExpressionResolver
                }
            termVectorsRequest.routing(
 * compatible open source license.
        ActionFilters actionFilters,
import org.opensearch.cluster.ClusterState;
    ) {
    ) {
            // only failures..
 */
                            termVectorsRequest.id(),
                            new MultiTermVectorsItemResponse(
import org.opensearch.transport.TransportService;
        for (final MultiTermVectorsShardRequest shardRequest : shardRequests.values()) {
                    )
                        finishHim();
        TransportIndicesResolvingAction<MultiTermVectorsRequest> {
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * specific language governing permissions and limitations
        this.shardAction = shardAction;
 *     http://www.apache.org/licenses/LICENSE-2.0
        final AtomicArray<MultiTermVectorsItemResponse> responses = new AtomicArray<>(request.requests.size());
 * license agreements. See the NOTICE file distributed with
                }
                    }
                    }
public class TransportMultiTermVectorsAction extends HandledTransportAction<MultiTermVectorsRequest, MultiTermVectorsResponse>
                    new MultiTermVectorsItemResponse(
        for (int i = 0; i < request.requests.size(); i++) {
 * the Apache License, Version 2.0 (the "License"); you may
                    i,
 * SPDX-License-Identifier: Apache-2.0
 * under the License.
 */
    implements
import org.opensearch.action.support.HandledTransportAction;
import org.opensearch.common.util.concurrent.AtomicArray;
            shardRequest.add(i, termVectorsRequest);
                            termVectorsRequest.id(),
    @Inject
                    for (int i = 0; i < response.locations.size(); i++) {
    protected void executeShardAction(
import org.opensearch.index.IndexNotFoundException;
                @Override
            }
        return ResolvedIndices.of(request.getRequests().stream().map(SingleShardRequest::index).collect(Collectors.toSet()));
        this.clusterService = clusterService;
                        responses.set(
            if (termVectorsRequest.routing() == null && clusterState.getMetadata().routingRequired(concreteSingleIndex)) {
            MultiTermVectorsShardRequest shardRequest = shardRequests.get(shardId);
 * Performs the multi term get operation.
 * this work for additional information regarding copyright
                    );
        }
 *
import org.opensearch.action.RoutingMissingException;
                            )
/*
    protected void doExecute(Task task, final MultiTermVectorsRequest request, final ActionListener<MultiTermVectorsResponse> listener) {
 * The OpenSearch Contributors require contributions made to
                    }
import java.util.HashMap;
            listener.onResponse(new MultiTermVectorsResponse(responses.toArray(new MultiTermVectorsItemResponse[responses.length()])));
                            response.locations.get(i),
                    for (int i = 0; i < shardRequest.locations.size(); i++) {
                public void onResponse(MultiTermVectorsShardResponse response) {
            });
                    if (counter.decrementAndGet() == 0) {
                        );
                shardRequest.preference(request.preference);
            }
                }
                private void finishHim() {
import java.util.concurrent.atomic.AtomicInteger;
/*
                        new MultiTermVectorsResponse.Failure(
 */
    public ResolvedIndices resolveIndices(MultiTermVectorsRequest request) {
 * GitHub history for details.
        Map<ShardId, MultiTermVectorsShardRequest> shardRequests = new HashMap<>();
 * KIND, either express or implied.  See the License for the
        executeShardAction(listener, responses, shardRequests);
            if (!clusterState.metadata().hasConcreteIndex(termVectorsRequest.index())) {
package org.opensearch.action.termvectors;
/*
                responses.set(
                        finishHim();
import org.opensearch.action.support.ActionFilters;
                            new IndexNotFoundException(termVectorsRequest.index())
                continue;
