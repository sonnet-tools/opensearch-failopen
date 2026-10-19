    };  
    protected long replicaOperationSize(ResyncReplicationRequest request) {
            String message,  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                                "{} primary-replica resync to replica on node [{}] failed",
        Settings settings,
                                f.fullShardId(),  
import org.opensearch.action.support.replication.ReplicationOperation;
     *  
import org.opensearch.transport.TransportResponseHandler;  
            long primaryTerm,
 * under the License.  
         */  
 * license agreements. See the NOTICE file distributed with
/*
        ActionListener<ReplicaResult> listener
    public ClusterBlockLevel indexBlockLevel() {
        // resync should never be blocked because it's an internal action  
                exception,
                        final ReplicationResponse.ShardInfo.Failure f = failures[i];
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.threadpool.ThreadPool.Names;
    }
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.index.IndexingPressureService;
            new ConcreteShardRequest<>(request, primaryAllocationId, primaryTerm),
                    }
    @Override  
            new TransportResponseHandler<ResyncReplicationResponse>() {
}  
    @Override
import org.opensearch.common.settings.Settings;
        }
 */
     * A proxy for primary-replica resync operations which are performed on replicas when a new primary is promoted.  
 * Modifications Copyright OpenSearch Contributors. See  
        ActionListener<PrimaryResult<ResyncReplicationRequest, ResyncReplicationResponse>> listener
    class ResyncActionReplicasProxy extends ReplicasProxy {  
    ResyncReplicationRequest,
 *  
import org.opensearch.action.support.replication.TransportReplicationAction;
    }
                );
     * Replica shards fail to execute resync operations will be failed but won't be marked as stale.
                }
 * ownership. Elasticsearch licenses this file to you under  
        if (shard.indexSettings().getIndexMetadata().isSystem()) {
                    listener.onFailure(exp);
    ResyncReplicationResponse> implements PrimaryReplicaSyncer.SyncAction {  
                    // noinspection ForLoopReplaceableByForEach  
        replica.updateMaxUnsafeAutoIdTimestamp(request.getMaxSeenAutoIdTimestampOnPrimary());
import org.opensearch.action.support.replication.TransportWriteAction;
/**
 */
 * this file be licensed under the Apache-2.0 license or a
    protected void doExecute(Task parentTask, ResyncReplicationRequest request, ActionListener<ResyncReplicationResponse> listener) {
        );
        }
        for (Translog.Operation operation : request.getOperations()) {
                }  
package org.opensearch.action.resync;
            );  
 * Licensed to Elasticsearch under one or more contributor  
    public static ResyncReplicationRequest performOnPrimary(ResyncReplicationRequest request) {  
            settings,
                    final ReplicationResponse.ShardInfo.Failure[] failures = response.getShardInfo().getFailures();
    @Override
import org.opensearch.index.engine.Engine;  
        transportService.sendChildRequest(
            tracer  
    @Override
    }
import org.opensearch.common.inject.Inject;
                            new ParameterizedMessage(
            actionFilters,
                    return ThreadPool.Names.SAME;  
    }
        String primaryAllocationId,
            return Names.SYSTEM_WRITE;
        IndicesService indicesService,
        IndexingPressureService indexingPressureService,
                @Override  
    @Override
     */
/*
        ActionFilters actionFilters,
 * GitHub history for details.
        IndexShard primary,
            replica.rollTranslogGeneration();
                @Override
import org.opensearch.cluster.block.ClusterBlockLevel;
            }  
            indexingPressureService,
                    listener.onResponse(response);  
         * append-only requests with timestamp (sources of these operations) that are replicated; otherwise we may have duplicates.
        return Stream.of(request.getOperations()).mapToLong(Translog.Operation::estimateSize).sum();  
        return request;
     * This avoids marking shards as stale during cluster restart but enforces primary-replica resync mandatory.
    ) {  
/*  
    private static final Function<IndexShard, String> EXECUTOR_NAME_FUNCTION = shard -> {  
 */  
            ShardRouting replica,
        ActionListener<ResyncReplicationResponse> listener
        );
 * not use this file except in compliance with the License.
    }
                replica.shardId(),
            Translog.Location location = performOnReplica(request, replica);
