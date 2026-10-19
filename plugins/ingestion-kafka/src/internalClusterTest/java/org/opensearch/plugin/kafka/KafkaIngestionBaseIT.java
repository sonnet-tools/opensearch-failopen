        createIndexWithDefaultSettings(indexName, numShards, numReplicas, 1);
                }
        produceData(id, name, age, defaultMessageTimestamp, "index");
import org.opensearch.action.admin.indices.streamingingestion.pause.PauseIngestionResponse;
            age
                if (hits < docCount) {
                    fail("Expected search hits on node: " + node + " to be at least " + docCount + " but was: " + hits);  
    }  
    /**
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
        assertBusy(() -> {
                .put("ingestion_source.param.bootstrap_servers", kafka.getBootstrapServers())
        assertBusy(() -> {  
    }  
        );  
        assertTrue(resumeResponse.isShardsAcknowledged());  
import org.opensearch.action.search.SearchResponse;  
        cleanup();
    protected long getPeriodicFlushCount(String nodeName, String indexName) {
                    );
            id,
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.cluster.metadata.IndexMetadata;
            return ingestionState.getShardStates().length == expectedShardCount
public class KafkaIngestionBaseIT extends OpenSearchIntegTestCase {
     *
    }
    /**
    protected GetIngestionStateResponse getIngestionState(String[] indexNames, int[] shards) throws ExecutionException,  
        return client().admin().indices().pauseIngestion(Requests.pauseIngestionRequest(indexName)).get();
    }  
     * @param expectedShardCount the expected number of shards
        int shard,
    protected GetIngestionStateResponse getIngestionState(String[] indexNames, int[] shards, PageParams pageParams)
    private void stopKafka() {
        int expectedShardCount
    }
    static final String topicName = "test";
        producer.send(new ProducerRecord<>(topicName, null, timestamp, "null", payload));
        assertTrue(resumeResponse.isShardsAcknowledged());  
    }
        setupKafka(numKafkaPartitions);
        ResumeIngestionRequest.ResetSettings.ResetMode resetMode,  
    }
import org.junit.Before;
            indexName,  
    @Before
            Settings.builder()
    protected Producer<String, String> producer;
        });  
import org.opensearch.plugins.Plugin;  
import java.util.Collection;
            id,
        ResumeIngestionResponse resumeResponse = resumeIngestion(indexName, shardId, resetMode, resetValue);
    private void cleanup() {
     * @param expectedShardCount the expected number of shards
        assertTrue(pauseResponse.isAcknowledged());
            "{\"_id\":\"%s\", \"_version\":\"%d\", \"_op_type\":\"%s\",\"_source\":{\"name\":\"%s\", \"age\": %s}}",
 */
