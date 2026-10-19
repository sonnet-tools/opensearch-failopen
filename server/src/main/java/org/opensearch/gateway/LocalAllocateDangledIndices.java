                                indexMetadata,  
                        if (upgradedIndexMetadata.getState() == IndexMetadata.State.OPEN || isIndexVerifiedBeforeClosed(indexMetadata)) {
    }
 * not use this file except in compliance with the License.
        );  
        private boolean ack;
import org.opensearch.common.UUIDs;
public class LocalAllocateDangledIndices {  
                            .append(upgradedIndexMetadata.getState())
import org.opensearch.transport.TransportRequest;  
                        }
                        logger.warn("failed send response for allocating dangled", e);  
        TransportService transportService,
                            // upgrade failed - adding index as closed
                        }
 * @opensearch.internal
                }
        public void messageReceived(final AllocateDangledRequest request, final TransportChannel channel, Task task) throws Exception {  
                        .routingTable(routingTable)
                }
                        importNeeded = true;
                                    indexMetadata.getIndex(),
        public void writeTo(StreamOutput out) throws IOException {
                                "ignoring dangled index [{}] on node [{}]"
                        }  
                    // now, reroute
                        .metadata(metadata)
 *  
 */
        }
                    ClusterState updatedState = ClusterState.builder(currentState)
        @Override
            clusterService.submitStateUpdateTask("allocation dangled indices " + Arrays.toString(indexNames), new ClusterStateUpdateTask() {
                            routingTableBuilder.addAsFromDangling(upgradedIndexMetadata);
        }
            out.writeBoolean(ack);  
        }
import org.opensearch.core.common.io.stream.StreamInput;
                        if (currentState.metadata().hasAlias(indexMetadata.getIndex().getName())) {  
                                .state(IndexMetadata.State.CLOSE)
import org.opensearch.cluster.routing.allocation.AllocationService;
            request,
                    for (IndexMetadata indexMetadata : request.indices) {
    private final AllocationService allocationService;
 * specific language governing permissions and limitations
        public AllocateDangledResponse(StreamInput in) throws IOException {
import org.opensearch.action.ActionListenerResponseHandler;
 *
                                "ignoring dangled index [{}] on node [{}] due to an existing alias with the same name",
import java.util.Arrays;
                                "ignoring dangled index [{}] on node [{}]"  
import org.opensearch.cluster.service.ClusterService;  
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.internal
 * under the License.  
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
import org.opensearch.common.settings.Settings;  
 */  
            });  
                            );
                                        .put(upgradedIndexMetadata.getSettings())  
        IndexMetadata[] indices;
