        }
                                inSyncAllocationIds.addAll(shardTrackerInSyncIds);
                request.getCheckpoint().getShardId(),
 * compatible open source license.
            transfer.start();
    private final IndicesService indicesService;
import org.opensearch.threadpool.ThreadPool;
                if (indexService.getIndexSettings().isSegRepEnabledOrRemoteNode()) {
        transportService.registerRequestHandler(
                indexShard,
    protected void doStart() {
import org.apache.lucene.store.RateLimiter;
    ) {
        }
            new GetSegmentFilesRequestHandler()
        return new RemoteSegmentFileChunkWriter(
                    request.getTargetNode().getId(),
            UpdateVisibleCheckpointRequest::new,
                recoverySettings.getMergedSegmentReplicationTimeout(),
 * SPDX-License-Identifier: Apache-2.0
                            ongoingSegmentReplications.clearOutOfSyncIds(indexShard.shardId(), inSyncAllocationIds);
                request.getCheckpoint().getShardId(),
 *
                .createTransfer(
import org.opensearch.indices.replication.common.ReplicationTimer;
            indicesService.clusterService().removeListener(this);
            action,
            new CheckpointInfoRequestHandler()
                new ParameterizedMessage(
                recoverySettings::mergedSegmentReplicationRateLimiter
                    () -> 0,
import org.opensearch.transport.TransportChannel;
 */
            ThreadPool.Names.GENERIC,
            shardId,
            && indexShard.indexSettings().isSegRepEnabledOrRemoteNode()
            GetSegmentFilesRequest::new,
     */
        transportService.registerRequestHandler(
    @Override
        IndicesService indicesService,
import org.opensearch.transport.TransportService;
            );
                );
    protected void doStop() {
import org.opensearch.indices.recovery.RetryableTransportClient;
import org.opensearch.cluster.service.ClusterService;
        if (DiscoveryNode.isDataNode(clusterService.getSettings())) {
     * Before a primary shard is closed, cancel any ongoing replications to release incref'd segments.
                indexShard.getRecoverySettings().getMaxConcurrentFileChunks()
            final ShardId shardId = request.getCheckpoint().getShardId();
 * @opensearch.internal
                        @Override
            ongoingSegmentReplications.cancel(indexShard, "shard is closed");
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
            timer.start();
                            final IndexMetadata indexMetadata = indexService.getIndexSettings().getIndexMetadata();
    public static class Actions {
                request.getTargetNode(),
    private class CheckpointInfoRequestHandler implements TransportRequestHandler<CheckpointInfoRequest> {
    public void shardRoutingChanged(IndexShard indexShard, @Nullable ShardRouting oldRouting, ShardRouting newRouting) {
            Actions.GET_CHECKPOINT_INFO,
    private RemoteSegmentFileChunkWriter getRemoteSegmentFileChunkWriter(
 * The OpenSearch Contributors require contributions made to
            new RetryableTransportClient(transportService, request.getTargetNode(), retryTimeout, logger),
                        }
 * Typically, the "source" is a primary shard. This code executes on the source node.
import org.opensearch.index.store.StoreFileMetadata;
import org.opensearch.common.settings.Settings;
                    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.index.shard.ShardId;
                        }
import org.opensearch.core.transport.TransportResponse;
import org.opensearch.index.shard.IndexEventListener;
import org.opensearch.cluster.routing.ShardRouting;
    private class GetSegmentFilesRequestHandler implements TransportRequestHandler<GetSegmentFilesRequest> {
}
                        }
        public static final String GET_MERGED_SEGMENT_FILES = "internal:index/shard/replication/get_merged_segment_files";
            );
import org.apache.logging.log4j.message.ParameterizedMessage;
                SegmentReplicationTargetService.Actions.FILE_CHUNK,
            request.getReplicationId(),
    }
        this.indicesService = indicesService;
public class SegmentReplicationSourceService extends AbstractLifecycleComponent implements ClusterStateListener, IndexEventListener {
/**
                IndexService indexService = indicesService.indexServiceSafe(request.getPrimaryShardId().getIndex());
            }
        );
                new CancellableThreads(),
            timer.stop();
        public static final String GET_CHECKPOINT_INFO = "internal:index/shard/replication/get_checkpoint_info";
                    indexShard.store(),
import org.opensearch.indices.recovery.MultiChunkTransfer;
            if (indexShard.state().equals(IndexShardState.STARTED) == false || indexShard.isPrimaryMode() == false) {
    private final OngoingSegmentReplications ongoingSegmentReplications;
        public void messageReceived(CheckpointInfoRequest request, TransportChannel channel, Task task) throws Exception {
     */
import org.opensearch.common.util.CancellableThreads;
            );
    private class UpdateVisibleCheckpointRequestHandler implements TransportRequestHandler<UpdateVisibleCheckpointRequest> {
        }
        public void messageReceived(GetSegmentFilesRequest request, TransportChannel channel, Task task) throws Exception {
package org.opensearch.indices.replication;
        RecoverySettings recoverySettings
    }
                            listener.onResponse(new GetSegmentFilesResponse(request.getFilesToFetch()));
                    "[replication id {}] Source node sent checkpoint info [{}] to target node [{}], timing: {}",
                throw new IllegalStateException(String.format(Locale.ROOT, "%s is not a started primary shard", shardId));
    }
                request
import org.opensearch.cluster.ClusterChangedEvent;
        @Override
    }
            new GetMergedSegmentFilesRequestHandler()
                    timer.time()
                    }
    protected SegmentReplicationSourceService(
            );
            }
        );
                            listener.onFailure(e);
