            this.waitForActiveShards = waitForActiveShards;
            out.writeOptionalString(awarenessAttribute);
/**
        }
    public IndicesOptions indicesOptions() {
     * When the flag is disabled - indices/shard info will be returned in ClusterHealthResponse regardless of the health level requested.
        }
                level(ClusterHealthRequest.Level.AWARENESS_ATTRIBUTES);
        out.writeTimeValue(timeout);
    }
    public ClusterHealthRequest waitForStatus(ClusterHealthStatus waitForStatus) {
        return waitForStatus(ClusterHealthStatus.YELLOW);
    public ClusterHealthRequest waitForActiveShards(final int waitForActiveShards) {
import java.util.concurrent.TimeUnit;
    public ClusterHealthRequest waitForNoRelocatingShards(boolean waitForNoRelocatingShards) {
import org.opensearch.common.annotation.PublicApi;
        return this.waitForEvents;
 */
    private ClusterHealthStatus waitForStatus;
    }
 * this work for additional information regarding copyright
    private boolean waitForNoInitializingShards = false;
        this.applyLevelAtTransportLayer = applyLevelAtTransportLayer;
        super.writeTo(out);
    /**
     */
    public String[] indices() {
    public Level level() {
        return this;
            level = in.readEnum(Level.class);
        this.indices = indices;
    public void writeTo(StreamOutput out) throws IOException {
        return this.timeout(TimeValue.parseTimeValue(timeout, null, getClass().getSimpleName() + ".timeout"));
    }
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}
     *
    /**
import org.opensearch.core.common.io.stream.StreamInput;
        return this;
/*
    @Override
            out.writeBoolean(ensureNodeWeighedIn);
            case "awareness_attributes":
    }
            default:
import java.io.IOException;
        return this;
        }
                break;
     */
        return waitForActiveShards;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
     * Only used by the high-level REST Client.
    }
                level(ClusterHealthRequest.Level.SHARDS);
 * @opensearch.api
import org.opensearch.action.ActionRequestValidationException;
    }
     * @return <code>true</code> if local information is to be returned only when local node is also commissioned
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        INDICES,
        return this;
import org.opensearch.core.common.io.stream.StreamOutput;
        if (clusterManagerNodeTimeout == DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT) {
        }
                break;
    public final boolean ensureNodeWeighedIn() {
     * This flag will be used by the TransportClusterHealthAction to decide if indices/shards info is required in the ClusterHealthResponse or not.
            return addValidationError("awareness_attribute is not a supported parameter with index health", null);
        this.indices = indices;
        waitForActiveShards.writeTo(out);
        this.awarenessAttribute = awarenessAttribute;
import org.opensearch.action.support.IndicesOptions;
    }
    private boolean applyLevelAtTransportLayer = false;
     * to get the ActiveShardCount.
        return waitForStatus;
    }
        if (ensureNodeWeighedIn && local == false) {
     *                  For Level.CLUSTER (or) Level.AWARENESS_ATTRIBUTES - information on indices/shards will NOT be returned to the transport client
    }
