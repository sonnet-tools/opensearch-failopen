                        if (indexShard.routingEntry().primary()) {
            channel.sendResponse(new CheckpointInfoResponse(handler.getCheckpoint(), handler.getInfosBytes()));  
                            listener.onResponse(new GetSegmentFilesResponse(request.getFilesToFetch()));
import org.opensearch.cluster.service.ClusterService;
    private RemoteSegmentFileChunkWriter getRemoteSegmentFileChunkWriter(  
    private final RecoverySettings recoverySettings;
            new GetSegmentFilesRequestHandler()
            final ReplicationTimer timer = new ReplicationTimer();
            final SegmentReplicationSourceHandler handler = ongoingSegmentReplications.prepareForReplication(
                );
                    "[replication id {}] Source node sent checkpoint info [{}] to target node [{}], timing: {}",
                    request.getCheckpoint().getMetadataMap().values().toArray(new StoreFileMetadata[0]),  
    }
            }
            timer.stop();
        }  
import org.opensearch.cluster.ClusterStateListener;
import org.opensearch.common.unit.TimeValue;  
        final ClusterService clusterService = indicesService.clusterService();
                mergedSegmentFileChunkWriter,
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
            final ShardId shardId = request.getCheckpoint().getShardId();
 * @opensearch.internal  
                                inSyncAllocationIds.addAll(shardTrackerInSyncIds);  
        if (DiscoveryNode.isDataNode(clusterService.getSettings())) {  
        }  
            ThreadPool.Names.GENERIC,  
                    () -> 0,
                request,
                    }  
                SegmentReplicationTargetService.Actions.FILE_CHUNK,
                )  
 *
            }  
