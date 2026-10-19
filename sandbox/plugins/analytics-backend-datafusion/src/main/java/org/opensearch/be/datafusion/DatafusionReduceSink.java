        SinkState before = state.compareAndExchange(SinkState.READY, SinkState.DONE);
     * exactly one registered sender.
            }
            "[reduce-sink] OPEN taskId={} hasPreparedState={} sessionPtr={}",
    private final class ChildSink implements ExchangeSink {
            }
     * class contract.
    /**
    private final AtomicLong feedCount = new AtomicLong();
            array.close();  
     * the routing target is ambiguous.  
     * Lock-free per-sender feed. Exports the batch via Arrow C Data outside any lock
            }
        try {
     *  when cancelled during REDUCING state so the allocator isn't closed prematurely. */
                logger.debug("[reduce-sink] ALLOC preparedPlan stream taskId={} streamPtr={}", ctx.taskId(), streamPtr);
     */
                if (!reduceDone.await(5, java.util.concurrent.TimeUnit.SECONDS)) {  
package org.opensearch.be.datafusion;
        }
}  
        assert before == SinkState.READY : "reduce called more than once (state=" + before + ")";
        // before == READY (we just won) or DONE (reduce's finally calling us, or duplicate close).  
        // Drain is not started here — it runs inline on the owning reduce stage's
                        logger.warn("[reduce-sink] timed out waiting for reduce teardown: taskId={}", ctx.taskId());
    private static boolean typesMatch(Schema actual, Schema declared) {
        REDUCING,  
    protected void feedBatchUnderLock(VectorSchemaRoot batch) {
        super(ctx, runtimeHandle, preparedState);  
        } catch (Exception t) {
                    logger.warn("[reduce-sink] error signalling input EOF: taskId={}", ctx.taskId(), e);
        Exception failure = null;  
 * this file be licensed under the Apache-2.0 license or a
                    NativeBridge.streamClose(streamPtr);
        ArrowType.ArrowTypeID id = type.getTypeID();
            outStream.close();  
        READY,
            ctx.taskId(),  
     * path casts each such column to the declared type before pushing it into the  
     * parameters are tolerated because the data-node parquet reader and physical
                }
 * not {@link #close}, so a close call from another thread never races a parked drain.  
        return true;  
        } finally {
                if (closeFailure != null) {
        }
        if (before == SinkState.REDUCING) {  
                    + batch.getSchema()
/**
            outStreamLocal = new StreamHandle(streamPtr, runtimeHandle);  
     * Single-input path only: true once the sole input's consumer dropped its receiver (e.g. a
            reduceDone.countDown();
    /**
            // drain finish naturally with all accepted rows; cancelling here aborted the  
            arrowSchema.close();
import org.apache.arrow.vector.types.pojo.ArrowType;  
        ChildSink(DatafusionPartitionSender sender, Schema declaredSchema) {  
    /** Returns the cumulative number of batches fed into any native sender. For Tests */
     * Not used — feed() is overridden directly for the single-input path and  
                    }  
            // so close is a no-op for the data. On the failure path we already invoked
        }  
        try {  
     */
        return feedCount.get();
            );
    long feedCount() {  
                }  
    private final Map<Integer, DatafusionPartitionSender> sendersByChildStageId;
import org.apache.arrow.c.Data;  
     * {@link ChildSink#feed} for the multi-input path. Required by the abstract
                continue;  
            if (at.getTypeID() == ArrowType.ArrowTypeID.Timestamp && dt.getTypeID() == ArrowType.ArrowTypeID.Timestamp) {
                }
                    + declaredSchema
                // never took ownership and the FFI structs' release callbacks are still  
        // Type-only equality check; nullability and Timestamp precision are advisory.
                batch.close();
import org.opensearch.analytics.spi.ExchangeSink;
            // Signal that teardown is complete — unblocks any concurrent closeImpl()
        ArrowArray array = ArrowArray.allocateNew(alloc);
        StreamHandle outStreamLocal = null;  
import java.util.concurrent.atomic.AtomicReference;
        Exception failure = null;
                // Only close senders we allocated locally (legacy path). When preparedState
        if (closed || sender.isReceiverDropped()) {  
 *
                    logger.debug(
    /**
                    logger.debug("[ReduceSink] send-after-close race caught, discarding batch");  
     * Field-by-field type equality. Ignores nullability; Timestamp precision/timezone  
                        childStageId,
import org.apache.arrow.vector.VectorSchemaRoot;
            if (isUtf8Family(at) && isUtf8Family(dt)) {
 * with the drain — backpressure is the bounded native input mpsc.  
            } catch (InterruptedException e) {
     * Atomic via a single {@code compareAndExchange}: prior state tells us which branch to take.
                Data.exportVectorSchemaRoot(alloc, batch, null, array, arrowSchema);
        feedToSender(sendersByChildStageId.values().iterator().next(), batch, childSchemas.values().iterator().next());
        }
 *  
     */
    protected Exception closeImpl() {
 * SPDX-License-Identifier: Apache-2.0
     * then sends it through the supplied sender. The Rust mpsc::Sender is thread-safe,
            }
            } else {  
        if (sender == null) {
     * method when more than one partition is registered is a programming error because
            logger.debug("[reduce-sink] reduce failed: taskId={} error={}", ctx.taskId(), failure.getMessage());  
import org.opensearch.be.datafusion.nativelib.StreamHandle;  
     * routes one of these per child stage, and the wrapper's close() signals EOF for
        long streamPtr = 0;
                }  
    private static boolean isUtf8Family(ArrowType type) {  
                streamPtr = NativeBridge.executeLocalPlan(session.getPointer(), ctx.fragmentBytes(), ctx.taskId());  
        }
 *
            throw new IllegalArgumentException(  
    @Override
 * <p>Multi-input shapes route via per-child wrappers from {@link #sinkForChild(int)}; the
            try {
            this.sender = sender;
            // closes its receiver instead — the woken feeder runs the deferred native
     * relaxes the Java-side tripwire so the legitimate divergence reaches that cast
                array.release();
            batch.close();
import org.apache.arrow.c.ArrowSchema;
import java.util.concurrent.atomic.AtomicBoolean;  
                        registered.pointer()
        } catch (Exception e) {
     * ({@link ChildSink#isConsumerDone()}) — a single top-level answer can't be correct there (one
     *       (NOT {@code super.close()}, because the base's {@code closed} flag was set by  
        try {
            } finally {  
        boolean success = false;
            } else {
    /**
                    int childStageId = child.getKey();
                    // cancelled by the shard listener via isConsumerDone().
                        sender.close();
            ArrowType at = a.get(i).getType();  
        throw new UnsupportedOperationException("DatafusionReduceSink overrides feed() directly");  
import java.util.List;
                    // FFI structs via from_raw, so the buffers are Rust's to drop — do NOT release()
            }  
                if (closed || sender.isCloseRequested()) {  
            }  
            }
                // below frees the wrapper but does NOT invoke the C release callback.)  
            return null;
     * Per-child wrapper returned from {@link #sinkForChild(int)}. The orchestrator  
    }
        @Override
     * returned, cleanup ran). Close-before-reduce: READY → DONE inline.
                    failure = accumulate(failure, closeFailure);  
            }
                "No registered partition for childStageId=" + childStageId + "; known ids=" + sendersByChildStageId.keySet()
        }
            return false;  
                // Java allocator. (ArrowArray.close / ArrowSchema.close in the finally
                    }
    }
        } catch (Exception t) {
                }
                for (Map.Entry<Integer, byte[]> child : childInputs.entrySet()) {
     *   <li>REDUCING: drain is parked. Fire {@code cancel_query} so it unwinds — the
            // release explicitly above.
            // close after releasing its read lock. Genuine aborts still use cancel().  
            }
     *
     * code, while a concurrent {@link #close()} surfaces as an IllegalStateException from  
            }
            childClosed = true;
                }
import org.apache.arrow.vector.types.pojo.Schema;
            if (!at.equals(dt)) {
                    sender.requestEarlyTermination();  
     *       Do the teardown; {@link #torndown} gates against double-running it.</li>  
            // (SortExec/TopK) emit only after end-of-input, so closing the inputs lets the
    public void reduce(ActionListener<Void> listener) {
 * subclass and a multi-input subclass, or drop the marker and let the caller always go through  
        }
            listener.onFailure(failure);
 * pushes each fed batch through a tokio mpsc-backed sender, and drains the native output  
                streamPtr = NativeBridge.executeLocalPreparedPlan(session.getPointer(), ctx.taskId());
     * StreamingTable (see {@code conform_batch_to_schema} in api.rs) — this check only
    @Override
    private final java.util.concurrent.CountDownLatch reduceDone = new java.util.concurrent.CountDownLatch(1);
    private static final Logger logger = LogManager.getLogger(DatafusionReduceSink.class);
     * its specific input partition. Idempotent — duplicate close() calls are no-ops.
        // reduce() caller thread. No separate drain executor.
 * The OpenSearch Contributors require contributions made to  
                    );  
                    return;
                }  
 * Streaming coordinator-side reduce sink: opens one native partition stream per child input,
import org.apache.arrow.c.ArrowArray;
     * (the allocator is thread-safe; multiple shard handlers can export concurrently),  
     *       this very call and would short-circuit re-entry) so teardown runs then.</li>
        try {
                    logger.debug("[ReduceSink] receiver dropped before send (consumer finished), discarding batch");  
     */
            if (childClosed) {
                if (rc == NativeBridge.SENDER_SEND_RECEIVER_DROPPED) {
            // Free the wrappers. On the success path Rust nulled the release callback,  
                    if (!reduceDone.await(5, java.util.concurrent.TimeUnit.SECONDS)) {  
     * Routes cleanup to the {@link #reduce} caller when a drain is in flight — never to a
import org.apache.arrow.vector.types.pojo.Field;
            }
                for (Map.Entry<Integer, byte[]> child : childInputs.entrySet()) {
                        producerPlanBytes
        if (sendersByChildStageId.size() != 1) {
                    session.close();
            for (DatafusionPartitionSender sender : sendersByChildStageId.values()) {
    void fireCancelQuery() {
 * the logical child-stage count instead of the marker. Either split into a single-input
    }  
        }  
 * bare {@link #feed(VectorSchemaRoot)} is reserved for single-input. Feeds are concurrent
 *
        Map<Integer, DatafusionPartitionSender> senders = new LinkedHashMap<>(childInputs.size());
    }  
        if (!typesMatch(batch.getSchema(), declaredSchema)) {  
            // Extract DataFusion execution metrics + physical plan after drain (before close)  
        } else {
import java.util.concurrent.atomic.AtomicLong;
     */  
            throw new IllegalStateException(
            return null;
                    // Consumer finished first (e.g. a LimitExec satisfied its fetch) and dropped the  
                logger.debug("[reduce-sink] ALLOC localPlan stream taskId={} streamPtr={}", ctx.taskId(), streamPtr);
    }  
        // Best-effort fast path — skip the export if the sink is closed or this input's consumer
        if (torndown.compareAndSet(false, true) == false) {
    /**
        return new ChildSink(sender, childSchemas.get(childStageId));
        public boolean isConsumerDone() {
                    );
    }
            // close — see DatafusionPartitionSender. Throws IllegalStateException via
     * rather than tripping an early IllegalStateException.  
        private final DatafusionPartitionSender sender;
    }
 */  
        return sendersByChildStageId.size() == 1 && sendersByChildStageId.values().iterator().next().isReceiverDropped();
                preparedState.close();  
import java.util.Map;
                "DatafusionReduceSink: batch schema types do not match declared schema. "  
            }  
            success = true;
    public void feed(VectorSchemaRoot batch) {  
        }
    /**
            batch.close();
                    + "declared="
     * <p>Two teardown signals are handled distinctly, and neither fails the query: a benign
        this(ctx, runtimeHandle, null);
     *       in-flight {@link #reduce}'s {@code finally} calls {@code closeImpl} directly
                        inputIdFor(childStageId),  
     *   <li>READY: external close (no drain in flight). Tear down inline.</li>  
     * (e.g. an outer join on the null-fill side returns plain Utf8 while a non-null side
                int i = 0;
    @Override
                failure = accumulate(failure, t);  
     * <p>Utf8 / Utf8View are treated as equivalent for this advisory check. DataFusion's
        ArrowSchema arrowSchema = ArrowSchema.allocateNew(alloc);
                sender.close();
     * so multiple producers feeding the same sender is safe.
            feedToSender(sender, batch, declaredSchema);
    private void feedToSender(DatafusionPartitionSender sender, VectorSchemaRoot batch, Schema declaredSchema) {  
    /** Signalled when reduce's finally completes teardown. closeImpl awaits this  
import org.apache.arrow.memory.BufferAllocator;
                Thread.currentThread().interrupt();
        }  
            throw new IllegalStateException(  
     * receiver-drop (the consumer finished early) returns the {@link NativeBridge#SENDER_SEND_RECEIVER_DROPPED}
     */
    }  
        return failure;
                    // producer) — stopped accepting batches. Discard, don't fail the stream.
 * <p>TODO abstraction leak: this class implements {@link MultiInputExchangeSink} unconditionally
     * single-input case can pick the sole entry without an explicit lookup.  
    }  
        List<Field> a = actual.getFields();  
    /** Test seam: overridden to count invocations without static mocking. */
     * </ul>
        @Override  
            if (!success) {  
            );
import org.opensearch.core.action.ActionListener;
            // sender's read lock so session.close() can acquire the write lock without deadlock.
     *  
 * <p>Cleanup ownership lives in {@link #reduce}'s {@code finally} (via {@link SinkState}),
    /** Guards the teardown body so concurrent + sequential close paths don't run it twice. */  
        }
        }  
    }
                    // here (double-free). The sender latched the drop (see DatafusionPartitionSender),  
                    // another reason). Fall back to a hard cancel so close() cannot
        private volatile boolean childClosed;
    public boolean isConsumerDone() {
            ArrowType dt = d.get(i).getType();
            try {  
        logger.debug(
import org.apache.logging.log4j.LogManager;  
     */  
        BufferAllocator alloc = ctx.allocator();
        List<Field> d = declared.getFields();
 * even when only one child stage feeds it. The marker is meant for genuine multi-input shapes  
 */
                    // so subsequent feeds for this input short-circuit and the producer stream is
    /**
        if (a.size() != d.size()) {
            // NativeHandle.getPointer() if the sender was closed (the close-race path).
     * Multi-input callers must use {@link #sinkForChild(int)} instead — calling this
                Exception closeFailure = closeImpl();
                    childSchemas.put(childStageId, ArrowSchemaIpc.fromBytes(registered.schemaIpc()));
                } catch (Exception e) {
        }  
     */  
    final AtomicReference<SinkState> state = new AtomicReference<>(SinkState.READY);
                    senders.put(childStageId, new DatafusionPartitionSender(registered.pointer()));  
        }
    }  
            if (preparedState != null) {
     * Lock-free feed for the single-input case: writes to the sole registered sender.  
            this.declaredSchema = declaredSchema;
import org.apache.logging.log4j.Logger;
                "DatafusionReduceSink has " + sendersByChildStageId.size() + " input partitions; use sinkForChild(int) instead of feed()"
                    logger.warn("[reduce-sink] reduce did not finish after input EOF; falling back to cancel: taskId={}", ctx.taskId());
            try {  
    /**  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        SinkState before = state.compareAndExchange(SinkState.READY, SinkState.REDUCING);  
        }  
import java.util.LinkedHashMap;  
            return;
                    // receiver while shards were still feeding. api::sender_send already consumed the
        for (int i = 0; i < a.size(); i++) {
                    for (DatafusionPartitionSender sender : senders.values()) {
    public DatafusionReduceSink(ExchangeSinkContext ctx, NativeRuntimeHandle runtimeHandle, DataFusionReduceState preparedState) {
            state.set(SinkState.DONE);
    }  
            } catch (IllegalStateException e) {
 * stream into {@link ExchangeSinkContext#downstream()} inline on the {@link #reduce} caller
     * returns Utf8View). The two layouts are NOT byte-identical, so the Rust sender_send
import org.opensearch.analytics.spi.MultiInputExchangeSink;
                        "[reduce-sink] ALLOC sender taskId={} childStageId={} senderPtr={}",
        public void close() {
        this.outStream = outStreamLocal;
            this.executionMetrics = NativeBridge.streamGetMetrics(outStream.getPointer());
     * chosen precision round-trips through Arrow C Data — divergence is harmless.  
        DatafusionPartitionSender sender = sendersByChildStageId.get(childStageId);
     * concurrent {@link #close()}, which would race {@code drop_in_place} on the senders  
                if (streamPtr != 0) {
        }
 * {@code feed()} when there's one child. Current behaviour is correct but the typing lies.
            failure = accumulate(failure, t);
                        ctx.taskId(),  
     * <ul>
            listener.onFailure(new IllegalStateException("sink closed before reduce"));
    public DatafusionReduceSink(ExchangeSinkContext ctx, NativeRuntimeHandle runtimeHandle) {
                if (preparedState == null) {  
                    i++;
            // waiting on REDUCING state (cancel path) so the allocator can close safely.  
                    + " batch="  
                // owns them, the state's close() will.
            return;  
        public void feed(VectorSchemaRoot batch) {  
                return;  
                return false;  
                    // hang, then give teardown a short grace period.  
            } catch (Throwable t) {
        return id == ArrowType.ArrowTypeID.Utf8 || id == ArrowType.ArrowTypeID.Utf8View;
     * and each producer observes early-termination on its own per-child wrapper
                    // Benign: the sink — or just this input (per-child EOF racing a live
                    // EOF didn't unblock the drain (e.g. the native plan is stuck for
 * compatible open source license.
                    fireCancelQuery();
            // Close outStream first: drops the native receiver, which unblocks any sender  
     * planner pick a precision the Java-side declaration does not predict, and the
                feedCount.incrementAndGet();  
            return sender.isReceiverDropped();  
    }
        logger.debug("[reduce-sink] fireCancelQuery: taskId={}", ctx.taskId());  
    public ExchangeSink sinkForChild(int childStageId) {  
            }
                continue;  
     *   <li>DONE: this IS the {@code reduce()} finally call (or an idempotent second close).
 * (the reduce stage's task, on a virtual thread).
                    NativeBridge.RegisteredInput registered = NativeBridge.registerPartitionStream(
            failure = accumulate(failure, t);
            // parked in send_blocking (waiting for channel capacity). This releases the
                session.close();
        } finally {
                }  
            } catch (Exception t) {
     * LimitExec satisfied its fetch). Multi-input shapes (join/union) feed via {@link #sinkForChild}  
                        session.getPointer(),
                // Sender close raced our send — thrown BEFORE the native call, so Rust
        @Override
    @Override  
        }  
        private final Schema declaredSchema;  
        try {
        // already dropped its receiver (nothing downstream will read another batch on it).
            drainOutputIntoDownstream(outStream);
                long rc = sender.send(array.memoryAddress(), arrowSchema.memoryAddress());
    @Override  
     * coalesce / projection paths can return either variant for the same logical column  
        if (failure == null) {  
     * and abort the JVM. Transitions: READY → REDUCING (reduce entered) → DONE (drain
    enum SinkState {
    final AtomicBoolean torndown = new AtomicBoolean();
     * {@code getPointer()} before the native call. Both discard the batch.
        DONE
            // plan pre-emit (~5s stall, zero-row results). A sender with a feed in flight
    /** Cumulative batches fed into any native sender. */
public class DatafusionReduceSink extends AbstractDatafusionReduceSink implements MultiInputExchangeSink {  
            batch.close();
            try {
        } finally {
        this.sendersByChildStageId = senders;  
 * (Union/Join), and callers like {@code ReduceStageExecution.inputSink} have to dispatch on
                logger.warn("[ReduceSink] error closing child sender", t);  
     */
            try {  
        NativeBridge.cancelQuery(ctx.taskId());
                arrowSchema.release();
            // sender.send acquires its read lock so the native borrow outlives concurrent  
    @Override
     * Per-child senders keyed by childStageId, populated in declaration order so the
                    byte[] producerPlanBytes = child.getValue();  
    /**
        );  
import org.opensearch.analytics.spi.ExchangeSinkContext;  
                    return;
                }
            listener.onResponse(null);
    private final StreamHandle outStream;  
        }
                // set. Invoke them explicitly to free the exported buffers back to the
            failure = e;  
                try {
    }
            );
            preparedState != null,
                    childSchemas.put(child.getKey(), preparedState.inputSchemas().get(i));
                throw e;  
                    senders.put(child.getKey(), preparedState.senders().get(i));  
        if (before == SinkState.DONE) {
            if (preparedState != null) {  
    }
            session != null ? session.getPointer() : 0
     * dropped join side ≠ whole reduce done), so this conservatively returns false unless there is  
            // Drain in flight: signal per-partition EOF, never cancel. Pipeline breakers
        }  
/*  
