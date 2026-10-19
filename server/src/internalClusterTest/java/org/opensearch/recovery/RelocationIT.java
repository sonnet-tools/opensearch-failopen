            .execute()
        int numDocs = randomIntBetween(100, 200);
                    assertEquals(expectedCount, response.getHits().getTotalHits().value());
            client().admin()
        assertBusy(() -> {
        assertAcked(
            pendingIndexResponses.add(  
                }
        );
            if (!node.equals(clusterService.localNode())) {
            indexRandom(false, true, builders1);
import org.opensearch.cluster.service.ClusterService;  
    }  
        );
        String node2 = internalCluster().startNode();
                    postRecoveryShards.release();
                    .execute()  
                logger.debug("--> Allow indexer to index [{}] documents", numDocs);  
            // Let it index docCount documents
            for (int numDocs = randomIntBetween(10, 30); numDocs > 0; numDocs--) {
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;  
 * You may obtain a copy of the License at  
                if (node.equals(p_node)) {
        logger.info(
                },
        logger.info("--> flush so we have an actual index");
            prepareCreate(
        refreshAndWaitForReplication();  
                },
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
              "properties": {
                    for (ShardStats shardStat : shardStats) {  
        });
                        hitIds[hit] = hit + 1;  
        );
                    .setDoc("value", docId * 2)
            logger.info("--> starting [node_{}] ...", i);  
            // verify cluster was finished.
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("3").setWaitForGreenStatus().get().isTimedOut());
        int numDocs = randomIntBetween(100, 150);  
              }
        String[] blueNodes = nodes.subList(0, halfNodes).stream().toArray(String[]::new);
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
 *
        // Verify all documents including those in translog  
        public void sendRequest(
                    .execute()
            ).setMapping(mapping)  
import org.opensearch.cluster.routing.ShardRoutingState;  
                  "type": "integer"  
        final String node_1 = internalCluster().startNode();
        }
            }  
                                        not(startsWith("recovery."))
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)  
            client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).get();
