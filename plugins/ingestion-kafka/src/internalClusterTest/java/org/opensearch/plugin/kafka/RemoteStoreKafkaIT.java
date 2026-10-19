                .put("index.replication.type", "SEGMENT")
        createIndexWithDefaultSettings(1, 1);
        assertEquals(0, ingestionState.getShardStates()[0].getShardId());
            "100"  
            .getPollingIngestStats();  
                .put("index.replication.type", "SEGMENT")  
                .put("ingestion_source.pointer.init.reset", "earliest")
        assertThat(response1.getHits().getTotalHits().value(), is(1L));  
        produceData("5", "name5", "25");
        setWriteBlock(indexName, false);  
        // Create index with 5 second periodic flush interval
                .put("ingestion_source.type", "kafka")  
            .getPollingIngestStats();
        waitForSearchableDocs(4, Arrays.asList(nodeA, nodeB));
        ResumeIngestionResponse resumeResponse = resumeIngestion(
        refresh(indexName);
        assertNotNull(stats);
        assertTrue(Arrays.stream(responsePage3.getShardStates()).allMatch(shardIngestionState -> {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Step 8: Bring down nodeA (primary) and wait for nodeB to become primary
                    .allMatch(state -> state.isWriteBlockEnabled() && state.getPollerState().equalsIgnoreCase("paused"));
        assertEquals(3, responsePage2.getTotalShards());
        final String nodeA = internalCluster().startDataOnlyNode();  
        assertEquals(0, stats2.getMessageProcessorStats().totalVersionConflictsCount());
        waitForSearchableDocs(4, Arrays.asList(nodeB, nodeC));  
        waitForSearchableDocs(2, List.of(nodeA));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        createIndex(  
        waitForState(() -> {
        waitForState(() -> {
        // Step 7: Flush to persist data
package org.opensearch.plugin.kafka;
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        final String nodeA = internalCluster().startDataOnlyNode();
        // validate remaining messages are successfully indexed
                .put("ingestion_source.internal_queue_size", "1000")  
                .put("ingestion_source.param.auto.offset.reset", "earliest")
        internalCluster().startClusterManagerOnlyNode();
        internalCluster().startClusterManagerOnlyNode();
                .put("index.replication.type", "SEGMENT")  
        // expect only 1 document to be successfully indexed
        final String nodeA = internalCluster().startDataOnlyNode();  
        });
 * compatible open source license.
        ensureGreen(indexName);  
        );  
        // validate total polled count is 2  
        ensureGreen(indexName);  
        produceData("3", "name3", "24");  
        // validate index operation with lower version creates new document
        produceData("{\"_op_type\":\"invalid\",\"_source\":{\"name\":\"name4\", \"age\": 25}}");
            .get();
        PollingIngestStats finalStats = client(nodeB).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        });
            .put(super.nodeSettings(nodeOrdinal))  
    }
    public void testOffsetUpdateOnBlockErrorPolicy() throws Exception {  
import java.util.ArrayList;
            ingestionStateResponseList.add(ingestionStatePage);  
        waitForSearchableDocs(4, Arrays.asList(nodeA, nodeB));
        assertEquals(3, responsePage1.getSuccessfulShards());
        produceData("3", "name3", "24");
        assertThat(stats.getMessageProcessorStats().totalFailedCount(), is(1L));  
        produceData("3", "name3", "30");
                .build(),
            BoolQueryBuilder query2 = new BoolQueryBuilder().must(new TermQueryBuilder("_id", 2));  
            assertThat(response1.getHits().getTotalHits().value(), is(1L));
                .build(),
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            indexName,  
                .put("ingestion_source.pointer.init.reset", "earliest")
        resumeIngestionAndWait(indexName, 1);
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
        waitForSearchableDocs(1, Arrays.asList(nodeA, nodeB));  
                .preparePutRepository(snapshotRepositoryName)  
        waitForSearchableDocs(10, Arrays.asList(nodeA, nodeB));  
        final String node = internalCluster().startDataOnlyNode();
        produceData("2", "name2", "20");  
            return 25 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");
        assertTrue(nodeB.equals(primaryNodeName(indexName)));
        final String nodeA = internalCluster().startDataOnlyNode();
        waitForSearchableDocs(10, Arrays.asList(nodeA));  
            PageParams pageParams = new PageParams(nextToken, "asc", 3);
        // Step 5: Add a new node and assign the replica shard. Verify node recovery works.  
            .indices()
        // reset consumer by a timestamp after first message was produced  
        produceData("3", "name3", "24");  
            indexName,
        ensureGreen(indexName);
        final String nodeC = internalCluster().startDataOnlyNode();  
        assertEquals(3, responsePage1.getTotalShards());  
        internalCluster().startClusterManagerOnlyNode();
        createIndex(  
            .setWaitForCompletion(true)  
        PollingIngestStats stats1 = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
        // Step 2: Create index on nodeA
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        internalCluster().startClusterManagerOnlyNode();
        assertThat(newReplicaResponse.getHits().getTotalHits().value(), is(3L));
        ensureGreen(indexName);
        });  
        assertThat(stats.getConsumerStats().totalPollerMessageFailureCount(), is(0L));  
        assertEquals(3, responsePage3.getShardStates().length);
        produceDataWithExternalVersion("11", 1, "name11", "25", defaultMessageTimestamp, "index");
        // Step 2: Create index
        ensureYellowAndNoInitializingShards(indexName);  
        waitForState(() -> nodeB.equals(primaryNodeName(indexName)));  
        waitForSearchableDocs(2, List.of(nodeB));
                .put("ingestion_source.param.topic", topicName)
            indexName,
        waitForSearchableDocs(4, Arrays.asList(nodeA, nodeB));  
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, absolutePath))
        // remove write block
        pauseIngestionAndWait(indexName, 1);  
        final String nodeB = internalCluster().startDataOnlyNode();  
        // Step 3: Write documents and verify
            boolean indexMatch = "index2".equalsIgnoreCase(shardIngestionState.getIndex());
        final String nodeC = internalCluster().startDataOnlyNode();  
                && 30 == (Integer) response2.getHits().getHits()[0].getSourceAsMap().get("age");
        GetIngestionStateResponse responsePage3 = ingestionStateResponseList.get(2);
        waitForSearchableDocs(1, Arrays.asList(node));
        produceDataWithExternalVersion("1", 1, "name1", "25", defaultMessageTimestamp, "index");
 */  
        waitForState(() -> {
    }
                .put("index.replication.type", "SEGMENT")
        createIndex(  
        verifyRemoteStoreEnabled(nodeC);  
        setWriteBlock(indexName, true);  
        createIndexWithDefaultSettings(1, 1);  
        // validate page 4
        ensureGreen(indexName);
        produceData("2", "name2", "22", 105, "index");
    }  
        assertThat(response.getHits().getTotalHits().value(), is(4L));
        final String nodeB = internalCluster().startDataOnlyNode();  
        pauseIngestionAndWait(indexName, 1);
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
/*  
        internalCluster().startClusterManagerOnlyNode();
        assertEquals(1, responsePage4.getTotalShards());
            .setWaitForCompletion(true)
        ensureYellowAndNoInitializingShards(indexName);
        waitForSearchableDocs(4, Arrays.asList(nodeA, nodeB));
        produceData("1", "name1", "24");
        assertAcked(  
        final String nodeA = internalCluster().startDataOnlyNode();
    }  
        assertEquals(1L, finalStats.getMessageProcessorStats().totalVersionConflictsCount());  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        final String nodeA = internalCluster().startDataOnlyNode();
                .put("ingestion_source.param.topic", topicName)  
    public void testExternalVersioning() throws Exception {
        assertEquals(1, responsePage4.getSuccessfulShards());
        internalCluster().startClusterManagerOnlyNode();
        final String nodeB = internalCluster().startDataOnlyNode();  
    public void testPaginatedGetIngestionState() throws ExecutionException, InterruptedException {
    }  
            Settings.builder()  
                .put("index.replication.type", "SEGMENT")  
 * Integration tests for segment replication with remote store using kafka as ingestion source.
            .prepareCreateSnapshot(snapshotRepositoryName, snapshotName)  
        client().admin()  
                .allMatch(state -> state.isWriteBlockEnabled() && state.getPollerState().equalsIgnoreCase("paused"));
import java.util.Arrays;  
        waitForState(() -> {
        while (ingestionStatePage == null || ingestionStatePage.getNextPageToken() != null) {
        ensureYellowAndNoInitializingShards(indexName);
                && Arrays.stream(ingestionState.getShardStates())
        assertEquals(1, ingestionState.getShardStates().length);
        // pause ingestion
    }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        SearchResponse replicaResponse = client(nodeB).prepareSearch(indexName).setQuery(query).setPreference("_only_local").get();
                .setSettings(Settings.builder().put("index.routing.allocation.require._name", nodeB))
            indexName,
        ensureGreen("index2");
        assertEquals(2, getSearchableDocCount(nodeB));
            absolutePath = randomRepoPath().toAbsolutePath();  
            produceData(String.valueOf(i), "name" + i, "25");
            client().admin()
    public void testCloseIndex() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.is;
        // Step 4: Relocate index to nodeB
                .put("index.replication.type", "SEGMENT")
            assertThat(rangeQueryResponse.getHits().getTotalHits().value(), is(2L));
        // Step 2: Produce update messages and validate segment replication
            boolean matchIndex2 = shardIngestionState.getShardId() == 0 && "index2".equalsIgnoreCase(shardIngestionState.getIndex());
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                .put("ingestion_source.error_strategy", "block")  
        ensureGreen(indexName);
        // Step 3: Create index with 1 replica
    }
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        produceData("4", "name4", "20");  
        ensureYellowAndNoInitializingShards(indexName);  
        assertEquals(1, ingestionState.getSuccessfulShards());
        // setup nodes and index
        // Step 4: Stop kafka and relocate index to nodeB
        final String nodeB = internalCluster().startDataOnlyNode();  
import org.opensearch.index.query.TermQueryBuilder;
        }));
        produceDataWithExternalVersion("1", 3, "name1", "30", defaultMessageTimestamp, "delete");
    }
        for (int i = 1; i <= 10; i++) {  
        ensureGreen(indexName);  
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
        internalCluster().startDataOnlyNode();  
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
import java.util.Set;
            Settings.builder()
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
            .setIndices(indexName)
        produceData("3", "name3", "24", 110, "index");  
        SearchResponse response2 = client().prepareSearch(indexName).setQuery(query2).get();
                    .allMatch(state -> state.isPollerPaused() && state.getPollerState().equalsIgnoreCase("paused"));
                .indices()  
        flush(indexName);  
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(21);
        assertEquals(30, response1.getHits().getHits()[0].getSourceAsMap().get("age"));
        );
        internalCluster().startClusterManagerOnlyNode();  
        verifyRemoteStoreEnabled(nodeB);
        waitForSearchableDocs(2, Arrays.asList(nodeA, nodeB));  
        waitForSearchableDocs(4, Arrays.asList(nodeB, nodeC));
            return 30 == (Integer) response1.getHits().getHits()[0].getSourceAsMap().get("age")  
        assertHitCount(client().prepareSearch(indexName).get(), 4);
                .put("index.gc_deletes", "0")
    public void testRemoteSnapshotRestore() throws Exception {
        waitForSearchableDocs(1, Arrays.asList(nodeA, nodeB));
            0,
        assertTrue(Arrays.stream(responsePage4.getShardStates()).allMatch(shardIngestionState -> {
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
        assertThat(response2.getHits().getTotalHits().value(), is(1L));
        produceData("4", "name4", "31");
        createIndex(
                .put("ingestion_source.internal_queue_size", "1000")
    public void testKafkaConnectionLost() throws Exception {
        SearchResponse newReplicaResponse = client(nodeC).prepareSearch(indexName).setQuery(query).setPreference("_only_local").get();  
            indexName,
        assertThat(stats.getConsumerStats().totalPolledCount(), is(3L));
    public void testErrorStrategy() throws Exception {
        produceData("4", "name4", "24");
        String remoteStoreEnabled = settingsResponse.getIndexToSettings().get(indexName).get("index.remote_store.enabled");  
        produceDataWithExternalVersion("2", 2, "name2", "30", defaultMessageTimestamp, "index");
        internalCluster().startClusterManagerOnlyNode();
    public void testExternalVersioningWithDisabledGCDeletes() throws Exception {
                .cluster()
        });  
        produceData("{\"_op_type\":\"invalid\",\"_source\":{\"name\":\"name4\", \"age\": 25}}");
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
    private Path absolutePath;
        produceData("4", "name4", "31");
        });
            indexName,
        produceData("1", "name1", "25");  
        assertEquals("POLLING", ingestionState.getShardStates()[0].getPollerState());  
        createIndexWithDefaultSettings(1, 1);
        }
        });
        final String nodeA = internalCluster().startDataOnlyNode();
            .getPollingIngestStats();
        // Step 10: Wait for 11 messages to be visible on nodeB
        // validate page 1
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        produceDataWithExternalVersion("2", 1, "name2", "25", defaultMessageTimestamp, "index");  
        assertThat(stats.getMessageProcessorStats().totalVersionConflictsCount(), is(3L));
        assertEquals(3, responsePage2.getSuccessfulShards());  
        resumeIngestion(indexName);  
        // Step 5: Wait for relocation to complete
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        refresh(indexName);
        waitForSearchableDocs(4, Arrays.asList(nodeA, nodeB));
        GetIngestionStateResponse ingestionState = getIngestionState(new String[] { indexName }, new int[] { 0 });  
        // Step 5: Restore Index from Snapshot
import org.opensearch.action.pagination.PageParams;
            boolean shardsMatch = Set.of(0, 1, 2).contains(shardIngestionState.getShardId());
                .put("ingestion_source.type", "kafka")
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", 3));
        // test deletes with correct version
 */
        assertThat(primaryResponse.getHits().getTotalHits().value(), is(1L));
        waitForState(() -> getPeriodicFlushCount(nodeA, indexName) >= 1);
        final String nodeA = internalCluster().startDataOnlyNode();  
        SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
        );  
            SearchResponse rangeQueryResponse = client().prepareSearch(indexName).setQuery(rangeQuery).get();  
            RangeQueryBuilder rangeQuery = new RangeQueryBuilder("age").gte(34);  
        // create a write block
        refresh(indexName);  
        );  
        verifyRemoteStoreEnabled(nodeA);
        verifyRemoteStoreEnabled(nodeB);  
        SearchResponse primaryResponse = client(nodeA).prepareSearch(indexName).setQuery(query).setPreference("_only_local").get();  
        produceDataWithExternalVersion("3", 1, "name3", "25", defaultMessageTimestamp, "index");
        createIndexWithDefaultSettings(1, 1);
    public void testSegmentReplicationWithRemoteStore() throws Exception {
        produceData("3", "name3", "30");  
        produceDataWithExternalVersion("1", 1, "name1", "25", defaultMessageTimestamp, "index");
        if (absolutePath == null) {
                .put("ingestion_source.param.topic", topicName)  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        internalCluster().startClusterManagerOnlyNode();  
        assertEquals(2, getSearchableDocCount(nodeB));  
            .get();  
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;  
    }  
        internalCluster().startClusterManagerOnlyNode();
        ensureGreen("index1");  
        waitForSearchableDocs(4, Arrays.asList(nodeB));
                .put("ingestion_source.type", "kafka")
        internalCluster().startClusterManagerOnlyNode();
        waitForState(() -> {
                .prepareUpdateSettings(indexName)  
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
        waitForSearchableDocs(2, Arrays.asList(nodeA, nodeB));  
            return true;
        );
        resumeIngestionWithResetAndWait(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "2", 1);
        produceData("4", "name4", "24", 120, "index");
        createIndexWithDefaultSettings(1, 1);
        produceData("2", "name2", "20");  
        createIndexWithDefaultSettings(1, 1);
        produceData("1", "name1", "21", 100, "index");
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        // Step 1: Publish 10 messages
        refresh(indexName);
            .setIndices(indexName)
        waitForState(() -> "block".equalsIgnoreCase(getSettings(indexName, "index.ingestion_source.error_strategy")));  
                .build(),  
    @Override  
        final String nodeB = internalCluster().startDataOnlyNode();
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
            Settings.builder()
        assertEquals(3, stats2.getConsumerStats().totalPolledCount());
        assertTrue(nodeC.equals(replicaNodeName(indexName)));  
        produceData("1", "name1", "24");
        ensureGreen(indexName);
        });  
        );  
        produceData("1", "name1", "24");  
        internalCluster().startClusterManagerOnlyNode();
                .put("ingestion_source.error_strategy", "drop")  
        assertAcked(
            return indexMatch && shardsMatch;  
                .put("ingestion_source.pointer.init.reset", "earliest")
        assertEquals(1, ingestionState.getTotalShards());  
        client().admin()  
        // for page size of 3, we expect 4 pages in total
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        ensureGreen(indexName);
        final String nodeB = internalCluster().startDataOnlyNode();
                .put("index.periodic_flush_interval", "5s")
    public void testPeriodicFlush() throws Exception {
        BoolQueryBuilder query2 = new BoolQueryBuilder().must(new TermQueryBuilder("_id", 2));  
    }  
    public void testBatchStartPointerOnReplicaPromotion() throws Exception {
        final String nodeB = internalCluster().startDataOnlyNode();
        createIndexWithDefaultSettings("index2", 5, 0, 1);
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
            .setSettings(Settings.builder().put("ingestion_source.error_strategy", "drop"))  
        SearchResponse response1 = client().prepareSearch(indexName).setQuery(query1).get();
                .build(),  
        ensureGreen(indexName);  
        final String nodeA = internalCluster().startDataOnlyNode();
        );
        // delete documents 1 and 2
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        );  
        // pause ingestion  
            .cluster()
        flush(indexName);  
