        List<VectorSchemaRoot> toSerialize;
        // 1. A real schema captured from a fed batch (preferred).
     * close the root afterwards; {@link #close()} closes every retained batch.
 * stream byte array. The resulting bytes are exposed via {@link #ipcBytesFuture()} for the
 * {@code FragmentExecutionRequest}.
            for (VectorSchemaRoot root : toSerialize) {
            } else if (schema == null) {
        }
                try {
                } catch (Throwable ignore) {
                exceeded = true;
            if (exceeded || accumulatedBytes + batchBytes > maxBytes) {
            }
 */
package org.opensearch.be.datafusion;
            closed = true;
    /**
                    // Skip batches whose column count doesn't match the header. RowResponseCodec
            boolean batchHasColumns = !batchSchema.getFields().isEmpty();
        }
}
    }
            byte[] bytes = serializeToIpc(schemaSnapshot, toSerialize);
                try {
            // sink as exceeded and drop the batch. Subsequent batches are dropped too. The
    private final Object lock = new Object();
                schemaSnapshot = new Schema(List.of());
            return;
                throw new IllegalStateException("BroadcastCaptureSink: feed() after close()");
                    // is the one adopted by feed()'s schema-upgrade rule. Transferring a mismatched
                    // batch into the header root would walk off the field list.
                } catch (Throwable ignore) {
            // Still close any retained batches in the finally below.
            VectorSchemaRoot headerRoot = VectorSchemaRoot.create(schemaSnapshot, alloc);
        }
    }
        long batchBytes = bufferSize(batch);
 * <p>Threading: {@link #feed} and {@link #close} may be called from multiple shard-handler
        // emits no batches at all. Without a fallback, an all-empty build side would
    public void feed(VectorSchemaRoot batch) {
        try {
/*
        Schema schemaSnapshot;
            ipcBytesFuture.complete(bytes);
import java.io.ByteArrayOutputStream;
                batch.close();
import org.apache.arrow.vector.ipc.ArrowStreamWriter;
            if (fallbackSchema != null && !fallbackSchema.getFields().isEmpty()) {
    private static long bufferSize(VectorSchemaRoot batch) {
            ArrowStreamWriter writer = new ArrowStreamWriter(headerRoot, null, Channels.newChannel(out))
        if (wasExceeded) {
    private byte[] serializeToIpc(Schema schemaSnapshot, List<VectorSchemaRoot> toSerialize) throws Exception {
                return;
     * future with {@link BroadcastSizeExceededException} on close — the dispatcher routes
                    // Transfer vectors into the header root so the writer emits them with the
public final class BroadcastCaptureSink implements ExchangeSink {
     * @param maxBytes runtime cap on accumulated build-side buffer size, in bytes; pass
            schemaSnapshot = schema;
                    // original schema's field ordering, then clear so the next batch's transfer is clean.
 * Coordinator-side {@link ExchangeSink} that buffers build-side Arrow batches from a broadcast
    }
    public CompletableFuture<byte[]> ipcBytesFuture() {
        }
     * Appends a batch to the in-memory buffer. The sink takes ownership — callers must not
        this(alloc, fallbackSchema, DEFAULT_MAX_BYTES);
            ipcBytesFuture.completeExceptionally(ex);
            }
     * for the stream, and the real schema is the one the probe-side join needs.
                return;
        synchronized (lock) {
    private boolean exceeded;
            LOGGER.warn("[BroadcastCaptureSink] IPC serialization failed", t);
            // normal terminal-listener path.
     * <p>The fallback schema is used when the build stage emits no batches at all (or only
     * <p>If a later non-empty batch disagrees with an already-captured empty-schema snapshot,
        this(alloc, null, DEFAULT_MAX_BYTES);
import java.util.concurrent.CompletableFuture;
     * Creates a capture sink with an explicit fallback schema and a runtime byte cap. If the
        this.alloc = alloc;
        // 2. The fallback schema supplied at construction (build-side row type).
        this.maxBytes = maxBytes;
     * Without it, an all-empty build payload caused the memtable to register with
            LOGGER.warn("[BroadcastCaptureSink] {}", ex.getMessage());
            writer.start();
        boolean wasExceeded;
            accumulatedBytes += batchBytes;
        }
     * that to the terminal listener as a query failure, preventing a runaway broadcast from
                }
     *
            total += v.getBufferSize();
            batches.add(batch);
                    headerRoot.clear();
    public BroadcastCaptureSink(BufferAllocator alloc, Schema fallbackSchema, long maxBytes) {
                    // best-effort cleanup — an earlier exception is already being surfaced via the future
import java.util.ArrayList;
import java.nio.channels.Channels;
            }
            // memtable has no columns so the join over it produces zero rows for INNER and
                schema = batchSchema;
 * {@code BroadcastInjectionInstructionNode} attached to each probe-stage
    private final BufferAllocator alloc;
    /**
                // First batch was a zero-column root and we don't have a real schema yet;
            // Runtime cap check: if accumulating this batch would exceed the limit, mark the
    /** Sums per-vector buffer sizes for the accumulator; cheap, off the lock-protected path. */
     * Serializes a list of batches to an Arrow IPC stream. Returns an empty-schema header-only
            BroadcastSizeExceededException ex = new BroadcastSizeExceededException(observedBytes, maxBytes);
     * for a null shard payload) keep {@code schema} null until a real batch arrives; if the
     * {@code Schema(List.of())} and break the probe Substrait plan.
     *
/**
import org.opensearch.analytics.spi.ExchangeSink;
                        continue;
                }
            }
                    root.close();
        try (
            observedBytes = accumulatedBytes;
            }
 * broadcast-dispatch orchestrator to embed in a
            if (batchHasColumns && (schema == null || schema.getFields().isEmpty())) {
    private static final Logger LOGGER = LogManager.getLogger(BroadcastCaptureSink.class);
                    writer.writeBatch();
import org.apache.arrow.memory.BufferAllocator;
        synchronized (lock) {
     * we upgrade the snapshot to the real schema. Arrow IPC writer requires a single schema
    private final CompletableFuture<byte[]> ipcBytesFuture = new CompletableFuture<>();
            // failure is surfaced from close() so the dispatcher can route it through the
        // Schema selection priority:
            if (headerColumnCount > 0) {
 *
            }
     * <p>Schema capture policy: the real build-side schema is adopted from the first batch
    private long accumulatedBytes;
            }
    /**
    }
        int headerColumnCount = schemaSnapshot.getFields().size();
import org.apache.arrow.vector.types.pojo.Schema;
                        batch.getFieldVectors().get(i).makeTransferPair(headerRoot.getFieldVectors().get(i)).transfer();
                }
                    }
    private boolean closed;
                // if no real batch ever arrives.
        ) {
 * this file be licensed under the Apache-2.0 license or a
                    headerRoot.setRowCount(batch.getRowCount());
 *
                for (VectorSchemaRoot batch : toSerialize) {
                accumulatedBytes += batchBytes; // track the would-be total for the error message
 * compatible open source license.
import java.util.List;
                schema = batchSchema;
import org.apache.logging.log4j.LogManager;
     * zero-column phantoms produced by {@code RowResponseCodec} for empty IPC payloads).
 * data node when {@code BroadcastInjectionHandler} decodes the payload.
                schemaSnapshot = fallbackSchema;
    private final long maxBytes;
     * blowing up coordinator memory.
    }
            // P2a — if the captured schema is empty (every fed batch was a zero-column root
            Schema batchSchema = batch.getSchema();
 * SPDX-License-Identifier: Apache-2.0
     */
     * that has at least one column. Empty/header-only batches (produced by the response codec
            }
     *
            // preserves the probe side for OUTER — both correct for "empty build side".
        } finally {
            if (closed) {
 *
 * build stage and, on {@link #close()}, serializes the whole buffer to a single Arrow IPC
 * threads concurrently; both are serialized on a single lock. Close-once semantics — a
import org.apache.logging.log4j.Logger;
                    for (int i = 0; i < batch.getFieldVectors().size(); i++) {
    private final List<VectorSchemaRoot> batches = new ArrayList<>();
        this.fallbackSchema = fallbackSchema;
    public void close() {
    private volatile Schema schema;
                    // produces a zero-column root for a null payload; the real build-side schema
        } catch (Throwable t) {
     */
            wasExceeded = exceeded;
    private static final long DEFAULT_MAX_BYTES = Long.MAX_VALUE;
    }
            writer.end();
        long total = 0L;
     *                 {@code Long.MAX_VALUE} to disable.
    }
        return total;
import org.apache.arrow.vector.VectorSchemaRoot;
    /** Future completed with the Arrow IPC byte buffer when {@link #close()} finishes. */
            toSerialize = new ArrayList<>(batches);
                // remember the empty schema so close() can still produce a header-only stream
        return out.toByteArray();
        // The fallback exists because RowResponseCodec turns a null shard payload into a
     *
        long observedBytes;
    /** Default runtime byte cap when no explicit limit is set. Long.MAX_VALUE = effectively no cap. */
    @Override
            // from a null shard payload), emit header-only. On the probe side the broadcast
                batch.close();
 * Java-side collector producing wire bytes. The memtable registration happens on each probe
            } else if (schemaSnapshot == null) {
     * stream if no batches were fed (preserves downstream's ability to decode and register an
     * accumulated buffer-size of fed batches exceeds {@code maxBytes}, the sink fails its
                    // best-effort cleanup
 * second {@code close()} is a no-op.
    public BroadcastCaptureSink(BufferAllocator alloc, Schema fallbackSchema) {
                    root.close();
 */
    @Override
        return ipcBytesFuture;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
            batches.clear();
    private final Schema fallbackSchema;
        }
     * whole build side is empty, {@link #close()} falls back to a zero-column schema.
        // zero-column root, and the data-node serializer omits the schema header when it
            ipcBytesFuture.completeExceptionally(t);
        // register a zero-column memtable on the probe side and break the join's NamedScan.
        // 3. An empty schema as a last-resort header so the IPC stream is decodable.
            if (closed) {
 * <p>Unlike {@link DatafusionMemtableReduceSink}, this sink does not talk to DataFusion's FFM at
    public BroadcastCaptureSink(BufferAllocator alloc) {
     */
                    }
                    if (batch.getFieldVectors().size() != headerColumnCount) {
        }
            LOGGER.debug("[BroadcastCaptureSink] captured {} batches → {} bytes", toSerialize.size(), bytes.length);
 * all — it has no session, no registered memtable, no native handle. It is purely a
        if (schemaSnapshot == null || schemaSnapshot.getFields().isEmpty()) {
import org.opensearch.analytics.spi.BroadcastSizeExceededException;
            for (VectorSchemaRoot root : toSerialize) {
 * The OpenSearch Contributors require contributions made to
    }
        for (org.apache.arrow.vector.FieldVector v : batch.getFieldVectors()) {
     * empty memtable rather than failing on the probe side).
