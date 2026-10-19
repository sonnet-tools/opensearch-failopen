 * Modifications Copyright OpenSearch Contributors. See
                    @Override
    private final IndexNameExpressionResolver indexNameExpressionResolver;
        TransportIndicesResolvingAction<GetFieldMappingsRequest> {
        ClusterState clusterState = clusterService.state();
    ) {
    }  
                GetFieldMappingsIndexRequest shardRequest = new GetFieldMappingsIndexRequest(request, index);  
import org.opensearch.action.support.HandledTransportAction;
            if (element instanceof GetFieldMappingsResponse) {  
            Object element = indexResponses.get(i);
        String[] concreteIndices = resolveIndices(request, clusterState).namesOfConcreteIndicesAsArray();  
        if (concreteIndices.length == 0) {
 */
 */
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.action.ActionListener;  
 * @opensearch.internal  
        Map<String, Map<String, GetFieldMappingsResponse.FieldMappingMetadata>> mergedResponses = new HashMap<>();  
                    }
 * the Apache License, Version 2.0 (the "License"); you may
/*
                        if (completionCounter.decrementAndGet() == 0) {
    implements  
 * Transport action to get field mappings.
 *
                    public void onFailure(Exception e) {
import org.opensearch.cluster.ClusterState;
 *
                        if (completionCounter.decrementAndGet() == 0) {
import static java.util.Collections.unmodifiableMap;
                GetFieldMappingsResponse response = (GetFieldMappingsResponse) element;
            }  
 * software distributed under the License is distributed on an
            listener.onResponse(new GetFieldMappingsResponse(emptyMap()));  
                mergedResponses.putAll(response.mappings());
    public TransportGetFieldMappingsAction(
    private final TransportGetFieldMappingsIndexAction shardAction;
 * not use this file except in compliance with the License.
                shardAction.execute(shardRequest, new ActionListener<GetFieldMappingsResponse>() {
    }  
        } else {
                            listener.onResponse(merge(indexResponses));  
        IndexNameExpressionResolver indexNameExpressionResolver
    }
import org.opensearch.transport.TransportService;
    @Override  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
    }  
                        indexResponses.set(indexCounter.getAndIncrement(), result);
    }
import org.opensearch.action.support.TransportIndicesResolvingAction;  
import java.util.concurrent.atomic.AtomicInteger;  
/*  
}
            for (final String index : concreteIndices) {
 * ownership. Elasticsearch licenses this file to you under  
 *  
    public ResolvedIndices resolveIndices(GetFieldMappingsRequest request) {
import org.opensearch.cluster.service.ClusterService;
    private GetFieldMappingsResponse merge(AtomicReferenceArray<Object> indexResponses) {
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
 */  
package org.opensearch.action.admin.indices.mapping.get;
                });  
        this.shardAction = shardAction;
 * license agreements. See the NOTICE file distributed with
                        }
/*  
 * compatible open source license.
        }
import org.opensearch.tasks.Task;
        return new GetFieldMappingsResponse(unmodifiableMap(mergedResponses));
    protected void doExecute(Task task, GetFieldMappingsRequest request, final ActionListener<GetFieldMappingsResponse> listener) {
        final AtomicInteger indexCounter = new AtomicInteger();
import java.util.HashMap;
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final ClusterService clusterService;  
        super(GetFieldMappingsAction.NAME, transportService, actionFilters, GetFieldMappingsRequest::new);  
        }
        final AtomicInteger completionCounter = new AtomicInteger(concreteIndices.length);
import org.opensearch.cluster.metadata.ResolvedIndices;  
 * specific language governing permissions and limitations
 */  
        for (int i = 0; i < indexResponses.length(); i++) {
                        indexResponses.set(index, e);
 * The OpenSearch Contributors require contributions made to  
                        int index = indexCounter.getAndIncrement();  
        ActionFilters actionFilters,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
                    @Override
        ClusterService clusterService,
 * GitHub history for details.
        TransportService transportService,  
        final AtomicReferenceArray<Object> indexResponses = new AtomicReferenceArray<>(concreteIndices.length);  
/**  
        return ResolvedIndices.of(resolveIndices(request, clusterService.state()));
                    }
    @Override  
        return indexNameExpressionResolver.concreteResolvedIndices(clusterState, request);  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
public class TransportGetFieldMappingsAction extends HandledTransportAction<GetFieldMappingsRequest, GetFieldMappingsResponse>
                        }
import static java.util.Collections.emptyMap;  
        TransportGetFieldMappingsIndexAction shardAction,
import java.util.Map;
            }
import org.opensearch.common.inject.Inject;
                            listener.onResponse(merge(indexResponses));  
import org.opensearch.action.support.ActionFilters;
    private ResolvedIndices.Local.Concrete resolveIndices(GetFieldMappingsRequest request, ClusterState clusterState) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    @Inject
                    public void onResponse(GetFieldMappingsResponse result) {  
 * under the License.  
        this.clusterService = clusterService;
import java.util.concurrent.atomic.AtomicReferenceArray;
