import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    }  
                    instance.getNumberOfPendingTasks(),
import org.opensearch.cluster.node.DiscoveryNode;  
                    instance.getClusterName(),
                    instance.getClusterName() + randomAlphaOfLengthBetween(2, 5),
            randomInt(100),
import org.opensearch.cluster.ClusterState;  
        return ClusterHealthResponse.fromXContent(parser);
                    instance.getClusterName(),  
import java.util.regex.Pattern;
                "{\"cluster_name\":\"535799904437:7-1-3-node\",\"status\":\"green\","
    @Override
    @Override  
        // set the node information to verify cluster_manager_node discovery in ClusterHealthResponse
                    state.getNumberOfNodes(),
        assertThat(clusterHealth.getNumberOfNodes(), Matchers.equalTo(clusterStateHealth.getNumberOfNodes()));
import org.hamcrest.Matchers;  
                NamedXContentRegistry.EMPTY,
/*  
                return new ClusterHealthResponse(
     * As of 2.0, to support inclusive language, "discovered_master" field will be replaced by "discovered_cluster_manager".
                    + "\"active_primary_shards\":4,\"active_shards\":5,\"relocating_shards\":0,\"initializing_shards\":0,"
    }  
            for (int i = 0; i < indicesSize; i++) {  
            "clusterName",
    }  
        assertThat(clusterHealth.getNumberOfInFlightFetch(), Matchers.equalTo(inFlight));  
        ) {
            "timedOut",
import org.opensearch.common.settings.Settings;  
    @Override
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build();
                    + "\"number_of_in_flight_fetch\":0,\"task_max_waiting_in_queue_millis\":0,"
            assertThat(clusterHealth.getClusterName(), Matchers.equalTo("535799904437:7-1-3-node"));  
        int delayedUnassigned = randomIntBetween(0, 200);
                    state.getIndices()
            assertNotNull(clusterHealth);
        ClusterHealthResponse clusterHealth = new ClusterHealthResponse(  
                    instance.getClusterStateHealth()  
                    instance.getDelayedUnassignedShards(),  
        );  
        return ClusterHealthResponse::new;
                    instance.getNumberOfInFlightFetch(),
            XContentParser parser = JsonXContent.jsonXContent.createParser(  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(clusterHealth.getClusterStateHealth().hasDiscoveredClusterManager(), Matchers.equalTo(true));
        }
            }
import org.opensearch.cluster.health.ClusterHealthStatus;
            XContentParser parser = JsonXContent.jsonXContent.createParser(
        ClusterHealthResponse clusterHealth = new ClusterHealthResponse(
        assertThat(clusterHealth.getUnassignedShards(), Matchers.equalTo(clusterStateHealth.getUnassignedShards()));
                return new ClusterHealthResponse(
    }
import org.opensearch.cluster.ClusterName;
 * Unless required by applicable law or agreed to in writing,
                    instance.getDelayedUnassignedShards(),
        return clusterHealth;
                    instance.getNumberOfInFlightFetch(),  
 *  
import org.opensearch.core.common.io.stream.StreamInput;  
                indices.put(indexName, ClusterIndexHealthTests.randomIndexHealth(indexName, level));
            randomBoolean(),
            case "numberOfInFlightFetch":
                    + "\"unassigned_shards\":0,\"delayed_unassigned_shards\":0,\"number_of_pending_tasks\":0,"
                    instance.getTaskMaxWaitingTime(),
                    instance.getTaskMaxWaitingTime(),
                    + "\"active_primary_shards\":4,\"active_shards\":5,\"relocating_shards\":0,\"initializing_shards\":0,"  
        DiscoveryNode localNode = new DiscoveryNode("node", OpenSearchTestCase.buildNewFakeTransportAddress(), Version.CURRENT);
    }
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentParser;  
                );
            } else {  
 */
    }
    protected boolean supportsUnknownFields() {
import org.opensearch.core.rest.RestStatus;
    }
            "bla",
    public void testClusterHealth() throws IOException {  
        );  
    public void testIsTimeout() {  
                    instance.getTaskMaxWaitingTime(),
    protected ClusterHealthResponse doParseInstance(XContentParser parser) {  
        return field -> "indices".equals(field) || SHARDS_IN_XCONTENT.matcher(field).find();
import org.opensearch.cluster.health.ClusterStateHealth;
            assertThat(clusterHealth.hasDiscoveredClusterManager(), Matchers.equalTo(false));
                    + "\"active_shards_percent_as_number\":100}"  
                    instance.getDelayedUnassignedShards(),
                    instance.getNumberOfPendingTasks(),
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).clusterManagerNodeId(localNode.getId()))
import org.opensearch.cluster.health.ClusterIndexHealthTests;  
            randomInt(100),
            "numberOfInFlightFetch",
                    instance.isTimedOut() == false,  
