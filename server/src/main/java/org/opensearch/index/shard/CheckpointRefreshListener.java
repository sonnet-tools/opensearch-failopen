            && shard.getReplicationTracker().isPrimaryMode()
 */  
public class CheckpointRefreshListener extends ReleasableRetryableRefreshListener {
 * @opensearch.internal  
        this.shard = shard;
    @Override
            && shard.indexSettings.isAssignedOnRemoteNode() == false) {  
        if (didRefresh  
    @Override
            publisher.publish(shard, shard.getLatestReplicationCheckpoint());
 * This class is only used with Segment Replication enabled.
import org.apache.lucene.search.ReferenceManager;  
package org.opensearch.index.shard;
        }
    }  
    private final IndexShard shard;  
/**
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
import org.apache.logging.log4j.LogManager;
    public void beforeRefresh() throws IOException {  
 */
        this.publisher = publisher;
    }
 * The OpenSearch Contributors require contributions made to  
            && shard.state() == IndexShardState.STARTED
    protected Logger getLogger() {
import org.apache.logging.log4j.Logger;
/*  
    protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
 * A {@link ReferenceManager.RefreshListener} that publishes a checkpoint to be consumed by replicas.  
 * SPDX-License-Identifier: Apache-2.0
        return true;  
    }  
import java.io.IOException;  
    }
 * compatible open source license.
        return logger;
}
        // Do nothing
    private final SegmentReplicationCheckpointPublisher publisher;
    protected static Logger logger = LogManager.getLogger(CheckpointRefreshListener.class);
    @Override  
 *
 *
    public CheckpointRefreshListener(IndexShard shard, SegmentReplicationCheckpointPublisher publisher) {  
