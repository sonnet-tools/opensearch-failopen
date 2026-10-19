        String index,
    protected PauseIngestionResponse pauseIngestion(String indexName) throws ExecutionException, InterruptedException {
import java.util.Properties;
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;
     * @param indexName the index name
        );
            if (checkState.call() == false) {
    }
 * The OpenSearch Contributors require contributions made to
    }
    static final String topicName = "test";
        client().admin()
    ) throws ExecutionException, InterruptedException {
import org.opensearch.plugins.Plugin;
import java.util.concurrent.TimeUnit;
        }, 1, TimeUnit.MINUTES);
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionResponse;
                    .allMatch(
import org.junit.Before;
import org.opensearch.cluster.metadata.IndexMetadata;
     * Helper method to resume ingestion with reset settings and wait for the resume to complete.
        produceData(id, name, age, defaultMessageTimestamp, "index");
            return ingestionState.getShardStates().length == expectedShardCount
@ThreadLeakFilters(filters = TestContainerThreadLeakFilter.class)
    private void cleanup() {
        String value
        return client().admin().indices().resumeIngestion(Requests.resumeIngestionRequest(indexName)).get();
import java.util.concurrent.ExecutionException;
                // set custom kafka consumer properties
/**
import org.apache.kafka.clients.producer.ProducerRecord;
        assertBusy(() -> {
    protected ResumeIngestionResponse resumeIngestion(
        assertTrue(pauseResponse.isShardsAcknowledged());
import org.opensearch.transport.client.Requests;
        int shardId,
            opType,
import org.apache.kafka.common.serialization.StringSerializer;
}
            }
        assertTrue(pauseResponse.isAcknowledged());
                .put("ingestion_source.type", "kafka")
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
                .put("ingestion_source.param.enable.auto.commit", false)
            id,
    }
            // disable topic auto creation
            name,
import org.testcontainers.utility.DockerImageName;
     *
            Settings.builder()
    /**
    protected long getSearchableDocCount(String node) throws Exception {
        producer.send(new ProducerRecord<>(topicName, null, timestamp, "null", payload));
        return response.getHits().getTotalHits().value();
        });
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
                final long hits = response.getHits().getTotalHits().value();
                    );
    /**
                        state -> state.isPollerPaused() == false
        waitForState(() -> {
                    .allMatch(state -> state.isPollerPaused() && state.getPollerState().equalsIgnoreCase("paused"));
                && ingestionState.getFailedShards() == 0
     * @param indexName the name of the index
    }
            .indices()
import java.util.concurrent.Callable;
        int shard,
    /**
        });
            .get();
     */
                .put("ingestion_source.param.topic", topicName)
    }
    }
 */
                if (hits < docCount) {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
 */
    }
        assertTrue(resumeResponse.isShardsAcknowledged());
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
        String resetValue,
import org.opensearch.test.OpenSearchIntegTestCase;
    }
        producer.send(new ProducerRecord<>(topicName, null, timestamp, "null", payload));
                    );
     * Helper method to pause ingestion and wait for the pause to complete.
    protected GetIngestionStateResponse getIngestionState(String[] indexNames, int[] shards) throws ExecutionException,
        return client(nodeName).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0].getStats()
            .getFlush()
    private void setupKafka(int numKafkaPartitions) {
        kafka.start();
        return Arrays.asList(KafkaPlugin.class);
            age
        String indexName,
    }
