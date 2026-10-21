                );
                    forcedShardPointer = null;
            throw new IllegalStateException("poller is not started!");
    @Override
                case RESET_BY_OFFSET:
                }
            return new DefaultStreamPoller(
     * recovery/start point. In case the processor has not started tracking, then the initial batchStartPointer used by
            this.pointerBasedLagUpdateIntervalMs = pointerBasedLagUpdateInterval;
        logger.info("Starting poller for shard {}", shardId);
        public Builder resetState(ResetState resetState) {
 * SPDX-License-Identifier: Apache-2.0
        ResetState resetState,
     * blocking queues before initializing a new consumer. Also forces the consumer to start reading from the initial
         */
            );
        blockingQueueContainer.updateErrorStrategy(errorStrategy);
        boolean lagBelowThreshold = currentLag >= 0 && currentLag <= threshold;
     * Start the poller. visibile for testing
            resetValue,
        private IngestionErrorStrategy errorStrategy;
            errorStrategy,
        blockingQueueContainer.startProcessorThreads();
        }
                totalPollerMessageFailureCount.inc();
        }
                    try {
        }
     * Mark the poller's consumer for reinitialization. A new consumer will be initialized and start consuming from the
        public Builder blockingQueueSize(int blockingQueueSize) {
    /**
    private final CountDownLatch warmupLatch = new CountDownLatch(1);
            return this;
                shardId,
    private void updatePointerBasedLagIfNeeded() {
        int pollTimeout,
                    failedShardPointer = result.getPointer();
        started = true;
        forcedShardPointer = restartPointer;
                Thread.currentThread().interrupt();
    private IngestionConsumerFactory consumerFactory;
    private volatile boolean warmupComplete = false;
        /**
         */
         * Set the index metadata used to create the consumer.
            this.ingestionEngine = Objects.requireNonNull(ingestionEngine);
            shardId,
        /**
     */
    @Override
    public boolean isWarmupComplete() {
            if (System.currentTimeMillis() - startTime > timeout) {
         */
    private final String resetValue;
    private volatile boolean isWriteBlockEnabled;
                "Warmup timeout for index {} shard {} - proceeding with current lag (warmupComplete={})",
    private long maxPollSize;
        this.currentIndexMetadata = Objects.requireNonNull(indexMetadata);
                ShardUpdateMessage shardUpdateMessage = messageMapper.mapAndProcess(
                    resetPointer = consumer.pointerFromOffset(resetValue);
        this.state = newState;
         * Build the DefaultStreamPoller instance
                    break;
        /**
        IngestionShardPointer startPointer,
        int shardId,
import java.util.concurrent.TimeUnit;
        );
        this.state = initialState;
        return blockingQueueContainer.getCurrentShardPointers()
    private final IngestionPayloadDecoder payloadDecoder;
    @Override
     */
        builder.setTotalInvalidMessageCount(processorMetrics.invalidMessageCounter().count());
        private int pollTimeout = 1000;
        // Handle consumer offset reset the first time an index is created. The reset offset takes precedence if available.
import java.util.Objects;
         */
    private synchronized void initializeConsumer() {
import java.util.concurrent.Executors;
    // Force the consumer to start reading from this pointer. This is used in case of failures, or during initialization/reinitialization.
        return failedShardPointer;
                    );
        }
        }
            }
        IngestionEngine ingestionEngine,
        logger.info(
        } catch (Exception e) {
        if (warmupConfig.isEnabled() && !warmupComplete) {
    }
     */
                lastPointerBasedLagUpdateTime = currentTime;
import org.opensearch.cluster.ClusterChangedEvent;
         */
        );
        return paused;
                    result.getPointer().asString()
            throw new RuntimeException("consumer is closed!");
            }
        }
                // Force the consumer to start from forcedShardPointer if available
                        "Resetting pointer by seeking to timestamp {}, corresponding pointer {}",
        }
    private volatile boolean started;
     * processor are decoupled in this implementation, and hence the latest pointer tracked by the processor acts as the
                updatePointerBasedLagIfNeeded();
        int pollTimeout,
                // Errors here are caught below and handled by the configured DROP/BLOCK strategy.
     * Closes the consumer gracefully. This should be called when reinitializing or shutting down the poller.
        private long pointerBasedLagUpdateIntervalMs = 10000;
                maxPollSize,
     * the poller acts as the start point. If multiple processor threads are used, the minimum shard pointer across
    /**
            logger.warn("Cannot reinitialize consumer for closed poller of shard {}", shardId);
        builder.setTotalPollerMessageFailureCount(totalPollerMessageFailureCount.count());
            } catch (Exception e) {
    @Override
        try {
         * Set pointer-based lag update interval in milliseconds
        private Map<String, Object> mapperSettings = Collections.emptyMap();
        /**
        if (resetState != ResetState.NONE && consumer != null) {
                    result.getPointer().asString(),
    private final CounterMetric totalPolledCount = new CounterMetric();
        while (true) {
    private volatile IngestionSource.WarmupConfig warmupConfig;
        String resetValue,
    public static class Builder {
import java.util.Locale;
        MessageProcessorRunnable.MessageProcessorMetrics processorMetrics = blockingQueueContainer.getMessageProcessorMetrics();
                List<IngestionShardConsumer.ReadResult<? extends IngestionShardPointer, ? extends Message>> results;
     */
    /**
        // set consumer stats
         * Set the payload decoder to use for deserializing raw message bytes.
        return isWriteBlockEnabled;
    // the index metadata used to create the consumer; updated on settings changes
            restartPointer = resetShardPointer;
                // Pause ingestion when an error is encountered while polling the streaming source.
            );
    /**
                shardId,
                resetValue,
    private void setLastPolledMessageTimestamp(long timestamp) {
                logger.error("Pausing ingestion. Fatal error occurred in polling the shard {} for index {}: {}", shardId, indexName, e);
    private volatile boolean closed;
        return this.errorStrategy;
     * Kafka and other sources that support offset-based lag calculation.
            return 0;
            closePayloadDecoder();
                case LATEST:
import org.opensearch.cluster.metadata.IngestionSource;
            return true;
                mapperType,
    private volatile IngestionErrorStrategy errorStrategy;
         */
                    closeConsumer();
        if (this.consumer != null) {
            this.warmupConfig = Objects.requireNonNull(warmupConfig);
        if (!started) {
    @Override
                    updateWarmupStatus();
     */
            this.consumerFactory = Objects.requireNonNull(consumerFactory);
        this.messageMapper = Objects.requireNonNull(messageMapper);
            indexMetadata,
            return this;
    }
    }
    private final CounterMetric totalConsumerErrorCount = new CounterMetric();
                    // no new records
     * The updated config takes effect on the next polling loop iteration via updateWarmupStatus().
        IngestionErrorStrategy errorStrategy,
                "Warmup skipped for index {} shard {} - {}",
    }
 * compatible open source license.
        private int shardId;
            }
        if (resetShardPointer != null) {
            payloadDecoder
            logger.warn("Error closing payload decoder for shard {}: {}", shardId, e.getMessage());
                "Warmup timeout for index {} shard {} after {}ms - proceeding with lag {} (threshold was {})",
        // Initialize warmup if enabled
        boolean timeoutReached = elapsedTime >= warmupConfig.timeout().millis();
import org.opensearch.indices.pollingingest.mappers.IngestionMessageMapper;
                setStateWithWarmupAwareness(State.POLLING);
        private IngestionShardPointer startPointer;
        }
    private volatile long lastPolledMessageTimestamp = 0;
        // handle initial poller states
            } catch (Throwable e) {
        long maxPollSize,
        public Builder pollTimeout(int pollTimeout) {
            .orElseGet(() -> initialBatchStartPointer);
        public Builder errorStrategy(IngestionErrorStrategy errorStrategy) {
                    results = consumer.readNext(forcedShardPointer, true, maxPollSize, pollTimeout);
    }
            return this;
    @Override
         */
            IngestionEngine ingestionEngine
            return;
                paused ? "poller is paused" : "warmup is disabled"
        /**
        }
        List<IngestionShardConsumer.ReadResult<? extends IngestionShardPointer, ? extends Message>> results
         */
        blockingQueueContainer.clearAllQueues();
    public boolean isWriteBlockEnabled() {
                warmupConfig,
        if (!isWarmupComplete()) {
        /**
        builder.setTotalPollerMessageDroppedCount(totalPollerMessageDroppedCount.count());
import java.util.List;
    @Override
        long maxPollSize,
    public void close() {
                    logger.info("Resetting pointer by seeking to earliest pointer {}", resetPointer.asString());
    }
         * Set reset value
            throw e;
     * the poller thread sleeps for the provided duration before retrying/proceeding with the polling loop.
                    break;
    private static final int DEFAULT_POLLER_SLEEP_PERIOD_MS = 100;
import org.apache.logging.log4j.LogManager;
        ResetState resetState,
        }
        public Builder mapperType(IngestionMessageMapper.MapperType mapperType) {
        Map<String, Object> mapperSettings,
            try {
            shardId,
                // in case of failures
    public boolean isClosed() {
     * batchStartPointer if first time initialization, or from the latest available batchStartPointer on reinitialization.
    }
            return this;
    public IngestionShardConsumer getConsumer() {
         */
    }
        this.paused = initialState == State.PAUSED;
     * Builder for DefaultStreamPoller
            warmupComplete = true;
                Map<String, Object> decodedPayload = payloadDecoder.decode(result.getMessage());
            this.warmupComplete = true;
            IngestionMessageMapper.create(mapperType.getName(), shardId, mapperSettings),
 * The OpenSearch Contributors require contributions made to
                    resetPointer = consumer.pointerFromTimestampMillis(Long.parseLong(resetValue));
        this.pollTimeout = pollTimeout;
        }
    public synchronized void requestConsumerReinitialization(IndexMetadata updatedIndexMetadata) {
            switch (resetState) {
     */
                    pause();
                consumerFactory,
    }
        builder.setTotalConsumerErrorCount(totalConsumerErrorCount.count());
                }
    @Override
    private void closePayloadDecoder() {
                logger.error("Timeout reached while waiting for shard {} to close", shardId);
import java.util.Map;
                setStateWithWarmupAwareness(State.PROCESSING);
         * Set poll timeout
     * processors indicates the start point.
                );
        public DefaultStreamPoller build() {
            return this;
                pointerBasedLagUpdateIntervalMs,
            this.errorStrategy = new DropIngestionErrorStrategy("poller");
            try {
        private int blockingQueueSize = 100;
        public Builder numProcessorThreads(int numProcessorThreads) {
        if (!started) {
                if (!warmupComplete) {
        public Builder resetValue(String resetValue) {
        this.isWriteBlockEnabled = isWriteBlockEnabled;
        initializeConsumer();
        return warmupComplete || !warmupConfig.isEnabled();
        }
                }
                return;
    }
            this.errorStrategy = Objects.requireNonNull(errorStrategy);
    private static final int CONSUMER_INIT_RETRY_INTERVAL_MS = 10000;
        if (pointerBasedLagUpdateIntervalMs == 0) {
            warmupLatch.countDown();
                    continue;
            String consumerClientId,
    public boolean awaitWarmupComplete(long timeoutMs) throws InterruptedException {
            );
        }
            return this;
            "Warmup config updated for index {} shard {}: timeout={}, lagThreshold={}",
            this.consumerClientId = Objects.requireNonNull(consumerClientId);
            }
                    decodedPayload
            final ClusterState state = event.state();
import org.opensearch.index.Message;
     *
                }
            indexName,
    }
                        Thread.sleep(DEFAULT_POLLER_SLEEP_PERIOD_MS);
import org.opensearch.common.unit.TimeValue;
            this.state = newState;
    private final CounterMetric totalPollerMessageDroppedCount = new CounterMetric();
        public Builder warmupConfig(IngestionSource.WarmupConfig warmupConfig) {
        }
import org.opensearch.cluster.ClusterState;
                logger.error(
     * If pointerBasedLagUpdateIntervalMs is 0, pointer-based lag calculation is disabled.
        closeConsumer();
    public void updateErrorStrategy(IngestionErrorStrategy errorStrategy) {
        }
    // goal state
         * Set warmup configuration
            this.indexMetadata = Objects.requireNonNull(indexMetadata);
        } catch (Exception e) {
        }
    DefaultStreamPoller(
                if (closed) {
        private IngestionEngine ingestionEngine;
        }
                    result.getPointer(),
            throw new RuntimeException("consumer is closed!");
    private long pointerBasedLagUpdateIntervalMs;
        if (started) {
     * to allow monitoring via the ingestion state API.
        builder.setTotalProcessorFailuresDroppedCount(processorMetrics.failedMessageDroppedCounter().count());
    private volatile long lastPointerBasedLagUpdateTime = 0;
    public void setWriteBlockEnabled(boolean isWriteBlockEnabled) {
        IngestionMessageMapper.MapperType mapperType,
    @Override
            return;
import org.opensearch.common.Nullable;
        long elapsedTime = System.currentTimeMillis() - warmupStartTime;
                // update the lastPointerBasedLagUpdateTime first, to avoid load on streaming source in case of errors
    @Nullable
     * Returns the lag in milliseconds since the last polled message
            return;
        IndexMetadata indexMetadata,
            initialState,
    /**
    private String consumerClientId;
        private ResetState resetState = ResetState.LATEST;
    protected void startPoll() {
/*
                blockingQueueSize,
         */
                    e
        this.warmupConfig = newConfig;
        builder.setTotalProcessedCount(processorMetrics.processedCounter().count());
    public IngestionErrorStrategy getErrorStrategy() {
            resetState = ResetState.NONE;
        IndexSettings indexSettings,
                    break;
        return resetPointer;
        IngestionMessageMapper messageMapper,
    /**
                case EARLIEST:
                    indexName,
        }
        // Force the consumer to start from the batchStartPointer. This will be the initialBatchStartPointer for first
        }
            pointerBasedLagUpdateIntervalMs,
    ) {
            try {
    private volatile IngestionShardConsumer consumer;
        while (state != State.CLOSED) {
            warmupLatch.countDown();
            totalConsumerErrorCount.inc();
                    "Put message {} with pointer {} to the blocking queue",
        }
        /**
            consumerFactory,
    public void resume() {
            this.consumer = consumerFactory.createShardConsumer(consumerClientId, shardId, currentIndexMetadata);
        return System.currentTimeMillis() - lastPolledMessageTimestamp;
            .filter(Objects::nonNull)
        paused = false;
        IngestionShardPointer resetShardPointer = getResetShardPointer();
                );
        }
            r -> new Thread(r, String.format(Locale.ROOT, "stream-poller-consumer-%d-%d", shardId, System.currentTimeMillis()))
                mapperSettings,
            this.pollTimeout = pollTimeout;
         */
        }
     */
                    continue;
            return;
    private final CounterMetric totalPollerMessageFailureCount = new CounterMetric();
            this.initialState = initialState;
        // retrieve batchStartPointer before clearing the partition blocking queues
    /**
     * Initializes the consumer using the provided consumerFactory. If an error is encountered during initialization,
                "Warmup complete for index {} shard {} - lag {} is at or below threshold {}",
    /**
        }
        paused = true;
            this.mapperType = mapperType;
     * @param newState the desired state to set
        /**
            return this;
        }
     * Returns the batch start pointer from where the poller can resume in case of shard recovery. The poller and
            try {
            maxPollSize,
        this.resetState = resetState;
        }
        /**
        private State initialState = State.NONE;
        builder.setLagInMillis(computeTimeBasedLag());
        }
import org.opensearch.index.IngestionPayloadDecoder;
                if (results.isEmpty()) {
                    }
            return this;
        public Builder payloadDecoder(IngestionPayloadDecoder payloadDecoder) {
        if (closed) {
        if (!warmupConfig.isEnabled() || isWarmupComplete()) {
                indexName,
                pollTimeout,
            consumerClientId,
     * Warmup uses offset-based lag (cachedPointerBasedLag) which tracks the difference between
            return;
        }
        public Builder mapperSettings(Map<String, Object> mapperSettings) {
        /**
                shardId,
                // Currently we do not have a good way to skip past the failing messages.
    /**
            logger.info("consumer thread not started");
    private final IngestionMessageMapper messageMapper;
    // indicates if a local or global cluster write block is in effect
            newConfig.lagThreshold()
        return this.state;
                    setLastPolledMessageTimestamp(0);
            logger.info("Successfully initialized consumer for shard {}", shardId);
            pollTimeout,
    }
                    Thread.sleep(DEFAULT_POLLER_SLEEP_PERIOD_MS);
        builder.setTotalPolledCount(totalPolledCount.count());
     */
                setLastPolledMessageTimestamp(result.getMessage().getTimestamp() == null ? 0 : result.getMessage().getTimestamp());
     * Visible for testing.
        private IngestionConsumerFactory consumerFactory;
        long threshold = warmupConfig.lagThreshold();
            this.pipelineExecutor = pipelineExecutor;
                forcedShardPointer = processRecords(results);
/**
         */
        String resetValue,
     * Handles consumer initialization and reinitialization logic. Closes existing consumer if available and clears the
         */
    private volatile IngestionShardPointer initialBatchStartPointer;
        return closed;
        IngestionConsumerFactory consumerFactory,
                this.consumer = null;
    private PartitionedBlockingQueueContainer blockingQueueContainer;
                Thread.sleep(100);
        this.blockingQueueContainer = blockingQueueContainer;
        this.shardId = shardId;
 */
        }
        public Builder maxPollSize(long maxPollSize) {
    private int pollTimeout;
     * During warmup, POLLING and PROCESSING states are reported as WARMING_UP
        long currentTime = System.currentTimeMillis();
                errorStrategy.handleError(e, IngestionErrorStrategy.ErrorStage.POLLING);
        public Builder pipelineExecutor(IngestPipelineExecutor pipelineExecutor) {
        /**
            this.shardId = shardId;
            return this;
        IndexMetadata indexMetadata,
                        resetPointer.asString()
        IngestPipelineExecutor pipelineExecutor,
            throw new RuntimeException("poller is already running");
         * Set number of processor threads
     * Returns the resulting IngestionShardPointer for reset or null if no reset required.
    }
        this.initialBatchStartPointer = startPointer;
                // Use mapper to create ShardUpdateMessage
        /**
        }
                break; // Exit the loop if the timeout is reached
    private void handleConsumerInitialization() {
            .stream()
                initialState,
            this.resetValue = resetValue;
                currentLag,
        // CLOSED and PAUSED always take effect
        // Warmup configuration - default matches IndexMetadata settings
     * Check if warmup conditions are met and mark warmup as complete if so.
            }
            return;
    }
                    shardId,
    }
     */
                logger.debug(
                    totalPollerMessageDroppedCount.inc();
        private IngestionSource.WarmupConfig warmupConfig = new IngestionSource.WarmupConfig(TimeValue.timeValueMillis(-1), 100L);
        /**
        return builder.build();
        for (IngestionShardConsumer.ReadResult<? extends IngestionShardPointer, ? extends Message> result : results) {
            // Check if the timeout has been reached
        return completed;
         */
        }
        IngestionPayloadDecoder payloadDecoder
        int blockingQueueSize,
        /**
            }
        State initialState,
    }
        }
    }
        private IngestionMessageMapper.MapperType mapperType = IngestionMessageMapper.MapperType.DEFAULT;
    private static final Logger logger = LogManager.getLogger(DefaultStreamPoller.class);
import java.util.Collections;
        }
    @Override
        // During warmup, stay in WARMING_UP instead of POLLING/PROCESSING
        }
 */
            ),
                // todo: support retry?
                this.consumer.close();
        if (paused || !warmupConfig.isEnabled()) {
         * Set pipeline executor for ingest pipeline execution
    public void start() {
 * this file be licensed under the Apache-2.0 license or a
            reinitializeConsumer = false;
        builder.setPointerBasedLag(cachedPointerBasedLag);
                // The user will have the option to manually update the offset and resume ingestion.
    private IngestionShardPointer processRecords(
        if (closed) {
import org.opensearch.cluster.block.ClusterBlockLevel;
            return this;
     * @param updatedIndexMetadata the updated index metadata with new configuration parameters
        }
    public void updateWarmupConfig(IngestionSource.WarmupConfig newConfig) {
                    result.getMessage(),
    }
        public Builder pointerBasedLagUpdateInterval(long pointerBasedLagUpdateInterval) {
        try {
    private volatile long warmupStartTime = 0;
        long timeout = 5000;
        this.consumerFactory = Objects.requireNonNull(consumerFactory);
        logger.info("Configuration parameters updated for index {} shard {}, requesting consumer reinitialization", indexName, shardId);
            return this;
    }
            warmupComplete = true;
            this.blockingQueueSize = blockingQueueSize;
            warmupStartTime = System.currentTimeMillis();
    private volatile long cachedPointerBasedLag = -1; // -1 indicates poller has not consumed any message yet
package org.opensearch.indices.pollingingest;
        if (lastPolledMessageTimestamp == 0 || paused) {
}
        try {
        IngestionShardPointer failedShardPointer = null;
import java.util.concurrent.ExecutorService;
            this.payloadDecoder = payloadDecoder;
            resetState,
        if (closed) {
        builder.setTotalProcessorVersionConflictsCount(processorMetrics.versionConflictCounter().count());
            lastPolledMessageTimestamp = timestamp;
            int shardId,
            logger.info("Starting warmup phase for index {} shard {}, waiting for lag to catch up", indexName, shardId);
                indexName,
                indexMetadata,
        /**
        State initialState,
            this.numProcessorThreads = numProcessorThreads;
                ingestionEngine,
            warmupConfig,
        }
    public void pause() {
                } else {
            startPointer,
    private void closeConsumer() {
        }
         */
            logger.info(
            logger.warn(
                // Decode payload to a field map before the mapper sees the message.
                numProcessorThreads,
         */
    }
        // in-flight decode() call on the consumer thread is not racing with resource cleanup here.
                    continue;
        // time initialization, or the latest batchStartPointer based on processed messages.
                    "[Default Poller] Error processing record. Index={}, Shard={}, pointer={}: error={}",
        String consumerClientId,
     * Process records and write to the blocking queue. In case of error, return the shard pointer of the failed message.
        long startTime = System.currentTimeMillis(); // Record the start time
                // Update lag periodically. Lag is updated even if the poller is paused.
                if (forcedShardPointer != null) {
    @Override
            } catch (Exception e) {
    public State getState() {
     */
        IngestionPayloadDecoder payloadDecoder
        if (closed) {
                    break;
         * Set initial state
        reinitializeConsumer = true;
        builder.setTotalProcessorFailedCount(processorMetrics.failedMessageCounter().count());
                errorStrategy,
    // Warmup configuration and state
    /**
    // indicates number of messages dropped due to error
            logger.info(
    }
        IngestionShardPointer resetPointer = null;
                Thread.sleep(CONSUMER_INIT_RETRY_INTERVAL_MS);
            return this;
                blockingQueueSize,
        IngestionShardPointer startPointer,
         * Set max poll size
                totalPolledCount.inc();
        int numProcessorThreads,
                threshold
    /**
                    break;
        if (consumer != null && (currentTime - lastPointerBasedLagUpdateTime >= pointerBasedLagUpdateIntervalMs)) {
        }
            this.maxPollSize = maxPollSize;
import java.util.Comparator;
        consumerThread.shutdown();
        this.consumerClientId = Objects.requireNonNull(consumerClientId);
            return this;
            throw new IllegalStateException("poller is closed!");
                pause();
        if (!warmupConfig.isEnabled()) {
            this.mapperSettings = mapperSettings != null ? mapperSettings : Collections.emptyMap();
    }
            return this;
            ingestionEngine.config().getIndexSettings(),
    private volatile IndexMetadata currentIndexMetadata;
         * Initialize the builder with mandatory parameters
        }
    private ResetState resetState;
        boolean completed = warmupLatch.await(timeoutMs, TimeUnit.MILLISECONDS);
                } else {
            if (event.blocksChanged() == false) {
                    results = consumer.readNext(maxPollSize, pollTimeout);
                    handleConsumerInitialization();
            }
    @Override
                cachedPointerBasedLag = consumer.getPointerBasedLag(initialBatchStartPointer);
        this.pointerBasedLagUpdateIntervalMs = pointerBasedLagUpdateIntervalMs;
    }
        this.payloadDecoder = Objects.requireNonNull(payloadDecoder);
        this(
import org.opensearch.index.IndexSettings;
            warmupComplete = true;
                indexName,
     * Updates the warmup configuration dynamically.
    private ExecutorService consumerThread;
        private IndexMetadata indexMetadata;
        /**
        if (closed) {
            warmupLatch.countDown();
        public Builder indexMetadata(IndexMetadata indexMetadata) {
                shardId,
import java.util.concurrent.CountDownLatch;
    ) {
                        logger.error("Error in pausing the poller of shard {}: {}", shardId, e);
        if (newState == State.CLOSED || newState == State.PAUSED) {
        long currentLag = cachedPointerBasedLag;
    @Override
        );
                // Check warmup status if not yet complete
        PartitionedBlockingQueueContainer blockingQueueContainer,
        private int numProcessorThreads = 1;
    private volatile boolean reinitializeConsumer;
            } catch (Exception e) {
    @Override
import org.opensearch.index.engine.IngestionEngine;
import org.opensearch.index.IngestionShardConsumer;
    }
                    } catch (Throwable e) {
    }
     * Handles the reset state logic.
                totalConsumerErrorCount.inc();
    private void setStateWithWarmupAwareness(State newState) {
     */
                threshold
        }
        private long maxPollSize = 1000;
            );
        String consumerClientId,
        // If warmup is disabled, mark as complete immediately
    private volatile State state = State.NONE;
            state = State.WARMING_UP;
    @Override
                payloadDecoder
        public Builder initialState(State initialState) {
import org.opensearch.cluster.metadata.IndexMetadata;
                ingestionEngine,
                case RESET_BY_TIMESTAMP:
     * Sets the poller state with warmup-aware logic.
            return;
                    setStateWithWarmupAwareness(State.CLOSED);
                indexName,
            this.state = State.WARMING_UP;
        this.errorStrategy = errorStrategy;
    }
    /**
                logger.error("Error in closing the poller of shard {}: {}", shardId, e);
     * latest batchStartPointer using the updated index metadata.
        if (lastPolledMessageTimestamp != timestamp) {
    }
    public void clusterChanged(ClusterChangedEvent event) {
    /**
                shardId,
    public PollingIngestStats getStats() {
            );
                resetState,
        // If interval is 0, pointer-based lag is disabled
    private DefaultStreamPoller(
     */
        IngestionConsumerFactory consumerFactory,
    /**
            this.startPointer = startPointer;
        logger.info("closed the poller of shard {}", shardId);
public class DefaultStreamPoller implements StreamPoller {
            IngestionShardPointer startPointer,
                startPointer,
                    resetPointer = consumer.earliestPointer();
    /**
        IngestionErrorStrategy errorStrategy,
        this.indexName = indexSettings.getIndex().getName();
    public IngestionShardPointer getBatchStartPointer() {
        consumerThread.submit(this::startPoll);
            } catch (Exception e) {
        // Skip warmup if poller is paused or warmup is disabled
                pipelineExecutor
                elapsedTime,
    @Nullable
            try {
                }
    private long computeTimeBasedLag() {
                    logger.info("Resetting pointer by seeking to pointer {}", resetPointer.asString());
        }
    @Override
            logger.warn(
        IngestionSource.WarmupConfig warmupConfig,
    }
            payloadDecoder.close();
     * the current consumer position and the end of the stream. This is the preferred mode for
            }
        builder.setTotalProcessorThreadInterruptCount(processorMetrics.processorThreadInterruptCounter().count());
            initialBatchStartPointer = resetShardPointer;
            isWriteBlockEnabled = state.blocks().indexBlocked(ClusterBlockLevel.WRITE, indexName);
    @Override
        this.errorStrategy = errorStrategy;
    // flag to indicate if consumer needs to be reinitialized
        }
    private final String indexName;
     * Called when index settings are changed at runtime.
         * Set mapper settings
        // Close only after the consumer thread has reached CLOSED (or the wait timed out), so any
                pipelineExecutor,
                    String.valueOf(result.getMessage().getPayload()),
         * Set error strategy
                if (this.consumer == null || reinitializeConsumer) {
        this.consumerThread = Executors.newSingleThreadExecutor(
    private volatile boolean paused;
        return consumer;
        IngestionSource.WarmupConfig warmupConfig,
        this.resetValue = resetValue;
        ) {
                    logger.info(
        IngestionShardPointer restartPointer = getBatchStartPointer();
        blockingQueueContainer.close();
                shardId,
                // processRecords returns failed shard pointers. Update forcedShardPointer to the failed pointer to retry on next iteration
    private int shardId;
        } else if (timeoutReached) {
         */
         * Set reset state
        this.warmupConfig = Objects.requireNonNull(warmupConfig);
    }
     * Messages must be written to the blocking queue in the same order in which they were received from the consumer to
            newConfig.timeout(),
import org.opensearch.common.metrics.CounterMetric;
    }
        PollingIngestStats.Builder builder = new PollingIngestStats.Builder();
        /**
    }
                consumerClientId,
        }
     * is called.
        long pointerBasedLagUpdateIntervalMs,
        long pointerBasedLagUpdateIntervalMs,
     * Note: cachedPointerBasedLag is -1 by default (indicating no messages consumed yet) and is only updated after updatePointerBasedLagIfNeeded()
    ) {
                errorStrategy,
    }
            this.resetState = resetState;
        }
            new PartitionedBlockingQueueContainer(
 * Default implementation of {@link StreamPoller}
         * Set blocking queue size
        int shardId,
    private IngestionShardPointer getResetShardPointer() {
                    logger.info("Resetting pointer by seeking to latest pointer {}", resetPointer.asString());
                    setStateWithWarmupAwareness(State.PAUSED);
            logger.warn("Failed to create consumer for shard {}: {}", shardId, e.getMessage());
            throw new RuntimeException("poller is closed!");
    public boolean isPaused() {
                // Initialize/reinitialization consumer
            try {
     *
        closed = true;
        closePayloadDecoder();
    @Override
                isWarmupComplete()
        if (lagBelowThreshold) {
            .min(Comparator.naturalOrder())
     * ensure ordering guarantees.
    }
        private IngestPipelineExecutor pipelineExecutor;
    private IngestionShardPointer forcedShardPointer = null;
            return this;
import org.opensearch.index.IngestionShardPointer;
        if (!completed) {
                currentLag,
     */
     * Update the cached pointer-based lag if enough time has elapsed since the last update.
                }
        this.maxPollSize = maxPollSize;
     */
        this.currentIndexMetadata = updatedIndexMetadata;
                    resetPointer = consumer.latestPointer();
 *
                        resetValue,
                if (errorStrategy.shouldIgnoreError(e, IngestionErrorStrategy.ErrorStage.POLLING) == false) {
                    // Blocking error encountered. Pause poller to stop processing remaining updates.
            IngestionConsumerFactory consumerFactory,
                numProcessorThreads,
     */
                }
                logger.warn("Failed to update lag for index {} shard {}: {}", indexName, shardId, e.getMessage());
            }
         * Set mapper type
    }
        public Builder(
            logger.error("Error applying cluster state in stream poller", e);
        }
import org.apache.logging.log4j.Logger;
                    break;
                logger.warn("Error closing consumer for index {} shard {}: {}", indexName, shardId, e.getMessage());
        }
        private String resetValue = "";
                blockingQueueContainer.add(shardUpdateMessage);
    private void updateWarmupStatus() {
        // set processor stats
        private String consumerClientId;
        }
        } catch (Exception e) {
        if (this.consumer == null) {
            } catch (InterruptedException ie) {
                logger.info("Closing consumer for index {} shard {}", indexName, shardId);
        private IngestionPayloadDecoder payloadDecoder = new XContentIngestionPayloadDecoder();
                if (paused || isWriteBlockEnabled) {
import org.opensearch.index.IngestionConsumerFactory;
    // start of the batch, inclusive
        }
