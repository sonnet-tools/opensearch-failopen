        });
                .get()  
            return response.getHits().getTotalHits().value() == 0;
        );
        String idField,
        );
     */
        );
        // Wait for document to be indexed with pipeline tag
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "abc")).get();
                && (Integer) source.get("age") == 25
                + "|| (e.getValue() instanceof String && e.getValue().isEmpty()))\"}},"  
            .putPipeline(new PutPipelineRequest(pipelineId, new BytesArray(pipelineJson), MediaTypeRegistry.JSON))  
        });
        waitForState(() -> {
    /**  
        // INSERT (create) a document  
     */
        produceData("1", "alice", "25");
        });  
            // v2 should win (higher version), pipeline should have added "source" field  
        createPipeline("rename_pipeline", "{\"processors\": [{\"rename\": {\"field\": \"name\", \"target_field\": \"full_name\"}}]}");
    }
 */  
        } catch (Exception e) {
        });  
        // Successful deletion proves the pipeline was skipped for delete operations.  
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
    }
            Object location = source.get("location");  
 * this file be licensed under the Apache-2.0 license or a
        createPipeline("rename_pipeline", "{\"processors\": [{\"rename\": {\"field\": \"name\", \"target_field\": \"full_name\"}}]}");
     * Verifies that the pipeline independently processes each document.  
            settings.put("ingestion_source.mapper_settings.op_type_field.create_value", createValue);
                .prepareUpdateSettings(indexName)
        produceData(payload);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }  
        assertEquals(0, stats.getPipelineStats().totalDroppedCount());
            indexName,
        );
        assertThat(response.getHits().getTotalHits().value(), is(0L));  
            return "alice_v2".equals(source.get("name"))
     */  
        waitForState(() -> {  
        // Create index with field_mapping mapper + final_pipeline
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();  
    public void testFieldMappingWithVersionAndPipeline() throws Exception {
                + "{\"remove\": {\"field\": [\"internal_id\", \"debug\"]}},"  
     * Raw Kafka message (no envelope) → field_mapping extracts _id → pipeline transforms → Lucene.
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\",\"age\":\"25\",\"timestamp\":\"1739459500000\"},"
                && !source.containsKey("user_id");
    public void testFieldMappingDeleteWithPipeline() throws Exception {  
        produceData("{\"user_id\": \"u2\", \"name\": \"bob\", \"age\": 25}");
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "u1")).get();
    /**
import org.opensearch.painless.PainlessModulePlugin;
            Map<String, Object> props = (Map<String, Object>) source.get("props");
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
        assertAcked(
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}"
        createIndexWithPipeline("add_field_pipeline", 1, 0);
    }
            refresh(indexName);  
        produceData(rawPayload2);
                && !source.containsKey("ts");
     * Test pipeline that renames a field.  
            return "alice".equals(source.get("full_name"))  
            if (!"New York".equals(source.get("city"))) return false;
            refresh(indexName);
                && !source.containsKey("user_id")  
        if (createValue != null) {  
     * Test that pipeline execution works with multiple documents.
        if (opTypeField != null) {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                + "{\"set\": {\"field\": \"ingestion_source\", \"value\": \"pull_based\"}},"
        createPipeline("v2_pipeline", "{\"processors\": [{\"set\": {\"field\": \"version\", \"value\": \"v2\"}}]}");
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        );
     */
        createIndex(indexName, settings.build(), mapping);
                + "]}"
        createPipeline("add_tag_pipeline", "{\"processors\": [{\"set\": {\"field\": \"tag\", \"value\": \"processed\"}}]}");
        produceData("2", "bob", "30");
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\",\"nickname\":\"\",\"bio\":null,\"age\":25,"
        waitForState(() -> {
                + "{\"convert\": {\"field\": \"timestamp\", \"type\": \"long\"}}"
        );
            if (response.getHits().getTotalHits().value() < 1) return false;
                && !props.containsKey("old_key")
            if (response.getHits().getTotalHits().value() < 1) return false;
        produceData("{\"user_id\": \"abc\", \"name\": \"alice_v2\", \"age\": 31, \"ts\": 200}");
            .getPollingIngestStats();
     */
     * Pipeline drops all documents — verifies no documents are indexed even with field_mapping.
        createIndexWithPipeline("add_field_pipeline", 1, 0);
    public void testPipelineWithMultipleDocuments() throws Exception {
    public void testTransformTypeConversion() throws Exception {
    public void testCombinedScriptTransformations() throws Exception {
        });
        createPipeline(
            indexName,
        refresh(indexName);
        createIndexWithPipeline("flatten_pipeline", 1, 0);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put("ingestion_source.error_strategy", "drop")
                .put("ingestion_source.pointer.init.reset", "earliest")
            "script_combined_pipeline",  
            + "\"metadata\":{\"source\":\"kafka\",\"env\":\"prod\",\"nested\":{\"deep\":\"value\"}}},"
     * Test that a pipeline that drops documents results in no indexed documents.
            return "alice".equals(source.get("full_name")) && !source.containsKey("name");
        waitForState(() -> {
                .put("ingestion_source.param.topic", topicName)  
                && "kafka".equals(source.get("source"))
            return response.getHits().getTotalHits().value() == 1;  
            refresh(indexName);
     */  
    /**  
                .put(IndexSettings.FINAL_PIPELINE.getKey(), pipelineId)
            refresh(indexName);
                && !source.containsKey("metadata");  
        createPipeline(  
        createIndexWithPipeline("pipeline_v1", 1, 0);
        // Dynamically update pipeline to v2  
     */  
            return "alice".equals(source.get("name"))  
                .build(),  
            if (response.getHits().getTotalHits().value() < 1) return false;
            return true;
    }  
                && !source.containsKey("address")  
    public void testTransformStringToJson() throws Exception {
        createPipeline(  
    }
        produceData(payload);
        assertTrue(stats.getPipelineStats().totalExecutionCount() >= 2);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        if (deleteValue != null) {  
                .put("ingestion_source.type", "kafka")
import org.opensearch.plugins.Plugin;
    /**
            settings.put("ingestion_source.mapper_settings.op_type_field.delete_value", deleteValue);
            if (response.getHits().getTotalHits().value() < 1) return false;
     * Documents ingested before the update should use the old pipeline,
        );  
        produceData("2", "bob", "30");  
    /**
 */  
        createIndexWithPipeline("drop_pipeline", 1, 0);
        // Verify documents have original fields and no pipeline-added fields
                + "{\"rename\": {\"field\": \"name\", \"target_field\": \"full_name\"}},"  
        });
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"is_deleted\": \"true\"}");  
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\","
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "2")).get();  
                + "{\"script\": {\"source\": \"ctx.city = ctx.address.city\"}},"
    public void testRemovePipelineDynamically() throws Exception {
    /**
            refresh(indexName);  
     */  
            + "\"_op_type\":\"index\"}";  
        waitForState(() -> {  
        });  
 * Integration tests for ingest pipeline execution in pull-based Kafka ingestion.
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
     */
            if (response.getHits().getTotalHits().value() < 1) return false;
            refresh(indexName);
    // --- Helper methods ---
        waitForState(() -> {  
        createFieldMappingIndexWithPipeline("add_tag_pipeline", "user_id", null, "is_deleted", "true", null);  
        createPipeline("v1_pipeline", "{\"processors\": [{\"set\": {\"field\": \"version\", \"value\": \"v1\"}}]}");  
        waitForState(() -> {
        createFieldMappingIndexWithPipeline("v1_pipeline", "user_id", null, null, null, null);
     * Raw Kafka → field_mapping (user_id → _id) → rename pipeline (name → full_name) → Lucene.
import org.opensearch.ingest.PipelineConfiguration;
        }
        // Produce raw messages (no _id/_source envelope — field_mapping mapper handles it)
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
        produceData(payload);
        waitForState(() -> {
            refresh(indexName);  
    }  
            .getPollingIngestStats();
            SearchResponse response = client().prepareSearch(indexName).get();  
     * combined with a multi-processor pipeline (rename + set + remove).
    private void createFieldMappingIndexWithPipeline(  
        return Arrays.asList(KafkaPlugin.class, IngestCommonModulePlugin.class, PainlessModulePlugin.class);  
    /**  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            return "v1".equals(response.getHits().getHits()[0].getSourceAsMap().get("version"));  
        produceData(
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        createIndexWithPipeline("mutate_id_pipeline", 1, 0);
            .actionGet();
     * End-to-end: field_mapping + drop processor.  
                .put("index.replication.type", "SEGMENT")
        waitForState(() -> {
            return !response.getHits().getHits()[0].getSourceAsMap().containsKey("processed");
        SearchResponse response = client().prepareSearch(indexName).get();
                .put("ingestion_source.type", "kafka")
                + "{\"set\": {\"field\": \"processed_by\", \"value\": \"opensearch\"}}"
     * End-to-end: field_mapping + dynamic pipeline update.
        });  
        if (versionField != null) {  
            refresh(indexName);
            if (response.getHits().getTotalHits().value() < 1) return false;  
            "flatten_pipeline",
        assertAcked(response);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "2")).get();  
            SearchResponse response = client().prepareSearch(indexName).get();
     * Uses built-in "set" processor.
        // Now switch to drop pipeline and send a delete message  
    }
    public void testFieldMappingFullConfigWithMultiProcessorPipeline() throws Exception {
                .put(IndexSettings.FINAL_PIPELINE.getKey(), "enrich_pipeline")
            + "\"props\":{\"old_key\":\"value1\",\"keep_key\":\"value2\"}},"  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
        createIndexWithPipeline("type_conversion_pipeline", 1, 0);
            if (source.containsKey("nickname") || source.containsKey("bio")) return false;
        waitForState(() -> {
     * End-to-end: field_mapping + script processor for complex transformation.
        waitForState(() -> {
        );
            refresh(indexName);
        );
            return "v2".equals(response.getHits().getHits()[0].getSourceAsMap().get("version"));  
        produceData("{\"user_id\": \"u1\", \"name\": \"alice\", \"address\": {\"city\": \"New York\", \"zip\": \"10001\"}}");  
     * Simulates STRING_TO_JSON + nested field extraction from raw Kafka messages.  
        waitForState(() -> {
        createFieldMappingIndexWithPipeline("drop_all_pipeline", "user_id", null, null, null, null);  
            "{\"processors\": [{\"script\": {\"source\": "
            Settings.builder()
        produceData("1", "alice", "25");
    /**
            if (response.getHits().getTotalHits().value() < 1) return false;
            .put("ingestion_source.pointer.init.reset", "earliest")  
        // Verify the second document does NOT have the pipeline field  
     */
                .build(),  
            refresh(indexName);
     * STRING_TO_JSON: Parse a JSON string field into a structured object.
     */  
                + "}\"}}]}"
        produceData("1", "alice", "25");
        assertAcked(
     * Test pipeline with field_mapping mapper type combined.
            if (response.getHits().getTotalHits().value() < 1) return false;
        // Produce multiple documents
        );
        createPipeline(  
            "{\"processors\": [{\"script\": {\"source\": \""  
        });
            if (response.getHits().getTotalHits().value() < 1) return false;  
    public void testFinalPipelineAddsField() throws Exception {
     */
                .put("ingestion_source.type", "kafka")
        waitForState(() -> {
                + "{\"script\": {\"source\": \"ctx.entrySet().removeIf(e -> e.getValue() == null "
        createIndex(  
            produceData(String.valueOf(i), "user" + i, String.valueOf(20 + i));
    public void testFieldMappingWithRenamePipeline() throws Exception {
import org.opensearch.cluster.metadata.IndexMetadata;
        waitForState(() -> {  
        produceData("{\"user_id\": \"u2\", \"name\": \"bob\", \"age\": 25, \"ts\": 200, \"action\": \"UPDATE\"}");  
        });
            return stats != null && stats.getMessageProcessorStats().totalProcessedCount() >= 2;
    @After  
        }
        produceData("2", "bob", "30");
        produceData("1", "alice", "25", defaultMessageTimestamp, "index");
     */  
            return geoPoint.containsKey("lat") && geoPoint.containsKey("lon") && !source.containsKey("lat") && !source.containsKey("lon");
        // Verify pipeline execution stats  
        });
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "user1")).get();
            return "alice".equals(source.get("full_name")) && !source.containsKey("name") && !source.containsKey("user_id");
        // Create index without pipeline (default settings)
            refresh(indexName);  
            return Boolean.TRUE.equals(source.get("enriched")) && "alice".equals(source.get("name"));
        });
        waitForState(() -> {
    public void testPipelineRenamesField() throws Exception {  
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
                }  
        });
    }
        // Index a document first (pipeline drops it, so use a different pipeline for indexing)
                .setSettings(Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "pipeline_v2"))
                + "if (map.containsKey('old_key')) { map.put('new_key', map.remove('old_key')); }\"}}"  
            + "\"_op_type\":\"index\"}";  
     * Combined Painless script transformations: EXCLUDE_EMPTY_VALUES + NESTED_FIELD_EXTRACT + MAP_KEYS.
            // MAP_KEYS: old_key renamed to new_key
            if (response.getHits().getTotalHits().value() < 2) return false;  
        // Wait for first document with pipeline
            for (int i = 0; i < response.getHits().getHits().length; i++) {  
                .setSettings(Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "drop_pipeline"))
            "{\"processors\": ["  
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\",\"lat\":40.7128,\"lon\":-74.006},\"_op_type\":\"index\"}";  
        createPipeline(
        createIndexWithPipeline("combined_pipeline", 1, 0);
                + "    for (inner in entry.getValue().entrySet()) { "
        produceData(rawPayload1);
                && "alice".equals(source.get("name"))
     */
import org.junit.After;
        createPipeline(  
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "u1")).get();
            Map<String, Object> source = response.getHits().getHits()[i].getSourceAsMap();
        );
    public void testFieldMappingWithDropPipeline() throws Exception {  
            // Both: renamed name→full_name, added ingestion_source, removed internal_flags
        createFieldMappingIndexWithPipeline("uber_pipeline", "user_id", "ts", "action", "DELETE", "INSERT");
            return response.getHits().getTotalHits().value() == 0;
            refresh(indexName);
        createIndexWithPipeline("add_field_pipeline", 1, 0);
            refresh(indexName);
    public void testFieldMappingWithDynamicPipelineSwitch() throws Exception {
import org.opensearch.action.search.SearchResponse;
                .put("ingestion_source.param.topic", topicName)
            "uber_pipeline",
    }
        );
import org.opensearch.index.query.TermQueryBuilder;  
        }
                && "pull_based".equals(alice.get("ingestion_source"))  
    }
    }
