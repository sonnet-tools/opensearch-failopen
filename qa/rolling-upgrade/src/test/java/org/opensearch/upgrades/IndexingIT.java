                    .put(
            default:
                if (count.equals("0") == false) {  
                    } else if (nodeVersion.before(minNodeVersion)) {
            logger.info("--> Index one doc (to be deleted next) and verify doc count");
        logger.info("--> _cat/shards before search \n{}", EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/shards?v")).getEntity()));  
                            {
        logger.info("--> Case {}", CLUSTER_TYPE);
     *
import org.opensearch.Version;
                expectedCount = 5;
            case UPGRADED:  
            //forceMergeAndVerify(indexName, shardCount * (1 + replicaCount));
        }
                String[] elements = statLine.split(" +");
            break;
 * Modifications Copyright OpenSearch Contributors. See  
        bulk.setJsonEntity(b.toString());  
                    segmentsIndex++;  
            break;
                break;  
                expectedCount = 5;
            }
        }, 30, TimeUnit.SECONDS);  
            bulk(indexName, "_" + CLUSTER_TYPE, 5);
        waitForStatus.addParameter("wait_for_no_initializing_shards", "true");  
 *
 * You may obtain a copy of the License at  
        }  
        final String indexName = "auto_id_and_op_type_create_index";  
    private void waitForClusterHealthWithNoShardMigration(String indexName, String status) throws IOException {  
                id,
                client().performRequest(waitForGreen);  
    }  
        String cm = ObjectPath.createFromResponse(response).evaluate("master_node");  
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0);  
            case MIXED:  
            case MIXED:  
        Request waitForStatus = new Request("GET", "/_cluster/health/" + indexName);
            Request toBeDeleted = new Request("PUT", "/" + indexName + "/_doc/to_be_deleted");  
    private void verifySegmentStats(String indexName) throws Exception {
            segrepStatsRequest.addParameter("h", "shardId,target_node,checkpoints_behind");
        if (UPGRADE_FROM_VERSION.before(Version.V_2_4_0)) {
 */  
                break;  
            toBeDeleted.setJsonEntity("{\"f1\": \"delete-me\"}");
        printClusterNodes();
        switch (CLUSTER_TYPE) {
     * be running on older codec versions.
              Use default tabular output and sort response based on shard,segment,primaryOrReplica columns to allow line by
                break;
            } else {  
        b.append("{\"create\": {\"_index\": \"").append(indexName).append("\"}}\n");
                expectedCount = 10;
                        })
            waitForGreen.addParameter("wait_for_nodes", "3");
        }
        assertBusy(() -> {  
            case OLD:  
                expectedCount = 5;
                    .put(IndexSettings.INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING.getKey(), true);
                Request waitForGreen = new Request("GET", "/_cluster/health");
 * not use this file except in compliance with the License.
                break;
        Request bulk = new Request("POST", "/_bulk");
        }  
        Request clusterStateRequest = new Request("GET", "_nodes");  
                    }  
            waitForSearchableDocs(indexName, shardCount, replicaCount);
                    if (replicaRow[2].equals("p")) {  
 * Basic test that indexed documents survive the rolling restart. See
            client().performRequest(createIndexWithReplicas);
    }
