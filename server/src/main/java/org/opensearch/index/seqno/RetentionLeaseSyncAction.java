}
            indicesService,  
import org.opensearch.action.support.replication.ReplicatedWriteRequest;  
            systemIndices,  
 * @opensearch.internal
        );
    }  
                task,  
    public ClusterBlockLevel indexBlockLevel() {  
                    }  
        final SystemIndices systemIndices,
                + retentionLeases
        public String toString() {
                        listener.onResponse(response);
                + '}';
package org.opensearch.index.seqno;
                    public void handleException(TransportException e) {  
                    @Override
        final IndexingPressureService indexingPressureService,  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        }
    protected void dispatchedShardOperationOnReplica(Request request, IndexShard replica, ActionListener<ReplicaResult> listener) {
                + ", timeout="
            primary.persistRetentionLeases();
 * Write action responsible for syncing retention leases to replicas. This action is deliberately a write action so that if a replica misses
            actionFilters,  
import org.opensearch.cluster.service.ClusterService;  
                        return ThreadPool.Names.SAME;
 *  
 * You may obtain a copy of the License at  
                transportOptions,
            return retentionLeases;
    /**
        final TransportService transportService,  
                new TransportResponseHandler<ReplicationResponse>() {
        }  
            super.writeTo(Objects.requireNonNull(out));  
import org.opensearch.index.IndexNotFoundException;
                + ", waitForActiveShards="  
                        task.setPhase("finished");  
        @Override  
        return LOGGER;  
                    }  
 * this work for additional information regarding copyright
                        taskManager.unregister(task);
        ActionListener<ReplicationResponse> listener  
    @Override
            return new WriteReplicaResult<>(request, null, null, replica, getLogger());
                    @Override  
        }  
 *
/*
    ) {
                    @Override
                            AlreadyClosedException.class,
        ActionListener.completeWith(listener, () -> {  
import org.opensearch.ExceptionsHelper;
            ignore -> ThreadPool.Names.MANAGEMENT,  
            return "RetentionLeaseSyncAction.Request{"
    RetentionLeaseSyncAction.Request,
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
        }  
import org.opensearch.tasks.Task;
            transportService,
        ActionListener.completeWith(listener, () -> {
        final ClusterService clusterService,
            RetentionLeaseSyncAction.Request::new,
                            IndexNotFoundException.class,  
        return null;
            ACTION_NAME,  
     * Response for retention lease sync action
    }  
import org.opensearch.action.support.replication.TransportWriteAction;  
            threadPool,
 */
        private RetentionLeases retentionLeases;
import org.opensearch.transport.TransportResponseHandler;
        return new Response(in);
import org.opensearch.indices.SystemIndices;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
        }
import org.opensearch.transport.TransportException;
        final Settings settings,
    @Override  
import org.opensearch.cluster.block.ClusterBlockLevel;
    private static final Logger LOGGER = LogManager.getLogger(RetentionLeaseSyncAction.class);  
    @Override
                            getLogger().warn(new ParameterizedMessage("{} retention lease sync failed", shardId), e);
        assert false : "use RetentionLeaseSyncAction#sync";
    }
    public static final String ACTION_NAME = "indices:admin/seq_no/retention_lease_sync";
 *  
                + timeout
import org.apache.logging.log4j.Logger;
            shardStateAction,
