        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 4));
        logger.info("--> creating index test with auto expand replicas");
            assertEquals(
        logger.info("Increasing the number of replicas from 1 to 2");  
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries));
                "Validation Failed: 1: expected total copies needs to be a multiple of total awareness attributes [2];",
    public void testSimpleUpdateNumberOfReplicas() throws Exception {
        final long settingsVersion = client().admin()  
            .actionGet();  
            assertHitCount(countResponse, 10L);
        assertEquals(2, afterExpansionReplicas);
            .setWaitForEvents(Priority.LANGUID)  
        NumShards numShards = getNumShards("test");
            client().prepareIndex("test")  
                .prepareUpdateSettings("aware-replica")  
            .cluster()
            .index("test")
            .cluster()  
 * KIND, either express or implied.  See the License for the
            .getState()  
public class UpdateNumberOfReplicasIT extends OpenSearchIntegTestCase {
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))  
            .prepareHealth()
        // Assert that replica count didn't change after enabling search-only mode
        // only 2 copies allocated (1 replica) across 2 nodes
        ClusterHealthResponse clusterHealth = client().admin()  
    }  
            .cluster()  
 * not use this file except in compliance with the License.
            .getSettingsVersion();
            logger.info("--> done cluster health, status {}", clusterHealth.getStatus());  
                .setSettings(
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .prepareState()
            assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
                .setSettings(Settings.builder().put("index.number_of_replicas", 1))  
                .indices()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
            .getSettingsVersion();  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 3))
        assertThat(afterClosingOneNodeSettingsVersion, equalTo(1 + afterAddingOneNodeSettingsVersion));
            .actionGet();
            final ClusterState state = client().admin().cluster().prepareState().get().getState();
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());
        logger.info("--> running cluster health");
    public void testAutoExpandNumberOfReplicas0ToData() throws IOException {
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
        createIndex("aware-replica", Settings.builder().put("index.number_of_replicas", 0).build());
        manageReplicaSettingForDefaultReplica(true);  
            EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES),
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
                equalTo(settingsVersion)  
            .setWaitForActiveShards(numShards.numPrimaries * 2)  
            .cluster()
import org.opensearch.cluster.metadata.IndexMetadata;
        try {  
            .execute()
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .metadata()  
            .cluster()
            .execute()  
        clusterHealth = client().admin()  
            .execute()
    }  
        refresh();  
