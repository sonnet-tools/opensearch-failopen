 * GitHub history for details.
                assertThat(responseException.getResponse().getWarnings(),
            final int finalVersionForDoc4 = indexDocWithConcurrentUpdates(index, 4, nUpdates);
            .putList("index.sort.field", "sortfield")
                assertCount(index, "_only_nodes:" + shard.getNode().getNodeName(), 5);
        ObjectPath objectPath = ObjectPath.createFromResponse(response);
            final String nodeId = ObjectPath.evaluate(shard, "routing.node");
                assertThat(result.get("failed"), equalTo(0));
    }
            logger.info("moving primary to new node by excluding {}", primary.getNode().getNodeName());
        assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
                assertVersion(index, 3, "_only_nodes:" + shard.getNode().getNodeName(), finalVersionForDoc3);
                    contains("Synced flush is deprecated and will be removed in 3.0. Use flush at _/flush or /{index}/_flush instead."));
            seqNoStats = new SeqNoStats(maxSeqNo, localCheckpoint, globalCheckpoint);
            .put("index.routing.allocation.include._name", newNodes).build(), TEST_MAPPING);
        ensureGreen(index);
            return node;
            indexThreads[i].start();
        private final String nodeName;
    private void printClusterRouting() throws IOException, ParseException {
            logger.info("primary resolved to: " + primary.getNode().getNodeName());
            for (Shard shard : shards) {
            Map<String, Object> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));
        final String index = "test";
        }
            logger.info("allowing shards on all nodes");
    }
                '}';
                final long expectMaxSeqNo = numDocs - 1;
            logger.info("moving primary to new node by excluding {}", primary.getNode().getNodeName());
            ensureGreen(index);
import org.opensearch.test.rest.OpenSearchRestTestCase;
import org.opensearch.indices.replication.common.ReplicationType;
            return version;
            return "Node{" +
        final String index = "indexversionprop";
        for (String id : nodesAsMap.keySet()) {
            throws Exception {
            logger.info("setting number of replicas to 1");
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
            shards = buildShards(index, nodes, newNodeClient);
            primary = shards.stream().filter(Shard::isPrimary).findFirst().get();
        @Override
        logger.info("shards {}", shards);
        final List<String> bwcNamesList = nodes.getBWCNodes().stream().map(Node::getNodeName).collect(Collectors.toList());
                    .field("type", "fs")
                assertVersion(index, 4, "_only_nodes:" + shard.getNode().getNodeName(), finalVersionForDoc4);
            indexThread.join();
            List<String> warningMsg = Arrays.asList("Synced flush was removed and a normal flush was performed instead. " +
 * The OpenSearch Contributors require contributions made to
    }
    }
 */
        String bwcNames = nodes.getBWCNodes().stream().map(Node::getNodeName).collect(Collectors.joining(","));
import java.net.URISyntaxException;
import org.opensearch.common.xcontent.support.XContentMapValues;
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
        Settings.Builder settings = Settings.builder()
    }
        final List<String> bwcNamesList = nodes.getBWCNodes().stream().map(Node::getNodeName).collect(Collectors.toList());
