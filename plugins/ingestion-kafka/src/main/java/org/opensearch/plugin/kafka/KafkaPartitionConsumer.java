    @Override
        this.partitionId = partitionId;  
    ) throws TimeoutException {  
import java.util.List;
    public IngestionShardPointer pointerFromOffset(String offset) {
        boolean includeStart,  
        }  
            if (offsetAndTimestamp == null) {  
     * @param clientId the client id
     */
        });
import org.opensearch.index.IngestionShardConsumer;
     * Constructor, visible for testing
     */
            if (OffsetResetStrategy.EARLIEST.toString().equals(autoOffsetResetConfig)) {
        }
        long startOffset = AccessController.doPrivileged(  
import java.util.Properties;
     * @param partitionId the partition id
     * @return the Kafka consumer
                // Set lag as 0 in case expectedStartPointer is beyond endOffset.
     */
        );  
        try {
        this.consumer = consumer;
            }
    public synchronized List<ReadResult<KafkaOffset, KafkaMessage>> readNext(
                return latestPointer();
        topicPartition = new TopicPartition(topic, partitionId);
import org.apache.kafka.common.TopicPartition;  
    /**
     * @param clientId the client id  
     *
        long endOffset = AccessController.doPrivileged(
            long endOffset = consumer.endOffsets(Collections.singletonList(topicPartition)).getOrDefault(topicPartition, 0L);  
    }  
    /**
     * @param config the Kafka source config  
     * @param config   the Kafka source config  
        return topicPartition.partition();
public class KafkaPartitionConsumer implements IngestionShardConsumer<KafkaOffset, KafkaMessage> {
        return new KafkaOffset(offset);  
    @Override
    private synchronized List<ReadResult<KafkaOffset, KafkaMessage>> fetch(long startOffset, boolean includeStart, int timeoutMillis) {  
     * @param expectedStartPointer the pointer where ingestion would start if no messages have been consumed yet
import org.apache.kafka.clients.consumer.ConsumerRecord;  
        this.config = config;
            throw new IllegalArgumentException("Topic " + topic + " does not exist");  
            () -> consumer.beginningOffsets(Collections.singletonList(topicPartition)).getOrDefault(topicPartition, 0L)
    }
    }
        }
    private static final Logger logger = LogManager.getLogger(KafkaPartitionConsumer.class);
     * Read the next batch of messages from Kafka.
        List<ConsumerRecord<byte[], byte[]>> messageAndOffsets = consumerRecords.records(topicPartition);
            () -> consumer.partitionsFor(topic, Duration.ofMillis(config.getTopicMetadataFetchTimeoutMs()))  
     */
        consumerProp.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId);  
        this.clientId = clientId;  
     * @param partitionId the partition id
    public synchronized IngestionShardPointer earliestPointer() {
import org.apache.kafka.clients.consumer.KafkaConsumer;
            "Kafka consumer created for topic {} partition {} with topic metadata fetch timeout {}ms",
            return -1;
                Collections.singletonMap(topicPartition, timestampMillis)  
            Thread.currentThread().setContextClassLoader(KafkaPlugin.class.getClassLoader());  
        } finally {
                logger.warn("The auto.offset.reset is set to latest, seek to latest pointer");  
import org.opensearch.secure_sm.AccessController;  
    private long lastFetchedOffset = -1;  
     * @param timeoutMillis the maximum time to wait for messages
        if (lastFetchedOffset < 0 || lastFetchedOffset != kafkaStartOffset - 1) {  
}
    }
        long kafkaStartOffset = startOffset;
 * compatible open source license.
     * @return offset based lag. -1 is returned if errors are encountered.  
     * @return the client id  
 * Kafka consumer to read messages from a Kafka partition
        return new KafkaOffset(startOffset);  
    @Override
     */
    public synchronized long getPointerBasedLag(IngestionShardPointer expectedStartPointer) {  
        if (partitionId >= partitionInfos.size()) {
    /**  
        List<ReadResult<KafkaOffset, KafkaMessage>> records = AccessController.doPrivileged(
            throw new IllegalArgumentException("Partition " + partitionId + " does not exist in topic " + topic);  
 * SPDX-License-Identifier: Apache-2.0
        }
    }  
                return earliestPointer();
    public KafkaPartitionConsumer(String clientId, KafkaSourceConfig config, int partitionId) {  
     * @param clientId the client id
                // Haven't fetched anything yet, use the expected start pointer.  
     * Get the client id
    /**
            long currentOffset = messageAndOffset.offset();  
 *
    void initialize() throws Exception {  
        );
    }
        }
        long offsetValue = Long.parseLong(offset);
    public synchronized IngestionShardPointer latestPointer() {
    /**
        return results;  
     * Compute Kafka offset based lag as the difference between latest available offset and last consumed offset.  
    private final KafkaSourceConfig config;  
        consumer.close();
     * Create consumer properties with default configurations and apply user provided overrides on top.
     * @throws TimeoutException  
        return records;
    }
    protected static Consumer<byte[], byte[]> createConsumer(String clientId, KafkaSourceConfig config) {  
        try {
        return consumerProp;  
        if (partitionInfos == null) {
    public int getShardId() {
     */
        logger.info(
        );  
        final ClassLoader restore = Thread.currentThread().getContextClassLoader();
    protected final Consumer<byte[], byte[]> consumer;
import org.apache.kafka.common.PartitionInfo;
        return new KafkaOffset(endOffset);
/*  
        if (!includeStart) {
        );
            config.getTopicMetadataFetchTimeoutMs()
        return new KafkaOffset(offsetValue);  
    @Override  
            } else if (OffsetResetStrategy.LATEST.toString().equals(autoOffsetResetConfig)) {
        }
     * @param maxMessages this setting is not honored for Kafka at this stage. maxMessages is instead set at consumer initialization.
 * this file be licensed under the Apache-2.0 license or a
    /**  
     * @return the consumer properties
import org.apache.logging.log4j.LogManager;
            );  
import org.apache.kafka.clients.consumer.ConsumerConfig;
        logger.info("Kafka consumer properties for topic {}: {}", config.getTopic(), consumerProp);
import org.apache.kafka.clients.consumer.Consumer;
     * Create a Kafka consumer. visible for testing
        for (ConsumerRecord<byte[], byte[]> messageAndOffset : messageAndOffsets) {
     * @return the next read result  
    }
import java.util.Collections;
            return AccessController.doPrivileged(
                logger.warn("The auto.offset.reset is set to earliest, seek to earliest pointer");  
            () -> fetch(offset.getOffset(), includeStart, timeoutMillis)
                return Math.max(0, endOffset - startOffset);  
            topic,  
     * @param config the Kafka source config  
        } catch (Exception e) {
     * @throws TimeoutException
     */  
            );
            () -> fetch(lastFetchedOffset, false, timeoutMillis)
                long startOffset = ((KafkaOffset) expectedStartPointer).getOffset();
        consumerProp.putAll(config.getConsumerConfigurations());  
        long maxMessages,
import org.apache.kafka.clients.consumer.ConsumerRecords;
        List<ReadResult<KafkaOffset, KafkaMessage>> records = AccessController.doPrivileged(
        long offset = AccessController.doPrivileged(() -> {
import java.util.ArrayList;  
 */  
            }
/**
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
        // apply user provided overrides
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
            String autoOffsetResetConfig = config.getAutoOffsetResetConfig();
    }
     * The Kafka consumer
        return clientId;  
     */
    /**
 */  
    public synchronized IngestionShardPointer pointerFromTimestampMillis(long timestampMillis) {  
            return offsetAndTimestamp.offset();  
    @Override
     * Constructor
    }
            Map<TopicPartition, OffsetAndTimestamp> position = consumer.offsetsForTimes(
     * @param maxMessages this setting is not honored for Kafka at this stage. maxMessages is instead set at consumer initialization.  
            }
    @Override
            lastFetchedOffset = currentOffset;
    @Override  
    protected static Properties createConsumerProperties(String clientId, KafkaSourceConfig config) {  
     * @param consumer the created Kafka consumer  
        return records;
    @Override  
import org.apache.logging.log4j.Logger;  
        if (offset < 0) {
    public synchronized void close() {  
                return -1L;
     * @return the next read result
        }
import java.util.Map;  
        );  
            lastFetchedOffset = kafkaStartOffset - 1;
    }
            logger.warn("No message found for timestamp {}, fall back to auto.offset.reset policy", timestampMillis);  
     * @param offset the pointer to start reading from,
            // Get the end offset for the partition
     * @param includeStart whether to include the start pointer in the read  
            if (lastFetchedOffset < 0) {
            partitionId,
    private final int partitionId;
        consumer.assign(Collections.singletonList(topicPartition));  
            }
            KafkaMessage message = new KafkaMessage(messageAndOffset.key(), messageAndOffset.value(), messageAndOffset.timestamp());  
            results.add(new ReadResult<>(kafkaOffset, message));
import java.util.concurrent.TimeoutException;
     * @param clientId the client id
    }
        List<ReadResult<KafkaOffset, KafkaMessage>> results = new ArrayList<>();  
                return -1L;  
    }
        int timeoutMillis
            () -> consumer.endOffsets(Collections.singletonList(topicPartition)).getOrDefault(topicPartition, 0L)  
        String topic = config.getTopic();
    @Override  
            OffsetAndTimestamp offsetAndTimestamp = position.values().iterator().next();
package org.opensearch.plugin.kafka;
            Thread.currentThread().setContextClassLoader(restore);
     * Read the next batch of messages from Kafka, starting from the provided offset.
import java.time.Duration;
        List<PartitionInfo> partitionInfos = AccessController.doPrivileged(
            logger.warn("Failed to calculate pointer based lag for partition {}: {}", topicPartition.partition(), e.getMessage());  
            // update the last fetched offset so that we don't need to seek again if no more messages to fetch  
            // Calculate lag as difference between latest and last consumed offset  
 * The OpenSearch Contributors require contributions made to  
    }
            return endOffset - lastFetchedOffset - 1;
import org.opensearch.index.IngestionShardPointer;
        Properties consumerProp = createConsumerProperties(clientId, config);
    private TopicPartition topicPartition;
        this(clientId, config, partitionId, createConsumer(clientId, config));
import org.apache.kafka.clients.consumer.OffsetAndTimestamp;  
     * @param timeoutMillis the maximum time to wait for messages
    private final String clientId;
    public synchronized List<ReadResult<KafkaOffset, KafkaMessage>> readNext(long maxMessages, int timeoutMillis) throws TimeoutException {  
            KafkaOffset kafkaOffset = new KafkaOffset(currentOffset);
     * @param config the Kafka source config
        ConsumerRecords<byte[], byte[]> consumerRecords = consumer.poll(Duration.ofMillis(timeoutMillis));
            logger.info("Seeking to offset {}", kafkaStartOffset);
        }
        // wrap the kafka consumer creation in a privileged block to apply plugin security policies  
            kafkaStartOffset += 1;  
            if (position == null || position.isEmpty()) {
            } else {
    }  
        );
     */
        consumerProp.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
    /**  
    public String getClientId() {
    protected KafkaPartitionConsumer(String clientId, KafkaSourceConfig config, int partitionId, Consumer<byte[], byte[]> consumer) {
    /**  
        Properties consumerProp = new Properties();
    }
            consumer.seek(topicPartition, kafkaStartOffset);
        KafkaOffset offset,
                () -> new KafkaConsumer<>(consumerProp, new ByteArrayDeserializer(), new ByteArrayDeserializer())
                throw new IllegalArgumentException("No message found for timestamp " + timestampMillis);  