import org.opensearch.test.rest.yaml.ObjectPath;
            expectedCount = 5;
    public void testIndexingWithSegRep() throws Exception {  
                createIndex(indexName, settings.build());
            default:
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), replicaCount)  
        switch (CLUSTER_TYPE) {  
                bulk(indexName, "_OLD", 5);
                    expectedCount = 5;
            Request delete = new Request("DELETE", "/" + indexName + "/_doc/to_be_deleted");
                String count = row.split(" +")[4];
                        minNodeVersion = nodeVersion;  
            toBeDeleted.setJsonEntity("{\"f1\": \"delete-me\"}");
                break;
                    assertTrue(replicaRow[2].equals("r"));
            createTestIndex.setJsonEntity("{\"settings\": {\"index.number_of_replicas\": 0}}");  
        Response response = client().performRequest(clusterStateRequest);
            Request segrepStatsRequest = new Request("GET", "/_cat/segments/" + index + "?s=shard,segment,primaryOrReplica");  
        int expectedCount;
        if (CLUSTER_TYPE == ClusterType.OLD) {
            Response segrepStatsResponse = client().performRequest(segrepStatsRequest);
        printClusterNodes();  
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
                Version.fromString(objectPath.evaluate("nodes." + id + ".version")));  
            for (int segmentsIndex=0; segmentsIndex < filteredList.size();) {
 * {@link RecoveryIT} for much more in depth testing of the mechanism
        }
                assertEquals("Replica shard " + elements[0] + "not upto date with primary ", 0, Integer.parseInt(elements[2]));  
 */
    /**
            logger.info("--> {} {} {}",  
        if (UPGRADE_FROM_VERSION.onOrBefore(Version.V_2_11_1)) {
                    }  
     * @throws UnsupportedOperationException if cluster type is unknown
            throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
                            }
 * software distributed under the License is distributed on an
                }
            b.append("{\"f1\": \"v").append(i).append(valueSuffix).append("\", \"f2\": ").append(i).append("}\n");
            break;  
        switch (CLUSTER_TYPE) {
        waitForStatus.addParameter("wait_for_no_relocating_shards", "true");
    public void testAutoIdWithOpTypeCreate() throws IOException {
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
 * Licensed to Elasticsearch under one or more contributor  
            case OLD:  
                    if (minNodeVersion == null) {
    private void waitForSearchableDocs(String index, int shardCount, int replicaCount) throws Exception {
            logger.info("--> Skip test for version {} where segment replication feature is not available", UPGRADE_FROM_VERSION);
                waitForGreen.addParameter("wait_for_nodes", "3");
            toBeDeleted.setJsonEntity("{\"f1\": \"delete-me\"}");  
                Map<?, ?> nodes = (Map<?, ?>) response.get("nodes");
        switch (CLUSTER_TYPE) {
            createEmptyIndex.setJsonEntity(recoverQuickly);
                    Version nodeVersion = Version.fromString(nodeInfo.get("version").toString());
            logger.info("--> Skip test for version {} where fuzzy filter postings format feature is not available", UPGRADE_FROM_VERSION);  
        }
            assertCount(indexName, expectedCount + 6);
        }, 1, TimeUnit.MINUTES);  
                Settings.Builder settings = Settings.builder()
                    // Verify segment name matches e.g. _0
        bulk.addParameter("refresh", "true");
 * Unless required by applicable law or agreed to in writing,
              to primary while remaining *replicaCount* records belongs to replica copies
 * <p>
 * ownership. Elasticsearch licenses this file to you under  
/**  
import java.util.List;
        waitForSearchableDocs(indexName, shardCount, replicaCount);
            delete.addParameter("refresh", "true");  
            case MIXED:  
 * the Apache License, Version 2.0 (the "License"); you may
        switch (CLUSTER_TYPE) {
            createIndexWithReplicas.setJsonEntity(recoverQuickly);
            assertCount(indexName, expectedCount + 5);  
            bulk("index_with_replicas", "_OLD", 5);
    }
            assertEquals(0, filteredList.size() % (replicaCount + 1));  
     * @throws Exception if index creation fail  
            allowedWarnings("index [test_index] matches multiple legacy templates [global, prevent-bwc-deprecation-template], " +  
        assertCount("index_with_replicas", 5);  
            for (String statLine : Streams.readAllLines(segrepStatsResponse.getEntity().getContent())) {
                    )  
            Response segrepStatsResponse = client().performRequest(segrepStatsRequest);  
 * this file be licensed under the Apache-2.0 license or a
                    Map<?, ?> nodeInfo = (Map<?, ?>) node.getValue();  
            case OLD:
        }
            Request createTestIndex = new Request("PUT", "/test_index");
    private void bulk(String index, String valueSuffix, int count) throws IOException {
        }
        switch (CLUSTER_TYPE) {  
                waitForClusterHealthWithNoShardMigration(indexName, "green");  
                    // verify replica row  
        }  
     */
        }
                    // verify same shard id
            assertCount("test_index", expectedCount + 6);  
