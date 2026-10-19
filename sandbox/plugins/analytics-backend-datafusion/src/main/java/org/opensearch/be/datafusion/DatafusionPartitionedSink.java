public final class DatafusionPartitionedSink implements ExchangeSink {
            return;
        // by partition, not by row count.
        String logTag,
 * <p><b>Why native partitioning?</b> Hash-shuffle joins require producers and the consumer's
     *                             writes plain IPC
            return;
        while (pending.get() > 0 && System.currentTimeMillis() < deadlineMs) {
            } catch (Throwable t) {  
                    )
            // A previous feed already failed; drop further work but keep the pipeline draining
                        compression.zstdLevel()  
 * <p><b>Lifecycle.</b> {@code feed} is called once per engine batch; {@code close} is called once
 *  
        // df_partition_batch_by_hash re-exported the input FFI structs in place with a Rust-side
 * IPC serialization happen outside any lock so multiple feeds would interleave their FFM calls,  
            if (err instanceof Error e) throw e;
     * @param alloc                buffer allocator for Arrow C-data exports / IPC serialization
        }
import org.apache.logging.log4j.Logger;
        } catch (Throwable ignore) {}
        List<Integer> hashKeyChannels,  
                        ShuffleCompression.FACTORY,
                shipPayload(p, ipcBytes, /* isLast */ false);
            logTag,
    public void feed(VectorSchemaRoot batch) {
                partitionCount
                writer.writeBatch();
                writer.end();  
        } catch (Throwable ignore) {}  
     * to a single Arrow IPC stream containing one batch. Closes the C wrappers and the imported
            try {  
 *
                        compression.codec(),
            ArrowSchema arrowSchema = ArrowSchema.wrap(schemaPtr);
                    continue;  
        long[] partitionedFfi = null;
                "targetWorkerNodeIds.size() (" + targetWorkerNodeIds.size() + ") must equal partitionCount (" + partitionCount + ")"  
                LOGGER.warn("DatafusionPartitionedSink: failed to ship final marker for partition " + p + " (" + logTag + ")", t);
        try {
    private volatile boolean closed;  
        // consumer could begin draining BEFORE the retried data send lands — the late chunk would be  
            ByteArrayOutputStream baos = new ByteArrayOutputStream();  
    private long batchesFed;
            LOGGER.warn("DatafusionPartitionedSink: partition failed for " + logTag, t);  
        // PHASE 2: send isLast=true to every target so the consumer's per-side awaitReady latch fires.  
        pending.incrementAndGet();
        if (closed) {
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                        + targetNodeId  
        // alive via the Arc'd FFI_ArrowArray) never drops, and the original batch's buffers leak.
    private final BufferAllocator alloc;
                    : new ArrowStreamWriter(root, dictionaryProvider, Channels.newChannel(baos))
            inputArray.release();  
        this.targetWorkerNodeIds = List.copyOf(targetWorkerNodeIds);  
            batch.close();
            } catch (InterruptedException e) {
            } catch (Throwable ignore) {}
            // Best-effort cleanup of the input wrappers.
            } catch (Throwable t) {  
        // For each partition: import the (array, schema) pair back into a Java VSR, serialize to
            // plain (uncompressed) writer. This shrinks both the shipped bytes AND the heap-resident
 * compatible open source license.
        // backpressure-retrying inside ShuffleSender when close() runs. If we shipped isLast(p) now,
        awaitPendingDrain("isLast markers");  
                        + ", partition="  
            inputSchema.release();  
 * which is safe.
 */  
            err == null ? "none" : err.getMessage()
import org.apache.arrow.vector.VectorSchemaRoot;  
            Data.exportVectorSchemaRoot(alloc, batch, null, inputArray, inputSchema);  
        long deadlineMs = System.currentTimeMillis() + 60_000;  
    /**  
                inputArray.close();  
            // so close() can finalize and surface the first error.
            try {
            LOGGER.warn("DatafusionPartitionedSink: timed out draining {} for {} ({} sends still pending)", phase, logTag, pending.get());
     * root before returning. The returned bytes own no native memory.  
                pending.decrementAndGet();
        try {
    private final List<String> targetWorkerNodeIds;
 * {@code RepartitionExec(Hash)} uses {@code REPARTITION_RANDOM_STATE} as its hasher seed; calling  
        batchesFed++;  
    }  
            throw new IllegalStateException("DatafusionPartitionedSink: feed() after close()");
        } catch (Throwable ignore) {}
        try {
                );  
import java.util.concurrent.atomic.AtomicReference;  
            } catch (Throwable ignore) {}
            batch.close();
                shipPayload(p, new byte[0], /* isLast */ true);
    /**
            throw new RuntimeException(err);  
        }  
     */  
                LOGGER.warn(  
     */
            }
        ArrowSchema inputSchema = ArrowSchema.allocateNew(alloc);  
            return;
                    "DatafusionPartitionedSink: send failed ("
                return;
        }  
        }
     * Spins until the {@link #pending} send counter returns to zero (or a 60s deadline lapses).
/**
                        dictionaryProvider,
    @Override
        closed = true;
                batch.close();  
            try {
                firstError.compareAndSet(null, t);
        // Even partitions we never produced rows for need an isLast — the consumer counts senders
        this.partitionCount = partitionCount;
import java.util.concurrent.atomic.AtomicInteger;
        // exportVectorSchemaRoot moved the batch's buffers into the export; closing the source
 * this file be licensed under the Apache-2.0 license or a
     * {@link #pending} counter before send and decrements on completion (success or failure) so
                if (ipcBytes.length == 0) {
        String targetNodeId = targetWorkerNodeIds.get(partitionIndex);  
        int partitionCount,
            CDataDictionaryProvider dictionaryProvider = new CDataDictionaryProvider();  
 *
        awaitPendingDrain("data sends");
                        + ")",
            ArrowArray arrowArray = ArrowArray.wrap(arrayPtr);
    public DatafusionPartitionedSink(
 *
 * <p><b>Failure surface.</b> A native partitioner error or IPC serialization error stamps a  
     * the producer fragment's caller can wait on quiescence.  
     * @param sender               framework-provided wire wrapper, already stamped with the  
 * after the engine stream drains. On close, every target receives an {@code isLast=true} send
    /**  
import org.opensearch.analytics.exec.shuffle.ShuffleCompression;
        }  
        LOGGER.debug(
    private final int[] hashKeyIndices;  
 * code can poll completion by waiting until the counter returns to zero, but the sink itself
    private final String logTag;
        try {
        );
            batchesFed,
        // Wait for the isLast sends to drain too, so the sink is fully quiesced on return.
 * the {@code ShuffleSender}).
            if (err instanceof RuntimeException re) throw re;
 * batches sequentially per stream so concurrent feeds aren't expected, but the partitioning +
     * @param compression          resolved shuffle-IPC compression policy (from the cluster settings via  
import org.apache.arrow.c.ArrowSchema;
                    e
                // Empty partition for this batch — partitioner returns null FFI structs when no
        if (targetWorkerNodeIds.size() != partitionCount) {
        } catch (Throwable t) {
     * fragment (post stream-drain) on a worker thread already off the transport hot path. {@code phase}
        // root only releases its tracking shells. release() above is what frees the buffers.  
        // load-bearing for correctness: a data send for partition p (issued in feed()) may still be  
        }
import org.opensearch.analytics.spi.ShuffleSender;
            firstError.compareAndSet(null, t);
     * names the wave being drained for the timeout log.  
            try {
            public void onFailure(Exception e) {  
    @Override  
                byte[] ipcBytes = importAndSerializeToIpc(arrayPtr, schemaPtr);
                firstError.compareAndSet(null, e);  
 * sticky {@link #firstError}; subsequent feeds and {@code close} skip work but still send
        // isLast, every row this producer will ever ship has already been buffered.  
            return;
                        Channels.newChannel(baos),
        }
import org.apache.arrow.memory.BufferAllocator;
        try {
    private final AtomicInteger pending = new AtomicInteger(0);
        } catch (Throwable ignore) {}
        // admitted after the drain snapshot and silently dropped (codex round-5 BLOCKER #2). Ordering
            inputSchema.close();  
            partitionedFfi = NativeBridge.partitionBatchByHash(
            VectorSchemaRoot root = Data.importVectorSchemaRoot(alloc, arrowArray, arrowSchema, dictionaryProvider);
            } catch (Throwable ignore) {}
                    ? new ArrowStreamWriter(
     * @param targetWorkerNodeIds  one entry per partition; index {@code p} = destination for
        // the Java wrappers frees their 128-byte container buffers. Without release(), the Rust
            inputArray.close();  
     *                             {@link ShuffleCompression.Config#from}); {@link ShuffleCompression.Config#DISABLED}
        });
     * partitionCount + drain latency. Spinning is acceptable: close() happens once per producer
     *                             partition {@code p}; {@code size() == partitionCount}
        sender.send(targetNodeId, partitionIndex, data, isLast, new ActionListener<>() {
                Thread.currentThread().interrupt();
            try {
                firstError.compareAndSet(null, e);
import java.util.List;
        // PHASE 1: drain all in-flight DATA sends to zero BEFORE shipping any isLast. This is
     * Hands one partition's payload to the framework {@link ShuffleSender}. Increments the
    private static final Logger LOGGER = LogManager.getLogger(DatafusionPartitionedSink.class);  
    public void close() {  
                        + logTag
    ) {  
        this.sender = sender;
        // all data sends ahead of every isLast guarantees that when a consumer sees this producer's
 * SPDX-License-Identifier: Apache-2.0
 * output: for every batch the engine emits, hash-partition by {@code hashKeyChannels} into
        if (pending.get() > 0) {
     *                             {@code "queryId/stage/side"}
        this.hashKeyIndices = hashKeyChannels.stream().mapToInt(Integer::intValue).toArray();
import org.opensearch.analytics.spi.ExchangeSink;  
                inputSchema.memoryAddress(),  
            // auto-detects it — only the writer names a codec. NO_COMPRESSION falls back to the  
        try {
import org.apache.arrow.c.ArrowArray;
    private byte[] importAndSerializeToIpc(long arrayPtr, long schemaPtr) throws java.io.IOException {
        try (  
import org.opensearch.core.action.ActionListener;  
import java.io.ByteArrayOutputStream;
                inputArray.memoryAddress(),
     *                             into; the sink calls {@link ShuffleSender#send} per partition
import org.apache.arrow.vector.ipc.message.IpcOption;
            return baos.toByteArray();
        if (closed) {
                pending.decrementAndGet();
 * partition assignment matches what {@code HashJoinExec} would compute on the consumer side),  
     *                             different stages / sides can be distinguished. Typical value:
        if (err != null) {  
    private final AtomicReference<Throwable> firstError = new AtomicReference<>();
     */
                Thread.sleep(1);  
        // the consumer's awaitReady could fire (once every producer's isLast arrives) and the
import org.apache.arrow.c.CDataDictionaryProvider;  
                firstError.compareAndSet(null, t);
            throw new IllegalArgumentException(
        this.alloc = alloc;  
            try {
    private void awaitPendingDrain(String phase) {
                ArrowStreamWriter writer = compression.compress()
        if (batch.getRowCount() == 0) {  
        } catch (Throwable ignore) {}
            );  
    }
        List<String> targetWorkerNodeIds,
        }  
 * <p><b>Threading.</b> {@code feed} is callable from any thread; the sink itself is not  
 * re-entrant per partition (one call's exports use the same allocator). Producer engines emit
        }  
            }  
            batch.close();  
            long arrayPtr = partitionedFfi[2 * p];
        ShuffleSender sender,  
        // release callback (see api.rs partition_batch_by_hash). Fire release() before close() so  
     * Imports an FFI (array, schema) pair into a Java {@link VectorSchemaRoot} and serializes it
