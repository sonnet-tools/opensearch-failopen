        final String healthTimeout = "1m";
        // Start initial node
        refresh();
        // Initial indexing
                .setTimeout(healthTimeout)  
                .addSort("last_updated", SortOrder.DESC) // Sort by version to ensure we see latest updates  
 * The OpenSearch Contributors require contributions made to  
        // Add replicas before starting new nodes  
                .setSource(MapBuilder.<String, Object>newMapBuilder().put("test", "value" + i).map())  
            client().prepareIndex("test")
                // Verify data consistency
            assertHitCount(response, expectedDocs);  
        // Ensure documents are visible
        flush();
package org.opensearch.recovery;
                    .setWaitForNodes(String.valueOf(currentNodes))
                    .prepareHealth()
                    .put("index.number_of_shards", 3)  
import java.util.Collection;
        refreshAndWaitForReplication();
        // make sure the cluster state is green, and all has been recovered  
        bulkIndexMultiFieldDocuments(docCount, 0);  
        assertTimeout(
            SearchResponse response = client().prepareSearch("test").setSize(expectedDocs).addSort("numeric_field", SortOrder.ASC).get();
                  "type": "keyword"
            int finalTotalDocs1 = totalDocs;
        for (int i = 0; i < 10; i++) {  
            if (i % 100 == 0) {  
                  }
                .cluster()
                assertEquals("text value " + docId, source.get("text_field"));
        // see https://github.com/elastic/elasticsearch/issues/14387  
        BulkRequestBuilder bulkRequest = client().prepareBulk();
    private void rollingRestartWithVerification(int initialDocCount) throws Exception {  
    public static Collection<Object[]> parameters() {
        final CountDownLatch updateDocLatch = new CountDownLatch(docCount / 3);
                .setWaitForGreenStatus()  
        }
         */
            if (i % 100 == 0) {  
            assertTimeout(
                .setWaitForGreenStatus()
                recoveryState.getRecoverySource().getType() != RecoverySource.Type.PEER || recoveryState.getPrimary() == false
        }
                .setId(Long.toString(i))  
        for (RecoveryState recoveryState : recoveryResponse.shardRecoveryStates().get("test")) {
 * under the License.  
                      "type": "keyword"
                BulkResponse response = bulkRequest.execute().actionGet();  
                ensureGreen(TimeValue.timeValueSeconds(60));  
        );  
            BulkResponse response = bulkRequest.execute().actionGet();  
                .setTimeout(healthTimeout)  
        internalCluster().startNode();
                .setWaitForEvents(Priority.LANGUID)
                        Thread.sleep(50); // Larger delay between updates  
        return replicationSettings;
                .prepareHealth()  
        for (int i = 0; i < docCount; i++) {
                },
                .execute()
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);  
                // Resume updates  
        internalCluster().startNode();  
          We have a fix for this to wait until we have allocated unallocated shards now so this shouldn't happen.
        rollingRestartWithVerification(docCount);  
        );  
            );
        for (SearchHit hit : response.getHits()) {
        assertHitCount(client().prepareSearch("test").setSize(0).get(), docCount);
                "text_field": {  
        assertHitCount(response, expectedDocs);
            updateThread.start();
            ensureGreen("test");
                            .execute()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ).setMapping(mapping)
            BulkResponse response = bulkRequest.execute().actionGet();
        int totalDocs = docCount;  
                updateThread.join(TimeValue.timeValueSeconds(5).millis());
                    .put("index.number_of_replicas", 0)
        internalCluster().stopRandomDataNode();
    }  
        refresh("test");  
                },  
                client().admin()
        }  
            if (i % 100 == 0) {
        }
import org.opensearch.common.settings.Settings;
                .actionGet();
                .setWaitForNodes("2")
            ).setMapping(mapping)
            assertTrue(  
            .value(false)
    }
            client().prepareIndex("test")
        }
    }  
                  "type": "date"
            verifyDerivedSource(initialDocCount);
                    .setWaitForEvents(Priority.LANGUID)
                .setWaitForEvents(Priority.LANGUID)
    public FullRollingRestartIT(Settings settings) {
        logger.info("--> one node left, verifying data");
        // Rolling restart
            assertHitCount(response, expectedDocs);
                "version": {
        );
              }
                  "type": "text",
        );
                .setWaitForNodes("3")  
            );
        // make sure the cluster state is green, and all has been recovered
            stop.set(true);  
        prepareCreate("test").setSettings(  
                    logger.warn("Error in background update thread", e);  
            if (updateThread.isAlive()) {
import java.util.concurrent.CountDownLatch;
        ClusterHealthResponse clusterHealth = requestBuilder.get();  
 *
                } catch (Exception e) {
        internalCluster().startNode();
                assertNotNull(source.get("date_field"));
        );
        refreshAndWaitForReplication();
                .setTimeout(healthTimeout)
            .endObject();
                .execute()
                "date_field": {
        );  
                .setWaitForGreenStatus()  
        }, 30, TimeUnit.SECONDS);  
                Settings.builder()
                .setWaitForNoRelocatingShards(true)  
                .setWaitForNoRelocatingShards(true)