import org.opensearch.index.shard.IndexShard;
    @Override
                indexShard.getThreadPool(),  
            logger.trace(
                SegmentReplicationTargetService.Actions.MERGED_SEGMENT_FILE_CHUNK,  
            );  
            );
                            final Set<String> inSyncAllocationIds = new HashSet<>(
            IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
        if (DiscoveryNode.isDataNode(clusterService.getSettings())) {
        String action,
                }
        TransportService transportService,
            SegmentFileTransferHandler mergedSegmentFileTransferHandler = new SegmentFileTransferHandler(
            && oldRouting.primary() == false
import org.opensearch.index.shard.IndexShardState;
        final ClusterService clusterService = indicesService.clusterService();  
import org.opensearch.indices.recovery.RecoverySettings;  
                indexShard.updateVisibleCheckpointForShard(request.getTargetAllocationId(), request.getCheckpoint());  
            ongoingSegmentReplications.cancel(indexShard.routingEntry().allocationId().getId(), "Relocating primary shard.");  
    public SegmentReplicationSourceService(  
    ) {
        );  
                                final Set<String> shardTrackerInSyncIds = indexShard.getReplicationGroup().getInSyncAllocationIds();
            );
     */
                new ParameterizedMessage(  
                    indexShard.store(),
            action,  
        @Override
import java.util.Locale;  
 */
        }
     * @opensearch.internal  
            ongoingSegmentReplications.startSegmentCopy(request, new ChannelActionListener<>(channel, Actions.GET_SEGMENT_FILES, request));
        if (event.routingTableChanged()) {
                request,  
                            ongoingSegmentReplications.clearOutOfSyncIds(indexShard.shardId(), inSyncAllocationIds);
 *
    private final TransportService transportService;  
            && indexShard.indexSettings().isSegRepEnabledOrRemoteNode()  
    }  
            for (IndexService indexService : indicesService) {
    /**
                    request.getTargetNode().getId(),
            RemoteSegmentFileChunkWriter mergedSegmentFileChunkWriter = getRemoteSegmentFileChunkWriter(
        transportService.registerRequestHandler(
        public void messageReceived(GetSegmentFilesRequest request, TransportChannel channel, Task task) throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    public void clusterChanged(ClusterChangedEvent event) {
        if (indexShard != null
                Math.toIntExact(indexShard.getRecoverySettings().getChunkSize().getBytes()),
}
                    handler.getCheckpoint(),  
     * Before a primary shard is closed, cancel any ongoing replications to release incref'd segments.  
                ongoingSegmentReplications.cancelReplication(removedNode);
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.cluster.node.DiscoveryNode;  
        TransportService transportService,
                    }
            final RemoteSegmentFileChunkWriter segmentSegmentFileChunkWriter = getRemoteSegmentFileChunkWriter(
        }
    @Override
            clusterService.addListener(this);
    }
public class SegmentReplicationSourceService extends AbstractLifecycleComponent implements ClusterStateListener, IndexEventListener {
     *
import org.opensearch.core.action.ActionListener;
import org.apache.logging.log4j.Logger;
    ) {  
                request.getTargetNode(),  
                        }  
                                indexMetadata.inSyncAllocationIds(indexShard.shardId().id())
        @Override  
import org.opensearch.common.util.CancellableThreads;
            final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = mergedSegmentFileTransferHandler  
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
            } catch (Exception e) {
    private static final Logger logger = LogManager.getLogger(SegmentReplicationSourceService.class);
    private class UpdateVisibleCheckpointRequestHandler implements TransportRequestHandler<UpdateVisibleCheckpointRequest> {  
        if (event.nodesRemoved()) {  
            recoverySettings,  
            rateLimiterSupplier  
        IndicesService indicesService,
import org.opensearch.index.store.StoreFileMetadata;  
            try {  
        public static final String GET_CHECKPOINT_INFO = "internal:index/shard/replication/get_checkpoint_info";
                channel,  
        public void messageReceived(GetSegmentFilesRequest request, TransportChannel channel, Task task) throws Exception {
import org.opensearch.transport.TransportService;
 * The OpenSearch Contributors require contributions made to  
            if (indexShard.state().equals(IndexShardState.STARTED) == false || indexShard.isPrimaryMode() == false) {
                IndexService indexService = indicesService.indexServiceSafe(request.getPrimaryShardId().getIndex());
                channel.sendResponse(e);  
    }  
        ShardId shardId,  
        this.indicesService = indicesService;
import java.util.Set;
            new RetryableTransportClient(transportService, request.getTargetNode(), retryTimeout, logger),
    /**  
        );  
    private class GetSegmentFilesRequestHandler implements TransportRequestHandler<GetSegmentFilesRequest> {
            new AtomicLong(0),
        RecoverySettings recoverySettings  
import org.opensearch.action.support.ChannelActionListener;
        );  
            new CheckpointInfoRequestHandler()
import org.opensearch.transport.TransportRequestHandler;
    private final OngoingSegmentReplications ongoingSegmentReplications;
     */
                indexShard.getRecoverySettings().getMaxConcurrentFileChunks()  
        }  
    }
    public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {  
 */  
            ongoingSegmentReplications.cancel(indexShard, "shard is closed");
            indicesService.clusterService().removeListener(this);
        transportService.registerRequestHandler(
import org.opensearch.common.Nullable;  
            timer.start();  
import org.opensearch.threadpool.ThreadPool;
import org.apache.logging.log4j.LogManager;
            UpdateVisibleCheckpointRequest::new,
    }
                new CancellableThreads(),
        this.ongoingSegmentReplications = ongoingSegmentReplications;  
                            listener.onFailure(e);
                request.getCheckpoint().getShardId(),
            Actions.UPDATE_VISIBLE_CHECKPOINT,
        TimeValue retryTimeout,
package org.opensearch.indices.replication;
        RecoverySettings recoverySettings,  
                            );  
    ) {
            request.getReplicationId(),
                recoverySettings.internalActionRetryTimeout(),
        public static final String GET_MERGED_SEGMENT_FILES = "internal:index/shard/replication/get_merged_segment_files";
                        }
            IndexShard indexShard = indexService.getShard(shardId.id());  
                        public void onResponse(Void unused) {
        }
import org.opensearch.indices.replication.common.ReplicationTimer;
                recoverySettings::replicationRateLimiter  
                logger,
        OngoingSegmentReplications ongoingSegmentReplications
import org.opensearch.indices.replication.common.SegmentReplicationTransportRequest;  
                request.getCheckpoint().getShardId(),
        }