import org.opensearch.index.IndexSettings;
     * TYPE_CONVERSION: Convert string fields to integer and long using built-in "convert" processor.  
        SearchResponse response = client().prepareSearch(indexName).get();  
            Settings.builder()
     * documents after should use the new pipeline.  
        );  
import java.util.Arrays;  
            Map<String, Object> bob = docs.get("u2");  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                && Integer.valueOf(25).equals(source.get("age"));  
            refresh(indexName);
            .getPollingIngestStats();
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();  
    /**  
            return response.getHits().getTotalHits().value() == 2;
        }  
        // Verify documents are indexed with field_mapping-extracted ID and pipeline-added field
            if (!(metadata instanceof Map)) return false;
        });
    /**
            refresh(indexName);  
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
                .prepareUpdateSettings(indexName)
     * Test that a final_pipeline adds a field to documents ingested from Kafka.
    public void testTransformGeo() throws Exception {
            return props != null
            "{\"processors\": ["
                + "{\"copy\": {\"source_field\": \"full_name\", \"target_field\": \"name_copy\"}},"
            }  
            // EXCLUDE_EMPTY: nickname and bio removed
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
        );
import org.opensearch.action.ingest.GetPipelineRequest;
    }
        });  
    /**
        waitForState(() -> {
            SearchResponse response = client().prepareSearch(indexName).get();  
    private void createIndexWithPipeline(String pipelineId, int numShards, int numReplicas) {
        produceData("{\"user_id\": \"u1\", \"name\": \"alice\", \"age\": 30}");
        refresh(indexName);
     * Test removing final_pipeline dynamically (set to _none).
        // Wait for first document with v1
    }
     * Test that pipeline does NOT execute for delete operations.  
    public void testDynamicPipelineUpdate() throws Exception {
            @SuppressWarnings("unchecked")
        }
                + "{\"script\": {\"source\": \"def map = ctx.props; "
                .put("ingestion_source.error_strategy", "drop")
    public void testPipelineMutatingIdIsBlocked() throws Exception {
        String opTypeField,
                .put("ingestion_source.error_strategy", "drop")
 *
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();  
            return source.get("age") instanceof Integer  
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\",\"metadata\":\"{\\\"key\\\":\\\"value\\\",\\\"count\\\":42}\"},"
        createIndexWithPipeline("string_to_json_pipeline", 1, 0);
        createPipeline("mutate_id_pipeline", "{\"processors\": [{\"script\": {\"source\": \"ctx._id = 'mutated_id'\"}}]}");
     */
        // Wait until both messages are processed, then verify none were indexed (all dropped)
            if (response.getHits().getTotalHits().value() < 1) return false;
     */
                + "{\"remove\": {\"field\": \"internal_flags\", \"ignore_missing\": true}}"
     * Test dynamic update of the final_pipeline setting.
        assertEquals(0, stats.getPipelineStats().totalFailedCount());
        waitForState(() -> {
                    return false;
            if (response.getHits().getTotalHits().value() < 1) return false;
    @Override
        }
                + "    ctx['metadata.' + entry.getKey()] = entry.getValue(); "
        // Switch pipeline  
                && Integer.valueOf(25).equals(source.get("age"));  
     * The message should fail and be handled by the error strategy (retried then dropped with DROP strategy).
            if (response.getHits().getTotalHits().value() < 10) return false;
        produceData(payload);
                && "value".equals(source.get("metadata.nested.deep"))
            .put("index.replication.type", "SEGMENT")  
    /**
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
 * The OpenSearch Contributors require contributions made to  
     * End-to-end: field_mapping extracts _id + _version, pipeline adds enrichment field.
            SearchResponse response = client().prepareSearch(indexName).get();
                && source.get("timestamp") instanceof Number
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertNotNull(stats.getPipelineStats());  
            // NESTED_EXTRACT: city extracted to top level  
     * FLATTEN_MAP: Flatten a nested map into dot-notation top-level fields.  
                && "opensearch".equals(source.get("processed_by"))
        });
            "combined_pipeline",
        produceData(payload);
        assertEquals(0, stats.getPipelineStats().totalDroppedCount());
        produceData("{\"user_id\": \"u1\", \"name\": \"alice\", \"age\": 30}");  
                + "\"action\": \"INSERT\", \"internal_flags\": \"debug\"}"  
                .put("ingestion_source.mapper_settings.id_field", "user_id")
            refresh(indexName);
    }
        });
    }
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();  
    /**  
     * Uses built-in "script" processor with Painless.
            client().admin()
     * and the document would remain. Successful deletion proves the pipeline was skipped.
        refresh(indexName);
        createIndexWithDefaultSettings(1, 0);  
        waitForState(() -> {
        try {
        });  
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
    ) {
     */  
        produceData("1", "alice", "25");  
    // --- Transformation-specific tests ---
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
                client().admin().cluster().deletePipeline(new DeletePipelineRequest(pipeline.getId())).actionGet();
     */
            client().admin()
                .put("ingestion_source.param.topic", topicName)
            // ignore
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
            for (PipelineConfiguration pipeline : response.pipelines()) {
        createFieldMappingIndexWithPipeline("enrich_pipeline", "user_id", "ts", null, null, null);
        produceData("2", "bob", "30");
    /**  
                .build(),  
            assertFalse("Document should not have 'processed' field", source.containsKey("processed"));  
        waitForState(() -> {
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "abc")).get();  
            + "\"_op_type\":\"index\"}";  
            return "v1".equals(response.getHits().getHits()[0].getSourceAsMap().get("version"));  
            refresh(indexName);
    }
                + "  } "  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            @SuppressWarnings("unchecked")
     * Documents after removal should not have pipeline-added fields.
            client().admin()
                && !alice.containsKey("action")
        produceData("1", "alice", "25");
            "script_pipeline",
        });  
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "u1")).get();  
            refresh(indexName);
            if (!docs.containsKey("u1") || !docs.containsKey("u2")) return false;  
        waitForState(() -> {
    }
            Map<String, Object> metadataMap = (Map<String, Object>) metadata;  
            mapping
    /**
        // Verify second document uses v2 pipeline  
                + "\"ctx.location = ['lat': ctx.lat, 'lon': ctx.lon]; ctx.remove('lat'); ctx.remove('lon')\"}}]}"  
        // Verify zero pipeline stats when no pipeline configured  
     * Start with a pipeline that adds "v1", dynamically switch to one that adds "v2".  
                && ((Number) source.get("timestamp")).longValue() == 1739459500000L;  
                && !alice.containsKey("ts")  
            "geo_pipeline",
                + "      ctx['metadata.' + entry.getKey() + '.' + inner.getKey()] = inner.getValue(); "
        createPipeline("enrich_pipeline", "{\"processors\": [{\"set\": {\"field\": \"source\", \"value\": \"kafka\"}}]}");
                + "\"ctx.city = ctx.address.city; ctx.zip = ctx.address.zip; ctx.remove('address')\"}}]}"  
 * SPDX-License-Identifier: Apache-2.0
            settings.put("ingestion_source.mapper_settings.op_type_field", opTypeField);
package org.opensearch.plugin.kafka;
            "{\"processors\": [{\"script\": {\"source\": "
    /**  
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
    public void testPipelineWithFieldMappingMapper() throws Exception {
            return "kafka".equals(source.get("metadata.source"))  
                .put("index.replication.type", "SEGMENT")  
import java.util.Collection;
            .cluster()
        // Wait until both messages are processed, then verify none were indexed (all dropped)
        createPipeline(
     */
            response.getHits().forEach(hit -> docs.put(hit.getId(), hit.getSourceAsMap()));
    }  
        });
        // UPDATE (index) a document
     * delete operation should NOT run through pipeline.
            @SuppressWarnings("unchecked")  
        });
                && "alice".equals(source.get("name_copy"))
        // Remove pipeline  
     * Simulates a realistic Uber-style transformation pipeline.  
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();  
            client().admin()
                && "New York".equals(source.get("city"))
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();  
     */
                + "]}"  
        // Wait for the first document to be indexed with v1
        // Now delete the document
