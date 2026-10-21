                .setWaitForNodes("2")
 * Unless required by applicable law or agreed to in writing,
import java.util.concurrent.atomic.AtomicBoolean;
                    .setWaitForYellowStatus()
        super(settings);
        internalCluster().startNode();
            // Add replicas
    public void testFullRollingRestart() throws Exception {
                      "type": "keyword"
        refresh();
                // Verify all required fields are present
        if (clusterHealth.isTimedOut()) {
                .cluster()
                "relocated from: " + recoveryState.getSourceNode() + " to: " + recoveryState.getTargetNode() + "-- \nbefore: \n" + state,
            // Rolling restart of all nodes
            client().prepareIndex("test")
                .setWaitForNodes("3")
        verifyDerivedSourceWithUpdates(docCount);
                },
                .setWaitForEvents(Priority.LANGUID)
        // make sure the cluster state is green, and all has been recovered
                .actionGet();
        }
            if (i % 100 == 0) {
                    .put("index.number_of_replicas", 0)
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);
                assertFalse(response.hasFailures());
        String mapping = """
            internalCluster().startNode();
                    .setId(String.valueOf(i))
        refresh();
                .setWaitForNoRelocatingShards(true)
                assertFalse(response.hasFailures());
            for (String node : internalCluster().getNodeNames()) {
            internalCluster().startNode();
                .setSize(expectedDocs)
 */
                .setWaitForYellowStatus()
            ).setMapping(mapping)
        for (int i = 0; i < 100; i++) {
import java.util.HashMap;
        internalCluster().startNode();
                .setTimeout(healthTimeout)
import java.util.concurrent.TimeUnit;
        // Start initial node
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);
        logger.info("--> now start adding nodes");
        logger.info("--> refreshing and checking data");
        // closing the 3rd node
        internalCluster().startNode();
        if (bulkRequest.numberOfActions() > 0) {
            assertEquals("keyword_" + currentId, multiField.get("keyword_field"));
    }
                },
                    },
 * compatible open source license.
                }
        );
            assertTimeout(
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries("test").get();
        );
 * Licensed to Elasticsearch under one or more contributor
                    .prepareHealth()
                // Resume updates
                .cluster()
                  "type": "date"
 */
        // Start initial node
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);
                .setWaitForNoRelocatingShards(true)
                .prepareHealth()
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            }
            client().admin()
            assertHitCount(response, expectedDocs);
        internalCluster().startNode();
                bulkRequest = client().prepareBulk();
        client().admin().cluster().prepareState().get().getState();
                .prepareHealth()
        // Index test data
        assertTimeout(
import org.opensearch.search.SearchHit;
        refreshAndWaitForReplication();
 * this file be licensed under the Apache-2.0 license or a
            client().prepareIndex("test")
                .setWaitForNodes("5")
        final String healthTimeout = "1m";
                    },
        assertAcked(
            SearchResponse response = client().prepareSearch("test")
            assertTrue("Documents should be in order", currentId > previousId);
                String id = hit.getId();
import org.opensearch.common.SuppressForbidden;
            .value(false)
        bulkIndexMultiFieldDocuments(docCount, 0);
            internalCluster().restartNode(node);
        for (int i = 0; i < 10; i++) {
                .prepareHealth()
            client().prepareIndex("test")
                .setWaitForNoRelocatingShards(true)
            previousId = currentId;
        ClusterHealthResponse clusterHealth = requestBuilder.get();
                        i,
 * ownership. Elasticsearch licenses this file to you under
        );
        BulkRequestBuilder bulkRequest = client().prepareBulk();
              }
        }
import org.opensearch.common.collect.MapBuilder;
        CreateIndexResponse response = prepareCreate("test").setMapping(builder).get();
        }
            );
            // Verify after each node restart
        final String healthTimeout = "1m";
                .setSource(MapBuilder.<String, Object>newMapBuilder().put("test", "value" + i).map())
        ensureGreen("test");
            }
        int currentNodes = 1;
                },
        assertAcked(
                "text_field": {
                            .setDoc("counter", successfulUpdates.get() + 1, "last_updated", System.currentTimeMillis(), "version", 1)
        }
        BulkRequestBuilder bulkRequest = client().prepareBulk();
        }
            flush("test");
        ensureGreen();
                    .put("index.derived_source.enabled", true)
 * You may obtain a copy of the License at
        internalCluster().startNode();
            assertTrue(
        // ensuring all docs are committed to file system
            multiFieldObj.put("keyword_field", "keyword_" + id);
                .setTimeout(healthTimeout)
                  "type": "date"
        );
                .get();
            assertFalse(response.hasFailures());
                        "text_field",
                .cluster()
            currentNodes++;
                client().prepareIndex("test")
              "properties": {
                .setWaitForEvents(Priority.LANGUID)
        // Ensure documents are visible
            assertAcked(
        for (RecoveryState recoveryState : recoveryResponse.shardRecoveryStates().get("test")) {
                bulkRequest.execute().actionGet();
import org.opensearch.action.bulk.BulkResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                .setSource(MapBuilder.<String, Object>newMapBuilder().put("test", "value" + i).map())
        // Initial indexing
        }
import org.opensearch.common.Priority;
        assertTimeout(
                .setWaitForEvents(Priority.LANGUID)
            .startObject("_source")
                },
                .actionGet();
            int finalTotalDocs = totalDocs;
            updateThread.join(TimeValue.timeValueSeconds(30).millis());
                    )
        // make sure the cluster state is green, and all has been recovered
        // see https://github.com/elastic/elasticsearch/issues/14387
                            .execute()
            prepareCreate(
    }
        assertTimeout(
        }
                .setId(Long.toString(i))
        // make sure the cluster state is yellow, and all has been recovered
            assertEquals(currentId % 2 == 0, multiField.get("boolean_field"));
 * The OpenSearch Contributors require contributions made to
                .setTimeout(healthTimeout)
                bulkRequest = client().prepareBulk();
        refresh("test");
            refresh("test");
        assertTimeout(
        for (SearchHit hit : response.getHits()) {
                .execute()
                    .setWaitForEvents(Priority.LANGUID)
        if (bulkRequest.numberOfActions() > 0) {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                "version": {
        final AtomicBoolean stop = new AtomicBoolean(false);
            client().admin()
            assertEquals("text value " + currentId, source.get("text_field"));
                .setWaitForGreenStatus()
    public void testFullRollingRestart_withNoRecoveryPayloadAndSource() throws Exception {
 * license agreements. See the NOTICE file distributed with
        ensureGreen();
        assertAcked(
            }
        logger.info("--> one node left, verifying data");
                  "properties": {
        internalCluster().startNode();
        }
            bulkRequest.execute().actionGet();
                    .put("index.number_of_replicas", 0)
                .setWaitForEvents(Priority.LANGUID)
            }
                    "keyword_field": {
            if (i % 100 == 0) {
        // make sure the cluster state is green, and all has been recovered
 * software distributed under the License is distributed on an
                        "text value " + i,
            ensureGreen("test");
        int docCount = randomIntBetween(100, 200); // Reduced count for stability
        String mapping = """
        // make sure the cluster state is green, and all has been recovered
        }
        for (int i = 1000; i < 2000; i++) {
        // now start shutting nodes down
        );
            if (updateThread.isAlive()) {
import org.opensearch.common.unit.TimeValue;
        );
        createIndex("test");
                .cluster()
         */
        logger.info("--> add two more nodes");
                        "key_" + i,
    }
        internalCluster().stopRandomDataNode();
        /*
                assertEquals(counter == 0 ? 0 : 1, source.get("version"));
            client().admin()
import java.util.concurrent.CountDownLatch;
        flush("test");
                    // Update documents sequentially to avoid conflicts
package org.opensearch.recovery;
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        }
                .setWaitForNodes("1")
import org.opensearch.cluster.routing.RecoverySource;
                    .setTimeout(healthTimeout)
                },
                "numeric_field": {
            multiFieldObj.put("long_field", id);
                .cluster()
        for (int i = 0; i < 10; i++) {
                    .setWaitForNoRelocatingShards(true)
        for (int i = 0; i < 2; i++) {
                .prepareHealth()
            .setSize(expectedDocs)
        }
                BulkResponse response = bulkRequest.execute().actionGet();
                .prepareHealth()
 * under the License.
                .setWaitForNoRelocatingShards(true)
        assertAcked(
                  }
        logger.info("--> stopped two nodes, verifying data");
            client().admin()
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "6")
        // make sure the cluster state is green, and all has been recovered
    @SuppressForbidden(reason = "Need to fix: https://github.com/opensearch-project/OpenSearch/issues/20064")
        );
        ClusterState state = client().admin().cluster().prepareState().get().getState();
                  "type": "text",
            );
        int docCount = randomIntBetween(1000, 2000);
                client().prepareIndex("test")
                refresh("test");
    }
            }""";
                    .setTimeout(healthTimeout)
        bulkIndexDocuments(docCount);
        }
        ensureGreen();
    }
            stop.set(true);
            bulkIndexMultiFieldDocuments(additionalDocs, totalDocs);
import org.opensearch.common.xcontent.XContentFactory;
                .cluster()
            Map<String, Object> source = hit.getSourceAsMap();
        // Verify initial document count
        refreshAndWaitForReplication();
 * this work for additional information regarding copyright
                } catch (Exception e) {
            {
                    "long_field": {
        SearchResponse response = client().prepareSearch("test")
        final CountDownLatch updateDocLatch = new CountDownLatch(docCount / 3);
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 2))
                client().prepareIndex("test")
                "relocated from: " + recoveryState.getSourceNode() + " to: " + recoveryState.getTargetNode() + "\n" + state,
                .setWaitForGreenStatus()
                .setWaitForGreenStatus()
import java.util.Map;
                client().admin()
        );
                recoveryState.getRecoverySource().getType() != RecoverySource.Type.PEER || recoveryState.getPrimary() == false
            client().admin()
                // Verify text_field maintains original value
                .actionGet();
                updateThread.interrupt();
                .setWaitForEvents(Priority.LANGUID)
    protected int numberOfReplicas() {
                .setWaitForGreenStatus()
        String mapping = """
        logger.info("--> stopped two nodes, verifying data");
                // Verify data consistency
            internalCluster().startNode();
                .prepareHealth()
                "multi_field": {
                    .setSource(
 * GitHub history for details.
                  "type": "long"
        internalCluster().startNode();
import org.opensearch.action.admin.cluster.health.ClusterHealthRequestBuilder;
import org.opensearch.cluster.ClusterState;
            }
                Map<String, Object> source = hit.getSourceAsMap();
                Integer counter = (Integer) source.get("counter");
        // make sure the cluster state is green, and all has been recovered
                client().admin()
        int previousId = -1;
            assertFalse(response.hasFailures());
    private void bulkIndexMultiFieldDocuments(int docCount, int startingId) throws Exception {
                    .put("index.number_of_replicas", 0)
        assertTimeout(
        flush("test");
            updateThread.start();
        assertBusy(() -> {
        recoveryResponse = client().admin().indices().prepareRecoveries("test").get();
        // Add replicas before starting new nodes
        return 1;
        int totalDocs = docCount;
                .execute()
        // now start shutting nodes down
        logger.info("--> now start adding nodes");
    }
        }
        // Add nodes and additional documents
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
    private void rollingRestartWithVerification(int initialDocCount) throws Exception {
    protected void assertTimeout(ClusterHealthRequestBuilder requestBuilder) {
        assertTimeout(
        internalCluster().stopRandomDataNode();
        ensureGreen();
        flush();
        }
                .setTimeout(healthTimeout)
            .field("recovery_source_enabled")
            bulkRequest.add(
            assertBusy(() -> { verifyDerivedSourceWithMultiField(finalTotalDocs1); }, 30, TimeUnit.SECONDS);
                "date_field": {
        for (int i = 0; i < 1000; i++) {
        refresh("test");
                .setWaitForNoRelocatingShards(true)
        assertTimeout(
        // Index initial documents
                .setWaitForEvents(Priority.LANGUID)
 * not use this file except in compliance with the License.
        ).get();
        }
        // Start initial cluster
            client().admin()
                  "type": "long"
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
        // closing the 3rd node
                .setWaitForGreenStatus()
                "text_field": {
                }
        internalCluster().startNode();
        logger.info("--> refreshing and checking data");
            int additionalDocs = randomIntBetween(100, 200);
                    .cluster()
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);
                assertEquals(docId, source.get("numeric_field"));
        internalCluster().stopRandomDataNode();
import org.opensearch.action.search.SearchResponse;
                  "type": "text",
                    .put("index.number_of_shards", 3)
 *
import org.opensearch.cluster.metadata.IndexMetadata;
        internalCluster().restartRandomDataNode();
        );
                .setWaitForGreenStatus()
                  "type": "keyword"
    }
            }""";
                    "boolean_field": {
        assertHitCount(client().prepareSearch("test").setSize(0).get(), docCount);
        // Add replicas
        });
                        "date_field",
        rollingRestartWithVerification(docCount);
        // Remove nodes
                .prepareHealth()
                    .setSource("text_field", "text value " + id, "multi_field", multiFieldObj)
                client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.number_of_replicas", 1))
import org.opensearch.action.bulk.BulkRequestBuilder;
        // make sure the cluster state is green, and all has been recovered
        for (int i = 0; i < 10; i++) {
                .setId(Long.toString(i))
            client().admin()
        for (RecoveryState recoveryState : recoveryResponse.shardRecoveryStates().get("test")) {
            bulkRequest.add(
                .setWaitForNodes("3")
                       "type": "boolean"
        }
        }
        // make sure the cluster state is green, and all has been recovered
                BulkResponse response = bulkRequest.execute().actionGet();
                .setWaitForNodes("1")
                updateThread.join(TimeValue.timeValueSeconds(5).millis());
        internalCluster().stopRandomDataNode();
 * Modifications Copyright OpenSearch Contributors. See
            multiFieldObj.put("boolean_field", id % 2 == 0);
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
    public void testNoRebalanceOnRollingRestart() throws Exception {
public class FullRollingRestartIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        return replicationSettings;
        final String healthTimeout = "1m";
 *
        ensureGreen();
            // Start additional nodes
        internalCluster().stopRandomDataNode();
                    .put("index.refresh_interval", "1s")
        for (int i = 0; i < docCount; i++) {
                    }
        logger.info("--> performed {} successful updates during rolling restart", successfulUpdates.get());
        internalCluster().startDataOnlyNodes(3);
        assertAcked(
                .actionGet();
            .field("enabled")
        prepareCreate("test").setSettings(
                .setTimeout(healthTimeout)
                }
                try {
        internalCluster().stopRandomDataNode();
        for (int i = 0; i < 10; i++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        });
    }
                ensureGreen(TimeValue.timeValueSeconds(60));
import java.util.Collection;
                    .setWaitForNodes(String.valueOf(currentNodes))
        internalCluster().startNode();
            // Start updates after cluster is stable
                    .put("index.number_of_shards", 3)
            prepareCreate(
                        Thread.sleep(50); // Larger delay between updates
        }
            updateDocLatch.await();
                .setTimeout(healthTimeout)
                .setId(Long.toString(i))
                .prepareHealth()
        logger.info("Create index response is : {}", response);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                .setWaitForNoRelocatingShards(true)
                .setWaitForNodes("5")
        try {
                    .put("index.number_of_shards", 2)
        } finally {
                  "store": true
    }
                    .put("index.derived_source.enabled", true)
    }
            );
                .prepareHealth()
            );
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMinutes(1))
        }
        );
                .execute()
                assertNotNull(source.get("date_field"));
        }
        logger.info("--> one node left, verifying data");
            client().admin()
        internalCluster().startNode();
            BulkResponse response = bulkRequest.execute().actionGet();
        for (int i = 1000; i < 2000; i++) {
            currentNodes--;
                assertFalse(((String) source.get("last_updated")).isEmpty());
                .setWaitForGreenStatus()
    @ParametersFactory
            for (SearchHit hit : response.getHits()) {
    }
        BulkRequestBuilder bulkRequest = client().prepareBulk();
                .setTimeout(healthTimeout)
        assertTimeout(
        flush();
                .setWaitForNoRelocatingShards(true)
                .setTimeout(healthTimeout)
                .execute()
                .setWaitForNoRelocatingShards(true)
            internalCluster().stopRandomDataNode();
    public void testDerivedSourceWithMultiFieldsRollingRestart() throws Exception {
                stop.set(true);
        // make sure the cluster state is green, and all has been recovered
                "test",
                .setWaitForYellowStatus()
        refreshAndWaitForReplication();
        );
            totalDocs += additionalDocs;
        // Verify initial document count
                .setWaitForGreenStatus()
            client().admin()
                Settings.builder()
        final AtomicInteger successfulUpdates = new AtomicInteger(0);
import org.opensearch.core.xcontent.XContentBuilder;
            assertHitCount(response, expectedDocs);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        // Add nodes
        internalCluster().startNode();
import java.util.concurrent.atomic.AtomicInteger;
}
                "counter": {
                        System.currentTimeMillis()
                .prepareHealth()
        );
        }
        for (int i = 0; i < 1000; i++) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
/*
                .prepareHealth()
                .setSource(MapBuilder.<String, Object>newMapBuilder().put("test", "value" + i).map())
                },
          We have a fix for this to wait until we have allocated unallocated shards now so this shouldn't happen.
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                String id = hit.getId();
    private void verifyDerivedSource(int expectedDocs) throws Exception {
                .setWaitForNodes("4")
            logger.info("cluster health request timed out:\n{}", clusterHealth);
            }""";
                .cluster()
          to relocating to the restarting node since all had 2 shards and now one node has nothing allocated.
        logger.info("--> starting rolling restart with {} initial docs", docCount);
                "last_updated": {
                // Stop updates temporarily during node restart
        );
        int docCount = randomIntBetween(500, 1000);
                int docId = Integer.parseInt(id);
        refreshAndWaitForReplication();
        );
                .setWaitForNoRelocatingShards(true)
            fail("cluster health request timed out");
        for (int i = 0; i < docCount; i++) {
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);
                .setWaitForNoRelocatingShards(true)
                "keyword_field": {
            // Verify document count and contents
                .setWaitForNoRelocatingShards(true)
              "properties": {
            client().prepareIndex("test")
                    .cluster()
        }
        assertTimeout(
    }
                .setWaitForNodes("3")
                    logger.warn("Error in background update thread", e);
                  "type": "text",
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < docCount; i++) {
                },
        internalCluster().startNode();
                    .setWaitForNodes(String.valueOf(currentNodes))
        // make sure the cluster state is green, and all has been recovered
        // Search with preference to primary to ensure consistency
    public void testDerivedSourceRollingRestart() throws Exception {
                    .put("index.refresh_interval", "1s") // Ensure regular refreshes
        // Start rolling restart with verification
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTimeout(
                .setTimeout(healthTimeout)
        for (int i = 0; i < 1; i++) {
            client().prepareIndex("test")
        if (bulkRequest.numberOfActions() > 0) {
        assertTimeout(
                        "keyword_field",
        final Thread updateThread = new Thread(() -> {
                    .prepareHealth()
            client().admin()
            if (i % 100 == 0) {
/*
            .value(false)
        }
        for (int i = 0; i < 10; i++) {
                .setId(Long.toString(i))
        );
                .setWaitForGreenStatus()
            );
                .cluster()
            for (SearchHit hit : response.getHits()) {
                .setSource(MapBuilder.<String, Object>newMapBuilder().put("test", "value" + i).map())
    public FullRollingRestartIT(Settings settings) {
        // Rolling restart
                stop.set(false);
            client().admin()
                .setWaitForNodes("4")
        assertBusy(() -> {
                        successfulUpdates.incrementAndGet();
        // Start concurrent updates during rolling restart
        }
            {
            while (stop.get() == false) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
              }
            SearchResponse response = client().prepareSearch("test").setSize(expectedDocs).addSort("numeric_field", SortOrder.ASC).get();
                assertNotNull("counter missing for doc " + id, source.get("counter"));
            Map<String, Object> multiField = (Map<String, Object>) source.get("multi_field");
                assertEquals("text value " + id, source.get("text_field"));
            BulkResponse response = bulkRequest.execute().actionGet();
        internalCluster().stopRandomDataNode();
                .cluster()
                internalCluster().restartNode(node);
        internalCluster().stopRandomDataNode();
            .get();
                    .setId(String.valueOf(i))
import org.opensearch.cluster.routing.UnassignedInfo;
                    }
            int id = startingId + i;
            }
                        updateDocLatch.countDown();
 * KIND, either express or implied.  See the License for the
    }
                        client().prepareUpdate("test", String.valueOf(i))
            }
            .endObject()
    private void verifyDerivedSourceWithMultiField(int expectedDocs) {
                    for (int i = 0; i < docCount && !stop.get(); i++) {
            );
        refresh("test");
        internalCluster().startNode();
                .addSort("last_updated", SortOrder.DESC) // Sort by version to ensure we see latest updates
                assertEquals("key_" + docId, source.get("keyword_field"));
                Settings.builder()
                    .put("index.derived_source.enabled", true)
 * specific language governing permissions and limitations
            assertTimeout(
                .execute()
            // Add more documents
            // Ensure all documents are visible
                .setWaitForNodes("3")
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.number_of_replicas", 1))
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < 2; i++) {
            }
        assertHitCount(response, expectedDocs);
            verifyDerivedSource(initialDocCount);
/*
            assertBusy(() -> { verifyDerivedSourceWithMultiField(finalTotalDocs); }, 30, TimeUnit.SECONDS);
            bulkRequest.add(
            int currentId = ((Number) multiField.get("long_field")).intValue();
            int finalTotalDocs1 = totalDocs;
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);
                "test",
import org.opensearch.common.settings.Settings;
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
            assertTrue(
                assertEquals("text value " + docId, source.get("text_field"));
                .setWaitForEvents(Priority.LANGUID)
                .setWaitForNoRelocatingShards(true)
        logger.info("--> starting rolling restart with concurrent updates");
                .cluster()
                Map<String, Object> source = hit.getSourceAsMap();
        assertTimeout(
                    .setSource("text_field", "text value " + i, "counter", 0, "last_updated", System.currentTimeMillis(), "version", 0)
        refreshAndWaitForReplication();
                "text_field": {
                    .setWaitForEvents(Priority.LANGUID)
                  "type": "long"
                .cluster()
                .setWaitForEvents(Priority.LANGUID)
                verifyDerivedSourceWithUpdates(docCount);
                .setWaitForEvents(Priority.LANGUID)
                .setWaitForEvents(Priority.LANGUID)
        }, 30, TimeUnit.SECONDS);
    private void bulkIndexDocuments(int docCount) throws Exception {
        assertHitCount(client().prepareSearch("test").setSize(0).get(), docCount);
        for (int i = 0; i < 10; i++) {
          Yet we have 6 shards 0 replica so that means if the restarting node comes back both other nodes are subject
            Settings.builder()
                .prepareHealth()
        XContentBuilder builder = XContentFactory.jsonBuilder()
          We start 3 nodes and a dedicated cluster-manager. Restart on of the data-nodes and ensure that we got no relocations.
                .setWaitForEvents(Priority.LANGUID)
            );
        );
                  "store": true
            // Clean shutdown
            prepareCreate(
                .setTimeout(healthTimeout)
              }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            ).setMapping(mapping)
        flush("test");
                .setWaitForNodes("2")
            );
                        "numeric_field",
                .cluster()
                      "type": "long"
                .setWaitForGreenStatus()
        for (String node : internalCluster().getNodeNames()) {
                    .setId(String.valueOf(id))
        refreshAndWaitForReplication();
            {
    private void verifyDerivedSourceWithUpdates(int expectedDocs) throws Exception {
                .setTimeout(healthTimeout)
            .setPreference("_primary")
            .addSort("multi_field.long_field", SortOrder.ASC)
                            .actionGet(TimeValue.timeValueSeconds(5));
                .setSource(MapBuilder.<String, Object>newMapBuilder().put("test", "value" + i).map())
                }
        // make sure the cluster state is yellow, and all has been recovered
                bulkRequest = client().prepareBulk();
            .startObject()
 *
                .setWaitForEvents(Priority.LANGUID)
        logger.info("--> add two more nodes");
                "test",
 */
            .endObject();
                .setId(Long.toString(i))
            Map<String, Object> multiFieldObj = new HashMap<>();
              "properties": {
        }
import org.opensearch.indices.recovery.RecoveryState;
    }
    }
                Settings.builder()
    public static Collection<Object[]> parameters() {
            client().admin()
                .actionGet();
                .setTimeout(healthTimeout)
                assertEquals("text value " + id, source.get("text_field"));
                Thread.sleep(1000); // Wait for in-flight operations to complete
    public void testDerivedSourceWithConcurrentUpdatesRollingRestart() throws Exception {
        );
            // Wait for fix number of updates to go through
            verifyDerivedSource(initialDocCount);
                recoveryState.getRecoverySource().getType() != RecoverySource.Type.PEER || recoveryState.getPrimary() == false
            ).setMapping(mapping)
            ensureGreen("test");
                  "store": true
    @Override
import org.opensearch.search.sort.SortOrder;
        }
                            .setRetryOnConflict(3)
