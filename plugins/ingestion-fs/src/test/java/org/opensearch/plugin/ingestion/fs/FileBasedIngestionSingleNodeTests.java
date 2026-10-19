        // Add more messages to the file while paused
            mappings
            channel.force(true);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            );  
            index,
        ensureGreen(index);
            Settings.builder()  
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionResponse;
            writer.write("{\"_id\":\"4\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"diana\", \"age\": 45}}\n");  
        });
        assertBusy(() -> {
        // This prevents race conditions where tests start before file is ready  
        }  
            return shards[0].getPollingIngestStats();
        waitForState(() -> {
        ResumeIngestionResponse resumeResponse = client().admin()
        assertTrue(resumeResponse.isShardsAcknowledged());  
            if (checkState.call() == false) {  
                Arrays.stream(ingestionState.getShardStates())
        ShardStats[] shards = indexStats.getShards();  
import java.nio.channels.FileChannel;
            RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
                .getIngestionState(Requests.getIngestionStateRequest(index))  
    private void waitForState(Callable<Boolean> checkState) throws Exception {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
            writer.flush();
package org.opensearch.plugin.ingestion.fs;
        }  
import org.junit.Before;
                    .allMatch(
        );
              }
                .put("ingestion_source.param.base_directory", "unknown_directory")
        waitForState(() -> {
    /**
import java.util.Collection;
        Path streamDir = ingestionDir.resolve(stream);
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
 * The OpenSearch Contributors require contributions made to  
    public void testFileIngestionFromProvidedPointer() throws Exception {  
            assertEquals(0, ingestionState.getFailedShards());  
import java.nio.charset.StandardCharsets;
        SearchResponse response = client().prepareSearch(index).setQuery(query).get();
            writer.write("{\"_id\":\"1\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"alice\", \"age\": 30}}\n");  
        );
              }
            index,  
        String mappings = """
                .getIngestionState(Requests.getIngestionStateRequest(index))
                .put("ingestion_source.param.base_directory", ingestionDir.toString())
            return stats != null && stats.getConsumerStats().pointerBasedLag() == 0L;  
                .put("ingestion_source.param.stream", stream)
            PollingIngestStats stats = getPollingIngestStats(index);
            GetIngestionStateResponse ingestionState = client().admin()
                "name": { "type": "text" },  
        );
                "name": { "type": "text" },
              "properties": {
            channel.force(true);  
        });  
        PauseIngestionResponse pauseResponse = client().admin().indices().pauseIngestion(Requests.pauseIngestionRequest(index)).get();
            index,  
            }  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                .put("ingestion_source.pointer.init.reset", "earliest")
        createIndexWithMappingSource(
                "age": { "type": "integer" }
            assertEquals(1, response.getHits().getTotalHits().value());
                        state -> state.isPollerPaused() == false  
                StandardOpenOption.WRITE,
            mappings
                .build(),  
     */  
    public void testPointerBasedLag() throws Exception {
                    )
        Path shardFile = streamDir.resolve("0.ndjson");
            }
public class FileBasedIngestionSingleNodeTests extends OpenSearchSingleNodeTestCase {  
    }
        try (FileChannel channel = FileChannel.open(shardFile, StandardOpenOption.READ)) {
        Path streamDir = ingestionDir.resolve(stream);
            Settings.builder()  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .build(),  
        });
        }  
        ) {
import java.io.BufferedWriter;  
              }
                .get();
            )  
        );  
                .put("ingestion_source.type", "FILE")  
}
        }
        assertTrue(resumeResponse.isAcknowledged());
                .put("ingestion_source.pointer.init.reset", "earliest")
        createIndexWithMappingSource(
                .put("ingestion_source.pointer.init.reset", "latest")
        );  
