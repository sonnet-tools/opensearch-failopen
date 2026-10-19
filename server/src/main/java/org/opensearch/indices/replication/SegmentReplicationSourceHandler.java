    public synchronized void sendFiles(GetSegmentFilesRequest request, ActionListener<GetSegmentFilesResponse> listener) {
                IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
    }  
     *  
        this.writer = writer;  
        FileChunkWriter writer,
import org.opensearch.core.action.ActionListener;
    private final AtomicBoolean isReplicating = new AtomicBoolean();
    }
            shard.getThreadPool(),
        }
     * @param fileChunkSizeInBytes    {@link Integer}  
 * SPDX-License-Identifier: Apache-2.0
    public String getAllocationId() {
            throw new OpenSearchException("Replication to {} is already running.", shard.shardId());
    private final FileChunkWriter writer;
     */
    private final Logger logger;  
    public byte[] getInfosBytes() {
     * @param writer                  {@link FileChunkWriter} implementation that sends file chunks over the transport layer.
 */  
            "sending segments to " + targetNode.getName()
            shard.shardId(),  
import org.opensearch.common.util.concurrent.ListenableFuture;
    private final SegmentFileTransferHandler segmentFileTransferHandler;
        this.targetNode = targetNode;
            logger,
 * The OpenSearch Contributors require contributions made to  
        );  
                throw e;  
                timer.stop();
import java.util.Set;  
                assert Transports.assertNotTransportThread(SegmentReplicationSourceHandler.this + "[onFailure]");  
            fileChunkSizeInBytes,
     */
            shard,
import org.opensearch.transport.Transports;
        IOUtils.closeWhileHandlingException(copyState);  
     * @param request  {@link GetSegmentFilesRequest} request object containing list of files to be sent.
            Set<String> storeFiles = new HashSet<>(Arrays.asList(shard.store().directory().listAll()));
            listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));
import java.io.IOException;
 *
import org.opensearch.indices.replication.common.CopyState;
                    shard.updateVisibleCheckpointForShard(allocationId, copyState.getCheckpoint());  
                    "[replication id {}] Source node failed to send files to target node [{}], timing: {}",
                    "replication was canceled reason [" + reason + "]"  
                        request.getReplicationId(),
        }  
/**
    private final CopyState copyState;
            shard.updateVisibleCheckpointForShard(request.getTargetAllocationId(), copyState.getCheckpoint());
                }
                .stream()  
        final ReplicationTimer timer = new ReplicationTimer();
        try {
import org.opensearch.common.util.CancellableThreads;  
            return;
        this.shard = shard;  
            maxConcurrentFileChunks
            SegmentReplicationSourceHandler.class,
import java.io.Closeable;  
            cancellableThreads.checkForCancel();
            transfer.start();
    public ShardId shardId() {
        }  
            };  
import org.opensearch.indices.replication.common.ReplicationTimer;  
    public DiscoveryNode getTargetNode() {
     * @param listener {@link ActionListener} that completes with the list of files sent.
                    future.onResponse(new GetSegmentFilesResponse(List.of(storeFileMetadata)));
            final StepListener<Void> sendFileStep = new StepListener<>();  
     * Sends Segment files from the local node to the given target.
import org.opensearch.indices.recovery.MultiChunkTransfer;  
            });
                final RuntimeException e = new CancellableThreads.ExecutionCancelledException(
        this.segmentFileTransferHandler = new SegmentFileTransferHandler(  
     * Cancels the replication and interrupts all eligible threads.
                    request.getReplicationId(),
import org.opensearch.common.logging.Loggers;
                    logger.trace(
import java.util.Collections;  
            writer,  
            targetNode,
     * @param targetNode              {@link DiscoveryNode} target node where files should be sent.  
        writer.cancel();
                .toArray(StoreFileMetadata[]::new);
            cancellableThreads.setOnCancel((reason, beforeCancelEx) -> {
    }
 *
                );
     * @param maxConcurrentFileChunks {@link Integer}
    }
    private final DiscoveryNode targetNode;
            final Consumer<Exception> onFailure = e -> {
            IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
            IOUtils.closeWhileHandlingException(copyState);  
        );
                    timer.time()
        this.copyState = new CopyState(shard);
        if (request.getFilesToFetch().isEmpty()) {  
    private final String allocationId;  
     * Constructor.
import java.util.HashSet;
import org.opensearch.index.store.StoreFileMetadata;
     * @param shard                   {@link IndexShard} The primary shard local to this node.
                IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
import org.opensearch.index.shard.IndexShard;  
    }
import java.util.Arrays;
                }
    private final ListenableFuture<GetSegmentFilesResponse> future = new ListenableFuture<>();
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                .filter(file -> storeFiles.contains(file.name()))
import org.opensearch.core.index.shard.ShardId;
    /**  
 */  
            final StoreFileMetadata[] storeFileMetadata = request.getFilesToFetch()
        String allocationId,
        // Short circuit when no files to transfer
    private final CancellableThreads cancellableThreads = new CancellableThreads();  
    }
    /**  
                logger.trace(  
        int fileChunkSizeInBytes,
            cancellableThreads.checkForCancel();
import org.opensearch.action.StepListener;  
            final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = segmentFileTransferHandler
        this.logger = Loggers.getLogger(
    }
        return targetNode;
import org.opensearch.indices.recovery.FileChunkWriter;
/*  
    public boolean isReplicating() {  
        resources.add(copyState);
    }  
                    timer.stop();
                        timer.time()  
                    e.addSuppressed(beforeCancelEx);  
                    IOUtils.close(resources);
                        "[replication id {}] Source node completed sending files to target node [{}], timing: {}",  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
 * this file be licensed under the Apache-2.0 license or a
     *
class SegmentReplicationSourceHandler {
 * compatible open source license.
        final Closeable releaseResources = () -> IOUtils.close(resources);
import java.util.concurrent.CopyOnWriteArrayList;
        } catch (Exception e) {
        cancellableThreads.cancel(reason);
            }, onFailure);  
import java.util.function.Consumer;  
        int maxConcurrentFileChunks  
import org.opensearch.common.util.io.IOUtils;  
    public void cancel(String reason) {  
 * @opensearch.internal
            sendFileStep.whenComplete(r -> {
     */  
    private final List<Closeable> resources = new CopyOnWriteArrayList<>();
import java.util.List;
    SegmentReplicationSourceHandler(  
    private final IndexShard shard;  
                try {
            timer.start();  
        DiscoveryNode targetNode,
        return copyState.getCheckpoint();
                    request.getTargetNode().getId(),  
        if (isReplicating.compareAndSet(false, true) == false) {  
            resources.add(transfer);  
    }
        IndexShard shard,  
                        request.getTargetNode().getId(),
                if (beforeCancelEx != null) {
}
    ) throws IOException {
import org.opensearch.cluster.node.DiscoveryNode;
        return isReplicating.get();
    public ReplicationCheckpoint getCheckpoint() {  
                } finally {  
                );
                .createTransfer(shard.store(), storeFileMetadata, () -> 0, sendFileStep);
 * Orchestrates sending requested segment files to a target shard.  
    /**
        return copyState.getInfosBytes();
                    );
        return allocationId;  
            // before completion, alert the primary of the replica's state.
import org.opensearch.OpenSearchException;
package org.opensearch.indices.replication;
        this.allocationId = allocationId;
import java.util.concurrent.atomic.AtomicBoolean;
            cancellableThreads,  
import org.apache.logging.log4j.Logger;
        future.addListener(listener, OpenSearchExecutors.newDirectExecutorService());  
        return shard.shardId();  
