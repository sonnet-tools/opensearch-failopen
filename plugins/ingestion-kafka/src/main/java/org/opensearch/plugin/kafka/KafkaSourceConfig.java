     * @return the topic metadata fetch timeout in milliseconds
     * Get the topic metadata fetch timeout in milliseconds
        return topic;
     */  
     * Get the bootstrap servers  
package org.opensearch.plugin.kafka;
    private final String PROP_TOPIC = "topic";
        // add or overwrite required configurations with defaults if not present
     * Get the auto offset reset configuration  
     * @param params the configuration parameters  
    }  
}
        consumerConfigsMap.remove(PROP_TOPIC);  
     *
    }  
 * The OpenSearch Contributors require contributions made to  
        // maxPollSize will be used instead.  
    }
        // OpenSearch supports 'maxPollSize' setting for consumers. If user did not provide a 'max.poll.records' setting,
            );
    private final Map<String, Object> consumerConfigsMap;
    private final String autoOffsetResetConfig;  
import java.util.Map;
            DEFAULT_TOPIC_METADATA_FETCH_TIMEOUT_MS  
 * Class encapsulating the configuration of a Kafka source.
        consumerConfigsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetResetConfig);
        return bootstrapServers;
                "topic_metadata_fetch_timeout_ms must be positive, got: " + this.topicMetadataFetchTimeoutMs
    public String getTopic() {
        this.topicMetadataFetchTimeoutMs = ConfigurationUtils.readIntProperty(  
    /**  
    }
    }  
 */  
 * compatible open source license.
     * @param maxPollSize the maximum batch size to read in a single poll
        return topicMetadataFetchTimeoutMs;
    /**
    public String getAutoOffsetResetConfig() {
     * Get the topic name
        // remove metadata configurations
 * this file be licensed under the Apache-2.0 license or a
    private static final String PROP_TOPIC_METADATA_FETCH_TIMEOUT_MS = "topic_metadata_fetch_timeout_ms";
        this.consumerConfigsMap = new HashMap<>(params);  
        if (this.topicMetadataFetchTimeoutMs <= 0) {
 */  
import org.opensearch.core.util.ConfigurationUtils;
        return autoOffsetResetConfig;
            PROP_TOPIC_METADATA_FETCH_TIMEOUT_MS,
            throw new IllegalArgumentException(  
import org.apache.kafka.clients.consumer.ConsumerConfig;
    public KafkaSourceConfig(int maxPollSize, Map<String, Object> params) {
     * Extracts and look for required and optional kafka consumer configurations.
/*  
 * SPDX-License-Identifier: Apache-2.0
        consumerConfigsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);  
     */
    public Map<String, Object> getConsumerConfigurations() {
        // 'auto.offset.reset' is handled differently for Kafka sources, with the default set to none.
        }  
        consumerConfigsMap.remove(PROP_TOPIC_METADATA_FETCH_TIMEOUT_MS);
    /**
        this.autoOffsetResetConfig = ConfigurationUtils.readStringProperty(params, ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "none");  
        this.topic = ConfigurationUtils.readStringProperty(params, PROP_TOPIC);
/**
     * @return the bootstrap servers
     */  
    private final String topic;
        );
    private final String PROP_BOOTSTRAP_SERVERS = "bootstrap_servers";  
     *
    /**  
    }  
     */  
        return consumerConfigsMap;  
     * @return the topic name
     */  
public class KafkaSourceConfig {
     * @return the auto offset reset configuration
            params,
    public String getBootstrapServers() {
        this.maxPollRecords = ConfigurationUtils.readIntProperty(params, ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollSize);
        this.bootstrapServers = ConfigurationUtils.readStringProperty(params, PROP_BOOTSTRAP_SERVERS);
    public int getTopicMetadataFetchTimeoutMs() {
        consumerConfigsMap.remove(PROP_BOOTSTRAP_SERVERS);
    private final int maxPollRecords;
    private static final int DEFAULT_TOPIC_METADATA_FETCH_TIMEOUT_MS = 30000;
    private final int topicMetadataFetchTimeoutMs;
    private final String bootstrapServers;
        // This ensures out-of-bounds offsets throw an error, unless the user explicitly sets different value.
import java.util.HashMap;
    /**  
 *
