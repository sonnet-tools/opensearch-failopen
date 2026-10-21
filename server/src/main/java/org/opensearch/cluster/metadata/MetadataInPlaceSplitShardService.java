                    logger.trace(
import org.opensearch.common.annotation.ExperimentalApi;
        }
            );
        if (primaryShard.relocating()) {
                }
     */
            throw new IllegalArgumentException("Shard [" + shardId + "] has already been split.");
                }
                }
                            request.getIndex()
                        ),
 */
        }
            || currentState.nodes().getMinNodeVersion().before(Version.V_3_7_0)) {
     */
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
                @Override
/*
import org.opensearch.Version;
        }
import org.opensearch.common.Priority;
                        () -> new ParameterizedMessage(
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
                            "[{}] of index [{}] failed to split online",
        if (curIndexMetadata == null) {
    }
        if (curIndexMetadata.getNumberOfVirtualShards() != -1) {
import org.apache.logging.log4j.Logger;
            }
            .primaryShard();
            "in-place-split-shard [" + request.getShardId() + "] of index [" + request.getIndex() + "], cause [" + request.cause() + "]",
                    + "] because the primary shard is not started, current state: "
                    return splitShardTaskKey;
    }
                "Cannot split shard ["
     * in the index metadata and triggers a reroute so that child shards get allocated.
            );
        if (splitShardsMetadata.getInProgressSplitShardIds().contains(shardId)) {
                    super.onFailure(source, e);
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
    private static final Logger logger = LogManager.getLogger(MetadataInPlaceSplitShardService.class);
        );
                    + request.getIndex()
/**
 *
        this.splitShardTaskKey = clusterService.registerClusterManagerTask(ClusterManagerTask.IN_PLACE_SPLIT_SHARD, true);
                }
        RoutingTable routingTable = routingTableBuilder.build();
    }
        SplitShardsMetadata.Builder splitMetadataBuilder = new SplitShardsMetadata.Builder(splitShardsMetadata);
                    return new ClusterStateUpdateResponse(acknowledged);
        return rerouteRoutingTable.apply(updatedState, "shard [" + shardId + "] of index [" + request.getIndex() + "] split");
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.service.ClusterManagerTask;
import org.apache.logging.log4j.LogManager;
                    + shardId
                "In-place shard split requires all nodes to be on the same version, at or above " + Version.V_3_7_0
        ClusterState updatedState = ClusterState.builder(currentState).metadata(metadataBuilder).routingTable(routingTable).build();
    ) {
    private final ClusterManagerTaskThrottler.ThrottlingKey splitShardTaskKey;
        ClusterState currentState,
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
    /**
        ShardRouting primaryShard = currentState.routingTable()
        splitMetadataBuilder.splitShard(shardId, request.getSplitInto());
        metadataBuilder.put(indexMetadataBuilder);
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        indexMetadataBuilder.splitShardsMetadata(splitMetadataBuilder.build());
            );
     * Applies a shard split request to the given cluster state. Updates the split metadata
import java.util.function.BiFunction;
import org.opensearch.cluster.routing.RoutingTable;
        this.clusterService = clusterService;
            throw new IllegalArgumentException("Index [" + request.getIndex() + "] not found");
     * Submits a cluster state update task to split a shard in-place.
import org.opensearch.cluster.AckedClusterStateUpdateTask;
                        e
        }
        clusterService.submitStateUpdateTask(
            throw new IllegalArgumentException(
        BiFunction<ClusterState, String, ClusterState> rerouteRoutingTable
import org.opensearch.core.action.ActionListener;
    static ClusterState applySplitShardRequest(
import org.opensearch.cluster.service.ClusterService;
        if (currentState.nodes().getMinNodeVersion().equals(currentState.nodes().getMaxNodeVersion()) == false
import org.opensearch.cluster.ClusterState;
    /**
    public MetadataInPlaceSplitShardService(final ClusterService clusterService, final AllocationService allocationService) {
                public ClusterState execute(ClusterState currentState) {
                    + "] on index ["
 *
import org.opensearch.action.admin.indices.split.InPlaceSplitShardClusterStateUpdateRequest;
                @Override
        }
        IndexMetadata curIndexMetadata = currentState.metadata().index(request.getIndex());
            throw new IllegalArgumentException(
 */
                "Cannot split shard [" + shardId + "] on index [" + request.getIndex() + "] because it is currently relocating"
            );
}
    public void split(final InPlaceSplitShardClusterStateUpdateRequest request, final ActionListener<ClusterStateUpdateResponse> listener) {
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("Splitting of shard [" + shardId + "] is already in progress");
        }
        if (primaryShard.started() == false) {
        if (splitShardsMetadata.isSplitParent(shardId)) {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
 * Service responsible for applying in-place shard split requests to cluster state.
import org.apache.logging.log4j.message.ParameterizedMessage;
@ExperimentalApi
 * @opensearch.experimental
                    );
                @Override
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.cluster.metadata;
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
import org.opensearch.cluster.routing.allocation.AllocationService;
            .shardRoutingTable(curIndexMetadata.getIndex().getName(), shardId)
    private final AllocationService allocationService;
                "In-place shard split is not supported on index [" + request.getIndex() + "] with virtual shards enabled"
        int shardId = request.getShardId();
                    + primaryShard.state()
            throw new IllegalArgumentException(
                            request.getShardId(),
                    return applySplitShardRequest(currentState, request, allocationService::reroute);
    private final ClusterService clusterService;
        }
                public void onFailure(String source, Exception e) {
        SplitShardsMetadata splitShardsMetadata = curIndexMetadata.getSplitShardsMetadata();
            throw new IllegalArgumentException(
public class MetadataInPlaceSplitShardService {
        InPlaceSplitShardClusterStateUpdateRequest request,
            new AckedClusterStateUpdateTask<>(Priority.URGENT, request, listener) {
                @Override
        this.allocationService = allocationService;
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(curIndexMetadata);