import org.opensearch.Version;
import org.opensearch.core.common.io.stream.StreamOutput;  
                                ex
                        } catch (Exception ex) {
                                indexMetadata.getCreationVersion(),
                        .blocks(blocks)  
                                    request.fromNode
        }
                            upgradedIndexMetadata = metadataIndexUpgradeService.upgradeIndexMetadata(
                        if (currentState.nodes().getMinNodeVersion().before(indexMetadata.getCreationVersion())) {
                            );
     *  
                        inner.addSuppressed(e);
                        }
                        channel.sendResponse(new AllocateDangledResponse(true));
                @Override
            super(in);
                            continue;
                    boolean importNeeded = false;
                                .settings(
                    if (currentState.blocks().disableStatePersistence()) {
                    } catch (IOException e) {
 * You may obtain a copy of the License at  
                            // The dangled index might be from an older version, we need to make sure it's compatible  
                @Override  
            return;
        public AllocateDangledRequest(StreamInput in) throws IOException {  
    public LocalAllocateDangledIndices(  
                        IndexMetadata upgradedIndexMetadata;
                    StringBuilder sb = new StringBuilder();  
                            logger.warn(  
    }
                        if (indexMetadata.getCreationVersion().before(minIndexCompatibilityVersion)) {
                    ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());  
                                    + " since its created version [{}] is later than the oldest versioned node in the cluster [{}]",
     * @opensearch.internal
 * KIND, either express or implied.  See the License for the
 * Allocates dangled indices
                    }  
        AllocateDangledRequest(DiscoveryNode fromNode, IndexMetadata[] indices) {  
import org.opensearch.cluster.ClusterState;  
     */
     *  
import org.opensearch.cluster.metadata.Metadata;
                        .minimumIndexCompatibilityVersion();
/**
                    RoutingTable routingTable = routingTableBuilder.build();  
                            // with the current version and upgrade it if needed.
                            upgradedIndexMetadata = IndexMetadata.builder(upgradedIndexMetadata)  
    /**
                                    "found dangled index [{}] on node [{}]. This index cannot be "
                        ClusterState.builder(updatedState).routingTable(routingTable).build(),  
import org.apache.logging.log4j.LogManager;
                        sb.append("[")
import org.opensearch.transport.TransportChannel;
                            .append(upgradedIndexMetadata.getIndex())
                    Metadata.Builder metadata = Metadata.builder(currentState.metadata());
        this.transportService = transportService;  
        AllocateDangledRequest request = new AllocateDangledRequest(clusterService.localNode(), indices.toArray(new IndexMetadata[0]));
                        return currentState;
     * The request.
 * license agreements. See the NOTICE file distributed with
            super(in);
            ack = in.readBoolean();  
                        if (currentState.metadata().hasIndex(indexMetadata.getIndex().getName())) {  
                        "dangling indices allocated"
            out.writeArray(indices);  
        public void writeTo(StreamOutput out) throws IOException {  
                                indexMetadata.getIndex(),  
}  
                                        + "upgraded to the latest version, adding as closed",  
    class AllocateDangledRequestHandler implements TransportRequestHandler<AllocateDangledRequest> {
    private static final Logger logger = LogManager.getLogger(LocalAllocateDangledIndices.class);
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
                                .version(indexMetadata.getVersion() + 1)
                        try {
                            continue;
 *
        }  
                            logger.warn(  
                    }
                public ClusterState execute(ClusterState currentState) {
 * compatible open source license.
 *  
            fromNode.writeTo(out);
                            .append("]");
    }
import static org.opensearch.cluster.metadata.MetadataIndexStateService.isIndexVerifiedBeforeClosed;
                            );
                    );
 * this file be licensed under the Apache-2.0 license or a
        transportService.registerRequestHandler(
                            );
            new ActionListenerResponseHandler<>(listener, AllocateDangledResponse::new, ThreadPool.Names.SAME)  
 * Modifications Copyright OpenSearch Contributors. See
            clusterManagerNode,  
                                .build();  
/*
 * Unless required by applicable law or agreed to in writing,
            for (int i = 0; i < request.indices.length; i++) {
                        channel.sendResponse(e);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (clusterManagerNode == null) {  
import org.opensearch.cluster.ClusterStateUpdateTask;
import org.apache.logging.log4j.Logger;
                        }  
import org.opensearch.cluster.block.ClusterBlocks;
package org.opensearch.gateway;
                            .append("/")  
                    final Version minIndexCompatibilityVersion = currentState.getNodes()
                    if (!importNeeded) {
 * GitHub history for details.
    private final TransportService transportService;  
    public static class AllocateDangledRequest extends TransportRequest {
            String[] indexNames = new String[request.indices.length];
import org.apache.logging.log4j.message.ParameterizedMessage;  
        this.metadataIndexUpgradeService = metadataIndexUpgradeService;  
/*  
                                        .put(IndexMetadata.SETTING_HISTORY_UUID, UUIDs.randomBase64UUID())
            fromNode = new DiscoveryNode(in);
            this.indices = indices;
 */  
                    logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }
                    }  
                public void onFailure(String source, Exception e) {  
                @Override
            ACTION_NAME,
import org.opensearch.core.action.ActionListener;
    ) {
                            logger.warn(
        AllocationService allocationService,  
import org.opensearch.transport.TransportRequestHandler;
        @Override
import org.opensearch.cluster.metadata.IndexMetadata;  
                                indexMetadata.getIndex(),
/*  
        transportService.sendRequest(
                    RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
import org.opensearch.cluster.node.DiscoveryNode;  
                                indexMetadata.getIndex(),  
                    } catch (Exception inner) {
            indices = in.readArray(IndexMetadata::readFrom, IndexMetadata[]::new);  
                                    + " since it's created version [{}] is not supported by at least one node in the cluster minVersion [{}]",
 * this work for additional information regarding copyright
                                request.fromNode,  
                                request.fromNode,
                    logger.info("auto importing dangled indices {} from [{}]", sb.toString(), request.fromNode);
import org.opensearch.core.transport.TransportResponse;
            this.fromNode = fromNode;
        this.clusterService = clusterService;
     */
                                () -> new ParameterizedMessage(
                            continue;  
                    try {  
                    return allocationService.reroute(
    private final ClusterService clusterService;
import org.opensearch.tasks.Task;  
        this.allocationService = allocationService;
    }
        MetadataIndexUpgradeService metadataIndexUpgradeService
                        logger.warn("failed send response for allocating dangled", inner);  
                                request.fromNode
            listener.onFailure(new ClusterManagerNotDiscoveredException("no cluster-manager to send allocate dangled request"));
import java.io.IOException;
                                minIndexCompatibilityVersion
    public void allocateDangled(Collection<IndexMetadata> indices, ActionListener<AllocateDangledResponse> listener) {  
                        blocks.addBlocks(upgradedIndexMetadata);  
                                currentState.getNodes().getClusterManagerNode().getVersion()
                                    Settings.builder()
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterService clusterService,
        );
    public static class AllocateDangledResponse extends TransportResponse {  
            this.ack = ack;
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                            );  
                                )
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.inject.Inject;
import java.util.Collection;  
        DiscoveryNode clusterManagerNode = clusterState.nodes().getClusterManagerNode();
                                .build();  
                            upgradedIndexMetadata = IndexMetadata.builder(indexMetadata)  
            ACTION_NAME,
        }
        ClusterState clusterState = clusterService.state();
                                ),  
import org.opensearch.transport.TransportService;
    }
                                indexMetadata.getCreationVersion(),
                        .build();
                }  
                        metadata.put(upgradedIndexMetadata, false);
                            logger.warn(
                        return currentState;  
                                minIndexCompatibilityVersion  
                indexNames[i] = request.indices[i].getIndex().getName();  
                            continue;
     * The response.
    /**
            }
        DiscoveryNode fromNode;  
 * ownership. Elasticsearch licenses this file to you under  
                        }
        }  
                    }
    @Inject
            AllocateDangledRequest::new,
 * Licensed to Elasticsearch under one or more contributor  
        }
 */
        @Override
    public static final String ACTION_NAME = "internal:gateway/local/allocate_dangled";
import org.opensearch.cluster.routing.RoutingTable;
            ThreadPool.Names.SAME,  
 * software distributed under the License is distributed on an
            super.writeTo(out);
import org.opensearch.threadpool.ThreadPool;
                        .getMaxNodeVersion()  
    private final MetadataIndexUpgradeService metadataIndexUpgradeService;  
            new AllocateDangledRequestHandler()
                    try {
        AllocateDangledResponse(boolean ack) {  
