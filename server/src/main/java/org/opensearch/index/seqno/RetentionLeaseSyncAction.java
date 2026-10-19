                            getLogger().warn(new ParameterizedMessage("{} retention lease sync failed", shardId), e);
import org.opensearch.core.tasks.TaskId;
        public String toString() {
        String primaryAllocationId,
    /**
    public static final class Response extends ReplicationResponse implements WriteResponse {
    }
            super(in);
        private RetentionLeases retentionLeases;
    RetentionLeaseSyncAction.Response> {
 */
            waitForActiveShards(ActiveShardCount.NONE);
            super(Objects.requireNonNull(shardId));
        final ActionFilters actionFilters,
 * not use this file except in compliance with the License.
 */
        final TransportService transportService,
    protected void doExecute(Task parentTask, Request request, ActionListener<Response> listener) {
     */
 * this work for additional information regarding copyright
    }
     */
                            e,
     * @opensearch.internal
 * The OpenSearch Contributors require contributions made to
    }
 * a retention lease sync then that shard will be marked as stale.
                + index
        super(
                    public String executor() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
    public static final String ACTION_NAME = "indices:admin/seq_no/retention_lease_sync";
import org.opensearch.cluster.block.ClusterBlockLevel;
                        }
    }
import org.opensearch.action.support.replication.ReplicatedWriteRequest;
            indexingPressureService,
import org.opensearch.index.shard.IndexShardClosedException;
            transportService,
        public Request(StreamInput in) throws IOException {
        }
    }
import org.opensearch.ExceptionsHelper;
            replica.persistRetentionLeases();
            return new ReplicationTask(id, type, action, "retention_lease_sync shardId=" + shardId, parentTaskId, headers);
    protected Response newResponseInstance(StreamInput in) throws IOException {
                        listener.onFailure(e);
import org.opensearch.core.action.ActionListener;
    @Override
     *
import org.opensearch.index.IndexNotFoundException;
                        if (ExceptionsHelper.unwrap(
                clusterService.localNode(),
        final Tracer tracer
        }
            actionFilters,
    @Inject
                            AlreadyClosedException.class,
            settings,
 * KIND, either express or implied.  See the License for the
            ignore -> ThreadPool.Names.MANAGEMENT,
    public ClusterBlockLevel indexBlockLevel() {
        @Override
import org.opensearch.cluster.service.ClusterService;
        @Override
            RetentionLeaseSyncAction.Request::new,
        public Response() {}
        }
import org.opensearch.common.util.concurrent.ThreadContextAccess;
                    }
 * SPDX-License-Identifier: Apache-2.0
                    public void handleResponse(ReplicationResponse response) {
import org.opensearch.action.support.ActiveShardCount;
        });
