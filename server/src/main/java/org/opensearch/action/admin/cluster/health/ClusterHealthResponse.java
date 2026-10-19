        ClusterState clusterState,
 * You may obtain a copy of the License at
        builder.field(UNASSIGNED_SHARDS, getUnassignedShards());
    public int getNumberOfDataNodes() {
                timedOut,
        out.writeInt(numberOfPendingTasks);
        if (outputIndices) {
        int numberOfInFlightFetch,
        return this.numberOfInFlightFetch;
    // package private for testing
    /**
        return new ClusterHealthResponse(in);
            final Map<String, ClusterIndexHealth> indices;
        return clusterStateHealth.getActiveShards();
        }
        builder.field(ACTIVE_SHARDS, getActiveShards());
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
import org.opensearch.core.rest.RestStatus;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return this.delayedUnassignedShards;
    }
        TimeValue taskMaxWaitingTime
    }
    private TimeValue taskMaxWaitingTime = TimeValue.timeValueMillis(0);
 */
                activeShardsPercent,
        String index) -> ClusterIndexHealth.innerFromXContent(parser, index);
    public ClusterAwarenessHealth getClusterAwarenessHealth() {
    private static final String ACTIVE_SHARDS_PERCENT = "active_shards_percent";
    private static final String INDICES = "indices";
    public String toString() {
        return clusterStateHealth.getNumberOfNodes();
     *
        this.clusterName = clusterName;
            double activeShardsPercent = (double) parsedObjects[i++];
            int numberOfNodes = (int) parsedObjects[i++];
                hasDiscoveredClusterManager || hasDiscoveredMaster,
            for (ClusterIndexHealth indexHealth : clusterStateHealth.getIndices().values()) {
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_NODES));
    @Override
import org.opensearch.Version;
        builder.field(NUMBER_OF_IN_FLIGHT_FETCH, getNumberOfInFlightFetch());
        }
            );
            clusterName,
        }
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_DATA_NODES));
    @Override
        this.clusterHealthStatus = status;
    private static final ObjectParser.NamedObjectParser<ClusterIndexHealth, Void> INDEX_PARSER = (
        timedOut = in.readBoolean();
    public ClusterHealthResponse(
                numberOfNodes,
    }
    public boolean equals(Object o) {
            int activePrimaryShards = (int) parsedObjects[i++];
    public int getNumberOfPendingTasks() {
        builder.field(DISCOVERED_CLUSTER_MANAGER, hasDiscoveredClusterManager());
    @Override
 * specific language governing permissions and limitations
            boolean timedOut = (boolean) parsedObjects[i];
 * GitHub history for details.
            int numberOfDataNodes = (int) parsedObjects[i++];
        this.delayedUnassignedShards = clusterStateHealth.getDelayedUnassignedShards();
        PARSER.declareBoolean(optionalConstructorArg(), new ParseField(DISCOVERED_MASTER));
            clusterHealthRequest,
            int i = 0;
    }
 * Transport response for Cluster Health
     * For XContent Parser and serialization tests
     */
        if (status == null) {
import org.opensearch.cluster.health.ClusterIndexHealth;
/**
        return clusterStateHealth.hasDiscoveredClusterManager();
        // ClusterHealthResponse fields
        return clusterHealthStatus;
        return clusterName;
    }
    private static final String NUMBER_OF_PENDING_TASKS = "number_of_pending_tasks";
    ) {
import java.io.IOException;
    private String clusterName;
            numberOfInFlightFetch,
        PARSER.declareBoolean(constructorArg(), new ParseField(TIMED_OUT));
                }
 * software distributed under the License is distributed on an
            }
            clusterState,
        Void context,
    private static final String TASK_MAX_WAIT_TIME_IN_QUEUE_IN_MILLIS = "task_max_waiting_in_queue_millis";
        this.clusterHealthStatus = clusterStateHealth.getStatus();
                relocatingShards,
        out.writeInt(delayedUnassignedShards);
            taskMaxWaitingTime,
        this(
import org.opensearch.core.xcontent.XContentBuilder;
        PARSER.declareInt(constructorArg(), new ParseField(ACTIVE_SHARDS));
        String[] concreteIndices,
            numberOfInFlightFetch,
        this(
            clusterName,
 */
        numberOfInFlightFetch = in.readInt();
        out.writeByte(clusterHealthStatus.value());
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_IN_FLIGHT_FETCH));
        this.clusterStateHealth = clusterStateHealth;
    private ClusterAwarenessHealth clusterAwarenessHealth;
    public int getUnassignedShards() {
    private static final String TASK_MAX_WAIT_TIME_IN_QUEUE = "task_max_waiting_in_queue";
import org.opensearch.common.unit.TimeValue;
        out.writeBoolean(timedOut);
            builder.startObject(INDICES);
    public static ClusterHealthResponse readResponseFrom(StreamInput in) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {
            taskMaxWaitingTime
    }
            clusterAwarenessHealth.toXContent(builder, params);
        return clusterStateHealth.getInitializingShards();
        numberOfPendingTasks = in.readInt();
    ClusterStateHealth getClusterStateHealth() {
            delayedUnassignedShards,
        builder.field(RELOCATING_SHARDS, getRelocatingShards());
    }
        builder.field(NUMBER_OF_NODES, getNumberOfNodes());
 * this file be licensed under the Apache-2.0 license or a
                out.writeBoolean(true);
            // ClusterHealthResponse fields
    ) {
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
            builder.endObject();
     * back in order to allocate the shards back to it).
        int numberOfPendingTasks,
    }
        if (this == o) return true;
        PARSER.declareString(constructorArg(), new ParseField(CLUSTER_NAME));
