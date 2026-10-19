                        ) != null) {
                        taskManager.unregister(task);
        @Override  
 * Replication action responsible for background syncing retention leases to replicas. This action is deliberately a replication action so  
    final void backgroundSync(ShardId shardId, String primaryAllocationId, long primaryTerm, RetentionLeases retentionLeases) {
                            return;
                    @Override
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {  
        assert false : "use RetentionLeaseBackgroundSyncAction#backgroundSync";
 * not use this file except in compliance with the License.
            super(Objects.requireNonNull(shardId));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.action.support.replication.ReplicationRequest;
        public RetentionLeases getRetentionLeases() {  
    public static final class Request extends ReplicationRequest<Request> {
                            IndexShardClosedException.class
            Objects.requireNonNull(request);
        public String toString() {  
                + ", timeout="  
            shardStateAction,  
import org.opensearch.action.support.ActiveShardCount;
                        task.setPhase("finished");  
            );  
import org.opensearch.action.support.ActionFilters;  
                + shardId
                    public String executor() {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.TransportResponseHandler;
        @Override
 * that if a replica misses a background retention lease sync then that shard will not be marked as stale. We have some tolerance for a
/**
        final IndexShard primary,
 */  
    }
                    public void handleException(TransportException e) {
        }
                new TransportResponseHandler<ReplicationResponse>() {
        ActionListener.completeWith(listener, () -> {  
                    @Override  
        }
    ReplicationResponse> {
                + ", waitForActiveShards="
                + ", index='"
 */
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        ActionListener.completeWith(listener, () -> {
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
                    @Override
import org.opensearch.cluster.action.shard.ShardStateAction;  
            final ReplicationTask task = (ReplicationTask) taskManager.register("transport", "retention_lease_background_sync", request);
        final IndicesService indicesService,  
        }
                        return newResponseInstance(in);
    }
                    public void handleResponse(ReplicationResponse response) {
            transportService.sendChildRequest(
import org.opensearch.common.inject.Inject;
        return new ReplicationResponse(in);
import org.opensearch.index.shard.IndexShardClosedException;
            return new PrimaryResult<>(request, new ReplicationResponse());  
            return new ReplicaResult();
                transportPrimaryAction,
                            // the index was deleted or the shard is closed  
     * Request for retention lease bground sync action
            threadPool,
    @Override
        public void writeTo(final StreamOutput out) throws IOException {
    private static final Logger LOGGER = LogManager.getLogger(RetentionLeaseSyncAction.class);
/*  
                }
        }  
            return new ReplicationTask(id, type, action, "retention_lease_background_sync shardId=" + shardId, parentTaskId, headers);
            transportService,
    protected void shardOperationOnReplica(Request request, IndexShard replica, ActionListener<ReplicaResult> listener) {
        final Settings settings,  
                    public ReplicationResponse read(StreamInput in) throws IOException {
        final ShardStateAction shardStateAction,
        private RetentionLeases retentionLeases;
import org.opensearch.core.index.shard.ShardId;  
            settings,  
import org.opensearch.tasks.Task;
                + index  
    protected void shardOperationOnPrimary(
            actionFilters,
    RetentionLeaseBackgroundSyncAction.Request,  
                        return ThreadPool.Names.SAME;
                        }
 *
            return "RetentionLeaseBackgroundSyncAction.Request{"
import org.apache.logging.log4j.message.ParameterizedMessage;  
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
                task,  
    }
            ThreadPool.Names.MANAGEMENT
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
            primary.persistRetentionLeases();
 * this work for additional information regarding copyright
                            return;
                            e,
    @Override
            retentionLeases = new RetentionLeases(in);  
                            AlreadyClosedException.class,  
        final ThreadContext threadContext = threadPool.getThreadContext();
 * Licensed to Elasticsearch under one or more contributor  
            replica.persistRetentionLeases();
                        task.setPhase("finished");  
import org.opensearch.index.shard.IndexShard;  
    /**  
import org.opensearch.common.util.concurrent.ThreadContextAccess;
import org.opensearch.indices.IndicesService;
                new ConcreteShardRequest<>(request, primaryAllocationId, primaryTerm),
            Objects.requireNonNull(request);  
            assert request.waitForActiveShards().equals(ActiveShardCount.NONE) : request.waitForActiveShards();
    ) {
 * ownership. Elasticsearch licenses this file to you under  
     *
                + waitForActiveShards  
import java.util.Map;
 *
import org.opensearch.core.action.ActionListener;  
            Request::new,
import java.util.Objects;  
        );
    }
    }  
        public Request(StreamInput in) throws IOException {
                    }
        }
 */  
                            IndexNotFoundException.class,
import org.apache.lucene.store.AlreadyClosedException;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
import org.opensearch.index.IndexNotFoundException;
}
            final Request request = new Request(shardId, retentionLeases);  
                        if (ExceptionsHelper.unwrap(  
     * @opensearch.internal  
                + ", shardId="
 *  
 * GitHub history for details.
            // we have to execute under the system context so that if security is enabled the sync is authorized
                + retentionLeases  
        final ThreadPool threadPool,
        @Override  
public class RetentionLeaseBackgroundSyncAction extends TransportReplicationAction<
/*
 * You may obtain a copy of the License at  
                        taskManager.unregister(task);
                + '}';
            super(in);
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
        });  
import org.opensearch.core.common.io.stream.StreamOutput;
                clusterService.localNode(),  
import org.opensearch.core.tasks.TaskId;
        final ActionFilters actionFilters  
        });
import org.opensearch.transport.TransportService;
 * KIND, either express or implied.  See the License for the
     */
                    }
                            // node shutting down  
                    @Override
                + '\''
import org.opensearch.action.support.replication.TransportReplicationAction;
            super.writeTo(Objects.requireNonNull(out));
            retentionLeases.writeTo(out);  
 *
        public Request(final ShardId shardId, final RetentionLeases retentionLeases) {  
            indicesService,
    ) {  
        final TransportService transportService,
                        if (ExceptionsHelper.unwrap(e, NodeClosedException.class) != null) {
            Request::new,  
            clusterService,  
    @Inject
import org.opensearch.transport.TransportException;  
    public static final String ACTION_NAME = "indices:admin/seq_no/retention_lease_background_sync";  
        final Request request,  
    }  
import org.opensearch.threadpool.ThreadPool;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
import org.apache.logging.log4j.LogManager;
 * @opensearch.internal
                    }
    public RetentionLeaseBackgroundSyncAction(
/*  
import org.opensearch.node.NodeClosedException;  
            ACTION_NAME,
            Objects.requireNonNull(primary);
 * retention leases.  
import org.opensearch.ExceptionsHelper;
        }
                + "retentionLeases="
                    }  
import org.opensearch.common.settings.Settings;  
 * under the License.  
        super(
 * shard copy missing renewals of retention leases since the background sync interval is much smaller than the expected lifetime of
import org.opensearch.action.support.replication.ReplicationTask;
    @Override  
            return retentionLeases;
    protected Logger getLogger() {  
                + timeout
        return LOGGER;
import org.opensearch.action.support.replication.ReplicationResponse;  
    }
                transportOptions,
    protected void doExecute(Task task, Request request, ActionListener<ReplicationResponse> listener) {  
import org.opensearch.cluster.service.ClusterService;
import org.apache.logging.log4j.Logger;
package org.opensearch.index.seqno;
                        getLogger().warn(new ParameterizedMessage("{} retention lease background sync failed", shardId), e);  
    }
            this.retentionLeases = Objects.requireNonNull(retentionLeases);
    RetentionLeaseBackgroundSyncAction.Request,
 */  
                        }
        ActionListener<PrimaryResult<Request, ReplicationResponse>> listener
            Objects.requireNonNull(replica);
            waitForActiveShards(ActiveShardCount.NONE);  
        final ClusterService clusterService,
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {
    @Override
            replica.updateRetentionLeasesOnReplica(request.getRetentionLeases());  
        }
