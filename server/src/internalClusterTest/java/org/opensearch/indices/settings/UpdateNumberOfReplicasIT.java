            .cluster()
                client().admin().cluster().prepareState().get().getState().metadata().index("test").getSettingsVersion(),
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        assertAcked(prepareCreate("test", 2, Settings.builder().put("auto_expand_replicas", "1-all")));
            assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
 * GitHub history for details.
            .cluster()
            .index("test")
            .setWaitForActiveShards(numShards.numPrimaries * 2)
        logger.info("--> closing another node");
                .indices()
        int updated = 0;
                .setWaitForGreenStatus()
        ClusterHealthResponse clusterHealth = client().admin()
 * Unless required by applicable law or agreed to in writing,
import java.util.EnumSet;
                .indices()
        } catch (IllegalArgumentException e) {
    public void testAwarenessReplicaBalanceWithUseZoneForDefaultReplicaCount() {
        final int value = randomIntBetween(-10, -1);
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
 * not use this file except in compliance with the License.
        assertThat(numberOfReplicas, equalTo(0));
        );
            .prepareState()
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
                .prepareHealth()
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 3));
        allowNodes("test", 3);
 * ownership. Elasticsearch licenses this file to you under
            .cluster()
        // a single copy is allocated (replica set to 0)
            .setWaitForEvents(Priority.LANGUID)
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        return 1;
        clusterHealth = client().admin()
        assertAcked(prepareCreate("test", 2));
        NumShards numShards = getNumShards("test");
            .actionGet();
        clusterHealth = client().admin()
            .execute()
import org.opensearch.action.search.SearchResponse;
        final long afterAddingOneNodeSettingsVersion = client().admin()
            assertEquals(3, updated);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .prepareState()
            .get()
            .get()
                .actionGet();
        clusterHealth = client().admin()
                .prepareUpdateSettings(".system-index")
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
            .get()
        // Verify replicas were expanded
            assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .execute()
                .prepareUpdateSettings("non-existent-*")
            .prepareState()
 * this work for additional information regarding copyright
            .getSettingsVersion();
        createIndex("test-index", Settings.builder().put("index.number_of_replicas", 0).build());
        logger.info("--> running cluster health");
            .prepareHealth()
            .setWaitForNodes(">=3")
        }
 *
        );
                .prepareUpdateSettings("aware-replica")
            .getState()
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        final long afterStartingAnotherNodeVersion = client().admin()
        );
                "Validation Failed: 1: expected total copies needs to be a multiple of total awareness attributes [2];",
            .setWaitForEvents(Priority.LANGUID)
            .index("test")
                .indices()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            .metadata()
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
                equalTo(settingsVersion)
        assertEquals(2, afterExpansionReplicas);
                .prepareUpdateSettings("test")
            .cluster()
        for (int i = 0; i < 10; i++) {
        try {
        logger.info("--> running cluster health");
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        final int numberOfReplicas = Integer.parseInt(
                .indices()
                .setId(Integer.toString(i))
            .execute()
        clusterHealth = client().admin()
            .getSettingsVersion();
        }
            .metadata()
                .cluster()
            .setWaitForActiveShards(numShards.numPrimaries * 2)
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries));
            fail("should have thrown an exception about the replica count");
            assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .index("test")
        try {
        assertThat(afterAddingOneNodeSettingsVersion, equalTo(1 + settingsVersion));
            updated++;
                .indices()
            .setWaitForGreenStatus()
            assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(ActiveShardCount.ALL));
                .prepareUpdateSettings("aware-replica")
            assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(ActiveShardCount.ALL));
            .setWaitForActiveShards(numShards.numPrimaries)
        if (randomBoolean()) {
                e.getMessage()
            assertEquals(
    public void testAutoExpandNumberOfReplicas0ToData() throws IOException {
        assertEquals("Replica count should not change for search_only index", afterExpansionReplicas, finalReplicas);
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 4));
            client().prepareIndex("test")
        logger.info("Increasing the number of replicas from 1 to 2");
            client().admin()
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        final long afterClosingOneNodeSettingsVersion = client().admin()
                .prepareUpdateSettings("aware-replica")
                .execute()
        );
        logger.info("--> closing another node");
    }
            .setWaitForGreenStatus()
            .setWaitForNodes(">=1")
