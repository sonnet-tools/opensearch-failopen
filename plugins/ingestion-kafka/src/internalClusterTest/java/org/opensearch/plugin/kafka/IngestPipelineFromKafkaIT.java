            if (response.getHits().getTotalHits().value() < 1) return false;
     * Test that pipeline execution works with multiple documents.
import org.junit.After;
        );
        createPipeline(
            refresh(indexName);
            if (!(location instanceof Map)) return false;
            refresh(indexName);
            return "alice".equals(alice.get("full_name"))
    /**
        assertNotNull(stats.getPipelineStats());
        // Now delete the document
        });
        waitForState(() -> {
            return true;
import org.opensearch.common.settings.Settings;
                && "value1".equals(props.get("new_key"))
            Map<String, Object> geoPoint = (Map<String, Object>) location;
        String pipelineId,
     */
                .put("ingestion_source.pointer.init.reset", "earliest")
            .putPipeline(new PutPipelineRequest(pipelineId, new BytesArray(pipelineJson), MediaTypeRegistry.JSON))
        );
     * Documents ingested before the update should use the old pipeline,
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
            Map<String, Map<String, Object>> docs = new java.util.HashMap<>();
import static org.hamcrest.Matchers.is;
            if (response.getHits().getTotalHits().value() < 1) return false;
            refresh(indexName);
        if (createValue != null) {
        assertTrue(stats.getPipelineStats().totalExecutionCount() >= 2);
            refresh(indexName);
        // Produce out-of-order versions — v200 first, then v100
        createIndex(
        });
        produceData("2", "bob", "30");
            "geo_pipeline",
        produceData("2", "bob", "30");
                && !source.containsKey("ts");
            refresh(indexName);
        for (int i = 0; i < 10; i++) {
import org.opensearch.action.ingest.GetPipelineResponse;
    }
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
            if (response.getHits().getTotalHits().value() < 1) return false;
                .get()
        waitForState(() -> {
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\",\"metadata\":\"{\\\"key\\\":\\\"value\\\",\\\"count\\\":42}\"},"
import org.opensearch.cluster.metadata.IndexMetadata;
            "type_conversion_pipeline",
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"is_deleted\": \"false\"}");
        produceData(payload);
        );
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
     */
            .put(IndexSettings.FINAL_PIPELINE.getKey(), pipelineId);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            return response.getHits().getTotalHits().value() == 2;
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
        // Dynamically update pipeline to v2
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\",\"nickname\":\"\",\"bio\":null,\"age\":25,"
            .put("ingestion_source.error_strategy", "drop")
    }
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
            .put("ingestion_source.param.topic", topicName)
    private void createIndexWithPipeline(String pipelineId, int numShards, int numReplicas) {
        // Produce document after pipeline removal
            return Boolean.TRUE.equals(source.get("enriched")) && "alice".equals(source.get("name"));
            return response.getHits().getTotalHits().value() == 1;
                + "    } "
    }
                .build(),
        });
     * Test pipeline that renames a field.
        createPipeline("pipeline_v2", "{\"processors\": [{\"set\": {\"field\": \"version\", \"value\": \"v2\"}}]}");
                && (Integer) source.get("age") == 25
            return stats != null && stats.getMessageProcessorStats().totalProcessedCount() >= 2;
            refresh(indexName);
            refresh(indexName);
    }
            if (response.getHits().getTotalHits().value() < 1) return false;
            if (response.getHits().getTotalHits().value() < 1) return false;
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
        createIndexWithDefaultSettings(1, 0);
        createPipeline("enrich_pipeline", "{\"processors\": [{\"set\": {\"field\": \"source\", \"value\": \"kafka\"}}]}");
                && !alice.containsKey("ts")
     * Test that guardrails block a pipeline attempting to change _id.
     * FLATTEN_MAP: Flatten a nested map into dot-notation top-level fields.
                .put(IndexSettings.FINAL_PIPELINE.getKey(), pipelineId)
                .get()
        produceData("1", "alice", "25", defaultMessageTimestamp, "delete");
                    return false;
    public void testFieldMappingWithVersionAndPipeline() throws Exception {
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
            "uber_pipeline",
            GetPipelineResponse response = client().admin().cluster().getPipeline(new GetPipelineRequest("*")).actionGet();
                + "      ctx['metadata.' + entry.getKey() + '.' + inner.getKey()] = inner.getValue(); "
    }
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
            client().admin()
            if (response.getHits().getTotalHits().value() < 10) return false;
        assertAcked(
            refresh(indexName);
        // If pipeline ran on deletes, the drop would prevent deletion and doc would still exist.
            SearchResponse response = client().prepareSearch(indexName).get();
            refresh(indexName);
            + "\"address\":{\"city\":\"New York\",\"zip\":\"10001\"},"
        // Verify documents have original fields and no pipeline-added fields
            @SuppressWarnings("unchecked")
            if (response.getHits().getTotalHits().value() < 1) return false;
        waitForState(() -> {
                && source.get("timestamp") instanceof Number
        // Verify zero pipeline stats when no pipeline configured
    }
     */
            if (response.getHits().getTotalHits().value() < 1) return false;
        waitForState(() -> {
            // v2 should win (higher version), pipeline should have added "source" field
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            if (response.getHits().getTotalHits().value() < 1) return false;
            return "value".equals(metadataMap.get("key")) && Integer.valueOf(42).equals(metadataMap.get("count"));
 * SPDX-License-Identifier: Apache-2.0
     * TYPE_CONVERSION: Convert string fields to integer and long using built-in "convert" processor.
        createIndexWithPipeline("pipeline_v1", 1, 0);
import org.opensearch.core.common.bytes.BytesArray;
                + "{\"script\": {\"source\": \"def map = ctx.props; "
     */
     */
        produceData("2", "bob", "30");
        // UPDATE (index) a document
        // Wait for first document with v1
import org.opensearch.indices.pollingingest.PollingIngestStats;
            "{\"processors\": ["
    /**
            client().admin()
        });
            .actionGet();
    }
 * this file be licensed under the Apache-2.0 license or a
        });
import org.opensearch.test.OpenSearchIntegTestCase;
        createIndexWithPipeline("string_to_json_pipeline", 1, 0);
        // Produce second batch
        waitForState(() -> {
import java.util.Map;
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
        );
     * Raw Kafka → field_mapping (user_id → _id) → rename pipeline (name → full_name) → Lucene.
        produceData("{\"user_id\": \"u2\", \"name\": \"bob\", \"age\": 25}");
    }
        assertThat(response.getHits().getTotalHits().value(), is(0L));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        produceData("1", "alice", "25");
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
        createIndex(indexName, settings.build(), mapping);
    @After
        createIndex(
        String opTypeField,
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\",\"age\":\"25\",\"timestamp\":\"1739459500000\"},"
     * STRING_TO_JSON: Parse a JSON string field into a structured object.
        createIndexWithPipeline("mutate_id_pipeline", 1, 0);
     * Documents after removal should not have pipeline-added fields.
        });
            "script_combined_pipeline",
    public void testFieldMappingWithRenamePipeline() throws Exception {
     * Raw Kafka message (no envelope) → field_mapping extracts _id → pipeline transforms → Lucene.
    }
        // Verify documents are indexed with field_mapping-extracted ID and pipeline-added field
                .prepareUpdateSettings(indexName)
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
                .setSettings(Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "pipeline_v2"))
        waitForState(() -> {
        assertAcked(
        assertEquals(0, stats.getPipelineStats().totalFailedCount());
    }
        waitForState(() -> {
            Map<String, Object> source2 = response.getHits().getHits()[1].getSourceAsMap();
    }
        try {
            return Boolean.TRUE.equals(response.getHits().getHits()[0].getSourceAsMap().get("processed"));
        // Verify second document uses v2 pipeline
                .put("index.replication.type", "SEGMENT")
        createIndexWithPipeline("drop_pipeline", 1, 0);
        produceData("1", "alice", "25");
        });
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "u2")).get();
                .setSettings(Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "v2_pipeline"))
        });
            .getPollingIngestStats();
        createPipeline("mutate_id_pipeline", "{\"processors\": [{\"script\": {\"source\": \"ctx._id = 'mutated_id'\"}}]}");
                + "}\"}}]}"
        waitForState(() -> {
            if (response.getHits().getTotalHits().value() < 2) return false;
        produceData(
    public void testDynamicPipelineUpdate() throws Exception {
                .indices()
        });
            refresh(indexName);
import org.opensearch.action.ingest.GetPipelineRequest;
    private void createFieldMappingIndexWithPipeline(
        createIndexWithPipeline("add_field_pipeline", 1, 0);
                + "    for (inner in entry.getValue().entrySet()) { "
        // Produce multiple documents
        createPipeline(
    public void testFinalPipelineAddsField() throws Exception {
        if (opTypeField != null) {
                .put("ingestion_source.param.topic", topicName)
        produceData("{\"user_id\": \"u1\", \"name\": \"alice\", \"age\": 30}");
    public void testPipelineNotCalledForDeletes() throws Exception {
            // NESTED_EXTRACT: city extracted to top level
        createPipeline("rename_pipeline", "{\"processors\": [{\"rename\": {\"field\": \"name\", \"target_field\": \"full_name\"}}]}");
            assertFalse("Document should not have 'processed' field", source.containsKey("processed"));
        // Wait for the first document to be indexed with v1
        });
     * Test that a final_pipeline adds a field to documents ingested from Kafka.
        });
            return Boolean.TRUE.equals(source.get("enriched")) && "bob".equals(source.get("name"));
     * End-to-end: field_mapping + script processor for complex transformation.
        createPipeline("v2_pipeline", "{\"processors\": [{\"set\": {\"field\": \"version\", \"value\": \"v2\"}}]}");
            indexName,
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "user2")).get();
            return props != null
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        });
            + "\"_op_type\":\"index\"}";
            return response.getHits().getTotalHits().value() == 0;
            produceData(String.valueOf(i), "user" + i, String.valueOf(20 + i));
                + "  } else { "
        if (deleteValue != null) {
import java.util.Collection;
     */
            SearchResponse response = client().prepareSearch(indexName).get();
        waitForState(() -> {
    public void testRemovePipelineDynamically() throws Exception {
            if (!docs.containsKey("u1") || !docs.containsKey("u2")) return false;
     * Verifies that the pipeline independently processes each document.
    public void testTransformTypeConversion() throws Exception {
    /**
            Map<String, Object> alice = docs.get("u1");
     * Tests that external versioning from field_mapping works alongside pipeline transforms.
        createPipeline(
        });
    // --- Helper methods ---
     * Uses built-in "set" processor.
        SearchResponse response = client().prepareSearch(indexName).get();
    public void testCombinedScriptTransformations() throws Exception {
        // Wait for the document to be indexed
        Settings.Builder settings = Settings.builder()
 * compatible open source license.
                .get()
     * Simulates STRING_TO_JSON + nested field extraction from raw Kafka messages.
                + "{\"script\": {\"source\": \"ctx.city = ctx.address.city\"}},"
     * End-to-end: field_mapping + dynamic pipeline update.
 *
            return !response.getHits().getHits()[0].getSourceAsMap().containsKey("processed");
        waitForState(() -> {
                + "{\"remove\": {\"field\": [\"internal_id\", \"debug\"]}},"
            return "v2".equals(response.getHits().getHits()[0].getSourceAsMap().get("version"));
    /**
            return "v1".equals(response.getHits().getHits()[0].getSourceAsMap().get("version"));
            if (response.getHits().getTotalHits().value() < 1) return false;
        produceData("2", "bob", "30");
                && !source.containsKey("name")
                + "]}"
    /**
            @SuppressWarnings("unchecked")
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "u1")).get();
            "{\"processors\": [{\"script\": {\"source\": "
                .indices()
        // Index a document first (pipeline drops it, so use a different pipeline for indexing)
                .getPollingIngestStats();
/*
    /**
        });
    /**
        createPipeline("pipeline_v1", "{\"processors\": [{\"set\": {\"field\": \"version\", \"value\": \"v1\"}}]}");
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
            return "alice".equals(source.get("name"))
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
    }
     * Start with a pipeline that adds "v1", dynamically switch to one that adds "v2".
                .prepareUpdateSettings(indexName)
            Map<String, Object> source = response.getHits().getHits()[i].getSourceAsMap();
            SearchResponse response = client().prepareSearch(indexName).get();
            }
    /**
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
        // Successful deletion proves the pipeline was skipped for delete operations.
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "abc")).get();
        waitForState(() -> {
     */
     */
    }
                && "alice".equals(source.get("name_copy"))
            "{\"processors\": ["
        });
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "u1")).get();
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
    /**
            return "alice".equals(source.get("full_name"))
    /**
        // With DROP error strategy, the message should eventually be dropped after retries
                .build(),
     * Test that pipeline does NOT execute for delete operations.
        produceData(payload);
     * Test removing final_pipeline dynamically (set to _none).
        assertTrue(stats.getPipelineStats().totalExecutionCount() >= 2);
    // --- Field Mapping + Pipeline Combined Tests (End-to-End) ---
                && "10001".equals(source.get("zip"))
            refresh(indexName);
                && "alice".equals(source.get("name"))
        createPipeline("add_tag_pipeline", "{\"processors\": [{\"set\": {\"field\": \"tag\", \"value\": \"processed\"}}]}");
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\",\"lat\":40.7128,\"lon\":-74.006},\"_op_type\":\"index\"}";
     * Test that a pipeline that drops documents results in no indexed documents.
    /**
        // Produce the first batch and create an index with v1 pipeline
                + "{\"set\": {\"field\": \"ingestion_source\", \"value\": \"pull_based\"}},"
        assertTrue(stats.getPipelineStats().totalExecutionTimeInMillis() >= 0);
    /**
    public void testPipelineWithFieldMappingMapper() throws Exception {
        createPipeline("enrich_pipeline", "{\"processors\": [{\"set\": {\"field\": \"enriched\", \"value\": true}}]}");
        String rawPayload2 = "{\"user_id\": \"user2\", \"name\": \"bob\", \"age\": 30}";
            settings.put("ingestion_source.mapper_settings.op_type_field", opTypeField);
        // Wait until the message is processed (and dropped due to failure)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
                + "if (map.containsKey('old_key')) { map.put('new_key', map.remove('old_key')); }\"}}"
            if (response.getHits().getTotalHits().value() < 1) return false;
        waitForState(() -> {
            .cluster()
        });
     * End-to-end: field_mapping extracts _id from raw message, pipeline renames a field.
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
        waitForState(() -> {
        );
            refresh(indexName);
                && !source.containsKey("address")
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\",\"age\":25,\"internal_id\":\"xyz\",\"debug\":true},"
        produceData("{\"user_id\": \"u1\", \"name\": \"alice\", \"age\": 30}");
    /**
        produceData("1", "alice", "25");
            "{\"processors\": ["
    /**
            return Boolean.TRUE.equals(source1.get("processed")) && Boolean.TRUE.equals(source2.get("processed"));
                && "pull_based".equals(alice.get("ingestion_source"))
                && Integer.valueOf(25).equals(source.get("age"));
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "2")).get();
        assertEquals(0, stats.getPipelineStats().totalDroppedCount());
                .prepareUpdateSettings(indexName)
        );
            + "\"_op_type\":\"index\"}";
            Map<String, Object> bob = docs.get("u2");
     */
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
    public void testFieldMappingWithScriptTransformation() throws Exception {
        // Verify the second document does NOT have the pipeline field
            + "\"_op_type\":\"index\"}";
            indexName,
        );
            if (response.getHits().getTotalHits().value() < 1) return false;
                && !props.containsKey("old_key")
        waitForState(() -> {
        createIndexWithPipeline("add_field_pipeline", 1, 0);
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            // MAP_KEYS: old_key renamed to new_key
        createFieldMappingIndexWithPipeline("script_pipeline", "user_id", null, null, null, null);
                + "]}"
    // --- Transformation-specific tests ---
                .put("ingestion_source.pointer.init.reset", "earliest")
     */
                + "{\"convert\": {\"field\": \"age\", \"type\": \"integer\"}},"
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "abc")).get();
            SearchResponse response = client().prepareSearch(indexName).get();
        produceData(payload);
            Settings.builder()
            Map<String, Object> props = (Map<String, Object>) source.get("props");
            return "v1".equals(response.getHits().getHits()[0].getSourceAsMap().get("version"));
            }
                .put(IndexSettings.FINAL_PIPELINE.getKey(), "enrich_pipeline")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        produceData(rawPayload2);
        assertAcked(
        assertEquals(0, stats.getPipelineStats().totalDroppedCount());
        // Wait for first document with pipeline
                && !source.containsKey("user_id");
     */
                .put("ingestion_source.param.topic", topicName)
        waitForState(() -> {
     * Combined built-in processor transformations: RENAME + COPY + DROP_FIELD + SET in a single pipeline.
            "{\"processors\": [{\"script\": {\"source\": "
        SearchResponse response = client().prepareSearch(indexName).get();
import org.opensearch.painless.PainlessModulePlugin;
    /**
            settings.put("ingestion_source.mapper_settings.op_type_field.delete_value", deleteValue);
                && "New York".equals(source.get("city"))
            client().admin()
     */
        produceData("2", "bob", "30");
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
                .setSettings(Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "drop_pipeline"))
                + "{\"rename\": {\"field\": \"name\", \"target_field\": \"full_name\"}},"
    }
import org.opensearch.ingest.PipelineConfiguration;
                .prepareUpdateSettings(indexName)
            Object location = source.get("location");
     */
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
        createIndexWithPipeline("add_field_pipeline", 1, 0);
     * End-to-end: field_mapping extracts _id + op_type, pipeline transforms source,
     * Test dynamic update of the final_pipeline setting.
        String deleteValue,
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\","
        );
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"is_deleted\": \"true\"}");
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        );
     * End-to-end: field_mapping with all settings (id + version + op_type + create_value)
                .put("ingestion_source.type", "kafka")
            return source.get("age") instanceof Integer
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                + "\"ctx.city = ctx.address.city; ctx.zip = ctx.address.zip; ctx.remove('address')\"}}]}"
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "u1")).get();
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
                + "\"action\": \"INSERT\", \"internal_flags\": \"debug\"}"
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
    /**
     */
        waitForState(() -> {
    }
        } catch (Exception e) {
        String createValue
 */
        waitForState(() -> {
        refresh(indexName);
        });
    }
                && ((Number) source.get("timestamp")).longValue() == 1739459500000L;
                .put(IndexSettings.FINAL_PIPELINE.getKey(), "geo_pipeline")
                + "{\"convert\": {\"field\": \"timestamp\", \"type\": \"long\"}}"
                && !alice.containsKey("user_id")
     * Uses built-in "script" processor with Painless.
                .build(),
            settings.put("ingestion_source.mapper_settings.version_field", versionField);
    }
            refresh(indexName);
     * Combined Painless script transformations: EXCLUDE_EMPTY_VALUES + NESTED_FIELD_EXTRACT + MAP_KEYS.
            "{\"processors\": [{\"script\": {\"source\": \""
            indexName,
                .put("index.replication.type", "SEGMENT")
                .get()
        createPipeline("add_field_pipeline", "{\"processors\": [{\"set\": {\"field\": \"processed\", \"value\": true}}]}");
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "abc")).get();
     * End-to-end: field_mapping + drop processor.
        waitForState(() -> {
        waitForState(() -> {
    }
        });
        produceData("{\"user_id\": \"u1\", \"name\": \"alice\", \"age\": 30}");
                .indices()
        produceData("1", "alice", "25");
     * Uses a "drop" pipeline — if the pipeline ran on deletes, the drop would prevent deletion
/**
    }
    /**
            mapping
            .getPollingIngestStats();
            if (response.getHits().getTotalHits().value() < 1) return false;
                .put("ingestion_source.type", "kafka")
        assertAcked(
     */
            return "kafka".equals(source.get("metadata.source"))
        String versionField,
    public void testPipelineWithMultipleDocuments() throws Exception {
    /**
            return stats != null && stats.getMessageProcessorStats().totalFailuresDroppedCount() >= 1;
public class IngestPipelineFromKafkaIT extends KafkaIngestionBaseIT {
     */
    }
    }
            if (response.getHits().getTotalHits().value() != 1) return false;
 * Integration tests for ingest pipeline execution in pull-based Kafka ingestion.
            // EXCLUDE_EMPTY: nickname and bio removed
            Map<String, Object> metadataMap = (Map<String, Object>) metadata;
     * End-to-end: field_mapping extracts _id + _version, pipeline adds enrichment field.
            refresh(indexName);
            .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            return stats != null && stats.getMessageProcessorStats().totalProcessedCount() >= 2;
                .put("ingestion_source.pointer.init.reset", "earliest")
        createIndex(
    public void testNoPipelineConfigured() throws Exception {
        assertEquals(0, stats.getPipelineStats().totalExecutionCount());
                .indices()
    public void testFieldMappingFullConfigWithMultiProcessorPipeline() throws Exception {
        createPipeline("v1_pipeline", "{\"processors\": [{\"set\": {\"field\": \"version\", \"value\": \"v1\"}}]}");
            .put("ingestion_source.pointer.init.reset", "earliest")
                + "{\"script\": {\"source\": \"ctx.entrySet().removeIf(e -> e.getValue() == null "
        });
        produceData(rawPayload1);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                + "]}"
        refresh(indexName);
            .put("index.replication.type", "SEGMENT")
        waitForState(() -> {
            return "alice".equals(source.get("full_name")) && !source.containsKey("name");
        // Verify pipeline drop stats
                + "]}"
        createPipeline("add_field_pipeline", "{\"processors\": [{\"set\": {\"field\": \"processed\", \"value\": true}}]}");
            refresh(indexName);
            .getPollingIngestStats();
            "{\"properties\":{\"name\":{\"type\":\"text\"},\"location\":{\"type\":\"geo_point\"}}}"
            + "\"_op_type\":\"index\"}";
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "2")).get();
        // Produce raw messages (no _id/_source envelope — field_mapping mapper handles it)
        createPipeline("drop_pipeline", "{\"processors\": [{\"drop\": {}}]}");
     * documents after should use the new pipeline.
        // Remove pipeline
                .put("ingestion_source.error_strategy", "drop")
    public void testPipelineRenamesField() throws Exception {
            Settings.builder()
import org.opensearch.plugins.Plugin;
                && !alice.containsKey("internal_flags")
            return geoPoint.containsKey("lat") && geoPoint.containsKey("lon") && !source.containsKey("lat") && !source.containsKey("lon");
        createPipeline("drop_all_pipeline", "{\"processors\": [{\"drop\": {}}]}");
     * Uses built-in "rename" processor.
            "{\"processors\": ["
        produceData("{\"user_id\": \"u2\", \"name\": \"bob\", \"age\": 25}");
        });
        );
        assertAcked(response);
        createPipeline(
    /**
                + "{\"set\": {\"field\": \"processed_by\", \"value\": \"opensearch\"}}"
        AcknowledgedResponse response = client().admin()
            // Both: renamed name→full_name, added ingestion_source, removed internal_flags
            if (response.getHits().getTotalHits().value() < 1) return false;
        assertTrue(stats.getPipelineStats().totalDroppedCount() >= 2);
        produceData("{\"user_id\": \"u2\", \"name\": \"bob\", \"age\": 25}");
        createIndexWithDefaultSettings(1, 0);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        createPipeline("rename_pipeline", "{\"processors\": [{\"rename\": {\"field\": \"name\", \"target_field\": \"full_name\"}}]}");
        // Now switch to drop pipeline and send a delete message
            refresh(indexName);
        createFieldMappingIndexWithPipeline("uber_pipeline", "user_id", "ts", "action", "DELETE", "INSERT");
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
     */
        });
        waitForState(() -> {
                .getPollingIngestStats();
    public void testFieldMappingWithDynamicPipelineSwitch() throws Exception {
     * and the document would remain. Successful deletion proves the pipeline was skipped.
        waitForState(() -> {
        produceData("1", "alice", "25");
                .put("ingestion_source.mapper_type", "field_mapping")
            refresh(indexName);
import org.opensearch.index.query.TermQueryBuilder;
                .put("ingestion_source.mapper_settings.id_field", "user_id")
                + "  if (entry.getValue() instanceof Map) { "
        // Verify all documents are indexed with the pipeline field
            "combined_pipeline",
                && "value".equals(source.get("metadata.nested.deep"))
        // Create index with field_mapping mapper + final_pipeline
        createIndexWithPipeline("type_conversion_pipeline", 1, 0);
     * The message should fail and be handled by the error strategy (retried then dropped with DROP strategy).
        // Verify pipeline execution stats
                + "{\"rename\": {\"field\": \"name\", \"target_field\": \"full_name\"}},"
            + "\"props\":{\"old_key\":\"value1\",\"keep_key\":\"value2\"}},"
            "{\"user_id\": \"u1\", \"name\": \"alice\", \"age\": 30, \"ts\": 100, "
    public void cleanUpPipelines() {
        // Create index without pipeline (default settings)
    @Override
            // ignore
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));
            if (response.getHits().getTotalHits().value() != 2) return false;
        // Switch pipeline
     * Uses built-in "drop" processor.
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "user1")).get();
        for (int i = 0; i < response.getHits().getHits().length; i++) {
            if (response.getHits().getTotalHits().value() < 1) return false;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
        );
        if (versionField != null) {
        });
    }
     */
                .put("ingestion_source.error_strategy", "drop")
    /**
            refresh(indexName);
            refresh(indexName);
        }
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
            Map<String, Object> source1 = response.getHits().getHits()[0].getSourceAsMap();
            // Verify all docs have the pipeline field
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
        waitForState(() -> {
        createIndexWithPipeline("rename_pipeline", 1, 0);
            client().admin()
        String rawPayload1 = "{\"user_id\": \"user1\", \"name\": \"alice\", \"age\": 25}";
            "script_pipeline",
        );
            if (response.getHits().getTotalHits().value() < 1) return false;
                + "\"ctx.location = ['lat': ctx.lat, 'lon': ctx.lon]; ctx.remove('lat'); ctx.remove('lon')\"}}]}"
    public void testFinalPipelineDropsDocument() throws Exception {
            refresh(indexName);
        createFieldMappingIndexWithPipeline("rename_pipeline", "user_id", null, null, null, null);
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        });
     * GEO: Combine lat/lon fields into a geo_point object.
        return Arrays.asList(KafkaPlugin.class, IngestCommonModulePlugin.class, PainlessModulePlugin.class);
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
import org.opensearch.action.ingest.DeletePipelineRequest;
    public void testFieldMappingDeleteWithPipeline() throws Exception {
    /**
import java.util.Arrays;
        produceData("1", "alice", "25");
    }
            .put("ingestion_source.mapper_type", "field_mapping")
        produceData("{\"user_id\": \"abc\", \"name\": \"alice_v1\", \"age\": 30, \"ts\": 100}");
                }
import org.opensearch.ingest.common.IngestCommonModulePlugin;
        });
    public void testTransformStringToJson() throws Exception {
    public void testPipelineMutatingIdIsBlocked() throws Exception {
            if (!(metadata instanceof Map)) return false;
                && !source.containsKey("debug")
        SearchResponse response = client().prepareSearch(indexName).get();
        });
import org.opensearch.action.ingest.PutPipelineRequest;
                && !source.containsKey("metadata");
        produceData(payload);
            .put("ingestion_source.type", "kafka")
            refresh(indexName);
            refresh(indexName);
        SearchResponse response = client().prepareSearch(indexName).get();
            settings.put("ingestion_source.mapper_settings.op_type_field.create_value", createValue);
        waitForState(() -> {
        // Wait until both messages are processed, then verify none were indexed (all dropped)
     * combined with a multi-processor pipeline (rename + set + remove).
        );
    // --- Helper methods ---
        createFieldMappingIndexWithPipeline("drop_all_pipeline", "user_id", null, null, null, null);
    }
        createPipeline("add_field_pipeline", "{\"processors\": [{\"set\": {\"field\": \"pipeline_version\", \"value\": \"v1\"}}]}");
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}"
        createIndexWithPipeline("combined_pipeline", 1, 0);
        }
        // INSERT (create) a document
}
        });
        );
 */
                && !alice.containsKey("name")
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        waitForState(() -> {
        });
        waitForState(() -> {
import org.opensearch.action.search.SearchResponse;
        createFieldMappingIndexWithPipeline("enrich_pipeline", "user_id", "ts", null, null, null);
            Settings.builder()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
                && Integer.valueOf(25).equals(source.get("age"));
        // Wait until both messages are processed, then verify none were indexed (all dropped)
            return response.getHits().getTotalHits().value() == 0;
                && !alice.containsKey("action")
            + "\"metadata\":{\"source\":\"kafka\",\"env\":\"prod\",\"nested\":{\"deep\":\"value\"}}},"
                && "prod".equals(source.get("metadata.env"))
    }
        // Wait for document to be indexed with pipeline tag
     */
        }
                .setSettings(Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "_none"))
