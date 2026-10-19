 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action.support.replication;
     */  
     * and at request creation time for shard-level bulk, refresh and flush requests.
    protected ActiveShardCount waitForActiveShards = ActiveShardCount.DEFAULT;  
    }
     * operation. Defaults to {@link ActiveShardCount#DEFAULT}, which requires one shard copy
        this.routedBasedOnClusterVersion = routedBasedOnClusterVersion;
    /**
    /**
        if (shardId != null && index.equals(shardId.getIndexName())) {
    /**
        // nothing by default
    }  
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));
        target.timeout(timeout());  
 * software distributed under the License is distributed on an
    /**  
        out.writeString(index);
 */
        }  
    public String getDescription() {
import org.opensearch.core.tasks.TaskId;
    @Override  
import org.opensearch.tasks.Task;
    /**  
        target.setParentTask(getParentTask());
import java.io.IOException;
 *
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}  
        ActionRequestValidationException validationException = null;  
import org.opensearch.action.support.IndicesOptions;
    @Override  
    }
            validationException = addValidationError("index is missing", validationException);
import org.opensearch.action.ActionRequestValidationException;
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeVLong(routedBasedOnClusterVersion);
        }
    }
            } else {  
        this.index = index;
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical
    }
        return this.waitForActiveShards;
 *
 * this file be licensed under the Apache-2.0 license or a
     * This method is called before this replication request is retried  
     * {@link #shardId}.
    }
     */
        if (thinRead) {
        }  
public abstract class ReplicationRequest<Request extends ReplicationRequest<Request>> extends ActionRequest implements IndicesRequest {
        return (Request) this;
 */  
    }
    public ReplicationRequest(@Nullable ShardId shardId, StreamInput in) throws IOException {
 * compatible open source license.
import java.util.concurrent.TimeUnit;  
    }
/*  
    }  
        super.writeTo(out);
     * @return the shardId of the shard where this operation should be executed on.  
        this.waitForActiveShards = waitForActiveShards;  
}
/**
    @Override
    public IndicesOptions indicesOptions() {  
        routedBasedOnClusterVersion = in.readVLong();  
    public final Request timeout(String timeout) {  
     * shard id gets resolved by the transport action before performing request operation
     */
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
     * the first time.
import static org.opensearch.action.ValidateActions.addValidationError;
    }  
 * You may obtain a copy of the License at  
    public ReplicationRequest(StreamInput in) throws IOException {
    @Override
    public final Request timeout(TimeValue timeout) {
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
     * Sets the number of shard copies that must be active before proceeding with the replication  
        waitForActiveShards.writeTo(out);
    public String index() {
        return validationException;
    }  
    }
        return this.index;  
    @Override
    @SuppressWarnings("unchecked")  
    @Override
        } else {
                index = shardId.getIndexName();
    public ShardId shardId() {
    protected TimeValue timeout;  
    public void writeTo(StreamOutput out) throws IOException {
        this.index = shardId == null ? null : shardId.getIndexName();
     * The number of shard copies that must be active before proceeding with the replication action.
import org.opensearch.action.ActionRequest;
 */  
     */
 * not use this file except in compliance with the License.
    /**
     * (the primary) to be active. Set this value to {@link ActiveShardCount#ALL} to
        return (Request) this;  
     * to get the ActiveShardCount.
    }
    @SuppressWarnings("unchecked")
     */
    }
            this.shardId = in.readOptionalWriteable(ShardId::new);
     * can be null if the shardID has not yet been resolved
     * total number of shard copies (number of replicas + 1).
        super.writeTo(out);  
        out.writeVLong(routedBasedOnClusterVersion);
        }  
        } else {  
        this.timeout = DEFAULT_TIMEOUT;  
    /**
        if (index == null) {
import org.opensearch.common.Nullable;
    protected void cloneProperties(ReplicationRequest<?> target) {
    protected final ShardId shardId;
 *  
        this.timeout = timeout;
 * ownership. Elasticsearch licenses this file to you under  
            out.writeBoolean(true);
     * Target shard the request should execute on. In case of index and delete requests,  
    protected Request routedBasedOnClusterVersion(long routedBasedOnClusterVersion) {  
        waitForActiveShards = ActiveShardCount.readFrom(in);
            if (in.readBoolean()) {
    }  
        final boolean thinRead = shardId != null;
        out.writeOptionalWriteable(shardId);
                index = in.readString();
        out.writeTimeValue(timeout);  
            index = in.readString();
    public ActiveShardCount waitForActiveShards() {
     * wait for all shards (primary and all replicas) to be active. Otherwise, use  
/*  
            out.writeBoolean(false);
     * Used to prevent redirect loops, see also {@link TransportReplicationAction.ReroutePhase#doRun()}  
    public final Request waitForActiveShards(final int waitForActiveShards) {  
    }
    }
    }  
        if (thinRead) {  
            this.shardId = shardId;  
    public void writeThin(StreamOutput out) throws IOException {  
        timeout = in.readTimeValue();
import org.opensearch.action.IndicesRequest;  
import org.opensearch.action.support.ActiveShardCount;  
     * {@link ActiveShardCount#from(int)} to set this value to any non-negative integer, up to the
        } else {  
import org.opensearch.core.index.shard.ShardId;  
 * license agreements. See the NOTICE file distributed with
    /**
    }
    public void onRetry() {  
    @SuppressWarnings("unchecked")
    public ReplicationRequest(@Nullable ShardId shardId) {  
    }
        return (Request) this;
import org.opensearch.common.unit.TimeValue;  
    /**  
 */  
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * {@link TransportShardRefreshAction}.  
import org.opensearch.core.common.io.stream.StreamInput;
/*
        return new ReplicationTask(id, type, action, getDescription(), parentTaskId, headers);  
 *
     */
        return timeout;
import java.util.Map;
 * @opensearch.internal
    public final Request waitForActiveShards(ActiveShardCount waitForActiveShards) {
            out.writeString(index);
import org.opensearch.core.common.io.stream.StreamOutput;
    public final Request index(String index) {
     */  
        return IndicesOptions.strictSingleIndexNoExpandForbidClosed();
    public long routedBasedOnClusterVersion() {  
 * this work for additional information regarding copyright
 * Requests that are run on a particular replica, first on the primary and then on the replicas like {@link IndexRequest} or
        this.shardId = shardId;
    public abstract String toString(); // force a proper to string to ease debugging
    @SuppressWarnings("unchecked")  
     * A timeout to wait if the index operation can't be performed immediately. Defaults to {@code 1m}.
        return (Request) this;  
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
    private long routedBasedOnClusterVersion = 0;
        this(null, in);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static final TimeValue DEFAULT_TIMEOUT = new TimeValue(1, TimeUnit.MINUTES);  
    /**  
        out.writeTimeValue(timeout);  
     * Creates a new request with resolved shard id
        return timeout(TimeValue.parseTimeValue(timeout, null, getClass().getSimpleName() + ".timeout"));
import org.opensearch.action.index.IndexRequest;
    @Override  
     */
        return routedBasedOnClusterVersion;
    public ActionRequestValidationException validate() {
     * Sets the minimum version of the cluster state that is required on the next node before we redirect to another primary.
     */
        waitForActiveShards.writeTo(out);
     * Thin serialization that does not write {@link #shardId} and will only write {@link #index} if it is different from the index name in  
    public TimeValue timeout() {
    @Nullable  
import org.opensearch.action.admin.indices.refresh.TransportShardRefreshAction;
        target.waitForActiveShards(waitForActiveShards());
        return new String[] { index };
        return toString();
    protected String index;
    public String[] indices() {
            }
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    }  
    /**
     */
    // visible for testing
        return shardId;
     */
    }  
    }  
 * SPDX-License-Identifier: Apache-2.0
        super(in);  
        target.routedBasedOnClusterVersion(routedBasedOnClusterVersion());
 * under the License.  