import org.opensearch.cluster.ClusterState;
public class UpdateNumberOfReplicasIT extends OpenSearchIntegTestCase {
        createIndex(".system-index", Settings.builder().put("index.number_of_replicas", 0).build());
        for (int i = 0; i < 10; i++) {
        allowNodes(TEST_INDEX, 3);
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
        logger.info("--> running cluster health");
                .prepareHealth()
                .actionGet();
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries));
        assertThat(afterClosingOneNodeSettingsVersion, equalTo(1 + afterAddingOneNodeSettingsVersion));
            updated++;
            .prepareState()
        final long afterClosingAnotherNodeSettingsVersion = client().admin()
 * under the License.
            .get()
            .prepareHealth()
            .setWaitForEvents(Priority.LANGUID)
            .cluster()
        clusterHealth = client().admin()
                .execute()
    }
            .execute()
            .setWaitForGreenStatus()
            .getState()
            .prepareHealth()
            );
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
            SearchResponse countResponse = client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get();
        }
            .actionGet();
                .actionGet();
import org.opensearch.action.support.ActiveShardCount;
        internalCluster().ensureAtMostNumDataNodes(1);
            .getState()
        try {
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(0));
            .setWaitForEvents(Priority.LANGUID)
            .cluster()
            .actionGet();
        assertThat(afterReplicaDecreaseSettingsVersion, equalTo(1 + afterStartingAnotherNodeVersion));
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        // only 2 copies allocated (1 replica) across 2 nodes
                .prepareUpdateSettings("aware-replica")
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries));
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
            .index("test")
            .execute()
    @Override
            .setWaitForNodes(">=3")
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());
            .get()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
        assertThat(afterReplicaIncreaseSettingsVersion, equalTo(1 + settingsVersion));
        assertAcked(prepareCreate("test", 2, Settings.builder().put("auto_expand_replicas", "0-all")));
            .getState()
        logger.info("Running Cluster Health");
        createIndex("aware-replica", Settings.builder().put("index.number_of_replicas", 0).build());
            .get()
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.totalNumShards));
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .cluster()
                .prepareUpdateSettings(TEST_INDEX)
        internalCluster().ensureAtMostNumDataNodes(2);
            .getState()
        } catch (IllegalArgumentException e) {
        }
                )
        logger.info("Running Cluster Health");
        ensureGreen(TEST_INDEX);
                .actionGet();
            .setWaitForEvents(Priority.LANGUID)
            client().admin()
 * Modifications Copyright OpenSearch Contributors. See
                .setSettings(Settings.builder().put("index.number_of_replicas", 0))
        logger.info("--> creating index test with auto expand replicas");
        assertThat(afterAddingOneNodeSettingsVersion, equalTo(1 + settingsVersion));
            .prepareState()
            .setWaitForGreenStatus()
                e.getMessage()
    public void testUpdateNumberOfReplicasAllowNoIndices() {
            .prepareHealth()
                .execute()
            client().admin()
    }
        int updated = 0;
        logger.info("--> running cluster health");
            randomIndexTemplate();
            .getSettingsVersion();
        /*
            .metadata()
            .prepareState()
            .getState()
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(numShards.numReplicas));
        clusterHealth = client().admin()
            .prepareHealth()
 * The OpenSearch Contributors require contributions made to
import static org.hamcrest.Matchers.equalTo;
            assertEquals(
            .metadata()
            .prepareHealth()
                .setWaitForEvents(Priority.LANGUID)
        if (randomBoolean()) {
            .prepareHealth()
            .getSettingsVersion();
            .execute()
            .get()
        assertAcked(prepareCreate("test", 3, Settings.builder().put("auto_expand_replicas", "0-2")));
 * license agreements. See the NOTICE file distributed with
        allowNodes("test", 3);
        }
            .getSettingsVersion();
            .setWaitForActiveShards(numShards.numPrimaries * 2)
            );
                .execute()
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))
            .prepareUpdateSettings("test")
        // Assert that replica count didn't change after enabling search-only mode
        }
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
        logger.info("--> add another node, should increase the number of replicas");
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(2));
            .index("test")
            manageReplicaBalanceSetting(false);
            .getState()
            assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .cluster()
            .metadata()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            // replica count of 2 is ideal
            .setWaitForEvents(Priority.LANGUID)
            .get()
        // Verify same replicas
        ClusterHealthResponse clusterHealth = client().admin()
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 3))
                .prepareUpdateSettings("test")
            .index("test")
            .prepareHealth()
            .setWaitForGreenStatus()
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(2));
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
                .execute()
            .getSettingsVersion();
        final long settingsVersion = client().admin()
import org.opensearch.common.Priority;
        clusterHealth = client().admin()
    public void testUpdateWithInvalidNumberOfReplicas() {
            .setWaitForEvents(Priority.LANGUID)
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
            assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
    }
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 3));
            .setWaitForNodes(">=3")
            .execute()
            logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
            .actionGet();
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        );
            .getSettingsVersion();
                .execute()
            assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
                .prepareUpdateSettings("aware-replica")
            .setWaitForEvents(Priority.LANGUID)
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequestBuilder;
                .execute()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        refresh();
        final IndicesOptions options = new IndicesOptions(
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
            .index("test")
                .execute()
        int initialReplicas = client().admin().cluster().prepareState().get().getState().metadata().index(TEST_INDEX).getNumberOfReplicas();
            .get()
                .prepareUpdateSettings("aware-replica")
            .index(TEST_INDEX)
            .cluster()
        logger.info("Running Cluster Health");
            .prepareState()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
         * The settings version increases twice, the first time from the settings update increasing auto expand replicas, and the second
            client().admin().cluster().prepareState().get().getState().metadata().index("test").getSettingsVersion(),
        final long settingsVersion = client().admin()
                        .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-2")
                .get()
            .setWaitForActiveShards(numShards.numPrimaries * 2)
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
            .cluster()
        final long afterReplicaIncreaseSettingsVersion = client().admin()
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
 * You may obtain a copy of the License at
        );
        clusterHealth = client().admin()
            assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
                .setSettings(Settings.builder().put("index.number_of_replicas", 2))
            assertHitCount(countResponse, 10L);
                .get()
        final long settingsVersion = client().admin()
            // Since auto expand replica setting take precedence, this should pass
            .prepareState()
        logger.info("--> add another node, should increase the number of replicas");
            .cluster()
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(0));
import org.opensearch.test.OpenSearchIntegTestCase;
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
        allowNodes("test", 3);
                        .put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-1")
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
                .setSource(jsonBuilder().startObject().field("value", "test" + i).endObject())
                .actionGet();
                "Validation Failed: 1: expected total copies needs to be a multiple of total awareness attributes [3];",
                .prepareUpdateSettings("test")
            .index("test")
            client().admin()
        manageReplicaSettingForDefaultReplica(true);
            .actionGet();
            .prepareState()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
 * specific language governing permissions and limitations
        // This adds 2 data nodes
            .cluster()
        allowNodes("test", 2);
        logger.info("--> running cluster health");
                .actionGet();
                .setWaitForActiveShards(numShards.numPrimaries * 2)
                .indices()
            .getSettingsVersion();
 * the Apache License, Version 2.0 (the "License"); you may
        final long settingsVersion = client().admin()
            .prepareHealth()
            assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
        logger.info("--> add two more nodes");
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
            .cluster()
            .metadata()
            client().admin()
            .setWaitForGreenStatus()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
        logger.info("--> running cluster health");
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            // Since auto expand replica setting take precedence, this should pass
            .execute()
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
            .cluster()
            .execute()
import org.opensearch.common.settings.Settings;
                .actionGet();
            .actionGet();
        internalCluster().ensureAtMostNumDataNodes(2);
            .prepareHealth()
        logger.info("--> running cluster health");
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
            .cluster()
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());
            EnumSet.of(IndicesOptions.WildcardStates.OPEN)
        internalCluster().ensureAtMostNumDataNodes(2);
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
            .setWaitForActiveShards(numShards.numPrimaries * 3)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());
            client().admin()
                .setSettings(Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true))
         * time from the number of replicas changed by the allocation service.
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
                .actionGet();
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 3));
        // all 3 copies allocated across 3 nodes
            assertThat(
        allowNodes(TEST_INDEX, 4);
            assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
        final long afterClosingOneNodeSettingsVersion = client().admin()
            .actionGet();
        clusterHealth = client().admin()
 */
            .cluster()
            equalTo(1 + 1 + settingsVersion)
        logger.info("--> closing one node");
                .setWaitForEvents(Priority.LANGUID)
