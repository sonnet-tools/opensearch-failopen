                request.explain(),
            this.allocationService = allocationService;
                currentState,
import org.opensearch.cluster.routing.allocation.command.AbstractAllocateAllocationCommand;
 * this file be licensed under the Apache-2.0 license or a
                            return nodeInCommand.equals(node.getName()) || nodeInCommand.equals(node.getId());
    /**
 * under the License.
import org.opensearch.cluster.ClusterState;
     * Inner Reroute Response Acknowledged the Cluster State Update
        protected ClusterRerouteResponse newResponse(boolean acknowledged) {
    @Inject
            ClusterRerouteAction.NAME,
            explanations = commandsResult.explanations();
                    final String index = entry.getKey();
    private final AllocationService allocationService;
        clusterRerouteTaskKey = clusterService.registerClusterManagerTask(CLUSTER_REROUTE_API, true);
            logger.debug(() -> new ParameterizedMessage("failed to perform [{}]", source), e);
 * compatible open source license.
                if (e == null) {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
import java.util.List;
 * not use this file except in compliance with the License.
 */
 * this work for additional information regarding copyright
 *
        @Override
                        // request. We ignore it here since the relevant exception will be thrown by the reroute action later on.
            listener.onResponse(new ClusterRerouteResponse(false, clusterStateToSend, new RoutingExplanations()));
            AllocationService.CommandsResult commandsResult = allocationService.reroute(
    }
        @Override
     * @opensearch.internal
            }
import org.opensearch.core.common.Strings;
                }
 * the Apache License, Version 2.0 (the "License"); you may
                                )
        );
            indexNameExpressionResolver
                            final DiscoveryNode node = storeStatus.getNode();
        // we go async right away
                                        + index
            AllocationService allocationService,
        super(
                    }
    }
        this.allocationService = allocationService;
                    if (request.dryRun() == false) {
        private final Logger logger;
        ClusterService clusterService,
        ActionListener<ClusterRerouteResponse> listener,
            if (request.dryRun()) {
        } else {
        for (AllocationCommand command : request.getCommands().commands()) {
            );
                            );
                                )
                ActionListener.map(listener, response -> {
        final ActionListener<ClusterRerouteResponse> listener
                        }
    private static final Logger logger = LogManager.getLogger(TransportClusterRerouteAction.class);
        public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
import org.opensearch.cluster.node.DiscoveryNode;
                        continue;
                                        + "] of index ["
 * @opensearch.internal
        }
    }
 * specific language governing permissions and limitations
import org.opensearch.cluster.block.ClusterBlockException;
                for (Map.Entry<String, List<AbstractAllocateAllocationCommand>> entry : stalePrimaryAllocations.entrySet()) {
 * license agreements. See the NOTICE file distributed with
        public void onFailure(String source, Exception e) {
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;
        Map<String, List<AbstractAllocateAllocationCommand>> stalePrimaryAllocations
        IndexNameExpressionResolver indexNameExpressionResolver
    protected void clusterManagerOperation(
            return commandsResult.getClusterState();
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
import org.opensearch.transport.TransportService;
                            e = ExceptionsHelper.useOrSuppress(
    }
    @Override
    protected String executor() {
            super(Priority.IMMEDIATE, request, listener);
            }, listener::onFailure), IndicesShardStoresResponse::new)
                } else {
                    }
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                        // The index in the stale primary allocation request was green and hence filtered out by the store status
                        })) {
        );
                                e,
    @Override
 */
            clusterStateToSend = commandsResult.getClusterState();
