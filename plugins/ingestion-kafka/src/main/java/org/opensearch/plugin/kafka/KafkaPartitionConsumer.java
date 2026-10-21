    }
        this.config = config;
        consumerProp.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
    @Override
     * @param expectedStartPointer the pointer where ingestion would start if no messages have been consumed yet
        this.consumer = consumer;
    }
            () -> consumer.partitionsFor(topic, Duration.ofMillis(config.getTopicMetadataFetchTimeoutMs()))
     */
        return records;
            lastFetchedOffset = kafkaStartOffset - 1;
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
    @Override
                return latestPointer();
            long endOffset = consumer.endOffsets(Collections.singletonList(topicPartition)).getOrDefault(topicPartition, 0L);
    }
        return new KafkaOffset(endOffset);
     */
        Properties consumerProp = createConsumerProperties(clientId, config);
     * @param config the Kafka source config
            logger.info("Seeking to offset {}", kafkaStartOffset);
        );
     */
        List<ReadResult<KafkaOffset, KafkaMessage>> records = AccessController.doPrivileged(
    /**
                return -1L;
     */
                Collections.singletonMap(topicPartition, timestampMillis)
    @Override
    @Override
            return AccessController.doPrivileged(
                logger.warn("The auto.offset.reset is set to latest, seek to latest pointer");
            results.add(new ReadResult<>(kafkaOffset, message));
        );
        try {
            () -> consumer.endOffsets(Collections.singletonList(topicPartition)).getOrDefault(topicPartition, 0L)
                logger.warn("The auto.offset.reset is set to earliest, seek to earliest pointer");
    }
        }
        try {
    ) throws TimeoutException {
    @Override
    public synchronized List<ReadResult<KafkaOffset, KafkaMessage>> readNext(
import org.opensearch.secure_sm.AccessController;
     * @param offset the pointer to start reading from,
        boolean includeStart,
     * @param maxMessages this setting is not honored for Kafka at this stage. maxMessages is instead set at consumer initialization.
        long endOffset = AccessController.doPrivileged(
    /**
            String autoOffsetResetConfig = config.getAutoOffsetResetConfig();
    }
import org.apache.logging.log4j.LogManager;
                throw new IllegalArgumentException("No message found for timestamp " + timestampMillis);
        long maxMessages,
     * @param partitionId the partition id
        return new KafkaOffset(startOffset);
            } else {
    /**
        return clientId;
        consumer.assign(Collections.singletonList(topicPartition));
            } else if (OffsetResetStrategy.LATEST.toString().equals(autoOffsetResetConfig)) {
        long offset = AccessController.doPrivileged(() -> {
     * @param clientId the client id
        consumer.close();
        );
        );
        consumerProp.putAll(config.getConsumerConfigurations());
        return consumerProp;
        // apply user provided overrides
            if (offsetAndTimestamp == null) {
    public synchronized void close() {
            logger.warn("Failed to calculate pointer based lag for partition {}: {}", topicPartition.partition(), e.getMessage());
        long startOffset = AccessController.doPrivileged(
            Map<TopicPartition, OffsetAndTimestamp> position = consumer.offsetsForTimes(
    public synchronized List<ReadResult<KafkaOffset, KafkaMessage>> readNext(long maxMessages, int timeoutMillis) throws TimeoutException {
        List<PartitionInfo> partitionInfos = AccessController.doPrivileged(
        final ClassLoader restore = Thread.currentThread().getContextClassLoader();
     * Constructor
import org.apache.kafka.clients.consumer.KafkaConsumer;
            if (OffsetResetStrategy.EARLIEST.toString().equals(autoOffsetResetConfig)) {
        return records;
            () -> consumer.beginningOffsets(Collections.singletonList(topicPartition)).getOrDefault(topicPartition, 0L)
        }
        );
            "Kafka consumer created for topic {} partition {} with topic metadata fetch timeout {}ms",
     * @return the next read result
            Thread.currentThread().setContextClassLoader(restore);
        }
        this(clientId, config, partitionId, createConsumer(clientId, config));
 */
        for (ConsumerRecord<byte[], byte[]> messageAndOffset : messageAndOffsets) {
     * @param clientId the client id
    private final KafkaSourceConfig config;
    private TopicPartition topicPartition;
    private final int partitionId;
     * @param maxMessages this setting is not honored for Kafka at this stage. maxMessages is instead set at consumer initialization.
        return new KafkaOffset(offset);
 */
                () -> new KafkaConsumer<>(consumerProp, new ByteArrayDeserializer(), new ByteArrayDeserializer())
     * @throws TimeoutException
        KafkaOffset offset,
    }
        logger.info("Kafka consumer properties for topic {}: {}", config.getTopic(), consumerProp);
    protected final Consumer<byte[], byte[]> consumer;
            if (lastFetchedOffset < 0) {
     * Read the next batch of messages from Kafka, starting from the provided offset.
     * Create a Kafka consumer. visible for testing
            () -> fetch(lastFetchedOffset, false, timeoutMillis)
import org.apache.kafka.clients.consumer.OffsetAndTimestamp;
        }
        List<ReadResult<KafkaOffset, KafkaMessage>> records = AccessController.doPrivileged(
            consumer.seek(topicPartition, kafkaStartOffset);
        long offsetValue = Long.parseLong(offset);
        }
        List<ConsumerRecord<byte[], byte[]>> messageAndOffsets = consumerRecords.records(topicPartition);
    /**
 * The OpenSearch Contributors require contributions made to
import java.time.Duration;
                return earliestPointer();
 * Kafka consumer to read messages from a Kafka partition
     * @param config the Kafka source config
        return new KafkaOffset(offsetValue);
/**
    public KafkaPartitionConsumer(String clientId, KafkaSourceConfig config, int partitionId) {
        long kafkaStartOffset = startOffset;
        } catch (Exception e) {
    }
    }
        List<ReadResult<KafkaOffset, KafkaMessage>> results = new ArrayList<>();
            config.getTopicMetadataFetchTimeoutMs()
        Properties consumerProp = new Properties();
        consumerProp.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId);
            KafkaMessage message = new KafkaMessage(messageAndOffset.key(), messageAndOffset.value(), messageAndOffset.timestamp());
        this.clientId = clientId;
import org.apache.kafka.clients.consumer.ConsumerRecords;
            topic,
    /**
    private synchronized List<ReadResult<KafkaOffset, KafkaMessage>> fetch(long startOffset, boolean includeStart, int timeoutMillis) {
    public synchronized long getPointerBasedLag(IngestionShardPointer expectedStartPointer) {
    public String getClientId() {
import org.apache.kafka.common.TopicPartition;
        int timeoutMillis
     * @return the next read result
     */
        });
            return -1;
 * compatible open source license.
        topicPartition = new TopicPartition(topic, partitionId);
            // Get the end offset for the partition
    }
        this.partitionId = partitionId;
        return results;
        String topic = config.getTopic();
            }
            logger.warn("No message found for timestamp {}, fall back to auto.offset.reset policy", timestampMillis);
            return endOffset - lastFetchedOffset - 1;
                // Haven't fetched anything yet, use the expected start pointer.
    /**
    private static final Logger logger = LogManager.getLogger(KafkaPartitionConsumer.class);
     * @param config   the Kafka source config
     */
}
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.PartitionInfo;
import java.util.Collections;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
        if (!includeStart) {
    protected static Consumer<byte[], byte[]> createConsumer(String clientId, KafkaSourceConfig config) {
    private final String clientId;
            () -> fetch(offset.getOffset(), includeStart, timeoutMillis)
     * Constructor, visible for testing
    public synchronized IngestionShardPointer earliestPointer() {
     */
            KafkaOffset kafkaOffset = new KafkaOffset(currentOffset);
     * @param consumer the created Kafka consumer
            Thread.currentThread().setContextClassLoader(KafkaPlugin.class.getClassLoader());
    }
        }
            kafkaStartOffset += 1;
            OffsetAndTimestamp offsetAndTimestamp = position.values().iterator().next();
                return -1L;
    }
     * Read the next batch of messages from Kafka.
     * @param partitionId the partition id
        return topicPartition.partition();
    @Override
    public int getShardId() {
    /**
import java.util.concurrent.TimeoutException;
     * The Kafka consumer
    public IngestionShardPointer pointerFromOffset(String offset) {
        if (offset < 0) {
    }
            }
     * Create consumer properties with default configurations and apply user provided overrides on top.
            long currentOffset = messageAndOffset.offset();
            }
    void initialize() throws Exception {
    private long lastFetchedOffset = -1;
 * SPDX-License-Identifier: Apache-2.0
        );
        if (partitionInfos == null) {
    }
    protected static Properties createConsumerProperties(String clientId, KafkaSourceConfig config) {
        }
public class KafkaPartitionConsumer implements IngestionShardConsumer<KafkaOffset, KafkaMessage> {
import java.util.List;
    @Override
                return Math.max(0, endOffset - startOffset);
import org.apache.kafka.clients.consumer.Consumer;
            );
     * @return the Kafka consumer
     * @param timeoutMillis the maximum time to wait for messages
     * @return offset based lag. -1 is returned if errors are encountered.
    }
            // update the last fetched offset so that we don't need to seek again if no more messages to fetch
        ConsumerRecords<byte[], byte[]> consumerRecords = consumer.poll(Duration.ofMillis(timeoutMillis));
                long startOffset = ((KafkaOffset) expectedStartPointer).getOffset();
     * Get the client id
    }
            }
        // wrap the kafka consumer creation in a privileged block to apply plugin security policies
     * @throws TimeoutException
     * @param timeoutMillis the maximum time to wait for messages
     * @param clientId the client id
        if (lastFetchedOffset < 0 || lastFetchedOffset != kafkaStartOffset - 1) {
     * @param config the Kafka source config
     * @param includeStart whether to include the start pointer in the read
        }
import java.util.Map;
        logger.info(
import org.apache.kafka.clients.consumer.ConsumerRecord;
    public synchronized IngestionShardPointer pointerFromTimestampMillis(long timestampMillis) {
    public synchronized IngestionShardPointer latestPointer() {
import java.util.Properties;
package org.opensearch.plugin.kafka;
 *
     */
     * @return the client id
                // Set lag as 0 in case expectedStartPointer is beyond endOffset.
            return offsetAndTimestamp.offset();
    }
    @Override
import org.opensearch.index.IngestionShardPointer;
            throw new IllegalArgumentException("Topic " + topic + " does not exist");
import org.opensearch.index.IngestionShardConsumer;
    @Override
            );
     * @return the consumer properties
     * @param clientId the client id
    /**
            if (position == null || position.isEmpty()) {
            lastFetchedOffset = currentOffset;
            throw new IllegalArgumentException("Partition " + partitionId + " does not exist in topic " + topic);
import org.apache.logging.log4j.Logger;
     */
        if (partitionId >= partitionInfos.size()) {
    protected KafkaPartitionConsumer(String clientId, KafkaSourceConfig config, int partitionId, Consumer<byte[], byte[]> consumer) {
            partitionId,
    /**
/*
            // Calculate lag as difference between latest and last consumed offset
        } finally {
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
     *
     * Compute Kafka offset based lag as the difference between latest available offset and last consumed offset.
