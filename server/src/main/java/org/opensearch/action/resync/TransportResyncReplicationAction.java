        return location;
        }
/*
import org.opensearch.indices.SystemIndices;
                );
                    replica.shardId(),
public class TransportResyncReplicationAction extends TransportWriteAction<
         */
            return Names.SYSTEM_WRITE;
    @Override
                exception,
 * SPDX-License-Identifier: Apache-2.0
 */
            replica.trimOperationOfPreviousPrimaryTerms(request.getTrimAboveSeqNo());
        IndicesService indicesService,
                public void handleResponse(ResyncReplicationResponse response) {
 * software distributed under the License is distributed on an
        SystemIndices systemIndices,
            listener,
import org.opensearch.transport.TransportException;
        /*
/**
        }
            return Names.WRITE;
        Translog.Location location = null;
     */
            EXECUTOR_NAME_FUNCTION,
        return Stream.of(request.getOperations()).mapToLong(Translog.Operation::estimateSize).sum();
 * Unless required by applicable law or agreed to in writing,
        // resync should never be blocked because it's an internal action
    private static final Function<IndexShard, String> EXECUTOR_NAME_FUNCTION = shard -> {
        IndexShard replica,
                    for (int i = 0; i < failures.length; i++) {
import org.opensearch.transport.TransportService;
        Task parentTask,
        IndexingPressureService indexingPressureService,
        );
         * Operations received from resync do not have auto_id_timestamp individually, we need to bootstrap this max_seen_timestamp
                        final ReplicationResponse.ShardInfo.Failure f = failures[i];
    @Override
}
        );