import java.util.Locale;
/*  
            pendingTaskInQueueTime
            ClusterHealthResponse clusterHealth = ClusterHealthResponse.fromXContent(parser);
            )
                ClusterStateHealth newState = new ClusterStateHealth(
                "{\"cluster_name\":\"opensearch-cluster\",\"status\":\"green\","
import java.util.Map;  
        switch (mutate) {
            ClusterHealthResponse clusterHealth = ClusterHealthResponse.fromXContent(parser);
        }
                    state.getActiveShardsPercent(),
import org.opensearch.test.OpenSearchTestCase;
                    instance.isTimedOut(),
        TimeValue pendingTaskInQueueTime = TimeValue.timeValueMillis(randomIntBetween(1000, 100000));
                );
    }
            inFlight,
                    state.getNumberOfDataNodes(),  
        for (int i = 0; i < 5; i++) {
        int indicesSize = randomInt(20);  
        );
                    instance.getDelayedUnassignedShards(),  
        assertThat(clusterHealth.getRelocatingShards(), Matchers.equalTo(clusterStateHealth.getRelocatingShards()));
 * the Apache License, Version 2.0 (the "License"); you may
                    + "\"timed_out\":false,\"number_of_nodes\":6,\"number_of_data_nodes\":3,\"discovered_master\":true,"
                    instance.getClusterStateHealth()
        assertThat(clusterHealth.getNumberOfDataNodes(), Matchers.equalTo(clusterStateHealth.getNumberOfDataNodes()));  
}
            default:  
        assertThat(clusterHealth.getDelayedUnassignedShards(), Matchers.equalTo(delayedUnassigned));
 *    http://www.apache.org/licenses/LICENSE-2.0
                    instance.getDelayedUnassignedShards(),
                    instance.getTaskMaxWaitingTime(),
        try (  
    protected Writeable.Reader<ClusterHealthResponse> instanceReader() {
                );
                    instance.isTimedOut(),  
            new String[] { Metadata.ALL },  
            randomDoubleBetween(0d, 100d, true),
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNodes;
    @Override  
            ClusterHealthResponse clusterHealth = ClusterHealthResponse.fromXContent(parser);
        assertThat(clusterHealth.getTaskMaxWaitingTime().millis(), is(pendingTaskInQueueTime.millis()));
    public void testParseFromXContentWithDeprecatedDiscoveredMasterField() throws IOException {
import org.opensearch.common.xcontent.json.JsonXContent;
                    + "\"number_of_in_flight_fetch\":0,\"task_max_waiting_in_queue_millis\":0,"
            case "numberOfPendingTasks":  
                    instance.getClusterStateHealth()
                    instance.getNumberOfInFlightFetch(),  
            assertThat(clusterHealth.getClusterName(), Matchers.equalTo("535799904437:7-1-3-node"));  
                throw new UnsupportedOperationException();
 * You may obtain a copy of the License at  
                "{\"cluster_name\":\"535799904437:7-1-3-node\",\"status\":\"green\","
                    + "\"unassigned_shards\":0,\"delayed_unassigned_shards\":0,\"number_of_pending_tasks\":0,"
                return new ClusterHealthResponse(  
            "numberOfPendingTasks",  
                return new ClusterHealthResponse(  
                    instance.getClusterStateHealth()  
            clusterState,
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
            XContentParser parser = JsonXContent.jsonXContent.createParser(
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        String mutate = randomFrom(
    protected ClusterHealthResponse mutateInstance(ClusterHealthResponse instance) {  
        assertThat(clusterHealth.hasDiscoveredClusterManager(), Matchers.equalTo(clusterStateHealth.hasDiscoveredClusterManager()));
            res.setTimedOut(randomBoolean());  
    }
                    state.getRelocatingShards(),
        assertThat(clusterHealth.getActiveShards(), Matchers.equalTo(clusterStateHealth.getActiveShards()));  
            pendingTasks,
        }  
                NamedXContentRegistry.EMPTY,
                    + "\"number_of_in_flight_fetch\":0,\"task_max_waiting_in_queue_millis\":0,"  
    public void testClusterHealthVerifyClusterManagerNodeDiscovery() throws IOException {  
                    state.getStatus(),  
        return new ToXContent.MapParams(Collections.singletonMap("level", level.name().toLowerCase(Locale.ROOT)));
        ClusterStateHealth clusterStateHealth = clusterHealth.getClusterStateHealth();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        }  
                    + "\"unassigned_shards\":0,\"delayed_unassigned_shards\":0,\"number_of_pending_tasks\":0,"
                    newState
            assertThat(clusterHealth.hasDiscoveredClusterManager(), Matchers.equalTo(true));
    @Override
                NamedXContentRegistry.EMPTY,
package org.opensearch.action.admin.cluster.health;
 *
    public void testParseFromXContentWithoutDiscoveredClusterManagerField() throws IOException {  
    protected ToXContent.Params getToXContentParams() {  
        clusterHealth = maybeSerialize(clusterHealth);
        TimeValue pendingTaskInQueueTime = TimeValue.timeValueMillis(randomIntBetween(1000, 100000));  
                );
            stateHealth
                    instance.getNumberOfPendingTasks(),
                );
        }
            if (res.isTimedOut()) {
import org.opensearch.core.common.io.stream.Writeable;
            delayedUnassigned,
        assertThat(clusterHealth.getInitializingShards(), Matchers.equalTo(clusterStateHealth.getInitializingShards()));  
            new String[] { Metadata.ALL },
            randomInt(100),  
    @Override
import org.opensearch.common.io.stream.BytesStreamOutput;
                    instance.getNumberOfInFlightFetch(),  
            randomInt(100),
    protected ClusterHealthResponse createTestInstance() {
            randomInt(100),  
 * ownership. Elasticsearch licenses this file to you under  
        return true;  
            "bla",
            randomInt(100),
            pendingTasks,
            .build();
                    state.getActivePrimaryShards() + between(1, 10),  
     */  
                    instance.getClusterStateHealth()
    }  