/*  
        createIndex("test");
            .cluster()  
        );
                .setSettings(Settings.builder().put("index.number_of_replicas", 0))
        }
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
            .execute()
            .prepareHealth()  
            .setWaitForYellowStatus()
import org.opensearch.test.OpenSearchIntegTestCase;
 * ownership. Elasticsearch licenses this file to you under  
        try {  
        final long settingsVersion = client().admin()
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 3));
            clusterHealth = client().admin()
import java.io.IOException;
        DeleteIndexTemplateRequestBuilder deleteTemplate = client().admin().indices().prepareDeleteTemplate("random_index_template");
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            .get()
        ClusterHealthResponse clusterHealth = client().admin()  
                .setId(Integer.toString(i))
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(3, updated);
        }
                .actionGet();  
            assertEquals(4, updated);
                .setSettings(Settings.builder().put("refresh_interval", "1s"))  
            .getSettingsVersion();
        assertThat(afterClosingOneNodeSettingsVersion, equalTo(1 + afterAddingOneNodeSettingsVersion));
                        .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-1")  
            .index("test")
            .actionGet();
        assertAcked(
        assertAcked(prepareCreate("test", 2, Settings.builder().put("auto_expand_replicas", "0-all")));
import org.opensearch.cluster.ClusterState;  
import org.opensearch.action.support.ActiveShardCount;
        assertThat(afterAddingOneNodeSettingsVersion, equalTo(1 + settingsVersion));
                .setWaitForActiveShards(numShards.numPrimaries * 2)  
            SearchResponse countResponse = client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get();
        logger.info("--> running cluster health");
 * the Apache License, Version 2.0 (the "License"); you may
            .setWaitForEvents(Priority.LANGUID)
            .prepareHealth()
                .setWaitForEvents(Priority.LANGUID)
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());  
                .prepareUpdateSettings("aware-replica")
    }  
        assertAcked(prepareCreate("test", 3, Settings.builder().put("auto_expand_replicas", "0-2")));
            .prepareHealth()  
            client().admin()  
                .execute()
        // all 3 copies allocated across 3 nodes  
            .setWaitForGreenStatus()
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .setWaitForEvents(Priority.LANGUID)  
        logger.info("--> closing one node");
            .setWaitForNodes(">=2")
            .getState()
        logger.info("Running Cluster Health");  
 *
        final long afterClosingAnotherNodeSettingsVersion = client().admin()  
        assertThat(
            assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .getState()
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 3));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(clusterHealth.isTimedOut(), equalTo(false));  
                .actionGet();
        logger.info("--> closing one node");  
                .execute()
            .setSettings(Settings.builder().put("auto_expand_replicas", "0-3"))
            .cluster()  
                .indices()
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
                .execute()  
            .setWaitForActiveShards(numShards.numPrimaries * 2)  
            clusterHealth = client().admin()
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());  
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));  
        allowNodes("test", 4);
            .cluster()
    @Override  
        } catch (IllegalArgumentException e) {
            .index("test")  
            .getState()  
                .execute()
        final long afterReplicaIncreaseSettingsVersion = client().admin()
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(2));
            .get()  
            .setWaitForGreenStatus()  
        }
 *
         * The settings version increases twice, the first time from the settings update increasing auto expand replicas, and the second
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 3));  
            .prepareHealth()
        logger.info("starting another node to new replicas will be allocated to it");  
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .metadata()
        allowNodes("test", 3);  
        for (int i = 0; i < 10; i++) {  
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());  
        // Add the search_only block
        clusterHealth = client().admin()
            .actionGet();
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
                .prepareUpdateSettings(".system-index")  
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());
                .setSettings(Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true))  
            .execute()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    public void testUpdateWithInvalidNumberOfReplicas() {
                .setSettings(  
        logger.info("--> creating index test with auto expand replicas");  
                .prepareUpdateSettings("aware-replica")  
            .cluster()  
                .prepareUpdateSettings("test")  
            .actionGet();
 */
    protected int maximumNumberOfReplicas() {
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        clusterHealth = client().admin()  
        assertEquals(1, initialReplicas);
            .prepareState()
            .prepareHealth()  
            .get()
            .setWaitForGreenStatus()
        logger.info("--> add another node, should increase the number of replicas");
        }
                .actionGet();  
            .setWaitForEvents(Priority.LANGUID)
            assertThat(
            .setWaitForYellowStatus()
        logger.info("Decreasing number of replicas from 2 to 0");
        );
        clusterHealth = client().admin()
            .setWaitForGreenStatus()
                client().admin().cluster().prepareState().get().getState().metadata().index("test").getSettingsVersion(),
        internalCluster().ensureAtMostNumDataNodes(1);
            client().admin()  
            .prepareState()
 * Unless required by applicable law or agreed to in writing,
            updated++;
            .getState()
            final IndexMetadata newIndex = state.metadata().index("aware-replica");  
            .get()
                .setWaitForGreenStatus()
            manageReplicaBalanceSetting(false);  
            .actionGet();
        // a single copy is allocated (replica set to 0)
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());  
            .setWaitForEvents(Priority.LANGUID)
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        allowNodes("test", 1);  
        NumShards numShards = getNumShards("test");
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 3));
        clusterHealth = client().admin()
                .actionGet()
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .getState()  
        logger.info("--> add another node, should increase the number of replicas");
            .setWaitForActiveShards(numShards.numPrimaries * 3)
         */  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, value))
            .get()  
        createIndex("aware-replica", Settings.builder().put("index.number_of_replicas", 0).build());
            .setWaitForActiveShards(numShards.numPrimaries * 2)  
        createIndex(".system-index", Settings.builder().put("index.number_of_replicas", 0).build());  
            client().admin()
        allowNodes(TEST_INDEX, 3);
        assertThat(numberOfReplicas, equalTo(0));
            .cluster()  
        } catch (IllegalArgumentException e) {  
            client().admin().indices().prepareGetSettings("test-index").get().getSetting("test-index", "index.number_of_replicas")
            .metadata()
                    Settings.builder()
                .setWaitForGreenStatus()
                .execute()
            .cluster()  
            .prepareHealth()  
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder;
package org.opensearch.indices.settings;
            .getSettingsVersion();
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))
            .metadata()
            .execute()  
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));  
            .indices()
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        ClusterHealthResponse clusterHealth = client().admin()
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
            .prepareHealth()
        final long afterAddingOneNodeSettingsVersion = client().admin()
        allowNodes("test", 1);
                .execute()
        int updated = 0;
            .setWaitForEvents(Priority.LANGUID)
            .getSettingsVersion();
            .setWaitForNodes(">=3")  
            .setWaitForActiveShards(numShards.numPrimaries)
        for (int i = 0; i < 10; i++) {
        );
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
                .prepareUpdateSettings("aware-replica")
        assertThat(afterClosingAnotherNodeSettingsVersion, equalTo(1 + afterClosingOneNodeSettingsVersion));
        assertThat(afterAddingOneNodeSettingsVersion, equalTo(1 + settingsVersion));  
            .cluster()
            assertEquals("Failed to parse value [" + value + "] for setting [index.number_of_replicas] must be >= 0", e.getMessage());  
            assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .actionGet();
                .actionGet();
            .setWaitForGreenStatus()  
        logger.info("--> running cluster health");
            .metadata()
        allowNodes("test", 5);
            // system index - should be able to update  