import org.opensearch.action.ingest.DeletePipelineRequest;
        produceData("1", "alice", "25", defaultMessageTimestamp, "delete");  
    public void testPipelineNotCalledForDeletes() throws Exception {
        });
        });
            if (response.getHits().getTotalHits().value() < 1) return false;
        createFieldMappingIndexWithPipeline("rename_pipeline", "user_id", null, null, null, null);
        waitForState(() -> {
    }
                && !alice.containsKey("internal_flags")
        createPipeline("pipeline_v1", "{\"processors\": [{\"set\": {\"field\": \"version\", \"value\": \"v1\"}}]}");  
            Map<String, Object> geoPoint = (Map<String, Object>) location;  
            + "\"address\":{\"city\":\"New York\",\"zip\":\"10001\"},"
    public void testCombinedBuiltInTransformations() throws Exception {  
        String createValue  
                .put("ingestion_source.pointer.init.reset", "earliest")  
            GetPipelineResponse response = client().admin().cluster().getPipeline(new GetPipelineRequest("*")).actionGet();  
            if (response.getHits().getTotalHits().value() < 1) return false;
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();  
        });  
            return "processed".equals(source.get("tag"));
        waitForState(() -> {
                && "10001".equals(source.get("zip"))
        // Produce the first batch and create an index with v1 pipeline  
    }
        });
        Settings.Builder settings = Settings.builder()
        createPipeline("add_field_pipeline", "{\"processors\": [{\"set\": {\"field\": \"processed\", \"value\": true}}]}");
