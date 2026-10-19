import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.ClusterState;
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).clusterManagerNodeId(localNode.getId()))
                ClusterStateHealth newState = new ClusterStateHealth(
        try (
                    instance.getNumberOfInFlightFetch(),
 * The OpenSearch Contributors require contributions made to
                    instance.getDelayedUnassignedShards(),
            }
                assertEquals(RestStatus.REQUEST_TIMEOUT, res.status());
        ClusterHealthResponse clusterHealth = new ClusterHealthResponse(
                    instance.getTaskMaxWaitingTime(),
            assertThat(clusterHealth.getNumberOfNodes(), Matchers.equalTo(6));
        );
            BytesStreamOutput out = new BytesStreamOutput();
                    instance.getClusterName(),
    }
            pendingTaskInQueueTime
                    + "\"active_primary_shards\":4,\"active_shards\":5,\"relocating_shards\":0,\"initializing_shards\":0,"
                    instance.isTimedOut(),
            randomInt(100),
                    instance.getClusterName(),
            randomInt(100),
                    instance.getClusterStateHealth()
    @Override
 * You may obtain a copy of the License at
            new String[] { Metadata.ALL },
 * KIND, either express or implied.  See the License for the
                );
/*
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        return ClusterHealthResponse.fromXContent(parser);
                    instance.getTaskMaxWaitingTime(),
            TimeValue.timeValueMillis(randomInt(10000)),
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        // set the node information to verify cluster_manager_node discovery in ClusterHealthResponse
            randomFrom(ClusterHealthStatus.values()),
                    + "\"active_shards_percent_as_number\":100}"
    public void testParseFromXContentWithDeprecatedDiscoveredMasterField() throws IOException {
            for (int i = 0; i < indicesSize; i++) {
import org.opensearch.core.common.io.stream.StreamInput;
                    + "\"timed_out\":false,\"number_of_nodes\":6,\"number_of_data_nodes\":3,\"discovered_cluster_manager\":true,"
                    instance.getClusterName(),
                    + "\"unassigned_shards\":0,\"delayed_unassigned_shards\":0,\"number_of_pending_tasks\":0,"
 */
import org.opensearch.test.AbstractSerializingTestCase;
        clusterHealth = maybeSerialize(clusterHealth);
                    state.getIndices()
                    + "\"unassigned_shards\":0,\"delayed_unassigned_shards\":0,\"number_of_pending_tasks\":0,"
                    instance.getDelayedUnassignedShards(),
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    state.hasDiscoveredClusterManager(),
 * SPDX-License-Identifier: Apache-2.0
                    + "\"active_primary_shards\":4,\"active_shards\":5,\"relocating_shards\":0,\"initializing_shards\":0,"
    public void testParseFromXContentWithoutDiscoveredClusterManagerField() throws IOException {
        }
            case "numberOfInFlightFetch":
import org.opensearch.core.common.io.stream.Writeable;
        assertClusterHealth(clusterHealth);
    /**
                "{\"cluster_name\":\"535799904437:7-1-3-node\",\"status\":\"green\","
        );
    protected Writeable.Reader<ClusterHealthResponse> instanceReader() {
            XContentParser parser = JsonXContent.jsonXContent.createParser(
            )
            XContentParser parser = JsonXContent.jsonXContent.createParser(
        if (ClusterHealthRequest.Level.INDICES.equals(level) || ClusterHealthRequest.Level.SHARDS.equals(level)) {
        ) {
        int inFlight = randomIntBetween(0, 200);
    }
        assertThat(clusterHealth.getRelocatingShards(), Matchers.equalTo(clusterStateHealth.getRelocatingShards()));
                    instance.getDelayedUnassignedShards(),
            randomInt(100),
            randomInt(100),
            StreamInput in = out.bytes().streamInput();
        return new ToXContent.MapParams(Collections.singletonMap("level", level.name().toLowerCase(Locale.ROOT)));
                    instance.getNumberOfPendingTasks(),
                NamedXContentRegistry.EMPTY,
    public void testClusterHealth() throws IOException {
    public void testClusterHealthVerifyClusterManagerNodeDiscovery() throws IOException {
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterHealth.getNumberOfInFlightFetch(), Matchers.equalTo(inFlight));
        }
            pendingTaskInQueueTime
                );
            assertThat(clusterHealth.hasDiscoveredClusterManager(), Matchers.equalTo(false));
            randomInt(100),
        );
                    instance.getClusterStateHealth()
            case "numberOfPendingTasks":
            "clusterStateHealth"
        ) {
import org.opensearch.core.xcontent.DeprecationHandler;
                    state.getActiveShardsPercent(),
                    instance.getClusterStateHealth()
    public void testParseFromXContentWithDiscoveredClusterManagerField() throws IOException {
    }
 */
                    instance.getNumberOfInFlightFetch() + between(1, 10),
                    instance.isTimedOut() == false,
        return clusterHealth;
 * not use this file except in compliance with the License.
                    + "\"number_of_in_flight_fetch\":0,\"task_max_waiting_in_queue_millis\":0,"
 *
            )
    }
                    instance.getNumberOfInFlightFetch(),
