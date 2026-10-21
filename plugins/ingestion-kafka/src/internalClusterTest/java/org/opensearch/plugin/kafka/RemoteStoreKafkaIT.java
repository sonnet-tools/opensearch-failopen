        setWriteBlock(indexName, true);
        produceData("3", "name3", "30");
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;
    }
        waitForState(() -> "block".equalsIgnoreCase(getSettings(indexName, "index.ingestion_source.error_strategy")));
        flush(indexName);
        // Step 1: Create 2 nodes
        produceData("1", "name1", "24");
                .setSettings(Settings.builder().put("index.routing.allocation.require._name", nodeB))
            indexName,
    }
                    .allMatch(state -> state.isPollerPaused() && state.getPollerState().equalsIgnoreCase("paused"));
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.test.OpenSearchIntegTestCase;
        client().admin().cluster().prepareReroute().add(new AllocateReplicaAllocationCommand(indexName, 0, nodeC)).get();
        produceData("4", "name4", "31");
import java.util.ArrayList;
            assertThat(rangeQueryResponse.getHits().getTotalHits().value(), is(2L));
        assertEquals(3, responsePage1.getTotalShards());
        BoolQueryBuilder query2 = new BoolQueryBuilder().must(new TermQueryBuilder("_id", 2));
            indexName,
        SearchResponse response1 = client().prepareSearch(indexName).setQuery(query1).get();
                .put("ingestion_source.param.topic", topicName)
        // validate next version docs get indexed
        }));
            return ingestionState.getFailedShards() == 0
        );
        internalCluster().startClusterManagerOnlyNode();
        waitForSearchableDocs(2, Arrays.asList(nodeA, nodeB));
        ensureGreen(indexName);
            RangeQueryBuilder rangeQuery = new RangeQueryBuilder("age").gte(23);
        produceData("4", "name4", "20");
    @Override
        assertEquals(30, response1.getHits().getHits()[0].getSourceAsMap().get("age"));
            indexName,
            indexName,
        // Step 4: Verify new primary node is able to index documents
        assertAcked(
        recreateKafkaTopics(5);
            SearchResponse rangeQueryResponse = client().prepareSearch(indexName).setQuery(rangeQuery).get();
        ensureGreen(indexName);
        GetIngestionStateResponse responsePage2 = ingestionStateResponseList.get(1);
        internalCluster().startClusterManagerOnlyNode();
                .getPollingIngestStats();
        // test out-of-order updates
            assertThat(response2.getHits().getTotalHits().value(), is(1L));
        final String nodeC = internalCluster().startDataOnlyNode();
        assertFalse(ingestionState.getShardStates()[0].isPollerPaused());
        assertEquals(3, responsePage2.getTotalShards());
    public void testPaginatedGetIngestionState() throws ExecutionException, InterruptedException {
        assertThat(response2.getHits().getTotalHits().value(), is(1L));
        waitForSearchableDocs(2, Arrays.asList(nodeA, nodeB));
        CreateSnapshotResponse snapshotResponse = client().admin()
        createIndexWithDefaultSettings(1, 1);
        final String nodeA = internalCluster().startDataOnlyNode();
    public void testConsumerResetByTimestamp() throws Exception {
        // Step 4: Stop kafka and relocate index to nodeB
            .prepareCreateSnapshot(snapshotRepositoryName, snapshotName)
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            client().admin()
        produceData("3", "name3", "24");
        resumeIngestion(indexName);
import java.util.Arrays;
            RangeQueryBuilder rangeQuery = new RangeQueryBuilder("age").gte(34);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
                .allMatch(state -> state.isWriteBlockEnabled() && state.getPollerState().equalsIgnoreCase("paused"));
        produceData("2", "", "");
        }
        // validate total polled count is 2
        produceDataWithExternalVersion("2", 3, "name2", "30", defaultMessageTimestamp, "delete");
        produceData("2", "name2", "20");
        createIndexWithDefaultSettings(1, 1);
            PageParams pageParams = new PageParams(nextToken, "asc", 3);
        SearchResponse newReplicaResponse = client(nodeC).prepareSearch(indexName).setQuery(query).setPreference("_only_local").get();
        );
    }
                .put("index.routing.allocation.require._name", nodeA)
        createIndexWithDefaultSettings(1, 1);
    public void testBatchStartPointerOnReplicaPromotion() throws Exception {
        // delete documents 1 and 2
                .put("ingestion_source.pointer.init.reset", "earliest")
        });
            .getPollingIngestStats();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        internalCluster().startClusterManagerOnlyNode();
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
        // Create index with 5 second periodic flush interval
        ensureGreen(indexName);
        produceDataWithExternalVersion("11", 1, "name11", "25", defaultMessageTimestamp, "index");
                .cluster()
        final String nodeA = internalCluster().startDataOnlyNode();
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        );
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        createIndexWithDefaultSettings(1, 1);
        produceData("2", "name2", "22");
        final String nodeB = internalCluster().startDataOnlyNode();
 */
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        // Step 5: Wait for relocation to complete
        assertTrue(Arrays.stream(responsePage3.getShardStates()).allMatch(shardIngestionState -> {
        internalCluster().startDataOnlyNode();
    }
    public void testDefaultGetIngestionState() throws ExecutionException, InterruptedException {
            return indexMatch && shardsMatch;
        produceData("1", "name1", "21");
        });
            .getPollingIngestStats();
        produceDataWithExternalVersion("1", 2, "name1", "30", defaultMessageTimestamp, "index");
        produceData("1", "name1", "24");
        // Step 2: Create index
        String snapshotName = "snapshot-1";
                .put("ingestion_source.error_strategy", "block")
        assertEquals(3, responsePage3.getShardStates().length);
        waitForState(() -> {
        produceData("3", "name3", "24");
        final String node = internalCluster().startDataOnlyNode();
            return stats.getConsumerStats().totalConsumerErrorCount() > 0;
        internalCluster().startClusterManagerOnlyNode();
        produceDataWithExternalVersion("2", 2, "name2", "25", defaultMessageTimestamp, "delete");
        final String nodeB = internalCluster().startDataOnlyNode();
    }
    }
        final String nodeB = internalCluster().startDataOnlyNode();
        });
    public void testExternalVersioning() throws Exception {
        waitForSearchableDocs(11, Arrays.asList(nodeB));
        assertTrue(nodeB.equals(primaryNodeName(indexName)));
        ensureGreen(indexName);
        refresh(indexName);
        refresh(indexName);
            Settings.builder()
        assertAcked(
        createIndexWithDefaultSettings(1, 1);
        assertTrue(Arrays.stream(responsePage1.getShardStates()).allMatch(shardIngestionState -> {
        produceDataWithExternalVersion("1", 2, "name1", "25", defaultMessageTimestamp, "delete");
        // setup nodes and index
        produceDataWithExternalVersion("1", 1, "name1", "25", defaultMessageTimestamp, "index");
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        final String nodeB = internalCluster().startDataOnlyNode();
            return 30 == (Integer) response1.getHits().getHits()[0].getSourceAsMap().get("age")
                .build(),
        produceDataWithExternalVersion("1", 1, "name1", "35", defaultMessageTimestamp, "index");
        waitForSearchableDocs(4, Arrays.asList(nodeA, nodeB));
public class RemoteStoreKafkaIT extends KafkaIngestionBaseIT {
        internalCluster().startClusterManagerOnlyNode();
        assertEquals(1, responsePage4.getSuccessfulShards());
        assertEquals(0, ingestionState.getFailedShards());
            Settings.builder()
        waitForSearchableDocs(4, Arrays.asList(nodeB, nodeC));
                .put("ingestion_source.pointer.init.reset", "earliest")
        assertTrue(Arrays.stream(responsePage2.getShardStates()).allMatch(shardIngestionState -> {
            RangeQueryBuilder rangeQuery = new RangeQueryBuilder("age").gte(23);
        pauseIngestionAndWait(indexName, 1);
            indexName,
        ensureGreen("index1");
        assertEquals(0, stats2.getMessageProcessorStats().totalVersionConflictsCount());
        // malformed message
            .setWaitForCompletion(true)
        waitForSearchableDocs(2, Arrays.asList(nodeA, nodeB));
        assertEquals(1, ingestionState.getShardStates().length);
 * The OpenSearch Contributors require contributions made to
        refresh(indexName);
        waitForState(() -> "drop".equalsIgnoreCase(getSettings(indexName, "index.ingestion_source.error_strategy")));
package org.opensearch.plugin.kafka;
                .put("index.replication.type", "SEGMENT")
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
        final String nodeB = internalCluster().startDataOnlyNode();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.cluster.ClusterState;
        // Step 5: Restore Index from Snapshot
        internalCluster().startClusterManagerOnlyNode();
                .build(),
        // Step 6: Ensure index is searchable on nodeB and can resume ingestion
                .get()
        );
        resumeIngestionAndWait(indexName, 1);
        ensureGreen(indexName);
            assertThat(response.getHits().getTotalHits().value(), is(1L));
            assertThat(response1.getHits().getTotalHits().value(), is(1L));
        ensureGreen(indexName);
    public void testErrorStrategy() throws Exception {
        GetIngestionStateResponse ingestionStateForInvalidShard = getIngestionState(new String[] { indexName }, new int[] { 1 });
@ThreadLeakFilters(filters = TestContainerThreadLeakFilter.class)
        ensureYellowAndNoInitializingShards(indexName);
        assertEquals(3, responsePage1.getShardStates().length);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        verifyRemoteStoreEnabled(nodeC);
 * this file be licensed under the Apache-2.0 license or a
        ensureGreen(indexName);
        ensureGreen(indexName);
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            Settings.builder()
        final String nodeA = internalCluster().startDataOnlyNode();
        waitForSearchableDocs(6, Arrays.asList(nodeB, nodeC));
        assertEquals(2, getSearchableDocCount(nodeB));
        // expect only 1 document to be successfully indexed
            SearchResponse rangeQueryResponse = client().prepareSearch(indexName).setQuery(rangeQuery).get();
        produceDataWithExternalVersion("4", 1, "name4", "25", defaultMessageTimestamp, "index");
        // pause ingestion
        SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
 */
        produceData("2", "name2", "20");
        });
        assertEquals(3, responsePage1.getSuccessfulShards());
        }
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        waitForState(() -> {
            .get();
        );
        kafka.stop();
        waitForSearchableDocs(1, Arrays.asList(nodeA, nodeB));
        resumeIngestionWithResetAndWait(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "2", 1);
            return true;
        internalCluster().startClusterManagerOnlyNode();
            .indices()
                .build(),
            return state.getRoutingTable().hasIndex(indexName) == false && state.getMetadata().hasIndex(indexName) == false;
            return true;
        final String nodeA = internalCluster().startDataOnlyNode();
        pauseIngestionAndWait(indexName, 1);
        produceData("6", "name6", "41");
            ingestionStatePage = getIngestionState(new String[] { "index1", "index2" }, new int[] { 0, 1, 2, 3, 4 }, pageParams);
        GetIngestionStateResponse responsePage1 = ingestionStateResponseList.get(0);
            indexName,
                .put("ingestion_source.internal_queue_size", "1000")
                .put("ingestion_source.internal_queue_size", "1000")
 * SPDX-License-Identifier: Apache-2.0
            .cluster()
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startClusterManagerOnlyNode();
        waitForState(() -> nodeB.equals(primaryNodeName(indexName)));
        assertEquals(2L, finalStats.getMessageProcessorStats().totalProcessedCount());
        createIndexWithDefaultSettings("index1", 5, 0, 1);
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
                .prepareUpdateSettings(indexName)
        // Step 5: Verify nodeA has the primary shard
        produceData("{\"_op_type\":\"invalid\",\"_source\":{\"name\":\"name4\", \"age\": 25}}");
        assertEquals(1, ingestionState.getSuccessfulShards());
        waitForState(() -> {
/*
        assertThat(stats.getMessageProcessorStats().totalFailedCount(), is(1L));
        verifyRemoteStoreEnabled(nodeA);
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        produceData("2", "name2", "20");
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
                .build(),
            .put(super.nodeSettings(nodeOrdinal))
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        // remove write block
            .setIndices(indexName)
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        // revalidate that only 1 document is visible
        });
                .put("index.routing.allocation.require._name", nodeA)
import java.nio.file.Path;
        }));
        final String nodeB = internalCluster().startDataOnlyNode();
    public void testPeriodicFlush() throws Exception {
        produceDataWithExternalVersion("1", 1, "name1", "25", defaultMessageTimestamp, "index");
        return Settings.builder()
        waitForSearchableDocs(1, Arrays.asList(node));
        assertEquals(3, responsePage2.getShardStates().length);
        waitForSearchableDocs(2, List.of(nodeA));
    }
        assertThat(stats.getConsumerStats().totalPollerMessageFailureCount(), is(0L));
                && Arrays.stream(ingestionState.getShardStates())
        // Step 4: Relocate index to nodeB
                .put("ingestion_source.type", "kafka")
        ensureGreen(indexName);
    public void testOffsetUpdateOnBlockErrorPolicy() throws Exception {
        // validate index operation with lower version creates new document
        final String nodeB = internalCluster().startDataOnlyNode();
                .put("index.gc_deletes", "0")
        produceData("4", "name4", "20");
        verifyRemoteStoreEnabled(nodeB);
        internalCluster().startClusterManagerOnlyNode();
        SearchResponse replicaResponse = client(nodeB).prepareSearch(indexName).setQuery(query).setPreference("_only_local").get();
        final String nodeA = internalCluster().startDataOnlyNode();
        createIndex(
                .getPollingIngestStats();
        assertThat(stats.getConsumerStats().totalConsumerErrorCount(), is(0L));
        waitForSearchableDocs(2, Arrays.asList(nodeA));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertNotNull(finalStats);
                .put("ingestion_source.param.topic", topicName)
        // Start nodes
                .put("ingestion_source.type", "kafka")
        assertNotNull(stats);
        GetSettingsResponse settingsResponse = client(node).admin().indices().prepareGetSettings(indexName).get();
        internalCluster().startClusterManagerOnlyNode();
        final String nodeB = internalCluster().startDataOnlyNode();
                .put("index.replication.type", "SEGMENT")
        produceData("1", "name1", "24");
                    .allMatch(state -> state.isWriteBlockEnabled() && state.getPollerState().equalsIgnoreCase("paused"));
        verifyRemoteStoreEnabled(nodeA);
        }
        );
                .put("ingestion_source.param.topic", topicName)
                .put("ingestion_source.pointer.init.reset", "earliest")
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
import static org.hamcrest.Matchers.is;
        produceDataWithExternalVersion("2", 1, "name2", "25", defaultMessageTimestamp, "index");
        ensureYellowAndNoInitializingShards(indexName);
                .put("ingestion_source.param.topic", topicName)
        // validate page 3
        // Step 2: Create index on nodeA
        produceData("1", "name1", "25");
                .prepareUpdateSettings(indexName)
        // validate page 1
            boolean shardsMatch = Set.of(0, 1, 2).contains(shardIngestionState.getShardId());
        internalCluster().startDataOnlyNode();
            assertThat(rangeQueryResponse.getHits().getTotalHits().value(), is(2L));
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
    public void testClusterWriteBlock() throws Exception {
        // Step 5: Wait for relocation to complete
        ensureGreen(indexName);
        waitForState(() -> {
        createIndex(
        client().admin()
        ensureGreen(indexName);
        createIndex(
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
        client().admin().cluster().prepareReroute().add(new AllocateReplicaAllocationCommand(indexName, 0, nodeC)).get();
        // Step 3: Create index with 1 replica
        assertThat(stats.getConsumerStats().totalPollerMessageDroppedCount(), is(1L));
    }
        for (int i = 1; i <= 10; i++) {
        assertEquals(1, responsePage4.getShardStates().length);
        final String nodeA = internalCluster().startDataOnlyNode();
        produceData("1", "name1", "21", 100, "index");
        waitForState(() -> {
            .setIndices(indexName)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
    }
        final String nodeB = internalCluster().startDataOnlyNode();
        waitForSearchableDocs(4, Arrays.asList(nodeA, nodeB));
    private Path absolutePath;
        assertEquals("DROP", ingestionState.getShardStates()[0].getErrorPolicy());
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            return indexMatch && shardsMatch;
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
    public void testCloseIndex() throws Exception {
            .getPollingIngestStats();
        while (ingestionStatePage == null || ingestionStatePage.getNextPageToken() != null) {
        // verify write block state in poller is persisted
        waitForSearchableDocs(4, Arrays.asList(nodeA, nodeB));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
                .build(),
            indexName,
            .prepareRestoreSnapshot(snapshotRepositoryName, snapshotName)
    }
        waitForSearchableDocs(2, List.of(nodeA));
                .build(),
    public void testKafkaConnectionLost() throws Exception {
        assertEquals(0, ingestionState.getShardStates()[0].getShardId());
                .put("ingestion_source.type", "kafka")
            return Arrays.stream(ingestionState.getShardStates())
        waitForSearchableDocs(2, List.of(nodeB));
        assertThat(stats.getMessageProcessorStats().totalFailuresDroppedCount(), is(1L));
            0,
        refresh(indexName);
            SearchResponse response1 = client().prepareSearch(indexName).setQuery(query1).get();
        produceData("5", "name5", "40");
        createIndexWithDefaultSettings(1, 1);
            client().admin()
        createIndex(
        waitForState(() -> getPeriodicFlushCount(nodeA, indexName) >= 1);
        });
        assertEquals(1, ingestionState.getTotalShards());
        client().admin()
        waitForSearchableDocs(1, Arrays.asList(nodeA, nodeB));
        waitForSearchableDocs(1, Arrays.asList(nodeA, nodeB));
        assertTrue(resumeResponse.isAcknowledged());
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(23);
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            boolean shardsMatch = shardIngestionState.getShardId() == 4;
import java.util.List;
        assertAcked(client().admin().indices().prepareDelete(indexName));
        // Step 1: Create 2 nodes
            .setWaitForCompletion(true)
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
        assertTrue(nodeB.equals(replicaNodeName(indexName)));
        );
        ensureGreen(indexName);
            .build();
        // Step 1: Create primary and replica nodes. Create index with 1 replica and kafka as ingestion source.
                .setSettings(Settings.builder().put("location", randomRepoPath()).put("compress", false))
            ClusterState state = client().admin().cluster().prepareState().setIndices(indexName).get().getState();
        // setup nodes and index using block strategy
        });
            String nextToken = ingestionStatePage == null ? null : ingestionStatePage.getNextPageToken();
                .put("ingestion_source.pointer.init.reset", "earliest")
        // Step 3: Take snapshot
        internalCluster().startClusterManagerOnlyNode();
        produceDataWithExternalVersion("1", 1, "name1", "25", defaultMessageTimestamp, "delete");
                .put("ingestion_source.param.topic", topicName)
        produceData("2", "name2", "20");
            .prepareUpdateSettings(indexName)
        assertEquals(3, responsePage2.getSuccessfulShards());
        final String nodeA = internalCluster().startDataOnlyNode();
        // validate page 2
        ensureYellowAndNoInitializingShards(indexName);
import org.opensearch.test.InternalTestCluster;
        // test deletes with smaller version
        // validate processor stats
        ensureGreen(indexName);
        // Step 3: Write documents and verify
        // Step 4: Delete Index
        // Step 10: Wait for 11 messages to be visible on nodeB
        produceDataWithExternalVersion("3", 1, "name3", "25", defaultMessageTimestamp, "index");
            boolean indexMatch = "index1".equalsIgnoreCase(shardIngestionState.getIndex());
        client().admin().indices().close(Requests.closeIndexRequest(indexName)).get();
        produceData("1", "name1", "24");
            return ingestionState.getFailedShards() == 0
                .put("ingestion_source.error_strategy", "drop")
                .get()
        });
        assertEquals(2, stats1.getConsumerStats().totalPolledCount());
        assertThat(response1.getHits().getTotalHits().value(), is(1L));
        assertTrue(nodeC.equals(replicaNodeName(indexName)));
        produceDataWithExternalVersion("2", 2, "name2", "30", defaultMessageTimestamp, "index");
        produceData("3", "name3", "25");
import org.opensearch.index.query.BoolQueryBuilder;
        produceDataWithExternalVersion("1", 1, "name1", "25", defaultMessageTimestamp, "index");
        waitForState(() -> nodeB.equals(primaryNodeName(indexName)));
        final String nodeB = internalCluster().startDataOnlyNode();
        createIndex(
        assertThat(response.getHits().getTotalHits().value(), is(4L));
        PollingIngestStats stats2 = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
            assertThat(rangeQueryResponse.getHits().getTotalHits().value(), is(2L));
        waitForSearchableDocs(4, Arrays.asList(nodeA, nodeB));
        waitForSearchableDocs(10, Arrays.asList(nodeA, nodeB));
    protected Settings nodeSettings(int nodeOrdinal) {
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
        waitForSearchableDocs(4, List.of(nodeB));
        waitForSearchableDocs(2, Arrays.asList(nodeA, nodeB));
        produceData("3", "name3", "24");
    }
            BoolQueryBuilder query1 = new BoolQueryBuilder().must(new TermQueryBuilder("_id", 1));
        final String nodeB = internalCluster().startDataOnlyNode();
                .put("ingestion_source.param.auto.offset.reset", "earliest")
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        produceData("2", "name2", "20");
    }
        assertEquals(4, ingestionStateResponseList.size());
                .put("ingestion_source.type", "kafka")
            indexName,
        ensureGreen(indexName);
        produceDataWithExternalVersion("3", 1, "name3", "25", defaultMessageTimestamp, "index");
        produceData("5", "name5", "25");
            produceDataWithExternalVersion(String.valueOf(i), 1, "name" + i, "25", defaultMessageTimestamp, "index");
                .put("ingestion_source.pointer.init.reset", "earliest")
        createIndex(
        // Step 6: Verify index is restored and resumes ingestion from the 3rd message
        assertTrue(nodeC.equals(replicaNodeName(indexName)));
        PollingIngestStats stats1 = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        // pause ingestion
            return true;
            .getPollingIngestStats();
            produceData(String.valueOf(i), "name" + i, "25");
        produceData("2", "name2", "20");
        // Step 1: Publish 10 messages
        // Step 9: Publish 1 new message
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
        final String nodeA = internalCluster().startDataOnlyNode();
        assertThat(stats.getMessageProcessorStats().totalVersionConflictsCount(), is(3L));
            return matchIndex1 || matchIndex2;
        ensureGreen(indexName);
        });
            SearchResponse rangeQueryResponse = client().prepareSearch(indexName).setQuery(rangeQuery).get();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // update offset to skip past the invalid message
        GetIngestionStateResponse responsePage4 = ingestionStateResponseList.get(3);
        );
        List<GetIngestionStateResponse> ingestionStateResponseList = new ArrayList<>();
        waitForSearchableDocs(2, List.of(nodeB));
        waitForState(() -> {
        waitForState(() -> {
import org.opensearch.transport.client.Requests;
        ensureGreen(indexName);
        // Step 6: Produce new updates and verify segment replication works when primary and replica index are not empty.
        ensureGreen(indexName);
            absolutePath = randomRepoPath().toAbsolutePath();
            return indexMatch && shardsMatch;
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
                .indices()
                .put("ingestion_source.type", "kafka")
        // reset consumer by a timestamp after first message was produced
        // Step 2: Produce update messages and validate segment replication
        produceData("3", "name3", "24", 110, "index");
            .setSettings(Settings.builder().put("ingestion_source.error_strategy", "drop"))
        assertThat(newPrimaryResponse.getHits().getTotalHits().value(), is(3L));
        // Step 2: Start nodes
        produceData("1", "name1", "24");
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.util.concurrent.ExecutionException;
        waitForSearchableDocs(4, Arrays.asList(nodeA, nodeB));
        createIndex(
        internalCluster().startDataOnlyNode();
            .cluster()
        client().admin().cluster().prepareReroute().add(new AllocateReplicaAllocationCommand(indexName, 0, nodeC)).get();
        );
        internalCluster().startClusterManagerOnlyNode();
        waitForSearchableDocs(4, Arrays.asList(nodeC));
        waitForState(() -> {
import org.opensearch.action.search.SearchResponse;
        SearchResponse primaryResponse = client(nodeA).prepareSearch(indexName).setQuery(query).setPreference("_only_local").get();
        // Step 2: Register snapshot repository
        assertTrue(Arrays.stream(responsePage4.getShardStates()).allMatch(shardIngestionState -> {
                .indices()
import org.opensearch.action.pagination.PageParams;
        waitForSearchableDocs(3, Arrays.asList(nodeA, nodeB));
        }));
        // Step 7: Flush to persist data
        // Step 8: Bring down nodeA (primary) and wait for nodeB to become primary
        produceDataWithExternalVersion("4", 1, "name4", "35", defaultMessageTimestamp, "index");
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        assertEquals(2, getSearchableDocCount(nodeB));
        assertTrue(nodeB.equals(primaryNodeName(indexName)));
        refresh(indexName);
        // Step 11: Validate version conflict count is exactly 1
        assertNotNull(stats);
        // produce one invalid message to block the processor
                .setSettings(Settings.builder().put("index.routing.allocation.require._name", nodeB))
                && Arrays.stream(ingestionState.getShardStates()).allMatch(state -> state.isWriteBlockEnabled() == false);
        String snapshotRepositoryName = "test-snapshot-repo";
        verifyRemoteStoreEnabled(nodeB);
        produceData("4", "name4", "31");
            boolean shardsMatch = Set.of(1, 2, 3).contains(shardIngestionState.getShardId());
            boolean matchIndex2 = shardIngestionState.getShardId() == 0 && "index2".equalsIgnoreCase(shardIngestionState.getIndex());
        ensureGreen(indexName);
        waitForSearchableDocs(10, Arrays.asList(nodeA));
        });
        ensureYellowAndNoInitializingShards(indexName);
        final String nodeC = internalCluster().startDataOnlyNode();
        assertTrue(nodeC.equals(replicaNodeName(indexName)));
                && 30 == (Integer) response2.getHits().getHits()[0].getSourceAsMap().get("age");
                && "index1".equalsIgnoreCase(shardIngestionState.getIndex());
        String remoteStoreEnabled = settingsResponse.getIndexToSettings().get(indexName).get("index.remote_store.enabled");
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", 3));
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        // setup nodes and index
            Settings.builder()
        assertEquals("Remote store should be enabled", "true", remoteStoreEnabled);
        // Step 3: Stop current primary node and validate replica promotion.
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
            .get();
        // Step 6: Wait for 10 messages to be searchable on both nodes
        // setup nodes and index
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                .put("ingestion_source.type", "kafka")
        // setup nodes and index
        final String nodeA = internalCluster().startDataOnlyNode();
            boolean indexMatch = "index2".equalsIgnoreCase(shardIngestionState.getIndex());
 *
        assertThat(replicaResponse.getHits().getTotalHits().value(), is(1L));
                .put("index.periodic_flush_interval", "5s")
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        // expect error response since ingestion not yet paused
            "100"
                .put("ingestion_source.param.topic", topicName)
        }
                .build(),
                && Arrays.stream(ingestionState.getShardStates())
        assertThat(stats.getMessageProcessorStats().totalProcessedCount(), is(11L));
                .put("ingestion_source.pointer.init.reset", "earliest")
        // pause ingestion
                .put("index.replication.type", "SEGMENT")
            boolean indexMatch = "index2".equalsIgnoreCase(shardIngestionState.getIndex());
            SearchResponse response2 = client().prepareSearch(indexName).setQuery(query2).get();
        waitForSearchableDocs(3, Arrays.asList(node));
        verifyRemoteStoreEnabled(nodeA);
            return 25 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        produceDataWithExternalVersion("2", 1, "name2", "25", defaultMessageTimestamp, "index");
        waitForSearchableDocs(4, Arrays.asList(nodeB));
        // test deletes with correct version
        createIndexWithDefaultSettings(1, 1);
        }));
        // after index is restored, it should resume ingestion from batchStartPointer available in the latest commit
            .get();
        flush(indexName);
        // resume ingestion
                .put("index.replication.type", "SEGMENT")
 * Integration tests for segment replication with remote store using kafka as ingestion source.
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        produceData("3", "name3", "30");
        waitForState(() -> {
        ensureGreen("index2");
                .put("ingestion_source.type", "kafka")
        assertTrue(nodeB.equals(primaryNodeName(indexName)));
        // validate remaining messages are successfully indexed
                .put("ingestion_source.type", "kafka")
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
import org.opensearch.common.settings.Settings;
        // validate page 4
        GetIngestionStateResponse ingestionState = getIngestionState(new String[] { indexName }, new int[] { 0 });
                .put("ingestion_source.param.auto.offset.reset", "earliest")
            indexName,
        assertThat(primaryResponse.getHits().getTotalHits().value(), is(1L));
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        waitForSearchableDocs(4, Arrays.asList(nodeB, nodeC));
        SearchResponse newPrimaryResponse = client(nodeB).prepareSearch(indexName).setQuery(query).setPreference("_only_local").get();
        );
        // Publish 10 messages
        assertEquals(30, response2.getHits().getHits()[0].getSourceAsMap().get("age"));
        assertEquals(1, responsePage4.getTotalShards());
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        pauseIngestionAndWait(indexName, 1);
        assertTrue(snapshotResponse.getSnapshotInfo().successfulShards() > 0);
        // create a write block
        assertThat(newReplicaResponse.getHits().getTotalHits().value(), is(3L));
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        produceData("4", "name4", "31");
        assertEquals(1, resumeResponse.getShardFailures().length);
            ingestionStateResponseList.add(ingestionStatePage);
            BoolQueryBuilder query2 = new BoolQueryBuilder().must(new TermQueryBuilder("_id", 2));
        final String nodeA = internalCluster().startDataOnlyNode();
        assertAcked(
    public void testIndexRelocation() throws Exception {
import org.opensearch.index.query.RangeQueryBuilder;
        produceData("3", "name3", "30");
/**
    public void testSegmentReplicationWithRemoteStore() throws Exception {
        );
    public void testExternalVersioningWithDisabledGCDeletes() throws Exception {
            return stats.getConsumerStats().totalPolledCount() == 3;
            boolean matchIndex1 = Set.of(3, 4).contains(shardIngestionState.getShardId())
        final String nodeA = internalCluster().startDataOnlyNode();
        waitForState(() -> {
        assertEquals(3, responsePage3.getSuccessfulShards());
        assertFalse(resumeResponse.isShardsAcknowledged());
        ensureGreen(indexName);
        assertThat(stats.getConsumerStats().totalPolledCount(), is(3L));
        waitForSearchableDocs(2, Arrays.asList(nodeA, nodeB));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            ResumeIngestionRequest.ResetSettings.ResetMode.TIMESTAMP,
        ensureYellowAndNoInitializingShards(indexName);
        // Step 3: Write documents and verify
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
    private static final String REPOSITORY_NAME = "test-remote-store-repo";
        refresh(indexName);
 * compatible open source license.
    }
            Settings.builder()
        resumeIngestionWithResetAndWait(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.TIMESTAMP, "102", 1);
        produceData("2", "name2", "22", 105, "index");
        assertEquals(1L, finalStats.getMessageProcessorStats().totalVersionConflictsCount());
        // for page size of 3, we expect 4 pages in total
            client().admin()
        ResumeIngestionResponse resumeResponse = resumeIngestion(
        assertTrue(nodeB.equals(primaryNodeName(indexName)));
        );
        final String nodeA = internalCluster().startDataOnlyNode();
        // Step 1: Setup index and data
import org.opensearch.index.query.TermQueryBuilder;
        setWriteBlock(indexName, false);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            Settings.builder()
        assertEquals(3, stats2.getConsumerStats().totalPolledCount());
            Settings.builder()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        final String nodeA = internalCluster().startDataOnlyNode();
        produceDataWithExternalVersion("1", 3, "name1", "30", defaultMessageTimestamp, "delete");
                .put("index.replication.type", "SEGMENT")
        refresh(indexName);
                .put("ingestion_source.param.topic", topicName)
        // Step 5: Add a new node and assign the replica shard. Verify node recovery works.
        internalCluster().startDataOnlyNode();
                .put("ingestion_source.internal_queue_size", "1000")
import org.opensearch.indices.pollingingest.PollingIngestStats;
        // verify ingestion state is persisted
        produceData("4", "name4", "24");
                .setType("fs")
    public void testRemoteSnapshotRestore() throws Exception {
        // we have 2 index, each with 5 shards, total of 10 shards
            .getPollingIngestStats();
    }
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(21);
    public void testPauseAndResumeIngestion() throws Exception {
        assertEquals(0, ingestionStateForInvalidShard.getTotalShards());
        final String nodeC = internalCluster().startDataOnlyNode();
        produceData("1", "name1", "24");
        final String nodeB = internalCluster().startDataOnlyNode();
        assertHitCount(client().prepareSearch(indexName).get(), 4);
                .put("ingestion_source.error_strategy", "block")
        createIndexWithDefaultSettings("index2", 5, 0, 1);
    private void verifyRemoteStoreEnabled(String node) {
        flush(indexName);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        produceData("{\"_op_type\":\"invalid\",\"_source\":{\"name\":\"name4\", \"age\": 25}}");
    }
        ensureGreen(indexName);
        ensureYellowAndNoInitializingShards(indexName);
                .put("ingestion_source.param.topic", topicName)
        // Step 6: Ensure index is searchable on nodeB even though kafka is down
        for (int i = 1; i <= 10; i++) {
        produceData("4", "name4", "24", 120, "index");
        assertEquals("POLLING", ingestionState.getShardStates()[0].getPollerState());
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        // Step 4: Add second node and verify green status
    }
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        produceData("1", "name1", "24");
        ensureYellowAndNoInitializingShards(indexName);
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;
        GetIngestionStateResponse ingestionStatePage = null;
        waitForState(() -> {
import org.opensearch.cluster.metadata.IndexMetadata;
        });
        flush(indexName);
        if (absolutePath == null) {
        waitForState(() -> {
        // insert documents
                .put("index.replication.type", "SEGMENT")
        internalCluster().startClusterManagerOnlyNode();
        createIndex(
        produceDataWithExternalVersion("2", 1, "name2", "25", defaultMessageTimestamp, "index");
        assertTrue(nodeB.equals(replicaNodeName(indexName)));
        produceData("2", "name2", "20");
            return ingestionState.getFailedShards() == 0
        });
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))
                .build(),
            .getPollingIngestStats();
        BoolQueryBuilder query1 = new BoolQueryBuilder().must(new TermQueryBuilder("_id", 1));
import java.util.Set;
            Settings.builder()
        GetIngestionStateResponse responsePage3 = ingestionStateResponseList.get(2);
        refresh(indexName);
        PollingIngestStats finalStats = client(nodeB).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
                .preparePutRepository(snapshotRepositoryName)
    }
        SearchResponse response2 = client().prepareSearch(indexName).setQuery(query2).get();
        assertEquals(3, responsePage3.getTotalShards());
}
