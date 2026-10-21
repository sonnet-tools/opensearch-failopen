            bulk("index_with_replicas", "_OLD", 5);
            default:
            bulk(indexName, "_" + CLUSTER_TYPE, 5);
            segrepStatsRequest.addParameter("h", "index,shard,primaryOrReplica,segment,docs.count");
            case UPGRADED:
            assertCount(indexName, expectedCount + 5);
                Request waitForGreen = new Request("GET", "/_cluster/health");
            Request createTestIndex = new Request("PUT", "/test_index");
            assertEquals("{\"hits\":{\"total\":" + count + "}}",
 * specific language governing permissions and limitations
        for (String id : nodesAsMap.keySet()) {
        if (UPGRADE_FROM_VERSION.before(Version.V_2_4_0)) {
            case MIXED:
    }
            case UPGRADED:
        for (int i = 0; i < count; i++) {
        }
            client().performRequest(createTestIndex);
            case OLD:
            case UPGRADED:
                    .put(IndexSettings.INDEX_DOC_ID_FUZZY_SET_ENABLED_SETTING.getKey(), true);
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
            toBeDeleted.setJsonEntity("{\"f1\": \"delete-me\"}");
import org.opensearch.common.io.Streams;
        response = client().performRequest(new Request("GET", "_cluster/state"));
 * <p>
                                add(CodecService.LUCENE_DEFAULT_CODEC);
    }
        logger.info("--> Case {}", CLUSTER_TYPE);
            logger.info("--> Delete previously added doc and verify doc count");
              to primary while remaining *replicaCount* records belongs to replica copies
                break;
            logger.info("--> {} {} {}",
            client().performRequest(waitForGreen);
                objectPath.evaluate("nodes." + id + ".name"),
                    expectedCount = 10;
    private void printClusterNodes() throws IOException, ParseException, URISyntaxException {
 * by which they survive.
            waitForSearchableDocs(indexName, shardCount, replicaCount);
                    String[] replicaRow = filteredList.get(segmentsIndex).split(" +");
            Response searchTestIndexResponse = client().performRequest(searchTestIndexRequest);
            delete.addParameter("refresh", "true");
            toBeDeleted.setJsonEntity("{\"f1\": \"delete-me\"}");
/*
 * xpack rolling restart tests. We should work on a way to remove this
            case OLD:
        waitForStatus.addParameter("wait_for_status", status);
                break;
    }
        }
                    expectedCount = 5;
    }
            Response segrepStatsResponse = client().performRequest(segrepStatsRequest);
        switch (CLUSTER_TYPE) {
                    expectedCount = 10;
            toBeDeleted.addParameter("refresh", "true");
        printClusterNodes();
            default:
            bulk(indexName, "_" + CLUSTER_TYPE, 5);
            logger.info("--> Bulk index 5 documents");
        assertCount("empty_index", 0);
            Request toBeDeleted = new Request("PUT", "/" + indexName + "/_doc/to_be_deleted");
                if (Booleans.parseBoolean(System.getProperty("tests.first_round"))) {
            for (int segmentsIndex=0; segmentsIndex < filteredList.size();) {
                            }
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
        b.append("{\"f1\": \"v\"}\n");
            break;
        assertBusy(() -> {
import org.apache.hc.core5.http.ParseException;
        Request clusterStateRequest = new Request("GET", "_nodes");
            waitForGreen.addParameter("level", "shards");
import java.util.List;
            case UPGRADED:
 * The OpenSearch Contributors require contributions made to
        StringBuilder b = new StringBuilder();
            waitForSearchableDocs(indexName, shardCount, replicaCount);
                    // When segment has 0 doc count, not all replica copies posses that segment. Skip to next segment
                }
 * Licensed to Elasticsearch under one or more contributor
                waitForClusterHealthWithNoShardMigration(indexName, "yellow");
import org.opensearch.indices.replication.common.ReplicationType;
            Request createEmptyIndex = new Request("PUT", "/empty_index");
            segrepStatsRequest.addParameter("h", "shardId,target_node,checkpoints_behind");
        case OLD:
                waitForClusterHealthWithNoShardMigration(indexName, "green");
        bulk.setJsonEntity(b.toString());
/*
                        assertTrue(primaryRow[4].equals("0"));
/*
                break;
                        randomFrom(new ArrayList<>(CODECS) {
import org.opensearch.Version;
        }
                break;
            searchTestIndexRequest.addParameter(TOTAL_HITS_AS_INT_PARAM, "true");
 */
                waitForGreen.addParameter("wait_for_nodes", "3");
            logger.info("--> Skip test for version {} where segment replication feature is not available", UPGRADE_FROM_VERSION);
        bulk.setJsonEntity(b.toString());
            allowedWarnings("index [test_index] matches multiple legacy templates [global, prevent-bwc-deprecation-template], " +
            }
            b.append("{\"f1\": \"v").append(i).append(valueSuffix).append("\", \"f2\": ").append(i).append("}\n");
        assertCount("test_index", expectedCount);
                bulk(indexName, "_OLD", 5);
            break;
package org.opensearch.upgrades;
            // are not enough number of rows vs failing with IndexOutOfBoundsException
                } else {
import org.opensearch.client.Request;
                        break;
        }
            break;
            createIndexWithReplicas.setJsonEntity(recoverQuickly);
        logger.info("--> _cat/shards before test execution \n{}", EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/shards?v")).getEntity()));
        Map<String, Object> nodesAsMap = objectPath.evaluate("nodes");
                for(int replicaIndex = 1; replicaIndex <= replicaCount; replicaIndex++) {
 * Basic test that indexed documents survive the rolling restart. See
            client().performRequest(waitForYellow);
            return;
                break;
 * license agreements. See the NOTICE file distributed with
                        randomFrom(new ArrayList<>(CODECS) {
 *
                break;
            toBeDeleted.addParameter("refresh", "true");
        // Verify segment store
    /**
                    .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                        EngineConfig.INDEX_CODEC_SETTING.getKey(),
                Settings.Builder settings = Settings.builder()
            createTestIndex.setJsonEntity("{\"settings\": {\"index.number_of_replicas\": 0}}");
                createIndex(indexName, settings.build());
        default:
                        })
                break;
            expectedCount = 15;
import org.opensearch.index.engine.EngineConfig;
                updateIndexSettings(indexName, settingsBuilder);
            // Ensure there is result for replica copies before processing the result. This results in retry when there
        logger.info("--> Cluster manager {}", cm);
                expectedCount = 10;
                    if (replicaRow[2].equals("p")) {
            Request createIndexWithReplicas = new Request("PUT", "/index_with_replicas");
                    // verify same shard id
            toBeDeleted.addParameter("refresh", "true");
                    if (minNodeVersion == null) {
                    .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms");
            client().performRequest(createEmptyIndex);
        }, 1, TimeUnit.MINUTES);
            break;
        b.append("{\"create\": {\"_index\": \"").append(indexName).append("\"}}\n");
        if (CLUSTER_TYPE != ClusterType.OLD) {
                break;
 * this file be licensed under the Apache-2.0 license or a
                client().performRequest(bulk);
                id,
            Request segrepStatsRequest = new Request("GET", "/_cat/segment_replication/" + indexName);
        }
                waitForClusterHealthWithNoShardMigration(indexName, "green");
                Settings.Builder settings = Settings.builder()
                    Map<?, ?> nodeInfo = (Map<?, ?>) node.getValue();
            // Ask for recovery to be quick
    private void waitForSearchableDocs(String index, int shardCount, int replicaCount) throws Exception {
        StringBuilder b = new StringBuilder();
            client().performRequest(createIndexWithReplicas);
        final int replicaCount = 2;
     * This test verifies that during rolling upgrades the segment replication does not break when replica shards can
                EntityUtils.toString(searchTestIndexResponse.getEntity(), StandardCharsets.UTF_8));
            Request delete = new Request("DELETE", "/test_index/_doc/to_be_deleted");
    private void bulk(String index, String valueSuffix, int count) throws IOException {
        assertCount(indexName, expectedCount);
        }
                }
                }
                Settings.Builder settingsBuilder = Settings.builder()
        assertTrue(replicaCount > 0);
    }
 * not use this file except in compliance with the License.
        Request bulk = new Request("POST", "/_bulk");
                    String replicaShardId = replicaRow[0] + replicaRow[1];
                    segmentsIndex++;
                break;
                createIndex(indexName, settings.build());
                    }
     * @throws Exception if index creation fail
        }
                    // verify replica row
        assertBusy(() -> {
            // Filter response for rows with zero doc count
    public void testIndexing() throws Exception {
            case OLD:
        int expectedCount;
                            {
        verifySegmentStats(index);
                            }
    }
            assertCount(indexName, expectedCount + 6);
        logger.info("--> _cat/shards before search \n{}", EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/shards?v")).getEntity()));
                expectedCount = 5;
                Settings.Builder settings = Settings.builder()
import org.opensearch.client.Response;
        }
                        minNodeVersion = nodeVersion;
        }
                String shardId = primaryRow[0] + primaryRow[1];
            client().performRequest(delete);
        }, 30, TimeUnit.SECONDS);
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
        Request waitForStatus = new Request("GET", "/_cluster/health/" + indexName);
 * Modifications Copyright OpenSearch Contributors. See
                assertTrue(primaryRow[2].equals("p"));
            assertCount("test_index", expectedCount + 6);
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.opensearch.cluster.metadata.IndexMetadata;
        ObjectPath objectPath = ObjectPath.createFromResponse(response);
        case UPGRADED:
            client().performRequest(toBeDeleted);
public class IndexingIT extends AbstractRollingTestCase {
                    expectedCount = 5;
 * software distributed under the License is distributed on an
            bulk("test_index", "_OLD", 5);
            Request waitForYellow = new Request("GET", "/_cluster/health");
            useIgnoreMultipleMatchingTemplatesWarningsHandler(createIndexWithReplicas);
                    .put(
            assertEquals(0, filteredList.size() % (replicaCount + 1));
            Request waitForGreen = new Request("GET", "/_cluster/health/test_index,index_with_replicas,empty_index");
        Request bulk = new Request("POST", "/_bulk");
        final int shardCount = 3;
            waitForYellow.addParameter("wait_for_nodes", "3");
        default:
            client().performRequest(toBeDeleted);
            //forceMergeAndVerify(indexName, shardCount * (1 + replicaCount));
            toBeDeleted.setJsonEntity("{\"f1\": \"delete-me\"}");
     */
        }
        waitForStatus.addParameter("timeout", "70s");
            bulk("test_index", "_" + CLUSTER_TYPE, 5);
 * GitHub history for details.
                String[] primaryRow = filteredList.get(segmentsIndex++).split(" +");
    }
                waitForClusterHealthWithNoShardMigration(indexName, "green");
            } else {
                expectedCount = 15;
     * be running on older codec versions.
            client().performRequest(delete);
        if (CLUSTER_TYPE != ClusterType.OLD) {
                        EngineConfig.INDEX_CODEC_SETTING.getKey(),
        logger.info("--> Case {}", CLUSTER_TYPE);
                break;
            assertCount(indexName, expectedCount + 6);
                if (count.equals("0") == false) {
            break;
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), shardCount)
                    assertTrue(replicaRow[3].equals(primaryRow[3]));
            waitForGreen.addParameter("timeout", "70s");
                expectedCount = 5;
                    assertTrue(replicaRow[4].equals(primaryRow[4]));
 * {@link RecoveryIT} for much more in depth testing of the mechanism
        final String indexName = "auto_id_and_op_type_create_index";
            break;
            // wait for long enough that we give delayed unassigned shards to stop being delayed
                    filteredList.add(row);
 * compatible open source license.
            delete.addParameter("refresh", "true");
            case OLD:
                } else {
                    // Verify segment name matches e.g. _0
import java.util.Map;
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
        logger.info("--> _cat/shards before test execution \n{}", EntityUtils.toString(client().performRequest(new Request("GET", "/_cat/shards?v")).getEntity()));
        bulk.addParameter("refresh", "true");
            case MIXED:
                    .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), shardCount)
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
                "composable templates will only match a single template");
        final String indexName = "test-index-fuzzy-set";
    private void assertCount(String index, int count) throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
        assertCount("index_with_replicas", 5);
        client().performRequest(bulk);
        }
                break;
            logger.info("--> Index one doc (to be deleted next) and verify doc count");
