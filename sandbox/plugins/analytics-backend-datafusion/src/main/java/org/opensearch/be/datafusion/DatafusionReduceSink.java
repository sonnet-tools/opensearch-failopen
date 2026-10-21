    /**
        if (before == SinkState.DONE) {
        }
     * (e.g. an outer join on the null-fill side returns plain Utf8 while a non-null side
                        "[reduce-sink] ALLOC sender taskId={} childStageId={} senderPtr={}",
                if (rc == NativeBridge.SENDER_SEND_RECEIVER_DROPPED) {
        } else {
     * {@link ChildSink#feed} for the multi-input path. Required by the abstract
        } catch (Exception e) {
                array.release();
    @Override
                        sender.close();
        }
     * dropped join side ≠ whole reduce done), so this conservatively returns false unless there is
                if (!reduceDone.await(5, java.util.concurrent.TimeUnit.SECONDS)) {
                if (streamPtr != 0) {
     * then sends it through the supplied sender. The Rust mpsc::Sender is thread-safe,
        DONE
                failure = accumulate(failure, t);
                        inputIdFor(childStageId),
                continue;
            if (childClosed) {
 */
        }
                return;
            // NativeHandle.getPointer() if the sender was closed (the close-race path).
     * ({@link ChildSink#isConsumerDone()}) — a single top-level answer can't be correct there (one
     * Lock-free feed for the single-input case: writes to the sole registered sender.
     * class contract.
                try {
    public DatafusionReduceSink(ExchangeSinkContext ctx, NativeRuntimeHandle runtimeHandle, DataFusionReduceState preparedState) {
                }
import org.opensearch.analytics.spi.MultiInputExchangeSink;
            outStreamLocal = new StreamHandle(streamPtr, runtimeHandle);
                streamPtr = NativeBridge.executeLocalPlan(session.getPointer(), ctx.fragmentBytes(), ctx.taskId());
        }
        Map<Integer, DatafusionPartitionSender> senders = new LinkedHashMap<>(childInputs.size());
     * returns Utf8View). The two layouts are NOT byte-identical, so the Rust sender_send
     *       (NOT {@code super.close()}, because the base's {@code closed} flag was set by
     * its specific input partition. Idempotent — duplicate close() calls are no-ops.
/*
    /**
                // below frees the wrapper but does NOT invoke the C release callback.)
            );
                        childStageId,
            failure = accumulate(failure, t);
        }
                continue;
     * routes one of these per child stage, and the wrapper's close() signals EOF for
            logger.debug("[reduce-sink] reduce failed: taskId={} error={}", ctx.taskId(), failure.getMessage());
                    }
                        session.getPointer(),
    protected void feedBatchUnderLock(VectorSchemaRoot batch) {
                    // cancelled by the shard listener via isConsumerDone().
                if (preparedState == null) {
    public void reduce(ActionListener<Void> listener) {
        }
            return sender.isReceiverDropped();
import org.apache.arrow.c.ArrowArray;
                    failure = accumulate(failure, closeFailure);
        super(ctx, runtimeHandle, preparedState);
                    + "declared="
                    // receiver while shards were still feeding. api::sender_send already consumed the
            }
     * the routing target is ambiguous.
                    childSchemas.put(child.getKey(), preparedState.inputSchemas().get(i));
     *   <li>DONE: this IS the {@code reduce()} finally call (or an idempotent second close).
            );
            drainOutputIntoDownstream(outStream);
            }
                // Sender close raced our send — thrown BEFORE the native call, so Rust
            return null;
        long streamPtr = 0;
     * method when more than one partition is registered is a programming error because
     */
    }
                sender.close();
    protected Exception closeImpl() {
                    sender.requestEarlyTermination();
                if (closeFailure != null) {
        SinkState before = state.compareAndExchange(SinkState.READY, SinkState.DONE);
        }
 * bare {@link #feed(VectorSchemaRoot)} is reserved for single-input. Feeds are concurrent
import java.util.LinkedHashMap;
                // never took ownership and the FFI structs' release callbacks are still
        }
    public boolean isConsumerDone() {
     * StreamingTable (see {@code conform_batch_to_schema} in api.rs) — this check only
            failure = accumulate(failure, t);
 * {@code feed()} when there's one child. Current behaviour is correct but the typing lies.
    private final StreamHandle outStream;
        public void feed(VectorSchemaRoot batch) {
                feedCount.incrementAndGet();
                batch.close();
                logger.debug("[reduce-sink] ALLOC localPlan stream taskId={} streamPtr={}", ctx.taskId(), streamPtr);
            // Close outStream first: drops the native receiver, which unblocks any sender
        try {
     * code, while a concurrent {@link #close()} surfaces as an IllegalStateException from
     * <ul>
                }
     * and abort the JVM. Transitions: READY → REDUCING (reduce entered) → DONE (drain
            return null;
        private final DatafusionPartitionSender sender;
        // Drain is not started here — it runs inline on the owning reduce stage's
                    for (DatafusionPartitionSender sender : senders.values()) {
 * pushes each fed batch through a tokio mpsc-backed sender, and drains the native output
    }
            this.executionMetrics = NativeBridge.streamGetMetrics(outStream.getPointer());
            }
                    int childStageId = child.getKey();
            if (preparedState != null) {
            if (!success) {
                    }
            this.sender = sender;
        logger.debug("[reduce-sink] fireCancelQuery: taskId={}", ctx.taskId());
 * The OpenSearch Contributors require contributions made to
     */
                Data.exportVectorSchemaRoot(alloc, batch, null, array, arrowSchema);
            }
import org.apache.logging.log4j.LogManager;
        }
    /**
 * even when only one child stage feeds it. The marker is meant for genuine multi-input shapes
                    session.close();
        try {
        // already dropped its receiver (nothing downstream will read another batch on it).
            throw new IllegalStateException(
    private static final Logger logger = LogManager.getLogger(DatafusionReduceSink.class);
            return false;
     */
            return;
        public boolean isConsumerDone() {
     */
                    );
     *   <li>READY: external close (no drain in flight). Tear down inline.</li>
                arrowSchema.release();
                // set. Invoke them explicitly to free the exported buffers back to the
        return true;
            }
                int i = 0;
    }
import org.opensearch.core.action.ActionListener;
            }
                }
        return sendersByChildStageId.size() == 1 && sendersByChildStageId.values().iterator().next().isReceiverDropped();
            ArrowType dt = d.get(i).getType();
    void fireCancelQuery() {
    }
