            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), between(5, 10))  
            this.id = id;  
            if (isEmpty()) {  
            put(node.getId(), node);
    public void testSeqNoCheckpoints() throws Exception {
        // Exclude bwc nodes from allocation so that primaries gets allocated on current/higher version
     * This test verifies that segment replication does not break when primary shards are on lower OS version. It does this
import org.opensearch.test.rest.OpenSearchRestTestCase;
        createIndex(index, Settings.builder()
            // perform a refresh
            assertSeqNoOnShards(index, nodes, numDocs, newNodeClient);
            throws Exception {
            final int numberOfDocsAfterAllowingShardsOnAllNodes = 1 + randomInt(5);
            }
                Version.fromString(objectPath.evaluate("nodes." + id + ".version")),
            numDocsOnNewPrimary += indexDocs(index, numDocs, numberOfDocsAfterMovingPrimary);
                '}';
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
                throw new AssertionError("unexpected io exception", e);
                .startObject()
import static org.hamcrest.Matchers.contains;
            + "  }";
            ensureGreen(index);  
            Shard primary = buildShards(index, nodes, newNodeClient).stream().filter(Shard::isPrimary).findFirst().get();  
    public void testUpdateSnapshotStatus() throws Exception {
            logger.info("setting number of replicas to 1");
        ensureGreen(index);  
            primary = shards.stream().filter(Shard::isPrimary).findFirst().get();  
        public Node getClusterManager() {
    }
            nodes.add(new Node(
        }
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            return Primary;  
            request.setJsonEntity("{\"test\": \"test_" + randomAlphaOfLength(2) + "\", \"sortfield\": \""+ randomIntBetween(0, numDocs) + "\"}");
 */
        }  
    private int indexDocs(String index, final int idStart, final int numDocs) throws IOException {
        Settings.Builder settings = Settings.builder()  
        int docCount = 200;
        final int actualVersion = Integer.parseInt(ObjectPath.createFromResponse(response).evaluate("_version").toString());
            nUpdates = randomIntBetween(minUpdates, maxUpdates);
import java.io.IOException;
            assertSeqNoOnShards(index, nodes, docCount, nodeClient);  
import org.apache.hc.core5.http.io.entity.EntityUtils;
        private final String nodeName;
     */
        request.addParameter("wait_for_completion", "true");  
        indexDocs(index, randomIntBetween(0, 100), between(1, 100));
            this.version = version;
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 1));
    /**
        Nodes nodes = buildNodeAndVersions();  
            this.seqNoStats = seqNoStats;
        Nodes nodes = buildNodeAndVersions();  
        public SeqNoStats getSeqNoStats() {  
    }  
        }  
            return version;
                assertThat(result.get("total"), equalTo(totalShards));
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 0));
        assertOK(response);
                assertVersion(index, 1, "_only_nodes:" + shard.getNode().getNodeName(), finalVersionForDoc1);  
                throw new IllegalArgumentException("node with id [" + id + "] not found. got:" + toString());
                .endObject().toString());
                assertCount(index, "_only_nodes:" + shard.getNode().getNodeName(), 2);
            logger.info("indexing doc with [{}] concurrent updates after setting number of replicas to 1", nUpdates);
            + "      \"type\": \"integer\"\n"
            Node node = get(id);
        public Version getBWCVersion() {
        Request request = new Request("GET", index + "/_stats");
            indexThreads[i].start();
import org.opensearch.common.xcontent.json.JsonXContent;
        final String bwcNames = bwcNamesList.stream().collect(Collectors.joining(","));
            assertSeqNoOnShards(index, nodes, numDocs, newNodeClient);  
            clusterManagerNodeId = id;  
     * <code>nUpdates</code> times
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
    public void testIndexingWithPrimaryOnBwcNodes() throws Exception {
            .put("index.routing.allocation.include._name", bwcNames);  
        int docCount = 200;
        final List<String> bwcNamesList = nodes.getBWCNodes().stream().map(Node::getNodeName).collect(Collectors.toList());
    }  
        }
        assumeFalse("new nodes is empty", nodes.getNewNodes().isEmpty());
            logger.info("Remove allocation include settings so that shards can be allocated on current version nodes");
            .putList("index.sort.field", "sortfield")
            return "Shard{" +  
                assertThat(result.get("successful"), equalTo(totalShards));  
        final String index = "test-index";  
                Shard primaryShard = shards.stream().filter(Shard::isPrimary).findFirst().get();
        Nodes nodes = buildNodeAndVersions();  
    final class Shard {
                .putList("index.sort.field", "sortfield")
    public void testIndexingWithReplicaOnBwcNodes() throws Exception {  
        assumeFalse("new nodes is empty", nodes.getNewNodes().isEmpty());  
            numDocs += numberOfDocsAfterDroppingReplicas;
        }
        for (int i = 0; i < nUpdates; i++) {
            final Node node = nodes.getSafe(nodeId);
            nodes.getBWCNodes().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {  
            final int numberOfDocsAfterDroppingReplicas = 1 + randomInt(5);
             * the recovery code.  
        return numDocs;
                '}';
            nUpdates = randomIntBetween(minUpdates, maxUpdates);
            assertThat(XContentMapValues.extractValue("indices." + index + ".total.translog.uncommitted_operations", stats), equalTo(0));
            Version bwcVersion = getBWCVersion();
        // Allocating shards on the BWC nodes to makes sure that taking snapshot happens on those nodes.
            assertSeqNoOnShards(index, nodes, docCount, nodeClient);
                        .field("compress", randomBoolean())
            return "Nodes{" +
        Settings.Builder settings = Settings.builder()
        for (int i = 0; i < numDocs; i++) {
                }
                Map<String, Object> result = ObjectPath.createFromResponse(newNodeClient.performRequest(request)).evaluate("_shards");
        nodes.setClusterManagerNodeId(ObjectPath.createFromResponse(response).evaluate("master_node"));
        @Override
                assertCount(index, "_only_nodes:" + shard.node.nodeName, numDocs);
import org.apache.hc.core5.http.HttpHost;  
                    assertThat("max_seq no on " + shard.getNode() + " is wrong", seqNoStats.getMaxSeqNo(), equalTo(expectMaxSeqNo));
            final SeqNoStats seqNoStats;
        }
            numDocs += numberOfDocsAfterMovingPrimary;
    }
            for (Shard shard : buildShards(index, nodes, newNodeClient)) {
                "This transition will be removed in a future version.");
import org.apache.hc.core5.http.ParseException;
                    assertThat("globalCheckpoint no on " + shard.getNode() + " is wrong",
            request.setOptions(requestOptionsBuilder);
            logger.info("moving primary to new node by excluding {}", primary.getNode().getNodeName());
            logger.info("moving primary to new node by excluding {}", primary.getNode().getNodeName());
                List<Shard> shards = buildShards(index, nodes, client);
     *
        for (String id : nodesAsMap.keySet()) {  
import java.util.List;  
    public void testIndexVersionPropagation() throws Exception {
            assertOK(client().performRequest(request));  
            ensureGreen(index);
            logger.info("indexing [{}] docs after moving primary", numberOfDocsAfterMovingPrimary);  
            + "    \"test\": {\n"
        Request request = new Request("GET", index + "/_doc/" + docId);  
                throw new IllegalStateException("no nodes available");
 * ownership. Elasticsearch licenses this file to you under  
        private final Node node;  
                objectPath.evaluate("nodes." + id + ".name"),  
        }
        createIndex(index, settings.build(), TEST_MAPPING);  
        ensureGreen(index);  
            updateIndexSettings(index, Settings.builder().putNull("index.routing.allocation.include._name"));  
                    contains("Synced flush is deprecated and will be removed in 3.0. Use flush at _/flush or /{index}/_flush instead."));  
import org.opensearch.cluster.metadata.IndexMetadata;  
        }
        final String index = "test-index";
        Thread[] indexThreads = new Thread[nUpdates];
        indexDocs(index, 0, between(50, 100));
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 2));
        public String toString() {
        logger.info("shards {}", shards);  
                final long expectMaxSeqNo = numDocs - 1;
            shards = buildShards(index, nodes, newNodeClient);
            shards.add(new Shard(node, primary, seqNoStats));
import org.opensearch.indices.replication.common.ReplicationType;
        request.addParameter("preference", preference);
        public String toString() {  
            if (get(id) == null) {  
            });
                    throw new AssertionError("failed while indexing [" + e.getMessage() + "]");
        try (RestClient oldNodeClient = buildClient(restClientSettings(),
            numDocsOnNewPrimary += indexDocs(index, numDocs, numberOfDocsAfterDroppingReplicas);  
        updateIndexSettings(index, Settings.builder().putNull("index.routing.allocation.include._name"));
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
 * this file be licensed under the Apache-2.0 license or a
            for (Shard shard : shards) {
        public Node getSafe(String id) {  
        logger.info("cluster discovered:\n {}", nodes.toString());
            for (Shard shard : shards) {  
        indexDocs(index, docId, 1);  
            int numDocs = 0;
        assertOK(client().performRequest(request));
        return shards;
        try (RestClient newNodeClient = buildClient(restClientSettings(),
    private void assertVersion(final String index, final int docId, final String preference, final int expectedVersion) throws IOException {
        logger.info("cluster discovered: {}", nodes.toString());
        createIndex(index, settings.build(), TEST_MAPPING);  
            logger.info("primary resolved to: " + primary.getNode().getNodeName());
    }  
            final int numberOfDocsAfterMovingPrimary = 1 + randomInt(5);
     * replica shard allocation on lower OpenSearch version is prevented. Thus, this test though cover the use case where  
            /*
            logger.info("allowing shards on all nodes");
                assertThat(responseException.getResponse().getStatusLine().getStatusCode(), equalTo(RestStatus.CONFLICT.getStatus()));
            nodes.getNewNodes().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {  
            ensureGreen(index);
        assumeTrue("bwc version is on 1.x or Legacy 7.x", nodes.getBWCVersion().before(Version.V_2_0_0));
                    .field("type", "fs")
        }
            return nodeName;
        }
        String clusterState = EntityUtils.toString(client().performRequest(clusterStateRequest).getEntity()).trim();
        final String bwcNames = bwcNamesList.stream().collect(Collectors.joining(","));  
        public String getId() {  
        public List<Node> getBWCNodes() {  
            } catch (IOException e) {
            .put("index.routing.allocation.include._name", newNodes).build(), TEST_MAPPING);
            return get(clusterManagerNodeId);
            for (Shard shard : shards) {
        // Create the repository before taking the snapshot.
                id,
import java.util.Map;
            assertSeqNoOnShards(index, nodes, numDocs, newNodeClient);  
        assumeFalse("no new node found", nodes.getNewNodes().isEmpty());
        createIndex(index, settings.build(), TEST_MAPPING);  
 * this work for additional information regarding copyright
                assertCount(index, "_only_nodes:" + bwcName, numDocs);  
            RequestOptions.Builder requestOptionsBuilder = RequestOptions.DEFAULT.toBuilder();  
            return;
             */
                ResponseException responseException = expectThrows(ResponseException.class, () -> oldNodeClient.performRequest(request));  
        indexDocs(index, randomIntBetween(0, 100), between(1, 100));  
        printClusterRouting();
    }
import java.util.stream.Collectors;
    /**
        Request request = new Request("GET", index + "/_count");  
        ensureGreen(index);
        Shard(Node node, boolean primary, SeqNoStats seqNoStats) {
                assertCount(index, "_only_nodes:" + shard.getNode().getNodeName(), 3);  
            Primary = primary;  
            assertThat(XContentMapValues.extractValue("indices." + index + ".total.translog.uncommitted_operations", stats), equalTo(0));
            return;  
            updateIndexSettings(index, Settings.builder().put("index.routing.allocation.exclude._name", primary.getNode().getNodeName()));  
        final int actualCount = Integer.parseInt(ObjectPath.createFromResponse(response).evaluate("count").toString());
        Map<String, Object> nodesAsMap = objectPath.evaluate("nodes");
        request.addParameter("preference", preference);
            final String nodeId = ObjectPath.evaluate(shard, "routing.node");
            logger.info("indexing docs with [{}] concurrent updates after allowing shards on all nodes", nUpdates);
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
            updateIndexSettings(index, Settings.builder().put("index.routing.allocation.exclude._name", primary.getNode().getNodeName()));
            final int finalVersionForDoc4 = indexDocWithConcurrentUpdates(index, 4, nUpdates);
                assertVersion(index, 4, "_only_nodes:" + shard.getNode().getNodeName(), finalVersionForDoc4);  
            numDocs += indexDocs(index, numDocs, numberOfDocsAfterAllowingShardsOnAllNodes);
        response = client().performRequest(new Request("GET", "_cluster/state"));
import org.opensearch.client.ResponseException;
    private static String createTestMapping() {
                assertVersion(index, 2, "_only_nodes:" + shard.getNode().getNodeName(), finalVersionForDoc2);  
        request.setJsonEntity(JsonXContent.contentBuilder()  
                    final SeqNoStats seqNoStats = shard.getSeqNoStats();
            // Index docs
            shards = buildShards(index, nodes, newNodeClient);
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
    }
            }
            final Boolean primary = ObjectPath.evaluate(shard, "routing.primary");  
                try {
        }
            // Index docs
        request = new Request("PUT", "/_snapshot/repo/bwc-snapshot");
            shards = buildShards(index, nodes, newNodeClient);  
                assertThat(result.get("total"), equalTo(totalShards));
            // verify replica catch up with primary
        int numOfReplicas = randomIntBetween(0, nodes.getNewNodes().size() - 1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            });
            nUpdates = randomIntBetween(minUpdates, maxUpdates);  
            final int finalVersionForDoc1 = indexDocWithConcurrentUpdates(index, 1, nUpdates);  
            logger.info("indexing [{}] docs after setting number of replicas to 0", numberOfDocsAfterDroppingReplicas);
        public void setClusterManagerNodeId(String id) {
        // Update allocation settings so that primaries gets allocated only on nodes running on older version
        Node(String id, String nodeName, Version version, HttpHost publishAddress) {
            indexDocs(index, 0, docCount);
            ensureGreen(index);  
     * primary shard containing nodes are running on higher OS version while replicas are unassigned.
 *
    }  
        // Allocating shards on all nodes, taking snapshots should happen on all nodes.
            }  
        private final boolean Primary;
        public String toString() {
        assertBusy(() -> {
            .putList("index.sort.field", "sortfield")
                    assertThat("localCheckpoint no on " + shard.getNode() + " is wrong",
            for (final String bwcName : bwcNamesList) {
/*
            return Version.fromId(values().stream().map(node -> node.getVersion().id).min(Integer::compareTo).get());  
            ensureGreen(index);
            Shard primary = buildShards(index, nodes, newNodeClient).stream().filter(Shard::isPrimary).findFirst().get();  
        String bwcNames = nodes.getBWCNodes().stream().map(Node::getNodeName).collect(Collectors.joining(","));
            nodes.getNewNodes().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {
            assertBusy(() -> {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.rest.RestStatus;  
            // perform a refresh
            logger.info("setting number of replicas to 1");
            for (Shard shard : shards) {
        logger.info("cluster nodes: {}", clusterState);  
 * license agreements. See the NOTICE file distributed with
            logger.info("allowing replica shards assignment on bwc nodes");
            logger.info("setting number of replicas to 0");
        }
     * @return the document version after updates  
        request.addParameter("wait_for_completion", "true");
            indexThread.join();
        final List<String> bwcNamesList = nodes.getBWCNodes().stream().map(Node::getNodeName).collect(Collectors.toList());
import org.opensearch.test.rest.yaml.ObjectPath;
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 2));
        assumeFalse("new nodes is empty", nodes.getNewNodes().isEmpty());  
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)  
            Map<String, Object> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));  
                nodes.getNewNodes().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {
        Nodes nodes = new Nodes();
import org.opensearch.common.xcontent.support.XContentMapValues;  
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                "masterNodeId='" + clusterManagerNodeId + "'\n" +
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), numShards)
            updateIndexSettings(index, Settings.builder().putNull("index.routing.allocation.include._name"));
            nodes.values().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {  
 * The OpenSearch Contributors require contributions made to  
        final String index = "test";
        }
        List<Object> shardStats = ObjectPath.createFromResponse(response).evaluate("indices." + index + ".shards.0");
        final Response response = client().performRequest(request);
            }
        final String index = "test_synced_flush";  
            updateIndexSettings(index, Settings.builder().putNull("index.routing.allocation.exclude._name"));  
        return "  \"properties\": {\n"  
        request = new Request("PUT", "/_snapshot/repo/mixed-snapshot");  
                    logger.info("stats for {}, primary [{}]: [{}]", shard.getNode(), shard.isPrimary(), seqNoStats);  
        }
            if (node == null) {
                assertThat(responseException.getResponse().getWarnings(),
        }
import java.util.ArrayList;  
            return values().stream().filter(n -> n.getVersion().after(bwcVersion)).collect(Collectors.toList());  
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.equalTo;
        // Allocate shards to new nodes then verify synced flush requests processed by old nodes/new nodes
 *
                    .startObject("settings")  
                '}';
            shards = buildShards(index, nodes, newNodeClient);
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));  
    private void printClusterRouting() throws IOException, ParseException {  
            Request request = new Request("POST", index + "/_flush/synced");
            .put("index.routing.allocation.include._name", bwcNames);
        assumeFalse("no bwc node found", nodes.getBWCNodes().isEmpty());  
    private Nodes buildNodeAndVersions() throws IOException, URISyntaxException {
            }
        Settings.Builder settings = Settings.builder()
 * GitHub history for details.
                throw new IllegalArgumentException("node with id [" + id + "] not found");  
            Request request = new Request("POST", index + "/_flush/synced");  
        for (Thread indexThread : indexThreads) {  
        }
            .put("index.routing.allocation.exclude._name", bwcNames);
        logger.info("cluster discovered: {}", nodes.toString());
 *  
        assertOK(client().performRequest(new Request("POST", index + "/_refresh")));  
            Integer globalCheckpoint = ObjectPath.evaluate(shard, "seq_no.global_checkpoint");
            // Add replicas so that it can be assigned on higher OS version nodes.
                ", seqNoStats=" + seqNoStats +  
        public boolean isPrimary() {
import java.util.Arrays;
            nUpdates = randomIntBetween(minUpdates, maxUpdates);
        }
            assertBusy(() -> {
            final int numberOfInitialDocs = 1 + randomInt(5);  
        Nodes nodes = buildNodeAndVersions();
        }  
 * compatible open source license.
            return id;
        final List<String> bwcNamesList = nodes.getBWCNodes().stream().map(Node::getNodeName).collect(Collectors.toList());  
                assertCount(index, "_only_nodes:" + shard.getNode().getNodeName(), 4);
        Nodes nodes = buildNodeAndVersions();
    }
import org.opensearch.client.Response;  
        final int minUpdates = 5;
    }
            }  
            final int id = idStart + i;  
                ", nodeName='" + nodeName + '\'' +
            Integer maxSeqNo = ObjectPath.evaluate(shard, "seq_no.max_seq_no");  
        try (RestClient nodeClient = buildClient(restClientSettings(),
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
             * Dropping the number of replicas to zero, and then increasing it to one triggers a recovery thus exercising any BWC-logic in
        request.setJsonEntity("{\"indices\": \"" + index + "\"}");
            numDocs += indexDocs(index, 0, numberOfInitialDocs);
            .putList("index.sort.field", "sortfield")
        ObjectPath objectPath = ObjectPath.createFromResponse(response);  
            List<String> warningMsg = Arrays.asList("Synced flush was removed and a normal flush was performed instead. " +
        int totalShards = numShards * (numOfReplicas + 1);
            printClusterRouting();
            int nUpdates = randomIntBetween(minUpdates, maxUpdates);
                assertVersion(index, 5, "_only_nodes:" + shard.getNode().getNodeName(), finalVersionForDoc5);
            + "      \"type\": \"text\"\n"
        public Node getNode() {
import org.opensearch.Version;  
            }
            updateIndexSettings(index, Settings.builder().putNull("index.routing.allocation.include._name"));
        });
        final String bwcNames = bwcNamesList.stream().collect(Collectors.joining(","));  
            seqNoStats = new SeqNoStats(maxSeqNo, localCheckpoint, globalCheckpoint);  
            ensureGreen(index);
        if (UPGRADE_FROM_VERSION.before(Version.V_2_4_0)) {
        }
    private void assertCount(final String index, final String preference, final int expectedCount) throws IOException {
 */
                "node=" + node +
            .putList("index.sort.field", "sortfield")  
        @Override
     * This test creates a cluster with primary on higher version but due to {@link org.opensearch.cluster.routing.allocation.decider.NodeVersionAllocationDecider};
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
                assertNotNull("failed to find primary shard", primaryShard);  
            assertSeqNoOnShards(index, nodes, numDocs, newNodeClient);
            .putList("index.sort.field", "sortfield")
        return nUpdates + 1;  
            // verify replica catch up with primary
        final String index = "test-snapshot-index";
        private final HttpHost publishAddress;  
                Map<String, Object> result = ObjectPath.createFromResponse(responseException.getResponse()).evaluate("_shards");
        assumeFalse("new nodes is empty", nodes.getNewNodes().isEmpty());  
/*  
        try (RestClient newNodeClient = buildClient(restClientSettings(),
        final int maxUpdates = 10;
import org.opensearch.client.Request;
        Settings.Builder settings = Settings.builder()
        ArrayList<Shard> shards = new ArrayList<>();  
    final class Node {
            Version bwcVersion = getBWCVersion();
            this.node = node;
                        seqNoStats.getLocalCheckpoint(), equalTo(expectMaxSeqNo));  
            logger.info("indexing [{}] docs initially", numberOfInitialDocs);
            return node;
        private String clusterManagerNodeId = null;
                .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        public List<Node> getNewNodes() {
        request.addParameter("level", "shards");  
            logger.info("indexing docs with [{}] concurrent updates after moving primary", nUpdates);  
        private final SeqNoStats seqNoStats;
        Nodes nodes = buildNodeAndVersions();
 * SPDX-License-Identifier: Apache-2.0
            List<Shard> shards = buildShards(index, nodes, newNodeClient);
        try (RestClient nodeClient = buildClient(restClientSettings(),
            return values().stream().filter(n -> n.getVersion().equals(bwcVersion)).collect(Collectors.toList());
        public void add(Node node) {  
 * software distributed under the License is distributed on an
import java.net.URISyntaxException;
                HttpHost.create((String)objectPath.evaluate("nodes." + id + ".http.publish_address"))));
        }  
        createIndex(index, settings.build(), TEST_MAPPING);
        }
                    indexDocs(index, docId, 1);
import java.util.HashMap;
        String newNodes = nodes.getNewNodes().stream().map(Node::getNodeName).collect(Collectors.joining(","));
package org.opensearch.backwards;
                }  
        return nodes;  
        try (RestClient newNodeClient = buildClient(restClientSettings(),  
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                assertCount(index, "_only_nodes:" + shard.getNode().getNodeName(), 5);
            return "Node{" +  
        final String index = "indexversionprop";  
            ensureGreen(index);  
        @Override
                ", Primary=" + Primary +
            logger.info("allowing shards on all nodes");
        assumeFalse("new nodes is empty", nodes.getNewNodes().isEmpty());
            try {  
            logger.info("indexing [{}] docs after allowing shards on all nodes", numberOfDocsAfterAllowingShardsOnAllNodes);  
            assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
                logger.info("primary resolved to node {}", primaryShard.getNode());  
            indexThreads[i] = new Thread(() -> {  
            }
     */  
            return seqNoStats;
 * under the License.  
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            return node;
            final int finalVersionForDoc3 = indexDocWithConcurrentUpdates(index, 3, nUpdates);
        }
                assertThat(result.get("failed"), equalTo(totalShards));
                assertThat(result.get("failed"), equalTo(0));
     * Indexes a document in <code>index</code> with <code>docId</code> then concurrently updates the same document  
        createIndex(index, settings.build(), TEST_MAPPING);
        logger.info("cluster discovered:\n {}", nodes.toString());
            }  
        Request clusterStateRequest = new Request("GET", "_cluster/state/routing_nodes?pretty");
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 0));  
    }  
        }
        int numShards = randomIntBetween(1, 10);  
            Map<String, Object> stats = entityAsMap(client().performRequest(new Request("GET", index + "/_stats?level=shards")));  
