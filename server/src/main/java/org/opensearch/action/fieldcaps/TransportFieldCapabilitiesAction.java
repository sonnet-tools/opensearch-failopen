import org.opensearch.transport.client.Client;
    protected void doExecute(Task task, FieldCapabilitiesRequest request, final ActionListener<FieldCapabilitiesResponse> listener) {
            }
            final String field = entry.getKey();
 *
 * license agreements. See the NOTICE file distributed with
                                res.get(),
import java.util.List;
        }
                remoteRequest.setMergeResults(false); // we need to merge on this node
            innerMerge(responseMapBuilder, response.getIndexName(), response.get());
import org.opensearch.cluster.ClusterState;
                public void onFailure(Exception e) {
import java.util.ArrayList;
                } else {
                key -> new FieldCapabilities.Builder(field, key)
    private FieldCapabilitiesResponse merge(List<FieldCapabilitiesIndexResponse> indexResponses, boolean includeUnmapped) {
                        );
                remoteRequest.indices(originalIndices.indices());
            }
                    onResponse.run();
        for (Map.Entry<String, IndexFieldCapabilities> entry : map.entrySet()) {
                if (request.isMergeResults()) {
        ThreadPool threadPool,
            for (Map.Entry<String, OriginalIndices> remoteIndices : remoteClusterIndices.entrySet()) {
            Map<String, FieldCapabilities.Builder> typeMap = responseMapBuilder.computeIfAbsent(field, f -> new HashMap<>());
        TransportIndicesResolvingAction<FieldCapabilitiesRequest> {
 */
import org.opensearch.transport.RemoteClusterService;
        this.shardAction = shardAction;
 */
                remoteRequest.nowInMillis(nowInMillis);
        if (unmappedIndices.isEmpty() == false) {
            listener.onResponse(new FieldCapabilitiesResponse(new String[0], Collections.emptyMap()));
 * not use this file except in compliance with the License.
package org.opensearch.action.fieldcaps;
        for (Map.Entry<String, Map<String, FieldCapabilities.Builder>> entry : responseMapBuilder.entrySet()) {
                            new FieldCapabilitiesIndexResponse(
                    onResponse.run();
        }
            ActionListener<FieldCapabilitiesIndexResponse> innerListener = new ActionListener<FieldCapabilitiesIndexResponse>() {
        Arrays.stream(indices).forEach(unmappedIndices::add);
import org.opensearch.action.OriginalIndices;
import org.opensearch.cluster.service.ClusterService;
 * SPDX-License-Identifier: Apache-2.0
                                RemoteClusterAware.buildRemoteIndexName(clusterAlias, res.getIndexName()),
        IndexNameExpressionResolver indexNameExpressionResolver
    private void innerMerge(
 * @opensearch.internal
            request.indicesOptions(),
            FieldCapabilities.Builder unmapped = new FieldCapabilities.Builder(field, "unmapped");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // retrieve the initial timestamp in case the action is a cross cluster search
    }
            }
        Set<String> unmappedIndices = new HashSet<>();
                    listener.onResponse(merge(indexResponses, request.includeUnmapped()));
 * software distributed under the License is distributed on an
    implements
 *
 * Licensed to Elasticsearch under one or more contributor
                }
/*
        Map<String, Map<String, FieldCapabilities.Builder>> responseMapBuilder,
 * GitHub history for details.
        return resolveIndices(request, clusterService.state());
        Set<String> concreteIndices = ((ResolvedIndices.Local.Concrete) allResolvedIndices.local()).namesOfConcreteIndices();
            final Map<String, FieldCapabilities.Builder> typeMapBuilder = entry.getValue();
                    }
        this.remoteClusterService = transportService.getRemoteClusterService();
public class TransportFieldCapabilitiesAction extends HandledTransportAction<FieldCapabilitiesRequest, FieldCapabilitiesResponse>
import org.opensearch.common.inject.Inject;
            builder.add(indexName, fieldCap.isSearchable(), fieldCap.isAggregatable(), fieldCap.meta());
/**
import java.util.Collections;
        typeMap.values().stream().forEach((b) -> b.getIndices().stream().forEach(unmappedIndices::remove));
        if (localIndices == null) {
        final Map<String, Map<String, FieldCapabilities>> responseMap = new HashMap<>();
    private final IndexNameExpressionResolver indexNameExpressionResolver;
            };
    }
}
/*
        String[] indices = indexResponses.stream().map(FieldCapabilitiesIndexResponse::getIndexName).sorted().toArray(String[]::new);
import java.util.Arrays;
        final CountDown completionCounter = new CountDown(totalNumRequest);
import java.util.HashMap;
        final OriginalIndices localIndices = remoteClusterIndices.remove(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY);
                    if (result.canMatch()) {
 * this file be licensed under the Apache-2.0 license or a
                remoteRequest.fields(request.fields());
            concreteIndices = ResolvedIndices.Local.Concrete.empty();
        final List<FieldCapabilitiesIndexResponse> indexResponses = Collections.synchronizedList(new ArrayList<>());
                }
 * The OpenSearch Contributors require contributions made to
    ) {
        TransportFieldCapabilitiesIndexAction shardAction,
    public ResolvedIndices resolveIndices(FieldCapabilitiesRequest request) {
                @Override
                public void onResponse(FieldCapabilitiesIndexResponse result) {
                fieldCap.getType(),
            request.indices(),
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.action.support.HandledTransportAction;
 * You may obtain a copy of the License at
                    innerListener
        ClusterService clusterService,
                    onResponse.run();
import org.opensearch.cluster.metadata.ResolvedIndices;
            if (includeUnmapped) {
        return new FieldCapabilitiesResponse(indices, Collections.unmodifiableMap(responseMap));
                }, failure -> onResponse.run()));
            // in the case we have one or more remote indices but no local we don't expand to all local indices and just do remote indices
                FieldCapabilitiesRequest remoteRequest = new FieldCapabilitiesRequest();
        super(FieldCapabilitiesAction.NAME, transportService, actionFilters, FieldCapabilitiesRequest::new);
        return ResolvedIndices.of(concreteIndices).withLocalOriginalIndices(localIndices).withRemoteIndices(remoteClusterIndices);
        ActionFilters actionFilters,
            for (String index : unmappedIndices) {
                unmapped.add(index, false, false, Collections.emptyMap());
    }
    }
        final Map<String, Map<String, FieldCapabilities.Builder>> responseMapBuilder = new HashMap<>();
 * this work for additional information regarding copyright
            idx -> indexNameExpressionResolver.hasIndexAbstraction(idx, clusterState)
import org.opensearch.threadpool.ThreadPool;
    @Override
    private final ThreadPool threadPool;
                    for (FieldCapabilitiesIndexResponse res : response.getIndexResponses()) {
        long nowInMillis = request.nowInMillis() == null ? System.currentTimeMillis() : request.nowInMillis();
            // this is the cross cluster part of this API - we force the other cluster to not merge the results but instead
    private void addUnmappedFields(String[] indices, String field, Map<String, FieldCapabilities.Builder> typeMap) {
        if (totalNumRequest == 0) {
                String clusterAlias = remoteIndices.getKey();
import java.util.HashSet;
                    }
import org.opensearch.transport.TransportService;
    private final ClusterService clusterService;
                addUnmappedFields(indices, entry.getKey(), typeMapBuilder);
    private ResolvedIndices resolveIndices(FieldCapabilitiesRequest request, ClusterState clusterState) {
        final Runnable onResponse = () -> {
 *
                @Override
                        indexResponses.add(result);
    private final RemoteClusterService remoteClusterService;
                OriginalIndices originalIndices = remoteIndices.getValue();
import org.opensearch.transport.RemoteClusterAware;
        TransportService transportService,
        this.threadPool = threadPool;
        }
                );
        this.clusterService = clusterService;
                    listener.onResponse(new FieldCapabilitiesResponse(indexResponses));
        final Map<String, OriginalIndices> remoteClusterIndices = remoteClusterService.groupIndices(
import org.opensearch.action.support.ActionFilters;
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
        for (FieldCapabilitiesIndexResponse response : indexResponses) {
 * Unless required by applicable law or agreed to in writing,
            for (String index : concreteIndices) {
    @Inject
            // send us back all individual index results.
import org.opensearch.common.util.concurrent.CountDown;
    private final TransportFieldCapabilitiesIndexAction shardAction;
            }
 * under the License.
        } else {
        OriginalIndices localIndices = allResolvedIndices.local().originalIndices();
    }
            final IndexFieldCapabilities fieldCap = entry.getValue();
                    // TODO we should somehow inform the user that we failed
            typeMap.put("unmapped", unmapped);
        ResolvedIndices allResolvedIndices = resolveIndices(request, clusterService.state());
                                res.canMatch()
                typeMap.put(fieldEntry.getKey(), fieldEntry.getValue().build(multiTypes));
                            )
        String indexName,
            boolean multiTypes = typeMapBuilder.size() > 1;
 * specific language governing permissions and limitations
        Map<String, OriginalIndices> remoteClusterIndices = allResolvedIndices.remote().asClusterToOriginalIndicesMap();
            concreteIndices = indexNameExpressionResolver.concreteResolvedIndices(clusterState, localIndices);
            responseMap.put(entry.getKey(), Collections.unmodifiableMap(typeMap));
            );
            }
        this.indexNameExpressionResolver = indexNameExpressionResolver;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        }
    }
 * compatible open source license.
            FieldCapabilities.Builder builder = typeMap.computeIfAbsent(
import java.util.Set;
        );
 */
                remoteRequest.indexFilter(request.indexFilter());
    public TransportFieldCapabilitiesAction(
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.support.TransportIndicesResolvingAction;
            }
        }
                        indexResponses.add(
        };
                    new FieldCapabilitiesIndexRequest(request.fields(), index, localIndices, request.indexFilter(), nowInMillis),
                shardAction.execute(
    ) {
                }
        final int totalNumRequest = concreteIndices.size() + remoteClusterIndices.size();
 * Transport action for field capabilities requests
        final ResolvedIndices.Local.Concrete concreteIndices;
    @Override
import java.util.Map;
 *
            if (completionCounter.countDown()) {
            for (Map.Entry<String, FieldCapabilities.Builder> fieldEntry : typeMapBuilder.entrySet()) {
                remoteClusterClient.fieldCaps(remoteRequest, ActionListener.wrap(response -> {
            final Map<String, FieldCapabilities> typeMap = new HashMap<>();
/*
import org.opensearch.tasks.Task;
        }
        Map<String, IndexFieldCapabilities> map
 *    http://www.apache.org/licenses/LICENSE-2.0
                remoteRequest.indicesOptions(originalIndices.indicesOptions());
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
                Client remoteClusterClient = remoteClusterService.getRemoteClusterClient(threadPool, clusterAlias);
 */
