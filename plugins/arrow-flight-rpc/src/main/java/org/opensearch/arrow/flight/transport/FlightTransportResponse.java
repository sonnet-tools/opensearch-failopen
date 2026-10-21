import org.opensearch.ExceptionsHelper;
        TransportResponseHandler<T> handler,
        this.onClosed = onClosed;
        if (flightStream != null || prefetchCompleted) {
 * compatible open source license.
            return streamReleased;
    private volatile boolean prefetchCompleted;
     * <p>If the stream has not been published yet (open/prefetch still in flight, or never started),
    Releasable markDispatchThread() {
    private final long correlationId;
    void setOnClosed(Runnable onClosed) {
import org.apache.logging.log4j.Logger;
                            // channel waiting on stream shutdown does not proceed while they may
        return currentBatchSize;
    /**
     * same stream (they write {@code flightStream} and {@code closed} in opposite orders, so each
    public void cancel(String reason, Throwable cause) {
     */
        if (closed) return;
     * {@link FlightStream#close()}.
        this.config = Objects.requireNonNull(config);
    private final FlightClient flightClient;
    public T nextResponse() {
        buf.getBytes(0, copy);
import org.apache.arrow.flight.FlightClient;
            // we copy off so the response can outlive the stream cursor.
                    logger.debug("FlightClient.getStream() for correlationId: {} took {}ms", correlationId, elapsedMs);
    private boolean streamCloseAttempted;
            if (flightStream != null) flightStream.cancel(reason, cause);
     * any thread: {@link FlightStream#cancel} unblocks a consumer parked in {@link #nextResponse()}
            boolean hasNext = firstBatchConsumed ? flightStream.next() : (firstBatchConsumed = true);
    }
        }
     */
        if (prefetchStarted) return;
        synchronized (this) {
            // Stream published (release it), or the prefetch finished without publishing one
import org.apache.arrow.flight.HeaderCallOption;
        // else: the prefetch is still in flight; its closed re-check sees closed == true and
                    streamReleased = true;
        FlightClient flightClient,
    private final HeaderContext headerContext;
    private final FlightCallHeaders callHeaders;
        try {
        NamedWriteableRegistry namedWriteableRegistry,
            throw new StreamException(StreamErrorCode.INTERNAL, "Failed to deserialize batch", e);
     * because the stream can only be released once the callback it is executing returns.
            // (getStream failed — nothing to release). Notify only once the buffers are known to be
    }
     * may observe the other's write). Blocking the loser rather than letting it return early is
        if (hadPrefetch == false) {
    }
     * completed — including when another thread is the one performing it. That makes a normal
    void afterStreamPublished() {}
        } catch (Exception e) {
            return;
                } finally {
        return isNativeHandler
                            // Notify only once the stream's buffers are actually released, so a
    /**
        }
    private volatile Header initialHeader;
        synchronized (streamCloseLock) {
    private final FlightTransportConfig config;
    /** Ensures {@link #onClosed} runs exactly once. */
            closed = true;
            if (closed) {
     * {@link #releaseStream()} first. No-op in production; overridden by tests that need to force
                future.completeExceptionally(new StreamException(StreamErrorCode.UNAVAILABLE, "Stream is closed"));
    private final AtomicBoolean closeNotified = new AtomicBoolean();
    /** Guarded by {@link #streamCloseLock}: set when the stream's buffers are known to be released. */
    }
                    // so once the future completes, any subsequent close() always observes flightStream != null
            logFailure("Error cancelling flight stream", e);
    /** Runs the {@link #onClosed} callback exactly once, if set. */
    }
     * Copies an Arrow Flight metadata buffer into a {@code byte[]} the consumer owns, or
     * Notified exactly once, after the underlying flight stream (if any) has been closed and its
     * extended stack-trace renderer, which can stall the virtual-thread scheduler under a mass stream failure.
        FlightStream stream = flightStream;
            long took = System.currentTimeMillis() - startTime;
            stream.cancel(reason, null);
        byte[] copy = new byte[len];
     */
                    // second caller until that close has completed.
        this.flightClient = Objects.requireNonNull(flightClient);
                    // and owns the close itself.
            if (prefetchStarted) return;
     *
    }
                try {
                }
        assert closed == false : "onClosed callback must be set before the response is closed";
        int len = (int) buf.readableBytes();
     * (it observes a CANCELLED error), and that consumer remains responsible for {@link #close()}.
        return correlationId;
                    future.complete(initialHeader);
        if (buf == null || buf.readableBytes() == 0) return null;
     * Test seam, invoked after the stream is published and before the closed re-check below it —
    private boolean streamReleased;
     */
     * the window in which a concurrent {@link #close()} can observe the published stream and reach
    private byte[] readMetadata() {
import java.util.concurrent.CompletableFuture;
            close();
            logger.trace("{} for correlationId [{}]: {}", message, correlationId, ExceptionsHelper.stackTrace(cause));
        }
                    streamReleased = true;
    }
                    // close() may have run while we were inside getStream() and missed the stream because
 * Streaming transport response implementation using Arrow Flight.
    /** Guarded by {@link #streamCloseLock}: set once a thread has entered {@code FlightStream#close}. */
     * Marks the calling thread as the one executing the consumer's stream callback, and returns a
     * callback is in progress. A closer running on this thread cannot wait for this stream to be
                        future.completeExceptionally(new StreamException(StreamErrorCode.UNAVAILABLE, "Stream is closed"));
                notifyClosed();
    private volatile boolean closed;
        if (stream == null) {
import org.apache.arrow.flight.FlightRuntimeException;
        } finally {
     * what prevents it from reporting the stream released while the winner is still inside
    /**
            }
            return true;
     *
            // released; a failed close may still retain them and must remain tracked by the channel.
import org.apache.arrow.flight.Ticket;
     * that interleaving, which is only a few instructions wide and cannot be hit reliably by racing.
            prefetchStarted = true;
     * <p>Both {@link #close()} and the prefetch's closed re-check can reach this method for the
                    afterStreamPublished();
    }
                    flightStream.next();
    /**
        }
            close();
        } catch (IOException e) {
            }
     * this falls back to {@link #close()}: the prefetch's closed re-check self-closes the stream it
     */
        return handler;
                    // (getStream failed), there is nothing to close but the notification must
                    // (getStream failed), close() owns notification".
    private volatile FlightStream flightStream;
        try {
                    flightStream = flightClient.getStream(ticket, new HeaderCallOption(callHeaders));
import org.opensearch.transport.TransportResponseHandler;
        if (flightStream == null) throw new IllegalStateException("openAndPrefetch() must be called first");
        FlightStream stream = flightStream;
            logFailure("Error requesting flight stream cancellation", e);
                    // Lets a racing close() distinguish "prefetch still running, it will handle
    private final Object streamCloseLock = new Object();
                    if (closed && flightStream == null) {
}
                            if (releaseStream()) {
    FlightTransportResponse(
        Ticket ticket,
        if (stream == null) {
     */
                return;
    private VectorStreamInput newStreamInput(VectorSchemaRoot streamRoot, byte[] metadata) {
                        }
                    logger.debug("First FlightClient.next() for correlationId: {} took {}ms", correlationId, elapsedMs);
     */
                    //
    /**
    private boolean releaseStream() {
            }
                    // already happened, self-close the stream we just opened so the prefetched first-batch
     * it cannot wait for: a close running on the dispatch thread would block until the timeout,
            VectorSchemaRoot streamRoot = flightStream.getRoot();
        this.callHeaders = new FlightCallHeaders();
    /**
import static org.opensearch.arrow.flight.transport.ClientHeaderMiddleware.CORRELATION_ID_KEY;
    void cancelStreamOnly(String reason) {
     * have been released, so it is safe to notify a channel that is waiting to close its client.
/*
                    stream.close();
                    // Already closed underneath us; the buffers are gone either way.
        this.isNativeHandler = handler.skipsDeserialization();
    /** Set when the open/prefetch task has finished (whether or not it published a stream). */
            logger.debug("FlightClient.next() for correlationId: {} took {}ms", correlationId, took);
     * handle that clears the mark. Used by {@link FlightClientChannel#close()} to recognise streams
     * {@code FlightClientChannel#logFailure} for the full mechanism.
        // Decide who owns stream shutdown under the same lock openAndPrefetchAsync uses, so a
    TransportResponseHandler<T> getHandler() {
                    future.completeExceptionally(FlightErrorMapper.fromFlightException(e));
        this.callHeaders.insert(CORRELATION_ID_KEY, String.valueOf(correlationId));
            if (streamCloseAttempted == false) {
            return;
            if (closed) return;
import java.util.Objects;
        long startTime = System.currentTimeMillis();
                logger.debug("Flight stream next() took [{}ms], exceeding threshold [{}ms]", took, config.getSlowLogThreshold().millis());
        }
        return () -> dispatchThread = null;
        } catch (FlightRuntimeException e) {
        if (logger.isTraceEnabled()) {
     * @return true if the stream's buffers are known to be released, false if the close failed
import org.apache.arrow.vector.VectorSchemaRoot;
        }
     * Both lines below pass strings only, so the renderer never runs at any level. See
    public void close() {
     * Requests cancellation of the underlying flight stream without closing it. Safe to call from
                    prefetchCompleted = true;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
    private volatile long currentBatchSize;
    /**
package org.opensearch.arrow.flight.transport;
                } catch (FlightRuntimeException e) {
                        notifyClosed();
                input.setVersion(initialHeader.getVersion());
    static byte[] copyMetadata(ArrowBuf buf) {
import org.apache.logging.log4j.LogManager;
import org.apache.arrow.memory.ArrowBuf;
    }
        dispatchThread = Thread.currentThread();
     */
    /**
                } catch (Exception e) {
                    long elapsedMs = (System.nanoTime() - start) / 1_000_000;
     * publishes, so no consumer-owned resource is torn down from under a reader.
        if (callback != null && closeNotified.compareAndSet(false, true)) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    // still fire so a waiting channel is not left hanging. (No-op when the closed
     * Closing here instead would race with a consumer concurrently reading the stream's root.
        }
                    throw new StreamException(StreamErrorCode.INTERNAL, "Error closing flight stream", e);
            if (took > config.getSlowLogThreshold().millis()) {
    @Override
        } finally {
    /**
    }
            try (VectorStreamInput input = newStreamInput(streamRoot, metadata)) {
            }
    }
    long getCorrelationId() {
                    // root is not stranded, then abort. This check is performed *before* future.complete(),
     * The thread currently executing the consumer's stream callback, or {@code null} if none is.
                    // a completed prefetch deferred to us. If the stream never got published
     * buffers returned to the allocator. Used by {@link FlightClientChannel} to track streams that
        this.ticket = Objects.requireNonNull(ticket);
            // No stream was ever opened and none can start now (closed is set under the lock).
                                notifyClosed();
 * SPDX-License-Identifier: Apache-2.0
        this.correlationId = correlationId;
                    }
    private final TransportResponseHandler<T> handler;
import org.apache.arrow.flight.FlightStream;
     * {@link #openAndPrefetchAsync}. Handing a throwable to log4j there risks pinning the carrier inside its
            if (releaseStream()) {
        } catch (Exception e) {
 *
        // self-closes the stream it publishes, then notifies.
                            }
     * @throws StreamException if this thread's close attempt failed unexpectedly
        this.headerContext = Objects.requireNonNull(headerContext);
    }
    private void logFailure(String message, Throwable cause) {
                    if (closed) {
        return copy;
 */
        logger.warn("{} for correlationId [{}]: {}", message, correlationId, FlightUtils.causeSummary(cause));
        long correlationId,
        this.namedWriteableRegistry = Objects.requireNonNull(namedWriteableRegistry);
    void openAndPrefetchAsync(CompletableFuture<Header> future) {
     * return a reliable statement about allocator state: {@code true} means the stream's buffers
     *
class FlightTransportResponse<T extends TransportResponse> implements StreamTransportResponse<T> {
     * closed and its buffers released. Must be set before the response is handed to a consumer.
    /** Correlates this response with its request in logs and in {@link HeaderContext}. */
        final boolean hadPrefetch;
            : VectorStreamInput.forByteSerialized(streamRoot, namedWriteableRegistry);
            hadPrefetch = prefetchStarted;
        return copyMetadata(flightStream.getLatestMetadata());
        this.handler = Objects.requireNonNull(handler);
            callback.run();
     * returns {@code null} if the buffer is absent/empty. Package-private for testing.
    private final Ticket ticket;
                    // A close() that raced this prefetch and found neither a published stream nor
import org.opensearch.transport.stream.StreamTransportResponse;
            ? VectorStreamInput.forNativeArrow(streamRoot, namedWriteableRegistry, metadata)
        }
                    start = System.nanoTime();
    private final NamedWriteableRegistry namedWriteableRegistry;
            byte[] metadata = readMetadata();
                    future.completeExceptionally(new StreamException(StreamErrorCode.INTERNAL, "Stream open/prefetch failed", e));
import org.opensearch.core.transport.TransportResponse;
        synchronized (this) {
                    // A close() can still slip in between publishing the stream and reading the flag here, in
import org.opensearch.transport.stream.StreamException;
                    // the closed re-check" from "prefetch finished without publishing a stream
    ) {
    @Override
            notifyClosed();
/**
        }
        }
 * Manages Flight stream lifecycle with lazy initialization and prefetching support.
            throw FlightErrorMapper.fromFlightException(e);
    }
                } catch (IllegalStateException ignore) {
import org.opensearch.transport.stream.StreamErrorCode;
                try {
            // Flight owns getLatestMetadata()'s buffer until the next next() call;
        return dispatchThread;
            currentBatchSize = FlightUtils.calculateVectorSchemaRootSize(streamRoot);
        if (closed) throw new StreamException(StreamErrorCode.UNAVAILABLE, "Stream is closed");
     *
                    initialHeader = headerContext.getHeader(correlationId);
                    }
                            // the one performing the close, and reports whether it succeeded.
     */
            // Nothing was ever published, so nothing is holding allocator memory.
                streamCloseAttempted = true;
    }
        try {
import java.io.IOException;
    }
import java.util.concurrent.atomic.AtomicBoolean;
                    // flightStream was still null. Now that it is published, re-check the flag: if a close()
            if (!hasNext) return null;
                return handler.read(input);
    private void notifyClosed() {
            });
 */
    }
                        try {
    private volatile Thread dispatchThread;
    private volatile boolean prefetchStarted;
    }
        Runnable callback = onClosed;
    Thread getDispatchThread() {
                    // re-check or the racing close() already notified — notification is one-shot.)
            }
                }
        }
    long getCurrentBatchSize() {
    private volatile boolean firstBatchConsumed;
     * Sets the callback notified exactly once, after the underlying flight stream (if any) has been
        FlightTransportConfig config
    private final boolean isNativeHandler;
        }
                } catch (Exception e) {
                        return;
    private volatile Runnable onClosed;
        // prefetch cannot start after close() concluded none was running.
        HeaderContext headerContext,
import org.opensearch.common.lease.Releasable;
                    long start = System.nanoTime();
    }
     */
                            // still be allocated. releaseStream() blocks if a racing close() is
                        } catch (StreamException e) {
    /**
import org.opensearch.transport.Header;
                    elapsedMs = (System.nanoTime() - start) / 1_000_000;
     * Closes the underlying flight stream at most once, and does not return until the close has
     * The thread currently executing the consumer's stream callback, or {@code null} when no
     * are still holding allocator memory, so channel close can wait for them before closing the
     * {@link FlightClient} (whose allocator close treats outstanding buffers as a leak).
     * Logs a one-line summary at WARN, with the full stack trace only at TRACE.
                    // which case both paths reach releaseStream(); it closes the stream once and blocks the
     * <p>Every path in this class can run on the per-stream prefetch virtual thread started by
                            logFailure("Error closing flight stream after close() raced the prefetch", e);
     * released, because the release can only happen once the callback it is executing returns.
import org.apache.arrow.flight.FlightCallHeaders;
            Thread.ofVirtual().start(() -> {
    private static final Logger logger = LogManager.getLogger(FlightTransportResponse.class);
    @Override
