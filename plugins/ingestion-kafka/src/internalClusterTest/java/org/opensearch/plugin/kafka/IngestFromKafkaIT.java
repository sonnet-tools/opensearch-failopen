    public void testKafkaIngestionWithFieldMappingMapper_VariousConfigurations() throws Exception {
        client().admin()
            .indices()
        produceData(payload);
            .get();
        // Step 6: Wait for documents to be searchable (handles async refresh)
                && stats.getConsumerStats().totalPolledCount() == 4L
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
                .put("ingestion_source.all_active", true)
    }
        waitForState(() -> validateOffsetBasedLagForPrimaryAndReplica(0));
    public void testKafkaIngestionWithFieldMappingMapper() throws Exception {
                .build(),
        final String nodeA = internalCluster().startDataOnlyNode();
        // Step 6: Update auto.offset.reset to earliest again. Consumer must not be reinitialized again as no config change.
        produceData(invalidJsonMessage);
                .getPollingIngestStats();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            indexName,
     */
    }
            assertThat(response.getHits().getTotalHits().value(), is(1L));
        pauseIngestionAndWait(indexName, 2);
        assertEquals(9L, shardTypeToStats.get("replica").getMessageProcessorStats().totalVersionConflictsCount());
        final String nodeB = internalCluster().startDataOnlyNode();
                shardTypeToStats.put("primary", shardStats.getPollingIngestStats());
            mapping
        // move replica from nodeB to nodeC
            assertThat(response.getHits().getTotalHits().value(), is(1L));
            return "alice".equals(aliceDoc.get("name"))
            indexName,
                .build(),
        assertAcked(
            .getPollingIngestStats();
                .put("ingestion_source.all_active", true)
            "message2 should fail due to strict mapping",
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            SearchResponse response = client().prepareSearch(indexName).get();
                .put("ingestion_source.mapper_settings.op_type_field.delete_value", "true")
        // Step 11: Publish 10 more messages
            "{\"dynamic\":\"strict\",\"properties\":{\"product\":{\"type\": \"text\"},"
        Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);
    /**
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", "1"));
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
                .build(),
     */
}
        createIndex(
        assertNotNull(shardTypeToStats.get("primary"));
                .put("index.replication.type", "SEGMENT")
            return ingestionState.getShardStates().length == 1
            indexName,
            @SuppressWarnings("unchecked")
        for (int i = 0; i < 10; i++) {
            .indices()
    }
        String id = searchableDocsResponse.getHits().getHits()[0].getId();
        @Override
            .indices()
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                .getPollingIngestStats();
    private Map<String, PollingIngestStats> getPollingIngestStatsForPrimaryAndReplica(String indexName) {
        internalCluster().restartNode(nodeC);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .put("ingestion_source.all_active", true)
            Settings.builder()
        waitForSearchableDocs(11, Arrays.asList(nodeC));
        for (int i = 0; i < 10; i++) {
     * Test plugin that registers a custom ingestion payload decoder ({@code test_uppercase}) which
            refresh(createIndex);
        produceData("{\"user_id\": \"abc\", \"name\": \"alice_v2\", \"age\": 31, \"timestamp\": 200, \"is_deleted\": \"false\"}");
        assertBusy(() -> { assertEquals(3, internalCluster().clusterService().state().nodes().getSize()); }, 30, TimeUnit.SECONDS);
        IndexStats indexStats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName);
            .getPollingIngestStats();
        });
        }
        // Step 1: Create index with pointer.init.reset to offset 100 and auto.offset.reset to earliest
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
                        + "{\"is_promotional\":{\"type\":\"boolean\",\"doc_values\":false}}}}}",
        ensureGreen(indexName);
import org.opensearch.index.query.TermQueryBuilder;
        ensureGreen(indexName);
        waitForState(() -> {
            .prepareUpdateSettings(indexName)
            produceData(Integer.toString(i), "name" + i, "30");
        final String nodeA = internalCluster().startDataOnlyNode();
            Map<String, Map<String, Object>> docs = new HashMap<>();
            return 30 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");
        });
        waitForSearchableDocs(30, List.of(nodeA, nodeC));
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        // resume ingestion
                && stats.getMessageProcessorStats().totalProcessedCount() == 2L;
                .put("ingestion_source.type", "kafka")
     * end-to-end when selected via {@code ingestion_source.decoder_type}.
                    Object name = sourceMap.get("name");
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        }
            indexName,
                .build(),