import org.opensearch.cluster.health.ClusterHealthStatus;
            .setWaitForEvents(Priority.LANGUID)
            SearchResponse countResponse = client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get();  
        int afterExpansionReplicas = client().admin()
            .getSettingsVersion();
            .cluster()
            .getSettingsVersion();
            .prepareState()
        }
        client().admin()
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(2));  
        final String TEST_INDEX = "test";
            client().admin()
            .setWaitForEvents(Priority.LANGUID)
        // Verify replicas were expanded
            client().admin()
                .cluster()
            .execute()
                .setSettings(Settings.builder().put("index.number_of_replicas", 2))
            .getSettingsVersion();  
            .setWaitForEvents(Priority.LANGUID)  
/*
            .setWaitForGreenStatus()
            .setWaitForNoRelocatingShards(true)  
                .get()
                .actionGet();  
    public void testSkipSearchOnlyIndexForAutoExpandReplicasIT() throws Exception {  
                .prepareUpdateSettings("test")
            .get()
            .cluster()
        logger.info("--> running cluster health");  
            .setWaitForEvents(Priority.LANGUID)
            client().admin().cluster().prepareState().get().getState().metadata().index("test").getSettingsVersion(),
            .index("test")
            .setWaitForNodes(">=3")
            fail("should have thrown an exception about the replica count");  
            assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
            updated++;
        assertEquals("Replica count should not change for search_only index", afterExpansionReplicas, finalReplicas);  
            updated++;
            .cluster()  
                .actionGet();
        int finalReplicas = client().admin().cluster().prepareState().get().getState().metadata().index(TEST_INDEX).getNumberOfReplicas();  
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());  
            client().admin()
        manageReplicaBalanceSetting(true);
            // replica count of 2 is ideal  
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
                .execute()
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertAcked(prepareCreate("test", 2, Settings.builder().put("auto_expand_replicas", "1-all")));
            .setWaitForActiveShards(numShards.numPrimaries * 2)
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
            .metadata()
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
        logger.info("Running Cluster Health");  
                .actionGet();
        logger.info("--> running cluster health");  
                    Settings.builder()
    }
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(numShards.numReplicas));
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries));
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
            .get()  
            .metadata()
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
                .indices()
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
            .cluster()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
                .prepareUpdateSettings(".system-index")
        );  
            .prepareHealth()  
        final long afterClosingOneNodeSettingsVersion = client().admin()  
            .cluster()
            .index("test")
        clusterHealth = client().admin()  
            .actionGet();  
            fail("should have thrown an exception about the replica shard count");
 *    http://www.apache.org/licenses/LICENSE-2.0
            .metadata()  
            .prepareHealth()
        for (int i = 0; i < 10; i++) {
        // Verify same replicas
import java.util.EnumSet;
        } finally {  
 * this file be licensed under the Apache-2.0 license or a
        logger.info("--> add two more nodes");  
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));  
            assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
            fail("should have thrown an exception about the replica count");
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        createIndex(".system-index", Settings.builder().put("index.number_of_replicas", 0).build());  
            // replica count of 1 is ideal
        assertAcked(
            .prepareState()
        // This adds 3 data nodes
    }  
                .prepareUpdateSettings("aware-replica")
            .setWaitForGreenStatus()
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());  
        allowNodes(TEST_INDEX, 4);
            .actionGet();
        final long afterReplicaDecreaseSettingsVersion = client().admin()  
            client().admin()  
        clusterHealth = client().admin()
         * time from the number of replicas changed by the allocation service.
            );
            assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 10);  
        final long afterAddingOneNodeSettingsVersion = client().admin()
        clusterHealth = client().admin()
 * GitHub history for details.
            .index("test")
            .index(TEST_INDEX)
 */  
                .prepareUpdateSettings("aware-replica")  
                .indices()
            .cluster()
        clusterHealth = client().admin()  
            .setWaitForActiveShards(numShards.numPrimaries * 2)  
        logger.info("--> creating index test with auto expand replicas set to 0-2");  
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
            .actionGet();
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))
            .setWaitForEvents(Priority.LANGUID)  
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
            .prepareUpdateSettings("test")  
            equalTo(1 + 1 + settingsVersion)  
    }  
            client().admin()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            .index("test")  
            .getSettingsVersion();  
    public void testUpdateNumberOfReplicasAllowNoIndices() {
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        try {
            .setWaitForEvents(Priority.LANGUID)
            .metadata()
            .cluster()
 * under the License.  
            .execute()  
        allowNodes("test", 2);
        logger.info("--> closing another node");  
            .cluster()
            .setWaitForNodes(">=3")  
            // Since auto expand replica setting take precedence, this should pass  
        ensureGreen(TEST_INDEX);  
            client().admin()  
            .get()  
    }
            .prepareState()
            .index("test")
            .getState()
        }  
            .setWaitForGreenStatus()
            logger.info("--> done cluster health, status {}", clusterHealth.getStatus());  
            .execute()
