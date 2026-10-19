            } else {
            cancellableThreads.checkForCancel();  
         */
import java.util.function.BiConsumer;
    }  
                    diff.different
         * Segments are immutable. So if the replica has any segments with the same name that differ from the one in the incoming
    protected final SegmentReplicationState state;
import org.opensearch.indices.replication.common.ReplicationFailedException;  
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
            final String checksum = indexShard.store().checksumLocalFile(file.name());
     *
        try {  
        } catch (Exception e) {  
                return false;
            listener.onResponse(null);
package org.opensearch.indices.replication;
import org.opensearch.index.store.StoreFileMetadata;  
        BytesReference content,
    @Override
            notifyListener(new ReplicationFailedException(reason), false);
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        ReplicationCheckpoint checkpoint,  
    }
            }
    private boolean validateLocalChecksum(StoreFileMetadata file) {
        final StepListener<CheckpointInfoResponse> checkpointInfoListener = new StepListener<>();
import org.opensearch.core.action.ActionListener;
        boolean lastChunk,
        logger.trace(new ParameterizedMessage("Starting Replication Target: {}", description()));
            final List<StoreFileMetadata> filesToFetch = getFiles(checkpointInfo);
        }, listener::onFailure);  
 * compatible open source license.
    }  
        }
        ReplicationListener listener  
        this.source = source;
    );
            // Only enforce strict checkpoint validation during normal replication, not during recovery.  
        // TODO
        try {  
        } finally {
            return Collections.emptyList();
        return String.format(
     */  
        int totalTranslogOps,  
     * @param bytesRecovered Number of bytes recovered
                indexShard.store().directory().deleteFile(file.name());
        return state;  
        IndexShard indexShard,
                && checkpoint.isAheadOf(getMetadataCheckpoint)  
    /**
        state.setStage(SegmentReplicationState.Stage.GET_CHECKPOINT_INFO);  
    @Override  
    }
            getFilesFromSource(checkpointInfo, filesToFetch, getFilesListener);
                && false == isRetry) {
            );
    ) {
            source.getDescription()
            // During recovery (shard is INITIALIZING or RELOCATING), the replica may have a stale checkpoint
        // local files
        }
        );  
import java.util.Locale;  
    public AbstractSegmentReplicationTarget(  
        cancellableThreads.setOnCancel((reason, beforeCancelEx) -> {
                            + "] is ahead of it"
        SegmentReplicationSource source,
            } catch (IOException ex) {  
                return true;  
        }  
    public boolean reset(CancellableThreads newTargetCancellableThreads) throws IOException {  
        this.state = new SegmentReplicationState(  
        if (diff.different.isEmpty() == false) {  
        List<StoreFileMetadata> filesToFetch,  
        );  
        /*
            // Delete file on exceptions so that it can be re-downloaded. This is safe to do as this file is local only
            boolean isRecovering = indexShard.routingEntry().initializing() || indexShard.routingEntry().relocating();
            Locale.ROOT,  
        state.setStage(SegmentReplicationState.Stage.FILE_DIFF);
    ) {
            updateCheckpoint(checkpointInfo.getCheckpoint(), checkpointUpdater);  
        this.isRetry = isRetry;
import org.opensearch.OpenSearchCorruptionException;
            // and not referenced by reader.  
import org.opensearch.action.StepListener;  
    }  
            state.setStage(SegmentReplicationState.Stage.FINALIZE_REPLICATION);  
            )
                missingFiles,  
public abstract class AbstractSegmentReplicationTarget extends ReplicationTarget {
    // pkg private for tests
    @Override
                            + checkpoint  
        }
                // clear local copy with mismatch. Safe because file is not referenced by active reader.
        boolean isRetry,
            super.closeInternal();  
import java.io.UncheckedIOException;  
            }
            shardId(),
     * @param listener {@link ActionListener} listener.
    public String description() {
        state.setStage(SegmentReplicationState.Stage.REPLICATING);  
        // Get list of files to copy from this checkpoint.
        cancellableThreads.checkForCancel();
    public SegmentReplicationState state() {
        setLastAccessTime();  
            () -> new ParameterizedMessage(  
            throw new OpenSearchCorruptionException(
import java.util.Set;
        return this.checkpoint;  
        // as replicas will sync all files from remote in case of failure.
        if (index != null) {  
    @Override
}
 * SPDX-License-Identifier: Apache-2.0
        try {  
        long position,  
    protected final SegmentReplicationSource source;
        state.setStage(SegmentReplicationState.Stage.DONE);
        ActionListener<Void> listener
        try {  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
            "Id:[%d] Checkpoint [%s] Shard:[%s] Source:[%s]",
    public void startReplication(ActionListener<Void> listener, BiConsumer<ReplicationCheckpoint, IndexShard> checkpointUpdater) {
                        "Rejecting stale metadata checkpoint ["  
    protected void onDone() {  
            getId(),
            try {
            // See: https://github.com/opensearch-project/OpenSearch/issues/19234  
                            + "] since initial checkpoint ["
        } finally {
            throw new CancellableThreads.ExecutionCancelledException("replication was canceled reason [" + reason + "]");  
 * Abstract base class for segment replication.  
 *
         * IllegalStateException to fail the shard
        // TODO: Remove this useless state.
            .filter(md -> reuseFiles.contains(md.name()) == false)
                listener.onFailure(
        }
    protected abstract void getFilesFromSource(
        final Set<String> localFiles = Set.of(indexShard.store().directory().listAll());
            .collect(Collectors.toSet());
         * snapshot from source that means the local copy of the segment has been corrupted/changed in some way and we throw an  
    /**
            .collect(Collectors.toList());  
            listener.onFailure(e);
            getId(),  
import org.opensearch.index.store.Store;
        this.multiFileWriter = new MultiFileWriter(indexShard.store(), stateIndex, getPrefix(), logger, this::ensureRefCount);
        for (StoreFileMetadata file : missingFiles) {
    }
                    )
 * The OpenSearch Contributors require contributions made to  
    }
                return;
     * Start the Replication event.  
    @Override  
        }, listener::onFailure);
            listener.onResponse(null);
    protected List<StoreFileMetadata> getFiles(CheckpointInfoResponse checkpointInfo) throws IOException {  
        ReplicationLuceneIndex index = state.getIndex();
            stateIndex,
                ).getFormattedMessage()  
        StoreFileMetadata metadata,
        final StepListener<GetSegmentFilesResponse> getFilesListener = new StepListener<>();
            // from before a restart, and should accept the primary's current state even if it appears older.
                "Replication diff for checkpoint {} {} {}",
                    new ReplicationFailedException(
    @Override
        logger.trace(
import org.opensearch.indices.recovery.MultiFileWriter;
    }
            indexShard.routingEntry(),
                // Fixes https://github.com/opensearch-project/OpenSearch/issues/18490  
    protected final MultiFileWriter multiFileWriter;  
        StepListener<GetSegmentFilesResponse> getFilesListener
        String name,
    }  
        getFilesListener.whenComplete(response -> {
import java.util.List;
     * updates the last access time for the target.  
            .filter(this::validateLocalChecksum)  
            index.addRecoveredBytesToFile(fileName, bytesRecovered);
    protected void updateFileRecoveryBytes(String fileName, long bytesRecovered) {
            logger.warn("Error reading " + file, e);
            multiFileWriter.writeFileChunk(metadata, position, content, lastChunk);
import org.opensearch.common.util.CancellableThreads;
                checkpointInfo.getCheckpoint(),
                            + getMetadataCheckpoint
            indexShard.recoveryState().getTargetNode()
                    indexShard.shardId(),
        if (indexShard.indexSettings().isWarmIndex()) {  
        return missingFiles;
            .filter(storeFileMetadata -> localFiles.contains(storeFileMetadata.name()))
        listener.onFailure(state(), e, sendShardFailure);
                    "Shard {} has local copies of segments that differ from the primary {}",  
                && false == isRecovering
        return false;
/*  
import org.apache.logging.log4j.message.ParameterizedMessage;
    protected abstract void updateCheckpoint(
    @Override
        BiConsumer<ReplicationCheckpoint, IndexShard> checkpointUpdater
        getCheckpointMetadata(checkpointInfoListener);
            return false;  
        }
import org.opensearch.indices.replication.common.ReplicationListener;
import org.opensearch.indices.replication.common.ReplicationTarget;  
        });
            finalizeReplication(checkpointInfoListener.result());
    }
import org.opensearch.index.shard.IndexShard;
    }
            multiFileWriter.close();
    }
            .map(StoreFileMetadata::name)
    );
    public void notifyListener(ReplicationFailedException e, boolean sendShardFailure) {
        final Store.RecoveryDiff diff = Store.segmentReplicationDiff(checkpointInfo.getMetadataMap(), indexShard.getSegmentMetadataMap());  
    protected final boolean isRetry;
                diff.different
                throw new UncheckedIOException("Error reading " + file, e);
 *
/**
            if (file.checksum().equals(checksum)) {
     */  
        ReplicationCheckpoint checkpoint,  
 */  
    public ReplicationCheckpoint getCheckpoint() {
    @Override  
        }
 */  
import java.util.stream.Collectors;  
        checkpointInfoListener.whenComplete(checkpointInfo -> {
            getCheckpoint(),  
    public void writeFileChunk(
        } catch (IOException e) {  
        // Return an empty list for warm indices, In this case, replica shards don't require downloading files from remote storage
        }
     * @param fileName Name of the file being downloaded
import java.util.Collections;
            source.getDescription(),
            state.setStage(SegmentReplicationState.Stage.GET_FILES);
     * Updates the state to reflect recovery progress for the given file and
        final Set<String> reuseFiles = diff.missing.stream()
            state.getIndex().addFileDetail(file.name(), file.length(), false);
import org.opensearch.core.common.bytes.BytesReference;  
            }
            if (indexShard.indexSettings().isSegRepLocalEnabled()
    protected abstract void getCheckpointMetadata(StepListener<CheckpointInfoResponse> checkpointInfoListener);  
                store.deleteQuiet(file.name());  
                );  
        final List<StoreFileMetadata> missingFiles = diff.missing.stream()
        cancellableThreads.checkForCancel();
    }
        this.checkpoint = checkpoint;  
    protected abstract void finalizeReplication(CheckpointInfoResponse checkpointInfoResponse) throws Exception;
            source.cancel();  
        CheckpointInfoResponse checkpointInfo,
 * @opensearch.internal
        // set of local files that can be reused  
        super(name, indexShard, new ReplicationLuceneIndex(), listener);
    protected void onCancel(String reason) {
            ReplicationCheckpoint getMetadataCheckpoint = checkpointInfo.getCheckpoint();
            cancellableThreads.checkForCancel();
    protected final ReplicationCheckpoint checkpoint;  
        );  
    }
    protected void closeInternal() {
            cancellableThreads.cancel(reason);
                new ParameterizedMessage(