import java.util.Map;
                        minNodeVersion = nodeVersion;
    // Verifies that for each shard copy holds same document count across all containing nodes.
                    .put(
        logger.info("--> _cat/shards before test execution \n{}", EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/shards?v")).getEntity()));
 * under the License.  
 * xpack rolling restart tests. We should work on a way to remove this  
        case MIXED:  
            client().performRequest(delete);
        for (String id : nodesAsMap.keySet()) {
                EntityUtils.toString(searchTestIndexResponse.getEntity(), StandardCharsets.UTF_8));
        }
import static org.opensearch.test.OpenSearchIntegTestCase.CODECS;
        waitForClusterHealthWithNoShardMigration(index, "green");
            default:  
import java.util.ArrayList;  
                break;
        logger.info("--> Cluster manager {}", cm);
import java.nio.charset.StandardCharsets;
                "composable templates will only match a single template");
        case UPGRADED:
 * this work for additional information regarding copyright
                bulk(indexName, "_OLD", 5);
            break;
            throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
                    // When segment has 0 doc count, not all replica copies posses that segment. Skip to next segment
                        EngineConfig.INDEX_CODEC_SETTING.getKey(),  
            searchTestIndexRequest.addParameter(TOTAL_HITS_AS_INT_PARAM, "true");
            case MIXED:  
            }
                        EngineConfig.INDEX_CODEC_SETTING.getKey(),  
            assertCount(indexName, expectedCount + 6);
 */
 * SPDX-License-Identifier: Apache-2.0
                }
            toBeDeleted.addParameter("refresh", "true");  
            waitForGreen.addParameter("level", "shards");  
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), shardCount)  
 * The OpenSearch Contributors require contributions made to  
            delete.addParameter("refresh", "true");  
                break;
            searchTestIndexRequest.addParameter("filter_path", "hits.total");