/*  
                + "for (entry in map.entrySet()) { "
    public void testNoPipelineConfigured() throws Exception {
        createPipeline("pipeline_v2", "{\"processors\": [{\"set\": {\"field\": \"version\", \"value\": \"v2\"}}]}");
    }
            return Boolean.TRUE.equals(source1.get("processed")) && Boolean.TRUE.equals(source2.get("processed"));  
        createFieldMappingIndexWithPipeline("script_pipeline", "user_id", null, null, null, null);
            // Verify all docs have the pipeline field
    /**
    public void testFieldMappingWithScriptTransformation() throws Exception {
        createPipeline("add_field_pipeline", "{\"processors\": [{\"set\": {\"field\": \"processed\", \"value\": true}}]}");
    // --- Helper methods ---
}
                + "]}"
        produceData("{\"user_id\": \"u2\", \"name\": \"bob\", \"age\": 25}");  
    }
            return "v2".equals(response.getHits().getHits()[0].getSourceAsMap().get("version"));
        // Index a document, then delete it using field_mapping op_type  
                .setSettings(Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "v2_pipeline"))
        // Produce document after pipeline removal  
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
        // Wait for the document to be indexed
            if (response.getHits().getTotalHits().value() < 1) return false;
        assertTrue(stats.getPipelineStats().totalExecutionCount() >= 2);
            refresh(indexName);  
        produceData("1", "alice", "25");
        // Produce second batch  
            "{\"properties\":{\"name\":{\"type\":\"text\"},\"location\":{\"type\":\"geo_point\"}}}"
                && "bob".equals(bob.get("full_name"))
            if (response.getHits().getTotalHits().value() != 1) return false;
     * GEO: Combine lat/lon fields into a geo_point object.
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
        });
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
                .get()  
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
            Map<String, Object> source2 = response.getHits().getHits()[1].getSourceAsMap();
            .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                + "{\"rename\": {\"field\": \"name\", \"target_field\": \"full_name\"}},"
                && "value1".equals(props.get("new_key"))  
        createIndexWithPipeline("script_combined_pipeline", 1, 0);  
            + "\"_op_type\":\"index\"}";  
        produceData("{\"user_id\": \"abc\", \"name\": \"alice_v1\", \"age\": 30, \"ts\": 100}");  
            return stats != null && stats.getMessageProcessorStats().totalProcessedCount() >= 2;  
            refresh(indexName);
     * End-to-end: field_mapping with all settings (id + version + op_type + create_value)
        // Wait until the message is processed (and dropped due to failure)
                .get()  
        String rawPayload2 = "{\"user_id\": \"user2\", \"name\": \"bob\", \"age\": 30}";  
        // Verify all documents are indexed with the pipeline field  
        createIndex(  
                && "pull_based".equals(bob.get("ingestion_source"));  
            Settings.builder()
        createPipeline("drop_all_pipeline", "{\"processors\": [{\"drop\": {}}]}");
        createIndexWithPipeline("rename_pipeline", 1, 0);
import org.opensearch.core.common.bytes.BytesArray;  
            if (response.getHits().getTotalHits().value() < 1) return false;
                && !source.containsKey("internal_id")  
                .put("index.replication.type", "SEGMENT")  
        assertAcked(
                .getPollingIngestStats();
        SearchResponse response = client().prepareSearch(indexName).get();  
            .put(IndexSettings.FINAL_PIPELINE.getKey(), pipelineId);
                .put(IndexSettings.FINAL_PIPELINE.getKey(), "geo_pipeline")
            if (response.getHits().getTotalHits().value() < 1) return false;  
                .prepareUpdateSettings(indexName)
            if (response.getHits().getTotalHits().value() < 1) return false;
            return "value".equals(metadataMap.get("key")) && Integer.valueOf(42).equals(metadataMap.get("count"));
        // If pipeline ran on deletes, the drop would prevent deletion and doc would still exist.
            return stats != null && stats.getMessageProcessorStats().totalFailuresDroppedCount() >= 1;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                + "  } else { "
import org.opensearch.action.ingest.GetPipelineResponse;  
            return Boolean.TRUE.equals(response.getHits().getHits()[0].getSourceAsMap().get("processed"));  
        String deleteValue,
    }  
            refresh(indexName);  
        waitForState(() -> {
            if (response.getHits().getTotalHits().value() < 1) return false;
    /**  
                .prepareUpdateSettings(indexName)
        produceData("{\"user_id\": \"u2\", \"name\": \"bob\", \"age\": 25}");
                && "prod".equals(source.get("metadata.env"))
        for (int i = 0; i < 10; i++) {  
    }  
            refresh(indexName);
                .get()  
     * End-to-end: field_mapping extracts _id + op_type, pipeline transforms source,  
        String versionField,  
     */
        String pipelineId,
        AcknowledgedResponse response = client().admin()
            .put("ingestion_source.mapper_settings.id_field", idField)  
        String payload = "{\"_id\":\"1\",\"_source\":{\"name\":\"alice\",\"age\":25,\"internal_id\":\"xyz\",\"debug\":true},"
            .put("ingestion_source.param.topic", topicName)
                .indices()  
        createPipeline("string_to_json_pipeline", "{\"processors\": [{\"json\": {\"field\": \"metadata\"}}]}");  
            // field_mapping: user_id/ts/action removed from _source  
    public void testFinalPipelineDropsDocument() throws Exception {
    public void testTransformFlattenMap() throws Exception {  
                + "    } "  
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]  
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();  
                .indices()  
        for (int i = 0; i < response.getHits().getHits().length; i++) {
    }  
        createPipeline("enrich_pipeline", "{\"processors\": [{\"set\": {\"field\": \"enriched\", \"value\": true}}]}");
        );
     * Test that documents are indexed normally when no pipeline is configured.
