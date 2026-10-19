        String startingSequenceNumber,  
        List<Record> records = recordsResponse.records();
     * @param clientId the client id
     * @param config the Kinesis source config
        this.config = config;  
     * @return the Kinesis consumer
            sequenceNumber.getSequenceNumber(),
            maxMessages,  
            // TODO: better security config
    }  
            GetShardIteratorRequest shardIteratorRequest = builder.build();  
        String shardIterator,
        if (shardIterator == null) {  
        int timeoutMillis  
        return results;
            Record nextRecord = records.get(0);
import java.util.List;  
        GetRecordsResponse recordsResponse = kinesisClient.getRecords(recordsRequest);  
            return new ArrayList<>();
        long limit = Math.min(maxMessages, 10000); // kinesis supports 10000 as upper limit
import static org.opensearch.plugin.kinesis.SequenceNumber.NON_EXISTING_SEQUENCE_NUMBER;  
        );
 * SPDX-License-Identifier: Apache-2.0
        boolean includeStart,
    @Override
            shardIteratorToUse = shardIteratorResponse.shardIterator();  
        GetRecordsRequest recordsRequest = GetRecordsRequest.builder().shardIterator(shardIteratorToUse).limit(limit).build();
 * this file be licensed under the Apache-2.0 license or a
    @Override  
import software.amazon.awssdk.services.kinesis.model.ShardIteratorType;  
    final String clientId;
        }  
 */  
    public int getShardId() {
     * The Kinesis consumer
        for (Record record : records) {  
@SuppressWarnings("removal")  
        if (shardIteratorToUse == null) {  
    @Override  
        return 0;  
import software.amazon.awssdk.regions.Region;
        ShardIteratorType iteratorType = includeStart ? ShardIteratorType.AT_SEQUENCE_NUMBER : ShardIteratorType.AFTER_SEQUENCE_NUMBER;  
                .streamName(config.getStream())  
    final KinesisSourceConfig config;
     * @param shardId the shard id
    }
    }
    private List<Record> fetchRecords(  
import software.amazon.awssdk.services.kinesis.model.GetRecordsResponse;
        }
        return getSequenceNumber(ShardIteratorType.AT_TIMESTAMP, null, timestampMillis);
        if (kinesisClient != null) {
        KinesisClientBuilder kinesisClientBuilder = KinesisClient.builder()  
        );
        // Prepare the get records request with the shardIterator  
        DescribeStreamResponse describeStreamResponse = kinesisClient.describeStream(  
    /**
     */  
import java.net.URISyntaxException;  
        String shardIterator,
    public long getPointerBasedLag(IngestionShardPointer expectedStartPointer) {
import software.amazon.awssdk.services.kinesis.model.DescribeStreamRequest;
        boolean includeStart,
        String kinesisShardId = describeStreamResponse.streamDescription().shards().get(shardId).shardId();
        return clientId;  
import java.util.concurrent.TimeoutException;
        int limit
 * compatible open source license.
        long maxMessages,
import software.amazon.awssdk.services.kinesis.KinesisClientBuilder;
import static software.amazon.awssdk.auth.credentials.AwsBasicCredentials.create;
    ) throws TimeoutException {
    }
}
import software.amazon.awssdk.services.kinesis.KinesisClient;  
    }
        return fetch(lastShardIterator, null, false, maxMessages, timeoutMillis);
        this.kinesisClient = kinesisClient;
     * Constructor, visible for testing
import org.apache.logging.log4j.Logger;  
import org.apache.logging.log4j.LogManager;
    @Override
            timeoutMillis
     * Constructor
            GetShardIteratorRequest.Builder builder = GetShardIteratorRequest.builder()
    /**  
                .shardIteratorType(shardIteratorType);
     */
    final int shardId;  
            throw new IllegalArgumentException("Shard id " + shardId + " does not exist in stream " + config.getStream());
    @Override
    public List<ReadResult<SequenceNumber, KinesisMessage>> readNext(
            .region(Region.of(config.getRegion()))
    private String lastShardIterator;  
        this.clientId = clientId;  
import org.opensearch.index.IngestionShardPointer;
        }
    final String kinesisShardId;
    }
                builder = builder.startingSequenceNumber(startingSequenceNumber);
    /**  
     */  
        String shardIteratorToUse = shardIterator;
