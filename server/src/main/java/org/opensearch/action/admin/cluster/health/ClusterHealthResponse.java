        String awarenessAttributeName,
            }
        return clusterStateHealth.getInitializingShards();
        String clusterName,
    private static final String TASK_MAX_WAIT_TIME_IN_QUEUE = "task_max_waiting_in_queue";
        String[] concreteIndices,
 * ownership. Elasticsearch licenses this file to you under  
    }
            taskMaxWaitingTime,  
            timedOut,
        PARSER.declareInt(constructorArg(), new ParseField(ACTIVE_PRIMARY_SHARDS));
        PARSER.declareInt(constructorArg(), new ParseField(RELOCATING_SHARDS));
/*  
    /**  
        String clusterName,  
                indices = new HashMap<>(indexList.size());  
        PARSER.declareString(constructorArg(), new ParseField(CLUSTER_NAME));
    @Deprecated
    public boolean hasDiscoveredClusterManager() {
        int numberOfInFlightFetch,  
     */  
    }
        PARSER.declareInt(constructorArg(), new ParseField(ACTIVE_SHARDS));  
    public int getNumberOfDataNodes() {
            clusterState,
                numberOfNodes,
            }
    public ClusterHealthResponse(StreamInput in) throws IOException {
        int numberOfPendingTasks,
        builder.field(TIMED_OUT, isTimedOut());
        clusterHealthStatus = ClusterHealthStatus.fromValue(in.readByte());
        return builder;
        String[] concreteIndices,
    public int getInitializingShards() {
        return clusterAwarenessHealth;
    }  
    public int getNumberOfNodes() {  
                numberOfPendingTasks,  
import org.opensearch.core.ParseField;
                unassignedShards,
    ) {
 * @opensearch.api
            numberOfPendingTasks,
            } else {
package org.opensearch.action.admin.cluster.health;
     * {@code true} if the waitForXXX has timeout out and did not match.  
            numberOfInFlightFetch,  
    private static final String ACTIVE_SHARDS = "active_shards";  
            : new ClusterStateHealth(clusterState, concreteIndices);
    }
 * compatible open source license.
        PARSER.declareBoolean(constructorArg(), new ParseField(TIMED_OUT));
import org.opensearch.cluster.health.ClusterHealthStatus;
import org.opensearch.core.xcontent.XContentParser;  
import java.util.Locale;
        builder.field(RELOCATING_SHARDS, getRelocatingShards());
        // Can be absent if LEVEL == 'cluster'
        TimeValue taskMaxWaitingTime
            if (in.readBoolean()) {  
import java.io.IOException;
    public ClusterHealthResponse(
    public double getActiveShardsPercent() {
            ? new ClusterStateHealth(clusterState, concreteIndices, clusterHealthRequest.level())
    public RestStatus status() {
    /**
        this.timedOut = timedOut;
            }
    /**  
    ClusterStateHealth getClusterStateHealth() {  
        numberOfInFlightFetch = in.readInt();
    private String clusterName;
import org.opensearch.core.common.io.stream.StreamInput;
            @SuppressWarnings("unchecked")  
            List<ClusterIndexHealth> indexList = (List<ClusterIndexHealth>) parsedObjects[i++];
            delayedUnassignedShards,
                for (ClusterIndexHealth indexHealth : indexList) {
        // ClusterHealthResponse fields
    // package private for testing
     */  
            numberOfInFlightFetch,
        return clusterStateHealth;
import org.opensearch.cluster.ClusterState;
        this.clusterHealthStatus = clusterStateHealth.getStatus();  
        return clusterStateHealth.getActivePrimaryShards();
    }  
            if (indexList == null || indexList.isEmpty()) {  
    }
        int numberOfPendingTasks,
 */  
 */
    }  
     * due to node leaving the cluster and waiting for a timeout for the node to come
        ClusterStateHealth clusterStateHealth
            clusterHealthRequest,  
    /** needed for plugins BWC */  
            int numberOfInFlightFetch = (int) parsedObjects[i++];  
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
    @Override
    private static final String INDICES = "indices";
 *  
        this.taskMaxWaitingTime = taskMaxWaitingTime;
            && numberOfPendingTasks == that.numberOfPendingTasks
import org.opensearch.cluster.health.ClusterIndexHealth;
    }
 * this file be licensed under the Apache-2.0 license or a
        parsedObjects -> {  
            numberOfPendingTasks,
    private ClusterStateHealth clusterStateHealth;
import org.opensearch.Version;
    /**
        this.clusterName = clusterName;  
    private int delayedUnassignedShards = 0;
        builder.field(CLUSTER_NAME, getClusterName());
        out.writeInt(delayedUnassignedShards);
import static java.util.Collections.emptyMap;  
 */
        String clusterName,
    private static final String INITIALIZING_SHARDS = "initializing_shards";
        this.delayedUnassignedShards = clusterStateHealth.getDelayedUnassignedShards();
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    }  
        return clusterStateHealth.getIndices();  
            int numberOfDataNodes = (int) parsedObjects[i++];
    }
        this.clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, awarenessAttributeName);  
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_PENDING_TASKS));  
        out.writeInt(numberOfInFlightFetch);  
    ) {
    }  
        int numberOfInFlightFetch,
    public int getRelocatingShards() {
    }
        PARSER.declareBoolean(optionalConstructorArg(), new ParseField(DISCOVERED_MASTER));
        XContentParser parser,
        this(
            // ClusterHealthResponse fields  
    }
        out.writeTimeValue(taskMaxWaitingTime);
    private static final String ACTIVE_SHARDS_PERCENT = "active_shards_percent";
                numberOfDataNodes,  
        return this.numberOfPendingTasks;