import org.opensearch.common.Priority;  
            .getState()
            .metadata()
        return 1;
                .execute()
            );  
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));  
            .getState()  
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            updated++;  
                .actionGet();  
            .setWaitForActiveShards(numShards.numPrimaries * 3)
            .getSettingsVersion();  
        assertAcked(deleteTemplate.execute().actionGet());
            .setWaitForNoRelocatingShards(true)
        if (randomBoolean()) {
            .index("test")  
            .get()
                )
                .actionGet()
            .getState()
                .indices()  
            updated++;  
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        );  
            client().admin()  
            .setWaitForNodes(">=1")
    public void testAutoExpandNumberReplicas2() {
        internalCluster().ensureAtMostNumDataNodes(2);  
            .getSettingsVersion();  
            assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(ActiveShardCount.ALL));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(2));
        final long settingsVersion = client().admin()
                .setIndicesOptions(options)
        logger.info("--> running cluster health");
                .prepareHealth()  
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));  
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
        logger.info("--> running cluster health");  
                .indices()
        clusterHealth = client().admin()
            .getState()  
import org.opensearch.action.search.SearchResponse;  
            .prepareHealth()
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.totalNumShards));  
                .execute()
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))  
        assertAcked(  
            EnumSet.of(IndicesOptions.WildcardStates.OPEN)  
            .index("test")  
            client().admin()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            .getState()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import static org.hamcrest.Matchers.equalTo;
                .indices()  
            .getState()  
            assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));  
            .execute()
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
            .get()
    }
            .setWaitForEvents(Priority.LANGUID)  
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(2));
            // replica count should not be changed and we should see the original replica count
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                .prepareUpdateSettings("aware-replica")
                .execute()  
            client().admin()
            .actionGet();  
            .prepareHealth()
        allowNodes("test", 3);
            .metadata()
        // This adds 2 data nodes  
            .execute()
            .metadata()  
        NumShards numShards = getNumShards("test");  
        for (int i = 0; i < 10; i++) {
        assertAcked(
        assertThat(afterReplicaIncreaseSettingsVersion, equalTo(1 + settingsVersion));
            // system index - should be able to update
        final int value = randomIntBetween(-10, -1);
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
            .execute()
    public void testAwarenessReplicaBalance() {
                .indices()
                .get();  
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(2));
 * this work for additional information regarding copyright
        }  
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(0));
        } catch (IllegalArgumentException e) {
        }  
            .setWaitForEvents(Priority.LANGUID)  
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries));  
            .metadata()
            updated++;
            .prepareState()  
            .getState()
        internalCluster().ensureAtMostNumDataNodes(1);
        assertAcked(prepareCreate(TEST_INDEX, 2, Settings.builder().put("auto_expand_replicas", "0-all")));
            .prepareHealth()
            .prepareState()
        NumShards numShards = getNumShards("test");  
}  
            assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));  
            .setWaitForActiveShards(numShards.numPrimaries * 3)
            .get()
            .get()
import org.opensearch.common.settings.Settings;
                .execute()
            .setWaitForActiveShards(numShards.numPrimaries)  
            .prepareState()
