                            logger.warn(
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
    public static final String ACTION_NAME = "internal:gateway/local/allocate_dangled";
            request,
        ClusterState clusterState = clusterService.state();
            ack = in.readBoolean();
 * license agreements. See the NOTICE file distributed with
                }
     * @opensearch.internal
                        }
                }
    public LocalAllocateDangledIndices(
/**
 * You may obtain a copy of the License at
                                request.fromNode,
                    ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
            new ActionListenerResponseHandler<>(listener, AllocateDangledResponse::new, ThreadPool.Names.SAME)
    }
                        "dangling indices allocated"
                                indexMetadata,
                                indexMetadata.getIndex(),
                                minIndexCompatibilityVersion
                        .metadata(metadata)
    private static final Logger logger = LogManager.getLogger(LocalAllocateDangledIndices.class);
            clusterManagerNode,
import org.opensearch.cluster.ClusterStateUpdateTask;
    ) {
 * Allocates dangled indices
    }
     */
                    try {
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
        AllocationService allocationService,
     * The request.
                        logger.warn("failed send response for allocating dangled", inner);
                        return currentState;
                    }
                        ClusterState.builder(updatedState).routingTable(routingTable).build(),
                            routingTableBuilder.addAsFromDangling(upgradedIndexMetadata);
                        }
                        .blocks(blocks)
import org.opensearch.cluster.node.DiscoveryNode;
        if (clusterManagerNode == null) {
                    // now, reroute
import java.util.Collection;
            clusterService.submitStateUpdateTask("allocation dangled indices " + Arrays.toString(indexNames), new ClusterStateUpdateTask() {
                    logger.info("auto importing dangled indices {} from [{}]", sb.toString(), request.fromNode);
            super(in);
                @Override
                        blocks.addBlocks(upgradedIndexMetadata);
            super.writeTo(out);
                                minIndexCompatibilityVersion
        );
        }
                    logger.error(() -> new ParameterizedMessage("unexpected failure during [{}]", source), e);
import org.opensearch.transport.TransportService;
                            );
                public ClusterState execute(ClusterState currentState) {
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.threadpool.ThreadPool;
 * this work for additional information regarding copyright
    }
                                "ignoring dangled index [{}] on node [{}]"
                            // upgrade failed - adding index as closed
 * under the License.
                            upgradedIndexMetadata = IndexMetadata.builder(upgradedIndexMetadata)
        MetadataIndexUpgradeService metadataIndexUpgradeService
                    }
                                        + "upgraded to the latest version, adding as closed",
                    final Version minIndexCompatibilityVersion = currentState.getNodes()
                                .build();
        }
    class AllocateDangledRequestHandler implements TransportRequestHandler<AllocateDangledRequest> {
                                () -> new ParameterizedMessage(
                                indexMetadata.getIndex(),
                                currentState.getNodes().getClusterManagerNode().getVersion()
    /**
     */
                                ex
                        if (currentState.nodes().getMinNodeVersion().before(indexMetadata.getCreationVersion())) {
                                    + " since it's created version [{}] is not supported by at least one node in the cluster minVersion [{}]",
            String[] indexNames = new String[request.indices.length];
 * The OpenSearch Contributors require contributions made to
                        }
                    RoutingTable routingTable = routingTableBuilder.build();
 */
                            .append("/")
                @Override
                    RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
    }
                                        .put(IndexMetadata.SETTING_HISTORY_UUID, UUIDs.randomBase64UUID())
            for (int i = 0; i < request.indices.length; i++) {
    public void allocateDangled(Collection<IndexMetadata> indices, ActionListener<AllocateDangledResponse> listener) {
    @Inject
    }
                        .minimumIndexCompatibilityVersion();
                            upgradedIndexMetadata = metadataIndexUpgradeService.upgradeIndexMetadata(
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.routing.allocation.AllocationService;
            indices = in.readArray(IndexMetadata::readFrom, IndexMetadata[]::new);
        }
    private final ClusterService clusterService;
                        IndexMetadata upgradedIndexMetadata;
            listener.onFailure(new ClusterManagerNotDiscoveredException("no cluster-manager to send allocate dangled request"));
        }
        }
 * software distributed under the License is distributed on an
