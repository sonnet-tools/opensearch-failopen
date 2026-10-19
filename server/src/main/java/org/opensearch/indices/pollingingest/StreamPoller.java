    IngestionShardPointer getBatchStartPointer();  
     * Returns if write block is active for the poller.
     * Sets write block status for the poller.
    void pause();
    /**
    void updateErrorStrategy(IngestionErrorStrategy errorStrategy);
        EARLIEST,
     */  
        PAUSED,
     * Resume the poller polling
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
     */  
 *
     * Pause the poller
import org.opensearch.common.annotation.PublicApi;
    /**
     * Get the pointer to the start of the current batch of messages.
    /**
    IngestionErrorStrategy getErrorStrategy();
package org.opensearch.indices.pollingingest;
        CLOSED,  
     * Block until warmup is complete or timeout occurs.
    String BATCH_START = "batch_start";  
 * A poller for reading messages from an ingestion shard. This is used in the ingestion engine.
    /**  
     * Called when index settings are changed at runtime.
    /**
    boolean isWriteBlockEnabled();
    /**
        LATEST,  
     * This is called when ingestion source params are dynamically updated.  
    boolean isPaused();
     * Start the poller  
    boolean isClosed();
     * Requests the poller to reinitialize the consumer with updated index metadata.
        PROCESSING,  
/*  
    void setWriteBlockEnabled(boolean isWriteBlockEnabled);  
     *  A reset state to indicate how to reset the pointer
     * @param timeoutMs maximum time to wait in milliseconds  
     */  
     * @throws InterruptedException if the thread is interrupted while waiting
public interface StreamPoller extends Closeable, ClusterStateListener {
        RESET_BY_OFFSET,
    IngestionShardConsumer getConsumer();
     * @param updatedIndexMetadata the updated index metadata with new configuration parameters
}
import org.opensearch.cluster.ClusterStateListener;
    void requestConsumerReinitialization(IndexMetadata updatedIndexMetadata);  
     * Check if the poller is closed
/**
    /**
        NONE,  
    void start();;
 */  
    PollingIngestStats getStats();
 * this file be licensed under the Apache-2.0 license or a
    /**
    boolean isWarmupComplete();
        WARMING_UP,
        NONE,
     */
     */
     * @return true if warmup completed, false if timeout
     */
     * Update the error strategy for the poller.  
    void resume();  
    /**  
import java.io.Closeable;
     */
    void updateWarmupConfig(IngestionSource.WarmupConfig config);  
    }
    boolean awaitWarmupComplete(long timeoutMs) throws InterruptedException;
     */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.IngestionSource;  
    enum State {  
        POLLING,
     */
     * A state to indicate the current state of the poller
     */  
import org.opensearch.cluster.metadata.IndexMetadata;
     * @return true if the warmup phase is complete and the shard is ready to serve  
    /**
    /**
    /**  
     */
    @PublicApi(since = "3.6.0")  
     */
import org.opensearch.index.IngestionShardPointer;  
     */
import org.opensearch.index.IngestionShardConsumer;
     */
    State getState();  
     * @return if the poller is paused  
 */  
    }
        RESET_BY_TIMESTAMP,
    enum ResetState {
     */
    /**
    /**  
    /**  
     * Updates the warmup configuration dynamically.  
