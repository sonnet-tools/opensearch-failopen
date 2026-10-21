    public void writeFileChunk(
     * @param bytesRecovered Number of bytes recovered
        try {
    @Override
            boolean isRecovering = indexShard.routingEntry().initializing() || indexShard.routingEntry().relocating();
            return false;
                checkpointInfo.getCheckpoint(),
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
        // TODO
    public void notifyListener(ReplicationFailedException e, boolean sendShardFailure) {
            state.setStage(SegmentReplicationState.Stage.GET_FILES);
    protected List<StoreFileMetadata> getFiles(CheckpointInfoResponse checkpointInfo) throws IOException {
    );
import java.io.IOException;
        StoreFileMetadata metadata,
        // Get list of files to copy from this checkpoint.
        BytesReference content,
    }
        }, listener::onFailure);
        cancellableThreads.checkForCancel();
        }
            throw new OpenSearchCorruptionException(
        this.source = source;
        IndexShard indexShard,
            multiFileWriter.close();
import org.opensearch.indices.replication.common.ReplicationListener;
        List<StoreFileMetadata> filesToFetch,
        final Store.RecoveryDiff diff = Store.segmentReplicationDiff(checkpointInfo.getMetadataMap(), indexShard.getSegmentMetadataMap());
    ) {
                missingFiles,
        try {
    protected void onCancel(String reason) {
        }
            "Id:[%d] Checkpoint [%s] Shard:[%s] Source:[%s]",
    protected final MultiFileWriter multiFileWriter;
                return;
import org.opensearch.index.shard.IndexShard;
    protected abstract void finalizeReplication(CheckpointInfoResponse checkpointInfoResponse) throws Exception;
                            + "] since initial checkpoint ["
            .filter(storeFileMetadata -> localFiles.contains(storeFileMetadata.name()))
        if (indexShard.indexSettings().isWarmIndex()) {
        return missingFiles;
        CheckpointInfoResponse checkpointInfo,
        );
        SegmentReplicationSource source,
            .filter(this::validateLocalChecksum)
    @Override
        long position,
    protected final SegmentReplicationSource source;
        String name,
         * Segments are immutable. So if the replica has any segments with the same name that differ from the one in the incoming
            .collect(Collectors.toList());
        final Set<String> reuseFiles = diff.missing.stream()
            try {
    public ReplicationCheckpoint getCheckpoint() {
        this.isRetry = isRetry;
import org.opensearch.index.store.StoreFileMetadata;
        } catch (Exception e) {
            throw new CancellableThreads.ExecutionCancelledException("replication was canceled reason [" + reason + "]");
        cancellableThreads.checkForCancel();
        // Return an empty list for warm indices, In this case, replica shards don't require downloading files from remote storage
            // from before a restart, and should accept the primary's current state even if it appears older.
        state.setStage(SegmentReplicationState.Stage.REPLICATING);
        // set of local files that can be reused
            } catch (IOException ex) {
            final List<StoreFileMetadata> filesToFetch = getFiles(checkpointInfo);
 *
        BiConsumer<ReplicationCheckpoint, IndexShard> checkpointUpdater
 * SPDX-License-Identifier: Apache-2.0
    }
import java.util.stream.Collectors;
        }
import org.opensearch.indices.replication.common.ReplicationTarget;
    }
            getCheckpoint(),
import org.opensearch.OpenSearchCorruptionException;
            source.getDescription(),
    @Override
        // TODO: Remove this useless state.
                throw new UncheckedIOException("Error reading " + file, e);
                            + "] is ahead of it"
            indexShard.recoveryState().getTargetNode()
    }
        logger.trace(
        return false;
    }
    protected abstract void getCheckpointMetadata(StepListener<CheckpointInfoResponse> checkpointInfoListener);
    protected final ReplicationCheckpoint checkpoint;
            if (file.checksum().equals(checksum)) {
        /*
 * this file be licensed under the Apache-2.0 license or a
            cancellableThreads.cancel(reason);
        int totalTranslogOps,
            getId(),
                    diff.different
import java.util.function.BiConsumer;
        ReplicationCheckpoint checkpoint,
            listener.onResponse(null);
         * IllegalStateException to fail the shard
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
    }
        cancellableThreads.setOnCancel((reason, beforeCancelEx) -> {
    // pkg private for tests
import org.opensearch.core.action.ActionListener;
import java.util.Set;
     * Start the Replication event.
            }
        try {
        );
package org.opensearch.indices.replication;
        state.setStage(SegmentReplicationState.Stage.DONE);
import org.opensearch.common.util.CancellableThreads;
 * Abstract base class for segment replication.
        StepListener<GetSegmentFilesResponse> getFilesListener
    protected abstract void updateCheckpoint(
                // clear local copy with mismatch. Safe because file is not referenced by active reader.
                store.deleteQuiet(file.name());
    }
        }
        ReplicationCheckpoint checkpoint,
            multiFileWriter.writeFileChunk(metadata, position, content, lastChunk);
            // Delete file on exceptions so that it can be re-downloaded. This is safe to do as this file is local only
                ).getFormattedMessage()
import java.util.Collections;
            .map(StoreFileMetadata::name)
     *
            // Only enforce strict checkpoint validation during normal replication, not during recovery.
        final List<StoreFileMetadata> missingFiles = diff.missing.stream()
            stateIndex,
    }
    }
            // During recovery (shard is INITIALIZING or RELOCATING), the replica may have a stale checkpoint
        boolean lastChunk,
        setLastAccessTime();
     * Updates the state to reflect recovery progress for the given file and
        } catch (IOException e) {
            }
        final StepListener<CheckpointInfoResponse> checkpointInfoListener = new StepListener<>();
import org.apache.logging.log4j.message.ParameterizedMessage;
    /**
        ReplicationLuceneIndex index = state.getIndex();
        }
            state.setStage(SegmentReplicationState.Stage.FINALIZE_REPLICATION);
            listener.onResponse(null);
 */
        }
                diff.different
        ActionListener<Void> listener
            cancellableThreads.checkForCancel();
 * @opensearch.internal
                && false == isRetry) {
            shardId(),
        if (diff.different.isEmpty() == false) {
        });
            listener.onFailure(e);