import org.opensearch.core.xcontent.ToXContent;
        try (
            } else {
import java.util.Collections;
            .build();
            indices
                    instance.getTaskMaxWaitingTime(),
                    instance.getDelayedUnassignedShards(),
/*
            "clusterName",
        }
            "timedOut",
            "delayedUnassignedShards",
                    state.getInitializingShards(),
                    + "\"active_shards_percent_as_number\":100}"
        ) {
                    new TimeValue(instance.getTaskMaxWaitingTime().millis() + between(1, 10)),
                return new ClusterHealthResponse(
    // Ignore all paths which looks like "indices.RANDOMINDEXNAME.shards"
                indices.put(indexName, ClusterIndexHealthTests.randomIndexHealth(indexName, level));
            inFlight,
                );
        return field -> "indices".equals(field) || SHARDS_IN_XCONTENT.matcher(field).find();
    ClusterHealthResponse maybeSerialize(ClusterHealthResponse clusterHealth) throws IOException {
            clusterState,
                    instance.getDelayedUnassignedShards(),
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertThat(clusterHealth.getTaskMaxWaitingTime().millis(), is(pendingTaskInQueueTime.millis()));
                    instance.getTaskMaxWaitingTime(),
        TimeValue pendingTaskInQueueTime = TimeValue.timeValueMillis(randomIntBetween(1000, 100000));
        assertThat(clusterHealth.hasDiscoveredClusterManager(), Matchers.equalTo(clusterStateHealth.hasDiscoveredClusterManager()));
    protected Predicate<String> getRandomFieldsExcludeFilter() {
                    instance.getNumberOfPendingTasks(),
                    instance.getNumberOfInFlightFetch(),
    }
 * ownership. Elasticsearch licenses this file to you under
                    instance.getDelayedUnassignedShards() + between(1, 10),
                assertEquals(RestStatus.OK, res.status());
        assertThat(clusterHealth.getInitializingShards(), Matchers.equalTo(clusterStateHealth.getInitializingShards()));
                    state.getNumberOfDataNodes(),
    @Override
                    instance.getNumberOfPendingTasks(),
            delayedUnassigned,
            stateHealth
                    state.getNumberOfNodes(),
            assertThat(clusterHealth.getNumberOfNodes(), Matchers.equalTo(6));
                    + "\"unassigned_shards\":0,\"delayed_unassigned_shards\":0,\"number_of_pending_tasks\":0,"
    @Override
        assertClusterHealth(clusterHealth);
 * compatible open source license.
    protected boolean supportsUnknownFields() {
    public void testIsTimeout() {
            ClusterHealthResponse clusterHealth = ClusterHealthResponse.fromXContent(parser);
            }
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.health.ClusterStateHealth;
            if (res.isTimedOut()) {
        String mutate = randomFrom(
    }
        }
        }
                    instance.getNumberOfPendingTasks(),
        return new ClusterHealthResponse(
                );
    }
            default:
                    instance.getTaskMaxWaitingTime(),
 * GitHub history for details.
            pendingTasks,
import org.opensearch.cluster.health.ClusterIndexHealthTests;
import org.opensearch.Version;
                NamedXContentRegistry.EMPTY,
        switch (mutate) {
        int delayedUnassigned = randomIntBetween(0, 200);
import java.util.Locale;
            )
package org.opensearch.action.admin.cluster.health;
        DiscoveryNode localNode = new DiscoveryNode("node", OpenSearchTestCase.buildNewFakeTransportAddress(), Version.CURRENT);
                    + "\"number_of_nodes\":6,\"number_of_data_nodes\":3,\"discovered_cluster_manager\":true,\"discovered_master\":true,"
            XContentParser parser = JsonXContent.jsonXContent.createParser(
            XContentParser parser = JsonXContent.jsonXContent.createParser(
                    instance.getNumberOfInFlightFetch(),
import org.opensearch.common.xcontent.json.JsonXContent;
import java.util.HashMap;
                    instance.getClusterName(),
                    instance.getNumberOfInFlightFetch(),
            randomInt(100),
import org.opensearch.cluster.ClusterName;
import org.opensearch.test.OpenSearchTestCase;
    private static final Pattern SHARDS_IN_XCONTENT = Pattern.compile("^indices\\.\\w+\\.shards$");
                "{\"cluster_name\":\"opensearch-cluster\",\"status\":\"green\","
import org.opensearch.cluster.metadata.Metadata;
                String indexName = randomAlphaOfLengthBetween(1, 5) + i;
            "taskMaxWaitingTime",
    @Override
            clusterState,
        ClusterStateHealth clusterStateHealth = clusterHealth.getClusterStateHealth();
            case "delayedUnassignedShards":
        clusterHealth = maybeSerialize(clusterHealth);
        int delayedUnassigned = randomIntBetween(0, 200);
 * license agreements. See the NOTICE file distributed with
                return new ClusterHealthResponse(
        ClusterHealthResponse res = new ClusterHealthResponse();
            randomDoubleBetween(0d, 100d, true),
 * software distributed under the License is distributed on an
        return ClusterHealthResponse::new;
     */
     * As of 2.0, to support inclusive language, "discovered_master" field will be replaced by "discovered_cluster_manager".
                    instance.getClusterName(),
                    state.getRelocatingShards(),
            ClusterHealthResponse clusterHealth = ClusterHealthResponse.fromXContent(parser);
                    instance.isTimedOut(),
 * Modifications Copyright OpenSearch Contributors. See
            case "taskMaxWaitingTime":
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Predicate;
    @Override
import java.util.Map;
        assertThat(clusterHealth.getDelayedUnassignedShards(), Matchers.equalTo(delayedUnassigned));
                    state.getUnassignedShards(),
    }
