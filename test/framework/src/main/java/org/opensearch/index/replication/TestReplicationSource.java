 * this file be licensed under the Apache-2.0 license or a
    );
    public String getDescription() {
        long replicationId,
 *
 */  
        ActionListener<CheckpointInfoResponse> listener  
import java.util.function.BiConsumer;
import org.opensearch.indices.replication.SegmentReplicationSource;  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
import java.util.List;  
 * The OpenSearch Contributors require contributions made to  
 * This class is used by unit tests implementing SegmentReplicationSource
        ReplicationCheckpoint checkpoint,  
        BiConsumer<String, Long> fileProgressTracker,  
import org.opensearch.indices.replication.GetSegmentFilesResponse;
        IndexShard indexShard,
/**  
        long replicationId,
    @Override
    public abstract void getSegmentFiles(
        return "This is a test description";  
        List<StoreFileMetadata> filesToFetch,
    @Override
import org.opensearch.indices.replication.CheckpointInfoResponse;
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
        ReplicationCheckpoint checkpoint,
public abstract class TestReplicationSource implements SegmentReplicationSource {  
    public abstract void getCheckpointMetadata(  
package org.opensearch.index.replication;
        ActionListener<GetSegmentFilesResponse> listener
    );
import org.opensearch.index.shard.IndexShard;
 * compatible open source license.
    @Override  
 */
import org.opensearch.core.action.ActionListener;
import org.opensearch.index.store.StoreFileMetadata;  
}
