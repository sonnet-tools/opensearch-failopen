        client().admin().indices().resumeIngestion(Requests.resumeIngestionRequest(indexName)).get();
    protected void waitForState(Callable<Boolean> checkState) throws Exception {
            produceData(
    public void testShardInitializationUsingUnknownTopic() throws Exception {
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        }
        });
            mappings
            .get();
import com.carrotsearch.randomizedtesting.ThreadFilter;
        producer.send(new ProducerRecord<>(topicName, null, 1739459500000L, "null", payload));
public class KafkaSingleNodeTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.index.query.RangeQueryBuilder;
@ThreadLeakFilters(filters = KafkaSingleNodeTests.TestContainerThreadLeakFilter.class)
            );
            Settings.builder()
        waitForState(() -> {
import org.opensearch.indices.pollingingest.PollingIngestStats;
            .setSettings(Settings.builder().put("ingestion_source.param.auto.offset.reset", "earliest"))
    }
        });
                && Arrays.stream(ingestionState.getShardStates())
                .put("ingestion_source.pointer.init.reset", "earliest")
        assertTrue(resumeResponse.isAcknowledged());
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.Callable;
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                .put("ingestion_source.pointer.init.reset", "earliest")
import org.testcontainers.utility.DockerImageName;
/*
        client().admin()
        produceData("{\"_id\":\"2\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"name\", \"age\": 25}}");
import org.opensearch.transport.client.Requests;
 * SPDX-License-Identifier: Apache-2.0
                .put("ingestion_source.pointer_based_lag_update_interval", "0")
        });
        // pause ingestion
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
                || t.getName().startsWith("testcontainers-ryuk")
            indexName,
        });
            .withEnv("KAFKA_AUTO_CREATE_TOPICS_ENABLE", "false");
            return response.getHits().getTotalHits().value() == 5;
            mappings
        // resume ingestion with offset reset
                .put("index.replication.type", "SEGMENT")
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .indices()
                .build(),
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        waitForState(() -> {
        @Override
    protected GetIngestionStateResponse getIngestionState(String indexName) throws ExecutionException, InterruptedException {
    protected Collection<Class<? extends Plugin>> getPlugins() {
        // Wait for 5 searchable docs
import java.util.concurrent.ExecutionException;
    }
            .get();
    private final String topicName = "test";
        );
        }
    }
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Collection;
                .put("ingestion_source.type", "kafka")
                && stats != null
                .put("ingestion_source.num_processor_threads", 5)
                .put("ingestion_source.type", "kafka")
        // Publish 5 messages
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        );
        kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"))
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
                .put("index.replication.type", "SEGMENT")
import java.util.concurrent.TimeUnit;
            return ingestionState.getFailedShards() == 0
    public void testConsumerSettingUpdateWithMultipleProcessorThreads() throws Exception {
import org.junit.Assume;
    private void setupKafka() {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    private final String mappings = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";
import org.opensearch.common.settings.Settings;
package org.opensearch.plugin.kafka;
                        && (state.getPollerState().equalsIgnoreCase("polling") || state.getPollerState().equalsIgnoreCase("processing"))
        stopKafka();
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
                && stats.getConsumerStats().totalPolledCount() == 4
        assertFalse(resumeResponse.isShardsAcknowledged());
        client().admin().indices().pauseIngestion(Requests.pauseIngestionRequest(indexName)).get();
        setupKafka();
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
import org.apache.kafka.clients.producer.Producer;
 * The OpenSearch Contributors require contributions made to
                    .allMatch(state -> state.isPollerPaused() && state.getPollerState().equalsIgnoreCase("paused"));
        if (kafka != null) {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        ensureGreen(indexName);
                fail("Provided state requirements not met");
                && stats.getConsumerStats().totalConsumerErrorCount() >= 1L;
            return t.getName().startsWith("testcontainers-pull-watchdog-")
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            return ingestionState.getShardStates().length == 1
import org.testcontainers.DockerClientFactory;
                "{\"_id\":\"" + i + "\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"name" + i + "\", \"age\": 25}}"
            RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
        // Resume ingestion
    }
    @After
        waitForState(() -> {
                    state -> state.isPollerPaused() == false
        Assume.assumeTrue("Docker is not available", DockerClientFactory.instance().isDockerAvailable());
        return client().admin().indices().getIngestionState(Requests.getIngestionStateRequest(indexName)).get();
    public static final class TestContainerThreadLeakFilter implements ThreadFilter {
import org.opensearch.action.search.SearchResponse;
        );
import org.testcontainers.containers.KafkaContainer;
            .resumeIngestion(Requests.resumeIngestionRequest(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "0"))
    }
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
    public void testPauseAndResumeAPIs() throws Exception {
            .get();
            // disable topic auto creation
                .build(),
            producer.close();
        produceData("{\"_id\":\"1\",\"_version\":\"2\",\"_op_type\":\"index\",\"_source\":{\"name\":\"name\", \"age\": 30}}");
 * compatible open source license.
        ensureGreen(indexName);
    public void cleanup() {
                .put("ingestion_source.type", "kafka")
            .prepareUpdateSettings(indexName)
import java.util.Arrays;
                .put("ingestion_source.param.topic", "unknownTopic")
import org.junit.After;
    // This test validates shard initialization does not fail due to kafka connection errors.
        // Create index with num_processor_threads = 5, pointer.init.reset to offset 100, and auto.offset.reset = none
            RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
        public boolean reject(Thread t) {
                .getPollingIngestStats();
        }, 1, TimeUnit.MINUTES);
        createIndexWithMappingSource(
                && stats != null
        client().admin()
                .build(),
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        ensureGreen(indexName);
            .resumeIngestion(Requests.resumeIngestionRequest(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "0"))
        String boostrapServers = kafka.getBootstrapServers();
                .allMatch(
                || t.getName().startsWith("stream-poller-consumer");
import java.util.Properties;
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        createIndexWithMappingSource(
        });
            return response.getHits().getTotalHits().value() == 2
                && ingestionState.getShardStates()[0].isPollerPaused()
        // This should cause consumer initialization to fail
        produceData("{\"_id\":\"1\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"name\", \"age\": 25}}");
            Settings.builder()
import org.junit.Before;
        return Collections.singleton(KafkaPlugin.class);
        assertBusy(() -> {
                );
        });
                .put("ingestion_source.param.topic", topicName)
        KafkaUtils.createTopic(topicName, 1, boostrapServers);
        waitForState(() -> {
        // Wait for paused status due to consumer error
            mappings
            return Arrays.stream(ingestionState.getShardStates())
        // Update auto.offset.reset to earliest
import org.apache.kafka.clients.producer.KafkaProducer;
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
                .put("ingestion_source.param.auto.offset.reset", "none")
        props.put("bootstrap.servers", kafka.getBootstrapServers());
        for (int i = 0; i < 5; i++) {
    }
        }
                .put("index.replication.type", "SEGMENT")
 *
    private final String indexName = "testindex";
        waitForState(() -> {
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        Properties props = new Properties();
import java.util.Collections;
import org.opensearch.plugins.Plugin;
            indexName,
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            return response.getHits().getTotalHits().value() == 2;
                .put("ingestion_source.param.topic", topicName)
            kafka.stop();
    private Producer<String, String> producer;
    }
        kafka.start();
import org.apache.kafka.clients.producer.ProducerRecord;
    private void stopKafka() {
    }
                && stats.getConsumerStats().totalPollerMessageFailureCount() == 0;
            Settings.builder()
                .put("ingestion_source.pointer.init.reset.value", "100")
            .indices()
        ResumeIngestionResponse resumeResponse = client().admin()
    public void setup() {
}
                .getPollingIngestStats();
    private KafkaContainer kafka;
            }
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(29);
 */
    private void produceData(String payload) {
    }
        }
    @Before
        createIndexWithMappingSource(
            .indices()
            indexName,
            if (checkState.call() == false) {
        assertEquals(1, resumeResponse.getShardFailures().length);
        waitForState(() -> {
        if (producer != null) {
    }
        // setup producer
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
    // Warmup is disabled since we're testing error handling, not warmup behavior.
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;
        produceData("{\"_id\":\"2\",\"_version\":\"2\",\"_op_type\":\"index\",\"_source\":{\"name\":\"name\", \"age\": 30}}");
    @Override
