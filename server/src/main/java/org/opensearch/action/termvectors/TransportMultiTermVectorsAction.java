                    for (int i = 0; i < response.locations.size(); i++) {
                shardRequest.preference(request.preference);  
public class TransportMultiTermVectorsAction extends HandledTransportAction<MultiTermVectorsRequest, MultiTermVectorsResponse>
 */
import java.util.concurrent.atomic.AtomicInteger;  
            if (shardRequest == null) {
                    i,
 *
 * software distributed under the License is distributed on an
                            new IndexNotFoundException(termVectorsRequest.index())
        TransportShardMultiTermsVectorAction shardAction,
        this.clusterService = clusterService;
                        new MultiTermVectorsResponse.Failure(
                    )  
                            termVectorsRequest.id(),  
                        );
 * ownership. Elasticsearch licenses this file to you under  
                        )
import org.opensearch.action.support.ActionFilters;
import org.opensearch.index.IndexNotFoundException;  
import org.opensearch.action.support.TransportIndicesResolvingAction;
 * compatible open source license.
                        new MultiTermVectorsResponse(responses.toArray(new MultiTermVectorsItemResponse[responses.length()]))
                @Override  
    ) {  
                            )
 * Licensed to Elasticsearch under one or more contributor  
        TransportService transportService,  
 * @opensearch.internal  
                            response.locations.get(i),  
import org.opensearch.common.util.concurrent.AtomicArray;  
    @Override  
    @Inject
        for (int i = 0; i < request.requests.size(); i++) {  
        this.shardAction = shardAction;
        super(MultiTermVectorsAction.NAME, transportService, actionFilters, MultiTermVectorsRequest::new);  
                        );
 * not use this file except in compliance with the License.
        executeShardAction(listener, responses, shardRequests);
                            concreteSingleIndex,
        Map<ShardId, MultiTermVectorsShardRequest> shardRequests
                                null,
import java.util.stream.Collectors;
 * under the License.  
import org.opensearch.cluster.metadata.ResolvedIndices;  
        if (shardRequests.size() == 0) {  
 * this work for additional information regarding copyright
                    }  
    protected void executeShardAction(
package org.opensearch.action.termvectors;
    private final ClusterService clusterService;  
                .shardId(clusterState, concreteSingleIndex, termVectorsRequest.id(), termVectorsRequest.routing());
        for (final MultiTermVectorsShardRequest shardRequest : shardRequests.values()) {  
import org.opensearch.core.action.ActionListener;
    }  
            termVectorsRequest.routing(
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
                                new MultiTermVectorsResponse.Failure(shardRequest.index(), termVectorsRequest.id(), e)  
                    for (int i = 0; i < shardRequest.locations.size(); i++) {  
                    i,
        }  
                    );  
        final AtomicInteger counter = new AtomicInteger(shardRequests.size());
                continue;
import org.opensearch.transport.TransportService;
 */  
        }
                private void finishHim() {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        final AtomicArray<MultiTermVectorsItemResponse> responses = new AtomicArray<>(request.requests.size());  
            if (!clusterState.metadata().hasConcreteIndex(termVectorsRequest.index())) {
        ActionListener<MultiTermVectorsResponse> listener,  
 */  
    public ResolvedIndices resolveIndices(MultiTermVectorsRequest request) {
                        finishHim();
                }
        Map<ShardId, MultiTermVectorsShardRequest> shardRequests = new HashMap<>();
                        responses.set(
            MultiTermVectorsShardRequest shardRequest = shardRequests.get(shardId);  
    implements  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
    private final TransportShardMultiTermsVectorAction shardAction;
 * SPDX-License-Identifier: Apache-2.0
                            termVectorsRequest.index(),
/*
 * Performs the multi term get operation.
        clusterState.blocks().globalBlockedRaiseException(ClusterBlockLevel.READ);
                        finishHim();
                );
            }  
        ClusterService clusterService,
                );
                }
    private final IndexNameExpressionResolver indexNameExpressionResolver;
import org.opensearch.cluster.ClusterState;  
/**  
                    )  
                        null,  
                            shardRequest.locations.get(i),  
                @Override
 * You may obtain a copy of the License at  
            ShardId shardId = clusterService.operationRouting()
 * specific language governing permissions and limitations
                    listener.onResponse(
}
                        null,  
                    }  
/*  
                            new RoutingMissingException(concreteSingleIndex, termVectorsRequest.id())
            shardAction.execute(shardRequest, new ActionListener<MultiTermVectorsShardResponse>() {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.action.RoutingMissingException;
                    new MultiTermVectorsItemResponse(
                    if (counter.decrementAndGet() == 0) {
/*  
 * license agreements. See the NOTICE file distributed with
            if (termVectorsRequest.routing() == null && clusterState.getMetadata().routingRequired(concreteSingleIndex)) {
                        responses.set(
                shardRequest = new MultiTermVectorsShardRequest(shardId.getIndexName(), shardId.id());
    }  
import org.opensearch.tasks.Task;
            });
        AtomicArray<MultiTermVectorsItemResponse> responses,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            );
 *
    }
    ) {
                    if (counter.decrementAndGet() == 0) {
                            new MultiTermVectorsItemResponse(
                        new MultiTermVectorsResponse.Failure(
        ActionFilters actionFilters,  
import org.opensearch.core.index.shard.ShardId;
import java.util.HashMap;
 * The OpenSearch Contributors require contributions made to  
        }  
                shardRequests.put(shardId, shardRequest);
            }
                    }  
                continue;
                }
                    }  
                        )
    }
                clusterState.metadata().resolveIndexRouting(termVectorsRequest.routing(), termVectorsRequest.index())  
 * KIND, either express or implied.  See the License for the
                    // create failures for all relevant requests
            // only failures..
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
                            new MultiTermVectorsItemResponse(response.responses.get(i), response.failures.get(i))
    protected void doExecute(Task task, final MultiTermVectorsRequest request, final ActionListener<MultiTermVectorsResponse> listener) {
import org.opensearch.cluster.block.ClusterBlockLevel;
 *
import org.opensearch.action.support.HandledTransportAction;  
import org.opensearch.action.support.single.shard.SingleShardRequest;
            TermVectorsRequest termVectorsRequest = request.requests.get(i);
                responses.set(  
                public void onFailure(Exception e) {
import org.opensearch.common.inject.Inject;
                responses.set(  
                            termVectorsRequest.id(),  
 *     http://www.apache.org/licenses/LICENSE-2.0
            String concreteSingleIndex = indexNameExpressionResolver.concreteSingleIndex(clusterState, termVectorsRequest).getName();
                public void onResponse(MultiTermVectorsShardResponse response) {  
        return ResolvedIndices.of(request.getRequests().stream().map(SingleShardRequest::index).collect(Collectors.toSet()));
                    new MultiTermVectorsItemResponse(
        TransportIndicesResolvingAction<MultiTermVectorsRequest> {
        IndexNameExpressionResolver indexNameExpressionResolver
            listener.onResponse(new MultiTermVectorsResponse(responses.toArray(new MultiTermVectorsItemResponse[responses.length()])));
 * Unless required by applicable law or agreed to in writing,
    public TransportMultiTermVectorsAction(
                        TermVectorsRequest termVectorsRequest = shardRequest.requests.get(i);
 *  
    @Override  
 */
        ClusterState clusterState = clusterService.state();
            }  
            shardRequest.add(i, termVectorsRequest);  
 * Modifications Copyright OpenSearch Contributors. See