/*  
import java.nio.channels.Channels;  
 * does not block on send acknowledgement (sends are fire-and-forget with retry handled inside  
            @Override  
 */  
 * {@code HashJoinExec} to agree on which partition a row lands in. DataFusion's
        }
        }
 * {@code isLast} so the consumer doesn't hang. The first error is rethrown from {@code close}.
}
 * (empty payload) so the consumer's per-side {@code awaitReady} latch releases. Send completions  
            // buffered chunks the consumer accumulates (the shuffle circuit-breaker relief).
            // Compress the IPC buffers with the configured codec (default ZSTD). The codec id is
            }  
                        + partitionIndex
package org.opensearch.be.datafusion;
            );
                inputSchema.close();  
 * the same {@code BatchPartitioner} from the producer guarantees consistency without
            ) {  
            long schemaPtr = partitionedFfi[2 * p + 1];  
 * DataFusion's hash-partitioned {@link ExchangeSink}. Sits at the tail of a producer fragment's  
            try (  
     * {@code ShuffleSender} handles backpressure retry, so this is bounded by the per-send retry cap ×  
        ArrowArray inputArray = ArrowArray.allocateNew(alloc);
     * @param logTag               opaque identifier used in log messages so producer streams from  
            batch.close();  
    }
     * @param partitionCount       number of consumer partitions  
 * serialize each non-empty partition to Arrow IPC bytes, and ship the bytes to
    }
        ShuffleCompression.Config compression
                writer.start();
    private final ShuffleCompression.Config compression;
                        + ", target="
            }
    }
    /**  
                continue;
                }
            }  
                hashKeyIndices,
        BufferAllocator alloc,
                        root,  
        // the Rust-side callback decrements its Arc refs to the imported ArrayData; then closing
            "DatafusionPartitionedSink: closed ({}, batches={}, partitions={}, error={})",  
     */
 * {@code partitionCount} buckets via DataFusion's native {@code BatchPartitioner} (so the
        // ArrayData (which transitively holds the original Java-side ExportedArrayPrivateData  
        this.logTag = logTag;
 *  
