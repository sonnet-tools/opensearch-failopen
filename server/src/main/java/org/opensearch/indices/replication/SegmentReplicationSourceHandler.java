            shard,
            IOUtils.closeWhileHandlingException(copyState);
        resources.add(copyState);
import org.opensearch.OpenSearchException;
        this.copyState = new CopyState(shard);
import org.opensearch.action.StepListener;
        this.segmentFileTransferHandler = new SegmentFileTransferHandler(
import java.util.List;
/*
        this.allocationId = allocationId;
                timer.stop();
 * The OpenSearch Contributors require contributions made to
    }
        final Closeable releaseResources = () -> IOUtils.close(resources);
    }
    private final CancellableThreads cancellableThreads = new CancellableThreads();
     */
                if (beforeCancelEx != null) {
                }
        writer.cancel();
        }
                .filter(file -> storeFiles.contains(file.name()))
        // Short circuit when no files to transfer
    /**
     * Sends Segment files from the local node to the given target.
        future.addListener(listener, OpenSearchExecutors.newDirectExecutorService());
class SegmentReplicationSourceHandler {
    private final FileChunkWriter writer;
        int maxConcurrentFileChunks
import java.util.concurrent.CopyOnWriteArrayList;
            };
     */
                        "[replication id {}] Source node completed sending files to target node [{}], timing: {}",
            final Consumer<Exception> onFailure = e -> {
            }, onFailure);
                        request.getReplicationId(),
            shard.shardId(),
        if (isReplicating.compareAndSet(false, true) == false) {
import org.opensearch.transport.Transports;
import org.opensearch.common.util.io.IOUtils;
     * @param request  {@link GetSegmentFilesRequest} request object containing list of files to be sent.
                    timer.stop();
package org.opensearch.indices.replication;
import org.opensearch.core.index.shard.ShardId;
     *
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
 * compatible open source license.
import java.io.Closeable;
    public void cancel(String reason) {
    }
    public ShardId shardId() {
        return allocationId;
     * @param writer                  {@link FileChunkWriter} implementation that sends file chunks over the transport layer.
    }
            IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
    }
                        timer.time()
     * @param maxConcurrentFileChunks {@link Integer}
            SegmentReplicationSourceHandler.class,
            });
                    request.getTargetNode().getId(),
                    IOUtils.close(resources);
        String allocationId,
        return copyState.getInfosBytes();
     * Constructor.
            maxConcurrentFileChunks
import org.opensearch.common.util.concurrent.ListenableFuture;
        final ReplicationTimer timer = new ReplicationTimer();
    }
        if (request.getFilesToFetch().isEmpty()) {
            final MultiChunkTransfer<StoreFileMetadata, SegmentFileTransferHandler.FileChunk> transfer = segmentFileTransferHandler
            cancellableThreads.checkForCancel();
        IOUtils.closeWhileHandlingException(copyState);
            timer.start();
import org.opensearch.index.store.StoreFileMetadata;
            cancellableThreads,
            final StoreFileMetadata[] storeFileMetadata = request.getFilesToFetch()
     * @param targetNode              {@link DiscoveryNode} target node where files should be sent.
import org.opensearch.indices.recovery.MultiChunkTransfer;
                    logger.trace(
    public String getAllocationId() {
                logger.trace(
        return copyState.getCheckpoint();
        );
                    "replication was canceled reason [" + reason + "]"
            transfer.start();
                    future.onResponse(new GetSegmentFilesResponse(List.of(storeFileMetadata)));
        this.targetNode = targetNode;
import java.util.Collections;
    public byte[] getInfosBytes() {
 * SPDX-License-Identifier: Apache-2.0
    }
            sendFileStep.whenComplete(r -> {
    /**
        this.logger = Loggers.getLogger(
    private final String allocationId;
            targetNode,
                IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
        cancellableThreads.cancel(reason);
 */
 * this file be licensed under the Apache-2.0 license or a
                    timer.time()
            return;
            listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));
    ) throws IOException {
import org.opensearch.index.shard.IndexShard;
    SegmentReplicationSourceHandler(
import java.io.IOException;
}
        FileChunkWriter writer,
        return shard.shardId();
        return isReplicating.get();
    public DiscoveryNode getTargetNode() {
 * Orchestrates sending requested segment files to a target shard.
    private final List<Closeable> resources = new CopyOnWriteArrayList<>();
            final StepListener<Void> sendFileStep = new StepListener<>();
        );
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.node.DiscoveryNode;
    public synchronized void sendFiles(GetSegmentFilesRequest request, ActionListener<GetSegmentFilesResponse> listener) {
    /**
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            shard.getThreadPool(),
    private final IndexShard shard;
     * Cancels the replication and interrupts all eligible threads.
                    shard.updateVisibleCheckpointForShard(allocationId, copyState.getCheckpoint());
 * @opensearch.internal
    private final DiscoveryNode targetNode;
 */
import org.opensearch.common.util.CancellableThreads;
        }
     * @param shard                   {@link IndexShard} The primary shard local to this node.
 *
import java.util.Arrays;
        this.writer = writer;
        }
        DiscoveryNode targetNode,
    private final Logger logger;
                }
    }
                IOUtils.closeWhileHandlingException(releaseResources, () -> future.onFailure(e));
     */
            cancellableThreads.setOnCancel((reason, beforeCancelEx) -> {
                .createTransfer(shard.store(), storeFileMetadata, () -> 0, sendFileStep);
                try {
                final RuntimeException e = new CancellableThreads.ExecutionCancelledException(
import java.util.function.Consumer;
import org.opensearch.core.action.ActionListener;
        try {
            logger,
                        request.getTargetNode().getId(),
                    );
    }
    public ReplicationCheckpoint getCheckpoint() {
import java.util.Set;
            throw new OpenSearchException("Replication to {} is already running.", shard.shardId());
            Set<String> storeFiles = new HashSet<>(Arrays.asList(shard.store().directory().listAll()));
import org.opensearch.indices.replication.common.ReplicationTimer;
    private final CopyState copyState;
                assert Transports.assertNotTransportThread(SegmentReplicationSourceHandler.this + "[onFailure]");
                );
    private final AtomicBoolean isReplicating = new AtomicBoolean();
        return targetNode;
    private final ListenableFuture<GetSegmentFilesResponse> future = new ListenableFuture<>();
                    e.addSuppressed(beforeCancelEx);
        this.shard = shard;
            "sending segments to " + targetNode.getName()
 *
        } catch (Exception e) {
                throw e;
            resources.add(transfer);
        IndexShard shard,
            shard.updateVisibleCheckpointForShard(request.getTargetAllocationId(), copyState.getCheckpoint());
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.indices.recovery.FileChunkWriter;
            writer,
     * @param listener {@link ActionListener} that completes with the list of files sent.
import java.util.HashSet;
                    request.getReplicationId(),
                    "[replication id {}] Source node failed to send files to target node [{}], timing: {}",
    private final SegmentFileTransferHandler segmentFileTransferHandler;
            cancellableThreads.checkForCancel();
    public boolean isReplicating() {
            // before completion, alert the primary of the replica's state.
import org.opensearch.indices.replication.common.CopyState;
/**
     * @param fileChunkSizeInBytes    {@link Integer}
                .stream()
     *
        int fileChunkSizeInBytes,
                } finally {
            fileChunkSizeInBytes,
import org.opensearch.common.logging.Loggers;
                );
                .toArray(StoreFileMetadata[]::new);
