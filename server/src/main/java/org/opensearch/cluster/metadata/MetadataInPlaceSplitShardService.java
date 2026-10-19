}
        }
import org.opensearch.cluster.routing.ShardRouting;
    private final AllocationService allocationService;
        SplitShardsMetadata.Builder splitMetadataBuilder = new SplitShardsMetadata.Builder(splitShardsMetadata);
                    return new ClusterStateUpdateResponse(acknowledged);
    /**
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                            request.getShardId(),
    private final ClusterManagerTaskThrottler.ThrottlingKey splitShardTaskKey;
                }  
                public ClusterState execute(ClusterState currentState) {
        }
                        ),  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());  
                    );
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {  
        this.clusterService = clusterService;
        if (splitShardsMetadata.isSplitParent(shardId)) {
 */
            throw new IllegalArgumentException("Splitting of shard [" + shardId + "] is already in progress");
        }  
        int shardId = request.getShardId();  
    }
    public MetadataInPlaceSplitShardService(final ClusterService clusterService, final AllocationService allocationService) {
                "Cannot split shard ["  
            .shardRoutingTable(curIndexMetadata.getIndex().getName(), shardId)  
import org.apache.logging.log4j.Logger;
    static ClusterState applySplitShardRequest(
    ) {
     * in the index metadata and triggers a reroute so that child shards get allocated.
        if (curIndexMetadata.getNumberOfVirtualShards() != -1) {
import org.opensearch.cluster.AckedClusterStateUpdateTask;  
            throw new IllegalArgumentException(
        ClusterState currentState,
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.admin.indices.split.InPlaceSplitShardClusterStateUpdateRequest;
        if (splitShardsMetadata.getInProgressSplitShardIds().contains(shardId)) {  
        BiFunction<ClusterState, String, ClusterState> rerouteRoutingTable
                }
    private static final Logger logger = LogManager.getLogger(MetadataInPlaceSplitShardService.class);
    public void split(final InPlaceSplitShardClusterStateUpdateRequest request, final ActionListener<ClusterStateUpdateResponse> listener) {
                    return splitShardTaskKey;  
                "In-place shard split requires all nodes to be on the same version, at or above " + Version.V_3_7_0
            );  
import org.opensearch.Version;
        splitMetadataBuilder.splitShard(shardId, request.getSplitInto());
    }
@ExperimentalApi
        InPlaceSplitShardClusterStateUpdateRequest request,  
        indexMetadataBuilder.splitShardsMetadata(splitMetadataBuilder.build());  
        if (primaryShard.started() == false) {
import org.opensearch.cluster.service.ClusterManagerTask;  
import org.opensearch.cluster.ClusterState;
                        e
            }
public class MetadataInPlaceSplitShardService {  
            "in-place-split-shard [" + request.getShardId() + "] of index [" + request.getIndex() + "], cause [" + request.cause() + "]",  
                    super.onFailure(source, e);  
package org.opensearch.cluster.metadata;
                "Cannot split shard [" + shardId + "] on index [" + request.getIndex() + "] because it is currently relocating"
        RoutingTable routingTable = routingTableBuilder.build();
        SplitShardsMetadata splitShardsMetadata = curIndexMetadata.getSplitShardsMetadata();
                @Override
            .primaryShard();
     */  
 * compatible open source license.
        clusterService.submitStateUpdateTask(
            throw new IllegalArgumentException(
                            request.getIndex()
                }
                        () -> new ParameterizedMessage(
 * SPDX-License-Identifier: Apache-2.0
                    + primaryShard.state()
 * Service responsible for applying in-place shard split requests to cluster state.
            new AckedClusterStateUpdateTask<>(Priority.URGENT, request, listener) {
                            "[{}] of index [{}] failed to split online",  
    /**  
                    logger.trace(
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(curIndexMetadata);
        }  
                    + "] on index ["
 * The OpenSearch Contributors require contributions made to  
                    + shardId
            );
                    + "] because the primary shard is not started, current state: "
        ClusterState updatedState = ClusterState.builder(currentState).metadata(metadataBuilder).routingTable(routingTable).build();
/**  
            throw new IllegalArgumentException("Shard [" + shardId + "] has already been split.");
 */  
            throw new IllegalArgumentException(  
                @Override
import org.opensearch.common.annotation.ExperimentalApi;
import java.util.function.BiFunction;
        }  
            );
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
                    return applySplitShardRequest(currentState, request, allocationService::reroute);
                    + request.getIndex()  
import org.opensearch.cluster.routing.allocation.AllocationService;
        if (primaryShard.relocating()) {
        return rerouteRoutingTable.apply(updatedState, "shard [" + shardId + "] of index [" + request.getIndex() + "] split");  
     * Applies a shard split request to the given cluster state. Updates the split metadata
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
 * @opensearch.experimental  
            throw new IllegalArgumentException(  
    private final ClusterService clusterService;  
import org.opensearch.cluster.service.ClusterService;
        );  
        IndexMetadata curIndexMetadata = currentState.metadata().index(request.getIndex());  
        metadataBuilder.put(indexMetadataBuilder);  
                public void onFailure(String source, Exception e) {  
 * this file be licensed under the Apache-2.0 license or a
/*  
        this.splitShardTaskKey = clusterService.registerClusterManagerTask(ClusterManagerTask.IN_PLACE_SPLIT_SHARD, true);
            || currentState.nodes().getMinNodeVersion().before(Version.V_3_7_0)) {  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                @Override
            throw new IllegalArgumentException("Index [" + request.getIndex() + "] not found");
import org.apache.logging.log4j.LogManager;
 *
                @Override  
 *
        }  
            );  
        ShardRouting primaryShard = currentState.routingTable()
     */  
                "In-place shard split is not supported on index [" + request.getIndex() + "] with virtual shards enabled"
        if (currentState.nodes().getMinNodeVersion().equals(currentState.nodes().getMaxNodeVersion()) == false
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        this.allocationService = allocationService;  
import org.opensearch.cluster.routing.RoutingTable;  
import org.opensearch.common.Priority;  
        }
    }
     * Submits a cluster state update task to split a shard in-place.
        if (curIndexMetadata == null) {
                }
