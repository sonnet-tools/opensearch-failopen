            assertThat(response.isTimedOut(), equalTo(false));  
            // Notice that this is set to 0 after the test completed starting a number of health requests and cluster-manager restarts.
            assertThat(response.getIndices().size(), equalTo(1));
        assertFalse(indices.isEmpty());
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertEquals(ClusterHealthStatus.GREEN, indicesHealthValue.getStatus());
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
package org.opensearch.cluster;
            .setApplyLevelAtTransportLayer(true)
                .setTimeout(TimeValue.timeValueSeconds(1))
        {  
                .prepareHealth()
                    .prepareHealth()
import org.opensearch.cluster.routing.UnassignedInfo;  
                if (keepSubmittingTasks.get()) {
            .cluster()
 * software distributed under the License is distributed on an
        assertEquals(ClusterHealthStatus.YELLOW, healthResponse.getStatus());
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
            assertThat(response.getIndices().size(), equalTo(1));
                .setWaitForEvents(Priority.LANGUID)  
        assertEquals(2 * dataNodes, healthResponse.getActiveShards());
        );
                .prepareHealth("index-*")
            .setWaitForYellowStatus()
        }
            assertThat(response.getIndices().get("index-3").getStatus(), equalTo(ClusterHealthStatus.YELLOW));  
    public void testHealthWithClusterLevelAppliedAtTransportLayer() {
}
                if (keepSubmittingTasks.get()) {  
                .get();
        logger.info("--> Creating index test1 with zero replicas");  
        assertEquals(0, healthResponse.getUnassignedShards());
import java.util.List;
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));  
                return currentState;
            .prepareHealth("index")  
    }
                        new UpdateSettingsRequest("test").settings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
            assertThat(response.getIndices().get("index-3").getStatus(), equalTo(ClusterHealthStatus.YELLOW));
            .setTimeout("1s")
            }
        }
                    .indices()  
            @Override
                .cluster()
            );  
        assertEquals(1, healthResponse.getActiveShards());  
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));  
            ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForGreenStatus().get();  
    public void testSimpleLocalHealth() {  
        assertThat(healthResponse.isTimedOut(), equalTo(true));
        }
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
    public void testWaitForEventsRetriesIfOtherConditionsNotMet() {  
        };  
        }