import org.opensearch.index.seqno.SeqNoStats;
 * not use this file except in compliance with the License.
        private final Version version;
            logger.info("--> Skip test for version {} where segment replication feature is not available", UPGRADE_FROM_VERSION);  
                values().stream().map(Node::toString).collect(Collectors.joining("\n")) +  
            }
     * by verifying replica shards contains same number of documents as primary's.
        logger.info("cluster discovered: {}", nodes.toString());
        private final String id;  
        }  
    /**  
    private void assertSeqNoOnShards(String index, Nodes nodes, int numDocs, RestClient client)  
        Response response = client().performRequest(new Request("GET", "_nodes"));
 * You may obtain a copy of the License at  
            + "    }\n"  
        }
        }
            assertOK(client().performRequest(new Request("POST", index + "/_flush")));  
    }
            assertOK(client().performRequest(new Request("POST", index + "/_flush")));
        }
        for (Object shard : shardStats) {
    }  
        assertOK(client().performRequest(request));  
        public HttpHost getPublishAddress() {
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat("version mismatch for doc [" + docId + "] preference [" + preference + "]", actualVersion, equalTo(expectedVersion));  
            + "    },\n"  
            });  
            final int finalVersionForDoc5 = indexDocWithConcurrentUpdates(index, 5, nUpdates);  
    public void testSyncedFlushTransition() throws Exception {
            primary = shards.stream().filter(Shard::isPrimary).findFirst().get();
            logger.info("setting number of replicas to 0");  
            logger.info("indexing doc with [{}] concurrent updates after setting number of replicas to 0", nUpdates);
 * KIND, either express or implied.  See the License for the
        ensureNoInitializingShards(); // wait for all other shard activity to finish
}  
        final String bwcNames = bwcNamesList.stream().collect(Collectors.joining(","));  
        assertThat(actualCount, equalTo(expectedCount));
    }
     */
        }
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
    private int indexDocWithConcurrentUpdates(String index, final int docId, int nUpdates) throws IOException, InterruptedException {
                ", version=" + version +  
    final class Nodes extends HashMap<String, Node> {  
            ensureGreen(index);  
 * Licensed to Elasticsearch under one or more contributor  
                assertCount(index, "_only_nodes:" + shard.getNode().getNodeName(), 1);
                assertThat(result.get("successful"), equalTo(0));  
    }  
 * specific language governing permissions and limitations
            int numDocsOnNewPrimary = 0;
                        seqNoStats.getGlobalCheckpoint(), equalTo(expectedGlobalCkp));
            nodes.getNewNodes().stream().map(Node::getPublishAddress).toArray(HttpHost[]::new))) {
        assertOK(client().performRequest(new Request("POST", index + "/_refresh")));
                    .endObject()  
                .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 2)  
    }
        final List<String> bwcNamesList = nodes.getBWCNodes().stream().map(Node::getNodeName).collect(Collectors.toList());
                "id='" + id + '\'' +
        ensureNoInitializingShards(); // wait for all other shard activity to finish
