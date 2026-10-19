     * (not pre-declared on {@link ExchangeSinkContext.ChildInput}) — the backend
 * this file be licensed under the Apache-2.0 license or a
     *
     * <p>The schema of each child's batches is learned at the backend boundary
 * SPDX-License-Identifier: Apache-2.0
     * <p>The {@code maxBytes} cap is enforced at runtime: if the accumulated build-side buffer
public interface ExchangeSinkProvider {
     */
     * <p>The {@code buildRowType} is the build stage's Calcite row type. The backend uses it
     *
     * analytics-engine on any specific backend's sink class.  
     *                            uses {@code targetWorkerNodeIds.get(p)} as the destination for
     * {@code CompletableFuture<byte[]> ipcBytesFuture()} method that completes when  
    /**
     * local scan output and must hash-partition each batch by {@code hashKeyChannels} into
     *                            partition {@code p}
     * reduced output into {@link ExchangeSinkContext#downstream()}.
 * Factory for creating a coordinator-side {@link ExchangeSink}.  
     *
 *
 * coordinator-side computation over them (final aggregate, sort, etc.) implements  
                + "to return an ExchangeSink whose close() completes ipcBytesFuture() with the build-side Arrow IPC bytes."
     *                            {@link ShuffleSender#send} once per partition per batch and
        ShuffleSender sender,  
        throw new UnsupportedOperationException(  
        org.apache.calcite.rel.type.RelDataType buildRowType,
     * size exceeds it, the sink fails its {@code ipcBytesFuture()} so the dispatcher routes the  
     * @param partitionCount      total number of consumer partitions; the sink must produce
    default ExchangeSink createPartitionedSink(
     * @param hashKeyChannels     0-indexed input channels to hash on  
/**
     * @param context             the standard sink context (allocator, child inputs, etc.)  
     */  
     * {@code targetWorkerNodeIds[partitionIndex]} via the framework-supplied {@link ShuffleSender}.
 *
    }  
     * dispatcher accesses that method reflectively to avoid a compile-time dependency from
 * A {@code null} return means the backend cannot act as a coordinator-side executor.
     * at least one {@link DataTransferCapability} with {@link DataTransferCapability.Kind#PRODUCER}.
 * this interface.
        );  
     * @param context core-provided context carrying plan bytes, allocator, child inputs, and downstream sink  
     *
        );
            "Backend does not support hash-partitioned shuffle sinks. "
/*  
package org.opensearch.analytics.spi;
 *
            "Backend does not support broadcast-capture sinks. Override createBroadcastCaptureSink "  
    ExchangeSink createSink(ExchangeSinkContext context, BackendExecutionContext backendContext);
 */
     * applies backpressure retry via {@code ShuffleSenderRetry} under the hood. Backends own
                + "Declare a DataTransferCapability(PRODUCER, ...) and override createPartitionedSink."
     * representation in the way it already does for normal scan output.  
    ) {
     *
 * <p>Returned by {@link AnalyticsSearchBackendPlugin#getExchangeSinkProvider()}.  
     * as the fallback schema when the build stage emits zero batches — without it, an  
}
    default ExchangeSink createBroadcastCaptureSink(  
        int partitionCount,
 */  
     * the join's NamedScan binding. Each backend converts {@code RelDataType} to its Arrow
        List<String> targetWorkerNodeIds,
import org.apache.arrow.memory.BufferAllocator;
import java.util.List;  
     *  
        BufferAllocator allocator,
     * @param sender              framework-provided transport wrapper; the sink calls  
        List<Integer> hashKeyChannels,  
     * all-empty build side would register a zero-column memtable on the probe side and break
     * uses {@link ExchangeSinkContext#fragmentBytes()} as the serialized plan  
    ) {
     * support do not need to opt in. Backends that support shuffle must override AND declare  
        ExchangeSinkContext context
 * The OpenSearch Contributors require contributions made to  
     * the producer-side plan bytes already encode the producer schema.
 *
 * compatible open source license.
     * Creates a capture sink used by the M1 broadcast-join coordinator to buffer the build
     * derives it when it registers the child input on its native session, since  
        long maxBytes  
     * @param targetWorkerNodeIds {@code targetWorkerNodeIds.size() == partitionCount}; the sink  
     * Creates a sink for coordinator-side execution. The backend implementation
     *
     * <p>Default impl throws {@link UnsupportedOperationException} — backends without shuffle
     * stage's output into Arrow IPC bytes. The returned sink must expose a
     * <p>Default impl throws {@link UnsupportedOperationException} — backends that don't  
     */
 * <p>A backend that can accept Arrow Record Batches from data nodes and run
     * framework builds the sender, stamps it with {@code (queryId, targetStageId, side)}, and
     * {@link ExchangeSink#close()} finishes, delivering the full build-side payload. The
     *
     * the partitioning algorithm only; the framework owns the wire.  
     * participate as the coordinator-side broadcast build collector do not need to opt in.
     *                            partition indices in {@code [0, partitionCount)}
     * Creates a partitioned sink for hash-shuffle producers. The sink consumes the data-node's
     * failure through the query's terminal listener. Pass {@code Long.MAX_VALUE} to disable.
        throw new UnsupportedOperationException(
     * (produced by {@code FragmentConvertor#convertFragment}) and writes its
     *                            once per partition at close with {@code isLast=true}
     * @param backendContext backend-opaque state produced by instruction handlers (e.g.
     *        {@code FinalAggregateInstructionHandler}), or {@code null} when no handler ran
    /**  
     * {@code partitionCount} buckets, shipping each bucket to the worker at  
    /**  
     * <p>Backends never touch {@code Client} or the transport action types directly — the  
    }
 * @opensearch.internal  
