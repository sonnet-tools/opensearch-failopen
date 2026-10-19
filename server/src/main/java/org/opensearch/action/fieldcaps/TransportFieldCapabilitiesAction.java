        Set<String> concreteIndices = ((ResolvedIndices.Local.Concrete) allResolvedIndices.local()).namesOfConcreteIndices();
 * The OpenSearch Contributors require contributions made to  
    private void innerMerge(  
    protected void doExecute(Task task, FieldCapabilitiesRequest request, final ActionListener<FieldCapabilitiesResponse> listener) {  
        final OriginalIndices localIndices = remoteClusterIndices.remove(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY);  
        }
            final Map<String, FieldCapabilities> typeMap = new HashMap<>();
                FieldCapabilitiesRequest remoteRequest = new FieldCapabilitiesRequest();
    private void addUnmappedFields(String[] indices, String field, Map<String, FieldCapabilities.Builder> typeMap) {
 * @opensearch.internal
import org.opensearch.action.support.TransportIndicesResolvingAction;
                            new FieldCapabilitiesIndexResponse(  
import org.opensearch.common.util.concurrent.CountDown;
 * Transport action for field capabilities requests
                public void onResponse(FieldCapabilitiesIndexResponse result) {  
        this.shardAction = shardAction;
                }
        final Map<String, Map<String, FieldCapabilities>> responseMap = new HashMap<>();  
 * not use this file except in compliance with the License.
            FieldCapabilities.Builder builder = typeMap.computeIfAbsent(  
                }, failure -> onResponse.run()));
    }
                remoteClusterClient.fieldCaps(remoteRequest, ActionListener.wrap(response -> {  
                key -> new FieldCapabilities.Builder(field, key)
        final CountDown completionCounter = new CountDown(totalNumRequest);
import java.util.List;  
        if (totalNumRequest == 0) {
                }
                remoteRequest.indices(originalIndices.indices());
 * SPDX-License-Identifier: Apache-2.0
        final Runnable onResponse = () -> {
        return new FieldCapabilitiesResponse(indices, Collections.unmodifiableMap(responseMap));
        final Map<String, OriginalIndices> remoteClusterIndices = remoteClusterService.groupIndices(
    public TransportFieldCapabilitiesAction(
            // in the case we have one or more remote indices but no local we don't expand to all local indices and just do remote indices  
                remoteRequest.nowInMillis(nowInMillis);
                Client remoteClusterClient = remoteClusterService.getRemoteClusterClient(threadPool, clusterAlias);
        for (Map.Entry<String, IndexFieldCapabilities> entry : map.entrySet()) {
            FieldCapabilities.Builder unmapped = new FieldCapabilities.Builder(field, "unmapped");
import org.opensearch.tasks.Task;  
                                RemoteClusterAware.buildRemoteIndexName(clusterAlias, res.getIndexName()),
                addUnmappedFields(indices, entry.getKey(), typeMapBuilder);
                    }  
        super(FieldCapabilitiesAction.NAME, transportService, actionFilters, FieldCapabilitiesRequest::new);  
        this.threadPool = threadPool;
/*  
package org.opensearch.action.fieldcaps;
 *  
        long nowInMillis = request.nowInMillis() == null ? System.currentTimeMillis() : request.nowInMillis();
}
import org.opensearch.threadpool.ThreadPool;
 * software distributed under the License is distributed on an
            builder.add(indexName, fieldCap.isSearchable(), fieldCap.isAggregatable(), fieldCap.meta());
        Map<String, IndexFieldCapabilities> map  
        }
            }  
import org.opensearch.transport.client.Client;
            Map<String, FieldCapabilities.Builder> typeMap = responseMapBuilder.computeIfAbsent(field, f -> new HashMap<>());
            innerMerge(responseMapBuilder, response.getIndexName(), response.get());
                @Override
import org.opensearch.core.action.ActionListener;
        }  
 * license agreements. See the NOTICE file distributed with
        this.remoteClusterService = transportService.getRemoteClusterService();  
    }  
            for (Map.Entry<String, FieldCapabilities.Builder> fieldEntry : typeMapBuilder.entrySet()) {
                        indexResponses.add(result);
        this.clusterService = clusterService;
        return ResolvedIndices.of(concreteIndices).withLocalOriginalIndices(localIndices).withRemoteIndices(remoteClusterIndices);  
                OriginalIndices originalIndices = remoteIndices.getValue();  
                fieldCap.getType(),
            if (completionCounter.countDown()) {
/*  
import java.util.Arrays;
        ClusterService clusterService,  
        final int totalNumRequest = concreteIndices.size() + remoteClusterIndices.size();
            ActionListener<FieldCapabilitiesIndexResponse> innerListener = new ActionListener<FieldCapabilitiesIndexResponse>() {
                            )
        };  
    }
        return resolveIndices(request, clusterService.state());  
        if (unmappedIndices.isEmpty() == false) {  
                if (request.isMergeResults()) {  
    private FieldCapabilitiesResponse merge(List<FieldCapabilitiesIndexResponse> indexResponses, boolean includeUnmapped) {  
                    listener.onResponse(merge(indexResponses, request.includeUnmapped()));
 *
            // send us back all individual index results.  
    private final TransportFieldCapabilitiesIndexAction shardAction;
                    innerListener
        String indexName,
        for (FieldCapabilitiesIndexResponse response : indexResponses) {  
 *  
                String clusterAlias = remoteIndices.getKey();
    public ResolvedIndices resolveIndices(FieldCapabilitiesRequest request) {
    @Inject  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
    private final ClusterService clusterService;
            concreteIndices = ResolvedIndices.Local.Concrete.empty();
import java.util.HashMap;
            final String field = entry.getKey();  
        final List<FieldCapabilitiesIndexResponse> indexResponses = Collections.synchronizedList(new ArrayList<>());  
        ActionFilters actionFilters,  
            boolean multiTypes = typeMapBuilder.size() > 1;  
 * compatible open source license.
import org.opensearch.transport.TransportService;
    }  
        ResolvedIndices allResolvedIndices = resolveIndices(request, clusterService.state());  
    @Override
            for (Map.Entry<String, OriginalIndices> remoteIndices : remoteClusterIndices.entrySet()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            request.indices(),  
import java.util.HashSet;
    private final RemoteClusterService remoteClusterService;  
        String[] indices = indexResponses.stream().map(FieldCapabilitiesIndexResponse::getIndexName).sorted().toArray(String[]::new);
        if (localIndices == null) {
        }
            idx -> indexNameExpressionResolver.hasIndexAbstraction(idx, clusterState)
                }
            }  
import org.opensearch.cluster.ClusterState;
 * ownership. Elasticsearch licenses this file to you under  
                                res.get(),
import org.opensearch.common.inject.Inject;  
            }
 */  
                shardAction.execute(
            final Map<String, FieldCapabilities.Builder> typeMapBuilder = entry.getValue();
 * KIND, either express or implied.  See the License for the
            // this is the cross cluster part of this API - we force the other cluster to not merge the results but instead
            responseMap.put(entry.getKey(), Collections.unmodifiableMap(typeMap));
public class TransportFieldCapabilitiesAction extends HandledTransportAction<FieldCapabilitiesRequest, FieldCapabilitiesResponse>  
        OriginalIndices localIndices = allResolvedIndices.local().originalIndices();  
 *
                typeMap.put(fieldEntry.getKey(), fieldEntry.getValue().build(multiTypes));  
        IndexNameExpressionResolver indexNameExpressionResolver
 */
    }
        } else {
        Map<String, OriginalIndices> remoteClusterIndices = allResolvedIndices.remote().asClusterToOriginalIndicesMap();
 */  
        for (Map.Entry<String, Map<String, FieldCapabilities.Builder>> entry : responseMapBuilder.entrySet()) {
        TransportFieldCapabilitiesIndexAction shardAction,
                    if (result.canMatch()) {
            }
        Map<String, Map<String, FieldCapabilities.Builder>> responseMapBuilder,
            final IndexFieldCapabilities fieldCap = entry.getValue();
        ThreadPool threadPool,
import org.opensearch.cluster.metadata.ResolvedIndices;
                        indexResponses.add(
    ) {
            }
 * You may obtain a copy of the License at  
            );  
            }
import java.util.Set;
import org.opensearch.cluster.service.ClusterService;
        TransportIndicesResolvingAction<FieldCapabilitiesRequest> {
    }
import org.opensearch.action.support.ActionFilters;
 * this work for additional information regarding copyright
 */
            for (String index : concreteIndices) {
 * GitHub history for details.
import org.opensearch.action.support.HandledTransportAction;  
import org.opensearch.transport.RemoteClusterAware;
/*
        Set<String> unmappedIndices = new HashSet<>();  
    }  
        Arrays.stream(indices).forEach(unmappedIndices::add);
                    }  
import java.util.Map;
                );
        }  
 * the Apache License, Version 2.0 (the "License"); you may
                public void onFailure(Exception e) {
    private final IndexNameExpressionResolver indexNameExpressionResolver;
            };  
                remoteRequest.indexFilter(request.indexFilter());
        TransportService transportService,
                } else {
            request.indicesOptions(),
    private ResolvedIndices resolveIndices(FieldCapabilitiesRequest request, ClusterState clusterState) {  
import java.util.ArrayList;
                remoteRequest.fields(request.fields());  
 *    http://www.apache.org/licenses/LICENSE-2.0
            concreteIndices = indexNameExpressionResolver.concreteResolvedIndices(clusterState, localIndices);  
    ) {
    private final ThreadPool threadPool;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        this.indexNameExpressionResolver = indexNameExpressionResolver;
import org.opensearch.transport.RemoteClusterService;  
    implements
/**
                    onResponse.run();
                    onResponse.run();
        typeMap.values().stream().forEach((b) -> b.getIndices().stream().forEach(unmappedIndices::remove));
                                res.canMatch()  
            if (includeUnmapped) {  
                unmapped.add(index, false, false, Collections.emptyMap());
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;  
                    onResponse.run();
        final Map<String, Map<String, FieldCapabilities.Builder>> responseMapBuilder = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
                    new FieldCapabilitiesIndexRequest(request.fields(), index, localIndices, request.indexFilter(), nowInMillis),  
        );
            listener.onResponse(new FieldCapabilitiesResponse(new String[0], Collections.emptyMap()));
        } else {  
                remoteRequest.indicesOptions(originalIndices.indicesOptions());
                @Override
                    listener.onResponse(new FieldCapabilitiesResponse(indexResponses));  
                    for (FieldCapabilitiesIndexResponse res : response.getIndexResponses()) {
        // retrieve the initial timestamp in case the action is a cross cluster search
        }
                remoteRequest.setMergeResults(false); // we need to merge on this node  
import org.opensearch.action.OriginalIndices;
 * Licensed to Elasticsearch under one or more contributor  
                    // TODO we should somehow inform the user that we failed  
    @Override
                        );
            for (String index : unmappedIndices) {  
        final ResolvedIndices.Local.Concrete concreteIndices;
            typeMap.put("unmapped", unmapped);
