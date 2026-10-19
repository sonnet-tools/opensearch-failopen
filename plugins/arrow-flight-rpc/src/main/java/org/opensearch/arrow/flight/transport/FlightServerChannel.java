/**
            return;
        BufferAllocator allocator,  
                open.get(),  
     * Frees the source buffers of a batch that was built but never handed to {@link #sendBatch}  
            cancelled = true;
 * producer thread while {@code close()} frees it on the executor) is a data race that corrupts Arrow
            closeListenersFired = true;
 *       sends, {@code completeStream}/{@code sendError}, and the root free among themselves, so none  
    }
    public BufferAllocator getAllocator() {
                    correlationId
    /** Idempotent cleanup invoked from the strategy when gRPC fires {@code OnCancelHandler}. */
    public InetSocketAddress getLocalAddress() {
    public FlightServerChannel(
 *
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
    }  
 * SPDX-License-Identifier: Apache-2.0
    public boolean isOpen() {  
        return remoteAddress;
        this.serverStreamListener = serverStreamListener;
    private boolean terminalSent = false;
        }
import org.apache.arrow.flight.FlightRuntimeException;
    public ExecutorService getExecutor() {
    public void completeStream(ByteBuffer header) {
    public void sendError(ByteBuffer header, Exception error) {
        if (!cancelled) {
            logger.debug("Completing empty stream for correlation ID: {}", correlationId);
        }  
import java.util.concurrent.atomic.AtomicInteger;  
import org.opensearch.core.action.ActionListener;
                    serverStreamListener.putNext(metadataBuf);  
        return root;
            } catch (Exception e) {
            }  
                VectorTransfer.transferRoot(sourceRoot, created);
 *       operation: it flips {@link #open} exactly once via {@code compareAndSet}, fires close
            long putNextTime = (System.nanoTime() - batchStartTime) / 1_000_000;
     * @throws IOException if header serialization or byte-path serialization fails
        try {
            if (firstBatch) {  
        if (error instanceof FlightRuntimeException fre) {
        listener.onResponse(null);
        }
     *         {@link StreamErrorCode#CANCELLED} if the client cancelled.  
    }
        try {
    private final List<ActionListener<Void>> closeListeners = new ArrayList<>();  
                    created.close();
     * the freshly-created root, that root is freed here so it cannot leak (it has not yet become
import org.apache.arrow.flight.CallStatus;
        synchronized (closeListenerMutex) {  
                logger.debug("Batch #{} sent for correlation ID: {}, putNext: {}ms", batchNumber, correlationId, putNextTime);
    private void transferIntoStreamRoot(VectorSchemaRoot sourceRoot, boolean firstBatch) {
                callTracker.recordBatchSent(rootSize, System.nanoTime() - batchStartTime);
        } else {
     */
        boolean alreadyFired;
        middleware.setHeader(header);  
/*  
            }  
                        metadataBuf.close();  
            } else {
 * <p><b>Ownership &amp; concurrency — single-writer model.</b> This channel is the sole owner of  
            }  
        return PROFILE_NAME;
 *       every exit), or by {@link #releaseUnsent} when the batch never reached {@code sendBatch}.</li>
                sourceRoot.close();  
            try {
     */
 *       listeners, and <b>posts the root free onto the flight executor</b>. Because the executor is
            listener.accept(null, null);  
        FlightRuntimeException flightExc;
            } else {
            // Set header if no batches were sent
import org.apache.arrow.vector.FieldVector;
 * reference counts and can orphan or double-free buffers (an off-heap leak). It keeps that ownership  
     * created, filled, and freed only there. {@code volatile} so the test-only {@link #getRoot()}  
     * pool — or limit concurrent streams via admission control — accordingly.
     *         remains not-ready longer than {@code readyTimeoutMillis}, or
    private final CompositeBackpressureStrategy bp;
import org.opensearch.transport.TcpChannel;
        for (ActionListener<Void> listener : toFire) {  
    public void awaitReadyOrThrow() {
    }
            removableToFire = new ArrayList<>(removableCloseListeners);
        return allocator;  
    /**  
 * this file be licensed under the Apache-2.0 license or a
                serverStreamListener.putNext();
        // Registered against notifyCloseListeners exactly like addCloseListener(ActionListener), see there.  
    public void addCloseListener(ActionListener<Void> listener) {
        if (cancelled) {  
     *  
            } else {
            logger.debug("Sending batch #{} for correlation ID: {}", batchNumber, correlationId);
 * ({@link #closeListenerMutex}) whose critical section only mutates that list. See
     * stream root — that is deferred to {@link #close()} to preserve gRPC's zero-copy retention window.  
        } catch (RejectedExecutionException e) {  
                    }
        if (!open.get() || cancelled || terminalSent) {  
 * producer threads call {@link #awaitReadyOrThrow()} before a batch is submitted and park  
                correlationId  
                correlationId  
            middleware.setHeader(header);  
        } finally {
                    correlationId,  
                open.get(),  
    public InetSocketAddress getRemoteAddress() {
        this.localAddress = new InetSocketAddress(InetAddress.getLoopbackAddress(), 0);  
                } catch (Throwable t) {
     * into the reused stream root and the producer root is freed here exactly once (on every exit, via
            List<FieldVector> fieldVectors = sourceRoot.getFieldVectors();
    private final ExecutorService executor;
        return localAddress;  
    }
            // means new tasks are refused while an already-running send may still be touching the root
 *   <li>{@link #close()} may be called from any thread (the gRPC cancel callback, the flight executor
        logger.debug("Creating FlightServerChannel for correlation ID: {}", correlationId);
import org.opensearch.core.transport.TransportResponse;
                .toRuntimeException();
                }
    static void releaseUnsentSource(TransportResponse response) {  
            alreadyFired = closeListenersFired;  
    @Override
                ArrowBuf metadataBuf = allocator.buffer(metadata.length);  
        notifyCloseListeners();
    public void close() {
                throw new StreamException(StreamErrorCode.TIMED_OUT, "consumer not ready after " + readyTimeoutMillis + "ms");
        this.executor = executor;
    private void notifyCloseListeners() {
            if (fieldVectors.isEmpty()) {
        } else {
import org.opensearch.transport.stream.StreamErrorCode;  
        }  
            flightExc = CallStatus.INTERNAL.withCause(error)
     * the sole place they are transferred onto the wire and freed.
        // Assume Arrow Flight is connected  
                try {
    }
 * <p><b>Invariant: this channel is NOT thread-safe. All send-side mutation — the stream {@link #root}  
 *   <li><b>The stream {@link #root} and every {@code serverStreamListener} call  
     * <p>For an {@link ArrowBatchResponse} (native path) the producer's root is zero-copy transferred
     * @param response the batch to send; the channel takes ownership of its buffers  
    }  
        } finally {
    }
                listener.accept(null, null);  
                throw new IllegalStateException("Native Arrow batch has no field vectors");  
import java.util.ArrayList;
     */  
            // Build the header before mutating any root so a header-serialization failure fails fast
        // thread.
        // Fire-once: exactly one caller wins the CAS, regardless of thread (gRPC cancel, the flight
        return executor;
    public ChannelStats getChannelStats() {
     * simultaneously and can starve the pool. Operators should size the action's thread
    private final long readyTimeoutMillis;
            }  
                serializeIntoStreamRoot(response, firstBatch);
            listener.onResponse(null);  
        // by the executor's own FIFO ordering; we never touch Arrow buffers from this (possibly gRPC)  
        if (firstBatch) {  
     */
            if (!firstBatch) {
            throw StreamException.cancelled("stream cancelled before back-pressure wait");
    }  
     * Static variant of {@link #releaseUnsent} for the defensive path where the channel is the wrong
                adopted = true;
                    if (metadataBuf.refCnt() > 0) {
            removableCloseListeners.clear();  
import org.opensearch.transport.stream.StreamException;
            toFire = new ArrayList<>(closeListeners);  
            final long batchStartTime = System.nanoTime();
     *
                // Flight takes ownership of metadataBuf via putNext(ArrowBuf); free it ourselves
            try {
     * @param error the error to send  
            final ByteBuffer header = headerSupplier.get();  
        }  
            if (!alreadyFired) {
        BackpressureStrategy.WaitResult result = bp.waitForListener(readyTimeoutMillis);  
            // still holds its buffers (close frees them).
                    root.close();
        // have not fired yet and we enqueue (notifyCloseListeners will fire it), or they have already
 *       ({@code start}/{@code putNext}/{@code completed}/{@code error}) happen only on the channel's
                logger.warn(new ParameterizedMessage("close listener failed for correlation ID: {}", correlationId), e);
    }
        }
                e
 *
            response.writeTo(out);
    @Override
            removableCloseListeners.remove(listener);
    }
    /** Leaf mutex guarding {@link #closeListeners} and {@link #closeListenersFired}; its critical section only mutates them. */
     * creating it on the first batch and clearing it for reuse on later batches. On the first batch,
            }  
import org.apache.logging.log4j.LogManager;  
            // buffers (from C data import) does not properly free the ArrowArray C struct. The producer's  
     * (the back-pressure gate threw, the executor rejected the task, or the channel was the wrong
        listener.onFailure(new UnsupportedOperationException("FlightServerChannel does not support BytesReference based sendMessage()"));
import org.apache.arrow.vector.VectorSchemaRoot;
    /**
            case CANCELLED:
import java.io.IOException;  
            }
            if (cancelled) {  
        }
    private boolean closeListenersFired = false;
        } else {  
import org.opensearch.core.common.bytes.BytesReference;  
     * type). The channel owns the source root from the moment the producer enqueues the batch, so on a
        ExecutorService executor,  
        callTracker.recordCallEnd(mapFromCallStatus(flightExc).name());  
class FlightServerChannel implements TcpChannel, ArrowFlightChannel {
            }  
package org.opensearch.arrow.flight.transport;
 *  
    public void addCloseListener(BiConsumer<Void, ? super Exception> listener) {
     *
            }
            });
    }  
            executor.execute(() -> {  
import org.apache.arrow.memory.ArrowBuf;
        if (!open.compareAndSet(true, false)) {
                }  
        if (root == null) {
     * The reused stream root (native or byte-serialized). Confined to the flight-executor thread:
        }
            // allocator must be long-lived (not closed per-request).
        // Register atomically against notifyCloseListeners under the leaf mutex: either the listeners  
            // channel-owned root, which close() frees.  
    @Override  
            alreadyFired = closeListenersFired;  
        }  
    public void releaseUnsent(TransportResponse response) {  
                sourceRoot.close();
        terminalSent = true;  
import org.apache.arrow.memory.BufferAllocator;  
            close();
            if (metadata != null) {  
     * byte-serialized path (no off-heap source root).
        serverStreamListener.completed();
            VectorTransfer.transferRoot(sourceRoot, root);
    /**
        }
                terminalSent,
            // shutdown-time leak is visible rather than buried.
        this.middleware = middleware;
 *
    }
 *       FIFO and single-threaded, that free runs only after any in-flight send completes.  
        synchronized (closeListenerMutex) {
            if (sourceRoot != null) {  
            adopted = true;  
            // (the source root is still freed by the finally) without adopting a stream root.
    /**
        final VectorSchemaRoot sourceRoot = isNative ? ((ArrowBatchResponse) response).getRoot() : null;  
 * <p>The producer must invoke {@link #sendBatch} serially and finish with {@link #completeStream}
    private final AtomicInteger batchNumber = new AtomicInteger(0);  
                    throw t;
                metadataBuf.writeBytes(metadata);
        this.allocator = allocator;
     * @throws StreamException with {@link StreamErrorCode#TIMED_OUT} if the consumer
            // exit: after a successful transfer it is empty (close is a no-op); on any early throw it  
     * <p>This method, the terminal ops, and the {@link #close()} root-free all run on the
 * {@code docs/channel-lifecycle-ownership.md} for the full contract.
     * {@code finally}. No-op for the byte-serialized path (no off-heap source root).
        }
    }
            return;
     * sees a consistent reference; correctness relies on executor confinement, not on volatility.
     * from the producer thread before the batch is submitted to the channel's executor.
     * creating it on the first batch. On the first batch, if transfer fails before the channel adopts
                ),  
            } finally {
 * (success) or {@link #sendError} (failure).
import java.util.function.BiConsumer;
    public void removeCloseListener(BiConsumer<Void, ? super Exception> listener) {
    public String getProfile() {  
            boolean adopted = false;  
        }
 * <p>Honours gRPC's {@code isReady()} contract via {@link CompositeBackpressureStrategy}:
            default:
    public boolean isCancelled() {
        serverStreamListener.error(flightExc);
            root = out.getRoot();
     * Byte-serialized path: writes {@code response} into the reused {@code VarBinary} stream root,
            // The native source root is exclusively owned by this call. Free it exactly once on every
                try {
        for (BiConsumer<Void, ? super Exception> listener : removableToFire) {
                }  
    private final List<BiConsumer<Void, ? super Exception>> removableCloseListeners = new ArrayList<>();
                return;  
import org.apache.arrow.flight.FlightProducer.ServerStreamListener;  
        boolean alreadyFired;
 */  
        this.bp.register(serverStreamListener);  
        FlightCallTracker callTracker,
            }  
 * </ul>
     * Sends one streaming batch. <b>Must run on the flight executor thread</b> (it is dispatched there  
     * without adopting a stream root.
                // only if putNext never adopted it.
    private final InetSocketAddress remoteAddress;  
 *       can interleave.</li>
        boolean adopted = false;
        this.readyTimeoutMillis = readyTimeoutMillis;
    public void sendMessage(BytesReference reference, ActionListener<Void> listener) {  
    public void sendBatch(TransportResponse response, CheckedSupplier<ByteBuffer, IOException> headerSupplier) throws IOException {
                "completeStream is a no-op (open={}, cancelled={}, terminalSent={}) for correlation ID: {}",
            }
        // double-fired, then fire outside the mutex so foreign listener code never runs while we hold  
    }
        switch (result) {
     */
            flightExc = fre;  
     *  
            VectorSchemaRoot sourceRoot = arrowResponse.getRoot();
        callTracker.recordCallEnd(StreamErrorCode.OK.name());
            // Create using the producer's allocator: cross-allocator transferOwnership of foreign-backed
import java.nio.ByteBuffer;  
            logger.error("Unexpected error in Flight stream", error);
    /** Whether the client cancelled the gRPC stream (onChannelCancelled fired). Read by FlightTransportChannel. */  
        final boolean isNative = response instanceof ArrowBatchResponse;
        if (!open.get() || cancelled || terminalSent) {  
        releaseUnsentSource(response);
 * until gRPC's outbound buffer drains below {@code setOnReadyThreshold}.
    private void onChannelCancelled() {  
    private final long correlationId;
        // executor via release, or producer bootstrap) or interleaving.  
                removableCloseListeners.add(listener);
        synchronized (closeListenerMutex) {
                throw StreamException.cancelled("stream cancelled while waiting for consumer");
import org.opensearch.arrow.flight.stats.FlightCallTracker;
    private final AtomicBoolean open = new AtomicBoolean(true);
 * The only cross-thread state is the close-listener list, guarded by a small leaf mutex  
     * Completes the streaming response. <b>Must run on the flight executor thread.</b> Terminal and
     */
    }
     * Sends a terminal error to the consumer. <b>Must run on the flight executor thread.</b> Terminal
            }
        try {  
    private final Object closeListenerMutex = new Object();
        if (response instanceof ArrowBatchResponse arrowResponse) {
 *
                new ParameterizedMessage(  
        VectorStreamOutput out = VectorStreamOutput.create(allocator, root);
            // reclaimed by the OS on process exit (documented limitation, channel-lifecycle-ownership
        this.bp = new CompositeBackpressureStrategy(this::onChannelCancelled);
    /**  
     * under a slow consumer. If the action handler is registered on a bounded thread
                    root = null;  
    @Override
    private final FlightCallTracker callTracker;
            if (firstBatch && !adopted) {
     * single-threaded executor and are serialized by it. The header is built before any root is
    }
 * The OpenSearch Contributors require contributions made to  
        }  
            logger.debug("Error in Flight stream: {}", error.getMessage());
        if (error instanceof OpenSearchException) {
                    rootSize,
            // Only the first-batch output owns a freshly-allocated vector; on reuse the output wraps the
import java.util.concurrent.atomic.AtomicBoolean;
                "sendError is a no-op (open={}, cancelled={}, terminalSent={}) for correlation ID: {}",
        } else {
import static org.opensearch.arrow.flight.transport.FlightErrorMapper.mapFromCallStatus;  
 * safe by confining the stream root to that single thread:
        this.serverStreamListener.setUseZeroCopy(true);  
            if (isNative && sourceRoot != null) {
        }  
        return true;
     *  
     * @param headerSupplier builds the response header
    @Override
            logger.debug(
     * then already done). Does not free the stream root — that is deferred to {@link #close()}.
    /**
                transferIntoStreamRoot(sourceRoot, firstBatch);  
import org.apache.logging.log4j.Logger;
     *  
            }  
            logger.debug(
                cancelled,
        logger.debug("Sending error for correlation ID: {} after {} batches: {}", correlationId, batchNumber, error.getMessage());  
import org.apache.arrow.flight.BackpressureStrategy;
        long readyTimeoutMillis
        }
            case READY:
 * <ul>
            // Executor shut down (node shutdown): the posted free will not run, so the stream root is
    }
                middleware.setHeader(header);
            if (alreadyFired == false) {
        }
        // it. Isolate each listener so one failure cannot strand the rest (e.g. the TaskManager untrack
            VectorSchemaRoot created = VectorSchemaRoot.create(sourceRoot.getSchema(), fieldVectors.getFirst().getAllocator());
}  
        // mutates the list.  
            // use-after-free this single-writer model exists to prevent. Logged at WARN so the  
                    "Batch #{} sent for correlation ID: {}, size: {} bytes, putNext: {}ms",
        // CompositeBackpressureStrategy.register installs both setOnReadyHandler and
    }  
import org.opensearch.arrow.transport.VectorTransfer;  
    }
    @Override
 * (create/transfer/serialize/free), {@link #terminalSent}, and every {@code serverStreamListener} call
    /** Whether a terminal gRPC op ({@code completed()} XOR {@code error()}) was issued. Flight-executor confined. */
            case TIMEOUT:  
            );
            // §10). We deliberately do NOT free inline: a rejection from ExecutorService.shutdown()  
        synchronized (closeListenerMutex) {
    private final ServerStreamListener serverStreamListener;
    ) {
 *       {@code close()} never touches Arrow buffers or gRPC from the caller's thread, so it cannot
     * mutated, so a header-serialization failure fails fast (the source is freed by the {@code finally})  
            }
    @Override  
                    "flight executor rejected stream-root release for correlation ID: {}; root reclaimed at process exit",
     * the reused {@code VarBinary} stream root. The stream root itself is freed once, at {@link #close()}
                }
    public void addConnectListener(ActionListener<Void> listener) {
            logger.debug("Completing stream for correlation ID: {} after {} batches", correlationId, batchNumber);  
                if (!adopted) {  
        final List<ActionListener<Void>> toFire;  
        if (alreadyFired) {
import org.opensearch.OpenSearchException;  
     */
    /**
import java.net.InetAddress;
     * Parks the calling thread until gRPC signals it can accept another batch. Called
            final boolean firstBatch = (root == null);
            // on the executor thread, so freeing from this (possibly gRPC) thread would reintroduce the
                listener.onResponse(null);
                closeListeners.add(listener);
    }
        // notifying parked threads so the cancelled state is visible on wake.
        // freed there). Post the free onto that executor so it is serialized behind any in-flight send
        this.correlationId = Long.parseLong(middleware.getCorrelationId());  
    /**
                if (root != null) {
    }  
    private volatile boolean cancelled = false;  
    @Override
        }
                .withDescription(error.getMessage() != null ? error.getMessage() : "Stream error")  
 * concurrently from more than one thread.</b> The executor is single-threaded, so it serializes those  
 *       via {@code release()}, or producer bootstrap). It is a <em>signal</em>, not a buffer  
            logger.warn(
    private static final String PROFILE_NAME = "flight";
 * mutations and the buffer frees among themselves. Violating this (e.g. mutating the root from a
     * idempotent: a no-op if the channel is already closed, cancelled, or terminal. Does not free the
                logger.warn(new ParameterizedMessage("close listener failed for correlation ID: {}", correlationId), e);
                    out.close();  
                throw StreamException.cancelled("Cannot flush more batches. Stream cancelled by the client");
                throw new IllegalStateException("FlightServerChannel already closed.");
        }
                root = created;  
                );  
        // listener).
            callTracker.recordCallEnd(StreamErrorCode.CANCELLED.name());  
 * every Arrow buffer it sends and of the gRPC stream lifecycle.
    /** Returns the current stream root. Package-private; intended for tests/assertions only. */
                logger.debug(  
        final byte[] metadata = isNative ? ((ArrowBatchResponse) response).getMetadata() : null;
            if (callTracker != null) {  
    private final InetSocketAddress localAddress;
        // setOnCancelHandler; the cancel callback runs onChannelCancelled before  
    private final Logger logger = LogManager.getLogger(FlightServerChannel.class);
        }
    private final ServerHeaderMiddleware middleware;
            closeListeners.clear();
    }  
import org.opensearch.arrow.transport.ArrowBatchResponse;
    @Override  
        // The stream root is owned exclusively by the flight-executor thread (created, filled, and
        this.remoteAddress = new InetSocketAddress(InetAddress.getLoopbackAddress(), 0);
                throw new StreamException(StreamErrorCode.INTERNAL, "unexpected back-pressure wait result: " + result);
    }
     * type and no instance is available. Frees the native source root of an unsent batch; no-op for the  
            );
            }  
import org.apache.logging.log4j.message.ParameterizedMessage;
                    batchNumber,
                logger.warn("unexpected back-pressure wait result: {}", result);  
 */  
 *       single-threaded flight executor</b> ({@link #getExecutor()}). The executor serializes batch
    }
     */  
    }  
    private void serializeIntoStreamRoot(TransportResponse response, boolean firstBatch) throws IOException {  
            );
    /**
        this.callTracker = callTracker;  
            batchNumber.incrementAndGet();
    @Override
    @Override
import org.opensearch.common.CheckedSupplier;
                    // best-effort cleanup of the un-adopted first-batch vector
     * pool (e.g. {@code SEARCH}), N concurrent slow streams will hold N threads parked  
            try {
                } catch (IOException ignore) {
            if (!open.get()) {  
        // fired and we fire immediately. Never both, never neither. The mutex's critical section only
                long rootSize = FlightUtils.calculateVectorSchemaRootSize(root);
    }  
     */
            }
     * {@link #root}, so {@link #close()} would not free it). Flight-executor confined.  
        final List<BiConsumer<Void, ? super Exception>> removableToFire;
 *       race an in-flight {@code putNext} and never blocks the cancel thread.</li>
import java.net.InetSocketAddress;
            } catch (Exception e) {  
        return cancelled;
                    putNextTime
     * — never per batch — to preserve gRPC's zero-copy retention window.
                cancelled,
 *   <li>A native source root is freed exactly once by {@link #sendBatch} (in a {@code finally} on  
 * — MUST run on the channel's single {@link #getExecutor() flight-executor thread}, and never
    VectorSchemaRoot getRoot() {  
                terminalSent,
        // Snapshot+mark-fired under the leaf mutex so a concurrent addCloseListener cannot be lost or
        ServerHeaderMiddleware middleware,
            }
     * and idempotent: a no-op if the channel is already closed, cancelled, or terminal (the consumer is  
     * if serialization fails before the channel adopts the freshly-created root, the output's vector is  
        return new ChannelStats(); // TODO: Implement stats. Add custom stats as needed  
 * compatible open source license.
                serverStreamListener.start(root);
    public boolean isServerChannel() {
     * the {@code finally}). For any other response (byte-serialized path) the response is written into  
     * by {@link FlightOutboundHandler}). The channel takes ownership of the response's buffers and is
        }
        ServerStreamListener serverStreamListener,
        return open.get();
     * <p><b>Warning:</b> the calling thread may park for up to {@code readyTimeoutMillis}
     * Native path: zero-copy transfers {@code sourceRoot}'s vectors into the reused stream root,  
                out.reset();
        }  
 * TcpChannel implementation for Arrow Flight. Created per call in {@link ArrowFlightProducer}.  
        terminalSent = true;
    @Override
        if (alreadyFired) {
            if (isNative) {
        }
import java.util.concurrent.ExecutorService;  
     * failed hand-off it is freed here — the mutually-exclusive counterpart to {@link #sendBatch}'s own  
    private final BufferAllocator allocator;  
    private volatile VectorSchemaRoot root = null;  
     */
            return;
    /**  
     * freed here so it cannot leak. Flight-executor confined.
     * Gets the executor for this channel