import org.opensearch.cluster.health.ClusterStateHealth;  
 * GitHub history for details.
 * software distributed under the License is distributed on an
                numberOfInFlightFetch,
    private static final String NUMBER_OF_IN_FLIGHT_FETCH = "number_of_in_flight_fetch";
 * Licensed to Elasticsearch under one or more contributor  
        return PARSER.apply(parser, null);
                indices
     * back in order to allocate the shards back to it).
     */
    private static final String STATUS = "status";  
        this.delayedUnassignedShards = delayedUnassignedShards;
@PublicApi(since = "1.0.0")  
        this.clusterAwarenessHealth = new ClusterAwarenessHealth(clusterState, clusterSettings, awarenessAttributeName);
import org.opensearch.common.unit.TimeValue;  
        ClusterHealthRequest clusterHealthRequest,
    public ClusterHealthResponse(
            && timedOut == that.timedOut  
        PARSER.declareInt(constructorArg(), new ParseField(UNASSIGNED_SHARDS));
        }
        PARSER.declareNamedObjects(optionalConstructorArg(), INDEX_PARSER, new ParseField(INDICES));
    }  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        ClusterState clusterState,
        this.numberOfInFlightFetch = numberOfInFlightFetch;
    ) {
import org.opensearch.core.common.Strings;
    public void writeTo(StreamOutput out) throws IOException {  
        builder.field(DELAYED_UNASSIGNED_SHARDS, getDelayedUnassignedShards());
        this.numberOfPendingTasks = numberOfPendingTasks;  
        super(in);
        int numberOfPendingTasks,
    public int getDelayedUnassignedShards() {
    private static final String DISCOVERED_MASTER = "discovered_master";
        PARSER.declareInt(constructorArg(), new ParseField(INITIALIZING_SHARDS));  
            } else {
        out.writeString(clusterName);
            && clusterHealthStatus == that.clusterHealthStatus;
/**
        return clusterStateHealth.getUnassignedShards();  
    }
     * @param status The override status. Must not be null.
    }
    @Override
                indexHealth.toXContent(builder, params);  
        PARSER.declareLong(constructorArg(), new ParseField(TASK_MAX_WAIT_TIME_IN_QUEUE_IN_MILLIS));  
import java.util.List;
        builder.field(NUMBER_OF_NODES, getNumberOfNodes());
        ClusterSettings clusterSettings,
    );
    public void setTimedOut(boolean timedOut) {  
    public int hashCode() {  
        return Objects.hash(
        }  
        boolean outputIndices = "indices".equals(level) || "shards".equals(level);  
     *
            String clusterName = (String) parsedObjects[i++];
            concreteIndices,  
        out.writeInt(numberOfPendingTasks);
        return clusterStateHealth.getActiveShards();
                stateHealth
    ClusterHealthResponse(  
        int delayedUnassignedShards,
        this.taskMaxWaitingTime = taskMaxWaitingTime;
        this.numberOfPendingTasks = numberOfPendingTasks;  
        builder.field(NUMBER_OF_DATA_NODES, getNumberOfDataNodes());  
    @Override
        int delayedUnassignedShards,
    private TimeValue taskMaxWaitingTime = TimeValue.timeValueMillis(0);
 * the Apache License, Version 2.0 (the "License"); you may
    // Awareness Attribute health
     * For XContent Parser and serialization tests
    }  
        String[] concreteIndices,  
    private static final String RELOCATING_SHARDS = "relocating_shards";
    public static ClusterHealthResponse fromXContent(XContentParser parser) {
        ClusterHealthResponse that = (ClusterHealthResponse) o;  
                activePrimaryShards,  
            taskMaxWaitingTime
    private static final String ACTIVE_PRIMARY_SHARDS = "active_primary_shards";
        clusterName = in.readString();  
    }  
    }
        return isTimedOut() ? RestStatus.REQUEST_TIMEOUT : RestStatus.OK;
        TimeValue taskMaxWaitingTime
    private static final String TIMED_OUT = "timed_out";
        String clusterName,  
            return new ClusterHealthResponse(
    private int numberOfPendingTasks = 0;
        }
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                timedOut,
        numberOfPendingTasks = in.readInt();  
    private ClusterHealthStatus clusterHealthStatus;
 * not use this file except in compliance with the License.
                out.writeBoolean(true);
 *  
        this.clusterStateHealth = clusterStateHealth;  
    private boolean timedOut = false;  
        ClusterState clusterState,  
    }  
    @Override
        return Objects.equals(clusterName, that.clusterName)
    }
import java.util.HashMap;  
        builder.field(DISCOVERED_CLUSTER_MANAGER, hasDiscoveredClusterManager());
    private static final String NUMBER_OF_DATA_NODES = "number_of_data_nodes";  
        this.clusterHealthStatus = status;
    }  
        }
            clusterStateHealth,
    public void setStatus(ClusterHealthStatus status) {
 * You may obtain a copy of the License at  
     */  
     */
    private static final String TASK_MAX_WAIT_TIME_IN_QUEUE_IN_MILLIS = "task_max_waiting_in_queue_millis";
 * Unless required by applicable law or agreed to in writing,
        builder.humanReadableField(TASK_MAX_WAIT_TIME_IN_QUEUE_IN_MILLIS, TASK_MAX_WAIT_TIME_IN_QUEUE, getTaskMaxWaitingTime());
    public ClusterHealthResponse(
            builder.startObject(INDICES);
        boolean timedOut,  
                clusterAwarenessHealth.writeTo(out);  
import org.opensearch.core.action.ActionResponse;  
        builder.field(NUMBER_OF_IN_FLIGHT_FETCH, getNumberOfInFlightFetch());
        taskMaxWaitingTime = in.readTimeValue();
    ) {
        PARSER.declareString(constructorArg(), new ParseField(STATUS));  
public class ClusterHealthResponse extends ActionResponse implements StatusToXContentObject {
    public TimeValue getTaskMaxWaitingTime() {
        return clusterStateHealth.getActiveShardsPercent();  
        return Strings.toString(MediaTypeRegistry.JSON, this);  
        PARSER.declareDouble(constructorArg(), new ParseField(ACTIVE_SHARDS_PERCENT_AS_NUMBER));
        int numberOfInFlightFetch,
            boolean timedOut = (boolean) parsedObjects[i];  
        );  
    public Map<String, ClusterIndexHealth> getIndices() {
    public int getActiveShards() {
            delayedUnassignedShards,
    static {  
        Void context,  
    public String getClusterName() {
            ClusterHealthStatus status = ClusterHealthStatus.fromString(statusStr);
            boolean hasDiscoveredMaster = Boolean.TRUE.equals(parsedObjects[i++]);
        builder.field(DISCOVERED_MASTER, hasDiscoveredClusterManager());  // the field will be removed in a future major version
/*
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_NODES));
            && numberOfInFlightFetch == that.numberOfInFlightFetch  
            && Objects.equals(taskMaxWaitingTime, that.taskMaxWaitingTime)
        // ClusterStateHealth fields
        String level = params.param("level", "cluster");
        boolean outputAwarenessHealth = "awareness_attributes".equals(level);
        this.clusterHealthStatus = clusterStateHealth.getStatus();
        builder.percentageField(ACTIVE_SHARDS_PERCENT_AS_NUMBER, ACTIVE_SHARDS_PERCENT, getActiveShardsPercent());  
        this(  
            if (clusterAwarenessHealth != null) {
     * @return The maximum wait time of all tasks in the queue
            int relocatingShards = (int) parsedObjects[i++];
        int numberOfInFlightFetch,  
    public static ClusterHealthResponse readResponseFrom(StreamInput in) throws IOException {
import java.util.Map;  
        if (this == o) return true;
            int unassignedShards = (int) parsedObjects[i++];
        this.clusterHealthStatus = clusterStateHealth.getStatus();
        clusterStateHealth.writeTo(out);  
            final Map<String, ClusterIndexHealth> indices;
 * license agreements. See the NOTICE file distributed with
    public int getActivePrimaryShards() {  
            for (ClusterIndexHealth indexHealth : clusterStateHealth.getIndices().values()) {
        int delayedUnassignedShards,
        this.taskMaxWaitingTime = taskMaxWaitingTime;  
import org.opensearch.common.settings.ClusterSettings;
    @Override
    ) {  
import org.opensearch.core.xcontent.ObjectParser;
        this.clusterName = clusterName;
            throw new IllegalArgumentException("'status' must not be null");  
            boolean hasDiscoveredClusterManager = Boolean.TRUE.equals(parsedObjects[i++]);  
        builder.endObject();  
        builder.field(ACTIVE_SHARDS, getActiveShards());
        if (in.getVersion().onOrAfter(Version.V_2_5_0)) {
                relocatingShards,
    }
            clusterAwarenessHealth.toXContent(builder, params);  
 *
    }
    public int getNumberOfPendingTasks() {  
                clusterAwarenessHealth = new ClusterAwarenessHealth(in);
            ClusterStateHealth stateHealth = new ClusterStateHealth(
                status,  
 * this work for additional information regarding copyright
        TimeValue taskMaxWaitingTime  
        builder.field(NUMBER_OF_PENDING_TASKS, getNumberOfPendingTasks());  
        return new ClusterHealthResponse(in);
            taskMaxWaitingTime
        this.timedOut = timedOut;
            int initializingShards = (int) parsedObjects[i++];
    public int getNumberOfInFlightFetch() {
        return clusterStateHealth.getRelocatingShards();  
        delayedUnassignedShards = in.readInt();  
                activeShards,
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
            clusterName,
        this.clusterStateHealth = new ClusterStateHealth(clusterState, concreteIndices);
                out.writeBoolean(false);
 * under the License.  
        ClusterState clusterState,
        }
        String[] concreteIndices,  
    }  
        "cluster_health_response",
        );
            numberOfPendingTasks,  
    }  
                activeShardsPercent,
            && Objects.equals(clusterStateHealth, that.clusterStateHealth)
        this.numberOfPendingTasks = numberOfPendingTasks;
    private static final String CLUSTER_NAME = "cluster_name";
            // ClusterStateHealth fields
        return taskMaxWaitingTime;
        this.clusterStateHealth = clusterHealthRequest.isApplyLevelAtTransportLayer()  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        String awarenessAttributeName,
                clusterName,
        return clusterHealthStatus;
}  
        this.clusterName = clusterName;
            concreteIndices,
    }  
    @Override  
    private static final String NUMBER_OF_PENDING_TASKS = "number_of_pending_tasks";
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.ConstructingObjectParser;
        return clusterStateHealth.getNumberOfDataNodes();
    public int getUnassignedShards() {
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_DATA_NODES));  
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.cluster.awarenesshealth.ClusterAwarenessHealth;  
    public String toString() {
    /**
        int numberOfPendingTasks,  
    public boolean isTimedOut() {
import org.opensearch.core.rest.RestStatus;
    private static final ConstructingObjectParser<ClusterHealthResponse, Void> PARSER = new ConstructingObjectParser<>(  
    public ClusterAwarenessHealth getClusterAwarenessHealth() {  
        return this.timedOut;  
    private static final String UNASSIGNED_SHARDS = "unassigned_shards";  
                TimeValue.timeValueMillis(taskMaxWaitingTimeMillis),  
        PARSER.declareInt(constructorArg(), new ParseField(DELAYED_UNASSIGNED_SHARDS));
        return clusterStateHealth.getNumberOfNodes();
            );
        ClusterState clusterState,
    public ClusterHealthStatus getStatus() {
    }  
            double activeShardsPercent = (double) parsedObjects[i++];  
                    indices.put(indexHealth.getIndex(), indexHealth);
        return clusterStateHealth.hasDiscoveredClusterManager();  
        builder.field(ACTIVE_PRIMARY_SHARDS, getActivePrimaryShards());  
        this.numberOfInFlightFetch = numberOfInFlightFetch;
 */  
    public ClusterHealthResponse(String clusterName, String[] concreteIndices, ClusterState clusterState) {
        builder.startObject();
    }
            clusterState,
import org.opensearch.common.xcontent.StatusToXContentObject;
            int numberOfNodes = (int) parsedObjects[i++];  
        builder.field(UNASSIGNED_SHARDS, getUnassignedShards());
        this.numberOfInFlightFetch = numberOfInFlightFetch;
        String index) -> ClusterIndexHealth.innerFromXContent(parser, index);
import org.opensearch.core.xcontent.XContentBuilder;
        ClusterHealthRequest clusterHealthRequest,  
        }  
        builder.field(STATUS, getStatus().name().toLowerCase(Locale.ROOT));  
    public ClusterHealthResponse(
        timedOut = in.readBoolean();
    }
                delayedUnassignedShards,
import org.opensearch.common.annotation.PublicApi;
import java.util.Objects;
     *
    private ClusterAwarenessHealth clusterAwarenessHealth;  
            );  
    public boolean equals(Object o) {  
    }
            && delayedUnassignedShards == that.delayedUnassignedShards
    public ClusterHealthResponse() {}
 * Modifications Copyright OpenSearch Contributors. See
            int delayedUnassignedShards = (int) parsedObjects[i++];
        PARSER.declareBoolean(optionalConstructorArg(), new ParseField(DISCOVERED_CLUSTER_MANAGER));
        );
        this.delayedUnassignedShards = delayedUnassignedShards;  
                initializingShards,  
        ClusterSettings clusterSettings,
     * The percentage of active shards, should be 100% in a green system  
        builder.field(INITIALIZING_SHARDS, getInitializingShards());  
        int numberOfPendingTasks,
        return this.numberOfInFlightFetch;
    private static final String DELAYED_UNASSIGNED_SHARDS = "delayed_unassigned_shards";  
    private static final String NUMBER_OF_NODES = "number_of_nodes";
    }
    }
        out.writeByte(clusterHealthStatus.value());
            numberOfInFlightFetch,  
        if (o == null || getClass() != o.getClass()) return false;
 *
            int activePrimaryShards = (int) parsedObjects[i++];  
                hasDiscoveredClusterManager || hasDiscoveredMaster,
            String statusStr = (String) parsedObjects[i++];
        if (out.getVersion().onOrAfter(Version.V_2_5_0)) {  
    private int numberOfInFlightFetch = 0;  
 * Transport response for Cluster Health
    private static final String DISCOVERED_CLUSTER_MANAGER = "discovered_cluster_manager";  
            int activeShards = (int) parsedObjects[i++];
    private static final String ACTIVE_SHARDS_PERCENT_AS_NUMBER = "active_shards_percent_as_number";  
        TimeValue taskMaxWaitingTime,
        if (outputIndices) {  
     * The number of unassigned shards that are currently being delayed (for example,  
        return this.delayedUnassignedShards;
            long taskMaxWaitingTimeMillis = (long) parsedObjects[i++];
            clusterName,
        if (status == null) {
        return clusterName;
                }  
        this(clusterName, concreteIndices, clusterState, -1, -1, -1, TimeValue.timeValueHours(0));
            builder.endObject();
            clusterHealthStatus  
            }  
    }
            int i = 0;
        PARSER.declareInt(constructorArg(), new ParseField(NUMBER_OF_IN_FLIGHT_FETCH));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int numberOfInFlightFetch,  
        out.writeBoolean(timedOut);
     * Allows to explicitly override the derived cluster health status.  
                indices = emptyMap();
        clusterStateHealth = new ClusterStateHealth(in);
/*  
        TimeValue taskMaxWaitingTime  
    }  
        String clusterName,  
 * The OpenSearch Contributors require contributions made to  
        if (outputAwarenessHealth && clusterAwarenessHealth != null) {
    private static final ObjectParser.NamedObjectParser<ClusterIndexHealth, Void> INDEX_PARSER = (
 * specific language governing permissions and limitations
            int numberOfPendingTasks = (int) parsedObjects[i++];
            clusterName,
        true,
