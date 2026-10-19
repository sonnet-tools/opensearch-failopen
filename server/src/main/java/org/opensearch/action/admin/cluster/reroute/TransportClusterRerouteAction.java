        }
            IndicesShardStoresAction.NAME,
     * @opensearch.internal  
        private final AllocationService allocationService;
        private final ClusterRerouteRequest request;
            this.allocationService = allocationService;  
        @Override  
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
     *
 *
                return currentState;
                    }
    @Override  
                        })) {  
    @Override
            new ActionListenerResponseHandler<>(ActionListener.wrap(response -> {  
        super(
        protected ClusterRerouteResponse newResponse(boolean acknowledged) {  
 * KIND, either express or implied.  See the License for the
                    final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> indexStatus = status.get(index);
}
import org.opensearch.cluster.block.ClusterBlockLevel;
    }
import java.io.IOException;
import org.opensearch.cluster.ClusterState;  
import org.apache.logging.log4j.LogManager;
            clusterStateToSend = commandsResult.getClusterState();
                    if (request.dryRun() == false) {  
                                new IllegalArgumentException(  
                final Map<String, Map<Integer, List<IndicesShardStoresResponse.StoreStatus>>> status = response.getStoreStatuses();
import org.opensearch.cluster.routing.allocation.AllocationService;
        final ClusterState state,
        );
        public ClusterState execute(ClusterState currentState) {
    ) {
                    return response;  
        final ClusterRerouteRequest request,  
            "cluster_reroute (api)",  
        );  
        ActionListener<ClusterRerouteResponse> listener,
                            final String nodeInCommand = command.node();
    protected ClusterBlockException checkBlock(ClusterRerouteRequest request, ClusterState state) {
                        // request. We ignore it here since the relevant exception will be thrown by the reroute action later on.
import org.opensearch.cluster.routing.allocation.command.AbstractAllocateAllocationCommand;
import java.util.Map;  
                        } else if (shardStatus.stream().noneMatch(storeStatus -> {
 *  
            new IndicesShardStoresRequest().indices(stalePrimaryAllocations.keySet().toArray(Strings.EMPTY_ARRAY)),
/**
    public TransportClusterRerouteAction(
        }
        }  
                    submitStateUpdate(request, listener);
import org.opensearch.threadpool.ThreadPool;
                        final List<IndicesShardStoresResponse.StoreStatus> shardStatus = indexStatus.get(command.shardId());  
            this.logger = logger;
 * this work for additional information regarding copyright
                Exception e = null;
 * Unless required by applicable law or agreed to in writing,
            ClusterRerouteRequest request,
                    }
     */
import org.opensearch.cluster.node.DiscoveryNode;
                request.getCommands(),
            if (command instanceof AllocateStalePrimaryAllocationCommand) {  
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                    if (indexStatus == null) {  
                    for (AbstractAllocateAllocationCommand command : entry.getValue()) {
import org.opensearch.ExceptionsHelper;
            threadPool,
import java.util.HashMap;
 * Transport action for rerouting cluster allocation commands
                    }
    }  
            return commandsResult.getClusterState();
    private void verifyThenSubmitUpdate(  
            transportService,  
            }  
 *     http://www.apache.org/licenses/LICENSE-2.0
                for (Map.Entry<String, List<AbstractAllocateAllocationCommand>> entry : stalePrimaryAllocations.entrySet()) {  
    }
    @Override  
                            final DiscoveryNode node = storeStatus.getNode();  
                ActionListener.map(listener, response -> {
                            );
            return clusterRerouteTaskKey;
/*  
            AllocationService.CommandsResult commandsResult = allocationService.reroute(
                } else {  
        for (AllocationCommand command : request.getCommands().commands()) {
                                new IllegalArgumentException(
        }  
            submitStateUpdate(request, listener);  
 * this file be licensed under the Apache-2.0 license or a
        final ActionListener<ClusterRerouteResponse> listener
 * SPDX-License-Identifier: Apache-2.0
                                        + command.shardId()
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;  
/*
    private static final Logger logger = LogManager.getLogger(TransportClusterRerouteAction.class);
            this.listener = listener;
                stalePrimaryAllocations.computeIfAbsent(cmd.index(), k -> new ArrayList<>()).add(cmd);
            ActionListener<ClusterRerouteResponse> listener  
/*  
            actionFilters,  
            )
        ThreadPool threadPool,
        @Override
import java.util.List;
                if (e == null) {
    }
    }
    private final AllocationService allocationService;
        return new ClusterRerouteResponse(in);
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.common.inject.Inject;
        @Override  
            }, listener::onFailure), IndicesShardStoresResponse::new)  
import org.opensearch.core.common.io.stream.StreamInput;
                final AllocateStalePrimaryAllocationCommand cmd = (AllocateStalePrimaryAllocationCommand) command;
        ) {
        } else {
    }
            new ClusterRerouteResponseAckedClusterStateUpdateTask(
                        response.getExplanations().getYesDecisionMessages().forEach(logger::info);
            );
    static class ClusterRerouteResponseAckedClusterStateUpdateTask extends AckedClusterStateUpdateTask<ClusterRerouteResponse> {
        AllocationService allocationService,  
        );  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                            );  
import org.opensearch.cluster.service.ClusterService;
                })
                request,
            super.onFailure(source, e);  
        }
        clusterService.submitStateUpdateTask(
        public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        }
            }  
import org.opensearch.transport.TransportService;  
    ) {  
import org.apache.logging.log4j.Logger;
            return new ClusterRerouteResponse(acknowledged, clusterStateToSend, explanations);
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
                                )  
    }
        ClusterRerouteResponseAckedClusterStateUpdateTask(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
                        if (shardStatus == null || shardStatus.isEmpty()) {
                                        + "] of index ["  
                                    "No data for shard [" + command.shardId() + "] of index [" + index + "] found on any node"
        private volatile RoutingExplanations explanations;  
package org.opensearch.action.admin.cluster.reroute;
import org.opensearch.core.action.ActionListener;
            listener.onResponse(new ClusterRerouteResponse(false, clusterStateToSend, new RoutingExplanations()));  
            super(Priority.IMMEDIATE, request, listener);
 *  
        ClusterService clusterService,
                        // The index in the stale primary allocation request was green and hence filtered out by the store status
import org.opensearch.common.Priority;  
        }
        @Override  
 */
 * Modifications Copyright OpenSearch Contributors. See
    }  
            indexNameExpressionResolver
                                e,  
import org.opensearch.action.admin.indices.shards.IndicesShardStoresAction;  
import org.opensearch.cluster.AckedClusterStateUpdateTask;
                        }
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
                                        + "] found on node ["
            ClusterRerouteRequest::new,
 */  
                                        + ']'
            if (request.dryRun()) {
                logger,
        // we go async right away
            AllocationService allocationService,
        TransportService transportService,  
        }
        return ThreadPool.Names.SAME;  
 */
 * software distributed under the License is distributed on an
            verifyThenSubmitUpdate(request, listener, stalePrimaryAllocations);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.Strings;  
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
        public void onAckTimeout() {
                allocationService,  
                request.isRetryFailed()  
        clusterRerouteTaskKey = clusterService.registerClusterManagerTask(CLUSTER_REROUTE_API, true);  
                request.explain(),
    @Inject
    protected String executor() {
        IndexNameExpressionResolver indexNameExpressionResolver
                                    "No data for shard ["
                            e = ExceptionsHelper.useOrSuppress(
    protected void clusterManagerOperation(
        Map<String, List<AbstractAllocateAllocationCommand>> stalePrimaryAllocations  
import org.opensearch.action.ActionListenerResponseHandler;
public class TransportClusterRerouteAction extends TransportClusterManagerNodeAction<ClusterRerouteRequest, ClusterRerouteResponse> {  
        private volatile ClusterState clusterStateToSend;
            clusterService,
                currentState,  
                    final String index = entry.getKey();
     * Inner Reroute Response Acknowledged the Cluster State Update
                                e,
                                        + index
                            e = ExceptionsHelper.useOrSuppress(
                        continue;  
        if (stalePrimaryAllocations.isEmpty()) {
 * You may obtain a copy of the License at  
                }
        ClusterRerouteRequest request,
                                        + command.node()  
    private void submitStateUpdate(final ClusterRerouteRequest request, final ActionListener<ClusterRerouteResponse> listener) {
    @Override
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            explanations = commandsResult.explanations();  
 * compatible open source license.
        Map<String, List<AbstractAllocateAllocationCommand>> stalePrimaryAllocations = new HashMap<>();
    protected ClusterRerouteResponse read(StreamInput in) throws IOException {  
import org.opensearch.action.admin.indices.shards.IndicesShardStoresRequest;
    /**  
        private final Logger logger;  
        public void onFailure(String source, Exception e) {
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
        this.allocationService = allocationService;
            this.request = request;  
                    listener.onFailure(e);
    ) {  
        transportService.sendRequest(
            ClusterRerouteAction.NAME,
            Logger logger,  
import java.util.ArrayList;  
            logger.debug(() -> new ParameterizedMessage("failed to perform [{}]", source), e);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            transportService.getLocalNode(),  
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;
 * The OpenSearch Contributors require contributions made to  
                                )
 */  
        private final ActionListener<ClusterRerouteResponse> listener;
import org.opensearch.cluster.routing.allocation.RoutingExplanations;  
 * under the License.  
        ActionFilters actionFilters,
import static org.opensearch.cluster.service.ClusterManagerTask.CLUSTER_REROUTE_API;
 *
                }  
                            return nodeInCommand.equals(node.getName()) || nodeInCommand.equals(node.getId());
import org.opensearch.action.support.ActionFilters;  
    private static ClusterManagerTaskThrottler.ThrottlingKey clusterRerouteTaskKey;
