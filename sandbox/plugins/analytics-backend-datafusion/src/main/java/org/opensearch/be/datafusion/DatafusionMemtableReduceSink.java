import org.opensearch.analytics.spi.ExchangeSink;  
     */
            synchronized (feedLock) {
            arrays.clear();
                failure = accumulate(failure, t);
                } catch (Exception ignore) {  
        // be reliably caught — once thrown it leaks the in-flight buffers and the cause is masked
    /** Single-fire guard so a stray second {@link #reduce} call doesn't re-execute the plan. */
    }
 * <p><b>Why buffered, especially for multi-input.</b> The streaming sink
        // as a TaskCancelledException. So we refuse the batch up front when retaining it would not
     */
        }
                    a.close();  
                    long[] schemaPtrs = new long[schemas.size()];  
    private static final long FFI_EXPORT_OVERHEAD_BYTES = 64 * 1024;
     * {@link #sinkForChild(int)} instead.
        } finally {
     * duration so a concurrent {@link #close} (or late {@link #feed}) can't race the buffer-list
 * always run to completion + EOF, and the plan executes over complete in-memory inputs.
                        inputIdFor(childStageId),
 * inputs) that concurrency can deadlock: a {@code HashJoinExec} collects its build side fully
 * <p><b>Multi-input.</b> {@link #sinkForChild(int)} returns a per-child buffering wrapper; each  
    /** Per-child buffered Arrow C-data pairs, keyed by child-stage id (iteration order = childInputs). */
 * child stage's output accumulates into its own batch list keyed by child-stage id and registers
 * this file be licensed under the Apache-2.0 license or a
            }
import java.util.List;  
                } catch (Exception ignore) {
            throw new IllegalArgumentException(
                try {
 * Buffered variant of {@link DatafusionReduceSink}: every fed batch is exported as an Arrow
                return;  
import org.apache.arrow.memory.BufferAllocator;
    protected Exception closeImpl() {
    }  
            if (array != null) {
     * {@link ReduceSizeExceededException} on a sibling input, or an external cancel), the exported
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(alloc);  
 * {@code registerMemtable} call per child input, then {@code executeLocalPlan + drain}. No
                } catch (Exception t) {  
                streamPtr = NativeBridge.executeLocalPlan(session.getPointer(), ctx.fragmentBytes(), ctx.taskId());
            if (arrowSchema != null) {
    /**
        }
        }
    @Override
        ArrowArray array = ArrowArray.allocateNew(alloc);
                throw new ReduceSizeExceededException(projected, bufferBudget);  
        public void close() {
                } catch (Exception t) {
    /**
                    // register_memtable MOVED these FFI structs into native (FFI_ArrowArray::from_raw);  
        super(ctx, runtimeHandle);  
    @Override
                    // they no longer hold Java-side buffers. Drop the container references now (close
                failure = accumulate(failure, t);
    private final Map<Integer, List<ArrowSchema>> schemasByChild = new LinkedHashMap<>();
                }  
                    return;
            } catch (Exception t) {
                    long[] arrayPtrs = new long[arrays.size()];
            listener.onFailure(failure);  
        @Override  
        public void feed(VectorSchemaRoot batch) {
    /** Sums per-vector buffer sizes; the off-heap cost of retaining this batch's data. */
        Exception failure = releaseUnconsumedBuffers(null);  
 * {@link AbstractDatafusionReduceSink#INPUT_ID}).
            schemasByChild.put(childStageId, new ArrayList<>());
            schemas.clear();
    @Override  
            for (ArrowSchema s : schemas) {  
    public DatafusionMemtableReduceSink(ExchangeSinkContext ctx, NativeRuntimeHandle runtimeHandle) {
    private static long bufferSize(VectorSchemaRoot batch) {
                }  
        for (List<ArrowSchema> schemas : schemasByChild.values()) {  
        // Ancestor-aware check: even within the per-query budget, the shared pool may be exhausted.  
            try {
            } catch (Exception t) {
                    this.executionMetrics = NativeBridge.streamGetMetrics(outStream.getPointer());
import org.apache.arrow.c.ArrowSchema;
import org.opensearch.be.datafusion.nativelib.StreamHandle;
    private final Map<Integer, List<ArrowArray>> arraysByChild = new LinkedHashMap<>();  
    protected void feedBatchUnderLock(VectorSchemaRoot batch) {
                try (StreamHandle outStream = new StreamHandle(streamPtr, runtimeHandle)) {
import org.apache.arrow.c.ArrowArray;
     * Drops the container references for ONE child whose FFI structs native just consumed via  
     */
        if (arrays != null) {  
     * {@code finally}'s release-then-close path never touches consumed inputs. Swallows close errors
import org.apache.arrow.vector.VectorSchemaRoot;
            throw new IllegalStateException("DatafusionMemtableReduceSink requires at least one child input");
                    // only, no release) and remove them from the lists so the finally's
                }  
        if (childInputs.size() != 1) {
                    failure = accumulate(failure, t);
        }
     * Arrow C-data structs were never imported by native and still hold live buffers: they must be  
            }  
import java.util.concurrent.atomic.AtomicBoolean;
                        schemaPtrs
        return failure;  
        return false;
        List<ArrowArray> arrays = arraysByChild.get(childStageId);
        }  
            }
/**
    /** Exports {@code batch} as an Arrow C-data pair into the given child's buffer. */
        BufferAllocator alloc = ctx.allocator();
            }
    private final long bufferBudget;  
            try {
        if (preparedState == null) {
                try {
        try {
            arrowSchema = null;  
 * <em>multi-input</em> coordinator operator (e.g. a {@code Join} over two SINGLETON-reduced
import org.apache.arrow.c.Data;  
     * Frees buffers that native never imported (cancel-before-reduce, or a child that threw before  
    }  
                    s.release();  
                    }
 * The OpenSearch Contributors require contributions made to  
                    failure = accumulate(failure, t);
            if (closed) {
     * Single-input feed: buffers into the sole child's batch list. Multi-input callers route via  
                    failure = accumulate(failure, t);
    }  
     * double-fire the C release callback Rust now owns. Removes the child's lists so the reduce  
    /**
     * {@code ExportedArrayPrivateData}). Keeps the clean {@link ReduceSizeExceededException}
                session.close();  
        // The coordinator-centric reduce buffers every input fully, so these retained buffers
        return failure;
     * Per-child buffering wrapper handed to the orchestrator via {@link #sinkForChild(int)}. Each
 * <p>Trade-off: all input batches live in memory until {@link #reduce}. For very large streaming  
    /**  
            }
                    childSchemas.put(childStageId, ArrowSchemaIpc.fromBytes(registered.schemaIpc()));
            total += v.getBufferSize();
        }  
import org.opensearch.analytics.spi.ExchangeSinkContext;
     * iteration. Releases the Arrow Java wrappers in {@code finally}.  
    @Override
                    int childStageId = child.getKey();
            // Per-child EOF carries no native signal in the buffered path — the parent's reduce()  
                        session.getPointer(),  
     * ran, it already cleared the per-child lists in its {@code finally}, so this finds them empty.  
    }
        ChildSink(int childStageId) {
        // getLimit() alone overstates what's actually grantable — getHeadroom() does not).
    }  
        } else {
        long need = batchBytes + FFI_EXPORT_OVERHEAD_BYTES;
                    // container free only; data buffers are owned by native now
        }
    private final AtomicBoolean reduceStarted = new AtomicBoolean(false);  
                }
     * from the allocator itself ({@code getAllocatedMemory}); we only cache the limit here.
            }  
            }  
 * Java before execution removes every bounded native channel from the input path, so producers  
                    NativeBridge.RegisteredInput registered = NativeBridge.registerMemtable(
     * Headroom margin reserved per buffered batch for the Arrow C-Data export's control  
    private final class ChildSink implements ExchangeSink {
            long projected = alloc.getAllocatedMemory() + need;  
                try {
            for (ArrowSchema s : schemas) {
        }
        if (need > alloc.getHeadroom()) {
        return new ChildSink(childStageId);
     */  
    private void releaseConsumedChild(int childStageId) {
    public void reduce(ActionListener<Void> listener) {  
            listener.onResponse(null);
            }  
package org.opensearch.be.datafusion;
     * Registers each child's buffered batches as a distinct {@code "input-<childStageId>"}  
        }
                arrowSchema.close();  
 * tokio mpsc in the input path.
    }  
        for (Integer childStageId : childInputs.keySet()) {  
                }  
                } catch (Exception t) {  
                        arrayPtrs[i] = arrays.get(i).memoryAddress();
public final class DatafusionMemtableReduceSink extends AbstractDatafusionReduceSink implements MultiInputExchangeSink {  
            schemas.clear();
     * When the sink is closed BEFORE {@code reduce()} (cancel path — e.g. a size-guard
     *  channel in the input path means non-eager is also deadlock-free for multi-input). */
        if (!arraysByChild.containsKey(childStageId)) {  
        for (org.apache.arrow.vector.FieldVector v : batch.getFieldVectors()) {
                // Original IllegalStateException carries the actionable message; suppress cleanup errors.
import org.opensearch.analytics.spi.MultiInputExchangeSink;
import org.opensearch.core.action.ActionListener;
            try {  
                    // without double-releasing A.
    public ExchangeSink sinkForChild(int childStageId) {
                    releaseConsumedChild(childStageId);  
                    s.close();
                    a.release();  
            long streamPtr = 0;
        }
        for (List<ArrowArray> arrays : arraysByChild.values()) {  
    /**
        // (1) the per-query budget (this allocator's own limit, analytics.coordinator.buffer_limit)  
        // Fail fast BEFORE allocating, so the per-query Arrow allocator never hits a hard limit.  
            for (ArrowArray a : arrays) {
import java.util.ArrayList;
        private final int childStageId;  
                if (streamPtr != 0) {
     * size guard is then inert and the path behaves exactly as before. The live usage is read  
 */  
        // exportVectorSchemaRoot shares the batch buffers by reference plus allocates per-buffer
     * {@link #closeImpl} and {@link #reduce}'s {@code finally}.  
        // allocation site (here, the FFI export, the Flight receive, the native drain) and cannot  
 *
        // — projected against live usage (getAllocatedMemory), and
        }
     */
    /** Memtable buffers all input first — never schedule concurrently with feeds (no bounded
            }
            schemasByChild.get(childStageId).add(arrowSchema);
        // The binding limit is the SMALLER of two ceilings, so we check both:
                    List<ArrowArray> arrays = arraysByChild.get(childStageId);  
                try {
            } finally {  
            }
            }  
 * C Data pair and held until {@link #reduce} hands the full set(s) to native via one  
                }
        @Override
     * (best-effort; the reduce result is the meaningful signal).
            throw new IllegalStateException(  
import java.util.Map;
        assert reduceStarted.compareAndSet(false, true) : "reduce called more than once";
     */
                }
 * on a bounded input mpsc the join is not yet draining, the producer blocks, never signals EOF,
        // private data; we add an FFI margin so the clean failure trips before the raw OOM. Inert  
        return total;
            );  
     * {@code release()}d (fire the C release callback to free the buffers) THEN {@code close()}d
                    );
 * as a distinct {@code "input-<childStageId>"} {@code MemTable} at {@link #reduce} time. The
        //
        long batchBytes = bufferSize(batch);  
                if (closed) {  
    public boolean supportsEagerScheduling() {
                    NativeBridge.streamClose(streamPtr);
                    a.close();
                    // release-then-close path only ever touches inputs native did NOT consume — a  
                        child.getValue(),
                }  
        if (bufferBudget != Long.MAX_VALUE) {
        }
        }
 *
        }
 *  
     * means the operator disabled the per-query limit (shared coordinator allocator) — the
     * parent sink's {@link #reduce}/{@link #close} own the buffer lifecycle).  
                // import, or all children if executeLocalPlan failed pre-registration) — release+close.
            array = null;
     * Per-query off-heap budget for the buffered inputs: the limit of the query's Arrow  
                    drainOutputIntoDownstream(outStream);
                }
        // (2) the allocator's getHeadroom(), which Arrow computes across the ANCESTOR chain
                    List<ArrowSchema> schemas = schemasByChild.get(childStageId);
 *
        // (the shared POOL_QUERY pool can be smaller than this child's nominal limit, so  
 * and the join's build never completes (observed on TPC-H q15). Buffering each input fully in
                }  
     * MemTable, executes the plan, drains into the downstream. Holds {@link #feedLock} for the
}
        List<ArrowSchema> schemas = schemasByChild.get(childStageId);
                    s.close();
                "No registered input for childStageId=" + childStageId + "; known ids=" + arraysByChild.keySet()
        // when the budget is unbounded (Long.MAX_VALUE — operator disabled the per-query limit).
    }
 * SPDX-License-Identifier: Apache-2.0
 */
                try {
                // Anything left in the lists was NOT consumed by native (a child that threw before
                }  
        // fit, with an actionable exception.  
            throw new ReduceSizeExceededException(alloc.getAllocatedMemory() + need, alloc.getAllocatedMemory() + alloc.getHeadroom());  
        }
    }  
                "DatafusionMemtableReduceSink has " + childInputs.size() + " inputs; use sinkForChild(int) instead of feed()"
    }
     * fed batch is exported + appended to its child's buffer; {@code close()} is a no-op (the
     * tripping before the raw allocator-limit OOM.  
        }  
                    failure = accumulate(failure, t);
     * structures (the {@code ArrowArray} + {@code ArrowSchema} FFI structs and per-buffer
    /**
        if (childInputs.isEmpty()) {
        synchronized (feedLock) {  
                listener.onFailure(new IllegalStateException("sink closed before reduce"));
import java.util.LinkedHashMap;
                // batch is closed by the caller's try-with-resources; do not allocate.
        bufferBatch(childInputs.keySet().iterator().next(), batch);
            arraysByChild.put(childStageId, new ArrayList<>());
                    // partial failure (child A imported, child B throws) then frees B correctly
            this.childStageId = childStageId;  
                } catch (Exception t) {
        if (schemas != null) {
     */  
        long total = 0L;  
    private Exception releaseUnconsumedBuffers(Exception failure) {
                for (Map.Entry<Integer, byte[]> child : childInputs.entrySet()) {
                try {
        if (failure == null) {  
                    bufferBatch(childStageId, batch);
                array.close();  
 * ({@link DatafusionReduceSink}) registers each input as a bounded-mpsc-backed
     */
 * single-input case keeps the bare {@link #feed(VectorSchemaRoot)} path (one input under  
            for (ArrowArray a : arrays) {
     * (free the 128-byte FFI container). {@code close()} alone leaks the buffers.
            // registers each child's accumulated buffer as a complete MemTable. No-op.
    }
 * {@code StreamingTable} and drains the plan concurrently with producer feeds. For a  
                        schemaPtrs[i] = schemas.get(i).memoryAddress();  
            Data.exportVectorSchemaRoot(alloc, batch, null, array, arrowSchema);
                    streamPtr = 0;  
     * {@code close()} frees the FFI container. {@code close()} alone leaks the buffers. Used by
            }
            );
 * compatible open source license.
        // dominate the allocator's usage. A raw Arrow OutOfMemoryException can fire at ANY
     * {@code register_memtable} ({@code FFI_ArrowArray::from_raw} moved them out of Java). Java
        Exception failure = null;
        }  
     * only frees the 128-byte container with {@code close()} — calling {@code release()} here would
            arrays.clear();
 * before reading the probe, so if the build-side producer's cross-node delivery back-pressures  
                session.close();  
        // getHeadroom() returns the effective grantable bytes up the allocator tree.
                    // container free only
    /**
            } catch (Throwable ignore) {
     * its import): {@code release()} fires the C release callback to free the data buffers, then
     * allocator (set by {@code analytics.coordinator.buffer_limit}). {@link Long#MAX_VALUE}
        }
                        arrayPtrs,  
            arraysByChild.get(childStageId).add(array);  
            if (projected > bufferBudget) {
    @Override  
     * Releases any buffers {@link #reduce} didn't consume, then the session. When {@code reduce()}
    private void bufferBatch(int childStageId, VectorSchemaRoot batch) {
                    batch.close();
/*  
        this.bufferBudget = ctx.allocator().getLimit();
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
 * reductions prefer {@link DatafusionReduceSink} via {@code datafusion.reduce.input_mode=streaming}.
    /**
                failure = releaseUnconsumedBuffers(failure);  
                    for (int i = 0; i < arrays.size(); i++) {
                try (batch) {
