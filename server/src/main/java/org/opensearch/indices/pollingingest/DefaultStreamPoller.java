         * Set blocking queue size
        return paused;
                    updateWarmupStatus();
            payloadDecoder
        long currentLag = cachedPointerBasedLag;  
                if (paused || isWriteBlockEnabled) {
import java.util.Map;  
            return this;  
            logger.info(  
            this.maxPollSize = maxPollSize;
                shardId,  
    private PartitionedBlockingQueueContainer blockingQueueContainer;
            return;
            logger.warn(
    }
        for (IngestionShardConsumer.ReadResult<? extends IngestionShardPointer, ? extends Message> result : results) {
     * processor are decoupled in this implementation, and hence the latest pointer tracked by the processor acts as the  
            state = State.WARMING_UP;
                    Thread.sleep(DEFAULT_POLLER_SLEEP_PERIOD_MS);
            isWriteBlockEnabled = state.blocks().indexBlocked(ClusterBlockLevel.WRITE, indexName);
        long timeout = 5000;
        public Builder(
    private volatile IngestionErrorStrategy errorStrategy;  
    ) {  
            return this;
    @Override
                mapperType,
                    String.valueOf(result.getMessage().getPayload()),
    private volatile boolean closed;
        IngestionShardPointer failedShardPointer = null;
    }
        /**
            ingestionEngine.config().getIndexSettings(),  
    /**  
                    resetPointer = consumer.pointerFromOffset(resetValue);
            final ClusterState state = event.state();  
        builder.setTotalProcessorFailedCount(processorMetrics.failedMessageCounter().count());
        }  
    @Override
        );
                "Warmup skipped for index {} shard {} - {}",
        IndexMetadata indexMetadata,
        blockingQueueContainer.close();  
        }
        if (resetState != ResetState.NONE && consumer != null) {  
            this.mapperType = mapperType;
                pause();
        reinitializeConsumer = true;
        this.pollTimeout = pollTimeout;
        // Handle consumer offset reset the first time an index is created. The reset offset takes precedence if available.  
                lastPointerBasedLagUpdateTime = currentTime;  
                    pause();  
    private volatile boolean paused;
        this.state = initialState;  
                }
}
         */
                );
            this.state = State.WARMING_UP;
    }
        logger.info("Starting poller for shard {}", shardId);  
        this.paused = initialState == State.PAUSED;
     * to allow monitoring via the ingestion state API.  
    private DefaultStreamPoller(  
                currentLag,
        // set processor stats  
                totalConsumerErrorCount.inc();  
        }
        } catch (Exception e) {  
        if (!warmupConfig.isEnabled() || isWarmupComplete()) {
        // handle initial poller states  
            return this;
         */
    }  
                if (errorStrategy.shouldIgnoreError(e, IngestionErrorStrategy.ErrorStage.POLLING) == false) {
import org.opensearch.cluster.block.ClusterBlockLevel;
                    logger.info(
                setStateWithWarmupAwareness(State.PROCESSING);
                ingestionEngine,
    private void closeConsumer() {
            this.warmupConfig = Objects.requireNonNull(warmupConfig);
            totalConsumerErrorCount.inc();
import java.util.concurrent.CountDownLatch;
            return;  
                if (results.isEmpty()) {
        private State initialState = State.NONE;
        } catch (Exception e) {
 */  
        return System.currentTimeMillis() - lastPolledMessageTimestamp;
            reinitializeConsumer = false;  
        this.consumerFactory = Objects.requireNonNull(consumerFactory);  
                currentLag,
        }
    private String consumerClientId;  
         * Set initial state
        if (closed) {
                List<IngestionShardConsumer.ReadResult<? extends IngestionShardPointer, ? extends Message>> results;  
    public boolean awaitWarmupComplete(long timeoutMs) throws InterruptedException {  
                    logger.info("Resetting pointer by seeking to earliest pointer {}", resetPointer.asString());
     * Returns the lag in milliseconds since the last polled message  
                }  
import org.opensearch.cluster.metadata.IndexMetadata;  
            warmupStartTime = System.currentTimeMillis();
    /**
        if (lagBelowThreshold) {
         * Set reset value  
                consumerFactory,
     * Update the cached pointer-based lag if enough time has elapsed since the last update.
                pipelineExecutor  
    }
                threshold
         * Set the payload decoder to use for deserializing raw message bytes.
        IngestionShardPointer startPointer,
    }  
     */
            );  
        builder.setTotalPollerMessageFailureCount(totalPollerMessageFailureCount.count());
        /**  
            return;
                numProcessorThreads,
            try {
        // Initialize warmup if enabled
         * Set reset state
    private static final int DEFAULT_POLLER_SLEEP_PERIOD_MS = 100;  
        State initialState,
        this.maxPollSize = maxPollSize;
import java.util.concurrent.TimeUnit;
            this.pollTimeout = pollTimeout;  
    }  
        if (lastPolledMessageTimestamp != timestamp) {
    private void updatePointerBasedLagIfNeeded() {
        this.blockingQueueContainer = blockingQueueContainer;
    private volatile boolean warmupComplete = false;
/**
import org.opensearch.cluster.ClusterChangedEvent;  
        public Builder payloadDecoder(IngestionPayloadDecoder payloadDecoder) {
        }
        }
        private IngestionEngine ingestionEngine;
        return failedShardPointer;  
    // Force the consumer to start reading from this pointer. This is used in case of failures, or during initialization/reinitialization.  
     */
    }
        String resetValue,  
                Map<String, Object> decodedPayload = payloadDecoder.decode(result.getMessage());
            return this;
                updatePointerBasedLagIfNeeded();  
    /**  
        }
            return this;
        IngestionMessageMapper messageMapper,
                shardId,
        PollingIngestStats.Builder builder = new PollingIngestStats.Builder();
import java.util.List;
            return this;
    @Nullable  
                    continue;
    private volatile boolean reinitializeConsumer;  
        if (closed) {
        }  
        builder.setTotalConsumerErrorCount(totalConsumerErrorCount.count());  
    }  
            logger.warn("Cannot reinitialize consumer for closed poller of shard {}", shardId);
                    );
                warmupConfig,
     * Start the poller. visibile for testing  
            }
         */  
        /**
     * Initializes the consumer using the provided consumerFactory. If an error is encountered during initialization,
            this.errorStrategy = new DropIngestionErrorStrategy("poller");
            resetState,
            .stream()
            lastPolledMessageTimestamp = timestamp;  
        }  
                maxPollSize,  
                resetValue,  
     * Warmup uses offset-based lag (cachedPointerBasedLag) which tracks the difference between
            .filter(Objects::nonNull)  
                logger.error("Timeout reached while waiting for shard {} to close", shardId);
        long threshold = warmupConfig.lagThreshold();
     * Mark the poller's consumer for reinitialization. A new consumer will be initialized and start consuming from the
                // The user will have the option to manually update the offset and resume ingestion.  
                errorStrategy.handleError(e, IngestionErrorStrategy.ErrorStage.POLLING);
            }
            this.errorStrategy = Objects.requireNonNull(errorStrategy);
            consumerClientId,
    public IngestionShardPointer getBatchStartPointer() {  
            this.pipelineExecutor = pipelineExecutor;  
    /**
            try {
        }  
        public Builder pointerBasedLagUpdateInterval(long pointerBasedLagUpdateInterval) {
        this.initialBatchStartPointer = startPointer;
            r -> new Thread(r, String.format(Locale.ROOT, "stream-poller-consumer-%d-%d", shardId, System.currentTimeMillis()))  
        /**  
    private IngestionShardPointer forcedShardPointer = null;
     * Process records and write to the blocking queue. In case of error, return the shard pointer of the failed message.
            );
        int shardId,
                indexName,  
            return 0;
            return this;  
            throw new IllegalStateException("poller is not started!");
    /**  
    private void closePayloadDecoder() {
    @Override
        this.shardId = shardId;
import java.util.concurrent.ExecutorService;  
        }  
                setLastPolledMessageTimestamp(result.getMessage().getTimestamp() == null ? 0 : result.getMessage().getTimestamp());
            resetState = ResetState.NONE;
        }  
    }  
                blockingQueueSize,  
            consumerFactory,  
    private volatile IndexMetadata currentIndexMetadata;  
import org.opensearch.index.IngestionShardConsumer;
        }  
            } catch (Exception e) {
        // Warmup configuration - default matches IndexMetadata settings
    public void pause() {
                indexName,  
                    e
        int blockingQueueSize,
        IngestionShardPointer resetShardPointer = getResetShardPointer();
    @Override  
    }  
            restartPointer = resetShardPointer;
        while (state != State.CLOSED) {
            this.payloadDecoder = payloadDecoder;
        ) {
            try {  
    ) {
            return;  
        IngestionEngine ingestionEngine,
         */
     *  
        IngestionPayloadDecoder payloadDecoder
    }  
            shardId,
         */  
    }  
    }
        builder.setTotalProcessorVersionConflictsCount(processorMetrics.versionConflictCounter().count());  
    }
                shardId,
        return builder.build();
        if (!started) {  
                    setStateWithWarmupAwareness(State.PAUSED);
        if (consumer != null && (currentTime - lastPointerBasedLagUpdateTime >= pointerBasedLagUpdateIntervalMs)) {  
                logger.info("Closing consumer for index {} shard {}", indexName, shardId);
        // in-flight decode() call on the consumer thread is not racing with resource cleanup here.
    private final String indexName;
        }  
        if (started) {
        }
        }
                );
                );  