import org.apache.arrow.vector.ipc.ArrowStreamWriter;
            if (arrayPtr == 0 || schemaPtr == 0) {
 * The OpenSearch Contributors require contributions made to  
        ) {
            public void onResponse(Void unused) {
        if (firstError.get() != null) {  
 * {@code targetWorkerNodeIds[partitionIndex]} via the framework-provided {@link ShuffleSender}.
                LOGGER.warn("DatafusionPartitionedSink: failed to ship partition " + p + " for " + logTag, t);
     *                             {@code (queryId, targetStageId, side)} this sink is shipping
    private void shipPayload(int partitionIndex, byte[] data, boolean isLast) {
        // IPC bytes, and ship.  
        this.compression = compression;  
            // written into each IPC message's metadata, so the consumer's ArrowStreamReader
    private final int partitionCount;
import org.apache.arrow.c.Data;
                        IpcOption.DEFAULT,  
        for (int p = 0; p < partitionCount; p++) {  
    }
        Throwable err = firstError.get();
            partitionCount,  
                // rows hashed there. Skip serialization; isLast at close() will release the latch.  
        for (int p = 0; p < partitionCount; p++) {
            @Override
 * reverse-engineering the seed in JVM code.
            }
     * @param hashKeyChannels      0-indexed input channels to hash on
    private final ShuffleSender sender;  
            }
import org.apache.logging.log4j.LogManager;  
 * are tracked through one shared {@link AtomicInteger} pending counter — the framework's calling
        }  
