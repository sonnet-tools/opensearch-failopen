                pending.decrementAndGet();
                        ShuffleCompression.FACTORY,
import org.apache.arrow.vector.ipc.message.IpcOption;
    private long batchesFed;
        // For each partition: import the (array, schema) pair back into a Java VSR, serialize to
        ShuffleSender sender,
                batch.close();
    /**
                byte[] ipcBytes = importAndSerializeToIpc(arrayPtr, schemaPtr);
            ArrowSchema arrowSchema = ArrowSchema.wrap(schemaPtr);
    ) {
import org.apache.arrow.memory.BufferAllocator;
                inputArray.memoryAddress(),
            // Best-effort cleanup of the input wrappers.
import java.util.List;
            batch.close();
 * <p><b>Failure surface.</b> A native partitioner error or IPC serialization error stamps a
    private final String logTag;
            }
            // A previous feed already failed; drop further work but keep the pipeline draining
                partitionCount
                // Empty partition for this batch — partitioner returns null FFI structs when no
        awaitPendingDrain("isLast markers");
package org.opensearch.be.datafusion;
            LOGGER.warn("DatafusionPartitionedSink: timed out draining {} for {} ({} sends still pending)", phase, logTag, pending.get());
        LOGGER.debug(
            return;
    }
                if (ipcBytes.length == 0) {
            try {
    }
/**
                firstError.compareAndSet(null, t);
        try {
        // isLast, every row this producer will ever ship has already been buffered.
    private final List<String> targetWorkerNodeIds;
     *                             {@code "queryId/stage/side"}
    private final ShuffleCompression.Config compression;
 * IPC serialization happen outside any lock so multiple feeds would interleave their FFM calls,
        ) {
        pending.incrementAndGet();
    /**
            } catch (Throwable t) {
     *                             writes plain IPC
        this.hashKeyIndices = hashKeyChannels.stream().mapToInt(Integer::intValue).toArray();
        ShuffleCompression.Config compression
    }
                shipPayload(p, ipcBytes, /* isLast */ false);
import org.apache.arrow.c.ArrowSchema;
                        + logTag
        ArrowArray inputArray = ArrowArray.allocateNew(alloc);
        if (err != null) {
                        compression.zstdLevel()
 *
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                );
    private volatile boolean closed;
