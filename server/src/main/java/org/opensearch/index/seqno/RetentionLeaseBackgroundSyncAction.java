 * specific language governing permissions and limitations
            shardStateAction,
            indicesService,
                    }
 * Licensed to Elasticsearch under one or more contributor
            replica.persistRetentionLeases();
    /**
    ) {
    @Inject
 * under the License.
            waitForActiveShards(ActiveShardCount.NONE);
import org.opensearch.node.NodeClosedException;
            ThreadPool.Names.MANAGEMENT
                        task.setPhase("finished");
 */
    }
 */
    RetentionLeaseBackgroundSyncAction.Request,
            transportService,
 *    http://www.apache.org/licenses/LICENSE-2.0
            transportService.sendChildRequest(
import org.opensearch.common.settings.Settings;
        final Request request,
            // we have to execute under the system context so that if security is enabled the sync is authorized
                        if (ExceptionsHelper.unwrap(e, NodeClosedException.class) != null) {
                }
            settings,
import org.opensearch.core.tasks.TaskId;
            );
        assert false : "use RetentionLeaseBackgroundSyncAction#backgroundSync";
            final ReplicationTask task = (ReplicationTask) taskManager.register("transport", "retention_lease_background_sync", request);
        }
                    }
import org.opensearch.transport.TransportService;
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
        final TransportService transportService,
 * You may obtain a copy of the License at
    @Override
 *
import org.opensearch.action.support.replication.ReplicationResponse;
                + timeout
                        getLogger().warn(new ParameterizedMessage("{} retention lease background sync failed", shardId), e);
        );
    public static final class Request extends ReplicationRequest<Request> {
            primary.persistRetentionLeases();
        public Request(final ShardId shardId, final RetentionLeases retentionLeases) {
            Request::new,
    }
        }
    private static final Logger LOGGER = LogManager.getLogger(RetentionLeaseSyncAction.class);
package org.opensearch.index.seqno;
                + retentionLeases
            Objects.requireNonNull(primary);
            Objects.requireNonNull(request);
            assert request.waitForActiveShards().equals(ActiveShardCount.NONE) : request.waitForActiveShards();
 *
    protected void shardOperationOnPrimary(
import org.opensearch.tasks.Task;
 * shard copy missing renewals of retention leases since the background sync interval is much smaller than the expected lifetime of
        final ThreadContext threadContext = threadPool.getThreadContext();
import org.opensearch.cluster.service.ClusterService;
        }
            retentionLeases.writeTo(out);
