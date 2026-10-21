                StreamException exception = new StreamException(StreamErrorCode.UNAVAILABLE, "FlightClientChannel is closed");
     * Waits up to {@link FlightTransportConfig#getStreamCloseTimeout()} for active streams to be
     * Constructs a new FlightClientChannel for handling Arrow Flight streams.
     * released by their consumers (each removes itself from {@link #activeStreams} once its buffers
    private final FlightTransportConfig config;
        // is safe from this thread and unblocks consumers parked in nextResponse()
                streamResponse.cancelStreamOnly("channel to node [" + node.getId() + "] closed");
            if (streamResponse.getDispatchThread() != current) {
    private final CompletableFuture<Void> closeFuture;
        if (closeStarted.compareAndSet(false, true) == false) {
                );
            connectFuture.completeExceptionally(e);
                try (var dispatchMark = streamResponse.markDispatchThread()) {
        this.closeFuture = new CompletableFuture<>();
        });
     * only at TRACE.
        }
                    } catch (Exception e) {
            // Track the stream until its buffers are released, so close() can wait for it before
     */
        }
            notifyListener(listener, closeFuture);
    @Override
        BoundTransportAddress boundTransportAddress,
                            // would NPE on getHeaders() below and mask the real failure. A null header is
        }
                timeoutMillis,
/*
     *       log4j's <em>extended</em> stack-trace renderer, which annotates every frame with its source JAR.</li>
        // until their consumer closes them. So: cancel every active stream — FlightStream.cancel
     *       contended, and a continuation carrying a native frame cannot be unmounted. So the virtual thread
    }
        Location location,
                return true;
            logger.warn(
import org.opensearch.transport.stream.StreamException;
                        cleanupStreamResponse(streamResponse);
     * <p><b>Never hand a throwable to log4j from these paths.</b> They run on the per-stream prefetch
                    Thread.currentThread().interrupt();
     *       {@code forName0} <em>native</em> frame sits on the stack while the classloader monitor is
        }
                        handler.handleStreamResponse(streamResponse);
        }
    }
        this.removableCloseListeners = new CopyOnWriteArrayList<>();
                task.run();
            // closing the FlightClient. Set the callback before any consumer can close the stream.
        if (ThreadPool.Names.SAME.equals(executor)) {
        if (logger.isTraceEnabled()) {
        this.profile = profile;
        }
    }
            );
     * their underlying flight stream is closed. {@link #close()} cancels every remaining stream
        notifyListeners(closeListeners, closeFuture);
                notifyHandlerOfException(handler, exception);
        var threadContext = threadPool.getThreadContext();
    }
    private final HeaderContext headerContext;
        }
import org.apache.logging.log4j.Logger;
        NamedWriteableRegistry namedWriteableRegistry,
import java.util.List;
     * <p>Streams whose consumer callback is running on this very thread are excluded from the wait:
            connectFuture.complete(null);
import org.opensearch.transport.stream.StreamErrorCode;
            };
        }
    private final Transport.ResponseHandlers responseHandlers;
        return "FlightClientChannel{node=" + node.getId() + ", remoteAddress=" + getRemoteAddress() + ", profile=" + profile + '}';
        return stats;
                handler,
            client.close();
        String profile,
        if (!isOpen()) {
     *
            TransportResponseHandler<?> handler = responseHandlers.onResponseReceived(requestId, messageListener);
/**
            listener.onResponse(null);
            notifyListeners(connectListeners, connectFuture);
    }
    }
    ) {
    }
        }
            cancelStream(streamResponse, exception);
        FlightCallTracker callTracker = null;
        this.boundAddress = boundTransportAddress;
                // rather than leaving the request without a terminal callback.
        future.whenComplete((header, error) -> {
                config
            });
        this.responseHandlers = responseHandlers;
                callTracker.recordCallEnd(StreamErrorCode.INTERNAL.name());
                streamResponse.cancelStreamOnly("channel to node [" + node.getId() + "] closed");
        if (ThreadPool.Names.SAME.equals(executor)) {
            );
        }
import org.opensearch.core.common.bytes.BytesReference;
        }
            if (isOpen() == false) {
                            // Must return: handleStreamException does not throw, so falling through here
                    + "cannot be released before close returns and their buffers may be reported as leaked",
    private final ChannelStats stats;
    private final List<ActionListener<Void>> connectListeners;
    @Override
                namedWriteableRegistry,
     * render a stack trace there can wedge the whole node:
import java.util.Set;
    public void close() {
                listener.onFailure(exception);
                // While the consumer callback runs, this thread owns the stream: it is the only one
    }
class FlightClientChannel implements TcpChannel {
            // Runs on the prefetch virtual thread when the handler declares the SAME executor.
            Ticket ticket = serializeToTicket(reference);
        this.connectFuture = new CompletableFuture<>();
            final Throwable ex = closeFuture.exceptionNow();
        } else {
        return new Ticket(BytesReference.toBytes(reference));
                    e
        if (closeFuture.isDone()) {
        } catch (Exception cancelEx) {
                    }
            listener.onFailure(new StreamException(StreamErrorCode.INTERNAL, "Failed to send message", e));
                return;
                // handler was already removed from responseHandlers above, so notify it directly
                correlationId,
     */
            notifyHandlerOfException(handler, exception);
    @Override
        } else {
    }
 * SPDX-License-Identifier: Apache-2.0
    public FlightClientChannel(
        long selfOwned = remaining.stream().filter(s -> s.getDispatchThread() == current).count();
        long channelId = GLOBAL_CHANNEL_COUNTER.incrementAndGet() & 0xFFFFF; // 20 bits for channel ID
        // taking the listener out of the list claims it, so a listener that is removed while the channel is
    public void removeCloseListener(BiConsumer<Void, ? super Exception> listener) {
                        }
        }
        }
        ThreadPool threadPool,
        }
        long straggling = remaining.size() - selfOwned;
            notifyRemovableListener(listener);
        }
        synchronized (activeStreamsMonitor) {
    public void addCloseListener(BiConsumer<Void, ? super Exception> listener) {
            statsCollector.incrementClientChannelsActive();
        DiscoveryNode node,
            return;
     *       pins its carrier instead of yielding it, even on JDK 25 where JEP 491 lets {@code synchronized}
    @Override
        }
        if (exception instanceof StreamException se) {
     * @param statsCollector         the collector for flight statistics
            openStreamAndInvokeHandler(streamResponse);
        return !isClosed;
            }
import org.opensearch.arrow.flight.stats.FlightStatsCollector;
                "Gave up after [{}ms] waiting for [{}] active stream(s) to be released while closing channel to node [{}]; "
            });
            } else {
                            // is a plain map remove), e.g. a call closed before its headers arrived.
        TransportResponseHandler handler = streamResponse.getHandler();
import org.opensearch.ExceptionsHelper;
        this.threadPool = threadPool;
     * returns, so waiting for them would burn the whole timeout to no effect.
import java.util.concurrent.atomic.AtomicBoolean;
    }
    public String getProfile() {
        connectListeners.add(listener);
    }
     *       (for example every stream reconnecting at once after a network partition heals) can therefore pin
