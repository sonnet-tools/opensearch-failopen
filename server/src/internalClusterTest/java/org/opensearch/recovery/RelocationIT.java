        Thread indexingThread = new Thread(() -> {
                toNode += nodeShiftBased;
 *
            .execute()
                    internalCluster().getInstance(TransportService.class, node.getName()),
        // Start relocation
        logger.info("--> verifying count");
            .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "1s")
            docs[i] = client().prepareIndex("test").setId(id).setSource("field1", English.intToEnglish(numDocs + i));
        });
            List<IndexRequestBuilder> builders2 = new ArrayList<>();
        for (int i = 0; i < numDocs; i++) {
            ).setMapping(mapping)
        for (int i = 10; i < 20; i++) {
                }
import java.util.concurrent.atomic.AtomicBoolean;
            if (i != numberOfNodes - 1) {
        }
        client().admin().indices().prepareFlush().execute().actionGet();
 * not use this file except in compliance with the License.
        }
        for (int i = 0; i < numDocs; i++) {
                            .retentionLeases()
                    .put("index.number_of_replicas", 0)
            assertEquals("test" + id, source.get("name"));
import org.opensearch.action.support.WriteRequest;
            logger.debug("--> verifying all searches return the same number of docs");
            Settings.builder()
 * software distributed under the License is distributed on an
        final String node2 = internalCluster().startNode();
                  "type": "keyword"
            logger.info("--> starting [node{}] ...", i);
        }
            logger.info("--> starting relocations...");
        refreshAndWaitForReplication();
            searchThread.join();
                .setTransientSettings(
        public void sendRequest(
                                                                                                                                     // to
                }
                                                                                                                                     // refreshes
import org.opensearch.common.action.ActionFuture;
        logger.info("--> creating test index ...");
    }
                int id = randomIntBetween(1, totalDocCount.get());
                // we want to control refreshes
            connection.sendRequest(requestId, action, request, options);
        Settings[] nodeSettings = Stream.concat(
        logger.info(" --> moving index to new nodes");
            .cluster()
        logger.info("--> starting [node1] ...");
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
                    .put("index.number_of_replicas", 0)
        logger.info("--> index 10 docs");
                    logger.debug("--> flushing");
                if (rarely()) {
            if (ranOnce == false) {
            logger.info(" --> checking iteration {}", i);
        });
                            throw new AssertionError("failed to walk file tree starting at [" + shardLoc + "]", e);
            Stream.generate(() -> Settings.builder().put("node.attr.color", "red").build()).limit(halfNodes)
                assertEquals("test" + id, source.get("name"));
            logger.info("--> starting [node_{}] ...", i);
        )) {
            for (int i = 0; i < numberOfRelocations; i++) {
                client().admin()
                    Set<Integer> set = Arrays.stream(hitIds).boxed().collect(Collectors.toSet());
        super(settings);
        String node1 = internalCluster().startNode();
        }
        });
                FileChunkRequest chunkRequest = (FileChunkRequest) request;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(halfNodes - 1));
        }
            .prepareHealth()
            } else {
        for (int i = 10; i < 20; i++) {
/*
        ArrayList<String> ids = new ArrayList<>();
                try {
                IndexShardState currentState,
        logger.info("--> creating test index ...");
import java.util.ArrayList;
        List<String> nodes = internalCluster().startNodes(nodeSettings);
                    initialDocCountLatch.countDown();
        internalCluster().startNode();
            .setWaitForEvents(Priority.LANGUID)
            .actionGet();
                    assertNoFailures(client().prepareSearch("test").setRequestCache(false).get());
        }
public class RelocationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat(client().prepareSearch("test").setSize(0).execute().actionGet().getHits().getTotalHits().value(), equalTo(20L));
        String[] blueNodes = nodes.subList(0, halfNodes).stream().toArray(String[]::new);
                SearchResponse response = client.prepareSearch("test").setPreference("_local").setSize(0).get();
                for (List<ShardStats> shardStats : byShardId.values()) {
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
        }
              "properties": {
        // Index some documents
        docsToUpdate.stream().forEach(docId -> {
        String node1 = internalCluster().startNode();
            .actionGet();
        int halfNodes = randomIntBetween(1, 3);
                    .getHits();
import static org.hamcrest.Matchers.not;
            }
            for (final Path shardLoc : nodeEnvironment.availableShardPaths(new ShardId(indexName, "_na_", 0))) {
            }""";
            if (i != numberOfNodes) {
        client().admin()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        String[] redNodes = nodes.subList(halfNodes, nodes.size()).toArray(new String[0]);
        String node1 = internalCluster().startNode();
        int numberOfRelocations = scaledRandomIntBetween(1, rarely() ? 10 : 4);
                .setSource("field", "value" + i)
                },
import org.opensearch.action.index.IndexRequestBuilder;
        );
                    for (ShardStats shardStat : shardStats) {
import org.opensearch.common.unit.TimeValue;
        // Start indexing
        };
            .prepareHealth()
                .prepareCreate(indexName)
    }
                    .put("index.number_of_shards", 1)
            assertHitCount(response, totalDocCount.get());
                    byte[] array = chunkRequest.content().toBytesRef().bytes;
                Settings.builder()
        clusterHealthResponse = client().admin()
import org.opensearch.index.shard.IndexShardState;
            for (SearchHit hit : response.getHits()) {
            // verify cluster was finished.
            refreshAndWaitForReplication("test");
            pendingIndexResponses.add(
                Map<String, Object> source = response.getHits().getAt(id - 1).getSourceAsMap();
                            });
        });
                },
                        .put("index.routing.allocation.include.color", "blue")
        final List<ActionFuture<IndexResponse>> pendingIndexResponses = new ArrayList<>();
        }
        logger.info("--> index 10 docs");
        assertBusy(() -> assertAllShardsOnNodes(indexName, redNodes));
        prepareCreate("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", numberOfReplicas)).get();
                "name": {
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("3").setWaitForGreenStatus().get().isTimedOut());
import org.apache.lucene.index.IndexFileNames;
                    .setSource("field", "value" + i)
 */
                            .map(RetentionLease::id)
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
 * this work for additional information regarding copyright
            .put(indexSettings())
        int numTranslogDocs = randomIntBetween(50, 100);
import org.opensearch.action.admin.indices.stats.ShardStats;
        client().admin().indices().prepareFlush().execute().actionGet();
            .setWaitForNoRelocatingShards(true)
            }
                    .put("index.derived_source.enabled", true)
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
import org.opensearch.transport.Transport;
        ClusterHealthResponse clusterHealthResponse = client().admin()
        String node1 = internalCluster().startNode();
    public void testRelocationWithDerivedSourceAndConcurrentIndexing() throws Exception {
            Stream.generate(() -> Settings.builder().put("node.attr.color", "red").build()).limit(halfNodes)
        assertHitCount(response, numDocs);
                "value": {
        logger.info("--> flush so we have an actual index");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
 * KIND, either express or implied.  See the License for the
        logger.info(
                                }
                            .stream()
            .put(super.indexSettings())
                    .execute()
                        : "no internal reference!!";
                logger.info("--> DONE search test round {}", i + 1);
                            logger.error("Extra id [{}]", id);
        int updateCount = randomIntBetween(10, numDocs / 2);
                    .put("index.number_of_replicas", 0)
                },
                assertThat(healthResponse.isTimedOut(), equalTo(false));
                    .put("index.derived_source.enabled", true)
        logger.info("--> relocate the shard from node1 to node2");
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertAcked(
            }
                updatedDocs.add(docId);
        for (int i = 0; i < 10; i++) {
                    .cluster()
                IndexShard indexShard,
                            .leases()
            indexer.stopAndAwaitStopped();
            prepareCreate(
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
                connection.sendRequest(requestId, action, request, options);
                }
            if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {
        String node1 = internalCluster().startNode();
                  "type": "integer"
            docsToUpdate.add(randomIntBetween(0, numDocs - 1));
                    .put("index.number_of_replicas", 0)
                assertThat(
            Stream.generate(() -> Settings.builder().put("node.attr.color", "blue").build()).limit(halfNodes),
                    long id = totalDocCount.incrementAndGet();
    @Override
            Map<String, Object> source = hit.getSourceAsMap();
        final String node1 = internalCluster().startNode();
            .cluster()
        logger.info("--> relocate the shard from node1 to node2");
import java.nio.file.Path;
                                                                                                                                     // want
                        } catch (IOException e) {
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "value", i).get();
        }
        }
    @Override
            .execute()
        });
                client().prepareIndex("test")
                assertThat(healthResponse.isTimedOut(), equalTo(false));
            logger.info("--> START relocate the shard from {} to {}", nodes[fromNode], nodes[toNode]);
            .setWaitForEvents(Priority.LANGUID)
        }
                ClusterState state = client(node).admin().cluster().prepareState().setLocal(true).get().getState();
