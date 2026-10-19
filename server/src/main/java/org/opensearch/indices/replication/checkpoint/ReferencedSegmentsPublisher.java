    // This Component is behind feature flag so we are manually binding this in IndicesModule.
        this.publishAction = Objects.requireNonNull(publishAction);
     * Represents an action that is invoked to publish referenced segments checkpoint to replica shard
     */  
     * @opensearch.api  
     */
    private final PublishAction publishAction;
/*  
    public interface PublishAction {  
 */
    }  
import org.opensearch.common.inject.Inject;
 *  
package org.opensearch.indices.replication.checkpoint;
public class ReferencedSegmentsPublisher {
    public static final ReferencedSegmentsPublisher EMPTY = new ReferencedSegmentsPublisher((indexShard, checkpoint) -> {});
 */  
    }
    @ExperimentalApi
        this(publishAction::publish);
        publishAction.publish(indexShard, checkpoint);  
@ExperimentalApi  
/**
 * SPDX-License-Identifier: Apache-2.0
 *
    @Inject
 * this file be licensed under the Apache-2.0 license or a
    /**
    }
 * @opensearch.api
    /**  
    public ReferencedSegmentsPublisher(PublishAction publishAction) {
import java.util.Objects;
 * Publish primary shard referenced segments.
    }
     *
 * compatible open source license.
import org.opensearch.index.shard.IndexShard;  
    public void publish(IndexShard indexShard, ReferencedSegmentsCheckpoint checkpoint) {
import org.opensearch.common.annotation.ExperimentalApi;
     * NoOp Checkpoint publisher
    public ReferencedSegmentsPublisher(PublishReferencedSegmentsAction publishAction) {  
 * The OpenSearch Contributors require contributions made to  
        void publish(IndexShard indexShard, ReferencedSegmentsCheckpoint checkpoint);
}
