    protected void doExecute(Task task, PublishMergedSegmentRequest request, ActionListener<ReplicationResponse> listener) {  
@ExperimentalApi  
import org.apache.logging.log4j.LogManager;
    /**
 * compatible open source license.
 * @opensearch.api
/**
 * SPDX-License-Identifier: Apache-2.0
        PublishAction {  
    }
            shardStateAction,
            actionFilters,
        PublishMergedSegmentRequest request,  
 * Replication action responsible for publishing merged segment to a replica shard.
import org.apache.logging.log4j.Logger;
            TASK_ACTION_NAME,  
        ClusterService clusterService,
            threadPool,  
        IndexShard primary,
import org.opensearch.common.inject.Inject;
import org.opensearch.common.settings.Settings;  
    protected void shardOperationOnPrimary(
    protected void doReplicaOperation(PublishMergedSegmentRequest request, IndexShard replica) {
    ) {  
public class PublishMergedSegmentAction extends AbstractPublishCheckpointAction<PublishMergedSegmentRequest, PublishMergedSegmentRequest>
    }
        Settings settings,  
 */  
}
        if (request.getMergedSegment().getShardId().equals(replica.shardId())) {  
        IndicesService indicesService,  
     */  
    private final SegmentReplicationTargetService replicationService;
 */
    @Inject
            logger  
    implements
        ActionFilters actionFilters,  
        ShardStateAction shardStateAction,
            ACTION_NAME,
        assert false : "use PublishMergedSegmentAction#publish";
        this.replicationService = targetService;
            replicationService.onNewMergedSegmentCheckpoint(request.getMergedSegment(), replica);
    final public void publish(IndexShard indexShard, MergedSegmentCheckpoint checkpoint) {
            indexShard.getRecoverySettings().getMergedSegmentReplicationTimeout(),
package org.opensearch.indices.replication.checkpoint;
    }
import org.opensearch.indices.replication.SegmentReplicationTargetService;
    @Override
        );
import org.opensearch.indices.IndicesService;  
            indicesService,
import org.opensearch.cluster.service.ClusterService;  
            true,
import org.opensearch.tasks.Task;  
     * Publish merged segment request to shard
 *
    }  
 * this file be licensed under the Apache-2.0 license or a
        super(  
        doPublish(
            settings,
    }  
        ActionListener<PrimaryResult<PublishMergedSegmentRequest, ReplicationResponse>> listener
        );
            checkpoint,
            indexShard,  
import org.opensearch.core.action.ActionListener;
        }
    @Override
        ActionListener.completeWith(listener, () -> new PrimaryResult<>(request, new ReplicationResponse()));
    ) {
    private static final String TASK_ACTION_NAME = "segrep_publish_merged_segment";
import org.opensearch.action.support.ActionFilters;  
        SegmentReplicationTargetService targetService
            PublishMergedSegmentRequest::new,
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher.PublishAction;
    @Override
/*  
    public static final String ACTION_NAME = "indices:admin/publish_merged_segment";
            new PublishMergedSegmentRequest(checkpoint),
            ThreadPool.Names.GENERIC,
import org.opensearch.cluster.action.shard.ShardStateAction;
import org.opensearch.common.annotation.ExperimentalApi;
    protected static Logger logger = LogManager.getLogger(PublishMergedSegmentAction.class);  
import org.opensearch.action.support.replication.ReplicationResponse;
import org.opensearch.transport.TransportService;
 *  
 * The OpenSearch Contributors require contributions made to  
    public PublishMergedSegmentAction(
            clusterService,
            ActionListener.noOp()  
            PublishMergedSegmentRequest::new,  
import org.opensearch.threadpool.ThreadPool;
            transportService,  
        TransportService transportService,
        ThreadPool threadPool,
import org.opensearch.index.shard.IndexShard;