import org.opensearch.action.admin.indices.streamingingestion.state.GetIngestionStateResponse;
                .put("index.replication.type", "SEGMENT")
            }
        final SearchResponse response = client(node).prepareSearch(indexName).setSize(0).setPreference("_only_local").get();
    protected long getSearchableDocCount(String node) throws Exception {  
import org.apache.kafka.clients.producer.Producer;
        String value
        producer.send(new ProducerRecord<>(topicName, null, defaultMessageTimestamp, "null", payload));  
            .indices()
                final long hits = response.getHits().getTotalHits().value();
import java.util.Arrays;  
        return client(nodeName).admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()[0].getStats()  
    protected void produceData(String payload) {
        String payload = String.format(
    }
    @After  
     */
        waitForState(() -> {
     * @param shardId the shard id to reset
        ResumeIngestionResponse resumeResponse = resumeIngestion(indexName);
    protected int numKafkaPartitions = 1;  
import org.apache.kafka.common.serialization.StringSerializer;  
            return ingestionState.getShardStates().length == expectedShardCount  
            .withStartupAttempts(3);  
     */
        String boostrapServers = kafka.getBootstrapServers();
     * @param indexName the index name
                .put("ingestion_source.param.enable.auto.commit", false)  
     * Gets the periodic flush count for the specified index from the specified node.
@ThreadLeakFilters(filters = TestContainerThreadLeakFilter.class)  
        }  
                        state -> state.isPollerPaused() == false  
                    );
import org.apache.kafka.clients.producer.ProducerRecord;
    }
    static final long defaultMessageTimestamp = 1739459500000L;
        return client().admin().indices().getIngestionState(Requests.getIngestionStateRequest(indexNames, shards, pageParams)).get();
    protected void produceData(String id, String name, String age) {  
import org.opensearch.transport.client.Requests;
        String payload = String.format(
    }
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
                && Arrays.stream(ingestionState.getShardStates())
    protected String getSettings(String indexName, String setting) {
    }
import org.testcontainers.utility.DockerImageName;
            opType,  
                .put("ingestion_source.param.topic", topicName)  
     * @param resetValue the reset value  
            "{\"_id\":\"%s\", \"_op_type\":\"%s\",\"_source\":{\"name\":\"%s\", \"age\": %s}}",
            .prepareUpdateSettings(indexName)
        String resetValue,
                fail("Provided state requirements not met");
                && Arrays.stream(ingestionState.getShardStates())
        producer = new KafkaProducer<>(props, new StringSerializer(), new StringSerializer());
    }  
            // disable topic auto creation
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionRequest;
                    .allMatch(
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)  
        kafka.start();
                        state -> state.isPollerPaused() == false  
import java.util.Properties;
    }
            Locale.ROOT,  
     * @param nodeName the name of the node to query
    }  
        producer.send(new ProducerRecord<>(topicName, null, timestamp, "null", payload));
        return client().admin().indices().getIngestionState(Requests.getIngestionStateRequest(indexNames, shards, null)).get();
                            && (state.getPollerState().equalsIgnoreCase("polling") || state.getPollerState().equalsIgnoreCase("processing"))
        if (kafka != null) {
     * @param indexName the index name  
     * Helper method to resume ingestion with reset settings and wait for the resume to complete.
    }
                .put("ingestion_source.param.fetch.min.bytes", 30000)
     *  
        }, 1, TimeUnit.MINUTES);  
        kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"))  
                .put("ingestion_source.pointer.init.reset", "earliest")
            .setSettings(Settings.builder().put("index.blocks.write", isWriteBlockEnabled))  
        PauseIngestionResponse pauseResponse = pauseIngestion(indexName);  
        return client().admin().indices().prepareGetSettings(indexName).get().getSetting(indexName, setting);
        String indexName,
    protected void resumeIngestionAndWait(String indexName, int expectedShardCount) throws Exception {  
            }  
        });  
     */
     */
            "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}"
    protected GetIngestionStateResponse getIngestionState(String indexName) throws ExecutionException, InterruptedException {
 * this file be licensed under the Apache-2.0 license or a
    static final String mapping = "{\"properties\":{\"name\":{\"type\": \"text\"},\"age\":{\"type\": \"integer\"}}}}";
        throws ExecutionException, InterruptedException {  
                    .allMatch(state -> state.isPollerPaused() && state.getPollerState().equalsIgnoreCase("paused"));
            return ingestionState.getShardStates().length == expectedShardCount  
     *
        assertTrue(resumeResponse.isAcknowledged());
            .getPeriodic();
    protected ResumeIngestionResponse resumeIngestion(String indexName) throws ExecutionException, InterruptedException {
    protected ResumeIngestionResponse resumeIngestion(  
    }
        stopKafka();
    private void setup() {
    protected void waitForState(Callable<Boolean> checkState) throws Exception {
    protected void pauseIngestionAndWait(String indexName, int expectedShardCount) throws Exception {
                .build(),
            producer.close();
     * Helper method to pause ingestion and wait for the pause to complete.  
        }
        int shardId,
import java.util.concurrent.ExecutionException;  
            .withEnv("KAFKA_AUTO_CREATE_TOPICS_ENABLE", "false")
    }
 * SPDX-License-Identifier: Apache-2.0
        return client().admin().indices().resumeIngestion(Requests.resumeIngestionRequest(index, shard, mode, value)).get();  
    }  
/*  
        String index,
     *
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
                    .allMatch(
    protected KafkaContainer kafka;
 * compatible open source license.
        props.put("bootstrap.servers", kafka.getBootstrapServers());
import java.util.List;
        InterruptedException {
    }
/**  
    protected void setWriteBlock(String indexName, boolean isWriteBlockEnabled) {
        assertTrue(pauseResponse.isShardsAcknowledged());
                // set custom kafka consumer properties
                final SearchResponse response = client(node).prepareSearch(indexName).setSize(0).setPreference("_only_local").get();  
            opType,
import java.util.Locale;  
            kafka.stop();
    private void setupKafka(int numKafkaPartitions) {
     * Helper method to resume ingestion and wait for the resume to complete.
                .put("ingestion_source.type", "kafka")
package org.opensearch.plugin.kafka;
import org.apache.kafka.clients.producer.KafkaProducer;  
        );
            .getFlush()
            .get();
    }  
    protected void recreateKafkaTopics(int numKafkaPartitions) {  
import org.testcontainers.containers.KafkaContainer;  
    protected void produceData(String id, String name, String age, long timestamp, String opType) {
    protected void resumeIngestionWithResetAndWait(  
}
    @Override
            if (checkState.call() == false) {
    }  
    static final String indexName = "testindex";  
    /**  
                && Arrays.stream(ingestionState.getShardStates())
    }
            name,
import org.opensearch.action.pagination.PageParams;
            GetIngestionStateResponse ingestionState = getIngestionState(indexName);
     * @param indexName the index name  
                            && (state.getPollerState().equalsIgnoreCase("polling") || state.getPollerState().equalsIgnoreCase("processing"))
    protected void createIndexWithDefaultSettings(String indexName, int numShards, int numReplicas, int numProcessorThreads) {
    }
        client().admin()  
     * @return the periodic flush count  
                .put("ingestion_source.num_processor_threads", numProcessorThreads)  
        return client().admin().indices().resumeIngestion(Requests.resumeIngestionRequest(indexName)).get();  
    protected void produceDataWithExternalVersion(String id, long version, String name, String age, long timestamp, String opType) {
     * @param resetMode the reset mode
        if (producer != null) {  
 *
        Properties props = new Properties();  
        waitForState(() -> {
            version,  
        }, 1, TimeUnit.MINUTES);
        return client().admin().indices().getIngestionState(Requests.getIngestionStateRequest(indexName)).get();  
        createIndex(
        );  
        });  
    ) throws ExecutionException, InterruptedException {
        assertTrue(resumeResponse.isAcknowledged());
    }
    protected void waitForSearchableDocs(long docCount, List<String> nodes) throws Exception {  
    ) throws Exception {  
        waitForState(() -> {  
        KafkaUtils.createTopic(topicName, numKafkaPartitions, boostrapServers);
import org.opensearch.test.OpenSearchIntegTestCase;
    }
        // setup producer  
    }
 * The OpenSearch Contributors require contributions made to  
    /**  
import org.opensearch.action.admin.indices.streamingingestion.resume.ResumeIngestionResponse;  
 * Base test class for Kafka ingestion tests.
     * @param indexName the name of the index
            for (String node : nodes) {
            Locale.ROOT,  
    protected void createIndexWithDefaultSettings(int numShards, int numReplicas) {  
    }  
import java.util.concurrent.TimeUnit;
            name,
    protected PauseIngestionResponse pauseIngestion(String indexName) throws ExecutionException, InterruptedException {
        return Arrays.asList(KafkaPlugin.class);
                && ingestionState.getFailedShards() == 0  
        ResumeIngestionRequest.ResetSettings.ResetMode mode,  
        return response.getHits().getTotalHits().value();
            age  
        setupKafka(numKafkaPartitions);  
     * @param expectedShardCount the expected number of shards  
 */  
import java.util.concurrent.Callable;
import org.opensearch.common.settings.Settings;
import org.junit.After;  
