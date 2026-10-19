        long replicationId,
        IndexShard indexShard,
        // MultiFileWriter takes care of progress tracking for downloads in this scenario
            filesToFetch,
        );
import org.opensearch.action.ActionListenerResponseHandler;
        DiscoveryNode targetNode,
            request,  
import static org.opensearch.indices.replication.SegmentReplicationSourceService.Actions.GET_CHECKPOINT_INFO;  
        final GetSegmentFilesRequest request = new GetSegmentFilesRequest(
import static org.opensearch.indices.replication.SegmentReplicationSourceService.Actions.GET_MERGED_SEGMENT_FILES;
        transportService.sendRequest(
        BiConsumer<String, Long> fileProgressTracker,  
import java.util.List;  
 */  
    private final RecoverySettings recoverySettings;
                checkpoint.getSegmentsGen(),
        this.sourceNode = sourceNode;  
    @Override
 *
        TransportService transportService,
        return sourceNode.getName();
    public PrimaryShardReplicationSource(
            new ActionListenerResponseHandler<>(listener, GetSegmentFilesResponse::new, ThreadPool.Names.GENERIC)
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.indices.recovery.RecoverySettings;  
    public String getDescription() {  
        );  
                checkpoint.getLength(),  
            TransportRequestOptions.builder().withTimeout(recoverySettings.internalActionRetryTimeout()).build(),
        DiscoveryNode sourceNode  
    private final DiscoveryNode sourceNode;
        this.transportService = transportService;
            TransportRequestOptions.builder().withTimeout(recoverySettings.internalActionLongTimeout()).build(),  
public class PrimaryShardReplicationSource implements SegmentReplicationSource {
    }  
 * @opensearch.internal
import org.opensearch.index.shard.IndexShard;
                checkpoint.getPrimaryTerm(),  
        String targetAllocationId,  
package org.opensearch.indices.replication;
    @Override
    @Override
}  
        IndexShard indexShard,
                checkpoint.getSegmentInfosVersion(),
/**
    ) {
    private final TransportService transportService;  
import org.opensearch.transport.TransportService;
 */  
                checkpoint.getShardId(),
            new ActionListenerResponseHandler<>(listener, CheckpointInfoResponse::new, ThreadPool.Names.GENERIC)
    public void getCheckpointMetadata(  
import org.opensearch.transport.TransportRequestOptions;  
        ReplicationCheckpoint checkpoint,
            sourceNode,  
            sourceNode,
    }  
import org.opensearch.core.action.ActionListener;  
 * this file be licensed under the Apache-2.0 license or a
    }  
        final GetSegmentFilesRequest request = new GetSegmentFilesRequest(
            )  
            checkpoint  
        this.targetNode = targetNode;
    }
        RecoverySettings recoverySettings,
        this.recoverySettings = recoverySettings;
    private final String targetAllocationId;
 * SPDX-License-Identifier: Apache-2.0
    @Override  
            targetAllocationId,
            new ActionListenerResponseHandler<>(listener, GetSegmentFilesResponse::new, ThreadPool.Names.GENERIC)
    public void getSegmentFiles(
        BiConsumer<String, Long> fileProgressTracker,
        this.targetAllocationId = targetAllocationId;
    ) {
        ActionListener<GetSegmentFilesResponse> listener
        // TODO: Move state management and tracking into replication methods and use chunking and data
import static org.opensearch.indices.replication.SegmentReplicationSourceService.Actions.GET_SEGMENT_FILES;
/*  
            sourceNode,  
        ActionListener<GetSegmentFilesResponse> listener  
            GET_SEGMENT_FILES,
            replicationId,  
 * Implementation of a {@link SegmentReplicationSource} where the source is a primary node.
            replicationId,
        long replicationId,
        );
            targetNode,
        assert targetNode != null : "Target node must be set";
        ReplicationCheckpoint checkpoint,
import org.opensearch.cluster.node.DiscoveryNode;
    ) {
    private final DiscoveryNode targetNode;  
                checkpoint.getMetadataMap()
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
import org.opensearch.index.store.StoreFileMetadata;
        final CheckpointInfoRequest request = new CheckpointInfoRequest(replicationId, targetAllocationId, targetNode, checkpoint);
        long replicationId,
        transportService.sendRequest(
 * This code executes on the target node.  
    ) {
            request,
            GET_CHECKPOINT_INFO,
        );
            targetAllocationId,  
        transportService.sendRequest(  
        // fileProgressTracker is a no-op for node to node recovery  
 *
import java.util.function.BiConsumer;
        );
            GET_MERGED_SEGMENT_FILES,
    public void getMergedSegmentFiles(  
        // copy mechanisms only from MultiFileWriter  
            new ReplicationCheckpoint(
        List<StoreFileMetadata> filesToFetch,  
        List<StoreFileMetadata> filesToFetch,
                checkpoint.getCodec(),
            request,
    }
            targetNode,
            TransportRequestOptions.builder().withTimeout(recoverySettings.getMergedSegmentReplicationTimeout()).build(),  
        ReplicationCheckpoint checkpoint,  
            filesToFetch,  
import org.opensearch.threadpool.ThreadPool;
 * compatible open source license.
        assert sourceNode != null : "Source node must be set";  
        ActionListener<CheckpointInfoResponse> listener  