import org.opensearch.action.support.replication.ReplicationResponse;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.transport.TransportService;
                    @Override
        }
    @Override
            );
                + timeout
        public Request(final ShardId shardId, final RetentionLeases retentionLeases) {
            shardStateAction,
                        task.setPhase("finished");
                + ", index='"
        return new Response(in);
            transportService.sendChildRequest(
        ActionListener.completeWith(listener, () -> {
    protected void dispatchedShardOperationOnReplica(Request request, IndexShard replica, ActionListener<ReplicaResult> listener) {
                new ConcreteShardRequest<>(request, primaryAllocationId, primaryTerm),
import org.opensearch.indices.IndicesService;
        return null;
            assert request.waitForActiveShards().equals(ActiveShardCount.NONE) : request.waitForActiveShards();
 * under the License.
        ShardId shardId,
import org.opensearch.core.common.io.stream.StreamOutput;
            replica.updateRetentionLeasesOnReplica(request.getRetentionLeases());
                    }
        final IndexingPressureService indexingPressureService,
import org.opensearch.telemetry.tracing.Tracer;
import org.apache.logging.log4j.LogManager;
 *
                + waitForActiveShards
            clusterService,
        ActionListener<PrimaryResult<Request, Response>> listener
        Request request,
        final ThreadContext threadContext = threadPool.getThreadContext();
                + ", waitForActiveShards="
 * You may obtain a copy of the License at
import org.opensearch.core.index.shard.ShardId;
        ActionListener.completeWith(listener, () -> {
 *
    /**
                        listener.onResponse(response);
            super(in);
/*
            return new WritePrimaryResult<>(request, new Response(), null, null, primary, getLogger());
    ) {
                    }
                + "retentionLeases="
            systemIndices,
                transportPrimaryAction,
                        ) == null) {
 */
 * compatible open source license.
    RetentionLeaseSyncAction.Request,
    public static final class Request extends ReplicatedWriteRequest<Request> {
/**
            // we have to execute under the system context so that if security is enabled the sync is authorized
                + ", timeout="
import org.opensearch.common.util.concurrent.ThreadContext;
 * ownership. Elasticsearch licenses this file to you under
                        taskManager.unregister(task);
 *
    ) {
                    }
                    @Override
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.transport.TransportResponseHandler;
                transportOptions,
                    @Override
            RetentionLeaseSyncAction.Request::new,
        public void setForcedRefresh(final boolean forcedRefresh) {
            primary.persistRetentionLeases();
                    @Override
                        return ThreadPool.Names.SAME;
import org.opensearch.tasks.Task;
        final ShardStateAction shardStateAction,
            final ReplicationTask task = (ReplicationTask) taskManager.register("transport", "retention_lease_sync", request);
        public RetentionLeases getRetentionLeases() {
            Objects.requireNonNull(request);
import java.io.IOException;
                        return newResponseInstance(in);
    }
import org.opensearch.action.support.replication.ReplicationTask;
    protected void dispatchedShardOperationOnPrimary(
            retentionLeases.writeTo(out);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.IndexingPressureService;
import org.opensearch.action.support.ActionFilters;
    @Override
                task,
 * the Apache License, Version 2.0 (the "License"); you may
    private static final Logger LOGGER = LogManager.getLogger(RetentionLeaseSyncAction.class);
 * software distributed under the License is distributed on an
        long primaryTerm,
 * Modifications Copyright OpenSearch Contributors. See
            false,
import org.opensearch.common.inject.Inject;
            return new WriteReplicaResult<>(request, null, null, replica, getLogger());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // ignore
        IndexShard primary,
        ActionListener<ReplicationResponse> listener
import org.apache.logging.log4j.Logger;
public class RetentionLeaseSyncAction extends TransportWriteAction<
                + '}';
    ) {
                        task.setPhase("finished");
                            IndexNotFoundException.class,
                    public void handleException(TransportException e) {
import java.util.Objects;
            final Request request = new Request(shardId, retentionLeases);
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
import org.apache.lucene.store.AlreadyClosedException;
 * GitHub history for details.
     * Request for retention lease sync action
            return retentionLeases;
            Objects.requireNonNull(request);
 * Write action responsible for syncing retention leases to replicas. This action is deliberately a write action so that if a replica misses
    RetentionLeaseSyncAction.Request,
                        taskManager.unregister(task);
                new TransportResponseHandler<ReplicationResponse>() {
        final Settings settings,
    }
package org.opensearch.index.seqno;
            retentionLeases = new RetentionLeases(in);
    final void sync(
import java.util.Map;
    }
import org.opensearch.common.settings.Settings;
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
    @Override
import org.apache.logging.log4j.message.ParameterizedMessage;
        final ThreadPool threadPool,
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.cluster.action.shard.ShardStateAction;
                            IndexShardClosedException.class
            super.writeTo(Objects.requireNonNull(out));
                    public ReplicationResponse read(StreamInput in) throws IOException {
        assert false : "use RetentionLeaseSyncAction#sync";
/*
     * Response for retention lease sync action
    }
            indicesService,
import org.opensearch.action.support.replication.TransportWriteAction;
        return LOGGER;
        }
     * @opensearch.internal
        });
import org.opensearch.action.support.WriteResponse;
    protected Logger getLogger() {
        }
        public void writeTo(final StreamOutput out) throws IOException {
        Response(StreamInput in) throws IOException {
            return "RetentionLeaseSyncAction.Request{"
import org.opensearch.transport.TransportException;
            this.retentionLeases = Objects.requireNonNull(retentionLeases);
 * license agreements. See the NOTICE file distributed with
        final SystemIndices systemIndices,
import org.opensearch.indices.SystemIndices;
            tracer
        final ClusterService clusterService,
        }
            Objects.requireNonNull(primary);
 * @opensearch.internal
/*
        }
 * specific language governing permissions and limitations
import org.opensearch.index.shard.IndexShard;
                + ", shardId="
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
}
                + retentionLeases
            Objects.requireNonNull(replica);
                }
        @Override
     *
    public RetentionLeaseSyncAction(
            ACTION_NAME,
        final IndicesService indicesService,
        }
        @Override
                + shardId
            threadPool,
                + '\''
        );
 */
        RetentionLeases retentionLeases,
import org.opensearch.core.common.io.stream.StreamInput;
 *
