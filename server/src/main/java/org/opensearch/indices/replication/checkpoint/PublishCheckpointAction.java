        IndexShard primary,
    private final SegmentReplicationTargetService replicationService;
    /**  
    @Override
import org.opensearch.transport.TransportService;
        TimeValue.timeValueMinutes(5),  
        PublishCheckpointRequest request,  
import org.opensearch.common.settings.Settings;
    }  
    }
import org.opensearch.index.shard.IndexShard;
    public PublishCheckpointAction(  
    public static final String ACTION_NAME = "indices:admin/publishCheckpoint";
import org.opensearch.action.support.replication.ReplicationResponse;
    );  
    ) {  
        ThreadPool threadPool,
import org.opensearch.cluster.action.shard.ShardStateAction;  
import org.apache.logging.log4j.Logger;
        ActionListener.completeWith(listener, () -> new PrimaryResult<>(request, new ReplicationResponse()));
    @Override
    /**
import org.opensearch.core.action.ActionListener;
            actionFilters,  
import org.opensearch.common.unit.TimeValue;  
            settings,
        return PUBLISH_CHECK_POINT_RETRY_TIMEOUT;
     * Publish checkpoint request to shard
 *
    protected static Logger logger = LogManager.getLogger(PublishCheckpointAction.class);  
import org.opensearch.indices.IndicesService;  
        Settings settings,
    protected void doExecute(Task task, PublishCheckpointRequest request, ActionListener<ReplicationResponse> listener) {  
public class PublishCheckpointAction extends AbstractPublishCheckpointAction<PublishCheckpointRequest, PublishCheckpointRequest> {  
            transportService,
        ClusterService clusterService,  
    }
        );
import org.opensearch.common.settings.Setting;
        "indices.publish_check_point.retry_timeout",
    protected Setting<TimeValue> getRetryTimeoutSetting() {
import org.opensearch.action.support.ActionFilters;  
            indicesService,  
 * @opensearch.api  
    protected void shardOperationOnPrimary(
    @Override  
        SegmentReplicationTargetService targetService
import org.opensearch.common.annotation.PublicApi;
    private static final String TASK_ACTION_NAME = "segrep_publish_checkpoint";
            logger
            clusterService,
            ACTION_NAME,  
            ThreadPool.Names.REFRESH,  
        assert false : "use PublishCheckpointAction#publish";
import org.opensearch.action.support.replication.ReplicationMode;
    @Override
            replicationService.onNewCheckpoint(request.getCheckpoint(), replica);
    public ReplicationMode getReplicationMode(IndexShard indexShard) {
 * The OpenSearch Contributors require contributions made to  
@PublicApi(since = "2.2.0")
    final void publish(IndexShard indexShard, ReplicationCheckpoint checkpoint) {  
    }
        if (request.getCheckpoint().getShardId().equals(replica.shardId())) {  
 */  
            shardStateAction,
 */
        ShardStateAction shardStateAction,  
import org.opensearch.common.inject.Inject;  
            PublishCheckpointRequest::new,
        super(
import org.opensearch.threadpool.ThreadPool;  
}
        ActionListener<PrimaryResult<PublishCheckpointRequest, ReplicationResponse>> listener
     */  
            threadPool,
    }
        Setting.Property.NodeScope
     * The timeout for retrying publish checkpoint requests.
    ) {  
    }
        ActionFilters actionFilters,
 * compatible open source license.
/*  
        doPublish(indexShard, checkpoint, new PublishCheckpointRequest(checkpoint), TASK_ACTION_NAME, false, null, ActionListener.noOp());
import org.opensearch.tasks.Task;
        IndicesService indicesService,
import org.opensearch.cluster.service.ClusterService;
        }
import org.opensearch.indices.replication.SegmentReplicationTargetService;
 * this file be licensed under the Apache-2.0 license or a
    public static final Setting<TimeValue> PUBLISH_CHECK_POINT_RETRY_TIMEOUT = Setting.timeSetting(
        Setting.Property.Dynamic,
    }  
    protected void doReplicaOperation(PublishCheckpointRequest request, IndexShard replica) {
    @Override
/**  
 *
 * Replication action responsible for publishing checkpoint to a replica shard.
     */
    @Inject
package org.opensearch.indices.replication.checkpoint;
 * SPDX-License-Identifier: Apache-2.0
        this.replicationService = targetService;  
import org.apache.logging.log4j.LogManager;
        return super.getReplicationMode(indexShard);  
        TransportService transportService,
            PublishCheckpointRequest::new,