import org.opensearch.common.xcontent.XContentFactory;
 * this work for additional information regarding copyright
                        "date_field",
import java.util.Map;  
                .setWaitForEvents(Priority.LANGUID)
                .setWaitForNoRelocatingShards(true)
        // Add replicas
        }  
        }
        // now start shutting nodes down  
            SearchResponse response = client().prepareSearch("test")
            client().admin()
                .execute()
                .setWaitForNodes("3")
        );  
        }
        internalCluster().stopRandomDataNode();
            .setPreference("_primary")  
import org.opensearch.indices.recovery.RecoveryState;  
            updateThread.join(TimeValue.timeValueSeconds(30).millis());
                assertEquals(docId, source.get("numeric_field"));  
                  "type": "long"
                },  
                .setSize(expectedDocs)
        // make sure the cluster state is green, and all has been recovered  
        }
    }
        }
            bulkRequest.execute().actionGet();  
            multiFieldObj.put("keyword_field", "keyword_" + id);
        // Search with preference to primary to ensure consistency  
        // Start initial node
 * specific language governing permissions and limitations
                    .setId(String.valueOf(i))
            assertFalse(response.hasFailures());
        );
 * license agreements. See the NOTICE file distributed with
                .setWaitForNoRelocatingShards(true)
                .setWaitForGreenStatus()
                },  
    }
            bulkRequest.add(  
                .setSource(MapBuilder.<String, Object>newMapBuilder().put("test", "value" + i).map())
            .field("recovery_source_enabled")
        internalCluster().startNode();
                .setSource(MapBuilder.<String, Object>newMapBuilder().put("test", "value" + i).map())
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
                .setTimeout(healthTimeout)
                "test",
        if (clusterHealth.isTimedOut()) {
            internalCluster().startNode();
        for (int i = 0; i < 1; i++) {
        internalCluster().stopRandomDataNode();
        assertTimeout(
        }
    private void bulkIndexMultiFieldDocuments(int docCount, int startingId) throws Exception {
                Map<String, Object> source = hit.getSourceAsMap();
            }""";
        // now start shutting nodes down  
            prepareCreate(  
                bulkRequest = client().prepareBulk();
        logger.info("--> one node left, verifying data");
                .execute()
        internalCluster().startNode();
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;  
            for (SearchHit hit : response.getHits()) {
        } finally {
        createIndex("test");
                    .put("index.derived_source.enabled", true)  
            client().admin()
            multiFieldObj.put("boolean_field", id % 2 == 0);  
                .setWaitForGreenStatus()  
            // Verify after each node restart
    public void testFullRollingRestart_withNoRecoveryPayloadAndSource() throws Exception {  
import java.util.concurrent.atomic.AtomicBoolean;  
                assertEquals("text value " + id, source.get("text_field"));  
                .setSource(MapBuilder.<String, Object>newMapBuilder().put("test", "value" + i).map())  
    public void testDerivedSourceRollingRestart() throws Exception {
        }
                    .put("index.number_of_shards", 3)
        try {
        logger.info("Create index response is : {}", response);  
                  "store": true
                    .put("index.number_of_replicas", 0)
 * the Apache License, Version 2.0 (the "License"); you may
        assertTimeout(
            int additionalDocs = randomIntBetween(100, 200);
            internalCluster().startNode();  
                },  
                .prepareHealth()
            // Clean shutdown
        client().admin().cluster().prepareState().get().getState();
                client().prepareIndex("test")
                .cluster()  
                    }
                }  
        if (bulkRequest.numberOfActions() > 0) {  
        for (int i = 0; i < docCount; i++) {
        // ensuring all docs are committed to file system
    }  
            client().prepareIndex("test")
        ensureGreen();
                .setWaitForGreenStatus()
                .setWaitForNoRelocatingShards(true)
              }  
                    .setSource("text_field", "text value " + id, "multi_field", multiFieldObj)
                        "text value " + i,
    private void verifyDerivedSource(int expectedDocs) throws Exception {
            // Rolling restart of all nodes
                "numeric_field": {
        final AtomicBoolean stop = new AtomicBoolean(false);  
                Map<String, Object> source = hit.getSourceAsMap();  
        assertTimeout(  
                  "properties": {  
            Map<String, Object> multiField = (Map<String, Object>) source.get("multi_field");  
          Yet we have 6 shards 0 replica so that means if the restarting node comes back both other nodes are subject
 * GitHub history for details.
        internalCluster().stopRandomDataNode();
                String id = hit.getId();
        internalCluster().startNode();
                .setId(Long.toString(i))
}
                    .setWaitForNoRelocatingShards(true)
                .prepareHealth()
        internalCluster().stopRandomDataNode();
    }  
        flush("test");  
            client().admin()
        for (RecoveryState recoveryState : recoveryResponse.shardRecoveryStates().get("test")) {
                .setWaitForNoRelocatingShards(true)  
    }
                .setWaitForGreenStatus()
                    }  
                .cluster()
    private void verifyDerivedSourceWithMultiField(int expectedDocs) {
            bulkRequest.add(
import org.opensearch.core.xcontent.XContentBuilder;
 *
            {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")  
            bulkRequest.add(  
            client().admin()
                client().admin()
            assertEquals("keyword_" + currentId, multiField.get("keyword_field"));
                assertEquals(counter == 0 ? 0 : 1, source.get("version"));
            }
import org.opensearch.cluster.metadata.IndexMetadata;
            multiFieldObj.put("long_field", id);
        assertTimeout(  
                .setWaitForNodes("1")
        internalCluster().stopRandomDataNode();
        );  
                .setWaitForNodes("1")
            client().prepareIndex("test")  
 */  
 * this file be licensed under the Apache-2.0 license or a
        BulkRequestBuilder bulkRequest = client().prepareBulk();  
                  "type": "date"
            bulkIndexMultiFieldDocuments(additionalDocs, totalDocs);  
import org.opensearch.common.unit.TimeValue;  
                .get();
    protected void assertTimeout(ClusterHealthRequestBuilder requestBuilder) {
            verifyDerivedSource(initialDocCount);
        for (int i = 1000; i < 2000; i++) {  
            client().admin()
        for (int i = 0; i < 1000; i++) {
        // make sure the cluster state is green, and all has been recovered  
        // Add nodes  
 * You may obtain a copy of the License at  
        }
            totalDocs += additionalDocs;
        refresh("test");
/*  
                "multi_field": {
                .setWaitForEvents(Priority.LANGUID)  
            // Start additional nodes
 * KIND, either express or implied.  See the License for the
                    for (int i = 0; i < docCount && !stop.get(); i++) {
        internalCluster().startNode();  
        });  
                .actionGet();
        // make sure the cluster state is green, and all has been recovered
        logger.info("--> add two more nodes");
        SearchResponse response = client().prepareSearch("test")
        assertAcked(
import java.util.concurrent.atomic.AtomicInteger;
                // Verify all required fields are present
                "last_updated": {
        assertTimeout(  
                        System.currentTimeMillis()
        // make sure the cluster state is yellow, and all has been recovered
                    "boolean_field": {
                "keyword_field": {
                .setId(Long.toString(i))
        ensureGreen();
                  "type": "long"
                .setWaitForNoRelocatingShards(true)
        int currentNodes = 1;
            }
                  "type": "text",
                .setWaitForEvents(Priority.LANGUID)  
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
                .setWaitForYellowStatus()
        );
        // closing the 3rd node  
import org.opensearch.cluster.ClusterState;
                client().prepareIndex("test")  
        assertAcked(
                       "type": "boolean"
                .prepareHealth()  
 * ownership. Elasticsearch licenses this file to you under  
            );  
        // Index test data
        XContentBuilder builder = XContentFactory.jsonBuilder()
        flush("test");  
    private void bulkIndexDocuments(int docCount) throws Exception {  
            internalCluster().stopRandomDataNode();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
/*
    @Override
        ensureGreen();  
        assertTimeout(  
import org.opensearch.cluster.routing.RecoverySource;  
            assertTimeout(
                .setWaitForEvents(Priority.LANGUID)
    }  
 * software distributed under the License is distributed on an
    @ParametersFactory  
        internalCluster().startNode();
        internalCluster().startDataOnlyNodes(3);
                .cluster()
                BulkResponse response = bulkRequest.execute().actionGet();
                        "numeric_field",
        ensureGreen();
              "properties": {
 *  
        });  
                      "type": "long"
            ).setMapping(mapping)
            Map<String, Object> multiFieldObj = new HashMap<>();  
        );
        final AtomicInteger successfulUpdates = new AtomicInteger(0);
                .setWaitForGreenStatus()  
            int currentId = ((Number) multiField.get("long_field")).intValue();
        assertTimeout(  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        internalCluster().restartRandomDataNode();
                Settings.builder()  
        logger.info("--> performed {} successful updates during rolling restart", successfulUpdates.get());
                .prepareHealth()
                bulkRequest.execute().actionGet();
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .setWaitForNodes(String.valueOf(currentNodes))
            }  
        internalCluster().startNode();
        }
                "counter": {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "6")
            .endObject()  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        logger.info("--> refreshing and checking data");  
              "properties": {
        assertBusy(() -> {
                .cluster()
                    "keyword_field": {
                .setWaitForNoRelocatingShards(true)
            assertEquals("text value " + currentId, source.get("text_field"));  
        logger.info("--> refreshing and checking data");  
                "text_field": {  
        for (int i = 0; i < docCount; i++) {
        logger.info("--> now start adding nodes");
        );  
                assertEquals("text value " + id, source.get("text_field"));
        CreateIndexResponse response = prepareCreate("test").setMapping(builder).get();
                .prepareHealth()  
 * Modifications Copyright OpenSearch Contributors. See
            }
    }  
        internalCluster().startNode();
                    // Update documents sequentially to avoid conflicts  
            .startObject()  
                assertEquals("key_" + docId, source.get("keyword_field"));
            assertAcked(
            .startObject("_source")
        );  
                        "text_field",
                .cluster()
            assertEquals(currentId % 2 == 0, multiField.get("boolean_field"));
                    "long_field": {
        // Verify initial document count  
import java.util.concurrent.TimeUnit;
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
            client().admin()
                stop.set(false);
                "relocated from: " + recoveryState.getSourceNode() + " to: " + recoveryState.getTargetNode() + "\n" + state,
          to relocating to the restarting node since all had 2 shards and now one node has nothing allocated.  
        // Verify initial document count  
            Map<String, Object> source = hit.getSourceAsMap();
import org.opensearch.common.collect.MapBuilder;
                    .setTimeout(healthTimeout)  
                    .put("index.number_of_shards", 2)
        }
        int docCount = randomIntBetween(100, 200); // Reduced count for stability  
            internalCluster().startNode();
            int finalTotalDocs = totalDocs;
            client().admin()
    }
import org.opensearch.action.search.SearchResponse;  
            refresh("test");
    }
            // Ensure all documents are visible  
                .setWaitForNoRelocatingShards(true)
        assertTimeout(
        refreshAndWaitForReplication();
                .actionGet();  
                .setId(Long.toString(i))  
        internalCluster().stopRandomDataNode();
        );
            // Add replicas  
                .setTimeout(healthTimeout)
        logger.info("--> stopped two nodes, verifying data");  
import org.opensearch.common.SuppressForbidden;  
            currentNodes++;  
                        "keyword_field",  
            assertTrue("Documents should be in order", currentId > previousId);  
            }
                .setWaitForNodes("2")
        for (int i = 0; i < 10; i++) {
        String mapping = """  
            .setSize(expectedDocs)
        ).get();
                    .setTimeout(healthTimeout)  
                Thread.sleep(1000); // Wait for in-flight operations to complete  
            client().admin()  
                Settings.builder()  
                verifyDerivedSourceWithUpdates(docCount);
                            .actionGet(TimeValue.timeValueSeconds(5));  
                .setWaitForEvents(Priority.LANGUID)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries("test").get();
            client().admin()  
            assertBusy(() -> { verifyDerivedSourceWithMultiField(finalTotalDocs); }, 30, TimeUnit.SECONDS);  
        bulkIndexDocuments(docCount);  
            }  
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.number_of_replicas", 1))
            assertBusy(() -> { verifyDerivedSourceWithMultiField(finalTotalDocs1); }, 30, TimeUnit.SECONDS);  
        String mapping = """
            while (stop.get() == false) {
import org.opensearch.action.bulk.BulkRequestBuilder;
        for (int i = 0; i < 10; i++) {
                .setTimeout(healthTimeout)  
/*  
        for (int i = 0; i < 10; i++) {
                        successfulUpdates.incrementAndGet();
        }  
                    .setWaitForEvents(Priority.LANGUID)
                assertNotNull("counter missing for doc " + id, source.get("counter"));
                stop.set(true);
        if (bulkRequest.numberOfActions() > 0) {
            );  
public class FullRollingRestartIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
        refreshAndWaitForReplication();
                },  
                .setWaitForEvents(Priority.LANGUID)
import org.opensearch.action.admin.cluster.health.ClusterHealthRequestBuilder;  
        );  
                .setWaitForNoRelocatingShards(true)
            int id = startingId + i;
        }
                    .put("index.derived_source.enabled", true)  
                try {
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);  
            }""";
        int previousId = -1;  
                .execute()  
    @SuppressForbidden(reason = "Need to fix: https://github.com/opensearch-project/OpenSearch/issues/20064")
                .cluster()  
                    .setSource("text_field", "text value " + i, "counter", 0, "last_updated", System.currentTimeMillis(), "version", 0)  
                client().prepareIndex("test")
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
    }  
                .cluster()
                    .cluster()  
        logger.info("--> starting rolling restart with concurrent updates");
            client().prepareIndex("test")
                .setWaitForNoRelocatingShards(true)
                            .setRetryOnConflict(3)  
        // Add nodes and additional documents
                .setWaitForNodes("4")
        }  
                .actionGet();
                .setSource(MapBuilder.<String, Object>newMapBuilder().put("test", "value" + i).map())
        assertTimeout(
                .cluster()
 * SPDX-License-Identifier: Apache-2.0
                .cluster()
          We start 3 nodes and a dedicated cluster-manager. Restart on of the data-nodes and ensure that we got no relocations.
    }
    public void testFullRollingRestart() throws Exception {  
                .setWaitForGreenStatus()  
                .setWaitForNoRelocatingShards(true)
                  "store": true  
            {
        assertAcked(  
                .setTimeout(healthTimeout)
            client().admin()
            );  
                    .setId(String.valueOf(id))
        // make sure the cluster state is green, and all has been recovered  
                }  
                },  
                .setWaitForNodes("5")  
                Integer counter = (Integer) source.get("counter");  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                .setTimeout(healthTimeout)
                bulkRequest = client().prepareBulk();  
        }
        internalCluster().stopRandomDataNode();
                .setWaitForYellowStatus()
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);
            assertTrue(
                refresh("test");  
        // Start rolling restart with verification
                .setWaitForEvents(Priority.LANGUID)
        logger.info("--> add two more nodes");
            assertFalse(response.hasFailures());
            .addSort("multi_field.long_field", SortOrder.ASC)
                .setTimeout(healthTimeout)  
        final String healthTimeout = "1m";
                    .setWaitForYellowStatus()
                    .setId(String.valueOf(i))
                // Stop updates temporarily during node restart
        for (int i = 0; i < 2; i++) {
        int docCount = randomIntBetween(1000, 2000);
    public void testDerivedSourceWithConcurrentUpdatesRollingRestart() throws Exception {
        logger.info("--> starting rolling restart with {} initial docs", docCount);
        return 1;  
        String mapping = """  
            for (String node : internalCluster().getNodeNames()) {  
                    .prepareHealth()
            prepareCreate(
                    },  
            .get();
                .actionGet();  
            .value(false)  
        );
            prepareCreate(
        internalCluster().startNode();  
        if (bulkRequest.numberOfActions() > 0) {
                            .setDoc("counter", successfulUpdates.get() + 1, "last_updated", System.currentTimeMillis(), "version", 1)
            {
                  "type": "long"
                  "store": true
        verifyDerivedSourceWithUpdates(docCount);
        int docCount = randomIntBetween(500, 1000);
import org.opensearch.action.bulk.BulkResponse;
                .setTimeout(healthTimeout)
                .setWaitForNodes("5")  
            for (SearchHit hit : response.getHits()) {
                String id = hit.getId();  
                bulkRequest = client().prepareBulk();
                }
                recoveryState.getRecoverySource().getType() != RecoverySource.Type.PEER || recoveryState.getPrimary() == false
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
        final Thread updateThread = new Thread(() -> {  
        /*  
                .setTimeout(healthTimeout)
                .cluster()  
            // Start updates after cluster is stable  
        for (int i = 0; i < 10; i++) {  
        super(settings);  
        // closing the 3rd node  
                        "key_" + i,
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
        // Start initial cluster  
            // Add more documents
            client().admin()
                .prepareHealth()  
        assertBusy(() -> {  
        assertAcked(  
import java.util.HashMap;
        );
import org.opensearch.search.SearchHit;
            currentNodes--;  
                "test",
 * not use this file except in compliance with the License.
        flush();
                    .cluster()  
            flush("test");
            // Verify document count and contents
                .setWaitForGreenStatus()  
                        i,  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);  
        for (int i = 0; i < 2; i++) {
                // Verify text_field maintains original value  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
    public void testNoRebalanceOnRollingRestart() throws Exception {
            );  
                .prepareHealth()
        }
                .setWaitForNodes("3")
        // make sure the cluster state is green, and all has been recovered
                .setWaitForEvents(Priority.LANGUID)
                .prepareHealth()  
              }
 * compatible open source license.
              "properties": {  
            .field("enabled")
            );
            ensureGreen("test");
        recoveryResponse = client().admin().indices().prepareRecoveries("test").get();  
        // Index initial documents
            }""";
import org.opensearch.common.Priority;
                .prepareHealth()
        // Start concurrent updates during rolling restart  
                .setId(Long.toString(i))
                    .put("index.refresh_interval", "1s")
            // Wait for fix number of updates to go through
        assertTimeout(  
                .prepareHealth()  
        ensureGreen();
                        client().prepareUpdate("test", String.valueOf(i))
        }  
                  "type": "text",
            client().admin()
        assertHitCount(client().prepareSearch("test").setSize(0).get(), docCount);
        }
        final String healthTimeout = "1m";
                    .setSource(  
        assertTimeout(
                internalCluster().restartNode(node);
        refresh("test");
        internalCluster().startNode();  
                assertFalse(((String) source.get("last_updated")).isEmpty());
    public void testDerivedSourceWithMultiFieldsRollingRestart() throws Exception {  
                .setTimeout(healthTimeout)
        }
                    },  
                assertFalse(response.hasFailures());
        refreshAndWaitForReplication();
            previousId = currentId;
    }
                client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.number_of_replicas", 1))
                    )  
        // make sure the cluster state is green, and all has been recovered
    private void verifyDerivedSourceWithUpdates(int expectedDocs) throws Exception {
                "text_field": {
 */
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 2))  
        }
                "relocated from: " + recoveryState.getSourceNode() + " to: " + recoveryState.getTargetNode() + "-- \nbefore: \n" + state,  
            updateDocLatch.await();  
        BulkRequestBuilder bulkRequest = client().prepareBulk();
        refreshAndWaitForReplication();
                        updateDocLatch.countDown();
        for (int i = 1000; i < 2000; i++) {
            );  
        }
                .cluster()  
        for (int i = 0; i < 1000; i++) {  
                .setWaitForEvents(Priority.LANGUID)
            }
            }
            fail("cluster health request timed out");  
                    .put("index.number_of_replicas", 0)
                assertFalse(response.hasFailures());
        internalCluster().startNode();