import org.opensearch.cluster.metadata.IndexMetadata;
                    logger.error("Error in background indexing", e);
                logger.warn("Error while updating doc with id = {}", docId, e);
import java.util.stream.Collectors;
                                    return FileVisitResult.CONTINUE;
        });
                .put("index.number_of_shards", 1)
                    }
                    .setTimeout(ACCEPTABLE_RELOCATION_TIME)
        ) throws IOException {
        transportService.clearAllRules();
            refresh();
            ids.add(id);
                .execute();
        logger.info("--> blocking recoveries from primary (allowed failures: [{}])", allowedFailures);
                client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, nodes[fromNode], nodes[toNode])).get();
        ensureGreen(TimeValue.timeValueMinutes(2));
                    state.getRoutingTable().index(indexName).shardsWithState(ShardRoutingState.UNASSIGNED).size(),
                        }
                        hitIds[hit] = hit + 1;
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {
        assertBusy(() -> {
                    .setSource("field", "value" + i)
        assertThat(client().prepareSearch("test").setSize(0).execute().actionGet().getHits().getTotalHits().value(), equalTo(20L));
}
        );
            {
            .add(new MoveAllocationCommand("test", 0, node1, node2))
import java.io.IOException;
                indexer.pauseIndexing();
                                    assertThat(
                  "type": "integer"
                    .execute()
            SearchResponse response = client().prepareSearch("test")
                    int[] hitIds = new int[(int) indexer.totalIndexedDocs()];
                    .cluster()
              }
            // Expected failure
            nodes[i - 1] = internalCluster().startNode();
                }
        for (int i = 10; i < 20; i++) {
            int fromNode = (i % 2);
package org.opensearch.recovery;
                "test",
            stopIndexing.set(true);
        for (int i = 0; i < updateCount; i++) {
            // Let it index docCount documents
            "test",
                assertEquals(Integer.parseInt(id), source.get("value"));
                "value": {
    }
        refreshAndWaitForReplication();
            initialDocCountLatch.await();
        logger.info("--> creating test index with derived source enabled");
        prepareCreate("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0)).get();
                    .prepareHealth()
    private final TimeValue ACCEPTABLE_RELOCATION_TIME = new TimeValue(5, TimeUnit.MINUTES);
        prepareCreate(
 * under the License.
                if (hits.getTotalHits().value() != indexer.totalIndexedDocs()) {
    public Settings indexSettings() {
                Map<String, Object> source = hit.getSourceAsMap();
        final Set<Integer> docsToUpdate = new HashSet<>();
 * GitHub history for details.
                .setId(Integer.toString(i))
                    .actionGet();
        });
            .prepareReroute()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.index.shard.IndexShard;
        try {
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteResponse;
                                        not(startsWith("recovery."))
import org.opensearch.index.shard.IndexEventListener;
        refresh("test");
        // Start relocation
                } catch (Exception e) {
 * specific language governing permissions and limitations
        refreshAndWaitForReplication();
        }
            logger.debug("--> index [{}] documents", builders1.size());
                int fromNode = (i % 2);
                } else {
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).get();
                assertEquals(Integer.parseInt(id), source.get("value"));
        AtomicBoolean stopped = new AtomicBoolean(false);
                Map<String, Object> source = hit.getSourceAsMap();
            assertTrue(pendingIndexResponses.stream().allMatch(ActionFuture::isDone));
                    .collect(Collectors.groupingBy(l -> l.getShardRouting().shardId()));
        logger.info("--> wait for all replica shards to be removed, on all nodes");
    }
            while (stopIndexing.get() == false) {
                }
                    assert chunkRequest.content().toBytesRef().bytes == chunkRequest.content().toBytesRef().bytes
        logger.info(" --> waiting for relocation to complete");
import org.opensearch.action.index.IndexResponse;
    public void testRelocationEstablishedPeerRecoveryRetentionLeases() throws Exception {
            }
                .put("index.number_of_replicas", 0)
import java.nio.file.Files;
            eventListener.setNewDelegate(listener);
            ensureGreen(TimeValue.timeValueSeconds(30));
            {
        AtomicBoolean stopIndexing = new AtomicBoolean(false);
                    assertEquals(expectedCount, response.getHits().getTotalHits().value());
            prepareCreate(
            .setTimeout(ACCEPTABLE_RELOCATION_TIME)
                }
        // Index some documents
import org.opensearch.test.MockIndexEventListener;
                );
        prepareCreate(
                "name": {
                    Set<String> expectedLeaseIds = shardStats.stream()
        ClusterHealthResponse clusterHealthResponse = client().admin()
        assertAllShardsOnNodes("test", redNodes);
                } else {
              "properties": {
        ClusterHealthResponse clusterHealthResponse = client().admin()
                }
                    Settings.builder()
        logger.info("--> verifying count");
                    .prepareHealth()
            }""";
                }
    }
            indexingThread.start();
        }
        int initialDocCount = randomIntBetween(10, 100);
            .prepareHealth()
            );
            .get();
            prepareCreate(
        String mapping = """
            @Override
            ).setMapping(mapping)
        indexRandom(true, docs);
import static org.hamcrest.Matchers.everyItem;
    }
 * this file be licensed under the Apache-2.0 license or a
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {
                peerRecoveryFailed.set(true);
            Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).put("index.refresh_interval", -1) // we
import java.util.stream.Stream;
            } catch (Exception e) {
        ).toArray(Settings[]::new);
        refresh();
import java.util.Arrays;
        logger.info("--> creating test index with derived source enabled");
            "test",
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).execute().actionGet();
            logger.info("--> refreshing the index");
            .execute()
            }
        indexRandom(true, requests);
            TransportRequestOptions options
                    .put("index.derived_source.enabled", true)