import org.opensearch.common.io.Streams;
                } else {  
            case UPGRADED:  
import org.opensearch.common.settings.Settings;
                    filteredList.add(row);
            assertEquals("{\"hits\":{\"total\":" + count + "}}",
                break;
            // Ensure there is result for replica copies before processing the result. This results in retry when there
                Settings.Builder settings = Settings.builder()
        assertCount(indexName, expectedCount);  
        case MIXED:  
        assertBusy(() -> {
            logger.info("--> Bulk index 5 documents");  
            Request segrepStatsRequest = new Request("GET", "/_cat/segment_replication/" + indexName);
            assertCount(indexName, expectedCount + 5);
        response = client().performRequest(new Request("GET", "_cluster/state"));
import org.opensearch.index.codec.CodecService;
            bulk(indexName, "_" + CLUSTER_TYPE, 5);
        // wait for long enough that we give delayed unassigned shards to stop being delayed  
        client().performRequest(bulk);
            waitForYellow.addParameter("wait_for_nodes", "3");
            // Filter response for rows with zero doc count
                        randomFrom(new ArrayList<>(CODECS) {
                break;
                            {
                        assertTrue(primaryRow[4].equals("0"));
                Settings.Builder settingsBuilder = Settings.builder()
        assertCount("empty_index", 0);
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), replicaCount)
        final int replicaCount = 2;
                waitForClusterHealthWithNoShardMigration(indexName, "green");  
              */
        }
                createIndex(indexName, settings.build());
            toBeDeleted.addParameter("refresh", "true");
                                add(CodecService.LUCENE_DEFAULT_CODEC);  
                for (Map.Entry<?, ?> node : nodes.entrySet()) {
                createIndex(indexName, settings.build());
            client().performRequest(waitForGreen);
                expectedCount = 15;
                expectedCount = 15;
                break;
                    assertTrue(replicaRow[3].equals(primaryRow[3]));  
        default:
        final int shardCount = 3;  
                        break;
                for(int replicaIndex = 1; replicaIndex <= replicaCount; replicaIndex++) {
        final String indexName = "test-index-segrep";
import org.opensearch.index.IndexSettings;  
 *
            client().performRequest(delete);
            case OLD:  
        ObjectPath objectPath = ObjectPath.createFromResponse(response);  
            Request waitForYellow = new Request("GET", "/_cluster/health");
            break;
    public void testIndexing() throws Exception {
            Request delete = new Request("DELETE", "/test_index/_doc/to_be_deleted");
        }, 1, TimeUnit.MINUTES);
    }  
                if (Booleans.parseBoolean(System.getProperty("tests.first_round"))) {
        logger.info("--> _cat/shards before test execution \n{}", EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/shards?v")).getEntity()));
            waitForGreen.addParameter("timeout", "70s");
        assertTrue(shardCount > 0);  
            client().performRequest(createTestIndex);
        case OLD:  
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
            client().performRequest(toBeDeleted);
            return;  
                objectPath.evaluate("nodes." + id + ".name"),
            Request delete = new Request("DELETE", "/" + indexName + "/_doc/to_be_deleted");
    }
        final int shardCount = 3;
            for(String row: responseList) {
        if (CLUSTER_TYPE != ClusterType.OLD) {
        switch (CLUSTER_TYPE) {
/*  
            case UPGRADED:
                if (Booleans.parseBoolean(System.getProperty("tests.first_round"))) {
            useIgnoreMultipleMatchingTemplatesWarningsHandler(createTestIndex);
            Request toBeDeleted = new Request("PUT", "/test_index/_doc/to_be_deleted");
        final int replicaCount = 1;
            waitForSearchableDocs(indexName, shardCount, replicaCount);
            logger.info("--> Delete previously added doc and verify doc count");
                break;
        }  
                Map<?, ?> response = entityAsMap(client().performRequest(new Request("GET", "_nodes")));  
        assertCount(indexName, expectedCount);
 * duplication but for now we have no real way to share code.
                waitForClusterHealthWithNoShardMigration(indexName, "yellow");
 * This test is an almost exact copy of <code>IndexingIT</code> in the
            Response searchTestIndexResponse = client().performRequest(searchTestIndexRequest);  
                Settings.Builder settings = Settings.builder()
            expectedCount = 15;
            case UPGRADED:
        bulk.addParameter("refresh", "true");
    }
                String shardId = primaryRow[0] + primaryRow[1];  
 * license agreements. See the NOTICE file distributed with
        default:  
            default:  
public class IndexingIT extends AbstractRollingTestCase {  
            case OLD:  
        // Verify segment replication stats
                Version minNodeVersion = null;
    }
                    expectedCount = 5;
                    assertTrue(replicaShardId.equals(shardId));
}
    }  
import static org.opensearch.rest.action.search.RestSearchAction.TOTAL_HITS_AS_INT_PARAM;  
 * compatible open source license.
        int expectedCount;
                } else {  
            }  
            if (Booleans.parseBoolean(System.getProperty("tests.first_round"))) {
            case UPGRADED:
                break;
        for (int i = 0; i < count; i++) {  
    public void testIndexingWithFuzzyFilterPostings() throws Exception {
    }
                    // Verify doc count matches
        StringBuilder b = new StringBuilder();
            Request createIndexWithReplicas = new Request("PUT", "/index_with_replicas");
            Request toBeDeleted = new Request("PUT", "/" + indexName + "/_doc/to_be_deleted");
                }
import org.opensearch.client.Response;
    private void assertCount(String index, int count) throws Exception {
            Request searchTestIndexRequest = new Request("POST", "/" + index + "/_search");  
            client().performRequest(toBeDeleted);  
                            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            waitForGreen.addParameter("wait_for_status", "green");  
            logger.info("--> Index one doc (to be deleted next) and verify doc count");  
            String recoverQuickly = "{\"settings\": {\"index.unassigned.node_left.delayed_timeout\": \"100ms\"}}";  
        logger.info("--> Case {}", CLUSTER_TYPE);  
        case OLD:
/*
                    .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms");
            List<String> filteredList = new ArrayList<>();  
                    expectedCount = 10;
import org.apache.hc.core5.http.io.entity.EntityUtils;
        }
                    .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                break;  
            // wait for long enough that we give delayed unassigned shards to stop being delayed
                client().performRequest(bulk);  
import java.io.IOException;  
                    String[] replicaRow = filteredList.get(segmentsIndex).split(" +");  
        assertTrue(replicaCount > 0);
            }
                client().performRequest(bulk);  
        if (CLUSTER_TYPE != ClusterType.OLD) {  
            client().performRequest(createEmptyIndex);
        client().performRequest(waitForStatus);
            useIgnoreMultipleMatchingTemplatesWarningsHandler(createIndexWithReplicas);  
        assertCount("test_index", expectedCount);
                }
        waitForStatus.addParameter("level", "shards");
        bulk.setJsonEntity(b.toString());  
            break;  
                updateIndexSettings(indexName, settingsBuilder);  
import org.opensearch.index.engine.EngineConfig;
 */
                waitForClusterHealthWithNoShardMigration(indexName, "green");
            bulk("test_index", "_" + CLUSTER_TYPE, 5);
        final String indexName = "test-index-fuzzy-set";  
                    String replicaShardId = replicaRow[0] + replicaRow[1];
            segrepStatsRequest.addParameter("h", "index,shard,primaryOrReplica,segment,docs.count");
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
        case UPGRADED:  
        assertBusy(() -> {  
                waitForClusterHealthWithNoShardMigration(indexName, "yellow");
 * specific language governing permissions and limitations
            logger.info("--> _cat/segments response\n {}", responseList.toString().replace(',', '\n'));
        Map<String, Object> nodesAsMap = objectPath.evaluate("nodes");
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), shardCount)
            Request waitForGreen = new Request("GET", "/_cluster/health/test_index,index_with_replicas,empty_index");
            b.append("{\"index\": {\"_index\": \"").append(index).append("\"}}\n");
        waitForStatus.addParameter("wait_for_status", status);
            case MIXED:  
     * This test verifies that during rolling upgrades the segment replication does not break when replica shards can  
            client().performRequest(delete);
            client().performRequest(waitForYellow);
package org.opensearch.upgrades;
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");  
            useIgnoreMultipleMatchingTemplatesWarningsHandler(createEmptyIndex);  
 *  
 * GitHub history for details.
        int expectedCount;
                waitForClusterHealthWithNoShardMigration(indexName, "green");
 * by which they survive.  
              line parsing where records related to a segment (e.g. _0) are chunked together with first record belonging  
                break;  
        StringBuilder b = new StringBuilder();
            client().performRequest(toBeDeleted);
 * KIND, either express or implied.  See the License for the
            return;
        if (CLUSTER_TYPE != ClusterType.OLD) {
            default:
            delete.addParameter("refresh", "true");  
                    )  
import org.opensearch.indices.replication.common.ReplicationType;  
    }
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
            toBeDeleted.addParameter("refresh", "true");
            /*
import java.util.concurrent.TimeUnit;  
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                    assertTrue(replicaRow[4].equals(primaryRow[4]));
            // Ask for recovery to be quick
import org.opensearch.client.Request;  
                    expectedCount = 10;
            logger.info("--> Delete previously added doc and verify doc count");
                        })
                String[] primaryRow = filteredList.get(segmentsIndex++).split(" +");
import org.apache.hc.core5.http.ParseException;  
import org.opensearch.common.Booleans;  
            waitForYellow.addParameter("wait_for_status", "yellow");  
            Request createEmptyIndex = new Request("PUT", "/empty_index");  
        verifySegmentStats(index);  
            bulk("test_index", "_OLD", 5);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        b.append("{\"f1\": \"v\"}\n");  
                assertTrue(primaryRow[2].equals("p"));
        // Verify segment store
import org.opensearch.cluster.metadata.IndexMetadata;
/*
                    .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms");
            // are not enough number of rows vs failing with IndexOutOfBoundsException
            assertCount("test_index", expectedCount + 5);  
        waitForStatus.addParameter("timeout", "70s");
import java.net.URISyntaxException;
                        randomFrom(new ArrayList<>(CODECS) {
            List<String> responseList = Streams.readAllLines(segrepStatsResponse.getEntity().getContent());  
        Request bulk = new Request("POST", "/_bulk");
                                add(CodecService.LUCENE_DEFAULT_CODEC);  
                break;
    private void printClusterNodes() throws IOException, ParseException, URISyntaxException {
        }
                }
