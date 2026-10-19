import org.opensearch.core.action.ActionListener;
import java.net.InetSocketAddress;  
import java.util.concurrent.CopyOnWriteArrayList;  
     *   <li>To do that it resolves each frame's declaring class via {@code Class.forName}. The resulting  
     * Logs a per-stream failure as a one-line summary at ERROR, with the full stack trace available
import org.apache.logging.log4j.message.ParameterizedMessage;  
    public void close() {
        } else {  
                ticket,  
     * @param client                 the Arrow Flight client  
        try {
            if (isOpen() == false) {
    private final List<ActionListener<Void>> connectListeners;  
    }  
            notifyListener(listener, future);  
                    activeStreamsMonitor.wait(Math.max(1, TimeUnit.NANOSECONDS.toMillis(remainingNanos)));
        } catch (Exception cancelEx) {
import org.opensearch.arrow.flight.stats.FlightCallTracker;
            } catch (Exception e) {
    @Override
     *
            notifyListeners(connectListeners, connectFuture);
        } catch (IOException e) {
        } catch (Exception e) {
    private final ThreadPool threadPool;
import org.opensearch.transport.TransportMessageListener;
            );  
        try {  
            statsCollector.decrementClientChannelsActive();
     * Whether any active stream can still be released while this close is waiting — that is, any
import java.util.Set;  
     */
            while (hasStreamsToAwait() && (remainingNanos = deadlineNanos - System.nanoTime()) > 0) {
    private final List<BiConsumer<Void, ? super Exception>> removableCloseListeners;
        try {
                            return;  
        if (statsCollector != null) {
                // rather than leaving the request without a terminal callback.  
    @Override  
        long initialValue = (System.currentTimeMillis() << 20) | channelId;  
    @Override
 *
        if (closeFuture.isDone()) {
        for (FlightTransportResponse<?> streamResponse : activeStreams) {
    @Override
                handler = new MetricsTrackingResponseHandler<>(handler, callTracker);
    }
    private boolean hasStreamsToAwait() {
            });  
        if (closeFuture.isDone()) {
     */
import org.opensearch.transport.stream.StreamTransportResponse;
                callTracker.recordCallEnd(StreamErrorCode.INTERNAL.name());
        this.config = config;
     */  
                client,
        BoundTransportAddress boundTransportAddress,
                            // is a plain map remove), e.g. a call closed before its headers arrived.
class FlightClientChannel implements TcpChannel {
        try {  
                        cleanupStreamResponse(streamResponse);
import org.opensearch.core.common.bytes.BytesReference;  
        future.whenComplete((header, error) -> {
        // until their consumer closes them. So: cancel every active stream — FlightStream.cancel
    }
    }  
                return null;
     * @param headerContext          the context for header management  
    }
        }
     * @param threadPool             the thread pool for async operations  
    }
        Location location,
    }
        }
    private static final Logger logger = LogManager.getLogger(FlightClientChannel.class);
    /**
import org.apache.arrow.flight.Ticket;  
                            // would NPE on getHeaders() below and mask the real failure. A null header is
    public void removeCloseListener(BiConsumer<Void, ? super Exception> listener) {
        try {
            } else {
                handleStreamException(streamResponse, error instanceof Exception ? (Exception) error : new Exception(error));  
        } catch (Exception e) {  
        if (removableCloseListeners.remove(listener) == false) {
        NamedWriteableRegistry namedWriteableRegistry,
    private void notifyListeners(List<ActionListener<Void>> listeners, CompletableFuture<Void> future) {
            statsCollector.incrementClientChannelsActive();  
    }  
            listener.accept(null, ex instanceof Exception exception ? exception : new Exception(ex));  
    private final FlightTransportConfig config;  
        if (closeStarted.compareAndSet(false, true) == false) {
            logger.warn("Failed to close FlightClient for node [" + node.getId() + "]", e);  
    }
            try {
        String executor = handler.executor();  
    }
            logger.debug("Stream transport handler using SAME executor, which may cause blocking behavior");  
            Runnable task = () -> {
    private void openStreamAndInvokeHandler(FlightTransportResponse<?> streamResponse) {
        this.profile = profile;
     *       pins its carrier instead of yielding it, even on JDK 25 where JEP 491 lets {@code synchronized}  
            }
        }  
            return new InetSocketAddress(InetAddress.getByName(location.getUri().getHost()), location.getUri().getPort());
    private void awaitActiveStreamsClosed() {
                timeoutMillis,
    @Override
            FlightTransportResponse<?> streamResponse = new FlightTransportResponse<>(
        CompletableFuture<Header> future = new CompletableFuture<>();
                    + "cannot be released before close returns and their buffers may be reported as leaked",  
     */
            }  
                correlationId,  
     *       contended, and a continuation carrying a native frame cannot be unmounted. So the virtual thread
            );
        if (statsCollector != null) {  
    private final FlightClient client;
    }
        FlightClient client,
    }  
    /**
        this.connectFuture = new CompletableFuture<>();
                straggling,
    @Override  
        ThreadPool threadPool,
    /**
        return false;
        DiscoveryNode node,  
     * <p>Streams whose consumer callback is running on this very thread are excluded from the wait:
    @Override
    private final Object activeStreamsMonitor = new Object();
            listener.onFailure(new StreamException(StreamErrorCode.INTERNAL, "Failed to send message", e));  
            logger.trace("{}: {}", message, ExceptionsHelper.stackTrace(cause));
                activeStreams.remove(streamResponse);
            future.handle((result, ex) -> {
        this.closeListeners = new CopyOnWriteArrayList<>();
            logFailure("Handler failed to process exception", handlerEx);  
        } finally {  
        return !isClosed;  
    private volatile boolean isClosed;
    private void cleanupStreamResponse(StreamTransportResponse<?> streamResponse) {
     * virtual thread started by {@link FlightTransportResponse#openAndPrefetchAsync}, and letting log4j  
import org.apache.logging.log4j.Logger;
    }
                    Thread.currentThread().interrupt();  
        String executor = handler.executor();
            return;  
    }
    private void handleStreamException(FlightTransportResponse<?> streamResponse, Exception exception) {  
        }
            streamResponse.cancel("Client-side exception: " + cause.getMessage(), cause);
                threadPool.executor(executor).execute(task);
    }
                // While the consumer callback runs, this thread owns the stream: it is the only one
        // notified here, one added before it is notified by close(), and remove() decides which of the two does it  
                synchronized (activeStreamsMonitor) {  
        }
                        handler.handleStreamResponse(streamResponse);  
        // Upper bits: timestamp, lower 20 bits: channel ID
    private final BoundTransportAddress boundAddress;
                    activeStreamsMonitor.notifyAll();
/*  
     * @param messageListener        the transport message listener
    public void addCloseListener(BiConsumer<Void, ? super Exception> listener) {
        Thread current = Thread.currentThread();
     *
     * @param config                 the shared transport configuration
import org.opensearch.transport.stream.StreamErrorCode;  
     * @param node                   the discovery node for this channel
    private void cancelStream(FlightTransportResponse<?> streamResponse, Exception cause) {
        if (ThreadPool.Names.SAME.equals(executor)) {  
            callTracker.recordRequestBytes(reference.length());  
    @SuppressWarnings({ "unchecked", "rawtypes" })  
            });
                            handleStreamException(streamResponse, new StreamException(StreamErrorCode.INTERNAL, "Header is null"));
        if (statsCollector != null) {
     *       blocking unmount.</li>
                }
     * render a stack trace there can wedge the whole node:
            notifyListener(listener, closeFuture);
        }
        }  
            connectFuture.completeExceptionally(e);
        } else {
        }
        // Initialize with timestamp + global counter to ensure uniqueness with multiple channels  
            }  
        } catch (Exception handlerEx) {
            );  
    public void sendMessage(BytesReference reference, ActionListener<Void> listener) {
 */  
        isClosed = true;
                node.getId()  