import java.util.ArrayList;
                    .put(
            assertCount(indexName, expectedCount + 5);
                    Version nodeVersion = Version.fromString(nodeInfo.get("version").toString());
                        })
            Request toBeDeleted = new Request("PUT", "/test_index/_doc/to_be_deleted");
            expectedCount = 5;
    private void verifySegmentStats(String indexName) throws Exception {
        printClusterNodes();
        final String indexName = "test-index-segrep";
                createIndex(indexName, settings.build());
                assertEquals("Replica shard " + elements[0] + "not upto date with primary ", 0, Integer.parseInt(elements[2]));
        switch (CLUSTER_TYPE) {
            case MIXED:
            assertCount("test_index", expectedCount + 5);
                    )
                expectedCount = 5;
 * this work for additional information regarding copyright
        final int shardCount = 3;
                waitForClusterHealthWithNoShardMigration(indexName, "green");
            logger.info("--> Index one doc (to be deleted next) and verify doc count");
        String cm = ObjectPath.createFromResponse(response).evaluate("master_node");
            }
        // wait for long enough that we give delayed unassigned shards to stop being delayed
        switch (CLUSTER_TYPE) {
                    // Verify doc count matches
import org.opensearch.common.Booleans;
import org.opensearch.index.codec.CodecService;
            case MIXED:
        case OLD:
            waitForGreen.addParameter("wait_for_nodes", "3");
        }
                String count = row.split(" +")[4];
        switch (CLUSTER_TYPE) {
        switch (CLUSTER_TYPE) {
import static org.opensearch.cluster.routing.UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING;
                Map<?, ?> nodes = (Map<?, ?>) response.get("nodes");
            /*
import static org.opensearch.test.OpenSearchIntegTestCase.CODECS;
            throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
            String recoverQuickly = "{\"settings\": {\"index.unassigned.node_left.delayed_timeout\": \"100ms\"}}";
 * duplication but for now we have no real way to share code.
            logger.info("--> Skip test for version {} where fuzzy filter postings format feature is not available", UPGRADE_FROM_VERSION);
        bulk.addParameter("refresh", "true");
            case MIXED:
        }
    private void waitForClusterHealthWithNoShardMigration(String indexName, String status) throws IOException {
        final int replicaCount = 1;
        if (CLUSTER_TYPE == ClusterType.OLD) {
            searchTestIndexRequest.addParameter("filter_path", "hits.total");
        assertTrue(shardCount > 0);
        Response response = client().performRequest(clusterStateRequest);
        waitForSearchableDocs(indexName, shardCount, replicaCount);
            useIgnoreMultipleMatchingTemplatesWarningsHandler(createTestIndex);
    public void testIndexingWithFuzzyFilterPostings() throws Exception {
import org.opensearch.common.settings.Settings;
        waitForStatus.addParameter("wait_for_no_relocating_shards", "true");
    // Verifies that for each shard copy holds same document count across all containing nodes.
            return;
                Map<?, ?> response = entityAsMap(client().performRequest(new Request("GET", "_nodes")));
                break;
                break;
        }, 1, TimeUnit.MINUTES);
                client().performRequest(bulk);
            logger.info("--> _cat/segments response\n {}", responseList.toString().replace(',', '\n'));
            createEmptyIndex.setJsonEntity(recoverQuickly);
                    assertTrue(replicaRow[2].equals("r"));
                            {
                }
        switch (CLUSTER_TYPE) {
        assertBusy(() -> {
 *
            List<String> responseList = Streams.readAllLines(segrepStatsResponse.getEntity().getContent());
            case UPGRADED:
            default:
    }
    }
            List<String> filteredList = new ArrayList<>();
                String[] elements = statLine.split(" +");
 * SPDX-License-Identifier: Apache-2.0
        client().performRequest(waitForStatus);
            }
                        minNodeVersion = nodeVersion;
import java.util.concurrent.TimeUnit;
            Request delete = new Request("DELETE", "/" + indexName + "/_doc/to_be_deleted");
import java.io.IOException;
                throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
            default:
        waitForStatus.addParameter("level", "shards");
}
                Version minNodeVersion = null;
            Request segrepStatsRequest = new Request("GET", "/_cat/segments/" + index + "?s=shard,segment,primaryOrReplica");
            }
                                add(CodecService.LUCENE_DEFAULT_CODEC);
                    } else if (nodeVersion.before(minNodeVersion)) {
import static org.opensearch.rest.action.search.RestSearchAction.TOTAL_HITS_AS_INT_PARAM;
 * under the License.
                for (Map.Entry<?, ?> node : nodes.entrySet()) {
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), replicaCount)
 */
              Use default tabular output and sort response based on shard,segment,primaryOrReplica columns to allow line by
                if (Booleans.parseBoolean(System.getProperty("tests.first_round"))) {
                expectedCount = 15;
        waitForClusterHealthWithNoShardMigration(index, "green");
    }
              */
            for(String row: responseList) {
                    )
    public void testIndexingWithSegRep() throws Exception {
                    .put(INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "100ms");
        }
     * @throws UnsupportedOperationException if cluster type is unknown
            Request delete = new Request("DELETE", "/" + indexName + "/_doc/to_be_deleted");
 * ownership. Elasticsearch licenses this file to you under
            useIgnoreMultipleMatchingTemplatesWarningsHandler(createEmptyIndex);
            client().performRequest(toBeDeleted);
import java.nio.charset.StandardCharsets;
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), replicaCount)
            case OLD:
        // Verify segment replication stats
        }
        case MIXED:
            for (String statLine : Streams.readAllLines(segrepStatsResponse.getEntity().getContent())) {
                break;
        assertCount(indexName, expectedCount);
    public void testAutoIdWithOpTypeCreate() throws IOException {
            logger.info("--> Delete previously added doc and verify doc count");
            Request searchTestIndexRequest = new Request("POST", "/" + index + "/_search");
 * This test is an almost exact copy of <code>IndexingIT</code> in the
            throw new UnsupportedOperationException("Unknown cluster type [" + CLUSTER_TYPE + "]");
 *    http://www.apache.org/licenses/LICENSE-2.0
                waitForClusterHealthWithNoShardMigration(indexName, "yellow");
 */
            b.append("{\"index\": {\"_index\": \"").append(index).append("\"}}\n");
            default:
                break;
            if (Booleans.parseBoolean(System.getProperty("tests.first_round"))) {
import java.net.URISyntaxException;
import org.opensearch.index.IndexSettings;
        switch (CLUSTER_TYPE) {
        case UPGRADED:
 *
        waitForStatus.addParameter("wait_for_no_initializing_shards", "true");
        int expectedCount;
            client().performRequest(delete);
                Version.fromString(objectPath.evaluate("nodes." + id + ".version")));
                    }
import org.opensearch.test.rest.yaml.ObjectPath;
                bulk(indexName, "_OLD", 5);
            waitForYellow.addParameter("wait_for_status", "yellow");
/**
                    .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0);
                }
        int expectedCount;
        if (UPGRADE_FROM_VERSION.onOrBefore(Version.V_2_11_1)) {
            delete.addParameter("refresh", "true");
              line parsing where records related to a segment (e.g. _0) are chunked together with first record belonging
 * KIND, either express or implied.  See the License for the
            Request toBeDeleted = new Request("PUT", "/" + indexName + "/_doc/to_be_deleted");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     *
        case MIXED:
            waitForGreen.addParameter("wait_for_status", "green");
                    assertTrue(replicaShardId.equals(shardId));
            Response segrepStatsResponse = client().performRequest(segrepStatsRequest);
 */
                client().performRequest(waitForGreen);
        if (CLUSTER_TYPE != ClusterType.OLD) {