import java.nio.file.FileVisitResult;
        for (int i = 0; i < numDocs; i++) {
            .cluster()
            {  
    public void testRelocateWhileWaitingForRefresh() {  
import org.opensearch.common.Priority;
        for (String node : internalCluster().getNodeNames()) {
import java.util.Collection;
    }
        int numDocs = randomIntBetween(100, 200);
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).get();  
                for (List<ShardStats> shardStats : byShardId.values()) {
        client().admin()
        int numberOfReplicas = randomBoolean() ? 0 : 1;
                .put("index.number_of_replicas", numberOfReplicas)  
            }
            initialDocCountLatch.await();
                                                                                                                                     // want  
            // Expected failure
                }
            indexRandom(true, true, builders2);  
                    logger.debug("--> flushing");
        final Set<Integer> docsToUpdate = new HashSet<>();
        for (MockIndexEventListener.TestEventListener eventListener : internalCluster().getInstances(
    public RelocationIT(Settings settings) {
        }
        for (Thread searchThread : searchThreads) {
            pendingIndexResponses.add(
                    .cluster()
        int updateCount = randomIntBetween(10, numDocs / 2);
        for (int i = numDocs; i < numDocs + numTranslogDocs; i++) {  
                "value": {
        int numDocs = scaledRandomIntBetween(200, 2500);
import org.opensearch.index.mapper.MapperService;
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        logger.info("--> starting [node1] ...");
                    .put("index.derived_source.enabled", true)  
                  "type": "integer"  
                    }
                .setSize(totalDocCount.get())  
                        .collect(Collectors.toSet());
        super.beforeIndexDeletion();
            .setWaitForEvents(Priority.LANGUID)
        }
            boolean ranOnce = false;
                    .get()
    private void assertActiveCopiesEstablishedPeerRecoveryRetentionLeases() throws Exception {  
            .prepareHealth()
        for (int i = 0; i < numberOfRelocations; i++) {
                    .setWaitForGreenStatus()
        prepareCreate("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0)).get();
        for (int i = 0; i < numDocs; i++) {  
                ranOnce = true;
            ensureGreen(TimeValue.timeValueMinutes(2));  
            .put("index.routing.allocation.exclude.color", "red")  
    public void testRelocationWhileIndexingRandom() throws Exception {
import org.opensearch.core.index.shard.ShardId;
        int nodeShiftBased = numberOfReplicas; // if we have replicas shift those  
import org.opensearch.cluster.ClusterState;  
    @Override  
        for (int i = 0; i < numDocs; i++) {
            }  
            logger.info("--> starting relocations...");
 * Modifications Copyright OpenSearch Contributors. See
                }
            .execute();
                            .stream()
        ensureStableCluster(halfNodes * 2);  
        logger.info("blue nodes: {}", (Object) blueNodes);
                .setQuery(matchAllQuery())
            // Assert few documents
 * compatible open source license.
        logger.info("--> relocate the shard from node1 to node2");
        int numberOfRelocations = scaledRandomIntBetween(1, rarely() ? 10 : 4);
        }  
        ClusterHealthResponse clusterHealthResponse = client().admin()
                            throw new AssertionError("failed to walk file tree starting at [" + shardLoc + "]", e);
        });
    private final TimeValue ACCEPTABLE_RELOCATION_TIME = new TimeValue(5, TimeUnit.MINUTES);
        }
 * Licensed to Elasticsearch under one or more contributor  
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
            Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).put("index.refresh_interval", -1) // we
        try {
        assertAcked(  
        )) {
            @Override
    @ParametersFactory  
            {  
                    .isTimedOut()
            if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {  
                "test",
        client().admin().indices().prepareFlush().execute().actionGet();
            refreshAndWaitForReplication("test");
        assertActiveCopiesEstablishedPeerRecoveryRetentionLeases();  
                    .actionGet();
        // Start second node but block recovery
            "test",  
    @Override
        logger.info("--> relocate the shard from node1 to node2");
import org.opensearch.transport.TransportRequest;
        for (int i = 20; i < 120; i++) {  
        indexRandom(true, requests);
        int numDocs = randomIntBetween(100, 200);
        assertAcked(prepareCreate("test", settings));  
            }  
            for (int i = 0; i < Math.min(totalDocCount.get(), 50); i++) {  
                assertThat(
                .setId(Integer.toString(i))
        SearchResponse response = client().prepareSearch("test").setQuery(matchAllQuery()).setSize(numDocs).get();
            logger.info(" --> checking iteration {}", i);
        // Index some documents
        String node1 = internalCluster().startNode();
import java.util.HashSet;  
            .prepareHealth()  
        logger.info("--> stopping replica assignment");  
        flush();  
                  "type": "keyword"  
            Stream.generate(() -> Settings.builder().put("node.attr.color", "red").build()).limit(halfNodes)
        Settings[] nodeSettings = Stream.concat(
            .actionGet();
            .execute()  
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node_1, node_2)).execute().actionGet();  
                  "type": "keyword"  
                }
                    .setSize((int) indexer.totalIndexedDocs())  
        for (int i = 2; i <= numberOfNodes; i++) {  
            .prepareHealth()
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));  
            }
                    .execute()
                }
        for (DiscoveryNode node : clusterService.state().nodes()) {
                assertThat(healthResponse.isTimedOut(), equalTo(false));
                    .setWaitForNodes(Integer.toString(i + 1))
    public static Collection<Object[]> parameters() {
            .actionGet();
                        try {
        internalCluster().assertSameDocIdsOnShards();
            List<IndexRequestBuilder> builders2 = new ArrayList<>();  
        assertThat(client().prepareSearch("test").setSize(0).execute().actionGet().getHits().getTotalHits().value(), equalTo(120L));
                    .prepareHealth()
                if (currentState == IndexShardState.POST_RECOVERY) {  
        assertActiveCopiesEstablishedPeerRecoveryRetentionLeases();  
                    .setWaitForEvents(Priority.LANGUID)
            int toNode = fromNode == 0 ? 1 : 0;  
        // Verify documents are still accessible on original node  
                toNode += nodeShiftBased;
                ClusterHealthResponse healthResponse = client().admin()  
        logger.info("--> creating test index ...");
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, p_node);
        for (int i = 0; i < numDocs; i++) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
        @Override
import java.util.concurrent.CountDownLatch;
            Map<String, Object> source = hit.getSourceAsMap();  
        }
            .put("index.routing.allocation.include.color", "blue")
                    .actionGet();
                    .cluster()
                .indices()  
            client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, nodes[fromNode], nodes[toNode])).get();
            settings.put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomIntBetween(1, 10) + "s");
            client().prepareIndex("test")
                numDocs = scaledRandomIntBetween(200, 1000);
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
            }
            numberOfNodes
            numberOfNodes  
                .put("index.refresh_interval", -1)
        ).get();  
            }  
            logger.info("--> starting [node{}] ...", i);
                    logger.debug("corrupting [{}] to {}. file name: [{}]", action, connection.getNode(), chunkRequest.name());
        for (int i = 0; i < numDocs; i++) {
        CountDownLatch initialDocCountLatch = new CountDownLatch(initialDocCount);
        logger.info("--> index more docs so we have something in the translog");
                .put("index.number_of_replicas", 0)  
            logger.info("--> START relocate the shard from {} to {}", nodes[fromNode], nodes[toNode]);
import org.opensearch.index.shard.IndexShardState;  
                .get();
            Stream.generate(() -> Settings.builder().put("node.attr.color", "blue").build()).limit(halfNodes),  
            ids.add(id);  
            Transport.Connection connection,  
        assertBusy(() -> assertAllShardsOnNodes(indexName, blueNodes));  
        }  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    equalTo(1)
        for (int i = 0; i < 10; i++) {
            }
            .execute()
            "testRelocationWhileIndexingRandom(numRelocations={}, numberOfReplicas={}, numberOfNodes={})",
                    continue;
    public void testSimpleRelocationNoIndexing() {
        }  
                    .setTimeout("30s")  
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, node1);
                )
            indexer.stopAndAwaitStopped();
            }
              }
            SearchResponse response = client().prepareSearch("test").setQuery(matchAllQuery()).setSize(numDocs).get();
                            logger.error("Extra id [{}]", id);  
        ClusterHealthResponse clusterHealthResponse = client().admin()
    public void testRelocationWithDerivedSourceAndConcurrentIndexing() throws Exception {
        }
            if (i != numberOfNodes) {  
                    .setQuery(matchAllQuery())
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
import java.io.IOException;  
                int fromNode = (i % 2);
 * this file be licensed under the Apache-2.0 license or a
            while (stopIndexing.get() == false) {
            fromNode += nodeShiftBased;
                Settings.builder()  
                assertEquals(Integer.parseInt(id), source.get("value"));
        ).toArray(Settings[]::new);
            }
        int numberOfRelocations = scaledRandomIntBetween(1, rarely() ? 10 : 4);  
                "value": {  
                .get();
                while (stopped.get() == false) {  
        int numDocs = randomIntBetween(100, 200);
        ActionFuture<ClusterRerouteResponse> relocationListener = client().admin()  
            .setWaitForNoRelocatingShards(true)  
        String node1 = internalCluster().startNode();  
                    .execute()
                },
        // Start indexing
    public void testRelocationWithDerivedSourceWithUpdates() throws Exception {  
        }  
                .addSort("value", SortOrder.ASC)  
        assertActiveCopiesEstablishedPeerRecoveryRetentionLeases();
                    Set<String> expectedLeaseIds = shardStats.stream()  
                        .map(s -> ReplicationTracker.getPeerRecoveryRetentionLeaseId(s.getShardRouting()))
            logger.info("--> waiting for {} docs to be indexed ...", numDocs);  
            }""";
            .setWaitForEvents(Priority.LANGUID)
        String[] redNodes = nodes.subList(halfNodes, nodes.size()).stream().toArray(String[]::new);  
                    }
            .setWaitForNoRelocatingShards(true)
    }  
                "value": {
        flush();
        indexRandom(true, docs);  
                    Thread.yield(); // Small delay to prevent overwhelming  
        }
            for (SearchHit hit : response.getHits()) {
 * this work for additional information regarding copyright
import org.opensearch.cluster.metadata.IndexMetadata;
        final String node2 = internalCluster().startNode();  
                    .put("index.number_of_shards", 1)
            MockIndexEventListener.TestEventListener.class  
import java.nio.file.Files;
 * ownership. Elasticsearch licenses this file to you under  
            if (indexingThread.isAlive()) {
                int id = randomIntBetween(1, totalDocCount.get());
        });  
                "name": {
        }
        ensureGreen("test");
            List<IndexRequestBuilder> builders1 = new ArrayList<>();
                    internalCluster().getInstance(TransportService.class, node.getName()),
                                    return FileVisitResult.CONTINUE;
                }
            refresh();  
        logger.info("--> flush so we have an actual index");  
import org.opensearch.test.transport.StubbableTransport;
    protected void beforeIndexDeletion() throws Exception {
        int halfNodes = randomIntBetween(1, 3);
        String nodeId = state.routingTable().index(idx).shard(0).primaryShard().currentNodeId();  
        assertAcked(
                            Files.walkFileTree(shardLoc, new SimpleFileVisitor<Path>() {
        // index while relocating
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).execute().actionGet();  
                    state.getRoutingTable().index(indexName).shardsWithState(ShardRoutingState.UNASSIGNED).size(),
            .prepareHealth()
import org.opensearch.common.Nullable;
            indexingThread.join();
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        logger.info("--> creating test index with derived source enabled");
        refresh();
import org.opensearch.indices.recovery.FileChunkRequest;
                "value": {
import org.opensearch.action.admin.indices.stats.ShardStats;
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)  
        logger.info("--> start another node");  
                    .setWaitForEvents(Priority.LANGUID)
                client().prepareUpdate("test", String.valueOf(docId))
                Settings.builder()  
                    .actionGet()  
            .cluster()  
            .prepareUpdateSettings(indexName)  
        client().admin().indices().prepareFlush().execute().actionGet();
            .get();  
    public Settings indexSettings() {  
        });  
        super(settings);  
                    .put("index.derived_source.enabled", true)  
        String node2 = internalCluster().startNode();  
                .setSource("field", "value" + i)
    }
                .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)  
            SearchResponse response = client().prepareSearch("test")  
              "properties": {
            .put(super.indexSettings())
 */  
            .put(indexSettings())
    }  
                    .put("index.number_of_replicas", 0)
        logger.info("--> wait for all replica shards to be removed, on all nodes");
        ensureGreen();
                client().prepareIndex("test")
    }  
        String node1 = internalCluster().startNode();
        client().admin()
import org.opensearch.search.SearchHit;
import org.opensearch.action.search.SearchResponse;
            TransportRequest request,  
              "properties": {
                logger.warn("Error while updating doc with id = {}", docId, e);
        for (int i = 0; i < searchThreads.length; i++) {
                    .actionGet();  
 * specific language governing permissions and limitations
            if (ranOnce == false) {  
        ).toArray(Settings[]::new);  
                  "type": "keyword"  
        // Start relocation
        }
            } else {  
                String id = hit.getId();
                SearchHits hits = client().prepareSearch("test")
}  
                FileChunkRequest chunkRequest = (FileChunkRequest) request;
            .cluster()  
        logger.info("--> index 10 docs");  
            }
            String id = hit.getId();
                client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, nodes[fromNode], nodes[toNode])).get();  
                    .put("index.derived_source.enabled", true)
                                    assertThat(
                    .put("index.number_of_shards", 1)
                                @Override  
                    .put("index.number_of_shards", 1)
 * under the License.  
                    .put("index.number_of_shards", 1)
            .setWaitForEvents(Priority.LANGUID)
            .actionGet();  
import org.opensearch.common.settings.Settings;
                    .put("index.number_of_replicas", 0)  
                        .put("index.routing.allocation.include.color", "blue")
        logger.info("--> creating test index ...");
import org.opensearch.index.IndexSettings;  
            try {
                    .cluster()  
        int numTranslogDocs = randomIntBetween(50, 100);
                    .cluster()
                                                                                                                                     // to
            numberOfRelocations,  
import org.opensearch.search.SearchHits;
    }
            indexingThread.start();  
        nodes[0] = internalCluster().startNode();
        corruptionCount.await();
import static org.hamcrest.Matchers.not;
        // Verify all documents after relocation  
 *  
                    for (SearchHit hit : hits.getHits()) {  
            .setSettings(Settings.builder().put("index.routing.allocation.include.color", "red"))
                    new RecoveryCorruption(corruptionCount)
        // Index some documents
                ClusterState state = client(node).admin().cluster().prepareState().setLocal(true).get().getState();
                }  
            }
                  "type": "integer"  
import org.opensearch.action.support.WriteRequest;
            }
            }
        prepareCreate(  
            int nodeShiftBased = numberOfReplicas; // if we have replicas shift those
            connection.sendRequest(requestId, action, request, options);
            .prepareReroute()
        }
        assertBusy(() -> {
            String id = randomRealisticUnicodeOfLength(10) + String.valueOf(numDocs + i);
                    .setWaitForGreenStatus()  
        final String node2 = internalCluster().startNode();
            .setWaitForEvents(Priority.LANGUID)
            searchThreads[i].start();
                .prepareUpdateSettings()
                }  
                assertEquals("test" + id, source.get("name"));
                assertEquals(id, source.get("value"));
            .setWaitForEvents(Priority.LANGUID)
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "value", i).get();
import org.opensearch.test.BackgroundIndexer;
        int numDocs = scaledRandomIntBetween(25, 250);  
            ensureGreen();
        final String node1 = internalCluster().startNode();
                .setQuery(matchAllQuery())
                    initialDocCountLatch.countDown();
            for (int i = 0; i < numberOfRelocations; i++) {  
            }
            logger.info("--> waiting for indexing threads to stop ...");  
                String id = hit.getId();
            }
                    .setId(Integer.toString(i))  
            .put("index.routing.allocation.exclude.color", "blue")  
            // sync global checkpoint quickly so we can verify seq_no_stats aligned between all copies after tests.  
                    assertEquals(Integer.parseInt(id) * 2, source.get("value")); // Verify updated value  
            docs[i] = client().prepareIndex("test").setId(id).setSource("field1", English.intToEnglish(i));
                }  
            Stream.generate(() -> Settings.builder().put("node.attr.color", "red").build()).limit(halfNodes)
        int initialDocCount = randomIntBetween(10, 100);
import org.opensearch.core.index.Index;
            } catch (Exception e) {  
                    });
                logger.info("--> START search test round {}", i + 1);  
            assertEquals(Integer.parseInt(id), source.get("value"));  
import org.opensearch.common.action.ActionFuture;  
        AtomicBoolean stopIndexing = new AtomicBoolean(false);  
        for (int i = 10; i < 20; i++) {  
        logger.info("--> index 10 docs");
                  "type": "keyword"  
            .prepareUpdateSettings(indexName)
        List<String> nodes = internalCluster().startNodes(nodeSettings);
                },
            }
 * SPDX-License-Identifier: Apache-2.0
            ) {
            for (String node : internalCluster().getNodeNames()) {  
            postRecoveryShards.acquire(1);  
        }
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));  
            .cluster()  
        List<String> nodes = internalCluster().startNodes(nodeSettings);  
        for (int i = 10; i < 20; i++) {
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "value", i).get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        refreshAndWaitForReplication();
import org.opensearch.index.seqno.RetentionLease;  
                                        file.getFileName().toString(),
                );  
        assertBusy(() -> assertAllShardsOnNodes(indexName, redNodes));
        // Start relocation
        logger.info("--> verifying count");
                logger.info("--> DONE search test round {}", i + 1);  
        try (BackgroundIndexer indexer = new BackgroundIndexer("test", MapperService.SINGLE_MAPPING_NAME, client(), numDocs)) {
              "properties": {
                assertEquals("test" + id, source.get("name"));
        ).get();
import org.opensearch.test.transport.MockTransportService;
            nodes[i] = internalCluster().startNode();
                ClusterHealthResponse healthResponse = client().admin()
                indexer.continueIndexing(numDocs);
        logger.info("--> verifying count");
        logger.info("--> relocate the shard with uncommitted translog");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        for (SearchHit hit : response.getHits()) {
                }  
                  "type": "integer"  
        relocationListener.actionGet();  
                indexingThread.interrupt();  
                    .setId(Integer.toString(i))
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                  "type": "integer"
                                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        }  
                client().admin()
                }
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, halfNodes - 1))
            for (int i = 0; i < 10; i++) {
        for (int i = 0; i < updateCount; i++) {
import org.opensearch.env.NodeEnvironment;
 * software distributed under the License is distributed on an
        client().admin().indices().prepareFlush().execute().actionGet();
            waitForDocs(numDocs, indexer);
            assertFalse(  
                Settings.builder()  
import static org.hamcrest.Matchers.equalTo;
 * the Apache License, Version 2.0 (the "License"); you may
        String[] nodes = new String[numberOfNodes];
import org.opensearch.test.MockIndexEventListener;  
                updatedDocs.add(docId);
                "name": {
                                                                                                                                     // control
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        CountDownLatch corruptionCount = new CountDownLatch(allowedFailures);
            .actionGet();
                            });  
                Map<String, Object> source = hit.getSourceAsMap();  
        String[] blueNodes = nodes.subList(0, halfNodes).toArray(new String[0]);
import java.util.Arrays;
                ClusterHealthResponse clusterHealthResponse = client().admin()
        final String p_node = internalCluster().startNode();
        clusterHealthResponse = client().admin()
                    corruptionCount.countDown();  
    }
                @Nullable IndexShardState previousState,
import org.opensearch.index.IndexService;
                "test",
    public void testRelocationFailureWithDerivedSource() throws Exception {
            assertNoFailures(afterRelocation);  
                    .put("index.number_of_replicas", 0)
        ClusterState state = client().admin().cluster().prepareState().get().getState();
            Settings.builder()
        final Set<Integer> updatedDocs = ConcurrentCollections.newConcurrentSet();  
            numberOfReplicas,
        assertEquals(node1, state.getRoutingNodes().node(nodeId).node().getName()); // Verify the allocated node of the shard
        int numberOfNodes = numberOfReplicas == 0 ? 2 : 3;  
        String mapping = """
        logger.info("red nodes: {}", (Object) redNodes);
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        logger.info("--> start another node");  
import org.opensearch.transport.client.Client;
        );
                }
                IndexShardState currentState,  
    public void testIndexSearchAndRelocateConcurrently() throws Exception {
    }  
            logger.info("--> searching the index");  
                "name": {
import org.apache.lucene.tests.util.English;
                    set.forEach(value -> logger.error("Missing id [{}]", value));  
                            .retentionLeases()
        assertAllShardsOnNodes("test", redNodes);
        internalCluster().startNode();
                throw new IOException("Simulated recovery failure");  
            indexName,
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "value", i).get();
        internalCluster().assertSeqNos();
        logger.info("--> start another node");
            .setWaitForNoRelocatingShards(true)
        logger.info(" --> moving index to new nodes");