import org.opensearch.core.action.ActionResponse;
        taskMaxWaitingTime = in.readTimeValue();
 *
        delayedUnassignedShards = in.readInt();
     * due to node leaving the cluster and waiting for a timeout for the node to come
        int numberOfPendingTasks,
     * @param status The override status. Must not be null.
        int numberOfPendingTasks,
                out.writeBoolean(false);
    }
        return clusterAwarenessHealth;
 * @opensearch.api
        builder.field(ACTIVE_PRIMARY_SHARDS, getActivePrimaryShards());
        PARSER.declareInt(constructorArg(), new ParseField(RELOCATING_SHARDS));
        return clusterStateHealth.getIndices();
    @Override
        PARSER.declareInt(constructorArg(), new ParseField(DELAYED_UNASSIGNED_SHARDS));
    public boolean hasDiscoveredClusterManager() {
        return clusterStateHealth.getActiveShardsPercent();
        return clusterStateHealth.getRelocatingShards();
    );
    /**
    }
    public ClusterHealthResponse(
            int unassignedShards = (int) parsedObjects[i++];
        String awarenessAttributeName,
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
        XContentParser parser,
        PARSER.declareNamedObjects(optionalConstructorArg(), INDEX_PARSER, new ParseField(INDICES));
        TimeValue taskMaxWaitingTime
        builder.field(TIMED_OUT, isTimedOut());
     * {@code true} if the waitForXXX has timeout out and did not match.
            int activeShards = (int) parsedObjects[i++];
    }
    }
                indexHealth.toXContent(builder, params);
import static java.util.Collections.emptyMap;
    @Override
        boolean outputAwarenessHealth = "awareness_attributes".equals(level);
        if (o == null || getClass() != o.getClass()) return false;
    static {
        return clusterStateHealth;
            ClusterStateHealth stateHealth = new ClusterStateHealth(
    private boolean timedOut = false;
        return Objects.equals(clusterName, that.clusterName)
        int numberOfInFlightFetch,
package org.opensearch.action.admin.cluster.health;
        this(clusterName, concreteIndices, clusterState, -1, -1, -1, TimeValue.timeValueHours(0));
                indices = new HashMap<>(indexList.size());
        builder.field(INITIALIZING_SHARDS, getInitializingShards());
        "cluster_health_response",
        this.numberOfInFlightFetch = numberOfInFlightFetch;
import org.opensearch.common.settings.ClusterSettings;
        this.clusterName = clusterName;
    private static final String ACTIVE_SHARDS_PERCENT_AS_NUMBER = "active_shards_percent_as_number";
import java.util.HashMap;
            int initializingShards = (int) parsedObjects[i++];
        String clusterName,
        return PARSER.apply(parser, null);
            int numberOfPendingTasks = (int) parsedObjects[i++];
            int numberOfInFlightFetch = (int) parsedObjects[i++];
    }
import org.opensearch.core.ParseField;
        if (in.getVersion().onOrAfter(Version.V_2_5_0)) {
        clusterName = in.readString();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String awarenessAttributeName,
    @Deprecated
            && numberOfPendingTasks == that.numberOfPendingTasks
        PARSER.declareInt(constructorArg(), new ParseField(INITIALIZING_SHARDS));
        clusterHealthStatus = ClusterHealthStatus.fromValue(in.readByte());
    public int getRelocatingShards() {
        ClusterState clusterState,
            numberOfInFlightFetch,
        true,
        builder.humanReadableField(TASK_MAX_WAIT_TIME_IN_QUEUE_IN_MILLIS, TASK_MAX_WAIT_TIME_IN_QUEUE, getTaskMaxWaitingTime());
        this.clusterHealthStatus = clusterStateHealth.getStatus();
        }
        int numberOfPendingTasks,
        PARSER.declareLong(constructorArg(), new ParseField(TASK_MAX_WAIT_TIME_IN_QUEUE_IN_MILLIS));
    }
        this.clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, awarenessAttributeName);
    private static final String TIMED_OUT = "timed_out";
                TimeValue.timeValueMillis(taskMaxWaitingTimeMillis),
        int numberOfInFlightFetch,
        this.timedOut = timedOut;
    private static final String DISCOVERED_MASTER = "discovered_master";
    private static final String ACTIVE_PRIMARY_SHARDS = "active_primary_shards";
 * Licensed to Elasticsearch under one or more contributor
    public int getDelayedUnassignedShards() {
import java.util.Objects;
 * the Apache License, Version 2.0 (the "License"); you may
        String clusterName,
@PublicApi(since = "1.0.0")
    }
    }
            && Objects.equals(clusterStateHealth, that.clusterStateHealth)
        boolean timedOut,
            // ClusterStateHealth fields
    public ClusterHealthResponse(
 *
        return Strings.toString(MediaTypeRegistry.JSON, this);
     */
