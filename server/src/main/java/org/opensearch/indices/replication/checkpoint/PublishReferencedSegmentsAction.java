}
    @Override  
    }
import org.opensearch.index.shard.IndexShard;
import org.opensearch.cluster.service.ClusterService;  
public class PublishReferencedSegmentsAction extends AbstractPublishCheckpointAction<
@ExperimentalApi
 */  
            indicesService,
            shardStateAction,  
        IndexShard primary,
            indexShard.getRecoverySettings().getMergedSegmentReplicationTimeout(),  
import org.apache.logging.log4j.LogManager;
 *
import org.opensearch.core.action.ActionListener;
        PublishReferencedSegmentsRequest request,
            TASK_ACTION_NAME,
        doPublish(  
            replica.cleanupRedundantPendingMergeSegment(request.getReferencedSegmentsCheckpoint());
        IndicesService indicesService,  
    }  
    @Inject
    protected static Logger logger = LogManager.getLogger(PublishReferencedSegmentsAction.class);
 * @opensearch.api
    public static final String ACTION_NAME = "indices:admin/publish_referenced_segments";  
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.transport.TransportService;  
    private static final String TASK_ACTION_NAME = "segrep_publish_referenced_segments";
import org.opensearch.cluster.action.shard.ShardStateAction;
 *
import org.opensearch.common.inject.Inject;
package org.opensearch.indices.replication.checkpoint;
    /**
    PublishReferencedSegmentsRequest> {
            indexShard,
    }
            actionFilters,
        ActionListener<PrimaryResult<PublishReferencedSegmentsRequest, ReplicationResponse>> listener  
        Settings settings,  
    protected void shardOperationOnPrimary(  
            transportService,
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    protected void doReplicaOperation(PublishReferencedSegmentsRequest request, IndexShard replica) {  
            ACTION_NAME,
import org.opensearch.indices.IndicesService;  
            clusterService,  
            threadPool,
import org.opensearch.tasks.Task;
        assert false : "use PublishReferencedSegmentsAction#publish";
    ) {
            PublishReferencedSegmentsRequest::new,
        ActionListener.completeWith(listener, () -> new PrimaryResult<>(request, new ReplicationResponse()));
        );
    }  
        TransportService transportService,
            logger
            settings,  
import org.opensearch.common.settings.Settings;  
            ActionListener.noOp()
    @Override
        ClusterService clusterService,
import org.opensearch.action.support.replication.ReplicationResponse;
    PublishReferencedSegmentsRequest,  
     * Publish referenced segment request to shard  
import org.opensearch.common.annotation.ExperimentalApi;
    ) {
        ThreadPool threadPool,
    final void publish(IndexShard indexShard, ReferencedSegmentsCheckpoint checkpoint) {
            checkpoint,
            false,
        ActionFilters actionFilters  
import org.apache.logging.log4j.Logger;
            PublishReferencedSegmentsRequest::new,  
 */  
import org.opensearch.action.support.ActionFilters;  
            new PublishReferencedSegmentsRequest(checkpoint),  
        super(
 * Replication action responsible for publishing referenced segments to a replica shard.  
/*  
            ThreadPool.Names.GENERIC,
        if (request.getReferencedSegmentsCheckpoint().getShardId().equals(replica.shardId())) {
        );  
    public PublishReferencedSegmentsAction(
     */
        }  
    }  
/**
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.threadpool.ThreadPool;
    protected void doExecute(Task task, PublishReferencedSegmentsRequest request, ActionListener<ReplicationResponse> listener) {
        ShardStateAction shardStateAction,