import java.util.List;
        // --- Scenario 3: custom delete_value (Y/N convention) ---
                && docs.containsKey("def")
        waitForSearchableDocs(10, List.of(nodeA));
        produceData("{\"user_id\": \"ghi\", \"name\": \"charlie\", \"age\": 35, \"timestamp\": 400, \"expired\": \"N\"}");
        waitForSearchableDocs(5, List.of(nodeA));
                .build(),
        waitForState(() -> {
            )
                .put("ingestion_source.pointer.init.reset", "earliest")
            .setSettings(
        }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put("ingestion_source.mapper_settings.id_field", "user_id")
            // IDs extracted from user_id, user_id removed from source, content preserved
            if (shardStats.getShardRouting().primary()) {
        for (int i = 0; i < 10; i++) {
            SearchResponse response = client().prepareSearch(idOnlyIndex).get();
                // 1739459500000 is the timestamp of the first message
        produceData("1", "name1", "25");
    }
        produceData("2", "name2", "20");
                .setQuery(new TermQueryBuilder("attributes.is_promotional", false))
        String createIndex = "test_create_op";
        waitForState(() -> getPeriodicFlushCount(nodeA, indexName) >= 1);
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
                .put("ingestion_source.mapper_settings.op_type_field.delete_value", "true")
import java.util.Arrays;
        final String nodeB = internalCluster().startDataOnlyNode();
 * compatible open source license.
                .build(),
        // Step 14: Add a replica (will be allocated to nodeC since only nodeB and nodeC are available)
                    if (name instanceof String) {
                .put("ingestion_source.pointer.init.reset", "earliest")
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            refresh("test_rewind_by_offset");
                && ingestionState.getShardStates()[0].getPollerState().equalsIgnoreCase("polling");
        // Step 4: Wait for poller to enter POLLING state (warmup complete)
        resumeIngestionAndWait(indexName, 2);
        );
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
        createIndex(
        waitForSearchableDocs(10, Arrays.asList(nodeA));
                public IngestionPayloadDecoder create(IndexMetadata indexMetadata, int shardId, Map<String, Object> settings) {
        flush(indexName);
        // Step 5: Pause and resume ingestion, setting offset to 100 (out-of-range, hence expect auto.offset.reset to be used)
        waitForSearchableDocs(20, List.of(nodeC));
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .get();
            .get();
            indexName,
                && stats.getMessageProcessorStats().totalVersionConflictsCount() == 1L;
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(indexName, 0, nodeA, nodeB)).get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // Add new node and wait for new node to join cluster
        waitForState(() -> {
        await().atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
        NodesInfoResponse nodesInfoResponse = OpenSearchIntegTestCase.client().admin().cluster().nodesInfo(nodesInfoRequest).actionGet();
        createIndex(
            mapping
            Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);
                .put("ingestion_source.type", "kafka")
                .put("ingestion_source.decoder_type", TestCustomDecoderPlugin.CUSTOM_DECODER_TYPE)
            mapping
        waitForState(() -> {
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(shardTypeToStats.get("replica").getConsumerStats().totalPollerMessageDroppedCount(), is(0L));
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        }
                .put("ingestion_source.param.topic", topicName)
    }
        waitForSearchableDocs(2, List.of(nodeA));
                .put("index.replication.type", "SEGMENT")
                .put("ingestion_source.param.max.poll.records", "100")
                .put("ingestion_source.mapper_settings.version_field", "timestamp")
            .indices()
        // produce 10 more messages
            assertThat(stats.getConsumerStats().totalPolledCount(), is(2L));
                && ingestionState.getShardStates()[0].isPollerPaused()
                .put("ingestion_source.warmup.lag_threshold", 0)
                .put("ingestion_source.param.topic", topicName)
        waitForSearchableDocs(10, Arrays.asList(nodeA));
        assertTrue(nodeB.equals(primaryNodeName(indexName)));
        ensureGreen(indexName);
        await().atMost(1, TimeUnit.MINUTES).untilAsserted(() -> {
        await().atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
                .put("ingestion_source.pointer.init.reset.value", "1")
            .prepareUpdateSettings(indexName)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            Settings.builder()
                .put("ingestion_source.all_active", true)
import org.opensearch.plugins.IngestionConsumerPlugin;
        public Map<String, IngestionConsumerFactory> getIngestionConsumerFactories() {
        createIndex(
        // Step 7: Publish 1 more message
                }
        refresh(indexName);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                && ingestionState.getFailedShards() == 0
    public void testPluginsAreInstalled() {
        // Step 11: Validate processed messages and version conflict count on nodeB
        final String nodeA = internalCluster().startDataOnlyNode();
        // This should cause consumer initialization to fail
        assertEquals(25, searchableDocsResponse.getHits().getHits()[0].getSourceAsMap().get("age"));
        );
        waitForSearchableDocs(10, Arrays.asList(nodeA, nodeB));
            return stats != null && stats.getMessageProcessorStats().totalFailuresDroppedCount() >= 1L;
            return stats != null
            Settings.builder()
            .indices()
            .setSettings(Settings.builder().put("ingestion_source.param.auto.offset.reset", "earliest"))
        ensureGreen(indexName);
        // Verify both primary and replica do not have failed messages
        GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        // Validate document content
        // create an index with ingestion source from kafka
        client().admin()
        pauseIngestionAndWait(indexName, 2);
            Settings.builder()
        createIndexWithDefaultSettings(1, 0);
import java.util.stream.Collectors;
    }
        ensureGreen(indexName);
                .put("ingestion_source.all_active", true)
        final String nodeB = internalCluster().startDataOnlyNode();
        final String nodeB = internalCluster().startDataOnlyNode();
            pluginInfos.stream().anyMatch(pluginInfo -> pluginInfo.getName().equals("org.opensearch.plugin.kafka.KafkaPlugin"))
        // Step 4: Update auto.offset.reset to earliest
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        assertThat(
        ensureGreen(indexName);
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
            .prepareUpdateSettings(indexName)
                .getPollingIngestStats();
        waitForState(() -> {
        waitForState(() -> {
                .getPollingIngestStats();
                .put("ingestion_source.error_strategy", "drop")
        waitForState(() -> {
        waitForState(() -> {
                .put("ingestion_source.mapper_settings.op_type_field", "is_deleted")
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));
                .getPollingIngestStats();
        waitForState(() -> {
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        final String nodeA = internalCluster().startDataOnlyNode();
        createIndex(
            .setSettings(Settings.builder().put("ingestion_source.warmup.lag_threshold", 50).put("ingestion_source.warmup.timeout", "5m"))
                .put("ingestion_source.error_strategy", "drop")
        // pause ingestion
                .put("ingestion_source.all_active", true)
            produceData(String.valueOf(i), "name" + i, "25");
                && ingestionState.getShardStates()[0].isPollerPaused() == false
        createIndex(
        final String nodeA = internalCluster().startDataOnlyNode();
                .cluster()
        assertEquals(10L, stats.getMessageProcessorStats().totalProcessedCount());
            mapping
        );
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));
            deleteValueIndex,
            Map<String, Object> source = response.getHits().getAt(0).getSourceAsMap();
        );
        // verify replica ingests data after resuming ingestion
        waitForSearchableDocs(10, Arrays.asList(nodeA));
        ensureGreen(indexName);
        final String nodeA = internalCluster().startDataOnlyNode();
                .put("index.replication.type", "SEGMENT")
                .preparePutMapping(indexName)
        @Override
import static org.awaitility.Awaitility.await;
        flush(indexName);
                .put("ingestion_source.param.topic", topicName)
        createIndex(
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", "2"));
        waitForState(() -> {
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        waitForState(() -> {
                .put("ingestion_source.pointer.init.reset", "earliest")
        // Step 10: Flush to persist data
            return stats != null && stats.getMessageProcessorStats().totalProcessedCount() == 3L;
import org.opensearch.indices.pollingingest.IngestionUtils;
            if (response.getHits().getTotalHits().value() != 1L) return false;
            .setSettings(Settings.builder().put("ingestion_source.param.auto.offset.reset", "latest"))
        // Step 8: Update auto.offset.reset back to "latest". This is surrounded by pause/resume to indirectly infer
        // Step 5: Dynamically update warmup settings (lag_threshold and timeout)
    public void testKafkaIngestionWithFieldMappingMapper_VersionConflict() throws Exception {
            indexName,
import org.opensearch.action.search.SearchResponse;
            // Both documents indexed — INSERT as create, UPDATE as index (default)
        ensureYellowAndNoInitializingShards(indexName);
        internalCluster().startClusterManagerOnlyNode();
        });
import org.opensearch.plugins.PluginInfo;
        }
            return attrProps.containsKey("is_promotional");
                .put("ingestion_source.warmup.timeout", "10m")
    }
        waitForState(() -> {
        assertEquals(10L, stats.getConsumerStats().totalPolledCount());
                    org.opensearch.common.xcontent.XContentType.JSON
        PollingIngestStats statsBeforePutMapping = client().admin()
            Settings.builder()
        for (int i = 0; i < 10; i++) {
    public void testDynamicConfigUpdateOnNoMessages() throws Exception {
                .put("ingestion_source.type", "kafka")
        ensureYellowAndNoInitializingShards(indexName);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                .put("ingestion_source.pointer.init.reset.value", "100")
            @Override
            produceData(Integer.toString(i), "name" + i, "30");
        Thread.sleep(1000);
                .put("ingestion_source.mapper_settings.id_field", "user_id")
        for (int i = 0; i < 10; i++) {
                .put("ingestion_source.mapper_type", "field_mapping")
        // Take snapshot
            Settings.builder()
        });
        }
                && stats.getMessageProcessorStats().totalFailedCount() == 1L
            && shardTypeToStats.get("replica").getConsumerStats().pointerBasedLag() == expectedLag;
        // confirm replica ingests messages after moving to new node
            .get();
        assertTrue(nodeB.equals(primaryNodeName(indexName)));
            return ingestionState.getShardStates().length == 1
            produceData(Integer.toString(i), "name" + i, "30");
        waitForSearchableDocs(11, Arrays.asList(nodeA));
                .put("ingestion_source.mapper_settings.op_type_field.create_value", "INSERT")
    }
        assertNotNull(nodeCStats);
        });
        internalCluster().startClusterManagerOnlyNode();
            Settings.builder()
public class IngestFromKafkaIT extends KafkaIngestionBaseIT {
        ensureGreen(indexName);
                && replicaStats.getMessageProcessorStats().totalVersionConflictsCount() == 10L;
                + "{\"product\":\"product1\", \"attributes\":{\"title\":\"Screenshot 2026\"}}}"
        // verify pause and resume functionality on replica
            if (response.getHits().getTotalHits().value() != 2L) return false;
            produceData(Integer.toString(i), "name" + i, "30");
        assertEquals(1L, stats.getMessageProcessorStats().totalProcessedCount());
        waitForState(() -> validateOffsetBasedLagForPrimaryAndReplica(0));
            assertThat(response.getHits().getTotalHits().value(), is(1L));
    public void testAllActiveIngestionBatchStartPointerOnReplicaPromotion() throws Exception {
            assertThat(response.getHits().getTotalHits().value(), is(1L));
                .put("ingestion_source.type", "kafka")
        produceDataWithExternalVersion("11", 1, "name11", "25", defaultMessageTimestamp, "index");
                .build(),
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        }
            produceData(Integer.toString(i), "name" + i, "30");
        resumeIngestionAndWait(indexName, 1);
/*
import org.opensearch.index.IngestionPayloadDecoderFactory;
                .put("ingestion_source.param.topic", topicName)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .getPollingIngestStats();
            // ghi should be deleted, jkl should remain
            return docs.containsKey("abc")
        ensureGreen(indexName);
        PollingIngestStats finalStats = client(nodeA).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
                .put("ingestion_source.all_active", true)
                .build(),
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        }
        assertTrue(nodeB.equals(replicaNodeName(indexName)));
        client().admin().indices().close(Requests.closeIndexRequest(indexName)).get();
        waitForState(() -> {
        // Step 8: Wait for 11 searchable docs
        waitForState(() -> {
        produceData("1", "name", "30", defaultMessageTimestamp, "delete");
import java.util.Collection;
        resumeIngestionAndWait(indexName, 2);
                .indices()
            Map<String, Object> mappings = client().admin()
            .get();
            return stats != null && stats.getMessageProcessorStats().totalProcessedCount() == 2L;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            }
        return plugins;
        ensureGreen(indexName);
        waitForSearchableDocs(9, Arrays.asList(nodeA, nodeB));
                + "\"attributes\":{\"properties\":{\"title\":{\"type\": \"keyword\"}}}}}"
        );
            .get();
                .put("ingestion_source.param.auto.offset.reset", "latest")
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"timestamp\": 100, \"is_deleted\": \"false\"}");
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(indexName, 0, nodeB, nodeC)).get();
            assertNotNull(shardTypeToStats.get("replica"));
                .put("ingestion_source.all_active", true)
        client().admin()
    }
                .build(),
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            public static class Factory implements IngestionPayloadDecoderFactory {
        await().atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
        // Step 1: Publish messages before creating the index
        );
                .put("ingestion_source.all_active", true)
        Map<String, PollingIngestStats> shardTypeToStats = new HashMap<>();
            // The newer version (v2) should win
            return response.getHits().getTotalHits().value() == 1L
        for (int i = 10; i < 20; i++) {
                .put("ingestion_source.all_active", true)
            .cluster()
        assertTrue(nodeC.equals(primaryNodeName(indexName)));
        produceData("1", "name", "30", defaultMessageTimestamp, "index");
        final String nodeA = internalCluster().startDataOnlyNode();
                .put("ingestion_source.param.topic", topicName)
                .put("ingestion_source.mapper_settings.version_field", "timestamp")
            assertThat(docs.get("2").get("name"), is("NAME2"));
        assertTrue(nodeB.equals(replicaNodeName(indexName)));
        }
            assertThat(response.getHits().getTotalHits().value(), is(2L));
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", "1"));
        Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);
        );
    }
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            indexName,
        assertEquals(11L, finalStats.getMessageProcessorStats().totalProcessedCount());
        // replica must not ingest when paused
                Map<String, Object> payloadMap = IngestionUtils.getParsedPayloadMap((byte[]) message.getPayload());
        // Step 8: Publish 1 new message
        produceData(validMessage1);
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
                .put("ingestion_source.type", "kafka")
                .put("ingestion_source.all_active", true)
        assertThat(shardTypeToStats.get("replica").getConsumerStats().totalPollerMessageFailureCount(), is(0L));
            );
            produceData(Integer.toString(i), "name" + i, "25");
                && Integer.valueOf(30).equals(aliceDoc.get("age"))
        // --- Scenario 2: only id_field configured (minimal config) ---
        // Step 12: Add third node
            .get();
            assertThat(response.getHits().getTotalHits().value(), is(1L));
        await().atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
            .prepareCreateSnapshot(snapshotRepositoryName, snapshotName)
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
        assertThat(shardTypeToStats.get("primary").getConsumerStats().totalPollerMessageFailureCount(), is(0L));
                "Should have 4 nodes total (1 cluster manager + 3 data)",
                .put("ingestion_source.type", "kafka")
            assertThat(response.getHits().getTotalHits().value(), is(1L));
        // Step 3: Create index with warmup enabled (lag_threshold=100, so 5 messages will be under threshold)
            @SuppressWarnings("unchecked")
        // Create all-active pull-based index
    public void testMultiThreadedWrites() throws Exception {
                && stats.getConsumerStats().totalPollerMessageFailureCount() == 1L
        // Wait for processor to encounter the error
                .put("ingestion_source.param.auto.offset.reset", "none")
                .put("ingestion_source.param.topic", topicName)
        for (int i = 20; i < 30; i++) {
        client().admin()
        // add third node and allocate the replica once the node joins the cluster
                .put("ingestion_source.param.topic", "test")
        assertNotNull(shardTypeToStats.get("primary"));
                    return new UppercaseNameIngestionPayloadDecoder();
        createIndex(
            Settings.builder()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            }
        // Step 6: Produce more data and verify it's still ingested (settings update didn't break anything)
        produceData("1", "name1", "24", 1739459500000L, "index");
        // Step 4: Update auto.offset.reset to latest. This is surrounded by pause/resume to indirectly infer the config change has been
        // resume ingestion
        createIndex(
        // Step 2: Publish doc with unknown field - strict mapping should reject it
        // Wait for both messages to be indexed
        // Step 6: Wait for version conflict count to be 9 and total messages processed to be 10 on both shards.
        pauseIngestionAndWait(indexName, 1);
                .put("ingestion_source.type", "kafka")
                .build(),
                .put("ingestion_source.type", "kafka")
import org.opensearch.index.query.RangeQueryBuilder;
            mapping
    public void testAllActiveOffsetBasedLag() throws Exception {
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
            PollingIngestStats primaryStats = shardTypeToStats.get("primary");
            RangeQueryBuilder query = new RangeQueryBuilder("age").gte(28);
        });
    }
            SearchResponse response = client().prepareSearch(createIndex).get();
        final String nodeB = internalCluster().startDataOnlyNode();
        }
        }
        waitForSearchableDocs(20, Arrays.asList(nodeA, nodeB));
        createIndex(
        // Step 3: Delete the document and validate
        assertEquals(1L, nodeBStats.getMessageProcessorStats().totalVersionConflictsCount());
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
                if (source instanceof Map) {
            return ingestionState.getShardStates().length == 1
        internalCluster().startNode();
        client().admin().cluster().prepareReroute().add(new AllocateReplicaAllocationCommand(indexName, 0, nodeC)).get();
import java.util.function.Function;
            produceData(Integer.toString(i), "name" + i, "30");
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            return Map.of();
        // Step 4: Wait for warmup to complete and docs to be searchable
        // Step 2: Start cluster
                .getPollingIngestStats();
import org.opensearch.index.Message;
        internalCluster().startClusterManagerOnlyNode();
        // Pause ingestion, reset to offset 0, and resume
                .put("ingestion_source.type", "kafka")
            client().admin()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
        assertThat(shardTypeToStats.get("primary").getConsumerStats().totalPollerMessageDroppedCount(), is(0L));
            refresh(indexName);
                .get(indexName)
        );
                .put("ingestion_source.param.topic", topicName)
                .getPollingIngestStats();
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
            return "TEST_CUSTOM_DECODER_PLUGIN";
        ensureGreen(indexName);
            return stats != null
            SearchResponse response = client().prepareSearch(deleteValueIndex).get();
                return payloadMap;
            Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);
import static org.hamcrest.Matchers.is;
        client().admin()
            indexName,
            Settings.builder()
        // Create all-active index with 5 second periodic flush interval
        // Step 18: Wait for 12 messages to be visible on nodeC
        Assert.assertTrue(
    public void testKafkaIngestion_WithCustomDecoder() {
            indexName,
    }
        resumeIngestionWithResetAndWait(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "100", 2);
                .put("ingestion_source.mapper_settings.version_field", "timestamp")
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            .indices()
        // Step 9: Wait for 11 messages to be visible on nodeB
import java.util.HashMap;
            produceData(Integer.toString(i), "name" + i, "30");
     * test ingestion-kafka-plugin is installed
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            refresh(indexName);
                .setSource(
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        waitForState(() -> {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        createIndexWithDefaultSettings(indexName, 1, 0, 5);
            return Map.of(CUSTOM_DECODER_TYPE, new UppercaseNameIngestionPayloadDecoder.Factory());
            produceData(Integer.toString(i), "name" + i, "25");
            Map<String, Map<String, Object>> docs = new HashMap<>();
        ensureGreen(indexName);
            mapping
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        internalCluster().startClusterManagerOnlyNode();
            indexName,
            Settings.builder()
            .prepareUpdateSettings(indexName)
                && stats.getConsumerStats().totalPollerMessageDroppedCount() == 1L
        // Both messages processed, but the older version should be rejected
            refresh(indexName);
            assertThat(stats.getConsumerStats().totalPolledCount(), is(2L));
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        // validate there are 8 messages polled after reset
     * uppercases the {@code name} field of the decoded {@code _source}. Used to verify that a
            "{\"_id\":\"1\", \"_op_type\":\"index\",\"_source\":"
                && "product3".equals(response.getHits().getAt(0).getSourceAsMap().get("product"));
    }
        );
        // the config change has been applied.
            indexName,
import java.util.Locale;
import org.opensearch.indices.pollingingest.XContentIngestionPayloadDecoder;
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
import org.junit.Assert;
                .getMappings()
        ensureGreen(indexName);
                && ingestionState.getShardStates()[0].getPollerState().equalsIgnoreCase("polling");
        pauseIngestionAndWait(indexName, 2);
        String invalidFieldTypeMessage = "{\"name\":123,\"age\":\"not a number\"}";
                .put("ingestion_source.pointer.init.reset", "earliest")
            Settings.builder()
                .put("ingestion_source.pointer.init.reset", "earliest")
                .put("ingestion_source.pointer.init.reset", "earliest")
        // Step 6: Add second node
            mapping
                && stats.getMessageProcessorStats().totalInvalidMessageCount() == 0L;
            .setWaitForCompletion(true)
                && primaryStats.getMessageProcessorStats().totalProcessedCount() == 21L
    public void testSnapshotRestoreOnAllActiveIngestion() throws Exception {
                && stats.getMessageProcessorStats().totalProcessedCount() == 3L
            if (!"alice_v2".equals(source.get("name"))) return false;
            mapping
        // Step 1: Publish 10 messages with versioning
    public void testKafkaIngestion_RewindByOffset() {
    }
        assertEquals(9L, shardTypeToStats.get("primary").getMessageProcessorStats().totalVersionConflictsCount());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .build(),
                + "{\"product\":\"product2\", \"attributes\":{\"title\":\"Banner Ad\",\"is_promotional\":true}}}"
            refresh("test_rewind_by_timestamp");
        }
        // Step 12: Wait for processed count to be 21 and version conflict to be 10 on both shards. On updating the Kafka settings, the
            Settings.builder()
        assertEquals(10L, shardTypeToStats.get("replica").getMessageProcessorStats().totalProcessedCount());
        // Create all-active pull-based index
            if (response.getHits().getTotalHits().value() != 2L) return false;
    public void testConsumerInitializationFailureAndRecovery() throws Exception {
        // Step 15: Wait for 11 messages to be searchable on nodeC (replica)
        produceData("2", "name2", "20");
        });
import org.opensearch.index.IngestionPayloadDecoder;
        });
        waitForState(() -> {
    }
        ensureGreen(indexName);
        internalCluster().startClusterManagerOnlyNode();
                .put("ingestion_source.pointer.init.reset", "earliest")
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
                .put("ingestion_source.param.auto.offset.reset", "earliest")
            assertNotNull(stats);
            .setIndices(indexName)
                .getPollingIngestStats();
            } else {
        String autoOffsetReset = getSettings(indexName, "index.ingestion_source.param.auto.offset.reset");
                .put("ingestion_source.type", "kafka")
            .stream()
        waitForState(() -> {
    }
        // ghi N → index, jkl N → index, ghi Y → delete. Result: abc + def + jkl = at least jkl present, ghi deleted.
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                && replicaStats != null
            .indices()
        String autoOffsetReset = getSettings(indexName, "index.ingestion_source.param.auto.offset.reset");
        // Step 3: Wait for 9 messages to be visible on both nodes
                && !aliceDoc.containsKey("user_id")
        resumeIngestion(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "0");
    }
        });
        // Since offset 100 doesn't exist, it will fall back to earliest (offset 0)
        ensureGreen(indexName);
        // Step 1: Publish 10 messages before creating the index
        internalCluster().startClusterManagerOnlyNode();
        produceData("2", "name2", "20");
                .put("ingestion_source.pointer.init.reset.value", "1739459600000")
                .put("ingestion_source.type", "kafka")
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .put("ingestion_source.mapper_settings.id_field", "user_id")
        assertThat(shardTypeToStats.get("replica").getConsumerStats().totalPollerMessageDroppedCount(), is(0L));
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
                && "diana".equals(docs.get("jkl").get("name"))
        createIndex(
        // reset to offset=2 and resume ingestion
        });
        // Verify the setting was updated
import org.opensearch.test.InternalTestCluster;
        assertEquals(1L, nodeCStats.getMessageProcessorStats().totalVersionConflictsCount());
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
        // Step 1: Create index with auto.offset.reset=none and pointer.init.reset to offset 100 (invalid offset)
        internalCluster().startClusterManagerOnlyNode();
        final String nodeA = internalCluster().startDataOnlyNode();
                .put("ingestion_source.pointer.init.reset", "reset_by_timestamp")
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Step 4: Update the index settings to set auto.offset.reset to earliest and max.poll.records to 200
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            produceDataWithExternalVersion(String.valueOf(i), 1, "name" + i, "25", defaultMessageTimestamp, "index");
        // Step 2: Produce an update message using retrieved ID and validate
            .setWaitForCompletion(true)
        return shardTypeToStats;
            idOnlyIndex,
    public void testRawPayloadMapperIngestion() throws Exception {
    public void testAllActiveIngestionPeriodicFlush() throws Exception {
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
        assertBusy(() -> {
 */
        }
        });
                .put("ingestion_source.mapper_settings.version_field", "timestamp")
                // by resetting to 1739459600000, only the second message will be ingested
        );
            PollingIngestStats replicaStats = shardTypeToStats.get("replica");
                .put("ingestion_source.param.topic", topicName)
                .put("ingestion_source.pointer.init.reset.value", "1")
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            public Map<String, Object> decode(Message<?> message) {
                .put("ingestion_source.type", "kafka")
        createIndex(
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Step 7: Relocate shard from nodeA to nodeB
            Map<String, PollingIngestStats> updatedStats = getPollingIngestStatsForPrimaryAndReplica(indexName);
        });
        assertEquals(2, shards.length);
            .getPollingIngestStats();
import java.util.concurrent.TimeUnit;
        }
        ensureGreen(indexName);
        nodesInfoRequest.addMetric(NodesInfoRequest.Metric.PLUGINS.metricName());
        });
                .put("ingestion_source.type", "kafka")
        internalCluster().startClusterManagerOnlyNode();
                .put("ingestion_source.mapper_type", "field_mapping")
            produceData(Integer.toString(i), "name" + i, "25");
        String deleteValueIndex = "test_custom_delete";
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
                internalCluster().clusterService().state().nodes().getSize()
        // Step 9: Verify total processed message count is 11
        // Step 5: Resume ingestion
        // Delete Index
            return stats != null
        );
    }
        // Step 3: Add is_promotional to the mapping via PUT mapping API
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
                .put("ingestion_source.pointer.init.reset", "earliest")
        String autoOffsetReset = getSettings(indexName, "index.ingestion_source.param.auto.offset.reset");
            .prepareUpdateSettings(indexName)
        public Map<String, IngestionPayloadDecoderFactory> getIngestionPayloadDecoderFactories() {
        );
        ensureGreen(indexName);
        waitForSearchableDocs(10, List.of(nodeA));
        // Step 5: Query on the new boolean field to verify it was indexed correctly
        assertThat(shardTypeToStats.get("primary").getConsumerStats().totalPollerMessageDroppedCount(), is(0L));
        valid &= shardTypeToStats.get("replica") != null
            Settings.builder()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * Integration test for Kafka ingestion.
        waitForState(() -> {
        for (int i = 0; i < 10; i++) {
                    Map<String, Object> sourceMap = (Map<String, Object>) source;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        createIndex(
                .preparePutRepository(snapshotRepositoryName)
                && stats.getMessageProcessorStats().totalProcessedCount() == 2L
                .put("ingestion_source.param.topic", topicName)
                .build(),
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
        waitForSearchableDocs(40, List.of(nodeA, nodeB));
        ensureGreen(indexName);
        PollingIngestStats nodeBStats = client(nodeB).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
    }
        // Step 2: Wait for poller state to be polling
        @SuppressWarnings("rawtypes")
        assertEquals(2, ingestionState.getShardStates().length);
                && "alice".equals(docs.get("abc").get("name"));
                .put("ingestion_source.param.topic", topicName)
        ensureGreen(indexName);
            mapping
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                .put("ingestion_source.mapper_settings.op_type_field.delete_value", "Y")
        String payload = "{\"_op_type\":\"index\",\"_source\":{\"name\":\"name\", \"age\": 25}}";
        waitForState(() -> {
            mapping
                .put("ingestion_source.pointer.init.reset", "earliest")
        );
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        // Step 4: Publish doc with is_promotional - should now succeed after the mapping update
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        });
        for (int i = 10; i < 20; i++) {
                .put("ingestion_source.warmup.timeout", "10m")
        PollingIngestStats stats = client(nodeA).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
    @Override
        SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
import org.opensearch.action.admin.indices.stats.IndexStats;
            indexName,
        produceData("2", "name2", "20", 1739459800000L, "index");
                .getPollingIngestStats();
        // ghi indexed then deleted by Y, jkl remains. Earlier messages (abc, def) also indexed.
    /**
            indexName,
            .getIndex(indexName)
    public void testWarmupPhase() throws Exception {
            @SuppressWarnings("unchecked")
        // Since offset 100 doesn't exist, it will fall back to earliest (offset 0).
                && stats.getConsumerStats().totalPollerMessageFailureCount() == 0L
    public void testKafkaIngestion_WithExplicitDecoderType() {
        assertEquals(10, getSearchableDocCount(nodeB));
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        waitForState(() -> {
            .getPollingIngestStats();
        for (int i = 1; i <= 10; i++) {
        );
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"timestamp\": 100, \"action\": \"INSERT\"}");
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            if (response.getHits().getTotalHits().value() != 2L) return false;
        }
            Settings.builder()
            refresh(indexName);
            indexName,
        });
                .put("ingestion_source.type", "kafka")
        // Step 3: Create index with warmup enabled, lag_threshold=0, and long timeout
        waitForState(() -> {
import org.opensearch.transport.client.Requests;
    }
                )
                .put("ingestion_source.mapper_settings.version_field", "timestamp")
            Settings.builder()
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        for (int i = 0; i < 5; i++) {
                && stats.getConsumerStats().totalConsumerErrorCount() >= 1L;
            SearchResponse response = client().prepareSearch(indexName).get();
        // Step 2: Start cluster
            return 30 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");
        public String getType() {
        createIndexWithDefaultSettings(1, 0);
                .put("ingestion_source.mapper_settings.id_field", "user_id")
        );
            Settings.builder()
        produceData(
        produceData("{\"user_id\": \"def\", \"name\": \"bob\", \"age\": 25, \"timestamp\": 200, \"is_deleted\": \"false\"}");
        });
        // restart replica node and verify ingestion
            SearchResponse response = client().prepareSearch(indexName).get();
                .put("ingestion_source.type", "kafka")
            Settings.builder()
        // These share the same Kafka topic but use different indices with different mapper configs
            assertThat(response.getHits().getTotalHits().value(), is(1L));
        });
        SearchResponse searchResponse = client().prepareSearch(indexName).get();
                .put("ingestion_source.param.topic", topicName)
        final String nodeA = internalCluster().startDataOnlyNode();
        // create an index with ingestion source from kafka
        PollingIngestStats nodeCStats = client(nodeC).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
            return response.getHits().getTotalHits().value() == 0;
                .build(),
        });
        flush(indexName);
                }
    }
        // Validate replica promotion
        waitForSearchableDocs(20, List.of(nodeA, nodeB));
        produceData("{\"user_id\": \"jkl\", \"name\": \"diana\", \"age\": 28, \"timestamp\": 500, \"expired\": \"N\"}");
            .collect(Collectors.toList());
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", id));
    public void testDynamicWarmupSettingsUpdate() throws Exception {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            is(1L)
        waitForState(() -> {
        waitForSearchableDocs(1, Arrays.asList(nodeA));
                .put("ingestion_source.pointer.init.reset", "earliest")
        waitForSearchableDocs(10, List.of(nodeA));
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        // Step 16: Bring down nodeB (primary) and wait for nodeC to become primary
        // Step 5: Resume ingestion and wait for 10 searchable docs
        // Step 2: Produce an update message and validate
                .put("ingestion_source.param.topic", "test")
        waitForSearchableDocs(20, List.of(nodeB));
                .put("ingestion_source.pointer.init.reset", "earliest")
        // Produce an index message followed by a delete message for the same document
            .get()
        });
        waitForSearchableDocs(11, Arrays.asList(nodeB));
        String snapshotName = "snapshot-1";
        }
        });
        });
        assertEquals("latest", autoOffsetReset);
    public void testKafkaIngestion() {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        internalCluster().startNode();
        // Step 3: Pause ingestion
            indexName,
    }
        assertThat(shardTypeToStats.get("primary").getConsumerStats().totalPollerMessageFailureCount(), is(0L));
        });
                .build(),
        assertEquals(0, ingestionState.getFailedShards());
        // Create all-active pull-based index
                .put("ingestion_source.mapper_type", "field_mapping")
            Map<String, Map<String, Object>> docs = new HashMap<>();
        // Produce messages covering create_value, only-id, and custom delete_value scenarios
            "{\"_id\":\"2\", \"_op_type\":\"index\",\"_source\":"
        }
        });
                .put("ingestion_source.type", "kafka")
        );
        final String nodeA = internalCluster().startDataOnlyNode();
        });
                .put("ingestion_source.pointer.init.reset", "earliest")
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
    public void testCloseIndex() throws Exception {
            "{\"_id\":\"3\", \"_op_type\":\"index\",\"_source\":"
        }, 30, TimeUnit.SECONDS);
        for (int i = 1; i <= 10; i++) {
        }
        // Verify both primary and replica have indexed remaining messages
                && !aliceDoc.containsKey("timestamp")
        // Create all-active pull-based index
                && ingestionState.getShardStates()[0].getPollerState().equalsIgnoreCase("paused");
        }
            .getPollingIngestStats();
            assertTrue(source.containsKey("name"));
        // Publish 2 valid messages
        static final String CUSTOM_DECODER_TYPE = "test_uppercase";
        produceData("1", "name1", "24");
        // Step 5: Verify poller metric confirms all 10 messages were polled during warmup
        );
            PollingIngestStats primaryStats = updatedStats.get("primary");
        produceData("1", "name1", "24");
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        for (int i = 0; i < 10; i++) {
                .put("index.replication.type", "SEGMENT")
        waitForState(() -> validateOffsetBasedLagForPrimaryAndReplica(10));
        // Step 7: Pause ingestion
            produceData(Integer.toString(i), "name" + i, "30");
        }
            Map<String, Map<String, Object>> docs = new HashMap<>();
        // Produce raw JSON messages (no _id/_source/_op_type envelope)
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .build(),
                .getPollingIngestStats();
            Map<String, Map<String, Object>> docs = new HashMap<>();
        internalCluster().startClusterManagerOnlyNode();
                .put("ingestion_source.pointer.init.reset.value", "100")
        // pause ingestion
            if (!docs.containsKey("abc") || !docs.containsKey("def")) return false;
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        });
        for (int i = 5; i < 10; i++) {
            .cluster()
        // Produce messages out of order: newer version first, then older version
                .put("ingestion_source.type", "kafka")
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        waitForState(() -> {
        for (int i = 30; i < 40; i++) {
                .build(),
            Settings.builder()
        // Step 1: Produce message and wait for it to be searchable
                .build(),
                .put("ingestion_source.type", "kafka")
import java.util.stream.Stream;
        for (ShardStats shardStats : shards) {
            produceData(Integer.toString(i), "name" + i, "30");
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        assertAcked(
                    "{\"properties\":{\"attributes\":{\"properties\":"
        internalCluster().startClusterManagerOnlyNode();
    public void testKafkaIngestionWithMappingUpdate() throws Exception {
        // Create index with raw_payload mapper
        resumeIngestionAndWait(indexName, 2);
        internalCluster().startClusterManagerOnlyNode();
    }
                .put("ingestion_source.all_active", true)
            indexName,
            return response.getHits().getTotalHits().value() == 1000;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                .build(),
        NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
        createIndexWithDefaultSettings(1, 0);
            SearchResponse response = client().prepareSearch(indexName)
        assertThat(shardTypeToStats.get("replica").getConsumerStats().totalPollerMessageFailureCount(), is(0L));
                .put("ingestion_source.all_active", true)
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
            refresh(indexName);
                .put("ingestion_source.param.topic", topicName)
        waitForSearchableDocs(12, Arrays.asList(nodeC));
        // Step 2: Start nodes
            Settings.builder()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Verify all 10 messages were processed
                .put("ingestion_source.mapper_settings.op_type_field", "is_deleted")
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        produceData(id, "name", "30", defaultMessageTimestamp, "index");
            produceDataWithExternalVersion(String.valueOf(i), 1, "name" + i, "25", defaultMessageTimestamp, "index");
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            assertNotNull(stats);
                .put("index.replication.type", "SEGMENT")
    public void testUpdateWithoutIDField() throws Exception {
            return primaryStats != null
        );
            Settings.builder()
        final String nodeA = internalCluster().startNode();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));
                && shardTypeToStats.get("replica").getConsumerStats().totalPolledCount() == 8;
        String validMessage1 = "{\"name\":\"alice\",\"age\":30}";
        waitForState(() -> {
                .put("ingestion_source.param.topic", topicName)
        Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);
                && replicaStats != null
            assertTrue(source.containsKey("age"));
        );
    public void testDynamicUpdateKafkaParams() throws Exception {
        assertThat(response.getHits().getTotalHits().value(), is(2L));
        waitForState(() -> {
            produceData(Integer.toString(i), "name" + i, "30");
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        assertEquals(2L, nodeBStats.getMessageProcessorStats().totalProcessedCount());
        resumeIngestionWithResetAndWait(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "2", 2);
                && primaryStats.getMessageProcessorStats().totalVersionConflictsCount() == 10L
        public static class UppercaseNameIngestionPayloadDecoder implements IngestionPayloadDecoder {
        // --- Scenario 1: create_value support ---
                .put("ingestion_source.all_active", true)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                .get();
                    .put("ingestion_source.param.auto.offset.reset", "earliest")
        Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);
        assertThat(searchableDocsResponse.getHits().getTotalHits().value(), is(1L));
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        );
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
        ensureGreen(indexName);
                .build(),
        ensureGreen(indexName);
        produceData("{\"user_id\": \"ghi\", \"name\": \"charlie\", \"age\": 35, \"timestamp\": 600, \"expired\": \"Y\"}");
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        waitForSearchableDocs(40, List.of(nodeA, nodeC));
        internalCluster().startClusterManagerOnlyNode();
        final String nodeC = internalCluster().startDataOnlyNode();
                .put("ingestion_source.all_active", true)
            PollingIngestStats replicaStats = updatedStats.get("replica");
            assertEquals(
                .put("ingestion_source.type", "kafka")
                .put("ingestion_source.mapper_type", "raw_payload")
        );
                .put("ingestion_source.type", "kafka")
            "test_rewind_by_offset",
        // Restore Index from Snapshot
            produceData(Integer.toString(i), "name" + i, "25");
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
                .put("ingestion_source.mapper_type", "field_mapping")
import org.opensearch.common.settings.Settings;
                .get()
                .put("ingestion_source.mapper_settings.op_type_field", "expired")
        waitForState(() -> {
                && (ingestionState.getShardStates()[0].getPollerState().equalsIgnoreCase("polling")
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeB));
        client().admin()
        CreateSnapshotResponse snapshotResponse = client().admin()
        client().admin()
        assertEquals("earliest", autoOffsetReset);
                .put("ingestion_source.param.auto.offset.reset", "latest")
            indexName,
        // add second node
        // Verify 1 message was processed
        // last message (offset=9) is reprocessed resulting in additional processed message and version conflict.
        ensureYellowAndNoInitializingShards(indexName);
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        // Create all-active pull-based index
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        produceData("{\"user_id\": \"def\", \"name\": \"bob\", \"age\": 25, \"timestamp\": 200, \"action\": \"UPDATE\"}");
        waitForState(() -> {
            SearchResponse searchableDocsResponse = client().prepareSearch(indexName).setSize(2000).setPreference("_only_local").get();
        });
        assertThat("message2 should be dropped", statsBeforePutMapping.getMessageProcessorStats().totalFailuresDroppedCount(), is(1L));
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
        );
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                && stats.getConsumerStats().totalPolledCount() == 2L
        PollingIngestStats stats = client(nodeA).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        );
            .get();
                .put("ingestion_source.type", "kafka")
        // applied.
        // Step 1: Produce messages
            produceData(Integer.toString(i), "name" + i, "30");
        produceData("1", "name1", "24");
    }
 * The OpenSearch Contributors require contributions made to
            Map<String, Object> source = searchResponse.getHits().getHits()[i].getSourceAsMap();
        // pause ingestion
    public void testMessageOperationTypes() throws Exception {
        createIndexWithDefaultSettings(1, 0);
        // Step 1: Publish 10 messages
                .setType("fs")
import java.util.Map;
        produceData("{\"user_id\": \"abc\", \"name\": \"alice_v1\", \"age\": 30, \"timestamp\": 100, \"is_deleted\": \"false\"}");
/**
    private boolean validateOffsetBasedLagForPrimaryAndReplica(long expectedLag) {
                .put("ingestion_source.pointer.init.reset", "earliest")
            }
            refresh(deleteValueIndex);
        });
        assertEquals(2, searchResponse.getHits().getHits().length);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            refresh(idOnlyIndex);
        PollingIngestStats statsAfterPut = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        });
                .put("ingestion_source.mapper_settings.op_type_field", "action")
                .put("ingestion_source.param.auto.offset.reset", "latest")
        ensureYellowAndNoInitializingShards(indexName);
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        pauseIngestionAndWait(indexName, 2);
                && !docs.get("abc").containsKey("user_id")
 */
        });
        ensureGreen(indexName);
        // Resume with reset to offset 0 (will re-process the 2 valid messages)
        produceData(validMessage2);
        createIndex(
                && stats.getConsumerStats().totalPollerMessageDroppedCount() == 0L
        // Step 1: Produce message without ID
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
        // Step 10: Resume ingestion. This does not recreate the poller as consumer is not reset.
                .put("ingestion_source.all_active", true)
        assertNotNull(stats);
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
        }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        plugins.add(TestCustomDecoderPlugin.class);
        // Step 6: Publish 1 message and wait for it to be searchable
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;
        createIndex(
            ClusterState state = client().admin().cluster().prepareState().setIndices(indexName).get().getState();
package org.opensearch.plugin.kafka;
                && !docs.get("def").containsKey("action");
                .prepareGetMappings(indexName)
    }
            indexName,
            mapping
        }
        String invalidJsonMessage = "{ invalid json";
        SearchResponse searchableDocsResponse = client().prepareSearch(indexName).setSize(10).setPreference("_only_local").get();
        String validMessage2 = "{\"name\":\"bob\",\"age\":25}";
        waitForSearchableDocs(1, List.of(nodeA));
        waitForSearchableDocs(2, List.of(nodeA));
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
                .put("ingestion_source.type", "kafka")
        // produce 10 messages in paused state and validate lag
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        valid &= shardTypeToStats.get("primary") != null
        // replica consumes only 10 messages after it has been restarted
                .build(),
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
            PollingIngestStats stats = client(nodeA).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", "1"));
        for (int i = 20; i < 40; i++) {
                .put("ingestion_source.param.topic", topicName)
        for (int i = 0; i < 1000; i++) {
        resumeIngestionAndWait(indexName, 1);
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        // Step 4: Validate create operation
        createIndex(
        // Verify the setting was updated
                .build(),
                .put("ingestion_source.param.topic", topicName)
        // Step 19: Validate processed messages and version conflict count on nodeC
                .build(),
        // Step 2: Create index with pointer.init.reset to offset 1 and auto.offset.reset=latest
        assertNotNull(shardTypeToStats.get("replica"));
        // no messages published, expect 0 lag
        assertEquals("latest", autoOffsetReset);
        });
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"timestamp\": 100, \"is_deleted\": \"false\"}");
            Settings.builder()
        String snapshotRepositoryName = "test-snapshot-repo";
        // Publish invalid JSON message
 * SPDX-License-Identifier: Apache-2.0
        // Start nodes
        assertThat(shardTypeToStats.get("replica").getConsumerStats().totalPolledCount(), is(21L));
        }
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        produceData(invalidFieldTypeMessage);
        final String nodeA = internalCluster().startDataOnlyNode();
        // Step 4: Wait for 10 messages to be searchable on nodeA
                .put("ingestion_source.pointer.init.reset", "earliest")
        createIndex(
            )
                .put("ingestion_source.param.topic", topicName)
        }
        // Wait for the 3 messages to be processed by the processor after reset (1 will be dropped by the poller)
                        sourceMap.put("name", ((String) name).toUpperCase(Locale.ROOT));
    }
        // Verify still only 2 documents (no duplicates must be indexed)
        produceData("1", "name", "25", defaultMessageTimestamp, "index");
        }
        final String nodeB = internalCluster().startDataOnlyNode();
                .put("ingestion_source.param.topic", topicName)
        // Verify the setting was updated
                && !docs.get("abc").containsKey("action")
        );
        autoOffsetReset = getSettings(indexName, "index.ingestion_source.param.auto.offset.reset");
                .put("ingestion_source.param.topic", topicName)
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
 *
        createIndex(
        // Verify failedCount is still 1 (only message2 failed, message3 succeeded)
            .prepareUpdateSettings(indexName)
                4,
        assertThat(shardTypeToStats.get("primary").getConsumerStats().totalPolledCount(), is(21L));
    }
        ShardStats[] shards = indexStats.getShards();
        // Publish message with invalid content that will fail at processor level
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        });
        produceDataWithExternalVersion("12", 1, "name12", "25", defaultMessageTimestamp, "index");
            assertThat(stats.getMessageProcessorStats().totalProcessedCount(), is(2L));
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));
        // Step 2: Wait for consumer error and paused status
        produceData("2", "name", "30", defaultMessageTimestamp, "create");
                shardTypeToStats.put("replica", shardStats.getPollingIngestStats());
                && !aliceDoc.containsKey("is_deleted");
                && replicaStats.getMessageProcessorStats().totalProcessedCount() == 10L
                .put("ingestion_source.param.topic", topicName)
        pauseIngestion(indexName);
            .setSettings(Settings.builder().put("ingestion_source.param.auto.offset.reset", "earliest"))
        );
        for (int i = 10; i < 20; i++) {
import org.opensearch.indices.pollingingest.PollingIngestStats;
        waitForSearchableDocs(20, List.of(nodeA, nodeB));
        // Need new messages with the Y/N pattern on the same topic
                && primaryStats.getMessageProcessorStats().totalVersionConflictsCount() == 9L
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        final String nodeC = internalCluster().startDataOnlyNode();
                .put("ingestion_source.mapper_type", "field_mapping")
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
                .put("ingestion_source.pointer.init.reset", "earliest")
                .put("ingestion_source.pointer.init.reset", "earliest")
                .put("index.replication.type", "SEGMENT")
            return docs.containsKey("jkl")
        assertNotNull(nodeBStats);
        createIndex(
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            // Verify _source does not contain extracted metadata fields
            return stats != null
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
        final String nodeC = internalCluster().startDataOnlyNode();
        );
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .getPollingIngestStats();
            .get();
                .put("ingestion_source.param.topic", topicName)
                .put("ingestion_source.warmup.lag_threshold", 100)
        produceData(
        return valid;
            Settings.builder()
                && stats.getMessageProcessorStats().totalProcessedCount() == 2L
        waitForSearchableDocs(10, List.of(nodeB));
        }
        });
                .build(),
                .put("ingestion_source.decoder_type", XContentIngestionPayloadDecoder.NAME)
