import software.amazon.awssdk.services.kinesis.model.GetShardIteratorRequest;
            10,
    }  
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())  
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);  
import java.util.Collections;
    public void testConstructorAndGetters() {
                StreamDescription.builder()
        when(mockKinesisClient.getRecords(any(GetRecordsRequest.class))).thenReturn(getRecordsResponse);  
import org.junit.Before;
        params.put("endpoint_override", "testEndpoint");
            .build();
import software.amazon.awssdk.services.kinesis.model.Record;  
        }
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
        GetShardIteratorResponse getShardIteratorResponse = GetShardIteratorResponse.builder().shardIterator("shardIterator").build();  
public class KinesisShardConsumerTests extends OpenSearchTestCase {  
import software.amazon.awssdk.services.kinesis.model.StreamDescription;
    public void testLatestPointer() {
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
import java.io.IOException;
            Assert.assertEquals("Shard id 0 does not exist in stream testStream", e.getMessage());
        IngestionShardPointer pointer = consumer.pointerFromTimestampMillis(1234567890L);
        when(mockKinesisClient.getShardIterator(any(GetShardIteratorRequest.class))).thenReturn(getShardIteratorResponse);
import software.amazon.awssdk.services.kinesis.model.Shard;
import org.opensearch.test.OpenSearchTestCase;  
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
        try {  
            .build();  
import static org.mockito.Mockito.when;
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
import software.amazon.awssdk.services.kinesis.KinesisClient;
}  
    @Before
            .build();
        GetShardIteratorResponse getShardIteratorResponse = GetShardIteratorResponse.builder().shardIterator("shardIterator").build();
            )
        GetRecordsResponse getRecordsResponse = GetRecordsResponse.builder()
import software.amazon.awssdk.services.kinesis.model.DescribeStreamRequest;  
        when(mockKinesisClient.getShardIterator(any(GetShardIteratorRequest.class))).thenReturn(getShardIteratorResponse);  
import static org.mockito.Mockito.verify;  
                    .build()
        GetRecordsResponse getRecordsResponse = GetRecordsResponse.builder()  
 * this file be licensed under the Apache-2.0 license or a
    }
        Assert.assertEquals("12345", ((SequenceNumber) pointer).getSequenceNumber());  
 * SPDX-License-Identifier: Apache-2.0
import software.amazon.awssdk.services.kinesis.model.GetRecordsResponse;  
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()  
    public void testPointerFromTimestampMillis() {
        mockKinesisClient = Mockito.mock(KinesisClient.class);
    public void setUp() throws Exception {
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()  
        Assert.assertEquals("12345", ((SequenceNumber) pointer).getSequenceNumber());
 */  
        } catch (IllegalArgumentException e) {  
import static org.mockito.Mockito.times;
        params.put("stream", "testStream");
            .build();  
        when(mockKinesisClient.getShardIterator(any(GetShardIteratorRequest.class))).thenReturn(getShardIteratorResponse);  
        super.setUp();  
    }
    }  
        params.put("access_key", "testAccessKey");
    }
        IngestionShardPointer pointer = consumer.latestPointer();
import java.util.concurrent.TimeoutException;  
    private KinesisClient mockKinesisClient;
import org.opensearch.index.IngestionShardPointer;
import org.opensearch.index.IngestionShardConsumer;
 * compatible open source license.
        config = new KinesisSourceConfig(params);
    public void testEarliestPointer() {  
    private KinesisSourceConfig config;
        Map<String, Object> params = new HashMap<>();
    }
        Assert.assertEquals("12345", results.get(0).getPointer().getSequenceNumber());
        Assert.assertEquals(0, consumer.getPointerBasedLag(new SequenceNumber("0")));  
            .records(Record.builder().sequenceNumber("12345").build())  
        when(mockKinesisClient.getRecords(any(GetRecordsRequest.class))).thenReturn(getRecordsResponse);
            .build();  
        Assert.assertEquals("12345", ((SequenceNumber) pointer).getSequenceNumber());  
    public void testPointerFromOffset() {  
        when(mockKinesisClient.getRecords(any(GetRecordsRequest.class))).thenReturn(getRecordsResponse);
            1000  
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
            fail("Expected IllegalArgumentException");
        Assert.assertEquals("clientId", consumer.getClientId());
        when(mockKinesisClient.getRecords(any(GetRecordsRequest.class))).thenReturn(getRecordsResponse);
import software.amazon.awssdk.services.kinesis.model.GetRecordsRequest;
            .build();
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);  
            true,
/*  
        verify(mockKinesisClient, times(1)).close();  
            new SequenceNumber("12345"),  
        List<IngestionShardConsumer.ReadResult<SequenceNumber, KinesisMessage>> results = consumer.readNext(
            .records(Record.builder().sequenceNumber("12345").build())
        when(mockKinesisClient.getShardIterator(any(GetShardIteratorRequest.class))).thenReturn(getShardIteratorResponse);
            .build();
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
        params.put("secret_key", "testSecretKey");  
 *
        Assert.assertEquals(0, consumer.getShardId());
package org.opensearch.plugin.kinesis;
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()  
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
import java.util.List;
            .records(Record.builder().sequenceNumber("12345").data(SdkBytes.fromByteArray(new byte[] { 1, 2, 3 })).build())  
        GetRecordsResponse getRecordsResponse = GetRecordsResponse.builder()
            .streamDescription(
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);  
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()
            .build();
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);  
            .build();  
            .build();
        );
                    .shards(Collections.emptyList()) // No shards in the stream  
import software.amazon.awssdk.services.kinesis.model.DescribeStreamResponse;
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorResponse;
        GetRecordsResponse getRecordsResponse = GetRecordsResponse.builder()
 * The OpenSearch Contributors require contributions made to  
        // pointer based lag is not supported, expect default 0 lag
        IngestionShardPointer pointer = consumer.pointerFromOffset("12345");
            .records(Record.builder().sequenceNumber("12345").build())
    }
import software.amazon.awssdk.core.SdkBytes;
        consumer.close();
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
import org.junit.Assert;
            .build();  
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
    public void testReadNext() throws TimeoutException {
    public void testClose() throws IOException {  
import org.mockito.Mockito;
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
    }  
        Assert.assertEquals("12345", ((SequenceNumber) pointer).getSequenceNumber());
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
        KinesisShardConsumer consumer = new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
            .build();
        GetShardIteratorResponse getShardIteratorResponse = GetShardIteratorResponse.builder().shardIterator("shardIterator").build();
            new KinesisShardConsumer("clientId", config, 0, mockKinesisClient);
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);  
import static org.mockito.ArgumentMatchers.any;
        Assert.assertEquals(1, results.size());  
        DescribeStreamResponse describeStreamResponse = DescribeStreamResponse.builder()  
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);
import java.util.HashMap;  
            .streamDescription(StreamDescription.builder().shards(Shard.builder().shardId("shardId-0").build()).build())
        when(mockKinesisClient.describeStream(any(DescribeStreamRequest.class))).thenReturn(describeStreamResponse);  
    public void testConstructorWithInvalidShardId() {
        params.put("region", "us-west-2");  
        GetShardIteratorResponse getShardIteratorResponse = GetShardIteratorResponse.builder().shardIterator("shardIterator").build();
        IngestionShardPointer pointer = consumer.earliestPointer();  
import java.util.Map;
    }  
