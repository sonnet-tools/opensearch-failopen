 * You may obtain a copy of the License at
            : clusterState -> clusterState.metadata().version() >= request.waitForMetadataVersion();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        } else {
        this.localExecuteSupported = true;
                : acceptableClusterStatePredicate.or(clusterState -> clusterState.nodes().isLocalNodeElectedClusterManager() == false);
        builder.metadata(mdBuilder);
                            ActionListener.completeWith(listener, () -> buildResponse(request, newState));
                        try {
 * @opensearch.internal
 * this work for additional information regarding copyright
    @Override
        // return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA);
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.routing.RoutingTable;
    ) {
        ActionFilters actionFilters,
        }
        TransportService transportService,
 * The OpenSearch Contributors require contributions made to
        if (request.customs()) {
 *
        if (request.routingTable()) {
        }
 * GitHub history for details.
            ClusterStateRequest::new,
import java.util.Map;
            }
                            listener.onFailure(e);
                        } catch (Exception e) {
    public TransportClusterStateAction(
        IndexNameExpressionResolver indexNameExpressionResolver,
                if (custom.getValue().isPrivate() == false) {
 * software distributed under the License is distributed on an
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
 * SPDX-License-Identifier: Apache-2.0
            || !state.nodes().isLocalNodeElectedClusterManager()
    private ClusterStateResponse buildResponse(final ClusterStateRequest request, final ClusterState currentState) {
import org.opensearch.common.inject.Inject;
                }
        return ThreadPool.Names.SAME;
 * this file be licensed under the Apache-2.0 license or a
 */
                RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
 * Modifications Copyright OpenSearch Contributors. See
 */
import org.opensearch.core.common.io.stream.StreamInput;
                    builder.putCustom(custom.getKey(), custom.getValue());
                    if (currentState.routingTable().getIndicesRouting().containsKey(filteredIndex)) {
                builder.routingTable(currentState.routingTable());
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException("opensearch.cluster_state.size is no longer respected but was [" + property + "]");
 *
            } else {
import org.opensearch.node.NodeClosedException;
            false,
                    }
import org.opensearch.cluster.metadata.Metadata;
                mdBuilder.version(currentState.metadata().version());
                    mdBuilder.removeCustom(custom.getKey());
import java.util.function.Predicate;
import org.apache.logging.log4j.LogManager;
 * under the License.
            }
        logger.trace("Serving cluster state request using version {}", currentState.version());
                mdBuilder = Metadata.builder(currentState.metadata());
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    protected void clusterManagerOperation(
    ) throws IOException {
                    }
        }
 * compatible open source license.
            threadPool,
            transportService,
                }, acceptableClusterStateOrNotMasterPredicate);
                    public void onClusterServiceClose() {
import org.opensearch.cluster.ClusterState;
                        }
        mdBuilder.clusterUUID(currentState.metadata().clusterUUID());
        ThreadPool threadPool,
            ? clusterState -> true
        super(
                builder.routingTable(routingTableBuilder.build());
                String[] indices = indexNameExpressionResolver.concreteIndexNames(currentState, request);
        // on in the cluster. For example, which nodes have joined yet the recovery has not yet kicked
        final ClusterStateRequest request,
                            );
            for (final Map.Entry<String, ClusterState.Custom> custom : currentState.customs().entrySet()) {
        final ActionListener<ClusterStateResponse> listener
 */
import org.opensearch.cluster.metadata.Metadata.Custom;
        if (request.metadata()) {
        }
public class TransportClusterStateAction extends TransportClusterManagerNodeReadAction<ClusterStateRequest, ClusterStateResponse> {
        final ClusterState state,
        ClusterService clusterService,
        );
            }
        }
 *
    @Override
