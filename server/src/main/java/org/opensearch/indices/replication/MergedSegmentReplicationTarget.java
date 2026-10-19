    @Override
    protected void getFilesFromSource(
 * @opensearch.internal  
    }
    @Override  
    }  
    public MergedSegmentReplicationTarget retryCopy() {  
            checkpoint,
        CheckpointInfoResponse checkpointInfo,
            this::updateMergedSegmentFileRecoveryBytes,
import org.opensearch.index.shard.IndexShard;  
/*  
        IndexShard indexShard,  
    ) {
import org.opensearch.indices.replication.common.ReplicationListener;
        return MERGE_REPLICATION_PREFIX + UUIDs.randomBase64UUID() + ".";
    protected String getPrefix() {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.UUIDs;
import org.opensearch.action.StepListener;
    protected void updateCheckpoint(ReplicationCheckpoint checkpoint, BiConsumer<ReplicationCheckpoint, IndexShard> checkpointUpdater) {}
import org.opensearch.index.store.StoreFileMetadata;
package org.opensearch.indices.replication;
    protected void finalizeReplication(CheckpointInfoResponse checkpointInfoResponse) throws Exception {
    public final static String MERGE_REPLICATION_PREFIX = "merge.";  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
        source.getMergedSegmentFiles(  
        ReplicationCheckpoint checkpoint,
        ReplicationListener listener  
    }  
        checkpointInfoListener.onResponse(new CheckpointInfoResponse(checkpoint, checkpoint.getMetadataMap(), null));  
        StepListener<GetSegmentFilesResponse> getFilesListener
 * Represents the target of a merged segment replication event.
        assert checkpoint instanceof MergedSegmentCheckpoint;  
 */  
    }
    protected void updateMergedSegmentFileRecoveryBytes(String fileName, long bytesRecovered) {
    public MergedSegmentReplicationTarget(
import java.util.List;  
        return new MergedSegmentReplicationTarget(indexShard, checkpoint, source, listener);
    @Override
public class MergedSegmentReplicationTarget extends AbstractSegmentReplicationTarget {
    }
import java.util.function.BiConsumer;
            filesToFetch,  
 *
    @Override  
    protected void getCheckpointMetadata(StepListener<CheckpointInfoResponse> checkpointInfoListener) {
    @Override
 * compatible open source license.
            indexShard,
}
 */
        indexShard.mergedSegmentTransferTracker().addTotalBytesReceived(bytesRecovered);
    }
 *
 * this file be licensed under the Apache-2.0 license or a
        updateFileRecoveryBytes(fileName, bytesRecovered);  
 * SPDX-License-Identifier: Apache-2.0
    @Override
        SegmentReplicationSource source,
        );
            getId(),
        super("merged_segment_replication_target", indexShard, checkpoint, source, false, listener);
        List<StoreFileMetadata> filesToFetch,  
        indexShard.addPendingMergeSegmentCheckpoint((MergedSegmentCheckpoint) checkpoint);
            getFilesListener  
    ) {
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;
        multiFileWriter.renameAllTempFiles();
/**  
    }