import java.util.concurrent.atomic.AtomicLong;
                            }
    }
        public static final String UPDATE_VISIBLE_CHECKPOINT = "internal:index/shard/replication/update_visible_checkpoint";
                )
    }
        if (event.nodesRemoved()) {
                            );
                recoverySettings::replicationRateLimiter
            ongoingSegmentReplications.cancel(indexShard.routingEntry().allocationId().getId(), "Relocating primary shard.");
                            if (indexShard.isPrimaryMode()) {
        if (DiscoveryNode.isDataNode(clusterService.getSettings())) {
     * Cancels any replications on this node to a replica that has been promoted as primary.
    public void clusterChanged(ClusterChangedEvent event) {
     * @opensearch.internal
import java.util.Set;
        }
        }
        if (indexShard != null
    @Override
                        public void onFailure(Exception e) {
    }
        SegmentReplicationTransportRequest request,
            RemoteSegmentFileChunkWriter mergedSegmentFileChunkWriter = getRemoteSegmentFileChunkWriter(
                                final Set<String> shardTrackerInSyncIds = indexShard.getReplicationGroup().getInSyncAllocationIds();
import org.opensearch.tasks.Task;
        }
            GetSegmentFilesRequest::new,
                IndexShard indexShard = indexService.getShard(request.getPrimaryShardId().id());
        TransportService transportService,
        // we need to ensure its state has cleared up in ongoing replications.
        public void messageReceived(UpdateVisibleCheckpointRequest request, TransportChannel channel, Task task) throws Exception {
            logger.trace(
        );
        );
            ThreadPool.Names.GENERIC,
                request,
import org.opensearch.cluster.metadata.IndexMetadata;
                channel,
    }
                                indexMetadata.inSyncAllocationIds(indexShard.shardId().id())
            Actions.GET_SEGMENT_FILES,
            Actions.GET_MERGED_SEGMENT_FILES,
import org.opensearch.cluster.ClusterStateListener;
    @Override
    }
        }
            );
                Math.toIntExact(indexShard.getRecoverySettings().getChunkSize().getBytes()),
 * Service class that handles segment replication requests from replica shards.
 *
                        public void onResponse(Void unused) {
            IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
            for (IndexService indexService : indicesService) {
            && oldRouting.primary() == false
    }
            }
