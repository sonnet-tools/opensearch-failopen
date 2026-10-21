    public void close() {
                    root = null;
            throw StreamException.cancelled("stream cancelled before back-pressure wait");
        synchronized (closeListenerMutex) {
        this.middleware = middleware;
            try {
 *       sends, {@code completeStream}/{@code sendError}, and the root free among themselves, so none
     * The reused stream root (native or byte-serialized). Confined to the flight-executor thread:
                logger.debug(
 * </ul>
                middleware.setHeader(header);
     * <p><b>Warning:</b> the calling thread may park for up to {@code readyTimeoutMillis}
        return true;
    public void sendMessage(BytesReference reference, ActionListener<Void> listener) {
            } else {
    private final Object closeListenerMutex = new Object();
    }
            cancelled = true;
    private final long correlationId;
            long putNextTime = (System.nanoTime() - batchStartTime) / 1_000_000;
            }
            boolean adopted = false;
    private final ExecutorService executor;
            // still holds its buffers (close frees them).
                long rootSize = FlightUtils.calculateVectorSchemaRootSize(root);
        VectorStreamOutput out = VectorStreamOutput.create(allocator, root);
        this.remoteAddress = new InetSocketAddress(InetAddress.getLoopbackAddress(), 0);
            logger.debug(
    private static final String PROFILE_NAME = "flight";
            VectorTransfer.transferRoot(sourceRoot, root);
            default:
     */
    /**
            // (the source root is still freed by the finally) without adopting a stream root.
 * The only cross-thread state is the close-listener list, guarded by a small leaf mutex
            // Only the first-batch output owns a freshly-allocated vector; on reuse the output wraps the
    /**
    /**
            logger.debug("Completing stream for correlation ID: {} after {} batches", correlationId, batchNumber);
 *       operation: it flips {@link #open} exactly once via {@code compareAndSet}, fires close
                listener.accept(null, null);
 * compatible open source license.
    /**
    public ExecutorService getExecutor() {
 * TcpChannel implementation for Arrow Flight. Created per call in {@link ArrowFlightProducer}.
            response.writeTo(out);
        } else {
    private void notifyCloseListeners() {
        boolean alreadyFired;
                adopted = true;
        synchronized (closeListenerMutex) {
            if (!alreadyFired) {
    }
     * type and no instance is available. Frees the native source root of an unsent batch; no-op for the
     */
import java.util.concurrent.RejectedExecutionException;
        }
     * by {@link FlightOutboundHandler}). The channel takes ownership of the response's buffers and is
                return;
        switch (result) {
    /**
        return root;
                transferIntoStreamRoot(sourceRoot, firstBatch);
    private final AtomicInteger batchNumber = new AtomicInteger(0);
    /** Leaf mutex guarding {@link #closeListeners} and {@link #closeListenersFired}; its critical section only mutates them. */
        try {
                    out.close();
    private final CompositeBackpressureStrategy bp;
        return executor;
    }
 */
 * The OpenSearch Contributors require contributions made to
 * concurrently from more than one thread.</b> The executor is single-threaded, so it serializes those
     * (the back-pressure gate threw, the executor rejected the task, or the channel was the wrong
 *       every exit), or by {@link #releaseUnsent} when the batch never reached {@code sendBatch}.</li>
     * — never per batch — to preserve gRPC's zero-copy retention window.
     */
 *
            if (isNative) {
            listener.accept(null, null);
                    rootSize,
    @Override
import org.opensearch.arrow.transport.VectorTransfer;
            try {
        if (!cancelled) {
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.transport.stream.StreamException;
import org.opensearch.transport.TcpChannel;
                e
import org.opensearch.core.transport.TransportResponse;
     * creating it on the first batch and clearing it for reuse on later batches. On the first batch,
                }
     * {@code finally}. No-op for the byte-serialized path (no off-heap source root).
        listener.onFailure(new UnsupportedOperationException("FlightServerChannel does not support BytesReference based sendMessage()"));
        } finally {
        // listener).
 *       FIFO and single-threaded, that free runs only after any in-flight send completes.
    }
            logger.error("Unexpected error in Flight stream", error);
    }
import org.apache.arrow.memory.ArrowBuf;
        if (error instanceof OpenSearchException) {
                root = created;
            if (metadata != null) {
        return remoteAddress;
     * Sends one streaming batch. <b>Must run on the flight executor thread</b> (it is dispatched there
     * sees a consistent reference; correctness relies on executor confinement, not on volatility.
     * freed here so it cannot leak. Flight-executor confined.
        // Assume Arrow Flight is connected
            case READY:
            );
            if (cancelled) {
        for (BiConsumer<Void, ? super Exception> listener : removableToFire) {
     *
                metadataBuf.writeBytes(metadata);
    @Override
            VectorSchemaRoot sourceRoot = arrowResponse.getRoot();
                );
     *
class FlightServerChannel implements TcpChannel, ArrowFlightChannel {
        } catch (RejectedExecutionException e) {
        if (!open.get() || cancelled || terminalSent) {
        }
    @Override
     */
 * producer threads call {@link #awaitReadyOrThrow()} before a batch is submitted and park
                serializeIntoStreamRoot(response, firstBatch);
        }
            }
        }
            // exit: after a successful transfer it is empty (close is a no-op); on any early throw it
        }
                } catch (Throwable t) {
        logger.debug("Sending error for correlation ID: {} after {} batches: {}", correlationId, batchNumber, error.getMessage());
            middleware.setHeader(header);
import java.util.ArrayList;
    public FlightServerChannel(
        // CompositeBackpressureStrategy.register installs both setOnReadyHandler and
                sourceRoot.close();
        final boolean isNative = response instanceof ArrowBatchResponse;
        }
                .toRuntimeException();
 *       {@code close()} never touches Arrow buffers or gRPC from the caller's thread, so it cannot
                throw new StreamException(StreamErrorCode.INTERNAL, "unexpected back-pressure wait result: " + result);
import org.apache.logging.log4j.LogManager;
import java.nio.ByteBuffer;
            // allocator must be long-lived (not closed per-request).
            close();
            List<FieldVector> fieldVectors = sourceRoot.getFieldVectors();
    @Override
            final boolean firstBatch = (root == null);
import org.apache.arrow.vector.FieldVector;
    /**
            }
                if (!adopted) {
    }
     * from the producer thread before the batch is submitted to the channel's executor.
    public void awaitReadyOrThrow() {
import java.util.List;
    private final InetSocketAddress localAddress;
        // Fire-once: exactly one caller wins the CAS, regardless of thread (gRPC cancel, the flight
import org.opensearch.core.common.bytes.BytesReference;
    public void sendError(ByteBuffer header, Exception error) {
     * single-threaded executor and are serialized by it. The header is built before any root is
            if (firstBatch && !adopted) {
 * <p><b>Invariant: this channel is NOT thread-safe. All send-side mutation — the stream {@link #root}
     * into the reused stream root and the producer root is freed here exactly once (on every exit, via
            listener.onResponse(null);
    VectorSchemaRoot getRoot() {
     * the {@code finally}). For any other response (byte-serialized path) the response is written into
    @Override
            // means new tasks are refused while an already-running send may still be touching the root
            closeListenersFired = true;
    public void completeStream(ByteBuffer header) {
                }
            );
 * every Arrow buffer it sends and of the gRPC stream lifecycle.
    public void removeCloseListener(BiConsumer<Void, ? super Exception> listener) {
    private void transferIntoStreamRoot(VectorSchemaRoot sourceRoot, boolean firstBatch) {
    public InetSocketAddress getLocalAddress() {
        final VectorSchemaRoot sourceRoot = isNative ? ((ArrowBatchResponse) response).getRoot() : null;
        try {
     * if serialization fails before the channel adopts the freshly-created root, the output's vector is
        this.executor = executor;
    private final Logger logger = LogManager.getLogger(FlightServerChannel.class);
 * producer thread while {@code close()} frees it on the executor) is a data race that corrupts Arrow
import org.apache.arrow.memory.BufferAllocator;
        // mutates the list.
        }
import org.apache.logging.log4j.Logger;
    private boolean terminalSent = false;
     * the sole place they are transferred onto the wire and freed.
            // §10). We deliberately do NOT free inline: a rejection from ExecutorService.shutdown()
import org.opensearch.core.action.ActionListener;
                    "Batch #{} sent for correlation ID: {}, size: {} bytes, putNext: {}ms",
        }
        // setOnCancelHandler; the cancel callback runs onChannelCancelled before
                serverStreamListener.putNext();
    }
     * pool — or limit concurrent streams via admission control — accordingly.
    }
        return open.get();
                    correlationId
            if (isNative && sourceRoot != null) {
import org.opensearch.arrow.transport.ArrowBatchResponse;
    public void addConnectListener(ActionListener<Void> listener) {
                callTracker.recordBatchSent(rootSize, System.nanoTime() - batchStartTime);
    private final BufferAllocator allocator;
     * <p>For an {@link ArrowBatchResponse} (native path) the producer's root is zero-copy transferred
            return;
        this.serverStreamListener = serverStreamListener;
        }
        if (error instanceof FlightRuntimeException fre) {
     * Completes the streaming response. <b>Must run on the flight executor thread.</b> Terminal and
            final ByteBuffer header = headerSupplier.get();
    }
        }
            } catch (Exception e) {
 * (create/transfer/serialize/free), {@link #terminalSent}, and every {@code serverStreamListener} call
     * byte-serialized path (no off-heap source root).
    public boolean isServerChannel() {
import org.apache.logging.log4j.message.ParameterizedMessage;
     * Native path: zero-copy transfers {@code sourceRoot}'s vectors into the reused stream root,
        synchronized (closeListenerMutex) {
 * until gRPC's outbound buffer drains below {@code setOnReadyThreshold}.
     *
        // thread.
        }
     * type). The channel owns the source root from the moment the producer enqueues the batch, so on a
        }
    private final FlightCallTracker callTracker;
            }
    @Override
                    if (metadataBuf.refCnt() > 0) {
 *
            }
            removableToFire = new ArrayList<>(removableCloseListeners);
                throw new IllegalStateException("FlightServerChannel already closed.");
        // The stream root is owned exclusively by the flight-executor thread (created, filled, and
                    serverStreamListener.putNext(metadataBuf);
        callTracker.recordCallEnd(StreamErrorCode.OK.name());
        }
        this.callTracker = callTracker;
            if (!firstBatch) {
                    // best-effort cleanup of the un-adopted first-batch vector
                    batchNumber,
     *
        if (alreadyFired) {
    /**
     * stream root — that is deferred to {@link #close()} to preserve gRPC's zero-copy retention window.
            }
        } else {
                new ParameterizedMessage(
                    created.close();
            toFire = new ArrayList<>(closeListeners);
     * <p>This method, the terminal ops, and the {@link #close()} root-free all run on the
        // it. Isolate each listener so one failure cannot strand the rest (e.g. the TaskManager untrack
    }
    }
            // buffers (from C data import) does not properly free the ArrowArray C struct. The producer's
     * @throws IOException if header serialization or byte-path serialization fails
    public BufferAllocator getAllocator() {
            // Create using the producer's allocator: cross-allocator transferOwnership of foreign-backed
            try {
            executor.execute(() -> {
     * Gets the executor for this channel
        middleware.setHeader(header);
        synchronized (closeListenerMutex) {
        }
     */
        this.readyTimeoutMillis = readyTimeoutMillis;
    public boolean isCancelled() {
                "sendError is a no-op (open={}, cancelled={}, terminalSent={}) for correlation ID: {}",
     * Parks the calling thread until gRPC signals it can accept another batch. Called
        this.correlationId = Long.parseLong(middleware.getCorrelationId());
        }
     * mutated, so a header-serialization failure fails fast (the source is freed by the {@code finally})
        for (ActionListener<Void> listener : toFire) {
            closeListeners.clear();
 *
        // freed there). Post the free onto that executor so it is serialized behind any in-flight send
                    }
                open.get(),
        // fired and we fire immediately. Never both, never neither. The mutex's critical section only
        return allocator;
                } catch (IOException ignore) {
 * this file be licensed under the Apache-2.0 license or a
    static void releaseUnsentSource(TransportResponse response) {
        // Register atomically against notifyCloseListeners under the leaf mutex: either the listeners
        }
 * <p>The producer must invoke {@link #sendBatch} serially and finish with {@link #completeStream}
        }
                correlationId
                logger.warn(new ParameterizedMessage("close listener failed for correlation ID: {}", correlationId), e);
        }
        if (firstBatch) {
        boolean alreadyFired;
                terminalSent,
    public void sendBatch(TransportResponse response, CheckedSupplier<ByteBuffer, IOException> headerSupplier) throws IOException {
    }
 * <p><b>Ownership &amp; concurrency — single-writer model.</b> This channel is the sole owner of
    }
     * under a slow consumer. If the action handler is registered on a bounded thread
        } finally {
    private volatile VectorSchemaRoot root = null;
        if (!open.compareAndSet(true, false)) {
            removableCloseListeners.clear();
     * then already done). Does not free the stream root — that is deferred to {@link #close()}.
import org.opensearch.transport.stream.StreamErrorCode;
 * SPDX-License-Identifier: Apache-2.0
            if (alreadyFired == false) {
        this.bp = new CompositeBackpressureStrategy(this::onChannelCancelled);
    }
 * (success) or {@link #sendError} (failure).
        ServerHeaderMiddleware middleware,
            } finally {
            // The native source root is exclusively owned by this call. Free it exactly once on every
            }
    }
        long readyTimeoutMillis
     * @param error the error to send
    private final InetSocketAddress remoteAddress;
     * @param response the batch to send; the channel takes ownership of its buffers
                logger.warn(new ParameterizedMessage("close listener failed for correlation ID: {}", correlationId), e);
                "completeStream is a no-op (open={}, cancelled={}, terminalSent={}) for correlation ID: {}",
 *   <li>A native source root is freed exactly once by {@link #sendBatch} (in a {@code finally} on
            removableCloseListeners.remove(listener);
    private final List<BiConsumer<Void, ? super Exception>> removableCloseListeners = new ArrayList<>();
        }
            }
     * {@link #root}, so {@link #close()} would not free it). Flight-executor confined.
     *
        BackpressureStrategy.WaitResult result = bp.waitForListener(readyTimeoutMillis);
        FlightCallTracker callTracker,
    private void onChannelCancelled() {
        if (response instanceof ArrowBatchResponse arrowResponse) {
     * failed hand-off it is freed here — the mutually-exclusive counterpart to {@link #sendBatch}'s own
    private final List<ActionListener<Void>> closeListeners = new ArrayList<>();
            logger.debug(
     * Sends a terminal error to the consumer. <b>Must run on the flight executor thread.</b> Terminal
            // Executor shut down (node shutdown): the posted free will not run, so the stream root is
     *         {@link StreamErrorCode#CANCELLED} if the client cancelled.
 *       single-threaded flight executor</b> ({@link #getExecutor()}). The executor serializes batch
import org.apache.arrow.flight.BackpressureStrategy;
            } else {
            // channel-owned root, which close() frees.
            });
        boolean adopted = false;
            alreadyFired = closeListenersFired;
        final byte[] metadata = isNative ? ((ArrowBatchResponse) response).getMetadata() : null;
            case CANCELLED:
/**
    /** Whether a terminal gRPC op ({@code completed()} XOR {@code error()}) was issued. Flight-executor confined. */
     * the reused {@code VarBinary} stream root. The stream root itself is freed once, at {@link #close()}
    @Override
    @Override
     * created, filled, and freed only there. {@code volatile} so the test-only {@link #getRoot()}
                logger.warn("unexpected back-pressure wait result: {}", result);
            // on the executor thread, so freeing from this (possibly gRPC) thread would reintroduce the
        terminalSent = true;
            case TIMEOUT:
     *
            // Build the header before mutating any root so a header-serialization failure fails fast
    }
     * @param headerSupplier builds the response header
            logger.debug("Error in Flight stream: {}", error.getMessage());
        this.localAddress = new InetSocketAddress(InetAddress.getLoopbackAddress(), 0);
            VectorSchemaRoot created = VectorSchemaRoot.create(sourceRoot.getSchema(), fieldVectors.getFirst().getAllocator());
                throw StreamException.cancelled("stream cancelled while waiting for consumer");
import org.apache.arrow.flight.CallStatus;
}
    public void addCloseListener(ActionListener<Void> listener) {
    private final AtomicBoolean open = new AtomicBoolean(true);
                        metadataBuf.close();
            return;
 * mutations and the buffer frees among themselves. Violating this (e.g. mutating the root from a
                    throw t;
            alreadyFired = closeListenersFired;
import org.opensearch.common.CheckedSupplier;
 *   <li>{@link #close()} may be called from any thread (the gRPC cancel callback, the flight executor
import org.apache.arrow.flight.FlightProducer.ServerStreamListener;
import java.net.InetAddress;
            logger.warn(
    private final ServerHeaderMiddleware middleware;
    private volatile boolean cancelled = false;
     * pool (e.g. {@code SEARCH}), N concurrent slow streams will hold N threads parked
        return localAddress;
        listener.onResponse(null);
            final long batchStartTime = System.nanoTime();
    public void addCloseListener(BiConsumer<Void, ? super Exception> listener) {
    }
                closeListeners.add(listener);
 * <ul>
            logger.debug("Completing empty stream for correlation ID: {}", correlationId);
     * simultaneously and can starve the pool. Operators should size the action's thread
     */
    }
/*
                // only if putNext never adopted it.
import java.io.IOException;
                cancelled,
            root = out.getRoot();
    @Override
        try {
                try {
import java.util.concurrent.atomic.AtomicInteger;
        if (alreadyFired) {
        this.bp.register(serverStreamListener);
        return cancelled;
        }
        serverStreamListener.error(flightExc);
                    root.close();
                cancelled,
            flightExc = CallStatus.INTERNAL.withCause(error)
    ) {
    }
            }
    private void serializeIntoStreamRoot(TransportResponse response, boolean firstBatch) throws IOException {
    private boolean closeListenersFired = false;
                sourceRoot.close();
            flightExc = fre;
    }
     */
            }
        if (cancelled) {
        }
    public String getProfile() {
     * Frees the source buffers of a batch that was built but never handed to {@link #sendBatch}
            }
        this.serverStreamListener.setUseZeroCopy(true);
 *
                VectorTransfer.transferRoot(sourceRoot, created);
import java.util.concurrent.ExecutorService;
                listener.onResponse(null);
                out.reset();
            // reclaimed by the OS on process exit (documented limitation, channel-lifecycle-ownership
import java.util.function.BiConsumer;
    /** Returns the current stream root. Package-private; intended for tests/assertions only. */
 * {@code docs/channel-lifecycle-ownership.md} for the full contract.
    private final ServerStreamListener serverStreamListener;
import org.apache.arrow.vector.VectorSchemaRoot;
    }
                }
        final List<ActionListener<Void>> toFire;
 */
        // notifying parked threads so the cancelled state is visible on wake.
        releaseUnsentSource(response);
import org.apache.arrow.flight.FlightRuntimeException;
 *       can interleave.</li>
            logger.debug("Sending batch #{} for correlation ID: {}", batchNumber, correlationId);
                ),
 *   <li><b>The stream {@link #root} and every {@code serverStreamListener} call
        if (!open.get() || cancelled || terminalSent) {
        terminalSent = true;
 * safe by confining the stream root to that single thread:
                removableCloseListeners.add(listener);
                    correlationId,
            } catch (Exception e) {
        FlightRuntimeException flightExc;
            if (fieldVectors.isEmpty()) {
import static org.opensearch.arrow.flight.transport.FlightErrorMapper.mapFromCallStatus;
 *       race an in-flight {@code putNext} and never blocks the cancel thread.</li>
 * ({@link #closeListenerMutex}) whose critical section only mutates that list. See
     */
                try {
package org.opensearch.arrow.flight.transport;
    }
        // Registered against notifyCloseListeners exactly like addCloseListener(ActionListener), see there.
        // by the executor's own FIFO ordering; we never touch Arrow buffers from this (possibly gRPC)
 *       listeners, and <b>posts the root free onto the flight executor</b>. Because the executor is
     * creating it on the first batch. On the first batch, if transfer fails before the channel adopts
                }
    }
            }
        // double-fired, then fire outside the mutex so foreign listener code never runs while we hold
 * — MUST run on the channel's single {@link #getExecutor() flight-executor thread}, and never
    private final long readyTimeoutMillis;
                open.get(),
            } else {
        final List<BiConsumer<Void, ? super Exception>> removableToFire;
            if (!open.get()) {
            // Set header if no batches were sent
                serverStreamListener.start(root);
                // Flight takes ownership of metadataBuf via putNext(ArrowBuf); free it ourselves
        }
            }
import org.opensearch.OpenSearchException;
 *
                ArrowBuf metadataBuf = allocator.buffer(metadata.length);
        // have not fired yet and we enqueue (notifyCloseListeners will fire it), or they have already
                if (root != null) {
        if (root == null) {
    @Override
    }
                    "flight executor rejected stream-root release for correlation ID: {}; root reclaimed at process exit",
 * reference counts and can orphan or double-free buffers (an off-heap leak). It keeps that ownership
     * idempotent: a no-op if the channel is already closed, cancelled, or terminal. Does not free the
    public void releaseUnsent(TransportResponse response) {
            return;
                .withDescription(error.getMessage() != null ? error.getMessage() : "Stream error")
        ExecutorService executor,
        // Snapshot+mark-fired under the leaf mutex so a concurrent addCloseListener cannot be lost or
        notifyCloseListeners();
            // shutdown-time leak is visible rather than buried.
            if (sourceRoot != null) {
    /**
                throw new IllegalStateException("Native Arrow batch has no field vectors");
        return PROFILE_NAME;
 * <p>Honours gRPC's {@code isReady()} contract via {@link CompositeBackpressureStrategy}:
            // use-after-free this single-writer model exists to prevent. Logged at WARN so the
    /** Idempotent cleanup invoked from the strategy when gRPC fires {@code OnCancelHandler}. */
     */
 *       via {@code release()}, or producer bootstrap). It is a <em>signal</em>, not a buffer
     *         remains not-ready longer than {@code readyTimeoutMillis}, or
        } else {
    }
    public InetSocketAddress getRemoteAddress() {
import org.opensearch.arrow.flight.stats.FlightCallTracker;
            adopted = true;
    @Override
        logger.debug("Creating FlightServerChannel for correlation ID: {}", correlationId);
        return new ChannelStats(); // TODO: Implement stats. Add custom stats as needed
        // executor via release, or producer bootstrap) or interleaving.
     * @throws StreamException with {@link StreamErrorCode#TIMED_OUT} if the consumer
            }
     */
     * Byte-serialized path: writes {@code response} into the reused {@code VarBinary} stream root,
                correlationId
                throw StreamException.cancelled("Cannot flush more batches. Stream cancelled by the client");
            if (firstBatch) {
            );
            callTracker.recordCallEnd(StreamErrorCode.CANCELLED.name());
            if (callTracker != null) {
     * Static variant of {@link #releaseUnsent} for the defensive path where the channel is the wrong
            batchNumber.incrementAndGet();
 *       ({@code start}/{@code putNext}/{@code completed}/{@code error}) happen only on the channel's
        this.allocator = allocator;
     * and idempotent: a no-op if the channel is already closed, cancelled, or terminal (the consumer is
        serverStreamListener.completed();
    }
     * the freshly-created root, that root is freed here so it cannot leak (it has not yet become
                    putNextTime
    /**
    /** Whether the client cancelled the gRPC stream (onChannelCancelled fired). Read by FlightTransportChannel. */
        callTracker.recordCallEnd(mapFromCallStatus(flightExc).name());
import java.net.InetSocketAddress;
                logger.debug("Batch #{} sent for correlation ID: {}, putNext: {}ms", batchNumber, correlationId, putNextTime);
            }
            }
    @Override
     * without adopting a stream root.
                terminalSent,
        } else {
    public ChannelStats getChannelStats() {
    }
        ServerStreamListener serverStreamListener,
        BufferAllocator allocator,
    public boolean isOpen() {
    /**
                throw new StreamException(StreamErrorCode.TIMED_OUT, "consumer not ready after " + readyTimeoutMillis + "ms");