/*
    private int numberOfInFlightFetch = 0;
            : new ClusterStateHealth(clusterState, concreteIndices);
        ClusterState clusterState,
        out.writeTimeValue(taskMaxWaitingTime);
            } else {
                clusterAwarenessHealth.writeTo(out);
    public static ClusterHealthResponse fromXContent(XContentParser parser) {
            taskMaxWaitingTime
        ClusterSettings clusterSettings,
            ? new ClusterStateHealth(clusterState, concreteIndices, clusterHealthRequest.level())
    }
            }
            numberOfPendingTasks,
        builder.field(DISCOVERED_MASTER, hasDiscoveredClusterManager());  // the field will be removed in a future major version
        TimeValue taskMaxWaitingTime,
    public int getNumberOfNodes() {
    public int getActivePrimaryShards() {
                activeShards,
            && timedOut == that.timedOut
    // Awareness Attribute health
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_PENDING_TASKS));
    }
                status,
        TimeValue taskMaxWaitingTime
import java.util.Locale;
            }
        // ClusterStateHealth fields
    private static final String NUMBER_OF_DATA_NODES = "number_of_data_nodes";
/*
    ) {
    }
        String[] concreteIndices,
        this.numberOfPendingTasks = numberOfPendingTasks;
        out.writeInt(numberOfInFlightFetch);
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentParser;
    public int getActiveShards() {
    /**
        builder.field(NUMBER_OF_DATA_NODES, getNumberOfDataNodes());
    private static final String DISCOVERED_CLUSTER_MANAGER = "discovered_cluster_manager";
    private static final String NUMBER_OF_IN_FLIGHT_FETCH = "number_of_in_flight_fetch";
 */
        this.taskMaxWaitingTime = taskMaxWaitingTime;
    private static final String DELAYED_UNASSIGNED_SHARDS = "delayed_unassigned_shards";
        );
    }
            int relocatingShards = (int) parsedObjects[i++];
    }
        this.numberOfInFlightFetch = numberOfInFlightFetch;
            if (clusterAwarenessHealth != null) {
        return this.timedOut;
            && clusterHealthStatus == that.clusterHealthStatus;
 * compatible open source license.
                unassignedShards,
    }
    }
     * @return The maximum wait time of all tasks in the queue
        return clusterStateHealth.getUnassignedShards();
    public boolean isTimedOut() {
        this.clusterStateHealth = clusterHealthRequest.isApplyLevelAtTransportLayer()
        builder.field(CLUSTER_NAME, getClusterName());
            );
        ClusterState clusterState,
    private static final String ACTIVE_SHARDS = "active_shards";
            concreteIndices,
 * Unless required by applicable law or agreed to in writing,
            clusterName,
            }
