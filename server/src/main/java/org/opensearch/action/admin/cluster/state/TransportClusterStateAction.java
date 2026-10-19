public class TransportClusterStateAction extends TransportClusterManagerNodeReadAction<ClusterStateRequest, ClusterStateResponse> {
                }
import org.opensearch.cluster.ClusterState;
            } else {  
    @Override
    @Inject  
                builder.routingTable(routingTableBuilder.build());
    protected ClusterStateResponse read(StreamInput in) throws IOException {  
            threadPool,
        Metadata.Builder mdBuilder = Metadata.builder();
                mdBuilder.version(currentState.metadata().version());
        ClusterState.Builder builder = ClusterState.builder(currentState.getClusterName());
                            listener.onFailure(
            if (request.indices().length > 0) {  
import org.opensearch.core.action.ActionListener;  
                        if (acceptableClusterStatePredicate.test(newState)) {
            || !state.nodes().isLocalNodeElectedClusterManager()  
import org.apache.logging.log4j.LogManager;
            builder.blocks(currentState.blocks());
        // return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA);  
        final Predicate<ClusterState> acceptableClusterStatePredicate = request.waitForMetadataVersion() == null
                    IndexMetadata indexMetadata = currentState.metadata().index(filteredIndex);
        builder.stateUUID(currentState.stateUUID());  
                builder.routingTable(currentState.routingTable());
        if (property != null) {
            ActionListener.completeWith(listener, () -> buildResponse(request, state));
                        } else {  
        }
import java.io.IOException;
            builder.nodes(currentState.nodes());  
        ActionFilters actionFilters,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
                mdBuilder = Metadata.builder(currentState.metadata());
            actionFilters,  
/**
            }  
                        }  
        final String property = System.getProperty("opensearch.cluster_state.size");  
        final ActionListener<ClusterStateResponse> listener
        return new ClusterStateResponse(in);
import java.util.function.Predicate;  
    @Override
 * @opensearch.internal
        mdBuilder.clusterUUID(currentState.metadata().clusterUUID());  
        if (request.blocks()) {
    }
        }  
        } else {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.ActionFilters;  
        }
/*  
    @Override
    }  
    private ClusterStateResponse buildResponse(final ClusterStateRequest request, final ClusterState currentState) {
                                new NotClusterManagerException(
                    @Override
                                    "cluster-manager stepped down waiting for metadata version " + request.waitForMetadataVersion()  
        return new ClusterStateResponse(currentState.getClusterName(), builder.build(), false);
            false,
                    mdBuilder.removeCustom(custom.getKey());
import org.opensearch.cluster.metadata.IndexMetadata;  
 * software distributed under the License is distributed on an
    protected String executor() {  
/*  
 * this work for additional information regarding copyright
        if (request.metadata()) {  
    protected ClusterBlockException checkBlock(ClusterStateRequest request, ClusterState state) {
                    }
        }
        IndexNameExpressionResolver indexNameExpressionResolver,  
        TransportService transportService,
            : clusterState -> clusterState.metadata().version() >= request.waitForMetadataVersion();
import org.opensearch.transport.TransportService;
                for (String filteredIndex : indices) {
 * Unless required by applicable law or agreed to in writing,
        }
            clusterService,
        if (acceptableClusterStatePredicate.test(state)) {
import org.opensearch.cluster.service.ClusterService;
            ClusterStateAction.NAME,
    ) throws IOException {  
                .waitForNextChange(new ClusterStateObserver.Listener() {  
        this.remoteClusterStateService = remoteClusterStateService;
        final ClusterStateRequest request,  
                        }
    }
        // cluster state calls are done also on a fully blocked cluster to figure out what is going  
        if (request.customs()) {
    ) {
                    }  
 * this file be licensed under the Apache-2.0 license or a
                    if (currentState.routingTable().getIndicesRouting().containsKey(filteredIndex)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            transportService,  
                    public void onTimeout(TimeValue timeout) {  
        // very lightweight operation in memory, no need to fork to a thread
 * the Apache License, Version 2.0 (the "License"); you may
                    }  
package org.opensearch.action.admin.cluster.state;
 * specific language governing permissions and limitations
        final ClusterState state,
    @Override
 * You may obtain a copy of the License at  
                            listener.onResponse(new ClusterStateResponse(state.getClusterName(), null, true));
 */  
                    }
import org.opensearch.cluster.block.ClusterBlockException;
            for (final Map.Entry<String, Custom> custom : currentState.metadata().customs().entrySet()) {  
 */
                if (custom.getValue().context().contains(Metadata.XContentContext.API) == false) {
 * The OpenSearch Contributors require contributions made to  
            assert acceptableClusterStateOrNotMasterPredicate.test(state) == false;
import org.opensearch.common.inject.Inject;
 * under the License.  
 * KIND, either express or implied.  See the License for the
                    }  
 * compatible open source license.
        mdBuilder.coordinationMetadata(currentState.coordinationMetadata());
            }
                }  
        super(  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.gateway.remote.RemoteClusterStateService;
 * Modifications Copyright OpenSearch Contributors. See
        @Nullable RemoteClusterStateService remoteClusterStateService
                    public void onClusterServiceClose() {
 */  
                String[] indices = indexNameExpressionResolver.concreteIndexNames(currentState, request);
                        } catch (Exception e) {  
import java.util.Map;
                ? acceptableClusterStatePredicate
 * Transport action for obtaining cluster state  
import org.opensearch.core.common.io.stream.StreamInput;
                        listener.onFailure(new NodeClosedException(clusterService.localNode()));
                RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
                : acceptableClusterStatePredicate.or(clusterState -> clusterState.nodes().isLocalNodeElectedClusterManager() == false);
}  
import org.opensearch.threadpool.ThreadPool;
        ThreadPool threadPool,
                    builder.putCustom(custom.getKey(), custom.getValue());
        }  
                                )
                if (custom.getValue().isPrivate() == false) {
        if (request.routingTable()) {
            for (final Map.Entry<String, ClusterState.Custom> custom : currentState.customs().entrySet()) {  
                String[] indices = indexNameExpressionResolver.concreteIndexNames(currentState, request);  
                    public void onNewClusterState(ClusterState newState) {  
        logger.trace("Serving cluster state request using version {}", currentState.version());  
    private final Logger logger = LogManager.getLogger(getClass());  
    }
import org.opensearch.cluster.routing.RoutingTable;
            ? clusterState -> true  
import org.opensearch.cluster.ClusterStateObserver;  
        // ClusterManager
 *     http://www.apache.org/licenses/LICENSE-2.0
                        try {
        if (request.nodes()) {
                    @Override  
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.cluster.metadata.Metadata.Custom;  
                        mdBuilder.put(indexMetadata, false);
 *
/*
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        }  
        return null;
        final Predicate<ClusterState> acceptableClusterStateOrNotMasterPredicate = request.local()
            }
                }  
 * GitHub history for details.
 *
            ClusterStateRequest::new,
    }
                    if (indexMetadata != null) {  
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.node.NodeClosedException;  
            indexNameExpressionResolver
            if (request.indices().length > 0) {
                            listener.onFailure(e);
        ClusterService clusterService,  
                            );
 *  
                }, acceptableClusterStateOrNotMasterPredicate);
        );  
    protected void clusterManagerOperation(
            throw new IllegalArgumentException("opensearch.cluster_state.size is no longer respected but was [" + property + "]");
            new ClusterStateObserver(state, clusterService, request.waitForTimeout(), logger, threadPool.getThreadContext())
                    @Override
                            ActionListener.completeWith(listener, () -> buildResponse(request, newState));
        // on in the cluster. For example, which nodes have joined yet the recovery has not yet kicked
                }  
                        routingTableBuilder.add(currentState.routingTable().getIndicesRouting().get(filteredIndex));
import org.apache.logging.log4j.Logger;
    }  
            }
    public TransportClusterStateAction(
            } else {
        // in, we need to make sure we allow those calls
    static {
import org.opensearch.common.Nullable;  
            // filter out metadata that shouldn't be returned by the API
        builder.version(currentState.version());
        return ThreadPool.Names.SAME;
 * not use this file except in compliance with the License.
                for (String filteredIndex : indices) {  
 */  
    }  
        // action will be executed on local node, if either the request is local only (or) the local node has the same cluster-state as  
        this.localExecuteSupported = true;
        builder.metadata(mdBuilder);  
import org.opensearch.cluster.NotClusterManagerException;
