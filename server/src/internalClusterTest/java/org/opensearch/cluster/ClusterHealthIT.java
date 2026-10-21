        );
            assertFalse("timed out on " + node, health.isTimedOut());
        }
            .indices()
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertThat(response.isTimedOut(), equalTo(false));
                .setIndicesOptions(IndicesOptions.lenientExpandOpen())
    public void testHealthWithClusterLevelAppliedAtTransportLayer() {
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .prepareHealth("test1", "test2")
import static org.hamcrest.Matchers.not;
            public ClusterState execute(ClusterState currentState) {
            .prepareHealth()
        {
            .prepareHealth()
                .cluster()
public class ClusterHealthIT extends OpenSearchIntegTestCase {
            .cluster()
        assertAcked(client().admin().indices().prepareClose("index-2"));
                .get();
                .cluster()
        }
        clusterHealthThread.join();
            .actionGet();
            @Override
            createIndex(
            .setTimeout("1s")
            assertFalse(shards.isEmpty());
        createIndex(
                    clusterService.submitStateUpdateTask("looping task", this);
        try {
            assertEquals(1, indicesHealthValue.getActiveShards());
        Map<String, ClusterIndexHealth> indices = healthResponse.getIndices();
        assertThat(healthResponse.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        }
        final ClusterService clusterService = internalCluster().getInstance(
            assertEquals(indexHasMoreReplicas ? 1 : 0, indicesHealthValue.getUnassignedShards());
                .setWaitForNoRelocatingShards(true)
    public void testHealthWithAwarenessAttributesLevelAppliedAtTransportLayer() {
        for (Map.Entry<String, ClusterIndexHealth> indicesHealth : indices.entrySet()) {
            assertThat(response.isTimedOut(), equalTo(false));
        assertThat(healthResponse.getIndices().get("test1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
    public void testHealthWithIndicesLevelAppliedAtTransportLayer() {
            String indexName = indicesHealth.getKey();
import static org.hamcrest.Matchers.nullValue;
        assertEquals(1, healthResponse.getActiveShards());
        assertEquals(2 * dataNodes, healthResponse.getActiveShards());
            .execute();
            .execute()
            public void onFailure(String source, Exception e) {
            assertThat(response.getIndices().size(), equalTo(1));
        assertEquals(0, healthResponse.getDelayedUnassignedShards());
                .setWaitForEvents(Priority.LANGUID)
 * The OpenSearch Contributors require contributions made to
        assertEquals(0, healthResponse.getRelocatingShards());
                .build()
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        try {
        );
 * Licensed to Elasticsearch under one or more contributor
            assertThat(response.getIndices().get("index-3").getStatus(), equalTo(ClusterHealthStatus.YELLOW));
                .indices()
            assertEquals(0, indicesHealthValue.getDelayedUnassignedShards());
            keepSubmittingTasks.set(false);
                assertEquals(0, clusterShardHealth.getRelocatingShards());
            );
 * this file be licensed under the Apache-2.0 license or a
                    .build()
        int greenClusterReplicaCount = dataNodes - 1;
        );
                .setWaitForEvents(Priority.LANGUID)
        final List<ActionFuture<ClusterHealthResponse>> responseFutures = new ArrayList<>();
        logger.info("--> Creating index test1 with zero replicas");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        finished.set(true);
        final ClusterService clusterService = internalCluster().getInstance(
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
/*
                } else {
                assertEquals(indexHasMoreReplicas ? ClusterHealthStatus.YELLOW : ClusterHealthStatus.GREEN, clusterShardHealth.getStatus());
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertEquals(1, healthResponse.getActivePrimaryShards());
            assertEquals(0, indicesHealthValue.getUnassignedShards());
                    .setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(3))
        }
            .setWaitForYellowStatus()
        assertEquals(1, healthResponse.getActiveShards());
 *
        assertEquals(ClusterHealthStatus.YELLOW, healthResponse.getStatus());
                throw new AssertionError(source, e);
                .prepareHealth("index-*")
            assertEquals(1, indicesHealthValue.getActivePrimaryShards());
            );
        }
                .prepareUpdateSettings("index-3")
            assertThat(response.getIndices().get("index-2"), nullValue());
            assertThat(response.getIndices().size(), equalTo(3));
            .actionGet();
        {
            assertThat(response.isTimedOut(), equalTo(false));
                return currentState;
    public void testWaitForEventsRetriesIfOtherConditionsNotMet() {
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
        Thread clusterHealthThread = new Thread() {
        assertEquals(ClusterHealthStatus.GREEN, healthResponse.getStatus());
        }
        {
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
                completionFuture.onFailure(e);
        final PlainActionFuture<Void> completionFuture = new PlainActionFuture<>();
            .setSettings(Settings.builder().put("index.number_of_replicas", yellowClusterReplicaCount).build())
        assertThat(healthResponse.getStatus(), equalTo(ClusterHealthStatus.RED));
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
                } else {
                assertTrue(clusterShardHealth.isPrimaryActive());
        ensureGreen();
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
import org.opensearch.cluster.health.ClusterHealthStatus;
        {
                "test",
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas()).build())
 * You may obtain a copy of the License at
        for (int i = 0; i < iterations; ++i) {
            }
                    ClusterHealthResponse health = client().admin().cluster().prepareHealth().get();
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .cluster()
        } finally {
        {
import org.opensearch.common.unit.TimeValue;
            .setApplyLevelAtTransportLayer(true)
                .prepareHealth("index-*")
        {
        assertEquals(1, healthResponse.getActivePrimaryShards());
        }
            keepSubmittingTasks.set(false);
                .cluster()
                }
            ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForGreenStatus().get();
import org.opensearch.test.OpenSearchIntegTestCase;
    }
            public void run() {
                    .cluster()
        // Run a few health requests concurrent to cluster-manager fail-overs against a data-node
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertThat(response.isTimedOut(), equalTo(false));
 * specific language governing permissions and limitations
        healthResponse = client().admin()
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
import java.util.Map;
            }
            String indexName = indicesHealth.getKey();
                .get();
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
        healthResponse = client().admin().cluster().prepareHealth("test1").setWaitForGreenStatus().setTimeout("10s").execute().actionGet();
                }
            .setTimeout("1s")
            assertThat(response.getIndices().size(), equalTo(1));
        );
import java.util.List;
            .cluster()
            assertThat(response.getIndices().size(), equalTo(1));
    }
        assertEquals(2, healthResponse.getActivePrimaryShards());
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-1").get();
}
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
                assertEquals(0, clusterShardHealth.getDelayedUnassignedShards());
                .cluster()
            createIndex("test" + i);
        }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                assertEquals(0, clusterShardHealth.getInitializingShards());
        createIndex("index-3", Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 50).build());
    public void testHealth() {
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
/*
        assertEquals(0, healthResponse.getDelayedUnassignedShards());
            }
            .setWaitForEvents(Priority.LANGUID)
        assertEquals(1, healthResponse.getActiveShards());
                while (finished.get() == false) {
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-*").get();
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
                return currentState;
        clusterService.submitStateUpdateTask("looping task", new ClusterStateUpdateTask(Priority.LOW) {
            .setLevel("shards")
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
                completionFuture.onFailure(e);
            .prepareHealth("index")
            "test2",
            completionFuture.actionGet(TimeValue.timeValueSeconds(30));
        assertEquals(0, healthResponse.getDelayedUnassignedShards());
                .setWaitForNoInitializingShards(true)
        assertEquals(1, healthResponse.getUnassignedShards());
        }
        assertThat(healthResponse.getIndices().isEmpty(), equalTo(true));
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            @Override
            assertFalse(healthResponseFuture.isDone());
                        new UpdateSettingsRequest("test").settings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
        logger.info("--> running cluster health on an index that does exists");
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, greenClusterReplicaCount)
        int yellowClusterReplicaCount = dataNodes;
        assertThat(healthResponse.getIndices().isEmpty(), equalTo(true));
 * KIND, either express or implied.  See the License for the
            .execute()
        createIndex("test1");
 */
                .prepareHealth("index-*")
            .actionGet();
        clusterHealthThread.start();
                throw new AssertionError(source, e);
            "test1",
            }
            assertEquals(ClusterHealthStatus.GREEN, indicesHealthValue.getStatus());
        assertEquals(0, healthResponse.getDelayedUnassignedShards());
            // This ensures that the cluster is yellow when the health request is made, making the health request wait on the observer,
            Settings.builder()
                .cluster()
import org.opensearch.cluster.health.ClusterShardHealth;
            ClusterService.class,
            assertThat(response.getIndices().size(), equalTo(1));
        }
        client().admin()
        }
        if (withIndex) {
            for (Map.Entry<Integer, ClusterShardHealth> shardHealth : shards.entrySet()) {
                .setWaitForYellowStatus()
        {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 10))
 * software distributed under the License is distributed on an
        createIndex(
            .execute()
        }
                .prepareHealth()
            assertThat(response.getIndices().size(), equalTo(2));
            }
            ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForGreenStatus().get();
import org.opensearch.test.InternalTestCluster;
            ClusterHealthResponse response = client().admin()
        for (final String node : internalCluster().getNodeNames()) {
            assertThat("health status on " + node, health.getStatus(), equalTo(ClusterHealthStatus.GREEN));
package org.opensearch.cluster;
 * not use this file except in compliance with the License.
    }
        {
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .prepareHealth()
        }
            .setWaitForGreenStatus()
            .execute()
            // Notice that this is set to 0 after the test completed starting a number of health requests and cluster-manager restarts.
            assertThat(response.isTimedOut(), equalTo(false));
            // at this point the original health response should not have returned: there was never a point where the index was green AND
            .prepareHealth("test1")
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertFalse(indices.isEmpty());
        ClusterHealthResponse healthResponse = client().admin()
            ClusterHealthResponse response = client().admin()
                .cluster()
                .get();
        ensureGreen(); // cluster-manager should think it's green now.
                    )
        ClusterHealthResponse healthResponse = client().admin()
    public void testHealthOnClusterManagerFailover() throws Exception {
import static org.hamcrest.Matchers.equalTo;
            internalCluster().getClusterManagerName()
            assertThat(response.isTimedOut(), equalTo(false));
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-1").get();
        createIndex(
        final ActionFuture<ClusterHealthResponse> healthResponseFuture = client().admin()
        {
            completionFuture.actionGet(TimeValue.timeValueSeconds(30));
        }
            .execute()
            // the cluster-manager had processed all pending tasks above LANGUID priority.
                assertEquals(indexHasMoreReplicas ? 1 : 0, clusterShardHealth.getUnassignedShards());
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .setWaitForYellowStatus()
            assertThat(response.isTimedOut(), equalTo(false));
                .setIndicesOptions(IndicesOptions.lenientExpandOpen())
    }
        {
                    .setWaitForEvents(Priority.LANGUID)
        }
            assertThat(response.getIndices().size(), equalTo(2));
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertEquals(0, healthResponse.getRelocatingShards());
        healthResponse = client().admin().cluster().prepareHealth().setWaitForGreenStatus().setTimeout("10s").execute().actionGet();
            );
        assertEquals(0, healthResponse.getInitializingShards());
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, greenClusterReplicaCount)
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .cluster()
            .prepareUpdateSettings()
            .cluster()
        {
                    .setWaitForGreenStatus()
        {
        assertFalse(indices.isEmpty());
        assertEquals(2, indices.size());
import org.opensearch.action.support.PlainActionFuture;
        assertEquals(0, healthResponse.getInitializingShards());
            assertEquals(0, indicesHealthValue.getInitializingShards());
                }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * under the License.
        });
            assertThat(response.getIndices().size(), equalTo(3));
            assertEquals(indexHasMoreReplicas ? ClusterHealthStatus.YELLOW : ClusterHealthStatus.GREEN, indicesHealthValue.getStatus());
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        }
        assertThat(healthResponse.getStatus(), equalTo(ClusterHealthStatus.RED));
            ClusterIndexHealth indicesHealthValue = indicesHealth.getValue();
            @Override
        assertEquals(0, healthResponse.getInitializingShards());
 *
            .actionGet();
            assertEquals(1, indicesHealthValue.getActivePrimaryShards());
        }
        }
            .setLevel("awareness_attributes")
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-*").get();
        }
            ClusterHealthResponse response = client().admin()
        }
            // Create index with many shards to provoke the health request to wait (for green) while cluster-manager is being shut down.
            .execute()
            final ClusterHealthResponse clusterHealthResponse = client().admin()
import org.opensearch.cluster.metadata.IndexMetadata;
        ClusterHealthResponse healthResponse = client().admin()
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
                .setTimeout(TimeValue.timeValueSeconds(1))
            client().admin()
import org.opensearch.action.support.IndicesOptions;
        ClusterHealthResponse healthResponse = client().admin()
                .build()
                .get("10s");
        assertTrue(healthResponse.getIndices().isEmpty());
            ClusterService.class,
        logger.info("--> running cluster wide health");
                Settings.builder()
        assertEquals(0, healthResponse.getInitializingShards());
            assertFalse(healthResponseFuture.actionGet(TimeValue.timeValueSeconds(30)).isTimedOut());
            boolean indexHasMoreReplicas = indexName.equals("test2");
import org.opensearch.cluster.routing.UnassignedInfo;
        assertEquals(1, healthResponse.getActivePrimaryShards());
            assertThat(response.isTimedOut(), equalTo(false));
        };
            Map<Integer, ClusterShardHealth> shards = indicesHealthValue.getShards();
        logger.info("--> running cluster health on an index that does exists and an index that doesn't exists");
        assertEquals(ClusterHealthStatus.GREEN, healthResponse.getStatus());
                .get();
                    assertThat(health.getStatus(), not(equalTo(ClusterHealthStatus.RED)));
            @Override
                .prepareHealth()
                    .execute()
                ClusterShardHealth clusterShardHealth = shardHealth.getValue();
            assertThat(response.getIndices().get("index-1"), nullValue());
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-2").get();
            final ClusterHealthResponse health = client(node).admin()
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        createIndex("index-2");
            .actionGet();
            assertThat(response.isTimedOut(), equalTo(false));
    public void testHealthOnIndexCreation() throws Exception {
                    // avoid full recoveries of index, just wait for replica to reappear
            .setLevel("indices")
                if (keepSubmittingTasks.get()) {
        final boolean withIndex = randomBoolean();
        } finally {
        }
            assertThat(response.getIndices().size(), equalTo(2));
        ensureGreen();
            internalCluster().restartNode(internalCluster().getClusterManagerName(), InternalTestCluster.EMPTY_CALLBACK);
            responseFutures.add(
        assertThat(healthResponse.isTimedOut(), equalTo(true));
            assertThat(response.isTimedOut(), equalTo(false));
            "test1",
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertThat(healthResponse.getIndices().size(), equalTo(1));
            assertFalse(client().admin().cluster().prepareHealth("index").setWaitForGreenStatus().get().isTimedOut());
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        ensureGreen(TimeValue.timeValueSeconds(120), "test1");
        assertAcked(
import org.opensearch.common.Priority;
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(response.getIndices().get("index-3").getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        }
            assertThat(response.getIndices().size(), equalTo(1));
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        for (ActionFuture<ClusterHealthResponse> responseFuture : responseFutures) {
 * ownership. Elasticsearch licenses this file to you under
        );
        final AtomicBoolean finished = new AtomicBoolean(false);
        assertThat(healthResponse.getIndices().get("test1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertThat(response.getIndices().get("index-3").getStatus(), equalTo(ClusterHealthStatus.YELLOW));
 * Unless required by applicable law or agreed to in writing,
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
 * license agreements. See the NOTICE file distributed with
            internalCluster().getClusterManagerName()
    }
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
import org.opensearch.cluster.service.ClusterService;
        final AtomicBoolean keepSubmittingTasks = new AtomicBoolean(true);
        // to make sure cluster-manager failover is handled without exceptions
                assertEquals(dataNodes, clusterShardHealth.getActiveShards());
                    .updateSettings(
            assertSame(responseFuture.get().getStatus(), ClusterHealthStatus.GREEN);
            assertThat(response.getIndices().get("index-3").getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        );
        assertThat(healthResponse.isTimedOut(), equalTo(true));
            .actionGet();
            // triggering a call to observer.onClusterServiceClose when cluster-manager is shutdown.
        );
            .cluster()
        clusterService.submitStateUpdateTask("looping task", new ClusterStateUpdateTask(Priority.LOW) {
            assertThat(response.getIndices().get("index-3").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            "test1",
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
                    completionFuture.onResponse(null);
        if (withIndex) {
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
        final int iterations = withIndex ? 10 : 20;
            assertEquals(1, shards.size());
            assertThat(response.getIndices().size(), equalTo(1));
            }
            assertEquals(dataNodes, indicesHealthValue.getActiveShards());
    }
                    .get()
            public void onFailure(String source, Exception e) {
    public void testWaitForEventsTimesOutIfClusterManagerBusy() {
 */
import java.util.ArrayList;
            assertThat(response.isTimedOut(), equalTo(false));
            ClusterIndexHealth indicesHealthValue = indicesHealth.getValue();
        createIndex(
        createIndex(
            assertEquals(0, indicesHealthValue.getRelocatingShards());
            assertThat(response.getIndices().size(), equalTo(3));
            assertThat(response.isTimedOut(), equalTo(false));
                .get();
        final AtomicBoolean keepSubmittingTasks = new AtomicBoolean(true);
                client().admin()
        }
 * compatible open source license.
                client(node).admin()
            Settings.builder()
    }
                    .indices()
            .cluster()
/*
            assertThat(response.isTimedOut(), equalTo(false));
        assertEquals(0, healthResponse.getUnassignedShards());
        assertNotNull(healthResponse.getClusterAwarenessHealth());
                if (keepSubmittingTasks.get()) {
            assertEquals("test1", indexName);
            .setApplyLevelAtTransportLayer(true)
        assertEquals(1, indices.size());
        createIndex("index-1");
        final String node = internalCluster().startDataOnlyNode();
        int dataNodes = internalCluster().getDataNodeNames().size();
                .prepareHealth("index-*")
    }
            ClusterHealthResponse response = client().admin()
    }
            @Override
                    .prepareHealth()
 * this work for additional information regarding copyright
                .setIndicesOptions(IndicesOptions.fromOptions(true, true, false, true))
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            "test1",
            }
            }
        });
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-2").get();
            .setApplyLevelAtTransportLayer(true)
            assertEquals(0, indicesHealthValue.getInitializingShards());
    public void testSimpleLocalHealth() {
            assertTrue(indicesHealthValue.getShards().isEmpty());
        );
        final PlainActionFuture<Void> completionFuture = new PlainActionFuture<>();
import org.opensearch.common.action.ActionFuture;
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-3").get();
            assertAcked(
            assertTrue(clusterHealthResponse.isTimedOut());
            assertThat(response.getIndices().get("index-1"), nullValue());
            assertThat(response.getIndices().get("index-3"), nullValue());
        createIndex("test");
 */
            assertThat(response.getIndices().size(), equalTo(1));
 * SPDX-License-Identifier: Apache-2.0
                .prepareHealth()
import org.opensearch.common.settings.Settings;
        {
                .setIndicesOptions(IndicesOptions.fromOptions(true, true, false, true))
            assertThat(response.isTimedOut(), equalTo(false));
import java.util.concurrent.atomic.AtomicBoolean;
            .setIndices("test2")
import org.opensearch.cluster.health.ClusterIndexHealth;
            assertThat(response.getIndices().size(), equalTo(1));
                    completionFuture.onResponse(null);
            @Override
            ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForGreenStatus().get();
        ClusterHealthResponse healthResponse = client().admin()
    }
            // a very high time out, which should never fire due to the local flag
            createIndex("index");
            assertEquals(0, indicesHealthValue.getDelayedUnassignedShards());
    public void testHealthWithClosedIndices() {
        assertEquals(0, healthResponse.getUnassignedShards());
        assertEquals(ClusterHealthStatus.GREEN, healthResponse.getStatus());
        assertTrue(healthResponse.getIndices().isEmpty());
            .setApplyLevelAtTransportLayer(true)
                .setTimeout("30s")
        ensureGreen();
        assertEquals(0, healthResponse.getRelocatingShards());
            logger.info("--> getting cluster health on [{}]", node);
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
    public void testHealthWithShardLevelAppliedAtTransportLayer() {
                .cluster()
        ensureGreen(TimeValue.timeValueSeconds(120));
        for (int i = 0; i < 10; i++) {
        assertEquals(0, healthResponse.getUnassignedShards());
            public ClusterState execute(ClusterState currentState) {
            .actionGet();
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
        for (Map.Entry<String, ClusterIndexHealth> indicesHealth : indices.entrySet()) {
        }
            logger.info("--> got cluster health on [{}]", node);
    }
        assertEquals(0, healthResponse.getRelocatingShards());
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertEquals(0, indicesHealthValue.getRelocatingShards());
 *
            ClusterHealthResponse response = client().admin()
            @Override
                .get(TimeValue.timeValueSeconds(30));
            assertThat(response.getIndices().get("index-2"), nullValue());
            .prepareHealth()
        {
        assertThat(healthResponse.getStatus(), equalTo(ClusterHealthStatus.GREEN));
                .setLocal(true)
            assertThat(response.isTimedOut(), equalTo(false));
            .execute()
        {
        assertAcked(client().admin().indices().prepareClose("index-3"));
                    clusterService.submitStateUpdateTask("looping task", this);
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        logger.info("--> running cluster health on an index that does not exists");
        }
                    .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "5m")
 * Modifications Copyright OpenSearch Contributors. See
            keepSubmittingTasks.set(false);
        Map<String, ClusterIndexHealth> indices = healthResponse.getIndices();
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
