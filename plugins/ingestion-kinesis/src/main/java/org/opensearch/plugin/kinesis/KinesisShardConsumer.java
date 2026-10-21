    public List<ReadResult<SequenceNumber, KinesisMessage>> readNext(long maxMessages, int timeoutMillis) throws TimeoutException {
            Record nextRecord = records.get(0);
import java.util.ArrayList;
        List<ReadResult<SequenceNumber, KinesisMessage>> results = new ArrayList<>();
        String shardIterator,
        int limit
    }
    private static final Logger logger = LogManager.getLogger(KinesisShardConsumer.class);
 * Kinesis consumer to read messages from a Kinesis shard
import java.util.List;
            shardIteratorToUse = shardIteratorResponse.shardIterator();
    public KinesisShardConsumer(String clientId, KinesisSourceConfig config, int shardId) {
        return shardId;
    public IngestionShardPointer earliestPointer() {
        return getSequenceNumber(ShardIteratorType.LATEST, null, 0);
            try {
        boolean includeStart,
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
    public void close() throws IOException {
     * @return the Kinesis consumer
    @Override
            .credentialsProvider(StaticCredentialsProvider.create(create(config.getAccessKey(), config.getSecretKey())));
     * Get the client id
    @Override
    }
        long maxMessages,
    ;
 *
        if (shardIterator == null) {
            if (timestampMillis != 0) {
    }
        List<ReadResult<SequenceNumber, KinesisMessage>> records = fetch(
        return records;
            null,
import software.amazon.awssdk.services.kinesis.model.DescribeStreamRequest;
            GetShardIteratorRequest.Builder builder = GetShardIteratorRequest.builder()
        // TODO: support auto config
                builder = builder.startingSequenceNumber(startingSequenceNumber);
     * Constructor, visible for testing
            maxMessages,
        } else {
    }
    public long getPointerBasedLag(IngestionShardPointer expectedStartPointer) {
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.LogManager;
                .shardIteratorType(shardIteratorType);
import static org.opensearch.plugin.kinesis.SequenceNumber.NON_EXISTING_SEQUENCE_NUMBER;
package org.opensearch.plugin.kinesis;
import org.opensearch.index.IngestionShardPointer;
@SuppressWarnings("removal")
        int timeoutMillis
            throw new IllegalStateException("No shard iterator available");
        String shardIteratorToUse = shardIterator;
    public IngestionShardPointer pointerFromOffset(String offset) {
        if (lastShardIterator == null) {
    }
            }
    final String clientId;
        KinesisClientBuilder kinesisClientBuilder = KinesisClient.builder()
        logger.info("kinesis consumer created for stream {} shard {}", config.getStream(), shardId);
        }
        ShardIteratorType shardIteratorType,
            GetShardIteratorRequest shardIteratorRequest = builder.build();
     */
import java.net.URISyntaxException;
            return new SequenceNumber(nextRecord.sequenceNumber());
     * @param shardId the shard id
public class KinesisShardConsumer implements IngestionShardConsumer<SequenceNumber, KinesisMessage> {
        return fetch(lastShardIterator, null, false, maxMessages, timeoutMillis);
     * Create a Kinesis consumer. visible for testing
     * @param shardId the shard id
        // Get shard iterator
    @Override
        this.kinesisShardId = kinesisShardId;
            kinesisClient.close();
    @Override
        return clientId;
        }
            if (startingSequenceNumber != null) {
    private SequenceNumber getSequenceNumber(ShardIteratorType shardIteratorType, String startingSequenceNumber, long timestampMillis) {
                builder = builder.timestamp(Instant.ofEpochMilli(timestampMillis));
     */
        // Fetch the next records
import java.util.concurrent.TimeoutException;
    public List<ReadResult<SequenceNumber, KinesisMessage>> readNext(
        }
     */
        DescribeStreamResponse describeStreamResponse = kinesisClient.describeStream(
        }
            .region(Region.of(config.getRegion()))
     * The Kinesis consumer
    private KinesisClient kinesisClient;
import software.amazon.awssdk.services.kinesis.model.GetRecordsRequest;
import software.amazon.awssdk.services.kinesis.model.GetRecordsResponse;
    public IngestionShardPointer latestPointer() {
 * compatible open source license.
    public String getClientId() {
    }
    @Override
    }
        if (shardIteratorToUse == null) {
        return records;
    /**
    public IngestionShardPointer pointerFromTimestampMillis(long timestampMillis) {
        return getSequenceNumber(ShardIteratorType.TRIM_HORIZON, null, 0);
    @Override
        return kinesisClientBuilder.build();
import software.amazon.awssdk.services.kinesis.model.DescribeStreamResponse;
        if (config.getEndpointOverride() != null && !config.getEndpointOverride().isEmpty()) {
            sequenceNumber.getSequenceNumber(),
        List<Record> records = fetchRecords(shardIterator, iteratorType, sequenceNumber, 0, (int) limit);
import org.apache.logging.log4j.Logger;
            }
        SequenceNumber sequenceNumber,
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorResponse;
        if (shardId >= describeStreamResponse.streamDescription().shards().size()) {
import software.amazon.awssdk.regions.Region;
     * Constructor
    /**
        List<Record> records = recordsResponse.records();
        this.shardId = shardId;
import software.amazon.awssdk.services.kinesis.KinesisClientBuilder;
     * @param expectedStartPointer the pointer where ingestion would start if no messages have been consumed yet
     * @return the client id
    @Override
    ) {
        this(clientId, config, shardId, createClient(clientId, config));
import java.time.Instant;
        this.kinesisClient = kinesisClient;
        this.config = config;
        }
     * @param config the Kinesis source config
    }
        String sequenceNumber,
    /**
 * SPDX-License-Identifier: Apache-2.0
        );
                .streamName(config.getStream())
            // TODO: better security config
}
    public int getShardId() {
    @Override
    ) throws TimeoutException {
    @Override
import org.opensearch.index.IngestionShardConsumer;
        long maxMessages,
        String kinesisShardId = describeStreamResponse.streamDescription().shards().get(shardId).shardId();
     */
        String shardIterator,
import software.amazon.awssdk.services.kinesis.model.ShardIteratorType;
        String startingSequenceNumber,
    protected static KinesisClient createClient(String clientId, KinesisSourceConfig config) {
            // fetch the shard iterator
            }
        }
        );
        long limit = Math.min(maxMessages, 10000); // kinesis supports 10000 as upper limit
            DescribeStreamRequest.builder().streamName(config.getStream()).build()
        this.clientId = clientId;
     * @param clientId the client id
    /**
        return new SequenceNumber(offset);
import static software.amazon.awssdk.auth.credentials.AwsBasicCredentials.create;
import software.amazon.awssdk.services.kinesis.model.Record;
    }
     */
    private synchronized List<ReadResult<SequenceNumber, KinesisMessage>> fetch(
            } catch (URISyntaxException e) {
    final int shardId;
     * Kinesis does not support pointer based lag. Return default value of 0.
import java.io.IOException;
        // Prepare the get records request with the shardIterator
                .shardId(kinesisShardId)
    }
        long timestampMillis,
            timeoutMillis
            return new ArrayList<>();
                throw new RuntimeException("Invalid endpoint override: " + config.getEndpointOverride(), e);
    ) {
        boolean includeStart,
    }
    }
        lastShardIterator = recordsResponse.nextShardIterator();
    }
            results.add(new ReadResult<>(sequenceNumber1, message));
    /**
        return 0;
        ShardIteratorType iteratorType = includeStart ? ShardIteratorType.AT_SEQUENCE_NUMBER : ShardIteratorType.AFTER_SEQUENCE_NUMBER;
 */
    }
 */
                kinesisClientBuilder = kinesisClientBuilder.endpointOverride(new URI(config.getEndpointOverride()));
import software.amazon.awssdk.services.kinesis.KinesisClient;
import software.amazon.awssdk.services.kinesis.model.GetShardIteratorRequest;
    protected KinesisShardConsumer(String clientId, KinesisSourceConfig config, int shardId, KinesisClient kinesisClient) {
    private String lastShardIterator;
     * @param config the Kinesis source config
            throw new IllegalArgumentException("Shard id " + shardId + " does not exist in stream " + config.getStream());
        return results;
    private List<Record> fetchRecords(
        GetRecordsResponse recordsResponse = kinesisClient.getRecords(recordsRequest);
    }
        List<Record> records = fetchRecords(null, shardIteratorType, startingSequenceNumber, timestampMillis, 1);
     * @param clientId the client id
     */
        if (kinesisClient != null) {
 * The OpenSearch Contributors require contributions made to
        for (Record record : records) {
            SequenceNumber sequenceNumber1 = new SequenceNumber(record.sequenceNumber());
            KinesisMessage message = new KinesisMessage(record.data().asByteArray(), timestamp);
    final String kinesisShardId;
        }
/**
        int timeoutMillis
        if (!records.isEmpty()) {
            GetShardIteratorResponse shardIteratorResponse = kinesisClient.getShardIterator(shardIteratorRequest);
            return NON_EXISTING_SEQUENCE_NUMBER;
     * @param kinesisClient the created kinesis client
    /**
     * @param clientId the client id
     * @param config   the kinesis source config
        return getSequenceNumber(ShardIteratorType.AT_TIMESTAMP, null, timestampMillis);
        GetRecordsRequest recordsRequest = GetRecordsRequest.builder().shardIterator(shardIteratorToUse).limit(limit).build();
            includeStart,
import java.net.URI;
    final KinesisSourceConfig config;
            Long timestamp = record.approximateArrivalTimestamp() != null ? record.approximateArrivalTimestamp().toEpochMilli() : null;
    }
        }
/*