import java.util.HashSet;
    /**
    @Override
import org.opensearch.indices.replication.common.SegmentReplicationTransportRequest;
                            final Set<String> inSyncAllocationIds = new HashSet<>(
                ongoingSegmentReplications.cancelReplication(removedNode);
                    handler.getCheckpoint(),
import org.opensearch.indices.recovery.RecoverySettings;
    private class GetMergedSegmentFilesRequestHandler implements TransportRequestHandler<GetSegmentFilesRequest> {
        Supplier<RateLimiter> rateLimiterSupplier
        if (event.routingTableChanged()) {
        @Override
import java.util.Locale;
                    request.getCheckpoint().getMetadataMap().values().toArray(new StoreFileMetadata[0]),
            IndexShard indexShard = indexService.getShard(shardId.id());
import org.opensearch.index.IndexService;
            final RemoteSegmentFileChunkWriter segmentSegmentFileChunkWriter = getRemoteSegmentFileChunkWriter(
        final ClusterService clusterService = indicesService.clusterService();
import java.io.IOException;
            recoverySettings,
     *
     * Internal actions used by the segment replication source service on the primary shard
    ) {
        TransportService transportService,
                request,
    /**
            final SegmentReplicationSourceHandler handler = ongoingSegmentReplications.prepareForReplication(
    @Override
            } catch (Exception e) {
    private final TransportService transportService;
                Actions.GET_MERGED_SEGMENT_FILES,
    private static final Logger logger = LogManager.getLogger(SegmentReplicationSourceService.class);
        IndicesService indicesService,
        @Override
            CheckpointInfoRequest::new,
            for (DiscoveryNode removedNode : event.nodesDelta().removedNodes()) {
                        if (indexShard.routingEntry().primary()) {
            final ReplicationTimer timer = new ReplicationTimer();
            && newRouting.primary()) {
            );
                logger,
        this.recoverySettings = recoverySettings;
import org.opensearch.index.shard.IndexShardState;
        TimeValue retryTimeout,
            new UpdateVisibleCheckpointRequestHandler()
                mergedSegmentFileChunkWriter,
    protected void doClose() throws IOException {
            SegmentFileTransferHandler mergedSegmentFileTransferHandler = new SegmentFileTransferHandler(
            }
                request,
import org.opensearch.core.action.ActionListener;
        ShardId shardId,
    public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
        // if a replica for one of the primary shards on this node has closed,
    private final RecoverySettings recoverySettings;
     *
    }
        if (indexShard != null && indexShard.indexSettings().isSegRepEnabledOrRemoteNode()) {
                    request.getReplicationId(),
                recoverySettings.internalActionRetryTimeout(),
            ThreadPool.Names.GENERIC,
    }
                channel.sendResponse(e);
import org.opensearch.cluster.node.DiscoveryNode;
 */
            (throttleTime) -> {},
import org.opensearch.transport.TransportRequestHandler;
            try {
        public static final String GET_SEGMENT_FILES = "internal:index/shard/replication/get_segment_files";
        this.ongoingSegmentReplications = ongoingSegmentReplications;
import org.opensearch.index.shard.IndexShard;
            Actions.UPDATE_VISIBLE_CHECKPOINT,
        @Override
import org.opensearch.common.Nullable;
     */
        RecoverySettings recoverySettings,
        }
            clusterService.addListener(this);
        );
import org.apache.logging.log4j.LogManager;
import org.opensearch.indices.IndicesService;
                    for (IndexShard indexShard : indexService) {
                segmentSegmentFileChunkWriter
                indexShard.getThreadPool(),
        transportService.registerRequestHandler(
            ActionListener<GetSegmentFilesResponse> listener = new ChannelActionListener<>(
    public SegmentReplicationSourceService(
            new AtomicLong(0),
                SegmentReplicationTargetService.Actions.MERGED_SEGMENT_FILE_CHUNK,
                indexShard.updateVisibleCheckpointForShard(request.getTargetAllocationId(), request.getCheckpoint());
        public void messageReceived(GetSegmentFilesRequest request, TransportChannel channel, Task task) throws Exception {
import java.util.function.Supplier;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.action.support.ChannelActionListener;
            ongoingSegmentReplications.startSegmentCopy(request, new ChannelActionListener<>(channel, Actions.GET_SEGMENT_FILES, request));
        String action,
    }
                    new ActionListener<>() {
            final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = mergedSegmentFileTransferHandler
        this(indicesService, transportService, recoverySettings, new OngoingSegmentReplications(indicesService, recoverySettings));
            rateLimiterSupplier
        this.transportService = transportService;
import org.apache.logging.log4j.Logger;
        }
                        @Override
        OngoingSegmentReplications ongoingSegmentReplications
        final ClusterService clusterService = indicesService.clusterService();
        transportService.registerRequestHandler(
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
        }
    /**
            ThreadPool.Names.GENERIC,
/*
    @Override
            channel.sendResponse(new CheckpointInfoResponse(handler.getCheckpoint(), handler.getInfosBytes()));
    ) {
                }
    }