import org.opensearch.core.common.bytes.BytesReference;
        return String.format(
    protected void closeInternal() {
    }
    @Override
    protected void updateFileRecoveryBytes(String fileName, long bytesRecovered) {
    private boolean validateLocalChecksum(StoreFileMetadata file) {
 * The OpenSearch Contributors require contributions made to
            finalizeReplication(checkpointInfoListener.result());
                // Fixes https://github.com/opensearch-project/OpenSearch/issues/18490
    );
            // See: https://github.com/opensearch-project/OpenSearch/issues/19234
        }, listener::onFailure);
                && false == isRecovering
    public boolean reset(CancellableThreads newTargetCancellableThreads) throws IOException {
        checkpointInfoListener.whenComplete(checkpointInfo -> {
    protected abstract void getFilesFromSource(
            index.addRecoveredBytesToFile(fileName, bytesRecovered);
         */
    }
            Locale.ROOT,
            getFilesFromSource(checkpointInfo, filesToFetch, getFilesListener);
    /**
                    new ReplicationFailedException(
            .filter(md -> reuseFiles.contains(md.name()) == false)
     * updates the last access time for the target.
            source.getDescription()
            () -> new ParameterizedMessage(
        listener.onFailure(state(), e, sendShardFailure);
        state.setStage(SegmentReplicationState.Stage.GET_CHECKPOINT_INFO);
            if (indexShard.indexSettings().isSegRepLocalEnabled()
                );
        ReplicationListener listener
            } else {
                indexShard.store().directory().deleteFile(file.name());
        super(name, indexShard, new ReplicationLuceneIndex(), listener);
        boolean isRetry,
            logger.warn("Error reading " + file, e);
    protected final SegmentReplicationState state;
            }
                    indexShard.shardId(),
                listener.onFailure(
        }
 *
            // and not referenced by reader.
        return state;
                return false;
/*
}
     * @param fileName Name of the file being downloaded
        );
    @Override
import java.util.Locale;
            );
            ReplicationCheckpoint getMetadataCheckpoint = checkpointInfo.getCheckpoint();
            indexShard.routingEntry(),
    }
            state.getIndex().addFileDetail(file.name(), file.length(), false);
    }
/**
    public void startReplication(ActionListener<Void> listener, BiConsumer<ReplicationCheckpoint, IndexShard> checkpointUpdater) {
     * @param listener {@link ActionListener} listener.
import org.opensearch.indices.recovery.MultiFileWriter;
        getFilesListener.whenComplete(response -> {
            getId(),
 * compatible open source license.
import org.opensearch.action.StepListener;
                && checkpoint.isAheadOf(getMetadataCheckpoint)
 */
        final Set<String> localFiles = Set.of(indexShard.store().directory().listAll());
     */
                            + getMetadataCheckpoint
import java.util.List;
    @Override
                            + checkpoint
        }
                        "Rejecting stale metadata checkpoint ["
import org.opensearch.index.store.Store;
        } finally {
    public String description() {
        // as replicas will sync all files from remote in case of failure.
                "Replication diff for checkpoint {} {} {}",
    @Override
        this.multiFileWriter = new MultiFileWriter(indexShard.store(), stateIndex, getPrefix(), logger, this::ensureRefCount);
import java.io.UncheckedIOException;
            return Collections.emptyList();
        this.checkpoint = checkpoint;
        for (StoreFileMetadata file : missingFiles) {
    }
        try {
        this.state = new SegmentReplicationState(
            final String checksum = indexShard.store().checksumLocalFile(file.name());
        logger.trace(new ParameterizedMessage("Starting Replication Target: {}", description()));
        state.setStage(SegmentReplicationState.Stage.FILE_DIFF);
                    "Shard {} has local copies of segments that differ from the primary {}",
         * snapshot from source that means the local copy of the segment has been corrupted/changed in some way and we throw an
     */
                new ParameterizedMessage(
        } finally {
    public SegmentReplicationState state() {
    protected final boolean isRetry;
    ) {
    public AbstractSegmentReplicationTarget(
import org.opensearch.indices.replication.common.ReplicationFailedException;
        getCheckpointMetadata(checkpointInfoListener);
                return true;
                    )
            super.closeInternal();
            cancellableThreads.checkForCancel();
    @Override
    protected void onDone() {
public abstract class AbstractSegmentReplicationTarget extends ReplicationTarget {
            .collect(Collectors.toSet());
        final StepListener<GetSegmentFilesResponse> getFilesListener = new StepListener<>();
            )
        // local files
            source.cancel();
        if (index != null) {
            updateCheckpoint(checkpointInfo.getCheckpoint(), checkpointUpdater);
        return this.checkpoint;
            notifyListener(new ReplicationFailedException(reason), false);
