    void cancel(String allocationId, String reason) {
            );
    void startSegmentCopy(GetSegmentFilesRequest request, ActionListener<GetSegmentFilesResponse> listener) {
    Map<String, SegmentReplicationSourceHandler> getHandlers() {
 * @opensearch.internal
 * compatible open source license.
        }
    int size() {
        if (handler != null) {
     * Cancel any ongoing replications for a given {@link DiscoveryNode}
    }
     * Start sending files to the replica.
                    Math.toIntExact(recoverySettings.getChunkSize().getBytes()),
 * this file be licensed under the Apache-2.0 license or a
                throw new OpenSearchException(
     *
            .map(SegmentReplicationSourceHandler::getAllocationId)
     */
import org.opensearch.core.index.shard.ShardId;
     */
     * @param recoverySettings {@link RecoverySettings}
import java.util.Collections;
        this.allocationIdToHandlers = ConcurrentCollections.newConcurrentMap();
            } catch (IOException e) {
    OngoingSegmentReplications(IndicesService indicesService, RecoverySettings recoverySettings) {
                final IndexShard indexShard = indexService.getShard(shardId.id());
                    recoverySettings.getMaxConcurrentFileChunks()
     * Remove handlers from allocationIdToHandlers map based on a filter predicate.
 */
     *
import org.opensearch.core.action.ActionListener;
                final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
                    request.getTargetNode(),
                );
        }
    private void cancelHandlers(Predicate<? super SegmentReplicationSourceHandler> predicate, String reason) {
            handler.sendFiles(request, wrappedListener);
                throw new UncheckedIOException("Error creating replication handler", e);
import org.opensearch.index.shard.IndexShard;
        final List<String> allocationIds = allocationIdToHandlers.values()
            }
    void clearOutOfSyncIds(ShardId shardId, Set<String> inSyncAllocationIds) {
                );
        }
        if (handler != null) {
        }
     */
     *
     * @param reason       {@link String} - Reason for the cancel
import java.util.function.Predicate;
 *
    /**
import java.io.UncheckedIOException;
                    "Replication to shard {}, on node {} has already started",
     * @param request  {@link GetSegmentFilesRequest}
    }
     */
    // Visible for tests.
    private static final Logger logger = LogManager.getLogger(OngoingSegmentReplications.class);
    }
     * will internally incref files for copy.
/*
    private final RecoverySettings recoverySettings;
import java.util.Map;
     * @param indicesService   {@link IndicesService}
 *
 * Each replica will have a new {@link SegmentReplicationSourceHandler} created when starting replication.
                    fileChunkWriter,
        });
 */
        );
     * @param allocationId {@link String} - Allocation ID.
    }
import org.opensearch.OpenSearchException;
                    request.getCheckpoint().getShardId(),
import java.util.List;
    /**
     * @param request         {@link CheckpointInfoRequest}
        final SegmentReplicationSourceHandler handler = allocationIdToHandlers.remove(allocationId);
}
                // From the checkpoint's shard ID, fetch the IndexShard
            return;
     */
import org.opensearch.indices.recovery.FileChunkWriter;
    void cancel(IndexShard shard, String reason) {
                    request.getTargetAllocationId(),
import org.opensearch.cluster.node.DiscoveryNode;
     * @param fileChunkWriter {@link FileChunkWriter} writer to handle sending files over the transport layer.
import java.util.stream.Collectors;
    /**
            final ActionListener<GetSegmentFilesResponse> wrappedListener = ActionListener.runBefore(
import java.util.Set;
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            handler.cancel(reason);
    /**
     * Cancel all Replication events for the given allocation ID, intended to be called when a primary is shutting down.
     * @param shardId {@link ShardId}
     * Clear handlers for any allocationIds not in sync.
            listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));
 * The OpenSearch Contributors require contributions made to
        for (String allocationId : allocationIds) {
     * @param node {@link DiscoveryNode} node for which to cancel replication events.
    private final Map<String, SegmentReplicationSourceHandler> allocationIdToHandlers;
    /**
            cancel(allocationId, reason);
                final ShardId shardId = request.getCheckpoint().getShardId();
     * @param reason {@link String} - Reason for the cancel
     *
     *
import org.apache.logging.log4j.message.ParameterizedMessage;
        if (allocationIds.size() == 0) {
    /**
    /**
        this.indicesService = indicesService;
        this.recoverySettings = recoverySettings;
     * @param shard  {@link IndexShard}
class OngoingSegmentReplications {
        final SegmentReplicationSourceHandler handler = allocationIdToHandlers.get(request.getTargetAllocationId());
    }
        return allocationIdToHandlers.size();
     * @param listener {@link ActionListener} that resolves when sending files is complete.
    private final IndicesService indicesService;
     */
    }
/**
import org.opensearch.index.IndexService;
    SegmentReplicationSourceHandler prepareForReplication(CheckpointInfoRequest request, FileChunkWriter fileChunkWriter) {
                return new SegmentReplicationSourceHandler(
                () -> allocationIdToHandlers.remove(request.getTargetAllocationId())
import org.apache.logging.log4j.Logger;
        logger.warn(() -> new ParameterizedMessage("Cancelling replications for allocationIds {}", allocationIds));
            .filter(predicate)
        cancelHandlers(
    void cancelReplication(DiscoveryNode node) {
        cancelHandlers(handler -> handler.getTargetNode().equals(node), "Node left");
 * Manages references to ongoing segrep events on a node.
                    request.getTargetNode()
import org.opensearch.indices.IndicesService;
            (handler) -> handler.shardId().equals(shardId) && inSyncAllocationIds.contains(handler.getAllocationId()) == false,
                    indexShard,
            }
            "Shard is no longer in-sync with the primary"
import org.apache.logging.log4j.LogManager;
                listener,
        } else {
     * Cancel all Replication events for the given shard, intended to be called when a primary is shutting down.
    /**
        cancelHandlers(handler -> handler.shardId().equals(shard.shardId()), reason);
     */
            if (handler.isReplicating()) {
    }
import java.io.IOException;
     * Prepare for a Replication event. This method constructs a {@link SegmentReplicationSourceHandler} that orchestrates segment copy and
     * Constructor.
        return allocationIdToHandlers;
    }
 * SPDX-License-Identifier: Apache-2.0
            .collect(Collectors.toList());
    }
     */
import org.opensearch.indices.recovery.RecoverySettings;
package org.opensearch.indices.replication;
     * @param inSyncAllocationIds {@link List} of in-sync allocation Ids.
            // update the given listener to release the CopyState before it resolves.
     * @return {@link SegmentReplicationSourceHandler} the built CopyState for this replication event.
     *
        return allocationIdToHandlers.computeIfAbsent(request.getTargetAllocationId(), aId -> {
    }
            .stream()
            try {