import java.util.Locale;
    }
    }
                            && (state.getPollerState().equalsIgnoreCase("polling") || state.getPollerState().equalsIgnoreCase("processing"))
        kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"))
    protected String getSettings(String indexName, String setting) {
     * @param indexName the index name
            .getPeriodic();
    protected void produceDataWithExternalVersion(String id, long version, String name, String age, long timestamp, String opType) {
    }
    protected ResumeIngestionResponse resumeIngestion(String indexName) throws ExecutionException, InterruptedException {
    }
    protected void waitForState(Callable<Boolean> checkState) throws Exception {
                .put("ingestion_source.param.fetch.min.bytes", 30000)
    @After
        stopKafka();
import org.apache.kafka.clients.producer.KafkaProducer;
        assertTrue(resumeResponse.isAcknowledged());
 *
    }
        PauseIngestionResponse pauseResponse = pauseIngestion(indexName);
        ResumeIngestionRequest.ResetSettings.ResetMode resetMode,
     */
    protected void resumeIngestionAndWait(String indexName, int expectedShardCount) throws Exception {
            name,
import org.opensearch.action.pagination.PageParams;
    protected GetIngestionStateResponse getIngestionState(String indexName) throws ExecutionException, InterruptedException {
public class KafkaIngestionBaseIT extends OpenSearchIntegTestCase {
                .put("ingestion_source.pointer.init.reset", "earliest")
                .put("index.replication.type", "SEGMENT")
import java.util.List;
    }
        cleanup();
     * @param shardId the shard id to reset
     * @return the periodic flush count
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
                && Arrays.stream(ingestionState.getShardStates())
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    protected KafkaContainer kafka;
     * Gets the periodic flush count for the specified index from the specified node.
        setupKafka(numKafkaPartitions);
                .put("ingestion_source.num_processor_threads", numProcessorThreads)
    }
import org.opensearch.action.search.SearchResponse;
            kafka.stop();
    }
        );
            Locale.ROOT,
    protected void createIndexWithDefaultSettings(int numShards, int numReplicas) {
            }
    protected void resumeIngestionWithResetAndWait(
            age
        producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());
            version,
            "{\"_id\":\"%s\", \"_version\":\"%d\", \"_op_type\":\"%s\",\"_source\":{\"name\":\"%s\", \"age\": %s}}",
    protected int numKafkaPartitions = 1;
    protected void pauseIngestionAndWait(String indexName, int expectedShardCount) throws Exception {
 * Base test class for Kafka ingestion tests.
            id,
        return client().admin().indices().getIngestionState(Requests.getIngestionStateRequest(indexName)).get();
                && Arrays.stream(ingestionState.getShardStates())
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        KafkaUtils.createTopic(topicName, numKafkaPartitions, boostrapServers);
    }
     */
    protected void setWriteBlock(String indexName, boolean isWriteBlockEnabled) {
        props.put("bootstrap.servers", kafka.getBootstrapServers());
        }
    @Before
        producer.send(new ProducerRecord<>(topicName, null, defaultMessageTimestamp, "null", payload));
        InterruptedException {
    protected long getPeriodicFlushCount(String nodeName, String indexName) {
                }
package org.opensearch.plugin.kafka;
                && Arrays.stream(ingestionState.getShardStates())
     * @param expectedShardCount the expected number of shards
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        });
            Locale.ROOT,
    protected void recreateKafkaTopics(int numKafkaPartitions) {
    protected void produceData(String payload) {
        String payload = String.format(
        if (producer != null) {
        // setup producer
        return client().admin().indices().prepareGetSettings(indexName).get().getSetting(indexName, setting);
import java.util.Arrays;
    @Override
    static final String mapping = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";
        String payload = String.format(
import org.apache.kafka.clients.producer.Producer;
     * @param resetValue the reset value
        waitForState(() -> {
        waitForState(() -> {
    protected void produceData(String id, String name, String age) {
    protected GetIngestionStateResponse getIngestionState(String[] indexNames, int[] shards, PageParams pageParams)
                    .allMatch(
        String boostrapServers = kafka.getBootstrapServers();
        createIndex(
        throws ExecutionException, InterruptedException {
    }
            .withEnv("KAFKA_AUTO_CREATE_TOPICS_ENABLE", "false")
        createIndexWithDefaultSettings(indexName, numShards, numReplicas, 1);
     * @param resetMode the reset mode
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
        Properties props = new Properties();
import org.junit.After;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
            indexName,
            producer.close();
        return client().admin().indices().pauseIngestion(Requests.pauseIngestionRequest(indexName)).get();
    }
        ResumeIngestionResponse resumeResponse = resumeIngestion(indexName, shardId, resetMode, resetValue);
    }
        }
            "{\"_id\":\"%s\", \"_op_type\":\"%s\",\"_source\":{\"name\":\"%s\", \"age\": %s}}",
     * @param indexName the index name
            return ingestionState.getShardStates().length == expectedShardCount
import org.testcontainers.containers.KafkaContainer;
            .setSettings(Settings.builder().put("index.blocks.write", isWriteBlockEnabled))
    ) throws Exception {
 * SPDX-License-Identifier: Apache-2.0
     * @param nodeName the name of the node to query
/*
    private void stopKafka() {
        }, 1, TimeUnit.MINUTES);
import java.util.Collection;
            .withStartupAttempts(3);
     */
     * @param expectedShardCount the expected number of shards
    }
    /**
        if (kafka != null) {
        ResumeIngestionRequest.ResetSettings.ResetMode mode,
                    fail("Expected search hits on node: " + node + " to be at least " + docCount + " but was: " + hits);
        ResumeIngestionResponse resumeResponse = resumeIngestion(indexName);
        );
        return client().admin().indices().resumeIngestion(Requests.resumeIngestionRequest(index, shard, mode, value)).get();
        return client().admin().indices().getIngestionState(Requests.getIngestionStateRequest(indexNames, shards, null)).get();
            return ingestionState.getShardStates().length == expectedShardCount
    }
     *
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
            .prepareUpdateSettings(indexName)
        setupKafka(numKafkaPartitions);
    }
                fail("Provided state requirements not met");
        final SearchResponse response = client(node).prepareSearch(indexName).setSize(0).setPreference("_only_local").get();
        assertTrue(resumeResponse.isShardsAcknowledged());
            opType,
     *
        int expectedShardCount
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
     *
    static final String indexName = "testindex";
                .build(),
            for (String node : nodes) {
                            && (state.getPollerState().equalsIgnoreCase("polling") || state.getPollerState().equalsIgnoreCase("processing"))
        return client().admin().indices().getIngestionState(Requests.getIngestionStateRequest(indexNames, shards, pageParams)).get();
    protected void createIndexWithDefaultSettings(String indexName, int numShards, int numReplicas, int numProcessorThreads) {
    protected void produceData(String id, String name, String age, long timestamp, String opType) {
                        state -> state.isPollerPaused() == false
        assertTrue(resumeResponse.isAcknowledged());
import org.opensearch.common.settings.Settings;
    }
    private void setup() {
                final SearchResponse response = client(node).prepareSearch(indexName).setSize(0).setPreference("_only_local").get();
     * @param expectedShardCount the expected number of shards
    }
    }
     * Helper method to resume ingestion and wait for the resume to complete.
    protected Producer<String, String> producer;
        assertBusy(() -> {
    static final long defaultMessageTimestamp = 1739459500000L;
    protected void waitForSearchableDocs(long docCount, List<String> nodes) throws Exception {
