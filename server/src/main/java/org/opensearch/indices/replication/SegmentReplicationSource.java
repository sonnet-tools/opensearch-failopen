import org.opensearch.core.action.ActionListener;  
     *  
     * @param checkpoint    {@link ReplicationCheckpoint} Checkpoint to fetch metadata for.
    default void cancel() {}
     * Get the source description
     * Cancel any ongoing requests, should resolve any ongoing listeners with onFailure with a {@link ExecutionCancelledException}.  
                        public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
                        @Override  
import org.apache.lucene.store.FilterDirectory;
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
        BiConsumer<String, Long> fileProgressTracker,
                        @Override  
            // here we wrap the index input form the source directory to report progress of file copy for the recovery stats.
 * compatible open source license.
                            // we rely on the fact that copyFrom uses a buffer
     * @param checkpoint    {@link ReplicationCheckpoint} Checkpoint to fetch metadata for.
     *  
        }  
                        @Override  
 */  
public interface SegmentReplicationSource {
     * Fetch the requested segment files.  Passes a listener that completes when files are stored locally.
     * @opensearch.internal
                    final IndexInput input = in.openInput(name, context);
                        }
     *
                            return input.length();
                        }  
        long replicationId,
            this.fileProgressTracker = fileProgressTracker;
     * Directory wrapper that records copy process for replication statistics
     * @param replicationId long - ID of the replication event.
        private final BiConsumer<String, Long> fileProgressTracker;
    /**  
     */
                            throw new UnsupportedOperationException("use a buffer if you wanna perform well");  
 *
import org.opensearch.common.util.CancellableThreads.ExecutionCancelledException;
    /**
        List<StoreFileMetadata> filesToFetch,  
        }  
            super(in);
                            input.close();
                    };  
 * Represents the source of a replication event.
                        }
        public void copyFrom(Directory from, String src, String dest, IOContext context) throws IOException {  
    }
                public IndexInput openInput(String name, IOContext context) throws IOException {  
    void getCheckpointMetadata(long replicationId, ReplicationCheckpoint checkpoint, ActionListener<CheckpointInfoResponse> listener);
     * @param fileProgressTracker {@link BiConsumer} A consumer that updates the replication progress for shard files.
            // we increment the num bytes recovered in the readBytes method below, if users pull statistics they can see immediately
     * Get Metadata for a ReplicationCheckpoint.
     */
                            throw new UnsupportedOperationException("seeks are not supported");  
    void getSegmentFiles(
 * this file be licensed under the Apache-2.0 license or a
     * @param checkpoint    {@link ReplicationCheckpoint} Checkpoint to fetch metadata for.  
/**  
        ActionListener<GetSegmentFilesResponse> listener  
 * SPDX-License-Identifier: Apache-2.0
     * Fetch the merged segment files.  Passes a listener that completes when files are stored locally.  
                        }  
     * @param replicationId long - ID of the replication event.
        ReplicationCheckpoint checkpoint,
            in.copyFrom(new FilterDirectory(from) {
     * @param indexShard    {@link IndexShard} Reference to the IndexShard.
     * @param filesToFetch  {@link List} List of files to fetch.  
    /**
                        public void seek(long pos) throws IOException {
                        public void readBytes(byte[] b, int offset, int len) throws IOException {
                        }
                        }
                        @Override
        ActionListener<GetSegmentFilesResponse> listener
            }, src, dest, context);
        @Override
import java.io.IOException;
                        public long length() {
        BiConsumer<String, Long> fileProgressTracker,
                        public void close() throws IOException {
     *  
     * @param listener      {@link ActionListener} Listener that completes with the list of files copied.
import org.opensearch.index.store.StoreFileMetadata;
     */
    /**
    /**
                            throw new UnsupportedOperationException("slices are not supported");
        ReplicationCheckpoint checkpoint,
                        public byte readByte() throws IOException {
    default void getMergedSegmentFiles(  
                            fileProgressTracker.accept(dest, (long) len);
     */
        ReplicationStatsDirectoryWrapper(Directory in, BiConsumer<String, Long> fileProgressTracker) {  
     * @param listener      {@link ActionListener} listener that completes with a {@link CheckpointInfoResponse}.  
/*  
                @Override
    String getDescription();  
 * @opensearch.internal  
                        }
     * @param listener      {@link ActionListener} Listener that completes with the list of files copied.  
                            throw new UnsupportedOperationException("only straight copies are supported");
    final class ReplicationStatsDirectoryWrapper extends FilterDirectory {  
 *
     */
                            input.readBytes(b, offset, len);  
    ) {};
}
                        public long getFilePointer() {  
import org.apache.lucene.store.IOContext;  
                }
    );  
            // how much has been recovered.  
import org.opensearch.index.shard.IndexShard;
     * @param replicationId long - ID of the replication event.
import org.apache.lucene.store.IndexInput;
                        @Override
    /**
     */
        long replicationId,  
        IndexShard indexShard,
import org.apache.lucene.store.Directory;
        IndexShard indexShard,  
                        @Override
 */
     * @param filesToFetch  {@link List} List of files to fetch.
import java.util.List;  
package org.opensearch.indices.replication;
     * @param fileProgressTracker {@link BiConsumer} A consumer that updates the replication progress for shard files.  
                        @Override
import java.util.function.BiConsumer;
        List<StoreFileMetadata> filesToFetch,
     * @param indexShard    {@link IndexShard} Reference to the IndexShard.
                    return new IndexInput("StatsDirectoryWrapper(" + input.toString() + ")") {
