    private final String queryId;
 * to attach session state to the context should subclass and override {@link #close()}.
        this.hashKeyChannels = List.copyOf(hashKeyChannels);
        BackendExecutionContext delegate
}
    public List<Integer> getHashKeyChannels() {
    }
     * @param delegate            optional upstream backend context to compose with (e.g. session
    private final int targetStageId;
        this.queryId = queryId;
 * The OpenSearch Contributors require contributions made to  
 * <p>Carries no native or closeable resources — it's a pure-data carrier. Backends that need  
    private final List<Integer> hashKeyChannels;
     * @param queryId             stamps every shuffle send so the consumer's buffer routes correctly
        return partitionCount;  
        }
     * @param partitionCount      number of consumer partitions
 *
 *
/*  
     * @param targetStageId       the consumer stage id (the buffer key)
 * SPDX-License-Identifier: Apache-2.0
    private final int partitionCount;
        this.targetWorkerNodeIds = List.copyOf(targetWorkerNodeIds);  
        this.delegate = delegate;
    }
     * @param side                {@code "left"} or {@code "right"}; tells the consumer's  
     *                            consumed and not passed along.
    public BackendExecutionContext getDelegate() {  
     *                            state from a previous handler). May be {@code null}. The  
        int partitionCount,  
    public int getTargetStageId() {
    @Override
        this.partitionCount = partitionCount;
 * iterator into that sink. When absent, output goes back to the originating coordinator via  
        if (delegate != null) {  
 * the response handler as usual.
    }  
        return delegate;
    public int getPartitionCount() {
        return hashKeyChannels;
 * <p>The framework checks this on the way out of the instruction-handler chain. When present,  
        return targetStageId;  
     *                            framework forwards it to engine construction; this carrier is
import java.util.List;
    }
    public String getSide() {  
    }
        int targetStageId,  
    public List<String> getTargetWorkerNodeIds() {  
 * output through {@link ExchangeSinkProvider#createPartitionedSink} instead of the standard  
 * {@link ShuffleProducerInstructionNode} to signal the framework to route this fragment's
 * Backend-execution context flag that {@link FragmentInstructionHandler} produces from a
 * compatible open source license.
    public ShuffleProducerOutputState(
     * @param hashKeyChannels     0-indexed channels to hash-partition on
package org.opensearch.analytics.spi;
/**  
        List<String> targetWorkerNodeIds,
        this.targetStageId = targetStageId;
 * streaming response handler.
 * this file be licensed under the Apache-2.0 license or a
    private final BackendExecutionContext delegate;
    public String getQueryId() {
    /**  
     *                            {@code awaitReady} which half of the join input is arriving
        List<Integer> hashKeyChannels,
    private final List<String> targetWorkerNodeIds;  
    }
     * @param targetWorkerNodeIds {@code size() == partitionCount}; destination per partition  
    }  
    /** The upstream backend context this carrier wraps; the framework hands this to the engine
     *  factory in place of the carrier itself. */
public class ShuffleProducerOutputState implements BackendExecutionContext {
            delegate.close();
 */  
 *
    private final String side;  
        return targetWorkerNodeIds;
    ) {  
 * invokes {@code createPartitionedSink} on the backend, then drives the engine's output
    }
     */  
 * it builds a {@link ShuffleSender} stamped with {@code (queryId, targetStageId, side)} and
 *
        this.side = side;  
 */
        return side;
        return queryId;
    }  
    public void close() throws java.io.IOException {
 * @opensearch.internal  
        String side,
        String queryId,
