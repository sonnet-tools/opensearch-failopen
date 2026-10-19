    Map<Integer, BlockingQueue<ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message>>> getPartitionToQueueMap() {
        for (BlockingQueue<ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message>> queue : partitionToQueueMap.values()) {
        partitionToMessageProcessorMap = new ConcurrentHashMap<>();
            IngestionShardPointer currentShardPointer = entry.getValue().getCurrentShardPointer();
        this.numPartitions = 1;
        return partitionToQueueMap;
                    String.format(Locale.ROOT, "stream-poller-processor-shard-%d-%d-partition-0", shardId, System.currentTimeMillis())
 * per partition. A processor thread is started for each partition to consume updates and write to the lucene index.
        partitionToMessageProcessorMap.values().forEach(MessageProcessorRunnable::close);
import org.apache.logging.log4j.LogManager;
import org.opensearch.index.mapper.IdFieldMapper;
    /**
    }
}
 * The OpenSearch Contributors require contributions made to
    }
            partitionToMessageProcessorMap.put(partition, messageProcessorRunnable);
    }
            );
    }
        return Math.floorMod(id.hashCode(), numPartitions);
            System.currentTimeMillis()
            if (previousFirstQueuedPointer == null) {
        for (int partition = 0; partition < numPartitions; partition++) {
        return partitionToMessageProcessorMap.entrySet().stream().map(entry -> {
import java.util.concurrent.BlockingQueue;
            shardId,
     *  Visible for testing. Initialize a single partition for the provided messageProcessorRunnable.
public class PartitionedBlockingQueueContainer {
            if (currentShardPointer != null) {
    private final int numPartitions;
        return partitionToProcessorExecutorMap;
        }).toList();
import java.util.List;
            "stream-poller-processor-shard-%d-%d",
        partitionToProcessorExecutorMap = new ConcurrentHashMap<>();
            .map(MessageProcessorRunnable::getMessageProcessorMetrics)
    }
            ExecutorService executorService = Executors.newSingleThreadExecutor(
        int blockingQueueSize,
    }
            Locale.ROOT,
        this.numPartitions = numPartitions;
     */
        logger.info("Initializing processors for shard {} using {} partitions", shardId, numPartitions);
            executorService.submit(messageProcessorRunnable);
        }
        if (Strings.isEmpty(id)) {
    }
import java.util.concurrent.ArrayBlockingQueue;
        IngestionShardPointer previousFirstQueuedPointer = partitionToFirstQueuedPointerMap.putIfAbsent(
                partitionToQueueMap.get(partition),
    private final Map<Integer, ExecutorService> partitionToProcessorExecutorMap;
    private static final Logger logger = LogManager.getLogger(PartitionedBlockingQueueContainer.class);
        );
            .reduce(MessageProcessorRunnable.MessageProcessorMetrics::combine)
    /**
        partitionToMessageProcessorMap.clear();
import java.util.Locale;
        int numPartitions,
        int partition = getPartitionFromID(id);
        try {
    }
                r,
    public void close() {
        partitionToFirstQueuedPointerMap.clear();
        IngestionEngine ingestionEngine,
     * Update error strategy in all available message processors.
     */
        }
            return partitionToFirstQueuedPointerMap.get(entry.getKey());
    private int getPartitionFromID(String id) {
        partitionToFirstQueuedPointerMap = new ConcurrentHashMap<>();
    /**
 * partition on a retry.
import org.opensearch.core.common.Strings;
        partitionToProcessorExecutorMap = new ConcurrentHashMap<>();
package org.opensearch.indices.pollingingest;
        }
        }
            partition,
        partitionToMessageProcessorMap = new ConcurrentHashMap<>();
            r -> new Thread(
            );
                    Locale.ROOT,
    /**
            queue.clear();
     * by the processor thread. Note that this fallback works because messages are written to the blocking queue sequentially
                ingestionEngine,
     * Returns the list of lowest/first shard pointer per partition that is in-flight or already processed.
            MessageProcessorRunnable messageProcessorRunnable = new MessageProcessorRunnable(
        for (int partition = 0; partition < numPartitions; partition++) {
        return partitionToMessageProcessorMap;
import org.opensearch.index.IngestionShardPointer;
                r -> new Thread(r, String.format(Locale.ROOT, processorThreadName))
            shardUpdateMessage.pointer()
        } catch (InterruptedException | RuntimeException e) {
     * Add a shard update message to the blocking queue. ID of the document will be used to identify the blocking queue partition.
            .orElseGet(MessageProcessorRunnable.MessageProcessorMetrics::create);
    public void clearAllQueues() {
        partitionToQueueMap.clear();
     * The fallback to first queued partition ensures that the correct pointer is considered before the very first message is processed
    Map<Integer, ExecutorService> getPartitionToProcessorExecutorMap() {
    /**
    Map<Integer, MessageProcessorRunnable> getPartitionToMessageProcessorMap() {
            return 0;
/**
    public PartitionedBlockingQueueContainer(
     * If the processor thread is yet to process the very first message, the first queued pointer for the partition is considered.
    }
        return partitionToMessageProcessorMap.values()
     */
    public void updateErrorStrategy(IngestionErrorStrategy errorStrategy) {
            MessageProcessorRunnable messageProcessorRunnable = partitionToMessageProcessorMap.get(partition);
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
        int shardId,
        assert numPartitions > 0 : "Number of processor threads / partitions must be greater than 0";
    private final Map<Integer, MessageProcessorRunnable> partitionToMessageProcessorMap;
 * A partitioned blocking queue approach is used to support multiple writer threads. This class holds a blocking queue
import org.apache.logging.log4j.Logger;
        IngestPipelineExecutor pipelineExecutor
                )
            partitionToProcessorExecutorMap.put(partition, executorService);
     */
        partitionToFirstQueuedPointerMap = new ConcurrentHashMap<>();
        partitionToProcessorExecutorMap.values().forEach(ExecutorService::shutdown);
     * in the same order in which they are received from the consumer.
        partitionToFirstQueuedPointerMap.clear();
        IngestionErrorStrategy errorStrategy,
        partitionToProcessorExecutorMap.clear();
        String processorThreadNamePrefix = String.format(
                partitionToFirstQueuedPointerMap.remove(partition, shardUpdateMessage.pointer());
 *
import org.opensearch.index.engine.IngestionEngine;
    private final Map<Integer, BlockingQueue<ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message>>> partitionToQueueMap;
        }
    // partition mappings
    /**
 */
 * compatible open source license.
        partitionToMessageProcessorMap.values().forEach(messageProcessor -> messageProcessor.setErrorStrategy(errorStrategy));
            partitionToQueueMap.get(partition).put(shardUpdateMessage);
import java.util.Map;
    public void add(ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message> shardUpdateMessage) throws InterruptedException {
    }
            )
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.Message;
    /**
     */
            }
     */
     * Clear data in all blocking queues across all partitions.
