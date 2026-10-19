    private static long bufferSize(VectorSchemaRoot batch) {  
                schemaSnapshot = fallbackSchema;
        this.fallbackSchema = fallbackSchema;
    private final Schema fallbackSchema;
            ArrowStreamWriter writer = new ArrowStreamWriter(headerRoot, null, Channels.newChannel(out))  
package org.opensearch.be.datafusion;
                    writer.writeBatch();
     *
        // zero-column root, and the data-node serializer omits the schema header when it
import org.apache.logging.log4j.Logger;  
 * The OpenSearch Contributors require contributions made to  
                    // Skip batches whose column count doesn't match the header. RowResponseCodec  
                batch.close();
 * <p>Unlike {@link DatafusionMemtableReduceSink}, this sink does not talk to DataFusion's FFM at  
 *
            boolean batchHasColumns = !batchSchema.getFields().isEmpty();
     * <p>The fallback schema is used when the build stage emits no batches at all (or only  
     * Creates a capture sink with an explicit fallback schema and a runtime byte cap. If the  
        synchronized (lock) {
    public BroadcastCaptureSink(BufferAllocator alloc, Schema fallbackSchema) {
            closed = true;  
    }  
        this(alloc, fallbackSchema, DEFAULT_MAX_BYTES);
        return total;
    private final List<VectorSchemaRoot> batches = new ArrayList<>();
     * that has at least one column. Empty/header-only batches (produced by the response codec  
        this.maxBytes = maxBytes;
    public BroadcastCaptureSink(BufferAllocator alloc, Schema fallbackSchema, long maxBytes) {
import org.apache.arrow.vector.VectorSchemaRoot;
     * {@code Schema(List.of())} and break the probe Substrait plan.  
        // 1. A real schema captured from a fed batch (preferred).
 *
 *
}  
            if (batchHasColumns && (schema == null || schema.getFields().isEmpty())) {
                return;
 * {@code BroadcastInjectionInstructionNode} attached to each probe-stage  
    private byte[] serializeToIpc(Schema schemaSnapshot, List<VectorSchemaRoot> toSerialize) throws Exception {
                    root.close();  
 * Java-side collector producing wire bytes. The memtable registration happens on each probe
        // 3. An empty schema as a last-resort header so the IPC stream is decodable.  
        try (
            ipcBytesFuture.complete(bytes);
            }  
     * Appends a batch to the in-memory buffer. The sink takes ownership — callers must not
                    if (batch.getFieldVectors().size() != headerColumnCount) {
                // if no real batch ever arrives.
        synchronized (lock) {
                    headerRoot.setRowCount(batch.getRowCount());  
            }
                // First batch was a zero-column root and we don't have a real schema yet;
                        batch.getFieldVectors().get(i).makeTransferPair(headerRoot.getFieldVectors().get(i)).transfer();
            ipcBytesFuture.completeExceptionally(t);
                try {
        if (wasExceeded) {
            batches.add(batch);
                accumulatedBytes += batchBytes; // track the would-be total for the error message
     * whole build side is empty, {@link #close()} falls back to a zero-column schema.
 * SPDX-License-Identifier: Apache-2.0
            LOGGER.warn("[BroadcastCaptureSink] IPC serialization failed", t);
 * second {@code close()} is a no-op.
     */
            schemaSnapshot = schema;  
                batch.close();
     * Without it, an all-empty build payload caused the memtable to register with
 * threads concurrently; both are serialized on a single lock. Close-once semantics — a  
     * blowing up coordinator memory.
 * Coordinator-side {@link ExchangeSink} that buffers build-side Arrow batches from a broadcast
                throw new IllegalStateException("BroadcastCaptureSink: feed() after close()");
            if (closed) {  
    private boolean exceeded;
                    }  
            // from a null shard payload), emit header-only. On the probe side the broadcast
import org.apache.arrow.vector.types.pojo.Schema;
            accumulatedBytes += batchBytes;
import java.util.List;
 * stream byte array. The resulting bytes are exposed via {@link #ipcBytesFuture()} for the
                    // original schema's field ordering, then clear so the next batch's transfer is clean.
import java.nio.channels.Channels;
        return ipcBytesFuture;
     *
     * accumulated buffer-size of fed batches exceeds {@code maxBytes}, the sink fails its
     * <p>If a later non-empty batch disagrees with an already-captured empty-schema snapshot,
            wasExceeded = exceeded;
            if (fallbackSchema != null && !fallbackSchema.getFields().isEmpty()) {  
     *  
import java.util.ArrayList;  
        }
            ipcBytesFuture.completeExceptionally(ex);
        } catch (Throwable t) {  
                    root.close();  
 * {@code FragmentExecutionRequest}.
     */  
     * close the root afterwards; {@link #close()} closes every retained batch.  
            writer.start();
            total += v.getBufferSize();  
/**
            BroadcastSizeExceededException ex = new BroadcastSizeExceededException(observedBytes, maxBytes);  
import org.apache.arrow.memory.BufferAllocator;
                } catch (Throwable ignore) {
        long total = 0L;
    /**
    private static final long DEFAULT_MAX_BYTES = Long.MAX_VALUE;
    }
                } catch (Throwable ignore) {
     * @param maxBytes runtime cap on accumulated build-side buffer size, in bytes; pass
    private final CompletableFuture<byte[]> ipcBytesFuture = new CompletableFuture<>();  
    /**
                try {
                schema = batchSchema;  
        }
import java.util.concurrent.CompletableFuture;
            Schema batchSchema = batch.getSchema();  
        }  
        }
    /**
import org.opensearch.analytics.spi.ExchangeSink;
        }
                    }
                exceeded = true;  
                }  
     * we upgrade the snapshot to the real schema. Arrow IPC writer requires a single schema
     * for a null shard payload) keep {@code schema} null until a real batch arrives; if the
    /** Sums per-vector buffer sizes for the accumulator; cheap, off the lock-protected path. */
 * this file be licensed under the Apache-2.0 license or a
                    // produces a zero-column root for a null payload; the real build-side schema
            // memtable has no columns so the join over it produces zero rows for INNER and
            } else if (schema == null) {
        } finally {  
     *                 {@code Long.MAX_VALUE} to disable.  
public final class BroadcastCaptureSink implements ExchangeSink {  
    }  
     * zero-column phantoms produced by {@code RowResponseCodec} for empty IPC payloads).
                    // Transfer vectors into the header root so the writer emits them with the
        long batchBytes = bufferSize(batch);
            LOGGER.warn("[BroadcastCaptureSink] {}", ex.getMessage());
     * Serializes a list of batches to an Arrow IPC stream. Returns an empty-schema header-only  
                    // batch into the header root would walk off the field list.  
    }  
    private volatile Schema schema;
        this(alloc, null, DEFAULT_MAX_BYTES);
    }
            // sink as exceeded and drop the batch. Subsequent batches are dropped too. The
                    // is the one adopted by feed()'s schema-upgrade rule. Transferring a mismatched
    private final long maxBytes;  
    @Override
        int headerColumnCount = schemaSnapshot.getFields().size();  
        }  
    }  
    }  
 */
            return;
            LOGGER.debug("[BroadcastCaptureSink] captured {} batches → {} bytes", toSerialize.size(), bytes.length);
                        continue;
     * empty memtable rather than failing on the probe side).
        }  
                    headerRoot.clear();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for (org.apache.arrow.vector.FieldVector v : batch.getFieldVectors()) {
 * broadcast-dispatch orchestrator to embed in a
     * for the stream, and the real schema is the one the probe-side join needs.  
        boolean wasExceeded;  
            if (closed) {  
    /** Future completed with the Arrow IPC byte buffer when {@link #close()} finishes. */
            }
        ) {
        this.alloc = alloc;  
                schemaSnapshot = new Schema(List.of());  
                    // best-effort cleanup
            // preserves the probe side for OUTER — both correct for "empty build side".  
     * stream if no batches were fed (preserves downstream's ability to decode and register an
    public void feed(VectorSchemaRoot batch) {  
                return;  
                schema = batchSchema;
                    for (int i = 0; i < batch.getFieldVectors().size(); i++) {  
        Schema schemaSnapshot;
        // emits no batches at all. Without a fallback, an all-empty build side would  
            if (exceeded || accumulatedBytes + batchBytes > maxBytes) {
 * <p>Threading: {@link #feed} and {@link #close} may be called from multiple shard-handler
     */
                    // best-effort cleanup — an earlier exception is already being surfaced via the future
            }
    @Override
    public void close() {  
import java.io.ByteArrayOutputStream;
    public CompletableFuture<byte[]> ipcBytesFuture() {  
    }
    public BroadcastCaptureSink(BufferAllocator alloc) {  
    /** Default runtime byte cap when no explicit limit is set. Long.MAX_VALUE = effectively no cap. */
        // Schema selection priority:  
            for (VectorSchemaRoot root : toSerialize) {
        // The fallback exists because RowResponseCodec turns a null shard payload into a
            if (headerColumnCount > 0) {
            } else if (schemaSnapshot == null) {
        try {
            }
            writer.end();
    private static final Logger LOGGER = LogManager.getLogger(BroadcastCaptureSink.class);
    private final Object lock = new Object();
     * that to the terminal listener as a query failure, preventing a runaway broadcast from  
        // register a zero-column memtable on the probe side and break the join's NamedScan.
            byte[] bytes = serializeToIpc(schemaSnapshot, toSerialize);  
 * all — it has no session, no registered memtable, no native handle. It is purely a
            // failure is surfaced from close() so the dispatcher can route it through the  
        return out.toByteArray();
            VectorSchemaRoot headerRoot = VectorSchemaRoot.create(schemaSnapshot, alloc);
            // Still close any retained batches in the finally below.  
            batches.clear();
 * data node when {@code BroadcastInjectionHandler} decodes the payload.  
            for (VectorSchemaRoot root : toSerialize) {
/*  
        List<VectorSchemaRoot> toSerialize;
import org.apache.arrow.vector.ipc.ArrowStreamWriter;  
     * future with {@link BroadcastSizeExceededException} on close — the dispatcher routes
            observedBytes = accumulatedBytes;
            // Runtime cap check: if accumulating this batch would exceed the limit, mark the
 */  
        if (schemaSnapshot == null || schemaSnapshot.getFields().isEmpty()) {
    private boolean closed;  
                // remember the empty schema so close() can still produce a header-only stream  
     * <p>Schema capture policy: the real build-side schema is adopted from the first batch
                for (VectorSchemaRoot batch : toSerialize) {
     *
                }  
 * compatible open source license.
            // normal terminal-listener path.
import org.apache.logging.log4j.LogManager;
        long observedBytes;
            toSerialize = new ArrayList<>(batches);
            }  
 * build stage and, on {@link #close()}, serializes the whole buffer to a single Arrow IPC  
                }  
            }
    private long accumulatedBytes;
import org.opensearch.analytics.spi.BroadcastSizeExceededException;
            // P2a — if the captured schema is empty (every fed batch was a zero-column root  
        // 2. The fallback schema supplied at construction (build-side row type).
    private final BufferAllocator alloc;
            }
