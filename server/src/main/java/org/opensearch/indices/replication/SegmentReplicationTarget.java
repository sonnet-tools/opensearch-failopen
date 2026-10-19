    protected void getFilesFromSource(
}
import org.opensearch.index.store.Store;
        checkpointUpdater.accept(checkpoint, this.indexShard);
    }  
        StepListener<GetSegmentFilesResponse> getFilesListener
            indexShard.finalizeReplication(catalogSnapshot);
 * compatible open source license.
                    Lucene.cleanLuceneIndex(store.directory()); // clean up and delete all files
        List<StoreFileMetadata> filesToFetch,
            /*
        return new SegmentReplicationTarget(indexShard, checkpoint, source, isRetry, listener);
            try {  
        } catch (CorruptIndexException | IndexFormatTooNewException | IndexFormatTooOldException ex) {
        ReplicationListener listener
            CatalogSnapshot catalogSnapshot = Store.fromSegmentInfos(infos, store.shardFormatDirectoryResolver());  
        this(indexShard, checkpoint, source, false, listener);  
    public SegmentReplicationTarget(  
            }  
        IndexShard indexShard,
            multiFileWriter.renameAllTempFiles();  
import java.util.function.BiConsumer;
    @Override  
            this::updateFileRecoveryBytes,  
        ReplicationCheckpoint checkpoint,
            checkpointInfo.getCheckpoint(),  
    ) {
            final SegmentInfos infos = store.buildSegmentInfos(
            filesToFetch,
 * SPDX-License-Identifier: Apache-2.0
    protected void finalizeReplication(CheckpointInfoResponse checkpointInfoResponse) throws Exception {  
            getId(),
        return REPLICATION_PREFIX + UUIDs.randomBase64UUID() + ".";  
/**
            indexShard,
import java.util.List;
        IndexShard indexShard,
        ReplicationListener listener
import org.opensearch.indices.replication.common.ReplicationFailedException;
    @Override
            } catch (Exception e) {  
 *  
    }  
import org.opensearch.common.lucene.Lucene;  
        Store store = null;
             In such scenario, ignore the exception  
 */  
import org.opensearch.common.UUIDs;
    }
    public final static String REPLICATION_PREFIX = "replication.";
        }
    }
        CheckpointInfoResponse checkpointInfo,  
 *
        }  
import org.opensearch.indices.replication.common.ReplicationListener;
                }
    protected String getPrefix() {
    public SegmentReplicationTarget(  
    ) {  
        } catch (Exception ex) {  
        } catch (CancellableThreads.ExecutionCancelledException ex) {  
            // This can happen when the engine is closed in a separate thread.
                    store.removeCorruptionMarker();
        ReplicationCheckpoint checkpoint,
        boolean isRetry,
            store.incRef();
                logger.debug("Failed to clean lucene index", e);
        if (checkpointInfoResponse.getInfosBytes() == null) {
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
                checkpointInfoResponse.getCheckpoint().getSegmentsGen()
import org.apache.lucene.index.CorruptIndexException;
import org.opensearch.OpenSearchCorruptionException;  
    protected void updateCheckpoint(ReplicationCheckpoint checkpoint, BiConsumer<ReplicationCheckpoint, IndexShard> checkpointUpdater) {  
                checkpointInfoResponse.getInfosBytes(),  
                try {
    @Override
    @Override  
            logger.warn("Shard is already closed, closing replication");
            // this means we transferred files from the remote that have not be checksummed and they are
import org.apache.lucene.index.IndexFormatTooNewException;
             */
/*  
        // Handle empty SegmentInfos bytes for recovering replicas
    @Override
 * The OpenSearch Contributors require contributions made to  
    ) {  
import org.opensearch.action.StepListener;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
package org.opensearch.indices.replication;
        } finally {
import org.apache.lucene.store.AlreadyClosedException;
    }
             Ignore closed replication target as it can happen due to index shard closed event in a separate thread.
    }
import org.opensearch.index.shard.IndexShard;  
import org.apache.lucene.index.IndexFormatTooOldException;  
            // broken. We have to clean up this shard entirely, remove all files and bubble it up.
            throw new ReplicationFailedException(ex);
 * Represents the target of a replication event.
import org.apache.lucene.index.SegmentInfos;
        SegmentReplicationSource source,  
    }
        source.getCheckpointMetadata(getId(), checkpoint, checkpointInfoListener);
    }  
            );
    protected void getCheckpointMetadata(StepListener<CheckpointInfoResponse> checkpointInfoListener) {
            getFilesListener
 */
        } catch (AlreadyClosedException ex) {
            if (store != null) {  
                ex.addSuppressed(e);
 * this file be licensed under the Apache-2.0 license or a
            store = store();
import org.opensearch.index.store.StoreFileMetadata;
    @Override
 * @opensearch.internal
        SegmentReplicationSource source,  
            throw new OpenSearchCorruptionException(ex);
        );
            // In this case the shard is closed at some point while updating the reader.  
    public SegmentReplicationTarget retryCopy() {
            // this is a fatal exception at this stage.  
        try {  
            }
        source.getSegmentFiles(
            return;  
public class SegmentReplicationTarget extends AbstractSegmentReplicationTarget {  
                } finally {  
                store.decRef();
        super("replication_target", indexShard, checkpoint, source, isRetry, listener);
            assert cancellableThreads.isCancelled() : "Replication target cancelled but cancellable threads not cancelled";
            // Unified path: bytes are always Lucene SegmentInfos. DFA snapshots travel in userData.
import org.opensearch.common.util.CancellableThreads;
