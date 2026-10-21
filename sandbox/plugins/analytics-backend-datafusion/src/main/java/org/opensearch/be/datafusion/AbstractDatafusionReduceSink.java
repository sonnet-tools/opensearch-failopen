     * Per-batch hook. Called under {@link #feedLock} after the closed-check. MUST NOT
    @Override
 * {@link #childSchemas} (lazily populated by subclasses from native registration replies).
     */
 * {@code finally}; {@link #close} flips {@link #closed} under the lock then delegates to
import org.apache.arrow.memory.BufferAllocator;
        Map<Integer, byte[]> inputs = new LinkedHashMap<>(ctx.childInputs().size());
            }
            // Imports go onto the caller-owned, node-scoped staging allocator — never a child minted here:
                    if (!fed) {
                    ctx.downstream().feed(batch);
    /** DataFusion table name for an input partition associated with the given child stage id. */
    protected final ExchangeSinkContext ctx;
     */
                    fed = true;
                }
        this.runtimeHandle = runtimeHandle;
            }
    }
        return "input-" + childStageId;
        }
    @Override
    /** Serialises {@link #feed}/{@link #close} against producers. */
            failure = accumulate(failure, t);
        for (ExchangeSinkContext.ChildInput child : ctx.childInputs()) {
import java.util.LinkedHashMap;
        acc.addSuppressed(t);
    private static void rethrow(Exception failure) {
 * the streaming subclass needs to manage.
                ctx.importStagingAllocator(),
import org.opensearch.analytics.spi.ReducingExchangeSink;
 *
    protected final DataFusionReduceState preparedState;
    }
import org.opensearch.analytics.spi.ExchangeSinkContext;
        }
            // downstream may hand the batch to the Flight transport, which keeps charging that allocator
        this.ctx = ctx;
                // close it ourselves on the failure path.
     * session + senders are owned by the state and {@link #close} skips re-closing them.
                return;
    /**
        synchronized (feedLock) {
                } finally {
        try {
    public byte[] getExecutionMetrics() {
import org.apache.arrow.c.CDataDictionaryProvider;
    /** Execution metrics + physical plan JSON, populated after reduce drains. */
                        batch.close();
    protected final void drainOutputIntoDownstream(StreamHandle outStream) {
            DatafusionResultStream.BatchIterator it = new DatafusionResultStream.BatchIterator(
import org.apache.arrow.vector.VectorSchemaRoot;
        long taskId = ctx.taskId();
        return executionMetrics;
        }
        return acc;
    /** Returns execution metrics JSON (including physical_plan) captured after reduce, or null. */
                // on success; if it throws (e.g. the downstream sink was torn down on a concurrent
                try {
        this.childInputs = inputs;
    /** Returns {@code t} if {@code acc} is null; otherwise adds {@code t} as a suppressed of {@code acc}. */
    public void close() {
    /** Set once under {@link #feedLock} in {@link #close}. */
     */
            failure = closeImpl();
 * including {@link #session} and any sender/stream handles. The base used to auto-close
        rethrow(failure);
    }
 * walker's.
 * this file be licensed under the Apache-2.0 license or a
        }
        this(ctx, runtimeHandle, null);
            }
    protected AbstractDatafusionReduceSink(
     * Fires the Rust CancellationToken for this query so that {@code stream_next}
     */
package org.opensearch.be.datafusion;
        DataFusionReduceState preparedState
        if (taskId != 0L) {
/**
    }
    protected final Object feedLock = new Object();
        }
    protected final Map<Integer, byte[]> childInputs;
                feedBatchUnderLock(batch);
        this.preparedState = preparedState;
        try (CDataDictionaryProvider dictProvider = new CDataDictionaryProvider()) {
 */
 *
    protected AbstractDatafusionReduceSink(ExchangeSinkContext ctx, NativeRuntimeHandle runtimeHandle) {
        this.childSchemas = new LinkedHashMap<>(ctx.childInputs().size());
 * Use {@link #inputIdFor(int)} for the per-child table id; {@link #INPUT_ID} is the
 * {@link #closeImpl}. Subclasses own the full teardown sequence in {@link #closeImpl} —
    @Override
 * {@code session} after {@code closeImpl} returned, but that double-closed (every concrete
    /**
        if (acc == null) {
                return;
        Exception failure = null;
                // next() transfers ownership of the imported VSR to us. feed() takes ownership only
        this.session = preparedState != null ? preparedState.session() : new DatafusionLocalSession(runtimeHandle.get());
        }
            );
        throw new RuntimeException(failure);
    }
 *
     * feeds it downstream. Caller retains ownership of {@code outStream}.
 * @opensearch.internal
        }
        }
                boolean fed = false;
            closed = true;
            try (batch) {
                // cancel), the imported batch would otherwise leak in the per-query allocator —
            // long after this drain returns.
 * Shared lifecycle skeleton for coordinator-side {@link ReducingExchangeSink}s backed by a
 * subclass already closed it) and tangled session ownership with the close-state machine
 * and native cleanup via {@link #feedBatchUnderLock}, {@link #reduce}, {@link #closeImpl}.
                batch.close();
        }
     */
                dictProvider
 * <p>Invariants: {@link #feed} runs under {@link #feedLock} and always closes the batch in
import org.opensearch.be.datafusion.nativelib.StreamHandle;
        BufferAllocator alloc = ctx.allocator();
            if (closed) {
import org.opensearch.be.datafusion.nativelib.NativeBridge;
    protected abstract Exception closeImpl();
    protected final Map<Integer, Schema> childSchemas;
            throw re;
     * returns the sentinel {@code 0} immediately and the drain unblocks without
}
            }
        synchronized (feedLock) {
     * close {@code batch} — the base does it in {@code finally}.
    }
                    }
        ExchangeSinkContext ctx,
     * Non-null when constructed from a pre-prepared plan (FinalAggregateInstructionHandler):
    ) {
    protected volatile byte[] executionMetrics;
    protected volatile boolean closed;
import org.opensearch.analytics.spi.CancellableExchangeSink;
     * (no context registered) or when already closed.
    protected static String inputIdFor(int childStageId) {
     * Subclass shutdown. Despite the historical name, this is NOT called under {@link #feedLock} —
    /**
 *
abstract class AbstractDatafusionReduceSink implements ReducingExchangeSink, CancellableExchangeSink {
                outStream,
            if (closed) {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
     * Imports each batch from {@code outStream} into a fresh {@link VectorSchemaRoot} and
import org.apache.arrow.vector.types.pojo.Schema;
 * The {@link ExchangeSinkContext#downstream()} sink is NOT closed here — its lifecycle is the
                VectorSchemaRoot batch = it.next().getArrowRoot();
    public final void cancel() {
 * <p>Multi-input is exposed via {@link #childInputs} (childStageId → producer plan bytes) and
import java.util.Map;
            inputs.put(child.childStageId(), child.producerPlanBytes());
    protected final DatafusionLocalSession session;
    }
     * owned externally). Return the first failure, or null.
    /** Per-child declared schema, populated lazily from native registration replies. */
/*
            return;
            return t;
                alloc,
    /** Per-child producer plan bytes (childStageId → bytes), iteration order = ctx.childInputs(). */
     * including {@link #session} (gate on {@link #preparedState} == null when the session is
    }
            while (it.hasNext()) {
        } catch (Exception t) {
 * native DataFusion local session. Subclasses customise per-batch handling, the reduce verb,
    public void feed(VectorSchemaRoot batch) {
    }
    static final String INPUT_ID = "input-0";
        if (failure instanceof RuntimeException re) {
    }
    protected static Exception accumulate(Exception acc, Exception t) {
     * the lock is released after {@link #closed} is flipped. Subclasses own the full teardown
        if (failure == null) {
    /**
    protected abstract void feedBatchUnderLock(VectorSchemaRoot batch);
    /**
 * compatible open source license.
 * single-input shortcut.
    /** Single-input shortcut for the per-child table id; multi-input uses {@link #inputIdFor(int)}. */
     * waiting for DataFusion to finish naturally. No-op when {@code taskId} is 0
    protected final NativeRuntimeHandle runtimeHandle;
 */
            NativeBridge.cancelQuery(taskId);
        NativeRuntimeHandle runtimeHandle,