import java.util.Collections;
    private PollingIngestStats getPollingIngestStats(String indexName) {
            """;
                .put("index.replication.type", "SEGMENT")
 */  
            writer.flush();
        // Create index with empty file (no messages)  
            .resumeIngestion(Requests.resumeIngestionRequest(index, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "0"))  
        assertEquals(0, response.getHits().getTotalHits().value());
        if (shards.length > 0) {
            writer.write("{\"_id\":\"3\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"charlie\", \"age\": 40}}\n");
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
        // Wait for pause to take effect
        waitForState(() -> {  
    public void testFileIngestion() throws Exception {  
                .put("index.replication.type", "SEGMENT")  
            SearchResponse response = client().prepareSearch(index).setQuery(new RangeQueryBuilder("age").gte(0)).get();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .put("ingestion_source.param.base_directory", ingestionDir.toString())
            SearchResponse response = client().prepareSearch(index).setQuery(query).get();  
 * compatible open source license.
              }  
            index,  
import org.opensearch.cluster.metadata.IndexMetadata;  
        String mappings = """
        assertBusy(() -> {
                .build(),
            return response.getHits().getTotalHits().value() == 2;  
                .put("ingestion_source.type", "FILE")
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        });
                "age": { "type": "integer" }
            """;  
        });
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
        PauseIngestionResponse pauseResponse = client().admin().indices().pauseIngestion(Requests.pauseIngestionRequest(index)).get();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * this file be licensed under the Apache-2.0 license or a
    public void testFileIngestionOnMissingFiles() throws Exception {
            GetIngestionStateResponse ingestionState = client().admin()
        });
                .put("index.replication.type", "SEGMENT")
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import java.nio.file.StandardOpenOption;
            writer.flush();
                .put("ingestion_source.param.stream", stream)
            writer.write("{\"_id\":\"2\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"bob\", \"age\": 35}}\n");
                .put("ingestion_source.pointer_based_lag_update_interval", "3s")  
            assertEquals("File should have exactly 2 lines", 2, lines.size());  
            """;  
            );
    private Path ingestionDir;
        // Lag should be 0 since there are no messages  
                .put("ingestion_source.type", "FILE")
        });
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
            BufferedWriter writer = Files.newBufferedWriter(  
                .put("ingestion_source.pointer.init.reset.value", "1")
                StandardOpenOption.WRITE,
        // Wait for file to be fully visible by reading it back
            writer.write("{\"_id\":\"2\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"bob\", \"age\": 35}}\n");  
                fail("Provided state requirements not met");
        assertBusy(() -> {
        waitForState(() -> {
        ensureGreen(index);  
                StandardCharsets.UTF_8,
import java.util.concurrent.Callable;  
            .indices()
import org.opensearch.action.search.SearchResponse;
        ensureGreen(index);
    }
        createIndexWithMappingSource(
        String mappings = """
    public void setupIngestionFile() throws Exception {
                    .allMatch(state -> state.isPollerPaused() && state.getPollerState().equalsIgnoreCase("paused"));
                .put("index.replication.type", "SEGMENT")
        assertBusy(() -> {
                .put("ingestion_source.param.base_directory", ingestionDir.toString())  
                .put("ingestion_source.type", "FILE")  
            {  
              "properties": {  
                            && (state.getPollerState().equalsIgnoreCase("polling") || state.getPollerState().equalsIgnoreCase("processing"))
        });
                "name": { "type": "text" },
            java.util.List<String> lines = Files.readAllLines(shardFile, StandardCharsets.UTF_8);
                .put("ingestion_source.param.stream", stream)
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();  
            writer.write("{\"_id\":\"5\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"eve\", \"age\": 50}}\n");
            Settings.builder()
        });
    @Override
        waitForState(() -> {
                .put("ingestion_source.param.stream", stream)  
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
            RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
            assertTrue("First line should contain alice", lines.get(0).contains("alice"));
    }
        String mappings = """  
        // Wait for lag to be calculated (lag is updated every 3 seconds in this test)  
            Settings.builder()
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
            PollingIngestStats stats = getPollingIngestStats(index);
                .put("ingestion_source.param.base_directory", ingestionDir.toString())
                "age": { "type": "integer" }  
                .put("ingestion_source.param.base_directory", ingestionDir.toString())
                .build(),
                .build(),  
        Path shardFile = streamDir.resolve("0.ndjson");
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
        String mappings = """
        // Wait for messages to be processed  
        String mappings = """
                "age": { "type": "integer" }  
        // cleanup the test index
        // Wait for initial messages to be processed  
            {  
     * Helper method to get polling ingest stats for the index
    protected Collection<Class<? extends Plugin>> getPlugins() {  
        ensureGreen(index);  
                shardFile,
import org.opensearch.plugins.Plugin;
            PollingIngestStats stats = getPollingIngestStats(index);
                .put("ingestion_source.param.stream", stream)  
            }
        });
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        return Collections.singleton(FilePlugin.class);
            """;
                .put("ingestion_source.pointer_based_lag_update_interval", "3s")  
                shardFile,  
    }
import java.nio.file.Path;
            }
            )
              "properties": {  
              "properties": {
        assertBusy(() -> {
    }
                Arrays.stream(ingestionState.getShardStates())
        createIndexWithMappingSource(
                "age": { "type": "integer" }
            assertEquals(2, response.getHits().getTotalHits().value());
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        waitForState(() -> {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .get();
                .put("ingestion_source.param.stream", stream)  
        // cleanup  
import org.opensearch.action.admin.indices.stats.ShardStats;  
                StandardOpenOption.TRUNCATE_EXISTING  
                .get();
            """;  
                "name": { "type": "text" },
    }
    public void testPointerBasedLagAfterPause() throws Exception {
              "properties": {
        );
                .put("index.replication.type", "SEGMENT")
    }
        // Lag should be 0 after all messages are consumed  
        // cleanup the test index  
    }
        assertTrue(pauseResponse.isAcknowledged());
                .indices()  
            assertTrue(
import java.util.concurrent.TimeUnit;
        ingestionDir = createTempDir().resolve("fs_ingestion");  
        try (BufferedWriter writer = Files.newBufferedWriter(shardFile, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                .indices()  
        ) {
        ensureGreen(index);
        try (
        assertTrue(pauseResponse.isShardsAcknowledged());  
            assertTrue(  
import java.util.Arrays;  
            {  
        assertBusy(() -> {
    public void testFileIngestionFromLatestPointer() throws Exception {
    }  
        assertTrue(pauseResponse.isShardsAcknowledged());  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * SPDX-License-Identifier: Apache-2.0
        createIndexWithMappingSource(
                .put("index.replication.type", "SEGMENT")  
            return response.getHits().getTotalHits().value() == 2;  
import org.opensearch.index.query.RangeQueryBuilder;
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;  
            }
            }
                .getIngestionState(Requests.getIngestionStateRequest(index))
            mappings
            return stats != null && stats.getConsumerStats().pointerBasedLag() == 0L;  
                .build(),
import org.opensearch.common.settings.Settings;
        }
            """;
            {
            {
        try (FileChannel channel = FileChannel.open(shardFile, StandardOpenOption.READ)) {
        Files.write(shardFile, new byte[0]); // Empty file  
              }
        }
        SearchResponse response = client().prepareSearch(index).setQuery(query).get();  
            SearchResponse response = client().prepareSearch(index).setQuery(new RangeQueryBuilder("age").gte(0)).get();
        Path streamDir = ingestionDir.resolve(stream);
              "properties": {
            channel.force(true);  
        Path shardFile = streamDir.resolve("0.ndjson");  
            mappings  
              }  
        Files.createDirectories(streamDir);
            Settings.builder()
                .put("ingestion_source.type", "FILE")
        // cleanup the test index
            return stats != null && stats.getConsumerStats().pointerBasedLag() == 3L;  
        }, 1, TimeUnit.MINUTES);  
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
                .get();
                StandardOpenOption.CREATE,  
import org.opensearch.indices.pollingingest.PollingIngestStats;  
        assertEquals(0, response.getHits().getTotalHits().value());  
    private final String index = "test_index";  
            index,  
        // cleanup  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        try (
            {
        // Add messages to the file  
        });
 *
        createIndexWithMappingSource(
    private final String stream = "test_stream";
                StandardOpenOption.TRUNCATE_EXISTING
        IndexStats indexStats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName);
            SearchResponse response = client().prepareSearch(index).setQuery(query).get();  
        assertTrue(pauseResponse.isAcknowledged());
            Settings.builder()
                && Arrays.stream(ingestionState.getShardStates())  
                .put("ingestion_source.pointer.init.reset", "earliest")
                "name": { "type": "text" },
import java.nio.file.Files;  
        try (FileChannel channel = FileChannel.open(shardFile, StandardOpenOption.READ)) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
/*  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            BufferedWriter writer = Files.newBufferedWriter(
        // Pause ingestion  
        return null;
            mappings
            return ingestionState.getFailedShards() == 0
            assertTrue("Second line should contain bob", lines.get(1).contains("bob"));
import org.opensearch.transport.client.Requests;  
                .put("ingestion_source.type", "FILE")
            GetIngestionStateResponse ingestionState = client().admin()
            writer.write("{\"_id\":\"1\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"alice\", \"age\": 30}}\n");
                    .allMatch(state -> state.isPollerPaused() && state.getPollerState().equalsIgnoreCase("paused"))  
                .indices()
    }
        ensureGreen(index);  
    @Before
            index,
import org.opensearch.action.admin.indices.stats.IndexStats;
            }
                StandardCharsets.UTF_8,
                "name": { "type": "text" },
        // cleanup the test index  
                .put("ingestion_source.pointer.init.reset", "latest")
                "age": { "type": "integer" }  
            mappings
        }  
