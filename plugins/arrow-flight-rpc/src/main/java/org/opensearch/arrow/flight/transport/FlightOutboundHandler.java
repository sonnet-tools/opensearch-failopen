    private void processErrorTask(BatchTask task) {
        String action,
        // either sendBatch runs on the executor (its finally frees the source), or it never does
 * <p>Its one buffer responsibility is the <em>source-root hand-off</em>: ownership of a native
            flightServerChannel.sendError(getHeaderBuffer(task.requestId(), task.nodeVersion(), task.features()), flightError);
import org.opensearch.transport.ProtocolOutboundHandler;
            }
    private void processCompleteTask(BatchTask task) {
     * thread itself (blocking on the result from that thread would deadlock the single-threaded executor).
            return;
            transportChannel,
        final boolean compress,
 * response's root transfers to the channel when {@link #sendResponseBatch} is called, and the handler
            // Defensive: this transport always uses FlightServerChannel. There is no channel to take
        DiscoveryNode node,
            failStream(flightChannel, task, e);
        } catch (FlightRuntimeException e) {
            messageListener.onResponseSent(task.requestId(), task.action(), error);
        @Override
import org.opensearch.transport.nativeprotocol.NativeOutboundMessage;
        if (!(channel instanceof FlightServerChannel flightChannel)) {
    /**
        }
        final long requestId,
            // channel (also untracks the framework task); fall back to closing the channel directly when
            flightChannel.awaitReadyOrThrow();
            if ((isComplete || isError) && transportChannel != null) {
     */
import java.util.concurrent.ExecutionException;
        TransportRequest request,
                try (BatchTask ignored = task) {
            // root) and report it to the listener rather than letting it kill the executor worker and
                processCompleteTask(completeTask);
        );
import org.opensearch.threadpool.ThreadPool;
        if (messageListener == TransportMessageListener.NOOP_LISTENER) {
 *
        try {
            throw new StreamException(StreamErrorCode.INTERNAL, "Interrupted while sending batch synchronously", e);
/**
            response,
 * Outbound handler for Arrow Flight streaming responses.
            action,
        }
            messageListener = listener;
            // allocation rather than letting the eventloop's queue grow. Note: isReady()
            // reflects only gRPC's outbound buffer, not our own queue depth — see
import org.opensearch.core.transport.TransportResponse;
    }
            Exception flightError = cause instanceof StreamException se ? FlightErrorMapper.toFlightException(se) : cause;
                flightError = FlightErrorMapper.toFlightException(se);
        final Set<String> features,
            // here means it genuinely failed (e.g. header serialization). Attach to the original cause
            return ByteBuffer.wrap(headerBytes.toBytesRef().bytes);
            }
import org.opensearch.transport.TransportRequestOptions;
        this.nodeName = nodeName;
    @Override
                handedOff = true;
        }
            channel,
            requestId,
        final Set<String> features,
            true,
            messageListener.onResponseSent(requestId, action, new IllegalStateException("Expected FlightServerChannel"));
     * here. {@code sendError} and {@code releaseChannel} are both idempotent / best-effort.
    private void processBatchTask(BatchTask task) {
import org.opensearch.transport.stream.StreamException;
            try (BatchTask ignored = errorTask) {
     */
        final boolean compress,
        }
            return;
            transportChannel,
            // sendError is a no-op when the channel is already closed/cancelled/terminal, so reaching
 * (the back-pressure gate threw or the executor rejected the task).
 * SPDX-License-Identifier: Apache-2.0
            // A non-Exception Throwable (e.g. OutOfMemoryError, or an AssertionError from Arrow/gRPC
    }
        final long requestId,
        BatchTask completeTask = new BatchTask(
            Exception wrapped = new RuntimeException("Fatal error sending Arrow batch", t);
            false,
            false,
        String action, TransportResponse response, boolean compress, boolean isHandshake, boolean isComplete, boolean isError,
        final long requestId,
            failStream(flightChannel, task, wrapped);
import org.opensearch.cluster.node.DiscoveryNode;
        }
        }
 * <p>It must invoke the messageListener and relay any exception back to the caller and not suppress them.
        } catch (InterruptedException e) {
                awaitSend(future);
     * frame, then releases the channel so a later {@code completeStream} no-ops on its open guard. The
        final String action,
    record BatchTask(Version nodeVersion, Set<String> features, TcpChannel channel, FlightTransportChannel transportChannel, long requestId,
        final Version nodeVersion,
 * The OpenSearch Contributors require contributions made to
        long requestId,
            return;
class FlightOutboundHandler extends ProtocolOutboundHandler {
        // these two paths mutually exclusive.
        } else {
            messageListener.onResponseSent(task.requestId(), task.action(), e);
        final TcpChannel channel,
        boolean isHandshake
        Set<String> features,
        final TcpChannel channel,
            // strand the caller. Wrapped so the listener's Exception contract is honoured.
    public void sendErrorResponse(
            nodeVersion,
import org.apache.logging.log4j.message.ParameterizedMessage;
            // ownership, so free the source here so it cannot leak.
        }
        public void close() {
            // expected; surface it rather than swallow if it ever happens.
        final boolean isHandshake
            // docs/backpressure.md "Known limitation: unbounded eventloop queue".
            error
        final Version nodeVersion,
    @Override
    private final ThreadPool threadPool;
            }
            Version.min(version, nodeVersion),
    }
 * <p>This handler is a stateless translator: it switches onto the channel's flight executor, gates
            messageListener.onResponseSent(task.requestId(), task.action(), error);
            isHandshake,
            if (task.error() instanceof StreamException se) {
    public void setMessageListener(TransportMessageListener listener) {
 * handed off, or by {@link FlightServerChannel#releaseUnsent} if the batch never reaches the channel
     * parks the caller for the result. The caller must be a producer thread, not the flight executor
 * compatible open source license.
            // Fail the stream before notifying the listener so the consumer surfaces an error instead
            cause.addSuppressed(suppressed);
            flightChannel.sendBatch(task.response(), () -> getHeaderBuffer(task.requestId(), task.nodeVersion(), task.features()));
    }
    }
            return;
            }
        );
        }
            nodeVersion,
    @Override
        TcpChannel channel,
            messageListener.onResponseSent(requestId, action, new IllegalStateException("Expected FlightServerChannel"));
