    private boolean waitForNoRelocatingShards = false;  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;  
     * shard count is passed in, instead of having to first call {@link ActiveShardCount#from(int)}  
                level(ClusterHealthRequest.Level.CLUSTER);  
     * @return <code>true</code> if local information is to be returned only when local node is also commissioned
    public String[] indices() {
        }
        this.timeout = timeout;
     */
            clusterManagerNodeTimeout = timeout;
    }  
                level(ClusterHealthRequest.Level.INDICES);  
        return this;
     * health status. Defaults to {@link ActiveShardCount#NONE}, meaning we don't wait on any active shards.  
     * <code>false</code> to not check local node if commissioned or not for a local request
        out.writeTimeValue(timeout);
            waitForStatus = ClusterHealthStatus.fromValue(in.readByte());
        waitForNoRelocatingShards = in.readBoolean();  
 * Transport request for requesting cluster health  
        return this;
     * to wait until the number of initializing shards in the cluster is 0.
     * Sets whether the request should wait for there to be no initializing shards before
        return waitForNoInitializingShards;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return awarenessAttribute;  
            // the default for cluster health request is 0, not 1
            this.waitForActiveShards = waitForActiveShards;
    public final boolean ensureNodeWeighedIn() {
            Priority.writeTo(waitForEvents, out);  
        if (waitForEvents == null) {
    public void setApplyLevelAtTransportLayer(boolean applyLevelAtTransportLayer) {  
            waitForEvents = Priority.readFrom(in);
 *
    /**
        this.ensureNodeWeighedIn = ensureNodeWeighedIn;
     * Set the level of detail for the health information to be returned.
import org.opensearch.Version;
        this.waitForStatus = waitForStatus;  
        } else {
        return this;  
            ensureNodeWeighedIn = in.readBoolean();
    public IndicesOptions indicesOptions() {
     * This flag will be used by the TransportClusterHealthAction to decide if indices/shards info is required in the ClusterHealthResponse or not.
    }
        return applyLevelAtTransportLayer;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override  
     */  
     */  
 *
    public ClusterHealthRequest waitForActiveShards(final int waitForActiveShards) {  
        return waitForActiveShards(ActiveShardCount.from(waitForActiveShards));
     *                  For Level.INDICES - information on indices will be returned to the transport client.
        }  
     * total number of shard copies to wait for.
    private String[] indices;
    }  
     *                  For Level.CLUSTER (or) Level.AWARENESS_ATTRIBUTES - information on indices/shards will NOT be returned to the transport client
    public boolean isApplyLevelAtTransportLayer() {
 * @opensearch.api
    public ClusterHealthRequest(String... indices) {
                break;
    private ActiveShardCount waitForActiveShards = ActiveShardCount.NONE;
    }
        out.writeBoolean(waitForNoInitializingShards);
    public ClusterHealthRequest waitForNoRelocatingShards(boolean waitForNoRelocatingShards) {
     */
        }  
    }
 * not use this file except in compliance with the License.
}
 * Unless required by applicable law or agreed to in writing,
        waitForActiveShards.writeTo(out);  
    }  
import org.opensearch.common.unit.TimeValue;
        this.awarenessAttribute = awarenessAttribute;
    public ClusterHealthRequest waitForGreenStatus() {
/*
     */  
        }
    }  
                break;
    private String waitForNodes = "";  
        waitForNodes = in.readString();
 * this file be licensed under the Apache-2.0 license or a
public class ClusterHealthRequest extends ClusterManagerNodeReadRequest<ClusterHealthRequest> implements IndicesRequest.Replaceable {
    private Level level = Level.CLUSTER;
        return this;  
        super(in);  
/*  
        return waitForNodes;
    }  
    @Override  
 * KIND, either express or implied.  See the License for the
        } else {
    public ClusterHealthRequest waitForEvents(Priority waitForEvents) {
     * Only used by the high-level REST Client.  
    public void setLevel(String level) {  
 * GitHub history for details.
     * operation does not wait on there being no more relocating shards.  Set to <code>true</code>
 * SPDX-License-Identifier: Apache-2.0
     * The default value is 'cluster'.
    public String waitForNodes() {
        this.indices = indices;
    }
    }  
     * By default, the flag is disabled.
    /**  
        if (indices == null) {
 * The OpenSearch Contributors require contributions made to  
     * Only used by the high-level REST Client. Controls the details level of the health information returned.
import org.opensearch.action.ActionRequestValidationException;
    }
        return indicesOptions;
        } else {
    public ClusterHealthRequest waitForStatus(ClusterHealthStatus waitForStatus) {
    }  
        }
        waitForNoInitializingShards = in.readBoolean();  
     */
    }