import org.opensearch.common.annotation.PublicApi;
     */
    /**
        this.clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, awarenessAttributeName);
    public int getInitializingShards() {
        boolean outputIndices = "indices".equals(level) || "shards".equals(level);
        int delayedUnassignedShards,
 * ownership. Elasticsearch licenses this file to you under
        TimeValue taskMaxWaitingTime
    private static final String INITIALIZING_SHARDS = "initializing_shards";
    private ClusterStateHealth clusterStateHealth;
        ClusterHealthRequest clusterHealthRequest,
        PARSER.declareString(constructorArg(), new ParseField(STATUS));
        PARSER.declareBoolean(optionalConstructorArg(), new ParseField(DISCOVERED_CLUSTER_MANAGER));
import org.opensearch.cluster.ClusterState;
    private static final ConstructingObjectParser<ClusterHealthResponse, Void> PARSER = new ConstructingObjectParser<>(
import java.util.List;
        String clusterName,
 * SPDX-License-Identifier: Apache-2.0
    private static final String CLUSTER_NAME = "cluster_name";
    }
                indices
    /** needed for plugins BWC */
    public void setStatus(ClusterHealthStatus status) {
        clusterStateHealth.writeTo(out);
        int numberOfPendingTasks,
            && delayedUnassignedShards == that.delayedUnassignedShards
    }
                activePrimaryShards,
    public Map<String, ClusterIndexHealth> getIndices() {
            List<ClusterIndexHealth> indexList = (List<ClusterIndexHealth>) parsedObjects[i++];
    }
    public int getNumberOfInFlightFetch() {
        this.taskMaxWaitingTime = taskMaxWaitingTime;
        builder.field(DELAYED_UNASSIGNED_SHARDS, getDelayedUnassignedShards());
     */
        return taskMaxWaitingTime;
    public ClusterHealthResponse(
 * KIND, either express or implied.  See the License for the
            clusterStateHealth,
            int delayedUnassignedShards = (int) parsedObjects[i++];
                stateHealth
        int delayedUnassignedShards,
import org.opensearch.core.common.Strings;
}
        ClusterStateHealth clusterStateHealth
        ClusterSettings clusterSettings,
    public int hashCode() {
 * Modifications Copyright OpenSearch Contributors. See
        );
    public void setTimedOut(boolean timedOut) {
    }
        PARSER.declareDouble(constructorArg(), new ParseField(ACTIVE_SHARDS_PERCENT_AS_NUMBER));
 *
        String[] concreteIndices,
        return isTimedOut() ? RestStatus.REQUEST_TIMEOUT : RestStatus.OK;
            concreteIndices,
        );
        return Objects.hash(
    public String getClusterName() {
        }
        this.numberOfPendingTasks = numberOfPendingTasks;
    @Override
        this.clusterStateHealth = new ClusterStateHealth(clusterState, concreteIndices);
        out.writeString(clusterName);
    private static final String NUMBER_OF_NODES = "number_of_nodes";
import org.opensearch.cluster.health.ClusterStateHealth;
        this.numberOfInFlightFetch = numberOfInFlightFetch;
    public ClusterHealthResponse(String clusterName, String[] concreteIndices, ClusterState clusterState) {
    }
            String clusterName = (String) parsedObjects[i++];
        if (out.getVersion().onOrAfter(Version.V_2_5_0)) {
    private int delayedUnassignedShards = 0;
            timedOut,
    }
public class ClusterHealthResponse extends ActionResponse implements StatusToXContentObject {
        ClusterHealthResponse that = (ClusterHealthResponse) o;
        builder.field(NUMBER_OF_PENDING_TASKS, getNumberOfPendingTasks());
        this.numberOfPendingTasks = numberOfPendingTasks;
 *
        String[] concreteIndices,
        this.delayedUnassignedShards = delayedUnassignedShards;
    }
    public ClusterHealthResponse(StreamInput in) throws IOException {
        int delayedUnassignedShards,
        }
                numberOfDataNodes,
            numberOfPendingTasks,
    ) {
    }
        return clusterStateHealth.getActivePrimaryShards();
        PARSER.declareInt(constructorArg(), new ParseField(UNASSIGNED_SHARDS));
    private static final String UNASSIGNED_SHARDS = "unassigned_shards";