import org.apache.arrow.flight.FlightClient;
                        if (header == null) {  
                        }
        FlightStatsCollector statsCollector,
        return stats;
        var threadContext = threadPool.getThreadContext();  
    public InetSocketAddress getRemoteAddress() {  
        long straggling = remaining.size() - selfOwned;
                // handler was already removed from responseHandlers above, so notify it directly
                headerContext,
        } else {
            streamResponse.close();  
        closeFuture.complete(null);
        try {
    public void addCloseListener(ActionListener<Void> listener) {
        return profile;
            if (callTracker != null) {  
        try {  
 * compatible open source license.
     * @param responseHandlers       the transport response handlers
     */
            TransportResponseHandler<?> handler = streamResponse.getHandler();
        if (selfOwned > 0) {  
                config
        }
                }
    }
     * allocator. Entries remove themselves via {@link FlightTransportResponse#setOnClosed} once  
        notifyListeners(closeListeners, closeFuture);
            logger.warn(
        }  
    public void sendMessage(long requestId, BytesReference reference, ActionListener<Void> listener) {  
    }
            // Runs on the prefetch virtual thread when the handler declares the SAME executor.
    public boolean isOpen() {
            notifyRemovableListener(listener);
            // ticket will contain the serialized headers
import org.apache.arrow.flight.Location;
                StreamException exception = new StreamException(StreamErrorCode.UNAVAILABLE, "FlightClientChannel is closed");
        initializeConnection();
                handler,
            logFailure("Failed to close stream response", e);
        }
import org.opensearch.transport.TransportResponseHandler;
        if (closeFuture.isCompletedExceptionally()) {
            if (error != null) {
                    } catch (Exception e) {
    }  
    private final Set<FlightTransportResponse<?>> activeStreams = ConcurrentHashMap.newKeySet();
        }
    }
import org.opensearch.transport.stream.StreamException;
        }
        }
import java.util.concurrent.atomic.AtomicLong;  
            }  
            // Open stream and prefetch first batch, invoke handler when ready
        if (straggling > 0) {  
     * Constructs a new FlightClientChannel for handling Arrow Flight streams.
    }  
     * Waits up to {@link FlightTransportConfig#getStreamCloseTimeout()} for active streams to be
import java.io.IOException;
        return boundAddress.publishAddress().address();
    @Override  
            final Throwable ex = closeFuture.exceptionNow();
        if (logger.isTraceEnabled()) {  
        for (BiConsumer<Void, ? super Exception> listener : removableCloseListeners) {  
        } catch (Exception e) {
        return new Ticket(BytesReference.toBytes(reference));  
import org.opensearch.transport.Header;
import org.apache.logging.log4j.LogManager;
                        throw e;  
    /** Signalled whenever a stream leaves {@link #activeStreams}, to wake {@link #close()}. */  
     *   <li>OpenSearch's JSON layout always appends {@code %exceptionAsJson}, so a logged throwable reaches
        }
        this.closeFuture = new CompletableFuture<>();  
        this.correlationIdGenerator.set(initialValue);
import org.opensearch.transport.Transport;  
        this.location = location;
    private final DiscoveryNode node;  
            openStreamAndInvokeHandler(streamResponse);  
        this.headerContext = headerContext;  
     * @param profile                the channel profile
    private Ticket serializeToTicket(BytesReference reference) {
    public boolean isServerChannel() {
        FlightTransportConfig config  
            }  
        // taking the listener out of the list claims it, so a listener that is removed while the channel is
    public void addConnectListener(ActionListener<Void> listener) {
        removableCloseListeners.add(listener);
        this.stats = new ChannelStats();
        }
import java.net.InetAddress;
            // closing the FlightClient. Set the callback before any consumer can close the stream.  
import java.util.concurrent.ConcurrentHashMap;
    private void notifyHandlerOfException(TransportResponseHandler<?> handler, Exception exception) {
        String profile,  
                        threadContext.setHeaders(header.getHeaders());
                    break;
    }
        connectListeners.add(listener);
        // The FlightClient's allocator close treats any outstanding buffer as a leak, and live  
                node.getId(),
}
        return "FlightClientChannel{node=" + node.getId() + ", remoteAddress=" + getRemoteAddress() + ", profile=" + profile + '}';
import org.opensearch.core.common.transport.BoundTransportAddress;
    }  
        }
            activeStreams.add(streamResponse);