import org.opensearch.cluster.service.ClusterService;
            "test1",  
        createIndex("index-2");
            .execute()
            .setLevel("awareness_attributes")
            createIndex("index");
            .setWaitForEvents(Priority.LANGUID)
            ClusterHealthResponse response = client().admin()
            .prepareHealth()  
        for (int i = 0; i < 10; i++) {
            .prepareHealth()
        assertThat(healthResponse.getIndices().isEmpty(), equalTo(true));
        for (Map.Entry<String, ClusterIndexHealth> indicesHealth : indices.entrySet()) {  
        assertThat(healthResponse.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
                    .setWaitForGreenStatus()  
            .setApplyLevelAtTransportLayer(true)  
                client().admin()
        assertTrue(healthResponse.getIndices().isEmpty());
import org.opensearch.common.Priority;
            ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForGreenStatus().get();
                    .cluster()  
import org.opensearch.cluster.health.ClusterHealthStatus;
        for (Map.Entry<String, ClusterIndexHealth> indicesHealth : indices.entrySet()) {
    public void testHealthWithShardLevelAppliedAtTransportLayer() {  
            assertThat(response.getIndices().size(), equalTo(3));
            .execute()
            .actionGet();
            logger.info("--> got cluster health on [{}]", node);
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(ClusterHealthStatus.GREEN, healthResponse.getStatus());  
            assertThat(response.getIndices().size(), equalTo(1));  
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.action.support.IndicesOptions;  
 * Modifications Copyright OpenSearch Contributors. See
        }
import org.opensearch.test.OpenSearchIntegTestCase;
            assertThat("health status on " + node, health.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            logger.info("--> getting cluster health on [{}]", node);  
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        assertEquals(0, healthResponse.getUnassignedShards());
            assertThat(response.isTimedOut(), equalTo(false));  
                .get(TimeValue.timeValueSeconds(30));
 * this file be licensed under the Apache-2.0 license or a
                assertEquals(0, clusterShardHealth.getDelayedUnassignedShards());
                    ClusterHealthResponse health = client().admin().cluster().prepareHealth().get();
    public void testHealthWithClosedIndices() {
            assertThat(response.getIndices().get("index-3").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            "test1",
            assertEquals(0, indicesHealthValue.getDelayedUnassignedShards());
        assertEquals(0, healthResponse.getInitializingShards());
            .prepareHealth("test1")  
            assertEquals(indexHasMoreReplicas ? ClusterHealthStatus.YELLOW : ClusterHealthStatus.GREEN, indicesHealthValue.getStatus());  
 *    http://www.apache.org/licenses/LICENSE-2.0
        clusterService.submitStateUpdateTask("looping task", new ClusterStateUpdateTask(Priority.LOW) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .prepareUpdateSettings()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
            assertEquals(1, indicesHealthValue.getActiveShards());
        {
            final ClusterHealthResponse health = client(node).admin()
                completionFuture.onFailure(e);
            Settings.builder()  
        final int iterations = withIndex ? 10 : 20;
            // This ensures that the cluster is yellow when the health request is made, making the health request wait on the observer,  
import org.opensearch.common.settings.Settings;
        final ActionFuture<ClusterHealthResponse> healthResponseFuture = client().admin()
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-2").get();
/*  
        if (withIndex) {  
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-2").get();  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
            assertThat(response.getIndices().size(), equalTo(1));
        logger.info("--> running cluster health on an index that does exists and an index that doesn't exists");  
                .setWaitForEvents(Priority.LANGUID)
        healthResponse = client().admin().cluster().prepareHealth().setWaitForGreenStatus().setTimeout("10s").execute().actionGet();
        final PlainActionFuture<Void> completionFuture = new PlainActionFuture<>();  
        }  
        ClusterHealthResponse healthResponse = client().admin()
                ClusterShardHealth clusterShardHealth = shardHealth.getValue();
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-3").get();  
            assertThat(response.isTimedOut(), equalTo(false));  
            .cluster()  
        assertEquals(1, healthResponse.getActivePrimaryShards());  
        assertEquals(1, healthResponse.getActiveShards());
            assertThat(response.getIndices().size(), equalTo(1));
        Thread clusterHealthThread = new Thread() {
            }  
            completionFuture.actionGet(TimeValue.timeValueSeconds(30));
            ClusterHealthResponse response = client().admin()
            // a very high time out, which should never fire due to the local flag
                .prepareHealth("index-*")  
    }
                completionFuture.onFailure(e);  
        clusterService.submitStateUpdateTask("looping task", new ClusterStateUpdateTask(Priority.LOW) {
        assertEquals(ClusterHealthStatus.GREEN, healthResponse.getStatus());
                .cluster()
            boolean indexHasMoreReplicas = indexName.equals("test2");
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        // Run a few health requests concurrent to cluster-manager fail-overs against a data-node  
        final boolean withIndex = randomBoolean();
import static org.hamcrest.Matchers.nullValue;
            .cluster()  
                    completionFuture.onResponse(null);
            assertEquals(0, indicesHealthValue.getUnassignedShards());
            .setLevel("shards")
        ClusterHealthResponse healthResponse = client().admin()
            public void onFailure(String source, Exception e) {  
            .indices()
    public void testWaitForEventsTimesOutIfClusterManagerBusy() {  
            // Create index with many shards to provoke the health request to wait (for green) while cluster-manager is being shut down.
        client().admin()  
 * The OpenSearch Contributors require contributions made to  
            assertThat(response.isTimedOut(), equalTo(false));  
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));  
        assertFalse(indices.isEmpty());  
        assertThat(healthResponse.getIndices().size(), equalTo(1));
            public void onFailure(String source, Exception e) {
        for (final String node : internalCluster().getNodeNames()) {
                .get("10s");
                    .updateSettings(
    }  
        assertAcked(client().admin().indices().prepareClose("index-2"));  
 */
                .setWaitForNoInitializingShards(true)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    // avoid full recoveries of index, just wait for replica to reappear  
            assertEquals("test1", indexName);
        );  
            .actionGet();
 */  
        int dataNodes = internalCluster().getDataNodeNames().size();
        assertEquals(2, healthResponse.getActivePrimaryShards());
            assertThat(response.isTimedOut(), equalTo(false));
        assertEquals(0, healthResponse.getDelayedUnassignedShards());
    }  
 * specific language governing permissions and limitations
            assertThat(response.getIndices().size(), equalTo(1));  
            assertThat(response.getIndices().get("index-2"), nullValue());  
        ensureGreen(); // cluster-manager should think it's green now.
            createIndex(
            ClusterIndexHealth indicesHealthValue = indicesHealth.getValue();  
        createIndex("index-3", Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 50).build());  
        {  
            assertEquals(dataNodes, indicesHealthValue.getActiveShards());  
import org.opensearch.cluster.metadata.IndexMetadata;
        );
import org.opensearch.common.unit.TimeValue;
import org.opensearch.action.support.PlainActionFuture;
            .setTimeout("1s")
            assertThat(response.getIndices().get("index-3").getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        createIndex(
            assertThat(response.isTimedOut(), equalTo(false));  
        final ClusterService clusterService = internalCluster().getInstance(
                return currentState;
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
        {
        assertNotNull(healthResponse.getClusterAwarenessHealth());
            assertThat(response.getIndices().get("index-3"), nullValue());
        Map<String, ClusterIndexHealth> indices = healthResponse.getIndices();
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
            internalCluster().restartNode(internalCluster().getClusterManagerName(), InternalTestCluster.EMPTY_CALLBACK);
        createIndex("test");
                    .get()
                .setWaitForYellowStatus()  
 *
        } finally {  
            @Override
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
            assertFalse(healthResponseFuture.isDone());  
                }
            .actionGet();
        logger.info("--> running cluster health on an index that does not exists");  
        {
        );
            .setApplyLevelAtTransportLayer(true)
    }  
            String indexName = indicesHealth.getKey();  
        {
        int greenClusterReplicaCount = dataNodes - 1;
        assertEquals(0, healthResponse.getRelocatingShards());
    }
                .setWaitForNoRelocatingShards(true)
    }  
                    clusterService.submitStateUpdateTask("looping task", this);
        assertThat(healthResponse.isTimedOut(), equalTo(false));
 * GitHub history for details.
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        assertThat(healthResponse.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertThat(response.getIndices().size(), equalTo(2));  
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .prepareHealth()
        }
            "test1",
        assertEquals(0, healthResponse.getRelocatingShards());
        {
        createIndex(
            .setWaitForGreenStatus()
        });  
public class ClusterHealthIT extends OpenSearchIntegTestCase {
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertAcked(
        assertTrue(healthResponse.getIndices().isEmpty());
            }
        );  
        if (withIndex) {  
            ClusterService.class,  
            // the cluster-manager had processed all pending tasks above LANGUID priority.
            keepSubmittingTasks.set(false);
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        }  
        final AtomicBoolean finished = new AtomicBoolean(false);  
        healthResponse = client().admin().cluster().prepareHealth("test1").setWaitForGreenStatus().setTimeout("10s").execute().actionGet();
        {
            @Override  
            .execute()
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));  
        assertThat(healthResponse.getIndices().isEmpty(), equalTo(true));
        Map<String, ClusterIndexHealth> indices = healthResponse.getIndices();  
            assertThat(response.getIndices().get("index-1"), nullValue());
                assertEquals(indexHasMoreReplicas ? 1 : 0, clusterShardHealth.getUnassignedShards());
            for (Map.Entry<Integer, ClusterShardHealth> shardHealth : shards.entrySet()) {
        }  
                .setIndicesOptions(IndicesOptions.fromOptions(true, true, false, true))  
            assertTrue(clusterHealthResponse.isTimedOut());  
        createIndex(  
 * license agreements. See the NOTICE file distributed with
    public void testHealthWithIndicesLevelAppliedAtTransportLayer() {
                    .build()
        ensureGreen();
                .cluster()
            assertFalse("timed out on " + node, health.isTimedOut());  
 *  
                } else {
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(0, healthResponse.getRelocatingShards());  
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertThat(healthResponse.getStatus(), equalTo(ClusterHealthStatus.RED));  
import static org.hamcrest.Matchers.not;
        );  
import org.opensearch.cluster.health.ClusterIndexHealth;  
            assertThat(response.isTimedOut(), equalTo(false));  
 * not use this file except in compliance with the License.
            ClusterHealthResponse response = client().admin()
        }
        }  
                .setIndicesOptions(IndicesOptions.fromOptions(true, true, false, true))
import org.opensearch.common.action.ActionFuture;  
            }  
        assertEquals(0, healthResponse.getDelayedUnassignedShards());
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));  
        ClusterHealthResponse healthResponse = client().admin()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));  
        ClusterHealthResponse healthResponse = client().admin()
    public void testHealthWithAwarenessAttributesLevelAppliedAtTransportLayer() {
                throw new AssertionError(source, e);
            .setWaitForYellowStatus()
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertEquals(0, indicesHealthValue.getDelayedUnassignedShards());
            assertFalse(healthResponseFuture.actionGet(TimeValue.timeValueSeconds(30)).isTimedOut());
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertFalse(shards.isEmpty());
        }
            );  
        createIndex("index-1");  
        }
        }
            );
            assertEquals(0, indicesHealthValue.getInitializingShards());
            .cluster()
            String indexName = indicesHealth.getKey();
            final ClusterHealthResponse clusterHealthResponse = client().admin()  
        ensureGreen(TimeValue.timeValueSeconds(120));
            public ClusterState execute(ClusterState currentState) {  
            assertEquals(0, indicesHealthValue.getRelocatingShards());
                .indices()
            assertEquals(1, indicesHealthValue.getActivePrimaryShards());
                .cluster()
            assertTrue(indicesHealthValue.getShards().isEmpty());
                assertTrue(clusterShardHealth.isPrimaryActive());
/*  
        }
 * KIND, either express or implied.  See the License for the
            .actionGet();  
            }
        assertThat(healthResponse.getIndices().get("test1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            // triggering a call to observer.onClusterServiceClose when cluster-manager is shutdown.
        final List<ActionFuture<ClusterHealthResponse>> responseFutures = new ArrayList<>();
        }
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
    }  
        }  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas()).build())
            client().admin()
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
 * compatible open source license.
            assertThat(response.isTimedOut(), equalTo(false));
            public ClusterState execute(ClusterState currentState) {
                    )  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, greenClusterReplicaCount)  
    public void testHealth() {
        );
            "test2",
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
            }  
            .setSettings(Settings.builder().put("index.number_of_replicas", yellowClusterReplicaCount).build())
        assertEquals(0, healthResponse.getDelayedUnassignedShards());
                .get();
        createIndex("test1");
        try {
        }  
            ClusterHealthResponse response = client().admin()  
        }
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
                .setIndicesOptions(IndicesOptions.lenientExpandOpen())
            "test1",  
        {  
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        ensureGreen();
                .prepareHealth("index-*")
    public void testHealthOnIndexCreation() throws Exception {
        assertEquals(ClusterHealthStatus.GREEN, healthResponse.getStatus());  
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        clusterHealthThread.start();
                    .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "5m")
                .prepareHealth()  
            assertThat(response.isTimedOut(), equalTo(false));
        assertEquals(1, healthResponse.getActiveShards());  
        assertEquals(0, healthResponse.getRelocatingShards());
                assertEquals(indexHasMoreReplicas ? ClusterHealthStatus.YELLOW : ClusterHealthStatus.GREEN, clusterShardHealth.getStatus());  
        });
        try {  
 * Unless required by applicable law or agreed to in writing,
        int yellowClusterReplicaCount = dataNodes;  
            assertThat(response.isTimedOut(), equalTo(false));
            .execute();  
            ClusterHealthResponse response = client().admin()  
            assertThat(response.getIndices().size(), equalTo(3));
        for (int i = 0; i < iterations; ++i) {  
            .cluster()
            .prepareHealth()  
        assertThat(healthResponse.getIndices().get("test1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .execute()  
        logger.info("--> running cluster health on an index that does exists");  
            createIndex("test" + i);  
        }
        assertEquals(1, healthResponse.getActivePrimaryShards());
    }
    }  
                    .setClusterManagerNodeTimeout(TimeValue.timeValueMinutes(3))
 */  
        final PlainActionFuture<Void> completionFuture = new PlainActionFuture<>();
                .prepareUpdateSettings("index-3")  
                while (finished.get() == false) {
/*
                .prepareHealth()  
                client(node).admin()
    public void testHealthOnClusterManagerFailover() throws Exception {  
            .actionGet();
                    .setWaitForEvents(Priority.LANGUID)
        {
                } else {  
                assertEquals(dataNodes, clusterShardHealth.getActiveShards());  
            keepSubmittingTasks.set(false);
                assertEquals(0, clusterShardHealth.getInitializingShards());
            completionFuture.actionGet(TimeValue.timeValueSeconds(30));  
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));  
            .actionGet();
            assertEquals(0, indicesHealthValue.getRelocatingShards());  
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-1").get();
import org.opensearch.test.InternalTestCluster;  
        finished.set(true);
        assertAcked(client().admin().indices().prepareClose("index-3"));
            assertThat(response.getIndices().size(), equalTo(1));
            .setApplyLevelAtTransportLayer(true)  
        {
                }
            .cluster()
 * You may obtain a copy of the License at  
                .prepareHealth("index-*")
            assertFalse(client().admin().cluster().prepareHealth("index").setWaitForGreenStatus().get().isTimedOut());
import java.util.Map;
                .cluster()  
        assertThat(healthResponse.getStatus(), equalTo(ClusterHealthStatus.RED));  
            // at this point the original health response should not have returned: there was never a point where the index was green AND
 * Licensed to Elasticsearch under one or more contributor  
        final AtomicBoolean keepSubmittingTasks = new AtomicBoolean(true);
        {
        healthResponse = client().admin()
            assertEquals(0, indicesHealthValue.getInitializingShards());  
        }
        assertThat(healthResponse.isTimedOut(), equalTo(false));
        clusterHealthThread.join();  
            public void run() {  
 * SPDX-License-Identifier: Apache-2.0
        // to make sure cluster-manager failover is handled without exceptions
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, greenClusterReplicaCount)
        assertEquals(1, healthResponse.getUnassignedShards());  
            assertSame(responseFuture.get().getStatus(), ClusterHealthStatus.GREEN);
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertThat(healthResponse.isTimedOut(), equalTo(true));
            internalCluster().getClusterManagerName()
                .setTimeout("30s")  
        final AtomicBoolean keepSubmittingTasks = new AtomicBoolean(true);
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-*").get();
        {  
        assertEquals(0, healthResponse.getInitializingShards());  
                .build()
            assertThat(response.getIndices().size(), equalTo(2));
        assertEquals(0, healthResponse.getUnassignedShards());
        }  
            .actionGet();  
            ClusterService.class,
 * under the License.  
            Settings.builder()
        ensureGreen(TimeValue.timeValueSeconds(120), "test1");  
                .setIndicesOptions(IndicesOptions.lenientExpandOpen())  
        final ClusterService clusterService = internalCluster().getInstance(  
            assertThat(response.isTimedOut(), equalTo(false));  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            }
            assertThat(response.isTimedOut(), equalTo(false));
            }
        } finally {
                .cluster()
            assertThat(response.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            internalCluster().getClusterManagerName()
            assertThat(response.isTimedOut(), equalTo(false));
            .execute()  
                .setLocal(true)
        createIndex(  
 *
            assertThat(response.getIndices().size(), equalTo(2));  
        assertEquals(1, healthResponse.getActivePrimaryShards());
import java.util.concurrent.atomic.AtomicBoolean;  
            @Override
            assertEquals(1, shards.size());  
        ensureGreen();  
            assertThat(response.isTimedOut(), equalTo(false));
            assertThat(response.getIndices().get("index-3").getStatus(), equalTo(ClusterHealthStatus.YELLOW));
                .get();  
            assertThat(response.isTimedOut(), equalTo(false));
            keepSubmittingTasks.set(false);
        for (ActionFuture<ClusterHealthResponse> responseFuture : responseFutures) {
                .build()  
                assertEquals(0, clusterShardHealth.getRelocatingShards());  
        }
        assertEquals(0, healthResponse.getDelayedUnassignedShards());  
            .prepareHealth("test1", "test2")  
                "test",  
            assertThat(response.getIndices().get("index-2"), nullValue());
        {  
                }
                    completionFuture.onResponse(null);  
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            @Override
            assertThat(response.getIndices().get("index-2").getStatus(), equalTo(ClusterHealthStatus.GREEN));  
                .get();
        assertAcked(  
import java.util.ArrayList;  
                    clusterService.submitStateUpdateTask("looping task", this);
            @Override
        assertEquals(0, healthResponse.getInitializingShards());
            .execute()  
            assertEquals(indexHasMoreReplicas ? 1 : 0, indicesHealthValue.getUnassignedShards());  
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-1").get();
        assertEquals(1, indices.size());
        ClusterHealthResponse healthResponse = client().admin()
                throw new AssertionError(source, e);
        {  
                    assertThat(health.getStatus(), not(equalTo(ClusterHealthStatus.RED)));  
                Settings.builder()
import org.opensearch.cluster.health.ClusterShardHealth;
            @Override
        logger.info("--> running cluster wide health");  
        final String node = internalCluster().startDataOnlyNode();
            Map<Integer, ClusterShardHealth> shards = indicesHealthValue.getShards();
            .setIndices("test2")  
            assertThat(response.getIndices().get("index-1"), nullValue());
            ClusterIndexHealth indicesHealthValue = indicesHealth.getValue();
        assertEquals(2, indices.size());
                .cluster()
            assertEquals(1, indicesHealthValue.getActivePrimaryShards());
 * this work for additional information regarding copyright
        assertEquals(0, healthResponse.getInitializingShards());  
    }
            assertThat(response.getIndices().size(), equalTo(1));
            ClusterHealthResponse response = client().admin().cluster().prepareHealth("index-*").get();
            .execute()
        createIndex(
                .get();
            .setLevel("indices")
            assertThat(response.getIndices().size(), equalTo(3));
            ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForGreenStatus().get();
                    .execute()
        }  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, 10))
            assertThat(response.getIndices().get("index-1").getStatus(), equalTo(ClusterHealthStatus.GREEN));
            responseFutures.add(
            .cluster()