import java.util.Comparator;  
         */
         */  
            logger.info(
    }  
        long startTime = System.currentTimeMillis(); // Record the start time  
        }
            } catch (Exception e) {
    /**  
 */  
        private String consumerClientId;
import org.opensearch.cluster.metadata.IngestionSource;
    @Override
import java.util.Objects;
 * compatible open source license.
        IndexSettings indexSettings,  
        if (warmupConfig.isEnabled() && !warmupComplete) {  
package org.opensearch.indices.pollingingest;
            this.resetState = resetState;
        // CLOSED and PAUSED always take effect
                } else {  
import org.opensearch.index.Message;
        IngestionShardPointer resetPointer = null;
                indexName,
                }  
                errorStrategy,
        }  
        return resetPointer;
        return isWriteBlockEnabled;
        // Force the consumer to start from the batchStartPointer. This will be the initialBatchStartPointer for first
     * Closes the consumer gracefully. This should be called when reinitializing or shutting down the poller.  
                    logger.info("Resetting pointer by seeking to latest pointer {}", resetPointer.asString());
                }  
                "Warmup timeout for index {} shard {} - proceeding with current lag (warmupComplete={})",
        }
        this.state = newState;
    private volatile IngestionShardPointer initialBatchStartPointer;  
        }
        /**
                    totalPollerMessageDroppedCount.inc();
        }
        IngestionShardPointer startPointer,  
        blockingQueueContainer.clearAllQueues();
        String consumerClientId,
            } catch (InterruptedException ie) {
        public Builder blockingQueueSize(int blockingQueueSize) {  
        closePayloadDecoder();  
        builder.setTotalInvalidMessageCount(processorMetrics.invalidMessageCounter().count());
        }
            IngestionEngine ingestionEngine  
        builder.setTotalProcessorFailuresDroppedCount(processorMetrics.failedMessageDroppedCounter().count());
        // If interval is 0, pointer-based lag is disabled  
     */  
                mapperSettings,  
        private ResetState resetState = ResetState.LATEST;
     * the current consumer position and the end of the stream. This is the preferred mode for
        int numProcessorThreads,  
    private long maxPollSize;
         * Set max poll size
            this.numProcessorThreads = numProcessorThreads;
                payloadDecoder
        );
        closed = true;  
        return warmupComplete || !warmupConfig.isEnabled();  
         * Set warmup configuration