import java.util.concurrent.ExecutorService;
     * Stop the processor threads and shutdown the executors.
        partitionToProcessorExecutorMap.put(0, executorService);
    private final Map<Integer, IngestionShardPointer> partitionToFirstQueuedPointerMap;
                pipelineExecutor
                String.format(
/*
        partitionToQueueMap = new ConcurrentHashMap<>();
    PartitionedBlockingQueueContainer(MessageProcessorRunnable messageProcessorRunnable, int shardId) {
        Map<String, Object> payloadMap = shardUpdateMessage.parsedPayloadMap();
        String id = (String) payloadMap.get(IdFieldMapper.NAME);
            }
    }
    /**
                errorStrategy,
     */
        );
        partitionToQueueMap = new ConcurrentHashMap<>();
            ExecutorService executorService = partitionToProcessorExecutorMap.get(partition);
    ) {
            throw e;
                return currentShardPointer;
     */
        partitionToQueueMap.put(0, messageProcessorRunnable.getBlockingQueue());
    }
        ExecutorService executorService = Executors.newSingleThreadExecutor(
     * Initialize partitions and processor threads for given number of partitions.
     */
    public void startProcessorThreads() {
    }
            partitionToQueueMap.put(partition, new ArrayBlockingQueue<>(blockingQueueSize));
 * missing, a new one is auto-generated and used for mapping, and can result in the message/record mapped to a different
        partitionToMessageProcessorMap.put(0, messageProcessorRunnable);
     * Starts the processor threads to read updates and write to the index.
    public List<IngestionShardPointer> getCurrentShardPointers() {
        logger.debug("Cleared all blocking queues across {} partitions", numPartitions);
            String processorThreadName = String.format(Locale.ROOT, "%s-partition-%d", processorThreadNamePrefix, partition);
    public MessageProcessorRunnable.MessageProcessorMetrics getMessageProcessorMetrics() {
            .stream()
        );
 */
     * Returns aggregated message processor metrics from all processor threads.
    /**
 * Messages/records for the same document (ID) are mapped to the same partition for sequential processing. If ID is
 * this file be licensed under the Apache-2.0 license or a