import java.util.stream.Collectors;  
            Stream.generate(() -> Settings.builder().put("node.attr.color", "blue").build()).limit(halfNodes),
            assertHitCount(response, numDocs);  
import org.opensearch.common.util.concurrent.ConcurrentCollections;  
                }
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {  
                Map<String, Object> source = hit.getSourceAsMap();  
import org.opensearch.common.unit.TimeValue;
        // Index more docs but don't refresh (keep in translog)
import org.opensearch.index.shard.IndexEventListener;
        ensureStableCluster(halfNodes * 2);  
            assertSearchHits(afterRelocation, ids.toArray(new String[0]));
            logger.info("--> indexing threads stopped");
            client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).get();
import org.apache.lucene.index.IndexFileNames;  
        ensureGreen();  
                    .put("index.number_of_shards", 1)
        ensureGreen(TimeValue.timeValueSeconds(60), "test"); // move all shards to the new nodes (it waits on relocation)  
    }
        int numberOfReplicas = randomBoolean() ? 0 : 1;
                                                                                                                                     // refreshes  
                if (expectedCount < 0) {
            }
        ) throws IOException {
                Map<String, Object> source = response.getHits().getAt(id - 1).getSourceAsMap();
                    Settings.builder()  
                .setSettings(
            public void indexShardStateChanged(  
    }
                Settings.builder()  
        logger.info("--> blocking recoveries from primary (allowed failures: [{}])", allowedFailures);  
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")
        logger.info("--> starting [node1] ...");  
                },
        prepareCreate(
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        prepareCreate(
                try {
        logger.info("--> index more docs so we have something in the translog");  
        logger.info("--> index 10 docs");  
                Settings.builder()
            "testRelocationWhileIndexingRandom(numRelocations={}, numberOfReplicas={}, numberOfNodes={})",  
            String id = randomRealisticUnicodeOfLength(10) + String.valueOf(i);
            TransportRequestOptions options
                // we want to control refreshes
        assertHitCount(response, numDocs);  
        ClusterHealthResponse clusterHealthResponse = client().admin()
        // Index some documents
                    .setRetryOnConflict(3)  
import java.util.Map;
            toNode += nodeShiftBased;
        });
            }
                assertThat(hits.getTotalHits().value(), equalTo(indexer.totalIndexedDocs()));
        } catch (Exception e) {
            for (Client client : clients()) {
            );  
        );
                "test",  
        }  
                indexingThread.join(TimeValue.timeValueSeconds(5).millis());
        logger.info("--> relocate the shard from node1 to node2");
                } else {
            logger.debug("--> index [{}] documents", builders1.size());  
        assertHitCount(countResponse, numDocs);
                    Set<Integer> set = Arrays.stream(hitIds).boxed().collect(Collectors.toSet());
        });  
              }  
            assertHitCount(response, numDocs + numTranslogDocs);
                if (updatedDocs.contains(Integer.parseInt(id))) {
            logger.info("--> DONE relocate the shard from {} to {}", fromNode, toNode);
            .cluster()
                        : "no internal reference!!";  
            .prepareHealth()  
        }
            SearchResponse response = client().prepareSearch("test")
        }
                    for (int hit = 0; hit < indexer.totalIndexedDocs(); hit++) {
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
import java.util.concurrent.atomic.AtomicBoolean;
                    assertNoFailures(client().prepareSearch("test").setRequestCache(false).get());
        int allowedFailures = randomIntBetween(3, 5); // the default of the `index.allocation.max_retries` is 5.
        return Arrays.asList(InternalSettingsPlugin.class, MockTransportService.TestPlugin.class, MockIndexEventListener.TestPlugin.class);  
                if (hits.getTotalHits().value() != indexer.totalIndexedDocs()) {  
        });
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
            if (i != numberOfNodes - 1) {
        for (int i = 0; i < numIters; i++) {  
                );  
import java.util.List;
import java.util.concurrent.TimeUnit;  
            }  
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));  
        logger.info("--> index more docs so we have something in the translog");  
            .setWaitForNodes("2")  
 * The OpenSearch Contributors require contributions made to  
                            .map(RetentionLease::id)
                .cluster()  
                assertThat(healthResponse.isTimedOut(), equalTo(false));  
            }
        for (int i = 0; i < numDocs; i++) {
        }  
                        Set<String> actualLeaseIds = shardStat.getRetentionLeaseStats()
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        }
        );  
        // Start relocation
                    .storedFields()
                .addSort("value", SortOrder.ASC)
        for (int i = 0; i < 10; i++) {  
import static org.hamcrest.Matchers.in;
    public void testRelocateWhileContinuouslyIndexingAndWaitingForRefresh() throws Exception {
    @Override
        String node1 = internalCluster().startNode();
        final String indexName = "test";
        String node2 = internalCluster().startNode();
            ).setMapping(mapping)
    }
    }
        logger.info("--> creating test index ...");  
                        assertThat(expectedLeaseIds, everyItem(in(actualLeaseIds)));
    class RecoveryCorruption implements StubbableTransport.SendRequestBehavior {
        logger.info("--> creating test index ...");
import org.opensearch.transport.TransportRequestOptions;
                @Nullable String reason
        assertThat(client().prepareSearch("test").setSize(0).execute().actionGet().getHits().getTotalHits().value(), equalTo(20L));
            ).setMapping(mapping)
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).execute().actionGet();
        logger.info("--> flush so we have an actual index");
            .cluster()
        Thread indexingThread = new Thread(() -> {  
/*  
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "value", i).get();
        Thread[] searchThreads = randomBoolean() ? new Thread[0] : new Thread[randomIntBetween(1, 4)];  
public class RelocationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
        ArrayList<String> ids = new ArrayList<>();
        }  
        int halfNodes = randomIntBetween(1, 3);  
        ).get();  
                "name": {  
            Settings.builder()
            refreshAndWaitForReplication();
        final String node1 = internalCluster().startNode();  
        for (int i = 0; i < 10; i++) {
            ensureGreen(TimeValue.timeValueSeconds(30));  
                // we want to control refreshes
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        assertThat(client().prepareSearch("test").setSize(0).execute().actionGet().getHits().getTotalHits().value(), equalTo(20L));
                    .setWaitForNoRelocatingShards(true)
                                }
                .execute();
                indexer.pauseIndexing();
        // Verify all documents after relocation  
            .build();
        assertBusy(() -> {
            {  
    }
        try {
            .indices()  
        docsToUpdate.stream().forEach(docId -> {  
                SearchResponse response = client.prepareSearch("test").setPreference("_local").setSize(0).get();  
import org.opensearch.transport.Transport;  
                .put("index.number_of_shards", 1)
        ensureGreen(TimeValue.timeValueMinutes(2));
        }  
                    // corrupting the segments_N files in order to make sure future recovery re-send files  
            logger.debug("--> index [{}] documents", builders2.size());
import org.opensearch.transport.TransportService;  
                int toNode = fromNode == 0 ? 1 : 0;
        final IndexEventListener listener = new IndexEventListener() {
                "value": {
        logger.info("--> verifying count");
import static org.hamcrest.Matchers.startsWith;  
                if (chunkRequest.name().startsWith(IndexFileNames.SEGMENTS)) {
        return replicationSettings;
        ensureGreen("test");
            logger.info("--> relocate the shard while indexing");
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)  
                    int[] hitIds = new int[(int) indexer.totalIndexedDocs()];
            {  
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));
            .execute()
        ensureGreen();  
                        }  
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        );
                peerRecoveryFailed.set(true);
        logger.info("--> relocate the shard from node1 to node2");
        for (int i = 1; i < numberOfNodes; i++) {
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));  
        AtomicInteger totalDocCount = new AtomicInteger(0);
        assertBusy(() -> {
 * license agreements. See the NOTICE file distributed with
                fromNode += nodeShiftBased;  
 */  
        String node1 = internalCluster().startNode();
            for (SearchHit hit : response.getHits()) {
                    node + " indicates assigned replicas",  
                "name": {
        ).get();  
                }
                if (rarely()) {
        }  
            docs[i] = client().prepareIndex("test").setId(id).setSource("field1", English.intToEnglish(numDocs + i));
            int fromNode = (i % 2);
                    array[0] = (byte) ~array[0]; // flip one byte in the content
        } finally {
        assertAcked(  
import java.nio.file.attribute.BasicFileAttributes;
        Settings[] nodeSettings = Stream.concat(  
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "value", i).get();  
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];  
                    .setTimeout(ACCEPTABLE_RELOCATION_TIME)
            long expectedCount = -1;
                assertNoFailures(response);
                        }
        }
        indexRandom(true, docs);  
    public void testRelocationEstablishedPeerRecoveryRetentionLeases() throws Exception {
        }
        refresh("test");  
        }
            .prepareHealth()  
 * not use this file except in compliance with the License.
        MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(TransportService.class, p_node);  
                .prepareCreate(indexName)
        String mapping = """
            String node2 = internalCluster().startNode();
                Map<ShardId, List<ShardStats>> byShardId = Stream.of(client().admin().indices().prepareStats(it).get().getShards())  
                        } catch (IOException e) {
import java.nio.file.SimpleFileVisitor;
                    logger.error("Error in background indexing", e);
        logger.info("--> starting [node1] ...");
            assertHitCount(response, totalDocCount.get());  
import org.opensearch.action.index.IndexRequestBuilder;
                }  
            docsToUpdate.add(randomIntBetween(0, numDocs - 1));  
        logger.info("--> attempt relocation with simulated failure");  
 */
 *
            }""";  
        Settings build = Settings.builder()
    public void testRelocationWithDerivedSourceAndTranslog() throws Exception {
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        return Settings.builder()
        logger.info("--> starting [node1] ...");  
        });
        assertBusy(() -> {
        assertBusy(() -> {
                client().prepareIndex("test")
                IndexShard indexShard,
        assertAcked(  
            for (int numDocs = randomIntBetween(10, 30); numDocs > 0; numDocs--) {
        SearchResponse countResponse = client().prepareSearch("test").get();
        for (int i = 0; i < numDocs; i++) {  
            .actionGet();
            NodeEnvironment nodeEnvironment = internalCluster().getInstance(NodeEnvironment.class, node);  
                if (Files.exists(shardLoc)) {
                    expectedCount = response.getHits().getTotalHits().value();  
        String[] nodes = new String[numberOfNodes];  
        clusterHealthResponse = client().admin()
                    .prepareHealth()  
                String id = hit.getId();
        assertThat(client().prepareSearch("test").setSize(0).execute().actionGet().getHits().getTotalHits().value(), equalTo(20L));
                    .prepareHealth()
            prepareCreate(
                    .put("index.number_of_replicas", 0)
        logger.info("--> creating test index ...");  
            // wait for shard to reach post recovery
            "test",  
import org.opensearch.action.index.IndexResponse;  
        }  
    }
import org.opensearch.test.InternalSettingsPlugin;
            logger.info("--> done relocations");
        assertAcked(  
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)
import java.util.concurrent.atomic.AtomicInteger;
                )  
                }
            ).setMapping(mapping)
import org.opensearch.cluster.node.DiscoveryNode;
        logger.info(" --> indexing [{}] docs", numDocs);
        RecoveryCorruption(CountDownLatch corruptionCount) {  
        logger.info("--> creating test index with derived source enabled");
            .setWaitForEvents(Priority.LANGUID)
                assertEquals(Integer.parseInt(id), source.get("value"));
                    client().admin().indices().prepareFlush().get();  
            SearchResponse afterRelocation = client().prepareSearch().setSize(ids.size()).get();
import java.nio.file.Path;  
                } catch (Exception e) {
        final int numIters = randomIntBetween(10, 20);
/*  
        clusterHealthResponse = client().admin()
        String[] redNodes = nodes.subList(halfNodes, nodes.size()).toArray(new String[0]);
                    .actionGet();  
                                    );  
                    assert chunkRequest.content().toBytesRef().bytes == chunkRequest.content().toBytesRef().bytes
                logger.info("--> DONE relocate the shard from {} to {}", fromNode, toNode);  
                builders2.add(client().prepareIndex("test").setSource("{}", MediaTypeRegistry.JSON));
                builders1.add(client().prepareIndex("test").setSource("{}", MediaTypeRegistry.JSON));  
            SearchResponse response = client().prepareSearch("test").setQuery(matchAllQuery()).setSize(numDocs).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        String node2 = internalCluster().startNode();
        stopped.set(true);  
            prepareCreate(
                .put("index.refresh_interval", -1)
                    .getHits();
        internalCluster().startNode();  
            logger.info("--> refreshing the index");
/*
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        );
            searchThreads[i] = new Thread(() -> {
                "test",
        Index idx = state.metadata().index("test").getIndex();
            .setWaitForNodes("2")  
            .build();
        assertAcked(
            ids.add(id);  
            .get();
import org.opensearch.index.shard.IndexShard;
            for (final String it : client().admin().cluster().prepareState().get().getState().metadata().indices().keySet()) {
import org.opensearch.index.seqno.ReplicationTracker;
                    .execute()
            prepareCreate(
 * Unless required by applicable law or agreed to in writing,
            searchThread.join();
            "test",
package org.opensearch.recovery;
            assertEquals("test" + id, source.get("name"));
                } else {
        prepareCreate(  
            numberOfReplicas,
                logger.info("--> START relocate the shard from {} to {}", nodes[fromNode], nodes[toNode]);
            String action,
                            .leases()  
import java.util.stream.Stream;
            numberOfRelocations,
                    assertBusy(() -> {  
            });  
        });
                    }
        AtomicBoolean stopped = new AtomicBoolean(false);
            );  
            .indices()
                "test",
        }
            long requestId,
                    .collect(Collectors.groupingBy(l -> l.getShardRouting().shardId()));
                    .setSource("field", "value" + i)
                            .collect(Collectors.toSet());  
            .actionGet();
        final String node_2 = internalCluster().startNode();
                Thread.yield();
                    .execute()  
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).get();  
        refreshAndWaitForReplication();  
            this.corruptionCount = corruptionCount;
        logger.info(" --> indexing [{}] more docs", numDocs);  
import java.util.Set;  
        final Settings.Builder settings = Settings.builder()
        nodes[0] = internalCluster().startNode();
    public void testCancellationCleansTempFiles() throws Exception {
            if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {
        ensureGreen(TimeValue.timeValueMinutes(2));
        logger.info("--> relocate the shard from node1 to node2");
                        int id = Integer.parseInt(hit.getId());
                fail();
            }""";  
              "properties": {
        ensureGreen();  
import org.opensearch.plugins.Plugin;  
                                        "found a temporary recovery file: " + file,  
            }""";  
            .cluster()
        prepareCreate("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", numberOfReplicas)).get();
            }  
        assertEquals(docsToUpdate.size(), updatedDocs.size());
    public void testRelocationWhileRefreshing() throws Exception {  
            for (final Path shardLoc : nodeEnvironment.availableShardPaths(new ShardId(indexName, "_na_", 0))) {
    }  
                    .execute()
              }
    public void testRelocationWithDerivedSourceBasic() throws Exception {  
        String mapping = """  
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).get();  
        logger.info("--> verifying count again...");  
                    .put("index.derived_source.enabled", true)  
    }  
        };
            for (SearchHit hit : response.getHits()) {
                    .setWaitForNoRelocatingShards(true)  
            {
        String mapping = """
                connection.sendRequest(requestId, action, request, options);
        int numberOfNodes = numberOfReplicas == 0 ? 2 : 3;
 * GitHub history for details.
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(halfNodes - 1));
                connection.sendRequest(requestId, action, request, options);
        }
                    .setWaitForEvents(Priority.LANGUID)  
        }, 1, TimeUnit.MINUTES);  
            nodes[i - 1] = internalCluster().startNode();
        }  
                .setSize(numDocs + numTranslogDocs)
        transportService.clearAllRules();
            );
        ensureGreen(TimeValue.timeValueMinutes(2));
        AtomicBoolean peerRecoveryFailed = new AtomicBoolean(false);
                        if (set.remove(id) == false) {
                    .setSource("field", "value" + i)
            logger.info("--> {} docs indexed", numDocs);
                .setTransientSettings(
              }
        );
                  "type": "keyword"
                assertEquals("test" + id, source.get("name"));
            .execute()
                    .put("index.number_of_replicas", 0)
        if (randomBoolean()) {  
                    long id = totalDocCount.incrementAndGet();  
        logger.info(
        for (int i = 10; i < 20; i++) {
    }
                    .put("index.derived_source.enabled", true)  
                assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
    }
            }""";  
        assertBusy(() -> {  
        String mapping = """
        logger.info(" --> waiting for relocation to complete");
            .execute()
                    .put("index.refresh_interval", -1) // Disable automatic refresh
import org.opensearch.search.sort.SortOrder;  
            assertHitCount(response, numDocs);  
            stopIndexing.set(true);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    byte[] array = chunkRequest.content().toBytesRef().bytes;
        // Index some documents and flush  
                    .setWaitForNodes(Integer.toString(i))
                assertEquals("test" + id, source.get("name"));  
        logger.info("--> verifying no temporary recoveries are left");
            eventListener.setNewDelegate(listener);
                    assertEquals(Integer.parseInt(id), source.get("value"));
                    client().prepareIndex("test").setId(String.valueOf(id)).setSource("name", "test" + id, "value", id).get();
                    .setWaitForEvents(Priority.LANGUID)
                Map<String, Object> source = hit.getSourceAsMap();  
        List<IndexRequestBuilder> requests = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));
        final Semaphore postRecoveryShards = new Semaphore(0);  
                mockTransportService.addSendBehavior(  
import static org.hamcrest.Matchers.everyItem;  
        }
        assertTrue(peerRecoveryFailed.get()); // verify that peer recovery is getting blocked
            // Stop the indexing
            client().admin()
            .setWaitForNodes("2")
                    .prepareHealth()  
            // Start relocation  
            ).setMapping(mapping)
import java.util.concurrent.Semaphore;
                .put("index.number_of_shards", 1)
            .add(new MoveAllocationCommand("test", 0, node1, node2))  
            logger.debug("--> verifying all searches return the same number of docs");  
        logger.info("--> starting relocations...");
 *    http://www.apache.org/licenses/LICENSE-2.0
        logger.info("--> index 100 docs while relocating");
        String indexName = "test";
        private final CountDownLatch corruptionCount;
            prepareCreate(
    }
        logger.info("--> starting [node_0] ...");
        refresh();
import java.util.ArrayList;  