/*
            return;
        // the consumer's awaitReady could fire (once every producer's isLast arrives) and the
     * Imports an FFI (array, schema) pair into a Java {@link VectorSchemaRoot} and serializes it
        closed = true;
            if (err instanceof RuntimeException re) throw re;
            );
        });
                writer.end();
import java.nio.channels.Channels;
                return;
     */
     * the producer fragment's caller can wait on quiescence.
 * reverse-engineering the seed in JVM code.
            Data.exportVectorSchemaRoot(alloc, batch, null, inputArray, inputSchema);
     *                             partition {@code p}; {@code size() == partitionCount}
        }
            // Compress the IPC buffers with the configured codec (default ZSTD). The codec id is
            CDataDictionaryProvider dictionaryProvider = new CDataDictionaryProvider();
 * output: for every batch the engine emits, hash-partition by {@code hashKeyChannels} into
    public void close() {
                LOGGER.warn(
        for (int p = 0; p < partitionCount; p++) {
     *                             {@code (queryId, targetStageId, side)} this sink is shipping
            firstError.compareAndSet(null, t);
    private void awaitPendingDrain(String phase) {
        }
     * Hands one partition's payload to the framework {@link ShuffleSender}. Increments the
     * to a single Arrow IPC stream containing one batch. Closes the C wrappers and the imported
            inputArray.close();
            err == null ? "none" : err.getMessage()
     * @param sender               framework-provided wire wrapper, already stamped with the
 * (empty payload) so the consumer's per-side {@code awaitReady} latch releases. Send completions
                }
    private final ShuffleSender sender;
     * partitionCount + drain latency. Spinning is acceptable: close() happens once per producer
    private final BufferAllocator alloc;
     * @param targetWorkerNodeIds  one entry per partition; index {@code p} = destination for
import org.apache.arrow.c.CDataDictionaryProvider;
            // plain (uncompressed) writer. This shrinks both the shipped bytes AND the heap-resident
    private static final Logger LOGGER = LogManager.getLogger(DatafusionPartitionedSink.class);
    private final int[] hashKeyIndices;
            partitionedFfi = NativeBridge.partitionBatchByHash(
        Throwable err = firstError.get();
        // PHASE 2: send isLast=true to every target so the consumer's per-side awaitReady latch fires.
        this.targetWorkerNodeIds = List.copyOf(targetWorkerNodeIds);
            throw new RuntimeException(err);
            batch.close();
 * compatible open source license.
        BufferAllocator alloc,
        if (batch.getRowCount() == 0) {
                firstError.compareAndSet(null, e);
        long[] partitionedFfi = null;
                shipPayload(p, new byte[0], /* isLast */ true);
        try {
        // root only releases its tracking shells. release() above is what frees the buffers.
            // written into each IPC message's metadata, so the consumer's ArrowStreamReader
import java.util.concurrent.atomic.AtomicReference;
        // exportVectorSchemaRoot moved the batch's buffers into the export; closing the source
            batch.close();
    /**
import org.opensearch.analytics.exec.shuffle.ShuffleCompression;
     * {@code ShuffleSender} handles backpressure retry, so this is bounded by the per-send retry cap ×
                        + targetNodeId
        if (closed) {
import org.apache.arrow.vector.ipc.ArrowStreamWriter;
    private final AtomicReference<Throwable> firstError = new AtomicReference<>();
                    continue;
            }
        } catch (Throwable ignore) {}
            @Override
 * DataFusion's hash-partitioned {@link ExchangeSink}. Sits at the tail of a producer fragment's
                    )
     * Spins until the {@link #pending} send counter returns to zero (or a 60s deadline lapses).
                        + ", partition="
        for (int p = 0; p < partitionCount; p++) {
        // the Rust-side callback decrements its Arc refs to the imported ArrayData; then closing
                    "DatafusionPartitionedSink: send failed ("
 * <p><b>Lifecycle.</b> {@code feed} is called once per engine batch; {@code close} is called once
    private final AtomicInteger pending = new AtomicInteger(0);
            } catch (Throwable ignore) {}
        if (closed) {
            public void onResponse(Void unused) {
 * <p><b>Threading.</b> {@code feed} is callable from any thread; the sink itself is not
 * <p><b>Why native partitioning?</b> Hash-shuffle joins require producers and the consumer's
                pending.decrementAndGet();
     * @param logTag               opaque identifier used in log messages so producer streams from
            } catch (InterruptedException e) {
            batch.close();
        if (firstError.get() != null) {
 * code can poll completion by waiting until the counter returns to zero, but the sink itself
 * {@code targetWorkerNodeIds[partitionIndex]} via the framework-provided {@link ShuffleSender}.
        this.logTag = logTag;
                writer.start();
     */
            inputArray.release();
 * {@code HashJoinExec} to agree on which partition a row lands in. DataFusion's
 * after the engine stream drains. On close, every target receives an {@code isLast=true} send
            try {
        // admitted after the drain snapshot and silently dropped (codex round-5 BLOCKER #2). Ordering
                ArrowStreamWriter writer = compression.compress()
 *
        }
            } catch (Throwable ignore) {}
        try {
                LOGGER.warn("DatafusionPartitionedSink: failed to ship partition " + p + " for " + logTag, t);
            ArrowArray arrowArray = ArrowArray.wrap(arrayPtr);
            }
        // release callback (see api.rs partition_batch_by_hash). Fire release() before close() so
 *
        try (
 * partition assignment matches what {@code HashJoinExec} would compute on the consumer side),
        // load-bearing for correctness: a data send for partition p (issued in feed()) may still be
            }
import org.apache.arrow.vector.VectorSchemaRoot;
        } catch (Throwable t) {
            inputSchema.close();
            );
     * names the wave being drained for the timeout log.
    }
 */
    public DatafusionPartitionedSink(
            partitionCount,
public final class DatafusionPartitionedSink implements ExchangeSink {
import org.opensearch.core.action.ActionListener;
     * fragment (post stream-drain) on a worker thread already off the transport hot path. {@code phase}
}
                continue;
            logTag,
        long deadlineMs = System.currentTimeMillis() + 60_000;
            try {
            long schemaPtr = partitionedFfi[2 * p + 1];
                firstError.compareAndSet(null, e);
import org.apache.logging.log4j.LogManager;
        String targetNodeId = targetWorkerNodeIds.get(partitionIndex);
                    ? new ArrowStreamWriter(
        try {
     *                             into; the sink calls {@link ShuffleSender#send} per partition
        }
    private void shipPayload(int partitionIndex, byte[] data, boolean isLast) {
            } catch (Throwable ignore) {}
import java.util.concurrent.atomic.AtomicInteger;
            try {
            try {
                        compression.codec(),
    private final int partitionCount;
            return;
 * {@code RepartitionExec(Hash)} uses {@code REPARTITION_RANDOM_STATE} as its hasher seed; calling
        // by partition, not by row count.
            if (err instanceof Error e) throw e;
            // so close() can finalize and surface the first error.
        }
            ) {
            if (arrayPtr == 0 || schemaPtr == 0) {
 * serialize each non-empty partition to Arrow IPC bytes, and ship the bytes to
        batchesFed++;
        // Even partitions we never produced rows for need an isLast — the consumer counts senders
        if (targetWorkerNodeIds.size() != partitionCount) {
            batchesFed,
     */
                        + ")",
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
 * the same {@code BatchPartitioner} from the producer guarantees consistency without
    public void feed(VectorSchemaRoot batch) {
            throw new IllegalStateException("DatafusionPartitionedSink: feed() after close()");
            @Override
                    e
            public void onFailure(Exception e) {
import java.io.ByteArrayOutputStream;
        String logTag,
                // rows hashed there. Skip serialization; isLast at close() will release the latch.
 * this file be licensed under the Apache-2.0 license or a
        awaitPendingDrain("data sends");
                Thread.currentThread().interrupt();
            return baos.toByteArray();
                "targetWorkerNodeIds.size() (" + targetWorkerNodeIds.size() + ") must equal partitionCount (" + partitionCount + ")"
 *
        this.alloc = alloc;
        // ArrayData (which transitively holds the original Java-side ExportedArrayPrivateData
    private byte[] importAndSerializeToIpc(long arrayPtr, long schemaPtr) throws java.io.IOException {
        // PHASE 1: drain all in-flight DATA sends to zero BEFORE shipping any isLast. This is
        // df_partition_batch_by_hash re-exported the input FFI structs in place with a Rust-side
            }
            try {
                        + partitionIndex
    /**
            long arrayPtr = partitionedFfi[2 * p];
                inputArray.close();
    @Override
                LOGGER.warn("DatafusionPartitionedSink: failed to ship final marker for partition " + p + " (" + logTag + ")", t);
        this.compression = compression;
            LOGGER.warn("DatafusionPartitionedSink: partition failed for " + logTag, t);
                        Channels.newChannel(baos),
import org.opensearch.analytics.spi.ShuffleSender;
import org.apache.arrow.c.Data;
                    : new ArrowStreamWriter(root, dictionaryProvider, Channels.newChannel(baos))
        sender.send(targetNodeId, partitionIndex, data, isLast, new ActionListener<>() {
        if (pending.get() > 0) {
     *                             {@link ShuffleCompression.Config#from}); {@link ShuffleCompression.Config#DISABLED}
    }
        this.partitionCount = partitionCount;
                hashKeyIndices,
            VectorSchemaRoot root = Data.importVectorSchemaRoot(alloc, arrowArray, arrowSchema, dictionaryProvider);
     * @param partitionCount       number of consumer partitions
        // alive via the Arc'd FFI_ArrowArray) never drops, and the original batch's buffers leak.
                        dictionaryProvider,
 * which is safe.
     *                             different stages / sides can be distinguished. Typical value:
 * does not block on send acknowledgement (sends are fire-and-forget with retry handled inside
                writer.writeBatch();
import org.opensearch.analytics.spi.ExchangeSink;
        int partitionCount,
        try {
        // IPC bytes, and ship.
 * sticky {@link #firstError}; subsequent feeds and {@code close} skip work but still send
 * are tracked through one shared {@link AtomicInteger} pending counter — the framework's calling
        // backpressure-retrying inside ShuffleSender when close() runs. If we shipped isLast(p) now,
                Thread.sleep(1);
 * The OpenSearch Contributors require contributions made to
                        + ", target="
        // the Java wrappers frees their 128-byte container buffers. Without release(), the Rust
            }
            try (
     */
            return;
     * @param alloc                buffer allocator for Arrow C-data exports / IPC serialization
        }
            throw new IllegalArgumentException(
        } catch (Throwable ignore) {}
import org.apache.arrow.c.ArrowArray;
     * @param hashKeyChannels      0-indexed input channels to hash on
        }
 * the {@code ShuffleSender}).
        // all data sends ahead of every isLast guarantees that when a consumer sees this producer's
                        IpcOption.DEFAULT,
        }
        );
            // auto-detects it — only the writer names a codec. NO_COMPRESSION falls back to the
        this.sender = sender;
     * root before returning. The returned bytes own no native memory.
                inputSchema.close();
    @Override
     * {@link #pending} counter before send and decrements on completion (success or failure) so
        } catch (Throwable ignore) {}
                firstError.compareAndSet(null, t);
        }
                inputSchema.memoryAddress(),
import org.apache.logging.log4j.Logger;
            } catch (Throwable t) {
     * @param compression          resolved shuffle-IPC compression policy (from the cluster settings via
        // Wait for the isLast sends to drain too, so the sink is fully quiesced on return.
        List<String> targetWorkerNodeIds,
 * SPDX-License-Identifier: Apache-2.0
        }
        while (pending.get() > 0 && System.currentTimeMillis() < deadlineMs) {
                        root,
        try {
        List<Integer> hashKeyChannels,
 */
 * re-entrant per partition (one call's exports use the same allocator). Producer engines emit
        } catch (Throwable ignore) {}
        // consumer could begin draining BEFORE the retried data send lands — the late chunk would be
 * {@code isLast} so the consumer doesn't hang. The first error is rethrown from {@code close}.
    }
        }
            inputSchema.release();
        ArrowSchema inputSchema = ArrowSchema.allocateNew(alloc);
            // buffered chunks the consumer accumulates (the shuffle circuit-breaker relief).
        }
 * {@code partitionCount} buckets via DataFusion's native {@code BatchPartitioner} (so the
 * batches sequentially per stream so concurrent feeds aren't expected, but the partitioning +
 *
            "DatafusionPartitionedSink: closed ({}, batches={}, partitions={}, error={})",
        } catch (Throwable ignore) {}
            }