import java.nio.file.Path;
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(23);  
            SearchResponse rangeQueryResponse = client().prepareSearch(indexName).setQuery(rangeQuery).get();
        // Step 2: Register snapshot repository
        kafka.stop();  
        final String nodeA = internalCluster().startDataOnlyNode();  
                .put("ingestion_source.error_strategy", "block")
 *
        assertTrue(nodeB.equals(primaryNodeName(indexName)));
        // Step 1: Create 2 nodes  
    public void testPauseAndResumeIngestion() throws Exception {  
        produceData("3", "name3", "30");  
        verifyRemoteStoreEnabled(nodeA);
        GetIngestionStateResponse responsePage4 = ingestionStateResponseList.get(3);  
        // resume ingestion  
            .get();
            boolean indexMatch = "index2".equalsIgnoreCase(shardIngestionState.getIndex());  
                .put("ingestion_source.type", "kafka")
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
public class RemoteStoreKafkaIT extends KafkaIngestionBaseIT {
        assertEquals(3, responsePage3.getTotalShards());
        // Start nodes
        // validate page 2  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;  
        // setup nodes and index  
        waitForSearchableDocs(4, List.of(nodeB));
        client().admin().cluster().prepareReroute().add(new AllocateReplicaAllocationCommand(indexName, 0, nodeC)).get();
        waitForState(() -> {  
        produceData("3", "name3", "25");  
        ensureGreen(indexName);
        });
import org.opensearch.transport.client.Requests;
        produceDataWithExternalVersion("1", 2, "name1", "30", defaultMessageTimestamp, "index");  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        assertThat(stats.getConsumerStats().totalConsumerErrorCount(), is(0L));
        assertEquals(4, ingestionStateResponseList.size());
        // verify ingestion state is persisted
                .put("ingestion_source.param.topic", topicName)
        final String nodeC = internalCluster().startDataOnlyNode();
        verifyRemoteStoreEnabled(nodeA);
                .put("ingestion_source.type", "kafka")
            boolean matchIndex1 = Set.of(3, 4).contains(shardIngestionState.getShardId())  
            return Arrays.stream(ingestionState.getShardStates())  
        assertAcked(client().admin().indices().prepareDelete(indexName));  
        }));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));  
        waitForSearchableDocs(3, Arrays.asList(node));
        // Step 6: Verify index is restored and resumes ingestion from the 3rd message
        assertEquals(3, responsePage1.getShardStates().length);
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        assertEquals(2, stats1.getConsumerStats().totalPolledCount());  
        produceData("2", "name2", "20");  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        // insert documents
                .build(),
            return stats.getConsumerStats().totalPolledCount() == 3;
            boolean shardsMatch = Set.of(1, 2, 3).contains(shardIngestionState.getShardId());  