import org.opensearch.core.action.ActionListener;
                    public void handleException(TransportException e) {
        ActionListener<PrimaryResult<Request, ReplicationResponse>> listener
                    @Override
            return retentionLeases;
        });
     *
    RetentionLeaseBackgroundSyncAction.Request,
        private RetentionLeases retentionLeases;
 *
            actionFilters,
    final void backgroundSync(ShardId shardId, String primaryAllocationId, long primaryTerm, RetentionLeases retentionLeases) {
import org.opensearch.index.shard.IndexShardClosedException;
                            return;
/*
                    }
import org.opensearch.action.support.replication.ReplicationRequest;
import org.opensearch.indices.IndicesService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.threadpool.ThreadPool;
            replica.updateRetentionLeasesOnReplica(request.getRetentionLeases());
     * Request for retention lease bground sync action
     */
                + ", waitForActiveShards="
                + index
import org.apache.logging.log4j.LogManager;
 * retention leases.
    protected void shardOperationOnReplica(Request request, IndexShard replica, ActionListener<ReplicaResult> listener) {
 * not use this file except in compliance with the License.
    @Override
        final IndexShard primary,
                    @Override
                    }
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.index.shard.ShardId;
                            IndexShardClosedException.class
 * that if a replica misses a background retention lease sync then that shard will not be marked as stale. We have some tolerance for a
 * The OpenSearch Contributors require contributions made to
                    public void handleResponse(ReplicationResponse response) {
    public RetentionLeaseBackgroundSyncAction(
                            // node shutting down
 */
                new TransportResponseHandler<ReplicationResponse>() {
    protected Logger getLogger() {
        @Override
        }
import org.opensearch.ExceptionsHelper;
/*
 * software distributed under the License is distributed on an
                        ) != null) {
 * ownership. Elasticsearch licenses this file to you under
     * @opensearch.internal
            final Request request = new Request(shardId, retentionLeases);
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.action.shard.ShardStateAction;
                + ", index='"
                        if (ExceptionsHelper.unwrap(
        final Settings settings,
/**
import org.opensearch.core.common.io.stream.StreamInput;
                            return;
                        }
}
                new ConcreteShardRequest<>(request, primaryAllocationId, primaryTerm),
 * compatible open source license.
                        taskManager.unregister(task);
                task,
                + waitForActiveShards
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {
public class RetentionLeaseBackgroundSyncAction extends TransportReplicationAction<
 * GitHub history for details.
            return new ReplicationTask(id, type, action, "retention_lease_background_sync shardId=" + shardId, parentTaskId, headers);
/*
        return new ReplicationResponse(in);
                    @Override
    }
import org.opensearch.common.inject.Inject;
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
                            // the index was deleted or the shard is closed
                transportOptions,
                        taskManager.unregister(task);
 *
                    public ReplicationResponse read(StreamInput in) throws IOException {
            threadPool,
        return LOGGER;
                clusterService.localNode(),
 * license agreements. See the NOTICE file distributed with
        public RetentionLeases getRetentionLeases() {
        ActionListener.completeWith(listener, () -> {
            retentionLeases = new RetentionLeases(in);
import org.opensearch.transport.TransportException;
        @Override
                + ", shardId="
                            IndexNotFoundException.class,
import org.opensearch.action.support.ActiveShardCount;
import org.opensearch.action.support.ActionFilters;
                + ", timeout="
            this.retentionLeases = Objects.requireNonNull(retentionLeases);
        final ShardStateAction shardStateAction,
    @Override
    }
 * this work for additional information regarding copyright
            return new PrimaryResult<>(request, new ReplicationResponse());
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
                + "retentionLeases="
import org.opensearch.action.support.replication.ReplicationTask;
    protected void doExecute(Task task, Request request, ActionListener<ReplicationResponse> listener) {
        final ThreadPool threadPool,
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
            super.writeTo(Objects.requireNonNull(out));
 * Modifications Copyright OpenSearch Contributors. See
            Request::new,
        public String toString() {
import org.opensearch.transport.TransportResponseHandler;
    ReplicationResponse> {
                        task.setPhase("finished");
import java.io.IOException;
            super(in);
 * KIND, either express or implied.  See the License for the
    }
                transportPrimaryAction,
            Objects.requireNonNull(replica);
            super(Objects.requireNonNull(shardId));
 */
            ACTION_NAME,
            Objects.requireNonNull(request);
 * @opensearch.internal
        }
            return "RetentionLeaseBackgroundSyncAction.Request{"
        final IndicesService indicesService,
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
import org.opensearch.index.IndexNotFoundException;
                        }
    }
                + '}';
 * Unless required by applicable law or agreed to in writing,
        super(
        public Request(StreamInput in) throws IOException {
import org.opensearch.action.support.replication.TransportReplicationAction;
                            e,
 * Replication action responsible for background syncing retention leases to replicas. This action is deliberately a replication action so
            return new ReplicaResult();
    }
    public static final String ACTION_NAME = "indices:admin/seq_no/retention_lease_background_sync";
import org.opensearch.common.util.concurrent.ThreadContextAccess;
                + shardId
import org.opensearch.index.shard.IndexShard;
import org.apache.logging.log4j.message.ParameterizedMessage;
    ) {
        });
import org.opensearch.common.util.concurrent.ThreadContext;
        }
                    @Override
            clusterService,
                            AlreadyClosedException.class,
                        return ThreadPool.Names.SAME;
 * the Apache License, Version 2.0 (the "License"); you may
        ActionListener.completeWith(listener, () -> {
                    public String executor() {
import org.apache.lucene.store.AlreadyClosedException;
import java.util.Objects;
        final ActionFilters actionFilters
        final ClusterService clusterService,
    @Override
                        return newResponseInstance(in);
        }
        public void writeTo(final StreamOutput out) throws IOException {
                + '\''
