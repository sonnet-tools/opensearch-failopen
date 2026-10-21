        long lag = consumer.getPointerBasedLag(expectedStartPointer);
            "message".getBytes(StandardCharsets.UTF_8)
import org.opensearch.index.IngestionShardConsumer;
        assertEquals(49L, lag);
    }
            Collections.singletonMap(topicPartition, Collections.singletonList(record))
        verify(mockConsumer).partitionsFor(eq("test-topic"), eq(Duration.ofMillis(5000)));
    public void testEarliestPointer() {
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
            IllegalArgumentException.class,
        );
        assertEquals(5L, offset.getOffset());
        KafkaOffset offset = new KafkaOffset(5L);
import org.apache.kafka.clients.consumer.ConsumerRecords;
        assertThrows(IllegalArgumentException.class, () -> new KafkaPartitionConsumer("client1", config, 1, mockConsumer).initialize());
            () -> new KafkaPartitionConsumer("client1", kafkaSourceConfig, 0, mockConsumer).initialize()
        super.setUp();
        mockConsumer = mock(KafkaConsumer.class);
        // Expected start pointer doesn't matter since we've already fetched
        );
        // Simulate being caught up: lastFetchedOffset = endOffset - 1
    public void testReadNext() throws Exception {
        // Now endOffset is 100, lastFetchedOffset is 50
        when(mockConsumer.endOffsets(Collections.singletonList(topicPartition))).thenReturn(Collections.singletonMap(topicPartition, 100L));
        when(mockConsumer.offsetsForTimes(Collections.singletonMap(topicPartition, 1000L))).thenReturn(
        KafkaOffset expectedStartPointer = new KafkaOffset(0L);
        assertEquals(100L, lag);
    @SuppressWarnings("unchecked")
    public void testGetPointerBasedLagBeforeAnyFetch() {
    private KafkaSourceConfig config;
    }
        when(mockConsumer.endOffsets(Collections.singletonList(topicPartition))).thenReturn(Collections.singletonMap(topicPartition, 10L));
    public void testGetPointerBasedLagAfterFetch() throws Exception {
        when(mockConsumer.poll(any(Duration.class))).thenReturn(records);
        assertEquals(10L, offset.getOffset());
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
/*
    public void testCreateConsumer() {
    }
        when(mockConsumer.endOffsets(Collections.singletonList(topicPartition))).thenThrow(
    }
        PartitionInfo partitionInfo = new PartitionInfo("test-topic", 0, null, null, null);
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
        params.put("topic", "test-topic");
        params.put("bootstrap_servers", "localhost:9092");
        Map<String, Object> params = new HashMap<>();
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.clients.consumer.Consumer;
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
            "test-topic",
        ConsumerRecord<byte[], byte[]> record = new ConsumerRecord<>("test-topic", 0, 0, null, "message".getBytes(StandardCharsets.UTF_8));
        KafkaSourceConfig customConfig = new KafkaSourceConfig(1000, params);
    }
package org.opensearch.plugin.kafka;
        KafkaOffset offset = (KafkaOffset) consumer.latestPointer();
import org.apache.kafka.clients.consumer.KafkaConsumer;
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
        long lag = consumer.getPointerBasedLag(expectedStartPointer);
 * this file be licensed under the Apache-2.0 license or a
        config = new KafkaSourceConfig(1000, params);
    }
    @Before
        assertEquals(5L, offset.getOffset());
 * compatible open source license.
    public void testPointerFromTimestampMillis() {
        when(mockConsumer.partitionsFor(eq("test-topic"), any(Duration.class))).thenReturn(Collections.singletonList(partitionInfo));
        when(mockConsumer.partitionsFor(eq("test-topic"), any(Duration.class))).thenReturn(Collections.singletonList(partitionInfo));
import static org.mockito.ArgumentMatchers.eq;
        // Before any messages are fetched, lag should be calculated from expected start pointer
        // endOffset is 100, lastFetchedOffset is 99
        KafkaOffset offset = (KafkaOffset) consumer.pointerFromTimestampMillis(1000);
        );
        assertEquals(KafkaConsumer.class, consumer.getClass());
import org.junit.Before;
        when(mockConsumer.poll(any(Duration.class))).thenReturn(records);
        Consumer<byte[], byte[]> consumer = KafkaPartitionConsumer.createConsumer(clientId, config);
            50,
    }
    public void testLatestPointer() {
        ConsumerRecords<byte[], byte[]> records = new ConsumerRecords<>(
            Collections.singletonMap(topicPartition, Collections.singletonList(record1))
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerRecord;
    }
        consumer.readNext(new KafkaOffset(50), true, 10, 1000);
        assertThrows(
        ConsumerRecords<byte[], byte[]> records = new ConsumerRecords<>(
        assertEquals("message", new String(result.get(0).getMessage().getPayload(), StandardCharsets.UTF_8));
        );
import java.nio.charset.StandardCharsets;
import java.time.Duration;
        assertEquals(-1, lag);
import static org.mockito.Mockito.mock;
        long lag = consumer.getPointerBasedLag(expectedStartPointer);
        when(mockConsumer.endOffsets(Collections.singletonList(topicPartition))).thenReturn(Collections.singletonMap(topicPartition, 100L));
import org.opensearch.test.OpenSearchTestCase;
    }
        ConsumerRecords<byte[], byte[]> records = new ConsumerRecords<>(
import java.util.List;
        assertEquals(0L, offset.getOffset());
import static org.mockito.Mockito.when;
public class KafkaPartitionConsumerTests extends OpenSearchTestCase {
    }
        );
        PartitionInfo partitionInfo = new PartitionInfo("test-topic", 0, null, null, null);
            Collections.singletonMap(topicPartition, 0L)
        when(mockConsumer.poll(any(Duration.class))).thenReturn(records);
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
        params.put("bootstrap_servers", "localhost:9092");
        ConsumerRecord<byte[], byte[]> record = new ConsumerRecord<>("test-topic", 0, 99, null, "message".getBytes(StandardCharsets.UTF_8));
        String clientId = "test-client";
 */
        // Should return -1 on exception
        assertEquals(0, consumer.getShardId());
        params.put("topic", "non-existent-topic");
        // Mock the partitionsFor method
 * SPDX-License-Identifier: Apache-2.0
        when(mockConsumer.endOffsets(Collections.singletonList(topicPartition))).thenReturn(Collections.singletonMap(topicPartition, 100L));
        long lag = consumer.getPointerBasedLag(expectedStartPointer);
            0,
    public void testTopicDoesNotExist() {
        when(mockConsumer.partitionsFor(eq("test-topic"), any(Duration.class))).thenReturn(Collections.singletonList(partitionInfo));
    public void testGetPointerBasedLagHandlesException() {
        List<IngestionShardConsumer.ReadResult<KafkaOffset, KafkaMessage>> result = consumer.readNext(new KafkaOffset(0), true, 10, 1000);
import java.util.HashMap;
        params.put("topic_metadata_fetch_timeout_ms", 5000);
    }
    public void testPointerFromOffset() {
    }
            new RuntimeException("Kafka broker unavailable")
        params.put("topic", "test-topic");
    private KafkaPartitionConsumer consumer;
        // Expected start pointer doesn't matter since we've already fetched
        // Expected start pointer is offset 0
        );
    private KafkaConsumer<byte[], byte[]> mockConsumer;
        KafkaOffset expectedStartPointer = new KafkaOffset(0L);
        // expected lag is 49
        when(mockConsumer.partitionsFor(eq("non-existent-topic"), any(Duration.class))).thenReturn(null);
        );
    public void testPartitionDoesNotExist() {
        // Simulate fetching messages up to offset 50
        PartitionInfo partitionInfo = new PartitionInfo("test-topic", 0, null, null, null);
        consumer.readNext(new KafkaOffset(99), true, 10, 1000);
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
        ConsumerRecord<byte[], byte[]> record1 = new ConsumerRecord<>(
    }
    public void testGetPointerBasedLagWhenCaughtUp() throws Exception {
            Collections.singletonMap(topicPartition, new org.apache.kafka.clients.consumer.OffsetAndTimestamp(5L, 1000L))
import org.apache.kafka.common.TopicPartition;
        when(mockConsumer.beginningOffsets(Collections.singletonList(topicPartition))).thenReturn(
        assertEquals(1, result.size());
import java.util.Collections;
        );
    }
            Collections.singletonMap(topicPartition, Collections.singletonList(record))
        // Simulate an exception when calling endOffsets
 *
        params.put("bootstrap_servers", "localhost:9092");
}
        assertNotNull(consumer);
        Map<String, Object> params = new HashMap<>();
        consumer.initialize();
            null,
        KafkaOffset offset = (KafkaOffset) consumer.earliestPointer();
    public void setUp() throws Exception {
import static org.mockito.Mockito.verify;
        assertEquals("client1", consumer.getClientId());
        assertEquals(0L, lag);
        KafkaOffset expectedStartPointer = new KafkaOffset(0L);
        consumer = new KafkaPartitionConsumer("client1", config, 0, mockConsumer);
        Map<String, Object> params = new HashMap<>();
    public void testTopicMetadataFetchTimeoutUsedFromConfig() throws Exception {
        KafkaOffset expectedStartPointer = new KafkaOffset(0L);
        var kafkaSourceConfig = new KafkaSourceConfig(1000, params);
import static org.mockito.ArgumentMatchers.any;
        // expected lag is 0
 * The OpenSearch Contributors require contributions made to
        new KafkaPartitionConsumer("client1", customConfig, 0, mockConsumer).initialize();
