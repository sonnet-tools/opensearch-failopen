    @Override
        for (org.apache.arrow.vector.FieldVector v : batch.getFieldVectors()) {
 * <p><b>Multi-input.</b> {@link #sinkForChild(int)} returns a per-child buffering wrapper; each
     * allocator (set by {@code analytics.coordinator.buffer_limit}). {@link Long#MAX_VALUE}
        long batchBytes = bufferSize(batch);
        return failure;
 *
                streamPtr = NativeBridge.executeLocalPlan(session.getPointer(), ctx.fragmentBytes(), ctx.taskId());
                    for (int i = 0; i < arrays.size(); i++) {
            }
                if (streamPtr != 0) {
     */
import java.util.List;
        // — projected against live usage (getAllocatedMemory), and
            // Per-child EOF carries no native signal in the buffered path — the parent's reduce()
                session.close();
 * <p>Trade-off: all input batches live in memory until {@link #reduce}. For very large streaming
                    releaseConsumedChild(childStageId);
 * single-input case keeps the bare {@link #feed(VectorSchemaRoot)} path (one input under
            this.childStageId = childStageId;
        synchronized (feedLock) {
                    // container free only; data buffers are owned by native now
import org.apache.arrow.vector.VectorSchemaRoot;
import org.apache.arrow.c.Data;
                    failure = accumulate(failure, t);
    }
 * before reading the probe, so if the build-side producer's cross-node delivery back-pressures
 * {@code registerMemtable} call per child input, then {@code executeLocalPlan + drain}. No
        @Override
        public void feed(VectorSchemaRoot batch) {
            } catch (Exception t) {
        // getLimit() alone overstates what's actually grantable — getHeadroom() does not).
                    NativeBridge.RegisteredInput registered = NativeBridge.registerMemtable(
                try {
    }
        }
            );
        }
 * {@link AbstractDatafusionReduceSink#INPUT_ID}).
        // dominate the allocator's usage. A raw Arrow OutOfMemoryException can fire at ANY
            for (ArrowArray a : arrays) {
        // Ancestor-aware check: even within the per-query budget, the shared pool may be exhausted.
                        session.getPointer(),
            if (closed) {
     * {@code release()}d (fire the C release callback to free the buffers) THEN {@code close()}d
import org.opensearch.core.action.ActionListener;
            }
import java.util.Map;
            long streamPtr = 0;
                    NativeBridge.streamClose(streamPtr);
 */
     * only frees the 128-byte container with {@code close()} — calling {@code release()} here would
                    // partial failure (child A imported, child B throws) then frees B correctly
    /** Exports {@code batch} as an Arrow C-data pair into the given child's buffer. */
        // when the budget is unbounded (Long.MAX_VALUE — operator disabled the per-query limit).
                    long[] arrayPtrs = new long[arrays.size()];
            array = null;
     * (free the 128-byte FFI container). {@code close()} alone leaks the buffers.
            }
                } catch (Exception t) {
                }
            long projected = alloc.getAllocatedMemory() + need;
                    a.close();
                try {
        }
        if (preparedState == null) {
                    }
                    List<ArrowArray> arrays = arraysByChild.get(childStageId);
        for (List<ArrowArray> arrays : arraysByChild.values()) {
                failure = releaseUnconsumedBuffers(failure);
    @Override
    }
    }
    private void releaseConsumedChild(int childStageId) {
                try {
                    long[] schemaPtrs = new long[schemas.size()];
            try {
                        inputIdFor(childStageId),
                    // release-then-close path only ever touches inputs native did NOT consume — a
        //
        // exportVectorSchemaRoot shares the batch buffers by reference plus allocates per-buffer
            throw new IllegalStateException("DatafusionMemtableReduceSink requires at least one child input");
            schemasByChild.get(childStageId).add(arrowSchema);
                    s.close();
            }
        for (List<ArrowSchema> schemas : schemasByChild.values()) {
     * {@code finally}'s release-then-close path never touches consumed inputs. Swallows close errors
        this.bufferBudget = ctx.allocator().getLimit();
        if (arrays != null) {
        }
        Exception failure = releaseUnconsumedBuffers(null);
 * tokio mpsc in the input path.
                try (StreamHandle outStream = new StreamHandle(streamPtr, runtimeHandle)) {
                // import, or all children if executeLocalPlan failed pre-registration) — release+close.
    /**
            }
 * ({@link DatafusionReduceSink}) registers each input as a bounded-mpsc-backed
     * Single-input feed: buffers into the sole child's batch list. Multi-input callers route via
        private final int childStageId;
        }
                    childSchemas.put(childStageId, ArrowSchemaIpc.fromBytes(registered.schemaIpc()));
                    return;
        return false;
        if (bufferBudget != Long.MAX_VALUE) {
            for (ArrowArray a : arrays) {
            listener.onFailure(failure);
        // Fail fast BEFORE allocating, so the per-query Arrow allocator never hits a hard limit.
                }
        return total;
                session.close();
            try {
        @Override
                    // register_memtable MOVED these FFI structs into native (FFI_ArrowArray::from_raw);
                }
 * C Data pair and held until {@link #reduce} hands the full set(s) to native via one
    /**
        long total = 0L;
                    // container free only
     * fed batch is exported + appended to its child's buffer; {@code close()} is a no-op (the
/**
                    drainOutputIntoDownstream(outStream);
     */
     * {@link #closeImpl} and {@link #reduce}'s {@code finally}.
     * {@code ExportedArrayPrivateData}). Keeps the clean {@link ReduceSizeExceededException}
     * tripping before the raw allocator-limit OOM.
            throw new IllegalStateException(
        }
        if (failure == null) {
     * iteration. Releases the Arrow Java wrappers in {@code finally}.
    }
    private final Map<Integer, List<ArrowArray>> arraysByChild = new LinkedHashMap<>();
                        schemaPtrs[i] = schemas.get(i).memoryAddress();
            );
    public DatafusionMemtableReduceSink(ExchangeSinkContext ctx, NativeRuntimeHandle runtimeHandle) {
     * {@code register_memtable} ({@code FFI_ArrowArray::from_raw} moved them out of Java). Java
    /** Single-fire guard so a stray second {@link #reduce} call doesn't re-execute the plan. */
    public void reduce(ActionListener<Void> listener) {
                        schemaPtrs
                try (batch) {
            }
        // getHeadroom() returns the effective grantable bytes up the allocator tree.
        assert reduceStarted.compareAndSet(false, true) : "reduce called more than once";
            throw new ReduceSizeExceededException(alloc.getAllocatedMemory() + need, alloc.getAllocatedMemory() + alloc.getHeadroom());
        }
    /**
                    streamPtr = 0;
            } catch (Throwable ignore) {
                    s.release();
            arrays.clear();
        // (2) the allocator's getHeadroom(), which Arrow computes across the ANCESTOR chain
 * always run to completion + EOF, and the plan executes over complete in-memory inputs.
            }
    /** Memtable buffers all input first — never schedule concurrently with feeds (no bounded
    private static long bufferSize(VectorSchemaRoot batch) {
    /** Per-child buffered Arrow C-data pairs, keyed by child-stage id (iteration order = childInputs). */
        bufferBatch(childInputs.keySet().iterator().next(), batch);
                try {
        // (1) the per-query budget (this allocator's own limit, analytics.coordinator.buffer_limit)
        if (childInputs.size() != 1) {
            try {
 * child stage's output accumulates into its own batch list keyed by child-stage id and registers
                throw new ReduceSizeExceededException(projected, bufferBudget);
    /**
import org.apache.arrow.memory.BufferAllocator;
            throw new IllegalArgumentException(
    @Override
     * ran, it already cleared the per-child lists in its {@code finally}, so this finds them empty.
 * reductions prefer {@link DatafusionReduceSink} via {@code datafusion.reduce.input_mode=streaming}.
        }
import org.opensearch.be.datafusion.nativelib.NativeBridge;
            if (array != null) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.spi.ExchangeSink;
                "No registered input for childStageId=" + childStageId + "; known ids=" + arraysByChild.keySet()
                    a.release();
     * parent sink's {@link #reduce}/{@link #close} own the buffer lifecycle).
                // Original IllegalStateException carries the actionable message; suppress cleanup errors.
                        arrayPtrs,
 * <p><b>Why buffered, especially for multi-input.</b> The streaming sink
                    s.close();
    private final AtomicBoolean reduceStarted = new AtomicBoolean(false);
                }
 * on a bounded input mpsc the join is not yet draining, the producer blocks, never signals EOF,
        // The binding limit is the SMALLER of two ceilings, so we check both:
        }
import java.util.LinkedHashMap;
        if (childInputs.isEmpty()) {
    /** Sums per-vector buffer sizes; the off-heap cost of retaining this batch's data. */
     * size guard is then inert and the path behaves exactly as before. The live usage is read
            } catch (Exception t) {
                    failure = accumulate(failure, t);
     * Per-query off-heap budget for the buffered inputs: the limit of the query's Arrow
            listener.onResponse(null);
    private Exception releaseUnconsumedBuffers(Exception failure) {
                arrowSchema.close();
     * its import): {@code release()} fires the C release callback to free the data buffers, then
        }
import org.opensearch.analytics.spi.MultiInputExchangeSink;
public final class DatafusionMemtableReduceSink extends AbstractDatafusionReduceSink implements MultiInputExchangeSink {
                        child.getValue(),
    protected Exception closeImpl() {
            for (ArrowSchema s : schemas) {
                    // they no longer hold Java-side buffers. Drop the container references now (close
                // batch is closed by the caller's try-with-resources; do not allocate.
     * Registers each child's buffered batches as a distinct {@code "input-<childStageId>"}
    private void bufferBatch(int childStageId, VectorSchemaRoot batch) {
 * and the join's build never completes (observed on TPC-H q15). Buffering each input fully in
        }
        try {
 * as a distinct {@code "input-<childStageId>"} {@code MemTable} at {@link #reduce} time. The
            }
import java.util.ArrayList;
                    failure = accumulate(failure, t);
            synchronized (feedLock) {
 * The OpenSearch Contributors require contributions made to
        } else {
     * {@link ReduceSizeExceededException} on a sibling input, or an external cancel), the exported
            total += v.getBufferSize();
     * Releases any buffers {@link #reduce} didn't consume, then the session. When {@code reduce()}
 * inputs) that concurrency can deadlock: a {@code HashJoinExec} collects its build side fully
            arrowSchema = null;
 * <em>multi-input</em> coordinator operator (e.g. a {@code Join} over two SINGLETON-reduced
     * {@link #sinkForChild(int)} instead.
            if (arrowSchema != null) {
        public void close() {
        } finally {
     * means the operator disabled the per-query limit (shared coordinator allocator) — the
    private final class ChildSink implements ExchangeSink {
    }
 * compatible open source license.
        Exception failure = null;
            }
                // Anything left in the lists was NOT consumed by native (a child that threw before
        ChildSink(int childStageId) {
        return new ChildSink(childStageId);
            Data.exportVectorSchemaRoot(alloc, batch, null, array, arrowSchema);
        }
        // private data; we add an FFI margin so the clean failure trips before the raw OOM. Inert
            if (projected > bufferBudget) {
                } catch (Exception ignore) {
                    int childStageId = child.getKey();
     *  channel in the input path means non-eager is also deadlock-free for multi-input). */
        for (Integer childStageId : childInputs.keySet()) {
            schemas.clear();
            for (ArrowSchema s : schemas) {
        }
        if (need > alloc.getHeadroom()) {
                if (closed) {
 *
    @Override
            } finally {
     * MemTable, executes the plan, drains into the downstream. Holds {@link #feedLock} for the
     */
     */
    }
     * When the sink is closed BEFORE {@code reduce()} (cancel path — e.g. a size-guard
            arrays.clear();
                    // without double-releasing A.
                    batch.close();
    }
     */
        }
}
            }
    }
import org.opensearch.analytics.spi.ExchangeSinkContext;
            }
                try {
    }
                    );
     * {@code close()} frees the FFI container. {@code close()} alone leaks the buffers. Used by
     * Frees buffers that native never imported (cancel-before-reduce, or a child that threw before
import org.apache.arrow.c.ArrowSchema;
    /**
                return;
    /**
import org.opensearch.be.datafusion.nativelib.StreamHandle;
            schemasByChild.put(childStageId, new ArrayList<>());
import org.apache.arrow.c.ArrowArray;
     */
    @Override
            }
                failure = accumulate(failure, t);
                }
    /**
                array.close();
            // registers each child's accumulated buffer as a complete MemTable. No-op.
        // as a TaskCancelledException. So we refuse the batch up front when retaining it would not
     * Arrow C-data structs were never imported by native and still hold live buffers: they must be
            arraysByChild.get(childStageId).add(array);
                }
                        arrayPtrs[i] = arrays.get(i).memoryAddress();
                }
 * SPDX-License-Identifier: Apache-2.0
                }
        return failure;
                    a.close();
        if (!arraysByChild.containsKey(childStageId)) {
        }
 *
        if (schemas != null) {
import java.util.concurrent.atomic.AtomicBoolean;
        long need = batchBytes + FFI_EXPORT_OVERHEAD_BYTES;
/*
        // be reliably caught — once thrown it leaks the in-flight buffers and the cause is masked
    }
     * structures (the {@code ArrowArray} + {@code ArrowSchema} FFI structs and per-buffer
                "DatafusionMemtableReduceSink has " + childInputs.size() + " inputs; use sinkForChild(int) instead of feed()"
    private final long bufferBudget;
        // allocation site (here, the FFI export, the Flight receive, the native drain) and cannot
        // The coordinator-centric reduce buffers every input fully, so these retained buffers
    private final Map<Integer, List<ArrowSchema>> schemasByChild = new LinkedHashMap<>();
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(alloc);
                try {
     * Per-child buffering wrapper handed to the orchestrator via {@link #sinkForChild(int)}. Each
        // (the shared POOL_QUERY pool can be smaller than this child's nominal limit, so
        super(ctx, runtimeHandle);
        List<ArrowSchema> schemas = schemasByChild.get(childStageId);
 *
     * Drops the container references for ONE child whose FFI structs native just consumed via
                } catch (Exception ignore) {
        }
                    failure = accumulate(failure, t);
                    this.executionMetrics = NativeBridge.streamGetMetrics(outStream.getPointer());
                }
 * {@code StreamingTable} and drains the plan concurrently with producer feeds. For a
                for (Map.Entry<Integer, byte[]> child : childInputs.entrySet()) {
 * Buffered variant of {@link DatafusionReduceSink}: every fed batch is exported as an Arrow
     */
                } catch (Exception t) {
        }
                }
        List<ArrowArray> arrays = arraysByChild.get(childStageId);
                }
                failure = accumulate(failure, t);
     * Headroom margin reserved per buffered batch for the Arrow C-Data export's control
                listener.onFailure(new IllegalStateException("sink closed before reduce"));
                    List<ArrowSchema> schemas = schemasByChild.get(childStageId);
     */
                } catch (Exception t) {
            schemas.clear();
 */
                } catch (Exception t) {
        }
     * from the allocator itself ({@code getAllocatedMemory}); we only cache the limit here.
                    // only, no release) and remove them from the lists so the finally's
        BufferAllocator alloc = ctx.allocator();
     * double-fire the C release callback Rust now owns. Removes the child's lists so the reduce
        ArrowArray array = ArrowArray.allocateNew(alloc);
            arraysByChild.put(childStageId, new ArrayList<>());
    public boolean supportsEagerScheduling() {
    private static final long FFI_EXPORT_OVERHEAD_BYTES = 64 * 1024;
 * Java before execution removes every bounded native channel from the input path, so producers
package org.opensearch.be.datafusion;
     * duration so a concurrent {@link #close} (or late {@link #feed}) can't race the buffer-list
    /**
    public ExchangeSink sinkForChild(int childStageId) {
        // fit, with an actionable exception.
     * (best-effort; the reduce result is the meaningful signal).
    protected void feedBatchUnderLock(VectorSchemaRoot batch) {
                    bufferBatch(childStageId, batch);