import org.opensearch.Version;
 *
        final TransportResponse response,
                transportChannel.releaseChannel(isError);
import org.opensearch.core.common.bytes.BytesReference;
                messageListener.onResponseSent(requestId, action, e);
    }
                    messageListener.onResponseSent(requestId, action, e);
        final TransportResponse response,
            }
 * not own or free the stream root and never closes the channel directly — the channel is the sole
import java.nio.ByteBuffer;
        final long requestId,
            channel,
    private static final Logger logger = LogManager.getLogger(FlightOutboundHandler.class);
        this.version = version;
        if (!(channel instanceof FlightServerChannel flightChannel)) {
        }
        final TcpChannel channel,
                handedOff = true; // task accepted; it now owns (and will free) the source
        );
                flightChannel.getExecutor().execute(sendBatch);
import org.apache.logging.log4j.Logger;
            false,
    @Override
            transportChannel,
            // channel; without failing the stream here, the adopted stream root would never be freed.
    }
     * Blocks the caller until the executor has run the submitted send, so the caller cannot submit the
                }
        // Just a way( probably inefficient) to serialize header to reuse existing logic present in
    ) throws IOException {
 *
        }
            // Block the producer thread before queuing the batch so a slow consumer throttles
    }
        }));
        if (!(task.channel() instanceof FlightServerChannel flightChannel)) {
        final boolean sync
            action,
 * @opensearch.internal
            TransportResponse.Empty.INSTANCE,
        flightChannel.getExecutor().execute(threadPool.getThreadContext().preserveContext(() -> {
        final FlightTransportChannel transportChannel,
            messageListener.onResponseSent(task.requestId(), task.action(), FlightErrorMapper.fromFlightException(e));
 * on back-pressure, and hands each {@link TransportResponse} to {@link FlightServerChannel}. It does
            }
            Exception flightError = task.error();
        try {
            flightChannel.sendError(getHeaderBuffer(task.requestId(), task.nodeVersion(), task.features()), flightError);
            Throwable cause = e.getCause() != null ? e.getCause() : e;
        final Set<String> features,
import java.io.IOException;
import java.util.Set;
import org.opensearch.transport.StatsTracker;
import org.opensearch.transport.TcpChannel;
            "sendResponse() is not supported for streaming requests in FlightOutboundHandler; use sendResponseBatch()"
        Version nodeVersion,
 * owner of all Arrow buffers (see {@code docs/channel-lifecycle-ownership.md}).
        BatchTask errorTask = new BatchTask(
        }
            logger.warn(new ParameterizedMessage("failStream: could not send error for requestId [{}]", task.requestId()), suppressed);
            messageListener.onResponseSent(task.requestId(), task.action(), e);
        final Exception error
            try (BatchTask ignored = completeTask) {
     * the readiness back-pressure gate). The send itself runs on the channel's flight executor (so it is
                } catch (Exception e) {
import org.opensearch.transport.TransportException;
            return;
        throw new UnsupportedOperationException(
            BytesReference headerBytes = headerMessage.serialize(bytesStream);
            if (task.transportChannel() != null) {
            features,
        boolean handedOff = false;
        final Version nodeVersion,
        final String action
            null
    private final String[] features;
 * this file be licensed under the Apache-2.0 license or a
            FlightServerChannel.releaseUnsentSource(response);
 */
    public FlightOutboundHandler(String nodeName, Version version, String[] features, StatsTracker statsTracker, ThreadPool threadPool) {
        if (!(task.channel() instanceof FlightServerChannel flightServerChannel)) {
        TcpChannel channel,
    public void sendResponse(
        final String action,
        );
        if (!(channel instanceof FlightServerChannel flightChannel)) {
        try (BytesStreamOutput bytesStream = new BytesStreamOutput()) {
        flightChannel.getExecutor().execute(threadPool.getThreadContext().preserveContext(() -> {
import org.opensearch.transport.TransportMessageListener;
            action,
        if (!(task.channel() instanceof FlightServerChannel flightChannel)) {
    }
        );
import java.util.concurrent.Future;
            return;
            requestId,
        } finally {
            false,
                Future<?> future = flightChannel.getExecutor().submit(sendBatch);
        Version channelVersion,
                flightChannel.releaseUnsent(response);
            // Route it through the same fail path (which releases the channel -> close() frees the
            Exception error = new IllegalStateException("Expected FlightServerChannel, got " + task.channel().getClass().getName());
            false
            messageListener.onResponseSent(task.requestId(), task.action(), TransportResponse.Empty.INSTANCE);
        final Version nodeVersion,
        final String action,
            "sendResponse() is not supported for streaming requests in FlightOutboundHandler; use sendResponseBatch()"
            messageListener.onResponseSent(task.requestId(), task.action(), task.error());
    private volatile TransportMessageListener messageListener = TransportMessageListener.NOOP_LISTENER;
        NativeOutboundMessage.Response headerMessage = new NativeOutboundMessage.Response(
            } catch (Exception e) {
        }));
                throw se;
        BatchTask task = new BatchTask(
    }
            null
            // and so close() runs to free the adopted stream root. Prefer releasing via the transport
    public void completeStream(
            requestId,
        }
            compress,
            channel,
    ) throws IOException {
     * Fails the stream after a batch send error: sends the error so the consumer's
            // wait, ensuring the finally's releaseUnsent never double-frees a source the task already owns.
            features,
            // header itself before mutating any root, so a header-serialization failure cannot orphan the source.
            // Make the channel terminal so a later completeStream can't double-terminate the listener,
            } catch (Exception e) {
        );
            failStream(flightChannel, task, e);
        }
        String action,
            throw new IllegalStateException("Cannot set message listener twice");
            // stream root. The batch task is non-terminal, so BatchTask.close() does not release the
            final Runnable sendBatch = threadPool.getThreadContext().preserveContext(() -> {
import org.apache.logging.log4j.LogManager;
        } finally {
 */
            threadPool.getThreadContext(),
            features,
     * {@code FlightStream.getRoot()} surfaces an exception instead of hanging on a never-arriving first
    private void awaitSend(Future<?> future) {
            // outstanding batches to one; a full buffer is throttled by the readiness gate above); async
import org.apache.arrow.flight.FlightRuntimeException;
    private void failStream(FlightServerChannel flightChannel, BatchTask task, Exception cause) {
        final FlightTransportChannel transportChannel,
        }
    ) throws IOException {
            out -> {},
import org.opensearch.transport.stream.StreamErrorCode;
            true,
            future.get();
            // of blocking forever on a never-arriving first frame.
        this.statsTracker = statsTracker;
            nodeVersion,
    private final String nodeName;
            messageListener.onResponseSent(requestId, action, new IllegalStateException("Expected FlightServerChannel"));
    /**
            requestId,
        this.features = features;
        final TcpChannel channel,
/*
        TransportRequestOptions options,
            messageListener.onResponseSent(task.requestId(), task.action(), e);
            // at WARN — this is a cascading failure, not routine.
            // so the second failure's context travels with the exception the listener receives, and log
            messageListener.onResponseSent(task.requestId(), task.action(), task.response());
 * guarantees it is freed exactly once — by {@link FlightServerChannel#sendBatch} once the batch is
            throw new StreamException(StreamErrorCode.INTERNAL, "Error sending batch synchronously", cause);
                task.transportChannel().releaseChannel(true);
    }
            // The work body catches its own exceptions and routes them to the listener, so this is not
        final FlightTransportChannel transportChannel,
        // (gate throws / executor rejects) and releaseUnsent frees it here. The handedOff flag keeps
        try {
     * next batch until this one has been pushed to gRPC's outbound buffer (a full buffer is throttled by
    ) throws IOException, TransportException {
        final Set<String> features,
        try {
            } else {
            false,
        } catch (Exception e) {
            }
package org.opensearch.arrow.flight.transport;
        } catch (Throwable t) {
    private final StatsTracker statsTracker;
        // The channel owns the response's buffers from this point. The batch is freed exactly once:
            if (handedOff == false) {
    ) {
        try {
            null,
            // under -ea) can be thrown by start()/putNext()/transfer AFTER the channel adopted the
            // sync blocks the caller until the batch has been pushed to gRPC's outbound buffer (bounding
    private final Version version;
     * stream root and the source root are owned and freed by the channel, so there is nothing to free
        throw new UnsupportedOperationException("sendRequest not implemented for FlightOutboundHandler");
        final boolean isHandshake,
    private ByteBuffer getHeaderBuffer(long requestId, Version nodeVersion, Set<String> features) throws IOException {
    }
                messageListener.onResponseSent(requestId, action, e);
            // The channel owns the stream root end to end (create/transfer/adopt/free) and builds the
            false,
            false,
 *
        } catch (Exception e) {
        try {
        Exception error
            // there is no transport channel. Both are idempotent (close() is fire-once).
        Exception error) implements AutoCloseable {
            // ownership to that task the moment it is accepted — so handedOff is set before any blocking
    }
        // NativeOutboundMessage.Response#writeVariableHeader()
            messageListener.onResponseSent(task.requestId(), task.action(), error);
}
            if (cause instanceof StreamException se) {
    public void sendRequest(
            false,
        } catch (ExecutionException e) {
    public void sendResponseBatch(
            messageListener.onResponseSent(task.requestId(), task.action(), wrapped);
import org.opensearch.transport.TransportRequest;
        throw new UnsupportedOperationException(
     * serialized with the stream-root free that {@code close()} posts to the same executor); this only
            Exception error = new IllegalStateException("Expected FlightServerChannel, got " + task.channel().getClass().getName());
        long requestId,
    ) {
            Exception error = new IllegalStateException("Expected FlightServerChannel, got " + task.channel().getClass().getName());
            // returns once it is queued. Both run on the channel executor, and both transfer source
            } else {
        } catch (Exception e) {
            features,
import org.opensearch.common.io.stream.BytesStreamOutput;
                flightChannel.close();
        boolean compressRequest,
    }
            }
            false,
                processErrorTask(errorTask);
    }
            flightChannel.completeStream(getHeaderBuffer(task.requestId(), task.nodeVersion(), task.features()));
            });
        } catch (Exception suppressed) {
                    processBatchTask(task);
            if (sync) {
    public void sendErrorResponse(
        }
            Thread.currentThread().interrupt();
        this.threadPool = threadPool;
