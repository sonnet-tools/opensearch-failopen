            if (!hasNext) return null;
     * the window in which a concurrent {@link #close()} can observe the published stream and reach
    /**  
                } catch (Exception e) {
                logger.debug("Flight stream next() took [{}ms], exceeding threshold [{}ms]", took, config.getSlowLogThreshold().millis());
    private final NamedWriteableRegistry namedWriteableRegistry;
    private volatile long currentBatchSize;
     * The thread currently executing the consumer's stream callback, or {@code null} when no  
            });
    long getCurrentBatchSize() {
                return;
     * Copies an Arrow Flight metadata buffer into a {@code byte[]} the consumer owns, or
import java.util.concurrent.atomic.AtomicBoolean;  
    ) {
            VectorSchemaRoot streamRoot = flightStream.getRoot();  
            // released; a failed close may still retain them and must remain tracked by the channel.  
        this.onClosed = onClosed;  
     * this falls back to {@link #close()}: the prefetch's closed re-check self-closes the stream it
                    // close() may have run while we were inside getStream() and missed the stream because
     */  
    /** Runs the {@link #onClosed} callback exactly once, if set. */  
     * @throws StreamException if this thread's close attempt failed unexpectedly  
    }
        NamedWriteableRegistry namedWriteableRegistry,  
    /** Correlates this response with its request in logs and in {@link HeaderContext}. */
        this.ticket = Objects.requireNonNull(ticket);
    private byte[] readMetadata() {
                    logger.debug("FlightClient.getStream() for correlationId: {} took {}ms", correlationId, elapsedMs);
                    initialHeader = headerContext.getHeader(correlationId);  
     * {@link #releaseStream()} first. No-op in production; overridden by tests that need to force  
     * @return true if the stream's buffers are known to be released, false if the close failed
    long getCorrelationId() {
 * compatible open source license.
    /** Guarded by {@link #streamCloseLock}: set when the stream's buffers are known to be released. */
        FlightTransportConfig config
            }
import org.opensearch.transport.stream.StreamErrorCode;
    }
     * same stream (they write {@code flightStream} and {@code closed} in opposite orders, so each  
            }  
            if (closed) {
        synchronized (this) {
                try {
        try {  
    void cancelStreamOnly(String reason) {
import org.opensearch.transport.stream.StreamException;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    streamReleased = true;
        this.callHeaders = new FlightCallHeaders();
        return handler;
                    //
        }
import org.apache.arrow.flight.FlightStream;
        FlightStream stream = flightStream;  
    void setOnClosed(Runnable onClosed) {
/*  
    @Override  
            // Nothing was ever published, so nothing is holding allocator memory.
     */
    /** Set when the open/prefetch task has finished (whether or not it published a stream). */  
     * {@link #openAndPrefetchAsync}. Handing a throwable to log4j there risks pinning the carrier inside its  
 *
            logger.debug("FlightClient.next() for correlationId: {} took {}ms", correlationId, took);  
     * return a reliable statement about allocator state: {@code true} means the stream's buffers
        }  
    }
        // else: the prefetch is still in flight; its closed re-check sees closed == true and
            long took = System.currentTimeMillis() - startTime;
                                notifyClosed();
     * {@code FlightClientChannel#logFailure} for the full mechanism.  
        logger.warn("{} for correlationId [{}]: {}", message, correlationId, FlightUtils.causeSummary(cause));  
     * handle that clears the mark. Used by {@link FlightClientChannel#close()} to recognise streams
        }
    @Override
                    // so once the future completes, any subsequent close() always observes flightStream != null  
            // Stream published (release it), or the prefetch finished without publishing one
    private final FlightCallHeaders callHeaders;
    /**  
     * Notified exactly once, after the underlying flight stream (if any) has been closed and its
                    // flightStream was still null. Now that it is published, re-check the flag: if a close()  
     * may observe the other's write). Blocking the loser rather than letting it return early is
                    // A close() can still slip in between publishing the stream and reading the flag here, in  
            if (streamCloseAttempted == false) {  
    }
    private final HeaderContext headerContext;  
    /** Ensures {@link #onClosed} runs exactly once. */
     * have been released, so it is safe to notify a channel that is waiting to close its client.  
     * <p>Every path in this class can run on the per-stream prefetch virtual thread started by
        } finally {
                future.completeExceptionally(new StreamException(StreamErrorCode.UNAVAILABLE, "Stream is closed"));  
     * returns {@code null} if the buffer is absent/empty. Package-private for testing.
        long correlationId,
     * Requests cancellation of the underlying flight stream without closing it. Safe to call from
    private final FlightClient flightClient;
    Releasable markDispatchThread() {  
        if (closed) return;
        long startTime = System.currentTimeMillis();
    }
    public void close() {
     */
        }
    private volatile FlightStream flightStream;  
                return handler.read(input);
     * Test seam, invoked after the stream is published and before the closed re-check below it —
import org.apache.arrow.flight.HeaderCallOption;
    }
import org.opensearch.ExceptionsHelper;
                    // A close() that raced this prefetch and found neither a published stream nor
        } catch (IOException e) {
    }
import org.opensearch.common.lease.Releasable;  
        try {
                    // (getStream failed), there is nothing to close but the notification must
     *
    }  
        return correlationId;  
            return;
     * buffers returned to the allocator. Used by {@link FlightClientChannel} to track streams that
        }  
 * Streaming transport response implementation using Arrow Flight.
    private final Ticket ticket;  
import java.util.concurrent.CompletableFuture;
            prefetchStarted = true;
                    future.complete(initialHeader);
                    streamReleased = true;
                streamCloseAttempted = true;
                    // which case both paths reach releaseStream(); it closes the stream once and blocks the
import org.apache.arrow.flight.FlightRuntimeException;  
                    if (closed && flightStream == null) {
        if (logger.isTraceEnabled()) {
     * are still holding allocator memory, so channel close can wait for them before closing the  
     * publishes, so no consumer-owned resource is torn down from under a reader.
    /** Guarded by {@link #streamCloseLock}: set once a thread has entered {@code FlightStream#close}. */
            Thread.ofVirtual().start(() -> {  
     * {@link FlightStream#close()}.  
                    // and owns the close itself.
                }
        // self-closes the stream it publishes, then notifies.  
            return streamReleased;  
    }  
            if (prefetchStarted) return;
import java.util.Objects;
                    prefetchCompleted = true;
     * Sets the callback notified exactly once, after the underlying flight stream (if any) has been
        buf.getBytes(0, copy);
            logFailure("Error cancelling flight stream", e);  
    private volatile boolean firstBatchConsumed;
            hadPrefetch = prefetchStarted;
    /**
        synchronized (streamCloseLock) {
        // Decide who owns stream shutdown under the same lock openAndPrefetchAsync uses, so a  
                    // root is not stranded, then abort. This check is performed *before* future.complete(),
    }
                    }  
     * {@link FlightClient} (whose allocator close treats outstanding buffers as a leak).
import org.apache.logging.log4j.Logger;
import org.apache.arrow.flight.FlightCallHeaders;
                    // still fire so a waiting channel is not left hanging. (No-op when the closed
        Runnable callback = onClosed;
    void afterStreamPublished() {}  
        synchronized (this) {  
import org.apache.arrow.flight.Ticket;  
            throw new StreamException(StreamErrorCode.INTERNAL, "Failed to deserialize batch", e);  
            return true;  
                            // Notify only once the stream's buffers are actually released, so a
     * released, because the release can only happen once the callback it is executing returns.
    private final long correlationId;
                        return;
    }  
            if (flightStream != null) flightStream.cancel(reason, cause);
        this.namedWriteableRegistry = Objects.requireNonNull(namedWriteableRegistry);  
        } catch (FlightRuntimeException e) {  
                    throw new StreamException(StreamErrorCode.INTERNAL, "Error closing flight stream", e);  
            if (took > config.getSlowLogThreshold().millis()) {  
import org.apache.logging.log4j.LogManager;  
                } catch (IllegalStateException ignore) {
     * Logs a one-line summary at WARN, with the full stack trace only at TRACE.  
        }  
            close();
    /**  
                    // (getStream failed), close() owns notification".  
        }
import org.opensearch.transport.Header;  
            // No stream was ever opened and none can start now (closed is set under the lock).
                        } catch (StreamException e) {  
        byte[] copy = new byte[len];
     *
import org.opensearch.transport.TransportResponseHandler;
    private volatile boolean prefetchCompleted;
    }
     */
    private volatile boolean closed;  
     * <p>If the stream has not been published yet (open/prefetch still in flight, or never started),  
        } catch (Exception e) {
import org.apache.arrow.memory.ArrowBuf;
     * Both lines below pass strings only, so the renderer never runs at any level. See
        FlightStream stream = flightStream;
        }
                    afterStreamPublished();
import org.apache.arrow.vector.VectorSchemaRoot;
    }
            if (closed) return;  
     * closed and its buffers released. Must be set before the response is handed to a consumer.
                    // second caller until that close has completed.
    }
                    long start = System.nanoTime();
            stream.cancel(reason, null);
            }
        return currentBatchSize;
class FlightTransportResponse<T extends TransportResponse> implements StreamTransportResponse<T> {
                input.setVersion(initialHeader.getVersion());  
                    start = System.nanoTime();
        int len = (int) buf.readableBytes();  
            // (getStream failed — nothing to release). Notify only once the buffers are known to be
    private void notifyClosed() {
        return isNativeHandler  
 * this file be licensed under the Apache-2.0 license or a
     * Closes the underlying flight stream at most once, and does not return until the close has  
    /**
            notifyClosed();  
     * completed — including when another thread is the one performing it. That makes a normal
    private void logFailure(String message, Throwable cause) {
     * callback is in progress. A closer running on this thread cannot wait for this stream to be
     */  
     * it cannot wait for: a close running on the dispatch thread would block until the timeout,  
     *
     * what prevents it from reporting the stream released while the winner is still inside
        return copyMetadata(flightStream.getLatestMetadata());  
        }
        if (stream == null) {  
            byte[] metadata = readMetadata();
    private volatile Runnable onClosed;  
    private static final Logger logger = LogManager.getLogger(FlightTransportResponse.class);  
            callback.run();
        if (flightStream != null || prefetchCompleted) {  
                    // a completed prefetch deferred to us. If the stream never got published  
    private final Object streamCloseLock = new Object();
        }  
        if (closed) throw new StreamException(StreamErrorCode.UNAVAILABLE, "Stream is closed");
                } finally {  
            logFailure("Error requesting flight stream cancellation", e);
        } finally {
    private VectorStreamInput newStreamInput(VectorSchemaRoot streamRoot, byte[] metadata) {
        if (hadPrefetch == false) {
package org.opensearch.arrow.flight.transport;
                        notifyClosed();
            boolean hasNext = firstBatchConsumed ? flightStream.next() : (firstBatchConsumed = true);  
    private volatile Header initialHeader;
            ? VectorStreamInput.forNativeArrow(streamRoot, namedWriteableRegistry, metadata)
        if (flightStream == null) throw new IllegalStateException("openAndPrefetch() must be called first");
     * (it observes a CANCELLED error), and that consumer remains responsible for {@link #close()}.  
        }  
        this.correlationId = correlationId;
                        future.completeExceptionally(new StreamException(StreamErrorCode.UNAVAILABLE, "Stream is closed"));  
    private boolean streamCloseAttempted;  
                }
                    future.completeExceptionally(FlightErrorMapper.fromFlightException(e));  
                            if (releaseStream()) {  
                } catch (Exception e) {
import static org.opensearch.arrow.flight.transport.ClientHeaderMiddleware.CORRELATION_ID_KEY;
        this.flightClient = Objects.requireNonNull(flightClient);  
        }
            if (releaseStream()) {
 * Manages Flight stream lifecycle with lazy initialization and prefetching support.  
     * <p>Both {@link #close()} and the prefetch's closed re-check can reach this method for the
                    future.completeExceptionally(new StreamException(StreamErrorCode.INTERNAL, "Stream open/prefetch failed", e));
                    // already happened, self-close the stream we just opened so the prefetched first-batch
        assert closed == false : "onClosed callback must be set before the response is closed";
            }
            // Flight owns getLatestMetadata()'s buffer until the next next() call;
     */
                            // still be allocated. releaseStream() blocks if a racing close() is
        final boolean hadPrefetch;
            closed = true;
            close();
        this.headerContext = Objects.requireNonNull(headerContext);
                    logger.debug("First FlightClient.next() for correlationId: {} took {}ms", correlationId, elapsedMs);
        return () -> dispatchThread = null;
                            }
    private volatile Thread dispatchThread;
    private boolean streamReleased;
        try {
            }
    /**
     */  
            logger.trace("{} for correlationId [{}]: {}", message, correlationId, ExceptionsHelper.stackTrace(cause));
                    flightStream = flightClient.getStream(ticket, new HeaderCallOption(callHeaders));  
        this.handler = Objects.requireNonNull(handler);  
        this.isNativeHandler = handler.skipsDeserialization();
                    }
    private final AtomicBoolean closeNotified = new AtomicBoolean();
    /**  
        if (callback != null && closeNotified.compareAndSet(false, true)) {  
        if (buf == null || buf.readableBytes() == 0) return null;
        TransportResponseHandler<T> handler,
                    // the closed re-check" from "prefetch finished without publishing a stream
                    // Lets a racing close() distinguish "prefetch still running, it will handle
                        try {
    FlightTransportResponse(  
    private final FlightTransportConfig config;  
                        }
            currentBatchSize = FlightUtils.calculateVectorSchemaRootSize(streamRoot);
        if (prefetchStarted) return;
            // we copy off so the response can outlive the stream cursor.  
    /**  
        } catch (Exception e) {  
        if (stream == null) {
     * because the stream can only be released once the callback it is executing returns.
        this.callHeaders.insert(CORRELATION_ID_KEY, String.valueOf(correlationId));  
     */  
    TransportResponseHandler<T> getHandler() {  
        return dispatchThread;  
    }  
                try {
 */
                    elapsedMs = (System.nanoTime() - start) / 1_000_000;
     * that interleaving, which is only a few instructions wide and cannot be hit reliably by racing.
                            // channel waiting on stream shutdown does not proceed while they may  
            return;
     */
        // prefetch cannot start after close() concluded none was running.
                    long elapsedMs = (System.nanoTime() - start) / 1_000_000;  
    public T nextResponse() {  
     * Marks the calling thread as the one executing the consumer's stream callback, and returns a
    /**  
        this.config = Objects.requireNonNull(config);
    private volatile boolean prefetchStarted;  
import org.apache.arrow.flight.FlightClient;
    public void cancel(String reason, Throwable cause) {
    void openAndPrefetchAsync(CompletableFuture<Header> future) {  
        return copy;  
import org.opensearch.core.transport.TransportResponse;
    private final TransportResponseHandler<T> handler;
            try (VectorStreamInput input = newStreamInput(streamRoot, metadata)) {
 * SPDX-License-Identifier: Apache-2.0
                    flightStream.next();  
import org.opensearch.transport.stream.StreamTransportResponse;
                    if (closed) {  
     */
    }
                    // Already closed underneath us; the buffers are gone either way.  
                    // re-check or the racing close() already notified — notification is one-shot.)  
     * any thread: {@link FlightStream#cancel} unblocks a consumer parked in {@link #nextResponse()}
                            logFailure("Error closing flight stream after close() raced the prefetch", e);
    private boolean releaseStream() {
                notifyClosed();
}  
    }  
                            // the one performing the close, and reports whether it succeeded.
 * The OpenSearch Contributors require contributions made to  
    @Override  
    static byte[] copyMetadata(ArrowBuf buf) {
 */  
/**
     *
            : VectorStreamInput.forByteSerialized(streamRoot, namedWriteableRegistry);
    }
     * extended stack-trace renderer, which can stall the virtual-thread scheduler under a mass stream failure.
        Ticket ticket,
     * Closing here instead would race with a consumer concurrently reading the stream's root.
                    stream.close();  
        HeaderContext headerContext,
            throw FlightErrorMapper.fromFlightException(e);
    /**
                } catch (FlightRuntimeException e) {
     * The thread currently executing the consumer's stream callback, or {@code null} if none is.  
import java.io.IOException;  
        FlightClient flightClient,  
    Thread getDispatchThread() {
        dispatchThread = Thread.currentThread();
    private final boolean isNativeHandler;