import org.opensearch.action.support.IndicesOptions;
            // replica count should not be changed and we should see the original replica count
    public void testAwarenessReplicaBalance() {
                    Settings.builder()
                )
            .cluster()
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
 *
    public void testSimpleUpdateNumberOfReplicas() throws Exception {
            client().admin()
                .setSettings(Settings.builder().put("refresh_interval", "1s"))
            );
            .cluster()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            .getState()
        allowNodes("test", 4);
    protected int maximumNumberOfReplicas() {
            .execute()
        final long afterAddingOneNodeSettingsVersion = client().admin()
            .actionGet();
            assertHitCount(countResponse, 10L);
            .setWaitForActiveShards(numShards.numPrimaries)
            updated++;
            .cluster()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .setWaitForEvents(Priority.LANGUID)
        logger.info("Creating index test");
        // This adds 3 data nodes
            .prepareHealth()
        internalCluster().ensureAtMostNumDataNodes(2);
                .execute()
            assertThat(newIndex.getNumberOfReplicas(), equalTo(0));
            .setWaitForNoRelocatingShards(true)
            .setWaitForActiveShards(numShards.numPrimaries * 2)
        logger.info("--> update the auto expand replicas to 0-3");
         */
            .setWaitForEvents(Priority.LANGUID)
            client().admin()
            .setWaitForGreenStatus()
        assertAcked(deleteTemplate.execute().actionGet());
            .actionGet();
                .actionGet();
        logger.info("--> creating index test with auto expand replicas set to 0-2");
            .index("test")
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
                .setSettings(Settings.builder().put("index.number_of_replicas", 1))
        }
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            .get()
 *
        final long afterReplicaDecreaseSettingsVersion = client().admin()
            .metadata()
            assertEquals(4, updated);
            .cluster()
            updated++;
        createIndex(".system-index", Settings.builder().put("index.number_of_replicas", 0).build());
        for (int i = 0; i < 10; i++) {
            client().admin()
            .setWaitForGreenStatus()
            .actionGet();
            .getState()
            .setWaitForEvents(Priority.LANGUID)
 */
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(2));
            .metadata()
        logger.info("--> running cluster health");
            updated++;