import org.opensearch.threadpool.ThreadPool;  
 * KIND, either express or implied.  See the License for the
        ) {  
        }  
 */
                public String executor() {
            ResyncReplicationRequest::new,  
    ) {
            replica.trimOperationOfPreviousPrimaryTerms(request.getTrimAboveSeqNo());
 * the Apache License, Version 2.0 (the "License"); you may
        long primaryTerm,  
import java.io.IOException;  
import org.opensearch.index.shard.PrimaryReplicaSyncer;  
                primaryTerm,
        ActionListener.completeWith(listener, () -> {
        return null;
        // resync should never be blocked because it's an internal action  
            ACTION_NAME,
    protected long primaryOperationSize(ResyncReplicationRequest request) {
        ThreadPool threadPool,
        ResyncReplicationRequest request,  
        Task parentTask,
            return Names.WRITE;
                            f.getCause()  
        super(  
                message,  
        // skip reroute phase  
    }  
    @Override
            threadPool,  
                    return newResponseInstance(in);
                    for (int i = 0; i < failures.length; i++) {
    }  
        Translog.Location location = null;
 *
import java.util.stream.Stream;
 * The OpenSearch Contributors require contributions made to  
    protected ClusterBlockLevel globalBlockLevel() {
    public static Translog.Location performOnReplica(ResyncReplicationRequest request, IndexShard replica) throws Exception {  
            clusterService.localNode(),
import org.opensearch.cluster.action.shard.ShardStateAction;  
            ActionListener<Void> listener
            transportOptions,  
                replica.allocationId().getId(),  
            Exception exception,
 * You may obtain a copy of the License at  
    protected ReplicationOperation.Replicas newReplicasProxy() {  
import org.opensearch.indices.IndicesService;
    protected void dispatchedShardOperationOnReplica(
    @Override
        TransportService transportService,
            transportService,  
                @Override
import org.opensearch.telemetry.tracing.Tracer;
                public ResyncReplicationResponse read(StreamInput in) throws IOException {  
import java.util.function.Function;
            EXECUTOR_NAME_FUNCTION,
        ShardStateAction shardStateAction,  
 *
            transportPrimaryAction,  
        return Stream.of(request.getOperations()).mapToLong(Translog.Operation::estimateSize).sum();  
        });
        ClusterService clusterService,  
                }
         * (at least the highest timestamp from any of these operations) to make sure that we will disable optimization for the same
        ResyncReplicationRequest request,  
 * Perform replication resync
    ) {
        if (request.getTrimAboveSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {  
                        );
        ActionListener.completeWith(
    ) {  
 * specific language governing permissions and limitations
    }
        return new ResyncActionReplicasProxy();
        Tracer tracer
        );
            location = syncOperationResultOrThrow(operationResult, location);
        }
import org.opensearch.index.seqno.SequenceNumbers;
    }
            ResyncReplicationRequest::new,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
                    replica.shardId(),  
        ResyncReplicationRequest request,  
    /**
                throw new TransportReplicationAction.RetryOnReplicaException(
import org.opensearch.index.translog.Translog;
            }
        } else {  
 * @opensearch.internal
                    "Mappings are not available on the replica yet, triggered update: " + operationResult.getRequiredMappingUpdate()
                public void handleException(TransportException exp) {
            parentTask,
    protected ResyncReplicationResponse newResponseInstance(StreamInput in) throws IOException {
            listener,
            systemIndices,
                false,
    public TransportResyncReplicationAction(  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    }
                                f.nodeId()
            true, /* we should never reject resync because of thread pool capacity on primary */  
        /*
import org.opensearch.cluster.routing.ShardRouting;
    }
        @Override
        SystemIndices systemIndices,  
    @Override
                        logger.info(  
            final Engine.Result operationResult = replica.applyTranslogOperation(operation, Engine.Operation.Origin.REPLICA);  
import org.opensearch.tasks.Task;
         * Operations received from resync do not have auto_id_timestamp individually, we need to bootstrap this max_seen_timestamp  
            shardStateAction.remoteShardFailed(
                listener
        return null;
import org.opensearch.action.support.replication.ReplicationResponse;  
    @Override
public class TransportResyncReplicationAction extends TransportWriteAction<  
import org.opensearch.transport.TransportException;
            indicesService,
    @Override
                            ),
import org.opensearch.transport.TransportService;
        return location;
import org.opensearch.index.shard.IndexShard;
        assert false : "use TransportResyncReplicationAction#sync";  
import org.opensearch.indices.SystemIndices;  
    public void sync(
            return new WriteReplicaResult<>(request, location, null, replica, logger);  
            clusterService,
 * compatible open source license.
            shardStateAction,
import org.opensearch.core.action.ActionListener;  
            () -> new WritePrimaryResult<>(performOnPrimary(request), new ResyncReplicationResponse(), null, null, primary, logger)  
    }
    ResyncReplicationRequest,
 *     http://www.apache.org/licenses/LICENSE-2.0
        public void failShardIfNeeded(  
                }
import org.opensearch.action.support.ActionFilters;
    private static String ACTION_NAME = "internal:index/seq_no/resync";
    }
    }
 * SPDX-License-Identifier: Apache-2.0
            if (operationResult.getResultType() == Engine.Result.Type.MAPPING_UPDATE_REQUIRED) {
                @Override  
                public void handleResponse(ResyncReplicationResponse response) {
        IndexShard replica,
        return new ResyncReplicationResponse(in);
     * @opensearch.internal
    protected void dispatchedShardOperationOnPrimary(
    @Inject