import java.util.List;
        assertEquals(2L, finalStats.getMessageProcessorStats().totalProcessedCount());
    public void testConsumerResetByTimestamp() throws Exception {  
                .put("ingestion_source.pointer.init.reset", "earliest")  
        waitForSearchableDocs(11, Arrays.asList(nodeB));
        // update offset to skip past the invalid message
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            String nextToken = ingestionStatePage == null ? null : ingestionStatePage.getNextPageToken();  
}  
        ensureGreen(indexName);
        // Step 3: Take snapshot
        waitForSearchableDocs(2, Arrays.asList(nodeA));  
        assertTrue(nodeA.equals(primaryNodeName(indexName)));  
        internalCluster().startDataOnlyNode();
        createIndex(  
        produceData("2", "name2", "20");
            Settings.builder()  
    }  
        waitForState(() -> {  
import org.opensearch.test.InternalTestCluster;  
        // Step 6: Wait for 10 messages to be searchable on both nodes
                .put("ingestion_source.pointer.init.reset", "earliest")
        produceDataWithExternalVersion("3", 1, "name3", "25", defaultMessageTimestamp, "index");
    protected Settings nodeSettings(int nodeOrdinal) {
        CreateSnapshotResponse snapshotResponse = client().admin()
        waitForState(() -> {
            indexName,
            ResumeIngestionRequest.ResetSettings.ResetMode.TIMESTAMP,
        produceData("1", "name1", "24");
        // verify write block state in poller is persisted
        produceDataWithExternalVersion("2", 1, "name2", "25", defaultMessageTimestamp, "index");
            produceDataWithExternalVersion(String.valueOf(i), 1, "name" + i, "25", defaultMessageTimestamp, "index");
        waitForSearchableDocs(2, Arrays.asList(nodeA, nodeB));
        final String nodeB = internalCluster().startDataOnlyNode();
            BoolQueryBuilder query1 = new BoolQueryBuilder().must(new TermQueryBuilder("_id", 1));  
            Settings.builder()
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        refresh(indexName);
        assertTrue(Arrays.stream(responsePage2.getShardStates()).allMatch(shardIngestionState -> {
                .put("ingestion_source.internal_queue_size", "1000")
    }
        assertFalse(resumeResponse.isShardsAcknowledged());  
            boolean indexMatch = "index1".equalsIgnoreCase(shardIngestionState.getIndex());
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        // validate next version docs get indexed
        // pause ingestion
                && Arrays.stream(ingestionState.getShardStates())
        client().admin().indices().close(Requests.closeIndexRequest(indexName)).get();
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
        produceData("6", "name6", "41");
            boolean shardsMatch = shardIngestionState.getShardId() == 4;
        waitForSearchableDocs(2, Arrays.asList(nodeA, nodeB));  
        ensureGreen(indexName);  
                .build(),
        final String nodeB = internalCluster().startDataOnlyNode();
        assertAcked(  
        produceData("2", "name2", "20");  
        refresh(indexName);
            assertThat(rangeQueryResponse.getHits().getTotalHits().value(), is(2L));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        ensureGreen(indexName);
        assertTrue(nodeA.equals(primaryNodeName(indexName)));  
        assertTrue(nodeC.equals(replicaNodeName(indexName)));  
        assertTrue(nodeB.equals(primaryNodeName(indexName)));
        // Step 1: Create 2 nodes  
            ingestionStatePage = getIngestionState(new String[] { "index1", "index2" }, new int[] { 0, 1, 2, 3, 4 }, pageParams);
import org.opensearch.cluster.ClusterState;
        waitForSearchableDocs(6, Arrays.asList(nodeB, nodeC));
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        }
        assertTrue(nodeB.equals(primaryNodeName(indexName)));  
        // Step 6: Ensure index is searchable on nodeB and can resume ingestion
                .setSettings(Settings.builder().put("index.routing.allocation.require._name", nodeB))
            .getPollingIngestStats();  
        produceDataWithExternalVersion("1", 1, "name1", "35", defaultMessageTimestamp, "index");  
        assertNotNull(finalStats);
        refresh(indexName);  
        waitForSearchableDocs(1, Arrays.asList(nodeA, nodeB));  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        String snapshotName = "snapshot-1";
                .build(),
            SearchResponse rangeQueryResponse = client().prepareSearch(indexName).setQuery(rangeQuery).get();  
        waitForSearchableDocs(4, Arrays.asList(nodeC));
        }));  
            .prepareUpdateSettings(indexName)
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
import org.opensearch.index.query.BoolQueryBuilder;
        // Step 9: Publish 1 new message
        final String nodeB = internalCluster().startDataOnlyNode();
        assertEquals(0, ingestionState.getFailedShards());
                .getPollingIngestStats();  
        }
        internalCluster().startClusterManagerOnlyNode();  
                .put("index.routing.allocation.require._name", nodeA)  
    }
        produceDataWithExternalVersion("1", 2, "name1", "25", defaultMessageTimestamp, "delete");  
            RangeQueryBuilder rangeQuery = new RangeQueryBuilder("age").gte(23);
        // Step 4: Delete Index
        GetSettingsResponse settingsResponse = client(node).admin().indices().prepareGetSettings(indexName).get();
            client().admin()
        assertEquals(1, resumeResponse.getShardFailures().length);
        internalCluster().startClusterManagerOnlyNode();
                .getPollingIngestStats();
        // Step 6: Produce new updates and verify segment replication works when primary and replica index are not empty.  
        ensureYellowAndNoInitializingShards(indexName);
        createIndex(  
        ensureGreen(indexName);
        produceDataWithExternalVersion("2", 2, "name2", "25", defaultMessageTimestamp, "delete");
        internalCluster().startClusterManagerOnlyNode();  
        produceDataWithExternalVersion("4", 1, "name4", "35", defaultMessageTimestamp, "index");
        final String nodeB = internalCluster().startDataOnlyNode();  
        List<GetIngestionStateResponse> ingestionStateResponseList = new ArrayList<>();  
        assertEquals(3, responsePage3.getSuccessfulShards());  
        );
                .indices()
                .setSettings(Settings.builder().put("location", randomRepoPath()).put("compress", false))
        pauseIngestionAndWait(indexName, 1);  
            assertThat(rangeQueryResponse.getHits().getTotalHits().value(), is(2L));
        });
        // validate processor stats
    public void testDefaultGetIngestionState() throws ExecutionException, InterruptedException {
        GetIngestionStateResponse responsePage2 = ingestionStateResponseList.get(1);
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
        // malformed message
                .put("ingestion_source.param.topic", topicName)  
        produceData("1", "name1", "24");  
        // setup nodes and index  
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        assertThat(replicaResponse.getHits().getTotalHits().value(), is(1L));  
        assertEquals(1, responsePage4.getShardStates().length);  
        // setup nodes and index
import org.opensearch.action.search.SearchResponse;  
import org.opensearch.index.query.RangeQueryBuilder;  
        client().admin().cluster().prepareReroute().add(new AllocateReplicaAllocationCommand(indexName, 0, nodeC)).get();  
        // Step 2: Start nodes
            return stats.getConsumerStats().totalConsumerErrorCount() > 0;  
        produceData("2", "", "");
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
        ensureYellowAndNoInitializingShards(indexName);
        produceDataWithExternalVersion("4", 1, "name4", "25", defaultMessageTimestamp, "index");
        produceDataWithExternalVersion("2", 3, "name2", "30", defaultMessageTimestamp, "delete");  
                .put("ingestion_source.type", "kafka")  
/**  
import org.opensearch.cluster.metadata.IndexMetadata;
        produceData("2", "name2", "22");
        assertThat(newPrimaryResponse.getHits().getTotalHits().value(), is(3L));
        assertTrue(snapshotResponse.getSnapshotInfo().successfulShards() > 0);
            return ingestionState.getFailedShards() == 0  
        internalCluster().startClusterManagerOnlyNode();
        assertTrue(nodeB.equals(replicaNodeName(indexName)));  
            .prepareRestoreSnapshot(snapshotRepositoryName, snapshotName)
            return true;  
        assertNotNull(stats);
        // validate page 3  
        ensureGreen(indexName);
        // Step 6: Ensure index is searchable on nodeB even though kafka is down  
        produceData("2", "name2", "20");
    }
        produceData("1", "name1", "24");
        // Step 1: Setup index and data  
                .put("ingestion_source.pointer.init.reset", "earliest")  
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"  
        // Step 3: Write documents and verify
        waitForSearchableDocs(2, List.of(nodeA));
            SearchResponse response2 = client().prepareSearch(indexName).setQuery(query2).get();
        // Step 4: Verify new primary node is able to index documents
        waitForState(() -> "drop".equalsIgnoreCase(getSettings(indexName, "index.ingestion_source.error_strategy")));
        assertTrue(resumeResponse.isAcknowledged());
        produceDataWithExternalVersion("1", 1, "name1", "25", defaultMessageTimestamp, "index");
    }  
 * The OpenSearch Contributors require contributions made to  
            .getPollingIngestStats();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        produceDataWithExternalVersion("2", 1, "name2", "25", defaultMessageTimestamp, "index");  
        flush(indexName);  
        GetIngestionStateResponse ingestionStatePage = null;
            RangeQueryBuilder rangeQuery = new RangeQueryBuilder("age").gte(23);
        // test deletes with smaller version
        flush(indexName);  
            .getPollingIngestStats();
        resumeIngestionWithResetAndWait(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.TIMESTAMP, "102", 1);
        // test out-of-order updates
        waitForState(() -> {
        final String nodeA = internalCluster().startDataOnlyNode();
    }  
        waitForState(() -> {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
            .build();
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                .put("ingestion_source.param.auto.offset.reset", "earliest")
        produceDataWithExternalVersion("1", 1, "name1", "25", defaultMessageTimestamp, "delete");  
            return indexMatch && shardsMatch;
            assertThat(response2.getHits().getTotalHits().value(), is(1L));
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        // Step 3: Stop current primary node and validate replica promotion.
        // after index is restored, it should resume ingestion from batchStartPointer available in the latest commit
            Settings.builder()
            return true;
        BoolQueryBuilder query1 = new BoolQueryBuilder().must(new TermQueryBuilder("_id", 1));
        assertEquals("DROP", ingestionState.getShardStates()[0].getErrorPolicy());
            return state.getRoutingTable().hasIndex(indexName) == false && state.getMetadata().hasIndex(indexName) == false;  
        ensureGreen(indexName);
@ThreadLeakFilters(filters = TestContainerThreadLeakFilter.class)
        // Step 11: Validate version conflict count is exactly 1
        return Settings.builder()
        );
                .put("ingestion_source.param.topic", topicName)
        }
        ensureGreen(indexName);
import java.util.concurrent.ExecutionException;  
        assertEquals("Remote store should be enabled", "true", remoteStoreEnabled);
        // revalidate that only 1 document is visible
        assertTrue(nodeB.equals(replicaNodeName(indexName)));
        recreateKafkaTopics(5);  
        produceData("2", "name2", "20");
        createIndexWithDefaultSettings(1, 1);
            SearchResponse response1 = client().prepareSearch(indexName).setQuery(query1).get();
                .get()
        assertEquals(30, response2.getHits().getHits()[0].getSourceAsMap().get("age"));  
                && Arrays.stream(ingestionState.getShardStates()).allMatch(state -> state.isWriteBlockEnabled() == false);
        internalCluster().startDataOnlyNode();
        waitForState(() -> {
            assertThat(response.getHits().getTotalHits().value(), is(1L));  
        assertEquals(0, ingestionStateForInvalidShard.getTotalShards());
        refresh(indexName);  
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;  
        );
        assertTrue(Arrays.stream(responsePage1.getShardStates()).allMatch(shardIngestionState -> {  
        // Step 5: Wait for relocation to complete  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // setup nodes and index using block strategy
        GetIngestionStateResponse responsePage1 = ingestionStateResponseList.get(0);
        createIndex(
    }
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
        ensureYellowAndNoInitializingShards(indexName);
        assertThat(stats.getMessageProcessorStats().totalProcessedCount(), is(11L));  
    }
        final String nodeA = internalCluster().startDataOnlyNode();
        // Publish 10 messages
        createIndexWithDefaultSettings("index1", 5, 0, 1);
        );  
        waitForState(() -> nodeB.equals(primaryNodeName(indexName)));
        produceData("1", "name1", "21");  
            indexName,
        String snapshotRepositoryName = "test-snapshot-repo";  
            client().admin()
                .put("ingestion_source.type", "kafka")
        waitForSearchableDocs(3, Arrays.asList(nodeA, nodeB));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put("ingestion_source.param.topic", topicName)
        ensureGreen(indexName);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testIndexRelocation() throws Exception {
        produceData("5", "name5", "40");
            indexName,
            Settings.builder()
        waitForSearchableDocs(2, Arrays.asList(nodeA, nodeB));  
                .put("ingestion_source.param.topic", topicName)  
        // Step 5: Verify nodeA has the primary shard
        assertFalse(ingestionState.getShardStates()[0].isPollerPaused());
        // produce one invalid message to block the processor
        produceData("1", "name1", "24");
            return ingestionState.getFailedShards() == 0  
        final String nodeB = internalCluster().startDataOnlyNode();
        });
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        }));
            return matchIndex1 || matchIndex2;  
        assertEquals(3, responsePage2.getShardStates().length);
        internalCluster().startDataOnlyNode();
        GetIngestionStateResponse ingestionStateForInvalidShard = getIngestionState(new String[] { indexName }, new int[] { 1 });
import org.opensearch.common.settings.Settings;
    private static final String REPOSITORY_NAME = "test-remote-store-repo";  
import org.opensearch.indices.pollingingest.PollingIngestStats;
        produceData("4", "name4", "20");
    public void testClusterWriteBlock() throws Exception {
            .cluster()
                .get()  
        assertTrue(nodeC.equals(replicaNodeName(indexName)));
                .put("index.routing.allocation.require._name", nodeA)  
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 1; i <= 10; i++) {  
        // Step 1: Create primary and replica nodes. Create index with 1 replica and kafka as ingestion source.  
        });
            ClusterState state = client().admin().cluster().prepareState().setIndices(indexName).get().getState();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
        // Step 4: Add second node and verify green status
                .build(),  
        assertThat(stats.getConsumerStats().totalPollerMessageDroppedCount(), is(1L));  
        });  
        final String nodeA = internalCluster().startDataOnlyNode();  
        // we have 2 index, each with 5 shards, total of 10 shards  
        SearchResponse newPrimaryResponse = client(nodeB).prepareSearch(indexName).setQuery(query).setPreference("_only_local").get();  
            Settings.builder()
        assertThat(stats.getMessageProcessorStats().totalFailuresDroppedCount(), is(1L));
        waitForSearchableDocs(2, List.of(nodeB));
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        ensureGreen(indexName);
            return indexMatch && shardsMatch;
                .put("ingestion_source.type", "kafka")
                && "index1".equalsIgnoreCase(shardIngestionState.getIndex());
import org.opensearch.test.OpenSearchIntegTestCase;
                .setType("fs")
        client().admin().cluster().prepareReroute().add(new AllocateReplicaAllocationCommand(indexName, 0, nodeC)).get();
        waitForState(() -> {
        PollingIngestStats stats2 = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        produceData("4", "name4", "31");
                .prepareUpdateSettings(indexName)
        // expect error response since ingestion not yet paused
            return ingestionState.getFailedShards() == 0  
    private void verifyRemoteStoreEnabled(String node) {
        createIndex(  
