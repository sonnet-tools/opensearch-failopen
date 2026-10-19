/**  
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
     */
        final SegmentReplicationSourceHandler handler = allocationIdToHandlers.remove(allocationId);
    }
 *
import org.apache.logging.log4j.message.ParameterizedMessage;  
            try {
     * @param request  {@link GetSegmentFilesRequest}
    int size() {
                );
                throw new OpenSearchException(
 *  
     *  
 * this file be licensed under the Apache-2.0 license or a
    // Visible for tests.  
                    request.getCheckpoint().getShardId(),
                final IndexShard indexShard = indexService.getShard(shardId.id());  
    }
     * @param indicesService   {@link IndicesService}
        cancelHandlers(handler -> handler.shardId().equals(shard.shardId()), reason);
        final SegmentReplicationSourceHandler handler = allocationIdToHandlers.get(request.getTargetAllocationId());
    /**
     */  
    void cancel(IndexShard shard, String reason) {  
        if (handler != null) {  
class OngoingSegmentReplications {  
     *
            cancel(allocationId, reason);
            .collect(Collectors.toList());
     * @param shardId {@link ShardId}
    SegmentReplicationSourceHandler prepareForReplication(CheckpointInfoRequest request, FileChunkWriter fileChunkWriter) {  
    private void cancelHandlers(Predicate<? super SegmentReplicationSourceHandler> predicate, String reason) {
            }
import org.opensearch.indices.recovery.FileChunkWriter;  
 * Each replica will have a new {@link SegmentReplicationSourceHandler} created when starting replication.
     * @param allocationId {@link String} - Allocation ID.
        );
     *  
import org.opensearch.OpenSearchException;
        } else {
import org.apache.logging.log4j.LogManager;
            "Shard is no longer in-sync with the primary"
        final List<String> allocationIds = allocationIdToHandlers.values()  
     * @param shard  {@link IndexShard}  
     * Cancel all Replication events for the given allocation ID, intended to be called when a primary is shutting down.
        this.recoverySettings = recoverySettings;  
    }
 * The OpenSearch Contributors require contributions made to  
                listener,
     */
        return allocationIdToHandlers.size();  
     * @param fileChunkWriter {@link FileChunkWriter} writer to handle sending files over the transport layer.  
    OngoingSegmentReplications(IndicesService indicesService, RecoverySettings recoverySettings) {
 * compatible open source license.
                    fileChunkWriter,  
 * SPDX-License-Identifier: Apache-2.0
import java.util.stream.Collectors;
     * Constructor.
     * @param reason {@link String} - Reason for the cancel
import java.util.Map;
import org.opensearch.indices.recovery.RecoverySettings;
     * @param node {@link DiscoveryNode} node for which to cancel replication events.
        }
import java.util.function.Predicate;  
 */  
            // update the given listener to release the CopyState before it resolves.
import org.opensearch.core.index.shard.ShardId;
        }
                );  
                    request.getTargetNode()
            handler.sendFiles(request, wrappedListener);
    /**
            );  
    void clearOutOfSyncIds(ShardId shardId, Set<String> inSyncAllocationIds) {
     *
     * Clear handlers for any allocationIds not in sync.  
                () -> allocationIdToHandlers.remove(request.getTargetAllocationId())
     * Cancel all Replication events for the given shard, intended to be called when a primary is shutting down.
        cancelHandlers(handler -> handler.getTargetNode().equals(node), "Node left");
                return new SegmentReplicationSourceHandler(
import org.apache.logging.log4j.Logger;
    /**
        return allocationIdToHandlers.computeIfAbsent(request.getTargetAllocationId(), aId -> {
    private final Map<String, SegmentReplicationSourceHandler> allocationIdToHandlers;
            .stream()
    }
import java.util.Collections;
    }  
        logger.warn(() -> new ParameterizedMessage("Cancelling replications for allocationIds {}", allocationIds));
            .filter(predicate)
        for (String allocationId : allocationIds) {  
     */  
        if (allocationIds.size() == 0) {
            .map(SegmentReplicationSourceHandler::getAllocationId)  
     * @param listener {@link ActionListener} that resolves when sending files is complete.
    /**
     * @param recoverySettings {@link RecoverySettings}
            if (handler.isReplicating()) {
                final ShardId shardId = request.getCheckpoint().getShardId();
        this.indicesService = indicesService;
 * @opensearch.internal
        cancelHandlers(
    }
            } catch (IOException e) {  
import java.util.List;  
    /**
                    "Replication to shard {}, on node {} has already started",  
     * @param inSyncAllocationIds {@link List} of in-sync allocation Ids.
    }  
     * @param reason       {@link String} - Reason for the cancel
            return;  
                final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
                    indexShard,
import org.opensearch.index.shard.IndexShard;
        this.allocationIdToHandlers = ConcurrentCollections.newConcurrentMap();
    void cancelReplication(DiscoveryNode node) {
        if (handler != null) {  
import java.io.IOException;  
                    request.getTargetNode(),
 * Manages references to ongoing segrep events on a node.
import org.opensearch.index.IndexService;  
}
 */
import org.opensearch.cluster.node.DiscoveryNode;
    private final IndicesService indicesService;
import org.opensearch.indices.IndicesService;
     */  
     * @return {@link SegmentReplicationSourceHandler} the built CopyState for this replication event.
    }  
                    recoverySettings.getMaxConcurrentFileChunks()
     */
            }
    }  
    /**  
/*  
     */  
        });  
    Map<String, SegmentReplicationSourceHandler> getHandlers() {
    private static final Logger logger = LogManager.getLogger(OngoingSegmentReplications.class);
import org.opensearch.core.action.ActionListener;
     * will internally incref files for copy.  
                throw new UncheckedIOException("Error creating replication handler", e);
        }
     * Remove handlers from allocationIdToHandlers map based on a filter predicate.  
                    Math.toIntExact(recoverySettings.getChunkSize().getBytes()),  
     * Start sending files to the replica.
import java.util.Set;
            final ActionListener<GetSegmentFilesResponse> wrappedListener = ActionListener.runBefore(  
    /**
     * Prepare for a Replication event. This method constructs a {@link SegmentReplicationSourceHandler} that orchestrates segment copy and
                // From the checkpoint's shard ID, fetch the IndexShard  
        }
            (handler) -> handler.shardId().equals(shardId) && inSyncAllocationIds.contains(handler.getAllocationId()) == false,  
import java.io.UncheckedIOException;
            handler.cancel(reason);
                    request.getTargetAllocationId(),
     */  
     *  
     *
     * @param request         {@link CheckpointInfoRequest}
     * Cancel any ongoing replications for a given {@link DiscoveryNode}  
    void cancel(String allocationId, String reason) {
    void startSegmentCopy(GetSegmentFilesRequest request, ActionListener<GetSegmentFilesResponse> listener) {
            listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));  
    private final RecoverySettings recoverySettings;  
        return allocationIdToHandlers;
    }  
package org.opensearch.indices.replication;
    /**