import java.util.concurrent.atomic.AtomicLong;
    private class GetMergedSegmentFilesRequestHandler implements TransportRequestHandler<GetSegmentFilesRequest> {
    private final IndicesService indicesService;
            Actions.GET_MERGED_SEGMENT_FILES,
        this.recoverySettings = recoverySettings;
    @Override
            CheckpointInfoRequest::new,
                Actions.GET_MERGED_SEGMENT_FILES,
import java.util.function.Supplier;  
            }  
                throw new IllegalStateException(String.format(Locale.ROOT, "%s is not a started primary shard", shardId));
    protected void doClose() throws IOException {  
            Actions.GET_CHECKPOINT_INFO,
import org.opensearch.common.settings.Settings;
        this(indicesService, transportService, recoverySettings, new OngoingSegmentReplications(indicesService, recoverySettings));
        public void messageReceived(CheckpointInfoRequest request, TransportChannel channel, Task task) throws Exception {
import org.opensearch.core.index.shard.ShardId;  
                recoverySettings.getMergedSegmentReplicationTimeout(),  
import org.opensearch.cluster.ClusterChangedEvent;  
import org.apache.logging.log4j.message.ParameterizedMessage;  
import java.util.HashSet;
                IndexShard indexShard = indexService.getShard(request.getPrimaryShardId().id());
        }
            ThreadPool.Names.GENERIC,  
                        public void onFailure(Exception e) {  
    /**  
            );
                            if (indexShard.isPrimaryMode()) {
        SegmentReplicationTransportRequest request,
        this.transportService = transportService;  
/**
        }  
            new GetMergedSegmentFilesRequestHandler()
            }  
    }
        @Override  
    public void shardRoutingChanged(IndexShard indexShard, @Nullable ShardRouting oldRouting, ShardRouting newRouting) {
            for (DiscoveryNode removedNode : event.nodesDelta().removedNodes()) {
 * compatible open source license.
        transportService.registerRequestHandler(
    protected SegmentReplicationSourceService(  
import org.opensearch.index.shard.IndexEventListener;  
    protected void doStop() {
import java.io.IOException;
        return new RemoteSegmentFileChunkWriter(
import org.opensearch.transport.TransportChannel;  
        public static final String GET_SEGMENT_FILES = "internal:index/shard/replication/get_segment_files";
        // we need to ensure its state has cleared up in ongoing replications.  
            shardId,
        }
     *
            ActionListener<GetSegmentFilesResponse> listener = new ChannelActionListener<>(
            );
    private class CheckpointInfoRequestHandler implements TransportRequestHandler<CheckpointInfoRequest> {
                        @Override
        @Override  
            );
import org.opensearch.core.transport.TransportResponse;
                recoverySettings::mergedSegmentReplicationRateLimiter
    protected void doStart() {
                if (indexService.getIndexSettings().isSegRepEnabledOrRemoteNode()) {  
                            final IndexMetadata indexMetadata = indexService.getIndexSettings().getIndexMetadata();  
            GetSegmentFilesRequest::new,
                    timer.time()
     * Cancels any replications on this node to a replica that has been promoted as primary.
     * Internal actions used by the segment replication source service on the primary shard
                            }
        Supplier<RateLimiter> rateLimiterSupplier
 * Service class that handles segment replication requests from replica shards.  
 * Typically, the "source" is a primary shard. This code executes on the source node.
            ThreadPool.Names.GENERIC,  
                request,  
    @Override  
import org.opensearch.indices.recovery.RetryableTransportClient;
        // if a replica for one of the primary shards on this node has closed,
import org.opensearch.tasks.Task;
                request
    }
                    request.getReplicationId(),
        if (indexShard != null && indexShard.indexSettings().isSegRepEnabledOrRemoteNode()) {
        public void messageReceived(UpdateVisibleCheckpointRequest request, TransportChannel channel, Task task) throws Exception {
            GetSegmentFilesRequest::new,
                indexShard,
import org.opensearch.cluster.routing.ShardRouting;
    }
import org.opensearch.indices.recovery.MultiChunkTransfer;
    }
    }
            transfer.start();
                    new ActionListener<>() {
        IndicesService indicesService,
    public static class Actions {
                segmentSegmentFileChunkWriter
            new UpdateVisibleCheckpointRequestHandler()
        transportService.registerRequestHandler(
    }
                        }  
    }  
import org.apache.lucene.store.RateLimiter;
                        @Override  
     */
            (throttleTime) -> {},
            ThreadPool.Names.GENERIC,  
import org.opensearch.index.IndexService;
                .createTransfer(
        );  
            && newRouting.primary()) {
                    for (IndexShard indexShard : indexService) {
            Actions.GET_SEGMENT_FILES,
        );
import org.opensearch.indices.IndicesService;
    @Override  
    }  
        public static final String UPDATE_VISIBLE_CHECKPOINT = "internal:index/shard/replication/update_visible_checkpoint";  
    @Override
