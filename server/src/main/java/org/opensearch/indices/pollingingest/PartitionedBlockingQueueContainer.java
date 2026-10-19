        }
/*  
            queue.clear();  
    public void updateErrorStrategy(IngestionErrorStrategy errorStrategy) {
        partitionToMessageProcessorMap = new ConcurrentHashMap<>();  
            MessageProcessorRunnable messageProcessorRunnable = new MessageProcessorRunnable(  
        IngestionEngine ingestionEngine,
            partitionToQueueMap.put(partition, new ArrayBlockingQueue<>(blockingQueueSize));
                    Locale.ROOT,
    private static final Logger logger = LogManager.getLogger(PartitionedBlockingQueueContainer.class);
        IngestionErrorStrategy errorStrategy,  
            );
        if (Strings.isEmpty(id)) {  
    // partition mappings
     * Update error strategy in all available message processors.  
     * in the same order in which they are received from the consumer.
    /**
                ingestionEngine,
        IngestionShardPointer previousFirstQueuedPointer = partitionToFirstQueuedPointerMap.putIfAbsent(
 * SPDX-License-Identifier: Apache-2.0
        try {  
 * partition on a retry.
        partitionToFirstQueuedPointerMap.clear();
        partitionToFirstQueuedPointerMap = new ConcurrentHashMap<>();
public class PartitionedBlockingQueueContainer {
        }
        int partition = getPartitionFromID(id);
                String.format(
        } catch (InterruptedException | RuntimeException e) {
            if (currentShardPointer != null) {
import java.util.concurrent.ConcurrentHashMap;
        return partitionToMessageProcessorMap.values()
import org.apache.logging.log4j.LogManager;
        }
     */  
        partitionToMessageProcessorMap.put(0, messageProcessorRunnable);  
     * Returns the list of lowest/first shard pointer per partition that is in-flight or already processed.
        ExecutorService executorService = Executors.newSingleThreadExecutor(
            return partitionToFirstQueuedPointerMap.get(entry.getKey());
        partitionToProcessorExecutorMap.values().forEach(ExecutorService::shutdown);  
                r -> new Thread(r, String.format(Locale.ROOT, processorThreadName))
    }  
        return partitionToMessageProcessorMap;
            "stream-poller-processor-shard-%d-%d",
        return partitionToProcessorExecutorMap;
     * Starts the processor threads to read updates and write to the index.
/**  
    Map<Integer, BlockingQueue<ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message>>> getPartitionToQueueMap() {
        partitionToMessageProcessorMap = new ConcurrentHashMap<>();  
     * Add a shard update message to the blocking queue. ID of the document will be used to identify the blocking queue partition.
        partitionToProcessorExecutorMap = new ConcurrentHashMap<>();
 * compatible open source license.
     */  
    public PartitionedBlockingQueueContainer(
        this.numPartitions = numPartitions;  
import org.apache.logging.log4j.Logger;
    private final int numPartitions;  
            ExecutorService executorService = partitionToProcessorExecutorMap.get(partition);  
                    String.format(Locale.ROOT, "stream-poller-processor-shard-%d-%d-partition-0", shardId, System.currentTimeMillis())  
 * this file be licensed under the Apache-2.0 license or a
        partitionToMessageProcessorMap.clear();
    }
    }
        int blockingQueueSize,
    private final Map<Integer, MessageProcessorRunnable> partitionToMessageProcessorMap;
            System.currentTimeMillis()
    }
     */  
            shardUpdateMessage.pointer()
        partitionToFirstQueuedPointerMap.clear();
            return 0;
}
 * Messages/records for the same document (ID) are mapped to the same partition for sequential processing. If ID is  
    ) {  
        IngestPipelineExecutor pipelineExecutor
                partitionToFirstQueuedPointerMap.remove(partition, shardUpdateMessage.pointer());
import java.util.concurrent.ExecutorService;  
    public void close() {
import org.opensearch.index.Message;
        int numPartitions,  
        );
        for (BlockingQueue<ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message>> queue : partitionToQueueMap.values()) {
    private final Map<Integer, BlockingQueue<ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message>>> partitionToQueueMap;  
import java.util.concurrent.BlockingQueue;
                return currentShardPointer;
        String processorThreadNamePrefix = String.format(  
    private int getPartitionFromID(String id) {
 * The OpenSearch Contributors require contributions made to  
        String id = (String) payloadMap.get(IdFieldMapper.NAME);
     * Returns aggregated message processor metrics from all processor threads.
     */  
        partitionToProcessorExecutorMap = new ConcurrentHashMap<>();
            .stream()
 */  
 *
        partitionToMessageProcessorMap.values().forEach(MessageProcessorRunnable::close);
    }
                )
    PartitionedBlockingQueueContainer(MessageProcessorRunnable messageProcessorRunnable, int shardId) {
    public MessageProcessorRunnable.MessageProcessorMetrics getMessageProcessorMetrics() {  
 * per partition. A processor thread is started for each partition to consume updates and write to the lucene index.
        }).toList();
    }
        }
     * If the processor thread is yet to process the very first message, the first queued pointer for the partition is considered.
        partitionToProcessorExecutorMap.put(0, executorService);
    }
            IngestionShardPointer currentShardPointer = entry.getValue().getCurrentShardPointer();  
        partitionToQueueMap = new ConcurrentHashMap<>();
    }
            }  
