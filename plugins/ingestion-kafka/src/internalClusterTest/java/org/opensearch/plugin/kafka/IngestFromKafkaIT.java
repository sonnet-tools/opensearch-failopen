            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"  
                .put("ingestion_source.mapper_settings.id_field", "user_id")  
                .put("ingestion_source.all_active", true)
            SearchResponse response = client().prepareSearch(indexName).get();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);  
            assertNotNull(shardTypeToStats.get("replica"));
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                .put("ingestion_source.type", "kafka")
            refresh(idOnlyIndex);
        );
                .put("ingestion_source.mapper_settings.op_type_field.delete_value", "true")  
        @Override
                .put("ingestion_source.pointer.init.reset", "earliest")
        waitForSearchableDocs(10, List.of(nodeA));
                .put("ingestion_source.type", "kafka")  
            SearchResponse response = client().prepareSearch(indexName)
        // Create index with raw_payload mapper
        internalCluster().startNode();  
            "{\"_id\":\"2\", \"_op_type\":\"index\",\"_source\":"  
            indexName,
        waitForState(() -> {
        }
                .put("ingestion_source.all_active", true)  
        }  
        static final String CUSTOM_DECODER_TYPE = "test_uppercase";  
        );
    }
        createIndex(  
            SearchResponse response = client().prepareSearch(indexName).get();
        // Step 1: Create index with auto.offset.reset=none and pointer.init.reset to offset 100 (invalid offset)
            client().admin()
            return Map.of(CUSTOM_DECODER_TYPE, new UppercaseNameIngestionPayloadDecoder.Factory());  
        // This should cause consumer initialization to fail
            .getPollingIngestStats();  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
import org.opensearch.action.admin.indices.stats.ShardStats;
        // Produce raw JSON messages (no _id/_source/_op_type envelope)
            Map<String, Map<String, Object>> docs = new HashMap<>();
            .get();  
            assertThat(response.getHits().getTotalHits().value(), is(1L));  
                .put("ingestion_source.mapper_settings.op_type_field.delete_value", "true")
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"timestamp\": 200, \"is_deleted\": \"true\"}");
        final String nodeA = internalCluster().startDataOnlyNode();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .prepareGetMappings(indexName)
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
            pluginInfos.stream().anyMatch(pluginInfo -> pluginInfo.getName().equals("org.opensearch.plugin.kafka.KafkaPlugin"))
            return state.getRoutingTable().hasIndex(indexName) == false && state.getMetadata().hasIndex(indexName) == false;
        Map<String, PollingIngestStats> shardTypeToStats = new HashMap<>();
        // Step 2: Produce an update message using retrieved ID and validate  
                && !docs.get("abc").containsKey("user_id")
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        }
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
            produceData(Integer.toString(i), "name" + i, "30");
        // Step 6: Add second node  
            RangeQueryBuilder query = new RangeQueryBuilder("age").gte(28);
                && !docs.containsKey("ghi")
                .put("ingestion_source.all_active", true)
    public void testKafkaIngestionWithFieldMappingMapper() throws Exception {
                    }
        // Verify failedCount is still 1 (only message2 failed, message3 succeeded)
        produceData("1", "name1", "24", 1739459500000L, "index");
                && stats.getConsumerStats().totalPollerMessageDroppedCount() == 0L
            return stats != null
    }  
                .put("ingestion_source.type", "kafka")
                .put("ingestion_source.warmup.lag_threshold", 100)
        ensureYellowAndNoInitializingShards(indexName);  
        waitForSearchableDocs(9, Arrays.asList(nodeA, nodeB));
                .put("ingestion_source.pointer.init.reset", "earliest")
        waitForState(() -> {
        // Publish invalid JSON message  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testConsumerInitializationFailureAndRecovery() throws Exception {  
                .getPollingIngestStats();
            deleteValueIndex,
        waitForState(() -> {
                .put("ingestion_source.param.auto.offset.reset", "latest")
            .indices()
            SearchResponse response = client().prepareSearch(indexName).get();  
                .put("index.replication.type", "SEGMENT")
                .put("index.periodic_flush_interval", "5s")
            return response.getHits().getTotalHits().value() == 1L
                .getSourceAsMap();  
            return ingestionState.getShardStates().length == 1
            Settings.builder()  
        for (int i = 10; i < 20; i++) {
        client().admin()
                .indices()
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
        assertThat(response.getHits().getTotalHits().value(), is(2L));
                .put("ingestion_source.all_active", true)
                && !docs.get("abc").containsKey("action")
        // Verify stats show 2 processed messages  
                .put("ingestion_source.mapper_settings.op_type_field", "expired")
        // Step 5: Query on the new boolean field to verify it was indexed correctly
        waitForSearchableDocs(5, List.of(nodeA));
            } else {  
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
import java.util.stream.Stream;
        produceData("1", "name1", "25");  
        pauseIngestionAndWait(indexName, 1);  
        await().atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {  
        // Step 11: Validate processed messages and version conflict count on nodeB
                .put("ingestion_source.pointer.init.reset", "earliest")  
            produceDataWithExternalVersion(String.valueOf(i), 1, "name" + i, "25", defaultMessageTimestamp, "index");  
        produceData("1", "name1", "24");  
        // Step 1: Produce messages
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
        });
                Object source = payloadMap.get("_source");
        // Step 8: Wait for 11 searchable docs
            refresh(createIndex);  
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
            client().admin()
            refresh(deleteValueIndex);  
                .put("ingestion_source.mapper_settings.id_field", "user_id")
        // Step 4: Update auto.offset.reset to earliest
            produceData(Integer.toString(i), "name" + i, "25");
        });  
        );  
                .getPollingIngestStats();  
        assertThat(shardTypeToStats.get("replica").getConsumerStats().totalPollerMessageDroppedCount(), is(0L));
                .put("ingestion_source.type", "kafka")
    public void testSnapshotRestoreOnAllActiveIngestion() throws Exception {
        createIndex(
 * SPDX-License-Identifier: Apache-2.0
                .build(),
            indexName,
        assertThat(shardTypeToStats.get("primary").getConsumerStats().totalPollerMessageDroppedCount(), is(0L));  
            assertThat(response.getHits().getTotalHits().value(), is(1L));  
        });
            mapping
            .get();
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        });  
        assertNotNull(stats);
                .preparePutMapping(indexName)  
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
                    .put("ingestion_source.param.max.poll.records", "200")
        // Step 2: Wait for poller state to be polling
                + "{\"product\":\"product1\", \"attributes\":{\"title\":\"Screenshot 2026\"}}}"
                .getPollingIngestStats();  
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", "2"));  
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));
            .get()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .put("ingestion_source.param.topic", topicName)
        createIndex(
import org.opensearch.index.Message;
        // Step 12: Wait for processed count to be 21 and version conflict to be 10 on both shards. On updating the Kafka settings, the  
            assertThat(response.getHits().getTotalHits().value(), is(1L));  
            .indices()  
        produceData("1", "name1", "24");
            Map<String, Map<String, Object>> docs = new HashMap<>();
        assertEquals(10L, stats.getConsumerStats().totalPolledCount());  
            .get();  
                .put("ingestion_source.error_strategy", "drop")
        produceData("{\"user_id\": \"abc\", \"name\": \"alice_v2\", \"age\": 31, \"timestamp\": 200, \"is_deleted\": \"false\"}");
        pauseIngestionAndWait(indexName, 2);
        waitForState(() -> {
                .put("ingestion_source.pointer.init.reset.value", "1739459600000")
            return "alice".equals(aliceDoc.get("name"))
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
                .build(),
        PollingIngestStats stats = client(nodeA).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
                .put("index.replication.type", "SEGMENT")
    }
                .put("ingestion_source.pointer.init.reset", "earliest")
                .put("ingestion_source.type", "kafka")  
        final String nodeB = internalCluster().startDataOnlyNode();  
            produceData(Integer.toString(i), "name" + i, "25");
        PollingIngestStats finalStats = client(nodeA).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
                .put("ingestion_source.param.auto.offset.reset", "earliest")
        // confirm replica ingests messages after moving to new node
import org.opensearch.index.query.TermQueryBuilder;
                        + "{\"is_promotional\":{\"type\":\"boolean\",\"doc_values\":false}}}}}",  
        ensureGreen(indexName);
        nodesInfoRequest.addMetric(NodesInfoRequest.Metric.PLUGINS.metricName());
                .put("ingestion_source.param.topic", topicName)
            assertNotNull(stats);
        // Step 6: Update auto.offset.reset to earliest again. Consumer must not be reinitialized again as no config change.
        waitForState(() -> {
            return 30 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");  
        client().admin().indices().close(Requests.closeIndexRequest(indexName)).get();
        }, 30, TimeUnit.SECONDS);
        final String nodeC = internalCluster().startDataOnlyNode();  
import static org.hamcrest.Matchers.is;
        resumeIngestionAndWait(indexName, 2);
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
        produceData(  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            mapping  
        produceData("2", "name2", "20");
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        final String nodeB = internalCluster().startDataOnlyNode();  
        produceDataWithExternalVersion("11", 1, "name11", "25", defaultMessageTimestamp, "index");  
        }
            mapping
        createIndex(
        waitForSearchableDocs(10, List.of(nodeA));
                .put("ingestion_source.all_active", true)
                    Map<String, Object> sourceMap = (Map<String, Object>) source;
        // move replica from nodeB to nodeC  
     * uppercases the {@code name} field of the decoded {@code _source}. Used to verify that a
        valid &= shardTypeToStats.get("primary") != null
            .getPollingIngestStats();  
        waitForSearchableDocs(20, Arrays.asList(nodeA, nodeB));  
            indexName,  
        // add second node  
            );  
        assertThat(shardTypeToStats.get("replica").getConsumerStats().totalPollerMessageFailureCount(), is(0L));
                .put("ingestion_source.param.topic", topicName)
        // Step 3: Delete the document and validate
        // Wait for processor to encounter the error
        );
        }
            refresh(indexName);
    public void testMultiThreadedWrites() throws Exception {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
        // Step 9: Wait for 11 messages to be visible on nodeB
        produceData(validMessage1);
        for (int i = 30; i < 40; i++) {
                .build(),
                && stats.getMessageProcessorStats().totalFailuresDroppedCount() == 1L;
            Settings.builder()  
        assertEquals(10L, shardTypeToStats.get("primary").getMessageProcessorStats().totalProcessedCount());
            indexName,
        assertEquals(10L, stats.getMessageProcessorStats().totalProcessedCount());
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
    private boolean validateOffsetBasedLagForPrimaryAndReplica(long expectedLag) {
            .getPollingIngestStats();
                .put("ingestion_source.type", "kafka")  
        produceDataWithExternalVersion("12", 1, "name12", "25", defaultMessageTimestamp, "index");
                .put("ingestion_source.type", "kafka")
                .put("ingestion_source.param.topic", topicName)
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
        final String nodeA = internalCluster().startDataOnlyNode();  
        // Step 12: Add third node  
            if (!docs.containsKey("abc") || !docs.containsKey("def")) return false;
                .put("ingestion_source.param.topic", topicName)
        resumeIngestionAndWait(indexName, 2);
                .build(),  
                && stats.getConsumerStats().totalPolledCount() == 4L  
            produceDataWithExternalVersion(String.valueOf(i), 1, "name" + i, "25", defaultMessageTimestamp, "index");  
import org.opensearch.index.query.BoolQueryBuilder;
     * test ingestion-kafka-plugin is installed  
        // create an index with ingestion source from kafka
            produceData(Integer.toString(i), "name" + i, "30");
                && primaryStats.getMessageProcessorStats().totalVersionConflictsCount() == 10L  
            )
            return attrProps.containsKey("is_promotional");
        waitForState(() -> {  
        // Verify still only 2 documents (no duplicates must be indexed)
package org.opensearch.plugin.kafka;
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);  
        });  
                .put("ingestion_source.mapper_settings.op_type_field", "action")
        internalCluster().restartNode(nodeC);
            .prepareUpdateSettings(indexName)
public class IngestFromKafkaIT extends KafkaIngestionBaseIT {  
            refresh(indexName);
        waitForSearchableDocs(30, List.of(nodeA, nodeC));  
                .put("ingestion_source.pointer.init.reset", "earliest")
        waitForState(() -> {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put("ingestion_source.error_strategy", "drop")
        // ghi N → index, jkl N → index, ghi Y → delete. Result: abc + def + jkl = at least jkl present, ghi deleted.
                && stats.getConsumerStats().totalPolledCount() == 3L  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            assertNotNull(stats);
            .prepareCreateSnapshot(snapshotRepositoryName, snapshotName)  
            .cluster()
        assertTrue(nodeC.equals(primaryNodeName(indexName)));
        assertThat(searchableDocsResponse.getHits().getTotalHits().value(), is(1L));
                .put("ingestion_source.all_active", true)
        }  
        }
                .put("ingestion_source.param.topic", "test")  
        });  
        // Step 7: Relocate shard from nodeA to nodeB  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            mapping  
            indexName,  
    /**
            return stats != null
                .put("ingestion_source.param.topic", topicName)
            produceData(Integer.toString(i), "name" + i, "30");
                // by resetting to 1739459600000, only the second message will be ingested  
    }
                && "diana".equals(docs.get("jkl").get("name"))  
            indexName,
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            return stats != null && stats.getMessageProcessorStats().totalProcessedCount() == 3L;
import org.opensearch.transport.client.Requests;
                && stats.getMessageProcessorStats().totalProcessedCount() == 2L
            .setWaitForCompletion(true)  
        // Step 5: Flush to persist data  
        waitForSearchableDocs(10, List.of(nodeB));  
        );
            produceData(Integer.toString(i), "name" + i, "25");  
        waitForState(() -> {
        final String nodeB = internalCluster().startDataOnlyNode();
        }
            .indices()
        createIndex(
        // replica must not ingest when paused
        client().admin()
        }  
        createIndex(  
        produceData("1", "name", "30", defaultMessageTimestamp, "index");
        // Step 2: Produce an update message and validate
        NodesInfoResponse nodesInfoResponse = OpenSearchIntegTestCase.client().admin().cluster().nodesInfo(nodesInfoRequest).actionGet();
            produceData(Integer.toString(i), "name" + i, "30");
        String autoOffsetReset = getSettings(indexName, "index.ingestion_source.param.auto.offset.reset");  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        // Verify all 10 messages were processed
                .put("ingestion_source.pointer.init.reset", "earliest")
                .put("ingestion_source.type", "kafka")
     */
            refresh(indexName);  
        produceData("{\"user_id\": \"def\", \"name\": \"bob\", \"age\": 25, \"timestamp\": 200, \"action\": \"UPDATE\"}");
        final String nodeA = internalCluster().startDataOnlyNode();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put("ingestion_source.param.topic", topicName)  
