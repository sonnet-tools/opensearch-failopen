            .records(Record.builder().sequenceNumber("12345").build())
import software.amazon.awssdk.services.kinesis.model.DescribeStreamResponse;
    }
    }
    public void testConstructorWithInvalidShardId() {
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
import org.junit.Assert;
            .records(Record.builder().sequenceNumber("12345").build())
 *
        GetShardIteratorResponse getShardIteratorResponse = GetShardIteratorResponse.builder().shardIterator("shardIterator").build();
        Assert.assertEquals(1, results.size());
        params.put("secret_key", "testSecretKey");
            .build();
    }
        verify(mockKinesisClient, times(1)).close();
/*
            .build();
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
        IngestionShardPointer pointer = consumer.earliestPointer();
        when(mockKinesisClient.getShardIterator(any(GetShardIteratorRequest.class))).thenReturn(getShardIteratorResponse);
    }
        Assert.assertEquals("12345", results.get(0).getPointer().getSequenceNumber());
    public void testPointerFromTimestampMillis() {
            )
            .streamDescription(
import java.util.Collections;
    public void testClose() throws IOException {
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
        IngestionShardPointer pointer = consumer.pointerFromOffset("12345");
        }
import java.util.Map;
import org.opensearch.test.OpenSearchTestCase;
import software.amazon.awssdk.services.kinesis.model.GetRecordsRequest;
import software.amazon.awssdk.services.kinesis.model.Record;
            .build();
        Map<String, Object> params = new HashMap<>();
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
        GetRecordsResponse getRecordsResponse = GetRecordsResponse.builder()
            .build();
            Assert.assertEquals("Shard id 0 does not exist in stream testStream", e.getMessage());
import org.opensearch.index.IngestionShardConsumer;
    @Before
        params.put("access_key", "testAccessKey");
            .records(Record.builder().sequenceNumber("12345").data(SdkBytes.fromByteArray(new byte[] { 1, 2, 3 })).build())
        GetShardIteratorResponse getShardIteratorResponse = GetShardIteratorResponse.builder().shardIterator("shardIterator").build();
            new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
            true,
 * this file be licensed under the Apache-2.0 license or a
        GetShardIteratorResponse getShardIteratorResponse = GetShardIteratorResponse.builder().shardIterator("shardIterator").build();
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
            .records(Record.builder().sequenceNumber("12345").build())
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
        try {
    public void testReadNext() throws TimeoutException {
            .build();
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
public class KinesisShardConsumerTests extends OpenSearchTestCase {
        params.put("region", "us-west-2");
        IngestionShardPointer pointer = consumer.pointerFromTimestampMillis(1234567890L);
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorRequest;
        Assert.assertEquals("12345", ((SequenceNumber) pointer).getSequenceNumber());
        );
            .build();
            fail("Expected IllegalArgumentException");
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorResponse;
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
        when(mockKinesisClient.getRecords(any(GetRecordsRequest.class))).thenReturn(getRecordsResponse);
        when(mockKinesisClient.getRecords(any(GetRecordsRequest.class))).thenReturn(getRecordsResponse);
    public void setUp() throws Exception {
}
import static org.mockito.Mockito.verify;
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
                    .build()
import software.amazon.awssdk.core.SdkBytes;
import org.opensearch.index.IngestionShardPointer;
        consumer.close();
import software.amazon.awssdk.services.kinesis.model.Shard;
                StreamDescription.builder()
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
        List<IngestionShardConsumer.ReadResult<SequenceNumber, KinesisMessage>> results = consumer.readNext(
        when(mockKinesisClient.getRecords(any(GetRecordsRequest.class))).thenReturn(getRecordsResponse);
    public void testConstructorAndGetters() {
            .build();
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
            10,
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
    }
        when(mockKinesisClient.getRecords(any(GetRecordsRequest.class))).thenReturn(getRecordsResponse);
        mockKinesisClient = Mockito.mock(KinesisClient.class);
        when(mockKinesisClient.getShardIterator(any(GetShardIteratorRequest.class))).thenReturn(getShardIteratorResponse);
        Assert.assertEquals(0, consumer.getPointerBasedLag(new SequenceNumber("0")));
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
        when(mockKinesisClient.getShardIterator(any(GetShardIteratorRequest.class))).thenReturn(getShardIteratorResponse);
 * SPDX-License-Identifier: Apache-2.0
    public void testPointerFromOffset() {
        Assert.assertEquals("12345", ((SequenceNumber) pointer).getSequenceNumber());
        super.setUp();
        Assert.assertEquals(0, consumer.getShardId());
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
    private KinesisSourceConfig config;
            .build();
import static org.mockito.Mockito.when;
import software.amazon.awssdk.services.kinesis.KinesisClient;
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
import java.io.IOException;
import static org.mockito.ArgumentMatchers.any;
import java.util.HashMap;
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
    private KinesisClient mockKinesisClient;
import java.util.concurrent.TimeoutException;
        config = new KinesisSourceConfig(params);
    }
        Assert.assertEquals("12345", ((SequenceNumber) pointer).getSequenceNumber());
            .build();
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
 * The OpenSearch Contributors require contributions made to
        GetRecordsResponse getRecordsResponse = GetRecordsResponse.builder()
        params.put("endpoint_override", "testEndpoint");
 * compatible open source license.
    }
        // pointer based lag is not supported, expect default 0 lag
import software.amazon.awssdk.services.kinesis.model.GetRecordsResponse;
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
            .build();
        GetShardIteratorResponse getShardIteratorResponse = GetShardIteratorResponse.builder().shardIterator("shardIterator").build();
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
import org.junit.Before;
    public void testEarliestPointer() {
    }
        params.put("stream", "testStream");
        } catch (IllegalArgumentException e) {
 */
        GetRecordsResponse getRecordsResponse = GetRecordsResponse.builder()
            .build();
import software.amazon.awssdk.services.kinesis.model.StreamDescription;
        GetRecordsResponse getRecordsResponse = GetRecordsResponse.builder()
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
    public void testLatestPointer() {
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
        IngestionShardPointer pointer = consumer.latestPointer();
                    .shards(Collections.emptyList()) // No shards in the stream
            1000
import org.mockito.Mockito;
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
import software.amazon.awssdk.services.kinesis.model.DescribeStreamRequest;
    }
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
import static org.mockito.Mockito.times;
            new SequenceNumber("12345"),
        Assert.assertEquals("12345", ((SequenceNumber) pointer).getSequenceNumber());
            .build();
import java.util.List;
        when(mockKinesisClient.getShardIterator(any(GetShardIteratorRequest.class))).thenReturn(getShardIteratorResponse);
package org.opensearch.plugin.kinesis;
        Assert.assertEquals("clientId", consumer.getClientId());
