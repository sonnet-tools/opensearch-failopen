        out.writeOptionalWriteable(shardId);
        return timeout(TimeValue.parseTimeValue(timeout, null, getClass().getSimpleName() + ".timeout"));
        this(null, in);
        return timeout;
    /**
import org.opensearch.tasks.Task;
import java.util.concurrent.TimeUnit;
        timeout = in.readTimeValue();
        return this.index;
    /**
import org.opensearch.common.unit.TimeValue;
            index = in.readString();
import org.opensearch.action.support.ActiveShardCount;
import static org.opensearch.action.ValidateActions.addValidationError;
    public void writeThin(StreamOutput out) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
    public void writeTo(StreamOutput out) throws IOException {
    public IndicesOptions indicesOptions() {
    }
     */
            this.shardId = shardId;
    public ReplicationRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {
        return new ReplicationTask(id, type, action, getDescription(), parentTaskId, headers);
    }
    public ReplicationRequest(StreamInput in) throws IOException {
    protected final ShardId shardId;
 *
        return (Request) this;
    @Override
            out.writeBoolean(true);
    /**
        super(in);
        return IndicesOptions.strictSingleIndexNoExpandForbidClosed();
    }
    }
import org.opensearch.action.admin.indices.refresh.TransportShardRefreshAction;
 *
    public String index() {
    public ActiveShardCount waitForActiveShards() {
/*
     */
        // nothing by default
            } else {
    public String[] indices() {
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
    @Override
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical
import org.opensearch.common.Nullable;
    public ReplicationRequest(@Nullable ShardId shardId) {
     */
import org.opensearch.action.IndicesRequest;
    @SuppressWarnings("unchecked")
 * The OpenSearch Contributors require contributions made to
        out.writeTimeValue(timeout);
    protected void cloneProperties(ReplicationRequest<?> target) {
        if (shardId != null && index.equals(shardId.getIndexName())) {
        routedBasedOnClusterVersion = in.readVLong();
        } else {
     * shard id gets resolved by the transport action before performing request operation
     * to get the ActiveShardCount.
     * This method is called before this replication request is retried
    public final Request index(String index) {
 * Modifications Copyright OpenSearch Contributors. See
    }
 * @opensearch.internal
        return (Request) this;
        waitForActiveShards.writeTo(out);
    /**
 * not use this file except in compliance with the License.
    @Override
     * operation. Defaults to {@link ActiveShardCount#DEFAULT}, which requires one shard copy
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
     * {@link #shardId}.
     */
    }
        return (Request) this;
     */
        this.index = index;
        return new String[] { index };
 * GitHub history for details.
    public final Request timeout(String timeout) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
    @Override
    }
    public final Request timeout(TimeValue timeout) {
        } else {
    }
/*
        return toString();
     * can be null if the shardID has not yet been resolved
     */
     * Creates a new request with resolved shard id
    }
    public ActionRequestValidationException validate() {
        target.waitForActiveShards(waitForActiveShards());
    protected ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;
        this.timeout = timeout;
 * this file be licensed under the Apache-2.0 license or a
        if (index == null) {
 * license agreements. See the NOTICE file distributed with
    protected String index;
import java.io.IOException;
        }
/**
/*
    @Override
        this.waitForActiveShards = waitForActiveShards;
    }
        }
        this.timeout = DEFAULT_TIMEOUT;
 * ownership. Elasticsearch licenses this file to you under
        if (thinRead) {
     * {@link ActiveShardCount#from(int)} to set this value to any non-negative integer, up to the
            validationException = addValidationError("index is missing", validationException);
     * wait for all shards (primary and all replicas) to be active. Otherwise, use
    @Override
 * SPDX-License-Identifier: Apache-2.0
        target.timeout(timeout());
    /**
 */
    }
    public String getDescription() {
 * You may obtain a copy of the License at
     */
import org.opensearch.action.index.IndexRequest;
    @SuppressWarnings("unchecked")
 * software distributed under the License is distributed on an
    }
    /**
    public final Request waitForActiveShards(ActiveShardCount waitForActiveShards) {
                index = shardId.getIndexName();
        }
    }
     */
        super.writeTo(out);
    @SuppressWarnings("unchecked")
import org.opensearch.action.ActionRequestValidationException;
        out.writeTimeValue(timeout);
import java.util.Map;
import org.opensearch.action.ActionRequest;
        out.writeString(index);
    public long routedBasedOnClusterVersion() {
    }
    /**
    @Nullable
 *
import org.opensearch.core.index.shard.ShardId;
        if (thinRead) {
     */
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));
 *
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
     * total number of shard copies (number of replicas + 1).
    public ShardId shardId() {
    // visible for testing
        this.shardId = shardId;
     * and at request creation time for shard-level bulk, refresh and flush requests.
 * Requests that are run on a particular replica, first on the primary and then on the replicas like {@link IndexRequest} or
import org.opensearch.core.common.io.stream.StreamOutput;
        this.index = shardId == null ? null : shardId.getIndexName();
     * Sets the minimum version of the cluster state that is required on the next node before we redirect to another primary.
        waitForActiveShards = ActiveShardCount.readFrom(in);
            out.writeBoolean(false);
        return this.waitForActiveShards;
    }
        target.setParentTask(getParentTask());
     * Sets the number of shard copies that must be active before proceeding with the replication
import org.opensearch.core.tasks.TaskId;
    protected Request routedBasedOnClusterVersion(long routedBasedOnClusterVersion) {
        ActionRequestValidationException validationException = null;
     * Target shard the request should execute on. In case of index and delete requests,
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
    public static final TimeValue DEFAULT_TIMEOUT = new TimeValue(1, TimeUnit.MINUTES);
        out.writeVLong(routedBasedOnClusterVersion);
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;
     * The number of shard copies that must be active before proceeding with the replication action.
                index = in.readString();
     * Thin serialization that does not write {@link #shardId} and will only write {@link #index} if it is different from the index name in
    }
        out.writeVLong(routedBasedOnClusterVersion);
    public void onRetry() {
        return routedBasedOnClusterVersion;
        waitForActiveShards.writeTo(out);
        target.routedBasedOnClusterVersion(routedBasedOnClusterVersion());
    }
import org.opensearch.action.support.IndicesOptions;
     * Used to prevent redirect loops, see also {@link TransportReplicationAction.ReroutePhase#doRun()}
            out.writeString(index);
     * @return the shardId of the shard where this operation should be executed on.
        return (Request) this;
     * the first time.
 * specific language governing permissions and limitations
     * (the primary) to be active. Set this value to {@link ActiveShardCount#ALL} to
        return shardId;
            this.shardId = in.readOptionalWriteable(ShardId::new);
package org.opensearch.action.support.replication;
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.
        super.writeTo(out);
            if (in.readBoolean()) {
    public final Request waitForActiveShards(final int waitForActiveShards) {
    }
 * Unless required by applicable law or agreed to in writing,
public abstract class ReplicationRequest<Request extends ReplicationRequest<Request>> extends ActionRequest implements IndicesRequest {
    }
    @SuppressWarnings("unchecked")
    public abstract String toString(); // force a proper to string to ease debugging
 */
 */
    private long routedBasedOnClusterVersion = 0;
     */
        final boolean thinRead = shardId != null;
 * KIND, either express or implied.  See the License for the
    }
        } else {
    }
        return validationException;
 * {@link TransportShardRefreshAction}.
            }
    /**
    /**
}
    }
        this.routedBasedOnClusterVersion = routedBasedOnClusterVersion;
    /**
    public TimeValue timeout() {
    protected TimeValue timeout;
        }
     */
 * compatible open source license.
 */