import java.util.concurrent.atomic.AtomicInteger;
                    assertBusy(() -> {
            {
import static org.hamcrest.Matchers.in;
            numberOfReplicas,
            .get();
    }
                indexingThread.interrupt();
            }
                    .setWaitForEvents(Priority.LANGUID)
              "properties": {
                        if (set.remove(id) == false) {
            SearchResponse response = client().prepareSearch("test")
        assertActiveCopiesEstablishedPeerRecoveryRetentionLeases();
                    for (int hit = 0; hit < indexer.totalIndexedDocs(); hit++) {
                Thread.yield();
                  "type": "keyword"
        for (int i = 2; i <= numberOfNodes; i++) {
            boolean ranOnce = false;
            .setWaitForNoRelocatingShards(true)
            .setWaitForNodes("2")
        final String indexName = "test";
                    .put("index.number_of_shards", 1)
import java.util.concurrent.CountDownLatch;
                                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).execute().actionGet();
import java.util.Collection;
        String mapping = """
            prepareCreate(
                }
            searchThreads[i] = new Thread(() -> {
                        try {
        int numberOfNodes = numberOfReplicas == 0 ? 2 : 3;
                },
                .indices()
            }
        logger.info("--> verifying count again...");
        int numberOfReplicas = randomBoolean() ? 0 : 1;
    public void testRelocationWithDerivedSourceWithUpdates() throws Exception {
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).get();
import java.nio.file.attribute.BasicFileAttributes;
                    .setSize((int) indexer.totalIndexedDocs())
import org.opensearch.transport.TransportRequest;
            }
        int numberOfReplicas = randomBoolean() ? 0 : 1;
                ClusterHealthResponse clusterHealthResponse = client().admin()
                    .put("index.refresh_interval", -1) // Disable automatic refresh
            waitForDocs(numDocs, indexer);
 * Modifications Copyright OpenSearch Contributors. See
                    .setQuery(matchAllQuery())
        );
            });
            for (int numDocs = randomIntBetween(10, 30); numDocs > 0; numDocs--) {
            logger.info("--> {} docs indexed", numDocs);
              }
    public void testRelocateWhileContinuouslyIndexingAndWaitingForRefresh() throws Exception {
import org.opensearch.test.transport.StubbableTransport;
    }
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            {
 * the Apache License, Version 2.0 (the "License"); you may
                    .setTimeout("30s")
import org.opensearch.cluster.ClusterState;
                    node + " indicates assigned replicas",
    }
import org.opensearch.index.seqno.RetentionLease;
                builders2.add(client().prepareIndex("test").setSource("{}", MediaTypeRegistry.JSON));
                }
import org.opensearch.common.Nullable;
            indexRandom(false, true, builders1);
        for (int i = 0; i < searchThreads.length; i++) {
                    .cluster()
        ).get();
            }
                .prepareUpdateSettings()
            }
            "test",
        final IndexEventListener listener = new IndexEventListener() {
import org.opensearch.indices.recovery.FileChunkRequest;
        AtomicInteger totalDocCount = new AtomicInteger(0);
                                @Override
                while (stopped.get() == false) {
                    equalTo(1)
        logger.info("--> flush so we have an actual index");
    }
        assertBusy(() -> {
                    .actionGet();
        assertAcked(
        assertAcked(
        for (int i = 0; i < numIters; i++) {
                  "type": "keyword"
        logger.info("--> index 100 docs while relocating");
    private void assertActiveCopiesEstablishedPeerRecoveryRetentionLeases() throws Exception {
/*
                    .put("index.number_of_shards", 1)
        ).get();
import java.nio.file.SimpleFileVisitor;
import java.util.HashSet;
    }
                        assertThat(expectedLeaseIds, everyItem(in(actualLeaseIds)));
            toNode += nodeShiftBased;
            searchThreads[i].start();
        }
        logger.info("--> start another node");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            }
        logger.info("--> relocate the shard from node1 to node2");
                            Files.walkFileTree(shardLoc, new SimpleFileVisitor<Path>() {
import org.opensearch.index.mapper.MapperService;
            NodeEnvironment nodeEnvironment = internalCluster().getInstance(NodeEnvironment.class, node);
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)
        SearchResponse countResponse = client().prepareSearch("test").get();
                "test",
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
            }""";
            for (final String it : client().admin().cluster().prepareState().get().getState().metadata().indices().keySet()) {
                    // corrupting the segments_N files in order to make sure future recovery re-send files
              }
    public void testRelocationWhileRefreshing() throws Exception {
        }
                ClusterHealthResponse healthResponse = client().admin()
            Stream.generate(() -> Settings.builder().put("node.attr.color", "blue").build()).limit(halfNodes),
        for (int i = 0; i < numDocs; i++) {
                assertEquals("test" + id, source.get("name"));
            );
            .prepareUpdateSettings(indexName)
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
                Settings.builder()
                "name": {
import org.opensearch.test.BackgroundIndexer;
            refreshAndWaitForReplication();
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node_1, node_2)).execute().actionGet();
        // Index some documents
            ids.add(id);
import java.util.Set;
            .setWaitForEvents(Priority.LANGUID)
            ).setMapping(mapping)
            prepareCreate(
            indexName,
import java.util.concurrent.TimeUnit;
            MockIndexEventListener.TestEventListener.class
        for (int i = numDocs; i < numDocs + numTranslogDocs; i++) {
                .setSettings(
                    set.forEach(value -> logger.error("Missing id [{}]", value));
        );
                .addSort("value", SortOrder.ASC)
            logger.info("--> waiting for {} docs to be indexed ...", numDocs);
    class RecoveryCorruption implements StubbableTransport.SendRequestBehavior {
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
import java.util.concurrent.Semaphore;
        int numDocs = randomIntBetween(100, 200);
    public RelocationIT(Settings settings) {
import static org.hamcrest.Matchers.startsWith;
        logger.info("--> creating test index ...");
                if (Files.exists(shardLoc)) {
        refresh();
import org.opensearch.cluster.routing.ShardRoutingState;
            assertHitCount(response, numDocs);
            SearchResponse response = client().prepareSearch("test").setQuery(matchAllQuery()).setSize(numDocs).get();
 *
        logger.info("--> starting [node1] ...");
                    .isTimedOut()
            long expectedCount = -1;
        logger.info("--> relocate the shard from node1 to node2");
                                        file.getFileName().toString(),
                    .setWaitForEvents(Priority.LANGUID)
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "value", i).get();
            .cluster()
    public void testRelocationWhileIndexingRandom() throws Exception {
    public void testRelocateWhileWaitingForRefresh() {
                )
                }
            String id = hit.getId();
        ensureGreen();
        String[] nodes = new String[numberOfNodes];
            .indices()
                Settings.builder()
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    .setWaitForEvents(Priority.LANGUID)
                    .put("index.derived_source.enabled", true)
import org.opensearch.plugins.Plugin;
        String mapping = """
                Settings.builder()
            client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, nodes[fromNode], nodes[toNode])).get();
            numberOfRelocations,
        );
            .execute();
        for (int i = 1; i < numberOfNodes; i++) {
                    .setWaitForGreenStatus()
              "properties": {
            logger.info("--> searching the index");
            .execute()
            SearchResponse afterRelocation = client().prepareSearch().setSize(ids.size()).get();
            ) {
                    for (SearchHit hit : hits.getHits()) {
        );
                @Nullable String reason
            .setWaitForNoRelocatingShards(true)
        ensureGreen();
                    .put("index.number_of_shards", 1)
import org.opensearch.index.IndexSettings;
        for (int i = 0; i < numDocs; i++) {
 * Licensed to Elasticsearch under one or more contributor
        final Settings.Builder settings = Settings.builder()
                                    );
        Settings[] nodeSettings = Stream.concat(
                fail();
        assertEquals(node1, state.getRoutingNodes().node(nodeId).node().getName()); // Verify the allocated node of the shard
        clusterHealthResponse = client().admin()
            for (SearchHit hit : response.getHits()) {
            // Assert few documents
import org.opensearch.transport.TransportService;
                    .setDoc("value", docId * 2)
                indexer.continueIndexing(numDocs);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        logger.info("--> verifying count");
        );
                    .put("index.number_of_replicas", 0)
            .setWaitForEvents(Priority.LANGUID)
            }""";
                    .setWaitForEvents(Priority.LANGUID)
        RecoveryCorruption(CountDownLatch corruptionCount) {
        logger.info("blue nodes: {}", (Object) blueNodes);
        return Arrays.asList(InternalSettingsPlugin.class, MockTransportService.TestPlugin.class, MockIndexEventListener.TestPlugin.class);
        super.beforeIndexDeletion();
            client().admin()
            String id = randomRealisticUnicodeOfLength(10) + String.valueOf(numDocs + i);
                assertThat(hits.getTotalHits().value(), equalTo(indexer.totalIndexedDocs()));
                    .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)
            .actionGet();
                "value": {
                assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
            .execute()
import org.opensearch.core.index.shard.ShardId;
        assertAcked(
            "testRelocationWhileIndexingRandom(numRelocations={}, numberOfReplicas={}, numberOfNodes={})",
        int halfNodes = randomIntBetween(1, 3);
                )
        for (int i = 0; i < 10; i++) {
            .build();
            logger.info("--> waiting for indexing threads to stop ...");
            client().admin()
        int allowedFailures = randomIntBetween(3, 5); // the default of the `index.allocation.max_retries` is 5.
import org.opensearch.index.seqno.ReplicationTracker;
                }
        final String node_1 = internalCluster().startNode();
            .setWaitForEvents(Priority.LANGUID)
                Map<String, Object> source = hit.getSourceAsMap();
                "name": {
import org.opensearch.cluster.node.DiscoveryNode;
            .setWaitForNodes("2")
                    .setWaitForGreenStatus()
        }
        String[] nodes = new String[numberOfNodes];
        );
    }
        assertBusy(() -> assertAllShardsOnNodes(indexName, blueNodes));
import org.opensearch.core.index.Index;
 * The OpenSearch Contributors require contributions made to
        // Verify all documents after relocation
                            .collect(Collectors.toSet());
        ).get();
        for (int i = 0; i < numberOfRelocations; i++) {
        logger.info("--> index more docs so we have something in the translog");
                .put("index.number_of_replicas", numberOfReplicas)
                    array[0] = (byte) ~array[0]; // flip one byte in the content
                client().prepareIndex("test")
            settings.put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), randomIntBetween(1, 10) + "s");
                    .setWaitForNoRelocatingShards(true)
import org.opensearch.transport.TransportRequestOptions;
        logger.info("red nodes: {}", (Object) redNodes);
            client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).get();
            .setSettings(Settings.builder().put("index.routing.allocation.include.color", "red"))
            List<IndexRequestBuilder> builders1 = new ArrayList<>();
        assertBusy(() -> {
                  "type": "integer"
            try {
            int nodeShiftBased = numberOfReplicas; // if we have replicas shift those
            assertHitCount(response, numDocs);
                .setQuery(matchAllQuery())
            ensureGreen();
import java.util.List;
            }
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.env.NodeEnvironment;
                String id = hit.getId();
                client().prepareUpdate("test", String.valueOf(docId))
        List<IndexRequestBuilder> requests = new ArrayList<>();
        Index idx = state.metadata().index("test").getIndex();
        ensureGreen(TimeValue.timeValueMinutes(2));
            public void indexShardStateChanged(
                    client().admin().indices().prepareFlush().get();
                logger.info("--> DONE relocate the shard from {} to {}", fromNode, toNode);
        }
                    .setRetryOnConflict(3)
            }
                .setSize(numDocs + numTranslogDocs)
        return replicationSettings;
import org.opensearch.common.settings.Settings;
            .prepareHealth()
                assertEquals("test" + id, source.get("name"));
        }
            }
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertAcked(
        logger.info("--> relocate the shard from node1 to node2");
        logger.info("--> start another node");
 * You may obtain a copy of the License at
        for (DiscoveryNode node : clusterService.state().nodes()) {
        String mapping = """
    }
        String indexName = "test";
        for (SearchHit hit : response.getHits()) {
                fromNode += nodeShiftBased;
        ).toArray(Settings[]::new);
                    expectedCount = response.getHits().getTotalHits().value();
        assertAcked(
        int numDocs = scaledRandomIntBetween(25, 250);
        ClusterService clusterService = internalCluster().getInstance(ClusterService.class, p_node);
        logger.info("--> index more docs so we have something in the translog");
        ensureGreen("test");
            .setWaitForNodes("2")
        // Index some documents and flush
                mockTransportService.addSendBehavior(
    }
            client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).get();
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
                Map<ShardId, List<ShardStats>> byShardId = Stream.of(client().admin().indices().prepareStats(it).get().getShards())
        assertAcked(prepareCreate("test", settings));
        logger.info(" --> indexing [{}] more docs", numDocs);
        assertTrue(peerRecoveryFailed.get()); // verify that peer recovery is getting blocked
            ).setMapping(mapping)
            String id = randomRealisticUnicodeOfLength(10) + String.valueOf(i);
        }
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
        String[] blueNodes = nodes.subList(0, halfNodes).toArray(new String[0]);
        }
        }
            numberOfReplicas,
            assertFalse(
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "value", i).get();
    public void testRelocationFailureWithDerivedSource() throws Exception {
        indexRandom(true, docs);
                    .setWaitForNodes(Integer.toString(i + 1))
                  "type": "keyword"
                                        "found a temporary recovery file: " + file,
 */
                logger.info("--> START search test round {}", i + 1);
            .actionGet();
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            .prepareUpdateSettings(indexName)
 * SPDX-License-Identifier: Apache-2.0
                    logger.debug("corrupting [{}] to {}. file name: [{}]", action, connection.getNode(), chunkRequest.name());
        int numDocs = randomIntBetween(100, 200);
            fromNode += nodeShiftBased;
            }
            }
            logger.info("--> DONE relocate the shard from {} to {}", fromNode, toNode);
            }
        Settings build = Settings.builder()
        });
                SearchHits hits = client().prepareSearch("test")
        ClusterState state = client().admin().cluster().prepareState().get().getState();
                );
            for (int i = 0; i < 10; i++) {
            Settings.builder()
        for (String node : internalCluster().getNodeNames()) {
        String mapping = """
        int numDocs = randomIntBetween(100, 200);
                    }
                numDocs = scaledRandomIntBetween(200, 1000);
        nodes[0] = internalCluster().startNode();
        assertThat(client().prepareSearch("test").setSize(0).execute().actionGet().getHits().getTotalHits().value(), equalTo(20L));
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(0, halfNodes - 1))
                .addSort("value", SortOrder.ASC)
            }
        SearchResponse response = client().prepareSearch("test").setQuery(matchAllQuery()).setSize(numDocs).get();
            .prepareHealth()
        int numberOfNodes = numberOfReplicas == 0 ? 2 : 3;
        }
        assertActiveCopiesEstablishedPeerRecoveryRetentionLeases();
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
            pendingIndexResponses.add(
            postRecoveryShards.acquire(1);
            int toNode = fromNode == 0 ? 1 : 0;
              "properties": {
        logger.info(" --> indexing [{}] docs", numDocs);
            .indices()
            logger.info("--> indexing threads stopped");
            {
 * ownership. Elasticsearch licenses this file to you under
        assertAcked(
        MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(TransportService.class, p_node);
        logger.info("--> index 10 docs");
            ensureGreen(TimeValue.timeValueMinutes(2));
        ensureGreen();
        assertActiveCopiesEstablishedPeerRecoveryRetentionLeases();
                                                                                                                                     // control
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 *
                    Thread.yield(); // Small delay to prevent overwhelming
            long requestId,
                assertEquals(id, source.get("value"));
        );
        stopped.set(true);
                        int id = Integer.parseInt(hit.getId());
            for (int i = 0; i < Math.min(totalDocCount.get(), 50); i++) {
        logger.info("--> starting relocations...");
        ensureGreen(TimeValue.timeValueSeconds(60), "test"); // move all shards to the new nodes (it waits on relocation)
                if (currentState == IndexShardState.POST_RECOVERY) {
import org.opensearch.action.search.SearchResponse;
        IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
                    .put("index.derived_source.enabled", true)
        int numDocs = randomIntBetween(100, 150);
                .cluster()
            // Start relocation
        final Semaphore postRecoveryShards = new Semaphore(0);
        private final CountDownLatch corruptionCount;
    public void testRelocationWithDerivedSourceBasic() throws Exception {
        String node2 = internalCluster().startNode();
                    .execute()
        logger.info("--> relocate the shard with uncommitted translog");
                builders1.add(client().prepareIndex("test").setSource("{}", MediaTypeRegistry.JSON));
        for (int i = 0; i < numDocs; i++) {
              }
                .put("index.number_of_shards", 1)
                connection.sendRequest(requestId, action, request, options);
                    new RecoveryCorruption(corruptionCount)
                int toNode = fromNode == 0 ? 1 : 0;
        // Index more docs but don't refresh (keep in translog)
                    .put("index.number_of_shards", 1)
        logger.info("--> starting [node_0] ...");
        final String node1 = internalCluster().startNode();
            logger.debug("--> index [{}] documents", builders2.size());
            numberOfNodes
            for (int numDocs = randomIntBetween(10, 30); numDocs > 0; numDocs--) {
            client().prepareIndex("test")
                    assertEquals(Integer.parseInt(id) * 2, source.get("value")); // Verify updated value
        }
        ).get();
        return Settings.builder()
                    .execute()
            }""";
        int numDocs = randomIntBetween(100, 200);
        final String node2 = internalCluster().startNode();
 * compatible open source license.
            numberOfNodes
                    .get()
                },
                .setQuery(matchAllQuery())
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // Start relocation
        Thread[] searchThreads = randomBoolean() ? new Thread[0] : new Thread[randomIntBetween(1, 4)];
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand("test", 0, node1, node2)).get();
        // Verify all documents after relocation
        ensureStableCluster(halfNodes * 2);
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
            String node2 = internalCluster().startNode();
        assertEquals(docsToUpdate.size(), updatedDocs.size());
        } finally {
                    .setId(Integer.toString(i))
                    .setWaitForNodes(Integer.toString(i))
import org.opensearch.test.InternalSettingsPlugin;
                    .execute()
                    corruptionCount.countDown();
                    .storedFields()
        assertBusy(() -> {
            .put("index.routing.allocation.include.color", "blue")
        assertBusy(() -> {
import org.apache.lucene.tests.util.English;
                .setSize(totalDocCount.get())
            }
                .get();
        }
                    .prepareHealth()
import java.nio.file.FileVisitResult;
                        .map(s -> ReplicationTracker.getPeerRecoveryRetentionLeaseId(s.getShardRouting()))
        ensureGreen();
                String id = hit.getId();
            );
                    }
        logger.info("--> flush so we have an actual index");
        ensureStableCluster(halfNodes * 2);
                  "type": "keyword"
                .setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL)
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                    postRecoveryShards.release();
                logger.debug("--> Allow indexer to index [{}] documents", numDocs);
            assertHitCount(response, numDocs + numTranslogDocs);
                    .actionGet();
        }
            SearchResponse response = client().prepareSearch("test").setQuery(matchAllQuery()).setSize(numDocs).get();
        logger.info("--> starting [node1] ...");
                assertNoFailures(response);
 * Unless required by applicable law or agreed to in writing,
            .build();
                .put("index.refresh_interval", -1)
        logger.info("--> starting [node1] ...");
    public void testCancellationCleansTempFiles() throws Exception {
                "value": {
        }
                        Set<String> actualLeaseIds = shardStat.getRetentionLeaseStats()
    }
                    .setId(Integer.toString(i))
import org.opensearch.common.Priority;
        final String p_node = internalCluster().startNode();
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
        int nodeShiftBased = numberOfReplicas; // if we have replicas shift those
              }
        String[] redNodes = nodes.subList(halfNodes, nodes.size()).stream().toArray(String[]::new);
 */
    @ParametersFactory
        assertBusy(() -> {
                }
        }
            numberOfRelocations,
        for (int i = 20; i < 120; i++) {
        logger.info(
                // we want to control refreshes
            indexingThread.join();
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));
        String nodeId = state.routingTable().index(idx).shard(0).primaryShard().currentNodeId();
        }
                }
        if (randomBoolean()) {
                Settings.builder()
import org.opensearch.search.SearchHits;
                "test",
    public void testRelocationWithDerivedSourceAndTranslog() throws Exception {
        try (BackgroundIndexer indexer = new BackgroundIndexer("test", MapperService.SINGLE_MAPPING_NAME, client(), numDocs)) {
        AtomicBoolean peerRecoveryFailed = new AtomicBoolean(false);
        logger.info("--> verifying no temporary recoveries are left");
                        }
        internalCluster().assertSeqNos();
        internalCluster().startNode();
        }
    }
        CountDownLatch corruptionCount = new CountDownLatch(allowedFailures);
    }
        String node2 = internalCluster().startNode();
                    .execute()
        });
                @Nullable IndexShardState previousState,
        ensureGreen(TimeValue.timeValueMinutes(2));
                assertEquals("test" + id, source.get("name"));
    public void testSimpleRelocationNoIndexing() {
        clusterHealthResponse = client().admin()
            .setWaitForEvents(Priority.LANGUID)
        ensureGreen("test");
        flush();
                  "type": "integer"
                }
            assertSearchHits(afterRelocation, ids.toArray(new String[0]));
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "value", i).get();
                    continue;
        logger.info("--> stopping replica assignment");
        int numberOfRelocations = scaledRandomIntBetween(1, rarely() ? 10 : 4);
            .cluster()
                    client().prepareIndex("test").setId(String.valueOf(id)).setSource("name", "test" + id, "value", id).get();
        } catch (Exception e) {
                    .cluster()
    }
            .put("index.routing.allocation.exclude.color", "blue")
                    .actionGet();
        nodes[0] = internalCluster().startNode();
                if (node.equals(p_node)) {
            .execute()
            .actionGet();
            assertEquals(Integer.parseInt(id), source.get("value"));
            nodes[i] = internalCluster().startNode();
        logger.info("--> start another node");
            .actionGet();
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
        for (MockIndexEventListener.TestEventListener eventListener : internalCluster().getInstances(
                if (expectedCount < 0) {
        for (int i = 0; i < numDocs; i++) {
        // Start second node but block recovery
        flush();
    @Override
        int numDocs = scaledRandomIntBetween(200, 2500);
            Transport.Connection connection,
        client().admin().indices().prepareFlush().execute().actionGet();
            if (indexingThread.isAlive()) {
                ClusterHealthResponse healthResponse = client().admin()
        try {
        for (Thread searchThread : searchThreads) {
                    .execute()
                        .collect(Collectors.toSet());
        final String node_2 = internalCluster().startNode();
            docs[i] = client().prepareIndex("test").setId(id).setSource("field1", English.intToEnglish(i));
        corruptionCount.await();
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, node1);
        prepareCreate(
            // sync global checkpoint quickly so we can verify seq_no_stats aligned between all copies after tests.
            if (!node.equals(clusterService.localNode())) {
                String id = hit.getId();
            ).setMapping(mapping)
            client().prepareIndex("test").setId(String.valueOf(i)).setSource("name", "test" + i, "value", i).get();
        }, 1, TimeUnit.MINUTES);
            .cluster()
import org.opensearch.cluster.service.ClusterService;
    protected void beforeIndexDeletion() throws Exception {
import java.util.Map;
            .cluster()
        logger.info("--> attempt relocation with simulated failure");
        @Override
                .put("index.refresh_interval", -1)
            .prepareHealth()
            for (String node : internalCluster().getNodeNames()) {
        }
        assertThat(client().prepareSearch("test").setSize(0).execute().actionGet().getHits().getTotalHits().value(), equalTo(120L));
            for (Client client : clients()) {
    public void testIndexSearchAndRelocateConcurrently() throws Exception {
        client().admin()
            "testRelocationWhileIndexingRandom(numRelocations={}, numberOfReplicas={}, numberOfNodes={})",
        internalCluster().assertSameDocIdsOnShards();
        String node2 = internalCluster().startNode();
            String action,
                .get();
import org.opensearch.index.IndexService;
        relocationListener.actionGet();
            TransportRequest request,
                    assertEquals(Integer.parseInt(id), source.get("value"));
        String node2 = internalCluster().startNode();
                indexingThread.join(TimeValue.timeValueSeconds(5).millis());
                    .setWaitForNoRelocatingShards(true)
import org.opensearch.test.transport.MockTransportService;
                throw new IOException("Simulated recovery failure");
        // Verify documents are still accessible on original node
        assertHitCount(countResponse, numDocs);
                }
    }
            this.corruptionCount = corruptionCount;
                if (updatedDocs.contains(Integer.parseInt(id))) {
            logger.info("--> done relocations");
            // Stop the indexing
            }
            // wait for shard to reach post recovery
            .cluster()
            assertNoFailures(afterRelocation);
    }
import org.opensearch.transport.client.Client;
                    .actionGet()
            }
                  "type": "integer"
            }
        // Verify all documents including those in translog
        // index while relocating
        logger.info("--> creating test index ...");
                "test",
            for (SearchHit hit : response.getHits()) {
        logger.info("--> index more docs so we have something in the translog");
        for (int i = 0; i < 10; i++) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * license agreements. See the NOTICE file distributed with
        assertBusy(() -> {
            logger.info("--> relocate the shard while indexing");
/*
                if (chunkRequest.name().startsWith(IndexFileNames.SEGMENTS)) {
                "name": {
        for (int i = 0; i < numDocs; i++) {
        final Set<Integer> updatedDocs = ConcurrentCollections.newConcurrentSet();
                logger.info("--> START relocate the shard from {} to {}", nodes[fromNode], nodes[toNode]);
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        final int numIters = randomIntBetween(10, 20);
                ranOnce = true;
        }
        assertThat(clusterHealthResponse.isTimedOut(), equalTo(false));
            indexRandom(true, true, builders2);
        prepareCreate(
        logger.info("--> creating test index ...");
            .put("index.routing.allocation.exclude.color", "red")
                "value": {
                    });
        }
        List<String> nodes = internalCluster().startNodes(nodeSettings);
    public static Collection<Object[]> parameters() {
import org.opensearch.search.SearchHit;
                    .prepareHealth()
        CountDownLatch initialDocCountLatch = new CountDownLatch(initialDocCount);
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).execute().actionGet();
        ActionFuture<ClusterRerouteResponse> relocationListener = client().admin()
                "test",
import org.opensearch.search.sort.SortOrder;
