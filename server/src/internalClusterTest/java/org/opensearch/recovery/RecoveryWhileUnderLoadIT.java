                1,
        final int numDocs = scaledRandomIntBetween(200, 9999);
                        .setQuery(matchAllQuery())
        );
                    .setId(String.valueOf(i))
        logger.info("--> creating test index ...");
import org.opensearch.core.common.util.CollectionUtils;
            if (i % 2 == 0) {  
            logger.info("--> flushing the index ....");
            ensureGreen(TimeValue.timeValueMinutes(2));
    }  
                    .setWaitForEvents(Priority.LANGUID)  
                    .get();
                .addSort("id", SortOrder.ASC)
            indexer.stopAndAwaitStopped();  
        );
            extraDocs = totalNumDocs - waitFor;
            ClusterService clusterService = clusterService();
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)  
            assertAfterRefreshAndWaitForReplication();
import org.opensearch.common.Priority;  
            indexer.continueIndexing(extraDocs);  
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)  
        int numberOfShards = numberOfShards();
            logger.info("--> refreshing the index");
                .get();
                    .setSource("timestamp", "2023-01-01T01:20:30." + String.valueOf(i % 10).repeat(3) + "Z", "ip", "192.168.1." + i)  
        }
                assertNotNull(hit.getSourceAsMap());
        int extraDocs = waitFor;
            extraDocs = totalNumDocs - waitFor;
                "test",
        );  
            logger.info("--> indexing threads stopped");
        );
              "properties": {
                    .get();
                        for (ShardRouting shardRouting : state.routingTable().shardRoutingTable("test", shard)) {
            assertNoTimeout(  
                .setSource("coordinates", Geohash.stringEncode(40.0 + i, 75.0 + i) + i, "value", "fox_" + i + " in the field")
 * specific language governing permissions and limitations
                }
        final int totalNumDocs = scaledRandomIntBetween(200, 10000);
                "coordinates": {
                2,
import org.opensearch.core.index.shard.ShardId;  
                    .cluster()
    }
                assertHitCount(replicaResponse, numDocs);  
            logger.info("--> waiting for relocations ...");
                assertNotNull(hit.getSourceAsMap().get("coordinates"));
import org.opensearch.action.get.GetResponse;  
                assertFalse("An error occurred while waiting", errorOccurred);
            assertNoTimeout(  
        final int totalNumDocs = scaledRandomIntBetween(2000, 10000);
            logger.info("--> {} docs indexed", waitFor);  
            // Printing out shards and their doc count
                client().prepareIndex("test")
            client().admin().indices().prepareFlush().execute().actionGet();
                    SearchResponse searchResponse = client().prepareSearch()
                "ip": {
        assertAcked(
import java.io.IOException;
        // Create index with replica  
                Settings.builder()
                    .cluster()  
import org.opensearch.common.settings.Setting;
                    .setSource("ip", "192.168.1." + i, "timestamp", "2023-01-01T01:20:30." + String.valueOf(i % 10).repeat(3) + "Z")
                Settings.builder()
            searchResponse.getSuccessfulShards(),
                  "type": "ip"  
                    if (docShard.id() == shard) {
                    .field("name", "name_" + id)
            {  
                allowNodes("test", allowNodes);
            }
    }
        // Verify all documents on replica including those recovered from translog  
                    .addSort("value", SortOrder.ASC)
            ).setMapping(mapping)
        // Restart replica node and verify recovery
            logger.info("--> waiting for GREEN health status ...");
            client().admin().indices().prepareFlush().execute().actionGet();  
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)  
        for (int i = 0; i < sampleSize; i++) {  
                    .prepareHealth()  
import org.opensearch.core.xcontent.XContentBuilder;
            assertAfterRefreshAndWaitForReplication();
            assertHitCount(searchResponse, docCount + additionalDocs);  
        int extraDocs = waitFor;
            // now flush, just to make sure we have some data in the index, not just translog  
import org.opensearch.cluster.ClusterState;  
                    .setWaitForEvents(Priority.LANGUID)
                .setPreference("_replica")  
import org.opensearch.action.admin.indices.stats.ShardStats;
                  "type": "date"
                "value": {
import org.opensearch.action.search.SearchResponse;
                        .setSize(0)  
                    .put(SETTING_NUMBER_OF_SHARDS, numShards)  
                "name": {
            SearchResponse searchResponse = client().prepareSearch("test").setPreference("_replica").setSize(docCount).get();
            );
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
            protected XContentBuilder generateSource(long id, Random random) throws IOException {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            assertAfterRefreshAndWaitForReplication();
              "properties": {  
            // now flush, just to make sure we have some data in the index, not just translog
                    assertEquals(3, hit.getSourceAsMap().size());
                    .field("value", id)  
            prepareCreate(  
        });  
    public void testRecoverWhileUnderLoadWithReducedAllowedNodes() throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
                    .setTrackTotalHits(true)  
            logger.info("--> adding replicas ...");
            allowNodes("test", 2);
                },
            if (i % 100 == 0) {  
    public void testRecoverWhileRelocating() throws Exception {
                "test",
            }""";
        logger.info("--> creating test index ...");  
                Settings.builder()  
            {
                    }
                logger.info("--> waiting for GREEN health status ...");  
                boolean errorOccurred = false;
        int waitFor = totalNumDocs / 10;  
            indexer.continueIndexing(extraDocs);  
 * this work for additional information regarding copyright
            logger.info("--> flushing the index ....");
            logger.info("--> marking and waiting for indexing threads to stop ...");
                    docsStats.getCount(),  
            );  
            prepareCreate(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
import org.opensearch.action.admin.indices.refresh.RefreshResponse;  
                    .setWaitForNoRelocatingShards(true)
            return Collections.singletonList(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING);
                client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setTimeout("5m").setWaitForGreenStatus()
    public void testReplicaRecoveryWithDerivedSourceFromTranslog() throws Exception {  
            assertBusy(() -> {
            waitForDocs(waitFor, indexer);
                Map<String, Object> source = getResponse.getSourceAsMap();
        int numNodes = 1;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
                    .put(SETTING_NUMBER_OF_SHARDS, 1)  
        String mapping = """
        }  
            iterationResults[i] = searchResponse;
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, 2))  
            // Verify docs and derived source on replica
            IndicesStatsResponse indicesStatsResponse = client().admin().indices().prepareStats().get();  
            for (SearchHit hit : searchResponse.getHits()) {
                indexer.assertNoFailures();  
                },  
                    .setTimeout("5m")
            logger.info("--> {} docs indexed", totalNumDocs);  
            numberOfDocs  
            ).setMapping(mapping)  
                return jsonBuilder().startObject()
            indexer.assertNoFailures();  
 * the Apache License, Version 2.0 (the "License"); you may
            logger.info("iteration [{}] - shard failures: {}", iteration, Arrays.toString(searchResponse.getShardFailures()));  
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
            assertBusy(() -> {  
package org.opensearch.recovery;
        // Force flush to ensure documents are in segments  
        logger.info("--> allow 2 nodes for index [test] with replica ...");  
                String id = hit.getId();  
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)  
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            iterateAssertCount(numberOfShards, 10, indexer.getIds());
                // Verify source reconstruction on replica
            );
                                .get();
            indexer.stopAndAwaitStopped();
        ensureGreen();
                    .field("timestamp", System.currentTimeMillis())
            SearchResponse primaryResponse = client().prepareSearch("test").setPreference("_primary").setTrackTotalHits(true).get();
            logger.info("--> allow 1 nodes for index [test] ...");  
        // Index documents with immediate visibility  
            logger.info("--> waiting for GREEN health status ...");
            {
            }  
                    .setWaitForGreenStatus()
            logger.info("--> waiting for {} docs to be indexed ...", waitFor);
                    .setWaitForNoRelocatingShards(true)  
                1,
    }
                    .field("value", id)
                .setSize((int) numberOfDocs)
                    .setId(String.valueOf(i))
            indexer.stopAndAwaitStopped();
                    int id = (Integer) hit.getSourceAsMap().get("value");  
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)
                2,
            waitFor += extraDocs;
                logger.info("--> waiting for GREEN health status ...");  
                client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("number_of_replicas", 1)).get()
            logger.info("--> marking and waiting for indexing threads to stop ...");
            allowNodes("test", 4);
                    .cluster()
                  "type": "keyword"  
        waitForReplication();  
                  "type": "integer"  
                    .setWaitForEvents(Priority.LANGUID)
        String mapping = """
            logger.info("--> indexing threads stopped");
                1,  
                numNodes++;
            extraDocs = totalNumDocs - waitFor;
            logger.info("--> waiting for GREEN health status ...");
                client().admin()
            indexer.assertNoFailures();
                assertEquals(Integer.parseInt(id), source.get("value"));  
            logger.info("--> waiting for {} docs to be indexed ...", waitFor);
            waitForDocs(waitFor, indexer);
        }) {
                    "2023-01-01T01:20:30." + String.valueOf(Integer.valueOf(id) % 10).repeat(3) + "Z",
 */  
            waitForDocs(totalNumDocs, indexer);
        int numberOfShards = numberOfShards();  
            SearchResponse searchResponse = client().prepareSearch()  
                for (int i = 0; i < iterations; i++) {  
            ensureGreen(TimeValue.timeValueMinutes(5));
public class RecoveryWhileUnderLoadIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
            }
              }
        int waitFor = totalNumDocs / 10;  
                client().admin()  
    }
    private void logSearchResponse(int numberOfShards, long numberOfDocs, int iteration, SearchResponse searchResponse) {  
    private String ensureReplicaNode(String index) {  
            waitForDocs(waitFor, indexer);
                }
import org.opensearch.search.sort.SortOrder;  
            }  
            }
            logger.info("--> waiting for {} docs to be indexed ...", waitFor);
              "properties": {  
        );
            allowNodes("test", 2);
/*
@AwaitsFix(bugUrl = "flaky test - enable after fix")
            }  
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)
            indexer.stopAndAwaitStopped();
                }  
            // Verify source reconstruction for all documents
                1,
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
        // Kill replica node and index more documents  
    public void testRecoverWhileUnderLoadAllocateReplicasRelocatePrimariesTest() throws Exception {  
            if (i % 2 == 0) {  
                SearchResponse replicaResponse = client().prepareSearch("test")
        );  
            }
        final int totalNumDocs = scaledRandomIntBetween(200, 10000);
                Settings.builder()
                    assertNotNull(hit.getSourceAsMap());  
            // Verify docs on primary
                    .field("timestamp", System.currentTimeMillis())
    public RecoveryWhileUnderLoadIT(Settings settings) {
            assertAcked(
                    .setId(String.valueOf(i))
                    .setWaitForNoRelocatingShards(true)  
            logger.info("--> {} docs indexed", waitFor);
        // Custom indexer for derived source documents  
 */
        assertBusy(() -> {
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)
        }
                    .setSize(totalNumDocs)
                }  
        assertBusy(() -> {
        super(settings);  
        for (int i = docCount; i < docCount + additionalDocs; i++) {
            );
            logger.info("--> waiting for {} docs to be indexed ...", waitFor);  
            iterateAssertCount(numShards, 10, indexer.getIds());  
            logger.info("--> verifying indexed content");  
            logger.info("--> waiting for relocations ...");
                        .setTrackTotalHits(true)
                client().admin()
    @AwaitsFix(bugUrl = "Flaky test - fix before enabling")
            } else {  
            allowNodes("test", 1);
        assertAcked(
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));  
                indexer.assertNoFailures();  
    public void testReplicaRecoveryWithDerivedSourceBeforeRefresh() throws Exception {  
        if (!replicaNode.equals(clusterManagerNode)) {
                    .setSize(numDocs)
            indexer.continueIndexing(extraDocs);
                },  
            allowNodes("test", 4);
            searchResponse.getHits().getTotalHits().value(),
        }
                  "type": "date"  
                    .setSource("coordinates", Geohash.stringEncode(40.0 + i, 75.0 + i) + i, "value", "fox_" + i + " in the field")  
        for (int i = 0; i < iterations; i++) {
            .collect(Collectors.toList());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                    shardStats.getShardRouting().id(),
            // Add replicas after stopping indexing
                internalCluster().startDataOnlyNode();  
        assertAcked(
                assertEquals(2, hit.getSourceAsMap().size());
        }  
            }""";
                client().admin().indices().prepareFlush("test").setForce(true).get();
        }
            indexer.assertNoFailures();  
                waitForDocs(i, indexer);
            protected XContentBuilder generateSource(long id, Random random) throws IOException {  
                    "shard [{}] - count {}, primary {}",
            logger.info("--> {} docs indexed", waitFor);
            iterateAssertCount(numberOfShards, 10, indexer.getIds());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            for (SearchHit hit : searchResponse.getHits()) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            logger.info("--> refreshing the index");
                assertNotNull(source);  
                logger.info(  
import org.opensearch.index.IndexSettings;
            logger.info("--> allow 2 nodes for index [test] ...");
                    .setSource("value", "fox_" + i + " in the field", "coordinates", Geohash.stringEncode(40.0 + i, 75.0 + i) + i)  
    }  
            prepareCreate(
            for (ShardStats shardStats : indicesStatsResponse.getShards()) {
            state.nodes().get(replicaNode).getName();  
                assertHitCount(replicaResponse, totalNumDocs);
            logger.info("--> refreshing the index");  
        }
        logger.info("--> creating test index with derived source enabled...");
            logger.info("--> waiting for {} docs to be indexed ...", waitFor);
            RefreshResponse actionGet = client().admin().indices().prepareRefresh().get();  
            "iteration [{}] - returned documents: {} (expected {})",  
                  "type": "integer"
    public static final class RetentionLeaseSyncIntervalSettingPlugin extends Plugin {
import java.util.Collections;
        logger.info(
            assertHitCount(primaryResponse, totalNumDocs);  
            logger.info("--> marking and waiting for indexing threads to stop ...");
                    .get();
            indexer.continueIndexing(extraDocs);
            // if there was an error we try to wait and see if at some point it'll get fixed
        final int numReplicas = 0;
                    if (searchResponse.getHits().getTotalHits().value() != numberOfDocs) {  
                    .setSettings(Settings.builder().put(SETTING_NUMBER_OF_REPLICAS, numNodes - 1))
    }  
            indexer.assertNoFailures();
                    .get();  
                client().prepareIndex("test").setId(String.valueOf(i)).setSource("age", i, "name", "test" + i).get();  
            extraDocs = totalNumDocs - waitFor;  
import org.opensearch.cluster.routing.ShardRouting;
            logger.info("--> allow 2 nodes for index [test] ...");  
            waitFor += extraDocs;  
                    .endObject();  
                3,
import java.util.stream.Collectors;
                "test",  
            }""";  
 * The OpenSearch Contributors require contributions made to  
                        }  
            indexer.stopAndAwaitStopped();  
            // Additional source verification with random sampling
        return Stream.concat(super.nodePlugins().stream(), Stream.of(RetentionLeaseSyncIntervalSettingPlugin.class))  
        }
              }
                assertEquals("192.168.1." + id, hit.getSourceAsMap().get("ip"));
            }  
            prepareCreate(  
            @Override
              }
        int waitFor = totalNumDocs / 10;
import org.opensearch.plugins.Plugin;
              "properties": {
        }
                    .get();  
                  "type": "date"  
        final int numShards = between(2, 5);  
            )
            }
                assertEquals(  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoTimeout;  
        );
                "test",  
                3,
        int docCount = randomIntBetween(100, 200);
                    .setWaitForEvents(Priority.LANGUID)
            indexer.continueIndexing(extraDocs);  
            // now start another node, while we index
            );
            }  
    }
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            prepareCreate(
                Settings.builder()
                    .prepareHealth()
            logger.info("--> verifying indexed content");
                    .prepareHealth()
        try (BackgroundIndexer indexer = new BackgroundIndexer("test", "type", client(), numDocs)) {  
                  "type": "integer"
            }, 5, TimeUnit.MINUTES);
            waitForDocs(totalNumDocs, indexer);
            logger.info("--> marking and waiting for indexing threads to stop ...");  
    @AwaitsFix(bugUrl = "Flaky test - fix before enabling")
            allowNodes("test", 3);
                    .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
import java.util.concurrent.TimeUnit;
        String mapping = """
                    assertNotNull(hit.getSourceAsMap().get("timestamp"));
            )
        );
        // Index documents without refresh  
        assertBusy(() -> {  
            assertNoTimeout(
                    .setWaitForNoRelocatingShards(true)  
            // now flush, just to make sure we have some data in the index, not just translog
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
            // Verify final doc count and derived source reconstruction  
 *  
            {  
        int numberOfShards = numberOfShards();
                SearchResponse replicaResponse = client().prepareSearch("test")
            ).setMapping(mapping)
                    .addSort("value", SortOrder.ASC)  
            assertRandomDocsSource(100);  
            SearchResponse searchResponse = client().prepareSearch("test")
            indexer.continueIndexing(extraDocs);  
        });
                },
import org.opensearch.core.index.Index;
                Settings.builder()  
            } else {
import org.opensearch.index.translog.Translog;  
            SearchResponse primaryResponse = client().prepareSearch("test").setPreference("_primary").setTrackTotalHits(true).get();
            String id = String.valueOf(randomIntBetween(0, 100));
            final ClusterState state = clusterService.state();  
        }
            assertAllSuccessful(actionGet);
            logger.info("--> verifying indexed content");  
                waitForDocs(i, indexer);
            indexer.assertNoFailures();  
        if (error) {
                    .setTimeout("5m")
                  "store": true
                "timestamp": {
    public void testRecoverWhileUnderLoadWithDerivedSource() throws Exception {
        logger.info("--> creating test index with derived source enabled...");  
        for (int i = 0; i < docCount; i++) {
import org.opensearch.index.IndexService;  
        try (BackgroundIndexer indexer = new BackgroundIndexer("test", "type", client(), extraDocs)) {  
            }, 30, TimeUnit.SECONDS);
            iteration,
            logger.info("--> allow 3 nodes for index [test] ...");  
            indexer.assertNoFailures();
                    .prepareUpdateSettings("test")  
        int numberOfShards = numberOfShards();
            indexer.assertNoFailures();
                assertNotNull(hit.getSourceAsMap().get("name"));  
                Settings.builder()
 * Unless required by applicable law or agreed to in writing,
        final int totalNumDocs = scaledRandomIntBetween(200, 1000);
                assertEquals(2, hit.getSourceAsMap().size());
        try (BackgroundIndexer indexer = new BackgroundIndexer("test", null, client(), extraDocs) {
    @ParametersFactory  
            assertHitCount(primaryResponse, numDocs);
                assertEquals(2, hit.getSourceAsMap().size());
                "name": {
    private void assertRandomDocsSource(int sampleSize) {
            logger.info("--> allow 4 nodes for index [test] ...");
    public static Collection<Object[]> parameters() {
                client().admin()
        ensureGreen(TimeValue.timeValueMinutes(2));  
            client().admin().indices().prepareRefresh().get();  
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)
            indexer.assertNoFailures();
            waitForDocs(waitFor, indexer);  
            logger.info("--> flushing the index ....");
                client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setTimeout("5m").setWaitForGreenStatus()
        logger.info("--> creating test index with derived source enabled...");
            logger.info("--> waiting for {} docs to be indexed ...", waitFor);
            logger.info("--> refreshing the index");
            logger.info("--> {} docs indexed", totalNumDocs);
import java.util.Map;
                    .setId(String.valueOf(i))
            extraDocs = totalNumDocs / 10;  
            indexer.continueIndexing(extraDocs);  
            indexer.stopAndAwaitStopped();
        String clusterManagerNode = internalCluster().getClusterManagerName();
            );
        if (replicaNode != null) {
        try (BackgroundIndexer indexer = new BackgroundIndexer("test", "type", client(), extraDocs)) {
        String mapping = """
        }  
              }
            logger.info("--> {} docs indexed", totalNumDocs);
                client().admin()
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
import org.opensearch.geometry.utils.Geohash;
        try (BackgroundIndexer indexer = new BackgroundIndexer("test", null, client(), numDocs) {
 * You may obtain a copy of the License at  
        for (int i = 0; i < iterations; i++) {
            prepareCreate(  
                    assertNotNull(hit.getSourceAsMap().get("timestamp"));
            logger.info("--> trying to wait");  
        logger.info("iteration [{}] - failed shards: {} (expected 0)", iteration, searchResponse.getFailedShards());
                assertEquals("fox_" + id + " in the field", hit.getSourceAsMap().get("value"));
                for (SearchHit hit : replicaResponse.getHits()) {
    }
    private void assertAfterRefreshAndWaitForReplication() throws Exception {
                  "type": "geo_point"  
import org.apache.logging.log4j.Logger;
            indexer.continueIndexing(extraDocs);
import org.opensearch.test.InternalTestCluster;
            }
                        errorOccurred = true;
                                .setPreference("_only_nodes:" + shardRouting.currentNodeId())
        // Verify documents on replica  
            // Verify derived source reconstruction
        final int totalNumDocs = scaledRandomIntBetween(200, 10000);  
        if (CollectionUtils.isEmpty(searchResponse.getShardFailures()) == false) {
            ).setMapping(mapping)  
            logger.info("--> indexing threads stopped");
 *
                "value": {
            assertHitCount(iterationResults[i], numberOfDocs);
        assertAcked(
            if (i % 2 == 0) {  
 * not use this file except in compliance with the License.
                },
                    ShardId docShard = clusterService.operationRouting().shardId(state, "test", id, null);  
            assertHitCount(searchResponse, totalNumDocs);  
                assertNotNull(hit.getSourceAsMap().get("age"));
                    shardStats.getShardRouting().primary()
        assertAcked(  
                    .put("index.refresh_interval", -1)
            indexer.setUseAutoGeneratedIDs(true);
    public void testRecoveryWithDerivedSourceEnabled() throws Exception {
        int extraDocs = waitFor;
                    .prepareHealth()  
        @Override  
            logger.info("--> allow 4 nodes for index [test] ...");
        }  
 * GitHub history for details.
                    .endObject();
    }
        }
            // Verify source reconstruction
        logger.info("--> waiting for GREEN health status ...");  
            waitForDocs(totalNumDocs, indexer);
            } else {
    private final Logger logger = LogManager.getLogger(RecoveryWhileUnderLoadIT.class);
        });  
                  "type": "text",  
                }  
                },  
        int additionalDocs = randomIntBetween(50, 100);  
            logger.info("--> waiting for GREEN health status ...");
            client().admin().indices().prepareRefresh().get();
            );
            ).setMapping(mapping)
                "test",
import java.util.Arrays;  
    }
            assertAfterRefreshAndWaitForReplication();
                    .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)
        SearchResponse[] iterationResults = new SearchResponse[iterations];  
import java.util.stream.Stream;  
                            }
            }
            indexer.setUseAutoGeneratedIDs(true);
                // Occasionally flush to create new segments
        // Verify documents on replica
                }  
        public List<Setting<?>> getSettings() {
 * this file be licensed under the Apache-2.0 license or a
            )
            assertNoTimeout(
import org.opensearch.search.SearchHit;
            prepareCreate(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertAcked(
                for (String id : ids) {
                    assertNotNull(hit.getSourceAsMap());
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        internalCluster().startNode();  
    private void iterateAssertCount(final int numberOfShards, final int iterations, final Set<String> ids) throws Exception {
        try (BackgroundIndexer indexer = new BackgroundIndexer("test", "type", client(), extraDocs)) {
            assertNoTimeout(
            for (int i = 0; i < numDocs; i += scaledRandomIntBetween(100, Math.min(1000, numDocs))) {
        final int numShards = between(3, 5);
                String id = hit.getId();
                return jsonBuilder().startObject()
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
import org.opensearch.common.settings.Settings;
            logger.info("--> waiting for relocations ...");
 * software distributed under the License is distributed on an
                    .get();
                    .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)  
        }
            logSearchResponse(numberOfShards, numberOfDocs, i, searchResponse);  
            logger.info("--> refreshing the index");  
                    .setTimeout("5m")  
 * under the License.  
            assertNoTimeout(  
 * SPDX-License-Identifier: Apache-2.0
            waitForDocs(waitFor, indexer);
        assertAcked(
        assertAcked(
                client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setTimeout("5m").setWaitForGreenStatus()  
        logger.info("--> creating test index with derived source enabled...");  
            GetResponse getResponse = client().prepareGet("test", id).setPreference("_replica").get();
            SearchResponse searchResponse = client().prepareSearch("test").setPreference("_replica").setSize(totalNumDocs).get();
                assertEquals(3, source.size());
import java.util.Collection;
        int extraDocs = waitFor;  
                                logger.info("missing id [{}] on shard {}", id, shardRouting);
            assertNoTimeout(  
                1,
            indexer.assertNoFailures();
        Index idx = state.metadata().index(index).getIndex();
                "test",  
                }
        logger.info("--> creating test index ...");
                );
        int allowNodes = 2;  
                    assertEquals(3, hit.getSourceAsMap().size());
 * license agreements. See the NOTICE file distributed with
    }
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                            if (response.isExists()) {  
            }""";  
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
            assertNoTimeout(  
            extraDocs = totalNumDocs / 10;
                ensureGreen(TimeValue.timeValueMinutes(2));
/*  
            }
            if (searchResponse.getHits().getTotalHits().value() != numberOfDocs) {
            logger.info("--> {} docs indexed", waitFor);
        assertAcked(
import org.opensearch.index.shard.DocsStats;
                }
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            logger.info("--> waiting for {} docs to be indexed ...", totalNumDocs);  
                    }
                assertEquals("name_" + id, source.get("name"));
            assertEquals(numberOfDocs, ids.size());  
            logger.info("--> refreshing the index");  
            logger.info("--> flushing the index ....");  
            assertRandomDocsSource(50);  
            waitForDocs(waitFor, indexer);
        for (int i = 0; i < docCount; i++) {
        assertBusy(() -> {
                    .setWaitForEvents(Priority.LANGUID)
            }
                );  
    }
        return null;
            @Override  
                    .setTimeout("5m")
                            GetResponse response = client().prepareGet("test", id)  
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
                .get();
        }
            if (getResponse.isExists()) {
import org.opensearch.action.support.WriteRequest;
                Settings.builder()  
import org.opensearch.test.BackgroundIndexer;
                allowNodes = 2 / allowNodes;
                    .field("name", "name_" + id)  
                    assertEquals("name_" + id, hit.getSourceAsMap().get("name"));  
        }) {
            client().prepareIndex("test")
            )  
            extraDocs = totalNumDocs / 10;
            for (SearchHit hit : searchResponse.getHits()) {  
            iteration,  
            assertBusy(() -> {
    }
            "iteration [{}] - successful shards: {} (expected {})",
            logger.info("--> allow 2 nodes for index [test] ...");  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
            logger.info("--> bump up number of replicas to 1 and allow all nodes to hold the index");
                    hit.getSourceAsMap().get("timestamp")
            logger.info("--> waiting for {} docs to be indexed ...", totalNumDocs);
import org.opensearch.cluster.service.ClusterService;
            logger.info("--> verifying indexed content");
                logger.info("--> waiting for {} docs to be indexed ...", i);
                "test",
            logger.info("--> {} docs indexed", waitFor);
            indexer.assertNoFailures();  
        ensureGreen(TimeValue.timeValueMinutes(2));
                    .setTimeout("5m")
                // Verify source reconstruction on replica
            indexer.assertNoFailures();
                assertNotNull(source.get("timestamp"));
                    .get()
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)
                Settings.builder()  
import java.util.Random;
 * Licensed to Elasticsearch under one or more contributor  
            logger.info("--> waiting for {} docs to be indexed ...", totalNumDocs);  
              }  
                "test",  
                }
                    .setTrackTotalHits(true)
                },
            logger.info("--> waiting for {} docs to be indexed ...", waitFor);  
                    .setPreference("_replica")  
    @Override
                        .get();
            logger.info("--> waiting for {} docs to be indexed ...", waitFor);  
                DocsStats docsStats = shardStats.getStats().docs;
        String mapping = """
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            logger.info("--> marking and waiting for indexing threads to stop ...");
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)  
        // lets now make the test fail if it was supposed to fail  
            assertHitCount(searchResponse, docCount);
        logger.info("--> creating test index ...");
            prepareCreate(  
}
import org.opensearch.common.unit.TimeValue;  
import org.apache.logging.log4j.LogManager;  
        }
        assertAcked(
                    .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), randomFrom("100ms", "1s", "5s", "30s", "60s"))  
    public void testRecoverWithRelocationAndDerivedSource() throws Exception {
            );
        final long numberOfDocs = ids.size();
            indexer.assertNoFailures();  
    @AwaitsFix(bugUrl = "Flaky test - fix before enabling")
                    .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
    @AwaitsFix(bugUrl = "Flaky test - fix before enabling")  
            for (int shard = 0; shard < numberOfShards; shard++) {
        ensureGreen(TimeValue.timeValueMinutes(2));
            // make sure the cluster state is green, and all has been recovered
                client().admin()
        for (int i = 0; i < totalNumDocs; i++) {
                client().prepareIndex("test")  
            // make sure the cluster state is green, and all has been recovered
        logger.info("--> creating test index with derived source enabled...");
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                "timestamp": {
                .setTrackTotalHits(true)  
            }, 30, TimeUnit.SECONDS);  
                .setQuery(matchAllQuery())
            extraDocs = totalNumDocs / 10;
            assertAcked(  
                .setSize(docCount + additionalDocs)
                client().prepareIndex("test")
        }
 *
            // now, shutdown nodes
                    .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)  
        int numberOfShards = numberOfShards();  
            client().admin().indices().prepareFlush().execute().actionGet();
            allowNodes("test", 2);
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
    }  
import java.util.Set;  
        String replicaNode = state.routingTable().index(idx).shard(0).replicaShards().get(0).currentNodeId();  
        // Add replica before refresh
 * Modifications Copyright OpenSearch Contributors. See
            waitFor += extraDocs;
        return replicationSettings;
            waitForDocs(waitFor, indexer);  
            );
            logger.info("--> {} docs indexed", waitFor);  
                "value": {
        logger.info(
            prepareCreate(
        int docCount = randomIntBetween(100, 200);
        boolean error = false;
            }""";
        // Random sampling of documents for detailed source verification
                client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "age", i).get();
        final int numDocs = scaledRandomIntBetween(1500, 2000);  
                  "type": "keyword"
                "timestamp": {
                for (SearchHit hit : replicaResponse.getHits()) {  
                .get();
 */  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    .cluster()
    }
        }, 5, TimeUnit.MINUTES);
                "name": {
        );
 * compatible open source license.
            logger.info("--> waiting for {} docs to be indexed ...", totalNumDocs);
 * KIND, either express or implied.  See the License for the
            logger.info("--> indexing threads stopped");
                "test",
        allowNodes("test", 2);
                assertNotNull(hit.getSourceAsMap());
                    .put(IndexSettings.INDEX_DERIVED_SOURCE_SETTING.getKey(), true)  
        );  
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)  
                    .prepareHealth()  
              "properties": {
            waitForDocs(waitFor, indexer);
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                client().prepareIndex("test")
                    .cluster()
    public void testRecoverWhileUnderLoadAllocateReplicasTest() throws Exception {
import java.util.List;  
                    .indices()
                assertNotNull(hit.getSourceAsMap());  
                .setId(String.valueOf(i))  
            }  
            client().admin().indices().prepareFlush().execute().actionGet();
                "age": {
                    .put(SETTING_NUMBER_OF_REPLICAS, numReplicas)
    }
            for (int i = 0; i < numDocs; i += scaledRandomIntBetween(500, Math.min(1000, numDocs))) {
        );
                    .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
                    .setWaitForNoRelocatingShards(true)  
                    .put(SETTING_NUMBER_OF_SHARDS, numShards)
            // now start more nodes, while we index
            logger.info("--> marking and waiting for indexing threads to stop ...");  
/*  
            numberOfShards
        );
                logger.info("--> waiting for {} docs to be indexed ...", i);
                    assertEquals("name_" + id, hit.getSourceAsMap().get("name"));
                    int id = (Integer) hit.getSourceAsMap().get("value");
    }
        }
                error = true;  
            );  
            {  
            logger.info("--> verifying indexed content");
                ensureGreen(TimeValue.timeValueMinutes(5));
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
        final String replicaNode = ensureReplicaNode("test");
                logger.info("--> {} docs indexed", i);  
            allowNodes("test", 3);  
            waitForDocs(totalNumDocs, indexer);
                  "type": "keyword"
            iterateAssertCount(numberOfShards, 10, indexer.getIds());  
                    .setPreference("_replica")
        client().admin().indices().prepareFlush("test").setForce(true).get();
        int waitFor = totalNumDocs / 10;
            waitFor += extraDocs;