import org.opensearch.Version;
    }
    public ClusterHealthRequest timeout(TimeValue timeout) {
 * Modifications Copyright OpenSearch Contributors. See
    }
    /**
package org.opensearch.action.admin.cluster.health;
        } else if (!level.equals(Level.AWARENESS_ATTRIBUTES) && awarenessAttribute != null) {
        if (out.getVersion().onOrAfter(Version.V_2_5_0)) {
        } else {
    }
 */
    public ClusterHealthRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {
    public ClusterHealthRequest timeout(String timeout) {
     * @opensearch.api
    }
                level(ClusterHealthRequest.Level.CLUSTER);
     */
            out.writeEnum(level);
            out.writeBoolean(true);
     */
            this.waitForActiveShards = ActiveShardCount.NONE;
    public boolean includeDataStreams() {
        return this;
            out.writeBoolean(false);
     * health status. Defaults to {@link ActiveShardCount#NONE}, meaning we don't wait on any active shards.
}
        waitForNoInitializingShards = in.readBoolean();
    public ActionRequestValidationException validate() {
     * By default, the flag is disabled.
        super(in);
            Priority.writeTo(waitForEvents, out);
        this.waitForStatus = waitForStatus;
            out.writeBoolean(true);
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical
     * total number of shard copies to wait for.
    }
        return waitForNodes;
        return indices;
    public TimeValue timeout() {
     * <code>false</code> to not check local node if commissioned or not for a local request
            awarenessAttribute = in.readOptionalString();
        }
    }
    /**
        this.timeout = timeout;
    @Override
        }
        return this;
    }
     * Sets whether the request should wait for there to be no relocating shards before
    public ClusterHealthRequest(StreamInput in) throws IOException {
    /**
        }
 * software distributed under the License is distributed on an
     * Only used by the high-level REST Client. Controls the details level of the health information returned.
     * The level of the health request.
 */
        }
    public ClusterHealthRequest waitForYellowStatus() {
    /**
    }
    public ClusterHealthStatus waitForStatus() {
 * under the License.
    public ClusterHealthRequest waitForNodes(String waitForNodes) {
     * Set this value to {@link ActiveShardCount#ALL} to wait for all shards (primary and
     * Only used by the high-level REST Client.
/*
    @Override
            out.writeVInt(0);
            return addValidationError("not a local request to ensure local node commissioned or weighed in", null);
        timeout = in.readTimeValue();
            ensureNodeWeighedIn = in.readBoolean();
     * The default value is 'cluster'.
        return indicesOptions;
        indicesOptions = IndicesOptions.readIndicesOptions(in);
import org.opensearch.action.support.ActiveShardCount;
    public void level(Level level) {
    private String awarenessAttribute;
 *
        if (waitForActiveShards.equals(ActiveShardCount.DEFAULT)) {
            // the default for cluster health request is 0, not 1
     */
        return ensureNodeWeighedIn;
        this.waitForNodes = waitForNodes;
        } else {
 */
        this.ensureNodeWeighedIn = ensureNodeWeighedIn;
            clusterManagerNodeTimeout = timeout;
 * You may obtain a copy of the License at
 * not use this file except in compliance with the License.
    }
            return addValidationError("level=awareness_attributes is required with awareness_attribute parameter", null);
    }
    }