import org.opensearch.core.common.io.stream.StreamInput;
        return this;  
    /**
    public ClusterHealthRequest timeout(TimeValue timeout) {
    public boolean waitForNoInitializingShards() {  
            out.writeBoolean(ensureNodeWeighedIn);  
import org.opensearch.action.support.IndicesOptions;
    /**  
        this.waitForEvents = waitForEvents;
     * Waits for N number of nodes. Use "12" for exact mapping, "&gt;12" and "&lt;12" for range.  
        }
    public final ClusterHealthRequest ensureNodeWeighedIn(boolean ensureNodeWeighedIn) {  
 * under the License.  
        return true;  
        return this.timeout(TimeValue.parseTimeValue(timeout, null, getClass().getSimpleName() + ".timeout"));
     * Sets the number of shard copies that must be active across all indices before getting the
        if (waitForActiveShards.equals(ActiveShardCount.DEFAULT)) {
    }
    private ClusterHealthStatus waitForStatus;
            case "indices":
        SHARDS,
        this.level = Objects.requireNonNull(level, "level must not be null");  
    public Priority waitForEvents() {  
     */  
        AWARENESS_ATTRIBUTES  
    /**
     *
    public ClusterHealthRequest(StreamInput in) throws IOException {
    public ClusterHealthRequest setAwarenessAttribute(String awarenessAttribute) {  
        this.waitForNoInitializingShards = waitForNoInitializingShards;
    public enum Level {
        if (out.getVersion().onOrAfter(Version.V_2_6_0)) {
    }
 */  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        } else if (!level.equals(Level.AWARENESS_ATTRIBUTES) && awarenessAttribute != null) {
    public ActionRequestValidationException validate() {
        INDICES,
            return addValidationError("level=awareness_attributes is required with awareness_attribute parameter", null);  
        }
    @Override
 * ownership. Elasticsearch licenses this file to you under  
        return ensureNodeWeighedIn;
        return waitForStatus(ClusterHealthStatus.YELLOW);  
        return timeout;
     * Get the level of detail for the health information to be returned.
        }
    private Priority waitForEvents = null;
        }
     * to get the ActiveShardCount.
     */
        if (level.equals(Level.AWARENESS_ATTRIBUTES) && indices.length > 0) {  
        }
 * license agreements. See the NOTICE file distributed with
            out.writeBoolean(false);  
    /**
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
 * specific language governing permissions and limitations
     * retrieving the cluster health status.  Defaults to {@code false}, meaning the  
import java.util.concurrent.TimeUnit;
            default:
import java.util.Objects;  
        return this;
        timeout = in.readTimeValue();
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {  
 */  
    public boolean waitForNoRelocatingShards() {  
        }
     * Only used by the high-level REST Client.  
     *                  For Level.SHARDS - information on indices and shards will be returned to the transport client  
    private boolean ensureNodeWeighedIn = false;
    @Override
            out.writeOptionalString(awarenessAttribute);
 * You may obtain a copy of the License at  
        if (in.getVersion().onOrAfter(Version.V_2_5_0)) {
    }
            out.writeVInt(0);  
 * Modifications Copyright OpenSearch Contributors. See
    public ClusterHealthStatus waitForStatus() {
        if (in.getVersion().onOrAfter(Version.V_2_6_0)) {  
    public ClusterHealthRequest waitForActiveShards(ActiveShardCount waitForActiveShards) {  
        indicesOptions.writeIndicesOptions(out);  
            out.writeBoolean(true);
    /**
        return null;
    }
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
    }
        return waitForNoRelocatingShards;
        if (out.getVersion().onOrAfter(Version.V_2_5_0)) {
    public ClusterHealthRequest indices(String... indices) {
            out.writeByte(waitForStatus.value());  
        return this;  
    private boolean applyLevelAtTransportLayer = false;  
    }
            case "shards":
    public void writeTo(StreamOutput out) throws IOException {  
@PublicApi(since = "1.0.0")
     */
        return waitForActiveShards;
        indicesOptions = IndicesOptions.readIndicesOptions(in);
    }
        switch (level) {
            level = in.readEnum(Level.class);
    public void level(Level level) {
import org.opensearch.common.annotation.PublicApi;  
            awarenessAttribute = in.readOptionalString();  
/**
        }
    /**
        super.writeTo(out);
        if (in.readBoolean()) {  
    }
        return this;
import org.opensearch.action.IndicesRequest;  
 *
    }
        return waitForStatus(ClusterHealthStatus.GREEN);
    /**
     * all replicas) to be active across all indices in the cluster. Otherwise, use
    public ClusterHealthRequest waitForYellowStatus() {
    }
        out.writeString(waitForNodes);
    }  
     */  
 */
            out.writeEnum(level);  
    public ClusterHealthRequest waitForNoInitializingShards(boolean waitForNoInitializingShards) {
     * When the flag is disabled - indices/shard info will be returned in ClusterHealthResponse regardless of the health level requested.
     */
            applyLevelAtTransportLayer = in.readBoolean();
 * this work for additional information regarding copyright
    }  
        this.indicesOptions = indicesOptions;  
     * operation does not wait on there being no more initializing shards.  Set to <code>true</code>
        return this;
        return this;  
     * The level of the health request.  
        this.waitForNodes = waitForNodes;  
        CLUSTER,  
            case "awareness_attributes":
            out.writeBoolean(applyLevelAtTransportLayer);  
            out.writeBoolean(true);
    public ClusterHealthRequest() {}
    /**
        if (in.readBoolean()) {  
            out.writeBoolean(false);  
    public Level level() {
     * to wait until the number of relocating shards in the cluster is 0.
        out.writeBoolean(waitForNoRelocatingShards);
        this.applyLevelAtTransportLayer = applyLevelAtTransportLayer;
        } else {
 * software distributed under the License is distributed on an
    }
    public ClusterHealthRequest waitForNodes(String waitForNodes) {
import org.opensearch.cluster.health.ClusterHealthStatus;
package org.opensearch.action.admin.cluster.health;
                level(ClusterHealthRequest.Level.AWARENESS_ATTRIBUTES);  
     * Sets whether the request should wait for there to be no relocating shards before
        if (ensureNodeWeighedIn && local == false) {
        this.indices = indices;
        return level;  
    }
    }
        }
    @PublicApi(since = "1.0.0")
    @Override
        if (clusterManagerNodeTimeout == DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT) {  
    private String awarenessAttribute;
    private boolean waitForNoInitializingShards = false;
        this.waitForNoRelocatingShards = waitForNoRelocatingShards;
            return addValidationError("awareness_attribute is not a supported parameter with index health", null);
    private IndicesOptions indicesOptions = IndicesOptions.lenientExpandHidden();  
import org.opensearch.common.Priority;
    public String getAwarenessAttribute() {
    private TimeValue timeout = new TimeValue(30, TimeUnit.SECONDS);
     * @opensearch.api
     * When the flag is enabled - indices/shards info will be set according to health level requested.  
            this.waitForActiveShards = ActiveShardCount.NONE;  
        }
        return this;
     * {@link ActiveShardCount#from(int)} to set this value to any non-negative integer, up to the  
    }
    }
        }
 */  
    }
    public ClusterHealthRequest indicesOptions(final IndicesOptions indicesOptions) {
        return waitForStatus;
     * A shortcut for {@link #waitForActiveShards(ActiveShardCount)} where the numerical
            out.writeStringArray(indices);
 *  
    public ClusterHealthRequest timeout(String timeout) {  
        waitForActiveShards = ActiveShardCount.readFrom(in);
        return this.waitForEvents;
import static org.opensearch.action.ValidateActions.addValidationError;  
        }
        indices = in.readStringArray();
     * retrieving the cluster health status.  Defaults to {@code false}, meaning the  
        if (waitForStatus == null) {
    }  
    }
     * Set this value to {@link ActiveShardCount#ALL} to wait for all shards (primary and
    public ActiveShardCount waitForActiveShards() {  
    }
    }
                break;
import org.opensearch.action.support.ActiveShardCount;
        return indices;  
     * For a given local request, checks if the local node is commissioned or not (default: false).  
    public TimeValue timeout() {  
 * compatible open source license.
    /**
import java.io.IOException;
    public boolean includeDataStreams() {
/*  
 * the Apache License, Version 2.0 (the "License"); you may
            return addValidationError("not a local request to ensure local node commissioned or weighed in", null);  
    }
                level(ClusterHealthRequest.Level.SHARDS);  