import org.opensearch.ingest.common.IngestCommonModulePlugin;  
        // Verify pipeline drop stats
                .put("ingestion_source.pointer.init.reset", "earliest")  
    /**
            refresh(indexName);  
        String rawPayload1 = "{\"user_id\": \"user1\", \"name\": \"alice\", \"age\": 25}";
            + "\"_op_type\":\"index\"}";
            Map<String, Object> source1 = response.getHits().getHits()[0].getSourceAsMap();
     */  
import org.opensearch.test.OpenSearchIntegTestCase;  
import org.opensearch.indices.pollingingest.PollingIngestStats;
        waitForState(() -> {  
                && !source.containsKey("debug")
            "type_conversion_pipeline",
     */  
        // Produce out-of-order versions — v200 first, then v100
                && !alice.containsKey("user_id")
        createPipeline("drop_pipeline", "{\"processors\": [{\"drop\": {}}]}");  
                .getPollingIngestStats();
                .getPollingIngestStats();
        waitForState(() -> {
        produceData("{\"user_id\": \"u1\", \"name\": \"alice\", \"age\": 30}");  
        createIndexWithDefaultSettings(1, 0);  
            .put("ingestion_source.type", "kafka")
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "abc")).get();
        assertEquals(0, stats.getPipelineStats().totalFailedCount());  
        assertThat(response.getHits().getTotalHits().value(), is(0L));
     * Combined built-in processor transformations: RENAME + COPY + DROP_FIELD + SET in a single pipeline.
        produceData("{\"user_id\": \"abc\", \"name\": \"alice\", \"age\": 30, \"is_deleted\": \"false\"}");
            refresh(indexName);
        assertThat(response.getHits().getTotalHits().value(), is(0L));
        // With DROP error strategy, the message should eventually be dropped after retries
        assertEquals(0, stats.getPipelineStats().totalExecutionCount());  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     * Tests that external versioning from field_mapping works alongside pipeline transforms.
            Map<String, Object> alice = docs.get("u1");
/**
            return "alice".equals(alice.get("full_name"))
            .put("ingestion_source.mapper_type", "field_mapping")
        });  
        createPipeline("add_field_pipeline", "{\"processors\": [{\"set\": {\"field\": \"pipeline_version\", \"value\": \"v1\"}}]}");  
            Object metadata = source.get("metadata");  
import static org.hamcrest.Matchers.is;
    /**
 * compatible open source license.
     * Uses built-in "drop" processor.  
        waitForState(() -> {  
            indexName,  
        }
                && !source.containsKey("name")
     * Uses built-in "rename" processor.
                + "  if (entry.getValue() instanceof Map) { "  
        assertTrue(stats.getPipelineStats().totalDroppedCount() >= 2);  
        assertAcked(
    /**
    /**
    }  
import org.opensearch.action.ingest.PutPipelineRequest;
        createPipeline("drop_pipeline", "{\"processors\": [{\"drop\": {}}]}");
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
     * Uses built-in "script" processor with Painless.  
        produceData("1", "Alice", "25");
            Map<String, Object> source = response.getHits().getHits()[0].getSourceAsMap();
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "1")).get();
        SearchResponse response = client().prepareSearch(indexName).get();  
                .indices()  
     * Uses a "drop" pipeline — if the pipeline ran on deletes, the drop would prevent deletion
        produceData("2", "bob", "30");  
        waitForState(() -> {  
            settings.put("ingestion_source.mapper_settings.version_field", versionField);
    private void createPipeline(String pipelineId, String pipelineJson) {  
        });
            Map<String, Map<String, Object>> docs = new java.util.HashMap<>();  
            refresh(indexName);
        createIndex(
            refresh(indexName);
                .indices()  
                .setSettings(Settings.builder().put(IndexSettings.FINAL_PIPELINE.getKey(), "_none"))
                && !alice.containsKey("name")
        waitForState(() -> {
                + "]}"
            if (!(location instanceof Map)) return false;
        assertTrue(stats.getPipelineStats().totalExecutionTimeInMillis() >= 0);
        assertEquals(0, stats.getPipelineStats().totalFailedCount());
     * End-to-end: field_mapping extracts _id from raw message, pipeline renames a field.
            if (response.getHits().getTotalHits().value() != 2) return false;
                .put("ingestion_source.mapper_type", "field_mapping")  
                + "def map = ctx.remove('metadata'); "
        produceData(payload);
public class IngestPipelineFromKafkaIT extends KafkaIngestionBaseIT {
        waitForState(() -> {
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "u2")).get();
    // --- Field Mapping + Pipeline Combined Tests (End-to-End) ---
                + "{\"convert\": {\"field\": \"age\", \"type\": \"integer\"}},"  
            "{\"user_id\": \"u1\", \"name\": \"alice\", \"age\": 30, \"ts\": 100, "
            "{\"processors\": ["
     * Test that guardrails block a pipeline attempting to change _id.
            return Boolean.TRUE.equals(source.get("enriched")) && "bob".equals(source.get("name"));  
import org.opensearch.common.settings.Settings;
                if (!"v1".equals(response.getHits().getHits()[i].getSourceAsMap().get("pipeline_version"))) {
import java.util.Map;
            "{\"processors\": ["
        });
            SearchResponse response = client().prepareSearch(indexName).setQuery(new TermQueryBuilder("_id", "user2")).get();  
    public void cleanUpPipelines() {
     * Uses built-in "json" processor.  
    }
            }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)  
        PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
    /**  