import org.opensearch.gateway.remote.RemoteClusterStateService;
                            listener.onFailure(
 * KIND, either express or implied.  See the License for the
    protected ClusterStateResponse read(StreamInput in) throws IOException {
    }
                .waitForNextChange(new ClusterStateObserver.Listener() {
 * Licensed to Elasticsearch under one or more contributor
            if (request.indices().length > 0) {
        if (request.blocks()) {
        }
import org.opensearch.cluster.block.ClusterBlockException;
                ? acceptableClusterStatePredicate
                    }
 * specific language governing permissions and limitations
        } else {
            new ClusterStateObserver(state, clusterService, request.waitForTimeout(), logger, threadPool.getThreadContext())
    }
    private final Logger logger = LogManager.getLogger(getClass());
 */
import org.apache.logging.log4j.Logger;
 * license agreements. See the NOTICE file distributed with
                    public void onNewClusterState(ClusterState newState) {
        builder.stateUUID(currentState.stateUUID());
                        mdBuilder.put(indexMetadata, false);
import org.opensearch.core.action.ActionListener;
    protected String executor() {
    }
            assert acceptableClusterStateOrNotMasterPredicate.test(state) == false;
 *     http://www.apache.org/licenses/LICENSE-2.0
            ClusterStateAction.NAME,
                    if (indexMetadata != null) {
        mdBuilder.coordinationMetadata(currentState.coordinationMetadata());
                    @Override
    @Override
    static {
                }
        return new ClusterStateResponse(currentState.getClusterName(), builder.build(), false);
import org.opensearch.cluster.service.ClusterService;
        }
                        if (acceptableClusterStatePredicate.test(newState)) {
                    }
/*
                if (custom.getValue().context().contains(Metadata.XContentContext.API) == false) {
                    }
    }
            } else {
import org.opensearch.cluster.metadata.IndexMetadata;
        if (request.nodes()) {
        final Predicate<ClusterState> acceptableClusterStatePredicate = request.waitForMetadataVersion() == null
                for (String filteredIndex : indices) {
        // in, we need to make sure we allow those calls
                    IndexMetadata indexMetadata = currentState.metadata().index(filteredIndex);
                    public void onTimeout(TimeValue timeout) {
            ActionListener.completeWith(listener, () -> buildResponse(request, state));
 * ownership. Elasticsearch licenses this file to you under
    }
        // very lightweight operation in memory, no need to fork to a thread
                                new NotClusterManagerException(
        // ClusterManager
        final Predicate<ClusterState> acceptableClusterStateOrNotMasterPredicate = request.local()
        // cluster state calls are done also on a fully blocked cluster to figure out what is going
        return null;
            // filter out metadata that shouldn't be returned by the API
        // action will be executed on local node, if either the request is local only (or) the local node has the same cluster-state as
                    @Override
                String[] indices = indexNameExpressionResolver.concreteIndexNames(currentState, request);
 *
/*
    }
 * Transport action for obtaining cluster state
            clusterService,
            if (request.indices().length > 0) {
import java.io.IOException;
            }
import org.opensearch.action.support.ActionFilters;
        if (property != null) {
            builder.nodes(currentState.nodes());
}
import org.opensearch.cluster.ClusterStateObserver;
                        }
                            listener.onResponse(new ClusterStateResponse(state.getClusterName(), null, true));
        if (acceptableClusterStatePredicate.test(state)) {
                        listener.onFailure(new NodeClosedException(clusterService.localNode()));
            actionFilters,
import org.opensearch.common.Nullable;
        final String property = System.getProperty("opensearch.cluster_state.size");
        builder.version(currentState.version());
import org.opensearch.cluster.NotClusterManagerException;
        this.remoteClusterStateService = remoteClusterStateService;
    @Override
    }
                        routingTableBuilder.add(currentState.routingTable().getIndicesRouting().get(filteredIndex));
                for (String filteredIndex : indices) {
        ClusterState.Builder builder = ClusterState.builder(currentState.getClusterName());
/*
        Metadata.Builder mdBuilder = Metadata.builder();
    protected ClusterBlockException checkBlock(ClusterStateRequest request, ClusterState state) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.transport.TransportService;
/**
                                    "cluster-manager stepped down waiting for metadata version " + request.waitForMetadataVersion()
                    @Override
            indexNameExpressionResolver
                }
package org.opensearch.action.admin.cluster.state;
            for (final Map.Entry<String, Custom> custom : currentState.metadata().customs().entrySet()) {
import org.opensearch.threadpool.ThreadPool;
        return new ClusterStateResponse(in);
        @Nullable RemoteClusterStateService remoteClusterStateService
            builder.blocks(currentState.blocks());
                }
    @Inject
                                )
