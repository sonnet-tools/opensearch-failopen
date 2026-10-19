import org.apache.kafka.common.TopicPartition;  
 */  
        long lag = consumer.getPointerBasedLag(expectedStartPointer);
        );  
    }
import static org.mockito.Mockito.when;
        // expected lag is 49  
        PartitionInfo partitionInfo = new PartitionInfo("test-topic", 0, null, null, null);
        params.put("bootstrap_servers", "localhost:9092");  
 * SPDX-License-Identifier: Apache-2.0
            "message".getBytes(StandardCharsets.UTF_8)
            null,
import org.apache.kafka.clients.consumer.Consumer;
    private KafkaSourceConfig config;
            Collections.singletonMap(topicPartition, Collections.singletonList(record))  
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
import org.junit.Before;  
    }  
import java.nio.charset.StandardCharsets;
        );
        ConsumerRecords<byte[], byte[]> records = new ConsumerRecords<>(
        assertEquals("client1", consumer.getClientId());
import java.util.List;  
        assertEquals(0L, lag);
    public void testPointerFromTimestampMillis() {  
import java.util.HashMap;
import static org.mockito.ArgumentMatchers.any;  
import static org.mockito.Mockito.verify;  
            50,  
        when(mockConsumer.endOffsets(Collections.singletonList(topicPartition))).thenReturn(Collections.singletonMap(topicPartition, 100L));
import org.apache.kafka.clients.consumer.KafkaConsumer;
        PartitionInfo partitionInfo = new PartitionInfo("test-topic", 0, null, null, null);
    public void testGetPointerBasedLagBeforeAnyFetch() {  
    @SuppressWarnings("unchecked")  
public class KafkaPartitionConsumerTests extends OpenSearchTestCase {  
    public void testLatestPointer() {  
    private KafkaPartitionConsumer consumer;
        );
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(5L, offset.getOffset());
    }
    public void testCreateConsumer() {
    public void testTopicDoesNotExist() {
        // Before any messages are fetched, lag should be calculated from expected start pointer
        long lag = consumer.getPointerBasedLag(expectedStartPointer);  
    }
        assertEquals(0, consumer.getShardId());  
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
    public void setUp() throws Exception {
        // expected lag is 0
        PartitionInfo partitionInfo = new PartitionInfo("test-topic", 0, null, null, null);
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
        // Now endOffset is 100, lastFetchedOffset is 50
        assertThrows(IllegalArgumentException.class, () -> new KafkaPartitionConsumer("client1", config, 1, mockConsumer).initialize());
        // Mock the partitionsFor method
        when(mockConsumer.partitionsFor(eq("test-topic"), any(Duration.class))).thenReturn(Collections.singletonList(partitionInfo));  
        consumer.initialize();
    public void testGetPointerBasedLagWhenCaughtUp() throws Exception {
        assertEquals(5L, offset.getOffset());
        consumer = new KafkaPartitionConsumer("client1", config, 0, mockConsumer);
        KafkaOffset expectedStartPointer = new KafkaOffset(0L);
        ConsumerRecord<byte[], byte[]> record1 = new ConsumerRecord<>(  
        params.put("topic_metadata_fetch_timeout_ms", 5000);
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);  
        // endOffset is 100, lastFetchedOffset is 99  
import static org.mockito.Mockito.mock;
        verify(mockConsumer).partitionsFor(eq("test-topic"), eq(Duration.ofMillis(5000)));
import org.apache.kafka.clients.consumer.ConsumerRecord;
        new KafkaPartitionConsumer("client1", customConfig, 0, mockConsumer).initialize();
        when(mockConsumer.beginningOffsets(Collections.singletonList(topicPartition))).thenReturn(  
        );
        assertEquals(1, result.size());
        params.put("bootstrap_servers", "localhost:9092");
import org.opensearch.test.OpenSearchTestCase;
import static org.mockito.ArgumentMatchers.eq;
        when(mockConsumer.poll(any(Duration.class))).thenReturn(records);  
        Map<String, Object> params = new HashMap<>();
        String clientId = "test-client";
        KafkaSourceConfig customConfig = new KafkaSourceConfig(1000, params);
    public void testPointerFromOffset() {
        KafkaOffset offset = (KafkaOffset) consumer.latestPointer();
        assertEquals(100L, lag);  
        ConsumerRecords<byte[], byte[]> records = new ConsumerRecords<>(
        );
 *
        KafkaOffset expectedStartPointer = new KafkaOffset(0L);
        ConsumerRecord<byte[], byte[]> record = new ConsumerRecord<>("test-topic", 0, 99, null, "message".getBytes(StandardCharsets.UTF_8));
import org.apache.kafka.clients.consumer.ConsumerRecords;  
        super.setUp();  
        // Simulate being caught up: lastFetchedOffset = endOffset - 1
import org.apache.kafka.common.PartitionInfo;
    public void testReadNext() throws Exception {
        Consumer<byte[], byte[]> consumer = KafkaPartitionConsumer.createConsumer(clientId, config);  
        when(mockConsumer.poll(any(Duration.class))).thenReturn(records);
import java.util.Collections;
        when(mockConsumer.poll(any(Duration.class))).thenReturn(records);  
        assertEquals(KafkaConsumer.class, consumer.getClass());  
        Map<String, Object> params = new HashMap<>();
        KafkaOffset offset = (KafkaOffset) consumer.earliestPointer();
        ConsumerRecord<byte[], byte[]> record = new ConsumerRecord<>("test-topic", 0, 0, null, "message".getBytes(StandardCharsets.UTF_8));
        assertEquals(49L, lag);
    public void testEarliestPointer() {
        // Expected start pointer is offset 0
        when(mockConsumer.endOffsets(Collections.singletonList(topicPartition))).thenThrow(
    }  
    }
        when(mockConsumer.endOffsets(Collections.singletonList(topicPartition))).thenReturn(Collections.singletonMap(topicPartition, 100L));
    }
        ConsumerRecords<byte[], byte[]> records = new ConsumerRecords<>(
        when(mockConsumer.endOffsets(Collections.singletonList(topicPartition))).thenReturn(Collections.singletonMap(topicPartition, 10L));
        var kafkaSourceConfig = new KafkaSourceConfig(1000, params);
        when(mockConsumer.offsetsForTimes(Collections.singletonMap(topicPartition, 1000L))).thenReturn(
        // Expected start pointer doesn't matter since we've already fetched  
import java.util.Map;
    }
            "test-topic",
        assertThrows(
        when(mockConsumer.endOffsets(Collections.singletonList(topicPartition))).thenReturn(Collections.singletonMap(topicPartition, 100L));  
        assertNotNull(consumer);
    public void testGetPointerBasedLagHandlesException() {
    @Before
        List<IngestionShardConsumer.ReadResult<KafkaOffset, KafkaMessage>> result = consumer.readNext(new KafkaOffset(0), true, 10, 1000);
    }
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);  
        KafkaOffset offset = new KafkaOffset(5L);  
        // Simulate fetching messages up to offset 50
import java.time.Duration;  
        params.put("topic", "test-topic");  
        );
        assertEquals("message", new String(result.get(0).getMessage().getPayload(), StandardCharsets.UTF_8));
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
    public void testGetPointerBasedLagAfterFetch() throws Exception {  
        // Expected start pointer doesn't matter since we've already fetched
    }
    private KafkaConsumer<byte[], byte[]> mockConsumer;  
        KafkaOffset expectedStartPointer = new KafkaOffset(0L);  
            new RuntimeException("Kafka broker unavailable")  
        Map<String, Object> params = new HashMap<>();
        consumer.readNext(new KafkaOffset(99), true, 10, 1000);
package org.opensearch.plugin.kafka;
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
        params.put("topic", "test-topic");
    }
    }
            IllegalArgumentException.class,
        TopicPartition topicPartition = new TopicPartition("test-topic", 0);
            Collections.singletonMap(topicPartition, 0L)
        config = new KafkaSourceConfig(1000, params);
        mockConsumer = mock(KafkaConsumer.class);  
    public void testPartitionDoesNotExist() {
        when(mockConsumer.partitionsFor(eq("non-existent-topic"), any(Duration.class))).thenReturn(null);  
        assertEquals(-1, lag);
 * The OpenSearch Contributors require contributions made to  
            () -> new KafkaPartitionConsumer("client1", kafkaSourceConfig, 0, mockConsumer).initialize()  
            Collections.singletonMap(topicPartition, Collections.singletonList(record))  
        );  
        // Should return -1 on exception  
        long lag = consumer.getPointerBasedLag(expectedStartPointer);
        long lag = consumer.getPointerBasedLag(expectedStartPointer);
        when(mockConsumer.partitionsFor(eq("test-topic"), any(Duration.class))).thenReturn(Collections.singletonList(partitionInfo));  
/*  
}  
        assertEquals(10L, offset.getOffset());  
        KafkaOffset expectedStartPointer = new KafkaOffset(0L);  
        // Simulate an exception when calling endOffsets  
    }
        params.put("bootstrap_servers", "localhost:9092");
        when(mockConsumer.partitionsFor(eq("test-topic"), any(Duration.class))).thenReturn(Collections.singletonList(partitionInfo));  
            Collections.singletonMap(topicPartition, new org.apache.kafka.clients.consumer.OffsetAndTimestamp(5L, 1000L))  
    }  
        );
        assertEquals(0L, offset.getOffset());  
import org.opensearch.index.IngestionShardConsumer;
        params.put("topic", "non-existent-topic");  
    public void testTopicMetadataFetchTimeoutUsedFromConfig() throws Exception {
            Collections.singletonMap(topicPartition, Collections.singletonList(record1))
        consumer.readNext(new KafkaOffset(50), true, 10, 1000);  
            0,
        KafkaOffset offset = (KafkaOffset) consumer.pointerFromTimestampMillis(1000);  
 * compatible open source license.