import org.opensearch.search.sort.SortOrder;
                    .put("index.derived_source.enabled", true)
                "test",
        // make sure the cluster state is green, and all has been recovered
                updateThread.interrupt();  
        // make sure the cluster state is green, and all has been recovered
            internalCluster().restartNode(node);
                }
                .setWaitForNodes("4")
        for (String node : internalCluster().getNodeNames()) {  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);  
        for (int i = 0; i < 10; i++) {
        logger.info("--> stopped two nodes, verifying data");  
                int docId = Integer.parseInt(id);
        // Remove nodes  
        for (int i = 0; i < 100; i++) {
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMinutes(1))
        assertAcked(
                .setWaitForNodes("3")  
        flush("test");
        ensureGreen("test");  
        refresh();  
            logger.info("cluster health request timed out:\n{}", clusterHealth);
        // make sure the cluster state is yellow, and all has been recovered
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2000L);
            Settings.builder()
 * Licensed to Elasticsearch under one or more contributor  
                    .put("index.refresh_interval", "1s") // Ensure regular refreshes  
        }  
 * Unless required by applicable law or agreed to in writing,
    }
    protected int numberOfReplicas() {
                .setWaitForEvents(Priority.LANGUID)
 */  
                .prepareHealth()
import org.opensearch.cluster.routing.UnassignedInfo;
        logger.info("--> now start adding nodes");