package org.opensearch.arrow.flight.transport;
     * @param namedWriteableRegistry the registry for deserialization
    private void initializeConnection() {
        HeaderContext headerContext,
                    }
                "Channel to node [{}] is being closed from a stream consumer callback; [{}] stream(s) owned by this thread "
        if (future.isCompletedExceptionally()) {
        }
        } catch (Exception e) {  
                selfOwned
import org.opensearch.arrow.flight.stats.FlightStatsCollector;  
    }
            long correlationId = correlationIdGenerator.incrementAndGet();
    @Override
            streamResponse.setOnClosed(() -> {
        }
     * only at TRACE.  
 * TcpChannel implementation for Flight client with async response handling.
            };  
     * their release cannot happen until the callback returns, which cannot happen until this close
        StreamException streamException;  
        this.responseHandlers = responseHandlers;
    /**
                try {
        awaitActiveStreamsClosed();
    /**
        TransportMessageListener messageListener,  
    private final ChannelStats stats;  
        }
    @Override  
                "Gave up after [{}ms] waiting for [{}] active stream(s) to be released while closing channel to node [{}]; "
        this.namedWriteableRegistry = namedWriteableRegistry;
            cleanupStreamResponse(streamResponse);
            if (streamResponse.getDispatchThread() != current) {
            TransportResponseHandler<?> handler = responseHandlers.onResponseReceived(requestId, messageListener);  
                listener.onFailure(ex instanceof Exception exception ? exception : new Exception(ex));  
    public ChannelStats getChannelStats() {  
        removableCloseListeners.remove(listener);  
        final long timeoutMillis = config.getStreamCloseTimeout().millis();  
        streamResponse.openAndPrefetchAsync(future);
        }
            connectFuture.complete(null);
                    try (var ignored = threadContext.stashContext()) {
            notifyListener(listener, connectFuture);
     *  
    private void safeHandleException(TransportResponseHandler<?> handler, StreamException exception) {
     * stream not owned by the calling thread. See {@link #awaitActiveStreamsClosed()}.  
            streamException = se;
    private final CompletableFuture<Void> connectFuture;
    private final String profile;  
 * The OpenSearch Contributors require contributions made to  
            listener.onResponse(null);
import java.util.ArrayList;
     *   <li>The scheduler's carrier count defaults to {@code availableProcessors}. A mass stream failure
    public InetSocketAddress getLocalAddress() {
                }
import java.util.concurrent.atomic.AtomicBoolean;
        // added before the check on purpose: close() walks the list once, so a listener added after that walk is
        }
        }
     * that were captured when the throwable was constructed, resolving no classes and taking no lock.
            notifyListeners(connectListeners, connectFuture);
        }  
     * are released). On timeout, proceeds anyway — the subsequent {@link FlightClient#close()} may
        logFailure("Exception while handling stream response for correlationId [" + streamResponse.getCorrelationId() + "]", exception);
            }
    }
        }
    private void notifyListener(ActionListener<Void> listener, CompletableFuture<Void> future) {  
     */
 */  