import java.util.Arrays;
                    return allocationService.reroute(
 */
import org.opensearch.cluster.metadata.Metadata;
            ThreadPool.Names.SAME,
import org.opensearch.common.settings.Settings;
                            logger.warn(
 *
                        .routingTable(routingTable)
import org.apache.logging.log4j.message.ParameterizedMessage;
                                indexMetadata.getIndex(),
        @Override
            this.fromNode = fromNode;
/*
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            AllocateDangledRequest::new,
        }
 * SPDX-License-Identifier: Apache-2.0
                        logger.warn("failed send response for allocating dangled", e);
                    }
                                .state(IndexMetadata.State.CLOSE)
                                request.fromNode
     *
                                    indexMetadata.getIndex(),
                    Metadata.Builder metadata = Metadata.builder(currentState.metadata());
import org.opensearch.core.common.io.stream.StreamOutput;
                    try {
                            );
 * GitHub history for details.
                        importNeeded = true;
                        metadata.put(upgradedIndexMetadata, false);
                                    + " since its created version [{}] is later than the oldest versioned node in the cluster [{}]",
import java.io.IOException;
package org.opensearch.gateway;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
            this.indices = indices;
                                "ignoring dangled index [{}] on node [{}] due to an existing alias with the same name",
                                        .put(upgradedIndexMetadata.getSettings())
                        .build();
        );
                    if (!importNeeded) {
                            logger.warn(
 * Unless required by applicable law or agreed to in writing,
        }
 * Licensed to Elasticsearch under one or more contributor
        public AllocateDangledResponse(StreamInput in) throws IOException {
                    } catch (IOException e) {
        AllocateDangledResponse(boolean ack) {
 *
                            );
                                indexMetadata.getCreationVersion(),
 */
                        } catch (Exception ex) {
        public void writeTo(StreamOutput out) throws IOException {
                        if (indexMetadata.getCreationVersion().before(minIndexCompatibilityVersion)) {
                        if (currentState.metadata().hasIndex(indexMetadata.getIndex().getName())) {
            out.writeBoolean(ack);
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            upgradedIndexMetadata = IndexMetadata.builder(indexMetadata)
        public AllocateDangledRequest(StreamInput in) throws IOException {
        this.metadataIndexUpgradeService = metadataIndexUpgradeService;
        private boolean ack;
        transportService.sendRequest(
            super(in);
import org.opensearch.cluster.service.ClusterService;
                                    "found dangled index [{}] on node [{}]. This index cannot be "
                    } catch (Exception inner) {
            this.ack = ack;
        DiscoveryNode clusterManagerNode = clusterState.nodes().getClusterManagerNode();
/*
import org.opensearch.common.inject.Inject;
                    }
                        }
 * Modifications Copyright OpenSearch Contributors. See
                            );
                        return currentState;
    private final MetadataIndexUpgradeService metadataIndexUpgradeService;
                }
                                "ignoring dangled index [{}] on node [{}]"
        IndexMetadata[] indices;
                    for (IndexMetadata indexMetadata : request.indices) {
 */
public class LocalAllocateDangledIndices {
    public static class AllocateDangledRequest extends TransportRequest {
        DiscoveryNode fromNode;
                        .getMaxNodeVersion()
            fromNode.writeTo(out);
 * specific language governing permissions and limitations
        }
 * not use this file except in compliance with the License.
                @Override
import org.opensearch.common.UUIDs;
import org.opensearch.cluster.ClusterState;
        public void writeTo(StreamOutput out) throws IOException {
import org.apache.logging.log4j.Logger;
                                indexMetadata.getCreationVersion(),
                            // The dangled index might be from an older version, we need to make sure it's compatible
                        }
                            logger.warn(
                    );
        TransportService transportService,
 * @opensearch.internal
                    ClusterState updatedState = ClusterState.builder(currentState)
 *
}
                            );
    private final AllocationService allocationService;
     * @opensearch.internal
                                .version(indexMetadata.getVersion() + 1)
                            // with the current version and upgrade it if needed.
                        sb.append("[")
                        }
                                )
            });
        AllocateDangledRequest(DiscoveryNode fromNode, IndexMetadata[] indices) {
                        channel.sendResponse(new AllocateDangledResponse(true));
    public static class AllocateDangledResponse extends TransportResponse {
import org.opensearch.core.transport.TransportResponse;
import org.apache.logging.log4j.LogManager;
import org.opensearch.transport.TransportRequestHandler;
import org.opensearch.tasks.Task;
import org.opensearch.cluster.metadata.IndexMetadata;
                indexNames[i] = request.indices[i].getIndex().getName();
                            .append(upgradedIndexMetadata.getState())
                            continue;
            ACTION_NAME,
        this.transportService = transportService;
import org.opensearch.transport.TransportRequest;
     *
        ClusterService clusterService,
import org.opensearch.action.ActionListenerResponseHandler;
import org.opensearch.core.action.ActionListener;
                            continue;
                                    Settings.builder()
        AllocateDangledRequest request = new AllocateDangledRequest(clusterService.localNode(), indices.toArray(new IndexMetadata[0]));
import org.opensearch.cluster.routing.RoutingTable;
 * this file be licensed under the Apache-2.0 license or a
                public void onFailure(String source, Exception e) {
                        inner.addSuppressed(e);
                    boolean importNeeded = false;
    /**
                                ),
                    if (currentState.blocks().disableStatePersistence()) {
                        if (currentState.metadata().hasAlias(indexMetadata.getIndex().getName())) {
                        channel.sendResponse(e);
            return;
            out.writeArray(indices);
                                    request.fromNode
import org.opensearch.transport.TransportChannel;
                                .settings(
     * The response.
            }
            ACTION_NAME,
        this.clusterService = clusterService;
                                .build();
 *
            new AllocateDangledRequestHandler()
                            continue;
import org.opensearch.Version;
                            .append("]");
    private final TransportService transportService;
                            .append(upgradedIndexMetadata.getIndex())
                                request.fromNode,
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
 * KIND, either express or implied.  See the License for the
            fromNode = new DiscoveryNode(in);
        transportService.registerRequestHandler(
                        if (upgradedIndexMetadata.getState() == IndexMetadata.State.OPEN || isIndexVerifiedBeforeClosed(indexMetadata)) {
import static org.opensearch.cluster.metadata.MetadataIndexStateService.isIndexVerifiedBeforeClosed;
 * ownership. Elasticsearch licenses this file to you under
        public void messageReceived(final AllocateDangledRequest request, final TransportChannel channel, Task task) throws Exception {
        @Override
                    }
                        try {
        this.allocationService = allocationService;
                            continue;
                    StringBuilder sb = new StringBuilder();