public class ClusterHealthResponsesTests extends AbstractSerializingTestCase<ClusterHealthResponse> {  
                    instance.getDelayedUnassignedShards(),
 */  
                    state.hasDiscoveredClusterManager(),
import java.util.function.Predicate;
        assertThat(clusterHealth.getActiveShardsPercent(), is(allOf(greaterThanOrEqualTo(0.0), lessThanOrEqualTo(100.0))));  
                assertEquals(RestStatus.REQUEST_TIMEOUT, res.status());
/*
    protected Predicate<String> getRandomFieldsExcludeFilter() {
        assertClusterHealth(clusterHealth);  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
            assertThat(clusterHealth.hasDiscoveredClusterManager(), Matchers.equalTo(true));
import java.io.IOException;
    private void assertClusterHealth(ClusterHealthResponse clusterHealth) {  
        );
    // Ignore all paths which looks like "indices.RANDOMINDEXNAME.shards"  
                );  
                    instance.getTaskMaxWaitingTime(),
 * license agreements. See the NOTICE file distributed with
            )  
                    instance.getNumberOfPendingTasks(),
            ClusterHealthResponse clusterHealth = ClusterHealthResponse.fromXContent(parser);  
            clusterState,  
        if (randomBoolean()) {
            assertThat(clusterHealth.hasDiscoveredClusterManager(), Matchers.equalTo(true));  
    }
            case "timedOut":
                    instance.getNumberOfInFlightFetch() + between(1, 10),
                return new ClusterHealthResponse(  
    /**  
                return new ClusterHealthResponse(
        ) {
 *
 * compatible open source license.
import org.opensearch.test.AbstractSerializingTestCase;
                    instance.isTimedOut(),
     * Validate the ClusterHealthResponse can be parsed from JsonXContent that contains the deprecated "discovered_master" field.
 * GitHub history for details.
        );  
 */  
import static org.hamcrest.CoreMatchers.allOf;
import org.opensearch.cluster.metadata.Metadata;
import java.util.Collections;  
        }
import org.opensearch.core.xcontent.DeprecationHandler;  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            inFlight,  
                    + "\"timed_out\":false,\"number_of_nodes\":6,\"number_of_data_nodes\":3,\"discovered_cluster_manager\":true,"
                    + "\"number_of_in_flight_fetch\":0,\"task_max_waiting_in_queue_millis\":0,"
            clusterHealth.writeTo(out);
                String indexName = randomAlphaOfLengthBetween(1, 5) + i;
        int pendingTasks = randomIntBetween(0, 200);
                    state.getUnassignedShards(),
                    instance.getNumberOfInFlightFetch(),
                    instance.getNumberOfInFlightFetch(),  
                    instance.getNumberOfPendingTasks(),
            randomInt(100),  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        int inFlight = randomIntBetween(0, 200);  
            case "clusterName":
            indices
                    instance.getDelayedUnassignedShards() + between(1, 10),