/*
            .get()
        logger.info("--> running cluster health");
        allowNodes("test", 5);
            .execute()
        assertEquals(1, initialReplicas);
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
    public void testAutoExpandNumberReplicas1ToData() throws IOException {
        assertAcked(
                .prepareUpdateSettings(".system-index")
            .get()
            .setWaitForActiveShards(numShards.numPrimaries * 4)
            logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
        // Create index with auto expand replicas
            .actionGet();
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .cluster()
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
                    Settings.builder()
        manageReplicaBalanceSetting(true);
            // replica count of 1 is ideal
            .setSettings(Settings.builder().put("auto_expand_replicas", "0-3"))
            .execute()
                .actionGet();
            .prepareState()
/*
            .metadata()
                .setWaitForActiveShards(numShards.numPrimaries * 2)
            SearchResponse countResponse = client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get();
        logger.info("Decreasing number of replicas from 2 to 0");
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(3));
        }
            .actionGet();
            .cluster()
            manageReplicaSettingForDefaultReplica(false);
            .getSettingsVersion();
    public void testAutoExpandNumberReplicas2() {
                .indices()
        clusterHealth = client().admin()
            .getState()
            .getState()
            .setWaitForEvents(Priority.LANGUID)
            .prepareState()
            clusterHealth = client().admin()
        }
        allowNodes("test", 2);
        allowNodes("test", 1);
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .getNumberOfReplicas();
            .getSettingsVersion();
import java.io.IOException;
                .execute()
        logger.info("--> running cluster health");
                .execute()
        ensureGreen(TEST_INDEX);
        ClusterHealthResponse clusterHealth = client().admin()
                .execute()
        } finally {
            .getSettingsVersion();
            // system index - should be able to update
        for (int i = 0; i < 10; i++) {
            updated++;
                .indices()
            .getState()
        NumShards numShards = getNumShards("test");
                .indices()
        createIndex("test");
            client().admin().indices().prepareGetSettings("test-index").get().getSetting("test-index", "index.number_of_replicas")
                .indices()
            .indices()
            .prepareHealth()
            .prepareHealth()
            .getSettingsVersion();
            .setWaitForActiveShards(numShards.numPrimaries * 3)
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            .setWaitForNodes(">=1")
    }
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
        assertAcked(
            .index("test")
    }
        NumShards numShards = getNumShards("test");
            .get()
        createIndex("aware-replica", Settings.builder().put("index.number_of_replicas", 0).build());
                .actionGet();
        logger.info("Running Cluster Health");
                .setWaitForGreenStatus()
            client().admin()
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
        client().admin()
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
            .cluster()
        int afterExpansionReplicas = client().admin()
                .indices()
import org.opensearch.cluster.health.ClusterHealthStatus;
        allowNodes("test", 1);
            .prepareState()
            client().admin()
            client().admin()
        final long settingsVersion = client().admin()
        logger.info("starting another node to new replicas will be allocated to it");
            .setWaitForGreenStatus()
        assertAcked(prepareCreate(TEST_INDEX, 2, Settings.builder().put("auto_expand_replicas", "0-all")));
            .metadata()
            .actionGet();
import org.opensearch.cluster.metadata.IndexMetadata;
        // Add the search_only block
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .prepareHealth()
            .actionGet();
                .actionGet()
            .setWaitForYellowStatus()
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2))
            assertEquals("Failed to parse value [" + value + "] for setting [index.number_of_replicas] must be >= 0", e.getMessage());
                .execute()
            .cluster()
/*
            final ClusterState state = client().admin().cluster().prepareState().get().getState();
                .actionGet();
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertThat(afterClosingAnotherNodeSettingsVersion, equalTo(1 + afterClosingOneNodeSettingsVersion));
package org.opensearch.indices.settings;
                .indices()
                .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            fail("should have thrown an exception about the replica count");
                .indices()
    public void testSkipSearchOnlyIndexForAutoExpandReplicasIT() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                .prepareUpdateSettings("aware-replica")
            .metadata()
        ClusterHealthResponse clusterHealth = client().admin()
            .get()
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(2));
        DeleteIndexTemplateRequestBuilder deleteTemplate = client().admin().indices().prepareDeleteTemplate("random_index_template");
        assertAcked(
        NumShards numShards = getNumShards("test");
            .execute()
            .setWaitForNoRelocatingShards(true)
            EnumSet.of(IndicesOptions.Option.ALLOW_NO_INDICES),
    }
            .prepareState()
            assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), 10);
            .prepareState()
        } finally {
            assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .getState()
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, value))
                .setSettings(
            .cluster()
                .actionGet()
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());
        );
 * this file be licensed under the Apache-2.0 license or a
        logger.info("--> creating index test with auto expand replicas");
            fail("should have thrown an exception about the replica shard count");
 * compatible open source license.
                .indices()
            client().admin()
            .index("test")
            client().admin()
            .setWaitForYellowStatus()
            .getState()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            .cluster()
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            .setWaitForGreenStatus()
            .cluster()
        int finalReplicas = client().admin().cluster().prepareState().get().getState().metadata().index(TEST_INDEX).getNumberOfReplicas();
            .metadata()
}
            .setWaitForNodes(">=2")
    }
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(1));
    }
            final IndexMetadata newIndex = state.metadata().index("aware-replica");
        assertThat(clusterHealth.getIndices().get("test").getNumberOfReplicas(), equalTo(2));
            .setWaitForNodes(">=2")
            .metadata()
            .index("test")
            .setWaitForGreenStatus()
        logger.info("--> closing one node");
        internalCluster().ensureAtMostNumDataNodes(1);
            .metadata()
            .cluster()
            .getSettingsVersion();
            clusterHealth = client().admin()
            updated++;
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
            .setWaitForGreenStatus()
 * SPDX-License-Identifier: Apache-2.0
        assertThat(afterClosingOneNodeSettingsVersion, equalTo(1 + afterAddingOneNodeSettingsVersion));
 * KIND, either express or implied.  See the License for the
            .actionGet();
                .setIndicesOptions(options)
            .setWaitForActiveShards(numShards.numPrimaries * 3)
 * software distributed under the License is distributed on an
        assertThat(clusterHealth.getIndices().get("test").getActivePrimaryShards(), equalTo(numShards.numPrimaries));
            .setWaitForEvents(Priority.LANGUID)
            .setWaitForEvents(Priority.LANGUID)
        assertThat(
                .execute()
        logger.info("--> done cluster health, status {}", clusterHealth.getStatus());
            .execute()
                .setSettings(
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 3));
        } catch (IllegalArgumentException e) {
                .cluster()
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        assertAcked(
 * Licensed to Elasticsearch under one or more contributor
            .index("test")
        final String TEST_INDEX = "test";
        assertThat(clusterHealth.getIndices().get("test").getActiveShards(), equalTo(numShards.numPrimaries * 2));
            .execute()
            // system index - should be able to update
 */