import org.opensearch.action.admin.indices.stats.ShardStats;
            produceData(Integer.toString(i), "name" + i, "25");
            if (response.getHits().getTotalHits().value() != 0L) return false;
                // 1739459800000 is the timestamp of the second message
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                + "{\"product\":\"product3\", \"attributes\":{\"title\":\"Holiday Sale\",\"is_promotional\":false}}}"
        @Override
import org.opensearch.index.query.BoolQueryBuilder;
            return docs.containsKey("abc")
            Settings.builder()
                .put("ingestion_source.param.topic", topicName)
            SearchResponse response = client().prepareSearch(indexName).get();
                && replicaStats.getMessageProcessorStats().totalProcessedCount() == 21L
                .put("ingestion_source.type", "kafka")
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"timestamp\": 200, \"is_deleted\": \"true\"}");
        );
            assertThat(response.getHits().getTotalHits().value(), is(1L));
                .put("ingestion_source.mapper_settings.id_field", "user_id")
        // Both messages processed, but the delete should remove the document
        produceData("10", "name10", "30");
            return ingestionState.getShardStates().length == 1
                .put("ingestion_source.mapper_type", "field_mapping")
        });
                && stats.getConsumerStats().totalPolledCount() == 3L
                .getPollingIngestStats();
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            && shardTypeToStats.get("primary").getConsumerStats().pointerBasedLag() == expectedLag;
            return 25 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");
    public void testKafkaIngestion_RewindByTimeStamp() {
        ensureGreen(indexName);
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            Map<String, Object> attrProps = (Map<String, Object>) ((Map<String, Object>) properties.get("attributes")).get("properties");
            Map<String, Object> properties = (Map<String, Object>) mappings.get("properties");
        assertAcked(client().admin().indices().prepareDelete(indexName));
        boolean valid = true;
            .flatMap(
    public void testResetPollerInAllActiveIngestion() throws Exception {
    }
        // Verify the setting was updated
            assertThat(docs.get("1").get("name"), is("NAME1"));
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                .put("ingestion_source.param.topic", topicName)
        pauseIngestionAndWait(indexName, 2);
            .prepareStats(indexName)
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(21);
        assertNotNull(shardTypeToStats.get("replica"));
    public static class TestCustomDecoderPlugin extends Plugin implements IngestionConsumerPlugin {
            Settings.builder()
                && stats.getMessageProcessorStats().totalFailuresDroppedCount() == 1L;
                .put("ingestion_source.pointer.init.reset", "earliest")
        // Step 5: Flush to persist data
    }
                .setSettings(Settings.builder().put("location", randomRepoPath()).put("compress", false))
        for (int i = 0; i < 20; i++) {
        List<PluginInfo> pluginInfos = nodesInfoResponse.getNodes()
                && !docs.get("jkl").containsKey("expired");
        // Step 3: Publish 10 messages
            .prepareUpdateSettings(indexName)
        assertEquals(10L, shardTypeToStats.get("primary").getMessageProcessorStats().totalProcessedCount());
                .indices()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(21);
            return state.getRoutingTable().hasIndex(indexName) == false && state.getMetadata().hasIndex(indexName) == false;
                .put("index.periodic_flush_interval", "5s")
                && ingestionState.getShardStates()[0].isPollerPaused()
        assertEquals("earliest", autoOffsetReset);
                .getSourceAsMap();
            .setIndices(indexName)
                && !docs.containsKey("ghi")
        );
                .put("ingestion_source.pointer.init.reset", "earliest")
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
                && stats != null
        waitForState(() -> {
        assertEquals(2L, nodeCStats.getMessageProcessorStats().totalProcessedCount());
        createIndex(
            // action field should be removed from _source
        for (int i = 0; i < 1000; i++) {
        );
            statsBeforePutMapping.getMessageProcessorStats().totalFailedCount(),
            assertNotNull(stats);
                Settings.builder()
        // add a second node and verify the replica ingests the data
        // create index with 5 writer threads
        waitForSearchableDocs(10, List.of(nodeA, nodeB));
        produceData("2", "name2", "20");
import org.opensearch.cluster.metadata.IndexMetadata;
        );
            SearchResponse response = client().prepareSearch("test_rewind_by_timestamp").setQuery(query).get();
                .put("ingestion_source.mapper_settings.id_field", "user_id")
        // Register snapshot repository
        waitForState(() -> {
            assertThat(stats.getMessageProcessorStats().totalProcessedCount(), is(2L));
        produceData(
        flush(indexName);
                    }
            return searchableDocsResponse.getHits().getTotalHits().value() == 1000;
        final String nodeA = internalCluster().startDataOnlyNode();
        // Step 3: Create all-active index
        // Step 1: Publish doc with known fields and wait for it to be searchable
            Map<String, Object> aliceDoc = docs.get("abc");
        waitForSearchableDocs(10, List.of(nodeA, nodeB));
            client().admin()
        // Step 2: Update age field from 25 to 30 and validate
        final String nodeA = internalCluster().startDataOnlyNode();
        // Step 13: Bring down nodeA so the new replica will be allocated to nodeC
            indexName,
                .put("index.replication.type", "SEGMENT")
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
        assertThat(statsAfterPut.getMessageProcessorStats().totalFailedCount(), is(1L));
            assertThat(stats.getConsumerStats().totalPolledCount(), is(2L));
        createIndex(
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
        String idOnlyIndex = "test_id_only";
            SearchResponse response = client().prepareSearch("test_rewind_by_offset").setQuery(query).get();
            // Verify document IDs are extracted from user_id field
        final String nodeB = internalCluster().startDataOnlyNode();
        waitForState(() -> {
            return 25 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");
        // Start cluster
        });
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Publish 10 messages
                .put("ingestion_source.param.topic_metadata_fetch_timeout_ms", 5000)
            .prepareRestoreSnapshot(snapshotRepositoryName, snapshotName)
    public void testReplicaPromotionOnAllActiveIngestion() throws Exception {
                .put("ingestion_source.pointer_based_lag_update_interval", "3s")
            .setSettings(Settings.builder().put("ingestion_source.param.auto.offset.reset", "latest"))
            assertThat(response.getHits().getTotalHits().value(), is(1L));
                Object source = payloadMap.get("_source");
                    || ingestionState.getShardStates()[0].getPollerState().equalsIgnoreCase("processing"));
        // Verify stats show 2 processed messages
        createIndex(
                && docs.containsKey("def")
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
            return shardTypeToStats.get("primary").getConsumerStats().totalPolledCount() == 8
        waitForSearchableDocs(10, List.of(nodeA));
            produceDataWithExternalVersion(String.valueOf(i), 1, "name" + i, "25", defaultMessageTimestamp, "index");
        ensureGreen(indexName);
        ensureGreen(indexName);
                && replicaStats.getMessageProcessorStats().totalVersionConflictsCount() == 9L;
import org.opensearch.plugins.Plugin;
        );
        // Total messages on topic: 5. For this index: abc, def have no "expired" field → default index,
        internalCluster().startClusterManagerOnlyNode();
        // Wait for consumer to encounter the error and drop it
                .put("ingestion_source.all_active", true)
                .put("ingestion_source.pointer.init.reset", "earliest")
        createIndex(
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
            return primaryStats != null
            refresh(indexName);
        // Step 9: Verify processed count is still 10 on both shards
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            .getShards()[0].getPollingIngestStats();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            createIndex,
                && stats.getConsumerStats().totalPollerMessageFailureCount() == 1L
    public void testAllActiveIngestion() throws Exception {
            refresh(indexName);
        PollingIngestStats stats = client(nodeA).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
            return ingestionState.getShardStates().length == 1
            assertThat(stats.getMessageProcessorStats().totalProcessedCount(), is(2L));
                .build(),
    public void testKafkaIngestionWithFieldMappingMapper_DeleteOperation() throws Exception {
            .indices()
            return 30 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("age", "25"));
        client().admin()
    // returns PollingIngestStats for single primary and single replica
                .put("ingestion_source.mapper_settings.op_type_field", "is_deleted")
                .put("ingestion_source.type", "kafka")
        });
            "test_rewind_by_timestamp",
import java.util.ArrayList;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    .put("ingestion_source.param.max.poll.records", "200")
                && primaryStats.getMessageProcessorStats().totalProcessedCount() == 10L
        internalCluster().startNode();
        produceData("1", "name1", "24");
                @Override
        internalCluster().startNode();
        createIndex(
        assertTrue(snapshotResponse.getSnapshotInfo().successfulShards() > 0);
        waitForSearchableDocs(10, List.of(nodeB));
        // Step 17: Publish 1 more message
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.cluster.ClusterState;
 * this file be licensed under the Apache-2.0 license or a
                (Function<NodeInfo, Stream<PluginInfo>>) nodeInfo -> nodeInfo.getInfo(PluginsAndModules.class).getPluginInfos().stream()
     * plugin-contributed decoder (as opposed to the built-in {@code xcontent} decoder) is honored
                .put("ingestion_source.mapper_settings.op_type_field.delete_value", "true")
import org.opensearch.index.IngestionConsumerFactory;
            assertNotNull(shardTypeToStats.get("primary"));