import java.util.concurrent.CompletableFuture;
        } else {  
    }
        long channelId = GLOBAL_CHANNEL_COUNTER.incrementAndGet() & 0xFFFFF; // 20 bits for channel ID
     *       (for example every stream reconnecting at once after a network partition heals) can therefore pin  
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.ExceptionsHelper;
     * returns, so waiting for them would burn the whole timeout to no effect.  
                // is cancelled rather than left running against a closing client. The response
    private final AtomicLong correlationIdGenerator = new AtomicLong();
     * then report the stragglers' buffers as leaked, which is logged, not thrown.
                try (var dispatchMark = streamResponse.markDispatchThread()) {
                return true;  
        }
            // Track the stream until its buffers are released, so close() can wait for it before
            if (ThreadPool.Names.SAME.equals(executor)) {
        throw new IllegalStateException("sendMessage must be accompanied with requestId for FlightClientChannel, use the right variant.");  
import org.opensearch.threadpool.ThreadPool;  
     *       rescheduled to release it. That circular wait does not resolve: the node keeps reporting healthy
                streamResponse.cancelStreamOnly("channel to node [" + node.getId() + "] closed");
        return false;  
    @Override  
            }
            if (callTracker != null) {  
     * </ol>
        }
                    // Wake on the next release, or at the deadline; never wait(0), which waits forever.  
                logger.warn(
                // close() may have iterated activeStreams before this add; make sure this stream  
                            // Must return: handleStreamException does not throw, so falling through here
    private final CompletableFuture<Void> closeFuture;
 * SPDX-License-Identifier: Apache-2.0
     * <ol>  
import org.opensearch.transport.TcpChannel;
 *
                );
     * <p>The TRACE line is safe for the same reason: it passes a pre-rendered string, so log4j never sees a  
        FlightCallTracker callTracker = null;  
            notifyHandlerOfException(handler, exception);
        if (exception instanceof StreamException se) {
        });
    }
            return;
     * @param location               the flight server location
                task.run();  
     *       every carrier, while the thread holding the classloader lock is itself unmounted and can never be
        final long deadlineNanos = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(timeoutMillis);
     * throwable and the extended renderer never runs. {@link ExceptionsHelper#stackTrace} only formats frames
                return;
            Ticket ticket = serializeToTicket(reference);
     * released by their consumers (each removes itself from {@link #activeStreams} once its buffers  
            logFailure("Failed to cancel stream after exception", cancelEx);  
    }
        TransportResponseHandler handler = streamResponse.getHandler();
                } catch (InterruptedException e) {
            threadPool.executor(executor).execute(() -> safeHandleException(handler, streamException));  
 * this file be licensed under the Apache-2.0 license or a
    private final FlightStatsCollector statsCollector;
     * and waits for the set to drain before closing the {@link FlightClient}, whose allocator
    private final Location location;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            listener.onResponse(null);
import java.util.concurrent.TimeUnit;
     * @param statsCollector         the collector for flight statistics  
    private void logFailure(String message, Throwable cause) {
     * <p><b>Never hand a throwable to log4j from these paths.</b> They run on the per-stream prefetch
                notifyHandlerOfException(handler, exception);  
                streamResponse.cancelStreamOnly("channel to node [" + node.getId() + "] closed");  
                    e
                            // reachable whenever the middleware never stored one (HeaderContext.getHeader  
    /**  
    }  
        // closing is notified exactly once, or not at all once removeCloseListener has taken it  
     * Initializes the connection and notifies listeners of the result.  
     *       log4j's <em>extended</em> stack-trace renderer, which annotates every frame with its source JAR.</li>
        this.node = node;
            streamException = new StreamException(StreamErrorCode.INTERNAL, "Stream processing failed", exception);
            return;  
        try {  
     * Streams created by this channel whose buffers may still be accounted against the client's
            callTracker = statsCollector.createClientCallTracker();
            }
    private void notifyRemovableListener(BiConsumer<Void, ? super Exception> listener) {
                namedWriteableRegistry,
    ) {
        this.isClosed = false;
        // is safe from this thread and unblocks consumers parked in nextResponse()  
    @Override
        this.statsCollector = statsCollector;  
    private final List<ActionListener<Void>> closeListeners;
        }
    public String toString() {
        Thread current = Thread.currentThread();  
        synchronized (activeStreamsMonitor) {
    public FlightClientChannel(  
            listener.accept(closeFuture.resultNow(), null);
     *       while making no progress.</li>  
            handler.handleException(exception);  
     *       {@code forName0} <em>native</em> frame sits on the stack while the classloader monitor is
    private final AtomicBoolean closeStarted = new AtomicBoolean();  
            safeHandleException(handler, streamException);
        if (connectFuture.isDone()) {  
     * close treats any outstanding buffer as a leak.  
    @Override  
            logger.warn(
            client.close();
        this.threadPool = threadPool;  
    private final NamedWriteableRegistry namedWriteableRegistry;
        long selfOwned = remaining.stream().filter(s -> s.getDispatchThread() == current).count();
    private final TransportMessageListener messageListener;  
        this.removableCloseListeners = new CopyOnWriteArrayList<>();  
    public String getProfile() {  
            long remainingNanos;  
     * their underlying flight stream is closed. {@link #close()} cancels every remaining stream
            notifyRemovableListener(listener);  
import java.util.function.BiConsumer;
        this.boundAddress = boundTransportAddress;
    }  
        for (FlightTransportResponse<?> streamResponse : activeStreams) {
                listener.onFailure(exception);
        List<FlightTransportResponse<?>> remaining = new ArrayList<>(activeStreams);  
        }
    private static final AtomicLong GLOBAL_CHANNEL_COUNTER = new AtomicLong();  
import java.util.List;
        Transport.ResponseHandlers responseHandlers,
    private final Transport.ResponseHandlers responseHandlers;
     *
        }  
            throw new StreamException(StreamErrorCode.INTERNAL, "Failed to resolve remote address", e);
                return;
            cancelStream(streamResponse, exception);  
                // that can release it, so a close() reaching this thread must not wait for it.  
        closeListeners.add(listener);  
            listener.onFailure(new StreamException(StreamErrorCode.UNAVAILABLE, "FlightClientChannel is closed"));
        if (!isOpen()) {
        // streams legitimately hold buffers (current batch root, retained heartbeat metadata)
        this.messageListener = messageListener;
    private final HeaderContext headerContext;
        for (ActionListener<Void> listener : listeners) {
                    + "their buffers may be reported as leaked",  
        if (ThreadPool.Names.SAME.equals(executor)) {
                    () -> new ParameterizedMessage("Error cancelling active stream while closing channel to node [{}]", node.getId()),  
     *
    @Override
        logger.error("{}: {}", message, FlightUtils.causeSummary(cause));
/**  
        this.client = client;  
        this.connectListeners = new CopyOnWriteArrayList<>();