import org.opensearch.Version;
            + "    \"test\": {\n"
        // Exclude bwc nodes from allocation so that primaries gets allocated on current/higher version
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Node(String id, String nodeName, Version version, HttpHost publishAddress) {
    }
            }
        Settings.Builder settings = Settings.builder()
            .putList("index.sort.field", "sortfield")
        for (Object shard : shardStats) {
                objectPath.evaluate("nodes." + id + ".name"),
import java.io.IOException;
        final Response response = client().performRequest(request);
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
            updateIndexSettings(index, Settings.builder().put("index.routing.allocation.exclude._name", primary.getNode().getNodeName()));
        return nUpdates + 1;
            return publishAddress;
                assertCount(index, "_only_nodes:" + shard.getNode().getNodeName(), 2);
            request.setOptions(requestOptionsBuilder);
            + "      \"type\": \"text\"\n"
            for (Shard shard : buildShards(index, nodes, newNodeClient)) {
        assumeFalse("no new node found", nodes.getNewNodes().isEmpty());
        createIndex(index, settings.build(), TEST_MAPPING);
            printClusterRouting();
                final long expectedGlobalCkp = numDocs - 1;
        public SeqNoStats getSeqNoStats() {
        }
            nodes.add(new Node(
            this.publishAddress = publishAddress;
                    assertThat("localCheckpoint no on " + shard.getNode() + " is wrong",
        return shards;
            primary = shards.stream().filter(Shard::isPrimary).findFirst().get();
import org.opensearch.client.Request;
    private Nodes buildNodeAndVersions() throws IOException, URISyntaxException {
            return get(clusterManagerNodeId);
                assertCount(index, "_only_nodes:" + shard.getNode().getNodeName(), 3);
            final int finalVersionForDoc2 = indexDocWithConcurrentUpdates(index, 2, nUpdates);
    public void testIndexingWithReplicaOnBwcNodes() throws Exception {
            Integer localCheckpoint = ObjectPath.evaluate(shard, "seq_no.local_checkpoint");
        public Node getSafe(String id) {
        }
            /*
/*
                    final SeqNoStats seqNoStats = shard.getSeqNoStats();
            // verify replica catch up with primary
        printClusterRouting();
            }
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
 * compatible open source license.
    /**
            request.setJsonEntity("{\"test\": \"test_" + randomAlphaOfLength(2) + "\", \"sortfield\": \""+ randomIntBetween(0, numDocs) + "\"}");
    }
        indexDocs(index, randomIntBetween(0, 100), between(1, 100));
    private void assertCount(final String index, final String preference, final int expectedCount) throws IOException {
    private void assertSeqNoOnShards(String index, Nodes nodes, int numDocs, RestClient client)
            nodes.getNewNodes().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {
     */
        }
        indexDocs(index, randomIntBetween(0, 100), between(1, 100));
        Response response = client().performRequest(new Request("GET", "_nodes"));
                throw new AssertionError("unexpected io exception", e);
                "id='" + id + '\'' +
        assumeFalse("new nodes is empty", nodes.getNewNodes().isEmpty());
        String clusterState = EntityUtils.toString(client().performRequest(clusterStateRequest).getEntity()).trim();
            return;
                    assertThat("globalCheckpoint no on " + shard.getNode() + " is wrong",
        Settings.Builder settings = Settings.builder()
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), between(5, 10))
            clusterManagerNodeId = id;
            updateIndexSettings(index, Settings.builder().put("index.routing.allocation.exclude._name", primary.getNode().getNodeName()));
        public String getId() {
            final int numberOfDocsAfterAllowingShardsOnAllNodes = 1 + randomInt(5);
                Shard primaryShard = shards.stream().filter(Shard::isPrimary).findFirst().get();
 * this file be licensed under the Apache-2.0 license or a
        List<Object> shardStats = ObjectPath.createFromResponse(response).evaluate("indices." + index + ".shards.0");
            assertThat(XContentMapValues.extractValue("indices." + index + ".total.translog.uncommitted_operations", stats), equalTo(0));
                }
                throw new IllegalStateException("no nodes available");
            assertSeqNoOnShards(index, nodes, docCount, nodeClient);
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
import org.opensearch.client.RestClient;
        assumeFalse("new nodes is empty", nodes.getNewNodes().isEmpty());
            this.seqNoStats = seqNoStats;
        }
            numDocs += indexDocs(index, numDocs, numberOfDocsAfterAllowingShardsOnAllNodes);
     * replica shard allocation on lower OpenSearch version is prevented. Thus, this test though cover the use case where
package org.opensearch.backwards;
        private final String id;
                assertThat(result.get("total"), equalTo(totalShards));
            Request request = new Request("PUT", index + "/_doc/" + id);
     * @return the document version after updates
            nUpdates = randomIntBetween(minUpdates, maxUpdates);
                id,
            });
 *
            ensureGreen(index);
    }
             * the recovery code.
                assertCount(index, "_only_nodes:" + bwcName, numDocs);
            put(node.getId(), node);
        createIndex(index, settings.build(), TEST_MAPPING);
        public List<Node> getNewNodes() {
        if (UPGRADE_FROM_VERSION.before(Version.V_2_4_0)) {
        }
        final int maxUpdates = 10;
        // Allocating shards on all nodes, taking snapshots should happen on all nodes.
            } catch (IOException e) {
            // Add replicas so that it can be assigned on higher OS version nodes.
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
             * Dropping the number of replicas to zero, and then increasing it to one triggers a recovery thus exercising any BWC-logic in
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 0));
import org.apache.hc.core5.http.io.entity.EntityUtils;
        logger.info("cluster discovered:\n {}", nodes.toString());
                    .startObject("settings")
        Nodes nodes = buildNodeAndVersions();
        public List<Node> getBWCNodes() {
            nUpdates = randomIntBetween(minUpdates, maxUpdates);
            final int finalVersionForDoc3 = indexDocWithConcurrentUpdates(index, 3, nUpdates);
 */
            .put("index.routing.allocation.include._name", bwcNames);
        request.setJsonEntity("{\"indices\": \"" + index + "\"}");
            numDocsOnNewPrimary += indexDocs(index, numDocs, numberOfDocsAfterMovingPrimary);
     * <code>nUpdates</code> times
            assertSeqNoOnShards(index, nodes, numDocs, newNodeClient);
    private static final String TEST_MAPPING = createTestMapping();
                    logger.info("stats for {}, primary [{}]: [{}]", shard.getNode(), shard.isPrimary(), seqNoStats);
    final class Shard {
        int numOfReplicas = randomIntBetween(0, nodes.getNewNodes().size() - 1);
            for (Shard shard : shards) {
            final int finalVersionForDoc1 = indexDocWithConcurrentUpdates(index, 1, nUpdates);
        for (int i = 0; i < numDocs; i++) {
        // Update allocation settings so that primaries gets allocated only on nodes running on older version
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        ensureGreen(index);
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
        if (UPGRADE_FROM_VERSION.before(Version.V_2_4_0)) {
                assertVersion(index, 5, "_only_nodes:" + shard.getNode().getNodeName(), finalVersionForDoc5);
    private int indexDocWithConcurrentUpdates(String index, final int docId, int nUpdates) throws IOException, InterruptedException {
                    indexDocs(index, docId, 1);
        final String index = "test-index";
import org.opensearch.core.rest.RestStatus;
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.contains;
        }
            for (Shard shard : shards) {
        // Allocate shards to new nodes then verify synced flush requests processed by old nodes/new nodes
                assertThat(result.get("successful"), equalTo(totalShards));
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                throw new IllegalArgumentException("node with id [" + id + "] not found");
            // verify replica catch up with primary
            .put("index.routing.allocation.include._name", bwcNames);
        createIndex(index, settings.build(), TEST_MAPPING);
                .endObject().toString());
            updateIndexSettings(index, Settings.builder().putNull("index.routing.allocation.include._name"));
        }
            assertOK(client().performRequest(new Request("POST", index + "/_flush")));
        }
                .put("index.routing.allocation.include._name", bwcNames);
            // Index docs
        }
            logger.info("indexing docs with [{}] concurrent updates after allowing shards on all nodes", nUpdates);
            }
        private final boolean Primary;
                } catch (IOException e) {
        }
        int docCount = 200;
        @Override
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
                        .field("location", System.getProperty("tests.path.repo"))
            this.id = id;
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 1));
            ensureGreen(index);
            shards = buildShards(index, nodes, newNodeClient);
        request = new Request("PUT", "/_snapshot/repo/mixed-snapshot");
        }
            .putList("index.sort.field", "sortfield")
        Nodes nodes = buildNodeAndVersions();
            Request request = new Request("POST", index + "/_flush/synced");
}
        try (RestClient newNodeClient = buildClient(restClientSettings(),
                throw new IllegalArgumentException("node with id [" + id + "] not found. got:" + toString());
                List<Shard> shards = buildShards(index, nodes, client);
 * under the License.
                "This transition will be removed in a future version.");
            for (Shard shard : shards) {
 *
    private void assertVersion(final String index, final int docId, final String preference, final int expectedVersion) throws IOException {
            logger.info("--> Skip test for version {} where segment replication feature is not available", UPGRADE_FROM_VERSION);
        final String index = "test-snapshot-index";
     * This test verifies that segment replication does not break when primary shards are on lower OS version. It does this
            final int numberOfInitialDocs = 1 + randomInt(5);
        try (RestClient nodeClient = buildClient(restClientSettings(),
        createIndex(index, settings.build(), TEST_MAPPING);
 * Licensed to Elasticsearch under one or more contributor
            logger.info("setting number of replicas to 1");
            logger.info("primary resolved to: " + primary.getNode().getNodeName());
            final int numberOfDocsAfterDroppingReplicas = 1 + randomInt(5);
        }
import org.opensearch.index.seqno.SeqNoStats;
                values().stream().map(Node::toString).collect(Collectors.joining("\n")) +
                    throw new AssertionError("failed while indexing [" + e.getMessage() + "]");
            assertBusy(() -> {
            Shard primary = buildShards(index, nodes, newNodeClient).stream().filter(Shard::isPrimary).findFirst().get();
            Version bwcVersion = getBWCVersion();
        public String getNodeName() {
            if (node == null) {
 * You may obtain a copy of the License at
                assertThat(result.get("successful"), equalTo(0));
                HttpHost.create((String)objectPath.evaluate("nodes." + id + ".http.publish_address"))));
        request.addParameter("wait_for_completion", "true");
            return seqNoStats;
            Map<String, Object> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));
            updateIndexSettings(index, Settings.builder().putNull("index.routing.allocation.include._name"));
            + "    }\n"
        }
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
                assertCount(index, "_only_nodes:" + shard.getNode().getNodeName(), 4);
    private int indexDocs(String index, final int idStart, final int numDocs) throws IOException {
import org.opensearch.common.settings.Settings;
        }
            }
            if (get(id) == null) {
        int totalShards = numShards * (numOfReplicas + 1);
    /**
        Map<String, Object> nodesAsMap = objectPath.evaluate("nodes");
            numDocsOnNewPrimary += indexDocs(index, numDocs, numberOfDocsAfterDroppingReplicas);
        ensureGreen(index);
            + "  }";
            }
        }
        int docCount = 200;
                }
    public void testSyncedFlushTransition() throws Exception {
import org.opensearch.test.rest.yaml.ObjectPath;
        }
            final int finalVersionForDoc5 = indexDocWithConcurrentUpdates(index, 5, nUpdates);
            int numDocs = 0;
        logger.info("cluster discovered:\n {}", nodes.toString());
        Request request = new Request("PUT", "/_snapshot/repo");
                try {
            assertSeqNoOnShards(index, nodes, docCount, nodeClient);
        request.addParameter("preference", preference);
            logger.info("indexing docs with [{}] concurrent updates after moving primary", nUpdates);
        final int actualVersion = Integer.parseInt(ObjectPath.createFromResponse(response).evaluate("_version").toString());
            return values().stream().filter(n -> n.getVersion().equals(bwcVersion)).collect(Collectors.toList());
        public Version getBWCVersion() {
            }
            }
        public Node getNode() {
            for (Shard shard : shards) {
import java.util.Map;
    }
        nodes.setClusterManagerNodeId(ObjectPath.createFromResponse(response).evaluate("master_node"));
                logger.info("primary resolved to node {}", primaryShard.getNode());
        assumeFalse("new nodes is empty", nodes.getNewNodes().isEmpty());
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 0));
            assertOK(client().performRequest(new Request("POST", index + "/_flush")));
            shards = buildShards(index, nodes, newNodeClient);
        }
            numDocs += indexDocs(index, 0, numberOfInitialDocs);
            logger.info("--> Skip test for version {} where segment replication feature is not available", UPGRADE_FROM_VERSION);
            return;
            Primary = primary;
            Integer maxSeqNo = ObjectPath.evaluate(shard, "seq_no.max_seq_no");
            shards = buildShards(index, nodes, newNodeClient);
            }
        final String index = "test-index";
                '}';
            }
        request.setJsonEntity("{\"indices\": \"" + index + "\"}");
            this.nodeName = nodeName;
     * Indexes a document in <code>index</code> with <code>docId</code> then concurrently updates the same document
            logger.info("indexing doc with [{}] concurrent updates after setting number of replicas to 1", nUpdates);
                assertThat(result.get("failed"), equalTo(totalShards));
            // Add replicas so that it can be assigned on lower OS version nodes, but it doesn't work as called out in test overview
import org.opensearch.client.RequestOptions;
            return values().stream().filter(n -> n.getVersion().after(bwcVersion)).collect(Collectors.toList());
        assertOK(response);
        indexDocs(index, docId, 1);
                Version.fromString(objectPath.evaluate("nodes." + id + ".version")),
     * by verifying replica shards contains same number of documents as primary's.
                        .field("compress", randomBoolean())
                "node=" + node +
            final Node node = nodes.getSafe(nodeId);
            + "    },\n"
        }
        private final HttpHost publishAddress;
        try (RestClient newNodeClient = buildClient(restClientSettings(),
        request = new Request("PUT", "/_snapshot/repo/bwc-snapshot");
    }
            return Primary;
        assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
        assumeTrue("bwc version is on 1.x or Legacy 7.x", nodes.getBWCVersion().before(Version.V_2_0_0));
 * this work for additional information regarding copyright
                    .endObject()
        final String bwcNames = bwcNamesList.stream().collect(Collectors.joining(","));
        final String bwcNames = bwcNamesList.stream().collect(Collectors.joining(","));
            return Version.fromId(values().stream().map(node -> node.getVersion().id).min(Integer::compareTo).get());
     *
/*
                assertVersion(index, 2, "_only_nodes:" + shard.getNode().getNodeName(), finalVersionForDoc2);
        }
            updateIndexSettings(index, Settings.builder().putNull("index.routing.allocation.exclude._name"));
        Response response = client.performRequest(request);
     */
    public void testIndexVersionPropagation() throws Exception {
        Request request = new Request("GET", index + "/_stats");
            logger.info("setting number of replicas to 0");
        logger.info("cluster discovered: {}", nodes.toString());
        indexDocs(index, 0, between(50, 100));
            Node node = get(id);
            try {
        createIndex(index, settings.build(), TEST_MAPPING);
import org.opensearch.client.ResponseException;
                assertNotNull("failed to find primary shard", primaryShard);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)
                ResponseException responseException = expectThrows(ResponseException.class, () -> oldNodeClient.performRequest(request));
            ensureGreen(index);
        }
            final int id = idStart + i;
            ensureGreen(index);
        private final Node node;
            this.version = version;
        }
        }
        Shard(Node node, boolean primary, SeqNoStats seqNoStats) {
 * Modifications Copyright OpenSearch Contributors. See
            printClusterRouting();
import org.opensearch.client.Response;
import java.util.Arrays;
        final List<String> bwcNamesList = nodes.getBWCNodes().stream().map(Node::getNodeName).collect(Collectors.toList());
            });
 * software distributed under the License is distributed on an
        int numShards = randomIntBetween(1, 10);
        try (RestClient nodeClient = buildClient(restClientSettings(),
    public void testIndexingWithPrimaryOnBwcNodes() throws Exception {
        assertBusy(() -> {
            }
        assertOK(client().performRequest(request));
            final int numberOfDocsAfterMovingPrimary = 1 + randomInt(5);
        @Override
        String newNodes = nodes.getNewNodes().stream().map(Node::getNodeName).collect(Collectors.joining(","));
            logger.info("allowing shards on all nodes");
                for (Shard shard : shards) {
        assertThat("version mismatch for doc [" + docId + "] preference [" + preference + "]", actualVersion, equalTo(expectedVersion));
            }
            logger.info("indexing doc with [{}] concurrent updates after setting number of replicas to 0", nUpdates);
        Request clusterStateRequest = new Request("GET", "_cluster/state/routing_nodes?pretty");
        }
            return node;
        public void add(Node node) {
                        seqNoStats.getLocalCheckpoint(), equalTo(expectMaxSeqNo));
            numDocs += numberOfDocsAfterDroppingReplicas;
            logger.info("allowing replica shards assignment on bwc nodes");
        });
            RequestOptions.Builder requestOptionsBuilder = RequestOptions.DEFAULT.toBuilder();
    final class Node {
            nUpdates = randomIntBetween(minUpdates, maxUpdates);
                        seqNoStats.getGlobalCheckpoint(), equalTo(expectedGlobalCkp));
            .put("index.routing.allocation.include._name", bwcNames);
            logger.info("indexing [{}] docs initially", numberOfInitialDocs);
            assertSeqNoOnShards(index, nodes, numDocs, newNodeClient);
    final class Nodes extends HashMap<String, Node> {
import org.opensearch.cluster.metadata.IndexMetadata;
            return nodeName;
            for (final String bwcName : bwcNamesList) {
    public void testSeqNoCheckpoints() throws Exception {
 */
            ensureGreen(index);
            Integer globalCheckpoint = ObjectPath.evaluate(shard, "seq_no.global_checkpoint");
    }
        private final Version version;
            if (isEmpty()) {
            nodes.getBWCNodes().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {
                .putList("index.sort.field", "sortfield")
import org.apache.hc.core5.http.ParseException;
        Settings.Builder settings = Settings.builder()
            nodes.values().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {
            logger.info("Remove allocation include settings so that shards can be allocated on current version nodes");
        ensureNoInitializingShards(); // wait for all other shard activity to finish
     */
        public HttpHost getPublishAddress() {
     * primary shard containing nodes are running on higher OS version while replicas are unassigned.
            logger.info("indexing [{}] docs after moving primary", numberOfDocsAfterMovingPrimary);
                    assertThat("max_seq no on " + shard.getNode() + " is wrong", seqNoStats.getMaxSeqNo(), equalTo(expectMaxSeqNo));
            // perform a refresh
            return id;
        final Response response = client().performRequest(request);
            nUpdates = randomIntBetween(minUpdates, maxUpdates);
        final int actualCount = Integer.parseInt(ObjectPath.createFromResponse(response).evaluate("count").toString());
        public String toString() {
                "masterNodeId='" + clusterManagerNodeId + "'\n" +
    }
        assertOK(client().performRequest(request));
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 2));
                assertThat(result.get("total"), equalTo(totalShards));
    private static String createTestMapping() {
            });
import java.util.stream.Collectors;
                '}';
        final List<String> bwcNamesList = nodes.getBWCNodes().stream().map(Node::getNodeName).collect(Collectors.toList());
        response = client().performRequest(new Request("GET", "_cluster/state"));
        return numDocs;
        Thread[] indexThreads = new Thread[nUpdates];
        Nodes nodes = buildNodeAndVersions();
        public Version getVersion() {
                Map<String, Object> result = ObjectPath.createFromResponse(responseException.getResponse()).evaluate("_shards");
 * Unless required by applicable law or agreed to in writing,
            return "Shard{" +
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 2));
    }
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 1));
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), numShards)
            indexThreads[i] = new Thread(() -> {
        Request request = new Request("GET", index + "/_count");
/*
            assertSeqNoOnShards(index, nodes, numDocs, newNodeClient);
        }
            Request request = new Request("POST", index + "/_flush/synced");
        logger.info("cluster discovered: {}", nodes.toString());
        assumeFalse("new nodes is empty", nodes.getNewNodes().isEmpty());
import org.apache.hc.core5.http.HttpHost;
            indexDocs(index, 0, docCount);
                assertThat(responseException.getResponse().getStatusLine().getStatusCode(), equalTo(RestStatus.CONFLICT.getStatus()));
    }
        public void setClusterManagerNodeId(String id) {
        final String bwcNames = bwcNamesList.stream().collect(Collectors.joining(","));
 * ownership. Elasticsearch licenses this file to you under
     * This test creates a cluster with primary on higher version but due to {@link org.opensearch.cluster.routing.allocation.decider.NodeVersionAllocationDecider};
                .startObject()
        }
            assertOK(client().performRequest(request));
        // Allocating shards on the BWC nodes to makes sure that taking snapshot happens on those nodes.
        assumeFalse("no bwc node found", nodes.getBWCNodes().isEmpty());
            // Index docs
            int nUpdates = randomIntBetween(minUpdates, maxUpdates);
        }
import java.util.HashMap;
            logger.info("setting number of replicas to 0");
                assertCount(index, "_only_nodes:" + shard.node.nodeName, numDocs);
        public Node getClusterManager() {
        Nodes nodes = buildNodeAndVersions();
import static org.hamcrest.Matchers.equalTo;
            updateIndexSettings(index, Settings.builder().putNull("index.routing.allocation.include._name"));
    /**
 * specific language governing permissions and limitations
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
        }
            Shard primary = buildShards(index, nodes, newNodeClient).stream().filter(Shard::isPrimary).findFirst().get();
            .putList("index.sort.field", "sortfield")
        assertOK(response);
                ", version=" + version +
            int numDocsOnNewPrimary = 0;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            nodes.getNewNodes().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {
        request.addParameter("preference", preference);
            logger.info("indexing [{}] docs after setting number of replicas to 0", numberOfDocsAfterDroppingReplicas);
        assertThat(actualCount, equalTo(expectedCount));
        }
            requestOptionsBuilder.setWarningsHandler(warnings -> warnings.equals(warningMsg) == false);
        return "  \"properties\": {\n"
                ", nodeName='" + nodeName + '\'' +
            .putList("index.sort.field", "sortfield")
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
import java.util.List;
                ", Primary=" + Primary +
        Nodes nodes = buildNodeAndVersions();
        Request request = new Request("GET", index + "/_doc/" + docId);
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        }
            final SeqNoStats seqNoStats;
        public String toString() {
        Settings.Builder settings = Settings.builder()
        request.addParameter("wait_for_completion", "true");
            assertSeqNoOnShards(index, nodes, numDocs, newNodeClient);
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
    protected static final Version UPGRADE_FROM_VERSION = Version.fromString(System.getProperty("tests.upgrade_from_version"));
        }
    private List<Shard> buildShards(String index, Nodes nodes, RestClient client) throws IOException {
        // Create the repository before taking the snapshot.
 * SPDX-License-Identifier: Apache-2.0
        ArrayList<Shard> shards = new ArrayList<>();
import org.opensearch.common.xcontent.json.JsonXContent;
        for (Thread indexThread : indexThreads) {
        for (int i = 0; i < nUpdates; i++) {
        createIndex(index, Settings.builder()
public class IndexingIT extends OpenSearchRestTestCase {
        Nodes nodes = new Nodes();
                assertCount(index, "_only_nodes:" + shard.getNode().getNodeName(), 1);
        logger.info("cluster nodes: {}", clusterState);
    }
        request.setJsonEntity(JsonXContent.contentBuilder()
                ", seqNoStats=" + seqNoStats +
        updateIndexSettings(index, Settings.builder().putNull("index.routing.allocation.include._name"));
            logger.info("indexing docs with [{}] concurrent updates initially", nUpdates);
    public void testUpdateSnapshotStatus() throws Exception {
 * license agreements. See the NOTICE file distributed with
            this.node = node;
            logger.info("indexing [{}] docs after allowing shards on all nodes", numberOfDocsAfterAllowingShardsOnAllNodes);
            indexDocs(index, 0, docCount);
        final int minUpdates = 5;
        assumeFalse("new nodes is empty", nodes.getNewNodes().isEmpty());
        request.addParameter("level", "shards");
 *
        try (RestClient newNodeClient = buildClient(restClientSettings(),
        logger.info("cluster discovered: {}", nodes.toString());
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
                assertVersion(index, 1, "_only_nodes:" + shard.getNode().getNodeName(), finalVersionForDoc1);
        private final SeqNoStats seqNoStats;
             */
import java.util.ArrayList;
            ensureGreen(index);
            final Boolean primary = ObjectPath.evaluate(shard, "routing.primary");
        public boolean isPrimary() {
    }
            numDocs += numberOfDocsAfterMovingPrimary;
            assertThat(XContentMapValues.extractValue("indices." + index + ".total.translog.uncommitted_operations", stats), equalTo(0));
    }
            Version bwcVersion = getBWCVersion();
            assertBusy(() -> {
            shards.add(new Shard(node, primary, seqNoStats));
            // perform a refresh
    }
            ensureGreen(index);
        try (RestClient oldNodeClient = buildClient(restClientSettings(),
        Nodes nodes = buildNodeAndVersions();
        private String clusterManagerNodeId = null;
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)
            .put("index.routing.allocation.exclude._name", bwcNames);
        final String index = "test_synced_flush";
        final String bwcNames = bwcNamesList.stream().collect(Collectors.joining(","));
                nodes.getNewNodes().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        public String toString() {
            List<Shard> shards = buildShards(index, nodes, newNodeClient);
            nodes.getNewNodes().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {
        ensureNoInitializingShards(); // wait for all other shard activity to finish
                Map<String, Object> result = ObjectPath.createFromResponse(newNodeClient.performRequest(request)).evaluate("_shards");
            return "Nodes{" +
            + "      \"type\": \"integer\"\n"
            + "    \"sortfield\": {\n"
        return nodes;