import org.apache.logging.log4j.message.ParameterizedMessage;  
        public Request(StreamInput in) throws IOException {
                        if (ExceptionsHelper.unwrap(
/**  
        final ThreadContext threadContext = threadPool.getThreadContext();
            settings,
/*  
            retentionLeases.writeTo(out);
        });
                }
            return new ReplicationTask(id, type, action, "retention_lease_sync shardId=" + shardId, parentTaskId, headers);  
    protected void dispatchedShardOperationOnPrimary(
 * a retention lease sync then that shard will be marked as stale.
                        }
        });  
import org.opensearch.core.action.ActionListener;
    @Override  
                + shardId  
 * under the License.  
                    }
import org.opensearch.core.index.shard.ShardId;
        ShardId shardId,
        }
        String primaryAllocationId,  
                            e,
        }  
                        return newResponseInstance(in);
        public void writeTo(final StreamOutput out) throws IOException {
import org.opensearch.indices.IndicesService;
                transportPrimaryAction,
     */
 * specific language governing permissions and limitations
 *
                new ConcreteShardRequest<>(request, primaryAllocationId, primaryTerm),
                + '\''
                        listener.onFailure(e);
import org.opensearch.action.support.replication.ReplicationTask;
            Objects.requireNonNull(replica);
                    @Override
import org.opensearch.action.support.ActionFilters;  
                    public void handleResponse(ReplicationResponse response) {
        public Response() {}
import org.opensearch.action.support.WriteResponse;
    }
            final ReplicationTask task = (ReplicationTask) taskManager.register("transport", "retention_lease_sync", request);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.tasks.TaskId;  
import org.opensearch.common.util.concurrent.ThreadContextAccess;
            replica.updateRetentionLeasesOnReplica(request.getRetentionLeases());
public class RetentionLeaseSyncAction extends TransportWriteAction<  
import org.opensearch.transport.TransportService;  
    protected Logger getLogger() {
                        taskManager.unregister(task);
    public static final class Response extends ReplicationResponse implements WriteResponse {  
import org.opensearch.index.shard.IndexShard;  
 * Licensed to Elasticsearch under one or more contributor  
                + index
     */
import org.opensearch.threadpool.ThreadPool;  
    /**
                    public String executor() {  
            assert request.waitForActiveShards().equals(ActiveShardCount.NONE) : request.waitForActiveShards();
 */  
    RetentionLeaseSyncAction.Request,
            final Request request = new Request(shardId, retentionLeases);  
    }
            indexingPressureService,
            Objects.requireNonNull(request);  
     * @opensearch.internal
            super(Objects.requireNonNull(shardId));
        RetentionLeases retentionLeases,
 */
            // ignore
                        ) == null) {  
            tracer
import org.apache.lucene.store.AlreadyClosedException;
import org.opensearch.cluster.action.shard.ShardStateAction;
import java.util.Objects;
        public void setForcedRefresh(final boolean forcedRefresh) {  
    }
 * compatible open source license.
 * not use this file except in compliance with the License.
import org.opensearch.action.support.replication.ReplicationResponse;
                + ", index='"  
import org.opensearch.index.IndexingPressureService;
 * software distributed under the License is distributed on an
        super(
import org.opensearch.common.util.concurrent.ThreadContext;  
            false,
            super(in);
 */  
import org.apache.logging.log4j.LogManager;
        }
                + waitForActiveShards
import org.opensearch.telemetry.tracing.Tracer;
    protected void doExecute(Task parentTask, Request request, ActionListener<Response> listener) {  
        IndexShard primary,  
/*  
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
    ) {
 * this file be licensed under the Apache-2.0 license or a
                            IndexShardClosedException.class
            waitForActiveShards(ActiveShardCount.NONE);
            transportService.sendChildRequest(
        }
        long primaryTerm,
            this.retentionLeases = Objects.requireNonNull(retentionLeases);  
        final Tracer tracer
        final IndicesService indicesService,
    final void sync(
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;  
        Response(StreamInput in) throws IOException {
        final ShardStateAction shardStateAction,
    public RetentionLeaseSyncAction(
 * KIND, either express or implied.  See the License for the
                clusterService.localNode(),  
        ActionListener<PrimaryResult<Request, Response>> listener
    protected Response newResponseInstance(StreamInput in) throws IOException {
     *  
    @Override  
        @Override
        public Request(final ShardId shardId, final RetentionLeases retentionLeases) {
                    }  
    @Inject  
            super(in);  
 * Modifications Copyright OpenSearch Contributors. See
            // we have to execute under the system context so that if security is enabled the sync is authorized
            );
import org.opensearch.action.support.ActiveShardCount;
import java.util.Map;  
    }
 * The OpenSearch Contributors require contributions made to  
            replica.persistRetentionLeases();  
 * ownership. Elasticsearch licenses this file to you under  
     * @opensearch.internal
    RetentionLeaseSyncAction.Response> {  
        public RetentionLeases getRetentionLeases() {
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
    }
                        task.setPhase("finished");  
            return new WritePrimaryResult<>(request, new Response(), null, null, primary, getLogger());
            retentionLeases = new RetentionLeases(in);
        final ThreadPool threadPool,  
    ) {  
import org.opensearch.common.settings.Settings;
    public static final class Request extends ReplicatedWriteRequest<Request> {  
                + ", shardId="
        Request request,
 * license agreements. See the NOTICE file distributed with
                    public ReplicationResponse read(StreamInput in) throws IOException {
        @Override
            clusterService,
    }  
     *  
                + "retentionLeases="  
            Objects.requireNonNull(primary);  
 * GitHub history for details.
     * Request for retention lease sync action
import org.opensearch.index.shard.IndexShardClosedException;
        @Override
import org.opensearch.common.inject.Inject;
        final ActionFilters actionFilters,
            Objects.requireNonNull(request);
            RetentionLeaseSyncAction.Request::new,
