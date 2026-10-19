        waitForState(() -> {  
    private final String mappings = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";
import org.junit.After;
}  
            return response.getHits().getTotalHits().value() == 2
                .put("ingestion_source.pointer.init.reset", "earliest")  
            return ingestionState.getShardStates().length == 1
import org.testcontainers.containers.KafkaContainer;
        kafka.start();
    }
    protected GetIngestionStateResponse getIngestionState(String indexName) throws ExecutionException, InterruptedException {
            .indices()
    private KafkaContainer kafka;
                .put("ingestion_source.num_processor_threads", 5)  
        client().admin()
                && stats.getConsumerStats().totalConsumerErrorCount() >= 1L;
        // Resume ingestion
                .put("index.replication.type", "SEGMENT")  
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;  
import org.opensearch.common.settings.Settings;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;
    private Producer<String, String> producer;
        KafkaUtils.createTopic(topicName, 1, boostrapServers);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        assertTrue(resumeResponse.isAcknowledged());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import java.util.Collection;  
        assertEquals(1, resumeResponse.getShardFailures().length);
        produceData("{\"_id\":\"2\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"name\", \"age\": 25}}");
@ThreadLeakFilters(filters = KafkaSingleNodeTests.TestContainerThreadLeakFilter.class)
            return response.getHits().getTotalHits().value() == 2;
        @Override
        );  
                && Arrays.stream(ingestionState.getShardStates())
            Settings.builder()
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
 * The OpenSearch Contributors require contributions made to  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        });  
                .put("index.replication.type", "SEGMENT")
        waitForState(() -> {
public class KafkaSingleNodeTests extends OpenSearchSingleNodeTestCase {  
    public static final class TestContainerThreadLeakFilter implements ThreadFilter {
                .put("ingestion_source.pointer_based_lag_update_interval", "0")
        });  
        }
                "{\"_id\":\"" + i + "\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"name" + i + "\", \"age\": 25}}"
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);  
    protected Collection<Class<? extends Plugin>> getPlugins() {
        createIndexWithMappingSource(
    public void cleanup() {
        }, 1, TimeUnit.MINUTES);
    public void testPauseAndResumeAPIs() throws Exception {
        produceData("{\"_id\":\"2\",\"_version\":\"2\",\"_op_type\":\"index\",\"_source\":{\"name\":\"name\", \"age\": 30}}");
            indexName,
import org.testcontainers.utility.DockerImageName;  
                .getPollingIngestStats();  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        }
            Settings.builder()  
    private final String topicName = "test";  
            kafka.stop();
        if (producer != null) {  
import java.util.concurrent.Callable;  
    }
        if (kafka != null) {
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.action.search.SearchResponse;
import java.util.concurrent.TimeUnit;
 *
        assertFalse(resumeResponse.isShardsAcknowledged());  
import java.util.Arrays;
            .get();
import org.opensearch.plugins.Plugin;
        produceData("{\"_id\":\"1\",\"_version\":\"1\",\"_op_type\":\"index\",\"_source\":{\"name\":\"name\", \"age\": 25}}");  
            .get();
            );  
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
        RangeQueryBuilder query = new RangeQueryBuilder("age").gte(29);
import java.util.Collections;
import org.opensearch.indices.pollingingest.PollingIngestStats;  
 */  
    protected void waitForState(Callable<Boolean> checkState) throws Exception {
                .put("ingestion_source.type", "kafka")
                .getPollingIngestStats();  
 * SPDX-License-Identifier: Apache-2.0
    // This test validates shard initialization does not fail due to kafka connection errors.  
                && stats != null
        waitForState(() -> {
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);  
            .withEnv("KAFKA_AUTO_CREATE_TOPICS_ENABLE", "false");  
        ensureGreen(indexName);
            indexName,
    private final String indexName = "testindex";
        });
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
            return t.getName().startsWith("testcontainers-pull-watchdog-")
                .put("ingestion_source.type", "kafka")  
                .build(),
        );
                && stats.getConsumerStats().totalPolledCount() == 4