import org.opensearch.core.common.transport.BoundTransportAddress;
     * Whether any active stream can still be released while this close is waiting — that is, any
 * this file be licensed under the Apache-2.0 license or a
    private final DiscoveryNode node;
     *       blocking unmount.</li>
        FlightClient client,
        try {
                        if (header == null) {
    }
     *       every carrier, while the thread holding the classloader lock is itself unmounted and can never be
import java.util.concurrent.CompletableFuture;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        removableCloseListeners.add(listener);
        try {
    @SuppressWarnings({ "unchecked", "rawtypes" })
     * <p>The TRACE line is safe for the same reason: it passes a pre-rendered string, so log4j never sees a
        } catch (IOException e) {
    @Override
            // Open stream and prefetch first batch, invoke handler when ready
     * @param headerContext          the context for header management
     * then report the stragglers' buffers as leaked, which is logged, not thrown.
        } else {
    }
    public ChannelStats getChannelStats() {
        this.location = location;
    /** Signalled whenever a stream leaves {@link #activeStreams}, to wake {@link #close()}. */
        streamResponse.openAndPrefetchAsync(future);
                    () -> new ParameterizedMessage("Error cancelling active stream while closing channel to node [{}]", node.getId()),
        logFailure("Exception while handling stream response for correlationId [" + streamResponse.getCorrelationId() + "]", exception);
        StreamException streamException;
     * Logs a per-stream failure as a one-line summary at ERROR, with the full stack trace available
        try {
     *
        for (FlightTransportResponse<?> streamResponse : activeStreams) {
 * The OpenSearch Contributors require contributions made to
import java.util.function.BiConsumer;
    private void notifyRemovableListener(BiConsumer<Void, ? super Exception> listener) {
        try {
     * that were captured when the throwable was constructed, resolving no classes and taking no lock.
    }
            }
        List<FlightTransportResponse<?>> remaining = new ArrayList<>(activeStreams);
            }
        try {
                // is cancelled rather than left running against a closing client. The response
    }
        this.connectListeners = new CopyOnWriteArrayList<>();
        if (closeFuture.isCompletedExceptionally()) {
     * @param node                   the discovery node for this channel
     * @param namedWriteableRegistry the registry for deserialization
     * <ol>
import java.util.ArrayList;
            }
        CompletableFuture<Header> future = new CompletableFuture<>();
     * their release cannot happen until the callback returns, which cannot happen until this close
     * close treats any outstanding buffer as a leak.
                    try (var ignored = threadContext.stashContext()) {
import org.opensearch.arrow.flight.stats.FlightCallTracker;
    private final AtomicBoolean closeStarted = new AtomicBoolean();
    private void cleanupStreamResponse(StreamTransportResponse<?> streamResponse) {
                threadPool.executor(executor).execute(task);
        }
    }
    private void awaitActiveStreamsClosed() {
    }
            return;
     *   <li>OpenSearch's JSON layout always appends {@code %exceptionAsJson}, so a logged throwable reaches
                headerContext,
    public String toString() {
    @Override
            future.handle((result, ex) -> {
        try {
        if (straggling > 0) {
    }
        }
    private final Location location;
                        throw e;
                // that can release it, so a close() reaching this thread must not wait for it.
import java.util.concurrent.TimeUnit;
                }
     * stream not owned by the calling thread. See {@link #awaitActiveStreamsClosed()}.
            logger.warn("Failed to close FlightClient for node [" + node.getId() + "]", e);
        } catch (Exception e) {
import org.opensearch.transport.TcpChannel;
                selfOwned
        }
                return null;
 */
                logger.warn(
        final long deadlineNanos = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(timeoutMillis);
     */
        return boundAddress.publishAddress().address();
        for (ActionListener<Void> listener : listeners) {
     * and waits for the set to drain before closing the {@link FlightClient}, whose allocator
}
    }
                handleStreamException(streamResponse, error instanceof Exception ? (Exception) error : new Exception(error));
        logger.error("{}: {}", message, FlightUtils.causeSummary(cause));
                straggling,
        this.messageListener = messageListener;
    }
    private void handleStreamException(FlightTransportResponse<?> streamResponse, Exception exception) {
import java.io.IOException;
     * </ol>
            logFailure("Handler failed to process exception", handlerEx);
    private final Set<FlightTransportResponse<?>> activeStreams = ConcurrentHashMap.newKeySet();
            callTracker.recordRequestBytes(reference.length());
        if (statsCollector != null) {
            listener.onResponse(null);
                } catch (InterruptedException e) {
    private final BoundTransportAddress boundAddress;
            notifyListener(listener, future);
     * @param messageListener        the transport message listener
import org.opensearch.transport.Header;
    private volatile boolean isClosed;
            if (error != null) {
            if (ThreadPool.Names.SAME.equals(executor)) {
            streamResponse.cancel("Client-side exception: " + cause.getMessage(), cause);
            notifyRemovableListener(listener);
    }
                    break;
        String executor = handler.executor();
import org.apache.arrow.flight.Ticket;
            cleanupStreamResponse(streamResponse);
            }
        this.statsCollector = statsCollector;
        } catch (Exception e) {
     *       while making no progress.</li>
        Transport.ResponseHandlers responseHandlers,
                // close() may have iterated activeStreams before this add; make sure this stream
        // Initialize with timestamp + global counter to ensure uniqueness with multiple channels
        return false;
            streamException = new StreamException(StreamErrorCode.INTERNAL, "Stream processing failed", exception);
        FlightStatsCollector statsCollector,
        this.headerContext = headerContext;
        // The FlightClient's allocator close treats any outstanding buffer as a leak, and live
        }
            notifyListener(listener, connectFuture);
                    // Wake on the next release, or at the deadline; never wait(0), which waits forever.
            logFailure("Failed to close stream response", e);
        this.isClosed = false;
            TransportResponseHandler<?> handler = streamResponse.getHandler();
        if (statsCollector != null) {
 */
        this.stats = new ChannelStats();
     *   <li>The scheduler's carrier count defaults to {@code availableProcessors}. A mass stream failure
import java.util.concurrent.ConcurrentHashMap;
        }
    private void initializeConnection() {
import org.apache.logging.log4j.message.ParameterizedMessage;
    private final String profile;
            streamResponse.close();
     *       rescheduled to release it. That circular wait does not resolve: the node keeps reporting healthy
                    activeStreamsMonitor.notifyAll();
                handler = new MetricsTrackingResponseHandler<>(handler, callTracker);
        initializeConnection();
    @Override
        try {
                    activeStreamsMonitor.wait(Math.max(1, TimeUnit.NANOSECONDS.toMillis(remainingNanos)));
                    + "their buffers may be reported as leaked",
            throw new StreamException(StreamErrorCode.INTERNAL, "Failed to resolve remote address", e);
        HeaderContext headerContext,
    }
        long initialValue = (System.currentTimeMillis() << 20) | channelId;
    public void addConnectListener(ActionListener<Void> listener) {
                activeStreams.remove(streamResponse);
    /**
                node.getId(),
            long correlationId = correlationIdGenerator.incrementAndGet();
    private boolean hasStreamsToAwait() {
        } catch (Exception handlerEx) {
        this.client = client;
        }
        // notified here, one added before it is notified by close(), and remove() decides which of the two does it
     *   <li>To do that it resolves each frame's declaring class via {@code Class.forName}. The resulting
                }
     * virtual thread started by {@link FlightTransportResponse#openAndPrefetchAsync}, and letting log4j
                return;
                node.getId()
    /**
 *
    }
     * @param profile                the channel profile
                        threadContext.setHeaders(header.getHeaders());
    private final CompletableFuture<Void> connectFuture;
    /**
    @Override
     * @param config                 the shared transport configuration
            statsCollector.decrementClientChannelsActive();
import org.opensearch.transport.TransportMessageListener;
            listener.accept(closeFuture.resultNow(), null);
     * Streams created by this channel whose buffers may still be accounted against the client's
    public void sendMessage(long requestId, BytesReference reference, ActionListener<Void> listener) {
    private Ticket serializeToTicket(BytesReference reference) {
    private final List<BiConsumer<Void, ? super Exception>> removableCloseListeners;
    @Override
            return new InetSocketAddress(InetAddress.getByName(location.getUri().getHost()), location.getUri().getPort());
    private void cancelStream(FlightTransportResponse<?> streamResponse, Exception cause) {
    }
import org.opensearch.transport.stream.StreamTransportResponse;
            streamException = se;
            listener.accept(null, ex instanceof Exception exception ? exception : new Exception(ex));
     */
        Thread current = Thread.currentThread();
    private final Object activeStreamsMonitor = new Object();
        if (connectFuture.isDone()) {
                            handleStreamException(streamResponse, new StreamException(StreamErrorCode.INTERNAL, "Header is null"));
        // added before the check on purpose: close() walks the list once, so a listener added after that walk is
        closeFuture.complete(null);
        }
            }
     */
    @Override
package org.opensearch.arrow.flight.transport;
    private void openStreamAndInvokeHandler(FlightTransportResponse<?> streamResponse) {
    }
    private static final Logger logger = LogManager.getLogger(FlightClientChannel.class);
    private final TransportMessageListener messageListener;
    private final NamedWriteableRegistry namedWriteableRegistry;
            Runnable task = () -> {
     */
        if (selfOwned > 0) {
    @Override
                client,
    }
        } catch (Exception e) {
            long remainingNanos;
    private void logFailure(String message, Throwable cause) {
import org.opensearch.core.action.ActionListener;
                }
     *
            try {
            threadPool.executor(executor).execute(() -> safeHandleException(handler, streamException));
            streamResponse.setOnClosed(() -> {
     * allocator. Entries remove themselves via {@link FlightTransportResponse#setOnClosed} once
        }
import java.util.concurrent.CopyOnWriteArrayList;
    public void sendMessage(BytesReference reference, ActionListener<Void> listener) {
        removableCloseListeners.remove(listener);
        this.closeListeners = new CopyOnWriteArrayList<>();
        FlightTransportConfig config
        Thread current = Thread.currentThread();
                "Channel to node [{}] is being closed from a stream consumer callback; [{}] stream(s) owned by this thread "
                synchronized (activeStreamsMonitor) {
    }
        String executor = handler.executor();
            callTracker = statsCollector.createClientCallTracker();
            notifyListeners(connectListeners, connectFuture);
            }
        }
            );
    /**
    /**
    private final FlightStatsCollector statsCollector;
    private final AtomicLong correlationIdGenerator = new AtomicLong();
        }
        this.config = config;
        }
        this.correlationIdGenerator.set(initialValue);
            safeHandleException(handler, streamException);
     * Initializes the connection and notifies listeners of the result.
    public InetSocketAddress getRemoteAddress() {
    public boolean isServerChannel() {
import org.apache.logging.log4j.LogManager;
        try {
        for (BiConsumer<Void, ? super Exception> listener : removableCloseListeners) {
            logger.debug("Stream transport handler using SAME executor, which may cause blocking behavior");
    public boolean isOpen() {
     * @param responseHandlers       the transport response handlers
        // Upper bits: timestamp, lower 20 bits: channel ID
    private void notifyListeners(List<ActionListener<Void>> listeners, CompletableFuture<Void> future) {
                ticket,
    private final FlightClient client;
        final long timeoutMillis = config.getStreamCloseTimeout().millis();
        this.namedWriteableRegistry = namedWriteableRegistry;
            FlightTransportResponse<?> streamResponse = new FlightTransportResponse<>(
import java.net.InetAddress;
     * throwable and the extended renderer never runs. {@link ExceptionsHelper#stackTrace} only formats frames
                try {
                listener.onFailure(ex instanceof Exception exception ? exception : new Exception(ex));
        isClosed = true;
     * @param location               the flight server location
        } else {
     * @param threadPool             the thread pool for async operations
    }
    private void notifyHandlerOfException(TransportResponseHandler<?> handler, Exception exception) {
        return profile;
        return false;
 * compatible open source license.
 * TcpChannel implementation for Flight client with async response handling.
import org.opensearch.transport.TransportResponseHandler;
            while (hasStreamsToAwait() && (remainingNanos = deadlineNanos - System.nanoTime()) > 0) {
        if (closeFuture.isDone()) {
        if (future.isCompletedExceptionally()) {
    private void safeHandleException(TransportResponseHandler<?> handler, StreamException exception) {
            }
        awaitActiveStreamsClosed();
        closeListeners.add(listener);
            if (callTracker != null) {
import java.net.InetSocketAddress;
        if (statsCollector != null) {
    private final ThreadPool threadPool;
    private final List<ActionListener<Void>> closeListeners;
import org.opensearch.transport.Transport;
                            // reachable whenever the middleware never stored one (HeaderContext.getHeader
import org.apache.arrow.flight.Location;
    @Override
    private static final AtomicLong GLOBAL_CHANNEL_COUNTER = new AtomicLong();
            logger.trace("{}: {}", message, ExceptionsHelper.stackTrace(cause));
            return;
        // streams legitimately hold buffers (current batch root, retained heartbeat metadata)
    private void notifyListener(ActionListener<Void> listener, CompletableFuture<Void> future) {
            logger.warn(
            listener.onFailure(new StreamException(StreamErrorCode.UNAVAILABLE, "FlightClientChannel is closed"));
        }
        } catch (Exception e) {
        TransportMessageListener messageListener,
    public void addCloseListener(ActionListener<Void> listener) {
                            return;
        if (removableCloseListeners.remove(listener) == false) {
     *
    /**
            logFailure("Failed to cancel stream after exception", cancelEx);
import org.apache.arrow.flight.FlightClient;
        } finally {
    @Override
import java.util.concurrent.atomic.AtomicLong;
     * @param client                 the Arrow Flight client
            // ticket will contain the serialized headers
    public InetSocketAddress getLocalAddress() {
        for (FlightTransportResponse<?> streamResponse : activeStreams) {
        this.node = node;
    @Override
     * are released). On timeout, proceeds anyway — the subsequent {@link FlightClient#close()} may
import org.opensearch.threadpool.ThreadPool;
        throw new IllegalStateException("sendMessage must be accompanied with requestId for FlightClientChannel, use the right variant.");
 *
        }
     *
import org.opensearch.cluster.node.DiscoveryNode;
            handler.handleException(exception);
        }
    }
            if (callTracker != null) {
        // closing is notified exactly once, or not at all once removeCloseListener has taken it
            } catch (Exception e) {
            activeStreams.add(streamResponse);
