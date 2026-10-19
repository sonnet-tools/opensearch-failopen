 *  
     *
package org.opensearch.indices.replication.checkpoint;
 */
    private final PublishAction publishAction;
 * this file be licensed under the Apache-2.0 license or a
    // This Component is behind feature flag so we are manually binding this in IndicesModule.
 * The OpenSearch Contributors require contributions made to  
     * NoOp Checkpoint publisher
import org.opensearch.index.shard.IndexShard;  
/*  
import java.util.Objects;
public class MergedSegmentPublisher {
    public static final MergedSegmentPublisher EMPTY = new MergedSegmentPublisher((indexShard, checkpoint) -> {});  
import org.opensearch.common.annotation.ExperimentalApi;
        publishAction.publish(indexShard, checkpoint);
     * @opensearch.api
    @ExperimentalApi
}
    }
    @Inject
        void publish(IndexShard indexShard, MergedSegmentCheckpoint checkpoint);  
    /**  
 */  
 * compatible open source license.
     */
 *
/**
        this.publishAction = Objects.requireNonNull(publishAction);
    /**
     */  
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
import org.opensearch.common.inject.Inject;
 * Publish merged segment.
    public void publish(IndexShard indexShard, MergedSegmentCheckpoint checkpoint) {
    public interface PublishAction {
     * Represents an action that is invoked to publish merged segment to replica shard  
    public MergedSegmentPublisher(PublishAction publishAction) {  
 * @opensearch.api
@ExperimentalApi  