import org.opensearch.common.unit.TimeValue;
            assertThat(clusterHealth.getNumberOfNodes(), Matchers.equalTo(6));
                    state.getInitializingShards(),  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
                return new ClusterHealthResponse(  
                    + "\"number_of_nodes\":6,\"number_of_data_nodes\":3,\"discovered_cluster_manager\":true,\"discovered_master\":true,"
            randomInt(100),
        Map<String, ClusterIndexHealth> indices = new HashMap<>(indicesSize);
            clusterHealth = ClusterHealthResponse.readResponseFrom(in);  
        try (  
            randomAlphaOfLengthBetween(1, 10),
            )
            TimeValue.timeValueMillis(randomInt(10000)),  
    private static final Pattern SHARDS_IN_XCONTENT = Pattern.compile("^indices\\.\\w+\\.shards$");
                    + "\"active_shards_percent_as_number\":100}"  
                    instance.isTimedOut(),
 * Modifications Copyright OpenSearch Contributors. See
        ) {  
import org.opensearch.Version;
            assertNotNull(clusterHealth);
                    + "\"active_shards_percent_as_number\":100}"
    ClusterHealthResponse maybeSerialize(ClusterHealthResponse clusterHealth) throws IOException {
            case "delayedUnassignedShards":
                    + "\"active_primary_shards\":4,\"active_shards\":5,\"relocating_shards\":0,\"initializing_shards\":0,"  
            case "taskMaxWaitingTime":  
        assertClusterHealth(clusterHealth);
            "taskMaxWaitingTime",  
    }
                    + "\"timed_out\":false,\"number_of_nodes\":6,\"number_of_data_nodes\":3,"  
            delayedUnassigned,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int delayedUnassigned = randomIntBetween(0, 200);
        return new ClusterHealthResponse(
            assertThat(clusterHealth.getNumberOfNodes(), Matchers.equalTo(6));
                    instance.getTaskMaxWaitingTime(),  
 * under the License.  
        if (ClusterHealthRequest.Level.INDICES.equals(level) || ClusterHealthRequest.Level.SHARDS.equals(level)) {
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            randomBoolean(),
                "{\"cluster_name\":\"opensearch-cluster\",\"status\":\"green\",\"timed_out\":false,"  
    }  
        assertThat(clusterHealth.getNumberOfPendingTasks(), Matchers.equalTo(pendingTasks));
            case "clusterStateHealth":  
            )
                NamedXContentRegistry.EMPTY,  
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.ToXContent;
                    + "\"unassigned_shards\":0,\"delayed_unassigned_shards\":0,\"number_of_pending_tasks\":0,"  
    @Override
 * The OpenSearch Contributors require contributions made to  
                    instance.getClusterName(),
                    instance.getClusterName(),  
            "clusterStateHealth"
            XContentParser parser = JsonXContent.jsonXContent.createParser(
import org.opensearch.cluster.health.ClusterIndexHealth;
                );
    public void testParseFromXContentWithDiscoveredClusterManagerField() throws IOException {
                    instance.getClusterName(),
                    + "\"active_shards_percent_as_number\":100}"
        ) {
            pendingTaskInQueueTime
                    state.getActiveShards(),
                );
                    instance.getNumberOfPendingTasks(),
            StreamInput in = out.bytes().streamInput();
                    new TimeValue(instance.getTaskMaxWaitingTime().millis() + between(1, 10)),
        }  
            BytesStreamOutput out = new BytesStreamOutput();  
                    instance.getClusterName(),
import static org.hamcrest.Matchers.is;  
                    instance.isTimedOut(),  
            "delayedUnassignedShards",
        ClusterHealthResponse res = new ClusterHealthResponse();
            randomInt(100),  
        assertThat(clusterHealth.getActivePrimaryShards(), Matchers.equalTo(clusterStateHealth.getActivePrimaryShards()));
                    + "\"active_primary_shards\":4,\"active_shards\":5,\"relocating_shards\":0,\"initializing_shards\":0,"
                ClusterStateHealth state = instance.getClusterStateHealth();
        int inFlight = randomIntBetween(0, 200);
                    instance.getClusterStateHealth()
        try (
            randomFrom(ClusterHealthStatus.values()),  
        clusterHealth = maybeSerialize(clusterHealth);  
import java.util.HashMap;
    private final ClusterHealthRequest.Level level = randomFrom(ClusterHealthRequest.Level.values());
                assertEquals(RestStatus.OK, res.status());
            }  
        int pendingTasks = randomIntBetween(0, 200);  
 * this work for additional information regarding copyright
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        ClusterStateHealth stateHealth = new ClusterStateHealth(
                    instance.isTimedOut(),  
                    instance.getNumberOfPendingTasks() + between(1, 10),  
        }
            randomInt(100),
        try (