/*
        Request request = new Request("PUT", "/_snapshot/repo");
            logger.info("--> Skip test for version {} where segment replication feature is not available", UPGRADE_FROM_VERSION);
                for (Shard shard : shards) {
            return publishAddress;  
            logger.info("indexing docs with [{}] concurrent updates initially", nUpdates);
import org.opensearch.client.RestClient;
            .put("index.routing.allocation.include._name", bwcNames);
        }  
                        .field("location", System.getProperty("tests.path.repo"))
 * Unless required by applicable law or agreed to in writing,
                } catch (IOException e) {  
                final long expectedGlobalCkp = numDocs - 1;
import org.opensearch.client.RequestOptions;
            indexDocs(index, 0, docCount);  
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numOfReplicas)  
    private static final String TEST_MAPPING = createTestMapping();
    }
        }
public class IndexingIT extends OpenSearchRestTestCase {
            final int finalVersionForDoc2 = indexDocWithConcurrentUpdates(index, 2, nUpdates);  
            Request request = new Request("PUT", index + "/_doc/" + id);
                assertVersion(index, 3, "_only_nodes:" + shard.getNode().getNodeName(), finalVersionForDoc3);
            updateIndexSettings(index, Settings.builder().put("index.number_of_replicas", 1));  
    }  
        assertOK(response);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Response response = client.performRequest(request);
        final Response response = client().performRequest(request);  
            requestOptionsBuilder.setWarningsHandler(warnings -> warnings.equals(warningMsg) == false);
 */  
    protected static final Version UPGRADE_FROM_VERSION = Version.fromString(System.getProperty("tests.upgrade_from_version"));  
            Integer localCheckpoint = ObjectPath.evaluate(shard, "seq_no.local_checkpoint");
    private List<Shard> buildShards(String index, Nodes nodes, RestClient client) throws IOException {
            logger.info("primary resolved to: " + primary.getNode().getNodeName());
            this.nodeName = nodeName;
        }  
        Settings.Builder settings = Settings.builder()
            printClusterRouting();  
            }
            + "    \"sortfield\": {\n"
        public Version getVersion() {  
        public String getNodeName() {
        if (UPGRADE_FROM_VERSION.before(Version.V_2_4_0)) {
            this.publishAddress = publishAddress;  
        request.setJsonEntity("{\"indices\": \"" + index + "\"}");
            // Add replicas so that it can be assigned on lower OS version nodes, but it doesn't work as called out in test overview
                .put("index.routing.allocation.include._name", bwcNames);
            for (Shard shard : shards) {