import static org.hamcrest.CoreMatchers.allOf;
                    state.getActivePrimaryShards() + between(1, 10),
        return true;
                    newState
                    instance.getClusterName() + randomAlphaOfLengthBetween(2, 5),
import java.util.regex.Pattern;
            assertThat(clusterHealth.getClusterName(), Matchers.equalTo("535799904437:7-1-3-node"));
    }
                    instance.getNumberOfPendingTasks(),
        int pendingTasks = randomIntBetween(0, 200);
            case "clusterName":
            randomInt(100),
    protected ClusterHealthResponse createTestInstance() {
     * Validate the ClusterHealthResponse can be parsed from JsonXContent that contains the deprecated "discovered_master" field.
                    instance.getNumberOfPendingTasks() + between(1, 10),
            inFlight,
        }
        assertThat(clusterHealth.getUnassignedShards(), Matchers.equalTo(clusterStateHealth.getUnassignedShards()));
                    + "\"unassigned_shards\":0,\"delayed_unassigned_shards\":0,\"number_of_pending_tasks\":0,"
                    instance.isTimedOut(),
                NamedXContentRegistry.EMPTY,
            new String[] { Metadata.ALL },
 * the Apache License, Version 2.0 (the "License"); you may
    }
                    + "\"timed_out\":false,\"number_of_nodes\":6,\"number_of_data_nodes\":3,\"discovered_master\":true,"
import org.opensearch.core.rest.RestStatus;
                    instance.getNumberOfPendingTasks(),
            pendingTasks,
        ClusterStateHealth stateHealth = new ClusterStateHealth(
            res.setTimedOut(randomBoolean());
                );
                ClusterStateHealth state = instance.getClusterStateHealth();