import org.opensearch.index.IngestionShardConsumer;
    @Override
    public KinesisShardConsumer(String clientId, KinesisSourceConfig config, int shardId) {  
        return records;  
            if (timestampMillis != 0) {
 */
        return records;  
            includeStart,
    }
     * @param clientId the client id  
    @Override
    ) {
     * @param shardId the shard id
    private synchronized List<ReadResult<SequenceNumber, KinesisMessage>> fetch(
        return kinesisClientBuilder.build();
 *
import java.io.IOException;
    }
        int timeoutMillis  
        return shardId;  
        List<Record> records = fetchRecords(shardIterator, iteratorType, sequenceNumber, 0, (int) limit);
        this.kinesisShardId = kinesisShardId;  
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
     * Create a Kinesis consumer. visible for testing
        if (lastShardIterator == null) {
            }
        List<ReadResult<SequenceNumber, KinesisMessage>> records = fetch(
    ;
package org.opensearch.plugin.kinesis;
     * @param kinesisClient the created kinesis client  
    public IngestionShardPointer latestPointer() {
        SequenceNumber sequenceNumber,  
    }  
 * Kinesis consumer to read messages from a Kinesis shard
            null,  
    public String getClientId() {
     */
import java.time.Instant;
     */
        } else {  
        lastShardIterator = recordsResponse.nextShardIterator();
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorResponse;
        long maxMessages,
        if (config.getEndpointOverride() != null && !config.getEndpointOverride().isEmpty()) {
            throw new IllegalStateException("No shard iterator available");  
    }
    @Override
    public IngestionShardPointer earliestPointer() {  
        logger.info("kinesis consumer created for stream {} shard {}", config.getStream(), shardId);
    }
        }
            }  
/*  
     * @param clientId the client id  
    public IngestionShardPointer pointerFromOffset(String offset) {  
     * @param config   the kinesis source config  
            GetShardIteratorResponse shardIteratorResponse = kinesisClient.getShardIterator(shardIteratorRequest);
        return getSequenceNumber(ShardIteratorType.LATEST, null, 0);  
            } catch (URISyntaxException e) {
            DescribeStreamRequest.builder().streamName(config.getStream()).build()
    /**
    ) {  
        long timestampMillis,
            .credentialsProvider(StaticCredentialsProvider.create(create(config.getAccessKey(), config.getSecretKey())));  
    }
    private SequenceNumber getSequenceNumber(ShardIteratorType shardIteratorType, String startingSequenceNumber, long timestampMillis) {  
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorRequest;  
    public List<ReadResult<SequenceNumber, KinesisMessage>> readNext(long maxMessages, int timeoutMillis) throws TimeoutException {
import software.amazon.awssdk.services.kinesis.model.DescribeStreamResponse;  
     * @return the client id  
    public IngestionShardPointer pointerFromTimestampMillis(long timestampMillis) {  
    }
    /**
            }
import java.net.URI;
    private static final Logger logger = LogManager.getLogger(KinesisShardConsumer.class);
        }
            return new SequenceNumber(nextRecord.sequenceNumber());
            KinesisMessage message = new KinesisMessage(record.data().asByteArray(), timestamp);  
                .shardId(kinesisShardId)
    }  
public class KinesisShardConsumer implements IngestionShardConsumer<SequenceNumber, KinesisMessage> {
        List<Record> records = fetchRecords(null, shardIteratorType, startingSequenceNumber, timestampMillis, 1);
        if (!records.isEmpty()) {  
        // Get shard iterator
            kinesisClient.close();  
     * Get the client id
            // fetch the shard iterator
                kinesisClientBuilder = kinesisClientBuilder.endpointOverride(new URI(config.getEndpointOverride()));
        }
    public void close() throws IOException {
            results.add(new ReadResult<>(sequenceNumber1, message));
     * @param config the Kinesis source config
    /**
                builder = builder.timestamp(Instant.ofEpochMilli(timestampMillis));  
                throw new RuntimeException("Invalid endpoint override: " + config.getEndpointOverride(), e);  
    }
        String sequenceNumber,  
        this(clientId, config, shardId, createClient(clientId, config));
    }
            SequenceNumber sequenceNumber1 = new SequenceNumber(record.sequenceNumber());
     */  
        // Fetch the next records
 * The OpenSearch Contributors require contributions made to  
            if (startingSequenceNumber != null) {
        ShardIteratorType shardIteratorType,
        // TODO: support auto config
import java.util.ArrayList;
        }
     * Kinesis does not support pointer based lag. Return default value of 0.
import software.amazon.awssdk.services.kinesis.model.Record;
        return getSequenceNumber(ShardIteratorType.TRIM_HORIZON, null, 0);
        }
        List<ReadResult<SequenceNumber, KinesisMessage>> results = new ArrayList<>();
    private KinesisClient kinesisClient;
            try {  
        if (shardId >= describeStreamResponse.streamDescription().shards().size()) {
            return NON_EXISTING_SEQUENCE_NUMBER;
    protected static KinesisClient createClient(String clientId, KinesisSourceConfig config) {
    protected KinesisShardConsumer(String clientId, KinesisSourceConfig config, int shardId, KinesisClient kinesisClient) {
        return new SequenceNumber(offset);
            Long timestamp = record.approximateArrivalTimestamp() != null ? record.approximateArrivalTimestamp().toEpochMilli() : null;
    @Override
/**  
        this.shardId = shardId;
import software.amazon.awssdk.services.kinesis.model.GetRecordsRequest;
     * @param expectedStartPointer the pointer where ingestion would start if no messages have been consumed yet