import org.opensearch.index.engine.IngestionEngine;  
            if (previousFirstQueuedPointer == null) {  
     * The fallback to first queued partition ensures that the correct pointer is considered before the very first message is processed  
     */
            partition,  
import org.opensearch.index.IngestionShardPointer;
    /**
     */  
    }  
     *  Visible for testing. Initialize a single partition for the provided messageProcessorRunnable.
     */
            )
    /**
import java.util.concurrent.Executors;
 * A partitioned blocking queue approach is used to support multiple writer threads. This class holds a blocking queue
            Locale.ROOT,
        int shardId,
        }  
     */
     * Clear data in all blocking queues across all partitions.
        for (int partition = 0; partition < numPartitions; partition++) {
    }
        partitionToQueueMap.put(0, messageProcessorRunnable.getBlockingQueue());
    private final Map<Integer, IngestionShardPointer> partitionToFirstQueuedPointerMap;  
     */
        this.numPartitions = 1;  
        );  
    Map<Integer, ExecutorService> getPartitionToProcessorExecutorMap() {
    /**
        logger.info("Initializing processors for shard {} using {} partitions", shardId, numPartitions);
                partitionToQueueMap.get(partition),
    /**  
            .reduce(MessageProcessorRunnable.MessageProcessorMetrics::combine)
import java.util.concurrent.ArrayBlockingQueue;  
            MessageProcessorRunnable messageProcessorRunnable = partitionToMessageProcessorMap.get(partition);
        partitionToQueueMap.clear();
            ExecutorService executorService = Executors.newSingleThreadExecutor(  
            }
                pipelineExecutor
        logger.debug("Cleared all blocking queues across {} partitions", numPartitions);  
        partitionToFirstQueuedPointerMap = new ConcurrentHashMap<>();
    /**
    public List<IngestionShardPointer> getCurrentShardPointers() {
 * missing, a new one is auto-generated and used for mapping, and can result in the message/record mapped to a different
            executorService.submit(messageProcessorRunnable);
package org.opensearch.indices.pollingingest;
import org.opensearch.index.mapper.IdFieldMapper;
    Map<Integer, MessageProcessorRunnable> getPartitionToMessageProcessorMap() {  
        for (int partition = 0; partition < numPartitions; partition++) {
import java.util.Locale;
    /**  
            throw e;  
            String processorThreadName = String.format(Locale.ROOT, "%s-partition-%d", processorThreadNamePrefix, partition);
    public void clearAllQueues() {
        return partitionToMessageProcessorMap.entrySet().stream().map(entry -> {
     * by the processor thread. Note that this fallback works because messages are written to the blocking queue sequentially
import org.opensearch.core.common.Strings;  
        return partitionToQueueMap;  
        partitionToMessageProcessorMap.values().forEach(messageProcessor -> messageProcessor.setErrorStrategy(errorStrategy));  
                r,  
import java.util.Map;
    }
            );
        Map<String, Object> payloadMap = shardUpdateMessage.parsedPayloadMap();
     * Initialize partitions and processor threads for given number of partitions.  
            partitionToMessageProcessorMap.put(partition, messageProcessorRunnable);  
        partitionToProcessorExecutorMap.clear();  
            .map(MessageProcessorRunnable::getMessageProcessorMetrics)  
 */  
        );
            r -> new Thread(
            partitionToProcessorExecutorMap.put(partition, executorService);  
        assert numPartitions > 0 : "Number of processor threads / partitions must be greater than 0";
        return Math.floorMod(id.hashCode(), numPartitions);  
        partitionToQueueMap = new ConcurrentHashMap<>();
    /**  
            shardId,  
    private final Map<Integer, ExecutorService> partitionToProcessorExecutorMap;
    public void add(ShardUpdateMessage<? extends IngestionShardPointer, ? extends Message> shardUpdateMessage) throws InterruptedException {  
    public void startProcessorThreads() {
    }  
    }
            .orElseGet(MessageProcessorRunnable.MessageProcessorMetrics::create);
            partitionToQueueMap.get(partition).put(shardUpdateMessage);
    /**
import java.util.List;  
                errorStrategy,  
     * Stop the processor threads and shutdown the executors.