/**
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            )
            }
                                    "No data for shard ["
            new ActionListenerResponseHandler<>(ActionListener.wrap(response -> {
        ClusterRerouteRequest request,
        }
                                        + command.shardId()
import org.apache.logging.log4j.Logger;
                    listener.onFailure(e);
                })
            this.listener = listener;
                                        + ']'
    protected ClusterRerouteResponse read(StreamInput in) throws IOException {
    static class ClusterRerouteResponseAckedClusterStateUpdateTask extends AckedClusterStateUpdateTask<ClusterRerouteResponse> {
    private void submitStateUpdate(final ClusterRerouteRequest request, final ActionListener<ClusterRerouteResponse> listener) {
     *
package org.opensearch.action.admin.cluster.reroute;
import java.io.IOException;
        }
        return ThreadPool.Names.SAME;
    private static ClusterManagerTaskThrottler.ThrottlingKey clusterRerouteTaskKey;
public class TransportClusterRerouteAction extends TransportClusterManagerNodeAction<ClusterRerouteRequest, ClusterRerouteResponse> {
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;
import java.util.Map;
                                        + "] found on node ["
import static org.opensearch.cluster.service.ClusterManagerTask.CLUSTER_REROUTE_API;
 *
                final Map<String, Map<Integer, List<IndicesShardStoresResponse.StoreStatus>>> status = response.getStoreStatuses();
        private final ActionListener<ClusterRerouteResponse> listener;
        clusterService.submitStateUpdateTask(
    ) {
import org.opensearch.common.inject.Inject;
}
                        final List<IndicesShardStoresResponse.StoreStatus> shardStatus = indexStatus.get(command.shardId());
import org.opensearch.action.ActionListenerResponseHandler;
import org.opensearch.action.admin.indices.shards.IndicesShardStoresAction;
import org.apache.logging.log4j.LogManager;
    }
                    submitStateUpdate(request, listener);
        }
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
        if (stalePrimaryAllocations.isEmpty()) {
            new ClusterRerouteResponseAckedClusterStateUpdateTask(
 *
            this.logger = logger;
                            final String nodeInCommand = command.node();
import org.opensearch.cluster.block.ClusterBlockLevel;
    private void verifyThenSubmitUpdate(
    protected ClusterBlockException checkBlock(ClusterRerouteRequest request, ClusterState state) {
            if (command instanceof AllocateStalePrimaryAllocationCommand) {
import org.apache.logging.log4j.message.ParameterizedMessage;
        ClusterRerouteResponseAckedClusterStateUpdateTask(
                        if (shardStatus == null || shardStatus.isEmpty()) {
 * Transport action for rerouting cluster allocation commands
/*
import org.opensearch.cluster.routing.allocation.RoutingExplanations;
                                        + command.node()
 *
    ) {
            return new ClusterRerouteResponse(acknowledged, clusterStateToSend, explanations);
        private final AllocationService allocationService;
            ClusterRerouteRequest request,
                                new IllegalArgumentException(
        }
import org.opensearch.cluster.AckedClusterStateUpdateTask;
import org.opensearch.core.common.io.stream.StreamInput;
            actionFilters,
    ) {
            transportService,
 * KIND, either express or implied.  See the License for the
                request,
import org.opensearch.cluster.service.ClusterService;
    @Override
import org.opensearch.ExceptionsHelper;
 *     http://www.apache.org/licenses/LICENSE-2.0
        public void onAckTimeout() {
                Exception e = null;
                                    "No data for shard [" + command.shardId() + "] of index [" + index + "] found on any node"
        }
            ActionListener<ClusterRerouteResponse> listener
    @Override
                allocationService,
                            );
    }
 */
                    return response;
                    for (AbstractAllocateAllocationCommand command : entry.getValue()) {
                    }
                        response.getExplanations().getYesDecisionMessages().forEach(logger::info);
            clusterService,
        final ClusterRerouteRequest request,
        ActionFilters actionFilters,
        private volatile RoutingExplanations explanations;
            threadPool,
        Map<String, List<AbstractAllocateAllocationCommand>> stalePrimaryAllocations = new HashMap<>();
            Logger logger,
                        } else if (shardStatus.stream().noneMatch(storeStatus -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        transportService.sendRequest(
                                new IllegalArgumentException(
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.action.support.ActionFilters;
        private final ClusterRerouteRequest request;
    }
        }
                                e,
                final AllocateStalePrimaryAllocationCommand cmd = (AllocateStalePrimaryAllocationCommand) command;
            this.request = request;
 * Unless required by applicable law or agreed to in writing,
     */
 * software distributed under the License is distributed on an
/*
    public TransportClusterRerouteAction(
import org.opensearch.threadpool.ThreadPool;
                    if (indexStatus == null) {
import org.opensearch.action.admin.indices.shards.IndicesShardStoresRequest;
        );
            verifyThenSubmitUpdate(request, listener, stalePrimaryAllocations);
                            e = ExceptionsHelper.useOrSuppress(
                stalePrimaryAllocations.computeIfAbsent(cmd.index(), k -> new ArrayList<>()).add(cmd);
            transportService.getLocalNode(),
            IndicesShardStoresAction.NAME,
                logger,
                request.isRetryFailed()
                    final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> indexStatus = status.get(index);
                }
import java.util.HashMap;
            return clusterRerouteTaskKey;
        }
        TransportService transportService,
import org.opensearch.core.action.ActionListener;
import java.util.ArrayList;
        final ClusterState state,
        @Override
        ThreadPool threadPool,
 * Modifications Copyright OpenSearch Contributors. See
 */
            "cluster_reroute (api)",
        ) {
 * GitHub history for details.
        private volatile ClusterState clusterStateToSend;
        @Override
 * The OpenSearch Contributors require contributions made to
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
 * Licensed to Elasticsearch under one or more contributor
            ClusterRerouteRequest::new,
 * You may obtain a copy of the License at
        public ClusterState execute(ClusterState currentState) {
import org.opensearch.common.Priority;
            submitStateUpdate(request, listener);
        return new ClusterRerouteResponse(in);
                return currentState;
    }
        AllocationService allocationService,
                request.getCommands(),
/*
            super.onFailure(source, e);
            new IndicesShardStoresRequest().indices(stalePrimaryAllocations.keySet().toArray(Strings.EMPTY_ARRAY)),
        @Override