import java.io.IOException;
                NamedXContentRegistry.EMPTY,
            randomInt(100),
        try (
                    instance.getClusterStateHealth()
        assertThat(clusterHealth.getNumberOfPendingTasks(), Matchers.equalTo(pendingTasks));
                );
 */
 *
    private void assertClusterHealth(ClusterHealthResponse clusterHealth) {
    }
            assertNotNull(clusterHealth);
        assertThat(clusterHealth.getClusterStateHealth().hasDiscoveredClusterManager(), Matchers.equalTo(true));
                return new ClusterHealthResponse(
import org.opensearch.common.settings.Settings;
        assertThat(clusterHealth.getNumberOfNodes(), Matchers.equalTo(clusterStateHealth.getNumberOfNodes()));
            ClusterHealthResponse clusterHealth = ClusterHealthResponse.fromXContent(parser);
import org.opensearch.core.xcontent.NamedXContentRegistry;
            "bla",
 * specific language governing permissions and limitations
            delayedUnassigned,
            ClusterHealthResponse clusterHealth = ClusterHealthResponse.fromXContent(parser);
            "bla",
 * Unless required by applicable law or agreed to in writing,
            randomInt(100),
        for (int i = 0; i < 5; i++) {
            randomInt(100),
            assertThat(clusterHealth.getClusterName(), Matchers.equalTo("535799904437:7-1-3-node"));
        assertThat(clusterHealth.getActivePrimaryShards(), Matchers.equalTo(clusterStateHealth.getActivePrimaryShards()));
                    instance.isTimedOut(),
/*
import org.opensearch.cluster.health.ClusterIndexHealth;
                    instance.getDelayedUnassignedShards(),
 * Licensed to Elasticsearch under one or more contributor
                    instance.getClusterStateHealth()
 * this work for additional information regarding copyright
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY)).build();
        if (randomBoolean()) {
import org.opensearch.cluster.node.DiscoveryNodes;
            randomBoolean(),
                    state.getActiveShards(),
        Map<String, ClusterIndexHealth> indices = new HashMap<>(indicesSize);
        int pendingTasks = randomIntBetween(0, 200);
import org.opensearch.cluster.health.ClusterHealthStatus;
            clusterHealth.writeTo(out);
import static org.hamcrest.Matchers.is;
                    instance.getNumberOfInFlightFetch(),
        ) {
        assertThat(clusterHealth.getNumberOfDataNodes(), Matchers.equalTo(clusterStateHealth.getNumberOfDataNodes()));
    private final ClusterHealthRequest.Level level = randomFrom(ClusterHealthRequest.Level.values());
    protected ClusterHealthResponse mutateInstance(ClusterHealthResponse instance) {
            assertThat(clusterHealth.hasDiscoveredClusterManager(), Matchers.equalTo(true));
            randomBoolean(),
                    + "\"number_of_in_flight_fetch\":0,\"task_max_waiting_in_queue_millis\":0,"
                    + "\"number_of_in_flight_fetch\":0,\"task_max_waiting_in_queue_millis\":0,"
            assertNotNull(clusterHealth);
                    + "\"active_primary_shards\":4,\"active_shards\":5,\"relocating_shards\":0,\"initializing_shards\":0,"
    }
public class ClusterHealthResponsesTests extends AbstractSerializingTestCase<ClusterHealthResponse> {
                    + "\"active_shards_percent_as_number\":100}"
        );
            case "clusterStateHealth":
            )
                return new ClusterHealthResponse(
        int inFlight = randomIntBetween(0, 200);
        try (
            case "timedOut":
    }
                "{\"cluster_name\":\"535799904437:7-1-3-node\",\"status\":\"green\","
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import org.opensearch.core.xcontent.XContentParser;
 *
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        );
                    instance.isTimedOut(),
 * under the License.
                "{\"cluster_name\":\"opensearch-cluster\",\"status\":\"green\",\"timed_out\":false,"
                    + "\"timed_out\":false,\"number_of_nodes\":6,\"number_of_data_nodes\":3,"
        int indicesSize = randomInt(20);
                    + "\"active_shards_percent_as_number\":100}"
        }
                    instance.getClusterStateHealth()
                return new ClusterHealthResponse(
                    + "\"number_of_in_flight_fetch\":0,\"task_max_waiting_in_queue_millis\":0,"
                    instance.isTimedOut(),
                    state.getStatus(),
        TimeValue pendingTaskInQueueTime = TimeValue.timeValueMillis(randomIntBetween(1000, 100000));
        assertThat(clusterHealth.getActiveShardsPercent(), is(allOf(greaterThanOrEqualTo(0.0), lessThanOrEqualTo(100.0))));
import org.hamcrest.Matchers;
            "numberOfInFlightFetch",
                    + "\"active_primary_shards\":4,\"active_shards\":5,\"relocating_shards\":0,\"initializing_shards\":0,"
                    instance.getClusterName(),
            assertThat(clusterHealth.hasDiscoveredClusterManager(), Matchers.equalTo(true));
            "numberOfPendingTasks",
}
        }
    @Override
                return new ClusterHealthResponse(
    protected ToXContent.Params getToXContentParams() {
    protected ClusterHealthResponse doParseInstance(XContentParser parser) {
                throw new UnsupportedOperationException();
            randomAlphaOfLengthBetween(1, 10),
        ClusterHealthResponse clusterHealth = new ClusterHealthResponse(
 * this file be licensed under the Apache-2.0 license or a
                return new ClusterHealthResponse(
                    instance.getTaskMaxWaitingTime(),
        assertThat(clusterHealth.getActiveShards(), Matchers.equalTo(clusterStateHealth.getActiveShards()));
                );
            clusterHealth = ClusterHealthResponse.readResponseFrom(in);
                );
            assertThat(clusterHealth.hasDiscoveredClusterManager(), Matchers.equalTo(true));
    }