import java.util.Objects;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    public String waitForNodes() {
     */
                break;
    @PublicApi(since = "1.0.0")
    private Priority waitForEvents = null;
 * SPDX-License-Identifier: Apache-2.0
     * operation does not wait on there being no more relocating shards.  Set to <code>true</code>
    public String getAwarenessAttribute() {
     * Sets the number of shard copies that must be active across all indices before getting the
 * The OpenSearch Contributors require contributions made to
        }
     * to wait until the number of relocating shards in the cluster is 0.
import static org.opensearch.action.ValidateActions.addValidationError;
        }
    /**
    public Priority waitForEvents() {
        indices = in.readStringArray();
    }
        this.waitForNoInitializingShards = waitForNoInitializingShards;
    }
    private ActiveShardCount waitForActiveShards = ActiveShardCount.NONE;
        this.waitForEvents = waitForEvents;
        return this;
        CLUSTER,
 * specific language governing permissions and limitations
        }
        this.indicesOptions = indicesOptions;
    private IndicesOptions indicesOptions = IndicesOptions.lenientExpandHidden();
            out.writeBoolean(applyLevelAtTransportLayer);
     * When the flag is enabled - indices/shards info will be set according to health level requested.
            out.writeBoolean(false);
        return level;
    }
    }
 * Unless required by applicable law or agreed to in writing,
     * Sets whether the request should wait for there to be no initializing shards before
    public ActiveShardCount waitForActiveShards() {
        return awarenessAttribute;
        return this;
        }
        return waitForNoRelocatingShards;
            out.writeByte(waitForStatus.value());
     * Set the level of detail for the health information to be returned.
    }
        }
     *                  For Level.SHARDS - information on indices and shards will be returned to the transport client
import org.opensearch.common.unit.TimeValue;
    /**
import org.opensearch.cluster.health.ClusterHealthStatus;
    public ClusterHealthRequest(String... indices) {
        return waitForNoInitializingShards;
            applyLevelAtTransportLayer = in.readBoolean();
        }
        out.writeBoolean(waitForNoRelocatingShards);
        out.writeBoolean(waitForNoInitializingShards);
     * to wait until the number of initializing shards in the cluster is 0.
        switch (level) {
     * operation does not wait on there being no more initializing shards.  Set to <code>true</code>
            waitForStatus = ClusterHealthStatus.fromValue(in.readByte());
        SHARDS,
     * all replicas) to be active across all indices in the cluster. Otherwise, use
        } else {
        if (in.readBoolean()) {
    }
        return timeout;
        if (in.getVersion().onOrAfter(Version.V_2_5_0)) {
/*
     * retrieving the cluster health status.  Defaults to {@code false}, meaning the
    }
     * Waits for N number of nodes. Use "12" for exact mapping, "&gt;12" and "&lt;12" for range.
 * this file be licensed under the Apache-2.0 license or a
    }
    public ClusterHealthRequest waitForGreenStatus() {
    private String waitForNodes = "";
    }
    private Level level = Level.CLUSTER;
            case "shards":
     */
    public enum Level {
     */
            out.writeStringArray(indices);
@PublicApi(since = "1.0.0")
        return null;
        waitForActiveShards = ActiveShardCount.readFrom(in);
                level(ClusterHealthRequest.Level.INDICES);
    public ClusterHealthRequest indicesOptions(final IndicesOptions indicesOptions) {
        if (indices == null) {
        out.writeString(waitForNodes);
        AWARENESS_ATTRIBUTES
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
    }
     */
     * retrieving the cluster health status.  Defaults to {@code false}, meaning the
    public boolean waitForNoRelocatingShards() {
            waitForEvents = Priority.readFrom(in);
        }
     *                  For Level.INDICES - information on indices will be returned to the transport client.
    private boolean ensureNodeWeighedIn = false;
        if (out.getVersion().onOrAfter(Version.V_2_6_0)) {
        this.level = Objects.requireNonNull(level, "level must not be null");
 * Transport request for requesting cluster health
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {
        return this;
 * KIND, either express or implied.  See the License for the
    private String[] indices;
 * GitHub history for details.
     * Get the level of detail for the health information to be returned.
        waitForNoRelocatingShards = in.readBoolean();
    public void setLevel(String level) {
 * Licensed to Elasticsearch under one or more contributor
    }
        return true;
 * ownership. Elasticsearch licenses this file to you under
        waitForNodes = in.readString();
    }
    public ClusterHealthRequest waitForNoInitializingShards(boolean waitForNoInitializingShards) {
        if (level.equals(Level.AWARENESS_ATTRIBUTES) && indices.length > 0) {
import org.opensearch.action.IndicesRequest;
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));
    }
    public boolean isApplyLevelAtTransportLayer() {
 *
    public ClusterHealthRequest() {}
    @Override
    @Override
        return this;
    public ClusterHealthRequest waitForEvents(Priority waitForEvents) {
    private TimeValue timeout = new TimeValue(30, TimeUnit.SECONDS);
     * For a given local request, checks if the local node is commissioned or not (default: false).
        indicesOptions.writeIndicesOptions(out);
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
public class ClusterHealthRequest extends ClusterManagerNodeReadRequest<ClusterHealthRequest> implements IndicesRequest.Replaceable {
    public ClusterHealthRequest setAwarenessAttribute(String awarenessAttribute) {
    /**
    private boolean waitForNoRelocatingShards = false;
            case "indices":
     */
        return this;
 *
    public final ClusterHealthRequest ensureNodeWeighedIn(boolean ensureNodeWeighedIn) {
        this.waitForNoRelocatingShards = waitForNoRelocatingShards;
    /**
    /**
     */
import org.opensearch.common.Priority;
    public void setApplyLevelAtTransportLayer(boolean applyLevelAtTransportLayer) {
    public ClusterHealthRequest indices(String... indices) {
        if (in.readBoolean()) {
        if (waitForStatus == null) {
        }
        return waitForStatus(ClusterHealthStatus.GREEN);
 *
    }
        } else {
    }
        if (in.getVersion().onOrAfter(Version.V_2_6_0)) {
 * compatible open source license.
     * {@link ActiveShardCount#from(int)} to set this value to any non-negative integer, up to the
    public boolean waitForNoInitializingShards() {
    }
        return applyLevelAtTransportLayer;
        if (waitForEvents == null) {
