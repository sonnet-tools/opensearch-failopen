    public interface PublishAction {
 * SPDX-License-Identifier: Apache-2.0
        (indexShard, checkpoint) -> {}
 */
    public SegmentReplicationCheckpointPublisher(PublishAction publishAction) {
    );
 *  
import org.opensearch.common.annotation.PublicApi;
/**
 *
     *
        this(publishAction::publish);
        void publish(IndexShard indexShard, ReplicationCheckpoint checkpoint);  
        indexShard.onCheckpointPublished(checkpoint);
import org.opensearch.common.inject.Inject;
@PublicApi(since = "2.2.0")  
 */  
 * compatible open source license.
    public void publish(IndexShard indexShard, ReplicationCheckpoint checkpoint) {  
import org.opensearch.index.shard.IndexShard;  
package org.opensearch.indices.replication.checkpoint;
    }  
     * NoOp Checkpoint publisher
        this.publishAction = Objects.requireNonNull(publishAction);  
        publishAction.publish(indexShard, checkpoint);
public class SegmentReplicationCheckpointPublisher {
    public static final SegmentReplicationCheckpointPublisher EMPTY = new SegmentReplicationCheckpointPublisher(  
    @PublicApi(since = "2.2.0")
     * @opensearch.api
    /**
 * this file be licensed under the Apache-2.0 license or a
 * Publish Segment Replication Checkpoint.
    private final PublishAction publishAction;  
    }
    public SegmentReplicationCheckpointPublisher(PublishCheckpointAction publishAction) {
     * Represents an action that is invoked to publish segment replication checkpoint to replica shard  
}  
import java.util.Objects;
    }
 * @opensearch.api
    }  
    @Inject  
     */  
 * The OpenSearch Contributors require contributions made to  
    /**  
/*  
    // This Component is behind feature flag so we are manually binding this in IndicesModule.
     */
