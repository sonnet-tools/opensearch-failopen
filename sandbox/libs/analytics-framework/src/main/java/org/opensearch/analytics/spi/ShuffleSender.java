 * compatible open source license.
 * {@link org.opensearch.transport.client.Client} or the transport action types directly.
     * @param listener           receives one notification per send: {@code onResponse} on
 * framework owns retry, scheduling, and node-id-to-transport routing.  
 *
 * stage. The framework constructs the sender when it sees a  
     *                           {@code targetWorkerNodeIds[partitionIndex]}
     * @param targetWorkerNodeId destination node id from the producer instruction's
     *                           {@code (queryId, targetStageId, side)} channel; consumer
     *                           once per call.
     *                           consumer uses this to route into its per-partition buffer slice
 */  
     *                           on transport error or retry exhaustion. Always invoked exactly  
public interface ShuffleSender {
 * The OpenSearch Contributors require contributions made to  
     * this once per partition per fed batch (with {@code isLast=false}), and once per partition  
     */
import org.opensearch.core.action.ActionListener;
 * {@code ShuffleProducerInstructionNode} on a fragment; the sink calls {@link #send} for each
    void send(String targetWorkerNodeId, int partitionIndex, byte[] data, boolean isLast, ActionListener<Void> listener);  
 * to ship a per-partition payload to its target worker. Supplied to
 * Framework-provided wrapper around the shuffle transport that hash-shuffle producer sinks call
 *
     *                           success (including after backpressure retry), {@code onFailure}
    /**
     *                           {@code isLast=true} carries no payload)  
     * @param data               Arrow IPC bytes for one record batch (or {@code null}/empty when
 * <p>Lifecycle: a backend's {@link ExchangeSink} owns one {@code ShuffleSender} per producer
     * at sink close (with empty {@code data} and {@code isLast=true}) to release the consumer's
     * {@code awaitReady} latch.
     * @param isLast             marks the final transmission for {@code partitionIndex} on this
/**  
     * Ship one shuffle payload to the worker at {@code targetWorkerNodeId}. Producer sinks call
 *
}
/*  
 * {@link ExchangeSinkProvider#createPartitionedSink} so backends never touch  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     *                           awaitReady fires when every sender has sent its isLast  
 */
 * {@code ShuffleSenderRetry} so backpressure-rejected sends are automatically retried with
 * partition's batch payload, then {@link #send} again with {@code isLast=true} on every target
     *  
 * <p>The framework's implementation wraps {@code AnalyticsShuffleDataAction} with  
 * to release the consumer's per-side latch.  
package org.opensearch.analytics.spi;
     * @param partitionIndex     destination partition (the consumer-side bucket key); the  
 * exponential backoff. Backends only need to call {@link #send} once per partition payload; the