import org.opensearch.cluster.health.ClusterHealthStatus;
            boolean hasDiscoveredClusterManager = Boolean.TRUE.equals(parsedObjects[i++]);
            && numberOfInFlightFetch == that.numberOfInFlightFetch
            long taskMaxWaitingTimeMillis = (long) parsedObjects[i++];
        int numberOfInFlightFetch,
import org.opensearch.cluster.awarenesshealth.ClusterAwarenessHealth;
    ClusterHealthResponse(
            return new ClusterHealthResponse(
        ClusterHealthRequest clusterHealthRequest,
        this.delayedUnassignedShards = delayedUnassignedShards;
    public TimeValue getTaskMaxWaitingTime() {
        builder.field(STATUS, getStatus().name().toLowerCase(Locale.ROOT));
            && Objects.equals(taskMaxWaitingTime, that.taskMaxWaitingTime)
                    indices.put(indexHealth.getIndex(), indexHealth);
     */
        builder.startObject();
    }
        String clusterName,
    /**
                clusterName,
        this.timedOut = timedOut;
     * Allows to explicitly override the derived cluster health status.
    private int numberOfPendingTasks = 0;
        return clusterStateHealth.getNumberOfDataNodes();
            @SuppressWarnings("unchecked")
            clusterState,
 * under the License.
        return this.numberOfPendingTasks;
                numberOfPendingTasks,
            delayedUnassignedShards,
/*
    public RestStatus status() {
    }
                indices = emptyMap();
            boolean hasDiscoveredMaster = Boolean.TRUE.equals(parsedObjects[i++]);
        builder.endObject();
    public ClusterHealthResponse() {}
        builder.percentageField(ACTIVE_SHARDS_PERCENT_AS_NUMBER, ACTIVE_SHARDS_PERCENT, getActiveShardsPercent());
    private static final String STATUS = "status";
        // Can be absent if LEVEL == 'cluster'
        if (outputAwarenessHealth && clusterAwarenessHealth != null) {
        String clusterName,
        super(in);
                initializingShards,
                clusterAwarenessHealth = new ClusterAwarenessHealth(in);
            throw new IllegalArgumentException("'status' must not be null");
     * The number of unassigned shards that are currently being delayed (for example,
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 * not use this file except in compliance with the License.
        PARSER.declareInt(constructorArg(), new ParseField(ACTIVE_PRIMARY_SHARDS));
            if (in.readBoolean()) {
import org.opensearch.common.xcontent.StatusToXContentObject;
                for (ClusterIndexHealth indexHealth : indexList) {
        String level = params.param("level", "cluster");
        parsedObjects -> {
     */
        this.taskMaxWaitingTime = taskMaxWaitingTime;
                numberOfInFlightFetch,
                delayedUnassignedShards,
 * license agreements. See the NOTICE file distributed with
    }
            numberOfPendingTasks,
    public double getActiveShardsPercent() {
    private ClusterHealthStatus clusterHealthStatus;
    }
    ) {
        clusterStateHealth = new ClusterStateHealth(in);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.Map;
    }
    private static final String RELOCATING_SHARDS = "relocating_shards";
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.core.xcontent.ConstructingObjectParser;
        return builder;
            clusterHealthStatus
    public ClusterHealthStatus getStatus() {
     * The percentage of active shards, should be 100% in a green system
 * The OpenSearch Contributors require contributions made to
        this.clusterName = clusterName;
        int numberOfInFlightFetch,
     *
            } else {
            if (indexList == null || indexList.isEmpty()) {
            String statusStr = (String) parsedObjects[i++];
        this.clusterHealthStatus = clusterStateHealth.getStatus();
import org.opensearch.core.common.io.stream.StreamInput;
            ClusterHealthStatus status = ClusterHealthStatus.fromString(statusStr);