import java.util.concurrent.Executors;
        private IngestionSource.WarmupConfig warmupConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 100L);  
        } else if (timeoutReached) {
         * Set mapper settings
    private void handleConsumerInitialization() {
        this.errorStrategy = errorStrategy;
                isWarmupComplete()
import org.opensearch.index.IngestionShardPointer;  
         * Build the DefaultStreamPoller instance
    }
            }  
    }  
                "Warmup complete for index {} shard {} - lag {} is at or below threshold {}",
    @Override  
import org.opensearch.indices.pollingingest.mappers.IngestionMessageMapper;  
            "Warmup config updated for index {} shard {}: timeout={}, lagThreshold={}",
            IngestionMessageMapper.create(mapperType.getName(), shardId, mapperSettings),
                } else {  
    private void updateWarmupStatus() {
        private IngestionMessageMapper.MapperType mapperType = IngestionMessageMapper.MapperType.DEFAULT;
        }
        // If warmup is disabled, mark as complete immediately
                // Check warmup status if not yet complete
     */
        IngestPipelineExecutor pipelineExecutor,
                case EARLIEST:
                case RESET_BY_TIMESTAMP:
    @Override
         */
    /**
            this.consumerClientId = Objects.requireNonNull(consumerClientId);
        this.indexName = indexSettings.getIndex().getName();  
                this.consumer = null;
        if (closed) {  
        private IngestPipelineExecutor pipelineExecutor;
            if (event.blocksChanged() == false) {
        builder.setTotalPollerMessageDroppedCount(totalPollerMessageDroppedCount.count());
                    break;
        private IngestionErrorStrategy errorStrategy;
                    forcedShardPointer = null;
        public Builder mapperType(IngestionMessageMapper.MapperType mapperType) {
                blockingQueueContainer.add(shardUpdateMessage);
        builder.setLagInMillis(computeTimeBasedLag());  
    @Override  
        if (paused || !warmupConfig.isEnabled()) {  
        blockingQueueContainer.startProcessorThreads();
            new PartitionedBlockingQueueContainer(  
    private long pointerBasedLagUpdateIntervalMs;
 * this file be licensed under the Apache-2.0 license or a
            String consumerClientId,
        paused = true;
import org.apache.logging.log4j.LogManager;
            shardId,
            pointerBasedLagUpdateIntervalMs,
         */  
    @Override
    // goal state
        int pollTimeout,
import org.opensearch.common.metrics.CounterMetric;  
            this.shardId = shardId;
        Map<String, Object> mapperSettings,
        }
            warmupComplete = true;
        this.payloadDecoder = Objects.requireNonNull(payloadDecoder);
                        resetValue,  
     * Builder for DefaultStreamPoller  
        long pointerBasedLagUpdateIntervalMs,
        private int pollTimeout = 1000;
                logger.warn("Error closing consumer for index {} shard {}: {}", indexName, shardId, e.getMessage());  
            this.consumer = consumerFactory.createShardConsumer(consumerClientId, shardId, currentIndexMetadata);
        if (!warmupConfig.isEnabled()) {  
        logger.info("closed the poller of shard {}", shardId);
        ResetState resetState,  
            this.state = newState;
        // retrieve batchStartPointer before clearing the partition blocking queues
    public void resume() {  
                // Decode payload to a field map before the mapper sees the message.
    private ResetState resetState;
                // update the lastPointerBasedLagUpdateTime first, to avoid load on streaming source in case of errors
        private IngestionConsumerFactory consumerFactory;
    }
    /**
        private IngestionShardPointer startPointer;  
        }
        boolean timeoutReached = elapsedTime >= warmupConfig.timeout().millis();
            // Check if the timeout has been reached  
                logger.debug(  
            int shardId,
    public boolean isPaused() {
        IngestionPayloadDecoder payloadDecoder
        this.currentIndexMetadata = updatedIndexMetadata;  
        PartitionedBlockingQueueContainer blockingQueueContainer,
            throw e;
                if (!warmupComplete) {  
        }
        IngestionSource.WarmupConfig warmupConfig,
            );
        if (pointerBasedLagUpdateIntervalMs == 0) {
         * Set the index metadata used to create the consumer.  
                this.consumer.close();  
                paused ? "poller is paused" : "warmup is disabled"
            .min(Comparator.naturalOrder())
    private final CountDownLatch warmupLatch = new CountDownLatch(1);
                elapsedTime,  
        IngestionConsumerFactory consumerFactory,
     */
         * Set number of processor threads
                blockingQueueSize,
    /**
    }
        if (resetShardPointer != null) {
    public boolean isWarmupComplete() {
                    continue;
        }
    @Override
    public boolean isWriteBlockEnabled() {  
                if (closed) {
        try {
            logger.warn(
         */
         */
                totalPollerMessageFailureCount.inc();
            throw new RuntimeException("consumer is closed!");  
                // Pause ingestion when an error is encountered while polling the streaming source.
                        "Resetting pointer by seeking to timestamp {}, corresponding pointer {}",
            warmupLatch.countDown();  
     * During warmup, POLLING and PROCESSING states are reported as WARMING_UP
         * Initialize the builder with mandatory parameters
            return true;
                    shardId,  
        return completed;
        started = true;  
    }  
    public IngestionShardConsumer getConsumer() {
            return this;
     * Kafka and other sources that support offset-based lag calculation.  
            try {
                    continue;
            throw new RuntimeException("poller is closed!");
                    result.getPointer().asString(),
        this.currentIndexMetadata = Objects.requireNonNull(indexMetadata);
                    break;  
    private volatile long cachedPointerBasedLag = -1; // -1 indicates poller has not consumed any message yet  
import org.apache.logging.log4j.Logger;
                ingestionEngine,  
        builder.setTotalProcessedCount(processorMetrics.processedCounter().count());
                pollTimeout,
            initialBatchStartPointer = resetShardPointer;  
                    decodedPayload
    private long computeTimeBasedLag() {
        /**  
    public void updateWarmupConfig(IngestionSource.WarmupConfig newConfig) {
        State initialState,  
        // During warmup, stay in WARMING_UP instead of POLLING/PROCESSING
        IngestionConsumerFactory consumerFactory,
    // start of the batch, inclusive
        long pointerBasedLagUpdateIntervalMs,
                logger.error(  
                    result.getMessage(),  
     * Returns the batch start pointer from where the poller can resume in case of shard recovery. The poller and
            }
                    results = consumer.readNext(maxPollSize, pollTimeout);
        if (!started) {
        public Builder numProcessorThreads(int numProcessorThreads) {
            payloadDecoder.close();  
     */  
    @Override
        }  
import org.opensearch.common.Nullable;
        }
    }  
    public State getState() {
        private String resetValue = "";  
                setStateWithWarmupAwareness(State.POLLING);
         */  
/*  
        builder.setPointerBasedLag(cachedPointerBasedLag);
                forcedShardPointer = processRecords(results);
    private final CounterMetric totalPolledCount = new CounterMetric();
     * processors indicates the start point.  
        }  
            this.initialState = initialState;
    public PollingIngestStats getStats() {  
    @Override
        /**
        this.pointerBasedLagUpdateIntervalMs = pointerBasedLagUpdateIntervalMs;  
        this.messageMapper = Objects.requireNonNull(messageMapper);
        if (closed) {
        // set consumer stats
                indexName,
        builder.setTotalPolledCount(totalPolledCount.count());
                    break;
            if (System.currentTimeMillis() - startTime > timeout) {
        long elapsedTime = System.currentTimeMillis() - warmupStartTime;  
     * latest batchStartPointer using the updated index metadata.
        return blockingQueueContainer.getCurrentShardPointers()
        }
            initialState,
     *
     */
                if (this.consumer == null || reinitializeConsumer) {  
         */
    private volatile IngestionShardConsumer consumer;
            closePayloadDecoder();  
            warmupConfig,
     * Called when index settings are changed at runtime.
    public static class Builder {
        // Skip warmup if poller is paused or warmup is disabled
    }
     */  
            logger.info("Starting warmup phase for index {} shard {}, waiting for lag to catch up", indexName, shardId);  
        /**
                startPointer,  
    private final CounterMetric totalPollerMessageFailureCount = new CounterMetric();  
                totalPolledCount.inc();  
    private static final Logger logger = LogManager.getLogger(DefaultStreamPoller.class);
                    "Put message {} with pointer {} to the blocking queue",
                // Errors here are caught below and handled by the configured DROP/BLOCK strategy.  
        // Close only after the consumer thread has reached CLOSED (or the wait timed out), so any
import org.opensearch.index.IngestionConsumerFactory;  
                "Warmup timeout for index {} shard {} after {}ms - proceeding with lag {} (threshold was {})",  
        this.errorStrategy = errorStrategy;
                    logger.info("Resetting pointer by seeking to pointer {}", resetPointer.asString());  
         */
     * Note: cachedPointerBasedLag is -1 by default (indicating no messages consumed yet) and is only updated after updatePointerBasedLagIfNeeded()
                numProcessorThreads,
        /**  
        long currentTime = System.currentTimeMillis();
        /**  
                    try {  
                logger.error("Pausing ingestion. Fatal error occurred in polling the shard {} for index {}: {}", shardId, indexName, e);
        logger.info("Configuration parameters updated for index {} shard {}, requesting consumer reinitialization", indexName, shardId);
         */
            this.warmupComplete = true;
            return;
    /**
                    // no new records
import org.opensearch.cluster.ClusterState;
    // indicates if a local or global cluster write block is in effect
                    setStateWithWarmupAwareness(State.CLOSED);  
        IngestionErrorStrategy errorStrategy,
        }
    @Override
                // Force the consumer to start from forcedShardPointer if available
                logger.error("Error in closing the poller of shard {}: {}", shardId, e);
import java.util.Collections;
        /**
        private long maxPollSize = 1000;  
            try {
                        logger.error("Error in pausing the poller of shard {}: {}", shardId, e);  
            this.indexMetadata = Objects.requireNonNull(indexMetadata);  
                    }
    private IngestionShardPointer getResetShardPointer() {
         */  
         * Set pointer-based lag update interval in milliseconds  
    private volatile boolean started;  
        public DefaultStreamPoller build() {
                    results = consumer.readNext(forcedShardPointer, true, maxPollSize, pollTimeout);
        closeConsumer();
        }  
        MessageProcessorRunnable.MessageProcessorMetrics processorMetrics = blockingQueueContainer.getMessageProcessorMetrics();
         * Set mapper type
        this.warmupConfig = newConfig;  
        /**
        }  
                resetState,
    private IngestionConsumerFactory consumerFactory;
     * @param updatedIndexMetadata the updated index metadata with new configuration parameters  
        }  
                }
        boolean completed = warmupLatch.await(timeoutMs, TimeUnit.MILLISECONDS);
        if (lastPolledMessageTimestamp == 0 || paused) {  
                return;  
        }
            }
                    break;
                }  
    private volatile long lastPolledMessageTimestamp = 0;
    private volatile State state = State.NONE;  
        int shardId,  
    /**
        IngestionSource.WarmupConfig warmupConfig,  
    public IngestionErrorStrategy getErrorStrategy() {
         * Set poll timeout  
            indexName,  
        boolean lagBelowThreshold = currentLag >= 0 && currentLag <= threshold;
import java.util.Locale;
    private int shardId;
     */  
    private final String resetValue;  
        private int blockingQueueSize = 100;  
            } catch (Exception e) {  
    /**
        // time initialization, or the latest batchStartPointer based on processed messages.
                ShardUpdateMessage shardUpdateMessage = messageMapper.mapAndProcess(
     * the poller thread sleeps for the provided duration before retrying/proceeding with the polling loop.
    }  
        this.resetState = resetState;  
     */
            );
        try {
        long maxPollSize,  
                        resetPointer.asString()
                pointerBasedLagUpdateIntervalMs,
        IngestionMessageMapper.MapperType mapperType,  
     * Updates the warmup configuration dynamically.  
        /**
            } catch (Exception e) {
            return this;
 * SPDX-License-Identifier: Apache-2.0
                    result.getPointer(),
        private int numProcessorThreads = 1;
                // todo: support retry?
         */  
        long maxPollSize,
                // Update lag periodically. Lag is updated even if the poller is paused.
                }
                    // Blocking error encountered. Pause poller to stop processing remaining updates.
        }
    // indicates number of messages dropped due to error
        IngestionShardPointer restartPointer = getBatchStartPointer();  
            } catch (Throwable e) {
    public void start() {  
        return closed;
    public boolean isClosed() {  
        }
        this.consumerThread = Executors.newSingleThreadExecutor(
                errorStrategy,
     * @param newState the desired state to set
        public Builder indexMetadata(IndexMetadata indexMetadata) {
import org.opensearch.index.IngestionPayloadDecoder;
            switch (resetState) {
                    failedShardPointer = result.getPointer();
                    break;
    @Override
    @Override
    }
            return;
    DefaultStreamPoller(
                Thread.currentThread().interrupt();  
        while (true) {  
     */  
        this(
            throw new RuntimeException("poller is already running");  
                    setLastPolledMessageTimestamp(0);  
                    indexName,
    private volatile long lastPointerBasedLagUpdateTime = 0;
    @Override
                case LATEST:  
    @Override
                if (forcedShardPointer != null) {  
            this.mapperSettings = mapperSettings != null ? mapperSettings : Collections.emptyMap();
    private volatile long warmupStartTime = 0;  
        return this.state;  
            );  
        public Builder resetState(ResetState resetState) {  
            IngestionConsumerFactory consumerFactory,  
                    "[Default Poller] Error processing record. Index={}, Shard={}, pointer={}: error={}",
        try {
    protected void startPoll() {
                    closeConsumer();
    public void updateErrorStrategy(IngestionErrorStrategy errorStrategy) {  
        } catch (Exception e) {  
        this.isWriteBlockEnabled = isWriteBlockEnabled;  
            throw new IllegalStateException("poller is closed!");
     */
     * The updated config takes effect on the next polling loop iteration via updateWarmupStatus().
    /**  
     * Messages must be written to the blocking queue in the same order in which they were received from the consumer to
        private Map<String, Object> mapperSettings = Collections.emptyMap();  
 * Default implementation of {@link StreamPoller}
        return consumer;  
    }  
        if (newState == State.CLOSED || newState == State.PAUSED) {  
         * Set pipeline executor for ingest pipeline execution  
                pipelineExecutor,
                indexMetadata,  
    private void setStateWithWarmupAwareness(State newState) {
     * Sets the poller state with warmup-aware logic.
                    handleConsumerInitialization();
    private void setLastPolledMessageTimestamp(long timestamp) {
     */
     * the poller acts as the start point. If multiple processor threads are used, the minimum shard pointer across
            errorStrategy,
     */  
    }
        paused = false;
            return new DefaultStreamPoller(
        List<IngestionShardConsumer.ReadResult<? extends IngestionShardPointer, ? extends Message>> results  
                    resetPointer = consumer.earliestPointer();  
     * If pointerBasedLagUpdateIntervalMs is 0, pointer-based lag calculation is disabled.  
    }
        /**
                // Use mapper to create ShardUpdateMessage  
     * blocking queues before initializing a new consumer. Also forces the consumer to start reading from the initial
        public Builder maxPollSize(long maxPollSize) {  
        }
                logger.warn("Failed to update lag for index {} shard {}: {}", indexName, shardId, e.getMessage());  
        }  
                // in case of failures
import org.opensearch.index.IndexSettings;
            ),
    private volatile IngestionSource.WarmupConfig warmupConfig;
    private int pollTimeout;  
        private IndexMetadata indexMetadata;
        public Builder mapperSettings(Map<String, Object> mapperSettings) {  
        /**
    }
        public Builder resetValue(String resetValue) {
                break; // Exit the loop if the timeout is reached  
        blockingQueueContainer.updateErrorStrategy(errorStrategy);
            indexMetadata,  
            logger.info("Successfully initialized consumer for shard {}", shardId);
        return this.errorStrategy;
    @Override
                consumerClientId,
        public Builder initialState(State initialState) {
            this.blockingQueueSize = blockingQueueSize;
            logger.info("consumer thread not started");
        this.warmupConfig = Objects.requireNonNull(warmupConfig);  
        public Builder errorStrategy(IngestionErrorStrategy errorStrategy) {
        initializeConsumer();  
            }
    private ExecutorService consumerThread;  
        ResetState resetState,
    public void setWriteBlockEnabled(boolean isWriteBlockEnabled) {
        if (!isWarmupComplete()) {  
    private IngestionShardPointer processRecords(
            return this;
 * The OpenSearch Contributors require contributions made to  
            warmupComplete = true;
                    result.getPointer().asString()  
        );
import org.opensearch.index.engine.IngestionEngine;
        int pollTimeout,
            maxPollSize,  
            newConfig.lagThreshold()  
            logger.error("Error applying cluster state in stream poller", e);
        /**
        /**
        public Builder pollTimeout(int pollTimeout) {
            }
            pollTimeout,
                // Initialize/reinitialization consumer
    @Nullable  
        this.resetValue = resetValue;
            return this;  
                // Currently we do not have a good way to skip past the failing messages.
                case RESET_BY_OFFSET:
    private synchronized void initializeConsumer() {
    // the index metadata used to create the consumer; updated on settings changes
        IndexMetadata indexMetadata,  
            warmupLatch.countDown();
    public void close() {
            return this;
                cachedPointerBasedLag = consumer.getPointerBasedLag(initialBatchStartPointer);
    }
        }
            this.pointerBasedLagUpdateIntervalMs = pointerBasedLagUpdateInterval;  
            warmupComplete = true;  
                    break;  
        consumerThread.shutdown();
    }  
                shardId,  
            resetValue,  
                shardId,
    public synchronized void requestConsumerReinitialization(IndexMetadata updatedIndexMetadata) {  
     * Check if warmup conditions are met and mark warmup as complete if so.
    private final CounterMetric totalPollerMessageDroppedCount = new CounterMetric();
            return this;  
        if (this.consumer == null) {
     * Handles consumer initialization and reinitialization logic. Closes existing consumer if available and clears the  
                    resetPointer = consumer.pointerFromTimestampMillis(Long.parseLong(resetValue));  
        builder.setTotalProcessorThreadInterruptCount(processorMetrics.processorThreadInterruptCounter().count());  
                    resetPointer = consumer.latestPointer();
                initialState,
        private IngestionPayloadDecoder payloadDecoder = new XContentIngestionPayloadDecoder();
    }  
    // flag to indicate if consumer needs to be reinitialized
    private final IngestionPayloadDecoder payloadDecoder;  
    private volatile boolean isWriteBlockEnabled;  
                threshold  
    public void clusterChanged(ClusterChangedEvent event) {  
 *
            warmupLatch.countDown();
    ) {
    }
            IngestionShardPointer startPointer,
            }
     * recovery/start point. In case the processor has not started tracking, then the initial batchStartPointer used by
     * ensure ordering guarantees.  
        public Builder warmupConfig(IngestionSource.WarmupConfig warmupConfig) {  
                Thread.sleep(CONSUMER_INIT_RETRY_INTERVAL_MS);
            }  
        forcedShardPointer = restartPointer;  
        }
import org.opensearch.common.unit.TimeValue;
        consumerThread.submit(this::startPoll);
                        Thread.sleep(DEFAULT_POLLER_SLEEP_PERIOD_MS);
            throw new RuntimeException("consumer is closed!");
    /**
        if (closed) {
        public Builder pipelineExecutor(IngestPipelineExecutor pipelineExecutor) {
            this.startPointer = startPointer;
            newConfig.timeout(),
            this.consumerFactory = Objects.requireNonNull(consumerFactory);  
        String resetValue,
     * Handles the reset state logic.
        IngestionErrorStrategy errorStrategy,
    private static final int CONSUMER_INIT_RETRY_INTERVAL_MS = 10000;
     * batchStartPointer if first time initialization, or from the latest available batchStartPointer on reinitialization.
                // processRecords returns failed shard pointers. Update forcedShardPointer to the failed pointer to retry on next iteration  
        }
            this.resetValue = resetValue;  
        }  
            try {
            return this;
    private final CounterMetric totalConsumerErrorCount = new CounterMetric();
        if (!completed) {  
            return this;  
        this.consumerClientId = Objects.requireNonNull(consumerClientId);
    /**
        }
    // Warmup configuration and state  
        String consumerClientId,  
     * Returns the resulting IngestionShardPointer for reset or null if no reset required.
     * is called.
            this.ingestionEngine = Objects.requireNonNull(ingestionEngine);  
    }
            return;  
            startPointer,
    private final IngestionMessageMapper messageMapper;
        private int shardId;  
            .orElseGet(() -> initialBatchStartPointer);
        if (this.consumer != null) {  
                Thread.sleep(100);  
         * Set error strategy
     */
        logger.info(
        }
     * Visible for testing.  
                    } catch (Throwable e) {
        }
            logger.warn("Error closing payload decoder for shard {}: {}", shardId, e.getMessage());
public class DefaultStreamPoller implements StreamPoller {
            logger.warn("Failed to create consumer for shard {}: {}", shardId, e.getMessage());
        private long pointerBasedLagUpdateIntervalMs = 10000;
                shardId,
