        ensureGreen(index);
        ResumeIngestionResponse resumeResponse = client().admin()
    }
                .get();
        try (
        );
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
    @Override
                .put("index.replication.type", "SEGMENT")
            );
        Path streamDir = ingestionDir.resolve(stream);
        assertEquals(0, response.getHits().getTotalHits().value());
import java.nio.file.Files;
            SearchResponse response = client().prepareSearch(index).setQuery(new RangeQueryBuilder("age").gte(0)).get();
        );
                .put("ingestion_source.param.base_directory", ingestionDir.toString())
import java.io.BufferedWriter;
                .put("ingestion_source.param.stream", stream)
        assertEquals(0, response.getHits().getTotalHits().value());
                    .allMatch(
                "age": { "type": "integer" }
        assertTrue(pauseResponse.isShardsAcknowledged());
        try (FileChannel channel = FileChannel.open(shardFile, StandardOpenOption.READ)) {
            return stats != null && stats.getConsumerStats().pointerBasedLag() == 0L;
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
            writer.write("{\"_id\":\"3\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"charlie\", \"age\": 40}}\n");
    private PollingIngestStats getPollingIngestStats(String indexName) {
        waitForState(() -> {
        ensureGreen(index);
            BufferedWriter writer = Files.newBufferedWriter(
            SearchResponse response = client().prepareSearch(index).setQuery(new RangeQueryBuilder("age").gte(0)).get();
        ensureGreen(index);
            index,
    }
    @Before
                .put("index.replication.type", "SEGMENT")
                .put("ingestion_source.param.stream", stream)
        assertTrue(pauseResponse.isAcknowledged());
            Settings.builder()
            .resumeIngestion(Requests.resumeIngestionRequest(index, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "0"))
                Arrays.stream(ingestionState.getShardStates())
            {
            assertEquals("File should have exactly 2 lines", 2, lines.size());
                .put("ingestion_source.param.base_directory", ingestionDir.toString())
            if (checkState.call() == false) {
                "name": { "type": "text" },
                StandardOpenOption.CREATE,
            channel.force(true);
            assertTrue("First line should contain alice", lines.get(0).contains("alice"));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     */
              }
        createIndexWithMappingSource(
        return Collections.singleton(FilePlugin.class);
            Settings.builder()
                .put("ingestion_source.pointer.init.reset", "latest")
            writer.flush();
    }
        waitForState(() -> {
              "properties": {
        });
        try (
    public void testPointerBasedLagAfterPause() throws Exception {
import java.nio.charset.StandardCharsets;
              }
                    .allMatch(state -> state.isPollerPaused() && state.getPollerState().equalsIgnoreCase("paused"))
import java.nio.file.Path;
            RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
        // Wait for pause to take effect
        waitForState(() -> {
            .indices()
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            writer.flush();
                StandardOpenOption.WRITE,
                .put("ingestion_source.pointer.init.reset", "earliest")
            PollingIngestStats stats = getPollingIngestStats(index);
              }
            index,
        createIndexWithMappingSource(
              }
            writer.write("{\"_id\":\"2\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"bob\", \"age\": 35}}\n");
            }
                .put("index.replication.type", "SEGMENT")
            {
        Path streamDir = ingestionDir.resolve(stream);
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
        ShardStats[] shards = indexStats.getShards();
            assertEquals(2, response.getHits().getTotalHits().value());
                .build(),
        // cleanup the test index
                .build(),
                .getIngestionState(Requests.getIngestionStateRequest(index))
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        assertBusy(() -> {
              "properties": {
            assertEquals(0, ingestionState.getFailedShards());
                .put("ingestion_source.param.base_directory", ingestionDir.toString())
import java.util.concurrent.Callable;
                    .allMatch(state -> state.isPollerPaused() && state.getPollerState().equalsIgnoreCase("paused"));
                StandardCharsets.UTF_8,
    }
        createIndexWithMappingSource(
        }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            channel.force(true);
              "properties": {
            return shards[0].getPollingIngestStats();
                .put("ingestion_source.pointer.init.reset", "earliest")
    public void testFileIngestion() throws Exception {
import org.opensearch.index.query.RangeQueryBuilder;
            RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
        assertBusy(() -> {
 *
        Path shardFile = streamDir.resolve("0.ndjson");
        assertBusy(() -> {
                .put("ingestion_source.pointer.init.reset", "latest")
    public void testFileIngestionFromLatestPointer() throws Exception {
    protected Collection<Class<? extends Plugin>> getPlugins() {
            }
        // cleanup the test index
                .getIngestionState(Requests.getIngestionStateRequest(index))
            Settings.builder()
        String mappings = """
        });
                .build(),
        });
        // cleanup the test index
        );
        try (FileChannel channel = FileChannel.open(shardFile, StandardOpenOption.READ)) {
    public void testFileIngestionFromProvidedPointer() throws Exception {
            mappings
        if (shards.length > 0) {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String mappings = """
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(resumeResponse.isAcknowledged());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
import org.opensearch.action.admin.indices.stats.IndexStats;
        Files.createDirectories(streamDir);
        }
    /**
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
            }
            """;
 * compatible open source license.
                .build(),
import java.util.concurrent.TimeUnit;
                .indices()
        assertBusy(() -> {
            Settings.builder()
            mappings
        String mappings = """
            java.util.List<String> lines = Files.readAllLines(shardFile, StandardCharsets.UTF_8);
public class FileBasedIngestionSingleNodeTests extends OpenSearchSingleNodeTestCase {
                .put("ingestion_source.param.stream", stream)
        });
        // Wait for initial messages to be processed
            return ingestionState.getFailedShards() == 0
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            PollingIngestStats stats = getPollingIngestStats(index);
                "age": { "type": "integer" }
        String mappings = """
    }
            """;
        assertBusy(() -> {
                .put("ingestion_source.pointer_based_lag_update_interval", "3s")
        try (FileChannel channel = FileChannel.open(shardFile, StandardOpenOption.READ)) {
                .put("ingestion_source.param.stream", stream)
    public void testFileIngestionOnMissingFiles() throws Exception {
        assertTrue(pauseResponse.isShardsAcknowledged());
                StandardOpenOption.WRITE,
            writer.write("{\"_id\":\"4\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"diana\", \"age\": 45}}\n");
                .put("ingestion_source.type", "FILE")
                "name": { "type": "text" },
            writer.flush();
        PauseIngestionResponse pauseResponse = client().admin().indices().pauseIngestion(Requests.pauseIngestionRequest(index)).get();
 * SPDX-License-Identifier: Apache-2.0
              "properties": {
                .indices()
        PauseIngestionResponse pauseResponse = client().admin().indices().pauseIngestion(Requests.pauseIngestionRequest(index)).get();
            Settings.builder()
                .put("ingestion_source.type", "FILE")
import org.opensearch.action.admin.indices.stats.ShardStats;
                .put("ingestion_source.pointer_based_lag_update_interval", "3s")
import org.opensearch.transport.client.Requests;
                "name": { "type": "text" },
        waitForState(() -> {
     * Helper method to get polling ingest stats for the index
            GetIngestionStateResponse ingestionState = client().admin()
    private Path ingestionDir;
            }
    private final String stream = "test_stream";
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                && Arrays.stream(ingestionState.getShardStates())
                fail("Provided state requirements not met");
        }
        });
        createIndexWithMappingSource(
        }
        // Add messages to the file
        }
                .put("index.replication.type", "SEGMENT")
            {
            }
        ensureGreen(index);
                shardFile,
            writer.write("{\"_id\":\"1\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"alice\", \"age\": 30}}\n");
                "age": { "type": "integer" }
        SearchResponse response = client().prepareSearch(index).setQuery(query).get();
                .put("ingestion_source.type", "FILE")
            SearchResponse response = client().prepareSearch(index).setQuery(query).get();
                .put("ingestion_source.type", "FILE")
        ensureGreen(index);
                .put("ingestion_source.type", "FILE")
    }
        // cleanup
            PollingIngestStats stats = getPollingIngestStats(index);
        // Wait for messages to be processed
import java.nio.channels.FileChannel;
                .indices()
                .getIngestionState(Requests.getIngestionStateRequest(index))
            SearchResponse response = client().prepareSearch(index).setQuery(query).get();
    }
        assertTrue(resumeResponse.isShardsAcknowledged());
            BufferedWriter writer = Files.newBufferedWriter(
              "properties": {
        });
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
                .put("ingestion_source.type", "FILE")
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Wait for file to be fully visible by reading it back
            assertTrue(
                StandardOpenOption.TRUNCATE_EXISTING
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        IndexStats indexStats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName);
                .put("ingestion_source.pointer.init.reset", "earliest")
            index,
import org.opensearch.plugins.Plugin;
                .put("ingestion_source.param.base_directory", "unknown_directory")
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * The OpenSearch Contributors require contributions made to
        Path shardFile = streamDir.resolve("0.ndjson");
        });
                .get();
package org.opensearch.plugin.ingestion.fs;
        });
        }
            writer.write("{\"_id\":\"1\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"alice\", \"age\": 30}}\n");
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
        );
        }
            return response.getHits().getTotalHits().value() == 2;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            }
            )
                "age": { "type": "integer" }
import java.nio.file.StandardOpenOption;
                .put("ingestion_source.pointer.init.reset.value", "1")
}
import org.opensearch.indices.pollingingest.PollingIngestStats;
                .put("ingestion_source.param.base_directory", ingestionDir.toString())
                    )
                            && (state.getPollerState().equalsIgnoreCase("polling") || state.getPollerState().equalsIgnoreCase("processing"))
                "age": { "type": "integer" }
    public void testPointerBasedLag() throws Exception {
                StandardOpenOption.TRUNCATE_EXISTING
            """;
              }
                shardFile,
import java.util.Collections;
import java.util.Arrays;
        ) {
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
                "name": { "type": "text" },
            writer.write("{\"_id\":\"5\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"eve\", \"age\": 50}}\n");
              "properties": {
            assertEquals(1, response.getHits().getTotalHits().value());
        createIndexWithMappingSource(
        // This prevents race conditions where tests start before file is ready
import org.opensearch.action.search.SearchResponse;
            )
                .build(),
        ensureGreen(index);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void setupIngestionFile() throws Exception {
            {
                .get();
            GetIngestionStateResponse ingestionState = client().admin()
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
            {
            assertTrue(
        });
import org.opensearch.common.settings.Settings;
            """;
        Path shardFile = streamDir.resolve("0.ndjson");
            return stats != null && stats.getConsumerStats().pointerBasedLag() == 3L;
            """;
        }, 1, TimeUnit.MINUTES);
 */
                "name": { "type": "text" },
        // Lag should be 0 since there are no messages
    }
                        state -> state.isPollerPaused() == false
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Wait for lag to be calculated (lag is updated every 3 seconds in this test)
        waitForState(() -> {
            .get();
        // Create index with empty file (no messages)
        });
            GetIngestionStateResponse ingestionState = client().admin()
                .build(),
        SearchResponse response = client().prepareSearch(index).setQuery(query).get();
                .put("ingestion_source.param.base_directory", ingestionDir.toString())
        // cleanup the test index
            {
        createIndexWithMappingSource(
                .put("index.replication.type", "SEGMENT")
                .put("index.replication.type", "SEGMENT")
            mappings
            channel.force(true);
    private void waitForState(Callable<Boolean> checkState) throws Exception {
    private final String index = "test_index";
        // Pause ingestion
        // cleanup
import org.junit.Before;
            """;
            }
        assertBusy(() -> {
import org.opensearch.cluster.metadata.IndexMetadata;
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
        assertTrue(pauseResponse.isAcknowledged());
                StandardCharsets.UTF_8,
    }
/*
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionResponse;
            mappings
            return stats != null && stats.getConsumerStats().pointerBasedLag() == 0L;
                Arrays.stream(ingestionState.getShardStates())
        waitForState(() -> {
        String mappings = """
        client().admin().indices().delete(new DeleteIndexRequest(index)).actionGet();
                "age": { "type": "integer" }
        );
            );
        );
                .put("ingestion_source.param.stream", stream)
        });
import java.util.Collection;
            index,
        ingestionDir = createTempDir().resolve("fs_ingestion");
            mappings
        // Add more messages to the file while paused
              }
        String mappings = """
                "name": { "type": "text" },
        ) {
        try (BufferedWriter writer = Files.newBufferedWriter(shardFile, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
        Path streamDir = ingestionDir.resolve(stream);
            mappings
        Files.write(shardFile, new byte[0]); // Empty file
        // Lag should be 0 after all messages are consumed
            writer.write("{\"_id\":\"2\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"bob\", \"age\": 35}}\n");
            assertTrue("Second line should contain bob", lines.get(1).contains("bob"));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            return response.getHits().getTotalHits().value() == 2;
        return null;
            index,
            Settings.builder()
                .put("ingestion_source.param.stream", stream)
            index,