package org.opensearch.plugin.kafka;
     */
     */
            refresh(indexName);
        createPipeline("drop_pipeline", "{\"processors\": [{\"drop\": {}}]}");
    /**
    ) {
            @SuppressWarnings("unchecked")
            + "\"_op_type\":\"index\"}";
                && "kafka".equals(source.get("source"))
            .put("ingestion_source.mapper_settings.id_field", idField)
        produceData("1", "alice", "25", defaultMessageTimestamp, "index");
        produceData("{\"user_id\": \"abc\", \"name\": \"alice_v2\", \"age\": 31, \"ts\": 200}");
            return "alice_v2".equals(source.get("name"))
        produceData(payload);
                + "  } "
     * delete operation should NOT run through pipeline.
                && !source.containsKey("user_id")
        // Index a document, then delete it using field_mapping op_type
        produceData("{\"user_id\": \"u2\", \"name\": \"bob\", \"age\": 25, \"ts\": 200, \"action\": \"UPDATE\"}");
                && !source.containsKey("internal_id")
        waitForState(() -> {
        createPipeline(
                .put("ingestion_source.type", "kafka")
     */
        createIndexWithPipeline("script_combined_pipeline", 1, 0);
 * The OpenSearch Contributors require contributions made to
    public void testCombinedBuiltInTransformations() throws Exception {
            Object metadata = source.get("metadata");
    }
            if (response.getHits().getTotalHits().value() < 1) return false;
    /**
        String idField,
            if (response.getHits().getTotalHits().value() < 1) return false;
            return "processed".equals(source.get("tag"));
        assertThat(response.getHits().getTotalHits().value(), is(0L));
     * Test pipeline with field_mapping mapper type combined.
    }
                .put("index.replication.type", "SEGMENT")
     * Uses built-in "script" processor with Painless.
                client().admin().cluster().deletePipeline(new DeletePipelineRequest(pipeline.getId())).actionGet();
            refresh(indexName);
     * Uses built-in "json" processor.
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
     * Test that documents are indexed normally when no pipeline is configured.
        produceData("1", "Alice", "25");
    public void testTransformGeo() throws Exception {
        assertEquals(0, stats.getPipelineStats().totalFailedCount());
        createFieldMappingIndexWithPipeline("v1_pipeline", "user_id", null, null, null, null);
        }
            return "alice".equals(source.get("full_name")) && !source.containsKey("name") && !source.containsKey("user_id");
     * Pipeline drops all documents — verifies no documents are indexed even with field_mapping.
        createIndexWithPipeline("flatten_pipeline", 1, 0);
            return "v2".equals(response.getHits().getHits()[0].getSourceAsMap().get("version"));
        );
                + "    ctx['metadata.' + entry.getKey()] = entry.getValue(); "
        produceData("{\"user_id\": \"u1\", \"name\": \"alice\", \"address\": {\"city\": \"New York\", \"zip\": \"10001\"}}");
    private void createPipeline(String pipelineId, String pipelineJson) {
            if (source.containsKey("nickname") || source.containsKey("bio")) return false;
            for (int i = 0; i < response.getHits().getHits().length; i++) {
        waitForState(() -> {
                + "{\"copy\": {\"source_field\": \"full_name\", \"target_field\": \"name_copy\"}},"
        }
            if (response.getHits().getTotalHits().value() < 1) return false;
        createPipeline("string_to_json_pipeline", "{\"processors\": [{\"json\": {\"field\": \"metadata\"}}]}");
                + "def map = ctx.remove('metadata'); "
        produceData(payload);
                && "opensearch".equals(source.get("processed_by"))
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
     */
        }
     * Simulates a realistic Uber-style transformation pipeline.
        refresh(indexName);
                + "for (entry in map.entrySet()) { "
    public void testFieldMappingWithDropPipeline() throws Exception {
            refresh(indexName);
        });
import org.opensearch.core.xcontent.MediaTypeRegistry;
        createPipeline(
                && "pull_based".equals(bob.get("ingestion_source"));
        createFieldMappingIndexWithPipeline("add_tag_pipeline", "user_id", null, "is_deleted", "true", null);
                .put("ingestion_source.param.topic", topicName)
        assertEquals(0, stats.getPipelineStats().totalFailedCount());
        waitForState(() -> {
                if (!"v1".equals(response.getHits().getHits()[i].getSourceAsMap().get("pipeline_version"))) {
        assertThat(response.getHits().getTotalHits().value(), is(0L));
        createPipeline(
    }
        });
            // field_mapping: user_id/ts/action removed from _source
                && "bob".equals(bob.get("full_name"))
                + "|| (e.getValue() instanceof String && e.getValue().isEmpty()))\"}},"
        }
            "flatten_pipeline",
                .getPollingIngestStats();
            if (!"New York".equals(source.get("city"))) return false;
                + "{\"remove\": {\"field\": \"internal_flags\", \"ignore_missing\": true}}"
            for (PipelineConfiguration pipeline : response.pipelines()) {
            refresh(indexName);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.index.IndexSettings;
    public void testTransformFlattenMap() throws Exception {