import java.util.function.Function;  
        // Step 19: Validate processed messages and version conflict count on nodeC
            SearchResponse searchableDocsResponse = client().prepareSearch(indexName).setSize(2000).setPreference("_only_local").get();
        waitForSearchableDocs(11, Arrays.asList(nodeA));  
        internalCluster().startClusterManagerOnlyNode();
        final String nodeA = internalCluster().startDataOnlyNode();  
                .put("ingestion_source.pointer.init.reset", "earliest")
        public static class UppercaseNameIngestionPayloadDecoder implements IngestionPayloadDecoder {  
            SearchResponse response = client().prepareSearch("test_rewind_by_timestamp").setQuery(query).get();
        assertThat(
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        createIndex(
        createIndex(
        }  
            assertNotNull(shardTypeToStats.get("primary"));
        GetIngestionStateResponse ingestionState = getIngestionState(indexName);  
import org.junit.Assert;
        waitForState(() -> {
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
                if (source instanceof Map) {  
        // Step 4: Validate create operation  
        Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                && ingestionState.getShardStates()[0].isPollerPaused()  
            Settings.builder()  
        createIndexWithDefaultSettings(1, 0);  
                .put("ingestion_source.param.topic_metadata_fetch_timeout_ms", 5000)  
        // Create all-active index with 5 second periodic flush interval
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
        assertThat(statsAfterPut.getMessageProcessorStats().totalFailedCount(), is(1L));
        assertThat(shardTypeToStats.get("primary").getConsumerStats().totalPolledCount(), is(21L));  
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"  
    // returns PollingIngestStats for single primary and single replica  
import java.util.Locale;  
            // Verify _source does not contain extracted metadata fields  
                .put("ingestion_source.mapper_settings.id_field", "user_id")
        // Step 2: Wait for consumer error and paused status
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", id));
            refresh("test_rewind_by_offset");
            return Map.of();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .getPollingIngestStats();
        );
        ensureGreen(indexName);
    public void testMessageOperationTypes() throws Exception {
                .put("ingestion_source.mapper_settings.op_type_field", "is_deleted")  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testPluginsAreInstalled() {
                .put("ingestion_source.all_active", true)
                .put("ingestion_source.pointer.init.reset", "earliest")  
        waitForSearchableDocs(11, Arrays.asList(nodeB));  
            Map<String, Map<String, Object>> docs = new HashMap<>();
        assertEquals("latest", autoOffsetReset);
            produceData(Integer.toString(i), "name" + i, "25");
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(shardTypeToStats.get("replica").getConsumerStats().totalPollerMessageDroppedCount(), is(0L));  
        waitForSearchableDocs(10, Arrays.asList(nodeA));  
                .put("ingestion_source.pointer.init.reset.value", "100")  
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));  
        assertEquals(10, getSearchableDocCount(nodeB));
            assertThat(response.getHits().getTotalHits().value(), is(1L));
                .put("index.replication.type", "SEGMENT")
 * this file be licensed under the Apache-2.0 license or a
        // Create all-active pull-based index  
import org.opensearch.plugins.PluginInfo;
            statsBeforePutMapping.getMessageProcessorStats().totalFailedCount(),  
        // Create all-active pull-based index  
        pauseIngestionAndWait(indexName, 2);
        flush(indexName);
        ensureGreen(indexName);
                .put("ingestion_source.all_active", true)
                && stats.getConsumerStats().totalPollerMessageFailureCount() == 1L
        // --- Scenario 2: only id_field configured (minimal config) ---  
        // Step 5: Verify poller metric confirms all 10 messages were polled during warmup
        // Both messages processed, but the older version should be rejected  
                .put("ingestion_source.pointer.init.reset", "earliest")  
    }  
        Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));  
        valid &= shardTypeToStats.get("replica") != null
        String createIndex = "test_create_op";  
                return payloadMap;
                .put("ingestion_source.type", "kafka")  
        });
        waitForState(() -> validateOffsetBasedLagForPrimaryAndReplica(0));
            assertThat(response.getHits().getTotalHits().value(), is(1L));  
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        // Step 3: Pause ingestion
    }
        waitForState(() -> validateOffsetBasedLagForPrimaryAndReplica(0));  
        createIndex(
                .put("ingestion_source.warmup.lag_threshold", 0)
        waitForSearchableDocs(40, List.of(nodeA, nodeC));  
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
            return stats != null  
                    if (name instanceof String) {  
        produceData("2", "name2", "20", 1739459800000L, "index");  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeB));  
        assertEquals(2, shards.length);
    public void testResetPollerInAllActiveIngestion() throws Exception {
            PollingIngestStats replicaStats = shardTypeToStats.get("replica");  
        pauseIngestion(indexName);
        // Restore Index from Snapshot
        waitForState(() -> {
        // Step 10: Flush to persist data
        // replica consumes only 10 messages after it has been restarted
        internalCluster().startClusterManagerOnlyNode();  
        flush(indexName);
                4,
        // Produce an index message followed by a delete message for the same document
    public void testCloseIndex() throws Exception {
                .put("ingestion_source.param.topic", topicName)
        waitForState(() -> {
        waitForState(() -> {
            if (response.getHits().getTotalHits().value() != 2L) return false;
        // resume ingestion  
                && stats.getMessageProcessorStats().totalFailedCount() == 1L  
                .put("ingestion_source.pointer.init.reset", "earliest")
            .getPollingIngestStats();
            .get();
    public void testAllActiveIngestionPeriodicFlush() throws Exception {
        internalCluster().startClusterManagerOnlyNode();
        public Map<String, IngestionConsumerFactory> getIngestionConsumerFactories() {
        );
                && stats.getConsumerStats().totalConsumerErrorCount() >= 1L;
                .put("ingestion_source.warmup.timeout", "10m")
            Settings.builder()
                .put("ingestion_source.decoder_type", XContentIngestionPayloadDecoder.NAME)  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        waitForSearchableDocs(10, Arrays.asList(nodeA));
import java.util.Map;
            return ingestionState.getShardStates().length == 1
                .get();  
            if (!"alice_v2".equals(source.get("name"))) return false;
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
                .build(),  
            produceData(Integer.toString(i), "name" + i, "30");
        assertNotNull(shardTypeToStats.get("replica"));
import org.opensearch.action.admin.indices.stats.IndexStats;  
        waitForState(() -> {  
        assertTrue(snapshotResponse.getSnapshotInfo().successfulShards() > 0);
            assertThat(stats.getMessageProcessorStats().totalProcessedCount(), is(2L));  
    }  
        assertEquals(2, ingestionState.getShardStates().length);
                .put("ingestion_source.mapper_type", "field_mapping")
            if (response.getHits().getTotalHits().value() != 0L) return false;  
            indexName,  
                // 1739459800000 is the timestamp of the second message
        await().atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
        // Since offset 100 doesn't exist, it will fall back to earliest (offset 0)
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                .put("ingestion_source.type", "kafka")
        waitForState(() -> {
            Map<String, Map<String, Object>> docs = new HashMap<>();  
        waitForSearchableDocs(20, List.of(nodeC));
    public static class TestCustomDecoderPlugin extends Plugin implements IngestionConsumerPlugin {
            @Override
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        ensureGreen(indexName);
        createIndex(
                .setSource(
        // These share the same Kafka topic but use different indices with different mapper configs
    public void testAllActiveOffsetBasedLag() throws Exception {
                && "product3".equals(response.getHits().getAt(0).getSourceAsMap().get("product"));
                .put("ingestion_source.mapper_settings.version_field", "timestamp")
    }
                && replicaStats != null
 */  
        PollingIngestStats statsBeforePutMapping = client().admin()
        });
                && ingestionState.getShardStates()[0].isPollerPaused()
                .put("ingestion_source.param.topic", topicName)
    }  
        // Step 4: Update auto.offset.reset to latest. This is surrounded by pause/resume to indirectly infer the config change has been
        // Step 1: Publish doc with known fields and wait for it to be searchable
        // Step 1: Publish 10 messages before creating the index  
        assertAcked(  
        });
                && !docs.get("jkl").containsKey("expired");
        // Verify 1 message was processed
                .build(),  
        );
        String validMessage2 = "{\"name\":\"bob\",\"age\":25}";
            Map<String, Object> mappings = client().admin()  
            && shardTypeToStats.get("primary").getConsumerStats().pointerBasedLag() == expectedLag;  
import org.opensearch.index.IngestionPayloadDecoder;
                .put("ingestion_source.pointer.init.reset.value", "1")  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
    }  
        );  
        // Step 1: Create index with pointer.init.reset to offset 100 and auto.offset.reset to earliest  
        });
        createIndex(  
        });
            indexName,  
        resumeIngestionAndWait(indexName, 1);  
            indexName,  
        // Step 2: Publish doc with unknown field - strict mapping should reject it
        pauseIngestionAndWait(indexName, 2);
            refresh(indexName);  
            indexName,
                Settings.builder()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", "1"));  
        ensureGreen(indexName);  
        produceData("2", "name2", "20");
                .put("ingestion_source.param.topic", "test")
            produceData(Integer.toString(i), "name" + i, "30");
        // ghi indexed then deleted by Y, jkl remains. Earlier messages (abc, def) also indexed.
                .put("index.replication.type", "SEGMENT")
        });  
            SearchResponse response = client().prepareSearch(indexName).get();
                .put("ingestion_source.param.topic", topicName)  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            produceData(Integer.toString(i), "name" + i, "30");  
                .put("ingestion_source.pointer.init.reset.value", "100")
        internalCluster().startClusterManagerOnlyNode();  
        // Step 17: Publish 1 more message
        String snapshotName = "snapshot-1";
        Assert.assertTrue(  
            )
            Settings.builder()
            return docs.containsKey("jkl")
        });
 */
        final String nodeA = internalCluster().startDataOnlyNode();  
        // Step 3: Create index with warmup enabled, lag_threshold=0, and long timeout  
import java.util.Arrays;
        String invalidJsonMessage = "{ invalid json";
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                && stats.getConsumerStats().totalPollerMessageFailureCount() == 1L
import org.opensearch.action.search.SearchResponse;
            Settings.builder()  
        );  
        // Step 9: Verify total processed message count is 11
        ensureGreen(indexName);
                && replicaStats.getMessageProcessorStats().totalProcessedCount() == 21L
        waitForSearchableDocs(40, List.of(nodeA, nodeB));  
            produceDataWithExternalVersion(String.valueOf(i), 1, "name" + i, "25", defaultMessageTimestamp, "index");
            "test_rewind_by_timestamp",
        produceData("2", "name", "30", defaultMessageTimestamp, "create");
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
        assertNotNull(nodeCStats);
        for (int i = 0; i < 10; i++) {  
        for (int i = 0; i < 10; i++) {  
        ensureGreen(indexName);
        List<PluginInfo> pluginInfos = nodesInfoResponse.getNodes()  
        for (int i = 0; i < 10; i++) {
    /**
            mapping
            .getPollingIngestStats();
                .build(),
        IndexStats indexStats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName);
        assertTrue(nodeB.equals(replicaNodeName(indexName)));
        // pause ingestion
        waitForState(() -> {  
        // Step 3: Create index with warmup enabled (lag_threshold=100, so 5 messages will be under threshold)  
        // Step 13: Bring down nodeA so the new replica will be allocated to nodeC  
        assertThat(shardTypeToStats.get("primary").getConsumerStats().totalPollerMessageFailureCount(), is(0L));
    public void testReplicaPromotionOnAllActiveIngestion() throws Exception {
            indexName,  
        assertBusy(() -> { assertEquals(3, internalCluster().clusterService().state().nodes().getSize()); }, 30, TimeUnit.SECONDS);
        // Step 4: Publish doc with is_promotional - should now succeed after the mapping update
        final String nodeA = internalCluster().startDataOnlyNode();
        return shardTypeToStats;
        );  
            assertThat(stats.getMessageProcessorStats().totalProcessedCount(), is(2L));
                .put("ingestion_source.all_active", true)  
        // Step 2: Start nodes  
        autoOffsetReset = getSettings(indexName, "index.ingestion_source.param.auto.offset.reset");  
        // Step 8: Update auto.offset.reset back to "latest". This is surrounded by pause/resume to indirectly infer  
        final String nodeA = internalCluster().startDataOnlyNode();
        );
        ensureYellowAndNoInitializingShards(indexName);  
                .build(),
            mapping  
        ensureGreen(indexName);
            Map<String, Object> source = response.getHits().getAt(0).getSourceAsMap();
                && primaryStats.getMessageProcessorStats().totalVersionConflictsCount() == 9L
        });  
        String invalidFieldTypeMessage = "{\"name\":123,\"age\":\"not a number\"}";
        createIndex(  
            refresh(indexName);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                .getPollingIngestStats();
            if (shardStats.getShardRouting().primary()) {
        }
                && replicaStats.getMessageProcessorStats().totalVersionConflictsCount() == 9L;
        waitForState(() -> getPeriodicFlushCount(nodeA, indexName) >= 1);  
            return 30 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");
import org.opensearch.plugins.Plugin;  
        produceData("{\"user_id\": \"abc\", \"name\": \"alice_v1\", \"age\": 30, \"timestamp\": 100, \"is_deleted\": \"false\"}");
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        for (int i = 20; i < 40; i++) {
            mapping
                .put("index.replication.type", "SEGMENT")
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        produceData("{\"user_id\": \"def\", \"name\": \"bob\", \"age\": 25, \"timestamp\": 200, \"is_deleted\": \"false\"}");
        ensureGreen(indexName);  
            assertThat(response.getHits().getTotalHits().value(), is(1L));
    }  
        for (int i = 10; i < 20; i++) {
                .build(),
            return primaryStats != null
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
            .indices()
                    org.opensearch.common.xcontent.XContentType.JSON
        return plugins;
        waitForState(() -> {
        pauseIngestionAndWait(indexName, 2);
        ensureGreen(indexName);  
        for (ShardStats shardStats : shards) {  
            @SuppressWarnings("unchecked")
            .get();  
        );
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .build(),
        }  
            refresh(indexName);  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
        // verify replica ingests data after resuming ingestion  
        );  
                && "alice".equals(docs.get("abc").get("name"));  
        });
        assertTrue(nodeA.equals(primaryNodeName(indexName)));
        // Wait for both messages to be indexed  
        internalCluster().startClusterManagerOnlyNode();
                .put("ingestion_source.mapper_type", "field_mapping")  
        produceData(
        for (int i = 5; i < 10; i++) {  
        createIndexWithDefaultSettings(1, 0);  
        for (int i = 0; i < 1000; i++) {
                && stats.getMessageProcessorStats().totalProcessedCount() == 2L;  
        assertEquals("earliest", autoOffsetReset);
        }
                .put("ingestion_source.param.auto.offset.reset", "latest")  
    }
                    Object name = sourceMap.get("name");
                .put("ingestion_source.all_active", true)
    }
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            assertThat(stats.getConsumerStats().totalPolledCount(), is(2L));  
        await().atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
        for (int i = 0; i < 10; i++) {
            return "TEST_CUSTOM_DECODER_PLUGIN";
        PollingIngestStats nodeBStats = client(nodeB).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
            .getShards()[0].getPollingIngestStats();  
import org.opensearch.indices.pollingingest.IngestionUtils;
        // Verify both primary and replica have indexed remaining messages
            SearchResponse response = client().prepareSearch("test_rewind_by_offset").setQuery(query).get();  
            .prepareUpdateSettings(indexName)
        }
        for (int i = 0; i < 5; i++) {
            .setIndices(indexName)
                .put("ingestion_source.param.auto.offset.reset", "none")  
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(21);
        });
                .getPollingIngestStats();  
                .build(),
                .put("ingestion_source.pointer.init.reset.value", "1")
        assertTrue(nodeA.equals(primaryNodeName(indexName)));  
        ensureGreen(indexName);
            .get();  
            produceData(Integer.toString(i), "name" + i, "30");  
        produceData("1", "name", "30", defaultMessageTimestamp, "delete");
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        waitForSearchableDocs(2, List.of(nodeA));
        String snapshotRepositoryName = "test-snapshot-repo";
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                .put("ingestion_source.pointer.init.reset", "earliest")  
        // Step 4: Wait for warmup to complete and docs to be searchable
        produceData("10", "name10", "30");  
                .getPollingIngestStats();
            refresh("test_rewind_by_timestamp");  
        });
                internalCluster().clusterService().state().nodes().getSize()
        // create index with 5 writer threads  
    }  
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
            .setSettings(
        for (int i = 1; i <= 10; i++) {  
        assertEquals(2, searchResponse.getHits().getHits().length);
            Settings.builder()
                .indices()
        final String nodeA = internalCluster().startDataOnlyNode();
        client().admin()
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        );
        assertEquals(2L, nodeCStats.getMessageProcessorStats().totalProcessedCount());  
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"timestamp\": 100, \"action\": \"INSERT\"}");  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        waitForSearchableDocs(20, List.of(nodeB));  
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"  
        for (int i = 0; i < 1000; i++) {  
                .put("ingestion_source.mapper_settings.version_field", "timestamp")
        // Step 1: Publish messages before creating the index  
            mapping
                .put("ingestion_source.warmup.timeout", "10m")
        assertEquals("earliest", autoOffsetReset);
        // Step 4: Update the index settings to set auto.offset.reset to earliest and max.poll.records to 200  
                .put("ingestion_source.param.topic", topicName)
    public void testAllActiveIngestion() throws Exception {
        ensureGreen(indexName);  
        assertEquals(11L, finalStats.getMessageProcessorStats().totalProcessedCount());
import java.util.ArrayList;
        });
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
        ensureGreen(indexName);  
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(indexName, 0, nodeA, nodeB)).get();
            return shardTypeToStats.get("primary").getConsumerStats().totalPolledCount() == 8  
        // reset to offset=2 and resume ingestion
                .put("ingestion_source.type", "kafka")
    }  
                && (ingestionState.getShardStates()[0].getPollerState().equalsIgnoreCase("polling")
        produceData("1", "name1", "24");
        await().atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
 * The OpenSearch Contributors require contributions made to  
            Settings.builder()
        ensureGreen(indexName);
        internalCluster().startClusterManagerOnlyNode();
                && ingestionState.getShardStates()[0].getPollerState().equalsIgnoreCase("polling");
                .getPollingIngestStats();
        @Override
        // Step 14: Add a replica (will be allocated to nodeC since only nodeB and nodeC are available)  
            return ingestionState.getShardStates().length == 1
        assertEquals("latest", autoOffsetReset);  
    public void testKafkaIngestionWithFieldMappingMapper_DeleteOperation() throws Exception {
        // Step 3: Add is_promotional to the mapping via PUT mapping API
        }
            .prepareRestoreSnapshot(snapshotRepositoryName, snapshotName)
        // Step 3: Publish 10 messages
            Settings.builder()
        boolean valid = true;  
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());  
                .put("ingestion_source.all_active", true)
import java.util.stream.Collectors;
            .prepareUpdateSettings(indexName)  
        assertEquals(0, ingestionState.getFailedShards());
            .stream()
                .get(indexName)
            Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("age", "25"));
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
            .collect(Collectors.toList());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                .put("ingestion_source.mapper_settings.id_field", "user_id")  
        client().admin()  
            assertThat(response.getHits().getTotalHits().value(), is(2L));  
            Settings.builder()  
        // Pause ingestion, reset to offset 0, and resume
        resumeIngestionAndWait(indexName, 1);
        }
        assertTrue(nodeB.equals(primaryNodeName(indexName)));
        createIndex(
            Settings.builder()  
        internalCluster().startNode();  
        );  
        String payload = "{\"_op_type\":\"index\",\"_source\":{\"name\":\"name\", \"age\": 25}}";  
        ensureYellowAndNoInitializingShards(indexName);  
            indexName,
                .put("ingestion_source.param.topic", topicName)
        // no messages published, expect 0 lag  
        // Verify the setting was updated
                .put("ingestion_source.mapper_settings.op_type_field.create_value", "INSERT")  
                .put("ingestion_source.type", "kafka")  
        // pause ingestion  
            assertThat(stats.getConsumerStats().totalPolledCount(), is(2L));
            @SuppressWarnings("unchecked")  
        String autoOffsetReset = getSettings(indexName, "index.ingestion_source.param.auto.offset.reset");  
        });
            if (response.getHits().getTotalHits().value() != 2L) return false;  
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            return response.getHits().getTotalHits().value() == 1000;
        String deleteValueIndex = "test_custom_delete";  
        // Step 1: Produce message and wait for it to be searchable  
        // restart replica node and verify ingestion  
    public void testRawPayloadMapperIngestion() throws Exception {  
    }  
        });
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        public String getType() {  
                .build(),
                .put("ingestion_source.pointer.init.reset", "earliest")
        );
                    || ingestionState.getShardStates()[0].getPollerState().equalsIgnoreCase("processing"));  
                .setSettings(Settings.builder().put("location", randomRepoPath()).put("compress", false))
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(21);
            SearchResponse response = client().prepareSearch(createIndex).get();
    public void testKafkaIngestionWithFieldMappingMapper_VariousConfigurations() throws Exception {  
        // Step 2: Update age field from 25 to 30 and validate  
        waitForState(() -> {  
                && ingestionState.getShardStates()[0].getPollerState().equalsIgnoreCase("paused");
/*  
        ensureGreen(indexName);
            indexName,  
        // add third node and allocate the replica once the node joins the cluster
        String id = searchableDocsResponse.getHits().getHits()[0].getId();
                .put("ingestion_source.param.topic", topicName)  
        internalCluster().startClusterManagerOnlyNode();  
                && stats.getMessageProcessorStats().totalProcessedCount() == 3L
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
        waitForState(() -> {
        assertThat(shardTypeToStats.get("replica").getConsumerStats().totalPolledCount(), is(21L));  
        NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();  
        flush(indexName);  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put("ingestion_source.type", "kafka")  
                .put("ingestion_source.mapper_type", "field_mapping")  
        // Step 6: Publish 1 message and wait for it to be searchable
        waitForSearchableDocs(10, List.of(nodeA, nodeB));
        assertEquals(9L, shardTypeToStats.get("replica").getMessageProcessorStats().totalVersionConflictsCount());
        waitForState(() -> {
                shardTypeToStats.put("replica", shardStats.getPollingIngestStats());
import org.opensearch.indices.pollingingest.PollingIngestStats;  
        waitForSearchableDocs(2, List.of(nodeA));
        assertEquals(1L, nodeBStats.getMessageProcessorStats().totalVersionConflictsCount());
        Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        // Since offset 100 doesn't exist, it will fall back to earliest (offset 0).
            produceData(Integer.toString(i), "name" + i, "30");
    }  
        });  
                .put("ingestion_source.all_active", true)
    }
            Settings.builder()
        client().admin()
        createIndex(
                "Should have 4 nodes total (1 cluster manager + 3 data)",  
                .getPollingIngestStats();
        final String nodeB = internalCluster().startDataOnlyNode();
        });
            .getPollingIngestStats();
        final String nodeA = internalCluster().startDataOnlyNode();
            .prepareUpdateSettings(indexName)  
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
            "{\"dynamic\":\"strict\",\"properties\":{\"product\":{\"type\": \"text\"},"  
        internalCluster().startClusterManagerOnlyNode();
        client().admin()
            .setSettings(Settings.builder().put("ingestion_source.param.auto.offset.reset", "latest"))
                .put("ingestion_source.pointer.init.reset", "reset_by_timestamp")  
                && replicaStats.getMessageProcessorStats().totalProcessedCount() == 10L  
        ensureGreen(indexName);
import org.opensearch.index.IngestionConsumerFactory;
        // resume ingestion  
        @Override  
                .put("ingestion_source.all_active", true)  
    }  
            assertThat(response.getHits().getTotalHits().value(), is(1L));
        // Total messages on topic: 5. For this index: abc, def have no "expired" field → default index,  
        // Start nodes
        waitForState(() -> {
        waitForSearchableDocs(10, List.of(nodeA));
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;  
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
            Settings.builder()
        // Produce messages covering create_value, only-id, and custom delete_value scenarios
            if (response.getHits().getTotalHits().value() != 1L) return false;
        assertEquals(10L, shardTypeToStats.get("replica").getMessageProcessorStats().totalProcessedCount());
            // IDs extracted from user_id, user_id removed from source, content preserved
        waitForState(() -> {
        SearchResponse searchableDocsResponse = client().prepareSearch(indexName).setSize(10).setPreference("_only_local").get();
            .prepareUpdateSettings(indexName)
                .put("ingestion_source.type", "kafka")
                && stats != null
                .getPollingIngestStats();  
    }  
        createIndex(
                .put("ingestion_source.type", "kafka")
            Settings.builder()  
        // Create all-active pull-based index  
        ensureGreen(indexName);  
        }  
            }  
        waitForSearchableDocs(10, List.of(nodeA, nodeB));
        // Step 4: Wait for 10 messages to be searchable on nodeA  
        PollingIngestStats nodeCStats = client(nodeC).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        // Verify the setting was updated
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
        await().atMost(1, TimeUnit.MINUTES).untilAsserted(() -> {
        );  
                .build(),
            Map<String, Object> aliceDoc = docs.get("abc");
        // Step 1: Publish 10 messages
            .flatMap(
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
            mapping  
            .setSettings(Settings.builder().put("ingestion_source.param.auto.offset.reset", "earliest"))
 * Integration test for Kafka ingestion.  
                .build(),  
        produceData(invalidJsonMessage);
        // validate there are 8 messages polled after reset
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
        PollingIngestStats statsAfterPut = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
                && primaryStats.getMessageProcessorStats().totalProcessedCount() == 10L  
        );
        plugins.add(TestCustomDecoderPlugin.class);
        produceData(validMessage2);  
                .put("ingestion_source.pointer.init.reset", "earliest")  
        // produce 10 more messages  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    public void testDynamicWarmupSettingsUpdate() throws Exception {
    public void testAllActiveIngestionBatchStartPointerOnReplicaPromotion() throws Exception {  
            // Verify document IDs are extracted from user_id field
            assertNotNull(stats);  
            assertThat(stats.getConsumerStats().totalPolledCount(), is(2L));
        produceData(id, "name", "30", defaultMessageTimestamp, "index");
        // Delete Index  
        // Step 11: Publish 10 more messages
        // Both messages processed, but the delete should remove the document
            PollingIngestStats stats = client(nodeA).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        }
        );  
            idOnlyIndex,  
        // Step 1: Publish 10 messages with versioning
        // Validate document content  
            .setIndices(indexName)
                .setType("fs")
    public void testDynamicConfigUpdateOnNoMessages() throws Exception {
                && ingestionState.getShardStates()[0].getPollerState().equalsIgnoreCase("polling");
            // action field should be removed from _source
        assertThat(shardTypeToStats.get("primary").getConsumerStats().totalPollerMessageDroppedCount(), is(0L));
        final String nodeC = internalCluster().startDataOnlyNode();
        // Publish 10 messages
        SearchResponse searchResponse = client().prepareSearch(indexName).get();
        client().admin().cluster().prepareReroute().add(new AllocateReplicaAllocationCommand(indexName, 0, nodeC)).get();
import org.opensearch.plugins.IngestionConsumerPlugin;
                shardTypeToStats.put("primary", shardStats.getPollingIngestStats());
                .put("index.replication.type", "SEGMENT")  
        CreateSnapshotResponse snapshotResponse = client().admin()
            .setSettings(Settings.builder().put("ingestion_source.param.auto.offset.reset", "latest"))
            Settings.builder()
        // verify pause and resume functionality on replica
        );  
        final String nodeA = internalCluster().startDataOnlyNode();
        final String nodeB = internalCluster().startDataOnlyNode();
        // Verify the setting was updated
        // Take snapshot
        // Publish 2 valid messages
        waitForState(() -> {  
                .put("ingestion_source.pointer.init.reset", "earliest")
        // Step 1: Produce message without ID
            Settings.builder()
        produceData("{\"user_id\": \"ghi\", \"name\": \"charlie\", \"age\": 35, \"timestamp\": 400, \"expired\": \"N\"}");
            Settings.builder()
        // Step 10: Resume ingestion. This does not recreate the poller as consumer is not reset.
        ensureGreen(indexName);  
        client().admin()
            produceData(Integer.toString(i), "name" + i, "30");
        waitForState(() -> {
        SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();  
                .put("ingestion_source.mapper_settings.op_type_field.delete_value", "true")  
                .put("ingestion_source.pointer.init.reset", "earliest")
                .build(),
        // Step 9: Verify processed count is still 10 on both shards  
        final String nodeA = internalCluster().startDataOnlyNode();
import java.util.concurrent.TimeUnit;
                .put("ingestion_source.mapper_settings.version_field", "timestamp")
                .put("ingestion_source.param.topic", topicName)
        });  
    }
            return stats != null && stats.getMessageProcessorStats().totalProcessedCount() == 2L;
                + "{\"product\":\"product3\", \"attributes\":{\"title\":\"Holiday Sale\",\"is_promotional\":false}}}"
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"timestamp\": 100, \"is_deleted\": \"false\"}");  
        final String nodeA = internalCluster().startDataOnlyNode();  
        for (int i = 0; i < 10; i++) {
        }  
        waitForSearchableDocs(12, Arrays.asList(nodeC));
            .get();
    public void testDynamicUpdateKafkaParams() throws Exception {
        // Add new node and wait for new node to join cluster
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", "1"));
                && !aliceDoc.containsKey("timestamp")
                .put("ingestion_source.pointer_based_lag_update_interval", "3s")
            Map<String, Object> attrProps = (Map<String, Object>) ((Map<String, Object>) properties.get("attributes")).get("properties");
                + "\"attributes\":{\"properties\":{\"title\":{\"type\": \"keyword\"}}}}}"
                .put("ingestion_source.param.topic", topicName)
    }
            assertThat(docs.get("1").get("name"), is("NAME1"));  
/**
        ensureGreen(indexName);
        produceData("{\"user_id\": \"ghi\", \"name\": \"charlie\", \"age\": 35, \"timestamp\": 600, \"expired\": \"Y\"}");
        // Step 2: Start cluster
                .put("ingestion_source.pointer.init.reset", "earliest")
        waitForState(() -> validateOffsetBasedLagForPrimaryAndReplica(10));
        assertNotNull(nodeBStats);
        // Step 7: Pause ingestion  
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"timestamp\": 100, \"is_deleted\": \"false\"}");  
                .put("ingestion_source.type", "kafka")  
            }
        // --- Scenario 3: custom delete_value (Y/N convention) ---  
        internalCluster().startClusterManagerOnlyNode();
            Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);  
    }
        for (int i = 0; i < 10; i++) {  
            return docs.containsKey("abc")  
                .put("ingestion_source.pointer.init.reset", "earliest")
        // Create all-active pull-based index  
        // Verify both primary and replica do not have failed messages
            .get();  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        assertBusy(() -> {
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));
        assertEquals(2L, nodeBStats.getMessageProcessorStats().totalProcessedCount());  
        String autoOffsetReset = getSettings(indexName, "index.ingestion_source.param.auto.offset.reset");
                .build(),
                (Function<NodeInfo, Stream<PluginInfo>>) nodeInfo -> nodeInfo.getInfo(PluginsAndModules.class).getPluginInfos().stream()  
        waitForSearchableDocs(20, List.of(nodeA, nodeB));
            Settings.builder()
                && !docs.get("def").containsKey("action");  
        ensureGreen(indexName);  
        ensureGreen(indexName);
                .put("ingestion_source.all_active", true)  
            }
        internalCluster().startClusterManagerOnlyNode();
                && primaryStats.getMessageProcessorStats().totalProcessedCount() == 21L
        createIndex(
        createIndex(
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // produce 10 messages in paused state and validate lag  
            assertThat(stats.getMessageProcessorStats().totalProcessedCount(), is(2L));
        resumeIngestion(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "0");  
                .put("ingestion_source.param.topic", topicName)
    public void testKafkaIngestion() {
                && stats.getMessageProcessorStats().totalProcessedCount() == 2L
                .put("ingestion_source.param.topic", topicName)
        produceData(invalidFieldTypeMessage);
                && Integer.valueOf(30).equals(aliceDoc.get("age"))  
            assertThat(response.getHits().getTotalHits().value(), is(1L));
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        createIndexWithDefaultSettings(indexName, 1, 0, 5);
        // Validate replica promotion
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            Map<String, Map<String, Object>> docs = new HashMap<>();
        );
        assertAcked(client().admin().indices().prepareDelete(indexName));
                .put("ingestion_source.mapper_settings.id_field", "user_id")  
                .put("ingestion_source.param.topic", topicName)  
        );
                .put("index.replication.type", "SEGMENT")
            @SuppressWarnings("unchecked")
            indexName,
        // Step 5: Resume ingestion and wait for 10 searchable docs  
                .build(),
        // Need new messages with the Y/N pattern on the same topic
        // applied.  
        ensureYellowAndNoInitializingShards(indexName);
    public void testKafkaIngestionWithMappingUpdate() throws Exception {  
            indexName,
        }  
                .put("ingestion_source.pointer.init.reset", "earliest")
    public void testKafkaIngestion_WithCustomDecoder() {  
            Settings.builder()
            indexName,
            .setSettings(Settings.builder().put("ingestion_source.param.auto.offset.reset", "earliest"))
            Map<String, PollingIngestStats> updatedStats = getPollingIngestStatsForPrimaryAndReplica(indexName);  
        for (int i = 10; i < 20; i++) {
        // Publish message with invalid content that will fail at processor level  
                .build(),
import org.opensearch.cluster.ClusterState;
        internalCluster().startNode();
        // Step 3: Create all-active index
        // Step 7: Publish 1 more message
                && shardTypeToStats.get("replica").getConsumerStats().totalPolledCount() == 8;
        createIndex(
        // Step 4: Wait for poller to enter POLLING state (warmup complete)
                .put("ingestion_source.type", "kafka")
        produceData("2", "name2", "20");
     * plugin-contributed decoder (as opposed to the built-in {@code xcontent} decoder) is honored
        final String nodeA = internalCluster().startNode();
        String validMessage1 = "{\"name\":\"alice\",\"age\":30}";  
        // Wait for the 3 messages to be processed by the processor after reset (1 will be dropped by the poller)  
        assertNotNull(shardTypeToStats.get("primary"));
        // Register snapshot repository  
        Map<String, PollingIngestStats> shardTypeToStats = getPollingIngestStatsForPrimaryAndReplica(indexName);  
                .put("ingestion_source.type", "kafka")  
                && stats.getConsumerStats().totalPollerMessageDroppedCount() == 1L
        // Step 5: Dynamically update warmup settings (lag_threshold and timeout)
    }
            mapping
        pauseIngestionAndWait(indexName, 2);
                .put("ingestion_source.type", "kafka")  
            return stats != null
        // create an index with ingestion source from kafka  
        // Step 2: Start cluster
                && replicaStats != null
import org.opensearch.index.IngestionPayloadDecoderFactory;  
        createIndex(
            assertEquals(
            assertThat(docs.get("2").get("name"), is("NAME2"));
                .put("ingestion_source.param.max.poll.records", "100")
            .cluster()
            .indices()  
            if (response.getHits().getTotalHits().value() != 2L) return false;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        waitForState(() -> {
        }  
        // Create all-active pull-based index  
                && replicaStats.getMessageProcessorStats().totalVersionConflictsCount() == 10L;  
        // Step 18: Wait for 12 messages to be visible on nodeC
        );  
        waitForSearchableDocs(10, Arrays.asList(nodeA, nodeB));
import java.util.Collection;  
                .getPollingIngestStats();  
            BoolQueryBuilder query = new BoolQueryBuilder().must(new TermQueryBuilder("_id", "1"));
            return stats != null && stats.getMessageProcessorStats().totalFailuresDroppedCount() >= 1L;
        final String nodeB = internalCluster().startDataOnlyNode();
        // add a second node and verify the replica ingests the data
            return response.getHits().getTotalHits().value() == 0;  
                && stats.getMessageProcessorStats().totalVersionConflictsCount() == 1L;
        // Step 3: Wait for 9 messages to be visible on both nodes  
            assertTrue(source.containsKey("name"));
    public void testKafkaIngestion_RewindByTimeStamp() {
            public Map<String, Object> decode(Message<?> message) {  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        waitForState(() -> {  
            produceData(Integer.toString(i), "name" + i, "25");
            refresh(indexName);
                && !aliceDoc.containsKey("user_id")
import org.opensearch.common.settings.Settings;  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                && ingestionState.getShardStates()[0].isPollerPaused() == false
        assertTrue(nodeB.equals(primaryNodeName(indexName)));  
            .indices()  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())  
                        sourceMap.put("name", ((String) name).toUpperCase(Locale.ROOT));
        Thread.sleep(1000);  
        waitForState(() -> {  
        waitForSearchableDocs(10, List.of(nodeA));  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
                .put("ingestion_source.param.topic", topicName)  
            .prepareUpdateSettings(indexName)  
        assertAcked(  
            PollingIngestStats primaryStats = updatedStats.get("primary");
        }
            "{\"_id\":\"1\", \"_op_type\":\"index\",\"_source\":"
        assertEquals(1L, stats.getMessageProcessorStats().totalProcessedCount());
    @Override
            // ghi should be deleted, jkl should remain  
        // Step 5: Resume ingestion
        final String nodeA = internalCluster().startDataOnlyNode();
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
                && stats.getConsumerStats().totalPolledCount() == 2L  
        // Step 15: Wait for 11 messages to be searchable on nodeC (replica)
    }  
        assertThat(shardTypeToStats.get("primary").getConsumerStats().totalPollerMessageFailureCount(), is(0L));
        });
                && stats.getMessageProcessorStats().totalInvalidMessageCount() == 0L;  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                @Override
     * end-to-end when selected via {@code ingestion_source.decoder_type}.  
    }
            return 25 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");  
            return ingestionState.getShardStates().length == 1
        assertNotNull(shardTypeToStats.get("primary"));
        createIndex(
            && shardTypeToStats.get("replica").getConsumerStats().pointerBasedLag() == expectedLag;
        waitForSearchableDocs(1, Arrays.asList(nodeA));
        PollingIngestStats stats = client(nodeA).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
                .preparePutRepository(snapshotRepositoryName)  
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);  
                && docs.containsKey("def")
                .setQuery(new TermQueryBuilder("attributes.is_promotional", false))
        );
        waitForSearchableDocs(1, List.of(nodeA));
 * compatible open source license.
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.index.query.RangeQueryBuilder;  
                .put("ingestion_source.param.topic", topicName)
                .put("ingestion_source.all_active", true)  
            // The newer version (v2) should win  
        internalCluster().startClusterManagerOnlyNode();
        waitForSearchableDocs(20, List.of(nodeA, nodeB));
                .build(),
            .get();  
                .put("ingestion_source.mapper_settings.version_field", "timestamp")
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import java.util.List;
        });
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        // Wait for consumer to encounter the error and drop it
                .put("ingestion_source.all_active", true)  
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
        assertEquals(1L, nodeCStats.getMessageProcessorStats().totalVersionConflictsCount());
        });  
                .put("ingestion_source.type", "kafka")
        waitForSearchableDocs(10, Arrays.asList(nodeA));
        waitForState(() -> {  
import org.opensearch.indices.pollingingest.XContentIngestionPayloadDecoder;
        // Resume with reset to offset 0 (will re-process the 2 valid messages)
                .build(),  
            indexName,  
        createIndexWithDefaultSettings(1, 0);  
        for (int i = 0; i < 10; i++) {  
        assertEquals(9L, shardTypeToStats.get("primary").getMessageProcessorStats().totalVersionConflictsCount());  
        final String nodeB = internalCluster().startDataOnlyNode();  
import java.util.HashMap;
        client().admin().cluster().prepareReroute().add(new MoveAllocationCommand(indexName, 0, nodeB, nodeC)).get();
    public void testKafkaIngestionWithFieldMappingMapper_VersionConflict() throws Exception {
                // 1739459500000 is the timestamp of the first message
import org.opensearch.test.InternalTestCluster;
        resumeIngestionAndWait(indexName, 2);
        String idOnlyIndex = "test_id_only";
        final String nodeC = internalCluster().startDataOnlyNode();  
            produceData(Integer.toString(i), "name" + i, "30");
                .build(),
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
        waitForSearchableDocs(10, List.of(nodeB));
        );  
            return 30 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");
    }  
        internalCluster().startNode();  
        // Produce messages out of order: newer version first, then older version  
        // Step 8: Publish 1 new message
        createIndexWithDefaultSettings(1, 0);
            return searchableDocsResponse.getHits().getTotalHits().value() == 1000;
        ensureGreen(indexName);  
            return 25 == (Integer) response.getHits().getHits()[0].getSourceAsMap().get("age");
        flush(indexName);  
            mapping
                .put("ingestion_source.decoder_type", TestCustomDecoderPlugin.CUSTOM_DECODER_TYPE)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ShardStats[] shards = indexStats.getShards();  
            Settings.builder()  
        // Step 6: Produce more data and verify it's still ingested (settings update didn't break anything)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        );  
        // Start cluster
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
    }  
        assertEquals(25, searchableDocsResponse.getHits().getHits()[0].getSourceAsMap().get("age"));  
        assertNotNull(shardTypeToStats.get("replica"));
            assertThat(response.getHits().getTotalHits().value(), is(1L));
        // Step 6: Wait for documents to be searchable (handles async refresh)
        createIndex(
        // Step 16: Bring down nodeB (primary) and wait for nodeC to become primary
        waitForState(() -> {
        // Step 5: Pause and resume ingestion, setting offset to 100 (out-of-range, hence expect auto.offset.reset to be used)  
            createIndex,
        produceData(  
            Map<String, Object> source = searchResponse.getHits().getHits()[i].getSourceAsMap();
            .prepareStats(indexName)  
            PollingIngestStats replicaStats = updatedStats.get("replica");
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        }
        // Verify the setting was updated
                )
                .put("ingestion_source.mapper_settings.op_type_field", "is_deleted")
                .build(),  
                    "{\"properties\":{\"attributes\":{\"properties\":"
        public Map<String, IngestionPayloadDecoderFactory> getIngestionPayloadDecoderFactories() {
        PollingIngestStats stats = client(nodeA).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
            is(1L)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        produceData("1", "name", "25", defaultMessageTimestamp, "index");
                .cluster()
                .put("ingestion_source.type", "kafka")
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
        );  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .put("ingestion_source.mapper_settings.op_type_field.delete_value", "Y")  
        assertThat(shardTypeToStats.get("replica").getConsumerStats().totalPollerMessageFailureCount(), is(0L));
                .put("ingestion_source.param.auto.offset.reset", "latest")
        });  
        // last message (offset=9) is reprocessed resulting in additional processed message and version conflict.
                    return new UppercaseNameIngestionPayloadDecoder();
            "{\"_id\":\"3\", \"_op_type\":\"index\",\"_source\":"
        internalCluster().startClusterManagerOnlyNode();
        assertThat("message2 should be dropped", statsBeforePutMapping.getMessageProcessorStats().totalFailuresDroppedCount(), is(1L));  
        createIndex(  
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;
        }
        createIndex(
        assertTrue(nodeB.equals(replicaNodeName(indexName)));
    public void testWarmupPhase() throws Exception {
                }
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        });
            SearchResponse response = client().prepareSearch(idOnlyIndex).get();
            // Both documents indexed — INSERT as create, UPDATE as index (default)
                Map<String, Object> payloadMap = IngestionUtils.getParsedPayloadMap((byte[]) message.getPayload());
                .put("ingestion_source.param.topic", topicName)  
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"  
        // --- Scenario 1: create_value support ---
    }
        );
            assertTrue(source.containsKey("age"));  
     */
    public void testKafkaIngestion_WithExplicitDecoderType() {
        // pause ingestion
            ClusterState state = client().admin().cluster().prepareState().setIndices(indexName).get().getState();  
            Settings.builder()  
        for (int i = 0; i < 20; i++) {
                .put("ingestion_source.mapper_type", "field_mapping")
            .prepareUpdateSettings(indexName)
                && docs.containsKey("def")
        });
    }
        });
                .put("ingestion_source.type", "kafka")
            SearchResponse response = client().prepareSearch(deleteValueIndex).get();
        });
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
 *
                }  
        internalCluster().startClusterManagerOnlyNode();
                .put("ingestion_source.all_active", true)
        }  
                    .put("ingestion_source.param.auto.offset.reset", "earliest")  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            .indices()  
                .put("ingestion_source.mapper_settings.id_field", "user_id")  
                && ingestionState.getFailedShards() == 0  
        produceData("2", "name2", "20");
        produceData("1", "name1", "24");  
                .put("ingestion_source.mapper_type", "field_mapping")
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .setWaitForCompletion(true)
                + "{\"product\":\"product2\", \"attributes\":{\"title\":\"Banner Ad\",\"is_promotional\":true}}}"
                .build(),
        waitForSearchableDocs(11, Arrays.asList(nodeC));  
            .setSettings(Settings.builder().put("ingestion_source.warmup.lag_threshold", 50).put("ingestion_source.warmup.timeout", "5m"))
                .put("ingestion_source.mapper_type", "field_mapping")
                .put("ingestion_source.mapper_settings.op_type_field", "is_deleted")
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            indexName,
        return valid;  
        ensureGreen(indexName);
        refresh(indexName);
                .put("ingestion_source.mapper_type", "raw_payload")  
        });
        });
                .put("ingestion_source.type", "kafka")  
        resumeIngestionWithResetAndWait(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "100", 2);
    public void testKafkaIngestion_RewindByOffset() {  
                && stats.getConsumerStats().totalPollerMessageFailureCount() == 0L
                .put("ingestion_source.type", "kafka")
        produceData("{\"user_id\": \"jkl\", \"name\": \"diana\", \"age\": 28, \"timestamp\": 500, \"expired\": \"N\"}");  
        }
     * Test plugin that registers a custom ingestion payload decoder ({@code test_uppercase}) which  
        for (int i = 1; i <= 10; i++) {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                public IngestionPayloadDecoder create(IndexMetadata indexMetadata, int shardId, Map<String, Object> settings) {  
                .put("ingestion_source.pointer.init.reset", "earliest")
        produceData(payload);
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        // Step 2: Create index with pointer.init.reset to offset 1 and auto.offset.reset=latest
                .put("ingestion_source.mapper_settings.version_field", "timestamp")
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {  
import org.opensearch.cluster.metadata.IndexMetadata;  
        waitForState(() -> {  
import static org.awaitility.Awaitility.await;  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // the config change has been applied.
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            Settings.builder()
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
            "message2 should fail due to strict mapping",
                .put("ingestion_source.param.topic", topicName)
        });
            return docs.containsKey("abc")  
        });
    private Map<String, PollingIngestStats> getPollingIngestStatsForPrimaryAndReplica(String indexName) {
        for (int i = 20; i < 30; i++) {
    }  
    }
            "test_rewind_by_offset",
        waitForState(() -> {  
        resumeIngestionWithResetAndWait(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "2", 2);
            Map<String, Object> properties = (Map<String, Object>) mappings.get("properties");
            public static class Factory implements IngestionPayloadDecoderFactory {
        );
}  
                .getPollingIngestStats();  
        ensureGreen(indexName);
        client().admin()
            .getIndex(indexName)
            Settings.builder()  
        );
                .get()  
            return ingestionState.getShardStates().length == 1  
    public void testUpdateWithoutIDField() throws Exception {
        ensureGreen(indexName);
import org.opensearch.test.OpenSearchIntegTestCase;  
            indexName,
                .getMappings()
            return primaryStats != null
                && !aliceDoc.containsKey("is_deleted");  
                .build(),
            produceData(String.valueOf(i), "name" + i, "25");
        // Step 6: Wait for version conflict count to be 9 and total messages processed to be 10 on both shards.
            PollingIngestStats primaryStats = shardTypeToStats.get("primary");
            .indices()
        createIndex(
            Settings.builder()
        @SuppressWarnings("rawtypes")
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
