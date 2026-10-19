import org.apache.arrow.memory.BufferAllocator;
        synchronized (feedLock) {
            NativeBridge.cancelQuery(taskId);
import org.opensearch.analytics.spi.CancellableExchangeSink;
                // cancel), the imported batch would otherwise leak in the per-query allocator —
            }
        }  
        return "input-" + childStageId;
                        batch.close();
    /** Per-child producer plan bytes (childStageId → bytes), iteration order = ctx.childInputs(). */
     * returns the sentinel {@code 0} immediately and the drain unblocks without  
    public void close() {
 */
     * Per-batch hook. Called under {@link #feedLock} after the closed-check. MUST NOT
 * <p>Invariants: {@link #feed} runs under {@link #feedLock} and always closes the batch in
            );
        this.runtimeHandle = runtimeHandle;  
    }  
    ) {
                // close it ourselves on the failure path.  
        BufferAllocator alloc = ctx.allocator();  
 * SPDX-License-Identifier: Apache-2.0
     * session + senders are owned by the state and {@link #close} skips re-closing them.
     * the lock is released after {@link #closed} is flipped. Subclasses own the full teardown
        synchronized (feedLock) {  
 */  
 * subclass already closed it) and tangled session ownership with the close-state machine  
            if (closed) {
            return t;  
 * walker's.  
abstract class AbstractDatafusionReduceSink implements ReducingExchangeSink, CancellableExchangeSink {  
                }
        try {
        }
    }
import org.apache.arrow.vector.VectorSchemaRoot;  
            throw re;
    /** Serialises {@link #feed}/{@link #close} against producers. */
    protected final Map<Integer, byte[]> childInputs;  
    protected final DatafusionLocalSession session;
    }
    public final void cancel() {
            inputs.put(child.childStageId(), child.producerPlanBytes());
        return acc;  
                    ctx.downstream().feed(batch);
            try (batch) {
        if (failure == null) {
                } finally {  
            return;
    public byte[] getExecutionMetrics() {
     * close {@code batch} — the base does it in {@code finally}.
     */
 * Use {@link #inputIdFor(int)} for the per-child table id; {@link #INPUT_ID} is the
 * @opensearch.internal
                // on success; if it throws (e.g. the downstream sink was torn down on a concurrent
import org.opensearch.be.datafusion.nativelib.StreamHandle;  
    protected final Map<Integer, Schema> childSchemas;  
     * Imports each batch from {@code outStream} into a fresh {@link VectorSchemaRoot} and
            }  
    }
        throw new RuntimeException(failure);
                return;
import org.apache.arrow.vector.types.pojo.Schema;
    protected AbstractDatafusionReduceSink(  
/*  
import java.util.Map;  
        Map<Integer, byte[]> inputs = new LinkedHashMap<>(ctx.childInputs().size());  
                ctx.importStagingAllocator(),
    /** Execution metrics + physical plan JSON, populated after reduce drains. */
    @Override
    protected static Exception accumulate(Exception acc, Exception t) {
package org.opensearch.be.datafusion;
 * The OpenSearch Contributors require contributions made to  
        }  
     */  
                outStream,  
    private static void rethrow(Exception failure) {  
            }  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
     * waiting for DataFusion to finish naturally. No-op when {@code taskId} is 0
                boolean fed = false;
     * feeds it downstream. Caller retains ownership of {@code outStream}.  
 * {@code session} after {@code closeImpl} returned, but that double-closed (every concrete
                    }  
        this.ctx = ctx;
                alloc,
        try (CDataDictionaryProvider dictProvider = new CDataDictionaryProvider()) {
        if (failure instanceof RuntimeException re) {
    protected final Object feedLock = new Object();  
        }  
     * Non-null when constructed from a pre-prepared plan (FinalAggregateInstructionHandler):  
        long taskId = ctx.taskId();  
import java.util.LinkedHashMap;
        }
        this.preparedState = preparedState;
    }
                feedBatchUnderLock(batch);
    /** Per-child declared schema, populated lazily from native registration replies. */
    /**
    }
                try {  
    /**
    /** Returns execution metrics JSON (including physical_plan) captured after reduce, or null. */  
    protected static String inputIdFor(int childStageId) {  
            failure = closeImpl();
 *
        }  
            }  
                batch.close();
    protected AbstractDatafusionReduceSink(ExchangeSinkContext ctx, NativeRuntimeHandle runtimeHandle) {
    }  
            // Imports go onto the caller-owned, node-scoped staging allocator — never a child minted here:
     * (no context registered) or when already closed.
    /** Set once under {@link #feedLock} in {@link #close}. */
        }  
        if (acc == null) {
    static final String INPUT_ID = "input-0";  
                    if (!fed) {
 * including {@link #session} and any sender/stream handles. The base used to auto-close
     * Fires the Rust CancellationToken for this query so that {@code stream_next}
            DatafusionResultStream.BatchIterator it = new DatafusionResultStream.BatchIterator(
     * Subclass shutdown. Despite the historical name, this is NOT called under {@link #feedLock} —  
 * native DataFusion local session. Subclasses customise per-batch handling, the reduce verb,
 * and native cleanup via {@link #feedBatchUnderLock}, {@link #reduce}, {@link #closeImpl}.
            // downstream may hand the batch to the Flight transport, which keeps charging that allocator  
    protected final ExchangeSinkContext ctx;
        rethrow(failure);  
    protected abstract Exception closeImpl();
                dictProvider  
        for (ExchangeSinkContext.ChildInput child : ctx.childInputs()) {
/**
        this.childSchemas = new LinkedHashMap<>(ctx.childInputs().size());
import org.opensearch.analytics.spi.ExchangeSinkContext;  
        Exception failure = null;  
    }
     */  
    @Override  
    protected abstract void feedBatchUnderLock(VectorSchemaRoot batch);
    @Override
 * Shared lifecycle skeleton for coordinator-side {@link ReducingExchangeSink}s backed by a  
        }
        }
            closed = true;
 * single-input shortcut.
     */
                // next() transfers ownership of the imported VSR to us. feed() takes ownership only  
     * including {@link #session} (gate on {@link #preparedState} == null when the session is
        } catch (Exception t) {  
        this(ctx, runtimeHandle, null);  
     * owned externally). Return the first failure, or null.  
    public void feed(VectorSchemaRoot batch) {
                VectorSchemaRoot batch = it.next().getArrowRoot();
 * The {@link ExchangeSinkContext#downstream()} sink is NOT closed here — its lifecycle is the
    protected volatile byte[] executionMetrics;  
     */
    /**  
 *
                return;
            if (closed) {  
        this.session = preparedState != null ? preparedState.session() : new DatafusionLocalSession(runtimeHandle.get());
 * this file be licensed under the Apache-2.0 license or a
    }
    /** DataFusion table name for an input partition associated with the given child stage id. */
            while (it.hasNext()) {
    /**
    /**
    /** Returns {@code t} if {@code acc} is null; otherwise adds {@code t} as a suppressed of {@code acc}. */  
    }
 *  
import org.opensearch.analytics.spi.ReducingExchangeSink;
 * {@code finally}; {@link #close} flips {@link #closed} under the lock then delegates to
            // long after this drain returns.
 * compatible open source license.
        ExchangeSinkContext ctx,
}  
        DataFusionReduceState preparedState  
        NativeRuntimeHandle runtimeHandle,
import org.apache.arrow.c.CDataDictionaryProvider;
    protected volatile boolean closed;  
        return executionMetrics;
    protected final void drainOutputIntoDownstream(StreamHandle outStream) {
 * {@link #childSchemas} (lazily populated by subclasses from native registration replies).  
 *  
        if (taskId != 0L) {
 * {@link #closeImpl}. Subclasses own the full teardown sequence in {@link #closeImpl} —  
 * <p>Multi-input is exposed via {@link #childInputs} (childStageId → producer plan bytes) and
 * the streaming subclass needs to manage.
                    fed = true;
            failure = accumulate(failure, t);
        this.childInputs = inputs;
    /** Single-input shortcut for the per-child table id; multi-input uses {@link #inputIdFor(int)}. */
        acc.addSuppressed(t);
    protected final NativeRuntimeHandle runtimeHandle;  
    protected final DataFusionReduceState preparedState;  