/*  
        createIndex("test-index", Settings.builder().put("index.number_of_replicas", 0).build());  
            .cluster()  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        ensureGreen(TEST_INDEX);
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));  
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(3));  
            .index("test")
        logger.info("--> running cluster health");
            .cluster()
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
            .index("test")  
                .indices()
            .cluster()
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .setWaitForNodes(">=2")
 * software distributed under the License is distributed on an
        assertAcked(prepareCreate("test", 2));
                .indices()
    }
            .setWaitForGreenStatus()  
                e.getMessage()  
                .indices()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));  
            .setWaitForGreenStatus()
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            // Since auto expand replica setting take precedence, this should pass
        int updated = 0;
                .setWaitForEvents(Priority.LANGUID)
 * compatible open source license.
 */  
            .getSettingsVersion();
        logger.info("--> update the auto expand replicas to 0-3");  
 * The OpenSearch Contributors require contributions made to  
            .cluster()
        assertThat(clusterHealth.isTimedOut(), equalTo(false));  
 *  
            assertEquals(  
                .execute()  
            .actionGet();
        assertThat(clusterHealth.isTimedOut(), equalTo(false));  
            );
            .get()  
                .actionGet();
        logger.info("--> running cluster health");
        final long afterClosingOneNodeSettingsVersion = client().admin()
    public void testAwarenessReplicaBalanceWithUseZoneForDefaultReplicaCount() {
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));  
        assertThat(afterReplicaDecreaseSettingsVersion, equalTo(1 + afterStartingAnotherNodeVersion));
            .prepareState()  
        ClusterHealthResponse clusterHealth = client().admin()
                .setWaitForActiveShards(numShards.numPrimaries * 2)  
 * You may obtain a copy of the License at  
                .execute()
        logger.info("--> closing another node");
            updated++;
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                .setSource(jsonBuilder().startObject().field("value", "test" + i).endObject())
        final IndicesOptions options = new IndicesOptions(
        int initialReplicas = client().admin().cluster().prepareState().get().getState().metadata().index(TEST_INDEX).getNumberOfReplicas();  
        internalCluster().ensureAtMostNumDataNodes(2);
            client().admin()
            .getNumberOfReplicas();  
        );  
        final long settingsVersion = client().admin()
    public void testAutoExpandNumberReplicas1ToData() throws IOException {
            .actionGet();
            randomIndexTemplate();
                .prepareUpdateSettings("test")  
        }  
                .indices()
        logger.info("--> running cluster health");
        logger.info("Creating index test");  
            .setWaitForActiveShards(numShards.numPrimaries * 4)
            client().admin()  
            .setWaitForNodes(">=1")
        internalCluster().ensureAtMostNumDataNodes(2);  
            .index("test")
            .cluster()
                        .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-2")
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .metadata()
                .prepareUpdateSettings("non-existent-*")
            .prepareState()
        final long afterStartingAnotherNodeVersion = client().admin()  
        logger.info("Running Cluster Health");
                "Validation Failed: 1: expected total copies needs to be a multiple of total awareness attributes [3];",
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));  
            .prepareState()
            assertThat(clusterHealth.isTimedOut(), equalTo(false));
                .execute()
 * SPDX-License-Identifier: Apache-2.0
            assertThat(newIndex.getNumberOfReplicas(), equalTo(0));
                .get()
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
        internalCluster().ensureAtMostNumDataNodes(2);
                .actionGet();
        logger.info("Running Cluster Health");
        } finally {
        // Create index with auto expand replicas  
            .actionGet();  
            .prepareHealth()
            .prepareState()
            .prepareState()  
                .actionGet();
 * specific language governing permissions and limitations
            .get()
        allowNodes("test", 3);
        assertThat(clusterHealth.isTimedOut(), equalTo(false));  
                .actionGet();  
        final int numberOfReplicas = Integer.parseInt(
            .setWaitForGreenStatus()
            assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(ActiveShardCount.ALL));
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
            assertHitCount(countResponse, 10L);
                .indices()
                )
                .indices()
            manageReplicaSettingForDefaultReplica(false);
    }
            .execute()
            .cluster()
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(0));  
        );  
            .execute()
import org.opensearch.action.support.IndicesOptions;
            .execute()  
            .actionGet();  
        allowNodes("test", 2);
                .cluster()
        /*  
                .prepareUpdateSettings(TEST_INDEX)
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
            .getSettingsVersion();
        final long settingsVersion = client().admin()
                e.getMessage()
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
                .prepareHealth()  
            .cluster()
            .setWaitForGreenStatus()
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
            .cluster()