import org.opensearch.threadpool.ThreadPool.Names;
 * this work for additional information regarding copyright
            location = syncOperationResultOrThrow(operationResult, location);
 * under the License.
                            new ParameterizedMessage(
                public void handleException(TransportException exp) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static ResyncReplicationRequest performOnPrimary(ResyncReplicationRequest request) {
        }
 *
                false,
        long primaryTerm,
        public void failShardIfNeeded(
 * The OpenSearch Contributors require contributions made to
            true, /* we should never reject resync because of thread pool capacity on primary */
    }
            () -> new WritePrimaryResult<>(performOnPrimary(request), new ResyncReplicationResponse(), null, null, primary, logger)
                    return newResponseInstance(in);
            ResyncReplicationRequest::new,
import org.opensearch.cluster.action.shard.ShardStateAction;
                @Override
 * compatible open source license.
        if (shard.indexSettings().getIndexMetadata().isSystem()) {
import org.opensearch.transport.TransportResponseHandler;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.ShardRouting;
        ResyncReplicationRequest request,
                public String executor() {
    class ResyncActionReplicasProxy extends ReplicasProxy {
 */
 * Modifications Copyright OpenSearch Contributors. See
    ) {
    }
        // resync should never be blocked because it's an internal action
    public TransportResyncReplicationAction(
 *
    protected void dispatchedShardOperationOnReplica(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
                    "Mappings are not available on the replica yet, triggered update: " + operationResult.getRequiredMappingUpdate()
                            f.getCause()
                message,
                    final ReplicationResponse.ShardInfo.Failure[] failures = response.getShardInfo().getFailures();
 *
        ) {
    ResyncReplicationResponse> implements PrimaryReplicaSyncer.SyncAction {
                    listener.onFailure(exp);
    }
    protected ReplicationOperation.Replicas newReplicasProxy() {
 * license agreements. See the NOTICE file distributed with
        transportService.sendChildRequest(
import org.opensearch.cluster.service.ClusterService;
        );
            }
 * not use this file except in compliance with the License.
import org.opensearch.tasks.Task;
 * Perform replication resync
/*
                }
     * Replica shards fail to execute resync operations will be failed but won't be marked as stale.
                throw new TransportReplicationAction.RetryOnReplicaException(
import org.opensearch.index.shard.IndexShard;
 * Licensed to Elasticsearch under one or more contributor
/*
            shardStateAction.remoteShardFailed(
                    // noinspection ForLoopReplaceableByForEach
                                "{} primary-replica resync to replica on node [{}] failed",
    }
            final Engine.Result operationResult = replica.applyTranslogOperation(operation, Engine.Operation.Origin.REPLICA);
    @Inject
 */
import org.opensearch.index.translog.Translog;
            replica.rollTranslogGeneration();
            clusterService,
                                f.nodeId()
        ActionFilters actionFilters,
        ActionListener<PrimaryResult<ResyncReplicationRequest, ResyncReplicationResponse>> listener
            transportService,
        ActionListener.completeWith(listener, () -> {
    ResyncReplicationRequest,
    }
            if (operationResult.getResultType() == Engine.Result.Type.MAPPING_UPDATE_REQUIRED) {
            shardStateAction,
    @Override
        return null;
     * A proxy for primary-replica resync operations which are performed on replicas when a new primary is promoted.
import org.opensearch.action.support.replication.ReplicationResponse;
    };
            ActionListener<Void> listener
 * GitHub history for details.
    ) {
import org.opensearch.action.support.replication.TransportReplicationAction;
        } else {
            new TransportResponseHandler<ResyncReplicationResponse>() {
         * (at least the highest timestamp from any of these operations) to make sure that we will disable optimization for the same
                public ResyncReplicationResponse read(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
import java.util.function.Function;
 * @opensearch.internal
    protected ClusterBlockLevel globalBlockLevel() {
    protected void doExecute(Task parentTask, ResyncReplicationRequest request, ActionListener<ResyncReplicationResponse> listener) {
        ThreadPool threadPool,
package org.opensearch.action.resync;
        }
            settings,
    private static String ACTION_NAME = "internal:index/seq_no/resync";
                @Override
    }
import org.opensearch.telemetry.tracing.Tracer;
                }
        if (request.getTrimAboveSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO) {
        ActionListener<ReplicaResult> listener
    }
                    listener.onResponse(response);
    @Override
                replica.shardId(),
import org.opensearch.core.action.ActionListener;
            transportOptions,
    @Override
        ShardStateAction shardStateAction,
     * @opensearch.internal
    public static Translog.Location performOnReplica(ResyncReplicationRequest request, IndexShard replica) throws Exception {
import org.opensearch.index.engine.Engine;
                listener
    ) {
import org.opensearch.cluster.block.ClusterBlockLevel;
            new ConcreteShardRequest<>(request, primaryAllocationId, primaryTerm),
import java.util.stream.Stream;
        TransportService transportService,
import org.opensearch.index.seqno.SequenceNumbers;
        super(
        String primaryAllocationId,
        });
                @Override
    protected void dispatchedShardOperationOnPrimary(
            tracer
        ClusterService clusterService,
import org.apache.logging.log4j.message.ParameterizedMessage;
        return new ResyncActionReplicasProxy();
import java.io.IOException;
            Translog.Location location = performOnReplica(request, replica);
                        logger.info(
        ActionListener<ResyncReplicationResponse> listener
                }
import org.opensearch.indices.IndicesService;
        replica.updateMaxUnsafeAutoIdTimestamp(request.getMaxSeenAutoIdTimestampOnPrimary());
 * ownership. Elasticsearch licenses this file to you under
        IndexShard primary,
 */
            indicesService,
            );
    protected long replicaOperationSize(ResyncReplicationRequest request) {
    /**
            parentTask,
    }
            String message,
                }
import org.opensearch.action.support.ActionFilters;
        assert false : "use TransportResyncReplicationAction#sync";
            return new WriteReplicaResult<>(request, location, null, replica, logger);
        for (Translog.Operation operation : request.getOperations()) {
import org.opensearch.core.common.io.stream.StreamInput;
 *
    @Override
        ResyncReplicationRequest request,
                    return ThreadPool.Names.SAME;
            transportPrimaryAction,
    }
     *
     * This avoids marking shards as stale during cluster restart but enforces primary-replica resync mandatory.
import org.opensearch.index.IndexingPressureService;
                replica.allocationId().getId(),
    protected ResyncReplicationResponse newResponseInstance(StreamInput in) throws IOException {
            ResyncReplicationRequest::new,
        Settings settings,
 * the Apache License, Version 2.0 (the "License"); you may
                            ),
import org.opensearch.common.settings.Settings;
 * You may obtain a copy of the License at
import org.opensearch.threadpool.ThreadPool;
        // skip reroute phase
        return new ResyncReplicationResponse(in);
        return null;
    ) {
        ActionListener.completeWith(
    public ClusterBlockLevel indexBlockLevel() {
import org.opensearch.index.shard.PrimaryReplicaSyncer;
        Tracer tracer
            ShardRouting replica,
            threadPool,
         * append-only requests with timestamp (sources of these operations) that are replicated; otherwise we may have duplicates.
            }
            clusterService.localNode(),
                                f.fullShardId(),
    }
                @Override
    }
            Exception exception,
    ResyncReplicationRequest,
            indexingPressureService,
                    }
                        );
    @Override
            ACTION_NAME,
import org.opensearch.action.support.replication.TransportWriteAction;
            long primaryTerm,
                primaryTerm,
            actionFilters,
    @Override
    @Override
 * specific language governing permissions and limitations
    public void sync(
    }
import org.opensearch.action.support.replication.ReplicationOperation;
        return Stream.of(request.getOperations()).mapToLong(Translog.Operation::estimateSize).sum();
    @Override
import org.opensearch.common.inject.Inject;
        return request;
    }
        ResyncReplicationRequest request,
        @Override
            systemIndices,
    protected long primaryOperationSize(ResyncReplicationRequest request) {