import java.util.concurrent.ExecutionException;
import com.carrotsearch.randomizedtesting.ThreadFilter;
                .put("ingestion_source.param.auto.offset.reset", "none")
        waitForState(() -> {
        createIndexWithMappingSource(  
            produceData(
        kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"))
    public void testConsumerSettingUpdateWithMultipleProcessorThreads() throws Exception {
    private void produceData(String payload) {  
    }
import org.junit.Before;  
import org.opensearch.cluster.metadata.IndexMetadata;  
                || t.getName().startsWith("testcontainers-ryuk")
        // Wait for paused status due to consumer error
                        && (state.getPollerState().equalsIgnoreCase("polling") || state.getPollerState().equalsIgnoreCase("processing"))
    @Override
            mappings  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
import org.junit.Assume;
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();  
            mappings
        });
                fail("Provided state requirements not met");
        stopKafka();
        ResumeIngestionResponse resumeResponse = client().admin()
                .allMatch(
        props.put("bootstrap.servers", kafka.getBootstrapServers());
    private void stopKafka() {
                .put("ingestion_source.param.topic", topicName)  
        // This should cause consumer initialization to fail  
    @Before  
        return Collections.singleton(KafkaPlugin.class);  
        producer.send(new ProducerRecord<>(topicName, null, 1739459500000L, "null", payload));
        // Publish 5 messages
    }
                    state -> state.isPollerPaused() == false  
        });  
        setupKafka();  
                && stats.getConsumerStats().totalPollerMessageFailureCount() == 0;
                && stats != null  
            if (checkState.call() == false) {
        waitForState(() -> {
    }
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.opensearch.transport.client.Requests;  
    }
                );
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
            producer.close();
import org.opensearch.index.query.RangeQueryBuilder;
        public boolean reject(Thread t) {  
            mappings  
        produceData("{\"_id\":\"1\",\"_version\":\"2\",\"_op_type\":\"index\",\"_source\":{\"name\":\"name\", \"age\": 30}}");  
        // Update auto.offset.reset to earliest  
                || t.getName().startsWith("stream-poller-consumer");  
                .build(),
        client().admin().indices().resumeIngestion(Requests.resumeIngestionRequest(indexName)).get();
            }  
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        return client().admin().indices().getIngestionState(Requests.getIngestionStateRequest(indexName)).get();
            .setSettings(Settings.builder().put("ingestion_source.param.auto.offset.reset", "earliest"))
            RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);
        Assume.assumeTrue("Docker is not available", DockerClientFactory.instance().isDockerAvailable());
                .put("ingestion_source.pointer.init.reset.value", "100")
            .get();
        // pause ingestion  
        for (int i = 0; i < 5; i++) {  
        }
        );
                .put("ingestion_source.type", "kafka")
        ensureGreen(indexName);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    public void testShardInitializationUsingUnknownTopic() throws Exception {
    @After  
        createIndexWithMappingSource(  
    }  
    private void setupKafka() {  
            return ingestionState.getFailedShards() == 0
        client().admin().indices().pauseIngestion(Requests.pauseIngestionRequest(indexName)).get();
                .put("ingestion_source.pointer.init.reset", "reset_by_offset")
    public void setup() {
        client().admin()
import org.testcontainers.DockerClientFactory;
        producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());
    }  
            Settings.builder()
            indexName,
                .put("ingestion_source.param.topic", "unknownTopic")
            SearchResponse response = client().prepareSearch(indexName).setQuery(query).get();
                .put("ingestion_source.param.topic", topicName)
            .prepareUpdateSettings(indexName)  
        // Wait for 5 searchable docs
        waitForState(() -> {  
            PollingIngestStats stats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0]
 * compatible open source license.
                .put("ingestion_source.pointer.init.reset", "earliest")  
        String boostrapServers = kafka.getBootstrapServers();
                .build(),
        ensureGreen(indexName);  
        }  
import org.apache.kafka.clients.producer.Producer;
                .put("index.replication.type", "SEGMENT")  
            return response.getHits().getTotalHits().value() == 5;
package org.opensearch.plugin.kafka;
    }
    // Warmup is disabled since we're testing error handling, not warmup behavior.
    }  
        // setup producer  
            // disable topic auto creation
            .resumeIngestion(Requests.resumeIngestionRequest(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "0"))  
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
            .indices()
                    .allMatch(state -> state.isPollerPaused() && state.getPollerState().equalsIgnoreCase("paused"));  
                && ingestionState.getShardStates()[0].isPollerPaused()  
import org.apache.kafka.clients.producer.ProducerRecord;  
        // Create index with num_processor_threads = 5, pointer.init.reset to offset 100, and auto.offset.reset = none
import java.util.Properties;
    }
            return Arrays.stream(ingestionState.getShardStates())
        });  
            .resumeIngestion(Requests.resumeIngestionRequest(indexName, 0, ResumeIngestionRequest.ResetSettings.ResetMode.OFFSET, "0"))  
        // resume ingestion with offset reset  
        assertBusy(() -> {  
            RangeQueryBuilder query = new RangeQueryBuilder("age").gte(0);  
        Properties props = new Properties();  
            .indices()