import java.util.concurrent.atomic.AtomicBoolean;
                }
            // close — see DatafusionPartitionSender. Throws IllegalStateException via
            return;
                long rc = sender.send(array.memoryAddress(), arrowSchema.memoryAddress());
            }
                    byte[] producerPlanBytes = child.getValue();
            } catch (InterruptedException e) {
     * Per-child senders keyed by childStageId, populated in declaration order so the
import org.apache.arrow.c.ArrowSchema;
            // drain finish naturally with all accepted rows; cancelling here aborted the
            }
        }
            ctx.taskId(),
     */
    }
import java.util.concurrent.atomic.AtomicReference;
        NativeBridge.cancelQuery(ctx.taskId());
    /**
    public void feed(VectorSchemaRoot batch) {
                        ctx.taskId(),
     * single-input case can pick the sole entry without an explicit lookup.
            // Extract DataFusion execution metrics + physical plan after drain (before close)
                    // another reason). Fall back to a hard cancel so close() cannot
 */
            if (at.getTypeID() == ArrowType.ArrowTypeID.Timestamp && dt.getTypeID() == ArrowType.ArrowTypeID.Timestamp) {
            // sender.send acquires its read lock so the native borrow outlives concurrent
            }
import org.apache.arrow.vector.VectorSchemaRoot;
 * compatible open source license.
                    NativeBridge.streamClose(streamPtr);
        try {
        }
     * LimitExec satisfied its fetch). Multi-input shapes (join/union) feed via {@link #sinkForChild}
 * Streaming coordinator-side reduce sink: opens one native partition stream per child input,
        return new ChildSink(sender, childSchemas.get(childStageId));
            feedToSender(sender, batch, declaredSchema);
/**
            );
    /** Signalled when reduce's finally completes teardown. closeImpl awaits this
            try {
            childClosed = true;
    }
 * subclass and a multi-input subclass, or drop the marker and let the caller always go through
            try {
        private final Schema declaredSchema;
            throw new IllegalArgumentException(
                // owns them, the state's close() will.
     *
                } catch (Exception e) {
            } catch (Exception t) {
            session != null ? session.getPointer() : 0
        if (a.size() != d.size()) {
}
            success = true;
    public DatafusionReduceSink(ExchangeSinkContext ctx, NativeRuntimeHandle runtimeHandle) {
     * Lock-free per-sender feed. Exports the batch via Arrow C Data outside any lock
        List<Field> a = actual.getFields();
        ArrowType.ArrowTypeID id = type.getTypeID();
            batch.close();
        try {
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                    logger.debug(
import org.apache.arrow.vector.types.pojo.ArrowType;
                }
        }
     * Multi-input callers must use {@link #sinkForChild(int)} instead — calling this
     *       Do the teardown; {@link #torndown} gates against double-running it.</li>
            failure = e;
            }
                }
package org.opensearch.be.datafusion;
            try {
     */
            // release explicitly above.
        if (before == SinkState.REDUCING) {
        this.outStream = outStreamLocal;
                        registered.pointer()
        if (failure == null) {
    private final class ChildSink implements ExchangeSink {
                    logger.warn("[reduce-sink] error signalling input EOF: taskId={}", ctx.taskId(), e);
                    // FFI structs via from_raw, so the buffers are Rust's to drop — do NOT release()
            } else {
            // so close is a no-op for the data. On the failure path we already invoked
                    );
    }
     * path casts each such column to the declared type before pushing it into the
    /**
    }
     * Field-by-field type equality. Ignores nullability; Timestamp precision/timezone
        } finally {
        StreamHandle outStreamLocal = null;
                Exception closeFailure = closeImpl();
                Thread.currentThread().interrupt();
public class DatafusionReduceSink extends AbstractDatafusionReduceSink implements MultiInputExchangeSink {
            ArrowType at = a.get(i).getType();
        } catch (Exception t) {
        }
                "No registered partition for childStageId=" + childStageId + "; known ids=" + sendersByChildStageId.keySet()
        List<Field> d = declared.getFields();
    /**
import org.apache.arrow.vector.types.pojo.Schema;
            outStream.close();
     * chosen precision round-trips through Arrow C Data — divergence is harmless.
    private final Map<Integer, DatafusionPartitionSender> sendersByChildStageId;
                }
                }
            // closes its receiver instead — the woken feeder runs the deferred native
                "DatafusionReduceSink has " + sendersByChildStageId.size() + " input partitions; use sinkForChild(int) instead of feed()"
            } else {
                    return;
                preparedState.close();
     * concurrent {@link #close()}, which would race {@code drop_in_place} on the senders
    @Override
 * <p>Multi-input shapes route via per-child wrappers from {@link #sinkForChild(int)}; the
        feedToSender(sendersByChildStageId.values().iterator().next(), batch, childSchemas.values().iterator().next());
                    senders.put(child.getKey(), preparedState.senders().get(i));
     *
            // Drain in flight: signal per-partition EOF, never cancel. Pipeline breakers
    }
import org.opensearch.analytics.spi.ExchangeSinkContext;
                // Only close senders we allocated locally (legacy path). When preparedState
        // before == READY (we just won) or DONE (reduce's finally calling us, or duplicate close).
        READY,
    }
     *       this very call and would short-circuit re-entry) so teardown runs then.</li>
    /** Returns the cumulative number of batches fed into any native sender. For Tests */
            listener.onResponse(null);
                    i++;
            // waiting on REDUCING state (cancel path) so the allocator can close safely.
            array.close();
                    logger.warn("[reduce-sink] reduce did not finish after input EOF; falling back to cancel: taskId={}", ctx.taskId());
import java.util.concurrent.atomic.AtomicLong;
    @Override
            if (isUtf8Family(at) && isUtf8Family(dt)) {
     * Per-child wrapper returned from {@link #sinkForChild(int)}. The orchestrator
     *       in-flight {@link #reduce}'s {@code finally} calls {@code closeImpl} directly
import org.opensearch.analytics.spi.ExchangeSink;
                throw e;
            listener.onFailure(new IllegalStateException("sink closed before reduce"));
 * <p>TODO abstraction leak: this class implements {@link MultiInputExchangeSink} unconditionally
            listener.onFailure(failure);
            // sender's read lock so session.close() can acquire the write lock without deadlock.
    /**
            // close after releasing its read lock. Genuine aborts still use cancel().
        } finally {
            batch.close();
        return feedCount.get();
                for (Map.Entry<Integer, byte[]> child : childInputs.entrySet()) {
                    // here (double-free). The sender latched the drop (see DatafusionPartitionSender),
            reduceDone.countDown();
        } finally {
 *
     * coalesce / projection paths can return either variant for the same logical column
            }
            // (SortExec/TopK) emit only after end-of-input, so closing the inputs lets the
import org.apache.arrow.memory.BufferAllocator;
                        producerPlanBytes
    final AtomicReference<SinkState> state = new AtomicReference<>(SinkState.READY);
        if (sender == null) {
        ArrowArray array = ArrowArray.allocateNew(alloc);
        Exception failure = null;
                "DatafusionReduceSink: batch schema types do not match declared schema. "
    /** Guards the teardown body so concurrent + sequential close paths don't run it twice. */
        throw new UnsupportedOperationException("DatafusionReduceSink overrides feed() directly");
    final AtomicBoolean torndown = new AtomicBoolean();
                    NativeBridge.RegisteredInput registered = NativeBridge.registerPartitionStream(
 * SPDX-License-Identifier: Apache-2.0
        Exception failure = null;
            // Signal that teardown is complete — unblocks any concurrent closeImpl()
     * planner pick a precision the Java-side declaration does not predict, and the
    /** Test seam: overridden to count invocations without static mocking. */
 * with the drain — backpressure is the bounded native input mpsc.
    private final java.util.concurrent.CountDownLatch reduceDone = new java.util.concurrent.CountDownLatch(1);
    }
        }
 * <p>Cleanup ownership lives in {@link #reduce}'s {@code finally} (via {@link SinkState}),
    private final AtomicLong feedCount = new AtomicLong();
     */
import org.apache.arrow.vector.types.pojo.Field;
     * exactly one registered sender.
    enum SinkState {
                    return;
                logger.warn("[ReduceSink] error closing child sender", t);
            // plan pre-emit (~5s stall, zero-row results). A sender with a feed in flight
     */
        ChildSink(DatafusionPartitionSender sender, Schema declaredSchema) {
     * Routes cleanup to the {@link #reduce} caller when a drain is in flight — never to a
            this.declaredSchema = declaredSchema;
        @Override
        BufferAllocator alloc = ctx.allocator();
    }
        }
    /** Cumulative batches fed into any native sender. */
import org.apache.logging.log4j.Logger;
        if (!typesMatch(batch.getSchema(), declaredSchema)) {
        @Override
                    + " batch="
                    fireCancelQuery();
        );
                        logger.warn("[reduce-sink] timed out waiting for reduce teardown: taskId={}", ctx.taskId());
    }
        assert before == SinkState.READY : "reduce called more than once (state=" + before + ")";
        }
            if (!at.equals(dt)) {
        public void close() {
            // parked in send_blocking (waiting for channel capacity). This releases the
     * <p>Utf8 / Utf8View are treated as equivalent for this advisory check. DataFusion's
            for (DatafusionPartitionSender sender : sendersByChildStageId.values()) {
            }
 * the logical child-stage count instead of the marker. Either split into a single-input
    @Override
     * (the allocator is thread-safe; multiple shard handlers can export concurrently),
                    // hang, then give teardown a short grace period.
     * Atomic via a single {@code compareAndExchange}: prior state tells us which branch to take.
        private volatile boolean childClosed;
 *
     * returned, cleanup ran). Close-before-reduce: READY → DONE inline.
     *   <li>REDUCING: drain is parked. Fire {@code cancel_query} so it unwinds — the
 * (the reduce stage's task, on a virtual thread).
     * Single-input path only: true once the sole input's consumer dropped its receiver (e.g. a
    }
            } catch (IllegalStateException e) {
                    // producer) — stopped accepting batches. Discard, don't fail the stream.
                }
            } finally {
        this.sendersByChildStageId = senders;
                    // Consumer finished first (e.g. a LimitExec satisfied its fetch) and dropped the
            try {
     * parameters are tolerated because the data-node parquet reader and physical
        }
     * <p>Two teardown signals are handled distinctly, and neither fails the query: a benign
     * and each producer observes early-termination on its own per-child wrapper
                session.close();
     *  when cancelled during REDUCING state so the allocator isn't closed prematurely. */
            arrowSchema.close();
    public ExchangeSink sinkForChild(int childStageId) {
                    // EOF didn't unblock the drain (e.g. the native plan is stuck for
     * </ul>
import org.apache.arrow.c.Data;
     * relaxes the Java-side tripwire so the legitimate divergence reaches that cast
 * (Union/Join), and callers like {@code ReduceStageExecution.inputSink} have to dispatch on
        }
    long feedCount() {
 * not {@link #close}, so a close call from another thread never races a parked drain.
        try {
 *
            "[reduce-sink] OPEN taskId={} hasPreparedState={} sessionPtr={}",
        // Best-effort fast path — skip the export if the sink is closed or this input's consumer
import java.util.Map;
        DatafusionPartitionSender sender = sendersByChildStageId.get(childStageId);
        REDUCING,
        @Override
     * receiver-drop (the consumer finished early) returns the {@link NativeBridge#SENDER_SEND_RECEIVER_DROPPED}
     * Not used — feed() is overridden directly for the single-input path and
    @Override
                logger.debug("[reduce-sink] ALLOC preparedPlan stream taskId={} streamPtr={}", ctx.taskId(), streamPtr);
     * so multiple producers feeding the same sender is safe.
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(alloc);
        this(ctx, runtimeHandle, null);
        }
 * stream into {@link ExchangeSinkContext#downstream()} inline on the {@link #reduce} caller
    /**
        } catch (Exception t) {
        if (torndown.compareAndSet(false, true) == false) {
                for (Map.Entry<Integer, byte[]> child : childInputs.entrySet()) {
    private static boolean isUtf8Family(ArrowType type) {
        SinkState before = state.compareAndExchange(SinkState.READY, SinkState.REDUCING);
        logger.debug(
                streamPtr = NativeBridge.executeLocalPreparedPlan(session.getPointer(), ctx.taskId());
            if (preparedState != null) {
        return failure;
import org.opensearch.be.datafusion.nativelib.StreamHandle;
        boolean success = false;
 *
                    // so subsequent feeds for this input short-circuit and the producer stream is
            state.set(SinkState.DONE);
                // Java allocator. (ArrowArray.close / ArrowSchema.close in the finally
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
            try {
        // reduce() caller thread. No separate drain executor.
            // Free the wrappers. On the success path Rust nulled the release callback,
    }
                    senders.put(childStageId, new DatafusionPartitionSender(registered.pointer()));
                    + batch.getSchema()
        return id == ArrowType.ArrowTypeID.Utf8 || id == ArrowType.ArrowTypeID.Utf8View;
        if (sendersByChildStageId.size() != 1) {
                if (closed || sender.isCloseRequested()) {
                    + declaredSchema
     * {@code getPointer()} before the native call. Both discard the batch.
    @Override
        if (closed || sender.isReceiverDropped()) {
                    childSchemas.put(childStageId, ArrowSchemaIpc.fromBytes(registered.schemaIpc()));
            } catch (Throwable t) {
        // Type-only equality check; nullability and Timestamp precision are advisory.
            batch.close();
                    if (!reduceDone.await(5, java.util.concurrent.TimeUnit.SECONDS)) {
                    logger.debug("[ReduceSink] send-after-close race caught, discarding batch");
            preparedState != null,
     */
                return false;
    private void feedToSender(DatafusionPartitionSender sender, VectorSchemaRoot batch, Schema declaredSchema) {
        for (int i = 0; i < a.size(); i++) {
            }
    /**
                    // Benign: the sink — or just this input (per-child EOF racing a live
     * rather than tripping an early IllegalStateException.
                    logger.debug("[ReduceSink] receiver dropped before send (consumer finished), discarding batch");
    private static boolean typesMatch(Schema actual, Schema declared) {
            throw new IllegalStateException(
